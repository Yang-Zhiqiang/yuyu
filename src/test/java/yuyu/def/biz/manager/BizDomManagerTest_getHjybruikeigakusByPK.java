package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.db.entity.BT_Hjybruikeigaku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 補助簿リスト作成<br />
 * 補助簿累計額テーブルエンティティ取得(補助簿統括担当室コード、勘定科目コード、伝票年月)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getHjybruikeigakusByPK {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<BT_Hjybruikeigaku> hjybruikeigakuLst =
            bizDomManager.getHjybruikeigakusByPK("100", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201701));

        Assert.assertEquals(0, hjybruikeigakuLst.size());

        BT_Hjybruikeigaku hjybruikeigaku1 = new BT_Hjybruikeigaku("100", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201701));

        bizDomManager.insert(hjybruikeigaku1);

        BT_Hjybruikeigaku hjybruikeigaku2 = new BT_Hjybruikeigaku("100", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201702));

        bizDomManager.insert(hjybruikeigaku2);

        BT_Hjybruikeigaku hjybruikeigaku3 = new BT_Hjybruikeigaku("100", C_Kanjyoukmkcd.HOKENKEIYAKU_KOBETU_GAIHO_JPY, BizDateYM.valueOf(201701));

        bizDomManager.insert(hjybruikeigaku3);

        BT_Hjybruikeigaku hjybruikeigaku4 = new BT_Hjybruikeigaku("200", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201701));

        bizDomManager.insert(hjybruikeigaku4);

        BT_Hjybruikeigaku hjybruikeigaku5 = new BT_Hjybruikeigaku("400", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201701));

        bizDomManager.insert(hjybruikeigaku5);

        BT_Hjybruikeigaku hjybruikeigaku6 = new BT_Hjybruikeigaku("400", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201702));

        bizDomManager.insert(hjybruikeigaku6);

        BT_Hjybruikeigaku hjybruikeigaku7 = new BT_Hjybruikeigaku("400", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201703));

        bizDomManager.insert(hjybruikeigaku7);
    }

    @AfterClass
    @Transactional
    public  static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllHjybruikeigaku());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BT_Hjybruikeigaku> hjybruikeigakuLst =
            bizDomManager.getHjybruikeigakusByPK("300", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201701));

        Assert.assertEquals(0, hjybruikeigakuLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<BT_Hjybruikeigaku> hjybruikeigakuLst =
            bizDomManager.getHjybruikeigakusByPK("100", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201701));

        Assert.assertEquals(1, hjybruikeigakuLst.size());

        Assert.assertEquals("100", hjybruikeigakuLst.get(0).getHjybtantositucd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, hjybruikeigakuLst.get(0).getKanjyoukmkcd());
        Assert.assertEquals(BizDateYM.valueOf(201701), hjybruikeigakuLst.get(0).getDenym());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<BT_Hjybruikeigaku> hjybruikeigakuLst =
            bizDomManager.getHjybruikeigakusByPK("400", C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, BizDateYM.valueOf(201703));

        Assert.assertEquals(3, hjybruikeigakuLst.size());

        Assert.assertEquals("400", hjybruikeigakuLst.get(0).getHjybtantositucd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, hjybruikeigakuLst.get(0).getKanjyoukmkcd());
        Assert.assertEquals(BizDateYM.valueOf(201703), hjybruikeigakuLst.get(0).getDenym());

        Assert.assertEquals("400", hjybruikeigakuLst.get(1).getHjybtantositucd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, hjybruikeigakuLst.get(1).getKanjyoukmkcd());
        Assert.assertEquals(BizDateYM.valueOf(201702), hjybruikeigakuLst.get(1).getDenym());

        Assert.assertEquals("400", hjybruikeigakuLst.get(2).getHjybtantositucd());
        Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, hjybruikeigakuLst.get(2).getKanjyoukmkcd());
        Assert.assertEquals(BizDateYM.valueOf(201701), hjybruikeigakuLst.get(2).getDenym());
    }
}
