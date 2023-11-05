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
 * カテゴリ基幹テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_CategoryEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pCategoryId1 = "CI00000001";
        String pCategoryId2 = "CI00000002";
        String pCategoryId3 = "CI00000003";
        String pCategoryId4 = "CI00000004";
        String pCategoryId5 = "CI00000005";

        AS_Category aS_Category1 = baseDomManager.getCategory(pCategoryId1);
        if ( null == aS_Category1 ){

            aS_Category1 = new AS_Category();
            aS_Category1.setCategoryId(pCategoryId1);

            baseDomManager.insert(aS_Category1);
        }

        AS_Category aS_Category2 = baseDomManager.getCategory(pCategoryId2);
        if ( null == aS_Category2 ){

            aS_Category2 = new AS_Category();
            aS_Category2.setCategoryId(pCategoryId2);

            baseDomManager.insert(aS_Category2);
        }

        AS_Category aS_Category3 = baseDomManager.getCategory(pCategoryId3);
        if ( null == aS_Category3 ){

            aS_Category3 = new AS_Category();
            aS_Category3.setCategoryId(pCategoryId3);

            baseDomManager.insert(aS_Category3);
        }

        AS_Category aS_Category4 = baseDomManager.getCategory(pCategoryId4);
        if ( null == aS_Category4 ){

            aS_Category4 = new AS_Category();
            aS_Category4.setCategoryId(pCategoryId4);

            baseDomManager.insert(aS_Category4);
        }

        AS_Category aS_Category5 = baseDomManager.getCategory(pCategoryId5);
        if ( null == aS_Category5 ){

            aS_Category5 = new AS_Category();
            aS_Category5.setCategoryId(pCategoryId5);

            baseDomManager.insert(aS_Category5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pCategoryId1 = "CI00000001";
        String pCategoryId2 = "CI00000002";
        String pCategoryId3 = "CI00000003";
        String pCategoryId4 = "CI00000004";
        String pCategoryId5 = "CI00000005";

        AS_Category aS_Category1 = baseDomManager.getCategory(pCategoryId1);
        if ( null != aS_Category1 ){

            baseDomManager.delete(aS_Category1);
        }

        AS_Category aS_Category2 = baseDomManager.getCategory(pCategoryId2);
        if ( null != aS_Category2 ){

            baseDomManager.delete(aS_Category2);
        }

        AS_Category aS_Category3 = baseDomManager.getCategory(pCategoryId3);
        if ( null != aS_Category3 ){

            baseDomManager.delete(aS_Category3);
        }

        AS_Category aS_Category4 = baseDomManager.getCategory(pCategoryId4);
        if ( null != aS_Category4 ){

            baseDomManager.delete(aS_Category4);
        }

        AS_Category aS_Category5 = baseDomManager.getCategory(pCategoryId5);
        if ( null != aS_Category5 ){

            baseDomManager.delete(aS_Category5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AS_Category> categoryList = baseDomManager.getAllCategories();

        List<AS_Category> resultCategoryList = ImmutableList.copyOf(Iterables.filter(categoryList, new Predicate<AS_Category>() {

            @Override
            public boolean apply(AS_Category pCategoryEntity) {

                List<String> categoryIdList = new ArrayList<String>();
                categoryIdList.add("CI00000001");
                categoryIdList.add("CI00000002");
                categoryIdList.add("CI00000003");
                categoryIdList.add("CI00000004");
                categoryIdList.add("CI00000005");

                for (String categoryId : categoryIdList) {
                    if (categoryId.equals(pCategoryEntity.getCategoryId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultCategoryList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pCategoryId = "CI00000001";
        AS_Category aS_Category = baseDomManager.getCategory(pCategoryId);

        assertEquals(pCategoryId, aS_Category.getCategoryId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pCategoryId = "CI00000099";
        AS_Category aS_Category = baseDomManager.getCategory(pCategoryId);

        assertNull(aS_Category);

    }

    @Override
    @Test
    public void blankCondition() {
        String pCategoryId = "";
        AS_Category aS_Category = baseDomManager.getCategory(pCategoryId);

        assertNull(aS_Category);
    }

    @Override
    @Test
    public void nullCondition() {
        String pCategoryId = null;
        try {
            baseDomManager.getCategory(pCategoryId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
