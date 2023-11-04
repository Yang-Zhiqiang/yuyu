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

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.haitou.CheckDShrDShr;
import yuyu.common.hozen.haitou.CheckDShrDShrMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 契約内容のお知らせ編集（共通項目）クラスのメソッド {@link EditKykNaiyouOsiraseKytKm#editInfo(IT_KykKihon,BizDate,BizDate,ZT_GaikaKokyakuTuutiTy)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsiraseKytKmTest_editInfo_uktInfoNenkin {

    @Inject
    private EditKykNaiyouOsiraseKytKm editKykNaiyouOsiraseKytKm;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約内容のお知らせ編集（共通項目）";
    private final static String sheetName = "INデータ003";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CheckDShrDShr.class).to(CheckDShrDShrMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        CheckDShrDShrMockForHozen.caller = EditKykNaiyouOsiraseKytKmTest_editInfo.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.caller = null;
        CheckDShrDShrMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditDairitenTesuuryouTblTest_exec_A2.class, fileName, sheetName);

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
    public void testEditInfo_N1() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015512");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280901");
        String syouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "05", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "03", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "02", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "06", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユ指名　二あ", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "04", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユ契名　五二き", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "11111111", "（中継用）積立配当金残高（円貨）");

    }

    @Test
    @TestOrder(20)
    public void testEditInfo_N2() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015523");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280901");
        String syouhnHanmeiKbn = "04";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "05", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "03", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "02", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "06", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユケイメイ　ニコ", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "04", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユケイメイ　ニコ", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "11111111", "（中継用）積立配当金残高（円貨）");
    }

    @Test
    @TestOrder(30)
    public void testEditInfo_N3() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015534");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280901");
        String syouhnHanmeiKbn = "05";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "05", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "03", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "02", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "06", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユケイメイ　ニア", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "04", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユケイメイ　ゴニケ", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "11111111", "（中継用）積立配当金残高（円貨）");
    }

    @Test
    @TestOrder(40)
    public void testEditInfo_N4() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015545");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280901");
        String syouhnHanmeiKbn = "06";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "05", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "03", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "02", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "06", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユ契名　二い", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "04", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユ契名　二い", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "11111111", "（中継用）積立配当金残高（円貨）");
    }

    @Test
    @TestOrder(50)
    public void testEditInfo_N5() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015556");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270901");
        String syouhnHanmeiKbn = "07";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "07", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "ユウケメイ　イチゴスゴ", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "01", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "07", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "ユウケメイ　イチゴスニ", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "03", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "02", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "06", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユ指名　二お", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "04", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "07", "（中継用）受取人区分５");
    }

    @Test
    @TestOrder(60)
    public void testEditInfo_N6() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015567");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20190901");
        String syouhnHanmeiKbn = "08";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "07", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "ユ受名　一五す五", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "01", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "07", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "ユ受名　一五す二", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "03", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "02", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "06", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユケイメイ　ニオ", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "04", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "07", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "ユケイメイ　ニオ", "（中継用）受取人名５（１８桁）");

    }

    @Test
    @TestOrder(70)
    public void testEditInfo_N7() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015578");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20180901");
        String syouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "03", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "02", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "06", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "07", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "ユ契名　二き", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "04", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユ契名　二き", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
    }

    @Test
    @TestOrder(80)
    public void testEditInfo_N8() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015589");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20200901");
        String syouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "03", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "03", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "03", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "06", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユ指名　二く", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "04", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユ契名　五二せ", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
    }

    @Test
    @TestOrder(90)
    public void testEditInfo_N9() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015590");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270901");
        String syouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "02", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "03", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "03", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "06", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユシメイ　ニケ", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "04", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユシメイ　ゴニソ", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
    }

    @Test
    @TestOrder(100)
    public void testEditInfo_N10() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015604");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270901");
        String syouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "04", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "03", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "03", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "06", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユ指名　二こ", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "04", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユ指名　五二た", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
    }

    @Test
    @TestOrder(110)
    public void testEditInfo_N11() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015615");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270901");
        String syouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "07", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "ユウケメイ　イチゴスく", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "03", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "03", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "06", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユシメイ　ニサ", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "04", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユウケメイ　イチゴスく", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
    }

    @Test
    @TestOrder(120)
    public void testEditInfo_N12() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015626");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270901");
        String syouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "07", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "ユ受名　一五す四", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "03", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "03", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "06", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユ指名　二し", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "04", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "07", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "ユ受名　一五す四", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
    }

    @Test
    @TestOrder(130)
    public void testEditInfo_N13() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015637");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20270802");
        String syouhnHanmeiKbn = "03";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "05", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "03", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "03", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "03", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "06", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "07", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "ユ指名　二す", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "04", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "06", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
    }

    @Test
    @TestOrder(160)
    public void testEditInfo_N14() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806015660");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20280901");
        String syouhnHanmeiKbn = "08";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn1(), "03", "（中継用）受取人見出し区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn1(), "03", "（中継用）受取人区分１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm118(), "", "（中継用）受取人名１（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn2(), "06", "（中継用）受取人見出し区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn2(), "06", "（中継用）受取人区分２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm218(), "", "（中継用）受取人名２（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn3(), "04", "（中継用）受取人見出し区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn3(), "06", "（中継用）受取人区分３");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm318(), "", "（中継用）受取人名３（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn4(), "", "（中継用）受取人見出し区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn4(), "", "（中継用）受取人区分４");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm418(), "", "（中継用）受取人名４（１８桁）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktmidasikbn5(), "", "（中継用）受取人見出し区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktkbn5(), "", "（中継用）受取人区分５");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyuktnm518(), "", "（中継用）受取人名５（１８桁）");
    }
}