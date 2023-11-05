package yuyu.def.direct.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ダイレクトサービス共通DBアクセス<br />
 * ＤＳ顧客契約テーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn {

    @Inject
    DirectDomManager directDomManager;
    HozenDomManager hozenDomManager;

    public static String P_DSKOKNO_01 = "1118120714";
    public static String P_DSKOKNO_02 = "1118120715";
    public static String P_DSKOKNO_03 = "1118120716";
    public static String P_SYONO_01 = "11807111118";
    public static String P_SYONO_02 = "11807111130";
    public static String P_SYONO_03 = "11807111141";
    public static String P_SYONO_04 = "11807111152";

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestData();

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = directDomManager.
            getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn(P_DSKOKNO_02);

        Assert.assertEquals(0, dsKokyakuKeiyakuLst.size());


        insertSubData();
    }

    @Transactional
    public static void insertSubData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri mT_DsKokyakuKanri1 = new MT_DsKokyakuKanri(P_DSKOKNO_01);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku1 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku1.setSyono(P_SYONO_01);
        mT_DsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.MUKOU);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku2 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku2.setSyono(P_SYONO_02);
        mT_DsKokyakuKeiyaku2.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku3 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku3.setSyono(P_SYONO_03);
        mT_DsKokyakuKeiyaku3.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku4 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku4.setSyono(P_SYONO_04);
        mT_DsKokyakuKeiyaku4.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(mT_DsKokyakuKanri1);

        MT_DsKokyakuKanri mT_DsKokyakuKanri2 = new MT_DsKokyakuKanri(P_DSKOKNO_02);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku5 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku5.setSyono(P_SYONO_01);
        mT_DsKokyakuKeiyaku5.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(mT_DsKokyakuKanri2);

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);

        IT_KykSyouhn kykSyouhn1 = iT_KykKihon1.createKykSyouhn();

        kykSyouhn1.setSyutkkbn(C_SyutkKbn.TK);
        kykSyouhn1.setSyouhncd("1001");
        kykSyouhn1.setSyouhnsdno(01);
        kykSyouhn1.setKyksyouhnrenno(1);
        kykSyouhn1.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);

        IT_KykSyouhn kykSyouhn2 = iT_KykKihon1.createKykSyouhn();

        kykSyouhn2.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn2.setSyouhncd("1001");
        kykSyouhn2.setSyouhnsdno(01);
        kykSyouhn2.setKyksyouhnrenno(1);
        kykSyouhn2.setYuukousyoumetukbn(C_YuukousyoumetuKbn.YUUKOU);

        IT_KykSyouhn kykSyouhn3 = iT_KykKihon1.createKykSyouhn();

        kykSyouhn3.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn3.setSyouhncd("1002");
        kykSyouhn3.setSyouhnsdno(01);
        kykSyouhn3.setKyksyouhnrenno(1);
        kykSyouhn3.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);

        hozenDomManager.insert(iT_KykKihon1);

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);

        IT_KykSyouhn kykSyouhn4 = iT_KykKihon2.createKykSyouhn();

        kykSyouhn4.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn4.setSyouhncd("1001");
        kykSyouhn4.setSyouhnsdno(01);
        kykSyouhn4.setKyksyouhnrenno(1);
        kykSyouhn4.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);

        hozenDomManager.insert(iT_KykKihon2);

        IT_KykKihon iT_KykKihon3 = new IT_KykKihon(P_SYONO_03);

        IT_KykSyouhn kykSyouhn5 = iT_KykKihon3.createKykSyouhn();

        kykSyouhn5.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn5.setSyouhncd("1001");
        kykSyouhn5.setSyouhnsdno(01);
        kykSyouhn5.setKyksyouhnrenno(1);
        kykSyouhn5.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);

        hozenDomManager.insert(iT_KykKihon3);

        IT_KykKihon iT_KykKihon4 = new IT_KykKihon(P_SYONO_04);

        IT_KykSyouhn kykSyouhn6 = iT_KykKihon4.createKykSyouhn();

        kykSyouhn6.setSyutkkbn(C_SyutkKbn.SYU);
        kykSyouhn6.setSyouhncd("1001");
        kykSyouhn6.setSyouhnsdno(01);
        kykSyouhn6.setKyksyouhnrenno(1);
        kykSyouhn6.setYuukousyoumetukbn(C_YuukousyoumetuKbn.SYOUMETU);

        hozenDomManager.insert(iT_KykKihon4);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<MT_DsKokyakuKeiyaku> mT_DsKokyakuKeiyakuLst = directDomManager.
            getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn(P_DSKOKNO_03);

        Assert.assertEquals(0, mT_DsKokyakuKeiyakuLst.size());
    }
    @Test
    @TestOrder(20)
    public void normal1() {

        List<MT_DsKokyakuKeiyaku> mT_DsKokyakuKeiyakuLst = directDomManager.
            getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn(P_DSKOKNO_02);

        Assert.assertEquals(1, mT_DsKokyakuKeiyakuLst.size());

        Assert.assertEquals(P_DSKOKNO_02, mT_DsKokyakuKeiyakuLst.get(0).getDskokno());
        Assert.assertEquals(P_SYONO_01, mT_DsKokyakuKeiyakuLst.get(0).getSyono());
        Assert.assertEquals(C_MukouHyj.BLANK, mT_DsKokyakuKeiyakuLst.get(0).getDskykmukouhyj());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("1118120714","11807111130","0"), "1");
        datamap.put($("1118120714","11807111141","0"), "2");
        datamap.put($("1118120714","11807111152","0"), "3");

        List<MT_DsKokyakuKeiyaku> mT_DsKokyakuKeiyakuLst = directDomManager.
            getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn(P_DSKOKNO_01);

        for(MT_DsKokyakuKeiyaku dsKokyakuKeiyaku:mT_DsKokyakuKeiyakuLst){
            datamap.remove($(dsKokyakuKeiyaku.getDskokno(),dsKokyakuKeiyaku.getSyono(),dsKokyakuKeiyaku.getDskykmukouhyj()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<MT_DsKokyakuKeiyaku> mT_DsKokyakuKeiyakuLst = directDomManager.
            getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn("");

        Assert.assertEquals(0, mT_DsKokyakuKeiyakuLst.size());
    }
}
