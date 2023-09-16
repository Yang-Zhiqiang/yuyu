
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 抽出処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyuusyoriKbn</td><td colspan="3">抽出処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENSUUKAKUNIN}</td><td>&quot;1&quot;</td><td>件数確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RWSAKUSEI}</td><td>&quot;2&quot;</td><td>レポートワーク作成</td></tr>
 * </table>
 */
public class C_TyuusyoriKbn extends Classification<C_TyuusyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyuusyoriKbn BLNK = new C_TyuusyoriKbn("0");

    public static final C_TyuusyoriKbn KENSUUKAKUNIN = new C_TyuusyoriKbn("1");

    public static final C_TyuusyoriKbn RWSAKUSEI = new C_TyuusyoriKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KENSUUKAKUNIN, "KENSUUKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, RWSAKUSEI, "RWSAKUSEI", false);


        lock(C_TyuusyoriKbn.class);
    }

    private C_TyuusyoriKbn(String value) {
        super(value);
    }

    public static C_TyuusyoriKbn valueOf(String value) {
        return valueOf(C_TyuusyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyuusyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyuusyoriKbn.class, patternId, value);
    }
}
