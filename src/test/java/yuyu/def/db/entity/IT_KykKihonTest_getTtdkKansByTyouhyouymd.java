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

import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;


/**
 * 手続完了テーブル、<br />
 * 帳票作成日、<br />
 * 手続完了テーブルエンティティリストを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getTtdkKansByTyouhyouymd {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        List<IT_KykKihon> kykKihonList = hozenDomManager.getAllKykKihon();
        if (kykKihonList.size() == 0) {
            IT_KykKihon kykKihon1= new IT_KykKihon("01","11807111118");

            List<IT_TtdkKan> ttdkKanLst = kykKihon1.getTtdkKansByTyouhyouymd(BizDate.valueOf(20161109));
            Assert.assertEquals(0, ttdkKanLst.size());

            IT_TtdkKan ttdkKan1 = kykKihon1.createTtdkKan();
            ttdkKan1.setHenkousikibetukey("11");
            ttdkKan1.setTyouhyouymd(BizDate.valueOf(20161109));

            IT_TtdkKan ttdkKan2 = kykKihon1.createTtdkKan();
            ttdkKan2.setHenkousikibetukey("12");
            ttdkKan2.setTyouhyouymd(BizDate.valueOf(20161111));

            IT_TtdkKan ttdkKan3 = kykKihon1.createTtdkKan();
            ttdkKan3.setHenkousikibetukey("13");
            ttdkKan3.setTyouhyouymd(BizDate.valueOf(20161110));

            IT_TtdkKan ttdkKan4 = kykKihon1.createTtdkKan();
            ttdkKan4.setHenkousikibetukey("14");
            ttdkKan4.setTyouhyouymd(BizDate.valueOf(20161110));

            IT_TtdkKan ttdkKan5 = kykKihon1.createTtdkKan();
            ttdkKan5.setHenkousikibetukey("15");
            ttdkKan5.setTyouhyouymd(BizDate.valueOf(20161110));

            hozenDomManager.insert(kykKihon1);


        }
    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_TtdkKan> ttdkKanLst = kykKihon.getTtdkKansByTyouhyouymd(BizDate.valueOf(20161101));

        Assert.assertEquals(0, ttdkKanLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_TtdkKan> ttdkKanLst = kykKihon.getTtdkKansByTyouhyouymd(BizDate.valueOf(20161109));

        Assert.assertEquals(1, ttdkKanLst.size());

        Assert.assertEquals("01", ttdkKanLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", ttdkKanLst.get(0).getSyono());
        Assert.assertEquals("11", ttdkKanLst.get(0).getHenkousikibetukey());
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_TtdkKan> ttdkKanLst = kykKihon.getTtdkKansByTyouhyouymd(BizDate.valueOf(20161110));

        Assert.assertEquals(3, ttdkKanLst.size());

        Assert.assertEquals("01", ttdkKanLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", ttdkKanLst.get(0).getSyono());
        Assert.assertEquals("13", ttdkKanLst.get(0).getHenkousikibetukey());

        Assert.assertEquals("01", ttdkKanLst.get(1).getKbnkey());
        Assert.assertEquals("11807111118", ttdkKanLst.get(1).getSyono());
        Assert.assertEquals("14", ttdkKanLst.get(1).getHenkousikibetukey());

        Assert.assertEquals("01", ttdkKanLst.get(2).getKbnkey());
        Assert.assertEquals("11807111118", ttdkKanLst.get(2).getSyono());
        Assert.assertEquals("15", ttdkKanLst.get(2).getHenkousikibetukey());

    }
}
