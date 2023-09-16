
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 控除証明内容ＴＢＬ編集処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KjsymnytblhensyuusyoriKbn</td><td colspan="3">控除証明内容ＴＢＬ編集処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINHANEI}</td><td>&quot;1&quot;</td><td>入金反映</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOUPHANEI}</td><td>&quot;2&quot;</td><td>要Ｐ反映</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINTORIKESI}</td><td>&quot;3&quot;</td><td>入金取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKEIKAP_SYOUMETU}</td><td>&quot;4&quot;</td><td>未経過保険料（消滅）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKEIKAP_KYKHENKOU}</td><td>&quot;5&quot;</td><td>未経過保険料（契約変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBUMUKOU}</td><td>&quot;6&quot;</td><td>一部無効</td></tr>
 * </table>
 */
public class C_KjsymnytblhensyuusyoriKbn extends Classification<C_KjsymnytblhensyuusyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KjsymnytblhensyuusyoriKbn BLNK = new C_KjsymnytblhensyuusyoriKbn("0");

    public static final C_KjsymnytblhensyuusyoriKbn NYUUKINHANEI = new C_KjsymnytblhensyuusyoriKbn("1");

    public static final C_KjsymnytblhensyuusyoriKbn YOUPHANEI = new C_KjsymnytblhensyuusyoriKbn("2");

    public static final C_KjsymnytblhensyuusyoriKbn NYUUKINTORIKESI = new C_KjsymnytblhensyuusyoriKbn("3");

    public static final C_KjsymnytblhensyuusyoriKbn MIKEIKAP_SYOUMETU = new C_KjsymnytblhensyuusyoriKbn("4");

    public static final C_KjsymnytblhensyuusyoriKbn MIKEIKAP_KYKHENKOU = new C_KjsymnytblhensyuusyoriKbn("5");

    public static final C_KjsymnytblhensyuusyoriKbn ITIBUMUKOU = new C_KjsymnytblhensyuusyoriKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NYUUKINHANEI, "NYUUKINHANEI", false);
        addPattern(PATTERN_DEFAULT, YOUPHANEI, "YOUPHANEI", false);
        addPattern(PATTERN_DEFAULT, NYUUKINTORIKESI, "NYUUKINTORIKESI", false);
        addPattern(PATTERN_DEFAULT, MIKEIKAP_SYOUMETU, "MIKEIKAP_SYOUMETU", false);
        addPattern(PATTERN_DEFAULT, MIKEIKAP_KYKHENKOU, "MIKEIKAP_KYKHENKOU", false);
        addPattern(PATTERN_DEFAULT, ITIBUMUKOU, "ITIBUMUKOU", false);


        lock(C_KjsymnytblhensyuusyoriKbn.class);
    }

    private C_KjsymnytblhensyuusyoriKbn(String value) {
        super(value);
    }

    public static C_KjsymnytblhensyuusyoriKbn valueOf(String value) {
        return valueOf(C_KjsymnytblhensyuusyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KjsymnytblhensyuusyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KjsymnytblhensyuusyoriKbn.class, patternId, value);
    }
}
