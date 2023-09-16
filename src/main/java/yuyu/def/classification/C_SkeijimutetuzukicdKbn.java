
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約事務手続コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SkeijimutetuzukicdKbn</td><td colspan="3">新契約事務手続コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKEI}</td><td>&quot;skei&quot;</td><td>ショップ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKWB}</td><td>&quot;skwb&quot;</td><td>Ｗｅｂ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKMD}</td><td>&quot;skmd&quot;</td><td>ＳＭＢＣ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKSK}</td><td>&quot;sksk&quot;</td><td>信金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKTG}</td><td>&quot;sktg&quot;</td><td>地銀</td></tr>
 * </table>
 */
public class C_SkeijimutetuzukicdKbn extends Classification<C_SkeijimutetuzukicdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SkeijimutetuzukicdKbn BLNK = new C_SkeijimutetuzukicdKbn("0");

    public static final C_SkeijimutetuzukicdKbn SKEI = new C_SkeijimutetuzukicdKbn("skei");

    public static final C_SkeijimutetuzukicdKbn SKWB = new C_SkeijimutetuzukicdKbn("skwb");

    public static final C_SkeijimutetuzukicdKbn SKMD = new C_SkeijimutetuzukicdKbn("skmd");

    public static final C_SkeijimutetuzukicdKbn SKSK = new C_SkeijimutetuzukicdKbn("sksk");

    public static final C_SkeijimutetuzukicdKbn SKTG = new C_SkeijimutetuzukicdKbn("sktg");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SKEI, "SKEI", false);
        addPattern(PATTERN_DEFAULT, SKWB, "SKWB", false);
        addPattern(PATTERN_DEFAULT, SKMD, "SKMD", false);
        addPattern(PATTERN_DEFAULT, SKSK, "SKSK", false);
        addPattern(PATTERN_DEFAULT, SKTG, "SKTG", false);


        lock(C_SkeijimutetuzukicdKbn.class);
    }

    private C_SkeijimutetuzukicdKbn(String value) {
        super(value);
    }

    public static C_SkeijimutetuzukicdKbn valueOf(String value) {
        return valueOf(C_SkeijimutetuzukicdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SkeijimutetuzukicdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SkeijimutetuzukicdKbn.class, patternId, value);
    }
}
