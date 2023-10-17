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

import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst = siharaiDomManager.getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno
            ("A110", C_KyhgndkataKbn.TYPE180, 10);
        Assert.assertEquals(0,siSyouhnZokuseiLst.size());

        JM_SiSyouhnZokusei siSyouhnZokusei1 = new JM_SiSyouhnZokusei("A110", C_KyhgndkataKbn.TYPE180, 10, "1000");
        siharaiDomManager.insert(siSyouhnZokusei1);
        JM_SiSyouhnZokusei siSyouhnZokusei2 = new JM_SiSyouhnZokusei("A120", C_KyhgndkataKbn.TYPE180, 10, "1000");
        siharaiDomManager.insert(siSyouhnZokusei2);
        JM_SiSyouhnZokusei siSyouhnZokusei3 = new JM_SiSyouhnZokusei("A110", C_KyhgndkataKbn.TYPE120, 10, "1000");
        siharaiDomManager.insert(siSyouhnZokusei3);
        JM_SiSyouhnZokusei siSyouhnZokusei4 = new JM_SiSyouhnZokusei("A110", C_KyhgndkataKbn.TYPE180, 20, "1000");
        siharaiDomManager.insert(siSyouhnZokusei4);
        JM_SiSyouhnZokusei siSyouhnZokusei5 = new JM_SiSyouhnZokusei("A130", C_KyhgndkataKbn.TYPE60, 30, "1001");
        siharaiDomManager.insert(siSyouhnZokusei5);
        JM_SiSyouhnZokusei siSyouhnZokusei6 = new JM_SiSyouhnZokusei("A130", C_KyhgndkataKbn.TYPE60, 30, "1002");
        siharaiDomManager.insert(siSyouhnZokusei6);
        JM_SiSyouhnZokusei siSyouhnZokusei7 = new JM_SiSyouhnZokusei("A130", C_KyhgndkataKbn.TYPE60, 30, "1003");
        siharaiDomManager.insert(siSyouhnZokusei7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst = siharaiDomManager.getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno
            ("A300", C_KyhgndkataKbn.TYPE180, 10);
        Assert.assertEquals(0,siSyouhnZokuseiLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst = siharaiDomManager.getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno
            ("A110", C_KyhgndkataKbn.TYPE180, 10);
        Assert.assertEquals(1,siSyouhnZokuseiLst.size());
        Assert.assertEquals("A110", siSyouhnZokuseiLst.get(0).getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE180, siSyouhnZokuseiLst.get(0).getKyhgndkatakbn());
        Assert.assertEquals(10, siSyouhnZokuseiLst.get(0).getSyouhnsdno().intValue());
        Assert.assertEquals("1000", siSyouhnZokuseiLst.get(0).getKyuuhucd());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("A130",C_KyhgndkataKbn.TYPE60,30,"1001"), "1");
        datamap.put($("A130",C_KyhgndkataKbn.TYPE60,30,"1002"), "1");
        datamap.put($("A130",C_KyhgndkataKbn.TYPE60,30,"1003"), "1");

        List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst = siharaiDomManager.getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno
            ("A130", C_KyhgndkataKbn.TYPE60, 30);

        for(JM_SiSyouhnZokusei siSyouhnZokusei:siSyouhnZokuseiLst){
            datamap.remove($(
                siSyouhnZokusei.getSyouhncd(),
                siSyouhnZokusei.getKyhgndkatakbn(),
                siSyouhnZokusei.getSyouhnsdno().intValue(),
                siSyouhnZokusei.getKyuuhucd()));
        }

        Assert.assertEquals(3,siSyouhnZokuseiLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}
