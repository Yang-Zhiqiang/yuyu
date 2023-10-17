package yuyu.def.siharai.manager;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SiharaiDomManagerクラスの、<br />
 * getSiBikinkanrisByKakutyoujobcdItems() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanrisByKakutyoujobcdItems {

    @Inject
    SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        try (ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItems("RCA0", BizDate.valueOf(20160823), C_BknrigiKbn.DEL)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        insertSubData();

    }


    @Transactional
    public static void insertSubData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        JT_SiBikinkanri siBikinkanri1 = new JT_SiBikinkanri("10000000001", "11807111118", BizDate.valueOf(20160823),
            C_BkncdKbn.BLNK, BizDate.valueOf(20160808), "M101");
        siBikinkanri1.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri1.setCalckijyunymd(BizDate.valueOf(20160808));
        siBikinkanri1.setKbnkeirisegcd(C_Segcd.BLNK);

        siharaiDomManager.insert(siBikinkanri1);

        JT_SiBikinkanri siBikinkanri2 = new JT_SiBikinkanri("10000000001", "11807111118", BizDate.valueOf(20160822),
            C_BkncdKbn.BLNK, BizDate.valueOf(20160808), "M101");
        siBikinkanri2.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri2.setCalckijyunymd(BizDate.valueOf(20160808));
        siBikinkanri2.setKbnkeirisegcd(C_Segcd.BLNK);

        siharaiDomManager.insert(siBikinkanri2);

        JT_SiBikinkanri siBikinkanri3 = new JT_SiBikinkanri("10000000002", "11807111118", BizDate.valueOf(20160823),
            C_BkncdKbn.BLNK, BizDate.valueOf(20160808), "M101");
        siBikinkanri3.setBknrigikbn(C_BknrigiKbn.DEL);
        siBikinkanri3.setCalckijyunymd(BizDate.valueOf(20160808));
        siBikinkanri3.setKbnkeirisegcd(C_Segcd.BLNK);

        siharaiDomManager.insert(siBikinkanri3);

        JT_SiBikinkanri siBikinkanri4 = new JT_SiBikinkanri("10000000001", "11807111118", BizDate.valueOf(20160920),
            C_BkncdKbn.GENGK, BizDate.valueOf(20160901), "M101");
        siBikinkanri4.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri4.setCalckijyunymd(BizDate.valueOf(20160801));
        siBikinkanri4.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        siharaiDomManager.insert(siBikinkanri4);

        JT_SiBikinkanri siBikinkanri5 = new JT_SiBikinkanri("10000000002", "11807111118", BizDate.valueOf(20160920),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20160901), "M102");
        siBikinkanri5.setBknrigikbn(C_BknrigiKbn.DEL);
        siBikinkanri5.setCalckijyunymd(BizDate.valueOf(20160801));
        siBikinkanri5.setKbnkeirisegcd(C_Segcd.BLNK);

        siharaiDomManager.insert(siBikinkanri5);

        JT_SiBikinkanri siBikinkanri6 = new JT_SiBikinkanri("10000000003", "11807111118", BizDate.valueOf(20160920),
            C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160903), "M103");
        siBikinkanri6.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri6.setCalckijyunymd(BizDate.valueOf(20160801));
        siBikinkanri6.setKbnkeirisegcd(C_Segcd.BLNK);

        siharaiDomManager.insert(siBikinkanri6);

        JT_SiBikinkanri siBikinkanri7 = new JT_SiBikinkanri("10000000004", "11807111118", BizDate.valueOf(20160920),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20160901), "M104");
        siBikinkanri7.setBknrigikbn(C_BknrigiKbn.DEL);
        siBikinkanri7.setCalckijyunymd(BizDate.valueOf(20160801));
        siBikinkanri7.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        siharaiDomManager.insert(siBikinkanri7);

        JT_SiBikinkanri siBikinkanri8 = new JT_SiBikinkanri("10000000005", "11807111118", BizDate.valueOf(20160920),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20160901), "M105");
        siBikinkanri8.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri8.setCalckijyunymd(BizDate.valueOf(20160803));
        siBikinkanri8.setKbnkeirisegcd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);

        siharaiDomManager.insert(siBikinkanri8);

        JT_SiBikinkanri siBikinkanri9 = new JT_SiBikinkanri("10000000006", "11807111118", BizDate.valueOf(20160920),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20160903), "M106");
        siBikinkanri9.setBknrigikbn(C_BknrigiKbn.DEL);
        siBikinkanri9.setCalckijyunymd(BizDate.valueOf(20160801));
        siBikinkanri9.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        siharaiDomManager.insert(siBikinkanri9);

        JT_SiBikinkanri siBikinkanri10 = new JT_SiBikinkanri("10000000007", "11807111130", BizDate.valueOf(20160920),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20160902), "M107");
        siBikinkanri10.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri10.setCalckijyunymd(BizDate.valueOf(20160801));
        siBikinkanri10.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        siharaiDomManager.insert(siBikinkanri10);

        JT_SiBikinkanri siBikinkanri11 = new JT_SiBikinkanri("10000000008", "11807111118", BizDate.valueOf(20160920),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20160903), "M108");
        siBikinkanri11.setBknrigikbn(C_BknrigiKbn.DEL);
        siBikinkanri11.setCalckijyunymd(BizDate.valueOf(20160803));
        siBikinkanri11.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        siharaiDomManager.insert(siBikinkanri11);

        JT_SiBikinkanri siBikinkanri12 = new JT_SiBikinkanri("10000000009", "11807111118", BizDate.valueOf(20160920),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20160903), "M109");
        siBikinkanri12.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri12.setCalckijyunymd(BizDate.valueOf(20160802));
        siBikinkanri12.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        siharaiDomManager.insert(siBikinkanri12);

        JT_SiBikinkanri siBikinkanri13 = new JT_SiBikinkanri("10000000010", "11807111130", BizDate.valueOf(20160920),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20160903), "M110");
        siBikinkanri13.setBknrigikbn(C_BknrigiKbn.DEL);
        siBikinkanri13.setCalckijyunymd(BizDate.valueOf(20160803));
        siBikinkanri13.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        siharaiDomManager.insert(siBikinkanri13);

        JT_SiBikinkanri siBikinkanri14 = new JT_SiBikinkanri("10000000011", "11807111129", BizDate.valueOf(20160920),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20160903), "M111");
        siBikinkanri14.setBknrigikbn(C_BknrigiKbn.BLNK);
        siBikinkanri14.setCalckijyunymd(BizDate.valueOf(20160803));
        siBikinkanri14.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        siharaiDomManager.insert(siBikinkanri14);
    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItems("RCA0", BizDate.valueOf(20160822), C_BknrigiKbn.BLNK)) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try(ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItems("RCA0", BizDate.valueOf(20160823), C_BknrigiKbn.DEL)) {

            Iterator<JT_SiBikinkanri> iter = exDBResults.iterator();
            JT_SiBikinkanri siBikinkanri = null;
            int iCount = 0;
            while(iter.hasNext()) {

                iCount++;
                siBikinkanri=iter.next();

                Assert.assertEquals("10000000001", siBikinkanri.getSkno());
                Assert.assertEquals("11807111118", siBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160823), siBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.BLNK, siBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160808), siBikinkanri.getBknkktymd());
                Assert.assertEquals("M101", siBikinkanri.getKyuuhucd());
            }

            Assert.assertEquals(1, iCount);
        }
    }
    @Test
    @TestOrder(30)
    public void normal2() {

        try(ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItems("RCA0", BizDate.valueOf(20160920), C_BknrigiKbn.ADD)) {

            Iterator<JT_SiBikinkanri> iter = exDBResults.iterator();
            JT_SiBikinkanri siBikinkanri = null;
            int iCount = 0;
            while(iter.hasNext()) {

                iCount++;
                siBikinkanri=iter.next();

                if (1 == iCount) {
                    Assert.assertEquals("10000000001", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.GENGK, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160901), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M101", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160801), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (2 == iCount) {
                    Assert.assertEquals("10000000003", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.KAIYAKU, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160903), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M103", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160801), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.BLNK, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (3 == iCount) {
                    Assert.assertEquals("10000000002", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160901), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M102", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160801), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.BLNK, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (4 == iCount) {
                    Assert.assertEquals("10000000005", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160901), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M105", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160803), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (5 == iCount) {
                    Assert.assertEquals("10000000004", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160901), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M104", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160801), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (6 == iCount) {
                    Assert.assertEquals("10000000007", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111130", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160902), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M107", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160801), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (7 == iCount) {
                    Assert.assertEquals("10000000006", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160903), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M106", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160801), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (8 == iCount) {
                    Assert.assertEquals("10000000009", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160903), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M109", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160802), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (9 == iCount) {
                    Assert.assertEquals("10000000008", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111118", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160903), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M108", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160803), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (10 == iCount) {
                    Assert.assertEquals("10000000011", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111129", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160903), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M111", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160803), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                if (11 == iCount) {
                    Assert.assertEquals("10000000010", siBikinkanri.getSkno());
                    Assert.assertEquals("11807111130", siBikinkanri.getSyono());
                    Assert.assertEquals(BizDate.valueOf(20160920), siBikinkanri.getKessankijyunymd());
                    Assert.assertEquals(C_BkncdKbn.SIBOUUKETUKE, siBikinkanri.getBkncdkbn());
                    Assert.assertEquals(BizDate.valueOf(20160903), siBikinkanri.getBknkktymd());
                    Assert.assertEquals("M110", siBikinkanri.getKyuuhucd());
                    Assert.assertEquals(BizDate.valueOf(20160803), siBikinkanri.getCalckijyunymd());
                    Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, siBikinkanri.getKbnkeirisegcd());

                    continue;
                }

                Assert.assertEquals(11, iCount);
            }
        }
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BT_SkipKey> bT_SkipKeys = bizDomManager.getAllSkipKey();
        if(bT_SkipKeys.size() > 0){
            bizDomManager.delete(bT_SkipKeys);
        }
        List<BM_RecoveryFilter> bM_RecoveryFilters = bizDomManager.getAllRecoveryFilter();
        if(bM_RecoveryFilters.size() > 0){
            bizDomManager.delete(bM_RecoveryFilters);
        }
    }
    @Test
    @TestOrder(40)
    @Transactional
    public void testSkippedFilter40() {

        int iCount = 0;
        try(ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItems("RCA0", BizDate.valueOf(20160920), C_BknrigiKbn.ADD)){
            for(JT_SiBikinkanri siBikinkanri : exDBResults){

                iCount++;
            }

            Assert.assertEquals(11, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50() {
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Si001");
        recoveryFilter1.setRecoveryfilternm("請求基本フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("syono");
        recoveryFilter1.setRecoveryfilterkeykmid2("skno");

        siharaiDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("900001");
        skipKey1.setKakutyoujobcd("RCA0");
        skipKey1.setTableid("JT_SiBikinkanri");
        skipKey1.setRecoveryfilterid("Si001");
        skipKey1.setRecoveryfilterkey1("11807111130");
        skipKey1.setRecoveryfilterkey2("10000000010");

        siharaiDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){


        try(ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItems("RCA0", BizDate.valueOf(20160920), C_BknrigiKbn.ADD)){
            int iCount = 0;
            for(JT_SiBikinkanri siBikinkanri : exDBResults){

                boolean result1 =
                    (siBikinkanri.getSyono().equals("11807111130")) &&
                    (siBikinkanri.getSkno().equals("10000000010"));

                assertFalse(result1);

                iCount++;
            }
            Assert.assertEquals(10, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60() {
        BT_SkipKey skipKey2 = new BT_SkipKey("900002");
        skipKey2.setKakutyoujobcd("RCA0");
        skipKey2.setTableid("JT_SiBikinkanri");
        skipKey2.setRecoveryfilterid("Si001");
        skipKey2.setRecoveryfilterkey1("11807111129");
        skipKey2.setRecoveryfilterkey2("10000000011");

        siharaiDomManager.insert(skipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){


        try(ExDBResults<JT_SiBikinkanri> exDBResults =
            siharaiDomManager.getSiBikinkanrisByKakutyoujobcdItems("RCA0", BizDate.valueOf(20160920), C_BknrigiKbn.ADD)){

            int iCount = 0;
            for(JT_SiBikinkanri siBikinkanri : exDBResults){

                boolean result1 =
                    (siBikinkanri.getSyono().equals("11807111130")) &&
                    (siBikinkanri.getSkno().equals("10000000010"));

                boolean result2 =
                    (siBikinkanri.getSyono().equals("11807111129")) &&
                    (siBikinkanri.getSkno().equals("10000000011"));

                assertFalse(result1 || result2);

                iCount++;
            }
            Assert.assertEquals(9, iCount);
        }
    }

    @Transactional
    public static void deleteTestSubData() {
        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);
        List<JT_SiBikinkanri> jT_SiBikinkanris = siharaiDomManager.getAllSiBikinkanri();
        if(jT_SiBikinkanris.size() > 0){
            siharaiDomManager.delete(jT_SiBikinkanris);
        }

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BT_SkipKey> bT_SkipKeys = bizDomManager.getAllSkipKey();
        if(bT_SkipKeys.size() > 0){
            bizDomManager.delete(bT_SkipKeys);
        }
        List<BM_RecoveryFilter> bM_RecoveryFilters = bizDomManager.getAllRecoveryFilter();
        if(bM_RecoveryFilters.size() > 0){
            bizDomManager.delete(bM_RecoveryFilters);
        }
    }



    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}
