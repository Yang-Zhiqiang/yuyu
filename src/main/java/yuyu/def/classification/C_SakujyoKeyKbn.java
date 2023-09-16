
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 削除キー区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakujyoKeyKbn</td><td colspan="3">削除キー区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENGAPPI}</td><td>&quot;1&quot;</td><td>年月日（8桁）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKAN}</td><td>&quot;2&quot;</td><td>時間（１７桁）</td></tr>
 * </table>
 */
public class C_SakujyoKeyKbn extends Classification<C_SakujyoKeyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakujyoKeyKbn BLNK = new C_SakujyoKeyKbn("0");

    public static final C_SakujyoKeyKbn NENGAPPI = new C_SakujyoKeyKbn("1");

    public static final C_SakujyoKeyKbn JIKAN = new C_SakujyoKeyKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NENGAPPI, "NENGAPPI", false);
        addPattern(PATTERN_DEFAULT, JIKAN, "JIKAN", false);


        lock(C_SakujyoKeyKbn.class);
    }

    private C_SakujyoKeyKbn(String value) {
        super(value);
    }

    public static C_SakujyoKeyKbn valueOf(String value) {
        return valueOf(C_SakujyoKeyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakujyoKeyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakujyoKeyKbn.class, patternId, value);
    }
}
