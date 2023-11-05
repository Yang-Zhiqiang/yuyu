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

import yuyu.def.db.entity.IT_KhFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhFBSoukinDatasBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhFBSoukinDatasBySyono {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        List<IT_KhFBSoukinData> khFBSoukinDataLst = hozenDomManager.getKhFBSoukinDatasBySyono("10000000001");

        Assert.assertEquals(0,khFBSoukinDataLst.size());

        khFBSoukinDataLst =  hozenDomManager.getAllKhFBSoukinData();

        if (khFBSoukinDataLst.size() == 0) {
            IT_KhFBSoukinData khFBSoukinData = new IT_KhFBSoukinData();
            khFBSoukinData.setFbsoukindatasikibetukey("10000000060");
            khFBSoukinData.setSyono("10000000001");
            hozenDomManager.insert(khFBSoukinData);

            IT_KhFBSoukinData khFBSoukinData2 = new IT_KhFBSoukinData();
            khFBSoukinData2.setFbsoukindatasikibetukey("10000000061");
            khFBSoukinData2.setSyono("10000000002");
            hozenDomManager.insert(khFBSoukinData2);

            IT_KhFBSoukinData khFBSoukinData3 = new IT_KhFBSoukinData();
            khFBSoukinData3.setFbsoukindatasikibetukey("10000000062");
            khFBSoukinData3.setSyono("10000000003");
            hozenDomManager.insert(khFBSoukinData3);

            IT_KhFBSoukinData khFBSoukinData4 = new IT_KhFBSoukinData();
            khFBSoukinData4.setFbsoukindatasikibetukey("10000000063");
            khFBSoukinData4.setSyono("10000000003");
            hozenDomManager.insert(khFBSoukinData4);

            IT_KhFBSoukinData khFBSoukinData5 = new IT_KhFBSoukinData();
            khFBSoukinData5.setFbsoukindatasikibetukey("10000000064");
            khFBSoukinData5.setSyono("10000000003");
            hozenDomManager.insert(khFBSoukinData5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhFBSoukinData());
    }
    @Test
    @TestOrder(10)
    public void noResult1(){

        List<IT_KhFBSoukinData> khFBSoukinDataLst = hozenDomManager.getKhFBSoukinDatasBySyono("10000000004");

        assertEquals(0, khFBSoukinDataLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_KhFBSoukinData> khFBSoukinDataLst = hozenDomManager.getKhFBSoukinDatasBySyono("10000000001");

        assertEquals(1, khFBSoukinDataLst.size());
        assertEquals("10000000060", khFBSoukinDataLst.get(0).getFbsoukindatasikibetukey());
        assertEquals("10000000001",khFBSoukinDataLst.get(0).getSyono());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10000000062","10000000003"), "1");
        datamap.put($("10000000063","10000000003"), "2");
        datamap.put($("10000000064","10000000003"), "3");

        List<IT_KhFBSoukinData> khFBSoukinDataLst = hozenDomManager.getKhFBSoukinDatasBySyono("10000000003");

        for(IT_KhFBSoukinData khFBSoukinData:khFBSoukinDataLst){
            datamap.remove($(khFBSoukinData.getFbsoukindatasikibetukey(),khFBSoukinData.getSyono()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhFBSoukinData> khFBSoukinDataLst = hozenDomManager.getKhFBSoukinDatasBySyono("");

        assertEquals(0, khFBSoukinDataLst.size());

    }
}
