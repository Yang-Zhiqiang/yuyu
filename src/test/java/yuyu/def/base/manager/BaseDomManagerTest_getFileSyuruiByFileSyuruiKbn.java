package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_FileSyuruiKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、
 * getFileSyuruiByFileSyuruiKbnメソッドのテストクラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getFileSyuruiByFileSyuruiKbn extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        C_FileSyuruiCdKbn pFileSyuruiCd1 = C_FileSyuruiCdKbn.BLNK;
        C_FileSyuruiCdKbn pFileSyuruiCd2 = C_FileSyuruiCdKbn.BLNK;
        C_FileSyuruiCdKbn pFileSyuruiCd3 = C_FileSyuruiCdKbn.BLNK;
        C_FileSyuruiCdKbn pFileSyuruiCd4 = C_FileSyuruiCdKbn.BLNK;

        C_FileSyuruiKbn pFileSyuruiKbn1 = C_FileSyuruiKbn.DOWNLOAD;
        C_FileSyuruiKbn pFileSyuruiKbn2 = C_FileSyuruiKbn.UPLOAD;

        AS_FileSyurui aS_FileSyurui1 = baseDomManager.getFileSyurui(pFileSyuruiCd1);
        if ( null == aS_FileSyurui1 ) {

            aS_FileSyurui1 = new AS_FileSyurui();
            aS_FileSyurui1.setFileSyuruiCd(pFileSyuruiCd1);
            aS_FileSyurui1.setFileSyuruiKbn(pFileSyuruiKbn1);

            baseDomManager.insert(aS_FileSyurui1);
        }

        AS_FileSyurui aS_FileSyurui2 = baseDomManager.getFileSyurui(pFileSyuruiCd2);
        if ( null == aS_FileSyurui2 ) {

            aS_FileSyurui2 = new AS_FileSyurui();
            aS_FileSyurui2.setFileSyuruiCd(pFileSyuruiCd2);
            aS_FileSyurui2.setFileSyuruiKbn(pFileSyuruiKbn2);

            baseDomManager.insert(aS_FileSyurui2);
        }

        AS_FileSyurui aS_FileSyurui3 = baseDomManager.getFileSyurui(pFileSyuruiCd3);
        if ( null == aS_FileSyurui3 ) {

            aS_FileSyurui3 = new AS_FileSyurui();
            aS_FileSyurui3.setFileSyuruiCd(pFileSyuruiCd3);
            aS_FileSyurui3.setFileSyuruiKbn(pFileSyuruiKbn2);

            baseDomManager.insert(aS_FileSyurui3);
        }

        AS_FileSyurui aS_FileSyurui4 = baseDomManager.getFileSyurui(pFileSyuruiCd4);
        if ( null == aS_FileSyurui4 ) {

            aS_FileSyurui4 = new AS_FileSyurui();
            aS_FileSyurui4.setFileSyuruiCd(pFileSyuruiCd4);
            aS_FileSyurui4.setFileSyuruiKbn(pFileSyuruiKbn2);

            baseDomManager.insert(aS_FileSyurui4);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        C_FileSyuruiCdKbn pFileSyuruiCd1 = C_FileSyuruiCdKbn.BLNK;
        C_FileSyuruiCdKbn pFileSyuruiCd2 = C_FileSyuruiCdKbn.BLNK;
        C_FileSyuruiCdKbn pFileSyuruiCd3 = C_FileSyuruiCdKbn.BLNK;
        C_FileSyuruiCdKbn pFileSyuruiCd4 = C_FileSyuruiCdKbn.BLNK;

        AS_FileSyurui aS_FileSyurui1 = baseDomManager.getFileSyurui(pFileSyuruiCd1);
        if ( null != aS_FileSyurui1 ) {

            baseDomManager.delete(aS_FileSyurui1);
        }

        AS_FileSyurui aS_FileSyurui2 = baseDomManager.getFileSyurui(pFileSyuruiCd2);
        if ( null != aS_FileSyurui2 ) {

            baseDomManager.delete(aS_FileSyurui2);
        }

        AS_FileSyurui aS_FileSyurui3 = baseDomManager.getFileSyurui(pFileSyuruiCd3);
        if ( null != aS_FileSyurui3 ) {

            baseDomManager.delete(aS_FileSyurui3);
        }

        AS_FileSyurui aS_FileSyurui4 = baseDomManager.getFileSyurui(pFileSyuruiCd4);
        if ( null != aS_FileSyurui4 ) {

            baseDomManager.delete(aS_FileSyurui4);
        }

    }

    @Test
    public void test001(){
        C_FileSyuruiKbn pSyuruiKbn = C_FileSyuruiKbn.DOWNLOAD;
        List<AS_FileSyurui> aS_FileSyuruiList = baseDomManager.getFileSyuruiByFileSyuruiKbn(pSyuruiKbn);

        assertEquals(1, aS_FileSyuruiList.size());
    }

    @Test
    public void test002(){
        C_FileSyuruiKbn pSyuruiKbn = C_FileSyuruiKbn.UPLOAD;
        List<AS_FileSyurui> aS_FileSyuruiList = baseDomManager.getFileSyuruiByFileSyuruiKbn(pSyuruiKbn);

        assertEquals(0, aS_FileSyuruiList.size());
    }

    @Test
    public void test003(){
        C_FileSyuruiKbn pSyuruiKbn = null;
        List<AS_FileSyurui> aS_FileSyuruiList = baseDomManager.getFileSyuruiByFileSyuruiKbn(pSyuruiKbn);

        assertEquals(0, aS_FileSyuruiList.size());
    }

    @Test
    public void test004(){
        C_FileSyuruiKbn pSyuruiKbn = C_FileSyuruiKbn.UPLOAD;
        List<AS_FileSyurui> aS_FileSyuruiList = baseDomManager.getFileSyuruiByFileSyuruiKbn(pSyuruiKbn);

        assertEquals(0, aS_FileSyuruiList.size());
    }

}
