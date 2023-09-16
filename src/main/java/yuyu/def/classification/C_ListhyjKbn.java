
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 一覧表示区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ListhyjKbn</td><td colspan="3">一覧表示区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDRTNNOMI}</td><td>&quot;1&quot;</td><td>自代理店のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OYAKOZENBOSYUUNIN}</td><td>&quot;2&quot;</td><td>親子全募集人</td></tr>
 * </table>
 */
public class C_ListhyjKbn extends Classification<C_ListhyjKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ListhyjKbn BLNK = new C_ListhyjKbn("0");

    public static final C_ListhyjKbn JIDRTNNOMI = new C_ListhyjKbn("1");

    public static final C_ListhyjKbn OYAKOZENBOSYUUNIN = new C_ListhyjKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JIDRTNNOMI, "JIDRTNNOMI", false);
        addPattern(PATTERN_DEFAULT, OYAKOZENBOSYUUNIN, "OYAKOZENBOSYUUNIN", false);


        lock(C_ListhyjKbn.class);
    }

    private C_ListhyjKbn(String value) {
        super(value);
    }

    public static C_ListhyjKbn valueOf(String value) {
        return valueOf(C_ListhyjKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ListhyjKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ListhyjKbn.class, patternId, value);
    }
}
