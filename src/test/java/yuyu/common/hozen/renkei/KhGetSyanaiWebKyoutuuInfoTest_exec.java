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
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.CheckKaiyaku;
import yuyu.common.hozen.khcommon.CheckKaiyakuBean;
import yuyu.common.hozen.khcommon.CheckKaiyakuMockForHozen;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyaku;
import yuyu.common.hozen.khcommon.KeisanCommonKaiyakuMockForHozen;
import yuyu.common.hozen.khcommon.KeisanKaiyakuBean;
import yuyu.common.hozen.khcommon.KeisanKijyungk;
import yuyu.common.hozen.khcommon.KeisanKijyungkMockForHozen;
import yuyu.common.hozen.renkei.KhGetSyanaiWebKeiyakuInfo;
import yuyu.common.hozen.renkei.KhGetSyanaiWebKyoutuuInfo;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.def.biz.bean.webservice.IwssnSyanaiHozenInfoOutputBean;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 *  社内Web用保全共通情報取得のメソッド {@link KhGetSyanaiWebKyoutuuInfo#exec(IwssnSyanaiHozenInfoOutputBean)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KhGetSyanaiWebKyoutuuInfoTest_exec extends AbstractTest {

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

        KeisanCommonKaiyakuMockForHozen.caller = KhGetSyanaiWebKyoutuuInfoTest_exec.class;
        CalcHkShrKngkMockForHozen.caller = KhGetSyanaiWebKyoutuuInfoTest_exec.class;
        CheckKaiyakuMockForHozen.caller = KhGetSyanaiWebKyoutuuInfoTest_exec.class;
        KeisanKijyungkMockForHozen.caller = KhGetSyanaiWebKyoutuuInfoTest_exec.class;
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
        KeisanKijyungkMockForHozen.caller = null;
        KeisanKijyungkMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker
                .getInData(KhGetSyanaiWebKyoutuuInfoTest_exec.class, fileName, sheetName);
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
    public void testExec_A1() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001113");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnAisyoumeikbn(), "702", "（ＩＷＳＳＮ）愛称名区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnAisyoumeikj(), "笑顔の約束", "（ＩＷＳＳＮ）愛称名区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuuym(), "201705", "（ＩＷＳＳＮ）募集年月");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyhenkouymd(), "20190426", "（ＩＷＳＳＮ）最終変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyhenkousyorinm(), "配当金反映", "（ＩＷＳＳＮ）最終変更処理名");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokensakuseiymd(), "20170508", "（ＩＷＳＳＮ）証券作成日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyosaihkymd(), "20190427", "（ＩＷＳＳＮ）証券再発行日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYakkanjyuryouhoukbn(), "2", "（ＩＷＳＳＮ）約款受領方法区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYakkanjyuryouhoukbnnm(), "冊子での受取り", "（ＩＷＳＳＮ）約款受領方法（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbn(), "0", "（ＩＷＳＳＮ）円貨払込額案内通知区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbnnm(), "　", "（ＩＷＳＳＮ）円貨払込額案内通知区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhnnm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）", "（ＩＷＳＳＮ）商品名");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetujiyuu(), "16", "（ＩＷＳＳＮ）消滅事由");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetujiyuukj(), "死亡無効", "（ＩＷＳＳＮ）消滅事由（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjyoutaikbn(), "7", "（ＩＷＳＳＮ）契約状態");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjyoutaikbnnm(), "一括入金中", "（ＩＷＳＳＮ）契約状態（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykymd(), "20200106", "（ＩＷＳＳＮ）契約日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSknnkaisiymd(), "20170425", "（ＩＷＳＳＮ）責任開始日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetuymd(), "20160424", "（ＩＷＳＳＮ）消滅日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn(), "99", "（ＩＷＳＳＮ）保険期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngk(), "16909.00", "（ＩＷＳＳＮ）基本保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngktuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）基本保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhknkknsmnkbn(), "1", "（ＩＷＳＳＮ）主契約保険期間歳満期区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhknkknsmnkbnnm(), "歳満期", "（ＩＷＳＳＮ）主契約保険期間歳満期区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnWarnmongon(), "　", "（ＩＷＳＳＮ）ワーニング文言");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsyanmkn(), "ﾕﾋﾒｲ ｲﾁｱ", "（ＩＷＳＳＮ）被保険者氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnmkj(), "ユ被名　一あ", "（ＩＷＳＳＮ）被保険者氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseiymd(), "19770101", "（ＩＷＳＳＮ）被保険者生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknkyknen(), "40", "（ＩＷＳＳＮ）被保険者契約時年齢");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnen(), "43", "（ＩＷＳＳＮ）被保険者現在年齢");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsei(), "1", "（ＩＷＳＳＮ）被保険者性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseikj(), "男性", "（ＩＷＳＳＮ）被保険者性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkn(), "ﾕﾋﾒｲ ｲﾁ", "（ＩＷＳＳＮ）契約者氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkj(), "ユ被名　一", "（ＩＷＳＳＮ）契約者氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyaseiymd(), "19760102", "（ＩＷＳＳＮ）契約者生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyanen(), "44", "（ＩＷＳＳＮ）契約者現在年齢 ");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyasei(), "2", "（ＩＷＳＳＮ）契約者性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykseikj(), "女性", "（ＩＷＳＳＮ）契約者性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdk(), "5", "（ＩＷＳＳＮ）契約者続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdkkj(), "祖父母", "（ＩＷＳＳＮ）契約者続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinyno(), "0100001", "（ＩＷＳＳＮ）通信先郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr1kj(), "秋田市", "（ＩＷＳＳＮ）通信先住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr2kj(), "中通", "（ＩＷＳＳＮ）通信先住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr3kj(), "中田市", "（ＩＷＳＳＮ）通信先住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsintelno(), "01-2345-6789", "（ＩＷＳＳＮ）通信先電話番号");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkbn(), " ", "（ＩＷＳＳＮ）死亡受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkj(), "　", "（ＩＷＳＳＮ）死亡受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari1(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana1(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji1(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari2(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana2(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji2(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari3(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana3(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji3(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari4(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana4(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji4(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）４");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPyenhrktkkbn(), "0", "（ＩＷＳＳＮ）保険料円貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrskntkyhkkbn(), "0", "（ＩＷＳＳＮ）被保険者代理特約付加区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrtkykhukakbn(), "1", "（ＩＷＳＳＮ）契約者代理特約付加区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknkbn(), " ", "（ＩＷＳＳＮ）被保険者代理人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknkbnnm(), "　", "（ＩＷＳＳＮ）被保険者代理人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknsmikanji(), "　", "（ＩＷＳＳＮ）被保険者代理人氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknsmikana(), " ", "（ＩＷＳＳＮ）被保険者代理人氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhkdrseiymd(), "00000000", "（ＩＷＳＳＮ）被保険者代理人生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrkbn(), " ", "（ＩＷＳＳＮ）契約者代理人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrkbnnm(), "　", "（ＩＷＳＳＮ）契約者代理人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdairinmkj(), "　", "（ＩＷＳＳＮ）契約者代理人（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdairinmkn(), " ", "（ＩＷＳＳＮ）契約者代理人（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdryno(), "0000000", "（ＩＷＳＳＮ）契約者代理人郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr1kj(), "　", "（ＩＷＳＳＮ）契約者代理人住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr2kj(), "　", "（ＩＷＳＳＮ）契約者代理人住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr3kj(), "　", "（ＩＷＳＳＮ）契約者代理人住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrseiymd(), "00000000", "（ＩＷＳＳＮ）契約者代理人生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd1(), " ", "（ＩＷＳＳＮ）代理店コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm1(), "　", "（ＩＷＳＳＮ）代理店名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd1(), " ", "（ＩＷＳＳＮ）代表募集人コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin1(), "　", "（ＩＷＳＳＮ）募集人名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd2(), " ", "（ＩＷＳＳＮ）代理店コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm2(), "　", "（ＩＷＳＳＮ）代理店名２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd2(), " ", "（ＩＷＳＳＮ）代表募集人コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin2(), "　", "（ＩＷＳＳＮ）募集人名２");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn1(), " ", "（ＩＷＳＳＮ）手続注意区分１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn2(), " ", "（ＩＷＳＳＮ）手続注意区分２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn3(), " ", "（ＩＷＳＳＮ）手続注意区分３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn4(), " ", "（ＩＷＳＳＮ）手続注意区分４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn5(), " ", "（ＩＷＳＳＮ）手続注意区分５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj1(), "　", "（ＩＷＳＳＮ）手続注意区分（区分名称）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj2(), "　", "（ＩＷＳＳＮ）手続注意区分（区分名称）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj3(), "　", "（ＩＷＳＳＮ）手続注意区分（区分名称）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj4(), "　", "（ＩＷＳＳＮ）手続注意区分（区分名称）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj5(), "　", "（ＩＷＳＳＮ）手続注意区分（区分名称）５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd1(), "00000000", "（ＩＷＳＳＮ）手続注意設定日１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd2(), "00000000", "（ＩＷＳＳＮ）手続注意設定日２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd3(), "00000000", "（ＩＷＳＳＮ）手続注意設定日３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd4(), "00000000", "（ＩＷＳＳＮ）手続注意設定日４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd5(), "00000000", "（ＩＷＳＳＮ）手続注意設定日５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo1(), "　", "（ＩＷＳＳＮ）手続注意内容１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo2(), "　", "（ＩＷＳＳＮ）手続注意内容２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo3(), "　", "（ＩＷＳＳＮ）手続注意内容３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo4(), "　", "（ＩＷＳＳＮ）手続注意内容４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo5(), "　", "（ＩＷＳＳＮ）手続注意内容５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrknhatudoujyoutai(), " ", "（ＩＷＳＳＮ）契約者代理特約発動状態");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd1(), "20170427", "（ＩＷＳＳＮ）手続履歴処理日１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou1(), "契約取消", "（ＩＷＳＳＮ）手続履歴処理内容１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd2(), "00000000", "（ＩＷＳＳＮ）手続履歴処理日２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou2(), "　", "（ＩＷＳＳＮ）手続履歴処理内容２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd3(), "00000000", "（ＩＷＳＳＮ）手続履歴処理日３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou3(), "　", "（ＩＷＳＳＮ）手続履歴処理内容３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSioriyakkansearchcd(), " ", "（ＩＷＳＳＮ）しおり約款検索コード");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka(), "USD", "（ＩＷＳＳＮ）指定通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka(), " ", "（ＩＷＳＳＮ）払込通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "0", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "0", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "00000000", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "0", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "0", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), " ", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "0", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "3.36", "（ＩＷＳＳＮ）照会時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTeirituwari(), "0", "（ＩＷＳＳＮ）定率割合");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm1kn(), " ", "（ＩＷＳＳＮ）登録家族１氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm1kj(), "　", "（ＩＷＳＳＮ）登録家族１氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1seiymd(), "00000000", "（ＩＷＳＳＮ）登録家族１生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1sei(), " ", "（ＩＷＳＳＮ）登録家族１性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1seinm(), "　", "（ＩＷＳＳＮ）登録家族１性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1tdk(), " ", "（ＩＷＳＳＮ）登録家族１続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1tdknm(), "　", "（ＩＷＳＳＮ）登録家族１続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1yno(), "0000000", "（ＩＷＳＳＮ）登録家族１郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr1kj(), "　", "（ＩＷＳＳＮ）登録家族１住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr2kj(), "　", "（ＩＷＳＳＮ）登録家族１住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr3kj(), "　", "（ＩＷＳＳＮ）登録家族１住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1telno(), " ", "（ＩＷＳＳＮ）登録家族１電話番号");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm2kn(), " ", "（ＩＷＳＳＮ）登録家族２氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm2kj(), "　", "（ＩＷＳＳＮ）登録家族２氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2seiymd(), "00000000", "（ＩＷＳＳＮ）登録家族２生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2sei(), " ", "（ＩＷＳＳＮ）登録家族２性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2seinm(), "　", "（ＩＷＳＳＮ）登録家族２性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2tdk(), " ", "（ＩＷＳＳＮ）登録家族２続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2tdknm(), "　", "（ＩＷＳＳＮ）登録家族２続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2yno(), "0000000", "（ＩＷＳＳＮ）登録家族２郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr1kj(), "　", "（ＩＷＳＳＮ）登録家族２住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr2kj(), "　", "（ＩＷＳＳＮ）登録家族２住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr3kj(), "　", "（ＩＷＳＳＮ）登録家族２住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2telno(), " ", "（ＩＷＳＳＮ）登録家族２電話番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0.7", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "0", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugktuksyu(), " ", "（ＩＷＳＳＮ）基準金額（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKzktrkserviceryumu(), "0", "（ＩＷＳＳＮ）ご家族登録サービス利用有無");

        exStringEquals((String)MockObjectManager.getArgument(CheckKaiyakuMockForHozen.class, "exec", 0), "drctservice", "機能分類");
        exStringEquals((String)MockObjectManager.getArgument(CheckKaiyakuMockForHozen.class, "exec", 1), "", "画面分類");
        CheckKaiyakuBean checkKaiyakuBean = (CheckKaiyakuBean)MockObjectManager.getArgument(CheckKaiyakuMockForHozen.class, "exec", 2);
        exDateEquals(checkKaiyakuBean.getSyoruiukeYmd(), BizDate.valueOf(20160802), "書類受付日");
        exDateEquals(checkKaiyakuBean.getSyukykYmd(), BizDate.valueOf(20200106), "主契約契約日");
        exDateEquals(checkKaiyakuBean.getYendthnkYmd(), null, "円建変更日");
        exDateEquals(checkKaiyakuBean.getSyoriYmd(), BizDate.valueOf(20200107), "処理日");
        exStringEquals(checkKaiyakuBean.getKykKihon().getSyono(), "99806001113", "証券番号");
        exStringEquals(checkKaiyakuBean.getAnsyuKihon().getSyono(), "99806001113", "証券番号");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001124");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnAisyoumeikbn(), "702", "（ＩＷＳＳＮ）愛称名区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnAisyoumeikj(), "笑顔の約束", "（ＩＷＳＳＮ）愛称名区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuuym(), "201705", "（ＩＷＳＳＮ）募集年月");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyhenkouymd(), "20190426", "（ＩＷＳＳＮ）最終変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyhenkousyorinm(), "配当金反映", "（ＩＷＳＳＮ）最終変更処理名");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokensakuseiymd(), "20170508", "（ＩＷＳＳＮ）証券作成日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyosaihkymd(), "20190427", "（ＩＷＳＳＮ）証券再発行日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYakkanjyuryouhoukbn(), "1", "（ＩＷＳＳＮ）約款受領方法区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYakkanjyuryouhoukbnnm(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳＳＮ）約款受領方法（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhnnm(), "予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）", "（ＩＷＳＳＮ）商品名");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetujiyuu(), "16", "（ＩＷＳＳＮ）消滅事由");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetujiyuukj(), "死亡無効", "（ＩＷＳＳＮ）消滅事由（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjyoutaikbn(), "9", "（ＩＷＳＳＮ）契約状態");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjyoutaikbnnm(), "一時払い", "（ＩＷＳＳＮ）契約状態（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykymd(), "20200107", "（ＩＷＳＳＮ）契約日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSknnkaisiymd(), "20170425", "（ＩＷＳＳＮ）責任開始日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetuymd(), "20160424", "（ＩＷＳＳＮ）消滅日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn(), "99", "（ＩＷＳＳＮ）保険期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngk(), "0", "（ＩＷＳＳＮ）基本保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngktuukasyu(), " ", "（ＩＷＳＳＮ）基本保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhknkknsmnkbn(), "1", "（ＩＷＳＳＮ）主契約保険期間歳満期区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhknkknsmnkbnnm(), "歳満期", "（ＩＷＳＳＮ）主契約保険期間歳満期区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnWarnmongon(), "　", "（ＩＷＳＳＮ）ワーニング文言");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsyanmkn(), "ﾕﾋﾒｲ ｲﾁｱ", "（ＩＷＳＳＮ）被保険者氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnmkj(), "ユ被名　一あ", "（ＩＷＳＳＮ）被保険者氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseiymd(), "19770101", "（ＩＷＳＳＮ）被保険者生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknkyknen(), "40", "（ＩＷＳＳＮ）被保険者契約時年齢");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnen(), "43", "（ＩＷＳＳＮ）被保険者現在年齢");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsei(), "1", "（ＩＷＳＳＮ）被保険者性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseikj(), "男性", "（ＩＷＳＳＮ）被保険者性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkn(), "ﾕﾋﾒｲ ｲﾁ", "（ＩＷＳＳＮ）契約者氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkj(), "ユ被名　一", "（ＩＷＳＳＮ）契約者氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyaseiymd(), "19760102", "（ＩＷＳＳＮ）契約者生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyanen(), "44", "（ＩＷＳＳＮ）契約者現在年齢 ");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyasei(), "2", "（ＩＷＳＳＮ）契約者性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykseikj(), "女性", "（ＩＷＳＳＮ）契約者性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdk(), "5", "（ＩＷＳＳＮ）契約者続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdkkj(), "祖父母", "（ＩＷＳＳＮ）契約者続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinyno(), "0000000", "（ＩＷＳＳＮ）通信先郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr1kj(), "秋田市", "（ＩＷＳＳＮ）通信先住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr2kj(), "中通", "（ＩＷＳＳＮ）通信先住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr3kj(), "中田市", "（ＩＷＳＳＮ）通信先住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsintelno(), " ", "（ＩＷＳＳＮ）通信先電話番号");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkbn(), "1", "（ＩＷＳＳＮ）死亡受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkj(), "契約者と同じ", "（ＩＷＳＳＮ）死亡受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari1(), "100", "（ＩＷＳＳＮ）死亡保険金分割割合１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana1(), "ﾕﾋﾒｲ ｲﾁ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji1(), "ユ被名　一", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari2(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana2(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji2(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari3(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana3(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji3(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari4(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana4(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji4(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）４");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPyenhrktkkbn(), "1", "（ＩＷＳＳＮ）保険料円貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrskntkyhkkbn(), "1", "（ＩＷＳＳＮ）被保険者代理特約付加区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrtkykhukakbn(), "1", "（ＩＷＳＳＮ）契約者代理特約付加区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknkbn(), " ", "（ＩＷＳＳＮ）被保険者代理人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknkbnnm(), "　", "（ＩＷＳＳＮ）被保険者代理人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknsmikanji(), "　", "（ＩＷＳＳＮ）被保険者代理人氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknsmikana(), " ", "（ＩＷＳＳＮ）被保険者代理人氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhkdrseiymd(), "00000000", "（ＩＷＳＳＮ）被保険者代理人生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrkbn(), "10", "（ＩＷＳＳＮ）契約者代理人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrkbnnm(), "登録家族（１人目）と同じ", "（ＩＷＳＳＮ）契約者代理人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdairinmkj(), "ユユ受名　一あ", "（ＩＷＳＳＮ）契約者代理人（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdairinmkn(), "ﾕﾕｳｹﾒｲ ｲﾁｱ", "（ＩＷＳＳＮ）契約者代理人（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdryno(), "1001001", "（ＩＷＳＳＮ）契約者代理人郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr1kj(), "住所１", "（ＩＷＳＳＮ）契約者代理人住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr2kj(), "住所２", "（ＩＷＳＳＮ）契約者代理人住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr3kj(), "住所３", "（ＩＷＳＳＮ）契約者代理人住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrseiymd(), "19450102", "（ＩＷＳＳＮ）契約者代理人生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd1(), "5100230", "（ＩＷＳＳＮ）代理店コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm1(), "漢字代理店正式名５１００２３０", "（ＩＷＳＳＮ）代理店名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd1(), "080020", "（ＩＷＳＳＮ）代表募集人コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin1(), "漢字募集人名　テスト用", "（ＩＷＳＳＮ）募集人名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd2(), "5100001", "（ＩＷＳＳＮ）代理店コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm2(), "漢字代理店正式名５１００００１", "（ＩＷＳＳＮ）代理店名２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd2(), "110000", "（ＩＷＳＳＮ）代表募集人コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin2(), "漢字募集人名　テスト用", "（ＩＷＳＳＮ）募集人名２");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn1(), "01", "（ＩＷＳＳＮ）手続注意区分１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn2(), "02", "（ＩＷＳＳＮ）手続注意区分２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn3(), "03", "（ＩＷＳＳＮ）手続注意区分３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn4(), "04", "（ＩＷＳＳＮ）手続注意区分４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn5(), "05", "（ＩＷＳＳＮ）手続注意区分５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj1(), "手続中応対注意", "（ＩＷＳＳＮ）手続注意区分（区分名称）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj2(), "契約者に関する捜査照会", "（ＩＷＳＳＮ）手続注意区分（区分名称）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj3(), "破産および倒産", "（ＩＷＳＳＮ）手続注意区分（区分名称）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj4(), "保険契約差押え", "（ＩＷＳＳＮ）手続注意区分（区分名称）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj5(), "契約者行方不明", "（ＩＷＳＳＮ）手続注意区分（区分名称）５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd1(), "20200101", "（ＩＷＳＳＮ）手続注意設定日１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd2(), "20200102", "（ＩＷＳＳＮ）手続注意設定日２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd3(), "20200103", "（ＩＷＳＳＮ）手続注意設定日３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd4(), "20200104", "（ＩＷＳＳＮ）手続注意設定日４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd5(), "20200105", "（ＩＷＳＳＮ）手続注意設定日５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo1(), "補足内容１", "（ＩＷＳＳＮ）手続注意内容１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo2(), "補足内容２", "（ＩＷＳＳＮ）手続注意内容２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo3(), "補足内容３", "（ＩＷＳＳＮ）手続注意内容３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo4(), "補足内容４", "（ＩＷＳＳＮ）手続注意内容４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo5(), "補足内容５", "（ＩＷＳＳＮ）手続注意内容５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrknhatudoujyoutai(), "2", "（ＩＷＳＳＮ）契約者代理特約発動状態");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd1(), "20170427", "（ＩＷＳＳＮ）手続履歴処理日１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou1(), "契約取消（契約取消）", "（ＩＷＳＳＮ）手続履歴処理内容１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd2(), "20170428", "（ＩＷＳＳＮ）手続履歴処理日２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou2(), "契約取消", "（ＩＷＳＳＮ）手続履歴処理内容２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd3(), "20170429", "（ＩＷＳＳＮ）手続履歴処理日３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou3(), "契約取消", "（ＩＷＳＳＮ）手続履歴処理内容３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSioriyakkansearchcd(), " ", "（ＩＷＳＳＮ）しおり約款検索コード");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka(), " ", "（ＩＷＳＳＮ）指定通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "12", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), "YEN", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka(), "USD", "（ＩＷＳＳＮ）払込通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), null, "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "0", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "00000000", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "0", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "0", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), " ", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "0", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), null, "（ＩＷＳＳＮ）照会時市場価格調整用利率");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm1kn(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳＳＮ）登録家族１氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm1kj(), "ユ受名　三二き", "（ＩＷＳＳＮ）登録家族１氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1seiymd(), "20200319", "（ＩＷＳＳＮ）登録家族１生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1sei(), "1", "（ＩＷＳＳＮ）登録家族１性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1seinm(), "男性", "（ＩＷＳＳＮ）登録家族１性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1tdk(), "2", "（ＩＷＳＳＮ）登録家族１続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1tdknm(), "配偶者", "（ＩＷＳＳＮ）登録家族１続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1yno(), "1001000", "（ＩＷＳＳＮ）登録家族１郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr1kj(), "住所１１住所１１", "（ＩＷＳＳＮ）登録家族１住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr2kj(), "住所１２住所１２", "（ＩＷＳＳＮ）登録家族１住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr3kj(), "住所１３住所１３", "（ＩＷＳＳＮ）登録家族１住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1telno(), "011-1111-1111", "（ＩＷＳＳＮ）登録家族１電話番号");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm2kn(), "ﾕｳｹﾒｲｻﾝﾆｸﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳＳＮ）登録家族２氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm2kj(), "ユ受名　三二く", "（ＩＷＳＳＮ）登録家族２氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2seiymd(), "20200320", "（ＩＷＳＳＮ）登録家族２生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2sei(), "2", "（ＩＷＳＳＮ）登録家族２性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2seinm(), "女性", "（ＩＷＳＳＮ）登録家族２性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2tdk(), "3", "（ＩＷＳＳＮ）登録家族２続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2tdknm(), "親", "（ＩＷＳＳＮ）登録家族２続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2yno(), "2002000", "（ＩＷＳＳＮ）登録家族２郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr1kj(), "住所２１住所２１", "（ＩＷＳＳＮ）登録家族２住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr2kj(), "住所２２住所２２", "（ＩＷＳＳＮ）登録家族２住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr3kj(), "住所２３住所２３", "（ＩＷＳＳＮ）登録家族２住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2telno(), "022-2222-2222", "（ＩＷＳＳＮ）登録家族２電話番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "0", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugktuksyu(), " ", "（ＩＷＳＳＮ）基準金額（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKzktrkserviceryumu(), "1", "（ＩＷＳＳＮ）ご家族登録サービス利用有無");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1tsindousiteikbn(), "1", "（ＩＷＳＳＮ）登録家族１通信先同一指定区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2tsindousiteikbn(), "0", "（ＩＷＳＳＮ）登録家族２通信先同一指定区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStknsetkbn(), "2", "（ＩＷＳＳＮ）質権設定区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStknsetkbnnm(), "設定なし", "（ＩＷＳＳＮ）質権設定区分（区分名称）");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001135");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.NORMAL, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnAisyoumeikbn(), "702", "（ＩＷＳＳＮ）愛称名区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnAisyoumeikj(), "笑顔の約束", "（ＩＷＳＳＮ）愛称名区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuuym(), "201705", "（ＩＷＳＳＮ）募集年月");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyhenkouymd(), "20190426", "（ＩＷＳＳＮ）最終変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyhenkousyorinm(), "配当金反映", "（ＩＷＳＳＮ）最終変更処理名");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokensakuseiymd(), "20170508", "（ＩＷＳＳＮ）証券作成日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyosaihkymd(), "20190427", "（ＩＷＳＳＮ）証券再発行日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYakkanjyuryouhoukbn(), "1", "（ＩＷＳＳＮ）約款受領方法区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYakkanjyuryouhoukbnnm(), "Ｗｅｂでの受取り（インターネット環境で確認）", "（ＩＷＳＳＮ）約款受領方法（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhnnm(), "５年ごと利差配当付指定通貨建個人年金保険（一時払い）　　５年確定（米ドル）", "（ＩＷＳＳＮ）商品名");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetujiyuu(), "16", "（ＩＷＳＳＮ）消滅事由");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetujiyuukj(), "死亡無効", "（ＩＷＳＳＮ）消滅事由（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjyoutaikbn(), "9", "（ＩＷＳＳＮ）契約状態");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjyoutaikbnnm(), "一時払い", "（ＩＷＳＳＮ）契約状態（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykymd(), "20200108", "（ＩＷＳＳＮ）契約日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSknnkaisiymd(), "20170425", "（ＩＷＳＳＮ）責任開始日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetuymd(), "20160424", "（ＩＷＳＳＮ）消滅日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn(), "5", "（ＩＷＳＳＮ）保険期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngk(), "1690900", "（ＩＷＳＳＮ）基本保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngktuukasyu(), "YEN", "（ＩＷＳＳＮ）基本保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhknkknsmnkbn(), "1", "（ＩＷＳＳＮ）主契約保険期間歳満期区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyuhknkknsmnkbnnm(), "歳満期", "（ＩＷＳＳＮ）主契約保険期間歳満期区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnWarnmongon(), "　", "（ＩＷＳＳＮ）ワーニング文言");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsyanmkn(), "ﾕﾋﾒｲ ｲﾁｱ", "（ＩＷＳＳＮ）被保険者氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnmkj(), "ユ被名　一あ", "（ＩＷＳＳＮ）被保険者氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseiymd(), "19770101", "（ＩＷＳＳＮ）被保険者生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknkyknen(), "40", "（ＩＷＳＳＮ）被保険者契約時年齢");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnen(), "43", "（ＩＷＳＳＮ）被保険者現在年齢");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsei(), "1", "（ＩＷＳＳＮ）被保険者性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseikj(), "男性", "（ＩＷＳＳＮ）被保険者性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkn(), "ﾕﾋﾒｲ ｲﾁ", "（ＩＷＳＳＮ）契約者氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkj(), "ユ被名　一", "（ＩＷＳＳＮ）契約者氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyaseiymd(), "19760102", "（ＩＷＳＳＮ）契約者生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyanen(), "44", "（ＩＷＳＳＮ）契約者現在年齢 ");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyasei(), "2", "（ＩＷＳＳＮ）契約者性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykseikj(), "女性", "（ＩＷＳＳＮ）契約者性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdk(), "5", "（ＩＷＳＳＮ）契約者続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdkkj(), "祖父母", "（ＩＷＳＳＮ）契約者続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinyno(), "0000000", "（ＩＷＳＳＮ）通信先郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr1kj(), "秋田市", "（ＩＷＳＳＮ）通信先住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr2kj(), "中通", "（ＩＷＳＳＮ）通信先住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr3kj(), "中田市", "（ＩＷＳＳＮ）通信先住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsintelno(), "01-2345-6789", "（ＩＷＳＳＮ）通信先電話番号");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkbn(), "2", "（ＩＷＳＳＮ）死亡受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkj(), "被保険者と同じ", "（ＩＷＳＳＮ）死亡受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari1(), "100", "（ＩＷＳＳＮ）死亡保険金分割割合１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana1(), "ﾕﾋﾒｲ ｲﾁｱ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji1(), "ユ被名　一あ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari2(), "101", "（ＩＷＳＳＮ）死亡保険金分割割合２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana2(), "ﾕｳｹﾒｲ ｲﾁ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji2(), "ユ受名　一", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari3(), "102", "（ＩＷＳＳＮ）死亡保険金分割割合３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana3(), "ﾕｳｹﾒｲ ｲｱ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji3(), "ユ受名　あ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari4(), "103", "（ＩＷＳＳＮ）死亡保険金分割割合４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana4(), "ﾕｳｹﾒｲ ﾁｱ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji4(), "ユ受　一あ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）４");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPyenhrktkkbn(), "0", "（ＩＷＳＳＮ）保険料円貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrskntkyhkkbn(), "1", "（ＩＷＳＳＮ）被保険者代理特約付加区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrtkykhukakbn(), "0", "（ＩＷＳＳＮ）契約者代理特約付加区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknkbn(), "10", "（ＩＷＳＳＮ）被保険者代理人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknkbnnm(), "登録家族（１人目）と同じ", "（ＩＷＳＳＮ）被保険者代理人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknsmikanji(), "ユ受名　一あ", "（ＩＷＳＳＮ）被保険者代理人氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknsmikana(), "ﾕｳｹﾒｲ ｲﾁｱｱ", "（ＩＷＳＳＮ）被保険者代理人氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhkdrseiymd(), "19450101", "（ＩＷＳＳＮ）被保険者代理人生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrkbn(), " ", "（ＩＷＳＳＮ）契約者代理人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrkbnnm(), "　", "（ＩＷＳＳＮ）契約者代理人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdairinmkj(), "　", "（ＩＷＳＳＮ）契約者代理人（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdairinmkn(), " ", "（ＩＷＳＳＮ）契約者代理人（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdryno(), "0000000", "（ＩＷＳＳＮ）契約者代理人郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr1kj(), "　", "（ＩＷＳＳＮ）契約者代理人住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr2kj(), "　", "（ＩＷＳＳＮ）契約者代理人住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr3kj(), "　", "（ＩＷＳＳＮ）契約者代理人住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrseiymd(), "00000000", "（ＩＷＳＳＮ）契約者代理人生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd1(), "1200009", "（ＩＷＳＳＮ）代理店コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm1(), "漢字代理店正式名１２００００９", "（ＩＷＳＳＮ）代理店名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd1(), "080020", "（ＩＷＳＳＮ）代表募集人コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin1(), "漢字募集人名　テスト用", "（ＩＷＳＳＮ）募集人名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd2(), "1200039", "（ＩＷＳＳＮ）代理店コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm2(), "漢字代理店正式名１２０００３９", "（ＩＷＳＳＮ）代理店名２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd2(), "010033", "（ＩＷＳＳＮ）代表募集人コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin2(), "漢字代表募集人名　テスト用", "（ＩＷＳＳＮ）募集人名２");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn1(), "01", "（ＩＷＳＳＮ）手続注意区分１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn2(), "02", "（ＩＷＳＳＮ）手続注意区分２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn3(), "03", "（ＩＷＳＳＮ）手続注意区分３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn4(), "04", "（ＩＷＳＳＮ）手続注意区分４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn5(), "05", "（ＩＷＳＳＮ）手続注意区分５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj1(), "手続中応対注意", "（ＩＷＳＳＮ）手続注意区分（区分名称）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj2(), "契約者に関する捜査照会", "（ＩＷＳＳＮ）手続注意区分（区分名称）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj3(), "破産および倒産", "（ＩＷＳＳＮ）手続注意区分（区分名称）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj4(), "保険契約差押え", "（ＩＷＳＳＮ）手続注意区分（区分名称）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj5(), "契約者行方不明", "（ＩＷＳＳＮ）手続注意区分（区分名称）５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd1(), "20200101", "（ＩＷＳＳＮ）手続注意設定日１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd2(), "20200102", "（ＩＷＳＳＮ）手続注意設定日２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd3(), "20200103", "（ＩＷＳＳＮ）手続注意設定日３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd4(), "20200104", "（ＩＷＳＳＮ）手続注意設定日４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd5(), "20200105", "（ＩＷＳＳＮ）手続注意設定日５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo1(), "補足内容１", "（ＩＷＳＳＮ）手続注意内容１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo2(), "補足内容２", "（ＩＷＳＳＮ）手続注意内容２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo3(), "補足内容３", "（ＩＷＳＳＮ）手続注意内容３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo4(), "補足内容４", "（ＩＷＳＳＮ）手続注意内容４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo5(), "補足内容５", "（ＩＷＳＳＮ）手続注意内容５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrknhatudoujyoutai(), "1", "（ＩＷＳＳＮ）契約者代理特約発動状態");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd1(), "20170427", "（ＩＷＳＳＮ）手続履歴処理日１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou1(), "契約取消（契約取消）", "（ＩＷＳＳＮ）手続履歴処理内容１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd2(), "20170428", "（ＩＷＳＳＮ）手続履歴処理日２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou2(), "契約取消（解除）", "（ＩＷＳＳＮ）手続履歴処理内容２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd3(), "20170429", "（ＩＷＳＳＮ）手続履歴処理日３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou3(), "契約取消（免責）", "（ＩＷＳＳＮ）手続履歴処理内容３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSioriyakkansearchcd(), " ", "（ＩＷＳＳＮ）しおり約款検索コード");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka(), "JPY", "（ＩＷＳＳＮ）指定通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka(), "USD", "（ＩＷＳＳＮ）払込通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "0", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "00000000", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "66666", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "7777", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), "YEN", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), "YEN", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "3.34", "（ＩＷＳＳＮ）照会時市場価格調整用利率");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm1kn(), "ﾕｳｹﾒｲｻﾝﾆｷﾕｳｹﾒｲｻﾝﾆ", "（ＩＷＳＳＮ）登録家族１氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm1kj(), "ユ受名　三二き", "（ＩＷＳＳＮ）登録家族１氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1seiymd(), "20200319", "（ＩＷＳＳＮ）登録家族１生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1sei(), "1", "（ＩＷＳＳＮ）登録家族１性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1seinm(), "男性", "（ＩＷＳＳＮ）登録家族１性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1tdk(), "2", "（ＩＷＳＳＮ）登録家族１続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1tdknm(), "配偶者", "（ＩＷＳＳＮ）登録家族１続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1yno(), "1001000", "（ＩＷＳＳＮ）登録家族１郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr1kj(), "住所１１住所１１", "（ＩＷＳＳＮ）登録家族１住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr2kj(), "住所１２住所１２", "（ＩＷＳＳＮ）登録家族１住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1adr3kj(), "住所１３住所１３", "（ＩＷＳＳＮ）登録家族１住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk1telno(), "011-1111-1111", "（ＩＷＳＳＮ）登録家族１電話番号");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm2kn(), " ", "（ＩＷＳＳＮ）登録家族２氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzknm2kj(), "　", "（ＩＷＳＳＮ）登録家族２氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2seiymd(), "00000000", "（ＩＷＳＳＮ）登録家族２生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2sei(), " ", "（ＩＷＳＳＮ）登録家族２性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2seinm(), "　", "（ＩＷＳＳＮ）登録家族２性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2tdk(), " ", "（ＩＷＳＳＮ）登録家族２続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2tdknm(), "　", "（ＩＷＳＳＮ）登録家族２続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2yno(), "0000000", "（ＩＷＳＳＮ）登録家族２郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr1kj(), "　", "（ＩＷＳＳＮ）登録家族２住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr2kj(), "　", "（ＩＷＳＳＮ）登録家族２住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2adr3kj(), "　", "（ＩＷＳＳＮ）登録家族２住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTrkkzk2telno(), " ", "（ＩＷＳＳＮ）登録家族２電話番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "0", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugktuksyu(), " ", "（ＩＷＳＳＮ）基準金額（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKzktrkserviceryumu(), "1", "（ＩＷＳＳＮ）ご家族登録サービス利用有無");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001146");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsyanmkn(), "ﾕﾋﾒｲ ｲﾁｱ", "（ＩＷＳＳＮ）被保険者氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnmkj(), "ユ被名　一あ", "（ＩＷＳＳＮ）被保険者氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseiymd(), "19770101", "（ＩＷＳＳＮ）被保険者生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknkyknen(), "40", "（ＩＷＳＳＮ）被保険者契約時年齢");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnen(), "43", "（ＩＷＳＳＮ）被保険者現在年齢");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsei(), "1", "（ＩＷＳＳＮ）被保険者性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseikj(), "男性", "（ＩＷＳＳＮ）被保険者性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkn(), "ﾕﾋﾒｲ ｲﾁ", "（ＩＷＳＳＮ）契約者氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkj(), "ユ被名　一", "（ＩＷＳＳＮ）契約者氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyaseiymd(), "19760102", "（ＩＷＳＳＮ）契約者生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyanen(), "44", "（ＩＷＳＳＮ）契約者現在年齢 ");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyasei(), "2", "（ＩＷＳＳＮ）契約者性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykseikj(), "女性", "（ＩＷＳＳＮ）契約者性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdk(), "5", "（ＩＷＳＳＮ）契約者続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdkkj(), "祖父母", "（ＩＷＳＳＮ）契約者続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinyno(), "0100001", "（ＩＷＳＳＮ）通信先郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr1kj(), "秋田市", "（ＩＷＳＳＮ）通信先住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr2kj(), "中通", "（ＩＷＳＳＮ）通信先住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr3kj(), "中田市", "（ＩＷＳＳＮ）通信先住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsintelno(), "01-2345-6789", "（ＩＷＳＳＮ）通信先電話番号");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkbn(), "6", "（ＩＷＳＳＮ）死亡受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkj(), "特定名義", "（ＩＷＳＳＮ）死亡受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari1(), "100", "（ＩＷＳＳＮ）死亡保険金分割割合１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana1(), "ﾕｳｹﾒｲ ｲﾁｱ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji1(), "ユ受名　一あ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari2(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana2(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji2(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari3(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana3(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji3(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari4(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana4(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji4(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）４");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnPyenhrktkkbn(), "1", "（ＩＷＳＳＮ）保険料円貨払込特約区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrskntkyhkkbn(), "0", "（ＩＷＳＳＮ）被保険者代理特約付加区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrtkykhukakbn(), "0", "（ＩＷＳＳＮ）契約者代理特約付加区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknkbn(), " ", "（ＩＷＳＳＮ）被保険者代理人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknkbnnm(), "　", "（ＩＷＳＳＮ）被保険者代理人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknsmikanji(), "　", "（ＩＷＳＳＮ）被保険者代理人氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnStdrsknsmikana(), " ", "（ＩＷＳＳＮ）被保険者代理人氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhkdrseiymd(), "00000000", "（ＩＷＳＳＮ）被保険者代理人生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrkbn(), " ", "（ＩＷＳＳＮ）契約者代理人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrkbnnm(), "　", "（ＩＷＳＳＮ）契約者代理人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdairinmkj(), "　", "（ＩＷＳＳＮ）契約者代理人（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdairinmkn(), " ", "（ＩＷＳＳＮ）契約者代理人（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdryno(), "0000000", "（ＩＷＳＳＮ）契約者代理人郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr1kj(), "　", "（ＩＷＳＳＮ）契約者代理人住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr2kj(), "　", "（ＩＷＳＳＮ）契約者代理人住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdradr3kj(), "　", "（ＩＷＳＳＮ）契約者代理人住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrseiymd(), "00000000", "（ＩＷＳＳＮ）契約者代理人生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd1(), "1200009", "（ＩＷＳＳＮ）代理店コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm1(), "漢字代理店正式名１２００００９", "（ＩＷＳＳＮ）代理店名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd1(), "080020", "（ＩＷＳＳＮ）代表募集人コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin1(), "漢字募集人名　テスト用", "（ＩＷＳＳＮ）募集人名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd2(), " ", "（ＩＷＳＳＮ）代理店コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm2(), "　", "（ＩＷＳＳＮ）代理店名２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd2(), " ", "（ＩＷＳＳＮ）代表募集人コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin2(), "　", "（ＩＷＳＳＮ）募集人名２");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn1(), "01", "（ＩＷＳＳＮ）手続注意区分１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn2(), "02", "（ＩＷＳＳＮ）手続注意区分２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn3(), "03", "（ＩＷＳＳＮ）手続注意区分３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn4(), "04", "（ＩＷＳＳＮ）手続注意区分４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbn5(), "05", "（ＩＷＳＳＮ）手続注意区分５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj1(), "手続中応対注意", "（ＩＷＳＳＮ）手続注意区分（区分名称）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj2(), "契約者に関する捜査照会", "（ＩＷＳＳＮ）手続注意区分（区分名称）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj3(), "破産および倒産", "（ＩＷＳＳＮ）手続注意区分（区分名称）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj4(), "保険契約差押え", "（ＩＷＳＳＮ）手続注意区分（区分名称）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuikbnkj5(), "契約者行方不明", "（ＩＷＳＳＮ）手続注意区分（区分名称）５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd1(), "00000000", "（ＩＷＳＳＮ）手続注意設定日１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd2(), "00000000", "（ＩＷＳＳＮ）手続注意設定日２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd3(), "00000000", "（ＩＷＳＳＮ）手続注意設定日３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd4(), "00000000", "（ＩＷＳＳＮ）手続注意設定日４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuisetymd5(), "00000000", "（ＩＷＳＳＮ）手続注意設定日５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo1(), "　", "（ＩＷＳＳＮ）手続注意内容１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo2(), "　", "（ＩＷＳＳＮ）手続注意内容２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo3(), "　", "（ＩＷＳＳＮ）手続注意内容３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo4(), "　", "（ＩＷＳＳＮ）手続注意内容４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdktyuuinaiyo5(), "　", "（ＩＷＳＳＮ）手続注意内容５");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykdrknhatudoujyoutai(), "0", "（ＩＷＳＳＮ）契約者代理特約発動状態");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd1(), "00000000", "（ＩＷＳＳＮ）手続履歴処理日１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou1(), "　", "（ＩＷＳＳＮ）手続履歴処理内容１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd2(), "00000000", "（ＩＷＳＳＮ）手続履歴処理日２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou2(), "　", "（ＩＷＳＳＮ）手続履歴処理内容２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyoriymd3(), "00000000", "（ＩＷＳＳＮ）手続履歴処理日３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTtdkrrksyorinaiyou3(), "　", "（ＩＷＳＳＮ）手続履歴処理内容３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSioriyakkansearchcd(), "12-3456-7895", "（ＩＷＳＳＮ）しおり約款検索コード");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka(), "JPY", "（ＩＷＳＳＮ）指定通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka(), "USD", "（ＩＷＳＳＮ）払込通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "0", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "00000000", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "0", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "0", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "3.36", "（ＩＷＳＳＮ）照会時市場価格調整用利率");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001157");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkbn(), "5", "（ＩＷＳＳＮ）死亡受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkj(), "相続人", "（ＩＷＳＳＮ）死亡受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari1(), "100", "（ＩＷＳＳＮ）死亡保険金分割割合１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana1(), "ｿｳｿﾞｸﾆﾝ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji1(), "相続人", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari2(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana2(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji2(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari3(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana3(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji3(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari4(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana4(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji4(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）４");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka(), "AUD", "（ＩＷＳＳＮ）指定通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka(), "USD", "（ＩＷＳＳＮ）払込通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "119.36", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "20200106", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "6666", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "7777", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "8888.00", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "9999.00", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), "YEN", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), "YEN", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "3.36", "（ＩＷＳＳＮ）照会時市場価格調整用利率");

        exStringEquals((String)MockObjectManager.getArgument(KeisanCommonKaiyakuMockForHozen.class, "keisanKaiyakuseisankin", 0), "online", "機能分類");
        IT_KykKihon kykKihon = (IT_KykKihon) MockObjectManager.getArgument( KeisanCommonKaiyakuMockForHozen.class, "keisanKaiyakuseisankin", 1);
        exStringEquals(kykKihon.getSyono(), "99806001157", "証券番号");

        exDateEquals((BizDate)MockObjectManager.getArgument(KeisanCommonKaiyakuMockForHozen.class, "keisanKaiyakuseisankin", 2), BizDate.valueOf(20200107), "処理年月日");

        KeisanKaiyakuBean keisanKaiyakuBean =  (KeisanKaiyakuBean) MockObjectManager.getArgument( KeisanCommonKaiyakuMockForHozen.class, "keisanKaiyakuseisankin", 3);
        exDateEquals(keisanKaiyakuBean.getSyoruiukeymd(), BizDate.valueOf(20200107), "書類受付日");
        exDateEquals(keisanKaiyakuBean.getKaiykymd(), BizDate.valueOf(20200107), "解約日");
        exBizCalcbleEquals(keisanKaiyakuBean.getYenshrkwsrate(), BizNumber.valueOf(119.36), "円支払為替レート");
        exBizCalcbleEquals(keisanKaiyakuBean.getGkshrkwsrate(), BizNumber.valueOf(119.37), "外貨支払為替レート");

        exStringEquals((String)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 0), "99806001157", "証券番号");
        exDateEquals((BizDate)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 1), BizDate.valueOf(20200107), "計算基準日");
        exClassificationEquals((C_SiinKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 2), C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn)MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "execByKeisanWExt", 3), C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001168");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkbn(), "8", "（ＩＷＳＳＮ）死亡受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkj(), "　", "（ＩＷＳＳＮ）死亡受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari1(), "100", "（ＩＷＳＳＮ）死亡保険金分割割合１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana1(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji1(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari2(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana2(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji2(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari3(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana3(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji3(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari4(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana4(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji4(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）４");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka(), "USD", "（ＩＷＳＳＮ）指定通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "12", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), "YEN", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka(), "USD", "（ＩＷＳＳＮ）払込通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "119.36", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "20150701", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "0", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "0", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "3.36", "（ＩＷＳＳＮ）照会時市場価格調整用利率");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001179");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkbn(), " ", "（ＩＷＳＳＮ）死亡受取人区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouuktkj(), "　", "（ＩＷＳＳＮ）死亡受取人区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari1(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana1(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji1(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari2(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana2(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji2(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari3(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana3(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji3(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknbunwari4(), "0", "（ＩＷＳＳＮ）死亡保険金分割割合４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikana4(), " ", "（ＩＷＳＳＮ）死亡保険金受取人氏名（カナ）４");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSibouhknknuktsmikanji4(), "　", "（ＩＷＳＳＮ）死亡保険金受取人氏名（漢字）４");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka(), "USD", "（ＩＷＳＳＮ）指定通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "1", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), "YEN", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka(), "USD", "（ＩＷＳＳＮ）払込通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "119.36", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "20160531", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "6666", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "7777", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "8888.00", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), "YEN", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), "YEN", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "3.36", "（ＩＷＳＳＮ）照会時市場価格調整用利率");
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN2;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001180");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka(), "JPY", "（ＩＷＳＳＮ）指定通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka(), "USD", "（ＩＷＳＳＮ）払込通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "0", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "0", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "00000000", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "0", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "0", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "0", "（ＩＷＳＳＮ）照会時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
    }

    @Test
    @TestOrder(90)
    public void testExec_A9() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001191");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka(), "JPY", "（ＩＷＳＳＮ）指定通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka(), "USD", "（ＩＷＳＳＮ）払込通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "0", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "0", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "00000000", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "0", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "0", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "0", "（ＩＷＳＳＮ）照会時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0.7", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
    }

    @Test
    @TestOrder(100)
    public void testExec_A10() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001205");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSiteituuka(), "JPY", "（ＩＷＳＳＮ）指定通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHrktuuka(), "USD", "（ＩＷＳＳＮ）払込通貨");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaipnyknrate(), "1", "（ＩＷＳＳＮ）初回Ｐ入金レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "0", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "00000000", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "0", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "0", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokaijikkktusirrt(), "3.36", "（ＩＷＳＳＮ）照会時市場価格調整用利率");
    }

    @Test
    @TestOrder(110)
    public void testExec_A11() {
        changeSystemDate(BizDate.valueOf(20200107));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806001010");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOKENKANKEISYAMEIGI_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnAisyoumeikbn(), "0", "（ＩＷＳＳＮ）愛称名区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnAisyoumeikj(), "　", "（ＩＷＳＳＮ）愛称名区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuuym(), "000000", "（ＩＷＳＳＮ）募集年月");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyhenkouymd(), "00000000", "（ＩＷＳＳＮ）最終変更日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyhenkousyorinm(), "配当金反映", "（ＩＷＳＳＮ）最終変更処理名");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyokensakuseiymd(), "20170508", "（ＩＷＳＳＮ）証券作成日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyosaihkymd(), "00000000", "（ＩＷＳＳＮ）証券再発行日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYakkanjyuryouhoukbn(), "0", "（ＩＷＳＳＮ）約款受領方法区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYakkanjyuryouhoukbnnm(), "　", "（ＩＷＳＳＮ）約款受領方法（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyouhnnm(), "５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）", "（ＩＷＳＳＮ）商品名");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetujiyuu(), "0", "（ＩＷＳＳＮ）消滅事由");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetujiyuukj(), "　", "（ＩＷＳＳＮ）消滅事由（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjyoutaikbn(), "0", "（ＩＷＳＳＮ）契約状態");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjyoutaikbnnm(), "　", "（ＩＷＳＳＮ）契約状態（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykymd(), "20200107", "（ＩＷＳＳＮ）契約日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSknnkaisiymd(), "00000000", "（ＩＷＳＳＮ）責任開始日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnSyoumetuymd(), "00000000", "（ＩＷＳＳＮ）消滅日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHknkkn(), "99", "（ＩＷＳＳＮ）保険期間");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnWarnmongon(), "　", "（ＩＷＳＳＮ）ワーニング文言");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsyanmkn(), " ", "（ＩＷＳＳＮ）被保険者氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnmkj(), "　", "（ＩＷＳＳＮ）被保険者氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseiymd(), "00000000", "（ＩＷＳＳＮ）被保険者生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknkyknen(), "40", "（ＩＷＳＳＮ）被保険者契約時年齢");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknnen(), "0", "（ＩＷＳＳＮ）被保険者現在年齢");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknsei(), "0", "（ＩＷＳＳＮ）被保険者性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnHhknseikj(), "　", "（ＩＷＳＳＮ）被保険者性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkn(), " ", "（ＩＷＳＳＮ）契約者氏名（カナ）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyknmkj(), "　", "（ＩＷＳＳＮ）契約者氏名（漢字）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyaseiymd(), "00000000", "（ＩＷＳＳＮ）契約者生年月日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyanen(), "0", "（ＩＷＳＳＮ）契約者現在年齢 ");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyksyasei(), "0", "（ＩＷＳＳＮ）契約者性別");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykseikj(), "　", "（ＩＷＳＳＮ）契約者性別（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdk(), "0", "（ＩＷＳＳＮ）契約者続柄");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKyktdkkj(), "　", "（ＩＷＳＳＮ）契約者続柄（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinyno(), "0000000", "（ＩＷＳＳＮ）通信先郵便番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr1kj(), "　", "（ＩＷＳＳＮ）通信先住所１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr2kj(), "　", "（ＩＷＳＳＮ）通信先住所２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsinadr3kj(), "　", "（ＩＷＳＳＮ）通信先住所３");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnTsintelno(), " ", "（ＩＷＳＳＮ）通信先電話番号");


        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKykjisjkkktusirrt(), "0", "（ＩＷＳＳＮ）契約時市場価格調整用利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKihonhokenkngk(), "16909.00", "（ＩＷＳＳＮ）基本保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYoteiriritu(), "0", "（ＩＷＳＳＮ）予定利率");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnInitsbjyensitihsykjnkg(), "0", "（ＩＷＳＳＮ）初期死亡時円換算支払額最低保証特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnMkhyouyensysnnktkjnkg(), "0", "（ＩＷＳＳＮ）目標到達時円建終身・年金保険変更特約基準金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
    }

    @Test
    @TestOrder(120)
    public void testExec_A12() {
        changeSystemDate(BizDate.valueOf(20210909));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806062916");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbn(), "1", "（ＩＷＳＳＮ）円貨払込額案内通知区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbnnm(), "希望する（メール、郵送）", "（ＩＷＳＳＮ）円貨払込額案内通知区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDai2tsintelno(), "02-3456-8976", "（ＩＷＳＳＮ）第２通信先電話番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "24252000.00", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugktuksyu(), "DOLLAR", "（ＩＷＳＳＮ）基準金額（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "119.37", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "20210908", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "6666", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), "YEN", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "8888.00", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "7777", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), "YEN", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "9999.00", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");

    }

    @Test
    @TestOrder(130)
    public void testExec_A13() {
        changeSystemDate(BizDate.valueOf(20210909));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806062868");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbn(), "1", "（ＩＷＳＳＮ）円貨払込額案内通知区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbnnm(), "希望する（メール、郵送）", "（ＩＷＳＳＮ）円貨払込額案内通知区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDai2tsintelno(), "02-3456-8976", "（ＩＷＳＳＮ）第２通信先電話番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "24252000.00", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugktuksyu(), "DOLLAR", "（ＩＷＳＳＮ）基準金額（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "119.37", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "20210908", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "6666", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), "YEN", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "8888.00", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "7777", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), "YEN", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "9999.00", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), "DOLLAR", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");

    }

    @Test
    @TestOrder(140)
    public void testExec_A14() {
        changeSystemDate(BizDate.valueOf(20210904));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806061395");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbn(), "2", "（ＩＷＳＳＮ）円貨払込額案内通知区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbnnm(), "希望する（郵送）", "（ＩＷＳＳＮ）円貨払込額案内通知区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDai2tsintelno(), "02-3456-8976", "（ＩＷＳＳＮ）第２通信先電話番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "24252000.00", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugktuksyu(), "DOLLAR", "（ＩＷＳＳＮ）基準金額（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "0", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "00000000", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "0", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "0", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd1(), "5100230", "（ＩＷＳＳＮ）代理店コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm1(), "漢字代理店正式名５１００２３０", "（ＩＷＳＳＮ）代理店名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd1(), "080020", "（ＩＷＳＳＮ）代表募集人コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin1(), "漢字募集人名　テスト用", "（ＩＷＳＳＮ）募集人名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd2(), " ", "（ＩＷＳＳＮ）代理店コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm2(), "　", "（ＩＷＳＳＮ）代理店名２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd2(), "080120", "（ＩＷＳＳＮ）代表募集人コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin2(), "　", "（ＩＷＳＳＮ）募集人名２");

    }

    @Test
    @TestOrder(150)
    public void testExec_A15() {
        changeSystemDate(BizDate.valueOf(20210911));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806060497");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbn(), "3", "（ＩＷＳＳＮ）円貨払込額案内通知区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbnnm(), "希望する（メール）", "（ＩＷＳＳＮ）円貨払込額案内通知区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDai2tsintelno(), "02-3456-8976", "（ＩＷＳＳＮ）第２通信先電話番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "24252000.00", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugktuksyu(), "DOLLAR", "（ＩＷＳＳＮ）基準金額（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "0", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), " ", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "119.38", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "20210910", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "0", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "0", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd1(), " ", "（ＩＷＳＳＮ）代理店コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm1(), "　", "（ＩＷＳＳＮ）代理店名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd1(), "080120", "（ＩＷＳＳＮ）代表募集人コード１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin1(), "　", "（ＩＷＳＳＮ）募集人名１");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitencd2(), " ", "（ＩＷＳＳＮ）代理店コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDairitenm2(), "　", "（ＩＷＳＳＮ）代理店名２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDaibosyuucd2(), " ", "（ＩＷＳＳＮ）代表募集人コード２");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnBosyuunin2(), "　", "（ＩＷＳＳＮ）募集人名２");

    }

    @Test
    @TestOrder(160)
    public void testExec_A16() {
        changeSystemDate(BizDate.valueOf(20210909));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN3;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806060394");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbn(), "3", "（ＩＷＳＳＮ）円貨払込額案内通知区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbnnm(), "希望する（メール）", "（ＩＷＳＳＮ）円貨払込額案内通知区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDai2tsintelno(), " ", "（ＩＷＳＳＮ）第２通信先電話番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "0", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugktuksyu(), " ", "（ＩＷＳＳＮ）基準金額（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "6000000", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), "YEN", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "0", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "00000000", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "148227", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), "YEN", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "7777", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), "YEN", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");

    }

    @Test
    @TestOrder(170)
    public void testExec_A17() {
        changeSystemDate(BizDate.valueOf(20210909));

        MockObjectManager.initialize();

        KeisanCommonKaiyakuMockForHozen.SYORIPTN = KeisanCommonKaiyakuMockForHozen.TESTPATTERN3;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN2;
        CheckKaiyakuMockForHozen.SYORIPTN = CheckKaiyakuMockForHozen.TESTPATTERN1;

        C_IwssnKykSyoukaiKekkaKbn iwssnKykSyoukaiKekkaKbn = KhGetSyanaiWebKeiyakuInfo.exec("99806051288");
        IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean = KhGetSyanaiWebKeiyakuInfo.getIwssnSyanaiHozenInfoOutputBean();

        exClassificationEquals(iwssnKykSyoukaiKekkaKbn, C_IwssnKykSyoukaiKekkaKbn.HOSYOUNAIYOU_ERROR, "社内用契約内容照会結果区分");

        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbn(), "4", "（ＩＷＳＳＮ）円貨払込額案内通知区分");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnYnkhrkmgkannittkbnnm(), "希望しない", "（ＩＷＳＳＮ）円貨払込額案内通知区分（区分名称）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnDai2tsintelno(), " ", "（ＩＷＳＳＮ）第２通信先電話番号");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugaika(), "0", "（ＩＷＳＳＮ）基準金額（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakugktuksyu(), " ", "（ＩＷＳＳＮ）基準金額（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyen(), "6000000", "（ＩＷＳＳＮ）基準金額（円貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKijyunkingakuyentuksyu(), "YEN", "（ＩＷＳＳＮ）基準金額（円貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrkwsrate(), "0", "（ＩＷＳＳＮ）支払時為替レート");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKwsratesyutokuymd(), "00000000", "（ＩＷＳＳＮ）為替レート取得日");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryen(), "148227", "（ＩＷＳＳＮ）解約返戻金（円建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhryentuukasyu(), "YEN", "（ＩＷＳＳＮ）解約返戻金（円建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaika(), "0", "（ＩＷＳＳＮ）解約返戻金（外貨建て）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnKaiyakuhrgaikatuukasyu(), " ", "（ＩＷＳＳＮ）解約返戻金（外貨建て）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyen(), "7777", "（ＩＷＳＳＮ）支払額合計（円）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeiyentuukasyu(), "YEN", "（ＩＷＳＳＮ）支払額合計（円）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaika(), "0", "（ＩＷＳＳＮ）支払額合計（外貨）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnShrgkkeigaikatuukasyu(), " ", "（ＩＷＳＳＮ）支払額合計（外貨）（通貨種類）");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngaku(), "20010", "（ＩＷＳＳＮ）現在死亡保険金額");
        exStringEquals(iwssnSyanaiHozenInfoOutputBean.getIwssnGenzaisbhknkngakutuksy(), "YEN", "（ＩＷＳＳＮ）現在死亡保険金額（通貨種類）");

    }


}
