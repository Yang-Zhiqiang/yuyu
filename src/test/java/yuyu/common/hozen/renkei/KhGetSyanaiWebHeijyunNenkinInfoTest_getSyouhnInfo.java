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
 * 社内Web用保全平準払年金情報取得のメソッド {@link KhGetSyanaiWebHeijyunNenkinInfo#getSyouhnInfo()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo extends AbstractTest {

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

        KeisanCommonKaiyakuMockForHozen.caller = KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo.class;
        CalcHkShrKngkMockForHozen.caller = KhGetSyanaiWebHeijyunNenkinInfoTest_getSyouhnInfo.class;
        CheckKaiyakuMockForHozen.caller = KhGetSyanaiWebKyoutuuInfoTest_exec.class;
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
                .getInData(KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo.class, fileName, sheetName);
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
    public void testGetSyouhnInfo_A1() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001412");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnkshrstartymd(), "99991231", "（ＩＷＳＳＮ）年金支払開始日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukbn(), "3", "（ＩＷＳＳＮ）年金種類区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukj(), "確定年金（第１回年金倍額型）", "（ＩＷＳＳＮ）年金種類区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrkkkn(), "2", "（ＩＷＳＳＮ）払込期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinkkn(), "12", "（ＩＷＳＳＮ）年金期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "1", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKjnnkpzeitekitkhukakbn(), "1", "（ＩＷＳＳＮ）個人年金保険料税制適格特約付加区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkbn(), " ", "（ＩＷＳＳＮ）年金受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkj(), "　", "（ＩＷＳＳＮ）年金受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), "3.67", "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankin(), "0", "（ＩＷＳＳＮ）前納精算金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankintuukasy(), " ", "（ＩＷＳＳＮ）前納精算金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbn(), "1", "（ＩＷＳＳＮ）主契約払込期間歳満期区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbnnm(), "歳満期", "（ＩＷＳＳＮ）主契約払込期間歳満期区分（区分名称）");
    }
    @Test
    @TestOrder(20)
    public void testGetSyouhnInfo_A2() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001423");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnkshrstartymd(), "99991231", "（ＩＷＳＳＮ）年金支払開始日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukbn(), "3", "（ＩＷＳＳＮ）年金種類区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukj(), "確定年金（第１回年金倍額型）", "（ＩＷＳＳＮ）年金種類区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrkkkn(), "2", "（ＩＷＳＳＮ）払込期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinkkn(), "12", "（ＩＷＳＳＮ）年金期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "4", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKjnnkpzeitekitkhukakbn(), "1", "（ＩＷＳＳＮ）個人年金保険料税制適格特約付加区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkbn(), "2", "（ＩＷＳＳＮ）年金受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkj(), "被保険者と同じ", "（ＩＷＳＳＮ）年金受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), "0", "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankin(), "10010", "（ＩＷＳＳＮ）前納精算金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnZennouseisankintuukasy(), "YEN", "（ＩＷＳＳＮ）前納精算金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbn(), "0", "（ＩＷＳＳＮ）主契約払込期間歳満期区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhrkkknsmnkbnnm(), "　", "（ＩＷＳＳＮ）主契約払込期間歳満期区分（区分名称）");
    }

}
