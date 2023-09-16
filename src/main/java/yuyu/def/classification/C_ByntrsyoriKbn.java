
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集人登録処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ByntrsyoriKbn</td><td colspan="3">募集人登録処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;1&quot;</td><td>登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GYOUHAI}</td><td>&quot;3&quot;</td><td>業廃</td></tr>
 * </table>
 */
public class C_ByntrsyoriKbn extends Classification<C_ByntrsyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ByntrsyoriKbn BLNK = new C_ByntrsyoriKbn("0");

    public static final C_ByntrsyoriKbn TOUROKU = new C_ByntrsyoriKbn("1");

    public static final C_ByntrsyoriKbn HENKOU = new C_ByntrsyoriKbn("2");

    public static final C_ByntrsyoriKbn GYOUHAI = new C_ByntrsyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, GYOUHAI, "GYOUHAI", false);


        lock(C_ByntrsyoriKbn.class);
    }

    private C_ByntrsyoriKbn(String value) {
        super(value);
    }

    public static C_ByntrsyoriKbn valueOf(String value) {
        return valueOf(C_ByntrsyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ByntrsyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ByntrsyoriKbn.class, patternId, value);
    }
}
