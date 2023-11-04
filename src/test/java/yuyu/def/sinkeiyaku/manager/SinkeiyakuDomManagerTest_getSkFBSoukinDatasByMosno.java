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

import yuyu.def.db.entity.HT_SkFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkFBSoukinDatasByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkFBSoukinDatasByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SkFBSoukinData> skFBSoukinData = sinkeiyakuDomManager.getSkFBSoukinDatasByMosno("791112220");
        Assert.assertEquals(0,skFBSoukinData.size());

        HT_SkFBSoukinData skFBSoukinData1 = new HT_SkFBSoukinData("11111");
        skFBSoukinData1.setMosno("791112220");

        sinkeiyakuDomManager.insert(skFBSoukinData1);

        HT_SkFBSoukinData skFBSoukinData2 = new HT_SkFBSoukinData("11112");
        skFBSoukinData2.setMosno("791112238");

        sinkeiyakuDomManager.insert(skFBSoukinData2);

        HT_SkFBSoukinData skFBSoukinData3 = new HT_SkFBSoukinData("11113");
        skFBSoukinData3.setMosno("791112246");

        sinkeiyakuDomManager.insert(skFBSoukinData3);

        HT_SkFBSoukinData skFBSoukinData4 = new HT_SkFBSoukinData("11114");
        skFBSoukinData4.setMosno("791112246");

        sinkeiyakuDomManager.insert(skFBSoukinData4);

        HT_SkFBSoukinData skFBSoukinData5 = new HT_SkFBSoukinData("11115");
        skFBSoukinData5.setMosno("791112246");

        sinkeiyakuDomManager.insert(skFBSoukinData5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkFBSoukinData());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_SkFBSoukinData> skFBSoukinData = sinkeiyakuDomManager.getSkFBSoukinDatasByMosno("791112279");
        Assert.assertEquals(0,skFBSoukinData.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_SkFBSoukinData> skFBSoukinData = sinkeiyakuDomManager.getSkFBSoukinDatasByMosno("791112220");

        Assert.assertEquals(1, skFBSoukinData.size());

        Assert.assertEquals("11111", skFBSoukinData.get(0).getFbsoukindatasikibetukey());

    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11113"), "1");
        datamap.put($("11114"), "1");
        datamap.put($("11115"), "1");

        List<HT_SkFBSoukinData> skFBSoukinDataLst = sinkeiyakuDomManager.getSkFBSoukinDatasByMosno("791112246");

        for(HT_SkFBSoukinData skFBSoukinData:skFBSoukinDataLst){
            datamap.remove($(
                skFBSoukinData.getFbsoukindatasikibetukey()));
        }

        Assert.assertEquals(3, skFBSoukinDataLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HT_SkFBSoukinData> skDenpyoDataLst = sinkeiyakuDomManager.getSkFBSoukinDatasByMosno("");
        Assert.assertEquals(0,skDenpyoDataLst.size());
    }
}
