package yuyu.def.direct.manager;

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

import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * DirectDomManagerクラスの、<br />
 * getDsKokyakuKeiyakusBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokyakuKeiyakusBySyono {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestData();

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = directDomManager.getDsKokyakuKeiyakusBySyono("11807111200");

        Assert.assertEquals(0, dsKokyakuKeiyakuLst.size());

        insertSubData();

    }

    @Transactional
    public static void insertSubData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("11807111200");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setSyono("11807111211");

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("100010");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku3 = dsKokyakuKanri2.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku3.setSyono("11807111222");

        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("100011");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku4 = dsKokyakuKanri3.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku4.setSyono("11807111222");

        directDomManager.insert(dsKokyakuKanri3);

        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("100012");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku5 = dsKokyakuKanri4.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku5.setSyono("11807111222");

        directDomManager.insert(dsKokyakuKanri4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = directDomManager.getDsKokyakuKeiyakusBySyono("11807111233");

        Assert.assertEquals(0, dsKokyakuKeiyakuLst.size());
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = directDomManager.getDsKokyakuKeiyakusBySyono("11807111200");

        Assert.assertEquals(1, dsKokyakuKeiyakuLst.size());

        Assert.assertEquals("100001", dsKokyakuKeiyakuLst.get(0).getDskokno());
        Assert.assertEquals("11807111200", dsKokyakuKeiyakuLst.get(0).getSyono());
    }
    @Test
    @TestOrder(30)
    @Transactional
    public void normal3() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("100010","11807111222"), "1");
        datamap.put($("100011","11807111222"), "2");
        datamap.put($("100012","11807111222"), "3");

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = directDomManager.getDsKokyakuKeiyakusBySyono("11807111222");

        for(MT_DsKokyakuKeiyaku dsKokyakuKeiyaku:dsKokyakuKeiyakuLst){
            datamap.remove($(dsKokyakuKeiyaku.getDskokno(),dsKokyakuKeiyaku.getSyono()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }
    @Test
    @TestOrder(40)
    @Transactional
    public void blank1() {

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = directDomManager.getDsKokyakuKeiyakusBySyono("");

        Assert.assertEquals(0, dsKokyakuKeiyakuLst.size());

    }
}
