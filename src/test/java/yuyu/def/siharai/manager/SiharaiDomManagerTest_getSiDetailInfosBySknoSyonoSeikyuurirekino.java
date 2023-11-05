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

import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.result.bean.SiDetailInfosBySknoSyonoSeikyuurirekinoBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 支社別保険金種類別集計情報作成<br />
 * 支払明細情報Beanリスト取得(請求番号、証券番号、請求履歴番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiDetailInfosBySknoSyonoSeikyuurirekino {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "skno001";
    static String P_SKNO_02 = "skno002";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static Integer P_SEIKYUURIEKINO_1 = new Integer(10);
    static Integer P_SEIKYUURIEKINO_2 = new Integer(20);
    static Integer P_SEIKYUURIEKINO_3 = new Integer(30);
    static Integer P_UKETUKENO_1 = new Integer(1);
    static Integer P_UKETUKENO_2 = new Integer(2);
    static String P_SYOUHNCD = "200";
    static Integer P_SYOUHNSDNO = new Integer(1);
    static Integer P_KYKSYOUHNRENNO = new Integer(2);
    static Integer P_RENNO = new Integer(3);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst = siharaiDomManager.getSiDetailInfosBySknoSyonoSeikyuurirekino(P_SKNO_01, P_SYONO_02, P_SEIKYUURIEKINO_1);

        Assert.assertEquals(0,siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.size());

        JT_SkKihon skKihon1 = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_Sk sk1 = skKihon1.createSk();
        sk1.setSeikyuurirekino(P_SEIKYUURIEKINO_1);

        JT_SkJiyuu skJiyuu1 = sk1.createSkJiyuu();
        skJiyuu1.setUketukeno(P_UKETUKENO_2);

        JT_SiDetail siDetail1 = skJiyuu1.createSiDetail();
        siDetail1.setSyutkkbn(C_SyutkKbn.SYU);
        siDetail1.setSyouhncd(P_SYOUHNCD);
        siDetail1.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siDetail1.setSyouhnsdno(P_SYOUHNSDNO);
        siDetail1.setKyksyouhnrenno(P_KYKSYOUHNRENNO);
        siDetail1.setKyuuhucd("700");
        siDetail1.setRenno(P_RENNO);

        JT_SkJiyuu skJiyuu2 = sk1.createSkJiyuu();
        skJiyuu2.setUketukeno(P_UKETUKENO_1);

        JT_SiDetail siDetail2 = skJiyuu2.createSiDetail();
        siDetail2.setSyutkkbn(C_SyutkKbn.SYU);
        siDetail2.setSyouhncd(P_SYOUHNCD);
        siDetail2.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siDetail2.setSyouhnsdno(P_SYOUHNSDNO);
        siDetail2.setKyksyouhnrenno(P_KYKSYOUHNRENNO);
        siDetail2.setKyuuhucd("500");
        siDetail2.setRenno(P_RENNO);

        JT_SiDetail siDetail3 = skJiyuu1.createSiDetail();
        siDetail3.setSyutkkbn(C_SyutkKbn.SYU);
        siDetail3.setSyouhncd(P_SYOUHNCD);
        siDetail3.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siDetail3.setSyouhnsdno(P_SYOUHNSDNO);
        siDetail3.setKyksyouhnrenno(P_KYKSYOUHNRENNO);
        siDetail3.setKyuuhucd("600");
        siDetail3.setRenno(P_RENNO);

        JT_SkKihon skKihon2 = new JT_SkKihon(P_SKNO_01, P_SYONO_02);

        JT_Sk sk2 = skKihon2.createSk();
        sk2.setSeikyuurirekino(P_SEIKYUURIEKINO_1);

        JT_SkJiyuu skJiyuu3 = sk2.createSkJiyuu();
        skJiyuu3.setUketukeno(P_UKETUKENO_2);

        JT_SiDetail siDetail4 = skJiyuu3.createSiDetail();
        siDetail4.setSyutkkbn(C_SyutkKbn.SYU);
        siDetail4.setSyouhncd(P_SYOUHNCD);
        siDetail4.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siDetail4.setSyouhnsdno(P_SYOUHNSDNO);
        siDetail4.setKyksyouhnrenno(P_KYKSYOUHNRENNO);
        siDetail4.setKyuuhucd("400");
        siDetail4.setRenno(P_RENNO);

        JT_Sk sk3 = skKihon2.createSk();
        sk3.setSeikyuurirekino(P_SEIKYUURIEKINO_3);

        JT_SkJiyuu skJiyuu4 = sk3.createSkJiyuu();
        skJiyuu4.setUketukeno(P_UKETUKENO_2);

        JT_SiDetail siDetail5 = skJiyuu4.createSiDetail();
        siDetail5.setSyutkkbn(C_SyutkKbn.SYU);
        siDetail5.setSyouhncd(P_SYOUHNCD);
        siDetail5.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siDetail5.setSyouhnsdno(P_SYOUHNSDNO);
        siDetail5.setKyksyouhnrenno(P_KYKSYOUHNRENNO);
        siDetail5.setKyuuhucd("300");
        siDetail5.setRenno(P_RENNO);

        JT_SkKihon skKihon3 = new JT_SkKihon(P_SKNO_01, P_SYONO_03);

        JT_Sk sk4 = skKihon3.createSk();
        sk4.setSeikyuurirekino(P_SEIKYUURIEKINO_1);

        JT_SkJiyuu skJiyuu5 = sk4.createSkJiyuu();
        skJiyuu5.setUketukeno(P_UKETUKENO_2);

        JT_SiDetail siDetail6 = skJiyuu5.createSiDetail();
        siDetail6.setSyutkkbn(C_SyutkKbn.SYU);
        siDetail6.setSyouhncd(P_SYOUHNCD);
        siDetail6.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siDetail6.setSyouhnsdno(P_SYOUHNSDNO);
        siDetail6.setKyksyouhnrenno(P_KYKSYOUHNRENNO);
        siDetail6.setKyuuhucd("200");
        siDetail6.setRenno(P_RENNO);

        JT_SkKihon skKihon4 = new JT_SkKihon(P_SKNO_02, P_SYONO_01);

        JT_Sk sk5 = skKihon4.createSk();
        sk5.setSeikyuurirekino(P_SEIKYUURIEKINO_1);

        JT_SkJiyuu skJiyuu6 = sk5.createSkJiyuu();
        skJiyuu6.setUketukeno(P_UKETUKENO_2);

        JT_SiDetail siDetail7 = skJiyuu6.createSiDetail();
        siDetail7.setSyutkkbn(C_SyutkKbn.SYU);
        siDetail7.setSyouhncd(P_SYOUHNCD);
        siDetail7.setKyhgndkatakbn(C_KyhgndkataKbn.TYPE60);
        siDetail7.setSyouhnsdno(P_SYOUHNSDNO);
        siDetail7.setKyksyouhnrenno(P_KYKSYOUHNRENNO);
        siDetail7.setKyuuhucd("100");
        siDetail7.setRenno(P_RENNO);

        siharaiDomManager.insert(skKihon1);
        siharaiDomManager.insert(skKihon2);
        siharaiDomManager.insert(skKihon3);
        siharaiDomManager.insert(skKihon4);

        JM_Kyuuhu kyuuhu1 = new JM_Kyuuhu("800");
        kyuuhu1.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBKYUUHUKIN);

        siharaiDomManager.insert(kyuuhu1);

        JM_Kyuuhu kyuuhu2 = new JM_Kyuuhu("700");
        kyuuhu2.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBKYUUHUKIN);

        siharaiDomManager.insert(kyuuhu2);

        JM_Kyuuhu kyuuhu3 = new JM_Kyuuhu("600");
        kyuuhu3.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBKYUUHUKIN);

        siharaiDomManager.insert(kyuuhu3);

        JM_Kyuuhu kyuuhu4 = new JM_Kyuuhu("500");
        kyuuhu4.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.KDHOKENKIN);

        siharaiDomManager.insert(kyuuhu4);

        JM_Kyuuhu kyuuhu5 = new JM_Kyuuhu("400");
        kyuuhu5.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);

        siharaiDomManager.insert(kyuuhu5);

        JM_Kyuuhu kyuuhu6 = new JM_Kyuuhu("300");
        kyuuhu6.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.SBHOKENKIN);

        siharaiDomManager.insert(kyuuhu6);

        JM_Kyuuhu kyuuhu7 = new JM_Kyuuhu("200");
        kyuuhu7.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);

        siharaiDomManager.insert(kyuuhu7);

        JM_Kyuuhu kyuuhu8 = new JM_Kyuuhu("100");
        kyuuhu8.setHokenkinsyuruikbn(C_HokenkinsyuruiKbn.BLNK);

        siharaiDomManager.insert(kyuuhu8);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllKyuuhu());
        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst = siharaiDomManager.getSiDetailInfosBySknoSyonoSeikyuurirekino(P_SKNO_01, P_SYONO_01, P_SEIKYUURIEKINO_2);

        Assert.assertEquals(0,siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst = siharaiDomManager.getSiDetailInfosBySknoSyonoSeikyuurirekino(P_SKNO_01, P_SYONO_02, P_SEIKYUURIEKINO_1);

        Assert.assertEquals(1,siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.size());

        Assert.assertEquals(P_SKNO_01, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSkno());
        Assert.assertEquals(P_SYONO_02, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSyono());
        Assert.assertEquals(P_SEIKYUURIEKINO_1, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_2, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getUketukeno());
        Assert.assertEquals(C_SyutkKbn.SYU, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getKyksyouhnrenno());
        Assert.assertEquals("400", siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getKyuuhucd());
        Assert.assertEquals(P_RENNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getRenno());
        Assert.assertEquals("400", siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getKyuuhucd());
        Assert.assertEquals(C_HokenkinsyuruiKbn.SBHOKENKIN, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getHokenkinsyuruikbn());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst = siharaiDomManager.getSiDetailInfosBySknoSyonoSeikyuurirekino(P_SKNO_01, P_SYONO_01, P_SEIKYUURIEKINO_1);

        Assert.assertEquals(3,siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.size());

        Assert.assertEquals(P_SKNO_01, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSkno());
        Assert.assertEquals(P_SYONO_01, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSyono());
        Assert.assertEquals(P_SEIKYUURIEKINO_1, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_1, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getUketukeno());
        Assert.assertEquals(C_SyutkKbn.SYU, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getKyksyouhnrenno());
        Assert.assertEquals("500", siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getKyuuhucd());
        Assert.assertEquals(P_RENNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getJT_SiDetail().getRenno());
        Assert.assertEquals("500", siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getKyuuhucd());
        Assert.assertEquals(C_HokenkinsyuruiKbn.KDHOKENKIN, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(0).getHokenkinsyuruikbn());

        Assert.assertEquals(P_SKNO_01, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getSkno());
        Assert.assertEquals(P_SYONO_01, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getSyono());
        Assert.assertEquals(P_SEIKYUURIEKINO_1, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_2, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getUketukeno());
        Assert.assertEquals(C_SyutkKbn.SYU, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getKyksyouhnrenno());
        Assert.assertEquals("600", siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getKyuuhucd());
        Assert.assertEquals(P_RENNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getJT_SiDetail().getRenno());
        Assert.assertEquals("600", siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getKyuuhucd());
        Assert.assertEquals(C_HokenkinsyuruiKbn.SBKYUUHUKIN, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(1).getHokenkinsyuruikbn());

        Assert.assertEquals(P_SKNO_01, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getSkno());
        Assert.assertEquals(P_SYONO_01, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getSyono());
        Assert.assertEquals(P_SEIKYUURIEKINO_1, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_2, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getUketukeno());
        Assert.assertEquals(C_SyutkKbn.SYU, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getSyouhncd());
        Assert.assertEquals(C_KyhgndkataKbn.TYPE60, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getKyhgndkatakbn());
        Assert.assertEquals(P_SYOUHNSDNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getKyksyouhnrenno());
        Assert.assertEquals("700", siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getKyuuhucd());
        Assert.assertEquals(P_RENNO, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getJT_SiDetail().getRenno());
        Assert.assertEquals("700", siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getKyuuhucd());
        Assert.assertEquals(C_HokenkinsyuruiKbn.SBKYUUHUKIN, siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.get(2).getHokenkinsyuruikbn());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst = siharaiDomManager.getSiDetailInfosBySknoSyonoSeikyuurirekino("", P_SYONO_01, P_SEIKYUURIEKINO_1);

        Assert.assertEquals(0,siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.size());
    }

    @Test
    @TestOrder(50)
    public void blank2() {

        List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst = siharaiDomManager.getSiDetailInfosBySknoSyonoSeikyuurirekino(P_SKNO_01, "", P_SEIKYUURIEKINO_1);

        Assert.assertEquals(0,siDetailInfosBySknoSyonoSeikyuurirekinoBeanLst.size());
    }
}



