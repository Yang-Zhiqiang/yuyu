package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 請求基本テーブルエンティティから、<br />
 * 取消フラグを指定して<br />
 * 死亡仮受付テーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class JT_SkKihonTest_getSibouKariuketsukesByTorikesiflg {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SKNO_001 = "SK01";
    static String P_SKNO_002 = "SK02";
    static String P_SYONO_001 = "11807111118";
    static String P_SYONO_002 = "11807111129";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(P_SKNO_001, P_SYONO_001);

        List<JT_SibouKariuketsuke> sibouKariuketsukeLst = jT_SkKihon1.getSibouKariuketsukesByTorikesiflg(C_UmuKbn.NONE);
        Assert.assertEquals(0, sibouKariuketsukeLst.size());

        JT_SibouKariuketsuke jT_SibouKariuketsuke1 = jT_SkKihon1.createSibouKariuketsuke();
        jT_SibouKariuketsuke1.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(jT_SkKihon1);

        JT_SkKihon jT_SkKihon2 = new JT_SkKihon(P_SKNO_002, P_SYONO_002);

        JT_SibouKariuketsuke jT_SibouKariuketsuke2 = jT_SkKihon2.createSibouKariuketsuke();
        jT_SibouKariuketsuke2.setTorikesiflg(C_UmuKbn.ARI);

        siharaiDomManager.insert(jT_SkKihon2);
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

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_002, P_SYONO_002);
        List<JT_SibouKariuketsuke> sibouKariuketsukeLst = jT_SkKihon.getSibouKariuketsukesByTorikesiflg(C_UmuKbn.NONE);

        Assert.assertEquals(0, sibouKariuketsukeLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        JT_SkKihon jT_SkKihon = siharaiDomManager.getSkKihon(P_SKNO_001, P_SYONO_001);
        List<JT_SibouKariuketsuke> sibouKariuketsukeLst = jT_SkKihon.getSibouKariuketsukesByTorikesiflg(C_UmuKbn.NONE);

        Assert.assertEquals(1, sibouKariuketsukeLst.size());

        Assert.assertEquals(P_SKNO_001, sibouKariuketsukeLst.get(0).getSkno());
        Assert.assertEquals(P_SYONO_001, sibouKariuketsukeLst.get(0).getSyono());
        Assert.assertEquals(C_UmuKbn.NONE, sibouKariuketsukeLst.get(0).getTorikesiflg());
    }
}
