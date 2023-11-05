package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        Assert.assertEquals(null, hozenDomManager.getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai("11807111118", "1001", 21, C_Kykjyoutai.HRKMTYUU));

        IT_KykKihon kykKihon1 = new IT_KykKihon("11", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("20161001");

        IT_KykSyouhnRireki kykSyouhnRireki1 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki1.setSyouhncd("1001");
        kykSyouhnRireki1.setSyouhnsdno(21);
        kykSyouhnRireki1.setKyksyouhnrenno(31);
        kykSyouhnRireki1.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        kykSyouhnRireki1.setKouryokuhasseiymd(BizDate.valueOf(20160228));

        IT_KykSyouhnRireki kykSyouhnRireki2 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki2.setSyouhncd("1001");
        kykSyouhnRireki2.setSyouhnsdno(21);
        kykSyouhnRireki2.setKyksyouhnrenno(32);
        kykSyouhnRireki2.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        kykSyouhnRireki2.setKouryokuhasseiymd(BizDate.valueOf(20160215));

        IT_KykSyouhnRireki kykSyouhnRireki3 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki3.setSyouhncd("1001");
        kykSyouhnRireki3.setSyouhnsdno(21);
        kykSyouhnRireki3.setKyksyouhnrenno(33);
        kykSyouhnRireki3.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        kykSyouhnRireki3.setKouryokuhasseiymd(BizDate.valueOf(20160205));

        IT_KykSyouhnRireki kykSyouhnRireki5 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki5.setSyouhncd("1002");
        kykSyouhnRireki5.setSyouhnsdno(21);
        kykSyouhnRireki5.setKyksyouhnrenno(31);
        kykSyouhnRireki5.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        kykSyouhnRireki5.setKouryokuhasseiymd(BizDate.valueOf(20160201));

        IT_KykSyouhnRireki kykSyouhnRireki6 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki6.setSyouhncd("1001");
        kykSyouhnRireki6.setSyouhnsdno(22);
        kykSyouhnRireki6.setKyksyouhnrenno(31);
        kykSyouhnRireki6.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        kykSyouhnRireki6.setKouryokuhasseiymd(BizDate.valueOf(20160201));

        IT_KykSyouhnRireki kykSyouhnRireki7 = khTtdkRireki1.createKykSyouhnRireki();
        kykSyouhnRireki7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki7.setSyouhncd("1001");
        kykSyouhnRireki7.setSyouhnsdno(21);
        kykSyouhnRireki7.setKyksyouhnrenno(34);
        kykSyouhnRireki7.setKykjyoutai(C_Kykjyoutai.BLNK);
        kykSyouhnRireki7.setKouryokuhasseiymd(BizDate.valueOf(20160201));

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("11", "11807111129");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("20161001");

        IT_KykSyouhnRireki kykSyouhnRireki4 = khTtdkRireki2.createKykSyouhnRireki();
        kykSyouhnRireki4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhnRireki4.setSyouhncd("1001");
        kykSyouhnRireki4.setSyouhnsdno(21);
        kykSyouhnRireki4.setKyksyouhnrenno(31);
        kykSyouhnRireki4.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        kykSyouhnRireki4.setKouryokuhasseiymd(BizDate.valueOf(20160201));

        hozenDomManager.insert(kykKihon2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }
    @Test
    @TestOrder(10)
    public void noResult1(){

        BizDate result = hozenDomManager.getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai("11807111129", "1002", 22, C_Kykjyoutai.BLNK);
        Assert.assertNull(result);

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        BizDate result = hozenDomManager.getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai("11807111118", "1001", 21, C_Kykjyoutai.HRKMTYUU);
        Assert.assertEquals(BizDate.valueOf(20160205), result);
    }
    @Test
    @TestOrder(30)
    public void blankCondition1(){

        BizDate result = hozenDomManager.getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai("", "1001", 21, C_Kykjyoutai.HRKMTYUU);
        Assert.assertNull(result);
    }
    @Test
    @TestOrder(40)
    public void blankCondition2() {

        BizDate result = hozenDomManager.getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai("11807111118", "", 21, C_Kykjyoutai.HRKMTYUU);
        Assert.assertNull(result);

    }
}
