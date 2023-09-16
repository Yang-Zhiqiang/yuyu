
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 内部契約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NaibuKeiyakuKbn</td><td colspan="3">内部契約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_NaibuKeiyakuKbn extends Classification<C_NaibuKeiyakuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NaibuKeiyakuKbn BLNK = new C_NaibuKeiyakuKbn("0");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_NaibuKeiyakuKbn.class);
    }

    private C_NaibuKeiyakuKbn(String value) {
        super(value);
    }

    public static C_NaibuKeiyakuKbn valueOf(String value) {
        return valueOf(C_NaibuKeiyakuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NaibuKeiyakuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NaibuKeiyakuKbn.class, patternId, value);
    }
}
