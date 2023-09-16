
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 本社組織権限区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HnsyaSosikiKengenKbn</td><td colspan="3">本社組織権限区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIMU}</td><td>&quot;1&quot;</td><td>本社（事務所管組織）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAI}</td><td>&quot;2&quot;</td><td>本社（照会のみ組織）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIKAIHOU}</td><td>&quot;3&quot;</td><td>本社（非開放組織）</td></tr>
 * </table>
 */
public class C_HnsyaSosikiKengenKbn extends Classification<C_HnsyaSosikiKengenKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HnsyaSosikiKengenKbn BLNK = new C_HnsyaSosikiKengenKbn("0");

    public static final C_HnsyaSosikiKengenKbn JIMU = new C_HnsyaSosikiKengenKbn("1");

    public static final C_HnsyaSosikiKengenKbn SYOUKAI = new C_HnsyaSosikiKengenKbn("2");

    public static final C_HnsyaSosikiKengenKbn HIKAIHOU = new C_HnsyaSosikiKengenKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JIMU, "JIMU", false);
        addPattern(PATTERN_DEFAULT, SYOUKAI, "SYOUKAI", false);
        addPattern(PATTERN_DEFAULT, HIKAIHOU, "HIKAIHOU", false);


        lock(C_HnsyaSosikiKengenKbn.class);
    }

    private C_HnsyaSosikiKengenKbn(String value) {
        super(value);
    }

    public static C_HnsyaSosikiKengenKbn valueOf(String value) {
        return valueOf(C_HnsyaSosikiKengenKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HnsyaSosikiKengenKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HnsyaSosikiKengenKbn.class, patternId, value);
    }
}
