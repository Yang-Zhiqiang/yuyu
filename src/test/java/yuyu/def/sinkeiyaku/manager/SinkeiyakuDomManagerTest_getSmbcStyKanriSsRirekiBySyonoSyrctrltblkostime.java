package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_SmbcStyKanriSsRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ＳＭＢＣ進捗管理作成履歴テーブル のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki = sinkeiyakuDomManager.getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime("11807111118", "201603231123");
        Assert.assertEquals(null, smbcStyKanriSsRireki);


        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki1 = new HT_SmbcStyKanriSsRireki();
        smbcStyKanriSsRireki1.setSyono("11807111118");
        smbcStyKanriSsRireki1.setSyrctrltblkostime("201603231122");
        smbcStyKanriSsRireki1.setRenkanryoflg(0);

        sinkeiyakuDomManager.insert(smbcStyKanriSsRireki1);

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki2 = new HT_SmbcStyKanriSsRireki();
        smbcStyKanriSsRireki2.setSyono("11807111129");
        smbcStyKanriSsRireki2.setSyrctrltblkostime("201603231122");
        smbcStyKanriSsRireki2.setRenkanryoflg(0);

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki3 = new HT_SmbcStyKanriSsRireki();
        smbcStyKanriSsRireki3.setSyono("11807111130");
        smbcStyKanriSsRireki3.setSyrctrltblkostime("201603231122");
        smbcStyKanriSsRireki3.setRenkanryoflg(1);

        sinkeiyakuDomManager.insert(smbcStyKanriSsRireki3);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanriSsRireki());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki = sinkeiyakuDomManager.getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime("11807111118", "201603231122");
        Assert.assertEquals(null, smbcStyKanriSsRireki);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki = sinkeiyakuDomManager.getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime("11807111118", "201603231123");

        Assert.assertEquals("11807111118", smbcStyKanriSsRireki.getSyono());
        Assert.assertEquals("201603231122", smbcStyKanriSsRireki.getSyrctrltblkostime());
        Assert.assertEquals(0, smbcStyKanriSsRireki.getRenkanryoflg().intValue());

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void noResult2() {

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki = sinkeiyakuDomManager.getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime("11807111118", "201603231121");
        Assert.assertEquals(null, smbcStyKanriSsRireki);

    }

    @Test
    @TestOrder(40)
    @Transactional
    public void noResult3() {

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki = sinkeiyakuDomManager.getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime("11807111130", "201603231123");
        Assert.assertEquals(null, smbcStyKanriSsRireki);

    }


    @Test
    @TestOrder(50)
    public void blank1() {

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki = sinkeiyakuDomManager.getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime("", "201603231123");
        Assert.assertEquals(null, smbcStyKanriSsRireki);

    }

    @Test
    @TestOrder(60)
    public void blank2() {

        HT_SmbcStyKanriSsRireki smbcStyKanriSsRireki = sinkeiyakuDomManager.getSmbcStyKanriSsRirekiBySyonoSyrctrltblkostime("11807111118", "");
        Assert.assertEquals(null, smbcStyKanriSsRireki);

    }

}
