package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getYoteiRiritusByPK() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getYoteiRiritusByPK {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        List<BM_YoteiRiritu> BM_YoteiRirituLst = bizDomManager.getYoteiRiritusByPK("0001",C_Tuukasyu.BLNK,
            C_HhknNenKbn.BLNK,BizDate.valueOf(20160520), BizDate.valueOf(20160918));

        Assert.assertEquals(0,BM_YoteiRirituLst.size());

        BM_YoteiRiritu yoteiRiritu1 = new BM_YoteiRiritu("0001", C_Tuukasyu.valueOf("0"), C_HhknNenKbn.valueOf("0"),
            BizDate.valueOf(20160519), BizDate.valueOf(20160919));

        bizDomManager.insert(yoteiRiritu1);

        BM_YoteiRiritu yoteiRiritu2 = new BM_YoteiRiritu("0011", C_Tuukasyu.valueOf("0"), C_HhknNenKbn.valueOf("0"),
            BizDate.valueOf(20160519), BizDate.valueOf(20160919));

        bizDomManager.insert(yoteiRiritu2);

        BM_YoteiRiritu yoteiRiritu3 = new BM_YoteiRiritu("0001", C_Tuukasyu.valueOf("JPY"), C_HhknNenKbn.valueOf("0"),
            BizDate.valueOf(20160519), BizDate.valueOf(20160919));

        bizDomManager.insert(yoteiRiritu3);

        BM_YoteiRiritu yoteiRiritu4 = new BM_YoteiRiritu("0001", C_Tuukasyu.valueOf("0"), C_HhknNenKbn.valueOf("1"),
            BizDate.valueOf(20160519), BizDate.valueOf(20160919));

        bizDomManager.insert(yoteiRiritu4);

        BM_YoteiRiritu yoteiRiritu5 = new BM_YoteiRiritu("0001", C_Tuukasyu.valueOf("0"), C_HhknNenKbn.valueOf("0"),
            BizDate.valueOf(20160521), BizDate.valueOf(20160919));

        bizDomManager.insert(yoteiRiritu5);

        BM_YoteiRiritu yoteiRiritu6 = new BM_YoteiRiritu("0001", C_Tuukasyu.valueOf("0"), C_HhknNenKbn.valueOf("0"),
            BizDate.valueOf(20160519), BizDate.valueOf(20160917));

        bizDomManager.insert(yoteiRiritu6);

        BM_YoteiRiritu yoteiRiritu7 = new BM_YoteiRiritu("0002", C_Tuukasyu.valueOf("USD"), C_HhknNenKbn.valueOf("2"),
            BizDate.valueOf(20160519), BizDate.valueOf(20160919));

        bizDomManager.insert(yoteiRiritu7);

        BM_YoteiRiritu yoteiRiritu8 = new BM_YoteiRiritu("0002", C_Tuukasyu.valueOf("USD"), C_HhknNenKbn.valueOf("2"),
            BizDate.valueOf(20160520), BizDate.valueOf(20160918));

        bizDomManager.insert(yoteiRiritu8);

        BM_YoteiRiritu yoteiRiritu9 = new BM_YoteiRiritu("0002", C_Tuukasyu.valueOf("USD"), C_HhknNenKbn.valueOf("2"),
            BizDate.valueOf(20160520), BizDate.valueOf(20160919));

        bizDomManager.insert(yoteiRiritu9);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BM_YoteiRiritu> BM_YoteiRirituLst = bizDomManager.getYoteiRiritusByPK("1111",C_Tuukasyu.BLNK,
            C_HhknNenKbn.BLNK,BizDate.valueOf(20160520), BizDate.valueOf(20160918));

        Assert.assertEquals(0,BM_YoteiRirituLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BM_YoteiRiritu> BM_YoteiRirituLst = bizDomManager.getYoteiRiritusByPK("0001",C_Tuukasyu.BLNK,
            C_HhknNenKbn.BLNK,BizDate.valueOf(20160520), BizDate.valueOf(20160918));

        Assert.assertEquals(1,BM_YoteiRirituLst.size());

        assertEquals("0001", BM_YoteiRirituLst.get(0).getSyouhncd());
        assertEquals(C_Tuukasyu.BLNK, BM_YoteiRirituLst.get(0).getTuukasyu());
        assertEquals(C_HhknNenKbn.BLNK, BM_YoteiRirituLst.get(0).getHhknnenkbn());
        assertEquals(BizDate.valueOf(20160519), BM_YoteiRirituLst.get(0).getKykfromymd());
        assertEquals(BizDate.valueOf(20160919), BM_YoteiRirituLst.get(0).getKyktoymd());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BM_YoteiRiritu> BM_YoteiRirituLst = bizDomManager.getYoteiRiritusByPK("0002",C_Tuukasyu.USD,
            C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,BizDate.valueOf(20160520), BizDate.valueOf(20160918));

        Assert.assertEquals(3,BM_YoteiRirituLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("0002",C_Tuukasyu.USD,C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,BizDate.valueOf(20160519),BizDate.valueOf(20160919)), "1");
        map.put($("0002",C_Tuukasyu.USD,C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,BizDate.valueOf(20160520),BizDate.valueOf(20160918)), "1");
        map.put($("0002",C_Tuukasyu.USD,C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,BizDate.valueOf(20160520),BizDate.valueOf(20160919)), "1");
        for(BM_YoteiRiritu yoteiRiritu : BM_YoteiRirituLst){
            map.remove($(yoteiRiritu.getSyouhncd(),yoteiRiritu.getTuukasyu(),yoteiRiritu.getHhknnenkbn(),yoteiRiritu.getKykfromymd(),yoteiRiritu.getKyktoymd()));
        }
        assertTrue(map.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_YoteiRiritu> BM_YoteiRirituLst = bizDomManager.getYoteiRiritusByPK("", C_Tuukasyu.USD,
            C_HhknNenKbn.NANAJYUUROKUSAIIJYOU,BizDate.valueOf(20160520), BizDate.valueOf(20160918));

        Assert.assertEquals(0,BM_YoteiRirituLst.size());
    }
}


