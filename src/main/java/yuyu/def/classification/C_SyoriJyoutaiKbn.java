
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 処理状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoriJyoutaiKbn</td><td colspan="3">処理状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORITYUU}</td><td>&quot;1&quot;</td><td>処理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;9&quot;</td><td>完了</td></tr>
 * </table>
 */
public class C_SyoriJyoutaiKbn extends Classification<C_SyoriJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoriJyoutaiKbn BLNK = new C_SyoriJyoutaiKbn("0");

    public static final C_SyoriJyoutaiKbn SYORITYUU = new C_SyoriJyoutaiKbn("1");

    public static final C_SyoriJyoutaiKbn KANRYOU = new C_SyoriJyoutaiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYORITYUU, "SYORITYUU", false);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);


        lock(C_SyoriJyoutaiKbn.class);
    }

    private C_SyoriJyoutaiKbn(String value) {
        super(value);
    }

    public static C_SyoriJyoutaiKbn valueOf(String value) {
        return valueOf(C_SyoriJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoriJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoriJyoutaiKbn.class, patternId, value);
    }
}
