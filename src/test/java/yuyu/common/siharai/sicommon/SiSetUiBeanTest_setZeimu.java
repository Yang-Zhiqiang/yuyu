package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.common.siharai.siview.viewzeimuinfo.ViewZeimuInfoUiBeanParamImpl;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_Sk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setZeimu(CommonViewUiBeanParam, JT_SiRireki, JT_Sk)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setZeimu {

    @Test
    @TestOrder(10)
    public void testSetZeimu_A1() {

        CommonViewUiBeanParam commonViewUiBeanParam = null;
        JT_SiRireki siRireki = new JT_SiRireki();
        JT_Sk sk = new JT_Sk();
        SiSetUiBean.setZeimu(commonViewUiBeanParam, siRireki, sk);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetZeimu_A2() {

        ViewZeimuInfoUiBeanParamImpl viewZeimuInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewZeimuInfoUiBeanParamImpl.class);
        viewZeimuInfoUiBeanParamImpl.setZeitratkikbn(C_ZeitratkiKbn.BLNK);
        viewZeimuInfoUiBeanParamImpl.setGoukeihituyoukeihi(BizCurrency.valueOf(10));

        JT_SiRireki siRireki = null;

        JT_Sk sk = null;

        SiSetUiBean.setZeimu(viewZeimuInfoUiBeanParamImpl, siRireki, sk);

        exClassificationEquals(viewZeimuInfoUiBeanParamImpl.getZeitratkikbn(), null, "税取扱区分");
        exBizCalcbleEquals(viewZeimuInfoUiBeanParamImpl.getGoukeihituyoukeihi(), null, "合計必要経費");

    }

    @Test
    @TestOrder(30)
    public void testSetZeimu_A3() {

        ViewZeimuInfoUiBeanParamImpl viewZeimuInfoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewZeimuInfoUiBeanParamImpl.class);
        viewZeimuInfoUiBeanParamImpl.setZeitratkikbn(C_ZeitratkiKbn.BLNK);
        viewZeimuInfoUiBeanParamImpl.setGoukeihituyoukeihi(BizCurrency.valueOf(10));

        JT_SiRireki siRireki = new JT_SiRireki();
        siRireki.setZeitratkikbn(C_ZeitratkiKbn.ITIJI);

        JT_Sk sk = new JT_Sk();
        sk.setGoukeihituyoukeihi(BizCurrency.valueOf(20));
        sk.setKykhnkkaisuu(1);
        sk.setShrkykhtykeihi(BizCurrency.valueOf(55));

        SiSetUiBean.setZeimu(viewZeimuInfoUiBeanParamImpl, siRireki, sk);

        exClassificationEquals(viewZeimuInfoUiBeanParamImpl.getZeitratkikbn(), C_ZeitratkiKbn.ITIJI, "税取扱区分");
        exBizCalcbleEquals(viewZeimuInfoUiBeanParamImpl.getGoukeihituyoukeihi(), BizCurrency.valueOf(20), "合計必要経費");
        exNumericEquals(viewZeimuInfoUiBeanParamImpl.getKykhnkkaisuu(), 1, "契約者変更回数");
        exBizCalcbleEquals(viewZeimuInfoUiBeanParamImpl.getShrkykhtykeihi(), BizCurrency.valueOf(55), "支払時契約者必要経費");

    }

    @Test
    @TestOrder(40)
    public void testSetZeimu_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_SiRireki siRireki = new JT_SiRireki();
        siRireki.setSkno("2001");
        JT_Sk sk = new JT_Sk();
        sk.setSkno("2003");

        SiSetUiBean.setZeimu(viewSkKihonUiBeanParamImpl, siRireki, sk);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

        MockObjectManager.initialize();

    }

}
