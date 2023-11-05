package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.db.entity.HT_SisyaToukeiHokan;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSisyaToukeiHokansBySstmosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSisyaToukeiHokansBySstmosno {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SisyaToukeiHokan> sisyaToukeiHokan = sinkeiyakuDomManager.getSisyaToukeiHokansBySstmosno("791112220");

        Assert.assertEquals(0,sisyaToukeiHokan.size());

        HT_SisyaToukeiHokan sisyaToukeiHokan1 = new HT_SisyaToukeiHokan("791112220", 1);

        sinkeiyakuDomManager.insert(sisyaToukeiHokan1);

        HT_SisyaToukeiHokan sisyaToukeiHokan2 = new HT_SisyaToukeiHokan("791112238", 2);

        sinkeiyakuDomManager.insert(sisyaToukeiHokan2);

        HT_SisyaToukeiHokan sisyaToukeiHokan3 = new HT_SisyaToukeiHokan("791112238", 3);

        sinkeiyakuDomManager.insert(sisyaToukeiHokan3);

        HT_SisyaToukeiHokan sisyaToukeiHokan4 = new HT_SisyaToukeiHokan("791112238", 4);

        sinkeiyakuDomManager.insert(sisyaToukeiHokan4);

        HT_SisyaToukeiHokan sisyaToukeiHokan5 = new HT_SisyaToukeiHokan("791112246", 5);

        sinkeiyakuDomManager.insert(sisyaToukeiHokan5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSisyaToukeiHokan());
    }

    @Test
    @TestOrder(20)
    public void noResult1(){

        List<HT_SisyaToukeiHokan> sisyaToukeiHokan = sinkeiyakuDomManager.getSisyaToukeiHokansBySstmosno("791112219");

        Assert.assertEquals(0, sisyaToukeiHokan.size());

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<HT_SisyaToukeiHokan> sisyaToukeiHokan = sinkeiyakuDomManager.getSisyaToukeiHokansBySstmosno("791112220");


        Assert.assertEquals(1,sisyaToukeiHokan.size());

        Assert.assertEquals("791112220", sisyaToukeiHokan.get(0).getSstmosno());
        Assert.assertEquals(Integer.valueOf(1), sisyaToukeiHokan.get(0).getRenno());

    }

    @Test
    @TestOrder(40)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112238",Integer.valueOf(2)), "1");
        datamap.put($("791112238",Integer.valueOf(3)), "1");
        datamap.put($("791112238",Integer.valueOf(4)), "1");

        List<HT_SisyaToukeiHokan> sisyaToukeiHokanlst = sinkeiyakuDomManager.getSisyaToukeiHokansBySstmosno("791112238");

        for(HT_SisyaToukeiHokan sisyaToukeiHokan:sisyaToukeiHokanlst){
            datamap.remove($(
                sisyaToukeiHokan.getSstmosno(),
                sisyaToukeiHokan.getRenno()));
        }

        Assert.assertEquals(3,sisyaToukeiHokanlst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<HT_SisyaToukeiHokan> sisyaToukeiHokan = sinkeiyakuDomManager.getSisyaToukeiHokansBySstmosno("");

        assertEquals(0,sisyaToukeiHokan.size());

    }
}
