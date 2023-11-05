package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.db.entity.HT_YuukoukknKykList;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getYuukoukknKykListsByMosno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getYuukoukknKykListsByMosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_YuukoukknKykList> yuukoukknKykLLst = sinkeiyakuDomManager
            .getYuukoukknKykListsByMosno("791112220");

        Assert.assertEquals(0, yuukoukknKykLLst.size());

        HT_YuukoukknKykList yuukoukknKykList1 = new HT_YuukoukknKykList("791112220", BizDate.valueOf(20140504));

        sinkeiyakuDomManager.insert(yuukoukknKykList1);

        HT_YuukoukknKykList yuukoukknKykList2 = new HT_YuukoukknKykList("791112246", BizDate.valueOf(20140504));

        sinkeiyakuDomManager.insert(yuukoukknKykList2);

        HT_YuukoukknKykList yuukoukknKykList3 = new HT_YuukoukknKykList("791112238", BizDate.valueOf(20140505));

        sinkeiyakuDomManager.insert(yuukoukknKykList3);

        HT_YuukoukknKykList yuukoukknKykList4 = new HT_YuukoukknKykList("791112238", BizDate.valueOf(20140506));

        sinkeiyakuDomManager.insert(yuukoukknKykList4);

        HT_YuukoukknKykList yuukoukknKykList5 = new HT_YuukoukknKykList("791112238", BizDate.valueOf(20140507));

        sinkeiyakuDomManager.insert(yuukoukknKykList5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllYuukoukknKykList());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_YuukoukknKykList> yuukoukknKykLLst = sinkeiyakuDomManager.getYuukoukknKykListsByMosno(
            "791112279");

        assertEquals(0, yuukoukknKykLLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_YuukoukknKykList> yuukoukknKykLLst = sinkeiyakuDomManager.getYuukoukknKykListsByMosno(
            "791112220");

        assertEquals(1, yuukoukknKykLLst.size());

        assertEquals("791112220", yuukoukknKykLLst.get(0).getMosno());
        assertEquals(BizDate.valueOf(20140504), yuukoukknKykLLst.get(0).getTyouhyouymd());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112238",BizDate.valueOf(20140505)), "1");
        datamap.put($("791112238",BizDate.valueOf(20140506)), "1");
        datamap.put($("791112238",BizDate.valueOf(20140507)), "1");

        List<HT_YuukoukknKykList> yuukoukknKykLLst = sinkeiyakuDomManager.getYuukoukknKykListsByMosno(
            "791112238");

        for(HT_YuukoukknKykList yuukoukknKykList:yuukoukknKykLLst){
            datamap.remove($(
                yuukoukknKykList.getMosno(),
                yuukoukknKykList.getTyouhyouymd()));
        }

        assertEquals(3, yuukoukknKykLLst.size());
        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<HT_YuukoukknKykList> yuukoukknKykLLst = sinkeiyakuDomManager.getYuukoukknKykListsByMosno(
            "");
        Assert.assertEquals(0, yuukoukknKykLLst.size());

    }
}
