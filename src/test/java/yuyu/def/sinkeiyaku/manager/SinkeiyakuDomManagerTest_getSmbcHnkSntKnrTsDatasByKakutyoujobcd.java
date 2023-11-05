package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSmbcHnkSntKnrTsDatasByKakutyoujobcd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcHnkSntKnrTsDatasByKakutyoujobcd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcHnkSntKnrTsDatasByKakutyoujobcd("RSM5")){
            Assert.assertFalse(exDBResults.iterator().hasNext());}

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112238");
        syoriCTL1.setSkeijimukbn(C_SkeijimuKbn.valueOf("00"));
        syoriCTL1.setMosnrkumu(C_UmuKbn.valueOf("0"));

        sinkeiyakuDomManager.insert(syoriCTL1);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanriSsRireki());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }


    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcHnkSntKnrTsDatasByKakutyoujobcd("RSM5")){
            Assert.assertFalse(exDBResults.iterator().hasNext());}
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanriSsRireki());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSyono("11807111118");
        syoriCTL1.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL1.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL1.setGyoumuKousinTime("20160411");

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(1);

        HT_MosDairiten mosDairiten2 = syoriCTL1.createMosDairiten();
        mosDairiten2.setRenno(2);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSyono("11807111118");
        syoriCTL2.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL2.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL2.setGyoumuKousinTime("20160410");

        HT_MosDairiten mosDairiten3 = syoriCTL2.createMosDairiten();
        mosDairiten3.setRenno(1);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSyono("11807111118");
        syoriCTL3.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL3.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL3.setGyoumuKousinTime("20160409");

        HT_MosDairiten mosDairiten4 = syoriCTL3.createMosDairiten();
        mosDairiten4.setRenno(1);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("791112253");
        syoriCTL4.setSyono("11807111118");
        syoriCTL4.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL4.setMosnrkumu(C_UmuKbn.valueOf("0"));
        syoriCTL4.setGyoumuKousinTime("20160411");

        HT_MosDairiten mosDairiten5 = syoriCTL4.createMosDairiten();
        mosDairiten5.setRenno(1);

        HT_MosKihon mosKihon4 = syoriCTL4.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("791112261");
        syoriCTL5.setSyono("11807111129");
        syoriCTL5.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL5.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL5.setGyoumuKousinTime("20160411");

        HT_MosDairiten mosDairiten6 = syoriCTL5.createMosDairiten();
        mosDairiten6.setRenno(1);

        HT_MosKihon mosKihon5 = syoriCTL5.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("791112279");
        syoriCTL6.setSyono("11807111118");
        syoriCTL6.setSkeijimukbn(C_SkeijimuKbn.valueOf("03"));
        syoriCTL6.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL6.setGyoumuKousinTime("20160411");

        HT_MosDairiten mosDairiten7 = syoriCTL6.createMosDairiten();
        mosDairiten7.setRenno(1);

        HT_MosKihon mosKihon6 = syoriCTL6.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("791112287");
        syoriCTL7.setSyono("11807111118");
        syoriCTL7.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL7.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL7.setGyoumuKousinTime("20160411");

        HT_MosDairiten mosDairiten8 = syoriCTL7.createMosDairiten();
        mosDairiten8.setRenno(1);

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("791112295");
        syoriCTL8.setSyono("11807111118");
        syoriCTL8.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL8.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL8.setGyoumuKousinTime("20160411");

        HT_MosKihon mosKihon7 = syoriCTL8.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL8);

        HT_SyoriCTL syoriCTL10 = new HT_SyoriCTL("791112337");
        syoriCTL10.setSyono("11807111141");
        syoriCTL10.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL10.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL10.setGyoumuKousinTime("20160411");

        HT_MosDairiten mosDairiten12 = syoriCTL10.createMosDairiten();
        mosDairiten12.setRenno(1);

        HT_MosKihon mosKihon12 = syoriCTL10.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL10);

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki1 = new HT_SmbcStyKanriSsRireki("11807111118");
        smbcStyKanriSsRireki1.setSyrctrltblkostime("20160410");
        smbcStyKanriSsRireki1.setRenkanryoflg(0);

        sinkeiyakuDomManager.insert(smbcStyKanriSsRireki1);

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki2 = new HT_SmbcStyKanriSsRireki("11807111129");
        smbcStyKanriSsRireki2.setSyrctrltblkostime("20160410");
        smbcStyKanriSsRireki2.setRenkanryoflg(1);

        sinkeiyakuDomManager.insert(smbcStyKanriSsRireki2);

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcHnkSntKnrTsDatasByKakutyoujobcd("RSM5");

        int iCount = 0;
        for (HT_SyoriCTL syoriCTL : exDBResults) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112220", syoriCTL.getMosno());
            }
        }
        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanriSsRireki());

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("791112220");
        syoriCTL1.setSyono("11807111118");
        syoriCTL1.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL1.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL1.setGyoumuKousinTime("20160411");

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(1);

        HT_MosKihon mosKihon1 = syoriCTL1.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("791112238");
        syoriCTL2.setSyono("11807111118");
        syoriCTL2.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL2.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL2.setGyoumuKousinTime("20160412");

        HT_MosDairiten mosDairiten2 = syoriCTL2.createMosDairiten();
        mosDairiten2.setRenno(1);

        HT_MosKihon mosKihon2 = syoriCTL2.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("791112246");
        syoriCTL3.setSyono("11807111118");
        syoriCTL3.setSkeijimukbn(C_SkeijimuKbn.valueOf("02"));
        syoriCTL3.setMosnrkumu(C_UmuKbn.valueOf("1"));
        syoriCTL3.setGyoumuKousinTime("20160413");

        HT_MosDairiten mosDairiten3 = syoriCTL3.createMosDairiten();
        mosDairiten3.setRenno(1);

        HT_MosKihon mosKihon3 = syoriCTL3.createMosKihon();

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki1 = new HT_SmbcStyKanriSsRireki("11807111118");
        smbcStyKanriSsRireki1.setSyrctrltblkostime("20160410");
        smbcStyKanriSsRireki1.setRenkanryoflg(0);

        sinkeiyakuDomManager.insert(smbcStyKanriSsRireki1);
    }

    @Test
    @TestOrder(31)
    public void normal31() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("791112220"), "1");
        datamap.put($("791112238"), "1");
        datamap.put($("791112246"), "1");


        try(ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcHnkSntKnrTsDatasByKakutyoujobcd("RSM5")) {
            int iCount = 0;
            Iterator<HT_SyoriCTL> bean = exDBResults.iterator();
            HT_SyoriCTL syoriCTL = null;

            while (bean.hasNext()) {

                syoriCTL = bean.next();
                datamap.remove($(
                    syoriCTL.getMosno()));

                iCount++;
            }
            Assert.assertEquals(3, iCount);
            Assert.assertTrue(datamap.isEmpty());
        }
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter1() {

        int iCount = 0;
        try(ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcHnkSntKnrTsDatasByKakutyoujobcd("RSM5")){
            for(HT_SyoriCTL syoriCTL : exDBResults){

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BT_SkipKey skipKey1 = new BT_SkipKey("A03");
        skipKey1.setKakutyoujobcd("RSM5");
        skipKey1.setTableid("HT_SyoriCTL");
        skipKey1.setRecoveryfilterid("Sk001");
        skipKey1.setRecoveryfilterkey1("791112246");

        sinkeiyakuDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Sk001");
        recoveryFilter1.setRecoveryfilternm("申込番号フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("mosno");

        sinkeiyakuDomManager.insert(recoveryFilter1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcHnkSntKnrTsDatasByKakutyoujobcd("RSM5")){
            for(HT_SyoriCTL syoriCTL : exDBResults){
                assertNotEquals(syoriCTL.getMosno(), "791112246");

                iCount++;
            }
            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey skipKey2 = new BT_SkipKey("A04");
        skipKey2.setKakutyoujobcd("RSM5");
        skipKey2.setTableid("HT_SyoriCTL");
        skipKey2.setRecoveryfilterid("Sk001");
        skipKey2.setRecoveryfilterkey1("791112238");

        sinkeiyakuDomManager.insert(skipKey2);

    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        int iCount = 0;
        try(ExDBResults<HT_SyoriCTL> exDBResults = sinkeiyakuDomManager.getSmbcHnkSntKnrTsDatasByKakutyoujobcd("RSM5")){
            for(HT_SyoriCTL syoriCTL : exDBResults){
                assertNotEquals(syoriCTL.getMosno(), "791112246");
                assertNotEquals(syoriCTL.getMosno(), "791112238");

                iCount++;
            }
            assertEquals(1, iCount);
        }
    }
}