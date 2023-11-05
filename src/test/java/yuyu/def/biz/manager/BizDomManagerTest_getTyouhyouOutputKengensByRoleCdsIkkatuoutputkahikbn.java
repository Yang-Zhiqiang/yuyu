package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn {

    @Inject
    BizDomManager bizDomManager;

    private final static String[] dSyukouteikanriid1 = {"sk03","sk04","sk05"};
    private final static String[] dSyukouteikanriid2 = {"sk06","sk07"};
    private final static String[] dSyukouteikanriid3 = {"sk01","sk06"};
    private final static String[] dSyukouteikanriid4 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        List<BT_TyouhyouOutputKengen> tyouhyouOutputKengenLst = bizDomManager.getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(dSyukouteikanriid1, C_KahiKbn.KA);

        Assert.assertEquals(0,tyouhyouOutputKengenLst.size());

        BT_TyouhyouOutputKengen tyouhyouOutputKengen = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen.setRoleCd("sk01");
        tyouhyouOutputKengen.setSyoruiCd(C_SyoruiCdKbn.CM_JIMURENRAKUHYOU);
        tyouhyouOutputKengen.setIkkatuoutputkahikbn(C_KahiKbn.KA);
        bizDomManager.insert(tyouhyouOutputKengen);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen2 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen2.setRoleCd("sk02");
        tyouhyouOutputKengen2.setSyoruiCd(C_SyoruiCdKbn.CM_JIMURENRAKUHYOU);
        tyouhyouOutputKengen2.setIkkatuoutputkahikbn(C_KahiKbn.KA);
        bizDomManager.insert(tyouhyouOutputKengen2);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen3 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen3.setRoleCd("sk01");
        tyouhyouOutputKengen3.setSyoruiCd(C_SyoruiCdKbn.CM_LINC_MISSLIST);
        tyouhyouOutputKengen3.setIkkatuoutputkahikbn(C_KahiKbn.HUKA);
        bizDomManager.insert(tyouhyouOutputKengen3);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen4 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen4.setRoleCd("sk03");
        tyouhyouOutputKengen4.setSyoruiCd(C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);
        tyouhyouOutputKengen4.setIkkatuoutputkahikbn(C_KahiKbn.KA);
        bizDomManager.insert(tyouhyouOutputKengen4);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen5 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen5.setRoleCd("sk04");
        tyouhyouOutputKengen5.setSyoruiCd(C_SyoruiCdKbn.CM_BATCH_GKFBFURIKOMIKEI);
        tyouhyouOutputKengen5.setIkkatuoutputkahikbn(C_KahiKbn.KA);
        bizDomManager.insert(tyouhyouOutputKengen5);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen6 = new BT_TyouhyouOutputKengen();
        tyouhyouOutputKengen6.setRoleCd("sk05");
        tyouhyouOutputKengen6.setSyoruiCd(C_SyoruiCdKbn.CM_JIMURENRAKUHYOU);
        tyouhyouOutputKengen6.setIkkatuoutputkahikbn(C_KahiKbn.KA);
        bizDomManager.insert(tyouhyouOutputKengen6);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllTyouhyouOutputKengen());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<BT_TyouhyouOutputKengen> tyouhyouOutputKengenLst = bizDomManager.getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(dSyukouteikanriid2, C_KahiKbn.KA);

        assertEquals(0, tyouhyouOutputKengenLst.size());

    }

    @Test
    @TestOrder(20)
    public void normal1(){

        List<BT_TyouhyouOutputKengen> tyouhyouOutputKengenLst = bizDomManager.getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(dSyukouteikanriid3, C_KahiKbn.KA);

        assertEquals(1, tyouhyouOutputKengenLst.size());
        assertEquals("sk01", tyouhyouOutputKengenLst.get(0).getRoleCd());
        assertEquals(C_SyoruiCdKbn.CM_JIMURENRAKUHYOU, tyouhyouOutputKengenLst.get(0).getSyoruiCd());
        assertEquals(C_KahiKbn.KA, tyouhyouOutputKengenLst.get(0).getIkkatuoutputkahikbn());
    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<BT_TyouhyouOutputKengen> tyouhyouOutputKengenLst = bizDomManager.getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(dSyukouteikanriid1, C_KahiKbn.KA);

        assertEquals(3, tyouhyouOutputKengenLst.size());
        Map<String,String> map = new HashMap<String,String>();
        map.put($("sk03",C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI,C_KahiKbn.KA), "1");
        map.put($("sk04",C_SyoruiCdKbn.CM_BATCH_GKFBFURIKOMIKEI,C_KahiKbn.KA), "1");
        map.put($("sk05",C_SyoruiCdKbn.CM_JIMURENRAKUHYOU,C_KahiKbn.KA), "1");

        for(BT_TyouhyouOutputKengen tyouhyouOutputKengen : tyouhyouOutputKengenLst){
            map.remove($(tyouhyouOutputKengen.getRoleCd(),tyouhyouOutputKengen.getSyoruiCd(),tyouhyouOutputKengen.getIkkatuoutputkahikbn()));
        }
        assertTrue(map.isEmpty());
    }
    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<BT_TyouhyouOutputKengen> tyouhyouOutputKengenLst = bizDomManager.getTyouhyouOutputKengensByRoleCdsIkkatuoutputkahikbn(dSyukouteikanriid4, C_KahiKbn.KA);
        Assert.assertEquals(0, tyouhyouOutputKengenLst.size());
    }
}

