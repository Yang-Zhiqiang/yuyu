package yuyu.def.siharai.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 請求基本テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsBySyorijyoutaikbnLikeHhknnmkn {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(C_SyoriJyoutaiKbn.SYORITYUU, "イイ");
        Assert.assertEquals(0, skKihonLst.size());
        JT_SkKihon skKihon1 = new JT_SkKihon("ASD121", "11807111118");
        skKihon1.setHhknnmkn("エイイエ");
        skKihon1.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("ASD125", "11807111118");
        skKihon2.setHhknnmkn("イエエイ");
        skKihon2.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("ASD127", "11807111118");
        skKihon3.setHhknnmkn("イ");
        skKihon3.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("ASD128", "11807111118");
        skKihon4.setHhknnmkn("エ");
        skKihon4.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("ASD123", "11807111118");
        skKihon5.setHhknnmkn("イイイイ");
        skKihon5.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("ASD130", "11807111118");
        skKihon6.setHhknnmkn("アイイイ");
        skKihon6.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("ASD131", "11807111118");
        skKihon7.setHhknnmkn("ウイイイ");
        skKihon7.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("ASD132", "11807111118");
        skKihon8.setHhknnmkn("イイイイ");
        skKihon8.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("0"));

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon9 = new JT_SkKihon("ASD120", "11807111118");
        skKihon9.setHhknnmkn("エエエエ");
        skKihon9.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

        siharaiDomManager.insert(skKihon9);

        JT_SkKihon skKihon10 = new JT_SkKihon("ASD140", "11807111118");
        skKihon10.setHhknnmkn("ラ");
        skKihon10.setSyorijyoutaikbn(C_SyoriJyoutaiKbn.valueOf("1"));

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
        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(C_SyoriJyoutaiKbn.KANRYOU, "イイ");
        Assert.assertEquals(0, skKihonLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(C_SyoriJyoutaiKbn.SYORITYUU, "ラ");
        Assert.assertEquals(1, skKihonLst.size());

        Assert.assertEquals("ASD140", skKihonLst.get(0).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(0).getSyono());
        Assert.assertEquals("ラ", skKihonLst.get(0).getHhknnmkn());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(C_SyoriJyoutaiKbn.SYORITYUU, "イイ");
        Assert.assertEquals(4, skKihonLst.size());

        Assert.assertEquals("ASD130", skKihonLst.get(0).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(0).getSyono());
        Assert.assertEquals("アイイイ", skKihonLst.get(0).getHhknnmkn());
        Assert.assertEquals("ASD123", skKihonLst.get(1).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(1).getSyono());
        Assert.assertEquals("イイイイ", skKihonLst.get(1).getHhknnmkn());
        Assert.assertEquals("ASD131", skKihonLst.get(2).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(2).getSyono());
        Assert.assertEquals("ウイイイ", skKihonLst.get(2).getHhknnmkn());
        Assert.assertEquals("ASD121", skKihonLst.get(3).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(3).getSyono());
        Assert.assertEquals("エイイエ", skKihonLst.get(3).getHhknnmkn());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(C_SyoriJyoutaiKbn.SYORITYUU, "");
        Assert.assertEquals(9, skKihonLst.size());

        Assert.assertEquals("ASD130", skKihonLst.get(0).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(0).getSyono());
        Assert.assertEquals("アイイイ", skKihonLst.get(0).getHhknnmkn());
        Assert.assertEquals("ASD127", skKihonLst.get(1).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(1).getSyono());
        Assert.assertEquals("イ", skKihonLst.get(1).getHhknnmkn());
        Assert.assertEquals("ASD123", skKihonLst.get(2).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(2).getSyono());
        Assert.assertEquals("イイイイ", skKihonLst.get(2).getHhknnmkn());
        Assert.assertEquals("ASD125", skKihonLst.get(3).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(3).getSyono());
        Assert.assertEquals("イエエイ", skKihonLst.get(3).getHhknnmkn());
        Assert.assertEquals("ASD131", skKihonLst.get(4).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(4).getSyono());
        Assert.assertEquals("ウイイイ", skKihonLst.get(4).getHhknnmkn());
        Assert.assertEquals("ASD128", skKihonLst.get(5).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(5).getSyono());
        Assert.assertEquals("エ", skKihonLst.get(5).getHhknnmkn());
        Assert.assertEquals("ASD121", skKihonLst.get(6).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(6).getSyono());
        Assert.assertEquals("エイイエ", skKihonLst.get(6).getHhknnmkn());
        Assert.assertEquals("ASD120", skKihonLst.get(7).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(7).getSyono());
        Assert.assertEquals("エエエエ", skKihonLst.get(7).getHhknnmkn());
        Assert.assertEquals("ASD140", skKihonLst.get(8).getSkno());
        Assert.assertEquals("11807111118", skKihonLst.get(8).getSyono());
        Assert.assertEquals("ラ", skKihonLst.get(8).getHhknnmkn());
    }

}
