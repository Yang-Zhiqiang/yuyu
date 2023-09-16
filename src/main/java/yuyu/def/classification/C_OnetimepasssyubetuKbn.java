
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ワンタイムパスワード種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_OnetimepasssyubetuKbn</td><td colspan="3">ワンタイムパスワード種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KARITOUROKU}</td><td>&quot;1&quot;</td><td>仮登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PWSAISETTEI}</td><td>&quot;2&quot;</td><td>パスワード再設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILADRHENKOU}</td><td>&quot;3&quot;</td><td>メールアドレス変更</td></tr>
 * </table>
 */
public class C_OnetimepasssyubetuKbn extends Classification<C_OnetimepasssyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_OnetimepasssyubetuKbn KARITOUROKU = new C_OnetimepasssyubetuKbn("1");

    public static final C_OnetimepasssyubetuKbn PWSAISETTEI = new C_OnetimepasssyubetuKbn("2");

    public static final C_OnetimepasssyubetuKbn MAILADRHENKOU = new C_OnetimepasssyubetuKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KARITOUROKU, "KARITOUROKU", true);
        addPattern(PATTERN_DEFAULT, PWSAISETTEI, "PWSAISETTEI", false);
        addPattern(PATTERN_DEFAULT, MAILADRHENKOU, "MAILADRHENKOU", false);


        lock(C_OnetimepasssyubetuKbn.class);
    }

    private C_OnetimepasssyubetuKbn(String value) {
        super(value);
    }

    public static C_OnetimepasssyubetuKbn valueOf(String value) {
        return valueOf(C_OnetimepasssyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_OnetimepasssyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_OnetimepasssyubetuKbn.class, patternId, value);
    }
}
