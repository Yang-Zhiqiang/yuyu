
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 進捗データ承認処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_StydatasyouninsyoriKbn</td><td colspan="3">進捗データ承認処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN}</td><td>&quot;1&quot;</td><td>承認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIUPLOADKYOKA}</td><td>&quot;2&quot;</td><td>再アップロード許可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATASAKUJYO}</td><td>&quot;3&quot;</td><td>データ削除</td></tr>
 * </table>
 */
public class C_StydatasyouninsyoriKbn extends Classification<C_StydatasyouninsyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_StydatasyouninsyoriKbn BLNK = new C_StydatasyouninsyoriKbn("0");

    public static final C_StydatasyouninsyoriKbn SYOUNIN = new C_StydatasyouninsyoriKbn("1");

    public static final C_StydatasyouninsyoriKbn SAIUPLOADKYOKA = new C_StydatasyouninsyoriKbn("2");

    public static final C_StydatasyouninsyoriKbn DATASAKUJYO = new C_StydatasyouninsyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUNIN, "SYOUNIN", false);
        addPattern(PATTERN_DEFAULT, SAIUPLOADKYOKA, "SAIUPLOADKYOKA", false);
        addPattern(PATTERN_DEFAULT, DATASAKUJYO, "DATASAKUJYO", false);


        lock(C_StydatasyouninsyoriKbn.class);
    }

    private C_StydatasyouninsyoriKbn(String value) {
        super(value);
    }

    public static C_StydatasyouninsyoriKbn valueOf(String value) {
        return valueOf(C_StydatasyouninsyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_StydatasyouninsyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_StydatasyouninsyoriKbn.class, patternId, value);
    }
}
