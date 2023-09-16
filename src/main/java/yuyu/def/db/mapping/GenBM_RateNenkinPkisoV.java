package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.BM_RateNenkinPkisoV;
import yuyu.def.db.id.PKBM_RateNenkinPkisoV;
import yuyu.def.db.meta.GenQBM_RateNenkinPkisoV;
import yuyu.def.db.meta.QBM_RateNenkinPkisoV;

/**
 * 年金開始後Ｐ基礎Ｖレートマスタ テーブルのマッピング情報クラスで、 {@link BM_RateNenkinPkisoV} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateNenkinPkisoV}</td><td colspan="3">年金開始後Ｐ基礎Ｖレートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getPalnenkinsisutemusyurui palnenkinsisutemusyurui}</td><td>ＰＡＬ年金システム種類</td><td align="center">{@link PKBM_RateNenkinPkisoV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalnenkinsyuruikigou palnenkinsyuruikigou}</td><td>ＰＡＬ年金種類記号</td><td align="center">{@link PKBM_RateNenkinPkisoV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalnenkinkigousedaicode palnenkinkigousedaicode}</td><td>ＰＡＬ年金記号世代コード</td><td align="center">{@link PKBM_RateNenkinPkisoV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalnenkinsiharaikikan palnenkinsiharaikikan}</td><td>ＰＡＬ年金支払期間</td><td align="center">{@link PKBM_RateNenkinPkisoV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalnnknksgyoteiriritucode palnnknksgyoteiriritucode}</td><td>ＰＡＬ年金開始後予定利率コード</td><td align="center">{@link PKBM_RateNenkinPkisoV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getPalnnknksgjmtesuuryoucode palnnknksgjmtesuuryoucode}</td><td>ＰＡＬ年金開始後事務手数料コード</td><td align="center">{@link PKBM_RateNenkinPkisoV ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate00 nenkinkaisigopkisovrate00}</td><td>年金開始後Ｖレート００</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate01 nenkinkaisigopkisovrate01}</td><td>年金開始後Ｖレート０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate02 nenkinkaisigopkisovrate02}</td><td>年金開始後Ｖレート０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate03 nenkinkaisigopkisovrate03}</td><td>年金開始後Ｖレート０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate04 nenkinkaisigopkisovrate04}</td><td>年金開始後Ｖレート０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate05 nenkinkaisigopkisovrate05}</td><td>年金開始後Ｖレート０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate06 nenkinkaisigopkisovrate06}</td><td>年金開始後Ｖレート０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate07 nenkinkaisigopkisovrate07}</td><td>年金開始後Ｖレート０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate08 nenkinkaisigopkisovrate08}</td><td>年金開始後Ｖレート０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate09 nenkinkaisigopkisovrate09}</td><td>年金開始後Ｖレート０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate10 nenkinkaisigopkisovrate10}</td><td>年金開始後Ｖレート１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate11 nenkinkaisigopkisovrate11}</td><td>年金開始後Ｖレート１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate12 nenkinkaisigopkisovrate12}</td><td>年金開始後Ｖレート１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate13 nenkinkaisigopkisovrate13}</td><td>年金開始後Ｖレート１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate14 nenkinkaisigopkisovrate14}</td><td>年金開始後Ｖレート１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate15 nenkinkaisigopkisovrate15}</td><td>年金開始後Ｖレート１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate16 nenkinkaisigopkisovrate16}</td><td>年金開始後Ｖレート１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate17 nenkinkaisigopkisovrate17}</td><td>年金開始後Ｖレート１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate18 nenkinkaisigopkisovrate18}</td><td>年金開始後Ｖレート１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate19 nenkinkaisigopkisovrate19}</td><td>年金開始後Ｖレート１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate20 nenkinkaisigopkisovrate20}</td><td>年金開始後Ｖレート２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate21 nenkinkaisigopkisovrate21}</td><td>年金開始後Ｖレート２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate22 nenkinkaisigopkisovrate22}</td><td>年金開始後Ｖレート２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate23 nenkinkaisigopkisovrate23}</td><td>年金開始後Ｖレート２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate24 nenkinkaisigopkisovrate24}</td><td>年金開始後Ｖレート２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate25 nenkinkaisigopkisovrate25}</td><td>年金開始後Ｖレート２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate26 nenkinkaisigopkisovrate26}</td><td>年金開始後Ｖレート２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate27 nenkinkaisigopkisovrate27}</td><td>年金開始後Ｖレート２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate28 nenkinkaisigopkisovrate28}</td><td>年金開始後Ｖレート２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate29 nenkinkaisigopkisovrate29}</td><td>年金開始後Ｖレート２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate30 nenkinkaisigopkisovrate30}</td><td>年金開始後Ｖレート３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate31 nenkinkaisigopkisovrate31}</td><td>年金開始後Ｖレート３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate32 nenkinkaisigopkisovrate32}</td><td>年金開始後Ｖレート３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate33 nenkinkaisigopkisovrate33}</td><td>年金開始後Ｖレート３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate34 nenkinkaisigopkisovrate34}</td><td>年金開始後Ｖレート３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate35 nenkinkaisigopkisovrate35}</td><td>年金開始後Ｖレート３５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate36 nenkinkaisigopkisovrate36}</td><td>年金開始後Ｖレート３６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate37 nenkinkaisigopkisovrate37}</td><td>年金開始後Ｖレート３７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate38 nenkinkaisigopkisovrate38}</td><td>年金開始後Ｖレート３８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate39 nenkinkaisigopkisovrate39}</td><td>年金開始後Ｖレート３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate40 nenkinkaisigopkisovrate40}</td><td>年金開始後Ｖレート４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate41 nenkinkaisigopkisovrate41}</td><td>年金開始後Ｖレート４１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate42 nenkinkaisigopkisovrate42}</td><td>年金開始後Ｖレート４２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate43 nenkinkaisigopkisovrate43}</td><td>年金開始後Ｖレート４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate44 nenkinkaisigopkisovrate44}</td><td>年金開始後Ｖレート４４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate45 nenkinkaisigopkisovrate45}</td><td>年金開始後Ｖレート４５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate46 nenkinkaisigopkisovrate46}</td><td>年金開始後Ｖレート４６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate47 nenkinkaisigopkisovrate47}</td><td>年金開始後Ｖレート４７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate48 nenkinkaisigopkisovrate48}</td><td>年金開始後Ｖレート４８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate49 nenkinkaisigopkisovrate49}</td><td>年金開始後Ｖレート４９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate50 nenkinkaisigopkisovrate50}</td><td>年金開始後Ｖレート５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate51 nenkinkaisigopkisovrate51}</td><td>年金開始後Ｖレート５１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate52 nenkinkaisigopkisovrate52}</td><td>年金開始後Ｖレート５２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate53 nenkinkaisigopkisovrate53}</td><td>年金開始後Ｖレート５３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate54 nenkinkaisigopkisovrate54}</td><td>年金開始後Ｖレート５４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate55 nenkinkaisigopkisovrate55}</td><td>年金開始後Ｖレート５５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate56 nenkinkaisigopkisovrate56}</td><td>年金開始後Ｖレート５６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate57 nenkinkaisigopkisovrate57}</td><td>年金開始後Ｖレート５７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate58 nenkinkaisigopkisovrate58}</td><td>年金開始後Ｖレート５８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate59 nenkinkaisigopkisovrate59}</td><td>年金開始後Ｖレート５９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate60 nenkinkaisigopkisovrate60}</td><td>年金開始後Ｖレート６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate61 nenkinkaisigopkisovrate61}</td><td>年金開始後Ｖレート６１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate62 nenkinkaisigopkisovrate62}</td><td>年金開始後Ｖレート６２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate63 nenkinkaisigopkisovrate63}</td><td>年金開始後Ｖレート６３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate64 nenkinkaisigopkisovrate64}</td><td>年金開始後Ｖレート６４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate65 nenkinkaisigopkisovrate65}</td><td>年金開始後Ｖレート６５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate66 nenkinkaisigopkisovrate66}</td><td>年金開始後Ｖレート６６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate67 nenkinkaisigopkisovrate67}</td><td>年金開始後Ｖレート６７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate68 nenkinkaisigopkisovrate68}</td><td>年金開始後Ｖレート６８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate69 nenkinkaisigopkisovrate69}</td><td>年金開始後Ｖレート６９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate70 nenkinkaisigopkisovrate70}</td><td>年金開始後Ｖレート７０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate71 nenkinkaisigopkisovrate71}</td><td>年金開始後Ｖレート７１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate72 nenkinkaisigopkisovrate72}</td><td>年金開始後Ｖレート７２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate73 nenkinkaisigopkisovrate73}</td><td>年金開始後Ｖレート７３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate74 nenkinkaisigopkisovrate74}</td><td>年金開始後Ｖレート７４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate75 nenkinkaisigopkisovrate75}</td><td>年金開始後Ｖレート７５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate76 nenkinkaisigopkisovrate76}</td><td>年金開始後Ｖレート７６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate77 nenkinkaisigopkisovrate77}</td><td>年金開始後Ｖレート７７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate78 nenkinkaisigopkisovrate78}</td><td>年金開始後Ｖレート７８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate79 nenkinkaisigopkisovrate79}</td><td>年金開始後Ｖレート７９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate80 nenkinkaisigopkisovrate80}</td><td>年金開始後Ｖレート８０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate81 nenkinkaisigopkisovrate81}</td><td>年金開始後Ｖレート８１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate82 nenkinkaisigopkisovrate82}</td><td>年金開始後Ｖレート８２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate83 nenkinkaisigopkisovrate83}</td><td>年金開始後Ｖレート８３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate84 nenkinkaisigopkisovrate84}</td><td>年金開始後Ｖレート８４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate85 nenkinkaisigopkisovrate85}</td><td>年金開始後Ｖレート８５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate86 nenkinkaisigopkisovrate86}</td><td>年金開始後Ｖレート８６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate87 nenkinkaisigopkisovrate87}</td><td>年金開始後Ｖレート８７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate88 nenkinkaisigopkisovrate88}</td><td>年金開始後Ｖレート８８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate89 nenkinkaisigopkisovrate89}</td><td>年金開始後Ｖレート８９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate90 nenkinkaisigopkisovrate90}</td><td>年金開始後Ｖレート９０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate91 nenkinkaisigopkisovrate91}</td><td>年金開始後Ｖレート９１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate92 nenkinkaisigopkisovrate92}</td><td>年金開始後Ｖレート９２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate93 nenkinkaisigopkisovrate93}</td><td>年金開始後Ｖレート９３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate94 nenkinkaisigopkisovrate94}</td><td>年金開始後Ｖレート９４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate95 nenkinkaisigopkisovrate95}</td><td>年金開始後Ｖレート９５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate96 nenkinkaisigopkisovrate96}</td><td>年金開始後Ｖレート９６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate97 nenkinkaisigopkisovrate97}</td><td>年金開始後Ｖレート９７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate98 nenkinkaisigopkisovrate98}</td><td>年金開始後Ｖレート９８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getNenkinkaisigopkisovrate99 nenkinkaisigopkisovrate99}</td><td>年金開始後Ｖレート９９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     BM_RateNenkinPkisoV
 * @see     PKBM_RateNenkinPkisoV
 * @see     QBM_RateNenkinPkisoV
 * @see     GenQBM_RateNenkinPkisoV
 */
@MappedSuperclass
@Table(name=GenBM_RateNenkinPkisoV.TABLE_NAME)
@IdClass(value=PKBM_RateNenkinPkisoV.class)
public abstract class GenBM_RateNenkinPkisoV extends AbstractExDBEntity<BM_RateNenkinPkisoV, PKBM_RateNenkinPkisoV> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_RateNenkinPkisoV";
    public static final String PALNENKINSISUTEMUSYURUI  = "palnenkinsisutemusyurui";
    public static final String PALNENKINSYURUIKIGOU     = "palnenkinsyuruikigou";
    public static final String PALNENKINKIGOUSEDAICODE  = "palnenkinkigousedaicode";
    public static final String PALNENKINSIHARAIKIKAN    = "palnenkinsiharaikikan";
    public static final String PALNNKNKSGYOTEIRIRITUCODE = "palnnknksgyoteiriritucode";
    public static final String PALNNKNKSGJMTESUURYOUCODE = "palnnknksgjmtesuuryoucode";
    public static final String NENKINKAISIGOPKISOVRATE00 = "nenkinkaisigopkisovrate00";
    public static final String NENKINKAISIGOPKISOVRATE01 = "nenkinkaisigopkisovrate01";
    public static final String NENKINKAISIGOPKISOVRATE02 = "nenkinkaisigopkisovrate02";
    public static final String NENKINKAISIGOPKISOVRATE03 = "nenkinkaisigopkisovrate03";
    public static final String NENKINKAISIGOPKISOVRATE04 = "nenkinkaisigopkisovrate04";
    public static final String NENKINKAISIGOPKISOVRATE05 = "nenkinkaisigopkisovrate05";
    public static final String NENKINKAISIGOPKISOVRATE06 = "nenkinkaisigopkisovrate06";
    public static final String NENKINKAISIGOPKISOVRATE07 = "nenkinkaisigopkisovrate07";
    public static final String NENKINKAISIGOPKISOVRATE08 = "nenkinkaisigopkisovrate08";
    public static final String NENKINKAISIGOPKISOVRATE09 = "nenkinkaisigopkisovrate09";
    public static final String NENKINKAISIGOPKISOVRATE10 = "nenkinkaisigopkisovrate10";
    public static final String NENKINKAISIGOPKISOVRATE11 = "nenkinkaisigopkisovrate11";
    public static final String NENKINKAISIGOPKISOVRATE12 = "nenkinkaisigopkisovrate12";
    public static final String NENKINKAISIGOPKISOVRATE13 = "nenkinkaisigopkisovrate13";
    public static final String NENKINKAISIGOPKISOVRATE14 = "nenkinkaisigopkisovrate14";
    public static final String NENKINKAISIGOPKISOVRATE15 = "nenkinkaisigopkisovrate15";
    public static final String NENKINKAISIGOPKISOVRATE16 = "nenkinkaisigopkisovrate16";
    public static final String NENKINKAISIGOPKISOVRATE17 = "nenkinkaisigopkisovrate17";
    public static final String NENKINKAISIGOPKISOVRATE18 = "nenkinkaisigopkisovrate18";
    public static final String NENKINKAISIGOPKISOVRATE19 = "nenkinkaisigopkisovrate19";
    public static final String NENKINKAISIGOPKISOVRATE20 = "nenkinkaisigopkisovrate20";
    public static final String NENKINKAISIGOPKISOVRATE21 = "nenkinkaisigopkisovrate21";
    public static final String NENKINKAISIGOPKISOVRATE22 = "nenkinkaisigopkisovrate22";
    public static final String NENKINKAISIGOPKISOVRATE23 = "nenkinkaisigopkisovrate23";
    public static final String NENKINKAISIGOPKISOVRATE24 = "nenkinkaisigopkisovrate24";
    public static final String NENKINKAISIGOPKISOVRATE25 = "nenkinkaisigopkisovrate25";
    public static final String NENKINKAISIGOPKISOVRATE26 = "nenkinkaisigopkisovrate26";
    public static final String NENKINKAISIGOPKISOVRATE27 = "nenkinkaisigopkisovrate27";
    public static final String NENKINKAISIGOPKISOVRATE28 = "nenkinkaisigopkisovrate28";
    public static final String NENKINKAISIGOPKISOVRATE29 = "nenkinkaisigopkisovrate29";
    public static final String NENKINKAISIGOPKISOVRATE30 = "nenkinkaisigopkisovrate30";
    public static final String NENKINKAISIGOPKISOVRATE31 = "nenkinkaisigopkisovrate31";
    public static final String NENKINKAISIGOPKISOVRATE32 = "nenkinkaisigopkisovrate32";
    public static final String NENKINKAISIGOPKISOVRATE33 = "nenkinkaisigopkisovrate33";
    public static final String NENKINKAISIGOPKISOVRATE34 = "nenkinkaisigopkisovrate34";
    public static final String NENKINKAISIGOPKISOVRATE35 = "nenkinkaisigopkisovrate35";
    public static final String NENKINKAISIGOPKISOVRATE36 = "nenkinkaisigopkisovrate36";
    public static final String NENKINKAISIGOPKISOVRATE37 = "nenkinkaisigopkisovrate37";
    public static final String NENKINKAISIGOPKISOVRATE38 = "nenkinkaisigopkisovrate38";
    public static final String NENKINKAISIGOPKISOVRATE39 = "nenkinkaisigopkisovrate39";
    public static final String NENKINKAISIGOPKISOVRATE40 = "nenkinkaisigopkisovrate40";
    public static final String NENKINKAISIGOPKISOVRATE41 = "nenkinkaisigopkisovrate41";
    public static final String NENKINKAISIGOPKISOVRATE42 = "nenkinkaisigopkisovrate42";
    public static final String NENKINKAISIGOPKISOVRATE43 = "nenkinkaisigopkisovrate43";
    public static final String NENKINKAISIGOPKISOVRATE44 = "nenkinkaisigopkisovrate44";
    public static final String NENKINKAISIGOPKISOVRATE45 = "nenkinkaisigopkisovrate45";
    public static final String NENKINKAISIGOPKISOVRATE46 = "nenkinkaisigopkisovrate46";
    public static final String NENKINKAISIGOPKISOVRATE47 = "nenkinkaisigopkisovrate47";
    public static final String NENKINKAISIGOPKISOVRATE48 = "nenkinkaisigopkisovrate48";
    public static final String NENKINKAISIGOPKISOVRATE49 = "nenkinkaisigopkisovrate49";
    public static final String NENKINKAISIGOPKISOVRATE50 = "nenkinkaisigopkisovrate50";
    public static final String NENKINKAISIGOPKISOVRATE51 = "nenkinkaisigopkisovrate51";
    public static final String NENKINKAISIGOPKISOVRATE52 = "nenkinkaisigopkisovrate52";
    public static final String NENKINKAISIGOPKISOVRATE53 = "nenkinkaisigopkisovrate53";
    public static final String NENKINKAISIGOPKISOVRATE54 = "nenkinkaisigopkisovrate54";
    public static final String NENKINKAISIGOPKISOVRATE55 = "nenkinkaisigopkisovrate55";
    public static final String NENKINKAISIGOPKISOVRATE56 = "nenkinkaisigopkisovrate56";
    public static final String NENKINKAISIGOPKISOVRATE57 = "nenkinkaisigopkisovrate57";
    public static final String NENKINKAISIGOPKISOVRATE58 = "nenkinkaisigopkisovrate58";
    public static final String NENKINKAISIGOPKISOVRATE59 = "nenkinkaisigopkisovrate59";
    public static final String NENKINKAISIGOPKISOVRATE60 = "nenkinkaisigopkisovrate60";
    public static final String NENKINKAISIGOPKISOVRATE61 = "nenkinkaisigopkisovrate61";
    public static final String NENKINKAISIGOPKISOVRATE62 = "nenkinkaisigopkisovrate62";
    public static final String NENKINKAISIGOPKISOVRATE63 = "nenkinkaisigopkisovrate63";
    public static final String NENKINKAISIGOPKISOVRATE64 = "nenkinkaisigopkisovrate64";
    public static final String NENKINKAISIGOPKISOVRATE65 = "nenkinkaisigopkisovrate65";
    public static final String NENKINKAISIGOPKISOVRATE66 = "nenkinkaisigopkisovrate66";
    public static final String NENKINKAISIGOPKISOVRATE67 = "nenkinkaisigopkisovrate67";
    public static final String NENKINKAISIGOPKISOVRATE68 = "nenkinkaisigopkisovrate68";
    public static final String NENKINKAISIGOPKISOVRATE69 = "nenkinkaisigopkisovrate69";
    public static final String NENKINKAISIGOPKISOVRATE70 = "nenkinkaisigopkisovrate70";
    public static final String NENKINKAISIGOPKISOVRATE71 = "nenkinkaisigopkisovrate71";
    public static final String NENKINKAISIGOPKISOVRATE72 = "nenkinkaisigopkisovrate72";
    public static final String NENKINKAISIGOPKISOVRATE73 = "nenkinkaisigopkisovrate73";
    public static final String NENKINKAISIGOPKISOVRATE74 = "nenkinkaisigopkisovrate74";
    public static final String NENKINKAISIGOPKISOVRATE75 = "nenkinkaisigopkisovrate75";
    public static final String NENKINKAISIGOPKISOVRATE76 = "nenkinkaisigopkisovrate76";
    public static final String NENKINKAISIGOPKISOVRATE77 = "nenkinkaisigopkisovrate77";
    public static final String NENKINKAISIGOPKISOVRATE78 = "nenkinkaisigopkisovrate78";
    public static final String NENKINKAISIGOPKISOVRATE79 = "nenkinkaisigopkisovrate79";
    public static final String NENKINKAISIGOPKISOVRATE80 = "nenkinkaisigopkisovrate80";
    public static final String NENKINKAISIGOPKISOVRATE81 = "nenkinkaisigopkisovrate81";
    public static final String NENKINKAISIGOPKISOVRATE82 = "nenkinkaisigopkisovrate82";
    public static final String NENKINKAISIGOPKISOVRATE83 = "nenkinkaisigopkisovrate83";
    public static final String NENKINKAISIGOPKISOVRATE84 = "nenkinkaisigopkisovrate84";
    public static final String NENKINKAISIGOPKISOVRATE85 = "nenkinkaisigopkisovrate85";
    public static final String NENKINKAISIGOPKISOVRATE86 = "nenkinkaisigopkisovrate86";
    public static final String NENKINKAISIGOPKISOVRATE87 = "nenkinkaisigopkisovrate87";
    public static final String NENKINKAISIGOPKISOVRATE88 = "nenkinkaisigopkisovrate88";
    public static final String NENKINKAISIGOPKISOVRATE89 = "nenkinkaisigopkisovrate89";
    public static final String NENKINKAISIGOPKISOVRATE90 = "nenkinkaisigopkisovrate90";
    public static final String NENKINKAISIGOPKISOVRATE91 = "nenkinkaisigopkisovrate91";
    public static final String NENKINKAISIGOPKISOVRATE92 = "nenkinkaisigopkisovrate92";
    public static final String NENKINKAISIGOPKISOVRATE93 = "nenkinkaisigopkisovrate93";
    public static final String NENKINKAISIGOPKISOVRATE94 = "nenkinkaisigopkisovrate94";
    public static final String NENKINKAISIGOPKISOVRATE95 = "nenkinkaisigopkisovrate95";
    public static final String NENKINKAISIGOPKISOVRATE96 = "nenkinkaisigopkisovrate96";
    public static final String NENKINKAISIGOPKISOVRATE97 = "nenkinkaisigopkisovrate97";
    public static final String NENKINKAISIGOPKISOVRATE98 = "nenkinkaisigopkisovrate98";
    public static final String NENKINKAISIGOPKISOVRATE99 = "nenkinkaisigopkisovrate99";

    private final PKBM_RateNenkinPkisoV primaryKey;

    public GenBM_RateNenkinPkisoV() {
        primaryKey = new PKBM_RateNenkinPkisoV();
    }

    public GenBM_RateNenkinPkisoV(
        String pPalnenkinsisutemusyurui,
        String pPalnenkinsyuruikigou,
        String pPalnenkinkigousedaicode,
        String pPalnenkinsiharaikikan,
        String pPalnnknksgyoteiriritucode,
        String pPalnnknksgjmtesuuryoucode
    ) {
        primaryKey = new PKBM_RateNenkinPkisoV(
            pPalnenkinsisutemusyurui,
            pPalnenkinsyuruikigou,
            pPalnenkinkigousedaicode,
            pPalnenkinsiharaikikan,
            pPalnnknksgyoteiriritucode,
            pPalnnknksgjmtesuuryoucode
        );
    }

    @Transient
    @Override
    public PKBM_RateNenkinPkisoV getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_RateNenkinPkisoV> getMetaClass() {
        return QBM_RateNenkinPkisoV.class;
    }

    @Id
    @Column(name=GenBM_RateNenkinPkisoV.PALNENKINSISUTEMUSYURUI)
    public String getPalnenkinsisutemusyurui() {
        return getPrimaryKey().getPalnenkinsisutemusyurui();
    }

    public void setPalnenkinsisutemusyurui(String pPalnenkinsisutemusyurui) {
        getPrimaryKey().setPalnenkinsisutemusyurui(pPalnenkinsisutemusyurui);
    }

    @Id
    @Column(name=GenBM_RateNenkinPkisoV.PALNENKINSYURUIKIGOU)
    public String getPalnenkinsyuruikigou() {
        return getPrimaryKey().getPalnenkinsyuruikigou();
    }

    public void setPalnenkinsyuruikigou(String pPalnenkinsyuruikigou) {
        getPrimaryKey().setPalnenkinsyuruikigou(pPalnenkinsyuruikigou);
    }

    @Id
    @Column(name=GenBM_RateNenkinPkisoV.PALNENKINKIGOUSEDAICODE)
    public String getPalnenkinkigousedaicode() {
        return getPrimaryKey().getPalnenkinkigousedaicode();
    }

    public void setPalnenkinkigousedaicode(String pPalnenkinkigousedaicode) {
        getPrimaryKey().setPalnenkinkigousedaicode(pPalnenkinkigousedaicode);
    }

    @Id
    @Column(name=GenBM_RateNenkinPkisoV.PALNENKINSIHARAIKIKAN)
    public String getPalnenkinsiharaikikan() {
        return getPrimaryKey().getPalnenkinsiharaikikan();
    }

    public void setPalnenkinsiharaikikan(String pPalnenkinsiharaikikan) {
        getPrimaryKey().setPalnenkinsiharaikikan(pPalnenkinsiharaikikan);
    }

    @Id
    @Column(name=GenBM_RateNenkinPkisoV.PALNNKNKSGYOTEIRIRITUCODE)
    public String getPalnnknksgyoteiriritucode() {
        return getPrimaryKey().getPalnnknksgyoteiriritucode();
    }

    public void setPalnnknksgyoteiriritucode(String pPalnnknksgyoteiriritucode) {
        getPrimaryKey().setPalnnknksgyoteiriritucode(pPalnnknksgyoteiriritucode);
    }

    @Id
    @Column(name=GenBM_RateNenkinPkisoV.PALNNKNKSGJMTESUURYOUCODE)
    public String getPalnnknksgjmtesuuryoucode() {
        return getPrimaryKey().getPalnnknksgjmtesuuryoucode();
    }

    public void setPalnnknksgjmtesuuryoucode(String pPalnnknksgjmtesuuryoucode) {
        getPrimaryKey().setPalnnknksgjmtesuuryoucode(pPalnnknksgjmtesuuryoucode);
    }

    private String nenkinkaisigopkisovrate00;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE00)
    public String getNenkinkaisigopkisovrate00() {
        return nenkinkaisigopkisovrate00;
    }

    public void setNenkinkaisigopkisovrate00(String pNenkinkaisigopkisovrate00) {
        nenkinkaisigopkisovrate00 = pNenkinkaisigopkisovrate00;
    }

    private String nenkinkaisigopkisovrate01;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE01)
    public String getNenkinkaisigopkisovrate01() {
        return nenkinkaisigopkisovrate01;
    }

    public void setNenkinkaisigopkisovrate01(String pNenkinkaisigopkisovrate01) {
        nenkinkaisigopkisovrate01 = pNenkinkaisigopkisovrate01;
    }

    private String nenkinkaisigopkisovrate02;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE02)
    public String getNenkinkaisigopkisovrate02() {
        return nenkinkaisigopkisovrate02;
    }

    public void setNenkinkaisigopkisovrate02(String pNenkinkaisigopkisovrate02) {
        nenkinkaisigopkisovrate02 = pNenkinkaisigopkisovrate02;
    }

    private String nenkinkaisigopkisovrate03;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE03)
    public String getNenkinkaisigopkisovrate03() {
        return nenkinkaisigopkisovrate03;
    }

    public void setNenkinkaisigopkisovrate03(String pNenkinkaisigopkisovrate03) {
        nenkinkaisigopkisovrate03 = pNenkinkaisigopkisovrate03;
    }

    private String nenkinkaisigopkisovrate04;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE04)
    public String getNenkinkaisigopkisovrate04() {
        return nenkinkaisigopkisovrate04;
    }

    public void setNenkinkaisigopkisovrate04(String pNenkinkaisigopkisovrate04) {
        nenkinkaisigopkisovrate04 = pNenkinkaisigopkisovrate04;
    }

    private String nenkinkaisigopkisovrate05;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE05)
    public String getNenkinkaisigopkisovrate05() {
        return nenkinkaisigopkisovrate05;
    }

    public void setNenkinkaisigopkisovrate05(String pNenkinkaisigopkisovrate05) {
        nenkinkaisigopkisovrate05 = pNenkinkaisigopkisovrate05;
    }

    private String nenkinkaisigopkisovrate06;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE06)
    public String getNenkinkaisigopkisovrate06() {
        return nenkinkaisigopkisovrate06;
    }

    public void setNenkinkaisigopkisovrate06(String pNenkinkaisigopkisovrate06) {
        nenkinkaisigopkisovrate06 = pNenkinkaisigopkisovrate06;
    }

    private String nenkinkaisigopkisovrate07;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE07)
    public String getNenkinkaisigopkisovrate07() {
        return nenkinkaisigopkisovrate07;
    }

    public void setNenkinkaisigopkisovrate07(String pNenkinkaisigopkisovrate07) {
        nenkinkaisigopkisovrate07 = pNenkinkaisigopkisovrate07;
    }

    private String nenkinkaisigopkisovrate08;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE08)
    public String getNenkinkaisigopkisovrate08() {
        return nenkinkaisigopkisovrate08;
    }

    public void setNenkinkaisigopkisovrate08(String pNenkinkaisigopkisovrate08) {
        nenkinkaisigopkisovrate08 = pNenkinkaisigopkisovrate08;
    }

    private String nenkinkaisigopkisovrate09;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE09)
    public String getNenkinkaisigopkisovrate09() {
        return nenkinkaisigopkisovrate09;
    }

    public void setNenkinkaisigopkisovrate09(String pNenkinkaisigopkisovrate09) {
        nenkinkaisigopkisovrate09 = pNenkinkaisigopkisovrate09;
    }

    private String nenkinkaisigopkisovrate10;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE10)
    public String getNenkinkaisigopkisovrate10() {
        return nenkinkaisigopkisovrate10;
    }

    public void setNenkinkaisigopkisovrate10(String pNenkinkaisigopkisovrate10) {
        nenkinkaisigopkisovrate10 = pNenkinkaisigopkisovrate10;
    }

    private String nenkinkaisigopkisovrate11;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE11)
    public String getNenkinkaisigopkisovrate11() {
        return nenkinkaisigopkisovrate11;
    }

    public void setNenkinkaisigopkisovrate11(String pNenkinkaisigopkisovrate11) {
        nenkinkaisigopkisovrate11 = pNenkinkaisigopkisovrate11;
    }

    private String nenkinkaisigopkisovrate12;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE12)
    public String getNenkinkaisigopkisovrate12() {
        return nenkinkaisigopkisovrate12;
    }

    public void setNenkinkaisigopkisovrate12(String pNenkinkaisigopkisovrate12) {
        nenkinkaisigopkisovrate12 = pNenkinkaisigopkisovrate12;
    }

    private String nenkinkaisigopkisovrate13;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE13)
    public String getNenkinkaisigopkisovrate13() {
        return nenkinkaisigopkisovrate13;
    }

    public void setNenkinkaisigopkisovrate13(String pNenkinkaisigopkisovrate13) {
        nenkinkaisigopkisovrate13 = pNenkinkaisigopkisovrate13;
    }

    private String nenkinkaisigopkisovrate14;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE14)
    public String getNenkinkaisigopkisovrate14() {
        return nenkinkaisigopkisovrate14;
    }

    public void setNenkinkaisigopkisovrate14(String pNenkinkaisigopkisovrate14) {
        nenkinkaisigopkisovrate14 = pNenkinkaisigopkisovrate14;
    }

    private String nenkinkaisigopkisovrate15;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE15)
    public String getNenkinkaisigopkisovrate15() {
        return nenkinkaisigopkisovrate15;
    }

    public void setNenkinkaisigopkisovrate15(String pNenkinkaisigopkisovrate15) {
        nenkinkaisigopkisovrate15 = pNenkinkaisigopkisovrate15;
    }

    private String nenkinkaisigopkisovrate16;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE16)
    public String getNenkinkaisigopkisovrate16() {
        return nenkinkaisigopkisovrate16;
    }

    public void setNenkinkaisigopkisovrate16(String pNenkinkaisigopkisovrate16) {
        nenkinkaisigopkisovrate16 = pNenkinkaisigopkisovrate16;
    }

    private String nenkinkaisigopkisovrate17;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE17)
    public String getNenkinkaisigopkisovrate17() {
        return nenkinkaisigopkisovrate17;
    }

    public void setNenkinkaisigopkisovrate17(String pNenkinkaisigopkisovrate17) {
        nenkinkaisigopkisovrate17 = pNenkinkaisigopkisovrate17;
    }

    private String nenkinkaisigopkisovrate18;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE18)
    public String getNenkinkaisigopkisovrate18() {
        return nenkinkaisigopkisovrate18;
    }

    public void setNenkinkaisigopkisovrate18(String pNenkinkaisigopkisovrate18) {
        nenkinkaisigopkisovrate18 = pNenkinkaisigopkisovrate18;
    }

    private String nenkinkaisigopkisovrate19;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE19)
    public String getNenkinkaisigopkisovrate19() {
        return nenkinkaisigopkisovrate19;
    }

    public void setNenkinkaisigopkisovrate19(String pNenkinkaisigopkisovrate19) {
        nenkinkaisigopkisovrate19 = pNenkinkaisigopkisovrate19;
    }

    private String nenkinkaisigopkisovrate20;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE20)
    public String getNenkinkaisigopkisovrate20() {
        return nenkinkaisigopkisovrate20;
    }

    public void setNenkinkaisigopkisovrate20(String pNenkinkaisigopkisovrate20) {
        nenkinkaisigopkisovrate20 = pNenkinkaisigopkisovrate20;
    }

    private String nenkinkaisigopkisovrate21;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE21)
    public String getNenkinkaisigopkisovrate21() {
        return nenkinkaisigopkisovrate21;
    }

    public void setNenkinkaisigopkisovrate21(String pNenkinkaisigopkisovrate21) {
        nenkinkaisigopkisovrate21 = pNenkinkaisigopkisovrate21;
    }

    private String nenkinkaisigopkisovrate22;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE22)
    public String getNenkinkaisigopkisovrate22() {
        return nenkinkaisigopkisovrate22;
    }

    public void setNenkinkaisigopkisovrate22(String pNenkinkaisigopkisovrate22) {
        nenkinkaisigopkisovrate22 = pNenkinkaisigopkisovrate22;
    }

    private String nenkinkaisigopkisovrate23;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE23)
    public String getNenkinkaisigopkisovrate23() {
        return nenkinkaisigopkisovrate23;
    }

    public void setNenkinkaisigopkisovrate23(String pNenkinkaisigopkisovrate23) {
        nenkinkaisigopkisovrate23 = pNenkinkaisigopkisovrate23;
    }

    private String nenkinkaisigopkisovrate24;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE24)
    public String getNenkinkaisigopkisovrate24() {
        return nenkinkaisigopkisovrate24;
    }

    public void setNenkinkaisigopkisovrate24(String pNenkinkaisigopkisovrate24) {
        nenkinkaisigopkisovrate24 = pNenkinkaisigopkisovrate24;
    }

    private String nenkinkaisigopkisovrate25;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE25)
    public String getNenkinkaisigopkisovrate25() {
        return nenkinkaisigopkisovrate25;
    }

    public void setNenkinkaisigopkisovrate25(String pNenkinkaisigopkisovrate25) {
        nenkinkaisigopkisovrate25 = pNenkinkaisigopkisovrate25;
    }

    private String nenkinkaisigopkisovrate26;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE26)
    public String getNenkinkaisigopkisovrate26() {
        return nenkinkaisigopkisovrate26;
    }

    public void setNenkinkaisigopkisovrate26(String pNenkinkaisigopkisovrate26) {
        nenkinkaisigopkisovrate26 = pNenkinkaisigopkisovrate26;
    }

    private String nenkinkaisigopkisovrate27;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE27)
    public String getNenkinkaisigopkisovrate27() {
        return nenkinkaisigopkisovrate27;
    }

    public void setNenkinkaisigopkisovrate27(String pNenkinkaisigopkisovrate27) {
        nenkinkaisigopkisovrate27 = pNenkinkaisigopkisovrate27;
    }

    private String nenkinkaisigopkisovrate28;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE28)
    public String getNenkinkaisigopkisovrate28() {
        return nenkinkaisigopkisovrate28;
    }

    public void setNenkinkaisigopkisovrate28(String pNenkinkaisigopkisovrate28) {
        nenkinkaisigopkisovrate28 = pNenkinkaisigopkisovrate28;
    }

    private String nenkinkaisigopkisovrate29;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE29)
    public String getNenkinkaisigopkisovrate29() {
        return nenkinkaisigopkisovrate29;
    }

    public void setNenkinkaisigopkisovrate29(String pNenkinkaisigopkisovrate29) {
        nenkinkaisigopkisovrate29 = pNenkinkaisigopkisovrate29;
    }

    private String nenkinkaisigopkisovrate30;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE30)
    public String getNenkinkaisigopkisovrate30() {
        return nenkinkaisigopkisovrate30;
    }

    public void setNenkinkaisigopkisovrate30(String pNenkinkaisigopkisovrate30) {
        nenkinkaisigopkisovrate30 = pNenkinkaisigopkisovrate30;
    }

    private String nenkinkaisigopkisovrate31;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE31)
    public String getNenkinkaisigopkisovrate31() {
        return nenkinkaisigopkisovrate31;
    }

    public void setNenkinkaisigopkisovrate31(String pNenkinkaisigopkisovrate31) {
        nenkinkaisigopkisovrate31 = pNenkinkaisigopkisovrate31;
    }

    private String nenkinkaisigopkisovrate32;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE32)
    public String getNenkinkaisigopkisovrate32() {
        return nenkinkaisigopkisovrate32;
    }

    public void setNenkinkaisigopkisovrate32(String pNenkinkaisigopkisovrate32) {
        nenkinkaisigopkisovrate32 = pNenkinkaisigopkisovrate32;
    }

    private String nenkinkaisigopkisovrate33;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE33)
    public String getNenkinkaisigopkisovrate33() {
        return nenkinkaisigopkisovrate33;
    }

    public void setNenkinkaisigopkisovrate33(String pNenkinkaisigopkisovrate33) {
        nenkinkaisigopkisovrate33 = pNenkinkaisigopkisovrate33;
    }

    private String nenkinkaisigopkisovrate34;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE34)
    public String getNenkinkaisigopkisovrate34() {
        return nenkinkaisigopkisovrate34;
    }

    public void setNenkinkaisigopkisovrate34(String pNenkinkaisigopkisovrate34) {
        nenkinkaisigopkisovrate34 = pNenkinkaisigopkisovrate34;
    }

    private String nenkinkaisigopkisovrate35;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE35)
    public String getNenkinkaisigopkisovrate35() {
        return nenkinkaisigopkisovrate35;
    }

    public void setNenkinkaisigopkisovrate35(String pNenkinkaisigopkisovrate35) {
        nenkinkaisigopkisovrate35 = pNenkinkaisigopkisovrate35;
    }

    private String nenkinkaisigopkisovrate36;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE36)
    public String getNenkinkaisigopkisovrate36() {
        return nenkinkaisigopkisovrate36;
    }

    public void setNenkinkaisigopkisovrate36(String pNenkinkaisigopkisovrate36) {
        nenkinkaisigopkisovrate36 = pNenkinkaisigopkisovrate36;
    }

    private String nenkinkaisigopkisovrate37;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE37)
    public String getNenkinkaisigopkisovrate37() {
        return nenkinkaisigopkisovrate37;
    }

    public void setNenkinkaisigopkisovrate37(String pNenkinkaisigopkisovrate37) {
        nenkinkaisigopkisovrate37 = pNenkinkaisigopkisovrate37;
    }

    private String nenkinkaisigopkisovrate38;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE38)
    public String getNenkinkaisigopkisovrate38() {
        return nenkinkaisigopkisovrate38;
    }

    public void setNenkinkaisigopkisovrate38(String pNenkinkaisigopkisovrate38) {
        nenkinkaisigopkisovrate38 = pNenkinkaisigopkisovrate38;
    }

    private String nenkinkaisigopkisovrate39;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE39)
    public String getNenkinkaisigopkisovrate39() {
        return nenkinkaisigopkisovrate39;
    }

    public void setNenkinkaisigopkisovrate39(String pNenkinkaisigopkisovrate39) {
        nenkinkaisigopkisovrate39 = pNenkinkaisigopkisovrate39;
    }

    private String nenkinkaisigopkisovrate40;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE40)
    public String getNenkinkaisigopkisovrate40() {
        return nenkinkaisigopkisovrate40;
    }

    public void setNenkinkaisigopkisovrate40(String pNenkinkaisigopkisovrate40) {
        nenkinkaisigopkisovrate40 = pNenkinkaisigopkisovrate40;
    }

    private String nenkinkaisigopkisovrate41;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE41)
    public String getNenkinkaisigopkisovrate41() {
        return nenkinkaisigopkisovrate41;
    }

    public void setNenkinkaisigopkisovrate41(String pNenkinkaisigopkisovrate41) {
        nenkinkaisigopkisovrate41 = pNenkinkaisigopkisovrate41;
    }

    private String nenkinkaisigopkisovrate42;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE42)
    public String getNenkinkaisigopkisovrate42() {
        return nenkinkaisigopkisovrate42;
    }

    public void setNenkinkaisigopkisovrate42(String pNenkinkaisigopkisovrate42) {
        nenkinkaisigopkisovrate42 = pNenkinkaisigopkisovrate42;
    }

    private String nenkinkaisigopkisovrate43;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE43)
    public String getNenkinkaisigopkisovrate43() {
        return nenkinkaisigopkisovrate43;
    }

    public void setNenkinkaisigopkisovrate43(String pNenkinkaisigopkisovrate43) {
        nenkinkaisigopkisovrate43 = pNenkinkaisigopkisovrate43;
    }

    private String nenkinkaisigopkisovrate44;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE44)
    public String getNenkinkaisigopkisovrate44() {
        return nenkinkaisigopkisovrate44;
    }

    public void setNenkinkaisigopkisovrate44(String pNenkinkaisigopkisovrate44) {
        nenkinkaisigopkisovrate44 = pNenkinkaisigopkisovrate44;
    }

    private String nenkinkaisigopkisovrate45;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE45)
    public String getNenkinkaisigopkisovrate45() {
        return nenkinkaisigopkisovrate45;
    }

    public void setNenkinkaisigopkisovrate45(String pNenkinkaisigopkisovrate45) {
        nenkinkaisigopkisovrate45 = pNenkinkaisigopkisovrate45;
    }

    private String nenkinkaisigopkisovrate46;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE46)
    public String getNenkinkaisigopkisovrate46() {
        return nenkinkaisigopkisovrate46;
    }

    public void setNenkinkaisigopkisovrate46(String pNenkinkaisigopkisovrate46) {
        nenkinkaisigopkisovrate46 = pNenkinkaisigopkisovrate46;
    }

    private String nenkinkaisigopkisovrate47;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE47)
    public String getNenkinkaisigopkisovrate47() {
        return nenkinkaisigopkisovrate47;
    }

    public void setNenkinkaisigopkisovrate47(String pNenkinkaisigopkisovrate47) {
        nenkinkaisigopkisovrate47 = pNenkinkaisigopkisovrate47;
    }

    private String nenkinkaisigopkisovrate48;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE48)
    public String getNenkinkaisigopkisovrate48() {
        return nenkinkaisigopkisovrate48;
    }

    public void setNenkinkaisigopkisovrate48(String pNenkinkaisigopkisovrate48) {
        nenkinkaisigopkisovrate48 = pNenkinkaisigopkisovrate48;
    }

    private String nenkinkaisigopkisovrate49;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE49)
    public String getNenkinkaisigopkisovrate49() {
        return nenkinkaisigopkisovrate49;
    }

    public void setNenkinkaisigopkisovrate49(String pNenkinkaisigopkisovrate49) {
        nenkinkaisigopkisovrate49 = pNenkinkaisigopkisovrate49;
    }

    private String nenkinkaisigopkisovrate50;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE50)
    public String getNenkinkaisigopkisovrate50() {
        return nenkinkaisigopkisovrate50;
    }

    public void setNenkinkaisigopkisovrate50(String pNenkinkaisigopkisovrate50) {
        nenkinkaisigopkisovrate50 = pNenkinkaisigopkisovrate50;
    }

    private String nenkinkaisigopkisovrate51;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE51)
    public String getNenkinkaisigopkisovrate51() {
        return nenkinkaisigopkisovrate51;
    }

    public void setNenkinkaisigopkisovrate51(String pNenkinkaisigopkisovrate51) {
        nenkinkaisigopkisovrate51 = pNenkinkaisigopkisovrate51;
    }

    private String nenkinkaisigopkisovrate52;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE52)
    public String getNenkinkaisigopkisovrate52() {
        return nenkinkaisigopkisovrate52;
    }

    public void setNenkinkaisigopkisovrate52(String pNenkinkaisigopkisovrate52) {
        nenkinkaisigopkisovrate52 = pNenkinkaisigopkisovrate52;
    }

    private String nenkinkaisigopkisovrate53;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE53)
    public String getNenkinkaisigopkisovrate53() {
        return nenkinkaisigopkisovrate53;
    }

    public void setNenkinkaisigopkisovrate53(String pNenkinkaisigopkisovrate53) {
        nenkinkaisigopkisovrate53 = pNenkinkaisigopkisovrate53;
    }

    private String nenkinkaisigopkisovrate54;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE54)
    public String getNenkinkaisigopkisovrate54() {
        return nenkinkaisigopkisovrate54;
    }

    public void setNenkinkaisigopkisovrate54(String pNenkinkaisigopkisovrate54) {
        nenkinkaisigopkisovrate54 = pNenkinkaisigopkisovrate54;
    }

    private String nenkinkaisigopkisovrate55;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE55)
    public String getNenkinkaisigopkisovrate55() {
        return nenkinkaisigopkisovrate55;
    }

    public void setNenkinkaisigopkisovrate55(String pNenkinkaisigopkisovrate55) {
        nenkinkaisigopkisovrate55 = pNenkinkaisigopkisovrate55;
    }

    private String nenkinkaisigopkisovrate56;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE56)
    public String getNenkinkaisigopkisovrate56() {
        return nenkinkaisigopkisovrate56;
    }

    public void setNenkinkaisigopkisovrate56(String pNenkinkaisigopkisovrate56) {
        nenkinkaisigopkisovrate56 = pNenkinkaisigopkisovrate56;
    }

    private String nenkinkaisigopkisovrate57;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE57)
    public String getNenkinkaisigopkisovrate57() {
        return nenkinkaisigopkisovrate57;
    }

    public void setNenkinkaisigopkisovrate57(String pNenkinkaisigopkisovrate57) {
        nenkinkaisigopkisovrate57 = pNenkinkaisigopkisovrate57;
    }

    private String nenkinkaisigopkisovrate58;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE58)
    public String getNenkinkaisigopkisovrate58() {
        return nenkinkaisigopkisovrate58;
    }

    public void setNenkinkaisigopkisovrate58(String pNenkinkaisigopkisovrate58) {
        nenkinkaisigopkisovrate58 = pNenkinkaisigopkisovrate58;
    }

    private String nenkinkaisigopkisovrate59;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE59)
    public String getNenkinkaisigopkisovrate59() {
        return nenkinkaisigopkisovrate59;
    }

    public void setNenkinkaisigopkisovrate59(String pNenkinkaisigopkisovrate59) {
        nenkinkaisigopkisovrate59 = pNenkinkaisigopkisovrate59;
    }

    private String nenkinkaisigopkisovrate60;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE60)
    public String getNenkinkaisigopkisovrate60() {
        return nenkinkaisigopkisovrate60;
    }

    public void setNenkinkaisigopkisovrate60(String pNenkinkaisigopkisovrate60) {
        nenkinkaisigopkisovrate60 = pNenkinkaisigopkisovrate60;
    }

    private String nenkinkaisigopkisovrate61;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE61)
    public String getNenkinkaisigopkisovrate61() {
        return nenkinkaisigopkisovrate61;
    }

    public void setNenkinkaisigopkisovrate61(String pNenkinkaisigopkisovrate61) {
        nenkinkaisigopkisovrate61 = pNenkinkaisigopkisovrate61;
    }

    private String nenkinkaisigopkisovrate62;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE62)
    public String getNenkinkaisigopkisovrate62() {
        return nenkinkaisigopkisovrate62;
    }

    public void setNenkinkaisigopkisovrate62(String pNenkinkaisigopkisovrate62) {
        nenkinkaisigopkisovrate62 = pNenkinkaisigopkisovrate62;
    }

    private String nenkinkaisigopkisovrate63;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE63)
    public String getNenkinkaisigopkisovrate63() {
        return nenkinkaisigopkisovrate63;
    }

    public void setNenkinkaisigopkisovrate63(String pNenkinkaisigopkisovrate63) {
        nenkinkaisigopkisovrate63 = pNenkinkaisigopkisovrate63;
    }

    private String nenkinkaisigopkisovrate64;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE64)
    public String getNenkinkaisigopkisovrate64() {
        return nenkinkaisigopkisovrate64;
    }

    public void setNenkinkaisigopkisovrate64(String pNenkinkaisigopkisovrate64) {
        nenkinkaisigopkisovrate64 = pNenkinkaisigopkisovrate64;
    }

    private String nenkinkaisigopkisovrate65;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE65)
    public String getNenkinkaisigopkisovrate65() {
        return nenkinkaisigopkisovrate65;
    }

    public void setNenkinkaisigopkisovrate65(String pNenkinkaisigopkisovrate65) {
        nenkinkaisigopkisovrate65 = pNenkinkaisigopkisovrate65;
    }

    private String nenkinkaisigopkisovrate66;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE66)
    public String getNenkinkaisigopkisovrate66() {
        return nenkinkaisigopkisovrate66;
    }

    public void setNenkinkaisigopkisovrate66(String pNenkinkaisigopkisovrate66) {
        nenkinkaisigopkisovrate66 = pNenkinkaisigopkisovrate66;
    }

    private String nenkinkaisigopkisovrate67;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE67)
    public String getNenkinkaisigopkisovrate67() {
        return nenkinkaisigopkisovrate67;
    }

    public void setNenkinkaisigopkisovrate67(String pNenkinkaisigopkisovrate67) {
        nenkinkaisigopkisovrate67 = pNenkinkaisigopkisovrate67;
    }

    private String nenkinkaisigopkisovrate68;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE68)
    public String getNenkinkaisigopkisovrate68() {
        return nenkinkaisigopkisovrate68;
    }

    public void setNenkinkaisigopkisovrate68(String pNenkinkaisigopkisovrate68) {
        nenkinkaisigopkisovrate68 = pNenkinkaisigopkisovrate68;
    }

    private String nenkinkaisigopkisovrate69;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE69)
    public String getNenkinkaisigopkisovrate69() {
        return nenkinkaisigopkisovrate69;
    }

    public void setNenkinkaisigopkisovrate69(String pNenkinkaisigopkisovrate69) {
        nenkinkaisigopkisovrate69 = pNenkinkaisigopkisovrate69;
    }

    private String nenkinkaisigopkisovrate70;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE70)
    public String getNenkinkaisigopkisovrate70() {
        return nenkinkaisigopkisovrate70;
    }

    public void setNenkinkaisigopkisovrate70(String pNenkinkaisigopkisovrate70) {
        nenkinkaisigopkisovrate70 = pNenkinkaisigopkisovrate70;
    }

    private String nenkinkaisigopkisovrate71;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE71)
    public String getNenkinkaisigopkisovrate71() {
        return nenkinkaisigopkisovrate71;
    }

    public void setNenkinkaisigopkisovrate71(String pNenkinkaisigopkisovrate71) {
        nenkinkaisigopkisovrate71 = pNenkinkaisigopkisovrate71;
    }

    private String nenkinkaisigopkisovrate72;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE72)
    public String getNenkinkaisigopkisovrate72() {
        return nenkinkaisigopkisovrate72;
    }

    public void setNenkinkaisigopkisovrate72(String pNenkinkaisigopkisovrate72) {
        nenkinkaisigopkisovrate72 = pNenkinkaisigopkisovrate72;
    }

    private String nenkinkaisigopkisovrate73;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE73)
    public String getNenkinkaisigopkisovrate73() {
        return nenkinkaisigopkisovrate73;
    }

    public void setNenkinkaisigopkisovrate73(String pNenkinkaisigopkisovrate73) {
        nenkinkaisigopkisovrate73 = pNenkinkaisigopkisovrate73;
    }

    private String nenkinkaisigopkisovrate74;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE74)
    public String getNenkinkaisigopkisovrate74() {
        return nenkinkaisigopkisovrate74;
    }

    public void setNenkinkaisigopkisovrate74(String pNenkinkaisigopkisovrate74) {
        nenkinkaisigopkisovrate74 = pNenkinkaisigopkisovrate74;
    }

    private String nenkinkaisigopkisovrate75;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE75)
    public String getNenkinkaisigopkisovrate75() {
        return nenkinkaisigopkisovrate75;
    }

    public void setNenkinkaisigopkisovrate75(String pNenkinkaisigopkisovrate75) {
        nenkinkaisigopkisovrate75 = pNenkinkaisigopkisovrate75;
    }

    private String nenkinkaisigopkisovrate76;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE76)
    public String getNenkinkaisigopkisovrate76() {
        return nenkinkaisigopkisovrate76;
    }

    public void setNenkinkaisigopkisovrate76(String pNenkinkaisigopkisovrate76) {
        nenkinkaisigopkisovrate76 = pNenkinkaisigopkisovrate76;
    }

    private String nenkinkaisigopkisovrate77;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE77)
    public String getNenkinkaisigopkisovrate77() {
        return nenkinkaisigopkisovrate77;
    }

    public void setNenkinkaisigopkisovrate77(String pNenkinkaisigopkisovrate77) {
        nenkinkaisigopkisovrate77 = pNenkinkaisigopkisovrate77;
    }

    private String nenkinkaisigopkisovrate78;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE78)
    public String getNenkinkaisigopkisovrate78() {
        return nenkinkaisigopkisovrate78;
    }

    public void setNenkinkaisigopkisovrate78(String pNenkinkaisigopkisovrate78) {
        nenkinkaisigopkisovrate78 = pNenkinkaisigopkisovrate78;
    }

    private String nenkinkaisigopkisovrate79;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE79)
    public String getNenkinkaisigopkisovrate79() {
        return nenkinkaisigopkisovrate79;
    }

    public void setNenkinkaisigopkisovrate79(String pNenkinkaisigopkisovrate79) {
        nenkinkaisigopkisovrate79 = pNenkinkaisigopkisovrate79;
    }

    private String nenkinkaisigopkisovrate80;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE80)
    public String getNenkinkaisigopkisovrate80() {
        return nenkinkaisigopkisovrate80;
    }

    public void setNenkinkaisigopkisovrate80(String pNenkinkaisigopkisovrate80) {
        nenkinkaisigopkisovrate80 = pNenkinkaisigopkisovrate80;
    }

    private String nenkinkaisigopkisovrate81;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE81)
    public String getNenkinkaisigopkisovrate81() {
        return nenkinkaisigopkisovrate81;
    }

    public void setNenkinkaisigopkisovrate81(String pNenkinkaisigopkisovrate81) {
        nenkinkaisigopkisovrate81 = pNenkinkaisigopkisovrate81;
    }

    private String nenkinkaisigopkisovrate82;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE82)
    public String getNenkinkaisigopkisovrate82() {
        return nenkinkaisigopkisovrate82;
    }

    public void setNenkinkaisigopkisovrate82(String pNenkinkaisigopkisovrate82) {
        nenkinkaisigopkisovrate82 = pNenkinkaisigopkisovrate82;
    }

    private String nenkinkaisigopkisovrate83;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE83)
    public String getNenkinkaisigopkisovrate83() {
        return nenkinkaisigopkisovrate83;
    }

    public void setNenkinkaisigopkisovrate83(String pNenkinkaisigopkisovrate83) {
        nenkinkaisigopkisovrate83 = pNenkinkaisigopkisovrate83;
    }

    private String nenkinkaisigopkisovrate84;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE84)
    public String getNenkinkaisigopkisovrate84() {
        return nenkinkaisigopkisovrate84;
    }

    public void setNenkinkaisigopkisovrate84(String pNenkinkaisigopkisovrate84) {
        nenkinkaisigopkisovrate84 = pNenkinkaisigopkisovrate84;
    }

    private String nenkinkaisigopkisovrate85;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE85)
    public String getNenkinkaisigopkisovrate85() {
        return nenkinkaisigopkisovrate85;
    }

    public void setNenkinkaisigopkisovrate85(String pNenkinkaisigopkisovrate85) {
        nenkinkaisigopkisovrate85 = pNenkinkaisigopkisovrate85;
    }

    private String nenkinkaisigopkisovrate86;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE86)
    public String getNenkinkaisigopkisovrate86() {
        return nenkinkaisigopkisovrate86;
    }

    public void setNenkinkaisigopkisovrate86(String pNenkinkaisigopkisovrate86) {
        nenkinkaisigopkisovrate86 = pNenkinkaisigopkisovrate86;
    }

    private String nenkinkaisigopkisovrate87;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE87)
    public String getNenkinkaisigopkisovrate87() {
        return nenkinkaisigopkisovrate87;
    }

    public void setNenkinkaisigopkisovrate87(String pNenkinkaisigopkisovrate87) {
        nenkinkaisigopkisovrate87 = pNenkinkaisigopkisovrate87;
    }

    private String nenkinkaisigopkisovrate88;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE88)
    public String getNenkinkaisigopkisovrate88() {
        return nenkinkaisigopkisovrate88;
    }

    public void setNenkinkaisigopkisovrate88(String pNenkinkaisigopkisovrate88) {
        nenkinkaisigopkisovrate88 = pNenkinkaisigopkisovrate88;
    }

    private String nenkinkaisigopkisovrate89;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE89)
    public String getNenkinkaisigopkisovrate89() {
        return nenkinkaisigopkisovrate89;
    }

    public void setNenkinkaisigopkisovrate89(String pNenkinkaisigopkisovrate89) {
        nenkinkaisigopkisovrate89 = pNenkinkaisigopkisovrate89;
    }

    private String nenkinkaisigopkisovrate90;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE90)
    public String getNenkinkaisigopkisovrate90() {
        return nenkinkaisigopkisovrate90;
    }

    public void setNenkinkaisigopkisovrate90(String pNenkinkaisigopkisovrate90) {
        nenkinkaisigopkisovrate90 = pNenkinkaisigopkisovrate90;
    }

    private String nenkinkaisigopkisovrate91;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE91)
    public String getNenkinkaisigopkisovrate91() {
        return nenkinkaisigopkisovrate91;
    }

    public void setNenkinkaisigopkisovrate91(String pNenkinkaisigopkisovrate91) {
        nenkinkaisigopkisovrate91 = pNenkinkaisigopkisovrate91;
    }

    private String nenkinkaisigopkisovrate92;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE92)
    public String getNenkinkaisigopkisovrate92() {
        return nenkinkaisigopkisovrate92;
    }

    public void setNenkinkaisigopkisovrate92(String pNenkinkaisigopkisovrate92) {
        nenkinkaisigopkisovrate92 = pNenkinkaisigopkisovrate92;
    }

    private String nenkinkaisigopkisovrate93;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE93)
    public String getNenkinkaisigopkisovrate93() {
        return nenkinkaisigopkisovrate93;
    }

    public void setNenkinkaisigopkisovrate93(String pNenkinkaisigopkisovrate93) {
        nenkinkaisigopkisovrate93 = pNenkinkaisigopkisovrate93;
    }

    private String nenkinkaisigopkisovrate94;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE94)
    public String getNenkinkaisigopkisovrate94() {
        return nenkinkaisigopkisovrate94;
    }

    public void setNenkinkaisigopkisovrate94(String pNenkinkaisigopkisovrate94) {
        nenkinkaisigopkisovrate94 = pNenkinkaisigopkisovrate94;
    }

    private String nenkinkaisigopkisovrate95;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE95)
    public String getNenkinkaisigopkisovrate95() {
        return nenkinkaisigopkisovrate95;
    }

    public void setNenkinkaisigopkisovrate95(String pNenkinkaisigopkisovrate95) {
        nenkinkaisigopkisovrate95 = pNenkinkaisigopkisovrate95;
    }

    private String nenkinkaisigopkisovrate96;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE96)
    public String getNenkinkaisigopkisovrate96() {
        return nenkinkaisigopkisovrate96;
    }

    public void setNenkinkaisigopkisovrate96(String pNenkinkaisigopkisovrate96) {
        nenkinkaisigopkisovrate96 = pNenkinkaisigopkisovrate96;
    }

    private String nenkinkaisigopkisovrate97;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE97)
    public String getNenkinkaisigopkisovrate97() {
        return nenkinkaisigopkisovrate97;
    }

    public void setNenkinkaisigopkisovrate97(String pNenkinkaisigopkisovrate97) {
        nenkinkaisigopkisovrate97 = pNenkinkaisigopkisovrate97;
    }

    private String nenkinkaisigopkisovrate98;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE98)
    public String getNenkinkaisigopkisovrate98() {
        return nenkinkaisigopkisovrate98;
    }

    public void setNenkinkaisigopkisovrate98(String pNenkinkaisigopkisovrate98) {
        nenkinkaisigopkisovrate98 = pNenkinkaisigopkisovrate98;
    }

    private String nenkinkaisigopkisovrate99;

    @Column(name=GenBM_RateNenkinPkisoV.NENKINKAISIGOPKISOVRATE99)
    public String getNenkinkaisigopkisovrate99() {
        return nenkinkaisigopkisovrate99;
    }

    public void setNenkinkaisigopkisovrate99(String pNenkinkaisigopkisovrate99) {
        nenkinkaisigopkisovrate99 = pNenkinkaisigopkisovrate99;
    }
}
