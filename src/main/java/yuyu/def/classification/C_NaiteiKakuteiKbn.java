
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 内定確定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NaiteiKakuteiKbn</td><td colspan="3">内定確定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEI}</td><td>&quot;1&quot;</td><td>確定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAITEI}</td><td>&quot;2&quot;</td><td>内定</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEI}</td><td>&quot;1&quot;</td><td>０：確定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAITEI}</td><td>&quot;2&quot;</td><td>１：内定</td></tr>
 * </table>
 */
public class C_NaiteiKakuteiKbn extends Classification<C_NaiteiKakuteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NaiteiKakuteiKbn BLNK = new C_NaiteiKakuteiKbn("0");

    public static final C_NaiteiKakuteiKbn KAKUTEI = new C_NaiteiKakuteiKbn("1");

    public static final C_NaiteiKakuteiKbn NAITEI = new C_NaiteiKakuteiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAKUTEI, "KAKUTEI", false);
        addPattern(PATTERN_DEFAULT, NAITEI, "NAITEI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, KAKUTEI, "KAKUTEI", false);
        addPattern(PATTERN_SELECT, NAITEI, "NAITEI", false);


        lock(C_NaiteiKakuteiKbn.class);
    }

    private C_NaiteiKakuteiKbn(String value) {
        super(value);
    }

    public static C_NaiteiKakuteiKbn valueOf(String value) {
        return valueOf(C_NaiteiKakuteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NaiteiKakuteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NaiteiKakuteiKbn.class, patternId, value);
    }
}
