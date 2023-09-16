package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NkHitKsnRn;
import yuyu.def.db.mapping.GenZT_NkHitKsnRn;
import yuyu.def.db.meta.GenQZT_NkHitKsnRn;
import yuyu.def.db.meta.QZT_NkHitKsnRn;

/**
 * 年金配当所要額Ｆ決算報告用テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkHitKsnRn}</td><td colspan="3">年金配当所要額Ｆ決算報告用テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnksyousyono zrnnksyousyono}</td><td>（連携用）年金証書番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeijyouym</td><td>（連携用）計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukeiyakusyuruicdv2</td><td>（連携用）主契約種類コードＶ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyousegmentkbn</td><td>（連携用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkbnkeiriyourgnbnskkbn</td><td>（連携用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkintypekbn</td><td>（連携用）年金タイプ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnknshry</td><td>（連携用）年金支払期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinitijisiharainendo</td><td>（連携用）年金一時支払年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmanryoukbn</td><td>（連携用）満了区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakunendo</td><td>（連携用）契約年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisinendo</td><td>（連携用）年金開始年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseizonkbn</td><td>（連携用）生存区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritun5</td><td>（連携用）予定利率Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhihokensyaagev2</td><td>（連携用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrn5nngt3nngtoutubkbn</td><td>（連携用）５年ごと３年ごと応当日区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubikbn</td><td>（連携用）契約応当日区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv7</td><td>（連携用）予備項目Ｖ７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv15</td><td>（連携用）予備項目Ｖ１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngyousekihyoujisibous</td><td>（連携用）業績表示死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkhnnkgk</td><td>（連携用）基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntounendmtwrhrgkruikeigk</td><td>（連携用）当年度末割振額累計額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnwarihurigakurisoku1</td><td>（連携用）割振額利息１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnwarihurigakurisoku2</td><td>（連携用）割振額利息２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyokunendosyoyougakuyou</td><td>（連携用）翌年度所要額用</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyokuyokunendosyoyougkyou</td><td>（連携用）翌々年度所要額用</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyuukoutyuusyoyougakuyou</td><td>（連携用）有効中所要額用</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyoumetujisyoyougakuyou1</td><td>（連携用）消滅時所要額用１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyoumetujisyoyougakuyou2</td><td>（連携用）消滅時所要額用２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnrisadtaisyouv</td><td>（連携用）利差Ｄ対象Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnknengk</td><td>（連携用）年金年額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyukeiyakunenkinnengaku</td><td>（連携用）主契約年金年額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkaimasinenkinnengaku</td><td>（連携用）買増年金年額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyobiv8</td><td>（連携用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv38</td><td>（連携用）予備項目Ｖ３８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeisankijyunymd</td><td>（連携用）計算基準日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoujigyounendo</td><td>（連携用）当事業年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyokujigyounendo</td><td>（連携用）翌事業年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyokuyokujigyounendo</td><td>（連携用）翌々事業年度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntounendseisikiwariatehyj</td><td>（連携用）当年度正式割当表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyknndseisikiwariatehyj</td><td>（連携用）翌年度正式割当表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnznnndseisikiwratehyj</td><td>（連携用）前年度正式割当表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntounendodhaneizumihyouji</td><td>（連携用）当年度Ｄ反映済表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntounendooutoubijitend</td><td>（連携用）当年度応当日時点Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntunndoutubikutunndmtrrt</td><td>（連携用）当年度応当日以降当年度末利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrntunndmtikuyknndoutubrrt</td><td>（連携用）当年度末以降翌年度応当日利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyknndoutubikouyknndmtrrt</td><td>（連携用）翌年度応当日以降翌年度末利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnznnndoutubikuktyumtrrt</td><td>（連携用）前年度応当日以降期中末利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnktyumtikutunndoutubrrt</td><td>（連携用）期中末以降当年度応当日利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrntunndoutubikuktyumtrrt</td><td>（連携用）当年度応当日以降期中末利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnktyumtikutunndmtrrt</td><td>（連携用）期中末以降当年度末利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnyobiv4</td><td>（連携用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8x2</td><td>（連携用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv16</td><td>（連携用）予備項目Ｖ１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkHitKsnRn
 * @see     GenZT_NkHitKsnRn
 * @see     QZT_NkHitKsnRn
 * @see     GenQZT_NkHitKsnRn
 */
public class PKZT_NkHitKsnRn extends AbstractExDBPrimaryKey<ZT_NkHitKsnRn, PKZT_NkHitKsnRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_NkHitKsnRn() {
    }

    public PKZT_NkHitKsnRn(String pZrnnksyousyono) {
        zrnnksyousyono = pZrnnksyousyono;
    }

    @Transient
    @Override
    public Class<ZT_NkHitKsnRn> getEntityClass() {
        return ZT_NkHitKsnRn.class;
    }

    private String zrnnksyousyono;

    public String getZrnnksyousyono() {
        return zrnnksyousyono;
    }

    public void setZrnnksyousyono(String pZrnnksyousyono) {
        zrnnksyousyono = pZrnnksyousyono;
    }

}