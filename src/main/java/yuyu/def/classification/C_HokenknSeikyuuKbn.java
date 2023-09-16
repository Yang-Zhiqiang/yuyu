
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険金請求区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HokenknSeikyuuKbn</td><td colspan="3">保険金請求区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;1&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;2&quot;</td><td>高度障害</td></tr>
 * </table>
 */
public class C_HokenknSeikyuuKbn extends Classification<C_HokenknSeikyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HokenknSeikyuuKbn BLNK = new C_HokenknSeikyuuKbn("0");

    public static final C_HokenknSeikyuuKbn SIBOU = new C_HokenknSeikyuuKbn("1");

    public static final C_HokenknSeikyuuKbn KOUDOSYOUGAI = new C_HokenknSeikyuuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);


        lock(C_HokenknSeikyuuKbn.class);
    }

    private C_HokenknSeikyuuKbn(String value) {
        super(value);
    }

    public static C_HokenknSeikyuuKbn valueOf(String value) {
        return valueOf(C_HokenknSeikyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HokenknSeikyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HokenknSeikyuuKbn.class, patternId, value);
    }
}
