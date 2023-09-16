
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 伝票用支払方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DenshrhouKbn</td><td colspan="3">伝票用支払方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FBSOUKINYOKU}</td><td>&quot;01&quot;</td><td>ＦＢ送金（オンラインＦＢ着金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FBSOUKIN}</td><td>&quot;02&quot;</td><td>ＦＢ送金（夜間、個別業務オンライン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKERSKARI}</td><td>&quot;03&quot;</td><td>仮受計上（利息計算あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKERSKNASI}</td><td>&quot;04&quot;</td><td>仮受計上（利息計算なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITHENKIN_MINUSURIAGE}</td><td>&quot;05&quot;</td><td>クレカ返金（マイナス売上）</td></tr>
 * </table>
 */
public class C_DenshrhouKbn extends Classification<C_DenshrhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DenshrhouKbn BLNK = new C_DenshrhouKbn("0");

    public static final C_DenshrhouKbn FBSOUKINYOKU = new C_DenshrhouKbn("01");

    public static final C_DenshrhouKbn FBSOUKIN = new C_DenshrhouKbn("02");

    public static final C_DenshrhouKbn KARIUKERSKARI = new C_DenshrhouKbn("03");

    public static final C_DenshrhouKbn KARIUKERSKNASI = new C_DenshrhouKbn("04");

    public static final C_DenshrhouKbn CREDITHENKIN_MINUSURIAGE = new C_DenshrhouKbn("05");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FBSOUKINYOKU, "FBSOUKINYOKU", false);
        addPattern(PATTERN_DEFAULT, FBSOUKIN, "FBSOUKIN", false);
        addPattern(PATTERN_DEFAULT, KARIUKERSKARI, "KARIUKERSKARI", false);
        addPattern(PATTERN_DEFAULT, KARIUKERSKNASI, "KARIUKERSKNASI", false);
        addPattern(PATTERN_DEFAULT, CREDITHENKIN_MINUSURIAGE, "CREDITHENKIN_MINUSURIAGE", false);


        lock(C_DenshrhouKbn.class);
    }

    private C_DenshrhouKbn(String value) {
        super(value);
    }

    public static C_DenshrhouKbn valueOf(String value) {
        return valueOf(C_DenshrhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DenshrhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DenshrhouKbn.class, patternId, value);
    }
}
