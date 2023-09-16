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
import yuyu.def.db.entity.BM_RateD;
import yuyu.def.db.id.PKBM_RateD;
import yuyu.def.db.meta.GenQBM_RateD;
import yuyu.def.db.meta.QBM_RateD;

/**
 * Ｄレートマスタ テーブルのマッピング情報クラスで、 {@link BM_RateD} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateD}</td><td colspan="3">Ｄレートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getPalhokensyuruikigou palhokensyuruikigou}</td><td>ＰＡＬ保険種類記号</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhokensyuruikigousdicode palhokensyuruikigousdicode}</td><td>ＰＡＬ保険種類記号世代コード</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalyoteiriritu palyoteiriritu}</td><td>ＰＡＬ予定利率</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalpmencode palpmencode}</td><td>ＰＡＬＰ免コード</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalharaikomikaisuu palharaikomikaisuu}</td><td>ＰＡＬ払込回数</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhhknsei palhhknsei}</td><td>ＰＡＬ被保険者性別</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalkeiyakujihhknnen palkeiyakujihhknnen}</td><td>ＰＡＬ契約時被保険者年令</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalsaimankihyouji palsaimankihyouji}</td><td>ＰＡＬ才満期契約表示</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhokenkikan palhokenkikan}</td><td>ＰＡＬ保険期間</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalpharaikomikikan palpharaikomikikan}</td><td>ＰＡＬＰ払込期間</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPaldnendo paldnendo}</td><td>ＰＡＬＤ年度</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPaldratenaikakucode paldratenaikakucode}</td><td>ＰＡＬＤレート内定確定コード</td><td align="center">{@link PKBM_RateD ○}</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>{@link #getSisadrate00 sisadrate00}</td><td>死差Ｄレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate01 sisadrate01}</td><td>死差Ｄレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate02 sisadrate02}</td><td>死差Ｄレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate03 sisadrate03}</td><td>死差Ｄレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate04 sisadrate04}</td><td>死差Ｄレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate05 sisadrate05}</td><td>死差Ｄレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate06 sisadrate06}</td><td>死差Ｄレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate07 sisadrate07}</td><td>死差Ｄレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate08 sisadrate08}</td><td>死差Ｄレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate09 sisadrate09}</td><td>死差Ｄレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate10 sisadrate10}</td><td>死差Ｄレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate11 sisadrate11}</td><td>死差Ｄレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate12 sisadrate12}</td><td>死差Ｄレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate13 sisadrate13}</td><td>死差Ｄレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate14 sisadrate14}</td><td>死差Ｄレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate15 sisadrate15}</td><td>死差Ｄレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate16 sisadrate16}</td><td>死差Ｄレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate17 sisadrate17}</td><td>死差Ｄレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate18 sisadrate18}</td><td>死差Ｄレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate19 sisadrate19}</td><td>死差Ｄレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate20 sisadrate20}</td><td>死差Ｄレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate21 sisadrate21}</td><td>死差Ｄレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate22 sisadrate22}</td><td>死差Ｄレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate23 sisadrate23}</td><td>死差Ｄレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate24 sisadrate24}</td><td>死差Ｄレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate25 sisadrate25}</td><td>死差Ｄレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate26 sisadrate26}</td><td>死差Ｄレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate27 sisadrate27}</td><td>死差Ｄレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate28 sisadrate28}</td><td>死差Ｄレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate29 sisadrate29}</td><td>死差Ｄレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate30 sisadrate30}</td><td>死差Ｄレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate31 sisadrate31}</td><td>死差Ｄレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate32 sisadrate32}</td><td>死差Ｄレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate33 sisadrate33}</td><td>死差Ｄレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate34 sisadrate34}</td><td>死差Ｄレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate35 sisadrate35}</td><td>死差Ｄレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate36 sisadrate36}</td><td>死差Ｄレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate37 sisadrate37}</td><td>死差Ｄレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate38 sisadrate38}</td><td>死差Ｄレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate39 sisadrate39}</td><td>死差Ｄレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate40 sisadrate40}</td><td>死差Ｄレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate41 sisadrate41}</td><td>死差Ｄレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate42 sisadrate42}</td><td>死差Ｄレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate43 sisadrate43}</td><td>死差Ｄレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate44 sisadrate44}</td><td>死差Ｄレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate45 sisadrate45}</td><td>死差Ｄレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate46 sisadrate46}</td><td>死差Ｄレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate47 sisadrate47}</td><td>死差Ｄレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate48 sisadrate48}</td><td>死差Ｄレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate49 sisadrate49}</td><td>死差Ｄレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate50 sisadrate50}</td><td>死差Ｄレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate51 sisadrate51}</td><td>死差Ｄレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate52 sisadrate52}</td><td>死差Ｄレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate53 sisadrate53}</td><td>死差Ｄレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate54 sisadrate54}</td><td>死差Ｄレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate55 sisadrate55}</td><td>死差Ｄレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate56 sisadrate56}</td><td>死差Ｄレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate57 sisadrate57}</td><td>死差Ｄレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate58 sisadrate58}</td><td>死差Ｄレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate59 sisadrate59}</td><td>死差Ｄレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate60 sisadrate60}</td><td>死差Ｄレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate61 sisadrate61}</td><td>死差Ｄレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate62 sisadrate62}</td><td>死差Ｄレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate63 sisadrate63}</td><td>死差Ｄレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate64 sisadrate64}</td><td>死差Ｄレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate65 sisadrate65}</td><td>死差Ｄレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate66 sisadrate66}</td><td>死差Ｄレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate67 sisadrate67}</td><td>死差Ｄレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate68 sisadrate68}</td><td>死差Ｄレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate69 sisadrate69}</td><td>死差Ｄレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate70 sisadrate70}</td><td>死差Ｄレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate71 sisadrate71}</td><td>死差Ｄレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate72 sisadrate72}</td><td>死差Ｄレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate73 sisadrate73}</td><td>死差Ｄレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate74 sisadrate74}</td><td>死差Ｄレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate75 sisadrate75}</td><td>死差Ｄレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate76 sisadrate76}</td><td>死差Ｄレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate77 sisadrate77}</td><td>死差Ｄレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate78 sisadrate78}</td><td>死差Ｄレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate79 sisadrate79}</td><td>死差Ｄレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate80 sisadrate80}</td><td>死差Ｄレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate81 sisadrate81}</td><td>死差Ｄレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate82 sisadrate82}</td><td>死差Ｄレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate83 sisadrate83}</td><td>死差Ｄレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate84 sisadrate84}</td><td>死差Ｄレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate85 sisadrate85}</td><td>死差Ｄレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate86 sisadrate86}</td><td>死差Ｄレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate87 sisadrate87}</td><td>死差Ｄレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate88 sisadrate88}</td><td>死差Ｄレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate89 sisadrate89}</td><td>死差Ｄレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate90 sisadrate90}</td><td>死差Ｄレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate91 sisadrate91}</td><td>死差Ｄレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate92 sisadrate92}</td><td>死差Ｄレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate93 sisadrate93}</td><td>死差Ｄレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate94 sisadrate94}</td><td>死差Ｄレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate95 sisadrate95}</td><td>死差Ｄレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate96 sisadrate96}</td><td>死差Ｄレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate97 sisadrate97}</td><td>死差Ｄレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate98 sisadrate98}</td><td>死差Ｄレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSisadrate99 sisadrate99}</td><td>死差Ｄレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate00 risadrate00}</td><td>利差Ｄレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate01 risadrate01}</td><td>利差Ｄレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate02 risadrate02}</td><td>利差Ｄレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate03 risadrate03}</td><td>利差Ｄレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate04 risadrate04}</td><td>利差Ｄレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate05 risadrate05}</td><td>利差Ｄレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate06 risadrate06}</td><td>利差Ｄレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate07 risadrate07}</td><td>利差Ｄレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate08 risadrate08}</td><td>利差Ｄレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate09 risadrate09}</td><td>利差Ｄレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate10 risadrate10}</td><td>利差Ｄレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate11 risadrate11}</td><td>利差Ｄレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate12 risadrate12}</td><td>利差Ｄレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate13 risadrate13}</td><td>利差Ｄレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate14 risadrate14}</td><td>利差Ｄレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate15 risadrate15}</td><td>利差Ｄレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate16 risadrate16}</td><td>利差Ｄレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate17 risadrate17}</td><td>利差Ｄレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate18 risadrate18}</td><td>利差Ｄレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate19 risadrate19}</td><td>利差Ｄレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate20 risadrate20}</td><td>利差Ｄレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate21 risadrate21}</td><td>利差Ｄレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate22 risadrate22}</td><td>利差Ｄレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate23 risadrate23}</td><td>利差Ｄレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate24 risadrate24}</td><td>利差Ｄレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate25 risadrate25}</td><td>利差Ｄレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate26 risadrate26}</td><td>利差Ｄレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate27 risadrate27}</td><td>利差Ｄレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate28 risadrate28}</td><td>利差Ｄレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate29 risadrate29}</td><td>利差Ｄレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate30 risadrate30}</td><td>利差Ｄレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate31 risadrate31}</td><td>利差Ｄレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate32 risadrate32}</td><td>利差Ｄレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate33 risadrate33}</td><td>利差Ｄレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate34 risadrate34}</td><td>利差Ｄレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate35 risadrate35}</td><td>利差Ｄレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate36 risadrate36}</td><td>利差Ｄレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate37 risadrate37}</td><td>利差Ｄレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate38 risadrate38}</td><td>利差Ｄレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate39 risadrate39}</td><td>利差Ｄレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate40 risadrate40}</td><td>利差Ｄレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate41 risadrate41}</td><td>利差Ｄレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate42 risadrate42}</td><td>利差Ｄレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate43 risadrate43}</td><td>利差Ｄレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate44 risadrate44}</td><td>利差Ｄレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate45 risadrate45}</td><td>利差Ｄレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate46 risadrate46}</td><td>利差Ｄレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate47 risadrate47}</td><td>利差Ｄレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate48 risadrate48}</td><td>利差Ｄレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate49 risadrate49}</td><td>利差Ｄレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate50 risadrate50}</td><td>利差Ｄレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate51 risadrate51}</td><td>利差Ｄレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate52 risadrate52}</td><td>利差Ｄレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate53 risadrate53}</td><td>利差Ｄレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate54 risadrate54}</td><td>利差Ｄレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate55 risadrate55}</td><td>利差Ｄレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate56 risadrate56}</td><td>利差Ｄレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate57 risadrate57}</td><td>利差Ｄレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate58 risadrate58}</td><td>利差Ｄレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate59 risadrate59}</td><td>利差Ｄレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate60 risadrate60}</td><td>利差Ｄレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate61 risadrate61}</td><td>利差Ｄレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate62 risadrate62}</td><td>利差Ｄレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate63 risadrate63}</td><td>利差Ｄレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate64 risadrate64}</td><td>利差Ｄレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate65 risadrate65}</td><td>利差Ｄレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate66 risadrate66}</td><td>利差Ｄレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate67 risadrate67}</td><td>利差Ｄレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate68 risadrate68}</td><td>利差Ｄレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate69 risadrate69}</td><td>利差Ｄレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate70 risadrate70}</td><td>利差Ｄレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate71 risadrate71}</td><td>利差Ｄレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate72 risadrate72}</td><td>利差Ｄレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate73 risadrate73}</td><td>利差Ｄレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate74 risadrate74}</td><td>利差Ｄレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate75 risadrate75}</td><td>利差Ｄレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate76 risadrate76}</td><td>利差Ｄレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate77 risadrate77}</td><td>利差Ｄレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate78 risadrate78}</td><td>利差Ｄレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate79 risadrate79}</td><td>利差Ｄレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate80 risadrate80}</td><td>利差Ｄレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate81 risadrate81}</td><td>利差Ｄレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate82 risadrate82}</td><td>利差Ｄレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate83 risadrate83}</td><td>利差Ｄレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate84 risadrate84}</td><td>利差Ｄレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate85 risadrate85}</td><td>利差Ｄレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate86 risadrate86}</td><td>利差Ｄレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate87 risadrate87}</td><td>利差Ｄレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate88 risadrate88}</td><td>利差Ｄレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate89 risadrate89}</td><td>利差Ｄレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate90 risadrate90}</td><td>利差Ｄレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate91 risadrate91}</td><td>利差Ｄレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate92 risadrate92}</td><td>利差Ｄレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate93 risadrate93}</td><td>利差Ｄレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate94 risadrate94}</td><td>利差Ｄレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate95 risadrate95}</td><td>利差Ｄレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate96 risadrate96}</td><td>利差Ｄレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate97 risadrate97}</td><td>利差Ｄレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate98 risadrate98}</td><td>利差Ｄレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getRisadrate99 risadrate99}</td><td>利差Ｄレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate00 hisadrate00}</td><td>費差Ｄレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate01 hisadrate01}</td><td>費差Ｄレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate02 hisadrate02}</td><td>費差Ｄレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate03 hisadrate03}</td><td>費差Ｄレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate04 hisadrate04}</td><td>費差Ｄレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate05 hisadrate05}</td><td>費差Ｄレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate06 hisadrate06}</td><td>費差Ｄレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate07 hisadrate07}</td><td>費差Ｄレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate08 hisadrate08}</td><td>費差Ｄレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate09 hisadrate09}</td><td>費差Ｄレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate10 hisadrate10}</td><td>費差Ｄレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate11 hisadrate11}</td><td>費差Ｄレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate12 hisadrate12}</td><td>費差Ｄレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate13 hisadrate13}</td><td>費差Ｄレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate14 hisadrate14}</td><td>費差Ｄレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate15 hisadrate15}</td><td>費差Ｄレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate16 hisadrate16}</td><td>費差Ｄレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate17 hisadrate17}</td><td>費差Ｄレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate18 hisadrate18}</td><td>費差Ｄレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate19 hisadrate19}</td><td>費差Ｄレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate20 hisadrate20}</td><td>費差Ｄレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate21 hisadrate21}</td><td>費差Ｄレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate22 hisadrate22}</td><td>費差Ｄレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate23 hisadrate23}</td><td>費差Ｄレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate24 hisadrate24}</td><td>費差Ｄレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate25 hisadrate25}</td><td>費差Ｄレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate26 hisadrate26}</td><td>費差Ｄレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate27 hisadrate27}</td><td>費差Ｄレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate28 hisadrate28}</td><td>費差Ｄレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate29 hisadrate29}</td><td>費差Ｄレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate30 hisadrate30}</td><td>費差Ｄレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate31 hisadrate31}</td><td>費差Ｄレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate32 hisadrate32}</td><td>費差Ｄレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate33 hisadrate33}</td><td>費差Ｄレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate34 hisadrate34}</td><td>費差Ｄレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate35 hisadrate35}</td><td>費差Ｄレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate36 hisadrate36}</td><td>費差Ｄレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate37 hisadrate37}</td><td>費差Ｄレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate38 hisadrate38}</td><td>費差Ｄレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate39 hisadrate39}</td><td>費差Ｄレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate40 hisadrate40}</td><td>費差Ｄレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate41 hisadrate41}</td><td>費差Ｄレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate42 hisadrate42}</td><td>費差Ｄレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate43 hisadrate43}</td><td>費差Ｄレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate44 hisadrate44}</td><td>費差Ｄレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate45 hisadrate45}</td><td>費差Ｄレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate46 hisadrate46}</td><td>費差Ｄレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate47 hisadrate47}</td><td>費差Ｄレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate48 hisadrate48}</td><td>費差Ｄレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate49 hisadrate49}</td><td>費差Ｄレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate50 hisadrate50}</td><td>費差Ｄレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate51 hisadrate51}</td><td>費差Ｄレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate52 hisadrate52}</td><td>費差Ｄレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate53 hisadrate53}</td><td>費差Ｄレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate54 hisadrate54}</td><td>費差Ｄレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate55 hisadrate55}</td><td>費差Ｄレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate56 hisadrate56}</td><td>費差Ｄレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate57 hisadrate57}</td><td>費差Ｄレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate58 hisadrate58}</td><td>費差Ｄレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate59 hisadrate59}</td><td>費差Ｄレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate60 hisadrate60}</td><td>費差Ｄレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate61 hisadrate61}</td><td>費差Ｄレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate62 hisadrate62}</td><td>費差Ｄレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate63 hisadrate63}</td><td>費差Ｄレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate64 hisadrate64}</td><td>費差Ｄレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate65 hisadrate65}</td><td>費差Ｄレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate66 hisadrate66}</td><td>費差Ｄレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate67 hisadrate67}</td><td>費差Ｄレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate68 hisadrate68}</td><td>費差Ｄレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate69 hisadrate69}</td><td>費差Ｄレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate70 hisadrate70}</td><td>費差Ｄレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate71 hisadrate71}</td><td>費差Ｄレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate72 hisadrate72}</td><td>費差Ｄレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate73 hisadrate73}</td><td>費差Ｄレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate74 hisadrate74}</td><td>費差Ｄレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate75 hisadrate75}</td><td>費差Ｄレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate76 hisadrate76}</td><td>費差Ｄレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate77 hisadrate77}</td><td>費差Ｄレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate78 hisadrate78}</td><td>費差Ｄレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate79 hisadrate79}</td><td>費差Ｄレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate80 hisadrate80}</td><td>費差Ｄレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate81 hisadrate81}</td><td>費差Ｄレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate82 hisadrate82}</td><td>費差Ｄレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate83 hisadrate83}</td><td>費差Ｄレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate84 hisadrate84}</td><td>費差Ｄレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate85 hisadrate85}</td><td>費差Ｄレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate86 hisadrate86}</td><td>費差Ｄレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate87 hisadrate87}</td><td>費差Ｄレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate88 hisadrate88}</td><td>費差Ｄレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate89 hisadrate89}</td><td>費差Ｄレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate90 hisadrate90}</td><td>費差Ｄレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate91 hisadrate91}</td><td>費差Ｄレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate92 hisadrate92}</td><td>費差Ｄレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate93 hisadrate93}</td><td>費差Ｄレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate94 hisadrate94}</td><td>費差Ｄレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate95 hisadrate95}</td><td>費差Ｄレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate96 hisadrate96}</td><td>費差Ｄレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate97 hisadrate97}</td><td>費差Ｄレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate98 hisadrate98}</td><td>費差Ｄレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getHisadrate99 hisadrate99}</td><td>費差Ｄレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
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
 *  <tr><td>{@link #getKikensrate00 kikensrate00}</td><td>危険Ｓレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate01 kikensrate01}</td><td>危険Ｓレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate02 kikensrate02}</td><td>危険Ｓレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate03 kikensrate03}</td><td>危険Ｓレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate04 kikensrate04}</td><td>危険Ｓレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate05 kikensrate05}</td><td>危険Ｓレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate06 kikensrate06}</td><td>危険Ｓレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate07 kikensrate07}</td><td>危険Ｓレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate08 kikensrate08}</td><td>危険Ｓレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate09 kikensrate09}</td><td>危険Ｓレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate10 kikensrate10}</td><td>危険Ｓレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate11 kikensrate11}</td><td>危険Ｓレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate12 kikensrate12}</td><td>危険Ｓレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate13 kikensrate13}</td><td>危険Ｓレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate14 kikensrate14}</td><td>危険Ｓレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate15 kikensrate15}</td><td>危険Ｓレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate16 kikensrate16}</td><td>危険Ｓレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate17 kikensrate17}</td><td>危険Ｓレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate18 kikensrate18}</td><td>危険Ｓレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate19 kikensrate19}</td><td>危険Ｓレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate20 kikensrate20}</td><td>危険Ｓレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate21 kikensrate21}</td><td>危険Ｓレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate22 kikensrate22}</td><td>危険Ｓレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate23 kikensrate23}</td><td>危険Ｓレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate24 kikensrate24}</td><td>危険Ｓレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate25 kikensrate25}</td><td>危険Ｓレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate26 kikensrate26}</td><td>危険Ｓレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate27 kikensrate27}</td><td>危険Ｓレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate28 kikensrate28}</td><td>危険Ｓレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate29 kikensrate29}</td><td>危険Ｓレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate30 kikensrate30}</td><td>危険Ｓレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate31 kikensrate31}</td><td>危険Ｓレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate32 kikensrate32}</td><td>危険Ｓレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate33 kikensrate33}</td><td>危険Ｓレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate34 kikensrate34}</td><td>危険Ｓレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate35 kikensrate35}</td><td>危険Ｓレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate36 kikensrate36}</td><td>危険Ｓレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate37 kikensrate37}</td><td>危険Ｓレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate38 kikensrate38}</td><td>危険Ｓレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate39 kikensrate39}</td><td>危険Ｓレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate40 kikensrate40}</td><td>危険Ｓレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate41 kikensrate41}</td><td>危険Ｓレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate42 kikensrate42}</td><td>危険Ｓレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate43 kikensrate43}</td><td>危険Ｓレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate44 kikensrate44}</td><td>危険Ｓレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate45 kikensrate45}</td><td>危険Ｓレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate46 kikensrate46}</td><td>危険Ｓレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate47 kikensrate47}</td><td>危険Ｓレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate48 kikensrate48}</td><td>危険Ｓレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate49 kikensrate49}</td><td>危険Ｓレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate50 kikensrate50}</td><td>危険Ｓレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate51 kikensrate51}</td><td>危険Ｓレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate52 kikensrate52}</td><td>危険Ｓレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate53 kikensrate53}</td><td>危険Ｓレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate54 kikensrate54}</td><td>危険Ｓレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate55 kikensrate55}</td><td>危険Ｓレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate56 kikensrate56}</td><td>危険Ｓレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate57 kikensrate57}</td><td>危険Ｓレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate58 kikensrate58}</td><td>危険Ｓレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate59 kikensrate59}</td><td>危険Ｓレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate60 kikensrate60}</td><td>危険Ｓレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate61 kikensrate61}</td><td>危険Ｓレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate62 kikensrate62}</td><td>危険Ｓレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate63 kikensrate63}</td><td>危険Ｓレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate64 kikensrate64}</td><td>危険Ｓレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate65 kikensrate65}</td><td>危険Ｓレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate66 kikensrate66}</td><td>危険Ｓレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate67 kikensrate67}</td><td>危険Ｓレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate68 kikensrate68}</td><td>危険Ｓレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate69 kikensrate69}</td><td>危険Ｓレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate70 kikensrate70}</td><td>危険Ｓレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate71 kikensrate71}</td><td>危険Ｓレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate72 kikensrate72}</td><td>危険Ｓレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate73 kikensrate73}</td><td>危険Ｓレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate74 kikensrate74}</td><td>危険Ｓレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate75 kikensrate75}</td><td>危険Ｓレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate76 kikensrate76}</td><td>危険Ｓレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate77 kikensrate77}</td><td>危険Ｓレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate78 kikensrate78}</td><td>危険Ｓレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate79 kikensrate79}</td><td>危険Ｓレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate80 kikensrate80}</td><td>危険Ｓレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate81 kikensrate81}</td><td>危険Ｓレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate82 kikensrate82}</td><td>危険Ｓレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate83 kikensrate83}</td><td>危険Ｓレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate84 kikensrate84}</td><td>危険Ｓレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate85 kikensrate85}</td><td>危険Ｓレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate86 kikensrate86}</td><td>危険Ｓレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate87 kikensrate87}</td><td>危険Ｓレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate88 kikensrate88}</td><td>危険Ｓレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate89 kikensrate89}</td><td>危険Ｓレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate90 kikensrate90}</td><td>危険Ｓレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate91 kikensrate91}</td><td>危険Ｓレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate92 kikensrate92}</td><td>危険Ｓレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate93 kikensrate93}</td><td>危険Ｓレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate94 kikensrate94}</td><td>危険Ｓレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate95 kikensrate95}</td><td>危険Ｓレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate96 kikensrate96}</td><td>危険Ｓレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate97 kikensrate97}</td><td>危険Ｓレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate98 kikensrate98}</td><td>危険Ｓレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getKikensrate99 kikensrate99}</td><td>危険Ｓレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_RateD
 * @see     PKBM_RateD
 * @see     QBM_RateD
 * @see     GenQBM_RateD
 */
@MappedSuperclass
@Table(name=GenBM_RateD.TABLE_NAME)
@IdClass(value=PKBM_RateD.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_RateD extends AbstractExDBEntity<BM_RateD, PKBM_RateD> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_RateD";
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
    public static final String SISADRATE00              = "sisadrate00";
    public static final String SISADRATE01              = "sisadrate01";
    public static final String SISADRATE02              = "sisadrate02";
    public static final String SISADRATE03              = "sisadrate03";
    public static final String SISADRATE04              = "sisadrate04";
    public static final String SISADRATE05              = "sisadrate05";
    public static final String SISADRATE06              = "sisadrate06";
    public static final String SISADRATE07              = "sisadrate07";
    public static final String SISADRATE08              = "sisadrate08";
    public static final String SISADRATE09              = "sisadrate09";
    public static final String SISADRATE10              = "sisadrate10";
    public static final String SISADRATE11              = "sisadrate11";
    public static final String SISADRATE12              = "sisadrate12";
    public static final String SISADRATE13              = "sisadrate13";
    public static final String SISADRATE14              = "sisadrate14";
    public static final String SISADRATE15              = "sisadrate15";
    public static final String SISADRATE16              = "sisadrate16";
    public static final String SISADRATE17              = "sisadrate17";
    public static final String SISADRATE18              = "sisadrate18";
    public static final String SISADRATE19              = "sisadrate19";
    public static final String SISADRATE20              = "sisadrate20";
    public static final String SISADRATE21              = "sisadrate21";
    public static final String SISADRATE22              = "sisadrate22";
    public static final String SISADRATE23              = "sisadrate23";
    public static final String SISADRATE24              = "sisadrate24";
    public static final String SISADRATE25              = "sisadrate25";
    public static final String SISADRATE26              = "sisadrate26";
    public static final String SISADRATE27              = "sisadrate27";
    public static final String SISADRATE28              = "sisadrate28";
    public static final String SISADRATE29              = "sisadrate29";
    public static final String SISADRATE30              = "sisadrate30";
    public static final String SISADRATE31              = "sisadrate31";
    public static final String SISADRATE32              = "sisadrate32";
    public static final String SISADRATE33              = "sisadrate33";
    public static final String SISADRATE34              = "sisadrate34";
    public static final String SISADRATE35              = "sisadrate35";
    public static final String SISADRATE36              = "sisadrate36";
    public static final String SISADRATE37              = "sisadrate37";
    public static final String SISADRATE38              = "sisadrate38";
    public static final String SISADRATE39              = "sisadrate39";
    public static final String SISADRATE40              = "sisadrate40";
    public static final String SISADRATE41              = "sisadrate41";
    public static final String SISADRATE42              = "sisadrate42";
    public static final String SISADRATE43              = "sisadrate43";
    public static final String SISADRATE44              = "sisadrate44";
    public static final String SISADRATE45              = "sisadrate45";
    public static final String SISADRATE46              = "sisadrate46";
    public static final String SISADRATE47              = "sisadrate47";
    public static final String SISADRATE48              = "sisadrate48";
    public static final String SISADRATE49              = "sisadrate49";
    public static final String SISADRATE50              = "sisadrate50";
    public static final String SISADRATE51              = "sisadrate51";
    public static final String SISADRATE52              = "sisadrate52";
    public static final String SISADRATE53              = "sisadrate53";
    public static final String SISADRATE54              = "sisadrate54";
    public static final String SISADRATE55              = "sisadrate55";
    public static final String SISADRATE56              = "sisadrate56";
    public static final String SISADRATE57              = "sisadrate57";
    public static final String SISADRATE58              = "sisadrate58";
    public static final String SISADRATE59              = "sisadrate59";
    public static final String SISADRATE60              = "sisadrate60";
    public static final String SISADRATE61              = "sisadrate61";
    public static final String SISADRATE62              = "sisadrate62";
    public static final String SISADRATE63              = "sisadrate63";
    public static final String SISADRATE64              = "sisadrate64";
    public static final String SISADRATE65              = "sisadrate65";
    public static final String SISADRATE66              = "sisadrate66";
    public static final String SISADRATE67              = "sisadrate67";
    public static final String SISADRATE68              = "sisadrate68";
    public static final String SISADRATE69              = "sisadrate69";
    public static final String SISADRATE70              = "sisadrate70";
    public static final String SISADRATE71              = "sisadrate71";
    public static final String SISADRATE72              = "sisadrate72";
    public static final String SISADRATE73              = "sisadrate73";
    public static final String SISADRATE74              = "sisadrate74";
    public static final String SISADRATE75              = "sisadrate75";
    public static final String SISADRATE76              = "sisadrate76";
    public static final String SISADRATE77              = "sisadrate77";
    public static final String SISADRATE78              = "sisadrate78";
    public static final String SISADRATE79              = "sisadrate79";
    public static final String SISADRATE80              = "sisadrate80";
    public static final String SISADRATE81              = "sisadrate81";
    public static final String SISADRATE82              = "sisadrate82";
    public static final String SISADRATE83              = "sisadrate83";
    public static final String SISADRATE84              = "sisadrate84";
    public static final String SISADRATE85              = "sisadrate85";
    public static final String SISADRATE86              = "sisadrate86";
    public static final String SISADRATE87              = "sisadrate87";
    public static final String SISADRATE88              = "sisadrate88";
    public static final String SISADRATE89              = "sisadrate89";
    public static final String SISADRATE90              = "sisadrate90";
    public static final String SISADRATE91              = "sisadrate91";
    public static final String SISADRATE92              = "sisadrate92";
    public static final String SISADRATE93              = "sisadrate93";
    public static final String SISADRATE94              = "sisadrate94";
    public static final String SISADRATE95              = "sisadrate95";
    public static final String SISADRATE96              = "sisadrate96";
    public static final String SISADRATE97              = "sisadrate97";
    public static final String SISADRATE98              = "sisadrate98";
    public static final String SISADRATE99              = "sisadrate99";
    public static final String RISADRATE00              = "risadrate00";
    public static final String RISADRATE01              = "risadrate01";
    public static final String RISADRATE02              = "risadrate02";
    public static final String RISADRATE03              = "risadrate03";
    public static final String RISADRATE04              = "risadrate04";
    public static final String RISADRATE05              = "risadrate05";
    public static final String RISADRATE06              = "risadrate06";
    public static final String RISADRATE07              = "risadrate07";
    public static final String RISADRATE08              = "risadrate08";
    public static final String RISADRATE09              = "risadrate09";
    public static final String RISADRATE10              = "risadrate10";
    public static final String RISADRATE11              = "risadrate11";
    public static final String RISADRATE12              = "risadrate12";
    public static final String RISADRATE13              = "risadrate13";
    public static final String RISADRATE14              = "risadrate14";
    public static final String RISADRATE15              = "risadrate15";
    public static final String RISADRATE16              = "risadrate16";
    public static final String RISADRATE17              = "risadrate17";
    public static final String RISADRATE18              = "risadrate18";
    public static final String RISADRATE19              = "risadrate19";
    public static final String RISADRATE20              = "risadrate20";
    public static final String RISADRATE21              = "risadrate21";
    public static final String RISADRATE22              = "risadrate22";
    public static final String RISADRATE23              = "risadrate23";
    public static final String RISADRATE24              = "risadrate24";
    public static final String RISADRATE25              = "risadrate25";
    public static final String RISADRATE26              = "risadrate26";
    public static final String RISADRATE27              = "risadrate27";
    public static final String RISADRATE28              = "risadrate28";
    public static final String RISADRATE29              = "risadrate29";
    public static final String RISADRATE30              = "risadrate30";
    public static final String RISADRATE31              = "risadrate31";
    public static final String RISADRATE32              = "risadrate32";
    public static final String RISADRATE33              = "risadrate33";
    public static final String RISADRATE34              = "risadrate34";
    public static final String RISADRATE35              = "risadrate35";
    public static final String RISADRATE36              = "risadrate36";
    public static final String RISADRATE37              = "risadrate37";
    public static final String RISADRATE38              = "risadrate38";
    public static final String RISADRATE39              = "risadrate39";
    public static final String RISADRATE40              = "risadrate40";
    public static final String RISADRATE41              = "risadrate41";
    public static final String RISADRATE42              = "risadrate42";
    public static final String RISADRATE43              = "risadrate43";
    public static final String RISADRATE44              = "risadrate44";
    public static final String RISADRATE45              = "risadrate45";
    public static final String RISADRATE46              = "risadrate46";
    public static final String RISADRATE47              = "risadrate47";
    public static final String RISADRATE48              = "risadrate48";
    public static final String RISADRATE49              = "risadrate49";
    public static final String RISADRATE50              = "risadrate50";
    public static final String RISADRATE51              = "risadrate51";
    public static final String RISADRATE52              = "risadrate52";
    public static final String RISADRATE53              = "risadrate53";
    public static final String RISADRATE54              = "risadrate54";
    public static final String RISADRATE55              = "risadrate55";
    public static final String RISADRATE56              = "risadrate56";
    public static final String RISADRATE57              = "risadrate57";
    public static final String RISADRATE58              = "risadrate58";
    public static final String RISADRATE59              = "risadrate59";
    public static final String RISADRATE60              = "risadrate60";
    public static final String RISADRATE61              = "risadrate61";
    public static final String RISADRATE62              = "risadrate62";
    public static final String RISADRATE63              = "risadrate63";
    public static final String RISADRATE64              = "risadrate64";
    public static final String RISADRATE65              = "risadrate65";
    public static final String RISADRATE66              = "risadrate66";
    public static final String RISADRATE67              = "risadrate67";
    public static final String RISADRATE68              = "risadrate68";
    public static final String RISADRATE69              = "risadrate69";
    public static final String RISADRATE70              = "risadrate70";
    public static final String RISADRATE71              = "risadrate71";
    public static final String RISADRATE72              = "risadrate72";
    public static final String RISADRATE73              = "risadrate73";
    public static final String RISADRATE74              = "risadrate74";
    public static final String RISADRATE75              = "risadrate75";
    public static final String RISADRATE76              = "risadrate76";
    public static final String RISADRATE77              = "risadrate77";
    public static final String RISADRATE78              = "risadrate78";
    public static final String RISADRATE79              = "risadrate79";
    public static final String RISADRATE80              = "risadrate80";
    public static final String RISADRATE81              = "risadrate81";
    public static final String RISADRATE82              = "risadrate82";
    public static final String RISADRATE83              = "risadrate83";
    public static final String RISADRATE84              = "risadrate84";
    public static final String RISADRATE85              = "risadrate85";
    public static final String RISADRATE86              = "risadrate86";
    public static final String RISADRATE87              = "risadrate87";
    public static final String RISADRATE88              = "risadrate88";
    public static final String RISADRATE89              = "risadrate89";
    public static final String RISADRATE90              = "risadrate90";
    public static final String RISADRATE91              = "risadrate91";
    public static final String RISADRATE92              = "risadrate92";
    public static final String RISADRATE93              = "risadrate93";
    public static final String RISADRATE94              = "risadrate94";
    public static final String RISADRATE95              = "risadrate95";
    public static final String RISADRATE96              = "risadrate96";
    public static final String RISADRATE97              = "risadrate97";
    public static final String RISADRATE98              = "risadrate98";
    public static final String RISADRATE99              = "risadrate99";
    public static final String HISADRATE00              = "hisadrate00";
    public static final String HISADRATE01              = "hisadrate01";
    public static final String HISADRATE02              = "hisadrate02";
    public static final String HISADRATE03              = "hisadrate03";
    public static final String HISADRATE04              = "hisadrate04";
    public static final String HISADRATE05              = "hisadrate05";
    public static final String HISADRATE06              = "hisadrate06";
    public static final String HISADRATE07              = "hisadrate07";
    public static final String HISADRATE08              = "hisadrate08";
    public static final String HISADRATE09              = "hisadrate09";
    public static final String HISADRATE10              = "hisadrate10";
    public static final String HISADRATE11              = "hisadrate11";
    public static final String HISADRATE12              = "hisadrate12";
    public static final String HISADRATE13              = "hisadrate13";
    public static final String HISADRATE14              = "hisadrate14";
    public static final String HISADRATE15              = "hisadrate15";
    public static final String HISADRATE16              = "hisadrate16";
    public static final String HISADRATE17              = "hisadrate17";
    public static final String HISADRATE18              = "hisadrate18";
    public static final String HISADRATE19              = "hisadrate19";
    public static final String HISADRATE20              = "hisadrate20";
    public static final String HISADRATE21              = "hisadrate21";
    public static final String HISADRATE22              = "hisadrate22";
    public static final String HISADRATE23              = "hisadrate23";
    public static final String HISADRATE24              = "hisadrate24";
    public static final String HISADRATE25              = "hisadrate25";
    public static final String HISADRATE26              = "hisadrate26";
    public static final String HISADRATE27              = "hisadrate27";
    public static final String HISADRATE28              = "hisadrate28";
    public static final String HISADRATE29              = "hisadrate29";
    public static final String HISADRATE30              = "hisadrate30";
    public static final String HISADRATE31              = "hisadrate31";
    public static final String HISADRATE32              = "hisadrate32";
    public static final String HISADRATE33              = "hisadrate33";
    public static final String HISADRATE34              = "hisadrate34";
    public static final String HISADRATE35              = "hisadrate35";
    public static final String HISADRATE36              = "hisadrate36";
    public static final String HISADRATE37              = "hisadrate37";
    public static final String HISADRATE38              = "hisadrate38";
    public static final String HISADRATE39              = "hisadrate39";
    public static final String HISADRATE40              = "hisadrate40";
    public static final String HISADRATE41              = "hisadrate41";
    public static final String HISADRATE42              = "hisadrate42";
    public static final String HISADRATE43              = "hisadrate43";
    public static final String HISADRATE44              = "hisadrate44";
    public static final String HISADRATE45              = "hisadrate45";
    public static final String HISADRATE46              = "hisadrate46";
    public static final String HISADRATE47              = "hisadrate47";
    public static final String HISADRATE48              = "hisadrate48";
    public static final String HISADRATE49              = "hisadrate49";
    public static final String HISADRATE50              = "hisadrate50";
    public static final String HISADRATE51              = "hisadrate51";
    public static final String HISADRATE52              = "hisadrate52";
    public static final String HISADRATE53              = "hisadrate53";
    public static final String HISADRATE54              = "hisadrate54";
    public static final String HISADRATE55              = "hisadrate55";
    public static final String HISADRATE56              = "hisadrate56";
    public static final String HISADRATE57              = "hisadrate57";
    public static final String HISADRATE58              = "hisadrate58";
    public static final String HISADRATE59              = "hisadrate59";
    public static final String HISADRATE60              = "hisadrate60";
    public static final String HISADRATE61              = "hisadrate61";
    public static final String HISADRATE62              = "hisadrate62";
    public static final String HISADRATE63              = "hisadrate63";
    public static final String HISADRATE64              = "hisadrate64";
    public static final String HISADRATE65              = "hisadrate65";
    public static final String HISADRATE66              = "hisadrate66";
    public static final String HISADRATE67              = "hisadrate67";
    public static final String HISADRATE68              = "hisadrate68";
    public static final String HISADRATE69              = "hisadrate69";
    public static final String HISADRATE70              = "hisadrate70";
    public static final String HISADRATE71              = "hisadrate71";
    public static final String HISADRATE72              = "hisadrate72";
    public static final String HISADRATE73              = "hisadrate73";
    public static final String HISADRATE74              = "hisadrate74";
    public static final String HISADRATE75              = "hisadrate75";
    public static final String HISADRATE76              = "hisadrate76";
    public static final String HISADRATE77              = "hisadrate77";
    public static final String HISADRATE78              = "hisadrate78";
    public static final String HISADRATE79              = "hisadrate79";
    public static final String HISADRATE80              = "hisadrate80";
    public static final String HISADRATE81              = "hisadrate81";
    public static final String HISADRATE82              = "hisadrate82";
    public static final String HISADRATE83              = "hisadrate83";
    public static final String HISADRATE84              = "hisadrate84";
    public static final String HISADRATE85              = "hisadrate85";
    public static final String HISADRATE86              = "hisadrate86";
    public static final String HISADRATE87              = "hisadrate87";
    public static final String HISADRATE88              = "hisadrate88";
    public static final String HISADRATE89              = "hisadrate89";
    public static final String HISADRATE90              = "hisadrate90";
    public static final String HISADRATE91              = "hisadrate91";
    public static final String HISADRATE92              = "hisadrate92";
    public static final String HISADRATE93              = "hisadrate93";
    public static final String HISADRATE94              = "hisadrate94";
    public static final String HISADRATE95              = "hisadrate95";
    public static final String HISADRATE96              = "hisadrate96";
    public static final String HISADRATE97              = "hisadrate97";
    public static final String HISADRATE98              = "hisadrate98";
    public static final String HISADRATE99              = "hisadrate99";
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
    public static final String KIKENSRATE00             = "kikensrate00";
    public static final String KIKENSRATE01             = "kikensrate01";
    public static final String KIKENSRATE02             = "kikensrate02";
    public static final String KIKENSRATE03             = "kikensrate03";
    public static final String KIKENSRATE04             = "kikensrate04";
    public static final String KIKENSRATE05             = "kikensrate05";
    public static final String KIKENSRATE06             = "kikensrate06";
    public static final String KIKENSRATE07             = "kikensrate07";
    public static final String KIKENSRATE08             = "kikensrate08";
    public static final String KIKENSRATE09             = "kikensrate09";
    public static final String KIKENSRATE10             = "kikensrate10";
    public static final String KIKENSRATE11             = "kikensrate11";
    public static final String KIKENSRATE12             = "kikensrate12";
    public static final String KIKENSRATE13             = "kikensrate13";
    public static final String KIKENSRATE14             = "kikensrate14";
    public static final String KIKENSRATE15             = "kikensrate15";
    public static final String KIKENSRATE16             = "kikensrate16";
    public static final String KIKENSRATE17             = "kikensrate17";
    public static final String KIKENSRATE18             = "kikensrate18";
    public static final String KIKENSRATE19             = "kikensrate19";
    public static final String KIKENSRATE20             = "kikensrate20";
    public static final String KIKENSRATE21             = "kikensrate21";
    public static final String KIKENSRATE22             = "kikensrate22";
    public static final String KIKENSRATE23             = "kikensrate23";
    public static final String KIKENSRATE24             = "kikensrate24";
    public static final String KIKENSRATE25             = "kikensrate25";
    public static final String KIKENSRATE26             = "kikensrate26";
    public static final String KIKENSRATE27             = "kikensrate27";
    public static final String KIKENSRATE28             = "kikensrate28";
    public static final String KIKENSRATE29             = "kikensrate29";
    public static final String KIKENSRATE30             = "kikensrate30";
    public static final String KIKENSRATE31             = "kikensrate31";
    public static final String KIKENSRATE32             = "kikensrate32";
    public static final String KIKENSRATE33             = "kikensrate33";
    public static final String KIKENSRATE34             = "kikensrate34";
    public static final String KIKENSRATE35             = "kikensrate35";
    public static final String KIKENSRATE36             = "kikensrate36";
    public static final String KIKENSRATE37             = "kikensrate37";
    public static final String KIKENSRATE38             = "kikensrate38";
    public static final String KIKENSRATE39             = "kikensrate39";
    public static final String KIKENSRATE40             = "kikensrate40";
    public static final String KIKENSRATE41             = "kikensrate41";
    public static final String KIKENSRATE42             = "kikensrate42";
    public static final String KIKENSRATE43             = "kikensrate43";
    public static final String KIKENSRATE44             = "kikensrate44";
    public static final String KIKENSRATE45             = "kikensrate45";
    public static final String KIKENSRATE46             = "kikensrate46";
    public static final String KIKENSRATE47             = "kikensrate47";
    public static final String KIKENSRATE48             = "kikensrate48";
    public static final String KIKENSRATE49             = "kikensrate49";
    public static final String KIKENSRATE50             = "kikensrate50";
    public static final String KIKENSRATE51             = "kikensrate51";
    public static final String KIKENSRATE52             = "kikensrate52";
    public static final String KIKENSRATE53             = "kikensrate53";
    public static final String KIKENSRATE54             = "kikensrate54";
    public static final String KIKENSRATE55             = "kikensrate55";
    public static final String KIKENSRATE56             = "kikensrate56";
    public static final String KIKENSRATE57             = "kikensrate57";
    public static final String KIKENSRATE58             = "kikensrate58";
    public static final String KIKENSRATE59             = "kikensrate59";
    public static final String KIKENSRATE60             = "kikensrate60";
    public static final String KIKENSRATE61             = "kikensrate61";
    public static final String KIKENSRATE62             = "kikensrate62";
    public static final String KIKENSRATE63             = "kikensrate63";
    public static final String KIKENSRATE64             = "kikensrate64";
    public static final String KIKENSRATE65             = "kikensrate65";
    public static final String KIKENSRATE66             = "kikensrate66";
    public static final String KIKENSRATE67             = "kikensrate67";
    public static final String KIKENSRATE68             = "kikensrate68";
    public static final String KIKENSRATE69             = "kikensrate69";
    public static final String KIKENSRATE70             = "kikensrate70";
    public static final String KIKENSRATE71             = "kikensrate71";
    public static final String KIKENSRATE72             = "kikensrate72";
    public static final String KIKENSRATE73             = "kikensrate73";
    public static final String KIKENSRATE74             = "kikensrate74";
    public static final String KIKENSRATE75             = "kikensrate75";
    public static final String KIKENSRATE76             = "kikensrate76";
    public static final String KIKENSRATE77             = "kikensrate77";
    public static final String KIKENSRATE78             = "kikensrate78";
    public static final String KIKENSRATE79             = "kikensrate79";
    public static final String KIKENSRATE80             = "kikensrate80";
    public static final String KIKENSRATE81             = "kikensrate81";
    public static final String KIKENSRATE82             = "kikensrate82";
    public static final String KIKENSRATE83             = "kikensrate83";
    public static final String KIKENSRATE84             = "kikensrate84";
    public static final String KIKENSRATE85             = "kikensrate85";
    public static final String KIKENSRATE86             = "kikensrate86";
    public static final String KIKENSRATE87             = "kikensrate87";
    public static final String KIKENSRATE88             = "kikensrate88";
    public static final String KIKENSRATE89             = "kikensrate89";
    public static final String KIKENSRATE90             = "kikensrate90";
    public static final String KIKENSRATE91             = "kikensrate91";
    public static final String KIKENSRATE92             = "kikensrate92";
    public static final String KIKENSRATE93             = "kikensrate93";
    public static final String KIKENSRATE94             = "kikensrate94";
    public static final String KIKENSRATE95             = "kikensrate95";
    public static final String KIKENSRATE96             = "kikensrate96";
    public static final String KIKENSRATE97             = "kikensrate97";
    public static final String KIKENSRATE98             = "kikensrate98";
    public static final String KIKENSRATE99             = "kikensrate99";

    private final PKBM_RateD primaryKey;

    public GenBM_RateD() {
        primaryKey = new PKBM_RateD();
    }

    public GenBM_RateD(
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
        String pPaldnendo,
        String pPaldratenaikakucode
    ) {
        primaryKey = new PKBM_RateD(
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
            pPaldnendo,
            pPaldratenaikakucode
        );
    }

    @Transient
    @Override
    public PKBM_RateD getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_RateD> getMetaClass() {
        return QBM_RateD.class;
    }

    @Id
    @Column(name=GenBM_RateD.PALHOKENSYURUIKIGOU)
    public String getPalhokensyuruikigou() {
        return getPrimaryKey().getPalhokensyuruikigou();
    }

    public void setPalhokensyuruikigou(String pPalhokensyuruikigou) {
        getPrimaryKey().setPalhokensyuruikigou(pPalhokensyuruikigou);
    }

    @Id
    @Column(name=GenBM_RateD.PALHOKENSYURUIKIGOUSDICODE)
    public String getPalhokensyuruikigousdicode() {
        return getPrimaryKey().getPalhokensyuruikigousdicode();
    }

    public void setPalhokensyuruikigousdicode(String pPalhokensyuruikigousdicode) {
        getPrimaryKey().setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
    }

    @Id
    @Column(name=GenBM_RateD.PALYOTEIRIRITU)
    public String getPalyoteiriritu() {
        return getPrimaryKey().getPalyoteiriritu();
    }

    public void setPalyoteiriritu(String pPalyoteiriritu) {
        getPrimaryKey().setPalyoteiriritu(pPalyoteiriritu);
    }

    @Id
    @Column(name=GenBM_RateD.PALPMENCODE)
    public String getPalpmencode() {
        return getPrimaryKey().getPalpmencode();
    }

    public void setPalpmencode(String pPalpmencode) {
        getPrimaryKey().setPalpmencode(pPalpmencode);
    }

    @Id
    @Column(name=GenBM_RateD.PALHARAIKOMIKAISUU)
    public String getPalharaikomikaisuu() {
        return getPrimaryKey().getPalharaikomikaisuu();
    }

    public void setPalharaikomikaisuu(String pPalharaikomikaisuu) {
        getPrimaryKey().setPalharaikomikaisuu(pPalharaikomikaisuu);
    }

    @Id
    @Column(name=GenBM_RateD.PALHHKNSEI)
    public String getPalhhknsei() {
        return getPrimaryKey().getPalhhknsei();
    }

    public void setPalhhknsei(String pPalhhknsei) {
        getPrimaryKey().setPalhhknsei(pPalhhknsei);
    }

    @Id
    @Column(name=GenBM_RateD.PALKEIYAKUJIHHKNNEN)
    public String getPalkeiyakujihhknnen() {
        return getPrimaryKey().getPalkeiyakujihhknnen();
    }

    public void setPalkeiyakujihhknnen(String pPalkeiyakujihhknnen) {
        getPrimaryKey().setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
    }

    @Id
    @Column(name=GenBM_RateD.PALSAIMANKIHYOUJI)
    public String getPalsaimankihyouji() {
        return getPrimaryKey().getPalsaimankihyouji();
    }

    public void setPalsaimankihyouji(String pPalsaimankihyouji) {
        getPrimaryKey().setPalsaimankihyouji(pPalsaimankihyouji);
    }

    @Id
    @Column(name=GenBM_RateD.PALHOKENKIKAN)
    public String getPalhokenkikan() {
        return getPrimaryKey().getPalhokenkikan();
    }

    public void setPalhokenkikan(String pPalhokenkikan) {
        getPrimaryKey().setPalhokenkikan(pPalhokenkikan);
    }

    @Id
    @Column(name=GenBM_RateD.PALPHARAIKOMIKIKAN)
    public String getPalpharaikomikikan() {
        return getPrimaryKey().getPalpharaikomikikan();
    }

    public void setPalpharaikomikikan(String pPalpharaikomikikan) {
        getPrimaryKey().setPalpharaikomikikan(pPalpharaikomikikan);
    }

    @Id
    @Column(name=GenBM_RateD.PALDNENDO)
    public String getPaldnendo() {
        return getPrimaryKey().getPaldnendo();
    }

    public void setPaldnendo(String pPaldnendo) {
        getPrimaryKey().setPaldnendo(pPaldnendo);
    }

    @Id
    @Column(name=GenBM_RateD.PALDRATENAIKAKUCODE)
    public String getPaldratenaikakucode() {
        return getPrimaryKey().getPaldratenaikakucode();
    }

    public void setPaldratenaikakucode(String pPaldratenaikakucode) {
        getPrimaryKey().setPaldratenaikakucode(pPaldratenaikakucode);
    }

    private BizNumber drate00;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE00)
    public BizNumber getDrate00() {
        return drate00;
    }

    public void setDrate00(BizNumber pDrate00) {
        drate00 = pDrate00;
    }

    private BizNumber drate01;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE01)
    public BizNumber getDrate01() {
        return drate01;
    }

    public void setDrate01(BizNumber pDrate01) {
        drate01 = pDrate01;
    }

    private BizNumber drate02;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE02)
    public BizNumber getDrate02() {
        return drate02;
    }

    public void setDrate02(BizNumber pDrate02) {
        drate02 = pDrate02;
    }

    private BizNumber drate03;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE03)
    public BizNumber getDrate03() {
        return drate03;
    }

    public void setDrate03(BizNumber pDrate03) {
        drate03 = pDrate03;
    }

    private BizNumber drate04;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE04)
    public BizNumber getDrate04() {
        return drate04;
    }

    public void setDrate04(BizNumber pDrate04) {
        drate04 = pDrate04;
    }

    private BizNumber drate05;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE05)
    public BizNumber getDrate05() {
        return drate05;
    }

    public void setDrate05(BizNumber pDrate05) {
        drate05 = pDrate05;
    }

    private BizNumber drate06;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE06)
    public BizNumber getDrate06() {
        return drate06;
    }

    public void setDrate06(BizNumber pDrate06) {
        drate06 = pDrate06;
    }

    private BizNumber drate07;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE07)
    public BizNumber getDrate07() {
        return drate07;
    }

    public void setDrate07(BizNumber pDrate07) {
        drate07 = pDrate07;
    }

    private BizNumber drate08;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE08)
    public BizNumber getDrate08() {
        return drate08;
    }

    public void setDrate08(BizNumber pDrate08) {
        drate08 = pDrate08;
    }

    private BizNumber drate09;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE09)
    public BizNumber getDrate09() {
        return drate09;
    }

    public void setDrate09(BizNumber pDrate09) {
        drate09 = pDrate09;
    }

    private BizNumber drate10;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE10)
    public BizNumber getDrate10() {
        return drate10;
    }

    public void setDrate10(BizNumber pDrate10) {
        drate10 = pDrate10;
    }

    private BizNumber drate11;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE11)
    public BizNumber getDrate11() {
        return drate11;
    }

    public void setDrate11(BizNumber pDrate11) {
        drate11 = pDrate11;
    }

    private BizNumber drate12;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE12)
    public BizNumber getDrate12() {
        return drate12;
    }

    public void setDrate12(BizNumber pDrate12) {
        drate12 = pDrate12;
    }

    private BizNumber drate13;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE13)
    public BizNumber getDrate13() {
        return drate13;
    }

    public void setDrate13(BizNumber pDrate13) {
        drate13 = pDrate13;
    }

    private BizNumber drate14;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE14)
    public BizNumber getDrate14() {
        return drate14;
    }

    public void setDrate14(BizNumber pDrate14) {
        drate14 = pDrate14;
    }

    private BizNumber drate15;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE15)
    public BizNumber getDrate15() {
        return drate15;
    }

    public void setDrate15(BizNumber pDrate15) {
        drate15 = pDrate15;
    }

    private BizNumber drate16;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE16)
    public BizNumber getDrate16() {
        return drate16;
    }

    public void setDrate16(BizNumber pDrate16) {
        drate16 = pDrate16;
    }

    private BizNumber drate17;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE17)
    public BizNumber getDrate17() {
        return drate17;
    }

    public void setDrate17(BizNumber pDrate17) {
        drate17 = pDrate17;
    }

    private BizNumber drate18;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE18)
    public BizNumber getDrate18() {
        return drate18;
    }

    public void setDrate18(BizNumber pDrate18) {
        drate18 = pDrate18;
    }

    private BizNumber drate19;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE19)
    public BizNumber getDrate19() {
        return drate19;
    }

    public void setDrate19(BizNumber pDrate19) {
        drate19 = pDrate19;
    }

    private BizNumber drate20;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE20)
    public BizNumber getDrate20() {
        return drate20;
    }

    public void setDrate20(BizNumber pDrate20) {
        drate20 = pDrate20;
    }

    private BizNumber drate21;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE21)
    public BizNumber getDrate21() {
        return drate21;
    }

    public void setDrate21(BizNumber pDrate21) {
        drate21 = pDrate21;
    }

    private BizNumber drate22;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE22)
    public BizNumber getDrate22() {
        return drate22;
    }

    public void setDrate22(BizNumber pDrate22) {
        drate22 = pDrate22;
    }

    private BizNumber drate23;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE23)
    public BizNumber getDrate23() {
        return drate23;
    }

    public void setDrate23(BizNumber pDrate23) {
        drate23 = pDrate23;
    }

    private BizNumber drate24;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE24)
    public BizNumber getDrate24() {
        return drate24;
    }

    public void setDrate24(BizNumber pDrate24) {
        drate24 = pDrate24;
    }

    private BizNumber drate25;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE25)
    public BizNumber getDrate25() {
        return drate25;
    }

    public void setDrate25(BizNumber pDrate25) {
        drate25 = pDrate25;
    }

    private BizNumber drate26;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE26)
    public BizNumber getDrate26() {
        return drate26;
    }

    public void setDrate26(BizNumber pDrate26) {
        drate26 = pDrate26;
    }

    private BizNumber drate27;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE27)
    public BizNumber getDrate27() {
        return drate27;
    }

    public void setDrate27(BizNumber pDrate27) {
        drate27 = pDrate27;
    }

    private BizNumber drate28;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE28)
    public BizNumber getDrate28() {
        return drate28;
    }

    public void setDrate28(BizNumber pDrate28) {
        drate28 = pDrate28;
    }

    private BizNumber drate29;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE29)
    public BizNumber getDrate29() {
        return drate29;
    }

    public void setDrate29(BizNumber pDrate29) {
        drate29 = pDrate29;
    }

    private BizNumber drate30;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE30)
    public BizNumber getDrate30() {
        return drate30;
    }

    public void setDrate30(BizNumber pDrate30) {
        drate30 = pDrate30;
    }

    private BizNumber drate31;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE31)
    public BizNumber getDrate31() {
        return drate31;
    }

    public void setDrate31(BizNumber pDrate31) {
        drate31 = pDrate31;
    }

    private BizNumber drate32;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE32)
    public BizNumber getDrate32() {
        return drate32;
    }

    public void setDrate32(BizNumber pDrate32) {
        drate32 = pDrate32;
    }

    private BizNumber drate33;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE33)
    public BizNumber getDrate33() {
        return drate33;
    }

    public void setDrate33(BizNumber pDrate33) {
        drate33 = pDrate33;
    }

    private BizNumber drate34;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE34)
    public BizNumber getDrate34() {
        return drate34;
    }

    public void setDrate34(BizNumber pDrate34) {
        drate34 = pDrate34;
    }

    private BizNumber drate35;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE35)
    public BizNumber getDrate35() {
        return drate35;
    }

    public void setDrate35(BizNumber pDrate35) {
        drate35 = pDrate35;
    }

    private BizNumber drate36;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE36)
    public BizNumber getDrate36() {
        return drate36;
    }

    public void setDrate36(BizNumber pDrate36) {
        drate36 = pDrate36;
    }

    private BizNumber drate37;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE37)
    public BizNumber getDrate37() {
        return drate37;
    }

    public void setDrate37(BizNumber pDrate37) {
        drate37 = pDrate37;
    }

    private BizNumber drate38;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE38)
    public BizNumber getDrate38() {
        return drate38;
    }

    public void setDrate38(BizNumber pDrate38) {
        drate38 = pDrate38;
    }

    private BizNumber drate39;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE39)
    public BizNumber getDrate39() {
        return drate39;
    }

    public void setDrate39(BizNumber pDrate39) {
        drate39 = pDrate39;
    }

    private BizNumber drate40;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE40)
    public BizNumber getDrate40() {
        return drate40;
    }

    public void setDrate40(BizNumber pDrate40) {
        drate40 = pDrate40;
    }

    private BizNumber drate41;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE41)
    public BizNumber getDrate41() {
        return drate41;
    }

    public void setDrate41(BizNumber pDrate41) {
        drate41 = pDrate41;
    }

    private BizNumber drate42;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE42)
    public BizNumber getDrate42() {
        return drate42;
    }

    public void setDrate42(BizNumber pDrate42) {
        drate42 = pDrate42;
    }

    private BizNumber drate43;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE43)
    public BizNumber getDrate43() {
        return drate43;
    }

    public void setDrate43(BizNumber pDrate43) {
        drate43 = pDrate43;
    }

    private BizNumber drate44;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE44)
    public BizNumber getDrate44() {
        return drate44;
    }

    public void setDrate44(BizNumber pDrate44) {
        drate44 = pDrate44;
    }

    private BizNumber drate45;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE45)
    public BizNumber getDrate45() {
        return drate45;
    }

    public void setDrate45(BizNumber pDrate45) {
        drate45 = pDrate45;
    }

    private BizNumber drate46;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE46)
    public BizNumber getDrate46() {
        return drate46;
    }

    public void setDrate46(BizNumber pDrate46) {
        drate46 = pDrate46;
    }

    private BizNumber drate47;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE47)
    public BizNumber getDrate47() {
        return drate47;
    }

    public void setDrate47(BizNumber pDrate47) {
        drate47 = pDrate47;
    }

    private BizNumber drate48;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE48)
    public BizNumber getDrate48() {
        return drate48;
    }

    public void setDrate48(BizNumber pDrate48) {
        drate48 = pDrate48;
    }

    private BizNumber drate49;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE49)
    public BizNumber getDrate49() {
        return drate49;
    }

    public void setDrate49(BizNumber pDrate49) {
        drate49 = pDrate49;
    }

    private BizNumber drate50;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE50)
    public BizNumber getDrate50() {
        return drate50;
    }

    public void setDrate50(BizNumber pDrate50) {
        drate50 = pDrate50;
    }

    private BizNumber drate51;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE51)
    public BizNumber getDrate51() {
        return drate51;
    }

    public void setDrate51(BizNumber pDrate51) {
        drate51 = pDrate51;
    }

    private BizNumber drate52;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE52)
    public BizNumber getDrate52() {
        return drate52;
    }

    public void setDrate52(BizNumber pDrate52) {
        drate52 = pDrate52;
    }

    private BizNumber drate53;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE53)
    public BizNumber getDrate53() {
        return drate53;
    }

    public void setDrate53(BizNumber pDrate53) {
        drate53 = pDrate53;
    }

    private BizNumber drate54;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE54)
    public BizNumber getDrate54() {
        return drate54;
    }

    public void setDrate54(BizNumber pDrate54) {
        drate54 = pDrate54;
    }

    private BizNumber drate55;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE55)
    public BizNumber getDrate55() {
        return drate55;
    }

    public void setDrate55(BizNumber pDrate55) {
        drate55 = pDrate55;
    }

    private BizNumber drate56;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE56)
    public BizNumber getDrate56() {
        return drate56;
    }

    public void setDrate56(BizNumber pDrate56) {
        drate56 = pDrate56;
    }

    private BizNumber drate57;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE57)
    public BizNumber getDrate57() {
        return drate57;
    }

    public void setDrate57(BizNumber pDrate57) {
        drate57 = pDrate57;
    }

    private BizNumber drate58;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE58)
    public BizNumber getDrate58() {
        return drate58;
    }

    public void setDrate58(BizNumber pDrate58) {
        drate58 = pDrate58;
    }

    private BizNumber drate59;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE59)
    public BizNumber getDrate59() {
        return drate59;
    }

    public void setDrate59(BizNumber pDrate59) {
        drate59 = pDrate59;
    }

    private BizNumber drate60;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE60)
    public BizNumber getDrate60() {
        return drate60;
    }

    public void setDrate60(BizNumber pDrate60) {
        drate60 = pDrate60;
    }

    private BizNumber drate61;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE61)
    public BizNumber getDrate61() {
        return drate61;
    }

    public void setDrate61(BizNumber pDrate61) {
        drate61 = pDrate61;
    }

    private BizNumber drate62;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE62)
    public BizNumber getDrate62() {
        return drate62;
    }

    public void setDrate62(BizNumber pDrate62) {
        drate62 = pDrate62;
    }

    private BizNumber drate63;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE63)
    public BizNumber getDrate63() {
        return drate63;
    }

    public void setDrate63(BizNumber pDrate63) {
        drate63 = pDrate63;
    }

    private BizNumber drate64;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE64)
    public BizNumber getDrate64() {
        return drate64;
    }

    public void setDrate64(BizNumber pDrate64) {
        drate64 = pDrate64;
    }

    private BizNumber drate65;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE65)
    public BizNumber getDrate65() {
        return drate65;
    }

    public void setDrate65(BizNumber pDrate65) {
        drate65 = pDrate65;
    }

    private BizNumber drate66;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE66)
    public BizNumber getDrate66() {
        return drate66;
    }

    public void setDrate66(BizNumber pDrate66) {
        drate66 = pDrate66;
    }

    private BizNumber drate67;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE67)
    public BizNumber getDrate67() {
        return drate67;
    }

    public void setDrate67(BizNumber pDrate67) {
        drate67 = pDrate67;
    }

    private BizNumber drate68;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE68)
    public BizNumber getDrate68() {
        return drate68;
    }

    public void setDrate68(BizNumber pDrate68) {
        drate68 = pDrate68;
    }

    private BizNumber drate69;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE69)
    public BizNumber getDrate69() {
        return drate69;
    }

    public void setDrate69(BizNumber pDrate69) {
        drate69 = pDrate69;
    }

    private BizNumber drate70;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE70)
    public BizNumber getDrate70() {
        return drate70;
    }

    public void setDrate70(BizNumber pDrate70) {
        drate70 = pDrate70;
    }

    private BizNumber drate71;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE71)
    public BizNumber getDrate71() {
        return drate71;
    }

    public void setDrate71(BizNumber pDrate71) {
        drate71 = pDrate71;
    }

    private BizNumber drate72;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE72)
    public BizNumber getDrate72() {
        return drate72;
    }

    public void setDrate72(BizNumber pDrate72) {
        drate72 = pDrate72;
    }

    private BizNumber drate73;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE73)
    public BizNumber getDrate73() {
        return drate73;
    }

    public void setDrate73(BizNumber pDrate73) {
        drate73 = pDrate73;
    }

    private BizNumber drate74;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE74)
    public BizNumber getDrate74() {
        return drate74;
    }

    public void setDrate74(BizNumber pDrate74) {
        drate74 = pDrate74;
    }

    private BizNumber drate75;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE75)
    public BizNumber getDrate75() {
        return drate75;
    }

    public void setDrate75(BizNumber pDrate75) {
        drate75 = pDrate75;
    }

    private BizNumber drate76;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE76)
    public BizNumber getDrate76() {
        return drate76;
    }

    public void setDrate76(BizNumber pDrate76) {
        drate76 = pDrate76;
    }

    private BizNumber drate77;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE77)
    public BizNumber getDrate77() {
        return drate77;
    }

    public void setDrate77(BizNumber pDrate77) {
        drate77 = pDrate77;
    }

    private BizNumber drate78;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE78)
    public BizNumber getDrate78() {
        return drate78;
    }

    public void setDrate78(BizNumber pDrate78) {
        drate78 = pDrate78;
    }

    private BizNumber drate79;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE79)
    public BizNumber getDrate79() {
        return drate79;
    }

    public void setDrate79(BizNumber pDrate79) {
        drate79 = pDrate79;
    }

    private BizNumber drate80;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE80)
    public BizNumber getDrate80() {
        return drate80;
    }

    public void setDrate80(BizNumber pDrate80) {
        drate80 = pDrate80;
    }

    private BizNumber drate81;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE81)
    public BizNumber getDrate81() {
        return drate81;
    }

    public void setDrate81(BizNumber pDrate81) {
        drate81 = pDrate81;
    }

    private BizNumber drate82;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE82)
    public BizNumber getDrate82() {
        return drate82;
    }

    public void setDrate82(BizNumber pDrate82) {
        drate82 = pDrate82;
    }

    private BizNumber drate83;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE83)
    public BizNumber getDrate83() {
        return drate83;
    }

    public void setDrate83(BizNumber pDrate83) {
        drate83 = pDrate83;
    }

    private BizNumber drate84;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE84)
    public BizNumber getDrate84() {
        return drate84;
    }

    public void setDrate84(BizNumber pDrate84) {
        drate84 = pDrate84;
    }

    private BizNumber drate85;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE85)
    public BizNumber getDrate85() {
        return drate85;
    }

    public void setDrate85(BizNumber pDrate85) {
        drate85 = pDrate85;
    }

    private BizNumber drate86;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE86)
    public BizNumber getDrate86() {
        return drate86;
    }

    public void setDrate86(BizNumber pDrate86) {
        drate86 = pDrate86;
    }

    private BizNumber drate87;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE87)
    public BizNumber getDrate87() {
        return drate87;
    }

    public void setDrate87(BizNumber pDrate87) {
        drate87 = pDrate87;
    }

    private BizNumber drate88;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE88)
    public BizNumber getDrate88() {
        return drate88;
    }

    public void setDrate88(BizNumber pDrate88) {
        drate88 = pDrate88;
    }

    private BizNumber drate89;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE89)
    public BizNumber getDrate89() {
        return drate89;
    }

    public void setDrate89(BizNumber pDrate89) {
        drate89 = pDrate89;
    }

    private BizNumber drate90;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE90)
    public BizNumber getDrate90() {
        return drate90;
    }

    public void setDrate90(BizNumber pDrate90) {
        drate90 = pDrate90;
    }

    private BizNumber drate91;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE91)
    public BizNumber getDrate91() {
        return drate91;
    }

    public void setDrate91(BizNumber pDrate91) {
        drate91 = pDrate91;
    }

    private BizNumber drate92;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE92)
    public BizNumber getDrate92() {
        return drate92;
    }

    public void setDrate92(BizNumber pDrate92) {
        drate92 = pDrate92;
    }

    private BizNumber drate93;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE93)
    public BizNumber getDrate93() {
        return drate93;
    }

    public void setDrate93(BizNumber pDrate93) {
        drate93 = pDrate93;
    }

    private BizNumber drate94;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE94)
    public BizNumber getDrate94() {
        return drate94;
    }

    public void setDrate94(BizNumber pDrate94) {
        drate94 = pDrate94;
    }

    private BizNumber drate95;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE95)
    public BizNumber getDrate95() {
        return drate95;
    }

    public void setDrate95(BizNumber pDrate95) {
        drate95 = pDrate95;
    }

    private BizNumber drate96;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE96)
    public BizNumber getDrate96() {
        return drate96;
    }

    public void setDrate96(BizNumber pDrate96) {
        drate96 = pDrate96;
    }

    private BizNumber drate97;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE97)
    public BizNumber getDrate97() {
        return drate97;
    }

    public void setDrate97(BizNumber pDrate97) {
        drate97 = pDrate97;
    }

    private BizNumber drate98;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE98)
    public BizNumber getDrate98() {
        return drate98;
    }

    public void setDrate98(BizNumber pDrate98) {
        drate98 = pDrate98;
    }

    private BizNumber drate99;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DRATE99)
    public BizNumber getDrate99() {
        return drate99;
    }

    public void setDrate99(BizNumber pDrate99) {
        drate99 = pDrate99;
    }

    private BizNumber sisadrate00;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE00)
    public BizNumber getSisadrate00() {
        return sisadrate00;
    }

    public void setSisadrate00(BizNumber pSisadrate00) {
        sisadrate00 = pSisadrate00;
    }

    private BizNumber sisadrate01;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE01)
    public BizNumber getSisadrate01() {
        return sisadrate01;
    }

    public void setSisadrate01(BizNumber pSisadrate01) {
        sisadrate01 = pSisadrate01;
    }

    private BizNumber sisadrate02;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE02)
    public BizNumber getSisadrate02() {
        return sisadrate02;
    }

    public void setSisadrate02(BizNumber pSisadrate02) {
        sisadrate02 = pSisadrate02;
    }

    private BizNumber sisadrate03;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE03)
    public BizNumber getSisadrate03() {
        return sisadrate03;
    }

    public void setSisadrate03(BizNumber pSisadrate03) {
        sisadrate03 = pSisadrate03;
    }

    private BizNumber sisadrate04;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE04)
    public BizNumber getSisadrate04() {
        return sisadrate04;
    }

    public void setSisadrate04(BizNumber pSisadrate04) {
        sisadrate04 = pSisadrate04;
    }

    private BizNumber sisadrate05;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE05)
    public BizNumber getSisadrate05() {
        return sisadrate05;
    }

    public void setSisadrate05(BizNumber pSisadrate05) {
        sisadrate05 = pSisadrate05;
    }

    private BizNumber sisadrate06;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE06)
    public BizNumber getSisadrate06() {
        return sisadrate06;
    }

    public void setSisadrate06(BizNumber pSisadrate06) {
        sisadrate06 = pSisadrate06;
    }

    private BizNumber sisadrate07;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE07)
    public BizNumber getSisadrate07() {
        return sisadrate07;
    }

    public void setSisadrate07(BizNumber pSisadrate07) {
        sisadrate07 = pSisadrate07;
    }

    private BizNumber sisadrate08;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE08)
    public BizNumber getSisadrate08() {
        return sisadrate08;
    }

    public void setSisadrate08(BizNumber pSisadrate08) {
        sisadrate08 = pSisadrate08;
    }

    private BizNumber sisadrate09;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE09)
    public BizNumber getSisadrate09() {
        return sisadrate09;
    }

    public void setSisadrate09(BizNumber pSisadrate09) {
        sisadrate09 = pSisadrate09;
    }

    private BizNumber sisadrate10;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE10)
    public BizNumber getSisadrate10() {
        return sisadrate10;
    }

    public void setSisadrate10(BizNumber pSisadrate10) {
        sisadrate10 = pSisadrate10;
    }

    private BizNumber sisadrate11;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE11)
    public BizNumber getSisadrate11() {
        return sisadrate11;
    }

    public void setSisadrate11(BizNumber pSisadrate11) {
        sisadrate11 = pSisadrate11;
    }

    private BizNumber sisadrate12;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE12)
    public BizNumber getSisadrate12() {
        return sisadrate12;
    }

    public void setSisadrate12(BizNumber pSisadrate12) {
        sisadrate12 = pSisadrate12;
    }

    private BizNumber sisadrate13;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE13)
    public BizNumber getSisadrate13() {
        return sisadrate13;
    }

    public void setSisadrate13(BizNumber pSisadrate13) {
        sisadrate13 = pSisadrate13;
    }

    private BizNumber sisadrate14;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE14)
    public BizNumber getSisadrate14() {
        return sisadrate14;
    }

    public void setSisadrate14(BizNumber pSisadrate14) {
        sisadrate14 = pSisadrate14;
    }

    private BizNumber sisadrate15;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE15)
    public BizNumber getSisadrate15() {
        return sisadrate15;
    }

    public void setSisadrate15(BizNumber pSisadrate15) {
        sisadrate15 = pSisadrate15;
    }

    private BizNumber sisadrate16;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE16)
    public BizNumber getSisadrate16() {
        return sisadrate16;
    }

    public void setSisadrate16(BizNumber pSisadrate16) {
        sisadrate16 = pSisadrate16;
    }

    private BizNumber sisadrate17;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE17)
    public BizNumber getSisadrate17() {
        return sisadrate17;
    }

    public void setSisadrate17(BizNumber pSisadrate17) {
        sisadrate17 = pSisadrate17;
    }

    private BizNumber sisadrate18;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE18)
    public BizNumber getSisadrate18() {
        return sisadrate18;
    }

    public void setSisadrate18(BizNumber pSisadrate18) {
        sisadrate18 = pSisadrate18;
    }

    private BizNumber sisadrate19;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE19)
    public BizNumber getSisadrate19() {
        return sisadrate19;
    }

    public void setSisadrate19(BizNumber pSisadrate19) {
        sisadrate19 = pSisadrate19;
    }

    private BizNumber sisadrate20;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE20)
    public BizNumber getSisadrate20() {
        return sisadrate20;
    }

    public void setSisadrate20(BizNumber pSisadrate20) {
        sisadrate20 = pSisadrate20;
    }

    private BizNumber sisadrate21;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE21)
    public BizNumber getSisadrate21() {
        return sisadrate21;
    }

    public void setSisadrate21(BizNumber pSisadrate21) {
        sisadrate21 = pSisadrate21;
    }

    private BizNumber sisadrate22;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE22)
    public BizNumber getSisadrate22() {
        return sisadrate22;
    }

    public void setSisadrate22(BizNumber pSisadrate22) {
        sisadrate22 = pSisadrate22;
    }

    private BizNumber sisadrate23;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE23)
    public BizNumber getSisadrate23() {
        return sisadrate23;
    }

    public void setSisadrate23(BizNumber pSisadrate23) {
        sisadrate23 = pSisadrate23;
    }

    private BizNumber sisadrate24;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE24)
    public BizNumber getSisadrate24() {
        return sisadrate24;
    }

    public void setSisadrate24(BizNumber pSisadrate24) {
        sisadrate24 = pSisadrate24;
    }

    private BizNumber sisadrate25;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE25)
    public BizNumber getSisadrate25() {
        return sisadrate25;
    }

    public void setSisadrate25(BizNumber pSisadrate25) {
        sisadrate25 = pSisadrate25;
    }

    private BizNumber sisadrate26;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE26)
    public BizNumber getSisadrate26() {
        return sisadrate26;
    }

    public void setSisadrate26(BizNumber pSisadrate26) {
        sisadrate26 = pSisadrate26;
    }

    private BizNumber sisadrate27;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE27)
    public BizNumber getSisadrate27() {
        return sisadrate27;
    }

    public void setSisadrate27(BizNumber pSisadrate27) {
        sisadrate27 = pSisadrate27;
    }

    private BizNumber sisadrate28;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE28)
    public BizNumber getSisadrate28() {
        return sisadrate28;
    }

    public void setSisadrate28(BizNumber pSisadrate28) {
        sisadrate28 = pSisadrate28;
    }

    private BizNumber sisadrate29;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE29)
    public BizNumber getSisadrate29() {
        return sisadrate29;
    }

    public void setSisadrate29(BizNumber pSisadrate29) {
        sisadrate29 = pSisadrate29;
    }

    private BizNumber sisadrate30;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE30)
    public BizNumber getSisadrate30() {
        return sisadrate30;
    }

    public void setSisadrate30(BizNumber pSisadrate30) {
        sisadrate30 = pSisadrate30;
    }

    private BizNumber sisadrate31;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE31)
    public BizNumber getSisadrate31() {
        return sisadrate31;
    }

    public void setSisadrate31(BizNumber pSisadrate31) {
        sisadrate31 = pSisadrate31;
    }

    private BizNumber sisadrate32;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE32)
    public BizNumber getSisadrate32() {
        return sisadrate32;
    }

    public void setSisadrate32(BizNumber pSisadrate32) {
        sisadrate32 = pSisadrate32;
    }

    private BizNumber sisadrate33;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE33)
    public BizNumber getSisadrate33() {
        return sisadrate33;
    }

    public void setSisadrate33(BizNumber pSisadrate33) {
        sisadrate33 = pSisadrate33;
    }

    private BizNumber sisadrate34;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE34)
    public BizNumber getSisadrate34() {
        return sisadrate34;
    }

    public void setSisadrate34(BizNumber pSisadrate34) {
        sisadrate34 = pSisadrate34;
    }

    private BizNumber sisadrate35;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE35)
    public BizNumber getSisadrate35() {
        return sisadrate35;
    }

    public void setSisadrate35(BizNumber pSisadrate35) {
        sisadrate35 = pSisadrate35;
    }

    private BizNumber sisadrate36;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE36)
    public BizNumber getSisadrate36() {
        return sisadrate36;
    }

    public void setSisadrate36(BizNumber pSisadrate36) {
        sisadrate36 = pSisadrate36;
    }

    private BizNumber sisadrate37;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE37)
    public BizNumber getSisadrate37() {
        return sisadrate37;
    }

    public void setSisadrate37(BizNumber pSisadrate37) {
        sisadrate37 = pSisadrate37;
    }

    private BizNumber sisadrate38;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE38)
    public BizNumber getSisadrate38() {
        return sisadrate38;
    }

    public void setSisadrate38(BizNumber pSisadrate38) {
        sisadrate38 = pSisadrate38;
    }

    private BizNumber sisadrate39;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE39)
    public BizNumber getSisadrate39() {
        return sisadrate39;
    }

    public void setSisadrate39(BizNumber pSisadrate39) {
        sisadrate39 = pSisadrate39;
    }

    private BizNumber sisadrate40;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE40)
    public BizNumber getSisadrate40() {
        return sisadrate40;
    }

    public void setSisadrate40(BizNumber pSisadrate40) {
        sisadrate40 = pSisadrate40;
    }

    private BizNumber sisadrate41;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE41)
    public BizNumber getSisadrate41() {
        return sisadrate41;
    }

    public void setSisadrate41(BizNumber pSisadrate41) {
        sisadrate41 = pSisadrate41;
    }

    private BizNumber sisadrate42;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE42)
    public BizNumber getSisadrate42() {
        return sisadrate42;
    }

    public void setSisadrate42(BizNumber pSisadrate42) {
        sisadrate42 = pSisadrate42;
    }

    private BizNumber sisadrate43;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE43)
    public BizNumber getSisadrate43() {
        return sisadrate43;
    }

    public void setSisadrate43(BizNumber pSisadrate43) {
        sisadrate43 = pSisadrate43;
    }

    private BizNumber sisadrate44;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE44)
    public BizNumber getSisadrate44() {
        return sisadrate44;
    }

    public void setSisadrate44(BizNumber pSisadrate44) {
        sisadrate44 = pSisadrate44;
    }

    private BizNumber sisadrate45;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE45)
    public BizNumber getSisadrate45() {
        return sisadrate45;
    }

    public void setSisadrate45(BizNumber pSisadrate45) {
        sisadrate45 = pSisadrate45;
    }

    private BizNumber sisadrate46;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE46)
    public BizNumber getSisadrate46() {
        return sisadrate46;
    }

    public void setSisadrate46(BizNumber pSisadrate46) {
        sisadrate46 = pSisadrate46;
    }

    private BizNumber sisadrate47;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE47)
    public BizNumber getSisadrate47() {
        return sisadrate47;
    }

    public void setSisadrate47(BizNumber pSisadrate47) {
        sisadrate47 = pSisadrate47;
    }

    private BizNumber sisadrate48;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE48)
    public BizNumber getSisadrate48() {
        return sisadrate48;
    }

    public void setSisadrate48(BizNumber pSisadrate48) {
        sisadrate48 = pSisadrate48;
    }

    private BizNumber sisadrate49;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE49)
    public BizNumber getSisadrate49() {
        return sisadrate49;
    }

    public void setSisadrate49(BizNumber pSisadrate49) {
        sisadrate49 = pSisadrate49;
    }

    private BizNumber sisadrate50;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE50)
    public BizNumber getSisadrate50() {
        return sisadrate50;
    }

    public void setSisadrate50(BizNumber pSisadrate50) {
        sisadrate50 = pSisadrate50;
    }

    private BizNumber sisadrate51;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE51)
    public BizNumber getSisadrate51() {
        return sisadrate51;
    }

    public void setSisadrate51(BizNumber pSisadrate51) {
        sisadrate51 = pSisadrate51;
    }

    private BizNumber sisadrate52;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE52)
    public BizNumber getSisadrate52() {
        return sisadrate52;
    }

    public void setSisadrate52(BizNumber pSisadrate52) {
        sisadrate52 = pSisadrate52;
    }

    private BizNumber sisadrate53;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE53)
    public BizNumber getSisadrate53() {
        return sisadrate53;
    }

    public void setSisadrate53(BizNumber pSisadrate53) {
        sisadrate53 = pSisadrate53;
    }

    private BizNumber sisadrate54;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE54)
    public BizNumber getSisadrate54() {
        return sisadrate54;
    }

    public void setSisadrate54(BizNumber pSisadrate54) {
        sisadrate54 = pSisadrate54;
    }

    private BizNumber sisadrate55;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE55)
    public BizNumber getSisadrate55() {
        return sisadrate55;
    }

    public void setSisadrate55(BizNumber pSisadrate55) {
        sisadrate55 = pSisadrate55;
    }

    private BizNumber sisadrate56;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE56)
    public BizNumber getSisadrate56() {
        return sisadrate56;
    }

    public void setSisadrate56(BizNumber pSisadrate56) {
        sisadrate56 = pSisadrate56;
    }

    private BizNumber sisadrate57;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE57)
    public BizNumber getSisadrate57() {
        return sisadrate57;
    }

    public void setSisadrate57(BizNumber pSisadrate57) {
        sisadrate57 = pSisadrate57;
    }

    private BizNumber sisadrate58;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE58)
    public BizNumber getSisadrate58() {
        return sisadrate58;
    }

    public void setSisadrate58(BizNumber pSisadrate58) {
        sisadrate58 = pSisadrate58;
    }

    private BizNumber sisadrate59;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE59)
    public BizNumber getSisadrate59() {
        return sisadrate59;
    }

    public void setSisadrate59(BizNumber pSisadrate59) {
        sisadrate59 = pSisadrate59;
    }

    private BizNumber sisadrate60;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE60)
    public BizNumber getSisadrate60() {
        return sisadrate60;
    }

    public void setSisadrate60(BizNumber pSisadrate60) {
        sisadrate60 = pSisadrate60;
    }

    private BizNumber sisadrate61;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE61)
    public BizNumber getSisadrate61() {
        return sisadrate61;
    }

    public void setSisadrate61(BizNumber pSisadrate61) {
        sisadrate61 = pSisadrate61;
    }

    private BizNumber sisadrate62;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE62)
    public BizNumber getSisadrate62() {
        return sisadrate62;
    }

    public void setSisadrate62(BizNumber pSisadrate62) {
        sisadrate62 = pSisadrate62;
    }

    private BizNumber sisadrate63;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE63)
    public BizNumber getSisadrate63() {
        return sisadrate63;
    }

    public void setSisadrate63(BizNumber pSisadrate63) {
        sisadrate63 = pSisadrate63;
    }

    private BizNumber sisadrate64;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE64)
    public BizNumber getSisadrate64() {
        return sisadrate64;
    }

    public void setSisadrate64(BizNumber pSisadrate64) {
        sisadrate64 = pSisadrate64;
    }

    private BizNumber sisadrate65;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE65)
    public BizNumber getSisadrate65() {
        return sisadrate65;
    }

    public void setSisadrate65(BizNumber pSisadrate65) {
        sisadrate65 = pSisadrate65;
    }

    private BizNumber sisadrate66;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE66)
    public BizNumber getSisadrate66() {
        return sisadrate66;
    }

    public void setSisadrate66(BizNumber pSisadrate66) {
        sisadrate66 = pSisadrate66;
    }

    private BizNumber sisadrate67;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE67)
    public BizNumber getSisadrate67() {
        return sisadrate67;
    }

    public void setSisadrate67(BizNumber pSisadrate67) {
        sisadrate67 = pSisadrate67;
    }

    private BizNumber sisadrate68;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE68)
    public BizNumber getSisadrate68() {
        return sisadrate68;
    }

    public void setSisadrate68(BizNumber pSisadrate68) {
        sisadrate68 = pSisadrate68;
    }

    private BizNumber sisadrate69;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE69)
    public BizNumber getSisadrate69() {
        return sisadrate69;
    }

    public void setSisadrate69(BizNumber pSisadrate69) {
        sisadrate69 = pSisadrate69;
    }

    private BizNumber sisadrate70;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE70)
    public BizNumber getSisadrate70() {
        return sisadrate70;
    }

    public void setSisadrate70(BizNumber pSisadrate70) {
        sisadrate70 = pSisadrate70;
    }

    private BizNumber sisadrate71;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE71)
    public BizNumber getSisadrate71() {
        return sisadrate71;
    }

    public void setSisadrate71(BizNumber pSisadrate71) {
        sisadrate71 = pSisadrate71;
    }

    private BizNumber sisadrate72;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE72)
    public BizNumber getSisadrate72() {
        return sisadrate72;
    }

    public void setSisadrate72(BizNumber pSisadrate72) {
        sisadrate72 = pSisadrate72;
    }

    private BizNumber sisadrate73;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE73)
    public BizNumber getSisadrate73() {
        return sisadrate73;
    }

    public void setSisadrate73(BizNumber pSisadrate73) {
        sisadrate73 = pSisadrate73;
    }

    private BizNumber sisadrate74;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE74)
    public BizNumber getSisadrate74() {
        return sisadrate74;
    }

    public void setSisadrate74(BizNumber pSisadrate74) {
        sisadrate74 = pSisadrate74;
    }

    private BizNumber sisadrate75;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE75)
    public BizNumber getSisadrate75() {
        return sisadrate75;
    }

    public void setSisadrate75(BizNumber pSisadrate75) {
        sisadrate75 = pSisadrate75;
    }

    private BizNumber sisadrate76;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE76)
    public BizNumber getSisadrate76() {
        return sisadrate76;
    }

    public void setSisadrate76(BizNumber pSisadrate76) {
        sisadrate76 = pSisadrate76;
    }

    private BizNumber sisadrate77;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE77)
    public BizNumber getSisadrate77() {
        return sisadrate77;
    }

    public void setSisadrate77(BizNumber pSisadrate77) {
        sisadrate77 = pSisadrate77;
    }

    private BizNumber sisadrate78;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE78)
    public BizNumber getSisadrate78() {
        return sisadrate78;
    }

    public void setSisadrate78(BizNumber pSisadrate78) {
        sisadrate78 = pSisadrate78;
    }

    private BizNumber sisadrate79;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE79)
    public BizNumber getSisadrate79() {
        return sisadrate79;
    }

    public void setSisadrate79(BizNumber pSisadrate79) {
        sisadrate79 = pSisadrate79;
    }

    private BizNumber sisadrate80;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE80)
    public BizNumber getSisadrate80() {
        return sisadrate80;
    }

    public void setSisadrate80(BizNumber pSisadrate80) {
        sisadrate80 = pSisadrate80;
    }

    private BizNumber sisadrate81;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE81)
    public BizNumber getSisadrate81() {
        return sisadrate81;
    }

    public void setSisadrate81(BizNumber pSisadrate81) {
        sisadrate81 = pSisadrate81;
    }

    private BizNumber sisadrate82;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE82)
    public BizNumber getSisadrate82() {
        return sisadrate82;
    }

    public void setSisadrate82(BizNumber pSisadrate82) {
        sisadrate82 = pSisadrate82;
    }

    private BizNumber sisadrate83;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE83)
    public BizNumber getSisadrate83() {
        return sisadrate83;
    }

    public void setSisadrate83(BizNumber pSisadrate83) {
        sisadrate83 = pSisadrate83;
    }

    private BizNumber sisadrate84;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE84)
    public BizNumber getSisadrate84() {
        return sisadrate84;
    }

    public void setSisadrate84(BizNumber pSisadrate84) {
        sisadrate84 = pSisadrate84;
    }

    private BizNumber sisadrate85;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE85)
    public BizNumber getSisadrate85() {
        return sisadrate85;
    }

    public void setSisadrate85(BizNumber pSisadrate85) {
        sisadrate85 = pSisadrate85;
    }

    private BizNumber sisadrate86;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE86)
    public BizNumber getSisadrate86() {
        return sisadrate86;
    }

    public void setSisadrate86(BizNumber pSisadrate86) {
        sisadrate86 = pSisadrate86;
    }

    private BizNumber sisadrate87;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE87)
    public BizNumber getSisadrate87() {
        return sisadrate87;
    }

    public void setSisadrate87(BizNumber pSisadrate87) {
        sisadrate87 = pSisadrate87;
    }

    private BizNumber sisadrate88;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE88)
    public BizNumber getSisadrate88() {
        return sisadrate88;
    }

    public void setSisadrate88(BizNumber pSisadrate88) {
        sisadrate88 = pSisadrate88;
    }

    private BizNumber sisadrate89;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE89)
    public BizNumber getSisadrate89() {
        return sisadrate89;
    }

    public void setSisadrate89(BizNumber pSisadrate89) {
        sisadrate89 = pSisadrate89;
    }

    private BizNumber sisadrate90;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE90)
    public BizNumber getSisadrate90() {
        return sisadrate90;
    }

    public void setSisadrate90(BizNumber pSisadrate90) {
        sisadrate90 = pSisadrate90;
    }

    private BizNumber sisadrate91;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE91)
    public BizNumber getSisadrate91() {
        return sisadrate91;
    }

    public void setSisadrate91(BizNumber pSisadrate91) {
        sisadrate91 = pSisadrate91;
    }

    private BizNumber sisadrate92;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE92)
    public BizNumber getSisadrate92() {
        return sisadrate92;
    }

    public void setSisadrate92(BizNumber pSisadrate92) {
        sisadrate92 = pSisadrate92;
    }

    private BizNumber sisadrate93;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE93)
    public BizNumber getSisadrate93() {
        return sisadrate93;
    }

    public void setSisadrate93(BizNumber pSisadrate93) {
        sisadrate93 = pSisadrate93;
    }

    private BizNumber sisadrate94;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE94)
    public BizNumber getSisadrate94() {
        return sisadrate94;
    }

    public void setSisadrate94(BizNumber pSisadrate94) {
        sisadrate94 = pSisadrate94;
    }

    private BizNumber sisadrate95;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE95)
    public BizNumber getSisadrate95() {
        return sisadrate95;
    }

    public void setSisadrate95(BizNumber pSisadrate95) {
        sisadrate95 = pSisadrate95;
    }

    private BizNumber sisadrate96;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE96)
    public BizNumber getSisadrate96() {
        return sisadrate96;
    }

    public void setSisadrate96(BizNumber pSisadrate96) {
        sisadrate96 = pSisadrate96;
    }

    private BizNumber sisadrate97;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE97)
    public BizNumber getSisadrate97() {
        return sisadrate97;
    }

    public void setSisadrate97(BizNumber pSisadrate97) {
        sisadrate97 = pSisadrate97;
    }

    private BizNumber sisadrate98;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE98)
    public BizNumber getSisadrate98() {
        return sisadrate98;
    }

    public void setSisadrate98(BizNumber pSisadrate98) {
        sisadrate98 = pSisadrate98;
    }

    private BizNumber sisadrate99;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.SISADRATE99)
    public BizNumber getSisadrate99() {
        return sisadrate99;
    }

    public void setSisadrate99(BizNumber pSisadrate99) {
        sisadrate99 = pSisadrate99;
    }

    private BizNumber risadrate00;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE00)
    public BizNumber getRisadrate00() {
        return risadrate00;
    }

    public void setRisadrate00(BizNumber pRisadrate00) {
        risadrate00 = pRisadrate00;
    }

    private BizNumber risadrate01;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE01)
    public BizNumber getRisadrate01() {
        return risadrate01;
    }

    public void setRisadrate01(BizNumber pRisadrate01) {
        risadrate01 = pRisadrate01;
    }

    private BizNumber risadrate02;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE02)
    public BizNumber getRisadrate02() {
        return risadrate02;
    }

    public void setRisadrate02(BizNumber pRisadrate02) {
        risadrate02 = pRisadrate02;
    }

    private BizNumber risadrate03;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE03)
    public BizNumber getRisadrate03() {
        return risadrate03;
    }

    public void setRisadrate03(BizNumber pRisadrate03) {
        risadrate03 = pRisadrate03;
    }

    private BizNumber risadrate04;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE04)
    public BizNumber getRisadrate04() {
        return risadrate04;
    }

    public void setRisadrate04(BizNumber pRisadrate04) {
        risadrate04 = pRisadrate04;
    }

    private BizNumber risadrate05;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE05)
    public BizNumber getRisadrate05() {
        return risadrate05;
    }

    public void setRisadrate05(BizNumber pRisadrate05) {
        risadrate05 = pRisadrate05;
    }

    private BizNumber risadrate06;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE06)
    public BizNumber getRisadrate06() {
        return risadrate06;
    }

    public void setRisadrate06(BizNumber pRisadrate06) {
        risadrate06 = pRisadrate06;
    }

    private BizNumber risadrate07;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE07)
    public BizNumber getRisadrate07() {
        return risadrate07;
    }

    public void setRisadrate07(BizNumber pRisadrate07) {
        risadrate07 = pRisadrate07;
    }

    private BizNumber risadrate08;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE08)
    public BizNumber getRisadrate08() {
        return risadrate08;
    }

    public void setRisadrate08(BizNumber pRisadrate08) {
        risadrate08 = pRisadrate08;
    }

    private BizNumber risadrate09;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE09)
    public BizNumber getRisadrate09() {
        return risadrate09;
    }

    public void setRisadrate09(BizNumber pRisadrate09) {
        risadrate09 = pRisadrate09;
    }

    private BizNumber risadrate10;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE10)
    public BizNumber getRisadrate10() {
        return risadrate10;
    }

    public void setRisadrate10(BizNumber pRisadrate10) {
        risadrate10 = pRisadrate10;
    }

    private BizNumber risadrate11;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE11)
    public BizNumber getRisadrate11() {
        return risadrate11;
    }

    public void setRisadrate11(BizNumber pRisadrate11) {
        risadrate11 = pRisadrate11;
    }

    private BizNumber risadrate12;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE12)
    public BizNumber getRisadrate12() {
        return risadrate12;
    }

    public void setRisadrate12(BizNumber pRisadrate12) {
        risadrate12 = pRisadrate12;
    }

    private BizNumber risadrate13;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE13)
    public BizNumber getRisadrate13() {
        return risadrate13;
    }

    public void setRisadrate13(BizNumber pRisadrate13) {
        risadrate13 = pRisadrate13;
    }

    private BizNumber risadrate14;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE14)
    public BizNumber getRisadrate14() {
        return risadrate14;
    }

    public void setRisadrate14(BizNumber pRisadrate14) {
        risadrate14 = pRisadrate14;
    }

    private BizNumber risadrate15;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE15)
    public BizNumber getRisadrate15() {
        return risadrate15;
    }

    public void setRisadrate15(BizNumber pRisadrate15) {
        risadrate15 = pRisadrate15;
    }

    private BizNumber risadrate16;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE16)
    public BizNumber getRisadrate16() {
        return risadrate16;
    }

    public void setRisadrate16(BizNumber pRisadrate16) {
        risadrate16 = pRisadrate16;
    }

    private BizNumber risadrate17;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE17)
    public BizNumber getRisadrate17() {
        return risadrate17;
    }

    public void setRisadrate17(BizNumber pRisadrate17) {
        risadrate17 = pRisadrate17;
    }

    private BizNumber risadrate18;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE18)
    public BizNumber getRisadrate18() {
        return risadrate18;
    }

    public void setRisadrate18(BizNumber pRisadrate18) {
        risadrate18 = pRisadrate18;
    }

    private BizNumber risadrate19;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE19)
    public BizNumber getRisadrate19() {
        return risadrate19;
    }

    public void setRisadrate19(BizNumber pRisadrate19) {
        risadrate19 = pRisadrate19;
    }

    private BizNumber risadrate20;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE20)
    public BizNumber getRisadrate20() {
        return risadrate20;
    }

    public void setRisadrate20(BizNumber pRisadrate20) {
        risadrate20 = pRisadrate20;
    }

    private BizNumber risadrate21;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE21)
    public BizNumber getRisadrate21() {
        return risadrate21;
    }

    public void setRisadrate21(BizNumber pRisadrate21) {
        risadrate21 = pRisadrate21;
    }

    private BizNumber risadrate22;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE22)
    public BizNumber getRisadrate22() {
        return risadrate22;
    }

    public void setRisadrate22(BizNumber pRisadrate22) {
        risadrate22 = pRisadrate22;
    }

    private BizNumber risadrate23;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE23)
    public BizNumber getRisadrate23() {
        return risadrate23;
    }

    public void setRisadrate23(BizNumber pRisadrate23) {
        risadrate23 = pRisadrate23;
    }

    private BizNumber risadrate24;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE24)
    public BizNumber getRisadrate24() {
        return risadrate24;
    }

    public void setRisadrate24(BizNumber pRisadrate24) {
        risadrate24 = pRisadrate24;
    }

    private BizNumber risadrate25;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE25)
    public BizNumber getRisadrate25() {
        return risadrate25;
    }

    public void setRisadrate25(BizNumber pRisadrate25) {
        risadrate25 = pRisadrate25;
    }

    private BizNumber risadrate26;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE26)
    public BizNumber getRisadrate26() {
        return risadrate26;
    }

    public void setRisadrate26(BizNumber pRisadrate26) {
        risadrate26 = pRisadrate26;
    }

    private BizNumber risadrate27;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE27)
    public BizNumber getRisadrate27() {
        return risadrate27;
    }

    public void setRisadrate27(BizNumber pRisadrate27) {
        risadrate27 = pRisadrate27;
    }

    private BizNumber risadrate28;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE28)
    public BizNumber getRisadrate28() {
        return risadrate28;
    }

    public void setRisadrate28(BizNumber pRisadrate28) {
        risadrate28 = pRisadrate28;
    }

    private BizNumber risadrate29;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE29)
    public BizNumber getRisadrate29() {
        return risadrate29;
    }

    public void setRisadrate29(BizNumber pRisadrate29) {
        risadrate29 = pRisadrate29;
    }

    private BizNumber risadrate30;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE30)
    public BizNumber getRisadrate30() {
        return risadrate30;
    }

    public void setRisadrate30(BizNumber pRisadrate30) {
        risadrate30 = pRisadrate30;
    }

    private BizNumber risadrate31;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE31)
    public BizNumber getRisadrate31() {
        return risadrate31;
    }

    public void setRisadrate31(BizNumber pRisadrate31) {
        risadrate31 = pRisadrate31;
    }

    private BizNumber risadrate32;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE32)
    public BizNumber getRisadrate32() {
        return risadrate32;
    }

    public void setRisadrate32(BizNumber pRisadrate32) {
        risadrate32 = pRisadrate32;
    }

    private BizNumber risadrate33;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE33)
    public BizNumber getRisadrate33() {
        return risadrate33;
    }

    public void setRisadrate33(BizNumber pRisadrate33) {
        risadrate33 = pRisadrate33;
    }

    private BizNumber risadrate34;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE34)
    public BizNumber getRisadrate34() {
        return risadrate34;
    }

    public void setRisadrate34(BizNumber pRisadrate34) {
        risadrate34 = pRisadrate34;
    }

    private BizNumber risadrate35;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE35)
    public BizNumber getRisadrate35() {
        return risadrate35;
    }

    public void setRisadrate35(BizNumber pRisadrate35) {
        risadrate35 = pRisadrate35;
    }

    private BizNumber risadrate36;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE36)
    public BizNumber getRisadrate36() {
        return risadrate36;
    }

    public void setRisadrate36(BizNumber pRisadrate36) {
        risadrate36 = pRisadrate36;
    }

    private BizNumber risadrate37;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE37)
    public BizNumber getRisadrate37() {
        return risadrate37;
    }

    public void setRisadrate37(BizNumber pRisadrate37) {
        risadrate37 = pRisadrate37;
    }

    private BizNumber risadrate38;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE38)
    public BizNumber getRisadrate38() {
        return risadrate38;
    }

    public void setRisadrate38(BizNumber pRisadrate38) {
        risadrate38 = pRisadrate38;
    }

    private BizNumber risadrate39;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE39)
    public BizNumber getRisadrate39() {
        return risadrate39;
    }

    public void setRisadrate39(BizNumber pRisadrate39) {
        risadrate39 = pRisadrate39;
    }

    private BizNumber risadrate40;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE40)
    public BizNumber getRisadrate40() {
        return risadrate40;
    }

    public void setRisadrate40(BizNumber pRisadrate40) {
        risadrate40 = pRisadrate40;
    }

    private BizNumber risadrate41;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE41)
    public BizNumber getRisadrate41() {
        return risadrate41;
    }

    public void setRisadrate41(BizNumber pRisadrate41) {
        risadrate41 = pRisadrate41;
    }

    private BizNumber risadrate42;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE42)
    public BizNumber getRisadrate42() {
        return risadrate42;
    }

    public void setRisadrate42(BizNumber pRisadrate42) {
        risadrate42 = pRisadrate42;
    }

    private BizNumber risadrate43;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE43)
    public BizNumber getRisadrate43() {
        return risadrate43;
    }

    public void setRisadrate43(BizNumber pRisadrate43) {
        risadrate43 = pRisadrate43;
    }

    private BizNumber risadrate44;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE44)
    public BizNumber getRisadrate44() {
        return risadrate44;
    }

    public void setRisadrate44(BizNumber pRisadrate44) {
        risadrate44 = pRisadrate44;
    }

    private BizNumber risadrate45;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE45)
    public BizNumber getRisadrate45() {
        return risadrate45;
    }

    public void setRisadrate45(BizNumber pRisadrate45) {
        risadrate45 = pRisadrate45;
    }

    private BizNumber risadrate46;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE46)
    public BizNumber getRisadrate46() {
        return risadrate46;
    }

    public void setRisadrate46(BizNumber pRisadrate46) {
        risadrate46 = pRisadrate46;
    }

    private BizNumber risadrate47;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE47)
    public BizNumber getRisadrate47() {
        return risadrate47;
    }

    public void setRisadrate47(BizNumber pRisadrate47) {
        risadrate47 = pRisadrate47;
    }

    private BizNumber risadrate48;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE48)
    public BizNumber getRisadrate48() {
        return risadrate48;
    }

    public void setRisadrate48(BizNumber pRisadrate48) {
        risadrate48 = pRisadrate48;
    }

    private BizNumber risadrate49;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE49)
    public BizNumber getRisadrate49() {
        return risadrate49;
    }

    public void setRisadrate49(BizNumber pRisadrate49) {
        risadrate49 = pRisadrate49;
    }

    private BizNumber risadrate50;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE50)
    public BizNumber getRisadrate50() {
        return risadrate50;
    }

    public void setRisadrate50(BizNumber pRisadrate50) {
        risadrate50 = pRisadrate50;
    }

    private BizNumber risadrate51;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE51)
    public BizNumber getRisadrate51() {
        return risadrate51;
    }

    public void setRisadrate51(BizNumber pRisadrate51) {
        risadrate51 = pRisadrate51;
    }

    private BizNumber risadrate52;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE52)
    public BizNumber getRisadrate52() {
        return risadrate52;
    }

    public void setRisadrate52(BizNumber pRisadrate52) {
        risadrate52 = pRisadrate52;
    }

    private BizNumber risadrate53;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE53)
    public BizNumber getRisadrate53() {
        return risadrate53;
    }

    public void setRisadrate53(BizNumber pRisadrate53) {
        risadrate53 = pRisadrate53;
    }

    private BizNumber risadrate54;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE54)
    public BizNumber getRisadrate54() {
        return risadrate54;
    }

    public void setRisadrate54(BizNumber pRisadrate54) {
        risadrate54 = pRisadrate54;
    }

    private BizNumber risadrate55;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE55)
    public BizNumber getRisadrate55() {
        return risadrate55;
    }

    public void setRisadrate55(BizNumber pRisadrate55) {
        risadrate55 = pRisadrate55;
    }

    private BizNumber risadrate56;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE56)
    public BizNumber getRisadrate56() {
        return risadrate56;
    }

    public void setRisadrate56(BizNumber pRisadrate56) {
        risadrate56 = pRisadrate56;
    }

    private BizNumber risadrate57;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE57)
    public BizNumber getRisadrate57() {
        return risadrate57;
    }

    public void setRisadrate57(BizNumber pRisadrate57) {
        risadrate57 = pRisadrate57;
    }

    private BizNumber risadrate58;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE58)
    public BizNumber getRisadrate58() {
        return risadrate58;
    }

    public void setRisadrate58(BizNumber pRisadrate58) {
        risadrate58 = pRisadrate58;
    }

    private BizNumber risadrate59;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE59)
    public BizNumber getRisadrate59() {
        return risadrate59;
    }

    public void setRisadrate59(BizNumber pRisadrate59) {
        risadrate59 = pRisadrate59;
    }

    private BizNumber risadrate60;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE60)
    public BizNumber getRisadrate60() {
        return risadrate60;
    }

    public void setRisadrate60(BizNumber pRisadrate60) {
        risadrate60 = pRisadrate60;
    }

    private BizNumber risadrate61;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE61)
    public BizNumber getRisadrate61() {
        return risadrate61;
    }

    public void setRisadrate61(BizNumber pRisadrate61) {
        risadrate61 = pRisadrate61;
    }

    private BizNumber risadrate62;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE62)
    public BizNumber getRisadrate62() {
        return risadrate62;
    }

    public void setRisadrate62(BizNumber pRisadrate62) {
        risadrate62 = pRisadrate62;
    }

    private BizNumber risadrate63;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE63)
    public BizNumber getRisadrate63() {
        return risadrate63;
    }

    public void setRisadrate63(BizNumber pRisadrate63) {
        risadrate63 = pRisadrate63;
    }

    private BizNumber risadrate64;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE64)
    public BizNumber getRisadrate64() {
        return risadrate64;
    }

    public void setRisadrate64(BizNumber pRisadrate64) {
        risadrate64 = pRisadrate64;
    }

    private BizNumber risadrate65;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE65)
    public BizNumber getRisadrate65() {
        return risadrate65;
    }

    public void setRisadrate65(BizNumber pRisadrate65) {
        risadrate65 = pRisadrate65;
    }

    private BizNumber risadrate66;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE66)
    public BizNumber getRisadrate66() {
        return risadrate66;
    }

    public void setRisadrate66(BizNumber pRisadrate66) {
        risadrate66 = pRisadrate66;
    }

    private BizNumber risadrate67;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE67)
    public BizNumber getRisadrate67() {
        return risadrate67;
    }

    public void setRisadrate67(BizNumber pRisadrate67) {
        risadrate67 = pRisadrate67;
    }

    private BizNumber risadrate68;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE68)
    public BizNumber getRisadrate68() {
        return risadrate68;
    }

    public void setRisadrate68(BizNumber pRisadrate68) {
        risadrate68 = pRisadrate68;
    }

    private BizNumber risadrate69;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE69)
    public BizNumber getRisadrate69() {
        return risadrate69;
    }

    public void setRisadrate69(BizNumber pRisadrate69) {
        risadrate69 = pRisadrate69;
    }

    private BizNumber risadrate70;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE70)
    public BizNumber getRisadrate70() {
        return risadrate70;
    }

    public void setRisadrate70(BizNumber pRisadrate70) {
        risadrate70 = pRisadrate70;
    }

    private BizNumber risadrate71;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE71)
    public BizNumber getRisadrate71() {
        return risadrate71;
    }

    public void setRisadrate71(BizNumber pRisadrate71) {
        risadrate71 = pRisadrate71;
    }

    private BizNumber risadrate72;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE72)
    public BizNumber getRisadrate72() {
        return risadrate72;
    }

    public void setRisadrate72(BizNumber pRisadrate72) {
        risadrate72 = pRisadrate72;
    }

    private BizNumber risadrate73;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE73)
    public BizNumber getRisadrate73() {
        return risadrate73;
    }

    public void setRisadrate73(BizNumber pRisadrate73) {
        risadrate73 = pRisadrate73;
    }

    private BizNumber risadrate74;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE74)
    public BizNumber getRisadrate74() {
        return risadrate74;
    }

    public void setRisadrate74(BizNumber pRisadrate74) {
        risadrate74 = pRisadrate74;
    }

    private BizNumber risadrate75;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE75)
    public BizNumber getRisadrate75() {
        return risadrate75;
    }

    public void setRisadrate75(BizNumber pRisadrate75) {
        risadrate75 = pRisadrate75;
    }

    private BizNumber risadrate76;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE76)
    public BizNumber getRisadrate76() {
        return risadrate76;
    }

    public void setRisadrate76(BizNumber pRisadrate76) {
        risadrate76 = pRisadrate76;
    }

    private BizNumber risadrate77;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE77)
    public BizNumber getRisadrate77() {
        return risadrate77;
    }

    public void setRisadrate77(BizNumber pRisadrate77) {
        risadrate77 = pRisadrate77;
    }

    private BizNumber risadrate78;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE78)
    public BizNumber getRisadrate78() {
        return risadrate78;
    }

    public void setRisadrate78(BizNumber pRisadrate78) {
        risadrate78 = pRisadrate78;
    }

    private BizNumber risadrate79;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE79)
    public BizNumber getRisadrate79() {
        return risadrate79;
    }

    public void setRisadrate79(BizNumber pRisadrate79) {
        risadrate79 = pRisadrate79;
    }

    private BizNumber risadrate80;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE80)
    public BizNumber getRisadrate80() {
        return risadrate80;
    }

    public void setRisadrate80(BizNumber pRisadrate80) {
        risadrate80 = pRisadrate80;
    }

    private BizNumber risadrate81;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE81)
    public BizNumber getRisadrate81() {
        return risadrate81;
    }

    public void setRisadrate81(BizNumber pRisadrate81) {
        risadrate81 = pRisadrate81;
    }

    private BizNumber risadrate82;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE82)
    public BizNumber getRisadrate82() {
        return risadrate82;
    }

    public void setRisadrate82(BizNumber pRisadrate82) {
        risadrate82 = pRisadrate82;
    }

    private BizNumber risadrate83;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE83)
    public BizNumber getRisadrate83() {
        return risadrate83;
    }

    public void setRisadrate83(BizNumber pRisadrate83) {
        risadrate83 = pRisadrate83;
    }

    private BizNumber risadrate84;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE84)
    public BizNumber getRisadrate84() {
        return risadrate84;
    }

    public void setRisadrate84(BizNumber pRisadrate84) {
        risadrate84 = pRisadrate84;
    }

    private BizNumber risadrate85;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE85)
    public BizNumber getRisadrate85() {
        return risadrate85;
    }

    public void setRisadrate85(BizNumber pRisadrate85) {
        risadrate85 = pRisadrate85;
    }

    private BizNumber risadrate86;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE86)
    public BizNumber getRisadrate86() {
        return risadrate86;
    }

    public void setRisadrate86(BizNumber pRisadrate86) {
        risadrate86 = pRisadrate86;
    }

    private BizNumber risadrate87;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE87)
    public BizNumber getRisadrate87() {
        return risadrate87;
    }

    public void setRisadrate87(BizNumber pRisadrate87) {
        risadrate87 = pRisadrate87;
    }

    private BizNumber risadrate88;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE88)
    public BizNumber getRisadrate88() {
        return risadrate88;
    }

    public void setRisadrate88(BizNumber pRisadrate88) {
        risadrate88 = pRisadrate88;
    }

    private BizNumber risadrate89;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE89)
    public BizNumber getRisadrate89() {
        return risadrate89;
    }

    public void setRisadrate89(BizNumber pRisadrate89) {
        risadrate89 = pRisadrate89;
    }

    private BizNumber risadrate90;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE90)
    public BizNumber getRisadrate90() {
        return risadrate90;
    }

    public void setRisadrate90(BizNumber pRisadrate90) {
        risadrate90 = pRisadrate90;
    }

    private BizNumber risadrate91;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE91)
    public BizNumber getRisadrate91() {
        return risadrate91;
    }

    public void setRisadrate91(BizNumber pRisadrate91) {
        risadrate91 = pRisadrate91;
    }

    private BizNumber risadrate92;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE92)
    public BizNumber getRisadrate92() {
        return risadrate92;
    }

    public void setRisadrate92(BizNumber pRisadrate92) {
        risadrate92 = pRisadrate92;
    }

    private BizNumber risadrate93;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE93)
    public BizNumber getRisadrate93() {
        return risadrate93;
    }

    public void setRisadrate93(BizNumber pRisadrate93) {
        risadrate93 = pRisadrate93;
    }

    private BizNumber risadrate94;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE94)
    public BizNumber getRisadrate94() {
        return risadrate94;
    }

    public void setRisadrate94(BizNumber pRisadrate94) {
        risadrate94 = pRisadrate94;
    }

    private BizNumber risadrate95;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE95)
    public BizNumber getRisadrate95() {
        return risadrate95;
    }

    public void setRisadrate95(BizNumber pRisadrate95) {
        risadrate95 = pRisadrate95;
    }

    private BizNumber risadrate96;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE96)
    public BizNumber getRisadrate96() {
        return risadrate96;
    }

    public void setRisadrate96(BizNumber pRisadrate96) {
        risadrate96 = pRisadrate96;
    }

    private BizNumber risadrate97;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE97)
    public BizNumber getRisadrate97() {
        return risadrate97;
    }

    public void setRisadrate97(BizNumber pRisadrate97) {
        risadrate97 = pRisadrate97;
    }

    private BizNumber risadrate98;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE98)
    public BizNumber getRisadrate98() {
        return risadrate98;
    }

    public void setRisadrate98(BizNumber pRisadrate98) {
        risadrate98 = pRisadrate98;
    }

    private BizNumber risadrate99;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.RISADRATE99)
    public BizNumber getRisadrate99() {
        return risadrate99;
    }

    public void setRisadrate99(BizNumber pRisadrate99) {
        risadrate99 = pRisadrate99;
    }

    private BizNumber hisadrate00;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE00)
    public BizNumber getHisadrate00() {
        return hisadrate00;
    }

    public void setHisadrate00(BizNumber pHisadrate00) {
        hisadrate00 = pHisadrate00;
    }

    private BizNumber hisadrate01;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE01)
    public BizNumber getHisadrate01() {
        return hisadrate01;
    }

    public void setHisadrate01(BizNumber pHisadrate01) {
        hisadrate01 = pHisadrate01;
    }

    private BizNumber hisadrate02;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE02)
    public BizNumber getHisadrate02() {
        return hisadrate02;
    }

    public void setHisadrate02(BizNumber pHisadrate02) {
        hisadrate02 = pHisadrate02;
    }

    private BizNumber hisadrate03;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE03)
    public BizNumber getHisadrate03() {
        return hisadrate03;
    }

    public void setHisadrate03(BizNumber pHisadrate03) {
        hisadrate03 = pHisadrate03;
    }

    private BizNumber hisadrate04;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE04)
    public BizNumber getHisadrate04() {
        return hisadrate04;
    }

    public void setHisadrate04(BizNumber pHisadrate04) {
        hisadrate04 = pHisadrate04;
    }

    private BizNumber hisadrate05;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE05)
    public BizNumber getHisadrate05() {
        return hisadrate05;
    }

    public void setHisadrate05(BizNumber pHisadrate05) {
        hisadrate05 = pHisadrate05;
    }

    private BizNumber hisadrate06;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE06)
    public BizNumber getHisadrate06() {
        return hisadrate06;
    }

    public void setHisadrate06(BizNumber pHisadrate06) {
        hisadrate06 = pHisadrate06;
    }

    private BizNumber hisadrate07;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE07)
    public BizNumber getHisadrate07() {
        return hisadrate07;
    }

    public void setHisadrate07(BizNumber pHisadrate07) {
        hisadrate07 = pHisadrate07;
    }

    private BizNumber hisadrate08;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE08)
    public BizNumber getHisadrate08() {
        return hisadrate08;
    }

    public void setHisadrate08(BizNumber pHisadrate08) {
        hisadrate08 = pHisadrate08;
    }

    private BizNumber hisadrate09;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE09)
    public BizNumber getHisadrate09() {
        return hisadrate09;
    }

    public void setHisadrate09(BizNumber pHisadrate09) {
        hisadrate09 = pHisadrate09;
    }

    private BizNumber hisadrate10;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE10)
    public BizNumber getHisadrate10() {
        return hisadrate10;
    }

    public void setHisadrate10(BizNumber pHisadrate10) {
        hisadrate10 = pHisadrate10;
    }

    private BizNumber hisadrate11;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE11)
    public BizNumber getHisadrate11() {
        return hisadrate11;
    }

    public void setHisadrate11(BizNumber pHisadrate11) {
        hisadrate11 = pHisadrate11;
    }

    private BizNumber hisadrate12;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE12)
    public BizNumber getHisadrate12() {
        return hisadrate12;
    }

    public void setHisadrate12(BizNumber pHisadrate12) {
        hisadrate12 = pHisadrate12;
    }

    private BizNumber hisadrate13;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE13)
    public BizNumber getHisadrate13() {
        return hisadrate13;
    }

    public void setHisadrate13(BizNumber pHisadrate13) {
        hisadrate13 = pHisadrate13;
    }

    private BizNumber hisadrate14;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE14)
    public BizNumber getHisadrate14() {
        return hisadrate14;
    }

    public void setHisadrate14(BizNumber pHisadrate14) {
        hisadrate14 = pHisadrate14;
    }

    private BizNumber hisadrate15;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE15)
    public BizNumber getHisadrate15() {
        return hisadrate15;
    }

    public void setHisadrate15(BizNumber pHisadrate15) {
        hisadrate15 = pHisadrate15;
    }

    private BizNumber hisadrate16;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE16)
    public BizNumber getHisadrate16() {
        return hisadrate16;
    }

    public void setHisadrate16(BizNumber pHisadrate16) {
        hisadrate16 = pHisadrate16;
    }

    private BizNumber hisadrate17;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE17)
    public BizNumber getHisadrate17() {
        return hisadrate17;
    }

    public void setHisadrate17(BizNumber pHisadrate17) {
        hisadrate17 = pHisadrate17;
    }

    private BizNumber hisadrate18;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE18)
    public BizNumber getHisadrate18() {
        return hisadrate18;
    }

    public void setHisadrate18(BizNumber pHisadrate18) {
        hisadrate18 = pHisadrate18;
    }

    private BizNumber hisadrate19;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE19)
    public BizNumber getHisadrate19() {
        return hisadrate19;
    }

    public void setHisadrate19(BizNumber pHisadrate19) {
        hisadrate19 = pHisadrate19;
    }

    private BizNumber hisadrate20;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE20)
    public BizNumber getHisadrate20() {
        return hisadrate20;
    }

    public void setHisadrate20(BizNumber pHisadrate20) {
        hisadrate20 = pHisadrate20;
    }

    private BizNumber hisadrate21;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE21)
    public BizNumber getHisadrate21() {
        return hisadrate21;
    }

    public void setHisadrate21(BizNumber pHisadrate21) {
        hisadrate21 = pHisadrate21;
    }

    private BizNumber hisadrate22;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE22)
    public BizNumber getHisadrate22() {
        return hisadrate22;
    }

    public void setHisadrate22(BizNumber pHisadrate22) {
        hisadrate22 = pHisadrate22;
    }

    private BizNumber hisadrate23;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE23)
    public BizNumber getHisadrate23() {
        return hisadrate23;
    }

    public void setHisadrate23(BizNumber pHisadrate23) {
        hisadrate23 = pHisadrate23;
    }

    private BizNumber hisadrate24;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE24)
    public BizNumber getHisadrate24() {
        return hisadrate24;
    }

    public void setHisadrate24(BizNumber pHisadrate24) {
        hisadrate24 = pHisadrate24;
    }

    private BizNumber hisadrate25;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE25)
    public BizNumber getHisadrate25() {
        return hisadrate25;
    }

    public void setHisadrate25(BizNumber pHisadrate25) {
        hisadrate25 = pHisadrate25;
    }

    private BizNumber hisadrate26;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE26)
    public BizNumber getHisadrate26() {
        return hisadrate26;
    }

    public void setHisadrate26(BizNumber pHisadrate26) {
        hisadrate26 = pHisadrate26;
    }

    private BizNumber hisadrate27;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE27)
    public BizNumber getHisadrate27() {
        return hisadrate27;
    }

    public void setHisadrate27(BizNumber pHisadrate27) {
        hisadrate27 = pHisadrate27;
    }

    private BizNumber hisadrate28;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE28)
    public BizNumber getHisadrate28() {
        return hisadrate28;
    }

    public void setHisadrate28(BizNumber pHisadrate28) {
        hisadrate28 = pHisadrate28;
    }

    private BizNumber hisadrate29;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE29)
    public BizNumber getHisadrate29() {
        return hisadrate29;
    }

    public void setHisadrate29(BizNumber pHisadrate29) {
        hisadrate29 = pHisadrate29;
    }

    private BizNumber hisadrate30;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE30)
    public BizNumber getHisadrate30() {
        return hisadrate30;
    }

    public void setHisadrate30(BizNumber pHisadrate30) {
        hisadrate30 = pHisadrate30;
    }

    private BizNumber hisadrate31;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE31)
    public BizNumber getHisadrate31() {
        return hisadrate31;
    }

    public void setHisadrate31(BizNumber pHisadrate31) {
        hisadrate31 = pHisadrate31;
    }

    private BizNumber hisadrate32;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE32)
    public BizNumber getHisadrate32() {
        return hisadrate32;
    }

    public void setHisadrate32(BizNumber pHisadrate32) {
        hisadrate32 = pHisadrate32;
    }

    private BizNumber hisadrate33;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE33)
    public BizNumber getHisadrate33() {
        return hisadrate33;
    }

    public void setHisadrate33(BizNumber pHisadrate33) {
        hisadrate33 = pHisadrate33;
    }

    private BizNumber hisadrate34;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE34)
    public BizNumber getHisadrate34() {
        return hisadrate34;
    }

    public void setHisadrate34(BizNumber pHisadrate34) {
        hisadrate34 = pHisadrate34;
    }

    private BizNumber hisadrate35;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE35)
    public BizNumber getHisadrate35() {
        return hisadrate35;
    }

    public void setHisadrate35(BizNumber pHisadrate35) {
        hisadrate35 = pHisadrate35;
    }

    private BizNumber hisadrate36;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE36)
    public BizNumber getHisadrate36() {
        return hisadrate36;
    }

    public void setHisadrate36(BizNumber pHisadrate36) {
        hisadrate36 = pHisadrate36;
    }

    private BizNumber hisadrate37;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE37)
    public BizNumber getHisadrate37() {
        return hisadrate37;
    }

    public void setHisadrate37(BizNumber pHisadrate37) {
        hisadrate37 = pHisadrate37;
    }

    private BizNumber hisadrate38;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE38)
    public BizNumber getHisadrate38() {
        return hisadrate38;
    }

    public void setHisadrate38(BizNumber pHisadrate38) {
        hisadrate38 = pHisadrate38;
    }

    private BizNumber hisadrate39;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE39)
    public BizNumber getHisadrate39() {
        return hisadrate39;
    }

    public void setHisadrate39(BizNumber pHisadrate39) {
        hisadrate39 = pHisadrate39;
    }

    private BizNumber hisadrate40;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE40)
    public BizNumber getHisadrate40() {
        return hisadrate40;
    }

    public void setHisadrate40(BizNumber pHisadrate40) {
        hisadrate40 = pHisadrate40;
    }

    private BizNumber hisadrate41;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE41)
    public BizNumber getHisadrate41() {
        return hisadrate41;
    }

    public void setHisadrate41(BizNumber pHisadrate41) {
        hisadrate41 = pHisadrate41;
    }

    private BizNumber hisadrate42;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE42)
    public BizNumber getHisadrate42() {
        return hisadrate42;
    }

    public void setHisadrate42(BizNumber pHisadrate42) {
        hisadrate42 = pHisadrate42;
    }

    private BizNumber hisadrate43;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE43)
    public BizNumber getHisadrate43() {
        return hisadrate43;
    }

    public void setHisadrate43(BizNumber pHisadrate43) {
        hisadrate43 = pHisadrate43;
    }

    private BizNumber hisadrate44;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE44)
    public BizNumber getHisadrate44() {
        return hisadrate44;
    }

    public void setHisadrate44(BizNumber pHisadrate44) {
        hisadrate44 = pHisadrate44;
    }

    private BizNumber hisadrate45;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE45)
    public BizNumber getHisadrate45() {
        return hisadrate45;
    }

    public void setHisadrate45(BizNumber pHisadrate45) {
        hisadrate45 = pHisadrate45;
    }

    private BizNumber hisadrate46;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE46)
    public BizNumber getHisadrate46() {
        return hisadrate46;
    }

    public void setHisadrate46(BizNumber pHisadrate46) {
        hisadrate46 = pHisadrate46;
    }

    private BizNumber hisadrate47;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE47)
    public BizNumber getHisadrate47() {
        return hisadrate47;
    }

    public void setHisadrate47(BizNumber pHisadrate47) {
        hisadrate47 = pHisadrate47;
    }

    private BizNumber hisadrate48;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE48)
    public BizNumber getHisadrate48() {
        return hisadrate48;
    }

    public void setHisadrate48(BizNumber pHisadrate48) {
        hisadrate48 = pHisadrate48;
    }

    private BizNumber hisadrate49;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE49)
    public BizNumber getHisadrate49() {
        return hisadrate49;
    }

    public void setHisadrate49(BizNumber pHisadrate49) {
        hisadrate49 = pHisadrate49;
    }

    private BizNumber hisadrate50;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE50)
    public BizNumber getHisadrate50() {
        return hisadrate50;
    }

    public void setHisadrate50(BizNumber pHisadrate50) {
        hisadrate50 = pHisadrate50;
    }

    private BizNumber hisadrate51;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE51)
    public BizNumber getHisadrate51() {
        return hisadrate51;
    }

    public void setHisadrate51(BizNumber pHisadrate51) {
        hisadrate51 = pHisadrate51;
    }

    private BizNumber hisadrate52;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE52)
    public BizNumber getHisadrate52() {
        return hisadrate52;
    }

    public void setHisadrate52(BizNumber pHisadrate52) {
        hisadrate52 = pHisadrate52;
    }

    private BizNumber hisadrate53;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE53)
    public BizNumber getHisadrate53() {
        return hisadrate53;
    }

    public void setHisadrate53(BizNumber pHisadrate53) {
        hisadrate53 = pHisadrate53;
    }

    private BizNumber hisadrate54;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE54)
    public BizNumber getHisadrate54() {
        return hisadrate54;
    }

    public void setHisadrate54(BizNumber pHisadrate54) {
        hisadrate54 = pHisadrate54;
    }

    private BizNumber hisadrate55;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE55)
    public BizNumber getHisadrate55() {
        return hisadrate55;
    }

    public void setHisadrate55(BizNumber pHisadrate55) {
        hisadrate55 = pHisadrate55;
    }

    private BizNumber hisadrate56;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE56)
    public BizNumber getHisadrate56() {
        return hisadrate56;
    }

    public void setHisadrate56(BizNumber pHisadrate56) {
        hisadrate56 = pHisadrate56;
    }

    private BizNumber hisadrate57;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE57)
    public BizNumber getHisadrate57() {
        return hisadrate57;
    }

    public void setHisadrate57(BizNumber pHisadrate57) {
        hisadrate57 = pHisadrate57;
    }

    private BizNumber hisadrate58;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE58)
    public BizNumber getHisadrate58() {
        return hisadrate58;
    }

    public void setHisadrate58(BizNumber pHisadrate58) {
        hisadrate58 = pHisadrate58;
    }

    private BizNumber hisadrate59;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE59)
    public BizNumber getHisadrate59() {
        return hisadrate59;
    }

    public void setHisadrate59(BizNumber pHisadrate59) {
        hisadrate59 = pHisadrate59;
    }

    private BizNumber hisadrate60;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE60)
    public BizNumber getHisadrate60() {
        return hisadrate60;
    }

    public void setHisadrate60(BizNumber pHisadrate60) {
        hisadrate60 = pHisadrate60;
    }

    private BizNumber hisadrate61;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE61)
    public BizNumber getHisadrate61() {
        return hisadrate61;
    }

    public void setHisadrate61(BizNumber pHisadrate61) {
        hisadrate61 = pHisadrate61;
    }

    private BizNumber hisadrate62;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE62)
    public BizNumber getHisadrate62() {
        return hisadrate62;
    }

    public void setHisadrate62(BizNumber pHisadrate62) {
        hisadrate62 = pHisadrate62;
    }

    private BizNumber hisadrate63;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE63)
    public BizNumber getHisadrate63() {
        return hisadrate63;
    }

    public void setHisadrate63(BizNumber pHisadrate63) {
        hisadrate63 = pHisadrate63;
    }

    private BizNumber hisadrate64;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE64)
    public BizNumber getHisadrate64() {
        return hisadrate64;
    }

    public void setHisadrate64(BizNumber pHisadrate64) {
        hisadrate64 = pHisadrate64;
    }

    private BizNumber hisadrate65;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE65)
    public BizNumber getHisadrate65() {
        return hisadrate65;
    }

    public void setHisadrate65(BizNumber pHisadrate65) {
        hisadrate65 = pHisadrate65;
    }

    private BizNumber hisadrate66;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE66)
    public BizNumber getHisadrate66() {
        return hisadrate66;
    }

    public void setHisadrate66(BizNumber pHisadrate66) {
        hisadrate66 = pHisadrate66;
    }

    private BizNumber hisadrate67;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE67)
    public BizNumber getHisadrate67() {
        return hisadrate67;
    }

    public void setHisadrate67(BizNumber pHisadrate67) {
        hisadrate67 = pHisadrate67;
    }

    private BizNumber hisadrate68;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE68)
    public BizNumber getHisadrate68() {
        return hisadrate68;
    }

    public void setHisadrate68(BizNumber pHisadrate68) {
        hisadrate68 = pHisadrate68;
    }

    private BizNumber hisadrate69;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE69)
    public BizNumber getHisadrate69() {
        return hisadrate69;
    }

    public void setHisadrate69(BizNumber pHisadrate69) {
        hisadrate69 = pHisadrate69;
    }

    private BizNumber hisadrate70;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE70)
    public BizNumber getHisadrate70() {
        return hisadrate70;
    }

    public void setHisadrate70(BizNumber pHisadrate70) {
        hisadrate70 = pHisadrate70;
    }

    private BizNumber hisadrate71;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE71)
    public BizNumber getHisadrate71() {
        return hisadrate71;
    }

    public void setHisadrate71(BizNumber pHisadrate71) {
        hisadrate71 = pHisadrate71;
    }

    private BizNumber hisadrate72;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE72)
    public BizNumber getHisadrate72() {
        return hisadrate72;
    }

    public void setHisadrate72(BizNumber pHisadrate72) {
        hisadrate72 = pHisadrate72;
    }

    private BizNumber hisadrate73;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE73)
    public BizNumber getHisadrate73() {
        return hisadrate73;
    }

    public void setHisadrate73(BizNumber pHisadrate73) {
        hisadrate73 = pHisadrate73;
    }

    private BizNumber hisadrate74;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE74)
    public BizNumber getHisadrate74() {
        return hisadrate74;
    }

    public void setHisadrate74(BizNumber pHisadrate74) {
        hisadrate74 = pHisadrate74;
    }

    private BizNumber hisadrate75;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE75)
    public BizNumber getHisadrate75() {
        return hisadrate75;
    }

    public void setHisadrate75(BizNumber pHisadrate75) {
        hisadrate75 = pHisadrate75;
    }

    private BizNumber hisadrate76;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE76)
    public BizNumber getHisadrate76() {
        return hisadrate76;
    }

    public void setHisadrate76(BizNumber pHisadrate76) {
        hisadrate76 = pHisadrate76;
    }

    private BizNumber hisadrate77;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE77)
    public BizNumber getHisadrate77() {
        return hisadrate77;
    }

    public void setHisadrate77(BizNumber pHisadrate77) {
        hisadrate77 = pHisadrate77;
    }

    private BizNumber hisadrate78;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE78)
    public BizNumber getHisadrate78() {
        return hisadrate78;
    }

    public void setHisadrate78(BizNumber pHisadrate78) {
        hisadrate78 = pHisadrate78;
    }

    private BizNumber hisadrate79;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE79)
    public BizNumber getHisadrate79() {
        return hisadrate79;
    }

    public void setHisadrate79(BizNumber pHisadrate79) {
        hisadrate79 = pHisadrate79;
    }

    private BizNumber hisadrate80;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE80)
    public BizNumber getHisadrate80() {
        return hisadrate80;
    }

    public void setHisadrate80(BizNumber pHisadrate80) {
        hisadrate80 = pHisadrate80;
    }

    private BizNumber hisadrate81;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE81)
    public BizNumber getHisadrate81() {
        return hisadrate81;
    }

    public void setHisadrate81(BizNumber pHisadrate81) {
        hisadrate81 = pHisadrate81;
    }

    private BizNumber hisadrate82;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE82)
    public BizNumber getHisadrate82() {
        return hisadrate82;
    }

    public void setHisadrate82(BizNumber pHisadrate82) {
        hisadrate82 = pHisadrate82;
    }

    private BizNumber hisadrate83;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE83)
    public BizNumber getHisadrate83() {
        return hisadrate83;
    }

    public void setHisadrate83(BizNumber pHisadrate83) {
        hisadrate83 = pHisadrate83;
    }

    private BizNumber hisadrate84;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE84)
    public BizNumber getHisadrate84() {
        return hisadrate84;
    }

    public void setHisadrate84(BizNumber pHisadrate84) {
        hisadrate84 = pHisadrate84;
    }

    private BizNumber hisadrate85;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE85)
    public BizNumber getHisadrate85() {
        return hisadrate85;
    }

    public void setHisadrate85(BizNumber pHisadrate85) {
        hisadrate85 = pHisadrate85;
    }

    private BizNumber hisadrate86;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE86)
    public BizNumber getHisadrate86() {
        return hisadrate86;
    }

    public void setHisadrate86(BizNumber pHisadrate86) {
        hisadrate86 = pHisadrate86;
    }

    private BizNumber hisadrate87;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE87)
    public BizNumber getHisadrate87() {
        return hisadrate87;
    }

    public void setHisadrate87(BizNumber pHisadrate87) {
        hisadrate87 = pHisadrate87;
    }

    private BizNumber hisadrate88;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE88)
    public BizNumber getHisadrate88() {
        return hisadrate88;
    }

    public void setHisadrate88(BizNumber pHisadrate88) {
        hisadrate88 = pHisadrate88;
    }

    private BizNumber hisadrate89;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE89)
    public BizNumber getHisadrate89() {
        return hisadrate89;
    }

    public void setHisadrate89(BizNumber pHisadrate89) {
        hisadrate89 = pHisadrate89;
    }

    private BizNumber hisadrate90;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE90)
    public BizNumber getHisadrate90() {
        return hisadrate90;
    }

    public void setHisadrate90(BizNumber pHisadrate90) {
        hisadrate90 = pHisadrate90;
    }

    private BizNumber hisadrate91;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE91)
    public BizNumber getHisadrate91() {
        return hisadrate91;
    }

    public void setHisadrate91(BizNumber pHisadrate91) {
        hisadrate91 = pHisadrate91;
    }

    private BizNumber hisadrate92;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE92)
    public BizNumber getHisadrate92() {
        return hisadrate92;
    }

    public void setHisadrate92(BizNumber pHisadrate92) {
        hisadrate92 = pHisadrate92;
    }

    private BizNumber hisadrate93;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE93)
    public BizNumber getHisadrate93() {
        return hisadrate93;
    }

    public void setHisadrate93(BizNumber pHisadrate93) {
        hisadrate93 = pHisadrate93;
    }

    private BizNumber hisadrate94;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE94)
    public BizNumber getHisadrate94() {
        return hisadrate94;
    }

    public void setHisadrate94(BizNumber pHisadrate94) {
        hisadrate94 = pHisadrate94;
    }

    private BizNumber hisadrate95;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE95)
    public BizNumber getHisadrate95() {
        return hisadrate95;
    }

    public void setHisadrate95(BizNumber pHisadrate95) {
        hisadrate95 = pHisadrate95;
    }

    private BizNumber hisadrate96;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE96)
    public BizNumber getHisadrate96() {
        return hisadrate96;
    }

    public void setHisadrate96(BizNumber pHisadrate96) {
        hisadrate96 = pHisadrate96;
    }

    private BizNumber hisadrate97;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE97)
    public BizNumber getHisadrate97() {
        return hisadrate97;
    }

    public void setHisadrate97(BizNumber pHisadrate97) {
        hisadrate97 = pHisadrate97;
    }

    private BizNumber hisadrate98;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE98)
    public BizNumber getHisadrate98() {
        return hisadrate98;
    }

    public void setHisadrate98(BizNumber pHisadrate98) {
        hisadrate98 = pHisadrate98;
    }

    private BizNumber hisadrate99;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.HISADRATE99)
    public BizNumber getHisadrate99() {
        return hisadrate99;
    }

    public void setHisadrate99(BizNumber pHisadrate99) {
        hisadrate99 = pHisadrate99;
    }

    private BizNumber dyouvrate00;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE00)
    public BizNumber getDyouvrate00() {
        return dyouvrate00;
    }

    public void setDyouvrate00(BizNumber pDyouvrate00) {
        dyouvrate00 = pDyouvrate00;
    }

    private BizNumber dyouvrate01;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE01)
    public BizNumber getDyouvrate01() {
        return dyouvrate01;
    }

    public void setDyouvrate01(BizNumber pDyouvrate01) {
        dyouvrate01 = pDyouvrate01;
    }

    private BizNumber dyouvrate02;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE02)
    public BizNumber getDyouvrate02() {
        return dyouvrate02;
    }

    public void setDyouvrate02(BizNumber pDyouvrate02) {
        dyouvrate02 = pDyouvrate02;
    }

    private BizNumber dyouvrate03;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE03)
    public BizNumber getDyouvrate03() {
        return dyouvrate03;
    }

    public void setDyouvrate03(BizNumber pDyouvrate03) {
        dyouvrate03 = pDyouvrate03;
    }

    private BizNumber dyouvrate04;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE04)
    public BizNumber getDyouvrate04() {
        return dyouvrate04;
    }

    public void setDyouvrate04(BizNumber pDyouvrate04) {
        dyouvrate04 = pDyouvrate04;
    }

    private BizNumber dyouvrate05;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE05)
    public BizNumber getDyouvrate05() {
        return dyouvrate05;
    }

    public void setDyouvrate05(BizNumber pDyouvrate05) {
        dyouvrate05 = pDyouvrate05;
    }

    private BizNumber dyouvrate06;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE06)
    public BizNumber getDyouvrate06() {
        return dyouvrate06;
    }

    public void setDyouvrate06(BizNumber pDyouvrate06) {
        dyouvrate06 = pDyouvrate06;
    }

    private BizNumber dyouvrate07;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE07)
    public BizNumber getDyouvrate07() {
        return dyouvrate07;
    }

    public void setDyouvrate07(BizNumber pDyouvrate07) {
        dyouvrate07 = pDyouvrate07;
    }

    private BizNumber dyouvrate08;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE08)
    public BizNumber getDyouvrate08() {
        return dyouvrate08;
    }

    public void setDyouvrate08(BizNumber pDyouvrate08) {
        dyouvrate08 = pDyouvrate08;
    }

    private BizNumber dyouvrate09;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE09)
    public BizNumber getDyouvrate09() {
        return dyouvrate09;
    }

    public void setDyouvrate09(BizNumber pDyouvrate09) {
        dyouvrate09 = pDyouvrate09;
    }

    private BizNumber dyouvrate10;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE10)
    public BizNumber getDyouvrate10() {
        return dyouvrate10;
    }

    public void setDyouvrate10(BizNumber pDyouvrate10) {
        dyouvrate10 = pDyouvrate10;
    }

    private BizNumber dyouvrate11;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE11)
    public BizNumber getDyouvrate11() {
        return dyouvrate11;
    }

    public void setDyouvrate11(BizNumber pDyouvrate11) {
        dyouvrate11 = pDyouvrate11;
    }

    private BizNumber dyouvrate12;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE12)
    public BizNumber getDyouvrate12() {
        return dyouvrate12;
    }

    public void setDyouvrate12(BizNumber pDyouvrate12) {
        dyouvrate12 = pDyouvrate12;
    }

    private BizNumber dyouvrate13;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE13)
    public BizNumber getDyouvrate13() {
        return dyouvrate13;
    }

    public void setDyouvrate13(BizNumber pDyouvrate13) {
        dyouvrate13 = pDyouvrate13;
    }

    private BizNumber dyouvrate14;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE14)
    public BizNumber getDyouvrate14() {
        return dyouvrate14;
    }

    public void setDyouvrate14(BizNumber pDyouvrate14) {
        dyouvrate14 = pDyouvrate14;
    }

    private BizNumber dyouvrate15;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE15)
    public BizNumber getDyouvrate15() {
        return dyouvrate15;
    }

    public void setDyouvrate15(BizNumber pDyouvrate15) {
        dyouvrate15 = pDyouvrate15;
    }

    private BizNumber dyouvrate16;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE16)
    public BizNumber getDyouvrate16() {
        return dyouvrate16;
    }

    public void setDyouvrate16(BizNumber pDyouvrate16) {
        dyouvrate16 = pDyouvrate16;
    }

    private BizNumber dyouvrate17;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE17)
    public BizNumber getDyouvrate17() {
        return dyouvrate17;
    }

    public void setDyouvrate17(BizNumber pDyouvrate17) {
        dyouvrate17 = pDyouvrate17;
    }

    private BizNumber dyouvrate18;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE18)
    public BizNumber getDyouvrate18() {
        return dyouvrate18;
    }

    public void setDyouvrate18(BizNumber pDyouvrate18) {
        dyouvrate18 = pDyouvrate18;
    }

    private BizNumber dyouvrate19;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE19)
    public BizNumber getDyouvrate19() {
        return dyouvrate19;
    }

    public void setDyouvrate19(BizNumber pDyouvrate19) {
        dyouvrate19 = pDyouvrate19;
    }

    private BizNumber dyouvrate20;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE20)
    public BizNumber getDyouvrate20() {
        return dyouvrate20;
    }

    public void setDyouvrate20(BizNumber pDyouvrate20) {
        dyouvrate20 = pDyouvrate20;
    }

    private BizNumber dyouvrate21;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE21)
    public BizNumber getDyouvrate21() {
        return dyouvrate21;
    }

    public void setDyouvrate21(BizNumber pDyouvrate21) {
        dyouvrate21 = pDyouvrate21;
    }

    private BizNumber dyouvrate22;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE22)
    public BizNumber getDyouvrate22() {
        return dyouvrate22;
    }

    public void setDyouvrate22(BizNumber pDyouvrate22) {
        dyouvrate22 = pDyouvrate22;
    }

    private BizNumber dyouvrate23;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE23)
    public BizNumber getDyouvrate23() {
        return dyouvrate23;
    }

    public void setDyouvrate23(BizNumber pDyouvrate23) {
        dyouvrate23 = pDyouvrate23;
    }

    private BizNumber dyouvrate24;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE24)
    public BizNumber getDyouvrate24() {
        return dyouvrate24;
    }

    public void setDyouvrate24(BizNumber pDyouvrate24) {
        dyouvrate24 = pDyouvrate24;
    }

    private BizNumber dyouvrate25;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE25)
    public BizNumber getDyouvrate25() {
        return dyouvrate25;
    }

    public void setDyouvrate25(BizNumber pDyouvrate25) {
        dyouvrate25 = pDyouvrate25;
    }

    private BizNumber dyouvrate26;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE26)
    public BizNumber getDyouvrate26() {
        return dyouvrate26;
    }

    public void setDyouvrate26(BizNumber pDyouvrate26) {
        dyouvrate26 = pDyouvrate26;
    }

    private BizNumber dyouvrate27;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE27)
    public BizNumber getDyouvrate27() {
        return dyouvrate27;
    }

    public void setDyouvrate27(BizNumber pDyouvrate27) {
        dyouvrate27 = pDyouvrate27;
    }

    private BizNumber dyouvrate28;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE28)
    public BizNumber getDyouvrate28() {
        return dyouvrate28;
    }

    public void setDyouvrate28(BizNumber pDyouvrate28) {
        dyouvrate28 = pDyouvrate28;
    }

    private BizNumber dyouvrate29;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE29)
    public BizNumber getDyouvrate29() {
        return dyouvrate29;
    }

    public void setDyouvrate29(BizNumber pDyouvrate29) {
        dyouvrate29 = pDyouvrate29;
    }

    private BizNumber dyouvrate30;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE30)
    public BizNumber getDyouvrate30() {
        return dyouvrate30;
    }

    public void setDyouvrate30(BizNumber pDyouvrate30) {
        dyouvrate30 = pDyouvrate30;
    }

    private BizNumber dyouvrate31;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE31)
    public BizNumber getDyouvrate31() {
        return dyouvrate31;
    }

    public void setDyouvrate31(BizNumber pDyouvrate31) {
        dyouvrate31 = pDyouvrate31;
    }

    private BizNumber dyouvrate32;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE32)
    public BizNumber getDyouvrate32() {
        return dyouvrate32;
    }

    public void setDyouvrate32(BizNumber pDyouvrate32) {
        dyouvrate32 = pDyouvrate32;
    }

    private BizNumber dyouvrate33;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE33)
    public BizNumber getDyouvrate33() {
        return dyouvrate33;
    }

    public void setDyouvrate33(BizNumber pDyouvrate33) {
        dyouvrate33 = pDyouvrate33;
    }

    private BizNumber dyouvrate34;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE34)
    public BizNumber getDyouvrate34() {
        return dyouvrate34;
    }

    public void setDyouvrate34(BizNumber pDyouvrate34) {
        dyouvrate34 = pDyouvrate34;
    }

    private BizNumber dyouvrate35;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE35)
    public BizNumber getDyouvrate35() {
        return dyouvrate35;
    }

    public void setDyouvrate35(BizNumber pDyouvrate35) {
        dyouvrate35 = pDyouvrate35;
    }

    private BizNumber dyouvrate36;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE36)
    public BizNumber getDyouvrate36() {
        return dyouvrate36;
    }

    public void setDyouvrate36(BizNumber pDyouvrate36) {
        dyouvrate36 = pDyouvrate36;
    }

    private BizNumber dyouvrate37;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE37)
    public BizNumber getDyouvrate37() {
        return dyouvrate37;
    }

    public void setDyouvrate37(BizNumber pDyouvrate37) {
        dyouvrate37 = pDyouvrate37;
    }

    private BizNumber dyouvrate38;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE38)
    public BizNumber getDyouvrate38() {
        return dyouvrate38;
    }

    public void setDyouvrate38(BizNumber pDyouvrate38) {
        dyouvrate38 = pDyouvrate38;
    }

    private BizNumber dyouvrate39;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE39)
    public BizNumber getDyouvrate39() {
        return dyouvrate39;
    }

    public void setDyouvrate39(BizNumber pDyouvrate39) {
        dyouvrate39 = pDyouvrate39;
    }

    private BizNumber dyouvrate40;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE40)
    public BizNumber getDyouvrate40() {
        return dyouvrate40;
    }

    public void setDyouvrate40(BizNumber pDyouvrate40) {
        dyouvrate40 = pDyouvrate40;
    }

    private BizNumber dyouvrate41;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE41)
    public BizNumber getDyouvrate41() {
        return dyouvrate41;
    }

    public void setDyouvrate41(BizNumber pDyouvrate41) {
        dyouvrate41 = pDyouvrate41;
    }

    private BizNumber dyouvrate42;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE42)
    public BizNumber getDyouvrate42() {
        return dyouvrate42;
    }

    public void setDyouvrate42(BizNumber pDyouvrate42) {
        dyouvrate42 = pDyouvrate42;
    }

    private BizNumber dyouvrate43;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE43)
    public BizNumber getDyouvrate43() {
        return dyouvrate43;
    }

    public void setDyouvrate43(BizNumber pDyouvrate43) {
        dyouvrate43 = pDyouvrate43;
    }

    private BizNumber dyouvrate44;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE44)
    public BizNumber getDyouvrate44() {
        return dyouvrate44;
    }

    public void setDyouvrate44(BizNumber pDyouvrate44) {
        dyouvrate44 = pDyouvrate44;
    }

    private BizNumber dyouvrate45;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE45)
    public BizNumber getDyouvrate45() {
        return dyouvrate45;
    }

    public void setDyouvrate45(BizNumber pDyouvrate45) {
        dyouvrate45 = pDyouvrate45;
    }

    private BizNumber dyouvrate46;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE46)
    public BizNumber getDyouvrate46() {
        return dyouvrate46;
    }

    public void setDyouvrate46(BizNumber pDyouvrate46) {
        dyouvrate46 = pDyouvrate46;
    }

    private BizNumber dyouvrate47;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE47)
    public BizNumber getDyouvrate47() {
        return dyouvrate47;
    }

    public void setDyouvrate47(BizNumber pDyouvrate47) {
        dyouvrate47 = pDyouvrate47;
    }

    private BizNumber dyouvrate48;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE48)
    public BizNumber getDyouvrate48() {
        return dyouvrate48;
    }

    public void setDyouvrate48(BizNumber pDyouvrate48) {
        dyouvrate48 = pDyouvrate48;
    }

    private BizNumber dyouvrate49;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE49)
    public BizNumber getDyouvrate49() {
        return dyouvrate49;
    }

    public void setDyouvrate49(BizNumber pDyouvrate49) {
        dyouvrate49 = pDyouvrate49;
    }

    private BizNumber dyouvrate50;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE50)
    public BizNumber getDyouvrate50() {
        return dyouvrate50;
    }

    public void setDyouvrate50(BizNumber pDyouvrate50) {
        dyouvrate50 = pDyouvrate50;
    }

    private BizNumber dyouvrate51;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE51)
    public BizNumber getDyouvrate51() {
        return dyouvrate51;
    }

    public void setDyouvrate51(BizNumber pDyouvrate51) {
        dyouvrate51 = pDyouvrate51;
    }

    private BizNumber dyouvrate52;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE52)
    public BizNumber getDyouvrate52() {
        return dyouvrate52;
    }

    public void setDyouvrate52(BizNumber pDyouvrate52) {
        dyouvrate52 = pDyouvrate52;
    }

    private BizNumber dyouvrate53;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE53)
    public BizNumber getDyouvrate53() {
        return dyouvrate53;
    }

    public void setDyouvrate53(BizNumber pDyouvrate53) {
        dyouvrate53 = pDyouvrate53;
    }

    private BizNumber dyouvrate54;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE54)
    public BizNumber getDyouvrate54() {
        return dyouvrate54;
    }

    public void setDyouvrate54(BizNumber pDyouvrate54) {
        dyouvrate54 = pDyouvrate54;
    }

    private BizNumber dyouvrate55;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE55)
    public BizNumber getDyouvrate55() {
        return dyouvrate55;
    }

    public void setDyouvrate55(BizNumber pDyouvrate55) {
        dyouvrate55 = pDyouvrate55;
    }

    private BizNumber dyouvrate56;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE56)
    public BizNumber getDyouvrate56() {
        return dyouvrate56;
    }

    public void setDyouvrate56(BizNumber pDyouvrate56) {
        dyouvrate56 = pDyouvrate56;
    }

    private BizNumber dyouvrate57;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE57)
    public BizNumber getDyouvrate57() {
        return dyouvrate57;
    }

    public void setDyouvrate57(BizNumber pDyouvrate57) {
        dyouvrate57 = pDyouvrate57;
    }

    private BizNumber dyouvrate58;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE58)
    public BizNumber getDyouvrate58() {
        return dyouvrate58;
    }

    public void setDyouvrate58(BizNumber pDyouvrate58) {
        dyouvrate58 = pDyouvrate58;
    }

    private BizNumber dyouvrate59;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE59)
    public BizNumber getDyouvrate59() {
        return dyouvrate59;
    }

    public void setDyouvrate59(BizNumber pDyouvrate59) {
        dyouvrate59 = pDyouvrate59;
    }

    private BizNumber dyouvrate60;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE60)
    public BizNumber getDyouvrate60() {
        return dyouvrate60;
    }

    public void setDyouvrate60(BizNumber pDyouvrate60) {
        dyouvrate60 = pDyouvrate60;
    }

    private BizNumber dyouvrate61;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE61)
    public BizNumber getDyouvrate61() {
        return dyouvrate61;
    }

    public void setDyouvrate61(BizNumber pDyouvrate61) {
        dyouvrate61 = pDyouvrate61;
    }

    private BizNumber dyouvrate62;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE62)
    public BizNumber getDyouvrate62() {
        return dyouvrate62;
    }

    public void setDyouvrate62(BizNumber pDyouvrate62) {
        dyouvrate62 = pDyouvrate62;
    }

    private BizNumber dyouvrate63;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE63)
    public BizNumber getDyouvrate63() {
        return dyouvrate63;
    }

    public void setDyouvrate63(BizNumber pDyouvrate63) {
        dyouvrate63 = pDyouvrate63;
    }

    private BizNumber dyouvrate64;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE64)
    public BizNumber getDyouvrate64() {
        return dyouvrate64;
    }

    public void setDyouvrate64(BizNumber pDyouvrate64) {
        dyouvrate64 = pDyouvrate64;
    }

    private BizNumber dyouvrate65;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE65)
    public BizNumber getDyouvrate65() {
        return dyouvrate65;
    }

    public void setDyouvrate65(BizNumber pDyouvrate65) {
        dyouvrate65 = pDyouvrate65;
    }

    private BizNumber dyouvrate66;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE66)
    public BizNumber getDyouvrate66() {
        return dyouvrate66;
    }

    public void setDyouvrate66(BizNumber pDyouvrate66) {
        dyouvrate66 = pDyouvrate66;
    }

    private BizNumber dyouvrate67;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE67)
    public BizNumber getDyouvrate67() {
        return dyouvrate67;
    }

    public void setDyouvrate67(BizNumber pDyouvrate67) {
        dyouvrate67 = pDyouvrate67;
    }

    private BizNumber dyouvrate68;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE68)
    public BizNumber getDyouvrate68() {
        return dyouvrate68;
    }

    public void setDyouvrate68(BizNumber pDyouvrate68) {
        dyouvrate68 = pDyouvrate68;
    }

    private BizNumber dyouvrate69;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE69)
    public BizNumber getDyouvrate69() {
        return dyouvrate69;
    }

    public void setDyouvrate69(BizNumber pDyouvrate69) {
        dyouvrate69 = pDyouvrate69;
    }

    private BizNumber dyouvrate70;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE70)
    public BizNumber getDyouvrate70() {
        return dyouvrate70;
    }

    public void setDyouvrate70(BizNumber pDyouvrate70) {
        dyouvrate70 = pDyouvrate70;
    }

    private BizNumber dyouvrate71;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE71)
    public BizNumber getDyouvrate71() {
        return dyouvrate71;
    }

    public void setDyouvrate71(BizNumber pDyouvrate71) {
        dyouvrate71 = pDyouvrate71;
    }

    private BizNumber dyouvrate72;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE72)
    public BizNumber getDyouvrate72() {
        return dyouvrate72;
    }

    public void setDyouvrate72(BizNumber pDyouvrate72) {
        dyouvrate72 = pDyouvrate72;
    }

    private BizNumber dyouvrate73;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE73)
    public BizNumber getDyouvrate73() {
        return dyouvrate73;
    }

    public void setDyouvrate73(BizNumber pDyouvrate73) {
        dyouvrate73 = pDyouvrate73;
    }

    private BizNumber dyouvrate74;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE74)
    public BizNumber getDyouvrate74() {
        return dyouvrate74;
    }

    public void setDyouvrate74(BizNumber pDyouvrate74) {
        dyouvrate74 = pDyouvrate74;
    }

    private BizNumber dyouvrate75;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE75)
    public BizNumber getDyouvrate75() {
        return dyouvrate75;
    }

    public void setDyouvrate75(BizNumber pDyouvrate75) {
        dyouvrate75 = pDyouvrate75;
    }

    private BizNumber dyouvrate76;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE76)
    public BizNumber getDyouvrate76() {
        return dyouvrate76;
    }

    public void setDyouvrate76(BizNumber pDyouvrate76) {
        dyouvrate76 = pDyouvrate76;
    }

    private BizNumber dyouvrate77;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE77)
    public BizNumber getDyouvrate77() {
        return dyouvrate77;
    }

    public void setDyouvrate77(BizNumber pDyouvrate77) {
        dyouvrate77 = pDyouvrate77;
    }

    private BizNumber dyouvrate78;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE78)
    public BizNumber getDyouvrate78() {
        return dyouvrate78;
    }

    public void setDyouvrate78(BizNumber pDyouvrate78) {
        dyouvrate78 = pDyouvrate78;
    }

    private BizNumber dyouvrate79;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE79)
    public BizNumber getDyouvrate79() {
        return dyouvrate79;
    }

    public void setDyouvrate79(BizNumber pDyouvrate79) {
        dyouvrate79 = pDyouvrate79;
    }

    private BizNumber dyouvrate80;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE80)
    public BizNumber getDyouvrate80() {
        return dyouvrate80;
    }

    public void setDyouvrate80(BizNumber pDyouvrate80) {
        dyouvrate80 = pDyouvrate80;
    }

    private BizNumber dyouvrate81;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE81)
    public BizNumber getDyouvrate81() {
        return dyouvrate81;
    }

    public void setDyouvrate81(BizNumber pDyouvrate81) {
        dyouvrate81 = pDyouvrate81;
    }

    private BizNumber dyouvrate82;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE82)
    public BizNumber getDyouvrate82() {
        return dyouvrate82;
    }

    public void setDyouvrate82(BizNumber pDyouvrate82) {
        dyouvrate82 = pDyouvrate82;
    }

    private BizNumber dyouvrate83;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE83)
    public BizNumber getDyouvrate83() {
        return dyouvrate83;
    }

    public void setDyouvrate83(BizNumber pDyouvrate83) {
        dyouvrate83 = pDyouvrate83;
    }

    private BizNumber dyouvrate84;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE84)
    public BizNumber getDyouvrate84() {
        return dyouvrate84;
    }

    public void setDyouvrate84(BizNumber pDyouvrate84) {
        dyouvrate84 = pDyouvrate84;
    }

    private BizNumber dyouvrate85;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE85)
    public BizNumber getDyouvrate85() {
        return dyouvrate85;
    }

    public void setDyouvrate85(BizNumber pDyouvrate85) {
        dyouvrate85 = pDyouvrate85;
    }

    private BizNumber dyouvrate86;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE86)
    public BizNumber getDyouvrate86() {
        return dyouvrate86;
    }

    public void setDyouvrate86(BizNumber pDyouvrate86) {
        dyouvrate86 = pDyouvrate86;
    }

    private BizNumber dyouvrate87;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE87)
    public BizNumber getDyouvrate87() {
        return dyouvrate87;
    }

    public void setDyouvrate87(BizNumber pDyouvrate87) {
        dyouvrate87 = pDyouvrate87;
    }

    private BizNumber dyouvrate88;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE88)
    public BizNumber getDyouvrate88() {
        return dyouvrate88;
    }

    public void setDyouvrate88(BizNumber pDyouvrate88) {
        dyouvrate88 = pDyouvrate88;
    }

    private BizNumber dyouvrate89;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE89)
    public BizNumber getDyouvrate89() {
        return dyouvrate89;
    }

    public void setDyouvrate89(BizNumber pDyouvrate89) {
        dyouvrate89 = pDyouvrate89;
    }

    private BizNumber dyouvrate90;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE90)
    public BizNumber getDyouvrate90() {
        return dyouvrate90;
    }

    public void setDyouvrate90(BizNumber pDyouvrate90) {
        dyouvrate90 = pDyouvrate90;
    }

    private BizNumber dyouvrate91;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE91)
    public BizNumber getDyouvrate91() {
        return dyouvrate91;
    }

    public void setDyouvrate91(BizNumber pDyouvrate91) {
        dyouvrate91 = pDyouvrate91;
    }

    private BizNumber dyouvrate92;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE92)
    public BizNumber getDyouvrate92() {
        return dyouvrate92;
    }

    public void setDyouvrate92(BizNumber pDyouvrate92) {
        dyouvrate92 = pDyouvrate92;
    }

    private BizNumber dyouvrate93;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE93)
    public BizNumber getDyouvrate93() {
        return dyouvrate93;
    }

    public void setDyouvrate93(BizNumber pDyouvrate93) {
        dyouvrate93 = pDyouvrate93;
    }

    private BizNumber dyouvrate94;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE94)
    public BizNumber getDyouvrate94() {
        return dyouvrate94;
    }

    public void setDyouvrate94(BizNumber pDyouvrate94) {
        dyouvrate94 = pDyouvrate94;
    }

    private BizNumber dyouvrate95;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE95)
    public BizNumber getDyouvrate95() {
        return dyouvrate95;
    }

    public void setDyouvrate95(BizNumber pDyouvrate95) {
        dyouvrate95 = pDyouvrate95;
    }

    private BizNumber dyouvrate96;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE96)
    public BizNumber getDyouvrate96() {
        return dyouvrate96;
    }

    public void setDyouvrate96(BizNumber pDyouvrate96) {
        dyouvrate96 = pDyouvrate96;
    }

    private BizNumber dyouvrate97;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE97)
    public BizNumber getDyouvrate97() {
        return dyouvrate97;
    }

    public void setDyouvrate97(BizNumber pDyouvrate97) {
        dyouvrate97 = pDyouvrate97;
    }

    private BizNumber dyouvrate98;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE98)
    public BizNumber getDyouvrate98() {
        return dyouvrate98;
    }

    public void setDyouvrate98(BizNumber pDyouvrate98) {
        dyouvrate98 = pDyouvrate98;
    }

    private BizNumber dyouvrate99;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.DYOUVRATE99)
    public BizNumber getDyouvrate99() {
        return dyouvrate99;
    }

    public void setDyouvrate99(BizNumber pDyouvrate99) {
        dyouvrate99 = pDyouvrate99;
    }

    private BizNumber kikensrate00;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE00)
    public BizNumber getKikensrate00() {
        return kikensrate00;
    }

    public void setKikensrate00(BizNumber pKikensrate00) {
        kikensrate00 = pKikensrate00;
    }

    private BizNumber kikensrate01;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE01)
    public BizNumber getKikensrate01() {
        return kikensrate01;
    }

    public void setKikensrate01(BizNumber pKikensrate01) {
        kikensrate01 = pKikensrate01;
    }

    private BizNumber kikensrate02;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE02)
    public BizNumber getKikensrate02() {
        return kikensrate02;
    }

    public void setKikensrate02(BizNumber pKikensrate02) {
        kikensrate02 = pKikensrate02;
    }

    private BizNumber kikensrate03;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE03)
    public BizNumber getKikensrate03() {
        return kikensrate03;
    }

    public void setKikensrate03(BizNumber pKikensrate03) {
        kikensrate03 = pKikensrate03;
    }

    private BizNumber kikensrate04;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE04)
    public BizNumber getKikensrate04() {
        return kikensrate04;
    }

    public void setKikensrate04(BizNumber pKikensrate04) {
        kikensrate04 = pKikensrate04;
    }

    private BizNumber kikensrate05;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE05)
    public BizNumber getKikensrate05() {
        return kikensrate05;
    }

    public void setKikensrate05(BizNumber pKikensrate05) {
        kikensrate05 = pKikensrate05;
    }

    private BizNumber kikensrate06;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE06)
    public BizNumber getKikensrate06() {
        return kikensrate06;
    }

    public void setKikensrate06(BizNumber pKikensrate06) {
        kikensrate06 = pKikensrate06;
    }

    private BizNumber kikensrate07;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE07)
    public BizNumber getKikensrate07() {
        return kikensrate07;
    }

    public void setKikensrate07(BizNumber pKikensrate07) {
        kikensrate07 = pKikensrate07;
    }

    private BizNumber kikensrate08;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE08)
    public BizNumber getKikensrate08() {
        return kikensrate08;
    }

    public void setKikensrate08(BizNumber pKikensrate08) {
        kikensrate08 = pKikensrate08;
    }

    private BizNumber kikensrate09;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE09)
    public BizNumber getKikensrate09() {
        return kikensrate09;
    }

    public void setKikensrate09(BizNumber pKikensrate09) {
        kikensrate09 = pKikensrate09;
    }

    private BizNumber kikensrate10;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE10)
    public BizNumber getKikensrate10() {
        return kikensrate10;
    }

    public void setKikensrate10(BizNumber pKikensrate10) {
        kikensrate10 = pKikensrate10;
    }

    private BizNumber kikensrate11;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE11)
    public BizNumber getKikensrate11() {
        return kikensrate11;
    }

    public void setKikensrate11(BizNumber pKikensrate11) {
        kikensrate11 = pKikensrate11;
    }

    private BizNumber kikensrate12;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE12)
    public BizNumber getKikensrate12() {
        return kikensrate12;
    }

    public void setKikensrate12(BizNumber pKikensrate12) {
        kikensrate12 = pKikensrate12;
    }

    private BizNumber kikensrate13;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE13)
    public BizNumber getKikensrate13() {
        return kikensrate13;
    }

    public void setKikensrate13(BizNumber pKikensrate13) {
        kikensrate13 = pKikensrate13;
    }

    private BizNumber kikensrate14;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE14)
    public BizNumber getKikensrate14() {
        return kikensrate14;
    }

    public void setKikensrate14(BizNumber pKikensrate14) {
        kikensrate14 = pKikensrate14;
    }

    private BizNumber kikensrate15;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE15)
    public BizNumber getKikensrate15() {
        return kikensrate15;
    }

    public void setKikensrate15(BizNumber pKikensrate15) {
        kikensrate15 = pKikensrate15;
    }

    private BizNumber kikensrate16;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE16)
    public BizNumber getKikensrate16() {
        return kikensrate16;
    }

    public void setKikensrate16(BizNumber pKikensrate16) {
        kikensrate16 = pKikensrate16;
    }

    private BizNumber kikensrate17;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE17)
    public BizNumber getKikensrate17() {
        return kikensrate17;
    }

    public void setKikensrate17(BizNumber pKikensrate17) {
        kikensrate17 = pKikensrate17;
    }

    private BizNumber kikensrate18;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE18)
    public BizNumber getKikensrate18() {
        return kikensrate18;
    }

    public void setKikensrate18(BizNumber pKikensrate18) {
        kikensrate18 = pKikensrate18;
    }

    private BizNumber kikensrate19;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE19)
    public BizNumber getKikensrate19() {
        return kikensrate19;
    }

    public void setKikensrate19(BizNumber pKikensrate19) {
        kikensrate19 = pKikensrate19;
    }

    private BizNumber kikensrate20;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE20)
    public BizNumber getKikensrate20() {
        return kikensrate20;
    }

    public void setKikensrate20(BizNumber pKikensrate20) {
        kikensrate20 = pKikensrate20;
    }

    private BizNumber kikensrate21;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE21)
    public BizNumber getKikensrate21() {
        return kikensrate21;
    }

    public void setKikensrate21(BizNumber pKikensrate21) {
        kikensrate21 = pKikensrate21;
    }

    private BizNumber kikensrate22;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE22)
    public BizNumber getKikensrate22() {
        return kikensrate22;
    }

    public void setKikensrate22(BizNumber pKikensrate22) {
        kikensrate22 = pKikensrate22;
    }

    private BizNumber kikensrate23;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE23)
    public BizNumber getKikensrate23() {
        return kikensrate23;
    }

    public void setKikensrate23(BizNumber pKikensrate23) {
        kikensrate23 = pKikensrate23;
    }

    private BizNumber kikensrate24;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE24)
    public BizNumber getKikensrate24() {
        return kikensrate24;
    }

    public void setKikensrate24(BizNumber pKikensrate24) {
        kikensrate24 = pKikensrate24;
    }

    private BizNumber kikensrate25;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE25)
    public BizNumber getKikensrate25() {
        return kikensrate25;
    }

    public void setKikensrate25(BizNumber pKikensrate25) {
        kikensrate25 = pKikensrate25;
    }

    private BizNumber kikensrate26;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE26)
    public BizNumber getKikensrate26() {
        return kikensrate26;
    }

    public void setKikensrate26(BizNumber pKikensrate26) {
        kikensrate26 = pKikensrate26;
    }

    private BizNumber kikensrate27;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE27)
    public BizNumber getKikensrate27() {
        return kikensrate27;
    }

    public void setKikensrate27(BizNumber pKikensrate27) {
        kikensrate27 = pKikensrate27;
    }

    private BizNumber kikensrate28;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE28)
    public BizNumber getKikensrate28() {
        return kikensrate28;
    }

    public void setKikensrate28(BizNumber pKikensrate28) {
        kikensrate28 = pKikensrate28;
    }

    private BizNumber kikensrate29;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE29)
    public BizNumber getKikensrate29() {
        return kikensrate29;
    }

    public void setKikensrate29(BizNumber pKikensrate29) {
        kikensrate29 = pKikensrate29;
    }

    private BizNumber kikensrate30;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE30)
    public BizNumber getKikensrate30() {
        return kikensrate30;
    }

    public void setKikensrate30(BizNumber pKikensrate30) {
        kikensrate30 = pKikensrate30;
    }

    private BizNumber kikensrate31;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE31)
    public BizNumber getKikensrate31() {
        return kikensrate31;
    }

    public void setKikensrate31(BizNumber pKikensrate31) {
        kikensrate31 = pKikensrate31;
    }

    private BizNumber kikensrate32;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE32)
    public BizNumber getKikensrate32() {
        return kikensrate32;
    }

    public void setKikensrate32(BizNumber pKikensrate32) {
        kikensrate32 = pKikensrate32;
    }

    private BizNumber kikensrate33;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE33)
    public BizNumber getKikensrate33() {
        return kikensrate33;
    }

    public void setKikensrate33(BizNumber pKikensrate33) {
        kikensrate33 = pKikensrate33;
    }

    private BizNumber kikensrate34;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE34)
    public BizNumber getKikensrate34() {
        return kikensrate34;
    }

    public void setKikensrate34(BizNumber pKikensrate34) {
        kikensrate34 = pKikensrate34;
    }

    private BizNumber kikensrate35;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE35)
    public BizNumber getKikensrate35() {
        return kikensrate35;
    }

    public void setKikensrate35(BizNumber pKikensrate35) {
        kikensrate35 = pKikensrate35;
    }

    private BizNumber kikensrate36;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE36)
    public BizNumber getKikensrate36() {
        return kikensrate36;
    }

    public void setKikensrate36(BizNumber pKikensrate36) {
        kikensrate36 = pKikensrate36;
    }

    private BizNumber kikensrate37;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE37)
    public BizNumber getKikensrate37() {
        return kikensrate37;
    }

    public void setKikensrate37(BizNumber pKikensrate37) {
        kikensrate37 = pKikensrate37;
    }

    private BizNumber kikensrate38;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE38)
    public BizNumber getKikensrate38() {
        return kikensrate38;
    }

    public void setKikensrate38(BizNumber pKikensrate38) {
        kikensrate38 = pKikensrate38;
    }

    private BizNumber kikensrate39;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE39)
    public BizNumber getKikensrate39() {
        return kikensrate39;
    }

    public void setKikensrate39(BizNumber pKikensrate39) {
        kikensrate39 = pKikensrate39;
    }

    private BizNumber kikensrate40;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE40)
    public BizNumber getKikensrate40() {
        return kikensrate40;
    }

    public void setKikensrate40(BizNumber pKikensrate40) {
        kikensrate40 = pKikensrate40;
    }

    private BizNumber kikensrate41;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE41)
    public BizNumber getKikensrate41() {
        return kikensrate41;
    }

    public void setKikensrate41(BizNumber pKikensrate41) {
        kikensrate41 = pKikensrate41;
    }

    private BizNumber kikensrate42;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE42)
    public BizNumber getKikensrate42() {
        return kikensrate42;
    }

    public void setKikensrate42(BizNumber pKikensrate42) {
        kikensrate42 = pKikensrate42;
    }

    private BizNumber kikensrate43;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE43)
    public BizNumber getKikensrate43() {
        return kikensrate43;
    }

    public void setKikensrate43(BizNumber pKikensrate43) {
        kikensrate43 = pKikensrate43;
    }

    private BizNumber kikensrate44;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE44)
    public BizNumber getKikensrate44() {
        return kikensrate44;
    }

    public void setKikensrate44(BizNumber pKikensrate44) {
        kikensrate44 = pKikensrate44;
    }

    private BizNumber kikensrate45;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE45)
    public BizNumber getKikensrate45() {
        return kikensrate45;
    }

    public void setKikensrate45(BizNumber pKikensrate45) {
        kikensrate45 = pKikensrate45;
    }

    private BizNumber kikensrate46;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE46)
    public BizNumber getKikensrate46() {
        return kikensrate46;
    }

    public void setKikensrate46(BizNumber pKikensrate46) {
        kikensrate46 = pKikensrate46;
    }

    private BizNumber kikensrate47;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE47)
    public BizNumber getKikensrate47() {
        return kikensrate47;
    }

    public void setKikensrate47(BizNumber pKikensrate47) {
        kikensrate47 = pKikensrate47;
    }

    private BizNumber kikensrate48;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE48)
    public BizNumber getKikensrate48() {
        return kikensrate48;
    }

    public void setKikensrate48(BizNumber pKikensrate48) {
        kikensrate48 = pKikensrate48;
    }

    private BizNumber kikensrate49;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE49)
    public BizNumber getKikensrate49() {
        return kikensrate49;
    }

    public void setKikensrate49(BizNumber pKikensrate49) {
        kikensrate49 = pKikensrate49;
    }

    private BizNumber kikensrate50;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE50)
    public BizNumber getKikensrate50() {
        return kikensrate50;
    }

    public void setKikensrate50(BizNumber pKikensrate50) {
        kikensrate50 = pKikensrate50;
    }

    private BizNumber kikensrate51;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE51)
    public BizNumber getKikensrate51() {
        return kikensrate51;
    }

    public void setKikensrate51(BizNumber pKikensrate51) {
        kikensrate51 = pKikensrate51;
    }

    private BizNumber kikensrate52;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE52)
    public BizNumber getKikensrate52() {
        return kikensrate52;
    }

    public void setKikensrate52(BizNumber pKikensrate52) {
        kikensrate52 = pKikensrate52;
    }

    private BizNumber kikensrate53;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE53)
    public BizNumber getKikensrate53() {
        return kikensrate53;
    }

    public void setKikensrate53(BizNumber pKikensrate53) {
        kikensrate53 = pKikensrate53;
    }

    private BizNumber kikensrate54;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE54)
    public BizNumber getKikensrate54() {
        return kikensrate54;
    }

    public void setKikensrate54(BizNumber pKikensrate54) {
        kikensrate54 = pKikensrate54;
    }

    private BizNumber kikensrate55;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE55)
    public BizNumber getKikensrate55() {
        return kikensrate55;
    }

    public void setKikensrate55(BizNumber pKikensrate55) {
        kikensrate55 = pKikensrate55;
    }

    private BizNumber kikensrate56;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE56)
    public BizNumber getKikensrate56() {
        return kikensrate56;
    }

    public void setKikensrate56(BizNumber pKikensrate56) {
        kikensrate56 = pKikensrate56;
    }

    private BizNumber kikensrate57;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE57)
    public BizNumber getKikensrate57() {
        return kikensrate57;
    }

    public void setKikensrate57(BizNumber pKikensrate57) {
        kikensrate57 = pKikensrate57;
    }

    private BizNumber kikensrate58;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE58)
    public BizNumber getKikensrate58() {
        return kikensrate58;
    }

    public void setKikensrate58(BizNumber pKikensrate58) {
        kikensrate58 = pKikensrate58;
    }

    private BizNumber kikensrate59;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE59)
    public BizNumber getKikensrate59() {
        return kikensrate59;
    }

    public void setKikensrate59(BizNumber pKikensrate59) {
        kikensrate59 = pKikensrate59;
    }

    private BizNumber kikensrate60;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE60)
    public BizNumber getKikensrate60() {
        return kikensrate60;
    }

    public void setKikensrate60(BizNumber pKikensrate60) {
        kikensrate60 = pKikensrate60;
    }

    private BizNumber kikensrate61;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE61)
    public BizNumber getKikensrate61() {
        return kikensrate61;
    }

    public void setKikensrate61(BizNumber pKikensrate61) {
        kikensrate61 = pKikensrate61;
    }

    private BizNumber kikensrate62;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE62)
    public BizNumber getKikensrate62() {
        return kikensrate62;
    }

    public void setKikensrate62(BizNumber pKikensrate62) {
        kikensrate62 = pKikensrate62;
    }

    private BizNumber kikensrate63;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE63)
    public BizNumber getKikensrate63() {
        return kikensrate63;
    }

    public void setKikensrate63(BizNumber pKikensrate63) {
        kikensrate63 = pKikensrate63;
    }

    private BizNumber kikensrate64;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE64)
    public BizNumber getKikensrate64() {
        return kikensrate64;
    }

    public void setKikensrate64(BizNumber pKikensrate64) {
        kikensrate64 = pKikensrate64;
    }

    private BizNumber kikensrate65;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE65)
    public BizNumber getKikensrate65() {
        return kikensrate65;
    }

    public void setKikensrate65(BizNumber pKikensrate65) {
        kikensrate65 = pKikensrate65;
    }

    private BizNumber kikensrate66;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE66)
    public BizNumber getKikensrate66() {
        return kikensrate66;
    }

    public void setKikensrate66(BizNumber pKikensrate66) {
        kikensrate66 = pKikensrate66;
    }

    private BizNumber kikensrate67;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE67)
    public BizNumber getKikensrate67() {
        return kikensrate67;
    }

    public void setKikensrate67(BizNumber pKikensrate67) {
        kikensrate67 = pKikensrate67;
    }

    private BizNumber kikensrate68;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE68)
    public BizNumber getKikensrate68() {
        return kikensrate68;
    }

    public void setKikensrate68(BizNumber pKikensrate68) {
        kikensrate68 = pKikensrate68;
    }

    private BizNumber kikensrate69;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE69)
    public BizNumber getKikensrate69() {
        return kikensrate69;
    }

    public void setKikensrate69(BizNumber pKikensrate69) {
        kikensrate69 = pKikensrate69;
    }

    private BizNumber kikensrate70;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE70)
    public BizNumber getKikensrate70() {
        return kikensrate70;
    }

    public void setKikensrate70(BizNumber pKikensrate70) {
        kikensrate70 = pKikensrate70;
    }

    private BizNumber kikensrate71;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE71)
    public BizNumber getKikensrate71() {
        return kikensrate71;
    }

    public void setKikensrate71(BizNumber pKikensrate71) {
        kikensrate71 = pKikensrate71;
    }

    private BizNumber kikensrate72;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE72)
    public BizNumber getKikensrate72() {
        return kikensrate72;
    }

    public void setKikensrate72(BizNumber pKikensrate72) {
        kikensrate72 = pKikensrate72;
    }

    private BizNumber kikensrate73;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE73)
    public BizNumber getKikensrate73() {
        return kikensrate73;
    }

    public void setKikensrate73(BizNumber pKikensrate73) {
        kikensrate73 = pKikensrate73;
    }

    private BizNumber kikensrate74;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE74)
    public BizNumber getKikensrate74() {
        return kikensrate74;
    }

    public void setKikensrate74(BizNumber pKikensrate74) {
        kikensrate74 = pKikensrate74;
    }

    private BizNumber kikensrate75;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE75)
    public BizNumber getKikensrate75() {
        return kikensrate75;
    }

    public void setKikensrate75(BizNumber pKikensrate75) {
        kikensrate75 = pKikensrate75;
    }

    private BizNumber kikensrate76;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE76)
    public BizNumber getKikensrate76() {
        return kikensrate76;
    }

    public void setKikensrate76(BizNumber pKikensrate76) {
        kikensrate76 = pKikensrate76;
    }

    private BizNumber kikensrate77;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE77)
    public BizNumber getKikensrate77() {
        return kikensrate77;
    }

    public void setKikensrate77(BizNumber pKikensrate77) {
        kikensrate77 = pKikensrate77;
    }

    private BizNumber kikensrate78;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE78)
    public BizNumber getKikensrate78() {
        return kikensrate78;
    }

    public void setKikensrate78(BizNumber pKikensrate78) {
        kikensrate78 = pKikensrate78;
    }

    private BizNumber kikensrate79;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE79)
    public BizNumber getKikensrate79() {
        return kikensrate79;
    }

    public void setKikensrate79(BizNumber pKikensrate79) {
        kikensrate79 = pKikensrate79;
    }

    private BizNumber kikensrate80;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE80)
    public BizNumber getKikensrate80() {
        return kikensrate80;
    }

    public void setKikensrate80(BizNumber pKikensrate80) {
        kikensrate80 = pKikensrate80;
    }

    private BizNumber kikensrate81;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE81)
    public BizNumber getKikensrate81() {
        return kikensrate81;
    }

    public void setKikensrate81(BizNumber pKikensrate81) {
        kikensrate81 = pKikensrate81;
    }

    private BizNumber kikensrate82;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE82)
    public BizNumber getKikensrate82() {
        return kikensrate82;
    }

    public void setKikensrate82(BizNumber pKikensrate82) {
        kikensrate82 = pKikensrate82;
    }

    private BizNumber kikensrate83;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE83)
    public BizNumber getKikensrate83() {
        return kikensrate83;
    }

    public void setKikensrate83(BizNumber pKikensrate83) {
        kikensrate83 = pKikensrate83;
    }

    private BizNumber kikensrate84;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE84)
    public BizNumber getKikensrate84() {
        return kikensrate84;
    }

    public void setKikensrate84(BizNumber pKikensrate84) {
        kikensrate84 = pKikensrate84;
    }

    private BizNumber kikensrate85;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE85)
    public BizNumber getKikensrate85() {
        return kikensrate85;
    }

    public void setKikensrate85(BizNumber pKikensrate85) {
        kikensrate85 = pKikensrate85;
    }

    private BizNumber kikensrate86;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE86)
    public BizNumber getKikensrate86() {
        return kikensrate86;
    }

    public void setKikensrate86(BizNumber pKikensrate86) {
        kikensrate86 = pKikensrate86;
    }

    private BizNumber kikensrate87;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE87)
    public BizNumber getKikensrate87() {
        return kikensrate87;
    }

    public void setKikensrate87(BizNumber pKikensrate87) {
        kikensrate87 = pKikensrate87;
    }

    private BizNumber kikensrate88;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE88)
    public BizNumber getKikensrate88() {
        return kikensrate88;
    }

    public void setKikensrate88(BizNumber pKikensrate88) {
        kikensrate88 = pKikensrate88;
    }

    private BizNumber kikensrate89;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE89)
    public BizNumber getKikensrate89() {
        return kikensrate89;
    }

    public void setKikensrate89(BizNumber pKikensrate89) {
        kikensrate89 = pKikensrate89;
    }

    private BizNumber kikensrate90;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE90)
    public BizNumber getKikensrate90() {
        return kikensrate90;
    }

    public void setKikensrate90(BizNumber pKikensrate90) {
        kikensrate90 = pKikensrate90;
    }

    private BizNumber kikensrate91;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE91)
    public BizNumber getKikensrate91() {
        return kikensrate91;
    }

    public void setKikensrate91(BizNumber pKikensrate91) {
        kikensrate91 = pKikensrate91;
    }

    private BizNumber kikensrate92;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE92)
    public BizNumber getKikensrate92() {
        return kikensrate92;
    }

    public void setKikensrate92(BizNumber pKikensrate92) {
        kikensrate92 = pKikensrate92;
    }

    private BizNumber kikensrate93;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE93)
    public BizNumber getKikensrate93() {
        return kikensrate93;
    }

    public void setKikensrate93(BizNumber pKikensrate93) {
        kikensrate93 = pKikensrate93;
    }

    private BizNumber kikensrate94;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE94)
    public BizNumber getKikensrate94() {
        return kikensrate94;
    }

    public void setKikensrate94(BizNumber pKikensrate94) {
        kikensrate94 = pKikensrate94;
    }

    private BizNumber kikensrate95;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE95)
    public BizNumber getKikensrate95() {
        return kikensrate95;
    }

    public void setKikensrate95(BizNumber pKikensrate95) {
        kikensrate95 = pKikensrate95;
    }

    private BizNumber kikensrate96;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE96)
    public BizNumber getKikensrate96() {
        return kikensrate96;
    }

    public void setKikensrate96(BizNumber pKikensrate96) {
        kikensrate96 = pKikensrate96;
    }

    private BizNumber kikensrate97;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE97)
    public BizNumber getKikensrate97() {
        return kikensrate97;
    }

    public void setKikensrate97(BizNumber pKikensrate97) {
        kikensrate97 = pKikensrate97;
    }

    private BizNumber kikensrate98;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE98)
    public BizNumber getKikensrate98() {
        return kikensrate98;
    }

    public void setKikensrate98(BizNumber pKikensrate98) {
        kikensrate98 = pKikensrate98;
    }

    private BizNumber kikensrate99;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateD.KIKENSRATE99)
    public BizNumber getKikensrate99() {
        return kikensrate99;
    }

    public void setKikensrate99(BizNumber pKikensrate99) {
        kikensrate99 = pKikensrate99;
    }
}
