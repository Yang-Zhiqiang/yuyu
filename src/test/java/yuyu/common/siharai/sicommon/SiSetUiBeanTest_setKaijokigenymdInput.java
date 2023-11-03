package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.viewkaijokigenymdinput.ViewKaijokigenymdInputUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setKaijokigenymdInput(CommonViewUiBeanParam, JT_SateiKaijyoInfo)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setKaijokigenymdInput {

    @Test
    @TestOrder(10)
    public void testSetKaijokigenymdInput_A1() {

        JT_SateiKaijyoInfo sateiKaijyoInfo = new JT_SateiKaijyoInfo();
        CommonViewUiBeanParam commonViewUiBeanParam = null;
        SiSetUiBean.setKaijokigenymdInput(commonViewUiBeanParam, sateiKaijyoInfo);

        assertNull(commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetKaijokigenymdInput_A2() {

        ViewKaijokigenymdInputUiBeanParamImpl viewKaijokigenymdInputUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKaijokigenymdInputUiBeanParamImpl.class);
        viewKaijokigenymdInputUiBeanParamImpl.setKaijokigenymd(BizDate.valueOf(20160301));

        JT_SateiKaijyoInfo sateiKaijyoInfo = null;

        SiSetUiBean.setKaijokigenymdInput(viewKaijokigenymdInputUiBeanParamImpl, sateiKaijyoInfo);

        exDateEquals(viewKaijokigenymdInputUiBeanParamImpl.getKaijokigenymd(), null, "解除期限日");

    }

    @Test
    @TestOrder(30)
    public void testSetKaijokigenymdInput_A3() {

        ViewKaijokigenymdInputUiBeanParamImpl viewKaijokigenymdInputUiBeanParamImpl = SWAKInjector
            .getInstance(ViewKaijokigenymdInputUiBeanParamImpl.class);
        viewKaijokigenymdInputUiBeanParamImpl.setKaijokigenymd(BizDate.valueOf(20160301));

        JT_SateiKaijyoInfo sateiKaijyoInfo = new JT_SateiKaijyoInfo();
        sateiKaijyoInfo.setKaijokigenymd(BizDate.valueOf(20150301));

        SiSetUiBean.setKaijokigenymdInput(viewKaijokigenymdInputUiBeanParamImpl, sateiKaijyoInfo);

        exDateEquals(viewKaijokigenymdInputUiBeanParamImpl.getKaijokigenymd(), BizDate.valueOf(20150301), "解除期限日");

    }

    @Test
    @TestOrder(40)
    public void testSetKaijokigenymdInput_A4() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSkno("1002");

        JT_SateiKaijyoInfo sateiKaijyoInfo = new JT_SateiKaijyoInfo();
        sateiKaijyoInfo.setSkno("2002");

        SiSetUiBean.setKaijokigenymdInput(viewSkKihonUiBeanParamImpl, sateiKaijyoInfo);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSkno(), "1002", "請求番号");

    }

}
