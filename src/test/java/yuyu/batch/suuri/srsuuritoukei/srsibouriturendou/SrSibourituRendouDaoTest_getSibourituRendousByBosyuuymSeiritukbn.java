package yuyu.batch.suuri.srsuuritoukei.srsibouriturendou;

import java.util.HashMap;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Kykkaksyrui;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_IjitoukeiMeisai;
import yuyu.def.db.entity.HT_KykKak;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.entity.SV_SibourituRendou;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 死亡率用連動情報作成<br />
 * getSibourituRendousByBosyuuymSeiritukbn() メソッドのテストクラス <br />
 */
@RunWith(OrderedRunner.class)
public class SrSibourituRendouDaoTest_getSibourituRendousByBosyuuymSeiritukbn {

    @Inject
    private SrSibourituRendouDao srSibourituRendouDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        SrSibourituRendouDao srSibourituRendouDao = SWAKInjector.getInstance(SrSibourituRendouDao.class);

        try (ExDBResults<SV_SibourituRendou> beans =
            srSibourituRendouDao.getSibourituRendousByBosyuuymSeiritukbn(BizDateYM.valueOf("201603"),C_SeirituKbn.BLNK)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSyono("11807111118");
        syoriCTL1.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setBosyuuym(BizDateYM.valueOf(201603));

        syoriCTL1.createKokutisyo();

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(1);

        HT_KykKak kykKak1 = syoriCTL1.createKykKak();
        kykKak1.setRenno(1);
        kykKak1.setKykkaksyrui(C_Kykkaksyrui.KETMAE);

        HT_KykKak kykKak2 = syoriCTL1.createKykKak();
        kykKak2.setRenno(2);
        kykKak2.setKykkaksyrui(C_Kykkaksyrui.BLNK);

        HT_DakuhiKettei dakuhiKettei1 = syoriCTL1.createDakuhiKettei();
        dakuhiKettei1.setDakuhiktrenno(1);
        dakuhiKettei1.setKetkekkacd(C_Ketkekkacd.BLNK);

        HT_DakuhiKettei dakuhiKettei2 = syoriCTL1.createDakuhiKettei();
        dakuhiKettei2.setDakuhiktrenno(2);
        dakuhiKettei2.setKetkekkacd(C_Ketkekkacd.MUJYOUKEN);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSyono("11807111129");
        syoriCTL2.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setBosyuuym(BizDateYM.valueOf(201604));

        syoriCTL2.createKokutisyo();

        HT_MosDairiten mosDairiten2 = syoriCTL2.createMosDairiten();
        mosDairiten2.setRenno(1);

        HT_KykKak kykKak3 = syoriCTL2.createKykKak();
        kykKak3.setRenno(0);
        kykKak3.setKykkaksyrui(C_Kykkaksyrui.KETMAE);

        HT_DakuhiKettei dakuhiKettei3 = syoriCTL2.createDakuhiKettei();
        dakuhiKettei3.setDakuhiktrenno(0);
        dakuhiKettei3.setKetkekkacd(C_Ketkekkacd.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSyono("11807111130");
        syoriCTL3.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setBosyuuym(BizDateYM.valueOf(201604));

        syoriCTL3.createKokutisyo();

        HT_MosDairiten mosDairiten3 = syoriCTL3.createMosDairiten();
        mosDairiten3.setRenno(1);

        HT_KykKak kykKak4 = syoriCTL3.createKykKak();
        kykKak4.setRenno(0);
        kykKak4.setKykkaksyrui(C_Kykkaksyrui.KETMAE);

        HT_DakuhiKettei dakuhiKettei4 = syoriCTL3.createDakuhiKettei();
        dakuhiKettei4.setDakuhiktrenno(0);
        dakuhiKettei4.setKetkekkacd(C_Ketkekkacd.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSyono("11807111141");
        syoriCTL4.setSeiritukbn(C_SeirituKbn.NONE);

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();
        mosKihon4.setBosyuuym(BizDateYM.valueOf(201604));

        syoriCTL4.createKokutisyo();

        HT_MosDairiten mosDairiten4 = syoriCTL4.createMosDairiten();
        mosDairiten4.setRenno(1);

        HT_KykKak kykKak5 = syoriCTL4.createKykKak();
        kykKak5.setRenno(0);
        kykKak5.setKykkaksyrui(C_Kykkaksyrui.KETMAE);

        HT_DakuhiKettei dakuhiKettei5 = syoriCTL4.createDakuhiKettei();
        dakuhiKettei5.setDakuhiktrenno(0);
        dakuhiKettei5.setKetkekkacd(C_Ketkekkacd.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setSyono("11807111152");
        syoriCTL5.setSeiritukbn(C_SeirituKbn.BLNK);

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();
        mosKihon5.setBosyuuym(BizDateYM.valueOf(201604));

        syoriCTL5.createKokutisyo();

        HT_MosDairiten mosDairiten5 = syoriCTL5.createMosDairiten();
        mosDairiten5.setRenno(1);

        HT_KykKak kykKak6 = syoriCTL5.createKykKak();
        kykKak6.setRenno(0);
        kykKak6.setKykkaksyrui(C_Kykkaksyrui.KETMAE);

        HT_DakuhiKettei dakuhiKettei6 = syoriCTL5.createDakuhiKettei();
        dakuhiKettei6.setDakuhiktrenno(0);
        dakuhiKettei6.setKetkekkacd(C_Ketkekkacd.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_IjitoukeiMeisai ijitoukeiMeisai1 = new HT_IjitoukeiMeisai("11807111118", 1);

        sinkeiyakuDomManager.insert(ijitoukeiMeisai1);

        HT_IjitoukeiMeisai ijitoukeiMeisai2 = new HT_IjitoukeiMeisai("11807111129", 1);

        sinkeiyakuDomManager.insert(ijitoukeiMeisai2);

        HT_IjitoukeiMeisai ijitoukeiMeisai3 = new HT_IjitoukeiMeisai("11807111130", 1);

        sinkeiyakuDomManager.insert(ijitoukeiMeisai3);

        HT_IjitoukeiMeisai ijitoukeiMeisai4 = new HT_IjitoukeiMeisai("11807111141", 1);

        sinkeiyakuDomManager.insert(ijitoukeiMeisai4);

        HT_IjitoukeiMeisai ijitoukeiMeisai5 = new HT_IjitoukeiMeisai("11807111152", 1);

        sinkeiyakuDomManager.insert(ijitoukeiMeisai5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllIjitoukeiMeisai());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<SV_SibourituRendou> beans =
            srSibourituRendouDao.getSibourituRendousByBosyuuymSeiritukbn(BizDateYM.valueOf("201603"), C_SeirituKbn.NONE)) {

            Assert.assertFalse(beans.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        try (ExDBResults<SV_SibourituRendou> beans =
            srSibourituRendouDao.getSibourituRendousByBosyuuymSeiritukbn(BizDateYM.valueOf("201603"), C_SeirituKbn.BLNK)) {

            int iCount = 0;
            Iterator<SV_SibourituRendou> iter = beans.iterator();
            SV_SibourituRendou sV_SibourituRendou = null;
            while (iter.hasNext()) {

                sV_SibourituRendou = iter.next();
                iCount++;

                Assert.assertEquals("791112220", sV_SibourituRendou.getMosno());
                Assert.assertEquals("11807111118", sV_SibourituRendou.getSyono());
                Assert.assertEquals(C_Kykkaksyrui.BLNK, sV_SibourituRendou.getKykkaksyrui());
                Assert.assertEquals(C_Ketkekkacd.MUJYOUKEN, sV_SibourituRendou.getKetkekkacd());
                Assert.assertEquals(BizDateYM.valueOf("201603"), sV_SibourituRendou.getBosyuuym());
                Assert.assertEquals(C_SeirituKbn.BLNK, sV_SibourituRendou.getSeiritukbn ());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        try (ExDBResults<SV_SibourituRendou> beans =
            srSibourituRendouDao.getSibourituRendousByBosyuuymSeiritukbn(BizDateYM.valueOf("201604"), C_SeirituKbn.NONE)) {

            int iCount = 0;
            Iterator<SV_SibourituRendou> iter = beans.iterator();
            SV_SibourituRendou sV_SibourituRendou = null;
            Map<String,String> map = new HashMap<String,String>();
            map.put($("791112238","11807111129",C_Kykkaksyrui.KETMAE,C_Ketkekkacd.BLNK,BizDateYM.valueOf("201604"),C_SeirituKbn.NONE), "1");
            map.put($("791112246","11807111130",C_Kykkaksyrui.KETMAE,C_Ketkekkacd.BLNK,BizDateYM.valueOf("201604"),C_SeirituKbn.NONE), "1");
            map.put($("791112253","11807111141",C_Kykkaksyrui.KETMAE,C_Ketkekkacd.BLNK,BizDateYM.valueOf("201604"),C_SeirituKbn.NONE), "1");
            while (iter.hasNext()) {

                sV_SibourituRendou = iter.next();
                iCount++;

                if (1 == iCount) {

                    map.remove($(sV_SibourituRendou.getMosno(),sV_SibourituRendou.getSyono(),sV_SibourituRendou.getKykkaksyrui(),sV_SibourituRendou.getKetkekkacd(),
                        sV_SibourituRendou.getBosyuuym(),sV_SibourituRendou.getSeiritukbn ()));

                    continue;
                }

                if (2 == iCount) {

                    map.remove($(sV_SibourituRendou.getMosno(),sV_SibourituRendou.getSyono(),sV_SibourituRendou.getKykkaksyrui(),sV_SibourituRendou.getKetkekkacd(),
                        sV_SibourituRendou.getBosyuuym(),sV_SibourituRendou.getSeiritukbn ()));

                    continue;
                }

                if (3 == iCount) {

                    map.remove($(sV_SibourituRendou.getMosno(),sV_SibourituRendou.getSyono(),sV_SibourituRendou.getKykkaksyrui(),sV_SibourituRendou.getKetkekkacd(),
                        sV_SibourituRendou.getBosyuuym(),sV_SibourituRendou.getSeiritukbn ()));

                    continue;
                }
            }
            Assert.assertEquals(3, iCount);
            assertTrue(map.isEmpty());
        }
    }
}
