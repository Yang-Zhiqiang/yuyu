package yuyu.common.hozen.setuibean;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 被保険者代理人情報設定のメソッド{@link SetSiteiseikyuu#init(SetSiteiseikyuuExecUiBeanParam)}
                                   テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SetSiteiseikyuuTest_init {
    private SetSiteiseikyuuExecUiBeanParamImpl setSiteiseikyuuExecUiBeanParamImpl;

    @Test
    @TestOrder(10)
    public void testInit_A1() {
        setSiteiseikyuuExecUiBeanParamImpl = SWAKInjector.getInstance(SetSiteiseikyuuExecUiBeanParamImpl.class);
        SetSiteiseikyuu.init(setSiteiseikyuuExecUiBeanParamImpl);

        exClassificationEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstsksiteidruktkbn(), C_UktKbn.BLNK,
            "（指定代理請求人情報）指定代理受取人区分");

        exStringEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkn(), "",
            "（指定代理請求人情報）指定代理請求人名（カナ）");

        exStringEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkj(), "",
            "(（指定代理請求人情報）指定代理請求人名（漢字）");

        exClassificationEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkjhukakbn(), C_KjkhukaKbn.BLNK,
            "（指定代理請求人情報）指定代理請求人名漢字化不可区分");

        exDateEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrskseiymd(), null,
                "（指定代理請求人情報）指定代理請求人生年月日");
    }

    @Test
    @TestOrder(20)
    public void testInit_A2() {
        setSiteiseikyuuExecUiBeanParamImpl = SWAKInjector.getInstance(SetSiteiseikyuuExecUiBeanParamImpl.class);

        setSiteiseikyuuExecUiBeanParamImpl.setVstsksiteidruktkbn(C_UktKbn.STDRNIN);

        setSiteiseikyuuExecUiBeanParamImpl.setVstskstdrsknmkn( "アイウエオ");

        setSiteiseikyuuExecUiBeanParamImpl.setVstskstdrsknmkj("１２３４５");

        setSiteiseikyuuExecUiBeanParamImpl.setVstskstdrsknmkjhukakbn( C_KjkhukaKbn.KJKHUKA);

        setSiteiseikyuuExecUiBeanParamImpl.setVstskstdrskseiymd(BizDate.valueOf("19751229"));

        SetSiteiseikyuu.init(setSiteiseikyuuExecUiBeanParamImpl);

        exClassificationEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstsksiteidruktkbn(), C_UktKbn.BLNK,
            "（指定代理請求人情報）指定代理受取人区分");

        exStringEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkn(), "",
            "（指定代理請求人情報）指定代理請求人名（カナ）");

        exStringEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkj(), "",
            "(（指定代理請求人情報）指定代理請求人名（漢字）");

        exClassificationEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrsknmkjhukakbn(), C_KjkhukaKbn.BLNK,
            "（指定代理請求人情報）指定代理請求人名漢字化不可区分");

        exDateEquals(setSiteiseikyuuExecUiBeanParamImpl.getVstskstdrskseiymd(), null,
                "（指定代理請求人情報）指定代理請求人生年月日");

        MockObjectManager.initialize();
    }
}
