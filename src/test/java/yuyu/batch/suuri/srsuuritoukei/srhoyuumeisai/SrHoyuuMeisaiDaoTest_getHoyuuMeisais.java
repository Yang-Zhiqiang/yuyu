package yuyu.batch.suuri.srsuuritoukei.srhoyuumeisai;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 保有明細情報作成<br />
 * 保有明細情報ビューエンティティ全件取得（大量）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SrHoyuuMeisaiDaoTest_getHoyuuMeisais {

    @Inject
    SrHoyuuMeisaiDao srHoyuuMeisaiDao;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static Integer P_DRTENRENNO_01 = new Integer(1);

    // 2/27↓
    static String P_KUBUNKEY_01 = "01";
    // 2/27↑

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        SrHoyuuMeisaiDao srHoyuuMeisaiDao = SWAKInjector.getInstance(SrHoyuuMeisaiDao.class);

        // 2/27↓
        //try (ExDBResults<SV_HoyuuMeisai> exDBResView = srHoyuuMeisaiDao.getHoyuuMeisais()) {
        try (ExDBResults<SV_HoyuuMeisai> exDBResView = srHoyuuMeisaiDao.getHoyuuMeisais(P_KUBUNKEY_01)) {
        // 2/27↑
            Assert.assertFalse(exDBResView.iterator().hasNext());
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon(P_SYONO_01);

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(P_DRTENRENNO_01);

        kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(20)
    public void normal10() {

        // 2/27↓
        //try (ExDBResults<SV_HoyuuMeisai> exDBResView = srHoyuuMeisaiDao.getHoyuuMeisais()) {
        try (ExDBResults<SV_HoyuuMeisai> exDBResView = srHoyuuMeisaiDao.getHoyuuMeisais(P_KUBUNKEY_01)) {
        // 2/27↑
            int iCount = 0;
            Iterator<SV_HoyuuMeisai> iter = exDBResView.iterator();
            SV_HoyuuMeisai sV_HoyuuMeisai = null;
            while (iter.hasNext()) {

                sV_HoyuuMeisai = iter.next();
                iCount++;

                Assert.assertEquals(P_SYONO_01, sV_HoyuuMeisai.getSyono());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon2 = new IT_KykKihon(P_SYONO_02);

        IT_KykDairiten kykDairiten2 = kykKihon2.createKykDairiten();
        kykDairiten2.setDrtenrenno(P_DRTENRENNO_01);

        kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon(P_SYONO_03);

        IT_KykDairiten kykDairiten3 = kykKihon3.createKykDairiten();
        kykDairiten3.setDrtenrenno(P_DRTENRENNO_01);

        kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        // 2/27↓
        //try (ExDBResults<SV_HoyuuMeisai> exDBResView = srHoyuuMeisaiDao.getHoyuuMeisais()) {
        try (ExDBResults<SV_HoyuuMeisai> exDBResView = srHoyuuMeisaiDao.getHoyuuMeisais(P_KUBUNKEY_01)) {
        // 2/27↑
            int iCount = 0;
            Iterator<SV_HoyuuMeisai> iter = exDBResView.iterator();
            SV_HoyuuMeisai sV_HoyuuMeisai = null;

            Map<String,String> map = new HashMap<String,String>();
            map.put($(P_SYONO_01), "1");
            map.put($(P_SYONO_02), "1");
            map.put($(P_SYONO_03), "1");

            while (iter.hasNext()) {

                sV_HoyuuMeisai = iter.next();
                iCount++;

                if (1 == iCount) {

                    map.remove($(sV_HoyuuMeisai.getSyono()));

                    continue;
                }

                if (2 == iCount) {

                    map.remove($(sV_HoyuuMeisai.getSyono()));

                    continue;
                }

                if (3 == iCount) {

                    map.remove($(sV_HoyuuMeisai.getSyono()));

                    continue;
                }
            }

            Assert.assertEquals(3, iCount);
            assertTrue(map.isEmpty());
        }
    }
}
