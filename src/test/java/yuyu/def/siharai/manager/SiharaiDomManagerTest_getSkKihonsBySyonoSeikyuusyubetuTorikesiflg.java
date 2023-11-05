package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSkKihonsBySyonoSeikyuusyubetuTorikesiflg() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class SiharaiDomManagerTest_getSkKihonsBySyonoSeikyuusyubetuTorikesiflg {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg("10000000001", C_SeikyuuSyubetu.SBKRUKTK,C_UmuKbn.NONE);

        Assert.assertEquals(0,skKihonLst.size());

        JT_SkKihon skKihon1 = new JT_SkKihon("10000000060", "10000000001");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke1 = skKihon1.createSibouKariuketsuke();
        sibouKariuketsuke1.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon6 = new JT_SkKihon("10000000064", "10000000004");
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke6 = skKihon6.createSibouKariuketsuke();
        sibouKariuketsuke6.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon3 = new JT_SkKihon("10000000061", "10000000002");
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke3 = skKihon3.createSibouKariuketsuke();
        sibouKariuketsuke3.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("10000000062", "10000000002");
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke4 = skKihon4.createSibouKariuketsuke();
        sibouKariuketsuke4.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon7 = new JT_SkKihon("10000000065", "10000000002");
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke7 = skKihon7.createSibouKariuketsuke();
        sibouKariuketsuke7.setTorikesiflg(C_UmuKbn.ARI);

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("10000000066", "10000000002");
        skKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.BLNK);

        JT_SibouKariuketsuke sibouKariuketsuke8 = skKihon8.createSibouKariuketsuke();
        sibouKariuketsuke8.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon5 = new JT_SkKihon("10000000063", "10000000002");
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke5 = skKihon5.createSibouKariuketsuke();
        sibouKariuketsuke5.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg("10000000003", C_SeikyuuSyubetu.SBKRUKTK,C_UmuKbn.ARI);

        Assert.assertEquals(0, skKihonLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg("10000000001", C_SeikyuuSyubetu.SBKRUKTK,C_UmuKbn.NONE);


        Assert.assertEquals(1, skKihonLst.size());
        Assert.assertEquals("10000000060", skKihonLst.get(0).getSkno());
        Assert.assertEquals("10000000001", skKihonLst.get(0).getSyono());
        Assert.assertEquals(C_SeikyuuSyubetu.SBKRUKTK, skKihonLst.get(0).getSeikyuusyubetu());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("10000000061","10000000002",C_SeikyuuSyubetu.SBKRUKTK), "1");
        datamap.put($("10000000062","10000000002",C_SeikyuuSyubetu.SBKRUKTK), "1");
        datamap.put($("10000000063","10000000002",C_SeikyuuSyubetu.SBKRUKTK), "1");

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg("10000000002", C_SeikyuuSyubetu.SBKRUKTK,C_UmuKbn.NONE);

        for(JT_SkKihon skKihon:skKihonLst){
            datamap.remove($(
                skKihon.getSkno(),
                skKihon.getSyono(),
                skKihon.getSeikyuusyubetu()));
        }

        Assert.assertEquals(3, skKihonLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }
}
