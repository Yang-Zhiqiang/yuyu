package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
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

import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * IBNR備金明細表作成<br />
 * 請求基本テーブルエンティティリスト（大量）取得 請求種別 再査定区分などのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns {

    @Inject
    SiharaiDomManager siharaiDomManager;

    static C_ShrKekkaKbn[] SHRKEKKAKBN1 = {C_ShrKekkaKbn.SHR, C_ShrKekkaKbn.HSHR};
    static C_ShrKekkaKbn[] SHRKEKKAKBN2 = {C_ShrKekkaKbn.HSHR, C_ShrKekkaKbn.ITIBU_SHR, C_ShrKekkaKbn.TSSHR};
    static C_ShrKekkaKbn[] SHRKEKKAKBN3 = {C_ShrKekkaKbn.TSSHR, C_ShrKekkaKbn.NENKINSHR, C_ShrKekkaKbn.ITIBU_NENKIN};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SkKihon> exDB_SkKihonLst = siharaiDomManager
            .getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu.KYH,
                C_SaisateiKbn.SAISATEI, BizDate.valueOf(20161026), BizDate.valueOf(20170331), SHRKEKKAKBN1)) {

            Assert.assertFalse(exDB_SkKihonLst.iterator().hasNext());
        }

        JT_SkKihon skKihon1 = new JT_SkKihon("SKNO01", "11807111118");
        skKihon1.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon1.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        skKihon1.setSiboukaritrkymd(BizDate.valueOf(20161027));
        skKihon1.setShrkekkakbn(C_ShrKekkaKbn.SHR);

        siharaiDomManager.insert(skKihon1);

        JT_SkKihon skKihon2 = new JT_SkKihon("SKNO01", "11807111129");
        skKihon2.setSeikyuusyubetu(C_SeikyuuSyubetu.BLNK);
        skKihon2.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        skKihon2.setSiboukaritrkymd(BizDate.valueOf(20161027));
        skKihon2.setShrkekkakbn(C_ShrKekkaKbn.SHR);

        siharaiDomManager.insert(skKihon2);

        JT_SkKihon skKihon3 = new JT_SkKihon("SKNO01", "11807111130");
        skKihon3.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon3.setSaisateikbn(C_SaisateiKbn.BLNK);
        skKihon3.setSiboukaritrkymd(BizDate.valueOf(20161027));
        skKihon3.setShrkekkakbn(C_ShrKekkaKbn.SHR);

        siharaiDomManager.insert(skKihon3);

        JT_SkKihon skKihon4 = new JT_SkKihon("SKNO01", "11807111141");
        skKihon4.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon4.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        skKihon4.setSiboukaritrkymd(BizDate.valueOf(20161025));
        skKihon4.setShrkekkakbn(C_ShrKekkaKbn.SHR);

        siharaiDomManager.insert(skKihon4);

        JT_SkKihon skKihon5 = new JT_SkKihon("SKNO01", "11807111152");
        skKihon5.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon5.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        skKihon5.setSiboukaritrkymd(BizDate.valueOf(20161027));
        skKihon5.setShrkekkakbn(C_ShrKekkaKbn.BLNK);

        siharaiDomManager.insert(skKihon5);

        JT_SkKihon skKihon6 = new JT_SkKihon("SKNO01", "11807111163");
        skKihon6.setSeikyuusyubetu(C_SeikyuuSyubetu.PM);
        skKihon6.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        skKihon6.setSiboukaritrkymd(BizDate.valueOf(20161126));
        skKihon6.setShrkekkakbn(C_ShrKekkaKbn.TSSHR);

        siharaiDomManager.insert(skKihon6);

        JT_SkKihon skKihon7 = new JT_SkKihon("SKNO01", "11807111174");
        skKihon7.setSeikyuusyubetu(C_SeikyuuSyubetu.PM);
        skKihon7.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        skKihon7.setSiboukaritrkymd(BizDate.valueOf(20161127));
        skKihon7.setShrkekkakbn(C_ShrKekkaKbn.NENKINSHR);

        siharaiDomManager.insert(skKihon7);

        JT_SkKihon skKihon8 = new JT_SkKihon("SKNO01", "11807111185");
        skKihon8.setSeikyuusyubetu(C_SeikyuuSyubetu.PM);
        skKihon8.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        skKihon8.setSiboukaritrkymd(BizDate.valueOf(20161128));
        skKihon8.setShrkekkakbn(C_ShrKekkaKbn.ITIBU_NENKIN);

        siharaiDomManager.insert(skKihon8);

        JT_SkKihon skKihon9 = new JT_SkKihon("SKNO01", "11807111196");
        skKihon9.setSeikyuusyubetu(C_SeikyuuSyubetu.KYH);
        skKihon9.setSaisateikbn(C_SaisateiKbn.SAISATEI);
        skKihon9.setSiboukaritrkymd(BizDate.valueOf(20170406));
        skKihon9.setShrkekkakbn(C_ShrKekkaKbn.SHR);

        siharaiDomManager.insert(skKihon9);

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
            .getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu.KYH,
                C_SaisateiKbn.SAISATEI, BizDate.valueOf(20161026), BizDate.valueOf(20170331), SHRKEKKAKBN2)) {

            Assert.assertFalse(exDB_SkKihonLst.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<JT_SkKihon> exDB_SkKihonLst = siharaiDomManager
            .getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu.KYH,
                C_SaisateiKbn.SAISATEI, BizDate.valueOf(20161026), BizDate.valueOf(20170331), SHRKEKKAKBN1)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDB_SkKihonLst.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                iCount++;
                jT_SkKihon = iter.next();

                Assert.assertEquals("SKNO01", jT_SkKihon.getSkno());
                Assert.assertEquals("11807111118", jT_SkKihon.getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("SKNO01","11807111163"), "1");
        datamap.put($("SKNO01","11807111174"), "1");
        datamap.put($("SKNO01","11807111185"), "1");

        try (ExDBResults<JT_SkKihon> exDB_SkKihonLst = siharaiDomManager
            .getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu.PM,
                C_SaisateiKbn.SAISATEI, BizDate.valueOf(20161126), BizDate.valueOf(20170331), SHRKEKKAKBN3)) {

            int iCount = 0;
            Iterator<JT_SkKihon> iter = exDB_SkKihonLst.iterator();
            JT_SkKihon jT_SkKihon = null;
            while (iter.hasNext()) {

                iCount++;
                jT_SkKihon = iter.next();

                datamap.remove($(
                    jT_SkKihon.getSkno(),
                    jT_SkKihon.getSyono()));

            }
            Assert.assertTrue(datamap.isEmpty());
        }
    }
}

