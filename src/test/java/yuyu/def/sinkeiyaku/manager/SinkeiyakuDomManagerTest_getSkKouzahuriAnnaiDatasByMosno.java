package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.db.entity.HT_SkKouzahuriAnnaiData;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSkKouzahuriAnnaiDatasByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSkKouzahuriAnnaiDatasByMosno {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SkKouzahuriAnnaiData> skKouzahuriAnnaiData = sinkeiyakuDomManager.getSkKouzahuriAnnaiDatasByMosno("791112220");

        Assert.assertEquals(0,skKouzahuriAnnaiData.size());

        HT_SkKouzahuriAnnaiData skKouzahuriAnnaiData1 = new HT_SkKouzahuriAnnaiData(C_AnsyuusysKbn.valueOf("0"),
            BizDate.valueOf(20160503), "791112220", C_NyknaiyouKbn.valueOf("0"), BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(skKouzahuriAnnaiData1);

        HT_SkKouzahuriAnnaiData skKouzahuriAnnaiData2 = new HT_SkKouzahuriAnnaiData(C_AnsyuusysKbn.valueOf("0"),
            BizDate.valueOf(20160503), "791112238", C_NyknaiyouKbn.valueOf("0"), BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(skKouzahuriAnnaiData2);

        HT_SkKouzahuriAnnaiData skKouzahuriAnnaiData3 = new HT_SkKouzahuriAnnaiData(C_AnsyuusysKbn.valueOf("1"),
            BizDate.valueOf(20160503), "791112238", C_NyknaiyouKbn.valueOf("0"), BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(skKouzahuriAnnaiData3);

        HT_SkKouzahuriAnnaiData skKouzahuriAnnaiData4 = new HT_SkKouzahuriAnnaiData(C_AnsyuusysKbn.valueOf("2"),
            BizDate.valueOf(20160503), "791112238", C_NyknaiyouKbn.valueOf("0"), BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(skKouzahuriAnnaiData4);

        HT_SkKouzahuriAnnaiData skKouzahuriAnnaiData5 = new HT_SkKouzahuriAnnaiData(C_AnsyuusysKbn.valueOf("0"),
            BizDate.valueOf(20160503), "791112246", C_NyknaiyouKbn.valueOf("0"), BizDateYM.valueOf(201605));

        sinkeiyakuDomManager.insert(skKouzahuriAnnaiData5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSkKouzahuriAnnaiData());
    }

    @Test
    @TestOrder(20)
    public void noResult1(){

        List<HT_SkKouzahuriAnnaiData> skKouzahuriAnnaiData = sinkeiyakuDomManager.getSkKouzahuriAnnaiDatasByMosno("791112261");

        Assert.assertEquals(0, skKouzahuriAnnaiData.size());

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<HT_SkKouzahuriAnnaiData> skKouzahuriAnnaiData = sinkeiyakuDomManager.getSkKouzahuriAnnaiDatasByMosno("791112220");


        Assert.assertEquals(1,skKouzahuriAnnaiData.size());

        Assert.assertEquals(C_AnsyuusysKbn.valueOf("0"), skKouzahuriAnnaiData.get(0).getAnsyuusyskbn());
        Assert.assertEquals(BizDate.valueOf("20160503"), skKouzahuriAnnaiData.get(0).getSyoriYmd());
        Assert.assertEquals("791112220", skKouzahuriAnnaiData.get(0).getMosno());
        Assert.assertEquals(C_NyknaiyouKbn.BLNK, skKouzahuriAnnaiData.get(0).getNyknaiyoukbn());
        Assert.assertEquals(BizDateYM.valueOf("201605"), skKouzahuriAnnaiData.get(0).getJyuutouym());

    }

    @Test
    @TestOrder(40)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(C_AnsyuusysKbn.valueOf("0"),BizDate.valueOf("20160503"),"791112238",C_NyknaiyouKbn.BLNK,BizDateYM.valueOf("201605")), "1");
        datamap.put($(C_AnsyuusysKbn.valueOf("1"),BizDate.valueOf("20160503"),"791112238",C_NyknaiyouKbn.BLNK,BizDateYM.valueOf("201605")), "1");
        datamap.put($(C_AnsyuusysKbn.valueOf("2"),BizDate.valueOf("20160503"),"791112238",C_NyknaiyouKbn.BLNK,BizDateYM.valueOf("201605")), "1");

        List<HT_SkKouzahuriAnnaiData> skKouzahuriAnnaiDataLst = sinkeiyakuDomManager.getSkKouzahuriAnnaiDatasByMosno("791112238");


        for(HT_SkKouzahuriAnnaiData skKouzahuriAnnaiData:skKouzahuriAnnaiDataLst){
            datamap.remove($(
                skKouzahuriAnnaiData.getAnsyuusyskbn(),
                skKouzahuriAnnaiData.getSyoriYmd(),
                skKouzahuriAnnaiData.getMosno(),
                skKouzahuriAnnaiData.getNyknaiyoukbn(),
                skKouzahuriAnnaiData.getJyuutouym()));
        }

        Assert.assertEquals(3,skKouzahuriAnnaiDataLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<HT_SkKouzahuriAnnaiData> skKouzahuriAnnaiData = sinkeiyakuDomManager.getSkKouzahuriAnnaiDatasByMosno("");

        Assert.assertEquals(0,skKouzahuriAnnaiData.size());

    }
}