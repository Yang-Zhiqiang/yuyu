
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 工程作成結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouteiSakuseiKekkaKbn</td><td colspan="3">工程作成結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SUCCESS}</td><td>&quot;1&quot;</td><td>正常終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISAKUSEI_KIZON_ARI}</td><td>&quot;2&quot;</td><td>工程未作成（既存工程有り）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FAILURE}</td><td>&quot;3&quot;</td><td>工程作成失敗</td></tr>
 * </table>
 */
public class C_KouteiSakuseiKekkaKbn extends Classification<C_KouteiSakuseiKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KouteiSakuseiKekkaKbn SUCCESS = new C_KouteiSakuseiKekkaKbn("1");

    public static final C_KouteiSakuseiKekkaKbn MISAKUSEI_KIZON_ARI = new C_KouteiSakuseiKekkaKbn("2");

    public static final C_KouteiSakuseiKekkaKbn FAILURE = new C_KouteiSakuseiKekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SUCCESS, "SUCCESS", true);
        addPattern(PATTERN_DEFAULT, MISAKUSEI_KIZON_ARI, "MISAKUSEI_KIZON_ARI", false);
        addPattern(PATTERN_DEFAULT, FAILURE, "FAILURE", false);


        lock(C_KouteiSakuseiKekkaKbn.class);
    }

    private C_KouteiSakuseiKekkaKbn(String value) {
        super(value);
    }

    public static C_KouteiSakuseiKekkaKbn valueOf(String value) {
        return valueOf(C_KouteiSakuseiKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouteiSakuseiKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouteiSakuseiKekkaKbn.class, patternId, value);
    }
}
