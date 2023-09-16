
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振替伝票作成区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HuridensksKbn</td><td colspan="3">振替伝票作成区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GYOUMUIGAI}</td><td>&quot;1&quot;</td><td>業務所管室以外の処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENYAKAN}</td><td>&quot;2&quot;</td><td>本社保全関係の夜間処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOBETU}</td><td>&quot;3&quot;</td><td>個別調整要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINEFB}</td><td>&quot;4&quot;</td><td>オンラインFB処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSYARYOUKIN}</td><td>&quot;5&quot;</td><td>本社料金関係の処理</td></tr>
 * </table>
 */
public class C_HuridensksKbn extends Classification<C_HuridensksKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HuridensksKbn BLNK = new C_HuridensksKbn("0");

    public static final C_HuridensksKbn GYOUMUIGAI = new C_HuridensksKbn("1");

    public static final C_HuridensksKbn HOZENYAKAN = new C_HuridensksKbn("2");

    public static final C_HuridensksKbn KOBETU = new C_HuridensksKbn("3");

    public static final C_HuridensksKbn ONLINEFB = new C_HuridensksKbn("4");

    public static final C_HuridensksKbn HONSYARYOUKIN = new C_HuridensksKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GYOUMUIGAI, "GYOUMUIGAI", false);
        addPattern(PATTERN_DEFAULT, HOZENYAKAN, "HOZENYAKAN", false);
        addPattern(PATTERN_DEFAULT, KOBETU, "KOBETU", false);
        addPattern(PATTERN_DEFAULT, ONLINEFB, "ONLINEFB", false);
        addPattern(PATTERN_DEFAULT, HONSYARYOUKIN, "HONSYARYOUKIN", false);


        lock(C_HuridensksKbn.class);
    }

    private C_HuridensksKbn(String value) {
        super(value);
    }

    public static C_HuridensksKbn valueOf(String value) {
        return valueOf(C_HuridensksKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HuridensksKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HuridensksKbn.class, patternId, value);
    }
}
