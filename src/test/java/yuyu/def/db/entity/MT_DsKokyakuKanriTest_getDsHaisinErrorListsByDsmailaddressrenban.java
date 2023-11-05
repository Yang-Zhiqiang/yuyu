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
 * ＤＳ顧客管理テーブルエンティティから、<br />
 * ＤＳメールアドレス連番を指定して<br />
 * ＤＳ配信エラーリストテーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class MT_DsKokyakuKanriTest_getDsHaisinErrorListsByDsmailaddressrenban {

    @Inject
    private DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        if (dsKokyakuKanri1 == null) {
            dsKokyakuKanri1 = new MT_DsKokyakuKanri("100001");

            List<MT_DsHaisinErrorList> dsHaisinErrorListLst = dsKokyakuKanri1.getDsHaisinErrorListsByDsmailaddressrenban(2001);
            Assert.assertEquals(0, dsHaisinErrorListLst.size());

            MT_DsHaisinErrorList dsHaisinErrorList1 = dsKokyakuKanri1.createDsHaisinErrorList();
            dsHaisinErrorList1.setDsdatasakuseiymd(BizDate.valueOf(20161015));
            dsHaisinErrorList1.setDsmailaddressrenban(2001);

            MT_DsHaisinErrorList dsHaisinErrorList2 = dsKokyakuKanri1.createDsHaisinErrorList();
            dsHaisinErrorList2.setDsdatasakuseiymd(BizDate.valueOf(20161015));
            dsHaisinErrorList2.setDsmailaddressrenban(1002);

            MT_DsHaisinErrorList dsHaisinErrorList3 = dsKokyakuKanri1.createDsHaisinErrorList();
            dsHaisinErrorList3.setDsdatasakuseiymd(BizDate.valueOf(20161017));
            dsHaisinErrorList3.setDsmailaddressrenban(2002);

            MT_DsHaisinErrorList dsHaisinErrorList4 = dsKokyakuKanri1.createDsHaisinErrorList();
            dsHaisinErrorList4.setDsdatasakuseiymd(BizDate.valueOf(20161018));
            dsHaisinErrorList4.setDsmailaddressrenban(2002);

            MT_DsHaisinErrorList dsHaisinErrorList5 = dsKokyakuKanri1.createDsHaisinErrorList();
            dsHaisinErrorList5.setDsdatasakuseiymd(BizDate.valueOf(20161019));
            dsHaisinErrorList5.setDsmailaddressrenban(2002);

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
        List<MT_DsHaisinErrorList> dsHaisinErrorListLst = dsKokyakuKanri1.getDsHaisinErrorListsByDsmailaddressrenban(2222);

        Assert.assertEquals(0, dsHaisinErrorListLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        List<MT_DsHaisinErrorList> dsHaisinErrorListLst = dsKokyakuKanri1.getDsHaisinErrorListsByDsmailaddressrenban(2001);

        Assert.assertEquals(1, dsHaisinErrorListLst.size());

        Assert.assertEquals(BizDate.valueOf(20161015), dsHaisinErrorListLst.get(0).getDsdatasakuseiymd());
        Assert.assertEquals("100001", dsHaisinErrorListLst.get(0).getDskokno());
        Assert.assertEquals(2001, dsHaisinErrorListLst.get(0).getDsmailaddressrenban().intValue());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        MT_DsKokyakuKanri dsKokyakuKanri1 = directDomManager.getDsKokyakuKanri("100001");
        List<MT_DsHaisinErrorList> dsHaisinErrorListLst = dsKokyakuKanri1.getDsHaisinErrorListsByDsmailaddressrenban(2002);

        Assert.assertEquals(3, dsHaisinErrorListLst.size());

        Assert.assertEquals(BizDate.valueOf(20161017), dsHaisinErrorListLst.get(0).getDsdatasakuseiymd());
        Assert.assertEquals("100001", dsHaisinErrorListLst.get(0).getDskokno());
        Assert.assertEquals(2002, dsHaisinErrorListLst.get(0).getDsmailaddressrenban().intValue());

        Assert.assertEquals(BizDate.valueOf(20161018), dsHaisinErrorListLst.get(1).getDsdatasakuseiymd());
        Assert.assertEquals("100001", dsHaisinErrorListLst.get(1).getDskokno());
        Assert.assertEquals(2002, dsHaisinErrorListLst.get(1).getDsmailaddressrenban().intValue());

        Assert.assertEquals(BizDate.valueOf(20161019), dsHaisinErrorListLst.get(2).getDsdatasakuseiymd());
        Assert.assertEquals("100001", dsHaisinErrorListLst.get(2).getDskokno());
        Assert.assertEquals(2002, dsHaisinErrorListLst.get(2).getDsmailaddressrenban().intValue());
    }
}
