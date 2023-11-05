package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;

import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.TestOrder;

/**
 * 死亡保険金受取人情報設定のメソッド{@link SetSbHkukt#init(SetSbHkuktExecUiBeanParam)}
                                      テスト用クラスです。<br />
 */
public class SetSbHkuktTest_init {

    private SetSbHkuktExecUiBeanParamImpl setSbHkuktExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        setSbHkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetSbHkuktExecUiBeanParamImpl.class);
        SetSbHkukt.init(setSbHkuktExecUiBeanParamImpl);
        exNumericEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbuktnin(), 0,
            "(死亡保険金受取人情報)死亡受取人人数");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbhkuktumu(), C_UmuKbn.NONE,
            "(死亡保険金受取人情報) 死亡保険金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbkyuuhukinuktumu(), C_UmuKbn.NONE,
            "(死亡保険金受取人情報) 死亡給付金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn1(), C_UktKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人区分１");
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
    public void testInit_A2() {
        setSbHkuktExecUiBeanParamImpl = SWAKInjector.getInstance(SetSbHkuktExecUiBeanParamImpl.class);
        setSbHkuktExecUiBeanParamImpl.setVshktsbuktnin(1);
        setSbHkuktExecUiBeanParamImpl.setVshktsbhkuktumu(C_UmuKbn.ARI);
        setSbHkuktExecUiBeanParamImpl.setVshktsbkyuuhukinuktumu(C_UmuKbn.ARI);
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktkbn1(C_UktKbn.HHKN);
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkn1("受取人カナ１１");
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkj1("受取人漢字１１");
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkjhukakbn1(C_KjkhukaKbn.KJKHUKA);
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktseiymd1(BizDate.valueOf(20141101));
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktbnwari1(BizNumber.valueOf(25));
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktkbn2(C_UktKbn.HHKN);
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkn2("受取人カナ２２");
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkj2("受取人漢字２２");
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkjhukakbn2(C_KjkhukaKbn.KJKHUKA);
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktseiymd2(BizDate.valueOf(20141101));
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktbnwari2(BizNumber.valueOf(15));
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktkbn3(C_UktKbn.HHKN);
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkn3("受取人カナ３３");
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkj3("受取人漢字３３");
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkjhukakbn3(C_KjkhukaKbn.KJKHUKA);
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktseiymd3(BizDate.valueOf(20141201));
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktbnwari3(BizNumber.valueOf(35));
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktkbn4(C_UktKbn.HHKN);
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkn4("受取人カナ４４");
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkj4("受取人漢字４４");
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktnmkjhukakbn4(C_KjkhukaKbn.KJKHUKA);
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktseiymd4(BizDate.valueOf(20140901));
        setSbHkuktExecUiBeanParamImpl.setVshktdispsbuktbnwari4(BizNumber.valueOf(10));

        SetSbHkukt.init(setSbHkuktExecUiBeanParamImpl);
        exNumericEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbuktnin(), 0,
            "(死亡保険金受取人情報)死亡受取人人数");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbhkuktumu(), C_UmuKbn.NONE,
            "(死亡保険金受取人情報) 死亡保険金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktsbkyuuhukinuktumu(), C_UmuKbn.NONE,
            "(死亡保険金受取人情報) 死亡給付金受取有無");
        exClassificationEquals(setSbHkuktExecUiBeanParamImpl.getVshktdispsbuktkbn1(), C_UktKbn.BLNK,
            "(死亡保険金受取人情報)死亡受取人区分１");
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

        MockObjectManager.initialize();
    }

}
