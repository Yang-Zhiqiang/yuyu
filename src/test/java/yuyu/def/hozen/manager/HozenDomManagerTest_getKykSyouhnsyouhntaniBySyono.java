package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
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

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.hozen.result.bean.KykSyouhnsyouhntaniBySyonoBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykSyouhnsyouhntaniBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykSyouhnsyouhntaniBySyono {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnsyouhntaniBySyonoBeanLst = hozenDomManager.getKykSyouhnsyouhntaniBySyono("11807000032");
        Assert.assertEquals(0, kykSyouhnsyouhntaniBySyonoBeanLst.size());

        IT_KykKihon kykKihon1 = new IT_KykKihon("10", "11807000010");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("M110");
        kykSyouhn1.setSyouhnsdno(1);
        kykSyouhn1.setKyksyouhnrenno(1);
        kykSyouhn1.setKouryokuhasseiymd(null);
        kykSyouhn1.setGyoumuKousinKinou(null);

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("20141210143615501");

        IT_KykSyouhnRireki kykSyouhnRireki1 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki1.setSyouhncd("M110");
        kykSyouhnRireki1.setSyouhnsdno(1);
        kykSyouhnRireki1.setKyksyouhnrenno(1);
        kykSyouhnRireki1.setKouryokuhasseiymd(BizDate.valueOf(20150201));
        kykSyouhnRireki1.setGyoumuKousinKinou(null);

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("10", "11807000021");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn2.setSyouhncd("M110");
        kykSyouhn2.setSyouhnsdno(1);
        kykSyouhn2.setKyksyouhnrenno(1);
        kykSyouhn2.setKouryokuhasseiymd(null);
        kykSyouhn2.setGyoumuKousinKinou(null);

        IT_KykSyouhn kykSyouhn3 = kykKihon2.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("M110");
        kykSyouhn3.setSyouhnsdno(2);
        kykSyouhn3.setKyksyouhnrenno(1);
        kykSyouhn3.setKouryokuhasseiymd(BizDate.valueOf(20150102));
        kykSyouhn3.setGyoumuKousinKinou(null);

        IT_KykSyouhn kykSyouhn4 = kykKihon2.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn4.setSyouhncd("M110");
        kykSyouhn4.setSyouhnsdno(3);
        kykSyouhn4.setKyksyouhnrenno(1);
        kykSyouhn4.setKouryokuhasseiymd(BizDate.valueOf(20150104));
        kykSyouhn4.setGyoumuKousinKinou(null);

        IT_KykSyouhn kykSyouhn5 = kykKihon2.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn5.setSyouhncd("M110");
        kykSyouhn5.setSyouhnsdno(4);
        kykSyouhn5.setKyksyouhnrenno(1);
        kykSyouhn5.setKouryokuhasseiymd(null);
        kykSyouhn5.setGyoumuKousinKinou("111");

        IT_KykSyouhn kykSyouhn6 = kykKihon2.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn6.setSyouhncd("M110");
        kykSyouhn6.setSyouhnsdno(5);
        kykSyouhn6.setKyksyouhnrenno(1);
        kykSyouhn6.setKouryokuhasseiymd(null);
        kykSyouhn6.setGyoumuKousinKinou("111");

        IT_KykSyouhn kykSyouhn7 = kykKihon2.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn7.setSyouhncd("M110");
        kykSyouhn7.setSyouhnsdno(6);
        kykSyouhn7.setKyksyouhnrenno(1);
        kykSyouhn7.setKouryokuhasseiymd(null);
        kykSyouhn7.setGyoumuKousinKinou("131");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20141210143615501");

        IT_KykSyouhnRireki kykSyouhnRireki2 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki2.setSyouhncd("M110");
        kykSyouhnRireki2.setSyouhnsdno(1);
        kykSyouhnRireki2.setKyksyouhnrenno(1);
        kykSyouhnRireki2.setKouryokuhasseiymd(null);
        kykSyouhnRireki2.setGyoumuKousinKinou(null);

        IT_KykSyouhnRireki kykSyouhnRireki3 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki3.setSyouhncd("M110");
        kykSyouhnRireki3.setSyouhnsdno(2);
        kykSyouhnRireki3.setKyksyouhnrenno(1);
        kykSyouhnRireki3.setKouryokuhasseiymd(BizDate.valueOf(20150102));
        kykSyouhnRireki3.setGyoumuKousinKinou(null);

        IT_KykSyouhnRireki kykSyouhnRireki4 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki4.setSyouhncd("M110");
        kykSyouhnRireki4.setSyouhnsdno(3);
        kykSyouhnRireki4.setKyksyouhnrenno(1);
        kykSyouhnRireki4.setKouryokuhasseiymd(BizDate.valueOf(20150105));
        kykSyouhnRireki4.setGyoumuKousinKinou(null);

        IT_KykSyouhnRireki kykSyouhnRireki5 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki5.setSyouhncd("M110");
        kykSyouhnRireki5.setSyouhnsdno(4);
        kykSyouhnRireki5.setKyksyouhnrenno(1);
        kykSyouhnRireki5.setKouryokuhasseiymd(null);
        kykSyouhnRireki5.setGyoumuKousinKinou("111");

        IT_KykSyouhnRireki kykSyouhnRireki6 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki6.setSyouhncd("M110");
        kykSyouhnRireki6.setSyouhnsdno(5);
        kykSyouhnRireki6.setKyksyouhnrenno(1);
        kykSyouhnRireki6.setKouryokuhasseiymd(null);
        kykSyouhnRireki6.setGyoumuKousinKinou("112");

        IT_KykSyouhnRireki kykSyouhnRireki7 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki7.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki7.setSyouhncd("M110");
        kykSyouhnRireki7.setSyouhnsdno(6);
        kykSyouhnRireki7.setKyksyouhnrenno(1);
        kykSyouhnRireki7.setKouryokuhasseiymd(BizDate.valueOf(20150407));
        kykSyouhnRireki7.setGyoumuKousinKinou("131");

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("10", "11807000032");

        IT_KykSyouhn kykSyouhn8 = kykKihon3.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn8.setSyouhncd("M110");
        kykSyouhn8.setSyouhnsdno(1);
        kykSyouhn8.setKyksyouhnrenno(1);
        kykSyouhn8.setKouryokuhasseiymd(BizDate.valueOf(20150402));
        kykSyouhn8.setGyoumuKousinKinou("114");

        IT_KykSyouhn kykSyouhn9 = kykKihon3.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn9.setSyouhncd("M110");
        kykSyouhn9.setSyouhnsdno(2);
        kykSyouhn9.setKyksyouhnrenno(1);
        kykSyouhn9.setKouryokuhasseiymd(BizDate.valueOf(20150403));
        kykSyouhn9.setGyoumuKousinKinou("115");

        IT_KykSyouhn kykSyouhn10 = kykKihon3.createKykSyouhn();
        kykSyouhn10.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn10.setSyouhncd("M110");
        kykSyouhn10.setSyouhnsdno(3);
        kykSyouhn10.setKyksyouhnrenno(1);
        kykSyouhn10.setKouryokuhasseiymd(BizDate.valueOf(20150501));
        kykSyouhn10.setGyoumuKousinKinou("116");

        IT_KykSyouhn kykSyouhn11 = kykKihon3.createKykSyouhn();
        kykSyouhn11.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn11.setSyouhncd("M110");
        kykSyouhn11.setSyouhnsdno(4);
        kykSyouhn11.setKyksyouhnrenno(1);
        kykSyouhn11.setKouryokuhasseiymd(BizDate.valueOf(20150404));
        kykSyouhn11.setGyoumuKousinKinou("116");

        IT_KykSyouhn kykSyouhn12 = kykKihon3.createKykSyouhn();
        kykSyouhn12.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn12.setSyouhncd("M110");
        kykSyouhn12.setSyouhnsdno(5);
        kykSyouhn12.setKyksyouhnrenno(1);
        kykSyouhn12.setKouryokuhasseiymd(BizDate.valueOf(20150405));
        kykSyouhn12.setGyoumuKousinKinou("117");

        IT_KykSyouhn kykSyouhn13 = kykKihon3.createKykSyouhn();
        kykSyouhn13.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn13.setSyouhncd("M110");
        kykSyouhn13.setSyouhnsdno(6);
        kykSyouhn13.setKyksyouhnrenno(1);
        kykSyouhn13.setKouryokuhasseiymd(BizDate.valueOf(20150408));
        kykSyouhn13.setGyoumuKousinKinou("117");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("20141210143615501");

        IT_KykSyouhnRireki kykSyouhnRireki8 = khTtdkRireki3.createKykSyouhnRireki();
        kykSyouhnRireki8.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki8.setSyouhncd("M110");
        kykSyouhnRireki8.setSyouhnsdno(1);
        kykSyouhnRireki8.setKyksyouhnrenno(1);
        kykSyouhnRireki8.setKouryokuhasseiymd(BizDate.valueOf(20150403));
        kykSyouhnRireki8.setGyoumuKousinKinou("115");

        IT_KykSyouhnRireki kykSyouhnRireki9 = khTtdkRireki3.createKykSyouhnRireki();
        kykSyouhnRireki9.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki9.setSyouhncd("M110");
        kykSyouhnRireki9.setSyouhnsdno(2);
        kykSyouhnRireki9.setKyksyouhnrenno(1);
        kykSyouhnRireki9.setKouryokuhasseiymd(BizDate.valueOf(20150406));
        kykSyouhnRireki9.setGyoumuKousinKinou("116");

        IT_KykSyouhnRireki kykSyouhnRireki10 = khTtdkRireki3.createKykSyouhnRireki();
        kykSyouhnRireki10.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki10.setSyouhncd("M110");
        kykSyouhnRireki10.setSyouhnsdno(3);
        kykSyouhnRireki10.setKyksyouhnrenno(1);
        kykSyouhnRireki10.setKouryokuhasseiymd(BizDate.valueOf(20150402));
        kykSyouhnRireki10.setGyoumuKousinKinou("116");

        IT_KykSyouhnRireki kykSyouhnRireki11 = khTtdkRireki3.createKykSyouhnRireki();
        kykSyouhnRireki11.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki11.setSyouhncd("M110");
        kykSyouhnRireki11.setSyouhnsdno(4);
        kykSyouhnRireki11.setKyksyouhnrenno(1);
        kykSyouhnRireki11.setKouryokuhasseiymd(BizDate.valueOf(20150502));
        kykSyouhnRireki11.setGyoumuKousinKinou("117");

        IT_KykSyouhnRireki kykSyouhnRireki12 = khTtdkRireki3.createKykSyouhnRireki();
        kykSyouhnRireki12.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki12.setSyouhncd("M120");
        kykSyouhnRireki12.setSyouhnsdno(5);
        kykSyouhnRireki12.setKyksyouhnrenno(1);
        kykSyouhnRireki12.setKouryokuhasseiymd(BizDate.valueOf(20150409));
        kykSyouhnRireki12.setGyoumuKousinKinou("117");

        IT_KykSyouhnRireki kykSyouhnRireki13 = khTtdkRireki3.createKykSyouhnRireki();
        kykSyouhnRireki13.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki13.setSyouhncd("M110");
        kykSyouhnRireki13.setSyouhnsdno(6);
        kykSyouhnRireki13.setKyksyouhnrenno(1);
        kykSyouhnRireki13.setKouryokuhasseiymd(BizDate.valueOf(20150406));
        kykSyouhnRireki13.setGyoumuKousinKinou("117");

        IT_KykSyouhnRireki kykSyouhnRireki14 = khTtdkRireki3.createKykSyouhnRireki();
        kykSyouhnRireki14.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki14.setSyouhncd("M110");
        kykSyouhnRireki14.setSyouhnsdno(7);
        kykSyouhnRireki14.setKyksyouhnrenno(3);
        kykSyouhnRireki14.setKouryokuhasseiymd(BizDate.valueOf(20150407));
        kykSyouhnRireki14.setGyoumuKousinKinou("118");

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("10", "11807000043");

        IT_KykSyouhn kykSyouhn14 = kykKihon4.createKykSyouhn();
        kykSyouhn14.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn14.setSyouhncd("M110");
        kykSyouhn14.setSyouhnsdno(1);
        kykSyouhn14.setKyksyouhnrenno(1);
        kykSyouhn14.setKouryokuhasseiymd(BizDate.valueOf(20140401));
        kykSyouhn14.setGyoumuKousinKinou("121");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("20141210143615501");

        IT_KykSyouhnRireki kykSyouhnRireki15 = khTtdkRireki4.createKykSyouhnRireki();
        kykSyouhnRireki15.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki15.setSyouhncd("M110");
        kykSyouhnRireki15.setSyouhnsdno(1);
        kykSyouhnRireki15.setKyksyouhnrenno(1);
        kykSyouhnRireki15.setKouryokuhasseiymd(BizDate.valueOf(20140201));
        kykSyouhnRireki15.setGyoumuKousinKinou("122");

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("10", "11807000054");

        IT_KykSyouhn kykSyouhn15 = kykKihon5.createKykSyouhn();
        kykSyouhn15.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn15.setSyouhncd("M110");
        kykSyouhn15.setSyouhnsdno(1);
        kykSyouhn15.setKyksyouhnrenno(1);
        kykSyouhn15.setKouryokuhasseiymd(BizDate.valueOf(20140301));
        kykSyouhn15.setGyoumuKousinKinou("122");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("20141210143615501");

        IT_KykSyouhnRireki kykSyouhnRireki16 = khTtdkRireki5.createKykSyouhnRireki();
        kykSyouhnRireki16.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki16.setSyouhncd("M110");
        kykSyouhnRireki16.setSyouhnsdno(1);
        kykSyouhnRireki16.setKyksyouhnrenno(1);
        kykSyouhnRireki16.setKouryokuhasseiymd(BizDate.valueOf(20140501));
        kykSyouhnRireki16.setGyoumuKousinKinou("121");

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("10", "11807000065");

        IT_KykSyouhn kykSyouhn16 = kykKihon6.createKykSyouhn();
        kykSyouhn16.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn16.setSyouhncd("M110");
        kykSyouhn16.setSyouhnsdno(1);
        kykSyouhn16.setKyksyouhnrenno(1);
        kykSyouhn16.setKouryokuhasseiymd(BizDate.valueOf(20140701));
        kykSyouhn16.setGyoumuKousinKinou("125");

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("10", "11807000076");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon7.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("20141210143615501");

        IT_KykSyouhnRireki kykSyouhnRireki17 = khTtdkRireki6.createKykSyouhnRireki();
        kykSyouhnRireki17.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhnRireki17.setSyouhncd("M110");
        kykSyouhnRireki17.setSyouhnsdno(1);
        kykSyouhnRireki17.setKyksyouhnrenno(1);
        kykSyouhnRireki17.setKouryokuhasseiymd(BizDate.valueOf(20140702));
        kykSyouhnRireki17.setGyoumuKousinKinou("125");

        hozenDomManager.insert(kykKihon7);


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

        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnsyouhntaniBySyonoBeanLst = hozenDomManager.getKykSyouhnsyouhntaniBySyono("11807000087");
        Assert.assertEquals(0, kykSyouhnsyouhntaniBySyonoBeanLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnsyouhntaniBySyonoBeanLst = hozenDomManager.getKykSyouhnsyouhntaniBySyono("11807000010");

        Assert.assertEquals(1, kykSyouhnsyouhntaniBySyonoBeanLst.size());
        Assert.assertEquals(BizDate.valueOf(20150201), kykSyouhnsyouhntaniBySyonoBeanLst.get(0).getKouryokuhasseiymd());
        Assert.assertEquals(null, kykSyouhnsyouhntaniBySyonoBeanLst.get(0).getGyoumuKousinKinou());

    }
    @Test
    @TestOrder(30)
    public void normal2() {

        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnsyouhntaniBySyonoBeanLst = hozenDomManager.getKykSyouhnsyouhntaniBySyono("11807000065");

        Assert.assertEquals(1, kykSyouhnsyouhntaniBySyonoBeanLst.size());
        Assert.assertEquals(BizDate.valueOf(20140701), kykSyouhnsyouhntaniBySyonoBeanLst.get(0).getKouryokuhasseiymd());
        Assert.assertEquals("125", kykSyouhnsyouhntaniBySyonoBeanLst.get(0).getGyoumuKousinKinou());

    }
    @Test
    @TestOrder(40)
    public void normal3() {

        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnsyouhntaniBySyonoBeanLst = hozenDomManager.getKykSyouhnsyouhntaniBySyono("11807000076");

        Assert.assertEquals(1, kykSyouhnsyouhntaniBySyonoBeanLst.size());
        Assert.assertEquals(BizDate.valueOf(20140702), kykSyouhnsyouhntaniBySyonoBeanLst.get(0).getKouryokuhasseiymd());
        Assert.assertEquals("125", kykSyouhnsyouhntaniBySyonoBeanLst.get(0).getGyoumuKousinKinou());

    }

    @Test
    @TestOrder(50)
    public void normal5() {

        HashMap<String,String> datamap1 = new HashMap<String,String>();
        datamap1.put($(BizDate.valueOf(20150105),"null"), "1");
        datamap1.put($("null","112"), "2");
        datamap1.put($("null","111"), "3");
        datamap1.put($(BizDate.valueOf(20150407),"131"), "4");

        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnsyouhntaniBySyonoBeanLst = hozenDomManager.getKykSyouhnsyouhntaniBySyono("11807000021");

        for(KykSyouhnsyouhntaniBySyonoBean bean:kykSyouhnsyouhntaniBySyonoBeanLst){
            String kouryokuhasseiymd ="null";
            String gyoumuKousinKinou ="null";

            if(!(bean.getKouryokuhasseiymd()==null)){
                kouryokuhasseiymd = bean.getKouryokuhasseiymd().toString();
            }
            if(!(bean.getGyoumuKousinKinou()==null)){
                gyoumuKousinKinou = bean.getGyoumuKousinKinou();
            }

            datamap1.remove($(kouryokuhasseiymd,gyoumuKousinKinou));
        }

        Assert.assertTrue(datamap1.isEmpty());

    }

    @Test
    @TestOrder(60)
    public void normal6() {

        HashMap<String,String> datamap2 = new HashMap<String,String>();
        datamap2.put($(BizDate.valueOf(20150501),"116"), "1");
        datamap2.put($(BizDate.valueOf(20150502),"117"), "2");
        datamap2.put($(BizDate.valueOf(20150402),"114"), "3");
        datamap2.put($(BizDate.valueOf(20150403),"115"), "4");
        datamap2.put($(BizDate.valueOf(20150407),"118"), "5");

        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnsyouhntaniBySyonoBeanLst = hozenDomManager.getKykSyouhnsyouhntaniBySyono("11807000032");

        for(KykSyouhnsyouhntaniBySyonoBean bean:kykSyouhnsyouhntaniBySyonoBeanLst){

            datamap2.remove($(bean.getKouryokuhasseiymd(),bean.getGyoumuKousinKinou()));
        }

        Assert.assertTrue(datamap2.isEmpty());

    }

    @Test
    @TestOrder(70)
    public void normal7() {
        HashMap<String,String> datamap3 = new HashMap<String,String>();
        datamap3.put($(BizDate.valueOf(20140401),"121"), "1");
        datamap3.put($(BizDate.valueOf(20140201),"122"), "2");

        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnsyouhntaniBySyonoBeanLst = hozenDomManager.getKykSyouhnsyouhntaniBySyono("11807000043");

        for(KykSyouhnsyouhntaniBySyonoBean bean:kykSyouhnsyouhntaniBySyonoBeanLst){

            datamap3.remove($(bean.getKouryokuhasseiymd(),bean.getGyoumuKousinKinou()));
        }

        Assert.assertTrue(datamap3.isEmpty());
    }

    @Test
    @TestOrder(80)
    public void blankCondition1() {
        List<KykSyouhnsyouhntaniBySyonoBean> kykSyouhnsyouhntaniBySyonoBeanLst = hozenDomManager.getKykSyouhnsyouhntaniBySyono("");

        Assert.assertEquals(0, kykSyouhnsyouhntaniBySyonoBeanLst.size());
    }
}
