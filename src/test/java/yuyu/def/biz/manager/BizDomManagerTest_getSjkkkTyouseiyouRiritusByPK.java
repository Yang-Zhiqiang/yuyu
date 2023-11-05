package yuyu.def.biz.manager;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

/**
 * BizDomManagerクラスの、<br />
 * getSjkkkTyouseiyouRiritusByPK() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSjkkkTyouseiyouRiritusByPK {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        List<BM_SjkkkTyouseiyouRiritu> BM_SjkkkTyouseiyouRiritu = bizDomManager.getSjkkkTyouseiyouRiritusByPK("01",
            C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.valueOf("0"),BizDate.valueOf(20160702), BizDate.valueOf(20160801));

        Assert.assertEquals(0,BM_SjkkkTyouseiyouRiritu.size());


        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu1 = new BM_SjkkkTyouseiyouRiritu("01", C_Tuukasyu.valueOf("JPY"),
            C_HhknNenKbn.valueOf("0"), BizDate.valueOf(20160702), BizDate.valueOf(20160801));

        bizDomManager.insert(sjkkkTyouseiyouRiritu1);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu2 = new BM_SjkkkTyouseiyouRiritu("02", C_Tuukasyu.valueOf("EUR"),
            C_HhknNenKbn.valueOf("1"), BizDate.valueOf(20160703), BizDate.valueOf(20160802));

        bizDomManager.insert(sjkkkTyouseiyouRiritu2);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu3 = new BM_SjkkkTyouseiyouRiritu("02", C_Tuukasyu.valueOf("EUR"),
            C_HhknNenKbn.valueOf("1"), BizDate.valueOf(20160704), BizDate.valueOf(20160803));

        bizDomManager.insert(sjkkkTyouseiyouRiritu3);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu4 = new BM_SjkkkTyouseiyouRiritu("02", C_Tuukasyu.valueOf("EUR"),
            C_HhknNenKbn.valueOf("1"), BizDate.valueOf(20160705), BizDate.valueOf(20160804));

        bizDomManager.insert(sjkkkTyouseiyouRiritu4);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu5 = new BM_SjkkkTyouseiyouRiritu("03", C_Tuukasyu.valueOf("JPY"),
            C_HhknNenKbn.valueOf("0"), BizDate.valueOf(20160702), BizDate.valueOf(20160801));

        bizDomManager.insert(sjkkkTyouseiyouRiritu5);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu6 = new BM_SjkkkTyouseiyouRiritu("01", C_Tuukasyu.valueOf("USD"),
            C_HhknNenKbn.valueOf("0"), BizDate.valueOf(20160702), BizDate.valueOf(20160801));

        bizDomManager.insert(sjkkkTyouseiyouRiritu6);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu7 = new BM_SjkkkTyouseiyouRiritu("01", C_Tuukasyu.valueOf("JPY"),
            C_HhknNenKbn.valueOf("2"), BizDate.valueOf(20160702), BizDate.valueOf(20160801));

        bizDomManager.insert(sjkkkTyouseiyouRiritu7);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu8 = new BM_SjkkkTyouseiyouRiritu("01", C_Tuukasyu.valueOf("JPY"),
            C_HhknNenKbn.valueOf("0"), BizDate.valueOf(20160703), BizDate.valueOf(20160801));

        bizDomManager.insert(sjkkkTyouseiyouRiritu8);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu9 = new BM_SjkkkTyouseiyouRiritu("01", C_Tuukasyu.valueOf("JPY"),
            C_HhknNenKbn.valueOf("0"), BizDate.valueOf(20160702), BizDate.valueOf(20160731));

        bizDomManager.insert(sjkkkTyouseiyouRiritu9);




    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSjkkkTyouseiyouRiritu());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BM_SjkkkTyouseiyouRiritu> BM_SjkkkTyouseiyouRiritu = bizDomManager.getSjkkkTyouseiyouRiritusByPK("04",
            C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.valueOf("0"),BizDate.valueOf(20160702), BizDate.valueOf(20160801));

        Assert.assertEquals(0,BM_SjkkkTyouseiyouRiritu.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BM_SjkkkTyouseiyouRiritu> BM_SjkkkTyouseiyouRiritu = bizDomManager.getSjkkkTyouseiyouRiritusByPK("01",
            C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.valueOf("0"),BizDate.valueOf(20160702), BizDate.valueOf(20160801));

        Assert.assertEquals(1,BM_SjkkkTyouseiyouRiritu.size());

        assertEquals("01", BM_SjkkkTyouseiyouRiritu.get(0).getSyouhncd());
        assertEquals(C_Tuukasyu.valueOf("JPY"), BM_SjkkkTyouseiyouRiritu.get(0).getTuukasyu());
        assertEquals(C_HhknNenKbn.valueOf("0"), BM_SjkkkTyouseiyouRiritu.get(0).getHhknnenkbn());
        assertEquals(BizDate.valueOf(20160702), BM_SjkkkTyouseiyouRiritu.get(0).getKykfromymd());
        assertEquals(BizDate.valueOf(20160801), BM_SjkkkTyouseiyouRiritu.get(0).getKyktoymd());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BM_SjkkkTyouseiyouRiritu> BM_SjkkkTyouseiyouRiritu  = bizDomManager.getSjkkkTyouseiyouRiritusByPK("02",
            C_Tuukasyu.valueOf("EUR"), C_HhknNenKbn.valueOf("1"),BizDate.valueOf(20160705), BizDate.valueOf(20160802));

        Assert.assertEquals(3,BM_SjkkkTyouseiyouRiritu.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("02",C_Tuukasyu.valueOf("EUR"),C_HhknNenKbn.valueOf("1"),BizDate.valueOf(20160703),BizDate.valueOf(20160802)), "1");
        map.put($("02",C_Tuukasyu.valueOf("EUR"),C_HhknNenKbn.valueOf("1"),BizDate.valueOf(20160704),BizDate.valueOf(20160803)), "1");
        map.put($("02",C_Tuukasyu.valueOf("EUR"),C_HhknNenKbn.valueOf("1"),BizDate.valueOf(20160705),BizDate.valueOf(20160804)), "1");

        assertTrue(map.containsKey($(BM_SjkkkTyouseiyouRiritu.get(0).getSyouhncd(),BM_SjkkkTyouseiyouRiritu.get(0).getTuukasyu(),BM_SjkkkTyouseiyouRiritu.get(0).getHhknnenkbn(),
            BM_SjkkkTyouseiyouRiritu.get(0).getKykfromymd(),BM_SjkkkTyouseiyouRiritu.get(0).getKyktoymd())));

        assertTrue(map.containsKey($(BM_SjkkkTyouseiyouRiritu.get(1).getSyouhncd(),BM_SjkkkTyouseiyouRiritu.get(1).getTuukasyu(),BM_SjkkkTyouseiyouRiritu.get(1).getHhknnenkbn(),
            BM_SjkkkTyouseiyouRiritu.get(1).getKykfromymd(),BM_SjkkkTyouseiyouRiritu.get(1).getKyktoymd())));

        assertTrue(map.containsKey($(BM_SjkkkTyouseiyouRiritu.get(2).getSyouhncd(),BM_SjkkkTyouseiyouRiritu.get(2).getTuukasyu(),BM_SjkkkTyouseiyouRiritu.get(2).getHhknnenkbn(),
            BM_SjkkkTyouseiyouRiritu.get(2).getKykfromymd(),BM_SjkkkTyouseiyouRiritu.get(2).getKyktoymd())));

        map.remove($(BM_SjkkkTyouseiyouRiritu.get(0).getSyouhncd(),BM_SjkkkTyouseiyouRiritu.get(0).getTuukasyu(),BM_SjkkkTyouseiyouRiritu.get(0).getHhknnenkbn(),
            BM_SjkkkTyouseiyouRiritu.get(0).getKykfromymd(),BM_SjkkkTyouseiyouRiritu.get(0).getKyktoymd()));

        map.remove($(BM_SjkkkTyouseiyouRiritu.get(1).getSyouhncd(),BM_SjkkkTyouseiyouRiritu.get(1).getTuukasyu(),BM_SjkkkTyouseiyouRiritu.get(1).getHhknnenkbn(),
            BM_SjkkkTyouseiyouRiritu.get(1).getKykfromymd(),BM_SjkkkTyouseiyouRiritu.get(1).getKyktoymd()));

        map.remove($(BM_SjkkkTyouseiyouRiritu.get(2).getSyouhncd(),BM_SjkkkTyouseiyouRiritu.get(2).getTuukasyu(),BM_SjkkkTyouseiyouRiritu.get(2).getHhknnenkbn(),
            BM_SjkkkTyouseiyouRiritu.get(2).getKykfromymd(),BM_SjkkkTyouseiyouRiritu.get(2).getKyktoymd()));

        assertTrue(map.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_SjkkkTyouseiyouRiritu> BM_SjkkkTyouseiyouRiritu = bizDomManager.getSjkkkTyouseiyouRiritusByPK("",
            C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.valueOf("0"),BizDate.valueOf(20160702), BizDate.valueOf(20160801));

        Assert.assertEquals(0,BM_SjkkkTyouseiyouRiritu.size());
    }
}
