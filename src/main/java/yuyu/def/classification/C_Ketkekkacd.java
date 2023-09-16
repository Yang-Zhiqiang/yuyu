
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 決定結果コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Ketkekkacd</td><td colspan="3">決定結果コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="16">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUJYOUKEN}</td><td>&quot;10&quot;</td><td>無条件承諾</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENKAITAI_SYOUDAKU}</td><td>&quot;11&quot;</td><td>限界体承諾</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYOUKENTUKI}</td><td>&quot;20&quot;</td><td>条件付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETUJYOUKEN}</td><td>&quot;30&quot;</td><td>特別条件</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKJY_JYOUKENTUKI_HEI}</td><td>&quot;40&quot;</td><td>特条・条件付併用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIAWASE}</td><td>&quot;51&quot;</td><td>見合わせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COOLINGOFF}</td><td>&quot;52&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS_TORIKESI}</td><td>&quot;53&quot;</td><td>申込取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKKNKKA}</td><td>&quot;54&quot;</td><td>有効期間経過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKAIPKOUHUNOU}</td><td>&quot;55&quot;</td><td>初回Ｐ口振不能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI_MATI}</td><td>&quot;60&quot;</td><td>不備待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKI_SIJINASI}</td><td>&quot;70&quot;</td><td>延期（指示なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKI_SUUNENGOSAISIN}</td><td>&quot;75&quot;</td><td>延期（数年後再診）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAND_KETTEI}</td><td>&quot;90&quot;</td><td>ハンド決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUSEIHAND_KETTEI}</td><td>&quot;91&quot;</td><td>強制ハンド決定</td></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUJYOUKEN}</td><td>&quot;10&quot;</td><td>無条件承諾</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENKAITAI_SYOUDAKU}</td><td>&quot;11&quot;</td><td>限界体承諾</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYOUKENTUKI}</td><td>&quot;20&quot;</td><td>条件付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETUJYOUKEN}</td><td>&quot;30&quot;</td><td>特別条件</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKJY_JYOUKENTUKI_HEI}</td><td>&quot;40&quot;</td><td>特条・条件付併用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIAWASE}</td><td>&quot;51&quot;</td><td>見合わせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COOLINGOFF}</td><td>&quot;52&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS_TORIKESI}</td><td>&quot;53&quot;</td><td>申込取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKKNKKA}</td><td>&quot;54&quot;</td><td>有効期間経過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKAIPKOUHUNOU}</td><td>&quot;55&quot;</td><td>初回Ｐ口振不能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI_MATI}</td><td>&quot;60&quot;</td><td>不備待ち</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_IKKATU IKKATU}<br />(一括)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUJYOUKEN}</td><td>&quot;10&quot;</td><td>無条件承諾</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIAWASE}</td><td>&quot;51&quot;</td><td>見合わせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COOLINGOFF}</td><td>&quot;52&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS_TORIKESI}</td><td>&quot;53&quot;</td><td>申込取消</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYOUKENTUKI}</td><td>&quot;20&quot;</td><td>条件付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETUJYOUKEN}</td><td>&quot;30&quot;</td><td>特別条件</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKJY_JYOUKENTUKI_HEI}</td><td>&quot;40&quot;</td><td>特条・条件付併用</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_IMUSATEI IMUSATEI}<br />(医務査定)</td><td align="center">&nbsp;</td><td>{@link #MUJYOUKEN}</td><td>&quot;10&quot;</td><td>無条件承諾</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENKAITAI_SYOUDAKU}</td><td>&quot;11&quot;</td><td>限界体承諾</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKI_SIJINASI}</td><td>&quot;70&quot;</td><td>延期（指示なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKI_SUUNENGOSAISIN}</td><td>&quot;75&quot;</td><td>延期（数年後再診）</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_KNKSATEI KNKSATEI}<br />(環境査定)</td><td align="center">&nbsp;</td><td>{@link #MUJYOUKEN}</td><td>&quot;10&quot;</td><td>問題なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIAWASE}</td><td>&quot;51&quot;</td><td>見合わせ</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_MOSTORIKESI MOSTORIKESI}<br />(申込取消)</td><td align="center">&nbsp;</td><td>{@link #COOLINGOFF}</td><td>&quot;52&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS_TORIKESI}</td><td>&quot;53&quot;</td><td>申込取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKKNKKA}</td><td>&quot;54&quot;</td><td>有効期間経過</td></tr>
 *  <tr><td rowspan="16">{@link #PATTERN_RYAKU RYAKU}<br />(略称)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUJYOUKEN}</td><td>&quot;10&quot;</td><td>無条件承諾</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENKAITAI_SYOUDAKU}</td><td>&quot;11&quot;</td><td>限界体承諾</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYOUKENTUKI}</td><td>&quot;20&quot;</td><td>条件付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETUJYOUKEN}</td><td>&quot;30&quot;</td><td>特別条件</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKJY_JYOUKENTUKI_HEI}</td><td>&quot;40&quot;</td><td>特条・条件付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIAWASE}</td><td>&quot;51&quot;</td><td>見合わせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COOLINGOFF}</td><td>&quot;52&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS_TORIKESI}</td><td>&quot;53&quot;</td><td>申込取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUKOUKKNKKA}</td><td>&quot;54&quot;</td><td>有効期間経過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKAIPKOUHUNOU}</td><td>&quot;55&quot;</td><td>初回Ｐ口振不能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI_MATI}</td><td>&quot;60&quot;</td><td>不備待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKI_SIJINASI}</td><td>&quot;70&quot;</td><td>延期（指示なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ENKI_SUUNENGOSAISIN}</td><td>&quot;75&quot;</td><td>延期（数年後再診）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAND_KETTEI}</td><td>&quot;90&quot;</td><td>ハンド決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUSEIHAND_KETTEI}</td><td>&quot;91&quot;</td><td>強制ハンド決定</td></tr>
 * </table>
 */
public class C_Ketkekkacd extends Classification<C_Ketkekkacd> {

    private static final long serialVersionUID = 1L;


    public static final C_Ketkekkacd BLNK = new C_Ketkekkacd("0");

    public static final C_Ketkekkacd MUJYOUKEN = new C_Ketkekkacd("10");

    public static final C_Ketkekkacd GENKAITAI_SYOUDAKU = new C_Ketkekkacd("11");

    public static final C_Ketkekkacd JYOUKENTUKI = new C_Ketkekkacd("20");

    public static final C_Ketkekkacd TOKUBETUJYOUKEN = new C_Ketkekkacd("30");

    public static final C_Ketkekkacd TKJY_JYOUKENTUKI_HEI = new C_Ketkekkacd("40");

    public static final C_Ketkekkacd MIAWASE = new C_Ketkekkacd("51");

    public static final C_Ketkekkacd COOLINGOFF = new C_Ketkekkacd("52");

    public static final C_Ketkekkacd MOS_TORIKESI = new C_Ketkekkacd("53");

    public static final C_Ketkekkacd YUUKOUKKNKKA = new C_Ketkekkacd("54");

    public static final C_Ketkekkacd SYOKAIPKOUHUNOU = new C_Ketkekkacd("55");

    public static final C_Ketkekkacd HUBI_MATI = new C_Ketkekkacd("60");

    public static final C_Ketkekkacd ENKI_SIJINASI = new C_Ketkekkacd("70");

    public static final C_Ketkekkacd ENKI_SUUNENGOSAISIN = new C_Ketkekkacd("75");

    public static final C_Ketkekkacd HAND_KETTEI = new C_Ketkekkacd("90");

    public static final C_Ketkekkacd KYOUSEIHAND_KETTEI = new C_Ketkekkacd("91");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_IKKATU = "3";

    public static final String PATTERN_SYOUKAI = "4";

    public static final String PATTERN_IMUSATEI = "5";

    public static final String PATTERN_KNKSATEI = "6";

    public static final String PATTERN_MOSTORIKESI = "7";

    public static final String PATTERN_RYAKU = "8";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MUJYOUKEN, "MUJYOUKEN", false);
        addPattern(PATTERN_DEFAULT, GENKAITAI_SYOUDAKU, "GENKAITAI_SYOUDAKU", false);
        addPattern(PATTERN_DEFAULT, JYOUKENTUKI, "JYOUKENTUKI", false);
        addPattern(PATTERN_DEFAULT, TOKUBETUJYOUKEN, "TOKUBETUJYOUKEN", false);
        addPattern(PATTERN_DEFAULT, TKJY_JYOUKENTUKI_HEI, "TKJY_JYOUKENTUKI_HEI", false);
        addPattern(PATTERN_DEFAULT, MIAWASE, "MIAWASE", false);
        addPattern(PATTERN_DEFAULT, COOLINGOFF, "COOLINGOFF", false);
        addPattern(PATTERN_DEFAULT, MOS_TORIKESI, "MOS_TORIKESI", false);
        addPattern(PATTERN_DEFAULT, YUUKOUKKNKKA, "YUUKOUKKNKKA", false);
        addPattern(PATTERN_DEFAULT, SYOKAIPKOUHUNOU, "SYOKAIPKOUHUNOU", false);
        addPattern(PATTERN_DEFAULT, HUBI_MATI, "HUBI_MATI", false);
        addPattern(PATTERN_DEFAULT, ENKI_SIJINASI, "ENKI_SIJINASI", false);
        addPattern(PATTERN_DEFAULT, ENKI_SUUNENGOSAISIN, "ENKI_SUUNENGOSAISIN", false);
        addPattern(PATTERN_DEFAULT, HAND_KETTEI, "HAND_KETTEI", false);
        addPattern(PATTERN_DEFAULT, KYOUSEIHAND_KETTEI, "KYOUSEIHAND_KETTEI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, MUJYOUKEN, "MUJYOUKEN", false);
        addPattern(PATTERN_SELECT, GENKAITAI_SYOUDAKU, "GENKAITAI_SYOUDAKU", false);
        addPattern(PATTERN_SELECT, JYOUKENTUKI, "JYOUKENTUKI", false);
        addPattern(PATTERN_SELECT, TOKUBETUJYOUKEN, "TOKUBETUJYOUKEN", false);
        addPattern(PATTERN_SELECT, TKJY_JYOUKENTUKI_HEI, "TKJY_JYOUKENTUKI_HEI", false);
        addPattern(PATTERN_SELECT, MIAWASE, "MIAWASE", false);
        addPattern(PATTERN_SELECT, COOLINGOFF, "COOLINGOFF", false);
        addPattern(PATTERN_SELECT, MOS_TORIKESI, "MOS_TORIKESI", false);
        addPattern(PATTERN_SELECT, YUUKOUKKNKKA, "YUUKOUKKNKKA", false);
        addPattern(PATTERN_SELECT, SYOKAIPKOUHUNOU, "SYOKAIPKOUHUNOU", false);
        addPattern(PATTERN_SELECT, HUBI_MATI, "HUBI_MATI", false);


        addPattern(PATTERN_IKKATU, BLNK, "BLNK", true);
        addPattern(PATTERN_IKKATU, MUJYOUKEN, "MUJYOUKEN", false);
        addPattern(PATTERN_IKKATU, MIAWASE, "MIAWASE", false);
        addPattern(PATTERN_IKKATU, COOLINGOFF, "COOLINGOFF", false);
        addPattern(PATTERN_IKKATU, MOS_TORIKESI, "MOS_TORIKESI", false);


        addPattern(PATTERN_SYOUKAI, BLNK, "BLNK", true);
        addPattern(PATTERN_SYOUKAI, JYOUKENTUKI, "JYOUKENTUKI", false);
        addPattern(PATTERN_SYOUKAI, TOKUBETUJYOUKEN, "TOKUBETUJYOUKEN", false);
        addPattern(PATTERN_SYOUKAI, TKJY_JYOUKENTUKI_HEI, "TKJY_JYOUKENTUKI_HEI", false);


        addPattern(PATTERN_IMUSATEI, MUJYOUKEN, "MUJYOUKEN", false);
        addPattern(PATTERN_IMUSATEI, GENKAITAI_SYOUDAKU, "GENKAITAI_SYOUDAKU", false);
        addPattern(PATTERN_IMUSATEI, ENKI_SIJINASI, "ENKI_SIJINASI", false);
        addPattern(PATTERN_IMUSATEI, ENKI_SUUNENGOSAISIN, "ENKI_SUUNENGOSAISIN", false);


        addPattern(PATTERN_KNKSATEI, MUJYOUKEN, "MUJYOUKEN", false);
        addPattern(PATTERN_KNKSATEI, MIAWASE, "MIAWASE", false);


        addPattern(PATTERN_MOSTORIKESI, COOLINGOFF, "COOLINGOFF", false);
        addPattern(PATTERN_MOSTORIKESI, MOS_TORIKESI, "MOS_TORIKESI", false);
        addPattern(PATTERN_MOSTORIKESI, YUUKOUKKNKKA, "YUUKOUKKNKKA", false);


        addPattern(PATTERN_RYAKU, BLNK, "BLNK", false);
        addPattern(PATTERN_RYAKU, MUJYOUKEN, "MUJYOUKEN", false);
        addPattern(PATTERN_RYAKU, GENKAITAI_SYOUDAKU, "GENKAITAI_SYOUDAKU", false);
        addPattern(PATTERN_RYAKU, JYOUKENTUKI, "JYOUKENTUKI", false);
        addPattern(PATTERN_RYAKU, TOKUBETUJYOUKEN, "TOKUBETUJYOUKEN", false);
        addPattern(PATTERN_RYAKU, TKJY_JYOUKENTUKI_HEI, "TKJY_JYOUKENTUKI_HEI", false);
        addPattern(PATTERN_RYAKU, MIAWASE, "MIAWASE", false);
        addPattern(PATTERN_RYAKU, COOLINGOFF, "COOLINGOFF", false);
        addPattern(PATTERN_RYAKU, MOS_TORIKESI, "MOS_TORIKESI", false);
        addPattern(PATTERN_RYAKU, YUUKOUKKNKKA, "YUUKOUKKNKKA", false);
        addPattern(PATTERN_RYAKU, SYOKAIPKOUHUNOU, "SYOKAIPKOUHUNOU", false);
        addPattern(PATTERN_RYAKU, HUBI_MATI, "HUBI_MATI", false);
        addPattern(PATTERN_RYAKU, ENKI_SIJINASI, "ENKI_SIJINASI", false);
        addPattern(PATTERN_RYAKU, ENKI_SUUNENGOSAISIN, "ENKI_SUUNENGOSAISIN", false);
        addPattern(PATTERN_RYAKU, HAND_KETTEI, "HAND_KETTEI", false);
        addPattern(PATTERN_RYAKU, KYOUSEIHAND_KETTEI, "KYOUSEIHAND_KETTEI", false);


        lock(C_Ketkekkacd.class);
    }

    private C_Ketkekkacd(String value) {
        super(value);
    }

    public static C_Ketkekkacd valueOf(String value) {
        return valueOf(C_Ketkekkacd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Ketkekkacd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Ketkekkacd.class, patternId, value);
    }
}
