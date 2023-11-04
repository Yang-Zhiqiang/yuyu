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
 * 稼働時間グループテーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_KadouTimeGroupEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKadouTimeGroupCd1 = "KGC0000001";
        String pKadouTimeGroupCd2 = "KGC0000002";
        String pKadouTimeGroupCd3 = "KGC0000003";
        String pKadouTimeGroupCd4 = "KGC0000004";
        String pKadouTimeGroupCd5 = "KGC0000005";

        AT_KadouTimeGroup aT_KadouTimeGroup1 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd1);
        if ( null == aT_KadouTimeGroup1 ){

            aT_KadouTimeGroup1 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup1.setKadouTimeGroupCd(pKadouTimeGroupCd1);

            baseDomManager.insert(aT_KadouTimeGroup1);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup2 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd2);
        if ( null == aT_KadouTimeGroup2 ){

            aT_KadouTimeGroup2 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup2.setKadouTimeGroupCd(pKadouTimeGroupCd2);

            baseDomManager.insert(aT_KadouTimeGroup2);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup3 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd3);
        if ( null == aT_KadouTimeGroup3 ){

            aT_KadouTimeGroup3 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup3.setKadouTimeGroupCd(pKadouTimeGroupCd3);

            baseDomManager.insert(aT_KadouTimeGroup3);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup4 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd4);
        if ( null == aT_KadouTimeGroup4 ){

            aT_KadouTimeGroup4 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup4.setKadouTimeGroupCd(pKadouTimeGroupCd4);

            baseDomManager.insert(aT_KadouTimeGroup4);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup5 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd5);
        if ( null == aT_KadouTimeGroup5 ){

            aT_KadouTimeGroup5 = new AT_KadouTimeGroup();
            aT_KadouTimeGroup5.setKadouTimeGroupCd(pKadouTimeGroupCd5);

            baseDomManager.insert(aT_KadouTimeGroup5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKadouTimeGroupCd1 = "KGC0000001";
        String pKadouTimeGroupCd2 = "KGC0000002";
        String pKadouTimeGroupCd3 = "KGC0000003";
        String pKadouTimeGroupCd4 = "KGC0000004";
        String pKadouTimeGroupCd5 = "KGC0000005";

        AT_KadouTimeGroup aT_KadouTimeGroup1 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd1);
        if ( null != aT_KadouTimeGroup1 ){

            baseDomManager.delete(aT_KadouTimeGroup1);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup2 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd2);
        if ( null != aT_KadouTimeGroup2 ){

            baseDomManager.delete(aT_KadouTimeGroup2);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup3 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd3);
        if ( null != aT_KadouTimeGroup3 ){

            baseDomManager.delete(aT_KadouTimeGroup3);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup4 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd4);
        if ( null != aT_KadouTimeGroup4 ){

            baseDomManager.delete(aT_KadouTimeGroup4);
        }

        AT_KadouTimeGroup aT_KadouTimeGroup5 = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd5);
        if ( null != aT_KadouTimeGroup5 ){

            baseDomManager.delete(aT_KadouTimeGroup5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AT_KadouTimeGroup> kadouTimeGroupList = baseDomManager.getAllKadouTimeGroups();

        List<AT_KadouTimeGroup> resultKadouTimeGroupList = ImmutableList.copyOf(Iterables.filter(kadouTimeGroupList, new Predicate<AT_KadouTimeGroup>() {

            @Override
            public boolean apply(AT_KadouTimeGroup pKadouTimeGroupEntity) {

                List<String> pKadouTimeGroupCdList = new ArrayList<String>();
                pKadouTimeGroupCdList.add("KGC0000001");
                pKadouTimeGroupCdList.add("KGC0000002");
                pKadouTimeGroupCdList.add("KGC0000003");
                pKadouTimeGroupCdList.add("KGC0000004");
                pKadouTimeGroupCdList.add("KGC0000005");

                for ( String kadouTimeGroupCd : pKadouTimeGroupCdList ){
                    if ( kadouTimeGroupCd.equals(pKadouTimeGroupEntity.getKadouTimeGroupCd())){
                        return true;
                    }
                }
                return false;
            }

        }));

        long count = resultKadouTimeGroupList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pKadouTimeGroupCd = "KGC0000001";
        AT_KadouTimeGroup aT_KadouTimeGroup = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd);

        assertEquals(pKadouTimeGroupCd, aT_KadouTimeGroup.getKadouTimeGroupCd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pKadouTimeGroupCd = "KGC0000099";
        AT_KadouTimeGroup aT_KadouTimeGroup = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd);

        assertNull(aT_KadouTimeGroup);
    }

    @Override
    @Test
    public void blankCondition() {
        String pKadouTimeGroupCd = "";
        AT_KadouTimeGroup aT_KadouTimeGroup = baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd);

        assertNull(aT_KadouTimeGroup);
    }

    @Override
    @Test
    public void nullCondition() {
        String pKadouTimeGroupCd = null;
        try {
            baseDomManager.getKadouTimeGroup(pKadouTimeGroupCd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
