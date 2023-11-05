package yuyu.def.base.manager;

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

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_TyouhyouSakujyotaisyo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BaseDomManagerクラスの、<br />
 * getTyouhyouSakujyotaisyosByHozonKikanOut() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BaseDomManagerTest_getTyouhyouSakujyotaisyosByHozonKikanOut {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<AS_TyouhyouSakujyotaisyo> tYouhyouSakujyotaisyoLst = baseDomManager.getTyouhyouSakujyotaisyosByHozonKikanOut(Integer.valueOf(2));

        Assert.assertEquals(0, tYouhyouSakujyotaisyoLst.size());

        AS_TyouhyouSakujyotaisyo tyouhyouSakujyotaisyo1 = new AS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn.KK_SYOSAIHK_HB);
        tyouhyouSakujyotaisyo1.setHozonKikan(3);

        baseDomManager.insert(tyouhyouSakujyotaisyo1);

        AS_TyouhyouSakujyotaisyo tyouhyouSakujyotaisyo2 = new AS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn.KK_KYKTORIKESI_HB);
        tyouhyouSakujyotaisyo2.setHozonKikan(3);

        baseDomManager.insert(tyouhyouSakujyotaisyo2);

        AS_TyouhyouSakujyotaisyo tyouhyouSakujyotaisyo3 = new AS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn.KK_CLGOFF_HB);
        tyouhyouSakujyotaisyo3.setHozonKikan(3);

        baseDomManager.insert(tyouhyouSakujyotaisyo3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getAllTyouhyouSakujyotaisyo());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1(){

        List<AS_TyouhyouSakujyotaisyo> tYouhyouSakujyotaisyoLst = baseDomManager.getTyouhyouSakujyotaisyosByHozonKikanOut(Integer.valueOf(3));

        Assert.assertEquals(0, tYouhyouSakujyotaisyoLst.size());

        baseDomManager.delete(baseDomManager.getAllTyouhyouSakujyotaisyo());

        AS_TyouhyouSakujyotaisyo tyouhyouSakujyotaisyo1 = new AS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn.KK_SYOSAIHK_HB );
        tyouhyouSakujyotaisyo1.setHozonKikan(1);

        baseDomManager.insert(tyouhyouSakujyotaisyo1);

        AS_TyouhyouSakujyotaisyo tyouhyouSakujyotaisyo2 = new AS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn.KK_KYKTORIKESI_HB);
        tyouhyouSakujyotaisyo2.setHozonKikan(2);

        baseDomManager.insert(tyouhyouSakujyotaisyo2);

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1(){

        List<AS_TyouhyouSakujyotaisyo> tYouhyouSakujyotaisyoLst = baseDomManager.getTyouhyouSakujyotaisyosByHozonKikanOut(Integer.valueOf(2));

        Assert.assertEquals(1, tYouhyouSakujyotaisyoLst.size());
        Assert.assertEquals(C_SyoruiCdKbn.KK_SYOSAIHK_HB , tYouhyouSakujyotaisyoLst.get(0).getSyoruiCd());
        Assert.assertEquals(Integer.valueOf(1), tYouhyouSakujyotaisyoLst.get(0).getHozonKikan());

        baseDomManager.delete(baseDomManager.getAllTyouhyouSakujyotaisyo());

        AS_TyouhyouSakujyotaisyo tyouhyouSakujyotaisyo1 = new AS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn.KK_SYOSAIHK_HB);
        tyouhyouSakujyotaisyo1.setHozonKikan(3);

        baseDomManager.insert(tyouhyouSakujyotaisyo1);

        AS_TyouhyouSakujyotaisyo tyouhyouSakujyotaisyo2 = new AS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn.KK_KYKTORIKESI_HB);
        tyouhyouSakujyotaisyo2.setHozonKikan(2);

        baseDomManager.insert(tyouhyouSakujyotaisyo2);

        AS_TyouhyouSakujyotaisyo tyouhyouSakujyotaisyo3 = new AS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn.KK_CLGOFF_HB);
        tyouhyouSakujyotaisyo3.setHozonKikan(1);

        baseDomManager.insert(tyouhyouSakujyotaisyo3);
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        Map<String,String> tYouhyouSakujyotaisyoMap = new HashMap<String,String>();
        tYouhyouSakujyotaisyoMap.put($(C_SyoruiCdKbn.KK_SYOSAIHK_HB, 3), "1");
        tYouhyouSakujyotaisyoMap.put($(C_SyoruiCdKbn.KK_KYKTORIKESI_HB, 2), "1");
        tYouhyouSakujyotaisyoMap.put($(C_SyoruiCdKbn.KK_CLGOFF_HB, 1), "1");

        List<AS_TyouhyouSakujyotaisyo> tYouhyouSakujyotaisyoLst = baseDomManager.getTyouhyouSakujyotaisyosByHozonKikanOut(Integer.valueOf(4));

        Assert.assertEquals(3, tYouhyouSakujyotaisyoLst.size());

        tYouhyouSakujyotaisyoMap.remove($(tYouhyouSakujyotaisyoLst.get(0).getSyoruiCd(), tYouhyouSakujyotaisyoLst.get(0).getHozonKikan()));

        tYouhyouSakujyotaisyoMap.remove($(tYouhyouSakujyotaisyoLst.get(1).getSyoruiCd(), tYouhyouSakujyotaisyoLst.get(1).getHozonKikan()));

        tYouhyouSakujyotaisyoMap.remove($(tYouhyouSakujyotaisyoLst.get(2).getSyoruiCd(), tYouhyouSakujyotaisyoLst.get(2).getHozonKikan()));

        assertTrue(tYouhyouSakujyotaisyoMap.isEmpty());
    }

}
