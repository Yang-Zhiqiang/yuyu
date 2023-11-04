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

import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.testinfr.TestOrder;


@RunWith(SWAKTestRunner.class)
public class HT_SmbcStyKanriSsRirekiEntityTest implements EntityTestInterface {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Assert.assertEquals(0,sinkeiyakuDomManager.getAllSmbcStyKanriSsRireki().size());


        String pMosno21 = "MOSNO21";

        HT_SmbcStyKanriSsRireki hT_SmbcStyKanriSsRireki21 = new HT_SmbcStyKanriSsRireki(pMosno21);
        sinkeiyakuDomManager.insert(hT_SmbcStyKanriSsRireki21);

        String pMosno12 = "MOSNO12";

        HT_SmbcStyKanriSsRireki hT_SmbcStyKanriSsRireki12 = new HT_SmbcStyKanriSsRireki(pMosno12);
        sinkeiyakuDomManager.insert(hT_SmbcStyKanriSsRireki12);

        String pMosno11 = "MOSNO11";

        HT_SmbcStyKanriSsRireki hT_SmbcStyKanriSsRireki11 = new HT_SmbcStyKanriSsRireki(pMosno11);
        sinkeiyakuDomManager.insert(hT_SmbcStyKanriSsRireki11);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSmbcStyKanriSsRireki());

    }

    @Override
    @Test
    @TestOrder(10)
    public void getAll() {

        String pMosno21 = "MOSNO21";
        String pMosno12 = "MOSNO12";
        String pMosno11 = "MOSNO11";

        List<HT_SmbcStyKanriSsRireki> hT_SmbcStyKanriSsRirekis = sinkeiyakuDomManager.getAllSmbcStyKanriSsRireki();

        Assert.assertEquals(hT_SmbcStyKanriSsRirekis.get(0), sinkeiyakuDomManager.getSmbcStyKanriSsRireki(pMosno11));
        Assert.assertEquals(hT_SmbcStyKanriSsRirekis.get(1), sinkeiyakuDomManager.getSmbcStyKanriSsRireki(pMosno12));
        Assert.assertEquals(hT_SmbcStyKanriSsRirekis.get(2), sinkeiyakuDomManager.getSmbcStyKanriSsRireki(pMosno21));

        Assert.assertEquals(3, hT_SmbcStyKanriSsRirekis.size());

    }

    @Override
    @Test
    @TestOrder(20)
    public void getUniqueEntity() {

        String pMosno12 = "MOSNO12";

        HT_SmbcStyKanriSsRireki hT_SmbcStyKanriSsRireki = sinkeiyakuDomManager.getSmbcStyKanriSsRireki(pMosno12);
        Assert.assertEquals(pMosno12, hT_SmbcStyKanriSsRireki.getSyono());
    }

    @Override
    @Test
    @TestOrder(30)
    public void noUniqueEntity() {

        String pMosno33 = "MOSNO33";

        HT_SmbcStyKanriSsRireki hT_SmbcStyKanriSsRireki = sinkeiyakuDomManager.getSmbcStyKanriSsRireki(pMosno33);
        Assert.assertNull(hT_SmbcStyKanriSsRireki);

    }

    @Override
    @Test
    @TestOrder(40)
    public void blankCondition() {

        String pMosnoBlank = "";

        HT_SmbcStyKanriSsRireki hT_SmbcStyKanriSsRireki = sinkeiyakuDomManager.getSmbcStyKanriSsRireki(pMosnoBlank);
        Assert.assertNull(hT_SmbcStyKanriSsRireki);

    }

    @Override
    @Test
    @TestOrder(50)
    public void nullCondition() {

        Assert.assertTrue(true);

    }
}
