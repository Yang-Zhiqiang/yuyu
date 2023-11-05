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

import yuyu.def.db.entity.HT_BAK_SkDenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getBAKSkDenpyoDatasBySyonoTrkssikibetukey() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getBAKSkDenpyoDatasBySyonoTrkssikibetukey {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasBySyonoTrkssikibetukey("1001", "M101");

        Assert.assertEquals(0,bAK_SkDenpyoDataLst.size());

        HT_BAK_SkDenpyoData bAK_SkDenpyoData = new HT_BAK_SkDenpyoData();
        bAK_SkDenpyoData.setDenrenno("1");
        bAK_SkDenpyoData.setSyono("1001");
        bAK_SkDenpyoData.setTrkssikibetukey("M101");
        bAK_SkDenpyoData.setEdano(1);
        sinkeiyakuDomManager.insert(bAK_SkDenpyoData);

        HT_BAK_SkDenpyoData bAK_SkDenpyoData2 = new HT_BAK_SkDenpyoData();
        bAK_SkDenpyoData2.setDenrenno("1");
        bAK_SkDenpyoData2.setSyono("1001");
        bAK_SkDenpyoData2.setTrkssikibetukey("M102");
        bAK_SkDenpyoData2.setEdano(1);
        sinkeiyakuDomManager.insert(bAK_SkDenpyoData2);

        HT_BAK_SkDenpyoData bAK_SkDenpyoData3 = new HT_BAK_SkDenpyoData();
        bAK_SkDenpyoData3.setDenrenno("2");
        bAK_SkDenpyoData3.setSyono("1001");
        bAK_SkDenpyoData3.setTrkssikibetukey("M102");
        bAK_SkDenpyoData3.setEdano(1);
        sinkeiyakuDomManager.insert(bAK_SkDenpyoData3);

        HT_BAK_SkDenpyoData bAK_SkDenpyoData4 = new HT_BAK_SkDenpyoData();
        bAK_SkDenpyoData4.setDenrenno("3");
        bAK_SkDenpyoData4.setSyono("1001");
        bAK_SkDenpyoData4.setTrkssikibetukey("M102");
        bAK_SkDenpyoData4.setEdano(1);
        sinkeiyakuDomManager.insert(bAK_SkDenpyoData4);

        HT_BAK_SkDenpyoData bAK_SkDenpyoData5 = new HT_BAK_SkDenpyoData();
        bAK_SkDenpyoData5.setDenrenno("4");
        bAK_SkDenpyoData5.setSyono("1002");
        bAK_SkDenpyoData5.setTrkssikibetukey("M101");
        bAK_SkDenpyoData5.setEdano(1);
        sinkeiyakuDomManager.insert(bAK_SkDenpyoData5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBAKSkDenpyoData());
    }

    @Test
    @TestOrder(20)
    public void noResult1(){

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasBySyonoTrkssikibetukey("2001", "M101");

        Assert.assertEquals(0, bAK_SkDenpyoDataLst.size());

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasBySyonoTrkssikibetukey("1001", "M101");

        Assert.assertEquals(1, bAK_SkDenpyoDataLst.size());
        Assert.assertEquals("1", bAK_SkDenpyoDataLst.get(0).getDenrenno());
        Assert.assertEquals("1001", bAK_SkDenpyoDataLst.get(0).getSyono());
        Assert.assertEquals("M101", bAK_SkDenpyoDataLst.get(0).getTrkssikibetukey());
        Assert.assertEquals(1, bAK_SkDenpyoDataLst.get(0).getEdano().intValue());

    }
    @Test
    @TestOrder(40)
    public void normal2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("1","1001","M102",1), "1");
        datamap.put($("2","1001","M102",1), "1");
        datamap.put($("3","1001","M102",1), "1");


        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasBySyonoTrkssikibetukey("1001", "M102");

        for(HT_BAK_SkDenpyoData bakskDenpyoData:bAK_SkDenpyoDataLst){
            datamap.remove($(
                bakskDenpyoData.getDenrenno(),
                bakskDenpyoData.getSyono(),
                bakskDenpyoData.getTrkssikibetukey(),
                bakskDenpyoData.getEdano().intValue()));
        }

        Assert.assertEquals(3, bAK_SkDenpyoDataLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasBySyonoTrkssikibetukey("", "M101");

        assertEquals(0, bAK_SkDenpyoDataLst.size());

    }

    @Test
    @TestOrder(60)
    public void blankCondition2() {

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasBySyonoTrkssikibetukey("1001", "");

        assertEquals(0, bAK_SkDenpyoDataLst.size());

    }

    @Test
    @TestOrder(70)
    @Transactional
    public void delete1(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("1","1001","M102",1), "1");
        datamap.put($("2","1001","M102",1), "1");
        datamap.put($("3","1001","M102",1), "1");


        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasBySyonoTrkssikibetukey("1001", "M102");

        for(HT_BAK_SkDenpyoData bakskDenpyoData:bAK_SkDenpyoDataLst){
            datamap.remove($(
                bakskDenpyoData.getDenrenno(),
                bakskDenpyoData.getSyono(),
                bakskDenpyoData.getTrkssikibetukey(),
                bakskDenpyoData.getEdano().intValue()));
        }

        Assert.assertTrue(datamap.isEmpty());

        sinkeiyakuDomManager.delete(bAK_SkDenpyoDataLst);

    }

    @Test
    @TestOrder(80)
    public void delete2(){

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasBySyonoTrkssikibetukey("1001", "M102");

        assertEquals(0, bAK_SkDenpyoDataLst.size());



    }
}
