
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払処理状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SiharaiSyoriJyoutaiKbn</td><td colspan="3">支払処理状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #MISEIKYUU}</td><td>&quot;1&quot;</td><td>未請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKETUKETYUU}</td><td>&quot;2&quot;</td><td>受付中</td></tr>
 *  <tr><td align="center">○</td><td>{@link #SIHARAIZUMI}</td><td>&quot;3&quot;</td><td>支払済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINDANSYORYOUSIHARAI}</td><td>&quot;4&quot;</td><td>診断書料支払</td></tr>
 * </table>
 */
public class C_SiharaiSyoriJyoutaiKbn extends Classification<C_SiharaiSyoriJyoutaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SiharaiSyoriJyoutaiKbn MISEIKYUU = new C_SiharaiSyoriJyoutaiKbn("1");

    public static final C_SiharaiSyoriJyoutaiKbn UKETUKETYUU = new C_SiharaiSyoriJyoutaiKbn("2");

    public static final C_SiharaiSyoriJyoutaiKbn SIHARAIZUMI = new C_SiharaiSyoriJyoutaiKbn("3");

    public static final C_SiharaiSyoriJyoutaiKbn SINDANSYORYOUSIHARAI = new C_SiharaiSyoriJyoutaiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISEIKYUU, "MISEIKYUU", false);
        addPattern(PATTERN_DEFAULT, UKETUKETYUU, "UKETUKETYUU", false);
        addPattern(PATTERN_DEFAULT, SIHARAIZUMI, "SIHARAIZUMI", true);
        addPattern(PATTERN_DEFAULT, SINDANSYORYOUSIHARAI, "SINDANSYORYOUSIHARAI", false);


        lock(C_SiharaiSyoriJyoutaiKbn.class);
    }

    private C_SiharaiSyoriJyoutaiKbn(String value) {
        super(value);
    }

    public static C_SiharaiSyoriJyoutaiKbn valueOf(String value) {
        return valueOf(C_SiharaiSyoriJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SiharaiSyoriJyoutaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SiharaiSyoriJyoutaiKbn.class, patternId, value);
    }
}
