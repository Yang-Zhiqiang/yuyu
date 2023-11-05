package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約内容のお知らせ編集クラスのメソッド {@link EditKykNaiyouOsirase#getKawaseRateBean(BizDate)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class EditKykNaiyouOsiraseTest_getKawaseRateBean {

    @Test
    @TestOrder(10)
    public void testEditKykNaiyouOsirase_B1() {

        MockObjectManager.initialize();

        EditKykNaiyouOsirase editKykNaiyouOsirase = SWAKInjector.getInstance(EditKykNaiyouOsirase.class);

        BizDate syoriYmd = BizDate.valueOf(20180101);

        KawaseRateBean kawaseRateBean = editKykNaiyouOsirase.getKawaseRateBean(syoriYmd);

        exBizCalcbleEquals(kawaseRateBean.getKwsrateUsdjpy1mae(), BizNumber.valueOf(122.04), "為替レート米ドル１ヶ月前");
        exDateEquals(kawaseRateBean.getKwsrateKijyunymd1mae(), BizDate.valueOf(20171201), "為替レート基準日１ヶ月前");
        exBizCalcbleEquals(kawaseRateBean.getKwsrateAudjpy1mae(), BizNumber.valueOf(89.25), "為替レート豪ドル１ヶ月前");

        exBizCalcbleEquals(kawaseRateBean.getKwsrateUsdjpy2mae(), BizNumber.valueOf(121.84), "為替レート米ドル２ヶ月前");
        exDateEquals(kawaseRateBean.getKwsrateKijyunymd2mae(), BizDate.valueOf(20171101), "為替レート基準日２ヶ月前");
        exBizCalcbleEquals(kawaseRateBean.getKwsrateAudjpy2mae(), BizNumber.valueOf(89.05), "為替レート豪ドル２ヶ月前");

        exBizCalcbleEquals(kawaseRateBean.getKwsrateUsdjpy3mae(), BizNumber.valueOf(121.63), "為替レート米ドル３ヶ月前");
        exDateEquals(kawaseRateBean.getKwsrateKijyunymd3mae(), BizDate.valueOf(20171002), "為替レート基準日３ヶ月前");
        exBizCalcbleEquals(kawaseRateBean.getKwsrateAudjpy3mae(), BizNumber.valueOf(88.84), "為替レート豪ドル３ヶ月前");

        exBizCalcbleEquals(kawaseRateBean.getKwsrateUsdjpy4mae(), BizNumber.valueOf(121.43), "為替レート米ドル４ヶ月前");
        exDateEquals(kawaseRateBean.getKwsrateKijyunymd4mae(), BizDate.valueOf(20170901), "為替レート基準日４ヶ月前");
        exBizCalcbleEquals(kawaseRateBean.getKwsrateAudjpy4mae(), BizNumber.valueOf(88.64), "為替レート豪ドル４ヶ月前");

        exBizCalcbleEquals(kawaseRateBean.getKwsrateUsdjpy5mae(), BizNumber.valueOf(121.21), "為替レート米ドル５ヶ月前");
        exDateEquals(kawaseRateBean.getKwsrateKijyunymd5mae(), BizDate.valueOf(20170801), "為替レート基準日５ヶ月前");
        exBizCalcbleEquals(kawaseRateBean.getKwsrateAudjpy5mae(), BizNumber.valueOf(88.42), "為替レート豪ドル５ヶ月前");

        exBizCalcbleEquals(kawaseRateBean.getKwsrateUsdjpy6mae(), BizNumber.valueOf(121.01), "為替レート米ドル６ヶ月前");
        exDateEquals(kawaseRateBean.getKwsrateKijyunymd6mae(), BizDate.valueOf(20170703), "為替レート基準日６ヶ月前");
        exBizCalcbleEquals(kawaseRateBean.getKwsrateAudjpy6mae(), BizNumber.valueOf(88.22), "為替レート豪ドル６ヶ月前");

        exBizCalcbleEquals(kawaseRateBean.getKwsrateUsdjpy7mae(), BizNumber.valueOf(120.79), "為替レート米ドル７ヶ月前");
        exDateEquals(kawaseRateBean.getKwsrateKijyunymd7mae(), BizDate.valueOf(20170601), "為替レート基準日７ヶ月前");
        exBizCalcbleEquals(kawaseRateBean.getKwsrateAudjpy7mae(), BizNumber.valueOf(88), "為替レート豪ドル７ヶ月前");

    }

}