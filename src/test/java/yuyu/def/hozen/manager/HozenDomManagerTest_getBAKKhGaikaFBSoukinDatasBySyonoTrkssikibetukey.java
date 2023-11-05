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

import yuyu.def.db.entity.IT_BAK_KhGaikaFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * HozenDomManagerクラスの、<br />
 * getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey {
    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_BAK_KhGaikaFBSoukinData> bAK_KhGaikaFBSoukinDataLst = hozenDomManager.getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey("10000000060", "SNK003");

        Assert.assertEquals(0,bAK_KhGaikaFBSoukinDataLst.size());

        IT_BAK_KhGaikaFBSoukinData bAK_KhGaikaFBSoukinData = new IT_BAK_KhGaikaFBSoukinData();
        bAK_KhGaikaFBSoukinData.setFbsoukindatasikibetukey("1111");
        bAK_KhGaikaFBSoukinData.setTrkssikibetukey("SNK002");
        bAK_KhGaikaFBSoukinData.setSyono("10000000060");
        hozenDomManager.insert(bAK_KhGaikaFBSoukinData);

        IT_BAK_KhGaikaFBSoukinData bAK_KhGaikaFBSoukinData2 = new IT_BAK_KhGaikaFBSoukinData();
        bAK_KhGaikaFBSoukinData2.setFbsoukindatasikibetukey("2222");
        bAK_KhGaikaFBSoukinData2.setTrkssikibetukey("SNK003");
        bAK_KhGaikaFBSoukinData2.setSyono("10000000060");
        hozenDomManager.insert(bAK_KhGaikaFBSoukinData2);

        IT_BAK_KhGaikaFBSoukinData bAK_KhGaikaFBSoukinData6 = new IT_BAK_KhGaikaFBSoukinData();
        bAK_KhGaikaFBSoukinData6.setFbsoukindatasikibetukey("6666");
        bAK_KhGaikaFBSoukinData6.setTrkssikibetukey("SNK002");
        bAK_KhGaikaFBSoukinData6.setSyono("10000000070");
        hozenDomManager.insert(bAK_KhGaikaFBSoukinData6);

        IT_BAK_KhGaikaFBSoukinData bAK_KhGaikaFBSoukinData3 = new IT_BAK_KhGaikaFBSoukinData();
        bAK_KhGaikaFBSoukinData3.setFbsoukindatasikibetukey("3333");
        bAK_KhGaikaFBSoukinData3.setTrkssikibetukey("SNK003");
        bAK_KhGaikaFBSoukinData3.setSyono("10000000060");
        hozenDomManager.insert(bAK_KhGaikaFBSoukinData3);

        IT_BAK_KhGaikaFBSoukinData bAK_KhGaikaFBSoukinData4 = new IT_BAK_KhGaikaFBSoukinData();
        bAK_KhGaikaFBSoukinData4.setFbsoukindatasikibetukey("4444");
        bAK_KhGaikaFBSoukinData4.setTrkssikibetukey("SNK003");
        bAK_KhGaikaFBSoukinData4.setSyono("10000000060");
        hozenDomManager.insert(bAK_KhGaikaFBSoukinData4);

        IT_BAK_KhGaikaFBSoukinData bAK_KhGaikaFBSoukinData5 = new IT_BAK_KhGaikaFBSoukinData();
        bAK_KhGaikaFBSoukinData5.setFbsoukindatasikibetukey("5555");
        bAK_KhGaikaFBSoukinData5.setTrkssikibetukey("SNK003");
        bAK_KhGaikaFBSoukinData5.setSyono("10000000070");
        hozenDomManager.insert(bAK_KhGaikaFBSoukinData5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllBAKKhGaikaFBSoukinData());

    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<IT_BAK_KhGaikaFBSoukinData> bAK_KhGaikaFBSoukinDataLst = hozenDomManager.getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey("10000000080", "SNK003");

        assertEquals(0, bAK_KhGaikaFBSoukinDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_BAK_KhGaikaFBSoukinData> bAK_KhGaikaFBSoukinDataLst = hozenDomManager.getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey("10000000060", "SNK002");

        assertEquals(1, bAK_KhGaikaFBSoukinDataLst.size());
        assertEquals("1111", bAK_KhGaikaFBSoukinDataLst.get(0).getFbsoukindatasikibetukey());
        assertEquals("SNK002",bAK_KhGaikaFBSoukinDataLst.get(0).getTrkssikibetukey());
        assertEquals("10000000060",bAK_KhGaikaFBSoukinDataLst.get(0).getSyono());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        List<IT_BAK_KhGaikaFBSoukinData> bAK_KhGaikaFBSoukinDataLst = hozenDomManager.getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey("", "SNK002");
        Assert.assertEquals(0, bAK_KhGaikaFBSoukinDataLst.size());

    }

    @Test
    @TestOrder(40)
    public void blank2() {

        List<IT_BAK_KhGaikaFBSoukinData> bAK_KhGaikaFBSoukinDataLst = hozenDomManager.getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey("10000000060", "");
        Assert.assertEquals(0, bAK_KhGaikaFBSoukinDataLst.size());

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("2222","SNK003","10000000060"), "1");
        datamap.put($("3333","SNK003","10000000060"), "2");
        datamap.put($("4444","SNK003","10000000060"), "3");

        List<IT_BAK_KhGaikaFBSoukinData> bAK_KhGaikaFBSoukinDataLst = hozenDomManager.getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey("10000000060", "SNK003");

        for(IT_BAK_KhGaikaFBSoukinData bakkhGaikaFBSoukinData:bAK_KhGaikaFBSoukinDataLst){
            datamap.remove($(bakkhGaikaFBSoukinData.getFbsoukindatasikibetukey(),bakkhGaikaFBSoukinData.getTrkssikibetukey(),bakkhGaikaFBSoukinData.getSyono()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }
    @Test
    @TestOrder(60)
    @Transactional
    public void noResult60(){
        hozenDomManager.delete(hozenDomManager.getAllBAKKhGaikaFBSoukinData());
    }

    @Test
    @TestOrder(61)
    public void noResult61(){

        List<IT_BAK_KhGaikaFBSoukinData> bAK_KhGaikaFBSoukinDataLst = hozenDomManager.getBAKKhGaikaFBSoukinDatasBySyonoTrkssikibetukey("10000000060", "SNK003");

        assertEquals(0, bAK_KhGaikaFBSoukinDataLst.size());
    }
}
