package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 異動明細情報作成<br />
 * 契約保全備金管理テーブルエンティティリスト取得　証券番号かつ変更識別キーを指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhBikinkanrisBySyonoHenkousikibetukey {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.getKhBikinkanrisBySyonoHenkousikibetukey("11807111118", "111");

        Assert.assertEquals(0, khBikinkanriList.size());

        IT_KhBikinkanri khBikinkanri1 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160101), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), 1);
        khBikinkanri1.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri1.setHenkousikibetukey("111");
        khBikinkanri1.setBknjkukbn(C_BknJkuKbn.SINBI);

        hozenDomManager.insert(khBikinkanri1);

        IT_KhBikinkanri khBikinkanri2 = new IT_KhBikinkanri("11807111129", BizDate.valueOf(20160101), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), 1);
        khBikinkanri2.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri2.setHenkousikibetukey("111");
        khBikinkanri2.setBknjkukbn(C_BknJkuKbn.SINBI);

        hozenDomManager.insert(khBikinkanri2);

        IT_KhBikinkanri khBikinkanri3 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160101), C_BkncdKbn.BLNK, BizDate.valueOf(20161221), 1);
        khBikinkanri3.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri3.setHenkousikibetukey("100");
        khBikinkanri3.setBknjkukbn(C_BknJkuKbn.SINBI);

        hozenDomManager.insert(khBikinkanri3);

        IT_KhBikinkanri khBikinkanri4 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160101), C_BkncdKbn.BLNK, BizDate.valueOf(20161222), 1);
        khBikinkanri4.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri4.setHenkousikibetukey("111");
        khBikinkanri4.setBknjkukbn(C_BknJkuKbn.SAIBI);

        hozenDomManager.insert(khBikinkanri4);

        IT_KhBikinkanri khBikinkanri5 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160101), C_BkncdKbn.BLNK, BizDate.valueOf(20161223), 1);
        khBikinkanri5.setBknrigikbn(C_BknrigiKbn.DEL);
        khBikinkanri5.setHenkousikibetukey("111");
        khBikinkanri5.setBknjkukbn(C_BknJkuKbn.SINBI);

        hozenDomManager.insert(khBikinkanri5);

        IT_KhBikinkanri khBikinkanri6 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160103), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), 3);
        khBikinkanri6.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri6.setHenkousikibetukey("333");
        khBikinkanri6.setBknjkukbn(C_BknJkuKbn.SINBI);

        hozenDomManager.insert(khBikinkanri6);

        IT_KhBikinkanri khBikinkanri7 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160104), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), 3);
        khBikinkanri7.setBknrigikbn(C_BknrigiKbn.ADD);
        khBikinkanri7.setHenkousikibetukey("333");
        khBikinkanri7.setBknjkukbn(C_BknJkuKbn.SINBI);

        hozenDomManager.insert(khBikinkanri7);

        IT_KhBikinkanri khBikinkanri8 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160105), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), 3);
        khBikinkanri8.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri8.setHenkousikibetukey("333");
        khBikinkanri8.setBknjkukbn(C_BknJkuKbn.SINBI);

        hozenDomManager.insert(khBikinkanri8);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.getKhBikinkanrisBySyonoHenkousikibetukey("11807111118", "222");

        Assert.assertEquals(0, khBikinkanriList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.getKhBikinkanrisBySyonoHenkousikibetukey("11807111118", "111");

        Assert.assertEquals(1, khBikinkanriList.size());
        Assert.assertEquals("11807111118", khBikinkanriList.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20160101), khBikinkanriList.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BkncdKbn.BLNK, khBikinkanriList.get(0).getBkncdkbn());
        Assert.assertEquals(BizDate.valueOf(20161220), khBikinkanriList.get(0).getBknkktymd());
        Assert.assertEquals(Integer.valueOf(1), khBikinkanriList.get(0).getRenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> khBikinkanriMap = new HashMap<String, String>();
        khBikinkanriMap.put($("11807111141", BizDate.valueOf(20160103), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), 3),"1");
        khBikinkanriMap.put($("11807111141", BizDate.valueOf(20160104), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), 3),"1");
        khBikinkanriMap.put($("11807111141", BizDate.valueOf(20160105), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), 3),"1");

        List<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.getKhBikinkanrisBySyonoHenkousikibetukey("11807111141", "333");

        assertEquals(3, khBikinkanriList.size());

        khBikinkanriMap.remove($(khBikinkanriList.get(0).getSyono(), khBikinkanriList.get(0).getKessankijyunymd(),
            khBikinkanriList.get(0).getBkncdkbn(), khBikinkanriList.get(0).getBknkktymd(), khBikinkanriList.get(0).getRenno()));
        khBikinkanriMap.remove($(khBikinkanriList.get(1).getSyono(), khBikinkanriList.get(1).getKessankijyunymd(),
            khBikinkanriList.get(1).getBkncdkbn(), khBikinkanriList.get(1).getBknkktymd(), khBikinkanriList.get(1).getRenno()));
        khBikinkanriMap.remove($(khBikinkanriList.get(2).getSyono(), khBikinkanriList.get(2).getKessankijyunymd(),
            khBikinkanriList.get(2).getBkncdkbn(), khBikinkanriList.get(2).getBknkktymd(), khBikinkanriList.get(2).getRenno()));
        assertTrue(khBikinkanriMap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.getKhBikinkanrisBySyonoHenkousikibetukey("", "333");

        assertEquals(0, khBikinkanriList.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<IT_KhBikinkanri> khBikinkanriList = hozenDomManager.getKhBikinkanrisBySyonoHenkousikibetukey("11807111141", "");

        assertEquals(0, khBikinkanriList.size());
    }
}
