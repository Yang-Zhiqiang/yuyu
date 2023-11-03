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

import yuyu.def.db.entity.IT_BAK_KhFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getBAKKhFBSoukinDatasBySyonoTrkssikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getBAKKhFBSoukinDatasBySyonoTrkssikibetukey {
    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_BAK_KhFBSoukinData> bAK_KhFBSoukinDataLst = hozenDomManager.getBAKKhFBSoukinDatasBySyonoTrkssikibetukey("10000000060", "SNK0003");

        Assert.assertEquals(0,bAK_KhFBSoukinDataLst.size());

        IT_BAK_KhFBSoukinData iT_BAK_KhFBSoukinData = new IT_BAK_KhFBSoukinData();
        iT_BAK_KhFBSoukinData.setFbsoukindatasikibetukey("MP10000000010");
        iT_BAK_KhFBSoukinData.setTrkssikibetukey("SNK0002");
        iT_BAK_KhFBSoukinData.setSyono("10000000060");
        hozenDomManager.insert(iT_BAK_KhFBSoukinData);

        IT_BAK_KhFBSoukinData iT_BAK_KhFBSoukinData2 = new IT_BAK_KhFBSoukinData();
        iT_BAK_KhFBSoukinData2.setFbsoukindatasikibetukey("MP10000000020");
        iT_BAK_KhFBSoukinData2.setTrkssikibetukey("SNK0003");
        iT_BAK_KhFBSoukinData2.setSyono("10000000060");
        hozenDomManager.insert(iT_BAK_KhFBSoukinData2);

        IT_BAK_KhFBSoukinData iT_BAK_KhFBSoukinData3 = new IT_BAK_KhFBSoukinData();
        iT_BAK_KhFBSoukinData3.setFbsoukindatasikibetukey("MP10000000030");
        iT_BAK_KhFBSoukinData3.setTrkssikibetukey("SNK0003");
        iT_BAK_KhFBSoukinData3.setSyono("10000000060");
        hozenDomManager.insert(iT_BAK_KhFBSoukinData3);

        IT_BAK_KhFBSoukinData iT_BAK_KhFBSoukinData4 = new IT_BAK_KhFBSoukinData();
        iT_BAK_KhFBSoukinData4.setFbsoukindatasikibetukey("MP10000000040");
        iT_BAK_KhFBSoukinData4.setTrkssikibetukey("SNK0003");
        iT_BAK_KhFBSoukinData4.setSyono("10000000060");
        hozenDomManager.insert(iT_BAK_KhFBSoukinData4);

        IT_BAK_KhFBSoukinData iT_BAK_KhFBSoukinData5 = new IT_BAK_KhFBSoukinData();
        iT_BAK_KhFBSoukinData5.setFbsoukindatasikibetukey("MP10000000050");
        iT_BAK_KhFBSoukinData5.setTrkssikibetukey("SNK0003");
        iT_BAK_KhFBSoukinData5.setSyono("10000000070");
        hozenDomManager.insert(iT_BAK_KhFBSoukinData5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllBAKKhFBSoukinData());

    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<IT_BAK_KhFBSoukinData> bAK_KhFBSoukinDataLst = hozenDomManager.getBAKKhFBSoukinDatasBySyonoTrkssikibetukey("10000000080", "SNK0003");

        assertEquals(0, bAK_KhFBSoukinDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_BAK_KhFBSoukinData> bAK_KhFBSoukinDataLst = hozenDomManager.getBAKKhFBSoukinDatasBySyonoTrkssikibetukey("10000000060", "SNK0002");

        assertEquals(1, bAK_KhFBSoukinDataLst.size());
        assertEquals("MP10000000010", bAK_KhFBSoukinDataLst.get(0).getFbsoukindatasikibetukey());
        assertEquals("SNK0002",bAK_KhFBSoukinDataLst.get(0).getTrkssikibetukey());
        assertEquals("10000000060",bAK_KhFBSoukinDataLst.get(0).getSyono());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        List<IT_BAK_KhFBSoukinData> bAK_KhFBSoukinDataLst = hozenDomManager.getBAKKhFBSoukinDatasBySyonoTrkssikibetukey("", "SNK0002");
        Assert.assertEquals(0, bAK_KhFBSoukinDataLst.size());

    }

    @Test
    @TestOrder(40)
    public void blank2() {

        List<IT_BAK_KhFBSoukinData> bAK_KhFBSoukinDataLst = hozenDomManager.getBAKKhFBSoukinDatasBySyonoTrkssikibetukey("10000000060", "");
        Assert.assertEquals(0, bAK_KhFBSoukinDataLst.size());

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("MP10000000020","SNK0003","10000000060"), "1");
        datamap.put($("MP10000000030","SNK0003","10000000060"), "2");
        datamap.put($("MP10000000040","SNK0003","10000000060"), "3");

        List<IT_BAK_KhFBSoukinData> bAK_KhFBSoukinDataLst = hozenDomManager.getBAKKhFBSoukinDatasBySyonoTrkssikibetukey("10000000060", "SNK0003");

        for(IT_BAK_KhFBSoukinData bakkhFBSoukinData:bAK_KhFBSoukinDataLst){
            datamap.remove($(bakkhFBSoukinData.getFbsoukindatasikibetukey(),bakkhFBSoukinData.getTrkssikibetukey(),bakkhFBSoukinData.getSyono()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void noResult60(){
        hozenDomManager.delete(hozenDomManager.getAllBAKKhFBSoukinData());
    }

    @Test
    @TestOrder(61)
    public void noResult61(){

        List<IT_BAK_KhFBSoukinData> bAK_KhFBSoukinDataLst = hozenDomManager.getBAKKhFBSoukinDatasBySyonoTrkssikibetukey("10000000060", "SNK0003");

        assertEquals(0, bAK_KhFBSoukinDataLst.size());
    }
}
