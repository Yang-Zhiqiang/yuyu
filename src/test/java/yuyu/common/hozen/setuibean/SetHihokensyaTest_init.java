package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 被保険者情報設定クラスのメソッド {@link SetHihokensya#init(SetHihokensyaExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHihokensyaTest_init {

    private SetHihokensyaExecUiBeanParamImpl setHihokensyaExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        setHihokensyaExecUiBeanParamImpl = SWAKInjector.getInstance(SetHihokensyaExecUiBeanParamImpl.class);

        SetHihokensya.init(setHihokensyaExecUiBeanParamImpl);

        exStringEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknnmkn(), "", "（被保険者情報）被保険者名（カナ）");
        exStringEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknnmkj(), "", "（被保険者情報）被保険者名（漢字）");
        exClassificationEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "（被保険者情報）被保険者名漢字化不可区分");
        exDateEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknseiymd(), null, "（被保険者情報）被保険者生年月日");
        exClassificationEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknsei(), C_Hhknsei.BLNK, "（被保険者情報）被保険者性別");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        setHihokensyaExecUiBeanParamImpl = SWAKInjector.getInstance(SetHihokensyaExecUiBeanParamImpl.class);

        setHihokensyaExecUiBeanParamImpl.setVhhkshhknnmkn("カナ");

        setHihokensyaExecUiBeanParamImpl.setVhhkshhknnmkj("山田");

        setHihokensyaExecUiBeanParamImpl.setVhhkshhknnmkjkhukakbn(C_KjkhukaKbn.KJKHUKA);

        setHihokensyaExecUiBeanParamImpl.setVhhkshhknseiymd(BizDate.valueOf("20151222"));

        setHihokensyaExecUiBeanParamImpl.setVhhkshhknsei(C_Hhknsei.MALE);

        SetHihokensya.init(setHihokensyaExecUiBeanParamImpl);

        exStringEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknnmkn(), "", "（被保険者情報）被保険者名（カナ）");
        exStringEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknnmkj(), "", "（被保険者情報）被保険者名（漢字）");
        exClassificationEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknnmkjkhukakbn(), C_KjkhukaKbn.BLNK, "（被保険者情報）被保険者名漢字化不可区分");
        exDateEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknseiymd(), null, "（被保険者情報）被保険者生年月日");
        exClassificationEquals(setHihokensyaExecUiBeanParamImpl.getVhhkshhknsei(), C_Hhknsei.BLNK, "（被保険者情報）被保険者性別");

        MockObjectManager.initialize();
    }
}
