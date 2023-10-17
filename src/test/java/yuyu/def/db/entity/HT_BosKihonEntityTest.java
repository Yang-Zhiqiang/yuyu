package yuyu.def.db.entity;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;

@RunWith(SWAKTestRunner.class)
public class HT_BosKihonEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        List<HT_BosKihon> hT_BosKihons = sinkeiyakuDomManager.getAllBosKihon();
        Assert.assertEquals(0, hT_BosKihons.size());

        bizDomManager.insert(new BM_Syokugyou("001"));
        bizDomManager.insert(new BM_Syokugyou("002"));

        HT_BosKihon hT_BosKihon1 = new HT_BosKihon("MOSNO002");
        HT_BosSyouhn hT_BosSyouhn1 = hT_BosKihon1.createBosSyouhn();
        hT_BosSyouhn1.setSyouhncd("SH02");
        HT_BosSyouhn hT_BosSyouhn2= hT_BosKihon1.createBosSyouhn();
        hT_BosSyouhn2.setSyouhncd("SH01");

        HT_BosUketorinin hT_BosUketorinin1 = hT_BosKihon1.createBosUketorinin();
        hT_BosUketorinin1.setUktsyukbn(C_UktsyuKbn.KEIZKNKUKT);
        hT_BosUketorinin1.setUktsyurenno(002);
        HT_BosUketorinin hT_BosUketorinin2 = hT_BosKihon1.createBosUketorinin();
        hT_BosUketorinin2.setUktsyukbn(C_UktsyuKbn.BLNK);
        hT_BosUketorinin2.setUktsyurenno(001);
        HT_BosUketorinin hT_BosUketorinin3 = hT_BosKihon1.createBosUketorinin();
        hT_BosUketorinin3.setUktsyukbn(C_UktsyuKbn.KEIZKNKUKT);
        hT_BosUketorinin3.setUktsyurenno(001);

        HT_BosDairiten hT_BosDairiten1 = hT_BosKihon1.createBosDairiten();
        hT_BosDairiten1.setRenno(002);
        HT_BosDairiten hT_BosDairiten2 = hT_BosKihon1.createBosDairiten();
        hT_BosDairiten2.setRenno(001);

        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou1 = hT_BosKihon1.createBosUketoriKouzaJyouhou();
        hT_BosUketoriKouzaJyouhou1.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN);
        HT_BosUketoriKouzaJyouhou hT_BosUketoriKouzaJyouhou2 = hT_BosKihon1.createBosUketoriKouzaJyouhou();
        hT_BosUketoriKouzaJyouhou2.setUktkzsyubetukbn(C_UketorikouzasyubetuKbn.BLNK);

        hT_BosKihon1.setHhknsykgycd("001");
        sinkeiyakuDomManager.insert(hT_BosKihon1);

        HT_BosKihon hT_BosKihon2 = new HT_BosKihon("MOSNO001");
        hT_BosKihon2.setHhknsykgycd("002");
        sinkeiyakuDomManager.insert(hT_BosKihon2);

        HT_BosKihon hT_BosKihon3 = new HT_BosKihon("MOSNO003");

        sinkeiyakuDomManager.insert(hT_BosKihon3);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllBosKihon());
        bizDomManager.delete(bizDomManager.getAllSyokugyou());
    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        List<HT_BosKihon> hT_BosKihons = sinkeiyakuDomManager.getAllBosKihon();
        Assert.assertSame("MOSNO001", hT_BosKihons.get(0).getMosno());
        Assert.assertSame("MOSNO002", hT_BosKihons.get(1).getMosno());
        Assert.assertSame("MOSNO003", hT_BosKihons.get(2).getMosno());

        Assert.assertEquals(3, hT_BosKihons.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon("MOSNO001");

        Assert.assertEquals("MOSNO001", hT_BosKihon.getMosno());

    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pMosno33 = "MOSNO33";

        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon(pMosno33);

        Assert.assertNull(hT_BosKihon);
    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pMosno22 = "";

        HT_BosKihon hT_BosKihon = sinkeiyakuDomManager.getBosKihon(pMosno22);

        Assert.assertNull(hT_BosKihon);
    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {
        Assert.assertTrue(true);
    }

    @Test
    @TestOrder(60)
    public void getBosSyouhn() {

        HT_BosKihon hT_BosKihon1 = sinkeiyakuDomManager.getBosKihon("MOSNO001");
        HT_BosKihon hT_BosKihon2 = sinkeiyakuDomManager.getBosKihon("MOSNO002");
        HT_BosKihon hT_BosKihon3 = sinkeiyakuDomManager.getBosKihon("MOSNO003");

        List<HT_BosSyouhn> hT_BosSyouhns = hT_BosKihon2.getBosSyouhns();
        Assert.assertEquals(2, hT_BosSyouhns.size());

        Assert.assertEquals("MOSNO002", hT_BosSyouhns.get(0).getMosno());
        Assert.assertEquals("SH01", hT_BosSyouhns.get(0).getSyouhncd());
        Assert.assertEquals("MOSNO002", hT_BosSyouhns.get(1).getMosno());
        Assert.assertEquals("SH02", hT_BosSyouhns.get(1).getSyouhncd());

        Assert.assertEquals(0, hT_BosKihon1.getBosSyouhns().size());
        Assert.assertEquals(0, hT_BosKihon3.getBosSyouhns().size());

    }

    @Test
    @TestOrder(70)
    public void getBosUketorinin() {

        HT_BosKihon hT_BosKihon1 = sinkeiyakuDomManager.getBosKihon("MOSNO001");
        HT_BosKihon hT_BosKihon2 = sinkeiyakuDomManager.getBosKihon("MOSNO002");
        HT_BosKihon hT_BosKihon3 = sinkeiyakuDomManager.getBosKihon("MOSNO003");

        List<HT_BosUketorinin> hT_BosUketorinins = hT_BosKihon2.getBosUketorinins();
        Assert.assertEquals(3, hT_BosUketorinins.size());

        Assert.assertEquals("MOSNO002", hT_BosUketorinins.get(0).getMosno());
        Assert.assertEquals(C_UktsyuKbn.BLNK, hT_BosUketorinins.get(0).getUktsyukbn());
        Assert.assertEquals(001, hT_BosUketorinins.get(0).getUktsyurenno().intValue());
        Assert.assertEquals("MOSNO002", hT_BosUketorinins.get(1).getMosno());
        Assert.assertEquals(C_UktsyuKbn.KEIZKNKUKT, hT_BosUketorinins.get(1).getUktsyukbn());
        Assert.assertEquals(001, hT_BosUketorinins.get(1).getUktsyurenno().intValue());
        Assert.assertEquals("MOSNO002", hT_BosUketorinins.get(2).getMosno());
        Assert.assertEquals(C_UktsyuKbn.KEIZKNKUKT, hT_BosUketorinins.get(2).getUktsyukbn());
        Assert.assertEquals(002, hT_BosUketorinins.get(2).getUktsyurenno().intValue());

        Assert.assertEquals(0, hT_BosKihon1.getBosUketorinins().size());
        Assert.assertEquals(0, hT_BosKihon3.getBosUketorinins().size());

    }

    @Test
    @TestOrder(80)
    public void getBosDairiten() {

        HT_BosKihon hT_BosKihon1 = sinkeiyakuDomManager.getBosKihon("MOSNO001");
        HT_BosKihon hT_BosKihon2 = sinkeiyakuDomManager.getBosKihon("MOSNO002");
        HT_BosKihon hT_BosKihon3 = sinkeiyakuDomManager.getBosKihon("MOSNO003");

        List<HT_BosDairiten> hT_BosDairitens = hT_BosKihon2.getBosDairitens();
        Assert.assertEquals(2, hT_BosDairitens.size());

        Assert.assertEquals("MOSNO002", hT_BosDairitens.get(0).getMosno());
        Assert.assertEquals(001, hT_BosDairitens.get(0).getRenno().intValue());
        Assert.assertEquals("MOSNO002", hT_BosDairitens.get(1).getMosno());
        Assert.assertEquals(002, hT_BosDairitens.get(1).getRenno().intValue());

        Assert.assertEquals(0, hT_BosKihon1.getBosDairitens().size());
        Assert.assertEquals(0, hT_BosKihon3.getBosDairitens().size());

    }

    @Test
    @TestOrder(90)
    public void getBosUketoriKouzaJyouhou() {

        HT_BosKihon hT_BosKihon1 = sinkeiyakuDomManager.getBosKihon("MOSNO001");
        HT_BosKihon hT_BosKihon2 = sinkeiyakuDomManager.getBosKihon("MOSNO002");
        HT_BosKihon hT_BosKihon3 = sinkeiyakuDomManager.getBosKihon("MOSNO003");

        List<HT_BosUketoriKouzaJyouhou> hT_BosUketoriKouzaJyouhous = hT_BosKihon2.getBosUketoriKouzaJyouhous();
        Assert.assertEquals(2, hT_BosUketoriKouzaJyouhous.size());

        Assert.assertEquals("MOSNO002", hT_BosUketoriKouzaJyouhous.get(0).getMosno());
        Assert.assertEquals(C_UketorikouzasyubetuKbn.BLNK, hT_BosUketoriKouzaJyouhous.get(0).getUktkzsyubetukbn());
        Assert.assertEquals("MOSNO002", hT_BosUketoriKouzaJyouhous.get(1).getMosno());
        Assert.assertEquals(C_UketorikouzasyubetuKbn.TEIKIUKETORIKIN, hT_BosUketoriKouzaJyouhous.get(1).getUktkzsyubetukbn());

        Assert.assertEquals(0, hT_BosKihon1.getBosUketoriKouzaJyouhous().size());
        Assert.assertEquals(0, hT_BosKihon3.getBosUketoriKouzaJyouhous().size());

    }

    @Test
    @TestOrder(100)
    public void getSyokugyou() {

        Assert.assertEquals(bizDomManager.getSyokugyou("001"), sinkeiyakuDomManager.getBosKihon("MOSNO002").getSyokugyou());
        Assert.assertEquals(bizDomManager.getSyokugyou("002"), sinkeiyakuDomManager.getBosKihon("MOSNO001").getSyokugyou());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon("MOSNO003").getSyokugyou());
    }

    @Test
    @TestOrder(110)
    @Transactional
    public void getBM_SyokugyouNull01() {

        bizDomManager.delete(bizDomManager.getSyokugyou("002"));
    }

    @Test
    @TestOrder(120)
    public void getBM_SyokugyouNull02() {

        Assert.assertEquals(bizDomManager.getSyokugyou("001"), sinkeiyakuDomManager.getBosKihon("MOSNO002").getSyokugyou());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon("MOSNO001").getSyokugyou());
        Assert.assertNull(sinkeiyakuDomManager.getBosKihon("MOSNO003").getSyokugyou());
    }

}
