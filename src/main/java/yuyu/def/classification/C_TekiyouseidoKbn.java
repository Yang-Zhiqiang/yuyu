
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 適用制度区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TekiyouseidoKbn</td><td colspan="3">適用制度区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ﾌﾞﾗﾝｸ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDSD}</td><td>&quot;1&quot;</td><td>旧制度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEWSD}</td><td>&quot;2&quot;</td><td>新制度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEWOLDHZN}</td><td>&quot;3&quot;</td><td>新旧制度併存</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">&nbsp;</td><td>{@link #OLDSD}</td><td>&quot;1&quot;</td><td>旧制度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEWSD}</td><td>&quot;2&quot;</td><td>新制度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEWOLDHZN}</td><td>&quot;3&quot;</td><td>新旧制度併存</td></tr>
 * </table>
 */
public class C_TekiyouseidoKbn extends Classification<C_TekiyouseidoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TekiyouseidoKbn BLNK = new C_TekiyouseidoKbn("0");

    public static final C_TekiyouseidoKbn OLDSD = new C_TekiyouseidoKbn("1");

    public static final C_TekiyouseidoKbn NEWSD = new C_TekiyouseidoKbn("2");

    public static final C_TekiyouseidoKbn NEWOLDHZN = new C_TekiyouseidoKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OLDSD, "OLDSD", false);
        addPattern(PATTERN_DEFAULT, NEWSD, "NEWSD", false);
        addPattern(PATTERN_DEFAULT, NEWOLDHZN, "NEWOLDHZN", false);


        addPattern(PATTERN_SELECT, OLDSD, "OLDSD", false);
        addPattern(PATTERN_SELECT, NEWSD, "NEWSD", false);
        addPattern(PATTERN_SELECT, NEWOLDHZN, "NEWOLDHZN", false);


        lock(C_TekiyouseidoKbn.class);
    }

    private C_TekiyouseidoKbn(String value) {
        super(value);
    }

    public static C_TekiyouseidoKbn valueOf(String value) {
        return valueOf(C_TekiyouseidoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TekiyouseidoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TekiyouseidoKbn.class, patternId, value);
    }
}
