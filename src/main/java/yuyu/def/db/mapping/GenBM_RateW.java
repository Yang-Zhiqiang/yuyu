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
import yuyu.def.db.entity.BM_RateW;
import yuyu.def.db.id.PKBM_RateW;
import yuyu.def.db.meta.GenQBM_RateW;
import yuyu.def.db.meta.QBM_RateW;

/**
 * Ｗレートマスタ テーブルのマッピング情報クラスで、 {@link BM_RateW} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateW}</td><td colspan="3">Ｗレートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getPalhokensyuruikigou palhokensyuruikigou}</td><td>ＰＡＬ保険種類記号</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhokensyuruikigousdicode palhokensyuruikigousdicode}</td><td>ＰＡＬ保険種類記号世代コード</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalyoteiriritu palyoteiriritu}</td><td>ＰＡＬ予定利率</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalpmencode palpmencode}</td><td>ＰＡＬＰ免コード</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalharaikomikaisuu palharaikomikaisuu}</td><td>ＰＡＬ払込回数</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhhknsei palhhknsei}</td><td>ＰＡＬ被保険者性別</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalkeiyakujihhknnen palkeiyakujihhknnen}</td><td>ＰＡＬ契約時被保険者年令</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalsaimankihyouji palsaimankihyouji}</td><td>ＰＡＬ才満期契約表示</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhokenkikan palhokenkikan}</td><td>ＰＡＬ保険期間</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalpharaikomikikan palpharaikomikikan}</td><td>ＰＡＬＰ払込期間</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalannaihuyouriyuukbn palannaihuyouriyuukbn}</td><td>ＰＡＬ案内不要理由区分</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getRatetuukasyukbn ratetuukasyukbn}</td><td>レート用通貨種類区分</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getRatedai1hknkkn ratedai1hknkkn}</td><td>レート用第１保険期間</td><td align="center">{@link PKBM_RateW ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getWrate00 wrate00}</td><td>Ｗレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate01 wrate01}</td><td>Ｗレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate02 wrate02}</td><td>Ｗレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate03 wrate03}</td><td>Ｗレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate04 wrate04}</td><td>Ｗレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate05 wrate05}</td><td>Ｗレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate06 wrate06}</td><td>Ｗレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate07 wrate07}</td><td>Ｗレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate08 wrate08}</td><td>Ｗレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate09 wrate09}</td><td>Ｗレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate10 wrate10}</td><td>Ｗレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate11 wrate11}</td><td>Ｗレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate12 wrate12}</td><td>Ｗレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate13 wrate13}</td><td>Ｗレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate14 wrate14}</td><td>Ｗレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate15 wrate15}</td><td>Ｗレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate16 wrate16}</td><td>Ｗレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate17 wrate17}</td><td>Ｗレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate18 wrate18}</td><td>Ｗレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate19 wrate19}</td><td>Ｗレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate20 wrate20}</td><td>Ｗレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate21 wrate21}</td><td>Ｗレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate22 wrate22}</td><td>Ｗレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate23 wrate23}</td><td>Ｗレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate24 wrate24}</td><td>Ｗレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate25 wrate25}</td><td>Ｗレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate26 wrate26}</td><td>Ｗレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate27 wrate27}</td><td>Ｗレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate28 wrate28}</td><td>Ｗレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate29 wrate29}</td><td>Ｗレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate30 wrate30}</td><td>Ｗレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate31 wrate31}</td><td>Ｗレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate32 wrate32}</td><td>Ｗレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate33 wrate33}</td><td>Ｗレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate34 wrate34}</td><td>Ｗレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate35 wrate35}</td><td>Ｗレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate36 wrate36}</td><td>Ｗレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate37 wrate37}</td><td>Ｗレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate38 wrate38}</td><td>Ｗレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate39 wrate39}</td><td>Ｗレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate40 wrate40}</td><td>Ｗレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate41 wrate41}</td><td>Ｗレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate42 wrate42}</td><td>Ｗレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate43 wrate43}</td><td>Ｗレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate44 wrate44}</td><td>Ｗレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate45 wrate45}</td><td>Ｗレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate46 wrate46}</td><td>Ｗレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate47 wrate47}</td><td>Ｗレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate48 wrate48}</td><td>Ｗレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate49 wrate49}</td><td>Ｗレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate50 wrate50}</td><td>Ｗレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate51 wrate51}</td><td>Ｗレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate52 wrate52}</td><td>Ｗレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate53 wrate53}</td><td>Ｗレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate54 wrate54}</td><td>Ｗレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate55 wrate55}</td><td>Ｗレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate56 wrate56}</td><td>Ｗレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate57 wrate57}</td><td>Ｗレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate58 wrate58}</td><td>Ｗレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate59 wrate59}</td><td>Ｗレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate60 wrate60}</td><td>Ｗレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate61 wrate61}</td><td>Ｗレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate62 wrate62}</td><td>Ｗレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate63 wrate63}</td><td>Ｗレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate64 wrate64}</td><td>Ｗレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate65 wrate65}</td><td>Ｗレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate66 wrate66}</td><td>Ｗレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate67 wrate67}</td><td>Ｗレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate68 wrate68}</td><td>Ｗレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate69 wrate69}</td><td>Ｗレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate70 wrate70}</td><td>Ｗレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate71 wrate71}</td><td>Ｗレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate72 wrate72}</td><td>Ｗレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate73 wrate73}</td><td>Ｗレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate74 wrate74}</td><td>Ｗレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate75 wrate75}</td><td>Ｗレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate76 wrate76}</td><td>Ｗレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate77 wrate77}</td><td>Ｗレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate78 wrate78}</td><td>Ｗレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate79 wrate79}</td><td>Ｗレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate80 wrate80}</td><td>Ｗレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate81 wrate81}</td><td>Ｗレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate82 wrate82}</td><td>Ｗレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate83 wrate83}</td><td>Ｗレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate84 wrate84}</td><td>Ｗレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate85 wrate85}</td><td>Ｗレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate86 wrate86}</td><td>Ｗレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate87 wrate87}</td><td>Ｗレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate88 wrate88}</td><td>Ｗレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate89 wrate89}</td><td>Ｗレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate90 wrate90}</td><td>Ｗレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate91 wrate91}</td><td>Ｗレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate92 wrate92}</td><td>Ｗレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate93 wrate93}</td><td>Ｗレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate94 wrate94}</td><td>Ｗレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate95 wrate95}</td><td>Ｗレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate96 wrate96}</td><td>Ｗレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate97 wrate97}</td><td>Ｗレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate98 wrate98}</td><td>Ｗレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getWrate99 wrate99}</td><td>Ｗレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_RateW
 * @see     PKBM_RateW
 * @see     QBM_RateW
 * @see     GenQBM_RateW
 */
@MappedSuperclass
@Table(name=GenBM_RateW.TABLE_NAME)
@IdClass(value=PKBM_RateW.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_RateW extends AbstractExDBEntity<BM_RateW, PKBM_RateW> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_RateW";
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
    public static final String WRATE00                  = "wrate00";
    public static final String WRATE01                  = "wrate01";
    public static final String WRATE02                  = "wrate02";
    public static final String WRATE03                  = "wrate03";
    public static final String WRATE04                  = "wrate04";
    public static final String WRATE05                  = "wrate05";
    public static final String WRATE06                  = "wrate06";
    public static final String WRATE07                  = "wrate07";
    public static final String WRATE08                  = "wrate08";
    public static final String WRATE09                  = "wrate09";
    public static final String WRATE10                  = "wrate10";
    public static final String WRATE11                  = "wrate11";
    public static final String WRATE12                  = "wrate12";
    public static final String WRATE13                  = "wrate13";
    public static final String WRATE14                  = "wrate14";
    public static final String WRATE15                  = "wrate15";
    public static final String WRATE16                  = "wrate16";
    public static final String WRATE17                  = "wrate17";
    public static final String WRATE18                  = "wrate18";
    public static final String WRATE19                  = "wrate19";
    public static final String WRATE20                  = "wrate20";
    public static final String WRATE21                  = "wrate21";
    public static final String WRATE22                  = "wrate22";
    public static final String WRATE23                  = "wrate23";
    public static final String WRATE24                  = "wrate24";
    public static final String WRATE25                  = "wrate25";
    public static final String WRATE26                  = "wrate26";
    public static final String WRATE27                  = "wrate27";
    public static final String WRATE28                  = "wrate28";
    public static final String WRATE29                  = "wrate29";
    public static final String WRATE30                  = "wrate30";
    public static final String WRATE31                  = "wrate31";
    public static final String WRATE32                  = "wrate32";
    public static final String WRATE33                  = "wrate33";
    public static final String WRATE34                  = "wrate34";
    public static final String WRATE35                  = "wrate35";
    public static final String WRATE36                  = "wrate36";
    public static final String WRATE37                  = "wrate37";
    public static final String WRATE38                  = "wrate38";
    public static final String WRATE39                  = "wrate39";
    public static final String WRATE40                  = "wrate40";
    public static final String WRATE41                  = "wrate41";
    public static final String WRATE42                  = "wrate42";
    public static final String WRATE43                  = "wrate43";
    public static final String WRATE44                  = "wrate44";
    public static final String WRATE45                  = "wrate45";
    public static final String WRATE46                  = "wrate46";
    public static final String WRATE47                  = "wrate47";
    public static final String WRATE48                  = "wrate48";
    public static final String WRATE49                  = "wrate49";
    public static final String WRATE50                  = "wrate50";
    public static final String WRATE51                  = "wrate51";
    public static final String WRATE52                  = "wrate52";
    public static final String WRATE53                  = "wrate53";
    public static final String WRATE54                  = "wrate54";
    public static final String WRATE55                  = "wrate55";
    public static final String WRATE56                  = "wrate56";
    public static final String WRATE57                  = "wrate57";
    public static final String WRATE58                  = "wrate58";
    public static final String WRATE59                  = "wrate59";
    public static final String WRATE60                  = "wrate60";
    public static final String WRATE61                  = "wrate61";
    public static final String WRATE62                  = "wrate62";
    public static final String WRATE63                  = "wrate63";
    public static final String WRATE64                  = "wrate64";
    public static final String WRATE65                  = "wrate65";
    public static final String WRATE66                  = "wrate66";
    public static final String WRATE67                  = "wrate67";
    public static final String WRATE68                  = "wrate68";
    public static final String WRATE69                  = "wrate69";
    public static final String WRATE70                  = "wrate70";
    public static final String WRATE71                  = "wrate71";
    public static final String WRATE72                  = "wrate72";
    public static final String WRATE73                  = "wrate73";
    public static final String WRATE74                  = "wrate74";
    public static final String WRATE75                  = "wrate75";
    public static final String WRATE76                  = "wrate76";
    public static final String WRATE77                  = "wrate77";
    public static final String WRATE78                  = "wrate78";
    public static final String WRATE79                  = "wrate79";
    public static final String WRATE80                  = "wrate80";
    public static final String WRATE81                  = "wrate81";
    public static final String WRATE82                  = "wrate82";
    public static final String WRATE83                  = "wrate83";
    public static final String WRATE84                  = "wrate84";
    public static final String WRATE85                  = "wrate85";
    public static final String WRATE86                  = "wrate86";
    public static final String WRATE87                  = "wrate87";
    public static final String WRATE88                  = "wrate88";
    public static final String WRATE89                  = "wrate89";
    public static final String WRATE90                  = "wrate90";
    public static final String WRATE91                  = "wrate91";
    public static final String WRATE92                  = "wrate92";
    public static final String WRATE93                  = "wrate93";
    public static final String WRATE94                  = "wrate94";
    public static final String WRATE95                  = "wrate95";
    public static final String WRATE96                  = "wrate96";
    public static final String WRATE97                  = "wrate97";
    public static final String WRATE98                  = "wrate98";
    public static final String WRATE99                  = "wrate99";

    private final PKBM_RateW primaryKey;

    public GenBM_RateW() {
        primaryKey = new PKBM_RateW();
    }

    public GenBM_RateW(
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
        String pRatedai1hknkkn
    ) {
        primaryKey = new PKBM_RateW(
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
            pRatedai1hknkkn
        );
    }

    @Transient
    @Override
    public PKBM_RateW getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_RateW> getMetaClass() {
        return QBM_RateW.class;
    }

    @Id
    @Column(name=GenBM_RateW.PALHOKENSYURUIKIGOU)
    public String getPalhokensyuruikigou() {
        return getPrimaryKey().getPalhokensyuruikigou();
    }

    public void setPalhokensyuruikigou(String pPalhokensyuruikigou) {
        getPrimaryKey().setPalhokensyuruikigou(pPalhokensyuruikigou);
    }

    @Id
    @Column(name=GenBM_RateW.PALHOKENSYURUIKIGOUSDICODE)
    public String getPalhokensyuruikigousdicode() {
        return getPrimaryKey().getPalhokensyuruikigousdicode();
    }

    public void setPalhokensyuruikigousdicode(String pPalhokensyuruikigousdicode) {
        getPrimaryKey().setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
    }

    @Id
    @Column(name=GenBM_RateW.PALYOTEIRIRITU)
    public String getPalyoteiriritu() {
        return getPrimaryKey().getPalyoteiriritu();
    }

    public void setPalyoteiriritu(String pPalyoteiriritu) {
        getPrimaryKey().setPalyoteiriritu(pPalyoteiriritu);
    }

    @Id
    @Column(name=GenBM_RateW.PALPMENCODE)
    public String getPalpmencode() {
        return getPrimaryKey().getPalpmencode();
    }

    public void setPalpmencode(String pPalpmencode) {
        getPrimaryKey().setPalpmencode(pPalpmencode);
    }

    @Id
    @Column(name=GenBM_RateW.PALHARAIKOMIKAISUU)
    public String getPalharaikomikaisuu() {
        return getPrimaryKey().getPalharaikomikaisuu();
    }

    public void setPalharaikomikaisuu(String pPalharaikomikaisuu) {
        getPrimaryKey().setPalharaikomikaisuu(pPalharaikomikaisuu);
    }

    @Id
    @Column(name=GenBM_RateW.PALHHKNSEI)
    public String getPalhhknsei() {
        return getPrimaryKey().getPalhhknsei();
    }

    public void setPalhhknsei(String pPalhhknsei) {
        getPrimaryKey().setPalhhknsei(pPalhhknsei);
    }

    @Id
    @Column(name=GenBM_RateW.PALKEIYAKUJIHHKNNEN)
    public String getPalkeiyakujihhknnen() {
        return getPrimaryKey().getPalkeiyakujihhknnen();
    }

    public void setPalkeiyakujihhknnen(String pPalkeiyakujihhknnen) {
        getPrimaryKey().setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
    }

    @Id
    @Column(name=GenBM_RateW.PALSAIMANKIHYOUJI)
    public String getPalsaimankihyouji() {
        return getPrimaryKey().getPalsaimankihyouji();
    }

    public void setPalsaimankihyouji(String pPalsaimankihyouji) {
        getPrimaryKey().setPalsaimankihyouji(pPalsaimankihyouji);
    }

    @Id
    @Column(name=GenBM_RateW.PALHOKENKIKAN)
    public String getPalhokenkikan() {
        return getPrimaryKey().getPalhokenkikan();
    }

    public void setPalhokenkikan(String pPalhokenkikan) {
        getPrimaryKey().setPalhokenkikan(pPalhokenkikan);
    }

    @Id
    @Column(name=GenBM_RateW.PALPHARAIKOMIKIKAN)
    public String getPalpharaikomikikan() {
        return getPrimaryKey().getPalpharaikomikikan();
    }

    public void setPalpharaikomikikan(String pPalpharaikomikikan) {
        getPrimaryKey().setPalpharaikomikikan(pPalpharaikomikikan);
    }

    @Id
    @Column(name=GenBM_RateW.PALANNAIHUYOURIYUUKBN)
    public String getPalannaihuyouriyuukbn() {
        return getPrimaryKey().getPalannaihuyouriyuukbn();
    }

    public void setPalannaihuyouriyuukbn(String pPalannaihuyouriyuukbn) {
        getPrimaryKey().setPalannaihuyouriyuukbn(pPalannaihuyouriyuukbn);
    }

    @Id
    @Column(name=GenBM_RateW.RATETUUKASYUKBN)
    public String getRatetuukasyukbn() {
        return getPrimaryKey().getRatetuukasyukbn();
    }

    public void setRatetuukasyukbn(String pRatetuukasyukbn) {
        getPrimaryKey().setRatetuukasyukbn(pRatetuukasyukbn);
    }

    @Id
    @Column(name=GenBM_RateW.RATEDAI1HKNKKN)
    public String getRatedai1hknkkn() {
        return getPrimaryKey().getRatedai1hknkkn();
    }

    public void setRatedai1hknkkn(String pRatedai1hknkkn) {
        getPrimaryKey().setRatedai1hknkkn(pRatedai1hknkkn);
    }

    private BizNumber wrate00;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE00)
    public BizNumber getWrate00() {
        return wrate00;
    }

    public void setWrate00(BizNumber pWrate00) {
        wrate00 = pWrate00;
    }

    private BizNumber wrate01;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE01)
    public BizNumber getWrate01() {
        return wrate01;
    }

    public void setWrate01(BizNumber pWrate01) {
        wrate01 = pWrate01;
    }

    private BizNumber wrate02;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE02)
    public BizNumber getWrate02() {
        return wrate02;
    }

    public void setWrate02(BizNumber pWrate02) {
        wrate02 = pWrate02;
    }

    private BizNumber wrate03;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE03)
    public BizNumber getWrate03() {
        return wrate03;
    }

    public void setWrate03(BizNumber pWrate03) {
        wrate03 = pWrate03;
    }

    private BizNumber wrate04;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE04)
    public BizNumber getWrate04() {
        return wrate04;
    }

    public void setWrate04(BizNumber pWrate04) {
        wrate04 = pWrate04;
    }

    private BizNumber wrate05;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE05)
    public BizNumber getWrate05() {
        return wrate05;
    }

    public void setWrate05(BizNumber pWrate05) {
        wrate05 = pWrate05;
    }

    private BizNumber wrate06;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE06)
    public BizNumber getWrate06() {
        return wrate06;
    }

    public void setWrate06(BizNumber pWrate06) {
        wrate06 = pWrate06;
    }

    private BizNumber wrate07;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE07)
    public BizNumber getWrate07() {
        return wrate07;
    }

    public void setWrate07(BizNumber pWrate07) {
        wrate07 = pWrate07;
    }

    private BizNumber wrate08;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE08)
    public BizNumber getWrate08() {
        return wrate08;
    }

    public void setWrate08(BizNumber pWrate08) {
        wrate08 = pWrate08;
    }

    private BizNumber wrate09;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE09)
    public BizNumber getWrate09() {
        return wrate09;
    }

    public void setWrate09(BizNumber pWrate09) {
        wrate09 = pWrate09;
    }

    private BizNumber wrate10;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE10)
    public BizNumber getWrate10() {
        return wrate10;
    }

    public void setWrate10(BizNumber pWrate10) {
        wrate10 = pWrate10;
    }

    private BizNumber wrate11;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE11)
    public BizNumber getWrate11() {
        return wrate11;
    }

    public void setWrate11(BizNumber pWrate11) {
        wrate11 = pWrate11;
    }

    private BizNumber wrate12;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE12)
    public BizNumber getWrate12() {
        return wrate12;
    }

    public void setWrate12(BizNumber pWrate12) {
        wrate12 = pWrate12;
    }

    private BizNumber wrate13;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE13)
    public BizNumber getWrate13() {
        return wrate13;
    }

    public void setWrate13(BizNumber pWrate13) {
        wrate13 = pWrate13;
    }

    private BizNumber wrate14;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE14)
    public BizNumber getWrate14() {
        return wrate14;
    }

    public void setWrate14(BizNumber pWrate14) {
        wrate14 = pWrate14;
    }

    private BizNumber wrate15;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE15)
    public BizNumber getWrate15() {
        return wrate15;
    }

    public void setWrate15(BizNumber pWrate15) {
        wrate15 = pWrate15;
    }

    private BizNumber wrate16;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE16)
    public BizNumber getWrate16() {
        return wrate16;
    }

    public void setWrate16(BizNumber pWrate16) {
        wrate16 = pWrate16;
    }

    private BizNumber wrate17;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE17)
    public BizNumber getWrate17() {
        return wrate17;
    }

    public void setWrate17(BizNumber pWrate17) {
        wrate17 = pWrate17;
    }

    private BizNumber wrate18;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE18)
    public BizNumber getWrate18() {
        return wrate18;
    }

    public void setWrate18(BizNumber pWrate18) {
        wrate18 = pWrate18;
    }

    private BizNumber wrate19;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE19)
    public BizNumber getWrate19() {
        return wrate19;
    }

    public void setWrate19(BizNumber pWrate19) {
        wrate19 = pWrate19;
    }

    private BizNumber wrate20;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE20)
    public BizNumber getWrate20() {
        return wrate20;
    }

    public void setWrate20(BizNumber pWrate20) {
        wrate20 = pWrate20;
    }

    private BizNumber wrate21;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE21)
    public BizNumber getWrate21() {
        return wrate21;
    }

    public void setWrate21(BizNumber pWrate21) {
        wrate21 = pWrate21;
    }

    private BizNumber wrate22;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE22)
    public BizNumber getWrate22() {
        return wrate22;
    }

    public void setWrate22(BizNumber pWrate22) {
        wrate22 = pWrate22;
    }

    private BizNumber wrate23;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE23)
    public BizNumber getWrate23() {
        return wrate23;
    }

    public void setWrate23(BizNumber pWrate23) {
        wrate23 = pWrate23;
    }

    private BizNumber wrate24;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE24)
    public BizNumber getWrate24() {
        return wrate24;
    }

    public void setWrate24(BizNumber pWrate24) {
        wrate24 = pWrate24;
    }

    private BizNumber wrate25;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE25)
    public BizNumber getWrate25() {
        return wrate25;
    }

    public void setWrate25(BizNumber pWrate25) {
        wrate25 = pWrate25;
    }

    private BizNumber wrate26;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE26)
    public BizNumber getWrate26() {
        return wrate26;
    }

    public void setWrate26(BizNumber pWrate26) {
        wrate26 = pWrate26;
    }

    private BizNumber wrate27;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE27)
    public BizNumber getWrate27() {
        return wrate27;
    }

    public void setWrate27(BizNumber pWrate27) {
        wrate27 = pWrate27;
    }

    private BizNumber wrate28;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE28)
    public BizNumber getWrate28() {
        return wrate28;
    }

    public void setWrate28(BizNumber pWrate28) {
        wrate28 = pWrate28;
    }

    private BizNumber wrate29;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE29)
    public BizNumber getWrate29() {
        return wrate29;
    }

    public void setWrate29(BizNumber pWrate29) {
        wrate29 = pWrate29;
    }

    private BizNumber wrate30;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE30)
    public BizNumber getWrate30() {
        return wrate30;
    }

    public void setWrate30(BizNumber pWrate30) {
        wrate30 = pWrate30;
    }

    private BizNumber wrate31;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE31)
    public BizNumber getWrate31() {
        return wrate31;
    }

    public void setWrate31(BizNumber pWrate31) {
        wrate31 = pWrate31;
    }

    private BizNumber wrate32;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE32)
    public BizNumber getWrate32() {
        return wrate32;
    }

    public void setWrate32(BizNumber pWrate32) {
        wrate32 = pWrate32;
    }

    private BizNumber wrate33;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE33)
    public BizNumber getWrate33() {
        return wrate33;
    }

    public void setWrate33(BizNumber pWrate33) {
        wrate33 = pWrate33;
    }

    private BizNumber wrate34;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE34)
    public BizNumber getWrate34() {
        return wrate34;
    }

    public void setWrate34(BizNumber pWrate34) {
        wrate34 = pWrate34;
    }

    private BizNumber wrate35;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE35)
    public BizNumber getWrate35() {
        return wrate35;
    }

    public void setWrate35(BizNumber pWrate35) {
        wrate35 = pWrate35;
    }

    private BizNumber wrate36;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE36)
    public BizNumber getWrate36() {
        return wrate36;
    }

    public void setWrate36(BizNumber pWrate36) {
        wrate36 = pWrate36;
    }

    private BizNumber wrate37;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE37)
    public BizNumber getWrate37() {
        return wrate37;
    }

    public void setWrate37(BizNumber pWrate37) {
        wrate37 = pWrate37;
    }

    private BizNumber wrate38;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE38)
    public BizNumber getWrate38() {
        return wrate38;
    }

    public void setWrate38(BizNumber pWrate38) {
        wrate38 = pWrate38;
    }

    private BizNumber wrate39;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE39)
    public BizNumber getWrate39() {
        return wrate39;
    }

    public void setWrate39(BizNumber pWrate39) {
        wrate39 = pWrate39;
    }

    private BizNumber wrate40;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE40)
    public BizNumber getWrate40() {
        return wrate40;
    }

    public void setWrate40(BizNumber pWrate40) {
        wrate40 = pWrate40;
    }

    private BizNumber wrate41;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE41)
    public BizNumber getWrate41() {
        return wrate41;
    }

    public void setWrate41(BizNumber pWrate41) {
        wrate41 = pWrate41;
    }

    private BizNumber wrate42;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE42)
    public BizNumber getWrate42() {
        return wrate42;
    }

    public void setWrate42(BizNumber pWrate42) {
        wrate42 = pWrate42;
    }

    private BizNumber wrate43;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE43)
    public BizNumber getWrate43() {
        return wrate43;
    }

    public void setWrate43(BizNumber pWrate43) {
        wrate43 = pWrate43;
    }

    private BizNumber wrate44;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE44)
    public BizNumber getWrate44() {
        return wrate44;
    }

    public void setWrate44(BizNumber pWrate44) {
        wrate44 = pWrate44;
    }

    private BizNumber wrate45;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE45)
    public BizNumber getWrate45() {
        return wrate45;
    }

    public void setWrate45(BizNumber pWrate45) {
        wrate45 = pWrate45;
    }

    private BizNumber wrate46;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE46)
    public BizNumber getWrate46() {
        return wrate46;
    }

    public void setWrate46(BizNumber pWrate46) {
        wrate46 = pWrate46;
    }

    private BizNumber wrate47;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE47)
    public BizNumber getWrate47() {
        return wrate47;
    }

    public void setWrate47(BizNumber pWrate47) {
        wrate47 = pWrate47;
    }

    private BizNumber wrate48;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE48)
    public BizNumber getWrate48() {
        return wrate48;
    }

    public void setWrate48(BizNumber pWrate48) {
        wrate48 = pWrate48;
    }

    private BizNumber wrate49;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE49)
    public BizNumber getWrate49() {
        return wrate49;
    }

    public void setWrate49(BizNumber pWrate49) {
        wrate49 = pWrate49;
    }

    private BizNumber wrate50;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE50)
    public BizNumber getWrate50() {
        return wrate50;
    }

    public void setWrate50(BizNumber pWrate50) {
        wrate50 = pWrate50;
    }

    private BizNumber wrate51;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE51)
    public BizNumber getWrate51() {
        return wrate51;
    }

    public void setWrate51(BizNumber pWrate51) {
        wrate51 = pWrate51;
    }

    private BizNumber wrate52;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE52)
    public BizNumber getWrate52() {
        return wrate52;
    }

    public void setWrate52(BizNumber pWrate52) {
        wrate52 = pWrate52;
    }

    private BizNumber wrate53;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE53)
    public BizNumber getWrate53() {
        return wrate53;
    }

    public void setWrate53(BizNumber pWrate53) {
        wrate53 = pWrate53;
    }

    private BizNumber wrate54;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE54)
    public BizNumber getWrate54() {
        return wrate54;
    }

    public void setWrate54(BizNumber pWrate54) {
        wrate54 = pWrate54;
    }

    private BizNumber wrate55;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE55)
    public BizNumber getWrate55() {
        return wrate55;
    }

    public void setWrate55(BizNumber pWrate55) {
        wrate55 = pWrate55;
    }

    private BizNumber wrate56;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE56)
    public BizNumber getWrate56() {
        return wrate56;
    }

    public void setWrate56(BizNumber pWrate56) {
        wrate56 = pWrate56;
    }

    private BizNumber wrate57;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE57)
    public BizNumber getWrate57() {
        return wrate57;
    }

    public void setWrate57(BizNumber pWrate57) {
        wrate57 = pWrate57;
    }

    private BizNumber wrate58;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE58)
    public BizNumber getWrate58() {
        return wrate58;
    }

    public void setWrate58(BizNumber pWrate58) {
        wrate58 = pWrate58;
    }

    private BizNumber wrate59;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE59)
    public BizNumber getWrate59() {
        return wrate59;
    }

    public void setWrate59(BizNumber pWrate59) {
        wrate59 = pWrate59;
    }

    private BizNumber wrate60;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE60)
    public BizNumber getWrate60() {
        return wrate60;
    }

    public void setWrate60(BizNumber pWrate60) {
        wrate60 = pWrate60;
    }

    private BizNumber wrate61;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE61)
    public BizNumber getWrate61() {
        return wrate61;
    }

    public void setWrate61(BizNumber pWrate61) {
        wrate61 = pWrate61;
    }

    private BizNumber wrate62;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE62)
    public BizNumber getWrate62() {
        return wrate62;
    }

    public void setWrate62(BizNumber pWrate62) {
        wrate62 = pWrate62;
    }

    private BizNumber wrate63;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE63)
    public BizNumber getWrate63() {
        return wrate63;
    }

    public void setWrate63(BizNumber pWrate63) {
        wrate63 = pWrate63;
    }

    private BizNumber wrate64;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE64)
    public BizNumber getWrate64() {
        return wrate64;
    }

    public void setWrate64(BizNumber pWrate64) {
        wrate64 = pWrate64;
    }

    private BizNumber wrate65;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE65)
    public BizNumber getWrate65() {
        return wrate65;
    }

    public void setWrate65(BizNumber pWrate65) {
        wrate65 = pWrate65;
    }

    private BizNumber wrate66;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE66)
    public BizNumber getWrate66() {
        return wrate66;
    }

    public void setWrate66(BizNumber pWrate66) {
        wrate66 = pWrate66;
    }

    private BizNumber wrate67;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE67)
    public BizNumber getWrate67() {
        return wrate67;
    }

    public void setWrate67(BizNumber pWrate67) {
        wrate67 = pWrate67;
    }

    private BizNumber wrate68;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE68)
    public BizNumber getWrate68() {
        return wrate68;
    }

    public void setWrate68(BizNumber pWrate68) {
        wrate68 = pWrate68;
    }

    private BizNumber wrate69;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE69)
    public BizNumber getWrate69() {
        return wrate69;
    }

    public void setWrate69(BizNumber pWrate69) {
        wrate69 = pWrate69;
    }

    private BizNumber wrate70;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE70)
    public BizNumber getWrate70() {
        return wrate70;
    }

    public void setWrate70(BizNumber pWrate70) {
        wrate70 = pWrate70;
    }

    private BizNumber wrate71;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE71)
    public BizNumber getWrate71() {
        return wrate71;
    }

    public void setWrate71(BizNumber pWrate71) {
        wrate71 = pWrate71;
    }

    private BizNumber wrate72;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE72)
    public BizNumber getWrate72() {
        return wrate72;
    }

    public void setWrate72(BizNumber pWrate72) {
        wrate72 = pWrate72;
    }

    private BizNumber wrate73;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE73)
    public BizNumber getWrate73() {
        return wrate73;
    }

    public void setWrate73(BizNumber pWrate73) {
        wrate73 = pWrate73;
    }

    private BizNumber wrate74;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE74)
    public BizNumber getWrate74() {
        return wrate74;
    }

    public void setWrate74(BizNumber pWrate74) {
        wrate74 = pWrate74;
    }

    private BizNumber wrate75;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE75)
    public BizNumber getWrate75() {
        return wrate75;
    }

    public void setWrate75(BizNumber pWrate75) {
        wrate75 = pWrate75;
    }

    private BizNumber wrate76;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE76)
    public BizNumber getWrate76() {
        return wrate76;
    }

    public void setWrate76(BizNumber pWrate76) {
        wrate76 = pWrate76;
    }

    private BizNumber wrate77;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE77)
    public BizNumber getWrate77() {
        return wrate77;
    }

    public void setWrate77(BizNumber pWrate77) {
        wrate77 = pWrate77;
    }

    private BizNumber wrate78;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE78)
    public BizNumber getWrate78() {
        return wrate78;
    }

    public void setWrate78(BizNumber pWrate78) {
        wrate78 = pWrate78;
    }

    private BizNumber wrate79;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE79)
    public BizNumber getWrate79() {
        return wrate79;
    }

    public void setWrate79(BizNumber pWrate79) {
        wrate79 = pWrate79;
    }

    private BizNumber wrate80;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE80)
    public BizNumber getWrate80() {
        return wrate80;
    }

    public void setWrate80(BizNumber pWrate80) {
        wrate80 = pWrate80;
    }

    private BizNumber wrate81;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE81)
    public BizNumber getWrate81() {
        return wrate81;
    }

    public void setWrate81(BizNumber pWrate81) {
        wrate81 = pWrate81;
    }

    private BizNumber wrate82;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE82)
    public BizNumber getWrate82() {
        return wrate82;
    }

    public void setWrate82(BizNumber pWrate82) {
        wrate82 = pWrate82;
    }

    private BizNumber wrate83;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE83)
    public BizNumber getWrate83() {
        return wrate83;
    }

    public void setWrate83(BizNumber pWrate83) {
        wrate83 = pWrate83;
    }

    private BizNumber wrate84;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE84)
    public BizNumber getWrate84() {
        return wrate84;
    }

    public void setWrate84(BizNumber pWrate84) {
        wrate84 = pWrate84;
    }

    private BizNumber wrate85;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE85)
    public BizNumber getWrate85() {
        return wrate85;
    }

    public void setWrate85(BizNumber pWrate85) {
        wrate85 = pWrate85;
    }

    private BizNumber wrate86;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE86)
    public BizNumber getWrate86() {
        return wrate86;
    }

    public void setWrate86(BizNumber pWrate86) {
        wrate86 = pWrate86;
    }

    private BizNumber wrate87;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE87)
    public BizNumber getWrate87() {
        return wrate87;
    }

    public void setWrate87(BizNumber pWrate87) {
        wrate87 = pWrate87;
    }

    private BizNumber wrate88;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE88)
    public BizNumber getWrate88() {
        return wrate88;
    }

    public void setWrate88(BizNumber pWrate88) {
        wrate88 = pWrate88;
    }

    private BizNumber wrate89;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE89)
    public BizNumber getWrate89() {
        return wrate89;
    }

    public void setWrate89(BizNumber pWrate89) {
        wrate89 = pWrate89;
    }

    private BizNumber wrate90;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE90)
    public BizNumber getWrate90() {
        return wrate90;
    }

    public void setWrate90(BizNumber pWrate90) {
        wrate90 = pWrate90;
    }

    private BizNumber wrate91;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE91)
    public BizNumber getWrate91() {
        return wrate91;
    }

    public void setWrate91(BizNumber pWrate91) {
        wrate91 = pWrate91;
    }

    private BizNumber wrate92;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE92)
    public BizNumber getWrate92() {
        return wrate92;
    }

    public void setWrate92(BizNumber pWrate92) {
        wrate92 = pWrate92;
    }

    private BizNumber wrate93;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE93)
    public BizNumber getWrate93() {
        return wrate93;
    }

    public void setWrate93(BizNumber pWrate93) {
        wrate93 = pWrate93;
    }

    private BizNumber wrate94;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE94)
    public BizNumber getWrate94() {
        return wrate94;
    }

    public void setWrate94(BizNumber pWrate94) {
        wrate94 = pWrate94;
    }

    private BizNumber wrate95;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE95)
    public BizNumber getWrate95() {
        return wrate95;
    }

    public void setWrate95(BizNumber pWrate95) {
        wrate95 = pWrate95;
    }

    private BizNumber wrate96;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE96)
    public BizNumber getWrate96() {
        return wrate96;
    }

    public void setWrate96(BizNumber pWrate96) {
        wrate96 = pWrate96;
    }

    private BizNumber wrate97;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE97)
    public BizNumber getWrate97() {
        return wrate97;
    }

    public void setWrate97(BizNumber pWrate97) {
        wrate97 = pWrate97;
    }

    private BizNumber wrate98;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE98)
    public BizNumber getWrate98() {
        return wrate98;
    }

    public void setWrate98(BizNumber pWrate98) {
        wrate98 = pWrate98;
    }

    private BizNumber wrate99;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateW.WRATE99)
    public BizNumber getWrate99() {
        return wrate99;
    }

    public void setWrate99(BizNumber pWrate99) {
        wrate99 = pWrate99;
    }
}