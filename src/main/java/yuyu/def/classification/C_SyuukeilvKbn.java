
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 集計レベル区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyuukeilvKbn</td><td colspan="3">集計レベル区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FLOORLIMITOVER}</td><td>&quot;1&quot;</td><td>フロアリミット超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUTHORIHUYOU}</td><td>&quot;2&quot;</td><td>オーソリ不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUTHORIHITUYOU}</td><td>&quot;3&quot;</td><td>オーソリ必要</td></tr>
 * </table>
 */
public class C_SyuukeilvKbn extends Classification<C_SyuukeilvKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyuukeilvKbn BLNK = new C_SyuukeilvKbn("0");

    public static final C_SyuukeilvKbn FLOORLIMITOVER = new C_SyuukeilvKbn("1");

    public static final C_SyuukeilvKbn AUTHORIHUYOU = new C_SyuukeilvKbn("2");

    public static final C_SyuukeilvKbn AUTHORIHITUYOU = new C_SyuukeilvKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FLOORLIMITOVER, "FLOORLIMITOVER", false);
        addPattern(PATTERN_DEFAULT, AUTHORIHUYOU, "AUTHORIHUYOU", false);
        addPattern(PATTERN_DEFAULT, AUTHORIHITUYOU, "AUTHORIHITUYOU", false);


        lock(C_SyuukeilvKbn.class);
    }

    private C_SyuukeilvKbn(String value) {
        super(value);
    }

    public static C_SyuukeilvKbn valueOf(String value) {
        return valueOf(C_SyuukeilvKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyuukeilvKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyuukeilvKbn.class, patternId, value);
    }
}
