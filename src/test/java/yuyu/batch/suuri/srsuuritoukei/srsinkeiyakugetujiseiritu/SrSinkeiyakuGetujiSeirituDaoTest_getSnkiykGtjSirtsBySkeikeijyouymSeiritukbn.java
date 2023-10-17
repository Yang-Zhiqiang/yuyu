package yuyu.batch.suuri.srsuuritoukei.srsinkeiyakugetujiseiritu;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_Kokutisyo;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.HT_Tokunin;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 新契約決算ベース月次成立情報作成<br />
 * getSnkiykGtjSirtsBySkeikeijyouymSeiritukbn() メソッドのテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class SrSinkeiyakuGetujiSeirituDaoTest_getSnkiykGtjSirtsBySkeikeijyouymSeiritukbn {

    @Inject
    private SrSinkeiyakuGetujiSeirituDao srSinkeiyakuGetujiSeirituDao;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112501";
    static String P_MOSNO_03 = "791112402";
    static String P_MOSNO_04 = "791112253";
    static String P_MOSNO_05 = "791112394";
    static String P_MOSNO_06 = "791112345";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static String P_SYONO_04 = "11807111141";
    static String P_SYONO_05 = "11807111152";
    static String P_SYONO_06 = "11807111163";
    static BizDateYM P_SKEIKEIJYOUYM_01 = BizDateYM.valueOf("201606");
    static BizDateYM P_SKEIKEIJYOUYM_02 = BizDateYM.valueOf("201607");
    static BizDateYM P_SKEIKEIJYOUYM_03 = BizDateYM.valueOf("201608");
    static BizDateYM P_SKEIKEIJYOUYM_04 = BizDateYM.valueOf("201609");
    static Integer P_RENNO_01 = 1;
    static Integer P_RENNO_02 = 2;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SrSinkeiyakuGetujiSeirituDao srSinkeiyakuGetujiSeirituDao = SWAKInjector.getInstance(SrSinkeiyakuGetujiSeirituDao.class);

        try (ExDBResults<SV_SnkiykGtjSirt> beans =
            srSinkeiyakuGetujiSeirituDao.getSnkiykGtjSirtsBySkeikeijyouymSeiritukbn(P_SKEIKEIJYOUYM_01, C_SeirituKbn.NONE)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_SyoriCTL hT_SyoriCTL1 = new HT_SyoriCTL(P_MOSNO_01);
        hT_SyoriCTL1.setSyono(P_SYONO_01);
        hT_SyoriCTL1.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon hT_MosKihon1 = hT_SyoriCTL1.createMosKihon();
        hT_MosKihon1.setMosno(P_MOSNO_01);
        hT_MosKihon1.setSkeikeijyouym(P_SKEIKEIJYOUYM_01);

        HT_Kokutisyo hT_Kokutisyo1 = hT_SyoriCTL1.createKokutisyo();
        hT_Kokutisyo1.setMosno(P_MOSNO_01);

        HT_KykKak hT_KykKak1 = hT_SyoriCTL1.createKykKak();
        hT_KykKak1.setMosno(P_MOSNO_01);
        hT_KykKak1.setRenno(P_RENNO_01);
        hT_KykKak1.setKykkaksyrui(C_Kykkaksyrui.BLNK);

        HT_KykKak hT_KykKak2 = hT_SyoriCTL1.createKykKak();
        hT_KykKak2.setMosno(P_MOSNO_01);
        hT_KykKak2.setRenno(P_RENNO_02);
        hT_KykKak2.setKykkaksyrui(C_Kykkaksyrui.KETMAE);

        HT_Nyuukin hT_Nyuukin1 = hT_SyoriCTL1.createNyuukin();
        hT_Nyuukin1.setMosno(P_MOSNO_01);
        hT_Nyuukin1.setRenno(P_RENNO_01);
        hT_Nyuukin1.setRyosyuymd(BizDate.valueOf("20200101"));

        HT_Nyuukin hT_Nyuukin2 = hT_SyoriCTL1.createNyuukin();
        hT_Nyuukin2.setMosno(P_MOSNO_01);
        hT_Nyuukin2.setRenno(P_RENNO_02);
        hT_Nyuukin2.setRyosyuymd(BizDate.valueOf("20200202"));

        HT_Tokunin hT_Tokunin1 = hT_SyoriCTL1.createTokunin();
        hT_Tokunin1.setMosno(P_MOSNO_01);

        sinkeiyakuDomManager.insert(hT_SyoriCTL1);

        HT_SyoriCTL hT_SyoriCTL2 = new HT_SyoriCTL(P_MOSNO_02);
        hT_SyoriCTL2.setSyono(P_SYONO_02);
        hT_SyoriCTL2.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon hT_MosKihon2 = hT_SyoriCTL2.createMosKihon();
        hT_MosKihon2.setMosno(P_MOSNO_02);
        hT_MosKihon2.setSkeikeijyouym(P_SKEIKEIJYOUYM_02);

        HT_Kokutisyo hT_Kokutisyo2 = hT_SyoriCTL2.createKokutisyo();
        hT_Kokutisyo2.setMosno(P_MOSNO_02);

        HT_KykKak hT_KykKak3 = hT_SyoriCTL2.createKykKak();
        hT_KykKak3.setMosno(P_MOSNO_02);
        hT_KykKak3.setRenno(P_RENNO_01);
        hT_KykKak3.setKykkaksyrui(C_Kykkaksyrui.KETHORYU);

        HT_Nyuukin hT_Nyuukin3 = hT_SyoriCTL2.createNyuukin();
        hT_Nyuukin3.setMosno(P_MOSNO_02);
        hT_Nyuukin3.setRenno(P_RENNO_01);
        hT_Nyuukin3.setRyosyuymd(BizDate.valueOf("20200303"));

        HT_Tokunin hT_Tokunin2 = hT_SyoriCTL2.createTokunin();
        hT_Tokunin2.setMosno(P_MOSNO_02);

        sinkeiyakuDomManager.insert(hT_SyoriCTL2);

        HT_SyoriCTL hT_SyoriCTL3 = new HT_SyoriCTL(P_MOSNO_03);
        hT_SyoriCTL3.setSyono(P_SYONO_03);
        hT_SyoriCTL3.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon hT_MosKihon3 = hT_SyoriCTL3.createMosKihon();
        hT_MosKihon3.setMosno(P_MOSNO_03);
        hT_MosKihon3.setSkeikeijyouym(P_SKEIKEIJYOUYM_02);

        HT_Kokutisyo hT_Kokutisyo3 = hT_SyoriCTL3.createKokutisyo();
        hT_Kokutisyo3.setMosno(P_MOSNO_03);

        HT_KykKak hT_KykKak4 = hT_SyoriCTL3.createKykKak();
        hT_KykKak4.setMosno(P_MOSNO_03);
        hT_KykKak4.setRenno(P_RENNO_01);
        hT_KykKak4.setKykkaksyrui(C_Kykkaksyrui.KETHORYU);

        HT_Nyuukin hT_Nyuukin4 = hT_SyoriCTL3.createNyuukin();
        hT_Nyuukin4.setMosno(P_MOSNO_03);
        hT_Nyuukin4.setRenno(P_RENNO_01);
        hT_Nyuukin4.setRyosyuymd(BizDate.valueOf("20200303"));

        HT_Tokunin hT_Tokunin3 = hT_SyoriCTL3.createTokunin();
        hT_Tokunin3.setMosno(P_MOSNO_03);

        sinkeiyakuDomManager.insert(hT_SyoriCTL3);

        HT_SyoriCTL hT_SyoriCTL4 = new HT_SyoriCTL(P_MOSNO_04);
        hT_SyoriCTL4.setSyono(P_SYONO_04);
        hT_SyoriCTL4.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon hT_MosKihon4 = hT_SyoriCTL4.createMosKihon();
        hT_MosKihon4.setMosno(P_MOSNO_04);
        hT_MosKihon4.setSkeikeijyouym(P_SKEIKEIJYOUYM_02);

        HT_Kokutisyo hT_Kokutisyo4 = hT_SyoriCTL4.createKokutisyo();
        hT_Kokutisyo4.setMosno(P_MOSNO_04);

        HT_KykKak hT_KykKak5 = hT_SyoriCTL4.createKykKak();
        hT_KykKak5.setMosno(P_MOSNO_04);
        hT_KykKak5.setRenno(P_RENNO_01);
        hT_KykKak5.setKykkaksyrui(C_Kykkaksyrui.KETHORYU);

        HT_Nyuukin hT_Nyuukin5 = hT_SyoriCTL4.createNyuukin();
        hT_Nyuukin5.setMosno(P_MOSNO_04);
        hT_Nyuukin5.setRenno(P_RENNO_01);
        hT_Nyuukin5.setRyosyuymd(BizDate.valueOf("20200303"));

        HT_Tokunin hT_Tokunin4 = hT_SyoriCTL4.createTokunin();
        hT_Tokunin4.setMosno(P_MOSNO_04);

        sinkeiyakuDomManager.insert(hT_SyoriCTL4);

        HT_SyoriCTL hT_SyoriCTL5 = new HT_SyoriCTL(P_MOSNO_05);
        hT_SyoriCTL5.setSyono(P_SYONO_05);
        hT_SyoriCTL5.setSeiritukbn(C_SeirituKbn.ITIPMATI);

        HT_MosKihon hT_MosKihon5 = hT_SyoriCTL5.createMosKihon();
        hT_MosKihon5.setMosno(P_MOSNO_05);
        hT_MosKihon5.setSkeikeijyouym(P_SKEIKEIJYOUYM_02);

        HT_Kokutisyo hT_Kokutisyo5 = hT_SyoriCTL5.createKokutisyo();
        hT_Kokutisyo5.setMosno(P_MOSNO_05);

        HT_KykKak hT_KykKak6 = hT_SyoriCTL5.createKykKak();
        hT_KykKak6.setMosno(P_MOSNO_05);
        hT_KykKak6.setRenno(P_RENNO_01);
        hT_KykKak6.setKykkaksyrui(C_Kykkaksyrui.KETHORYU);

        HT_Nyuukin hT_Nyuukin6 = hT_SyoriCTL5.createNyuukin();
        hT_Nyuukin6.setMosno(P_MOSNO_05);
        hT_Nyuukin6.setRenno(P_RENNO_01);
        hT_Nyuukin6.setRyosyuymd(BizDate.valueOf("20200303"));

        HT_Tokunin hT_Tokunin5 = hT_SyoriCTL5.createTokunin();
        hT_Tokunin5.setMosno(P_MOSNO_05);

        sinkeiyakuDomManager.insert(hT_SyoriCTL5);

        HT_SyoriCTL hT_SyoriCTL6 = new HT_SyoriCTL(P_MOSNO_06);
        hT_SyoriCTL6.setSyono(P_SYONO_06);
        hT_SyoriCTL6.setSeiritukbn(C_SeirituKbn.SEIRITU);

        HT_MosKihon hT_MosKihon6 = hT_SyoriCTL6.createMosKihon();
        hT_MosKihon6.setMosno(P_MOSNO_06);
        hT_MosKihon6.setSkeikeijyouym(P_SKEIKEIJYOUYM_03);

        HT_Kokutisyo hT_Kokutisyo6 = hT_SyoriCTL6.createKokutisyo();
        hT_Kokutisyo6.setMosno(P_MOSNO_06);

        HT_KykKak hT_KykKak7 = hT_SyoriCTL6.createKykKak();
        hT_KykKak7.setMosno(P_MOSNO_06);
        hT_KykKak7.setRenno(P_RENNO_01);
        hT_KykKak7.setKykkaksyrui(C_Kykkaksyrui.KETHORYU);

        HT_Nyuukin hT_Nyuukin7 = hT_SyoriCTL6.createNyuukin();
        hT_Nyuukin7.setMosno(P_MOSNO_06);
        hT_Nyuukin7.setRenno(P_RENNO_01);
        hT_Nyuukin7.setRyosyuymd(BizDate.valueOf("20200303"));

        HT_Tokunin hT_Tokunin6 = hT_SyoriCTL6.createTokunin();
        hT_Tokunin6.setMosno(P_MOSNO_06);

        sinkeiyakuDomManager.insert(hT_SyoriCTL6);

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon("F1", P_SYONO_01);
        hozenDomManager.insert(iT_KykKihon1);

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon("F2", P_SYONO_02);
        hozenDomManager.insert(iT_KykKihon2);

        IT_KykKihon iT_KykKihon3 = new IT_KykKihon("F3", P_SYONO_03);
        hozenDomManager.insert(iT_KykKihon3);

        IT_KykKihon iT_KykKihon4 = new IT_KykKihon("F4", P_SYONO_04);
        hozenDomManager.insert(iT_KykKihon4);

        IT_KykKihon iT_KykKihon5 = new IT_KykKihon("F5", P_SYONO_05);
        hozenDomManager.insert(iT_KykKihon5);

        IT_KykKihon iT_KykKihon6 = new IT_KykKihon("F6", P_SYONO_06);
        hozenDomManager.insert(iT_KykKihon6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<SV_SnkiykGtjSirt> beans =
            srSinkeiyakuGetujiSeirituDao.getSnkiykGtjSirtsBySkeikeijyouymSeiritukbn(P_SKEIKEIJYOUYM_04, C_SeirituKbn.BLNK)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        try (ExDBResults<SV_SnkiykGtjSirt> beans =
            srSinkeiyakuGetujiSeirituDao.getSnkiykGtjSirtsBySkeikeijyouymSeiritukbn(P_SKEIKEIJYOUYM_01, C_SeirituKbn.NONE)) {

            int iCount = 0;
            Iterator<SV_SnkiykGtjSirt> iter = beans.iterator();
            SV_SnkiykGtjSirt sV_SnkiykGtjSirt = null;
            while (iter.hasNext()) {

                sV_SnkiykGtjSirt = iter.next();
                iCount++;

                Assert.assertEquals(P_MOSNO_01, sV_SnkiykGtjSirt.getMosno());
                Assert.assertEquals(P_SYONO_01, sV_SnkiykGtjSirt.getSyono());
                Assert.assertEquals(P_SKEIKEIJYOUYM_01, sV_SnkiykGtjSirt.getSkeikeijyouym());
                Assert.assertEquals(C_SeirituKbn.NONE, sV_SnkiykGtjSirt.getSeiritukbn());
                Assert.assertEquals(C_Kykkaksyrui.KETMAE, sV_SnkiykGtjSirt.getKykkaksyrui());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        try (ExDBResults<SV_SnkiykGtjSirt> beans =
            srSinkeiyakuGetujiSeirituDao.getSnkiykGtjSirtsBySkeikeijyouymSeiritukbn(P_SKEIKEIJYOUYM_02, C_SeirituKbn.SEIRITU)) {

            int iCount = 0;
            Iterator<SV_SnkiykGtjSirt> iter = beans.iterator();
            SV_SnkiykGtjSirt sV_SnkiykGtjSirt = null;
            Map<String,String> map = new HashMap<String,String>();
            map.put($(P_MOSNO_02,P_SYONO_02,P_SKEIKEIJYOUYM_02,C_SeirituKbn.SEIRITU,C_Kykkaksyrui.KETHORYU), "1");
            map.put($(P_MOSNO_03,P_SYONO_03,P_SKEIKEIJYOUYM_02,C_SeirituKbn.SEIRITU,C_Kykkaksyrui.KETHORYU), "1");
            map.put($(P_MOSNO_04,P_SYONO_04,P_SKEIKEIJYOUYM_02,C_SeirituKbn.SEIRITU,C_Kykkaksyrui.KETHORYU), "1");
            while (iter.hasNext()) {

                sV_SnkiykGtjSirt = iter.next();
                iCount++;

                if (1 == iCount) {
                    map.remove($(sV_SnkiykGtjSirt.getMosno(),sV_SnkiykGtjSirt.getSyono(),sV_SnkiykGtjSirt.getSkeikeijyouym(),sV_SnkiykGtjSirt.getSeiritukbn(),sV_SnkiykGtjSirt.getKykkaksyrui()));

                    continue;
                }

                if (2 == iCount) {
                    map.remove($(sV_SnkiykGtjSirt.getMosno(),sV_SnkiykGtjSirt.getSyono(),sV_SnkiykGtjSirt.getSkeikeijyouym(),sV_SnkiykGtjSirt.getSeiritukbn(),sV_SnkiykGtjSirt.getKykkaksyrui()));

                    continue;
                }

                if (3 == iCount) {
                    map.remove($(sV_SnkiykGtjSirt.getMosno(),sV_SnkiykGtjSirt.getSyono(),sV_SnkiykGtjSirt.getSkeikeijyouym(),sV_SnkiykGtjSirt.getSeiritukbn(),sV_SnkiykGtjSirt.getKykkaksyrui()));

                    continue;
                }
            }

            Assert.assertEquals(3, iCount);
            assertTrue(map.isEmpty());
        }
    }
}
