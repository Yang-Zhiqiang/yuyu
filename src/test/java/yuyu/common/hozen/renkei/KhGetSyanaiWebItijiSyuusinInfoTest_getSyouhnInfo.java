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
import yuyu.common.hozen.renkei.KhGetSyanaiWebKeiyakuInfo;
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
 * 社内Web用保全一時払終身情報取得のメソッド {@link KhGetSyanaiWebItijiYuusinInfo#getSyouhnInfo()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo extends AbstractTest {

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

        KeisanCommonKaiyakuMockForHozen.caller = KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo.class;
        CalcHkShrKngkMockForHozen.caller = KhGetSyanaiWebItijiSyuusinInfoTest_getSyouhnInfo.class;
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

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001216");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1from(), "20170424", "（ＩＷＳＳＮ）第１保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1to(), "20190423", "（ＩＷＳＳＮ）第１保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2from(), "20190424", "（ＩＷＳＳＮ）第２保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0.7", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYensysnhkyenhnkymd(), "20200107", "（ＩＷＳＳＮ）円建終身保険円建変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngk(), "16909.00", "（ＩＷＳＳＮ）基本保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2to(), null, "（ＩＷＳＳＮ）第２保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn3(), null, "（ＩＷＳＳＮ）第３保険期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), null, "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyen(), "0", "（ＩＷＳＳＮ）一時払保険料（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaika(), "10000.00", "（ＩＷＳＳＮ）一時払保険料（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkwra(), "0", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約目標額割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkjnkg(), "0", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensitihsykjnkg(), "0", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkkbn(), "0", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjiyensitihsykbn(), "0", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPstigihrktkkbn(), "0", "（ＩＷＳＳＮ）保険料指定外通貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnJyudkaigomeharaitkkbn(), "1", "（ＩＷＳＳＮ）重度介護前払特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "0", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "3.32", "（ＩＷＳＳＮ）照会時市場価格調整用利率");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）一時払保険料（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTumitateriritu(), "12.2", "（ＩＷＳＳＮ）積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssn10nentumitateriritu(), "0.2", "（ＩＷＳＳＮ）１０年経過後積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuuka(), "0", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuukatuksy(), " ", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "0", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "00000000", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensykjnkgtksy(), " ", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhynsysnnktkjnkgtuksy(), " ", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), " ", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgk(), "0", "（ＩＷＳＳＮ）解約控除額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgktuukasyu(), " ", "（ＩＷＳＳＮ）解約控除額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukoujyoritu(), "0", "（ＩＷＳＳＮ）解約控除率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyentuukasyu(), " ", "（ＩＷＳＳＮ）一時払保険料（円）（通貨種類）");
    }

    @Test
    @TestOrder(20)
    public void testGetSyouhnInfo_A2() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001227");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1from(), "20170424", "（ＩＷＳＳＮ）第１保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1to(), "20190423", "（ＩＷＳＳＮ）第１保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2from(), "20190424", "（ＩＷＳＳＮ）第２保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0.7", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYensysnhkyenhnkymd(), "20200107", "（ＩＷＳＳＮ）円建終身保険円建変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngk(), "1690900", "（ＩＷＳＳＮ）基本保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2to(), null, "（ＩＷＳＳＮ）第２保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn3(), null, "（ＩＷＳＳＮ）第３保険期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), null, "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyen(), "0", "（ＩＷＳＳＮ）一時払保険料（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaika(), "0", "（ＩＷＳＳＮ）一時払保険料（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkwra(), "0", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約目標額割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkjnkg(), "0", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensitihsykjnkg(), "0", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkkbn(), "0", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjiyensitihsykbn(), "1", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPstigihrktkkbn(), "0", "（ＩＷＳＳＮ）保険料指定外通貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnJyudkaigomeharaitkkbn(), "1", "（ＩＷＳＳＮ）重度介護前払特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "10000", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "3.32", "（ＩＷＳＳＮ）照会時市場価格調整用利率");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaikatuukasyu(), " ", "（ＩＷＳＳＮ）一時払保険料（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTumitateriritu(), "0", "（ＩＷＳＳＮ）積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssn10nentumitateriritu(), "0", "（ＩＷＳＳＮ）１０年経過後積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuuka(), "10000.00", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuukatuksy(), "DOLLAR", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "20200319", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensykjnkgtksy(), " ", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhynsysnnktkjnkgtuksy(), " ", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), "YEN", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgk(), "-123.00", "（ＩＷＳＳＮ）解約控除額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgktuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）解約控除額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukoujyoritu(), "2.3", "（ＩＷＳＳＮ）解約控除率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyentuukasyu(), " ", "（ＩＷＳＳＮ）一時払保険料（円）（通貨種類）");
    }

    @Test
    @TestOrder(30)
    public void testGetSyouhnInfo_A3() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001238");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1from(), "20170424", "（ＩＷＳＳＮ）第１保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1to(), "20270423", "（ＩＷＳＳＮ）第１保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2from(), "20270424", "（ＩＷＳＳＮ）第２保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0.7", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYensysnhkyenhnkymd(), "20200107", "（ＩＷＳＳＮ）円建終身保険円建変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngk(), "1690900", "（ＩＷＳＳＮ）基本保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2to(), "20320423", "（ＩＷＳＳＮ）第２保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn3(), "20320424", "（ＩＷＳＳＮ）第３保険期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), "2.1", "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyen(), "0", "（ＩＷＳＳＮ）一時払保険料（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaika(), "10000.00", "（ＩＷＳＳＮ）一時払保険料（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkwra(), "102", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約目標額割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkjnkg(), "103", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensitihsykjnkg(), "101", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkkbn(), "1", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjiyensitihsykbn(), "1", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPstigihrktkkbn(), "1", "（ＩＷＳＳＮ）保険料指定外通貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnJyudkaigomeharaitkkbn(), "0", "（ＩＷＳＳＮ）重度介護前払特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "10000", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "3.36", "（ＩＷＳＳＮ）照会時市場価格調整用利率");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）一時払保険料（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTumitateriritu(), null, "（ＩＷＳＳＮ）積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssn10nentumitateriritu(), null, "（ＩＷＳＳＮ）１０年経過後積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuuka(), "10000.00", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuukatuksy(), "DOLLAR", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "20200319", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensykjnkgtksy(), "YEN", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhynsysnnktkjnkgtuksy(), "YEN", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), "YEN", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgk(), null, "（ＩＷＳＳＮ）解約控除額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgktuukasyu(), null, "（ＩＷＳＳＮ）解約控除額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukoujyoritu(), null, "（ＩＷＳＳＮ）解約控除率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyentuukasyu(), " ", "（ＩＷＳＳＮ）一時払保険料（円）（通貨種類）");
    }

    @Test
    @TestOrder(40)
    public void testGetSyouhnInfo_A4() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn =  KhGetSyanaiWebKeiyakuInfo.exec("99806001445");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "処理結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1from(), "00000000", "（ＩＷＳＳＮ）第１保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn1to(), "00000000", "（ＩＷＳＳＮ）第１保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2from(), "00000000", "（ＩＷＳＳＮ）第２保険期間（ｆｒｏｍ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYensysnhkyenhnkymd(), "20200107", "（ＩＷＳＳＮ）円建終身保険円建変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngk(), "1690900", "（ＩＷＳＳＮ）基本保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn2to(), "00000000", "（ＩＷＳＳＮ）第２保険期間（ｔｏ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn3(), "00000000", "（ＩＷＳＳＮ）第３保険期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), "2.1", "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyen(), "0", "（ＩＷＳＳＮ）一時払保険料（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaika(), "10000.00", "（ＩＷＳＳＮ）一時払保険料（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkwra(), "102", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約目標額割合");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkjnkg(), "103", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensitihsykjnkg(), "101", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkkbn(), "1", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjiyensitihsykbn(), "1", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPstigihrktkkbn(), "1", "（ＩＷＳＳＮ）保険料指定外通貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnJyudkaigomeharaitkkbn(), "0", "（ＩＷＳＳＮ）重度介護前払特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekin(), "10000", "（ＩＷＳＳＮ）保険料積立金");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "0", "（ＩＷＳＳＮ）照会時市場価格調整用利率");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpgaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）一時払保険料（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTumitateriritu(), null, "（ＩＷＳＳＮ）積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssn10nentumitateriritu(), null, "（ＩＷＳＳＮ）１０年経過後積立利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuuka(), "10000.00", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpnykntuukatuksy(), "DOLLAR", "（ＩＷＳＳＮ）一時払保険料（入金通貨ベース）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSykaipnyknratesyutkymd(), "20200319", "（ＩＷＳＳＮ）初回Ｐ入金レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensykjnkgtksy(), "YEN", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhynsysnnktkjnkgtuksy(), "YEN", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPtumitatekintuukasyu(), "YEN", "（ＩＷＳＳＮ）保険料積立金（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgk(), null, "（ＩＷＳＳＮ）解約控除額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukjgktuukasyu(), null, "（ＩＷＳＳＮ）解約控除額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakukoujyoritu(), null, "（ＩＷＳＳＮ）解約控除率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnItijibrpyentuukasyu(), " ", "（ＩＷＳＳＮ）一時払保険料（円）（通貨種類）");
    }

}
