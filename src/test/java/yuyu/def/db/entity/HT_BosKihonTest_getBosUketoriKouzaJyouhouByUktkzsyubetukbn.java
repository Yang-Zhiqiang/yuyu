package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 募集基本テーブルエンティティから、<br />
 * 受取口座種別区分を指定して<br />
 * 募集受取口座情報テーブルエンティティを取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_BosKihonTest_getBosUketoriKouzaJyouhouByUktkzsyubetukbn {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_BosKihon hT_BosKihon1 = new HT_BosKihon(P_MOSNO_01);

        Assert.assertNull(hT_BosKihon1.getBosUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN));

        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou1 = hT_BosKihon1.createBosUketoriKouzaJyouhou();
        hT_BosUketoriKouzaJyouhou1.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);

        sinkeiyakuDomManager.insert(hT_BosKihon1);

        HT_BosKihon hT_BosKihon2 = new HT_BosKihon(P_MOSNO_02);

        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou2 = hT_BosKihon2.createBosUketoriKouzaJyouhou();
        hT_BosUketoriKouzaJyouhou2.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);

        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou3 = hT_BosKihon2.createBosUketoriKouzaJyouhou();
        hT_BosUketoriKouzaJyouhou3.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.BLNK);

        sinkeiyakuDomManager.insert(hT_BosKihon2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBosKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon(P_MOSNO_01);

        Assert.assertNull(hT_BosKihon.getBosUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.BLNK));
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon(P_MOSNO_02);

        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou = hT_BosKihon.getBosUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);

        Assert.assertEquals(P_MOSNO_02, hT_BosUketoriKouzaJyouhou.getMosno());
        Assert.assertEquals(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN, hT_BosUketoriKouzaJyouhou.getUktkzsyubetukbn());
    }
}
