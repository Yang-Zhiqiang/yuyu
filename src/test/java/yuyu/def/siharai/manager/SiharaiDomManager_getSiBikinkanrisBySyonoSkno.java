package yuyu.def.siharai.manager;

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

import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 異動明細情報作成<br />
 * 保険金給付金備金管理テーブルエンティティリスト　証券番号かつ請求番号を指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManager_getSiBikinkanrisBySyonoSkno {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SiBikinkanri> siBikinkanriList = siharaiDomManager.getSiBikinkanrisBySyonoSkno("11807111118", "1000001");

        Assert.assertEquals(0, siBikinkanriList.size());

        JT_SiBikinkanri siBikinkanri1 = new JT_SiBikinkanri("1000001", "11807111118", BizDate.valueOf(20160101), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), "1000");
        siBikinkanri1.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri1.setBknjkukbn(C_BknJkuKbn.SINBI);

        siharaiDomManager.insert(siBikinkanri1);

        JT_SiBikinkanri siBikinkanri2 = new JT_SiBikinkanri("1000001", "11807111129", BizDate.valueOf(20160101), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), "1000");
        siBikinkanri2.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri2.setBknjkukbn(C_BknJkuKbn.SINBI);

        siharaiDomManager.insert(siBikinkanri2);

        JT_SiBikinkanri siBikinkanri3 = new JT_SiBikinkanri("1000002", "11807111118", BizDate.valueOf(20160101), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), "1000");
        siBikinkanri3.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri3.setBknjkukbn(C_BknJkuKbn.SINBI);

        siharaiDomManager.insert(siBikinkanri3);

        JT_SiBikinkanri siBikinkanri4 = new JT_SiBikinkanri("1000001", "11807111118", BizDate.valueOf(20160101), C_BkncdKbn.BLNK, BizDate.valueOf(20161222), "1000");
        siBikinkanri4.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri4.setBknjkukbn(C_BknJkuKbn.SAIBI);

        siharaiDomManager.insert(siBikinkanri4);

        JT_SiBikinkanri siBikinkanri5 = new JT_SiBikinkanri("1000001", "11807111118", BizDate.valueOf(20160101), C_BkncdKbn.BLNK, BizDate.valueOf(20161223), "1000");
        siBikinkanri5.setBknrigikbn(C_BknrigiKbn.DEL);
        siBikinkanri5.setBknjkukbn(C_BknJkuKbn.SINBI);

        siharaiDomManager.insert(siBikinkanri5);

        JT_SiBikinkanri siBikinkanri6 = new JT_SiBikinkanri("1000003", "11807111141", BizDate.valueOf(20160103), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), "1003");
        siBikinkanri6.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri6.setBknjkukbn(C_BknJkuKbn.SINBI);

        siharaiDomManager.insert(siBikinkanri6);

        JT_SiBikinkanri siBikinkanri7 = new JT_SiBikinkanri("1000003", "11807111141", BizDate.valueOf(20160104), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), "1003");
        siBikinkanri7.setBknrigikbn(C_BknrigiKbn.ADD);
        siBikinkanri7.setBknjkukbn(C_BknJkuKbn.SINBI);

        siharaiDomManager.insert(siBikinkanri7);

        JT_SiBikinkanri siBikinkanri8 = new JT_SiBikinkanri("1000003", "11807111141", BizDate.valueOf(20160105), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), "1003");
        siBikinkanri8.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri8.setBknjkukbn(C_BknJkuKbn.SINBI);

        siharaiDomManager.insert(siBikinkanri8);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<JT_SiBikinkanri> siBikinkanriList = siharaiDomManager.getSiBikinkanrisBySyonoSkno("11807111406", "1000001");

        Assert.assertEquals(0, siBikinkanriList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JT_SiBikinkanri> siBikinkanriList = siharaiDomManager.getSiBikinkanrisBySyonoSkno("11807111118", "1000001");

        Assert.assertEquals(1, siBikinkanriList.size());
        Assert.assertEquals("1000001", siBikinkanriList.get(0).getSkno());
        Assert.assertEquals("11807111118", siBikinkanriList.get(0).getSyono());
        Assert.assertEquals(BizDate.valueOf(20160101), siBikinkanriList.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BkncdKbn.BLNK, siBikinkanriList.get(0).getBkncdkbn());
        Assert.assertEquals(BizDate.valueOf(20161220), siBikinkanriList.get(0).getBknkktymd());
        Assert.assertEquals("1000", siBikinkanriList.get(0).getKyuuhucd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> siBikinkanriMap = new HashMap<String, String>();
        siBikinkanriMap.put($("1000003", "11807111141", BizDate.valueOf(20160103), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), "1003"),"1");
        siBikinkanriMap.put($("1000003", "11807111141", BizDate.valueOf(20160104), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), "1003"),"1");
        siBikinkanriMap.put($("1000003", "11807111141", BizDate.valueOf(20160105), C_BkncdKbn.BLNK, BizDate.valueOf(20161220), "1003"),"1");

        List<JT_SiBikinkanri> siBikinkanriList = siharaiDomManager.getSiBikinkanrisBySyonoSkno("11807111141", "1000003");

        assertEquals(3, siBikinkanriList.size());

        siBikinkanriMap.remove($(siBikinkanriList.get(0).getSkno(), siBikinkanriList.get(0).getSyono(), siBikinkanriList.get(0).getKessankijyunymd(),
            siBikinkanriList.get(0).getBkncdkbn(), siBikinkanriList.get(0).getBknkktymd(), siBikinkanriList.get(0).getKyuuhucd()));
        siBikinkanriMap.remove($(siBikinkanriList.get(1).getSkno(), siBikinkanriList.get(1).getSyono(), siBikinkanriList.get(1).getKessankijyunymd(),
            siBikinkanriList.get(1).getBkncdkbn(), siBikinkanriList.get(1).getBknkktymd(), siBikinkanriList.get(1).getKyuuhucd()));
        siBikinkanriMap.remove($(siBikinkanriList.get(2).getSkno(), siBikinkanriList.get(2).getSyono(), siBikinkanriList.get(2).getKessankijyunymd(),
            siBikinkanriList.get(2).getBkncdkbn(), siBikinkanriList.get(2).getBknkktymd(), siBikinkanriList.get(2).getKyuuhucd()));

        assertTrue(siBikinkanriMap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<JT_SiBikinkanri> siBikinkanriList = siharaiDomManager.getSiBikinkanrisBySyonoSkno("", "1000003");

        assertEquals(0, siBikinkanriList.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<JT_SiBikinkanri> siBikinkanriList = siharaiDomManager.getSiBikinkanrisBySyonoSkno("11807111141", "");

        assertEquals(0, siBikinkanriList.size());
    }

}
