package yuyu.common.biz.bzcommon;

/**
 *  業務共通 共通 DBロック管理ユーティリティ
 */
public class DbLockControlUtil {

    public static boolean lock(DbLockControlBean poSyoriBean) {
        return true;
    }

    public static boolean isLocked(DbLockControlBean poSyoriBean) {
        return false;
    }

    public static void unLock(DbLockControlBean poSyoriBean) {
        return;
    }

}
