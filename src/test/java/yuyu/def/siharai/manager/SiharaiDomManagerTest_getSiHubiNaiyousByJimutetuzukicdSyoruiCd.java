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

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.JM_SiHubiNaiyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiHubiNaiyousByJimutetuzukicdSyoruiCd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiHubiNaiyousByJimutetuzukicdSyoruiCd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JM_SiHubiNaiyou> siHubiNaiyouLst = siharaiDomManager.getSiHubiNaiyousByJimutetuzukicdSyoruiCd("J001", C_SyoruiCdKbn.BLNK);
        Assert.assertEquals(0,siHubiNaiyouLst.size());

        JM_SiHubiNaiyou jM_SiHubiNaiyou1 = new JM_SiHubiNaiyou();
        jM_SiHubiNaiyou1.setJimutetuzukicd("J001");
        jM_SiHubiNaiyou1.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        jM_SiHubiNaiyou1.setHubinaiyoucd("H001");
        siharaiDomManager.insert(jM_SiHubiNaiyou1);

        JM_SiHubiNaiyou jM_SiHubiNaiyou2 = new JM_SiHubiNaiyou();
        jM_SiHubiNaiyou2.setJimutetuzukicd("J002");
        jM_SiHubiNaiyou2.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        jM_SiHubiNaiyou2.setHubinaiyoucd("H001");
        siharaiDomManager.insert(jM_SiHubiNaiyou2);

        JM_SiHubiNaiyou jM_SiHubiNaiyou3 = new JM_SiHubiNaiyou();
        jM_SiHubiNaiyou3.setJimutetuzukicd("J001");
        jM_SiHubiNaiyou3.setSyoruiCd(C_SyoruiCdKbn.CM_JIMURENRAKUHYOU);
        jM_SiHubiNaiyou3.setHubinaiyoucd("H001");
        siharaiDomManager.insert(jM_SiHubiNaiyou3);

        JM_SiHubiNaiyou jM_SiHubiNaiyou4 = new JM_SiHubiNaiyou();
        jM_SiHubiNaiyou4.setJimutetuzukicd("J003");
        jM_SiHubiNaiyou4.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        jM_SiHubiNaiyou4.setHubinaiyoucd("H003");
        siharaiDomManager.insert(jM_SiHubiNaiyou4);

        JM_SiHubiNaiyou jM_SiHubiNaiyou5 = new JM_SiHubiNaiyou();
        jM_SiHubiNaiyou5.setJimutetuzukicd("J003");
        jM_SiHubiNaiyou5.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        jM_SiHubiNaiyou5.setHubinaiyoucd("H002");
        siharaiDomManager.insert(jM_SiHubiNaiyou5);

        JM_SiHubiNaiyou jM_SiHubiNaiyou6 = new JM_SiHubiNaiyou();
        jM_SiHubiNaiyou6.setJimutetuzukicd("J003");
        jM_SiHubiNaiyou6.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        jM_SiHubiNaiyou6.setHubinaiyoucd("H001");
        siharaiDomManager.insert(jM_SiHubiNaiyou6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiHubiNaiyou());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JM_SiHubiNaiyou> siHubiNaiyouLst = siharaiDomManager.getSiHubiNaiyousByJimutetuzukicdSyoruiCd("J004", C_SyoruiCdKbn.BLNK);

        Assert.assertEquals(0,siHubiNaiyouLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JM_SiHubiNaiyou> siHubiNaiyouLst = siharaiDomManager.getSiHubiNaiyousByJimutetuzukicdSyoruiCd("J001", C_SyoruiCdKbn.BLNK);

        Assert.assertEquals(1,siHubiNaiyouLst.size());

        Assert.assertEquals("J001", siHubiNaiyouLst.get(0).getJimutetuzukicd());
        Assert.assertEquals(C_SyoruiCdKbn.BLNK, siHubiNaiyouLst.get(0).getSyoruiCd());
        Assert.assertEquals("H001", siHubiNaiyouLst.get(0).getHubinaiyoucd());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("J003",C_SyoruiCdKbn.BLNK,"H001"), "1");
        datamap.put($("J003",C_SyoruiCdKbn.BLNK,"H002"), "1");
        datamap.put($("J003",C_SyoruiCdKbn.BLNK,"H003"), "1");

        List<JM_SiHubiNaiyou> siHubiNaiyouLst = siharaiDomManager.getSiHubiNaiyousByJimutetuzukicdSyoruiCd("J003", C_SyoruiCdKbn.BLNK);

        for(JM_SiHubiNaiyou siHubiNaiyou:siHubiNaiyouLst){
            datamap.remove($(
                siHubiNaiyou.getJimutetuzukicd(),
                siHubiNaiyou.getSyoruiCd(),
                siHubiNaiyou.getHubinaiyoucd()));
        }

        Assert.assertEquals(3,siHubiNaiyouLst.size());

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<JM_SiHubiNaiyou> siHubiNaiyouLst = siharaiDomManager.getSiHubiNaiyousByJimutetuzukicdSyoruiCd("", C_SyoruiCdKbn.BLNK);

        Assert.assertEquals(0,siHubiNaiyouLst.size());
    }
}
