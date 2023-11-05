package yuyu.batch.suuri.srsuuritoukei.srbikinidoumeisai;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.SV_BikinIdouMeisai;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 異動明細情報作成<br />
 * getBikinIdouMeisaisByBknjkukbnBknrigikbnKessankijyunymd() メソッドのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SrBikinIdouMeisaiDaoTest_getBikinIdouMeisaisByBknjkukbnBknrigikbnKessankijyunymd {

    @Inject
    private SrBikinIdouMeisaiDao srBikinIdouMeisaiDao;

    @BeforeClass
    @Transactional
    public static void TestDataInsert() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        SrBikinIdouMeisaiDao srBikinIdouMeisaiDao = SWAKInjector.getInstance(SrBikinIdouMeisaiDao.class);

        List<SV_BikinIdouMeisai> bikinIdouMeisaiLst = srBikinIdouMeisaiDao.getBikinIdouMeisaisByBknjkukbnBknrigikbnKessankijyunymd(C_BknJkuKbn.SINBI, C_BknrigiKbn.DEL,BizDate.valueOf(20160901));

        Assert.assertEquals(0, bikinIdouMeisaiLst.size());

        IT_KhBikinkanri khBikinkanri1 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20160901), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160909), 11);
        khBikinkanri1.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri1.setBknjkukbn(C_BknJkuKbn.SINBI);
        khBikinkanri1.setShrsyoriymd(BizDate.valueOf(20160901));
        khBikinkanri1.setGyoumuKousinKinou("11111");
        khBikinkanri1.setGyoumuKousinTime("20160901");

        hozenDomManager.insert(khBikinkanri1);

        IT_KhBikinkanri khBikinkanri2 = new IT_KhBikinkanri("11807111129", BizDate.valueOf(20160901), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160910), 12);
        khBikinkanri2.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri2.setBknjkukbn(C_BknJkuKbn.BLNK);
        khBikinkanri2.setShrsyoriymd(BizDate.valueOf(20160901));
        khBikinkanri2.setGyoumuKousinKinou("11112");
        khBikinkanri2.setGyoumuKousinTime("20160901");

        hozenDomManager.insert(khBikinkanri2);

        IT_KhBikinkanri khBikinkanri3 = new IT_KhBikinkanri("11807111130", BizDate.valueOf(20160901), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160911), 13);
        khBikinkanri3.setBknrigikbn(C_BknrigiKbn.DEL);
        khBikinkanri3.setBknjkukbn(C_BknJkuKbn.SINBI);
        khBikinkanri3.setShrsyoriymd(BizDate.valueOf(20160901));
        khBikinkanri3.setGyoumuKousinKinou("11113");
        khBikinkanri3.setGyoumuKousinTime("20160901");

        hozenDomManager.insert(khBikinkanri3);

        IT_KhBikinkanri khBikinkanri4 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20160808), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160912), 14);
        khBikinkanri4.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri4.setBknjkukbn(C_BknJkuKbn.SINBI);
        khBikinkanri4.setShrsyoriymd(BizDate.valueOf(20160901));
        khBikinkanri4.setGyoumuKousinKinou("11114");
        khBikinkanri4.setGyoumuKousinTime("20160901");

        hozenDomManager.insert(khBikinkanri4);

        IT_KhBikinkanri khBikinkanri5 = new IT_KhBikinkanri("11807111163", BizDate.valueOf(20160902), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160913), 15);
        khBikinkanri5.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri5.setBknjkukbn(C_BknJkuKbn.SAIBI);
        khBikinkanri5.setShrsyoriymd(BizDate.valueOf(20160810));
        khBikinkanri5.setGyoumuKousinKinou("11115");
        khBikinkanri5.setGyoumuKousinTime("20160826");

        hozenDomManager.insert(khBikinkanri5);

        IT_KhBikinkanri khBikinkanri6 = new IT_KhBikinkanri("11807111196", BizDate.valueOf(20160902), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160914), 16);
        khBikinkanri6.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri6.setBknjkukbn(C_BknJkuKbn.SAIBI);
        khBikinkanri6.setShrsyoriymd(BizDate.valueOf(20160809));
        khBikinkanri6.setGyoumuKousinKinou("11116");
        khBikinkanri6.setGyoumuKousinTime("20160826");

        hozenDomManager.insert(khBikinkanri6);

        IT_KhBikinkanri khBikinkanri7 = new IT_KhBikinkanri("11807111196", BizDate.valueOf(20160902), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160915), 17);
        khBikinkanri7.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri7.setBknjkukbn(C_BknJkuKbn.SAIBI);
        khBikinkanri7.setShrsyoriymd(BizDate.valueOf(20160808));
        khBikinkanri7.setGyoumuKousinKinou("11117");
        khBikinkanri7.setGyoumuKousinTime("20160826");

        hozenDomManager.insert(khBikinkanri7);

        IT_KhBikinkanri khBikinkanri8 = new IT_KhBikinkanri("11807111152", BizDate.valueOf(20160902), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160916), 18);
        khBikinkanri8.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri8.setBknjkukbn(C_BknJkuKbn.SAIBI);
        khBikinkanri8.setShrsyoriymd(BizDate.valueOf(20160810));
        khBikinkanri8.setGyoumuKousinKinou("11118");
        khBikinkanri8.setGyoumuKousinTime("20160826");

        hozenDomManager.insert(khBikinkanri8);

        IT_KhBikinkanri khBikinkanri9 = new IT_KhBikinkanri("11807111185", BizDate.valueOf(20160902), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160917), 19);
        khBikinkanri9.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri9.setBknjkukbn(C_BknJkuKbn.SAIBI);
        khBikinkanri9.setShrsyoriymd(BizDate.valueOf(20160810));
        khBikinkanri9.setGyoumuKousinKinou("11119");
        khBikinkanri9.setGyoumuKousinTime("20160826");

        hozenDomManager.insert(khBikinkanri9);

        IT_KhBikinkanri khBikinkanri10 = new IT_KhBikinkanri("11807111185", BizDate.valueOf(20160902), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160918), 20);
        khBikinkanri10.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri10.setBknjkukbn(C_BknJkuKbn.SAIBI);
        khBikinkanri10.setShrsyoriymd(BizDate.valueOf(20160810));
        khBikinkanri10.setGyoumuKousinKinou("11120");
        khBikinkanri10.setGyoumuKousinTime("20160825");

        hozenDomManager.insert(khBikinkanri10);

        IT_KhBikinkanri khBikinkanri11 = new IT_KhBikinkanri("11807111185", BizDate.valueOf(20160902), C_BkncdKbn.KAIYAKU, BizDate.valueOf(20160919), 21);
        khBikinkanri11.setBknrigikbn(C_BknrigiKbn.BLNK);
        khBikinkanri11.setBknjkukbn(C_BknJkuKbn.SAIBI);
        khBikinkanri11.setShrsyoriymd(BizDate.valueOf(20160810));
        khBikinkanri11.setGyoumuKousinKinou("11121");
        khBikinkanri11.setGyoumuKousinTime("20160824");

        hozenDomManager.insert(khBikinkanri11);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("06", "11807111163");

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("09", "11807111196");

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("05", "11807111152");

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("08", "11807111185");

        hozenDomManager.insert(kykKihon8);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<SV_BikinIdouMeisai> bikinIdouMeisaiLst = srBikinIdouMeisaiDao.getBikinIdouMeisaisByBknjkukbnBknrigikbnKessankijyunymd(C_BknJkuKbn.BLNK, C_BknrigiKbn.DEL,BizDate.valueOf(20140202));

        Assert.assertEquals(0, bikinIdouMeisaiLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<SV_BikinIdouMeisai> bikinIdouMeisaiLst = srBikinIdouMeisaiDao.getBikinIdouMeisaisByBknjkukbnBknrigikbnKessankijyunymd(C_BknJkuKbn.SINBI, C_BknrigiKbn.DEL,BizDate.valueOf(20160901));

        Assert.assertEquals(1, bikinIdouMeisaiLst.size());

        Assert.assertEquals("11807111118", bikinIdouMeisaiLst.get(0).getSyono());

    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<SV_BikinIdouMeisai> bikinIdouMeisaiLst = srBikinIdouMeisaiDao.getBikinIdouMeisaisByBknjkukbnBknrigikbnKessankijyunymd(C_BknJkuKbn.SAIBI, C_BknrigiKbn.DEL,BizDate.valueOf(20160902));

        Assert.assertEquals(7, bikinIdouMeisaiLst.size());

        Assert.assertEquals(BizDate.valueOf(20160808), bikinIdouMeisaiLst.get(0).getShrsyoriymd());
        Assert.assertEquals("11807111196", bikinIdouMeisaiLst.get(0).getSyono());
        Assert.assertEquals("20160826", bikinIdouMeisaiLst.get(0).getGyoumuKousinTime());

        Assert.assertEquals(BizDate.valueOf(20160809), bikinIdouMeisaiLst.get(1).getShrsyoriymd());
        Assert.assertEquals("11807111196", bikinIdouMeisaiLst.get(1).getSyono());
        Assert.assertEquals("20160826", bikinIdouMeisaiLst.get(1).getGyoumuKousinTime());

        Assert.assertEquals(BizDate.valueOf(20160810), bikinIdouMeisaiLst.get(2).getShrsyoriymd());
        Assert.assertEquals("11807111152", bikinIdouMeisaiLst.get(2).getSyono());
        Assert.assertEquals("20160826", bikinIdouMeisaiLst.get(2).getGyoumuKousinTime());

        Assert.assertEquals(BizDate.valueOf(20160810), bikinIdouMeisaiLst.get(3).getShrsyoriymd());
        Assert.assertEquals("11807111163", bikinIdouMeisaiLst.get(3).getSyono());
        Assert.assertEquals("20160826", bikinIdouMeisaiLst.get(3).getGyoumuKousinTime());

        Assert.assertEquals(BizDate.valueOf(20160810), bikinIdouMeisaiLst.get(4).getShrsyoriymd());
        Assert.assertEquals("11807111185", bikinIdouMeisaiLst.get(4).getSyono());
        Assert.assertEquals("20160824", bikinIdouMeisaiLst.get(4).getGyoumuKousinTime());

        Assert.assertEquals(BizDate.valueOf(20160810), bikinIdouMeisaiLst.get(5).getShrsyoriymd());
        Assert.assertEquals("11807111185", bikinIdouMeisaiLst.get(5).getSyono());
        Assert.assertEquals("20160825", bikinIdouMeisaiLst.get(5).getGyoumuKousinTime());

        Assert.assertEquals(BizDate.valueOf(20160810), bikinIdouMeisaiLst.get(6).getShrsyoriymd());
        Assert.assertEquals("11807111185", bikinIdouMeisaiLst.get(6).getSyono());
        Assert.assertEquals("20160826", bikinIdouMeisaiLst.get(6).getGyoumuKousinTime());
    }
}
