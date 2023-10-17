package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全手続履歴テーブルエンティティ情報取得(変更識別キー)<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getKhTtdkRirekiByHenkousikibetukey {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("10000000001");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("10", "10000000001");

            IT_KhTtdkRireki khTtdkRireki = kykKihon1.getKhTtdkRirekiByHenkousikibetukey("20121029090201511");
            Assert.assertEquals(null, khTtdkRireki);

            IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki1.setHenkousikibetukey("20121029090201511");

            IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("20121029090201512");

            hozenDomManager.insert(kykKihon1);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000001");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20121029090201513");
        Assert.assertEquals(null, khTtdkRireki);

    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000001");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20121029090201511");
        Assert.assertEquals("10", khTtdkRireki.getKbnkey());
        Assert.assertEquals("10000000001", khTtdkRireki.getSyono());
        Assert.assertEquals("20121029090201511", khTtdkRireki.getHenkousikibetukey());

    }

    @Test
    @TestOrder(30)
    public void blank1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000001");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("");
        Assert.assertEquals(null, khTtdkRireki);

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void update1() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000001");
        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey("20121029090201511");
        List<IT_KhHenkouRireki> khHenkouRirekiLst = khTtdkRireki.getKhHenkouRirekis();
        Assert.assertEquals(0, khHenkouRirekiLst.size());

        IT_KhHenkouRireki khHenkouRireki = khTtdkRireki.createKhHenkouRireki();
        khHenkouRireki.setRenno3keta(1);
        hozenDomManager.update(kykKihon);

        khHenkouRirekiLst = khTtdkRireki.getKhHenkouRirekis();
        Assert.assertEquals(1, khHenkouRirekiLst.size());
        Assert.assertEquals("10", khHenkouRirekiLst.get(0).getKbnkey());
        Assert.assertEquals("10000000001", khHenkouRirekiLst.get(0).getSyono());
        Assert.assertEquals("20121029090201511", khHenkouRirekiLst.get(0).getHenkousikibetukey());
        Assert.assertEquals(Integer.valueOf(1), khHenkouRirekiLst.get(0).getRenno3keta());

    }

}
