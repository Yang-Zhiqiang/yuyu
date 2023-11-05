package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

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

import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JT_SibouKariuketsuke;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 保険金給付金備金情報抽出<br />
 * 請求基本テーブルエンティティリスト取得　証券番号かつ取消フラグのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsBySyonoTorikesiflg {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    static String P_SKNO_001 = "B001";
    static String P_SKNO_002 = "B002";
    static String P_SKNO_003 = "B003";
    static String P_SKNO_004 = "B004";
    static String P_SKNO_005 = "B005";
    static String P_SYONO_001 = "11807111118";
    static String P_SYONO_002 = "11807111129";
    static String P_SYONO_003 = "11807111130";
    static String P_SYONO_004 = "11807111141";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoTorikesiflg(P_SYONO_001, C_UmuKbn.ARI);

        Assert.assertEquals(0, skKihonLst.size());

        JT_SkKihon skKihon1 = new JT_SkKihon(P_SKNO_001, P_SYONO_001);

        JT_SibouKariuketsuke sibouKariuketsuke1 = skKihon1.createSibouKariuketsuke();
        sibouKariuketsuke1.setTorikesiflg(C_UmuKbn.ARI);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon(P_SKNO_002, P_SYONO_002);

        JT_SibouKariuketsuke sibouKariuketsuke2 = skKihon2.createSibouKariuketsuke();
        sibouKariuketsuke2.setTorikesiflg(C_UmuKbn.ARI);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon(P_SKNO_003, P_SYONO_002);

        JT_SibouKariuketsuke sibouKariuketsuke3 = skKihon3.createSibouKariuketsuke();
        sibouKariuketsuke3.setTorikesiflg(C_UmuKbn.ARI);

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon(P_SKNO_004, P_SYONO_002);

        JT_SibouKariuketsuke sibouKariuketsuke4 = skKihon4.createSibouKariuketsuke();
        sibouKariuketsuke4.setTorikesiflg(C_UmuKbn.ARI);

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon(P_SKNO_004, P_SYONO_003);

        JT_SibouKariuketsuke sibouKariuketsuke5 = skKihon5.createSibouKariuketsuke();
        sibouKariuketsuke5.setTorikesiflg(C_UmuKbn.ARI);

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon(P_SKNO_005, P_SYONO_002);

        JT_SibouKariuketsuke sibouKariuketsuke6 = skKihon6.createSibouKariuketsuke();
        sibouKariuketsuke6.setTorikesiflg(C_UmuKbn.NONE);

        siharaiDomManager.insert(skKihon6);
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

        assertEquals(0, siharaiDomManager.getSkKihonsBySyonoTorikesiflg(P_SYONO_004, C_UmuKbn.ARI).size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoTorikesiflg(P_SYONO_001, C_UmuKbn.ARI);

        Assert.assertEquals(P_SKNO_001, skKihonLst.get(0).getSkno());
        Assert.assertEquals(P_SYONO_001, skKihonLst.get(0).getSyono());
        Assert.assertEquals(C_UmuKbn.ARI, skKihonLst.get(0).getSibouKariuketsuke().getTorikesiflg());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($(P_SKNO_002,P_SYONO_002,C_UmuKbn.ARI), "1");
        datamap.put($(P_SKNO_003,P_SYONO_002,C_UmuKbn.ARI), "1");
        datamap.put($(P_SKNO_004,P_SYONO_002,C_UmuKbn.ARI), "1");

        List<JT_SkKihon> skKihonLst = siharaiDomManager.getSkKihonsBySyonoTorikesiflg(P_SYONO_002, C_UmuKbn.ARI);

        for(JT_SkKihon skKihon:skKihonLst){
            datamap.remove($(
                skKihon.getSkno(),
                skKihon.getSyono(),
                skKihon.getSibouKariuketsuke().getTorikesiflg()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        Assert.assertEquals(0, siharaiDomManager.getSkKihonsBySyonoTorikesiflg("", C_UmuKbn.ARI).size());
    }
}
