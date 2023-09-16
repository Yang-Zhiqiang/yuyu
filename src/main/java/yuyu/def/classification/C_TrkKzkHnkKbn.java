
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 登録家族変更内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TrkKzkHnkKbn</td><td colspan="3">登録家族変更内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;1&quot;</td><td>新規登録・別人変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>改姓・情報変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;3&quot;</td><td>削除</td></tr>
 * </table>
 */
public class C_TrkKzkHnkKbn extends Classification<C_TrkKzkHnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TrkKzkHnkKbn BLNK = new C_TrkKzkHnkKbn("0");

    public static final C_TrkKzkHnkKbn TOUROKU = new C_TrkKzkHnkKbn("1");

    public static final C_TrkKzkHnkKbn HENKOU = new C_TrkKzkHnkKbn("2");

    public static final C_TrkKzkHnkKbn SAKUJYO = new C_TrkKzkHnkKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, SAKUJYO, "SAKUJYO", false);


        lock(C_TrkKzkHnkKbn.class);
    }

    private C_TrkKzkHnkKbn(String value) {
        super(value);
    }

    public static C_TrkKzkHnkKbn valueOf(String value) {
        return valueOf(C_TrkKzkHnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TrkKzkHnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TrkKzkHnkKbn.class, patternId, value);
    }
}
