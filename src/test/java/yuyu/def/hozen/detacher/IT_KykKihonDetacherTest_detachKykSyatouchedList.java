package yuyu.def.hozen.detacher;

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

import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ダイレクトサービス共通DBアクセス<br />
 * デタッチ取得[契約者テーブル](契約基本テーブルエンティティ)のテストクラスです。<br />
 */
@RunWith(OrderedRunner.class)
public class IT_KykKihonDetacherTest_detachKykSyatouchedList {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_SYONO_1 = "11807111118";
    static String P_SYONO_2 = "11807111129";
    static String P_SYONO_3 = "11807111130";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_1);
        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_2);
        IT_KykKihon iT_KykKihon3 = new IT_KykKihon(P_SYONO_3);

        iT_KykKihon1.createKykSya();
        iT_KykKihon2.createKykSya();
        iT_KykKihon3.createKykSya();

        hozenDomManager.insert(iT_KykKihon1);
        hozenDomManager.insert(iT_KykKihon2);
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

        List<IT_KykKihon> iT_KykKihonList = hozenDomManager.getAllKykKihon();

        List<IT_KykKihon> entityList = IT_KykKihonDetacher.detachKykSyatouched(iT_KykKihonList);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for (IT_KykKihon entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }

        Assert.assertEquals(3, iT_KykKihonList.size());

        Assert.assertEquals(P_SYONO_1, iT_KykKihonList.get(0).getKykSya().getSyono());
        Assert.assertEquals(P_SYONO_2, iT_KykKihonList.get(1).getKykSya().getSyono());
        Assert.assertEquals(P_SYONO_3, iT_KykKihonList.get(2).getKykSya().getSyono());
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<IT_KykKihon> iT_KykKihonList = new ArrayList<>();
        iT_KykKihonList.add(null);
        iT_KykKihonList.add(null);

        List<IT_KykKihon> entityList = IT_KykKihonDetacher.detachKykSyatouched(iT_KykKihonList);

        for (IT_KykKihon entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
