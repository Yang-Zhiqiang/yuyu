package yuyu.def.db.entity;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 主契約特約区分、商品コード、商品世代番号、契約商品連番を指定して<br />
 * 契約商品履歴テーブルエンティティを取得します。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KhTtdkRirekiTest_getKykSyouhnRirekiBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno {

    @Inject
    private HozenDomManager hozenDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_HENKOUSIKIBETUKEY_01 = "1000";
    static String P_HENKOUSIKIBETUKEY_02 = "2000";
    static String P_SYOUHNCD_01 = "A100";
    static String P_SYOUHNCD_02 = "A110";
    static Integer P_SYOUHNSDNO_01 = Integer.valueOf(0);
    static Integer P_SYOUHNSDNO_02 = Integer.valueOf(1);
    static Integer P_KYKSYOUHNRENNO_01 = Integer.valueOf(10);
    static Integer P_KYKSYOUHNRENNO_02 = Integer.valueOf(11);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);

        IT_KhTtdkRireki iT_KhTtdkRireki1 = iT_KykKihon1.createKhTtdkRireki();
        iT_KhTtdkRireki1.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);

        Assert.assertEquals(null, iT_KhTtdkRireki1.getKykSyouhnRirekiBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                C_SyutkKbn.SYU, P_SYOUHNCD_01, P_SYOUHNSDNO_02, P_KYKSYOUHNRENNO_02));

        IT_KykSyouhnRireki iT_KykSyouhnRireki1 = iT_KhTtdkRireki1.createKykSyouhnRireki();
        iT_KykSyouhnRireki1.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhnRireki1.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhnRireki1.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhnRireki1.setKyksyouhnrenno(P_KYKSYOUHNRENNO_02);

        IT_KykSyouhnRireki iT_KykSyouhnRirek2 = iT_KhTtdkRireki1.createKykSyouhnRireki();
        iT_KykSyouhnRirek2.setSyutkkbn(C_SyutkKbn.NONE);
        iT_KykSyouhnRirek2.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhnRirek2.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhnRirek2.setKyksyouhnrenno(P_KYKSYOUHNRENNO_02);

        IT_KykSyouhnRireki iT_KykSyouhnRirek3 = iT_KhTtdkRireki1.createKykSyouhnRireki();
        iT_KykSyouhnRirek3.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhnRirek3.setSyouhncd(P_SYOUHNCD_02);
        iT_KykSyouhnRirek3.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhnRirek3.setKyksyouhnrenno(P_KYKSYOUHNRENNO_02);

        IT_KykSyouhnRireki iT_KykSyouhnRirek4 = iT_KhTtdkRireki1.createKykSyouhnRireki();
        iT_KykSyouhnRirek4.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhnRirek4.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhnRirek4.setSyouhnsdno(P_SYOUHNSDNO_01);
        iT_KykSyouhnRirek4.setKyksyouhnrenno(P_KYKSYOUHNRENNO_02);

        IT_KykSyouhnRireki iT_KykSyouhnRirek5 = iT_KhTtdkRireki1.createKykSyouhnRireki();
        iT_KykSyouhnRirek5.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhnRirek5.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhnRirek5.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhnRirek5.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);

        IT_KhTtdkRireki iT_KhTtdkRireki2 = iT_KykKihon1.createKhTtdkRireki();
        iT_KhTtdkRireki2.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_02);

        IT_KykSyouhnRireki iT_KykSyouhnRirek6 = iT_KhTtdkRireki2.createKykSyouhnRireki();
        iT_KykSyouhnRirek6.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhnRirek6.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhnRirek6.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhnRirek6.setKyksyouhnrenno(P_KYKSYOUHNRENNO_02);

        hozenDomManager.insert(iT_KykKihon1);

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);

        IT_KhTtdkRireki iT_KhTtdkRireki3 = iT_KykKihon2.createKhTtdkRireki();
        iT_KhTtdkRireki3.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);

        IT_KykSyouhnRireki iT_KykSyouhnRirek7 = iT_KhTtdkRireki3.createKykSyouhnRireki();
        iT_KykSyouhnRirek7.setSyutkkbn(C_SyutkKbn.SYU);
        iT_KykSyouhnRirek7.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhnRirek7.setSyouhnsdno(P_SYOUHNSDNO_02);
        iT_KykSyouhnRirek7.setKyksyouhnrenno(P_KYKSYOUHNRENNO_02);

        hozenDomManager.insert(iT_KykKihon2);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData(){

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        IT_KykKihon iT_KykKihon1 = hozenDomManager.getKykKihon(P_SYONO_01);

        IT_KhTtdkRireki iT_KhTtdkRireki1 = iT_KykKihon1.getKhTtdkRirekiByHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);

        IT_KykSyouhnRireki iT_KykSyouhnRireki1 = iT_KhTtdkRireki1.getKykSyouhnRirekiBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno
                (C_SyutkKbn.TK, P_SYOUHNCD_01, P_SYOUHNSDNO_02, P_KYKSYOUHNRENNO_02);

        Assert.assertEquals(null, iT_KykSyouhnRireki1);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        IT_KykKihon iT_KykKihon1 = hozenDomManager.getKykKihon(P_SYONO_01);

        IT_KhTtdkRireki iT_KhTtdkRireki1 = iT_KykKihon1.getKhTtdkRirekiByHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);

        IT_KykSyouhnRireki iT_KykSyouhnRireki1 = iT_KhTtdkRireki1.getKykSyouhnRirekiBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno
                (C_SyutkKbn.SYU, P_SYOUHNCD_01, P_SYOUHNSDNO_02, P_KYKSYOUHNRENNO_02);

        Assert.assertEquals(P_SYONO_01, iT_KykSyouhnRireki1.getSyono());
        Assert.assertEquals(C_SyutkKbn.SYU, iT_KykSyouhnRireki1.getSyutkkbn());
        Assert.assertEquals(P_SYOUHNCD_01, iT_KykSyouhnRireki1.getSyouhncd());
        Assert.assertEquals(P_SYOUHNSDNO_02, iT_KykSyouhnRireki1.getSyouhnsdno());
        Assert.assertEquals(P_KYKSYOUHNRENNO_02, iT_KykSyouhnRireki1.getKyksyouhnrenno());
        Assert.assertEquals(P_HENKOUSIKIBETUKEY_01, iT_KykSyouhnRireki1.getHenkousikibetukey());
    }
}
