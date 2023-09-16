
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 工程結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouteiKekkaKbn</td><td colspan="3">工程結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;1&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;2&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSYOUNIN}</td><td>&quot;3&quot;</td><td>不承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;4&quot;</td><td>不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;5&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASIMODOSI}</td><td>&quot;6&quot;</td><td>差戻し</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKETORIKESI}</td><td>&quot;7&quot;</td><td>受付取消</td></tr>
 * </table>
 */
public class C_KouteiKekkaKbn extends Classification<C_KouteiKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KouteiKekkaKbn BLNK = new C_KouteiKekkaKbn("0");

    public static final C_KouteiKekkaKbn KANRYOU = new C_KouteiKekkaKbn("1");

    public static final C_KouteiKekkaKbn SYOUNIN = new C_KouteiKekkaKbn("2");

    public static final C_KouteiKekkaKbn HUSYOUNIN = new C_KouteiKekkaKbn("3");

    public static final C_KouteiKekkaKbn HUBI = new C_KouteiKekkaKbn("4");

    public static final C_KouteiKekkaKbn HORYUU = new C_KouteiKekkaKbn("5");

    public static final C_KouteiKekkaKbn SASIMODOSI = new C_KouteiKekkaKbn("6");

    public static final C_KouteiKekkaKbn UKETORIKESI = new C_KouteiKekkaKbn("7");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_DEFAULT, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_DEFAULT, HUSYOUNIN, "HUSYOUNIN", false);
        addPattern(PATTERN_DEFAULT, HUBI, "HUBI", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);
        addPattern(PATTERN_DEFAULT, SASIMODOSI, "SASIMODOSI", false);
        addPattern(PATTERN_DEFAULT, UKETORIKESI, "UKETORIKESI", false);


        lock(C_KouteiKekkaKbn.class);
    }

    private C_KouteiKekkaKbn(String value) {
        super(value);
    }

    public static C_KouteiKekkaKbn valueOf(String value) {
        return valueOf(C_KouteiKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouteiKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouteiKekkaKbn.class, patternId, value);
    }
}
