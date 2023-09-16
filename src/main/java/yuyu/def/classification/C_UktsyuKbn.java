
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受取人種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UktsyuKbn</td><td colspan="3">受取人種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKT}</td><td>&quot;1&quot;</td><td>死亡受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRSK}</td><td>&quot;2&quot;</td><td>被保険者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKUKT}</td><td>&quot;3&quot;</td><td>年金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZKNKUKT}</td><td>&quot;4&quot;</td><td>継続年金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHENKANUKT}</td><td>&quot;5&quot;</td><td>死亡返還金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDRN}</td><td>&quot;6&quot;</td><td>契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKSHKUKT}</td><td>&quot;7&quot;</td><td>定期支払金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #SBUKT}</td><td>&quot;1&quot;</td><td>死亡受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRSK}</td><td>&quot;2&quot;</td><td>被保険者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKUKT}</td><td>&quot;3&quot;</td><td>年金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZKNKUKT}</td><td>&quot;4&quot;</td><td>継続年金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHENKANUKT}</td><td>&quot;5&quot;</td><td>死亡返還金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDRN}</td><td>&quot;6&quot;</td><td>契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKSHKUKT}</td><td>&quot;7&quot;</td><td>定期支払金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_RRKGAMEN RRKGAMEN}<br />(変更履歴画面表示用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKT}</td><td>&quot;1&quot;</td><td>死亡受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRSK}</td><td>&quot;2&quot;</td><td>被保険者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKUKT}</td><td>&quot;3&quot;</td><td>年金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZKNKUKT}</td><td>&quot;4&quot;</td><td>継続年金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHENKANUKT}</td><td>&quot;5&quot;</td><td>死亡返還金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDRN}</td><td>&quot;6&quot;</td><td>契約者代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKSHKUKT}</td><td>&quot;7&quot;</td><td>定期支払金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_UktsyuKbn extends Classification<C_UktsyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UktsyuKbn BLNK = new C_UktsyuKbn("0");

    public static final C_UktsyuKbn SBUKT = new C_UktsyuKbn("1");

    public static final C_UktsyuKbn STDRSK = new C_UktsyuKbn("2");

    public static final C_UktsyuKbn NKUKT = new C_UktsyuKbn("3");

    public static final C_UktsyuKbn KEIZKNKUKT = new C_UktsyuKbn("4");

    public static final C_UktsyuKbn SBHENKANUKT = new C_UktsyuKbn("5");

    public static final C_UktsyuKbn KYKDRN = new C_UktsyuKbn("6");

    public static final C_UktsyuKbn TKSHKUKT = new C_UktsyuKbn("7");

    public static final C_UktsyuKbn SONOTA = new C_UktsyuKbn("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_RRKGAMEN = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SBUKT, "SBUKT", false);
        addPattern(PATTERN_DEFAULT, STDRSK, "STDRSK", false);
        addPattern(PATTERN_DEFAULT, NKUKT, "NKUKT", false);
        addPattern(PATTERN_DEFAULT, KEIZKNKUKT, "KEIZKNKUKT", false);
        addPattern(PATTERN_DEFAULT, SBHENKANUKT, "SBHENKANUKT", false);
        addPattern(PATTERN_DEFAULT, KYKDRN, "KYKDRN", false);
        addPattern(PATTERN_DEFAULT, TKSHKUKT, "TKSHKUKT", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_NOBLNK, SBUKT, "SBUKT", false);
        addPattern(PATTERN_NOBLNK, STDRSK, "STDRSK", false);
        addPattern(PATTERN_NOBLNK, NKUKT, "NKUKT", false);
        addPattern(PATTERN_NOBLNK, KEIZKNKUKT, "KEIZKNKUKT", false);
        addPattern(PATTERN_NOBLNK, SBHENKANUKT, "SBHENKANUKT", false);
        addPattern(PATTERN_NOBLNK, KYKDRN, "KYKDRN", false);
        addPattern(PATTERN_NOBLNK, TKSHKUKT, "TKSHKUKT", false);
        addPattern(PATTERN_NOBLNK, SONOTA, "SONOTA", false);


        addPattern(PATTERN_RRKGAMEN, BLNK, "BLNK", false);
        addPattern(PATTERN_RRKGAMEN, SBUKT, "SBUKT", false);
        addPattern(PATTERN_RRKGAMEN, STDRSK, "STDRSK", false);
        addPattern(PATTERN_RRKGAMEN, NKUKT, "NKUKT", false);
        addPattern(PATTERN_RRKGAMEN, KEIZKNKUKT, "KEIZKNKUKT", false);
        addPattern(PATTERN_RRKGAMEN, SBHENKANUKT, "SBHENKANUKT", false);
        addPattern(PATTERN_RRKGAMEN, KYKDRN, "KYKDRN", false);
        addPattern(PATTERN_RRKGAMEN, TKSHKUKT, "TKSHKUKT", false);
        addPattern(PATTERN_RRKGAMEN, SONOTA, "SONOTA", false);


        lock(C_UktsyuKbn.class);
    }

    private C_UktsyuKbn(String value) {
        super(value);
    }

    public static C_UktsyuKbn valueOf(String value) {
        return valueOf(C_UktsyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UktsyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UktsyuKbn.class, patternId, value);
    }
}
