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

import yuyu.def.db.entity.IT_BAK_KhDenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * HozenDomManagerクラスの、<br />
 * getBAKKhDenpyoDatasBySyonoTrkssikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getBAKKhDenpyoDatasBySyonoTrkssikibetukey {
    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_BAK_KhDenpyoData> bAK_KhDenpyoDataLst = hozenDomManager.getBAKKhDenpyoDatasBySyonoTrkssikibetukey("10000000060", "SNK0003");

        Assert.assertEquals(0,bAK_KhDenpyoDataLst.size());

        IT_BAK_KhDenpyoData iT_BAK_KhDenpyoData = new IT_BAK_KhDenpyoData();
        iT_BAK_KhDenpyoData.setDenrenno("10000000010");
        iT_BAK_KhDenpyoData.setTrkssikibetukey("SNK0002");
        iT_BAK_KhDenpyoData.setEdano(1);
        iT_BAK_KhDenpyoData.setSyono("10000000060");
        hozenDomManager.insert(iT_BAK_KhDenpyoData);

        IT_BAK_KhDenpyoData iT_BAK_KhDenpyoData2 = new IT_BAK_KhDenpyoData();
        iT_BAK_KhDenpyoData2.setDenrenno("10000000020");
        iT_BAK_KhDenpyoData2.setTrkssikibetukey("SNK0003");
        iT_BAK_KhDenpyoData2.setEdano(1);
        iT_BAK_KhDenpyoData2.setSyono("10000000060");
        hozenDomManager.insert(iT_BAK_KhDenpyoData2);

        IT_BAK_KhDenpyoData iT_BAK_KhDenpyoData3 = new IT_BAK_KhDenpyoData();
        iT_BAK_KhDenpyoData3.setDenrenno("10000000030");
        iT_BAK_KhDenpyoData3.setTrkssikibetukey("SNK0003");
        iT_BAK_KhDenpyoData3.setEdano(1);
        iT_BAK_KhDenpyoData3.setSyono("10000000060");
        hozenDomManager.insert(iT_BAK_KhDenpyoData3);

        IT_BAK_KhDenpyoData iT_BAK_KhDenpyoData4 = new IT_BAK_KhDenpyoData();
        iT_BAK_KhDenpyoData4.setDenrenno("10000000040");
        iT_BAK_KhDenpyoData4.setTrkssikibetukey("SNK0003");
        iT_BAK_KhDenpyoData4.setEdano(1);
        iT_BAK_KhDenpyoData4.setSyono("10000000060");
        hozenDomManager.insert(iT_BAK_KhDenpyoData4);

        IT_BAK_KhDenpyoData iT_BAK_KhDenpyoData5 = new IT_BAK_KhDenpyoData();
        iT_BAK_KhDenpyoData5.setDenrenno("10000000050");
        iT_BAK_KhDenpyoData5.setTrkssikibetukey("SNK0003");
        iT_BAK_KhDenpyoData5.setEdano(1);
        iT_BAK_KhDenpyoData5.setSyono("10000000070");
        hozenDomManager.insert(iT_BAK_KhDenpyoData5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllBAKKhDenpyoData());

    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<IT_BAK_KhDenpyoData> bAK_KhDenpyoDataLst = hozenDomManager.getBAKKhDenpyoDatasBySyonoTrkssikibetukey("10000000080", "SNK0003");

        assertEquals(0, bAK_KhDenpyoDataLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_BAK_KhDenpyoData> bAK_KhDenpyoDataLst = hozenDomManager.getBAKKhDenpyoDatasBySyonoTrkssikibetukey("10000000060", "SNK0002");

        assertEquals(1, bAK_KhDenpyoDataLst.size());
        assertEquals("10000000010", bAK_KhDenpyoDataLst.get(0).getDenrenno());
        assertEquals("SNK0002",bAK_KhDenpyoDataLst.get(0).getTrkssikibetukey());
        assertEquals(Integer.valueOf(1),bAK_KhDenpyoDataLst.get(0).getEdano());
        assertEquals("10000000060",bAK_KhDenpyoDataLst.get(0).getSyono());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        List<IT_BAK_KhDenpyoData> bAK_KhDenpyoDataLst = hozenDomManager.getBAKKhDenpyoDatasBySyonoTrkssikibetukey("", "SNK0002");
        Assert.assertEquals(0, bAK_KhDenpyoDataLst.size());

    }

    @Test
    @TestOrder(40)
    public void blank2() {

        List<IT_BAK_KhDenpyoData> bAK_KhDenpyoDataLst = hozenDomManager.getBAKKhDenpyoDatasBySyonoTrkssikibetukey("10000000060", "");
        Assert.assertEquals(0, bAK_KhDenpyoDataLst.size());

    }

    @Test
    @TestOrder(50)
    @Transactional
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10000000020","SNK0003","1","10000000060"), "1");
        datamap.put($("10000000030","SNK0003","1","10000000060"), "2");
        datamap.put($("10000000040","SNK0003","1","10000000060"), "3");


        List<IT_BAK_KhDenpyoData> bAK_KhDenpyoDataLst = hozenDomManager.getBAKKhDenpyoDatasBySyonoTrkssikibetukey("10000000060", "SNK0003");


        for(IT_BAK_KhDenpyoData bakkhDenpyoData:bAK_KhDenpyoDataLst){
            datamap.remove($(bakkhDenpyoData.getDenrenno(),bakkhDenpyoData.getTrkssikibetukey(),bakkhDenpyoData.getEdano(),bakkhDenpyoData.getSyono()));
        }

        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(60)
    @Transactional
    public void noResult60(){
        hozenDomManager.delete(hozenDomManager.getBAKKhDenpyoDatasBySyonoTrkssikibetukey("10000000060", "SNK0003"));
    }

    @Test
    @TestOrder(61)
    public void noResult61(){

        List<IT_BAK_KhDenpyoData> bAK_KhDenpyoDataLst = hozenDomManager.getBAKKhDenpyoDatasBySyonoTrkssikibetukey("10000000060", "SNK0003");

        assertEquals(0, bAK_KhDenpyoDataLst.size());
    }
}
