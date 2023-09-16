
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手続種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TetudukisyuKbn</td><td colspan="3">手続種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="35">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;11&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMODOSISHR}</td><td>&quot;12&quot;</td><td>払戻金のお支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANMUKOU}</td><td>&quot;17&quot;</td><td>がん無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDEMUKOU}</td><td>&quot;18&quot;</td><td>申出無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;21&quot;</td><td>減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEI}</td><td>&quot;22&quot;</td><td>生年月日・性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNK_NEN}</td><td>&quot;23&quot;</td><td>目標額到達時円建年金変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKNINI}</td><td>&quot;24&quot;</td><td>円建終身変更任意請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUDKAIGOMAEBRTKYKHUKA}</td><td>&quot;31&quot;</td><td>重度介護前払特約中途付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUDKAIGOMAEBRTKYKKAIYAKU}</td><td>&quot;32&quot;</td><td>重度介護前払特約解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHEN}</td><td>&quot;33&quot;</td><td>払方変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;35&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNITEN}</td><td>&quot;36&quot;</td><td>積立金移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNITENTORIKESI}</td><td>&quot;37&quot;</td><td>積立金移転取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNK}</td><td>&quot;38&quot;</td><td>目標額到達時円建終身変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHRSHR}</td><td>&quot;39&quot;</td><td>円建変更時返戻金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKNINI_NEN}</td><td>&quot;40&quot;</td><td>円建年金変更任意請求</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTKYKHUKA}</td><td>&quot;41&quot;</td><td>年金支払特約付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTKYKHENKOU}</td><td>&quot;42&quot;</td><td>年金支払特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTKYKKAIYAKU}</td><td>&quot;43&quot;</td><td>年金支払特約解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGETSYUUSINHENKOU}</td><td>&quot;44&quot;</td><td>ターゲット特約（終身）変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGETSYUUSINKAIYAKU}</td><td>&quot;45&quot;</td><td>ターゲット特約（終身）解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGETNKHENKOU}</td><td>&quot;46&quot;</td><td>ターゲット特約（年金）変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGETNKKAIYAKU}</td><td>&quot;47&quot;</td><td>ターゲット特約（年金）解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRHUKA}</td><td>&quot;48&quot;</td><td>被保険者代理特約中途付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKHNK}</td><td>&quot;49&quot;</td><td>目標額変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHNK}</td><td>&quot;51&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHNK}</td><td>&quot;61&quot;</td><td>住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANKINHURIKOMI}</td><td>&quot;71&quot;</td><td>精算金振込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSHR}</td><td>&quot;72&quot;</td><td>配当金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DTUIBARAI}</td><td>&quot;73&quot;</td><td>配当金追払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKZHENKOU}</td><td>&quot;81&quot;</td><td>定期金支払口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOSAIHK}</td><td>&quot;91&quot;</td><td>証券再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZKTRKKYKDRHNK}</td><td>&quot;92&quot;</td><td>家族登録／契約者代理特約中途付加</td></tr>
 *  <tr><td rowspan="34">{@link #PATTERN_REPORT REPORT}<br />(お手続き完了のお知らせ用)</td><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;11&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMODOSISHR}</td><td>&quot;12&quot;</td><td>払戻金のお支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANMUKOU}</td><td>&quot;17&quot;</td><td>一部のがん関連特約無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDEMUKOU}</td><td>&quot;18&quot;</td><td>３大疾病関連特約の無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;21&quot;</td><td>減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEI}</td><td>&quot;22&quot;</td><td>生年月日・性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUDKAIGOMAEBRTKYKHUKA}</td><td>&quot;31&quot;</td><td>重度介護前払特約中途付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUDKAIGOMAEBRTKYKKAIYAKU}</td><td>&quot;32&quot;</td><td>重度介護前払特約解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHEN}</td><td>&quot;33&quot;</td><td>保険料お支払方法変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;35&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNITEN}</td><td>&quot;36&quot;</td><td>積立金移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TMTTKNITENTORIKESI}</td><td>&quot;37&quot;</td><td>積立金移転取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNK}</td><td>&quot;38&quot;</td><td>目標額到達による円建終身保険への変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKTTTYENDTHNK_NEN}</td><td>&quot;23&quot;</td><td>目標額到達による円建年金保険への変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHRSHR}</td><td>&quot;39&quot;</td><td>円建変更時返戻金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKNINI}</td><td>&quot;24&quot;</td><td>円建終身保険への変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKNINI_NEN}</td><td>&quot;40&quot;</td><td>円建年金保険への変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTKYKHUKA}</td><td>&quot;41&quot;</td><td>年金支払特約付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTKYKHENKOU}</td><td>&quot;42&quot;</td><td>年金支払特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKTKYKKAIYAKU}</td><td>&quot;43&quot;</td><td>年金支払特約解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGETSYUUSINHENKOU}</td><td>&quot;44&quot;</td><td>目標値到達時円貨建終身保険移行特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGETSYUUSINKAIYAKU}</td><td>&quot;45&quot;</td><td>目標値到達時円貨建終身保険移行特約解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGETNKHENKOU}</td><td>&quot;46&quot;</td><td>目標値到達時円貨建年金保険移行特約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TARGETNKKAIYAKU}</td><td>&quot;47&quot;</td><td>目標値到達時円貨建年金保険移行特約解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRHUKA}</td><td>&quot;48&quot;</td><td>被保険者代理特約中途付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKHNK}</td><td>&quot;49&quot;</td><td>目標額変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHNK}</td><td>&quot;51&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHNK}</td><td>&quot;61&quot;</td><td>住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANKINHURIKOMI}</td><td>&quot;71&quot;</td><td>精算金振込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSHR}</td><td>&quot;72&quot;</td><td>配当金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DTUIBARAI}</td><td>&quot;73&quot;</td><td>配当金追払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKZHENKOU}</td><td>&quot;81&quot;</td><td>定期金支払口座変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOSAIHK}</td><td>&quot;91&quot;</td><td>保険証券再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KZKTRKKYKDRHNK}</td><td>&quot;92&quot;</td><td>家族登録／契約者代理特約中途付加</td></tr>
 * </table>
 */
public class C_TetudukisyuKbn extends Classification<C_TetudukisyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TetudukisyuKbn BLNK = new C_TetudukisyuKbn("0");

    public static final C_TetudukisyuKbn KAIYAKU = new C_TetudukisyuKbn("11");

    public static final C_TetudukisyuKbn HARAIMODOSISHR = new C_TetudukisyuKbn("12");

    public static final C_TetudukisyuKbn GANMUKOU = new C_TetudukisyuKbn("17");

    public static final C_TetudukisyuKbn MOUSIDEMUKOU = new C_TetudukisyuKbn("18");

    public static final C_TetudukisyuKbn GENGAKU = new C_TetudukisyuKbn("21");

    public static final C_TetudukisyuKbn SEINENGAPPISEI = new C_TetudukisyuKbn("22");

    public static final C_TetudukisyuKbn MKHGKTTTYENDTHNK_NEN = new C_TetudukisyuKbn("23");

    public static final C_TetudukisyuKbn YENDTHNKNINI = new C_TetudukisyuKbn("24");

    public static final C_TetudukisyuKbn JYUDKAIGOMAEBRTKYKHUKA = new C_TetudukisyuKbn("31");

    public static final C_TetudukisyuKbn JYUDKAIGOMAEBRTKYKKAIYAKU = new C_TetudukisyuKbn("32");

    public static final C_TetudukisyuKbn HRIHEN = new C_TetudukisyuKbn("33");

    public static final C_TetudukisyuKbn HUKKATU = new C_TetudukisyuKbn("35");

    public static final C_TetudukisyuKbn TMTTKNITEN = new C_TetudukisyuKbn("36");

    public static final C_TetudukisyuKbn TMTTKNITENTORIKESI = new C_TetudukisyuKbn("37");

    public static final C_TetudukisyuKbn MKHGKTTTYENDTHNK = new C_TetudukisyuKbn("38");

    public static final C_TetudukisyuKbn YENDTHNKHRSHR = new C_TetudukisyuKbn("39");

    public static final C_TetudukisyuKbn YENDTHNKNINI_NEN = new C_TetudukisyuKbn("40");

    public static final C_TetudukisyuKbn NKTKYKHUKA = new C_TetudukisyuKbn("41");

    public static final C_TetudukisyuKbn NKTKYKHENKOU = new C_TetudukisyuKbn("42");

    public static final C_TetudukisyuKbn NKTKYKKAIYAKU = new C_TetudukisyuKbn("43");

    public static final C_TetudukisyuKbn TARGETSYUUSINHENKOU = new C_TetudukisyuKbn("44");

    public static final C_TetudukisyuKbn TARGETSYUUSINKAIYAKU = new C_TetudukisyuKbn("45");

    public static final C_TetudukisyuKbn TARGETNKHENKOU = new C_TetudukisyuKbn("46");

    public static final C_TetudukisyuKbn TARGETNKKAIYAKU = new C_TetudukisyuKbn("47");

    public static final C_TetudukisyuKbn STDRHUKA = new C_TetudukisyuKbn("48");

    public static final C_TetudukisyuKbn MKHGKHNK = new C_TetudukisyuKbn("49");

    public static final C_TetudukisyuKbn MEIGIHNK = new C_TetudukisyuKbn("51");

    public static final C_TetudukisyuKbn ADRHNK = new C_TetudukisyuKbn("61");

    public static final C_TetudukisyuKbn SEISANKINHURIKOMI = new C_TetudukisyuKbn("71");

    public static final C_TetudukisyuKbn DSHR = new C_TetudukisyuKbn("72");

    public static final C_TetudukisyuKbn DTUIBARAI = new C_TetudukisyuKbn("73");

    public static final C_TetudukisyuKbn SHRKZHENKOU = new C_TetudukisyuKbn("81");

    public static final C_TetudukisyuKbn SYOSAIHK = new C_TetudukisyuKbn("91");

    public static final C_TetudukisyuKbn KZKTRKKYKDRHNK = new C_TetudukisyuKbn("92");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_REPORT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, HARAIMODOSISHR, "HARAIMODOSISHR", false);
        addPattern(PATTERN_DEFAULT, GANMUKOU, "GANMUKOU", false);
        addPattern(PATTERN_DEFAULT, MOUSIDEMUKOU, "MOUSIDEMUKOU", false);
        addPattern(PATTERN_DEFAULT, GENGAKU, "GENGAKU", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEI, "SEINENGAPPISEI", false);
        addPattern(PATTERN_DEFAULT, MKHGKTTTYENDTHNK_NEN, "MKHGKTTTYENDTHNK_NEN", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKNINI, "YENDTHNKNINI", false);
        addPattern(PATTERN_DEFAULT, JYUDKAIGOMAEBRTKYKHUKA, "JYUDKAIGOMAEBRTKYKHUKA", false);
        addPattern(PATTERN_DEFAULT, JYUDKAIGOMAEBRTKYKKAIYAKU, "JYUDKAIGOMAEBRTKYKKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, HRIHEN, "HRIHEN", false);
        addPattern(PATTERN_DEFAULT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_DEFAULT, TMTTKNITEN, "TMTTKNITEN", false);
        addPattern(PATTERN_DEFAULT, TMTTKNITENTORIKESI, "TMTTKNITENTORIKESI", false);
        addPattern(PATTERN_DEFAULT, MKHGKTTTYENDTHNK, "MKHGKTTTYENDTHNK", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKHRSHR, "YENDTHNKHRSHR", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKNINI_NEN, "YENDTHNKNINI_NEN", false);
        addPattern(PATTERN_DEFAULT, NKTKYKHUKA, "NKTKYKHUKA", false);
        addPattern(PATTERN_DEFAULT, NKTKYKHENKOU, "NKTKYKHENKOU", false);
        addPattern(PATTERN_DEFAULT, NKTKYKKAIYAKU, "NKTKYKKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, TARGETSYUUSINHENKOU, "TARGETSYUUSINHENKOU", false);
        addPattern(PATTERN_DEFAULT, TARGETSYUUSINKAIYAKU, "TARGETSYUUSINKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, TARGETNKHENKOU, "TARGETNKHENKOU", false);
        addPattern(PATTERN_DEFAULT, TARGETNKKAIYAKU, "TARGETNKKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, STDRHUKA, "STDRHUKA", false);
        addPattern(PATTERN_DEFAULT, MKHGKHNK, "MKHGKHNK", false);
        addPattern(PATTERN_DEFAULT, MEIGIHNK, "MEIGIHNK", false);
        addPattern(PATTERN_DEFAULT, ADRHNK, "ADRHNK", false);
        addPattern(PATTERN_DEFAULT, SEISANKINHURIKOMI, "SEISANKINHURIKOMI", false);
        addPattern(PATTERN_DEFAULT, DSHR, "DSHR", false);
        addPattern(PATTERN_DEFAULT, DTUIBARAI, "DTUIBARAI", false);
        addPattern(PATTERN_DEFAULT, SHRKZHENKOU, "SHRKZHENKOU", false);
        addPattern(PATTERN_DEFAULT, SYOSAIHK, "SYOSAIHK", false);
        addPattern(PATTERN_DEFAULT, KZKTRKKYKDRHNK, "KZKTRKKYKDRHNK", false);


        addPattern(PATTERN_REPORT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_REPORT, HARAIMODOSISHR, "HARAIMODOSISHR", false);
        addPattern(PATTERN_REPORT, GANMUKOU, "GANMUKOU", false);
        addPattern(PATTERN_REPORT, MOUSIDEMUKOU, "MOUSIDEMUKOU", false);
        addPattern(PATTERN_REPORT, GENGAKU, "GENGAKU", false);
        addPattern(PATTERN_REPORT, SEINENGAPPISEI, "SEINENGAPPISEI", false);
        addPattern(PATTERN_REPORT, JYUDKAIGOMAEBRTKYKHUKA, "JYUDKAIGOMAEBRTKYKHUKA", false);
        addPattern(PATTERN_REPORT, JYUDKAIGOMAEBRTKYKKAIYAKU, "JYUDKAIGOMAEBRTKYKKAIYAKU", false);
        addPattern(PATTERN_REPORT, HRIHEN, "HRIHEN", false);
        addPattern(PATTERN_REPORT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_REPORT, TMTTKNITEN, "TMTTKNITEN", false);
        addPattern(PATTERN_REPORT, TMTTKNITENTORIKESI, "TMTTKNITENTORIKESI", false);
        addPattern(PATTERN_REPORT, MKHGKTTTYENDTHNK, "MKHGKTTTYENDTHNK", false);
        addPattern(PATTERN_REPORT, MKHGKTTTYENDTHNK_NEN, "MKHGKTTTYENDTHNK_NEN", false);
        addPattern(PATTERN_REPORT, YENDTHNKHRSHR, "YENDTHNKHRSHR", false);
        addPattern(PATTERN_REPORT, YENDTHNKNINI, "YENDTHNKNINI", false);
        addPattern(PATTERN_REPORT, YENDTHNKNINI_NEN, "YENDTHNKNINI_NEN", false);
        addPattern(PATTERN_REPORT, NKTKYKHUKA, "NKTKYKHUKA", false);
        addPattern(PATTERN_REPORT, NKTKYKHENKOU, "NKTKYKHENKOU", false);
        addPattern(PATTERN_REPORT, NKTKYKKAIYAKU, "NKTKYKKAIYAKU", false);
        addPattern(PATTERN_REPORT, TARGETSYUUSINHENKOU, "TARGETSYUUSINHENKOU", false);
        addPattern(PATTERN_REPORT, TARGETSYUUSINKAIYAKU, "TARGETSYUUSINKAIYAKU", false);
        addPattern(PATTERN_REPORT, TARGETNKHENKOU, "TARGETNKHENKOU", false);
        addPattern(PATTERN_REPORT, TARGETNKKAIYAKU, "TARGETNKKAIYAKU", false);
        addPattern(PATTERN_REPORT, STDRHUKA, "STDRHUKA", false);
        addPattern(PATTERN_REPORT, MKHGKHNK, "MKHGKHNK", false);
        addPattern(PATTERN_REPORT, MEIGIHNK, "MEIGIHNK", false);
        addPattern(PATTERN_REPORT, ADRHNK, "ADRHNK", false);
        addPattern(PATTERN_REPORT, SEISANKINHURIKOMI, "SEISANKINHURIKOMI", false);
        addPattern(PATTERN_REPORT, DSHR, "DSHR", false);
        addPattern(PATTERN_REPORT, DTUIBARAI, "DTUIBARAI", false);
        addPattern(PATTERN_REPORT, SHRKZHENKOU, "SHRKZHENKOU", false);
        addPattern(PATTERN_REPORT, SYOSAIHK, "SYOSAIHK", false);
        addPattern(PATTERN_REPORT, KZKTRKKYKDRHNK, "KZKTRKKYKDRHNK", false);


        lock(C_TetudukisyuKbn.class);
    }

    private C_TetudukisyuKbn(String value) {
        super(value);
    }

    public static C_TetudukisyuKbn valueOf(String value) {
        return valueOf(C_TetudukisyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TetudukisyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TetudukisyuKbn.class, patternId, value);
    }
}
