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

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BM_Syonokanri;

/**
 * BizDomManagerクラスの、<br />
 * getSyonokanrisBySyono() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getSyonokanrisBySyono {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Syonokanri> syonokanriLst = bizDomManager.getSyonokanrisBySyono("10000000002");

        Assert.assertEquals(0,syonokanriLst.size());

        syonokanriLst =  bizDomManager.getAllSyonokanri();

        if (syonokanriLst.size() == 0) {
            BM_Syonokanri syonokanri = new BM_Syonokanri();
            syonokanri.setSyonorenno(1);
            syonokanri.setSeirekinen2keta("12");
            syonokanri.setBosyuusosikicd("801");
            syonokanri.setSyono("10000000002");
            bizDomManager.insert(syonokanri);


            BM_Syonokanri syonokanri3 = new BM_Syonokanri();
            syonokanri3.setSyonorenno(2);
            syonokanri3.setSeirekinen2keta("11");
            syonokanri3.setBosyuusosikicd("801");
            syonokanri3.setSyono("10000000002");

            bizDomManager.insert(syonokanri3);

            BM_Syonokanri syonokanri4 = new BM_Syonokanri();
            syonokanri4.setSyonorenno(3);
            syonokanri4.setSeirekinen2keta("11");
            syonokanri4.setBosyuusosikicd("801");
            syonokanri4.setSyono("10000000002");

            bizDomManager.insert(syonokanri4);

            BM_Syonokanri syonokanri2 = new BM_Syonokanri();
            syonokanri2.setSyonorenno(1);
            syonokanri2.setSeirekinen2keta("11");
            syonokanri2.setBosyuusosikicd("801");
            syonokanri2.setSyono("10000000001");

            bizDomManager.insert(syonokanri2);
        }



    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyonokanri());
    }

    @Test
    @Transactional
    public void noResult1(){

        List<BM_Syonokanri> syonokanriLst = bizDomManager.getSyonokanrisBySyono("10000000003");

        assertEquals(0, syonokanriLst.size());

        List<BM_Syonokanri> syonokanriLst2 = bizDomManager.getSyonokanrisBySyono("");

        assertEquals(0, syonokanriLst2.size());

    }

    @Test
    public void normal1(){

        List<BM_Syonokanri> syonokanriLst = bizDomManager.getSyonokanrisBySyono("10000000001");

        assertEquals(1, syonokanriLst.size());
        assertEquals("10000000001", syonokanriLst.get(0).getSyono());
        assertEquals("11",syonokanriLst.get(0).getSeirekinen2keta());
        assertEquals("801",syonokanriLst.get(0).getBosyuusosikicd());
        assertEquals("1", syonokanriLst.get(0).getSyonorenno().toString());
    }
    @Test
    public void normal2(){

        List<BM_Syonokanri> syonokanriLst = bizDomManager.getSyonokanrisBySyono("10000000002");

        assertEquals(3, syonokanriLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("10000000002","12","801","1"), "1");
        map.put($("10000000002","11","801","2"), "1");
        map.put($("10000000002","11","801","3"), "1");

        assertTrue(map.containsKey($(syonokanriLst.get(0).getSyono(),syonokanriLst.get(0).getSeirekinen2keta(),
            syonokanriLst.get(0).getBosyuusosikicd(),syonokanriLst.get(0).getSyonorenno().toString())));
        assertTrue(map.containsKey($(syonokanriLst.get(1).getSyono(),syonokanriLst.get(1).getSeirekinen2keta(),
            syonokanriLst.get(1).getBosyuusosikicd(),syonokanriLst.get(1).getSyonorenno().toString())));
        assertTrue(map.containsKey($(syonokanriLst.get(2).getSyono(),syonokanriLst.get(2).getSeirekinen2keta(),
            syonokanriLst.get(2).getBosyuusosikicd(),syonokanriLst.get(2).getSyonorenno().toString())));

        map.remove($(syonokanriLst.get(0).getSyono(),syonokanriLst.get(0).getSeirekinen2keta(),
            syonokanriLst.get(0).getBosyuusosikicd(),syonokanriLst.get(0).getSyonorenno().toString()));
        map.remove($(syonokanriLst.get(1).getSyono(),syonokanriLst.get(1).getSeirekinen2keta(),
            syonokanriLst.get(1).getBosyuusosikicd(),syonokanriLst.get(1).getSyonorenno().toString()));
        map.remove($(syonokanriLst.get(2).getSyono(),syonokanriLst.get(2).getSeirekinen2keta(),
            syonokanriLst.get(2).getBosyuusosikicd(),syonokanriLst.get(2).getSyonorenno().toString()));

        assertTrue(map.isEmpty());
    }
}
