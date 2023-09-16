
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 稼働時間曜日区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KadouTimeYoubiKbn</td><td colspan="3">稼働時間曜日区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #NITIYOU}</td><td>&quot;1&quot;</td><td>日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GETUYOU}</td><td>&quot;2&quot;</td><td>月</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAYOU}</td><td>&quot;3&quot;</td><td>火</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUIYOU}</td><td>&quot;4&quot;</td><td>水</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOKUYOU}</td><td>&quot;5&quot;</td><td>木</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINYOU}</td><td>&quot;6&quot;</td><td>金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOYOU}</td><td>&quot;7&quot;</td><td>土</td></tr>
 *  <tr><td align="center">○</td><td>{@link #HYOUJYUN}</td><td>&quot;8&quot;</td><td>標準</td></tr>
 * </table>
 */
public class C_KadouTimeYoubiKbn extends Classification<C_KadouTimeYoubiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KadouTimeYoubiKbn NITIYOU = new C_KadouTimeYoubiKbn("1");

    public static final C_KadouTimeYoubiKbn GETUYOU = new C_KadouTimeYoubiKbn("2");

    public static final C_KadouTimeYoubiKbn KAYOU = new C_KadouTimeYoubiKbn("3");

    public static final C_KadouTimeYoubiKbn SUIYOU = new C_KadouTimeYoubiKbn("4");

    public static final C_KadouTimeYoubiKbn MOKUYOU = new C_KadouTimeYoubiKbn("5");

    public static final C_KadouTimeYoubiKbn KINYOU = new C_KadouTimeYoubiKbn("6");

    public static final C_KadouTimeYoubiKbn DOYOU = new C_KadouTimeYoubiKbn("7");

    public static final C_KadouTimeYoubiKbn HYOUJYUN = new C_KadouTimeYoubiKbn("8");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NITIYOU, "NITIYOU", false);
        addPattern(PATTERN_DEFAULT, GETUYOU, "GETUYOU", false);
        addPattern(PATTERN_DEFAULT, KAYOU, "KAYOU", false);
        addPattern(PATTERN_DEFAULT, SUIYOU, "SUIYOU", false);
        addPattern(PATTERN_DEFAULT, MOKUYOU, "MOKUYOU", false);
        addPattern(PATTERN_DEFAULT, KINYOU, "KINYOU", false);
        addPattern(PATTERN_DEFAULT, DOYOU, "DOYOU", false);
        addPattern(PATTERN_DEFAULT, HYOUJYUN, "HYOUJYUN", true);


        lock(C_KadouTimeYoubiKbn.class);
    }

    private C_KadouTimeYoubiKbn(String value) {
        super(value);
    }

    public static C_KadouTimeYoubiKbn valueOf(String value) {
        return valueOf(C_KadouTimeYoubiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KadouTimeYoubiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KadouTimeYoubiKbn.class, patternId, value);
    }
}
