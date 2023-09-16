
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 本人確認結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HonninKakninKekkaKbn</td><td colspan="3">本人確認結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIRYOU}</td><td>&quot;1&quot;</td><td>本人確認未了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_UNTENMENKYOSYOU}</td><td>&quot;2&quot;</td><td>本人確認済（運転免許証）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_PASSPORT}</td><td>&quot;3&quot;</td><td>本人確認済（パスポート）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KENKOUHOKENSYOU}</td><td>&quot;4&quot;</td><td>本人確認済（健康保険証）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KOKUMINNENKINTETYOU}</td><td>&quot;5&quot;</td><td>本人確認済（国民年金手帳）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KOJINBANGOUCARD}</td><td>&quot;6&quot;</td><td>本人確認済（個人番号カード）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_HONNINKOUZA}</td><td>&quot;7&quot;</td><td>本人確認済（本人口座）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_SONOTA}</td><td>&quot;9&quot;</td><td>本人確認済（その他）</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_HKSELECT HKSELECT}<br />(保険金選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIRYOU}</td><td>&quot;1&quot;</td><td>確認未了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_UNTENMENKYOSYOU}</td><td>&quot;2&quot;</td><td>確認済（運転免許証）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_PASSPORT}</td><td>&quot;3&quot;</td><td>確認済（パスポート）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KENKOUHOKENSYOU}</td><td>&quot;4&quot;</td><td>確認済（健康保険証）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KOKUMINNENKINTETYOU}</td><td>&quot;5&quot;</td><td>確認済（国民年金手帳）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_SONOTA}</td><td>&quot;9&quot;</td><td>確認済（その他）</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_UNTENMENKYOSYOU}</td><td>&quot;2&quot;</td><td>確認済（運転免許証）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_PASSPORT}</td><td>&quot;3&quot;</td><td>確認済（パスポート）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KENKOUHOKENSYOU}</td><td>&quot;4&quot;</td><td>確認済（健康保険証）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KOKUMINNENKINTETYOU}</td><td>&quot;5&quot;</td><td>確認済（国民年金手帳）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KOJINBANGOUCARD}</td><td>&quot;6&quot;</td><td>確認済（個人番号カード）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_SONOTA}</td><td>&quot;9&quot;</td><td>確認済（その他）</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_SELECT_DSHR SELECT_DSHR}<br />(選択（配当金支払）)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">○</td><td>{@link #SUMI_HONNINKOUZA}</td><td>&quot;7&quot;</td><td>確認済（本人口座）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_UNTENMENKYOSYOU}</td><td>&quot;2&quot;</td><td>確認済（運転免許証）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_PASSPORT}</td><td>&quot;3&quot;</td><td>確認済（パスポート）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KENKOUHOKENSYOU}</td><td>&quot;4&quot;</td><td>確認済（健康保険証）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KOKUMINNENKINTETYOU}</td><td>&quot;5&quot;</td><td>確認済（国民年金手帳）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_KOJINBANGOUCARD}</td><td>&quot;6&quot;</td><td>確認済（個人番号カード）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMI_SONOTA}</td><td>&quot;9&quot;</td><td>確認済（その他）</td></tr>
 * </table>
 */
public class C_HonninKakninKekkaKbn extends Classification<C_HonninKakninKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HonninKakninKekkaKbn BLNK = new C_HonninKakninKekkaKbn("0");

    public static final C_HonninKakninKekkaKbn MIRYOU = new C_HonninKakninKekkaKbn("1");

    public static final C_HonninKakninKekkaKbn SUMI_UNTENMENKYOSYOU = new C_HonninKakninKekkaKbn("2");

    public static final C_HonninKakninKekkaKbn SUMI_PASSPORT = new C_HonninKakninKekkaKbn("3");

    public static final C_HonninKakninKekkaKbn SUMI_KENKOUHOKENSYOU = new C_HonninKakninKekkaKbn("4");

    public static final C_HonninKakninKekkaKbn SUMI_KOKUMINNENKINTETYOU = new C_HonninKakninKekkaKbn("5");

    public static final C_HonninKakninKekkaKbn SUMI_KOJINBANGOUCARD = new C_HonninKakninKekkaKbn("6");

    public static final C_HonninKakninKekkaKbn SUMI_HONNINKOUZA = new C_HonninKakninKekkaKbn("7");

    public static final C_HonninKakninKekkaKbn SUMI_SONOTA = new C_HonninKakninKekkaKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HKSELECT = "2";

    public static final String PATTERN_SELECT = "3";

    public static final String PATTERN_SELECT_DSHR = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MIRYOU, "MIRYOU", false);
        addPattern(PATTERN_DEFAULT, SUMI_UNTENMENKYOSYOU, "SUMI_UNTENMENKYOSYOU", false);
        addPattern(PATTERN_DEFAULT, SUMI_PASSPORT, "SUMI_PASSPORT", false);
        addPattern(PATTERN_DEFAULT, SUMI_KENKOUHOKENSYOU, "SUMI_KENKOUHOKENSYOU", false);
        addPattern(PATTERN_DEFAULT, SUMI_KOKUMINNENKINTETYOU, "SUMI_KOKUMINNENKINTETYOU", false);
        addPattern(PATTERN_DEFAULT, SUMI_KOJINBANGOUCARD, "SUMI_KOJINBANGOUCARD", false);
        addPattern(PATTERN_DEFAULT, SUMI_HONNINKOUZA, "SUMI_HONNINKOUZA", false);
        addPattern(PATTERN_DEFAULT, SUMI_SONOTA, "SUMI_SONOTA", false);


        addPattern(PATTERN_HKSELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_HKSELECT, MIRYOU, "MIRYOU", false);
        addPattern(PATTERN_HKSELECT, SUMI_UNTENMENKYOSYOU, "SUMI_UNTENMENKYOSYOU", false);
        addPattern(PATTERN_HKSELECT, SUMI_PASSPORT, "SUMI_PASSPORT", false);
        addPattern(PATTERN_HKSELECT, SUMI_KENKOUHOKENSYOU, "SUMI_KENKOUHOKENSYOU", false);
        addPattern(PATTERN_HKSELECT, SUMI_KOKUMINNENKINTETYOU, "SUMI_KOKUMINNENKINTETYOU", false);
        addPattern(PATTERN_HKSELECT, SUMI_SONOTA, "SUMI_SONOTA", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, SUMI_UNTENMENKYOSYOU, "SUMI_UNTENMENKYOSYOU", false);
        addPattern(PATTERN_SELECT, SUMI_PASSPORT, "SUMI_PASSPORT", false);
        addPattern(PATTERN_SELECT, SUMI_KENKOUHOKENSYOU, "SUMI_KENKOUHOKENSYOU", false);
        addPattern(PATTERN_SELECT, SUMI_KOKUMINNENKINTETYOU, "SUMI_KOKUMINNENKINTETYOU", false);
        addPattern(PATTERN_SELECT, SUMI_KOJINBANGOUCARD, "SUMI_KOJINBANGOUCARD", false);
        addPattern(PATTERN_SELECT, SUMI_SONOTA, "SUMI_SONOTA", false);


        addPattern(PATTERN_SELECT_DSHR, BLNK, "BLNK", false);
        addPattern(PATTERN_SELECT_DSHR, SUMI_HONNINKOUZA, "SUMI_HONNINKOUZA", true);
        addPattern(PATTERN_SELECT_DSHR, SUMI_UNTENMENKYOSYOU, "SUMI_UNTENMENKYOSYOU", false);
        addPattern(PATTERN_SELECT_DSHR, SUMI_PASSPORT, "SUMI_PASSPORT", false);
        addPattern(PATTERN_SELECT_DSHR, SUMI_KENKOUHOKENSYOU, "SUMI_KENKOUHOKENSYOU", false);
        addPattern(PATTERN_SELECT_DSHR, SUMI_KOKUMINNENKINTETYOU, "SUMI_KOKUMINNENKINTETYOU", false);
        addPattern(PATTERN_SELECT_DSHR, SUMI_KOJINBANGOUCARD, "SUMI_KOJINBANGOUCARD", false);
        addPattern(PATTERN_SELECT_DSHR, SUMI_SONOTA, "SUMI_SONOTA", false);


        lock(C_HonninKakninKekkaKbn.class);
    }

    private C_HonninKakninKekkaKbn(String value) {
        super(value);
    }

    public static C_HonninKakninKekkaKbn valueOf(String value) {
        return valueOf(C_HonninKakninKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HonninKakninKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HonninKakninKekkaKbn.class, patternId, value);
    }
}
