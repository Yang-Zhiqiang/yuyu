package yuyu.def.hozen.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.dao.IT_KykSyouhnDao;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.result.bean.HoyuKykSyouhnsBySyonoSyutkkbnBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

/**
 * 数理<br />
 * 保有明細情報作成<br />
 * 保有契約商品情報Beanリスト取得　証券番号 主契約特約区分のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getHoyuKykSyouhnsBySyonoSyutkkbn {

    @Inject
    HozenDomManager hozenDomManager;

    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111152";

    static C_SyutkKbn P_SYUTKKBN_01 = C_SyutkKbn.SYU;
    static C_SyutkKbn P_SYUTKKBN_02 = C_SyutkKbn.TK;

    static String P_HENKOUSIKIBETUKEY_01 = "KEY00001";
    static String P_HENKOUSIKIBETUKEY_02 = "KEY00002";

    static  C_YuukousyoumetuKbn P_YUUKOUSYOUMETUKBN_01 = C_YuukousyoumetuKbn.SYOUMETU;
    static  C_YuukousyoumetuKbn P_YUUKOUSYOUMETUKBN_02 = C_YuukousyoumetuKbn.YUUKOU;

    static BizDate P_SYOUMETUYMD_01 = BizDate.valueOf(20160320);
    static BizDate P_SYOUMETUYMD_02 = BizDate.valueOf(20160321);

    @BeforeClass
    @Transactional
    public static void preProcess() {
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykSyouhnDao iT_KykSyouhnDao = SWAKInjector.getInstance(IT_KykSyouhnDao.class);
        List<HoyuKykSyouhnsBySyonoSyutkkbnBean> list = iT_KykSyouhnDao.getHoyuKykSyouhnsBySyonoSyutkkbn(P_SYONO_01, P_SYUTKKBN_01);
        Assert.assertEquals(0, list.size());



        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);
        IT_KykSyouhn syohn1 = iT_KykKihon1.createKykSyouhn();
        syohn1.setSyutkkbn(P_SYUTKKBN_01);
        syohn1.setSyouhncd("11");
        syohn1.setSyouhnsdno(11);
        syohn1.setKyksyouhnrenno(1);
        syohn1.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
        syohn1.setYuukousyoumetukbn(P_YUUKOUSYOUMETUKBN_01);
        syohn1.setSyoumetuymd(P_SYOUMETUYMD_01);

        hozenDomManager.insert(iT_KykKihon1);


        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);
        IT_KykSyouhn syohn21 = iT_KykKihon2.createKykSyouhn();
        syohn21.setSyutkkbn(P_SYUTKKBN_01);
        syohn21.setSyouhncd("11");
        syohn21.setSyouhnsdno(11);
        syohn21.setKyksyouhnrenno(1);
        syohn21.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
        syohn21.setYuukousyoumetukbn(P_YUUKOUSYOUMETUKBN_01);
        syohn21.setSyoumetuymd(P_SYOUMETUYMD_01);

        IT_KykSyouhn syohn22 = iT_KykKihon2.createKykSyouhn();
        syohn22.setSyutkkbn(P_SYUTKKBN_02);
        syohn22.setSyouhncd("22");
        syohn22.setSyouhnsdno(22);
        syohn22.setKyksyouhnrenno(2);
        syohn22.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_02);
        syohn22.setYuukousyoumetukbn(P_YUUKOUSYOUMETUKBN_02);
        syohn22.setSyoumetuymd(P_SYOUMETUYMD_02);

        IT_KykSyouhn syohn23 = iT_KykKihon2.createKykSyouhn();
        syohn23.setSyutkkbn(P_SYUTKKBN_02);
        syohn23.setSyouhncd("33");
        syohn23.setSyouhnsdno(33);
        syohn23.setKyksyouhnrenno(3);
        syohn23.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
        syohn23.setYuukousyoumetukbn(P_YUUKOUSYOUMETUKBN_02);
        syohn23.setSyoumetuymd(P_SYOUMETUYMD_02);

        IT_KykSyouhn syohn24 = iT_KykKihon2.createKykSyouhn();
        syohn24.setSyutkkbn(P_SYUTKKBN_02);
        syohn24.setSyouhncd("44");
        syohn24.setSyouhnsdno(44);
        syohn24.setKyksyouhnrenno(4);
        syohn24.setHenkousikibetukey(P_HENKOUSIKIBETUKEY_01);
        syohn24.setYuukousyoumetukbn(P_YUUKOUSYOUMETUKBN_01);
        syohn24.setSyoumetuymd(P_SYOUMETUYMD_02);

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

        List<HoyuKykSyouhnsBySyonoSyutkkbnBean> list = hozenDomManager.getHoyuKykSyouhnsBySyonoSyutkkbn(P_SYONO_01, P_SYUTKKBN_02);
        Assert.assertEquals(0, list.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<HoyuKykSyouhnsBySyonoSyutkkbnBean> list = hozenDomManager.getHoyuKykSyouhnsBySyonoSyutkkbn(P_SYONO_01, P_SYUTKKBN_01);
        Assert.assertEquals(1, list.size());

        Assert.assertEquals(P_SYONO_01, list.get(0).getSyono());
        Assert.assertEquals(P_SYUTKKBN_01, list.get(0).getSyutkkbn());
        Assert.assertEquals(P_HENKOUSIKIBETUKEY_01, list.get(0).getHenkousikibetukey());
        Assert.assertEquals(P_YUUKOUSYOUMETUKBN_01, list.get(0).getYuukousyoumetukbn());
        Assert.assertEquals(P_SYOUMETUYMD_01, list.get(0).getSyoumetuymd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {
        List<HoyuKykSyouhnsBySyonoSyutkkbnBean> list = hozenDomManager.getHoyuKykSyouhnsBySyonoSyutkkbn(P_SYONO_02, P_SYUTKKBN_02);
        Assert.assertEquals(3, list.size());

        Map datamap = new HashMap<String,String>();
        datamap.put($(P_SYONO_02,P_HENKOUSIKIBETUKEY_02,P_SYUTKKBN_02,P_YUUKOUSYOUMETUKBN_02,P_SYOUMETUYMD_02), "1");
        datamap.put($(P_SYONO_02,P_HENKOUSIKIBETUKEY_01,P_SYUTKKBN_02,P_YUUKOUSYOUMETUKBN_02,P_SYOUMETUYMD_02), "1");
        datamap.put($(P_SYONO_02,P_HENKOUSIKIBETUKEY_01,P_SYUTKKBN_02,P_YUUKOUSYOUMETUKBN_01,P_SYOUMETUYMD_02), "1");

        for(HoyuKykSyouhnsBySyonoSyutkkbnBean bean:list){
            datamap.remove($(bean.getSyono(),bean.getHenkousikibetukey(),bean.getSyutkkbn(),bean.getYuukousyoumetukbn(),bean.getSyoumetuymd()));
        }

        assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {
        List<HoyuKykSyouhnsBySyonoSyutkkbnBean> list = hozenDomManager.getHoyuKykSyouhnsBySyonoSyutkkbn("", P_SYUTKKBN_02);
        Assert.assertEquals(0, list.size());
    }
}
