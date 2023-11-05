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
import yuyu.def.classification.C_FileSyuruiCdKbn;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * ファイル種類基幹テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_FileSyuruiEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        C_FileSyuruiCdKbn pFileSyuruiCd1 = C_FileSyuruiCdKbn.BLNK;

        AS_FileSyurui aS_FileSyurui1 = baseDomManager.getFileSyurui(pFileSyuruiCd1);
        if (null == aS_FileSyurui1) {

            aS_FileSyurui1 = new AS_FileSyurui();
            aS_FileSyurui1.setFileSyuruiCd(pFileSyuruiCd1);

            baseDomManager.insert(aS_FileSyurui1);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        C_FileSyuruiCdKbn pFileSyuruiCd1 = C_FileSyuruiCdKbn.BLNK;

        AS_FileSyurui aS_FileSyurui1 = baseDomManager.getFileSyurui(pFileSyuruiCd1);
        if (null != aS_FileSyurui1) {

            baseDomManager.delete(aS_FileSyurui1);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AS_FileSyurui> fileSyuruiList = baseDomManager.getAllFileSyuruis();

        List<AS_FileSyurui> resultFileSyuruiList = ImmutableList.copyOf(Iterables.filter(fileSyuruiList, new Predicate<AS_FileSyurui>() {

            @Override
            public boolean apply(AS_FileSyurui pFileSyuruiEntity) {

                List<String> fileSyuruiCdList = new ArrayList<String>();
                fileSyuruiCdList.add("0");

                for (String fileSyuruiCd : fileSyuruiCdList) {
                    if (fileSyuruiCd.equals(pFileSyuruiEntity.getFileSyuruiCd().toString())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultFileSyuruiList.size();
        assertEquals(1, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        AS_FileSyurui aS_FileSyurui = baseDomManager.getFileSyurui(pFileSyuruiCd);

        assertEquals(pFileSyuruiCd, aS_FileSyurui.getFileSyuruiCd());
    }

    @Override
    @Test
    public void noUniqueEntity() {
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        AS_FileSyurui aS_FileSyurui = baseDomManager.getFileSyurui(pFileSyuruiCd);
        assertNotNull(aS_FileSyurui);
    }

    @Override
    @Test
    public void blankCondition() {
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        AS_FileSyurui aS_FileSyurui = baseDomManager.getFileSyurui(pFileSyuruiCd);
        assertNotNull(aS_FileSyurui);
    }

    @Override
    @Test
    public void nullCondition() {
    	C_FileSyuruiCdKbn pFileSyuruiCd = null;
        try {
            baseDomManager.getFileSyurui(pFileSyuruiCd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
