package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.id.PKBM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.meta.GenQBM_RisaHitSyouhnyouRateD2;
import yuyu.def.db.meta.QBM_RisaHitSyouhnyouRateD2;

/**
 * 利差配当商品用Ｄレートマスタ２ テーブルのマッピング情報クラスで、 {@link BM_RisaHitSyouhnyouRateD2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RisaHitSyouhnyouRateD2}</td><td colspan="3">利差配当商品用Ｄレートマスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getPalhokensyuruikigou palhokensyuruikigou}</td><td>ＰＡＬ保険種類記号</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhokensyuruikigousdicode palhokensyuruikigousdicode}</td><td>ＰＡＬ保険種類記号世代コード</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalyoteiriritu palyoteiriritu}</td><td>ＰＡＬ予定利率</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalpmencode palpmencode}</td><td>ＰＡＬＰ免コード</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalharaikomikaisuu palharaikomikaisuu}</td><td>ＰＡＬ払込回数</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhhknsei palhhknsei}</td><td>ＰＡＬ被保険者性別</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalkeiyakujihhknnen palkeiyakujihhknnen}</td><td>ＰＡＬ契約時被保険者年令</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalsaimankihyouji palsaimankihyouji}</td><td>ＰＡＬ才満期契約表示</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhokenkikan palhokenkikan}</td><td>ＰＡＬ保険期間</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalpharaikomikikan palpharaikomikikan}</td><td>ＰＡＬＰ払込期間</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalannaihuyouriyuukbn palannaihuyouriyuukbn}</td><td>ＰＡＬ案内不要理由区分</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getRatetuukasyukbn ratetuukasyukbn}</td><td>レート用通貨種類区分</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getRatedai1hknkkn ratedai1hknkkn}</td><td>レート用第１保険期間</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPaldnendo paldnendo}</td><td>ＰＡＬＤ年度</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPaldratenaikakucode paldratenaikakucode}</td><td>ＰＡＬＤレート内定確定コード</td><td align="center">{@link PKBM_RisaHitSyouhnyouRateD2 ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getDrate00 drate00}</td><td>Ｄレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate01 drate01}</td><td>Ｄレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate02 drate02}</td><td>Ｄレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate03 drate03}</td><td>Ｄレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate04 drate04}</td><td>Ｄレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate05 drate05}</td><td>Ｄレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate06 drate06}</td><td>Ｄレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate07 drate07}</td><td>Ｄレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate08 drate08}</td><td>Ｄレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate09 drate09}</td><td>Ｄレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate10 drate10}</td><td>Ｄレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate11 drate11}</td><td>Ｄレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate12 drate12}</td><td>Ｄレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate13 drate13}</td><td>Ｄレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate14 drate14}</td><td>Ｄレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate15 drate15}</td><td>Ｄレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate16 drate16}</td><td>Ｄレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate17 drate17}</td><td>Ｄレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate18 drate18}</td><td>Ｄレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate19 drate19}</td><td>Ｄレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate20 drate20}</td><td>Ｄレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate21 drate21}</td><td>Ｄレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate22 drate22}</td><td>Ｄレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate23 drate23}</td><td>Ｄレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate24 drate24}</td><td>Ｄレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate25 drate25}</td><td>Ｄレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate26 drate26}</td><td>Ｄレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate27 drate27}</td><td>Ｄレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate28 drate28}</td><td>Ｄレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate29 drate29}</td><td>Ｄレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate30 drate30}</td><td>Ｄレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate31 drate31}</td><td>Ｄレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate32 drate32}</td><td>Ｄレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate33 drate33}</td><td>Ｄレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate34 drate34}</td><td>Ｄレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate35 drate35}</td><td>Ｄレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate36 drate36}</td><td>Ｄレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate37 drate37}</td><td>Ｄレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate38 drate38}</td><td>Ｄレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate39 drate39}</td><td>Ｄレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate40 drate40}</td><td>Ｄレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate41 drate41}</td><td>Ｄレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate42 drate42}</td><td>Ｄレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate43 drate43}</td><td>Ｄレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate44 drate44}</td><td>Ｄレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate45 drate45}</td><td>Ｄレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate46 drate46}</td><td>Ｄレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate47 drate47}</td><td>Ｄレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate48 drate48}</td><td>Ｄレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate49 drate49}</td><td>Ｄレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate50 drate50}</td><td>Ｄレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate51 drate51}</td><td>Ｄレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate52 drate52}</td><td>Ｄレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate53 drate53}</td><td>Ｄレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate54 drate54}</td><td>Ｄレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate55 drate55}</td><td>Ｄレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate56 drate56}</td><td>Ｄレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate57 drate57}</td><td>Ｄレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate58 drate58}</td><td>Ｄレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate59 drate59}</td><td>Ｄレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate60 drate60}</td><td>Ｄレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate61 drate61}</td><td>Ｄレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate62 drate62}</td><td>Ｄレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate63 drate63}</td><td>Ｄレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate64 drate64}</td><td>Ｄレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate65 drate65}</td><td>Ｄレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate66 drate66}</td><td>Ｄレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate67 drate67}</td><td>Ｄレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate68 drate68}</td><td>Ｄレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate69 drate69}</td><td>Ｄレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate70 drate70}</td><td>Ｄレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate71 drate71}</td><td>Ｄレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate72 drate72}</td><td>Ｄレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate73 drate73}</td><td>Ｄレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate74 drate74}</td><td>Ｄレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate75 drate75}</td><td>Ｄレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate76 drate76}</td><td>Ｄレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate77 drate77}</td><td>Ｄレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate78 drate78}</td><td>Ｄレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate79 drate79}</td><td>Ｄレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate80 drate80}</td><td>Ｄレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate81 drate81}</td><td>Ｄレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate82 drate82}</td><td>Ｄレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate83 drate83}</td><td>Ｄレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate84 drate84}</td><td>Ｄレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate85 drate85}</td><td>Ｄレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate86 drate86}</td><td>Ｄレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate87 drate87}</td><td>Ｄレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate88 drate88}</td><td>Ｄレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate89 drate89}</td><td>Ｄレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate90 drate90}</td><td>Ｄレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate91 drate91}</td><td>Ｄレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate92 drate92}</td><td>Ｄレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate93 drate93}</td><td>Ｄレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate94 drate94}</td><td>Ｄレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate95 drate95}</td><td>Ｄレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate96 drate96}</td><td>Ｄレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate97 drate97}</td><td>Ｄレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate98 drate98}</td><td>Ｄレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDrate99 drate99}</td><td>Ｄレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate00 dyouvrate00}</td><td>Ｄ用Ｖレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate01 dyouvrate01}</td><td>Ｄ用Ｖレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate02 dyouvrate02}</td><td>Ｄ用Ｖレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate03 dyouvrate03}</td><td>Ｄ用Ｖレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate04 dyouvrate04}</td><td>Ｄ用Ｖレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate05 dyouvrate05}</td><td>Ｄ用Ｖレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate06 dyouvrate06}</td><td>Ｄ用Ｖレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate07 dyouvrate07}</td><td>Ｄ用Ｖレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate08 dyouvrate08}</td><td>Ｄ用Ｖレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate09 dyouvrate09}</td><td>Ｄ用Ｖレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate10 dyouvrate10}</td><td>Ｄ用Ｖレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate11 dyouvrate11}</td><td>Ｄ用Ｖレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate12 dyouvrate12}</td><td>Ｄ用Ｖレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate13 dyouvrate13}</td><td>Ｄ用Ｖレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate14 dyouvrate14}</td><td>Ｄ用Ｖレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate15 dyouvrate15}</td><td>Ｄ用Ｖレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate16 dyouvrate16}</td><td>Ｄ用Ｖレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate17 dyouvrate17}</td><td>Ｄ用Ｖレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate18 dyouvrate18}</td><td>Ｄ用Ｖレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate19 dyouvrate19}</td><td>Ｄ用Ｖレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate20 dyouvrate20}</td><td>Ｄ用Ｖレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate21 dyouvrate21}</td><td>Ｄ用Ｖレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate22 dyouvrate22}</td><td>Ｄ用Ｖレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate23 dyouvrate23}</td><td>Ｄ用Ｖレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate24 dyouvrate24}</td><td>Ｄ用Ｖレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate25 dyouvrate25}</td><td>Ｄ用Ｖレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate26 dyouvrate26}</td><td>Ｄ用Ｖレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate27 dyouvrate27}</td><td>Ｄ用Ｖレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate28 dyouvrate28}</td><td>Ｄ用Ｖレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate29 dyouvrate29}</td><td>Ｄ用Ｖレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate30 dyouvrate30}</td><td>Ｄ用Ｖレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate31 dyouvrate31}</td><td>Ｄ用Ｖレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate32 dyouvrate32}</td><td>Ｄ用Ｖレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate33 dyouvrate33}</td><td>Ｄ用Ｖレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate34 dyouvrate34}</td><td>Ｄ用Ｖレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate35 dyouvrate35}</td><td>Ｄ用Ｖレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate36 dyouvrate36}</td><td>Ｄ用Ｖレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate37 dyouvrate37}</td><td>Ｄ用Ｖレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate38 dyouvrate38}</td><td>Ｄ用Ｖレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate39 dyouvrate39}</td><td>Ｄ用Ｖレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate40 dyouvrate40}</td><td>Ｄ用Ｖレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate41 dyouvrate41}</td><td>Ｄ用Ｖレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate42 dyouvrate42}</td><td>Ｄ用Ｖレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate43 dyouvrate43}</td><td>Ｄ用Ｖレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate44 dyouvrate44}</td><td>Ｄ用Ｖレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate45 dyouvrate45}</td><td>Ｄ用Ｖレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate46 dyouvrate46}</td><td>Ｄ用Ｖレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate47 dyouvrate47}</td><td>Ｄ用Ｖレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate48 dyouvrate48}</td><td>Ｄ用Ｖレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate49 dyouvrate49}</td><td>Ｄ用Ｖレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate50 dyouvrate50}</td><td>Ｄ用Ｖレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate51 dyouvrate51}</td><td>Ｄ用Ｖレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate52 dyouvrate52}</td><td>Ｄ用Ｖレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate53 dyouvrate53}</td><td>Ｄ用Ｖレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate54 dyouvrate54}</td><td>Ｄ用Ｖレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate55 dyouvrate55}</td><td>Ｄ用Ｖレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate56 dyouvrate56}</td><td>Ｄ用Ｖレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate57 dyouvrate57}</td><td>Ｄ用Ｖレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate58 dyouvrate58}</td><td>Ｄ用Ｖレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate59 dyouvrate59}</td><td>Ｄ用Ｖレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate60 dyouvrate60}</td><td>Ｄ用Ｖレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate61 dyouvrate61}</td><td>Ｄ用Ｖレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate62 dyouvrate62}</td><td>Ｄ用Ｖレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate63 dyouvrate63}</td><td>Ｄ用Ｖレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate64 dyouvrate64}</td><td>Ｄ用Ｖレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate65 dyouvrate65}</td><td>Ｄ用Ｖレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate66 dyouvrate66}</td><td>Ｄ用Ｖレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate67 dyouvrate67}</td><td>Ｄ用Ｖレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate68 dyouvrate68}</td><td>Ｄ用Ｖレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate69 dyouvrate69}</td><td>Ｄ用Ｖレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate70 dyouvrate70}</td><td>Ｄ用Ｖレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate71 dyouvrate71}</td><td>Ｄ用Ｖレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate72 dyouvrate72}</td><td>Ｄ用Ｖレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate73 dyouvrate73}</td><td>Ｄ用Ｖレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate74 dyouvrate74}</td><td>Ｄ用Ｖレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate75 dyouvrate75}</td><td>Ｄ用Ｖレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate76 dyouvrate76}</td><td>Ｄ用Ｖレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate77 dyouvrate77}</td><td>Ｄ用Ｖレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate78 dyouvrate78}</td><td>Ｄ用Ｖレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate79 dyouvrate79}</td><td>Ｄ用Ｖレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate80 dyouvrate80}</td><td>Ｄ用Ｖレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate81 dyouvrate81}</td><td>Ｄ用Ｖレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate82 dyouvrate82}</td><td>Ｄ用Ｖレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate83 dyouvrate83}</td><td>Ｄ用Ｖレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate84 dyouvrate84}</td><td>Ｄ用Ｖレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate85 dyouvrate85}</td><td>Ｄ用Ｖレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate86 dyouvrate86}</td><td>Ｄ用Ｖレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate87 dyouvrate87}</td><td>Ｄ用Ｖレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate88 dyouvrate88}</td><td>Ｄ用Ｖレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate89 dyouvrate89}</td><td>Ｄ用Ｖレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate90 dyouvrate90}</td><td>Ｄ用Ｖレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate91 dyouvrate91}</td><td>Ｄ用Ｖレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate92 dyouvrate92}</td><td>Ｄ用Ｖレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate93 dyouvrate93}</td><td>Ｄ用Ｖレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate94 dyouvrate94}</td><td>Ｄ用Ｖレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate95 dyouvrate95}</td><td>Ｄ用Ｖレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate96 dyouvrate96}</td><td>Ｄ用Ｖレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate97 dyouvrate97}</td><td>Ｄ用Ｖレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate98 dyouvrate98}</td><td>Ｄ用Ｖレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getDyouvrate99 dyouvrate99}</td><td>Ｄ用Ｖレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_RisaHitSyouhnyouRateD2
 * @see     PKBM_RisaHitSyouhnyouRateD2
 * @see     QBM_RisaHitSyouhnyouRateD2
 * @see     GenQBM_RisaHitSyouhnyouRateD2
 */
@MappedSuperclass
@Table(name=GenBM_RisaHitSyouhnyouRateD2.TABLE_NAME)
@IdClass(value=PKBM_RisaHitSyouhnyouRateD2.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_RisaHitSyouhnyouRateD2 extends AbstractExDBEntity<BM_RisaHitSyouhnyouRateD2, PKBM_RisaHitSyouhnyouRateD2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_RisaHitSyouhnyouRateD2";
    public static final String PALHOKENSYURUIKIGOU      = "palhokensyuruikigou";
    public static final String PALHOKENSYURUIKIGOUSDICODE = "palhokensyuruikigousdicode";
    public static final String PALYOTEIRIRITU           = "palyoteiriritu";
    public static final String PALPMENCODE              = "palpmencode";
    public static final String PALHARAIKOMIKAISUU       = "palharaikomikaisuu";
    public static final String PALHHKNSEI               = "palhhknsei";
    public static final String PALKEIYAKUJIHHKNNEN      = "palkeiyakujihhknnen";
    public static final String PALSAIMANKIHYOUJI        = "palsaimankihyouji";
    public static final String PALHOKENKIKAN            = "palhokenkikan";
    public static final String PALPHARAIKOMIKIKAN       = "palpharaikomikikan";
    public static final String PALANNAIHUYOURIYUUKBN    = "palannaihuyouriyuukbn";
    public static final String RATETUUKASYUKBN          = "ratetuukasyukbn";
    public static final String RATEDAI1HKNKKN           = "ratedai1hknkkn";
    public static final String PALDNENDO                = "paldnendo";
    public static final String PALDRATENAIKAKUCODE      = "paldratenaikakucode";
    public static final String DRATE00                  = "drate00";
    public static final String DRATE01                  = "drate01";
    public static final String DRATE02                  = "drate02";
    public static final String DRATE03                  = "drate03";
    public static final String DRATE04                  = "drate04";
    public static final String DRATE05                  = "drate05";
    public static final String DRATE06                  = "drate06";
    public static final String DRATE07                  = "drate07";
    public static final String DRATE08                  = "drate08";
    public static final String DRATE09                  = "drate09";
    public static final String DRATE10                  = "drate10";
    public static final String DRATE11                  = "drate11";
    public static final String DRATE12                  = "drate12";
    public static final String DRATE13                  = "drate13";
    public static final String DRATE14                  = "drate14";
    public static final String DRATE15                  = "drate15";
    public static final String DRATE16                  = "drate16";
    public static final String DRATE17                  = "drate17";
    public static final String DRATE18                  = "drate18";
    public static final String DRATE19                  = "drate19";
    public static final String DRATE20                  = "drate20";
    public static final String DRATE21                  = "drate21";
    public static final String DRATE22                  = "drate22";
    public static final String DRATE23                  = "drate23";
    public static final String DRATE24                  = "drate24";
    public static final String DRATE25                  = "drate25";
    public static final String DRATE26                  = "drate26";
    public static final String DRATE27                  = "drate27";
    public static final String DRATE28                  = "drate28";
    public static final String DRATE29                  = "drate29";
    public static final String DRATE30                  = "drate30";
    public static final String DRATE31                  = "drate31";
    public static final String DRATE32                  = "drate32";
    public static final String DRATE33                  = "drate33";
    public static final String DRATE34                  = "drate34";
    public static final String DRATE35                  = "drate35";
    public static final String DRATE36                  = "drate36";
    public static final String DRATE37                  = "drate37";
    public static final String DRATE38                  = "drate38";
    public static final String DRATE39                  = "drate39";
    public static final String DRATE40                  = "drate40";
    public static final String DRATE41                  = "drate41";
    public static final String DRATE42                  = "drate42";
    public static final String DRATE43                  = "drate43";
    public static final String DRATE44                  = "drate44";
    public static final String DRATE45                  = "drate45";
    public static final String DRATE46                  = "drate46";
    public static final String DRATE47                  = "drate47";
    public static final String DRATE48                  = "drate48";
    public static final String DRATE49                  = "drate49";
    public static final String DRATE50                  = "drate50";
    public static final String DRATE51                  = "drate51";
    public static final String DRATE52                  = "drate52";
    public static final String DRATE53                  = "drate53";
    public static final String DRATE54                  = "drate54";
    public static final String DRATE55                  = "drate55";
    public static final String DRATE56                  = "drate56";
    public static final String DRATE57                  = "drate57";
    public static final String DRATE58                  = "drate58";
    public static final String DRATE59                  = "drate59";
    public static final String DRATE60                  = "drate60";
    public static final String DRATE61                  = "drate61";
    public static final String DRATE62                  = "drate62";
    public static final String DRATE63                  = "drate63";
    public static final String DRATE64                  = "drate64";
    public static final String DRATE65                  = "drate65";
    public static final String DRATE66                  = "drate66";
    public static final String DRATE67                  = "drate67";
    public static final String DRATE68                  = "drate68";
    public static final String DRATE69                  = "drate69";
    public static final String DRATE70                  = "drate70";
    public static final String DRATE71                  = "drate71";
    public static final String DRATE72                  = "drate72";
    public static final String DRATE73                  = "drate73";
    public static final String DRATE74                  = "drate74";
    public static final String DRATE75                  = "drate75";
    public static final String DRATE76                  = "drate76";
    public static final String DRATE77                  = "drate77";
    public static final String DRATE78                  = "drate78";
    public static final String DRATE79                  = "drate79";
    public static final String DRATE80                  = "drate80";
    public static final String DRATE81                  = "drate81";
    public static final String DRATE82                  = "drate82";
    public static final String DRATE83                  = "drate83";
    public static final String DRATE84                  = "drate84";
    public static final String DRATE85                  = "drate85";
    public static final String DRATE86                  = "drate86";
    public static final String DRATE87                  = "drate87";
    public static final String DRATE88                  = "drate88";
    public static final String DRATE89                  = "drate89";
    public static final String DRATE90                  = "drate90";
    public static final String DRATE91                  = "drate91";
    public static final String DRATE92                  = "drate92";
    public static final String DRATE93                  = "drate93";
    public static final String DRATE94                  = "drate94";
    public static final String DRATE95                  = "drate95";
    public static final String DRATE96                  = "drate96";
    public static final String DRATE97                  = "drate97";
    public static final String DRATE98                  = "drate98";
    public static final String DRATE99                  = "drate99";
    public static final String DYOUVRATE00              = "dyouvrate00";
    public static final String DYOUVRATE01              = "dyouvrate01";
    public static final String DYOUVRATE02              = "dyouvrate02";
    public static final String DYOUVRATE03              = "dyouvrate03";
    public static final String DYOUVRATE04              = "dyouvrate04";
    public static final String DYOUVRATE05              = "dyouvrate05";
    public static final String DYOUVRATE06              = "dyouvrate06";
    public static final String DYOUVRATE07              = "dyouvrate07";
    public static final String DYOUVRATE08              = "dyouvrate08";
    public static final String DYOUVRATE09              = "dyouvrate09";
    public static final String DYOUVRATE10              = "dyouvrate10";
    public static final String DYOUVRATE11              = "dyouvrate11";
    public static final String DYOUVRATE12              = "dyouvrate12";
    public static final String DYOUVRATE13              = "dyouvrate13";
    public static final String DYOUVRATE14              = "dyouvrate14";
    public static final String DYOUVRATE15              = "dyouvrate15";
    public static final String DYOUVRATE16              = "dyouvrate16";
    public static final String DYOUVRATE17              = "dyouvrate17";
    public static final String DYOUVRATE18              = "dyouvrate18";
    public static final String DYOUVRATE19              = "dyouvrate19";
    public static final String DYOUVRATE20              = "dyouvrate20";
    public static final String DYOUVRATE21              = "dyouvrate21";
    public static final String DYOUVRATE22              = "dyouvrate22";
    public static final String DYOUVRATE23              = "dyouvrate23";
    public static final String DYOUVRATE24              = "dyouvrate24";
    public static final String DYOUVRATE25              = "dyouvrate25";
    public static final String DYOUVRATE26              = "dyouvrate26";
    public static final String DYOUVRATE27              = "dyouvrate27";
    public static final String DYOUVRATE28              = "dyouvrate28";
    public static final String DYOUVRATE29              = "dyouvrate29";
    public static final String DYOUVRATE30              = "dyouvrate30";
    public static final String DYOUVRATE31              = "dyouvrate31";
    public static final String DYOUVRATE32              = "dyouvrate32";
    public static final String DYOUVRATE33              = "dyouvrate33";
    public static final String DYOUVRATE34              = "dyouvrate34";
    public static final String DYOUVRATE35              = "dyouvrate35";
    public static final String DYOUVRATE36              = "dyouvrate36";
    public static final String DYOUVRATE37              = "dyouvrate37";
    public static final String DYOUVRATE38              = "dyouvrate38";
    public static final String DYOUVRATE39              = "dyouvrate39";
    public static final String DYOUVRATE40              = "dyouvrate40";
    public static final String DYOUVRATE41              = "dyouvrate41";
    public static final String DYOUVRATE42              = "dyouvrate42";
    public static final String DYOUVRATE43              = "dyouvrate43";
    public static final String DYOUVRATE44              = "dyouvrate44";
    public static final String DYOUVRATE45              = "dyouvrate45";
    public static final String DYOUVRATE46              = "dyouvrate46";
    public static final String DYOUVRATE47              = "dyouvrate47";
    public static final String DYOUVRATE48              = "dyouvrate48";
    public static final String DYOUVRATE49              = "dyouvrate49";
    public static final String DYOUVRATE50              = "dyouvrate50";
    public static final String DYOUVRATE51              = "dyouvrate51";
    public static final String DYOUVRATE52              = "dyouvrate52";
    public static final String DYOUVRATE53              = "dyouvrate53";
    public static final String DYOUVRATE54              = "dyouvrate54";
    public static final String DYOUVRATE55              = "dyouvrate55";
    public static final String DYOUVRATE56              = "dyouvrate56";
    public static final String DYOUVRATE57              = "dyouvrate57";
    public static final String DYOUVRATE58              = "dyouvrate58";
    public static final String DYOUVRATE59              = "dyouvrate59";
    public static final String DYOUVRATE60              = "dyouvrate60";
    public static final String DYOUVRATE61              = "dyouvrate61";
    public static final String DYOUVRATE62              = "dyouvrate62";
    public static final String DYOUVRATE63              = "dyouvrate63";
    public static final String DYOUVRATE64              = "dyouvrate64";
    public static final String DYOUVRATE65              = "dyouvrate65";
    public static final String DYOUVRATE66              = "dyouvrate66";
    public static final String DYOUVRATE67              = "dyouvrate67";
    public static final String DYOUVRATE68              = "dyouvrate68";
    public static final String DYOUVRATE69              = "dyouvrate69";
    public static final String DYOUVRATE70              = "dyouvrate70";
    public static final String DYOUVRATE71              = "dyouvrate71";
    public static final String DYOUVRATE72              = "dyouvrate72";
    public static final String DYOUVRATE73              = "dyouvrate73";
    public static final String DYOUVRATE74              = "dyouvrate74";
    public static final String DYOUVRATE75              = "dyouvrate75";
    public static final String DYOUVRATE76              = "dyouvrate76";
    public static final String DYOUVRATE77              = "dyouvrate77";
    public static final String DYOUVRATE78              = "dyouvrate78";
    public static final String DYOUVRATE79              = "dyouvrate79";
    public static final String DYOUVRATE80              = "dyouvrate80";
    public static final String DYOUVRATE81              = "dyouvrate81";
    public static final String DYOUVRATE82              = "dyouvrate82";
    public static final String DYOUVRATE83              = "dyouvrate83";
    public static final String DYOUVRATE84              = "dyouvrate84";
    public static final String DYOUVRATE85              = "dyouvrate85";
    public static final String DYOUVRATE86              = "dyouvrate86";
    public static final String DYOUVRATE87              = "dyouvrate87";
    public static final String DYOUVRATE88              = "dyouvrate88";
    public static final String DYOUVRATE89              = "dyouvrate89";
    public static final String DYOUVRATE90              = "dyouvrate90";
    public static final String DYOUVRATE91              = "dyouvrate91";
    public static final String DYOUVRATE92              = "dyouvrate92";
    public static final String DYOUVRATE93              = "dyouvrate93";
    public static final String DYOUVRATE94              = "dyouvrate94";
    public static final String DYOUVRATE95              = "dyouvrate95";
    public static final String DYOUVRATE96              = "dyouvrate96";
    public static final String DYOUVRATE97              = "dyouvrate97";
    public static final String DYOUVRATE98              = "dyouvrate98";
    public static final String DYOUVRATE99              = "dyouvrate99";

    private final PKBM_RisaHitSyouhnyouRateD2 primaryKey;

    public GenBM_RisaHitSyouhnyouRateD2() {
        primaryKey = new PKBM_RisaHitSyouhnyouRateD2();
    }

    public GenBM_RisaHitSyouhnyouRateD2(
        String pPalhokensyuruikigou,
        String pPalhokensyuruikigousdicode,
        String pPalyoteiriritu,
        String pPalpmencode,
        String pPalharaikomikaisuu,
        String pPalhhknsei,
        String pPalkeiyakujihhknnen,
        String pPalsaimankihyouji,
        String pPalhokenkikan,
        String pPalpharaikomikikan,
        String pPalannaihuyouriyuukbn,
        String pRatetuukasyukbn,
        String pRatedai1hknkkn,
        String pPaldnendo,
        String pPaldratenaikakucode
    ) {
        primaryKey = new PKBM_RisaHitSyouhnyouRateD2(
            pPalhokensyuruikigou,
            pPalhokensyuruikigousdicode,
            pPalyoteiriritu,
            pPalpmencode,
            pPalharaikomikaisuu,
            pPalhhknsei,
            pPalkeiyakujihhknnen,
            pPalsaimankihyouji,
            pPalhokenkikan,
            pPalpharaikomikikan,
            pPalannaihuyouriyuukbn,
            pRatetuukasyukbn,
            pRatedai1hknkkn,
            pPaldnendo,
            pPaldratenaikakucode
        );
    }

    @Transient
    @Override
    public PKBM_RisaHitSyouhnyouRateD2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_RisaHitSyouhnyouRateD2> getMetaClass() {
        return QBM_RisaHitSyouhnyouRateD2.class;
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALHOKENSYURUIKIGOU)
    public String getPalhokensyuruikigou() {
        return getPrimaryKey().getPalhokensyuruikigou();
    }

    public void setPalhokensyuruikigou(String pPalhokensyuruikigou) {
        getPrimaryKey().setPalhokensyuruikigou(pPalhokensyuruikigou);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALHOKENSYURUIKIGOUSDICODE)
    public String getPalhokensyuruikigousdicode() {
        return getPrimaryKey().getPalhokensyuruikigousdicode();
    }

    public void setPalhokensyuruikigousdicode(String pPalhokensyuruikigousdicode) {
        getPrimaryKey().setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALYOTEIRIRITU)
    public String getPalyoteiriritu() {
        return getPrimaryKey().getPalyoteiriritu();
    }

    public void setPalyoteiriritu(String pPalyoteiriritu) {
        getPrimaryKey().setPalyoteiriritu(pPalyoteiriritu);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALPMENCODE)
    public String getPalpmencode() {
        return getPrimaryKey().getPalpmencode();
    }

    public void setPalpmencode(String pPalpmencode) {
        getPrimaryKey().setPalpmencode(pPalpmencode);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALHARAIKOMIKAISUU)
    public String getPalharaikomikaisuu() {
        return getPrimaryKey().getPalharaikomikaisuu();
    }

    public void setPalharaikomikaisuu(String pPalharaikomikaisuu) {
        getPrimaryKey().setPalharaikomikaisuu(pPalharaikomikaisuu);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALHHKNSEI)
    public String getPalhhknsei() {
        return getPrimaryKey().getPalhhknsei();
    }

    public void setPalhhknsei(String pPalhhknsei) {
        getPrimaryKey().setPalhhknsei(pPalhhknsei);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALKEIYAKUJIHHKNNEN)
    public String getPalkeiyakujihhknnen() {
        return getPrimaryKey().getPalkeiyakujihhknnen();
    }

    public void setPalkeiyakujihhknnen(String pPalkeiyakujihhknnen) {
        getPrimaryKey().setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALSAIMANKIHYOUJI)
    public String getPalsaimankihyouji() {
        return getPrimaryKey().getPalsaimankihyouji();
    }

    public void setPalsaimankihyouji(String pPalsaimankihyouji) {
        getPrimaryKey().setPalsaimankihyouji(pPalsaimankihyouji);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALHOKENKIKAN)
    public String getPalhokenkikan() {
        return getPrimaryKey().getPalhokenkikan();
    }

    public void setPalhokenkikan(String pPalhokenkikan) {
        getPrimaryKey().setPalhokenkikan(pPalhokenkikan);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALPHARAIKOMIKIKAN)
    public String getPalpharaikomikikan() {
        return getPrimaryKey().getPalpharaikomikikan();
    }

    public void setPalpharaikomikikan(String pPalpharaikomikikan) {
        getPrimaryKey().setPalpharaikomikikan(pPalpharaikomikikan);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALANNAIHUYOURIYUUKBN)
    public String getPalannaihuyouriyuukbn() {
        return getPrimaryKey().getPalannaihuyouriyuukbn();
    }

    public void setPalannaihuyouriyuukbn(String pPalannaihuyouriyuukbn) {
        getPrimaryKey().setPalannaihuyouriyuukbn(pPalannaihuyouriyuukbn);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.RATETUUKASYUKBN)
    public String getRatetuukasyukbn() {
        return getPrimaryKey().getRatetuukasyukbn();
    }

    public void setRatetuukasyukbn(String pRatetuukasyukbn) {
        getPrimaryKey().setRatetuukasyukbn(pRatetuukasyukbn);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.RATEDAI1HKNKKN)
    public String getRatedai1hknkkn() {
        return getPrimaryKey().getRatedai1hknkkn();
    }

    public void setRatedai1hknkkn(String pRatedai1hknkkn) {
        getPrimaryKey().setRatedai1hknkkn(pRatedai1hknkkn);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALDNENDO)
    public String getPaldnendo() {
        return getPrimaryKey().getPaldnendo();
    }

    public void setPaldnendo(String pPaldnendo) {
        getPrimaryKey().setPaldnendo(pPaldnendo);
    }

    @Id
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.PALDRATENAIKAKUCODE)
    public String getPaldratenaikakucode() {
        return getPrimaryKey().getPaldratenaikakucode();
    }

    public void setPaldratenaikakucode(String pPaldratenaikakucode) {
        getPrimaryKey().setPaldratenaikakucode(pPaldratenaikakucode);
    }

    private BizNumber drate00;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE00)
    public BizNumber getDrate00() {
        return drate00;
    }

    public void setDrate00(BizNumber pDrate00) {
        drate00 = pDrate00;
    }

    private BizNumber drate01;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE01)
    public BizNumber getDrate01() {
        return drate01;
    }

    public void setDrate01(BizNumber pDrate01) {
        drate01 = pDrate01;
    }

    private BizNumber drate02;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE02)
    public BizNumber getDrate02() {
        return drate02;
    }

    public void setDrate02(BizNumber pDrate02) {
        drate02 = pDrate02;
    }

    private BizNumber drate03;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE03)
    public BizNumber getDrate03() {
        return drate03;
    }

    public void setDrate03(BizNumber pDrate03) {
        drate03 = pDrate03;
    }

    private BizNumber drate04;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE04)
    public BizNumber getDrate04() {
        return drate04;
    }

    public void setDrate04(BizNumber pDrate04) {
        drate04 = pDrate04;
    }

    private BizNumber drate05;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE05)
    public BizNumber getDrate05() {
        return drate05;
    }

    public void setDrate05(BizNumber pDrate05) {
        drate05 = pDrate05;
    }

    private BizNumber drate06;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE06)
    public BizNumber getDrate06() {
        return drate06;
    }

    public void setDrate06(BizNumber pDrate06) {
        drate06 = pDrate06;
    }

    private BizNumber drate07;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE07)
    public BizNumber getDrate07() {
        return drate07;
    }

    public void setDrate07(BizNumber pDrate07) {
        drate07 = pDrate07;
    }

    private BizNumber drate08;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE08)
    public BizNumber getDrate08() {
        return drate08;
    }

    public void setDrate08(BizNumber pDrate08) {
        drate08 = pDrate08;
    }

    private BizNumber drate09;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE09)
    public BizNumber getDrate09() {
        return drate09;
    }

    public void setDrate09(BizNumber pDrate09) {
        drate09 = pDrate09;
    }

    private BizNumber drate10;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE10)
    public BizNumber getDrate10() {
        return drate10;
    }

    public void setDrate10(BizNumber pDrate10) {
        drate10 = pDrate10;
    }

    private BizNumber drate11;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE11)
    public BizNumber getDrate11() {
        return drate11;
    }

    public void setDrate11(BizNumber pDrate11) {
        drate11 = pDrate11;
    }

    private BizNumber drate12;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE12)
    public BizNumber getDrate12() {
        return drate12;
    }

    public void setDrate12(BizNumber pDrate12) {
        drate12 = pDrate12;
    }

    private BizNumber drate13;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE13)
    public BizNumber getDrate13() {
        return drate13;
    }

    public void setDrate13(BizNumber pDrate13) {
        drate13 = pDrate13;
    }

    private BizNumber drate14;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE14)
    public BizNumber getDrate14() {
        return drate14;
    }

    public void setDrate14(BizNumber pDrate14) {
        drate14 = pDrate14;
    }

    private BizNumber drate15;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE15)
    public BizNumber getDrate15() {
        return drate15;
    }

    public void setDrate15(BizNumber pDrate15) {
        drate15 = pDrate15;
    }

    private BizNumber drate16;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE16)
    public BizNumber getDrate16() {
        return drate16;
    }

    public void setDrate16(BizNumber pDrate16) {
        drate16 = pDrate16;
    }

    private BizNumber drate17;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE17)
    public BizNumber getDrate17() {
        return drate17;
    }

    public void setDrate17(BizNumber pDrate17) {
        drate17 = pDrate17;
    }

    private BizNumber drate18;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE18)
    public BizNumber getDrate18() {
        return drate18;
    }

    public void setDrate18(BizNumber pDrate18) {
        drate18 = pDrate18;
    }

    private BizNumber drate19;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE19)
    public BizNumber getDrate19() {
        return drate19;
    }

    public void setDrate19(BizNumber pDrate19) {
        drate19 = pDrate19;
    }

    private BizNumber drate20;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE20)
    public BizNumber getDrate20() {
        return drate20;
    }

    public void setDrate20(BizNumber pDrate20) {
        drate20 = pDrate20;
    }

    private BizNumber drate21;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE21)
    public BizNumber getDrate21() {
        return drate21;
    }

    public void setDrate21(BizNumber pDrate21) {
        drate21 = pDrate21;
    }

    private BizNumber drate22;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE22)
    public BizNumber getDrate22() {
        return drate22;
    }

    public void setDrate22(BizNumber pDrate22) {
        drate22 = pDrate22;
    }

    private BizNumber drate23;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE23)
    public BizNumber getDrate23() {
        return drate23;
    }

    public void setDrate23(BizNumber pDrate23) {
        drate23 = pDrate23;
    }

    private BizNumber drate24;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE24)
    public BizNumber getDrate24() {
        return drate24;
    }

    public void setDrate24(BizNumber pDrate24) {
        drate24 = pDrate24;
    }

    private BizNumber drate25;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE25)
    public BizNumber getDrate25() {
        return drate25;
    }

    public void setDrate25(BizNumber pDrate25) {
        drate25 = pDrate25;
    }

    private BizNumber drate26;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE26)
    public BizNumber getDrate26() {
        return drate26;
    }

    public void setDrate26(BizNumber pDrate26) {
        drate26 = pDrate26;
    }

    private BizNumber drate27;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE27)
    public BizNumber getDrate27() {
        return drate27;
    }

    public void setDrate27(BizNumber pDrate27) {
        drate27 = pDrate27;
    }

    private BizNumber drate28;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE28)
    public BizNumber getDrate28() {
        return drate28;
    }

    public void setDrate28(BizNumber pDrate28) {
        drate28 = pDrate28;
    }

    private BizNumber drate29;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE29)
    public BizNumber getDrate29() {
        return drate29;
    }

    public void setDrate29(BizNumber pDrate29) {
        drate29 = pDrate29;
    }

    private BizNumber drate30;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE30)
    public BizNumber getDrate30() {
        return drate30;
    }

    public void setDrate30(BizNumber pDrate30) {
        drate30 = pDrate30;
    }

    private BizNumber drate31;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE31)
    public BizNumber getDrate31() {
        return drate31;
    }

    public void setDrate31(BizNumber pDrate31) {
        drate31 = pDrate31;
    }

    private BizNumber drate32;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE32)
    public BizNumber getDrate32() {
        return drate32;
    }

    public void setDrate32(BizNumber pDrate32) {
        drate32 = pDrate32;
    }

    private BizNumber drate33;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE33)
    public BizNumber getDrate33() {
        return drate33;
    }

    public void setDrate33(BizNumber pDrate33) {
        drate33 = pDrate33;
    }

    private BizNumber drate34;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE34)
    public BizNumber getDrate34() {
        return drate34;
    }

    public void setDrate34(BizNumber pDrate34) {
        drate34 = pDrate34;
    }

    private BizNumber drate35;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE35)
    public BizNumber getDrate35() {
        return drate35;
    }

    public void setDrate35(BizNumber pDrate35) {
        drate35 = pDrate35;
    }

    private BizNumber drate36;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE36)
    public BizNumber getDrate36() {
        return drate36;
    }

    public void setDrate36(BizNumber pDrate36) {
        drate36 = pDrate36;
    }

    private BizNumber drate37;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE37)
    public BizNumber getDrate37() {
        return drate37;
    }

    public void setDrate37(BizNumber pDrate37) {
        drate37 = pDrate37;
    }

    private BizNumber drate38;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE38)
    public BizNumber getDrate38() {
        return drate38;
    }

    public void setDrate38(BizNumber pDrate38) {
        drate38 = pDrate38;
    }

    private BizNumber drate39;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE39)
    public BizNumber getDrate39() {
        return drate39;
    }

    public void setDrate39(BizNumber pDrate39) {
        drate39 = pDrate39;
    }

    private BizNumber drate40;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE40)
    public BizNumber getDrate40() {
        return drate40;
    }

    public void setDrate40(BizNumber pDrate40) {
        drate40 = pDrate40;
    }

    private BizNumber drate41;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE41)
    public BizNumber getDrate41() {
        return drate41;
    }

    public void setDrate41(BizNumber pDrate41) {
        drate41 = pDrate41;
    }

    private BizNumber drate42;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE42)
    public BizNumber getDrate42() {
        return drate42;
    }

    public void setDrate42(BizNumber pDrate42) {
        drate42 = pDrate42;
    }

    private BizNumber drate43;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE43)
    public BizNumber getDrate43() {
        return drate43;
    }

    public void setDrate43(BizNumber pDrate43) {
        drate43 = pDrate43;
    }

    private BizNumber drate44;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE44)
    public BizNumber getDrate44() {
        return drate44;
    }

    public void setDrate44(BizNumber pDrate44) {
        drate44 = pDrate44;
    }

    private BizNumber drate45;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE45)
    public BizNumber getDrate45() {
        return drate45;
    }

    public void setDrate45(BizNumber pDrate45) {
        drate45 = pDrate45;
    }

    private BizNumber drate46;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE46)
    public BizNumber getDrate46() {
        return drate46;
    }

    public void setDrate46(BizNumber pDrate46) {
        drate46 = pDrate46;
    }

    private BizNumber drate47;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE47)
    public BizNumber getDrate47() {
        return drate47;
    }

    public void setDrate47(BizNumber pDrate47) {
        drate47 = pDrate47;
    }

    private BizNumber drate48;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE48)
    public BizNumber getDrate48() {
        return drate48;
    }

    public void setDrate48(BizNumber pDrate48) {
        drate48 = pDrate48;
    }

    private BizNumber drate49;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE49)
    public BizNumber getDrate49() {
        return drate49;
    }

    public void setDrate49(BizNumber pDrate49) {
        drate49 = pDrate49;
    }

    private BizNumber drate50;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE50)
    public BizNumber getDrate50() {
        return drate50;
    }

    public void setDrate50(BizNumber pDrate50) {
        drate50 = pDrate50;
    }

    private BizNumber drate51;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE51)
    public BizNumber getDrate51() {
        return drate51;
    }

    public void setDrate51(BizNumber pDrate51) {
        drate51 = pDrate51;
    }

    private BizNumber drate52;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE52)
    public BizNumber getDrate52() {
        return drate52;
    }

    public void setDrate52(BizNumber pDrate52) {
        drate52 = pDrate52;
    }

    private BizNumber drate53;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE53)
    public BizNumber getDrate53() {
        return drate53;
    }

    public void setDrate53(BizNumber pDrate53) {
        drate53 = pDrate53;
    }

    private BizNumber drate54;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE54)
    public BizNumber getDrate54() {
        return drate54;
    }

    public void setDrate54(BizNumber pDrate54) {
        drate54 = pDrate54;
    }

    private BizNumber drate55;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE55)
    public BizNumber getDrate55() {
        return drate55;
    }

    public void setDrate55(BizNumber pDrate55) {
        drate55 = pDrate55;
    }

    private BizNumber drate56;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE56)
    public BizNumber getDrate56() {
        return drate56;
    }

    public void setDrate56(BizNumber pDrate56) {
        drate56 = pDrate56;
    }

    private BizNumber drate57;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE57)
    public BizNumber getDrate57() {
        return drate57;
    }

    public void setDrate57(BizNumber pDrate57) {
        drate57 = pDrate57;
    }

    private BizNumber drate58;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE58)
    public BizNumber getDrate58() {
        return drate58;
    }

    public void setDrate58(BizNumber pDrate58) {
        drate58 = pDrate58;
    }

    private BizNumber drate59;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE59)
    public BizNumber getDrate59() {
        return drate59;
    }

    public void setDrate59(BizNumber pDrate59) {
        drate59 = pDrate59;
    }

    private BizNumber drate60;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE60)
    public BizNumber getDrate60() {
        return drate60;
    }

    public void setDrate60(BizNumber pDrate60) {
        drate60 = pDrate60;
    }

    private BizNumber drate61;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE61)
    public BizNumber getDrate61() {
        return drate61;
    }

    public void setDrate61(BizNumber pDrate61) {
        drate61 = pDrate61;
    }

    private BizNumber drate62;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE62)
    public BizNumber getDrate62() {
        return drate62;
    }

    public void setDrate62(BizNumber pDrate62) {
        drate62 = pDrate62;
    }

    private BizNumber drate63;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE63)
    public BizNumber getDrate63() {
        return drate63;
    }

    public void setDrate63(BizNumber pDrate63) {
        drate63 = pDrate63;
    }

    private BizNumber drate64;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE64)
    public BizNumber getDrate64() {
        return drate64;
    }

    public void setDrate64(BizNumber pDrate64) {
        drate64 = pDrate64;
    }

    private BizNumber drate65;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE65)
    public BizNumber getDrate65() {
        return drate65;
    }

    public void setDrate65(BizNumber pDrate65) {
        drate65 = pDrate65;
    }

    private BizNumber drate66;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE66)
    public BizNumber getDrate66() {
        return drate66;
    }

    public void setDrate66(BizNumber pDrate66) {
        drate66 = pDrate66;
    }

    private BizNumber drate67;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE67)
    public BizNumber getDrate67() {
        return drate67;
    }

    public void setDrate67(BizNumber pDrate67) {
        drate67 = pDrate67;
    }

    private BizNumber drate68;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE68)
    public BizNumber getDrate68() {
        return drate68;
    }

    public void setDrate68(BizNumber pDrate68) {
        drate68 = pDrate68;
    }

    private BizNumber drate69;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE69)
    public BizNumber getDrate69() {
        return drate69;
    }

    public void setDrate69(BizNumber pDrate69) {
        drate69 = pDrate69;
    }

    private BizNumber drate70;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE70)
    public BizNumber getDrate70() {
        return drate70;
    }

    public void setDrate70(BizNumber pDrate70) {
        drate70 = pDrate70;
    }

    private BizNumber drate71;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE71)
    public BizNumber getDrate71() {
        return drate71;
    }

    public void setDrate71(BizNumber pDrate71) {
        drate71 = pDrate71;
    }

    private BizNumber drate72;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE72)
    public BizNumber getDrate72() {
        return drate72;
    }

    public void setDrate72(BizNumber pDrate72) {
        drate72 = pDrate72;
    }

    private BizNumber drate73;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE73)
    public BizNumber getDrate73() {
        return drate73;
    }

    public void setDrate73(BizNumber pDrate73) {
        drate73 = pDrate73;
    }

    private BizNumber drate74;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE74)
    public BizNumber getDrate74() {
        return drate74;
    }

    public void setDrate74(BizNumber pDrate74) {
        drate74 = pDrate74;
    }

    private BizNumber drate75;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE75)
    public BizNumber getDrate75() {
        return drate75;
    }

    public void setDrate75(BizNumber pDrate75) {
        drate75 = pDrate75;
    }

    private BizNumber drate76;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE76)
    public BizNumber getDrate76() {
        return drate76;
    }

    public void setDrate76(BizNumber pDrate76) {
        drate76 = pDrate76;
    }

    private BizNumber drate77;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE77)
    public BizNumber getDrate77() {
        return drate77;
    }

    public void setDrate77(BizNumber pDrate77) {
        drate77 = pDrate77;
    }

    private BizNumber drate78;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE78)
    public BizNumber getDrate78() {
        return drate78;
    }

    public void setDrate78(BizNumber pDrate78) {
        drate78 = pDrate78;
    }

    private BizNumber drate79;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE79)
    public BizNumber getDrate79() {
        return drate79;
    }

    public void setDrate79(BizNumber pDrate79) {
        drate79 = pDrate79;
    }

    private BizNumber drate80;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE80)
    public BizNumber getDrate80() {
        return drate80;
    }

    public void setDrate80(BizNumber pDrate80) {
        drate80 = pDrate80;
    }

    private BizNumber drate81;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE81)
    public BizNumber getDrate81() {
        return drate81;
    }

    public void setDrate81(BizNumber pDrate81) {
        drate81 = pDrate81;
    }

    private BizNumber drate82;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE82)
    public BizNumber getDrate82() {
        return drate82;
    }

    public void setDrate82(BizNumber pDrate82) {
        drate82 = pDrate82;
    }

    private BizNumber drate83;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE83)
    public BizNumber getDrate83() {
        return drate83;
    }

    public void setDrate83(BizNumber pDrate83) {
        drate83 = pDrate83;
    }

    private BizNumber drate84;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE84)
    public BizNumber getDrate84() {
        return drate84;
    }

    public void setDrate84(BizNumber pDrate84) {
        drate84 = pDrate84;
    }

    private BizNumber drate85;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE85)
    public BizNumber getDrate85() {
        return drate85;
    }

    public void setDrate85(BizNumber pDrate85) {
        drate85 = pDrate85;
    }

    private BizNumber drate86;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE86)
    public BizNumber getDrate86() {
        return drate86;
    }

    public void setDrate86(BizNumber pDrate86) {
        drate86 = pDrate86;
    }

    private BizNumber drate87;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE87)
    public BizNumber getDrate87() {
        return drate87;
    }

    public void setDrate87(BizNumber pDrate87) {
        drate87 = pDrate87;
    }

    private BizNumber drate88;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE88)
    public BizNumber getDrate88() {
        return drate88;
    }

    public void setDrate88(BizNumber pDrate88) {
        drate88 = pDrate88;
    }

    private BizNumber drate89;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE89)
    public BizNumber getDrate89() {
        return drate89;
    }

    public void setDrate89(BizNumber pDrate89) {
        drate89 = pDrate89;
    }

    private BizNumber drate90;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE90)
    public BizNumber getDrate90() {
        return drate90;
    }

    public void setDrate90(BizNumber pDrate90) {
        drate90 = pDrate90;
    }

    private BizNumber drate91;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE91)
    public BizNumber getDrate91() {
        return drate91;
    }

    public void setDrate91(BizNumber pDrate91) {
        drate91 = pDrate91;
    }

    private BizNumber drate92;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE92)
    public BizNumber getDrate92() {
        return drate92;
    }

    public void setDrate92(BizNumber pDrate92) {
        drate92 = pDrate92;
    }

    private BizNumber drate93;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE93)
    public BizNumber getDrate93() {
        return drate93;
    }

    public void setDrate93(BizNumber pDrate93) {
        drate93 = pDrate93;
    }

    private BizNumber drate94;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE94)
    public BizNumber getDrate94() {
        return drate94;
    }

    public void setDrate94(BizNumber pDrate94) {
        drate94 = pDrate94;
    }

    private BizNumber drate95;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE95)
    public BizNumber getDrate95() {
        return drate95;
    }

    public void setDrate95(BizNumber pDrate95) {
        drate95 = pDrate95;
    }

    private BizNumber drate96;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE96)
    public BizNumber getDrate96() {
        return drate96;
    }

    public void setDrate96(BizNumber pDrate96) {
        drate96 = pDrate96;
    }

    private BizNumber drate97;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE97)
    public BizNumber getDrate97() {
        return drate97;
    }

    public void setDrate97(BizNumber pDrate97) {
        drate97 = pDrate97;
    }

    private BizNumber drate98;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE98)
    public BizNumber getDrate98() {
        return drate98;
    }

    public void setDrate98(BizNumber pDrate98) {
        drate98 = pDrate98;
    }

    private BizNumber drate99;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DRATE99)
    public BizNumber getDrate99() {
        return drate99;
    }

    public void setDrate99(BizNumber pDrate99) {
        drate99 = pDrate99;
    }

    private BizNumber dyouvrate00;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE00)
    public BizNumber getDyouvrate00() {
        return dyouvrate00;
    }

    public void setDyouvrate00(BizNumber pDyouvrate00) {
        dyouvrate00 = pDyouvrate00;
    }

    private BizNumber dyouvrate01;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE01)
    public BizNumber getDyouvrate01() {
        return dyouvrate01;
    }

    public void setDyouvrate01(BizNumber pDyouvrate01) {
        dyouvrate01 = pDyouvrate01;
    }

    private BizNumber dyouvrate02;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE02)
    public BizNumber getDyouvrate02() {
        return dyouvrate02;
    }

    public void setDyouvrate02(BizNumber pDyouvrate02) {
        dyouvrate02 = pDyouvrate02;
    }

    private BizNumber dyouvrate03;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE03)
    public BizNumber getDyouvrate03() {
        return dyouvrate03;
    }

    public void setDyouvrate03(BizNumber pDyouvrate03) {
        dyouvrate03 = pDyouvrate03;
    }

    private BizNumber dyouvrate04;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE04)
    public BizNumber getDyouvrate04() {
        return dyouvrate04;
    }

    public void setDyouvrate04(BizNumber pDyouvrate04) {
        dyouvrate04 = pDyouvrate04;
    }

    private BizNumber dyouvrate05;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE05)
    public BizNumber getDyouvrate05() {
        return dyouvrate05;
    }

    public void setDyouvrate05(BizNumber pDyouvrate05) {
        dyouvrate05 = pDyouvrate05;
    }

    private BizNumber dyouvrate06;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE06)
    public BizNumber getDyouvrate06() {
        return dyouvrate06;
    }

    public void setDyouvrate06(BizNumber pDyouvrate06) {
        dyouvrate06 = pDyouvrate06;
    }

    private BizNumber dyouvrate07;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE07)
    public BizNumber getDyouvrate07() {
        return dyouvrate07;
    }

    public void setDyouvrate07(BizNumber pDyouvrate07) {
        dyouvrate07 = pDyouvrate07;
    }

    private BizNumber dyouvrate08;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE08)
    public BizNumber getDyouvrate08() {
        return dyouvrate08;
    }

    public void setDyouvrate08(BizNumber pDyouvrate08) {
        dyouvrate08 = pDyouvrate08;
    }

    private BizNumber dyouvrate09;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE09)
    public BizNumber getDyouvrate09() {
        return dyouvrate09;
    }

    public void setDyouvrate09(BizNumber pDyouvrate09) {
        dyouvrate09 = pDyouvrate09;
    }

    private BizNumber dyouvrate10;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE10)
    public BizNumber getDyouvrate10() {
        return dyouvrate10;
    }

    public void setDyouvrate10(BizNumber pDyouvrate10) {
        dyouvrate10 = pDyouvrate10;
    }

    private BizNumber dyouvrate11;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE11)
    public BizNumber getDyouvrate11() {
        return dyouvrate11;
    }

    public void setDyouvrate11(BizNumber pDyouvrate11) {
        dyouvrate11 = pDyouvrate11;
    }

    private BizNumber dyouvrate12;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE12)
    public BizNumber getDyouvrate12() {
        return dyouvrate12;
    }

    public void setDyouvrate12(BizNumber pDyouvrate12) {
        dyouvrate12 = pDyouvrate12;
    }

    private BizNumber dyouvrate13;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE13)
    public BizNumber getDyouvrate13() {
        return dyouvrate13;
    }

    public void setDyouvrate13(BizNumber pDyouvrate13) {
        dyouvrate13 = pDyouvrate13;
    }

    private BizNumber dyouvrate14;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE14)
    public BizNumber getDyouvrate14() {
        return dyouvrate14;
    }

    public void setDyouvrate14(BizNumber pDyouvrate14) {
        dyouvrate14 = pDyouvrate14;
    }

    private BizNumber dyouvrate15;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE15)
    public BizNumber getDyouvrate15() {
        return dyouvrate15;
    }

    public void setDyouvrate15(BizNumber pDyouvrate15) {
        dyouvrate15 = pDyouvrate15;
    }

    private BizNumber dyouvrate16;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE16)
    public BizNumber getDyouvrate16() {
        return dyouvrate16;
    }

    public void setDyouvrate16(BizNumber pDyouvrate16) {
        dyouvrate16 = pDyouvrate16;
    }

    private BizNumber dyouvrate17;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE17)
    public BizNumber getDyouvrate17() {
        return dyouvrate17;
    }

    public void setDyouvrate17(BizNumber pDyouvrate17) {
        dyouvrate17 = pDyouvrate17;
    }

    private BizNumber dyouvrate18;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE18)
    public BizNumber getDyouvrate18() {
        return dyouvrate18;
    }

    public void setDyouvrate18(BizNumber pDyouvrate18) {
        dyouvrate18 = pDyouvrate18;
    }

    private BizNumber dyouvrate19;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE19)
    public BizNumber getDyouvrate19() {
        return dyouvrate19;
    }

    public void setDyouvrate19(BizNumber pDyouvrate19) {
        dyouvrate19 = pDyouvrate19;
    }

    private BizNumber dyouvrate20;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE20)
    public BizNumber getDyouvrate20() {
        return dyouvrate20;
    }

    public void setDyouvrate20(BizNumber pDyouvrate20) {
        dyouvrate20 = pDyouvrate20;
    }

    private BizNumber dyouvrate21;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE21)
    public BizNumber getDyouvrate21() {
        return dyouvrate21;
    }

    public void setDyouvrate21(BizNumber pDyouvrate21) {
        dyouvrate21 = pDyouvrate21;
    }

    private BizNumber dyouvrate22;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE22)
    public BizNumber getDyouvrate22() {
        return dyouvrate22;
    }

    public void setDyouvrate22(BizNumber pDyouvrate22) {
        dyouvrate22 = pDyouvrate22;
    }

    private BizNumber dyouvrate23;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE23)
    public BizNumber getDyouvrate23() {
        return dyouvrate23;
    }

    public void setDyouvrate23(BizNumber pDyouvrate23) {
        dyouvrate23 = pDyouvrate23;
    }

    private BizNumber dyouvrate24;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE24)
    public BizNumber getDyouvrate24() {
        return dyouvrate24;
    }

    public void setDyouvrate24(BizNumber pDyouvrate24) {
        dyouvrate24 = pDyouvrate24;
    }

    private BizNumber dyouvrate25;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE25)
    public BizNumber getDyouvrate25() {
        return dyouvrate25;
    }

    public void setDyouvrate25(BizNumber pDyouvrate25) {
        dyouvrate25 = pDyouvrate25;
    }

    private BizNumber dyouvrate26;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE26)
    public BizNumber getDyouvrate26() {
        return dyouvrate26;
    }

    public void setDyouvrate26(BizNumber pDyouvrate26) {
        dyouvrate26 = pDyouvrate26;
    }

    private BizNumber dyouvrate27;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE27)
    public BizNumber getDyouvrate27() {
        return dyouvrate27;
    }

    public void setDyouvrate27(BizNumber pDyouvrate27) {
        dyouvrate27 = pDyouvrate27;
    }

    private BizNumber dyouvrate28;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE28)
    public BizNumber getDyouvrate28() {
        return dyouvrate28;
    }

    public void setDyouvrate28(BizNumber pDyouvrate28) {
        dyouvrate28 = pDyouvrate28;
    }

    private BizNumber dyouvrate29;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE29)
    public BizNumber getDyouvrate29() {
        return dyouvrate29;
    }

    public void setDyouvrate29(BizNumber pDyouvrate29) {
        dyouvrate29 = pDyouvrate29;
    }

    private BizNumber dyouvrate30;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE30)
    public BizNumber getDyouvrate30() {
        return dyouvrate30;
    }

    public void setDyouvrate30(BizNumber pDyouvrate30) {
        dyouvrate30 = pDyouvrate30;
    }

    private BizNumber dyouvrate31;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE31)
    public BizNumber getDyouvrate31() {
        return dyouvrate31;
    }

    public void setDyouvrate31(BizNumber pDyouvrate31) {
        dyouvrate31 = pDyouvrate31;
    }

    private BizNumber dyouvrate32;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE32)
    public BizNumber getDyouvrate32() {
        return dyouvrate32;
    }

    public void setDyouvrate32(BizNumber pDyouvrate32) {
        dyouvrate32 = pDyouvrate32;
    }

    private BizNumber dyouvrate33;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE33)
    public BizNumber getDyouvrate33() {
        return dyouvrate33;
    }

    public void setDyouvrate33(BizNumber pDyouvrate33) {
        dyouvrate33 = pDyouvrate33;
    }

    private BizNumber dyouvrate34;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE34)
    public BizNumber getDyouvrate34() {
        return dyouvrate34;
    }

    public void setDyouvrate34(BizNumber pDyouvrate34) {
        dyouvrate34 = pDyouvrate34;
    }

    private BizNumber dyouvrate35;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE35)
    public BizNumber getDyouvrate35() {
        return dyouvrate35;
    }

    public void setDyouvrate35(BizNumber pDyouvrate35) {
        dyouvrate35 = pDyouvrate35;
    }

    private BizNumber dyouvrate36;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE36)
    public BizNumber getDyouvrate36() {
        return dyouvrate36;
    }

    public void setDyouvrate36(BizNumber pDyouvrate36) {
        dyouvrate36 = pDyouvrate36;
    }

    private BizNumber dyouvrate37;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE37)
    public BizNumber getDyouvrate37() {
        return dyouvrate37;
    }

    public void setDyouvrate37(BizNumber pDyouvrate37) {
        dyouvrate37 = pDyouvrate37;
    }

    private BizNumber dyouvrate38;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE38)
    public BizNumber getDyouvrate38() {
        return dyouvrate38;
    }

    public void setDyouvrate38(BizNumber pDyouvrate38) {
        dyouvrate38 = pDyouvrate38;
    }

    private BizNumber dyouvrate39;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE39)
    public BizNumber getDyouvrate39() {
        return dyouvrate39;
    }

    public void setDyouvrate39(BizNumber pDyouvrate39) {
        dyouvrate39 = pDyouvrate39;
    }

    private BizNumber dyouvrate40;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE40)
    public BizNumber getDyouvrate40() {
        return dyouvrate40;
    }

    public void setDyouvrate40(BizNumber pDyouvrate40) {
        dyouvrate40 = pDyouvrate40;
    }

    private BizNumber dyouvrate41;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE41)
    public BizNumber getDyouvrate41() {
        return dyouvrate41;
    }

    public void setDyouvrate41(BizNumber pDyouvrate41) {
        dyouvrate41 = pDyouvrate41;
    }

    private BizNumber dyouvrate42;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE42)
    public BizNumber getDyouvrate42() {
        return dyouvrate42;
    }

    public void setDyouvrate42(BizNumber pDyouvrate42) {
        dyouvrate42 = pDyouvrate42;
    }

    private BizNumber dyouvrate43;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE43)
    public BizNumber getDyouvrate43() {
        return dyouvrate43;
    }

    public void setDyouvrate43(BizNumber pDyouvrate43) {
        dyouvrate43 = pDyouvrate43;
    }

    private BizNumber dyouvrate44;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE44)
    public BizNumber getDyouvrate44() {
        return dyouvrate44;
    }

    public void setDyouvrate44(BizNumber pDyouvrate44) {
        dyouvrate44 = pDyouvrate44;
    }

    private BizNumber dyouvrate45;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE45)
    public BizNumber getDyouvrate45() {
        return dyouvrate45;
    }

    public void setDyouvrate45(BizNumber pDyouvrate45) {
        dyouvrate45 = pDyouvrate45;
    }

    private BizNumber dyouvrate46;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE46)
    public BizNumber getDyouvrate46() {
        return dyouvrate46;
    }

    public void setDyouvrate46(BizNumber pDyouvrate46) {
        dyouvrate46 = pDyouvrate46;
    }

    private BizNumber dyouvrate47;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE47)
    public BizNumber getDyouvrate47() {
        return dyouvrate47;
    }

    public void setDyouvrate47(BizNumber pDyouvrate47) {
        dyouvrate47 = pDyouvrate47;
    }

    private BizNumber dyouvrate48;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE48)
    public BizNumber getDyouvrate48() {
        return dyouvrate48;
    }

    public void setDyouvrate48(BizNumber pDyouvrate48) {
        dyouvrate48 = pDyouvrate48;
    }

    private BizNumber dyouvrate49;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE49)
    public BizNumber getDyouvrate49() {
        return dyouvrate49;
    }

    public void setDyouvrate49(BizNumber pDyouvrate49) {
        dyouvrate49 = pDyouvrate49;
    }

    private BizNumber dyouvrate50;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE50)
    public BizNumber getDyouvrate50() {
        return dyouvrate50;
    }

    public void setDyouvrate50(BizNumber pDyouvrate50) {
        dyouvrate50 = pDyouvrate50;
    }

    private BizNumber dyouvrate51;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE51)
    public BizNumber getDyouvrate51() {
        return dyouvrate51;
    }

    public void setDyouvrate51(BizNumber pDyouvrate51) {
        dyouvrate51 = pDyouvrate51;
    }

    private BizNumber dyouvrate52;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE52)
    public BizNumber getDyouvrate52() {
        return dyouvrate52;
    }

    public void setDyouvrate52(BizNumber pDyouvrate52) {
        dyouvrate52 = pDyouvrate52;
    }

    private BizNumber dyouvrate53;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE53)
    public BizNumber getDyouvrate53() {
        return dyouvrate53;
    }

    public void setDyouvrate53(BizNumber pDyouvrate53) {
        dyouvrate53 = pDyouvrate53;
    }

    private BizNumber dyouvrate54;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE54)
    public BizNumber getDyouvrate54() {
        return dyouvrate54;
    }

    public void setDyouvrate54(BizNumber pDyouvrate54) {
        dyouvrate54 = pDyouvrate54;
    }

    private BizNumber dyouvrate55;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE55)
    public BizNumber getDyouvrate55() {
        return dyouvrate55;
    }

    public void setDyouvrate55(BizNumber pDyouvrate55) {
        dyouvrate55 = pDyouvrate55;
    }

    private BizNumber dyouvrate56;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE56)
    public BizNumber getDyouvrate56() {
        return dyouvrate56;
    }

    public void setDyouvrate56(BizNumber pDyouvrate56) {
        dyouvrate56 = pDyouvrate56;
    }

    private BizNumber dyouvrate57;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE57)
    public BizNumber getDyouvrate57() {
        return dyouvrate57;
    }

    public void setDyouvrate57(BizNumber pDyouvrate57) {
        dyouvrate57 = pDyouvrate57;
    }

    private BizNumber dyouvrate58;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE58)
    public BizNumber getDyouvrate58() {
        return dyouvrate58;
    }

    public void setDyouvrate58(BizNumber pDyouvrate58) {
        dyouvrate58 = pDyouvrate58;
    }

    private BizNumber dyouvrate59;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE59)
    public BizNumber getDyouvrate59() {
        return dyouvrate59;
    }

    public void setDyouvrate59(BizNumber pDyouvrate59) {
        dyouvrate59 = pDyouvrate59;
    }

    private BizNumber dyouvrate60;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE60)
    public BizNumber getDyouvrate60() {
        return dyouvrate60;
    }

    public void setDyouvrate60(BizNumber pDyouvrate60) {
        dyouvrate60 = pDyouvrate60;
    }

    private BizNumber dyouvrate61;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE61)
    public BizNumber getDyouvrate61() {
        return dyouvrate61;
    }

    public void setDyouvrate61(BizNumber pDyouvrate61) {
        dyouvrate61 = pDyouvrate61;
    }

    private BizNumber dyouvrate62;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE62)
    public BizNumber getDyouvrate62() {
        return dyouvrate62;
    }

    public void setDyouvrate62(BizNumber pDyouvrate62) {
        dyouvrate62 = pDyouvrate62;
    }

    private BizNumber dyouvrate63;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE63)
    public BizNumber getDyouvrate63() {
        return dyouvrate63;
    }

    public void setDyouvrate63(BizNumber pDyouvrate63) {
        dyouvrate63 = pDyouvrate63;
    }

    private BizNumber dyouvrate64;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE64)
    public BizNumber getDyouvrate64() {
        return dyouvrate64;
    }

    public void setDyouvrate64(BizNumber pDyouvrate64) {
        dyouvrate64 = pDyouvrate64;
    }

    private BizNumber dyouvrate65;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE65)
    public BizNumber getDyouvrate65() {
        return dyouvrate65;
    }

    public void setDyouvrate65(BizNumber pDyouvrate65) {
        dyouvrate65 = pDyouvrate65;
    }

    private BizNumber dyouvrate66;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE66)
    public BizNumber getDyouvrate66() {
        return dyouvrate66;
    }

    public void setDyouvrate66(BizNumber pDyouvrate66) {
        dyouvrate66 = pDyouvrate66;
    }

    private BizNumber dyouvrate67;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE67)
    public BizNumber getDyouvrate67() {
        return dyouvrate67;
    }

    public void setDyouvrate67(BizNumber pDyouvrate67) {
        dyouvrate67 = pDyouvrate67;
    }

    private BizNumber dyouvrate68;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE68)
    public BizNumber getDyouvrate68() {
        return dyouvrate68;
    }

    public void setDyouvrate68(BizNumber pDyouvrate68) {
        dyouvrate68 = pDyouvrate68;
    }

    private BizNumber dyouvrate69;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE69)
    public BizNumber getDyouvrate69() {
        return dyouvrate69;
    }

    public void setDyouvrate69(BizNumber pDyouvrate69) {
        dyouvrate69 = pDyouvrate69;
    }

    private BizNumber dyouvrate70;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE70)
    public BizNumber getDyouvrate70() {
        return dyouvrate70;
    }

    public void setDyouvrate70(BizNumber pDyouvrate70) {
        dyouvrate70 = pDyouvrate70;
    }

    private BizNumber dyouvrate71;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE71)
    public BizNumber getDyouvrate71() {
        return dyouvrate71;
    }

    public void setDyouvrate71(BizNumber pDyouvrate71) {
        dyouvrate71 = pDyouvrate71;
    }

    private BizNumber dyouvrate72;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE72)
    public BizNumber getDyouvrate72() {
        return dyouvrate72;
    }

    public void setDyouvrate72(BizNumber pDyouvrate72) {
        dyouvrate72 = pDyouvrate72;
    }

    private BizNumber dyouvrate73;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE73)
    public BizNumber getDyouvrate73() {
        return dyouvrate73;
    }

    public void setDyouvrate73(BizNumber pDyouvrate73) {
        dyouvrate73 = pDyouvrate73;
    }

    private BizNumber dyouvrate74;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE74)
    public BizNumber getDyouvrate74() {
        return dyouvrate74;
    }

    public void setDyouvrate74(BizNumber pDyouvrate74) {
        dyouvrate74 = pDyouvrate74;
    }

    private BizNumber dyouvrate75;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE75)
    public BizNumber getDyouvrate75() {
        return dyouvrate75;
    }

    public void setDyouvrate75(BizNumber pDyouvrate75) {
        dyouvrate75 = pDyouvrate75;
    }

    private BizNumber dyouvrate76;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE76)
    public BizNumber getDyouvrate76() {
        return dyouvrate76;
    }

    public void setDyouvrate76(BizNumber pDyouvrate76) {
        dyouvrate76 = pDyouvrate76;
    }

    private BizNumber dyouvrate77;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE77)
    public BizNumber getDyouvrate77() {
        return dyouvrate77;
    }

    public void setDyouvrate77(BizNumber pDyouvrate77) {
        dyouvrate77 = pDyouvrate77;
    }

    private BizNumber dyouvrate78;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE78)
    public BizNumber getDyouvrate78() {
        return dyouvrate78;
    }

    public void setDyouvrate78(BizNumber pDyouvrate78) {
        dyouvrate78 = pDyouvrate78;
    }

    private BizNumber dyouvrate79;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE79)
    public BizNumber getDyouvrate79() {
        return dyouvrate79;
    }

    public void setDyouvrate79(BizNumber pDyouvrate79) {
        dyouvrate79 = pDyouvrate79;
    }

    private BizNumber dyouvrate80;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE80)
    public BizNumber getDyouvrate80() {
        return dyouvrate80;
    }

    public void setDyouvrate80(BizNumber pDyouvrate80) {
        dyouvrate80 = pDyouvrate80;
    }

    private BizNumber dyouvrate81;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE81)
    public BizNumber getDyouvrate81() {
        return dyouvrate81;
    }

    public void setDyouvrate81(BizNumber pDyouvrate81) {
        dyouvrate81 = pDyouvrate81;
    }

    private BizNumber dyouvrate82;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE82)
    public BizNumber getDyouvrate82() {
        return dyouvrate82;
    }

    public void setDyouvrate82(BizNumber pDyouvrate82) {
        dyouvrate82 = pDyouvrate82;
    }

    private BizNumber dyouvrate83;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE83)
    public BizNumber getDyouvrate83() {
        return dyouvrate83;
    }

    public void setDyouvrate83(BizNumber pDyouvrate83) {
        dyouvrate83 = pDyouvrate83;
    }

    private BizNumber dyouvrate84;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE84)
    public BizNumber getDyouvrate84() {
        return dyouvrate84;
    }

    public void setDyouvrate84(BizNumber pDyouvrate84) {
        dyouvrate84 = pDyouvrate84;
    }

    private BizNumber dyouvrate85;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE85)
    public BizNumber getDyouvrate85() {
        return dyouvrate85;
    }

    public void setDyouvrate85(BizNumber pDyouvrate85) {
        dyouvrate85 = pDyouvrate85;
    }

    private BizNumber dyouvrate86;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE86)
    public BizNumber getDyouvrate86() {
        return dyouvrate86;
    }

    public void setDyouvrate86(BizNumber pDyouvrate86) {
        dyouvrate86 = pDyouvrate86;
    }

    private BizNumber dyouvrate87;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE87)
    public BizNumber getDyouvrate87() {
        return dyouvrate87;
    }

    public void setDyouvrate87(BizNumber pDyouvrate87) {
        dyouvrate87 = pDyouvrate87;
    }

    private BizNumber dyouvrate88;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE88)
    public BizNumber getDyouvrate88() {
        return dyouvrate88;
    }

    public void setDyouvrate88(BizNumber pDyouvrate88) {
        dyouvrate88 = pDyouvrate88;
    }

    private BizNumber dyouvrate89;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE89)
    public BizNumber getDyouvrate89() {
        return dyouvrate89;
    }

    public void setDyouvrate89(BizNumber pDyouvrate89) {
        dyouvrate89 = pDyouvrate89;
    }

    private BizNumber dyouvrate90;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE90)
    public BizNumber getDyouvrate90() {
        return dyouvrate90;
    }

    public void setDyouvrate90(BizNumber pDyouvrate90) {
        dyouvrate90 = pDyouvrate90;
    }

    private BizNumber dyouvrate91;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE91)
    public BizNumber getDyouvrate91() {
        return dyouvrate91;
    }

    public void setDyouvrate91(BizNumber pDyouvrate91) {
        dyouvrate91 = pDyouvrate91;
    }

    private BizNumber dyouvrate92;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE92)
    public BizNumber getDyouvrate92() {
        return dyouvrate92;
    }

    public void setDyouvrate92(BizNumber pDyouvrate92) {
        dyouvrate92 = pDyouvrate92;
    }

    private BizNumber dyouvrate93;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE93)
    public BizNumber getDyouvrate93() {
        return dyouvrate93;
    }

    public void setDyouvrate93(BizNumber pDyouvrate93) {
        dyouvrate93 = pDyouvrate93;
    }

    private BizNumber dyouvrate94;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE94)
    public BizNumber getDyouvrate94() {
        return dyouvrate94;
    }

    public void setDyouvrate94(BizNumber pDyouvrate94) {
        dyouvrate94 = pDyouvrate94;
    }

    private BizNumber dyouvrate95;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE95)
    public BizNumber getDyouvrate95() {
        return dyouvrate95;
    }

    public void setDyouvrate95(BizNumber pDyouvrate95) {
        dyouvrate95 = pDyouvrate95;
    }

    private BizNumber dyouvrate96;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE96)
    public BizNumber getDyouvrate96() {
        return dyouvrate96;
    }

    public void setDyouvrate96(BizNumber pDyouvrate96) {
        dyouvrate96 = pDyouvrate96;
    }

    private BizNumber dyouvrate97;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE97)
    public BizNumber getDyouvrate97() {
        return dyouvrate97;
    }

    public void setDyouvrate97(BizNumber pDyouvrate97) {
        dyouvrate97 = pDyouvrate97;
    }

    private BizNumber dyouvrate98;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE98)
    public BizNumber getDyouvrate98() {
        return dyouvrate98;
    }

    public void setDyouvrate98(BizNumber pDyouvrate98) {
        dyouvrate98 = pDyouvrate98;
    }

    private BizNumber dyouvrate99;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RisaHitSyouhnyouRateD2.DYOUVRATE99)
    public BizNumber getDyouvrate99() {
        return dyouvrate99;
    }

    public void setDyouvrate99(BizNumber pDyouvrate99) {
        dyouvrate99 = pDyouvrate99;
    }
}