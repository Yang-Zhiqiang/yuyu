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
 * ファイル保存情報テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_FileHozonInfoEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pUniqueId5 = "UNI0000005";

        AT_FileHozonInfo aT_FileHozonInfo1 = baseDomManager.getFileHozonInfo(pUniqueId1);
        if ( null == aT_FileHozonInfo1 ){

            aT_FileHozonInfo1 = new AT_FileHozonInfo();
            aT_FileHozonInfo1.setUniqueId(pUniqueId1);

            baseDomManager.insert(aT_FileHozonInfo1);
        }

        AT_FileHozonInfo aT_FileHozonInfo2 = baseDomManager.getFileHozonInfo(pUniqueId2);
        if ( null == aT_FileHozonInfo2 ){

            aT_FileHozonInfo2 = new AT_FileHozonInfo();
            aT_FileHozonInfo2.setUniqueId(pUniqueId2);

            baseDomManager.insert(aT_FileHozonInfo2);
        }

        AT_FileHozonInfo aT_FileHozonInfo3 = baseDomManager.getFileHozonInfo(pUniqueId3);
        if ( null == aT_FileHozonInfo3 ){

            aT_FileHozonInfo3 = new AT_FileHozonInfo();
            aT_FileHozonInfo3.setUniqueId(pUniqueId3);

            baseDomManager.insert(aT_FileHozonInfo3);
        }

        AT_FileHozonInfo aT_FileHozonInfo4 = baseDomManager.getFileHozonInfo(pUniqueId4);
        if ( null == aT_FileHozonInfo4 ){

            aT_FileHozonInfo4 = new AT_FileHozonInfo();
            aT_FileHozonInfo4.setUniqueId(pUniqueId4);

            baseDomManager.insert(aT_FileHozonInfo4);
        }

        AT_FileHozonInfo aT_FileHozonInfo5 = baseDomManager.getFileHozonInfo(pUniqueId5);
        if ( null == aT_FileHozonInfo5 ){

            aT_FileHozonInfo5 = new AT_FileHozonInfo();
            aT_FileHozonInfo5.setUniqueId(pUniqueId5);

            baseDomManager.insert(aT_FileHozonInfo5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pUniqueId5 = "UNI0000005";

        AT_FileHozonInfo AT_FileHozonInfo1 = baseDomManager.getFileHozonInfo(pUniqueId1);
        if ( null != AT_FileHozonInfo1 ){

            baseDomManager.delete(AT_FileHozonInfo1);
        }

        AT_FileHozonInfo AT_FileHozonInfo2 = baseDomManager.getFileHozonInfo(pUniqueId2);
        if ( null != AT_FileHozonInfo2 ){

            baseDomManager.delete(AT_FileHozonInfo2);
        }

        AT_FileHozonInfo AT_FileHozonInfo3 = baseDomManager.getFileHozonInfo(pUniqueId3);
        if ( null != AT_FileHozonInfo3 ){

            baseDomManager.delete(AT_FileHozonInfo3);
        }

        AT_FileHozonInfo AT_FileHozonInfo4 = baseDomManager.getFileHozonInfo(pUniqueId4);
        if ( null != AT_FileHozonInfo4 ){

            baseDomManager.delete(AT_FileHozonInfo4);
        }

        AT_FileHozonInfo AT_FileHozonInfo5 = baseDomManager.getFileHozonInfo(pUniqueId5);
        if ( null != AT_FileHozonInfo5 ){

            baseDomManager.delete(AT_FileHozonInfo5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AT_FileHozonInfo> fileHozonInfoList = baseDomManager.getAllFileHozonInfo();

        List<AT_FileHozonInfo> resultFileHozonInfoList = ImmutableList.copyOf(Iterables.filter(fileHozonInfoList, new Predicate<AT_FileHozonInfo>() {

            @Override
            public boolean apply(AT_FileHozonInfo pFileHozonInfoEntity) {

                List<String> pUniqueIdList = new ArrayList<String>();
                pUniqueIdList.add("UNI0000001");
                pUniqueIdList.add("UNI0000002");
                pUniqueIdList.add("UNI0000003");
                pUniqueIdList.add("UNI0000004");
                pUniqueIdList.add("UNI0000005");

                for (String uniqueId : pUniqueIdList) {
                    if (uniqueId.equals(pFileHozonInfoEntity.getUniqueId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultFileHozonInfoList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pUniqueId = "UNI0000001";
        AT_FileHozonInfo aT_FileHozonInfo = baseDomManager.getFileHozonInfo(pUniqueId);

        assertEquals(pUniqueId, aT_FileHozonInfo.getUniqueId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUniqueId = "UNI0000099";
        AT_FileHozonInfo aT_FileHozonInfo = baseDomManager.getFileHozonInfo(pUniqueId);

        assertNull(aT_FileHozonInfo);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUniqueId = "";
        AT_FileHozonInfo aT_FileHozonInfo = baseDomManager.getFileHozonInfo(pUniqueId);

        assertNull(aT_FileHozonInfo);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUniqueId = null;
        try {
            baseDomManager.getFileHozonInfo(pUniqueId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
