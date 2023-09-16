
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * パスワード有効期間区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PasswordYuukouKikanKbn</td><td colspan="3">パスワード有効期間区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>無制限</td></tr>
 *  <tr><td align="center">○</td><td>{@link #ARI_NOEDIT}</td><td>&quot;2&quot;</td><td>期限あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI_EDIT}</td><td>&quot;3&quot;</td><td>期限を変更</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NEW NEW}<br />(新規)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>無制限</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI_EDIT}</td><td>&quot;3&quot;</td><td>期限を設定</td></tr>
 * </table>
 */
public class C_PasswordYuukouKikanKbn extends Classification<C_PasswordYuukouKikanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PasswordYuukouKikanKbn NONE = new C_PasswordYuukouKikanKbn("1");

    public static final C_PasswordYuukouKikanKbn ARI_NOEDIT = new C_PasswordYuukouKikanKbn("2");

    public static final C_PasswordYuukouKikanKbn ARI_EDIT = new C_PasswordYuukouKikanKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NEW = "2";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, ARI_NOEDIT, "ARI_NOEDIT", true);
        addPattern(PATTERN_DEFAULT, ARI_EDIT, "ARI_EDIT", false);


        addPattern(PATTERN_NEW, NONE, "NONE", true);
        addPattern(PATTERN_NEW, ARI_EDIT, "ARI_EDIT", false);


        lock(C_PasswordYuukouKikanKbn.class);
    }

    private C_PasswordYuukouKikanKbn(String value) {
        super(value);
    }

    public static C_PasswordYuukouKikanKbn valueOf(String value) {
        return valueOf(C_PasswordYuukouKikanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PasswordYuukouKikanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PasswordYuukouKikanKbn.class, patternId, value);
    }
}
