package yuyu.def.hozen.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhSntkInfoTouroku;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 契約保全<br />
 * 契約取消<br />
 * 契約保全選択情報登録テーブルの最大連番取得　証券番号のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhSntkInfoTourokuMaxRennoBySyono {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional()
    public static void insertTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        Integer count = hozenDomManager.getKhSntkInfoTourokuMaxRennoBySyono("11807111118");
        Assert.assertEquals(null, count);

        IT_KhSntkInfoTouroku khSntkInfoTouroku1 = new IT_KhSntkInfoTouroku("11807111118", 10);

        hozenDomManager.insert(khSntkInfoTouroku1);

        IT_KhSntkInfoTouroku khSntkInfoTouroku2 = new IT_KhSntkInfoTouroku("11807111118", 11);

        hozenDomManager.insert(khSntkInfoTouroku2);

        IT_KhSntkInfoTouroku khSntkInfoTouroku3 = new IT_KhSntkInfoTouroku("11807111130", 12);

        hozenDomManager.insert(khSntkInfoTouroku3);

        IT_KhSntkInfoTouroku khSntkInfoTouroku4 = new IT_KhSntkInfoTouroku("11807111129", 11);

        hozenDomManager.insert(khSntkInfoTouroku4);

        IT_KhSntkInfoTouroku khSntkInfoTouroku5 = new IT_KhSntkInfoTouroku("11807111118", 9);

        hozenDomManager.insert(khSntkInfoTouroku5);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKhSntkInfoTouroku());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        Integer count = hozenDomManager.getKhSntkInfoTourokuMaxRennoBySyono("11807111141");
        Assert.assertEquals(null, count);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Integer count = hozenDomManager.getKhSntkInfoTourokuMaxRennoBySyono("11807111118");
        Assert.assertEquals(new Integer(11), count);
    }

    @Test
    @TestOrder(30)
    public void blankCondition1() {

        Integer count = hozenDomManager.getKhSntkInfoTourokuMaxRennoBySyono("");
        Assert.assertEquals(null, count);
    }
}
