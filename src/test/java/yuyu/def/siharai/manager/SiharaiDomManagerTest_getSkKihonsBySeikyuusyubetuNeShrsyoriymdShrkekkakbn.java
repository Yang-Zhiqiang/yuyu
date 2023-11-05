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

import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 支社別保険金種類別集計情報作成<br />
 * 請求基本テーブルエンティティリスト(大量)取得(支払処理開始日、支払処理終了日)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SYONO_001 = "11807111118";
    static String P_SYONO_002 = "11807111129";
    static String P_SYONO_003 = "11807111130";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SkKihon> exDB_SkKihonLst = siharaiDomManager
                .getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(BizDate.valueOf(20160405),
                        BizDate.valueOf(20160406))) {

            Assert.assertFalse(exDB_SkKihonLst.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon("10000019", P_SYONO_001);
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("10000010", P_SYONO_003);
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("10000018", P_SYONO_001);
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki1 = skKihon3.createSiRireki();
        siRireki1.setShrsikibetukey("1");
        siRireki1.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki1.setShrsyoriymd(BizDate.valueOf(20160406));

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("10000017", P_SYONO_001);
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki2 = skKihon4.createSiRireki();
        siRireki2.setShrsikibetukey("1");
        siRireki2.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki2.setShrsyoriymd(BizDate.valueOf(20160411));

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("10000016", P_SYONO_001);
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki3 = skKihon5.createSiRireki();
        siRireki3.setShrsikibetukey("1");
        siRireki3.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki3.setShrsyoriymd(BizDate.valueOf(20160404));

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("10000015", P_SYONO_001);
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki4 = skKihon6.createSiRireki();
        siRireki4.setShrsikibetukey("1");
        siRireki4.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki4.setShrsyoriymd(BizDate.valueOf(20160410));

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("10000014", P_SYONO_001);
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.SDSSHR);

        JT_SiRireki siRireki5 = skKihon7.createSiRireki();
        siRireki5.setShrsikibetukey("1");
        siRireki5.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki5.setShrsyoriymd(BizDate.valueOf(20160408));

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("10000013", P_SYONO_001);
        skKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki6 = skKihon8.createSiRireki();
        siRireki6.setShrsikibetukey("1");
        siRireki6.setShrkekkakbn(C_ShrKekkaKbn.ITIBU_SHR);
        siRireki6.setShrsyoriymd(BizDate.valueOf(20160410));

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon9 = new JT_SkKihon("10000012", P_SYONO_002);
        skKihon9.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki7 = skKihon9.createSiRireki();
        siRireki7.setShrsikibetukey("1");
        siRireki7.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki7.setShrsyoriymd(BizDate.valueOf(20160409));

        siharaiDomManager.insert(skKihon9);

        JT_SkKihon skKihon10 = new JT_SkKihon("10000011", P_SYONO_001);
        skKihon10.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki8 = skKihon10.createSiRireki();
        siRireki8.setShrsikibetukey("1");
        siRireki8.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki8.setShrsyoriymd(BizDate.valueOf(20160408));

        siharaiDomManager.insert(skKihon10);

        JT_SkKihon skKihon11 = new JT_SkKihon("10000010", P_SYONO_001);
        skKihon11.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki9 = skKihon11.createSiRireki();
        siRireki9.setShrsikibetukey("1");
        siRireki9.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki9.setShrsyoriymd(BizDate.valueOf(20160407));

        siharaiDomManager.insert(skKihon11);
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

        try (ExDBResults<JT_SkKihon> exDB_SkKihonLst = siharaiDomManager
                .getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(BizDate.valueOf(20160401),
                        BizDate.valueOf(20160402))) {

            Assert.assertFalse(exDB_SkKihonLst.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_SkKihon> exDB_SkKihonLst =
                siharaiDomManager.getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(BizDate.valueOf(20160405),
                        BizDate.valueOf(20160406))) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDB_SkKihonLst.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                iCount++;
                jT_SkKihon = iter.next();

                Assert.assertEquals("10000018", jT_SkKihon.getSkno());
                Assert.assertEquals(P_SYONO_001, jT_SkKihon.getSyono());
                Assert.assertEquals(C_SeikyuuSyubetu.KYH, jT_SkKihon.getSeikyuusyubetu());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<JT_SkKihon> exDB_SkKihonLst =
                siharaiDomManager.getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(BizDate.valueOf(20160407),
                        BizDate.valueOf(20160410))) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDB_SkKihonLst.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                iCount++;
                jT_SkKihon = iter.next();

                if (1 == iCount) {

                    Assert.assertEquals("10000010", jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_001, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SeikyuuSyubetu.KYH, jT_SkKihon.getSeikyuusyubetu());

                    continue;
                }

                if (2 == iCount) {

                    Assert.assertEquals("10000011", jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_001, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SeikyuuSyubetu.KYH, jT_SkKihon.getSeikyuusyubetu());

                    continue;
                }

                if (3 == iCount) {

                    Assert.assertEquals("10000013", jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_001, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SeikyuuSyubetu.KYH, jT_SkKihon.getSeikyuusyubetu());

                    continue;
                }

                if (4 == iCount) {

                    Assert.assertEquals("10000012", jT_SkKihon.getSkno());
                    Assert.assertEquals(P_SYONO_002, jT_SkKihon.getSyono());
                    Assert.assertEquals(C_SeikyuuSyubetu.KYH, jT_SkKihon.getSeikyuusyubetu());

                    continue;
                }
            }

            Assert.assertEquals(4, iCount);
        }
    }
}
