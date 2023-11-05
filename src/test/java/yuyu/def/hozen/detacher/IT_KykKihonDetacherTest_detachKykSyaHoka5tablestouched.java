package yuyu.def.hozen.detacher;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.date.BizDateYM;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約基本テーブル(IT_KykKihon) デタッチャークラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachKykSyaHoka5tablestouched {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestData();

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("01", "11807111118");

        IT_KykSya kykSya1 = kykKihon1.createKykSya();

        IT_HhknSya hhknSya1 = kykKihon1.createHhknSya();

        IT_KykUkt kykUkt1 = kykKihon1.createKykUkt();
        kykUkt1.setUktsyukbn(C_UktsyuKbn.BLNK);
        kykUkt1.setUktsyurenno(01);

        IT_KykUkt kykUkt2 = kykKihon1.createKykUkt();
        kykUkt2.setUktsyukbn(C_UktsyuKbn.BLNK);
        kykUkt2.setUktsyurenno(02);

        IT_KykUkt kykUkt3 = kykKihon1.createKykUkt();
        kykUkt3.setUktsyukbn(C_UktsyuKbn.BLNK);
        kykUkt3.setUktsyurenno(03);

        IT_KykSonotaTkyk kykSonotaTkyk1 = kykKihon1.createKykSonotaTkyk();

        IT_KykSyouhn kykSyouhn1 = kykKihon1.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn1.setSyouhncd("01");
        kykSyouhn1.setSyouhnsdno(01);
        kykSyouhn1.setKyksyouhnrenno(01);

        IT_KykSyouhn kykSyouhn2 = kykKihon1.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn2.setSyouhncd("01");
        kykSyouhn2.setSyouhnsdno(02);
        kykSyouhn2.setKyksyouhnrenno(01);

        IT_KykSyouhn kykSyouhn3 = kykKihon1.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.NONE);
        kykSyouhn3.setSyouhncd("01");
        kykSyouhn3.setSyouhnsdno(03);
        kykSyouhn3.setKyksyouhnrenno(01);

        IT_NyknJissekiRireki nyknJissekiRireki1 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki1.setJyutoustartym(BizDateYM.valueOf(201702));
        nyknJissekiRireki1.setRenno(01);

        IT_NyknJissekiRireki nyknJissekiRireki2 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki2.setJyutoustartym(BizDateYM.valueOf(201702));
        nyknJissekiRireki2.setRenno(02);

        IT_NyknJissekiRireki nyknJissekiRireki3 = kykKihon1.createNyknJissekiRireki();
        nyknJissekiRireki3.setJyutoustartym(BizDateYM.valueOf(201702));
        nyknJissekiRireki3.setRenno(03);

        hozenDomManager.insert(kykKihon1);


    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager .class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        IT_KykKihon iT_KykKihon = hozenDomManager.getKykKihon("11807111118");

        IT_KykKihon entity = IT_KykKihonDetacher.detachKykSyaHoka5tablestouched(iT_KykKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        IT_KykSya IT_KykSya = iT_KykKihon.getKykSya();
        Assert.assertEquals("11807111118", IT_KykSya.getSyono());

        IT_HhknSya IT_HhknSya = iT_KykKihon.getHhknSya();
        Assert.assertEquals("11807111118", IT_HhknSya.getSyono());

        List<IT_KykUkt> kykUktlist = entity.getKykUkts();
        HashMap<String,String> datamap1 = new HashMap<String,String>();
        datamap1.put($("11807111118","0",01), "1");
        datamap1.put($("11807111118","0",02), "2");
        datamap1.put($("11807111118","0",03), "3");

        for(IT_KykUkt kykUkt:kykUktlist){
            datamap1.remove($(
                kykUkt.getSyono(),
                kykUkt.getUktsyukbn(),
                kykUkt.getUktsyurenno().intValue()));
        }

        Assert.assertTrue(datamap1.isEmpty());

        IT_KykSonotaTkyk IT_KykSonotaTkyk = iT_KykKihon.getKykSonotaTkyk();
        Assert.assertEquals("11807111118", IT_KykSonotaTkyk.getSyono());

        List<IT_KykSyouhn> kykSyouhnlist = entity.getKykSyouhns();
        HashMap<String,String> datamap2 = new HashMap<String,String>();
        datamap2.put($("11807111118","0","01",01,01), "1");
        datamap2.put($("11807111118","0","01",02,01), "2");
        datamap2.put($("11807111118","0","01",03,01), "3");

        for(IT_KykSyouhn kykSyouhn:kykSyouhnlist){
            datamap2.remove($(
                kykSyouhn.getSyono(),
                kykSyouhn.getSyutkkbn(),
                kykSyouhn.getSyouhncd(),
                kykSyouhn.getSyouhnsdno().intValue(),
                kykSyouhn.getKyksyouhnrenno().intValue()));
        }

        Assert.assertTrue(datamap2.isEmpty());


        List<IT_NyknJissekiRireki> kyknJissekiRirekiList = entity.getNyknJissekiRirekis();
        HashMap<String,String> datamap3 = new HashMap<String,String>();
        datamap3.put($("11807111118",BizDateYM.valueOf(201702),01), "1");
        datamap3.put($("11807111118",BizDateYM.valueOf(201702),02), "2");
        datamap3.put($("11807111118",BizDateYM.valueOf(201702),02), "3");

        for(IT_NyknJissekiRireki nyknJissekiRireki:kyknJissekiRirekiList){
            datamap3.remove($(
                nyknJissekiRireki.getSyono(),
                nyknJissekiRireki.getJyutoustartym(),
                nyknJissekiRireki.getRenno()));
        }

        Assert.assertTrue(datamap3.isEmpty());


    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon iT_KykKihon = null;

        Assert.assertNull(IT_KykKihonDetacher.detachKykSyaHoka5tablestouched(iT_KykKihon));
    }
}
