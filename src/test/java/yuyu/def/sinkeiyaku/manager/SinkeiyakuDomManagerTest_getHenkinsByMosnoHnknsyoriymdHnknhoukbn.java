package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.db.entity.HT_Henkin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getHenkinsByMosnoHnknsyoriymdHnknhoukbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getHenkinsByMosnoHnknsyoriymdHnknhoukbn {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_Henkin> hT_Henkin = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymdHnknhoukbn("791112220",BizDate.valueOf(20160504));
        Assert.assertEquals(0,hT_Henkin.size());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");

        HT_Henkin henkin1 = syoriCTL1.createHenkin();
        henkin1.setRenno(0);
        henkin1.setHnknsyoriymd(BizDate.valueOf(20160504));
        henkin1.setHnknhoukbn(C_HnknhouKbn.BLNK);

        HT_Henkin henkin6 = syoriCTL1.createHenkin();
        henkin6.setRenno(5);
        henkin6.setHnknsyoriymd(BizDate.valueOf(20160506));
        henkin6.setHnknhoukbn(C_HnknhouKbn.BLNK);

        HT_Henkin henkin7 = syoriCTL1.createHenkin();
        henkin7.setRenno(6);
        henkin7.setHnknsyoriymd(BizDate.valueOf(20160504));
        henkin7.setHnknhoukbn(C_HnknhouKbn.KARIUKE);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");

        HT_Henkin henkin2 = syoriCTL2.createHenkin();
        henkin2.setRenno(1);
        henkin2.setHnknsyoriymd(BizDate.valueOf(20160505));
        henkin2.setHnknhoukbn(C_HnknhouKbn.TOUKYK_KOUZA);

        HT_Henkin henkin3 = syoriCTL2.createHenkin();
        henkin3.setRenno(2);
        henkin3.setHnknsyoriymd(BizDate.valueOf(20160505));
        henkin3.setHnknhoukbn(C_HnknhouKbn.TOUKYK_KOUZA);

        HT_Henkin henkin4 = syoriCTL2.createHenkin();
        henkin4.setRenno(3);
        henkin4.setHnknsyoriymd(BizDate.valueOf(20160505));
        henkin4.setHnknhoukbn(C_HnknhouKbn.TOUKYK_KOUZA);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");

        HT_Henkin henkin5 = syoriCTL3.createHenkin();
        henkin5.setRenno(4);
        henkin5.setHnknsyoriymd(BizDate.valueOf(20160504));
        henkin5.setHnknhoukbn(C_HnknhouKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_Henkin> hT_Henkin = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymdHnknhoukbn("791112219",BizDate.valueOf(20160504));
        Assert.assertEquals(0,hT_Henkin.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_Henkin> hT_Henkin = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymdHnknhoukbn("791112220",BizDate.valueOf(20160504));
        Assert.assertEquals(1,hT_Henkin.size());

        Assert.assertEquals("791112220", hT_Henkin.get(0).getMosno());
        Assert.assertEquals(Integer.valueOf(0), hT_Henkin.get(0).getRenno());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112238",Integer.valueOf(1)), "1");
        datamap.put($("791112238",Integer.valueOf(2)), "1");
        datamap.put($("791112238",Integer.valueOf(3)), "1");

        List<HT_Henkin>  hT_Henkin = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymdHnknhoukbn("791112238",BizDate.valueOf(20160505));

        for(HT_Henkin henkin:hT_Henkin){
            datamap.remove($(
                henkin.getMosno(),
                henkin.getRenno()));
        }

        Assert.assertEquals(3, hT_Henkin.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank() {

        List<HT_Henkin> skLincJyusinInfo = sinkeiyakuDomManager.getHenkinsByMosnoHnknsyoriymdHnknhoukbn("",BizDate.valueOf(20160504));
        Assert.assertEquals(0,skLincJyusinInfo.size());
    }
}
