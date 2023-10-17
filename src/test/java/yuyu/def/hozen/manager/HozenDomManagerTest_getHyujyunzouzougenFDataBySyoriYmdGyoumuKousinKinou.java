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

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou {

    @Inject
    HozenDomManager hozenDomManager;
    BizDomManager bizDomManager;


    private  static final String kinouid_1 = "kykjyouhoutorikomi";
    private  static final String kinouid_2 = "shiharaijyouhoutorikomi";
    private  static final String kinouid_3 = "kaiyaku";
    private  static final String kinouid_4 = "gengaku";
    private  static final String kinouid_5 = "other";
    private  static final String kinouid_0 = "nothing";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou( BizDate.valueOf(20161101),kinouid_1,kinouid_2,kinouid_3,kinouid_4);

        int iCount = 0;
        for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "SYONO00001");
        IT_KhTtdkRireki khTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki1.setHenkousikibetukey("111");
        khTtdkRireki1.setSyoriYmd(BizDate.valueOf("20161101"));
        khTtdkRireki1.setGyoumuKousinKinou(kinouid_1);
        IT_KhTtdkRireki khTtdkRireki2 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki2.setHenkousikibetukey("222");
        khTtdkRireki2.setSyoriYmd(BizDate.valueOf("20161102"));
        khTtdkRireki2.setGyoumuKousinKinou(kinouid_2);
        IT_KhTtdkRireki khTtdkRireki3 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki3.setHenkousikibetukey("333");
        khTtdkRireki3.setSyoriYmd(BizDate.valueOf("20161103"));
        khTtdkRireki3.setGyoumuKousinKinou(kinouid_3);
        IT_KhTtdkRireki khTtdkRireki4 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki4.setHenkousikibetukey("444");
        khTtdkRireki4.setSyoriYmd(BizDate.valueOf("20161104"));
        khTtdkRireki4.setGyoumuKousinKinou(kinouid_4);
        IT_KhTtdkRireki khTtdkRireki5 = kykKihon1.createKhTtdkRireki();
        khTtdkRireki5.setHenkousikibetukey("555");
        khTtdkRireki5.setSyoriYmd(BizDate.valueOf("20161105"));
        khTtdkRireki5.setGyoumuKousinKinou(kinouid_5);
        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd("1111");
        kykSyouhn1.setSyouhnsdno(11);
        kykSyouhn1.setKyksyouhnrenno(11);
        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn2.setSyouhncd("1111");
        kykSyouhn2.setSyouhnsdno(11);
        kykSyouhn2.setKyksyouhnrenno(11);
        IT_KykSyouhn kykSyouhn3 = kykKihon1.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn3.setSyouhncd("1111");
        kykSyouhn3.setSyouhnsdno(11);
        kykSyouhn3.setKyksyouhnrenno(11);
        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();
        IT_KykDairiten kykDairiten1 = kykKihon1.createKykDairiten();
        kykDairiten1.setDrtenrenno(1);
        IT_KykDairiten kykDairiten2 = kykKihon1.createKykDairiten();
        kykDairiten2.setDrtenrenno(2);
        IT_KykDairiten kykDairiten3 = kykKihon1.createKykDairiten();
        kykDairiten3.setDrtenrenno(3);
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon1.createKykSonotaTkyk();

        hozenDomManager.insert(kykKihon1);


        IT_KykKihon kykKihon2 = new IT_KykKihon("01", "SYONO00002");
        IT_KhTtdkRireki khTtdkRireki21 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki21.setHenkousikibetukey("111");
        khTtdkRireki21.setSyoriYmd(BizDate.valueOf("20161101"));
        khTtdkRireki21.setGyoumuKousinKinou(kinouid_1);
        IT_KhTtdkRireki khTtdkRireki22 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki22.setHenkousikibetukey("222");
        khTtdkRireki22.setSyoriYmd(BizDate.valueOf("20161102"));
        khTtdkRireki22.setGyoumuKousinKinou(kinouid_2);
        IT_KhTtdkRireki khTtdkRireki23 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki23.setHenkousikibetukey("333");
        khTtdkRireki23.setSyoriYmd(BizDate.valueOf("20161103"));
        khTtdkRireki23.setGyoumuKousinKinou(kinouid_3);
        IT_KhTtdkRireki khTtdkRireki24 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki24.setHenkousikibetukey("444");
        khTtdkRireki24.setSyoriYmd(BizDate.valueOf("20161104"));
        khTtdkRireki24.setGyoumuKousinKinou(kinouid_4);
        IT_KhTtdkRireki khTtdkRireki25 = kykKihon2.createKhTtdkRireki();
        khTtdkRireki25.setHenkousikibetukey("555");
        khTtdkRireki25.setSyoriYmd(BizDate.valueOf("20161105"));
        khTtdkRireki25.setGyoumuKousinKinou(kinouid_5);
        IT_HhknSya hhknSya21 = kykKihon2.createHhknSya();
        IT_KykDairiten kykDairiten21 = kykKihon2.createKykDairiten();
        kykDairiten21.setDrtenrenno(1);
        IT_KykDairiten kykDairiten22 = kykKihon2.createKykDairiten();
        kykDairiten22.setDrtenrenno(2);
        IT_KykDairiten kykDairiten23 = kykKihon2.createKykDairiten();
        kykDairiten23.setDrtenrenno(3);
        IT_KykSonotaTkyk kykSonotaTkyk21 = kykKihon2.createKykSonotaTkyk();

        hozenDomManager.insert(kykKihon2);
        IT_KykKihon kykKihon3 = new IT_KykKihon("01", "SYONO00003");
        IT_KhTtdkRireki khTtdkRireki31 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki31.setHenkousikibetukey("111");
        khTtdkRireki31.setSyoriYmd(BizDate.valueOf("20161101"));
        khTtdkRireki31.setGyoumuKousinKinou(kinouid_1);
        IT_KhTtdkRireki khTtdkRireki32 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki32.setHenkousikibetukey("222");
        khTtdkRireki32.setSyoriYmd(BizDate.valueOf("20161102"));
        khTtdkRireki32.setGyoumuKousinKinou(kinouid_2);
        IT_KhTtdkRireki khTtdkRireki33 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki33.setHenkousikibetukey("333");
        khTtdkRireki33.setSyoriYmd(BizDate.valueOf("20161103"));
        khTtdkRireki33.setGyoumuKousinKinou(kinouid_3);
        IT_KhTtdkRireki khTtdkRireki34 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki34.setHenkousikibetukey("444");
        khTtdkRireki34.setSyoriYmd(BizDate.valueOf("20161104"));
        khTtdkRireki34.setGyoumuKousinKinou(kinouid_4);
        IT_KhTtdkRireki khTtdkRireki35 = kykKihon3.createKhTtdkRireki();
        khTtdkRireki35.setHenkousikibetukey("555");
        khTtdkRireki35.setSyoriYmd(BizDate.valueOf("20161105"));
        khTtdkRireki35.setGyoumuKousinKinou(kinouid_5);
        IT_KykSyouhn kykSyouhn31 = kykKihon3.createKykSyouhn();
        kykSyouhn31.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn31.setSyouhncd("1111");
        kykSyouhn31.setSyouhnsdno(11);
        kykSyouhn31.setKyksyouhnrenno(11);
        IT_HhknSya hhknSya31 = kykKihon3.createHhknSya();
        IT_KykDairiten kykDairiten31 = kykKihon3.createKykDairiten();
        kykDairiten31.setDrtenrenno(1);
        IT_KykDairiten kykDairiten32 = kykKihon3.createKykDairiten();
        kykDairiten32.setDrtenrenno(2);
        IT_KykDairiten kykDairiten33 = kykKihon3.createKykDairiten();
        kykDairiten33.setDrtenrenno(3);
        IT_KykSonotaTkyk kykSonotaTkyk31 = kykKihon3.createKykSonotaTkyk();
        hozenDomManager.insert(kykKihon3);

        IT_KykKihon kykKihon4 = new IT_KykKihon("01", "SYONO00004");
        IT_KhTtdkRireki khTtdkRireki45 = kykKihon4.createKhTtdkRireki();
        khTtdkRireki45.setHenkousikibetukey("555");
        khTtdkRireki45.setSyoriYmd(BizDate.valueOf("20161101"));
        khTtdkRireki45.setGyoumuKousinKinou(kinouid_1);
        IT_KykSyouhn kykSyouhn41 = kykKihon4.createKykSyouhn();
        kykSyouhn41.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn41.setSyouhncd("1111");
        kykSyouhn41.setSyouhnsdno(11);
        kykSyouhn41.setKyksyouhnrenno(11);
        IT_HhknSya hhknSya41 = kykKihon4.createHhknSya();
        IT_KykDairiten kykDairiten42 = kykKihon4.createKykDairiten();
        kykDairiten42.setDrtenrenno(2);
        IT_KykDairiten kykDairiten43 = kykKihon4.createKykDairiten();
        kykDairiten43.setDrtenrenno(3);
        IT_KykSonotaTkyk kykSonotaTkyk41 = kykKihon4.createKykSonotaTkyk();
        hozenDomManager.insert(kykKihon4);

        IT_KykKihon kykKihon5 = new IT_KykKihon("01", "SYONO00005");
        IT_KhTtdkRireki khTtdkRireki55 = kykKihon5.createKhTtdkRireki();
        khTtdkRireki55.setHenkousikibetukey("555");
        khTtdkRireki55.setSyoriYmd(BizDate.valueOf("20161101"));
        khTtdkRireki55.setGyoumuKousinKinou(kinouid_1);
        IT_KykSyouhn kykSyouhn51 = kykKihon5.createKykSyouhn();
        kykSyouhn51.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn51.setSyouhncd("1111");
        kykSyouhn51.setSyouhnsdno(11);
        kykSyouhn51.setKyksyouhnrenno(11);
        IT_KykDairiten kykDairiten52 = kykKihon5.createKykDairiten();
        kykDairiten52.setDrtenrenno(1);
        IT_KykSonotaTkyk kykSonotaTkyk51 = kykKihon5.createKykSonotaTkyk();
        hozenDomManager.insert(kykKihon5);

        IT_KykKihon kykKihon6 = new IT_KykKihon("01", "SYONO00006");
        IT_KhTtdkRireki khTtdkRireki65 = kykKihon6.createKhTtdkRireki();
        khTtdkRireki65.setHenkousikibetukey("555");
        khTtdkRireki65.setSyoriYmd(BizDate.valueOf("20161101"));
        khTtdkRireki65.setGyoumuKousinKinou(kinouid_1);
        IT_KykSyouhn kykSyouhn61 = kykKihon6.createKykSyouhn();
        kykSyouhn61.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn61.setSyouhncd("1111");
        kykSyouhn61.setSyouhnsdno(11);
        kykSyouhn61.setKyksyouhnrenno(11);
        IT_HhknSya hhknSya61 = kykKihon6.createHhknSya();
        IT_KykDairiten kykDairiten62 = kykKihon6.createKykDairiten();
        kykDairiten62.setDrtenrenno(1);

        hozenDomManager.insert(kykKihon6);



        IT_KykKihon kykKihon111 = new IT_KykKihon("01", "SYONO00111");
        IT_KhTtdkRireki khTtdkRireki1111 = kykKihon111.createKhTtdkRireki();
        khTtdkRireki1111.setHenkousikibetukey("111");
        khTtdkRireki1111.setSyoriYmd(BizDate.valueOf("20161102"));
        khTtdkRireki1111.setGyoumuKousinKinou(kinouid_1);
        IT_KhTtdkRireki khTtdkRireki1112 = kykKihon111.createKhTtdkRireki();
        khTtdkRireki1112.setHenkousikibetukey("222");
        khTtdkRireki1112.setSyoriYmd(BizDate.valueOf("20161102"));
        khTtdkRireki1112.setGyoumuKousinKinou(kinouid_2);
        IT_KhTtdkRireki khTtdkRireki1113 = kykKihon111.createKhTtdkRireki();
        khTtdkRireki1113.setHenkousikibetukey("333");
        khTtdkRireki1113.setSyoriYmd(BizDate.valueOf("20161102"));
        khTtdkRireki1113.setGyoumuKousinKinou(kinouid_3);
        IT_KhTtdkRireki khTtdkRireki1114 = kykKihon111.createKhTtdkRireki();
        khTtdkRireki1114.setHenkousikibetukey("444");
        khTtdkRireki1114.setSyoriYmd(BizDate.valueOf("20161102"));
        khTtdkRireki1114.setGyoumuKousinKinou(kinouid_4);
        IT_KhTtdkRireki khTtdkRireki1115 = kykKihon111.createKhTtdkRireki();
        khTtdkRireki1115.setHenkousikibetukey("555");
        khTtdkRireki1115.setSyoriYmd(BizDate.valueOf("20161103"));
        khTtdkRireki1115.setGyoumuKousinKinou(kinouid_1);
        IT_KhTtdkRireki khTtdkRireki1116 = kykKihon111.createKhTtdkRireki();
        khTtdkRireki1116.setHenkousikibetukey("666");
        khTtdkRireki1116.setSyoriYmd(BizDate.valueOf("20161102"));
        khTtdkRireki1116.setGyoumuKousinKinou(kinouid_5);
        IT_KykSyouhn kykSyouhn1111 = kykKihon111.createKykSyouhn();
        kykSyouhn1111.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1111.setSyouhncd("1111");
        kykSyouhn1111.setSyouhnsdno(11);
        kykSyouhn1111.setKyksyouhnrenno(11);
        IT_KykSyouhn kykSyouhn1112 = kykKihon111.createKykSyouhn();
        kykSyouhn1112.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn1112.setSyouhncd("1111");
        kykSyouhn1112.setSyouhnsdno(22);
        kykSyouhn1112.setKyksyouhnrenno(11);
        IT_KykSyouhn kykSyouhn1113 = kykKihon111.createKykSyouhn();
        kykSyouhn1113.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1113.setSyouhncd("1111");
        kykSyouhn1113.setSyouhnsdno(33);
        kykSyouhn1113.setKyksyouhnrenno(11);
        IT_HhknSya hhknSya1111 = kykKihon111.createHhknSya();
        IT_KykDairiten kykDairiten1111 = kykKihon111.createKykDairiten();
        kykDairiten1111.setDrtenrenno(1);
        IT_KykDairiten kykDairiten1112 = kykKihon111.createKykDairiten();
        kykDairiten1112.setDrtenrenno(2);
        IT_KykDairiten kykDairiten1113 = kykKihon111.createKykDairiten();
        kykDairiten1113.setDrtenrenno(3);
        IT_KykSonotaTkyk kykSonotaTkyk111 = kykKihon111.createKykSonotaTkyk();

        hozenDomManager.insert(kykKihon111);



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
        ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou( BizDate.valueOf(20161101),kinouid_2,kinouid_3,kinouid_4,kinouid_5);

        int iCount = 0;
        for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou( BizDate.valueOf(20161101),kinouid_1,kinouid_2);

        int iCount = 0;
        for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {
            Assert.assertEquals(bean.getIT_KykKihon().getSyono(),"SYONO00001");
            Assert.assertEquals(bean.getIT_KhTtdkRireki().getHenkousikibetukey(),"111");
            Assert.assertEquals(bean.getIT_KykSyouhn().getSyouhnsdno(),Integer.valueOf("11"));
            iCount++;
        }
        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(20)
    public void normal2() {

        Map<String,String> hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap = new HashMap<String, String>();
        hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.put($("SYONO00001", "222", Integer.valueOf("11")), "1");
        hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.put($("SYONO00111", "111", Integer.valueOf("11")), "1");
        hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.put($("SYONO00111", "111", Integer.valueOf("33")), "1");
        hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.put($("SYONO00111", "222", Integer.valueOf("11")), "1");
        hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.put($("SYONO00111", "222", Integer.valueOf("33")), "1");
        hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.put($("SYONO00111", "333", Integer.valueOf("11")), "1");
        hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.put($("SYONO00111", "333", Integer.valueOf("33")), "1");
        hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.put($("SYONO00111", "444", Integer.valueOf("11")), "1");
        hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.put($("SYONO00111", "444", Integer.valueOf("33")), "1");

        ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou( BizDate.valueOf(20161102),kinouid_1,kinouid_2,kinouid_3,kinouid_4);

        int iCount = 0;
        for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {
            System.out.println("データ■" + bean.getIT_KykKihon().getSyono() + "," + bean.getIT_KhTtdkRireki().getHenkousikibetukey() + "," + bean.getIT_KykSyouhn().getSyouhnsdno());
            hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.remove($(bean.getIT_KykKihon().getSyono(),bean.getIT_KhTtdkRireki().getHenkousikibetukey(),bean.getIT_KykSyouhn().getSyouhnsdno()));
            iCount++;
        }
        Assert.assertEquals(9, iCount);
        assertTrue(hyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBeanMap.isEmpty());
    }

    @Test
    @TestOrder(30)
    public void normal3() {

        ExDBResults<HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean> beans = hozenDomManager.
            getHyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinou( BizDate.valueOf(20161102),"");

        int iCount = 0;
        for (HyujyunzouzougenFDataBySyoriYmdGyoumuKousinKinouBean bean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }
}


