
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtensyKbn</td><td colspan="3">代理店種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU1}</td><td>&quot;01&quot;</td><td>Ｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU2}</td><td>&quot;02&quot;</td><td>Ａ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU51}</td><td>&quot;51&quot;</td><td>Ｓ（特殊地銀）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU99}</td><td>&quot;99&quot;</td><td>直扱</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NORMAL NORMAL}<br />(標準)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU1}</td><td>&quot;01&quot;</td><td>Ｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU2}</td><td>&quot;02&quot;</td><td>Ａ</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_TYOKU TYOKU}<br />(直扱用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU99}</td><td>&quot;99&quot;</td><td>直扱</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_MEISAI MEISAI}<br />(帳票用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU1}</td><td>&quot;01&quot;</td><td>S</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU2}</td><td>&quot;02&quot;</td><td>A</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU51}</td><td>&quot;51&quot;</td><td>ブランク</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SENGYOU SENGYOU}<br />(代理店登録用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU1}</td><td>&quot;01&quot;</td><td>Ｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU2}</td><td>&quot;02&quot;</td><td>Ａ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUBETU51}</td><td>&quot;51&quot;</td><td>Ｓ（特殊地銀）</td></tr>
 * </table>
 */
public class C_DrtensyKbn extends Classification<C_DrtensyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtensyKbn BLNK = new C_DrtensyKbn("00");

    public static final C_DrtensyKbn SYUBETU1 = new C_DrtensyKbn("01");

    public static final C_DrtensyKbn SYUBETU2 = new C_DrtensyKbn("02");

    public static final C_DrtensyKbn SYUBETU51 = new C_DrtensyKbn("51");

    public static final C_DrtensyKbn SYUBETU99 = new C_DrtensyKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NORMAL = "2";

    public static final String PATTERN_TYOKU = "3";

    public static final String PATTERN_MEISAI = "4";

    public static final String PATTERN_SENGYOU = "5";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYUBETU1, "SYUBETU1", false);
        addPattern(PATTERN_DEFAULT, SYUBETU2, "SYUBETU2", false);
        addPattern(PATTERN_DEFAULT, SYUBETU51, "SYUBETU51", false);
        addPattern(PATTERN_DEFAULT, SYUBETU99, "SYUBETU99", false);


        addPattern(PATTERN_NORMAL, BLNK, "BLNK", true);
        addPattern(PATTERN_NORMAL, SYUBETU1, "SYUBETU1", false);
        addPattern(PATTERN_NORMAL, SYUBETU2, "SYUBETU2", false);


        addPattern(PATTERN_TYOKU, BLNK, "BLNK", true);
        addPattern(PATTERN_TYOKU, SYUBETU99, "SYUBETU99", false);


        addPattern(PATTERN_MEISAI, BLNK, "BLNK", true);
        addPattern(PATTERN_MEISAI, SYUBETU1, "SYUBETU1", false);
        addPattern(PATTERN_MEISAI, SYUBETU2, "SYUBETU2", false);
        addPattern(PATTERN_MEISAI, SYUBETU51, "SYUBETU51", false);


        addPattern(PATTERN_SENGYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SENGYOU, SYUBETU1, "SYUBETU1", false);
        addPattern(PATTERN_SENGYOU, SYUBETU2, "SYUBETU2", false);
        addPattern(PATTERN_SENGYOU, SYUBETU51, "SYUBETU51", false);


        lock(C_DrtensyKbn.class);
    }

    private C_DrtensyKbn(String value) {
        super(value);
    }

    public static C_DrtensyKbn valueOf(String value) {
        return valueOf(C_DrtensyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtensyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtensyKbn.class, patternId, value);
    }
}
