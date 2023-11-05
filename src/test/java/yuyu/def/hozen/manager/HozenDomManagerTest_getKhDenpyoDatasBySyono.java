package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhDenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhDenpyoDatasBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhDenpyoDatasBySyono {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        List<IT_KhDenpyoData> khDenpyoDataLst = hozenDomManager.getKhDenpyoDatasBySyono("10000000001");

        Assert.assertEquals(0,khDenpyoDataLst.size());

        khDenpyoDataLst =  hozenDomManager.getAllKhDenpyoData();

        if (khDenpyoDataLst.size() == 0) {
            IT_KhDenpyoData khDenpyoData = new IT_KhDenpyoData();
            khDenpyoData.setDenrenno("10000000060");
            khDenpyoData.setEdano(11);
            khDenpyoData.setSyono("10000000001");
            hozenDomManager.insert(khDenpyoData);

            IT_KhDenpyoData khDenpyoData2 = new IT_KhDenpyoData();
            khDenpyoData2.setDenrenno("10000000060");
            khDenpyoData2.setEdano(12);
            khDenpyoData2.setSyono("10000000002");
            hozenDomManager.insert(khDenpyoData2);

            IT_KhDenpyoData khDenpyoData3 = new IT_KhDenpyoData();
            khDenpyoData3.setDenrenno("10000000061");
            khDenpyoData3.setEdano(13);
            khDenpyoData3.setSyono("10000000003");
            hozenDomManager.insert(khDenpyoData3);

            IT_KhDenpyoData khDenpyoData4 = new IT_KhDenpyoData();
            khDenpyoData4.setDenrenno("10000000062");
            khDenpyoData4.setEdano(14);
            khDenpyoData4.setSyono("10000000003");
            hozenDomManager.insert(khDenpyoData4);

            IT_KhDenpyoData khDenpyoData5 = new IT_KhDenpyoData();
            khDenpyoData5.setDenrenno("10000000063");
            khDenpyoData5.setEdano(15);
            khDenpyoData5.setSyono("10000000003");
            hozenDomManager.insert(khDenpyoData5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhDenpyoData());
    }
    @Test
    @TestOrder(10)
    public void noResult1(){

        List<IT_KhDenpyoData> khDenpyoDataLst = hozenDomManager.getKhDenpyoDatasBySyono("10000000004");

        assertEquals(0, khDenpyoDataLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_KhDenpyoData> khDenpyoDataLst = hozenDomManager.getKhDenpyoDatasBySyono("10000000001");

        assertEquals(1, khDenpyoDataLst.size());
        assertEquals("10000000060", khDenpyoDataLst.get(0).getDenrenno());
        assertEquals("11",khDenpyoDataLst.get(0).getEdano().toString());
        assertEquals("10000000001",khDenpyoDataLst.get(0).getSyono());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10000000061","13","10000000003"), "1");
        datamap.put($("10000000062","14","10000000003"), "2");
        datamap.put($("10000000063","15","10000000003"), "3");

        List<IT_KhDenpyoData> khDenpyoDataLst = hozenDomManager.getKhDenpyoDatasBySyono("10000000003");

        for(IT_KhDenpyoData khDenpyoData:khDenpyoDataLst){
            datamap.remove($(
                khDenpyoData.getDenrenno(),
                khDenpyoData.getEdano().toString(),
                khDenpyoData.getSyono()));

        }

        Assert.assertTrue(datamap.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhDenpyoData> khDenpyoDataLst = hozenDomManager.getKhDenpyoDatasBySyono("");

        assertEquals(0, khDenpyoDataLst.size());

    }
}
