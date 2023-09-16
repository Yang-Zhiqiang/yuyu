
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特定時点指定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkjitensiteiKbn</td><td colspan="3">特定時点指定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIJYUNYMD}</td><td>&quot;1&quot;</td><td>基準日指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOUSIKIBETUKEY}</td><td>&quot;2&quot;</td><td>変更識別キー指定</td></tr>
 * </table>
 */
public class C_TkjitensiteiKbn extends Classification<C_TkjitensiteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TkjitensiteiKbn BLNK = new C_TkjitensiteiKbn("0");

    public static final C_TkjitensiteiKbn KIJYUNYMD = new C_TkjitensiteiKbn("1");

    public static final C_TkjitensiteiKbn HENKOUSIKIBETUKEY = new C_TkjitensiteiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KIJYUNYMD, "KIJYUNYMD", false);
        addPattern(PATTERN_DEFAULT, HENKOUSIKIBETUKEY, "HENKOUSIKIBETUKEY", false);


        lock(C_TkjitensiteiKbn.class);
    }

    private C_TkjitensiteiKbn(String value) {
        super(value);
    }

    public static C_TkjitensiteiKbn valueOf(String value) {
        return valueOf(C_TkjitensiteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkjitensiteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkjitensiteiKbn.class, patternId, value);
    }
}
