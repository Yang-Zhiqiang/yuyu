
package yuyu.def.classification;

import jp.co.slcs.swak.core.accesslog.AccessLog;

/**
 * アクセスログ種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AccessLogSyubetuKbn</td><td colspan="3">アクセスログ種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="32">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGIN}</td><td>&quot;Login&quot;</td><td>ログイン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGIN_FAILURE}</td><td>&quot;LoginFailure&quot;</td><td>ログイン失敗</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOCKOUT}</td><td>&quot;Lockout&quot;</td><td>アカウントロック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNLOCK}</td><td>&quot;Unlock&quot;</td><td>アカウントロック解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGOUT}</td><td>&quot;Logout&quot;</td><td>ログアウト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGOUT_AUTO}</td><td>&quot;LogoutAuto&quot;</td><td>自動ログアウト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIMEOUT}</td><td>&quot;Timeout&quot;</td><td>タイムアウト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUTH_VIOLATION}</td><td>&quot;AuthViolation&quot;</td><td>権限違反</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USER_ADD}</td><td>&quot;UserAdd&quot;</td><td>ユーザー登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USER_MODIFY}</td><td>&quot;UserModify&quot;</td><td>ユーザー変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USER_DELETE}</td><td>&quot;UserDelete&quot;</td><td>ユーザー削除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PASSWORD_ALTER}</td><td>&quot;PasswordAlter&quot;</td><td>パスワード変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DB_SELECT}</td><td>&quot;DB-Select&quot;</td><td>DB（参照）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DB_INSERT}</td><td>&quot;DB-Insert&quot;</td><td>DB（追加）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DB_UPDATE}</td><td>&quot;DB-Update&quot;</td><td>DB（更新）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DB_DELETE}</td><td>&quot;DB-Delete&quot;</td><td>DB（削除）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DB_COMMIT}</td><td>&quot;DB-Commit&quot;</td><td>DB（コミット）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DB_ROLLBACK}</td><td>&quot;DB-Rollback&quot;</td><td>DB（ロールバック）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DB_DDL}</td><td>&quot;DB-DDL&quot;</td><td>DB（定義変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ACTION_BEGIN}</td><td>&quot;ActionBegin&quot;</td><td>Action開始</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ACTION_END}</td><td>&quot;ActionEnd&quot;</td><td>Action終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ACTION_FAILURE}</td><td>&quot;ActionFailure&quot;</td><td>Action失敗</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REPORT}</td><td>&quot;Report&quot;</td><td>帳票出力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KADOU_TIME_PAST}</td><td>&quot;KadouTimePast&quot;</td><td>稼働時間外アクセス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BATCH_BEGIN}</td><td>&quot;BatchBegin&quot;</td><td>Batch開始</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BATCH_END}</td><td>&quot;BatchEnd&quot;</td><td>Batch終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FILE_READ}</td><td>&quot;FileRead&quot;</td><td>ファイル読み込み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FILE_WRITE}</td><td>&quot;FileWrite&quot;</td><td>ファイル書き込み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FILE_MOVE}</td><td>&quot;FileMove&quot;</td><td>ファイル移動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FILE_COPY}</td><td>&quot;FileCopy&quot;</td><td>ファイルコピー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FILE_REMOVE}</td><td>&quot;FileRemove&quot;</td><td>ファイル削除</td></tr>
 * </table>
 */
@SuppressWarnings("unchecked")
public class C_AccessLogSyubetuKbn extends AccessLog<C_AccessLogSyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AccessLogSyubetuKbn BLNK = new C_AccessLogSyubetuKbn("0");

    public static final C_AccessLogSyubetuKbn LOGIN = new C_AccessLogSyubetuKbn("Login");

    public static final C_AccessLogSyubetuKbn LOGIN_FAILURE = new C_AccessLogSyubetuKbn("LoginFailure");

    public static final C_AccessLogSyubetuKbn LOCKOUT = new C_AccessLogSyubetuKbn("Lockout");

    public static final C_AccessLogSyubetuKbn UNLOCK = new C_AccessLogSyubetuKbn("Unlock");

    public static final C_AccessLogSyubetuKbn LOGOUT = new C_AccessLogSyubetuKbn("Logout");

    public static final C_AccessLogSyubetuKbn LOGOUT_AUTO = new C_AccessLogSyubetuKbn("LogoutAuto");

    public static final C_AccessLogSyubetuKbn TIMEOUT = new C_AccessLogSyubetuKbn("Timeout");

    public static final C_AccessLogSyubetuKbn AUTH_VIOLATION = new C_AccessLogSyubetuKbn("AuthViolation");

    public static final C_AccessLogSyubetuKbn USER_ADD = new C_AccessLogSyubetuKbn("UserAdd");

    public static final C_AccessLogSyubetuKbn USER_MODIFY = new C_AccessLogSyubetuKbn("UserModify");

    public static final C_AccessLogSyubetuKbn USER_DELETE = new C_AccessLogSyubetuKbn("UserDelete");

    public static final C_AccessLogSyubetuKbn PASSWORD_ALTER = new C_AccessLogSyubetuKbn("PasswordAlter");

    public static final C_AccessLogSyubetuKbn DB_SELECT = new C_AccessLogSyubetuKbn("DB-Select");

    public static final C_AccessLogSyubetuKbn DB_INSERT = new C_AccessLogSyubetuKbn("DB-Insert");

    public static final C_AccessLogSyubetuKbn DB_UPDATE = new C_AccessLogSyubetuKbn("DB-Update");

    public static final C_AccessLogSyubetuKbn DB_DELETE = new C_AccessLogSyubetuKbn("DB-Delete");

    public static final C_AccessLogSyubetuKbn DB_COMMIT = new C_AccessLogSyubetuKbn("DB-Commit");

    public static final C_AccessLogSyubetuKbn DB_ROLLBACK = new C_AccessLogSyubetuKbn("DB-Rollback");

    public static final C_AccessLogSyubetuKbn DB_DDL = new C_AccessLogSyubetuKbn("DB-DDL");

    public static final C_AccessLogSyubetuKbn ACTION_BEGIN = new C_AccessLogSyubetuKbn("ActionBegin");

    public static final C_AccessLogSyubetuKbn ACTION_END = new C_AccessLogSyubetuKbn("ActionEnd");

    public static final C_AccessLogSyubetuKbn ACTION_FAILURE = new C_AccessLogSyubetuKbn("ActionFailure");

    public static final C_AccessLogSyubetuKbn REPORT = new C_AccessLogSyubetuKbn("Report");

    public static final C_AccessLogSyubetuKbn KADOU_TIME_PAST = new C_AccessLogSyubetuKbn("KadouTimePast");

    public static final C_AccessLogSyubetuKbn BATCH_BEGIN = new C_AccessLogSyubetuKbn("BatchBegin");

    public static final C_AccessLogSyubetuKbn BATCH_END = new C_AccessLogSyubetuKbn("BatchEnd");

    public static final C_AccessLogSyubetuKbn FILE_READ = new C_AccessLogSyubetuKbn("FileRead");

    public static final C_AccessLogSyubetuKbn FILE_WRITE = new C_AccessLogSyubetuKbn("FileWrite");

    public static final C_AccessLogSyubetuKbn FILE_MOVE = new C_AccessLogSyubetuKbn("FileMove");

    public static final C_AccessLogSyubetuKbn FILE_COPY = new C_AccessLogSyubetuKbn("FileCopy");

    public static final C_AccessLogSyubetuKbn FILE_REMOVE = new C_AccessLogSyubetuKbn("FileRemove");


    @SuppressWarnings("hiding")
    public static final String PATTERN_DEFAULT = "1";


    static {

        importAllSuperValues(AccessLog.class, C_AccessLogSyubetuKbn.class);


        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, LOGIN, "LOGIN", false);
        addPattern(PATTERN_DEFAULT, LOGIN_FAILURE, "LOGIN_FAILURE", false);
        addPattern(PATTERN_DEFAULT, LOCKOUT, "LOCKOUT", false);
        addPattern(PATTERN_DEFAULT, UNLOCK, "UNLOCK", false);
        addPattern(PATTERN_DEFAULT, LOGOUT, "LOGOUT", false);
        addPattern(PATTERN_DEFAULT, LOGOUT_AUTO, "LOGOUT_AUTO", false);
        addPattern(PATTERN_DEFAULT, TIMEOUT, "TIMEOUT", false);
        addPattern(PATTERN_DEFAULT, AUTH_VIOLATION, "AUTH_VIOLATION", false);
        addPattern(PATTERN_DEFAULT, USER_ADD, "USER_ADD", false);
        addPattern(PATTERN_DEFAULT, USER_MODIFY, "USER_MODIFY", false);
        addPattern(PATTERN_DEFAULT, USER_DELETE, "USER_DELETE", false);
        addPattern(PATTERN_DEFAULT, PASSWORD_ALTER, "PASSWORD_ALTER", false);
        addPattern(PATTERN_DEFAULT, DB_SELECT, "DB_SELECT", false);
        addPattern(PATTERN_DEFAULT, DB_INSERT, "DB_INSERT", false);
        addPattern(PATTERN_DEFAULT, DB_UPDATE, "DB_UPDATE", false);
        addPattern(PATTERN_DEFAULT, DB_DELETE, "DB_DELETE", false);
        addPattern(PATTERN_DEFAULT, DB_COMMIT, "DB_COMMIT", false);
        addPattern(PATTERN_DEFAULT, DB_ROLLBACK, "DB_ROLLBACK", false);
        addPattern(PATTERN_DEFAULT, DB_DDL, "DB_DDL", false);
        addPattern(PATTERN_DEFAULT, ACTION_BEGIN, "ACTION_BEGIN", false);
        addPattern(PATTERN_DEFAULT, ACTION_END, "ACTION_END", false);
        addPattern(PATTERN_DEFAULT, ACTION_FAILURE, "ACTION_FAILURE", false);
        addPattern(PATTERN_DEFAULT, REPORT, "REPORT", false);
        addPattern(PATTERN_DEFAULT, KADOU_TIME_PAST, "KADOU_TIME_PAST", false);
        addPattern(PATTERN_DEFAULT, BATCH_BEGIN, "BATCH_BEGIN", false);
        addPattern(PATTERN_DEFAULT, BATCH_END, "BATCH_END", false);
        addPattern(PATTERN_DEFAULT, FILE_READ, "FILE_READ", false);
        addPattern(PATTERN_DEFAULT, FILE_WRITE, "FILE_WRITE", false);
        addPattern(PATTERN_DEFAULT, FILE_MOVE, "FILE_MOVE", false);
        addPattern(PATTERN_DEFAULT, FILE_COPY, "FILE_COPY", false);
        addPattern(PATTERN_DEFAULT, FILE_REMOVE, "FILE_REMOVE", false);


        lock(C_AccessLogSyubetuKbn.class);
    }

    private C_AccessLogSyubetuKbn(String value) {
        super(value);
    }

    public static C_AccessLogSyubetuKbn valueOf(String value) {
        return valueOf(C_AccessLogSyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AccessLogSyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AccessLogSyubetuKbn.class, patternId, value);
    }
}
