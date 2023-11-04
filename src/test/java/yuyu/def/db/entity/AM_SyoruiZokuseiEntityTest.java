package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 書類属性マスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AM_SyoruiZokuseiEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.BLNK;
        //        C_SyoruiCdKbn pSyoruiCd2 = C_SyoruiCdKbn.KK_HRIHEN_HB;
        //        C_SyoruiCdKbn pSyoruiCd3 = C_SyoruiCdKbn.HK_PM_KTJKSMS;
        //        C_SyoruiCdKbn pSyoruiCd4 = C_SyoruiCdKbn.CM_FBSOUKINMESLIST;
        //        C_SyoruiCdKbn pSyoruiCd5 = C_SyoruiCdKbn.KK_MINYUUITIRAN;

        AM_SyoruiZokusei aM_SyoruiZokusei1 = baseDomManager.getSyoruiZokusei(pSyoruiCd1);
        if ( null == aM_SyoruiZokusei1 ){

            aM_SyoruiZokusei1 = new AM_SyoruiZokusei();
            aM_SyoruiZokusei1.setSyoruiCd(pSyoruiCd1);

            baseDomManager.insert(aM_SyoruiZokusei1);
        }

        /*AM_SyoruiZokusei aM_SyoruiZokusei2 = baseDomManager.getSyoruiZokusei(pSyoruiCd2);
        if ( null == aM_SyoruiZokusei2 ){

            aM_SyoruiZokusei2 = new AM_SyoruiZokusei();
            aM_SyoruiZokusei2.setSyoruiCd(pSyoruiCd2);

            baseDomManager.insert(aM_SyoruiZokusei2);
        }

        AM_SyoruiZokusei aM_SyoruiZokusei3 = baseDomManager.getSyoruiZokusei(pSyoruiCd3);
        if ( null == aM_SyoruiZokusei3 ){

            aM_SyoruiZokusei3 = new AM_SyoruiZokusei();
            aM_SyoruiZokusei3.setSyoruiCd(pSyoruiCd3);

            baseDomManager.insert(aM_SyoruiZokusei3);
        }

        AM_SyoruiZokusei aM_SyoruiZokusei4 = baseDomManager.getSyoruiZokusei(pSyoruiCd4);
        if ( null == aM_SyoruiZokusei4 ){

            aM_SyoruiZokusei4 = new AM_SyoruiZokusei();
            aM_SyoruiZokusei4.setSyoruiCd(pSyoruiCd4);

            baseDomManager.insert(aM_SyoruiZokusei4);
        }

        AM_SyoruiZokusei aM_SyoruiZokusei5 = baseDomManager.getSyoruiZokusei(pSyoruiCd5);
        if ( null == aM_SyoruiZokusei5 ){

            aM_SyoruiZokusei5 = new AM_SyoruiZokusei();
            aM_SyoruiZokusei5.setSyoruiCd(pSyoruiCd5);

            baseDomManager.insert(aM_SyoruiZokusei5);
        }*/
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        C_SyoruiCdKbn pSyoruiCd1 = C_SyoruiCdKbn.BLNK;
        //        C_SyoruiCdKbn pSyoruiCd2 = C_SyoruiCdKbn.KK_HRIHEN_HB;
        //        C_SyoruiCdKbn pSyoruiCd3 = C_SyoruiCdKbn.HK_PM_KTJKSMS;
        //        C_SyoruiCdKbn pSyoruiCd4 = C_SyoruiCdKbn.CM_FBSOUKINMESLIST;
        //        C_SyoruiCdKbn pSyoruiCd5 = C_SyoruiCdKbn.KK_MINYUUITIRAN;

        AM_SyoruiZokusei aM_SyoruiZokusei1 = baseDomManager.getSyoruiZokusei(pSyoruiCd1);
        if ( null != aM_SyoruiZokusei1 ){

            baseDomManager.delete(aM_SyoruiZokusei1);
        }

        /*AM_SyoruiZokusei aM_SyoruiZokusei2 = baseDomManager.getSyoruiZokusei(pSyoruiCd2);
        if ( null != aM_SyoruiZokusei2 ){

            baseDomManager.delete(aM_SyoruiZokusei2);
        }

        AM_SyoruiZokusei aM_SyoruiZokusei3 = baseDomManager.getSyoruiZokusei(pSyoruiCd3);
        if ( null != aM_SyoruiZokusei3 ){

            baseDomManager.delete(aM_SyoruiZokusei3);
        }

        AM_SyoruiZokusei aM_SyoruiZokusei4 = baseDomManager.getSyoruiZokusei(pSyoruiCd4);
        if ( null != aM_SyoruiZokusei4 ){

            baseDomManager.delete(aM_SyoruiZokusei4);
        }

        AM_SyoruiZokusei aM_SyoruiZokusei5 = baseDomManager.getSyoruiZokusei(pSyoruiCd5);
        if ( null != aM_SyoruiZokusei5 ){

            baseDomManager.delete(aM_SyoruiZokusei5);
        }*/
    }

    @Override
    @Test
    @Transactional
    public void getAll() {

        List<AM_SyoruiZokusei> syoruiZokuseiList = baseDomManager.getAllSyoruiZokuseis();

        List<AM_SyoruiZokusei> resultSyoruiZokuseiList = ImmutableList.copyOf(Iterables.filter(syoruiZokuseiList, new Predicate<AM_SyoruiZokusei>() {

            @Override
            public boolean apply(AM_SyoruiZokusei pSyoruiZokuseiEntity) {

                List<C_SyoruiCdKbn> syoruiCdList = new ArrayList<C_SyoruiCdKbn>();
                syoruiCdList.add(C_SyoruiCdKbn.BLNK);
                //                syoruiCdList.add(C_SyoruiCdKbn.KK_HRIHEN_HB);
                //                syoruiCdList.add(C_SyoruiCdKbn.HK_PM_KTJKSMS);
                //                syoruiCdList.add(C_SyoruiCdKbn.CM_FBSOUKINMESLIST);
                //                syoruiCdList.add(C_SyoruiCdKbn.KK_MINYUUITIRAN);

                for (C_SyoruiCdKbn syoruiCd : syoruiCdList) {
                    if (syoruiCd.equals(pSyoruiZokuseiEntity.getSyoruiCd())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultSyoruiZokuseiList.size();
        assertEquals(1, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        C_SyoruiCdKbn pSyoruiCd = C_SyoruiCdKbn.BLNK;
        AM_SyoruiZokusei aM_SyoruiZokusei = baseDomManager.getSyoruiZokusei(pSyoruiCd);

        assertEquals(pSyoruiCd, aM_SyoruiZokusei.getSyoruiCd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
    }

    @Override
    @Test
    public void blankCondition() {

    }

    @Override
    @Test
    public void nullCondition() {
        C_SyoruiCdKbn pSyoruiCd = null;

        try {
            baseDomManager.getSyoruiZokusei(pSyoruiCd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
