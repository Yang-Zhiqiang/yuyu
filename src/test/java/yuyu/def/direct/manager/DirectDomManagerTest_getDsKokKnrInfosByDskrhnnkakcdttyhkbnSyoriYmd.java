package yuyu.def.direct.manager;

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

import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.direct.result.bean.DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * DirectDomManagerクラスの、<br />
 * getDsHonninKakuninCdsByDskrhnnkakcdttshjyhsymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        try (ExDBResults<DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean> exDBResults = directDomManager.
                getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(BizDate.valueOf(20161101))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("1000001");

        MT_DsHonninKakuninCd dsHonninKakuninCd1 = dsKokyakuKanri1.createDsHonninKakuninCd();
        dsHonninKakuninCd1.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20161101));
        dsHonninKakuninCd1.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("1000002");

        MT_DsHonninKakuninCd dsHonninKakuninCd2 = dsKokyakuKanri2.createDsHonninKakuninCd();
        dsHonninKakuninCd2.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20161101));
        dsHonninKakuninCd2.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);

        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("1000003");

        MT_DsHonninKakuninCd dsHonninKakuninCd3 = dsKokyakuKanri3.createDsHonninKakuninCd();
        dsHonninKakuninCd3.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20161102));
        dsHonninKakuninCd3.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);

        directDomManager.insert(dsKokyakuKanri3);

        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("1000006");

        MT_DsHonninKakuninCd dsHonninKakuninCd4 = dsKokyakuKanri4.createDsHonninKakuninCd();
        dsHonninKakuninCd4.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20161103));
        dsHonninKakuninCd4.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);

        directDomManager.insert(dsKokyakuKanri4);

        MT_DsKokyakuKanri dsKokyakuKanri5 = new MT_DsKokyakuKanri("1000005");

        MT_DsHonninKakuninCd dsHonninKakuninCd5 = dsKokyakuKanri5.createDsHonninKakuninCd();
        dsHonninKakuninCd5.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20161103));
        dsHonninKakuninCd5.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);

        directDomManager.insert(dsKokyakuKanri5);

        MT_DsKokyakuKanri dsKokyakuKanri6 = new MT_DsKokyakuKanri("1000004");

        MT_DsHonninKakuninCd dsHonninKakuninCd6 = dsKokyakuKanri6.createDsHonninKakuninCd();
        dsHonninKakuninCd6.setDskrhnnkakcdttshjyhsymd(BizDate.valueOf(20161103));
        dsHonninKakuninCd6.setDskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);

        directDomManager.insert(dsKokyakuKanri6);

        MT_DsKokyakuKanri dsKokyakuKanri7 = new MT_DsKokyakuKanri("1000007");

        directDomManager.insert(dsKokyakuKanri7);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        try (ExDBResults<DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean> exDBResults = directDomManager.
                getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(BizDate.valueOf(20161031))) {

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

    }
    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        try (ExDBResults<DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean> exDBResults = directDomManager.
                getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(BizDate.valueOf(20161101))){

            int iCount = 0;
            Iterator<DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean> iter = exDBResults.iterator();
            DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean bean = null;
            while (iter.hasNext()) {

                bean = iter.next();
                iCount++;

                if (1 == iCount) {

                    Assert.assertEquals("1000001", bean.getMT_DsKokyakuKanri().getDskokno());

                    Assert.assertEquals("1000001", bean.getMT_DsHonninKakuninCd().getDskokno());

                }
            }
            Assert.assertEquals(1, iCount);
        }

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {
        try(ExDBResults<DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean> exDBResults =
                directDomManager.getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(BizDate.valueOf(20161103))){

            int iCount = 0;
            for (DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean bean : exDBResults) {
                iCount++;

                if (1 == iCount) {
                    Assert.assertEquals("1000004", bean.getMT_DsKokyakuKanri().getDskokno());

                    Assert.assertEquals("1000004", bean.getMT_DsHonninKakuninCd().getDskokno());
                }

                if (2 == iCount) {
                    Assert.assertEquals("1000005", bean.getMT_DsKokyakuKanri().getDskokno());

                    Assert.assertEquals("1000005", bean.getMT_DsHonninKakuninCd().getDskokno());
                }

                if (3 == iCount) {
                    Assert.assertEquals("1000006", bean.getMT_DsKokyakuKanri().getDskokno());

                    Assert.assertEquals("1000006", bean.getMT_DsHonninKakuninCd().getDskokno());
                }
            }

            Assert.assertEquals(3, iCount);
        }
    }
}
