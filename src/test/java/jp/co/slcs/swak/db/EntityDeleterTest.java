package jp.co.slcs.swak.db;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

import com.google.common.collect.Lists;

/**
 * EntityDeleter,MultipleEntityDeleterテスト用のJUnitテスト<br />
 * テストコードは、全体実行以外使用しないでください。（バックアップ→削除処理→復元まで行いますが、すべてtestメソッドを使用しているため）<br />
 * アクセスログは、適当にテストコード中のIDを書き換える　または　テストコード中のIDのアクセスログを追加してください。<br />
 */
@RunWith(SWAKTestRunner.class)
public class EntityDeleterTest extends AbstractTest{

    @Inject
    private static Logger logger;
    @Inject
    private BaseDomManager manager;

    private static List<AT_AccessLog> logBack = Lists.newArrayList();
    private static List<AS_Kinou> kinouBack = Lists.newArrayList();
    //    private static List<AM_Role> roles = Lists.newArrayList();

    @Test
    @TestOrder(10000)
    @Transactional
    public void test0000() {
        logger.debug("================================== backup start ==================================");
        AT_AccessLog accesslog = manager.getAccessLog("0012e2y1j18t3r7ll1");
        accesslog.getAccessLogSyousais();
        accesslog.detach();
        logBack.add(accesslog);

        AS_Kinou kinou = manager.getKinou("roletouroku");
        for (AS_KinouMode mode : kinou.getKinouModes()) {
            mode.getKinouKengens();
        }
        kinou.detach();
        kinouBack.add(kinou);

        logger.debug("================================== backup  end  ==================================");
    }

    @Test
    @TestOrder(10010)
    @Transactional
    public void test0010() {
        logger.debug("================================== test0010 start ==================================");
        AT_AccessLog accesslog = manager.getAccessLog("0012e2y1j18t3r7ll1");
        if (accesslog == null) {
            logger.debug("アクセスログIDのデータが存在しません。コード中のIDを書き換えるか、データを作成してください。");
            assertTrue(false);
        }
        try (EntityDeleter<AT_AccessLog> deleter = new EntityDeleter<>();
            ){
            deleter.add(accesslog);
        }
        AT_AccessLog tester = manager.getAccessLog("0012e2y1j18t3r7ll1");
        assertTrue(tester == null);
        logger.debug("================================== test0010  end  ==================================");
    }


    @Test
    @TestOrder(10020)
    @Transactional
    public void test0020() {
        logger.debug("================================== test0020 start ==================================");
        AS_Kinou kinou = manager.getKinou("roletouroku");
        try (MultipleEntityDeleter deleter = new MultipleEntityDeleter();
            ){
            deleter.add(kinou);
        }
        AS_Kinou tester = manager.getKinou("roletouroku");
        assertTrue(tester == null);
        logger.debug("================================== test0020  end  ==================================");
    }

    @Test
    @TestOrder(19999)
    @Transactional
    public void test9999() {
        logger.debug("================================== restore start ==================================");
        manager.insert(logBack);
        manager.insert(kinouBack);
        logger.debug("================================== restore  end  ==================================");
    }

}
