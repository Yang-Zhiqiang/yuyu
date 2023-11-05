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
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ＤＳ顧客契約テーブルエンティティリスト取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestData();

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = directDomManager.
            getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("11807111130");

        Assert.assertEquals(0, dsKokyakuKeiyakuLst.size());


        insertSubData();
    }

    @Transactional
    public static void insertSubData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri mT_DsKokyakuKanri1 = new MT_DsKokyakuKanri("100001");

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd1 = mT_DsKokyakuKanri1.createDsHonninKakuninCd();

        MT_DsLoginKanri mT_DsLoginKanri1 = mT_DsKokyakuKanri1.createDsLoginKanri();

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku1 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku1.setSyono("11807111130");
        mT_DsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(mT_DsKokyakuKanri1);

        MT_DsKokyakuKanri mT_DsKokyakuKanri2 = new MT_DsKokyakuKanri("100002");

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd2 = mT_DsKokyakuKanri2.createDsHonninKakuninCd();

        MT_DsLoginKanri mT_DsLoginKanri2 = mT_DsKokyakuKanri2.createDsLoginKanri();

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku2 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku2.setSyono("11807111129");
        mT_DsKokyakuKeiyaku2.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(mT_DsKokyakuKanri2);

        MT_DsKokyakuKanri mT_DsKokyakuKanri3 = new MT_DsKokyakuKanri("100003");

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd3 = mT_DsKokyakuKanri3.createDsHonninKakuninCd();

        MT_DsLoginKanri mT_DsLoginKanri3 = mT_DsKokyakuKanri3.createDsLoginKanri();

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku3 = mT_DsKokyakuKanri3.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku3.setSyono("11807111130");
        mT_DsKokyakuKeiyaku3.setDskykmukouhyj(C_MukouHyj.MUKOU);

        directDomManager.insert(mT_DsKokyakuKanri3);

        MT_DsKokyakuKanri mT_DsKokyakuKanri4 = new MT_DsKokyakuKanri("100004");

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd4 = mT_DsKokyakuKanri4.createDsHonninKakuninCd();

        MT_DsLoginKanri mT_DsLoginKanri4 = mT_DsKokyakuKanri4.createDsLoginKanri();

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku4 = mT_DsKokyakuKanri4.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku4.setSyono("11807111200");
        mT_DsKokyakuKeiyaku4.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(mT_DsKokyakuKanri4);

        MT_DsKokyakuKanri mT_DsKokyakuKanri5 = new MT_DsKokyakuKanri("100005");

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd5 = mT_DsKokyakuKanri5.createDsHonninKakuninCd();

        MT_DsLoginKanri mT_DsLoginKanri5 = mT_DsKokyakuKanri5.createDsLoginKanri();

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku5 = mT_DsKokyakuKanri5.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku5.setSyono("11807111200");
        mT_DsKokyakuKeiyaku5.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(mT_DsKokyakuKanri5);

        MT_DsKokyakuKanri mT_DsKokyakuKanri6 = new MT_DsKokyakuKanri("100006");

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd6 = mT_DsKokyakuKanri6.createDsHonninKakuninCd();

        MT_DsLoginKanri mT_DsLoginKanri6 = mT_DsKokyakuKanri6.createDsLoginKanri();

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku6 = mT_DsKokyakuKanri6.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku6.setSyono("11807111200");
        mT_DsKokyakuKeiyaku6.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(mT_DsKokyakuKanri6);

        MT_DsKokyakuKanri mT_DsKokyakuKanri7 = new MT_DsKokyakuKanri("100007");

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd7 = mT_DsKokyakuKanri7.createDsHonninKakuninCd();

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku7 = mT_DsKokyakuKanri7.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku7.setSyono("11807111200");
        mT_DsKokyakuKeiyaku7.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(mT_DsKokyakuKanri7);

        MT_DsKokyakuKanri mT_DsKokyakuKanri8 = new MT_DsKokyakuKanri("100008");

        MT_DsLoginKanri mT_DsLoginKanri8 = mT_DsKokyakuKanri8.createDsLoginKanri();

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku8 = mT_DsKokyakuKanri8.createDsKokyakuKeiyaku();

        mT_DsKokyakuKeiyaku8.setSyono("11807111200");
        mT_DsKokyakuKeiyaku8.setDskykmukouhyj(C_MukouHyj.BLANK);

        directDomManager.insert(mT_DsKokyakuKanri8);

        MT_DsKokyakuKanri mT_DsKokyakuKanri9 = new MT_DsKokyakuKanri("100009");

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd9 = mT_DsKokyakuKanri9.createDsHonninKakuninCd();

        MT_DsLoginKanri mT_DsLoginKanri9 = mT_DsKokyakuKanri9.createDsLoginKanri();

        directDomManager.insert(mT_DsKokyakuKanri9);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<MT_DsKokyakuKeiyaku> mT_DsKokyakuKeiyakuLst = directDomManager.
            getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("11807111118");

        Assert.assertEquals(0, mT_DsKokyakuKeiyakuLst.size());
    }
    @Test
    @TestOrder(20)
    public void normal1() {

        List<MT_DsKokyakuKeiyaku> mT_DsKokyakuKeiyakuLst = directDomManager.
            getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("11807111130");

        Assert.assertEquals(1, mT_DsKokyakuKeiyakuLst.size());

        Assert.assertEquals("100001", mT_DsKokyakuKeiyakuLst.get(0).getDskokno());
        Assert.assertEquals("11807111130", mT_DsKokyakuKeiyakuLst.get(0).getSyono());
        Assert.assertEquals(C_MukouHyj.BLANK, mT_DsKokyakuKeiyakuLst.get(0).getDskykmukouhyj());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("100004","11807111200","0"), "1");
        datamap.put($("100005","11807111200","0"), "2");
        datamap.put($("100006","11807111200","0"), "3");

        List<MT_DsKokyakuKeiyaku> mT_DsKokyakuKeiyakuLst = directDomManager.
            getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("11807111200");

        for(MT_DsKokyakuKeiyaku dsKokyakuKeiyaku:mT_DsKokyakuKeiyakuLst){
            datamap.remove($(dsKokyakuKeiyaku.getDskokno(),dsKokyakuKeiyaku.getSyono(),dsKokyakuKeiyaku.getDskykmukouhyj()));
        }

        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blank1() {

        List<MT_DsKokyakuKeiyaku> mT_DsKokyakuKeiyakuLst = directDomManager.
            getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank("");

        Assert.assertEquals(0, mT_DsKokyakuKeiyakuLst.size());
    }
}
