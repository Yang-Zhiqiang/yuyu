
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 郵便番号検索区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Ynosrch</td><td colspan="3">郵便番号検索区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YNO_OR_ADDRESS}</td><td>&quot;1&quot;</td><td>郵便番号または住所からの検索</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHO}</td><td>&quot;2&quot;</td><td>候補からの絞込み検索</td></tr>
 * </table>
 */
public class C_Ynosrch extends Classification<C_Ynosrch> {

    private static final long serialVersionUID = 1L;


    public static final C_Ynosrch YNO_OR_ADDRESS = new C_Ynosrch("1");

    public static final C_Ynosrch KOUHO = new C_Ynosrch("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YNO_OR_ADDRESS, "YNO_OR_ADDRESS", true);
        addPattern(PATTERN_DEFAULT, KOUHO, "KOUHO", false);


        lock(C_Ynosrch.class);
    }

    private C_Ynosrch(String value) {
        super(value);
    }

    public static C_Ynosrch valueOf(String value) {
        return valueOf(C_Ynosrch.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Ynosrch.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Ynosrch.class, patternId, value);
    }
}
