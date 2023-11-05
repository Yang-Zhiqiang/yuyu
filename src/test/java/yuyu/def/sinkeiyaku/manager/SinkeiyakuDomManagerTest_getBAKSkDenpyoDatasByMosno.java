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
 * getBAKSkDenpyoDatasByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getBAKSkDenpyoDatasByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasByMosno("791112220");

        Assert.assertEquals(0,bAK_SkDenpyoDataLst.size());

        HT_BAK_SkDenpyoData bAK_SkDenpyoData1 = new HT_BAK_SkDenpyoData("1111", "0001", 01);
        bAK_SkDenpyoData1.setMosno("791112220");

        sinkeiyakuDomManager.insert(bAK_SkDenpyoData1);

        HT_BAK_SkDenpyoData bAK_SkDenpyoData2 = new HT_BAK_SkDenpyoData("5555", "0001", 01);
        bAK_SkDenpyoData2.setMosno("791112246");

        sinkeiyakuDomManager.insert(bAK_SkDenpyoData2);

        HT_BAK_SkDenpyoData bAK_SkDenpyoData3 = new HT_BAK_SkDenpyoData("2222", "0001", 01);
        bAK_SkDenpyoData3.setMosno("791112238");

        sinkeiyakuDomManager.insert(bAK_SkDenpyoData3);

        HT_BAK_SkDenpyoData bAK_SkDenpyoData4 = new HT_BAK_SkDenpyoData("3333", "0001", 01);
        bAK_SkDenpyoData4.setMosno("791112238");

        sinkeiyakuDomManager.insert(bAK_SkDenpyoData4);

        HT_BAK_SkDenpyoData bAK_SkDenpyoData5 = new HT_BAK_SkDenpyoData("4444", "0001", 01);
        bAK_SkDenpyoData5.setMosno("791112238");

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

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasByMosno("791112345");

        Assert.assertEquals(0,bAK_SkDenpyoDataLst.size());

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasByMosno("791112220");

        Assert.assertEquals(1, bAK_SkDenpyoDataLst.size());
        Assert.assertEquals("1111", bAK_SkDenpyoDataLst.get(0).getDenrenno());
        Assert.assertEquals("0001", bAK_SkDenpyoDataLst.get(0).getTrkssikibetukey());
        Assert.assertEquals(01, bAK_SkDenpyoDataLst.get(0).getEdano().intValue());

    }
    @Test
    @TestOrder(40)
    public void normal2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("2222","0001",01), "1");
        datamap.put($("3333","0001",01), "1");
        datamap.put($("4444","0001",01), "1");

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasByMosno("791112238");

        for(HT_BAK_SkDenpyoData bakskDenpyoData:bAK_SkDenpyoDataLst){
            datamap.remove($(
                bakskDenpyoData.getDenrenno(),
                bakskDenpyoData.getTrkssikibetukey(),
                bakskDenpyoData.getEdano().intValue()));
        }

        Assert.assertEquals(3, bAK_SkDenpyoDataLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<HT_BAK_SkDenpyoData> bAK_SkDenpyoDataLst = sinkeiyakuDomManager.getBAKSkDenpyoDatasByMosno("");

        assertEquals(0, bAK_SkDenpyoDataLst.size());

    }

}

