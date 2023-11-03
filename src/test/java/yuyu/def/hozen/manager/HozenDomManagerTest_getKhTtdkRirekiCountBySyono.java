package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全手続履歴テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhTtdkRirekiCountBySyono {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Long count = hozenDomManager.getKhTtdkRirekiCountBySyono("11807111118");
        Assert.assertEquals(new Long(0), count);


        IT_KykKihon kykKihon1 = new IT_KykKihon("1", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("1");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("2", "11807111129");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("2");

        hozenDomManager.insert(kykKihon2);

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

        Long count = hozenDomManager.getKhTtdkRirekiCountBySyono("11807111130");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(40)
    public void normal1() {

        Long count = hozenDomManager.getKhTtdkRirekiCountBySyono("11807111118");
        Assert.assertEquals(new Long(1), count);

    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        Long count = hozenDomManager.getKhTtdkRirekiCountBySyono("");
        Assert.assertEquals(new Long(0), count);

    }


}
