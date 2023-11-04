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
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

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
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoukenUktKbn;
import yuyu.def.classification.C_SyoukenUktMidasiKbn;
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
public class EditSyoukenTblTest_editTBL_A2 {

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
        HanteiHokenKikanMock.caller = EditSyoukenTblTest_editTBL_A2.class;
        KeisanKijyungkMock.caller = EditSyoukenTblTest_editTBL_A2.class;
        BzGetAgInfoMock.caller = EditSyoukenTblTest_editTBL_A2.class;
        SetOutoubiMock.caller = EditSyoukenTblTest_editTBL_A2.class;
        GetKawaseRateMock.caller = EditSyoukenTblTest_editTBL_A2.class;
        CalcHkShrKngkMock.caller = EditSyoukenTblTest_editTBL_A2.class;
        KeisanGaikakanzanMock.caller = EditSyoukenTblTest_editTBL_A2.class;
        CalcJdkghkKngkMock.caller = EditSyoukenTblTest_editTBL_A2.class;
        EditSuiihyouTblMock.caller = EditSyoukenTblTest_editTBL_A2.class;
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
            testDataAndTblMap = testDataMaker.getInData(EditSyoukenTblTest_editTBL_A2.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ002", testDataAndTblMap);
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
    public void testEditTBL_C1() {

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

        List<IT_KykDairiten> kykDairitenLst = kykKihon.getKykDairitens();

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);

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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(100000), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "03", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "03", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "04", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "05", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn2(), "02", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn3(), "03", "主契約特約保険期間メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn4(), "", "主契約特約保険期間メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn5(), "", "主契約特約保険期間メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn6(), "", "主契約特約保険期間メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn7(), "", "主契約特約保険期間メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn8(), "", "主契約特約保険期間メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn9(), "", "主契約特約保険期間メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn10(), "", "主契約特約保険期間メッセージ区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype3(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype4(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype5(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype6(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype7(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype8(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype9(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype10(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk1(), BizCurrency.valueOf(0), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk2(), BizCurrency.valueOf(0), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk3(), BizCurrency.valueOf(1000), "主契約特約保険金額３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk4(), BizCurrency.valueOf(0), "主契約特約保険金額４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk5(), BizCurrency.valueOf(0), "主契約特約保険金額５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk6(), BizCurrency.valueOf(0), "主契約特約保険金額６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk7(), BizCurrency.valueOf(0), "主契約特約保険金額７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk8(), BizCurrency.valueOf(0), "主契約特約保険金額８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk9(), BizCurrency.valueOf(0), "主契約特約保険金額９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk10(), BizCurrency.valueOf(0), "主契約特約保険金額１０");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn1(), 5, "主契約特約第１保険期間１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 5, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd2(), "08020", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd3(), "08030", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd4(), "08050", "契約内容欄下メッセージコード４");
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
        exClassificationEquals(hokenSyoukenLst.get(0).getKykniyustitjbrptuuktype(), C_Tuukasyu.JPY, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKykniyustitjbrp(), BizCurrency.valueOf(200), "契約内容欄下一時払保険料");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09032", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09038", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09040", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09050", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09090", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09100", "その他内容欄メッセージコード９");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.1), "その他内容欄市場価格調整用利率");

        exClassificationEquals(editSyoukenTbl.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_C2() {

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
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);

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
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.NKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.STDR, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.KYK, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn3(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn4(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn5(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn6(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn7(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn8(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn9(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn10(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm1(), "", "（証券）受取人名１");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm2(), "契約者名漢字２", "（証券）受取人名２");
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
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05030", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 10, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09002", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09006", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09030", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09042", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09045", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09046", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09034", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "09070", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "09110", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "09102", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.1), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), BizDate.valueOf(20180401), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(11), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(1.28), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.5836), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0.55), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(100000), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "その他内容欄指数名");
    }

    @Test
    @TestOrder(30)
    public void testEditTBL_C3() {

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
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.NKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.SBKFKUKT, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.STDR, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.HHKN, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.HYOUJIRANNOTOORI, "（証券）受取人区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn3(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分３");
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
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 10, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09003", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09007", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09010", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09043", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09034", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09080", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09110", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09102", "その他内容欄メッセージコード１０");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.2), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), BizDate.valueOf(20180401), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(1.28), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(100000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_C4() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN1;
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

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo4, "証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.NKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.STDR, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.HYOUJIRANNOTOORI, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分２");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "05020", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(200.01, BizCurrencyTypes.EURO), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "ユーロ", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05050", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "03", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "05", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "06", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "03", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn2(), "04", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn3(), "02", "主契約特約保険期間メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn4(), "", "主契約特約保険期間メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn5(), "", "主契約特約保険期間メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn6(), "", "主契約特約保険期間メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn7(), "", "主契約特約保険期間メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn8(), "", "主契約特約保険期間メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn9(), "", "主契約特約保険期間メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn10(), "", "主契約特約保険期間メッセージ区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype3(), C_Tuukasyu.USD, "主契約特約保険金額通貨タイプ３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype4(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype5(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype6(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype7(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype8(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype9(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype10(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk1(), BizCurrency.valueOf(0), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk2(), BizCurrency.valueOf(0), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk3(), BizCurrency.valueOf(1000), "主契約特約保険金額３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk4(), BizCurrency.valueOf(0), "主契約特約保険金額４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk5(), BizCurrency.valueOf(0), "主契約特約保険金額５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk6(), BizCurrency.valueOf(0), "主契約特約保険金額６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk7(), BizCurrency.valueOf(0), "主契約特約保険金額７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk8(), BizCurrency.valueOf(0), "主契約特約保険金額８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk9(), BizCurrency.valueOf(0), "主契約特約保険金額９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk10(), BizCurrency.valueOf(0), "主契約特約保険金額１０");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn1(), 5, "主契約特約第１保険期間１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 5, "主契約特約第２保険期間２");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn3(), 0, "主契約特約第２保険期間３");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn4(), 0, "主契約特約第２保険期間４");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn5(), 0, "主契約特約第２保険期間５");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn6(), 0, "主契約特約第２保険期間６");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn7(), 0, "主契約特約第２保険期間７");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn8(), 0, "主契約特約第２保険期間８");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn9(), 0, "主契約特約第２保険期間９");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn10(), 0, "主契約特約第２保険期間１０");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto1(), BizDate.valueOf(20170831), "主契約特約第１保険期間年月日（至）１");
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
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto2(), BizDate.valueOf(20220831), "主契約特約第２保険期間年月日（至）２");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto3(), null, "主契約特約第２保険期間年月日（至）３");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto4(), null, "主契約特約第２保険期間年月日（至）４");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto5(), null, "主契約特約第２保険期間年月日（至）５");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto6(), null, "主契約特約第２保険期間年月日（至）６");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto7(), null, "主契約特約第２保険期間年月日（至）７");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto8(), null, "主契約特約第２保険期間年月日（至）８");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto9(), null, "主契約特約第２保険期間年月日（至）９");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto10(), null, "主契約特約第２保険期間年月日（至）１０");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd2(), "08020", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd3(), "08050", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd4(), "08060", "契約内容欄下メッセージコード４");
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
        exClassificationEquals(hokenSyoukenLst.get(0).getKykniyustitjbrptuuktype(), C_Tuukasyu.JPY, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getKykniyustitjbrp(), BizCurrency.valueOf(100), "契約内容欄下一時払保険料");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09001", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09010", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09020", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09022", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09024", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09030", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09032", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09034", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09080", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09038", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "09040", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "09050", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "09060", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), BizDate.valueOf(20180401), "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");

    }

    @Test
    @TestOrder(50)
    public void testEditTBL_C5() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
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
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBKFKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.STDR, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.HYOUJIRANNOTOORI, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn3(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn4(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn5(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn6(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn7(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn8(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn9(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn10(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm1(), "", "（証券）受取人名１");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm2(), "指定代理請求人の受取人名", "（証券）受取人名２");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "03", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "04", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "03", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn2(), "02", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn3(), "", "主契約特約保険期間メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn4(), "", "主契約特約保険期間メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn5(), "", "主契約特約保険期間メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn6(), "", "主契約特約保険期間メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn7(), "", "主契約特約保険期間メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn8(), "", "主契約特約保険期間メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn9(), "", "主契約特約保険期間メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn10(), "", "主契約特約保険期間メッセージ区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype2(), C_Tuukasyu.USD, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype4(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype5(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype6(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype7(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype8(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype9(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype10(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk1(), BizCurrency.valueOf(0), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk2(), BizCurrency.valueOf(1000), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk3(), BizCurrency.valueOf(0), "主契約特約保険金額３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk4(), BizCurrency.valueOf(0), "主契約特約保険金額４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk5(), BizCurrency.valueOf(0), "主契約特約保険金額５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk6(), BizCurrency.valueOf(0), "主契約特約保険金額６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk7(), BizCurrency.valueOf(0), "主契約特約保険金額７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk8(), BizCurrency.valueOf(0), "主契約特約保険金額８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk9(), BizCurrency.valueOf(0), "主契約特約保険金額９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk10(), BizCurrency.valueOf(0), "主契約特約保険金額１０");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn1(), 5, "主契約特約第１保険期間１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 5, "主契約特約第２保険期間２");
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
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto1(), BizDate.valueOf(20220831), "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto3(), null, "主契約特約第２保険期間年月日（至）３");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto4(), null, "主契約特約第２保険期間年月日（至）４");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto5(), null, "主契約特約第２保険期間年月日（至）５");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto6(), null, "主契約特約第２保険期間年月日（至）６");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto7(), null, "主契約特約第２保険期間年月日（至）７");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto8(), null, "主契約特約第２保険期間年月日（至）８");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto9(), null, "主契約特約第２保険期間年月日（至）９");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto10(), null, "主契約特約第２保険期間年月日（至）１０");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08040", "契約内容欄下メッセージコード１");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09086", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09038", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09070", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09072", "その他内容欄メッセージコード６");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_C6() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
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
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBKFKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.NONE, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.STDR, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn3(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn4(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn5(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn6(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn7(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn8(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn9(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn10(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm1(), "死亡保険金受取人の受取人名", "（証券）受取人名１");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm2(), "", "（証券）受取人名２");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm3(), "", "（証券）受取人名３");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm4(), "", "（証券）受取人名４");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm5(), "", "（証券）受取人名５");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm6(), "", "（証券）受取人名６");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm7(), "", "（証券）受取人名７");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm8(), "", "（証券）受取人名８");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm9(), "", "（証券）受取人名９");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm10(), "", "（証券）受取人名１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari1(), BizNumber.valueOf(5), "（証券）受取人分割割合１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari2(), BizNumber.valueOf(6), "（証券）受取人分割割合２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari3(), BizNumber.valueOf(0), "（証券）受取人分割割合３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari4(), BizNumber.valueOf(0), "（証券）受取人分割割合４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari5(), BizNumber.valueOf(0), "（証券）受取人分割割合５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari6(), BizNumber.valueOf(0), "（証券）受取人分割割合６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari7(), BizNumber.valueOf(0), "（証券）受取人分割割合７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari8(), BizNumber.valueOf(0), "（証券）受取人分割割合８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari9(), BizNumber.valueOf(0), "（証券）受取人分割割合９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari10(), BizNumber.valueOf(0), "（証券）受取人分割割合１０");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "ユーロ", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 10, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09024", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09030", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09034", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09042", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09045", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09046", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09084", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "09070", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "09074", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(1.28), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.5836), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0.55), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(20006), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "その他内容欄指数名");

    }

    @Test
    @TestOrder(70)
    public void testEditTBL_C7() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
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
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.STDR, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.HYOUJIRANNOTOORI, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.NASI, "（証券）受取人区分２");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "05022", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 10, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09082", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09070", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09074", "その他内容欄メッセージコード６");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1007), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");

    }

    @Test
    @TestOrder(80)
    public void testEditTBL_C8() {

        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN3;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
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
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBKFKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.HHKN, "（証券）受取人区分１");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05011", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.BLNK, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "07", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "03", "主契約特約保険期間メッセージ区分１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn1(), 5, "主契約特約第１保険期間１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 5, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd1(), "09020", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09024", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09030", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09034", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09047", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09060", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09035", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09083", "その他内容欄メッセージコード８");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), BizDate.valueOf(20180424), "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");

    }

    @Test
    @TestOrder(90)
    public void testEditTBL_C9() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN3;
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
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.KYK, "（証券）受取人区分１");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "05020", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "03", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "03", "主契約特約保険期間メッセージ区分１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn1(), 5, "主契約特約第１保険期間１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 5, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09082", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09038", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09036", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09083", "その他内容欄メッセージコード６");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");
    }

    @Test
    @TestOrder(100)
    public void testEditTBL_C10() {
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
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.SOUZOKU, "（証券）受取人区分１");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05040", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "03", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "01", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "02", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "03", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn2(), "04", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn3(), "02", "主契約特約保険期間メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn4(), "", "主契約特約保険期間メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn5(), "", "主契約特約保険期間メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn6(), "", "主契約特約保険期間メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn7(), "", "主契約特約保険期間メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn8(), "", "主契約特約保険期間メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn9(), "", "主契約特約保険期間メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn10(), "", "主契約特約保険期間メッセージ区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype3(), C_Tuukasyu.USD, "主契約特約保険金額通貨タイプ３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype4(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype5(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype6(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype7(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype8(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype9(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype10(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk1(), BizCurrency.valueOf(0), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk2(), BizCurrency.valueOf(0), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk3(), BizCurrency.valueOf(1000), "主契約特約保険金額３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk4(), BizCurrency.valueOf(0), "主契約特約保険金額４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk5(), BizCurrency.valueOf(0), "主契約特約保険金額５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk6(), BizCurrency.valueOf(0), "主契約特約保険金額６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk7(), BizCurrency.valueOf(0), "主契約特約保険金額７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk8(), BizCurrency.valueOf(0), "主契約特約保険金額８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk9(), BizCurrency.valueOf(0), "主契約特約保険金額９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk10(), BizCurrency.valueOf(0), "主契約特約保険金額１０");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn1(), 5, "主契約特約第１保険期間１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 5, "主契約特約第２保険期間２");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn3(), 0, "主契約特約第２保険期間３");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn4(), 0, "主契約特約第２保険期間４");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn5(), 0, "主契約特約第２保険期間５");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn6(), 0, "主契約特約第２保険期間６");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn7(), 0, "主契約特約第２保険期間７");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn8(), 0, "主契約特約第２保険期間８");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn9(), 0, "主契約特約第２保険期間９");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn10(), 0, "主契約特約第２保険期間１０");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai1hknkknymdto1(), BizDate.valueOf(20170831), "主契約特約第１保険期間年月日（至）１");
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
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto2(), BizDate.valueOf(20220831), "主契約特約第２保険期間年月日（至）２");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto3(), null, "主契約特約第２保険期間年月日（至）３");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto4(), null, "主契約特約第２保険期間年月日（至）４");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto5(), null, "主契約特約第２保険期間年月日（至）５");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto6(), null, "主契約特約第２保険期間年月日（至）６");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto7(), null, "主契約特約第２保険期間年月日（至）７");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto8(), null, "主契約特約第２保険期間年月日（至）８");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto9(), null, "主契約特約第２保険期間年月日（至）９");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto10(), null, "主契約特約第２保険期間年月日（至）１０");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd2(), "08020", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd3(), "08030", "契約内容欄下メッセージコード３");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09024", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09033", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09085", "その他内容欄メッセージコード６");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");
    }

    @Test
    @TestOrder(110)
    public void testEditTBL_C11() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
        CalcJdkghkKngkMock.SYORIPTN  = CalcJdkghkKngkMock.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

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
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分１");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "03", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "04", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "03", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "04", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn2(), "02", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn3(), "", "主契約特約保険期間メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn4(), "", "主契約特約保険期間メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn5(), "", "主契約特約保険期間メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn6(), "", "主契約特約保険期間メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn7(), "", "主契約特約保険期間メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn8(), "", "主契約特約保険期間メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn9(), "", "主契約特約保険期間メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn10(), "", "主契約特約保険期間メッセージ区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype2(), C_Tuukasyu.USD, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype4(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype5(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype6(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype7(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype8(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype9(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype10(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk1(), BizCurrency.valueOf(0), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk2(), BizCurrency.valueOf(1000), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk3(), BizCurrency.valueOf(0), "主契約特約保険金額３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk4(), BizCurrency.valueOf(0), "主契約特約保険金額４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk5(), BizCurrency.valueOf(0), "主契約特約保険金額５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk6(), BizCurrency.valueOf(0), "主契約特約保険金額６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk7(), BizCurrency.valueOf(0), "主契約特約保険金額７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk8(), BizCurrency.valueOf(0), "主契約特約保険金額８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk9(), BizCurrency.valueOf(0), "主契約特約保険金額９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk10(), BizCurrency.valueOf(0), "主契約特約保険金額１０");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn1(), 5, "主契約特約第１保険期間１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 5, "主契約特約第２保険期間２");
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
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto1(), BizDate.valueOf(20220831), "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto3(), null, "主契約特約第２保険期間年月日（至）３");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto4(), null, "主契約特約第２保険期間年月日（至）４");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto5(), null, "主契約特約第２保険期間年月日（至）５");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto6(), null, "主契約特約第２保険期間年月日（至）６");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto7(), null, "主契約特約第２保険期間年月日（至）７");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto8(), null, "主契約特約第２保険期間年月日（至）８");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto9(), null, "主契約特約第２保険期間年月日（至）９");
        exDateEquals(hokenSyoukenLst.get(0).getSyutkdai2hknkknymdto10(), null, "主契約特約第２保険期間年月日（至）１０");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08040", "契約内容欄下メッセージコード１");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09060", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09037", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09085", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");
    }

    @Test
    @TestOrder(120)
    public void testEditTBL_C12() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN3;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
        CalcHkShrKngkMock.SYORIPTN = CalcHkShrKngkMock.TESTPATTERN1;
        KeisanGaikakanzanMock.SYORIPTN = KeisanGaikakanzanMock.TESTPATTERN2;
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
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分１");
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
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari1(), BizNumber.valueOf(1), "（証券）受取人分割割合１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari2(), BizNumber.valueOf(0), "（証券）受取人分割割合２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari3(), BizNumber.valueOf(0), "（証券）受取人分割割合３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari4(), BizNumber.valueOf(0), "（証券）受取人分割割合４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari5(), BizNumber.valueOf(0), "（証券）受取人分割割合５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari6(), BizNumber.valueOf(0), "（証券）受取人分割割合６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari7(), BizNumber.valueOf(0), "（証券）受取人分割割合７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari8(), BizNumber.valueOf(0), "（証券）受取人分割割合８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari9(), BizNumber.valueOf(0), "（証券）受取人分割割合９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari10(), BizNumber.valueOf(0), "（証券）受取人分割割合１０");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "03", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "03", "主契約特約保険期間メッセージ区分１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn1(), 5, "主契約特約第１保険期間１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 5, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09060", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");
    }

    @Test
    @TestOrder(130)
    public void testEditTBL_C13() {
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

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo13, "証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBKFKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.HHKN, "（証券）受取人区分１");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(100000), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "03", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "01", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "02", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "05", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn2(), "02", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn3(), "03", "主契約特約保険期間メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn4(), "", "主契約特約保険期間メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn5(), "", "主契約特約保険期間メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn6(), "", "主契約特約保険期間メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn7(), "", "主契約特約保険期間メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn8(), "", "主契約特約保険期間メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn9(), "", "主契約特約保険期間メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn10(), "", "主契約特約保険期間メッセージ区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype3(), C_Tuukasyu.USD, "主契約特約保険金額通貨タイプ３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype4(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype5(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype6(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype7(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype8(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype9(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyukyktkykstuukatype10(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk1(), BizCurrency.valueOf(0), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk2(), BizCurrency.valueOf(0), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk3(), BizCurrency.valueOf(1000), "主契約特約保険金額３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk4(), BizCurrency.valueOf(0), "主契約特約保険金額４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk5(), BizCurrency.valueOf(0), "主契約特約保険金額５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk6(), BizCurrency.valueOf(0), "主契約特約保険金額６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk7(), BizCurrency.valueOf(0), "主契約特約保険金額７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk8(), BizCurrency.valueOf(0), "主契約特約保険金額８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk9(), BizCurrency.valueOf(0), "主契約特約保険金額９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkngk10(), BizCurrency.valueOf(0), "主契約特約保険金額１０");
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai1hknkkn1(), 5, "主契約特約第１保険期間１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 5, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd2(), "08020", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getKykniyustmsgcd3(), "08040", "契約内容欄下メッセージコード３");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09060", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09090", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09100", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.2), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");
    }

    @Test
    @TestOrder(140)
    public void testEditTBL_C14() {
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
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo14, "証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.KYK, "（証券）受取人区分１");
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
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05020", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 10, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09030", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09044", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09060", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09035", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09083", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09110", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09102", "その他内容欄メッセージコード９");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.2), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(101000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(-1000), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_C15() {
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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo15, "証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.SOUZOKU, "（証券）受取人区分１");
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
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 10, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09044", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09045", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09046", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09060", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09036", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09084", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09110", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09102", "その他内容欄メッセージコード９");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(1.2), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(99000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(1000), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "その他内容欄指数名");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_C16() {
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

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo16, "証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn3(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn4(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn5(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn6(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn7(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn8(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn9(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn10(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm1(), "ああああ", "（証券）受取人名１");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170701), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 10, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09044", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09060", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(1016), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(20016), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_C17() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        BzGetAgInfoMock.SYORIPTN = BzGetAgInfoMock.TESTPATTERN1;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo17, "証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBKFKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.NONE, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.STDR, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn3(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn4(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn5(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn6(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn7(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn8(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn9(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn10(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm1(), "死亡保険金受取人の受取人名", "（証券）受取人名１");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm2(), "", "（証券）受取人名２");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm3(), "", "（証券）受取人名３");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm4(), "", "（証券）受取人名４");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm5(), "", "（証券）受取人名５");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm6(), "", "（証券）受取人名６");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm7(), "", "（証券）受取人名７");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm8(), "", "（証券）受取人名８");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm9(), "", "（証券）受取人名９");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm10(), "", "（証券）受取人名１０");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari1(), BizNumber.valueOf(5), "（証券）受取人分割割合１");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari2(), BizNumber.valueOf(6), "（証券）受取人分割割合２");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari3(), BizNumber.valueOf(0), "（証券）受取人分割割合３");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari4(), BizNumber.valueOf(0), "（証券）受取人分割割合４");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari5(), BizNumber.valueOf(0), "（証券）受取人分割割合５");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari6(), BizNumber.valueOf(0), "（証券）受取人分割割合６");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari7(), BizNumber.valueOf(0), "（証券）受取人分割割合７");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari8(), BizNumber.valueOf(0), "（証券）受取人分割割合８");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari9(), BizNumber.valueOf(0), "（証券）受取人分割割合９");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSyoukenuktbnwari10(), BizNumber.valueOf(0), "（証券）受取人分割割合１０");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "ユーロ", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170901), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 10, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09020", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09024", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09030", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09034", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09042", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd7(), "09045", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd8(), "09046", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd9(), "09084", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd10(), "09060", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd11(), "09070", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd12(), "09074", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(1.28), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0.5836), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0.55), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(0), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(100000), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "その他内容欄指数名");

    }

    @Test
    @TestOrder(180)
    public void testEditTBL_C18() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN2;
        SetOutoubiMock.SYORIPTN = SetOutoubiMock.TESTPATTERN1;
        GetKawaseRateMock.SYORIPTN = GetKawaseRateMock.TESTPATTERN2;
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
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo18, "証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.STDR, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.HYOUJIRANNOTOORI, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.NASI, "（証券）受取人区分２");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170901), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 10, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09086", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09070", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "09074", "その他内容欄メッセージコード６");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(100000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(0), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "", "その他内容欄指数名");

    }
    @Test
    @TestOrder(190)
    public void testEditTBL_C19() {
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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo19, "証券番号");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn1(), C_SyoukenUktMidasiKbn.SBHKKUKT, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn2(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn3(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn4(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn5(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn6(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn7(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn8(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn9(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktmidasikbn10(), C_SyoukenUktMidasiKbn.BLNK, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn1(), C_SyoukenUktKbn.TOKUTEIMEIGI, "（証券）受取人区分１");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn2(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分２");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn3(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分３");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn4(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分４");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn5(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分５");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn6(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分６");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn7(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分７");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn8(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分８");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn9(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分９");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukenuktkbn10(), C_SyoukenUktKbn.BLNK, "（証券）受取人区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyoukenuktnm1(), "ああああ", "（証券）受取人名１");
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
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd1(), "05013", "保険料メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd2(), "", "保険料メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getPmsgcd3(), "", "保険料メッセージコード３");
        exClassificationEquals(hokenSyoukenLst.get(0).getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHokenryou(), BizCurrency.valueOf(0), "保険料");
        exStringEquals(hokenSyoukenLst.get(0).getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyoukenLst.get(0).getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exDateEquals(hokenSyoukenLst.get(0).getKykymd(), BizDate.valueOf(20170902), "契約日");
        exStringEquals(hokenSyoukenLst.get(0).getPhrkkknmidasikbn(), "01", "保険料払込期間見出し区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkknmsgkbn(), "", "払込期間メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkaisuumsgkbn(), "", "払込回数メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkkitukimsgkbn(), "", "払込期月メッセージ区分");
        exStringEquals(hokenSyoukenLst.get(0).getHrkhouhoumsgkbn(), "", "込方法メッセージ区分");
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
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn4(), "", "主契約特約メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn5(), "", "主契約特約メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn6(), "", "主契約特約メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn7(), "", "主契約特約メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn8(), "", "主契約特約メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn9(), "", "主契約特約メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykmsgkbn10(), "", "主契約特約メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn1(), "08", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn2(), "", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn3(), "", "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn4(), "", "主契約特約保険金額メッセージ区分４");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn5(), "", "主契約特約保険金額メッセージ区分５");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn6(), "", "主契約特約保険金額メッセージ区分６");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn7(), "", "主契約特約保険金額メッセージ区分７");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn8(), "", "主契約特約保険金額メッセージ区分８");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn9(), "", "主契約特約保険金額メッセージ区分９");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkyksmsgkbn10(), "", "主契約特約保険金額メッセージ区分１０");
        exStringEquals(hokenSyoukenLst.get(0).getSyukyktkykhknkknmsgkbn1(), "05", "主契約特約保険期間メッセージ区分１");
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
        exNumericEquals(hokenSyoukenLst.get(0).getSyukyktkykdai2hknkkn2(), 10, "主契約特約第２保険期間２");
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
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd2(), "09044", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd3(), "09045", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd4(), "09046", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd5(), "09060", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
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

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranytirrt(), BizNumber.valueOf(0), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransjkkktusirrt(), BizNumber.valueOf(0), "その他内容欄市場価格調整用利率");

        exDateEquals(hokenSyoukenLst.get(0).getSonotanyrannkshrstartymd(), null, "その他内容欄年金支払開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrannenkinkkn(), BizNumber.valueOf(0), "その他内容欄年金期間");
        exDateEquals(hokenSyoukenLst.get(0).getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantmttknzkrtjygn(), BizNumber.valueOf(0), "その他内容欄積立金増加率上限");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransetteibairitu(), BizNumber.valueOf(0), "その他内容欄設定倍率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyranteiritutmttkngk(), BizCurrency.valueOf(99000), "その他内容欄定率積立金額");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyransisuutmttkngk(), BizCurrency.valueOf(1000), "その他内容欄指数積立金額");
        exStringEquals(hokenSyoukenLst.get(0).getSonotanyransisuunm(), "ＳＧＩ　ＦＩＡ　マルチ・アセット指数（米ドル）", "その他内容欄指数名");
    }
}