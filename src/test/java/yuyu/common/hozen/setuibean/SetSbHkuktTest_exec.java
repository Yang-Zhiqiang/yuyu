package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 死亡保険金受取人情報設定のメソッド{@link SetSbHkukt#exec(KhozenCommonParam, SetSbHkuktExecUiBeanParam)}
                                     テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSbHkuktTest_exec {

    private final static String dSyono1 = "12806345672";
    private final static String dSyono2 = "12806345683";
    private final static String dSyono3 = "12806345694";
    private final static String dSyono4 = "12806345708";
    private final static String dSyono5 = "12806345719";

    private KhozenCommonParam khozenCommonParam;
    private SetSbHkuktExecUiBeanParamImpl setSbHkuktExecUiBeanParamImpl;

    private final static String fileName = "UT_SP_単体テスト仕様書_死亡保険金受取人情報設定";
    private final static String sheetName = "テストデータ";

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {

            TestDataMaker testDataMaker = new TestDataMaker();

            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;

            testDataAndTblMap = testDataMaker.getInData(SetSbHkuktTest_exec.class, fileName, sheetName);

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
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono1));
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono2));
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono3));
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono4));
        hozenDomManager.delete(hozenDomManager.getKykKihon(dSyono5));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("5001",1));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("5002",2));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("5003",3));
        bizDomManager.delete(bizDomManager.getSyouhnZokusei("5004",4));
    }

    @Test
    @TestOrder(10)
    public void testExec_A1() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setSbHkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetSbHkuktExecUiBeanParamImpl.class);
        setSbHkuktExecUiBeanParamImpl.setSyono(dSyono1);
        boolean syorikeka = SetSbHkukt.exec(khozenCommonParam, setSbHkuktExecUiBeanParamImpl);
        exBooleanEquals(syorikeka, true, "処理結果");
        exNumericEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbuktnin(), 0,
            "(死亡保険金受取人情報)死亡受取人人数");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbhkuktumu(), C_UmuKbn.NONE,
            "死亡保険金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbkyuuhukinuktumu(), C_UmuKbn.NONE,
            "死亡給付金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn1(), C_UktKbn.BLNK,
            "(死亡保険金受取人情報)（表示用）死亡受取人区分１");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn1(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）１");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj1(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）１");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn1(), C_KjkhukaKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分１");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd1(), null,
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日１");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari1(),BizNumber.optional(),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合１");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn2(), C_UktKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人区分２");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn2(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）２");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj2(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）２");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn2(), C_KjkhukaKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分２");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd2(), null,
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日２");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari2(),BizNumber.optional(),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合２");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn3(), C_UktKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人区分３");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn3(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）３");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj3(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）３");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn3(), C_KjkhukaKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分３");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd3(), null,
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日３");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari3(),BizNumber.optional(),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合３");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn4(), C_UktKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人区分４");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn4(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）４");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj4(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）４");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn4(), C_KjkhukaKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分４");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd4(), null,
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日４");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari4(),BizNumber.optional(),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合４");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setSbHkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetSbHkuktExecUiBeanParamImpl.class);
        setSbHkuktExecUiBeanParamImpl.setSyono(dSyono2);
        boolean syorikeka = SetSbHkukt.exec(khozenCommonParam, setSbHkuktExecUiBeanParamImpl);
        exBooleanEquals(syorikeka, true, "処理結果");
        exNumericEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbuktnin(), 1,
            "(死亡保険金受取人情報)死亡受取人人数");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbhkuktumu(), C_UmuKbn.ARI,
            "死亡保険金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbkyuuhukinuktumu(), C_UmuKbn.ARI,
            "死亡給付金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn1(), C_UktKbn.HHKN,
            "(死亡保険金受取人情報)（表示用）死亡受取人区分１");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn1(), "受取人カナ１",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）１");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj1(), "受取人漢字１",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）１");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn1(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分１");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd1(), BizDate.valueOf(20151001),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日１");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari1(),BizNumber.valueOf(100),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合１");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn2(), C_UktKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人区分２");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn2(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）２");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj2(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）２");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn2(), C_KjkhukaKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分２");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd2(), null,
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日２");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari2(),BizNumber.optional(),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合２");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn3(), C_UktKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人区分３");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn3(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）３");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj3(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）３");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn3(), C_KjkhukaKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分３");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd3(), null,
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日３");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari3(),BizNumber.optional(),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合３");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn4(), C_UktKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人区分４");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn4(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）４");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj4(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）４");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn4(), C_KjkhukaKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分４");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd4(), null,
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日４");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari4(),BizNumber.optional(),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合４");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setSbHkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetSbHkuktExecUiBeanParamImpl.class);
        setSbHkuktExecUiBeanParamImpl.setSyono(dSyono3);
        boolean syorikeka = SetSbHkukt.exec(khozenCommonParam, setSbHkuktExecUiBeanParamImpl);
        exBooleanEquals(syorikeka, true, "処理結果");
        exNumericEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbuktnin(), 3,
            "(死亡保険金受取人情報)死亡受取人人数");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbhkuktumu(), C_UmuKbn.ARI,
            "死亡保険金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbkyuuhukinuktumu(), C_UmuKbn.ARI,
            "死亡給付金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn1(), C_UktKbn.KYK,
            "(死亡保険金受取人情報)（表示用）死亡受取人区分１");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn1(), "受取人カナ１",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）１");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj1(), "受取人漢字１",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）１");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn1(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分１");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd1(), BizDate.valueOf(20151001),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日１");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari1(),BizNumber.valueOf(65),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合１");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn2(), C_UktKbn.HHKN,
            "(死亡保険金受取人情報)死亡受取人区分２");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn2(), "受取人カナ２",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）２");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj2(), "受取人漢字２",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）２");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn2(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分２");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd2(), BizDate.valueOf(20151101),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日２");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari2(),BizNumber.valueOf(20),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合２");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn3(), C_UktKbn.STDRNIN,
            "(死亡保険金受取人情報)死亡受取人区分３");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn3(), "受取人カナ３",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）３");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj3(), "受取人漢字３",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）３");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn3(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分３");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd3(), BizDate.valueOf(20151201),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日３");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari3(),BizNumber.valueOf(15),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合３");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn4(), C_UktKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人区分４");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn4(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）４");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj4(), "",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）４");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn4(), C_KjkhukaKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分４");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd4(), null,
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日４");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari4(),BizNumber.optional(),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合４");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setSbHkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetSbHkuktExecUiBeanParamImpl.class);
        setSbHkuktExecUiBeanParamImpl.setSyono(dSyono4);
        boolean syorikeka = SetSbHkukt.exec(khozenCommonParam, setSbHkuktExecUiBeanParamImpl);
        exBooleanEquals(syorikeka, true, "処理結果");
        exNumericEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbuktnin(), 4,
            "(死亡保険金受取人情報)死亡受取人人数");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbhkuktumu(), C_UmuKbn.ARI,
            "死亡保険金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbkyuuhukinuktumu(), C_UmuKbn.ARI,
            "死亡給付金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn1(), C_UktKbn.KYK,
            "(死亡保険金受取人情報)（表示用）死亡受取人区分１");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn1(), "受取人カナ１",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）１");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj1(), "受取人漢字１",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）１");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn1(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分１");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd1(), BizDate.valueOf(20151001),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日１");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari1(),BizNumber.valueOf(55),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合１");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn2(), C_UktKbn.HHKN,
            "(死亡保険金受取人情報)死亡受取人区分２");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn2(), "受取人カナ２",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）２");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj2(), "受取人漢字２",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）２");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn2(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分２");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd2(), BizDate.valueOf(20151101),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日２");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari2(),BizNumber.valueOf(25),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合２");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn3(), C_UktKbn.STDRNIN,
            "(死亡保険金受取人情報)死亡受取人区分３");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn3(), "受取人カナ３",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）３");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj3(), "受取人漢字３",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）３");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn3(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分３");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd3(), BizDate.valueOf(20151201),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日３");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari3(),BizNumber.valueOf(15),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合３");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn4(), C_UktKbn.HUKUSUU,
            "(死亡保険金受取人情報)死亡受取人区分４");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn4(), "受取人カナ４",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）４");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj4(), "受取人漢字４",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）４");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn4(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分４");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd4(), BizDate.valueOf(20150901),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日４");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari4(),BizNumber.valueOf(5),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合４");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {
        khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        setSbHkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetSbHkuktExecUiBeanParamImpl.class);
        setSbHkuktExecUiBeanParamImpl.setSyono(dSyono5);
        boolean syorikeka = SetSbHkukt.exec(khozenCommonParam, setSbHkuktExecUiBeanParamImpl);
        exBooleanEquals(syorikeka, true, "処理結果");
        exNumericEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbuktnin(), 5,
            "(死亡保険金受取人情報)死亡受取人人数");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbhkuktumu(), C_UmuKbn.ARI,
            "死亡保険金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbkyuuhukinuktumu(), C_UmuKbn.ARI,
            "死亡給付金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn1(), C_UktKbn.KYK,
            "(死亡保険金受取人情報)（表示用）死亡受取人区分１");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn1(), "受取人カナ１１",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）１");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj1(), "受取人漢字１１",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）１");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn1(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分１");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd1(), BizDate.valueOf(20141001),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日１");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari1(),BizNumber.valueOf(25),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合１");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn2(), C_UktKbn.HHKN,
            "(死亡保険金受取人情報)死亡受取人区分２");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn2(), "受取人カナ２２",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）２");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj2(), "受取人漢字２２",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）２");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn2(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分２");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd2(), BizDate.valueOf(20141101),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日２");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari2(),BizNumber.valueOf(15),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合２");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn3(), C_UktKbn.STDRNIN,
            "(死亡保険金受取人情報)死亡受取人区分３");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn3(), "受取人カナ３３",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）３");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj3(), "受取人漢字３３",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）３");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn3(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分３");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd3(), BizDate.valueOf(20141201),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日３");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari3(),BizNumber.valueOf(35),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合３");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn4(), C_UktKbn.HUKUSUU,
            "(死亡保険金受取人情報)死亡受取人区分４");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkn4(), "受取人カナ４４",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（カナ）４");
        exStringEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkj4(), "受取人漢字４４",
            "(死亡保険金受取人情報)（表示用）死亡受取人氏名（漢字）４");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktnmkjhukakbn4(), C_KjkhukaKbn.KJKHUKA,
            "(死亡保険金受取人情報)死亡受取人氏名漢字化不可区分４");
        exDateEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktseiymd4(), BizDate.valueOf(20140901),
            "(死亡保険金受取人情報)（表示用）死亡受取人生年月日４");
        exBizCalcbleEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktbnwari4(),BizNumber.valueOf(10),
            "(死亡保険金受取人情報)（表示用）死亡受取人分割割合４");
    }
}
