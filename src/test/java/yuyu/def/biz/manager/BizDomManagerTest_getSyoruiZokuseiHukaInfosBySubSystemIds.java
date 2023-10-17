package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.BM_SyoruiZokuseiHukaInfo;
import yuyu.testinfr.TestOrder;

/**
 * 書類属性付加情報マスタエンティティリストのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getSyoruiZokuseiHukaInfosBySubSystemIds {

    @Inject
    private BizDomManager bizDomManager;

    private static final String[] subSystemId0 = {"003", null};
    private static final String[] subSystemId1 = {};
    private static final String[] subSystemId2 = {"004", "006", "007"};
    private static final String[] subSystemId3 = {""};
    private static final String[] subSystemId4 = {"003", "002", "001", "010"};
    private static final String[] subSystemId5 = {"", "003","002", "001", "010"};
    private static final String[] subSystemId6 = {"", ""};
    private static final String[] subSystemId7 = {"", "004", "006", "007"};
    private static final String[] subSystemId8 = {"003"};

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<BM_SyoruiZokuseiHukaInfo> syoruiZokuseiHukaInfoLst = bizDomManager.getSyoruiZokuseiHukaInfosBySubSystemIds(
            subSystemId4);

        Assert.assertEquals(0, syoruiZokuseiHukaInfoLst.size());

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo1 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo1.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        syoruiZokuseiHukaInfo1.setSubSystemId("005");
        syoruiZokuseiHukaInfo1.setTyouhyououtkinousiyouumu(C_UmuKbn.ARI);

        //BT_TyouhyouOutputKengen tyouhyouOutputKengen1 = syoruiZokuseiHukaInfo1.createTyouhyouOutputKengen();
        //tyouhyouOutputKengen1.setRoleCd("003");
        //        BT_TyouhyouOutputKengen tyouhyouOutputKengen1 = new BT_TyouhyouOutputKengen();
        //        tyouhyouOutputKengen1.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        //        tyouhyouOutputKengen1.setRoleCd("003");

        bizDomManager.insert(syoruiZokuseiHukaInfo1);
        // bizDomManager.insert(tyouhyouOutputKengen1);

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo2 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo2.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        syoruiZokuseiHukaInfo2.setSubSystemId("001");
        syoruiZokuseiHukaInfo2.setTyouhyououtkinousiyouumu(C_UmuKbn.ARI);

        //BT_TyouhyouOutputKengen tyouhyouOutputKengen2 = syoruiZokuseiHukaInfo2.createTyouhyouOutputKengen();
        //tyouhyouOutputKengen2.setRoleCd("004");
        //        BT_TyouhyouOutputKengen tyouhyouOutputKengen2 = new BT_TyouhyouOutputKengen();
        //        tyouhyouOutputKengen2.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        //        tyouhyouOutputKengen2.setRoleCd("004");

        bizDomManager.insert(syoruiZokuseiHukaInfo2);
        //        bizDomManager.insert(tyouhyouOutputKengen2);

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo3 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo3.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);
        syoruiZokuseiHukaInfo3.setSubSystemId("002");
        syoruiZokuseiHukaInfo3.setTyouhyououtkinousiyouumu(C_UmuKbn.ARI);

        //BT_TyouhyouOutputKengen tyouhyouOutputKengen3 = syoruiZokuseiHukaInfo3.createTyouhyouOutputKengen();
        //tyouhyouOutputKengen3.setRoleCd("003");
        //        BT_TyouhyouOutputKengen tyouhyouOutputKengen3 = new BT_TyouhyouOutputKengen();
        //        tyouhyouOutputKengen3.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);
        //        tyouhyouOutputKengen3.setRoleCd("003");

        bizDomManager.insert(syoruiZokuseiHukaInfo3);
        //        bizDomManager.insert(tyouhyouOutputKengen3);

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo4 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo4.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);
        syoruiZokuseiHukaInfo4.setSubSystemId("003");
        syoruiZokuseiHukaInfo4.setTyouhyououtkinousiyouumu(C_UmuKbn.ARI);
        bizDomManager.insert(syoruiZokuseiHukaInfo4);

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo5 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo5.setSyoruiCd(C_SyoruiCdKbn.HK_KD_JIKOJKS);
        syoruiZokuseiHukaInfo5.setSubSystemId("010");
        syoruiZokuseiHukaInfo5.setTyouhyououtkinousiyouumu(C_UmuKbn.ARI);
        bizDomManager.insert(syoruiZokuseiHukaInfo5);

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo6 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo6.setSyoruiCd(C_SyoruiCdKbn.HK_SEISANKINHRKM_IRAIS);
        syoruiZokuseiHukaInfo6.setSubSystemId("006");
        syoruiZokuseiHukaInfo6.setTyouhyououtkinousiyouumu(C_UmuKbn.ARI);
        bizDomManager.insert(syoruiZokuseiHukaInfo6);

        BM_SyoruiZokuseiHukaInfo syoruiZokuseiHukaInfo7 = new BM_SyoruiZokuseiHukaInfo();
        syoruiZokuseiHukaInfo7.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        syoruiZokuseiHukaInfo7.setSubSystemId("008");
        syoruiZokuseiHukaInfo7.setTyouhyououtkinousiyouumu(C_UmuKbn.NONE);

        //BT_TyouhyouOutputKengen tyouhyouOutputKengen4 = syoruiZokuseiHukaInfo7.createTyouhyouOutputKengen();
        //tyouhyouOutputKengen4.setRoleCd("003");
        //        BT_TyouhyouOutputKengen tyouhyouOutputKengen4 = new BT_TyouhyouOutputKengen();
        //        tyouhyouOutputKengen4.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        //        tyouhyouOutputKengen4.setRoleCd("003");

        bizDomManager.insert(syoruiZokuseiHukaInfo7);
        //        bizDomManager.insert(tyouhyouOutputKengen4);

        AS_SubSystem subSystem1 = new AS_SubSystem();
        subSystem1.setSubSystemId("001");
        subSystem1.setSortNo(3);
        baseDomManager.insert(subSystem1);

        AS_SubSystem subSystem2 = new AS_SubSystem();
        subSystem2.setSubSystemId("003");
        subSystem2.setSortNo(2);
        baseDomManager.insert(subSystem2);

        AS_SubSystem subSystem3 = new AS_SubSystem();
        subSystem3.setSubSystemId("002");
        subSystem3.setSortNo(1);
        baseDomManager.insert(subSystem3);

        AS_SubSystem subSystem4 = new AS_SubSystem();
        subSystem4.setSubSystemId("010");
        subSystem4.setSortNo(1);
        baseDomManager.insert(subSystem4);

        AS_SubSystem subSystem5 = new AS_SubSystem();
        subSystem5.setSubSystemId("004");
        subSystem5.setSortNo(4);
        baseDomManager.insert(subSystem5);

        AS_SubSystem subSystem6 = new AS_SubSystem();
        subSystem6.setSubSystemId("006");
        subSystem6.setSortNo(6);
        baseDomManager.insert(subSystem6);

        AS_SubSystem subSystem7 = new AS_SubSystem();
        subSystem7.setSubSystemId("008");
        subSystem7.setSortNo(7);
        baseDomManager.insert(subSystem7);

        AM_SyoruiZokusei syoruiZokusei1 = new AM_SyoruiZokusei();
        syoruiZokusei1.setSyoruiCd(C_SyoruiCdKbn.BLNK);
        syoruiZokusei1.setSortNo(5);
        bizDomManager.insert(syoruiZokusei1);

        AM_SyoruiZokusei syoruiZokusei2 = new AM_SyoruiZokusei();
        syoruiZokusei2.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        syoruiZokusei2.setSortNo(2);
        bizDomManager.insert(syoruiZokusei2);

        AM_SyoruiZokusei syoruiZokusei3 = new AM_SyoruiZokusei();
        syoruiZokusei3.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);
        syoruiZokusei3.setSortNo(4);
        bizDomManager.insert(syoruiZokusei3);

        AM_SyoruiZokusei syoruiZokusei4 = new AM_SyoruiZokusei();
        syoruiZokusei4.setSyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);
        syoruiZokusei4.setSortNo(3);
        bizDomManager.insert(syoruiZokusei4);

        AM_SyoruiZokusei syoruiZokusei5 = new AM_SyoruiZokusei();
        syoruiZokusei5.setSyoruiCd(C_SyoruiCdKbn.HK_KD_JIKOJKS);
        syoruiZokusei5.setSortNo(1);
        bizDomManager.insert(syoruiZokusei5);

        AM_SyoruiZokusei syoruiZokusei6 = new AM_SyoruiZokusei();
        syoruiZokusei6.setSyoruiCd(C_SyoruiCdKbn.HK_TEISYUTUSYORUI);
        syoruiZokusei6.setSortNo(1);
        bizDomManager.insert(syoruiZokusei6);

        AM_SyoruiZokusei syoruiZokusei7 = new AM_SyoruiZokusei();
        syoruiZokusei7.setSyoruiCd(C_SyoruiCdKbn.HK_SB_DAIHYOU);
        syoruiZokusei7.setSortNo(1);
        bizDomManager.insert(syoruiZokusei7);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyoruiZokuseiHukaInfo());
        //        bizDomManager.delete(bizDomManager.getAllTyouhyouOutputKengen());
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSubSystems());
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());

    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<BM_SyoruiZokuseiHukaInfo> syoruiZokuseiHukaInfoLst = bizDomManager.getSyoruiZokuseiHukaInfosBySubSystemIds(
            subSystemId2);

        Assert.assertEquals(0, syoruiZokuseiHukaInfoLst.size());
    }

    @Test
    @TestOrder(20)
    public void noResult2() {

        List<BM_SyoruiZokuseiHukaInfo> syoruiZokuseiHukaInfoLst = bizDomManager.getSyoruiZokuseiHukaInfosBySubSystemIds(
            subSystemId7);

        Assert.assertEquals(0, syoruiZokuseiHukaInfoLst.size());

    }

    @Test
    @TestOrder(30)
    public void normal1() {
        List<BM_SyoruiZokuseiHukaInfo> syoruiZokuseiHukaInfoLst = bizDomManager.getSyoruiZokuseiHukaInfosBySubSystemIds(
            subSystemId4);

        Assert.assertEquals(4, syoruiZokuseiHukaInfoLst.size());
        Assert.assertEquals(C_SyoruiCdKbn.HK_SHRMESS, syoruiZokuseiHukaInfoLst.get(3).getSyoruiCd());
        Assert.assertEquals(C_SyoruiCdKbn.HK_SB_HOKEN_SKS, syoruiZokuseiHukaInfoLst.get(2).getSyoruiCd());
        Assert.assertEquals(C_SyoruiCdKbn.HK_SHMEISAI_SDS, syoruiZokuseiHukaInfoLst.get(1).getSyoruiCd());
        Assert.assertEquals(C_SyoruiCdKbn.HK_KD_JIKOJKS, syoruiZokuseiHukaInfoLst.get(0).getSyoruiCd());
    }

    @Test
    @TestOrder(40)
    public void normal2() {
        List<BM_SyoruiZokuseiHukaInfo> syoruiZokuseiHukaInfoLst = bizDomManager.getSyoruiZokuseiHukaInfosBySubSystemIds(
            subSystemId5);

        Assert.assertEquals(4, syoruiZokuseiHukaInfoLst.size());
        Assert.assertEquals(C_SyoruiCdKbn.HK_KD_JIKOJKS, syoruiZokuseiHukaInfoLst.get(0).getSyoruiCd());
        Assert.assertEquals(C_SyoruiCdKbn.HK_SHMEISAI_SDS, syoruiZokuseiHukaInfoLst.get(1).getSyoruiCd());
        Assert.assertEquals(C_SyoruiCdKbn.HK_SB_HOKEN_SKS, syoruiZokuseiHukaInfoLst.get(2).getSyoruiCd());
        Assert.assertEquals(C_SyoruiCdKbn.HK_SHRMESS, syoruiZokuseiHukaInfoLst.get(3).getSyoruiCd());
    }

    @Test
    @TestOrder(50)
    public void normal3() {
        List<BM_SyoruiZokuseiHukaInfo> syoruiZokuseiHukaInfoLst = bizDomManager.getSyoruiZokuseiHukaInfosBySubSystemIds(
            subSystemId8);

        Assert.assertEquals(1, syoruiZokuseiHukaInfoLst.size());
        Assert.assertEquals(C_SyoruiCdKbn.HK_SB_HOKEN_SKS, syoruiZokuseiHukaInfoLst.get(0).getSyoruiCd());

    }

    @Test
    @TestOrder(90)
    public void blankCondition1() {

        List<BM_SyoruiZokuseiHukaInfo> syoruiZokuseiHukaInfoLst = bizDomManager.getSyoruiZokuseiHukaInfosBySubSystemIds(
            subSystemId3);

        Assert.assertEquals(0, syoruiZokuseiHukaInfoLst.size());
        //        Assert.assertEquals(C_SyoruiCdKbn.HK_KD_JIKOJKS, syoruiZokuseiHukaInfoLst.get(0).getSyoruiCd());
        //        Assert.assertEquals(C_SyoruiCdKbn.HK_SHMEISAI_SDS, syoruiZokuseiHukaInfoLst.get(1).getSyoruiCd());
        //        Assert.assertEquals(C_SyoruiCdKbn.HK_SB_HOKEN_SKS, syoruiZokuseiHukaInfoLst.get(2).getSyoruiCd());
        //        Assert.assertEquals(C_SyoruiCdKbn.HK_SHRMESS, syoruiZokuseiHukaInfoLst.get(3).getSyoruiCd());
    }

    @Test
    @TestOrder(100)
    public void blankCondition2() {

        List<BM_SyoruiZokuseiHukaInfo> syoruiZokuseiHukaInfoLst = bizDomManager.getSyoruiZokuseiHukaInfosBySubSystemIds(
            subSystemId6);

        Assert.assertEquals(0, syoruiZokuseiHukaInfoLst.size());
    }

}
