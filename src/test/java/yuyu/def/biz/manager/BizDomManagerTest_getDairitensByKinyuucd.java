package yuyu.def.biz.manager;

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

import yuyu.def.db.entity.BM_Dairiten;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getDairitensByKinyuucd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getDairitensByKinyuucd {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BM_Dairiten> dairitenList = bizDomManager.getDairitensByKinyuucd("0001");
        Assert.assertEquals(0, dairitenList.size());

        BM_Dairiten dairiten1 = new BM_Dairiten("0000001");
        dairiten1.setOyadrtencd("0000001");
        dairiten1.setDairitenkouryokukaisiymd(BizDate.getSysDate());
        dairiten1.setDairitenkouryokusyuuryouymd(BizDate.getSysDate());
        dairiten1.setKinyuucd("0001");

        bizDomManager.insert(dairiten1);

        BM_Dairiten dairiten2 = new BM_Dairiten("0000002");
        dairiten2.setOyadrtencd("0000002");
        dairiten2.setDairitenkouryokukaisiymd(BizDate.getSysDate());
        dairiten2.setDairitenkouryokusyuuryouymd(BizDate.getSysDate());
        dairiten2.setKinyuucd("0010");

        bizDomManager.insert(dairiten2);

        BM_Dairiten dairiten3 = new BM_Dairiten("0000003");
        dairiten3.setOyadrtencd("0000030");
        dairiten3.setDairitenkouryokukaisiymd(BizDate.getSysDate());
        dairiten3.setDairitenkouryokusyuuryouymd(BizDate.getSysDate());
        dairiten3.setKinyuucd("0001");

        bizDomManager.insert(dairiten3);

        BM_Dairiten dairiten4 = new BM_Dairiten("0000004");
        dairiten4.setOyadrtencd("0000004");
        dairiten4.setDairitenkouryokukaisiymd(BizDate.getSysDate().addDays(1));
        dairiten4.setDairitenkouryokusyuuryouymd(BizDate.getSysDate().addDays(2));
        dairiten4.setKinyuucd("0001");

        bizDomManager.insert(dairiten4);

        BM_Dairiten dairiten5 = new BM_Dairiten("0000005");
        dairiten5.setOyadrtencd("0000005");
        dairiten5.setDairitenkouryokukaisiymd(BizDate.getSysDate().addDays(-2));
        dairiten5.setDairitenkouryokusyuuryouymd(BizDate.getSysDate().addDays(-1));
        dairiten5.setKinyuucd("0001");

        bizDomManager.insert(dairiten5);

        BM_Dairiten dairiten6 = new BM_Dairiten("0000006");
        dairiten6.setOyadrtencd("0000006");
        dairiten6.setDairitenkouryokukaisiymd(BizDate.getSysDate().addDays(-1));
        dairiten6.setDairitenkouryokusyuuryouymd(BizDate.getSysDate());
        dairiten6.setKinyuucd("0002");

        bizDomManager.insert(dairiten6);

        BM_Dairiten dairiten7 = new BM_Dairiten("0000007");
        dairiten7.setOyadrtencd("0000007");
        dairiten7.setDairitenkouryokukaisiymd(BizDate.getSysDate());
        dairiten7.setKinyuucd("0002");

        bizDomManager.insert(dairiten7);

        BM_Dairiten dairiten8 = new BM_Dairiten("0000008");
        dairiten8.setOyadrtencd("0000008");
        dairiten8.setDairitenkouryokukaisiymd(BizDate.getSysDate());
        dairiten8.setDairitenkouryokusyuuryouymd(BizDate.getSysDate().addDays(1));
        dairiten8.setKinyuucd("0002");

        bizDomManager.insert(dairiten8);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllDairiten());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_Dairiten> dairitenList = bizDomManager.getDairitensByKinyuucd("1111");
        Assert.assertEquals(0, dairitenList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BM_Dairiten> dairitenList = bizDomManager.getDairitensByKinyuucd("0001");
        Assert.assertEquals(1, dairitenList.size());

        Assert.assertEquals("0000001", dairitenList.get(0).getDrtencd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BM_Dairiten> dairitenList = bizDomManager.getDairitensByKinyuucd("0002");
        Assert.assertEquals(3, dairitenList.size());

        Map<String,String> map = new HashMap<String,String>();
        map.put($("0000006"), "1");
        map.put($("0000007"), "1");
        map.put($("0000008"), "1");

        assertTrue(map.containsKey($(dairitenList.get(0).getDrtencd())));
        assertTrue(map.containsKey($(dairitenList.get(1).getDrtencd())));
        assertTrue(map.containsKey($(dairitenList.get(2).getDrtencd())));

        map.remove($(dairitenList.get(0).getDrtencd()));
        map.remove($(dairitenList.get(1).getDrtencd()));
        map.remove($(dairitenList.get(2).getDrtencd()));

        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BM_Dairiten> dairitenList = bizDomManager.getDairitensByKinyuucd("");
        Assert.assertEquals(0, dairitenList.size());

    }
}
