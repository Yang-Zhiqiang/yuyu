package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import javax.inject.Inject;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HaitoukinuketorihouKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 配当金情報設定クラスのメソッド {@link SetHaitoukin#init(SetHaitoukinExecUiBeanParam)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetHaitoukinTest_init {

    @Inject
    private SetHaitoukin setHaitoukin;

    @Inject
    private SetHaitoukinExecUiBeanParamImpl setHaitoukinExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {

        setHaitoukinExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaitoukinExecUiBeanParamImpl.class);

        setHaitoukin.init(setHaitoukinExecUiBeanParamImpl);

        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.BLNK, "（配当金情報）配当金受取方法区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitounendo(), null, "（配当金情報）配当年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttounendod(), BizCurrency.optional(), "（配当金情報）当年度Ｄ");
        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.BLNK, "（配当金情報）内定確定区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatenendo(), null, "（配当金情報）積立年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitated(), BizCurrency.optional(), "（配当金情報）積立Ｄ");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedtumitateymd(), null, "（配当金情報）積立Ｄ積立年月日");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedshrkrkymd(), null, "（配当金情報）積立Ｄ支払効力日");
    }

    @Test
    @TestOrder(40)
    public void testInit_A2() {

        setHaitoukinExecUiBeanParamImpl = SWAKInjector.getInstance(SetHaitoukinExecUiBeanParamImpl.class);
        setHaitoukinExecUiBeanParamImpl.setVhthaitoukinuketorihoukbn(C_HaitoukinuketorihouKbn.TUMIHAI);
        setHaitoukinExecUiBeanParamImpl.setVhthaitounendo(BizDateY.valueOf(2018));
        setHaitoukinExecUiBeanParamImpl.setVhttounendod(BizCurrency.valueOf(300000000));
        setHaitoukinExecUiBeanParamImpl.setVhtnaiteikakuteikbn(C_NaiteiKakuteiKbn.NAITEI);
        setHaitoukinExecUiBeanParamImpl.setVhttumitatenendo(BizDateY.valueOf(2019));
        setHaitoukinExecUiBeanParamImpl.setVhttumitated(BizCurrency.valueOf(400000000));
        setHaitoukinExecUiBeanParamImpl.setVhttumitatedtumitateymd(BizDate.valueOf(20181019));
        setHaitoukinExecUiBeanParamImpl.setVhttumitatedshrkrkymd(BizDate.valueOf(20181023));
        setHaitoukin.init(setHaitoukinExecUiBeanParamImpl);

        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitoukinuketorihoukbn(), C_HaitoukinuketorihouKbn.BLNK, "（配当金情報）配当金受取方法区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhthaitounendo(), null, "（配当金情報）配当年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttounendod(), BizCurrency.optional(), "（配当金情報）当年度Ｄ");
        exClassificationEquals(setHaitoukinExecUiBeanParamImpl.getVhtnaiteikakuteikbn(), C_NaiteiKakuteiKbn.BLNK, "（配当金情報）内定確定区分");
        exDateYEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatenendo(), null, "（配当金情報）積立年度");
        exBizCalcbleEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitated(), BizCurrency.optional(), "（配当金情報）積立Ｄ");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedtumitateymd(), null, "（配当金情報）積立Ｄ積立年月日");
        exDateEquals(setHaitoukinExecUiBeanParamImpl.getVhttumitatedshrkrkymd(), null, "（配当金情報）積立Ｄ支払効力日");
    }

}
