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
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約共通計算のメソッド {@link KeisanCommonKaiyaku#keisanZeimuinfo(String, IT_KykKihon, BizDate, C_Tuukasyu, C_Kaiyakujiyuu,
        KeisanKaiyakuBean, KeisanCommonKaiyakuOutBean) } テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanCommonKaiyakuTest_keisanZeimuinfo {


    @Inject
    private KeisanCommonKaiyaku keisanCommonKaiyaku;

    @Inject
    private HozenDomManager hozenDomManager;

    private C_ErrorKbn erroKbn;

    private final static String fileName = "UT-SP_単体テスト仕様書_解約共通計算";

    private final static String sheetName = "INデータ";

    private final static String syoNo1  = "17806000013";

    private final static String syoNo2  = "17806000024";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
                bind(KeisanHtyKeihi.class).to(KeisanHtyKeihiMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {

        KeisanGaikakanzanMockForHozen.caller = KeisanCommonKaiyakuTest_keisanZeimuinfo.class;
        KeisanHtyKeihiMockForHozen.caller = KeisanCommonKaiyakuTest_keisanZeimuinfo.class;
    }

    @AfterClass
    public static void testClear() {

        KeisanGaikakanzanMockForHozen.caller = null;
        KeisanHtyKeihiMockForHozen.caller = null;

        MockObjectManager.initialize();
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(KeisanCommonKaiyakuTest_keisanZeimuinfo.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testKeisanZeimuinfo_A1() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo1);
        BizDate pSyoriYmd = BizDate.valueOf("20181206");
        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;
        C_Kaiyakujiyuu pKaiyakujiyuu = C_Kaiyakujiyuu.KYKSB;
        KeisanKaiyakuBean pKeisanKaiyakuInBean = new KeisanKaiyakuBean();
        KeisanCommonKaiyakuOutBean pKeisanKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean =  new KeisanCommonKaiyakuOutBean();
        BizCurrency pKaiyakuhrgoukeiYen = BizCurrency.valueOf(1001);
        pKeisanKaiyakuOutBean.setKaiyakuhrgoukeiYen(pKaiyakuhrgoukeiYen);
        BizCurrency pSonotaseisan = BizCurrency.valueOf(1002);
        pKeisanKaiyakuOutBean.setSonotaseisan(pSonotaseisan);
        C_UmuKbn pGsbunritaisyouFlg = C_UmuKbn.ARI;
        pKeisanKaiyakuOutBean.setGsbunritaisyouFlg(pGsbunritaisyouFlg);
        BizCurrency pJpyShrjiYenhtykeihi = BizCurrency.valueOf(1010);
        pKeisanKaiyakuOutBean.setJpyShrjiYenhtykeihi(pJpyShrjiYenhtykeihi);
        BizCurrency pJpygstszeigk = BizCurrency.valueOf(1012);
        pKeisanKaiyakuOutBean.setJpygstszeigk(pJpygstszeigk);
        BizCurrency pJpykaShrYenGsTsTaisyouSaeki = BizCurrency.valueOf(1013);
        pKeisanKaiyakuOutBean.setJpykaShrYenGsTsTaisyouSaeki(pJpykaShrYenGsTsTaisyouSaeki);
        pKeisanKaiyakuOutBean.setHaitoukinYen(BizCurrency.valueOf(1014));
        pKeisanKaiyakuOutBean.setYentkbthaitoukin(BizCurrency.valueOf(1015));

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanZeimuinfo(pKinouBunrui, pKykKihon, pSyoriYmd, pTuukasyu, pKaiyakujiyuu, pKeisanKaiyakuInBean, pKeisanKaiyakuOutBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSynykngk(), BizCurrency.valueOf(4032), "収入金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHtykeihi(), BizCurrency.valueOf(1010), "必要経費");
        exNumericEquals(keisanCommonKaiyakuOutBean.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYenShrKykHtyKeihi(), BizCurrency.valueOf(0), "円換算支払時契約者必要経費");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengstszeigk(), BizCurrency.valueOf(1012), "円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengststaisyousaeki(), BizCurrency.valueOf(1013), "円換算源泉徴収対象差益");

        exStringEquals((String)MockObjectManager.getArgument(KeisanHtyKeihiMockForHozen.class, "exec", 0, 0), syoNo1, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (KeisanHtyKeihiMockForHozen.class, "exec", 0, 1), C_Tuukasyu.JPY, "契約通貨種類");
    }

    @Test
    @TestOrder(20)
    public void testKeisanZeimuinfo_A2() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo1);
        BizDate pSyoriYmd = BizDate.valueOf("20181206");
        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;
        C_Kaiyakujiyuu pKaiyakujiyuu = C_Kaiyakujiyuu.BLNK;
        KeisanKaiyakuBean pKeisanKaiyakuInBean = new KeisanKaiyakuBean();
        KeisanCommonKaiyakuOutBean pKeisanKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean =  new KeisanCommonKaiyakuOutBean();
        BizCurrency pKaiyakuhrgoukeiYen = BizCurrency.valueOf(1001);
        pKeisanKaiyakuOutBean.setKaiyakuhrgoukeiYen(pKaiyakuhrgoukeiYen);
        C_UmuKbn pGsbunritaisyouFlg = C_UmuKbn.NONE;
        pKeisanKaiyakuOutBean.setGsbunritaisyouFlg(pGsbunritaisyouFlg);
        BizCurrency pJpygstszeigk = BizCurrency.valueOf(1012);
        pKeisanKaiyakuOutBean.setJpygstszeigk(pJpygstszeigk);
        BizCurrency pJpykaShrYenGsTsTaisyouSaeki = BizCurrency.valueOf(1013);
        pKeisanKaiyakuOutBean.setJpykaShrYenGsTsTaisyouSaeki(pJpykaShrYenGsTsTaisyouSaeki);
        pKeisanKaiyakuOutBean.setHaitoukinYen(BizCurrency.valueOf(1014));
        pKeisanKaiyakuOutBean.setYentkbthaitoukin(BizCurrency.valueOf(1015));

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN2;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanZeimuinfo(pKinouBunrui, pKykKihon, pSyoriYmd, pTuukasyu, pKaiyakujiyuu, pKeisanKaiyakuInBean, pKeisanKaiyakuOutBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSynykngk(), BizCurrency.valueOf(3030), "収入金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHtykeihi(), BizCurrency.valueOf(2001), "必要経費");
        exNumericEquals(keisanCommonKaiyakuOutBean.getKykhnkkaisuu(), 1, "契約者変更回数");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYenShrKykHtyKeihi(), BizCurrency.valueOf(2001), "円換算支払時契約者必要経費");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengstszeigk(), BizCurrency.valueOf(1012), "円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengststaisyousaeki(), BizCurrency.valueOf(1013), "円換算源泉徴収対象差益");

        exStringEquals((String)MockObjectManager.getArgument(KeisanHtyKeihiMockForHozen.class, "exec", 0, 0), syoNo1, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (KeisanHtyKeihiMockForHozen.class, "exec", 0, 1), C_Tuukasyu.JPY, "契約通貨種類");

    }

    @Test
    @TestOrder(30)
    public void testKeisanZeimuinfo_A3() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo2);
        BizDate pSyoriYmd = BizDate.valueOf("20181206");
        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;
        C_Kaiyakujiyuu pKaiyakujiyuu = C_Kaiyakujiyuu.KYKSB;
        KeisanKaiyakuBean pKeisanKaiyakuInBean = new KeisanKaiyakuBean();
        KeisanCommonKaiyakuOutBean pKeisanKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean =  new KeisanCommonKaiyakuOutBean();
        BizCurrency pKaiyakuhrgoukeiYen = BizCurrency.valueOf(1003);
        pKeisanKaiyakuOutBean.setKaiyakuhrgoukeiYen(pKaiyakuhrgoukeiYen);
        BizCurrency pMikeikapYen = BizCurrency.valueOf(1004);
        pKeisanKaiyakuOutBean.setMikeikapYen(pMikeikapYen);
        BizCurrency pZennouseisankYen = BizCurrency.valueOf(1005);
        pKeisanKaiyakuOutBean.setZennouseisankYen(pZennouseisankYen);
        BizCurrency pAzukariGanrikinYen = BizCurrency.valueOf(1006);
        pKeisanKaiyakuOutBean.setAzukariGanrikinYen(pAzukariGanrikinYen);
        BizCurrency pHaitoukinYen = BizCurrency.valueOf(1007);
        pKeisanKaiyakuOutBean.setHaitoukinYen(pHaitoukinYen);
        BizCurrency pYentkbthaitoukin =  BizCurrency.valueOf(1008);
        pKeisanKaiyakuOutBean.setYentkbthaitoukin(pYentkbthaitoukin);
        BizCurrency pKrkgkYen = BizCurrency.valueOf(1009);
        pKeisanKaiyakuOutBean.setKrkgkYen(pKrkgkYen);
        C_UmuKbn pGsbunritaisyouFlg = C_UmuKbn.ARI;
        pKeisanKaiyakuOutBean.setGsbunritaisyouFlg(pGsbunritaisyouFlg);
        BizCurrency pJpyShrjiYenhtykeihi = BizCurrency.valueOf(1010);
        pKeisanKaiyakuOutBean.setJpyShrjiYenhtykeihi(pJpyShrjiYenhtykeihi);
        BizCurrency pJpygstszeigk = BizCurrency.valueOf(1012);
        pKeisanKaiyakuOutBean.setJpygstszeigk(pJpygstszeigk);
        BizCurrency pJpykaShrYenGsTsTaisyouSaeki = BizCurrency.valueOf(1013);
        pKeisanKaiyakuOutBean.setJpykaShrYenGsTsTaisyouSaeki(pJpykaShrYenGsTsTaisyouSaeki);

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanZeimuinfo(pKinouBunrui, pKykKihon, pSyoriYmd, pTuukasyu, pKaiyakujiyuu, pKeisanKaiyakuInBean, pKeisanKaiyakuOutBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSynykngk(), BizCurrency.valueOf(7042), "収入金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHtykeihi(), BizCurrency.valueOf(1010), "必要経費");
        exNumericEquals(keisanCommonKaiyakuOutBean.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYenShrKykHtyKeihi(), BizCurrency.valueOf(0), "円換算支払時契約者必要経費");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengstszeigk(), BizCurrency.valueOf(1012), "円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengststaisyousaeki(), BizCurrency.valueOf(1013), "円換算源泉徴収対象差益");

        exStringEquals((String)MockObjectManager.getArgument(KeisanHtyKeihiMockForHozen.class, "exec", 0, 0), syoNo2, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (KeisanHtyKeihiMockForHozen.class, "exec", 0, 1), C_Tuukasyu.USD, "契約通貨種類");
    }

    @Test
    @TestOrder(40)
    public void testKeisanZeimuinfo_A4() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo2);
        BizDate pSyoriYmd = BizDate.valueOf("20181206");
        C_Tuukasyu pTuukasyu = C_Tuukasyu.JPY;
        C_Kaiyakujiyuu pKaiyakujiyuu = C_Kaiyakujiyuu.BLNK;
        KeisanKaiyakuBean pKeisanKaiyakuInBean = new KeisanKaiyakuBean();
        KeisanCommonKaiyakuOutBean pKeisanKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean =  new KeisanCommonKaiyakuOutBean();
        BizCurrency pKaiyakuhrgoukeiYen = BizCurrency.valueOf(1003);
        pKeisanKaiyakuOutBean.setKaiyakuhrgoukeiYen(pKaiyakuhrgoukeiYen);
        BizCurrency pMikeikapYen = BizCurrency.valueOf(1004);
        pKeisanKaiyakuOutBean.setMikeikapYen(pMikeikapYen);
        BizCurrency pZennouseisankYen = BizCurrency.valueOf(1005);
        pKeisanKaiyakuOutBean.setZennouseisankYen(pZennouseisankYen);
        BizCurrency pAzukariGanrikinYen = BizCurrency.valueOf(1006);
        pKeisanKaiyakuOutBean.setAzukariGanrikinYen(pAzukariGanrikinYen);
        BizCurrency pHaitoukinYen = BizCurrency.valueOf(1007);
        pKeisanKaiyakuOutBean.setHaitoukinYen(pHaitoukinYen);
        BizCurrency pYentkbthaitoukin =  BizCurrency.valueOf(1008);
        pKeisanKaiyakuOutBean.setYentkbthaitoukin(pYentkbthaitoukin);
        C_UmuKbn pGsbunritaisyouFlg = C_UmuKbn.ARI;
        pKeisanKaiyakuOutBean.setGsbunritaisyouFlg(pGsbunritaisyouFlg);
        BizCurrency pJpyShrjiYenhtykeihi = BizCurrency.valueOf(1010);
        pKeisanKaiyakuOutBean.setJpyShrjiYenhtykeihi(pJpyShrjiYenhtykeihi);
        BizCurrency pJpygstszeigk = BizCurrency.valueOf(1012);
        pKeisanKaiyakuOutBean.setJpygstszeigk(pJpygstszeigk);
        BizCurrency pJpykaShrYenGsTsTaisyouSaeki = BizCurrency.valueOf(1013);
        pKeisanKaiyakuOutBean.setJpykaShrYenGsTsTaisyouSaeki(pJpykaShrYenGsTsTaisyouSaeki);

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanZeimuinfo(pKinouBunrui, pKykKihon, pSyoriYmd, pTuukasyu, pKaiyakujiyuu, pKeisanKaiyakuInBean, pKeisanKaiyakuOutBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSynykngk(), BizCurrency.valueOf(6033), "収入金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHtykeihi(), BizCurrency.valueOf(1010), "必要経費");
        exNumericEquals(keisanCommonKaiyakuOutBean.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYenShrKykHtyKeihi(), BizCurrency.valueOf(0), "円換算支払時契約者必要経費");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengstszeigk(), BizCurrency.valueOf(1012), "円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengststaisyousaeki(), BizCurrency.valueOf(1013), "円換算源泉徴収対象差益");

        exStringEquals((String)MockObjectManager.getArgument(KeisanHtyKeihiMockForHozen.class, "exec", 0, 0), syoNo2, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (KeisanHtyKeihiMockForHozen.class, "exec", 0, 1), C_Tuukasyu.USD, "契約通貨種類");

    }

    @Test
    @TestOrder(50)
    public void testKeisanZeimuinfo_A5() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo2);
        BizDate pSyoriYmd = BizDate.valueOf("20181206");
        C_Tuukasyu pTuukasyu = C_Tuukasyu.USD;
        C_Kaiyakujiyuu pKaiyakujiyuu = C_Kaiyakujiyuu.KYKSB;
        KeisanKaiyakuBean pKeisanKaiyakuInBean = new KeisanKaiyakuBean();
        KeisanCommonKaiyakuOutBean pKeisanKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean =  new KeisanCommonKaiyakuOutBean();
        BizCurrency pMikeikapGk = BizCurrency.valueOf(1004, BizCurrencyTypes.DOLLAR);
        pKeisanKaiyakuOutBean.setMikeikapGk(pMikeikapGk);
        BizCurrency pMikeikapYen = BizCurrency.valueOf(1004);
        pKeisanKaiyakuOutBean.setMikeikapYen(pMikeikapYen);
        BizCurrency pZennouseisankGk = BizCurrency.valueOf(1005, BizCurrencyTypes.DOLLAR);
        pKeisanKaiyakuOutBean.setZennouseisankGk(pZennouseisankGk);
        BizCurrency pZennouseisankYen = BizCurrency.valueOf(1005);
        pKeisanKaiyakuOutBean.setZennouseisankYen(pZennouseisankYen);
        BizCurrency pAzukariGanrikinYen = BizCurrency.valueOf(1006);
        pKeisanKaiyakuOutBean.setAzukariGanrikinYen(pAzukariGanrikinYen);
        BizCurrency pHaitoukinYen = BizCurrency.valueOf(1007);
        pKeisanKaiyakuOutBean.setHaitoukinYen(pHaitoukinYen);
        BizCurrency pYentkbthaitoukin =  BizCurrency.valueOf(1008);
        pKeisanKaiyakuOutBean.setYentkbthaitoukin(pYentkbthaitoukin);
        BizCurrency pKrkgkYen = BizCurrency.valueOf(1009);
        pKeisanKaiyakuOutBean.setKrkgkYen(pKrkgkYen);
        BizCurrency pKaiyakuHr = BizCurrency.valueOf(1010, BizCurrencyTypes.DOLLAR);
        pKeisanKaiyakuOutBean.setKaiyakuHr(pKaiyakuHr);
        BizCurrency pAzukariGanrikingk = BizCurrency.valueOf(1011, BizCurrencyTypes.DOLLAR);
        pKeisanKaiyakuOutBean.setAzukariGanrikingk(pAzukariGanrikingk);
        BizNumber pZeimukwsrate = BizNumber.valueOf(1.012);
        pKeisanKaiyakuOutBean.setZeimukwsrate(pZeimukwsrate);
        C_UmuKbn pGsbunritaisyouFlg = C_UmuKbn.ARI;
        pKeisanKaiyakuOutBean.setGsbunritaisyouFlg(pGsbunritaisyouFlg);
        BizCurrency pGaikaShrYenHtyKeihi = BizCurrency.valueOf(1010);
        pKeisanKaiyakuOutBean.setGaikaShrYenHtyKeihi(pGaikaShrYenHtyKeihi);
        BizCurrency pGaikaShrYenGsTsZeigk = BizCurrency.valueOf(1012);
        pKeisanKaiyakuOutBean.setGaikaShrYenGsTsZeigk(pGaikaShrYenGsTsZeigk);
        BizCurrency pGaikaShrYenGsTsTaisyouSaeki = BizCurrency.valueOf(1013);
        pKeisanKaiyakuOutBean.setGaikaShrYenGsTsTaisyouSaeki(pGaikaShrYenGsTsTaisyouSaeki);

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanZeimuinfo(pKinouBunrui, pKykKihon, pSyoriYmd, pTuukasyu, pKaiyakujiyuu, pKeisanKaiyakuInBean, pKeisanKaiyakuOutBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSynykngk(), BizCurrency.valueOf(10117), "収入金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHtykeihi(), BizCurrency.valueOf(1010), "必要経費");
        exNumericEquals(keisanCommonKaiyakuOutBean.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYenShrKykHtyKeihi(), BizCurrency.valueOf(0), "円換算支払時契約者必要経費");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengstszeigk(), BizCurrency.valueOf(1012), "円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengststaisyousaeki(), BizCurrency.valueOf(1013), "円換算源泉徴収対象差益");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(4030, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), pZeimukwsrate, "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.SUTE, "端数処理区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanHtyKeihiMockForHozen.class, "exec", 0, 0), syoNo2, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (KeisanHtyKeihiMockForHozen.class, "exec", 0, 1), C_Tuukasyu.USD, "契約通貨種類");

    }

    @Test
    @TestOrder(60)
    public void testKeisanZeimuinfo_A6() {

        String pKinouBunrui = "online";
        IT_KykKihon pKykKihon = hozenDomManager.getKykKihon(syoNo2);
        BizDate pSyoriYmd = BizDate.valueOf("20181206");
        C_Tuukasyu pTuukasyu = C_Tuukasyu.USD;
        C_Kaiyakujiyuu pKaiyakujiyuu = C_Kaiyakujiyuu.SKS;
        KeisanKaiyakuBean pKeisanKaiyakuInBean = new KeisanKaiyakuBean();
        KeisanCommonKaiyakuOutBean pKeisanKaiyakuOutBean = new KeisanCommonKaiyakuOutBean();
        KeisanCommonKaiyakuOutBean keisanCommonKaiyakuOutBean =  new KeisanCommonKaiyakuOutBean();
        BizCurrency pMikeikapGk = BizCurrency.valueOf(1004, BizCurrencyTypes.DOLLAR);
        pKeisanKaiyakuOutBean.setMikeikapGk(pMikeikapGk);
        BizCurrency pMikeikapYen = BizCurrency.valueOf(1004);
        pKeisanKaiyakuOutBean.setMikeikapYen(pMikeikapYen);
        BizCurrency pZennouseisankGk = BizCurrency.valueOf(1005, BizCurrencyTypes.DOLLAR);
        pKeisanKaiyakuOutBean.setZennouseisankGk(pZennouseisankGk);
        BizCurrency pZennouseisankYen = BizCurrency.valueOf(1005);
        pKeisanKaiyakuOutBean.setZennouseisankYen(pZennouseisankYen);
        BizCurrency pAzukariGanrikinYen = BizCurrency.valueOf(1006);
        pKeisanKaiyakuOutBean.setAzukariGanrikinYen(pAzukariGanrikinYen);
        BizCurrency pHaitoukinYen = BizCurrency.valueOf(1007);
        pKeisanKaiyakuOutBean.setHaitoukinYen(pHaitoukinYen);
        BizCurrency pYentkbthaitoukin =  BizCurrency.valueOf(1008);
        pKeisanKaiyakuOutBean.setYentkbthaitoukin(pYentkbthaitoukin);
        BizCurrency pKaiyakuHr = BizCurrency.valueOf(1010, BizCurrencyTypes.DOLLAR);
        pKeisanKaiyakuOutBean.setKaiyakuHr(pKaiyakuHr);
        BizCurrency pAzukariGanrikingk = BizCurrency.valueOf(1011, BizCurrencyTypes.DOLLAR);
        pKeisanKaiyakuOutBean.setAzukariGanrikingk(pAzukariGanrikingk);
        BizNumber pZeimukwsrate = BizNumber.valueOf(1.012);
        pKeisanKaiyakuOutBean.setZeimukwsrate(pZeimukwsrate);
        C_UmuKbn pGsbunritaisyouFlg = C_UmuKbn.ARI;
        pKeisanKaiyakuOutBean.setGsbunritaisyouFlg(pGsbunritaisyouFlg);
        BizCurrency pGaikaShrYenHtyKeihi = BizCurrency.valueOf(1010);
        pKeisanKaiyakuOutBean.setGaikaShrYenHtyKeihi(pGaikaShrYenHtyKeihi);
        BizCurrency pGaikaShrYenGsTsZeigk = BizCurrency.valueOf(1012);
        pKeisanKaiyakuOutBean.setGaikaShrYenGsTsZeigk(pGaikaShrYenGsTsZeigk);
        BizCurrency pGaikaShrYenGsTsTaisyouSaeki = BizCurrency.valueOf(1013);
        pKeisanKaiyakuOutBean.setGaikaShrYenGsTsTaisyouSaeki(pGaikaShrYenGsTsTaisyouSaeki);

        KeisanHtyKeihiMockForHozen.SYORIPTN = KeisanHtyKeihiMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        MockObjectManager.initialize();

        erroKbn = keisanCommonKaiyaku.keisanZeimuinfo(pKinouBunrui, pKykKihon, pSyoriYmd, pTuukasyu, pKaiyakujiyuu, pKeisanKaiyakuInBean, pKeisanKaiyakuOutBean);
        keisanCommonKaiyakuOutBean = keisanCommonKaiyaku.getKeisanCommonKaiyakuOutBean();
        exClassificationEquals(erroKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getSynykngk(), BizCurrency.valueOf(9108), "収入金額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getHtykeihi(), BizCurrency.valueOf(1010), "必要経費");
        exNumericEquals(keisanCommonKaiyakuOutBean.getKykhnkkaisuu(), 0, "契約者変更回数");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYenShrKykHtyKeihi(), BizCurrency.valueOf(0), "円換算支払時契約者必要経費");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengstszeigk(), BizCurrency.valueOf(1012), "円換算源泉徴収税額");
        exBizCalcbleEquals(keisanCommonKaiyakuOutBean.getYengststaisyousaeki(), BizCurrency.valueOf(1013), "円換算源泉徴収対象差益");

        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 1), BizCurrency.valueOf(4030, BizCurrencyTypes.DOLLAR), "金額");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 2), pZeimukwsrate, "レート");
        exClassificationEquals((C_HasuusyoriKbn)MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class,
            "exec", 0, 3), C_HasuusyoriKbn.SUTE, "端数処理区分");

        exStringEquals((String)MockObjectManager.getArgument(KeisanHtyKeihiMockForHozen.class, "exec", 0, 0), syoNo2, "証券番号");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument
            (KeisanHtyKeihiMockForHozen.class, "exec", 0, 1), C_Tuukasyu.USD, "契約通貨種類");

    }
}
