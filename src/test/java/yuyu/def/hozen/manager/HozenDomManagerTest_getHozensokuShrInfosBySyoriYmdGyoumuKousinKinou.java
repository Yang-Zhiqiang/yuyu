package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

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

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        ExDBResults<HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20160821), BizDate.valueOf(20160823), "hozen");

        int iCount = 0;
        for (HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn1.setSyouhncd("M101");
        kykSyouhn1.setSyouhnsdno(1);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("2016082310011001");
        khTtdkRireki1.setSyoriYmd(BizDate.valueOf(20160822));
        khTtdkRireki1.setGyoumuKousinKinou("hozen");

        IT_KhShrRireki khShrRireki1 = khTtdkRireki1.createKhShrRireki();

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("2016082310011002");
        khTtdkRireki2.setSyoriYmd(BizDate.valueOf(20160820));
        khTtdkRireki2.setGyoumuKousinKinou("hozen");

        IT_KhShrRireki khShrRireki2 = khTtdkRireki2.createKhShrRireki();

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("2016082310011003");
        khTtdkRireki3.setSyoriYmd(BizDate.valueOf(20160824));
        khTtdkRireki3.setGyoumuKousinKinou("hozen");

        IT_KhShrRireki khShrRireki3 = khTtdkRireki3.createKhShrRireki();

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("2016082310011004");
        khTtdkRireki4.setSyoriYmd(BizDate.valueOf(20160822));
        khTtdkRireki4.setGyoumuKousinKinou("khmeigihenkou");

        IT_KhShrRireki khShrRireki4 = khTtdkRireki4.createKhShrRireki();

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("2016082310011005");
        khTtdkRireki8.setSyoriYmd(BizDate.valueOf(20160822));
        khTtdkRireki8.setGyoumuKousinKinou("hozen");

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("2016082310011001");
        khTtdkRireki5.setSyoriYmd(BizDate.valueOf(20160822));
        khTtdkRireki5.setGyoumuKousinKinou("hozen");

        IT_KhShrRireki khShrRireki5 = khTtdkRireki5.createKhShrRireki();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("01", "11807111130");

        IT_KykSyouhn kykSyouhn2 = kykKihon3.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.valueOf("0"));
        kykSyouhn2.setSyouhncd("M101");
        kykSyouhn2.setSyouhnsdno(1);
        kykSyouhn2.setKyksyouhnrenno(1);

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("2016082310011001");
        khTtdkRireki6.setSyoriYmd(BizDate.valueOf(20160822));
        khTtdkRireki6.setGyoumuKousinKinou("hozen");

        IT_KhShrRireki khShrRireki6 = khTtdkRireki6.createKhShrRireki();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KykSyouhn kykSyouhn3 = kykKihon4.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn3.setSyouhncd("M101");
        kykSyouhn3.setSyouhnsdno(1);
        kykSyouhn3.setKyksyouhnrenno(1);

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn4 = kykKihon5.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn4.setSyouhncd("M101");
        kykSyouhn4.setSyouhnsdno(1);
        kykSyouhn4.setKyksyouhnrenno(1);

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("2016082310011001");
        khTtdkRireki7.setSyoriYmd(BizDate.valueOf(20160822));
        khTtdkRireki7.setGyoumuKousinKinou("hozen");

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KykSyouhn kykSyouhn5 = kykKihon6.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.valueOf("1"));
        kykSyouhn5.setSyouhncd("M101");
        kykSyouhn5.setSyouhnsdno(1);
        kykSyouhn5.setKyksyouhnrenno(1);

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("2016082310011001");
        khTtdkRireki9.setSyoriYmd(BizDate.valueOf(20160920));
        khTtdkRireki9.setGyoumuKousinKinou("khjyuusyohenkou");

        IT_KhShrRireki khShrRireki7 = khTtdkRireki9.createKhShrRireki();

        IT_KhTtdkRireki khTtdkRireki10 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki10.setHenkousikibetukey("2016082310011002");
        khTtdkRireki10.setSyoriYmd(BizDate.valueOf(20160921));
        khTtdkRireki10.setGyoumuKousinKinou("khjyuusyohenkou");

        IT_KhShrRireki khShrRireki8 = khTtdkRireki10.createKhShrRireki();

        IT_KhTtdkRireki khTtdkRireki11 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki11.setHenkousikibetukey("2016082310011003");
        khTtdkRireki11.setSyoriYmd(BizDate.valueOf(20160922));
        khTtdkRireki11.setGyoumuKousinKinou("khjyuusyohenkou");

        IT_KhShrRireki khShrRireki9 = khTtdkRireki11.createKhShrRireki();

        hozenDomManager.insert(kykKihon6);
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

        ExDBResults<HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20160821), BizDate.valueOf(20160823), "khkaiyaku");

        int iCount = 0;
        for (HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {


        ExDBResults<HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20160821), BizDate.valueOf(20160823), "hozen");

        int iCount = 0;
        for (HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean fKSKbean : beans) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals("01", fKSKbean.getIT_KykKihon().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KykKihon().getSyono());

                Assert.assertEquals("01", fKSKbean.getIT_KykSyouhn().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KykSyouhn().getSyono());
                Assert.assertEquals(C_SyutkKbn.SYU, fKSKbean.getIT_KykSyouhn().getSyutkkbn());
                Assert.assertEquals("M101", fKSKbean.getIT_KykSyouhn().getSyouhncd());
                Assert.assertEquals(1, fKSKbean.getIT_KykSyouhn().getSyouhnsdno().intValue());
                Assert.assertEquals(1, fKSKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue());

                Assert.assertEquals("01", fKSKbean.getIT_KhTtdkRireki().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KhTtdkRireki().getSyono());
                Assert.assertEquals("2016082310011001", fKSKbean.getIT_KhTtdkRireki().getHenkousikibetukey());

                Assert.assertEquals("01", fKSKbean.getIT_KhTtdkRireki().getKbnkey());
                Assert.assertEquals("11807111118", fKSKbean.getIT_KhTtdkRireki().getSyono());
                Assert.assertEquals("2016082310011001", fKSKbean.getIT_KhTtdkRireki().getHenkousikibetukey());
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBeanMap = new HashMap<String, String>();
        hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBeanMap.put($("06", "11807111163", "06", "11807111163", C_SyutkKbn.SYU, "M101", 1, 1, "06", "11807111163", "2016082310011001", "06", "11807111163", "2016082310011001"),"1");
        hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBeanMap.put($("06", "11807111163", "06", "11807111163", C_SyutkKbn.SYU, "M101", 1, 1, "06", "11807111163", "2016082310011002", "06", "11807111163", "2016082310011002"),"1");
        hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBeanMap.put($("06", "11807111163", "06", "11807111163", C_SyutkKbn.SYU, "M101", 1, 1, "06", "11807111163", "2016082310011003", "06", "11807111163", "2016082310011003"),"1");

        ExDBResults<HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20160920), BizDate.valueOf(20160922), "khjyuusyohenkou");

        int iCount = 0;
        for (HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean fKSKbean : beans) {
            iCount++;
            hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBeanMap.remove($(fKSKbean.getIT_KykKihon().getKbnkey(),fKSKbean.getIT_KykKihon().getSyono(),
                fKSKbean.getIT_KykSyouhn().getKbnkey(),fKSKbean.getIT_KykSyouhn().getSyono(),fKSKbean.getIT_KykSyouhn().getSyutkkbn(),
                fKSKbean.getIT_KykSyouhn().getSyouhncd(),fKSKbean.getIT_KykSyouhn().getSyouhnsdno().intValue(),fKSKbean.getIT_KykSyouhn().getKyksyouhnrenno().intValue(),
                fKSKbean.getIT_KhTtdkRireki().getKbnkey(),fKSKbean.getIT_KhTtdkRireki().getSyono(),fKSKbean.getIT_KhTtdkRireki().getHenkousikibetukey(),
                fKSKbean.getIT_KhTtdkRireki().getKbnkey(), fKSKbean.getIT_KhTtdkRireki().getSyono(),fKSKbean.getIT_KhTtdkRireki().getHenkousikibetukey()));

        }
        Assert.assertEquals(3, iCount);
        assertTrue(hozensokuShrInfosBySyoriYmdGyoumuKousinKinouBeanMap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        ExDBResults<HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHozensokuShrInfosBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20160821), BizDate.valueOf(20160823), "");

        int iCount = 0;
        for (HozensokuShrInfosBySyoriYmdGyoumuKousinKinouBean fKSKbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }
}


