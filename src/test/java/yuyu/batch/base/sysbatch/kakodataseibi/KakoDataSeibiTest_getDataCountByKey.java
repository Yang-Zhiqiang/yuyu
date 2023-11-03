package yuyu.batch.base.sysbatch.kakodataseibi;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.hibernate.JDBCException;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_UserGroup;
import yuyu.def.db.meta.QAM_UserGroup;
import yuyu.def.db.meta.QAT_MyMenu;
import yuyu.testinfr.AbstractTest;

/**
 * 過去データ整備DAOクラスの<br />
 * getDataCount のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class KakoDataSeibiTest_getDataCountByKey extends AbstractTest {

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
            kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
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

        Long resultCount = kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);

        assertEquals(Long.valueOf(5), resultCount);

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
            kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
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

        Long resultCount = kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);

        assertEquals(Long.valueOf(5), resultCount);

        deleteTest001();

    }

    @Test
    @Transactional
    public void test005() {

        insertTest002();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        Long resultCount = kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);

        assertEquals(Long.valueOf(2), resultCount);

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
            kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);
        } catch (Exception e) {
            assertThat(e, instanceOf(JDBCException.class));
        }

        deleteTest002();

    }

    @Test
    @Transactional
    public void test007() {

        insertTest002();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        try {
            kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
        }

        deleteTest002();

    }

    @Test
    @Transactional
    public void test008() {

        insertTest002();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        try {
            kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);
        } catch (Exception e) {
            assertThat(e, instanceOf(IllegalArgumentException.class));
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

        Long resultCount = kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);

        assertEquals(Long.valueOf(2), resultCount);

        deleteTest002();

    }

    @Test
    @Transactional
    public void test010() {

        insertTest002();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415";

        Long resultCount = kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);

        assertEquals(Long.valueOf(1), resultCount);

        deleteTest002();

    }

    @Test
    @Transactional
    public void test011() {

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        Long resultCount = kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);

        assertEquals(Long.valueOf(0), resultCount);
    }

    @Test
    @Transactional
    public void test012() {

        insertTest004();

        String tableId = "AM_UserGroup";
        String sakujyoKey = "KOUSINTIME";
        String sakujyokijynYmd = "20160415000000000";

        Long resultCount = kakoDataSeibiDao.getDataCountByKey(tableId, sakujyoKey, sakujyokijynYmd);

        assertEquals(Long.valueOf(1), resultCount);

        deleteTest004();

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
    private void setUserGroupByKousinTime(String pUserGroupCd, String pKousinTime) {

        QAM_UserGroup qUserGroup = new QAM_UserGroup();

        String jpql = $UPDATE + qUserGroup.AM_UserGroup() + $SET(qUserGroup.kousinTime.eq(pKousinTime)) + $WHERE + qUserGroup.userGroupCd.eq(pUserGroupCd);
        em.createJPQL(jpql).bind(qUserGroup).executeUpdate();

    }

    @Transactional
    private void setMyMenuByKousinTime(String pUserId, String pKinouId, String pKousinTime) {

        QAT_MyMenu qMyMenu = new QAT_MyMenu();

        String jpql = $UPDATE + qMyMenu.AT_MyMenu() + $SET(qMyMenu.kousinTime.eq(pKousinTime)) + $WHERE + qMyMenu.userId.eq(pUserId) + $AND + qMyMenu.kinouId.eq(pKinouId);
        em.createJPQL(jpql).bind(qMyMenu).executeUpdate();

    }
}
