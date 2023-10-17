package yuyu.batch.base.sysbatch.kakodataseibi;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.exception.ExIllegalArgumentException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;

import org.hibernate.JDBCException;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_UserGroup;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.def.db.meta.QAM_UserGroup;
import yuyu.def.db.meta.QAS_KinouModeSiborikomi;
import yuyu.testinfr.AbstractTest;

/**
 * 過去データ整備DAOクラスの<br />
 * getDataByKey のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class KakoDataSeibiTest_getDataByKey extends AbstractTest {

    @Inject
    private KakoDataSeibiDao kakoDataSeibiDao;

    @Inject
    private BaseDomManager baseDomManager;

    @Test
    @Transactional
    public void test001() {

        insertTest001();

        String tableId = null;
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        try {
            kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd);
        } catch (Exception e) {
            assertThat(e, instanceOf(NullPointerException.class));
        }

        deleteTest001();

    }

    @Test
    @Transactional
    public void test002() {

        insertTest001();

        String tableId = "AM_UserGroup";
        String sakujyoKey = null;
        String sakujyokijynYmd = "20160415000000000";

        List<AM_UserGroup> userGroupList = new ArrayList<AM_UserGroup>();

        try (ExDBResults<AM_UserGroup> resultEntityList = kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd)) {

            for (AM_UserGroup resultEntity : resultEntityList) {

                AM_UserGroup userGroup = new AM_UserGroup();

                userGroup.setUserGroupCd(resultEntity.getUserGroupCd());
                userGroup.setUserGroupNm(resultEntity.getUserGroupNm());
                userGroup.setUserGroupSetumei(resultEntity.getUserGroupSetumei());

                userGroupList.add(userGroup);
            }

        }

        String userGroupCd1 = "testUserGroup001";
        String userGroupCd2 = "testUserGroup002";
        String userGroupCd3 = "testUserGroup003";
        String userGroupCd4 = "testUserGroup004";
        String userGroupCd5 = "testUserGroup005";

        assertEquals(5, userGroupList.size());

        assertEquals(userGroupCd1, userGroupList.get(0).getUserGroupCd());
        assertEquals(userGroupCd2, userGroupList.get(1).getUserGroupCd());
        assertEquals(userGroupCd3, userGroupList.get(2).getUserGroupCd());
        assertEquals(userGroupCd4, userGroupList.get(3).getUserGroupCd());
        assertEquals(userGroupCd5, userGroupList.get(4).getUserGroupCd());

        deleteTest001();

    }

    @Test
    @Transactional
    public void test003() {

        insertTest001();

        String tableId = "";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        try {
            kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd);
        } catch (Exception e) {
            assertThat(e, instanceOf(ExIllegalArgumentException.class));
            assertEquals("引数が異常です。(指定されたテーブルID[]は不正です。)", e.getMessage());
        }

        deleteTest001();

    }

    @Test
    @Transactional
    public void test004() {

        insertTest001();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "";
        String sakujyokijynYmd = "20160415000000000";

        List<AM_UserGroup> userGroupList = new ArrayList<AM_UserGroup>();

        try (ExDBResults<AM_UserGroup> resultEntityList = kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd)) {

            for (AM_UserGroup resultEntity : resultEntityList) {

                AM_UserGroup userGroup = new AM_UserGroup();

                userGroup.setUserGroupCd(resultEntity.getUserGroupCd());
                userGroup.setUserGroupNm(resultEntity.getUserGroupNm());
                userGroup.setUserGroupSetumei(resultEntity.getUserGroupSetumei());

                userGroupList.add(userGroup);
            }

        }

        String userGroupCd1 = "testUserGroup001";
        String userGroupCd2 = "testUserGroup002";
        String userGroupCd3 = "testUserGroup003";
        String userGroupCd4 = "testUserGroup004";
        String userGroupCd5 = "testUserGroup005";

        assertEquals(5, userGroupList.size());

        assertEquals(userGroupCd1, userGroupList.get(0).getUserGroupCd());
        assertEquals(userGroupCd2, userGroupList.get(1).getUserGroupCd());
        assertEquals(userGroupCd3, userGroupList.get(2).getUserGroupCd());
        assertEquals(userGroupCd4, userGroupList.get(3).getUserGroupCd());
        assertEquals(userGroupCd5, userGroupList.get(4).getUserGroupCd());

        deleteTest001();

    }

    @Test
    @Transactional
    public void test005() {

        insertTest002();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        List<AM_UserGroup> userGroupList = new ArrayList<AM_UserGroup>();

        try (ExDBResults<AM_UserGroup> resultEntityList = kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd)) {

            for (AM_UserGroup resultEntity : resultEntityList) {

                AM_UserGroup userGroup = new AM_UserGroup();

                userGroup.setUserGroupCd(resultEntity.getUserGroupCd());
                userGroup.setUserGroupNm(resultEntity.getUserGroupNm());
                userGroup.setUserGroupSetumei(resultEntity.getUserGroupSetumei());

                userGroupList.add(userGroup);
            }

        }

        String userGroupCd1 = "testUserGroup001";
        String userGroupCd2 = "testUserGroup002";

        assertEquals(2, userGroupList.size());

        assertEquals(userGroupCd1, userGroupList.get(0).getUserGroupCd());
        assertEquals(userGroupCd2, userGroupList.get(1).getUserGroupCd());

        deleteTest002();

    }

    @Test
    @Transactional
    public void test006() {

        insertTest002();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIMES";
        String sakujyokijynYmd = "20160415000000000";

        try {
            kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd);
        } catch (Exception e) {
            assertThat(e, instanceOf(JDBCException.class));
        }

        deleteTest002();

    }

    @Test
    @Transactional
    public void test007() {

        insertTest002();

        String tableId = "AT_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        try {
            kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd);
        } catch (Exception e) {
            assertThat(e, instanceOf(ExIllegalArgumentException.class));
            assertEquals("引数が異常です。(指定されたテーブルID["+ tableId +"]は不正です。)", e.getMessage());
        }

        deleteTest002();

    }

    @Test
    @Transactional
    public void test008() {

        insertTest002();

        String tableId = "AT_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        try {
            kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd);
        } catch (Exception e) {
            assertThat(e, instanceOf(ExIllegalArgumentException.class));
            assertEquals("引数が異常です。(指定されたテーブルID["+ tableId +"]は不正です。)", e.getMessage());
        }

        deleteTest002();

    }

    @Test
    @Transactional
    public void test009() {

        insertTest002();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        List<AM_UserGroup> userGroupList = new ArrayList<AM_UserGroup>();

        try (ExDBResults<AM_UserGroup> resultEntityList = kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd)) {

            for (AM_UserGroup resultEntity : resultEntityList) {

                AM_UserGroup userGroup = new AM_UserGroup();

                userGroup.setUserGroupCd(resultEntity.getUserGroupCd());
                userGroup.setUserGroupNm(resultEntity.getUserGroupNm());
                userGroup.setUserGroupSetumei(resultEntity.getUserGroupSetumei());

                userGroupList.add(userGroup);
            }

        }

        String userGroupCd1 = "testUserGroup001";
        String userGroupCd2 = "testUserGroup002";

        assertEquals(2, userGroupList.size());

        assertEquals(userGroupCd1, userGroupList.get(0).getUserGroupCd());
        assertEquals(userGroupCd2, userGroupList.get(1).getUserGroupCd());

        deleteTest002();

    }

    @Test
    @Transactional
    public void test010() {

        insertTest002();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415";

        List<AM_UserGroup> userGroupList = new ArrayList<AM_UserGroup>();

        try (ExDBResults<AM_UserGroup> resultEntityList = kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd)) {

            for (AM_UserGroup resultEntity : resultEntityList) {

                AM_UserGroup userGroup = new AM_UserGroup();

                userGroup.setUserGroupCd(resultEntity.getUserGroupCd());
                userGroup.setUserGroupNm(resultEntity.getUserGroupNm());
                userGroup.setUserGroupSetumei(resultEntity.getUserGroupSetumei());

                userGroupList.add(userGroup);
            }

        }

        String userGroupCd1 = "testUserGroup001";

        assertEquals(1, userGroupList.size());

        assertEquals(userGroupCd1, userGroupList.get(0).getUserGroupCd());

        deleteTest002();

    }

    @Test
    @Transactional
    public void test011() {

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        List<AM_UserGroup> userGroupList = new ArrayList<AM_UserGroup>();

        try (ExDBResults<AM_UserGroup> resultEntityList = kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd)) {

            for (AM_UserGroup resultEntity : resultEntityList) {

                AM_UserGroup userGroup = new AM_UserGroup();

                userGroup.setUserGroupCd(resultEntity.getUserGroupCd());
                userGroup.setUserGroupNm(resultEntity.getUserGroupNm());
                userGroup.setUserGroupSetumei(resultEntity.getUserGroupSetumei());

                userGroupList.add(userGroup);
            }

        }

        assertEquals(0, userGroupList.size());

    }

    @Test
    @Transactional
    public void test012() {

        insertTest004();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        List<AM_UserGroup> userGroupList = new ArrayList<AM_UserGroup>();

        try (ExDBResults<AM_UserGroup> resultEntityList = kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd)) {

            for (AM_UserGroup resultEntity : resultEntityList) {

                AM_UserGroup userGroup = new AM_UserGroup();

                userGroup.setUserGroupCd(resultEntity.getUserGroupCd());
                userGroup.setUserGroupNm(resultEntity.getUserGroupNm());
                userGroup.setUserGroupSetumei(resultEntity.getUserGroupSetumei());

                userGroupList.add(userGroup);
            }

        }

        String userGroupCd1 = "testUserGroup001";

        assertEquals(1, userGroupList.size());

        assertEquals(userGroupCd1, userGroupList.get(0).getUserGroupCd());

        deleteTest004();

    }

    @Test
    @Transactional
    public void test013() {

        insertTest005();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        List<AM_UserGroup> userGroupList = new ArrayList<AM_UserGroup>();

        try (ExDBResults<AM_UserGroup> resultEntityList = kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd)) {

            for (AM_UserGroup resultEntity : resultEntityList) {

                AM_UserGroup userGroup = new AM_UserGroup();

                userGroup.setUserGroupCd(resultEntity.getUserGroupCd());
                userGroup.setUserGroupNm(resultEntity.getUserGroupNm());
                userGroup.setUserGroupSetumei(resultEntity.getUserGroupSetumei());

                userGroupList.add(userGroup);
            }

        }

        String userGroupCd1 = "testUserGroup001";
        String userGroupCd2 = "testUserGroup002";
        String userGroupCd3 = "testUserGroup003";
        String userGroupCd4 = "testUserGroup004";
        String userGroupCd5 = "testUserGroup005";
        String userGroupCd6 = "testUserGroup006";

        assertEquals(userGroupCd1, userGroupList.get(0).getUserGroupCd());
        assertEquals(userGroupCd2, userGroupList.get(1).getUserGroupCd());
        assertEquals(userGroupCd3, userGroupList.get(2).getUserGroupCd());
        assertEquals(userGroupCd4, userGroupList.get(3).getUserGroupCd());
        assertEquals(userGroupCd5, userGroupList.get(4).getUserGroupCd());
        assertEquals(userGroupCd6, userGroupList.get(5).getUserGroupCd());

        deleteTest005();

    }

    @Test
    @Transactional
    public void test014() {

        insertTest006();

        String tableId = "AS_KinouModeSiborikomi";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        List<AS_KinouModeSiborikomi> kinouModeSiborikomiList = new ArrayList<AS_KinouModeSiborikomi>();

        try (ExDBResults<AS_KinouModeSiborikomi> resultEntityList = kakoDataSeibiDao.getDataByKey(tableId, sakujyoKey, sakujyokijynYmd)) {

            for (AS_KinouModeSiborikomi resultEntity : resultEntityList) {

                AS_KinouModeSiborikomi kinouModeSiborikomi = new AS_KinouModeSiborikomi();

                kinouModeSiborikomi.setKinouId(resultEntity.getKinouId());
                kinouModeSiborikomi.setKinouModeId(resultEntity.getKinouModeId());
                kinouModeSiborikomi.setSiborikomiId(resultEntity.getSiborikomiId());
                kinouModeSiborikomi.setSiborikomiNm(resultEntity.getSiborikomiNm());
                kinouModeSiborikomi.setKousinsyaId(resultEntity.getKousinsyaId());
                kinouModeSiborikomi.setKousinTime(resultEntity.getKousinTime());
                kinouModeSiborikomi.setKousinKinou(resultEntity.getKousinKinou());
                kinouModeSiborikomi.setVersion(resultEntity.getVersion());

                kinouModeSiborikomiList.add(kinouModeSiborikomi);
            }

        }

        String kinouId01      = "testKinouID01";
        String kinouModeId01  = "testKinouModeID01";
        String siborikomiId01 = "testSiborikomiID01";

        String kinouId02      = "testKinouID01";
        String kinouModeId02  = "testKinouModeID01";
        String siborikomiId02 = "testSiborikomiID02";

        String kinouId03      = "testKinouID01";
        String kinouModeId03  = "testKinouModeID01";
        String siborikomiId03 = "testSiborikomiID03";

        String kinouId04      = "testKinouID01";
        String kinouModeId04  = "testKinouModeID01";
        String siborikomiId04 = "testSiborikomiID04";

        String kinouId05      = "testKinouID01";
        String kinouModeId05  = "testKinouModeID01";
        String siborikomiId05 = "testSiborikomiID05";

        String kinouId06      = "testKinouID01";
        String kinouModeId06  = "testKinouModeID02";
        String siborikomiId06 = "testSiborikomiID01";

        String kinouId07      = "testKinouID01";
        String kinouModeId07  = "testKinouModeID03";
        String siborikomiId07 = "testSiborikomiID01";

        String kinouId08      = "testKinouID01";
        String kinouModeId08  = "testKinouModeID04";
        String siborikomiId08 = "testSiborikomiID01";

        String kinouId09      = "testKinouID01";
        String kinouModeId09  = "testKinouModeID05";
        String siborikomiId09 = "testSiborikomiID01";

        String kinouId10      = "testKinouID01";
        String kinouModeId10  = "testKinouModeID06";
        String siborikomiId10 = "testSiborikomiID01";

        String kinouId11      = "testKinouID02";
        String kinouModeId11  = "testKinouModeID01";
        String siborikomiId11 = "testSiborikomiID01";

        String kinouId12      = "testKinouID03";
        String kinouModeId12  = "testKinouModeID01";
        String siborikomiId12 = "testSiborikomiID01";

        String kinouId13      = "testKinouID04";
        String kinouModeId13  = "testKinouModeID01";
        String siborikomiId13 = "testSiborikomiID01";

        String kinouId14      = "testKinouID05";
        String kinouModeId14  = "testKinouModeID01";
        String siborikomiId14 = "testSiborikomiID01";

        String kinouId15      = "testKinouID06";
        String kinouModeId15  = "testKinouModeID01";
        String siborikomiId15 = "testSiborikomiID01";


        assertEquals(kinouId01,      kinouModeSiborikomiList.get(0).getKinouId());
        assertEquals(kinouModeId01,  kinouModeSiborikomiList.get(0).getKinouModeId());
        assertEquals(siborikomiId01, kinouModeSiborikomiList.get(0).getSiborikomiId());

        assertEquals(kinouId02,      kinouModeSiborikomiList.get(1).getKinouId());
        assertEquals(kinouModeId02,  kinouModeSiborikomiList.get(1).getKinouModeId());
        assertEquals(siborikomiId02, kinouModeSiborikomiList.get(1).getSiborikomiId());

        assertEquals(kinouId03,      kinouModeSiborikomiList.get(2).getKinouId());
        assertEquals(kinouModeId03,  kinouModeSiborikomiList.get(2).getKinouModeId());
        assertEquals(siborikomiId03, kinouModeSiborikomiList.get(2).getSiborikomiId());

        assertEquals(kinouId04,      kinouModeSiborikomiList.get(3).getKinouId());
        assertEquals(kinouModeId04,  kinouModeSiborikomiList.get(3).getKinouModeId());
        assertEquals(siborikomiId04, kinouModeSiborikomiList.get(3).getSiborikomiId());

        assertEquals(kinouId05,      kinouModeSiborikomiList.get(4).getKinouId());
        assertEquals(kinouModeId05,  kinouModeSiborikomiList.get(4).getKinouModeId());
        assertEquals(siborikomiId05, kinouModeSiborikomiList.get(4).getSiborikomiId());

        assertEquals(kinouId06,      kinouModeSiborikomiList.get(5).getKinouId());
        assertEquals(kinouModeId06,  kinouModeSiborikomiList.get(5).getKinouModeId());
        assertEquals(siborikomiId06, kinouModeSiborikomiList.get(5).getSiborikomiId());

        assertEquals(kinouId07,      kinouModeSiborikomiList.get(6).getKinouId());
        assertEquals(kinouModeId07,  kinouModeSiborikomiList.get(6).getKinouModeId());
        assertEquals(siborikomiId07, kinouModeSiborikomiList.get(6).getSiborikomiId());

        assertEquals(kinouId08,      kinouModeSiborikomiList.get(7).getKinouId());
        assertEquals(kinouModeId08,  kinouModeSiborikomiList.get(7).getKinouModeId());
        assertEquals(siborikomiId08, kinouModeSiborikomiList.get(7).getSiborikomiId());

        assertEquals(kinouId09,      kinouModeSiborikomiList.get(8).getKinouId());
        assertEquals(kinouModeId09,  kinouModeSiborikomiList.get(8).getKinouModeId());
        assertEquals(siborikomiId09, kinouModeSiborikomiList.get(8).getSiborikomiId());

        assertEquals(kinouId10,      kinouModeSiborikomiList.get(9).getKinouId());
        assertEquals(kinouModeId10,  kinouModeSiborikomiList.get(9).getKinouModeId());
        assertEquals(siborikomiId10, kinouModeSiborikomiList.get(9).getSiborikomiId());

        assertEquals(kinouId11,      kinouModeSiborikomiList.get(10).getKinouId());
        assertEquals(kinouModeId11,  kinouModeSiborikomiList.get(10).getKinouModeId());
        assertEquals(siborikomiId11, kinouModeSiborikomiList.get(10).getSiborikomiId());

        assertEquals(kinouId12,      kinouModeSiborikomiList.get(11).getKinouId());
        assertEquals(kinouModeId12,  kinouModeSiborikomiList.get(11).getKinouModeId());
        assertEquals(siborikomiId12, kinouModeSiborikomiList.get(11).getSiborikomiId());

        assertEquals(kinouId13,      kinouModeSiborikomiList.get(12).getKinouId());
        assertEquals(kinouModeId13,  kinouModeSiborikomiList.get(12).getKinouModeId());
        assertEquals(siborikomiId13, kinouModeSiborikomiList.get(12).getSiborikomiId());

        assertEquals(kinouId14,      kinouModeSiborikomiList.get(13).getKinouId());
        assertEquals(kinouModeId14,  kinouModeSiborikomiList.get(13).getKinouModeId());
        assertEquals(siborikomiId14, kinouModeSiborikomiList.get(13).getSiborikomiId());

        assertEquals(kinouId15,      kinouModeSiborikomiList.get(14).getKinouId());
        assertEquals(kinouModeId15,  kinouModeSiborikomiList.get(14).getKinouModeId());
        assertEquals(siborikomiId15, kinouModeSiborikomiList.get(14).getSiborikomiId());

        deleteTest006();

    }

    @Transactional
    private void insertTest001() {

        ExDBEntityManager exDBEntityManager = SWAKInjector.getInstance(ExDBEntityManager.class);

        if (baseDomManager.getUserGroup("testUserGroup001") == null) {

            AM_UserGroup userGroup001 = new AM_UserGroup();

            userGroup001.setUserGroupCd("testUserGroup001");
            userGroup001.setUserGroupNm("テストユーザーグループ００１");
            userGroup001.setUserGroupSetumei("ユーザーグループ説明００１");

            exDBEntityManager.persist(userGroup001);
        }

        if (baseDomManager.getUserGroup("testUserGroup002") == null) {

            AM_UserGroup userGroup002 = new AM_UserGroup();

            userGroup002.setUserGroupCd("testUserGroup002");
            userGroup002.setUserGroupNm("テストユーザーグループ００２");
            userGroup002.setUserGroupSetumei("ユーザーグループ説明００２");

            exDBEntityManager.persist(userGroup002);
        }

        if (baseDomManager.getUserGroup("testUserGroup003") == null) {

            AM_UserGroup userGroup003 = new AM_UserGroup();

            userGroup003.setUserGroupCd("testUserGroup003");
            userGroup003.setUserGroupNm("テストユーザーグループ００３");
            userGroup003.setUserGroupSetumei("ユーザーグループ説明００３");

            exDBEntityManager.persist(userGroup003);
        }

        if (baseDomManager.getUserGroup("testUserGroup004") == null) {

            AM_UserGroup userGroup004 = new AM_UserGroup();

            userGroup004.setUserGroupCd("testUserGroup004");
            userGroup004.setUserGroupNm("テストユーザーグループ００４");
            userGroup004.setUserGroupSetumei("ユーザーグループ説明００４");

            exDBEntityManager.persist(userGroup004);
        }

        if (baseDomManager.getUserGroup("testUserGroup005") == null) {

            AM_UserGroup userGroup005 = new AM_UserGroup();

            userGroup005.setUserGroupCd("testUserGroup005");
            userGroup005.setUserGroupNm("テストユーザーグループ００５");
            userGroup005.setUserGroupSetumei("ユーザーグループ説明００５");

            exDBEntityManager.persist(userGroup005);
        }

        exDBEntityManager.flush();

        setUserGroupByKousinTime("testUserGroup001", "20160414094626732");
        setUserGroupByKousinTime("testUserGroup002", "20160414094626732");
        setUserGroupByKousinTime("testUserGroup003", "20160414094626732");
        setUserGroupByKousinTime("testUserGroup004", "20160414094626732");
        setUserGroupByKousinTime("testUserGroup005", "20160414094626732");
    }

    @Transactional
    private void insertTest002() {

        ExDBEntityManager exDBEntityManager = SWAKInjector.getInstance(ExDBEntityManager.class);

        if (baseDomManager.getUserGroup("testUserGroup001") == null) {

            AM_UserGroup userGroup001 = new AM_UserGroup();

            userGroup001.setUserGroupCd("testUserGroup001");
            userGroup001.setUserGroupNm("テストユーザーグループ００１");
            userGroup001.setUserGroupSetumei("ユーザーグループ説明００１");

            exDBEntityManager.persist(userGroup001);
        }

        if (baseDomManager.getUserGroup("testUserGroup002") == null) {

            AM_UserGroup userGroup002 = new AM_UserGroup();

            userGroup002.setUserGroupCd("testUserGroup002");
            userGroup002.setUserGroupNm("テストユーザーグループ００２");
            userGroup002.setUserGroupSetumei("ユーザーグループ説明００２");

            exDBEntityManager.persist(userGroup002);
        }

        if (baseDomManager.getUserGroup("testUserGroup003") == null) {

            AM_UserGroup userGroup003 = new AM_UserGroup();

            userGroup003.setUserGroupCd("testUserGroup003");
            userGroup003.setUserGroupNm("テストユーザーグループ００３");
            userGroup003.setUserGroupSetumei("ユーザーグループ説明００３");

            exDBEntityManager.persist(userGroup003);
        }

        exDBEntityManager.flush();

        setUserGroupByKousinTime("testUserGroup001", "20160414235959999");
        setUserGroupByKousinTime("testUserGroup002", "20160415000000000");
        setUserGroupByKousinTime("testUserGroup003", "20160415000000001");
    }

    @Transactional
    private void insertTest004() {

        ExDBEntityManager exDBEntityManager = SWAKInjector.getInstance(ExDBEntityManager.class);

        if (baseDomManager.getUserGroup("testUserGroup001") == null) {

            AM_UserGroup userGroup001 = new AM_UserGroup();

            userGroup001.setUserGroupCd("testUserGroup001");
            userGroup001.setUserGroupNm("テストユーザーグループ００１");
            userGroup001.setUserGroupSetumei("ユーザーグループ説明００１");

            exDBEntityManager.persist(userGroup001);
        }

        exDBEntityManager.flush();

        setUserGroupByKousinTime("testUserGroup001", "20160414235959999");

    }

    @Transactional
    private void insertTest005() {

        ExDBEntityManager exDBEntityManager = SWAKInjector.getInstance(ExDBEntityManager.class);

        if (baseDomManager.getUserGroup("testUserGroup004") == null) {

            AM_UserGroup userGroup001 = new AM_UserGroup();

            userGroup001.setUserGroupCd("testUserGroup004");
            userGroup001.setUserGroupNm("テストユーザーグループ");
            userGroup001.setUserGroupSetumei("ユーザーグループ説明");

            exDBEntityManager.persist(userGroup001);
        }

        if (baseDomManager.getUserGroup("testUserGroup003") == null) {

            AM_UserGroup userGroup002 = new AM_UserGroup();

            userGroup002.setUserGroupCd("testUserGroup003");
            userGroup002.setUserGroupNm("テストユーザーグループ");
            userGroup002.setUserGroupSetumei("ユーザーグループ説明");

            exDBEntityManager.persist(userGroup002);
        }

        if (baseDomManager.getUserGroup("testUserGroup005") == null) {

            AM_UserGroup userGroup003 = new AM_UserGroup();

            userGroup003.setUserGroupCd("testUserGroup005");
            userGroup003.setUserGroupNm("テストユーザーグループ");
            userGroup003.setUserGroupSetumei("ユーザーグループ説明");

            exDBEntityManager.persist(userGroup003);
        }

        if (baseDomManager.getUserGroup("testUserGroup001") == null) {

            AM_UserGroup userGroup004 = new AM_UserGroup();

            userGroup004.setUserGroupCd("testUserGroup001");
            userGroup004.setUserGroupNm("テストユーザーグループ");
            userGroup004.setUserGroupSetumei("ユーザーグループ説明");

            exDBEntityManager.persist(userGroup004);
        }

        if (baseDomManager.getUserGroup("testUserGroup002") == null) {

            AM_UserGroup userGroup005 = new AM_UserGroup();

            userGroup005.setUserGroupCd("testUserGroup002");
            userGroup005.setUserGroupNm("テストユーザーグループ");
            userGroup005.setUserGroupSetumei("ユーザーグループ説明");

            exDBEntityManager.persist(userGroup005);
        }

        if (baseDomManager.getUserGroup("testUserGroup006") == null) {

            AM_UserGroup userGroup006 = new AM_UserGroup();

            userGroup006.setUserGroupCd("testUserGroup006");
            userGroup006.setUserGroupNm("テストユーザーグループ");
            userGroup006.setUserGroupSetumei("ユーザーグループ説明");

            exDBEntityManager.persist(userGroup006);
        }

        exDBEntityManager.flush();

        setUserGroupByKousinTime("testUserGroup001", "20160414235959999");
        setUserGroupByKousinTime("testUserGroup002", "20160414235959999");
        setUserGroupByKousinTime("testUserGroup003", "20160414235959999");
        setUserGroupByKousinTime("testUserGroup004", "20160414235959999");
        setUserGroupByKousinTime("testUserGroup005", "20160414235959999");
        setUserGroupByKousinTime("testUserGroup006", "20160414235959999");

    }


    @Transactional
    private void insertTest006() {

        ExDBEntityManager exDBEntityManager = SWAKInjector.getInstance(ExDBEntityManager.class);

        if (baseDomManager.getKinou("testKinouID01") == null) {

            AS_Kinou kinou = new AS_Kinou();
            kinou.setKinouId("testKinouID01");

            AS_KinouMode kinouMode01 = kinou.createKinouMode();
            kinouMode01.setKinouModeId("testKinouModeID01");

            AS_KinouModeSiborikomi kinouModeSiborikomi01 = kinouMode01.createKinouModeSiborikomi();
            kinouModeSiborikomi01.setSiborikomiId("testSiborikomiID04");
            kinouModeSiborikomi01.setSiborikomiNm("機能ＤＡＯテストデータ");

            AS_KinouModeSiborikomi kinouModeSiborikomi02 = kinouMode01.createKinouModeSiborikomi();
            kinouModeSiborikomi02.setSiborikomiId("testSiborikomiID03");
            kinouModeSiborikomi02.setSiborikomiNm("機能ＤＡＯテストデータ");

            AS_KinouModeSiborikomi kinouModeSiborikomi03 = kinouMode01.createKinouModeSiborikomi();
            kinouModeSiborikomi03.setSiborikomiId("testSiborikomiID05");
            kinouModeSiborikomi03.setSiborikomiNm("機能ＤＡＯテストデータ");

            AS_KinouModeSiborikomi kinouModeSiborikomi04 = kinouMode01.createKinouModeSiborikomi();
            kinouModeSiborikomi04.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi04.setSiborikomiNm("機能ＤＡＯテストデータ");

            AS_KinouModeSiborikomi kinouModeSiborikomi05 = kinouMode01.createKinouModeSiborikomi();
            kinouModeSiborikomi05.setSiborikomiId("testSiborikomiID02");
            kinouModeSiborikomi05.setSiborikomiNm("機能ＤＡＯテストデータ");

            AS_KinouMode kinouMode02 = kinou.createKinouMode();
            kinouMode02.setKinouModeId("testKinouModeID05");

            AS_KinouModeSiborikomi kinouModeSiborikomi11 = kinouMode02.createKinouModeSiborikomi();
            kinouModeSiborikomi11.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi11.setSiborikomiNm("機能ＤＡＯテストデータ");

            AS_KinouMode kinouMode03 = kinou.createKinouMode();
            kinouMode03.setKinouModeId("testKinouModeID04");

            AS_KinouModeSiborikomi kinouModeSiborikomi21 = kinouMode03.createKinouModeSiborikomi();
            kinouModeSiborikomi21.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi21.setSiborikomiNm("機能ＤＡＯテストデータ");

            AS_KinouMode kinouMode04 = kinou.createKinouMode();
            kinouMode04.setKinouModeId("testKinouModeID06");

            AS_KinouModeSiborikomi kinouModeSiborikomi31 = kinouMode04.createKinouModeSiborikomi();
            kinouModeSiborikomi31.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi31.setSiborikomiNm("機能ＤＡＯテストデータ");

            AS_KinouMode kinouMode05 = kinou.createKinouMode();
            kinouMode05.setKinouModeId("testKinouModeID02");

            AS_KinouModeSiborikomi kinouModeSiborikomi41 = kinouMode05.createKinouModeSiborikomi();
            kinouModeSiborikomi41.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi41.setSiborikomiNm("機能ＤＡＯテストデータ");

            AS_KinouMode kinouMode06 = kinou.createKinouMode();
            kinouMode06.setKinouModeId("testKinouModeID03");

            AS_KinouModeSiborikomi kinouModeSiborikomi51 = kinouMode06.createKinouModeSiborikomi();
            kinouModeSiborikomi51.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi51.setSiborikomiNm("機能ＤＡＯテストデータ");

            exDBEntityManager.persist(kinou);
        }

        if (baseDomManager.getKinou("testKinouID05") == null) {

            AS_Kinou kinou = new AS_Kinou();
            kinou.setKinouId("testKinouID05");

            AS_KinouMode kinouMode = kinou.createKinouMode();
            kinouMode.setKinouModeId("testKinouModeID01");

            AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.createKinouModeSiborikomi();
            kinouModeSiborikomi.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi.setSiborikomiNm("機能ＤＡＯテストデータ");

            exDBEntityManager.persist(kinou);
        }

        if (baseDomManager.getKinou("testKinouID04") == null) {

            AS_Kinou kinou = new AS_Kinou();
            kinou.setKinouId("testKinouID04");

            AS_KinouMode kinouMode = kinou.createKinouMode();
            kinouMode.setKinouModeId("testKinouModeID01");

            AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.createKinouModeSiborikomi();
            kinouModeSiborikomi.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi.setSiborikomiNm("機能ＤＡＯテストデータ");

            exDBEntityManager.persist(kinou);
        }

        if (baseDomManager.getKinou("testKinouID06") == null) {

            AS_Kinou kinou = new AS_Kinou();
            kinou.setKinouId("testKinouID06");

            AS_KinouMode kinouMode = kinou.createKinouMode();
            kinouMode.setKinouModeId("testKinouModeID01");

            AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.createKinouModeSiborikomi();
            kinouModeSiborikomi.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi.setSiborikomiNm("機能ＤＡＯテストデータ");

            exDBEntityManager.persist(kinou);
        }

        if (baseDomManager.getKinou("testKinouID02") == null) {

            AS_Kinou kinou = new AS_Kinou();
            kinou.setKinouId("testKinouID02");

            AS_KinouMode kinouMode = kinou.createKinouMode();
            kinouMode.setKinouModeId("testKinouModeID01");

            AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.createKinouModeSiborikomi();
            kinouModeSiborikomi.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi.setSiborikomiNm("機能ＤＡＯテストデータ");

            exDBEntityManager.persist(kinou);
        }

        if (baseDomManager.getKinou("testKinouID03") == null) {

            AS_Kinou kinou = new AS_Kinou();
            kinou.setKinouId("testKinouID03");

            AS_KinouMode kinouMode = kinou.createKinouMode();
            kinouMode.setKinouModeId("testKinouModeID01");

            AS_KinouModeSiborikomi kinouModeSiborikomi = kinouMode.createKinouModeSiborikomi();
            kinouModeSiborikomi.setSiborikomiId("testSiborikomiID01");
            kinouModeSiborikomi.setSiborikomiNm("機能ＤＡＯテストデータ");

            exDBEntityManager.persist(kinou);
        }

        exDBEntityManager.flush();

        setKinouModeSiborikomiByKousinTime("testKinouID01", "testKinouModeID01", "testSiborikomiID04", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID01", "testKinouModeID01", "testSiborikomiID03", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID01", "testKinouModeID01", "testSiborikomiID05", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID01", "testKinouModeID01", "testSiborikomiID01", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID01", "testKinouModeID01", "testSiborikomiID02", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID01", "testKinouModeID05", "testSiborikomiID01", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID01", "testKinouModeID04", "testSiborikomiID01", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID01", "testKinouModeID06", "testSiborikomiID01", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID01", "testKinouModeID02", "testSiborikomiID01", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID01", "testKinouModeID03", "testSiborikomiID01", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID05", "testKinouModeID01", "testSiborikomiID01", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID04", "testKinouModeID01", "testSiborikomiID01", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID06", "testKinouModeID01", "testSiborikomiID01", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID02", "testKinouModeID01", "testSiborikomiID01", "20160414235959999");
        setKinouModeSiborikomiByKousinTime("testKinouID03", "testKinouModeID01", "testSiborikomiID01", "20160414235959999");

    }

    @Transactional
    private void deleteTest001() {

        baseDomManager.clear();

        if (baseDomManager.getUserGroup("testUserGroup001") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup001"));

        }

        if (baseDomManager.getUserGroup("testUserGroup002") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup002"));

        }

        if (baseDomManager.getUserGroup("testUserGroup003") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup003"));
        }

        if (baseDomManager.getUserGroup("testUserGroup004") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup004"));

        }

        if (baseDomManager.getUserGroup("testUserGroup005") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup005"));

        }
    }

    @Transactional
    private void deleteTest002() {

        baseDomManager.clear();

        if (baseDomManager.getUserGroup("testUserGroup001") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup001"));

        }

        if (baseDomManager.getUserGroup("testUserGroup002") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup002"));

        }

        if (baseDomManager.getUserGroup("testUserGroup003") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup003"));
        }
    }

    @Transactional
    private void deleteTest004() {

        baseDomManager.clear();

        if (baseDomManager.getUserGroup("testUserGroup001") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup001"));

        }

    }

    @Transactional
    private void deleteTest005() {

        baseDomManager.clear();

        if (baseDomManager.getUserGroup("testUserGroup001") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup001"));

        }

        if (baseDomManager.getUserGroup("testUserGroup002") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup002"));

        }

        if (baseDomManager.getUserGroup("testUserGroup003") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup003"));
        }

        if (baseDomManager.getUserGroup("testUserGroup004") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup004"));

        }

        if (baseDomManager.getUserGroup("testUserGroup005") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup005"));

        }

        if (baseDomManager.getUserGroup("testUserGroup006") != null) {

            baseDomManager.delete(baseDomManager.getUserGroup("testUserGroup006"));

        }
    }

    @Transactional
    private void deleteTest006() {

        baseDomManager.clear();

        if (baseDomManager.getKinou("testKinouID01") != null) {

            baseDomManager.delete(baseDomManager.getKinou("testKinouID01"));

        }

        if (baseDomManager.getKinou("testKinouID02") != null) {

            baseDomManager.delete(baseDomManager.getKinou("testKinouID02"));

        }

        if (baseDomManager.getKinou("testKinouID03") != null) {

            baseDomManager.delete(baseDomManager.getKinou("testKinouID03"));

        }

        if (baseDomManager.getKinou("testKinouID04") != null) {

            baseDomManager.delete(baseDomManager.getKinou("testKinouID04"));

        }

        if (baseDomManager.getKinou("testKinouID05") != null) {

            baseDomManager.delete(baseDomManager.getKinou("testKinouID05"));

        }

        if (baseDomManager.getKinou("testKinouID06") != null) {

            baseDomManager.delete(baseDomManager.getKinou("testKinouID06"));

        }

    }

    @Transactional
    private void setUserGroupByKousinTime(String pUserGroupCd, String pKousinTime) {

        QAM_UserGroup qUserGroup = new QAM_UserGroup();

        String jpql = $UPDATE + qUserGroup.AM_UserGroup() + $SET(qUserGroup.kousinTime.eq(pKousinTime)) + $WHERE + qUserGroup.userGroupCd.eq(pUserGroupCd);
        em.createJPQL(jpql).bind(qUserGroup).executeUpdate();

    }

    @Transactional
    private void setKinouModeSiborikomiByKousinTime(String pKinouId, String pKinouModeId, String pSiborikomiId, String pKousinTime) {

        QAS_KinouModeSiborikomi qKinouModeSiborikomi = new QAS_KinouModeSiborikomi();

        String jpql = $UPDATE + qKinouModeSiborikomi.AS_KinouModeSiborikomi() + $SET(qKinouModeSiborikomi.kousinTime.eq(pKousinTime)) +
            $WHERE + qKinouModeSiborikomi.kinouId.eq(pKinouId) + $AND + qKinouModeSiborikomi.kinouModeId.eq(pKinouModeId) + $AND + qKinouModeSiborikomi.siborikomiId.eq(pSiborikomiId);
        em.createJPQL(jpql).bind(qKinouModeSiborikomi).executeUpdate();

    }
}
