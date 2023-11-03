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

import yuyu.def.db.entity.IW_KhMeigiHenkouWk;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ダイレクトサービス共通DBアクセス<br />
 * 名義変更ワークテーブルエンティティをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class IW_KhMeigiHenkouWkDetacherTest_detachKhMeigiHenkouWktouched {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_KOUTEIKANRIID_01 = "KTKRID01";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.insert(new IW_KhMeigiHenkouWk(P_KOUTEIKANRIID_01));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhMeigiHenkouWk());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        IW_KhMeigiHenkouWk iW_KhMeigiHenkouWk = hozenDomManager.getKhMeigiHenkouWk(P_KOUTEIKANRIID_01);

        IW_KhMeigiHenkouWk entity = IW_KhMeigiHenkouWkDetacher.detachKhMeigiHenkouWktouched(iW_KhMeigiHenkouWk);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        Assert.assertFalse(em.getEntityManager().contains(entity));
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        IW_KhMeigiHenkouWk iW_KhMeigiHenkouWk = null;

        Assert.assertNull(IW_KhMeigiHenkouWkDetacher.detachKhMeigiHenkouWktouched(iW_KhMeigiHenkouWk));
    }
}
