
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集休止基準日区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BoskyuusiKijyunymdKbn</td><td colspan="3">募集休止基準日区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKYMD}</td><td>&quot;1&quot;</td><td>契約日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKNNKAISIYMD}</td><td>&quot;2&quot;</td><td>責任開始日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSYMD}</td><td>&quot;3&quot;</td><td>申込日</td></tr>
 * </table>
 */
public class C_BoskyuusiKijyunymdKbn extends Classification<C_BoskyuusiKijyunymdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BoskyuusiKijyunymdKbn BLNK = new C_BoskyuusiKijyunymdKbn("0");

    public static final C_BoskyuusiKijyunymdKbn KYKYMD = new C_BoskyuusiKijyunymdKbn("1");

    public static final C_BoskyuusiKijyunymdKbn SKNNKAISIYMD = new C_BoskyuusiKijyunymdKbn("2");

    public static final C_BoskyuusiKijyunymdKbn MOSYMD = new C_BoskyuusiKijyunymdKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKYMD, "KYKYMD", false);
        addPattern(PATTERN_DEFAULT, SKNNKAISIYMD, "SKNNKAISIYMD", false);
        addPattern(PATTERN_DEFAULT, MOSYMD, "MOSYMD", false);


        lock(C_BoskyuusiKijyunymdKbn.class);
    }

    private C_BoskyuusiKijyunymdKbn(String value) {
        super(value);
    }

    public static C_BoskyuusiKijyunymdKbn valueOf(String value) {
        return valueOf(C_BoskyuusiKijyunymdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BoskyuusiKijyunymdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BoskyuusiKijyunymdKbn.class, patternId, value);
    }
}
