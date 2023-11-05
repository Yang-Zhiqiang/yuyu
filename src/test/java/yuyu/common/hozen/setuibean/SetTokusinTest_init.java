package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_TokusinKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 特伸情報設定クラスのメソッド {@link SetTokusin#init(SetTokusinExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetTokusinTest_init {

    @Inject
    private SetTokusinExecUiBeanParamImpl setTokusinExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setTokusinExecUiBeanParamImpl = SWAKInjector.getInstance(SetTokusinExecUiBeanParamImpl.class);

        SetTokusin.init(setTokusinExecUiBeanParamImpl);

        exClassificationEquals(setTokusinExecUiBeanParamImpl.getVtsumukbn(), C_UmuKbn.NONE, "（特伸情報）有無区分");
        exDateEquals(setTokusinExecUiBeanParamImpl.getVtshsgymd(), null, "被災害年月日");
        exDateEquals(setTokusinExecUiBeanParamImpl.getVtstokusinendymd(), null, "終了年月日");
        exClassificationEquals(setTokusinExecUiBeanParamImpl.getVtstokusinkbn(), C_TokusinKbn.BLNK, "特伸区分");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {

        setTokusinExecUiBeanParamImpl = SWAKInjector.getInstance(SetTokusinExecUiBeanParamImpl.class);

        setTokusinExecUiBeanParamImpl.setVtsumukbn(C_UmuKbn.ARI);
        setTokusinExecUiBeanParamImpl.setVtshsgymd(BizDate.valueOf(20181001));
        setTokusinExecUiBeanParamImpl.setVtstokusinendymd(BizDate.valueOf(20181031));
        setTokusinExecUiBeanParamImpl.setVtstokusinkbn(C_TokusinKbn.HISAIGAI);

        SetTokusin.init(setTokusinExecUiBeanParamImpl);

        exClassificationEquals(setTokusinExecUiBeanParamImpl.getVtsumukbn(), C_UmuKbn.NONE, "（特伸情報）有無区分");
        exDateEquals(setTokusinExecUiBeanParamImpl.getVtshsgymd(), null, "被災害年月日");
        exDateEquals(setTokusinExecUiBeanParamImpl.getVtstokusinendymd(), null, "終了年月日");
        exClassificationEquals(setTokusinExecUiBeanParamImpl.getVtstokusinkbn(), C_TokusinKbn.BLNK, "特伸区分");
    }
}
