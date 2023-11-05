package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.HT_SkUriageData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkUriageDatasByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkUriageDatasByMosno {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SkUriageData> skUriageData = sinkeiyakuDomManager.getSkUriageDatasByMosno("791112220");

        Assert.assertEquals(0,skUriageData.size());

        HT_SkUriageData skUriageData1 = new HT_SkUriageData(C_AnsyuusysKbn.valueOf("0"), BizDate.valueOf(20160429), "791112220", 1);

        sinkeiyakuDomManager.insert(skUriageData1);

        HT_SkUriageData skUriageData2 = new HT_SkUriageData(C_AnsyuusysKbn.valueOf("0"), BizDate.valueOf(20160429), "791112238", 1);

        sinkeiyakuDomManager.insert(skUriageData2);

        HT_SkUriageData skUriageData3 = new HT_SkUriageData(C_AnsyuusysKbn.valueOf("1"), BizDate.valueOf(20160429), "791112238", 1);

        sinkeiyakuDomManager.insert(skUriageData3);

        HT_SkUriageData skUriageData4 = new HT_SkUriageData(C_AnsyuusysKbn.valueOf("2"), BizDate.valueOf(20160429), "791112238", 1);

        sinkeiyakuDomManager.insert(skUriageData4);

        HT_SkUriageData skUriageData5 = new HT_SkUriageData(C_AnsyuusysKbn.valueOf("0"), BizDate.valueOf(20160429), "791112246", 1);

        sinkeiyakuDomManager.insert(skUriageData5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkUriageData());
    }

    @Test
    @TestOrder(20)
    public void noResult1(){

        List<HT_SkUriageData> skUriageData = sinkeiyakuDomManager.getSkUriageDatasByMosno("791112261");

        Assert.assertEquals(0, skUriageData.size());

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<HT_SkUriageData> skUriageData = sinkeiyakuDomManager.getSkUriageDatasByMosno("791112220");


        Assert.assertEquals(1,skUriageData.size());

        Assert.assertEquals(C_AnsyuusysKbn.valueOf("0"), skUriageData.get(0).getAnsyuusyskbn());
        Assert.assertEquals(BizDate.valueOf("20160429"), skUriageData.get(0).getSyoriYmd());
        Assert.assertEquals("791112220", skUriageData.get(0).getMosno());
        Assert.assertEquals(Integer.valueOf(1), skUriageData.get(0).getAuthorikaisuu());

    }

    @Test
    @TestOrder(40)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(C_AnsyuusysKbn.valueOf("0"),BizDate.valueOf("20160429"),"791112238",Integer.valueOf(1)), "1");
        datamap.put($(C_AnsyuusysKbn.valueOf("1"),BizDate.valueOf("20160429"),"791112238",Integer.valueOf(1)), "1");
        datamap.put($(C_AnsyuusysKbn.valueOf("2"),BizDate.valueOf("20160429"),"791112238",Integer.valueOf(1)), "1");

        List<HT_SkUriageData> skUriageDataLst = sinkeiyakuDomManager.getSkUriageDatasByMosno("791112238");

        for(HT_SkUriageData skUriageData:skUriageDataLst){
            datamap.remove($(
                skUriageData.getAnsyuusyskbn(),
                skUriageData.getSyoriYmd(),
                skUriageData.getMosno(),
                skUriageData.getAuthorikaisuu()));
        }

        Assert.assertEquals(3,skUriageDataLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<HT_SkUriageData> skUriageData = sinkeiyakuDomManager.getSkUriageDatasByMosno("");

        Assert.assertEquals(0,skUriageData.size());

    }
}
