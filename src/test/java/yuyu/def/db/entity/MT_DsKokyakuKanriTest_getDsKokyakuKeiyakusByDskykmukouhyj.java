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

import yuyu.def.classification.C_MukouHyj;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳ顧客管理テーブルエンティティから、<br />
 * ＤＳ契約無効表示を指定して<br />
 * ＤＳ顧客契約テーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriTest_getDsKokyakuKeiyakusByDskykmukouhyj {

    @Inject
    private DirectDomManager directDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static String P_SYONO_04 = "11807111141";
    static String P_SYONO_05 = "11807111152";
    static String P_DSKOKNO_01 = "100001";
    static String P_DSKOKNO_02 = "100002";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri mT_DsKokyakuKanri1 = new MT_DsKokyakuKanri(P_DSKOKNO_01);

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = mT_DsKokyakuKanri1.getDsKokyakuKeiyakusByDskykmukouhyj(C_MukouHyj.BLANK);
        Assert.assertEquals(0, dsKokyakuKeiyakuLst.size());

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku1 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku1.setSyono(P_SYONO_01);
        mT_DsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(mT_DsKokyakuKanri1);

        MT_DsKokyakuKanri mT_DsKokyakuKanri2 = new MT_DsKokyakuKanri(P_DSKOKNO_02);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku2 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku2.setSyono(P_SYONO_02);
        mT_DsKokyakuKeiyaku2.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku3 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku3.setSyono(P_SYONO_03);
        mT_DsKokyakuKeiyaku3.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku4 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku4.setSyono(P_SYONO_04);
        mT_DsKokyakuKeiyaku4.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku5 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku5.setSyono(P_SYONO_05);
        mT_DsKokyakuKeiyaku5.setDskykmukouhyj(C_MukouHyj.MUKOU);

        directDomManager.insert(mT_DsKokyakuKanri2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri = directDomManager.getDsKokyakuKanri(P_DSKOKNO_01);
        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = mT_DsKokyakuKanri.getDsKokyakuKeiyakusByDskykmukouhyj(C_MukouHyj.MUKOU);

        Assert.assertEquals(0, dsKokyakuKeiyakuLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri = directDomManager.getDsKokyakuKanri(P_DSKOKNO_01);
        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = mT_DsKokyakuKanri.getDsKokyakuKeiyakusByDskykmukouhyj(C_MukouHyj.BLANK);

        Assert.assertEquals(1, dsKokyakuKeiyakuLst.size());

        Assert.assertEquals(P_DSKOKNO_01, dsKokyakuKeiyakuLst.get(0).getDskokno());
        Assert.assertEquals(P_SYONO_01, dsKokyakuKeiyakuLst.get(0).getSyono());
        Assert.assertEquals(C_MukouHyj.BLANK, dsKokyakuKeiyakuLst.get(0).getDskykmukouhyj());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        MT_DsKokyakuKanri mT_DsKokyakuKanri = directDomManager.getDsKokyakuKanri(P_DSKOKNO_02);
        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = mT_DsKokyakuKanri.getDsKokyakuKeiyakusByDskykmukouhyj(C_MukouHyj.BLANK);

        Assert.assertEquals(3, dsKokyakuKeiyakuLst.size());

        Assert.assertEquals(P_DSKOKNO_02, dsKokyakuKeiyakuLst.get(0).getDskokno());
        Assert.assertEquals(P_SYONO_02, dsKokyakuKeiyakuLst.get(0).getSyono());
        Assert.assertEquals(C_MukouHyj.BLANK, dsKokyakuKeiyakuLst.get(0).getDskykmukouhyj());

        Assert.assertEquals(P_DSKOKNO_02, dsKokyakuKeiyakuLst.get(1).getDskokno());
        Assert.assertEquals(P_SYONO_03, dsKokyakuKeiyakuLst.get(1).getSyono());
        Assert.assertEquals(C_MukouHyj.BLANK, dsKokyakuKeiyakuLst.get(1).getDskykmukouhyj());

        Assert.assertEquals(P_DSKOKNO_02, dsKokyakuKeiyakuLst.get(2).getDskokno());
        Assert.assertEquals(P_SYONO_04, dsKokyakuKeiyakuLst.get(2).getSyono());
        Assert.assertEquals(C_MukouHyj.BLANK, dsKokyakuKeiyakuLst.get(2).getDskykmukouhyj());
    }
}
