
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 更新機能ＩＤ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoskinouidKbn</td><td colspan="3">更新機能ＩＤ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUINFOTORIKOMI}</td><td>&quot;keiyakuinfotorikomi&quot;</td><td>契約情報取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;hukkatu&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUHENKOU}</td><td>&quot;keiyakuhenkou&quot;</td><td>契約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAIKEKKATORIKOMI}</td><td>&quot;siharaikekkatorikomi&quot;</td><td>支払結果情報取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMAN}</td><td>&quot;haraiman&quot;</td><td>払満処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEI}</td><td>&quot;seinengappisei&quot;</td><td>生年月日・性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIKATAHENKOU}</td><td>&quot;haraikatahenkou&quot;</td><td>払方変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;kaiyaku&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;sikkou&quot;</td><td>失効処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTORIKESI}</td><td>&quot;keiyakutorikesi&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENIKANINFORENDOU}</td><td>&quot;dairitenikaninforendou&quot;</td><td>移管</td></tr>
 * </table>
 */
public class C_KoskinouidKbn extends Classification<C_KoskinouidKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoskinouidKbn BLNK = new C_KoskinouidKbn("0");

    public static final C_KoskinouidKbn KEIYAKUINFOTORIKOMI = new C_KoskinouidKbn("keiyakuinfotorikomi");

    public static final C_KoskinouidKbn HUKKATU = new C_KoskinouidKbn("hukkatu");

    public static final C_KoskinouidKbn KEIYAKUHENKOU = new C_KoskinouidKbn("keiyakuhenkou");

    public static final C_KoskinouidKbn SIHARAIKEKKATORIKOMI = new C_KoskinouidKbn("siharaikekkatorikomi");

    public static final C_KoskinouidKbn HARAIMAN = new C_KoskinouidKbn("haraiman");

    public static final C_KoskinouidKbn SEINENGAPPISEI = new C_KoskinouidKbn("seinengappisei");

    public static final C_KoskinouidKbn HARAIKATAHENKOU = new C_KoskinouidKbn("haraikatahenkou");

    public static final C_KoskinouidKbn KAIYAKU = new C_KoskinouidKbn("kaiyaku");

    public static final C_KoskinouidKbn SIKKOU = new C_KoskinouidKbn("sikkou");

    public static final C_KoskinouidKbn KYKTORIKESI = new C_KoskinouidKbn("keiyakutorikesi");

    public static final C_KoskinouidKbn DAIRITENIKANINFORENDOU = new C_KoskinouidKbn("dairitenikaninforendou");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KEIYAKUINFOTORIKOMI, "KEIYAKUINFOTORIKOMI", false);
        addPattern(PATTERN_DEFAULT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUHENKOU, "KEIYAKUHENKOU", false);
        addPattern(PATTERN_DEFAULT, SIHARAIKEKKATORIKOMI, "SIHARAIKEKKATORIKOMI", false);
        addPattern(PATTERN_DEFAULT, HARAIMAN, "HARAIMAN", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEI, "SEINENGAPPISEI", false);
        addPattern(PATTERN_DEFAULT, HARAIKATAHENKOU, "HARAIKATAHENKOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_DEFAULT, KYKTORIKESI, "KYKTORIKESI", false);
        addPattern(PATTERN_DEFAULT, DAIRITENIKANINFORENDOU, "DAIRITENIKANINFORENDOU", false);


        lock(C_KoskinouidKbn.class);
    }

    private C_KoskinouidKbn(String value) {
        super(value);
    }

    public static C_KoskinouidKbn valueOf(String value) {
        return valueOf(C_KoskinouidKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoskinouidKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoskinouidKbn.class, patternId, value);
    }
}
