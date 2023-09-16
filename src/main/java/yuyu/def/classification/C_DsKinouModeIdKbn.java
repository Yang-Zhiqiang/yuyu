
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ機能モードＩＤ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsKinouModeIdKbn</td><td colspan="3">ＤＳ機能モードＩＤ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DEFAULT}</td><td>&quot;default&quot;</td><td>デフォルト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;syoukai&quot;</td><td>照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ACCOUNTJYOUTAIHENKOU}</td><td>&quot;accountjyoutaihenkou&quot;</td><td>アカウント状態変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISEI}</td><td>&quot;teisei&quot;</td><td>訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUT}</td><td>&quot;input&quot;</td><td>入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;syounin&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJINYUURYOKU}</td><td>&quot;itijinyuuryoku&quot;</td><td>１次入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIJINYUURYOKU}</td><td>&quot;nijinyuuryoku&quot;</td><td>２次入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;torikesi&quot;</td><td>取消</td></tr>
 * </table>
 */
public class C_DsKinouModeIdKbn extends Classification<C_DsKinouModeIdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsKinouModeIdKbn DEFAULT = new C_DsKinouModeIdKbn("default");

    public static final C_DsKinouModeIdKbn SYOUKAI = new C_DsKinouModeIdKbn("syoukai");

    public static final C_DsKinouModeIdKbn ACCOUNTJYOUTAIHENKOU = new C_DsKinouModeIdKbn("accountjyoutaihenkou");

    public static final C_DsKinouModeIdKbn TEISEI = new C_DsKinouModeIdKbn("teisei");

    public static final C_DsKinouModeIdKbn INPUT = new C_DsKinouModeIdKbn("input");

    public static final C_DsKinouModeIdKbn SYOUNIN = new C_DsKinouModeIdKbn("syounin");

    public static final C_DsKinouModeIdKbn ITIJINYUURYOKU = new C_DsKinouModeIdKbn("itijinyuuryoku");

    public static final C_DsKinouModeIdKbn NIJINYUURYOKU = new C_DsKinouModeIdKbn("nijinyuuryoku");

    public static final C_DsKinouModeIdKbn TORIKESI = new C_DsKinouModeIdKbn("torikesi");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DEFAULT, "DEFAULT", true);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);
        addPattern(PATTERN_DEFAULT, ACCOUNTJYOUTAIHENKOU, "ACCOUNTJYOUTAIHENKOU", false);
        addPattern(PATTERN_DEFAULT, TEISEI, "TEISEI", false);
        addPattern(PATTERN_DEFAULT, INPUT, "INPUT", false);
        addPattern(PATTERN_DEFAULT, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_DEFAULT, ITIJINYUURYOKU, "ITIJINYUURYOKU", false);
        addPattern(PATTERN_DEFAULT, NIJINYUURYOKU, "NIJINYUURYOKU", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);


        lock(C_DsKinouModeIdKbn.class);
    }

    private C_DsKinouModeIdKbn(String value) {
        super(value);
    }

    public static C_DsKinouModeIdKbn valueOf(String value) {
        return valueOf(C_DsKinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsKinouModeIdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsKinouModeIdKbn.class, patternId, value);
    }
}
