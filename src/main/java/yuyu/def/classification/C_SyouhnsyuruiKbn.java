
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 商品種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyouhnsyuruiKbn</td><td colspan="3">商品種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINHOKEN}</td><td>&quot;1&quot;</td><td>個人保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINNENKIN}</td><td>&quot;2&quot;</td><td>個人年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYOUHOKEN}</td><td>&quot;3&quot;</td><td>医療保険</td></tr>
 * </table>
 */
public class C_SyouhnsyuruiKbn extends Classification<C_SyouhnsyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyouhnsyuruiKbn BLNK = new C_SyouhnsyuruiKbn("0");

    public static final C_SyouhnsyuruiKbn KOJINHOKEN = new C_SyouhnsyuruiKbn("1");

    public static final C_SyouhnsyuruiKbn KOJINNENKIN = new C_SyouhnsyuruiKbn("2");

    public static final C_SyouhnsyuruiKbn IRYOUHOKEN = new C_SyouhnsyuruiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOJINHOKEN, "KOJINHOKEN", false);
        addPattern(PATTERN_DEFAULT, KOJINNENKIN, "KOJINNENKIN", false);
        addPattern(PATTERN_DEFAULT, IRYOUHOKEN, "IRYOUHOKEN", false);


        lock(C_SyouhnsyuruiKbn.class);
    }

    private C_SyouhnsyuruiKbn(String value) {
        super(value);
    }

    public static C_SyouhnsyuruiKbn valueOf(String value) {
        return valueOf(C_SyouhnsyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyouhnsyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyouhnsyuruiKbn.class, patternId, value);
    }
}
