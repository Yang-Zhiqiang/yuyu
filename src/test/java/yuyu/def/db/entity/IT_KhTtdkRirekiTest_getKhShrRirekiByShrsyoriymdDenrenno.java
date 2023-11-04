package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約商品履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KhTtdkRirekiTest_getKhShrRirekiByShrsyoriymdDenrenno {

    @Inject
    private HozenDomManager hozenDomManager;


    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon("11807111118");

        IT_KhTtdkRireki iT_KhTtdkRireki1 = iT_KykKihon1.createKhTtdkRireki();
        iT_KhTtdkRireki1.setHenkousikibetukey("11111");

        Assert.assertEquals(null, iT_KhTtdkRireki1.getKhShrRirekiByShrsyoriymdDenrenno(
                BizDate.valueOf(20160824),"111111"));


        IT_KhShrRireki khShrRireki1 = iT_KhTtdkRireki1.createKhShrRireki();
        khShrRireki1.setShrsyoriymd(BizDate.valueOf(20160824));
        khShrRireki1.setDenrenno("111111");

        IT_KhTtdkRireki iT_KhTtdkRireki2 = iT_KykKihon1.createKhTtdkRireki();
        iT_KhTtdkRireki2.setHenkousikibetukey("11112");

        IT_KhShrRireki khShrRireki2 = iT_KhTtdkRireki2.createKhShrRireki();
        khShrRireki2.setShrsyoriymd(BizDate.valueOf(20160825));
        khShrRireki2.setDenrenno("111111");

        IT_KhTtdkRireki iT_KhTtdkRireki3 = iT_KykKihon1.createKhTtdkRireki();
        iT_KhTtdkRireki3.setHenkousikibetukey("11113");

        IT_KhShrRireki khShrRireki3 = iT_KhTtdkRireki3.createKhShrRireki();
        khShrRireki3.setShrsyoriymd(BizDate.valueOf(20160824));
        khShrRireki3.setDenrenno("111112");

        hozenDomManager.insert(iT_KykKihon1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_KykKihon iT_KykKihon1 = hozenDomManager.getKykKihon("11807111118");

        IT_KhTtdkRireki iT_KhTtdkRireki1 = iT_KykKihon1.getKhTtdkRirekiByHenkousikibetukey("11111");

        IT_KhShrRireki iT_KhShrRireki1 = iT_KhTtdkRireki1.getKhShrRirekiByShrsyoriymdDenrenno
                (BizDate.valueOf(20150824),"333333");

        Assert.assertEquals(null, iT_KhShrRireki1);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon iT_KykKihon1 = hozenDomManager.getKykKihon("11807111118");

        IT_KhTtdkRireki iT_KhTtdkRireki1 = iT_KykKihon1.getKhTtdkRirekiByHenkousikibetukey("11111");

        IT_KhShrRireki iT_KhShrRireki1 = iT_KhTtdkRireki1.getKhShrRirekiByShrsyoriymdDenrenno
                ( BizDate.valueOf(20160824),"111111");

        Assert.assertEquals("01", iT_KhShrRireki1.getKbnkey());
        Assert.assertEquals("11807111118", iT_KhShrRireki1.getSyono());
        Assert.assertEquals("11111", iT_KhShrRireki1.getHenkousikibetukey());
    }

    @Test
    @TestOrder(40)
    public void normal3() {

        IT_KykKihon iT_KykKihon1 = hozenDomManager.getKykKihon("11807111118");

        IT_KhTtdkRireki iT_KhTtdkRireki1 = iT_KykKihon1.getKhTtdkRirekiByHenkousikibetukey("11111");

        IT_KhShrRireki iT_KhShrRireki1 = iT_KhTtdkRireki1.getKhShrRirekiByShrsyoriymdDenrenno
                (BizDate.valueOf(20160824),"");

        Assert.assertEquals(null, iT_KhShrRireki1);
    }
}
