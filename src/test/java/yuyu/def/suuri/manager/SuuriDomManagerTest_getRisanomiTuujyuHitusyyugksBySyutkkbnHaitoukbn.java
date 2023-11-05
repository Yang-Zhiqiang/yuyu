package yuyu.def.suuri.manager;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.SV_RisanomiTuujyuHitusyyugk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 利差のみ通常配当所要額情報作成<br />
 * 利差のみ通常配当所要額情報ビューエンティティリスト（大量）取得(主契約特約区分、配当区分)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn {

    @Inject
    SuuriDomManager suuriDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static Integer P_KYKSYOUHNRENNO_01 = new Integer(11);
    static Integer P_KYKSYOUHNRENNO_02 = new Integer(12);
    static Integer P_KYKSYOUHNRENNO_03 = new Integer(13);
    static String P_SYOUHNCD_01 = "SY01";
    static Integer P_SYOUHNSDNO_01 = new Integer(11);
    static Integer P_SYOUHNSDNO_02 = new Integer(12);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        try (ExDBResults<SV_RisanomiTuujyuHitusyyugk> exDBResEntity = suuriDomManager
            .getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn.SYU, C_HaitouKbn.YUUHAI, "")) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);

        IT_KykSyouhn iT_KykSyouhn11 = iT_KykKihon1.createKykSyouhn();
        iT_KykSyouhn11.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhn11.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhn11.setSyouhnsdno(P_SYOUHNSDNO_01);
        iT_KykSyouhn11.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);

        hozenDomManager.insert(iT_KykKihon1);

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);

        IT_KykSyouhn iT_KykSyouhn21 = iT_KykKihon2.createKykSyouhn();
        iT_KykSyouhn21.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhn21.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhn21.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhn21.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);

        IT_KykSyouhn iT_KykSyouhn22 = iT_KykKihon2.createKykSyouhn();
        iT_KykSyouhn22.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhn22.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhn22.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhn22.setKyksyouhnrenno(P_KYKSYOUHNRENNO_02);

        IT_KykSyouhn iT_KykSyouhn23 = iT_KykKihon2.createKykSyouhn();
        iT_KykSyouhn23.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhn23.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhn23.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhn23.setKyksyouhnrenno(P_KYKSYOUHNRENNO_03);

        IT_KykSyouhn iT_KykSyouhn24 = iT_KykKihon2.createKykSyouhn();
        iT_KykSyouhn24.setSyutkkbn(C_SyutkKbn.TK);
        iT_KykSyouhn24.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhn24.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhn24.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);

        hozenDomManager.insert(iT_KykKihon2);

        BM_SyouhnZokusei bM_SyouhnZokusei1 = new BM_SyouhnZokusei(P_SYOUHNCD_01, P_SYOUHNSDNO_01);
        bM_SyouhnZokusei1.setHaitoukbn(C_HaitouKbn.YUUHAI);

        bizDomManager.insert(bM_SyouhnZokusei1);

        BM_SyouhnZokusei bM_SyouhnZokusei2 = new BM_SyouhnZokusei(P_SYOUHNCD_01, P_SYOUHNSDNO_02);
        bM_SyouhnZokusei2.setHaitoukbn(C_HaitouKbn.RISAHAI);

        bizDomManager.insert(bM_SyouhnZokusei2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<SV_RisanomiTuujyuHitusyyugk> exDBResEntity = suuriDomManager
            .getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn.TK, C_HaitouKbn.YUUHAI, "")) {

            Assert.assertFalse(exDBResEntity.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<SV_RisanomiTuujyuHitusyyugk> exDBResEntity = suuriDomManager
            .getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn.SYU, C_HaitouKbn.YUUHAI, "")) {

            int iCount = 0;
            Iterator<SV_RisanomiTuujyuHitusyyugk> iter = exDBResEntity.iterator();
            SV_RisanomiTuujyuHitusyyugk sV_RisanomiTuujyuHitusyyugk = null;
            while(iter.hasNext()){

                sV_RisanomiTuujyuHitusyyugk = iter.next();
                iCount++;

                Assert.assertEquals(P_SYONO_01, sV_RisanomiTuujyuHitusyyugk.getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, sV_RisanomiTuujyuHitusyyugk.getSyutkkbn());
                Assert.assertEquals(P_SYOUHNCD_01, sV_RisanomiTuujyuHitusyyugk.getSyouhncd());
                Assert.assertEquals(P_SYOUHNSDNO_01, sV_RisanomiTuujyuHitusyyugk.getSyouhnsdno());
                Assert.assertEquals(P_KYKSYOUHNRENNO_01, sV_RisanomiTuujyuHitusyyugk.getKyksyouhnrenno());
                Assert.assertEquals(C_HaitouKbn.YUUHAI, sV_RisanomiTuujyuHitusyyugk.getHaitoukbn());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> risanomiTuujyuHitusyyugkMap = new HashMap<String, String>();
        risanomiTuujyuHitusyyugkMap.put($(P_SYONO_02,C_SyutkKbn.SYU,P_SYOUHNCD_01,P_SYOUHNSDNO_02,P_KYKSYOUHNRENNO_01,C_HaitouKbn.RISAHAI),"1");
        risanomiTuujyuHitusyyugkMap.put($(P_SYONO_02,C_SyutkKbn.SYU,P_SYOUHNCD_01,P_SYOUHNSDNO_02,P_KYKSYOUHNRENNO_02,C_HaitouKbn.RISAHAI),"1");
        risanomiTuujyuHitusyyugkMap.put($(P_SYONO_02,C_SyutkKbn.SYU,P_SYOUHNCD_01,P_SYOUHNSDNO_02,P_KYKSYOUHNRENNO_03,C_HaitouKbn.RISAHAI),"1");

        try (ExDBResults<SV_RisanomiTuujyuHitusyyugk> exDBResEntity = suuriDomManager
            .getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn.SYU, C_HaitouKbn.RISAHAI, "")) {

            int iCount = 0;
            Iterator<SV_RisanomiTuujyuHitusyyugk> iter = exDBResEntity.iterator();
            SV_RisanomiTuujyuHitusyyugk sV_RisanomiTuujyuHitusyyugk = null;
            while(iter.hasNext()){

                sV_RisanomiTuujyuHitusyyugk = iter.next();
                iCount++;
                risanomiTuujyuHitusyyugkMap.remove($(sV_RisanomiTuujyuHitusyyugk.getSyono(),sV_RisanomiTuujyuHitusyyugk.getSyutkkbn(),
                    sV_RisanomiTuujyuHitusyyugk.getSyouhncd(),sV_RisanomiTuujyuHitusyyugk.getSyouhnsdno(),sV_RisanomiTuujyuHitusyyugk.getKyksyouhnrenno(),
                    sV_RisanomiTuujyuHitusyyugk.getHaitoukbn()));
            }

            Assert.assertEquals(3, iCount);
            assertTrue(risanomiTuujyuHitusyyugkMap.isEmpty());
        }
    }
}
