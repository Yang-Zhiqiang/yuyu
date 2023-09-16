
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約内容訂正処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KykNaiyouTeiseiSyoriKbn</td><td colspan="3">契約内容訂正処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOKUHYOUGKWARIHENKOU}</td><td>&quot;01&quot;</td><td>目標額割合変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNKTRKS}</td><td>&quot;02&quot;</td><td>目標額到達時円建変更取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEISEITEKIKAKUHUKA}</td><td>&quot;03&quot;</td><td>個人年金保険料税制適格特約付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEISEITEKIKAKUSYOUMETU}</td><td>&quot;04&quot;</td><td>個人年金保険料税制適格特約消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI_TORIKESI}</td><td>&quot;05&quot;</td><td>積立金反映取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI_ITEN_TORIKESI}</td><td>&quot;06&quot;</td><td>積立金反映・移転取消</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNKTRKS}</td><td>&quot;02&quot;</td><td>目標額到達時円建変更取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNHANEI_TORIKESI}</td><td>&quot;05&quot;</td><td>積立金反映取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEISEITEKIKAKUHUKA}</td><td>&quot;03&quot;</td><td>個人年金保険料税制適格特約付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEISEITEKIKAKUSYOUMETU}</td><td>&quot;04&quot;</td><td>個人年金保険料税制適格特約消滅</td></tr>
 * </table>
 */
public class C_KykNaiyouTeiseiSyoriKbn extends Classification<C_KykNaiyouTeiseiSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KykNaiyouTeiseiSyoriKbn BLNK = new C_KykNaiyouTeiseiSyoriKbn("00");

    public static final C_KykNaiyouTeiseiSyoriKbn MOKUHYOUGKWARIHENKOU = new C_KykNaiyouTeiseiSyoriKbn("01");

    public static final C_KykNaiyouTeiseiSyoriKbn MKHGKTTTYENDTHNKTRKS = new C_KykNaiyouTeiseiSyoriKbn("02");

    public static final C_KykNaiyouTeiseiSyoriKbn ZEISEITEKIKAKUHUKA = new C_KykNaiyouTeiseiSyoriKbn("03");

    public static final C_KykNaiyouTeiseiSyoriKbn ZEISEITEKIKAKUSYOUMETU = new C_KykNaiyouTeiseiSyoriKbn("04");

    public static final C_KykNaiyouTeiseiSyoriKbn TMTTKNHANEI_TORIKESI = new C_KykNaiyouTeiseiSyoriKbn("05");

    public static final C_KykNaiyouTeiseiSyoriKbn TMTTKNHANEI_ITEN_TORIKESI = new C_KykNaiyouTeiseiSyoriKbn("06");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MOKUHYOUGKWARIHENKOU, "MOKUHYOUGKWARIHENKOU", false);
        addPattern(PATTERN_DEFAULT, MKHGKTTTYENDTHNKTRKS, "MKHGKTTTYENDTHNKTRKS", false);
        addPattern(PATTERN_DEFAULT, ZEISEITEKIKAKUHUKA, "ZEISEITEKIKAKUHUKA", false);
        addPattern(PATTERN_DEFAULT, ZEISEITEKIKAKUSYOUMETU, "ZEISEITEKIKAKUSYOUMETU", false);
        addPattern(PATTERN_DEFAULT, TMTTKNHANEI_TORIKESI, "TMTTKNHANEI_TORIKESI", false);
        addPattern(PATTERN_DEFAULT, TMTTKNHANEI_ITEN_TORIKESI, "TMTTKNHANEI_ITEN_TORIKESI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, MKHGKTTTYENDTHNKTRKS, "MKHGKTTTYENDTHNKTRKS", false);
        addPattern(PATTERN_SELECT, TMTTKNHANEI_TORIKESI, "TMTTKNHANEI_TORIKESI", false);
        addPattern(PATTERN_SELECT, ZEISEITEKIKAKUHUKA, "ZEISEITEKIKAKUHUKA", false);
        addPattern(PATTERN_SELECT, ZEISEITEKIKAKUSYOUMETU, "ZEISEITEKIKAKUSYOUMETU", false);


        lock(C_KykNaiyouTeiseiSyoriKbn.class);
    }

    private C_KykNaiyouTeiseiSyoriKbn(String value) {
        super(value);
    }

    public static C_KykNaiyouTeiseiSyoriKbn valueOf(String value) {
        return valueOf(C_KykNaiyouTeiseiSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KykNaiyouTeiseiSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KykNaiyouTeiseiSyoriKbn.class, patternId, value);
    }
}
