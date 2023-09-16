
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 照会区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoukaiKbn</td><td colspan="3">照会区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MINYUU}</td><td>&quot;minyuu&quot;</td><td>未入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;sikkou&quot;</td><td>失効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;kaiyaku&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;hukkatu&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAIKEKKATORIKOMI}</td><td>&quot;siharaikekkatorikomi&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUSYOHENKOU}</td><td>&quot;jyuusyohenkou&quot;</td><td>住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHENKOU}</td><td>&quot;meigihenkou&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUHENKOU}</td><td>&quot;keiyakuhenkou&quot;</td><td>契約変更（減額・特約解約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIKATAHENKOU}</td><td>&quot;haraikatahenkou&quot;</td><td>保険料払方変更</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_ITIRAN ITIRAN}<br />(各種一覧照会用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MINYUU}</td><td>&quot;minyuu&quot;</td><td>未入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;sikkou&quot;</td><td>失効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;kaiyaku&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;hukkatu&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAIKEKKATORIKOMI}</td><td>&quot;siharaikekkatorikomi&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUSYOHENKOU}</td><td>&quot;jyuusyohenkou&quot;</td><td>住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHENKOU}</td><td>&quot;meigihenkou&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUHENKOU}</td><td>&quot;keiyakuhenkou&quot;</td><td>契約変更（減額・特約解約）</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_KYK KYK}<br />(契約内容照会用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;sikkou&quot;</td><td>失効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;kaiyaku&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;hukkatu&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUSYOHENKOU}</td><td>&quot;jyuusyohenkou&quot;</td><td>住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHENKOU}</td><td>&quot;meigihenkou&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUHENKOU}</td><td>&quot;keiyakuhenkou&quot;</td><td>契約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIKATAHENKOU}</td><td>&quot;haraikatahenkou&quot;</td><td>保険料払方変更</td></tr>
 * </table>
 */
public class C_SyoukaiKbn extends Classification<C_SyoukaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoukaiKbn BLNK = new C_SyoukaiKbn("0");

    public static final C_SyoukaiKbn MINYUU = new C_SyoukaiKbn("minyuu");

    public static final C_SyoukaiKbn SIKKOU = new C_SyoukaiKbn("sikkou");

    public static final C_SyoukaiKbn KAIYAKU = new C_SyoukaiKbn("kaiyaku");

    public static final C_SyoukaiKbn HUKKATU = new C_SyoukaiKbn("hukkatu");

    public static final C_SyoukaiKbn SIHARAIKEKKATORIKOMI = new C_SyoukaiKbn("siharaikekkatorikomi");

    public static final C_SyoukaiKbn JYUUSYOHENKOU = new C_SyoukaiKbn("jyuusyohenkou");

    public static final C_SyoukaiKbn MEIGIHENKOU = new C_SyoukaiKbn("meigihenkou");

    public static final C_SyoukaiKbn KEIYAKUHENKOU = new C_SyoukaiKbn("keiyakuhenkou");

    public static final C_SyoukaiKbn HARAIKATAHENKOU = new C_SyoukaiKbn("haraikatahenkou");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_ITIRAN = "2";

    public static final String PATTERN_KYK = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MINYUU, "MINYUU", false);
        addPattern(PATTERN_DEFAULT, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_DEFAULT, SIHARAIKEKKATORIKOMI, "SIHARAIKEKKATORIKOMI", false);
        addPattern(PATTERN_DEFAULT, JYUUSYOHENKOU, "JYUUSYOHENKOU", false);
        addPattern(PATTERN_DEFAULT, MEIGIHENKOU, "MEIGIHENKOU", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUHENKOU, "KEIYAKUHENKOU", false);
        addPattern(PATTERN_DEFAULT, HARAIKATAHENKOU, "HARAIKATAHENKOU", false);


        addPattern(PATTERN_ITIRAN, BLNK, "BLNK", false);
        addPattern(PATTERN_ITIRAN, MINYUU, "MINYUU", false);
        addPattern(PATTERN_ITIRAN, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_ITIRAN, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_ITIRAN, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_ITIRAN, SIHARAIKEKKATORIKOMI, "SIHARAIKEKKATORIKOMI", false);
        addPattern(PATTERN_ITIRAN, JYUUSYOHENKOU, "JYUUSYOHENKOU", false);
        addPattern(PATTERN_ITIRAN, MEIGIHENKOU, "MEIGIHENKOU", false);
        addPattern(PATTERN_ITIRAN, KEIYAKUHENKOU, "KEIYAKUHENKOU", false);


        addPattern(PATTERN_KYK, BLNK, "BLNK", false);
        addPattern(PATTERN_KYK, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_KYK, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_KYK, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_KYK, JYUUSYOHENKOU, "JYUUSYOHENKOU", false);
        addPattern(PATTERN_KYK, MEIGIHENKOU, "MEIGIHENKOU", false);
        addPattern(PATTERN_KYK, KEIYAKUHENKOU, "KEIYAKUHENKOU", false);
        addPattern(PATTERN_KYK, HARAIKATAHENKOU, "HARAIKATAHENKOU", false);


        lock(C_SyoukaiKbn.class);
    }

    private C_SyoukaiKbn(String value) {
        super(value);
    }

    public static C_SyoukaiKbn valueOf(String value) {
        return valueOf(C_SyoukaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoukaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoukaiKbn.class, patternId, value);
    }
}
