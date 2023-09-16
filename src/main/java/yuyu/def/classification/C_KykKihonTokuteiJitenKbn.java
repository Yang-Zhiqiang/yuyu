
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約基本用特定時点判定処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykKihonTokuteiJitenKbn</td><td colspan="3">契約基本用特定時点判定処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHN_KIJYUNBIJITEN}</td><td>&quot;1&quot;</td><td>払方変更（基準日時点取得）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHN_KEIROHNARI_TEIKIIKKATUHNARI}</td><td>&quot;2&quot;</td><td>払方変更（処理別取得：経路変更あり、定期一括払変更あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHN_KEIROHNARI_TEIKIIKKATUHNNASI}</td><td>&quot;3&quot;</td><td>払方変更（処理別取得：経路変更あり、定期一括払変更なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHN_KEIROHNNASI_KAISUUHNARI}</td><td>&quot;4&quot;</td><td>払方変更（処理別取得：経路変更なし、回数変更あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHN_KEIROHNARI_KAISUUHNARI}</td><td>&quot;5&quot;</td><td>払方変更（処理別取得：経路変更あり、回数変更あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHN_KEIROHNARI_KAISUUHNNASI}</td><td>&quot;6&quot;</td><td>払方変更（処理別取得：経路変更あり、回数変更なし）</td></tr>
 * </table>
 */
public class C_KykKihonTokuteiJitenKbn extends Classification<C_KykKihonTokuteiJitenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykKihonTokuteiJitenKbn BLNK = new C_KykKihonTokuteiJitenKbn("0");

    public static final C_KykKihonTokuteiJitenKbn HRIHN_KIJYUNBIJITEN = new C_KykKihonTokuteiJitenKbn("1");

    public static final C_KykKihonTokuteiJitenKbn HRIHN_KEIROHNARI_TEIKIIKKATUHNARI = new C_KykKihonTokuteiJitenKbn("2");

    public static final C_KykKihonTokuteiJitenKbn HRIHN_KEIROHNARI_TEIKIIKKATUHNNASI = new C_KykKihonTokuteiJitenKbn("3");

    public static final C_KykKihonTokuteiJitenKbn HRIHN_KEIROHNNASI_KAISUUHNARI = new C_KykKihonTokuteiJitenKbn("4");

    public static final C_KykKihonTokuteiJitenKbn HRIHN_KEIROHNARI_KAISUUHNARI = new C_KykKihonTokuteiJitenKbn("5");

    public static final C_KykKihonTokuteiJitenKbn HRIHN_KEIROHNARI_KAISUUHNNASI = new C_KykKihonTokuteiJitenKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HRIHN_KIJYUNBIJITEN, "HRIHN_KIJYUNBIJITEN", false);
        addPattern(PATTERN_DEFAULT, HRIHN_KEIROHNARI_TEIKIIKKATUHNARI, "HRIHN_KEIROHNARI_TEIKIIKKATUHNARI", false);
        addPattern(PATTERN_DEFAULT, HRIHN_KEIROHNARI_TEIKIIKKATUHNNASI, "HRIHN_KEIROHNARI_TEIKIIKKATUHNNASI", false);
        addPattern(PATTERN_DEFAULT, HRIHN_KEIROHNNASI_KAISUUHNARI, "HRIHN_KEIROHNNASI_KAISUUHNARI", false);
        addPattern(PATTERN_DEFAULT, HRIHN_KEIROHNARI_KAISUUHNARI, "HRIHN_KEIROHNARI_KAISUUHNARI", false);
        addPattern(PATTERN_DEFAULT, HRIHN_KEIROHNARI_KAISUUHNNASI, "HRIHN_KEIROHNARI_KAISUUHNNASI", false);


        lock(C_KykKihonTokuteiJitenKbn.class);
    }

    private C_KykKihonTokuteiJitenKbn(String value) {
        super(value);
    }

    public static C_KykKihonTokuteiJitenKbn valueOf(String value) {
        return valueOf(C_KykKihonTokuteiJitenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykKihonTokuteiJitenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykKihonTokuteiJitenKbn.class, patternId, value);
    }
}
