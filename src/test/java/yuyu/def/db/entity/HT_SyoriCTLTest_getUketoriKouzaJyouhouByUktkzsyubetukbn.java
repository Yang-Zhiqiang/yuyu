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
 * 処理コントロールテーブルエンティティから、<br />
 * 受取口座種別区分を指定して、<br />
 * 受取口座情報テーブルエンティティ取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HT_SyoriCTLTest_getUketoriKouzaJyouhouByUktkzsyubetukbn {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_001 = "791112220";
    static String P_MOSNO_002 = "791112238";

    @BeforeClass
    @Transactional
    public static void insertTestData() {


        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(P_MOSNO_001);


        Assert.assertEquals(null, hT_SyoriCTL1.getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN));

        HT_UketoriKouzaJyouhou hT_UketoriKouzaJyouhou1 = hT_SyoriCTL1.createUketoriKouzaJyouhou();
        hT_UketoriKouzaJyouhou1.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(P_MOSNO_002);

        HT_UketoriKouzaJyouhou hT_UketoriKouzaJyouhou2 = hT_SyoriCTL2.createUketoriKouzaJyouhou();
        hT_UketoriKouzaJyouhou2.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.BLNK);

        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {


        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        Assert.assertEquals(null, hT_SyoriCTL.getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.BLNK));
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_SyoriCTL hT_SyoriCTL = sinkeiyakuDomManager.getSyoriCTL(P_MOSNO_001);

        HT_UketoriKouzaJyouhou hT_UketoriKouzaJyouhou = hT_SyoriCTL
                .getUketoriKouzaJyouhouByUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);

        Assert.assertEquals(P_MOSNO_001, hT_UketoriKouzaJyouhou.getMosno());
        Assert.assertEquals(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN, hT_UketoriKouzaJyouhou.getUktkzsyubetukbn());

    }
}
