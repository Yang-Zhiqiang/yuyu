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
 * サブシステム基幹テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_SubSystemEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pSubSystemId1 = "SSI0000001";
        String pSubSystemId2 = "SSI0000002";
        String pSubSystemId3 = "SSI0000003";
        String pSubSystemId4 = "SSI0000004";
        String pSubSystemId5 = "SSI0000005";

        AS_SubSystem aS_SubSystem1 = baseDomManager.getSubSystem(pSubSystemId1);
        if ( null == aS_SubSystem1 ){

            aS_SubSystem1 = new AS_SubSystem();
            aS_SubSystem1.setSubSystemId(pSubSystemId1);

            baseDomManager.insert(aS_SubSystem1);
        }

        AS_SubSystem aS_SubSystem2 = baseDomManager.getSubSystem(pSubSystemId2);
        if ( null == aS_SubSystem2 ){

            aS_SubSystem2 = new AS_SubSystem();
            aS_SubSystem2.setSubSystemId(pSubSystemId2);

            baseDomManager.insert(aS_SubSystem2);
        }

        AS_SubSystem aS_SubSystem3 = baseDomManager.getSubSystem(pSubSystemId3);
        if ( null == aS_SubSystem3 ){

            aS_SubSystem3 = new AS_SubSystem();
            aS_SubSystem3.setSubSystemId(pSubSystemId3);

            baseDomManager.insert(aS_SubSystem3);
        }

        AS_SubSystem aS_SubSystem4 = baseDomManager.getSubSystem(pSubSystemId4);
        if ( null == aS_SubSystem4 ){

            aS_SubSystem4 = new AS_SubSystem();
            aS_SubSystem4.setSubSystemId(pSubSystemId4);

            baseDomManager.insert(aS_SubSystem4);
        }

        AS_SubSystem aS_SubSystem5 = baseDomManager.getSubSystem(pSubSystemId5);
        if ( null == aS_SubSystem5 ){

            aS_SubSystem5 = new AS_SubSystem();
            aS_SubSystem5.setSubSystemId(pSubSystemId5);

            baseDomManager.insert(aS_SubSystem5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pSubSystemId1 = "SSI0000001";
        String pSubSystemId2 = "SSI0000002";
        String pSubSystemId3 = "SSI0000003";
        String pSubSystemId4 = "SSI0000004";
        String pSubSystemId5 = "SSI0000005";

        AS_SubSystem aS_SubSystem1 = baseDomManager.getSubSystem(pSubSystemId1);
        if (null != aS_SubSystem1) {

            baseDomManager.delete(aS_SubSystem1);
        }

        AS_SubSystem aS_SubSystem2 = baseDomManager.getSubSystem(pSubSystemId2);
        if (null != aS_SubSystem2) {

            baseDomManager.delete(aS_SubSystem2);
        }

        AS_SubSystem aS_SubSystem3 = baseDomManager.getSubSystem(pSubSystemId3);
        if (null != aS_SubSystem3) {

            baseDomManager.delete(aS_SubSystem3);
        }

        AS_SubSystem aS_SubSystem4 = baseDomManager.getSubSystem(pSubSystemId4);
        if (null != aS_SubSystem4) {

            baseDomManager.delete(aS_SubSystem4);
        }

        AS_SubSystem aS_SubSystem5 = baseDomManager.getSubSystem(pSubSystemId5);
        if (null != aS_SubSystem5) {

            baseDomManager.delete(aS_SubSystem5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AS_SubSystem> subSystemList = baseDomManager.getAllSubSystems();

        List<AS_SubSystem> resultSubSystemList = ImmutableList.copyOf(Iterables.filter(subSystemList, new Predicate<AS_SubSystem>() {

            @Override
            public boolean apply(AS_SubSystem pSubSystemEntity) {

                List<String> subSystemIdList = new ArrayList<String>();
                subSystemIdList.add("SSI0000001");
                subSystemIdList.add("SSI0000002");
                subSystemIdList.add("SSI0000003");
                subSystemIdList.add("SSI0000004");
                subSystemIdList.add("SSI0000005");

                for (String subSystemId : subSystemIdList) {
                    if (subSystemId.equals(pSubSystemEntity.getSubSystemId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultSubSystemList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pSubSystemId = "SSI0000001";
        AS_SubSystem aS_SubSystem = baseDomManager.getSubSystem(pSubSystemId);

        assertEquals(pSubSystemId, aS_SubSystem.getSubSystemId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pSubSystemId = "SSI0000099";
        AS_SubSystem aS_SubSystem = baseDomManager.getSubSystem(pSubSystemId);

        assertNull(aS_SubSystem);

    }

    @Override
    @Test
    public void blankCondition() {
        String pSubSystemId = "";
        AS_SubSystem aS_SubSystem = baseDomManager.getSubSystem(pSubSystemId);

        assertNull(aS_SubSystem);
    }

    @Override
    @Test
    public void nullCondition() {
        String pSubSystemId = null;
        try {
            baseDomManager.getSubSystem(pSubSystemId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
