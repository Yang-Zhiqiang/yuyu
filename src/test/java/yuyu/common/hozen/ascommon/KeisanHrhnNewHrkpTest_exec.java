package yuyu.common.hozen.ascommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.KeisanIkkatuPGk;
import yuyu.common.hozen.khcommon.KeisanIkkatuPGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuPGkMock_KeisanHrhnNewHrkp;
import yuyu.common.hozen.khcommon.KeisanSP;
import yuyu.common.hozen.khcommon.KeisanSPMock_KeisanHrhnNewHrkp;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 払変新払込Ｐ計算クラスのメソッド {@link KeisanHrhnNewHrkp#exec()}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class KeisanHrhnNewHrkpTest_exec {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_払変新払込Ｐ計算";

    private final static String sheetName = "INデータ";

    private static HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

    private final static String syono1 = "11807000010";

    private final static String syono3 = "11807000032";

    private final static String syono4 = "11807000043";

    private final static String syono5 = "11807000054";

    private final static String syono6 = "11807000065";

    private final static String syono7 = "11807000076";

    private final static String syono8 = "13809111116";

    private final static String syono9 = "11808221115";

    private final static String syono10 = "12809221131";

    private final static String syono11 = "24809221136";

    private final static String syono12 = "24809221147";

    private final static String syono13 = "24809221158";

    private final static String syono14 = "60806345767";

    private final static String syono15 = "60806345778";

    private final static String syono16 = "60806345789";

    @Inject
    private KeisanHrhnNewHrkp keisanHrhnNewHrkp;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanSP.class).to(KeisanSPMock_KeisanHrhnNewHrkp.class);
                bind(KeisanIkkatuPGk.class).to(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanSPMock_KeisanHrhnNewHrkp.caller = KeisanHrhnNewHrkpTest_exec.class;
        KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.caller = KeisanHrhnNewHrkpTest_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

        KeisanSPMock_KeisanHrhnNewHrkp.caller = null;
        KeisanSPMock_KeisanHrhnNewHrkp.SYORIPTN = null;
        KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.caller = null;
        KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.SYORIPTN = null;
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {

        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            testDataAndTblMap = testDataMaker.getInData(KeisanHrhnNewHrkpTest_exec.class, fileName, sheetName);
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
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());

        KeisanSPMock_KeisanHrhnNewHrkp.caller = null;
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        MockObjectManager.initialize();
        KeisanSPMock_KeisanHrhnNewHrkp.SYORIPTN = KeisanSPMock_KeisanHrhnNewHrkp.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono1);

        IT_KykSyouhn syuKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        List<IT_KykSyouhn> tkKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(
            syuKykSyouhn, tkKykSyouhn, C_Hrkkaisuu.HALFY, C_Hrkkaisuu.TUKI, C_Hrkkeiro.KOUHURI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(900), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(450), "主契約Ｐ");

        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 1, "特約情報件数");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(0), BizCurrency.valueOf(450), "特約Ｐリスト[0]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(0), "ﾕｲ", "特約商品コードリスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(0), 2, "特約商品世代番号リスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(0), 3, "特約契約商品連番リスト[0]");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.SD, "Ｓ建Ｐ建区分");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 0), "ﾕｱ", "SP計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 1), "A01", "SP計算の１次呼出の料率世代番号");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 2), BizNumber.valueOf(1.0605), "SP計算の１次呼出の予定利率");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 3), C_Hrkkaisuu.TUKI, "SP計算の１次呼出の払込回数");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 4), 45, "SP計算の１次呼出の被保険者年齢");
        exClassificationEquals((C_Hhknsei)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 5), C_Hhknsei.MALE, "SP計算の１次呼出の被保険者性別");
        exClassificationEquals((C_HknkknsmnKbn)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 6), C_HknkknsmnKbn.SAIMANKI, "SP計算の１次呼出の保険期間歳満期区分");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 7), 60, "SP計算の１次呼出の保険期間");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 8), 10, "SP計算の１次呼出の払込期間");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 9), C_Sdpd.SD, "SP計算の１次呼出のＳ建Ｐ建区分");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 10), BizCurrency.valueOf(5000000), "SP計算の１次呼出の保険金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 11), BizCurrency.valueOf(2500), "SP計算の１次呼出の保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 12), C_Tuukasyu.JPY, "SP計算の１次呼出の契約通貨種類");
        exClassificationEquals((C_Kykjyoutai)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 13), C_Kykjyoutai.HRKMTYUU, "SP計算の１次呼出の契約状態");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 14), 1, "SP計算の１次呼出の第１保険期間");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 15), C_Hrkkeiro.KOUHURI, "SP計算の１次呼出の払込経路");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 0), "ﾕｲ", "SP計算の２次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 1), "A02", "SP計算の２次呼出の料率世代番号");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 2), BizNumber.valueOf(1.0585), "SP計算の２次呼出の予定利率");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 3), C_Hrkkaisuu.TUKI, "SP計算の２次呼出の払込回数");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 4), 46, "SP計算の２次呼出の被保険者年齢");
        exClassificationEquals((C_Hhknsei)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 5), C_Hhknsei.FEMALE, "SP計算の２次呼出の被保険者性別");
        exClassificationEquals((C_HknkknsmnKbn)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 6), C_HknkknsmnKbn.NENMANKI, "SP計算の２次呼出の保険期間歳満期区分");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 7), 61, "SP計算の２次呼出の保険期間");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 8), 11, "SP計算の２次呼出の払込期間");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 9), C_Sdpd.SD, "SP計算の２次呼出のＳ建Ｐ建区分");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 10), BizCurrency.valueOf(100000), "SP計算の２次呼出の保険金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 11), BizCurrency.valueOf(600), "SP計算の２次呼出の保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 12), C_Tuukasyu.USD, "SP計算の２次呼出の契約通貨種類");
        exClassificationEquals((C_Kykjyoutai)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 13), C_Kykjyoutai.HRKMTYUU, "SP計算の２次呼出の契約状態");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 14), 1, "SP計算の２次呼出の第１保険期間");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 15), C_Hrkkeiro.KOUHURI, "SP計算の２次呼出の払込経路");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();

        KeisanSPMock_KeisanHrhnNewHrkp.SYORIPTN = KeisanSPMock_KeisanHrhnNewHrkp.TESTPATTERN2;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono3);
        IT_KykSyouhn syuKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        List<IT_KykSyouhn> tkKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(
            syuKykSyouhn, tkKykSyouhn, C_Hrkkaisuu.HALFY, C_Hrkkaisuu.TUKI, C_Hrkkeiro.KOUHURI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");

        assertNull("新払込保険料", keisanHrhnNewHrkp.getNewHrkp());
        assertNull("主契約Ｐ", keisanHrhnNewHrkp.getSyuP());
        assertNull( "特約Ｐリスト", keisanHrhnNewHrkp.getTkPList());
        assertNull("特約商品コードリスト", keisanHrhnNewHrkp.getTkSyouhnCdList());
        assertNull("特約商品世代番号リスト", keisanHrhnNewHrkp.getTkSyouhnSdnoList());
        assertNull("特約契約商品連番リスト", keisanHrhnNewHrkp.getTkKykSyouhnRennoList());
        assertNull("Ｓ建Ｐ建区分", keisanHrhnNewHrkp.getSdpd());

    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();

        KeisanSPMock_KeisanHrhnNewHrkp.SYORIPTN = KeisanSPMock_KeisanHrhnNewHrkp.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono4);
        IT_KykSyouhn syuKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        List<IT_KykSyouhn> tkKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(
            syuKykSyouhn, tkKykSyouhn, C_Hrkkaisuu.HALFY, C_Hrkkaisuu.TUKI, C_Hrkkeiro.KOUHURI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(450), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(450), "主契約Ｐ");

        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 0, "特約Ｐリストの要素数");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().size(), 0, "特約商品コードリストの要素数");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().size(), 0, "特約商品世代番号リストの要素数");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().size(), 0, "特約契約商品連番リストの要素数");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();

        KeisanSPMock_KeisanHrhnNewHrkp.SYORIPTN = KeisanSPMock_KeisanHrhnNewHrkp.TESTPATTERN3;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono5);
        IT_KykSyouhn syuKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        List<IT_KykSyouhn> tkKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(
            syuKykSyouhn, tkKykSyouhn, C_Hrkkaisuu.HALFY, C_Hrkkaisuu.TUKI, C_Hrkkeiro.KOUHURI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(4050), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(3200), "主契約Ｐ");

        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 1, "特約情報件数");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(0), BizCurrency.valueOf(850), "特約Ｐリスト[0]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(0), "ｵ2", "特約商品コードリスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(0), 2, "特約商品世代番号リスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(0), 3, "特約契約商品連番リスト[0]");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.SD, "Ｓ建Ｐ建区分");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 0), "ｵ1", "SP計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 1), "E01", "SP計算の１次呼出の料率世代番号");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 2), BizNumber.valueOf(1.0492), "SP計算の１次呼出の予定利率");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 3), C_Hrkkaisuu.TUKI, "SP計算の１次呼出の払込回数");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 4), 30, "SP計算の１次呼出の被保険者年齢");
        exClassificationEquals((C_Hhknsei)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 5), C_Hhknsei.MALE, "SP計算の１次呼出の被保険者性別");
        exClassificationEquals((C_HknkknsmnKbn)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 6), C_HknkknsmnKbn.SAIMANKI, "SP計算の１次呼出の保険期間歳満期区分");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 7), 70, "SP計算の１次呼出の保険期間");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 8), 20, "SP計算の１次呼出の払込期間");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 9), C_Sdpd.SD, "SP計算の１次呼出のＳ建Ｐ建区分");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 10), BizCurrency.valueOf(5000004), "SP計算の１次呼出の保険金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 11), BizCurrency.valueOf(2504), "SP計算の１次呼出の保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 12), C_Tuukasyu.JPY, "SP計算の１次呼出の契約通貨種類");
        exClassificationEquals((C_Kykjyoutai)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 13), C_Kykjyoutai.HRKMTYUU, "SP計算の１次呼出の契約状態");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 14), 1, "SP計算の１次呼出の第１保険期間");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 15), C_Hrkkeiro.KOUHURI, "SP計算の１次呼出の払込経路");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 0), "ｵ2", "SP計算の２次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 1), "E02", "SP計算の２次呼出の料率世代番号");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 2), BizNumber.valueOf(1.0473), "SP計算の２次呼出の予定利率");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 3), C_Hrkkaisuu.TUKI, "SP計算の２次呼出の払込回数");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 4), 31, "SP計算の２次呼出の被保険者年齢");
        exClassificationEquals((C_Hhknsei)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 5), C_Hhknsei.FEMALE, "SP計算の２次呼出の被保険者性別");
        exClassificationEquals((C_HknkknsmnKbn)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 6), C_HknkknsmnKbn.NENMANKI, "SP計算の２次呼出の保険期間歳満期区分");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 7), 39, "SP計算の２次呼出の保険期間");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 8), 15, "SP計算の２次呼出の払込期間");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 9), C_Sdpd.SD, "SP計算の２次呼出のＳ建Ｐ建区分");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 10), BizCurrency.valueOf(100004), "SP計算の２次呼出の保険金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 11), BizCurrency.valueOf(604), "SP計算の２次呼出の保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 12), C_Tuukasyu.USD, "SP計算の２次呼出の契約通貨種類");
        exClassificationEquals((C_Kykjyoutai)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 13), C_Kykjyoutai.HRKMTYUU, "SP計算の２次呼出の契約状態");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 14), 1, "SP計算の２次呼出の第１保険期間");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 15), C_Hrkkeiro.KOUHURI, "SP計算の２次呼出の払込経路");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();

        KeisanSPMock_KeisanHrhnNewHrkp.SYORIPTN = KeisanSPMock_KeisanHrhnNewHrkp.TESTPATTERN4;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono6);
        IT_KykSyouhn syuKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        List<IT_KykSyouhn> tkKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(
            syuKykSyouhn, tkKykSyouhn, C_Hrkkaisuu.HALFY, C_Hrkkaisuu.TUKI, C_Hrkkeiro.KOUHURI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(4230), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(3200), "主契約Ｐ");

        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 3, "特約情報件数");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(0), BizCurrency.valueOf(230), "特約Ｐリスト[0]");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(1), BizCurrency.valueOf(340), "特約Ｐリスト[1]");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(2), BizCurrency.valueOf(460), "特約Ｐリスト[2]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(0), "ｶ2", "特約商品コードリスト[0]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(1), "ｶ3", "特約商品コードリスト[1]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(2), "ｶ4", "特約商品コードリスト[2]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(0), 2, "特約商品世代番号リスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(1), 4, "特約商品世代番号リスト[1]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(2), 6, "特約商品世代番号リスト[2]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(0), 3, "特約契約商品連番リスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(1), 5, "特約契約商品連番リスト[1]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(2), 7, "特約契約商品連番リスト[2]");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.SD, "Ｓ建Ｐ建区分");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();

        KeisanSPMock_KeisanHrhnNewHrkp.SYORIPTN = KeisanSPMock_KeisanHrhnNewHrkp.TESTPATTERN5;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono7);
        IT_KykSyouhn syuKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        List<IT_KykSyouhn> tkKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(
            syuKykSyouhn, tkKykSyouhn, C_Hrkkaisuu.HALFY, C_Hrkkaisuu.TUKI, C_Hrkkeiro.KOUHURI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");

        assertNull("新払込保険料", keisanHrhnNewHrkp.getNewHrkp());
        assertNull("主契約Ｐ", keisanHrhnNewHrkp.getSyuP());
        assertNull( "特約Ｐリスト", keisanHrhnNewHrkp.getTkPList());
        assertNull("特約商品コードリスト", keisanHrhnNewHrkp.getTkSyouhnCdList());
        assertNull("特約商品世代番号リスト", keisanHrhnNewHrkp.getTkSyouhnSdnoList());
        assertNull("特約契約商品連番リスト", keisanHrhnNewHrkp.getTkKykSyouhnRennoList());
        assertNull("Ｓ建Ｐ建区分", keisanHrhnNewHrkp.getSdpd());
    }

    @Test
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();

        KeisanSPMock_KeisanHrhnNewHrkp.SYORIPTN = KeisanSPMock_KeisanHrhnNewHrkp.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono1);

        IT_KykSyouhn syuKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);
        List<IT_KykSyouhn> tkKykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(
            syuKykSyouhn, tkKykSyouhn, C_Hrkkaisuu.TUKI, C_Hrkkaisuu.TUKI, C_Hrkkeiro.KOUHURI);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");

        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(900), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(450), "主契約Ｐ");

        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 1, "特約情報件数");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(0), BizCurrency.valueOf(450), "特約Ｐリスト[0]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(0), "ﾕｲ", "特約商品コードリスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(0), 2, "特約商品世代番号リスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(0), 3, "特約契約商品連番リスト[0]");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.PD, "Ｓ建Ｐ建区分");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 0), "ﾕｱ", "SP計算の１次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 1), "A01", "SP計算の１次呼出の料率世代番号");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 2), BizNumber.valueOf(1.0605), "SP計算の１次呼出の予定利率");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 3), C_Hrkkaisuu.TUKI, "SP計算の１次呼出の払込回数");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 4), 45, "SP計算の１次呼出の被保険者年齢");
        exClassificationEquals((C_Hhknsei)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 5), C_Hhknsei.MALE, "SP計算の１次呼出の被保険者性別");
        exClassificationEquals((C_HknkknsmnKbn)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 6), C_HknkknsmnKbn.SAIMANKI, "SP計算の１次呼出の保険期間歳満期区分");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 7), 60, "SP計算の１次呼出の保険期間");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 8), 10, "SP計算の１次呼出の払込期間");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 9), C_Sdpd.PD, "SP計算の１次呼出のＳ建Ｐ建区分");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 10), BizCurrency.valueOf(5000000), "SP計算の１次呼出の保険金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 11), BizCurrency.valueOf(2500), "SP計算の１次呼出の保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 12), C_Tuukasyu.JPY, "SP計算の１次呼出の契約通貨種類");
        exClassificationEquals((C_Kykjyoutai)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 13), C_Kykjyoutai.HRKMTYUU, "SP計算の１次呼出の契約状態");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 14), 1, "SP計算の１次呼出の第１保険期間");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 0, 15), C_Hrkkeiro.KOUHURI, "SP計算の１次呼出の払込経路");

        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 0), "ﾕｲ", "SP計算の２次呼出の商品コード");
        exStringEquals((String)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 1), "A02", "SP計算の２次呼出の料率世代番号");
        exBizCalcbleEquals((BizNumber)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 2), BizNumber.valueOf(1.0585), "SP計算の２次呼出の予定利率");
        exClassificationEquals((C_Hrkkaisuu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 3), C_Hrkkaisuu.TUKI, "SP計算の２次呼出の払込回数");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 4), 46, "SP計算の２次呼出の被保険者年齢");
        exClassificationEquals((C_Hhknsei)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 5), C_Hhknsei.FEMALE, "SP計算の２次呼出の被保険者性別");
        exClassificationEquals((C_HknkknsmnKbn)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 6), C_HknkknsmnKbn.NENMANKI, "SP計算の２次呼出の保険期間歳満期区分");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 7), 61, "SP計算の２次呼出の保険期間");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 8), 11, "SP計算の２次呼出の払込期間");
        exClassificationEquals((C_Sdpd)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 9), C_Sdpd.SD, "SP計算の２次呼出のＳ建Ｐ建区分");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 10), BizCurrency.valueOf(100000), "SP計算の２次呼出の保険金額");
        exBizCalcbleEquals((BizCurrency)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 11), BizCurrency.valueOf(600), "SP計算の２次呼出の保険料");
        exClassificationEquals((C_Tuukasyu)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 12), C_Tuukasyu.USD, "SP計算の２次呼出の契約通貨種類");
        exClassificationEquals((C_Kykjyoutai)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 13), C_Kykjyoutai.HRKMTYUU, "SP計算の２次呼出の契約状態");
        exNumericEquals((int)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 14), 1, "SP計算の２次呼出の第１保険期間");
        exClassificationEquals((C_Hrkkeiro)MockObjectManager.getArgument(
            KeisanSPMock_KeisanHrhnNewHrkp.class, "exec", 1, 15), C_Hrkkeiro.KOUHURI, "SP計算の２次呼出の払込経路");
    }

    @Test
    @TestOrder(90)
    public void testExec_B1() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono8);
        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(kykKihon,C_TkiktbrisyuruiKbn.NONE);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(2500), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(2500), "主契約Ｐ");
        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 0, "特約情報件数");
        exListEquals(keisanHrhnNewHrkp.getTkSyouhnCdList(), new ArrayList<String>(), "特約商品コードリスト");
        exListEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList(), new ArrayList<Integer>(), "特約商品世代番号リスト");
        exListEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList(), new ArrayList<Integer>(), "特約契約商品連番リスト");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.PD, "Ｓ建Ｐ建区分");
    }

    @Test
    @TestOrder(100)
    public void testExec_B2() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono9);
        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(kykKihon,C_TkiktbrisyuruiKbn.NONE);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(1252), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(626), "主契約Ｐ");
        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 1, "特約情報件数");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(0), BizCurrency.valueOf(626), "特約Ｐリスト[0]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(0), "ｷ3", "特約商品コードリスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(0), 4, "特約商品世代番号リスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(0), 5, "特約契約商品連番リスト[0]");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.PD, "Ｓ建Ｐ建区分");
    }

    @Test
    @TestOrder(110)
    public void testExec_B3() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono10);
        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(kykKihon,C_TkiktbrisyuruiKbn.NONE);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(3745), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(2505), "主契約Ｐ");
        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 2, "特約情報件数");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(0), BizCurrency.valueOf(615), "特約Ｐリスト[0]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(0), "ｶ2", "特約商品コードリスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(0), 2, "特約商品世代番号リスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(0), 3, "特約契約商品連番リスト[0]");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(1), BizCurrency.valueOf(625), "特約Ｐリスト[1]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(1), "ｶ3", "特約商品コードリスト[1]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(1), 4, "特約商品世代番号リスト[1]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(1), 5, "特約契約商品連番リスト[1]");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getIktwaribikikgk(), BizCurrency.valueOf(0), "一括割引料");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.PD, "Ｓ建Ｐ建区分");
    }

    @Test
    @TestOrder(120)
    public void testExec_B4() {
        MockObjectManager.initialize();
        KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.SYORIPTN  = KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.TESTPATTERN1;
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono11);
        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(kykKihon,C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");

        KeisanIkkatuPGkBean bean = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 0, 0);
        exStringEquals(bean.getSyouhnCd(), "ﾕｱ", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品コード");
        exNumericEquals(bean.getSyouhnsdNo(), 1, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品世代番号");
        exStringEquals(bean.getRyouritusdNo(), "A01", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の料率世代番号");
        exBizCalcbleEquals(bean.getHokenryou(), BizCurrency.valueOf(2500), "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の保険料");
        exNumericEquals(bean.getKeikamon(), 6, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の経過月数");
        exClassificationEquals(bean.getHrkkaisuu(), C_Hrkkaisuu.HALFY, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の払込回数");
        exClassificationEquals(bean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の定期一括払種類区分");
        MockObjectManager.assertArgumentPassed(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 1, false);
    }

    @Test
    @TestOrder(130)
    public void testExec_B5() {
        MockObjectManager.initialize();
        KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.SYORIPTN  = "";
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono12);
        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(kykKihon,C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");

        KeisanIkkatuPGkBean bean = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 0, 0);
        exStringEquals(bean.getSyouhnCd(), "ｷ1", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品コード");
        exNumericEquals(bean.getSyouhnsdNo(), 1, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品世代番号");
        exStringEquals(bean.getRyouritusdNo(), "G03", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の料率世代番号");
        exBizCalcbleEquals(bean.getHokenryou(), BizCurrency.valueOf(626), "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の保険料");
        exNumericEquals(bean.getKeikamon(), 6, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の経過月数");
        exClassificationEquals(bean.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の払込回数");
        exClassificationEquals(bean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の定期一括払種類区分");
        MockObjectManager.assertArgumentPassed(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 1, false);
    }

    @Test
    @TestOrder(140)
    public void testExec_B6() {
        MockObjectManager.initialize();
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono13);
        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(kykKihon,C_TkiktbrisyuruiKbn.TEIKI_6MONTHS);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.ERROR, "結果区分");

        KeisanIkkatuPGkBean bean = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 0, 0);
        exStringEquals(bean.getSyouhnCd(), "ｶ1", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品コード");
        exNumericEquals(bean.getSyouhnsdNo(), 1, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品世代番号");
        exStringEquals(bean.getRyouritusdNo(), "F01", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の料率世代番号");
        exBizCalcbleEquals(bean.getHokenryou(), BizCurrency.valueOf(2505), "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の保険料");
        exNumericEquals(bean.getKeikamon(), 6, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の経過月数");
        exClassificationEquals(bean.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の払込回数");
        exClassificationEquals(bean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の定期一括払種類区分");
        MockObjectManager.assertArgumentPassed(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 1, false);

        KeisanIkkatuPGkBean bean2 = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 1, 0);
        exStringEquals(bean2.getSyouhnCd(), "ｶ2", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品コード");
        exNumericEquals(bean2.getSyouhnsdNo(), 2, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品世代番号");
        exStringEquals(bean2.getRyouritusdNo(), "F02", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の料率世代番号");
        exBizCalcbleEquals(bean2.getHokenryou(), BizCurrency.valueOf(615), "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の保険料");
        exNumericEquals(bean2.getKeikamon(), 6, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の経過月数");
        exClassificationEquals(bean2.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の払込回数");
        exClassificationEquals(bean2.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_6MONTHS, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の定期一括払種類区分");
        MockObjectManager.assertArgumentPassed(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 1, false);
    }

    @Test
    @TestOrder(150)
    public void testExec_B7() {
        MockObjectManager.initialize();
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono14);
        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(kykKihon,C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(80), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(80), "主契約Ｐ");
        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 0, "特約情報件数");
        exListEquals(keisanHrhnNewHrkp.getTkSyouhnCdList(), new ArrayList<String>(), "特約商品コードリスト");
        exListEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList(), new ArrayList<Integer>(), "特約商品世代番号リスト");
        exListEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList(), new ArrayList<Integer>(), "特約契約商品連番リスト");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getIktwaribikikgk(), BizCurrency.valueOf(90), "一括割引料");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.PD, "Ｓ建Ｐ建区分");

        KeisanIkkatuPGkBean bean = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 0, 0);
        exStringEquals(bean.getSyouhnCd(), "ﾕｱ", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品コード");
        exNumericEquals(bean.getSyouhnsdNo(), 1, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品世代番号");
        exStringEquals(bean.getRyouritusdNo(), "A01", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の料率世代番号");
        exBizCalcbleEquals(bean.getHokenryou(), BizCurrency.valueOf(2500), "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の保険料");
        exNumericEquals(bean.getKeikamon(), 12, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の経過月数");
        exClassificationEquals(bean.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の払込回数");
        exClassificationEquals(bean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の定期一括払種類区分");
        MockObjectManager.assertArgumentPassed(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 1, false);
    }

    @Test
    @TestOrder(160)
    public void testExec_B8() {
        MockObjectManager.initialize();
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono15);
        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(kykKihon,C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(160), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(80), "主契約Ｐ");
        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 1, "特約情報件数");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(0), BizCurrency.valueOf(80), "特約Ｐリスト[0]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(0), "ｷ2", "特約商品コードリスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(0), 4, "特約商品世代番号リスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(0), 5, "特約契約商品連番リスト[0]");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getIktwaribikikgk(), BizCurrency.valueOf(46), "一括割引料");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.PD, "Ｓ建Ｐ建区分");

        KeisanIkkatuPGkBean bean = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 0, 0);
        exStringEquals(bean.getSyouhnCd(), "ｷ1", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品コード");
        exNumericEquals(bean.getSyouhnsdNo(), 1, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品世代番号");
        exStringEquals(bean.getRyouritusdNo(), "G03", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の料率世代番号");
        exBizCalcbleEquals(bean.getHokenryou(), BizCurrency.valueOf(626), "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の保険料");
        exNumericEquals(bean.getKeikamon(), 12, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の経過月数");
        exClassificationEquals(bean.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の払込回数");
        exClassificationEquals(bean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の定期一括払種類区分");
        MockObjectManager.assertArgumentPassed(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 1, false);
    }

    @Test
    @TestOrder(170)
    public void testExec_B9() {
        MockObjectManager.initialize();
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono16);
        C_ErrorKbn kekkaKbn = keisanHrhnNewHrkp.exec(kykKihon,C_TkiktbrisyuruiKbn.TEIKI_12MONTHS);

        exClassificationEquals(kekkaKbn, C_ErrorKbn.OK, "結果区分");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getNewHrkp(), BizCurrency.valueOf(240), "新払込保険料");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getSyuP(), BizCurrency.valueOf(80), "主契約Ｐ");
        exNumericEquals(keisanHrhnNewHrkp.getTkPList().size(), 2, "特約情報件数");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(0), BizCurrency.valueOf(80), "特約Ｐリスト[0]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(0), "ｶ2", "特約商品コードリスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(0), 2, "特約商品世代番号リスト[0]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(0), 3, "特約契約商品連番リスト[0]");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getTkPList().get(1), BizCurrency.valueOf(80), "特約Ｐリスト[1]");
        exStringEquals(keisanHrhnNewHrkp.getTkSyouhnCdList().get(1), "ｶ3", "特約商品コードリスト[1]");
        exNumericEquals(keisanHrhnNewHrkp.getTkSyouhnSdnoList().get(1), 4, "特約商品世代番号リスト[1]");
        exNumericEquals(keisanHrhnNewHrkp.getTkKykSyouhnRennoList().get(1), 5, "特約契約商品連番リスト[1]");
        exBizCalcbleEquals(keisanHrhnNewHrkp.getIktwaribikikgk(), BizCurrency.valueOf(137), "一括割引料");
        exClassificationEquals(keisanHrhnNewHrkp.getSdpd(), C_Sdpd.PD, "Ｓ建Ｐ建区分");

        KeisanIkkatuPGkBean bean = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 0, 0);
        exStringEquals(bean.getSyouhnCd(), "ｶ1", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品コード");
        exNumericEquals(bean.getSyouhnsdNo(), 1, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品世代番号");
        exStringEquals(bean.getRyouritusdNo(), "F01", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の料率世代番号");
        exBizCalcbleEquals(bean.getHokenryou(), BizCurrency.valueOf(2505), "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の保険料");
        exNumericEquals(bean.getKeikamon(), 12, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の経過月数");
        exClassificationEquals(bean.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の払込回数");
        exClassificationEquals(bean.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の定期一括払種類区分");
        MockObjectManager.assertArgumentPassed(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 1, false);

        KeisanIkkatuPGkBean bean2 = (KeisanIkkatuPGkBean)MockObjectManager.getArgument(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 1, 0);
        exStringEquals(bean2.getSyouhnCd(), "ｶ2", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品コード");
        exNumericEquals(bean2.getSyouhnsdNo(), 2, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の商品世代番号");
        exStringEquals(bean2.getRyouritusdNo(), "F02", "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の料率世代番号");
        exBizCalcbleEquals(bean2.getHokenryou(), BizCurrency.valueOf(615), "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の保険料");
        exNumericEquals(bean2.getKeikamon(), 12, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の経過月数");
        exClassificationEquals(bean2.getHrkkaisuu(), C_Hrkkaisuu.TUKI, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の払込回数");
        exClassificationEquals(bean2.getTkiktbrisyuruiKbn(), C_TkiktbrisyuruiKbn.TEIKI_12MONTHS, "払変新払込Ｐ計算（定期一括払種類区分指定）＃メイン処理の呼出の定期一括払種類区分");
        MockObjectManager.assertArgumentPassed(KeisanIkkatuPGkMock_KeisanHrhnNewHrkp.class, "exec", 1, false);
    }
}
