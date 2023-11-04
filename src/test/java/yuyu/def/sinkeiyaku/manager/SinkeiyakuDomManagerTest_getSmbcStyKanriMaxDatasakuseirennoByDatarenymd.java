package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getSmbcStyKanriMaxDatasakuseirennoByDatarenymd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcStyKanriMaxDatasakuseirennoByDatarenymd {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizNumber result = sinkeiyakuDomManager.getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(BizDate.valueOf("20160218"));
        Assert.assertEquals(null, result);
        HT_SmbcStyKanri smbcStyKanri = new HT_SmbcStyKanri();
        smbcStyKanri.setDatarenymd(BizDate.valueOf("20160218"));
        smbcStyKanri.setDatasakuseirenno(BizNumber.ZERO);
        sinkeiyakuDomManager.insert(smbcStyKanri);

        HT_SmbcStyKanri smbcStyKanri2 = new HT_SmbcStyKanri();
        smbcStyKanri2.setDatarenymd(BizDate.valueOf("20160218"));
        smbcStyKanri2.setDatasakuseirenno(BizNumber.ONE);
        sinkeiyakuDomManager.insert(smbcStyKanri2);

        HT_SmbcStyKanri smbcStyKanri4 = new HT_SmbcStyKanri();
        smbcStyKanri4.setDatarenymd(BizDate.valueOf("20160217"));
        smbcStyKanri4.setDatasakuseirenno(BizNumber.TEN);
        sinkeiyakuDomManager.insert(smbcStyKanri4);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {
        BizNumber result = sinkeiyakuDomManager.getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(BizDate.valueOf("20160219"));
        Assert.assertEquals(null, result);
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        BizNumber result = sinkeiyakuDomManager.getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(BizDate.valueOf("20160218"));
        Assert.assertEquals(BizNumber.ONE, result);
    }

}
