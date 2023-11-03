package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
 * 保険金<br />
 * 支払所要日数情報作成<br />
 * 支払履歴テーブルエンティティリスト（大量）取得（支払処理開始日、支払処理終了日）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static String P_SKNO_01 = "11807111111";
    static String P_SKNO_02 = "11807111129";
    static String P_SKNO_03 = "11807111112";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111303";
    static String P_SHRSIKIBETUKEY_01 = "22220";
    static String P_SHRSIKIBETUKEY_02 = "22221";
    static String P_SHRSIKIBETUKEY_03 = "22222";
    static String P_SHRSIKIBETUKEY_04 = "22223";
    static String P_SHRSIKIBETUKEY_05 = "22224";
    static String P_SHRSIKIBETUKEY_06 = "22225";
    static String P_SHRSIKIBETUKEY_07 = "22226";
    static String P_SHRSIKIBETUKEY_08 = "22227";
    static BizDate P_SHRSYORIYMDFROM_001 = BizDate.valueOf("20160315");
    static BizDate P_SHRSYORIYMDFROM_002 = BizDate.valueOf("20160311");
    static BizDate P_SHRSYORIYMDFROM_003 = BizDate.valueOf("20160314");
    static BizDate P_SHRSYORIFROMYMDTO_001 = BizDate.valueOf("20160315");
    static BizDate P_SHRSYORIFROMYMDTO_002 = BizDate.valueOf("20160312");
    static BizDate P_SHRSYORIFROMYMDTO_003 = BizDate.valueOf("20160317");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SiRireki> jT_SiRirekiResults =
            siharaiDomManager.getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn(P_SHRSYORIYMDFROM_001, P_SHRSYORIFROMYMDTO_001)) {

            Assert.assertFalse(jT_SiRirekiResults.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon(P_SKNO_02, P_SYONO_02);
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki1 = skKihon1.createSiRireki();
        siRireki1.setShrsikibetukey(P_SHRSIKIBETUKEY_01);
        siRireki1.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki1.setShrsyoriymd(BizDate.valueOf("20160315"));

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon(P_SKNO_02, P_SYONO_01);
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki2 = skKihon2.createSiRireki();
        siRireki2.setShrsikibetukey(P_SHRSIKIBETUKEY_02);
        siRireki2.setShrkekkakbn(C_ShrKekkaKbn.ITIBU_SHR);
        siRireki2.setShrsyoriymd(BizDate.valueOf("20160313"));

        JT_SiRireki siRireki3 = skKihon2.createSiRireki();
        siRireki3.setShrsikibetukey(P_SHRSIKIBETUKEY_03);
        siRireki3.setShrkekkakbn(C_ShrKekkaKbn.ITIBU_SHR);
        siRireki3.setShrsyoriymd(BizDate.valueOf("20160316"));

        JT_SiRireki siRireki4 = skKihon2.createSiRireki();
        siRireki4.setShrsikibetukey(P_SHRSIKIBETUKEY_04);
        siRireki4.setShrkekkakbn(C_ShrKekkaKbn.ITIBU_SHR);
        siRireki4.setShrsyoriymd(BizDate.valueOf("20160314"));

        JT_SiRireki siRireki5 = skKihon2.createSiRireki();
        siRireki5.setShrsikibetukey(P_SHRSIKIBETUKEY_05);
        siRireki5.setShrkekkakbn(C_ShrKekkaKbn.HSHR);
        siRireki5.setShrsyoriymd(BizDate.valueOf("20160316"));

        JT_SiRireki siRireki6 = skKihon2.createSiRireki();
        siRireki6.setShrsikibetukey(P_SHRSIKIBETUKEY_06);
        siRireki6.setShrkekkakbn(C_ShrKekkaKbn.ITIBU_SHR);
        siRireki6.setShrsyoriymd(BizDate.valueOf("20160318"));

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon(P_SKNO_03, P_SYONO_02);
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);

        JT_SiRireki siRireki7 = skKihon3.createSiRireki();
        siRireki7.setShrsikibetukey(P_SHRSIKIBETUKEY_07);
        siRireki7.setShrkekkakbn(C_ShrKekkaKbn.ITIBU_SHR);
        siRireki7.setShrsyoriymd(BizDate.valueOf("20160317"));

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon(P_SKNO_01, P_SYONO_01);
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.SDSSHR);

        JT_SiRireki siRireki8 = skKihon4.createSiRireki();
        siRireki8.setShrsikibetukey(P_SHRSIKIBETUKEY_08);
        siRireki8.setShrkekkakbn(C_ShrKekkaKbn.SHR);
        siRireki8.setShrsyoriymd(BizDate.valueOf("20160315"));

        siharaiDomManager.insert(skKihon4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSkKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        try (ExDBResults<JT_SiRireki> jT_SiRirekiResults =
            siharaiDomManager.getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn(P_SHRSYORIYMDFROM_002, P_SHRSYORIFROMYMDTO_002)) {

            Assert.assertFalse(jT_SiRirekiResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_SiRireki> jT_SiRirekiResults =
            siharaiDomManager.getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn(P_SHRSYORIYMDFROM_001, P_SHRSYORIFROMYMDTO_001)) {

            int iCount = 0;
            Iterator<JT_SiRireki> iter = jT_SiRirekiResults.iterator();
            JT_SiRireki jT_SiRireki = null;
            while (iter.hasNext()) {

                jT_SiRireki = iter.next();
                iCount++;

                Assert.assertEquals(P_SKNO_02, jT_SiRireki.getSkno());
                Assert.assertEquals(P_SYONO_02, jT_SiRireki.getSyono());
                Assert.assertEquals(P_SHRSIKIBETUKEY_01, jT_SiRireki.getShrsikibetukey());
                Assert.assertEquals(C_ShrKekkaKbn.SHR, jT_SiRireki.getShrkekkakbn());
                Assert.assertEquals(BizDate.valueOf("20160315"), jT_SiRireki.getShrsyoriymd());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($(P_SKNO_02,P_SYONO_01,P_SHRSIKIBETUKEY_03,C_ShrKekkaKbn.ITIBU_SHR,BizDate.valueOf("20160316")),"1");
        map.put($(P_SKNO_02,P_SYONO_01,P_SHRSIKIBETUKEY_04,C_ShrKekkaKbn.ITIBU_SHR,BizDate.valueOf("20160314")),"1");

        try (ExDBResults<JT_SiRireki> jT_SiRirekiResults =
            siharaiDomManager.getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn(P_SHRSYORIYMDFROM_003, P_SHRSYORIFROMYMDTO_003)) {

            int iCount = 0;
            Iterator<JT_SiRireki> iter = jT_SiRirekiResults.iterator();
            JT_SiRireki jT_SiRireki = null;
            while (iter.hasNext()) {

                jT_SiRireki = iter.next();
                iCount++;

                if (1 == iCount) {
                    assertTrue(map.containsKey($(jT_SiRireki.getSkno(), jT_SiRireki.getSyono(), jT_SiRireki.getShrsikibetukey(), jT_SiRireki.getShrkekkakbn(), jT_SiRireki.getShrsyoriymd())));
                    continue;
                }

                if (2 == iCount) {
                    assertTrue(map.containsKey($(jT_SiRireki.getSkno(), jT_SiRireki.getSyono(), jT_SiRireki.getShrsikibetukey(), jT_SiRireki.getShrkekkakbn(), jT_SiRireki.getShrsyoriymd())));
                    continue;
                }

                if (3 == iCount) {
                    Assert.assertEquals(P_SKNO_03, jT_SiRireki.getSkno());
                    Assert.assertEquals(P_SYONO_02, jT_SiRireki.getSyono());
                    Assert.assertEquals(P_SHRSIKIBETUKEY_07, jT_SiRireki.getShrsikibetukey());
                    Assert.assertEquals(C_ShrKekkaKbn.ITIBU_SHR, jT_SiRireki.getShrkekkakbn());
                    Assert.assertEquals(BizDate.valueOf("20160317"), jT_SiRireki.getShrsyoriymd());
                    continue;
                }

                if (4 == iCount) {
                    Assert.assertEquals(P_SKNO_02, jT_SiRireki.getSkno());
                    Assert.assertEquals(P_SYONO_02, jT_SiRireki.getSyono());
                    Assert.assertEquals(P_SHRSIKIBETUKEY_01, jT_SiRireki.getShrsikibetukey());
                    Assert.assertEquals(C_ShrKekkaKbn.SHR, jT_SiRireki.getShrkekkakbn());
                    Assert.assertEquals(BizDate.valueOf("20160315"), jT_SiRireki.getShrsyoriymd());
                    continue;
                }
            }

            Assert.assertEquals(4, iCount);
        }
    }
}
