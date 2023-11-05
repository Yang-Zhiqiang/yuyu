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
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * バッチ日付テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_BatchDateEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        BizDate pBatchExecDate1 = BizDate.valueOf("20150309");
        BizDate pBatchExecDate2 = BizDate.valueOf("20150409");
        BizDate pBatchExecDate3 = BizDate.valueOf("20150509");
        BizDate pBatchExecDate4 = BizDate.valueOf("20150609");
        BizDate pBatchExecDate5 = BizDate.valueOf("20150709");

        AT_BatchDate aT_BatchDate1 = baseDomManager.getBatchDateByDate(pBatchExecDate1);
        if ( null == aT_BatchDate1 ) {

            aT_BatchDate1 = new AT_BatchDate();
            aT_BatchDate1.setBatchExecDate(pBatchExecDate1);

            baseDomManager.insert(aT_BatchDate1);
        }

        AT_BatchDate aT_BatchDate2 = baseDomManager.getBatchDateByDate(pBatchExecDate2);
        if ( null == aT_BatchDate2 ) {

            aT_BatchDate2 = new AT_BatchDate();
            aT_BatchDate2.setBatchExecDate(pBatchExecDate2);

            baseDomManager.insert(aT_BatchDate2);
        }

        AT_BatchDate aT_BatchDate3 = baseDomManager.getBatchDateByDate(pBatchExecDate3);
        if ( null == aT_BatchDate3 ) {

            aT_BatchDate3 = new AT_BatchDate();
            aT_BatchDate3.setBatchExecDate(pBatchExecDate3);

            baseDomManager.insert(aT_BatchDate3);
        }

        AT_BatchDate aT_BatchDate4 = baseDomManager.getBatchDateByDate(pBatchExecDate4);
        if ( null == aT_BatchDate4 ) {

            aT_BatchDate4 = new AT_BatchDate();
            aT_BatchDate4.setBatchExecDate(pBatchExecDate4);

            baseDomManager.insert(aT_BatchDate4);
        }

        AT_BatchDate aT_BatchDate5 = baseDomManager.getBatchDateByDate(pBatchExecDate5);
        if ( null == aT_BatchDate5 ) {

            aT_BatchDate5 = new AT_BatchDate();
            aT_BatchDate5.setBatchExecDate(pBatchExecDate5);

            baseDomManager.insert(aT_BatchDate5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        BizDate pBatchExecDate1 = BizDate.valueOf("20150309");
        BizDate pBatchExecDate2 = BizDate.valueOf("20150409");
        BizDate pBatchExecDate3 = BizDate.valueOf("20150509");
        BizDate pBatchExecDate4 = BizDate.valueOf("20150609");
        BizDate pBatchExecDate5 = BizDate.valueOf("20150709");

        AT_BatchDate aT_BatchDate1 = baseDomManager.getBatchDateByDate(pBatchExecDate1);
        if ( null != aT_BatchDate1 ) {

            baseDomManager.delete(aT_BatchDate1);
        }

        AT_BatchDate aT_BatchDate2 = baseDomManager.getBatchDateByDate(pBatchExecDate2);
        if ( null != aT_BatchDate2 ) {

            baseDomManager.delete(aT_BatchDate2);
        }

        AT_BatchDate aT_BatchDate3 = baseDomManager.getBatchDateByDate(pBatchExecDate3);
        if ( null != aT_BatchDate3 ) {

            baseDomManager.delete(aT_BatchDate3);
        }

        AT_BatchDate aT_BatchDate4 = baseDomManager.getBatchDateByDate(pBatchExecDate4);
        if ( null != aT_BatchDate4 ) {

            baseDomManager.delete(aT_BatchDate4);
        }

        AT_BatchDate aT_BatchDate5 = baseDomManager.getBatchDateByDate(pBatchExecDate5);
        if ( null != aT_BatchDate5 ) {

            baseDomManager.delete(aT_BatchDate5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AT_BatchDate> batchDateList = baseDomManager.getAT_BatchDateAll();

        List<AT_BatchDate> resultBatchDateList = ImmutableList.copyOf(Iterables.filter(batchDateList, new Predicate<AT_BatchDate>() {

            @Override
            public boolean apply(AT_BatchDate pBatchDateEntity) {

                List<BizDate> pBatchExecDateList = new ArrayList<BizDate>();
                pBatchExecDateList.add(BizDate.valueOf("20150309"));
                pBatchExecDateList.add(BizDate.valueOf("20150409"));
                pBatchExecDateList.add(BizDate.valueOf("20150509"));
                pBatchExecDateList.add(BizDate.valueOf("20150609"));
                pBatchExecDateList.add(BizDate.valueOf("20150709"));

                for (BizDate batchExecDate : pBatchExecDateList) {
                    if (batchExecDate.equals(pBatchDateEntity.getBatchExecDate())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultBatchDateList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        BizDate pBatchExecDate = BizDate.valueOf("20150309");
        AT_BatchDate aT_BatchDate = baseDomManager.getBatchDateByDate(pBatchExecDate);

        assertEquals(pBatchExecDate, aT_BatchDate.getBatchExecDate());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        BizDate pBatchExecDate = BizDate.valueOf("20991231");
        AT_BatchDate aT_BatchDate = baseDomManager.getBatchDateByDate(pBatchExecDate);

        assertNull(aT_BatchDate);
    }

    @Override
    @Test
    public void blankCondition() {
    }

    @Override
    @Test
    public void nullCondition() {
        try {
            baseDomManager.getBatchDateByDate(null);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
