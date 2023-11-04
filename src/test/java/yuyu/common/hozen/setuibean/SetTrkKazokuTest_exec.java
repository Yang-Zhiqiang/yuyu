package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 登録家族情報設定のメソッド{@link SetTrkKazoku#exec(KhozenCommonParam, SetTrkKazokuExecUiBeanParam)}
                                     テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetTrkKazokuTest_exec {
    private final static String dSyono1 = "60806005555";
    private final static String dSyono2 = "60806000734";
    private final static String dSyono3 = "60806001942";
    private final static String dSyono4 = "60806001540";
    private final static String dSyono5 = "60806000745";
    private final static String dSyono6 = "60806004749";
    private final static String dSyono7 = "60806004336";

    private KhozenCommonParam khozenCommonParam;
    private SetTrkKazokuExecUiBeanParamImpl setTrkKazokuExecUiBeanParamImpl;

    private final static String fileName = "UT-SP_単体テスト仕様書_登録家族情報設定";

    private final static String sheetName = "INデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(SetTrkKazokuTest_exec.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono2));
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono3));
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono4));
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono5));
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono6));
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono7));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTrkKazokuExecUiBeanParamImpl = SWAKInjector.getInstance(SetTrkKazokuExecUiBeanParamImpl.class);

        setTrkKazokuExecUiBeanParamImpl.setSyono(dSyono1);

        boolean syorikeka = SetTrkKazoku.exec(khozenCommonParam, setTrkKazokuExecUiBeanParamImpl);

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn1(), "", "（登録家族情報）登録家族氏名（カナ）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj1(), "", "（登録家族情報）登録家族氏名（漢字）１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn1(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分１");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd1(), null, "（登録家族情報）登録家族生年月日１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei1(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk1(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno1(), "", "（登録家族情報）登録家族郵便番号１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj1(), "", "（登録家族情報）登録家族住所１（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj1(), "", "（登録家族情報）登録家族住所２（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj1(), "", "（登録家族情報）登録家族住所３（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno1(), "", "（登録家族情報）登録家族電話番号１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn1(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分１");

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn2(), "", "（登録家族情報）登録家族氏名（カナ）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj2(), "", "（登録家族情報）登録家族氏名（漢字）２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn2(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分２");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd2(), null, "（登録家族情報）登録家族生年月日２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei2(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk2(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno2(), "", "（登録家族情報）登録家族郵便番号２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj2(), "", "（登録家族情報）登録家族住所１（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj2(), "", "（登録家族情報）登録家族住所２（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj2(), "", "（登録家族情報）登録家族住所３（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno2(), "", "（登録家族情報）登録家族電話番号２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn2(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分２");

        exBooleanEquals(syorikeka, true, "処理結果");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTrkKazokuExecUiBeanParamImpl = SWAKInjector.getInstance(SetTrkKazokuExecUiBeanParamImpl.class);

        setTrkKazokuExecUiBeanParamImpl.setSyono(dSyono2);

        boolean syorikeka = SetTrkKazoku.exec(khozenCommonParam, setTrkKazokuExecUiBeanParamImpl);

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn1(), "", "（登録家族情報）登録家族氏名（カナ）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj1(), "", "（登録家族情報）登録家族氏名（漢字）１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn1(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分１");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd1(), null, "（登録家族情報）登録家族生年月日１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei1(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk1(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno1(), "", "（登録家族情報）登録家族郵便番号１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj1(), "", "（登録家族情報）登録家族住所１（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj1(), "", "（登録家族情報）登録家族住所２（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj1(), "", "（登録家族情報）登録家族住所３（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno1(), "", "（登録家族情報）登録家族電話番号１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn1(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分１");

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn2(), "", "（登録家族情報）登録家族氏名（カナ）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj2(), "", "（登録家族情報）登録家族氏名（漢字）２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn2(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分２");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd2(), null, "（登録家族情報）登録家族生年月日２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei2(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk2(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno2(), "", "（登録家族情報）登録家族郵便番号２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj2(), "", "（登録家族情報）登録家族住所１（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj2(), "", "（登録家族情報）登録家族住所２（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj2(), "", "（登録家族情報）登録家族住所３（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno2(), "", "（登録家族情報）登録家族電話番号２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn2(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分２");

        exBooleanEquals(syorikeka, true, "処理結果");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTrkKazokuExecUiBeanParamImpl = SWAKInjector.getInstance(SetTrkKazokuExecUiBeanParamImpl.class);

        setTrkKazokuExecUiBeanParamImpl.setSyono(dSyono3);

        boolean syorikeka = SetTrkKazoku.exec(khozenCommonParam, setTrkKazokuExecUiBeanParamImpl);

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn1(), "カナシメイ１", "（登録家族情報）登録家族氏名（カナ）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj1(), "漢字氏名１", "（登録家族情報）登録家族氏名（漢字）１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn1(), C_KjkhukaKbn.KJKHUKA, "（登録家族情報）登録家族漢字化不可区分１");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd1(), BizDate.valueOf("19801229"), "（登録家族情報）登録家族生年月日１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei1(), C_Seibetu.MALE, "（登録家族情報）登録家族性別１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk1(), C_Tdk.KYDSM, "（登録家族情報）登録家族続柄１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno1(), "1234567", "（登録家族情報）登録家族郵便番号１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj1(), "住所１漢字１", "（登録家族情報）登録家族住所１（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj1(), "住所２漢字１", "（登録家族情報）登録家族住所２（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj1(), "住所３漢字１", "（登録家族情報）登録家族住所３（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno1(), "011-0123-4567", "（登録家族情報）登録家族電話番号１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn1(), C_UmuKbn.ARI, "（登録家族情報）登録家族情報有無区分１");

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn2(), "", "（登録家族情報）登録家族氏名（カナ）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj2(), "", "（登録家族情報）登録家族氏名（漢字）２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn2(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分２");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd2(), null, "（登録家族情報）登録家族生年月日２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei2(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk2(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno2(), "", "（登録家族情報）登録家族郵便番号２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj2(), "", "（登録家族情報）登録家族住所１（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj2(), "", "（登録家族情報）登録家族住所２（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj2(), "", "（登録家族情報）登録家族住所３（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno2(), "", "（登録家族情報）登録家族電話番号２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn2(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分２");

        exBooleanEquals(syorikeka, true, "処理結果");
    }


    @Test
    @TestOrder(40)
    public void testExec_A4() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTrkKazokuExecUiBeanParamImpl = SWAKInjector.getInstance(SetTrkKazokuExecUiBeanParamImpl.class);

        setTrkKazokuExecUiBeanParamImpl.setSyono(dSyono4);

        boolean syorikeka = SetTrkKazoku.exec(khozenCommonParam, setTrkKazokuExecUiBeanParamImpl);

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn1(), "", "（登録家族情報）登録家族氏名（カナ）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj1(), "", "（登録家族情報）登録家族氏名（漢字）１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn1(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分１");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd1(), null, "（登録家族情報）登録家族生年月日１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei1(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk1(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno1(), "", "（登録家族情報）登録家族郵便番号１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj1(), "", "（登録家族情報）登録家族住所１（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj1(), "", "（登録家族情報）登録家族住所２（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj1(), "", "（登録家族情報）登録家族住所３（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno1(), "", "（登録家族情報）登録家族電話番号１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn1(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分１");

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn2(), "カナシメイ２", "（登録家族情報）登録家族氏名（カナ）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj2(), "漢字氏名２", "（登録家族情報）登録家族氏名（漢字）２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn2(), C_KjkhukaKbn.KJKHUKA, "（登録家族情報）登録家族漢字化不可区分２");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd2(), BizDate.valueOf("19750925"), "（登録家族情報）登録家族生年月日２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei2(), C_Seibetu.FEMALE, "（登録家族情報）登録家族性別２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk2(), C_Tdk.SHB, "（登録家族情報）登録家族続柄２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno2(), "7654321", "（登録家族情報）登録家族郵便番号２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj2(), "住所１漢字２", "（登録家族情報）登録家族住所１（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj2(), "住所２漢字２", "（登録家族情報）登録家族住所２（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj2(), "住所３漢字２", "（登録家族情報）登録家族住所３（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno2(), "022-0123-4567", "（登録家族情報）登録家族電話番号２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn2(), C_UmuKbn.ARI, "（登録家族情報）登録家族情報有無区分２");

        exBooleanEquals(syorikeka, true, "処理結果");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTrkKazokuExecUiBeanParamImpl = SWAKInjector.getInstance(SetTrkKazokuExecUiBeanParamImpl.class);

        setTrkKazokuExecUiBeanParamImpl.setSyono(dSyono5);

        boolean syorikeka = SetTrkKazoku.exec(khozenCommonParam, setTrkKazokuExecUiBeanParamImpl);

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn1(), "カナシメイ１", "（登録家族情報）登録家族氏名（カナ）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj1(), "漢字氏名１", "（登録家族情報）登録家族氏名（漢字）１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn1(), C_KjkhukaKbn.KJKHUKA, "（登録家族情報）登録家族漢字化不可区分１");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd1(), BizDate.valueOf("19801229"), "（登録家族情報）登録家族生年月日１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei1(), C_Seibetu.MALE, "（登録家族情報）登録家族性別１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk1(), C_Tdk.KYDSM, "（登録家族情報）登録家族続柄１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno1(), "1234567", "（登録家族情報）登録家族郵便番号１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj1(), "住所１漢字１", "（登録家族情報）登録家族住所１（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj1(), "住所２漢字１", "（登録家族情報）登録家族住所２（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj1(), "住所３漢字１", "（登録家族情報）登録家族住所３（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno1(), "011-0123-4567", "（登録家族情報）登録家族電話番号１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn1(), C_UmuKbn.ARI, "（登録家族情報）登録家族情報有無区分１");

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn2(), "", "（登録家族情報）登録家族氏名（カナ）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj2(), "", "（登録家族情報）登録家族氏名（漢字）２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn2(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分２");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd2(), null, "（登録家族情報）登録家族生年月日２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei2(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk2(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno2(), "", "（登録家族情報）登録家族郵便番号２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj2(), "", "（登録家族情報）登録家族住所１（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj2(), "", "（登録家族情報）登録家族住所２（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj2(), "", "（登録家族情報）登録家族住所３（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno2(), "", "（登録家族情報）登録家族電話番号２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn2(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分２");

        exBooleanEquals(syorikeka, true, "処理結果");
    }


    @Test
    @TestOrder(60)
    public void testExec_A6() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTrkKazokuExecUiBeanParamImpl = SWAKInjector.getInstance(SetTrkKazokuExecUiBeanParamImpl.class);

        setTrkKazokuExecUiBeanParamImpl.setSyono(dSyono6);

        boolean syorikeka = SetTrkKazoku.exec(khozenCommonParam, setTrkKazokuExecUiBeanParamImpl);

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn1(), "", "（登録家族情報）登録家族氏名（カナ）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj1(), "", "（登録家族情報）登録家族氏名（漢字）１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn1(), C_KjkhukaKbn.BLNK, "（登録家族情報）登録家族漢字化不可区分１");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd1(), null, "（登録家族情報）登録家族生年月日１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei1(), C_Seibetu.BLNK, "（登録家族情報）登録家族性別１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk1(), C_Tdk.BLNK, "（登録家族情報）登録家族続柄１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno1(), "", "（登録家族情報）登録家族郵便番号１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj1(), "", "（登録家族情報）登録家族住所１（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj1(), "", "（登録家族情報）登録家族住所２（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj1(), "", "（登録家族情報）登録家族住所３（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno1(), "", "（登録家族情報）登録家族電話番号１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn1(), C_UmuKbn.NONE, "（登録家族情報）登録家族情報有無区分１");

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn2(), "カナシメイ２", "（登録家族情報）登録家族氏名（カナ）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj2(), "漢字氏名２", "（登録家族情報）登録家族氏名（漢字）２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn2(), C_KjkhukaKbn.KJKHUKA, "（登録家族情報）登録家族漢字化不可区分２");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd2(), BizDate.valueOf("19750925"), "（登録家族情報）登録家族生年月日２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei2(), C_Seibetu.FEMALE, "（登録家族情報）登録家族性別２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk2(), C_Tdk.SHB, "（登録家族情報）登録家族続柄２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno2(), "7654321", "（登録家族情報）登録家族郵便番号２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj2(), "住所１漢字２", "（登録家族情報）登録家族住所１（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj2(), "住所２漢字２", "（登録家族情報）登録家族住所２（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj2(), "住所３漢字２", "（登録家族情報）登録家族住所３（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno2(), "022-0123-4567", "（登録家族情報）登録家族電話番号２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn2(), C_UmuKbn.ARI, "（登録家族情報）登録家族情報有無区分２");

        exBooleanEquals(syorikeka, true, "処理結果");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setTrkKazokuExecUiBeanParamImpl = SWAKInjector.getInstance(SetTrkKazokuExecUiBeanParamImpl.class);

        setTrkKazokuExecUiBeanParamImpl.setSyono(dSyono7);

        boolean syorikeka = SetTrkKazoku.exec(khozenCommonParam, setTrkKazokuExecUiBeanParamImpl);

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn1(), "カナシメイ１", "（登録家族情報）登録家族氏名（カナ）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj1(), "漢字氏名１", "（登録家族情報）登録家族氏名（漢字）１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn1(), C_KjkhukaKbn.KJKHUKA, "（登録家族情報）登録家族漢字化不可区分１");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd1(), BizDate.valueOf("19801229"), "（登録家族情報）登録家族生年月日１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei1(), C_Seibetu.MALE, "（登録家族情報）登録家族性別１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk1(), C_Tdk.KYDSM, "（登録家族情報）登録家族続柄１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno1(), "1234567", "（登録家族情報）登録家族郵便番号１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj1(), "住所１漢字１", "（登録家族情報）登録家族住所１（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj1(), "住所２漢字１", "（登録家族情報）登録家族住所２（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj1(), "住所３漢字１", "（登録家族情報）登録家族住所３（漢字）１");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno1(), "011-0123-4567", "（登録家族情報）登録家族電話番号１");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn1(), C_UmuKbn.ARI, "（登録家族情報）登録家族情報有無区分１");

        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkn2(), "カナシメイ２", "（登録家族情報）登録家族氏名（カナ）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkj2(), "漢字氏名２", "（登録家族情報）登録家族氏名（漢字）２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzknmkjkhukakbn2(), C_KjkhukaKbn.KJKHUKA, "（登録家族情報）登録家族漢字化不可区分２");
        exDateEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkseiymd2(), BizDate.valueOf("19750925"), "（登録家族情報）登録家族生年月日２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzksei2(), C_Seibetu.FEMALE, "（登録家族情報）登録家族性別２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktdk2(), C_Tdk.SHB, "（登録家族情報）登録家族続柄２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkyno2(), "7654321", "（登録家族情報）登録家族郵便番号２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr1kj2(), "住所１漢字２", "（登録家族情報）登録家族住所１（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr2kj2(), "住所２漢字２", "（登録家族情報）登録家族住所２（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkadr3kj2(), "住所３漢字２", "（登録家族情報）登録家族住所３（漢字）２");
        exStringEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzktelno2(), "022-0123-4567", "（登録家族情報）登録家族電話番号２");
        exClassificationEquals(setTrkKazokuExecUiBeanParamImpl.getVtrkkzktrkkzkumukbn2(), C_UmuKbn.ARI, "（登録家族情報）登録家族情報有無区分２");

        exBooleanEquals(syorikeka, true, "処理結果");
    }
}
