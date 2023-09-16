
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Ｗｅｂ申込確認状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_WebmoskakjkKbn</td><td colspan="3">Ｗｅｂ申込確認状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEIMATI}</td><td>&quot;1&quot;</td><td>作成待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINTYUU}</td><td>&quot;2&quot;</td><td>確認中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;3&quot;</td><td>確認済</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_MESSAGE MESSAGE}<br />(メッセージ用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>確認対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEIMATI}</td><td>&quot;1&quot;</td><td>Ｗｅｂ申込書類作成待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINTYUU}</td><td>&quot;2&quot;</td><td>Ｗｅｂ申込書類確認中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI}</td><td>&quot;3&quot;</td><td>Ｗｅｂ申込書類確認済</td></tr>
 * </table>
 */
public class C_WebmoskakjkKbn extends Classification<C_WebmoskakjkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_WebmoskakjkKbn BLNK = new C_WebmoskakjkKbn("0");

    public static final C_WebmoskakjkKbn SAKUSEIMATI = new C_WebmoskakjkKbn("1");

    public static final C_WebmoskakjkKbn KAKUNINTYUU = new C_WebmoskakjkKbn("2");

    public static final C_WebmoskakjkKbn SUMI = new C_WebmoskakjkKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_MESSAGE = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SAKUSEIMATI, "SAKUSEIMATI", false);
        addPattern(PATTERN_DEFAULT, KAKUNINTYUU, "KAKUNINTYUU", false);
        addPattern(PATTERN_DEFAULT, SUMI, "SUMI", false);


        addPattern(PATTERN_MESSAGE, BLNK, "BLNK", true);
        addPattern(PATTERN_MESSAGE, SAKUSEIMATI, "SAKUSEIMATI", false);
        addPattern(PATTERN_MESSAGE, KAKUNINTYUU, "KAKUNINTYUU", false);
        addPattern(PATTERN_MESSAGE, SUMI, "SUMI", false);


        lock(C_WebmoskakjkKbn.class);
    }

    private C_WebmoskakjkKbn(String value) {
        super(value);
    }

    public static C_WebmoskakjkKbn valueOf(String value) {
        return valueOf(C_WebmoskakjkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_WebmoskakjkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_WebmoskakjkKbn.class, patternId, value);
    }
}
