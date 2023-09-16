
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 法人代表者役職区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HjndaiykKbn</td><td colspan="3">法人代表者役職区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DTYSYATYOU}</td><td>&quot;1&quot;</td><td>代表取締役社長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYATYOU}</td><td>&quot;2&quot;</td><td>社長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIHYOU}</td><td>&quot;3&quot;</td><td>代表</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RIJITYOU}</td><td>&quot;4&quot;</td><td>理事長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITYOU}</td><td>&quot;5&quot;</td><td>会長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KUMIAITYOU}</td><td>&quot;6&quot;</td><td>組合長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOTYOU}</td><td>&quot;7&quot;</td><td>所長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INTYOU}</td><td>&quot;8&quot;</td><td>院長</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_HjndaiykKbn extends Classification<C_HjndaiykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HjndaiykKbn BLNK = new C_HjndaiykKbn("0");

    public static final C_HjndaiykKbn DTYSYATYOU = new C_HjndaiykKbn("1");

    public static final C_HjndaiykKbn SYATYOU = new C_HjndaiykKbn("2");

    public static final C_HjndaiykKbn DAIHYOU = new C_HjndaiykKbn("3");

    public static final C_HjndaiykKbn RIJITYOU = new C_HjndaiykKbn("4");

    public static final C_HjndaiykKbn KAITYOU = new C_HjndaiykKbn("5");

    public static final C_HjndaiykKbn KUMIAITYOU = new C_HjndaiykKbn("6");

    public static final C_HjndaiykKbn SYOTYOU = new C_HjndaiykKbn("7");

    public static final C_HjndaiykKbn INTYOU = new C_HjndaiykKbn("8");

    public static final C_HjndaiykKbn SONOTA = new C_HjndaiykKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DTYSYATYOU, "DTYSYATYOU", false);
        addPattern(PATTERN_DEFAULT, SYATYOU, "SYATYOU", false);
        addPattern(PATTERN_DEFAULT, DAIHYOU, "DAIHYOU", false);
        addPattern(PATTERN_DEFAULT, RIJITYOU, "RIJITYOU", false);
        addPattern(PATTERN_DEFAULT, KAITYOU, "KAITYOU", false);
        addPattern(PATTERN_DEFAULT, KUMIAITYOU, "KUMIAITYOU", false);
        addPattern(PATTERN_DEFAULT, SYOTYOU, "SYOTYOU", false);
        addPattern(PATTERN_DEFAULT, INTYOU, "INTYOU", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_HjndaiykKbn.class);
    }

    private C_HjndaiykKbn(String value) {
        super(value);
    }

    public static C_HjndaiykKbn valueOf(String value) {
        return valueOf(C_HjndaiykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HjndaiykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HjndaiykKbn.class, patternId, value);
    }
}
