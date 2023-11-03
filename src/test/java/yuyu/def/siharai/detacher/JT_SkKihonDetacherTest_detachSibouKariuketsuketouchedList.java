package yuyu.def.siharai.detacher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金備金情報抽出<br />
 * デタッチ取得[死亡仮受付テーブル](請求基本テーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonDetacherTest_detachSibouKariuketsuketouchedList {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKON_01 = "SKNO1";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon skKihon1 = new JT_SkKihon(P_SKON_01, P_SYONO_01);

        skKihon1.createSibouKariuketsuke();

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon(P_SKON_01, P_SYONO_02);

        skKihon2.createSibouKariuketsuke();

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon(P_SKON_01, P_SYONO_03);

        skKihon3.createSibouKariuketsuke();

        siharaiDomManager.insert(skKihon3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<JT_SkKihon> jT_SkKihons = siharaiDomManager.getAllSkKihon();

        List<JT_SkKihon> entityList = JT_SkKihonDetacher.detachSibouKariuketsuketouched(jT_SkKihons);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(JT_SkKihon entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }

        Assert.assertEquals(3, entityList.size());

        Assert.assertEquals(P_SKON_01, entityList.get(0).getSibouKariuketsuke().getSkno());
        Assert.assertEquals(P_SYONO_01, entityList.get(0).getSibouKariuketsuke().getSyono());
        Assert.assertEquals(P_SKON_01, entityList.get(1).getSibouKariuketsuke().getSkno());
        Assert.assertEquals(P_SYONO_02, entityList.get(1).getSibouKariuketsuke().getSyono());
        Assert.assertEquals(P_SKON_01, entityList.get(2).getSibouKariuketsuke().getSkno());
        Assert.assertEquals(P_SYONO_03, entityList.get(2).getSibouKariuketsuke().getSyono());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<JT_SkKihon> jT_SkKihons = new ArrayList<>();

        jT_SkKihons.add(null);
        jT_SkKihons.add(null);

        List<JT_SkKihon> entityList = JT_SkKihonDetacher.detachSibouKariuketsuketouched(jT_SkKihons);

        for(JT_SkKihon entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
