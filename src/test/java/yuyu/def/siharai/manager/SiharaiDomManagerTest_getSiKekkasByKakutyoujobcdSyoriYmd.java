package yuyu.def.siharai.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiKekkasByKakutyoujobcdSyoriYmd() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class SiharaiDomManagerTest_getSiKekkasByKakutyoujobcdSyoriYmd {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        try (ExDBResults<JT_SiKekka> beans =siharaiDomManager.getSiKekkasByKakutyoujobcdSyoriYmd("RBA5", BizDate.valueOf("20160802"))) {

            Assert.assertFalse(beans.iterator().hasNext());}

        JT_SiKekka siKekka1 = new JT_SiKekka(C_ShiharaikekkadataKbn.valueOf("3"), "11807111130", "A100", 10, 1, C_SyutkKbn.valueOf("1"));
        siKekka1.setSyoriYmd(BizDate.valueOf("20160803"));

        siharaiDomManager.insert(siKekka1);

        JT_SiKekka siKekka2 = new JT_SiKekka(C_ShiharaikekkadataKbn.valueOf("3"), "11807111129", "A100", 10, 1, C_SyutkKbn.valueOf("1"));
        siKekka2.setSyoriYmd(BizDate.valueOf("20160803"));

        siharaiDomManager.insert(siKekka2);

        JT_SiKekka siKekka3 = new JT_SiKekka(C_ShiharaikekkadataKbn.valueOf("3"), "11807111118", "A100", 10, 1, C_SyutkKbn.valueOf("0"));
        siKekka3.setSyoriYmd(BizDate.valueOf("20160803"));

        siharaiDomManager.insert(siKekka3);

        JT_SiKekka siKekka4 = new JT_SiKekka(C_ShiharaikekkadataKbn.valueOf("3"), "11807111118", "A100", 10, 1, C_SyutkKbn.valueOf("1"));
        siKekka4.setSyoriYmd(BizDate.valueOf("20160803"));

        siharaiDomManager.insert(siKekka4);

        JT_SiKekka siKekka5 = new JT_SiKekka(C_ShiharaikekkadataKbn.valueOf("1"), "11807111118", "A100", 10, 1, C_SyutkKbn.valueOf("2"));
        siKekka5.setSyoriYmd(BizDate.valueOf("20160803"));

        siharaiDomManager.insert(siKekka5);

        JT_SiKekka siKekka6 = new JT_SiKekka(C_ShiharaikekkadataKbn.valueOf("2"), "11807111118", "A100", 10, 1, C_SyutkKbn.valueOf("2"));
        siKekka6.setSyoriYmd(BizDate.valueOf("20160803"));

        siharaiDomManager.insert(siKekka6);

        JT_SiKekka siKekka7 = new JT_SiKekka(C_ShiharaikekkadataKbn.valueOf("3"), "11807111118", "A100", 10, 1, C_SyutkKbn.valueOf("2"));
        siKekka7.setSyoriYmd(BizDate.valueOf("20160803"));

        siharaiDomManager.insert(siKekka7);

        JT_SiKekka siKekka8 = new JT_SiKekka(C_ShiharaikekkadataKbn.valueOf("1"), "11807111118", "A100", 10, 1, C_SyutkKbn.valueOf("1"));
        siKekka8.setSyoriYmd(BizDate.valueOf("20160802"));

        siharaiDomManager.insert(siKekka8);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        siharaiDomManager.delete(siharaiDomManager.getAllSiKekka());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult(){

        ExDBResults<JT_SiKekka> beans = siharaiDomManager.getSiKekkasByKakutyoujobcdSyoriYmd("RBA5", BizDate.valueOf("20160801"));

        int iCount = 0;
        for (JT_SiKekka siKekka : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void normal1(){

        ExDBResults<JT_SiKekka> beans = siharaiDomManager.getSiKekkasByKakutyoujobcdSyoriYmd("RBA5", BizDate.valueOf("20160802"));

        int iCount = 0;
        for (JT_SiKekka siKekka : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_ShiharaikekkadataKbn.SYOUMETU, siKekka.getShiharaikekkadatakbn());
                Assert.assertEquals("11807111118", siKekka.getSyono());
                Assert.assertEquals("A100", siKekka.getSyouhncd());
                Assert.assertEquals(10, siKekka.getSyouhnsdno().intValue());
                Assert.assertEquals(1, siKekka.getKyksyouhnrenno().intValue());
                Assert.assertEquals(C_SyutkKbn.SYU, siKekka.getSyutkkbn());
            }
        }
        Assert.assertEquals(1, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal2(){

        ExDBResults<JT_SiKekka> beans = siharaiDomManager.getSiKekkasByKakutyoujobcdSyoriYmd("RBA5", BizDate.valueOf("20160803"));

        int iCount = 0;
        for (JT_SiKekka siKekka : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals(C_ShiharaikekkadataKbn.TSNGNDTYOUKA, siKekka.getShiharaikekkadatakbn());
                Assert.assertEquals("11807111118", siKekka.getSyono());
                Assert.assertEquals("A100", siKekka.getSyouhncd());
                Assert.assertEquals(10, siKekka.getSyouhnsdno().intValue());
                Assert.assertEquals(1, siKekka.getKyksyouhnrenno().intValue());
                Assert.assertEquals(C_SyutkKbn.TK, siKekka.getSyutkkbn());
            }

            if (2 == iCount) {
                Assert.assertEquals(C_ShiharaikekkadataKbn.PMEN, siKekka.getShiharaikekkadatakbn());
                Assert.assertEquals("11807111118", siKekka.getSyono());
                Assert.assertEquals("A100", siKekka.getSyouhncd());
                Assert.assertEquals(10, siKekka.getSyouhnsdno().intValue());
                Assert.assertEquals(1, siKekka.getKyksyouhnrenno().intValue());
                Assert.assertEquals(C_SyutkKbn.TK, siKekka.getSyutkkbn());
            }

            if (3 == iCount) {
                Assert.assertEquals(C_ShiharaikekkadataKbn.SYOUMETU, siKekka.getShiharaikekkadatakbn());
                Assert.assertEquals("11807111118", siKekka.getSyono());
                Assert.assertEquals("A100", siKekka.getSyouhncd());
                Assert.assertEquals(10, siKekka.getSyouhnsdno().intValue());
                Assert.assertEquals(1, siKekka.getKyksyouhnrenno().intValue());
                Assert.assertEquals(C_SyutkKbn.TK, siKekka.getSyutkkbn());
            }

            if (4 == iCount) {
                Assert.assertEquals(C_ShiharaikekkadataKbn.TSNGNDTYOUKA, siKekka.getShiharaikekkadatakbn());
                Assert.assertEquals("11807111118", siKekka.getSyono());
                Assert.assertEquals("A100", siKekka.getSyouhncd());
                Assert.assertEquals(10, siKekka.getSyouhnsdno().intValue());
                Assert.assertEquals(1, siKekka.getKyksyouhnrenno().intValue());
                Assert.assertEquals(C_SyutkKbn.SYU, siKekka.getSyutkkbn());
            }

            if (5 == iCount) {
                Assert.assertEquals(C_ShiharaikekkadataKbn.TSNGNDTYOUKA, siKekka.getShiharaikekkadatakbn());
                Assert.assertEquals("11807111118", siKekka.getSyono());
                Assert.assertEquals("A100", siKekka.getSyouhncd());
                Assert.assertEquals(10, siKekka.getSyouhnsdno().intValue());
                Assert.assertEquals(1, siKekka.getKyksyouhnrenno().intValue());
                Assert.assertEquals(C_SyutkKbn.NONE, siKekka.getSyutkkbn());
            }

            if (6 == iCount) {
                Assert.assertEquals(C_ShiharaikekkadataKbn.TSNGNDTYOUKA, siKekka.getShiharaikekkadatakbn());
                Assert.assertEquals("11807111129", siKekka.getSyono());
                Assert.assertEquals("A100", siKekka.getSyouhncd());
                Assert.assertEquals(10, siKekka.getSyouhnsdno().intValue());
                Assert.assertEquals(1, siKekka.getKyksyouhnrenno().intValue());
                Assert.assertEquals(C_SyutkKbn.SYU, siKekka.getSyutkkbn());
            }

            if (7 == iCount) {
                Assert.assertEquals(C_ShiharaikekkadataKbn.TSNGNDTYOUKA, siKekka.getShiharaikekkadatakbn());
                Assert.assertEquals("11807111130", siKekka.getSyono());
                Assert.assertEquals("A100", siKekka.getSyouhncd());
                Assert.assertEquals(10, siKekka.getSyouhnsdno().intValue());
                Assert.assertEquals(1, siKekka.getKyksyouhnrenno().intValue());
                Assert.assertEquals(C_SyutkKbn.SYU, siKekka.getSyutkkbn());
            }
        }
        Assert.assertEquals(7, iCount);
    }

    @Test
    @TestOrder(29)
    @Transactional
    public void testSkippedFilter29(){
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String jpql2 = "delete from BT_SkipKey as q1 ";
        em.createJPQL(jpql2).executeUpdate();

        String jpql3 = "delete from BM_RecoveryFilter as q1";
        em.createJPQL(jpql3).executeUpdate();
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testSkippedFilter30() {

        int iCount = 0;
        try(ExDBResults<JT_SiKekka> beans =siharaiDomManager.getSiKekkasByKakutyoujobcdSyoriYmd("RBA5", BizDate.valueOf("20160803"))){
            for(JT_SiKekka siKekka : beans){

                iCount++;
            }

            Assert.assertEquals(7, iCount);
        }
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40(){
        BT_SkipKey skipKey1 = new BT_SkipKey("A03");
        skipKey1.setKakutyoujobcd("RBA5");
        skipKey1.setTableid("JT_SiKekka");
        skipKey1.setRecoveryfilterid("Bz001");
        skipKey1.setRecoveryfilterkey1("11807111130");

        siharaiDomManager.insert(skipKey1);

        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz001");
        recoveryFilter1.setRecoveryfilternm("証券番号フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("syono");

        siharaiDomManager.insert(recoveryFilter1);
    }
    @Test
    @TestOrder(41)
    @Transactional
    public void testSkippedFilter41(){

        int iCount = 0;
        try(ExDBResults<JT_SiKekka> beans =siharaiDomManager.getSiKekkasByKakutyoujobcdSyoriYmd("RBA5", BizDate.valueOf("20160803"))){
            for(JT_SiKekka siKekka : beans){
                assertNotEquals(siKekka.getSyono(), "11807111130");

                iCount++;
            }
            Assert.assertEquals(6, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BT_SkipKey skipKey2 = new BT_SkipKey("A04");
        skipKey2.setKakutyoujobcd("RBA5");
        skipKey2.setTableid("JT_SiKekka");
        skipKey2.setRecoveryfilterid("Bz001");
        skipKey2.setRecoveryfilterkey1("11807111129");

        siharaiDomManager.insert(skipKey2);

    }

    @Test
    @TestOrder(51)
    public void testSkippedFilter51(){

        int iCount = 0;
        try(ExDBResults<JT_SiKekka> beans =siharaiDomManager.getSiKekkasByKakutyoujobcdSyoriYmd("RBA5", BizDate.valueOf("20160803"))){
            for(JT_SiKekka siKekka : beans){
                assertNotEquals(siKekka.getSyono(), "11807111130");
                assertNotEquals(siKekka.getSyono(), "11807111129");

                iCount++;
            }
            assertEquals(5, iCount);
        }
    }
}
