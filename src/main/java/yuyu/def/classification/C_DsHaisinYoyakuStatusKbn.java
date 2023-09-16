
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ配信予約ステータス区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsHaisinYoyakuStatusKbn</td><td colspan="3">ＤＳ配信予約ステータス区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN_MATI}</td><td>&quot;1&quot;</td><td>承認待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN_SUMI}</td><td>&quot;2&quot;</td><td>承認済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RENKEI_SUMI}</td><td>&quot;3&quot;</td><td>連携済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO_SUMI}</td><td>&quot;4&quot;</td><td>削除済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIGENGIRE}</td><td>&quot;5&quot;</td><td>期限切れ</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_HAISINYOYAKU HAISINYOYAKU}<br />(配信予約)</td><td align="center">○</td><td>{@link #SYOUNIN_MATI}</td><td>&quot;1&quot;</td><td>承認待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUNIN_SUMI}</td><td>&quot;2&quot;</td><td>承認済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RENKEI_SUMI}</td><td>&quot;3&quot;</td><td>連携済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO_SUMI}</td><td>&quot;4&quot;</td><td>削除済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIGENGIRE}</td><td>&quot;5&quot;</td><td>期限切れ</td></tr>
 * </table>
 */
public class C_DsHaisinYoyakuStatusKbn extends Classification<C_DsHaisinYoyakuStatusKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsHaisinYoyakuStatusKbn BLNK = new C_DsHaisinYoyakuStatusKbn("0");

    public static final C_DsHaisinYoyakuStatusKbn SYOUNIN_MATI = new C_DsHaisinYoyakuStatusKbn("1");

    public static final C_DsHaisinYoyakuStatusKbn SYOUNIN_SUMI = new C_DsHaisinYoyakuStatusKbn("2");

    public static final C_DsHaisinYoyakuStatusKbn RENKEI_SUMI = new C_DsHaisinYoyakuStatusKbn("3");

    public static final C_DsHaisinYoyakuStatusKbn SAKUJYO_SUMI = new C_DsHaisinYoyakuStatusKbn("4");

    public static final C_DsHaisinYoyakuStatusKbn KIGENGIRE = new C_DsHaisinYoyakuStatusKbn("5");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HAISINYOYAKU = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUNIN_MATI, "SYOUNIN_MATI", false);
        addPattern(PATTERN_DEFAULT, SYOUNIN_SUMI, "SYOUNIN_SUMI", false);
        addPattern(PATTERN_DEFAULT, RENKEI_SUMI, "RENKEI_SUMI", false);
        addPattern(PATTERN_DEFAULT, SAKUJYO_SUMI, "SAKUJYO_SUMI", false);
        addPattern(PATTERN_DEFAULT, KIGENGIRE, "KIGENGIRE", false);


        addPattern(PATTERN_HAISINYOYAKU, SYOUNIN_MATI, "SYOUNIN_MATI", true);
        addPattern(PATTERN_HAISINYOYAKU, SYOUNIN_SUMI, "SYOUNIN_SUMI", false);
        addPattern(PATTERN_HAISINYOYAKU, RENKEI_SUMI, "RENKEI_SUMI", false);
        addPattern(PATTERN_HAISINYOYAKU, SAKUJYO_SUMI, "SAKUJYO_SUMI", false);
        addPattern(PATTERN_HAISINYOYAKU, KIGENGIRE, "KIGENGIRE", false);


        lock(C_DsHaisinYoyakuStatusKbn.class);
    }

    private C_DsHaisinYoyakuStatusKbn(String value) {
        super(value);
    }

    public static C_DsHaisinYoyakuStatusKbn valueOf(String value) {
        return valueOf(C_DsHaisinYoyakuStatusKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsHaisinYoyakuStatusKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsHaisinYoyakuStatusKbn.class, patternId, value);
    }
}
