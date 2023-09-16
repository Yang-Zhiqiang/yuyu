
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険金本人確認結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SiHonninKakninKekkaKbn</td><td colspan="3">保険金本人確認結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZA}</td><td>&quot;1&quot;</td><td>本人口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZASYORUI}</td><td>&quot;2&quot;</td><td>本人口座＋本人確認書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INKAN}</td><td>&quot;3&quot;</td><td>実印・届出印</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #KOUZA}</td><td>&quot;1&quot;</td><td>本人口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZASYORUI}</td><td>&quot;2&quot;</td><td>本人口座＋本人確認書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INKAN}</td><td>&quot;3&quot;</td><td>実印・届出印</td></tr>
 * </table>
 */
public class C_SiHonninKakninKekkaKbn extends Classification<C_SiHonninKakninKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SiHonninKakninKekkaKbn BLNK = new C_SiHonninKakninKekkaKbn("0");

    public static final C_SiHonninKakninKekkaKbn KOUZA = new C_SiHonninKakninKekkaKbn("1");

    public static final C_SiHonninKakninKekkaKbn KOUZASYORUI = new C_SiHonninKakninKekkaKbn("2");

    public static final C_SiHonninKakninKekkaKbn INKAN = new C_SiHonninKakninKekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOUZA, "KOUZA", false);
        addPattern(PATTERN_DEFAULT, KOUZASYORUI, "KOUZASYORUI", false);
        addPattern(PATTERN_DEFAULT, INKAN, "INKAN", false);


        addPattern(PATTERN_NOBLNK, KOUZA, "KOUZA", true);
        addPattern(PATTERN_NOBLNK, KOUZASYORUI, "KOUZASYORUI", false);
        addPattern(PATTERN_NOBLNK, INKAN, "INKAN", false);


        lock(C_SiHonninKakninKekkaKbn.class);
    }

    private C_SiHonninKakninKekkaKbn(String value) {
        super(value);
    }

    public static C_SiHonninKakninKekkaKbn valueOf(String value) {
        return valueOf(C_SiHonninKakninKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SiHonninKakninKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SiHonninKakninKekkaKbn.class, patternId, value);
    }
}
