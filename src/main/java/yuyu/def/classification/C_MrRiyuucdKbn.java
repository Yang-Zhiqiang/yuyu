
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＲ理由コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MrRiyuucdKbn</td><td colspan="3">ＭＲ理由コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANSYA}</td><td>&quot;M30&quot;</td><td>反社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANSYAKENENJYOUHOUARI}</td><td>&quot;M40&quot;</td><td>反社懸念情報あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUAKUHANZAI}</td><td>&quot;M50&quot;</td><td>凶悪犯罪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUAKUHANZAI_IGAI}</td><td>&quot;M52&quot;</td><td>凶悪犯罪以外の犯罪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIHANZAI}</td><td>&quot;M54&quot;</td><td>手口等により比較的軽微とする軽犯罪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOHASAN}</td><td>&quot;M60&quot;</td><td>自己破産（個人・法人とも）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUSASYOUKAI}</td><td>&quot;M62&quot;</td><td>捜査関係事項照会（反社・給付金以外）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;M90&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKIN_MORARURISUKU_KAKUTEI}</td><td>&quot;M93&quot;</td><td>給付金等モラルリスク（確定）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKIN_MORARURISUKU_KENEN}</td><td>&quot;M94&quot;</td><td>給付金等モラルリスク（懸念）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUSYA_GOUIKAIYAKUKAIJYO}</td><td>&quot;M95&quot;</td><td>当社　合意解約・契約解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TASYA_GOUIKAIYAKUKAIJYO}</td><td>&quot;M96&quot;</td><td>他社　合意解約・契約解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKENSASIOSAETOU}</td><td>&quot;M99&quot;</td><td>債権差押等</td></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_KNKSATEI KNKSATEI}<br />(環境査定)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANSYA}</td><td>&quot;M30&quot;</td><td>M30 反社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANSYAKENENJYOUHOUARI}</td><td>&quot;M40&quot;</td><td>M40 反社懸念情報あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUAKUHANZAI}</td><td>&quot;M50&quot;</td><td>M50 凶悪犯罪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUAKUHANZAI_IGAI}</td><td>&quot;M52&quot;</td><td>M52 凶悪犯罪以外の犯罪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIHANZAI}</td><td>&quot;M54&quot;</td><td>M54 比較的軽微な犯罪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKIN_MORARURISUKU_KAKUTEI}</td><td>&quot;M93&quot;</td><td>M93 給付金モラルリスク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKIN_MORARURISUKU_KENEN}</td><td>&quot;M94&quot;</td><td>M94 給付金モラルリスク疑</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUSYA_GOUIKAIYAKUKAIJYO}</td><td>&quot;M95&quot;</td><td>M95 当社「合意解約・解除」</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TASYA_GOUIKAIYAKUKAIJYO}</td><td>&quot;M96&quot;</td><td>M96 他社「合意解約・解除」</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOHASAN}</td><td>&quot;M60&quot;</td><td>M60 自己破産</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUSASYOUKAI}</td><td>&quot;M62&quot;</td><td>M62 捜査関係事項照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;M90&quot;</td><td>M90 その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKENSASIOSAETOU}</td><td>&quot;M99&quot;</td><td>M99 債権差押等</td></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANSYA}</td><td>&quot;M30&quot;</td><td>M30 反社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANSYAKENENJYOUHOUARI}</td><td>&quot;M40&quot;</td><td>M40 反社懸念情報あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUAKUHANZAI}</td><td>&quot;M50&quot;</td><td>M50 凶悪犯罪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUAKUHANZAI_IGAI}</td><td>&quot;M52&quot;</td><td>M52 凶悪犯罪以外の犯罪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIHANZAI}</td><td>&quot;M54&quot;</td><td>M54 比較的軽微な犯罪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOHASAN}</td><td>&quot;M60&quot;</td><td>M60 自己破産</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUSASYOUKAI}</td><td>&quot;M62&quot;</td><td>M62 捜査関係事項照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;M90&quot;</td><td>M90 その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKIN_MORARURISUKU_KAKUTEI}</td><td>&quot;M93&quot;</td><td>M93 給付金モラルリスク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKIN_MORARURISUKU_KENEN}</td><td>&quot;M94&quot;</td><td>M94 給付金モラルリスク疑</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUSYA_GOUIKAIYAKUKAIJYO}</td><td>&quot;M95&quot;</td><td>M95 当社「合意解約・解除」</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TASYA_GOUIKAIYAKUKAIJYO}</td><td>&quot;M96&quot;</td><td>M96 他社「合意解約・解除」</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKENSASIOSAETOU}</td><td>&quot;M99&quot;</td><td>M99 債権差押等</td></tr>
 * </table>
 */
public class C_MrRiyuucdKbn extends Classification<C_MrRiyuucdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MrRiyuucdKbn BLNK = new C_MrRiyuucdKbn("0");

    public static final C_MrRiyuucdKbn HANSYA = new C_MrRiyuucdKbn("M30");

    public static final C_MrRiyuucdKbn HANSYAKENENJYOUHOUARI = new C_MrRiyuucdKbn("M40");

    public static final C_MrRiyuucdKbn KYOUAKUHANZAI = new C_MrRiyuucdKbn("M50");

    public static final C_MrRiyuucdKbn KYOUAKUHANZAI_IGAI = new C_MrRiyuucdKbn("M52");

    public static final C_MrRiyuucdKbn KEIHANZAI = new C_MrRiyuucdKbn("M54");

    public static final C_MrRiyuucdKbn JIKOHASAN = new C_MrRiyuucdKbn("M60");

    public static final C_MrRiyuucdKbn SOUSASYOUKAI = new C_MrRiyuucdKbn("M62");

    public static final C_MrRiyuucdKbn OTHER = new C_MrRiyuucdKbn("M90");

    public static final C_MrRiyuucdKbn KYUUHUKIN_MORARURISUKU_KAKUTEI = new C_MrRiyuucdKbn("M93");

    public static final C_MrRiyuucdKbn KYUUHUKIN_MORARURISUKU_KENEN = new C_MrRiyuucdKbn("M94");

    public static final C_MrRiyuucdKbn TOUSYA_GOUIKAIYAKUKAIJYO = new C_MrRiyuucdKbn("M95");

    public static final C_MrRiyuucdKbn TASYA_GOUIKAIYAKUKAIJYO = new C_MrRiyuucdKbn("M96");

    public static final C_MrRiyuucdKbn SAIKENSASIOSAETOU = new C_MrRiyuucdKbn("M99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KNKSATEI = "2";

    public static final String PATTERN_SYOUKAI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HANSYA, "HANSYA", false);
        addPattern(PATTERN_DEFAULT, HANSYAKENENJYOUHOUARI, "HANSYAKENENJYOUHOUARI", false);
        addPattern(PATTERN_DEFAULT, KYOUAKUHANZAI, "KYOUAKUHANZAI", false);
        addPattern(PATTERN_DEFAULT, KYOUAKUHANZAI_IGAI, "KYOUAKUHANZAI_IGAI", false);
        addPattern(PATTERN_DEFAULT, KEIHANZAI, "KEIHANZAI", false);
        addPattern(PATTERN_DEFAULT, JIKOHASAN, "JIKOHASAN", false);
        addPattern(PATTERN_DEFAULT, SOUSASYOUKAI, "SOUSASYOUKAI", false);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);
        addPattern(PATTERN_DEFAULT, KYUUHUKIN_MORARURISUKU_KAKUTEI, "KYUUHUKIN_MORARURISUKU_KAKUTEI", false);
        addPattern(PATTERN_DEFAULT, KYUUHUKIN_MORARURISUKU_KENEN, "KYUUHUKIN_MORARURISUKU_KENEN", false);
        addPattern(PATTERN_DEFAULT, TOUSYA_GOUIKAIYAKUKAIJYO, "TOUSYA_GOUIKAIYAKUKAIJYO", false);
        addPattern(PATTERN_DEFAULT, TASYA_GOUIKAIYAKUKAIJYO, "TASYA_GOUIKAIYAKUKAIJYO", false);
        addPattern(PATTERN_DEFAULT, SAIKENSASIOSAETOU, "SAIKENSASIOSAETOU", false);


        addPattern(PATTERN_KNKSATEI, BLNK, "BLNK", true);
        addPattern(PATTERN_KNKSATEI, HANSYA, "HANSYA", false);
        addPattern(PATTERN_KNKSATEI, HANSYAKENENJYOUHOUARI, "HANSYAKENENJYOUHOUARI", false);
        addPattern(PATTERN_KNKSATEI, KYOUAKUHANZAI, "KYOUAKUHANZAI", false);
        addPattern(PATTERN_KNKSATEI, KYOUAKUHANZAI_IGAI, "KYOUAKUHANZAI_IGAI", false);
        addPattern(PATTERN_KNKSATEI, KEIHANZAI, "KEIHANZAI", false);
        addPattern(PATTERN_KNKSATEI, KYUUHUKIN_MORARURISUKU_KAKUTEI, "KYUUHUKIN_MORARURISUKU_KAKUTEI", false);
        addPattern(PATTERN_KNKSATEI, KYUUHUKIN_MORARURISUKU_KENEN, "KYUUHUKIN_MORARURISUKU_KENEN", false);
        addPattern(PATTERN_KNKSATEI, TOUSYA_GOUIKAIYAKUKAIJYO, "TOUSYA_GOUIKAIYAKUKAIJYO", false);
        addPattern(PATTERN_KNKSATEI, TASYA_GOUIKAIYAKUKAIJYO, "TASYA_GOUIKAIYAKUKAIJYO", false);
        addPattern(PATTERN_KNKSATEI, JIKOHASAN, "JIKOHASAN", false);
        addPattern(PATTERN_KNKSATEI, SOUSASYOUKAI, "SOUSASYOUKAI", false);
        addPattern(PATTERN_KNKSATEI, OTHER, "OTHER", false);
        addPattern(PATTERN_KNKSATEI, SAIKENSASIOSAETOU, "SAIKENSASIOSAETOU", false);


        addPattern(PATTERN_SYOUKAI, BLNK, "BLNK", false);
        addPattern(PATTERN_SYOUKAI, HANSYA, "HANSYA", false);
        addPattern(PATTERN_SYOUKAI, HANSYAKENENJYOUHOUARI, "HANSYAKENENJYOUHOUARI", false);
        addPattern(PATTERN_SYOUKAI, KYOUAKUHANZAI, "KYOUAKUHANZAI", false);
        addPattern(PATTERN_SYOUKAI, KYOUAKUHANZAI_IGAI, "KYOUAKUHANZAI_IGAI", false);
        addPattern(PATTERN_SYOUKAI, KEIHANZAI, "KEIHANZAI", false);
        addPattern(PATTERN_SYOUKAI, JIKOHASAN, "JIKOHASAN", false);
        addPattern(PATTERN_SYOUKAI, SOUSASYOUKAI, "SOUSASYOUKAI", false);
        addPattern(PATTERN_SYOUKAI, OTHER, "OTHER", false);
        addPattern(PATTERN_SYOUKAI, KYUUHUKIN_MORARURISUKU_KAKUTEI, "KYUUHUKIN_MORARURISUKU_KAKUTEI", false);
        addPattern(PATTERN_SYOUKAI, KYUUHUKIN_MORARURISUKU_KENEN, "KYUUHUKIN_MORARURISUKU_KENEN", false);
        addPattern(PATTERN_SYOUKAI, TOUSYA_GOUIKAIYAKUKAIJYO, "TOUSYA_GOUIKAIYAKUKAIJYO", false);
        addPattern(PATTERN_SYOUKAI, TASYA_GOUIKAIYAKUKAIJYO, "TASYA_GOUIKAIYAKUKAIJYO", false);
        addPattern(PATTERN_SYOUKAI, SAIKENSASIOSAETOU, "SAIKENSASIOSAETOU", false);


        lock(C_MrRiyuucdKbn.class);
    }

    private C_MrRiyuucdKbn(String value) {
        super(value);
    }

    public static C_MrRiyuucdKbn valueOf(String value) {
        return valueOf(C_MrRiyuucdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MrRiyuucdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MrRiyuucdKbn.class, patternId, value);
    }
}
