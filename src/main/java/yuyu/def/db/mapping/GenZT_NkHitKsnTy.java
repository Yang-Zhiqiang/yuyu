package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_NkHitKsnTy;
import yuyu.def.db.id.PKZT_NkHitKsnTy;
import yuyu.def.db.meta.GenQZT_NkHitKsnTy;
import yuyu.def.db.meta.QZT_NkHitKsnTy;

/**
 * 年金配当所要額Ｆ決算報告用テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_NkHitKsnTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkHitKsnTy}</td><td colspan="3">年金配当所要額Ｆ決算報告用テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtynksyousyono ztynksyousyono}</td><td>（中継用）年金証書番号</td><td align="center">{@link PKZT_NkHitKsnTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusyuruicdv2 ztysyukeiyakusyuruicdv2}</td><td>（中継用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkintypekbn ztynenkintypekbn}</td><td>（中継用）年金タイプ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknshry ztynknshry}</td><td>（中継用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinitijisiharainendo ztynenkinitijisiharainendo}</td><td>（中継用）年金一時支払年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymanryoukbn ztymanryoukbn}</td><td>（中継用）満了区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakunendo ztykeiyakunendo}</td><td>（中継用）契約年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkaisinendo ztynenkinkaisinendo}</td><td>（中継用）年金開始年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonkbn ztyseizonkbn}</td><td>（中継用）生存区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritun5 ztyyoteiriritun5}</td><td>（中継用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZty5nngt3nngtoutubkbn zty5nngt3nngtoutubkbn}</td><td>（中継用）５年ごと３年ごと応当日区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubikbn ztykeiyakuoutoubikbn}</td><td>（中継用）契約応当日区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7 ztyyobiv7}</td><td>（中継用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv15 ztyyobiv15}</td><td>（中継用）予備項目Ｖ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygyousekihyoujisibous ztygyousekihyoujisibous}</td><td>（中継用）業績表示死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykhnnkgk ztykhnnkgk}</td><td>（中継用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytounendmtwrhrgkruikeigk ztytounendmtwrhrgkruikeigk}</td><td>（中継用）当年度末割振額累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtywarihurigakurisoku1 ztywarihurigakurisoku1}</td><td>（中継用）割振額利息１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtywarihurigakurisoku2 ztywarihurigakurisoku2}</td><td>（中継用）割振額利息２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyokunendosyoyougakuyou ztyyokunendosyoyougakuyou}</td><td>（中継用）翌年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyokuyokunendosyoyougkyou ztyyokuyokunendosyoyougkyou}</td><td>（中継用）翌々年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyuukoutyuusyoyougakuyou ztyyuukoutyuusyoyougakuyou}</td><td>（中継用）有効中所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyoumetujisyoyougakuyou1 ztysyoumetujisyoyougakuyou1}</td><td>（中継用）消滅時所要額用１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyoumetujisyoyougakuyou2 ztysyoumetujisyoyougakuyou2}</td><td>（中継用）消滅時所要額用２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrisadtaisyouv ztyrisadtaisyouv}</td><td>（中継用）利差Ｄ対象Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynknengk ztynknengk}</td><td>（中継用）年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakunenkinnengaku ztysyukeiyakunenkinnengaku}</td><td>（中継用）主契約年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaimasinenkinnengaku ztykaimasinenkinnengaku}</td><td>（中継用）買増年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv38 ztyyobiv38}</td><td>（中継用）予備項目Ｖ３８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeisankijyunymd ztykeisankijyunymd}</td><td>（中継用）計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoujigyounendo ztytoujigyounendo}</td><td>（中継用）当事業年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyokujigyounendo ztyyokujigyounendo}</td><td>（中継用）翌事業年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyokuyokujigyounendo ztyyokuyokujigyounendo}</td><td>（中継用）翌々事業年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytounendseisikiwariatehyj ztytounendseisikiwariatehyj}</td><td>（中継用）当年度正式割当表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyknndseisikiwariatehyj ztyyknndseisikiwariatehyj}</td><td>（中継用）翌年度正式割当表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyznnndseisikiwratehyj ztyznnndseisikiwratehyj}</td><td>（中継用）前年度正式割当表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytounendodhaneizumihyouji ztytounendodhaneizumihyouji}</td><td>（中継用）当年度Ｄ反映済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytounendooutoubijitend ztytounendooutoubijitend}</td><td>（中継用）当年度応当日時点Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytunndoutubikutunndmtrrt ztytunndoutubikutunndmtrrt}</td><td>（中継用）当年度応当日以降当年度末利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtytunndmtikuyknndoutubrrt ztytunndmtikuyknndoutubrrt}</td><td>（中継用）当年度末以降翌年度応当日利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyyknndoutubikouyknndmtrrt ztyyknndoutubikouyknndmtrrt}</td><td>（中継用）翌年度応当日以降翌年度末利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyznnndoutubikuktyumtrrt ztyznnndoutubikuktyumtrrt}</td><td>（中継用）前年度応当日以降期中末利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyktyumtikutunndoutubrrt ztyktyumtikutunndoutubrrt}</td><td>（中継用）期中末以降当年度応当日利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtytunndoutubikuktyumtrrt ztytunndoutubikuktyumtrrt}</td><td>（中継用）当年度応当日以降期中末利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyktyumtikutunndmtrrt ztyktyumtikutunndmtrrt}</td><td>（中継用）期中末以降当年度末利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x2 ztyyobiv8x2}</td><td>（中継用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv16 ztyyobiv16}</td><td>（中継用）予備項目Ｖ１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkHitKsnTy
 * @see     PKZT_NkHitKsnTy
 * @see     QZT_NkHitKsnTy
 * @see     GenQZT_NkHitKsnTy
 */
@MappedSuperclass
@Table(name=GenZT_NkHitKsnTy.TABLE_NAME)
@IdClass(value=PKZT_NkHitKsnTy.class)
public abstract class GenZT_NkHitKsnTy extends AbstractExDBEntity<ZT_NkHitKsnTy, PKZT_NkHitKsnTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NkHitKsnTy";
    public static final String ZTYNKSYOUSYONO           = "ztynksyousyono";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYSYUKEIYAKUSYURUICDV2  = "ztysyukeiyakusyuruicdv2";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYNENKINTYPEKBN         = "ztynenkintypekbn";
    public static final String ZTYNKNSHRY               = "ztynknshry";
    public static final String ZTYNENKINITIJISIHARAINENDO = "ztynenkinitijisiharainendo";
    public static final String ZTYMANRYOUKBN            = "ztymanryoukbn";
    public static final String ZTYKEIYAKUNENDO          = "ztykeiyakunendo";
    public static final String ZTYNENKINKAISINENDO      = "ztynenkinkaisinendo";
    public static final String ZTYSEIZONKBN             = "ztyseizonkbn";
    public static final String ZTYYOTEIRIRITUN5         = "ztyyoteiriritun5";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTY5NNGT3NNGTOUTUBKBN    = "zty5nngt3nngtoutubkbn";
    public static final String ZTYKEIYAKUOUTOUBIKBN     = "ztykeiyakuoutoubikbn";
    public static final String ZTYYOBIV7                = "ztyyobiv7";
    public static final String ZTYYOBIV15               = "ztyyobiv15";
    public static final String ZTYGYOUSEKIHYOUJISIBOUS  = "ztygyousekihyoujisibous";
    public static final String ZTYKHNNKGK               = "ztykhnnkgk";
    public static final String ZTYTOUNENDMTWRHRGKRUIKEIGK = "ztytounendmtwrhrgkruikeigk";
    public static final String ZTYWARIHURIGAKURISOKU1   = "ztywarihurigakurisoku1";
    public static final String ZTYWARIHURIGAKURISOKU2   = "ztywarihurigakurisoku2";
    public static final String ZTYYOKUNENDOSYOYOUGAKUYOU = "ztyyokunendosyoyougakuyou";
    public static final String ZTYYOKUYOKUNENDOSYOYOUGKYOU = "ztyyokuyokunendosyoyougkyou";
    public static final String ZTYYUUKOUTYUUSYOYOUGAKUYOU = "ztyyuukoutyuusyoyougakuyou";
    public static final String ZTYSYOUMETUJISYOYOUGAKUYOU1 = "ztysyoumetujisyoyougakuyou1";
    public static final String ZTYSYOUMETUJISYOYOUGAKUYOU2 = "ztysyoumetujisyoyougakuyou2";
    public static final String ZTYRISADTAISYOUV         = "ztyrisadtaisyouv";
    public static final String ZTYNKNENGK               = "ztynknengk";
    public static final String ZTYSYUKEIYAKUNENKINNENGAKU = "ztysyukeiyakunenkinnengaku";
    public static final String ZTYKAIMASINENKINNENGAKU  = "ztykaimasinenkinnengaku";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYYOBIV38               = "ztyyobiv38";
    public static final String ZTYKEISANKIJYUNYMD       = "ztykeisankijyunymd";
    public static final String ZTYTOUJIGYOUNENDO        = "ztytoujigyounendo";
    public static final String ZTYYOKUJIGYOUNENDO       = "ztyyokujigyounendo";
    public static final String ZTYYOKUYOKUJIGYOUNENDO   = "ztyyokuyokujigyounendo";
    public static final String ZTYTOUNENDSEISIKIWARIATEHYJ = "ztytounendseisikiwariatehyj";
    public static final String ZTYYKNNDSEISIKIWARIATEHYJ = "ztyyknndseisikiwariatehyj";
    public static final String ZTYZNNNDSEISIKIWRATEHYJ  = "ztyznnndseisikiwratehyj";
    public static final String ZTYTOUNENDODHANEIZUMIHYOUJI = "ztytounendodhaneizumihyouji";
    public static final String ZTYTOUNENDOOUTOUBIJITEND = "ztytounendooutoubijitend";
    public static final String ZTYTUNNDOUTUBIKUTUNNDMTRRT = "ztytunndoutubikutunndmtrrt";
    public static final String ZTYTUNNDMTIKUYKNNDOUTUBRRT = "ztytunndmtikuyknndoutubrrt";
    public static final String ZTYYKNNDOUTUBIKOUYKNNDMTRRT = "ztyyknndoutubikouyknndmtrrt";
    public static final String ZTYZNNNDOUTUBIKUKTYUMTRRT = "ztyznnndoutubikuktyumtrrt";
    public static final String ZTYKTYUMTIKUTUNNDOUTUBRRT = "ztyktyumtikutunndoutubrrt";
    public static final String ZTYTUNNDOUTUBIKUKTYUMTRRT = "ztytunndoutubikuktyumtrrt";
    public static final String ZTYKTYUMTIKUTUNNDMTRRT   = "ztyktyumtikutunndmtrrt";
    public static final String ZTYYOBIV4                = "ztyyobiv4";
    public static final String ZTYYOBIV8X2              = "ztyyobiv8x2";
    public static final String ZTYYOBIV16               = "ztyyobiv16";

    private final PKZT_NkHitKsnTy primaryKey;

    public GenZT_NkHitKsnTy() {
        primaryKey = new PKZT_NkHitKsnTy();
    }

    public GenZT_NkHitKsnTy(String pZtynksyousyono) {
        primaryKey = new PKZT_NkHitKsnTy(pZtynksyousyono);
    }

    @Transient
    @Override
    public PKZT_NkHitKsnTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NkHitKsnTy> getMetaClass() {
        return QZT_NkHitKsnTy.class;
    }

    @Id
    @Column(name=GenZT_NkHitKsnTy.ZTYNKSYOUSYONO)
    public String getZtynksyousyono() {
        return getPrimaryKey().getZtynksyousyono();
    }

    public void setZtynksyousyono(String pZtynksyousyono) {
        getPrimaryKey().setZtynksyousyono(pZtynksyousyono);
    }

    private String ztykeijyouym;

    @Column(name=GenZT_NkHitKsnTy.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    private String ztysyukeiyakusyuruicdv2;

    @Column(name=GenZT_NkHitKsnTy.ZTYSYUKEIYAKUSYURUICDV2)
    public String getZtysyukeiyakusyuruicdv2() {
        return ztysyukeiyakusyuruicdv2;
    }

    public void setZtysyukeiyakusyuruicdv2(String pZtysyukeiyakusyuruicdv2) {
        ztysyukeiyakusyuruicdv2 = pZtysyukeiyakusyuruicdv2;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenZT_NkHitKsnTy.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_NkHitKsnTy.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztynenkintypekbn;

    @Column(name=GenZT_NkHitKsnTy.ZTYNENKINTYPEKBN)
    public String getZtynenkintypekbn() {
        return ztynenkintypekbn;
    }

    public void setZtynenkintypekbn(String pZtynenkintypekbn) {
        ztynenkintypekbn = pZtynenkintypekbn;
    }

    private String ztynknshry;

    @Column(name=GenZT_NkHitKsnTy.ZTYNKNSHRY)
    public String getZtynknshry() {
        return ztynknshry;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtynknshry(String pZtynknshry) {
        ztynknshry = pZtynknshry;
    }

    private String ztynenkinitijisiharainendo;

    @Column(name=GenZT_NkHitKsnTy.ZTYNENKINITIJISIHARAINENDO)
    public String getZtynenkinitijisiharainendo() {
        return ztynenkinitijisiharainendo;
    }

    public void setZtynenkinitijisiharainendo(String pZtynenkinitijisiharainendo) {
        ztynenkinitijisiharainendo = pZtynenkinitijisiharainendo;
    }

    private String ztymanryoukbn;

    @Column(name=GenZT_NkHitKsnTy.ZTYMANRYOUKBN)
    public String getZtymanryoukbn() {
        return ztymanryoukbn;
    }

    public void setZtymanryoukbn(String pZtymanryoukbn) {
        ztymanryoukbn = pZtymanryoukbn;
    }

    private String ztykeiyakunendo;

    @Column(name=GenZT_NkHitKsnTy.ZTYKEIYAKUNENDO)
    public String getZtykeiyakunendo() {
        return ztykeiyakunendo;
    }

    public void setZtykeiyakunendo(String pZtykeiyakunendo) {
        ztykeiyakunendo = pZtykeiyakunendo;
    }

    private String ztynenkinkaisinendo;

    @Column(name=GenZT_NkHitKsnTy.ZTYNENKINKAISINENDO)
    public String getZtynenkinkaisinendo() {
        return ztynenkinkaisinendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtynenkinkaisinendo(String pZtynenkinkaisinendo) {
        ztynenkinkaisinendo = pZtynenkinkaisinendo;
    }

    private String ztyseizonkbn;

    @Column(name=GenZT_NkHitKsnTy.ZTYSEIZONKBN)
    public String getZtyseizonkbn() {
        return ztyseizonkbn;
    }

    public void setZtyseizonkbn(String pZtyseizonkbn) {
        ztyseizonkbn = pZtyseizonkbn;
    }

    private Double ztyyoteiriritun5;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOTEIRIRITUN5)
    public Double getZtyyoteiriritun5() {
        return ztyyoteiriritun5;
    }

    public void setZtyyoteiriritun5(Double pZtyyoteiriritun5) {
        ztyyoteiriritun5 = pZtyyoteiriritun5;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_NkHitKsnTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_NkHitKsnTy.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String zty5nngt3nngtoutubkbn;

    @Column(name=GenZT_NkHitKsnTy.ZTY5NNGT3NNGTOUTUBKBN)
    public String getZty5nngt3nngtoutubkbn() {
        return zty5nngt3nngtoutubkbn;
    }

    public void setZty5nngt3nngtoutubkbn(String pZty5nngt3nngtoutubkbn) {
        zty5nngt3nngtoutubkbn = pZty5nngt3nngtoutubkbn;
    }

    private String ztykeiyakuoutoubikbn;

    @Column(name=GenZT_NkHitKsnTy.ZTYKEIYAKUOUTOUBIKBN)
    public String getZtykeiyakuoutoubikbn() {
        return ztykeiyakuoutoubikbn;
    }

    public void setZtykeiyakuoutoubikbn(String pZtykeiyakuoutoubikbn) {
        ztykeiyakuoutoubikbn = pZtykeiyakuoutoubikbn;
    }

    private String ztyyobiv7;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOBIV7)
    public String getZtyyobiv7() {
        return ztyyobiv7;
    }

    public void setZtyyobiv7(String pZtyyobiv7) {
        ztyyobiv7 = pZtyyobiv7;
    }

    private String ztyyobiv15;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOBIV15)
    public String getZtyyobiv15() {
        return ztyyobiv15;
    }

    public void setZtyyobiv15(String pZtyyobiv15) {
        ztyyobiv15 = pZtyyobiv15;
    }

    private Long ztygyousekihyoujisibous;

    @Column(name=GenZT_NkHitKsnTy.ZTYGYOUSEKIHYOUJISIBOUS)
    public Long getZtygyousekihyoujisibous() {
        return ztygyousekihyoujisibous;
    }

    public void setZtygyousekihyoujisibous(Long pZtygyousekihyoujisibous) {
        ztygyousekihyoujisibous = pZtygyousekihyoujisibous;
    }

    private Long ztykhnnkgk;

    @Column(name=GenZT_NkHitKsnTy.ZTYKHNNKGK)
    public Long getZtykhnnkgk() {
        return ztykhnnkgk;
    }

    public void setZtykhnnkgk(Long pZtykhnnkgk) {
        ztykhnnkgk = pZtykhnnkgk;
    }

    private Long ztytounendmtwrhrgkruikeigk;

    @Column(name=GenZT_NkHitKsnTy.ZTYTOUNENDMTWRHRGKRUIKEIGK)
    public Long getZtytounendmtwrhrgkruikeigk() {
        return ztytounendmtwrhrgkruikeigk;
    }

    public void setZtytounendmtwrhrgkruikeigk(Long pZtytounendmtwrhrgkruikeigk) {
        ztytounendmtwrhrgkruikeigk = pZtytounendmtwrhrgkruikeigk;
    }

    private Long ztywarihurigakurisoku1;

    @Column(name=GenZT_NkHitKsnTy.ZTYWARIHURIGAKURISOKU1)
    public Long getZtywarihurigakurisoku1() {
        return ztywarihurigakurisoku1;
    }

    public void setZtywarihurigakurisoku1(Long pZtywarihurigakurisoku1) {
        ztywarihurigakurisoku1 = pZtywarihurigakurisoku1;
    }

    private Long ztywarihurigakurisoku2;

    @Column(name=GenZT_NkHitKsnTy.ZTYWARIHURIGAKURISOKU2)
    public Long getZtywarihurigakurisoku2() {
        return ztywarihurigakurisoku2;
    }

    public void setZtywarihurigakurisoku2(Long pZtywarihurigakurisoku2) {
        ztywarihurigakurisoku2 = pZtywarihurigakurisoku2;
    }

    private Long ztyyokunendosyoyougakuyou;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOKUNENDOSYOYOUGAKUYOU)
    public Long getZtyyokunendosyoyougakuyou() {
        return ztyyokunendosyoyougakuyou;
    }

    public void setZtyyokunendosyoyougakuyou(Long pZtyyokunendosyoyougakuyou) {
        ztyyokunendosyoyougakuyou = pZtyyokunendosyoyougakuyou;
    }

    private Long ztyyokuyokunendosyoyougkyou;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOKUYOKUNENDOSYOYOUGKYOU)
    public Long getZtyyokuyokunendosyoyougkyou() {
        return ztyyokuyokunendosyoyougkyou;
    }

    public void setZtyyokuyokunendosyoyougkyou(Long pZtyyokuyokunendosyoyougkyou) {
        ztyyokuyokunendosyoyougkyou = pZtyyokuyokunendosyoyougkyou;
    }

    private Long ztyyuukoutyuusyoyougakuyou;

    @Column(name=GenZT_NkHitKsnTy.ZTYYUUKOUTYUUSYOYOUGAKUYOU)
    public Long getZtyyuukoutyuusyoyougakuyou() {
        return ztyyuukoutyuusyoyougakuyou;
    }

    public void setZtyyuukoutyuusyoyougakuyou(Long pZtyyuukoutyuusyoyougakuyou) {
        ztyyuukoutyuusyoyougakuyou = pZtyyuukoutyuusyoyougakuyou;
    }

    private Long ztysyoumetujisyoyougakuyou1;

    @Column(name=GenZT_NkHitKsnTy.ZTYSYOUMETUJISYOYOUGAKUYOU1)
    public Long getZtysyoumetujisyoyougakuyou1() {
        return ztysyoumetujisyoyougakuyou1;
    }

    public void setZtysyoumetujisyoyougakuyou1(Long pZtysyoumetujisyoyougakuyou1) {
        ztysyoumetujisyoyougakuyou1 = pZtysyoumetujisyoyougakuyou1;
    }

    private Long ztysyoumetujisyoyougakuyou2;

    @Column(name=GenZT_NkHitKsnTy.ZTYSYOUMETUJISYOYOUGAKUYOU2)
    public Long getZtysyoumetujisyoyougakuyou2() {
        return ztysyoumetujisyoyougakuyou2;
    }

    public void setZtysyoumetujisyoyougakuyou2(Long pZtysyoumetujisyoyougakuyou2) {
        ztysyoumetujisyoyougakuyou2 = pZtysyoumetujisyoyougakuyou2;
    }

    private Long ztyrisadtaisyouv;

    @Column(name=GenZT_NkHitKsnTy.ZTYRISADTAISYOUV)
    public Long getZtyrisadtaisyouv() {
        return ztyrisadtaisyouv;
    }

    public void setZtyrisadtaisyouv(Long pZtyrisadtaisyouv) {
        ztyrisadtaisyouv = pZtyrisadtaisyouv;
    }

    private Long ztynknengk;

    @Column(name=GenZT_NkHitKsnTy.ZTYNKNENGK)
    public Long getZtynknengk() {
        return ztynknengk;
    }

    public void setZtynknengk(Long pZtynknengk) {
        ztynknengk = pZtynknengk;
    }

    private Long ztysyukeiyakunenkinnengaku;

    @Column(name=GenZT_NkHitKsnTy.ZTYSYUKEIYAKUNENKINNENGAKU)
    public Long getZtysyukeiyakunenkinnengaku() {
        return ztysyukeiyakunenkinnengaku;
    }

    public void setZtysyukeiyakunenkinnengaku(Long pZtysyukeiyakunenkinnengaku) {
        ztysyukeiyakunenkinnengaku = pZtysyukeiyakunenkinnengaku;
    }

    private Long ztykaimasinenkinnengaku;

    @Column(name=GenZT_NkHitKsnTy.ZTYKAIMASINENKINNENGAKU)
    public Long getZtykaimasinenkinnengaku() {
        return ztykaimasinenkinnengaku;
    }

    public void setZtykaimasinenkinnengaku(Long pZtykaimasinenkinnengaku) {
        ztykaimasinenkinnengaku = pZtykaimasinenkinnengaku;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    private String ztyyobiv38;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOBIV38)
    public String getZtyyobiv38() {
        return ztyyobiv38;
    }

    public void setZtyyobiv38(String pZtyyobiv38) {
        ztyyobiv38 = pZtyyobiv38;
    }

    private String ztykeisankijyunymd;

    @Column(name=GenZT_NkHitKsnTy.ZTYKEISANKIJYUNYMD)
    public String getZtykeisankijyunymd() {
        return ztykeisankijyunymd;
    }

    public void setZtykeisankijyunymd(String pZtykeisankijyunymd) {
        ztykeisankijyunymd = pZtykeisankijyunymd;
    }

    private String ztytoujigyounendo;

    @Column(name=GenZT_NkHitKsnTy.ZTYTOUJIGYOUNENDO)
    public String getZtytoujigyounendo() {
        return ztytoujigyounendo;
    }

    public void setZtytoujigyounendo(String pZtytoujigyounendo) {
        ztytoujigyounendo = pZtytoujigyounendo;
    }

    private String ztyyokujigyounendo;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOKUJIGYOUNENDO)
    public String getZtyyokujigyounendo() {
        return ztyyokujigyounendo;
    }

    public void setZtyyokujigyounendo(String pZtyyokujigyounendo) {
        ztyyokujigyounendo = pZtyyokujigyounendo;
    }

    private String ztyyokuyokujigyounendo;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOKUYOKUJIGYOUNENDO)
    public String getZtyyokuyokujigyounendo() {
        return ztyyokuyokujigyounendo;
    }

    public void setZtyyokuyokujigyounendo(String pZtyyokuyokujigyounendo) {
        ztyyokuyokujigyounendo = pZtyyokuyokujigyounendo;
    }

    private String ztytounendseisikiwariatehyj;

    @Column(name=GenZT_NkHitKsnTy.ZTYTOUNENDSEISIKIWARIATEHYJ)
    public String getZtytounendseisikiwariatehyj() {
        return ztytounendseisikiwariatehyj;
    }

    public void setZtytounendseisikiwariatehyj(String pZtytounendseisikiwariatehyj) {
        ztytounendseisikiwariatehyj = pZtytounendseisikiwariatehyj;
    }

    private String ztyyknndseisikiwariatehyj;

    @Column(name=GenZT_NkHitKsnTy.ZTYYKNNDSEISIKIWARIATEHYJ)
    public String getZtyyknndseisikiwariatehyj() {
        return ztyyknndseisikiwariatehyj;
    }

    public void setZtyyknndseisikiwariatehyj(String pZtyyknndseisikiwariatehyj) {
        ztyyknndseisikiwariatehyj = pZtyyknndseisikiwariatehyj;
    }

    private String ztyznnndseisikiwratehyj;

    @Column(name=GenZT_NkHitKsnTy.ZTYZNNNDSEISIKIWRATEHYJ)
    public String getZtyznnndseisikiwratehyj() {
        return ztyznnndseisikiwratehyj;
    }

    public void setZtyznnndseisikiwratehyj(String pZtyznnndseisikiwratehyj) {
        ztyznnndseisikiwratehyj = pZtyznnndseisikiwratehyj;
    }

    private String ztytounendodhaneizumihyouji;

    @Column(name=GenZT_NkHitKsnTy.ZTYTOUNENDODHANEIZUMIHYOUJI)
    public String getZtytounendodhaneizumihyouji() {
        return ztytounendodhaneizumihyouji;
    }

    public void setZtytounendodhaneizumihyouji(String pZtytounendodhaneizumihyouji) {
        ztytounendodhaneizumihyouji = pZtytounendodhaneizumihyouji;
    }

    private Long ztytounendooutoubijitend;

    @Column(name=GenZT_NkHitKsnTy.ZTYTOUNENDOOUTOUBIJITEND)
    public Long getZtytounendooutoubijitend() {
        return ztytounendooutoubijitend;
    }

    public void setZtytounendooutoubijitend(Long pZtytounendooutoubijitend) {
        ztytounendooutoubijitend = pZtytounendooutoubijitend;
    }

    private Double ztytunndoutubikutunndmtrrt;

    @Column(name=GenZT_NkHitKsnTy.ZTYTUNNDOUTUBIKUTUNNDMTRRT)
    public Double getZtytunndoutubikutunndmtrrt() {
        return ztytunndoutubikutunndmtrrt;
    }

    public void setZtytunndoutubikutunndmtrrt(Double pZtytunndoutubikutunndmtrrt) {
        ztytunndoutubikutunndmtrrt = pZtytunndoutubikutunndmtrrt;
    }

    private Double ztytunndmtikuyknndoutubrrt;

    @Column(name=GenZT_NkHitKsnTy.ZTYTUNNDMTIKUYKNNDOUTUBRRT)
    public Double getZtytunndmtikuyknndoutubrrt() {
        return ztytunndmtikuyknndoutubrrt;
    }

    public void setZtytunndmtikuyknndoutubrrt(Double pZtytunndmtikuyknndoutubrrt) {
        ztytunndmtikuyknndoutubrrt = pZtytunndmtikuyknndoutubrrt;
    }

    private Double ztyyknndoutubikouyknndmtrrt;

    @Column(name=GenZT_NkHitKsnTy.ZTYYKNNDOUTUBIKOUYKNNDMTRRT)
    public Double getZtyyknndoutubikouyknndmtrrt() {
        return ztyyknndoutubikouyknndmtrrt;
    }

    public void setZtyyknndoutubikouyknndmtrrt(Double pZtyyknndoutubikouyknndmtrrt) {
        ztyyknndoutubikouyknndmtrrt = pZtyyknndoutubikouyknndmtrrt;
    }

    private Double ztyznnndoutubikuktyumtrrt;

    @Column(name=GenZT_NkHitKsnTy.ZTYZNNNDOUTUBIKUKTYUMTRRT)
    public Double getZtyznnndoutubikuktyumtrrt() {
        return ztyznnndoutubikuktyumtrrt;
    }

    public void setZtyznnndoutubikuktyumtrrt(Double pZtyznnndoutubikuktyumtrrt) {
        ztyznnndoutubikuktyumtrrt = pZtyznnndoutubikuktyumtrrt;
    }

    private Double ztyktyumtikutunndoutubrrt;

    @Column(name=GenZT_NkHitKsnTy.ZTYKTYUMTIKUTUNNDOUTUBRRT)
    public Double getZtyktyumtikutunndoutubrrt() {
        return ztyktyumtikutunndoutubrrt;
    }

    public void setZtyktyumtikutunndoutubrrt(Double pZtyktyumtikutunndoutubrrt) {
        ztyktyumtikutunndoutubrrt = pZtyktyumtikutunndoutubrrt;
    }

    private Double ztytunndoutubikuktyumtrrt;

    @Column(name=GenZT_NkHitKsnTy.ZTYTUNNDOUTUBIKUKTYUMTRRT)
    public Double getZtytunndoutubikuktyumtrrt() {
        return ztytunndoutubikuktyumtrrt;
    }

    public void setZtytunndoutubikuktyumtrrt(Double pZtytunndoutubikuktyumtrrt) {
        ztytunndoutubikuktyumtrrt = pZtytunndoutubikuktyumtrrt;
    }

    private Double ztyktyumtikutunndmtrrt;

    @Column(name=GenZT_NkHitKsnTy.ZTYKTYUMTIKUTUNNDMTRRT)
    public Double getZtyktyumtikutunndmtrrt() {
        return ztyktyumtikutunndmtrrt;
    }

    public void setZtyktyumtikutunndmtrrt(Double pZtyktyumtikutunndmtrrt) {
        ztyktyumtikutunndmtrrt = pZtyktyumtikutunndmtrrt;
    }

    private String ztyyobiv4;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }

    private String ztyyobiv8x2;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOBIV8X2)
    public String getZtyyobiv8x2() {
        return ztyyobiv8x2;
    }

    public void setZtyyobiv8x2(String pZtyyobiv8x2) {
        ztyyobiv8x2 = pZtyyobiv8x2;
    }

    private String ztyyobiv16;

    @Column(name=GenZT_NkHitKsnTy.ZTYYOBIV16)
    public String getZtyyobiv16() {
        return ztyyobiv16;
    }

    public void setZtyyobiv16(String pZtyyobiv16) {
        ztyyobiv16 = pZtyyobiv16;
    }
}
