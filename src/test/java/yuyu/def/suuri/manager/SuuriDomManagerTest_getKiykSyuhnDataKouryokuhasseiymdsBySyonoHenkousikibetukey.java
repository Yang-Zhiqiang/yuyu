package yuyu.def.suuri.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SuuriDomManagerクラスの、<br />
 * getKiykSyuhnDatasBySyonoSyutkkbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey {

    @Inject
    private SuuriDomManager suuriDomManager;

    @BeforeClass
    @Transactional()
    public static void preProcess() {

        deleteTestData();

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);

        List<BizDate> list = suuriDomManager.getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey("11807111118","10012002");
        Assert.assertEquals(0, list.size());

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("02", "11807111129");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        kykSyouhn1.setSyouhncd("A01");
        kykSyouhn1.setSyouhnsdno(11);
        kykSyouhn1.setKyksyouhnrenno(10);
        kykSyouhn1.setHenkousikibetukey("10012002");
        kykSyouhn1.setKouryokuhasseiymd(BizDate.valueOf("20170217"));

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("10012002");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        kykSyouhn2.setSyouhncd("A01");
        kykSyouhn2.setSyouhnsdno(11);
        kykSyouhn2.setKyksyouhnrenno(10);
        kykSyouhn2.setHenkousikibetukey("20111002");
        kykSyouhn2.setKouryokuhasseiymd(BizDate.valueOf("20170217"));

        IT_KykSyouhn kykSyouhn3 = kykKihon2.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        kykSyouhn3.setSyouhncd("A01");
        kykSyouhn3.setSyouhnsdno(12);
        kykSyouhn3.setKyksyouhnrenno(10);
        kykSyouhn3.setHenkousikibetukey("20111002");
        kykSyouhn3.setKouryokuhasseiymd(BizDate.valueOf("20170218"));

        IT_KykSyouhn kykSyouhn4 = kykKihon2.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        kykSyouhn4.setSyouhncd("A01");
        kykSyouhn4.setSyouhnsdno(13);
        kykSyouhn4.setKyksyouhnrenno(10);
        kykSyouhn4.setHenkousikibetukey("20111002");
        kykSyouhn4.setKouryokuhasseiymd(BizDate.valueOf("20170219"));

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20111002");

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
        List<BizDate> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey("11807111118","10012002");

        Assert.assertEquals(0, kiykSyuhnDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<BizDate> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey("11807111129","10012002");

        Assert.assertEquals(1, kiykSyuhnDataLst.size());

        Assert.assertEquals(BizDate.valueOf("20170217"), kiykSyuhnDataLst.get(0));

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> datamap = new HashMap<String, String>();
        datamap.put($(20170217),"1");
        datamap.put($(20170218),"2");
        datamap.put($(20170219),"3");

        List<BizDate> kiykSyuhnDataLst = suuriDomManager.getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey("11807111141","20111002");

        Assert.assertEquals(3, kiykSyuhnDataLst.size());

        for(BizDate kiykSyuhnData:kiykSyuhnDataLst){
            datamap.remove($(kiykSyuhnData));
        }
        Assert.assertTrue(datamap.isEmpty());
    }

}
