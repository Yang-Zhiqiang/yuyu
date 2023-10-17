package yuyu.def.direct.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * DirectDomManagerクラスの、<br />
 * getDsKokyakuKanrisBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokyakuKanrisBySyono {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.
            getDsKokyakuKanrisBySyono("11807111118");

        Assert.assertEquals(0, dsKokyakuKanriLst.size());

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("1000000001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("11807111118");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setSyono("11807111129");

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("1000000003");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku4 = dsKokyakuKanri3.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku4.setSyono("11807111130");

        directDomManager.insert(dsKokyakuKanri3);

        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("1000000005");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku5 = dsKokyakuKanri4.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku5.setSyono("11807111130");

        directDomManager.insert(dsKokyakuKanri4);

        MT_DsKokyakuKanri dsKokyakuKanri5 = new MT_DsKokyakuKanri("1000000004");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku6 = dsKokyakuKanri5.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku6.setSyono("11807111130");

        directDomManager.insert(dsKokyakuKanri5);

        MT_DsKokyakuKanri dsKokyakuKanri6 = new MT_DsKokyakuKanri("1000000006");

        directDomManager.insert(dsKokyakuKanri6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.
            getDsKokyakuKanrisBySyono("11807111141");

        Assert.assertEquals(0, dsKokyakuKanriLst.size());
    }
    @Test
    @TestOrder(20)
    public void normal1() {

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.
            getDsKokyakuKanrisBySyono("11807111118");

        Assert.assertEquals(1, dsKokyakuKanriLst.size());

        Assert.assertEquals("1000000001", dsKokyakuKanriLst.get(0).getDskokno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        Map<String,String> dsKokyakuKanriMap = new HashMap<String,String>();
        dsKokyakuKanriMap.put($("1000000003"),"1");
        dsKokyakuKanriMap.put($("1000000005"),"1");
        dsKokyakuKanriMap.put($("1000000004"),"1");


        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.
            getDsKokyakuKanrisBySyono("11807111130");

        Assert.assertEquals(3, dsKokyakuKanriLst.size());

        assertTrue(dsKokyakuKanriMap.containsKey($(dsKokyakuKanriLst.get(0).getDskokno())));
        dsKokyakuKanriMap.remove($(dsKokyakuKanriLst.get(0).getDskokno()));
        assertTrue(dsKokyakuKanriMap.containsKey($(dsKokyakuKanriLst.get(1).getDskokno())));
        dsKokyakuKanriMap.remove($(dsKokyakuKanriLst.get(1).getDskokno()));
        assertTrue(dsKokyakuKanriMap.containsKey($(dsKokyakuKanriLst.get(2).getDskokno())));
        dsKokyakuKanriMap.remove($(dsKokyakuKanriLst.get(2).getDskokno()));
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.
            getDsKokyakuKanrisBySyono("");

        Assert.assertEquals(0, dsKokyakuKanriLst.size());
    }
}
