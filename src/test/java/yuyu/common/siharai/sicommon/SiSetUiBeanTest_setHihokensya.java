package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.ViewHihokensyaSyouninTorikesiUiBeanParamImpl;
import yuyu.common.siharai.siview.viewhihokensya.ViewHihokensyaUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setHihokensya(CommonViewUiBeanParam, JT_SiKykKihon)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setHihokensya {

    @Test
    @TestOrder(10)
    public void testSetHihokensya_A1() {

        CommonViewUiBeanParam commonViewUiBeanParam = null;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        SiSetUiBean.setHihokensya(commonViewUiBeanParam, siKykKihon);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetHihokensya_A2() {

        ViewHihokensyaUiBeanParamImpl viewHihokensyaUiBeanParamImpl = SWAKInjector
            .getInstance(ViewHihokensyaUiBeanParamImpl.class);
        viewHihokensyaUiBeanParamImpl.setHhknnmkn("AAA");

        JT_SiKykKihon siKykKihon = null;

        SiSetUiBean.setHihokensya(viewHihokensyaUiBeanParamImpl, siKykKihon);

        exStringEquals(viewHihokensyaUiBeanParamImpl.getHhknnmkn(), "AAA", "被保険者名（カナ）");

    }

    @Test
    @TestOrder(30)
    public void testSetHihokensya_A3() {

        ViewHihokensyaUiBeanParamImpl viewHihokensyaUiBeanParamImpl = SWAKInjector
            .getInstance(ViewHihokensyaUiBeanParamImpl.class);
        viewHihokensyaUiBeanParamImpl.setHhknnmkn("AAA");
        viewHihokensyaUiBeanParamImpl.setHhknnmkj("BBB");
        viewHihokensyaUiBeanParamImpl.setHhknseiymd(BizDate.valueOf(20160301));
        viewHihokensyaUiBeanParamImpl.setMskmjskjhknnen("11");
        viewHihokensyaUiBeanParamImpl.setHhknsei(C_Hhknsei.BLNK);

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setHhknnmkn("CCC");
        siKykKihon.setHhknnmkj("DDD");
        siKykKihon.setHhknseiymd(BizDate.valueOf(20150301));
        siKykKihon.setHhknsei(C_Hhknsei.MALE);

        SiSetUiBean.setHihokensya(viewHihokensyaUiBeanParamImpl, siKykKihon);

        exStringEquals(viewHihokensyaUiBeanParamImpl.getHhknnmkn(), "CCC", "被保険者名（カナ）");
        exStringEquals(viewHihokensyaUiBeanParamImpl.getHhknnmkj(), "DDD", "被保険者名（漢字）");
        exDateEquals(viewHihokensyaUiBeanParamImpl.getHhknseiymd(), BizDate.valueOf(20150301), "被保険者生年月日");
        exStringEquals(viewHihokensyaUiBeanParamImpl.getMskmjskjhknnen(), null, "申込時請求時被保険者年齢");
        exClassificationEquals(viewHihokensyaUiBeanParamImpl.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");

    }

    @Test
    @TestOrder(40)
    public void testSetHihokensya_A4() {

        ViewHihokensyaSyouninTorikesiUiBeanParamImpl viewHihokensyaSyouninTorikesiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewHihokensyaSyouninTorikesiUiBeanParamImpl.class);
        viewHihokensyaSyouninTorikesiUiBeanParamImpl.setHhknnmkn("AAA");
        viewHihokensyaSyouninTorikesiUiBeanParamImpl.setHhknnmkj("BBB");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setHhknnmkn("CCC");
        siKykKihon.setHhknnmkj("DDD");

        SiSetUiBean.setHihokensya(viewHihokensyaSyouninTorikesiUiBeanParamImpl, siKykKihon);

        exStringEquals(viewHihokensyaSyouninTorikesiUiBeanParamImpl.getHhknnmkn(), "CCC", "被保険者名（カナ）");
        exStringEquals(viewHihokensyaSyouninTorikesiUiBeanParamImpl.getHhknnmkj(), "DDD", "被保険者名（漢字）");


    }

    @Test
    @TestOrder(50)
    public void testSetHihokensya_A5() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSyono("1002");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("2001");

        SiSetUiBean.setHihokensya(viewSkKihonUiBeanParamImpl, siKykKihon);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSyono(), "1002", "証券番号");

    }


}
