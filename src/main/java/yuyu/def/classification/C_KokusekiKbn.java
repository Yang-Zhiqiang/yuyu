
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 国籍区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KokusekiKbn</td><td colspan="3">国籍区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIHONKOKUSEKI}</td><td>&quot;1&quot;</td><td>日本国籍</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKOKUSEKI}</td><td>&quot;2&quot;</td><td>日本国籍以外</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #NIHONKOKUSEKI}</td><td>&quot;1&quot;</td><td>日本国籍</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKOKUSEKI}</td><td>&quot;2&quot;</td><td>日本国籍以外</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #NIHONKOKUSEKI}</td><td>&quot;1&quot;</td><td>日本国籍</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKOKUSEKI}</td><td>&quot;2&quot;</td><td>左記（日本国籍）以外</td></tr>
 * </table>
 */
public class C_KokusekiKbn extends Classification<C_KokusekiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KokusekiKbn BLNK = new C_KokusekiKbn("0");

    public static final C_KokusekiKbn NIHONKOKUSEKI = new C_KokusekiKbn("1");

    public static final C_KokusekiKbn GAIKOKUSEKI = new C_KokusekiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_SELECT = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NIHONKOKUSEKI, "NIHONKOKUSEKI", false);
        addPattern(PATTERN_DEFAULT, GAIKOKUSEKI, "GAIKOKUSEKI", false);


        addPattern(PATTERN_NOBLNK, NIHONKOKUSEKI, "NIHONKOKUSEKI", true);
        addPattern(PATTERN_NOBLNK, GAIKOKUSEKI, "GAIKOKUSEKI", false);


        addPattern(PATTERN_SELECT, NIHONKOKUSEKI, "NIHONKOKUSEKI", true);
        addPattern(PATTERN_SELECT, GAIKOKUSEKI, "GAIKOKUSEKI", false);


        lock(C_KokusekiKbn.class);
    }

    private C_KokusekiKbn(String value) {
        super(value);
    }

    public static C_KokusekiKbn valueOf(String value) {
        return valueOf(C_KokusekiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KokusekiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KokusekiKbn.class, patternId, value);
    }
}
