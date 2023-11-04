package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 手数料情報テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonTest_getTesuuryousByTsrysyorikbnRenno {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        if (kykKihon == null) {
            kykKihon = new IT_KykKihon("10","11807111118");
            Assert.assertEquals(0, kykKihon.getTesuuryousByTsrysyorikbnRenno(C_TsrysyoriKbn.SINKEIYAKUSEIRITU,1).size());

            IT_Tesuuryou tesuuryou1 = kykKihon.createTesuuryou();
            tesuuryou1.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
            tesuuryou1.setRenno(1);

            IT_Tesuuryou tesuuryou2 = kykKihon.createTesuuryou();
            tesuuryou2.setTsrysyorikbn(C_TsrysyoriKbn.BLNK);
            tesuuryou2.setRenno(1);

            IT_Tesuuryou tesuuryou3 = kykKihon.createTesuuryou();
            tesuuryou3.setTsrysyorikbn(C_TsrysyoriKbn.SINKEIYAKUSEIRITU);
            tesuuryou3.setRenno(2);

            hozenDomManager.insert(kykKihon);
        }

    }
    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_Tesuuryou> tesuuryouLst = kykKihon.getTesuuryousByTsrysyorikbnRenno(C_TsrysyoriKbn.SINKEIYAKUSEIRITU, 5);

        Assert.assertEquals(0, tesuuryouLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("11807111118");
        List<IT_Tesuuryou> tesuuryouLst = kykKihon.getTesuuryousByTsrysyorikbnRenno(C_TsrysyoriKbn.SINKEIYAKUSEIRITU, 1);

        Assert.assertEquals(1, tesuuryouLst.size());

        Assert.assertEquals("10", tesuuryouLst.get(0).getKbnkey());
        Assert.assertEquals("11807111118", tesuuryouLst.get(0).getSyono());
        Assert.assertEquals(C_TsrysyoriKbn.SINKEIYAKUSEIRITU, tesuuryouLst.get(0).getTsrysyorikbn());
        Assert.assertEquals(Integer.valueOf(1), tesuuryouLst.get(0).getRenno());
    }
}
