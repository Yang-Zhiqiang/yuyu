
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 登録ステータス区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TourokustatusKbn</td><td colspan="3">登録ステータス区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJINYUURYOKUMATI}</td><td>&quot;1&quot;</td><td>１次入力待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIJINYUURYOKUMATI}</td><td>&quot;2&quot;</td><td>２次入力待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIJINYUURYOKUSAI_ARI}</td><td>&quot;3&quot;</td><td>２次入力差異あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUURYOKUZUMI}</td><td>&quot;4&quot;</td><td>入力済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKUZUMI}</td><td>&quot;5&quot;</td><td>登録済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;6&quot;</td><td>取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKOMIERROR}</td><td>&quot;7&quot;</td><td>取込エラー</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_SEARCH SEARCH}<br />(検索用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIJINYUURYOKUMATI}</td><td>&quot;2&quot;</td><td>２次入力待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIJINYUURYOKUSAI_ARI}</td><td>&quot;3&quot;</td><td>２次入力差異あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUURYOKUZUMI}</td><td>&quot;4&quot;</td><td>入力済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;6&quot;</td><td>取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKOMIERROR}</td><td>&quot;7&quot;</td><td>取込エラー</td></tr>
 * </table>
 */
public class C_TourokustatusKbn extends Classification<C_TourokustatusKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TourokustatusKbn BLNK = new C_TourokustatusKbn("0");

    public static final C_TourokustatusKbn ITIJINYUURYOKUMATI = new C_TourokustatusKbn("1");

    public static final C_TourokustatusKbn NIJINYUURYOKUMATI = new C_TourokustatusKbn("2");

    public static final C_TourokustatusKbn NIJINYUURYOKUSAI_ARI = new C_TourokustatusKbn("3");

    public static final C_TourokustatusKbn NYUURYOKUZUMI = new C_TourokustatusKbn("4");

    public static final C_TourokustatusKbn TOUROKUZUMI = new C_TourokustatusKbn("5");

    public static final C_TourokustatusKbn TORIKESI = new C_TourokustatusKbn("6");

    public static final C_TourokustatusKbn TORIKOMIERROR = new C_TourokustatusKbn("7");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SEARCH = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITIJINYUURYOKUMATI, "ITIJINYUURYOKUMATI", false);
        addPattern(PATTERN_DEFAULT, NIJINYUURYOKUMATI, "NIJINYUURYOKUMATI", false);
        addPattern(PATTERN_DEFAULT, NIJINYUURYOKUSAI_ARI, "NIJINYUURYOKUSAI_ARI", false);
        addPattern(PATTERN_DEFAULT, NYUURYOKUZUMI, "NYUURYOKUZUMI", false);
        addPattern(PATTERN_DEFAULT, TOUROKUZUMI, "TOUROKUZUMI", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_DEFAULT, TORIKOMIERROR, "TORIKOMIERROR", false);


        addPattern(PATTERN_SEARCH, BLNK, "BLNK", true);
        addPattern(PATTERN_SEARCH, NIJINYUURYOKUMATI, "NIJINYUURYOKUMATI", false);
        addPattern(PATTERN_SEARCH, NIJINYUURYOKUSAI_ARI, "NIJINYUURYOKUSAI_ARI", false);
        addPattern(PATTERN_SEARCH, NYUURYOKUZUMI, "NYUURYOKUZUMI", false);
        addPattern(PATTERN_SEARCH, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_SEARCH, TORIKOMIERROR, "TORIKOMIERROR", false);


        lock(C_TourokustatusKbn.class);
    }

    private C_TourokustatusKbn(String value) {
        super(value);
    }

    public static C_TourokustatusKbn valueOf(String value) {
        return valueOf(C_TourokustatusKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TourokustatusKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TourokustatusKbn.class, patternId, value);
    }
}
