
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ取引サービス停止理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsTrhkserviceTeisiRiyuuKbn</td><td colspan="3">ＤＳ取引サービス停止理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOCK_OUT}</td><td>&quot;1&quot;</td><td>ロックアウト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKYAKUSAMAYOUBOU}</td><td>&quot;2&quot;</td><td>お客様要望</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETU}</td><td>&quot;3&quot;</td><td>契約無効による消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_DsTrhkserviceTeisiRiyuuKbn extends Classification<C_DsTrhkserviceTeisiRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsTrhkserviceTeisiRiyuuKbn BLNK = new C_DsTrhkserviceTeisiRiyuuKbn("0");

    public static final C_DsTrhkserviceTeisiRiyuuKbn LOCK_OUT = new C_DsTrhkserviceTeisiRiyuuKbn("1");

    public static final C_DsTrhkserviceTeisiRiyuuKbn OKYAKUSAMAYOUBOU = new C_DsTrhkserviceTeisiRiyuuKbn("2");

    public static final C_DsTrhkserviceTeisiRiyuuKbn SYOUMETU = new C_DsTrhkserviceTeisiRiyuuKbn("3");

    public static final C_DsTrhkserviceTeisiRiyuuKbn SONOTA = new C_DsTrhkserviceTeisiRiyuuKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, LOCK_OUT, "LOCK_OUT", false);
        addPattern(PATTERN_DEFAULT, OKYAKUSAMAYOUBOU, "OKYAKUSAMAYOUBOU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETU, "SYOUMETU", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_DsTrhkserviceTeisiRiyuuKbn.class);
    }

    private C_DsTrhkserviceTeisiRiyuuKbn(String value) {
        super(value);
    }

    public static C_DsTrhkserviceTeisiRiyuuKbn valueOf(String value) {
        return valueOf(C_DsTrhkserviceTeisiRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsTrhkserviceTeisiRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsTrhkserviceTeisiRiyuuKbn.class, patternId, value);
    }
}
