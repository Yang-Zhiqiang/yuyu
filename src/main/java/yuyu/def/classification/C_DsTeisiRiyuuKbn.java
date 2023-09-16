
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ停止理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsTeisiRiyuuKbn</td><td colspan="3">ＤＳ停止理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOCK_OUT}</td><td>&quot;1&quot;</td><td>ロックアウト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OMOUSIDE}</td><td>&quot;2&quot;</td><td>お申し出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PASSWORD_MITOUROKU}</td><td>&quot;3&quot;</td><td>パスワード未登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_DsTeisiRiyuuKbn extends Classification<C_DsTeisiRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsTeisiRiyuuKbn BLANK = new C_DsTeisiRiyuuKbn("0");

    public static final C_DsTeisiRiyuuKbn LOCK_OUT = new C_DsTeisiRiyuuKbn("1");

    public static final C_DsTeisiRiyuuKbn OMOUSIDE = new C_DsTeisiRiyuuKbn("2");

    public static final C_DsTeisiRiyuuKbn PASSWORD_MITOUROKU = new C_DsTeisiRiyuuKbn("3");

    public static final C_DsTeisiRiyuuKbn SONOTA = new C_DsTeisiRiyuuKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, LOCK_OUT, "LOCK_OUT", false);
        addPattern(PATTERN_DEFAULT, OMOUSIDE, "OMOUSIDE", false);
        addPattern(PATTERN_DEFAULT, PASSWORD_MITOUROKU, "PASSWORD_MITOUROKU", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_DsTeisiRiyuuKbn.class);
    }

    private C_DsTeisiRiyuuKbn(String value) {
        super(value);
    }

    public static C_DsTeisiRiyuuKbn valueOf(String value) {
        return valueOf(C_DsTeisiRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsTeisiRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsTeisiRiyuuKbn.class, patternId, value);
    }
}
