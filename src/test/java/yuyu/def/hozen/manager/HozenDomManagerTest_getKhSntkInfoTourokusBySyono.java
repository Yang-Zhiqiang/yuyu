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

import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全選択情報登録テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhSntkInfoTourokusBySyono {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        List<IT_KhSntkInfoTouroku> KhSntkInfoTourokuLst = hozenDomManager.getKhSntkInfoTourokusBySyono("10000000001");

        Assert.assertEquals(0,KhSntkInfoTourokuLst.size());

        IT_KhSntkInfoTouroku khSntkInfoTouroku = new IT_KhSntkInfoTouroku();
        khSntkInfoTouroku.setRenno(11);
        khSntkInfoTouroku.setSyono("10000000001");
        hozenDomManager.insert(khSntkInfoTouroku);

        IT_KhSntkInfoTouroku khSntkInfoTouroku2 = new IT_KhSntkInfoTouroku();
        khSntkInfoTouroku2.setRenno(12);
        khSntkInfoTouroku2.setSyono("10000000002");
        hozenDomManager.insert(khSntkInfoTouroku2);

        IT_KhSntkInfoTouroku khSntkInfoTouroku3 = new IT_KhSntkInfoTouroku();
        khSntkInfoTouroku3.setRenno(13);
        khSntkInfoTouroku3.setSyono("10000000003");
        hozenDomManager.insert(khSntkInfoTouroku3);

        IT_KhSntkInfoTouroku khSntkInfoTouroku4 = new IT_KhSntkInfoTouroku();
        khSntkInfoTouroku4.setRenno(14);
        khSntkInfoTouroku4.setSyono("10000000003");
        hozenDomManager.insert(khSntkInfoTouroku4);

        IT_KhSntkInfoTouroku khSntkInfoTouroku5 = new IT_KhSntkInfoTouroku();
        khSntkInfoTouroku5.setRenno(15);
        khSntkInfoTouroku5.setSyono("10000000003");
        hozenDomManager.insert(khSntkInfoTouroku5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhSntkInfoTouroku());
    }
    @Test
    @TestOrder(10)
    public void noResult1(){

        List<IT_KhSntkInfoTouroku> KhSntkInfoTourokuLst = hozenDomManager.getKhSntkInfoTourokusBySyono("10000000004");

        assertEquals(0, KhSntkInfoTourokuLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IT_KhSntkInfoTouroku> KhSntkInfoTourokuLst = hozenDomManager.getKhSntkInfoTourokusBySyono("10000000001");

        assertEquals(1, KhSntkInfoTourokuLst.size());
        assertEquals("11",KhSntkInfoTourokuLst.get(0).getRenno().toString());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("13"), "1");
        datamap.put($("14"), "2");
        datamap.put($("15"), "3");

        List<IT_KhSntkInfoTouroku> KhSntkInfoTourokuLst = hozenDomManager.getKhSntkInfoTourokusBySyono("10000000003");

        for(IT_KhSntkInfoTouroku khSntkInfoTouroku:KhSntkInfoTourokuLst){
            datamap.remove($(khSntkInfoTouroku.getRenno().toString()));
        }
        Assert.assertTrue(datamap.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<IT_KhSntkInfoTouroku> KhSntkInfoTourokuLst = hozenDomManager.getKhSntkInfoTourokusBySyono("");

        assertEquals(0, KhSntkInfoTourokuLst.size());

    }
}
