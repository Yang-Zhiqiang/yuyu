
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 次回年金受取方法 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Nextnkuktrhou</td><td colspan="3">次回年金受取方法</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOU_GENZAI}</td><td>&quot;1&quot;</td><td>自動支払（現在の口座）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOU_JYOUKI}</td><td>&quot;2&quot;</td><td>自動支払（上記口座）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDE}</td><td>&quot;3&quot;</td><td>申出支払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_MOUSIDE MOUSIDE}<br />(申出支払用)</td><td align="center">○</td><td>{@link #JIDOU_JYOUKI}</td><td>&quot;2&quot;</td><td>自動支払（上記口座）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDE}</td><td>&quot;3&quot;</td><td>申出支払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOTGINKOU NOTGINKOU}<br />(自動支払かつ銀行以外)</td><td align="center">○</td><td>{@link #JIDOU_GENZAI}</td><td>&quot;1&quot;</td><td>自動支払（現在の口座）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDE}</td><td>&quot;3&quot;</td><td>申出支払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_JIDOU JIDOU}<br />(自動支払用)</td><td align="center">○</td><td>{@link #JIDOU_GENZAI}</td><td>&quot;1&quot;</td><td>自動支払（現在の口座）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOU_JYOUKI}</td><td>&quot;2&quot;</td><td>自動支払（上記口座）</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_JYOUKI JYOUKI}<br />(上記口座のみ)</td><td align="center">○</td><td>{@link #JIDOU_JYOUKI}</td><td>&quot;2&quot;</td><td>自動支払（上記口座）</td></tr>
 * </table>
 */
public class C_Nextnkuktrhou extends Classification<C_Nextnkuktrhou> {

    private static final long serialVersionUID = 1L;


    public static final C_Nextnkuktrhou BLNK = new C_Nextnkuktrhou("0");

    public static final C_Nextnkuktrhou JIDOU_GENZAI = new C_Nextnkuktrhou("1");

    public static final C_Nextnkuktrhou JIDOU_JYOUKI = new C_Nextnkuktrhou("2");

    public static final C_Nextnkuktrhou MOUSIDE = new C_Nextnkuktrhou("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_MOUSIDE = "2";

    public static final String PATTERN_NOTGINKOU = "3";

    public static final String PATTERN_JIDOU = "4";

    public static final String PATTERN_JYOUKI = "5";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JIDOU_GENZAI, "JIDOU_GENZAI", false);
        addPattern(PATTERN_DEFAULT, JIDOU_JYOUKI, "JIDOU_JYOUKI", false);
        addPattern(PATTERN_DEFAULT, MOUSIDE, "MOUSIDE", false);


        addPattern(PATTERN_MOUSIDE, JIDOU_JYOUKI, "JIDOU_JYOUKI", true);
        addPattern(PATTERN_MOUSIDE, MOUSIDE, "MOUSIDE", false);


        addPattern(PATTERN_NOTGINKOU, JIDOU_GENZAI, "JIDOU_GENZAI", true);
        addPattern(PATTERN_NOTGINKOU, MOUSIDE, "MOUSIDE", false);


        addPattern(PATTERN_JIDOU, JIDOU_GENZAI, "JIDOU_GENZAI", true);
        addPattern(PATTERN_JIDOU, JIDOU_JYOUKI, "JIDOU_JYOUKI", false);


        addPattern(PATTERN_JYOUKI, JIDOU_JYOUKI, "JIDOU_JYOUKI", true);


        lock(C_Nextnkuktrhou.class);
    }

    private C_Nextnkuktrhou(String value) {
        super(value);
    }

    public static C_Nextnkuktrhou valueOf(String value) {
        return valueOf(C_Nextnkuktrhou.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Nextnkuktrhou.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Nextnkuktrhou.class, patternId, value);
    }
}
