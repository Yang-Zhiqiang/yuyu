package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
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

import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou2 {

    @Inject
    HozenDomManager hozenDomManager;

    private  static final String[] kinouid_1 = {"kykjyouhoutorikomi"};
    private  static final String[] kinouid_2 = {"shiharaijyouhoutorikomi", "kaiyaku", "gengaku"};
    private  static final String[] kinouid_3 = {"kykjyouhoutorikomi", "kaiyaku"};
    private  static final String[] kinouid_4 = {"kykjyouhoutorikomi", "shiharaijyouhoutorikomi", "kaiyaku"};
    private  static final String[] kinouid_0 = {""};
    private  static final String kinouid = "other";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);


        ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20161128), kinouid_1, kinouid);

        int iCount = 0;
        for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("0001");
        khTtdkRireki1.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki1.setGyoumuKousinKinou("kykjyouhoutorikomi");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("111");
        kykSyouhn1.setSyouhnsdno(01);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(2);

        IT_KykSonotaTkyk kykSonotaTkyk1 = kykKihon1.createKykSonotaTkyk();

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("0002");
        khTtdkRireki2.setSyoriYmd(BizDate.valueOf(20161127));
        khTtdkRireki2.setGyoumuKousinKinou("kykjyouhoutorikomi");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("111");
        kykSyouhn2.setSyouhnsdno(02);
        kykSyouhn2.setKyksyouhnrenno(2);

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        IT_KykDairiten kykDairiten2 = kykKihon2.createKykDairiten();
        kykDairiten2.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk2 = kykKihon2.createKykSonotaTkyk();

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("0003");
        khTtdkRireki3.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki3.setGyoumuKousinKinou("nothing");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("111");
        kykSyouhn3.setSyouhnsdno(03);
        kykSyouhn3.setKyksyouhnrenno(3);

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();

        IT_KykDairiten kykDairiten3 = kykKihon3.createKykDairiten();
        kykDairiten3.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk3 = kykKihon3.createKykSonotaTkyk();

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("0004");
        khTtdkRireki4.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki4.setSyorikbn(C_SyoriKbn.BLNK );
        khTtdkRireki4.setGyoumuKousinKinou("other");

        IT_KykSyouhn kykSyouhn4 = kykKihon4.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("111");
        kykSyouhn4.setSyouhnsdno(04);
        kykSyouhn4.setKyksyouhnrenno(4);

        IT_HhknSya hhknSya4 = kykKihon4.createHhknSya();

        IT_KykDairiten kykDairiten4 = kykKihon4.createKykDairiten();
        kykDairiten4.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk4 = kykKihon4.createKykSonotaTkyk();

        IT_KykSya kykSya4 = kykKihon4.createKykSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("111");
        kykSyouhn5.setSyouhnsdno(05);
        kykSyouhn5.setKyksyouhnrenno(5);

        IT_HhknSya hhknSya5 = kykKihon5.createHhknSya();

        IT_KykDairiten kykDairiten5 = kykKihon5.createKykDairiten();
        kykDairiten5.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk5 = kykKihon5.createKykSonotaTkyk();

        IT_KykSya kykSya5 = kykKihon5.createKykSya();

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("0005");
        khTtdkRireki5.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki5.setGyoumuKousinKinou("kykjyouhoutorikomi");

        IT_HhknSya hhknSya6 = kykKihon6.createHhknSya();

        IT_KykDairiten kykDairiten6 = kykKihon6.createKykDairiten();
        kykDairiten6.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk6 = kykKihon6.createKykSonotaTkyk();

        IT_KykSya kykSya6 = kykKihon6.createKykSya();

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon7.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("0006");
        khTtdkRireki6.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki6.setGyoumuKousinKinou("kykjyouhoutorikomi");

        IT_KykSyouhn kykSyouhn6 = kykKihon7.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setSyouhncd("111");
        kykSyouhn6.setSyouhnsdno(06);
        kykSyouhn6.setKyksyouhnrenno(11);

        IT_KykDairiten kykDairiten7 = kykKihon7.createKykDairiten();
        kykDairiten7.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk7 = kykKihon7.createKykSonotaTkyk();

        IT_KykSya kykSya7 = kykKihon7.createKykSya();

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("08", "11807111185");

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon8.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("0007");
        khTtdkRireki7.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki7.setGyoumuKousinKinou("kykjyouhoutorikomi");

        IT_KykSyouhn kykSyouhn7 = kykKihon8.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setSyouhncd("111");
        kykSyouhn7.setSyouhnsdno(07);
        kykSyouhn7.setKyksyouhnrenno(22);

        IT_HhknSya hhknSya7 = kykKihon8.createHhknSya();

        IT_KykSonotaTkyk kykSonotaTkyk8 = kykKihon8.createKykSonotaTkyk();

        IT_KykSya kykSya8 = kykKihon8.createKykSya();

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("09", "11807111196");

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon9.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("0008");
        khTtdkRireki8.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki8.setGyoumuKousinKinou("kykjyouhoutorikomi");

        IT_KykSyouhn kykSyouhn8 = kykKihon9.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn8.setSyouhncd("111");
        kykSyouhn8.setSyouhnsdno(12);
        kykSyouhn8.setKyksyouhnrenno(33);

        IT_HhknSya hhknSya8 = kykKihon9.createHhknSya();

        IT_KykDairiten kykDairiten8 = kykKihon9.createKykDairiten();
        kykDairiten8.setDrtenrenno(1);

        IT_KykSya kykSya9 = kykKihon9.createKykSya();

        hozenDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon("10", "11807111200");

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon10.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("0009");
        khTtdkRireki9.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki9.setGyoumuKousinKinou("kykjyouhoutorikomi");

        IT_KykSyouhn kykSyouhn9 = kykKihon10.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn9.setSyouhncd("111");
        kykSyouhn9.setSyouhnsdno(13);
        kykSyouhn9.setKyksyouhnrenno(44);

        IT_HhknSya hhknSya9 = kykKihon10.createHhknSya();

        IT_KykDairiten kykDairiten9 = kykKihon10.createKykDairiten();
        kykDairiten9.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk9 = kykKihon10.createKykSonotaTkyk();

        IT_KykSya kykSya10 = kykKihon10.createKykSya();

        hozenDomManager.insert(kykKihon10);

        IT_KykKihon kykKihon11 = new IT_KykKihon("11", "11807111211");

        IT_KhTtdkRireki khTtdkRireki10 = kykKihon11.createKhTtdkRireki();
        khTtdkRireki10.setHenkousikibetukey("0010");
        khTtdkRireki10.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki10.setGyoumuKousinKinou("kykjyouhoutorikomi");

        IT_KykSyouhn kykSyouhn10 = kykKihon11.createKykSyouhn();
        kykSyouhn10.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn10.setSyouhncd("111");
        kykSyouhn10.setSyouhnsdno(10);
        kykSyouhn10.setKyksyouhnrenno(55);

        IT_HhknSya hhknSya10 = kykKihon11.createHhknSya();

        IT_KykSonotaTkyk kykSonotaTkyk10 = kykKihon11.createKykSonotaTkyk();

        IT_KykSya kykSya11 = kykKihon11.createKykSya();

        hozenDomManager.insert(kykKihon11);

        IT_KykKihon kykKihon12 = new IT_KykKihon("12", "11807111222");

        IT_KhTtdkRireki khTtdkRireki11 = kykKihon12.createKhTtdkRireki();
        khTtdkRireki11.setHenkousikibetukey("0011");
        khTtdkRireki11.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki11.setGyoumuKousinKinou("kykjyouhoutorikomi");

        IT_KykSyouhn kykSyouhn11 = kykKihon12.createKykSyouhn();
        kykSyouhn11.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn11.setSyouhncd("111");
        kykSyouhn11.setSyouhnsdno(14);
        kykSyouhn11.setKyksyouhnrenno(66);

        IT_HhknSya hhknSya11 = kykKihon12.createHhknSya();

        IT_KykDairiten kykDairiten10 = kykKihon12.createKykDairiten();
        kykDairiten10.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk11 = kykKihon12.createKykSonotaTkyk();

        hozenDomManager.insert(kykKihon12);
    }

    @Test
    @TestOrder(10)
    public void noResult10() {
        ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20161128), kinouid_2, kinouid);

        int iCount = 0;
        for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal20() {

        ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20161128), kinouid_3, kinouid);

        int iCount = 0;
        for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {
            Assert.assertEquals(bean.getIT_KykKihon().getSyono(), "11807111118");

            Assert.assertEquals(bean.getIT_KhTtdkRireki().getSyono(), "11807111118");
            Assert.assertEquals(bean.getIT_KhTtdkRireki().getHenkousikibetukey(), "0001");

            Assert.assertEquals(bean.getIT_KykSyouhn().getSyono(), "11807111118");
            Assert.assertEquals(bean.getIT_KykSyouhn().getSyutkkbn(), C_SyutkKbn.SYU);
            Assert.assertEquals(bean.getIT_KykSyouhn().getSyouhncd(), "111");
            Assert.assertEquals(bean.getIT_KykSyouhn().getSyouhnsdno().intValue(), 01);
            Assert.assertEquals(bean.getIT_KykSyouhn().getKyksyouhnrenno().intValue(), 1);

            Assert.assertEquals(bean.getIT_HhknSya().getSyono(), "11807111118");

            Assert.assertEquals(bean.getIT_KykDairiten().getSyono(), "11807111118");
            Assert.assertEquals(bean.getIT_KykDairiten().getDrtenrenno().intValue(), 2);

            Assert.assertEquals(bean.getIT_KykSonotaTkyk().getSyono(), "11807111118");

            Assert.assertEquals(bean.getIT_KykSya().getSyono(), "11807111118");

            iCount++;
        }
        Assert.assertEquals(1, iCount);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal30() {

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("0001");
        khTtdkRireki1.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki1.setGyoumuKousinKinou("kykjyouhoutorikomi");

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("111");
        kykSyouhn1.setSyouhnsdno(01);
        kykSyouhn1.setKyksyouhnrenno(1);

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk1 = kykKihon1.createKykSonotaTkyk();

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        hozenDomManager.insert(kykKihon1);

        IT_KykKihon kykKihon2 = new IT_KykKihon("02", "11807111129");

        IT_KhTtdkRireki khTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("0002");
        khTtdkRireki2.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki2.setGyoumuKousinKinou("shiharaijyouhoutorikomi");

        IT_KykSyouhn kykSyouhn2 = kykKihon2.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("111");
        kykSyouhn2.setSyouhnsdno(02);
        kykSyouhn2.setKyksyouhnrenno(2);

        IT_HhknSya hhknSya2 = kykKihon2.createHhknSya();

        IT_KykDairiten kykDairiten2 = kykKihon2.createKykDairiten();
        kykDairiten2.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk2 = kykKihon2.createKykSonotaTkyk();

        IT_KykSya kykSya2 = kykKihon2.createKykSya();

        hozenDomManager.insert(kykKihon2);

        IT_KykKihon kykKihon3 = new IT_KykKihon("03", "11807111130");

        IT_KhTtdkRireki khTtdkRireki3 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("0003");
        khTtdkRireki3.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki3.setGyoumuKousinKinou("kaiyaku");

        IT_KykSyouhn kykSyouhn3 = kykKihon3.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("111");
        kykSyouhn3.setSyouhnsdno(03);
        kykSyouhn3.setKyksyouhnrenno(3);

        IT_HhknSya hhknSya3 = kykKihon3.createHhknSya();

        IT_KykDairiten kykDairiten3 = kykKihon3.createKykDairiten();
        kykDairiten3.setDrtenrenno(1);

        IT_KykSonotaTkyk kykSonotaTkyk3 = kykKihon3.createKykSonotaTkyk();

        IT_KykSya kykSya3 = kykKihon3.createKykSya();

        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("04", "11807111141");

        IT_KhTtdkRireki khTtdkRireki4 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("0004");
        khTtdkRireki4.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki4.setSyorikbn(C_SyoriKbn.SBMUKOU_KIHRKPSHR);
        khTtdkRireki4.setGyoumuKousinKinou("other");

        IT_KykSyouhn kykSyouhn4 = kykKihon4.createKykSyouhn();
        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("111");
        kykSyouhn4.setSyouhnsdno(04);
        kykSyouhn4.setKyksyouhnrenno(4);

        IT_HhknSya hhknSya4 = kykKihon4.createHhknSya();

        IT_KykDairiten kykDairiten4 = kykKihon4.createKykDairiten();
        kykDairiten4.setDrtenrenno(2);

        IT_KykSonotaTkyk kykSonotaTkyk4 = kykKihon4.createKykSonotaTkyk();

        IT_KykSya kykSya4 = kykKihon4.createKykSya();

        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("05", "11807111152");

        IT_KhTtdkRireki khTtdkRireki5 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("0011");
        khTtdkRireki5.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki5.setSyorikbn(C_SyoriKbn.SBMUKOU_SHRNASI);
        khTtdkRireki5.setGyoumuKousinKinou("other");

        IT_KykSyouhn kykSyouhn5 = kykKihon5.createKykSyouhn();
        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("111");
        kykSyouhn5.setSyouhnsdno(05);
        kykSyouhn5.setKyksyouhnrenno(5);

        IT_HhknSya hhknSya5 = kykKihon5.createHhknSya();

        IT_KykDairiten kykDairiten5 = kykKihon5.createKykDairiten();
        kykDairiten5.setDrtenrenno(2);

        IT_KykSonotaTkyk kykSonotaTkyk5 = kykKihon5.createKykSonotaTkyk();

        IT_KykSya kykSya5 = kykKihon5.createKykSya();

        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("06", "11807111163");

        IT_KhTtdkRireki khTtdkRireki6 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki6.setHenkousikibetukey("0005");
        khTtdkRireki6.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki6.setSyorikbn(C_SyoriKbn.SBMUKOU);
        khTtdkRireki6.setGyoumuKousinKinou("other");

        IT_KykSyouhn kykSyouhn6 = kykKihon6.createKykSyouhn();
        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setSyouhncd("111");
        kykSyouhn6.setSyouhnsdno(11);
        kykSyouhn6.setKyksyouhnrenno(11);

        IT_HhknSya hhknSya6 = kykKihon6.createHhknSya();

        IT_KykDairiten kykDairiten6 = kykKihon6.createKykDairiten();
        kykDairiten6.setDrtenrenno(2);

        IT_KykSonotaTkyk kykSonotaTkyk6 = kykKihon6.createKykSonotaTkyk();

        IT_KykSya kykSya6 = kykKihon6.createKykSya();

        hozenDomManager.insert(kykKihon6);

        IT_KykKihon kykKihon7 = new IT_KykKihon("07", "11807111174");

        IT_KhTtdkRireki khTtdkRireki7 = kykKihon7.createKhTtdkRireki();
        khTtdkRireki7.setHenkousikibetukey("0006");
        khTtdkRireki7.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki7.setSyorikbn(C_SyoriKbn.SBKAIJO);
        khTtdkRireki7.setGyoumuKousinKinou("other");

        IT_KykSyouhn kykSyouhn7 = kykKihon7.createKykSyouhn();
        kykSyouhn7.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn7.setSyouhncd("111");
        kykSyouhn7.setSyouhnsdno(06);
        kykSyouhn7.setKyksyouhnrenno(22);

        IT_HhknSya hhknSya7 = kykKihon7.createHhknSya();

        IT_KykDairiten kykDairiten7 = kykKihon7.createKykDairiten();
        kykDairiten7.setDrtenrenno(2);

        IT_KykSonotaTkyk kykSonotaTkyk7 = kykKihon7.createKykSonotaTkyk();

        IT_KykSya kykSya7 = kykKihon7.createKykSya();

        hozenDomManager.insert(kykKihon7);

        IT_KykKihon kykKihon8 = new IT_KykKihon("08", "11807111185");

        IT_KhTtdkRireki khTtdkRireki8 = kykKihon8.createKhTtdkRireki();
        khTtdkRireki8.setHenkousikibetukey("0007");
        khTtdkRireki8.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki8.setSyorikbn(C_SyoriKbn.SBMENSEKI);
        khTtdkRireki8.setGyoumuKousinKinou("other");

        IT_KykSyouhn kykSyouhn8 = kykKihon8.createKykSyouhn();
        kykSyouhn8.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn8.setSyouhncd("111");
        kykSyouhn8.setSyouhnsdno(07);
        kykSyouhn8.setKyksyouhnrenno(33);

        IT_HhknSya hhknSya8 = kykKihon8.createHhknSya();

        IT_KykDairiten kykDairiten8 = kykKihon8.createKykDairiten();
        kykDairiten8.setDrtenrenno(2);

        IT_KykSonotaTkyk kykSonotaTkyk8 = kykKihon8.createKykSonotaTkyk();

        IT_KykSya kykSya8 = kykKihon8.createKykSya();

        hozenDomManager.insert(kykKihon8);

        IT_KykKihon kykKihon9 = new IT_KykKihon("09", "11807111196");

        IT_KhTtdkRireki khTtdkRireki9 = kykKihon9.createKhTtdkRireki();
        khTtdkRireki9.setHenkousikibetukey("0008");
        khTtdkRireki9.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki9.setSyorikbn(C_SyoriKbn.SBMENSEKI_SHRNASI);
        khTtdkRireki9.setGyoumuKousinKinou("other");

        IT_KykSyouhn kykSyouhn9 = kykKihon9.createKykSyouhn();
        kykSyouhn9.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn9.setSyouhncd("111");
        kykSyouhn9.setSyouhnsdno(12);
        kykSyouhn9.setKyksyouhnrenno(44);

        IT_HhknSya hhknSya9 = kykKihon9.createHhknSya();

        IT_KykDairiten kykDairiten9 = kykKihon9.createKykDairiten();
        kykDairiten9.setDrtenrenno(2);

        IT_KykSonotaTkyk kykSonotaTkyk9 = kykKihon9.createKykSonotaTkyk();

        IT_KykSya kykSya9 = kykKihon9.createKykSya();

        hozenDomManager.insert(kykKihon9);

        IT_KykKihon kykKihon10 = new IT_KykKihon("10", "11807111200");

        IT_KhTtdkRireki khTtdkRireki10 = kykKihon10.createKhTtdkRireki();
        khTtdkRireki10.setHenkousikibetukey("0009");
        khTtdkRireki10.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki10.setSyorikbn(C_SyoriKbn.SIBOU);
        khTtdkRireki10.setGyoumuKousinKinou("other");

        IT_KykSyouhn kykSyouhn10 = kykKihon10.createKykSyouhn();
        kykSyouhn10.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn10.setSyouhncd("111");
        kykSyouhn10.setSyouhnsdno(13);
        kykSyouhn10.setKyksyouhnrenno(55);

        IT_HhknSya hhknSya10 = kykKihon10.createHhknSya();

        IT_KykDairiten kykDairiten10 = kykKihon10.createKykDairiten();
        kykDairiten10.setDrtenrenno(2);

        IT_KykSonotaTkyk kykSonotaTkyk10 = kykKihon10.createKykSonotaTkyk();

        IT_KykSya kykSya10 = kykKihon10.createKykSya();

        hozenDomManager.insert(kykKihon10);

        IT_KykKihon kykKihon11 = new IT_KykKihon("11", "11807111211");

        IT_KhTtdkRireki khTtdkRireki11 = kykKihon11.createKhTtdkRireki();
        khTtdkRireki11.setHenkousikibetukey("0010");
        khTtdkRireki11.setSyoriYmd(BizDate.valueOf(20161128));
        khTtdkRireki11.setSyorikbn(C_SyoriKbn.SBKYUUHUSHR);
        khTtdkRireki11.setGyoumuKousinKinou("other");

        IT_KykSyouhn kykSyouhn11 = kykKihon11.createKykSyouhn();
        kykSyouhn11.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn11.setSyouhncd("111");
        kykSyouhn11.setSyouhnsdno(10);
        kykSyouhn11.setKyksyouhnrenno(66);

        IT_HhknSya hhknSya11 = kykKihon11.createHhknSya();

        IT_KykDairiten kykDairiten11 = kykKihon11.createKykDairiten();
        kykDairiten11.setDrtenrenno(2);

        IT_KykSonotaTkyk kykSonotaTkyk11 = kykKihon11.createKykSonotaTkyk();

        IT_KykSya kykSya11 = kykKihon11.createKykSya();

        hozenDomManager.insert(kykKihon11);

    }

    @Test
    @TestOrder(31)
    public void normal31() {
        Map<String,String> resultMap = new HashMap<String, String>();
        resultMap.put($("11807111118",
            "11807111118", "0001",
            "11807111118", C_SyutkKbn.SYU, "111", new Integer(01), new Integer(1),
            "11807111118",
            "11807111118", new Integer(1),
            "11807111118",
            "11807111118"), "1");

        resultMap.put($("11807111129",
            "11807111129", "0002",
            "11807111129", C_SyutkKbn.SYU, "111", new Integer(02), new Integer(2),
            "11807111129",
            "11807111129", new Integer(1),
            "11807111129",
            "11807111129"), "1");

        resultMap.put($("11807111130",
            "11807111130", "0003",
            "11807111130", C_SyutkKbn.SYU, "111", new Integer(03), new Integer(3),
            "11807111130",
            "11807111130", new Integer(1),
            "11807111130",
            "11807111130"), "1");

        resultMap.put($("11807111141",
            "11807111141", "0004",
            "11807111141", C_SyutkKbn.SYU, "111", new Integer(04), new Integer(4),
            "11807111141",
            "11807111141", new Integer(2),
            "11807111141",
            "11807111141"), "1");

        resultMap.put($("11807111152",
            "11807111152", "0011",
            "11807111152", C_SyutkKbn.SYU, "111", new Integer(05), new Integer(5),
            "11807111152",
            "11807111152", new Integer(2),
            "11807111152",
            "11807111152"), "1");

        resultMap.put($("11807111163",
            "11807111163", "0005",
            "11807111163", C_SyutkKbn.SYU, "111", new Integer(11), new Integer(11),
            "11807111163",
            "11807111163", new Integer(2),
            "11807111163",
            "11807111163"), "1");
        resultMap.put($("11807111174",
            "11807111174", "0006",
            "11807111174", C_SyutkKbn.SYU, "111", new Integer(06), new Integer(22),
            "11807111174",
            "11807111174", new Integer(2),
            "11807111174",
            "11807111174"), "1");

        resultMap.put($("11807111185",
            "11807111185", "0007",
            "11807111185", C_SyutkKbn.SYU, "111", new Integer(07), new Integer(33),
            "11807111185",
            "11807111185", new Integer(2),
            "11807111185",
            "11807111185"), "1");

        resultMap.put($("11807111196",
            "11807111196", "0008",
            "11807111196", C_SyutkKbn.SYU, "111", new Integer(12), new Integer(44),
            "11807111196",
            "11807111196", new Integer(2),
            "11807111196",
            "11807111196"), "1");
        resultMap.put($("11807111200",
            "11807111200", "0009",
            "11807111200", C_SyutkKbn.SYU, "111", new Integer(13), new Integer(55),
            "11807111200",
            "11807111200", new Integer(2),
            "11807111200",
            "11807111200"), "1");

        resultMap.put($("11807111211",
            "11807111211", "0010",
            "11807111211", C_SyutkKbn.SYU, "111", new Integer(10), new Integer(66),
            "11807111211",
            "11807111211", new Integer(2),
            "11807111211",
            "11807111211"), "1");

        try (ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20161128), kinouid_4, kinouid)){

            int iCount = 0;
            for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {

                iCount++;
                resultMap.remove($(bean.getIT_KykKihon().getSyono(),
                    bean.getIT_KhTtdkRireki().getSyono(), bean.getIT_KhTtdkRireki().getHenkousikibetukey(),
                    bean.getIT_KykSyouhn().getSyono(), bean.getIT_KykSyouhn().getSyutkkbn(), bean.getIT_KykSyouhn().getSyouhncd(),
                    bean.getIT_KykSyouhn().getSyouhnsdno(), bean.getIT_KykSyouhn().getKyksyouhnrenno(),
                    bean.getIT_HhknSya().getSyono(),
                    bean.getIT_KykDairiten().getSyono(), bean.getIT_KykDairiten().getDrtenrenno(),
                    bean.getIT_KykSonotaTkyk().getSyono(),
                    bean.getIT_KykSya().getSyono()));

            }
            Assert.assertEquals(11, iCount);
            assertTrue(resultMap.isEmpty());
        }

    }

    @Test
    @TestOrder(40)
    public void blankCondition40() {
        Map<String,String> resultMap = new HashMap<String, String>();
        resultMap.put($("11807111118",
            "11807111118", "0001",
            "11807111118", C_SyutkKbn.SYU, "111", new Integer(01), new Integer(1),
            "11807111118",
            "11807111118", new Integer(1),
            "11807111118",
            "11807111118"), "1");

        resultMap.put($("11807111129",
            "11807111129", "0002",
            "11807111129", C_SyutkKbn.SYU, "111", new Integer(02), new Integer(2),
            "11807111129",
            "11807111129", new Integer(1),
            "11807111129",
            "11807111129"), "1");

        resultMap.put($("11807111130",
            "11807111130", "0003",
            "11807111130", C_SyutkKbn.SYU, "111", new Integer(03), new Integer(3),
            "11807111130",
            "11807111130", new Integer(1),
            "11807111130",
            "11807111130"), "1");

        try (ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20161128), kinouid_4, "")){

            int iCount = 0;
            for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {

                iCount++;
                resultMap.remove($(bean.getIT_KykKihon().getSyono(),
                    bean.getIT_KhTtdkRireki().getSyono(), bean.getIT_KhTtdkRireki().getHenkousikibetukey(),
                    bean.getIT_KykSyouhn().getSyono(), bean.getIT_KykSyouhn().getSyutkkbn(), bean.getIT_KykSyouhn().getSyouhncd(),
                    bean.getIT_KykSyouhn().getSyouhnsdno(), bean.getIT_KykSyouhn().getKyksyouhnrenno(),
                    bean.getIT_HhknSya().getSyono(),
                    bean.getIT_KykDairiten().getSyono(), bean.getIT_KykDairiten().getDrtenrenno(),
                    bean.getIT_KykSonotaTkyk().getSyono(),
                    bean.getIT_KykSya().getSyono()));

            }
            Assert.assertEquals(3, iCount);
            assertTrue(resultMap.isEmpty());
        }
    }

    @Test
    @TestOrder(50)
    public void blankCondition50() {
        Map<String,String> resultMap = new HashMap<String, String>();
        resultMap.put($("11807111141",
            "11807111141", "0004",
            "11807111141", C_SyutkKbn.SYU, "111", new Integer(04), new Integer(4),
            "11807111141",
            "11807111141", new Integer(2),
            "11807111141",
            "11807111141"), "1");

        resultMap.put($("11807111152",
            "11807111152", "0011",
            "11807111152", C_SyutkKbn.SYU, "111", new Integer(05), new Integer(5),
            "11807111152",
            "11807111152", new Integer(2),
            "11807111152",
            "11807111152"), "1");

        resultMap.put($("11807111163",
            "11807111163", "0005",
            "11807111163", C_SyutkKbn.SYU, "111", new Integer(11), new Integer(11),
            "11807111163",
            "11807111163", new Integer(2),
            "11807111163",
            "11807111163"), "1");
        resultMap.put($("11807111174",
            "11807111174", "0006",
            "11807111174", C_SyutkKbn.SYU, "111", new Integer(06), new Integer(22),
            "11807111174",
            "11807111174", new Integer(2),
            "11807111174",
            "11807111174"), "1");

        resultMap.put($("11807111185",
            "11807111185", "0007",
            "11807111185", C_SyutkKbn.SYU, "111", new Integer(07), new Integer(33),
            "11807111185",
            "11807111185", new Integer(2),
            "11807111185",
            "11807111185"), "1");

        resultMap.put($("11807111196",
            "11807111196", "0008",
            "11807111196", C_SyutkKbn.SYU, "111", new Integer(12), new Integer(44),
            "11807111196",
            "11807111196", new Integer(2),
            "11807111196",
            "11807111196"), "1");
        resultMap.put($("11807111200",
            "11807111200", "0009",
            "11807111200", C_SyutkKbn.SYU, "111", new Integer(13), new Integer(55),
            "11807111200",
            "11807111200", new Integer(2),
            "11807111200",
            "11807111200"), "1");

        resultMap.put($("11807111211",
            "11807111211", "0010",
            "11807111211", C_SyutkKbn.SYU, "111", new Integer(10), new Integer(66),
            "11807111211",
            "11807111211", new Integer(2),
            "11807111211",
            "11807111211"), "1");

        try (ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou(BizDate.valueOf(20161128), kinouid_0, kinouid)){

            int iCount = 0;
            for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {

                iCount++;
                resultMap.remove($(bean.getIT_KykKihon().getSyono(),
                    bean.getIT_KhTtdkRireki().getSyono(), bean.getIT_KhTtdkRireki().getHenkousikibetukey(),
                    bean.getIT_KykSyouhn().getSyono(), bean.getIT_KykSyouhn().getSyutkkbn(), bean.getIT_KykSyouhn().getSyouhncd(),
                    bean.getIT_KykSyouhn().getSyouhnsdno(), bean.getIT_KykSyouhn().getKyksyouhnrenno(),
                    bean.getIT_HhknSya().getSyono(),
                    bean.getIT_KykDairiten().getSyono(), bean.getIT_KykDairiten().getDrtenrenno(),
                    bean.getIT_KykSonotaTkyk().getSyono(),
                    bean.getIT_KykSya().getSyono()));

            }
            Assert.assertEquals(8, iCount);
            assertTrue(resultMap.isEmpty());
        }
    }

    @Transactional
    public static void deleteTestSubData() {


        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<IT_KykKihon> kykKihonLst = hozenDomManager.getAllKykKihon();
        if (kykKihonLst.size() > 0) {
            hozenDomManager.delete(kykKihonLst);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}


