package yuyu.def.suuri.detacher;

import java.util.ArrayList;
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
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 異動明細情報作成<br />
 * 契約商品情報ビューエンティティリストをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SV_KiykSyuhnDataDetacherTest_detachKiykSyuhnDatatouched {

    @Inject
    SuuriDomManager suuriDomManager;

    static String P_KBNKEY_01 = "11";
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111129";
    static String P_SYONO_03 = "11807111130";
    static String P_SYOUHNCD_01 = "SH01";
    static Integer P_SYOUHNSDNO_01 = new Integer(11);
    static Integer P_KYKSYOUHNRENNO_01 = new Integer(1);
    static String P_HENKOUSIKIBETUKEY_01 = "HK000000001";
    static String P_HENKOUSIKIBETUKEY_02 = "HK000000002";
    static Integer P_RENNO_01 = new Integer(1);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_KBNKEY_01, P_SYONO_01);

        IT_KykSyouhn iT_KykSyouhn11 = iT_KykKihon1.createKykSyouhn();
        iT_KykSyouhn11.setSyutkkbn(C_SyutkKbn.NONE);
        iT_KykSyouhn11.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhn11.setSyouhnsdno(P_SYOUHNSDNO_01);
        iT_KykSyouhn11.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        iT_KykSyouhn11.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);

        IT_KhTtdkRireki iT_KhTtdkRireki12 = iT_KykKihon1.createKhTtdkRireki();
        iT_KhTtdkRireki12.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);

        IT_KhTtdkRireki iT_KhTtdkRireki13 = iT_KykKihon1.createKhTtdkRireki();
        iT_KhTtdkRireki13.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_02);

        IT_KykSyouhnRireki iT_KykSyouhnRireki121 = iT_KhTtdkRireki12.createKykSyouhnRireki();
        iT_KykSyouhnRireki121.setSyutkkbn(C_SyutkKbn.NONE);
        iT_KykSyouhnRireki121.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhnRireki121.setSyouhnsdno(P_SYOUHNSDNO_01);
        iT_KykSyouhnRireki121.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        iT_KykSyouhnRireki121.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_02);

        hozenDomManager.insert(iT_KykKihon1);

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_KBNKEY_01, P_SYONO_02);

        IT_KykSyouhn iT_KykSyouhn21 = iT_KykKihon2.createKykSyouhn();
        iT_KykSyouhn21.setSyutkkbn(C_SyutkKbn.NONE);
        iT_KykSyouhn21.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhn21.setSyouhnsdno(P_SYOUHNSDNO_01);
        iT_KykSyouhn21.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        iT_KykSyouhn21.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);

        IT_KhTtdkRireki iT_KhTtdkRireki22 = iT_KykKihon2.createKhTtdkRireki();
        iT_KhTtdkRireki22.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);

        IT_KhTtdkRireki iT_KhTtdkRireki23 = iT_KykKihon2.createKhTtdkRireki();
        iT_KhTtdkRireki23.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_02);

        IT_KykSyouhnRireki iT_KykSyouhnRireki221 = iT_KhTtdkRireki22.createKykSyouhnRireki();
        iT_KykSyouhnRireki221.setSyutkkbn(C_SyutkKbn.NONE);
        iT_KykSyouhnRireki221.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhnRireki221.setSyouhnsdno(P_SYOUHNSDNO_01);
        iT_KykSyouhnRireki221.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        iT_KykSyouhnRireki221.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_02);

        hozenDomManager.insert(iT_KykKihon2);

        IT_KykKihon iT_KykKihon3 = new IT_KykKihon(P_KBNKEY_01, P_SYONO_03);

        IT_KykSyouhn iT_KykSyouhn31 = iT_KykKihon3.createKykSyouhn();
        iT_KykSyouhn31.setSyutkkbn(C_SyutkKbn.NONE);
        iT_KykSyouhn31.setSyouhncd(P_SYOUHNCD_01);
        iT_KykSyouhn31.setSyouhnsdno(P_SYOUHNSDNO_01);
        iT_KykSyouhn31.setKyksyouhnrenno(P_KYKSYOUHNRENNO_01);
        iT_KykSyouhn31.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);

        IT_KhTtdkRireki iT_KhTtdkRireki32 = iT_KykKihon3.createKhTtdkRireki();
        iT_KhTtdkRireki32.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);

        hozenDomManager.insert(iT_KykKihon3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<SV_KiykSyuhnData> sV_KiykSyuhnDataLst = suuriDomManager.getAllKiykSyuhnData();

        List<SV_KiykSyuhnData> entityList = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(sV_KiykSyuhnDataLst);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(SV_KiykSyuhnData entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<SV_KiykSyuhnData> sV_KiykSyuhnDataLst = new ArrayList<>();

        sV_KiykSyuhnDataLst.add(null);
        sV_KiykSyuhnDataLst.add(null);

        List<SV_KiykSyuhnData> entityList = SV_KiykSyuhnDataDetacher.detachKiykSyuhnDatatouched(sV_KiykSyuhnDataLst);

        for(SV_KiykSyuhnData entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
