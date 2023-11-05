package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSkKihonsBySyonoSeikyuusyubetuSaisateikbn() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class SiharaiDomManagerTest_getSkKihonsBySyonoSeikyuusyubetuSaisateikbn {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);


        List<JT_SkKihon> skKihonLst = siharaiDomManager.
            getSkKihonsBySyonoSeikyuusyubetuSaisateikbn("11807111118", C_SeikyuuSyubetu.KYH, C_SaisateiKbn.SAISATEI);

        Assert.assertEquals(0,skKihonLst.size());

        JT_SkKihon skKihon1 = new JT_SkKihon("SKNO01", "11807111118");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon1.setSaisateikbn(C_SaisateiKbn.SAISATEI);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("SKNO01", "11807111129");
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon2.setSaisateikbn(C_SaisateiKbn.SAISATEI);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("SKNO02", "11807111118");
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.BLNK);
        skKihon3.setSaisateikbn(C_SaisateiKbn.SAISATEI);

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("SKNO03", "11807111118");
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon4.setSaisateikbn(C_SaisateiKbn.BLNK);

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("SKNO04", "11807111163");
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.PM);
        skKihon5.setSaisateikbn(C_SaisateiKbn.SAISATEI);

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("SKNO05", "11807111163");
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.PM);
        skKihon6.setSaisateikbn(C_SaisateiKbn.SAISATEI);

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("SKNO06", "11807111163");
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.PM);
        skKihon7.setSaisateikbn(C_SaisateiKbn.SAISATEI);

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
    public void noResult(){

        List<JT_SkKihon> skKihonLst = siharaiDomManager.
            getSkKihonsBySyonoSeikyuusyubetuSaisateikbn("11807111118", C_SeikyuuSyubetu.BLNK, C_SaisateiKbn.BLNK);

        Assert.assertEquals(0,skKihonLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<JT_SkKihon> skKihonLst = siharaiDomManager.
            getSkKihonsBySyonoSeikyuusyubetuSaisateikbn("11807111118", C_SeikyuuSyubetu.KYH, C_SaisateiKbn.SAISATEI);

        Assert.assertEquals(1,skKihonLst.size());
        Assert.assertEquals("SKNO01", skKihonLst.get(0).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(0).getSyono());


    }
    @Test
    @TestOrder(30)
    public void normal2(){

        Map<String,String> SkKihonMap = new HashMap<String,String>();
        SkKihonMap.put($("SKNO04", "11807111163"),"1");
        SkKihonMap.put($("SKNO05", "11807111163"),"1");
        SkKihonMap.put($("SKNO06", "11807111163"),"1");

        List<JT_SkKihon> skKihonLst = siharaiDomManager.
            getSkKihonsBySyonoSeikyuusyubetuSaisateikbn("11807111163", C_SeikyuuSyubetu.PM, C_SaisateiKbn.SAISATEI);

        Assert.assertEquals(3,skKihonLst.size());

        SkKihonMap.remove($(skKihonLst.get(0).getSkno(),skKihonLst.get(0).getSyono()));
        SkKihonMap.remove($(skKihonLst.get(1).getSkno(),skKihonLst.get(1).getSyono()));
        SkKihonMap.remove($(skKihonLst.get(2).getSkno(),skKihonLst.get(2).getSyono()));

        assertTrue(SkKihonMap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank(){

        List<JT_SkKihon> skKihonLst = siharaiDomManager.
            getSkKihonsBySyonoSeikyuusyubetuSaisateikbn("", C_SeikyuuSyubetu.KYH, C_SaisateiKbn.SAISATEI);

        Assert.assertEquals(0,skKihonLst.size());

    }
}

