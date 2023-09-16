
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 選択情報作成理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SntkinfosakuseiriyuuKbn</td><td colspan="3">選択情報作成理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKJY_SKEI}</td><td>&quot;10&quot;</td><td>特条（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYOUKENTUKI_SKEI}</td><td>&quot;20&quot;</td><td>条件付（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKI_SKEI}</td><td>&quot;30&quot;</td><td>延期（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKI_HUKKATU}</td><td>&quot;40&quot;</td><td>延期（復活）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSEIRITU_SKEI}</td><td>&quot;45&quot;</td><td>不成立（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENKAITAISYOUDAKU_SKEI}</td><td>&quot;50&quot;</td><td>限界体承諾（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYHKNSHR}</td><td>&quot;60&quot;</td><td>給付金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYHKNHSHR}</td><td>&quot;61&quot;</td><td>給付金不支払</td></tr>
 * </table>
 */
public class C_SntkinfosakuseiriyuuKbn extends Classification<C_SntkinfosakuseiriyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SntkinfosakuseiriyuuKbn BLNK = new C_SntkinfosakuseiriyuuKbn("0");

    public static final C_SntkinfosakuseiriyuuKbn TKJY_SKEI = new C_SntkinfosakuseiriyuuKbn("10");

    public static final C_SntkinfosakuseiriyuuKbn JYOUKENTUKI_SKEI = new C_SntkinfosakuseiriyuuKbn("20");

    public static final C_SntkinfosakuseiriyuuKbn ENKI_SKEI = new C_SntkinfosakuseiriyuuKbn("30");

    public static final C_SntkinfosakuseiriyuuKbn ENKI_HUKKATU = new C_SntkinfosakuseiriyuuKbn("40");

    public static final C_SntkinfosakuseiriyuuKbn HUSEIRITU_SKEI = new C_SntkinfosakuseiriyuuKbn("45");

    public static final C_SntkinfosakuseiriyuuKbn GENKAITAISYOUDAKU_SKEI = new C_SntkinfosakuseiriyuuKbn("50");

    public static final C_SntkinfosakuseiriyuuKbn KYHKNSHR = new C_SntkinfosakuseiriyuuKbn("60");

    public static final C_SntkinfosakuseiriyuuKbn KYHKNHSHR = new C_SntkinfosakuseiriyuuKbn("61");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TKJY_SKEI, "TKJY_SKEI", false);
        addPattern(PATTERN_DEFAULT, JYOUKENTUKI_SKEI, "JYOUKENTUKI_SKEI", false);
        addPattern(PATTERN_DEFAULT, ENKI_SKEI, "ENKI_SKEI", false);
        addPattern(PATTERN_DEFAULT, ENKI_HUKKATU, "ENKI_HUKKATU", false);
        addPattern(PATTERN_DEFAULT, HUSEIRITU_SKEI, "HUSEIRITU_SKEI", false);
        addPattern(PATTERN_DEFAULT, GENKAITAISYOUDAKU_SKEI, "GENKAITAISYOUDAKU_SKEI", false);
        addPattern(PATTERN_DEFAULT, KYHKNSHR, "KYHKNSHR", false);
        addPattern(PATTERN_DEFAULT, KYHKNHSHR, "KYHKNHSHR", false);


        lock(C_SntkinfosakuseiriyuuKbn.class);
    }

    private C_SntkinfosakuseiriyuuKbn(String value) {
        super(value);
    }

    public static C_SntkinfosakuseiriyuuKbn valueOf(String value) {
        return valueOf(C_SntkinfosakuseiriyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SntkinfosakuseiriyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SntkinfosakuseiriyuuKbn.class, patternId, value);
    }
}
