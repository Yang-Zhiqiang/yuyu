package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NkHitKsnTy;
import yuyu.def.db.mapping.GenZT_NkHitKsnTy;
import yuyu.def.db.meta.GenQZT_NkHitKsnTy;
import yuyu.def.db.meta.QZT_NkHitKsnTy;

/**
 * 年金配当所要額Ｆ決算報告用テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NkHitKsnTy}</td><td colspan="3">年金配当所要額Ｆ決算報告用テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtynksyousyono ztynksyousyono}</td><td>（中継用）年金証書番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeijyouym</td><td>（中継用）計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakusyuruicdv2</td><td>（中継用）主契約種類コードＶ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentkbn</td><td>（中継用）区分経理用セグメント区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyourgnbnskkbn</td><td>（中継用）区分経理用利源分析区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkintypekbn</td><td>（中継用）年金タイプ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknshry</td><td>（中継用）年金支払期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinitijisiharainendo</td><td>（中継用）年金一時支払年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymanryoukbn</td><td>（中継用）満了区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakunendo</td><td>（中継用）契約年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinkaisinendo</td><td>（中継用）年金開始年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseizonkbn</td><td>（中継用）生存区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritun5</td><td>（中継用）予定利率Ｎ５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhihokensyaagev2</td><td>（中継用）被保険者年令Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zty5nngt3nngtoutubkbn</td><td>（中継用）５年ごと３年ごと応当日区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubikbn</td><td>（中継用）契約応当日区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv7</td><td>（中継用）予備項目Ｖ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv15</td><td>（中継用）予備項目Ｖ１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygyousekihyoujisibous</td><td>（中継用）業績表示死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykhnnkgk</td><td>（中継用）基本年金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytounendmtwrhrgkruikeigk</td><td>（中継用）当年度末割振額累計額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztywarihurigakurisoku1</td><td>（中継用）割振額利息１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztywarihurigakurisoku2</td><td>（中継用）割振額利息２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyokunendosyoyougakuyou</td><td>（中継用）翌年度所要額用</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyokuyokunendosyoyougkyou</td><td>（中継用）翌々年度所要額用</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyuukoutyuusyoyougakuyou</td><td>（中継用）有効中所要額用</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyoumetujisyoyougakuyou1</td><td>（中継用）消滅時所要額用１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyoumetujisyoyougakuyou2</td><td>（中継用）消滅時所要額用２</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyrisadtaisyouv</td><td>（中継用）利差Ｄ対象Ｖ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynknengk</td><td>（中継用）年金年額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyukeiyakunenkinnengaku</td><td>（中継用）主契約年金年額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykaimasinenkinnengaku</td><td>（中継用）買増年金年額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyobiv8</td><td>（中継用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv38</td><td>（中継用）予備項目Ｖ３８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeisankijyunymd</td><td>（中継用）計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoujigyounendo</td><td>（中継用）当事業年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyokujigyounendo</td><td>（中継用）翌事業年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyokuyokujigyounendo</td><td>（中継用）翌々事業年度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytounendseisikiwariatehyj</td><td>（中継用）当年度正式割当表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyknndseisikiwariatehyj</td><td>（中継用）翌年度正式割当表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyznnndseisikiwratehyj</td><td>（中継用）前年度正式割当表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytounendodhaneizumihyouji</td><td>（中継用）当年度Ｄ反映済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytounendooutoubijitend</td><td>（中継用）当年度応当日時点Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytunndoutubikutunndmtrrt</td><td>（中継用）当年度応当日以降当年度末利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztytunndmtikuyknndoutubrrt</td><td>（中継用）当年度末以降翌年度応当日利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztyyknndoutubikouyknndmtrrt</td><td>（中継用）翌年度応当日以降翌年度末利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztyznnndoutubikuktyumtrrt</td><td>（中継用）前年度応当日以降期中末利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztyktyumtikutunndoutubrrt</td><td>（中継用）期中末以降当年度応当日利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztytunndoutubikuktyumtrrt</td><td>（中継用）当年度応当日以降期中末利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztyktyumtikutunndmtrrt</td><td>（中継用）期中末以降当年度末利率</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztyyobiv4</td><td>（中継用）予備項目Ｖ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8x2</td><td>（中継用）予備項目Ｖ８＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv16</td><td>（中継用）予備項目Ｖ１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_NkHitKsnTy
 * @see     GenZT_NkHitKsnTy
 * @see     QZT_NkHitKsnTy
 * @see     GenQZT_NkHitKsnTy
 */
public class PKZT_NkHitKsnTy extends AbstractExDBPrimaryKey<ZT_NkHitKsnTy, PKZT_NkHitKsnTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_NkHitKsnTy() {
    }

    public PKZT_NkHitKsnTy(String pZtynksyousyono) {
        ztynksyousyono = pZtynksyousyono;
    }

    @Transient
    @Override
    public Class<ZT_NkHitKsnTy> getEntityClass() {
        return ZT_NkHitKsnTy.class;
    }

    private String ztynksyousyono;

    public String getZtynksyousyono() {
        return ztynksyousyono;
    }

    public void setZtynksyousyono(String pZtynksyousyono) {
        ztynksyousyono = pZtynksyousyono;
    }

}