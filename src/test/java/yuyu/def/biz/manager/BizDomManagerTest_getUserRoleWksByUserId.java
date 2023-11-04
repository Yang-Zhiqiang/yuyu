package yuyu.def.biz.manager;

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

import yuyu.def.db.entity.BW_UserRoleWk;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getUserRoleWksByUserId() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getUserRoleWksByUserId {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BW_UserRoleWk> userRoleWkLst = bizDomManager.getUserRoleWksByUserId("0001");

        Assert.assertEquals(0,userRoleWkLst.size());

        BW_UserRoleWk userRoleWk1 = new BW_UserRoleWk("0001", "Administrators");

        bizDomManager.insert(userRoleWk1);

        BW_UserRoleWk userRoleWk2 = new BW_UserRoleWk("1111", "Administrators");

        bizDomManager.insert(userRoleWk2);

        BW_UserRoleWk userRoleWk3 = new BW_UserRoleWk("0002", "SystemUsers");

        bizDomManager.insert(userRoleWk3);

        BW_UserRoleWk userRoleWk4 = new BW_UserRoleWk("0002", "CommonConsumer");

        bizDomManager.insert(userRoleWk4);

        BW_UserRoleWk userRoleWk5 = new BW_UserRoleWk("0002", "BatchExecutors");

        bizDomManager.insert(userRoleWk5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllUserRoleWk());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BW_UserRoleWk> userRoleWkLst = bizDomManager.getUserRoleWksByUserId("9999");

        Assert.assertEquals(0,userRoleWkLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BW_UserRoleWk> userRoleWkLst = bizDomManager.getUserRoleWksByUserId("0001");

        Assert.assertEquals(1,userRoleWkLst.size());
        assertEquals("0001", userRoleWkLst.get(0).getUserId());
        assertEquals("Administrators", userRoleWkLst.get(0).getRoleCd());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<BW_UserRoleWk> userRoleWkLst = bizDomManager.getUserRoleWksByUserId("0002");

        Assert.assertEquals(3,userRoleWkLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("0002","BatchExecutors"), "1");
        map.put($("0002","CommonConsumer"), "1");
        map.put($("0002","SystemUsers"), "1");

        for(BW_UserRoleWk userRoleWk : userRoleWkLst){
            map.remove($(userRoleWk.getUserId(),userRoleWk.getRoleCd()));
        }
        assertTrue(map.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BW_UserRoleWk> userRoleWkLst = bizDomManager.getUserRoleWksByUserId("");

        Assert.assertEquals(0, userRoleWkLst.size());
    }
}
