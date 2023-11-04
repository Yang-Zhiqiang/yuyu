package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.configuration.ProductMode;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.haitou.CheckDShrDShr;
import yuyu.common.hozen.haitou.CheckDShrDShrMockForHozen;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 契約内容のお知らせ編集（共通項目）クラスのメソッド {@link EditKykNaiyouOsiraseKytKm#editInfo(IT_KykKihon,BizDate,BizDate,ZT_GaikaKokyakuTuutiTy)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsiraseKytKmTest_editInfo {

    @Inject
    private EditKykNaiyouOsiraseKytKm editKykNaiyouOsiraseKytKm;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約内容のお知らせ編集（共通項目）";
    private final static String sheetName = "INデータ001";

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
    public void testEditInfo_A1() {
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "01";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20190802", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono  (), "17806000013", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "06000013178", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "2", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykoktuutireportlayoutptn(), "01", "（中継用）顧客通知帳票レイアウトパターン");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytuusinsakiyuubinno(), "1110000", "（中継用）通信先郵便番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr1kj(), "通信先住所１（漢字）", "（中継用）通信先住所１（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr2kj(), "通信先住所２（漢字）", "（中継用）通信先住所２（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr3kj(), "通信先住所３（漢字）", "（中継用）通信先住所３（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsintelno(), "06-1111-1111", "（中継用）通信先電話番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinnm18(), "カナカナ１", "（中継用）通信先氏名（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm1(), "漢字法人商号テスト用", "（中継用）照会先代理店名１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm2(), "漢字法人商号テスト用ＫＢ", "（中継用）照会先代理店名２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono2(), "17806000013", "（中継用）証券番号２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisyoumeikbn(), "702", "（中継用）愛称名区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyknmkj18(), "カナカナ１", "（中継用）契約者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhhknnmkj18(), "カナカナ２", "（中継用）被保険者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykykymdwa(), "２０１８年　８月　２日", "（中継用）契約年月日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukasyuzn(), "円", "（中継用）契約通貨種類（全）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukatype(), "JPY", "（中継用）契約通貨タイプ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk1msgcd(), "04001", "（中継用）特約１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk2msgcd(), "04002", "（中継用）特約２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk3msgcd(), "04004", "（中継用）特約３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk4msgcd(), "04005", "（中継用）特約４メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk5msgcd(), "04006", "（中継用）特約５メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk6msgcd(), "04011", "（中継用）特約６メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk7msgcd(), "04007", "（中継用）特約７メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk8msgcd(), "", "（中継用）特約８メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk9msgcd(), "", "（中継用）特約９メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk10msgcd(), "", "（中継用）特約１０メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysakuseikijyunymdwa(), "２０１８年１０月　１日", "（中継用）作成基準日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "11111111", "（中継用）積立配当金残高（円貨）");

    }

    @Test
    @TestOrder(20)
    public void testEditInfo_A2() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000024");
        BizDate syoriYmd = BizDate.valueOf("20190801");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "02";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20190801", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000024", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "06000024178", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykoktuutireportlayoutptn(), "02", "（中継用）顧客通知帳票レイアウトパターン");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytuusinsakiyuubinno(), "1110000", "（中継用）通信先郵便番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr1kj(), "通信先住所１（漢字）", "（中継用）通信先住所１（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr2kj(), "通信先住所２（漢字）", "（中継用）通信先住所２（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr3kj(), "通信先住所３（漢字）", "（中継用）通信先住所３（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinnm18(), "漢字漢字１", "（中継用）通信先氏名（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm1(), "漢字法人商号テスト用", "（中継用）照会先代理店名１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm2(), "", "（中継用）照会先代理店名２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono2(), "17806000024", "（中継用）証券番号２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisyoumeikbn(), "702", "（中継用）愛称名区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyknmkj18(), "漢字漢字１", "（中継用）契約者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhhknnmkj18(), "漢字漢字２", "（中継用）被保険者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykykymdwa(), "２０１８年　８月　１日", "（中継用）契約年月日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukasyuzn(), "円", "（中継用）契約通貨種類（全）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukatype(), "JPY", "（中継用）契約通貨タイプ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk1msgcd(), "04008", "（中継用）特約１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk2msgcd(), "", "（中継用）特約２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk3msgcd(), "", "（中継用）特約３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk4msgcd(), "", "（中継用）特約４メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk5msgcd(), "", "（中継用）特約５メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk6msgcd(), "", "（中継用）特約６メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk7msgcd(), "", "（中継用）特約７メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk8msgcd(), "", "（中継用）特約８メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk9msgcd(), "", "（中継用）特約９メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk10msgcd(), "", "（中継用）特約１０メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysakuseikijyunymdwa(), "２０１８年１０月　１日", "（中継用）作成基準日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "22222222", "（中継用）積立配当金残高（円貨）");
        exStringEquals(editKykNaiyouOsiraseKytKm.getBizLogicErrorMsg(), "", "エラーメッセージ（業務）");
        exClassificationEquals(editKykNaiyouOsiraseKytKm.getBizLogicErrorKbn(), C_ErrorKbn.OK, "エラー区分（業務）");

    }

    @Test
    @TestOrder(30)
    public void testEditInfo_A3() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000035");
        BizDate syoriYmd = BizDate.valueOf("20190803");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "08";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20190803", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000035", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "06000035178", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "0", "（中継用）ＤＳ解約チラシ同封区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykoktuutireportlayoutptn(), "08", "（中継用）顧客通知帳票レイアウトパターン");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytuusinsakiyuubinno(), "1110000", "（中継用）通信先郵便番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr1kj(), "通信先住所１（漢字）", "（中継用）通信先住所１（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr2kj(), "通信先住所２（漢字）", "（中継用）通信先住所２（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr3kj(), "通信先住所３（漢字）", "（中継用）通信先住所３（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinnm18(), "漢字漢字１", "（中継用）通信先氏名（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm1(), "漢字法人商号テスト用", "（中継用）照会先代理店名１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm2(), "", "（中継用）照会先代理店名２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono2(), "17806000035", "（中継用）証券番号２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisyoumeikbn(), "702", "（中継用）愛称名区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyknmkj18(), "漢字漢字１", "（中継用）契約者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhhknnmkj18(), "漢字漢字２", "（中継用）被保険者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykykymdwa(), "２０１８年　７月３１日", "（中継用）契約年月日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukasyuzn(), "円", "（中継用）契約通貨種類（全）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukatype(), "JPY", "（中継用）契約通貨タイプ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk1msgcd(), "04011", "（中継用）特約１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk2msgcd(), "", "（中継用）特約２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk3msgcd(), "", "（中継用）特約３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk4msgcd(), "", "（中継用）特約４メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk5msgcd(), "", "（中継用）特約５メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk6msgcd(), "", "（中継用）特約６メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk7msgcd(), "", "（中継用）特約７メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk8msgcd(), "", "（中継用）特約８メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk9msgcd(), "", "（中継用）特約９メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk10msgcd(), "", "（中継用）特約１０メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysakuseikijyunymdwa(), "２０１８年１０月　１日", "（中継用）作成基準日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "33333333", "（中継用）積立配当金残高（円貨）");
    }

    @Test
    @TestOrder(40)
    public void testEditInfo_A4() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000046");
        BizDate syoriYmd = BizDate.valueOf("20190803");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "09";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20190803", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000046", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "06000046178", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "0", "（中継用）ＤＳ解約チラシ同封区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykoktuutireportlayoutptn(), "09", "（中継用）顧客通知帳票レイアウトパターン");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytuusinsakiyuubinno(), "1110000", "（中継用）通信先郵便番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr1kj(), "通信先住所１（漢字）", "（中継用）通信先住所１（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr2kj(), "通信先住所２（漢字）", "（中継用）通信先住所２（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr3kj(), "通信先住所３（漢字）", "（中継用）通信先住所３（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinnm18(), "漢字漢字１", "（中継用）通信先氏名（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm1(), "", "（中継用）照会先代理店名１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm2(), "", "（中継用）照会先代理店名２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono2(), "17806000046", "（中継用）証券番号２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisyoumeikbn(), "702", "（中継用）愛称名区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyknmkj18(), "漢字漢字１", "（中継用）契約者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhhknnmkj18(), "漢字漢字２", "（中継用）被保険者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykykymdwa(), "２０１８年　７月３１日", "（中継用）契約年月日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukasyuzn(), "米ドル", "（中継用）契約通貨種類（全）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukatype(), "USD", "（中継用）契約通貨タイプ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk1msgcd(), "04012", "（中継用）特約１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk2msgcd(), "", "（中継用）特約２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk3msgcd(), "", "（中継用）特約３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk4msgcd(), "", "（中継用）特約４メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk5msgcd(), "", "（中継用）特約５メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk6msgcd(), "", "（中継用）特約６メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk7msgcd(), "", "（中継用）特約７メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk8msgcd(), "", "（中継用）特約８メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk9msgcd(), "", "（中継用）特約９メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk10msgcd(), "", "（中継用）特約１０メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysakuseikijyunymdwa(), "２０１８年１０月　１日", "（中継用）作成基準日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykzktrkjk(), "", "（中継用）家族登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytrkkzknm118(), "", "（中継用）登録家族名１（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytrkkzknm218(), "", "（中継用）登録家族名２（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "0", "（中継用）積立配当金残高（円貨）");
    }
    @Test
    @TestOrder(50)
    public void testEditInfo_A5() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000057");
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "07";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20190802", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000057", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "06000057178", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "2", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "0", "（中継用）ＤＳ解約チラシ同封区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykoktuutireportlayoutptn(), "07", "（中継用）顧客通知帳票レイアウトパターン");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytuusinsakiyuubinno(), "1110000", "（中継用）通信先郵便番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr1kj(), "通信先住所１（漢字）", "（中継用）通信先住所１（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr2kj(), "通信先住所２（漢字）", "（中継用）通信先住所２（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr3kj(), "通信先住所３（漢字）", "（中継用）通信先住所３（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinnm18(), "カナカナ１", "（中継用）通信先氏名（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm1(), "漢字法人商号テスト用", "（中継用）照会先代理店名１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm2(), "漢字法人商号テスト用ＫＢ", "（中継用）照会先代理店名２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono2(), "17806000057", "（中継用）証券番号２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisyoumeikbn(), "702", "（中継用）愛称名区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyknmkj18(), "カナカナ１", "（中継用）契約者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhhknnmkj18(), "カナカナ２", "（中継用）被保険者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykykymdwa(), "２０１８年　７月３１日", "（中継用）契約年月日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukasyuzn(), "米ドル", "（中継用）契約通貨種類（全）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukatype(), "USD", "（中継用）契約通貨タイプ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk1msgcd(), "04009", "（中継用）特約１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk2msgcd(), "04011", "（中継用）特約２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk3msgcd(), "04010", "（中継用）特約３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk4msgcd(), "", "（中継用）特約４メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk5msgcd(), "", "（中継用）特約５メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk6msgcd(), "", "（中継用）特約６メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk7msgcd(), "", "（中継用）特約７メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk8msgcd(), "", "（中継用）特約８メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk9msgcd(), "", "（中継用）特約９メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk10msgcd(), "", "（中継用）特約１０メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysakuseikijyunymdwa(), "２０１８年１０月　１日", "（中継用）作成基準日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykzktrkjk(), "1", "（中継用）家族登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytrkkzknm118(), "ユ家名　六三うあ５７１", "（中継用）登録家族名１（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytrkkzknm218(), "ユカメイ　ロクサンウ５７２", "（中継用）登録家族名２（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "", "（中継用）積立配当金残高（円貨）");
    }
    @Test
    @TestOrder(60)
    public void testEditInfo_A6() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000068");
        BizDate syoriYmd = BizDate.valueOf("20200401");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "01";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20200401", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000068", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "06000068178", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "2", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "0", "（中継用）ＤＳ解約チラシ同封区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykoktuutireportlayoutptn(), "01", "（中継用）顧客通知帳票レイアウトパターン");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytuusinsakiyuubinno(), "1110000", "（中継用）通信先郵便番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr1kj(), "通信先住所１（漢字）", "（中継用）通信先住所１（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr2kj(), "通信先住所２（漢字）", "（中継用）通信先住所２（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr3kj(), "通信先住所３（漢字）", "（中継用）通信先住所３（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinnm18(), "カナカナ１", "（中継用）通信先氏名（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm1(), "漢字法人商号テスト用", "（中継用）照会先代理店名１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm2(), "漢字法人商号テスト用ＫＢ", "（中継用）照会先代理店名２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono2(), "17806000068", "（中継用）証券番号２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisyoumeikbn(), "702", "（中継用）愛称名区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyknmkj18(), "カナカナ１", "（中継用）契約者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhhknnmkj18(), "カナカナ２", "（中継用）被保険者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykykymdwa(), "２０１８年　８月　２日", "（中継用）契約年月日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukasyuzn(), "米ドル", "（中継用）契約通貨種類（全）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukatype(), "USD", "（中継用）契約通貨タイプ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk1msgcd(), "04012", "（中継用）特約１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk2msgcd(), "", "（中継用）特約２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk3msgcd(), "", "（中継用）特約３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk4msgcd(), "", "（中継用）特約４メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk5msgcd(), "", "（中継用）特約５メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk6msgcd(), "", "（中継用）特約６メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk7msgcd(), "", "（中継用）特約７メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk8msgcd(), "", "（中継用）特約８メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk9msgcd(), "", "（中継用）特約９メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk10msgcd(), "", "（中継用）特約１０メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysakuseikijyunymdwa(), "２０１８年１０月　１日", "（中継用）作成基準日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykzktrkjk(), "1", "（中継用）家族登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytrkkzknm118(), "ユカメイ　ロクサンウ６８１", "（中継用）登録家族名１（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytrkkzknm218(), "", "（中継用）登録家族名２（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "66666666", "（中継用）積立配当金残高（円貨）");
    }
    @Test
    @TestOrder(70)
    public void testEditInfo_A7() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000079");
        BizDate syoriYmd = BizDate.valueOf("20190803");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "01";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20190803", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000079", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "06000079178", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "2", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "0", "（中継用）ＤＳ解約チラシ同封区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykoktuutireportlayoutptn(), "01", "（中継用）顧客通知帳票レイアウトパターン");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytuusinsakiyuubinno(), "1110000", "（中継用）通信先郵便番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr1kj(), "通信先住所１（漢字）", "（中継用）通信先住所１（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr2kj(), "通信先住所２（漢字）", "（中継用）通信先住所２（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr3kj(), "通信先住所３（漢字）", "（中継用）通信先住所３（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinnm18(), "カナカナ１", "（中継用）通信先氏名（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm1(), "漢字法人商号テスト用", "（中継用）照会先代理店名１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm2(), "漢字法人商号テスト用ＫＢ", "（中継用）照会先代理店名２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono2(), "17806000079", "（中継用）証券番号２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisyoumeikbn(), "702", "（中継用）愛称名区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyknmkj18(), "カナカナ１", "（中継用）契約者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhhknnmkj18(), "カナカナ２", "（中継用）被保険者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykykymdwa(), "２０１８年　７月３１日", "（中継用）契約年月日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukasyuzn(), "米ドル", "（中継用）契約通貨種類（全）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukatype(), "USD", "（中継用）契約通貨タイプ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk1msgcd(), "04011", "（中継用）特約１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk2msgcd(), "04010", "（中継用）特約２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk3msgcd(), "", "（中継用）特約３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk4msgcd(), "", "（中継用）特約４メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk5msgcd(), "", "（中継用）特約５メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk6msgcd(), "", "（中継用）特約６メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk7msgcd(), "", "（中継用）特約７メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk8msgcd(), "", "（中継用）特約８メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk9msgcd(), "", "（中継用）特約９メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk10msgcd(), "", "（中継用）特約１０メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysakuseikijyunymdwa(), "２０１８年１０月　１日", "（中継用）作成基準日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykzktrkjk(), "1", "（中継用）家族登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytrkkzknm118(), "ユ家名　六三うあ７９２", "（中継用）登録家族名１（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytrkkzknm218(), "", "（中継用）登録家族名２（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "0", "（中継用）積立配当金残高（円貨）");
    }

    @Test
    @TestOrder(80)
    public void testEditInfo_A8() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "02";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20190802", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000080", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "06000080178", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "2", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "0", "（中継用）ＤＳ解約チラシ同封区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykoktuutireportlayoutptn(), "02", "（中継用）顧客通知帳票レイアウトパターン");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytuusinsakiyuubinno(), "1110000", "（中継用）通信先郵便番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr1kj(), "通信先住所１（漢字）", "（中継用）通信先住所１（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr2kj(), "通信先住所２（漢字）", "（中継用）通信先住所２（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr3kj(), "通信先住所３（漢字）", "（中継用）通信先住所３（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinnm18(), "カナカナ１", "（中継用）通信先氏名（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm1(), "漢字法人商号テスト用", "（中継用）照会先代理店名１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm2(), "漢字法人商号テスト用ＫＢ", "（中継用）照会先代理店名２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono2(), "17806000080", "（中継用）証券番号２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisyoumeikbn(), "702", "（中継用）愛称名区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyknmkj18(), "カナカナ１", "（中継用）契約者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhhknnmkj18(), "カナカナ２", "（中継用）被保険者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykykymdwa(), "２０１８年　７月３１日", "（中継用）契約年月日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukasyuzn(), "米ドル", "（中継用）契約通貨種類（全）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukatype(), "USD", "（中継用）契約通貨タイプ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk1msgcd(), "", "（中継用）特約１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk2msgcd(), "", "（中継用）特約２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk3msgcd(), "", "（中継用）特約３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk4msgcd(), "", "（中継用）特約４メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk5msgcd(), "", "（中継用）特約５メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk6msgcd(), "", "（中継用）特約６メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk7msgcd(), "", "（中継用）特約７メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk8msgcd(), "", "（中継用）特約８メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk9msgcd(), "", "（中継用）特約９メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk10msgcd(), "", "（中継用）特約１０メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysakuseikijyunymdwa(), "２０１８年１０月　１日", "（中継用）作成基準日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykzktrkjk(), "0", "（中継用）家族登録状況");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytrkkzknm118(), "", "（中継用）登録家族名１（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytrkkzknm218(), "", "（中継用）登録家族名２（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "88888888", "（中継用）積立配当金残高（円貨）");
    }

    @Test
    @TestOrder(90)
    public void testEditInfo_A9() {
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "02";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN4;

        editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        C_ErrorKbn errkbn = editKykNaiyouOsiraseKytKm.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");
    }

    @Test
    @TestOrder(100)
    public void testEditInfo_A10() {
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "02";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN2;

        editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        C_ErrorKbn errkbn = editKykNaiyouOsiraseKytKm.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");
    }

    @Test
    @TestOrder(110)
    public void testEditInfo_A11() {
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "02";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN4;

        String message = "";

        try {
            editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        } catch (Exception e) {
            message = e.getMessage();
        }
        exStringEquals(message, "システム整合性エラーです。配当支払チェックが実行できませんでした。", "メッセージ内容");

    }

    @Test
    @TestOrder(120)
    public void testEditInfo_A12() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "02";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN2;

        String message = "";

        try {
            editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        } catch (Exception e) {
            message = e.getMessage();
        }
        exStringEquals(message, "配当整合チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");

    }


    @Test(expected = BizLogicException.class)
    @TestOrder(130)
    public void testEditInfo_A13() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "02";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN3;

        try {
            editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        } catch (Exception e) {
            exStringEquals(e.getMessage(), "配当金が未反映のため、処理できません。配当金反映後に処理可能となります。", "メッセージ内容");
            throw e;
        }

    }

    @Test
    @TestOrder(140)
    public void testEditInfo_A14() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000149");
        BizDate syoriYmd = BizDate.valueOf("20190801");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "10";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN1;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 1);

        exStringEquals(gaikaKokyakuTuutiTy.getZtytyouhyouymd(), "20190801", "（中継用）帳票作成日");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono(), "17806000149", "（中継用）証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysclatosyono(), "06000149178", "（中継用）スクランブル後証券番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhassoukbn(), "1", "（中継用）発送区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtydskaiyktirasidouhuukbn(), "1", "（中継用）ＤＳ解約チラシ同封区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykoktuutireportlayoutptn(), "10", "（中継用）顧客通知帳票レイアウトパターン");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytuusinsakiyuubinno(), "1110000", "（中継用）通信先郵便番号");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr1kj(), "通信先住所１（漢字）", "（中継用）通信先住所１（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr2kj(), "通信先住所２（漢字）", "（中継用）通信先住所２（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinadr3kj(), "通信先住所３（漢字）", "（中継用）通信先住所３（漢字）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytsinnm18(), "漢字漢字１", "（中継用）通信先氏名（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm1(), "漢字法人商号テスト用", "（中継用）照会先代理店名１");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyoukaisakidrtennm2(), "", "（中継用）照会先代理店名２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysyono2(), "17806000149", "（中継用）証券番号２");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyaisyoumeikbn(), "702", "（中継用）愛称名区分");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyknmkj18(), "漢字漢字１", "（中継用）契約者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtyhhknnmkj18(), "漢字漢字２", "（中継用）被保険者名（漢字）（１８桁）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykykymdwa(), "２０１８年　８月　１日", "（中継用）契約年月日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukasyuzn(), "円", "（中継用）契約通貨種類（全）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtykyktuukatype(), "JPY", "（中継用）契約通貨タイプ");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk1msgcd(), "04008", "（中継用）特約１メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk2msgcd(), "", "（中継用）特約２メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk3msgcd(), "", "（中継用）特約３メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk4msgcd(), "", "（中継用）特約４メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk5msgcd(), "", "（中継用）特約５メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk6msgcd(), "", "（中継用）特約６メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk7msgcd(), "", "（中継用）特約７メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk8msgcd(), "", "（中継用）特約８メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk9msgcd(), "", "（中継用）特約９メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytk10msgcd(), "", "（中継用）特約１０メッセージコード");
        exStringEquals(gaikaKokyakuTuutiTy.getZtysakuseikijyunymdwa(), "２０１８年１０月　１日", "（中継用）作成基準日（和暦）");
        exStringEquals(gaikaKokyakuTuutiTy.getZtytmtthaitoukinzndkyen(), "99999999", "（中継用）積立配当金残高（円貨）");
    }

    @Test
    @TestOrder(150)
    public void testEditInfo_A15() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "02";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN3;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 2);

        exClassificationEquals(editKykNaiyouOsiraseKytKm.getBizLogicErrorKbn(), C_ErrorKbn.ERROR, "エラー区分（業務）");
        exStringEquals(editKykNaiyouOsiraseKytKm.getBizLogicErrorMsg(), MessageUtil.getMessage(MessageId.EBA1048), "エラーメッセージ（業務）");
        exBooleanEquals(gaikaKokyakuTuutiTy == null, true, "外貨建顧客通知Ｆテーブル（中）");
    }


    @Test
    @TestOrder(160)
    public void testEditInfo_A16() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000080");
        BizDate syoriYmd = BizDate.valueOf("20190802");
        BizDate kykoutoubi = BizDate.valueOf("20181001");
        String syouhnHanmeiKbn = "02";
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CheckDShrDShrMockForHozen.SYORIPTN = CheckDShrDShrMockForHozen.TESTPATTERN2;

        gaikaKokyakuTuutiTy = editKykNaiyouOsiraseKytKm.editInfo(kykKihon, syoriYmd, kykoutoubi, syouhnHanmeiKbn, gaikaKokyakuTuutiTy, 2);

        exClassificationEquals(editKykNaiyouOsiraseKytKm.getBizLogicErrorKbn(), C_ErrorKbn.ERROR, "エラー区分（業務）");
        exStringEquals(editKykNaiyouOsiraseKytKm.getBizLogicErrorMsg(), MessageUtil.getMessage(MessageId.EBS1012), "エラーメッセージ（業務）");
        exBooleanEquals(gaikaKokyakuTuutiTy == null, true, "外貨建顧客通知Ｆテーブル（中）");
    }
}
