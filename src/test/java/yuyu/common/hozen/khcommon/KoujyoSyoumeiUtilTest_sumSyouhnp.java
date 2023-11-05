package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 控除証明ユーティリティクラスのメソッド {@link KoujyoSyoumeiUtil#sumSyouhnp(List<KykSyouhnCommonParam>)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class KoujyoSyoumeiUtilTest_sumSyouhnp {

    @Inject
    private KoujyoSyoumeiUtil koujyoSyoumeiUtil;

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();

    }

    @Test
    @TestOrder(10)
    public void testSumSyouhnp_A1(){

        List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = new ArrayList<>();
        BizCurrency keip = koujyoSyoumeiUtil.sumSyouhnp(kykSyouhnCommonParamLst);
        exBizCalcbleEquals(keip, BizCurrency.valueOf(0), "合計保険料");
    }

    @Test
    @TestOrder(20)
    public void testSumSyouhnp_A2(){

        List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = new ArrayList<>();
        KykSyouhnCommonParamTest kykSyouhnCommonParam = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam.setHokenryou(BizCurrency.valueOf(10000));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam);
        BizCurrency keip = koujyoSyoumeiUtil.sumSyouhnp(kykSyouhnCommonParamLst);
        exBizCalcbleEquals(keip, BizCurrency.valueOf(10000), "合計保険料");
    }

    @Test
    @TestOrder(30)
    public void testSumSyouhnp_A3(){

        List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = new ArrayList<>();
        KykSyouhnCommonParamTest kykSyouhnCommonParam1 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam1.setHokenryou(BizCurrency.valueOf(10000));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam1);

        KykSyouhnCommonParamTest kykSyouhnCommonParam2 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam2.setHokenryou(BizCurrency.valueOf(20000));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam2);

        KykSyouhnCommonParamTest kykSyouhnCommonParam3 = SWAKInjector.getInstance(KykSyouhnCommonParamTest.class);
        kykSyouhnCommonParam3.setHokenryou(BizCurrency.valueOf(30000));
        kykSyouhnCommonParamLst.add(kykSyouhnCommonParam3);

        BizCurrency keip = koujyoSyoumeiUtil.sumSyouhnp(kykSyouhnCommonParamLst);
        exBizCalcbleEquals(keip, BizCurrency.valueOf(60000), "合計保険料");
    }

}
