package yuyu.def.hozen.manager;

import static org.junit.Assert.*;

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

import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_KensakuyouGenponHnkykumu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IM_KhHubiNaiyou;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class HozenDomManagerTest_getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("10000",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.SYA,C_KensakuyouGenponHnkykumu.ARI,C_UmuKbn.ARI,"かうか");

        Assert.assertEquals(0,IM_KhHubiNaiyouLst.size());

        IM_KhHubiNaiyou khHubiNaiyou1 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("0"), "012");
        khHubiNaiyou1.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou1.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou1.setHubinaiyouhyoujijyun(112);
        khHubiNaiyou1.setHubinaiyou("かうか");

        hozenDomManager.insert(khHubiNaiyou1);

        IM_KhHubiNaiyou khHubiNaiyou2 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("0"), "000");
        khHubiNaiyou2.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou2.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou2.setHubinaiyouhyoujijyun(111);
        khHubiNaiyou2.setHubinaiyou("うかう");

        hozenDomManager.insert(khHubiNaiyou2);

        IM_KhHubiNaiyou khHubiNaiyou3 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("0"), "010");
        khHubiNaiyou3.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou3.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou3.setHubinaiyouhyoujijyun(110);
        khHubiNaiyou3.setHubinaiyou("う");

        hozenDomManager.insert(khHubiNaiyou3);

        IM_KhHubiNaiyou khHubiNaiyou4 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("0"), "009");
        khHubiNaiyou4.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou4.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou4.setHubinaiyouhyoujijyun(109);
        khHubiNaiyou4.setHubinaiyou("か");

        hozenDomManager.insert(khHubiNaiyou4);

        IM_KhHubiNaiyou khHubiNaiyou5 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("0"), "008");
        khHubiNaiyou5.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou5.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou5.setHubinaiyouhyoujijyun(110);
        khHubiNaiyou5.setHubinaiyou("ううう");

        hozenDomManager.insert(khHubiNaiyou5);

        IM_KhHubiNaiyou khHubiNaiyou6 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("0"), "007");
        khHubiNaiyou6.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou6.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou6.setHubinaiyouhyoujijyun(107);
        khHubiNaiyou6.setHubinaiyou("かかか");

        hozenDomManager.insert(khHubiNaiyou6);

        IM_KhHubiNaiyou khHubiNaiyou7 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("0"), "006");
        khHubiNaiyou7.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou7.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou7.setHubinaiyouhyoujijyun(106);
        khHubiNaiyou7.setHubinaiyou("じけえ");

        hozenDomManager.insert(khHubiNaiyou7);

        IM_KhHubiNaiyou khHubiNaiyou8 = new IM_KhHubiNaiyou("20000", C_SyoruiCdKbn.valueOf("0"), "005");
        khHubiNaiyou8.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou8.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou8.setHubinaiyouhyoujijyun(105);
        khHubiNaiyou8.setHubinaiyou("かうか");

        hozenDomManager.insert(khHubiNaiyou8);

        IM_KhHubiNaiyou khHubiNaiyou9 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("wf001"), "004");
        khHubiNaiyou9.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou9.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou9.setHubinaiyouhyoujijyun(104);
        khHubiNaiyou9.setHubinaiyou("かうか");

        hozenDomManager.insert(khHubiNaiyou9);

        IM_KhHubiNaiyou khHubiNaiyou10 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("0"), "003");
        khHubiNaiyou10.setHassinsakikbn(C_HassinsakiKbn.valueOf("2"));
        khHubiNaiyou10.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou10.setHubinaiyouhyoujijyun(103);
        khHubiNaiyou10.setHubinaiyou("かうか");

        hozenDomManager.insert(khHubiNaiyou10);

        IM_KhHubiNaiyou khHubiNaiyou11 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("0"), "002");
        khHubiNaiyou11.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou11.setGenponhnkykumu(C_UmuKbn.valueOf("0"));
        khHubiNaiyou11.setHubinaiyouhyoujijyun(102);
        khHubiNaiyou11.setHubinaiyou("かうか");

        hozenDomManager.insert(khHubiNaiyou11);

        IM_KhHubiNaiyou khHubiNaiyou12 = new IM_KhHubiNaiyou("10000", C_SyoruiCdKbn.valueOf("0"), "001");
        khHubiNaiyou12.setHassinsakikbn(C_HassinsakiKbn.valueOf("1"));
        khHubiNaiyou12.setGenponhnkykumu(C_UmuKbn.valueOf("1"));
        khHubiNaiyou12.setHubinaiyouhyoujijyun(101);
        khHubiNaiyou12.setHubinaiyou("もよび");

        hozenDomManager.insert(khHubiNaiyou12);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhHubiNaiyou());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("30000",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.SYA,C_KensakuyouGenponHnkykumu.ARI,C_UmuKbn.ARI,"かうか");

        Assert.assertEquals(0,IM_KhHubiNaiyouLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("10000",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.SYA,C_KensakuyouGenponHnkykumu.ARI,C_UmuKbn.ARI,"うう");

        Assert.assertEquals(1,IM_KhHubiNaiyouLst.size());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(0).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(0).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(0).getHubinaiyouhyoujijyun().intValue());
        assertEquals("008", IM_KhHubiNaiyouLst.get(0).getHubinaiyoucd());
        assertEquals("ううう", IM_KhHubiNaiyouLst.get(0).getHubinaiyou());
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("10000",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.SYA,C_KensakuyouGenponHnkykumu.ARI,C_UmuKbn.ARI,"け");

        Assert.assertEquals(1,IM_KhHubiNaiyouLst.size());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(0).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(0).getSyoruiCd());
        assertEquals(106, IM_KhHubiNaiyouLst.get(0).getHubinaiyouhyoujijyun().intValue());
        assertEquals("006", IM_KhHubiNaiyouLst.get(0).getHubinaiyoucd());
        assertEquals("じけえ", IM_KhHubiNaiyouLst.get(0).getHubinaiyou());

    }

    @Test
    @TestOrder(40)
    public void normal3(){

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("10000",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.SYA,C_KensakuyouGenponHnkykumu.ARI,C_UmuKbn.ARI,"う");

        Assert.assertEquals(4,IM_KhHubiNaiyouLst.size());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(0).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(0).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(0).getHubinaiyouhyoujijyun().intValue());
        assertEquals("008", IM_KhHubiNaiyouLst.get(0).getHubinaiyoucd());
        assertEquals("ううう", IM_KhHubiNaiyouLst.get(0).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(1).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(1).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(1).getHubinaiyouhyoujijyun().intValue());
        assertEquals("010", IM_KhHubiNaiyouLst.get(1).getHubinaiyoucd());
        assertEquals("う", IM_KhHubiNaiyouLst.get(1).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(2).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(2).getSyoruiCd());
        assertEquals(111, IM_KhHubiNaiyouLst.get(2).getHubinaiyouhyoujijyun().intValue());
        assertEquals("000", IM_KhHubiNaiyouLst.get(2).getHubinaiyoucd());
        assertEquals("うかう", IM_KhHubiNaiyouLst.get(2).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(3).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(3).getSyoruiCd());
        assertEquals(112, IM_KhHubiNaiyouLst.get(3).getHubinaiyouhyoujijyun().intValue());
        assertEquals("012", IM_KhHubiNaiyouLst.get(3).getHubinaiyoucd());
        assertEquals("かうか", IM_KhHubiNaiyouLst.get(3).getHubinaiyou());

    }

    @Test
    @TestOrder(50)
    public void normal4(){

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("10000",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.BLNK,C_KensakuyouGenponHnkykumu.ARI,C_UmuKbn.ARI,"う");

        Assert.assertEquals(5,IM_KhHubiNaiyouLst.size());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(0).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(0).getSyoruiCd());
        assertEquals(103, IM_KhHubiNaiyouLst.get(0).getHubinaiyouhyoujijyun().intValue());
        assertEquals("003", IM_KhHubiNaiyouLst.get(0).getHubinaiyoucd());
        assertEquals("かうか", IM_KhHubiNaiyouLst.get(0).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(1).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(1).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(1).getHubinaiyouhyoujijyun().intValue());
        assertEquals("008", IM_KhHubiNaiyouLst.get(1).getHubinaiyoucd());
        assertEquals("ううう", IM_KhHubiNaiyouLst.get(1).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(2).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(2).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(2).getHubinaiyouhyoujijyun().intValue());
        assertEquals("010", IM_KhHubiNaiyouLst.get(2).getHubinaiyoucd());
        assertEquals("う", IM_KhHubiNaiyouLst.get(2).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(3).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(3).getSyoruiCd());
        assertEquals(111, IM_KhHubiNaiyouLst.get(3).getHubinaiyouhyoujijyun().intValue());
        assertEquals("000", IM_KhHubiNaiyouLst.get(3).getHubinaiyoucd());
        assertEquals("うかう", IM_KhHubiNaiyouLst.get(3).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(4).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(4).getSyoruiCd());
        assertEquals(112, IM_KhHubiNaiyouLst.get(4).getHubinaiyouhyoujijyun().intValue());
        assertEquals("012", IM_KhHubiNaiyouLst.get(4).getHubinaiyoucd());
        assertEquals("かうか", IM_KhHubiNaiyouLst.get(4).getHubinaiyou());

    }

    @Test
    @TestOrder(60)
    public void normal5(){

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("10000",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.SYA,C_KensakuyouGenponHnkykumu.BLNK,C_UmuKbn.ARI,"う");

        Assert.assertEquals(5,IM_KhHubiNaiyouLst.size());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(0).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(0).getSyoruiCd());
        assertEquals(102, IM_KhHubiNaiyouLst.get(0).getHubinaiyouhyoujijyun().intValue());
        assertEquals("002", IM_KhHubiNaiyouLst.get(0).getHubinaiyoucd());
        assertEquals("かうか", IM_KhHubiNaiyouLst.get(0).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(1).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(1).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(1).getHubinaiyouhyoujijyun().intValue());
        assertEquals("008", IM_KhHubiNaiyouLst.get(1).getHubinaiyoucd());
        assertEquals("ううう", IM_KhHubiNaiyouLst.get(1).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(2).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(2).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(2).getHubinaiyouhyoujijyun().intValue());
        assertEquals("010", IM_KhHubiNaiyouLst.get(2).getHubinaiyoucd());
        assertEquals("う", IM_KhHubiNaiyouLst.get(2).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(3).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(3).getSyoruiCd());
        assertEquals(111, IM_KhHubiNaiyouLst.get(3).getHubinaiyouhyoujijyun().intValue());
        assertEquals("000", IM_KhHubiNaiyouLst.get(3).getHubinaiyoucd());
        assertEquals("うかう", IM_KhHubiNaiyouLst.get(3).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(4).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(4).getSyoruiCd());
        assertEquals(112, IM_KhHubiNaiyouLst.get(4).getHubinaiyouhyoujijyun().intValue());
        assertEquals("012", IM_KhHubiNaiyouLst.get(4).getHubinaiyoucd());
        assertEquals("かうか", IM_KhHubiNaiyouLst.get(4).getHubinaiyou());

    }

    @Test
    @TestOrder(70)
    public void normal6(){

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("10000",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.SYA,C_KensakuyouGenponHnkykumu.ARI,C_UmuKbn.ARI,null);

        Assert.assertEquals(8,IM_KhHubiNaiyouLst.size());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(0).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(0).getSyoruiCd());
        assertEquals(101, IM_KhHubiNaiyouLst.get(0).getHubinaiyouhyoujijyun().intValue());
        assertEquals("001", IM_KhHubiNaiyouLst.get(0).getHubinaiyoucd());
        assertEquals("もよび", IM_KhHubiNaiyouLst.get(0).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(1).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(1).getSyoruiCd());
        assertEquals(106, IM_KhHubiNaiyouLst.get(1).getHubinaiyouhyoujijyun().intValue());
        assertEquals("006", IM_KhHubiNaiyouLst.get(1).getHubinaiyoucd());
        assertEquals("じけえ", IM_KhHubiNaiyouLst.get(1).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(2).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(2).getSyoruiCd());
        assertEquals(107, IM_KhHubiNaiyouLst.get(2).getHubinaiyouhyoujijyun().intValue());
        assertEquals("007", IM_KhHubiNaiyouLst.get(2).getHubinaiyoucd());
        assertEquals("かかか", IM_KhHubiNaiyouLst.get(2).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(3).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(3).getSyoruiCd());
        assertEquals(109, IM_KhHubiNaiyouLst.get(3).getHubinaiyouhyoujijyun().intValue());
        assertEquals("009", IM_KhHubiNaiyouLst.get(3).getHubinaiyoucd());
        assertEquals("か", IM_KhHubiNaiyouLst.get(3).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(4).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(4).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(4).getHubinaiyouhyoujijyun().intValue());
        assertEquals("008", IM_KhHubiNaiyouLst.get(4).getHubinaiyoucd());
        assertEquals("ううう", IM_KhHubiNaiyouLst.get(4).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(5).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(5).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(5).getHubinaiyouhyoujijyun().intValue());
        assertEquals("010", IM_KhHubiNaiyouLst.get(5).getHubinaiyoucd());
        assertEquals("う", IM_KhHubiNaiyouLst.get(5).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(6).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(6).getSyoruiCd());
        assertEquals(111, IM_KhHubiNaiyouLst.get(6).getHubinaiyouhyoujijyun().intValue());
        assertEquals("000", IM_KhHubiNaiyouLst.get(6).getHubinaiyoucd());
        assertEquals("うかう", IM_KhHubiNaiyouLst.get(6).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(7).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(7).getSyoruiCd());
        assertEquals(112, IM_KhHubiNaiyouLst.get(7).getHubinaiyouhyoujijyun().intValue());
        assertEquals("012", IM_KhHubiNaiyouLst.get(7).getHubinaiyoucd());
        assertEquals("かうか", IM_KhHubiNaiyouLst.get(7).getHubinaiyou());

    }


    @Test
    @TestOrder(80)
    public void blankCondition1(){

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("10000",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.SYA,C_KensakuyouGenponHnkykumu.ARI,C_UmuKbn.ARI,"");

        Assert.assertEquals(8,IM_KhHubiNaiyouLst.size());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(0).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(0).getSyoruiCd());
        assertEquals(101, IM_KhHubiNaiyouLst.get(0).getHubinaiyouhyoujijyun().intValue());
        assertEquals("001", IM_KhHubiNaiyouLst.get(0).getHubinaiyoucd());
        assertEquals("もよび", IM_KhHubiNaiyouLst.get(0).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(1).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(1).getSyoruiCd());
        assertEquals(106, IM_KhHubiNaiyouLst.get(1).getHubinaiyouhyoujijyun().intValue());
        assertEquals("006", IM_KhHubiNaiyouLst.get(1).getHubinaiyoucd());
        assertEquals("じけえ", IM_KhHubiNaiyouLst.get(1).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(2).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(2).getSyoruiCd());
        assertEquals(107, IM_KhHubiNaiyouLst.get(2).getHubinaiyouhyoujijyun().intValue());
        assertEquals("007", IM_KhHubiNaiyouLst.get(2).getHubinaiyoucd());
        assertEquals("かかか", IM_KhHubiNaiyouLst.get(2).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(3).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(3).getSyoruiCd());
        assertEquals(109, IM_KhHubiNaiyouLst.get(3).getHubinaiyouhyoujijyun().intValue());
        assertEquals("009", IM_KhHubiNaiyouLst.get(3).getHubinaiyoucd());
        assertEquals("か", IM_KhHubiNaiyouLst.get(3).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(4).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(4).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(4).getHubinaiyouhyoujijyun().intValue());
        assertEquals("008", IM_KhHubiNaiyouLst.get(4).getHubinaiyoucd());
        assertEquals("ううう", IM_KhHubiNaiyouLst.get(4).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(5).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(5).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(5).getHubinaiyouhyoujijyun().intValue());
        assertEquals("010", IM_KhHubiNaiyouLst.get(5).getHubinaiyoucd());
        assertEquals("う", IM_KhHubiNaiyouLst.get(5).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(6).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(6).getSyoruiCd());
        assertEquals(111, IM_KhHubiNaiyouLst.get(6).getHubinaiyouhyoujijyun().intValue());
        assertEquals("000", IM_KhHubiNaiyouLst.get(6).getHubinaiyoucd());
        assertEquals("うかう", IM_KhHubiNaiyouLst.get(6).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(7).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(7).getSyoruiCd());
        assertEquals(112, IM_KhHubiNaiyouLst.get(7).getHubinaiyouhyoujijyun().intValue());
        assertEquals("012", IM_KhHubiNaiyouLst.get(7).getHubinaiyoucd());
        assertEquals("かうか", IM_KhHubiNaiyouLst.get(7).getHubinaiyou());

    }

    @Test
    @TestOrder(90)
    public void blankCondition2(){

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.SYA,C_KensakuyouGenponHnkykumu.ARI,C_UmuKbn.ARI,"かうか");

        Assert.assertEquals(0,IM_KhHubiNaiyouLst.size());

    }

    @Test
    @TestOrder(100)
    public void normal7(){

        List<IM_KhHubiNaiyou> IM_KhHubiNaiyouLst = hozenDomManager.getKhHubiNaiyousByJimutetuzukicdSyoruiCdItems("10000",C_SyoruiCdKbn.BLNK,
            C_HassinsakiKbn.BLNK,C_KensakuyouGenponHnkykumu.BLNK,C_UmuKbn.ARI,null);

        Assert.assertEquals(10,IM_KhHubiNaiyouLst.size());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(0).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(0).getSyoruiCd());
        assertEquals(101, IM_KhHubiNaiyouLst.get(0).getHubinaiyouhyoujijyun().intValue());
        assertEquals("001", IM_KhHubiNaiyouLst.get(0).getHubinaiyoucd());
        assertEquals("もよび", IM_KhHubiNaiyouLst.get(0).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(1).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(1).getSyoruiCd());
        assertEquals(102, IM_KhHubiNaiyouLst.get(1).getHubinaiyouhyoujijyun().intValue());
        assertEquals("002", IM_KhHubiNaiyouLst.get(1).getHubinaiyoucd());
        assertEquals("かうか", IM_KhHubiNaiyouLst.get(1).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(2).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(2).getSyoruiCd());
        assertEquals(103, IM_KhHubiNaiyouLst.get(2).getHubinaiyouhyoujijyun().intValue());
        assertEquals("003", IM_KhHubiNaiyouLst.get(2).getHubinaiyoucd());
        assertEquals("かうか", IM_KhHubiNaiyouLst.get(2).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(3).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(3).getSyoruiCd());
        assertEquals(106, IM_KhHubiNaiyouLst.get(3).getHubinaiyouhyoujijyun().intValue());
        assertEquals("006", IM_KhHubiNaiyouLst.get(3).getHubinaiyoucd());
        assertEquals("じけえ", IM_KhHubiNaiyouLst.get(3).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(4).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(4).getSyoruiCd());
        assertEquals(107, IM_KhHubiNaiyouLst.get(4).getHubinaiyouhyoujijyun().intValue());
        assertEquals("007", IM_KhHubiNaiyouLst.get(4).getHubinaiyoucd());
        assertEquals("かかか", IM_KhHubiNaiyouLst.get(4).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(5).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(5).getSyoruiCd());
        assertEquals(109, IM_KhHubiNaiyouLst.get(5).getHubinaiyouhyoujijyun().intValue());
        assertEquals("009", IM_KhHubiNaiyouLst.get(5).getHubinaiyoucd());
        assertEquals("か", IM_KhHubiNaiyouLst.get(5).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(6).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(6).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(6).getHubinaiyouhyoujijyun().intValue());
        assertEquals("008", IM_KhHubiNaiyouLst.get(6).getHubinaiyoucd());
        assertEquals("ううう", IM_KhHubiNaiyouLst.get(6).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(7).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(7).getSyoruiCd());
        assertEquals(110, IM_KhHubiNaiyouLst.get(7).getHubinaiyouhyoujijyun().intValue());
        assertEquals("010", IM_KhHubiNaiyouLst.get(7).getHubinaiyoucd());
        assertEquals("う", IM_KhHubiNaiyouLst.get(7).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(8).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(8).getSyoruiCd());
        assertEquals(111, IM_KhHubiNaiyouLst.get(8).getHubinaiyouhyoujijyun().intValue());
        assertEquals("000", IM_KhHubiNaiyouLst.get(8).getHubinaiyoucd());
        assertEquals("うかう", IM_KhHubiNaiyouLst.get(8).getHubinaiyou());

        assertEquals("10000", IM_KhHubiNaiyouLst.get(9).getJimutetuzukicd());
        assertEquals(C_SyoruiCdKbn.BLNK, IM_KhHubiNaiyouLst.get(9).getSyoruiCd());
        assertEquals(112, IM_KhHubiNaiyouLst.get(9).getHubinaiyouhyoujijyun().intValue());
        assertEquals("012", IM_KhHubiNaiyouLst.get(9).getHubinaiyoucd());
        assertEquals("かうか", IM_KhHubiNaiyouLst.get(9).getHubinaiyou());
    }
}
