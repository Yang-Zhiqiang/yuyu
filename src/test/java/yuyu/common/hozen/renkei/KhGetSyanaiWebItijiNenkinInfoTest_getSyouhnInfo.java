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
 * 社内Web用保全一時払年金情報取得のメソッド {@link KhGetSyanaiWebItijiNenkinInfo#getSyouhnInfo()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo extends AbstractTest {

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

        KeisanCommonKaiyakuMockForHozen.caller = KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo.class;
        CalcHkShrKngkMockForHozen.caller = KhGetSyanaiWebItijiNenkinInfoTest_getSyouhnInfo.class;
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
            hozenDomManager.delete(kykKihon.getKykUkts());
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

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001319");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "0", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnkshrstartymd(), "99991231", "（ＩＷＳＳＮ）年金支払開始日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukbn(), "3", "（ＩＷＳＳＮ）年金種類区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukj(), "確定年金（第１回年金倍額型）", "（ＩＷＳＳＮ）年金種類区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinkkn(), "12", "（ＩＷＳＳＮ）年金期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0.7", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTumitateriritu(), "100", "（ＩＷＳＳＮ）積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSetteibairitu(), "2", "（ＩＷＳＳＮ）設定倍率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjiTmttknzkrtjygn(), "300", "（ＩＷＳＳＮ）積立金増加率（上限）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYennknhkyenhnkymd(), "00000000", "（ＩＷＳＳＮ）円建年金保険円建変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSisuuwari(), "0", "（ＩＷＳＳＮ）指数割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTeirituwari(), "100", "（ＩＷＳＳＮ）定率割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkbn(), " ", "（ＩＷＳＳＮ）年金受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkj(), "　", "（ＩＷＳＳＮ）年金受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyen(), "0", "（ＩＷＳＳＮ）一時払保険料（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaika(), "10000.00", "（ＩＷＳＳＮ）一時払保険料（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPstigihrktkkbn(), "1", "（ＩＷＳＳＮ）保険料指定外通貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkkbn(), "2", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkwra(), "102", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約目標額割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkjnkg(), "103", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnWarnmongon(), "　", "（ＩＷＳＳＮ）ワーニング文言");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "10000", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "0", "（ＩＷＳＳＮ）照会時市場価格調整用利率");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）一時払保険料（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuuka(), "10000.00", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuukatuksy(), "DOLLAR", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "20200319", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhynsysnnktkjnkgtuksy(), "YEN", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgk(), "-123.00", "（ＩＷＳＳＮ）解約控除額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgktuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）解約控除額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukoujyoritu(), "2.3", "（ＩＷＳＳＮ）解約控除率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), "YEN", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyentuukasyu(), " ", "（ＩＷＳＳＮ）一時払保険料（円）（通貨種類）");
    }

    @Test
    @TestOrder(20)
    public void testGetSyouhnInfo_A2() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001320");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "0", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnkshrstartymd(), "99991231", "（ＩＷＳＳＮ）年金支払開始日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukbn(), "3", "（ＩＷＳＳＮ）年金種類区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukj(), "確定年金（第１回年金倍額型）", "（ＩＷＳＳＮ）年金種類区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinkkn(), "12", "（ＩＷＳＳＮ）年金期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0.7", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTumitateriritu(), "100", "（ＩＷＳＳＮ）積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSetteibairitu(), "2", "（ＩＷＳＳＮ）設定倍率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjiTmttknzkrtjygn(), "300", "（ＩＷＳＳＮ）積立金増加率（上限）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYennknhkyenhnkymd(), "00000000", "（ＩＷＳＳＮ）円建年金保険円建変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSisuuwari(), "100", "（ＩＷＳＳＮ）指数割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTeirituwari(), "0", "（ＩＷＳＳＮ）定率割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkbn(), "2", "（ＩＷＳＳＮ）年金受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkj(), "被保険者と同じ", "（ＩＷＳＳＮ）年金受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyen(), "0", "（ＩＷＳＳＮ）一時払保険料（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaika(), "0", "（ＩＷＳＳＮ）一時払保険料（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPstigihrktkkbn(), "1", "（ＩＷＳＳＮ）保険料指定外通貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkkbn(), "2", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkwra(), "102", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約目標額割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkjnkg(), "103", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnWarnmongon(), "　", "（ＩＷＳＳＮ）ワーニング文言");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "0", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "0", "（ＩＷＳＳＮ）照会時市場価格調整用利率");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaikatuukasyu(), " ", "（ＩＷＳＳＮ）一時払保険料（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuuka(), "0", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuukatuksy(), " ", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "0", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "00000000", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhynsysnnktkjnkgtuksy(), "YEN", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgk(), "0", "（ＩＷＳＳＮ）解約控除額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgktuukasyu(), " ", "（ＩＷＳＳＮ）解約控除額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukoujyoritu(), "0", "（ＩＷＳＳＮ）解約控除率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), " ", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyentuukasyu(), " ", "（ＩＷＳＳＮ）一時払保険料（円）（通貨種類）");
    }

    @Test
    @TestOrder(30)
    public void testGetSyouhnInfo_A3() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001331");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "0", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnkshrstartymd(), "99991231", "（ＩＷＳＳＮ）年金支払開始日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukbn(), "3", "（ＩＷＳＳＮ）年金種類区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinsyukj(), "確定年金（第１回年金倍額型）", "（ＩＷＳＳＮ）年金種類区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNksyouhnnenkinkkn(), "12", "（ＩＷＳＳＮ）年金期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0.7", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTumitateriritu(), "100", "（ＩＷＳＳＮ）積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSetteibairitu(), "2", "（ＩＷＳＳＮ）設定倍率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjiTmttknzkrtjygn(), "300", "（ＩＷＳＳＮ）積立金増加率（上限）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYennknhkyenhnkymd(), "00000000", "（ＩＷＳＳＮ）円建年金保険円建変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSisuuwari(), "0", "（ＩＷＳＳＮ）指数割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTeirituwari(), "0", "（ＩＷＳＳＮ）定率割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkbn(), "2", "（ＩＷＳＳＮ）年金受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnNenkinuktkj(), "被保険者と同じ", "（ＩＷＳＳＮ）年金受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyen(), "0", "（ＩＷＳＳＮ）一時払保険料（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaika(), "10000.00", "（ＩＷＳＳＮ）一時払保険料（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPstigihrktkkbn(), "1", "（ＩＷＳＳＮ）保険料指定外通貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkkbn(), "1", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkwra(), "102", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約目標額割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkjnkg(), "103", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnWarnmongon(), "　", "（ＩＷＳＳＮ）ワーニング文言");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "0", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "0", "（ＩＷＳＳＮ）照会時市場価格調整用利率");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）一時払保険料（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuuka(), "10000.00", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuukatuksy(), "DOLLAR", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "20200319", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhynsysnnktkjnkgtuksy(), "YEN", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgk(), "0", "（ＩＷＳＳＮ）解約控除額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgktuukasyu(), " ", "（ＩＷＳＳＮ）解約控除額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukoujyoritu(), "0", "（ＩＷＳＳＮ）解約控除率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), " ", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyentuukasyu(), " ", "（ＩＷＳＳＮ）一時払保険料（円）（通貨種類）");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnRendouritu(), null, "（ＩＷＳＳＮ）連動率");
    }

    @Test
    @TestOrder(40)
    public void testGetSyouhnInfo_A4() {
        changeSystemDate(BizDate.valueOf(20200709));

        MockObjectManager.initialize();

        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806044624");

        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjiTmttknzkrtjygn(), null, "（ＩＷＳＳＮ）積立金増加率（上限）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSetteibairitu(), null, "（ＩＷＳＳＮ）設定倍率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnRendouritu(), "13.5", "（ＩＷＳＳＮ）連動率");

    }

}
