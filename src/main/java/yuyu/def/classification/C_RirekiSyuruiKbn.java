
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 履歴種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RirekiSyuruiKbn</td><td colspan="3">履歴種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NEW}</td><td>&quot;1&quot;</td><td>新規履歴</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EDIT}</td><td>&quot;2&quot;</td><td>変更履歴</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DELETE}</td><td>&quot;3&quot;</td><td>削除履歴</td></tr>
 * </table>
 */
public class C_RirekiSyuruiKbn extends Classification<C_RirekiSyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RirekiSyuruiKbn NEW = new C_RirekiSyuruiKbn("1");

    public static final C_RirekiSyuruiKbn EDIT = new C_RirekiSyuruiKbn("2");

    public static final C_RirekiSyuruiKbn DELETE = new C_RirekiSyuruiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NEW, "NEW", true);
        addPattern(PATTERN_DEFAULT, EDIT, "EDIT", false);
        addPattern(PATTERN_DEFAULT, DELETE, "DELETE", false);


        lock(C_RirekiSyuruiKbn.class);
    }

    private C_RirekiSyuruiKbn(String value) {
        super(value);
    }

    public static C_RirekiSyuruiKbn valueOf(String value) {
        return valueOf(C_RirekiSyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RirekiSyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RirekiSyuruiKbn.class, patternId, value);
    }
}
