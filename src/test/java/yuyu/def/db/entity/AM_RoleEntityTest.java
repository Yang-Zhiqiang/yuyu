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
 * ロールマスタ エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AM_RoleEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pRoleCd1 = "RC0000001";
        String pRoleCd2 = "RC0000002";
        String pRoleCd3 = "RC0000003";
        String pRoleCd4 = "RC0000004";
        String pRoleCd5 = "RC0000005";

        AM_Role aM_Role1 = baseDomManager.getRole(pRoleCd1);
        if (null == aM_Role1) {

            aM_Role1 = new AM_Role();
            aM_Role1.setRoleCd(pRoleCd1);

            baseDomManager.insert(aM_Role1);
        }

        AM_Role aM_Role2 = baseDomManager.getRole(pRoleCd2);
        if (null == aM_Role2) {

            aM_Role2 = new AM_Role();
            aM_Role2.setRoleCd(pRoleCd2);

            baseDomManager.insert(aM_Role2);
        }

        AM_Role aM_Role3 = baseDomManager.getRole(pRoleCd3);
        if (null == aM_Role3) {

            aM_Role3 = new AM_Role();
            aM_Role3.setRoleCd(pRoleCd3);

            baseDomManager.insert(aM_Role3);
        }

        AM_Role aM_Role4 = baseDomManager.getRole(pRoleCd4);
        if (null == aM_Role4) {

            aM_Role4 = new AM_Role();
            aM_Role4.setRoleCd(pRoleCd4);

            baseDomManager.insert(aM_Role4);
        }

        AM_Role aM_Role5 = baseDomManager.getRole(pRoleCd5);
        if (null == aM_Role5) {

            aM_Role5 = new AM_Role();
            aM_Role5.setRoleCd(pRoleCd5);

            baseDomManager.insert(aM_Role5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pRoleCd1 = "RC0000001";
        String pRoleCd2 = "RC0000002";
        String pRoleCd3 = "RC0000003";
        String pRoleCd4 = "RC0000004";
        String pRoleCd5 = "RC0000005";
        AM_Role aM_Role1 = baseDomManager.getRole(pRoleCd1);
        if (null != aM_Role1) {

            baseDomManager.delete(aM_Role1);
        }

        AM_Role aM_Role2 = baseDomManager.getRole(pRoleCd2);
        if (null != aM_Role2) {

            baseDomManager.delete(aM_Role2);
        }

        AM_Role aM_Role3 = baseDomManager.getRole(pRoleCd3);
        if (null != aM_Role3) {

            baseDomManager.delete(aM_Role3);
        }

        AM_Role aM_Role4 = baseDomManager.getRole(pRoleCd4);
        if (null != aM_Role4) {

            baseDomManager.delete(aM_Role4);
        }

        AM_Role aM_Role5 = baseDomManager.getRole(pRoleCd5);
        if (null != aM_Role5) {

            baseDomManager.delete(aM_Role5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AM_Role> roleList = baseDomManager.getAllRoles();

        List<AM_Role> resultRoleList = ImmutableList.copyOf(Iterables.filter(roleList, new Predicate<AM_Role>() {

            @Override
            public boolean apply(AM_Role pRoleEntity) {

                List<String> roleCdList = new ArrayList<String>();
                roleCdList.add("RC0000001");
                roleCdList.add("RC0000002");
                roleCdList.add("RC0000003");
                roleCdList.add("RC0000004");
                roleCdList.add("RC0000005");

                for (String roleCd : roleCdList) {
                    if (roleCd.equals(pRoleEntity.getRoleCd())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultRoleList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pRoleCd = "RC0000001";
        AM_Role aM_Role = baseDomManager.getRole(pRoleCd);
        assertEquals(pRoleCd, aM_Role.getRoleCd());

    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pRoleCd = "RC0000099";
        AM_Role aM_Role = baseDomManager.getRole(pRoleCd);

        assertNull(aM_Role);

    }

    @Override
    @Test
    public void blankCondition() {
        String pRoleCd = "";
        AM_Role aM_Role = baseDomManager.getRole(pRoleCd);

        assertNull(aM_Role);
    }

    @Override
    @Test
    public void nullCondition() {
        String pRoleCd = null;
        try {
            baseDomManager.getRole(pRoleCd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
