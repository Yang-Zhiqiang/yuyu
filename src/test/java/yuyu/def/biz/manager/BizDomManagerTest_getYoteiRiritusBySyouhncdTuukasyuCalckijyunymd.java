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
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu;

/**
 * BizDomManagerクラスの、<br />
 * getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd("1001", C_Tuukasyu.AUD, BizDate.valueOf("20160215"));

        Assert.assertEquals(0,yoteiRirituLst.size());

        BM_YoteiRiritu yoteiRiritu = new BM_YoteiRiritu();
        yoteiRiritu.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu.setSyouhncd("1001");
        yoteiRiritu.setTuukasyu(C_Tuukasyu.AUD);
        yoteiRiritu.setKykfromymd(BizDate.valueOf("20160202"));
        yoteiRiritu.setKyktoymd(BizDate.valueOf("20160228"));
        yoteiRiritu.setYoteiriritu(BizNumber.valueOf(1.0002));
        bizDomManager.insert(yoteiRiritu);


        BM_YoteiRiritu yoteiRiritu2 = new BM_YoteiRiritu();
        yoteiRiritu2.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu2.setSyouhncd("1002");
        yoteiRiritu2.setTuukasyu(C_Tuukasyu.AUD);
        yoteiRiritu2.setKykfromymd(BizDate.valueOf("20160202"));
        yoteiRiritu2.setKyktoymd(BizDate.valueOf("20160228"));
        yoteiRiritu2.setYoteiriritu(BizNumber.valueOf(1.0002));
        bizDomManager.insert(yoteiRiritu2);

        BM_YoteiRiritu yoteiRiritu3 = new BM_YoteiRiritu();
        yoteiRiritu3.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu3.setSyouhncd("1001");
        yoteiRiritu3.setTuukasyu(C_Tuukasyu.EUR);
        yoteiRiritu3.setKykfromymd(BizDate.valueOf("20160202"));
        yoteiRiritu3.setKyktoymd(BizDate.valueOf("20160228"));
        yoteiRiritu3.setYoteiriritu(BizNumber.valueOf(1.0002));
        bizDomManager.insert(yoteiRiritu3);

        BM_YoteiRiritu yoteiRiritu4 = new BM_YoteiRiritu();
        yoteiRiritu4.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu4.setSyouhncd("1001");
        yoteiRiritu4.setTuukasyu(C_Tuukasyu.AUD);
        yoteiRiritu4.setKykfromymd(BizDate.valueOf("20160216"));
        yoteiRiritu4.setKyktoymd(BizDate.valueOf("20160228"));
        yoteiRiritu4.setYoteiriritu(BizNumber.valueOf(1.0002));
        bizDomManager.insert(yoteiRiritu4);

        BM_YoteiRiritu yoteiRiritu5 = new BM_YoteiRiritu();
        yoteiRiritu5.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu5.setSyouhncd("1001");
        yoteiRiritu5.setTuukasyu(C_Tuukasyu.AUD);
        yoteiRiritu5.setKykfromymd(BizDate.valueOf("20160202"));
        yoteiRiritu5.setKyktoymd(BizDate.valueOf("20160214"));
        yoteiRiritu5.setYoteiriritu(BizNumber.valueOf(1.0002));
        bizDomManager.insert(yoteiRiritu);

        BM_YoteiRiritu yoteiRiritu6 = new BM_YoteiRiritu();
        yoteiRiritu6.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu6.setSyouhncd("1003");
        yoteiRiritu6.setTuukasyu(C_Tuukasyu.JPY);
        yoteiRiritu6.setKykfromymd(BizDate.valueOf("20160215"));
        yoteiRiritu6.setKyktoymd(BizDate.valueOf("20160227"));
        yoteiRiritu6.setYoteiriritu(BizNumber.valueOf(0.0012));
        bizDomManager.insert(yoteiRiritu6);

        BM_YoteiRiritu yoteiRiritu7 = new BM_YoteiRiritu();
        yoteiRiritu7.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu7.setSyouhncd("1003");
        yoteiRiritu7.setTuukasyu(C_Tuukasyu.JPY);
        yoteiRiritu7.setKykfromymd(BizDate.valueOf("20160204"));
        yoteiRiritu7.setKyktoymd(BizDate.valueOf("20160215"));
        yoteiRiritu7.setYoteiriritu(BizNumber.valueOf(1.1001));
        bizDomManager.insert(yoteiRiritu7);

        BM_YoteiRiritu yoteiRiritu8 = new BM_YoteiRiritu();
        yoteiRiritu8.setHhknnenkbn(C_HhknNenKbn.BLNK);
        yoteiRiritu8.setSyouhncd("1003");
        yoteiRiritu8.setTuukasyu(C_Tuukasyu.JPY);
        yoteiRiritu8.setKykfromymd(BizDate.valueOf("20160205"));
        yoteiRiritu8.setKyktoymd(BizDate.valueOf("20160225"));
        yoteiRiritu8.setYoteiriritu(BizNumber.valueOf(1.0546));
        bizDomManager.insert(yoteiRiritu8);
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

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd("1002", C_Tuukasyu.EUR, BizDate.valueOf("20160228"));

        assertEquals(0, yoteiRirituLst.size());

        List<BM_YoteiRiritu> yoteiRirituLst2 = bizDomManager.getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd("", C_Tuukasyu.AUD, BizDate.valueOf("20160215"));

        assertEquals(0, yoteiRirituLst2.size());

    }

    @Test
    public void normal1(){

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd("1001", C_Tuukasyu.AUD, BizDate.valueOf("20160215"));

        assertEquals(1, yoteiRirituLst.size());
        assertEquals("1001", yoteiRirituLst.get(0).getSyouhncd());
        assertEquals(C_Tuukasyu.AUD, yoteiRirituLst.get(0).getTuukasyu());
        assertEquals(BizDate.valueOf("20160202"), yoteiRirituLst.get(0).getKykfromymd());
        assertEquals(BizDate.valueOf("20160228"), yoteiRirituLst.get(0).getKyktoymd());
        assertEquals(BizNumber.valueOf(1.0002), yoteiRirituLst.get(0).getYoteiriritu());
    }
    @Test
    public void normal2(){

        List<BM_YoteiRiritu> yoteiRirituLst = bizDomManager.getYoteiRiritusBySyouhncdTuukasyuCalckijyunymd("1003", C_Tuukasyu.JPY, BizDate.valueOf("20160215"));

        assertEquals(3, yoteiRirituLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("1003",C_Tuukasyu.JPY,BizDate.valueOf("20160204"),BizDate.valueOf("20160215"),BizNumber.valueOf(1.1001)), "1");
        map.put($("1003",C_Tuukasyu.JPY,BizDate.valueOf("20160205"),BizDate.valueOf("20160225"),BizNumber.valueOf(1.0546)), "1");
        map.put($("1003",C_Tuukasyu.JPY,BizDate.valueOf("20160215"),BizDate.valueOf("20160227"),BizNumber.valueOf(0.0012)), "1");

        for(BM_YoteiRiritu yoteiRiritu : yoteiRirituLst){
            map.remove($(yoteiRiritu.getSyouhncd(),yoteiRiritu.getTuukasyu(),yoteiRiritu.getKykfromymd(),yoteiRiritu.getKyktoymd(),yoteiRiritu.getYoteiriritu()));
        }
        assertTrue(map.isEmpty());
    }
}
