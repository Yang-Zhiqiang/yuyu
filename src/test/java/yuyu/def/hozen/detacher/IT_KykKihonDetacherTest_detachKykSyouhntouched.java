package yuyu.def.hozen.detacher;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 解約返戻金相当額情報作成<br />IT_KykKihonDetacher
 * 契約商品情報取得（証券番号、主契約特約区分指定）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachKykSyouhntouched {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_SYONO = "11807111118";
    static String P_SYOUHNCD = "SH01";
    static int P_SYOUHNSDNO_01 = 1;
    static int P_SYOUHNSDNO_02 = 2;
    static int P_SYOUHNSDNO_03 = 3;
    static int P_KYKSYOUHNRENNO = 11;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        IT_KykKihon iT_KykKihon = new IT_KykKihon(P_SYONO);

        IT_KykSyouhn kykSyouhn1 = iT_KykKihon.createKykSyouhn();
        kykSyouhn1.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn1.setSyouhncd(P_SYOUHNCD);
        kykSyouhn1.setSyouhnsdno(P_SYOUHNSDNO_01);
        kykSyouhn1.setKyksyouhnrenno(P_KYKSYOUHNRENNO);

        IT_KykSyouhn kykSyouhn2 = iT_KykKihon.createKykSyouhn();
        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd(P_SYOUHNCD);
        kykSyouhn2.setSyouhnsdno(P_SYOUHNSDNO_02);
        kykSyouhn2.setKyksyouhnrenno(P_KYKSYOUHNRENNO);

        IT_KykSyouhn kykSyouhn3 = iT_KykKihon.createKykSyouhn();
        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd(P_SYOUHNCD);
        kykSyouhn3.setSyouhnsdno(P_SYOUHNSDNO_03);
        kykSyouhn3.setKyksyouhnrenno(P_KYKSYOUHNRENNO);

        hozenDomManager.insert(iT_KykKihon);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager .class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        IT_KykKihon iT_KykKihon = hozenDomManager.getKykKihon(P_SYONO);

        IT_KykKihon entity = IT_KykKihonDetacher.detachKykSyouhntouched(iT_KykKihon);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));

        List<IT_KykSyouhn> kykSyouhns = entity.getKykSyouhns();

        Assert.assertEquals(3, kykSyouhns.size());

        IT_KykSyouhn iT_KykSyouhn1 = kykSyouhns.get(0);
        Assert.assertEquals(P_SYONO, iT_KykSyouhn1.getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, iT_KykSyouhn1.getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD, iT_KykSyouhn1.getSyouhncd());
        Assert.assertEquals(P_SYOUHNSDNO_01, iT_KykSyouhn1.getSyouhnsdno().intValue());
        Assert.assertEquals(P_KYKSYOUHNRENNO, iT_KykSyouhn1.getKyksyouhnrenno().intValue());

        IT_KykSyouhn iT_KykSyouhn2 = kykSyouhns.get(1);
        Assert.assertEquals(P_SYONO, iT_KykSyouhn2.getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, iT_KykSyouhn2.getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD, iT_KykSyouhn2.getSyouhncd());
        Assert.assertEquals(P_SYOUHNSDNO_02, iT_KykSyouhn2.getSyouhnsdno().intValue());
        Assert.assertEquals(P_KYKSYOUHNRENNO, iT_KykSyouhn2.getKyksyouhnrenno().intValue());

        IT_KykSyouhn iT_KykSyouhn3 = kykSyouhns.get(2);
        Assert.assertEquals(P_SYONO, iT_KykSyouhn3.getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, iT_KykSyouhn3.getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD, iT_KykSyouhn3.getSyouhncd());
        Assert.assertEquals(P_SYOUHNSDNO_03, iT_KykSyouhn3.getSyouhnsdno().intValue());
        Assert.assertEquals(P_KYKSYOUHNRENNO, iT_KykSyouhn3.getKyksyouhnrenno().intValue());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IT_KykKihon iT_KykKihon = null;

        Assert.assertNull(IT_KykKihonDetacher.detachKykSyouhntouched(iT_KykKihon));
    }

    public static IT_KykKihon detachKoujyoSymtouched(IT_KykKihon pEntity) {

        if (pEntity != null) {

            pEntity.getKoujyoSyms().size();

            pEntity.detach();
            return pEntity;
        }
        return null;
    }
}
