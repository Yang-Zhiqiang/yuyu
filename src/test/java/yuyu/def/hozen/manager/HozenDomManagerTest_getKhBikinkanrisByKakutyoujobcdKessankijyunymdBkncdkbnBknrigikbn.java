package yuyu.def.hozen.manager;

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
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 契約保全備金リスト作成（減額）<br />
 * 契約保全備金管理テーブルエンティティリスト(大量)取得　備金コード区分が減額備金のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        try(ExDBResults<IT_KhBikinkanri> exDBResBean = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn("JCD01", BizDate.valueOf(20160215))){

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KhBikinkanri khBikinkanri1 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160215), C_BkncdKbn.GENGK, BizDate.valueOf(20160115), 1);
        khBikinkanri1.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri1.setKbnkeirisegcd(C_Segcd.BLNK);

        hozenDomManager.insert(khBikinkanri1);

        IT_KhBikinkanri khBikinkanri2 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160214), C_BkncdKbn.GENGK, BizDate.valueOf(20160115), 1);
        khBikinkanri2.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri2.setKbnkeirisegcd(C_Segcd.BLNK);

        hozenDomManager.insert(khBikinkanri2);

        IT_KhBikinkanri khBikinkanri3 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160220), C_BkncdKbn.BLNK, BizDate.valueOf(20160115), 1);
        khBikinkanri3.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri3.setKbnkeirisegcd(C_Segcd.BLNK);

        hozenDomManager.insert(khBikinkanri3);

        IT_KhBikinkanri khBikinkanri4 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160220), C_BkncdKbn.GENGK, BizDate.valueOf(20160115), 2);
        khBikinkanri4.setBknrigikbn(C_BknrigiKbn.DEL);
        khBikinkanri4.setKbnkeirisegcd(C_Segcd.BLNK);

        hozenDomManager.insert(khBikinkanri4);

        IT_KhBikinkanri khBikinkanri5 = new IT_KhBikinkanri("11807111129", BizDate.valueOf(20160220), C_BkncdKbn.GENGK, BizDate.valueOf(20160125), 3);
        khBikinkanri5.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri5.setKbnkeirisegcd(C_Segcd.BLNK);

        hozenDomManager.insert(khBikinkanri5);

        IT_KhBikinkanri khBikinkanri6 = new IT_KhBikinkanri("11807111129", BizDate.valueOf(20160220), C_BkncdKbn.GENGK, BizDate.valueOf(20160105), 4);
        khBikinkanri6.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri6.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        hozenDomManager.insert(khBikinkanri6);

        IT_KhBikinkanri khBikinkanri7 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160220), C_BkncdKbn.GENGK, BizDate.valueOf(20160105), 5);
        khBikinkanri7.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri7.setKbnkeirisegcd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);

        hozenDomManager.insert(khBikinkanri7);

        IT_KhBikinkanri khBikinkanri8 = new IT_KhBikinkanri("11807111129", BizDate.valueOf(20160220), C_BkncdKbn.GENGK, BizDate.valueOf(20160125), 6);
        khBikinkanri8.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri8.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        hozenDomManager.insert(khBikinkanri8);

        IT_KhBikinkanri khBikinkanri9 = new IT_KhBikinkanri("11807111129", BizDate.valueOf(20160220), C_BkncdKbn.GENGK, BizDate.valueOf(20160115), 7);
        khBikinkanri9.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri9.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        hozenDomManager.insert(khBikinkanri9);

        IT_KhBikinkanri khBikinkanri10 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160220), C_BkncdKbn.GENGK, BizDate.valueOf(20160125), 8);
        khBikinkanri10.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri10.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        hozenDomManager.insert(khBikinkanri10);

        IT_KhBikinkanri khBikinkanri11 = new IT_KhBikinkanri("11807111130", BizDate.valueOf(20160220), C_BkncdKbn.GENGK, BizDate.valueOf(20160125), 9);
        khBikinkanri11.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri11.setKbnkeirisegcd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);

        hozenDomManager.insert(khBikinkanri11);
    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<IT_KhBikinkanri> exDBResBean = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn("JCD01", BizDate.valueOf(20160228))){

            Assert.assertFalse(exDBResBean.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<IT_KhBikinkanri> exDBResBean = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn("JCD01", BizDate.valueOf(20160215));

        int iCount = 0;
        for (IT_KhBikinkanri khBikinkanri : exDBResBean) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("11807111118", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160215), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160115), khBikinkanri.getBknkktymd());
                Assert.assertEquals(1, khBikinkanri.getRenno().intValue());
                Assert.assertEquals(C_BknrigiKbn.BLNK, khBikinkanri.getBknrigikbn());
                Assert.assertEquals(C_Segcd.BLNK, khBikinkanri.getKbnkeirisegcd());

            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        ExDBResults<IT_KhBikinkanri> exDBResBean = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn("JCD01", BizDate.valueOf(20160220));

        int iCount = 0;
        for (IT_KhBikinkanri khBikinkanri : exDBResBean) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("11807111129", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160125), khBikinkanri.getBknkktymd());
                Assert.assertEquals(3, khBikinkanri.getRenno().intValue());
                Assert.assertEquals(C_BknrigiKbn.BLNK, khBikinkanri.getBknrigikbn());
                Assert.assertEquals(C_Segcd.BLNK, khBikinkanri.getKbnkeirisegcd());

                continue;
            }

            if (2 == iCount) {

                Assert.assertEquals("11807111141", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160105), khBikinkanri.getBknkktymd());
                Assert.assertEquals(5, khBikinkanri.getRenno().intValue());
                Assert.assertEquals(C_BknrigiKbn.BLNK, khBikinkanri.getBknrigikbn());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, khBikinkanri.getKbnkeirisegcd());

                continue;
            }

            if (3 == iCount) {

                Assert.assertEquals("11807111129", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160105), khBikinkanri.getBknkktymd());
                Assert.assertEquals(4, khBikinkanri.getRenno().intValue());
                Assert.assertEquals(C_BknrigiKbn.BLNK, khBikinkanri.getBknrigikbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, khBikinkanri.getKbnkeirisegcd());

                continue;
            }

            if (4 == iCount) {

                Assert.assertEquals("11807111129", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160115), khBikinkanri.getBknkktymd());
                Assert.assertEquals(7, khBikinkanri.getRenno().intValue());
                Assert.assertEquals(C_BknrigiKbn.BLNK, khBikinkanri.getBknrigikbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, khBikinkanri.getKbnkeirisegcd());

                continue;
            }

            if (5 == iCount) {

                Assert.assertEquals("11807111129", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160125), khBikinkanri.getBknkktymd());
                Assert.assertEquals(6, khBikinkanri.getRenno().intValue());
                Assert.assertEquals(C_BknrigiKbn.BLNK, khBikinkanri.getBknrigikbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, khBikinkanri.getKbnkeirisegcd());

                continue;
            }

            if (6 == iCount) {

                Assert.assertEquals("11807111130", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160125), khBikinkanri.getBknkktymd());
                Assert.assertEquals(9, khBikinkanri.getRenno().intValue());
                Assert.assertEquals(C_BknrigiKbn.BLNK, khBikinkanri.getBknrigikbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, khBikinkanri.getKbnkeirisegcd());

                continue;
            }
            if (7 == iCount) {

                Assert.assertEquals("11807111141", khBikinkanri.getSyono());
                Assert.assertEquals(BizDate.valueOf(20160220), khBikinkanri.getKessankijyunymd());
                Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanri.getBkncdkbn());
                Assert.assertEquals(BizDate.valueOf(20160125), khBikinkanri.getBknkktymd());
                Assert.assertEquals(8, khBikinkanri.getRenno().intValue());
                Assert.assertEquals(C_BknrigiKbn.BLNK, khBikinkanri.getBknrigikbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, khBikinkanri.getKbnkeirisegcd());

                continue;
            }
        }
        Assert.assertEquals(7, iCount);
    }

    @Test
    @TestOrder(39)
    @Transactional
    public void testSkippedFilter39(){
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

        try(ExDBResults<IT_KhBikinkanri> exDBResBean = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn("RBG1", BizDate.valueOf(20160220));) {

            int iCount = 0;
            Iterator<IT_KhBikinkanri> iter = exDBResBean.iterator();
            IT_KhBikinkanri iT_KhBikinkanri = null;
            while (iter.hasNext()) {

                iT_KhBikinkanri = iter.next();
                iCount++;
            }
            Assert.assertEquals(7, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){
        BM_RecoveryFilter recoveryFilter1 = new BM_RecoveryFilter("Bz001");
        recoveryFilter1.setRecoveryfilternm("証券番号フィルタ");
        recoveryFilter1.setRecoveryfilterkeykmid1("syono");

        hozenDomManager.insert(recoveryFilter1);

        BT_SkipKey skipKey1 = new BT_SkipKey("A01");
        skipKey1.setKakutyoujobcd("RBG1");
        skipKey1.setTableid("IT_KhBikinkanri");
        skipKey1.setRecoveryfilterid("Bz001");
        skipKey1.setRecoveryfilterkey1("11807111130");

        hozenDomManager.insert(skipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<IT_KhBikinkanri> exDBResBean = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn("RBG1", BizDate.valueOf(20160220));) {

            int iCount = 0;
            Iterator<IT_KhBikinkanri> iter = exDBResBean.iterator();
            IT_KhBikinkanri iT_KhBikinkanri = null;
            while (iter.hasNext()) {

                iT_KhBikinkanri = iter.next();
                assertNotEquals(iT_KhBikinkanri.getSyono(), "11807111130");
                iCount++;
            }
            Assert.assertEquals(6, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){
        BT_SkipKey skipKey1 = new BT_SkipKey("A02");
        skipKey1.setKakutyoujobcd("RBG1");
        skipKey1.setTableid("IT_KhBikinkanri");
        skipKey1.setRecoveryfilterid("Bz001");
        skipKey1.setRecoveryfilterkey1("11807111141");

        hozenDomManager.insert(skipKey1);
    }


    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<IT_KhBikinkanri> exDBResBean = hozenDomManager.
            getKhBikinkanrisByKakutyoujobcdKessankijyunymdBkncdkbnBknrigikbn("RBG1", BizDate.valueOf(20160220));) {

            int iCount = 0;
            Iterator<IT_KhBikinkanri> iter = exDBResBean.iterator();
            IT_KhBikinkanri iT_KhBikinkanri = null;
            while (iter.hasNext()) {

                iT_KhBikinkanri = iter.next();
                assertNotEquals(iT_KhBikinkanri.getSyono(), "11807111130");
                assertNotEquals(iT_KhBikinkanri.getSyono(), "11807111141");
                iCount++;
            }

            Assert.assertEquals(4, iCount);
        }
    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        List<IT_KhBikinkanri> iT_KhBikinkanris = hozenDomManager.getAllKhBikinkanri();
        if(iT_KhBikinkanris.size() > 0){
            hozenDomManager.delete(iT_KhBikinkanris);
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