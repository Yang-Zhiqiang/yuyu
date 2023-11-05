package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykSyouhnRirekisBySyonoMaxHenkousikibetukey() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class HozenDomManagerTest_getKykSyouhnRirekisBySyonoMaxHenkousikibetukey extends AbstractTest {
    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("10000000001");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("1", "10000000001");
            IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();
            khTtdkRireki.setHenkousikibetukey("1");
            Assert.assertEquals(0,
                hozenDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey("10000000001").size());
            IT_KykSyouhnRireki iT_KykSyouhnRireki1 = khTtdkRireki.createKykSyouhnRireki();
            iT_KykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki1.setSyouhncd("1");
            iT_KykSyouhnRireki1.setSyouhnsdno(1);
            iT_KykSyouhnRireki1.setKyksyouhnrenno(1);

            IT_KykSyouhnRireki iT_KykSyouhnRireki2 = khTtdkRireki.createKykSyouhnRireki();
            iT_KykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki2.setSyouhncd("1");
            iT_KykSyouhnRireki2.setSyouhnsdno(1);
            iT_KykSyouhnRireki2.setKyksyouhnrenno(2);

            IT_KykSyouhnRireki iT_KykSyouhnRireki3 = khTtdkRireki.createKykSyouhnRireki();
            iT_KykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki3.setSyouhncd("1");
            iT_KykSyouhnRireki3.setSyouhnsdno(1);
            iT_KykSyouhnRireki3.setKyksyouhnrenno(3);

            hozenDomManager.insert(kykKihon);

        }
        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon("10000000002");
        if (kykKihon1 == null) {
            kykKihon1 = new IT_KykKihon("1", "10000000002");
            IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki1.setHenkousikibetukey("1");
            IT_KykSyouhnRireki iT_KykSyouhnRireki4 = khTtdkRireki1.createKykSyouhnRireki();
            iT_KykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki4.setSyouhncd("1");
            iT_KykSyouhnRireki4.setSyouhnsdno(1);
            iT_KykSyouhnRireki4.setKyksyouhnrenno(1);
            IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("2");
            IT_KykSyouhnRireki iT_KykSyouhnRireki5 = khTtdkRireki2.createKykSyouhnRireki();
            iT_KykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki5.setSyouhncd("1");
            iT_KykSyouhnRireki5.setSyouhnsdno(1);
            iT_KykSyouhnRireki5.setKyksyouhnrenno(1);
            IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
            khTtdkRireki3.setHenkousikibetukey("3");
            IT_KykSyouhnRireki iT_KykSyouhnRireki6 = khTtdkRireki3.createKykSyouhnRireki();
            iT_KykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki6.setSyouhncd("1");
            iT_KykSyouhnRireki6.setSyouhnsdno(1);
            iT_KykSyouhnRireki6.setKyksyouhnrenno(1);
            hozenDomManager.insert(kykKihon1);
        }
        IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon("10000000003");
        if (kykKihon2 == null) {
            kykKihon2 = new IT_KykKihon("1", "10000000003");
            IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
            khTtdkRireki2.setHenkousikibetukey("1");
            IT_KykSyouhnRireki iT_KykSyouhnRireki5 = khTtdkRireki2.createKykSyouhnRireki();
            iT_KykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.SYU);
            iT_KykSyouhnRireki5.setSyouhncd("1");
            iT_KykSyouhnRireki5.setSyouhnsdno(1);
            iT_KykSyouhnRireki5.setKyksyouhnrenno(1);
            hozenDomManager.insert(kykKihon2);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @Transactional
    public void noResult1() {
        List<IT_KykSyouhnRireki> result = hozenDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey("10000000004");
        Assert.assertEquals(0, result.size());
    }

    @Test
    @TestOrder(10)
    public void normal1() {
        List<IT_KykSyouhnRireki> result = hozenDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey("10000000002");
        Assert.assertEquals(1, result.size());

        Assert.assertEquals("1", result.get(0).getKbnkey());
        Assert.assertEquals("10000000002", result.get(0).getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, result.get(0).getSyutkkbn());
        Assert.assertEquals("1", result.get(0).getSyouhncd());
        Assert.assertEquals(1, result.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals(1, result.get(0).getKyksyouhnrenno().intValue());
        Assert.assertEquals("3", result.get(0).getHenkousikibetukey());
    }

    @Test
    @TestOrder(20)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("1","10000000001","1","1","1","1","1"), "1");
        datamap.put($("1","10000000001","1","1","1","2","1"), "2");
        datamap.put($("1","10000000001","1","1","1","3","1"), "3");

        List<IT_KykSyouhnRireki> result = hozenDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey("10000000001");

        for(IT_KykSyouhnRireki kykSyouhnRireki:result){
            datamap.remove($(
                kykSyouhnRireki.getKbnkey(),
                kykSyouhnRireki.getSyono(),
                kykSyouhnRireki.getSyutkkbn(),
                kykSyouhnRireki.getSyouhncd(),
                kykSyouhnRireki.getSyouhnsdno().intValue(),
                kykSyouhnRireki.getKyksyouhnrenno().intValue(),
                kykSyouhnRireki.getHenkousikibetukey()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(30)
    public void noResult2() {
        List<IT_KykSyouhnRireki> result = hozenDomManager.getKykSyouhnRirekisBySyonoMaxHenkousikibetukey("");
        Assert.assertEquals(0, result.size());
    }

}
