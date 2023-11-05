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

import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe {
    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe("1234430", "791112238");

        Assert.assertEquals(0, syoriCTLLst.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setDaimosno("1234431");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.NONE);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setDaimosno("1234430");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.ITIPMATI);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setDaimosno("1234430");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.NONE);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setDaimosno("1234430");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.valueOf("1"));

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setDaimosno("1234430");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.HUSEIRITU);

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setDaimosno("1234430");
        syoriCTL6.setSeiritukbn(C_SeirituKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");
        syoriCTL7.setDaimosno("1234430");
        syoriCTL7.setSeiritukbn(C_SeirituKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL7);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe("1234450", "791112238");

        Assert.assertEquals(0, syoriCTLLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe("1234431", "791112238");

        Assert.assertEquals(1, syoriCTLLst.size());
        Assert.assertEquals("791112220", syoriCTLLst.get(0).getMosno());
    }

    @Test
    @TestOrder(30)
    public void normal2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112246"), "1");
        datamap.put($("791112279"), "1");
        datamap.put($("791112287"), "1");

        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe("1234430", "791112238");

        for(HT_SyoriCTL syoriCTL:syoriCTLLst){
            datamap.remove($(
                syoriCTL.getMosno()));
        }

        Assert.assertEquals(3, syoriCTLLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1(){

        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe("", "791112238");

        Assert.assertEquals(0, syoriCTLLst.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2(){
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112238"), "1");
        datamap.put($("791112246"), "1");
        datamap.put($("791112279"), "1");
        datamap.put($("791112287"), "1");

        List<HT_SyoriCTL> syoriCTLLst = sinkeiyakuDomManager.getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe("1234430", "");

        for(HT_SyoriCTL syoriCTL:syoriCTLLst){
            datamap.remove($(
                syoriCTL.getMosno()));
        }

        Assert.assertEquals(4, syoriCTLLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}
