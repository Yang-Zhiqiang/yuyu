package yuyu.common.hozen.renkei;

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
import yuyu.common.hozen.khcommon.CheckKaiyaku;
import yuyu.common.hozen.khcommon.CheckKaiyakuMockForHozen;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuMockForHozen;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanKijyungkMockForHozen;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.def.biz.bean.webservice.IwssnSyanaiHozenInfoOutputBean;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;


/**
 * 社内Web用保全平準払終身情報取得のメソッド {@link KhGetSyanaiWebHeijyunSyuusinInfo#getSyouhnInfo()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo extends AbstractTest {

    @Inject
    KhGetSyanaiWebKeiyakuInfo KhGetSyanaiWebKeiyakuInfo;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_社内Web用保全契約内容情報取得";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanCommonKaiyaku.class).to(KeisanCommonKaiyakuMockForHozen.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
                bind(CheckKaiyaku.class).to(CheckKaiyakuMockForHozen.class);
                bind(KeisanKijyungk.class).to(KeisanKijyungkMockForHozen.class);
            }
        });
    }
    @BeforeClass
    public static void testInit() {

        KeisanCommonKaiyakuMockForHozen.caller = KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo.class;
        CalcHkShrKngkMockForHozen.caller = KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo.class;
        CheckKaiyakuMockForHozen.caller = KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo.class;
    }
    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanCommonKaiyakuMockForHozen.caller = null;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = null;
        CalcHkShrKngkMockForHozen.caller = null;
        CalcHkShrKngkMockForHozen.SYORIPTN = null;
        CheckKaiyakuMockForHozen.caller = null;
        CheckKaiyakuMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker
                .getInData(KhGetSyanaiWebHeijyunSyuusinInfoTest_getSyouhnInfo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        List<IT_KykKihon> kykKihonList= hozenDomManager.getAllKykKihon();
        hozenDomManager.delete(hozenDomManager.getAllAnsyuKihon());
        for (IT_KykKihon kykKihon : kykKihonList) {
            hozenDomManager.delete(kykKihon.getKykSyouhns());
            hozenDomManager.delete(hozenDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(kykKihon.getSyono()));
            hozenDomManager.delete(hozenDomManager.getKhHenreikinYendtMbrsBySyono(kykKihon.getSyono()));
            hozenDomManager.delete(kykKihon.getHhknSya());
            hozenDomManager.delete(kykKihon.getKykSya());
            hozenDomManager.delete(kykKihon.getKykSonotaTkyk());
            hozenDomManager.delete(kykKihon.getKykDairitens());
            hozenDomManager.delete(kykKihon.getKhTtdkTyuui());
            hozenDomManager.delete(kykKihon.getKhTtdkRirekis());
            hozenDomManager.delete(kykKihon.getNyknJissekiRirekis());

        }
    }

    @Test
    @TestOrder(10)
    public void testGetHeijyunSyuusinInfo_A1() {
        changeSystemDate(BizDate.valueOf(20210909));

        MockObjectManager.initialize();

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806062787");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrkkkn(), "50", "（ＩＷＳＳＮ）払込期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbn(), "1", "（ＩＷＳＳＮ）主契約払込期間歳満期区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbnnm(), "歳満期", "（ＩＷＳＳＮ）主契約払込期間歳満期区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1from(), "20210709", "（ＩＷＳＳＮ）第１保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1to(), "20260708", "（ＩＷＳＳＮ）第１保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2from(), "20260709", "（ＩＷＳＳＮ）第２保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), "0.3", "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "0", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "00000000", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnJyudkaigomeharaitkkbn(), "1", "（ＩＷＳＳＮ）重度介護前払特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "0", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), " ", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankin(), "0", "（ＩＷＳＳＮ）前納精算金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankintuukasy(), " ", "（ＩＷＳＳＮ）前納精算金（通貨種類）");
    }

    @Test
    @TestOrder(20)
    public void testGetHeijyunSyuusinInfo_A2() {
        changeSystemDate(BizDate.valueOf(20210909));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806062765");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrkkkn(), "43", "（ＩＷＳＳＮ）払込期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbn(), "1", "（ＩＷＳＳＮ）主契約払込期間歳満期区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbnnm(), "歳満期", "（ＩＷＳＳＮ）主契約払込期間歳満期区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1from(), "20210709", "（ＩＷＳＳＮ）第１保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1to(), "20260708", "（ＩＷＳＳＮ）第１保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2from(), "20260709", "（ＩＷＳＳＮ）第２保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), "1", "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "99.56", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "20210709", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnJyudkaigomeharaitkkbn(), "0", "（ＩＷＳＳＮ）重度介護前払特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "0", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), " ", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankin(), "119579.88", "（ＩＷＳＳＮ）前納精算金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankintuukasy(), "DOLLAR", "（ＩＷＳＳＮ）前納精算金（通貨種類）");
    }

    @Test
    @TestOrder(30)
    public void testGetHeijyunSyuusinInfo_A3() {
        changeSystemDate(BizDate.valueOf(20210909));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN3;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806049308");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrkkkn(), "50", "（ＩＷＳＳＮ）払込期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbn(), "1", "（ＩＷＳＳＮ）主契約払込期間歳満期区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbnnm(), "歳満期", "（ＩＷＳＳＮ）主契約払込期間歳満期区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1from(), "20210709", "（ＩＷＳＳＮ）第１保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1to(), "20260708", "（ＩＷＳＳＮ）第１保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2from(), "20260709", "（ＩＷＳＳＮ）第２保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), "0.3", "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "0", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "00000000", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnJyudkaigomeharaitkkbn(), "1", "（ＩＷＳＳＮ）重度介護前払特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "0", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), " ", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankin(), "11000", "（ＩＷＳＳＮ）前納精算金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankintuukasy(), "YEN", "（ＩＷＳＳＮ）前納精算金（通貨種類）");
    }


    @Test
    @TestOrder(40)
    public void testGetHeijyunSyuusinInfo_A4() {
        changeSystemDate(BizDate.valueOf(20210909));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN3;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806049401");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrkkkn(), "43", "（ＩＷＳＳＮ）払込期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbn(), "1", "（ＩＷＳＳＮ）主契約払込期間歳満期区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbnnm(), "歳満期", "（ＩＷＳＳＮ）主契約払込期間歳満期区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1from(), "20210314", "（ＩＷＳＳＮ）第１保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1to(), "20260313", "（ＩＷＳＳＮ）第１保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2from(), "20260314", "（ＩＷＳＳＮ）第２保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), "0", "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "99.56", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "20210314", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnJyudkaigomeharaitkkbn(), "0", "（ＩＷＳＳＮ）重度介護前払特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "0", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), " ", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankin(), "11000", "（ＩＷＳＳＮ）前納精算金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankintuukasy(), "YEN", "（ＩＷＳＳＮ）前納精算金（通貨種類）");
    }
}
