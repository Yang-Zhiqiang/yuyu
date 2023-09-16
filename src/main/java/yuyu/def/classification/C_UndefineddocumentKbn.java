
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 未定義ドキュメント区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UndefineddocumentKbn</td><td colspan="3">未定義ドキュメント区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TEIGI}</td><td>&quot;0&quot;</td><td>定義済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MITEIGI}</td><td>&quot;2&quot;</td><td>未定義</td></tr>
 * </table>
 */
public class C_UndefineddocumentKbn extends Classification<C_UndefineddocumentKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UndefineddocumentKbn TEIGI = new C_UndefineddocumentKbn("0");

    public static final C_UndefineddocumentKbn MITEIGI = new C_UndefineddocumentKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TEIGI, "TEIGI", true);
        addPattern(PATTERN_DEFAULT, MITEIGI, "MITEIGI", false);


        lock(C_UndefineddocumentKbn.class);
    }

    private C_UndefineddocumentKbn(String value) {
        super(value);
    }

    public static C_UndefineddocumentKbn valueOf(String value) {
        return valueOf(C_UndefineddocumentKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UndefineddocumentKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UndefineddocumentKbn.class, patternId, value);
    }
}
