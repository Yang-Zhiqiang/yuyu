package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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

/**
 * 連番値管理 エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_SequenceValueEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pId = "ID00000001";
        String pName = "NM00000001";
        long pStartWith = 1;
        int pIncrease = 1;
        long pMaxValue = 100;
        int pCacheSize = 100;
        C_UmuKbn pPadding = C_UmuKbn.NONE;
        int pLength = 5;

        AS_Sequence aS_Sequence = baseDomManager.getSequence(pId);
        if ( null == aS_Sequence ){
            aS_Sequence = new AS_Sequence();
            aS_Sequence.setId(pId);
            aS_Sequence.setName(pName);
            aS_Sequence.setStartWith(pStartWith);
            aS_Sequence.setIncrease(pIncrease);
            aS_Sequence.setMaxValue(pMaxValue);
            aS_Sequence.setCacheSize(pCacheSize);
            aS_Sequence.setPadding(pPadding);
            aS_Sequence.setLength(pLength);

            baseDomManager.insert(aS_Sequence);
        }

        String pKeys1 = "K000000001";
        String pKeys2 = "K000000002";
        String pKeys3 = "K000000003";
        String pKeys4 = "K000000004";
        String pKeys5 = "K000000005";
        long pCurrentValue1 = 1;
        long pCurrentValue2 = 2;
        long pCurrentValue3 = 3;
        long pCurrentValue4 = 4;
        long pCurrentValue5 = 5;

        AT_SequenceValue aT_SequenceValue1 = baseDomManager.getSequenceValueByIdKeys(pId, pKeys1);
        if ( null == aT_SequenceValue1 ) {

            aT_SequenceValue1 = aS_Sequence.createSequenceValue();
            aT_SequenceValue1.setKeys(pKeys1);
            aT_SequenceValue1.setCurrentValue(pCurrentValue1);

        }

        AT_SequenceValue aT_SequenceValue2 = baseDomManager.getSequenceValueByIdKeys(pId, pKeys2);
        if ( null == aT_SequenceValue2 ) {

            aT_SequenceValue2 = aS_Sequence.createSequenceValue();
            aT_SequenceValue2.setKeys(pKeys2);
            aT_SequenceValue2.setCurrentValue(pCurrentValue2);

        }

        AT_SequenceValue aT_SequenceValue3 = baseDomManager.getSequenceValueByIdKeys(pId, pKeys3);
        if ( null == aT_SequenceValue3 ) {

            aT_SequenceValue3 = aS_Sequence.createSequenceValue();
            aT_SequenceValue3.setKeys(pKeys3);
            aT_SequenceValue3.setCurrentValue(pCurrentValue3);

        }

        AT_SequenceValue aT_SequenceValue4 = baseDomManager.getSequenceValueByIdKeys(pId, pKeys4);
        if ( null == aT_SequenceValue4 ) {

            aT_SequenceValue4 = aS_Sequence.createSequenceValue();
            aT_SequenceValue4.setKeys(pKeys4);
            aT_SequenceValue4.setCurrentValue(pCurrentValue4);

        }

        AT_SequenceValue aT_SequenceValue5 = baseDomManager.getSequenceValueByIdKeys(pId, pKeys5);
        if ( null == aT_SequenceValue5 ) {

            aT_SequenceValue5 = aS_Sequence.createSequenceValue();
            aT_SequenceValue5.setKeys(pKeys5);
            aT_SequenceValue5.setCurrentValue(pCurrentValue5);

        }

        baseDomManager.update(aS_Sequence);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pId = "ID00000001";
        AS_Sequence aS_Sequence = baseDomManager.getSequence(pId);
        if ( null != aS_Sequence ) {

            aS_Sequence.getSequenceValues().removeAll(aS_Sequence.getSequenceValues());

            baseDomManager.update(aS_Sequence);
            baseDomManager.delete(aS_Sequence);
        }
    }

    @Override
    @Test
    @Transactional
    public void getAll() {
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pId = "ID00000001";
        String pKeys = "K000000001";
        AT_SequenceValue aT_SequenceValue = baseDomManager.getSequenceValueByIdKeys(pId, pKeys);

        assertEquals(pId, aT_SequenceValue.getId());
        assertEquals(pKeys, aT_SequenceValue.getKeys());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pId = "ID00000099";
        String pKeys = "K000000099";
        AT_SequenceValue aT_SequenceValue = baseDomManager.getSequenceValueByIdKeys(pId, pKeys);

        assertNull(aT_SequenceValue);
    }

    @Override
    @Test
    public void blankCondition() {
        String pId = "";
        String pKeys = "";
        AT_SequenceValue aT_SequenceValue = baseDomManager.getSequenceValueByIdKeys(pId, pKeys);

        assertNull(aT_SequenceValue);
    }

    @Override
    @Test
    public void nullCondition() {
        String pId = null;
        String pKeys = null;
        try {
            baseDomManager.getSequenceValueByIdKeys(pId, pKeys);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }

    }
}
