package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getBuntanInfosByPK() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getBuntanInfosByPK {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosByPK("5200002", "4001", "3200002",
            BizDateYM.valueOf(201512));

        Assert.assertEquals(0, buntanInfoLst.size());

        BT_BuntanInfo buntanInfo1 = new BT_BuntanInfo();
        buntanInfo1.setDrtencd("5200002");
        buntanInfo1.setDairitensyouhincd("4001");
        buntanInfo1.setTesuuryoubuntandrtencd("3200002");
        buntanInfo1.setTesuuryoubuntanstartym(BizDateYM.valueOf(201510));
        buntanInfo1.setTesuuryoubuntanendym(BizDateYM.valueOf(201512));
        bizDomManager.insert(buntanInfo1);

        BT_BuntanInfo buntanInfo2 = new BT_BuntanInfo();
        buntanInfo2.setDrtencd("5200002");
        buntanInfo2.setDairitensyouhincd("4001");
        buntanInfo2.setTesuuryoubuntandrtencd("3200002");
        buntanInfo2.setTesuuryoubuntanstartym(BizDateYM.valueOf(201511));
        buntanInfo2.setTesuuryoubuntanendym(BizDateYM.valueOf(201601));
        bizDomManager.insert(buntanInfo2);

        BT_BuntanInfo buntanInfo3 = new BT_BuntanInfo();
        buntanInfo3.setDrtencd("5200002");
        buntanInfo3.setDairitensyouhincd("4001");
        buntanInfo3.setTesuuryoubuntandrtencd("3200002");
        buntanInfo3.setTesuuryoubuntanstartym(BizDateYM.valueOf(201512));
        buntanInfo3.setTesuuryoubuntanendym(BizDateYM.valueOf(201512));
        bizDomManager.insert(buntanInfo3);

        BT_BuntanInfo buntanInfo4 = new BT_BuntanInfo();
        buntanInfo4.setDrtencd("5200003");
        buntanInfo4.setDairitensyouhincd("4001");
        buntanInfo4.setTesuuryoubuntandrtencd("3200002");
        buntanInfo4.setTesuuryoubuntanstartym(BizDateYM.valueOf(201510));
        buntanInfo4.setTesuuryoubuntanendym(BizDateYM.valueOf(201512));
        bizDomManager.insert(buntanInfo4);

        BT_BuntanInfo buntanInfo5 = new BT_BuntanInfo();
        buntanInfo5.setDrtencd("5200002");
        buntanInfo5.setDairitensyouhincd("4002");
        buntanInfo5.setTesuuryoubuntandrtencd("3200002");
        buntanInfo5.setTesuuryoubuntanstartym(BizDateYM.valueOf(201511));
        buntanInfo5.setTesuuryoubuntanendym(BizDateYM.valueOf(201512));
        bizDomManager.insert(buntanInfo5);

        BT_BuntanInfo buntanInfo6 = new BT_BuntanInfo();
        buntanInfo6.setDrtencd("5200002");
        buntanInfo6.setDairitensyouhincd("4001");
        buntanInfo6.setTesuuryoubuntandrtencd("3200001");
        buntanInfo6.setTesuuryoubuntanstartym(BizDateYM.valueOf(201512));
        buntanInfo6.setTesuuryoubuntanendym(BizDateYM.valueOf(201512));
        bizDomManager.insert(buntanInfo6);

        BT_BuntanInfo buntanInfo7 = new BT_BuntanInfo();
        buntanInfo7.setDrtencd("5200002");
        buntanInfo7.setDairitensyouhincd("4001");
        buntanInfo7.setTesuuryoubuntandrtencd("3200002");
        buntanInfo7.setTesuuryoubuntanstartym(BizDateYM.valueOf(201601));
        buntanInfo7.setTesuuryoubuntanendym(BizDateYM.valueOf(201602));
        bizDomManager.insert(buntanInfo7);

        BT_BuntanInfo buntanInfo8 = new BT_BuntanInfo();
        buntanInfo8.setDrtencd("5200002");
        buntanInfo8.setDairitensyouhincd("4001");
        buntanInfo8.setTesuuryoubuntandrtencd("3200002");
        buntanInfo8.setTesuuryoubuntanstartym(BizDateYM.valueOf(201509));
        buntanInfo8.setTesuuryoubuntanendym(BizDateYM.valueOf(201511));
        bizDomManager.insert(buntanInfo8);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllBuntanInfo());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosByPK("5200002", "4004", "3200002",
            BizDateYM.valueOf(201512));

        assertEquals(0, buntanInfoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosByPK("5200003", "4001", "3200002",
            BizDateYM.valueOf(201512));

        assertEquals(1, buntanInfoLst.size());
        assertEquals("5200003", buntanInfoLst.get(0).getDrtencd());
        assertEquals("4001", buntanInfoLst.get(0).getDairitensyouhincd());
        assertEquals("3200002", buntanInfoLst.get(0).getTesuuryoubuntandrtencd());
        assertEquals(BizDateYM.valueOf(201510), buntanInfoLst.get(0).getTesuuryoubuntanstartym());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosByPK("5200002", "4001", "3200002",
            BizDateYM.valueOf(201512));

        assertEquals(3, buntanInfoLst.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($("5200002", "4001", "3200002", BizDateYM.valueOf(201510)),"1");
        map.put($("5200002", "4001", "3200002", BizDateYM.valueOf(201511)),"2");
        map.put($("5200002", "4001", "3200002", BizDateYM.valueOf(201512)),"3");


        assertTrue(map.containsKey($(buntanInfoLst.get(0).getDrtencd(), buntanInfoLst.get(0).getDairitensyouhincd(), buntanInfoLst.get(0).getTesuuryoubuntandrtencd(), buntanInfoLst.get(0).getTesuuryoubuntanstartym())));
        assertTrue(map.containsKey($(buntanInfoLst.get(1).getDrtencd(), buntanInfoLst.get(1).getDairitensyouhincd(), buntanInfoLst.get(1).getTesuuryoubuntandrtencd(), buntanInfoLst.get(1).getTesuuryoubuntanstartym())));
        assertTrue(map.containsKey($(buntanInfoLst.get(2).getDrtencd(), buntanInfoLst.get(2).getDairitensyouhincd(), buntanInfoLst.get(2).getTesuuryoubuntandrtencd(), buntanInfoLst.get(2).getTesuuryoubuntanstartym())));


        map.remove($(buntanInfoLst.get(0).getDrtencd(), buntanInfoLst.get(0).getDairitensyouhincd(), buntanInfoLst.get(0).getTesuuryoubuntandrtencd(), buntanInfoLst.get(0).getTesuuryoubuntanstartym()));
        map.remove($(buntanInfoLst.get(1).getDrtencd(), buntanInfoLst.get(1).getDairitensyouhincd(), buntanInfoLst.get(1).getTesuuryoubuntandrtencd(), buntanInfoLst.get(1).getTesuuryoubuntanstartym()));
        map.remove($(buntanInfoLst.get(2).getDrtencd(), buntanInfoLst.get(2).getDairitensyouhincd(), buntanInfoLst.get(2).getTesuuryoubuntandrtencd(), buntanInfoLst.get(2).getTesuuryoubuntanstartym()));

        assertTrue(map.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosByPK("", "4001", "3200002",
            BizDateYM.valueOf(201512));

        assertEquals(0, buntanInfoLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosByPK("5200002", "", "3200002",
            BizDateYM.valueOf(201512));

        assertEquals(0, buntanInfoLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankCondition3() {

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosByPK("5200002", "4001", "",
            BizDateYM.valueOf(201512));

        assertEquals(0, buntanInfoLst.size());

    }
}
