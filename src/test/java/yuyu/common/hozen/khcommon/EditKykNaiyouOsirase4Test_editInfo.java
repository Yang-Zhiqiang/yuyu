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

import com.google.inject.AbstractModule;

/**
 * 契約内容のお知らせ編集４クラスのメソッド {@link EditKykNaiyouOsirase4#editInfo(IT_KykKihon,BizDate,BizDate,ZT_GaikaKokyakuTuutiTy)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsirase4Test_editInfo {

    @Inject
    private EditKykNaiyouOsirase4 editKykNaiyouOsirase4;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_契約内容のお知らせ編集４";
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

        CalcHkShrKngkMockForHozen.caller = EditKykNaiyouOsirase4Test_editInfo.class;
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

            testDataAndTblMap = testDataMaker.getInData(EditKykNaiyouOsirase4Test_editInfo.class, fileName, sheetName);

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
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001412");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 0), "99806001412", "証券番号");

        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 1), BizDate.valueOf(20191001), "計算基準日");

        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 2), C_SiinKbn.SP, "死因区分");

        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 3), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");

        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 4), C_Sdpd.PD, "Ｓ建Ｐ建区分");

        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class,
            "execByKeisanWExt", 0, 5), C_Hrkkeiro.BLNK, "払込経路");

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyaisatumsgcd1(), "03005", "（中継用）挨拶文メッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "1", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０２２年　４月２４日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "949632", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08005", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "08009", "（中継用）お知らせメッセージコード３");

    }

    @Test
    @TestOrder(20)
    public void testEditInfo_A2() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001423");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "1", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０２２年　４月２４日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "949632", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08006", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "08009", "（中継用）お知らせメッセージコード３");

    }

    @Test
    @TestOrder(30)
    public void testEditInfo_A3() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001434");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "1", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０２２年　４月２４日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "949632", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08009", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");

    }

    @Test
    @TestOrder(40)
    public void testEditInfo_A4() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001445");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "1", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０２２年　４月２４日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "949632", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08009", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }

    @Test
    @TestOrder(50)
    public void testEditInfo_A5() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001456");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "1", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０２２年　４月２４日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "705942", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08009", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }

    @Test
    @TestOrder(60)
    public void testEditInfo_A6() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001467");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "1", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０２２年　４月２４日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "705942", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08009", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }

    @Test
    @TestOrder(70)
    public void testEditInfo_A7() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001478");
        BizDate syoriYmd = BizDate.valueOf("20220423");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "1", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "２０２２年　４月２４日", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "705942", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "08012", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "08009", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }

    @Test
    @TestOrder(80)
    public void testEditInfo_A8() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001489");
        BizDate syoriYmd = BizDate.valueOf("20220424");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "0", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "0", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }

    @Test
    @TestOrder(90)
    public void testEditInfo_A9() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001490");
        BizDate syoriYmd = BizDate.valueOf("20220424");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "0", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "0", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }

    @Test
    @TestOrder(100)
    public void testEditInfo_A10() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001504");
        BizDate syoriYmd = BizDate.valueOf("20220424");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "0", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "0", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }

    @Test
    @TestOrder(110)
    public void testEditInfo_A11() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001515");
        BizDate syoriYmd = BizDate.valueOf("20220424");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "0", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "0", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }

    @Test
    @TestOrder(120)
    public void testEditInfo_A12() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001526");
        BizDate syoriYmd = BizDate.valueOf("20220424");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "0", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "0", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }

    @Test
    @TestOrder(130)
    public void testEditInfo_A13() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001537");
        BizDate syoriYmd = BizDate.valueOf("20220424");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "0", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "0", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }

    @Test
    @TestOrder(140)
    public void testEditInfo_A14() {
        CoreConfig.getInstance().setProductMode(ProductMode.BATCH);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001548");
        BizDate syoriYmd = BizDate.valueOf("20220425");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        C_ErrorKbn errkbn = editKykNaiyouOsirase4.getCommonErrorKbn();

        exClassificationEquals(errkbn, C_ErrorKbn.ERROR, "エラー区分（共有）");
    }

    @Test
    @TestOrder(150)
    public void testEditInfo_A15() {
        CoreConfig.getInstance().setProductMode(ProductMode.WEB);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001559");
        BizDate syoriYmd = BizDate.valueOf("20220425");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        String message = "";

        try {
            editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        } catch (Exception e) {
            message = e.getMessage();
        }
        exStringEquals(message, "システム整合性エラーです。金額チェックエラーです。システム管理者にお問い合わせください。", "メッセージ内容");
    }

    @Test
    @TestOrder(160)
    public void testEditInfo_A16() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806001559");
        BizDate syoriYmd = BizDate.valueOf("20220425");
        BizDate kykoutoubi = BizDate.valueOf("20191001");
        ZT_GaikaKokyakuTuutiTy gaikaKokyakuTuutiTy = new ZT_GaikaKokyakuTuutiTy();

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        ZT_GaikaKokyakuTuutiTy newGaikaKokyakuTuutiTy = editKykNaiyouOsirase4.editInfo(kykKihon, syoriYmd, kykoutoubi, gaikaKokyakuTuutiTy);

        exStringEquals(newGaikaKokyakuTuutiTy.getZtysyoruicd(), "KK306", "（中継用）書類コード");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyhrknkanssiryodouhuukbn(), "0", "（中継用）返戻金請求勧奨資料同封区分");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasetuutisakuseiymwa(), "２０１９年１０月", "（中継用）お知らせ通知作成年月（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtydai2hknkknfromwa(), "", "（中継用）第２保険期間自（和暦）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkymd(), "２０１９年１０月　１日", "（中継用）円建変更日");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtysbhknkngkyen(), "107310", "（中継用）死亡保険金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtykaiyakuhrkngakyen(), "3333", "（中継用）解約返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyyendthnkhrkngakyen(), "0", "（中継用）円建変更時返戻金額（円貨）");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd1(), "", "（中継用）お知らせメッセージコード１");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd2(), "", "（中継用）お知らせメッセージコード２");
        exStringEquals(newGaikaKokyakuTuutiTy.getZtyosirasemsgcd3(), "", "（中継用）お知らせメッセージコード３");
    }
}