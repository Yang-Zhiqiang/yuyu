package yuyu.def.hozen.manager;

import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        int iCount = 0;
        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> list = hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("11807111130");

        Assert.assertEquals(0,list.size());

        insertTestData();
    }

    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon kykKihon1 = new IT_KykKihon("a","11807111118");


        IT_KhTtdkRireki KhTtdkRireki1 = kykKihon1.createKhTtdkRireki();
        KhTtdkRireki1.setHenkousikibetukey("111");

        IT_KhHenkouRireki khHenkouRireki1 = KhTtdkRireki1.createKhHenkouRireki();
        khHenkouRireki1.setRenno3keta(001);
        khHenkouRireki1.setTableid(IT_KykSonotaTkyk.TABLE_NAME);
        khHenkouRireki1.setHenkoukoumokuid(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK);
        khHenkouRireki1.setBfrnaiyouoriginal("ああああ");
        khHenkouRireki1.setNewnaiyouoriginal("ささささ");

        hozenDomManager.insert(kykKihon1);


        IT_KykKihon kykKihon2 = new IT_KykKihon("b","11807111129");

        IT_KhTtdkRireki KhTtdkRireki4 = kykKihon2.createKhTtdkRireki();
        KhTtdkRireki4.setHenkousikibetukey("444");

        IT_KhHenkouRireki khHenkouRireki4 = KhTtdkRireki4.createKhHenkouRireki();
        khHenkouRireki4.setRenno3keta(004);
        khHenkouRireki4.setTableid(IT_KykSonotaTkyk.TABLE_NAME);
        khHenkouRireki4.setHenkoukoumokuid(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK);
        khHenkouRireki4.setBfrnaiyouoriginal("ええええ");
        khHenkouRireki4.setNewnaiyouoriginal("せせせせ");

        IT_KhTtdkRireki KhTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        KhTtdkRireki2.setHenkousikibetukey("222");

        IT_KhHenkouRireki khHenkouRireki2 = KhTtdkRireki2.createKhHenkouRireki();
        khHenkouRireki2.setRenno3keta(002);
        khHenkouRireki2.setTableid(IT_KykSonotaTkyk.TABLE_NAME);
        khHenkouRireki2.setHenkoukoumokuid(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK);
        khHenkouRireki2.setBfrnaiyouoriginal("いいいい");
        khHenkouRireki2.setNewnaiyouoriginal("しししし");


        IT_KhTtdkRireki KhTtdkRireki3 = kykKihon2.createKhTtdkRireki();
        KhTtdkRireki3.setHenkousikibetukey("333");


        IT_KhHenkouRireki khHenkouRireki3 = KhTtdkRireki3.createKhHenkouRireki();
        khHenkouRireki3.setRenno3keta(003);
        khHenkouRireki3.setTableid(IT_KykSonotaTkyk.TABLE_NAME);
        khHenkouRireki3.setHenkoukoumokuid(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK);
        khHenkouRireki3.setBfrnaiyouoriginal("うううう");
        khHenkouRireki3.setNewnaiyouoriginal("すすすす");

        IT_KhTtdkRireki KhTtdkRireki5 = kykKihon2.createKhTtdkRireki();
        KhTtdkRireki5.setHenkousikibetukey("555");

        IT_KhHenkouRireki khHenkouRireki5 = KhTtdkRireki5.createKhHenkouRireki();
        khHenkouRireki5.setRenno3keta(005);
        khHenkouRireki5.setTableid(IT_KykSonotaTkyk.TABLE_NAME);
        khHenkouRireki5.setHenkoukoumokuid(IT_KykSonotaTkyk.KWSTARGETRATE);
        khHenkouRireki5.setBfrnaiyouoriginal("おおおお");
        khHenkouRireki5.setNewnaiyouoriginal("そそそそ");

        IT_KhTtdkRireki KhTtdkRireki6 = kykKihon2.createKhTtdkRireki();
        KhTtdkRireki6.setHenkousikibetukey("666");

        IT_KhHenkouRireki khHenkouRireki6 = KhTtdkRireki6.createKhHenkouRireki();
        khHenkouRireki6.setRenno3keta(006);
        khHenkouRireki6.setTableid(IT_KykKihon.TABLE_NAME);
        khHenkouRireki6.setHenkoukoumokuid(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK);
        khHenkouRireki6.setBfrnaiyouoriginal("かかかか");
        khHenkouRireki6.setNewnaiyouoriginal("きききき");

        hozenDomManager.insert(kykKihon2);


    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> list = hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("11807111119");

        Assert.assertEquals(0, list.size());

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> list = hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("11807111118");

        Assert.assertEquals(1, list.size());
        Assert.assertEquals("ああああ", list.get(0).getBfrnaiyouoriginal());
        Assert.assertEquals("ささささ", list.get(0).getNewnaiyouoriginal());
    }

    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        List<KhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyonoBean> list = hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalNewnaiyouoriginalBySyono("11807111129");

        Assert.assertEquals(3, list.size());

        Assert.assertEquals("いいいい", list.get(0).getBfrnaiyouoriginal());
        Assert.assertEquals("しししし", list.get(0).getNewnaiyouoriginal());
        Assert.assertEquals("うううう", list.get(1).getBfrnaiyouoriginal());
        Assert.assertEquals("すすすす", list.get(1).getNewnaiyouoriginal());
        Assert.assertEquals("ええええ", list.get(2).getBfrnaiyouoriginal());
        Assert.assertEquals("せせせせ", list.get(2).getNewnaiyouoriginal());

    }

    @Transactional
    public static void deleteTestSubData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

    }



    @AfterClass
    @Transactional
    public static void deleteTestData() {

        deleteTestSubData();
    }
}
