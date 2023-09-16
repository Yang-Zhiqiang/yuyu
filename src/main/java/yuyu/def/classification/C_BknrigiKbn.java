
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 備金例外区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BknrigiKbn</td><td colspan="3">備金例外区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DEL}</td><td>&quot;1&quot;</td><td>備金削除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADD}</td><td>&quot;2&quot;</td><td>備金追加</td></tr>
 * </table>
 */
public class C_BknrigiKbn extends Classification<C_BknrigiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BknrigiKbn BLNK = new C_BknrigiKbn("0");

    public static final C_BknrigiKbn DEL = new C_BknrigiKbn("1");

    public static final C_BknrigiKbn ADD = new C_BknrigiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DEL, "DEL", false);
        addPattern(PATTERN_DEFAULT, ADD, "ADD", false);


        lock(C_BknrigiKbn.class);
    }

    private C_BknrigiKbn(String value) {
        super(value);
    }

    public static C_BknrigiKbn valueOf(String value) {
        return valueOf(C_BknrigiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BknrigiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BknrigiKbn.class, patternId, value);
    }
}
