package yuyu.def.siharai.manager;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * 確認登録リスト出力<br />
 * 最大手続履歴識別キーを持つ手続履歴テーブルエンティティリスト（大量）取得（処理年月日、更新処理詳細コード）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "SK000000001";
    static String P_SKNO_02 = "SK000000002";
    static String P_SKNO_03 = "SK000000003";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static String P_SYONO_04 = "11807111141";
    static String P_TTDKRRKSKBTKEY_01 = "TK000000001";
    static String P_TTDKRRKSKBTKEY_02 = "TK000000002";
    static String P_TTDKRRKSKBTKEY_03 = "TK000000003";
    static BizDate P_SYORIYMD_01 = BizDate.valueOf(20160303);
    static BizDate P_SYORIYMD_02 = BizDate.valueOf(20160313);
    static BizDate P_SYORIYMD_03 = BizDate.valueOf(20160323);
    static String P_SATEISYOUNINSKBTKEY_01 = "SKEY0000001";
    static String P_SATEISYOUNINSKBTKEY_02 = "SKEY0000002";
    static String P_SATEISYOUNINSKBTKEY_03 = "SKEY0000003";
    static String P_KOSSYORISSCD_01 = "CD000000001";
    static String P_KOSSYORISSCD_02 = "CD000000002";
    static String P_KOSSYORISSCD_03 = "CD000000003";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_TtdkRireki> exDBRes_JT_TtdkRireki =
                siharaiDomManager.getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(P_SYORIYMD_01,
                        P_KOSSYORISSCD_01)) {

            Assert.assertFalse(exDBRes_JT_TtdkRireki.iterator().hasNext());
        }

        JT_SkKihon jT_SkKihon1 = new JT_SkKihon(P_SKNO_01, P_SYONO_02);

        JT_TtdkRireki jT_TtdkRireki1 = jT_SkKihon1.createTtdkRireki();
        jT_TtdkRireki1.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_02);
        jT_TtdkRireki1.setSyoriYmd(P_SYORIYMD_01);
        jT_TtdkRireki1.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        jT_TtdkRireki1.setKossyorisscd(P_KOSSYORISSCD_01);

        JT_SateiSyouninRireki jT_SateiSyouninRireki1 = jT_SkKihon1.createSateiSyouninRireki();
        jT_SateiSyouninRireki1.setSyorikekkakbn(C_SyorikekkaKbn.TYUUKANKAKUNIN);
        jT_SateiSyouninRireki1.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        siharaiDomManager.insert(jT_SkKihon1);

        JT_SkKihon jT_SkKihon2 = new JT_SkKihon(P_SKNO_02, P_SYONO_01);

        JT_TtdkRireki jT_TtdkRireki2 = jT_SkKihon2.createTtdkRireki();
        jT_TtdkRireki2.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_01);
        jT_TtdkRireki2.setSyoriYmd(P_SYORIYMD_02);
        jT_TtdkRireki2.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        jT_TtdkRireki2.setKossyorisscd(P_KOSSYORISSCD_02);

        JT_SateiSyouninRireki jT_SateiSyouninRireki2 = jT_SkKihon2.createSateiSyouninRireki();
        jT_SateiSyouninRireki2.setSyorikekkakbn(C_SyorikekkaKbn.TUIKAKAKUNIN);
        jT_SateiSyouninRireki2.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        siharaiDomManager.insert(jT_SkKihon2);

        JT_SkKihon jT_SkKihon3 = new JT_SkKihon(P_SKNO_01, P_SYONO_03);

        JT_TtdkRireki jT_TtdkRireki3 = jT_SkKihon3.createTtdkRireki();
        jT_TtdkRireki3.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_02);
        jT_TtdkRireki3.setSyoriYmd(P_SYORIYMD_02);
        jT_TtdkRireki3.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        jT_TtdkRireki3.setKossyorisscd(P_KOSSYORISSCD_02);

        JT_SateiSyouninRireki jT_SateiSyouninRireki3 = jT_SkKihon3.createSateiSyouninRireki();
        jT_SateiSyouninRireki3.setSyorikekkakbn(C_SyorikekkaKbn.TYUUKANKAKUNIN);
        jT_SateiSyouninRireki3.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        siharaiDomManager.insert(jT_SkKihon3);

        JT_SkKihon jT_SkKihon4 = new JT_SkKihon(P_SKNO_01, P_SYONO_01);

        JT_TtdkRireki jT_TtdkRireki4 = jT_SkKihon4.createTtdkRireki();
        jT_TtdkRireki4.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_02);
        jT_TtdkRireki4.setSyoriYmd(P_SYORIYMD_02);
        jT_TtdkRireki4.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        jT_TtdkRireki4.setKossyorisscd(P_KOSSYORISSCD_02);

        JT_TtdkRireki jT_TtdkRireki5 = jT_SkKihon4.createTtdkRireki();
        jT_TtdkRireki5.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_03);
        jT_TtdkRireki5.setSyoriYmd(P_SYORIYMD_02);
        jT_TtdkRireki5.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        jT_TtdkRireki5.setKossyorisscd(P_KOSSYORISSCD_02);

        JT_SateiSyouninRireki jT_SateiSyouninRireki4 = jT_SkKihon4.createSateiSyouninRireki();
        jT_SateiSyouninRireki4.setSyorikekkakbn(C_SyorikekkaKbn.KAKUNIN);
        jT_SateiSyouninRireki4.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);

        JT_SateiSyouninRireki jT_SateiSyouninRireki5 = jT_SkKihon4.createSateiSyouninRireki();
        jT_SateiSyouninRireki5.setSyorikekkakbn(C_SyorikekkaKbn.KAKUNIN);
        jT_SateiSyouninRireki5.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_02);
        siharaiDomManager.insert(jT_SkKihon4);

        JT_SkKihon jT_SkKihon5 = new JT_SkKihon(P_SKNO_02, P_SYONO_02);

        JT_TtdkRireki jT_TtdkRireki6 = jT_SkKihon5.createTtdkRireki();
        jT_TtdkRireki6.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_01);
        jT_TtdkRireki6.setSyoriYmd(P_SYORIYMD_02);
        jT_TtdkRireki6.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        jT_TtdkRireki6.setKossyorisscd(P_KOSSYORISSCD_02);

        JT_SateiSyouninRireki jT_SateiSyouninRireki6 = jT_SkKihon5.createSateiSyouninRireki();
        jT_SateiSyouninRireki6.setSyorikekkakbn(C_SyorikekkaKbn.HORYUU);
        jT_SateiSyouninRireki6.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        siharaiDomManager.insert(jT_SkKihon5);

        JT_SkKihon jT_SkKihon6 = new JT_SkKihon(P_SKNO_02, P_SYONO_03);

        JT_TtdkRireki jT_TtdkRireki7 = jT_SkKihon6.createTtdkRireki();
        jT_TtdkRireki7.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_01);
        jT_TtdkRireki7.setSyoriYmd(P_SYORIYMD_03);
        jT_TtdkRireki7.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        jT_TtdkRireki7.setKossyorisscd(P_KOSSYORISSCD_02);

        JT_SateiSyouninRireki jT_SateiSyouninRireki7 = jT_SkKihon6.createSateiSyouninRireki();
        jT_SateiSyouninRireki7.setSyorikekkakbn(C_SyorikekkaKbn.KAKUNIN);
        jT_SateiSyouninRireki7.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        siharaiDomManager.insert(jT_SkKihon6);

        JT_SkKihon jT_SkKihon7 = new JT_SkKihon(P_SKNO_02, P_SYONO_04);

        JT_TtdkRireki jT_TtdkRireki8 = jT_SkKihon7.createTtdkRireki();
        jT_TtdkRireki8.setTtdkrrkskbtkey(P_TTDKRRKSKBTKEY_01);
        jT_TtdkRireki8.setSyoriYmd(P_SYORIYMD_02);
        jT_TtdkRireki8.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        jT_TtdkRireki8.setKossyorisscd(P_KOSSYORISSCD_03);

        JT_SateiSyouninRireki jT_SateiSyouninRireki8 = jT_SkKihon7.createSateiSyouninRireki();
        jT_SateiSyouninRireki8.setSyorikekkakbn(C_SyorikekkaKbn.KAKUNIN);
        jT_SateiSyouninRireki8.setSateisyouninskbtkey(P_SATEISYOUNINSKBTKEY_01);
        siharaiDomManager.insert(jT_SkKihon7);
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

        try (ExDBResults<JT_TtdkRireki> exDBRes_JT_TtdkRireki =
                siharaiDomManager.getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(P_SYORIYMD_03,
                        P_KOSSYORISSCD_03)) {

            Assert.assertFalse(exDBRes_JT_TtdkRireki.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_TtdkRireki> exDBRes_JT_TtdkRireki =
                siharaiDomManager.getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(P_SYORIYMD_01,
                        P_KOSSYORISSCD_01)) {

            int iCount = 0;
            Iterator<JT_TtdkRireki> iter = exDBRes_JT_TtdkRireki.iterator();
            JT_TtdkRireki jT_TtdkRireki = null;
            while (iter.hasNext()) {

                iCount++;
                jT_TtdkRireki = iter.next();

                Assert.assertEquals(P_SKNO_01, jT_TtdkRireki.getSkno());
                Assert.assertEquals(P_SYONO_02, jT_TtdkRireki.getSyono());
                Assert.assertEquals(P_TTDKRRKSKBTKEY_02, jT_TtdkRireki.getTtdkrrkskbtkey());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<JT_TtdkRireki> exDBRes_JT_TtdkRireki =
                siharaiDomManager.getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(P_SYORIYMD_02,
                        P_KOSSYORISSCD_02)) {

            int iCount = 0;
            Iterator<JT_TtdkRireki> iter = exDBRes_JT_TtdkRireki.iterator();
            JT_TtdkRireki jT_TtdkRireki = null;
            while (iter.hasNext()) {

                iCount++;
                jT_TtdkRireki = iter.next();

                if (1 == iCount) {

                    Assert.assertEquals(P_SKNO_01, jT_TtdkRireki.getSkno());
                    Assert.assertEquals(P_SYONO_01, jT_TtdkRireki.getSyono());
                    Assert.assertEquals(P_TTDKRRKSKBTKEY_03, jT_TtdkRireki.getTtdkrrkskbtkey());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals(P_SKNO_01, jT_TtdkRireki.getSkno());
                    Assert.assertEquals(P_SYONO_03, jT_TtdkRireki.getSyono());
                    Assert.assertEquals(P_TTDKRRKSKBTKEY_02, jT_TtdkRireki.getTtdkrrkskbtkey());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals(P_SKNO_02, jT_TtdkRireki.getSkno());
                    Assert.assertEquals(P_SYONO_01, jT_TtdkRireki.getSyono());
                    Assert.assertEquals(P_TTDKRRKSKBTKEY_01, jT_TtdkRireki.getTtdkrrkskbtkey());

                    continue;
                }
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        try (ExDBResults<JT_TtdkRireki> exDBRes_JT_TtdkRireki =
                siharaiDomManager.getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(P_SYORIYMD_02, "")) {

            Assert.assertFalse(exDBRes_JT_TtdkRireki.iterator().hasNext());
        }
    }
}
