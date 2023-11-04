package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 支払保険金備金調査F作成<br />
 * 請求事由テーブルエンティティ取得(受付番号)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkTest_getSkJiyuuByUketukeno {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "11807111111";
    static String P_SYONO_01 = "11807111118";
    static Integer P_SEIKYUURIREKINO_1= new Integer(1);
    static Integer P_UKETUKENO_1= new Integer(1);
    static Integer P_UKETUKENO_2= new Integer(2);
    static Integer P_UKETUKENO_3= new Integer(3);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_Sk jT_Sk1 = jT_SkKihon.createSk();
        jT_Sk1.setSeikyuurirekino(P_SEIKYUURIREKINO_1);

        Assert.assertEquals(null, jT_Sk1.getSkJiyuuByUketukeno(P_UKETUKENO_1));

        JT_SkJiyuu jT_SkJiyuu1 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu1.setUketukeno(P_UKETUKENO_1);

        JT_SkJiyuu jT_SkJiyuu2 = jT_Sk1.createSkJiyuu();
        jT_SkJiyuu2.setUketukeno(P_UKETUKENO_2);

        siharaiDomManager.insert(jT_SkKihon);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_01, P_SYONO_01);

        JT_Sk jT_Sk = jT_SkKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_1);

        Assert.assertEquals(null, jT_Sk.getSkJiyuuByUketukeno(P_UKETUKENO_3));
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_01, P_SYONO_01);

        JT_Sk jT_Sk = jT_SkKihon.getSkBySeikyuurirekino(P_SEIKYUURIREKINO_1);

        JT_SkJiyuu jT_SkJiyuu = jT_Sk.getSkJiyuuByUketukeno(P_UKETUKENO_1);

        Assert.assertEquals(P_SKNO_01, jT_SkJiyuu.getSkno());
        Assert.assertEquals(P_SYONO_01, jT_SkJiyuu.getSyono());
        Assert.assertEquals(P_SEIKYUURIREKINO_1, jT_SkJiyuu.getSeikyuurirekino());
        Assert.assertEquals(P_UKETUKENO_1, jT_SkJiyuu.getUketukeno());
    }
}
