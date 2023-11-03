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
 * getBuntanInfosAitedrtenSiteinasi() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getBuntanInfosAitedrtenSiteinasi {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosAitedrtenSiteinasi("5200002", "4001", BizDateYM.valueOf(201812));

        Assert.assertEquals(0, buntanInfoLst.size());

        BT_BuntanInfo buntanInfo1 = new BT_BuntanInfo();
        buntanInfo1.setDrtencd("5200002");
        buntanInfo1.setDairitensyouhincd("4001");
        buntanInfo1.setTesuuryoubuntandrtencd("8200001");
        buntanInfo1.setTesuuryoubuntanstartym(BizDateYM.valueOf(201812));
        buntanInfo1.setTesuuryoubuntanendym(BizDateYM.valueOf(201901));
        bizDomManager.insert(buntanInfo1);

        BT_BuntanInfo buntanInfo2 = new BT_BuntanInfo();
        buntanInfo2.setDrtencd("5200003");
        buntanInfo2.setDairitensyouhincd("4001");
        buntanInfo2.setTesuuryoubuntandrtencd("8200001");
        buntanInfo2.setTesuuryoubuntanstartym(BizDateYM.valueOf(201812));
        buntanInfo2.setTesuuryoubuntanendym(BizDateYM.valueOf(201901));
        bizDomManager.insert(buntanInfo2);

        BT_BuntanInfo buntanInfo3 = new BT_BuntanInfo();
        buntanInfo3.setDrtencd("5200004");
        buntanInfo3.setDairitensyouhincd("4002");
        buntanInfo3.setTesuuryoubuntandrtencd("8200002");
        buntanInfo3.setTesuuryoubuntanstartym(BizDateYM.valueOf(201811));
        bizDomManager.insert(buntanInfo3);

        BT_BuntanInfo buntanInfo4 = new BT_BuntanInfo();
        buntanInfo4.setDrtencd("5200004");
        buntanInfo4.setDairitensyouhincd("4002");
        buntanInfo4.setTesuuryoubuntandrtencd("8200003");
        buntanInfo4.setTesuuryoubuntanstartym(BizDateYM.valueOf(201812));
        buntanInfo4.setTesuuryoubuntanendym(BizDateYM.valueOf(201812));
        bizDomManager.insert(buntanInfo4);

        BT_BuntanInfo buntanInfo5 = new BT_BuntanInfo();
        buntanInfo5.setDrtencd("5200004");
        buntanInfo5.setDairitensyouhincd("4002");
        buntanInfo5.setTesuuryoubuntandrtencd("8200004");
        buntanInfo5.setTesuuryoubuntanstartym(BizDateYM.valueOf(201712));
        buntanInfo5.setTesuuryoubuntanendym(BizDateYM.valueOf(201904));
        bizDomManager.insert(buntanInfo5);

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

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosAitedrtenSiteinasi("5200002", "3001", BizDateYM.valueOf(201812));

        assertEquals(0, buntanInfoLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosAitedrtenSiteinasi("5200003", "4001", BizDateYM.valueOf(201812));

        assertEquals(1, buntanInfoLst.size());
        assertEquals("5200003", buntanInfoLst.get(0).getDrtencd());
        assertEquals("4001", buntanInfoLst.get(0).getDairitensyouhincd());
        assertEquals("8200001", buntanInfoLst.get(0).getTesuuryoubuntandrtencd());
        assertEquals(BizDateYM.valueOf(201812), buntanInfoLst.get(0).getTesuuryoubuntanstartym());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosAitedrtenSiteinasi("5200004", "4002", BizDateYM.valueOf(201812));

        assertEquals(3, buntanInfoLst.size());

        Map<String,String> map = new HashMap<String,String>();

        map.put($("5200004", "4002", "8200002", BizDateYM.valueOf(201811)),"1");
        map.put($("5200004", "4002", "8200003", BizDateYM.valueOf(201812)),"2");
        map.put($("5200004", "4002", "8200004", BizDateYM.valueOf(201712)),"3");

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

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosAitedrtenSiteinasi("", "4001", BizDateYM.valueOf(201812));

        assertEquals(0, buntanInfoLst.size());

    }

    @Test
    @TestOrder(50)
    public void blankConditio2() {

        List<BT_BuntanInfo> buntanInfoLst = bizDomManager.getBuntanInfosAitedrtenSiteinasi("5200002", "", BizDateYM.valueOf(201812));

        assertEquals(0, buntanInfoLst.size());

    }
}
