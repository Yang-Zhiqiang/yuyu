
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 家族登録サービス手続内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KzkTrkServicettdkKbn</td><td colspan="3">家族登録サービス手続内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;1&quot;</td><td>新規登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU}</td><td>&quot;3&quot;</td><td>サービス終了</td></tr>
 * </table>
 */
public class C_KzkTrkServicettdkKbn extends Classification<C_KzkTrkServicettdkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KzkTrkServicettdkKbn BLNK = new C_KzkTrkServicettdkKbn("0");

    public static final C_KzkTrkServicettdkKbn TOUROKU = new C_KzkTrkServicettdkKbn("1");

    public static final C_KzkTrkServicettdkKbn HENKOU = new C_KzkTrkServicettdkKbn("2");

    public static final C_KzkTrkServicettdkKbn SYUURYOU = new C_KzkTrkServicettdkKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, SYUURYOU, "SYUURYOU", false);


        lock(C_KzkTrkServicettdkKbn.class);
    }

    private C_KzkTrkServicettdkKbn(String value) {
        super(value);
    }

    public static C_KzkTrkServicettdkKbn valueOf(String value) {
        return valueOf(C_KzkTrkServicettdkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KzkTrkServicettdkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KzkTrkServicettdkKbn.class, patternId, value);
    }
}
