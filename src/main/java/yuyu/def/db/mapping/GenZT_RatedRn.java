package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_RatedRn;
import yuyu.def.db.id.PKZT_RatedRn;
import yuyu.def.db.meta.GenQZT_RatedRn;
import yuyu.def.db.meta.QZT_RatedRn;

/**
 * Dレートテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_RatedRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RatedRn}</td><td colspan="3">Dレートテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu zrnyoteiriritu}</td><td>（連携用）予定利率</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbn zrnpmenkbn}</td><td>（連携用）Ｐ免区分</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsei zrnhhknsei}</td><td>（連携用）被保険者性別</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujihhknnen zrnkeiyakujihhknnen}</td><td>（連携用）契約時被保険者年令</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndnendo zrndnendo}</td><td>（連携用）Ｄ年度</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaiteikakuteikbn zrnnaiteikakuteikbn}</td><td>（連携用）Ｄレート内定確定区分</td><td align="center">{@link PKZT_RatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrate00 zrndrate00}</td><td>（連携用）Ｄレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate01 zrndrate01}</td><td>（連携用）Ｄレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate02 zrndrate02}</td><td>（連携用）Ｄレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate03 zrndrate03}</td><td>（連携用）Ｄレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate04 zrndrate04}</td><td>（連携用）Ｄレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate05 zrndrate05}</td><td>（連携用）Ｄレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate06 zrndrate06}</td><td>（連携用）Ｄレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate07 zrndrate07}</td><td>（連携用）Ｄレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate08 zrndrate08}</td><td>（連携用）Ｄレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate09 zrndrate09}</td><td>（連携用）Ｄレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate10 zrndrate10}</td><td>（連携用）Ｄレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate11 zrndrate11}</td><td>（連携用）Ｄレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate12 zrndrate12}</td><td>（連携用）Ｄレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate13 zrndrate13}</td><td>（連携用）Ｄレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate14 zrndrate14}</td><td>（連携用）Ｄレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate15 zrndrate15}</td><td>（連携用）Ｄレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate16 zrndrate16}</td><td>（連携用）Ｄレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate17 zrndrate17}</td><td>（連携用）Ｄレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate18 zrndrate18}</td><td>（連携用）Ｄレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate19 zrndrate19}</td><td>（連携用）Ｄレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate20 zrndrate20}</td><td>（連携用）Ｄレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate21 zrndrate21}</td><td>（連携用）Ｄレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate22 zrndrate22}</td><td>（連携用）Ｄレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate23 zrndrate23}</td><td>（連携用）Ｄレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate24 zrndrate24}</td><td>（連携用）Ｄレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate25 zrndrate25}</td><td>（連携用）Ｄレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate26 zrndrate26}</td><td>（連携用）Ｄレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate27 zrndrate27}</td><td>（連携用）Ｄレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate28 zrndrate28}</td><td>（連携用）Ｄレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate29 zrndrate29}</td><td>（連携用）Ｄレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate30 zrndrate30}</td><td>（連携用）Ｄレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate31 zrndrate31}</td><td>（連携用）Ｄレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate32 zrndrate32}</td><td>（連携用）Ｄレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate33 zrndrate33}</td><td>（連携用）Ｄレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate34 zrndrate34}</td><td>（連携用）Ｄレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate35 zrndrate35}</td><td>（連携用）Ｄレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate36 zrndrate36}</td><td>（連携用）Ｄレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate37 zrndrate37}</td><td>（連携用）Ｄレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate38 zrndrate38}</td><td>（連携用）Ｄレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate39 zrndrate39}</td><td>（連携用）Ｄレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate40 zrndrate40}</td><td>（連携用）Ｄレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate41 zrndrate41}</td><td>（連携用）Ｄレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate42 zrndrate42}</td><td>（連携用）Ｄレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate43 zrndrate43}</td><td>（連携用）Ｄレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate44 zrndrate44}</td><td>（連携用）Ｄレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate45 zrndrate45}</td><td>（連携用）Ｄレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate46 zrndrate46}</td><td>（連携用）Ｄレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate47 zrndrate47}</td><td>（連携用）Ｄレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate48 zrndrate48}</td><td>（連携用）Ｄレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate49 zrndrate49}</td><td>（連携用）Ｄレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate50 zrndrate50}</td><td>（連携用）Ｄレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate51 zrndrate51}</td><td>（連携用）Ｄレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate52 zrndrate52}</td><td>（連携用）Ｄレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate53 zrndrate53}</td><td>（連携用）Ｄレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate54 zrndrate54}</td><td>（連携用）Ｄレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate55 zrndrate55}</td><td>（連携用）Ｄレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate56 zrndrate56}</td><td>（連携用）Ｄレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate57 zrndrate57}</td><td>（連携用）Ｄレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate58 zrndrate58}</td><td>（連携用）Ｄレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate59 zrndrate59}</td><td>（連携用）Ｄレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate60 zrndrate60}</td><td>（連携用）Ｄレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate61 zrndrate61}</td><td>（連携用）Ｄレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate62 zrndrate62}</td><td>（連携用）Ｄレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate63 zrndrate63}</td><td>（連携用）Ｄレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate64 zrndrate64}</td><td>（連携用）Ｄレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate65 zrndrate65}</td><td>（連携用）Ｄレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate66 zrndrate66}</td><td>（連携用）Ｄレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate67 zrndrate67}</td><td>（連携用）Ｄレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate68 zrndrate68}</td><td>（連携用）Ｄレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate69 zrndrate69}</td><td>（連携用）Ｄレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate70 zrndrate70}</td><td>（連携用）Ｄレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate71 zrndrate71}</td><td>（連携用）Ｄレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate72 zrndrate72}</td><td>（連携用）Ｄレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate73 zrndrate73}</td><td>（連携用）Ｄレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate74 zrndrate74}</td><td>（連携用）Ｄレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate75 zrndrate75}</td><td>（連携用）Ｄレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate76 zrndrate76}</td><td>（連携用）Ｄレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate77 zrndrate77}</td><td>（連携用）Ｄレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate78 zrndrate78}</td><td>（連携用）Ｄレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate79 zrndrate79}</td><td>（連携用）Ｄレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate80 zrndrate80}</td><td>（連携用）Ｄレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate81 zrndrate81}</td><td>（連携用）Ｄレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate82 zrndrate82}</td><td>（連携用）Ｄレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate83 zrndrate83}</td><td>（連携用）Ｄレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate84 zrndrate84}</td><td>（連携用）Ｄレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate85 zrndrate85}</td><td>（連携用）Ｄレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate86 zrndrate86}</td><td>（連携用）Ｄレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate87 zrndrate87}</td><td>（連携用）Ｄレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate88 zrndrate88}</td><td>（連携用）Ｄレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate89 zrndrate89}</td><td>（連携用）Ｄレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate90 zrndrate90}</td><td>（連携用）Ｄレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate91 zrndrate91}</td><td>（連携用）Ｄレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate92 zrndrate92}</td><td>（連携用）Ｄレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate93 zrndrate93}</td><td>（連携用）Ｄレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate94 zrndrate94}</td><td>（連携用）Ｄレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate95 zrndrate95}</td><td>（連携用）Ｄレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate96 zrndrate96}</td><td>（連携用）Ｄレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate97 zrndrate97}</td><td>（連携用）Ｄレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate98 zrndrate98}</td><td>（連携用）Ｄレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndrate99 zrndrate99}</td><td>（連携用）Ｄレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate00 zrnsisadrate00}</td><td>（連携用）死差Ｄレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate01 zrnsisadrate01}</td><td>（連携用）死差Ｄレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate02 zrnsisadrate02}</td><td>（連携用）死差Ｄレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate03 zrnsisadrate03}</td><td>（連携用）死差Ｄレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate04 zrnsisadrate04}</td><td>（連携用）死差Ｄレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate05 zrnsisadrate05}</td><td>（連携用）死差Ｄレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate06 zrnsisadrate06}</td><td>（連携用）死差Ｄレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate07 zrnsisadrate07}</td><td>（連携用）死差Ｄレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate08 zrnsisadrate08}</td><td>（連携用）死差Ｄレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate09 zrnsisadrate09}</td><td>（連携用）死差Ｄレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate10 zrnsisadrate10}</td><td>（連携用）死差Ｄレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate11 zrnsisadrate11}</td><td>（連携用）死差Ｄレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate12 zrnsisadrate12}</td><td>（連携用）死差Ｄレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate13 zrnsisadrate13}</td><td>（連携用）死差Ｄレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate14 zrnsisadrate14}</td><td>（連携用）死差Ｄレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate15 zrnsisadrate15}</td><td>（連携用）死差Ｄレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate16 zrnsisadrate16}</td><td>（連携用）死差Ｄレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate17 zrnsisadrate17}</td><td>（連携用）死差Ｄレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate18 zrnsisadrate18}</td><td>（連携用）死差Ｄレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate19 zrnsisadrate19}</td><td>（連携用）死差Ｄレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate20 zrnsisadrate20}</td><td>（連携用）死差Ｄレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate21 zrnsisadrate21}</td><td>（連携用）死差Ｄレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate22 zrnsisadrate22}</td><td>（連携用）死差Ｄレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate23 zrnsisadrate23}</td><td>（連携用）死差Ｄレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate24 zrnsisadrate24}</td><td>（連携用）死差Ｄレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate25 zrnsisadrate25}</td><td>（連携用）死差Ｄレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate26 zrnsisadrate26}</td><td>（連携用）死差Ｄレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate27 zrnsisadrate27}</td><td>（連携用）死差Ｄレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate28 zrnsisadrate28}</td><td>（連携用）死差Ｄレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate29 zrnsisadrate29}</td><td>（連携用）死差Ｄレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate30 zrnsisadrate30}</td><td>（連携用）死差Ｄレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate31 zrnsisadrate31}</td><td>（連携用）死差Ｄレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate32 zrnsisadrate32}</td><td>（連携用）死差Ｄレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate33 zrnsisadrate33}</td><td>（連携用）死差Ｄレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate34 zrnsisadrate34}</td><td>（連携用）死差Ｄレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate35 zrnsisadrate35}</td><td>（連携用）死差Ｄレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate36 zrnsisadrate36}</td><td>（連携用）死差Ｄレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate37 zrnsisadrate37}</td><td>（連携用）死差Ｄレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate38 zrnsisadrate38}</td><td>（連携用）死差Ｄレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate39 zrnsisadrate39}</td><td>（連携用）死差Ｄレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate40 zrnsisadrate40}</td><td>（連携用）死差Ｄレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate41 zrnsisadrate41}</td><td>（連携用）死差Ｄレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate42 zrnsisadrate42}</td><td>（連携用）死差Ｄレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate43 zrnsisadrate43}</td><td>（連携用）死差Ｄレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate44 zrnsisadrate44}</td><td>（連携用）死差Ｄレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate45 zrnsisadrate45}</td><td>（連携用）死差Ｄレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate46 zrnsisadrate46}</td><td>（連携用）死差Ｄレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate47 zrnsisadrate47}</td><td>（連携用）死差Ｄレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate48 zrnsisadrate48}</td><td>（連携用）死差Ｄレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate49 zrnsisadrate49}</td><td>（連携用）死差Ｄレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate50 zrnsisadrate50}</td><td>（連携用）死差Ｄレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate51 zrnsisadrate51}</td><td>（連携用）死差Ｄレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate52 zrnsisadrate52}</td><td>（連携用）死差Ｄレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate53 zrnsisadrate53}</td><td>（連携用）死差Ｄレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate54 zrnsisadrate54}</td><td>（連携用）死差Ｄレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate55 zrnsisadrate55}</td><td>（連携用）死差Ｄレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate56 zrnsisadrate56}</td><td>（連携用）死差Ｄレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate57 zrnsisadrate57}</td><td>（連携用）死差Ｄレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate58 zrnsisadrate58}</td><td>（連携用）死差Ｄレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate59 zrnsisadrate59}</td><td>（連携用）死差Ｄレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate60 zrnsisadrate60}</td><td>（連携用）死差Ｄレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate61 zrnsisadrate61}</td><td>（連携用）死差Ｄレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate62 zrnsisadrate62}</td><td>（連携用）死差Ｄレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate63 zrnsisadrate63}</td><td>（連携用）死差Ｄレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate64 zrnsisadrate64}</td><td>（連携用）死差Ｄレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate65 zrnsisadrate65}</td><td>（連携用）死差Ｄレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate66 zrnsisadrate66}</td><td>（連携用）死差Ｄレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate67 zrnsisadrate67}</td><td>（連携用）死差Ｄレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate68 zrnsisadrate68}</td><td>（連携用）死差Ｄレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate69 zrnsisadrate69}</td><td>（連携用）死差Ｄレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate70 zrnsisadrate70}</td><td>（連携用）死差Ｄレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate71 zrnsisadrate71}</td><td>（連携用）死差Ｄレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate72 zrnsisadrate72}</td><td>（連携用）死差Ｄレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate73 zrnsisadrate73}</td><td>（連携用）死差Ｄレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate74 zrnsisadrate74}</td><td>（連携用）死差Ｄレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate75 zrnsisadrate75}</td><td>（連携用）死差Ｄレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate76 zrnsisadrate76}</td><td>（連携用）死差Ｄレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate77 zrnsisadrate77}</td><td>（連携用）死差Ｄレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate78 zrnsisadrate78}</td><td>（連携用）死差Ｄレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate79 zrnsisadrate79}</td><td>（連携用）死差Ｄレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate80 zrnsisadrate80}</td><td>（連携用）死差Ｄレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate81 zrnsisadrate81}</td><td>（連携用）死差Ｄレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate82 zrnsisadrate82}</td><td>（連携用）死差Ｄレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate83 zrnsisadrate83}</td><td>（連携用）死差Ｄレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate84 zrnsisadrate84}</td><td>（連携用）死差Ｄレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate85 zrnsisadrate85}</td><td>（連携用）死差Ｄレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate86 zrnsisadrate86}</td><td>（連携用）死差Ｄレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate87 zrnsisadrate87}</td><td>（連携用）死差Ｄレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate88 zrnsisadrate88}</td><td>（連携用）死差Ｄレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate89 zrnsisadrate89}</td><td>（連携用）死差Ｄレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate90 zrnsisadrate90}</td><td>（連携用）死差Ｄレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate91 zrnsisadrate91}</td><td>（連携用）死差Ｄレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate92 zrnsisadrate92}</td><td>（連携用）死差Ｄレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate93 zrnsisadrate93}</td><td>（連携用）死差Ｄレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate94 zrnsisadrate94}</td><td>（連携用）死差Ｄレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate95 zrnsisadrate95}</td><td>（連携用）死差Ｄレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate96 zrnsisadrate96}</td><td>（連携用）死差Ｄレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate97 zrnsisadrate97}</td><td>（連携用）死差Ｄレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate98 zrnsisadrate98}</td><td>（連携用）死差Ｄレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnsisadrate99 zrnsisadrate99}</td><td>（連携用）死差Ｄレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate00 zrnrisadrate00}</td><td>（連携用）利差Ｄレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate01 zrnrisadrate01}</td><td>（連携用）利差Ｄレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate02 zrnrisadrate02}</td><td>（連携用）利差Ｄレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate03 zrnrisadrate03}</td><td>（連携用）利差Ｄレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate04 zrnrisadrate04}</td><td>（連携用）利差Ｄレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate05 zrnrisadrate05}</td><td>（連携用）利差Ｄレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate06 zrnrisadrate06}</td><td>（連携用）利差Ｄレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate07 zrnrisadrate07}</td><td>（連携用）利差Ｄレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate08 zrnrisadrate08}</td><td>（連携用）利差Ｄレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate09 zrnrisadrate09}</td><td>（連携用）利差Ｄレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate10 zrnrisadrate10}</td><td>（連携用）利差Ｄレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate11 zrnrisadrate11}</td><td>（連携用）利差Ｄレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate12 zrnrisadrate12}</td><td>（連携用）利差Ｄレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate13 zrnrisadrate13}</td><td>（連携用）利差Ｄレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate14 zrnrisadrate14}</td><td>（連携用）利差Ｄレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate15 zrnrisadrate15}</td><td>（連携用）利差Ｄレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate16 zrnrisadrate16}</td><td>（連携用）利差Ｄレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate17 zrnrisadrate17}</td><td>（連携用）利差Ｄレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate18 zrnrisadrate18}</td><td>（連携用）利差Ｄレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate19 zrnrisadrate19}</td><td>（連携用）利差Ｄレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate20 zrnrisadrate20}</td><td>（連携用）利差Ｄレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate21 zrnrisadrate21}</td><td>（連携用）利差Ｄレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate22 zrnrisadrate22}</td><td>（連携用）利差Ｄレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate23 zrnrisadrate23}</td><td>（連携用）利差Ｄレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate24 zrnrisadrate24}</td><td>（連携用）利差Ｄレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate25 zrnrisadrate25}</td><td>（連携用）利差Ｄレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate26 zrnrisadrate26}</td><td>（連携用）利差Ｄレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate27 zrnrisadrate27}</td><td>（連携用）利差Ｄレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate28 zrnrisadrate28}</td><td>（連携用）利差Ｄレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate29 zrnrisadrate29}</td><td>（連携用）利差Ｄレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate30 zrnrisadrate30}</td><td>（連携用）利差Ｄレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate31 zrnrisadrate31}</td><td>（連携用）利差Ｄレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate32 zrnrisadrate32}</td><td>（連携用）利差Ｄレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate33 zrnrisadrate33}</td><td>（連携用）利差Ｄレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate34 zrnrisadrate34}</td><td>（連携用）利差Ｄレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate35 zrnrisadrate35}</td><td>（連携用）利差Ｄレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate36 zrnrisadrate36}</td><td>（連携用）利差Ｄレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate37 zrnrisadrate37}</td><td>（連携用）利差Ｄレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate38 zrnrisadrate38}</td><td>（連携用）利差Ｄレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate39 zrnrisadrate39}</td><td>（連携用）利差Ｄレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate40 zrnrisadrate40}</td><td>（連携用）利差Ｄレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate41 zrnrisadrate41}</td><td>（連携用）利差Ｄレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate42 zrnrisadrate42}</td><td>（連携用）利差Ｄレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate43 zrnrisadrate43}</td><td>（連携用）利差Ｄレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate44 zrnrisadrate44}</td><td>（連携用）利差Ｄレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate45 zrnrisadrate45}</td><td>（連携用）利差Ｄレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate46 zrnrisadrate46}</td><td>（連携用）利差Ｄレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate47 zrnrisadrate47}</td><td>（連携用）利差Ｄレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate48 zrnrisadrate48}</td><td>（連携用）利差Ｄレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate49 zrnrisadrate49}</td><td>（連携用）利差Ｄレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate50 zrnrisadrate50}</td><td>（連携用）利差Ｄレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate51 zrnrisadrate51}</td><td>（連携用）利差Ｄレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate52 zrnrisadrate52}</td><td>（連携用）利差Ｄレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate53 zrnrisadrate53}</td><td>（連携用）利差Ｄレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate54 zrnrisadrate54}</td><td>（連携用）利差Ｄレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate55 zrnrisadrate55}</td><td>（連携用）利差Ｄレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate56 zrnrisadrate56}</td><td>（連携用）利差Ｄレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate57 zrnrisadrate57}</td><td>（連携用）利差Ｄレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate58 zrnrisadrate58}</td><td>（連携用）利差Ｄレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate59 zrnrisadrate59}</td><td>（連携用）利差Ｄレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate60 zrnrisadrate60}</td><td>（連携用）利差Ｄレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate61 zrnrisadrate61}</td><td>（連携用）利差Ｄレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate62 zrnrisadrate62}</td><td>（連携用）利差Ｄレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate63 zrnrisadrate63}</td><td>（連携用）利差Ｄレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate64 zrnrisadrate64}</td><td>（連携用）利差Ｄレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate65 zrnrisadrate65}</td><td>（連携用）利差Ｄレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate66 zrnrisadrate66}</td><td>（連携用）利差Ｄレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate67 zrnrisadrate67}</td><td>（連携用）利差Ｄレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate68 zrnrisadrate68}</td><td>（連携用）利差Ｄレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate69 zrnrisadrate69}</td><td>（連携用）利差Ｄレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate70 zrnrisadrate70}</td><td>（連携用）利差Ｄレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate71 zrnrisadrate71}</td><td>（連携用）利差Ｄレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate72 zrnrisadrate72}</td><td>（連携用）利差Ｄレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate73 zrnrisadrate73}</td><td>（連携用）利差Ｄレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate74 zrnrisadrate74}</td><td>（連携用）利差Ｄレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate75 zrnrisadrate75}</td><td>（連携用）利差Ｄレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate76 zrnrisadrate76}</td><td>（連携用）利差Ｄレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate77 zrnrisadrate77}</td><td>（連携用）利差Ｄレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate78 zrnrisadrate78}</td><td>（連携用）利差Ｄレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate79 zrnrisadrate79}</td><td>（連携用）利差Ｄレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate80 zrnrisadrate80}</td><td>（連携用）利差Ｄレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate81 zrnrisadrate81}</td><td>（連携用）利差Ｄレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate82 zrnrisadrate82}</td><td>（連携用）利差Ｄレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate83 zrnrisadrate83}</td><td>（連携用）利差Ｄレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate84 zrnrisadrate84}</td><td>（連携用）利差Ｄレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate85 zrnrisadrate85}</td><td>（連携用）利差Ｄレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate86 zrnrisadrate86}</td><td>（連携用）利差Ｄレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate87 zrnrisadrate87}</td><td>（連携用）利差Ｄレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate88 zrnrisadrate88}</td><td>（連携用）利差Ｄレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate89 zrnrisadrate89}</td><td>（連携用）利差Ｄレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate90 zrnrisadrate90}</td><td>（連携用）利差Ｄレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate91 zrnrisadrate91}</td><td>（連携用）利差Ｄレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate92 zrnrisadrate92}</td><td>（連携用）利差Ｄレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate93 zrnrisadrate93}</td><td>（連携用）利差Ｄレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate94 zrnrisadrate94}</td><td>（連携用）利差Ｄレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate95 zrnrisadrate95}</td><td>（連携用）利差Ｄレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate96 zrnrisadrate96}</td><td>（連携用）利差Ｄレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate97 zrnrisadrate97}</td><td>（連携用）利差Ｄレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate98 zrnrisadrate98}</td><td>（連携用）利差Ｄレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnrisadrate99 zrnrisadrate99}</td><td>（連携用）利差Ｄレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate00 zrnhisadrate00}</td><td>（連携用）費差Ｄレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate01 zrnhisadrate01}</td><td>（連携用）費差Ｄレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate02 zrnhisadrate02}</td><td>（連携用）費差Ｄレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate03 zrnhisadrate03}</td><td>（連携用）費差Ｄレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate04 zrnhisadrate04}</td><td>（連携用）費差Ｄレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate05 zrnhisadrate05}</td><td>（連携用）費差Ｄレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate06 zrnhisadrate06}</td><td>（連携用）費差Ｄレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate07 zrnhisadrate07}</td><td>（連携用）費差Ｄレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate08 zrnhisadrate08}</td><td>（連携用）費差Ｄレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate09 zrnhisadrate09}</td><td>（連携用）費差Ｄレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate10 zrnhisadrate10}</td><td>（連携用）費差Ｄレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate11 zrnhisadrate11}</td><td>（連携用）費差Ｄレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate12 zrnhisadrate12}</td><td>（連携用）費差Ｄレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate13 zrnhisadrate13}</td><td>（連携用）費差Ｄレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate14 zrnhisadrate14}</td><td>（連携用）費差Ｄレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate15 zrnhisadrate15}</td><td>（連携用）費差Ｄレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate16 zrnhisadrate16}</td><td>（連携用）費差Ｄレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate17 zrnhisadrate17}</td><td>（連携用）費差Ｄレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate18 zrnhisadrate18}</td><td>（連携用）費差Ｄレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate19 zrnhisadrate19}</td><td>（連携用）費差Ｄレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate20 zrnhisadrate20}</td><td>（連携用）費差Ｄレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate21 zrnhisadrate21}</td><td>（連携用）費差Ｄレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate22 zrnhisadrate22}</td><td>（連携用）費差Ｄレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate23 zrnhisadrate23}</td><td>（連携用）費差Ｄレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate24 zrnhisadrate24}</td><td>（連携用）費差Ｄレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate25 zrnhisadrate25}</td><td>（連携用）費差Ｄレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate26 zrnhisadrate26}</td><td>（連携用）費差Ｄレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate27 zrnhisadrate27}</td><td>（連携用）費差Ｄレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate28 zrnhisadrate28}</td><td>（連携用）費差Ｄレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate29 zrnhisadrate29}</td><td>（連携用）費差Ｄレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate30 zrnhisadrate30}</td><td>（連携用）費差Ｄレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate31 zrnhisadrate31}</td><td>（連携用）費差Ｄレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate32 zrnhisadrate32}</td><td>（連携用）費差Ｄレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate33 zrnhisadrate33}</td><td>（連携用）費差Ｄレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate34 zrnhisadrate34}</td><td>（連携用）費差Ｄレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate35 zrnhisadrate35}</td><td>（連携用）費差Ｄレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate36 zrnhisadrate36}</td><td>（連携用）費差Ｄレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate37 zrnhisadrate37}</td><td>（連携用）費差Ｄレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate38 zrnhisadrate38}</td><td>（連携用）費差Ｄレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate39 zrnhisadrate39}</td><td>（連携用）費差Ｄレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate40 zrnhisadrate40}</td><td>（連携用）費差Ｄレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate41 zrnhisadrate41}</td><td>（連携用）費差Ｄレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate42 zrnhisadrate42}</td><td>（連携用）費差Ｄレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate43 zrnhisadrate43}</td><td>（連携用）費差Ｄレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate44 zrnhisadrate44}</td><td>（連携用）費差Ｄレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate45 zrnhisadrate45}</td><td>（連携用）費差Ｄレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate46 zrnhisadrate46}</td><td>（連携用）費差Ｄレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate47 zrnhisadrate47}</td><td>（連携用）費差Ｄレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate48 zrnhisadrate48}</td><td>（連携用）費差Ｄレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate49 zrnhisadrate49}</td><td>（連携用）費差Ｄレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate50 zrnhisadrate50}</td><td>（連携用）費差Ｄレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate51 zrnhisadrate51}</td><td>（連携用）費差Ｄレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate52 zrnhisadrate52}</td><td>（連携用）費差Ｄレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate53 zrnhisadrate53}</td><td>（連携用）費差Ｄレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate54 zrnhisadrate54}</td><td>（連携用）費差Ｄレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate55 zrnhisadrate55}</td><td>（連携用）費差Ｄレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate56 zrnhisadrate56}</td><td>（連携用）費差Ｄレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate57 zrnhisadrate57}</td><td>（連携用）費差Ｄレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate58 zrnhisadrate58}</td><td>（連携用）費差Ｄレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate59 zrnhisadrate59}</td><td>（連携用）費差Ｄレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate60 zrnhisadrate60}</td><td>（連携用）費差Ｄレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate61 zrnhisadrate61}</td><td>（連携用）費差Ｄレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate62 zrnhisadrate62}</td><td>（連携用）費差Ｄレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate63 zrnhisadrate63}</td><td>（連携用）費差Ｄレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate64 zrnhisadrate64}</td><td>（連携用）費差Ｄレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate65 zrnhisadrate65}</td><td>（連携用）費差Ｄレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate66 zrnhisadrate66}</td><td>（連携用）費差Ｄレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate67 zrnhisadrate67}</td><td>（連携用）費差Ｄレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate68 zrnhisadrate68}</td><td>（連携用）費差Ｄレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate69 zrnhisadrate69}</td><td>（連携用）費差Ｄレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate70 zrnhisadrate70}</td><td>（連携用）費差Ｄレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate71 zrnhisadrate71}</td><td>（連携用）費差Ｄレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate72 zrnhisadrate72}</td><td>（連携用）費差Ｄレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate73 zrnhisadrate73}</td><td>（連携用）費差Ｄレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate74 zrnhisadrate74}</td><td>（連携用）費差Ｄレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate75 zrnhisadrate75}</td><td>（連携用）費差Ｄレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate76 zrnhisadrate76}</td><td>（連携用）費差Ｄレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate77 zrnhisadrate77}</td><td>（連携用）費差Ｄレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate78 zrnhisadrate78}</td><td>（連携用）費差Ｄレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate79 zrnhisadrate79}</td><td>（連携用）費差Ｄレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate80 zrnhisadrate80}</td><td>（連携用）費差Ｄレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate81 zrnhisadrate81}</td><td>（連携用）費差Ｄレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate82 zrnhisadrate82}</td><td>（連携用）費差Ｄレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate83 zrnhisadrate83}</td><td>（連携用）費差Ｄレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate84 zrnhisadrate84}</td><td>（連携用）費差Ｄレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate85 zrnhisadrate85}</td><td>（連携用）費差Ｄレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate86 zrnhisadrate86}</td><td>（連携用）費差Ｄレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate87 zrnhisadrate87}</td><td>（連携用）費差Ｄレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate88 zrnhisadrate88}</td><td>（連携用）費差Ｄレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate89 zrnhisadrate89}</td><td>（連携用）費差Ｄレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate90 zrnhisadrate90}</td><td>（連携用）費差Ｄレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate91 zrnhisadrate91}</td><td>（連携用）費差Ｄレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate92 zrnhisadrate92}</td><td>（連携用）費差Ｄレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate93 zrnhisadrate93}</td><td>（連携用）費差Ｄレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate94 zrnhisadrate94}</td><td>（連携用）費差Ｄレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate95 zrnhisadrate95}</td><td>（連携用）費差Ｄレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate96 zrnhisadrate96}</td><td>（連携用）費差Ｄレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate97 zrnhisadrate97}</td><td>（連携用）費差Ｄレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate98 zrnhisadrate98}</td><td>（連携用）費差Ｄレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnhisadrate99 zrnhisadrate99}</td><td>（連携用）費差Ｄレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate00 zrndyouvrate00}</td><td>（連携用）Ｄ用Ｖレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate01 zrndyouvrate01}</td><td>（連携用）Ｄ用Ｖレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate02 zrndyouvrate02}</td><td>（連携用）Ｄ用Ｖレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate03 zrndyouvrate03}</td><td>（連携用）Ｄ用Ｖレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate04 zrndyouvrate04}</td><td>（連携用）Ｄ用Ｖレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate05 zrndyouvrate05}</td><td>（連携用）Ｄ用Ｖレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate06 zrndyouvrate06}</td><td>（連携用）Ｄ用Ｖレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate07 zrndyouvrate07}</td><td>（連携用）Ｄ用Ｖレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate08 zrndyouvrate08}</td><td>（連携用）Ｄ用Ｖレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate09 zrndyouvrate09}</td><td>（連携用）Ｄ用Ｖレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate10 zrndyouvrate10}</td><td>（連携用）Ｄ用Ｖレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate11 zrndyouvrate11}</td><td>（連携用）Ｄ用Ｖレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate12 zrndyouvrate12}</td><td>（連携用）Ｄ用Ｖレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate13 zrndyouvrate13}</td><td>（連携用）Ｄ用Ｖレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate14 zrndyouvrate14}</td><td>（連携用）Ｄ用Ｖレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate15 zrndyouvrate15}</td><td>（連携用）Ｄ用Ｖレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate16 zrndyouvrate16}</td><td>（連携用）Ｄ用Ｖレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate17 zrndyouvrate17}</td><td>（連携用）Ｄ用Ｖレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate18 zrndyouvrate18}</td><td>（連携用）Ｄ用Ｖレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate19 zrndyouvrate19}</td><td>（連携用）Ｄ用Ｖレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate20 zrndyouvrate20}</td><td>（連携用）Ｄ用Ｖレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate21 zrndyouvrate21}</td><td>（連携用）Ｄ用Ｖレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate22 zrndyouvrate22}</td><td>（連携用）Ｄ用Ｖレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate23 zrndyouvrate23}</td><td>（連携用）Ｄ用Ｖレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate24 zrndyouvrate24}</td><td>（連携用）Ｄ用Ｖレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate25 zrndyouvrate25}</td><td>（連携用）Ｄ用Ｖレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate26 zrndyouvrate26}</td><td>（連携用）Ｄ用Ｖレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate27 zrndyouvrate27}</td><td>（連携用）Ｄ用Ｖレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate28 zrndyouvrate28}</td><td>（連携用）Ｄ用Ｖレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate29 zrndyouvrate29}</td><td>（連携用）Ｄ用Ｖレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate30 zrndyouvrate30}</td><td>（連携用）Ｄ用Ｖレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate31 zrndyouvrate31}</td><td>（連携用）Ｄ用Ｖレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate32 zrndyouvrate32}</td><td>（連携用）Ｄ用Ｖレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate33 zrndyouvrate33}</td><td>（連携用）Ｄ用Ｖレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate34 zrndyouvrate34}</td><td>（連携用）Ｄ用Ｖレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate35 zrndyouvrate35}</td><td>（連携用）Ｄ用Ｖレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate36 zrndyouvrate36}</td><td>（連携用）Ｄ用Ｖレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate37 zrndyouvrate37}</td><td>（連携用）Ｄ用Ｖレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate38 zrndyouvrate38}</td><td>（連携用）Ｄ用Ｖレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate39 zrndyouvrate39}</td><td>（連携用）Ｄ用Ｖレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate40 zrndyouvrate40}</td><td>（連携用）Ｄ用Ｖレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate41 zrndyouvrate41}</td><td>（連携用）Ｄ用Ｖレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate42 zrndyouvrate42}</td><td>（連携用）Ｄ用Ｖレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate43 zrndyouvrate43}</td><td>（連携用）Ｄ用Ｖレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate44 zrndyouvrate44}</td><td>（連携用）Ｄ用Ｖレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate45 zrndyouvrate45}</td><td>（連携用）Ｄ用Ｖレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate46 zrndyouvrate46}</td><td>（連携用）Ｄ用Ｖレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate47 zrndyouvrate47}</td><td>（連携用）Ｄ用Ｖレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate48 zrndyouvrate48}</td><td>（連携用）Ｄ用Ｖレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate49 zrndyouvrate49}</td><td>（連携用）Ｄ用Ｖレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate50 zrndyouvrate50}</td><td>（連携用）Ｄ用Ｖレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate51 zrndyouvrate51}</td><td>（連携用）Ｄ用Ｖレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate52 zrndyouvrate52}</td><td>（連携用）Ｄ用Ｖレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate53 zrndyouvrate53}</td><td>（連携用）Ｄ用Ｖレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate54 zrndyouvrate54}</td><td>（連携用）Ｄ用Ｖレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate55 zrndyouvrate55}</td><td>（連携用）Ｄ用Ｖレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate56 zrndyouvrate56}</td><td>（連携用）Ｄ用Ｖレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate57 zrndyouvrate57}</td><td>（連携用）Ｄ用Ｖレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate58 zrndyouvrate58}</td><td>（連携用）Ｄ用Ｖレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate59 zrndyouvrate59}</td><td>（連携用）Ｄ用Ｖレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate60 zrndyouvrate60}</td><td>（連携用）Ｄ用Ｖレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate61 zrndyouvrate61}</td><td>（連携用）Ｄ用Ｖレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate62 zrndyouvrate62}</td><td>（連携用）Ｄ用Ｖレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate63 zrndyouvrate63}</td><td>（連携用）Ｄ用Ｖレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate64 zrndyouvrate64}</td><td>（連携用）Ｄ用Ｖレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate65 zrndyouvrate65}</td><td>（連携用）Ｄ用Ｖレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate66 zrndyouvrate66}</td><td>（連携用）Ｄ用Ｖレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate67 zrndyouvrate67}</td><td>（連携用）Ｄ用Ｖレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate68 zrndyouvrate68}</td><td>（連携用）Ｄ用Ｖレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate69 zrndyouvrate69}</td><td>（連携用）Ｄ用Ｖレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate70 zrndyouvrate70}</td><td>（連携用）Ｄ用Ｖレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate71 zrndyouvrate71}</td><td>（連携用）Ｄ用Ｖレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate72 zrndyouvrate72}</td><td>（連携用）Ｄ用Ｖレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate73 zrndyouvrate73}</td><td>（連携用）Ｄ用Ｖレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate74 zrndyouvrate74}</td><td>（連携用）Ｄ用Ｖレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate75 zrndyouvrate75}</td><td>（連携用）Ｄ用Ｖレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate76 zrndyouvrate76}</td><td>（連携用）Ｄ用Ｖレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate77 zrndyouvrate77}</td><td>（連携用）Ｄ用Ｖレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate78 zrndyouvrate78}</td><td>（連携用）Ｄ用Ｖレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate79 zrndyouvrate79}</td><td>（連携用）Ｄ用Ｖレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate80 zrndyouvrate80}</td><td>（連携用）Ｄ用Ｖレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate81 zrndyouvrate81}</td><td>（連携用）Ｄ用Ｖレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate82 zrndyouvrate82}</td><td>（連携用）Ｄ用Ｖレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate83 zrndyouvrate83}</td><td>（連携用）Ｄ用Ｖレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate84 zrndyouvrate84}</td><td>（連携用）Ｄ用Ｖレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate85 zrndyouvrate85}</td><td>（連携用）Ｄ用Ｖレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate86 zrndyouvrate86}</td><td>（連携用）Ｄ用Ｖレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate87 zrndyouvrate87}</td><td>（連携用）Ｄ用Ｖレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate88 zrndyouvrate88}</td><td>（連携用）Ｄ用Ｖレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate89 zrndyouvrate89}</td><td>（連携用）Ｄ用Ｖレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate90 zrndyouvrate90}</td><td>（連携用）Ｄ用Ｖレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate91 zrndyouvrate91}</td><td>（連携用）Ｄ用Ｖレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate92 zrndyouvrate92}</td><td>（連携用）Ｄ用Ｖレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate93 zrndyouvrate93}</td><td>（連携用）Ｄ用Ｖレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate94 zrndyouvrate94}</td><td>（連携用）Ｄ用Ｖレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate95 zrndyouvrate95}</td><td>（連携用）Ｄ用Ｖレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate96 zrndyouvrate96}</td><td>（連携用）Ｄ用Ｖレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate97 zrndyouvrate97}</td><td>（連携用）Ｄ用Ｖレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate98 zrndyouvrate98}</td><td>（連携用）Ｄ用Ｖレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrndyouvrate99 zrndyouvrate99}</td><td>（連携用）Ｄ用Ｖレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate00 zrnkikensrate00}</td><td>（連携用）危険Ｓレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate01 zrnkikensrate01}</td><td>（連携用）危険Ｓレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate02 zrnkikensrate02}</td><td>（連携用）危険Ｓレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate03 zrnkikensrate03}</td><td>（連携用）危険Ｓレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate04 zrnkikensrate04}</td><td>（連携用）危険Ｓレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate05 zrnkikensrate05}</td><td>（連携用）危険Ｓレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate06 zrnkikensrate06}</td><td>（連携用）危険Ｓレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate07 zrnkikensrate07}</td><td>（連携用）危険Ｓレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate08 zrnkikensrate08}</td><td>（連携用）危険Ｓレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate09 zrnkikensrate09}</td><td>（連携用）危険Ｓレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate10 zrnkikensrate10}</td><td>（連携用）危険Ｓレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate11 zrnkikensrate11}</td><td>（連携用）危険Ｓレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate12 zrnkikensrate12}</td><td>（連携用）危険Ｓレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate13 zrnkikensrate13}</td><td>（連携用）危険Ｓレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate14 zrnkikensrate14}</td><td>（連携用）危険Ｓレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate15 zrnkikensrate15}</td><td>（連携用）危険Ｓレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate16 zrnkikensrate16}</td><td>（連携用）危険Ｓレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate17 zrnkikensrate17}</td><td>（連携用）危険Ｓレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate18 zrnkikensrate18}</td><td>（連携用）危険Ｓレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate19 zrnkikensrate19}</td><td>（連携用）危険Ｓレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate20 zrnkikensrate20}</td><td>（連携用）危険Ｓレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate21 zrnkikensrate21}</td><td>（連携用）危険Ｓレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate22 zrnkikensrate22}</td><td>（連携用）危険Ｓレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate23 zrnkikensrate23}</td><td>（連携用）危険Ｓレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate24 zrnkikensrate24}</td><td>（連携用）危険Ｓレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate25 zrnkikensrate25}</td><td>（連携用）危険Ｓレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate26 zrnkikensrate26}</td><td>（連携用）危険Ｓレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate27 zrnkikensrate27}</td><td>（連携用）危険Ｓレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate28 zrnkikensrate28}</td><td>（連携用）危険Ｓレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate29 zrnkikensrate29}</td><td>（連携用）危険Ｓレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate30 zrnkikensrate30}</td><td>（連携用）危険Ｓレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate31 zrnkikensrate31}</td><td>（連携用）危険Ｓレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate32 zrnkikensrate32}</td><td>（連携用）危険Ｓレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate33 zrnkikensrate33}</td><td>（連携用）危険Ｓレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate34 zrnkikensrate34}</td><td>（連携用）危険Ｓレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate35 zrnkikensrate35}</td><td>（連携用）危険Ｓレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate36 zrnkikensrate36}</td><td>（連携用）危険Ｓレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate37 zrnkikensrate37}</td><td>（連携用）危険Ｓレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate38 zrnkikensrate38}</td><td>（連携用）危険Ｓレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate39 zrnkikensrate39}</td><td>（連携用）危険Ｓレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate40 zrnkikensrate40}</td><td>（連携用）危険Ｓレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate41 zrnkikensrate41}</td><td>（連携用）危険Ｓレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate42 zrnkikensrate42}</td><td>（連携用）危険Ｓレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate43 zrnkikensrate43}</td><td>（連携用）危険Ｓレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate44 zrnkikensrate44}</td><td>（連携用）危険Ｓレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate45 zrnkikensrate45}</td><td>（連携用）危険Ｓレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate46 zrnkikensrate46}</td><td>（連携用）危険Ｓレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate47 zrnkikensrate47}</td><td>（連携用）危険Ｓレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate48 zrnkikensrate48}</td><td>（連携用）危険Ｓレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate49 zrnkikensrate49}</td><td>（連携用）危険Ｓレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate50 zrnkikensrate50}</td><td>（連携用）危険Ｓレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate51 zrnkikensrate51}</td><td>（連携用）危険Ｓレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate52 zrnkikensrate52}</td><td>（連携用）危険Ｓレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate53 zrnkikensrate53}</td><td>（連携用）危険Ｓレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate54 zrnkikensrate54}</td><td>（連携用）危険Ｓレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate55 zrnkikensrate55}</td><td>（連携用）危険Ｓレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate56 zrnkikensrate56}</td><td>（連携用）危険Ｓレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate57 zrnkikensrate57}</td><td>（連携用）危険Ｓレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate58 zrnkikensrate58}</td><td>（連携用）危険Ｓレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate59 zrnkikensrate59}</td><td>（連携用）危険Ｓレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate60 zrnkikensrate60}</td><td>（連携用）危険Ｓレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate61 zrnkikensrate61}</td><td>（連携用）危険Ｓレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate62 zrnkikensrate62}</td><td>（連携用）危険Ｓレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate63 zrnkikensrate63}</td><td>（連携用）危険Ｓレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate64 zrnkikensrate64}</td><td>（連携用）危険Ｓレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate65 zrnkikensrate65}</td><td>（連携用）危険Ｓレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate66 zrnkikensrate66}</td><td>（連携用）危険Ｓレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate67 zrnkikensrate67}</td><td>（連携用）危険Ｓレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate68 zrnkikensrate68}</td><td>（連携用）危険Ｓレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate69 zrnkikensrate69}</td><td>（連携用）危険Ｓレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate70 zrnkikensrate70}</td><td>（連携用）危険Ｓレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate71 zrnkikensrate71}</td><td>（連携用）危険Ｓレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate72 zrnkikensrate72}</td><td>（連携用）危険Ｓレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate73 zrnkikensrate73}</td><td>（連携用）危険Ｓレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate74 zrnkikensrate74}</td><td>（連携用）危険Ｓレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate75 zrnkikensrate75}</td><td>（連携用）危険Ｓレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate76 zrnkikensrate76}</td><td>（連携用）危険Ｓレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate77 zrnkikensrate77}</td><td>（連携用）危険Ｓレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate78 zrnkikensrate78}</td><td>（連携用）危険Ｓレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate79 zrnkikensrate79}</td><td>（連携用）危険Ｓレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate80 zrnkikensrate80}</td><td>（連携用）危険Ｓレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate81 zrnkikensrate81}</td><td>（連携用）危険Ｓレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate82 zrnkikensrate82}</td><td>（連携用）危険Ｓレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate83 zrnkikensrate83}</td><td>（連携用）危険Ｓレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate84 zrnkikensrate84}</td><td>（連携用）危険Ｓレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate85 zrnkikensrate85}</td><td>（連携用）危険Ｓレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate86 zrnkikensrate86}</td><td>（連携用）危険Ｓレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate87 zrnkikensrate87}</td><td>（連携用）危険Ｓレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate88 zrnkikensrate88}</td><td>（連携用）危険Ｓレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate89 zrnkikensrate89}</td><td>（連携用）危険Ｓレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate90 zrnkikensrate90}</td><td>（連携用）危険Ｓレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate91 zrnkikensrate91}</td><td>（連携用）危険Ｓレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate92 zrnkikensrate92}</td><td>（連携用）危険Ｓレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate93 zrnkikensrate93}</td><td>（連携用）危険Ｓレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate94 zrnkikensrate94}</td><td>（連携用）危険Ｓレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate95 zrnkikensrate95}</td><td>（連携用）危険Ｓレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate96 zrnkikensrate96}</td><td>（連携用）危険Ｓレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate97 zrnkikensrate97}</td><td>（連携用）危険Ｓレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate98 zrnkikensrate98}</td><td>（連携用）危険Ｓレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnkikensrate99 zrnkikensrate99}</td><td>（連携用）危険Ｓレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_RatedRn
 * @see     PKZT_RatedRn
 * @see     QZT_RatedRn
 * @see     GenQZT_RatedRn
 */
@MappedSuperclass
@Table(name=GenZT_RatedRn.TABLE_NAME)
@IdClass(value=PKZT_RatedRn.class)
public abstract class GenZT_RatedRn extends AbstractExDBEntityForZDB<ZT_RatedRn, PKZT_RatedRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RatedRn";
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
    public static final String ZRNDNENDO                = "zrndnendo";
    public static final String ZRNNAITEIKAKUTEIKBN      = "zrnnaiteikakuteikbn";
    public static final String ZRNDRATE00               = "zrndrate00";
    public static final String ZRNDRATE01               = "zrndrate01";
    public static final String ZRNDRATE02               = "zrndrate02";
    public static final String ZRNDRATE03               = "zrndrate03";
    public static final String ZRNDRATE04               = "zrndrate04";
    public static final String ZRNDRATE05               = "zrndrate05";
    public static final String ZRNDRATE06               = "zrndrate06";
    public static final String ZRNDRATE07               = "zrndrate07";
    public static final String ZRNDRATE08               = "zrndrate08";
    public static final String ZRNDRATE09               = "zrndrate09";
    public static final String ZRNDRATE10               = "zrndrate10";
    public static final String ZRNDRATE11               = "zrndrate11";
    public static final String ZRNDRATE12               = "zrndrate12";
    public static final String ZRNDRATE13               = "zrndrate13";
    public static final String ZRNDRATE14               = "zrndrate14";
    public static final String ZRNDRATE15               = "zrndrate15";
    public static final String ZRNDRATE16               = "zrndrate16";
    public static final String ZRNDRATE17               = "zrndrate17";
    public static final String ZRNDRATE18               = "zrndrate18";
    public static final String ZRNDRATE19               = "zrndrate19";
    public static final String ZRNDRATE20               = "zrndrate20";
    public static final String ZRNDRATE21               = "zrndrate21";
    public static final String ZRNDRATE22               = "zrndrate22";
    public static final String ZRNDRATE23               = "zrndrate23";
    public static final String ZRNDRATE24               = "zrndrate24";
    public static final String ZRNDRATE25               = "zrndrate25";
    public static final String ZRNDRATE26               = "zrndrate26";
    public static final String ZRNDRATE27               = "zrndrate27";
    public static final String ZRNDRATE28               = "zrndrate28";
    public static final String ZRNDRATE29               = "zrndrate29";
    public static final String ZRNDRATE30               = "zrndrate30";
    public static final String ZRNDRATE31               = "zrndrate31";
    public static final String ZRNDRATE32               = "zrndrate32";
    public static final String ZRNDRATE33               = "zrndrate33";
    public static final String ZRNDRATE34               = "zrndrate34";
    public static final String ZRNDRATE35               = "zrndrate35";
    public static final String ZRNDRATE36               = "zrndrate36";
    public static final String ZRNDRATE37               = "zrndrate37";
    public static final String ZRNDRATE38               = "zrndrate38";
    public static final String ZRNDRATE39               = "zrndrate39";
    public static final String ZRNDRATE40               = "zrndrate40";
    public static final String ZRNDRATE41               = "zrndrate41";
    public static final String ZRNDRATE42               = "zrndrate42";
    public static final String ZRNDRATE43               = "zrndrate43";
    public static final String ZRNDRATE44               = "zrndrate44";
    public static final String ZRNDRATE45               = "zrndrate45";
    public static final String ZRNDRATE46               = "zrndrate46";
    public static final String ZRNDRATE47               = "zrndrate47";
    public static final String ZRNDRATE48               = "zrndrate48";
    public static final String ZRNDRATE49               = "zrndrate49";
    public static final String ZRNDRATE50               = "zrndrate50";
    public static final String ZRNDRATE51               = "zrndrate51";
    public static final String ZRNDRATE52               = "zrndrate52";
    public static final String ZRNDRATE53               = "zrndrate53";
    public static final String ZRNDRATE54               = "zrndrate54";
    public static final String ZRNDRATE55               = "zrndrate55";
    public static final String ZRNDRATE56               = "zrndrate56";
    public static final String ZRNDRATE57               = "zrndrate57";
    public static final String ZRNDRATE58               = "zrndrate58";
    public static final String ZRNDRATE59               = "zrndrate59";
    public static final String ZRNDRATE60               = "zrndrate60";
    public static final String ZRNDRATE61               = "zrndrate61";
    public static final String ZRNDRATE62               = "zrndrate62";
    public static final String ZRNDRATE63               = "zrndrate63";
    public static final String ZRNDRATE64               = "zrndrate64";
    public static final String ZRNDRATE65               = "zrndrate65";
    public static final String ZRNDRATE66               = "zrndrate66";
    public static final String ZRNDRATE67               = "zrndrate67";
    public static final String ZRNDRATE68               = "zrndrate68";
    public static final String ZRNDRATE69               = "zrndrate69";
    public static final String ZRNDRATE70               = "zrndrate70";
    public static final String ZRNDRATE71               = "zrndrate71";
    public static final String ZRNDRATE72               = "zrndrate72";
    public static final String ZRNDRATE73               = "zrndrate73";
    public static final String ZRNDRATE74               = "zrndrate74";
    public static final String ZRNDRATE75               = "zrndrate75";
    public static final String ZRNDRATE76               = "zrndrate76";
    public static final String ZRNDRATE77               = "zrndrate77";
    public static final String ZRNDRATE78               = "zrndrate78";
    public static final String ZRNDRATE79               = "zrndrate79";
    public static final String ZRNDRATE80               = "zrndrate80";
    public static final String ZRNDRATE81               = "zrndrate81";
    public static final String ZRNDRATE82               = "zrndrate82";
    public static final String ZRNDRATE83               = "zrndrate83";
    public static final String ZRNDRATE84               = "zrndrate84";
    public static final String ZRNDRATE85               = "zrndrate85";
    public static final String ZRNDRATE86               = "zrndrate86";
    public static final String ZRNDRATE87               = "zrndrate87";
    public static final String ZRNDRATE88               = "zrndrate88";
    public static final String ZRNDRATE89               = "zrndrate89";
    public static final String ZRNDRATE90               = "zrndrate90";
    public static final String ZRNDRATE91               = "zrndrate91";
    public static final String ZRNDRATE92               = "zrndrate92";
    public static final String ZRNDRATE93               = "zrndrate93";
    public static final String ZRNDRATE94               = "zrndrate94";
    public static final String ZRNDRATE95               = "zrndrate95";
    public static final String ZRNDRATE96               = "zrndrate96";
    public static final String ZRNDRATE97               = "zrndrate97";
    public static final String ZRNDRATE98               = "zrndrate98";
    public static final String ZRNDRATE99               = "zrndrate99";
    public static final String ZRNSISADRATE00           = "zrnsisadrate00";
    public static final String ZRNSISADRATE01           = "zrnsisadrate01";
    public static final String ZRNSISADRATE02           = "zrnsisadrate02";
    public static final String ZRNSISADRATE03           = "zrnsisadrate03";
    public static final String ZRNSISADRATE04           = "zrnsisadrate04";
    public static final String ZRNSISADRATE05           = "zrnsisadrate05";
    public static final String ZRNSISADRATE06           = "zrnsisadrate06";
    public static final String ZRNSISADRATE07           = "zrnsisadrate07";
    public static final String ZRNSISADRATE08           = "zrnsisadrate08";
    public static final String ZRNSISADRATE09           = "zrnsisadrate09";
    public static final String ZRNSISADRATE10           = "zrnsisadrate10";
    public static final String ZRNSISADRATE11           = "zrnsisadrate11";
    public static final String ZRNSISADRATE12           = "zrnsisadrate12";
    public static final String ZRNSISADRATE13           = "zrnsisadrate13";
    public static final String ZRNSISADRATE14           = "zrnsisadrate14";
    public static final String ZRNSISADRATE15           = "zrnsisadrate15";
    public static final String ZRNSISADRATE16           = "zrnsisadrate16";
    public static final String ZRNSISADRATE17           = "zrnsisadrate17";
    public static final String ZRNSISADRATE18           = "zrnsisadrate18";
    public static final String ZRNSISADRATE19           = "zrnsisadrate19";
    public static final String ZRNSISADRATE20           = "zrnsisadrate20";
    public static final String ZRNSISADRATE21           = "zrnsisadrate21";
    public static final String ZRNSISADRATE22           = "zrnsisadrate22";
    public static final String ZRNSISADRATE23           = "zrnsisadrate23";
    public static final String ZRNSISADRATE24           = "zrnsisadrate24";
    public static final String ZRNSISADRATE25           = "zrnsisadrate25";
    public static final String ZRNSISADRATE26           = "zrnsisadrate26";
    public static final String ZRNSISADRATE27           = "zrnsisadrate27";
    public static final String ZRNSISADRATE28           = "zrnsisadrate28";
    public static final String ZRNSISADRATE29           = "zrnsisadrate29";
    public static final String ZRNSISADRATE30           = "zrnsisadrate30";
    public static final String ZRNSISADRATE31           = "zrnsisadrate31";
    public static final String ZRNSISADRATE32           = "zrnsisadrate32";
    public static final String ZRNSISADRATE33           = "zrnsisadrate33";
    public static final String ZRNSISADRATE34           = "zrnsisadrate34";
    public static final String ZRNSISADRATE35           = "zrnsisadrate35";
    public static final String ZRNSISADRATE36           = "zrnsisadrate36";
    public static final String ZRNSISADRATE37           = "zrnsisadrate37";
    public static final String ZRNSISADRATE38           = "zrnsisadrate38";
    public static final String ZRNSISADRATE39           = "zrnsisadrate39";
    public static final String ZRNSISADRATE40           = "zrnsisadrate40";
    public static final String ZRNSISADRATE41           = "zrnsisadrate41";
    public static final String ZRNSISADRATE42           = "zrnsisadrate42";
    public static final String ZRNSISADRATE43           = "zrnsisadrate43";
    public static final String ZRNSISADRATE44           = "zrnsisadrate44";
    public static final String ZRNSISADRATE45           = "zrnsisadrate45";
    public static final String ZRNSISADRATE46           = "zrnsisadrate46";
    public static final String ZRNSISADRATE47           = "zrnsisadrate47";
    public static final String ZRNSISADRATE48           = "zrnsisadrate48";
    public static final String ZRNSISADRATE49           = "zrnsisadrate49";
    public static final String ZRNSISADRATE50           = "zrnsisadrate50";
    public static final String ZRNSISADRATE51           = "zrnsisadrate51";
    public static final String ZRNSISADRATE52           = "zrnsisadrate52";
    public static final String ZRNSISADRATE53           = "zrnsisadrate53";
    public static final String ZRNSISADRATE54           = "zrnsisadrate54";
    public static final String ZRNSISADRATE55           = "zrnsisadrate55";
    public static final String ZRNSISADRATE56           = "zrnsisadrate56";
    public static final String ZRNSISADRATE57           = "zrnsisadrate57";
    public static final String ZRNSISADRATE58           = "zrnsisadrate58";
    public static final String ZRNSISADRATE59           = "zrnsisadrate59";
    public static final String ZRNSISADRATE60           = "zrnsisadrate60";
    public static final String ZRNSISADRATE61           = "zrnsisadrate61";
    public static final String ZRNSISADRATE62           = "zrnsisadrate62";
    public static final String ZRNSISADRATE63           = "zrnsisadrate63";
    public static final String ZRNSISADRATE64           = "zrnsisadrate64";
    public static final String ZRNSISADRATE65           = "zrnsisadrate65";
    public static final String ZRNSISADRATE66           = "zrnsisadrate66";
    public static final String ZRNSISADRATE67           = "zrnsisadrate67";
    public static final String ZRNSISADRATE68           = "zrnsisadrate68";
    public static final String ZRNSISADRATE69           = "zrnsisadrate69";
    public static final String ZRNSISADRATE70           = "zrnsisadrate70";
    public static final String ZRNSISADRATE71           = "zrnsisadrate71";
    public static final String ZRNSISADRATE72           = "zrnsisadrate72";
    public static final String ZRNSISADRATE73           = "zrnsisadrate73";
    public static final String ZRNSISADRATE74           = "zrnsisadrate74";
    public static final String ZRNSISADRATE75           = "zrnsisadrate75";
    public static final String ZRNSISADRATE76           = "zrnsisadrate76";
    public static final String ZRNSISADRATE77           = "zrnsisadrate77";
    public static final String ZRNSISADRATE78           = "zrnsisadrate78";
    public static final String ZRNSISADRATE79           = "zrnsisadrate79";
    public static final String ZRNSISADRATE80           = "zrnsisadrate80";
    public static final String ZRNSISADRATE81           = "zrnsisadrate81";
    public static final String ZRNSISADRATE82           = "zrnsisadrate82";
    public static final String ZRNSISADRATE83           = "zrnsisadrate83";
    public static final String ZRNSISADRATE84           = "zrnsisadrate84";
    public static final String ZRNSISADRATE85           = "zrnsisadrate85";
    public static final String ZRNSISADRATE86           = "zrnsisadrate86";
    public static final String ZRNSISADRATE87           = "zrnsisadrate87";
    public static final String ZRNSISADRATE88           = "zrnsisadrate88";
    public static final String ZRNSISADRATE89           = "zrnsisadrate89";
    public static final String ZRNSISADRATE90           = "zrnsisadrate90";
    public static final String ZRNSISADRATE91           = "zrnsisadrate91";
    public static final String ZRNSISADRATE92           = "zrnsisadrate92";
    public static final String ZRNSISADRATE93           = "zrnsisadrate93";
    public static final String ZRNSISADRATE94           = "zrnsisadrate94";
    public static final String ZRNSISADRATE95           = "zrnsisadrate95";
    public static final String ZRNSISADRATE96           = "zrnsisadrate96";
    public static final String ZRNSISADRATE97           = "zrnsisadrate97";
    public static final String ZRNSISADRATE98           = "zrnsisadrate98";
    public static final String ZRNSISADRATE99           = "zrnsisadrate99";
    public static final String ZRNRISADRATE00           = "zrnrisadrate00";
    public static final String ZRNRISADRATE01           = "zrnrisadrate01";
    public static final String ZRNRISADRATE02           = "zrnrisadrate02";
    public static final String ZRNRISADRATE03           = "zrnrisadrate03";
    public static final String ZRNRISADRATE04           = "zrnrisadrate04";
    public static final String ZRNRISADRATE05           = "zrnrisadrate05";
    public static final String ZRNRISADRATE06           = "zrnrisadrate06";
    public static final String ZRNRISADRATE07           = "zrnrisadrate07";
    public static final String ZRNRISADRATE08           = "zrnrisadrate08";
    public static final String ZRNRISADRATE09           = "zrnrisadrate09";
    public static final String ZRNRISADRATE10           = "zrnrisadrate10";
    public static final String ZRNRISADRATE11           = "zrnrisadrate11";
    public static final String ZRNRISADRATE12           = "zrnrisadrate12";
    public static final String ZRNRISADRATE13           = "zrnrisadrate13";
    public static final String ZRNRISADRATE14           = "zrnrisadrate14";
    public static final String ZRNRISADRATE15           = "zrnrisadrate15";
    public static final String ZRNRISADRATE16           = "zrnrisadrate16";
    public static final String ZRNRISADRATE17           = "zrnrisadrate17";
    public static final String ZRNRISADRATE18           = "zrnrisadrate18";
    public static final String ZRNRISADRATE19           = "zrnrisadrate19";
    public static final String ZRNRISADRATE20           = "zrnrisadrate20";
    public static final String ZRNRISADRATE21           = "zrnrisadrate21";
    public static final String ZRNRISADRATE22           = "zrnrisadrate22";
    public static final String ZRNRISADRATE23           = "zrnrisadrate23";
    public static final String ZRNRISADRATE24           = "zrnrisadrate24";
    public static final String ZRNRISADRATE25           = "zrnrisadrate25";
    public static final String ZRNRISADRATE26           = "zrnrisadrate26";
    public static final String ZRNRISADRATE27           = "zrnrisadrate27";
    public static final String ZRNRISADRATE28           = "zrnrisadrate28";
    public static final String ZRNRISADRATE29           = "zrnrisadrate29";
    public static final String ZRNRISADRATE30           = "zrnrisadrate30";
    public static final String ZRNRISADRATE31           = "zrnrisadrate31";
    public static final String ZRNRISADRATE32           = "zrnrisadrate32";
    public static final String ZRNRISADRATE33           = "zrnrisadrate33";
    public static final String ZRNRISADRATE34           = "zrnrisadrate34";
    public static final String ZRNRISADRATE35           = "zrnrisadrate35";
    public static final String ZRNRISADRATE36           = "zrnrisadrate36";
    public static final String ZRNRISADRATE37           = "zrnrisadrate37";
    public static final String ZRNRISADRATE38           = "zrnrisadrate38";
    public static final String ZRNRISADRATE39           = "zrnrisadrate39";
    public static final String ZRNRISADRATE40           = "zrnrisadrate40";
    public static final String ZRNRISADRATE41           = "zrnrisadrate41";
    public static final String ZRNRISADRATE42           = "zrnrisadrate42";
    public static final String ZRNRISADRATE43           = "zrnrisadrate43";
    public static final String ZRNRISADRATE44           = "zrnrisadrate44";
    public static final String ZRNRISADRATE45           = "zrnrisadrate45";
    public static final String ZRNRISADRATE46           = "zrnrisadrate46";
    public static final String ZRNRISADRATE47           = "zrnrisadrate47";
    public static final String ZRNRISADRATE48           = "zrnrisadrate48";
    public static final String ZRNRISADRATE49           = "zrnrisadrate49";
    public static final String ZRNRISADRATE50           = "zrnrisadrate50";
    public static final String ZRNRISADRATE51           = "zrnrisadrate51";
    public static final String ZRNRISADRATE52           = "zrnrisadrate52";
    public static final String ZRNRISADRATE53           = "zrnrisadrate53";
    public static final String ZRNRISADRATE54           = "zrnrisadrate54";
    public static final String ZRNRISADRATE55           = "zrnrisadrate55";
    public static final String ZRNRISADRATE56           = "zrnrisadrate56";
    public static final String ZRNRISADRATE57           = "zrnrisadrate57";
    public static final String ZRNRISADRATE58           = "zrnrisadrate58";
    public static final String ZRNRISADRATE59           = "zrnrisadrate59";
    public static final String ZRNRISADRATE60           = "zrnrisadrate60";
    public static final String ZRNRISADRATE61           = "zrnrisadrate61";
    public static final String ZRNRISADRATE62           = "zrnrisadrate62";
    public static final String ZRNRISADRATE63           = "zrnrisadrate63";
    public static final String ZRNRISADRATE64           = "zrnrisadrate64";
    public static final String ZRNRISADRATE65           = "zrnrisadrate65";
    public static final String ZRNRISADRATE66           = "zrnrisadrate66";
    public static final String ZRNRISADRATE67           = "zrnrisadrate67";
    public static final String ZRNRISADRATE68           = "zrnrisadrate68";
    public static final String ZRNRISADRATE69           = "zrnrisadrate69";
    public static final String ZRNRISADRATE70           = "zrnrisadrate70";
    public static final String ZRNRISADRATE71           = "zrnrisadrate71";
    public static final String ZRNRISADRATE72           = "zrnrisadrate72";
    public static final String ZRNRISADRATE73           = "zrnrisadrate73";
    public static final String ZRNRISADRATE74           = "zrnrisadrate74";
    public static final String ZRNRISADRATE75           = "zrnrisadrate75";
    public static final String ZRNRISADRATE76           = "zrnrisadrate76";
    public static final String ZRNRISADRATE77           = "zrnrisadrate77";
    public static final String ZRNRISADRATE78           = "zrnrisadrate78";
    public static final String ZRNRISADRATE79           = "zrnrisadrate79";
    public static final String ZRNRISADRATE80           = "zrnrisadrate80";
    public static final String ZRNRISADRATE81           = "zrnrisadrate81";
    public static final String ZRNRISADRATE82           = "zrnrisadrate82";
    public static final String ZRNRISADRATE83           = "zrnrisadrate83";
    public static final String ZRNRISADRATE84           = "zrnrisadrate84";
    public static final String ZRNRISADRATE85           = "zrnrisadrate85";
    public static final String ZRNRISADRATE86           = "zrnrisadrate86";
    public static final String ZRNRISADRATE87           = "zrnrisadrate87";
    public static final String ZRNRISADRATE88           = "zrnrisadrate88";
    public static final String ZRNRISADRATE89           = "zrnrisadrate89";
    public static final String ZRNRISADRATE90           = "zrnrisadrate90";
    public static final String ZRNRISADRATE91           = "zrnrisadrate91";
    public static final String ZRNRISADRATE92           = "zrnrisadrate92";
    public static final String ZRNRISADRATE93           = "zrnrisadrate93";
    public static final String ZRNRISADRATE94           = "zrnrisadrate94";
    public static final String ZRNRISADRATE95           = "zrnrisadrate95";
    public static final String ZRNRISADRATE96           = "zrnrisadrate96";
    public static final String ZRNRISADRATE97           = "zrnrisadrate97";
    public static final String ZRNRISADRATE98           = "zrnrisadrate98";
    public static final String ZRNRISADRATE99           = "zrnrisadrate99";
    public static final String ZRNHISADRATE00           = "zrnhisadrate00";
    public static final String ZRNHISADRATE01           = "zrnhisadrate01";
    public static final String ZRNHISADRATE02           = "zrnhisadrate02";
    public static final String ZRNHISADRATE03           = "zrnhisadrate03";
    public static final String ZRNHISADRATE04           = "zrnhisadrate04";
    public static final String ZRNHISADRATE05           = "zrnhisadrate05";
    public static final String ZRNHISADRATE06           = "zrnhisadrate06";
    public static final String ZRNHISADRATE07           = "zrnhisadrate07";
    public static final String ZRNHISADRATE08           = "zrnhisadrate08";
    public static final String ZRNHISADRATE09           = "zrnhisadrate09";
    public static final String ZRNHISADRATE10           = "zrnhisadrate10";
    public static final String ZRNHISADRATE11           = "zrnhisadrate11";
    public static final String ZRNHISADRATE12           = "zrnhisadrate12";
    public static final String ZRNHISADRATE13           = "zrnhisadrate13";
    public static final String ZRNHISADRATE14           = "zrnhisadrate14";
    public static final String ZRNHISADRATE15           = "zrnhisadrate15";
    public static final String ZRNHISADRATE16           = "zrnhisadrate16";
    public static final String ZRNHISADRATE17           = "zrnhisadrate17";
    public static final String ZRNHISADRATE18           = "zrnhisadrate18";
    public static final String ZRNHISADRATE19           = "zrnhisadrate19";
    public static final String ZRNHISADRATE20           = "zrnhisadrate20";
    public static final String ZRNHISADRATE21           = "zrnhisadrate21";
    public static final String ZRNHISADRATE22           = "zrnhisadrate22";
    public static final String ZRNHISADRATE23           = "zrnhisadrate23";
    public static final String ZRNHISADRATE24           = "zrnhisadrate24";
    public static final String ZRNHISADRATE25           = "zrnhisadrate25";
    public static final String ZRNHISADRATE26           = "zrnhisadrate26";
    public static final String ZRNHISADRATE27           = "zrnhisadrate27";
    public static final String ZRNHISADRATE28           = "zrnhisadrate28";
    public static final String ZRNHISADRATE29           = "zrnhisadrate29";
    public static final String ZRNHISADRATE30           = "zrnhisadrate30";
    public static final String ZRNHISADRATE31           = "zrnhisadrate31";
    public static final String ZRNHISADRATE32           = "zrnhisadrate32";
    public static final String ZRNHISADRATE33           = "zrnhisadrate33";
    public static final String ZRNHISADRATE34           = "zrnhisadrate34";
    public static final String ZRNHISADRATE35           = "zrnhisadrate35";
    public static final String ZRNHISADRATE36           = "zrnhisadrate36";
    public static final String ZRNHISADRATE37           = "zrnhisadrate37";
    public static final String ZRNHISADRATE38           = "zrnhisadrate38";
    public static final String ZRNHISADRATE39           = "zrnhisadrate39";
    public static final String ZRNHISADRATE40           = "zrnhisadrate40";
    public static final String ZRNHISADRATE41           = "zrnhisadrate41";
    public static final String ZRNHISADRATE42           = "zrnhisadrate42";
    public static final String ZRNHISADRATE43           = "zrnhisadrate43";
    public static final String ZRNHISADRATE44           = "zrnhisadrate44";
    public static final String ZRNHISADRATE45           = "zrnhisadrate45";
    public static final String ZRNHISADRATE46           = "zrnhisadrate46";
    public static final String ZRNHISADRATE47           = "zrnhisadrate47";
    public static final String ZRNHISADRATE48           = "zrnhisadrate48";
    public static final String ZRNHISADRATE49           = "zrnhisadrate49";
    public static final String ZRNHISADRATE50           = "zrnhisadrate50";
    public static final String ZRNHISADRATE51           = "zrnhisadrate51";
    public static final String ZRNHISADRATE52           = "zrnhisadrate52";
    public static final String ZRNHISADRATE53           = "zrnhisadrate53";
    public static final String ZRNHISADRATE54           = "zrnhisadrate54";
    public static final String ZRNHISADRATE55           = "zrnhisadrate55";
    public static final String ZRNHISADRATE56           = "zrnhisadrate56";
    public static final String ZRNHISADRATE57           = "zrnhisadrate57";
    public static final String ZRNHISADRATE58           = "zrnhisadrate58";
    public static final String ZRNHISADRATE59           = "zrnhisadrate59";
    public static final String ZRNHISADRATE60           = "zrnhisadrate60";
    public static final String ZRNHISADRATE61           = "zrnhisadrate61";
    public static final String ZRNHISADRATE62           = "zrnhisadrate62";
    public static final String ZRNHISADRATE63           = "zrnhisadrate63";
    public static final String ZRNHISADRATE64           = "zrnhisadrate64";
    public static final String ZRNHISADRATE65           = "zrnhisadrate65";
    public static final String ZRNHISADRATE66           = "zrnhisadrate66";
    public static final String ZRNHISADRATE67           = "zrnhisadrate67";
    public static final String ZRNHISADRATE68           = "zrnhisadrate68";
    public static final String ZRNHISADRATE69           = "zrnhisadrate69";
    public static final String ZRNHISADRATE70           = "zrnhisadrate70";
    public static final String ZRNHISADRATE71           = "zrnhisadrate71";
    public static final String ZRNHISADRATE72           = "zrnhisadrate72";
    public static final String ZRNHISADRATE73           = "zrnhisadrate73";
    public static final String ZRNHISADRATE74           = "zrnhisadrate74";
    public static final String ZRNHISADRATE75           = "zrnhisadrate75";
    public static final String ZRNHISADRATE76           = "zrnhisadrate76";
    public static final String ZRNHISADRATE77           = "zrnhisadrate77";
    public static final String ZRNHISADRATE78           = "zrnhisadrate78";
    public static final String ZRNHISADRATE79           = "zrnhisadrate79";
    public static final String ZRNHISADRATE80           = "zrnhisadrate80";
    public static final String ZRNHISADRATE81           = "zrnhisadrate81";
    public static final String ZRNHISADRATE82           = "zrnhisadrate82";
    public static final String ZRNHISADRATE83           = "zrnhisadrate83";
    public static final String ZRNHISADRATE84           = "zrnhisadrate84";
    public static final String ZRNHISADRATE85           = "zrnhisadrate85";
    public static final String ZRNHISADRATE86           = "zrnhisadrate86";
    public static final String ZRNHISADRATE87           = "zrnhisadrate87";
    public static final String ZRNHISADRATE88           = "zrnhisadrate88";
    public static final String ZRNHISADRATE89           = "zrnhisadrate89";
    public static final String ZRNHISADRATE90           = "zrnhisadrate90";
    public static final String ZRNHISADRATE91           = "zrnhisadrate91";
    public static final String ZRNHISADRATE92           = "zrnhisadrate92";
    public static final String ZRNHISADRATE93           = "zrnhisadrate93";
    public static final String ZRNHISADRATE94           = "zrnhisadrate94";
    public static final String ZRNHISADRATE95           = "zrnhisadrate95";
    public static final String ZRNHISADRATE96           = "zrnhisadrate96";
    public static final String ZRNHISADRATE97           = "zrnhisadrate97";
    public static final String ZRNHISADRATE98           = "zrnhisadrate98";
    public static final String ZRNHISADRATE99           = "zrnhisadrate99";
    public static final String ZRNDYOUVRATE00           = "zrndyouvrate00";
    public static final String ZRNDYOUVRATE01           = "zrndyouvrate01";
    public static final String ZRNDYOUVRATE02           = "zrndyouvrate02";
    public static final String ZRNDYOUVRATE03           = "zrndyouvrate03";
    public static final String ZRNDYOUVRATE04           = "zrndyouvrate04";
    public static final String ZRNDYOUVRATE05           = "zrndyouvrate05";
    public static final String ZRNDYOUVRATE06           = "zrndyouvrate06";
    public static final String ZRNDYOUVRATE07           = "zrndyouvrate07";
    public static final String ZRNDYOUVRATE08           = "zrndyouvrate08";
    public static final String ZRNDYOUVRATE09           = "zrndyouvrate09";
    public static final String ZRNDYOUVRATE10           = "zrndyouvrate10";
    public static final String ZRNDYOUVRATE11           = "zrndyouvrate11";
    public static final String ZRNDYOUVRATE12           = "zrndyouvrate12";
    public static final String ZRNDYOUVRATE13           = "zrndyouvrate13";
    public static final String ZRNDYOUVRATE14           = "zrndyouvrate14";
    public static final String ZRNDYOUVRATE15           = "zrndyouvrate15";
    public static final String ZRNDYOUVRATE16           = "zrndyouvrate16";
    public static final String ZRNDYOUVRATE17           = "zrndyouvrate17";
    public static final String ZRNDYOUVRATE18           = "zrndyouvrate18";
    public static final String ZRNDYOUVRATE19           = "zrndyouvrate19";
    public static final String ZRNDYOUVRATE20           = "zrndyouvrate20";
    public static final String ZRNDYOUVRATE21           = "zrndyouvrate21";
    public static final String ZRNDYOUVRATE22           = "zrndyouvrate22";
    public static final String ZRNDYOUVRATE23           = "zrndyouvrate23";
    public static final String ZRNDYOUVRATE24           = "zrndyouvrate24";
    public static final String ZRNDYOUVRATE25           = "zrndyouvrate25";
    public static final String ZRNDYOUVRATE26           = "zrndyouvrate26";
    public static final String ZRNDYOUVRATE27           = "zrndyouvrate27";
    public static final String ZRNDYOUVRATE28           = "zrndyouvrate28";
    public static final String ZRNDYOUVRATE29           = "zrndyouvrate29";
    public static final String ZRNDYOUVRATE30           = "zrndyouvrate30";
    public static final String ZRNDYOUVRATE31           = "zrndyouvrate31";
    public static final String ZRNDYOUVRATE32           = "zrndyouvrate32";
    public static final String ZRNDYOUVRATE33           = "zrndyouvrate33";
    public static final String ZRNDYOUVRATE34           = "zrndyouvrate34";
    public static final String ZRNDYOUVRATE35           = "zrndyouvrate35";
    public static final String ZRNDYOUVRATE36           = "zrndyouvrate36";
    public static final String ZRNDYOUVRATE37           = "zrndyouvrate37";
    public static final String ZRNDYOUVRATE38           = "zrndyouvrate38";
    public static final String ZRNDYOUVRATE39           = "zrndyouvrate39";
    public static final String ZRNDYOUVRATE40           = "zrndyouvrate40";
    public static final String ZRNDYOUVRATE41           = "zrndyouvrate41";
    public static final String ZRNDYOUVRATE42           = "zrndyouvrate42";
    public static final String ZRNDYOUVRATE43           = "zrndyouvrate43";
    public static final String ZRNDYOUVRATE44           = "zrndyouvrate44";
    public static final String ZRNDYOUVRATE45           = "zrndyouvrate45";
    public static final String ZRNDYOUVRATE46           = "zrndyouvrate46";
    public static final String ZRNDYOUVRATE47           = "zrndyouvrate47";
    public static final String ZRNDYOUVRATE48           = "zrndyouvrate48";
    public static final String ZRNDYOUVRATE49           = "zrndyouvrate49";
    public static final String ZRNDYOUVRATE50           = "zrndyouvrate50";
    public static final String ZRNDYOUVRATE51           = "zrndyouvrate51";
    public static final String ZRNDYOUVRATE52           = "zrndyouvrate52";
    public static final String ZRNDYOUVRATE53           = "zrndyouvrate53";
    public static final String ZRNDYOUVRATE54           = "zrndyouvrate54";
    public static final String ZRNDYOUVRATE55           = "zrndyouvrate55";
    public static final String ZRNDYOUVRATE56           = "zrndyouvrate56";
    public static final String ZRNDYOUVRATE57           = "zrndyouvrate57";
    public static final String ZRNDYOUVRATE58           = "zrndyouvrate58";
    public static final String ZRNDYOUVRATE59           = "zrndyouvrate59";
    public static final String ZRNDYOUVRATE60           = "zrndyouvrate60";
    public static final String ZRNDYOUVRATE61           = "zrndyouvrate61";
    public static final String ZRNDYOUVRATE62           = "zrndyouvrate62";
    public static final String ZRNDYOUVRATE63           = "zrndyouvrate63";
    public static final String ZRNDYOUVRATE64           = "zrndyouvrate64";
    public static final String ZRNDYOUVRATE65           = "zrndyouvrate65";
    public static final String ZRNDYOUVRATE66           = "zrndyouvrate66";
    public static final String ZRNDYOUVRATE67           = "zrndyouvrate67";
    public static final String ZRNDYOUVRATE68           = "zrndyouvrate68";
    public static final String ZRNDYOUVRATE69           = "zrndyouvrate69";
    public static final String ZRNDYOUVRATE70           = "zrndyouvrate70";
    public static final String ZRNDYOUVRATE71           = "zrndyouvrate71";
    public static final String ZRNDYOUVRATE72           = "zrndyouvrate72";
    public static final String ZRNDYOUVRATE73           = "zrndyouvrate73";
    public static final String ZRNDYOUVRATE74           = "zrndyouvrate74";
    public static final String ZRNDYOUVRATE75           = "zrndyouvrate75";
    public static final String ZRNDYOUVRATE76           = "zrndyouvrate76";
    public static final String ZRNDYOUVRATE77           = "zrndyouvrate77";
    public static final String ZRNDYOUVRATE78           = "zrndyouvrate78";
    public static final String ZRNDYOUVRATE79           = "zrndyouvrate79";
    public static final String ZRNDYOUVRATE80           = "zrndyouvrate80";
    public static final String ZRNDYOUVRATE81           = "zrndyouvrate81";
    public static final String ZRNDYOUVRATE82           = "zrndyouvrate82";
    public static final String ZRNDYOUVRATE83           = "zrndyouvrate83";
    public static final String ZRNDYOUVRATE84           = "zrndyouvrate84";
    public static final String ZRNDYOUVRATE85           = "zrndyouvrate85";
    public static final String ZRNDYOUVRATE86           = "zrndyouvrate86";
    public static final String ZRNDYOUVRATE87           = "zrndyouvrate87";
    public static final String ZRNDYOUVRATE88           = "zrndyouvrate88";
    public static final String ZRNDYOUVRATE89           = "zrndyouvrate89";
    public static final String ZRNDYOUVRATE90           = "zrndyouvrate90";
    public static final String ZRNDYOUVRATE91           = "zrndyouvrate91";
    public static final String ZRNDYOUVRATE92           = "zrndyouvrate92";
    public static final String ZRNDYOUVRATE93           = "zrndyouvrate93";
    public static final String ZRNDYOUVRATE94           = "zrndyouvrate94";
    public static final String ZRNDYOUVRATE95           = "zrndyouvrate95";
    public static final String ZRNDYOUVRATE96           = "zrndyouvrate96";
    public static final String ZRNDYOUVRATE97           = "zrndyouvrate97";
    public static final String ZRNDYOUVRATE98           = "zrndyouvrate98";
    public static final String ZRNDYOUVRATE99           = "zrndyouvrate99";
    public static final String ZRNKIKENSRATE00          = "zrnkikensrate00";
    public static final String ZRNKIKENSRATE01          = "zrnkikensrate01";
    public static final String ZRNKIKENSRATE02          = "zrnkikensrate02";
    public static final String ZRNKIKENSRATE03          = "zrnkikensrate03";
    public static final String ZRNKIKENSRATE04          = "zrnkikensrate04";
    public static final String ZRNKIKENSRATE05          = "zrnkikensrate05";
    public static final String ZRNKIKENSRATE06          = "zrnkikensrate06";
    public static final String ZRNKIKENSRATE07          = "zrnkikensrate07";
    public static final String ZRNKIKENSRATE08          = "zrnkikensrate08";
    public static final String ZRNKIKENSRATE09          = "zrnkikensrate09";
    public static final String ZRNKIKENSRATE10          = "zrnkikensrate10";
    public static final String ZRNKIKENSRATE11          = "zrnkikensrate11";
    public static final String ZRNKIKENSRATE12          = "zrnkikensrate12";
    public static final String ZRNKIKENSRATE13          = "zrnkikensrate13";
    public static final String ZRNKIKENSRATE14          = "zrnkikensrate14";
    public static final String ZRNKIKENSRATE15          = "zrnkikensrate15";
    public static final String ZRNKIKENSRATE16          = "zrnkikensrate16";
    public static final String ZRNKIKENSRATE17          = "zrnkikensrate17";
    public static final String ZRNKIKENSRATE18          = "zrnkikensrate18";
    public static final String ZRNKIKENSRATE19          = "zrnkikensrate19";
    public static final String ZRNKIKENSRATE20          = "zrnkikensrate20";
    public static final String ZRNKIKENSRATE21          = "zrnkikensrate21";
    public static final String ZRNKIKENSRATE22          = "zrnkikensrate22";
    public static final String ZRNKIKENSRATE23          = "zrnkikensrate23";
    public static final String ZRNKIKENSRATE24          = "zrnkikensrate24";
    public static final String ZRNKIKENSRATE25          = "zrnkikensrate25";
    public static final String ZRNKIKENSRATE26          = "zrnkikensrate26";
    public static final String ZRNKIKENSRATE27          = "zrnkikensrate27";
    public static final String ZRNKIKENSRATE28          = "zrnkikensrate28";
    public static final String ZRNKIKENSRATE29          = "zrnkikensrate29";
    public static final String ZRNKIKENSRATE30          = "zrnkikensrate30";
    public static final String ZRNKIKENSRATE31          = "zrnkikensrate31";
    public static final String ZRNKIKENSRATE32          = "zrnkikensrate32";
    public static final String ZRNKIKENSRATE33          = "zrnkikensrate33";
    public static final String ZRNKIKENSRATE34          = "zrnkikensrate34";
    public static final String ZRNKIKENSRATE35          = "zrnkikensrate35";
    public static final String ZRNKIKENSRATE36          = "zrnkikensrate36";
    public static final String ZRNKIKENSRATE37          = "zrnkikensrate37";
    public static final String ZRNKIKENSRATE38          = "zrnkikensrate38";
    public static final String ZRNKIKENSRATE39          = "zrnkikensrate39";
    public static final String ZRNKIKENSRATE40          = "zrnkikensrate40";
    public static final String ZRNKIKENSRATE41          = "zrnkikensrate41";
    public static final String ZRNKIKENSRATE42          = "zrnkikensrate42";
    public static final String ZRNKIKENSRATE43          = "zrnkikensrate43";
    public static final String ZRNKIKENSRATE44          = "zrnkikensrate44";
    public static final String ZRNKIKENSRATE45          = "zrnkikensrate45";
    public static final String ZRNKIKENSRATE46          = "zrnkikensrate46";
    public static final String ZRNKIKENSRATE47          = "zrnkikensrate47";
    public static final String ZRNKIKENSRATE48          = "zrnkikensrate48";
    public static final String ZRNKIKENSRATE49          = "zrnkikensrate49";
    public static final String ZRNKIKENSRATE50          = "zrnkikensrate50";
    public static final String ZRNKIKENSRATE51          = "zrnkikensrate51";
    public static final String ZRNKIKENSRATE52          = "zrnkikensrate52";
    public static final String ZRNKIKENSRATE53          = "zrnkikensrate53";
    public static final String ZRNKIKENSRATE54          = "zrnkikensrate54";
    public static final String ZRNKIKENSRATE55          = "zrnkikensrate55";
    public static final String ZRNKIKENSRATE56          = "zrnkikensrate56";
    public static final String ZRNKIKENSRATE57          = "zrnkikensrate57";
    public static final String ZRNKIKENSRATE58          = "zrnkikensrate58";
    public static final String ZRNKIKENSRATE59          = "zrnkikensrate59";
    public static final String ZRNKIKENSRATE60          = "zrnkikensrate60";
    public static final String ZRNKIKENSRATE61          = "zrnkikensrate61";
    public static final String ZRNKIKENSRATE62          = "zrnkikensrate62";
    public static final String ZRNKIKENSRATE63          = "zrnkikensrate63";
    public static final String ZRNKIKENSRATE64          = "zrnkikensrate64";
    public static final String ZRNKIKENSRATE65          = "zrnkikensrate65";
    public static final String ZRNKIKENSRATE66          = "zrnkikensrate66";
    public static final String ZRNKIKENSRATE67          = "zrnkikensrate67";
    public static final String ZRNKIKENSRATE68          = "zrnkikensrate68";
    public static final String ZRNKIKENSRATE69          = "zrnkikensrate69";
    public static final String ZRNKIKENSRATE70          = "zrnkikensrate70";
    public static final String ZRNKIKENSRATE71          = "zrnkikensrate71";
    public static final String ZRNKIKENSRATE72          = "zrnkikensrate72";
    public static final String ZRNKIKENSRATE73          = "zrnkikensrate73";
    public static final String ZRNKIKENSRATE74          = "zrnkikensrate74";
    public static final String ZRNKIKENSRATE75          = "zrnkikensrate75";
    public static final String ZRNKIKENSRATE76          = "zrnkikensrate76";
    public static final String ZRNKIKENSRATE77          = "zrnkikensrate77";
    public static final String ZRNKIKENSRATE78          = "zrnkikensrate78";
    public static final String ZRNKIKENSRATE79          = "zrnkikensrate79";
    public static final String ZRNKIKENSRATE80          = "zrnkikensrate80";
    public static final String ZRNKIKENSRATE81          = "zrnkikensrate81";
    public static final String ZRNKIKENSRATE82          = "zrnkikensrate82";
    public static final String ZRNKIKENSRATE83          = "zrnkikensrate83";
    public static final String ZRNKIKENSRATE84          = "zrnkikensrate84";
    public static final String ZRNKIKENSRATE85          = "zrnkikensrate85";
    public static final String ZRNKIKENSRATE86          = "zrnkikensrate86";
    public static final String ZRNKIKENSRATE87          = "zrnkikensrate87";
    public static final String ZRNKIKENSRATE88          = "zrnkikensrate88";
    public static final String ZRNKIKENSRATE89          = "zrnkikensrate89";
    public static final String ZRNKIKENSRATE90          = "zrnkikensrate90";
    public static final String ZRNKIKENSRATE91          = "zrnkikensrate91";
    public static final String ZRNKIKENSRATE92          = "zrnkikensrate92";
    public static final String ZRNKIKENSRATE93          = "zrnkikensrate93";
    public static final String ZRNKIKENSRATE94          = "zrnkikensrate94";
    public static final String ZRNKIKENSRATE95          = "zrnkikensrate95";
    public static final String ZRNKIKENSRATE96          = "zrnkikensrate96";
    public static final String ZRNKIKENSRATE97          = "zrnkikensrate97";
    public static final String ZRNKIKENSRATE98          = "zrnkikensrate98";
    public static final String ZRNKIKENSRATE99          = "zrnkikensrate99";

    private final PKZT_RatedRn primaryKey;

    public GenZT_RatedRn() {
        primaryKey = new PKZT_RatedRn();
    }

    public GenZT_RatedRn(
        String pZrnhknsyukigou,
        String pZrnhknsyuruikigousedaikbn,
        String pZrnyoteiriritu,
        String pZrnpmenkbn,
        String pZrnhrkkaisuukbn,
        String pZrnhhknsei,
        String pZrnkeiyakujihhknnen,
        String pZrnsaimnkkykhyj,
        String pZrnhknkkn,
        String pZrnphrkkikn,
        String pZrndnendo,
        String pZrnnaiteikakuteikbn
    ) {
        primaryKey = new PKZT_RatedRn(
            pZrnhknsyukigou,
            pZrnhknsyuruikigousedaikbn,
            pZrnyoteiriritu,
            pZrnpmenkbn,
            pZrnhrkkaisuukbn,
            pZrnhhknsei,
            pZrnkeiyakujihhknnen,
            pZrnsaimnkkykhyj,
            pZrnhknkkn,
            pZrnphrkkikn,
            pZrndnendo,
            pZrnnaiteikakuteikbn
        );
    }

    @Transient
    @Override
    public PKZT_RatedRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RatedRn> getMetaClass() {
        return QZT_RatedRn.class;
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return getPrimaryKey().getZrnhknsyukigou();
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        getPrimaryKey().setZrnhknsyukigou(pZrnhknsyukigou);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return getPrimaryKey().getZrnhknsyuruikigousedaikbn();
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        getPrimaryKey().setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNYOTEIRIRITU)
    public String getZrnyoteiriritu() {
        return getPrimaryKey().getZrnyoteiriritu();
    }

    public void setZrnyoteiriritu(String pZrnyoteiriritu) {
        getPrimaryKey().setZrnyoteiriritu(pZrnyoteiriritu);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNPMENKBN)
    public String getZrnpmenkbn() {
        return getPrimaryKey().getZrnpmenkbn();
    }

    public void setZrnpmenkbn(String pZrnpmenkbn) {
        getPrimaryKey().setZrnpmenkbn(pZrnpmenkbn);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return getPrimaryKey().getZrnhrkkaisuukbn();
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        getPrimaryKey().setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNHHKNSEI)
    public String getZrnhhknsei() {
        return getPrimaryKey().getZrnhhknsei();
    }

    public void setZrnhhknsei(String pZrnhhknsei) {
        getPrimaryKey().setZrnhhknsei(pZrnhhknsei);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNKEIYAKUJIHHKNNEN)
    public String getZrnkeiyakujihhknnen() {
        return getPrimaryKey().getZrnkeiyakujihhknnen();
    }

    public void setZrnkeiyakujihhknnen(String pZrnkeiyakujihhknnen) {
        getPrimaryKey().setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return getPrimaryKey().getZrnsaimnkkykhyj();
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        getPrimaryKey().setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return getPrimaryKey().getZrnhknkkn();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        getPrimaryKey().setZrnhknkkn(pZrnhknkkn);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return getPrimaryKey().getZrnphrkkikn();
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        getPrimaryKey().setZrnphrkkikn(pZrnphrkkikn);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNDNENDO)
    public String getZrndnendo() {
        return getPrimaryKey().getZrndnendo();
    }

    public void setZrndnendo(String pZrndnendo) {
        getPrimaryKey().setZrndnendo(pZrndnendo);
    }

    @Id
    @Column(name=GenZT_RatedRn.ZRNNAITEIKAKUTEIKBN)
    public String getZrnnaiteikakuteikbn() {
        return getPrimaryKey().getZrnnaiteikakuteikbn();
    }

    public void setZrnnaiteikakuteikbn(String pZrnnaiteikakuteikbn) {
        getPrimaryKey().setZrnnaiteikakuteikbn(pZrnnaiteikakuteikbn);
    }

    private Double zrndrate00;

    @Column(name=GenZT_RatedRn.ZRNDRATE00)
    public Double getZrndrate00() {
        return zrndrate00;
    }

    public void setZrndrate00(Double pZrndrate00) {
        zrndrate00 = pZrndrate00;
    }

    private Double zrndrate01;

    @Column(name=GenZT_RatedRn.ZRNDRATE01)
    public Double getZrndrate01() {
        return zrndrate01;
    }

    public void setZrndrate01(Double pZrndrate01) {
        zrndrate01 = pZrndrate01;
    }

    private Double zrndrate02;

    @Column(name=GenZT_RatedRn.ZRNDRATE02)
    public Double getZrndrate02() {
        return zrndrate02;
    }

    public void setZrndrate02(Double pZrndrate02) {
        zrndrate02 = pZrndrate02;
    }

    private Double zrndrate03;

    @Column(name=GenZT_RatedRn.ZRNDRATE03)
    public Double getZrndrate03() {
        return zrndrate03;
    }

    public void setZrndrate03(Double pZrndrate03) {
        zrndrate03 = pZrndrate03;
    }

    private Double zrndrate04;

    @Column(name=GenZT_RatedRn.ZRNDRATE04)
    public Double getZrndrate04() {
        return zrndrate04;
    }

    public void setZrndrate04(Double pZrndrate04) {
        zrndrate04 = pZrndrate04;
    }

    private Double zrndrate05;

    @Column(name=GenZT_RatedRn.ZRNDRATE05)
    public Double getZrndrate05() {
        return zrndrate05;
    }

    public void setZrndrate05(Double pZrndrate05) {
        zrndrate05 = pZrndrate05;
    }

    private Double zrndrate06;

    @Column(name=GenZT_RatedRn.ZRNDRATE06)
    public Double getZrndrate06() {
        return zrndrate06;
    }

    public void setZrndrate06(Double pZrndrate06) {
        zrndrate06 = pZrndrate06;
    }

    private Double zrndrate07;

    @Column(name=GenZT_RatedRn.ZRNDRATE07)
    public Double getZrndrate07() {
        return zrndrate07;
    }

    public void setZrndrate07(Double pZrndrate07) {
        zrndrate07 = pZrndrate07;
    }

    private Double zrndrate08;

    @Column(name=GenZT_RatedRn.ZRNDRATE08)
    public Double getZrndrate08() {
        return zrndrate08;
    }

    public void setZrndrate08(Double pZrndrate08) {
        zrndrate08 = pZrndrate08;
    }

    private Double zrndrate09;

    @Column(name=GenZT_RatedRn.ZRNDRATE09)
    public Double getZrndrate09() {
        return zrndrate09;
    }

    public void setZrndrate09(Double pZrndrate09) {
        zrndrate09 = pZrndrate09;
    }

    private Double zrndrate10;

    @Column(name=GenZT_RatedRn.ZRNDRATE10)
    public Double getZrndrate10() {
        return zrndrate10;
    }

    public void setZrndrate10(Double pZrndrate10) {
        zrndrate10 = pZrndrate10;
    }

    private Double zrndrate11;

    @Column(name=GenZT_RatedRn.ZRNDRATE11)
    public Double getZrndrate11() {
        return zrndrate11;
    }

    public void setZrndrate11(Double pZrndrate11) {
        zrndrate11 = pZrndrate11;
    }

    private Double zrndrate12;

    @Column(name=GenZT_RatedRn.ZRNDRATE12)
    public Double getZrndrate12() {
        return zrndrate12;
    }

    public void setZrndrate12(Double pZrndrate12) {
        zrndrate12 = pZrndrate12;
    }

    private Double zrndrate13;

    @Column(name=GenZT_RatedRn.ZRNDRATE13)
    public Double getZrndrate13() {
        return zrndrate13;
    }

    public void setZrndrate13(Double pZrndrate13) {
        zrndrate13 = pZrndrate13;
    }

    private Double zrndrate14;

    @Column(name=GenZT_RatedRn.ZRNDRATE14)
    public Double getZrndrate14() {
        return zrndrate14;
    }

    public void setZrndrate14(Double pZrndrate14) {
        zrndrate14 = pZrndrate14;
    }

    private Double zrndrate15;

    @Column(name=GenZT_RatedRn.ZRNDRATE15)
    public Double getZrndrate15() {
        return zrndrate15;
    }

    public void setZrndrate15(Double pZrndrate15) {
        zrndrate15 = pZrndrate15;
    }

    private Double zrndrate16;

    @Column(name=GenZT_RatedRn.ZRNDRATE16)
    public Double getZrndrate16() {
        return zrndrate16;
    }

    public void setZrndrate16(Double pZrndrate16) {
        zrndrate16 = pZrndrate16;
    }

    private Double zrndrate17;

    @Column(name=GenZT_RatedRn.ZRNDRATE17)
    public Double getZrndrate17() {
        return zrndrate17;
    }

    public void setZrndrate17(Double pZrndrate17) {
        zrndrate17 = pZrndrate17;
    }

    private Double zrndrate18;

    @Column(name=GenZT_RatedRn.ZRNDRATE18)
    public Double getZrndrate18() {
        return zrndrate18;
    }

    public void setZrndrate18(Double pZrndrate18) {
        zrndrate18 = pZrndrate18;
    }

    private Double zrndrate19;

    @Column(name=GenZT_RatedRn.ZRNDRATE19)
    public Double getZrndrate19() {
        return zrndrate19;
    }

    public void setZrndrate19(Double pZrndrate19) {
        zrndrate19 = pZrndrate19;
    }

    private Double zrndrate20;

    @Column(name=GenZT_RatedRn.ZRNDRATE20)
    public Double getZrndrate20() {
        return zrndrate20;
    }

    public void setZrndrate20(Double pZrndrate20) {
        zrndrate20 = pZrndrate20;
    }

    private Double zrndrate21;

    @Column(name=GenZT_RatedRn.ZRNDRATE21)
    public Double getZrndrate21() {
        return zrndrate21;
    }

    public void setZrndrate21(Double pZrndrate21) {
        zrndrate21 = pZrndrate21;
    }

    private Double zrndrate22;

    @Column(name=GenZT_RatedRn.ZRNDRATE22)
    public Double getZrndrate22() {
        return zrndrate22;
    }

    public void setZrndrate22(Double pZrndrate22) {
        zrndrate22 = pZrndrate22;
    }

    private Double zrndrate23;

    @Column(name=GenZT_RatedRn.ZRNDRATE23)
    public Double getZrndrate23() {
        return zrndrate23;
    }

    public void setZrndrate23(Double pZrndrate23) {
        zrndrate23 = pZrndrate23;
    }

    private Double zrndrate24;

    @Column(name=GenZT_RatedRn.ZRNDRATE24)
    public Double getZrndrate24() {
        return zrndrate24;
    }

    public void setZrndrate24(Double pZrndrate24) {
        zrndrate24 = pZrndrate24;
    }

    private Double zrndrate25;

    @Column(name=GenZT_RatedRn.ZRNDRATE25)
    public Double getZrndrate25() {
        return zrndrate25;
    }

    public void setZrndrate25(Double pZrndrate25) {
        zrndrate25 = pZrndrate25;
    }

    private Double zrndrate26;

    @Column(name=GenZT_RatedRn.ZRNDRATE26)
    public Double getZrndrate26() {
        return zrndrate26;
    }

    public void setZrndrate26(Double pZrndrate26) {
        zrndrate26 = pZrndrate26;
    }

    private Double zrndrate27;

    @Column(name=GenZT_RatedRn.ZRNDRATE27)
    public Double getZrndrate27() {
        return zrndrate27;
    }

    public void setZrndrate27(Double pZrndrate27) {
        zrndrate27 = pZrndrate27;
    }

    private Double zrndrate28;

    @Column(name=GenZT_RatedRn.ZRNDRATE28)
    public Double getZrndrate28() {
        return zrndrate28;
    }

    public void setZrndrate28(Double pZrndrate28) {
        zrndrate28 = pZrndrate28;
    }

    private Double zrndrate29;

    @Column(name=GenZT_RatedRn.ZRNDRATE29)
    public Double getZrndrate29() {
        return zrndrate29;
    }

    public void setZrndrate29(Double pZrndrate29) {
        zrndrate29 = pZrndrate29;
    }

    private Double zrndrate30;

    @Column(name=GenZT_RatedRn.ZRNDRATE30)
    public Double getZrndrate30() {
        return zrndrate30;
    }

    public void setZrndrate30(Double pZrndrate30) {
        zrndrate30 = pZrndrate30;
    }

    private Double zrndrate31;

    @Column(name=GenZT_RatedRn.ZRNDRATE31)
    public Double getZrndrate31() {
        return zrndrate31;
    }

    public void setZrndrate31(Double pZrndrate31) {
        zrndrate31 = pZrndrate31;
    }

    private Double zrndrate32;

    @Column(name=GenZT_RatedRn.ZRNDRATE32)
    public Double getZrndrate32() {
        return zrndrate32;
    }

    public void setZrndrate32(Double pZrndrate32) {
        zrndrate32 = pZrndrate32;
    }

    private Double zrndrate33;

    @Column(name=GenZT_RatedRn.ZRNDRATE33)
    public Double getZrndrate33() {
        return zrndrate33;
    }

    public void setZrndrate33(Double pZrndrate33) {
        zrndrate33 = pZrndrate33;
    }

    private Double zrndrate34;

    @Column(name=GenZT_RatedRn.ZRNDRATE34)
    public Double getZrndrate34() {
        return zrndrate34;
    }

    public void setZrndrate34(Double pZrndrate34) {
        zrndrate34 = pZrndrate34;
    }

    private Double zrndrate35;

    @Column(name=GenZT_RatedRn.ZRNDRATE35)
    public Double getZrndrate35() {
        return zrndrate35;
    }

    public void setZrndrate35(Double pZrndrate35) {
        zrndrate35 = pZrndrate35;
    }

    private Double zrndrate36;

    @Column(name=GenZT_RatedRn.ZRNDRATE36)
    public Double getZrndrate36() {
        return zrndrate36;
    }

    public void setZrndrate36(Double pZrndrate36) {
        zrndrate36 = pZrndrate36;
    }

    private Double zrndrate37;

    @Column(name=GenZT_RatedRn.ZRNDRATE37)
    public Double getZrndrate37() {
        return zrndrate37;
    }

    public void setZrndrate37(Double pZrndrate37) {
        zrndrate37 = pZrndrate37;
    }

    private Double zrndrate38;

    @Column(name=GenZT_RatedRn.ZRNDRATE38)
    public Double getZrndrate38() {
        return zrndrate38;
    }

    public void setZrndrate38(Double pZrndrate38) {
        zrndrate38 = pZrndrate38;
    }

    private Double zrndrate39;

    @Column(name=GenZT_RatedRn.ZRNDRATE39)
    public Double getZrndrate39() {
        return zrndrate39;
    }

    public void setZrndrate39(Double pZrndrate39) {
        zrndrate39 = pZrndrate39;
    }

    private Double zrndrate40;

    @Column(name=GenZT_RatedRn.ZRNDRATE40)
    public Double getZrndrate40() {
        return zrndrate40;
    }

    public void setZrndrate40(Double pZrndrate40) {
        zrndrate40 = pZrndrate40;
    }

    private Double zrndrate41;

    @Column(name=GenZT_RatedRn.ZRNDRATE41)
    public Double getZrndrate41() {
        return zrndrate41;
    }

    public void setZrndrate41(Double pZrndrate41) {
        zrndrate41 = pZrndrate41;
    }

    private Double zrndrate42;

    @Column(name=GenZT_RatedRn.ZRNDRATE42)
    public Double getZrndrate42() {
        return zrndrate42;
    }

    public void setZrndrate42(Double pZrndrate42) {
        zrndrate42 = pZrndrate42;
    }

    private Double zrndrate43;

    @Column(name=GenZT_RatedRn.ZRNDRATE43)
    public Double getZrndrate43() {
        return zrndrate43;
    }

    public void setZrndrate43(Double pZrndrate43) {
        zrndrate43 = pZrndrate43;
    }

    private Double zrndrate44;

    @Column(name=GenZT_RatedRn.ZRNDRATE44)
    public Double getZrndrate44() {
        return zrndrate44;
    }

    public void setZrndrate44(Double pZrndrate44) {
        zrndrate44 = pZrndrate44;
    }

    private Double zrndrate45;

    @Column(name=GenZT_RatedRn.ZRNDRATE45)
    public Double getZrndrate45() {
        return zrndrate45;
    }

    public void setZrndrate45(Double pZrndrate45) {
        zrndrate45 = pZrndrate45;
    }

    private Double zrndrate46;

    @Column(name=GenZT_RatedRn.ZRNDRATE46)
    public Double getZrndrate46() {
        return zrndrate46;
    }

    public void setZrndrate46(Double pZrndrate46) {
        zrndrate46 = pZrndrate46;
    }

    private Double zrndrate47;

    @Column(name=GenZT_RatedRn.ZRNDRATE47)
    public Double getZrndrate47() {
        return zrndrate47;
    }

    public void setZrndrate47(Double pZrndrate47) {
        zrndrate47 = pZrndrate47;
    }

    private Double zrndrate48;

    @Column(name=GenZT_RatedRn.ZRNDRATE48)
    public Double getZrndrate48() {
        return zrndrate48;
    }

    public void setZrndrate48(Double pZrndrate48) {
        zrndrate48 = pZrndrate48;
    }

    private Double zrndrate49;

    @Column(name=GenZT_RatedRn.ZRNDRATE49)
    public Double getZrndrate49() {
        return zrndrate49;
    }

    public void setZrndrate49(Double pZrndrate49) {
        zrndrate49 = pZrndrate49;
    }

    private Double zrndrate50;

    @Column(name=GenZT_RatedRn.ZRNDRATE50)
    public Double getZrndrate50() {
        return zrndrate50;
    }

    public void setZrndrate50(Double pZrndrate50) {
        zrndrate50 = pZrndrate50;
    }

    private Double zrndrate51;

    @Column(name=GenZT_RatedRn.ZRNDRATE51)
    public Double getZrndrate51() {
        return zrndrate51;
    }

    public void setZrndrate51(Double pZrndrate51) {
        zrndrate51 = pZrndrate51;
    }

    private Double zrndrate52;

    @Column(name=GenZT_RatedRn.ZRNDRATE52)
    public Double getZrndrate52() {
        return zrndrate52;
    }

    public void setZrndrate52(Double pZrndrate52) {
        zrndrate52 = pZrndrate52;
    }

    private Double zrndrate53;

    @Column(name=GenZT_RatedRn.ZRNDRATE53)
    public Double getZrndrate53() {
        return zrndrate53;
    }

    public void setZrndrate53(Double pZrndrate53) {
        zrndrate53 = pZrndrate53;
    }

    private Double zrndrate54;

    @Column(name=GenZT_RatedRn.ZRNDRATE54)
    public Double getZrndrate54() {
        return zrndrate54;
    }

    public void setZrndrate54(Double pZrndrate54) {
        zrndrate54 = pZrndrate54;
    }

    private Double zrndrate55;

    @Column(name=GenZT_RatedRn.ZRNDRATE55)
    public Double getZrndrate55() {
        return zrndrate55;
    }

    public void setZrndrate55(Double pZrndrate55) {
        zrndrate55 = pZrndrate55;
    }

    private Double zrndrate56;

    @Column(name=GenZT_RatedRn.ZRNDRATE56)
    public Double getZrndrate56() {
        return zrndrate56;
    }

    public void setZrndrate56(Double pZrndrate56) {
        zrndrate56 = pZrndrate56;
    }

    private Double zrndrate57;

    @Column(name=GenZT_RatedRn.ZRNDRATE57)
    public Double getZrndrate57() {
        return zrndrate57;
    }

    public void setZrndrate57(Double pZrndrate57) {
        zrndrate57 = pZrndrate57;
    }

    private Double zrndrate58;

    @Column(name=GenZT_RatedRn.ZRNDRATE58)
    public Double getZrndrate58() {
        return zrndrate58;
    }

    public void setZrndrate58(Double pZrndrate58) {
        zrndrate58 = pZrndrate58;
    }

    private Double zrndrate59;

    @Column(name=GenZT_RatedRn.ZRNDRATE59)
    public Double getZrndrate59() {
        return zrndrate59;
    }

    public void setZrndrate59(Double pZrndrate59) {
        zrndrate59 = pZrndrate59;
    }

    private Double zrndrate60;

    @Column(name=GenZT_RatedRn.ZRNDRATE60)
    public Double getZrndrate60() {
        return zrndrate60;
    }

    public void setZrndrate60(Double pZrndrate60) {
        zrndrate60 = pZrndrate60;
    }

    private Double zrndrate61;

    @Column(name=GenZT_RatedRn.ZRNDRATE61)
    public Double getZrndrate61() {
        return zrndrate61;
    }

    public void setZrndrate61(Double pZrndrate61) {
        zrndrate61 = pZrndrate61;
    }

    private Double zrndrate62;

    @Column(name=GenZT_RatedRn.ZRNDRATE62)
    public Double getZrndrate62() {
        return zrndrate62;
    }

    public void setZrndrate62(Double pZrndrate62) {
        zrndrate62 = pZrndrate62;
    }

    private Double zrndrate63;

    @Column(name=GenZT_RatedRn.ZRNDRATE63)
    public Double getZrndrate63() {
        return zrndrate63;
    }

    public void setZrndrate63(Double pZrndrate63) {
        zrndrate63 = pZrndrate63;
    }

    private Double zrndrate64;

    @Column(name=GenZT_RatedRn.ZRNDRATE64)
    public Double getZrndrate64() {
        return zrndrate64;
    }

    public void setZrndrate64(Double pZrndrate64) {
        zrndrate64 = pZrndrate64;
    }

    private Double zrndrate65;

    @Column(name=GenZT_RatedRn.ZRNDRATE65)
    public Double getZrndrate65() {
        return zrndrate65;
    }

    public void setZrndrate65(Double pZrndrate65) {
        zrndrate65 = pZrndrate65;
    }

    private Double zrndrate66;

    @Column(name=GenZT_RatedRn.ZRNDRATE66)
    public Double getZrndrate66() {
        return zrndrate66;
    }

    public void setZrndrate66(Double pZrndrate66) {
        zrndrate66 = pZrndrate66;
    }

    private Double zrndrate67;

    @Column(name=GenZT_RatedRn.ZRNDRATE67)
    public Double getZrndrate67() {
        return zrndrate67;
    }

    public void setZrndrate67(Double pZrndrate67) {
        zrndrate67 = pZrndrate67;
    }

    private Double zrndrate68;

    @Column(name=GenZT_RatedRn.ZRNDRATE68)
    public Double getZrndrate68() {
        return zrndrate68;
    }

    public void setZrndrate68(Double pZrndrate68) {
        zrndrate68 = pZrndrate68;
    }

    private Double zrndrate69;

    @Column(name=GenZT_RatedRn.ZRNDRATE69)
    public Double getZrndrate69() {
        return zrndrate69;
    }

    public void setZrndrate69(Double pZrndrate69) {
        zrndrate69 = pZrndrate69;
    }

    private Double zrndrate70;

    @Column(name=GenZT_RatedRn.ZRNDRATE70)
    public Double getZrndrate70() {
        return zrndrate70;
    }

    public void setZrndrate70(Double pZrndrate70) {
        zrndrate70 = pZrndrate70;
    }

    private Double zrndrate71;

    @Column(name=GenZT_RatedRn.ZRNDRATE71)
    public Double getZrndrate71() {
        return zrndrate71;
    }

    public void setZrndrate71(Double pZrndrate71) {
        zrndrate71 = pZrndrate71;
    }

    private Double zrndrate72;

    @Column(name=GenZT_RatedRn.ZRNDRATE72)
    public Double getZrndrate72() {
        return zrndrate72;
    }

    public void setZrndrate72(Double pZrndrate72) {
        zrndrate72 = pZrndrate72;
    }

    private Double zrndrate73;

    @Column(name=GenZT_RatedRn.ZRNDRATE73)
    public Double getZrndrate73() {
        return zrndrate73;
    }

    public void setZrndrate73(Double pZrndrate73) {
        zrndrate73 = pZrndrate73;
    }

    private Double zrndrate74;

    @Column(name=GenZT_RatedRn.ZRNDRATE74)
    public Double getZrndrate74() {
        return zrndrate74;
    }

    public void setZrndrate74(Double pZrndrate74) {
        zrndrate74 = pZrndrate74;
    }

    private Double zrndrate75;

    @Column(name=GenZT_RatedRn.ZRNDRATE75)
    public Double getZrndrate75() {
        return zrndrate75;
    }

    public void setZrndrate75(Double pZrndrate75) {
        zrndrate75 = pZrndrate75;
    }

    private Double zrndrate76;

    @Column(name=GenZT_RatedRn.ZRNDRATE76)
    public Double getZrndrate76() {
        return zrndrate76;
    }

    public void setZrndrate76(Double pZrndrate76) {
        zrndrate76 = pZrndrate76;
    }

    private Double zrndrate77;

    @Column(name=GenZT_RatedRn.ZRNDRATE77)
    public Double getZrndrate77() {
        return zrndrate77;
    }

    public void setZrndrate77(Double pZrndrate77) {
        zrndrate77 = pZrndrate77;
    }

    private Double zrndrate78;

    @Column(name=GenZT_RatedRn.ZRNDRATE78)
    public Double getZrndrate78() {
        return zrndrate78;
    }

    public void setZrndrate78(Double pZrndrate78) {
        zrndrate78 = pZrndrate78;
    }

    private Double zrndrate79;

    @Column(name=GenZT_RatedRn.ZRNDRATE79)
    public Double getZrndrate79() {
        return zrndrate79;
    }

    public void setZrndrate79(Double pZrndrate79) {
        zrndrate79 = pZrndrate79;
    }

    private Double zrndrate80;

    @Column(name=GenZT_RatedRn.ZRNDRATE80)
    public Double getZrndrate80() {
        return zrndrate80;
    }

    public void setZrndrate80(Double pZrndrate80) {
        zrndrate80 = pZrndrate80;
    }

    private Double zrndrate81;

    @Column(name=GenZT_RatedRn.ZRNDRATE81)
    public Double getZrndrate81() {
        return zrndrate81;
    }

    public void setZrndrate81(Double pZrndrate81) {
        zrndrate81 = pZrndrate81;
    }

    private Double zrndrate82;

    @Column(name=GenZT_RatedRn.ZRNDRATE82)
    public Double getZrndrate82() {
        return zrndrate82;
    }

    public void setZrndrate82(Double pZrndrate82) {
        zrndrate82 = pZrndrate82;
    }

    private Double zrndrate83;

    @Column(name=GenZT_RatedRn.ZRNDRATE83)
    public Double getZrndrate83() {
        return zrndrate83;
    }

    public void setZrndrate83(Double pZrndrate83) {
        zrndrate83 = pZrndrate83;
    }

    private Double zrndrate84;

    @Column(name=GenZT_RatedRn.ZRNDRATE84)
    public Double getZrndrate84() {
        return zrndrate84;
    }

    public void setZrndrate84(Double pZrndrate84) {
        zrndrate84 = pZrndrate84;
    }

    private Double zrndrate85;

    @Column(name=GenZT_RatedRn.ZRNDRATE85)
    public Double getZrndrate85() {
        return zrndrate85;
    }

    public void setZrndrate85(Double pZrndrate85) {
        zrndrate85 = pZrndrate85;
    }

    private Double zrndrate86;

    @Column(name=GenZT_RatedRn.ZRNDRATE86)
    public Double getZrndrate86() {
        return zrndrate86;
    }

    public void setZrndrate86(Double pZrndrate86) {
        zrndrate86 = pZrndrate86;
    }

    private Double zrndrate87;

    @Column(name=GenZT_RatedRn.ZRNDRATE87)
    public Double getZrndrate87() {
        return zrndrate87;
    }

    public void setZrndrate87(Double pZrndrate87) {
        zrndrate87 = pZrndrate87;
    }

    private Double zrndrate88;

    @Column(name=GenZT_RatedRn.ZRNDRATE88)
    public Double getZrndrate88() {
        return zrndrate88;
    }

    public void setZrndrate88(Double pZrndrate88) {
        zrndrate88 = pZrndrate88;
    }

    private Double zrndrate89;

    @Column(name=GenZT_RatedRn.ZRNDRATE89)
    public Double getZrndrate89() {
        return zrndrate89;
    }

    public void setZrndrate89(Double pZrndrate89) {
        zrndrate89 = pZrndrate89;
    }

    private Double zrndrate90;

    @Column(name=GenZT_RatedRn.ZRNDRATE90)
    public Double getZrndrate90() {
        return zrndrate90;
    }

    public void setZrndrate90(Double pZrndrate90) {
        zrndrate90 = pZrndrate90;
    }

    private Double zrndrate91;

    @Column(name=GenZT_RatedRn.ZRNDRATE91)
    public Double getZrndrate91() {
        return zrndrate91;
    }

    public void setZrndrate91(Double pZrndrate91) {
        zrndrate91 = pZrndrate91;
    }

    private Double zrndrate92;

    @Column(name=GenZT_RatedRn.ZRNDRATE92)
    public Double getZrndrate92() {
        return zrndrate92;
    }

    public void setZrndrate92(Double pZrndrate92) {
        zrndrate92 = pZrndrate92;
    }

    private Double zrndrate93;

    @Column(name=GenZT_RatedRn.ZRNDRATE93)
    public Double getZrndrate93() {
        return zrndrate93;
    }

    public void setZrndrate93(Double pZrndrate93) {
        zrndrate93 = pZrndrate93;
    }

    private Double zrndrate94;

    @Column(name=GenZT_RatedRn.ZRNDRATE94)
    public Double getZrndrate94() {
        return zrndrate94;
    }

    public void setZrndrate94(Double pZrndrate94) {
        zrndrate94 = pZrndrate94;
    }

    private Double zrndrate95;

    @Column(name=GenZT_RatedRn.ZRNDRATE95)
    public Double getZrndrate95() {
        return zrndrate95;
    }

    public void setZrndrate95(Double pZrndrate95) {
        zrndrate95 = pZrndrate95;
    }

    private Double zrndrate96;

    @Column(name=GenZT_RatedRn.ZRNDRATE96)
    public Double getZrndrate96() {
        return zrndrate96;
    }

    public void setZrndrate96(Double pZrndrate96) {
        zrndrate96 = pZrndrate96;
    }

    private Double zrndrate97;

    @Column(name=GenZT_RatedRn.ZRNDRATE97)
    public Double getZrndrate97() {
        return zrndrate97;
    }

    public void setZrndrate97(Double pZrndrate97) {
        zrndrate97 = pZrndrate97;
    }

    private Double zrndrate98;

    @Column(name=GenZT_RatedRn.ZRNDRATE98)
    public Double getZrndrate98() {
        return zrndrate98;
    }

    public void setZrndrate98(Double pZrndrate98) {
        zrndrate98 = pZrndrate98;
    }

    private Double zrndrate99;

    @Column(name=GenZT_RatedRn.ZRNDRATE99)
    public Double getZrndrate99() {
        return zrndrate99;
    }

    public void setZrndrate99(Double pZrndrate99) {
        zrndrate99 = pZrndrate99;
    }

    private Double zrnsisadrate00;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE00)
    public Double getZrnsisadrate00() {
        return zrnsisadrate00;
    }

    public void setZrnsisadrate00(Double pZrnsisadrate00) {
        zrnsisadrate00 = pZrnsisadrate00;
    }

    private Double zrnsisadrate01;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE01)
    public Double getZrnsisadrate01() {
        return zrnsisadrate01;
    }

    public void setZrnsisadrate01(Double pZrnsisadrate01) {
        zrnsisadrate01 = pZrnsisadrate01;
    }

    private Double zrnsisadrate02;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE02)
    public Double getZrnsisadrate02() {
        return zrnsisadrate02;
    }

    public void setZrnsisadrate02(Double pZrnsisadrate02) {
        zrnsisadrate02 = pZrnsisadrate02;
    }

    private Double zrnsisadrate03;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE03)
    public Double getZrnsisadrate03() {
        return zrnsisadrate03;
    }

    public void setZrnsisadrate03(Double pZrnsisadrate03) {
        zrnsisadrate03 = pZrnsisadrate03;
    }

    private Double zrnsisadrate04;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE04)
    public Double getZrnsisadrate04() {
        return zrnsisadrate04;
    }

    public void setZrnsisadrate04(Double pZrnsisadrate04) {
        zrnsisadrate04 = pZrnsisadrate04;
    }

    private Double zrnsisadrate05;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE05)
    public Double getZrnsisadrate05() {
        return zrnsisadrate05;
    }

    public void setZrnsisadrate05(Double pZrnsisadrate05) {
        zrnsisadrate05 = pZrnsisadrate05;
    }

    private Double zrnsisadrate06;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE06)
    public Double getZrnsisadrate06() {
        return zrnsisadrate06;
    }

    public void setZrnsisadrate06(Double pZrnsisadrate06) {
        zrnsisadrate06 = pZrnsisadrate06;
    }

    private Double zrnsisadrate07;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE07)
    public Double getZrnsisadrate07() {
        return zrnsisadrate07;
    }

    public void setZrnsisadrate07(Double pZrnsisadrate07) {
        zrnsisadrate07 = pZrnsisadrate07;
    }

    private Double zrnsisadrate08;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE08)
    public Double getZrnsisadrate08() {
        return zrnsisadrate08;
    }

    public void setZrnsisadrate08(Double pZrnsisadrate08) {
        zrnsisadrate08 = pZrnsisadrate08;
    }

    private Double zrnsisadrate09;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE09)
    public Double getZrnsisadrate09() {
        return zrnsisadrate09;
    }

    public void setZrnsisadrate09(Double pZrnsisadrate09) {
        zrnsisadrate09 = pZrnsisadrate09;
    }

    private Double zrnsisadrate10;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE10)
    public Double getZrnsisadrate10() {
        return zrnsisadrate10;
    }

    public void setZrnsisadrate10(Double pZrnsisadrate10) {
        zrnsisadrate10 = pZrnsisadrate10;
    }

    private Double zrnsisadrate11;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE11)
    public Double getZrnsisadrate11() {
        return zrnsisadrate11;
    }

    public void setZrnsisadrate11(Double pZrnsisadrate11) {
        zrnsisadrate11 = pZrnsisadrate11;
    }

    private Double zrnsisadrate12;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE12)
    public Double getZrnsisadrate12() {
        return zrnsisadrate12;
    }

    public void setZrnsisadrate12(Double pZrnsisadrate12) {
        zrnsisadrate12 = pZrnsisadrate12;
    }

    private Double zrnsisadrate13;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE13)
    public Double getZrnsisadrate13() {
        return zrnsisadrate13;
    }

    public void setZrnsisadrate13(Double pZrnsisadrate13) {
        zrnsisadrate13 = pZrnsisadrate13;
    }

    private Double zrnsisadrate14;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE14)
    public Double getZrnsisadrate14() {
        return zrnsisadrate14;
    }

    public void setZrnsisadrate14(Double pZrnsisadrate14) {
        zrnsisadrate14 = pZrnsisadrate14;
    }

    private Double zrnsisadrate15;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE15)
    public Double getZrnsisadrate15() {
        return zrnsisadrate15;
    }

    public void setZrnsisadrate15(Double pZrnsisadrate15) {
        zrnsisadrate15 = pZrnsisadrate15;
    }

    private Double zrnsisadrate16;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE16)
    public Double getZrnsisadrate16() {
        return zrnsisadrate16;
    }

    public void setZrnsisadrate16(Double pZrnsisadrate16) {
        zrnsisadrate16 = pZrnsisadrate16;
    }

    private Double zrnsisadrate17;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE17)
    public Double getZrnsisadrate17() {
        return zrnsisadrate17;
    }

    public void setZrnsisadrate17(Double pZrnsisadrate17) {
        zrnsisadrate17 = pZrnsisadrate17;
    }

    private Double zrnsisadrate18;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE18)
    public Double getZrnsisadrate18() {
        return zrnsisadrate18;
    }

    public void setZrnsisadrate18(Double pZrnsisadrate18) {
        zrnsisadrate18 = pZrnsisadrate18;
    }

    private Double zrnsisadrate19;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE19)
    public Double getZrnsisadrate19() {
        return zrnsisadrate19;
    }

    public void setZrnsisadrate19(Double pZrnsisadrate19) {
        zrnsisadrate19 = pZrnsisadrate19;
    }

    private Double zrnsisadrate20;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE20)
    public Double getZrnsisadrate20() {
        return zrnsisadrate20;
    }

    public void setZrnsisadrate20(Double pZrnsisadrate20) {
        zrnsisadrate20 = pZrnsisadrate20;
    }

    private Double zrnsisadrate21;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE21)
    public Double getZrnsisadrate21() {
        return zrnsisadrate21;
    }

    public void setZrnsisadrate21(Double pZrnsisadrate21) {
        zrnsisadrate21 = pZrnsisadrate21;
    }

    private Double zrnsisadrate22;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE22)
    public Double getZrnsisadrate22() {
        return zrnsisadrate22;
    }

    public void setZrnsisadrate22(Double pZrnsisadrate22) {
        zrnsisadrate22 = pZrnsisadrate22;
    }

    private Double zrnsisadrate23;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE23)
    public Double getZrnsisadrate23() {
        return zrnsisadrate23;
    }

    public void setZrnsisadrate23(Double pZrnsisadrate23) {
        zrnsisadrate23 = pZrnsisadrate23;
    }

    private Double zrnsisadrate24;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE24)
    public Double getZrnsisadrate24() {
        return zrnsisadrate24;
    }

    public void setZrnsisadrate24(Double pZrnsisadrate24) {
        zrnsisadrate24 = pZrnsisadrate24;
    }

    private Double zrnsisadrate25;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE25)
    public Double getZrnsisadrate25() {
        return zrnsisadrate25;
    }

    public void setZrnsisadrate25(Double pZrnsisadrate25) {
        zrnsisadrate25 = pZrnsisadrate25;
    }

    private Double zrnsisadrate26;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE26)
    public Double getZrnsisadrate26() {
        return zrnsisadrate26;
    }

    public void setZrnsisadrate26(Double pZrnsisadrate26) {
        zrnsisadrate26 = pZrnsisadrate26;
    }

    private Double zrnsisadrate27;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE27)
    public Double getZrnsisadrate27() {
        return zrnsisadrate27;
    }

    public void setZrnsisadrate27(Double pZrnsisadrate27) {
        zrnsisadrate27 = pZrnsisadrate27;
    }

    private Double zrnsisadrate28;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE28)
    public Double getZrnsisadrate28() {
        return zrnsisadrate28;
    }

    public void setZrnsisadrate28(Double pZrnsisadrate28) {
        zrnsisadrate28 = pZrnsisadrate28;
    }

    private Double zrnsisadrate29;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE29)
    public Double getZrnsisadrate29() {
        return zrnsisadrate29;
    }

    public void setZrnsisadrate29(Double pZrnsisadrate29) {
        zrnsisadrate29 = pZrnsisadrate29;
    }

    private Double zrnsisadrate30;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE30)
    public Double getZrnsisadrate30() {
        return zrnsisadrate30;
    }

    public void setZrnsisadrate30(Double pZrnsisadrate30) {
        zrnsisadrate30 = pZrnsisadrate30;
    }

    private Double zrnsisadrate31;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE31)
    public Double getZrnsisadrate31() {
        return zrnsisadrate31;
    }

    public void setZrnsisadrate31(Double pZrnsisadrate31) {
        zrnsisadrate31 = pZrnsisadrate31;
    }

    private Double zrnsisadrate32;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE32)
    public Double getZrnsisadrate32() {
        return zrnsisadrate32;
    }

    public void setZrnsisadrate32(Double pZrnsisadrate32) {
        zrnsisadrate32 = pZrnsisadrate32;
    }

    private Double zrnsisadrate33;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE33)
    public Double getZrnsisadrate33() {
        return zrnsisadrate33;
    }

    public void setZrnsisadrate33(Double pZrnsisadrate33) {
        zrnsisadrate33 = pZrnsisadrate33;
    }

    private Double zrnsisadrate34;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE34)
    public Double getZrnsisadrate34() {
        return zrnsisadrate34;
    }

    public void setZrnsisadrate34(Double pZrnsisadrate34) {
        zrnsisadrate34 = pZrnsisadrate34;
    }

    private Double zrnsisadrate35;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE35)
    public Double getZrnsisadrate35() {
        return zrnsisadrate35;
    }

    public void setZrnsisadrate35(Double pZrnsisadrate35) {
        zrnsisadrate35 = pZrnsisadrate35;
    }

    private Double zrnsisadrate36;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE36)
    public Double getZrnsisadrate36() {
        return zrnsisadrate36;
    }

    public void setZrnsisadrate36(Double pZrnsisadrate36) {
        zrnsisadrate36 = pZrnsisadrate36;
    }

    private Double zrnsisadrate37;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE37)
    public Double getZrnsisadrate37() {
        return zrnsisadrate37;
    }

    public void setZrnsisadrate37(Double pZrnsisadrate37) {
        zrnsisadrate37 = pZrnsisadrate37;
    }

    private Double zrnsisadrate38;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE38)
    public Double getZrnsisadrate38() {
        return zrnsisadrate38;
    }

    public void setZrnsisadrate38(Double pZrnsisadrate38) {
        zrnsisadrate38 = pZrnsisadrate38;
    }

    private Double zrnsisadrate39;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE39)
    public Double getZrnsisadrate39() {
        return zrnsisadrate39;
    }

    public void setZrnsisadrate39(Double pZrnsisadrate39) {
        zrnsisadrate39 = pZrnsisadrate39;
    }

    private Double zrnsisadrate40;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE40)
    public Double getZrnsisadrate40() {
        return zrnsisadrate40;
    }

    public void setZrnsisadrate40(Double pZrnsisadrate40) {
        zrnsisadrate40 = pZrnsisadrate40;
    }

    private Double zrnsisadrate41;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE41)
    public Double getZrnsisadrate41() {
        return zrnsisadrate41;
    }

    public void setZrnsisadrate41(Double pZrnsisadrate41) {
        zrnsisadrate41 = pZrnsisadrate41;
    }

    private Double zrnsisadrate42;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE42)
    public Double getZrnsisadrate42() {
        return zrnsisadrate42;
    }

    public void setZrnsisadrate42(Double pZrnsisadrate42) {
        zrnsisadrate42 = pZrnsisadrate42;
    }

    private Double zrnsisadrate43;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE43)
    public Double getZrnsisadrate43() {
        return zrnsisadrate43;
    }

    public void setZrnsisadrate43(Double pZrnsisadrate43) {
        zrnsisadrate43 = pZrnsisadrate43;
    }

    private Double zrnsisadrate44;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE44)
    public Double getZrnsisadrate44() {
        return zrnsisadrate44;
    }

    public void setZrnsisadrate44(Double pZrnsisadrate44) {
        zrnsisadrate44 = pZrnsisadrate44;
    }

    private Double zrnsisadrate45;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE45)
    public Double getZrnsisadrate45() {
        return zrnsisadrate45;
    }

    public void setZrnsisadrate45(Double pZrnsisadrate45) {
        zrnsisadrate45 = pZrnsisadrate45;
    }

    private Double zrnsisadrate46;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE46)
    public Double getZrnsisadrate46() {
        return zrnsisadrate46;
    }

    public void setZrnsisadrate46(Double pZrnsisadrate46) {
        zrnsisadrate46 = pZrnsisadrate46;
    }

    private Double zrnsisadrate47;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE47)
    public Double getZrnsisadrate47() {
        return zrnsisadrate47;
    }

    public void setZrnsisadrate47(Double pZrnsisadrate47) {
        zrnsisadrate47 = pZrnsisadrate47;
    }

    private Double zrnsisadrate48;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE48)
    public Double getZrnsisadrate48() {
        return zrnsisadrate48;
    }

    public void setZrnsisadrate48(Double pZrnsisadrate48) {
        zrnsisadrate48 = pZrnsisadrate48;
    }

    private Double zrnsisadrate49;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE49)
    public Double getZrnsisadrate49() {
        return zrnsisadrate49;
    }

    public void setZrnsisadrate49(Double pZrnsisadrate49) {
        zrnsisadrate49 = pZrnsisadrate49;
    }

    private Double zrnsisadrate50;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE50)
    public Double getZrnsisadrate50() {
        return zrnsisadrate50;
    }

    public void setZrnsisadrate50(Double pZrnsisadrate50) {
        zrnsisadrate50 = pZrnsisadrate50;
    }

    private Double zrnsisadrate51;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE51)
    public Double getZrnsisadrate51() {
        return zrnsisadrate51;
    }

    public void setZrnsisadrate51(Double pZrnsisadrate51) {
        zrnsisadrate51 = pZrnsisadrate51;
    }

    private Double zrnsisadrate52;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE52)
    public Double getZrnsisadrate52() {
        return zrnsisadrate52;
    }

    public void setZrnsisadrate52(Double pZrnsisadrate52) {
        zrnsisadrate52 = pZrnsisadrate52;
    }

    private Double zrnsisadrate53;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE53)
    public Double getZrnsisadrate53() {
        return zrnsisadrate53;
    }

    public void setZrnsisadrate53(Double pZrnsisadrate53) {
        zrnsisadrate53 = pZrnsisadrate53;
    }

    private Double zrnsisadrate54;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE54)
    public Double getZrnsisadrate54() {
        return zrnsisadrate54;
    }

    public void setZrnsisadrate54(Double pZrnsisadrate54) {
        zrnsisadrate54 = pZrnsisadrate54;
    }

    private Double zrnsisadrate55;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE55)
    public Double getZrnsisadrate55() {
        return zrnsisadrate55;
    }

    public void setZrnsisadrate55(Double pZrnsisadrate55) {
        zrnsisadrate55 = pZrnsisadrate55;
    }

    private Double zrnsisadrate56;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE56)
    public Double getZrnsisadrate56() {
        return zrnsisadrate56;
    }

    public void setZrnsisadrate56(Double pZrnsisadrate56) {
        zrnsisadrate56 = pZrnsisadrate56;
    }

    private Double zrnsisadrate57;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE57)
    public Double getZrnsisadrate57() {
        return zrnsisadrate57;
    }

    public void setZrnsisadrate57(Double pZrnsisadrate57) {
        zrnsisadrate57 = pZrnsisadrate57;
    }

    private Double zrnsisadrate58;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE58)
    public Double getZrnsisadrate58() {
        return zrnsisadrate58;
    }

    public void setZrnsisadrate58(Double pZrnsisadrate58) {
        zrnsisadrate58 = pZrnsisadrate58;
    }

    private Double zrnsisadrate59;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE59)
    public Double getZrnsisadrate59() {
        return zrnsisadrate59;
    }

    public void setZrnsisadrate59(Double pZrnsisadrate59) {
        zrnsisadrate59 = pZrnsisadrate59;
    }

    private Double zrnsisadrate60;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE60)
    public Double getZrnsisadrate60() {
        return zrnsisadrate60;
    }

    public void setZrnsisadrate60(Double pZrnsisadrate60) {
        zrnsisadrate60 = pZrnsisadrate60;
    }

    private Double zrnsisadrate61;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE61)
    public Double getZrnsisadrate61() {
        return zrnsisadrate61;
    }

    public void setZrnsisadrate61(Double pZrnsisadrate61) {
        zrnsisadrate61 = pZrnsisadrate61;
    }

    private Double zrnsisadrate62;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE62)
    public Double getZrnsisadrate62() {
        return zrnsisadrate62;
    }

    public void setZrnsisadrate62(Double pZrnsisadrate62) {
        zrnsisadrate62 = pZrnsisadrate62;
    }

    private Double zrnsisadrate63;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE63)
    public Double getZrnsisadrate63() {
        return zrnsisadrate63;
    }

    public void setZrnsisadrate63(Double pZrnsisadrate63) {
        zrnsisadrate63 = pZrnsisadrate63;
    }

    private Double zrnsisadrate64;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE64)
    public Double getZrnsisadrate64() {
        return zrnsisadrate64;
    }

    public void setZrnsisadrate64(Double pZrnsisadrate64) {
        zrnsisadrate64 = pZrnsisadrate64;
    }

    private Double zrnsisadrate65;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE65)
    public Double getZrnsisadrate65() {
        return zrnsisadrate65;
    }

    public void setZrnsisadrate65(Double pZrnsisadrate65) {
        zrnsisadrate65 = pZrnsisadrate65;
    }

    private Double zrnsisadrate66;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE66)
    public Double getZrnsisadrate66() {
        return zrnsisadrate66;
    }

    public void setZrnsisadrate66(Double pZrnsisadrate66) {
        zrnsisadrate66 = pZrnsisadrate66;
    }

    private Double zrnsisadrate67;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE67)
    public Double getZrnsisadrate67() {
        return zrnsisadrate67;
    }

    public void setZrnsisadrate67(Double pZrnsisadrate67) {
        zrnsisadrate67 = pZrnsisadrate67;
    }

    private Double zrnsisadrate68;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE68)
    public Double getZrnsisadrate68() {
        return zrnsisadrate68;
    }

    public void setZrnsisadrate68(Double pZrnsisadrate68) {
        zrnsisadrate68 = pZrnsisadrate68;
    }

    private Double zrnsisadrate69;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE69)
    public Double getZrnsisadrate69() {
        return zrnsisadrate69;
    }

    public void setZrnsisadrate69(Double pZrnsisadrate69) {
        zrnsisadrate69 = pZrnsisadrate69;
    }

    private Double zrnsisadrate70;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE70)
    public Double getZrnsisadrate70() {
        return zrnsisadrate70;
    }

    public void setZrnsisadrate70(Double pZrnsisadrate70) {
        zrnsisadrate70 = pZrnsisadrate70;
    }

    private Double zrnsisadrate71;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE71)
    public Double getZrnsisadrate71() {
        return zrnsisadrate71;
    }

    public void setZrnsisadrate71(Double pZrnsisadrate71) {
        zrnsisadrate71 = pZrnsisadrate71;
    }

    private Double zrnsisadrate72;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE72)
    public Double getZrnsisadrate72() {
        return zrnsisadrate72;
    }

    public void setZrnsisadrate72(Double pZrnsisadrate72) {
        zrnsisadrate72 = pZrnsisadrate72;
    }

    private Double zrnsisadrate73;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE73)
    public Double getZrnsisadrate73() {
        return zrnsisadrate73;
    }

    public void setZrnsisadrate73(Double pZrnsisadrate73) {
        zrnsisadrate73 = pZrnsisadrate73;
    }

    private Double zrnsisadrate74;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE74)
    public Double getZrnsisadrate74() {
        return zrnsisadrate74;
    }

    public void setZrnsisadrate74(Double pZrnsisadrate74) {
        zrnsisadrate74 = pZrnsisadrate74;
    }

    private Double zrnsisadrate75;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE75)
    public Double getZrnsisadrate75() {
        return zrnsisadrate75;
    }

    public void setZrnsisadrate75(Double pZrnsisadrate75) {
        zrnsisadrate75 = pZrnsisadrate75;
    }

    private Double zrnsisadrate76;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE76)
    public Double getZrnsisadrate76() {
        return zrnsisadrate76;
    }

    public void setZrnsisadrate76(Double pZrnsisadrate76) {
        zrnsisadrate76 = pZrnsisadrate76;
    }

    private Double zrnsisadrate77;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE77)
    public Double getZrnsisadrate77() {
        return zrnsisadrate77;
    }

    public void setZrnsisadrate77(Double pZrnsisadrate77) {
        zrnsisadrate77 = pZrnsisadrate77;
    }

    private Double zrnsisadrate78;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE78)
    public Double getZrnsisadrate78() {
        return zrnsisadrate78;
    }

    public void setZrnsisadrate78(Double pZrnsisadrate78) {
        zrnsisadrate78 = pZrnsisadrate78;
    }

    private Double zrnsisadrate79;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE79)
    public Double getZrnsisadrate79() {
        return zrnsisadrate79;
    }

    public void setZrnsisadrate79(Double pZrnsisadrate79) {
        zrnsisadrate79 = pZrnsisadrate79;
    }

    private Double zrnsisadrate80;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE80)
    public Double getZrnsisadrate80() {
        return zrnsisadrate80;
    }

    public void setZrnsisadrate80(Double pZrnsisadrate80) {
        zrnsisadrate80 = pZrnsisadrate80;
    }

    private Double zrnsisadrate81;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE81)
    public Double getZrnsisadrate81() {
        return zrnsisadrate81;
    }

    public void setZrnsisadrate81(Double pZrnsisadrate81) {
        zrnsisadrate81 = pZrnsisadrate81;
    }

    private Double zrnsisadrate82;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE82)
    public Double getZrnsisadrate82() {
        return zrnsisadrate82;
    }

    public void setZrnsisadrate82(Double pZrnsisadrate82) {
        zrnsisadrate82 = pZrnsisadrate82;
    }

    private Double zrnsisadrate83;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE83)
    public Double getZrnsisadrate83() {
        return zrnsisadrate83;
    }

    public void setZrnsisadrate83(Double pZrnsisadrate83) {
        zrnsisadrate83 = pZrnsisadrate83;
    }

    private Double zrnsisadrate84;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE84)
    public Double getZrnsisadrate84() {
        return zrnsisadrate84;
    }

    public void setZrnsisadrate84(Double pZrnsisadrate84) {
        zrnsisadrate84 = pZrnsisadrate84;
    }

    private Double zrnsisadrate85;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE85)
    public Double getZrnsisadrate85() {
        return zrnsisadrate85;
    }

    public void setZrnsisadrate85(Double pZrnsisadrate85) {
        zrnsisadrate85 = pZrnsisadrate85;
    }

    private Double zrnsisadrate86;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE86)
    public Double getZrnsisadrate86() {
        return zrnsisadrate86;
    }

    public void setZrnsisadrate86(Double pZrnsisadrate86) {
        zrnsisadrate86 = pZrnsisadrate86;
    }

    private Double zrnsisadrate87;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE87)
    public Double getZrnsisadrate87() {
        return zrnsisadrate87;
    }

    public void setZrnsisadrate87(Double pZrnsisadrate87) {
        zrnsisadrate87 = pZrnsisadrate87;
    }

    private Double zrnsisadrate88;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE88)
    public Double getZrnsisadrate88() {
        return zrnsisadrate88;
    }

    public void setZrnsisadrate88(Double pZrnsisadrate88) {
        zrnsisadrate88 = pZrnsisadrate88;
    }

    private Double zrnsisadrate89;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE89)
    public Double getZrnsisadrate89() {
        return zrnsisadrate89;
    }

    public void setZrnsisadrate89(Double pZrnsisadrate89) {
        zrnsisadrate89 = pZrnsisadrate89;
    }

    private Double zrnsisadrate90;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE90)
    public Double getZrnsisadrate90() {
        return zrnsisadrate90;
    }

    public void setZrnsisadrate90(Double pZrnsisadrate90) {
        zrnsisadrate90 = pZrnsisadrate90;
    }

    private Double zrnsisadrate91;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE91)
    public Double getZrnsisadrate91() {
        return zrnsisadrate91;
    }

    public void setZrnsisadrate91(Double pZrnsisadrate91) {
        zrnsisadrate91 = pZrnsisadrate91;
    }

    private Double zrnsisadrate92;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE92)
    public Double getZrnsisadrate92() {
        return zrnsisadrate92;
    }

    public void setZrnsisadrate92(Double pZrnsisadrate92) {
        zrnsisadrate92 = pZrnsisadrate92;
    }

    private Double zrnsisadrate93;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE93)
    public Double getZrnsisadrate93() {
        return zrnsisadrate93;
    }

    public void setZrnsisadrate93(Double pZrnsisadrate93) {
        zrnsisadrate93 = pZrnsisadrate93;
    }

    private Double zrnsisadrate94;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE94)
    public Double getZrnsisadrate94() {
        return zrnsisadrate94;
    }

    public void setZrnsisadrate94(Double pZrnsisadrate94) {
        zrnsisadrate94 = pZrnsisadrate94;
    }

    private Double zrnsisadrate95;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE95)
    public Double getZrnsisadrate95() {
        return zrnsisadrate95;
    }

    public void setZrnsisadrate95(Double pZrnsisadrate95) {
        zrnsisadrate95 = pZrnsisadrate95;
    }

    private Double zrnsisadrate96;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE96)
    public Double getZrnsisadrate96() {
        return zrnsisadrate96;
    }

    public void setZrnsisadrate96(Double pZrnsisadrate96) {
        zrnsisadrate96 = pZrnsisadrate96;
    }

    private Double zrnsisadrate97;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE97)
    public Double getZrnsisadrate97() {
        return zrnsisadrate97;
    }

    public void setZrnsisadrate97(Double pZrnsisadrate97) {
        zrnsisadrate97 = pZrnsisadrate97;
    }

    private Double zrnsisadrate98;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE98)
    public Double getZrnsisadrate98() {
        return zrnsisadrate98;
    }

    public void setZrnsisadrate98(Double pZrnsisadrate98) {
        zrnsisadrate98 = pZrnsisadrate98;
    }

    private Double zrnsisadrate99;

    @Column(name=GenZT_RatedRn.ZRNSISADRATE99)
    public Double getZrnsisadrate99() {
        return zrnsisadrate99;
    }

    public void setZrnsisadrate99(Double pZrnsisadrate99) {
        zrnsisadrate99 = pZrnsisadrate99;
    }

    private Double zrnrisadrate00;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE00)
    public Double getZrnrisadrate00() {
        return zrnrisadrate00;
    }

    public void setZrnrisadrate00(Double pZrnrisadrate00) {
        zrnrisadrate00 = pZrnrisadrate00;
    }

    private Double zrnrisadrate01;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE01)
    public Double getZrnrisadrate01() {
        return zrnrisadrate01;
    }

    public void setZrnrisadrate01(Double pZrnrisadrate01) {
        zrnrisadrate01 = pZrnrisadrate01;
    }

    private Double zrnrisadrate02;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE02)
    public Double getZrnrisadrate02() {
        return zrnrisadrate02;
    }

    public void setZrnrisadrate02(Double pZrnrisadrate02) {
        zrnrisadrate02 = pZrnrisadrate02;
    }

    private Double zrnrisadrate03;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE03)
    public Double getZrnrisadrate03() {
        return zrnrisadrate03;
    }

    public void setZrnrisadrate03(Double pZrnrisadrate03) {
        zrnrisadrate03 = pZrnrisadrate03;
    }

    private Double zrnrisadrate04;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE04)
    public Double getZrnrisadrate04() {
        return zrnrisadrate04;
    }

    public void setZrnrisadrate04(Double pZrnrisadrate04) {
        zrnrisadrate04 = pZrnrisadrate04;
    }

    private Double zrnrisadrate05;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE05)
    public Double getZrnrisadrate05() {
        return zrnrisadrate05;
    }

    public void setZrnrisadrate05(Double pZrnrisadrate05) {
        zrnrisadrate05 = pZrnrisadrate05;
    }

    private Double zrnrisadrate06;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE06)
    public Double getZrnrisadrate06() {
        return zrnrisadrate06;
    }

    public void setZrnrisadrate06(Double pZrnrisadrate06) {
        zrnrisadrate06 = pZrnrisadrate06;
    }

    private Double zrnrisadrate07;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE07)
    public Double getZrnrisadrate07() {
        return zrnrisadrate07;
    }

    public void setZrnrisadrate07(Double pZrnrisadrate07) {
        zrnrisadrate07 = pZrnrisadrate07;
    }

    private Double zrnrisadrate08;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE08)
    public Double getZrnrisadrate08() {
        return zrnrisadrate08;
    }

    public void setZrnrisadrate08(Double pZrnrisadrate08) {
        zrnrisadrate08 = pZrnrisadrate08;
    }

    private Double zrnrisadrate09;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE09)
    public Double getZrnrisadrate09() {
        return zrnrisadrate09;
    }

    public void setZrnrisadrate09(Double pZrnrisadrate09) {
        zrnrisadrate09 = pZrnrisadrate09;
    }

    private Double zrnrisadrate10;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE10)
    public Double getZrnrisadrate10() {
        return zrnrisadrate10;
    }

    public void setZrnrisadrate10(Double pZrnrisadrate10) {
        zrnrisadrate10 = pZrnrisadrate10;
    }

    private Double zrnrisadrate11;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE11)
    public Double getZrnrisadrate11() {
        return zrnrisadrate11;
    }

    public void setZrnrisadrate11(Double pZrnrisadrate11) {
        zrnrisadrate11 = pZrnrisadrate11;
    }

    private Double zrnrisadrate12;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE12)
    public Double getZrnrisadrate12() {
        return zrnrisadrate12;
    }

    public void setZrnrisadrate12(Double pZrnrisadrate12) {
        zrnrisadrate12 = pZrnrisadrate12;
    }

    private Double zrnrisadrate13;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE13)
    public Double getZrnrisadrate13() {
        return zrnrisadrate13;
    }

    public void setZrnrisadrate13(Double pZrnrisadrate13) {
        zrnrisadrate13 = pZrnrisadrate13;
    }

    private Double zrnrisadrate14;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE14)
    public Double getZrnrisadrate14() {
        return zrnrisadrate14;
    }

    public void setZrnrisadrate14(Double pZrnrisadrate14) {
        zrnrisadrate14 = pZrnrisadrate14;
    }

    private Double zrnrisadrate15;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE15)
    public Double getZrnrisadrate15() {
        return zrnrisadrate15;
    }

    public void setZrnrisadrate15(Double pZrnrisadrate15) {
        zrnrisadrate15 = pZrnrisadrate15;
    }

    private Double zrnrisadrate16;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE16)
    public Double getZrnrisadrate16() {
        return zrnrisadrate16;
    }

    public void setZrnrisadrate16(Double pZrnrisadrate16) {
        zrnrisadrate16 = pZrnrisadrate16;
    }

    private Double zrnrisadrate17;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE17)
    public Double getZrnrisadrate17() {
        return zrnrisadrate17;
    }

    public void setZrnrisadrate17(Double pZrnrisadrate17) {
        zrnrisadrate17 = pZrnrisadrate17;
    }

    private Double zrnrisadrate18;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE18)
    public Double getZrnrisadrate18() {
        return zrnrisadrate18;
    }

    public void setZrnrisadrate18(Double pZrnrisadrate18) {
        zrnrisadrate18 = pZrnrisadrate18;
    }

    private Double zrnrisadrate19;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE19)
    public Double getZrnrisadrate19() {
        return zrnrisadrate19;
    }

    public void setZrnrisadrate19(Double pZrnrisadrate19) {
        zrnrisadrate19 = pZrnrisadrate19;
    }

    private Double zrnrisadrate20;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE20)
    public Double getZrnrisadrate20() {
        return zrnrisadrate20;
    }

    public void setZrnrisadrate20(Double pZrnrisadrate20) {
        zrnrisadrate20 = pZrnrisadrate20;
    }

    private Double zrnrisadrate21;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE21)
    public Double getZrnrisadrate21() {
        return zrnrisadrate21;
    }

    public void setZrnrisadrate21(Double pZrnrisadrate21) {
        zrnrisadrate21 = pZrnrisadrate21;
    }

    private Double zrnrisadrate22;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE22)
    public Double getZrnrisadrate22() {
        return zrnrisadrate22;
    }

    public void setZrnrisadrate22(Double pZrnrisadrate22) {
        zrnrisadrate22 = pZrnrisadrate22;
    }

    private Double zrnrisadrate23;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE23)
    public Double getZrnrisadrate23() {
        return zrnrisadrate23;
    }

    public void setZrnrisadrate23(Double pZrnrisadrate23) {
        zrnrisadrate23 = pZrnrisadrate23;
    }

    private Double zrnrisadrate24;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE24)
    public Double getZrnrisadrate24() {
        return zrnrisadrate24;
    }

    public void setZrnrisadrate24(Double pZrnrisadrate24) {
        zrnrisadrate24 = pZrnrisadrate24;
    }

    private Double zrnrisadrate25;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE25)
    public Double getZrnrisadrate25() {
        return zrnrisadrate25;
    }

    public void setZrnrisadrate25(Double pZrnrisadrate25) {
        zrnrisadrate25 = pZrnrisadrate25;
    }

    private Double zrnrisadrate26;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE26)
    public Double getZrnrisadrate26() {
        return zrnrisadrate26;
    }

    public void setZrnrisadrate26(Double pZrnrisadrate26) {
        zrnrisadrate26 = pZrnrisadrate26;
    }

    private Double zrnrisadrate27;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE27)
    public Double getZrnrisadrate27() {
        return zrnrisadrate27;
    }

    public void setZrnrisadrate27(Double pZrnrisadrate27) {
        zrnrisadrate27 = pZrnrisadrate27;
    }

    private Double zrnrisadrate28;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE28)
    public Double getZrnrisadrate28() {
        return zrnrisadrate28;
    }

    public void setZrnrisadrate28(Double pZrnrisadrate28) {
        zrnrisadrate28 = pZrnrisadrate28;
    }

    private Double zrnrisadrate29;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE29)
    public Double getZrnrisadrate29() {
        return zrnrisadrate29;
    }

    public void setZrnrisadrate29(Double pZrnrisadrate29) {
        zrnrisadrate29 = pZrnrisadrate29;
    }

    private Double zrnrisadrate30;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE30)
    public Double getZrnrisadrate30() {
        return zrnrisadrate30;
    }

    public void setZrnrisadrate30(Double pZrnrisadrate30) {
        zrnrisadrate30 = pZrnrisadrate30;
    }

    private Double zrnrisadrate31;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE31)
    public Double getZrnrisadrate31() {
        return zrnrisadrate31;
    }

    public void setZrnrisadrate31(Double pZrnrisadrate31) {
        zrnrisadrate31 = pZrnrisadrate31;
    }

    private Double zrnrisadrate32;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE32)
    public Double getZrnrisadrate32() {
        return zrnrisadrate32;
    }

    public void setZrnrisadrate32(Double pZrnrisadrate32) {
        zrnrisadrate32 = pZrnrisadrate32;
    }

    private Double zrnrisadrate33;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE33)
    public Double getZrnrisadrate33() {
        return zrnrisadrate33;
    }

    public void setZrnrisadrate33(Double pZrnrisadrate33) {
        zrnrisadrate33 = pZrnrisadrate33;
    }

    private Double zrnrisadrate34;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE34)
    public Double getZrnrisadrate34() {
        return zrnrisadrate34;
    }

    public void setZrnrisadrate34(Double pZrnrisadrate34) {
        zrnrisadrate34 = pZrnrisadrate34;
    }

    private Double zrnrisadrate35;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE35)
    public Double getZrnrisadrate35() {
        return zrnrisadrate35;
    }

    public void setZrnrisadrate35(Double pZrnrisadrate35) {
        zrnrisadrate35 = pZrnrisadrate35;
    }

    private Double zrnrisadrate36;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE36)
    public Double getZrnrisadrate36() {
        return zrnrisadrate36;
    }

    public void setZrnrisadrate36(Double pZrnrisadrate36) {
        zrnrisadrate36 = pZrnrisadrate36;
    }

    private Double zrnrisadrate37;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE37)
    public Double getZrnrisadrate37() {
        return zrnrisadrate37;
    }

    public void setZrnrisadrate37(Double pZrnrisadrate37) {
        zrnrisadrate37 = pZrnrisadrate37;
    }

    private Double zrnrisadrate38;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE38)
    public Double getZrnrisadrate38() {
        return zrnrisadrate38;
    }

    public void setZrnrisadrate38(Double pZrnrisadrate38) {
        zrnrisadrate38 = pZrnrisadrate38;
    }

    private Double zrnrisadrate39;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE39)
    public Double getZrnrisadrate39() {
        return zrnrisadrate39;
    }

    public void setZrnrisadrate39(Double pZrnrisadrate39) {
        zrnrisadrate39 = pZrnrisadrate39;
    }

    private Double zrnrisadrate40;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE40)
    public Double getZrnrisadrate40() {
        return zrnrisadrate40;
    }

    public void setZrnrisadrate40(Double pZrnrisadrate40) {
        zrnrisadrate40 = pZrnrisadrate40;
    }

    private Double zrnrisadrate41;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE41)
    public Double getZrnrisadrate41() {
        return zrnrisadrate41;
    }

    public void setZrnrisadrate41(Double pZrnrisadrate41) {
        zrnrisadrate41 = pZrnrisadrate41;
    }

    private Double zrnrisadrate42;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE42)
    public Double getZrnrisadrate42() {
        return zrnrisadrate42;
    }

    public void setZrnrisadrate42(Double pZrnrisadrate42) {
        zrnrisadrate42 = pZrnrisadrate42;
    }

    private Double zrnrisadrate43;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE43)
    public Double getZrnrisadrate43() {
        return zrnrisadrate43;
    }

    public void setZrnrisadrate43(Double pZrnrisadrate43) {
        zrnrisadrate43 = pZrnrisadrate43;
    }

    private Double zrnrisadrate44;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE44)
    public Double getZrnrisadrate44() {
        return zrnrisadrate44;
    }

    public void setZrnrisadrate44(Double pZrnrisadrate44) {
        zrnrisadrate44 = pZrnrisadrate44;
    }

    private Double zrnrisadrate45;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE45)
    public Double getZrnrisadrate45() {
        return zrnrisadrate45;
    }

    public void setZrnrisadrate45(Double pZrnrisadrate45) {
        zrnrisadrate45 = pZrnrisadrate45;
    }

    private Double zrnrisadrate46;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE46)
    public Double getZrnrisadrate46() {
        return zrnrisadrate46;
    }

    public void setZrnrisadrate46(Double pZrnrisadrate46) {
        zrnrisadrate46 = pZrnrisadrate46;
    }

    private Double zrnrisadrate47;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE47)
    public Double getZrnrisadrate47() {
        return zrnrisadrate47;
    }

    public void setZrnrisadrate47(Double pZrnrisadrate47) {
        zrnrisadrate47 = pZrnrisadrate47;
    }

    private Double zrnrisadrate48;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE48)
    public Double getZrnrisadrate48() {
        return zrnrisadrate48;
    }

    public void setZrnrisadrate48(Double pZrnrisadrate48) {
        zrnrisadrate48 = pZrnrisadrate48;
    }

    private Double zrnrisadrate49;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE49)
    public Double getZrnrisadrate49() {
        return zrnrisadrate49;
    }

    public void setZrnrisadrate49(Double pZrnrisadrate49) {
        zrnrisadrate49 = pZrnrisadrate49;
    }

    private Double zrnrisadrate50;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE50)
    public Double getZrnrisadrate50() {
        return zrnrisadrate50;
    }

    public void setZrnrisadrate50(Double pZrnrisadrate50) {
        zrnrisadrate50 = pZrnrisadrate50;
    }

    private Double zrnrisadrate51;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE51)
    public Double getZrnrisadrate51() {
        return zrnrisadrate51;
    }

    public void setZrnrisadrate51(Double pZrnrisadrate51) {
        zrnrisadrate51 = pZrnrisadrate51;
    }

    private Double zrnrisadrate52;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE52)
    public Double getZrnrisadrate52() {
        return zrnrisadrate52;
    }

    public void setZrnrisadrate52(Double pZrnrisadrate52) {
        zrnrisadrate52 = pZrnrisadrate52;
    }

    private Double zrnrisadrate53;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE53)
    public Double getZrnrisadrate53() {
        return zrnrisadrate53;
    }

    public void setZrnrisadrate53(Double pZrnrisadrate53) {
        zrnrisadrate53 = pZrnrisadrate53;
    }

    private Double zrnrisadrate54;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE54)
    public Double getZrnrisadrate54() {
        return zrnrisadrate54;
    }

    public void setZrnrisadrate54(Double pZrnrisadrate54) {
        zrnrisadrate54 = pZrnrisadrate54;
    }

    private Double zrnrisadrate55;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE55)
    public Double getZrnrisadrate55() {
        return zrnrisadrate55;
    }

    public void setZrnrisadrate55(Double pZrnrisadrate55) {
        zrnrisadrate55 = pZrnrisadrate55;
    }

    private Double zrnrisadrate56;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE56)
    public Double getZrnrisadrate56() {
        return zrnrisadrate56;
    }

    public void setZrnrisadrate56(Double pZrnrisadrate56) {
        zrnrisadrate56 = pZrnrisadrate56;
    }

    private Double zrnrisadrate57;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE57)
    public Double getZrnrisadrate57() {
        return zrnrisadrate57;
    }

    public void setZrnrisadrate57(Double pZrnrisadrate57) {
        zrnrisadrate57 = pZrnrisadrate57;
    }

    private Double zrnrisadrate58;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE58)
    public Double getZrnrisadrate58() {
        return zrnrisadrate58;
    }

    public void setZrnrisadrate58(Double pZrnrisadrate58) {
        zrnrisadrate58 = pZrnrisadrate58;
    }

    private Double zrnrisadrate59;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE59)
    public Double getZrnrisadrate59() {
        return zrnrisadrate59;
    }

    public void setZrnrisadrate59(Double pZrnrisadrate59) {
        zrnrisadrate59 = pZrnrisadrate59;
    }

    private Double zrnrisadrate60;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE60)
    public Double getZrnrisadrate60() {
        return zrnrisadrate60;
    }

    public void setZrnrisadrate60(Double pZrnrisadrate60) {
        zrnrisadrate60 = pZrnrisadrate60;
    }

    private Double zrnrisadrate61;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE61)
    public Double getZrnrisadrate61() {
        return zrnrisadrate61;
    }

    public void setZrnrisadrate61(Double pZrnrisadrate61) {
        zrnrisadrate61 = pZrnrisadrate61;
    }

    private Double zrnrisadrate62;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE62)
    public Double getZrnrisadrate62() {
        return zrnrisadrate62;
    }

    public void setZrnrisadrate62(Double pZrnrisadrate62) {
        zrnrisadrate62 = pZrnrisadrate62;
    }

    private Double zrnrisadrate63;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE63)
    public Double getZrnrisadrate63() {
        return zrnrisadrate63;
    }

    public void setZrnrisadrate63(Double pZrnrisadrate63) {
        zrnrisadrate63 = pZrnrisadrate63;
    }

    private Double zrnrisadrate64;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE64)
    public Double getZrnrisadrate64() {
        return zrnrisadrate64;
    }

    public void setZrnrisadrate64(Double pZrnrisadrate64) {
        zrnrisadrate64 = pZrnrisadrate64;
    }

    private Double zrnrisadrate65;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE65)
    public Double getZrnrisadrate65() {
        return zrnrisadrate65;
    }

    public void setZrnrisadrate65(Double pZrnrisadrate65) {
        zrnrisadrate65 = pZrnrisadrate65;
    }

    private Double zrnrisadrate66;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE66)
    public Double getZrnrisadrate66() {
        return zrnrisadrate66;
    }

    public void setZrnrisadrate66(Double pZrnrisadrate66) {
        zrnrisadrate66 = pZrnrisadrate66;
    }

    private Double zrnrisadrate67;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE67)
    public Double getZrnrisadrate67() {
        return zrnrisadrate67;
    }

    public void setZrnrisadrate67(Double pZrnrisadrate67) {
        zrnrisadrate67 = pZrnrisadrate67;
    }

    private Double zrnrisadrate68;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE68)
    public Double getZrnrisadrate68() {
        return zrnrisadrate68;
    }

    public void setZrnrisadrate68(Double pZrnrisadrate68) {
        zrnrisadrate68 = pZrnrisadrate68;
    }

    private Double zrnrisadrate69;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE69)
    public Double getZrnrisadrate69() {
        return zrnrisadrate69;
    }

    public void setZrnrisadrate69(Double pZrnrisadrate69) {
        zrnrisadrate69 = pZrnrisadrate69;
    }

    private Double zrnrisadrate70;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE70)
    public Double getZrnrisadrate70() {
        return zrnrisadrate70;
    }

    public void setZrnrisadrate70(Double pZrnrisadrate70) {
        zrnrisadrate70 = pZrnrisadrate70;
    }

    private Double zrnrisadrate71;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE71)
    public Double getZrnrisadrate71() {
        return zrnrisadrate71;
    }

    public void setZrnrisadrate71(Double pZrnrisadrate71) {
        zrnrisadrate71 = pZrnrisadrate71;
    }

    private Double zrnrisadrate72;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE72)
    public Double getZrnrisadrate72() {
        return zrnrisadrate72;
    }

    public void setZrnrisadrate72(Double pZrnrisadrate72) {
        zrnrisadrate72 = pZrnrisadrate72;
    }

    private Double zrnrisadrate73;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE73)
    public Double getZrnrisadrate73() {
        return zrnrisadrate73;
    }

    public void setZrnrisadrate73(Double pZrnrisadrate73) {
        zrnrisadrate73 = pZrnrisadrate73;
    }

    private Double zrnrisadrate74;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE74)
    public Double getZrnrisadrate74() {
        return zrnrisadrate74;
    }

    public void setZrnrisadrate74(Double pZrnrisadrate74) {
        zrnrisadrate74 = pZrnrisadrate74;
    }

    private Double zrnrisadrate75;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE75)
    public Double getZrnrisadrate75() {
        return zrnrisadrate75;
    }

    public void setZrnrisadrate75(Double pZrnrisadrate75) {
        zrnrisadrate75 = pZrnrisadrate75;
    }

    private Double zrnrisadrate76;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE76)
    public Double getZrnrisadrate76() {
        return zrnrisadrate76;
    }

    public void setZrnrisadrate76(Double pZrnrisadrate76) {
        zrnrisadrate76 = pZrnrisadrate76;
    }

    private Double zrnrisadrate77;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE77)
    public Double getZrnrisadrate77() {
        return zrnrisadrate77;
    }

    public void setZrnrisadrate77(Double pZrnrisadrate77) {
        zrnrisadrate77 = pZrnrisadrate77;
    }

    private Double zrnrisadrate78;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE78)
    public Double getZrnrisadrate78() {
        return zrnrisadrate78;
    }

    public void setZrnrisadrate78(Double pZrnrisadrate78) {
        zrnrisadrate78 = pZrnrisadrate78;
    }

    private Double zrnrisadrate79;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE79)
    public Double getZrnrisadrate79() {
        return zrnrisadrate79;
    }

    public void setZrnrisadrate79(Double pZrnrisadrate79) {
        zrnrisadrate79 = pZrnrisadrate79;
    }

    private Double zrnrisadrate80;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE80)
    public Double getZrnrisadrate80() {
        return zrnrisadrate80;
    }

    public void setZrnrisadrate80(Double pZrnrisadrate80) {
        zrnrisadrate80 = pZrnrisadrate80;
    }

    private Double zrnrisadrate81;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE81)
    public Double getZrnrisadrate81() {
        return zrnrisadrate81;
    }

    public void setZrnrisadrate81(Double pZrnrisadrate81) {
        zrnrisadrate81 = pZrnrisadrate81;
    }

    private Double zrnrisadrate82;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE82)
    public Double getZrnrisadrate82() {
        return zrnrisadrate82;
    }

    public void setZrnrisadrate82(Double pZrnrisadrate82) {
        zrnrisadrate82 = pZrnrisadrate82;
    }

    private Double zrnrisadrate83;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE83)
    public Double getZrnrisadrate83() {
        return zrnrisadrate83;
    }

    public void setZrnrisadrate83(Double pZrnrisadrate83) {
        zrnrisadrate83 = pZrnrisadrate83;
    }

    private Double zrnrisadrate84;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE84)
    public Double getZrnrisadrate84() {
        return zrnrisadrate84;
    }

    public void setZrnrisadrate84(Double pZrnrisadrate84) {
        zrnrisadrate84 = pZrnrisadrate84;
    }

    private Double zrnrisadrate85;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE85)
    public Double getZrnrisadrate85() {
        return zrnrisadrate85;
    }

    public void setZrnrisadrate85(Double pZrnrisadrate85) {
        zrnrisadrate85 = pZrnrisadrate85;
    }

    private Double zrnrisadrate86;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE86)
    public Double getZrnrisadrate86() {
        return zrnrisadrate86;
    }

    public void setZrnrisadrate86(Double pZrnrisadrate86) {
        zrnrisadrate86 = pZrnrisadrate86;
    }

    private Double zrnrisadrate87;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE87)
    public Double getZrnrisadrate87() {
        return zrnrisadrate87;
    }

    public void setZrnrisadrate87(Double pZrnrisadrate87) {
        zrnrisadrate87 = pZrnrisadrate87;
    }

    private Double zrnrisadrate88;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE88)
    public Double getZrnrisadrate88() {
        return zrnrisadrate88;
    }

    public void setZrnrisadrate88(Double pZrnrisadrate88) {
        zrnrisadrate88 = pZrnrisadrate88;
    }

    private Double zrnrisadrate89;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE89)
    public Double getZrnrisadrate89() {
        return zrnrisadrate89;
    }

    public void setZrnrisadrate89(Double pZrnrisadrate89) {
        zrnrisadrate89 = pZrnrisadrate89;
    }

    private Double zrnrisadrate90;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE90)
    public Double getZrnrisadrate90() {
        return zrnrisadrate90;
    }

    public void setZrnrisadrate90(Double pZrnrisadrate90) {
        zrnrisadrate90 = pZrnrisadrate90;
    }

    private Double zrnrisadrate91;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE91)
    public Double getZrnrisadrate91() {
        return zrnrisadrate91;
    }

    public void setZrnrisadrate91(Double pZrnrisadrate91) {
        zrnrisadrate91 = pZrnrisadrate91;
    }

    private Double zrnrisadrate92;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE92)
    public Double getZrnrisadrate92() {
        return zrnrisadrate92;
    }

    public void setZrnrisadrate92(Double pZrnrisadrate92) {
        zrnrisadrate92 = pZrnrisadrate92;
    }

    private Double zrnrisadrate93;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE93)
    public Double getZrnrisadrate93() {
        return zrnrisadrate93;
    }

    public void setZrnrisadrate93(Double pZrnrisadrate93) {
        zrnrisadrate93 = pZrnrisadrate93;
    }

    private Double zrnrisadrate94;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE94)
    public Double getZrnrisadrate94() {
        return zrnrisadrate94;
    }

    public void setZrnrisadrate94(Double pZrnrisadrate94) {
        zrnrisadrate94 = pZrnrisadrate94;
    }

    private Double zrnrisadrate95;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE95)
    public Double getZrnrisadrate95() {
        return zrnrisadrate95;
    }

    public void setZrnrisadrate95(Double pZrnrisadrate95) {
        zrnrisadrate95 = pZrnrisadrate95;
    }

    private Double zrnrisadrate96;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE96)
    public Double getZrnrisadrate96() {
        return zrnrisadrate96;
    }

    public void setZrnrisadrate96(Double pZrnrisadrate96) {
        zrnrisadrate96 = pZrnrisadrate96;
    }

    private Double zrnrisadrate97;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE97)
    public Double getZrnrisadrate97() {
        return zrnrisadrate97;
    }

    public void setZrnrisadrate97(Double pZrnrisadrate97) {
        zrnrisadrate97 = pZrnrisadrate97;
    }

    private Double zrnrisadrate98;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE98)
    public Double getZrnrisadrate98() {
        return zrnrisadrate98;
    }

    public void setZrnrisadrate98(Double pZrnrisadrate98) {
        zrnrisadrate98 = pZrnrisadrate98;
    }

    private Double zrnrisadrate99;

    @Column(name=GenZT_RatedRn.ZRNRISADRATE99)
    public Double getZrnrisadrate99() {
        return zrnrisadrate99;
    }

    public void setZrnrisadrate99(Double pZrnrisadrate99) {
        zrnrisadrate99 = pZrnrisadrate99;
    }

    private Double zrnhisadrate00;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE00)
    public Double getZrnhisadrate00() {
        return zrnhisadrate00;
    }

    public void setZrnhisadrate00(Double pZrnhisadrate00) {
        zrnhisadrate00 = pZrnhisadrate00;
    }

    private Double zrnhisadrate01;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE01)
    public Double getZrnhisadrate01() {
        return zrnhisadrate01;
    }

    public void setZrnhisadrate01(Double pZrnhisadrate01) {
        zrnhisadrate01 = pZrnhisadrate01;
    }

    private Double zrnhisadrate02;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE02)
    public Double getZrnhisadrate02() {
        return zrnhisadrate02;
    }

    public void setZrnhisadrate02(Double pZrnhisadrate02) {
        zrnhisadrate02 = pZrnhisadrate02;
    }

    private Double zrnhisadrate03;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE03)
    public Double getZrnhisadrate03() {
        return zrnhisadrate03;
    }

    public void setZrnhisadrate03(Double pZrnhisadrate03) {
        zrnhisadrate03 = pZrnhisadrate03;
    }

    private Double zrnhisadrate04;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE04)
    public Double getZrnhisadrate04() {
        return zrnhisadrate04;
    }

    public void setZrnhisadrate04(Double pZrnhisadrate04) {
        zrnhisadrate04 = pZrnhisadrate04;
    }

    private Double zrnhisadrate05;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE05)
    public Double getZrnhisadrate05() {
        return zrnhisadrate05;
    }

    public void setZrnhisadrate05(Double pZrnhisadrate05) {
        zrnhisadrate05 = pZrnhisadrate05;
    }

    private Double zrnhisadrate06;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE06)
    public Double getZrnhisadrate06() {
        return zrnhisadrate06;
    }

    public void setZrnhisadrate06(Double pZrnhisadrate06) {
        zrnhisadrate06 = pZrnhisadrate06;
    }

    private Double zrnhisadrate07;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE07)
    public Double getZrnhisadrate07() {
        return zrnhisadrate07;
    }

    public void setZrnhisadrate07(Double pZrnhisadrate07) {
        zrnhisadrate07 = pZrnhisadrate07;
    }

    private Double zrnhisadrate08;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE08)
    public Double getZrnhisadrate08() {
        return zrnhisadrate08;
    }

    public void setZrnhisadrate08(Double pZrnhisadrate08) {
        zrnhisadrate08 = pZrnhisadrate08;
    }

    private Double zrnhisadrate09;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE09)
    public Double getZrnhisadrate09() {
        return zrnhisadrate09;
    }

    public void setZrnhisadrate09(Double pZrnhisadrate09) {
        zrnhisadrate09 = pZrnhisadrate09;
    }

    private Double zrnhisadrate10;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE10)
    public Double getZrnhisadrate10() {
        return zrnhisadrate10;
    }

    public void setZrnhisadrate10(Double pZrnhisadrate10) {
        zrnhisadrate10 = pZrnhisadrate10;
    }

    private Double zrnhisadrate11;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE11)
    public Double getZrnhisadrate11() {
        return zrnhisadrate11;
    }

    public void setZrnhisadrate11(Double pZrnhisadrate11) {
        zrnhisadrate11 = pZrnhisadrate11;
    }

    private Double zrnhisadrate12;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE12)
    public Double getZrnhisadrate12() {
        return zrnhisadrate12;
    }

    public void setZrnhisadrate12(Double pZrnhisadrate12) {
        zrnhisadrate12 = pZrnhisadrate12;
    }

    private Double zrnhisadrate13;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE13)
    public Double getZrnhisadrate13() {
        return zrnhisadrate13;
    }

    public void setZrnhisadrate13(Double pZrnhisadrate13) {
        zrnhisadrate13 = pZrnhisadrate13;
    }

    private Double zrnhisadrate14;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE14)
    public Double getZrnhisadrate14() {
        return zrnhisadrate14;
    }

    public void setZrnhisadrate14(Double pZrnhisadrate14) {
        zrnhisadrate14 = pZrnhisadrate14;
    }

    private Double zrnhisadrate15;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE15)
    public Double getZrnhisadrate15() {
        return zrnhisadrate15;
    }

    public void setZrnhisadrate15(Double pZrnhisadrate15) {
        zrnhisadrate15 = pZrnhisadrate15;
    }

    private Double zrnhisadrate16;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE16)
    public Double getZrnhisadrate16() {
        return zrnhisadrate16;
    }

    public void setZrnhisadrate16(Double pZrnhisadrate16) {
        zrnhisadrate16 = pZrnhisadrate16;
    }

    private Double zrnhisadrate17;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE17)
    public Double getZrnhisadrate17() {
        return zrnhisadrate17;
    }

    public void setZrnhisadrate17(Double pZrnhisadrate17) {
        zrnhisadrate17 = pZrnhisadrate17;
    }

    private Double zrnhisadrate18;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE18)
    public Double getZrnhisadrate18() {
        return zrnhisadrate18;
    }

    public void setZrnhisadrate18(Double pZrnhisadrate18) {
        zrnhisadrate18 = pZrnhisadrate18;
    }

    private Double zrnhisadrate19;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE19)
    public Double getZrnhisadrate19() {
        return zrnhisadrate19;
    }

    public void setZrnhisadrate19(Double pZrnhisadrate19) {
        zrnhisadrate19 = pZrnhisadrate19;
    }

    private Double zrnhisadrate20;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE20)
    public Double getZrnhisadrate20() {
        return zrnhisadrate20;
    }

    public void setZrnhisadrate20(Double pZrnhisadrate20) {
        zrnhisadrate20 = pZrnhisadrate20;
    }

    private Double zrnhisadrate21;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE21)
    public Double getZrnhisadrate21() {
        return zrnhisadrate21;
    }

    public void setZrnhisadrate21(Double pZrnhisadrate21) {
        zrnhisadrate21 = pZrnhisadrate21;
    }

    private Double zrnhisadrate22;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE22)
    public Double getZrnhisadrate22() {
        return zrnhisadrate22;
    }

    public void setZrnhisadrate22(Double pZrnhisadrate22) {
        zrnhisadrate22 = pZrnhisadrate22;
    }

    private Double zrnhisadrate23;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE23)
    public Double getZrnhisadrate23() {
        return zrnhisadrate23;
    }

    public void setZrnhisadrate23(Double pZrnhisadrate23) {
        zrnhisadrate23 = pZrnhisadrate23;
    }

    private Double zrnhisadrate24;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE24)
    public Double getZrnhisadrate24() {
        return zrnhisadrate24;
    }

    public void setZrnhisadrate24(Double pZrnhisadrate24) {
        zrnhisadrate24 = pZrnhisadrate24;
    }

    private Double zrnhisadrate25;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE25)
    public Double getZrnhisadrate25() {
        return zrnhisadrate25;
    }

    public void setZrnhisadrate25(Double pZrnhisadrate25) {
        zrnhisadrate25 = pZrnhisadrate25;
    }

    private Double zrnhisadrate26;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE26)
    public Double getZrnhisadrate26() {
        return zrnhisadrate26;
    }

    public void setZrnhisadrate26(Double pZrnhisadrate26) {
        zrnhisadrate26 = pZrnhisadrate26;
    }

    private Double zrnhisadrate27;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE27)
    public Double getZrnhisadrate27() {
        return zrnhisadrate27;
    }

    public void setZrnhisadrate27(Double pZrnhisadrate27) {
        zrnhisadrate27 = pZrnhisadrate27;
    }

    private Double zrnhisadrate28;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE28)
    public Double getZrnhisadrate28() {
        return zrnhisadrate28;
    }

    public void setZrnhisadrate28(Double pZrnhisadrate28) {
        zrnhisadrate28 = pZrnhisadrate28;
    }

    private Double zrnhisadrate29;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE29)
    public Double getZrnhisadrate29() {
        return zrnhisadrate29;
    }

    public void setZrnhisadrate29(Double pZrnhisadrate29) {
        zrnhisadrate29 = pZrnhisadrate29;
    }

    private Double zrnhisadrate30;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE30)
    public Double getZrnhisadrate30() {
        return zrnhisadrate30;
    }

    public void setZrnhisadrate30(Double pZrnhisadrate30) {
        zrnhisadrate30 = pZrnhisadrate30;
    }

    private Double zrnhisadrate31;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE31)
    public Double getZrnhisadrate31() {
        return zrnhisadrate31;
    }

    public void setZrnhisadrate31(Double pZrnhisadrate31) {
        zrnhisadrate31 = pZrnhisadrate31;
    }

    private Double zrnhisadrate32;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE32)
    public Double getZrnhisadrate32() {
        return zrnhisadrate32;
    }

    public void setZrnhisadrate32(Double pZrnhisadrate32) {
        zrnhisadrate32 = pZrnhisadrate32;
    }

    private Double zrnhisadrate33;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE33)
    public Double getZrnhisadrate33() {
        return zrnhisadrate33;
    }

    public void setZrnhisadrate33(Double pZrnhisadrate33) {
        zrnhisadrate33 = pZrnhisadrate33;
    }

    private Double zrnhisadrate34;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE34)
    public Double getZrnhisadrate34() {
        return zrnhisadrate34;
    }

    public void setZrnhisadrate34(Double pZrnhisadrate34) {
        zrnhisadrate34 = pZrnhisadrate34;
    }

    private Double zrnhisadrate35;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE35)
    public Double getZrnhisadrate35() {
        return zrnhisadrate35;
    }

    public void setZrnhisadrate35(Double pZrnhisadrate35) {
        zrnhisadrate35 = pZrnhisadrate35;
    }

    private Double zrnhisadrate36;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE36)
    public Double getZrnhisadrate36() {
        return zrnhisadrate36;
    }

    public void setZrnhisadrate36(Double pZrnhisadrate36) {
        zrnhisadrate36 = pZrnhisadrate36;
    }

    private Double zrnhisadrate37;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE37)
    public Double getZrnhisadrate37() {
        return zrnhisadrate37;
    }

    public void setZrnhisadrate37(Double pZrnhisadrate37) {
        zrnhisadrate37 = pZrnhisadrate37;
    }

    private Double zrnhisadrate38;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE38)
    public Double getZrnhisadrate38() {
        return zrnhisadrate38;
    }

    public void setZrnhisadrate38(Double pZrnhisadrate38) {
        zrnhisadrate38 = pZrnhisadrate38;
    }

    private Double zrnhisadrate39;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE39)
    public Double getZrnhisadrate39() {
        return zrnhisadrate39;
    }

    public void setZrnhisadrate39(Double pZrnhisadrate39) {
        zrnhisadrate39 = pZrnhisadrate39;
    }

    private Double zrnhisadrate40;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE40)
    public Double getZrnhisadrate40() {
        return zrnhisadrate40;
    }

    public void setZrnhisadrate40(Double pZrnhisadrate40) {
        zrnhisadrate40 = pZrnhisadrate40;
    }

    private Double zrnhisadrate41;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE41)
    public Double getZrnhisadrate41() {
        return zrnhisadrate41;
    }

    public void setZrnhisadrate41(Double pZrnhisadrate41) {
        zrnhisadrate41 = pZrnhisadrate41;
    }

    private Double zrnhisadrate42;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE42)
    public Double getZrnhisadrate42() {
        return zrnhisadrate42;
    }

    public void setZrnhisadrate42(Double pZrnhisadrate42) {
        zrnhisadrate42 = pZrnhisadrate42;
    }

    private Double zrnhisadrate43;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE43)
    public Double getZrnhisadrate43() {
        return zrnhisadrate43;
    }

    public void setZrnhisadrate43(Double pZrnhisadrate43) {
        zrnhisadrate43 = pZrnhisadrate43;
    }

    private Double zrnhisadrate44;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE44)
    public Double getZrnhisadrate44() {
        return zrnhisadrate44;
    }

    public void setZrnhisadrate44(Double pZrnhisadrate44) {
        zrnhisadrate44 = pZrnhisadrate44;
    }

    private Double zrnhisadrate45;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE45)
    public Double getZrnhisadrate45() {
        return zrnhisadrate45;
    }

    public void setZrnhisadrate45(Double pZrnhisadrate45) {
        zrnhisadrate45 = pZrnhisadrate45;
    }

    private Double zrnhisadrate46;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE46)
    public Double getZrnhisadrate46() {
        return zrnhisadrate46;
    }

    public void setZrnhisadrate46(Double pZrnhisadrate46) {
        zrnhisadrate46 = pZrnhisadrate46;
    }

    private Double zrnhisadrate47;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE47)
    public Double getZrnhisadrate47() {
        return zrnhisadrate47;
    }

    public void setZrnhisadrate47(Double pZrnhisadrate47) {
        zrnhisadrate47 = pZrnhisadrate47;
    }

    private Double zrnhisadrate48;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE48)
    public Double getZrnhisadrate48() {
        return zrnhisadrate48;
    }

    public void setZrnhisadrate48(Double pZrnhisadrate48) {
        zrnhisadrate48 = pZrnhisadrate48;
    }

    private Double zrnhisadrate49;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE49)
    public Double getZrnhisadrate49() {
        return zrnhisadrate49;
    }

    public void setZrnhisadrate49(Double pZrnhisadrate49) {
        zrnhisadrate49 = pZrnhisadrate49;
    }

    private Double zrnhisadrate50;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE50)
    public Double getZrnhisadrate50() {
        return zrnhisadrate50;
    }

    public void setZrnhisadrate50(Double pZrnhisadrate50) {
        zrnhisadrate50 = pZrnhisadrate50;
    }

    private Double zrnhisadrate51;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE51)
    public Double getZrnhisadrate51() {
        return zrnhisadrate51;
    }

    public void setZrnhisadrate51(Double pZrnhisadrate51) {
        zrnhisadrate51 = pZrnhisadrate51;
    }

    private Double zrnhisadrate52;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE52)
    public Double getZrnhisadrate52() {
        return zrnhisadrate52;
    }

    public void setZrnhisadrate52(Double pZrnhisadrate52) {
        zrnhisadrate52 = pZrnhisadrate52;
    }

    private Double zrnhisadrate53;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE53)
    public Double getZrnhisadrate53() {
        return zrnhisadrate53;
    }

    public void setZrnhisadrate53(Double pZrnhisadrate53) {
        zrnhisadrate53 = pZrnhisadrate53;
    }

    private Double zrnhisadrate54;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE54)
    public Double getZrnhisadrate54() {
        return zrnhisadrate54;
    }

    public void setZrnhisadrate54(Double pZrnhisadrate54) {
        zrnhisadrate54 = pZrnhisadrate54;
    }

    private Double zrnhisadrate55;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE55)
    public Double getZrnhisadrate55() {
        return zrnhisadrate55;
    }

    public void setZrnhisadrate55(Double pZrnhisadrate55) {
        zrnhisadrate55 = pZrnhisadrate55;
    }

    private Double zrnhisadrate56;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE56)
    public Double getZrnhisadrate56() {
        return zrnhisadrate56;
    }

    public void setZrnhisadrate56(Double pZrnhisadrate56) {
        zrnhisadrate56 = pZrnhisadrate56;
    }

    private Double zrnhisadrate57;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE57)
    public Double getZrnhisadrate57() {
        return zrnhisadrate57;
    }

    public void setZrnhisadrate57(Double pZrnhisadrate57) {
        zrnhisadrate57 = pZrnhisadrate57;
    }

    private Double zrnhisadrate58;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE58)
    public Double getZrnhisadrate58() {
        return zrnhisadrate58;
    }

    public void setZrnhisadrate58(Double pZrnhisadrate58) {
        zrnhisadrate58 = pZrnhisadrate58;
    }

    private Double zrnhisadrate59;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE59)
    public Double getZrnhisadrate59() {
        return zrnhisadrate59;
    }

    public void setZrnhisadrate59(Double pZrnhisadrate59) {
        zrnhisadrate59 = pZrnhisadrate59;
    }

    private Double zrnhisadrate60;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE60)
    public Double getZrnhisadrate60() {
        return zrnhisadrate60;
    }

    public void setZrnhisadrate60(Double pZrnhisadrate60) {
        zrnhisadrate60 = pZrnhisadrate60;
    }

    private Double zrnhisadrate61;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE61)
    public Double getZrnhisadrate61() {
        return zrnhisadrate61;
    }

    public void setZrnhisadrate61(Double pZrnhisadrate61) {
        zrnhisadrate61 = pZrnhisadrate61;
    }

    private Double zrnhisadrate62;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE62)
    public Double getZrnhisadrate62() {
        return zrnhisadrate62;
    }

    public void setZrnhisadrate62(Double pZrnhisadrate62) {
        zrnhisadrate62 = pZrnhisadrate62;
    }

    private Double zrnhisadrate63;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE63)
    public Double getZrnhisadrate63() {
        return zrnhisadrate63;
    }

    public void setZrnhisadrate63(Double pZrnhisadrate63) {
        zrnhisadrate63 = pZrnhisadrate63;
    }

    private Double zrnhisadrate64;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE64)
    public Double getZrnhisadrate64() {
        return zrnhisadrate64;
    }

    public void setZrnhisadrate64(Double pZrnhisadrate64) {
        zrnhisadrate64 = pZrnhisadrate64;
    }

    private Double zrnhisadrate65;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE65)
    public Double getZrnhisadrate65() {
        return zrnhisadrate65;
    }

    public void setZrnhisadrate65(Double pZrnhisadrate65) {
        zrnhisadrate65 = pZrnhisadrate65;
    }

    private Double zrnhisadrate66;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE66)
    public Double getZrnhisadrate66() {
        return zrnhisadrate66;
    }

    public void setZrnhisadrate66(Double pZrnhisadrate66) {
        zrnhisadrate66 = pZrnhisadrate66;
    }

    private Double zrnhisadrate67;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE67)
    public Double getZrnhisadrate67() {
        return zrnhisadrate67;
    }

    public void setZrnhisadrate67(Double pZrnhisadrate67) {
        zrnhisadrate67 = pZrnhisadrate67;
    }

    private Double zrnhisadrate68;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE68)
    public Double getZrnhisadrate68() {
        return zrnhisadrate68;
    }

    public void setZrnhisadrate68(Double pZrnhisadrate68) {
        zrnhisadrate68 = pZrnhisadrate68;
    }

    private Double zrnhisadrate69;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE69)
    public Double getZrnhisadrate69() {
        return zrnhisadrate69;
    }

    public void setZrnhisadrate69(Double pZrnhisadrate69) {
        zrnhisadrate69 = pZrnhisadrate69;
    }

    private Double zrnhisadrate70;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE70)
    public Double getZrnhisadrate70() {
        return zrnhisadrate70;
    }

    public void setZrnhisadrate70(Double pZrnhisadrate70) {
        zrnhisadrate70 = pZrnhisadrate70;
    }

    private Double zrnhisadrate71;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE71)
    public Double getZrnhisadrate71() {
        return zrnhisadrate71;
    }

    public void setZrnhisadrate71(Double pZrnhisadrate71) {
        zrnhisadrate71 = pZrnhisadrate71;
    }

    private Double zrnhisadrate72;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE72)
    public Double getZrnhisadrate72() {
        return zrnhisadrate72;
    }

    public void setZrnhisadrate72(Double pZrnhisadrate72) {
        zrnhisadrate72 = pZrnhisadrate72;
    }

    private Double zrnhisadrate73;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE73)
    public Double getZrnhisadrate73() {
        return zrnhisadrate73;
    }

    public void setZrnhisadrate73(Double pZrnhisadrate73) {
        zrnhisadrate73 = pZrnhisadrate73;
    }

    private Double zrnhisadrate74;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE74)
    public Double getZrnhisadrate74() {
        return zrnhisadrate74;
    }

    public void setZrnhisadrate74(Double pZrnhisadrate74) {
        zrnhisadrate74 = pZrnhisadrate74;
    }

    private Double zrnhisadrate75;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE75)
    public Double getZrnhisadrate75() {
        return zrnhisadrate75;
    }

    public void setZrnhisadrate75(Double pZrnhisadrate75) {
        zrnhisadrate75 = pZrnhisadrate75;
    }

    private Double zrnhisadrate76;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE76)
    public Double getZrnhisadrate76() {
        return zrnhisadrate76;
    }

    public void setZrnhisadrate76(Double pZrnhisadrate76) {
        zrnhisadrate76 = pZrnhisadrate76;
    }

    private Double zrnhisadrate77;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE77)
    public Double getZrnhisadrate77() {
        return zrnhisadrate77;
    }

    public void setZrnhisadrate77(Double pZrnhisadrate77) {
        zrnhisadrate77 = pZrnhisadrate77;
    }

    private Double zrnhisadrate78;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE78)
    public Double getZrnhisadrate78() {
        return zrnhisadrate78;
    }

    public void setZrnhisadrate78(Double pZrnhisadrate78) {
        zrnhisadrate78 = pZrnhisadrate78;
    }

    private Double zrnhisadrate79;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE79)
    public Double getZrnhisadrate79() {
        return zrnhisadrate79;
    }

    public void setZrnhisadrate79(Double pZrnhisadrate79) {
        zrnhisadrate79 = pZrnhisadrate79;
    }

    private Double zrnhisadrate80;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE80)
    public Double getZrnhisadrate80() {
        return zrnhisadrate80;
    }

    public void setZrnhisadrate80(Double pZrnhisadrate80) {
        zrnhisadrate80 = pZrnhisadrate80;
    }

    private Double zrnhisadrate81;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE81)
    public Double getZrnhisadrate81() {
        return zrnhisadrate81;
    }

    public void setZrnhisadrate81(Double pZrnhisadrate81) {
        zrnhisadrate81 = pZrnhisadrate81;
    }

    private Double zrnhisadrate82;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE82)
    public Double getZrnhisadrate82() {
        return zrnhisadrate82;
    }

    public void setZrnhisadrate82(Double pZrnhisadrate82) {
        zrnhisadrate82 = pZrnhisadrate82;
    }

    private Double zrnhisadrate83;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE83)
    public Double getZrnhisadrate83() {
        return zrnhisadrate83;
    }

    public void setZrnhisadrate83(Double pZrnhisadrate83) {
        zrnhisadrate83 = pZrnhisadrate83;
    }

    private Double zrnhisadrate84;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE84)
    public Double getZrnhisadrate84() {
        return zrnhisadrate84;
    }

    public void setZrnhisadrate84(Double pZrnhisadrate84) {
        zrnhisadrate84 = pZrnhisadrate84;
    }

    private Double zrnhisadrate85;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE85)
    public Double getZrnhisadrate85() {
        return zrnhisadrate85;
    }

    public void setZrnhisadrate85(Double pZrnhisadrate85) {
        zrnhisadrate85 = pZrnhisadrate85;
    }

    private Double zrnhisadrate86;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE86)
    public Double getZrnhisadrate86() {
        return zrnhisadrate86;
    }

    public void setZrnhisadrate86(Double pZrnhisadrate86) {
        zrnhisadrate86 = pZrnhisadrate86;
    }

    private Double zrnhisadrate87;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE87)
    public Double getZrnhisadrate87() {
        return zrnhisadrate87;
    }

    public void setZrnhisadrate87(Double pZrnhisadrate87) {
        zrnhisadrate87 = pZrnhisadrate87;
    }

    private Double zrnhisadrate88;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE88)
    public Double getZrnhisadrate88() {
        return zrnhisadrate88;
    }

    public void setZrnhisadrate88(Double pZrnhisadrate88) {
        zrnhisadrate88 = pZrnhisadrate88;
    }

    private Double zrnhisadrate89;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE89)
    public Double getZrnhisadrate89() {
        return zrnhisadrate89;
    }

    public void setZrnhisadrate89(Double pZrnhisadrate89) {
        zrnhisadrate89 = pZrnhisadrate89;
    }

    private Double zrnhisadrate90;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE90)
    public Double getZrnhisadrate90() {
        return zrnhisadrate90;
    }

    public void setZrnhisadrate90(Double pZrnhisadrate90) {
        zrnhisadrate90 = pZrnhisadrate90;
    }

    private Double zrnhisadrate91;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE91)
    public Double getZrnhisadrate91() {
        return zrnhisadrate91;
    }

    public void setZrnhisadrate91(Double pZrnhisadrate91) {
        zrnhisadrate91 = pZrnhisadrate91;
    }

    private Double zrnhisadrate92;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE92)
    public Double getZrnhisadrate92() {
        return zrnhisadrate92;
    }

    public void setZrnhisadrate92(Double pZrnhisadrate92) {
        zrnhisadrate92 = pZrnhisadrate92;
    }

    private Double zrnhisadrate93;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE93)
    public Double getZrnhisadrate93() {
        return zrnhisadrate93;
    }

    public void setZrnhisadrate93(Double pZrnhisadrate93) {
        zrnhisadrate93 = pZrnhisadrate93;
    }

    private Double zrnhisadrate94;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE94)
    public Double getZrnhisadrate94() {
        return zrnhisadrate94;
    }

    public void setZrnhisadrate94(Double pZrnhisadrate94) {
        zrnhisadrate94 = pZrnhisadrate94;
    }

    private Double zrnhisadrate95;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE95)
    public Double getZrnhisadrate95() {
        return zrnhisadrate95;
    }

    public void setZrnhisadrate95(Double pZrnhisadrate95) {
        zrnhisadrate95 = pZrnhisadrate95;
    }

    private Double zrnhisadrate96;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE96)
    public Double getZrnhisadrate96() {
        return zrnhisadrate96;
    }

    public void setZrnhisadrate96(Double pZrnhisadrate96) {
        zrnhisadrate96 = pZrnhisadrate96;
    }

    private Double zrnhisadrate97;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE97)
    public Double getZrnhisadrate97() {
        return zrnhisadrate97;
    }

    public void setZrnhisadrate97(Double pZrnhisadrate97) {
        zrnhisadrate97 = pZrnhisadrate97;
    }

    private Double zrnhisadrate98;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE98)
    public Double getZrnhisadrate98() {
        return zrnhisadrate98;
    }

    public void setZrnhisadrate98(Double pZrnhisadrate98) {
        zrnhisadrate98 = pZrnhisadrate98;
    }

    private Double zrnhisadrate99;

    @Column(name=GenZT_RatedRn.ZRNHISADRATE99)
    public Double getZrnhisadrate99() {
        return zrnhisadrate99;
    }

    public void setZrnhisadrate99(Double pZrnhisadrate99) {
        zrnhisadrate99 = pZrnhisadrate99;
    }

    private Double zrndyouvrate00;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE00)
    public Double getZrndyouvrate00() {
        return zrndyouvrate00;
    }

    public void setZrndyouvrate00(Double pZrndyouvrate00) {
        zrndyouvrate00 = pZrndyouvrate00;
    }

    private Double zrndyouvrate01;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE01)
    public Double getZrndyouvrate01() {
        return zrndyouvrate01;
    }

    public void setZrndyouvrate01(Double pZrndyouvrate01) {
        zrndyouvrate01 = pZrndyouvrate01;
    }

    private Double zrndyouvrate02;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE02)
    public Double getZrndyouvrate02() {
        return zrndyouvrate02;
    }

    public void setZrndyouvrate02(Double pZrndyouvrate02) {
        zrndyouvrate02 = pZrndyouvrate02;
    }

    private Double zrndyouvrate03;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE03)
    public Double getZrndyouvrate03() {
        return zrndyouvrate03;
    }

    public void setZrndyouvrate03(Double pZrndyouvrate03) {
        zrndyouvrate03 = pZrndyouvrate03;
    }

    private Double zrndyouvrate04;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE04)
    public Double getZrndyouvrate04() {
        return zrndyouvrate04;
    }

    public void setZrndyouvrate04(Double pZrndyouvrate04) {
        zrndyouvrate04 = pZrndyouvrate04;
    }

    private Double zrndyouvrate05;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE05)
    public Double getZrndyouvrate05() {
        return zrndyouvrate05;
    }

    public void setZrndyouvrate05(Double pZrndyouvrate05) {
        zrndyouvrate05 = pZrndyouvrate05;
    }

    private Double zrndyouvrate06;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE06)
    public Double getZrndyouvrate06() {
        return zrndyouvrate06;
    }

    public void setZrndyouvrate06(Double pZrndyouvrate06) {
        zrndyouvrate06 = pZrndyouvrate06;
    }

    private Double zrndyouvrate07;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE07)
    public Double getZrndyouvrate07() {
        return zrndyouvrate07;
    }

    public void setZrndyouvrate07(Double pZrndyouvrate07) {
        zrndyouvrate07 = pZrndyouvrate07;
    }

    private Double zrndyouvrate08;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE08)
    public Double getZrndyouvrate08() {
        return zrndyouvrate08;
    }

    public void setZrndyouvrate08(Double pZrndyouvrate08) {
        zrndyouvrate08 = pZrndyouvrate08;
    }

    private Double zrndyouvrate09;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE09)
    public Double getZrndyouvrate09() {
        return zrndyouvrate09;
    }

    public void setZrndyouvrate09(Double pZrndyouvrate09) {
        zrndyouvrate09 = pZrndyouvrate09;
    }

    private Double zrndyouvrate10;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE10)
    public Double getZrndyouvrate10() {
        return zrndyouvrate10;
    }

    public void setZrndyouvrate10(Double pZrndyouvrate10) {
        zrndyouvrate10 = pZrndyouvrate10;
    }

    private Double zrndyouvrate11;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE11)
    public Double getZrndyouvrate11() {
        return zrndyouvrate11;
    }

    public void setZrndyouvrate11(Double pZrndyouvrate11) {
        zrndyouvrate11 = pZrndyouvrate11;
    }

    private Double zrndyouvrate12;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE12)
    public Double getZrndyouvrate12() {
        return zrndyouvrate12;
    }

    public void setZrndyouvrate12(Double pZrndyouvrate12) {
        zrndyouvrate12 = pZrndyouvrate12;
    }

    private Double zrndyouvrate13;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE13)
    public Double getZrndyouvrate13() {
        return zrndyouvrate13;
    }

    public void setZrndyouvrate13(Double pZrndyouvrate13) {
        zrndyouvrate13 = pZrndyouvrate13;
    }

    private Double zrndyouvrate14;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE14)
    public Double getZrndyouvrate14() {
        return zrndyouvrate14;
    }

    public void setZrndyouvrate14(Double pZrndyouvrate14) {
        zrndyouvrate14 = pZrndyouvrate14;
    }

    private Double zrndyouvrate15;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE15)
    public Double getZrndyouvrate15() {
        return zrndyouvrate15;
    }

    public void setZrndyouvrate15(Double pZrndyouvrate15) {
        zrndyouvrate15 = pZrndyouvrate15;
    }

    private Double zrndyouvrate16;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE16)
    public Double getZrndyouvrate16() {
        return zrndyouvrate16;
    }

    public void setZrndyouvrate16(Double pZrndyouvrate16) {
        zrndyouvrate16 = pZrndyouvrate16;
    }

    private Double zrndyouvrate17;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE17)
    public Double getZrndyouvrate17() {
        return zrndyouvrate17;
    }

    public void setZrndyouvrate17(Double pZrndyouvrate17) {
        zrndyouvrate17 = pZrndyouvrate17;
    }

    private Double zrndyouvrate18;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE18)
    public Double getZrndyouvrate18() {
        return zrndyouvrate18;
    }

    public void setZrndyouvrate18(Double pZrndyouvrate18) {
        zrndyouvrate18 = pZrndyouvrate18;
    }

    private Double zrndyouvrate19;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE19)
    public Double getZrndyouvrate19() {
        return zrndyouvrate19;
    }

    public void setZrndyouvrate19(Double pZrndyouvrate19) {
        zrndyouvrate19 = pZrndyouvrate19;
    }

    private Double zrndyouvrate20;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE20)
    public Double getZrndyouvrate20() {
        return zrndyouvrate20;
    }

    public void setZrndyouvrate20(Double pZrndyouvrate20) {
        zrndyouvrate20 = pZrndyouvrate20;
    }

    private Double zrndyouvrate21;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE21)
    public Double getZrndyouvrate21() {
        return zrndyouvrate21;
    }

    public void setZrndyouvrate21(Double pZrndyouvrate21) {
        zrndyouvrate21 = pZrndyouvrate21;
    }

    private Double zrndyouvrate22;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE22)
    public Double getZrndyouvrate22() {
        return zrndyouvrate22;
    }

    public void setZrndyouvrate22(Double pZrndyouvrate22) {
        zrndyouvrate22 = pZrndyouvrate22;
    }

    private Double zrndyouvrate23;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE23)
    public Double getZrndyouvrate23() {
        return zrndyouvrate23;
    }

    public void setZrndyouvrate23(Double pZrndyouvrate23) {
        zrndyouvrate23 = pZrndyouvrate23;
    }

    private Double zrndyouvrate24;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE24)
    public Double getZrndyouvrate24() {
        return zrndyouvrate24;
    }

    public void setZrndyouvrate24(Double pZrndyouvrate24) {
        zrndyouvrate24 = pZrndyouvrate24;
    }

    private Double zrndyouvrate25;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE25)
    public Double getZrndyouvrate25() {
        return zrndyouvrate25;
    }

    public void setZrndyouvrate25(Double pZrndyouvrate25) {
        zrndyouvrate25 = pZrndyouvrate25;
    }

    private Double zrndyouvrate26;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE26)
    public Double getZrndyouvrate26() {
        return zrndyouvrate26;
    }

    public void setZrndyouvrate26(Double pZrndyouvrate26) {
        zrndyouvrate26 = pZrndyouvrate26;
    }

    private Double zrndyouvrate27;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE27)
    public Double getZrndyouvrate27() {
        return zrndyouvrate27;
    }

    public void setZrndyouvrate27(Double pZrndyouvrate27) {
        zrndyouvrate27 = pZrndyouvrate27;
    }

    private Double zrndyouvrate28;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE28)
    public Double getZrndyouvrate28() {
        return zrndyouvrate28;
    }

    public void setZrndyouvrate28(Double pZrndyouvrate28) {
        zrndyouvrate28 = pZrndyouvrate28;
    }

    private Double zrndyouvrate29;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE29)
    public Double getZrndyouvrate29() {
        return zrndyouvrate29;
    }

    public void setZrndyouvrate29(Double pZrndyouvrate29) {
        zrndyouvrate29 = pZrndyouvrate29;
    }

    private Double zrndyouvrate30;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE30)
    public Double getZrndyouvrate30() {
        return zrndyouvrate30;
    }

    public void setZrndyouvrate30(Double pZrndyouvrate30) {
        zrndyouvrate30 = pZrndyouvrate30;
    }

    private Double zrndyouvrate31;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE31)
    public Double getZrndyouvrate31() {
        return zrndyouvrate31;
    }

    public void setZrndyouvrate31(Double pZrndyouvrate31) {
        zrndyouvrate31 = pZrndyouvrate31;
    }

    private Double zrndyouvrate32;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE32)
    public Double getZrndyouvrate32() {
        return zrndyouvrate32;
    }

    public void setZrndyouvrate32(Double pZrndyouvrate32) {
        zrndyouvrate32 = pZrndyouvrate32;
    }

    private Double zrndyouvrate33;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE33)
    public Double getZrndyouvrate33() {
        return zrndyouvrate33;
    }

    public void setZrndyouvrate33(Double pZrndyouvrate33) {
        zrndyouvrate33 = pZrndyouvrate33;
    }

    private Double zrndyouvrate34;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE34)
    public Double getZrndyouvrate34() {
        return zrndyouvrate34;
    }

    public void setZrndyouvrate34(Double pZrndyouvrate34) {
        zrndyouvrate34 = pZrndyouvrate34;
    }

    private Double zrndyouvrate35;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE35)
    public Double getZrndyouvrate35() {
        return zrndyouvrate35;
    }

    public void setZrndyouvrate35(Double pZrndyouvrate35) {
        zrndyouvrate35 = pZrndyouvrate35;
    }

    private Double zrndyouvrate36;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE36)
    public Double getZrndyouvrate36() {
        return zrndyouvrate36;
    }

    public void setZrndyouvrate36(Double pZrndyouvrate36) {
        zrndyouvrate36 = pZrndyouvrate36;
    }

    private Double zrndyouvrate37;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE37)
    public Double getZrndyouvrate37() {
        return zrndyouvrate37;
    }

    public void setZrndyouvrate37(Double pZrndyouvrate37) {
        zrndyouvrate37 = pZrndyouvrate37;
    }

    private Double zrndyouvrate38;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE38)
    public Double getZrndyouvrate38() {
        return zrndyouvrate38;
    }

    public void setZrndyouvrate38(Double pZrndyouvrate38) {
        zrndyouvrate38 = pZrndyouvrate38;
    }

    private Double zrndyouvrate39;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE39)
    public Double getZrndyouvrate39() {
        return zrndyouvrate39;
    }

    public void setZrndyouvrate39(Double pZrndyouvrate39) {
        zrndyouvrate39 = pZrndyouvrate39;
    }

    private Double zrndyouvrate40;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE40)
    public Double getZrndyouvrate40() {
        return zrndyouvrate40;
    }

    public void setZrndyouvrate40(Double pZrndyouvrate40) {
        zrndyouvrate40 = pZrndyouvrate40;
    }

    private Double zrndyouvrate41;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE41)
    public Double getZrndyouvrate41() {
        return zrndyouvrate41;
    }

    public void setZrndyouvrate41(Double pZrndyouvrate41) {
        zrndyouvrate41 = pZrndyouvrate41;
    }

    private Double zrndyouvrate42;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE42)
    public Double getZrndyouvrate42() {
        return zrndyouvrate42;
    }

    public void setZrndyouvrate42(Double pZrndyouvrate42) {
        zrndyouvrate42 = pZrndyouvrate42;
    }

    private Double zrndyouvrate43;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE43)
    public Double getZrndyouvrate43() {
        return zrndyouvrate43;
    }

    public void setZrndyouvrate43(Double pZrndyouvrate43) {
        zrndyouvrate43 = pZrndyouvrate43;
    }

    private Double zrndyouvrate44;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE44)
    public Double getZrndyouvrate44() {
        return zrndyouvrate44;
    }

    public void setZrndyouvrate44(Double pZrndyouvrate44) {
        zrndyouvrate44 = pZrndyouvrate44;
    }

    private Double zrndyouvrate45;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE45)
    public Double getZrndyouvrate45() {
        return zrndyouvrate45;
    }

    public void setZrndyouvrate45(Double pZrndyouvrate45) {
        zrndyouvrate45 = pZrndyouvrate45;
    }

    private Double zrndyouvrate46;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE46)
    public Double getZrndyouvrate46() {
        return zrndyouvrate46;
    }

    public void setZrndyouvrate46(Double pZrndyouvrate46) {
        zrndyouvrate46 = pZrndyouvrate46;
    }

    private Double zrndyouvrate47;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE47)
    public Double getZrndyouvrate47() {
        return zrndyouvrate47;
    }

    public void setZrndyouvrate47(Double pZrndyouvrate47) {
        zrndyouvrate47 = pZrndyouvrate47;
    }

    private Double zrndyouvrate48;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE48)
    public Double getZrndyouvrate48() {
        return zrndyouvrate48;
    }

    public void setZrndyouvrate48(Double pZrndyouvrate48) {
        zrndyouvrate48 = pZrndyouvrate48;
    }

    private Double zrndyouvrate49;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE49)
    public Double getZrndyouvrate49() {
        return zrndyouvrate49;
    }

    public void setZrndyouvrate49(Double pZrndyouvrate49) {
        zrndyouvrate49 = pZrndyouvrate49;
    }

    private Double zrndyouvrate50;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE50)
    public Double getZrndyouvrate50() {
        return zrndyouvrate50;
    }

    public void setZrndyouvrate50(Double pZrndyouvrate50) {
        zrndyouvrate50 = pZrndyouvrate50;
    }

    private Double zrndyouvrate51;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE51)
    public Double getZrndyouvrate51() {
        return zrndyouvrate51;
    }

    public void setZrndyouvrate51(Double pZrndyouvrate51) {
        zrndyouvrate51 = pZrndyouvrate51;
    }

    private Double zrndyouvrate52;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE52)
    public Double getZrndyouvrate52() {
        return zrndyouvrate52;
    }

    public void setZrndyouvrate52(Double pZrndyouvrate52) {
        zrndyouvrate52 = pZrndyouvrate52;
    }

    private Double zrndyouvrate53;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE53)
    public Double getZrndyouvrate53() {
        return zrndyouvrate53;
    }

    public void setZrndyouvrate53(Double pZrndyouvrate53) {
        zrndyouvrate53 = pZrndyouvrate53;
    }

    private Double zrndyouvrate54;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE54)
    public Double getZrndyouvrate54() {
        return zrndyouvrate54;
    }

    public void setZrndyouvrate54(Double pZrndyouvrate54) {
        zrndyouvrate54 = pZrndyouvrate54;
    }

    private Double zrndyouvrate55;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE55)
    public Double getZrndyouvrate55() {
        return zrndyouvrate55;
    }

    public void setZrndyouvrate55(Double pZrndyouvrate55) {
        zrndyouvrate55 = pZrndyouvrate55;
    }

    private Double zrndyouvrate56;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE56)
    public Double getZrndyouvrate56() {
        return zrndyouvrate56;
    }

    public void setZrndyouvrate56(Double pZrndyouvrate56) {
        zrndyouvrate56 = pZrndyouvrate56;
    }

    private Double zrndyouvrate57;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE57)
    public Double getZrndyouvrate57() {
        return zrndyouvrate57;
    }

    public void setZrndyouvrate57(Double pZrndyouvrate57) {
        zrndyouvrate57 = pZrndyouvrate57;
    }

    private Double zrndyouvrate58;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE58)
    public Double getZrndyouvrate58() {
        return zrndyouvrate58;
    }

    public void setZrndyouvrate58(Double pZrndyouvrate58) {
        zrndyouvrate58 = pZrndyouvrate58;
    }

    private Double zrndyouvrate59;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE59)
    public Double getZrndyouvrate59() {
        return zrndyouvrate59;
    }

    public void setZrndyouvrate59(Double pZrndyouvrate59) {
        zrndyouvrate59 = pZrndyouvrate59;
    }

    private Double zrndyouvrate60;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE60)
    public Double getZrndyouvrate60() {
        return zrndyouvrate60;
    }

    public void setZrndyouvrate60(Double pZrndyouvrate60) {
        zrndyouvrate60 = pZrndyouvrate60;
    }

    private Double zrndyouvrate61;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE61)
    public Double getZrndyouvrate61() {
        return zrndyouvrate61;
    }

    public void setZrndyouvrate61(Double pZrndyouvrate61) {
        zrndyouvrate61 = pZrndyouvrate61;
    }

    private Double zrndyouvrate62;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE62)
    public Double getZrndyouvrate62() {
        return zrndyouvrate62;
    }

    public void setZrndyouvrate62(Double pZrndyouvrate62) {
        zrndyouvrate62 = pZrndyouvrate62;
    }

    private Double zrndyouvrate63;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE63)
    public Double getZrndyouvrate63() {
        return zrndyouvrate63;
    }

    public void setZrndyouvrate63(Double pZrndyouvrate63) {
        zrndyouvrate63 = pZrndyouvrate63;
    }

    private Double zrndyouvrate64;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE64)
    public Double getZrndyouvrate64() {
        return zrndyouvrate64;
    }

    public void setZrndyouvrate64(Double pZrndyouvrate64) {
        zrndyouvrate64 = pZrndyouvrate64;
    }

    private Double zrndyouvrate65;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE65)
    public Double getZrndyouvrate65() {
        return zrndyouvrate65;
    }

    public void setZrndyouvrate65(Double pZrndyouvrate65) {
        zrndyouvrate65 = pZrndyouvrate65;
    }

    private Double zrndyouvrate66;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE66)
    public Double getZrndyouvrate66() {
        return zrndyouvrate66;
    }

    public void setZrndyouvrate66(Double pZrndyouvrate66) {
        zrndyouvrate66 = pZrndyouvrate66;
    }

    private Double zrndyouvrate67;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE67)
    public Double getZrndyouvrate67() {
        return zrndyouvrate67;
    }

    public void setZrndyouvrate67(Double pZrndyouvrate67) {
        zrndyouvrate67 = pZrndyouvrate67;
    }

    private Double zrndyouvrate68;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE68)
    public Double getZrndyouvrate68() {
        return zrndyouvrate68;
    }

    public void setZrndyouvrate68(Double pZrndyouvrate68) {
        zrndyouvrate68 = pZrndyouvrate68;
    }

    private Double zrndyouvrate69;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE69)
    public Double getZrndyouvrate69() {
        return zrndyouvrate69;
    }

    public void setZrndyouvrate69(Double pZrndyouvrate69) {
        zrndyouvrate69 = pZrndyouvrate69;
    }

    private Double zrndyouvrate70;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE70)
    public Double getZrndyouvrate70() {
        return zrndyouvrate70;
    }

    public void setZrndyouvrate70(Double pZrndyouvrate70) {
        zrndyouvrate70 = pZrndyouvrate70;
    }

    private Double zrndyouvrate71;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE71)
    public Double getZrndyouvrate71() {
        return zrndyouvrate71;
    }

    public void setZrndyouvrate71(Double pZrndyouvrate71) {
        zrndyouvrate71 = pZrndyouvrate71;
    }

    private Double zrndyouvrate72;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE72)
    public Double getZrndyouvrate72() {
        return zrndyouvrate72;
    }

    public void setZrndyouvrate72(Double pZrndyouvrate72) {
        zrndyouvrate72 = pZrndyouvrate72;
    }

    private Double zrndyouvrate73;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE73)
    public Double getZrndyouvrate73() {
        return zrndyouvrate73;
    }

    public void setZrndyouvrate73(Double pZrndyouvrate73) {
        zrndyouvrate73 = pZrndyouvrate73;
    }

    private Double zrndyouvrate74;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE74)
    public Double getZrndyouvrate74() {
        return zrndyouvrate74;
    }

    public void setZrndyouvrate74(Double pZrndyouvrate74) {
        zrndyouvrate74 = pZrndyouvrate74;
    }

    private Double zrndyouvrate75;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE75)
    public Double getZrndyouvrate75() {
        return zrndyouvrate75;
    }

    public void setZrndyouvrate75(Double pZrndyouvrate75) {
        zrndyouvrate75 = pZrndyouvrate75;
    }

    private Double zrndyouvrate76;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE76)
    public Double getZrndyouvrate76() {
        return zrndyouvrate76;
    }

    public void setZrndyouvrate76(Double pZrndyouvrate76) {
        zrndyouvrate76 = pZrndyouvrate76;
    }

    private Double zrndyouvrate77;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE77)
    public Double getZrndyouvrate77() {
        return zrndyouvrate77;
    }

    public void setZrndyouvrate77(Double pZrndyouvrate77) {
        zrndyouvrate77 = pZrndyouvrate77;
    }

    private Double zrndyouvrate78;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE78)
    public Double getZrndyouvrate78() {
        return zrndyouvrate78;
    }

    public void setZrndyouvrate78(Double pZrndyouvrate78) {
        zrndyouvrate78 = pZrndyouvrate78;
    }

    private Double zrndyouvrate79;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE79)
    public Double getZrndyouvrate79() {
        return zrndyouvrate79;
    }

    public void setZrndyouvrate79(Double pZrndyouvrate79) {
        zrndyouvrate79 = pZrndyouvrate79;
    }

    private Double zrndyouvrate80;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE80)
    public Double getZrndyouvrate80() {
        return zrndyouvrate80;
    }

    public void setZrndyouvrate80(Double pZrndyouvrate80) {
        zrndyouvrate80 = pZrndyouvrate80;
    }

    private Double zrndyouvrate81;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE81)
    public Double getZrndyouvrate81() {
        return zrndyouvrate81;
    }

    public void setZrndyouvrate81(Double pZrndyouvrate81) {
        zrndyouvrate81 = pZrndyouvrate81;
    }

    private Double zrndyouvrate82;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE82)
    public Double getZrndyouvrate82() {
        return zrndyouvrate82;
    }

    public void setZrndyouvrate82(Double pZrndyouvrate82) {
        zrndyouvrate82 = pZrndyouvrate82;
    }

    private Double zrndyouvrate83;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE83)
    public Double getZrndyouvrate83() {
        return zrndyouvrate83;
    }

    public void setZrndyouvrate83(Double pZrndyouvrate83) {
        zrndyouvrate83 = pZrndyouvrate83;
    }

    private Double zrndyouvrate84;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE84)
    public Double getZrndyouvrate84() {
        return zrndyouvrate84;
    }

    public void setZrndyouvrate84(Double pZrndyouvrate84) {
        zrndyouvrate84 = pZrndyouvrate84;
    }

    private Double zrndyouvrate85;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE85)
    public Double getZrndyouvrate85() {
        return zrndyouvrate85;
    }

    public void setZrndyouvrate85(Double pZrndyouvrate85) {
        zrndyouvrate85 = pZrndyouvrate85;
    }

    private Double zrndyouvrate86;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE86)
    public Double getZrndyouvrate86() {
        return zrndyouvrate86;
    }

    public void setZrndyouvrate86(Double pZrndyouvrate86) {
        zrndyouvrate86 = pZrndyouvrate86;
    }

    private Double zrndyouvrate87;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE87)
    public Double getZrndyouvrate87() {
        return zrndyouvrate87;
    }

    public void setZrndyouvrate87(Double pZrndyouvrate87) {
        zrndyouvrate87 = pZrndyouvrate87;
    }

    private Double zrndyouvrate88;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE88)
    public Double getZrndyouvrate88() {
        return zrndyouvrate88;
    }

    public void setZrndyouvrate88(Double pZrndyouvrate88) {
        zrndyouvrate88 = pZrndyouvrate88;
    }

    private Double zrndyouvrate89;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE89)
    public Double getZrndyouvrate89() {
        return zrndyouvrate89;
    }

    public void setZrndyouvrate89(Double pZrndyouvrate89) {
        zrndyouvrate89 = pZrndyouvrate89;
    }

    private Double zrndyouvrate90;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE90)
    public Double getZrndyouvrate90() {
        return zrndyouvrate90;
    }

    public void setZrndyouvrate90(Double pZrndyouvrate90) {
        zrndyouvrate90 = pZrndyouvrate90;
    }

    private Double zrndyouvrate91;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE91)
    public Double getZrndyouvrate91() {
        return zrndyouvrate91;
    }

    public void setZrndyouvrate91(Double pZrndyouvrate91) {
        zrndyouvrate91 = pZrndyouvrate91;
    }

    private Double zrndyouvrate92;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE92)
    public Double getZrndyouvrate92() {
        return zrndyouvrate92;
    }

    public void setZrndyouvrate92(Double pZrndyouvrate92) {
        zrndyouvrate92 = pZrndyouvrate92;
    }

    private Double zrndyouvrate93;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE93)
    public Double getZrndyouvrate93() {
        return zrndyouvrate93;
    }

    public void setZrndyouvrate93(Double pZrndyouvrate93) {
        zrndyouvrate93 = pZrndyouvrate93;
    }

    private Double zrndyouvrate94;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE94)
    public Double getZrndyouvrate94() {
        return zrndyouvrate94;
    }

    public void setZrndyouvrate94(Double pZrndyouvrate94) {
        zrndyouvrate94 = pZrndyouvrate94;
    }

    private Double zrndyouvrate95;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE95)
    public Double getZrndyouvrate95() {
        return zrndyouvrate95;
    }

    public void setZrndyouvrate95(Double pZrndyouvrate95) {
        zrndyouvrate95 = pZrndyouvrate95;
    }

    private Double zrndyouvrate96;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE96)
    public Double getZrndyouvrate96() {
        return zrndyouvrate96;
    }

    public void setZrndyouvrate96(Double pZrndyouvrate96) {
        zrndyouvrate96 = pZrndyouvrate96;
    }

    private Double zrndyouvrate97;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE97)
    public Double getZrndyouvrate97() {
        return zrndyouvrate97;
    }

    public void setZrndyouvrate97(Double pZrndyouvrate97) {
        zrndyouvrate97 = pZrndyouvrate97;
    }

    private Double zrndyouvrate98;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE98)
    public Double getZrndyouvrate98() {
        return zrndyouvrate98;
    }

    public void setZrndyouvrate98(Double pZrndyouvrate98) {
        zrndyouvrate98 = pZrndyouvrate98;
    }

    private Double zrndyouvrate99;

    @Column(name=GenZT_RatedRn.ZRNDYOUVRATE99)
    public Double getZrndyouvrate99() {
        return zrndyouvrate99;
    }

    public void setZrndyouvrate99(Double pZrndyouvrate99) {
        zrndyouvrate99 = pZrndyouvrate99;
    }

    private Double zrnkikensrate00;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE00)
    public Double getZrnkikensrate00() {
        return zrnkikensrate00;
    }

    public void setZrnkikensrate00(Double pZrnkikensrate00) {
        zrnkikensrate00 = pZrnkikensrate00;
    }

    private Double zrnkikensrate01;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE01)
    public Double getZrnkikensrate01() {
        return zrnkikensrate01;
    }

    public void setZrnkikensrate01(Double pZrnkikensrate01) {
        zrnkikensrate01 = pZrnkikensrate01;
    }

    private Double zrnkikensrate02;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE02)
    public Double getZrnkikensrate02() {
        return zrnkikensrate02;
    }

    public void setZrnkikensrate02(Double pZrnkikensrate02) {
        zrnkikensrate02 = pZrnkikensrate02;
    }

    private Double zrnkikensrate03;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE03)
    public Double getZrnkikensrate03() {
        return zrnkikensrate03;
    }

    public void setZrnkikensrate03(Double pZrnkikensrate03) {
        zrnkikensrate03 = pZrnkikensrate03;
    }

    private Double zrnkikensrate04;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE04)
    public Double getZrnkikensrate04() {
        return zrnkikensrate04;
    }

    public void setZrnkikensrate04(Double pZrnkikensrate04) {
        zrnkikensrate04 = pZrnkikensrate04;
    }

    private Double zrnkikensrate05;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE05)
    public Double getZrnkikensrate05() {
        return zrnkikensrate05;
    }

    public void setZrnkikensrate05(Double pZrnkikensrate05) {
        zrnkikensrate05 = pZrnkikensrate05;
    }

    private Double zrnkikensrate06;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE06)
    public Double getZrnkikensrate06() {
        return zrnkikensrate06;
    }

    public void setZrnkikensrate06(Double pZrnkikensrate06) {
        zrnkikensrate06 = pZrnkikensrate06;
    }

    private Double zrnkikensrate07;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE07)
    public Double getZrnkikensrate07() {
        return zrnkikensrate07;
    }

    public void setZrnkikensrate07(Double pZrnkikensrate07) {
        zrnkikensrate07 = pZrnkikensrate07;
    }

    private Double zrnkikensrate08;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE08)
    public Double getZrnkikensrate08() {
        return zrnkikensrate08;
    }

    public void setZrnkikensrate08(Double pZrnkikensrate08) {
        zrnkikensrate08 = pZrnkikensrate08;
    }

    private Double zrnkikensrate09;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE09)
    public Double getZrnkikensrate09() {
        return zrnkikensrate09;
    }

    public void setZrnkikensrate09(Double pZrnkikensrate09) {
        zrnkikensrate09 = pZrnkikensrate09;
    }

    private Double zrnkikensrate10;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE10)
    public Double getZrnkikensrate10() {
        return zrnkikensrate10;
    }

    public void setZrnkikensrate10(Double pZrnkikensrate10) {
        zrnkikensrate10 = pZrnkikensrate10;
    }

    private Double zrnkikensrate11;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE11)
    public Double getZrnkikensrate11() {
        return zrnkikensrate11;
    }

    public void setZrnkikensrate11(Double pZrnkikensrate11) {
        zrnkikensrate11 = pZrnkikensrate11;
    }

    private Double zrnkikensrate12;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE12)
    public Double getZrnkikensrate12() {
        return zrnkikensrate12;
    }

    public void setZrnkikensrate12(Double pZrnkikensrate12) {
        zrnkikensrate12 = pZrnkikensrate12;
    }

    private Double zrnkikensrate13;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE13)
    public Double getZrnkikensrate13() {
        return zrnkikensrate13;
    }

    public void setZrnkikensrate13(Double pZrnkikensrate13) {
        zrnkikensrate13 = pZrnkikensrate13;
    }

    private Double zrnkikensrate14;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE14)
    public Double getZrnkikensrate14() {
        return zrnkikensrate14;
    }

    public void setZrnkikensrate14(Double pZrnkikensrate14) {
        zrnkikensrate14 = pZrnkikensrate14;
    }

    private Double zrnkikensrate15;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE15)
    public Double getZrnkikensrate15() {
        return zrnkikensrate15;
    }

    public void setZrnkikensrate15(Double pZrnkikensrate15) {
        zrnkikensrate15 = pZrnkikensrate15;
    }

    private Double zrnkikensrate16;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE16)
    public Double getZrnkikensrate16() {
        return zrnkikensrate16;
    }

    public void setZrnkikensrate16(Double pZrnkikensrate16) {
        zrnkikensrate16 = pZrnkikensrate16;
    }

    private Double zrnkikensrate17;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE17)
    public Double getZrnkikensrate17() {
        return zrnkikensrate17;
    }

    public void setZrnkikensrate17(Double pZrnkikensrate17) {
        zrnkikensrate17 = pZrnkikensrate17;
    }

    private Double zrnkikensrate18;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE18)
    public Double getZrnkikensrate18() {
        return zrnkikensrate18;
    }

    public void setZrnkikensrate18(Double pZrnkikensrate18) {
        zrnkikensrate18 = pZrnkikensrate18;
    }

    private Double zrnkikensrate19;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE19)
    public Double getZrnkikensrate19() {
        return zrnkikensrate19;
    }

    public void setZrnkikensrate19(Double pZrnkikensrate19) {
        zrnkikensrate19 = pZrnkikensrate19;
    }

    private Double zrnkikensrate20;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE20)
    public Double getZrnkikensrate20() {
        return zrnkikensrate20;
    }

    public void setZrnkikensrate20(Double pZrnkikensrate20) {
        zrnkikensrate20 = pZrnkikensrate20;
    }

    private Double zrnkikensrate21;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE21)
    public Double getZrnkikensrate21() {
        return zrnkikensrate21;
    }

    public void setZrnkikensrate21(Double pZrnkikensrate21) {
        zrnkikensrate21 = pZrnkikensrate21;
    }

    private Double zrnkikensrate22;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE22)
    public Double getZrnkikensrate22() {
        return zrnkikensrate22;
    }

    public void setZrnkikensrate22(Double pZrnkikensrate22) {
        zrnkikensrate22 = pZrnkikensrate22;
    }

    private Double zrnkikensrate23;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE23)
    public Double getZrnkikensrate23() {
        return zrnkikensrate23;
    }

    public void setZrnkikensrate23(Double pZrnkikensrate23) {
        zrnkikensrate23 = pZrnkikensrate23;
    }

    private Double zrnkikensrate24;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE24)
    public Double getZrnkikensrate24() {
        return zrnkikensrate24;
    }

    public void setZrnkikensrate24(Double pZrnkikensrate24) {
        zrnkikensrate24 = pZrnkikensrate24;
    }

    private Double zrnkikensrate25;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE25)
    public Double getZrnkikensrate25() {
        return zrnkikensrate25;
    }

    public void setZrnkikensrate25(Double pZrnkikensrate25) {
        zrnkikensrate25 = pZrnkikensrate25;
    }

    private Double zrnkikensrate26;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE26)
    public Double getZrnkikensrate26() {
        return zrnkikensrate26;
    }

    public void setZrnkikensrate26(Double pZrnkikensrate26) {
        zrnkikensrate26 = pZrnkikensrate26;
    }

    private Double zrnkikensrate27;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE27)
    public Double getZrnkikensrate27() {
        return zrnkikensrate27;
    }

    public void setZrnkikensrate27(Double pZrnkikensrate27) {
        zrnkikensrate27 = pZrnkikensrate27;
    }

    private Double zrnkikensrate28;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE28)
    public Double getZrnkikensrate28() {
        return zrnkikensrate28;
    }

    public void setZrnkikensrate28(Double pZrnkikensrate28) {
        zrnkikensrate28 = pZrnkikensrate28;
    }

    private Double zrnkikensrate29;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE29)
    public Double getZrnkikensrate29() {
        return zrnkikensrate29;
    }

    public void setZrnkikensrate29(Double pZrnkikensrate29) {
        zrnkikensrate29 = pZrnkikensrate29;
    }

    private Double zrnkikensrate30;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE30)
    public Double getZrnkikensrate30() {
        return zrnkikensrate30;
    }

    public void setZrnkikensrate30(Double pZrnkikensrate30) {
        zrnkikensrate30 = pZrnkikensrate30;
    }

    private Double zrnkikensrate31;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE31)
    public Double getZrnkikensrate31() {
        return zrnkikensrate31;
    }

    public void setZrnkikensrate31(Double pZrnkikensrate31) {
        zrnkikensrate31 = pZrnkikensrate31;
    }

    private Double zrnkikensrate32;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE32)
    public Double getZrnkikensrate32() {
        return zrnkikensrate32;
    }

    public void setZrnkikensrate32(Double pZrnkikensrate32) {
        zrnkikensrate32 = pZrnkikensrate32;
    }

    private Double zrnkikensrate33;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE33)
    public Double getZrnkikensrate33() {
        return zrnkikensrate33;
    }

    public void setZrnkikensrate33(Double pZrnkikensrate33) {
        zrnkikensrate33 = pZrnkikensrate33;
    }

    private Double zrnkikensrate34;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE34)
    public Double getZrnkikensrate34() {
        return zrnkikensrate34;
    }

    public void setZrnkikensrate34(Double pZrnkikensrate34) {
        zrnkikensrate34 = pZrnkikensrate34;
    }

    private Double zrnkikensrate35;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE35)
    public Double getZrnkikensrate35() {
        return zrnkikensrate35;
    }

    public void setZrnkikensrate35(Double pZrnkikensrate35) {
        zrnkikensrate35 = pZrnkikensrate35;
    }

    private Double zrnkikensrate36;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE36)
    public Double getZrnkikensrate36() {
        return zrnkikensrate36;
    }

    public void setZrnkikensrate36(Double pZrnkikensrate36) {
        zrnkikensrate36 = pZrnkikensrate36;
    }

    private Double zrnkikensrate37;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE37)
    public Double getZrnkikensrate37() {
        return zrnkikensrate37;
    }

    public void setZrnkikensrate37(Double pZrnkikensrate37) {
        zrnkikensrate37 = pZrnkikensrate37;
    }

    private Double zrnkikensrate38;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE38)
    public Double getZrnkikensrate38() {
        return zrnkikensrate38;
    }

    public void setZrnkikensrate38(Double pZrnkikensrate38) {
        zrnkikensrate38 = pZrnkikensrate38;
    }

    private Double zrnkikensrate39;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE39)
    public Double getZrnkikensrate39() {
        return zrnkikensrate39;
    }

    public void setZrnkikensrate39(Double pZrnkikensrate39) {
        zrnkikensrate39 = pZrnkikensrate39;
    }

    private Double zrnkikensrate40;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE40)
    public Double getZrnkikensrate40() {
        return zrnkikensrate40;
    }

    public void setZrnkikensrate40(Double pZrnkikensrate40) {
        zrnkikensrate40 = pZrnkikensrate40;
    }

    private Double zrnkikensrate41;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE41)
    public Double getZrnkikensrate41() {
        return zrnkikensrate41;
    }

    public void setZrnkikensrate41(Double pZrnkikensrate41) {
        zrnkikensrate41 = pZrnkikensrate41;
    }

    private Double zrnkikensrate42;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE42)
    public Double getZrnkikensrate42() {
        return zrnkikensrate42;
    }

    public void setZrnkikensrate42(Double pZrnkikensrate42) {
        zrnkikensrate42 = pZrnkikensrate42;
    }

    private Double zrnkikensrate43;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE43)
    public Double getZrnkikensrate43() {
        return zrnkikensrate43;
    }

    public void setZrnkikensrate43(Double pZrnkikensrate43) {
        zrnkikensrate43 = pZrnkikensrate43;
    }

    private Double zrnkikensrate44;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE44)
    public Double getZrnkikensrate44() {
        return zrnkikensrate44;
    }

    public void setZrnkikensrate44(Double pZrnkikensrate44) {
        zrnkikensrate44 = pZrnkikensrate44;
    }

    private Double zrnkikensrate45;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE45)
    public Double getZrnkikensrate45() {
        return zrnkikensrate45;
    }

    public void setZrnkikensrate45(Double pZrnkikensrate45) {
        zrnkikensrate45 = pZrnkikensrate45;
    }

    private Double zrnkikensrate46;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE46)
    public Double getZrnkikensrate46() {
        return zrnkikensrate46;
    }

    public void setZrnkikensrate46(Double pZrnkikensrate46) {
        zrnkikensrate46 = pZrnkikensrate46;
    }

    private Double zrnkikensrate47;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE47)
    public Double getZrnkikensrate47() {
        return zrnkikensrate47;
    }

    public void setZrnkikensrate47(Double pZrnkikensrate47) {
        zrnkikensrate47 = pZrnkikensrate47;
    }

    private Double zrnkikensrate48;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE48)
    public Double getZrnkikensrate48() {
        return zrnkikensrate48;
    }

    public void setZrnkikensrate48(Double pZrnkikensrate48) {
        zrnkikensrate48 = pZrnkikensrate48;
    }

    private Double zrnkikensrate49;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE49)
    public Double getZrnkikensrate49() {
        return zrnkikensrate49;
    }

    public void setZrnkikensrate49(Double pZrnkikensrate49) {
        zrnkikensrate49 = pZrnkikensrate49;
    }

    private Double zrnkikensrate50;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE50)
    public Double getZrnkikensrate50() {
        return zrnkikensrate50;
    }

    public void setZrnkikensrate50(Double pZrnkikensrate50) {
        zrnkikensrate50 = pZrnkikensrate50;
    }

    private Double zrnkikensrate51;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE51)
    public Double getZrnkikensrate51() {
        return zrnkikensrate51;
    }

    public void setZrnkikensrate51(Double pZrnkikensrate51) {
        zrnkikensrate51 = pZrnkikensrate51;
    }

    private Double zrnkikensrate52;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE52)
    public Double getZrnkikensrate52() {
        return zrnkikensrate52;
    }

    public void setZrnkikensrate52(Double pZrnkikensrate52) {
        zrnkikensrate52 = pZrnkikensrate52;
    }

    private Double zrnkikensrate53;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE53)
    public Double getZrnkikensrate53() {
        return zrnkikensrate53;
    }

    public void setZrnkikensrate53(Double pZrnkikensrate53) {
        zrnkikensrate53 = pZrnkikensrate53;
    }

    private Double zrnkikensrate54;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE54)
    public Double getZrnkikensrate54() {
        return zrnkikensrate54;
    }

    public void setZrnkikensrate54(Double pZrnkikensrate54) {
        zrnkikensrate54 = pZrnkikensrate54;
    }

    private Double zrnkikensrate55;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE55)
    public Double getZrnkikensrate55() {
        return zrnkikensrate55;
    }

    public void setZrnkikensrate55(Double pZrnkikensrate55) {
        zrnkikensrate55 = pZrnkikensrate55;
    }

    private Double zrnkikensrate56;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE56)
    public Double getZrnkikensrate56() {
        return zrnkikensrate56;
    }

    public void setZrnkikensrate56(Double pZrnkikensrate56) {
        zrnkikensrate56 = pZrnkikensrate56;
    }

    private Double zrnkikensrate57;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE57)
    public Double getZrnkikensrate57() {
        return zrnkikensrate57;
    }

    public void setZrnkikensrate57(Double pZrnkikensrate57) {
        zrnkikensrate57 = pZrnkikensrate57;
    }

    private Double zrnkikensrate58;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE58)
    public Double getZrnkikensrate58() {
        return zrnkikensrate58;
    }

    public void setZrnkikensrate58(Double pZrnkikensrate58) {
        zrnkikensrate58 = pZrnkikensrate58;
    }

    private Double zrnkikensrate59;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE59)
    public Double getZrnkikensrate59() {
        return zrnkikensrate59;
    }

    public void setZrnkikensrate59(Double pZrnkikensrate59) {
        zrnkikensrate59 = pZrnkikensrate59;
    }

    private Double zrnkikensrate60;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE60)
    public Double getZrnkikensrate60() {
        return zrnkikensrate60;
    }

    public void setZrnkikensrate60(Double pZrnkikensrate60) {
        zrnkikensrate60 = pZrnkikensrate60;
    }

    private Double zrnkikensrate61;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE61)
    public Double getZrnkikensrate61() {
        return zrnkikensrate61;
    }

    public void setZrnkikensrate61(Double pZrnkikensrate61) {
        zrnkikensrate61 = pZrnkikensrate61;
    }

    private Double zrnkikensrate62;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE62)
    public Double getZrnkikensrate62() {
        return zrnkikensrate62;
    }

    public void setZrnkikensrate62(Double pZrnkikensrate62) {
        zrnkikensrate62 = pZrnkikensrate62;
    }

    private Double zrnkikensrate63;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE63)
    public Double getZrnkikensrate63() {
        return zrnkikensrate63;
    }

    public void setZrnkikensrate63(Double pZrnkikensrate63) {
        zrnkikensrate63 = pZrnkikensrate63;
    }

    private Double zrnkikensrate64;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE64)
    public Double getZrnkikensrate64() {
        return zrnkikensrate64;
    }

    public void setZrnkikensrate64(Double pZrnkikensrate64) {
        zrnkikensrate64 = pZrnkikensrate64;
    }

    private Double zrnkikensrate65;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE65)
    public Double getZrnkikensrate65() {
        return zrnkikensrate65;
    }

    public void setZrnkikensrate65(Double pZrnkikensrate65) {
        zrnkikensrate65 = pZrnkikensrate65;
    }

    private Double zrnkikensrate66;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE66)
    public Double getZrnkikensrate66() {
        return zrnkikensrate66;
    }

    public void setZrnkikensrate66(Double pZrnkikensrate66) {
        zrnkikensrate66 = pZrnkikensrate66;
    }

    private Double zrnkikensrate67;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE67)
    public Double getZrnkikensrate67() {
        return zrnkikensrate67;
    }

    public void setZrnkikensrate67(Double pZrnkikensrate67) {
        zrnkikensrate67 = pZrnkikensrate67;
    }

    private Double zrnkikensrate68;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE68)
    public Double getZrnkikensrate68() {
        return zrnkikensrate68;
    }

    public void setZrnkikensrate68(Double pZrnkikensrate68) {
        zrnkikensrate68 = pZrnkikensrate68;
    }

    private Double zrnkikensrate69;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE69)
    public Double getZrnkikensrate69() {
        return zrnkikensrate69;
    }

    public void setZrnkikensrate69(Double pZrnkikensrate69) {
        zrnkikensrate69 = pZrnkikensrate69;
    }

    private Double zrnkikensrate70;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE70)
    public Double getZrnkikensrate70() {
        return zrnkikensrate70;
    }

    public void setZrnkikensrate70(Double pZrnkikensrate70) {
        zrnkikensrate70 = pZrnkikensrate70;
    }

    private Double zrnkikensrate71;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE71)
    public Double getZrnkikensrate71() {
        return zrnkikensrate71;
    }

    public void setZrnkikensrate71(Double pZrnkikensrate71) {
        zrnkikensrate71 = pZrnkikensrate71;
    }

    private Double zrnkikensrate72;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE72)
    public Double getZrnkikensrate72() {
        return zrnkikensrate72;
    }

    public void setZrnkikensrate72(Double pZrnkikensrate72) {
        zrnkikensrate72 = pZrnkikensrate72;
    }

    private Double zrnkikensrate73;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE73)
    public Double getZrnkikensrate73() {
        return zrnkikensrate73;
    }

    public void setZrnkikensrate73(Double pZrnkikensrate73) {
        zrnkikensrate73 = pZrnkikensrate73;
    }

    private Double zrnkikensrate74;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE74)
    public Double getZrnkikensrate74() {
        return zrnkikensrate74;
    }

    public void setZrnkikensrate74(Double pZrnkikensrate74) {
        zrnkikensrate74 = pZrnkikensrate74;
    }

    private Double zrnkikensrate75;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE75)
    public Double getZrnkikensrate75() {
        return zrnkikensrate75;
    }

    public void setZrnkikensrate75(Double pZrnkikensrate75) {
        zrnkikensrate75 = pZrnkikensrate75;
    }

    private Double zrnkikensrate76;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE76)
    public Double getZrnkikensrate76() {
        return zrnkikensrate76;
    }

    public void setZrnkikensrate76(Double pZrnkikensrate76) {
        zrnkikensrate76 = pZrnkikensrate76;
    }

    private Double zrnkikensrate77;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE77)
    public Double getZrnkikensrate77() {
        return zrnkikensrate77;
    }

    public void setZrnkikensrate77(Double pZrnkikensrate77) {
        zrnkikensrate77 = pZrnkikensrate77;
    }

    private Double zrnkikensrate78;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE78)
    public Double getZrnkikensrate78() {
        return zrnkikensrate78;
    }

    public void setZrnkikensrate78(Double pZrnkikensrate78) {
        zrnkikensrate78 = pZrnkikensrate78;
    }

    private Double zrnkikensrate79;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE79)
    public Double getZrnkikensrate79() {
        return zrnkikensrate79;
    }

    public void setZrnkikensrate79(Double pZrnkikensrate79) {
        zrnkikensrate79 = pZrnkikensrate79;
    }

    private Double zrnkikensrate80;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE80)
    public Double getZrnkikensrate80() {
        return zrnkikensrate80;
    }

    public void setZrnkikensrate80(Double pZrnkikensrate80) {
        zrnkikensrate80 = pZrnkikensrate80;
    }

    private Double zrnkikensrate81;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE81)
    public Double getZrnkikensrate81() {
        return zrnkikensrate81;
    }

    public void setZrnkikensrate81(Double pZrnkikensrate81) {
        zrnkikensrate81 = pZrnkikensrate81;
    }

    private Double zrnkikensrate82;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE82)
    public Double getZrnkikensrate82() {
        return zrnkikensrate82;
    }

    public void setZrnkikensrate82(Double pZrnkikensrate82) {
        zrnkikensrate82 = pZrnkikensrate82;
    }

    private Double zrnkikensrate83;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE83)
    public Double getZrnkikensrate83() {
        return zrnkikensrate83;
    }

    public void setZrnkikensrate83(Double pZrnkikensrate83) {
        zrnkikensrate83 = pZrnkikensrate83;
    }

    private Double zrnkikensrate84;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE84)
    public Double getZrnkikensrate84() {
        return zrnkikensrate84;
    }

    public void setZrnkikensrate84(Double pZrnkikensrate84) {
        zrnkikensrate84 = pZrnkikensrate84;
    }

    private Double zrnkikensrate85;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE85)
    public Double getZrnkikensrate85() {
        return zrnkikensrate85;
    }

    public void setZrnkikensrate85(Double pZrnkikensrate85) {
        zrnkikensrate85 = pZrnkikensrate85;
    }

    private Double zrnkikensrate86;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE86)
    public Double getZrnkikensrate86() {
        return zrnkikensrate86;
    }

    public void setZrnkikensrate86(Double pZrnkikensrate86) {
        zrnkikensrate86 = pZrnkikensrate86;
    }

    private Double zrnkikensrate87;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE87)
    public Double getZrnkikensrate87() {
        return zrnkikensrate87;
    }

    public void setZrnkikensrate87(Double pZrnkikensrate87) {
        zrnkikensrate87 = pZrnkikensrate87;
    }

    private Double zrnkikensrate88;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE88)
    public Double getZrnkikensrate88() {
        return zrnkikensrate88;
    }

    public void setZrnkikensrate88(Double pZrnkikensrate88) {
        zrnkikensrate88 = pZrnkikensrate88;
    }

    private Double zrnkikensrate89;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE89)
    public Double getZrnkikensrate89() {
        return zrnkikensrate89;
    }

    public void setZrnkikensrate89(Double pZrnkikensrate89) {
        zrnkikensrate89 = pZrnkikensrate89;
    }

    private Double zrnkikensrate90;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE90)
    public Double getZrnkikensrate90() {
        return zrnkikensrate90;
    }

    public void setZrnkikensrate90(Double pZrnkikensrate90) {
        zrnkikensrate90 = pZrnkikensrate90;
    }

    private Double zrnkikensrate91;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE91)
    public Double getZrnkikensrate91() {
        return zrnkikensrate91;
    }

    public void setZrnkikensrate91(Double pZrnkikensrate91) {
        zrnkikensrate91 = pZrnkikensrate91;
    }

    private Double zrnkikensrate92;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE92)
    public Double getZrnkikensrate92() {
        return zrnkikensrate92;
    }

    public void setZrnkikensrate92(Double pZrnkikensrate92) {
        zrnkikensrate92 = pZrnkikensrate92;
    }

    private Double zrnkikensrate93;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE93)
    public Double getZrnkikensrate93() {
        return zrnkikensrate93;
    }

    public void setZrnkikensrate93(Double pZrnkikensrate93) {
        zrnkikensrate93 = pZrnkikensrate93;
    }

    private Double zrnkikensrate94;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE94)
    public Double getZrnkikensrate94() {
        return zrnkikensrate94;
    }

    public void setZrnkikensrate94(Double pZrnkikensrate94) {
        zrnkikensrate94 = pZrnkikensrate94;
    }

    private Double zrnkikensrate95;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE95)
    public Double getZrnkikensrate95() {
        return zrnkikensrate95;
    }

    public void setZrnkikensrate95(Double pZrnkikensrate95) {
        zrnkikensrate95 = pZrnkikensrate95;
    }

    private Double zrnkikensrate96;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE96)
    public Double getZrnkikensrate96() {
        return zrnkikensrate96;
    }

    public void setZrnkikensrate96(Double pZrnkikensrate96) {
        zrnkikensrate96 = pZrnkikensrate96;
    }

    private Double zrnkikensrate97;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE97)
    public Double getZrnkikensrate97() {
        return zrnkikensrate97;
    }

    public void setZrnkikensrate97(Double pZrnkikensrate97) {
        zrnkikensrate97 = pZrnkikensrate97;
    }

    private Double zrnkikensrate98;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE98)
    public Double getZrnkikensrate98() {
        return zrnkikensrate98;
    }

    public void setZrnkikensrate98(Double pZrnkikensrate98) {
        zrnkikensrate98 = pZrnkikensrate98;
    }

    private Double zrnkikensrate99;

    @Column(name=GenZT_RatedRn.ZRNKIKENSRATE99)
    public Double getZrnkikensrate99() {
        return zrnkikensrate99;
    }

    public void setZrnkikensrate99(Double pZrnkikensrate99) {
        zrnkikensrate99 = pZrnkikensrate99;
    }
}