package yuyu.batch.suuri.srkessan.srskkessandataretentionperiod;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SrSkKessanDataRetentionPeriodDaoクラスの、<br />
 * deleteSkOikmTyouseiDenpyou() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SrSkKessanDataRetentionPeriodDaoTest_deleteSkOikmTyouseiDenpyou {
    @Inject
    private SrSkKessanDataRetentionPeriodDao srSkKessanDataRetentionPeriodDao;
    @Inject
    private SuuriDomManager suuriDomManager;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou1 = new ST_SkOikmTyouseiDenpyou("791112220",
            C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_AUD, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.BLNK);

        em.persist(skOikmTyouseiDenpyou1);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou2 = new ST_SkOikmTyouseiDenpyou("791112238",
            C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_JPY, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);

        em.persist(skOikmTyouseiDenpyou2);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou3 = new ST_SkOikmTyouseiDenpyou("791112246",
            C_Kanjyoukmkcd.HOKEN_KOBETUP_GAIHO_USD, C_TaisyakuKbn.BLNK, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        em.persist(skOikmTyouseiDenpyou3);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou4 = new ST_SkOikmTyouseiDenpyou("791112253",
            C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_AUD, C_TaisyakuKbn.KARIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        em.persist(skOikmTyouseiDenpyou4);

        ST_SkOikmTyouseiDenpyou skOikmTyouseiDenpyou5 = new ST_SkOikmTyouseiDenpyou("791112261",
            C_Kanjyoukmkcd.HOKENKEIYAKU_DAI1KAI_GAIHO_JPY, C_TaisyakuKbn.KASIKATA, C_NaibuKeiyakuKbn.BLNK, C_TekiyouKbn.BLNK, C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);

        em.persist(skOikmTyouseiDenpyou5);

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void Test_001() {
        srSkKessanDataRetentionPeriodDao.deleteSkOikmTyouseiDenpyou();
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void Test_002() {
        assertEquals(0, suuriDomManager.getAllSkOikmTyouseiDenpyou().size());
    }

}
