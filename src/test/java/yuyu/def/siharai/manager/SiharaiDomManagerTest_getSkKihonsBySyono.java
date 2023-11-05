package yuyu.def.siharai.manager;

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

import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 請求基本テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsBySyono {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon("SKNO0001", "11807111118");

        if (skKihon == null) {

            List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyono("11807111118");
            Assert.assertEquals(0, skKihonLst.size());
        }

        skKihon = new JT_SkKihon("SKNO0001", "11807111118");

        siharaiDomManager.insert(skKihon);

        JT_SkKihon skKihon2 = new JT_SkKihon("SKNO0001", "11807111130");

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("SKNO0002", "11807111129");

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("SKNO0003", "11807111129");

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("SKNO0004", "11807111129");

        siharaiDomManager.insert(skKihon5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }


    @Test
    @TestOrder(10)
    public void noResult1() {
        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyono("11807111163");
        Assert.assertEquals(0, skKihonLst.size());
    }

    @Test
    @TestOrder(20)
    public void blankCondition1() {
        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyono("");
        Assert.assertEquals(0, skKihonLst.size());
    }

    @Test
    @TestOrder(30)
    public void normal1() {
        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyono("11807111118");
        Assert.assertEquals(1, skKihonLst.size());

        Assert.assertEquals("SKNO0001", skKihonLst.get(0).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(0).getSyono());

    }

    @Test
    @TestOrder(40)
    public void normal2() {
        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("SKNO0002","11807111129"), "1");
        datamap.put($("SKNO0003","11807111129"), "2");
        datamap.put($("SKNO0004","11807111129"), "2");

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyono("11807111129");

        for(JT_SkKihon skKihon:skKihonLst){
            datamap.remove($(
                skKihon.getSkno(),
                skKihon.getSyono()));
        }

        Assert.assertEquals(3, skKihonLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

}
