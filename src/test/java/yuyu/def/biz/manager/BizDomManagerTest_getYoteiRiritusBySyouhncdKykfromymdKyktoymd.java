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
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.testinfr.OrderedRunner;

/**
 * BizDomManagerクラスの、<br />
 * getYoteiRiritusBySyouhncdKykfromymdKyktoymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getYoteiRiritusBySyouhncdKykfromymdKyktoymd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdKykfromymdKyktoymd("M101", BizDate.valueOf("20160215"));

        Assert.assertEquals(0,yoteiRirituLst.size());

        BM_YoteiRiritu yoteiRiritu1 = new BM_YoteiRiritu("M101", C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160215), BizDate.valueOf(20160216));

        bizDomManager.insert(yoteiRiritu1);

        BM_YoteiRiritu yoteiRiritu2 = new BM_YoteiRiritu("M102", C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160215), BizDate.valueOf(20160216));

        bizDomManager.insert(yoteiRiritu2);

        BM_YoteiRiritu yoteiRiritu3 = new BM_YoteiRiritu("M101", C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160216), BizDate.valueOf(20160217));

        bizDomManager.insert(yoteiRiritu3);

        BM_YoteiRiritu yoteiRiritu4 = new BM_YoteiRiritu("M101", C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160213), BizDate.valueOf(20160214));

        bizDomManager.insert(yoteiRiritu4);

        BM_YoteiRiritu yoteiRiritu5 = new BM_YoteiRiritu("M103", C_Tuukasyu.valueOf("USD"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160315), BizDate.valueOf(20160316));

        bizDomManager.insert(yoteiRiritu5);

        BM_YoteiRiritu yoteiRiritu6 = new BM_YoteiRiritu("M103", C_Tuukasyu.valueOf("USD"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160314), BizDate.valueOf(20160315));

        bizDomManager.insert(yoteiRiritu6);

        BM_YoteiRiritu yoteiRiritu7 = new BM_YoteiRiritu("M103", C_Tuukasyu.valueOf("USD"), C_HhknNenKbn.BLNK, BizDate.valueOf(20160314), BizDate.valueOf(20160316));

        bizDomManager.insert(yoteiRiritu7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());
    }

    @Test
    @Transactional
    public void noResult1(){

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdKykfromymdKyktoymd("M102", BizDate.valueOf("20160214"));

        assertEquals(0, yoteiRirituLst.size());

        List<BM_YoteiRiritu> yoteiRirituLst2 = bizDomManager.getYoteiRiritusBySyouhncdKykfromymdKyktoymd("", BizDate.valueOf("20160215"));

        assertEquals(0, yoteiRirituLst2.size());

    }

    @Test
    public void normal1(){

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdKykfromymdKyktoymd("M101", BizDate.valueOf("20160215"));

        assertEquals(1, yoteiRirituLst.size());
        assertEquals("M101", yoteiRirituLst.get(0).getSyouhncd());
        assertEquals(C_Tuukasyu.JPY, yoteiRirituLst.get(0).getTuukasyu());
        assertEquals(BizDate.valueOf("20160215"), yoteiRirituLst.get(0).getKykfromymd());
        assertEquals(BizDate.valueOf("20160216"), yoteiRirituLst.get(0).getKyktoymd());
    }
    @Test
    public void normal2(){

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdKykfromymdKyktoymd("M103", BizDate.valueOf("20160315"));

        assertEquals(3, yoteiRirituLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("M103",C_Tuukasyu.USD,BizDate.valueOf("20160314"),BizDate.valueOf("20160315")), "1");
        map.put($("M103",C_Tuukasyu.USD,BizDate.valueOf("20160314"),BizDate.valueOf("20160316")), "1");
        map.put($("M103",C_Tuukasyu.USD,BizDate.valueOf("20160315"),BizDate.valueOf("20160316")), "1");

        for(BM_YoteiRiritu yoteiRiritu : yoteiRirituLst){
            map.remove($(yoteiRiritu.getSyouhncd(),yoteiRiritu.getTuukasyu(),yoteiRiritu.getKykfromymd(),yoteiRiritu.getKyktoymd()));
        }
        assertTrue(map.isEmpty());
    }
}
