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
 * getSkKihonsBySyonoSibouKariuketsuke() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class SiharaiDomManagerTest_getSkKihonsBySyonoSibouKariuketsuke {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSibouKariuketsuke("11807111130");

        Assert.assertEquals(0, skKihonLst.size());

        JT_SkKihon skKihon8 = new JT_SkKihon("1111", "11807111129");
        skKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon1 = new JT_SkKihon("1111", "11807111130");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke1 = skKihon1.createSibouKariuketsuke();
        sibouKariuketsuke1.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("1111", "11807111118");
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke2 = skKihon2.createSibouKariuketsuke();
        sibouKariuketsuke2.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("2222", "11807111130");
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.BLNK);

        JT_SibouKariuketsuke sibouKariuketsuke3 = skKihon3.createSibouKariuketsuke();
        sibouKariuketsuke3.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("3333", "11807111130");
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke4 = skKihon4.createSibouKariuketsuke();
        sibouKariuketsuke4.setTorikesiflg(C_UmuKbn.ARI);

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("4444", "11807111200");
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke5 = skKihon5.createSibouKariuketsuke();
        sibouKariuketsuke5.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("5555", "11807111200");
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke6 = skKihon6.createSibouKariuketsuke();
        sibouKariuketsuke6.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("6666", "11807111200");
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.SBKRUKTK);

        JT_SibouKariuketsuke sibouKariuketsuke7 = skKihon7.createSibouKariuketsuke();
        sibouKariuketsuke7.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon7);

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

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSibouKariuketsuke("11807111129");

        Assert.assertEquals(0, skKihonLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSibouKariuketsuke("11807111130");


        Assert.assertEquals(1, skKihonLst.size());
        Assert.assertEquals("1111", skKihonLst.get(0).getSkno());
        Assert.assertEquals("11807111130", skKihonLst.get(0).getSyono());
        Assert.assertEquals(C_SeikyuuSyubetu.SBKRUKTK, skKihonLst.get(0).getSeikyuusyubetu());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("4444","11807111200",C_SeikyuuSyubetu.SBKRUKTK), "1");
        datamap.put($("5555","11807111200",C_SeikyuuSyubetu.SBKRUKTK), "1");
        datamap.put($("6666","11807111200",C_SeikyuuSyubetu.SBKRUKTK), "1");

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSibouKariuketsuke("11807111200");

        for(JT_SkKihon skKihon:skKihonLst){
            datamap.remove($(
                skKihon.getSkno(),
                skKihon.getSyono(),
                skKihon.getSeikyuusyubetu()));
        }

        Assert.assertEquals(3, skKihonLst.size());
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoSibouKariuketsuke("");
        Assert.assertEquals(0, skKihonLst.size());

    }
}
