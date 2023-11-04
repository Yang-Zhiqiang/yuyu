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
import yuyu.def.classification.C_UmuKbn;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 連番管理基幹テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_SequenceEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pId1 = "ID00000001";
        String pId2 = "ID00000002";
        String pId3 = "ID00000003";
        String pId4 = "ID00000004";
        String pId5 = "ID00000005";
        String pName1 = "NM00000001";
        String pName2 = "NM00000002";
        String pName3 = "NM00000003";
        String pName4 = "NM00000004";
        String pName5 = "NM00000005";
        long pStartWith1 = 1;
        long pStartWith2 = 1;
        long pStartWith3 = 1;
        long pStartWith4 = 1;
        long pStartWith5 = 1;
        int pIncrease1 = 1;
        int pIncrease2 = 1;
        int pIncrease3 = 1;
        int pIncrease4 = 1;
        int pIncrease5 = 1;
        long pMaxValue1 = 100;
        long pMaxValue2 = 100;
        long pMaxValue3 = 100;
        long pMaxValue4 = 100;
        long pMaxValue5 = 100;
        int pCacheSize1 = 100;
        int pCacheSize2 = 100;
        int pCacheSize3 = 100;
        int pCacheSize4 = 100;
        int pCacheSize5 = 100;
        C_UmuKbn pPadding1 = C_UmuKbn.NONE;
        C_UmuKbn pPadding2 = C_UmuKbn.NONE;
        C_UmuKbn pPadding3 = C_UmuKbn.NONE;
        C_UmuKbn pPadding4 = C_UmuKbn.NONE;
        C_UmuKbn pPadding5 = C_UmuKbn.NONE;
        int pLength1 = 5;
        int pLength2 = 5;
        int pLength3 = 5;
        int pLength4 = 5;
        int pLength5 = 5;

        AS_Sequence aS_Sequence1 = baseDomManager.getSequence(pId1);
        if ( null == aS_Sequence1 ){
            aS_Sequence1 = new AS_Sequence();
            aS_Sequence1.setId(pId1);
            aS_Sequence1.setName(pName1);
            aS_Sequence1.setStartWith(pStartWith1);
            aS_Sequence1.setIncrease(pIncrease1);
            aS_Sequence1.setMaxValue(pMaxValue1);
            aS_Sequence1.setCacheSize(pCacheSize1);
            aS_Sequence1.setPadding(pPadding1);
            aS_Sequence1.setLength(pLength1);

            baseDomManager.insert(aS_Sequence1);
        }

        AS_Sequence aS_Sequence2 = baseDomManager.getSequence(pId2);
        if ( null == aS_Sequence2 ){
            aS_Sequence2 = new AS_Sequence();
            aS_Sequence2.setId(pId2);
            aS_Sequence2.setName(pName2);
            aS_Sequence2.setStartWith(pStartWith2);
            aS_Sequence2.setIncrease(pIncrease2);
            aS_Sequence2.setMaxValue(pMaxValue2);
            aS_Sequence2.setCacheSize(pCacheSize2);
            aS_Sequence2.setPadding(pPadding2);
            aS_Sequence2.setLength(pLength2);

            baseDomManager.insert(aS_Sequence2);
        }

        AS_Sequence aS_Sequence3 = baseDomManager.getSequence(pId3);
        if ( null == aS_Sequence3 ){
            aS_Sequence3 = new AS_Sequence();
            aS_Sequence3.setId(pId3);
            aS_Sequence3.setName(pName3);
            aS_Sequence3.setStartWith(pStartWith3);
            aS_Sequence3.setIncrease(pIncrease3);
            aS_Sequence3.setMaxValue(pMaxValue3);
            aS_Sequence3.setCacheSize(pCacheSize3);
            aS_Sequence3.setPadding(pPadding3);
            aS_Sequence3.setLength(pLength3);

            baseDomManager.insert(aS_Sequence3);
        }

        AS_Sequence aS_Sequence4 = baseDomManager.getSequence(pId4);
        if ( null == aS_Sequence4 ){
            aS_Sequence4 = new AS_Sequence();
            aS_Sequence4.setId(pId4);
            aS_Sequence4.setName(pName4);
            aS_Sequence4.setStartWith(pStartWith4);
            aS_Sequence4.setIncrease(pIncrease4);
            aS_Sequence4.setMaxValue(pMaxValue4);
            aS_Sequence4.setCacheSize(pCacheSize4);
            aS_Sequence4.setPadding(pPadding4);
            aS_Sequence4.setLength(pLength4);

            baseDomManager.insert(aS_Sequence4);
        }

        AS_Sequence aS_Sequence5 = baseDomManager.getSequence(pId5);
        if ( null == aS_Sequence5 ){
            aS_Sequence5 = new AS_Sequence();
            aS_Sequence5.setId(pId5);
            aS_Sequence5.setName(pName5);
            aS_Sequence5.setStartWith(pStartWith5);
            aS_Sequence5.setIncrease(pIncrease5);
            aS_Sequence5.setMaxValue(pMaxValue5);
            aS_Sequence5.setCacheSize(pCacheSize5);
            aS_Sequence5.setPadding(pPadding5);
            aS_Sequence5.setLength(pLength5);

            baseDomManager.insert(aS_Sequence5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pId1 = "ID00000001";
        String pId2 = "ID00000002";
        String pId3 = "ID00000003";
        String pId4 = "ID00000004";
        String pId5 = "ID00000005";

        AS_Sequence aS_Sequence1 = baseDomManager.getSequence(pId1);
        if ( null != aS_Sequence1 ){

            baseDomManager.delete(aS_Sequence1);
        }

        AS_Sequence aS_Sequence2 = baseDomManager.getSequence(pId2);
        if ( null != aS_Sequence2 ){

            baseDomManager.delete(aS_Sequence2);
        }

        AS_Sequence aS_Sequence3 = baseDomManager.getSequence(pId3);
        if ( null != aS_Sequence3 ){

            baseDomManager.delete(aS_Sequence3);
        }

        AS_Sequence aS_Sequence4 = baseDomManager.getSequence(pId4);
        if ( null != aS_Sequence4 ){

            baseDomManager.delete(aS_Sequence4);
        }

        AS_Sequence aS_Sequence5 = baseDomManager.getSequence(pId5);
        if ( null != aS_Sequence5 ){

            baseDomManager.delete(aS_Sequence5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AS_Sequence> sequenceList = baseDomManager.getAllSequences();

        List<AS_Sequence> resultSequenceList = ImmutableList.copyOf(Iterables.filter(sequenceList, new Predicate<AS_Sequence>() {

            @Override
            public boolean apply(AS_Sequence pSequenceEntity) {

                List<String> sequenceIdList = new ArrayList<String>();
                sequenceIdList.add("ID00000001");
                sequenceIdList.add("ID00000002");
                sequenceIdList.add("ID00000003");
                sequenceIdList.add("ID00000004");
                sequenceIdList.add("ID00000005");

                for (String Id : sequenceIdList) {
                    if (Id.equals(pSequenceEntity.getId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultSequenceList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pId = "ID00000001";
        AS_Sequence aS_Sequence = baseDomManager.getSequence(pId);

        assertEquals(pId, aS_Sequence.getId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pId = "ID00000099";
        AS_Sequence aS_Sequence = baseDomManager.getSequence(pId);

        assertNull(aS_Sequence);
    }

    @Override
    @Test
    public void blankCondition() {
        String pId = "";
        AS_Sequence aS_Sequence = baseDomManager.getSequence(pId);

        assertNull(aS_Sequence);
    }

    @Override
    @Test
    public void nullCondition() {
        String pId = null;
        try {
            baseDomManager.getSequence(pId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
