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

import yuyu.def.db.entity.HT_SkGaikaFBSoukinData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkGaikaFBSoukinDatasByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkGaikaFBSoukinDatasByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SkGaikaFBSoukinData> ｓkGaikaFBSoukinData = sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByMosno("791112220");

        Assert.assertEquals(0, ｓkGaikaFBSoukinData.size());


        HT_SkGaikaFBSoukinData skGaikaFBSoukinData1 = new HT_SkGaikaFBSoukinData("FBSK1111");
        skGaikaFBSoukinData1.setMosno("791112220");

        sinkeiyakuDomManager.insert(skGaikaFBSoukinData1);

        HT_SkGaikaFBSoukinData skGaikaFBSoukinData2 = new HT_SkGaikaFBSoukinData("FBSK2222");
        skGaikaFBSoukinData2.setMosno("791112238");

        sinkeiyakuDomManager.insert(skGaikaFBSoukinData2);

        HT_SkGaikaFBSoukinData skGaikaFBSoukinData3 = new HT_SkGaikaFBSoukinData("FBSK3333");
        skGaikaFBSoukinData3.setMosno("791112246");

        sinkeiyakuDomManager.insert(skGaikaFBSoukinData3);

        HT_SkGaikaFBSoukinData skGaikaFBSoukinData4 = new HT_SkGaikaFBSoukinData("FBSK4444");
        skGaikaFBSoukinData4.setMosno("791112246");

        sinkeiyakuDomManager.insert(skGaikaFBSoukinData4);

        HT_SkGaikaFBSoukinData skGaikaFBSoukinData5 = new HT_SkGaikaFBSoukinData("FBSK5555");
        skGaikaFBSoukinData5.setMosno("791112246");

        sinkeiyakuDomManager.insert(skGaikaFBSoukinData5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkGaikaFBSoukinData());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_SkGaikaFBSoukinData> skGaikaFBSoukinData = sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByMosno(
            "791112279");

        assertEquals(0, skGaikaFBSoukinData.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_SkGaikaFBSoukinData> skGaikaFBSoukinData = sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByMosno(
            "791112220");

        assertEquals(1, skGaikaFBSoukinData.size());

        assertEquals("FBSK1111", skGaikaFBSoukinData.get(0).getFbsoukindatasikibetukey());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("FBSK3333"), "1");
        datamap.put($("FBSK4444"), "1");
        datamap.put($("FBSK5555"), "1");


        List<HT_SkGaikaFBSoukinData> skGaikaFBSoukinDataLst = sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByMosno(
            "791112246");

        for(HT_SkGaikaFBSoukinData skGaikaFBSoukinData:skGaikaFBSoukinDataLst){
            datamap.remove($(
                skGaikaFBSoukinData.getFbsoukindatasikibetukey()));
        }

        assertEquals(3, skGaikaFBSoukinDataLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<HT_SkGaikaFBSoukinData> skGaikaFBSoukinData = sinkeiyakuDomManager.getSkGaikaFBSoukinDatasByMosno(
            "");
        Assert.assertEquals(0, skGaikaFBSoukinData.size());

    }
}
