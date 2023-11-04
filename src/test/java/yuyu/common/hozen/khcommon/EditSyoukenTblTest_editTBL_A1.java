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
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMock;
import yuyu.common.siharai.sicommon.CalcJdkghkKngkMock;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
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
public class EditSyoukenTblTest_editTBL_A1 {

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
        HanteiHokenKikanMock.caller = EditSyoukenTblTest_editTBL_A1.class;
        KeisanKijyungkMock.caller = EditSyoukenTblTest_editTBL_A1.class;
        BzGetAgInfoMock.caller = EditSyoukenTblTest_editTBL_A1.class;
        SetOutoubiMock.caller = EditSyoukenTblTest_editTBL_A1.class;
        GetKawaseRateMock.caller = EditSyoukenTblTest_editTBL_A1.class;
        CalcHkShrKngkMock.caller = EditSyoukenTblTest_editTBL_A1.class;
        KeisanGaikakanzanMock.caller = EditSyoukenTblTest_editTBL_A1.class;
        CalcJdkghkKngkMock.caller = EditSyoukenTblTest_editTBL_A1.class;
        EditSuiihyouTblMock.caller = EditSyoukenTblTest_editTBL_A1.class;
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
            testDataAndTblMap = testDataMaker.getInData(EditSyoukenTblTest_editTBL_A1.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        IT_KykKihon kykKihon = new IT_KykKihon();

        List<IT_KykSyouhn> syuKykSyouhnLst = null;

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = new ArrayList<>();

        IT_SyouhnTokujou syouhnTokujou = new IT_SyouhnTokujou();

        IT_KykSya kykSya = new IT_KykSya();

        IT_HhknSya hhknSya = new IT_HhknSya();

        IT_KykUkt sibouHenkan = new IT_KykUkt();

        IT_KykUkt siteiDairi = new IT_KykUkt();

        List<IT_KykDairiten> kykDairitenLst = new ArrayList<>();

        IT_KhTtdkTyuui khTtdkTyuui = new IT_KhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = new ArrayList<>();

        List<IT_NyknJissekiRireki> nyknJissekiRireki = new ArrayList<>();

        BizDate syoriYMD = BizDate.valueOf(20150717);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exNumericEquals(hokenSyoukenLst.size(), 0, "保険証券テーブルエンティティリストの件数");

        exClassificationEquals(editSyoukenTbl.getHassoukbn(), null, "発送区分");
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        IT_KykKihon kykKihon = new IT_KykKihon();

        List<IT_KykSyouhn> syuKykSyouhnLst = new ArrayList<>();

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();

        List<IT_KykSyouhn> tkKykSyouhnLst = new ArrayList<>();

        IT_SyouhnTokujou syouhnTokujou = new IT_SyouhnTokujou();

        IT_KykSya kykSya = new IT_KykSya();

        IT_HhknSya hhknSya = new IT_HhknSya();

        IT_KykUkt sibouHenkan = new IT_KykUkt();

        IT_KykUkt siteiDairi = new IT_KykUkt();

        List<IT_KykDairiten> kykDairitenLst = new ArrayList<>();

        IT_KhTtdkTyuui khTtdkTyuui = new IT_KhTtdkTyuui();

        List<IT_KykUkt> sibouhokenLst = new ArrayList<>();

        List<IT_NyknJissekiRireki> nyknJissekiRireki = new ArrayList<>();

        BizDate syoriYMD = BizDate.valueOf(20150717);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();

        exNumericEquals(hokenSyoukenLst.size(), 0, "保険証券テーブルエンティティリストの件数");

    }

    @Test
    @TestOrder(30)
    public void testEditTBL_B1() {

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

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

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
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000010", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.NONE, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.ARI, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.ARI, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.NONE, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02021", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd4(), "02490", "表示欄左メッセージコード４");
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
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｹ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字１", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 30, "被保険者年齢");

        exClassificationEquals(editSyoukenTbl.getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_B2() {

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

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo2, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000020", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SAI, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.ARI, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.ARI, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.NONE, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02025", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd4(), "02490", "表示欄左メッセージコード４");
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
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名１", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字２", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.KJKHUKA, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字２", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.KJKHUKA, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 30, "被保険者年齢");

        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.JPY, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(11000), "保険料円換算額");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(50)
    public void testEditTBL_B3() {

        MockObjectManager.initialize();

        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN1;
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

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        try {
            editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
                tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
                sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。基準金額が取得できませんでした。", "エラーメッセージ");
            throw e;
        }
    }

    @Test
    @TestOrder(60)
    public void testEditTBL_B4() {
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

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.BLNK;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo4, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000040", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170815), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.BLNK, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.NONE, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.NONE, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.NONE, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.ARI, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd4(), "02072", "表示欄左メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd5(), "02062", "表示欄左メッセージコード５");
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
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd1(), "", "表示欄右メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd2(), "", "表示欄右メッセージコード２");
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
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiransjkkktusirrt(), BizNumber.valueOf(1.2), "表示欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｻ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名２", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字４", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字４", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 103, "被保険者年齢");

        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(2.05), "その他内容欄積立利率");

    }

    @Test
    @TestOrder(70)
    public void testEditTBL_B5() {
        MockObjectManager.initialize();
        KeisanKijyungkMock.SYORIPTN = KeisanKijyungkMock.TESTPATTERN2;
        HanteiHokenKikanMock.SYORIPTN = HanteiHokenKikanMock.TESTPATTERN3;
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
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000050", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170815), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SAI, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.NONE, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.NONE, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.ARI, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02029", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd4(), "02072", "表示欄左メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd5(), "02062", "表示欄左メッセージコード５");
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
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd1(), "", "表示欄右メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd2(), "", "表示欄右メッセージコード２");
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
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiransjkkktusirrt(), BizNumber.valueOf(1.2), "表示欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｻ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名２", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字４", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字４", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 102, "被保険者年齢");

        exClassificationEquals(hokenSyoukenLst.get(0).getPyentuuktype(), C_Tuukasyu.BLNK, "保険料円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getPyen(), BizCurrency.valueOf(0), "保険料円換算額");

        exBizCalcbleEquals(hokenSyoukenLst.get(0).getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_B6() {
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
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000060", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170815), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SAI, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.NONE, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.NONE, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.NONE, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.ARI, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02027", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd5(), "02072", "表示欄左メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd6(), "02062", "表示欄左メッセージコード６");
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
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd1(), "", "表示欄右メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd2(), "", "表示欄右メッセージコード２");
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
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiransjkkktusirrt(), BizNumber.valueOf(1.2), "表示欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｻ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名２", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字４", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字４", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 103, "被保険者年齢");

    }

    @Test
    @TestOrder(90)
    public void testEditTBL_B7() {
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

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SAI;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo7, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000070", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170815), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SAI, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.NONE, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.NONE, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.NONE, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.ARI, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02027", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd4(), "02031", "表示欄左メッセージコード４");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd5(), "02070", "表示欄左メッセージコード５");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd6(), "02062", "表示欄左メッセージコード６");
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
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd1(), "", "表示欄右メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd2(), "", "表示欄右メッセージコード２");
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
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiransjkkktusirrt(), BizNumber.valueOf(1.2), "表示欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｻ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名２", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字４", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字４", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 104, "被保険者年齢");

    }

    @Test
    @TestOrder(100)
    public void testEditTBL_B8() {

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
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000080", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170815), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SAI, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.NONE, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.NONE, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.NONE, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.ARI, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "", "表示欄左メッセージコード３");
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
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd1(), "", "表示欄右メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd2(), "", "表示欄右メッセージコード２");
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
        exDateEquals(hokenSyoukenLst.get(0).getHyoujiransknnkaisiymd(), null, "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiranyoteiriritu(), BizNumber.valueOf(0), "表示欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiransjkkktusirrt(), BizNumber.valueOf(0), "表示欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｻ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名２", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字４", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字４", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 62, "被保険者年齢");

    }

    @Test
    @TestOrder(110)
    public void testEditTBL_B9() {
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
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000090", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170815), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SAI, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.NONE, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.NONE, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.NONE, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.ARI, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02023", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "02050", "表示欄左メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd4(), "02060", "表示欄左メッセージコード４");
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
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd1(), "", "表示欄右メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd2(), "", "表示欄右メッセージコード２");
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
        exDateEquals(hokenSyoukenLst.get(0).getHyoujiransknnkaisiymd(), null, "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiranyoteiriritu(), BizNumber.valueOf(0), "表示欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiransjkkktusirrt(), BizNumber.valueOf(1.2), "表示欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｱ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名３", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字４", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 104, "被保険者年齢");

    }

    @Test
    @TestOrder(120)
    public void testEditTBL_B10() {
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
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000100", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170815), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SAI, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.NONE, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.NONE, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.NONE, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.ARI, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02050", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "", "表示欄左メッセージコード３");
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
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd1(), "", "表示欄右メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd2(), "", "表示欄右メッセージコード２");
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
        exDateEquals(hokenSyoukenLst.get(0).getHyoujiransknnkaisiymd(), null, "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiranyoteiriritu(), BizNumber.valueOf(0.1), "表示欄予定利率");
        exBizCalcbleEquals(hokenSyoukenLst.get(0).getHyoujiransjkkktusirrt(), BizNumber.valueOf(0), "表示欄市場価格調整用利率");
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ｱ1", "保険種類記号");
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
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 60, "被保険者年齢");

    }

    @Test
    @TestOrder(130)
    public void testEditTBL_B11() {

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

        khozenCommonParam.setSikibetuKey("10000000000000110");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo11);

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

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HENKOU);

        BizDate syoriYMD = BizDate.valueOf(20170815);

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo11, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000110", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.NONE, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.ARI, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.NONE, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02027", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd4(), "02490", "表示欄左メッセージコード４");
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
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｻ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名２", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字４", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字４", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 61, "被保険者年齢");

    }

    @Test
    @TestOrder(140)
    public void testEditTBL_B12() {
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

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.HONSYAKAISOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo12, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000120", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.ARI, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.NONE, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02027", "表示欄左メッセージコード２");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd3(), "02029", "表示欄左メッセージコード３");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd4(), "02490", "表示欄左メッセージコード４");
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
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd1(), "02040", "表示欄右メッセージコード１");
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
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｻ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名２", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字４", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字４", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 64, "被保険者年齢");
    }

    @Test
    @TestOrder(150)
    public void testEditTBL_B13() {
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

        List<IT_KykUkt> sibouhokenLst = null;

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
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000130", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
        exClassificationEquals(hokenSyoukenLst.get(0).getInsizeishryouhikbn(), C_InsizeiShryouhiKbn.YOU, "印紙税支払要否区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getHassoukbn(), C_HassouKbn.HONSYAKAISOU, "発送区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKoujyosyoumeiumukbn(), C_UmuKbn.ARI, "控除証明書有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getKanryoutuutiumukbn(), C_UmuKbn.NONE, "完了通知有無区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSuiihyouumukbn(), C_UmuKbn.ARI, "推移表有無区分");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranhidarimsgcd2(), "02023", "表示欄左メッセージコード２");
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
        exStringEquals(hokenSyoukenLst.get(0).getHyoujiranmigiimsgcd1(), "02510", "表示欄右メッセージコード１");
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
        exStringEquals(hokenSyoukenLst.get(0).getHknsyukigou(), "ﾕｱ", "保険種類記号");
        exStringEquals(hokenSyoukenLst.get(0).getHanbainm(), "", "販売名称");
        exClassificationEquals(hokenSyoukenLst.get(0).getAisyoumeikbn(), C_AisyoumeiKbn.GAIKASYUUSIN_K2_MDHN, "愛称名区分");
        exStringEquals(hokenSyoukenLst.get(0).getSeisikihknnm(), "商品名３", "正式保険名称");
        exDateEquals(hokenSyoukenLst.get(0).getKouryokukaisiymd(), null, "効力開始年月日");
        exStringEquals(hokenSyoukenLst.get(0).getKyknmkj(), "契約者名漢字４", "契約者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getKyknmkjkhukakbn(), C_KjkhukaKbn.BLNK, "契約者名漢字化不可区分");
        exStringEquals(hokenSyoukenLst.get(0).getHhknnmkj(), "被保険者名漢字４", "被保険者名（漢字）");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "被保険者名漢字化不可区分");
        exDateEquals(hokenSyoukenLst.get(0).getHhknseiymd(), BizDate.valueOf(19870601), "被保険者生年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(hokenSyoukenLst.get(0).getHhknnen(), 65, "被保険者年齢");
    }

    @Test
    @TestOrder(160)
    public void testEditTBL_B14() {
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

        List<IT_KykUkt> sibouhokenLst = null;

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
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000140", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(170)
    public void testEditTBL_B15() {
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

        List<IT_KykUkt> sibouhokenLst = null;

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
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000150", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(180)
    public void testEditTBL_B16() {
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

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo16, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000160", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(190)
    public void testEditTBL_B17() {
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

        khozenCommonParam.setSikibetuKey("10000000000000170");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo17);

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

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo17, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000170", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(200)
    public void testEditTBL_B18() {
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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey8, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo18, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000180", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(210)
    public void testEditTBL_B19() {
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

        List<IT_KykUkt> sibouhokenLst = null;

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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey9, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo19, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000190", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(220)
    public void testEditTBL_B20() {
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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey10, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo20, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000200", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(230)
    public void testEditTBL_B21() {
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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey1, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo21, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000210", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(240)
    public void testEditTBL_B22() {
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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey2, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo22, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000220", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(250)
    public void testEditTBL_B23() {
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
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey3, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo23, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000230", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(260)
    public void testEditTBL_B24() {
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

        khozenCommonParam.setSikibetuKey("10000000000000240");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo24);

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

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey4, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo24, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000240", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(270)
    public void testEditTBL_B25() {
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

        khozenCommonParam.setSikibetuKey("10000000000000250");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo25);

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

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey5, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo25, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000250", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(280)
    public void testEditTBL_B26() {
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

        khozenCommonParam.setSikibetuKey("10000000000000260");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo26);

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

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey6, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo26, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000260", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.ARI, "転送不要郵便有無");
    }

    @Test
    @TestOrder(290)
    public void testEditTBL_B27() {
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

        khozenCommonParam.setSikibetuKey("10000000000000270");

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syoNo27);

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

        C_SinsaihkKbn sinsaihkKbn = C_SinsaihkKbn.SIN;

        C_TetudukisyuKbn tetudukisyuKbn = C_TetudukisyuKbn.KAIYAKU;

        C_HassouKbn hassouKbn = C_HassouKbn.TYOKUSOU;

        editSyoukenTbl.editTBL(khozenCommonParam, kykKihon, syuKykSyouhnLst, kykSonotaTkyk,
            tkKykSyouhnLst, syouhnTokujou, kykSya, hhknSya, sibouHenkan, siteiDairi, kykDairitenLst, khTtdkTyuui,
            sibouhokenLst, nyknJissekiRireki, editHokenSyoukenParam, syoriYMD, sinsaihkKbn, tetudukisyuKbn, hassouKbn);

        List<IT_HokenSyouken> hokenSyoukenLst = kykKihon.getHokenSyoukens();
        exStringEquals(hokenSyoukenLst.get(0).getKbnkey(), kbnKey7, "区分キー");
        exStringEquals(hokenSyoukenLst.get(0).getSyono(), syoNo27, "証券番号");
        exDateEquals(hokenSyoukenLst.get(0).getTyouhyouymd(), BizDate.valueOf(20170815), "帳票作成日");
        exStringEquals(hokenSyoukenLst.get(0).getHenkousikibetukey(), "10000000000000270", "変更識別キー");
        exDateEquals(hokenSyoukenLst.get(0).getSyohakkouymd(), BizDate.valueOf(20170817), "証券発行年月日");
        exClassificationEquals(hokenSyoukenLst.get(0).getSinsaihkkbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyoukensaihkkbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getStdrsktirasidouhuukbn(), C_UmuKbn.ARI, "指定代理請求チラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getDstirasidouhuukbn(), C_UmuKbn.NONE, "ＤＳチラシ同封区分");
        exClassificationEquals(hokenSyoukenLst.get(0).getSyotnshuyoupostumukbn(), C_UmuKbn.NONE, "転送不要郵便有無");
    }
}