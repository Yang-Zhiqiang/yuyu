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

import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全外貨ＦＢ送金データテーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhGaikaFBSoukinDatasBySyono {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        List<IT_KhGaikaFBSoukinData> khGaikaFBSoukinDataLst = hozenDomManager.getKhGaikaFBSoukinDatasBySyono("10000000001");

        Assert.assertEquals(0,khGaikaFBSoukinDataLst.size());

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData = new IT_KhGaikaFBSoukinData();
        khGaikaFBSoukinData.setFbsoukindatasikibetukey("11");
        khGaikaFBSoukinData.setSyono("10000000001");
        hozenDomManager.insert(khGaikaFBSoukinData);

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData2 = new IT_KhGaikaFBSoukinData();
        khGaikaFBSoukinData2.setFbsoukindatasikibetukey("12");
        khGaikaFBSoukinData2.setSyono("10000000002");
        hozenDomManager.insert(khGaikaFBSoukinData2);

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData3 = new IT_KhGaikaFBSoukinData();
        khGaikaFBSoukinData3.setFbsoukindatasikibetukey("13");
        khGaikaFBSoukinData3.setSyono("10000000003");
        hozenDomManager.insert(khGaikaFBSoukinData3);

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData4 = new IT_KhGaikaFBSoukinData();
        khGaikaFBSoukinData4.setFbsoukindatasikibetukey("14");
        khGaikaFBSoukinData4.setSyono("10000000003");
        hozenDomManager.insert(khGaikaFBSoukinData4);

        IT_KhGaikaFBSoukinData khGaikaFBSoukinData5 = new IT_KhGaikaFBSoukinData();
        khGaikaFBSoukinData5.setFbsoukindatasikibetukey("15");
        khGaikaFBSoukinData5.setSyono("10000000003");
        hozenDomManager.insert(khGaikaFBSoukinData5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhGaikaFBSoukinData());
    }
    @Test
    @TestOrder(10)
    public void noResult1(){

        List<IT_KhGaikaFBSoukinData> khGaikaFBSoukinDataLst = hozenDomManager.getKhGaikaFBSoukinDatasBySyono("10000000004");

        assertEquals(0, khGaikaFBSoukinDataLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_KhGaikaFBSoukinData> khGaikaFBSoukinDataLst = hozenDomManager.getKhGaikaFBSoukinDatasBySyono("10000000001");

        assertEquals(1, khGaikaFBSoukinDataLst.size());
        assertEquals("11",khGaikaFBSoukinDataLst.get(0).getFbsoukindatasikibetukey());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("13"), "1");
        datamap.put($("14"), "2");
        datamap.put($("15"), "3");

        List<IT_KhGaikaFBSoukinData> khGaikaFBSoukinDataLst = hozenDomManager.getKhGaikaFBSoukinDatasBySyono("10000000003");

        for(IT_KhGaikaFBSoukinData khGaikaFBSoukinData:khGaikaFBSoukinDataLst){
            datamap.remove($(khGaikaFBSoukinData.getFbsoukindatasikibetukey()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhGaikaFBSoukinData> khGaikaFBSoukinDataLst = hozenDomManager.getKhGaikaFBSoukinDatasBySyono("");

        assertEquals(0, khGaikaFBSoukinDataLst.size());

    }
}
