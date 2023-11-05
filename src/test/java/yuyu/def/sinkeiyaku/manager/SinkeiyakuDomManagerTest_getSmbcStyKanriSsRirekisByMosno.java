package yuyu.def.sinkeiyaku.manager;

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

import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSmbcStyKanriSsRirekisByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcStyKanriSsRirekisByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_SmbcStyKanriSsRireki> hT_SmbcStyKanriSsRirekiList = sinkeiyakuDomManager.getSmbcStyKanriSsRirekisByMosno("791112220");
        Assert.assertEquals(0,hT_SmbcStyKanriSsRirekiList.size());

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki1 = new HT_SmbcStyKanriSsRireki("11807111118");
        smbcStyKanriSsRireki1.setMosno("791112220");

        sinkeiyakuDomManager.insert(smbcStyKanriSsRireki1);

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki2 = new HT_SmbcStyKanriSsRireki("11807111129");
        smbcStyKanriSsRireki2.setMosno("791112220");

        sinkeiyakuDomManager.insert(smbcStyKanriSsRireki2);

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki3 = new HT_SmbcStyKanriSsRireki("11807111130");
        smbcStyKanriSsRireki3.setMosno("791112220");

        sinkeiyakuDomManager.insert(smbcStyKanriSsRireki3);

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki4 = new HT_SmbcStyKanriSsRireki("11807111141");
        smbcStyKanriSsRireki4.setMosno("791112238");

        sinkeiyakuDomManager.insert(smbcStyKanriSsRireki4);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanriSsRireki());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_SmbcStyKanriSsRireki> hT_SmbcStyKanriSsRirekiList = sinkeiyakuDomManager.getSmbcStyKanriSsRirekisByMosno("791112246");
        Assert.assertEquals(0,hT_SmbcStyKanriSsRirekiList.size());
    }

    @Test
    @TestOrder(20)
    public void blank() {

        List<HT_SmbcStyKanriSsRireki> hT_SmbcStyKanriSsRirekiList = sinkeiyakuDomManager.getSmbcStyKanriSsRirekisByMosno("");
        Assert.assertEquals(0,hT_SmbcStyKanriSsRirekiList.size());

    }

    @Test
    @TestOrder(30)
    public void normal1() {

        List<HT_SmbcStyKanriSsRireki> hT_SmbcStyKanriSsRirekiList = sinkeiyakuDomManager.getSmbcStyKanriSsRirekisByMosno("791112238");
        Assert.assertEquals(1,hT_SmbcStyKanriSsRirekiList.size());

        Assert.assertEquals("11807111141",hT_SmbcStyKanriSsRirekiList.get(0).getSyono());
    }


    @Test
    @TestOrder(40)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("11807111118"), "1");
        datamap.put($("11807111129"), "1");
        datamap.put($("11807111130"), "1");

        List<HT_SmbcStyKanriSsRireki> hT_SmbcStyKanriSsRirekiList = sinkeiyakuDomManager.getSmbcStyKanriSsRirekisByMosno("791112220");

        for(HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki:hT_SmbcStyKanriSsRirekiList){
            datamap.remove($(
                smbcStyKanriSsRireki.getSyono()));
        }

        Assert.assertEquals(3,hT_SmbcStyKanriSsRirekiList.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}

