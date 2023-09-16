package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.BM_RateNenkinD;
import yuyu.def.db.id.PKBM_RateNenkinD;
import yuyu.def.db.meta.GenQBM_RateNenkinD;
import yuyu.def.db.meta.QBM_RateNenkinD;

/**
 * 年金開始後Ｄレートマスタ テーブルのマッピング情報クラスで、 {@link BM_RateNenkinD} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateNenkinD}</td><td colspan="3">年金開始後Ｄレートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getPalnenkinsisutemusyurui palnenkinsisutemusyurui}</td><td>ＰＡＬ年金システム種類</td><td align="center">{@link PKBM_RateNenkinD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalnenkinsyuruikigou palnenkinsyuruikigou}</td><td>ＰＡＬ年金種類記号</td><td align="center">{@link PKBM_RateNenkinD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalnenkinkigousedaicode palnenkinkigousedaicode}</td><td>ＰＡＬ年金記号世代コード</td><td align="center">{@link PKBM_RateNenkinD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalnenkinsiharaikikan palnenkinsiharaikikan}</td><td>ＰＡＬ年金支払期間</td><td align="center">{@link PKBM_RateNenkinD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalnnknksgyoteiriritucode palnnknksgyoteiriritucode}</td><td>ＰＡＬ年金開始後予定利率コード</td><td align="center">{@link PKBM_RateNenkinD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalnnknksgjmtesuuryoucode palnnknksgjmtesuuryoucode}</td><td>ＰＡＬ年金開始後事務手数料コード</td><td align="center">{@link PKBM_RateNenkinD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPaldnendo paldnendo}</td><td>ＰＡＬＤ年度</td><td align="center">{@link PKBM_RateNenkinD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPaldratenaikakucode paldratenaikakucode}</td><td>ＰＡＬＤレート内定確定コード</td><td align="center">{@link PKBM_RateNenkinD ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate00 nenkinkaisigodrate00}</td><td>年金開始後Ｄレート００</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate01 nenkinkaisigodrate01}</td><td>年金開始後Ｄレート０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate02 nenkinkaisigodrate02}</td><td>年金開始後Ｄレート０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate03 nenkinkaisigodrate03}</td><td>年金開始後Ｄレート０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate04 nenkinkaisigodrate04}</td><td>年金開始後Ｄレート０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate05 nenkinkaisigodrate05}</td><td>年金開始後Ｄレート０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate06 nenkinkaisigodrate06}</td><td>年金開始後Ｄレート０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate07 nenkinkaisigodrate07}</td><td>年金開始後Ｄレート０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate08 nenkinkaisigodrate08}</td><td>年金開始後Ｄレート０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate09 nenkinkaisigodrate09}</td><td>年金開始後Ｄレート０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate10 nenkinkaisigodrate10}</td><td>年金開始後Ｄレート１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate11 nenkinkaisigodrate11}</td><td>年金開始後Ｄレート１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate12 nenkinkaisigodrate12}</td><td>年金開始後Ｄレート１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate13 nenkinkaisigodrate13}</td><td>年金開始後Ｄレート１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate14 nenkinkaisigodrate14}</td><td>年金開始後Ｄレート１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate15 nenkinkaisigodrate15}</td><td>年金開始後Ｄレート１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate16 nenkinkaisigodrate16}</td><td>年金開始後Ｄレート１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate17 nenkinkaisigodrate17}</td><td>年金開始後Ｄレート１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate18 nenkinkaisigodrate18}</td><td>年金開始後Ｄレート１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate19 nenkinkaisigodrate19}</td><td>年金開始後Ｄレート１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate20 nenkinkaisigodrate20}</td><td>年金開始後Ｄレート２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate21 nenkinkaisigodrate21}</td><td>年金開始後Ｄレート２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate22 nenkinkaisigodrate22}</td><td>年金開始後Ｄレート２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate23 nenkinkaisigodrate23}</td><td>年金開始後Ｄレート２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate24 nenkinkaisigodrate24}</td><td>年金開始後Ｄレート２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate25 nenkinkaisigodrate25}</td><td>年金開始後Ｄレート２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate26 nenkinkaisigodrate26}</td><td>年金開始後Ｄレート２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate27 nenkinkaisigodrate27}</td><td>年金開始後Ｄレート２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate28 nenkinkaisigodrate28}</td><td>年金開始後Ｄレート２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate29 nenkinkaisigodrate29}</td><td>年金開始後Ｄレート２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate30 nenkinkaisigodrate30}</td><td>年金開始後Ｄレート３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate31 nenkinkaisigodrate31}</td><td>年金開始後Ｄレート３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate32 nenkinkaisigodrate32}</td><td>年金開始後Ｄレート３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate33 nenkinkaisigodrate33}</td><td>年金開始後Ｄレート３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate34 nenkinkaisigodrate34}</td><td>年金開始後Ｄレート３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate35 nenkinkaisigodrate35}</td><td>年金開始後Ｄレート３５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate36 nenkinkaisigodrate36}</td><td>年金開始後Ｄレート３６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate37 nenkinkaisigodrate37}</td><td>年金開始後Ｄレート３７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate38 nenkinkaisigodrate38}</td><td>年金開始後Ｄレート３８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate39 nenkinkaisigodrate39}</td><td>年金開始後Ｄレート３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate40 nenkinkaisigodrate40}</td><td>年金開始後Ｄレート４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate41 nenkinkaisigodrate41}</td><td>年金開始後Ｄレート４１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate42 nenkinkaisigodrate42}</td><td>年金開始後Ｄレート４２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate43 nenkinkaisigodrate43}</td><td>年金開始後Ｄレート４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate44 nenkinkaisigodrate44}</td><td>年金開始後Ｄレート４４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate45 nenkinkaisigodrate45}</td><td>年金開始後Ｄレート４５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate46 nenkinkaisigodrate46}</td><td>年金開始後Ｄレート４６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate47 nenkinkaisigodrate47}</td><td>年金開始後Ｄレート４７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate48 nenkinkaisigodrate48}</td><td>年金開始後Ｄレート４８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate49 nenkinkaisigodrate49}</td><td>年金開始後Ｄレート４９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate50 nenkinkaisigodrate50}</td><td>年金開始後Ｄレート５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate51 nenkinkaisigodrate51}</td><td>年金開始後Ｄレート５１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate52 nenkinkaisigodrate52}</td><td>年金開始後Ｄレート５２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate53 nenkinkaisigodrate53}</td><td>年金開始後Ｄレート５３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate54 nenkinkaisigodrate54}</td><td>年金開始後Ｄレート５４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate55 nenkinkaisigodrate55}</td><td>年金開始後Ｄレート５５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate56 nenkinkaisigodrate56}</td><td>年金開始後Ｄレート５６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate57 nenkinkaisigodrate57}</td><td>年金開始後Ｄレート５７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate58 nenkinkaisigodrate58}</td><td>年金開始後Ｄレート５８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate59 nenkinkaisigodrate59}</td><td>年金開始後Ｄレート５９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate60 nenkinkaisigodrate60}</td><td>年金開始後Ｄレート６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate61 nenkinkaisigodrate61}</td><td>年金開始後Ｄレート６１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate62 nenkinkaisigodrate62}</td><td>年金開始後Ｄレート６２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate63 nenkinkaisigodrate63}</td><td>年金開始後Ｄレート６３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate64 nenkinkaisigodrate64}</td><td>年金開始後Ｄレート６４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate65 nenkinkaisigodrate65}</td><td>年金開始後Ｄレート６５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate66 nenkinkaisigodrate66}</td><td>年金開始後Ｄレート６６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate67 nenkinkaisigodrate67}</td><td>年金開始後Ｄレート６７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate68 nenkinkaisigodrate68}</td><td>年金開始後Ｄレート６８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate69 nenkinkaisigodrate69}</td><td>年金開始後Ｄレート６９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate70 nenkinkaisigodrate70}</td><td>年金開始後Ｄレート７０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate71 nenkinkaisigodrate71}</td><td>年金開始後Ｄレート７１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate72 nenkinkaisigodrate72}</td><td>年金開始後Ｄレート７２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate73 nenkinkaisigodrate73}</td><td>年金開始後Ｄレート７３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate74 nenkinkaisigodrate74}</td><td>年金開始後Ｄレート７４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate75 nenkinkaisigodrate75}</td><td>年金開始後Ｄレート７５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate76 nenkinkaisigodrate76}</td><td>年金開始後Ｄレート７６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate77 nenkinkaisigodrate77}</td><td>年金開始後Ｄレート７７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate78 nenkinkaisigodrate78}</td><td>年金開始後Ｄレート７８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate79 nenkinkaisigodrate79}</td><td>年金開始後Ｄレート７９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate80 nenkinkaisigodrate80}</td><td>年金開始後Ｄレート８０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate81 nenkinkaisigodrate81}</td><td>年金開始後Ｄレート８１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate82 nenkinkaisigodrate82}</td><td>年金開始後Ｄレート８２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate83 nenkinkaisigodrate83}</td><td>年金開始後Ｄレート８３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate84 nenkinkaisigodrate84}</td><td>年金開始後Ｄレート８４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate85 nenkinkaisigodrate85}</td><td>年金開始後Ｄレート８５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate86 nenkinkaisigodrate86}</td><td>年金開始後Ｄレート８６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate87 nenkinkaisigodrate87}</td><td>年金開始後Ｄレート８７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate88 nenkinkaisigodrate88}</td><td>年金開始後Ｄレート８８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate89 nenkinkaisigodrate89}</td><td>年金開始後Ｄレート８９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate90 nenkinkaisigodrate90}</td><td>年金開始後Ｄレート９０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate91 nenkinkaisigodrate91}</td><td>年金開始後Ｄレート９１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate92 nenkinkaisigodrate92}</td><td>年金開始後Ｄレート９２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate93 nenkinkaisigodrate93}</td><td>年金開始後Ｄレート９３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate94 nenkinkaisigodrate94}</td><td>年金開始後Ｄレート９４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate95 nenkinkaisigodrate95}</td><td>年金開始後Ｄレート９５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate96 nenkinkaisigodrate96}</td><td>年金開始後Ｄレート９６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate97 nenkinkaisigodrate97}</td><td>年金開始後Ｄレート９７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate98 nenkinkaisigodrate98}</td><td>年金開始後Ｄレート９８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigodrate99 nenkinkaisigodrate99}</td><td>年金開始後Ｄレート９９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     BM_RateNenkinD
 * @see     PKBM_RateNenkinD
 * @see     QBM_RateNenkinD
 * @see     GenQBM_RateNenkinD
 */
@MappedSuperclass
@Table(name=GenBM_RateNenkinD.TABLE_NAME)
@IdClass(value=PKBM_RateNenkinD.class)
public abstract class GenBM_RateNenkinD extends AbstractExDBEntity<BM_RateNenkinD, PKBM_RateNenkinD> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_RateNenkinD";
    public static final String PALNENKINSISUTEMUSYURUI  = "palnenkinsisutemusyurui";
    public static final String PALNENKINSYURUIKIGOU     = "palnenkinsyuruikigou";
    public static final String PALNENKINKIGOUSEDAICODE  = "palnenkinkigousedaicode";
    public static final String PALNENKINSIHARAIKIKAN    = "palnenkinsiharaikikan";
    public static final String PALNNKNKSGYOTEIRIRITUCODE = "palnnknksgyoteiriritucode";
    public static final String PALNNKNKSGJMTESUURYOUCODE = "palnnknksgjmtesuuryoucode";
    public static final String PALDNENDO                = "paldnendo";
    public static final String PALDRATENAIKAKUCODE      = "paldratenaikakucode";
    public static final String NENKINKAISIGODRATE00     = "nenkinkaisigodrate00";
    public static final String NENKINKAISIGODRATE01     = "nenkinkaisigodrate01";
    public static final String NENKINKAISIGODRATE02     = "nenkinkaisigodrate02";
    public static final String NENKINKAISIGODRATE03     = "nenkinkaisigodrate03";
    public static final String NENKINKAISIGODRATE04     = "nenkinkaisigodrate04";
    public static final String NENKINKAISIGODRATE05     = "nenkinkaisigodrate05";
    public static final String NENKINKAISIGODRATE06     = "nenkinkaisigodrate06";
    public static final String NENKINKAISIGODRATE07     = "nenkinkaisigodrate07";
    public static final String NENKINKAISIGODRATE08     = "nenkinkaisigodrate08";
    public static final String NENKINKAISIGODRATE09     = "nenkinkaisigodrate09";
    public static final String NENKINKAISIGODRATE10     = "nenkinkaisigodrate10";
    public static final String NENKINKAISIGODRATE11     = "nenkinkaisigodrate11";
    public static final String NENKINKAISIGODRATE12     = "nenkinkaisigodrate12";
    public static final String NENKINKAISIGODRATE13     = "nenkinkaisigodrate13";
    public static final String NENKINKAISIGODRATE14     = "nenkinkaisigodrate14";
    public static final String NENKINKAISIGODRATE15     = "nenkinkaisigodrate15";
    public static final String NENKINKAISIGODRATE16     = "nenkinkaisigodrate16";
    public static final String NENKINKAISIGODRATE17     = "nenkinkaisigodrate17";
    public static final String NENKINKAISIGODRATE18     = "nenkinkaisigodrate18";
    public static final String NENKINKAISIGODRATE19     = "nenkinkaisigodrate19";
    public static final String NENKINKAISIGODRATE20     = "nenkinkaisigodrate20";
    public static final String NENKINKAISIGODRATE21     = "nenkinkaisigodrate21";
    public static final String NENKINKAISIGODRATE22     = "nenkinkaisigodrate22";
    public static final String NENKINKAISIGODRATE23     = "nenkinkaisigodrate23";
    public static final String NENKINKAISIGODRATE24     = "nenkinkaisigodrate24";
    public static final String NENKINKAISIGODRATE25     = "nenkinkaisigodrate25";
    public static final String NENKINKAISIGODRATE26     = "nenkinkaisigodrate26";
    public static final String NENKINKAISIGODRATE27     = "nenkinkaisigodrate27";
    public static final String NENKINKAISIGODRATE28     = "nenkinkaisigodrate28";
    public static final String NENKINKAISIGODRATE29     = "nenkinkaisigodrate29";
    public static final String NENKINKAISIGODRATE30     = "nenkinkaisigodrate30";
    public static final String NENKINKAISIGODRATE31     = "nenkinkaisigodrate31";
    public static final String NENKINKAISIGODRATE32     = "nenkinkaisigodrate32";
    public static final String NENKINKAISIGODRATE33     = "nenkinkaisigodrate33";
    public static final String NENKINKAISIGODRATE34     = "nenkinkaisigodrate34";
    public static final String NENKINKAISIGODRATE35     = "nenkinkaisigodrate35";
    public static final String NENKINKAISIGODRATE36     = "nenkinkaisigodrate36";
    public static final String NENKINKAISIGODRATE37     = "nenkinkaisigodrate37";
    public static final String NENKINKAISIGODRATE38     = "nenkinkaisigodrate38";
    public static final String NENKINKAISIGODRATE39     = "nenkinkaisigodrate39";
    public static final String NENKINKAISIGODRATE40     = "nenkinkaisigodrate40";
    public static final String NENKINKAISIGODRATE41     = "nenkinkaisigodrate41";
    public static final String NENKINKAISIGODRATE42     = "nenkinkaisigodrate42";
    public static final String NENKINKAISIGODRATE43     = "nenkinkaisigodrate43";
    public static final String NENKINKAISIGODRATE44     = "nenkinkaisigodrate44";
    public static final String NENKINKAISIGODRATE45     = "nenkinkaisigodrate45";
    public static final String NENKINKAISIGODRATE46     = "nenkinkaisigodrate46";
    public static final String NENKINKAISIGODRATE47     = "nenkinkaisigodrate47";
    public static final String NENKINKAISIGODRATE48     = "nenkinkaisigodrate48";
    public static final String NENKINKAISIGODRATE49     = "nenkinkaisigodrate49";
    public static final String NENKINKAISIGODRATE50     = "nenkinkaisigodrate50";
    public static final String NENKINKAISIGODRATE51     = "nenkinkaisigodrate51";
    public static final String NENKINKAISIGODRATE52     = "nenkinkaisigodrate52";
    public static final String NENKINKAISIGODRATE53     = "nenkinkaisigodrate53";
    public static final String NENKINKAISIGODRATE54     = "nenkinkaisigodrate54";
    public static final String NENKINKAISIGODRATE55     = "nenkinkaisigodrate55";
    public static final String NENKINKAISIGODRATE56     = "nenkinkaisigodrate56";
    public static final String NENKINKAISIGODRATE57     = "nenkinkaisigodrate57";
    public static final String NENKINKAISIGODRATE58     = "nenkinkaisigodrate58";
    public static final String NENKINKAISIGODRATE59     = "nenkinkaisigodrate59";
    public static final String NENKINKAISIGODRATE60     = "nenkinkaisigodrate60";
    public static final String NENKINKAISIGODRATE61     = "nenkinkaisigodrate61";
    public static final String NENKINKAISIGODRATE62     = "nenkinkaisigodrate62";
    public static final String NENKINKAISIGODRATE63     = "nenkinkaisigodrate63";
    public static final String NENKINKAISIGODRATE64     = "nenkinkaisigodrate64";
    public static final String NENKINKAISIGODRATE65     = "nenkinkaisigodrate65";
    public static final String NENKINKAISIGODRATE66     = "nenkinkaisigodrate66";
    public static final String NENKINKAISIGODRATE67     = "nenkinkaisigodrate67";
    public static final String NENKINKAISIGODRATE68     = "nenkinkaisigodrate68";
    public static final String NENKINKAISIGODRATE69     = "nenkinkaisigodrate69";
    public static final String NENKINKAISIGODRATE70     = "nenkinkaisigodrate70";
    public static final String NENKINKAISIGODRATE71     = "nenkinkaisigodrate71";
    public static final String NENKINKAISIGODRATE72     = "nenkinkaisigodrate72";
    public static final String NENKINKAISIGODRATE73     = "nenkinkaisigodrate73";
    public static final String NENKINKAISIGODRATE74     = "nenkinkaisigodrate74";
    public static final String NENKINKAISIGODRATE75     = "nenkinkaisigodrate75";
    public static final String NENKINKAISIGODRATE76     = "nenkinkaisigodrate76";
    public static final String NENKINKAISIGODRATE77     = "nenkinkaisigodrate77";
    public static final String NENKINKAISIGODRATE78     = "nenkinkaisigodrate78";
    public static final String NENKINKAISIGODRATE79     = "nenkinkaisigodrate79";
    public static final String NENKINKAISIGODRATE80     = "nenkinkaisigodrate80";
    public static final String NENKINKAISIGODRATE81     = "nenkinkaisigodrate81";
    public static final String NENKINKAISIGODRATE82     = "nenkinkaisigodrate82";
    public static final String NENKINKAISIGODRATE83     = "nenkinkaisigodrate83";
    public static final String NENKINKAISIGODRATE84     = "nenkinkaisigodrate84";
    public static final String NENKINKAISIGODRATE85     = "nenkinkaisigodrate85";
    public static final String NENKINKAISIGODRATE86     = "nenkinkaisigodrate86";
    public static final String NENKINKAISIGODRATE87     = "nenkinkaisigodrate87";
    public static final String NENKINKAISIGODRATE88     = "nenkinkaisigodrate88";
    public static final String NENKINKAISIGODRATE89     = "nenkinkaisigodrate89";
    public static final String NENKINKAISIGODRATE90     = "nenkinkaisigodrate90";
    public static final String NENKINKAISIGODRATE91     = "nenkinkaisigodrate91";
    public static final String NENKINKAISIGODRATE92     = "nenkinkaisigodrate92";
    public static final String NENKINKAISIGODRATE93     = "nenkinkaisigodrate93";
    public static final String NENKINKAISIGODRATE94     = "nenkinkaisigodrate94";
    public static final String NENKINKAISIGODRATE95     = "nenkinkaisigodrate95";
    public static final String NENKINKAISIGODRATE96     = "nenkinkaisigodrate96";
    public static final String NENKINKAISIGODRATE97     = "nenkinkaisigodrate97";
    public static final String NENKINKAISIGODRATE98     = "nenkinkaisigodrate98";
    public static final String NENKINKAISIGODRATE99     = "nenkinkaisigodrate99";

    private final PKBM_RateNenkinD primaryKey;

    public GenBM_RateNenkinD() {
        primaryKey = new PKBM_RateNenkinD();
    }

    public GenBM_RateNenkinD(
        String pPalnenkinsisutemusyurui,
        String pPalnenkinsyuruikigou,
        String pPalnenkinkigousedaicode,
        String pPalnenkinsiharaikikan,
        String pPalnnknksgyoteiriritucode,
        String pPalnnknksgjmtesuuryoucode,
        String pPaldnendo,
        String pPaldratenaikakucode
    ) {
        primaryKey = new PKBM_RateNenkinD(
            pPalnenkinsisutemusyurui,
            pPalnenkinsyuruikigou,
            pPalnenkinkigousedaicode,
            pPalnenkinsiharaikikan,
            pPalnnknksgyoteiriritucode,
            pPalnnknksgjmtesuuryoucode,
            pPaldnendo,
            pPaldratenaikakucode
        );
    }

    @Transient
    @Override
    public PKBM_RateNenkinD getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_RateNenkinD> getMetaClass() {
        return QBM_RateNenkinD.class;
    }

    @Id
    @Column(name=GenBM_RateNenkinD.PALNENKINSISUTEMUSYURUI)
    public String getPalnenkinsisutemusyurui() {
        return getPrimaryKey().getPalnenkinsisutemusyurui();
    }

    public void setPalnenkinsisutemusyurui(String pPalnenkinsisutemusyurui) {
        getPrimaryKey().setPalnenkinsisutemusyurui(pPalnenkinsisutemusyurui);
    }

    @Id
    @Column(name=GenBM_RateNenkinD.PALNENKINSYURUIKIGOU)
    public String getPalnenkinsyuruikigou() {
        return getPrimaryKey().getPalnenkinsyuruikigou();
    }

    public void setPalnenkinsyuruikigou(String pPalnenkinsyuruikigou) {
        getPrimaryKey().setPalnenkinsyuruikigou(pPalnenkinsyuruikigou);
    }

    @Id
    @Column(name=GenBM_RateNenkinD.PALNENKINKIGOUSEDAICODE)
    public String getPalnenkinkigousedaicode() {
        return getPrimaryKey().getPalnenkinkigousedaicode();
    }

    public void setPalnenkinkigousedaicode(String pPalnenkinkigousedaicode) {
        getPrimaryKey().setPalnenkinkigousedaicode(pPalnenkinkigousedaicode);
    }

    @Id
    @Column(name=GenBM_RateNenkinD.PALNENKINSIHARAIKIKAN)
    public String getPalnenkinsiharaikikan() {
        return getPrimaryKey().getPalnenkinsiharaikikan();
    }

    public void setPalnenkinsiharaikikan(String pPalnenkinsiharaikikan) {
        getPrimaryKey().setPalnenkinsiharaikikan(pPalnenkinsiharaikikan);
    }

    @Id
    @Column(name=GenBM_RateNenkinD.PALNNKNKSGYOTEIRIRITUCODE)
    public String getPalnnknksgyoteiriritucode() {
        return getPrimaryKey().getPalnnknksgyoteiriritucode();
    }

    public void setPalnnknksgyoteiriritucode(String pPalnnknksgyoteiriritucode) {
        getPrimaryKey().setPalnnknksgyoteiriritucode(pPalnnknksgyoteiriritucode);
    }

    @Id
    @Column(name=GenBM_RateNenkinD.PALNNKNKSGJMTESUURYOUCODE)
    public String getPalnnknksgjmtesuuryoucode() {
        return getPrimaryKey().getPalnnknksgjmtesuuryoucode();
    }

    public void setPalnnknksgjmtesuuryoucode(String pPalnnknksgjmtesuuryoucode) {
        getPrimaryKey().setPalnnknksgjmtesuuryoucode(pPalnnknksgjmtesuuryoucode);
    }

    @Id
    @Column(name=GenBM_RateNenkinD.PALDNENDO)
    public String getPaldnendo() {
        return getPrimaryKey().getPaldnendo();
    }

    public void setPaldnendo(String pPaldnendo) {
        getPrimaryKey().setPaldnendo(pPaldnendo);
    }

    @Id
    @Column(name=GenBM_RateNenkinD.PALDRATENAIKAKUCODE)
    public String getPaldratenaikakucode() {
        return getPrimaryKey().getPaldratenaikakucode();
    }

    public void setPaldratenaikakucode(String pPaldratenaikakucode) {
        getPrimaryKey().setPaldratenaikakucode(pPaldratenaikakucode);
    }

    private String nenkinkaisigodrate00;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE00)
    public String getNenkinkaisigodrate00() {
        return nenkinkaisigodrate00;
    }

    public void setNenkinkaisigodrate00(String pNenkinkaisigodrate00) {
        nenkinkaisigodrate00 = pNenkinkaisigodrate00;
    }

    private String nenkinkaisigodrate01;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE01)
    public String getNenkinkaisigodrate01() {
        return nenkinkaisigodrate01;
    }

    public void setNenkinkaisigodrate01(String pNenkinkaisigodrate01) {
        nenkinkaisigodrate01 = pNenkinkaisigodrate01;
    }

    private String nenkinkaisigodrate02;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE02)
    public String getNenkinkaisigodrate02() {
        return nenkinkaisigodrate02;
    }

    public void setNenkinkaisigodrate02(String pNenkinkaisigodrate02) {
        nenkinkaisigodrate02 = pNenkinkaisigodrate02;
    }

    private String nenkinkaisigodrate03;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE03)
    public String getNenkinkaisigodrate03() {
        return nenkinkaisigodrate03;
    }

    public void setNenkinkaisigodrate03(String pNenkinkaisigodrate03) {
        nenkinkaisigodrate03 = pNenkinkaisigodrate03;
    }

    private String nenkinkaisigodrate04;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE04)
    public String getNenkinkaisigodrate04() {
        return nenkinkaisigodrate04;
    }

    public void setNenkinkaisigodrate04(String pNenkinkaisigodrate04) {
        nenkinkaisigodrate04 = pNenkinkaisigodrate04;
    }

    private String nenkinkaisigodrate05;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE05)
    public String getNenkinkaisigodrate05() {
        return nenkinkaisigodrate05;
    }

    public void setNenkinkaisigodrate05(String pNenkinkaisigodrate05) {
        nenkinkaisigodrate05 = pNenkinkaisigodrate05;
    }

    private String nenkinkaisigodrate06;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE06)
    public String getNenkinkaisigodrate06() {
        return nenkinkaisigodrate06;
    }

    public void setNenkinkaisigodrate06(String pNenkinkaisigodrate06) {
        nenkinkaisigodrate06 = pNenkinkaisigodrate06;
    }

    private String nenkinkaisigodrate07;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE07)
    public String getNenkinkaisigodrate07() {
        return nenkinkaisigodrate07;
    }

    public void setNenkinkaisigodrate07(String pNenkinkaisigodrate07) {
        nenkinkaisigodrate07 = pNenkinkaisigodrate07;
    }

    private String nenkinkaisigodrate08;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE08)
    public String getNenkinkaisigodrate08() {
        return nenkinkaisigodrate08;
    }

    public void setNenkinkaisigodrate08(String pNenkinkaisigodrate08) {
        nenkinkaisigodrate08 = pNenkinkaisigodrate08;
    }

    private String nenkinkaisigodrate09;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE09)
    public String getNenkinkaisigodrate09() {
        return nenkinkaisigodrate09;
    }

    public void setNenkinkaisigodrate09(String pNenkinkaisigodrate09) {
        nenkinkaisigodrate09 = pNenkinkaisigodrate09;
    }

    private String nenkinkaisigodrate10;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE10)
    public String getNenkinkaisigodrate10() {
        return nenkinkaisigodrate10;
    }

    public void setNenkinkaisigodrate10(String pNenkinkaisigodrate10) {
        nenkinkaisigodrate10 = pNenkinkaisigodrate10;
    }

    private String nenkinkaisigodrate11;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE11)
    public String getNenkinkaisigodrate11() {
        return nenkinkaisigodrate11;
    }

    public void setNenkinkaisigodrate11(String pNenkinkaisigodrate11) {
        nenkinkaisigodrate11 = pNenkinkaisigodrate11;
    }

    private String nenkinkaisigodrate12;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE12)
    public String getNenkinkaisigodrate12() {
        return nenkinkaisigodrate12;
    }

    public void setNenkinkaisigodrate12(String pNenkinkaisigodrate12) {
        nenkinkaisigodrate12 = pNenkinkaisigodrate12;
    }

    private String nenkinkaisigodrate13;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE13)
    public String getNenkinkaisigodrate13() {
        return nenkinkaisigodrate13;
    }

    public void setNenkinkaisigodrate13(String pNenkinkaisigodrate13) {
        nenkinkaisigodrate13 = pNenkinkaisigodrate13;
    }

    private String nenkinkaisigodrate14;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE14)
    public String getNenkinkaisigodrate14() {
        return nenkinkaisigodrate14;
    }

    public void setNenkinkaisigodrate14(String pNenkinkaisigodrate14) {
        nenkinkaisigodrate14 = pNenkinkaisigodrate14;
    }

    private String nenkinkaisigodrate15;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE15)
    public String getNenkinkaisigodrate15() {
        return nenkinkaisigodrate15;
    }

    public void setNenkinkaisigodrate15(String pNenkinkaisigodrate15) {
        nenkinkaisigodrate15 = pNenkinkaisigodrate15;
    }

    private String nenkinkaisigodrate16;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE16)
    public String getNenkinkaisigodrate16() {
        return nenkinkaisigodrate16;
    }

    public void setNenkinkaisigodrate16(String pNenkinkaisigodrate16) {
        nenkinkaisigodrate16 = pNenkinkaisigodrate16;
    }

    private String nenkinkaisigodrate17;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE17)
    public String getNenkinkaisigodrate17() {
        return nenkinkaisigodrate17;
    }

    public void setNenkinkaisigodrate17(String pNenkinkaisigodrate17) {
        nenkinkaisigodrate17 = pNenkinkaisigodrate17;
    }

    private String nenkinkaisigodrate18;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE18)
    public String getNenkinkaisigodrate18() {
        return nenkinkaisigodrate18;
    }

    public void setNenkinkaisigodrate18(String pNenkinkaisigodrate18) {
        nenkinkaisigodrate18 = pNenkinkaisigodrate18;
    }

    private String nenkinkaisigodrate19;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE19)
    public String getNenkinkaisigodrate19() {
        return nenkinkaisigodrate19;
    }

    public void setNenkinkaisigodrate19(String pNenkinkaisigodrate19) {
        nenkinkaisigodrate19 = pNenkinkaisigodrate19;
    }

    private String nenkinkaisigodrate20;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE20)
    public String getNenkinkaisigodrate20() {
        return nenkinkaisigodrate20;
    }

    public void setNenkinkaisigodrate20(String pNenkinkaisigodrate20) {
        nenkinkaisigodrate20 = pNenkinkaisigodrate20;
    }

    private String nenkinkaisigodrate21;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE21)
    public String getNenkinkaisigodrate21() {
        return nenkinkaisigodrate21;
    }

    public void setNenkinkaisigodrate21(String pNenkinkaisigodrate21) {
        nenkinkaisigodrate21 = pNenkinkaisigodrate21;
    }

    private String nenkinkaisigodrate22;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE22)
    public String getNenkinkaisigodrate22() {
        return nenkinkaisigodrate22;
    }

    public void setNenkinkaisigodrate22(String pNenkinkaisigodrate22) {
        nenkinkaisigodrate22 = pNenkinkaisigodrate22;
    }

    private String nenkinkaisigodrate23;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE23)
    public String getNenkinkaisigodrate23() {
        return nenkinkaisigodrate23;
    }

    public void setNenkinkaisigodrate23(String pNenkinkaisigodrate23) {
        nenkinkaisigodrate23 = pNenkinkaisigodrate23;
    }

    private String nenkinkaisigodrate24;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE24)
    public String getNenkinkaisigodrate24() {
        return nenkinkaisigodrate24;
    }

    public void setNenkinkaisigodrate24(String pNenkinkaisigodrate24) {
        nenkinkaisigodrate24 = pNenkinkaisigodrate24;
    }

    private String nenkinkaisigodrate25;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE25)
    public String getNenkinkaisigodrate25() {
        return nenkinkaisigodrate25;
    }

    public void setNenkinkaisigodrate25(String pNenkinkaisigodrate25) {
        nenkinkaisigodrate25 = pNenkinkaisigodrate25;
    }

    private String nenkinkaisigodrate26;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE26)
    public String getNenkinkaisigodrate26() {
        return nenkinkaisigodrate26;
    }

    public void setNenkinkaisigodrate26(String pNenkinkaisigodrate26) {
        nenkinkaisigodrate26 = pNenkinkaisigodrate26;
    }

    private String nenkinkaisigodrate27;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE27)
    public String getNenkinkaisigodrate27() {
        return nenkinkaisigodrate27;
    }

    public void setNenkinkaisigodrate27(String pNenkinkaisigodrate27) {
        nenkinkaisigodrate27 = pNenkinkaisigodrate27;
    }

    private String nenkinkaisigodrate28;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE28)
    public String getNenkinkaisigodrate28() {
        return nenkinkaisigodrate28;
    }

    public void setNenkinkaisigodrate28(String pNenkinkaisigodrate28) {
        nenkinkaisigodrate28 = pNenkinkaisigodrate28;
    }

    private String nenkinkaisigodrate29;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE29)
    public String getNenkinkaisigodrate29() {
        return nenkinkaisigodrate29;
    }

    public void setNenkinkaisigodrate29(String pNenkinkaisigodrate29) {
        nenkinkaisigodrate29 = pNenkinkaisigodrate29;
    }

    private String nenkinkaisigodrate30;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE30)
    public String getNenkinkaisigodrate30() {
        return nenkinkaisigodrate30;
    }

    public void setNenkinkaisigodrate30(String pNenkinkaisigodrate30) {
        nenkinkaisigodrate30 = pNenkinkaisigodrate30;
    }

    private String nenkinkaisigodrate31;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE31)
    public String getNenkinkaisigodrate31() {
        return nenkinkaisigodrate31;
    }

    public void setNenkinkaisigodrate31(String pNenkinkaisigodrate31) {
        nenkinkaisigodrate31 = pNenkinkaisigodrate31;
    }

    private String nenkinkaisigodrate32;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE32)
    public String getNenkinkaisigodrate32() {
        return nenkinkaisigodrate32;
    }

    public void setNenkinkaisigodrate32(String pNenkinkaisigodrate32) {
        nenkinkaisigodrate32 = pNenkinkaisigodrate32;
    }

    private String nenkinkaisigodrate33;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE33)
    public String getNenkinkaisigodrate33() {
        return nenkinkaisigodrate33;
    }

    public void setNenkinkaisigodrate33(String pNenkinkaisigodrate33) {
        nenkinkaisigodrate33 = pNenkinkaisigodrate33;
    }

    private String nenkinkaisigodrate34;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE34)
    public String getNenkinkaisigodrate34() {
        return nenkinkaisigodrate34;
    }

    public void setNenkinkaisigodrate34(String pNenkinkaisigodrate34) {
        nenkinkaisigodrate34 = pNenkinkaisigodrate34;
    }

    private String nenkinkaisigodrate35;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE35)
    public String getNenkinkaisigodrate35() {
        return nenkinkaisigodrate35;
    }

    public void setNenkinkaisigodrate35(String pNenkinkaisigodrate35) {
        nenkinkaisigodrate35 = pNenkinkaisigodrate35;
    }

    private String nenkinkaisigodrate36;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE36)
    public String getNenkinkaisigodrate36() {
        return nenkinkaisigodrate36;
    }

    public void setNenkinkaisigodrate36(String pNenkinkaisigodrate36) {
        nenkinkaisigodrate36 = pNenkinkaisigodrate36;
    }

    private String nenkinkaisigodrate37;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE37)
    public String getNenkinkaisigodrate37() {
        return nenkinkaisigodrate37;
    }

    public void setNenkinkaisigodrate37(String pNenkinkaisigodrate37) {
        nenkinkaisigodrate37 = pNenkinkaisigodrate37;
    }

    private String nenkinkaisigodrate38;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE38)
    public String getNenkinkaisigodrate38() {
        return nenkinkaisigodrate38;
    }

    public void setNenkinkaisigodrate38(String pNenkinkaisigodrate38) {
        nenkinkaisigodrate38 = pNenkinkaisigodrate38;
    }

    private String nenkinkaisigodrate39;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE39)
    public String getNenkinkaisigodrate39() {
        return nenkinkaisigodrate39;
    }

    public void setNenkinkaisigodrate39(String pNenkinkaisigodrate39) {
        nenkinkaisigodrate39 = pNenkinkaisigodrate39;
    }

    private String nenkinkaisigodrate40;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE40)
    public String getNenkinkaisigodrate40() {
        return nenkinkaisigodrate40;
    }

    public void setNenkinkaisigodrate40(String pNenkinkaisigodrate40) {
        nenkinkaisigodrate40 = pNenkinkaisigodrate40;
    }

    private String nenkinkaisigodrate41;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE41)
    public String getNenkinkaisigodrate41() {
        return nenkinkaisigodrate41;
    }

    public void setNenkinkaisigodrate41(String pNenkinkaisigodrate41) {
        nenkinkaisigodrate41 = pNenkinkaisigodrate41;
    }

    private String nenkinkaisigodrate42;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE42)
    public String getNenkinkaisigodrate42() {
        return nenkinkaisigodrate42;
    }

    public void setNenkinkaisigodrate42(String pNenkinkaisigodrate42) {
        nenkinkaisigodrate42 = pNenkinkaisigodrate42;
    }

    private String nenkinkaisigodrate43;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE43)
    public String getNenkinkaisigodrate43() {
        return nenkinkaisigodrate43;
    }

    public void setNenkinkaisigodrate43(String pNenkinkaisigodrate43) {
        nenkinkaisigodrate43 = pNenkinkaisigodrate43;
    }

    private String nenkinkaisigodrate44;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE44)
    public String getNenkinkaisigodrate44() {
        return nenkinkaisigodrate44;
    }

    public void setNenkinkaisigodrate44(String pNenkinkaisigodrate44) {
        nenkinkaisigodrate44 = pNenkinkaisigodrate44;
    }

    private String nenkinkaisigodrate45;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE45)
    public String getNenkinkaisigodrate45() {
        return nenkinkaisigodrate45;
    }

    public void setNenkinkaisigodrate45(String pNenkinkaisigodrate45) {
        nenkinkaisigodrate45 = pNenkinkaisigodrate45;
    }

    private String nenkinkaisigodrate46;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE46)
    public String getNenkinkaisigodrate46() {
        return nenkinkaisigodrate46;
    }

    public void setNenkinkaisigodrate46(String pNenkinkaisigodrate46) {
        nenkinkaisigodrate46 = pNenkinkaisigodrate46;
    }

    private String nenkinkaisigodrate47;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE47)
    public String getNenkinkaisigodrate47() {
        return nenkinkaisigodrate47;
    }

    public void setNenkinkaisigodrate47(String pNenkinkaisigodrate47) {
        nenkinkaisigodrate47 = pNenkinkaisigodrate47;
    }

    private String nenkinkaisigodrate48;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE48)
    public String getNenkinkaisigodrate48() {
        return nenkinkaisigodrate48;
    }

    public void setNenkinkaisigodrate48(String pNenkinkaisigodrate48) {
        nenkinkaisigodrate48 = pNenkinkaisigodrate48;
    }

    private String nenkinkaisigodrate49;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE49)
    public String getNenkinkaisigodrate49() {
        return nenkinkaisigodrate49;
    }

    public void setNenkinkaisigodrate49(String pNenkinkaisigodrate49) {
        nenkinkaisigodrate49 = pNenkinkaisigodrate49;
    }

    private String nenkinkaisigodrate50;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE50)
    public String getNenkinkaisigodrate50() {
        return nenkinkaisigodrate50;
    }

    public void setNenkinkaisigodrate50(String pNenkinkaisigodrate50) {
        nenkinkaisigodrate50 = pNenkinkaisigodrate50;
    }

    private String nenkinkaisigodrate51;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE51)
    public String getNenkinkaisigodrate51() {
        return nenkinkaisigodrate51;
    }

    public void setNenkinkaisigodrate51(String pNenkinkaisigodrate51) {
        nenkinkaisigodrate51 = pNenkinkaisigodrate51;
    }

    private String nenkinkaisigodrate52;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE52)
    public String getNenkinkaisigodrate52() {
        return nenkinkaisigodrate52;
    }

    public void setNenkinkaisigodrate52(String pNenkinkaisigodrate52) {
        nenkinkaisigodrate52 = pNenkinkaisigodrate52;
    }

    private String nenkinkaisigodrate53;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE53)
    public String getNenkinkaisigodrate53() {
        return nenkinkaisigodrate53;
    }

    public void setNenkinkaisigodrate53(String pNenkinkaisigodrate53) {
        nenkinkaisigodrate53 = pNenkinkaisigodrate53;
    }

    private String nenkinkaisigodrate54;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE54)
    public String getNenkinkaisigodrate54() {
        return nenkinkaisigodrate54;
    }

    public void setNenkinkaisigodrate54(String pNenkinkaisigodrate54) {
        nenkinkaisigodrate54 = pNenkinkaisigodrate54;
    }

    private String nenkinkaisigodrate55;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE55)
    public String getNenkinkaisigodrate55() {
        return nenkinkaisigodrate55;
    }

    public void setNenkinkaisigodrate55(String pNenkinkaisigodrate55) {
        nenkinkaisigodrate55 = pNenkinkaisigodrate55;
    }

    private String nenkinkaisigodrate56;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE56)
    public String getNenkinkaisigodrate56() {
        return nenkinkaisigodrate56;
    }

    public void setNenkinkaisigodrate56(String pNenkinkaisigodrate56) {
        nenkinkaisigodrate56 = pNenkinkaisigodrate56;
    }

    private String nenkinkaisigodrate57;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE57)
    public String getNenkinkaisigodrate57() {
        return nenkinkaisigodrate57;
    }

    public void setNenkinkaisigodrate57(String pNenkinkaisigodrate57) {
        nenkinkaisigodrate57 = pNenkinkaisigodrate57;
    }

    private String nenkinkaisigodrate58;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE58)
    public String getNenkinkaisigodrate58() {
        return nenkinkaisigodrate58;
    }

    public void setNenkinkaisigodrate58(String pNenkinkaisigodrate58) {
        nenkinkaisigodrate58 = pNenkinkaisigodrate58;
    }

    private String nenkinkaisigodrate59;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE59)
    public String getNenkinkaisigodrate59() {
        return nenkinkaisigodrate59;
    }

    public void setNenkinkaisigodrate59(String pNenkinkaisigodrate59) {
        nenkinkaisigodrate59 = pNenkinkaisigodrate59;
    }

    private String nenkinkaisigodrate60;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE60)
    public String getNenkinkaisigodrate60() {
        return nenkinkaisigodrate60;
    }

    public void setNenkinkaisigodrate60(String pNenkinkaisigodrate60) {
        nenkinkaisigodrate60 = pNenkinkaisigodrate60;
    }

    private String nenkinkaisigodrate61;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE61)
    public String getNenkinkaisigodrate61() {
        return nenkinkaisigodrate61;
    }

    public void setNenkinkaisigodrate61(String pNenkinkaisigodrate61) {
        nenkinkaisigodrate61 = pNenkinkaisigodrate61;
    }

    private String nenkinkaisigodrate62;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE62)
    public String getNenkinkaisigodrate62() {
        return nenkinkaisigodrate62;
    }

    public void setNenkinkaisigodrate62(String pNenkinkaisigodrate62) {
        nenkinkaisigodrate62 = pNenkinkaisigodrate62;
    }

    private String nenkinkaisigodrate63;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE63)
    public String getNenkinkaisigodrate63() {
        return nenkinkaisigodrate63;
    }

    public void setNenkinkaisigodrate63(String pNenkinkaisigodrate63) {
        nenkinkaisigodrate63 = pNenkinkaisigodrate63;
    }

    private String nenkinkaisigodrate64;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE64)
    public String getNenkinkaisigodrate64() {
        return nenkinkaisigodrate64;
    }

    public void setNenkinkaisigodrate64(String pNenkinkaisigodrate64) {
        nenkinkaisigodrate64 = pNenkinkaisigodrate64;
    }

    private String nenkinkaisigodrate65;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE65)
    public String getNenkinkaisigodrate65() {
        return nenkinkaisigodrate65;
    }

    public void setNenkinkaisigodrate65(String pNenkinkaisigodrate65) {
        nenkinkaisigodrate65 = pNenkinkaisigodrate65;
    }

    private String nenkinkaisigodrate66;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE66)
    public String getNenkinkaisigodrate66() {
        return nenkinkaisigodrate66;
    }

    public void setNenkinkaisigodrate66(String pNenkinkaisigodrate66) {
        nenkinkaisigodrate66 = pNenkinkaisigodrate66;
    }

    private String nenkinkaisigodrate67;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE67)
    public String getNenkinkaisigodrate67() {
        return nenkinkaisigodrate67;
    }

    public void setNenkinkaisigodrate67(String pNenkinkaisigodrate67) {
        nenkinkaisigodrate67 = pNenkinkaisigodrate67;
    }

    private String nenkinkaisigodrate68;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE68)
    public String getNenkinkaisigodrate68() {
        return nenkinkaisigodrate68;
    }

    public void setNenkinkaisigodrate68(String pNenkinkaisigodrate68) {
        nenkinkaisigodrate68 = pNenkinkaisigodrate68;
    }

    private String nenkinkaisigodrate69;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE69)
    public String getNenkinkaisigodrate69() {
        return nenkinkaisigodrate69;
    }

    public void setNenkinkaisigodrate69(String pNenkinkaisigodrate69) {
        nenkinkaisigodrate69 = pNenkinkaisigodrate69;
    }

    private String nenkinkaisigodrate70;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE70)
    public String getNenkinkaisigodrate70() {
        return nenkinkaisigodrate70;
    }

    public void setNenkinkaisigodrate70(String pNenkinkaisigodrate70) {
        nenkinkaisigodrate70 = pNenkinkaisigodrate70;
    }

    private String nenkinkaisigodrate71;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE71)
    public String getNenkinkaisigodrate71() {
        return nenkinkaisigodrate71;
    }

    public void setNenkinkaisigodrate71(String pNenkinkaisigodrate71) {
        nenkinkaisigodrate71 = pNenkinkaisigodrate71;
    }

    private String nenkinkaisigodrate72;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE72)
    public String getNenkinkaisigodrate72() {
        return nenkinkaisigodrate72;
    }

    public void setNenkinkaisigodrate72(String pNenkinkaisigodrate72) {
        nenkinkaisigodrate72 = pNenkinkaisigodrate72;
    }

    private String nenkinkaisigodrate73;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE73)
    public String getNenkinkaisigodrate73() {
        return nenkinkaisigodrate73;
    }

    public void setNenkinkaisigodrate73(String pNenkinkaisigodrate73) {
        nenkinkaisigodrate73 = pNenkinkaisigodrate73;
    }

    private String nenkinkaisigodrate74;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE74)
    public String getNenkinkaisigodrate74() {
        return nenkinkaisigodrate74;
    }

    public void setNenkinkaisigodrate74(String pNenkinkaisigodrate74) {
        nenkinkaisigodrate74 = pNenkinkaisigodrate74;
    }

    private String nenkinkaisigodrate75;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE75)
    public String getNenkinkaisigodrate75() {
        return nenkinkaisigodrate75;
    }

    public void setNenkinkaisigodrate75(String pNenkinkaisigodrate75) {
        nenkinkaisigodrate75 = pNenkinkaisigodrate75;
    }

    private String nenkinkaisigodrate76;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE76)
    public String getNenkinkaisigodrate76() {
        return nenkinkaisigodrate76;
    }

    public void setNenkinkaisigodrate76(String pNenkinkaisigodrate76) {
        nenkinkaisigodrate76 = pNenkinkaisigodrate76;
    }

    private String nenkinkaisigodrate77;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE77)
    public String getNenkinkaisigodrate77() {
        return nenkinkaisigodrate77;
    }

    public void setNenkinkaisigodrate77(String pNenkinkaisigodrate77) {
        nenkinkaisigodrate77 = pNenkinkaisigodrate77;
    }

    private String nenkinkaisigodrate78;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE78)
    public String getNenkinkaisigodrate78() {
        return nenkinkaisigodrate78;
    }

    public void setNenkinkaisigodrate78(String pNenkinkaisigodrate78) {
        nenkinkaisigodrate78 = pNenkinkaisigodrate78;
    }

    private String nenkinkaisigodrate79;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE79)
    public String getNenkinkaisigodrate79() {
        return nenkinkaisigodrate79;
    }

    public void setNenkinkaisigodrate79(String pNenkinkaisigodrate79) {
        nenkinkaisigodrate79 = pNenkinkaisigodrate79;
    }

    private String nenkinkaisigodrate80;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE80)
    public String getNenkinkaisigodrate80() {
        return nenkinkaisigodrate80;
    }

    public void setNenkinkaisigodrate80(String pNenkinkaisigodrate80) {
        nenkinkaisigodrate80 = pNenkinkaisigodrate80;
    }

    private String nenkinkaisigodrate81;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE81)
    public String getNenkinkaisigodrate81() {
        return nenkinkaisigodrate81;
    }

    public void setNenkinkaisigodrate81(String pNenkinkaisigodrate81) {
        nenkinkaisigodrate81 = pNenkinkaisigodrate81;
    }

    private String nenkinkaisigodrate82;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE82)
    public String getNenkinkaisigodrate82() {
        return nenkinkaisigodrate82;
    }

    public void setNenkinkaisigodrate82(String pNenkinkaisigodrate82) {
        nenkinkaisigodrate82 = pNenkinkaisigodrate82;
    }

    private String nenkinkaisigodrate83;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE83)
    public String getNenkinkaisigodrate83() {
        return nenkinkaisigodrate83;
    }

    public void setNenkinkaisigodrate83(String pNenkinkaisigodrate83) {
        nenkinkaisigodrate83 = pNenkinkaisigodrate83;
    }

    private String nenkinkaisigodrate84;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE84)
    public String getNenkinkaisigodrate84() {
        return nenkinkaisigodrate84;
    }

    public void setNenkinkaisigodrate84(String pNenkinkaisigodrate84) {
        nenkinkaisigodrate84 = pNenkinkaisigodrate84;
    }

    private String nenkinkaisigodrate85;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE85)
    public String getNenkinkaisigodrate85() {
        return nenkinkaisigodrate85;
    }

    public void setNenkinkaisigodrate85(String pNenkinkaisigodrate85) {
        nenkinkaisigodrate85 = pNenkinkaisigodrate85;
    }

    private String nenkinkaisigodrate86;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE86)
    public String getNenkinkaisigodrate86() {
        return nenkinkaisigodrate86;
    }

    public void setNenkinkaisigodrate86(String pNenkinkaisigodrate86) {
        nenkinkaisigodrate86 = pNenkinkaisigodrate86;
    }

    private String nenkinkaisigodrate87;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE87)
    public String getNenkinkaisigodrate87() {
        return nenkinkaisigodrate87;
    }

    public void setNenkinkaisigodrate87(String pNenkinkaisigodrate87) {
        nenkinkaisigodrate87 = pNenkinkaisigodrate87;
    }

    private String nenkinkaisigodrate88;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE88)
    public String getNenkinkaisigodrate88() {
        return nenkinkaisigodrate88;
    }

    public void setNenkinkaisigodrate88(String pNenkinkaisigodrate88) {
        nenkinkaisigodrate88 = pNenkinkaisigodrate88;
    }

    private String nenkinkaisigodrate89;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE89)
    public String getNenkinkaisigodrate89() {
        return nenkinkaisigodrate89;
    }

    public void setNenkinkaisigodrate89(String pNenkinkaisigodrate89) {
        nenkinkaisigodrate89 = pNenkinkaisigodrate89;
    }

    private String nenkinkaisigodrate90;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE90)
    public String getNenkinkaisigodrate90() {
        return nenkinkaisigodrate90;
    }

    public void setNenkinkaisigodrate90(String pNenkinkaisigodrate90) {
        nenkinkaisigodrate90 = pNenkinkaisigodrate90;
    }

    private String nenkinkaisigodrate91;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE91)
    public String getNenkinkaisigodrate91() {
        return nenkinkaisigodrate91;
    }

    public void setNenkinkaisigodrate91(String pNenkinkaisigodrate91) {
        nenkinkaisigodrate91 = pNenkinkaisigodrate91;
    }

    private String nenkinkaisigodrate92;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE92)
    public String getNenkinkaisigodrate92() {
        return nenkinkaisigodrate92;
    }

    public void setNenkinkaisigodrate92(String pNenkinkaisigodrate92) {
        nenkinkaisigodrate92 = pNenkinkaisigodrate92;
    }

    private String nenkinkaisigodrate93;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE93)
    public String getNenkinkaisigodrate93() {
        return nenkinkaisigodrate93;
    }

    public void setNenkinkaisigodrate93(String pNenkinkaisigodrate93) {
        nenkinkaisigodrate93 = pNenkinkaisigodrate93;
    }

    private String nenkinkaisigodrate94;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE94)
    public String getNenkinkaisigodrate94() {
        return nenkinkaisigodrate94;
    }

    public void setNenkinkaisigodrate94(String pNenkinkaisigodrate94) {
        nenkinkaisigodrate94 = pNenkinkaisigodrate94;
    }

    private String nenkinkaisigodrate95;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE95)
    public String getNenkinkaisigodrate95() {
        return nenkinkaisigodrate95;
    }

    public void setNenkinkaisigodrate95(String pNenkinkaisigodrate95) {
        nenkinkaisigodrate95 = pNenkinkaisigodrate95;
    }

    private String nenkinkaisigodrate96;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE96)
    public String getNenkinkaisigodrate96() {
        return nenkinkaisigodrate96;
    }

    public void setNenkinkaisigodrate96(String pNenkinkaisigodrate96) {
        nenkinkaisigodrate96 = pNenkinkaisigodrate96;
    }

    private String nenkinkaisigodrate97;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE97)
    public String getNenkinkaisigodrate97() {
        return nenkinkaisigodrate97;
    }

    public void setNenkinkaisigodrate97(String pNenkinkaisigodrate97) {
        nenkinkaisigodrate97 = pNenkinkaisigodrate97;
    }

    private String nenkinkaisigodrate98;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE98)
    public String getNenkinkaisigodrate98() {
        return nenkinkaisigodrate98;
    }

    public void setNenkinkaisigodrate98(String pNenkinkaisigodrate98) {
        nenkinkaisigodrate98 = pNenkinkaisigodrate98;
    }

    private String nenkinkaisigodrate99;

    @Column(name=GenBM_RateNenkinD.NENKINKAISIGODRATE99)
    public String getNenkinkaisigodrate99() {
        return nenkinkaisigodrate99;
    }

    public void setNenkinkaisigodrate99(String pNenkinkaisigodrate99) {
        nenkinkaisigodrate99 = pNenkinkaisigodrate99;
    }
}
