package yuyu.infr.security;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBTransactional;
import jp.co.slcs.swak.db.ExDBTransactional.TransactionalCode;
import jp.co.slcs.swak.util.security.InvalidPasswordException;
import jp.co.slcs.swak.util.security.SecurityPolicy;
import jp.co.slcs.swak.util.security.SecurityPolicyConfig;
import jp.co.slcs.swak.util.string.StringUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AT_PasswordRireki;
import yuyu.def.db.id.PKAM_User;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * {@link YuyuSecurityPolicy} の UnitTest です。<br />
 * 主なテスト内容は「過去パスワード履歴チェックが正しく機能しているか」です。
 */
@RunWith(SWAKTestRunner.class)
public class YuyuSecurityPolicyTest {

    @Inject
    private static Logger log;

    @Inject
    private BaseDomManager domManager;

    @Inject
    SecurityPolicy policy;

    @Inject
    private SecurityPolicyConfig config;

    private static final String testUserId = "UnitTestUser";
    private static final String testUserNm = "単体テスト用ユーザー";
    static boolean testUserAlreadyExists = false;

    static final List<String> plaintextPasswords;
    static {
        Builder<String> builder = ImmutableList.builder();
        for (int i = 1; i <= SecurityPolicyConfig.instance.getPasswordMaxrireki() + 2; i++) {
            builder.add("Password" + i);
        }
        plaintextPasswords = builder.build().reverse();
    }

    @BeforeClass
    public static void init() {
        ExDBTransactional.runInBizLogicTransaction(
            new TransactionalCode() {
                @Override
                public void accept(ExDBEntityManager entityManager) {
                    PKAM_User pkUser = new PKAM_User(testUserId);
                    AM_User testUser = entityManager.findByPK(pkUser);

                    if (testUser != null) {
                        testUserAlreadyExists = true;
                        throw new IllegalStateException("TestUser '" + testUserId + "' already exists.");
                    }

                    testUser = new AM_User(testUserId);
                    testUser.setUserNm(testUserNm);

                    for (String plaintextPassword: Lists.reverse(plaintextPasswords)) {
                        testUser.setPassword(plaintextPassword);
                        entityManager.persist(testUser);
                        entityManager.flush();
                    }
                }
            }
        );
    }

    @AfterClass
    public static void destroy() {
        if (testUserAlreadyExists) return;

        ExDBTransactional.runInBizLogicTransaction(
            new TransactionalCode() {
                @Override
                public void accept(ExDBEntityManager entityManager) {
                    PKAM_User pkUser = new PKAM_User(testUserId);
                    AM_User testUser = entityManager.findByPK(pkUser);
                    entityManager.remove(testUser);
                }
            }
        );
    }

    @Test
    public void test00_dataCheck() {
        AM_User user = domManager.getUser(testUserId);
        assertNotNull(user);

        assertEquals(testUserId, user.getUserId());

        assertEquals(config.getPasswordMaxrireki() + 1, user.getPasswordRirekis().size());

        assertEquals(policy.encryptPassword(testUserId, plaintextPasswords.get(0)), user.getPassword());
    }

    @Test(expected=InvalidPasswordException.class)
    public void test01_GetPasswordRirekiString() {
        for (String newPassword : Iterables.limit(plaintextPasswords, config.getPasswordMaxrireki())) {
            policy.checkPassword(newPassword, testUserId);
        }
    }

    @Test
    public void test02_GetPasswordRirekiString() {
        for (String newPassword : Iterables.skip(plaintextPasswords, config.getPasswordMaxrireki())) {
            policy.checkPassword(newPassword, testUserId);
        }
    }

    @Test
    public void test03_Digest() {
        AM_User user = domManager.getUser(testUserId);
        log.debug(
            "password: {}, encrypted: {}",
            StringUtil.quote(user.getPassword()),
            StringUtil.quote(policy.encryptPassword(user.getUserId(), user.getPassword()))
        );
        for (AT_PasswordRireki rireki :
            YuyuSecurityPolicy.passwordRirekiOrder.reverse().sortedCopy(user.getPasswordRirekis())
        ) {
            log.debug(
                "password: {}, encrypted: {}",
                StringUtil.quote(rireki.getPassword()),
                StringUtil.quote(policy.encryptPassword(rireki.getUserId(), rireki.getPassword()))
            );
        }
    }
}
