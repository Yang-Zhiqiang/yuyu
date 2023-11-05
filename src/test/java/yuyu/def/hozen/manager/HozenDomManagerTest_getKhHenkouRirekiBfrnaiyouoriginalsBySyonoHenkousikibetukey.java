package yuyu.def.hozen.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import yuyu.def.hozen.result.bean.KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * HozenDomManagerクラスの、<br />
 * getSmbckykdtlInfosByKakutyoujobcd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey {

    @Inject
    HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        int iCount = 0;
        List<KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean> list = hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey("11807111130","111");

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


        IT_KhTtdkRireki KhTtdkRireki2 = kykKihon2.createKhTtdkRireki();
        KhTtdkRireki2.setHenkousikibetukey("222");

        IT_KhHenkouRireki khHenkouRireki2 = KhTtdkRireki2.createKhHenkouRireki();
        khHenkouRireki2.setRenno3keta(002);
        khHenkouRireki2.setTableid(IT_KykSonotaTkyk.TABLE_NAME);
        khHenkouRireki2.setHenkoukoumokuid(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK);
        khHenkouRireki2.setBfrnaiyouoriginal("いいいい");
        khHenkouRireki2.setNewnaiyouoriginal("しししし");

        IT_KhHenkouRireki khHenkouRireki3 = KhTtdkRireki2.createKhHenkouRireki();
        khHenkouRireki3.setRenno3keta(003);
        khHenkouRireki3.setTableid(IT_KykSonotaTkyk.TABLE_NAME);
        khHenkouRireki3.setHenkoukoumokuid(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK);
        khHenkouRireki3.setBfrnaiyouoriginal("うううう");
        khHenkouRireki3.setNewnaiyouoriginal("すすすす");


        IT_KhHenkouRireki khHenkouRireki4 = KhTtdkRireki2.createKhHenkouRireki();
        khHenkouRireki4.setRenno3keta(004);
        khHenkouRireki4.setTableid(IT_KykSonotaTkyk.TABLE_NAME);
        khHenkouRireki4.setHenkoukoumokuid(IT_KykSonotaTkyk.INITSBJIYENKASAITEIHSYGK);
        khHenkouRireki4.setBfrnaiyouoriginal("ええええ");
        khHenkouRireki4.setNewnaiyouoriginal("せせせせ");


        IT_KhHenkouRireki khHenkouRireki5 = KhTtdkRireki2.createKhHenkouRireki();
        khHenkouRireki5.setRenno3keta(005);
        khHenkouRireki5.setTableid(IT_KykSonotaTkyk.TABLE_NAME);
        khHenkouRireki5.setHenkoukoumokuid(IT_KykSonotaTkyk.KWSTARGETRATE);
        khHenkouRireki5.setBfrnaiyouoriginal("おおおお");
        khHenkouRireki5.setNewnaiyouoriginal("そそそそ");


        IT_KhHenkouRireki khHenkouRireki6 = KhTtdkRireki2.createKhHenkouRireki();
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

        List<KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean> list = hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey("11807111119","111");

        Assert.assertEquals(0, list.size());

    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal21() {

        List<KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean> list = hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey("11807111118","111");

        Assert.assertEquals(1, list.size());
        Assert.assertEquals("ああああ", list.get(0).getBfrnaiyouoriginal());
        Assert.assertEquals("ささささ", list.get(0).getNewnaiyouoriginal());
    }

    @Test
    @TestOrder(31)
    @Transactional
    public void normal31() {

        List<KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean> list = hozenDomManager.getKhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukey("11807111129","222");
        Map<String,String> map = new HashMap<String,String>();
        map.put($("いいいい","しししし"),"1");
        map.put($("うううう","すすすす"),"2");
        map.put($("ええええ","せせせせ"),"3");

        for(KhHenkouRirekiBfrnaiyouoriginalsBySyonoHenkousikibetukeyBean bean:list){
            map.remove($(bean.getBfrnaiyouoriginal(),bean.getNewnaiyouoriginal()));
        }

        assertTrue(map.isEmpty());

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
