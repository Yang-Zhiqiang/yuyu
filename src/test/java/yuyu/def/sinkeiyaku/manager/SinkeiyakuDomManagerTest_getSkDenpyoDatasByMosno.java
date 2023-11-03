package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

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

import yuyu.def.db.entity.HT_SkDenpyoData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkDenpyoDatasByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkDenpyoDatasByMosno {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByMosno("791112220");
        Assert.assertEquals(0, skDenpyoDataLst.size());

        HT_SkDenpyoData skDenpyoData1 = new HT_SkDenpyoData("1", 10);
        skDenpyoData1.setMosno("791112220");

        sinkeiyakuDomManager.insert(skDenpyoData1);

        HT_SkDenpyoData skDenpyoData2 = new HT_SkDenpyoData("2", 10);
        skDenpyoData2.setMosno("791112329");

        sinkeiyakuDomManager.insert(skDenpyoData2);

        HT_SkDenpyoData skDenpyoData3 = new HT_SkDenpyoData("3", 30);
        skDenpyoData3.setMosno("791112238");

        sinkeiyakuDomManager.insert(skDenpyoData3);

        HT_SkDenpyoData skDenpyoData4 = new HT_SkDenpyoData("4", 40);
        skDenpyoData4.setMosno("791112238");

        sinkeiyakuDomManager.insert(skDenpyoData4);

        HT_SkDenpyoData skDenpyoData5 = new HT_SkDenpyoData("5", 50);
        skDenpyoData5.setMosno("791112238");

        sinkeiyakuDomManager.insert(skDenpyoData5);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDenpyoData());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByMosno("791112261");
        Assert.assertEquals(0, skDenpyoDataLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByMosno("791112220");

        Assert.assertEquals(1, skDenpyoDataLst.size());
        Assert.assertEquals("1", skDenpyoDataLst.get(0).getDenrenno());
        Assert.assertEquals(Integer.valueOf(10), skDenpyoDataLst.get(0).getEdano());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("3",Integer.valueOf(30)), "1");
        datamap.put($("4",Integer.valueOf(40)), "1");
        datamap.put($("5",Integer.valueOf(50)), "1");

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByMosno("791112238");

        for(HT_SkDenpyoData skDenpyoData:skDenpyoDataLst){

            datamap.remove($(
                skDenpyoData.getDenrenno(),
                skDenpyoData.getEdano()));
        }

        Assert.assertEquals(3, skDenpyoDataLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByMosno("");
        Assert.assertEquals(0, skDenpyoDataLst.size());
    }
}
