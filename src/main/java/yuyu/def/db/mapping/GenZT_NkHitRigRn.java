package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_NkHitRigRn;
import yuyu.def.db.id.PKZT_NkHitRigRn;
import yuyu.def.db.meta.GenQZT_NkHitRigRn;
import yuyu.def.db.meta.QZT_NkHitRigRn;

/**
 * 年金配当所要額Ｆ例月報告用テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_NkHitRigRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkHitRigRn}</td><td colspan="3">年金配当所要額Ｆ例月報告用テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnnksyousyono zrnnksyousyono}</td><td>（連携用）年金証書番号</td><td align="center">{@link PKZT_NkHitRigRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeijyouym zrnkeijyouym}</td><td>（連携用）計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakusyuruicdv2 zrnsyukeiyakusyuruicdv2}</td><td>（連携用）主契約種類コードＶ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyousegmentkbn zrnkbnkeiriyousegmentkbn}</td><td>（連携用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkbnkeiriyourgnbnskkbn zrnkbnkeiriyourgnbnskkbn}</td><td>（連携用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkintypekbn zrnnenkintypekbn}</td><td>（連携用）年金タイプ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinitijisiharainendo zrnnenkinitijisiharainendo}</td><td>（連携用）年金一時支払年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmanryoukbn zrnmanryoukbn}</td><td>（連携用）満了区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakunendo zrnkeiyakunendo}</td><td>（連携用）契約年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisinendo zrnnenkinkaisinendo}</td><td>（連携用）年金開始年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonkbn zrnseizonkbn}</td><td>（連携用）生存区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritun5 zrnyoteiriritun5}</td><td>（連携用）予定利率Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrn5nngt3nngtoutubkbn zrn5nngt3nngtoutubkbn}</td><td>（連携用）５年ごと３年ごと応当日区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubikbn zrnkeiyakuoutoubikbn}</td><td>（連携用）契約応当日区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7 zrnyobiv7}</td><td>（連携用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv15 zrnyobiv15}</td><td>（連携用）予備項目Ｖ１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngyousekihyoujisibous zrngyousekihyoujisibous}</td><td>（連携用）業績表示死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkhnnkgk zrnkhnnkgk}</td><td>（連携用）基本年金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntounendmtwrhrgkruikeigk zrntounendmtwrhrgkruikeigk}</td><td>（連携用）当年度末割振額累計額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnwarihurigakurisoku1 zrnwarihurigakurisoku1}</td><td>（連携用）割振額利息１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnwarihurigakurisoku2 zrnwarihurigakurisoku2}</td><td>（連携用）割振額利息２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyokunendosyoyougakuyou zrnyokunendosyoyougakuyou}</td><td>（連携用）翌年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyokuyokunendosyoyougkyou zrnyokuyokunendosyoyougkyou}</td><td>（連携用）翌々年度所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyuukoutyuusyoyougakuyou zrnyuukoutyuusyoyougakuyou}</td><td>（連携用）有効中所要額用</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyoumetujisyoyougakuyou1 zrnsyoumetujisyoyougakuyou1}</td><td>（連携用）消滅時所要額用１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyoumetujisyoyougakuyou2 zrnsyoumetujisyoyougakuyou2}</td><td>（連携用）消滅時所要額用２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnrisadtaisyouv zrnrisadtaisyouv}</td><td>（連携用）利差Ｄ対象Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnknengk zrnnknengk}</td><td>（連携用）年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakunenkinnengaku zrnsyukeiyakunenkinnengaku}</td><td>（連携用）主契約年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaimasinenkinnengaku zrnkaimasinenkinnengaku}</td><td>（連携用）買増年金年額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv38 zrnyobiv38}</td><td>（連携用）予備項目Ｖ３８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeisankijyunymd zrnkeisankijyunymd}</td><td>（連携用）計算基準日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoujigyounendo zrntoujigyounendo}</td><td>（連携用）当事業年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokujigyounendo zrnyokujigyounendo}</td><td>（連携用）翌事業年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokuyokujigyounendo zrnyokuyokujigyounendo}</td><td>（連携用）翌々事業年度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntounendseisikiwariatehyj zrntounendseisikiwariatehyj}</td><td>（連携用）当年度正式割当表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyknndseisikiwariatehyj zrnyknndseisikiwariatehyj}</td><td>（連携用）翌年度正式割当表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnznnndseisikiwratehyj zrnznnndseisikiwratehyj}</td><td>（連携用）前年度正式割当表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntounendodhaneizumihyouji zrntounendodhaneizumihyouji}</td><td>（連携用）当年度Ｄ反映済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntounendooutoubijitend zrntounendooutoubijitend}</td><td>（連携用）当年度応当日時点Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntunndoutubikutunndmtrrt zrntunndoutubikutunndmtrrt}</td><td>（連携用）当年度応当日以降当年度末利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrntunndmtikuyknndoutubrrt zrntunndmtikuyknndoutubrrt}</td><td>（連携用）当年度末以降翌年度応当日利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyknndoutubikouyknndmtrrt zrnyknndoutubikouyknndmtrrt}</td><td>（連携用）翌年度応当日以降翌年度末利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnznnndoutubikuktyumtrrt zrnznnndoutubikuktyumtrrt}</td><td>（連携用）前年度応当日以降期中末利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnktyumtikutunndoutubrrt zrnktyumtikutunndoutubrrt}</td><td>（連携用）期中末以降当年度応当日利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrntunndoutubikuktyumtrrt zrntunndoutubikuktyumtrrt}</td><td>（連携用）当年度応当日以降期中末利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnktyumtikutunndmtrrt zrnktyumtikutunndmtrrt}</td><td>（連携用）期中末以降当年度末利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x2 zrnyobiv8x2}</td><td>（連携用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv16 zrnyobiv16}</td><td>（連携用）予備項目Ｖ１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkHitRigRn
 * @see     PKZT_NkHitRigRn
 * @see     QZT_NkHitRigRn
 * @see     GenQZT_NkHitRigRn
 */
@MappedSuperclass
@Table(name=GenZT_NkHitRigRn.TABLE_NAME)
@IdClass(value=PKZT_NkHitRigRn.class)
public abstract class GenZT_NkHitRigRn extends AbstractExDBEntityForZDB<ZT_NkHitRigRn, PKZT_NkHitRigRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NkHitRigRn";
    public static final String ZRNNKSYOUSYONO           = "zrnnksyousyono";
    public static final String ZRNKEIJYOUYM             = "zrnkeijyouym";
    public static final String ZRNSYUKEIYAKUSYURUICDV2  = "zrnsyukeiyakusyuruicdv2";
    public static final String ZRNKBNKEIRIYOUSEGMENTKBN = "zrnkbnkeiriyousegmentkbn";
    public static final String ZRNKBNKEIRIYOURGNBNSKKBN = "zrnkbnkeiriyourgnbnskkbn";
    public static final String ZRNNENKINTYPEKBN         = "zrnnenkintypekbn";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNNENKINITIJISIHARAINENDO = "zrnnenkinitijisiharainendo";
    public static final String ZRNMANRYOUKBN            = "zrnmanryoukbn";
    public static final String ZRNKEIYAKUNENDO          = "zrnkeiyakunendo";
    public static final String ZRNNENKINKAISINENDO      = "zrnnenkinkaisinendo";
    public static final String ZRNSEIZONKBN             = "zrnseizonkbn";
    public static final String ZRNYOTEIRIRITUN5         = "zrnyoteiriritun5";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRN5NNGT3NNGTOUTUBKBN    = "zrn5nngt3nngtoutubkbn";
    public static final String ZRNKEIYAKUOUTOUBIKBN     = "zrnkeiyakuoutoubikbn";
    public static final String ZRNYOBIV7                = "zrnyobiv7";
    public static final String ZRNYOBIV15               = "zrnyobiv15";
    public static final String ZRNGYOUSEKIHYOUJISIBOUS  = "zrngyousekihyoujisibous";
    public static final String ZRNKHNNKGK               = "zrnkhnnkgk";
    public static final String ZRNTOUNENDMTWRHRGKRUIKEIGK = "zrntounendmtwrhrgkruikeigk";
    public static final String ZRNWARIHURIGAKURISOKU1   = "zrnwarihurigakurisoku1";
    public static final String ZRNWARIHURIGAKURISOKU2   = "zrnwarihurigakurisoku2";
    public static final String ZRNYOKUNENDOSYOYOUGAKUYOU = "zrnyokunendosyoyougakuyou";
    public static final String ZRNYOKUYOKUNENDOSYOYOUGKYOU = "zrnyokuyokunendosyoyougkyou";
    public static final String ZRNYUUKOUTYUUSYOYOUGAKUYOU = "zrnyuukoutyuusyoyougakuyou";
    public static final String ZRNSYOUMETUJISYOYOUGAKUYOU1 = "zrnsyoumetujisyoyougakuyou1";
    public static final String ZRNSYOUMETUJISYOYOUGAKUYOU2 = "zrnsyoumetujisyoyougakuyou2";
    public static final String ZRNRISADTAISYOUV         = "zrnrisadtaisyouv";
    public static final String ZRNNKNENGK               = "zrnnknengk";
    public static final String ZRNSYUKEIYAKUNENKINNENGAKU = "zrnsyukeiyakunenkinnengaku";
    public static final String ZRNKAIMASINENKINNENGAKU  = "zrnkaimasinenkinnengaku";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNYOBIV38               = "zrnyobiv38";
    public static final String ZRNKEISANKIJYUNYMD       = "zrnkeisankijyunymd";
    public static final String ZRNTOUJIGYOUNENDO        = "zrntoujigyounendo";
    public static final String ZRNYOKUJIGYOUNENDO       = "zrnyokujigyounendo";
    public static final String ZRNYOKUYOKUJIGYOUNENDO   = "zrnyokuyokujigyounendo";
    public static final String ZRNTOUNENDSEISIKIWARIATEHYJ = "zrntounendseisikiwariatehyj";
    public static final String ZRNYKNNDSEISIKIWARIATEHYJ = "zrnyknndseisikiwariatehyj";
    public static final String ZRNZNNNDSEISIKIWRATEHYJ  = "zrnznnndseisikiwratehyj";
    public static final String ZRNTOUNENDODHANEIZUMIHYOUJI = "zrntounendodhaneizumihyouji";
    public static final String ZRNTOUNENDOOUTOUBIJITEND = "zrntounendooutoubijitend";
    public static final String ZRNTUNNDOUTUBIKUTUNNDMTRRT = "zrntunndoutubikutunndmtrrt";
    public static final String ZRNTUNNDMTIKUYKNNDOUTUBRRT = "zrntunndmtikuyknndoutubrrt";
    public static final String ZRNYKNNDOUTUBIKOUYKNNDMTRRT = "zrnyknndoutubikouyknndmtrrt";
    public static final String ZRNZNNNDOUTUBIKUKTYUMTRRT = "zrnznnndoutubikuktyumtrrt";
    public static final String ZRNKTYUMTIKUTUNNDOUTUBRRT = "zrnktyumtikutunndoutubrrt";
    public static final String ZRNTUNNDOUTUBIKUKTYUMTRRT = "zrntunndoutubikuktyumtrrt";
    public static final String ZRNKTYUMTIKUTUNNDMTRRT   = "zrnktyumtikutunndmtrrt";
    public static final String ZRNYOBIV4                = "zrnyobiv4";
    public static final String ZRNYOBIV8X2              = "zrnyobiv8x2";
    public static final String ZRNYOBIV16               = "zrnyobiv16";

    private final PKZT_NkHitRigRn primaryKey;

    public GenZT_NkHitRigRn() {
        primaryKey = new PKZT_NkHitRigRn();
    }

    public GenZT_NkHitRigRn(String pZrnnksyousyono) {
        primaryKey = new PKZT_NkHitRigRn(pZrnnksyousyono);
    }

    @Transient
    @Override
    public PKZT_NkHitRigRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NkHitRigRn> getMetaClass() {
        return QZT_NkHitRigRn.class;
    }

    @Id
    @Column(name=GenZT_NkHitRigRn.ZRNNKSYOUSYONO)
    public String getZrnnksyousyono() {
        return getPrimaryKey().getZrnnksyousyono();
    }

    public void setZrnnksyousyono(String pZrnnksyousyono) {
        getPrimaryKey().setZrnnksyousyono(pZrnnksyousyono);
    }

    private String zrnkeijyouym;

    @Column(name=GenZT_NkHitRigRn.ZRNKEIJYOUYM)
    public String getZrnkeijyouym() {
        return zrnkeijyouym;
    }

    public void setZrnkeijyouym(String pZrnkeijyouym) {
        zrnkeijyouym = pZrnkeijyouym;
    }

    private String zrnsyukeiyakusyuruicdv2;

    @Column(name=GenZT_NkHitRigRn.ZRNSYUKEIYAKUSYURUICDV2)
    public String getZrnsyukeiyakusyuruicdv2() {
        return zrnsyukeiyakusyuruicdv2;
    }

    public void setZrnsyukeiyakusyuruicdv2(String pZrnsyukeiyakusyuruicdv2) {
        zrnsyukeiyakusyuruicdv2 = pZrnsyukeiyakusyuruicdv2;
    }

    private String zrnkbnkeiriyousegmentkbn;

    @Column(name=GenZT_NkHitRigRn.ZRNKBNKEIRIYOUSEGMENTKBN)
    public String getZrnkbnkeiriyousegmentkbn() {
        return zrnkbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyousegmentkbn(String pZrnkbnkeiriyousegmentkbn) {
        zrnkbnkeiriyousegmentkbn = pZrnkbnkeiriyousegmentkbn;
    }

    private String zrnkbnkeiriyourgnbnskkbn;

    @Column(name=GenZT_NkHitRigRn.ZRNKBNKEIRIYOURGNBNSKKBN)
    public String getZrnkbnkeiriyourgnbnskkbn() {
        return zrnkbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkbnkeiriyourgnbnskkbn(String pZrnkbnkeiriyourgnbnskkbn) {
        zrnkbnkeiriyourgnbnskkbn = pZrnkbnkeiriyourgnbnskkbn;
    }

    private String zrnnenkintypekbn;

    @Column(name=GenZT_NkHitRigRn.ZRNNENKINTYPEKBN)
    public String getZrnnenkintypekbn() {
        return zrnnenkintypekbn;
    }

    public void setZrnnenkintypekbn(String pZrnnenkintypekbn) {
        zrnnenkintypekbn = pZrnnenkintypekbn;
    }

    private String zrnnknshry;

    @Column(name=GenZT_NkHitRigRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return zrnnknshry;
    }

    public void setZrnnknshry(String pZrnnknshry) {
        zrnnknshry = pZrnnknshry;
    }

    private String zrnnenkinitijisiharainendo;

    @Column(name=GenZT_NkHitRigRn.ZRNNENKINITIJISIHARAINENDO)
    public String getZrnnenkinitijisiharainendo() {
        return zrnnenkinitijisiharainendo;
    }

    public void setZrnnenkinitijisiharainendo(String pZrnnenkinitijisiharainendo) {
        zrnnenkinitijisiharainendo = pZrnnenkinitijisiharainendo;
    }

    private String zrnmanryoukbn;

    @Column(name=GenZT_NkHitRigRn.ZRNMANRYOUKBN)
    public String getZrnmanryoukbn() {
        return zrnmanryoukbn;
    }

    public void setZrnmanryoukbn(String pZrnmanryoukbn) {
        zrnmanryoukbn = pZrnmanryoukbn;
    }

    private String zrnkeiyakunendo;

    @Column(name=GenZT_NkHitRigRn.ZRNKEIYAKUNENDO)
    public String getZrnkeiyakunendo() {
        return zrnkeiyakunendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkeiyakunendo(String pZrnkeiyakunendo) {
        zrnkeiyakunendo = pZrnkeiyakunendo;
    }

    private String zrnnenkinkaisinendo;

    @Column(name=GenZT_NkHitRigRn.ZRNNENKINKAISINENDO)
    public String getZrnnenkinkaisinendo() {
        return zrnnenkinkaisinendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnnenkinkaisinendo(String pZrnnenkinkaisinendo) {
        zrnnenkinkaisinendo = pZrnnenkinkaisinendo;
    }

    private String zrnseizonkbn;

    @Column(name=GenZT_NkHitRigRn.ZRNSEIZONKBN)
    public String getZrnseizonkbn() {
        return zrnseizonkbn;
    }

    public void setZrnseizonkbn(String pZrnseizonkbn) {
        zrnseizonkbn = pZrnseizonkbn;
    }

    private Double zrnyoteiriritun5;

    @Column(name=GenZT_NkHitRigRn.ZRNYOTEIRIRITUN5)
    public Double getZrnyoteiriritun5() {
        return zrnyoteiriritun5;
    }

    public void setZrnyoteiriritun5(Double pZrnyoteiriritun5) {
        zrnyoteiriritun5 = pZrnyoteiriritun5;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_NkHitRigRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_NkHitRigRn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrn5nngt3nngtoutubkbn;

    @Column(name=GenZT_NkHitRigRn.ZRN5NNGT3NNGTOUTUBKBN)
    public String getZrn5nngt3nngtoutubkbn() {
        return zrn5nngt3nngtoutubkbn;
    }

    public void setZrn5nngt3nngtoutubkbn(String pZrn5nngt3nngtoutubkbn) {
        zrn5nngt3nngtoutubkbn = pZrn5nngt3nngtoutubkbn;
    }

    private String zrnkeiyakuoutoubikbn;

    @Column(name=GenZT_NkHitRigRn.ZRNKEIYAKUOUTOUBIKBN)
    public String getZrnkeiyakuoutoubikbn() {
        return zrnkeiyakuoutoubikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkeiyakuoutoubikbn(String pZrnkeiyakuoutoubikbn) {
        zrnkeiyakuoutoubikbn = pZrnkeiyakuoutoubikbn;
    }

    private String zrnyobiv7;

    @Column(name=GenZT_NkHitRigRn.ZRNYOBIV7)
    public String getZrnyobiv7() {
        return zrnyobiv7;
    }

    public void setZrnyobiv7(String pZrnyobiv7) {
        zrnyobiv7 = pZrnyobiv7;
    }

    private String zrnyobiv15;

    @Column(name=GenZT_NkHitRigRn.ZRNYOBIV15)
    public String getZrnyobiv15() {
        return zrnyobiv15;
    }

    public void setZrnyobiv15(String pZrnyobiv15) {
        zrnyobiv15 = pZrnyobiv15;
    }

    private Long zrngyousekihyoujisibous;

    @Column(name=GenZT_NkHitRigRn.ZRNGYOUSEKIHYOUJISIBOUS)
    public Long getZrngyousekihyoujisibous() {
        return zrngyousekihyoujisibous;
    }

    public void setZrngyousekihyoujisibous(Long pZrngyousekihyoujisibous) {
        zrngyousekihyoujisibous = pZrngyousekihyoujisibous;
    }

    private Long zrnkhnnkgk;

    @Column(name=GenZT_NkHitRigRn.ZRNKHNNKGK)
    public Long getZrnkhnnkgk() {
        return zrnkhnnkgk;
    }

    public void setZrnkhnnkgk(Long pZrnkhnnkgk) {
        zrnkhnnkgk = pZrnkhnnkgk;
    }

    private Long zrntounendmtwrhrgkruikeigk;

    @Column(name=GenZT_NkHitRigRn.ZRNTOUNENDMTWRHRGKRUIKEIGK)
    public Long getZrntounendmtwrhrgkruikeigk() {
        return zrntounendmtwrhrgkruikeigk;
    }

    public void setZrntounendmtwrhrgkruikeigk(Long pZrntounendmtwrhrgkruikeigk) {
        zrntounendmtwrhrgkruikeigk = pZrntounendmtwrhrgkruikeigk;
    }

    private Long zrnwarihurigakurisoku1;

    @Column(name=GenZT_NkHitRigRn.ZRNWARIHURIGAKURISOKU1)
    public Long getZrnwarihurigakurisoku1() {
        return zrnwarihurigakurisoku1;
    }

    public void setZrnwarihurigakurisoku1(Long pZrnwarihurigakurisoku1) {
        zrnwarihurigakurisoku1 = pZrnwarihurigakurisoku1;
    }

    private Long zrnwarihurigakurisoku2;

    @Column(name=GenZT_NkHitRigRn.ZRNWARIHURIGAKURISOKU2)
    public Long getZrnwarihurigakurisoku2() {
        return zrnwarihurigakurisoku2;
    }

    public void setZrnwarihurigakurisoku2(Long pZrnwarihurigakurisoku2) {
        zrnwarihurigakurisoku2 = pZrnwarihurigakurisoku2;
    }

    private Long zrnyokunendosyoyougakuyou;

    @Column(name=GenZT_NkHitRigRn.ZRNYOKUNENDOSYOYOUGAKUYOU)
    public Long getZrnyokunendosyoyougakuyou() {
        return zrnyokunendosyoyougakuyou;
    }

    public void setZrnyokunendosyoyougakuyou(Long pZrnyokunendosyoyougakuyou) {
        zrnyokunendosyoyougakuyou = pZrnyokunendosyoyougakuyou;
    }

    private Long zrnyokuyokunendosyoyougkyou;

    @Column(name=GenZT_NkHitRigRn.ZRNYOKUYOKUNENDOSYOYOUGKYOU)
    public Long getZrnyokuyokunendosyoyougkyou() {
        return zrnyokuyokunendosyoyougkyou;
    }

    public void setZrnyokuyokunendosyoyougkyou(Long pZrnyokuyokunendosyoyougkyou) {
        zrnyokuyokunendosyoyougkyou = pZrnyokuyokunendosyoyougkyou;
    }

    private Long zrnyuukoutyuusyoyougakuyou;

    @Column(name=GenZT_NkHitRigRn.ZRNYUUKOUTYUUSYOYOUGAKUYOU)
    public Long getZrnyuukoutyuusyoyougakuyou() {
        return zrnyuukoutyuusyoyougakuyou;
    }

    public void setZrnyuukoutyuusyoyougakuyou(Long pZrnyuukoutyuusyoyougakuyou) {
        zrnyuukoutyuusyoyougakuyou = pZrnyuukoutyuusyoyougakuyou;
    }

    private Long zrnsyoumetujisyoyougakuyou1;

    @Column(name=GenZT_NkHitRigRn.ZRNSYOUMETUJISYOYOUGAKUYOU1)
    public Long getZrnsyoumetujisyoyougakuyou1() {
        return zrnsyoumetujisyoyougakuyou1;
    }

    public void setZrnsyoumetujisyoyougakuyou1(Long pZrnsyoumetujisyoyougakuyou1) {
        zrnsyoumetujisyoyougakuyou1 = pZrnsyoumetujisyoyougakuyou1;
    }

    private Long zrnsyoumetujisyoyougakuyou2;

    @Column(name=GenZT_NkHitRigRn.ZRNSYOUMETUJISYOYOUGAKUYOU2)
    public Long getZrnsyoumetujisyoyougakuyou2() {
        return zrnsyoumetujisyoyougakuyou2;
    }

    public void setZrnsyoumetujisyoyougakuyou2(Long pZrnsyoumetujisyoyougakuyou2) {
        zrnsyoumetujisyoyougakuyou2 = pZrnsyoumetujisyoyougakuyou2;
    }

    private Long zrnrisadtaisyouv;

    @Column(name=GenZT_NkHitRigRn.ZRNRISADTAISYOUV)
    public Long getZrnrisadtaisyouv() {
        return zrnrisadtaisyouv;
    }

    public void setZrnrisadtaisyouv(Long pZrnrisadtaisyouv) {
        zrnrisadtaisyouv = pZrnrisadtaisyouv;
    }

    private Long zrnnknengk;

    @Column(name=GenZT_NkHitRigRn.ZRNNKNENGK)
    public Long getZrnnknengk() {
        return zrnnknengk;
    }

    public void setZrnnknengk(Long pZrnnknengk) {
        zrnnknengk = pZrnnknengk;
    }

    private Long zrnsyukeiyakunenkinnengaku;

    @Column(name=GenZT_NkHitRigRn.ZRNSYUKEIYAKUNENKINNENGAKU)
    public Long getZrnsyukeiyakunenkinnengaku() {
        return zrnsyukeiyakunenkinnengaku;
    }

    public void setZrnsyukeiyakunenkinnengaku(Long pZrnsyukeiyakunenkinnengaku) {
        zrnsyukeiyakunenkinnengaku = pZrnsyukeiyakunenkinnengaku;
    }

    private Long zrnkaimasinenkinnengaku;

    @Column(name=GenZT_NkHitRigRn.ZRNKAIMASINENKINNENGAKU)
    public Long getZrnkaimasinenkinnengaku() {
        return zrnkaimasinenkinnengaku;
    }

    public void setZrnkaimasinenkinnengaku(Long pZrnkaimasinenkinnengaku) {
        zrnkaimasinenkinnengaku = pZrnkaimasinenkinnengaku;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_NkHitRigRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrnyobiv38;

    @Column(name=GenZT_NkHitRigRn.ZRNYOBIV38)
    public String getZrnyobiv38() {
        return zrnyobiv38;
    }

    public void setZrnyobiv38(String pZrnyobiv38) {
        zrnyobiv38 = pZrnyobiv38;
    }

    private String zrnkeisankijyunymd;

    @Column(name=GenZT_NkHitRigRn.ZRNKEISANKIJYUNYMD)
    public String getZrnkeisankijyunymd() {
        return zrnkeisankijyunymd;
    }

    public void setZrnkeisankijyunymd(String pZrnkeisankijyunymd) {
        zrnkeisankijyunymd = pZrnkeisankijyunymd;
    }

    private String zrntoujigyounendo;

    @Column(name=GenZT_NkHitRigRn.ZRNTOUJIGYOUNENDO)
    public String getZrntoujigyounendo() {
        return zrntoujigyounendo;
    }

    public void setZrntoujigyounendo(String pZrntoujigyounendo) {
        zrntoujigyounendo = pZrntoujigyounendo;
    }

    private String zrnyokujigyounendo;

    @Column(name=GenZT_NkHitRigRn.ZRNYOKUJIGYOUNENDO)
    public String getZrnyokujigyounendo() {
        return zrnyokujigyounendo;
    }

    public void setZrnyokujigyounendo(String pZrnyokujigyounendo) {
        zrnyokujigyounendo = pZrnyokujigyounendo;
    }

    private String zrnyokuyokujigyounendo;

    @Column(name=GenZT_NkHitRigRn.ZRNYOKUYOKUJIGYOUNENDO)
    public String getZrnyokuyokujigyounendo() {
        return zrnyokuyokujigyounendo;
    }

    public void setZrnyokuyokujigyounendo(String pZrnyokuyokujigyounendo) {
        zrnyokuyokujigyounendo = pZrnyokuyokujigyounendo;
    }

    private String zrntounendseisikiwariatehyj;

    @Column(name=GenZT_NkHitRigRn.ZRNTOUNENDSEISIKIWARIATEHYJ)
    public String getZrntounendseisikiwariatehyj() {
        return zrntounendseisikiwariatehyj;
    }

    public void setZrntounendseisikiwariatehyj(String pZrntounendseisikiwariatehyj) {
        zrntounendseisikiwariatehyj = pZrntounendseisikiwariatehyj;
    }

    private String zrnyknndseisikiwariatehyj;

    @Column(name=GenZT_NkHitRigRn.ZRNYKNNDSEISIKIWARIATEHYJ)
    public String getZrnyknndseisikiwariatehyj() {
        return zrnyknndseisikiwariatehyj;
    }

    public void setZrnyknndseisikiwariatehyj(String pZrnyknndseisikiwariatehyj) {
        zrnyknndseisikiwariatehyj = pZrnyknndseisikiwariatehyj;
    }

    private String zrnznnndseisikiwratehyj;

    @Column(name=GenZT_NkHitRigRn.ZRNZNNNDSEISIKIWRATEHYJ)
    public String getZrnznnndseisikiwratehyj() {
        return zrnznnndseisikiwratehyj;
    }

    public void setZrnznnndseisikiwratehyj(String pZrnznnndseisikiwratehyj) {
        zrnznnndseisikiwratehyj = pZrnznnndseisikiwratehyj;
    }

    private String zrntounendodhaneizumihyouji;

    @Column(name=GenZT_NkHitRigRn.ZRNTOUNENDODHANEIZUMIHYOUJI)
    public String getZrntounendodhaneizumihyouji() {
        return zrntounendodhaneizumihyouji;
    }

    public void setZrntounendodhaneizumihyouji(String pZrntounendodhaneizumihyouji) {
        zrntounendodhaneizumihyouji = pZrntounendodhaneizumihyouji;
    }

    private Long zrntounendooutoubijitend;

    @Column(name=GenZT_NkHitRigRn.ZRNTOUNENDOOUTOUBIJITEND)
    public Long getZrntounendooutoubijitend() {
        return zrntounendooutoubijitend;
    }

    public void setZrntounendooutoubijitend(Long pZrntounendooutoubijitend) {
        zrntounendooutoubijitend = pZrntounendooutoubijitend;
    }

    private Double zrntunndoutubikutunndmtrrt;

    @Column(name=GenZT_NkHitRigRn.ZRNTUNNDOUTUBIKUTUNNDMTRRT)
    public Double getZrntunndoutubikutunndmtrrt() {
        return zrntunndoutubikutunndmtrrt;
    }

    public void setZrntunndoutubikutunndmtrrt(Double pZrntunndoutubikutunndmtrrt) {
        zrntunndoutubikutunndmtrrt = pZrntunndoutubikutunndmtrrt;
    }

    private Double zrntunndmtikuyknndoutubrrt;

    @Column(name=GenZT_NkHitRigRn.ZRNTUNNDMTIKUYKNNDOUTUBRRT)
    public Double getZrntunndmtikuyknndoutubrrt() {
        return zrntunndmtikuyknndoutubrrt;
    }

    public void setZrntunndmtikuyknndoutubrrt(Double pZrntunndmtikuyknndoutubrrt) {
        zrntunndmtikuyknndoutubrrt = pZrntunndmtikuyknndoutubrrt;
    }

    private Double zrnyknndoutubikouyknndmtrrt;

    @Column(name=GenZT_NkHitRigRn.ZRNYKNNDOUTUBIKOUYKNNDMTRRT)
    public Double getZrnyknndoutubikouyknndmtrrt() {
        return zrnyknndoutubikouyknndmtrrt;
    }

    public void setZrnyknndoutubikouyknndmtrrt(Double pZrnyknndoutubikouyknndmtrrt) {
        zrnyknndoutubikouyknndmtrrt = pZrnyknndoutubikouyknndmtrrt;
    }

    private Double zrnznnndoutubikuktyumtrrt;

    @Column(name=GenZT_NkHitRigRn.ZRNZNNNDOUTUBIKUKTYUMTRRT)
    public Double getZrnznnndoutubikuktyumtrrt() {
        return zrnznnndoutubikuktyumtrrt;
    }

    public void setZrnznnndoutubikuktyumtrrt(Double pZrnznnndoutubikuktyumtrrt) {
        zrnznnndoutubikuktyumtrrt = pZrnznnndoutubikuktyumtrrt;
    }

    private Double zrnktyumtikutunndoutubrrt;

    @Column(name=GenZT_NkHitRigRn.ZRNKTYUMTIKUTUNNDOUTUBRRT)
    public Double getZrnktyumtikutunndoutubrrt() {
        return zrnktyumtikutunndoutubrrt;
    }

    public void setZrnktyumtikutunndoutubrrt(Double pZrnktyumtikutunndoutubrrt) {
        zrnktyumtikutunndoutubrrt = pZrnktyumtikutunndoutubrrt;
    }

    private Double zrntunndoutubikuktyumtrrt;

    @Column(name=GenZT_NkHitRigRn.ZRNTUNNDOUTUBIKUKTYUMTRRT)
    public Double getZrntunndoutubikuktyumtrrt() {
        return zrntunndoutubikuktyumtrrt;
    }

    public void setZrntunndoutubikuktyumtrrt(Double pZrntunndoutubikuktyumtrrt) {
        zrntunndoutubikuktyumtrrt = pZrntunndoutubikuktyumtrrt;
    }

    private Double zrnktyumtikutunndmtrrt;

    @Column(name=GenZT_NkHitRigRn.ZRNKTYUMTIKUTUNNDMTRRT)
    public Double getZrnktyumtikutunndmtrrt() {
        return zrnktyumtikutunndmtrrt;
    }

    public void setZrnktyumtikutunndmtrrt(Double pZrnktyumtikutunndmtrrt) {
        zrnktyumtikutunndmtrrt = pZrnktyumtikutunndmtrrt;
    }

    private String zrnyobiv4;

    @Column(name=GenZT_NkHitRigRn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }

    private String zrnyobiv8x2;

    @Column(name=GenZT_NkHitRigRn.ZRNYOBIV8X2)
    public String getZrnyobiv8x2() {
        return zrnyobiv8x2;
    }

    public void setZrnyobiv8x2(String pZrnyobiv8x2) {
        zrnyobiv8x2 = pZrnyobiv8x2;
    }

    private String zrnyobiv16;

    @Column(name=GenZT_NkHitRigRn.ZRNYOBIV16)
    public String getZrnyobiv16() {
        return zrnyobiv16;
    }

    public void setZrnyobiv16(String pZrnyobiv16) {
        zrnyobiv16 = pZrnyobiv16;
    }
}