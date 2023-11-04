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

import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSksBySyonoItemsSeikyuurirekinoMax() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSksBySyonoItemsSeikyuurirekinoMax {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_Sk> JT_SkLst = siharaiDomManager.getSksBySyonoItemsSeikyuurirekinoMax("11807111118", C_SeikyuuSyubetu.BLNK, C_SaisateiKbn.BLNK, C_SyoriJyoutaiKbn.BLNK);

        Assert.assertEquals(0,JT_SkLst.size());

        JT_SkKihon skKihon1 = new JT_SkKihon("0003", "11807111118");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("0"));
        skKihon1.setSaisateikbn(C_SaisateiKbn.valueOf("0"));
        skKihon1.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("0"));

        JT_Sk sk1 = skKihon1.createSk();
        sk1.setSeikyuurirekino(001);

        JT_Sk sk2 = skKihon1.createSk();
        sk2.setSeikyuurirekino(002);

        JT_Sk sk3 = skKihon1.createSk();
        sk3.setSeikyuurirekino(003);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("0003", "11807111141");
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon2.setSaisateikbn(C_SaisateiKbn.valueOf("1"));
        skKihon2.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("0004", "11807111129");
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("0"));
        skKihon3.setSaisateikbn(C_SaisateiKbn.valueOf("0"));
        skKihon3.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("0"));

        JT_Sk sk4 = skKihon3.createSk();
        sk4.setSeikyuurirekino(004);

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("0005", "11807111118");
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("2"));
        skKihon4.setSaisateikbn(C_SaisateiKbn.valueOf("0"));
        skKihon4.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("0"));

        JT_Sk sk5 = skKihon4.createSk();
        sk5.setSeikyuurirekino(005);

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("0006", "11807111118");
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("0"));
        skKihon5.setSaisateikbn(C_SaisateiKbn.valueOf("1"));
        skKihon5.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("0"));

        JT_Sk sk6 = skKihon5.createSk();
        sk6.setSeikyuurirekino(006);

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("0007", "11807111118");
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("0"));
        skKihon6.setSaisateikbn(C_SaisateiKbn.valueOf("0"));
        skKihon6.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        JT_Sk sk7 = skKihon6.createSk();
        sk7.setSeikyuurirekino(007);

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("0008", "11807111118");
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("0"));
        skKihon7.setSaisateikbn(C_SaisateiKbn.valueOf("0"));
        skKihon7.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("0"));

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("3000", "11807111130");
        skKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon8.setSaisateikbn(C_SaisateiKbn.valueOf("1"));
        skKihon8.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        JT_Sk sk8 = skKihon8.createSk();
        sk8.setSeikyuurirekino(111);

        JT_Sk sk9 = skKihon8.createSk();
        sk9.setSeikyuurirekino(222);

        JT_Sk sk10 = skKihon8.createSk();
        sk10.setSeikyuurirekino(333);

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon9 = new JT_SkKihon("4000", "11807111130");
        skKihon9.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon9.setSaisateikbn(C_SaisateiKbn.valueOf("1"));
        skKihon9.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        JT_Sk sk11 = skKihon9.createSk();
        sk11.setSeikyuurirekino(333);

        siharaiDomManager.insert(skKihon9);

        JT_SkKihon skKihon10 = new JT_SkKihon("5000", "11807111130");
        skKihon10.setSeikyuusyubetu(C_SeikyuuSyubetu.valueOf("1"));
        skKihon10.setSaisateikbn(C_SaisateiKbn.valueOf("1"));
        skKihon10.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        JT_Sk sk12 = skKihon10.createSk();
        sk12.setSeikyuurirekino(333);

        siharaiDomManager.insert(skKihon10);

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<JT_Sk> JT_SkLst = siharaiDomManager.getSksBySyonoItemsSeikyuurirekinoMax("11807111141", C_SeikyuuSyubetu.KYH, C_SaisateiKbn.SAISATEI, C_SyoriJyoutaiKbn.SYORITYUU);

        Assert.assertEquals(0,JT_SkLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JT_Sk> JT_SkLst = siharaiDomManager.getSksBySyonoItemsSeikyuurirekinoMax("11807111118", C_SeikyuuSyubetu.BLNK, C_SaisateiKbn.BLNK, C_SyoriJyoutaiKbn.BLNK);

        Assert.assertEquals(1,JT_SkLst.size());

        Assert.assertEquals("0003",JT_SkLst.get(0).getSkno());
        Assert.assertEquals("11807111118",JT_SkLst.get(0).getSyono());
        Assert.assertEquals(003,JT_SkLst.get(0).getSeikyuurirekino().intValue());



    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("3000","11807111130",333), "1");
        datamap.put($("4000","11807111130",333), "1");
        datamap.put($("5000","11807111130",333), "1");

        List<JT_Sk> JT_SkLst = siharaiDomManager.getSksBySyonoItemsSeikyuurirekinoMax("11807111130", C_SeikyuuSyubetu.KYH, C_SaisateiKbn.SAISATEI, C_SyoriJyoutaiKbn.SYORITYUU);

        for(JT_Sk sk:JT_SkLst){
            datamap.remove($(
                sk.getSkno(),
                sk.getSyono(),
                sk.getSeikyuurirekino().intValue()));
        }

        Assert.assertEquals(3,JT_SkLst.size());

        Assert.assertTrue(datamap.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<JT_Sk> JT_SkLst = siharaiDomManager.getSksBySyonoItemsSeikyuurirekinoMax("", C_SeikyuuSyubetu.BLNK, C_SaisateiKbn.BLNK, C_SyoriJyoutaiKbn.BLNK);

        Assert.assertEquals(0,JT_SkLst.size());

    }
}

