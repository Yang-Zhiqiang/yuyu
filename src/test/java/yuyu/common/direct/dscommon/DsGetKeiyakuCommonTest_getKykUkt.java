package yuyu.common.direct.dscommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.common.hozen.khcommon.GetKhKykdrInfo;
import yuyu.common.hozen.khcommon.GetKhKykdrInfoMockForDirect;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GkdtKoktuutiUktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * ＤＳ契約共通情報取得クラスのメソッド {@link DsGetKeiyakuCommon#getKykUkt()} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class DsGetKeiyakuCommonTest_getKykUkt {

    private final static String SYONO1 = "11807111118";

    private final static String SYONO2 = "11807111129";

    private final static String SYONO3 = "11807111130";

    private final static String SYONO4 = "11807111141";

    private final static String SYONO5 = "11807111152";

    private final static String SYONO6 = "11807111163";

    private final static String SYONO7 = "11807111174";

    private final static String SYONO8 = "11807111185";

    private final static String SYONO9 = "11807111196";

    private final static String SYONO10 = "11807111200";

    private final static String SYONO11 = "11807111211";

    private final static String SYONO12 = "11807111222";

    private final static String SYONO13 = "11807111233";

    private final static String SYONO14 = "11807111244";

    private final static String SYONO15 = "11807111255";

    private final static String SYONO16 = "11807111266";

    @Inject
    private DsGetKeiyakuCommon dsGetKeiyakuCommon;

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_ＤＳ契約共通情報取得";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(GetKhKykdrInfo.class).to(GetKhKykdrInfoMockForDirect.class);
            }
        });
    }

    @BeforeClass
    @Transactional
    public static void testInit() {

        GetKhKykdrInfoMockForDirect.caller = DsGetKeiyakuCommonTest_getKykUkt.class;
    }

    @AfterClass
    public static void testClear() {

        MockObjectManager.initialize();

        GetKhKykdrInfoMockForDirect.caller = null;
        GetKhKykdrInfoMockForDirect.SYORIPTN = null;

    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(DsGetKeiyakuCommonTest_getKykUkt.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ004", testDataAndTblMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testGetKykUkt_A1() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO1);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(20)
    public void testGetKykUkt_A2() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO2);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(), C_ErrorKbn.OK, "結果区分");
    }

    @Test
    @TestOrder(30)
    public void testGetKykUkt_A3() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO3);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  3,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.SYOUKENGORAN,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.BLNK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.BLNK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }

    @Test
    @TestOrder(40)
    public void testGetKykUkt_A4() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO4);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  2,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.KYK,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "受取人カナ名０４２", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.BLNK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }

    @Test
    @TestOrder(50)
    public void testGetKykUkt_A5() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO5);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  2,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.KYK,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.BLNK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }

    @Test
    @TestOrder(60)
    public void testGetKykUkt_A6() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO6);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  1,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.KYK,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.BLNK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.BLNK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }

    @Test
    @TestOrder(70)
    public void testGetKykUkt_A7() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO7);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  1,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.HHKN,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.BLNK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.BLNK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }

    @Test
    @TestOrder(80)
    public void testGetKykUkt_A8() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO8);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  1,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.SOUZOKU,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.BLNK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.BLNK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }

    @Test
    @TestOrder(90)
    public void testGetKykUkt_A9() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO9);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  1,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "受取人カナ名０９", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.BLNK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.BLNK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }

    @Test
    @TestOrder(100)
    public void testGetKykUkt_A10() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO10);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  1,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.BLNK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.BLNK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }

    @Test
    @TestOrder(110)
    public void testGetKykUkt_A11() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO11);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  0,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.NKUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.KYK,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.NKUKT,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.HHKN,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.NKUKT,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }

    @Test
    @TestOrder(120)
    public void testGetKykUkt_A12() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO12);


        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  2,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.KYK,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.KYK,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "契約者カナ名１２", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "受取人カナ名１２４", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "受取人カナ名１２３", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "トウロクカゾクイチ", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "トウロクカゾクニ", "受取人名１０");
    }
    @Test
    @TestOrder(130)
    public void testGetKykUkt_A13() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO13);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }
    @Test
    @TestOrder(140)
    public void testGetKykUkt_A14() {
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO14);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(), C_ErrorKbn.ERROR, "結果区分");
    }

    @Test
    @TestOrder(150)
    public void testGetKykUkt_A15() {
        GetKhKykdrInfoMockForDirect.SYORIPTN = GetKhKykdrInfoMockForDirect.TESTPATTERN1;
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO15);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  0,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "ケイヤクダイリニン", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.BLNK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.BLNK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }

    @Test
    @TestOrder(160)
    public void testGetKykUkt_A16() {
        GetKhKykdrInfoMockForDirect.SYORIPTN = GetKhKykdrInfoMockForDirect.TESTPATTERN1;
        KeiyakuUketorininBean keiyakuUketorininBean = dsGetKeiyakuCommon.getKykUkt(SYONO16);

        exClassificationEquals(keiyakuUketorininBean.getErrorKbn(),  C_ErrorKbn.OK,  "結果区分");
        exNumericEquals(keiyakuUketorininBean.getSbuktnin(),  5,  "死亡受取人人数");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn1(),  C_UktsyuKbn.SBUKT,  "受取人見出し区分１");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn1(),  C_GkdtKoktuutiUktKbn.SYOUKENGORAN,  "受取人区分１");
        exStringEquals(keiyakuUketorininBean.getUktNm1(), "", "受取人名１");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn2(),  C_UktsyuKbn.KYKDRN,  "受取人見出し区分２");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn2(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分２");
        exStringEquals(keiyakuUketorininBean.getUktNm2(), "", "受取人名２");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn3(),  C_UktsyuKbn.STDRSK,  "受取人見出し区分３");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn3(),  C_GkdtKoktuutiUktKbn.NASI,  "受取人区分３");
        exStringEquals(keiyakuUketorininBean.getUktNm3(), "", "受取人名３");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn4(),  C_UktsyuKbn.BLNK,  "受取人見出し区分４");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn4(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分４");
        exStringEquals(keiyakuUketorininBean.getUktNm4(), "", "受取人名４");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn5(),  C_UktsyuKbn.BLNK,  "受取人見出し区分５");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn5(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分５");
        exStringEquals(keiyakuUketorininBean.getUktNm5(), "", "受取人名５");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn6(),  C_UktsyuKbn.BLNK,  "受取人見出し区分６");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn6(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分６");
        exStringEquals(keiyakuUketorininBean.getUktNm6(), "", "受取人名６");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn7(),  C_UktsyuKbn.BLNK,  "受取人見出し区分７");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn7(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分７");
        exStringEquals(keiyakuUketorininBean.getUktNm7(), "", "受取人名７");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn8(),  C_UktsyuKbn.BLNK,  "受取人見出し区分８");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn8(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分８");
        exStringEquals(keiyakuUketorininBean.getUktNm8(), "", "受取人名８");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn9(),  C_UktsyuKbn.BLNK,  "受取人見出し区分９");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn9(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分９");
        exStringEquals(keiyakuUketorininBean.getUktNm9(), "", "受取人名９");
        exClassificationEquals(keiyakuUketorininBean.getUktsyuKbn10(),  C_UktsyuKbn.BLNK,  "受取人見出し区分１０");
        exClassificationEquals(keiyakuUketorininBean.getGkdtKoktuutiUktKbn10(),  C_GkdtKoktuutiUktKbn.BLNK,  "受取人区分１０");
        exStringEquals(keiyakuUketorininBean.getUktNm10(), "", "受取人名１０");
    }
}
