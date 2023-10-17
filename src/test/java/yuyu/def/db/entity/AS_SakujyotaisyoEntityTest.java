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

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 削除対象基幹テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_SakujyotaisyoEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pSakujyoTableId1 = "STI0000001";
        String pSakujyoTableId2 = "STI0000002";
        String pSakujyoTableId3 = "STI0000003";
        String pSakujyoTableId4 = "STI0000004";
        String pSakujyoTableId5 = "STI0000005";

        AS_Sakujyotaisyo aS_Sakujyotaisyo1 = baseDomManager.getSakujyotaisyo(pSakujyoTableId1);
        if (null == aS_Sakujyotaisyo1) {

            aS_Sakujyotaisyo1 = new AS_Sakujyotaisyo(pSakujyoTableId1);

            baseDomManager.insert(aS_Sakujyotaisyo1);
        }

        AS_Sakujyotaisyo aS_Sakujyotaisyo2 = baseDomManager.getSakujyotaisyo(pSakujyoTableId2);
        if (null == aS_Sakujyotaisyo2) {

            aS_Sakujyotaisyo2 = new AS_Sakujyotaisyo(pSakujyoTableId2);

            baseDomManager.insert(aS_Sakujyotaisyo2);
        }

        AS_Sakujyotaisyo aS_Sakujyotaisyo3 = baseDomManager.getSakujyotaisyo(pSakujyoTableId3);
        if (null == aS_Sakujyotaisyo3) {

            aS_Sakujyotaisyo3 = new AS_Sakujyotaisyo(pSakujyoTableId3);

            baseDomManager.insert(aS_Sakujyotaisyo3);
        }

        AS_Sakujyotaisyo aS_Sakujyotaisyo4 = baseDomManager.getSakujyotaisyo(pSakujyoTableId4);
        if (null == aS_Sakujyotaisyo4) {

            aS_Sakujyotaisyo4 = new AS_Sakujyotaisyo(pSakujyoTableId4);

            baseDomManager.insert(aS_Sakujyotaisyo4);
        }

        AS_Sakujyotaisyo aS_Sakujyotaisyo5 = baseDomManager.getSakujyotaisyo(pSakujyoTableId5);
        if (null == aS_Sakujyotaisyo5) {

            aS_Sakujyotaisyo5 = new AS_Sakujyotaisyo(pSakujyoTableId5);

            baseDomManager.insert(aS_Sakujyotaisyo5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pSakujyoTableId1 = "STI0000001";
        String pSakujyoTableId2 = "STI0000002";
        String pSakujyoTableId3 = "STI0000003";
        String pSakujyoTableId4 = "STI0000004";
        String pSakujyoTableId5 = "STI0000005";

        AS_Sakujyotaisyo aS_Sakujyotaisyo1 = baseDomManager.getSakujyotaisyo(pSakujyoTableId1);
        if (null != aS_Sakujyotaisyo1) {

            baseDomManager.delete(aS_Sakujyotaisyo1);
        }

        AS_Sakujyotaisyo aS_Sakujyotaisyo2 = baseDomManager.getSakujyotaisyo(pSakujyoTableId2);
        if (null != aS_Sakujyotaisyo2) {

            baseDomManager.delete(aS_Sakujyotaisyo2);
        }

        AS_Sakujyotaisyo aS_Sakujyotaisyo3 = baseDomManager.getSakujyotaisyo(pSakujyoTableId3);
        if (null != aS_Sakujyotaisyo3) {

            baseDomManager.delete(aS_Sakujyotaisyo3);
        }

        AS_Sakujyotaisyo aS_Sakujyotaisyo4 = baseDomManager.getSakujyotaisyo(pSakujyoTableId4);
        if (null != aS_Sakujyotaisyo4) {

            baseDomManager.delete(aS_Sakujyotaisyo4);
        }

        AS_Sakujyotaisyo aS_Sakujyotaisyo5 = baseDomManager.getSakujyotaisyo(pSakujyoTableId5);
        if (null != aS_Sakujyotaisyo5) {

            baseDomManager.delete(aS_Sakujyotaisyo5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AS_Sakujyotaisyo> sakujyotaisyoList = baseDomManager.getAllSakujyotaisyos();

        List<AS_Sakujyotaisyo> resultSakujyotaisyoList = ImmutableList.copyOf(Iterables.filter(sakujyotaisyoList, new Predicate<AS_Sakujyotaisyo>() {

            @Override
            public boolean apply(AS_Sakujyotaisyo pSakujyotaisyoEntity) {

                List<String> sakujyotaisyoIdList = new ArrayList<String>();
                sakujyotaisyoIdList.add("STI0000001");
                sakujyotaisyoIdList.add("STI0000002");
                sakujyotaisyoIdList.add("STI0000003");
                sakujyotaisyoIdList.add("STI0000004");
                sakujyotaisyoIdList.add("STI0000005");

                for (String sakujyoTableId : sakujyotaisyoIdList) {
                    if (sakujyoTableId.equals(pSakujyotaisyoEntity.getSakujyoTableId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultSakujyotaisyoList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pSakujyoTableId = "STI0000001";
        AS_Sakujyotaisyo aS_Sakujyotaisyo = baseDomManager.getSakujyotaisyo(pSakujyoTableId);

        assertEquals(pSakujyoTableId, aS_Sakujyotaisyo.getSakujyoTableId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pSakujyoTableId = "STI0000099";
        AS_Sakujyotaisyo aS_Sakujyotaisyo = baseDomManager.getSakujyotaisyo(pSakujyoTableId);

        assertNull(aS_Sakujyotaisyo);
    }

    @Override
    @Test
    public void blankCondition() {
        String pSakujyoTableId = "";
        AS_Sakujyotaisyo aS_Sakujyotaisyo = baseDomManager.getSakujyotaisyo(pSakujyoTableId);

        assertNull(aS_Sakujyotaisyo);
    }

    @Override
    @Test
    public void nullCondition() {
        String pSakujyoTableId = null;
        try {
            baseDomManager.getSakujyotaisyo(pSakujyoTableId);
        } catch (Exception e){
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
