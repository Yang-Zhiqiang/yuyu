package yuyu.def.direct.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
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

import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ＤＳ汎用顧客宛通知テーブルエンティティリスト<br />
 * ＤＳ汎用顧客宛通知テーブルエンティティリスト（大量）取得　ＤＳデータ作成日指定<br />
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsHanyouKokyakuateTuutisByDsdatasakuseiymd {

    @Inject
    DirectDomManager directDomManager;


    @BeforeClass
    @Transactional()
    public static void preProcess() {

        deleteTestData();

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);


        try (ExDBResults<MT_DsHanyouKokyakuateTuuti> mT_DsHanyouKokyakuateTuuti =
            directDomManager.getDsHanyouKokyakuateTuutisByDsdatasakuseiymd(BizDate.valueOf(20161011))) {
            Assert.assertFalse(mT_DsHanyouKokyakuateTuuti.iterator().hasNext());
        }

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("100001");

        MT_DsHanyouKokyakuateTuuti dsHanyouKokyakuateTuuti1 = dsKokyakuKanri1.createDsHanyouKokyakuateTuuti();
        dsHanyouKokyakuateTuuti1.setDsdatasakuseiymd(BizDate.valueOf(20161011));
        dsHanyouKokyakuateTuuti1.setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI);

        MT_DsHanyouKokyakuateTuuti dsHanyouKokyakuateTuuti2 = dsKokyakuKanri1.createDsHanyouKokyakuateTuuti();
        dsHanyouKokyakuateTuuti2.setDsdatasakuseiymd(BizDate.valueOf(20161012));
        dsHanyouKokyakuateTuuti2.setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI);

        MT_DsHanyouKokyakuateTuuti dsHanyouKokyakuateTuuti3 = dsKokyakuKanri1.createDsHanyouKokyakuateTuuti();
        dsHanyouKokyakuateTuuti3.setDsdatasakuseiymd(BizDate.valueOf(20161011));
        dsHanyouKokyakuateTuuti3.setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn.BLNK);

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("100010");

        MT_DsHanyouKokyakuateTuuti dsHanyouKokyakuateTuuti4 = dsKokyakuKanri2.createDsHanyouKokyakuateTuuti();
        dsHanyouKokyakuateTuuti4.setDsdatasakuseiymd(BizDate.valueOf(20161017));
        dsHanyouKokyakuateTuuti4.setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI);

        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("100011");

        MT_DsHanyouKokyakuateTuuti dsHanyouKokyakuateTuuti5 = dsKokyakuKanri3.createDsHanyouKokyakuateTuuti();
        dsHanyouKokyakuateTuuti5.setDsdatasakuseiymd(BizDate.valueOf(20161017));
        dsHanyouKokyakuateTuuti5.setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI);

        directDomManager.insert(dsKokyakuKanri3);

        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("100012");

        MT_DsHanyouKokyakuateTuuti dsHanyouKokyakuateTuuti6 = dsKokyakuKanri4.createDsHanyouKokyakuateTuuti();
        dsHanyouKokyakuateTuuti6.setDsdatasakuseiymd(BizDate.valueOf(20161017));
        dsHanyouKokyakuateTuuti6.setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI);

        directDomManager.insert(dsKokyakuKanri4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void noResult() {

        try (ExDBResults<MT_DsHanyouKokyakuateTuuti> mT_DsHanyouKokyakuateTuuti =
            directDomManager.getDsHanyouKokyakuateTuutisByDsdatasakuseiymd(BizDate.valueOf(20160101))) {

            Assert.assertFalse(mT_DsHanyouKokyakuateTuuti.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<MT_DsHanyouKokyakuateTuuti>  mT_DsHanyouKokyakuateTuutis = directDomManager.getDsHanyouKokyakuateTuutisByDsdatasakuseiymd(BizDate.valueOf(20161011))){

            int iCount = 0;
            Iterator<MT_DsHanyouKokyakuateTuuti> iter = mT_DsHanyouKokyakuateTuutis.iterator();
            MT_DsHanyouKokyakuateTuuti  mT_DsHanyouKokyakuateTuuti = null;
            while (iter.hasNext()) {

                mT_DsHanyouKokyakuateTuuti = iter.next();
                iCount++;

                Assert.assertEquals(BizDate.valueOf(20161011), mT_DsHanyouKokyakuateTuuti.getDsdatasakuseiymd());
                Assert.assertEquals("100001", mT_DsHanyouKokyakuateTuuti.getDskokno());
                Assert.assertEquals(C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI, mT_DsHanyouKokyakuateTuuti.getDshanyoukokyakuatetuutikbn());
            }

            Assert.assertEquals(1, iCount);
        }


    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<MT_DsHanyouKokyakuateTuuti>  mT_DsHanyouKokyakuateTuutis = directDomManager.getDsHanyouKokyakuateTuutisByDsdatasakuseiymd(BizDate.valueOf(20161017))){

            HashMap<String,String> datamap = new HashMap<String,String>();
            datamap.put($(BizDate.valueOf(20161017),"100010",C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI), "1");
            datamap.put($(BizDate.valueOf(20161017),"100011",C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI), "2");
            datamap.put($(BizDate.valueOf(20161017),"100012",C_DsHanyouKokyakuateTuutiKbn.EMAILSOUSINERRORTUUTI), "3");

            Iterator<MT_DsHanyouKokyakuateTuuti> iter = mT_DsHanyouKokyakuateTuutis.iterator();
            MT_DsHanyouKokyakuateTuuti  mT_DsHanyouKokyakuateTuuti = null;
            while (iter.hasNext()) {

                mT_DsHanyouKokyakuateTuuti = iter.next();
                datamap.remove($(mT_DsHanyouKokyakuateTuuti.getDsdatasakuseiymd(),mT_DsHanyouKokyakuateTuuti.getDskokno(),mT_DsHanyouKokyakuateTuuti.getDshanyoukokyakuatetuutikbn()));

            }
            Assert.assertTrue(datamap.isEmpty());
        }

    }
}
