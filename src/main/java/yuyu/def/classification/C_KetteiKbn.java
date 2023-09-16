
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 決定状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KetteiKbn</td><td colspan="3">決定状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;99&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETTEI_SUMI}</td><td>&quot;1&quot;</td><td>決定済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETTEI_MATI}</td><td>&quot;2&quot;</td><td>決定待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKJYSYDK_MATI}</td><td>&quot;3&quot;</td><td>特条承諾書待ち</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_RYAKU RYAKU}<br />(略称)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;99&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETTEI_SUMI}</td><td>&quot;1&quot;</td><td>決定済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETTEI_MATI}</td><td>&quot;2&quot;</td><td>決定待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKJYSYDK_MATI}</td><td>&quot;3&quot;</td><td>特条待ち</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;99&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETTEI_SUMI}</td><td>&quot;1&quot;</td><td>決定済</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SKSTYJKSYOUKAI SKSTYJKSYOUKAI}<br />(進捗状況照会用)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETTEI_SUMI}</td><td>&quot;1&quot;</td><td>決定済</td></tr>
 * </table>
 */
public class C_KetteiKbn extends Classification<C_KetteiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KetteiKbn BLNK = new C_KetteiKbn("99");

    public static final C_KetteiKbn NONE = new C_KetteiKbn("0");

    public static final C_KetteiKbn KETTEI_SUMI = new C_KetteiKbn("1");

    public static final C_KetteiKbn KETTEI_MATI = new C_KetteiKbn("2");

    public static final C_KetteiKbn TKJYSYDK_MATI = new C_KetteiKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RYAKU = "2";

    public static final String PATTERN_SELECT = "3";

    public static final String PATTERN_SKSTYJKSYOUKAI = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, KETTEI_SUMI, "KETTEI_SUMI", false);
        addPattern(PATTERN_DEFAULT, KETTEI_MATI, "KETTEI_MATI", false);
        addPattern(PATTERN_DEFAULT, TKJYSYDK_MATI, "TKJYSYDK_MATI", false);


        addPattern(PATTERN_RYAKU, BLNK, "BLNK", false);
        addPattern(PATTERN_RYAKU, NONE, "NONE", false);
        addPattern(PATTERN_RYAKU, KETTEI_SUMI, "KETTEI_SUMI", false);
        addPattern(PATTERN_RYAKU, KETTEI_MATI, "KETTEI_MATI", false);
        addPattern(PATTERN_RYAKU, TKJYSYDK_MATI, "TKJYSYDK_MATI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, NONE, "NONE", false);
        addPattern(PATTERN_SELECT, KETTEI_SUMI, "KETTEI_SUMI", false);


        addPattern(PATTERN_SKSTYJKSYOUKAI, NONE, "NONE", false);
        addPattern(PATTERN_SKSTYJKSYOUKAI, KETTEI_SUMI, "KETTEI_SUMI", false);


        lock(C_KetteiKbn.class);
    }

    private C_KetteiKbn(String value) {
        super(value);
    }

    public static C_KetteiKbn valueOf(String value) {
        return valueOf(C_KetteiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KetteiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KetteiKbn.class, patternId, value);
    }
}
