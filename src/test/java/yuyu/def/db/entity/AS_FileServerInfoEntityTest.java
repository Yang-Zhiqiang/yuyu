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
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * ファイルサーバー情報基幹テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_FileServerInfoEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        Integer pSetteiNo1 = 11111;
        Integer pSetteiNo2 = 11112;
        Integer pSetteiNo3 = 11113;
        Integer pSetteiNo4 = 11114;
        Integer pSetteiNo5 = 11115;
        BizDate pTekiyouYmdFrom1 = BizDate.valueOf("20130110");
        BizDate pTekiyouYmdFrom2 = BizDate.valueOf("20130620");
        BizDate pTekiyouYmdFrom3 = BizDate.valueOf("20110411");
        BizDate pTekiyouYmdFrom4 = BizDate.valueOf("20150529");
        BizDate pTekiyouYmdFrom5 = BizDate.valueOf("20150709");

        AS_FileServerInfo aS_FileServerInfo1 = baseDomManager.getFileServerInfo(pSetteiNo1, pTekiyouYmdFrom1);
        if (null == aS_FileServerInfo1) {

            aS_FileServerInfo1 = new AS_FileServerInfo();
            aS_FileServerInfo1.setSetteiNo(pSetteiNo1);
            aS_FileServerInfo1.setTekiyouYmdFrom(pTekiyouYmdFrom1);

            baseDomManager.insert(aS_FileServerInfo1);
        }

        AS_FileServerInfo aS_FileServerInfo2 = baseDomManager.getFileServerInfo(pSetteiNo2, pTekiyouYmdFrom2);
        if (null == aS_FileServerInfo2) {

            aS_FileServerInfo2 = new AS_FileServerInfo();
            aS_FileServerInfo2.setSetteiNo(pSetteiNo2);
            aS_FileServerInfo2.setTekiyouYmdFrom(pTekiyouYmdFrom2);

            baseDomManager.insert(aS_FileServerInfo2);
        }

        AS_FileServerInfo aS_FileServerInfo3 = baseDomManager.getFileServerInfo(pSetteiNo3, pTekiyouYmdFrom3);
        if (null == aS_FileServerInfo3) {

            aS_FileServerInfo3 = new AS_FileServerInfo();
            aS_FileServerInfo3.setSetteiNo(pSetteiNo3);
            aS_FileServerInfo3.setTekiyouYmdFrom(pTekiyouYmdFrom3);

            baseDomManager.insert(aS_FileServerInfo3);
        }

        AS_FileServerInfo aS_FileServerInfo4 = baseDomManager.getFileServerInfo(pSetteiNo4, pTekiyouYmdFrom4);
        if (null == aS_FileServerInfo4) {

            aS_FileServerInfo4 = new AS_FileServerInfo();
            aS_FileServerInfo4.setSetteiNo(pSetteiNo4);
            aS_FileServerInfo4.setTekiyouYmdFrom(pTekiyouYmdFrom4);

            baseDomManager.insert(aS_FileServerInfo4);
        }

        AS_FileServerInfo aS_FileServerInfo5 = baseDomManager.getFileServerInfo(pSetteiNo5, pTekiyouYmdFrom5);
        if (null == aS_FileServerInfo5) {

            aS_FileServerInfo5 = new AS_FileServerInfo();
            aS_FileServerInfo5.setSetteiNo(pSetteiNo5);
            aS_FileServerInfo5.setTekiyouYmdFrom(pTekiyouYmdFrom5);

            baseDomManager.insert(aS_FileServerInfo5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        Integer pSetteiNo1 = 11111;
        Integer pSetteiNo2 = 11112;
        Integer pSetteiNo3 = 11113;
        Integer pSetteiNo4 = 11114;
        Integer pSetteiNo5 = 11115;
        BizDate pTekiyouYmdFrom1 = BizDate.valueOf("20130110");
        BizDate pTekiyouYmdFrom2 = BizDate.valueOf("20130620");
        BizDate pTekiyouYmdFrom3 = BizDate.valueOf("20110411");
        BizDate pTekiyouYmdFrom4 = BizDate.valueOf("20150529");
        BizDate pTekiyouYmdFrom5 = BizDate.valueOf("20150709");

        AS_FileServerInfo aS_FileServerInfo1 = baseDomManager.getFileServerInfo(pSetteiNo1, pTekiyouYmdFrom1);
        if (null != aS_FileServerInfo1) {

            baseDomManager.delete(aS_FileServerInfo1);
        }

        AS_FileServerInfo aS_FileServerInfo2 = baseDomManager.getFileServerInfo(pSetteiNo2, pTekiyouYmdFrom2);
        if (null != aS_FileServerInfo2) {

            baseDomManager.delete(aS_FileServerInfo2);
        }

        AS_FileServerInfo aS_FileServerInfo3 = baseDomManager.getFileServerInfo(pSetteiNo3, pTekiyouYmdFrom3);
        if (null != aS_FileServerInfo3) {

            baseDomManager.delete(aS_FileServerInfo3);
        }

        AS_FileServerInfo aS_FileServerInfo4 = baseDomManager.getFileServerInfo(pSetteiNo4, pTekiyouYmdFrom4);
        if (null != aS_FileServerInfo4) {

            baseDomManager.delete(aS_FileServerInfo4);
        }

        AS_FileServerInfo aS_FileServerInfo5 = baseDomManager.getFileServerInfo(pSetteiNo5, pTekiyouYmdFrom5);
        if (null != aS_FileServerInfo5) {

            baseDomManager.delete(aS_FileServerInfo5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AS_FileServerInfo> fileServberInfoList = baseDomManager.getAllFileServerInfos();

        List<AS_FileServerInfo> resultFileServerInfoList = ImmutableList.copyOf(Iterables.filter(fileServberInfoList, new Predicate<AS_FileServerInfo>() {

            @Override
            public boolean apply(AS_FileServerInfo pFileServerInfoEntity) {

                List<Integer> fileServerInfoSetteiNoList = new ArrayList<Integer>();
                fileServerInfoSetteiNoList.add(11111);
                fileServerInfoSetteiNoList.add(11112);
                fileServerInfoSetteiNoList.add(11113);
                fileServerInfoSetteiNoList.add(11114);
                fileServerInfoSetteiNoList.add(11115);

                List<BizDate> fileServerInfoTekiyouYmdFromList = new ArrayList<BizDate>();
                fileServerInfoTekiyouYmdFromList.add(BizDate.valueOf("20130110"));
                fileServerInfoTekiyouYmdFromList.add(BizDate.valueOf("20130620"));
                fileServerInfoTekiyouYmdFromList.add(BizDate.valueOf("20110411"));
                fileServerInfoTekiyouYmdFromList.add(BizDate.valueOf("20150529"));
                fileServerInfoTekiyouYmdFromList.add(BizDate.valueOf("20150709"));
                for ( int idx = 0; idx < fileServerInfoSetteiNoList.size(); idx++ ) {
                    if ( fileServerInfoSetteiNoList.get(idx).equals(pFileServerInfoEntity.getSetteiNo()) &&
                        fileServerInfoTekiyouYmdFromList.get(idx).equals(pFileServerInfoEntity.getTekiyouYmdFrom()) ){
                        return true;
                    }
                }
                return false;
            }

        }));

        long count = resultFileServerInfoList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        Integer pSetteiNo = 11111;
        BizDate pTekiyouYmdFrom = BizDate.valueOf("20130110");
        AS_FileServerInfo aS_FileServerInfo = baseDomManager.getFileServerInfo(pSetteiNo, pTekiyouYmdFrom);

        assertEquals(pSetteiNo, aS_FileServerInfo.getSetteiNo());
        assertEquals(pTekiyouYmdFrom, aS_FileServerInfo.getTekiyouYmdFrom());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        Integer pSetteiNo = 11199;
        BizDate pTekiyoYmdFrom = BizDate.valueOf("20990101");
        AS_FileServerInfo aS_FileServerInfo = baseDomManager.getFileServerInfo(pSetteiNo, pTekiyoYmdFrom);

        assertNull(aS_FileServerInfo);
    }

    @Override
    @Test
    public void blankCondition() {
    }

    @Override
    @Test
    public void nullCondition() {
        Integer pSetteiNo = null;
        BizDate pTekiyoYmdFrom = null;

        try {
            baseDomManager.getFileServerInfo(pSetteiNo, pTekiyoYmdFrom);
        } catch (Exception e) {
            assertThat(e,  instanceOf(NonUniqueResultException.class));
        }
    }
}
