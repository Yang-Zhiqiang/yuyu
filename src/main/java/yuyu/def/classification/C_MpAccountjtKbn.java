
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * マイページアカウント状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MpAccountjtKbn</td><td colspan="3">マイページアカウント状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KARITOUROKU}</td><td>&quot;0&quot;</td><td>仮登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOU}</td><td>&quot;1&quot;</td><td>有効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUMOSKEIIARI}</td><td>&quot;2&quot;</td><td>有効（申込経緯あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;3&quot;</td><td>無効</td></tr>
 * </table>
 */
public class C_MpAccountjtKbn extends Classification<C_MpAccountjtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MpAccountjtKbn KARITOUROKU = new C_MpAccountjtKbn("0");

    public static final C_MpAccountjtKbn YUUKOU = new C_MpAccountjtKbn("1");

    public static final C_MpAccountjtKbn YUUKOUMOSKEIIARI = new C_MpAccountjtKbn("2");

    public static final C_MpAccountjtKbn MUKOU = new C_MpAccountjtKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KARITOUROKU, "KARITOUROKU", true);
        addPattern(PATTERN_DEFAULT, YUUKOU, "YUUKOU", false);
        addPattern(PATTERN_DEFAULT, YUUKOUMOSKEIIARI, "YUUKOUMOSKEIIARI", false);
        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", false);


        lock(C_MpAccountjtKbn.class);
    }

    private C_MpAccountjtKbn(String value) {
        super(value);
    }

    public static C_MpAccountjtKbn valueOf(String value) {
        return valueOf(C_MpAccountjtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MpAccountjtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MpAccountjtKbn.class, patternId, value);
    }
}
