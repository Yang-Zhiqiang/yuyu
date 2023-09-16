
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * （選択用）保険種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SelHokensyuruiKbn</td><td colspan="3">（選択用）保険種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="44">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN_SAITEIHSYNASI_USD5Y}</td><td>&quot;ﾕｱ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN_SAITEIHSYNASI_AUD5Y}</td><td>&quot;ﾕｲ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証なし（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN_SAITEIHSYARI_USD5Y}</td><td>&quot;ﾕｳ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN_SAITEIHSYARI_AUD5Y}</td><td>&quot;ﾕｴ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）　　５年　最低保証あり（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN_SAITEIHSYNASI_USD10Y}</td><td>&quot;ﾕｵ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN_SAITEIHSYNASI_AUD10Y}</td><td>&quot;ﾕｶ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証なし（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN_SAITEIHSYARI_USD10Y}</td><td>&quot;ﾕｷ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN_SAITEIHSYARI_AUD10Y}</td><td>&quot;ﾕｸ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）　１０年　最低保証あり（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN_YENDTHNK}</td><td>&quot;ﾕA&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）　　円建変更後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KAKUTEI_USD5Y}</td><td>&quot;ﾕｹ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　　５年確定（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KAKUTEI_USD10Y}</td><td>&quot;ﾕｺ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　１０年確定（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KAKUTEI_USD15Y}</td><td>&quot;ﾕｻ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　１５年確定（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_SGKHOSYOUTUKISYSN_USD}</td><td>&quot;ﾕｼ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　総額保証終身（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KAKUTEI_AUD5Y}</td><td>&quot;ﾕｽ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　　５年確定（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KAKUTEI_AUD10Y}</td><td>&quot;ﾕｾ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　１０年確定（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KAKUTEI_AUD15Y}</td><td>&quot;ﾕｿ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　１５年確定（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_SGKHOSYOUTUKISYSN_AUD}</td><td>&quot;ﾕﾀ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　総額保証終身（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KAKUTEI_YENDTHNK5Y}</td><td>&quot;ﾕB&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　　５年確定　円建変更後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KAKUTEI_YENDTHNK10Y}</td><td>&quot;ﾕC&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　１０年確定　円建変更後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KAKUTEI_YENDTHNK15Y}</td><td>&quot;ﾕD&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　１５年確定　円建変更後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_SGKHOSYOUTUKISYSN_YENDTHNK}</td><td>&quot;ﾕE&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）　総額保証終身　円建変更後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENDOUNK_KAKUTEI_USD5Y}</td><td>&quot;ﾕﾁ&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENDOUNK_KAKUTEI_USD10Y}</td><td>&quot;ﾕﾂ&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　１０年確定（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENDOUNK_KAKUTEI_USD15Y}</td><td>&quot;ﾕﾃ&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　１５年確定（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENDOUNK_KAKUTEIBAIGAKU_USD5Y}</td><td>&quot;ﾕﾄ&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定倍額（米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENDOUNK_KAKUTEI_AUD5Y}</td><td>&quot;ﾕﾅ&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENDOUNK_KAKUTEI_AUD10Y}</td><td>&quot;ﾕﾆ&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　１０年確定（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENDOUNK_KAKUTEI_AUD15Y}</td><td>&quot;ﾕﾇ&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　１５年確定（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENDOUNK_KAKUTEIBAIGAKU_AUD5Y}</td><td>&quot;ﾕﾈ&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険　　５年確定倍額（豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN2_SAITEIHSYNASI_USD2Y}</td><td>&quot;ﾕﾉ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）Ⅱ型　２年　最低保証なし（米）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN2_SAITEIHSYNASI_AUD2Y}</td><td>&quot;ﾕﾊ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）Ⅱ型　２年　最低保証なし（豪）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN2_SAITEIHSYARI_USD2Y}</td><td>&quot;ﾕﾋ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）Ⅱ型　２年　最低保証あり（米）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN2_SAITEIHSYARI_AUD2Y}</td><td>&quot;ﾕﾌ&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）Ⅱ型　２年　最低保証あり（豪）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN2_YENDTHNK2Y}</td><td>&quot;ﾕF&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）（１９）　　円建変更後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KKT_USD5Y_TEIKISHRNASI}</td><td>&quot;ﾕﾍ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）５年確定（米）定期支払なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KKT_USD10Y_TEIKISHRNASI}</td><td>&quot;ﾕﾎ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）１０年確定（米）定期支払なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KKT_USD15Y_TEIKISHRNASI}</td><td>&quot;ﾕﾏ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）１５年確定（米）定期支払なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_SGKHSYSYSN_USD_TEIKISHRNASI}</td><td>&quot;ﾕﾐ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）総額保証終（米）定期支払なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KKT_AUD5Y_TEIKISHRNASI}</td><td>&quot;ﾕﾕ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）５年確定（豪）定期支払なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KKT_AUD10Y_TEIKISHRNASI}</td><td>&quot;ﾕﾖ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）１０年確定（豪）定期支払なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_KKT_AUD15Y_TEIKISHRNASI}</td><td>&quot;ﾕﾗ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）１５年確定（豪）定期支払なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN_SGKHSYSYSN_AUD_TEIKISHRNASI}</td><td>&quot;ﾕﾘ&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）総額保証終（豪）定期支払なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN_TEIKAIYAKUHRKN}</td><td>&quot;ﾆｱ&quot;</td><td>低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険</td></tr>
 * </table>
 */
public class C_SelHokensyuruiKbn extends Classification<C_SelHokensyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SelHokensyuruiKbn BLNK = new C_SelHokensyuruiKbn("0");

    public static final C_SelHokensyuruiKbn SYSN_SAITEIHSYNASI_USD5Y = new C_SelHokensyuruiKbn("ﾕｱ");

    public static final C_SelHokensyuruiKbn SYSN_SAITEIHSYNASI_AUD5Y = new C_SelHokensyuruiKbn("ﾕｲ");

    public static final C_SelHokensyuruiKbn SYSN_SAITEIHSYARI_USD5Y = new C_SelHokensyuruiKbn("ﾕｳ");

    public static final C_SelHokensyuruiKbn SYSN_SAITEIHSYARI_AUD5Y = new C_SelHokensyuruiKbn("ﾕｴ");

    public static final C_SelHokensyuruiKbn SYSN_SAITEIHSYNASI_USD10Y = new C_SelHokensyuruiKbn("ﾕｵ");

    public static final C_SelHokensyuruiKbn SYSN_SAITEIHSYNASI_AUD10Y = new C_SelHokensyuruiKbn("ﾕｶ");

    public static final C_SelHokensyuruiKbn SYSN_SAITEIHSYARI_USD10Y = new C_SelHokensyuruiKbn("ﾕｷ");

    public static final C_SelHokensyuruiKbn SYSN_SAITEIHSYARI_AUD10Y = new C_SelHokensyuruiKbn("ﾕｸ");

    public static final C_SelHokensyuruiKbn SYSN_YENDTHNK = new C_SelHokensyuruiKbn("ﾕA");

    public static final C_SelHokensyuruiKbn NENKIN_KAKUTEI_USD5Y = new C_SelHokensyuruiKbn("ﾕｹ");

    public static final C_SelHokensyuruiKbn NENKIN_KAKUTEI_USD10Y = new C_SelHokensyuruiKbn("ﾕｺ");

    public static final C_SelHokensyuruiKbn NENKIN_KAKUTEI_USD15Y = new C_SelHokensyuruiKbn("ﾕｻ");

    public static final C_SelHokensyuruiKbn NENKIN_SGKHOSYOUTUKISYSN_USD = new C_SelHokensyuruiKbn("ﾕｼ");

    public static final C_SelHokensyuruiKbn NENKIN_KAKUTEI_AUD5Y = new C_SelHokensyuruiKbn("ﾕｽ");

    public static final C_SelHokensyuruiKbn NENKIN_KAKUTEI_AUD10Y = new C_SelHokensyuruiKbn("ﾕｾ");

    public static final C_SelHokensyuruiKbn NENKIN_KAKUTEI_AUD15Y = new C_SelHokensyuruiKbn("ﾕｿ");

    public static final C_SelHokensyuruiKbn NENKIN_SGKHOSYOUTUKISYSN_AUD = new C_SelHokensyuruiKbn("ﾕﾀ");

    public static final C_SelHokensyuruiKbn NENKIN_KAKUTEI_YENDTHNK5Y = new C_SelHokensyuruiKbn("ﾕB");

    public static final C_SelHokensyuruiKbn NENKIN_KAKUTEI_YENDTHNK10Y = new C_SelHokensyuruiKbn("ﾕC");

    public static final C_SelHokensyuruiKbn NENKIN_KAKUTEI_YENDTHNK15Y = new C_SelHokensyuruiKbn("ﾕD");

    public static final C_SelHokensyuruiKbn NENKIN_SGKHOSYOUTUKISYSN_YENDTHNK = new C_SelHokensyuruiKbn("ﾕE");

    public static final C_SelHokensyuruiKbn HENDOUNK_KAKUTEI_USD5Y = new C_SelHokensyuruiKbn("ﾕﾁ");

    public static final C_SelHokensyuruiKbn HENDOUNK_KAKUTEI_USD10Y = new C_SelHokensyuruiKbn("ﾕﾂ");

    public static final C_SelHokensyuruiKbn HENDOUNK_KAKUTEI_USD15Y = new C_SelHokensyuruiKbn("ﾕﾃ");

    public static final C_SelHokensyuruiKbn HENDOUNK_KAKUTEIBAIGAKU_USD5Y = new C_SelHokensyuruiKbn("ﾕﾄ");

    public static final C_SelHokensyuruiKbn HENDOUNK_KAKUTEI_AUD5Y = new C_SelHokensyuruiKbn("ﾕﾅ");

    public static final C_SelHokensyuruiKbn HENDOUNK_KAKUTEI_AUD10Y = new C_SelHokensyuruiKbn("ﾕﾆ");

    public static final C_SelHokensyuruiKbn HENDOUNK_KAKUTEI_AUD15Y = new C_SelHokensyuruiKbn("ﾕﾇ");

    public static final C_SelHokensyuruiKbn HENDOUNK_KAKUTEIBAIGAKU_AUD5Y = new C_SelHokensyuruiKbn("ﾕﾈ");

    public static final C_SelHokensyuruiKbn SYSN2_SAITEIHSYNASI_USD2Y = new C_SelHokensyuruiKbn("ﾕﾉ");

    public static final C_SelHokensyuruiKbn SYSN2_SAITEIHSYNASI_AUD2Y = new C_SelHokensyuruiKbn("ﾕﾊ");

    public static final C_SelHokensyuruiKbn SYSN2_SAITEIHSYARI_USD2Y = new C_SelHokensyuruiKbn("ﾕﾋ");

    public static final C_SelHokensyuruiKbn SYSN2_SAITEIHSYARI_AUD2Y = new C_SelHokensyuruiKbn("ﾕﾌ");

    public static final C_SelHokensyuruiKbn SYSN2_YENDTHNK2Y = new C_SelHokensyuruiKbn("ﾕF");

    public static final C_SelHokensyuruiKbn NENKIN_KKT_USD5Y_TEIKISHRNASI = new C_SelHokensyuruiKbn("ﾕﾍ");

    public static final C_SelHokensyuruiKbn NENKIN_KKT_USD10Y_TEIKISHRNASI = new C_SelHokensyuruiKbn("ﾕﾎ");

    public static final C_SelHokensyuruiKbn NENKIN_KKT_USD15Y_TEIKISHRNASI = new C_SelHokensyuruiKbn("ﾕﾏ");

    public static final C_SelHokensyuruiKbn NENKIN_SGKHSYSYSN_USD_TEIKISHRNASI = new C_SelHokensyuruiKbn("ﾕﾐ");

    public static final C_SelHokensyuruiKbn NENKIN_KKT_AUD5Y_TEIKISHRNASI = new C_SelHokensyuruiKbn("ﾕﾕ");

    public static final C_SelHokensyuruiKbn NENKIN_KKT_AUD10Y_TEIKISHRNASI = new C_SelHokensyuruiKbn("ﾕﾖ");

    public static final C_SelHokensyuruiKbn NENKIN_KKT_AUD15Y_TEIKISHRNASI = new C_SelHokensyuruiKbn("ﾕﾗ");

    public static final C_SelHokensyuruiKbn NENKIN_SGKHSYSYSN_AUD_TEIKISHRNASI = new C_SelHokensyuruiKbn("ﾕﾘ");

    public static final C_SelHokensyuruiKbn SYSN_TEIKAIYAKUHRKN = new C_SelHokensyuruiKbn("ﾆｱ");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYSN_SAITEIHSYNASI_USD5Y, "SYSN_SAITEIHSYNASI_USD5Y", false);
        addPattern(PATTERN_DEFAULT, SYSN_SAITEIHSYNASI_AUD5Y, "SYSN_SAITEIHSYNASI_AUD5Y", false);
        addPattern(PATTERN_DEFAULT, SYSN_SAITEIHSYARI_USD5Y, "SYSN_SAITEIHSYARI_USD5Y", false);
        addPattern(PATTERN_DEFAULT, SYSN_SAITEIHSYARI_AUD5Y, "SYSN_SAITEIHSYARI_AUD5Y", false);
        addPattern(PATTERN_DEFAULT, SYSN_SAITEIHSYNASI_USD10Y, "SYSN_SAITEIHSYNASI_USD10Y", false);
        addPattern(PATTERN_DEFAULT, SYSN_SAITEIHSYNASI_AUD10Y, "SYSN_SAITEIHSYNASI_AUD10Y", false);
        addPattern(PATTERN_DEFAULT, SYSN_SAITEIHSYARI_USD10Y, "SYSN_SAITEIHSYARI_USD10Y", false);
        addPattern(PATTERN_DEFAULT, SYSN_SAITEIHSYARI_AUD10Y, "SYSN_SAITEIHSYARI_AUD10Y", false);
        addPattern(PATTERN_DEFAULT, SYSN_YENDTHNK, "SYSN_YENDTHNK", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KAKUTEI_USD5Y, "NENKIN_KAKUTEI_USD5Y", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KAKUTEI_USD10Y, "NENKIN_KAKUTEI_USD10Y", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KAKUTEI_USD15Y, "NENKIN_KAKUTEI_USD15Y", false);
        addPattern(PATTERN_DEFAULT, NENKIN_SGKHOSYOUTUKISYSN_USD, "NENKIN_SGKHOSYOUTUKISYSN_USD", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KAKUTEI_AUD5Y, "NENKIN_KAKUTEI_AUD5Y", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KAKUTEI_AUD10Y, "NENKIN_KAKUTEI_AUD10Y", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KAKUTEI_AUD15Y, "NENKIN_KAKUTEI_AUD15Y", false);
        addPattern(PATTERN_DEFAULT, NENKIN_SGKHOSYOUTUKISYSN_AUD, "NENKIN_SGKHOSYOUTUKISYSN_AUD", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KAKUTEI_YENDTHNK5Y, "NENKIN_KAKUTEI_YENDTHNK5Y", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KAKUTEI_YENDTHNK10Y, "NENKIN_KAKUTEI_YENDTHNK10Y", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KAKUTEI_YENDTHNK15Y, "NENKIN_KAKUTEI_YENDTHNK15Y", false);
        addPattern(PATTERN_DEFAULT, NENKIN_SGKHOSYOUTUKISYSN_YENDTHNK, "NENKIN_SGKHOSYOUTUKISYSN_YENDTHNK", false);
        addPattern(PATTERN_DEFAULT, HENDOUNK_KAKUTEI_USD5Y, "HENDOUNK_KAKUTEI_USD5Y", false);
        addPattern(PATTERN_DEFAULT, HENDOUNK_KAKUTEI_USD10Y, "HENDOUNK_KAKUTEI_USD10Y", false);
        addPattern(PATTERN_DEFAULT, HENDOUNK_KAKUTEI_USD15Y, "HENDOUNK_KAKUTEI_USD15Y", false);
        addPattern(PATTERN_DEFAULT, HENDOUNK_KAKUTEIBAIGAKU_USD5Y, "HENDOUNK_KAKUTEIBAIGAKU_USD5Y", false);
        addPattern(PATTERN_DEFAULT, HENDOUNK_KAKUTEI_AUD5Y, "HENDOUNK_KAKUTEI_AUD5Y", false);
        addPattern(PATTERN_DEFAULT, HENDOUNK_KAKUTEI_AUD10Y, "HENDOUNK_KAKUTEI_AUD10Y", false);
        addPattern(PATTERN_DEFAULT, HENDOUNK_KAKUTEI_AUD15Y, "HENDOUNK_KAKUTEI_AUD15Y", false);
        addPattern(PATTERN_DEFAULT, HENDOUNK_KAKUTEIBAIGAKU_AUD5Y, "HENDOUNK_KAKUTEIBAIGAKU_AUD5Y", false);
        addPattern(PATTERN_DEFAULT, SYSN2_SAITEIHSYNASI_USD2Y, "SYSN2_SAITEIHSYNASI_USD2Y", false);
        addPattern(PATTERN_DEFAULT, SYSN2_SAITEIHSYNASI_AUD2Y, "SYSN2_SAITEIHSYNASI_AUD2Y", false);
        addPattern(PATTERN_DEFAULT, SYSN2_SAITEIHSYARI_USD2Y, "SYSN2_SAITEIHSYARI_USD2Y", false);
        addPattern(PATTERN_DEFAULT, SYSN2_SAITEIHSYARI_AUD2Y, "SYSN2_SAITEIHSYARI_AUD2Y", false);
        addPattern(PATTERN_DEFAULT, SYSN2_YENDTHNK2Y, "SYSN2_YENDTHNK2Y", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KKT_USD5Y_TEIKISHRNASI, "NENKIN_KKT_USD5Y_TEIKISHRNASI", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KKT_USD10Y_TEIKISHRNASI, "NENKIN_KKT_USD10Y_TEIKISHRNASI", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KKT_USD15Y_TEIKISHRNASI, "NENKIN_KKT_USD15Y_TEIKISHRNASI", false);
        addPattern(PATTERN_DEFAULT, NENKIN_SGKHSYSYSN_USD_TEIKISHRNASI, "NENKIN_SGKHSYSYSN_USD_TEIKISHRNASI", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KKT_AUD5Y_TEIKISHRNASI, "NENKIN_KKT_AUD5Y_TEIKISHRNASI", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KKT_AUD10Y_TEIKISHRNASI, "NENKIN_KKT_AUD10Y_TEIKISHRNASI", false);
        addPattern(PATTERN_DEFAULT, NENKIN_KKT_AUD15Y_TEIKISHRNASI, "NENKIN_KKT_AUD15Y_TEIKISHRNASI", false);
        addPattern(PATTERN_DEFAULT, NENKIN_SGKHSYSYSN_AUD_TEIKISHRNASI, "NENKIN_SGKHSYSYSN_AUD_TEIKISHRNASI", false);
        addPattern(PATTERN_DEFAULT, SYSN_TEIKAIYAKUHRKN, "SYSN_TEIKAIYAKUHRKN", false);


        lock(C_SelHokensyuruiKbn.class);
    }

    private C_SelHokensyuruiKbn(String value) {
        super(value);
    }

    public static C_SelHokensyuruiKbn valueOf(String value) {
        return valueOf(C_SelHokensyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SelHokensyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SelHokensyuruiKbn.class, patternId, value);
    }
}
