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
import yuyu.def.db.entity.BM_RateV;
import yuyu.def.db.id.PKBM_RateV;
import yuyu.def.db.meta.GenQBM_RateV;
import yuyu.def.db.meta.QBM_RateV;

/**
 * Ｖレートマスタ テーブルのマッピング情報クラスで、 {@link BM_RateV} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateV}</td><td colspan="3">Ｖレートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getPalhokensyuruikigou palhokensyuruikigou}</td><td>ＰＡＬ保険種類記号</td><td align="center">{@link PKBM_RateV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhokensyuruikigousdicode palhokensyuruikigousdicode}</td><td>ＰＡＬ保険種類記号世代コード</td><td align="center">{@link PKBM_RateV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalyoteiriritu palyoteiriritu}</td><td>ＰＡＬ予定利率</td><td align="center">{@link PKBM_RateV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalpmencode palpmencode}</td><td>ＰＡＬＰ免コード</td><td align="center">{@link PKBM_RateV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalharaikomikaisuu palharaikomikaisuu}</td><td>ＰＡＬ払込回数</td><td align="center">{@link PKBM_RateV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhhknsei palhhknsei}</td><td>ＰＡＬ被保険者性別</td><td align="center">{@link PKBM_RateV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalkeiyakujihhknnen palkeiyakujihhknnen}</td><td>ＰＡＬ契約時被保険者年令</td><td align="center">{@link PKBM_RateV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalsaimankihyouji palsaimankihyouji}</td><td>ＰＡＬ才満期契約表示</td><td align="center">{@link PKBM_RateV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalhokenkikan palhokenkikan}</td><td>ＰＡＬ保険期間</td><td align="center">{@link PKBM_RateV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalpharaikomikikan palpharaikomikikan}</td><td>ＰＡＬＰ払込期間</td><td align="center">{@link PKBM_RateV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getVrate00 vrate00}</td><td>Ｖレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate01 vrate01}</td><td>Ｖレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate02 vrate02}</td><td>Ｖレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate03 vrate03}</td><td>Ｖレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate04 vrate04}</td><td>Ｖレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate05 vrate05}</td><td>Ｖレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate06 vrate06}</td><td>Ｖレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate07 vrate07}</td><td>Ｖレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate08 vrate08}</td><td>Ｖレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate09 vrate09}</td><td>Ｖレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate10 vrate10}</td><td>Ｖレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate11 vrate11}</td><td>Ｖレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate12 vrate12}</td><td>Ｖレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate13 vrate13}</td><td>Ｖレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate14 vrate14}</td><td>Ｖレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate15 vrate15}</td><td>Ｖレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate16 vrate16}</td><td>Ｖレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate17 vrate17}</td><td>Ｖレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate18 vrate18}</td><td>Ｖレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate19 vrate19}</td><td>Ｖレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate20 vrate20}</td><td>Ｖレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate21 vrate21}</td><td>Ｖレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate22 vrate22}</td><td>Ｖレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate23 vrate23}</td><td>Ｖレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate24 vrate24}</td><td>Ｖレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate25 vrate25}</td><td>Ｖレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate26 vrate26}</td><td>Ｖレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate27 vrate27}</td><td>Ｖレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate28 vrate28}</td><td>Ｖレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate29 vrate29}</td><td>Ｖレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate30 vrate30}</td><td>Ｖレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate31 vrate31}</td><td>Ｖレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate32 vrate32}</td><td>Ｖレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate33 vrate33}</td><td>Ｖレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate34 vrate34}</td><td>Ｖレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate35 vrate35}</td><td>Ｖレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate36 vrate36}</td><td>Ｖレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate37 vrate37}</td><td>Ｖレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate38 vrate38}</td><td>Ｖレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate39 vrate39}</td><td>Ｖレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate40 vrate40}</td><td>Ｖレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate41 vrate41}</td><td>Ｖレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate42 vrate42}</td><td>Ｖレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate43 vrate43}</td><td>Ｖレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate44 vrate44}</td><td>Ｖレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate45 vrate45}</td><td>Ｖレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate46 vrate46}</td><td>Ｖレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate47 vrate47}</td><td>Ｖレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate48 vrate48}</td><td>Ｖレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate49 vrate49}</td><td>Ｖレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate50 vrate50}</td><td>Ｖレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate51 vrate51}</td><td>Ｖレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate52 vrate52}</td><td>Ｖレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate53 vrate53}</td><td>Ｖレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate54 vrate54}</td><td>Ｖレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate55 vrate55}</td><td>Ｖレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate56 vrate56}</td><td>Ｖレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate57 vrate57}</td><td>Ｖレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate58 vrate58}</td><td>Ｖレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate59 vrate59}</td><td>Ｖレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate60 vrate60}</td><td>Ｖレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate61 vrate61}</td><td>Ｖレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate62 vrate62}</td><td>Ｖレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate63 vrate63}</td><td>Ｖレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate64 vrate64}</td><td>Ｖレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate65 vrate65}</td><td>Ｖレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate66 vrate66}</td><td>Ｖレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate67 vrate67}</td><td>Ｖレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate68 vrate68}</td><td>Ｖレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate69 vrate69}</td><td>Ｖレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate70 vrate70}</td><td>Ｖレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate71 vrate71}</td><td>Ｖレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate72 vrate72}</td><td>Ｖレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate73 vrate73}</td><td>Ｖレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate74 vrate74}</td><td>Ｖレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate75 vrate75}</td><td>Ｖレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate76 vrate76}</td><td>Ｖレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate77 vrate77}</td><td>Ｖレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate78 vrate78}</td><td>Ｖレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate79 vrate79}</td><td>Ｖレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate80 vrate80}</td><td>Ｖレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate81 vrate81}</td><td>Ｖレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate82 vrate82}</td><td>Ｖレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate83 vrate83}</td><td>Ｖレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate84 vrate84}</td><td>Ｖレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate85 vrate85}</td><td>Ｖレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate86 vrate86}</td><td>Ｖレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate87 vrate87}</td><td>Ｖレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate88 vrate88}</td><td>Ｖレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate89 vrate89}</td><td>Ｖレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate90 vrate90}</td><td>Ｖレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate91 vrate91}</td><td>Ｖレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate92 vrate92}</td><td>Ｖレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate93 vrate93}</td><td>Ｖレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate94 vrate94}</td><td>Ｖレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate95 vrate95}</td><td>Ｖレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate96 vrate96}</td><td>Ｖレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate97 vrate97}</td><td>Ｖレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate98 vrate98}</td><td>Ｖレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getVrate99 vrate99}</td><td>Ｖレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_RateV
 * @see     PKBM_RateV
 * @see     QBM_RateV
 * @see     GenQBM_RateV
 */
@MappedSuperclass
@Table(name=GenBM_RateV.TABLE_NAME)
@IdClass(value=PKBM_RateV.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenBM_RateV extends AbstractExDBEntity<BM_RateV, PKBM_RateV> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_RateV";
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
    public static final String VRATE00                  = "vrate00";
    public static final String VRATE01                  = "vrate01";
    public static final String VRATE02                  = "vrate02";
    public static final String VRATE03                  = "vrate03";
    public static final String VRATE04                  = "vrate04";
    public static final String VRATE05                  = "vrate05";
    public static final String VRATE06                  = "vrate06";
    public static final String VRATE07                  = "vrate07";
    public static final String VRATE08                  = "vrate08";
    public static final String VRATE09                  = "vrate09";
    public static final String VRATE10                  = "vrate10";
    public static final String VRATE11                  = "vrate11";
    public static final String VRATE12                  = "vrate12";
    public static final String VRATE13                  = "vrate13";
    public static final String VRATE14                  = "vrate14";
    public static final String VRATE15                  = "vrate15";
    public static final String VRATE16                  = "vrate16";
    public static final String VRATE17                  = "vrate17";
    public static final String VRATE18                  = "vrate18";
    public static final String VRATE19                  = "vrate19";
    public static final String VRATE20                  = "vrate20";
    public static final String VRATE21                  = "vrate21";
    public static final String VRATE22                  = "vrate22";
    public static final String VRATE23                  = "vrate23";
    public static final String VRATE24                  = "vrate24";
    public static final String VRATE25                  = "vrate25";
    public static final String VRATE26                  = "vrate26";
    public static final String VRATE27                  = "vrate27";
    public static final String VRATE28                  = "vrate28";
    public static final String VRATE29                  = "vrate29";
    public static final String VRATE30                  = "vrate30";
    public static final String VRATE31                  = "vrate31";
    public static final String VRATE32                  = "vrate32";
    public static final String VRATE33                  = "vrate33";
    public static final String VRATE34                  = "vrate34";
    public static final String VRATE35                  = "vrate35";
    public static final String VRATE36                  = "vrate36";
    public static final String VRATE37                  = "vrate37";
    public static final String VRATE38                  = "vrate38";
    public static final String VRATE39                  = "vrate39";
    public static final String VRATE40                  = "vrate40";
    public static final String VRATE41                  = "vrate41";
    public static final String VRATE42                  = "vrate42";
    public static final String VRATE43                  = "vrate43";
    public static final String VRATE44                  = "vrate44";
    public static final String VRATE45                  = "vrate45";
    public static final String VRATE46                  = "vrate46";
    public static final String VRATE47                  = "vrate47";
    public static final String VRATE48                  = "vrate48";
    public static final String VRATE49                  = "vrate49";
    public static final String VRATE50                  = "vrate50";
    public static final String VRATE51                  = "vrate51";
    public static final String VRATE52                  = "vrate52";
    public static final String VRATE53                  = "vrate53";
    public static final String VRATE54                  = "vrate54";
    public static final String VRATE55                  = "vrate55";
    public static final String VRATE56                  = "vrate56";
    public static final String VRATE57                  = "vrate57";
    public static final String VRATE58                  = "vrate58";
    public static final String VRATE59                  = "vrate59";
    public static final String VRATE60                  = "vrate60";
    public static final String VRATE61                  = "vrate61";
    public static final String VRATE62                  = "vrate62";
    public static final String VRATE63                  = "vrate63";
    public static final String VRATE64                  = "vrate64";
    public static final String VRATE65                  = "vrate65";
    public static final String VRATE66                  = "vrate66";
    public static final String VRATE67                  = "vrate67";
    public static final String VRATE68                  = "vrate68";
    public static final String VRATE69                  = "vrate69";
    public static final String VRATE70                  = "vrate70";
    public static final String VRATE71                  = "vrate71";
    public static final String VRATE72                  = "vrate72";
    public static final String VRATE73                  = "vrate73";
    public static final String VRATE74                  = "vrate74";
    public static final String VRATE75                  = "vrate75";
    public static final String VRATE76                  = "vrate76";
    public static final String VRATE77                  = "vrate77";
    public static final String VRATE78                  = "vrate78";
    public static final String VRATE79                  = "vrate79";
    public static final String VRATE80                  = "vrate80";
    public static final String VRATE81                  = "vrate81";
    public static final String VRATE82                  = "vrate82";
    public static final String VRATE83                  = "vrate83";
    public static final String VRATE84                  = "vrate84";
    public static final String VRATE85                  = "vrate85";
    public static final String VRATE86                  = "vrate86";
    public static final String VRATE87                  = "vrate87";
    public static final String VRATE88                  = "vrate88";
    public static final String VRATE89                  = "vrate89";
    public static final String VRATE90                  = "vrate90";
    public static final String VRATE91                  = "vrate91";
    public static final String VRATE92                  = "vrate92";
    public static final String VRATE93                  = "vrate93";
    public static final String VRATE94                  = "vrate94";
    public static final String VRATE95                  = "vrate95";
    public static final String VRATE96                  = "vrate96";
    public static final String VRATE97                  = "vrate97";
    public static final String VRATE98                  = "vrate98";
    public static final String VRATE99                  = "vrate99";

    private final PKBM_RateV primaryKey;

    public GenBM_RateV() {
        primaryKey = new PKBM_RateV();
    }

    public GenBM_RateV(
        String pPalhokensyuruikigou,
        String pPalhokensyuruikigousdicode,
        String pPalyoteiriritu,
        String pPalpmencode,
        String pPalharaikomikaisuu,
        String pPalhhknsei,
        String pPalkeiyakujihhknnen,
        String pPalsaimankihyouji,
        String pPalhokenkikan,
        String pPalpharaikomikikan
    ) {
        primaryKey = new PKBM_RateV(
            pPalhokensyuruikigou,
            pPalhokensyuruikigousdicode,
            pPalyoteiriritu,
            pPalpmencode,
            pPalharaikomikaisuu,
            pPalhhknsei,
            pPalkeiyakujihhknnen,
            pPalsaimankihyouji,
            pPalhokenkikan,
            pPalpharaikomikikan
        );
    }

    @Transient
    @Override
    public PKBM_RateV getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_RateV> getMetaClass() {
        return QBM_RateV.class;
    }

    @Id
    @Column(name=GenBM_RateV.PALHOKENSYURUIKIGOU)
    public String getPalhokensyuruikigou() {
        return getPrimaryKey().getPalhokensyuruikigou();
    }

    public void setPalhokensyuruikigou(String pPalhokensyuruikigou) {
        getPrimaryKey().setPalhokensyuruikigou(pPalhokensyuruikigou);
    }

    @Id
    @Column(name=GenBM_RateV.PALHOKENSYURUIKIGOUSDICODE)
    public String getPalhokensyuruikigousdicode() {
        return getPrimaryKey().getPalhokensyuruikigousdicode();
    }

    public void setPalhokensyuruikigousdicode(String pPalhokensyuruikigousdicode) {
        getPrimaryKey().setPalhokensyuruikigousdicode(pPalhokensyuruikigousdicode);
    }

    @Id
    @Column(name=GenBM_RateV.PALYOTEIRIRITU)
    public String getPalyoteiriritu() {
        return getPrimaryKey().getPalyoteiriritu();
    }

    public void setPalyoteiriritu(String pPalyoteiriritu) {
        getPrimaryKey().setPalyoteiriritu(pPalyoteiriritu);
    }

    @Id
    @Column(name=GenBM_RateV.PALPMENCODE)
    public String getPalpmencode() {
        return getPrimaryKey().getPalpmencode();
    }

    public void setPalpmencode(String pPalpmencode) {
        getPrimaryKey().setPalpmencode(pPalpmencode);
    }

    @Id
    @Column(name=GenBM_RateV.PALHARAIKOMIKAISUU)
    public String getPalharaikomikaisuu() {
        return getPrimaryKey().getPalharaikomikaisuu();
    }

    public void setPalharaikomikaisuu(String pPalharaikomikaisuu) {
        getPrimaryKey().setPalharaikomikaisuu(pPalharaikomikaisuu);
    }

    @Id
    @Column(name=GenBM_RateV.PALHHKNSEI)
    public String getPalhhknsei() {
        return getPrimaryKey().getPalhhknsei();
    }

    public void setPalhhknsei(String pPalhhknsei) {
        getPrimaryKey().setPalhhknsei(pPalhhknsei);
    }

    @Id
    @Column(name=GenBM_RateV.PALKEIYAKUJIHHKNNEN)
    public String getPalkeiyakujihhknnen() {
        return getPrimaryKey().getPalkeiyakujihhknnen();
    }

    public void setPalkeiyakujihhknnen(String pPalkeiyakujihhknnen) {
        getPrimaryKey().setPalkeiyakujihhknnen(pPalkeiyakujihhknnen);
    }

    @Id
    @Column(name=GenBM_RateV.PALSAIMANKIHYOUJI)
    public String getPalsaimankihyouji() {
        return getPrimaryKey().getPalsaimankihyouji();
    }

    public void setPalsaimankihyouji(String pPalsaimankihyouji) {
        getPrimaryKey().setPalsaimankihyouji(pPalsaimankihyouji);
    }

    @Id
    @Column(name=GenBM_RateV.PALHOKENKIKAN)
    public String getPalhokenkikan() {
        return getPrimaryKey().getPalhokenkikan();
    }

    public void setPalhokenkikan(String pPalhokenkikan) {
        getPrimaryKey().setPalhokenkikan(pPalhokenkikan);
    }

    @Id
    @Column(name=GenBM_RateV.PALPHARAIKOMIKIKAN)
    public String getPalpharaikomikikan() {
        return getPrimaryKey().getPalpharaikomikikan();
    }

    public void setPalpharaikomikikan(String pPalpharaikomikikan) {
        getPrimaryKey().setPalpharaikomikikan(pPalpharaikomikikan);
    }

    private BizNumber vrate00;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE00)
    public BizNumber getVrate00() {
        return vrate00;
    }

    public void setVrate00(BizNumber pVrate00) {
        vrate00 = pVrate00;
    }

    private BizNumber vrate01;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE01)
    public BizNumber getVrate01() {
        return vrate01;
    }

    public void setVrate01(BizNumber pVrate01) {
        vrate01 = pVrate01;
    }

    private BizNumber vrate02;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE02)
    public BizNumber getVrate02() {
        return vrate02;
    }

    public void setVrate02(BizNumber pVrate02) {
        vrate02 = pVrate02;
    }

    private BizNumber vrate03;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE03)
    public BizNumber getVrate03() {
        return vrate03;
    }

    public void setVrate03(BizNumber pVrate03) {
        vrate03 = pVrate03;
    }

    private BizNumber vrate04;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE04)
    public BizNumber getVrate04() {
        return vrate04;
    }

    public void setVrate04(BizNumber pVrate04) {
        vrate04 = pVrate04;
    }

    private BizNumber vrate05;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE05)
    public BizNumber getVrate05() {
        return vrate05;
    }

    public void setVrate05(BizNumber pVrate05) {
        vrate05 = pVrate05;
    }

    private BizNumber vrate06;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE06)
    public BizNumber getVrate06() {
        return vrate06;
    }

    public void setVrate06(BizNumber pVrate06) {
        vrate06 = pVrate06;
    }

    private BizNumber vrate07;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE07)
    public BizNumber getVrate07() {
        return vrate07;
    }

    public void setVrate07(BizNumber pVrate07) {
        vrate07 = pVrate07;
    }

    private BizNumber vrate08;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE08)
    public BizNumber getVrate08() {
        return vrate08;
    }

    public void setVrate08(BizNumber pVrate08) {
        vrate08 = pVrate08;
    }

    private BizNumber vrate09;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE09)
    public BizNumber getVrate09() {
        return vrate09;
    }

    public void setVrate09(BizNumber pVrate09) {
        vrate09 = pVrate09;
    }

    private BizNumber vrate10;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE10)
    public BizNumber getVrate10() {
        return vrate10;
    }

    public void setVrate10(BizNumber pVrate10) {
        vrate10 = pVrate10;
    }

    private BizNumber vrate11;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE11)
    public BizNumber getVrate11() {
        return vrate11;
    }

    public void setVrate11(BizNumber pVrate11) {
        vrate11 = pVrate11;
    }

    private BizNumber vrate12;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE12)
    public BizNumber getVrate12() {
        return vrate12;
    }

    public void setVrate12(BizNumber pVrate12) {
        vrate12 = pVrate12;
    }

    private BizNumber vrate13;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE13)
    public BizNumber getVrate13() {
        return vrate13;
    }

    public void setVrate13(BizNumber pVrate13) {
        vrate13 = pVrate13;
    }

    private BizNumber vrate14;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE14)
    public BizNumber getVrate14() {
        return vrate14;
    }

    public void setVrate14(BizNumber pVrate14) {
        vrate14 = pVrate14;
    }

    private BizNumber vrate15;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE15)
    public BizNumber getVrate15() {
        return vrate15;
    }

    public void setVrate15(BizNumber pVrate15) {
        vrate15 = pVrate15;
    }

    private BizNumber vrate16;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE16)
    public BizNumber getVrate16() {
        return vrate16;
    }

    public void setVrate16(BizNumber pVrate16) {
        vrate16 = pVrate16;
    }

    private BizNumber vrate17;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE17)
    public BizNumber getVrate17() {
        return vrate17;
    }

    public void setVrate17(BizNumber pVrate17) {
        vrate17 = pVrate17;
    }

    private BizNumber vrate18;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE18)
    public BizNumber getVrate18() {
        return vrate18;
    }

    public void setVrate18(BizNumber pVrate18) {
        vrate18 = pVrate18;
    }

    private BizNumber vrate19;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE19)
    public BizNumber getVrate19() {
        return vrate19;
    }

    public void setVrate19(BizNumber pVrate19) {
        vrate19 = pVrate19;
    }

    private BizNumber vrate20;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE20)
    public BizNumber getVrate20() {
        return vrate20;
    }

    public void setVrate20(BizNumber pVrate20) {
        vrate20 = pVrate20;
    }

    private BizNumber vrate21;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE21)
    public BizNumber getVrate21() {
        return vrate21;
    }

    public void setVrate21(BizNumber pVrate21) {
        vrate21 = pVrate21;
    }

    private BizNumber vrate22;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE22)
    public BizNumber getVrate22() {
        return vrate22;
    }

    public void setVrate22(BizNumber pVrate22) {
        vrate22 = pVrate22;
    }

    private BizNumber vrate23;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE23)
    public BizNumber getVrate23() {
        return vrate23;
    }

    public void setVrate23(BizNumber pVrate23) {
        vrate23 = pVrate23;
    }

    private BizNumber vrate24;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE24)
    public BizNumber getVrate24() {
        return vrate24;
    }

    public void setVrate24(BizNumber pVrate24) {
        vrate24 = pVrate24;
    }

    private BizNumber vrate25;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE25)
    public BizNumber getVrate25() {
        return vrate25;
    }

    public void setVrate25(BizNumber pVrate25) {
        vrate25 = pVrate25;
    }

    private BizNumber vrate26;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE26)
    public BizNumber getVrate26() {
        return vrate26;
    }

    public void setVrate26(BizNumber pVrate26) {
        vrate26 = pVrate26;
    }

    private BizNumber vrate27;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE27)
    public BizNumber getVrate27() {
        return vrate27;
    }

    public void setVrate27(BizNumber pVrate27) {
        vrate27 = pVrate27;
    }

    private BizNumber vrate28;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE28)
    public BizNumber getVrate28() {
        return vrate28;
    }

    public void setVrate28(BizNumber pVrate28) {
        vrate28 = pVrate28;
    }

    private BizNumber vrate29;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE29)
    public BizNumber getVrate29() {
        return vrate29;
    }

    public void setVrate29(BizNumber pVrate29) {
        vrate29 = pVrate29;
    }

    private BizNumber vrate30;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE30)
    public BizNumber getVrate30() {
        return vrate30;
    }

    public void setVrate30(BizNumber pVrate30) {
        vrate30 = pVrate30;
    }

    private BizNumber vrate31;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE31)
    public BizNumber getVrate31() {
        return vrate31;
    }

    public void setVrate31(BizNumber pVrate31) {
        vrate31 = pVrate31;
    }

    private BizNumber vrate32;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE32)
    public BizNumber getVrate32() {
        return vrate32;
    }

    public void setVrate32(BizNumber pVrate32) {
        vrate32 = pVrate32;
    }

    private BizNumber vrate33;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE33)
    public BizNumber getVrate33() {
        return vrate33;
    }

    public void setVrate33(BizNumber pVrate33) {
        vrate33 = pVrate33;
    }

    private BizNumber vrate34;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE34)
    public BizNumber getVrate34() {
        return vrate34;
    }

    public void setVrate34(BizNumber pVrate34) {
        vrate34 = pVrate34;
    }

    private BizNumber vrate35;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE35)
    public BizNumber getVrate35() {
        return vrate35;
    }

    public void setVrate35(BizNumber pVrate35) {
        vrate35 = pVrate35;
    }

    private BizNumber vrate36;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE36)
    public BizNumber getVrate36() {
        return vrate36;
    }

    public void setVrate36(BizNumber pVrate36) {
        vrate36 = pVrate36;
    }

    private BizNumber vrate37;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE37)
    public BizNumber getVrate37() {
        return vrate37;
    }

    public void setVrate37(BizNumber pVrate37) {
        vrate37 = pVrate37;
    }

    private BizNumber vrate38;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE38)
    public BizNumber getVrate38() {
        return vrate38;
    }

    public void setVrate38(BizNumber pVrate38) {
        vrate38 = pVrate38;
    }

    private BizNumber vrate39;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE39)
    public BizNumber getVrate39() {
        return vrate39;
    }

    public void setVrate39(BizNumber pVrate39) {
        vrate39 = pVrate39;
    }

    private BizNumber vrate40;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE40)
    public BizNumber getVrate40() {
        return vrate40;
    }

    public void setVrate40(BizNumber pVrate40) {
        vrate40 = pVrate40;
    }

    private BizNumber vrate41;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE41)
    public BizNumber getVrate41() {
        return vrate41;
    }

    public void setVrate41(BizNumber pVrate41) {
        vrate41 = pVrate41;
    }

    private BizNumber vrate42;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE42)
    public BizNumber getVrate42() {
        return vrate42;
    }

    public void setVrate42(BizNumber pVrate42) {
        vrate42 = pVrate42;
    }

    private BizNumber vrate43;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE43)
    public BizNumber getVrate43() {
        return vrate43;
    }

    public void setVrate43(BizNumber pVrate43) {
        vrate43 = pVrate43;
    }

    private BizNumber vrate44;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE44)
    public BizNumber getVrate44() {
        return vrate44;
    }

    public void setVrate44(BizNumber pVrate44) {
        vrate44 = pVrate44;
    }

    private BizNumber vrate45;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE45)
    public BizNumber getVrate45() {
        return vrate45;
    }

    public void setVrate45(BizNumber pVrate45) {
        vrate45 = pVrate45;
    }

    private BizNumber vrate46;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE46)
    public BizNumber getVrate46() {
        return vrate46;
    }

    public void setVrate46(BizNumber pVrate46) {
        vrate46 = pVrate46;
    }

    private BizNumber vrate47;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE47)
    public BizNumber getVrate47() {
        return vrate47;
    }

    public void setVrate47(BizNumber pVrate47) {
        vrate47 = pVrate47;
    }

    private BizNumber vrate48;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE48)
    public BizNumber getVrate48() {
        return vrate48;
    }

    public void setVrate48(BizNumber pVrate48) {
        vrate48 = pVrate48;
    }

    private BizNumber vrate49;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE49)
    public BizNumber getVrate49() {
        return vrate49;
    }

    public void setVrate49(BizNumber pVrate49) {
        vrate49 = pVrate49;
    }

    private BizNumber vrate50;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE50)
    public BizNumber getVrate50() {
        return vrate50;
    }

    public void setVrate50(BizNumber pVrate50) {
        vrate50 = pVrate50;
    }

    private BizNumber vrate51;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE51)
    public BizNumber getVrate51() {
        return vrate51;
    }

    public void setVrate51(BizNumber pVrate51) {
        vrate51 = pVrate51;
    }

    private BizNumber vrate52;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE52)
    public BizNumber getVrate52() {
        return vrate52;
    }

    public void setVrate52(BizNumber pVrate52) {
        vrate52 = pVrate52;
    }

    private BizNumber vrate53;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE53)
    public BizNumber getVrate53() {
        return vrate53;
    }

    public void setVrate53(BizNumber pVrate53) {
        vrate53 = pVrate53;
    }

    private BizNumber vrate54;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE54)
    public BizNumber getVrate54() {
        return vrate54;
    }

    public void setVrate54(BizNumber pVrate54) {
        vrate54 = pVrate54;
    }

    private BizNumber vrate55;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE55)
    public BizNumber getVrate55() {
        return vrate55;
    }

    public void setVrate55(BizNumber pVrate55) {
        vrate55 = pVrate55;
    }

    private BizNumber vrate56;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE56)
    public BizNumber getVrate56() {
        return vrate56;
    }

    public void setVrate56(BizNumber pVrate56) {
        vrate56 = pVrate56;
    }

    private BizNumber vrate57;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE57)
    public BizNumber getVrate57() {
        return vrate57;
    }

    public void setVrate57(BizNumber pVrate57) {
        vrate57 = pVrate57;
    }

    private BizNumber vrate58;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE58)
    public BizNumber getVrate58() {
        return vrate58;
    }

    public void setVrate58(BizNumber pVrate58) {
        vrate58 = pVrate58;
    }

    private BizNumber vrate59;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE59)
    public BizNumber getVrate59() {
        return vrate59;
    }

    public void setVrate59(BizNumber pVrate59) {
        vrate59 = pVrate59;
    }

    private BizNumber vrate60;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE60)
    public BizNumber getVrate60() {
        return vrate60;
    }

    public void setVrate60(BizNumber pVrate60) {
        vrate60 = pVrate60;
    }

    private BizNumber vrate61;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE61)
    public BizNumber getVrate61() {
        return vrate61;
    }

    public void setVrate61(BizNumber pVrate61) {
        vrate61 = pVrate61;
    }

    private BizNumber vrate62;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE62)
    public BizNumber getVrate62() {
        return vrate62;
    }

    public void setVrate62(BizNumber pVrate62) {
        vrate62 = pVrate62;
    }

    private BizNumber vrate63;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE63)
    public BizNumber getVrate63() {
        return vrate63;
    }

    public void setVrate63(BizNumber pVrate63) {
        vrate63 = pVrate63;
    }

    private BizNumber vrate64;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE64)
    public BizNumber getVrate64() {
        return vrate64;
    }

    public void setVrate64(BizNumber pVrate64) {
        vrate64 = pVrate64;
    }

    private BizNumber vrate65;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE65)
    public BizNumber getVrate65() {
        return vrate65;
    }

    public void setVrate65(BizNumber pVrate65) {
        vrate65 = pVrate65;
    }

    private BizNumber vrate66;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE66)
    public BizNumber getVrate66() {
        return vrate66;
    }

    public void setVrate66(BizNumber pVrate66) {
        vrate66 = pVrate66;
    }

    private BizNumber vrate67;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE67)
    public BizNumber getVrate67() {
        return vrate67;
    }

    public void setVrate67(BizNumber pVrate67) {
        vrate67 = pVrate67;
    }

    private BizNumber vrate68;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE68)
    public BizNumber getVrate68() {
        return vrate68;
    }

    public void setVrate68(BizNumber pVrate68) {
        vrate68 = pVrate68;
    }

    private BizNumber vrate69;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE69)
    public BizNumber getVrate69() {
        return vrate69;
    }

    public void setVrate69(BizNumber pVrate69) {
        vrate69 = pVrate69;
    }

    private BizNumber vrate70;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE70)
    public BizNumber getVrate70() {
        return vrate70;
    }

    public void setVrate70(BizNumber pVrate70) {
        vrate70 = pVrate70;
    }

    private BizNumber vrate71;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE71)
    public BizNumber getVrate71() {
        return vrate71;
    }

    public void setVrate71(BizNumber pVrate71) {
        vrate71 = pVrate71;
    }

    private BizNumber vrate72;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE72)
    public BizNumber getVrate72() {
        return vrate72;
    }

    public void setVrate72(BizNumber pVrate72) {
        vrate72 = pVrate72;
    }

    private BizNumber vrate73;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE73)
    public BizNumber getVrate73() {
        return vrate73;
    }

    public void setVrate73(BizNumber pVrate73) {
        vrate73 = pVrate73;
    }

    private BizNumber vrate74;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE74)
    public BizNumber getVrate74() {
        return vrate74;
    }

    public void setVrate74(BizNumber pVrate74) {
        vrate74 = pVrate74;
    }

    private BizNumber vrate75;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE75)
    public BizNumber getVrate75() {
        return vrate75;
    }

    public void setVrate75(BizNumber pVrate75) {
        vrate75 = pVrate75;
    }

    private BizNumber vrate76;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE76)
    public BizNumber getVrate76() {
        return vrate76;
    }

    public void setVrate76(BizNumber pVrate76) {
        vrate76 = pVrate76;
    }

    private BizNumber vrate77;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE77)
    public BizNumber getVrate77() {
        return vrate77;
    }

    public void setVrate77(BizNumber pVrate77) {
        vrate77 = pVrate77;
    }

    private BizNumber vrate78;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE78)
    public BizNumber getVrate78() {
        return vrate78;
    }

    public void setVrate78(BizNumber pVrate78) {
        vrate78 = pVrate78;
    }

    private BizNumber vrate79;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE79)
    public BizNumber getVrate79() {
        return vrate79;
    }

    public void setVrate79(BizNumber pVrate79) {
        vrate79 = pVrate79;
    }

    private BizNumber vrate80;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE80)
    public BizNumber getVrate80() {
        return vrate80;
    }

    public void setVrate80(BizNumber pVrate80) {
        vrate80 = pVrate80;
    }

    private BizNumber vrate81;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE81)
    public BizNumber getVrate81() {
        return vrate81;
    }

    public void setVrate81(BizNumber pVrate81) {
        vrate81 = pVrate81;
    }

    private BizNumber vrate82;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE82)
    public BizNumber getVrate82() {
        return vrate82;
    }

    public void setVrate82(BizNumber pVrate82) {
        vrate82 = pVrate82;
    }

    private BizNumber vrate83;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE83)
    public BizNumber getVrate83() {
        return vrate83;
    }

    public void setVrate83(BizNumber pVrate83) {
        vrate83 = pVrate83;
    }

    private BizNumber vrate84;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE84)
    public BizNumber getVrate84() {
        return vrate84;
    }

    public void setVrate84(BizNumber pVrate84) {
        vrate84 = pVrate84;
    }

    private BizNumber vrate85;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE85)
    public BizNumber getVrate85() {
        return vrate85;
    }

    public void setVrate85(BizNumber pVrate85) {
        vrate85 = pVrate85;
    }

    private BizNumber vrate86;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE86)
    public BizNumber getVrate86() {
        return vrate86;
    }

    public void setVrate86(BizNumber pVrate86) {
        vrate86 = pVrate86;
    }

    private BizNumber vrate87;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE87)
    public BizNumber getVrate87() {
        return vrate87;
    }

    public void setVrate87(BizNumber pVrate87) {
        vrate87 = pVrate87;
    }

    private BizNumber vrate88;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE88)
    public BizNumber getVrate88() {
        return vrate88;
    }

    public void setVrate88(BizNumber pVrate88) {
        vrate88 = pVrate88;
    }

    private BizNumber vrate89;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE89)
    public BizNumber getVrate89() {
        return vrate89;
    }

    public void setVrate89(BizNumber pVrate89) {
        vrate89 = pVrate89;
    }

    private BizNumber vrate90;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE90)
    public BizNumber getVrate90() {
        return vrate90;
    }

    public void setVrate90(BizNumber pVrate90) {
        vrate90 = pVrate90;
    }

    private BizNumber vrate91;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE91)
    public BizNumber getVrate91() {
        return vrate91;
    }

    public void setVrate91(BizNumber pVrate91) {
        vrate91 = pVrate91;
    }

    private BizNumber vrate92;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE92)
    public BizNumber getVrate92() {
        return vrate92;
    }

    public void setVrate92(BizNumber pVrate92) {
        vrate92 = pVrate92;
    }

    private BizNumber vrate93;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE93)
    public BizNumber getVrate93() {
        return vrate93;
    }

    public void setVrate93(BizNumber pVrate93) {
        vrate93 = pVrate93;
    }

    private BizNumber vrate94;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE94)
    public BizNumber getVrate94() {
        return vrate94;
    }

    public void setVrate94(BizNumber pVrate94) {
        vrate94 = pVrate94;
    }

    private BizNumber vrate95;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE95)
    public BizNumber getVrate95() {
        return vrate95;
    }

    public void setVrate95(BizNumber pVrate95) {
        vrate95 = pVrate95;
    }

    private BizNumber vrate96;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE96)
    public BizNumber getVrate96() {
        return vrate96;
    }

    public void setVrate96(BizNumber pVrate96) {
        vrate96 = pVrate96;
    }

    private BizNumber vrate97;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE97)
    public BizNumber getVrate97() {
        return vrate97;
    }

    public void setVrate97(BizNumber pVrate97) {
        vrate97 = pVrate97;
    }

    private BizNumber vrate98;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE98)
    public BizNumber getVrate98() {
        return vrate98;
    }

    public void setVrate98(BizNumber pVrate98) {
        vrate98 = pVrate98;
    }

    private BizNumber vrate99;

    @Type(type="BizNumberType")
    @Column(name=GenBM_RateV.VRATE99)
    public BizNumber getVrate99() {
        return vrate99;
    }

    public void setVrate99(BizNumber pVrate99) {
        vrate99 = pVrate99;
    }
}
