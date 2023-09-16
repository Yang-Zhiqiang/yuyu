
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 約款受領方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YakkanJyuryouKbn</td><td colspan="3">約款受領方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEB}</td><td>&quot;1&quot;</td><td>Ｗｅｂ受取り</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASSI}</td><td>&quot;2&quot;</td><td>冊子受取り</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEB_SASSI}</td><td>&quot;3&quot;</td><td>冊子後送</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DISP DISP}<br />(表示用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEB}</td><td>&quot;1&quot;</td><td>Ｗｅｂでの受取り（インターネット環境で確認）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASSI}</td><td>&quot;2&quot;</td><td>冊子での受取り</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEB_SASSI}</td><td>&quot;3&quot;</td><td>Ｗｅｂでの受取り（冊子も送付）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEB}</td><td>&quot;1&quot;</td><td>Ｗｅｂでの受取り（インターネット環境で確認）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEB_SASSI}</td><td>&quot;3&quot;</td><td>冊子の送付も希望される場合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASSI}</td><td>&quot;2&quot;</td><td>冊子での受取り（すでに冊子をお受け取りいただいている場合）</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_HOZEN HOZEN}<br />(保全用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEB}</td><td>&quot;1&quot;</td><td>Ｗｅｂでの受取り（インターネット環境で確認）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SASSI}</td><td>&quot;2&quot;</td><td>冊子での受取り</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEB_SASSI}</td><td>&quot;3&quot;</td><td>Ｗｅｂでの受取り（冊子も送付）</td></tr>
 * </table>
 */
public class C_YakkanJyuryouKbn extends Classification<C_YakkanJyuryouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YakkanJyuryouKbn BLNK = new C_YakkanJyuryouKbn("0");

    public static final C_YakkanJyuryouKbn WEB = new C_YakkanJyuryouKbn("1");

    public static final C_YakkanJyuryouKbn SASSI = new C_YakkanJyuryouKbn("2");

    public static final C_YakkanJyuryouKbn WEB_SASSI = new C_YakkanJyuryouKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_DISP = "2";

    public static final String PATTERN_SELECT = "3";

    public static final String PATTERN_HOZEN = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, WEB, "WEB", false);
        addPattern(PATTERN_DEFAULT, SASSI, "SASSI", false);
        addPattern(PATTERN_DEFAULT, WEB_SASSI, "WEB_SASSI", false);


        addPattern(PATTERN_DISP, BLNK, "BLNK", true);
        addPattern(PATTERN_DISP, WEB, "WEB", false);
        addPattern(PATTERN_DISP, SASSI, "SASSI", false);
        addPattern(PATTERN_DISP, WEB_SASSI, "WEB_SASSI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, WEB, "WEB", false);
        addPattern(PATTERN_SELECT, WEB_SASSI, "WEB_SASSI", false);
        addPattern(PATTERN_SELECT, SASSI, "SASSI", false);


        addPattern(PATTERN_HOZEN, BLNK, "BLNK", true);
        addPattern(PATTERN_HOZEN, WEB, "WEB", false);
        addPattern(PATTERN_HOZEN, SASSI, "SASSI", false);
        addPattern(PATTERN_HOZEN, WEB_SASSI, "WEB_SASSI", false);


        lock(C_YakkanJyuryouKbn.class);
    }

    private C_YakkanJyuryouKbn(String value) {
        super(value);
    }

    public static C_YakkanJyuryouKbn valueOf(String value) {
        return valueOf(C_YakkanJyuryouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YakkanJyuryouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YakkanJyuryouKbn.class, patternId, value);
    }
}
