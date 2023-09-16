
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約内容変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykniyuhenkouKbn</td><td colspan="3">契約内容変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTSYSN}</td><td>&quot;1&quot;</td><td>円建終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTNNKN_TMTTKINITENKEIIARI}</td><td>&quot;2&quot;</td><td>円建年金・積立金移転経緯あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTNNKN_TMTTKINITENKEIINASI}</td><td>&quot;3&quot;</td><td>円建年金・積立金移転経緯なし</td></tr>
 * </table>
 */
public class C_KykniyuhenkouKbn extends Classification<C_KykniyuhenkouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykniyuhenkouKbn BLNK = new C_KykniyuhenkouKbn("0");

    public static final C_KykniyuhenkouKbn YENDTSYSN = new C_KykniyuhenkouKbn("1");

    public static final C_KykniyuhenkouKbn YENDTNNKN_TMTTKINITENKEIIARI = new C_KykniyuhenkouKbn("2");

    public static final C_KykniyuhenkouKbn YENDTNNKN_TMTTKINITENKEIINASI = new C_KykniyuhenkouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YENDTSYSN, "YENDTSYSN", false);
        addPattern(PATTERN_DEFAULT, YENDTNNKN_TMTTKINITENKEIIARI, "YENDTNNKN_TMTTKINITENKEIIARI", false);
        addPattern(PATTERN_DEFAULT, YENDTNNKN_TMTTKINITENKEIINASI, "YENDTNNKN_TMTTKINITENKEIINASI", false);


        lock(C_KykniyuhenkouKbn.class);
    }

    private C_KykniyuhenkouKbn(String value) {
        super(value);
    }

    public static C_KykniyuhenkouKbn valueOf(String value) {
        return valueOf(C_KykniyuhenkouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykniyuhenkouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykniyuhenkouKbn.class, patternId, value);
    }
}
