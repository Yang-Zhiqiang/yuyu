package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_RatevRn;
import yuyu.def.db.id.PKZT_RatevRn;
import yuyu.def.db.meta.GenQZT_RatevRn;
import yuyu.def.db.meta.QZT_RatevRn;

/**
 * Ｖレートテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_RatevRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RatevRn}</td><td colspan="3">Ｖレートテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">{@link PKZT_RatevRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">{@link PKZT_RatevRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu zrnyoteiriritu}</td><td>（連携用）予定利率</td><td align="center">{@link PKZT_RatevRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbn zrnpmenkbn}</td><td>（連携用）Ｐ免区分</td><td align="center">{@link PKZT_RatevRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">{@link PKZT_RatevRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsei zrnhhknsei}</td><td>（連携用）被保険者性別</td><td align="center">{@link PKZT_RatevRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujihhknnen zrnkeiyakujihhknnen}</td><td>（連携用）契約時被保険者年令</td><td align="center">{@link PKZT_RatevRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">{@link PKZT_RatevRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">{@link PKZT_RatevRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">{@link PKZT_RatevRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvrate00 zrnvrate00}</td><td>（連携用）Ｖレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate01 zrnvrate01}</td><td>（連携用）Ｖレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate02 zrnvrate02}</td><td>（連携用）Ｖレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate03 zrnvrate03}</td><td>（連携用）Ｖレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate04 zrnvrate04}</td><td>（連携用）Ｖレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate05 zrnvrate05}</td><td>（連携用）Ｖレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate06 zrnvrate06}</td><td>（連携用）Ｖレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate07 zrnvrate07}</td><td>（連携用）Ｖレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate08 zrnvrate08}</td><td>（連携用）Ｖレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate09 zrnvrate09}</td><td>（連携用）Ｖレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate10 zrnvrate10}</td><td>（連携用）Ｖレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate11 zrnvrate11}</td><td>（連携用）Ｖレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate12 zrnvrate12}</td><td>（連携用）Ｖレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate13 zrnvrate13}</td><td>（連携用）Ｖレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate14 zrnvrate14}</td><td>（連携用）Ｖレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate15 zrnvrate15}</td><td>（連携用）Ｖレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate16 zrnvrate16}</td><td>（連携用）Ｖレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate17 zrnvrate17}</td><td>（連携用）Ｖレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate18 zrnvrate18}</td><td>（連携用）Ｖレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate19 zrnvrate19}</td><td>（連携用）Ｖレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate20 zrnvrate20}</td><td>（連携用）Ｖレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate21 zrnvrate21}</td><td>（連携用）Ｖレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate22 zrnvrate22}</td><td>（連携用）Ｖレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate23 zrnvrate23}</td><td>（連携用）Ｖレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate24 zrnvrate24}</td><td>（連携用）Ｖレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate25 zrnvrate25}</td><td>（連携用）Ｖレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate26 zrnvrate26}</td><td>（連携用）Ｖレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate27 zrnvrate27}</td><td>（連携用）Ｖレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate28 zrnvrate28}</td><td>（連携用）Ｖレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate29 zrnvrate29}</td><td>（連携用）Ｖレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate30 zrnvrate30}</td><td>（連携用）Ｖレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate31 zrnvrate31}</td><td>（連携用）Ｖレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate32 zrnvrate32}</td><td>（連携用）Ｖレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate33 zrnvrate33}</td><td>（連携用）Ｖレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate34 zrnvrate34}</td><td>（連携用）Ｖレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate35 zrnvrate35}</td><td>（連携用）Ｖレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate36 zrnvrate36}</td><td>（連携用）Ｖレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate37 zrnvrate37}</td><td>（連携用）Ｖレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate38 zrnvrate38}</td><td>（連携用）Ｖレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate39 zrnvrate39}</td><td>（連携用）Ｖレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate40 zrnvrate40}</td><td>（連携用）Ｖレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate41 zrnvrate41}</td><td>（連携用）Ｖレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate42 zrnvrate42}</td><td>（連携用）Ｖレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate43 zrnvrate43}</td><td>（連携用）Ｖレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate44 zrnvrate44}</td><td>（連携用）Ｖレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate45 zrnvrate45}</td><td>（連携用）Ｖレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate46 zrnvrate46}</td><td>（連携用）Ｖレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate47 zrnvrate47}</td><td>（連携用）Ｖレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate48 zrnvrate48}</td><td>（連携用）Ｖレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate49 zrnvrate49}</td><td>（連携用）Ｖレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate50 zrnvrate50}</td><td>（連携用）Ｖレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate51 zrnvrate51}</td><td>（連携用）Ｖレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate52 zrnvrate52}</td><td>（連携用）Ｖレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate53 zrnvrate53}</td><td>（連携用）Ｖレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate54 zrnvrate54}</td><td>（連携用）Ｖレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate55 zrnvrate55}</td><td>（連携用）Ｖレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate56 zrnvrate56}</td><td>（連携用）Ｖレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate57 zrnvrate57}</td><td>（連携用）Ｖレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate58 zrnvrate58}</td><td>（連携用）Ｖレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate59 zrnvrate59}</td><td>（連携用）Ｖレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate60 zrnvrate60}</td><td>（連携用）Ｖレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate61 zrnvrate61}</td><td>（連携用）Ｖレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate62 zrnvrate62}</td><td>（連携用）Ｖレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate63 zrnvrate63}</td><td>（連携用）Ｖレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate64 zrnvrate64}</td><td>（連携用）Ｖレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate65 zrnvrate65}</td><td>（連携用）Ｖレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate66 zrnvrate66}</td><td>（連携用）Ｖレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate67 zrnvrate67}</td><td>（連携用）Ｖレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate68 zrnvrate68}</td><td>（連携用）Ｖレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate69 zrnvrate69}</td><td>（連携用）Ｖレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate70 zrnvrate70}</td><td>（連携用）Ｖレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate71 zrnvrate71}</td><td>（連携用）Ｖレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate72 zrnvrate72}</td><td>（連携用）Ｖレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate73 zrnvrate73}</td><td>（連携用）Ｖレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate74 zrnvrate74}</td><td>（連携用）Ｖレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate75 zrnvrate75}</td><td>（連携用）Ｖレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate76 zrnvrate76}</td><td>（連携用）Ｖレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate77 zrnvrate77}</td><td>（連携用）Ｖレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate78 zrnvrate78}</td><td>（連携用）Ｖレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate79 zrnvrate79}</td><td>（連携用）Ｖレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate80 zrnvrate80}</td><td>（連携用）Ｖレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate81 zrnvrate81}</td><td>（連携用）Ｖレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate82 zrnvrate82}</td><td>（連携用）Ｖレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate83 zrnvrate83}</td><td>（連携用）Ｖレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate84 zrnvrate84}</td><td>（連携用）Ｖレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate85 zrnvrate85}</td><td>（連携用）Ｖレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate86 zrnvrate86}</td><td>（連携用）Ｖレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate87 zrnvrate87}</td><td>（連携用）Ｖレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate88 zrnvrate88}</td><td>（連携用）Ｖレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate89 zrnvrate89}</td><td>（連携用）Ｖレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate90 zrnvrate90}</td><td>（連携用）Ｖレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate91 zrnvrate91}</td><td>（連携用）Ｖレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate92 zrnvrate92}</td><td>（連携用）Ｖレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate93 zrnvrate93}</td><td>（連携用）Ｖレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate94 zrnvrate94}</td><td>（連携用）Ｖレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate95 zrnvrate95}</td><td>（連携用）Ｖレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate96 zrnvrate96}</td><td>（連携用）Ｖレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate97 zrnvrate97}</td><td>（連携用）Ｖレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate98 zrnvrate98}</td><td>（連携用）Ｖレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnvrate99 zrnvrate99}</td><td>（連携用）Ｖレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_RatevRn
 * @see     PKZT_RatevRn
 * @see     QZT_RatevRn
 * @see     GenQZT_RatevRn
 */
@MappedSuperclass
@Table(name=GenZT_RatevRn.TABLE_NAME)
@IdClass(value=PKZT_RatevRn.class)
public abstract class GenZT_RatevRn extends AbstractExDBEntityForZDB<ZT_RatevRn, PKZT_RatevRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RatevRn";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNYOTEIRIRITU           = "zrnyoteiriritu";
    public static final String ZRNPMENKBN               = "zrnpmenkbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHHKNSEI               = "zrnhhknsei";
    public static final String ZRNKEIYAKUJIHHKNNEN      = "zrnkeiyakujihhknnen";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNVRATE00               = "zrnvrate00";
    public static final String ZRNVRATE01               = "zrnvrate01";
    public static final String ZRNVRATE02               = "zrnvrate02";
    public static final String ZRNVRATE03               = "zrnvrate03";
    public static final String ZRNVRATE04               = "zrnvrate04";
    public static final String ZRNVRATE05               = "zrnvrate05";
    public static final String ZRNVRATE06               = "zrnvrate06";
    public static final String ZRNVRATE07               = "zrnvrate07";
    public static final String ZRNVRATE08               = "zrnvrate08";
    public static final String ZRNVRATE09               = "zrnvrate09";
    public static final String ZRNVRATE10               = "zrnvrate10";
    public static final String ZRNVRATE11               = "zrnvrate11";
    public static final String ZRNVRATE12               = "zrnvrate12";
    public static final String ZRNVRATE13               = "zrnvrate13";
    public static final String ZRNVRATE14               = "zrnvrate14";
    public static final String ZRNVRATE15               = "zrnvrate15";
    public static final String ZRNVRATE16               = "zrnvrate16";
    public static final String ZRNVRATE17               = "zrnvrate17";
    public static final String ZRNVRATE18               = "zrnvrate18";
    public static final String ZRNVRATE19               = "zrnvrate19";
    public static final String ZRNVRATE20               = "zrnvrate20";
    public static final String ZRNVRATE21               = "zrnvrate21";
    public static final String ZRNVRATE22               = "zrnvrate22";
    public static final String ZRNVRATE23               = "zrnvrate23";
    public static final String ZRNVRATE24               = "zrnvrate24";
    public static final String ZRNVRATE25               = "zrnvrate25";
    public static final String ZRNVRATE26               = "zrnvrate26";
    public static final String ZRNVRATE27               = "zrnvrate27";
    public static final String ZRNVRATE28               = "zrnvrate28";
    public static final String ZRNVRATE29               = "zrnvrate29";
    public static final String ZRNVRATE30               = "zrnvrate30";
    public static final String ZRNVRATE31               = "zrnvrate31";
    public static final String ZRNVRATE32               = "zrnvrate32";
    public static final String ZRNVRATE33               = "zrnvrate33";
    public static final String ZRNVRATE34               = "zrnvrate34";
    public static final String ZRNVRATE35               = "zrnvrate35";
    public static final String ZRNVRATE36               = "zrnvrate36";
    public static final String ZRNVRATE37               = "zrnvrate37";
    public static final String ZRNVRATE38               = "zrnvrate38";
    public static final String ZRNVRATE39               = "zrnvrate39";
    public static final String ZRNVRATE40               = "zrnvrate40";
    public static final String ZRNVRATE41               = "zrnvrate41";
    public static final String ZRNVRATE42               = "zrnvrate42";
    public static final String ZRNVRATE43               = "zrnvrate43";
    public static final String ZRNVRATE44               = "zrnvrate44";
    public static final String ZRNVRATE45               = "zrnvrate45";
    public static final String ZRNVRATE46               = "zrnvrate46";
    public static final String ZRNVRATE47               = "zrnvrate47";
    public static final String ZRNVRATE48               = "zrnvrate48";
    public static final String ZRNVRATE49               = "zrnvrate49";
    public static final String ZRNVRATE50               = "zrnvrate50";
    public static final String ZRNVRATE51               = "zrnvrate51";
    public static final String ZRNVRATE52               = "zrnvrate52";
    public static final String ZRNVRATE53               = "zrnvrate53";
    public static final String ZRNVRATE54               = "zrnvrate54";
    public static final String ZRNVRATE55               = "zrnvrate55";
    public static final String ZRNVRATE56               = "zrnvrate56";
    public static final String ZRNVRATE57               = "zrnvrate57";
    public static final String ZRNVRATE58               = "zrnvrate58";
    public static final String ZRNVRATE59               = "zrnvrate59";
    public static final String ZRNVRATE60               = "zrnvrate60";
    public static final String ZRNVRATE61               = "zrnvrate61";
    public static final String ZRNVRATE62               = "zrnvrate62";
    public static final String ZRNVRATE63               = "zrnvrate63";
    public static final String ZRNVRATE64               = "zrnvrate64";
    public static final String ZRNVRATE65               = "zrnvrate65";
    public static final String ZRNVRATE66               = "zrnvrate66";
    public static final String ZRNVRATE67               = "zrnvrate67";
    public static final String ZRNVRATE68               = "zrnvrate68";
    public static final String ZRNVRATE69               = "zrnvrate69";
    public static final String ZRNVRATE70               = "zrnvrate70";
    public static final String ZRNVRATE71               = "zrnvrate71";
    public static final String ZRNVRATE72               = "zrnvrate72";
    public static final String ZRNVRATE73               = "zrnvrate73";
    public static final String ZRNVRATE74               = "zrnvrate74";
    public static final String ZRNVRATE75               = "zrnvrate75";
    public static final String ZRNVRATE76               = "zrnvrate76";
    public static final String ZRNVRATE77               = "zrnvrate77";
    public static final String ZRNVRATE78               = "zrnvrate78";
    public static final String ZRNVRATE79               = "zrnvrate79";
    public static final String ZRNVRATE80               = "zrnvrate80";
    public static final String ZRNVRATE81               = "zrnvrate81";
    public static final String ZRNVRATE82               = "zrnvrate82";
    public static final String ZRNVRATE83               = "zrnvrate83";
    public static final String ZRNVRATE84               = "zrnvrate84";
    public static final String ZRNVRATE85               = "zrnvrate85";
    public static final String ZRNVRATE86               = "zrnvrate86";
    public static final String ZRNVRATE87               = "zrnvrate87";
    public static final String ZRNVRATE88               = "zrnvrate88";
    public static final String ZRNVRATE89               = "zrnvrate89";
    public static final String ZRNVRATE90               = "zrnvrate90";
    public static final String ZRNVRATE91               = "zrnvrate91";
    public static final String ZRNVRATE92               = "zrnvrate92";
    public static final String ZRNVRATE93               = "zrnvrate93";
    public static final String ZRNVRATE94               = "zrnvrate94";
    public static final String ZRNVRATE95               = "zrnvrate95";
    public static final String ZRNVRATE96               = "zrnvrate96";
    public static final String ZRNVRATE97               = "zrnvrate97";
    public static final String ZRNVRATE98               = "zrnvrate98";
    public static final String ZRNVRATE99               = "zrnvrate99";

    private final PKZT_RatevRn primaryKey;

    public GenZT_RatevRn() {
        primaryKey = new PKZT_RatevRn();
    }

    public GenZT_RatevRn(
        String pZrnhknsyukigou,
        String pZrnhknsyuruikigousedaikbn,
        String pZrnyoteiriritu,
        String pZrnpmenkbn,
        String pZrnhrkkaisuukbn,
        String pZrnhhknsei,
        String pZrnkeiyakujihhknnen,
        String pZrnsaimnkkykhyj,
        String pZrnhknkkn,
        String pZrnphrkkikn
    ) {
        primaryKey = new PKZT_RatevRn(
            pZrnhknsyukigou,
            pZrnhknsyuruikigousedaikbn,
            pZrnyoteiriritu,
            pZrnpmenkbn,
            pZrnhrkkaisuukbn,
            pZrnhhknsei,
            pZrnkeiyakujihhknnen,
            pZrnsaimnkkykhyj,
            pZrnhknkkn,
            pZrnphrkkikn
        );
    }

    @Transient
    @Override
    public PKZT_RatevRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RatevRn> getMetaClass() {
        return QZT_RatevRn.class;
    }

    @Id
    @Column(name=GenZT_RatevRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return getPrimaryKey().getZrnhknsyukigou();
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        getPrimaryKey().setZrnhknsyukigou(pZrnhknsyukigou);
    }

    @Id
    @Column(name=GenZT_RatevRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return getPrimaryKey().getZrnhknsyuruikigousedaikbn();
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        getPrimaryKey().setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
    }

    @Id
    @Column(name=GenZT_RatevRn.ZRNYOTEIRIRITU)
    public String getZrnyoteiriritu() {
        return getPrimaryKey().getZrnyoteiriritu();
    }

    public void setZrnyoteiriritu(String pZrnyoteiriritu) {
        getPrimaryKey().setZrnyoteiriritu(pZrnyoteiriritu);
    }

    @Id
    @Column(name=GenZT_RatevRn.ZRNPMENKBN)
    public String getZrnpmenkbn() {
        return getPrimaryKey().getZrnpmenkbn();
    }

    public void setZrnpmenkbn(String pZrnpmenkbn) {
        getPrimaryKey().setZrnpmenkbn(pZrnpmenkbn);
    }

    @Id
    @Column(name=GenZT_RatevRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return getPrimaryKey().getZrnhrkkaisuukbn();
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        getPrimaryKey().setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
    }

    @Id
    @Column(name=GenZT_RatevRn.ZRNHHKNSEI)
    public String getZrnhhknsei() {
        return getPrimaryKey().getZrnhhknsei();
    }

    public void setZrnhhknsei(String pZrnhhknsei) {
        getPrimaryKey().setZrnhhknsei(pZrnhhknsei);
    }

    @Id
    @Column(name=GenZT_RatevRn.ZRNKEIYAKUJIHHKNNEN)
    public String getZrnkeiyakujihhknnen() {
        return getPrimaryKey().getZrnkeiyakujihhknnen();
    }

    public void setZrnkeiyakujihhknnen(String pZrnkeiyakujihhknnen) {
        getPrimaryKey().setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
    }

    @Id
    @Column(name=GenZT_RatevRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return getPrimaryKey().getZrnsaimnkkykhyj();
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        getPrimaryKey().setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
    }

    @Id
    @Column(name=GenZT_RatevRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return getPrimaryKey().getZrnhknkkn();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        getPrimaryKey().setZrnhknkkn(pZrnhknkkn);
    }

    @Id
    @Column(name=GenZT_RatevRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return getPrimaryKey().getZrnphrkkikn();
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        getPrimaryKey().setZrnphrkkikn(pZrnphrkkikn);
    }

    private Double zrnvrate00;

    @Column(name=GenZT_RatevRn.ZRNVRATE00)
    public Double getZrnvrate00() {
        return zrnvrate00;
    }

    public void setZrnvrate00(Double pZrnvrate00) {
        zrnvrate00 = pZrnvrate00;
    }

    private Double zrnvrate01;

    @Column(name=GenZT_RatevRn.ZRNVRATE01)
    public Double getZrnvrate01() {
        return zrnvrate01;
    }

    public void setZrnvrate01(Double pZrnvrate01) {
        zrnvrate01 = pZrnvrate01;
    }

    private Double zrnvrate02;

    @Column(name=GenZT_RatevRn.ZRNVRATE02)
    public Double getZrnvrate02() {
        return zrnvrate02;
    }

    public void setZrnvrate02(Double pZrnvrate02) {
        zrnvrate02 = pZrnvrate02;
    }

    private Double zrnvrate03;

    @Column(name=GenZT_RatevRn.ZRNVRATE03)
    public Double getZrnvrate03() {
        return zrnvrate03;
    }

    public void setZrnvrate03(Double pZrnvrate03) {
        zrnvrate03 = pZrnvrate03;
    }

    private Double zrnvrate04;

    @Column(name=GenZT_RatevRn.ZRNVRATE04)
    public Double getZrnvrate04() {
        return zrnvrate04;
    }

    public void setZrnvrate04(Double pZrnvrate04) {
        zrnvrate04 = pZrnvrate04;
    }

    private Double zrnvrate05;

    @Column(name=GenZT_RatevRn.ZRNVRATE05)
    public Double getZrnvrate05() {
        return zrnvrate05;
    }

    public void setZrnvrate05(Double pZrnvrate05) {
        zrnvrate05 = pZrnvrate05;
    }

    private Double zrnvrate06;

    @Column(name=GenZT_RatevRn.ZRNVRATE06)
    public Double getZrnvrate06() {
        return zrnvrate06;
    }

    public void setZrnvrate06(Double pZrnvrate06) {
        zrnvrate06 = pZrnvrate06;
    }

    private Double zrnvrate07;

    @Column(name=GenZT_RatevRn.ZRNVRATE07)
    public Double getZrnvrate07() {
        return zrnvrate07;
    }

    public void setZrnvrate07(Double pZrnvrate07) {
        zrnvrate07 = pZrnvrate07;
    }

    private Double zrnvrate08;

    @Column(name=GenZT_RatevRn.ZRNVRATE08)
    public Double getZrnvrate08() {
        return zrnvrate08;
    }

    public void setZrnvrate08(Double pZrnvrate08) {
        zrnvrate08 = pZrnvrate08;
    }

    private Double zrnvrate09;

    @Column(name=GenZT_RatevRn.ZRNVRATE09)
    public Double getZrnvrate09() {
        return zrnvrate09;
    }

    public void setZrnvrate09(Double pZrnvrate09) {
        zrnvrate09 = pZrnvrate09;
    }

    private Double zrnvrate10;

    @Column(name=GenZT_RatevRn.ZRNVRATE10)
    public Double getZrnvrate10() {
        return zrnvrate10;
    }

    public void setZrnvrate10(Double pZrnvrate10) {
        zrnvrate10 = pZrnvrate10;
    }

    private Double zrnvrate11;

    @Column(name=GenZT_RatevRn.ZRNVRATE11)
    public Double getZrnvrate11() {
        return zrnvrate11;
    }

    public void setZrnvrate11(Double pZrnvrate11) {
        zrnvrate11 = pZrnvrate11;
    }

    private Double zrnvrate12;

    @Column(name=GenZT_RatevRn.ZRNVRATE12)
    public Double getZrnvrate12() {
        return zrnvrate12;
    }

    public void setZrnvrate12(Double pZrnvrate12) {
        zrnvrate12 = pZrnvrate12;
    }

    private Double zrnvrate13;

    @Column(name=GenZT_RatevRn.ZRNVRATE13)
    public Double getZrnvrate13() {
        return zrnvrate13;
    }

    public void setZrnvrate13(Double pZrnvrate13) {
        zrnvrate13 = pZrnvrate13;
    }

    private Double zrnvrate14;

    @Column(name=GenZT_RatevRn.ZRNVRATE14)
    public Double getZrnvrate14() {
        return zrnvrate14;
    }

    public void setZrnvrate14(Double pZrnvrate14) {
        zrnvrate14 = pZrnvrate14;
    }

    private Double zrnvrate15;

    @Column(name=GenZT_RatevRn.ZRNVRATE15)
    public Double getZrnvrate15() {
        return zrnvrate15;
    }

    public void setZrnvrate15(Double pZrnvrate15) {
        zrnvrate15 = pZrnvrate15;
    }

    private Double zrnvrate16;

    @Column(name=GenZT_RatevRn.ZRNVRATE16)
    public Double getZrnvrate16() {
        return zrnvrate16;
    }

    public void setZrnvrate16(Double pZrnvrate16) {
        zrnvrate16 = pZrnvrate16;
    }

    private Double zrnvrate17;

    @Column(name=GenZT_RatevRn.ZRNVRATE17)
    public Double getZrnvrate17() {
        return zrnvrate17;
    }

    public void setZrnvrate17(Double pZrnvrate17) {
        zrnvrate17 = pZrnvrate17;
    }

    private Double zrnvrate18;

    @Column(name=GenZT_RatevRn.ZRNVRATE18)
    public Double getZrnvrate18() {
        return zrnvrate18;
    }

    public void setZrnvrate18(Double pZrnvrate18) {
        zrnvrate18 = pZrnvrate18;
    }

    private Double zrnvrate19;

    @Column(name=GenZT_RatevRn.ZRNVRATE19)
    public Double getZrnvrate19() {
        return zrnvrate19;
    }

    public void setZrnvrate19(Double pZrnvrate19) {
        zrnvrate19 = pZrnvrate19;
    }

    private Double zrnvrate20;

    @Column(name=GenZT_RatevRn.ZRNVRATE20)
    public Double getZrnvrate20() {
        return zrnvrate20;
    }

    public void setZrnvrate20(Double pZrnvrate20) {
        zrnvrate20 = pZrnvrate20;
    }

    private Double zrnvrate21;

    @Column(name=GenZT_RatevRn.ZRNVRATE21)
    public Double getZrnvrate21() {
        return zrnvrate21;
    }

    public void setZrnvrate21(Double pZrnvrate21) {
        zrnvrate21 = pZrnvrate21;
    }

    private Double zrnvrate22;

    @Column(name=GenZT_RatevRn.ZRNVRATE22)
    public Double getZrnvrate22() {
        return zrnvrate22;
    }

    public void setZrnvrate22(Double pZrnvrate22) {
        zrnvrate22 = pZrnvrate22;
    }

    private Double zrnvrate23;

    @Column(name=GenZT_RatevRn.ZRNVRATE23)
    public Double getZrnvrate23() {
        return zrnvrate23;
    }

    public void setZrnvrate23(Double pZrnvrate23) {
        zrnvrate23 = pZrnvrate23;
    }

    private Double zrnvrate24;

    @Column(name=GenZT_RatevRn.ZRNVRATE24)
    public Double getZrnvrate24() {
        return zrnvrate24;
    }

    public void setZrnvrate24(Double pZrnvrate24) {
        zrnvrate24 = pZrnvrate24;
    }

    private Double zrnvrate25;

    @Column(name=GenZT_RatevRn.ZRNVRATE25)
    public Double getZrnvrate25() {
        return zrnvrate25;
    }

    public void setZrnvrate25(Double pZrnvrate25) {
        zrnvrate25 = pZrnvrate25;
    }

    private Double zrnvrate26;

    @Column(name=GenZT_RatevRn.ZRNVRATE26)
    public Double getZrnvrate26() {
        return zrnvrate26;
    }

    public void setZrnvrate26(Double pZrnvrate26) {
        zrnvrate26 = pZrnvrate26;
    }

    private Double zrnvrate27;

    @Column(name=GenZT_RatevRn.ZRNVRATE27)
    public Double getZrnvrate27() {
        return zrnvrate27;
    }

    public void setZrnvrate27(Double pZrnvrate27) {
        zrnvrate27 = pZrnvrate27;
    }

    private Double zrnvrate28;

    @Column(name=GenZT_RatevRn.ZRNVRATE28)
    public Double getZrnvrate28() {
        return zrnvrate28;
    }

    public void setZrnvrate28(Double pZrnvrate28) {
        zrnvrate28 = pZrnvrate28;
    }

    private Double zrnvrate29;

    @Column(name=GenZT_RatevRn.ZRNVRATE29)
    public Double getZrnvrate29() {
        return zrnvrate29;
    }

    public void setZrnvrate29(Double pZrnvrate29) {
        zrnvrate29 = pZrnvrate29;
    }

    private Double zrnvrate30;

    @Column(name=GenZT_RatevRn.ZRNVRATE30)
    public Double getZrnvrate30() {
        return zrnvrate30;
    }

    public void setZrnvrate30(Double pZrnvrate30) {
        zrnvrate30 = pZrnvrate30;
    }

    private Double zrnvrate31;

    @Column(name=GenZT_RatevRn.ZRNVRATE31)
    public Double getZrnvrate31() {
        return zrnvrate31;
    }

    public void setZrnvrate31(Double pZrnvrate31) {
        zrnvrate31 = pZrnvrate31;
    }

    private Double zrnvrate32;

    @Column(name=GenZT_RatevRn.ZRNVRATE32)
    public Double getZrnvrate32() {
        return zrnvrate32;
    }

    public void setZrnvrate32(Double pZrnvrate32) {
        zrnvrate32 = pZrnvrate32;
    }

    private Double zrnvrate33;

    @Column(name=GenZT_RatevRn.ZRNVRATE33)
    public Double getZrnvrate33() {
        return zrnvrate33;
    }

    public void setZrnvrate33(Double pZrnvrate33) {
        zrnvrate33 = pZrnvrate33;
    }

    private Double zrnvrate34;

    @Column(name=GenZT_RatevRn.ZRNVRATE34)
    public Double getZrnvrate34() {
        return zrnvrate34;
    }

    public void setZrnvrate34(Double pZrnvrate34) {
        zrnvrate34 = pZrnvrate34;
    }

    private Double zrnvrate35;

    @Column(name=GenZT_RatevRn.ZRNVRATE35)
    public Double getZrnvrate35() {
        return zrnvrate35;
    }

    public void setZrnvrate35(Double pZrnvrate35) {
        zrnvrate35 = pZrnvrate35;
    }

    private Double zrnvrate36;

    @Column(name=GenZT_RatevRn.ZRNVRATE36)
    public Double getZrnvrate36() {
        return zrnvrate36;
    }

    public void setZrnvrate36(Double pZrnvrate36) {
        zrnvrate36 = pZrnvrate36;
    }

    private Double zrnvrate37;

    @Column(name=GenZT_RatevRn.ZRNVRATE37)
    public Double getZrnvrate37() {
        return zrnvrate37;
    }

    public void setZrnvrate37(Double pZrnvrate37) {
        zrnvrate37 = pZrnvrate37;
    }

    private Double zrnvrate38;

    @Column(name=GenZT_RatevRn.ZRNVRATE38)
    public Double getZrnvrate38() {
        return zrnvrate38;
    }

    public void setZrnvrate38(Double pZrnvrate38) {
        zrnvrate38 = pZrnvrate38;
    }

    private Double zrnvrate39;

    @Column(name=GenZT_RatevRn.ZRNVRATE39)
    public Double getZrnvrate39() {
        return zrnvrate39;
    }

    public void setZrnvrate39(Double pZrnvrate39) {
        zrnvrate39 = pZrnvrate39;
    }

    private Double zrnvrate40;

    @Column(name=GenZT_RatevRn.ZRNVRATE40)
    public Double getZrnvrate40() {
        return zrnvrate40;
    }

    public void setZrnvrate40(Double pZrnvrate40) {
        zrnvrate40 = pZrnvrate40;
    }

    private Double zrnvrate41;

    @Column(name=GenZT_RatevRn.ZRNVRATE41)
    public Double getZrnvrate41() {
        return zrnvrate41;
    }

    public void setZrnvrate41(Double pZrnvrate41) {
        zrnvrate41 = pZrnvrate41;
    }

    private Double zrnvrate42;

    @Column(name=GenZT_RatevRn.ZRNVRATE42)
    public Double getZrnvrate42() {
        return zrnvrate42;
    }

    public void setZrnvrate42(Double pZrnvrate42) {
        zrnvrate42 = pZrnvrate42;
    }

    private Double zrnvrate43;

    @Column(name=GenZT_RatevRn.ZRNVRATE43)
    public Double getZrnvrate43() {
        return zrnvrate43;
    }

    public void setZrnvrate43(Double pZrnvrate43) {
        zrnvrate43 = pZrnvrate43;
    }

    private Double zrnvrate44;

    @Column(name=GenZT_RatevRn.ZRNVRATE44)
    public Double getZrnvrate44() {
        return zrnvrate44;
    }

    public void setZrnvrate44(Double pZrnvrate44) {
        zrnvrate44 = pZrnvrate44;
    }

    private Double zrnvrate45;

    @Column(name=GenZT_RatevRn.ZRNVRATE45)
    public Double getZrnvrate45() {
        return zrnvrate45;
    }

    public void setZrnvrate45(Double pZrnvrate45) {
        zrnvrate45 = pZrnvrate45;
    }

    private Double zrnvrate46;

    @Column(name=GenZT_RatevRn.ZRNVRATE46)
    public Double getZrnvrate46() {
        return zrnvrate46;
    }

    public void setZrnvrate46(Double pZrnvrate46) {
        zrnvrate46 = pZrnvrate46;
    }

    private Double zrnvrate47;

    @Column(name=GenZT_RatevRn.ZRNVRATE47)
    public Double getZrnvrate47() {
        return zrnvrate47;
    }

    public void setZrnvrate47(Double pZrnvrate47) {
        zrnvrate47 = pZrnvrate47;
    }

    private Double zrnvrate48;

    @Column(name=GenZT_RatevRn.ZRNVRATE48)
    public Double getZrnvrate48() {
        return zrnvrate48;
    }

    public void setZrnvrate48(Double pZrnvrate48) {
        zrnvrate48 = pZrnvrate48;
    }

    private Double zrnvrate49;

    @Column(name=GenZT_RatevRn.ZRNVRATE49)
    public Double getZrnvrate49() {
        return zrnvrate49;
    }

    public void setZrnvrate49(Double pZrnvrate49) {
        zrnvrate49 = pZrnvrate49;
    }

    private Double zrnvrate50;

    @Column(name=GenZT_RatevRn.ZRNVRATE50)
    public Double getZrnvrate50() {
        return zrnvrate50;
    }

    public void setZrnvrate50(Double pZrnvrate50) {
        zrnvrate50 = pZrnvrate50;
    }

    private Double zrnvrate51;

    @Column(name=GenZT_RatevRn.ZRNVRATE51)
    public Double getZrnvrate51() {
        return zrnvrate51;
    }

    public void setZrnvrate51(Double pZrnvrate51) {
        zrnvrate51 = pZrnvrate51;
    }

    private Double zrnvrate52;

    @Column(name=GenZT_RatevRn.ZRNVRATE52)
    public Double getZrnvrate52() {
        return zrnvrate52;
    }

    public void setZrnvrate52(Double pZrnvrate52) {
        zrnvrate52 = pZrnvrate52;
    }

    private Double zrnvrate53;

    @Column(name=GenZT_RatevRn.ZRNVRATE53)
    public Double getZrnvrate53() {
        return zrnvrate53;
    }

    public void setZrnvrate53(Double pZrnvrate53) {
        zrnvrate53 = pZrnvrate53;
    }

    private Double zrnvrate54;

    @Column(name=GenZT_RatevRn.ZRNVRATE54)
    public Double getZrnvrate54() {
        return zrnvrate54;
    }

    public void setZrnvrate54(Double pZrnvrate54) {
        zrnvrate54 = pZrnvrate54;
    }

    private Double zrnvrate55;

    @Column(name=GenZT_RatevRn.ZRNVRATE55)
    public Double getZrnvrate55() {
        return zrnvrate55;
    }

    public void setZrnvrate55(Double pZrnvrate55) {
        zrnvrate55 = pZrnvrate55;
    }

    private Double zrnvrate56;

    @Column(name=GenZT_RatevRn.ZRNVRATE56)
    public Double getZrnvrate56() {
        return zrnvrate56;
    }

    public void setZrnvrate56(Double pZrnvrate56) {
        zrnvrate56 = pZrnvrate56;
    }

    private Double zrnvrate57;

    @Column(name=GenZT_RatevRn.ZRNVRATE57)
    public Double getZrnvrate57() {
        return zrnvrate57;
    }

    public void setZrnvrate57(Double pZrnvrate57) {
        zrnvrate57 = pZrnvrate57;
    }

    private Double zrnvrate58;

    @Column(name=GenZT_RatevRn.ZRNVRATE58)
    public Double getZrnvrate58() {
        return zrnvrate58;
    }

    public void setZrnvrate58(Double pZrnvrate58) {
        zrnvrate58 = pZrnvrate58;
    }

    private Double zrnvrate59;

    @Column(name=GenZT_RatevRn.ZRNVRATE59)
    public Double getZrnvrate59() {
        return zrnvrate59;
    }

    public void setZrnvrate59(Double pZrnvrate59) {
        zrnvrate59 = pZrnvrate59;
    }

    private Double zrnvrate60;

    @Column(name=GenZT_RatevRn.ZRNVRATE60)
    public Double getZrnvrate60() {
        return zrnvrate60;
    }

    public void setZrnvrate60(Double pZrnvrate60) {
        zrnvrate60 = pZrnvrate60;
    }

    private Double zrnvrate61;

    @Column(name=GenZT_RatevRn.ZRNVRATE61)
    public Double getZrnvrate61() {
        return zrnvrate61;
    }

    public void setZrnvrate61(Double pZrnvrate61) {
        zrnvrate61 = pZrnvrate61;
    }

    private Double zrnvrate62;

    @Column(name=GenZT_RatevRn.ZRNVRATE62)
    public Double getZrnvrate62() {
        return zrnvrate62;
    }

    public void setZrnvrate62(Double pZrnvrate62) {
        zrnvrate62 = pZrnvrate62;
    }

    private Double zrnvrate63;

    @Column(name=GenZT_RatevRn.ZRNVRATE63)
    public Double getZrnvrate63() {
        return zrnvrate63;
    }

    public void setZrnvrate63(Double pZrnvrate63) {
        zrnvrate63 = pZrnvrate63;
    }

    private Double zrnvrate64;

    @Column(name=GenZT_RatevRn.ZRNVRATE64)
    public Double getZrnvrate64() {
        return zrnvrate64;
    }

    public void setZrnvrate64(Double pZrnvrate64) {
        zrnvrate64 = pZrnvrate64;
    }

    private Double zrnvrate65;

    @Column(name=GenZT_RatevRn.ZRNVRATE65)
    public Double getZrnvrate65() {
        return zrnvrate65;
    }

    public void setZrnvrate65(Double pZrnvrate65) {
        zrnvrate65 = pZrnvrate65;
    }

    private Double zrnvrate66;

    @Column(name=GenZT_RatevRn.ZRNVRATE66)
    public Double getZrnvrate66() {
        return zrnvrate66;
    }

    public void setZrnvrate66(Double pZrnvrate66) {
        zrnvrate66 = pZrnvrate66;
    }

    private Double zrnvrate67;

    @Column(name=GenZT_RatevRn.ZRNVRATE67)
    public Double getZrnvrate67() {
        return zrnvrate67;
    }

    public void setZrnvrate67(Double pZrnvrate67) {
        zrnvrate67 = pZrnvrate67;
    }

    private Double zrnvrate68;

    @Column(name=GenZT_RatevRn.ZRNVRATE68)
    public Double getZrnvrate68() {
        return zrnvrate68;
    }

    public void setZrnvrate68(Double pZrnvrate68) {
        zrnvrate68 = pZrnvrate68;
    }

    private Double zrnvrate69;

    @Column(name=GenZT_RatevRn.ZRNVRATE69)
    public Double getZrnvrate69() {
        return zrnvrate69;
    }

    public void setZrnvrate69(Double pZrnvrate69) {
        zrnvrate69 = pZrnvrate69;
    }

    private Double zrnvrate70;

    @Column(name=GenZT_RatevRn.ZRNVRATE70)
    public Double getZrnvrate70() {
        return zrnvrate70;
    }

    public void setZrnvrate70(Double pZrnvrate70) {
        zrnvrate70 = pZrnvrate70;
    }

    private Double zrnvrate71;

    @Column(name=GenZT_RatevRn.ZRNVRATE71)
    public Double getZrnvrate71() {
        return zrnvrate71;
    }

    public void setZrnvrate71(Double pZrnvrate71) {
        zrnvrate71 = pZrnvrate71;
    }

    private Double zrnvrate72;

    @Column(name=GenZT_RatevRn.ZRNVRATE72)
    public Double getZrnvrate72() {
        return zrnvrate72;
    }

    public void setZrnvrate72(Double pZrnvrate72) {
        zrnvrate72 = pZrnvrate72;
    }

    private Double zrnvrate73;

    @Column(name=GenZT_RatevRn.ZRNVRATE73)
    public Double getZrnvrate73() {
        return zrnvrate73;
    }

    public void setZrnvrate73(Double pZrnvrate73) {
        zrnvrate73 = pZrnvrate73;
    }

    private Double zrnvrate74;

    @Column(name=GenZT_RatevRn.ZRNVRATE74)
    public Double getZrnvrate74() {
        return zrnvrate74;
    }

    public void setZrnvrate74(Double pZrnvrate74) {
        zrnvrate74 = pZrnvrate74;
    }

    private Double zrnvrate75;

    @Column(name=GenZT_RatevRn.ZRNVRATE75)
    public Double getZrnvrate75() {
        return zrnvrate75;
    }

    public void setZrnvrate75(Double pZrnvrate75) {
        zrnvrate75 = pZrnvrate75;
    }

    private Double zrnvrate76;

    @Column(name=GenZT_RatevRn.ZRNVRATE76)
    public Double getZrnvrate76() {
        return zrnvrate76;
    }

    public void setZrnvrate76(Double pZrnvrate76) {
        zrnvrate76 = pZrnvrate76;
    }

    private Double zrnvrate77;

    @Column(name=GenZT_RatevRn.ZRNVRATE77)
    public Double getZrnvrate77() {
        return zrnvrate77;
    }

    public void setZrnvrate77(Double pZrnvrate77) {
        zrnvrate77 = pZrnvrate77;
    }

    private Double zrnvrate78;

    @Column(name=GenZT_RatevRn.ZRNVRATE78)
    public Double getZrnvrate78() {
        return zrnvrate78;
    }

    public void setZrnvrate78(Double pZrnvrate78) {
        zrnvrate78 = pZrnvrate78;
    }

    private Double zrnvrate79;

    @Column(name=GenZT_RatevRn.ZRNVRATE79)
    public Double getZrnvrate79() {
        return zrnvrate79;
    }

    public void setZrnvrate79(Double pZrnvrate79) {
        zrnvrate79 = pZrnvrate79;
    }

    private Double zrnvrate80;

    @Column(name=GenZT_RatevRn.ZRNVRATE80)
    public Double getZrnvrate80() {
        return zrnvrate80;
    }

    public void setZrnvrate80(Double pZrnvrate80) {
        zrnvrate80 = pZrnvrate80;
    }

    private Double zrnvrate81;

    @Column(name=GenZT_RatevRn.ZRNVRATE81)
    public Double getZrnvrate81() {
        return zrnvrate81;
    }

    public void setZrnvrate81(Double pZrnvrate81) {
        zrnvrate81 = pZrnvrate81;
    }

    private Double zrnvrate82;

    @Column(name=GenZT_RatevRn.ZRNVRATE82)
    public Double getZrnvrate82() {
        return zrnvrate82;
    }

    public void setZrnvrate82(Double pZrnvrate82) {
        zrnvrate82 = pZrnvrate82;
    }

    private Double zrnvrate83;

    @Column(name=GenZT_RatevRn.ZRNVRATE83)
    public Double getZrnvrate83() {
        return zrnvrate83;
    }

    public void setZrnvrate83(Double pZrnvrate83) {
        zrnvrate83 = pZrnvrate83;
    }

    private Double zrnvrate84;

    @Column(name=GenZT_RatevRn.ZRNVRATE84)
    public Double getZrnvrate84() {
        return zrnvrate84;
    }

    public void setZrnvrate84(Double pZrnvrate84) {
        zrnvrate84 = pZrnvrate84;
    }

    private Double zrnvrate85;

    @Column(name=GenZT_RatevRn.ZRNVRATE85)
    public Double getZrnvrate85() {
        return zrnvrate85;
    }

    public void setZrnvrate85(Double pZrnvrate85) {
        zrnvrate85 = pZrnvrate85;
    }

    private Double zrnvrate86;

    @Column(name=GenZT_RatevRn.ZRNVRATE86)
    public Double getZrnvrate86() {
        return zrnvrate86;
    }

    public void setZrnvrate86(Double pZrnvrate86) {
        zrnvrate86 = pZrnvrate86;
    }

    private Double zrnvrate87;

    @Column(name=GenZT_RatevRn.ZRNVRATE87)
    public Double getZrnvrate87() {
        return zrnvrate87;
    }

    public void setZrnvrate87(Double pZrnvrate87) {
        zrnvrate87 = pZrnvrate87;
    }

    private Double zrnvrate88;

    @Column(name=GenZT_RatevRn.ZRNVRATE88)
    public Double getZrnvrate88() {
        return zrnvrate88;
    }

    public void setZrnvrate88(Double pZrnvrate88) {
        zrnvrate88 = pZrnvrate88;
    }

    private Double zrnvrate89;

    @Column(name=GenZT_RatevRn.ZRNVRATE89)
    public Double getZrnvrate89() {
        return zrnvrate89;
    }

    public void setZrnvrate89(Double pZrnvrate89) {
        zrnvrate89 = pZrnvrate89;
    }

    private Double zrnvrate90;

    @Column(name=GenZT_RatevRn.ZRNVRATE90)
    public Double getZrnvrate90() {
        return zrnvrate90;
    }

    public void setZrnvrate90(Double pZrnvrate90) {
        zrnvrate90 = pZrnvrate90;
    }

    private Double zrnvrate91;

    @Column(name=GenZT_RatevRn.ZRNVRATE91)
    public Double getZrnvrate91() {
        return zrnvrate91;
    }

    public void setZrnvrate91(Double pZrnvrate91) {
        zrnvrate91 = pZrnvrate91;
    }

    private Double zrnvrate92;

    @Column(name=GenZT_RatevRn.ZRNVRATE92)
    public Double getZrnvrate92() {
        return zrnvrate92;
    }

    public void setZrnvrate92(Double pZrnvrate92) {
        zrnvrate92 = pZrnvrate92;
    }

    private Double zrnvrate93;

    @Column(name=GenZT_RatevRn.ZRNVRATE93)
    public Double getZrnvrate93() {
        return zrnvrate93;
    }

    public void setZrnvrate93(Double pZrnvrate93) {
        zrnvrate93 = pZrnvrate93;
    }

    private Double zrnvrate94;

    @Column(name=GenZT_RatevRn.ZRNVRATE94)
    public Double getZrnvrate94() {
        return zrnvrate94;
    }

    public void setZrnvrate94(Double pZrnvrate94) {
        zrnvrate94 = pZrnvrate94;
    }

    private Double zrnvrate95;

    @Column(name=GenZT_RatevRn.ZRNVRATE95)
    public Double getZrnvrate95() {
        return zrnvrate95;
    }

    public void setZrnvrate95(Double pZrnvrate95) {
        zrnvrate95 = pZrnvrate95;
    }

    private Double zrnvrate96;

    @Column(name=GenZT_RatevRn.ZRNVRATE96)
    public Double getZrnvrate96() {
        return zrnvrate96;
    }

    public void setZrnvrate96(Double pZrnvrate96) {
        zrnvrate96 = pZrnvrate96;
    }

    private Double zrnvrate97;

    @Column(name=GenZT_RatevRn.ZRNVRATE97)
    public Double getZrnvrate97() {
        return zrnvrate97;
    }

    public void setZrnvrate97(Double pZrnvrate97) {
        zrnvrate97 = pZrnvrate97;
    }

    private Double zrnvrate98;

    @Column(name=GenZT_RatevRn.ZRNVRATE98)
    public Double getZrnvrate98() {
        return zrnvrate98;
    }

    public void setZrnvrate98(Double pZrnvrate98) {
        zrnvrate98 = pZrnvrate98;
    }

    private Double zrnvrate99;

    @Column(name=GenZT_RatevRn.ZRNVRATE99)
    public Double getZrnvrate99() {
        return zrnvrate99;
    }

    public void setZrnvrate99(Double pZrnvrate99) {
        zrnvrate99 = pZrnvrate99;
    }
}