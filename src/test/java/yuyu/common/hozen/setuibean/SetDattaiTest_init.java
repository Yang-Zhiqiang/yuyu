package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DattairiyuuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 脱退情報設定クラスのメソッド {@link SetDattai#init(SetDattaiExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetDattaiTest_init {

    @Inject
    private SetDattaiExecUiBeanParamImpl setDattaiExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setDattaiExecUiBeanParamImpl = SWAKInjector.getInstance(SetDattaiExecUiBeanParamImpl.class);

        SetDattai.init(setDattaiExecUiBeanParamImpl);

        exClassificationEquals(setDattaiExecUiBeanParamImpl.getVdtumukbn(), C_UmuKbn.NONE, "（脱退情報）有無区分");
        exDateEquals(setDattaiExecUiBeanParamImpl.getVdtdattaisyoriymd(), null, "脱退処理日");
        exClassificationEquals(setDattaiExecUiBeanParamImpl.getVdtdattairiyuukbn(), C_DattairiyuuKbn.BLNK, "脱退理由区分");
        exStringEquals(setDattaiExecUiBeanParamImpl.getVdtcomment(), "", "コメント");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        setDattaiExecUiBeanParamImpl = SWAKInjector.getInstance(SetDattaiExecUiBeanParamImpl.class);

        setDattaiExecUiBeanParamImpl.setVdtumukbn(C_UmuKbn.ARI);
        setDattaiExecUiBeanParamImpl.setVdtdattaisyoriymd(BizDate.valueOf(20181019));
        setDattaiExecUiBeanParamImpl.setVdtdattairiyuukbn(C_DattairiyuuKbn.CSSKOUHURIIRHUBI);
        setDattaiExecUiBeanParamImpl.setVdtcomment("コメント（１２４桁）コメント（１２４桁）");

        SetDattai.init(setDattaiExecUiBeanParamImpl);

        exClassificationEquals(setDattaiExecUiBeanParamImpl.getVdtumukbn(), C_UmuKbn.NONE, "（脱退情報）有無区分");
        exDateEquals(setDattaiExecUiBeanParamImpl.getVdtdattaisyoriymd(), null, "脱退処理日");
        exClassificationEquals(setDattaiExecUiBeanParamImpl.getVdtdattairiyuukbn(), C_DattairiyuuKbn.BLNK, "脱退理由区分");
        exStringEquals(setDattaiExecUiBeanParamImpl.getVdtcomment(), "", "コメント");
    }
}
