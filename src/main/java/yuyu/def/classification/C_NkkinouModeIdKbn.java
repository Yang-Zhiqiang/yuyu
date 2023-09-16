
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金支払機能モードＩＤ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkkinouModeIdKbn</td><td colspan="3">年金支払機能モードＩＤ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DEFAULT}</td><td>&quot;default&quot;</td><td>デフォルト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUT}</td><td>&quot;input&quot;</td><td>入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;syoukai&quot;</td><td>照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUTKEY}</td><td>&quot;inputkey&quot;</td><td>キー入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKEN}</td><td>&quot;tenken&quot;</td><td>点検</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;syounin&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBITOUROKU}</td><td>&quot;hubitouroku&quot;</td><td>不備登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBISYOUNIN}</td><td>&quot;hubisyounin&quot;</td><td>不備承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIKAISYOU}</td><td>&quot;hubikaisyou&quot;</td><td>不備解消</td></tr>
 * </table>
 */
public class C_NkkinouModeIdKbn extends Classification<C_NkkinouModeIdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NkkinouModeIdKbn DEFAULT = new C_NkkinouModeIdKbn("default");

    public static final C_NkkinouModeIdKbn INPUT = new C_NkkinouModeIdKbn("input");

    public static final C_NkkinouModeIdKbn SYOUKAI = new C_NkkinouModeIdKbn("syoukai");

    public static final C_NkkinouModeIdKbn INPUTKEY = new C_NkkinouModeIdKbn("inputkey");

    public static final C_NkkinouModeIdKbn TENKEN = new C_NkkinouModeIdKbn("tenken");

    public static final C_NkkinouModeIdKbn SYOUNIN = new C_NkkinouModeIdKbn("syounin");

    public static final C_NkkinouModeIdKbn HUBITOUROKU = new C_NkkinouModeIdKbn("hubitouroku");

    public static final C_NkkinouModeIdKbn HUBISYOUNIN = new C_NkkinouModeIdKbn("hubisyounin");

    public static final C_NkkinouModeIdKbn HUBIKAISYOU = new C_NkkinouModeIdKbn("hubikaisyou");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DEFAULT, "DEFAULT", true);
        addPattern(PATTERN_DEFAULT, INPUT, "INPUT", false);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);
        addPattern(PATTERN_DEFAULT, INPUTKEY, "INPUTKEY", false);
        addPattern(PATTERN_DEFAULT, TENKEN, "TENKEN", false);
        addPattern(PATTERN_DEFAULT, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_DEFAULT, HUBITOUROKU, "HUBITOUROKU", false);
        addPattern(PATTERN_DEFAULT, HUBISYOUNIN, "HUBISYOUNIN", false);
        addPattern(PATTERN_DEFAULT, HUBIKAISYOU, "HUBIKAISYOU", false);


        lock(C_NkkinouModeIdKbn.class);
    }

    private C_NkkinouModeIdKbn(String value) {
        super(value);
    }

    public static C_NkkinouModeIdKbn valueOf(String value) {
        return valueOf(C_NkkinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkkinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkkinouModeIdKbn.class, patternId, value);
    }
}
