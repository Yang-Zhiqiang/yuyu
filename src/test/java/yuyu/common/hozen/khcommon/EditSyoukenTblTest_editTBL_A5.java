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
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HnskariyuuKbn;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoukenUktKbn;
import yuyu.def.classification.C_SyoukenUktMidasiKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TokusyuSyoriNaiyouKbn;
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
public class EditSyoukenTblTest_editTBL_A5 {

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
        HanteiHokenKikanMock.caller = EditSyoukenTblTest_editTBL_A5.class;
        KeisanKijyungkMock.caller = EditSyoukenTblTest_editTBL_A5.class;
        BzGetAgInfoMock.caller = EditSyoukenTblTest_editTBL_A5.class;
        SetOutoubiMock.caller = EditSyoukenTblTest_editTBL_A5.class;
        GetKawaseRateMock.caller = EditSyoukenTblTest_editTBL_A5.class;
        CalcHkShrKngkMock.caller = EditSyoukenTblTest_editTBL_A5.class;
        KeisanGaikakanzanMock.caller = EditSyoukenTblTest_editTBL_A5.class;
        CalcJdkghkKngkMock.caller = EditSyoukenTblTest_editTBL_A5.class;
        EditSuiihyouTblMock.caller = EditSyoukenTblTest_editTBL_A5.class;
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
            testDataAndTblMap = testDataMaker.getInData(EditSyoukenTblTest_editTBL_A5.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ005", testDataAndTblMap);
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
    public void testEditTBL_F1() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;

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

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

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

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo1, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.JPY, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "円", "その他内容欄入金通貨");
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

        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 0, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(0), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(0), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(100000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(10000), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn1(), C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI, "特殊処理内容区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn2(), C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI, "特殊処理内容区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn3(), C_TokusyuSyoriNaiyouKbn.KANJIADRNASI, "特殊処理内容区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn4(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_DNGNMEMOARI, "特殊処理内容区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn5(), C_TokusyuSyoriNaiyouKbn.STKNSETARI, "特殊処理内容区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn6(), C_TokusyuSyoriNaiyouKbn.KARIUKEKEIJOARI, "特殊処理内容区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn7(), C_TokusyuSyoriNaiyouKbn.DOUJITUSYOUKENFUKUSUUARI, "特殊処理内容区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn8(), C_TokusyuSyoriNaiyouKbn.DAIRITENMEIMOJISUUTYOUKA, "特殊処理内容区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn9(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn10(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn11(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn12(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn13(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn14(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn15(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn16(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn17(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１７");

        exClassificationEquals(editSyoukenTbl.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_F2() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
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

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

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
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.JPY, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "円", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(30), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(11000), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(50), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "円", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.JPY, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(11000), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(1), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.1), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "13060", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 65, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 70, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 75, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 80, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 85, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 90, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 95, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 100, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 105, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14040", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14060", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(100000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn1(), C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI, "特殊処理内容区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn2(), C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI, "特殊処理内容区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn3(), C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI, "特殊処理内容区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn4(), C_TokusyuSyoriNaiyouKbn.KANJIADRNASI, "特殊処理内容区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn5(), C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU, "特殊処理内容区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn6(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_DNGNMEMOARI, "特殊処理内容区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn7(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRKAKUNINUKE, "特殊処理内容区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn8(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRHUMEI, "特殊処理内容区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn9(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn10(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn11(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn12(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn13(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn14(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn15(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn16(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn17(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１７");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_F3() {

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
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.1), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 65, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 70, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 75, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 80, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 85, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 90, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 95, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 100, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 105, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14040", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14070", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(100000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn1(), C_TokusyuSyoriNaiyouKbn.HHKNKANJIMEINASI, "特殊処理内容区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn2(), C_TokusyuSyoriNaiyouKbn.KYKKANJIMEINASI, "特殊処理内容区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn3(), C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU, "特殊処理内容区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn4(), C_TokusyuSyoriNaiyouKbn.STDRNINKANJIMEINASI, "特殊処理内容区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn5(), C_TokusyuSyoriNaiyouKbn.SBUKFUKUSUU, "特殊処理内容区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn6(), C_TokusyuSyoriNaiyouKbn.SBUKBNWARINASI, "特殊処理内容区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn7(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRKAKUNINUKE, "特殊処理内容区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn8(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRHUMEI, "特殊処理内容区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn9(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn10(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn11(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn12(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn13(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn14(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn15(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn16(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn17(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１７");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_F4() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
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

        IT_KykUkt siteiDairi = null;

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
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(0), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
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

        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 70, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 75, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 80, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 85, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 90, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 95, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 100, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 105, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14040", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(100000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn1(), C_TokusyuSyoriNaiyouKbn.SBUKKANJIMEINASI_FUKUSUU, "特殊処理内容区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn2(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRKAKUNINUKE, "特殊処理内容区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn3(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRHUMEI, "特殊処理内容区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn4(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn5(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn6(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn7(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn8(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn9(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn10(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn11(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn12(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn13(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn14(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn15(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn16(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn17(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１７");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_F5() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);
        editHokenSyoukenParam.setHnskariyuu1(C_HnskariyuuKbn.YENDTHNKHR_ARI);
        editHokenSyoukenParam.setHnskariyuu2(C_HnskariyuuKbn.JIMU_ARI);

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
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.JPY, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "円", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(30), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.JPY, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(110), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyourangaimsgcd(), "09200", "その他内容欄外メッセージコード");

        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "13032", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "13060", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 105, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 0, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "14012", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14050", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn1(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRKAKUNINUKE, "特殊処理内容区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn2(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRHUMEI, "特殊処理内容区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn3(), C_TokusyuSyoriNaiyouKbn.YENDTHNKHRARI, "特殊処理内容区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn4(), C_TokusyuSyoriNaiyouKbn.BETUTTDKUKTKARI, "特殊処理内容区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn5(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn6(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn7(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn8(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn9(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn10(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn11(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn12(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn13(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn14(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn15(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn16(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn17(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１７");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_F6() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);
        editHokenSyoukenParam.setHnskariyuu1(C_HnskariyuuKbn.JIMU_ARI);
        editHokenSyoukenParam.setHnskariyuu2(C_HnskariyuuKbn.YENDTHNKHR_ARI);

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
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "ユーロ", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.JPY, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "円", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(30), "その他内容欄指定外通貨払込特約レート");
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

        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "13032", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "ユーロ", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.EUR, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 105, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 0, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "14012", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14034", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14050", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "14060", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.EUR, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(10000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn1(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRKAKUNINUKE, "特殊処理内容区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn2(), C_TokusyuSyoriNaiyouKbn.TTDKTYUUI_ADRHUMEI, "特殊処理内容区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn3(), C_TokusyuSyoriNaiyouKbn.YENDTHNKHRARI, "特殊処理内容区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn4(), C_TokusyuSyoriNaiyouKbn.BETUTTDKUKTKARI, "特殊処理内容区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn5(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn6(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn7(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn8(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn9(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn10(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn11(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn12(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn13(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn14(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn15(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn16(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn17(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１７");
    }
    @Test
    @TestOrder(70)
    public void testEditTBL_F7() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);
        editHokenSyoukenParam.setHnskariyuu1(C_HnskariyuuKbn.BLNK);
        editHokenSyoukenParam.setHnskariyuu2(C_HnskariyuuKbn.BLNK);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo7, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.JPY, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(10000), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "円", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(30), "その他内容欄円貨払込特約レート");
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

        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "13034", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 5, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 10, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 15, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 20, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 25, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 30, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 35, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 40, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 45, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(11), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(110000), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn1(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn2(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn3(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn4(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn5(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn6(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn7(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn8(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn9(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn10(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn11(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn12(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn13(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn14(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn15(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn16(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn17(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１７");

        exClassificationEquals(editSyoukenTbl.getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_F8() {

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

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo8, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(0), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
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

        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13036", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "13038", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13052", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 105, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 0, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14021", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "14080", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(90)
    public void testEditTBL_F9() {
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

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo9, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13036", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "13038", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13052", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 100, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 105, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14021", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "14080", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_F10() {
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
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13036", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13052", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 5, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 10, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 15, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 20, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 25, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 30, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 35, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 40, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 45, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(11), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(110000), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14021", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "14080", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_F11() {

        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN3;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
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

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo11, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 0, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(0), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(0), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14022", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14034", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_F12() {
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

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo12, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 70, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 75, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 80, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 85, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 90, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 95, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 100, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 105, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14011", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "14017", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "14018", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14024", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14036", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14038", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14051", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "14053", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "14074", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(10000), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_F13() {

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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo13, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 75, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 80, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 85, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 90, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 95, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 100, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 105, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14036", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14040", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14054", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14076", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_F14() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN1;
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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 75, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 80, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 85, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 90, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 95, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 100, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 105, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14025", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "14027", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14026", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14036", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14040", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14052", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "14076", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_F15() {

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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo15, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 80, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 85, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 90, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 95, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 100, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 105, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14019", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14042", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14044", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14056", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(10000), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_F16() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo16, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 80, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 85, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 90, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 95, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 100, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 105, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14019", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14042", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14046", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14056", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_F17() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
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

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo17, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 85, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 90, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 95, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 100, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 105, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14019", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(180)
    public void testEditTBL_F18() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo18, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 85, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 90, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 95, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 100, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 105, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14020", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14030", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14050", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(100000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(10000), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(190)
    public void testEditTBL_F19() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo19, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 90, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 95, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 100, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 105, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14013", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "14014", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "14015", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14028", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14027", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14052", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14053", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "14062", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(10000), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_F20() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 90, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 95, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 100, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 105, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14016", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14021", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14029", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14055", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14054", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "14072", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(210)
    public void testEditTBL_F21() {

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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 95, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 100, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 105, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14016", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14025", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14029", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14055", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "14072", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(220)
    public void testEditTBL_F22() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo22, "証券番号");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 95, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 100, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 105, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14016", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14021", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14029", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14055", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
    }

    @Test
    @TestOrder(230)
    public void testEditTBL_F23() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN1;
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

        IT_KykUkt siteiDairi = null;

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = null;

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo23, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000230", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.NONE, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.TYOKUSOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.ARI, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.NONE, "完了通知有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "02490", "表示欄左メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd4(), "", "表示欄左メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd5(), "", "表示欄左メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd6(), "", "表示欄左メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd7(), "", "表示欄左メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd8(), "", "表示欄左メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd9(), "", "表示欄左メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd10(), "", "表示欄左メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd11(), "", "表示欄左メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd12(), "", "表示欄左メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd13(), "", "表示欄左メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd14(), "", "表示欄左メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd15(), "", "表示欄左メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd16(), "", "表示欄左メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd17(), "", "表示欄左メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd18(), "", "表示欄左メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd19(), "", "表示欄左メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd20(), "", "表示欄左メッセージコード２０");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd1(), "02060", "表示欄右メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd3(), "", "表示欄右メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd4(), "", "表示欄右メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd5(), "", "表示欄右メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd6(), "", "表示欄右メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd7(), "", "表示欄右メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd8(), "", "表示欄右メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd9(), "", "表示欄右メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd10(), "", "表示欄右メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd11(), "", "表示欄右メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd12(), "", "表示欄右メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd13(), "", "表示欄右メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd14(), "", "表示欄右メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd15(), "", "表示欄右メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd16(), "", "表示欄右メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd17(), "", "表示欄右メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd18(), "", "表示欄右メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd19(), "", "表示欄右メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd20(), "", "表示欄右メッセージコード２０");
        exDateEquals(hokenSyoukenLst.get(0).getHyoujiransknnkaisiymd(), BizDate.valueOf(20170601), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiranyoteiriritu(), BizNumber.valueOf(0), "表示欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiransjkkktusirrt(), BizNumber.valueOf(0), "表示欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｺ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名４", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字４", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字４", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 89, "被保険者年齢");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn3(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn4(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn5(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn6(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn7(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn8(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn9(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn10(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm1(), "", "（証券）受取人名１");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm2(), "", "（証券）受取人名２");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm3(), "", "（証券）受取人名３");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm4(), "", "（証券）受取人名４");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm5(), "", "（証券）受取人名５");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm6(), "", "（証券）受取人名６");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm7(), "", "（証券）受取人名７");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm8(), "", "（証券）受取人名８");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm9(), "", "（証券）受取人名９");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm10(), "", "（証券）受取人名１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari1(), BizNumber.valueOf(0), "（証券）受取人分割割合１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari2(), BizNumber.valueOf(0), "（証券）受取人分割割合２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari3(), BizNumber.valueOf(0), "（証券）受取人分割割合３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari4(), BizNumber.valueOf(0), "（証券）受取人分割割合４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari5(), BizNumber.valueOf(0), "（証券）受取人分割割合５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari6(), BizNumber.valueOf(0), "（証券）受取人分割割合６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari7(), BizNumber.valueOf(0), "（証券）受取人分割割合７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari8(), BizNumber.valueOf(0), "（証券）受取人分割割合８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari9(), BizNumber.valueOf(0), "（証券）受取人分割割合９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari10(), BizNumber.valueOf(0), "（証券）受取人分割割合１０");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05012", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(100000), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "払込方法メッセージ区分");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykrenban1(), 1, "主契約特約連番１");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykrenban2(), 0, "主契約特約連番２");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykrenban3(), 0, "主契約特約連番３");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykrenban4(), 0, "主契約特約連番４");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykrenban5(), 0, "主契約特約連番５");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykrenban6(), 0, "主契約特約連番６");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykrenban7(), 0, "主契約特約連番７");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykrenban8(), 0, "主契約特約連番８");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykrenban9(), 0, "主契約特約連番９");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykrenban10(), 0, "主契約特約連番１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "06", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn2(), "", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn3(), "", "主契約特約保険期間メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn4(), "", "主契約特約保険期間メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn5(), "", "主契約特約保険期間メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn6(), "", "主契約特約保険期間メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn7(), "", "主契約特約保険期間メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn8(), "", "主契約特約保険期間メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn9(), "", "主契約特約保険期間メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn10(), "", "主契約特約保険期間メッセージ区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype1(), C_Tuukasyu.USD, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype4(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype5(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype6(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype7(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype8(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype9(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype10(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk1(), BizCurrency.valueOf(1000), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk2(), BizCurrency.valueOf(0), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk3(), BizCurrency.valueOf(0), "主契約特約保険金額３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk4(), BizCurrency.valueOf(0), "主契約特約保険金額４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk5(), BizCurrency.valueOf(0), "主契約特約保険金額５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk6(), BizCurrency.valueOf(0), "主契約特約保険金額６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk7(), BizCurrency.valueOf(0), "主契約特約保険金額７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk8(), BizCurrency.valueOf(0), "主契約特約保険金額８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk9(), BizCurrency.valueOf(0), "主契約特約保険金額９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk10(), BizCurrency.valueOf(0), "主契約特約保険金額１０");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn1(), 10, "主契約特約第１保険期間１");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn2(), 0, "主契約特約第１保険期間２");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn3(), 0, "主契約特約第１保険期間３");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn4(), 0, "主契約特約第１保険期間４");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn5(), 0, "主契約特約第１保険期間５");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn6(), 0, "主契約特約第１保険期間６");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn7(), 0, "主契約特約第１保険期間７");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn8(), 0, "主契約特約第１保険期間８");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn9(), 0, "主契約特約第１保険期間９");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn10(), 0, "主契約特約第１保険期間１０");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn1(), 0, "主契約特約第２保険期間１");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 0, "主契約特約第２保険期間２");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn3(), 0, "主契約特約第２保険期間３");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn4(), 0, "主契約特約第２保険期間４");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn5(), 0, "主契約特約第２保険期間５");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn6(), 0, "主契約特約第２保険期間６");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn7(), 0, "主契約特約第２保険期間７");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn8(), 0, "主契約特約第２保険期間８");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn9(), 0, "主契約特約第２保険期間９");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn10(), 0, "主契約特約第２保険期間１０");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto1(), null, "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto2(), null, "主契約特約第１保険期間年月日（至）２");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto3(), null, "主契約特約第１保険期間年月日（至）３");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto4(), null, "主契約特約第１保険期間年月日（至）４");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto5(), null, "主契約特約第１保険期間年月日（至）５");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto6(), null, "主契約特約第１保険期間年月日（至）６");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto7(), null, "主契約特約第１保険期間年月日（至）７");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto8(), null, "主契約特約第１保険期間年月日（至）８");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto9(), null, "主契約特約第１保険期間年月日（至）９");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto10(), null, "主契約特約第１保険期間年月日（至）１０");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto1(), null, "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto3(), null, "主契約特約第２保険期間年月日（至）３");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto4(), null, "主契約特約第２保険期間年月日（至）４");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto5(), null, "主契約特約第２保険期間年月日（至）５");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto6(), null, "主契約特約第２保険期間年月日（至）６");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto7(), null, "主契約特約第２保険期間年月日（至）７");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto8(), null, "主契約特約第２保険期間年月日（至）８");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto9(), null, "主契約特約第２保険期間年月日（至）９");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto10(), null, "主契約特約第２保険期間年月日（至）１０");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd3(), "", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd5(), "", "契約内容欄下メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd6(), "", "契約内容欄下メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd7(), "", "契約内容欄下メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd8(), "", "契約内容欄下メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd9(), "", "契約内容欄下メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd10(), "", "契約内容欄下メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd11(), "", "契約内容欄下メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd12(), "", "契約内容欄下メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd13(), "", "契約内容欄下メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd14(), "", "契約内容欄下メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd15(), "", "契約内容欄下メッセージコード１５");
        exClassificationEquals(hokenSyoukenLst.get(0).getKykniyustitjbrptuuktype(), C_Tuukasyu.BLNK, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKykniyustitjbrp(), BizCurrency.valueOf(0), "契約内容欄下一時払保険料");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09043", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09040", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09110", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09102", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransiteituuka(), "米ドル", "その他内容欄指定通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuktype(), C_Tuukasyu.BLNK, "その他内容欄入金通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukap(), BizCurrency.valueOf(0), "その他内容欄入金通貨保険料");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrannykntuukasyu(), "", "その他内容欄入金通貨");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranenkhrikmrate(), BizNumber.valueOf(0), "その他内容欄円貨払込特約レート");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranstigikwsrate(), BizNumber.valueOf(0), "その他内容欄指定外通貨払込特約レート");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuktype(), C_Tuukasyu.BLNK, "その他内容欄基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngk(), BizCurrency.valueOf(0), "その他内容欄基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngkrate(), BizNumber.valueOf(0), "その他内容欄基準金額換算レート");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrankjnkngktuuka(), "", "その他内容欄基準金額通貨");
        exClassificationEquals(hokenSyoukenLst.get(0).getSonotanyranpentuktype(), C_Tuukasyu.BLNK, "その他内容欄保険料円換算通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranpenknsngk(), BizCurrency.valueOf(0), "その他内容欄保険料円換算額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranmkhwariai(), BizNumber.valueOf(0), "その他内容欄目標到達割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.1), "その他内容欄市場価格調整用利率");
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
        exStringEquals(hokenSyoukenLst.get(0).getDuhutusnrnsyono(), "20806000237", "同封通信欄証券番号");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai1hknkkn(), 10, "死亡保障第１保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai1hknkknymdto(), null, "死亡保障第１保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuuktype(), C_Tuukasyu.JPY, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSibouitjbrpyentuukgk(), BizCurrency.valueOf(11000), "死亡保障一時払保険料相当円換算額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai1kjnkngk(), BizCurrency.valueOf(0), "死亡保障第１基準金額");
        exNumericEquals(hokenSyoukenLst.get(0).getSiboudai2hknkkn(), 0, "死亡保障第２保険期間");
        exDateEquals(hokenSyoukenLst.get(0).getSiboudai2hknkknymdto(), null, "死亡保障第２保険期間年月日（至）");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai2kjnkngk(), BizCurrency.valueOf(0), "死亡保障第２基準金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第３基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSiboudai3kjnkngk(), BizCurrency.valueOf(0), "死亡保障第３基準金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
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
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getInitsbjiyenkasaiteihsygk(), BizCurrency.valueOf(170), "初期死亡時円換算最低保証額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2stuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2s(), BizCurrency.valueOf(0), "第２死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai2syentuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyendaka(), BizCurrency.valueOf(0), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenkijyun(), BizCurrency.valueOf(0), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai2syenyenyasu(), BizCurrency.valueOf(0), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3stuuktype(), C_Tuukasyu.USD, "第３死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3s(), BizCurrency.valueOf(1000), "第３死亡保険金額");
        exClassificationEquals(hokenSyoukenLst.get(0).getDai3syentuuktype(), C_Tuukasyu.JPY, "第３死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyendaka(), BizCurrency.valueOf(120), "第３死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenkijyun(), BizCurrency.valueOf(130), "第３死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getDai3syenyenyasu(), BizCurrency.valueOf(140), "第３死亡保険金額（円貨）（円安）");
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
        exStringEquals(hokenSyoukenLst.get(0).getNkshrstartzenymd(), "", "年金支払開始日前日");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentktype(), "0", "目標到達時円建年金保険変更特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhgk(), BizCurrency.valueOf(0), "目標到達時円建年金保険変更特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyennkhknhentkmkhwari(), BizNumber.valueOf(0), "目標到達時円建年金保険変更特約目標割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getTeiritutmtthbnwr(), BizNumber.valueOf(100), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSisuutmtthbnwr(), BizNumber.valueOf(0), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getMkhyouyensysnikouwra(), BizNumber.valueOf(0), "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd1(), "13030", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst1(), "13050", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykmsgcdst2(), "", "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyoukenLst.get(0).getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen01(), 100, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen02(), 105, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyoukenLst.get(0).getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue01(), "13075", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue02(), "13082", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue03(), "13090", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmknsnhyuptn(), "07", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyoukenLst.get(0).getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyoukenLst.get(0).getStdstmmsgcd(), "", "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyoukenLst.get(0).getFstponegaimsgcd(), "13170", "初回Ｐご確認欄お願いメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getDsmsgcd(), "", "スミセイダイレクトサービスメッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");
        exStringEquals(hokenSyoukenLst.get(0).getToiawasesakihanyoumsgcd(), "13240", "問合せ先汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getAnnaihanyoumsgcd(), "13250", "案内汎用メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd1(), "14016", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd23(), "", "解約返戻金メッセージコード２＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd32(), "", "解約返戻金メッセージコード３＿２");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcd33(), "", "解約返戻金メッセージコード３＿３");
        exStringEquals(hokenSyoukenLst.get(0).getWmsgcdst1(), "", "解約返戻金メッセージコード表下");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd1(), "14021", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd2(), "14029", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd3(), "14055", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyoukenLst.get(0).getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenhrkgk(), BizCurrency.valueOf(0), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyoukenLst.get(0).getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeimsgcd1(), "15044", "控除証明説明メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKoujyosyoumeihskmsgcd(), "", "控除証明補足メッセージコード");
        exStringEquals(hokenSyoukenLst.get(0).getNenkoujyosyoumeihskmsgcd(), "", "年間控除証明補足メッセージコード");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn1(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn2(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn3(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn4(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn5(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn6(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn7(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn8(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn9(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn10(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn11(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１１");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn12(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１２");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn13(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１３");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn14(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１４");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn15(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１５");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn16(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１６");
        exClassificationEquals(hokenSyoukenLst.get(0).getTokusyusyorinaiyoukbn17(), C_TokusyuSyoriNaiyouKbn.BLNK, "特殊処理内容区分１７");
        exStringEquals(hokenSyoukenLst.get(0).getGyoumuKousinKinou(), "EditSyoukenTblTest_editTBL_A5", "業務用更新機能ＩＤ");
        exStringEquals(hokenSyoukenLst.get(0).getGyoumuKousinsyaId(), "JUnit", "業務用更新者ＩＤ");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkn(), "ケイヤクシヤメイカナ４", "契約者名（カナ）");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkn(), "ヒホケンシヤメイカナ４", "被保険者名（カナ）");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(100000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");
        exDateEquals(hokenSyoukenLst.get(0).getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");
        exClassificationEquals(hokenSyoukenLst.get(0).getTantocd(), C_TantouCdKbn.DAIRITENJIMUKANRI, "担当コード");
    }
}