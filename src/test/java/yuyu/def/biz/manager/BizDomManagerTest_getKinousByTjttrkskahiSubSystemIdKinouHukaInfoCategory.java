package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.BT_KinouHukaInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 機能付加情報テーブルのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<AS_Kinou> KinouLst = bizDomManager.getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(C_KahiKbn.KA,"sinkeiyaku");

        Assert.assertEquals(0,KinouLst.size());

        BT_KinouHukaInfo kinouHukaInfo1 = new BT_KinouHukaInfo("khseinengappiseiteisei");
        kinouHukaInfo1.setTjttrkskahi(C_KahiKbn.valueOf("0"));

        bizDomManager.insert(kinouHukaInfo1);

        BT_KinouHukaInfo kinouHukaInfo2 = new BT_KinouHukaInfo("skkyouseihand");
        kinouHukaInfo2.setTjttrkskahi(C_KahiKbn.valueOf("1"));

        bizDomManager.insert(kinouHukaInfo2);

        BT_KinouHukaInfo kinouHukaInfo3 = new BT_KinouHukaInfo("sktokunin");
        kinouHukaInfo3.setTjttrkskahi(C_KahiKbn.valueOf("0"));

        bizDomManager.insert(kinouHukaInfo3);

        BT_KinouHukaInfo kinouHukaInfo4 = new BT_KinouHukaInfo("khjyuusyohenkou");
        kinouHukaInfo4.setTjttrkskahi(C_KahiKbn.valueOf("1"));

        bizDomManager.insert(kinouHukaInfo4);

        BT_KinouHukaInfo kinouHukaInfo5 = new BT_KinouHukaInfo("khkaiyaku");
        kinouHukaInfo5.setTjttrkskahi(C_KahiKbn.valueOf("1"));

        bizDomManager.insert(kinouHukaInfo5);

        BT_KinouHukaInfo kinouHukaInfo6 = new BT_KinouHukaInfo("khkeiyakutorikesi");
        kinouHukaInfo6.setTjttrkskahi(C_KahiKbn.valueOf("1"));

        bizDomManager.insert(kinouHukaInfo6);

        BT_KinouHukaInfo kinouHukaInfo7 = new BT_KinouHukaInfo("khkeiyakuinfotorikomi");
        kinouHukaInfo7.setTjttrkskahi(C_KahiKbn.valueOf("1"));

        bizDomManager.insert(kinouHukaInfo7);

        BT_KinouHukaInfo kinouHukaInfo8 = new BT_KinouHukaInfo("khsiharaikekkatorikomi");
        kinouHukaInfo8.setTjttrkskahi(C_KahiKbn.valueOf("1"));

        bizDomManager.insert(kinouHukaInfo8);

        BT_KinouHukaInfo kinouHukaInfo9 = new BT_KinouHukaInfo("khkzseibi");
        kinouHukaInfo9.setTjttrkskahi(C_KahiKbn.valueOf("1"));

        bizDomManager.insert(kinouHukaInfo9);

        AS_Category category1 = new AS_Category("skkettei2");
        category1.setSubSystemId("sinkeiyaku");

        baseDomManager.insert(category1);

        AS_Category category2 = new AS_Category("skkettei");
        category2.setSubSystemId("sinkeiyaku");
        category2.setSortNo(1);

        baseDomManager.insert(category2);

        AS_Category category3 = new AS_Category("khozen");
        category3.setSubSystemId("hozen");
        category3.setSortNo(3);

        baseDomManager.insert(category3);

        AS_Category category4 = new AS_Category("khinterf");
        category4.setSubSystemId("hozen");
        category4.setSortNo(2);

        baseDomManager.insert(category4);

        AS_Category category5 = new AS_Category("khansyuu");
        category5.setSubSystemId("hozen");
        category5.setSortNo(1);

        baseDomManager.insert(category5);

        AS_SubSystem subSystem1 = new AS_SubSystem("hozen");
        subSystem1.setSubSystemNm("契約保全");
        subSystem1.setSortNo(3);

        baseDomManager.insert(subSystem1);

        AS_SubSystem subSystem2 = new AS_SubSystem("sinkeiyaku");
        subSystem2.setSubSystemNm("新契約");
        subSystem2.setSortNo(1);

        baseDomManager.insert(subSystem2);

        AS_Kinou kinou1 = new AS_Kinou("khseinengappiseiteisei");
        kinou1.setSubSystemId("hozen");
        kinou1.setCategoryId("skkettei");
        kinou1.setKinouNm("生年月日・性訂正");
        kinou1.setSortNo(3);

        baseDomManager.insert(kinou1);

        AS_Kinou kinou2 = new AS_Kinou("skkyouseihand");
        kinou2.setSubSystemId("sinkeiyaku");
        kinou2.setCategoryId("skkettei");
        kinou2.setKinouNm("強制ハンド決定入力");
        kinou2.setSortNo(5);

        baseDomManager.insert(kinou2);

        AS_Kinou kinou3 = new AS_Kinou("fukasinai");
        kinou3.setSubSystemId("sinkeiyaku");
        kinou3.setCategoryId("skkettei");
        kinou3.setKinouNm("付加存在しない");
        kinou3.setSortNo(1);

        baseDomManager.insert(kinou3);

        AS_Kinou kinou4 = new AS_Kinou("sktokunin");
        kinou4.setSubSystemId("sinkeiyaku");
        kinou4.setCategoryId("skkettei");
        kinou4.setKinouNm("特認処理");
        kinou4.setSortNo(2);

        baseDomManager.insert(kinou4);

        AS_Kinou kinou5 = new AS_Kinou("khjyuusyohenkou");
        kinou5.setSubSystemId("hozen");
        kinou5.setCategoryId("khozen");
        kinou5.setKinouNm("住所変更");
        kinou5.setSortNo(4);

        baseDomManager.insert(kinou5);

        AS_Kinou kinou6 = new AS_Kinou("khkaiyaku");
        kinou6.setSubSystemId("hozen");
        kinou6.setCategoryId("khozen");
        kinou6.setKinouNm("解約");
        kinou6.setSortNo(2);

        baseDomManager.insert(kinou6);

        AS_Kinou kinou7 = new AS_Kinou("khkeiyakutorikesi");
        kinou7.setSubSystemId("hozen");
        kinou7.setCategoryId("khozen");
        kinou7.setKinouNm("契約取消");
        kinou7.setSortNo(1);

        baseDomManager.insert(kinou7);

        AS_Kinou kinou8 = new AS_Kinou("khkeiyakuinfotorikomi");
        kinou8.setSubSystemId("hozen");
        kinou8.setCategoryId("khinterf");
        kinou8.setKinouNm("契約情報取込");
        kinou8.setSortNo(2);

        baseDomManager.insert(kinou8);

        AS_Kinou kinou9 = new AS_Kinou("khsiharaikekkatorikomi");
        kinou9.setSubSystemId("hozen");
        kinou9.setCategoryId("khinterf");
        kinou9.setKinouNm("支払結果情報取込");
        kinou9.setSortNo(1);

        baseDomManager.insert(kinou9);

        AS_Kinou kinou10 = new AS_Kinou("khkzseibi");
        kinou10.setSubSystemId("hozen");
        kinou10.setCategoryId("khansyuu");
        kinou10.setKinouNm("口座整備処理");
        kinou10.setSortNo(1);

        baseDomManager.insert(kinou10);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKinouHukaInfo());
        baseDomManager.delete(baseDomManager.getAllKinous());
        baseDomManager.delete(baseDomManager.getAllCategories());
        baseDomManager.delete(baseDomManager.getAllSubSystems());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){


        List<AS_Kinou> KinouLst = bizDomManager.getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(C_KahiKbn.KA,"base");

        Assert.assertEquals(0, KinouLst.size());


    }

    @Test
    @TestOrder(20)
    public void normal1() {
        List<AS_Kinou> KinouLst = bizDomManager.getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(C_KahiKbn.HUKA, "sinkeiyaku");

        Assert.assertEquals(1, KinouLst.size());

        Assert.assertEquals("sktokunin", KinouLst.get(0).getKinouId());
        Assert.assertEquals("sinkeiyaku", KinouLst.get(0).getSubSystemId());
        Assert.assertEquals("skkettei", KinouLst.get(0).getCategoryId());
        Assert.assertEquals("特認処理", KinouLst.get(0).getKinouNm());
        Assert.assertEquals(Integer.valueOf(2), KinouLst.get(0).getSortNo());
    }

    @Test
    @TestOrder(30)
    public void normal2(){
        List<AS_Kinou> KinouList = bizDomManager.getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(C_KahiKbn.KA,"hozen");

        Assert.assertEquals(6, KinouList.size());

        Assert.assertEquals("khkzseibi", KinouList.get(0).getKinouId());
        Assert.assertEquals("hozen", KinouList.get(0).getSubSystemId());
        Assert.assertEquals("khansyuu", KinouList.get(0).getCategoryId());
        Assert.assertEquals("口座整備処理", KinouList.get(0).getKinouNm());
        Assert.assertEquals(Integer.valueOf(1), KinouList.get(0).getSortNo());

        Assert.assertEquals("khsiharaikekkatorikomi", KinouList.get(1).getKinouId());
        Assert.assertEquals("hozen", KinouList.get(1).getSubSystemId());
        Assert.assertEquals("khinterf", KinouList.get(1).getCategoryId());
        Assert.assertEquals("支払結果情報取込", KinouList.get(1).getKinouNm());
        Assert.assertEquals(Integer.valueOf(1), KinouList.get(1).getSortNo());

        Assert.assertEquals("khkeiyakuinfotorikomi", KinouList.get(2).getKinouId());
        Assert.assertEquals("hozen", KinouList.get(2).getSubSystemId());
        Assert.assertEquals("khinterf", KinouList.get(2).getCategoryId());
        Assert.assertEquals("契約情報取込", KinouList.get(2).getKinouNm());
        Assert.assertEquals(Integer.valueOf(2), KinouList.get(2).getSortNo());

        Assert.assertEquals("khkeiyakutorikesi", KinouList.get(3).getKinouId());
        Assert.assertEquals("hozen", KinouList.get(3).getSubSystemId());
        Assert.assertEquals("khozen", KinouList.get(3).getCategoryId());
        Assert.assertEquals("契約取消", KinouList.get(3).getKinouNm());
        Assert.assertEquals(Integer.valueOf(1), KinouList.get(3).getSortNo());

        Assert.assertEquals("khkaiyaku", KinouList.get(4).getKinouId());
        Assert.assertEquals("hozen", KinouList.get(4).getSubSystemId());
        Assert.assertEquals("khozen", KinouList.get(4).getCategoryId());
        Assert.assertEquals("解約", KinouList.get(4).getKinouNm());
        Assert.assertEquals(Integer.valueOf(2), KinouList.get(4).getSortNo());

        Assert.assertEquals("khjyuusyohenkou", KinouList.get(5).getKinouId());
        Assert.assertEquals("hozen", KinouList.get(5).getSubSystemId());
        Assert.assertEquals("khozen", KinouList.get(5).getCategoryId());
        Assert.assertEquals("住所変更", KinouList.get(5).getKinouNm());
        Assert.assertEquals(Integer.valueOf(4), KinouList.get(5).getSortNo());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {
        List<AS_Kinou> KinouList = bizDomManager.getKinousByTjttrkskahiSubSystemIdKinouHukaInfoCategory(C_KahiKbn.KA,"");

        Assert.assertEquals(0, KinouList.size());
    }


}
