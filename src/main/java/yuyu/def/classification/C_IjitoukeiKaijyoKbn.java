
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 医事統計解除区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IjitoukeiKaijyoKbn</td><td colspan="3">医事統計解除区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIZONKAIJYO}</td><td>&quot;1&quot;</td><td>生存解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKEITORIKESI}</td><td>&quot;2&quot;</td><td>新契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKAIJYO}</td><td>&quot;3&quot;</td><td>死亡解除</td></tr>
 * </table>
 */
public class C_IjitoukeiKaijyoKbn extends Classification<C_IjitoukeiKaijyoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IjitoukeiKaijyoKbn BLNK = new C_IjitoukeiKaijyoKbn("0");

    public static final C_IjitoukeiKaijyoKbn SEIZONKAIJYO = new C_IjitoukeiKaijyoKbn("1");

    public static final C_IjitoukeiKaijyoKbn SKEITORIKESI = new C_IjitoukeiKaijyoKbn("2");

    public static final C_IjitoukeiKaijyoKbn SIBOUKAIJYO = new C_IjitoukeiKaijyoKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SEIZONKAIJYO, "SEIZONKAIJYO", false);
        addPattern(PATTERN_DEFAULT, SKEITORIKESI, "SKEITORIKESI", false);
        addPattern(PATTERN_DEFAULT, SIBOUKAIJYO, "SIBOUKAIJYO", false);


        lock(C_IjitoukeiKaijyoKbn.class);
    }

    private C_IjitoukeiKaijyoKbn(String value) {
        super(value);
    }

    public static C_IjitoukeiKaijyoKbn valueOf(String value) {
        return valueOf(C_IjitoukeiKaijyoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IjitoukeiKaijyoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IjitoukeiKaijyoKbn.class, patternId, value);
    }
}
