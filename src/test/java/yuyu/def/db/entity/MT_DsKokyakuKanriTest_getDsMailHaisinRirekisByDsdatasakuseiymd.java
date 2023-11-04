package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.direct.manager.DirectDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＤＳメール配信履歴テーブルエンティティから、<br />
 * ＤＳデータ作成日を指定して<br />
 * ＤＳ配信エラーリストテーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriTest_getDsMailHaisinRirekisByDsdatasakuseiymd {

    @Inject
    private DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        if (dsKokyakuKanri1 == null) {
            dsKokyakuKanri1 = new MT_DsKokyakuKanri("100001");

            List<MT_DsMailHaisinRireki> dsHaisinErrorListLst = dsKokyakuKanri1.getDsMailHaisinRirekisByDsdatasakuseiymd(BizDate.valueOf(20161015));
            Assert.assertEquals(0, dsHaisinErrorListLst.size());

            MT_DsMailHaisinRireki dsMailHaisinRireki1 = dsKokyakuKanri1.createDsMailHaisinRireki();
            dsMailHaisinRireki1.setDsdatasakuseiymd(BizDate.valueOf(20161015));
            dsMailHaisinRireki1.setDsmailhaisinrenban(2001);

            MT_DsMailHaisinRireki dsMailHaisinRireki2 = dsKokyakuKanri1.createDsMailHaisinRireki();
            dsMailHaisinRireki2.setDsdatasakuseiymd(BizDate.valueOf(20161016));
            dsMailHaisinRireki2.setDsmailhaisinrenban(2001);

            MT_DsMailHaisinRireki dsMailHaisinRireki3 = dsKokyakuKanri1.createDsMailHaisinRireki();
            dsMailHaisinRireki3.setDsdatasakuseiymd(BizDate.valueOf(20161017));
            dsMailHaisinRireki3.setDsmailhaisinrenban(2002);

            MT_DsMailHaisinRireki dsMailHaisinRireki4 = dsKokyakuKanri1.createDsMailHaisinRireki();
            dsMailHaisinRireki4.setDsdatasakuseiymd(BizDate.valueOf(20161017));
            dsMailHaisinRireki4.setDsmailhaisinrenban(2003);

            MT_DsMailHaisinRireki dsMailHaisinRireki5 = dsKokyakuKanri1.createDsMailHaisinRireki();
            dsMailHaisinRireki5.setDsdatasakuseiymd(BizDate.valueOf(20161017));
            dsMailHaisinRireki5.setDsmailhaisinrenban(2004);

            directDomManager.insert(dsKokyakuKanri1);

        }
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
        List<MT_DsMailHaisinRireki> dsMailHaisinRirekiLst = dsKokyakuKanri1.getDsMailHaisinRirekisByDsdatasakuseiymd(BizDate.valueOf(20161020));

        Assert.assertEquals(0, dsMailHaisinRirekiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        List<MT_DsMailHaisinRireki> dsMailHaisinRirekiLst = dsKokyakuKanri1.getDsMailHaisinRirekisByDsdatasakuseiymd(BizDate.valueOf(20161015));

        Assert.assertEquals(1, dsMailHaisinRirekiLst.size());

        Assert.assertEquals(BizDate.valueOf(20161015), dsMailHaisinRirekiLst.get(0).getDsdatasakuseiymd());
        Assert.assertEquals("100001", dsMailHaisinRirekiLst.get(0).getDskokno());
        Assert.assertEquals(2001, dsMailHaisinRirekiLst.get(0).getDsmailhaisinrenban().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        List<MT_DsMailHaisinRireki> dsMailHaisinRirekiLst = dsKokyakuKanri1.getDsMailHaisinRirekisByDsdatasakuseiymd(BizDate.valueOf(20161017));

        Assert.assertEquals(3, dsMailHaisinRirekiLst.size());

        Assert.assertEquals(BizDate.valueOf(20161017), dsMailHaisinRirekiLst.get(0).getDsdatasakuseiymd());
        Assert.assertEquals("100001", dsMailHaisinRirekiLst.get(0).getDskokno());
        Assert.assertEquals(2002, dsMailHaisinRirekiLst.get(0).getDsmailhaisinrenban().intValue());

        Assert.assertEquals(BizDate.valueOf(20161017), dsMailHaisinRirekiLst.get(1).getDsdatasakuseiymd());
        Assert.assertEquals("100001", dsMailHaisinRirekiLst.get(1).getDskokno());
        Assert.assertEquals(2003, dsMailHaisinRirekiLst.get(1).getDsmailhaisinrenban().intValue());

        Assert.assertEquals(BizDate.valueOf(20161017), dsMailHaisinRirekiLst.get(2).getDsdatasakuseiymd());
        Assert.assertEquals("100001", dsMailHaisinRirekiLst.get(2).getDskokno());
        Assert.assertEquals(2004, dsMailHaisinRirekiLst.get(2).getDsmailhaisinrenban().intValue());
    }
}
