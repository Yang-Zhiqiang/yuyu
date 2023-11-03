package yuyu.common.siharai.sicommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;
import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzview.CommonViewUiBeanParam;
import yuyu.common.siharai.siview.ViewSouhusakiSindansyoUiBeanParamImpl;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParamImpl;
import yuyu.common.siharai.siview.viewsouhusaki.ViewSouhusakiUiBeanParamImpl;
import yuyu.def.classification.C_SouhusakiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払共通UiBean設定のメソッド{@link SiSetUiBean#setSouhusakiKykAdr(CommonViewUiBeanParam, JT_SiKykKihon)} テスト用クラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class SiSetUiBeanTest_setSouhusakiKykAdr {

    @Test
    @TestOrder(10)
    public void testSetSouhusakiKykAdr_A1() {

        CommonViewUiBeanParam commonViewUiBeanParam = null;
        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        SiSetUiBean.setSouhusakiKykAdr(commonViewUiBeanParam, siKykKihon);

        assertNull("呼出元UiBean", commonViewUiBeanParam);

    }

    @Test
    @TestOrder(20)
    public void testSetSouhusakiKykAdr_A2() {

        ViewSouhusakiSindansyoUiBeanParamImpl viewSouhusakiSindansyoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSouhusakiSindansyoUiBeanParamImpl.class);
        viewSouhusakiSindansyoUiBeanParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);

        JT_SiKykKihon siKykKihon = null;

        SiSetUiBean.setSouhusakiKykAdr(viewSouhusakiSindansyoUiBeanParamImpl, siKykKihon);

        exClassificationEquals(viewSouhusakiSindansyoUiBeanParamImpl.getSouhusakikbn(), C_SouhusakiKbn.TDADD, "送付先区分");

    }

    @Test
    @TestOrder(30)
    public void testSetSouhusakiKykAdr_A3() {

        ViewSouhusakiSindansyoUiBeanParamImpl viewSouhusakiSindansyoUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSouhusakiSindansyoUiBeanParamImpl.class);
        viewSouhusakiSindansyoUiBeanParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADD);
        viewSouhusakiSindansyoUiBeanParamImpl.setTsinyno("1001");
        viewSouhusakiSindansyoUiBeanParamImpl.setTsinadr1kj("東京都");
        viewSouhusakiSindansyoUiBeanParamImpl.setTsinadr2kj("上野");
        viewSouhusakiSindansyoUiBeanParamImpl.setTsinadr3kj("條62-1");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTsinyno("2001");
        siKykKihon.setTsinadr1kj("大阪");
        siKykKihon.setTsinadr2kj("市内");
        siKykKihon.setTsinadr3kj("町201");

        SiSetUiBean.setSouhusakiKykAdr(viewSouhusakiSindansyoUiBeanParamImpl, siKykKihon);

        exClassificationEquals(viewSouhusakiSindansyoUiBeanParamImpl.getSouhusakikbn(), C_SouhusakiKbn.TDADD, "送付先区分");
        exStringEquals(viewSouhusakiSindansyoUiBeanParamImpl.getTsinyno(), "2001", "通信先郵便番号");
        exStringEquals(viewSouhusakiSindansyoUiBeanParamImpl.getTsinadr1kj(), "大阪", "通信先住所１（漢字）");
        exStringEquals(viewSouhusakiSindansyoUiBeanParamImpl.getTsinadr2kj(), "市内", "通信先住所２（漢字）");
        exStringEquals(viewSouhusakiSindansyoUiBeanParamImpl.getTsinadr3kj(), "町201", "通信先住所３（漢字）");

    }

    @Test
    @TestOrder(40)
    public void testSetSouhusakiKykAdr_A4() {

        ViewSouhusakiUiBeanParamImpl viewSouhusakiUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSouhusakiUiBeanParamImpl.class);
        viewSouhusakiUiBeanParamImpl.setSouhusakikbn(C_SouhusakiKbn.TDADDIGAI);
        viewSouhusakiUiBeanParamImpl.setTsinyno("0001");
        viewSouhusakiUiBeanParamImpl.setTsinadr1kj("北海道");
        viewSouhusakiUiBeanParamImpl.setTsinadr2kj("関内");
        viewSouhusakiUiBeanParamImpl.setTsinadr3kj("西條3-2-1");
        viewSouhusakiUiBeanParamImpl.setTsintelno("08072648888");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setTsinyno("3001");
        siKykKihon.setTsinadr1kj("横浜");
        siKykKihon.setTsinadr2kj("町田");
        siKykKihon.setTsinadr3kj("町44-1-56");
        siKykKihon.setTsintelno("0901234567");

        SiSetUiBean.setSouhusakiKykAdr(viewSouhusakiUiBeanParamImpl, siKykKihon);

        exClassificationEquals(viewSouhusakiUiBeanParamImpl.getSouhusakikbn(), C_SouhusakiKbn.TDADDIGAI, "送付先区分");
        exStringEquals(viewSouhusakiUiBeanParamImpl.getTsinyno(), "3001", "通信先郵便番号");
        exStringEquals(viewSouhusakiUiBeanParamImpl.getTsinadr1kj(), "横浜", "通信先住所１（漢字）");
        exStringEquals(viewSouhusakiUiBeanParamImpl.getTsinadr2kj(), "町田", "通信先住所２（漢字）");
        exStringEquals(viewSouhusakiUiBeanParamImpl.getTsinadr3kj(), "町44-1-56", "通信先住所３（漢字）");
        exStringEquals(viewSouhusakiUiBeanParamImpl.getTsintelno(), "0901234567", "通信先電話番号");

    }

    @Test
    @TestOrder(50)
    public void testSetSouhusakiKykAdr_A5() {

        ViewSkKihonUiBeanParamImpl viewSkKihonUiBeanParamImpl = SWAKInjector
            .getInstance(ViewSkKihonUiBeanParamImpl.class);
        viewSkKihonUiBeanParamImpl.setSyono("1002");

        JT_SiKykKihon siKykKihon = new JT_SiKykKihon();
        siKykKihon.setSyono("2001");

        SiSetUiBean.setSouhusakiKykAdr(viewSkKihonUiBeanParamImpl, siKykKihon);

        exStringEquals(viewSkKihonUiBeanParamImpl.getSyono(), "1002", "証券番号");

    }

}
