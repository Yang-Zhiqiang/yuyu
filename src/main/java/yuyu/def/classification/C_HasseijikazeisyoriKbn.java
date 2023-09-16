
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 発生時課税処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HasseijikazeisyoriKbn</td><td colspan="3">発生時課税処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNK}</td><td>&quot;01&quot;</td><td>目標額到達時円建変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMINYUUSYOUMETU}</td><td>&quot;02&quot;</td><td>Ｐ未入消滅</td></tr>
 * </table>
 */
public class C_HasseijikazeisyoriKbn extends Classification<C_HasseijikazeisyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HasseijikazeisyoriKbn BLNK = new C_HasseijikazeisyoriKbn("0");

    public static final C_HasseijikazeisyoriKbn MKHGKTTTYENDTHNK = new C_HasseijikazeisyoriKbn("01");

    public static final C_HasseijikazeisyoriKbn PMINYUUSYOUMETU = new C_HasseijikazeisyoriKbn("02");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MKHGKTTTYENDTHNK, "MKHGKTTTYENDTHNK", false);
        addPattern(PATTERN_DEFAULT, PMINYUUSYOUMETU, "PMINYUUSYOUMETU", false);


        lock(C_HasseijikazeisyoriKbn.class);
    }

    private C_HasseijikazeisyoriKbn(String value) {
        super(value);
    }

    public static C_HasseijikazeisyoriKbn valueOf(String value) {
        return valueOf(C_HasseijikazeisyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HasseijikazeisyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HasseijikazeisyoriKbn.class, patternId, value);
    }
}
