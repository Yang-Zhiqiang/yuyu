
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 作成対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SakuseitaisyouKbn</td><td colspan="3">作成対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEK}</td><td>&quot;1&quot;</td><td>設計書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS}</td><td>&quot;2&quot;</td><td>申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEKMOS}</td><td>&quot;3&quot;</td><td>設計書・申込書</td></tr>
 * </table>
 */
public class C_SakuseitaisyouKbn extends Classification<C_SakuseitaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SakuseitaisyouKbn BLNK = new C_SakuseitaisyouKbn("0");

    public static final C_SakuseitaisyouKbn SEK = new C_SakuseitaisyouKbn("1");

    public static final C_SakuseitaisyouKbn MOS = new C_SakuseitaisyouKbn("2");

    public static final C_SakuseitaisyouKbn SEKMOS = new C_SakuseitaisyouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SEK, "SEK", false);
        addPattern(PATTERN_DEFAULT, MOS, "MOS", false);
        addPattern(PATTERN_DEFAULT, SEKMOS, "SEKMOS", false);


        lock(C_SakuseitaisyouKbn.class);
    }

    private C_SakuseitaisyouKbn(String value) {
        super(value);
    }

    public static C_SakuseitaisyouKbn valueOf(String value) {
        return valueOf(C_SakuseitaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SakuseitaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SakuseitaisyouKbn.class, patternId, value);
    }
}
