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
 * ＤＳ顧客契約テーブルエンティティから、<br />
 * 証券番号を指定して<br />
 * ＤＳ顧客契約テーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriTest_getDsKokyakuKeiyakusBySyonoDskykmukouhyj {

    @Inject
    private DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        if (dsKokyakuKanri1 == null) {
            dsKokyakuKanri1 = new MT_DsKokyakuKanri("100001");

            List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri1.getDsKokyakuKeiyakusBySyonoDskykmukouhyj("11807111118");
            Assert.assertEquals(0, dsKokyakuKeiyakuList.size());

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
            dsKokyakuKeiyaku1.setSyono("11807111118");
            dsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.BLANK);

            MT_DsKokyakuKeiyaku dsKokyakuKeiyaku3 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
            dsKokyakuKeiyaku3.setSyono("11807111129");
            dsKokyakuKeiyaku3.setDskykmukouhyj(C_MukouHyj.BLANK);

            directDomManager.insert(dsKokyakuKanri1);
        }

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("100002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri2.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setSyono("11807111118");
        dsKokyakuKeiyaku2.setDskykmukouhyj(C_MukouHyj.MUKOU);

        directDomManager.insert(dsKokyakuKanri2);
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

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri1.getDsKokyakuKeiyakusBySyonoDskykmukouhyj("11807111141");

        Assert.assertEquals(0, dsKokyakuKeiyakuList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri1.getDsKokyakuKeiyakusBySyonoDskykmukouhyj("11807111118");

        Assert.assertEquals(1, dsKokyakuKeiyakuList.size());

        Assert.assertEquals("11807111118", dsKokyakuKeiyakuList.get(0).getSyono());
        Assert.assertEquals("100001", dsKokyakuKeiyakuList.get(0).getDskokno());
        Assert.assertEquals(C_MukouHyj.BLANK, dsKokyakuKeiyakuList.get(0).getDskykmukouhyj());
    }

    @Test
    @TestOrder(30)
    public void blank1() {

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = dsKokyakuKanri1.getDsKokyakuKeiyakusBySyonoDskykmukouhyj("");

        Assert.assertEquals(0, dsKokyakuKeiyakuList.size());
    }

}
