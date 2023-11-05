package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KoukankykKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MostenkenRireki;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 申込代理店テーブル のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getKokanKeiyakuGaitouKeiyakusBySyoriym {

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<HT_MosDairiten> mosDairitenLst = sinkeiyakuDomManager.getKokanKeiyakuGaitouKeiyakusBySyoriym(BizDateYM.valueOf(201507));
        Assert.assertEquals(0, mosDairitenLst.size());

        HT_SyoriCTL syoriCTL = new HT_SyoriCTL("10000000050");
        syoriCTL.setKoukankykkbn(C_KoukankykKbn.GAITOUKENENARI);

        HT_MosKihon  mosKihon = syoriCTL.createMosKihon();
        mosKihon.setMosymd(BizDate.valueOf(20150628));

        HT_MosDairiten mosDairiten = syoriCTL.createMosDairiten();
        mosDairiten.setRenno(1);

        HT_MostenkenRireki mostenkenRireki = syoriCTL.createMostenkenRireki();
        mostenkenRireki.setRenno(1);
        mostenkenRireki.setSyoriYmd(BizDate.valueOf(20150712));
        mostenkenRireki.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL("10000000060");
        syoriCTL1.setKoukankykkbn(C_KoukankykKbn.GAITOUKENENARI);

        HT_MosKihon  mosKihon1 = syoriCTL1.createMosKihon();
        mosKihon1.setMosymd(BizDate.valueOf(20150621));

        HT_MosDairiten mosDairiten1 = syoriCTL1.createMosDairiten();
        mosDairiten1.setRenno(1);

        HT_MosDairiten mosDairiten2 = syoriCTL1.createMosDairiten();
        mosDairiten2.setRenno(2);

        HT_MostenkenRireki mostenkenRireki1 = syoriCTL1.createMostenkenRireki();
        mostenkenRireki1.setRenno(1);
        mostenkenRireki1.setSyoriYmd(BizDate.valueOf(20150612));
        mostenkenRireki1.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        HT_MostenkenRireki mostenkenRireki2 = syoriCTL1.createMostenkenRireki();
        mostenkenRireki2.setRenno(2);
        mostenkenRireki2.setSyoriYmd(BizDate.valueOf(20150712));
        mostenkenRireki2.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL("10000000059");
        syoriCTL2.setKoukankykkbn(C_KoukankykKbn.GAITOUKENENARI);

        HT_MosKihon  mosKihon2 = syoriCTL2.createMosKihon();
        mosKihon2.setMosymd(BizDate.valueOf(20150625));

        HT_MosDairiten mosDairiten3 = syoriCTL2.createMosDairiten();
        mosDairiten3.setRenno(1);

        HT_MostenkenRireki mostenkenRireki3 = syoriCTL2.createMostenkenRireki();
        mostenkenRireki3.setRenno(1);
        mostenkenRireki3.setSyoriYmd(BizDate.valueOf(20150712));
        mostenkenRireki3.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL("10000000058");
        syoriCTL3.setKoukankykkbn(C_KoukankykKbn.GAITOUKENENARI);

        HT_MosKihon  mosKihon3 = syoriCTL3.createMosKihon();
        mosKihon3.setMosymd(BizDate.valueOf(20150625));

        HT_MosDairiten mosDairiten4 = syoriCTL3.createMosDairiten();
        mosDairiten4.setRenno(1);

        HT_MostenkenRireki mostenkenRireki4 = syoriCTL3.createMostenkenRireki();
        mostenkenRireki4.setRenno(1);
        mostenkenRireki4.setSyoriYmd(BizDate.valueOf(20150712));
        mostenkenRireki4.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL3);

        HT_SyoriCTL syoriCTL4 = new HT_SyoriCTL("10000000057");
        syoriCTL4.setKoukankykkbn(C_KoukankykKbn.GAITOUKENENARI);

        HT_MosKihon  mosKihon5 = syoriCTL4.createMosKihon();
        mosKihon5.setMosymd(BizDate.valueOf(20150625));

        HT_MosDairiten mosDairiten5 = syoriCTL4.createMosDairiten();
        mosDairiten5.setRenno(1);

        HT_MostenkenRireki mostenkenRireki5 = syoriCTL4.createMostenkenRireki();
        mostenkenRireki5.setRenno(1);
        mostenkenRireki5.setSyoriYmd(BizDate.valueOf(20150712));
        mostenkenRireki5.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL4);

        HT_SyoriCTL syoriCTL5 = new HT_SyoriCTL("10000000056");
        syoriCTL5.setKoukankykkbn(C_KoukankykKbn.GAITOUKENENARI);

        HT_MosKihon  mosKihon6 = syoriCTL5.createMosKihon();
        mosKihon6.setMosymd(BizDate.valueOf(20150623));

        HT_MosDairiten mosDairiten6 = syoriCTL5.createMosDairiten();
        mosDairiten6.setRenno(1);

        HT_MostenkenRireki mostenkenRireki6 = syoriCTL5.createMostenkenRireki();
        mostenkenRireki6.setRenno(1);
        mostenkenRireki6.setSyoriYmd(BizDate.valueOf(20150812));
        mostenkenRireki6.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL5);

        HT_SyoriCTL syoriCTL6 = new HT_SyoriCTL("10000000055");
        syoriCTL6.setKoukankykkbn(C_KoukankykKbn.GAITOUNASI);

        HT_MosKihon  mosKihon7 = syoriCTL6.createMosKihon();
        mosKihon7.setMosymd(BizDate.valueOf(20150622));

        HT_MosDairiten mosDairiten7 = syoriCTL6.createMosDairiten();
        mosDairiten7.setRenno(1);

        HT_MostenkenRireki mostenkenRireki7 = syoriCTL6.createMostenkenRireki();
        mostenkenRireki7.setRenno(1);
        mostenkenRireki7.setSyoriYmd(BizDate.valueOf(20150712));
        mostenkenRireki7.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL6);

        HT_SyoriCTL syoriCTL7 = new HT_SyoriCTL("10000000054");
        syoriCTL7.setKoukankykkbn(C_KoukankykKbn.GAITOUKENENARI);

        HT_MosDairiten mosDairiten8 = syoriCTL7.createMosDairiten();
        mosDairiten8.setRenno(1);

        HT_MostenkenRireki mostenkenRireki8 = syoriCTL7.createMostenkenRireki();
        mostenkenRireki8.setRenno(1);
        mostenkenRireki8.setSyoriYmd(BizDate.valueOf(20150712));
        mostenkenRireki8.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL7);

        HT_SyoriCTL syoriCTL8 = new HT_SyoriCTL("10000000053");
        syoriCTL8.setKoukankykkbn(C_KoukankykKbn.GAITOUKENENARI);

        HT_MosKihon  mosKihon9 = syoriCTL8.createMosKihon();
        mosKihon9.setMosymd(BizDate.valueOf(20150621));

        HT_MosDairiten mosDairiten9 = syoriCTL8.createMosDairiten();
        mosDairiten9.setRenno(1);

        sinkeiyakuDomManager.insert(syoriCTL8);

        HT_SyoriCTL syoriCTL9 = new HT_SyoriCTL("10000000052");
        syoriCTL9.setKoukankykkbn(C_KoukankykKbn.GAITOUKENENARI);

        HT_MosKihon  mosKihon10 = syoriCTL9.createMosKihon();
        mosKihon10.setMosymd(BizDate.valueOf(20150620));

        HT_MostenkenRireki mostenkenRireki9 = syoriCTL9.createMostenkenRireki();
        mostenkenRireki9.setRenno(1);
        mostenkenRireki9.setSyoriYmd(BizDate.valueOf(20150712));
        mostenkenRireki9.setMostenkenkekkakbn(C_SyorikekkaKbn.KANRYOU);

        sinkeiyakuDomManager.insert(syoriCTL9);

        HT_SyoriCTL syoriCTL10 = new HT_SyoriCTL("10000000061");
        syoriCTL10.setKoukankykkbn(C_KoukankykKbn.GAITOUKENENARI);

        HT_MosKihon  mosKihon11 = syoriCTL10.createMosKihon();
        mosKihon11.setMosymd(BizDate.valueOf(20150620));

        HT_MosDairiten mosDairiten10 = syoriCTL10.createMosDairiten();
        mosDairiten10.setRenno(1);

        HT_MostenkenRireki mostenkenRireki10 = syoriCTL10.createMostenkenRireki();
        mostenkenRireki10.setRenno(1);
        mostenkenRireki10.setSyoriYmd(BizDate.valueOf(20150712));
        mostenkenRireki10.setMostenkenkekkakbn(C_SyorikekkaKbn.SYOUNIN);

        sinkeiyakuDomManager.insert(syoriCTL10);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<HT_MosDairiten> mosDairitenLst = sinkeiyakuDomManager.getKokanKeiyakuGaitouKeiyakusBySyoriym(BizDateYM.valueOf(201506));
        Assert.assertEquals(0, mosDairitenLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HT_MosDairiten> mosDairitenLst = sinkeiyakuDomManager.getKokanKeiyakuGaitouKeiyakusBySyoriym(BizDateYM.valueOf(201508));
        Assert.assertEquals(1, mosDairitenLst.size());

        Assert.assertEquals("10000000056", mosDairitenLst.get(0).getMosno());
        Assert.assertEquals(Integer.valueOf(1), mosDairitenLst.get(0).getRenno());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> map = new HashMap<String,String>();

        map.put($("10000000060",Integer.valueOf(1)),"1");
        map.put($("10000000060",Integer.valueOf(2)),"1");

        List<HT_MosDairiten> mosDairitenLst = sinkeiyakuDomManager.getKokanKeiyakuGaitouKeiyakusBySyoriym(BizDateYM.valueOf(201507));
        Assert.assertEquals(6, mosDairitenLst.size());

        assertTrue(map.containsKey($(mosDairitenLst.get(0).getMosno(), mosDairitenLst.get(0).getRenno())));
        assertTrue(map.containsKey($(mosDairitenLst.get(1).getMosno(), mosDairitenLst.get(1).getRenno())));

        map.remove($(mosDairitenLst.get(0).getMosno(), mosDairitenLst.get(0).getRenno()));
        map.remove($(mosDairitenLst.get(1).getMosno(), mosDairitenLst.get(1).getRenno()));

        assertTrue(map.isEmpty());

        Assert.assertEquals("10000000057", mosDairitenLst.get(2).getMosno());
        Assert.assertEquals(Integer.valueOf(1), mosDairitenLst.get(2).getRenno());
        Assert.assertEquals("10000000058", mosDairitenLst.get(3).getMosno());
        Assert.assertEquals(Integer.valueOf(1), mosDairitenLst.get(3).getRenno());
        Assert.assertEquals("10000000059", mosDairitenLst.get(4).getMosno());
        Assert.assertEquals(Integer.valueOf(1), mosDairitenLst.get(4).getRenno());
        Assert.assertEquals("10000000050", mosDairitenLst.get(5).getMosno());
        Assert.assertEquals(Integer.valueOf(1), mosDairitenLst.get(5).getRenno());
    }


}
