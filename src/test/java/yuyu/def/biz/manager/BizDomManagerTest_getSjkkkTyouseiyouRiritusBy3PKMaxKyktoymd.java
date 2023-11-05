package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
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

/**
 * BizDomManagerクラスの、<br />
 * getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymdK() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        List<BM_SjkkkTyouseiyouRiritu> sjkkkTyouseiyouRirituLst = bizDomManager.getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(
            "0001", C_Tuukasyu.BLNK, C_HhknNenKbn.BLNK);

        Assert.assertEquals(0,sjkkkTyouseiyouRirituLst.size());

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu1 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.valueOf("0"),
            C_HhknNenKbn.valueOf("0"), BizDate.valueOf(20160519), BizDate.valueOf(20160920));

        bizDomManager.insert(sjkkkTyouseiyouRiritu1);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu2 = new BM_SjkkkTyouseiyouRiritu("0011", C_Tuukasyu.valueOf("0"),
            C_HhknNenKbn.valueOf("0"), BizDate.valueOf(20160520), BizDate.valueOf(20160923));

        bizDomManager.insert(sjkkkTyouseiyouRiritu2);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu3 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.valueOf("JPY"),
            C_HhknNenKbn.valueOf("0"), BizDate.valueOf(20160521), BizDate.valueOf(20160922));

        bizDomManager.insert(sjkkkTyouseiyouRiritu3);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu4 = new BM_SjkkkTyouseiyouRiritu("0001", C_Tuukasyu.valueOf("0"),
            C_HhknNenKbn.valueOf("1"), BizDate.valueOf(20160522), BizDate.valueOf(20160920));

        bizDomManager.insert(sjkkkTyouseiyouRiritu4);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu5 = new BM_SjkkkTyouseiyouRiritu("0002", C_Tuukasyu.valueOf("USD"),
            C_HhknNenKbn.valueOf("2"), BizDate.valueOf(20160518), BizDate.valueOf(20160920));

        bizDomManager.insert(sjkkkTyouseiyouRiritu5);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu6 = new BM_SjkkkTyouseiyouRiritu("0002", C_Tuukasyu.valueOf("USD"),
            C_HhknNenKbn.valueOf("2"), BizDate.valueOf(20160519), BizDate.valueOf(20160920));

        bizDomManager.insert(sjkkkTyouseiyouRiritu6);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu7 = new BM_SjkkkTyouseiyouRiritu("0002", C_Tuukasyu.valueOf("USD"),
            C_HhknNenKbn.valueOf("2"), BizDate.valueOf(20160520), BizDate.valueOf(20160920));

        bizDomManager.insert(sjkkkTyouseiyouRiritu7);

        BM_SjkkkTyouseiyouRiritu sjkkkTyouseiyouRiritu8 = new BM_SjkkkTyouseiyouRiritu("0002", C_Tuukasyu.valueOf("USD"),
            C_HhknNenKbn.valueOf("2"), BizDate.valueOf(20160521), BizDate.valueOf(20160919));

        bizDomManager.insert(sjkkkTyouseiyouRiritu8);
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

        List<BM_SjkkkTyouseiyouRiritu> sjkkkTyouseiyouRirituLst = bizDomManager.getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(
            "1000",C_Tuukasyu.BLNK, C_HhknNenKbn.BLNK);

        Assert.assertEquals(0,sjkkkTyouseiyouRirituLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BM_SjkkkTyouseiyouRiritu> sjkkkTyouseiyouRirituLst = bizDomManager.getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(
            "0001", C_Tuukasyu.BLNK, C_HhknNenKbn.BLNK);

        Assert.assertEquals(1,sjkkkTyouseiyouRirituLst.size());

        assertEquals("0001", sjkkkTyouseiyouRirituLst.get(0).getSyouhncd());
        assertEquals(C_Tuukasyu.BLNK, sjkkkTyouseiyouRirituLst.get(0).getTuukasyu());
        assertEquals(C_HhknNenKbn.BLNK, sjkkkTyouseiyouRirituLst.get(0).getHhknnenkbn());
        assertEquals(BizDate.valueOf(20160519), sjkkkTyouseiyouRirituLst.get(0).getKykfromymd());
        assertEquals(BizDate.valueOf(20160920), sjkkkTyouseiyouRirituLst.get(0).getKyktoymd());
    }


    @Test
    @TestOrder(30)
    public void normal2(){

        List<BM_SjkkkTyouseiyouRiritu> sjkkkTyouseiyouRirituLst = bizDomManager.getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(
            "0002", C_Tuukasyu.USD, C_HhknNenKbn.NANAJYUUROKUSAIIJYOU);

        Assert.assertEquals(3,sjkkkTyouseiyouRirituLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("0002",C_Tuukasyu.USD,C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,BizDate.valueOf(20160518),BizDate.valueOf(20160920)), "1");
        map.put($("0002",C_Tuukasyu.USD,C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,BizDate.valueOf(20160519),BizDate.valueOf(20160920)), "1");
        map.put($("0002",C_Tuukasyu.USD,C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,BizDate.valueOf(20160520),BizDate.valueOf(20160920)), "1");

        assertTrue(map.containsKey(($(sjkkkTyouseiyouRirituLst.get(0).getSyouhncd(),sjkkkTyouseiyouRirituLst.get(0).getTuukasyu(),sjkkkTyouseiyouRirituLst.get(0).getHhknnenkbn(),
            sjkkkTyouseiyouRirituLst.get(0).getKykfromymd(),sjkkkTyouseiyouRirituLst.get(0).getKyktoymd()))));

        assertTrue(map.containsKey(($(sjkkkTyouseiyouRirituLst.get(1).getSyouhncd(),sjkkkTyouseiyouRirituLst.get(1).getTuukasyu(),sjkkkTyouseiyouRirituLst.get(1).getHhknnenkbn(),
            sjkkkTyouseiyouRirituLst.get(1).getKykfromymd(),sjkkkTyouseiyouRirituLst.get(1).getKyktoymd()))));

        assertTrue(map.containsKey(($(sjkkkTyouseiyouRirituLst.get(2).getSyouhncd(),sjkkkTyouseiyouRirituLst.get(2).getTuukasyu(),sjkkkTyouseiyouRirituLst.get(2).getHhknnenkbn(),
            sjkkkTyouseiyouRirituLst.get(2).getKykfromymd(),sjkkkTyouseiyouRirituLst.get(2).getKyktoymd()))));

        map.remove(($(sjkkkTyouseiyouRirituLst.get(0).getSyouhncd(),sjkkkTyouseiyouRirituLst.get(0).getTuukasyu(),sjkkkTyouseiyouRirituLst.get(0).getHhknnenkbn(),
            sjkkkTyouseiyouRirituLst.get(0).getKykfromymd(),sjkkkTyouseiyouRirituLst.get(0).getKyktoymd())));

        map.remove(($(sjkkkTyouseiyouRirituLst.get(1).getSyouhncd(),sjkkkTyouseiyouRirituLst.get(1).getTuukasyu(),sjkkkTyouseiyouRirituLst.get(1).getHhknnenkbn(),
            sjkkkTyouseiyouRirituLst.get(1).getKykfromymd(),sjkkkTyouseiyouRirituLst.get(1).getKyktoymd())));

        map.remove(($(sjkkkTyouseiyouRirituLst.get(2).getSyouhncd(),sjkkkTyouseiyouRirituLst.get(2).getTuukasyu(),sjkkkTyouseiyouRirituLst.get(2).getHhknnenkbn(),
            sjkkkTyouseiyouRirituLst.get(2).getKykfromymd(),sjkkkTyouseiyouRirituLst.get(2).getKyktoymd())));

        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_SjkkkTyouseiyouRiritu> sjkkkTyouseiyouRirituLst = bizDomManager.getSjkkkTyouseiyouRiritusBy3PKMaxKyktoymd(
            "", C_Tuukasyu.BLNK, C_HhknNenKbn.BLNK);

        Assert.assertEquals(0,sjkkkTyouseiyouRirituLst.size());
    }
}


