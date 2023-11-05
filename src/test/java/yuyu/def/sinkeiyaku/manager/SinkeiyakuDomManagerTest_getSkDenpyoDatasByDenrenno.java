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
 * getSkDenpyoDatasByDenrenno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkDenpyoDatasByDenrenno {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno("10000000060");
        Assert.assertEquals(0,skDenpyoDataLst.size());

        HT_SkDenpyoData skDenpyoData = new HT_SkDenpyoData();
        skDenpyoData.setDenrenno("10000000060");
        skDenpyoData.setEdano(60);
        sinkeiyakuDomManager.insert(skDenpyoData);

        HT_SkDenpyoData skDenpyoData1 = new HT_SkDenpyoData();
        skDenpyoData1.setDenrenno("10000000060");
        skDenpyoData1.setEdano(70);
        sinkeiyakuDomManager.insert(skDenpyoData1);

        HT_SkDenpyoData skDenpyoData2 = new HT_SkDenpyoData();
        skDenpyoData2.setDenrenno("10000000060");
        skDenpyoData2.setEdano(80);
        sinkeiyakuDomManager.insert(skDenpyoData2);

        HT_SkDenpyoData skDenpyoData3 = new HT_SkDenpyoData();
        skDenpyoData3.setDenrenno("10000000070");
        skDenpyoData3.setEdano(90);
        sinkeiyakuDomManager.insert(skDenpyoData3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkDenpyoData());
    }

    @Test
    @TestOrder(20)
    public void noResult1(){

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno("10000000080");
        Assert.assertEquals(0,skDenpyoDataLst.size());

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno("10000000070");

        Assert.assertEquals(1, skDenpyoDataLst.size());
        Assert.assertEquals("10000000070", skDenpyoDataLst.get(0).getDenrenno());
        Assert.assertEquals(Integer.valueOf(90), skDenpyoDataLst.get(0).getEdano());

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10000000060",Integer.valueOf(60)), "1");
        datamap.put($("10000000060",Integer.valueOf(70)), "1");
        datamap.put($("10000000060",Integer.valueOf(80)), "1");

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno("10000000060");

        for(HT_SkDenpyoData skDenpyoData:skDenpyoDataLst){
            datamap.remove($(
                skDenpyoData.getDenrenno(),
                skDenpyoData.getEdano()));
        }

        Assert.assertEquals(3, skDenpyoDataLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<HT_SkDenpyoData> skDenpyoDataLst = sinkeiyakuDomManager.getSkDenpyoDatasByDenrenno("");
        Assert.assertEquals(0,skDenpyoDataLst.size());
    }
}
