package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 契約内容のお知らせ編集７クラスのメソッド {@link EditKykNaiyouOsirase7#editInfo(IT_KykKihon,BizDate,BizDate,ZT_GaikaKokyakuTuutiTy)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsirase7Test_editInfo {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約内容のお知らせ編集７";
    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        CalcHkShrKngkMockForHozen.caller = EditKykNaiyouOsirase7Test_editInfo.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.caller = null;
        CalcHkShrKngkMockForHozen.SYORIPTN = null;
    }


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(EditKykNaiyouOsirase7Test_editInfo.class, fileName, sheetName);

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
    @Transactional
    public void testEditInfo_A1() {
        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001010");
        BizDate syoriYmd = BizDate.valueOf("20201019");
        BizDate kykoutoubi = null;

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        EditKykNaiyouOsirase7 editKykNaiyouOsirase7 = SWAKInjector.getInstance(EditKykNaiyouOsirase7.class);
        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase7.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), null, "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), null, "（中継用）挨拶文メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), null, "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), null, "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), null, "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), null, "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), null, "（中継用）お知らせメッセージコード１");
        exClassificationEquals(editKykNaiyouOsirase7.getCommonErrorKbn(), C_ErrorKbn.ERROR, "エラー区分（共有）取得");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testEditInfo_A2() {
        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001021");
        BizDate syoriYmd = BizDate.valueOf("20201019");
        BizDate kykoutoubi = BizDate.valueOf("20201020");

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();
        try {

            EditKykNaiyouOsirase7 editKykNaiyouOsirase7 = SWAKInjector.getInstance(EditKykNaiyouOsirase7.class);
            editKykNaiyouOsirase7.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);
        }catch (Exception e) {

            exStringEquals(e.getMessage(), "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testEditInfo_A3() {
        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001032");
        BizDate syoriYmd = BizDate.valueOf("20201019");
        BizDate kykoutoubi = BizDate.valueOf("20201020");

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        EditKykNaiyouOsirase7 editKykNaiyouOsirase7 = SWAKInjector.getInstance(EditKykNaiyouOsirase7.class);
        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase7.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03005", "（中継用）挨拶文メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２０年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０２０年１０月２３日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "3690900", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "20001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exClassificationEquals(editKykNaiyouOsirase7.getCommonErrorKbn(), C_ErrorKbn.OK, "エラー区分（共有）取得");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 0), "99806001032", "証券番号");
        exDateEquals( (BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 1), BizDate.valueOf(20201020), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testEditInfo_A4() {
        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001043");
        BizDate syoriYmd = BizDate.valueOf("20201019");
        BizDate kykoutoubi = BizDate.valueOf("20200907");

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        EditKykNaiyouOsirase7 editKykNaiyouOsirase7 = SWAKInjector.getInstance(EditKykNaiyouOsirase7.class);
        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase7.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03005", "（中継用）挨拶文メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２０年　９月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０２０年　９月　８日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "4690900", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "20001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08005", "（中継用）お知らせメッセージコード１");
        exClassificationEquals(editKykNaiyouOsirase7.getCommonErrorKbn(), C_ErrorKbn.OK, "エラー区分（共有）取得");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testEditInfo_A5() {
        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001054");
        BizDate syoriYmd = BizDate.valueOf("20201019");
        BizDate kykoutoubi = BizDate.valueOf("20200907");

        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        EditKykNaiyouOsirase7 editKykNaiyouOsirase7 = SWAKInjector.getInstance(EditKykNaiyouOsirase7.class);
        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase7.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03005", "（中継用）挨拶文メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０２０年　９月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０２０年１０月２５日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykijyunkingaku(), "5690900", "（中継用）基準金額");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtytumitatekngkkyen(), "20001", "（中継用）保険料積立金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08006", "（中継用）お知らせメッセージコード１");
        exClassificationEquals(editKykNaiyouOsirase7.getCommonErrorKbn(), C_ErrorKbn.OK, "エラー区分（共有）取得");
    }
}
