package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.bzcommon.SetNenreiMockForHozen;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 契約内容のお知らせ編集５クラスのメソッド {@link EditKykNaiyouOsirase5#editInfo(IT_KykKihon,BizDate,BizDate,ZT_GaikaKokyakuTuutiTy)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsirase5Test_editInfo {

    @Inject
    private EditKykNaiyouOsirase5 editKykNaiyouOsirase5;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約内容のお知らせ編集５";
    private final static String sheetName = "INデータ";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
                bind(SetNenrei.class).to(SetNenreiMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        CalcHkShrKngkMockForHozen.caller = EditKykNaiyouOsirase5Test_editInfo.class;
        SetNenreiMockForHozen.caller = EditKykNaiyouOsirase5Test_editInfo.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.caller = null;
        CalcHkShrKngkMockForHozen.SYORIPTN = null;
        SetNenreiMockForHozen.caller = null;
        SetNenreiMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditKykNaiyouOsirase5Test_editInfo.class, fileName, sheetName);

            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);

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
    }

    @Test
    @TestOrder(10)
    public void testEditInfo_A1() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015512");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0),
            "99806015512", "証券番号");

        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1),
            BizDate.valueOf(20280831), "計算基準日");

        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 2),
            C_SiinKbn.SP, "死因区分");

        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBKYUUHUKIN, "保険金種類区分");

        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");

        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exNumericEquals((Integer)MockObjectManager.getArgument(SetNenreiMockForHozen.class, "getNkshrStartNenrei", 0, 0), 50, "被保険者年齢");

        exNumericEquals((Integer)MockObjectManager.getArgument(SetNenreiMockForHozen.class, "getNkshrStartNenrei", 0, 1), 10, "保険期間");

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03005", "（中継用）挨拶文メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), null, "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２８年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "９９年確定年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08007", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133575829", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(20)
    public void testEditInfo_A2() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015523");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280901");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２８年　９月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "９９年確定年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08008", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), null, "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), null, "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(30)
    public void testEditInfo_A3() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015534");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２８年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "９９年確定年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133575829", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(40)
    public void testEditInfo_A4() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015545");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２８年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "９９年確定年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133575829", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(50)
    public void testEditInfo_A5() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015556");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２７年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "９９年確定年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133575829", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(60)
    public void testEditInfo_A6() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015567");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20190831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "９９年確定年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2020年10月 1日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), "2021年10月 1日", "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), "2022年10月 1日", "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), "2023年10月 1日", "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), "2024年10月 1日", "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), "2025年10月 1日", "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), "2026年10月 1日", "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), "2027年10月 1日", "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), "2028年 8月31日", "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "103300000", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), "106708900", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), "110230294", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), "113867894", "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), "117625535", "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), "121507178", "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), "125516915", "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), "129658974", "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), "133575829", "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(70)
    public void testEditInfo_A7() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015578");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20180801");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１８年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１８年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "９９年確定年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2019年10月 1日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), "2020年10月 1日", "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), "2021年10月 1日", "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), "2022年10月 1日", "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), "2023年10月 1日", "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), "2024年10月 1日", "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), "2025年10月 1日", "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), "2026年10月 1日", "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), "2028年 8月31日", "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "103300000", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), "106708900", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), "110230294", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), "113867894", "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), "117625535", "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), "121507178", "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), "125516915", "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), "129658974", "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), "137983832", "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(80)
    public void testEditInfo_A8() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015589");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20200831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２０年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "年金総額保証付終身年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2021年10月 1日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), "2022年10月 1日", "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), "2023年10月 1日", "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), "2024年10月 1日", "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), "2025年10月 1日", "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), "2026年10月 1日", "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), "2027年10月 1日", "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), "2028年 8月31日", "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "106708900", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), "110230294", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), "113867894", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), "117625535", "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), "121507178", "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), "125516915", "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), "129658974", "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), "133575829", "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(90)
    public void testEditInfo_A9() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015590");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２７年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "年金総額保証付終身年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133575829", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(100)
    public void testEditInfo_A10() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015604");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２７年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "年金総額保証付終身年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133575829", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(110)
    public void testEditInfo_A11() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015615");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２７年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "年金総額保証付終身年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133575829", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(120)
    public void testEditInfo_A12() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015626");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２７年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "年金総額保証付終身年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133575829", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(130)
    public void testEditInfo_A13() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015637");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270830");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２７年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "年金総額保証付終身年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133575829", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(140)
    public void testEditInfo_A14() {
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015659");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270901");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        C_ErrorKbn errkbn = editKykNaiyouOsirase5.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");
    }

    @Test
    @TestOrder(150)
    public void testEditInfo_A15() {
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015659");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270901");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        String className = "";

        try {
            editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        } catch (Exception e) {
            className = e.getMessage();
        }
        exStringEquals(className, "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");
    }

    @Test
    @TestOrder(160)
    public void testEditInfo_A16() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015660");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280830");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２８年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年　８月３０日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "確定年金（第１回年金倍額型）", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133937721", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(170)
    public void testEditInfo_A17() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015660");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270830");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２７年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年　８月３０日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "確定年金（第１回年金倍額型）", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月30日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), "2028年 8月31日", "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133937721", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), "133937721", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(180)
    public void testEditInfo_A18() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015660");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２７年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年　８月３０日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "確定年金（第１回年金倍額型）", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "133937721", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(190)
    public void testEditInfo_A19() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015671");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280229");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２８年　２月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０２０年　２月２９日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "確定年金（第１回年金倍額型）", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "131780983", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(200)
    public void testEditInfo_A20() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015671");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280301");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２８年　３月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０２０年　２月２９日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "確定年金（第１回年金倍額型）", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), null, "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "131780983", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), null, "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(210)
    public void testEditInfo_A21() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015671");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270228");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２７年　２月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０２０年　２月２９日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "確定年金（第１回年金倍額型）", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 2月29日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), "2028年 8月31日", "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "129658974", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), "131780983", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(220)
    public void testEditInfo_A22() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015671");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270301");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２７年　３月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０２０年　２月２９日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "確定年金（第１回年金倍額型）", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2028年 2月29日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), "2028年 8月31日", "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), null, "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), null, "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), null, "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), null, "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), null, "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), null, "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "129658974", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), "131780983", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), null, "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), null, "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), null, "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), null, "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), null, "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), null, "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(230)
    public void testEditInfo_A23() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015567");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20191101");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１１月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "９９年確定年金", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2020年10月 1日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), "2021年10月 1日", "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), "2022年10月 1日", "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), "2023年10月 1日", "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), "2024年10月 1日", "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), "2025年10月 1日", "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), "2026年10月 1日", "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), "2027年10月 1日", "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), "2028年 8月31日", "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "103300000", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), "106708900", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), "110230294", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), "113867894", "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), "117625535", "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), "121507178", "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), "125516915", "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), "129658974", "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), "133575829", "（中継用）保険料積立金額（円貨）＿９");
    }

    @Test
    @TestOrder(240)
    public void testEditInfo_A24() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015682");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20200831");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        SetNenreiMockForHozen.SYORIPTN = SetNenreiMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase5.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２０年　８月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年　８月３１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynkshrstartymdstr(), "２０２８年　９月　１日", "（中継用）年金支払開始日（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynenkinstartnen(), "11", "（中継用）年金開始年齢");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtynksyuruinm(), "確定年金（第１回年金倍額型）", "（中継用）年金種類名称");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), null, "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "100000000", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "5656", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitateriritustr(), "330", "（中継用）積立利率（文字列）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix1(), "2021年 8月31日", "（中継用）契約応当日＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix2(), "2022年 8月31日", "（中継用）契約応当日＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix3(), "2023年 8月31日", "（中継用）契約応当日＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix4(), "2024年 8月31日", "（中継用）契約応当日＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix5(), "2025年 8月31日", "（中継用）契約応当日＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix6(), "2026年 8月31日", "（中継用）契約応当日＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix7(), "2027年 8月31日", "（中継用）契約応当日＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix8(), "2028年 8月31日", "（中継用）契約応当日＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykeiyakuoutoubix9(), null, "（中継用）契約応当日＿９");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx1(), "106708900", "（中継用）保険料積立金額（円貨）＿１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx2(), "110230294", "（中継用）保険料積立金額（円貨）＿２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx3(), "113867894", "（中継用）保険料積立金額（円貨）＿３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx4(), "117625535", "（中継用）保険料積立金額（円貨）＿４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx5(), "121507178", "（中継用）保険料積立金額（円貨）＿５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx6(), "125516915", "（中継用）保険料積立金額（円貨）＿６");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx7(), "129658974", "（中継用）保険料積立金額（円貨）＿７");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx8(), "133937721", "（中継用）保険料積立金額（円貨）＿８");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyptumitatekngkyenx9(), null, "（中継用）保険料積立金額（円貨）＿９");
    }
}