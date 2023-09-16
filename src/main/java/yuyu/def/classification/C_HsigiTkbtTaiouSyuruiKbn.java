
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 被災害特別対応種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HsigiTkbtTaiouSyuruiKbn</td><td colspan="3">被災害特別対応種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETU1}</td><td>&quot;01&quot;</td><td>特別被災害特伸１</td></tr>
 * </table>
 */
public class C_HsigiTkbtTaiouSyuruiKbn extends Classification<C_HsigiTkbtTaiouSyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HsigiTkbtTaiouSyuruiKbn BLNK = new C_HsigiTkbtTaiouSyuruiKbn("00");

    public static final C_HsigiTkbtTaiouSyuruiKbn TOKUBETU1 = new C_HsigiTkbtTaiouSyuruiKbn("01");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOKUBETU1, "TOKUBETU1", false);


        lock(C_HsigiTkbtTaiouSyuruiKbn.class);
    }

    private C_HsigiTkbtTaiouSyuruiKbn(String value) {
        super(value);
    }

    public static C_HsigiTkbtTaiouSyuruiKbn valueOf(String value) {
        return valueOf(C_HsigiTkbtTaiouSyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HsigiTkbtTaiouSyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HsigiTkbtTaiouSyuruiKbn.class, patternId, value);
    }
}
