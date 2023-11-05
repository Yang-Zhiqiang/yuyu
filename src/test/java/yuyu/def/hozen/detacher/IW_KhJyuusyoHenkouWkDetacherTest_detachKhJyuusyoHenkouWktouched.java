package yuyu.def.hozen.detacher;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IW_KhJyuusyoHenkouWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ダイレクトサービス共通DBアクセス<br />
 * 住所変更ワークテーブルエンティティデタッチ(住所変更ワークテーブルエンティティ)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IW_KhJyuusyoHenkouWkDetacherTest_detachKhJyuusyoHenkouWktouched {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_KOUTEIKANRIID_01 = "KTKRID01";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.insert(new IW_KhJyuusyoHenkouWk(P_KOUTEIKANRIID_01));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhJyuusyoHenkouWk());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        IW_KhJyuusyoHenkouWk iW_KhJyuusyoHenkouWk = hozenDomManager.getKhJyuusyoHenkouWk(P_KOUTEIKANRIID_01);

        IW_KhJyuusyoHenkouWk entity = IW_KhJyuusyoHenkouWkDetacher.detachKhJyuusyoHenkouWktouched(iW_KhJyuusyoHenkouWk);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IW_KhJyuusyoHenkouWk iW_KhJyuusyoHenkouWk = null;

        Assert.assertNull(IW_KhJyuusyoHenkouWkDetacher.detachKhJyuusyoHenkouWktouched(iW_KhJyuusyoHenkouWk));
    }
}
