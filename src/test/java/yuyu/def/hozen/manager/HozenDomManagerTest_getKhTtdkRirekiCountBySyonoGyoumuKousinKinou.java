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
 * 契約保全<br />
 * 被保険者生年月日・性訂正<br />
 * 契約保全手続履歴テーブル件数取得　証券番号かつ業務用更新機能ＩＤのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhTtdkRirekiCountBySyonoGyoumuKousinKinou {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Long count = hozenDomManager.getKhTtdkRirekiCountBySyonoGyoumuKousinKinou("11807111118", "10001");
        Assert.assertEquals(new Long(0), count);


        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("1111");
        khTtdkRireki1.setGyoumuKousinKinou("10001");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("1113");
        khTtdkRireki3.setGyoumuKousinKinou("10002");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("1114");
        khTtdkRireki4.setGyoumuKousinKinou("10003");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("1115");
        khTtdkRireki5.setGyoumuKousinKinou("10003");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("1116");
        khTtdkRireki6.setGyoumuKousinKinou("10003");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("01", "11807111129");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("1112");
        khTtdkRireki2.setGyoumuKousinKinou("10001");

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

        Long count = hozenDomManager.getKhTtdkRirekiCountBySyonoGyoumuKousinKinou("11807111130", "10004");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long count = hozenDomManager.getKhTtdkRirekiCountBySyonoGyoumuKousinKinou("11807111118", "10001");
        Assert.assertEquals(new Long(1), count);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Long count = hozenDomManager.getKhTtdkRirekiCountBySyonoGyoumuKousinKinou("11807111118", "10003");
        Assert.assertEquals(new Long(3), count);

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        Long count = hozenDomManager.getKhTtdkRirekiCountBySyonoGyoumuKousinKinou("", "10001");
        Assert.assertEquals(new Long(0), count);

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        Long count = hozenDomManager.getKhTtdkRirekiCountBySyonoGyoumuKousinKinou("11807111118", "");
        Assert.assertEquals(new Long(0), count);

    }
}
