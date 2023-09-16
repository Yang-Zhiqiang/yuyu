
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金変更請求内容 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkhkSeikyuuNaiyou</td><td colspan="3">年金変更請求内容</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITJSHR}</td><td>&quot;1&quot;</td><td>年金一時金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;2&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIJYUSYO_HK}</td><td>&quot;3&quot;</td><td>年金名義住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JDSHKZHK}</td><td>&quot;4&quot;</td><td>年金自動支払口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BNKT_SHRKAISU_HK}</td><td>&quot;5&quot;</td><td>年金分割支払回数変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SS_SAIHAKOU}</td><td>&quot;6&quot;</td><td>年金証書再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKYKHNK_STDRSKTKY}</td><td>&quot;7&quot;</td><td>年金特約変更（指定代理請求特約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKYKHNK_KKNKUKT}</td><td>&quot;8&quot;</td><td>年金特約変更（後継年金受取人）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAITOUKIN_UKTRHOU_HK}</td><td>&quot;9&quot;</td><td>年金配当金受取方法変更</td></tr>
 * </table>
 */
public class C_NkhkSeikyuuNaiyou extends Classification<C_NkhkSeikyuuNaiyou> {

    private static final long serialVersionUID = 1L;


    public static final C_NkhkSeikyuuNaiyou BLNK = new C_NkhkSeikyuuNaiyou("0");

    public static final C_NkhkSeikyuuNaiyou ITJSHR = new C_NkhkSeikyuuNaiyou("1");

    public static final C_NkhkSeikyuuNaiyou SIBOU = new C_NkhkSeikyuuNaiyou("2");

    public static final C_NkhkSeikyuuNaiyou MEIGIJYUSYO_HK = new C_NkhkSeikyuuNaiyou("3");

    public static final C_NkhkSeikyuuNaiyou JDSHKZHK = new C_NkhkSeikyuuNaiyou("4");

    public static final C_NkhkSeikyuuNaiyou BNKT_SHRKAISU_HK = new C_NkhkSeikyuuNaiyou("5");

    public static final C_NkhkSeikyuuNaiyou SS_SAIHAKOU = new C_NkhkSeikyuuNaiyou("6");

    public static final C_NkhkSeikyuuNaiyou TKYKHNK_STDRSKTKY = new C_NkhkSeikyuuNaiyou("7");

    public static final C_NkhkSeikyuuNaiyou TKYKHNK_KKNKUKT = new C_NkhkSeikyuuNaiyou("8");

    public static final C_NkhkSeikyuuNaiyou HAITOUKIN_UKTRHOU_HK = new C_NkhkSeikyuuNaiyou("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITJSHR, "ITJSHR", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, MEIGIJYUSYO_HK, "MEIGIJYUSYO_HK", false);
        addPattern(PATTERN_DEFAULT, JDSHKZHK, "JDSHKZHK", false);
        addPattern(PATTERN_DEFAULT, BNKT_SHRKAISU_HK, "BNKT_SHRKAISU_HK", false);
        addPattern(PATTERN_DEFAULT, SS_SAIHAKOU, "SS_SAIHAKOU", false);
        addPattern(PATTERN_DEFAULT, TKYKHNK_STDRSKTKY, "TKYKHNK_STDRSKTKY", false);
        addPattern(PATTERN_DEFAULT, TKYKHNK_KKNKUKT, "TKYKHNK_KKNKUKT", false);
        addPattern(PATTERN_DEFAULT, HAITOUKIN_UKTRHOU_HK, "HAITOUKIN_UKTRHOU_HK", false);


        lock(C_NkhkSeikyuuNaiyou.class);
    }

    private C_NkhkSeikyuuNaiyou(String value) {
        super(value);
    }

    public static C_NkhkSeikyuuNaiyou valueOf(String value) {
        return valueOf(C_NkhkSeikyuuNaiyou.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkhkSeikyuuNaiyou.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkhkSeikyuuNaiyou.class, patternId, value);
    }
}
