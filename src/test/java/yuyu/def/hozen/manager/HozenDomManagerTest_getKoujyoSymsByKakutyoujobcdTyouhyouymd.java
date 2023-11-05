package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.classification.C_KoujyosyoumeisakuseisyoriKbn;
import yuyu.def.db.entity.BM_RecoveryFilter;
import yuyu.def.db.entity.BT_SkipKey;
import yuyu.def.db.entity.IT_KoujyoSym;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 控除証明書Ｆ作成<br />
 * 控除証明書テーブルエンティティリスト(大量)取得(拡張ジョブコード、帳票作成日)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKoujyoSymsByKakutyoujobcdTyouhyouymd {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        try(ExDBResults<IT_KoujyoSym> iT_KoujyoSymResults = hozenDomManager.getKoujyoSymsByKakutyoujobcdTyouhyouymd("RBTA", BizDate.valueOf(20160331))){

            Assert.assertFalse(iT_KoujyoSymResults.iterator().hasNext());
        }

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KoujyoSym koujyoSym1 = kykKihon1.createKoujyoSym();
        koujyoSym1.setNendo("2016");
        koujyoSym1.setTyouhyouymd(BizDate.valueOf(20160331));
        koujyoSym1.setRenno(10);
        koujyoSym1.setKjsmsakuseisyorikbn(C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_GAIBU);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KoujyoSym koujyoSym2 = kykKihon2.createKoujyoSym();
        koujyoSym2.setNendo("2016");
        koujyoSym2.setTyouhyouymd(BizDate.valueOf(20160330));
        koujyoSym2.setRenno(20);
        koujyoSym2.setKjsmsakuseisyorikbn(C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_GAIBU);

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KoujyoSym koujyoSym3 = kykKihon3.createKoujyoSym();
        koujyoSym3.setNendo("2016");
        koujyoSym3.setTyouhyouymd(BizDate.valueOf(20160330));
        koujyoSym3.setRenno(30);
        koujyoSym3.setKjsmsakuseisyorikbn(C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_GAIBU);

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KoujyoSym koujyoSym4 = kykKihon4.createKoujyoSym();
        koujyoSym4.setNendo("2016");
        koujyoSym4.setTyouhyouymd(BizDate.valueOf(20160330));
        koujyoSym4.setRenno(40);
        koujyoSym4.setKjsmsakuseisyorikbn(C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_GAIBU);

        IT_KoujyoSym koujyoSym5 = kykKihon4.createKoujyoSym();
        koujyoSym5.setNendo("2016");
        koujyoSym5.setTyouhyouymd(BizDate.valueOf(20160330));
        koujyoSym5.setRenno(50);
        koujyoSym5.setKjsmsakuseisyorikbn(C_KoujyosyoumeisakuseisyoriKbn.HOKENSYOUKEN);

        IT_KoujyoSym koujyoSym6 = kykKihon4.createKoujyoSym();
        koujyoSym6.setNendo("2016");
        koujyoSym6.setTyouhyouymd(BizDate.valueOf(20160329));
        koujyoSym6.setRenno(60);
        koujyoSym6.setKjsmsakuseisyorikbn(C_KoujyosyoumeisakuseisyoriKbn.KOUJYOSYOUMEISYO_GAIBU);

        hozenDomManager.insert(kykKihon4);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        em.createJPQL("delete from BT_SkipKey").executeUpdate();
        em.createJPQL("delete from BM_RecoveryFilter").executeUpdate();
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try(ExDBResults<IT_KoujyoSym> iT_KoujyoSymResults = hozenDomManager.getKoujyoSymsByKakutyoujobcdTyouhyouymd("RBTA", BizDate.valueOf(20160401))){

            Assert.assertFalse(iT_KoujyoSymResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try(ExDBResults<IT_KoujyoSym> iT_KoujyoSymResults = hozenDomManager.getKoujyoSymsByKakutyoujobcdTyouhyouymd("RBTA", BizDate.valueOf(20160331))){

            int iCount = 0;
            Iterator<IT_KoujyoSym> iter = iT_KoujyoSymResults.iterator();
            IT_KoujyoSym iT_KoujyoSym = null;
            while (iter.hasNext()) {

                iT_KoujyoSym = iter.next();
                iCount++;

                Assert.assertEquals("01", iT_KoujyoSym.getKbnkey());
                Assert.assertEquals("11807111118", iT_KoujyoSym.getSyono());
                Assert.assertEquals("2016", iT_KoujyoSym.getNendo());
                Assert.assertEquals(BizDate.valueOf(20160331), iT_KoujyoSym.getTyouhyouymd());
                Assert.assertEquals(Integer.valueOf(10), iT_KoujyoSym.getRenno());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> KoujyoSymMap = new HashMap<String, String>();
        KoujyoSymMap.put($("02", "11807111129", "2016", BizDate.valueOf(20160330), Integer.valueOf(20)),"1");
        KoujyoSymMap.put($("03", "11807111130", "2016", BizDate.valueOf(20160330), Integer.valueOf(30)),"1");
        KoujyoSymMap.put($("04", "11807111141", "2016", BizDate.valueOf(20160330), Integer.valueOf(40)),"1");

        ExDBResults<IT_KoujyoSym> results = hozenDomManager.getKoujyoSymsByKakutyoujobcdTyouhyouymd("RBTA", BizDate.valueOf(20160330));

        int iCount = 0;

        for (IT_KoujyoSym koujyoSym : results) {

            iCount++;
            KoujyoSymMap.remove($(koujyoSym.getKbnkey(),koujyoSym.getSyono(),koujyoSym.getNendo(),koujyoSym.getTyouhyouymd(),koujyoSym.getRenno()));
        }

        Assert.assertEquals(3, iCount);
        assertTrue(KoujyoSymMap.isEmpty());
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
    public void testSkippedFilter40(){

        try(ExDBResults<IT_KoujyoSym> iT_KoujyoSymResults = hozenDomManager.getKoujyoSymsByKakutyoujobcdTyouhyouymd("RBTA", BizDate.valueOf(20160330))){

            Iterator<IT_KoujyoSym> iter = iT_KoujyoSymResults.iterator();
            int iCount = 0;
            while (iter.hasNext()) {

                iter.next();

                iCount++;
            }

            Assert.assertEquals(3, iCount);
        }
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testSkippedFilter50(){

        BM_RecoveryFilter bM_RecoveryFilter = new BM_RecoveryFilter("Kh001");
        bM_RecoveryFilter.setRecoveryfilternm("契約基本フィルタ");
        bM_RecoveryFilter.setRecoveryfilterkeykmid1("kbnkey");
        bM_RecoveryFilter.setRecoveryfilterkeykmid2("syono");
        hozenDomManager.insert(bM_RecoveryFilter);

        BT_SkipKey bT_SkipKey1 = new BT_SkipKey("900001");
        bT_SkipKey1.setKakutyoujobcd("RBTA");
        bT_SkipKey1.setTableid("IT_KoujyoSym");
        bT_SkipKey1.setRecoveryfilterid("Kh001");
        bT_SkipKey1.setRecoveryfilterkey1(SWAKInjector.getInstance(KbnKeyGenerator.class).generate("11807111129"));
        bT_SkipKey1.setRecoveryfilterkey2("11807111129");
        hozenDomManager.insert(bT_SkipKey1);
    }

    @Test
    @TestOrder(51)
    @Transactional
    public void testSkippedFilter51(){

        try(ExDBResults<IT_KoujyoSym> iT_KoujyoSymResults = hozenDomManager.getKoujyoSymsByKakutyoujobcdTyouhyouymd("RBTA", BizDate.valueOf(20160330))){

            int iCount = 0;
            for (IT_KoujyoSym iT_KoujyoSym : iT_KoujyoSymResults) {

                assertNotEquals("11807111129", iT_KoujyoSym.getSyono());

                iCount++;
            }

            Assert.assertEquals(2, iCount);
        }
    }

    @Test
    @TestOrder(60)
    @Transactional
    public void testSkippedFilter60(){

        BT_SkipKey bT_SkipKey2 = new BT_SkipKey("900002");
        bT_SkipKey2.setKakutyoujobcd("RBTA");
        bT_SkipKey2.setTableid("IT_KoujyoSym");
        bT_SkipKey2.setRecoveryfilterid("Kh001");
        bT_SkipKey2.setRecoveryfilterkey1(SWAKInjector.getInstance(KbnKeyGenerator.class).generate("11807111130"));
        bT_SkipKey2.setRecoveryfilterkey2("11807111130");
        hozenDomManager.insert(bT_SkipKey2);
    }

    @Test
    @TestOrder(61)
    public void testSkippedFilter61(){

        try(ExDBResults<IT_KoujyoSym> iT_KoujyoSymResults = hozenDomManager.getKoujyoSymsByKakutyoujobcdTyouhyouymd("RBTA", BizDate.valueOf(20160330))){

            int iCount = 0;
            for (IT_KoujyoSym iT_KoujyoSym : iT_KoujyoSymResults) {

                assertNotEquals("11807111129", iT_KoujyoSym.getSyono());
                assertNotEquals("11807111130", iT_KoujyoSym.getSyono());

                iCount++;
            }

            Assert.assertEquals(1, iCount);
        }
    }
}
