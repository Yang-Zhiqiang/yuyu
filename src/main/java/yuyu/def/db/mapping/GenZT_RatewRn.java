package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_RatewRn;
import yuyu.def.db.id.PKZT_RatewRn;
import yuyu.def.db.meta.GenQZT_RatewRn;
import yuyu.def.db.meta.QZT_RatewRn;

/**
 * Ｗレートテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_RatewRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RatewRn}</td><td colspan="3">Ｗレートテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu zrnyoteiriritu}</td><td>（連携用）予定利率</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbn zrnpmenkbn}</td><td>（連携用）Ｐ免区分</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsei zrnhhknsei}</td><td>（連携用）被保険者性別</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujihhknnen zrnkeiyakujihhknnen}</td><td>（連携用）契約時被保険者年令</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">{@link PKZT_RatewRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnwrate00 zrnwrate00}</td><td>（連携用）Ｗレート００</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate01 zrnwrate01}</td><td>（連携用）Ｗレート０１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate02 zrnwrate02}</td><td>（連携用）Ｗレート０２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate03 zrnwrate03}</td><td>（連携用）Ｗレート０３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate04 zrnwrate04}</td><td>（連携用）Ｗレート０４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate05 zrnwrate05}</td><td>（連携用）Ｗレート０５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate06 zrnwrate06}</td><td>（連携用）Ｗレート０６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate07 zrnwrate07}</td><td>（連携用）Ｗレート０７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate08 zrnwrate08}</td><td>（連携用）Ｗレート０８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate09 zrnwrate09}</td><td>（連携用）Ｗレート０９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate10 zrnwrate10}</td><td>（連携用）Ｗレート１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate11 zrnwrate11}</td><td>（連携用）Ｗレート１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate12 zrnwrate12}</td><td>（連携用）Ｗレート１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate13 zrnwrate13}</td><td>（連携用）Ｗレート１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate14 zrnwrate14}</td><td>（連携用）Ｗレート１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate15 zrnwrate15}</td><td>（連携用）Ｗレート１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate16 zrnwrate16}</td><td>（連携用）Ｗレート１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate17 zrnwrate17}</td><td>（連携用）Ｗレート１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate18 zrnwrate18}</td><td>（連携用）Ｗレート１８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate19 zrnwrate19}</td><td>（連携用）Ｗレート１９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate20 zrnwrate20}</td><td>（連携用）Ｗレート２０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate21 zrnwrate21}</td><td>（連携用）Ｗレート２１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate22 zrnwrate22}</td><td>（連携用）Ｗレート２２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate23 zrnwrate23}</td><td>（連携用）Ｗレート２３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate24 zrnwrate24}</td><td>（連携用）Ｗレート２４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate25 zrnwrate25}</td><td>（連携用）Ｗレート２５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate26 zrnwrate26}</td><td>（連携用）Ｗレート２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate27 zrnwrate27}</td><td>（連携用）Ｗレート２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate28 zrnwrate28}</td><td>（連携用）Ｗレート２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate29 zrnwrate29}</td><td>（連携用）Ｗレート２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate30 zrnwrate30}</td><td>（連携用）Ｗレート３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate31 zrnwrate31}</td><td>（連携用）Ｗレート３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate32 zrnwrate32}</td><td>（連携用）Ｗレート３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate33 zrnwrate33}</td><td>（連携用）Ｗレート３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate34 zrnwrate34}</td><td>（連携用）Ｗレート３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate35 zrnwrate35}</td><td>（連携用）Ｗレート３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate36 zrnwrate36}</td><td>（連携用）Ｗレート３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate37 zrnwrate37}</td><td>（連携用）Ｗレート３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate38 zrnwrate38}</td><td>（連携用）Ｗレート３８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate39 zrnwrate39}</td><td>（連携用）Ｗレート３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate40 zrnwrate40}</td><td>（連携用）Ｗレート４０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate41 zrnwrate41}</td><td>（連携用）Ｗレート４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate42 zrnwrate42}</td><td>（連携用）Ｗレート４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate43 zrnwrate43}</td><td>（連携用）Ｗレート４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate44 zrnwrate44}</td><td>（連携用）Ｗレート４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate45 zrnwrate45}</td><td>（連携用）Ｗレート４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate46 zrnwrate46}</td><td>（連携用）Ｗレート４６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate47 zrnwrate47}</td><td>（連携用）Ｗレート４７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate48 zrnwrate48}</td><td>（連携用）Ｗレート４８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate49 zrnwrate49}</td><td>（連携用）Ｗレート４９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate50 zrnwrate50}</td><td>（連携用）Ｗレート５０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate51 zrnwrate51}</td><td>（連携用）Ｗレート５１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate52 zrnwrate52}</td><td>（連携用）Ｗレート５２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate53 zrnwrate53}</td><td>（連携用）Ｗレート５３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate54 zrnwrate54}</td><td>（連携用）Ｗレート５４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate55 zrnwrate55}</td><td>（連携用）Ｗレート５５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate56 zrnwrate56}</td><td>（連携用）Ｗレート５６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate57 zrnwrate57}</td><td>（連携用）Ｗレート５７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate58 zrnwrate58}</td><td>（連携用）Ｗレート５８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate59 zrnwrate59}</td><td>（連携用）Ｗレート５９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate60 zrnwrate60}</td><td>（連携用）Ｗレート６０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate61 zrnwrate61}</td><td>（連携用）Ｗレート６１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate62 zrnwrate62}</td><td>（連携用）Ｗレート６２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate63 zrnwrate63}</td><td>（連携用）Ｗレート６３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate64 zrnwrate64}</td><td>（連携用）Ｗレート６４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate65 zrnwrate65}</td><td>（連携用）Ｗレート６５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate66 zrnwrate66}</td><td>（連携用）Ｗレート６６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate67 zrnwrate67}</td><td>（連携用）Ｗレート６７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate68 zrnwrate68}</td><td>（連携用）Ｗレート６８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate69 zrnwrate69}</td><td>（連携用）Ｗレート６９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate70 zrnwrate70}</td><td>（連携用）Ｗレート７０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate71 zrnwrate71}</td><td>（連携用）Ｗレート７１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate72 zrnwrate72}</td><td>（連携用）Ｗレート７２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate73 zrnwrate73}</td><td>（連携用）Ｗレート７３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate74 zrnwrate74}</td><td>（連携用）Ｗレート７４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate75 zrnwrate75}</td><td>（連携用）Ｗレート７５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate76 zrnwrate76}</td><td>（連携用）Ｗレート７６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate77 zrnwrate77}</td><td>（連携用）Ｗレート７７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate78 zrnwrate78}</td><td>（連携用）Ｗレート７８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate79 zrnwrate79}</td><td>（連携用）Ｗレート７９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate80 zrnwrate80}</td><td>（連携用）Ｗレート８０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate81 zrnwrate81}</td><td>（連携用）Ｗレート８１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate82 zrnwrate82}</td><td>（連携用）Ｗレート８２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate83 zrnwrate83}</td><td>（連携用）Ｗレート８３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate84 zrnwrate84}</td><td>（連携用）Ｗレート８４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate85 zrnwrate85}</td><td>（連携用）Ｗレート８５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate86 zrnwrate86}</td><td>（連携用）Ｗレート８６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate87 zrnwrate87}</td><td>（連携用）Ｗレート８７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate88 zrnwrate88}</td><td>（連携用）Ｗレート８８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate89 zrnwrate89}</td><td>（連携用）Ｗレート８９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate90 zrnwrate90}</td><td>（連携用）Ｗレート９０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate91 zrnwrate91}</td><td>（連携用）Ｗレート９１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate92 zrnwrate92}</td><td>（連携用）Ｗレート９２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate93 zrnwrate93}</td><td>（連携用）Ｗレート９３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate94 zrnwrate94}</td><td>（連携用）Ｗレート９４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate95 zrnwrate95}</td><td>（連携用）Ｗレート９５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate96 zrnwrate96}</td><td>（連携用）Ｗレート９６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate97 zrnwrate97}</td><td>（連携用）Ｗレート９７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate98 zrnwrate98}</td><td>（連携用）Ｗレート９８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrnwrate99 zrnwrate99}</td><td>（連携用）Ｗレート９９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_RatewRn
 * @see     PKZT_RatewRn
 * @see     QZT_RatewRn
 * @see     GenQZT_RatewRn
 */
@MappedSuperclass
@Table(name=GenZT_RatewRn.TABLE_NAME)
@IdClass(value=PKZT_RatewRn.class)
public abstract class GenZT_RatewRn extends AbstractExDBEntityForZDB<ZT_RatewRn, PKZT_RatewRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RatewRn";
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
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNDAI1HKNKKN            = "zrndai1hknkkn";
    public static final String ZRNWRATE00               = "zrnwrate00";
    public static final String ZRNWRATE01               = "zrnwrate01";
    public static final String ZRNWRATE02               = "zrnwrate02";
    public static final String ZRNWRATE03               = "zrnwrate03";
    public static final String ZRNWRATE04               = "zrnwrate04";
    public static final String ZRNWRATE05               = "zrnwrate05";
    public static final String ZRNWRATE06               = "zrnwrate06";
    public static final String ZRNWRATE07               = "zrnwrate07";
    public static final String ZRNWRATE08               = "zrnwrate08";
    public static final String ZRNWRATE09               = "zrnwrate09";
    public static final String ZRNWRATE10               = "zrnwrate10";
    public static final String ZRNWRATE11               = "zrnwrate11";
    public static final String ZRNWRATE12               = "zrnwrate12";
    public static final String ZRNWRATE13               = "zrnwrate13";
    public static final String ZRNWRATE14               = "zrnwrate14";
    public static final String ZRNWRATE15               = "zrnwrate15";
    public static final String ZRNWRATE16               = "zrnwrate16";
    public static final String ZRNWRATE17               = "zrnwrate17";
    public static final String ZRNWRATE18               = "zrnwrate18";
    public static final String ZRNWRATE19               = "zrnwrate19";
    public static final String ZRNWRATE20               = "zrnwrate20";
    public static final String ZRNWRATE21               = "zrnwrate21";
    public static final String ZRNWRATE22               = "zrnwrate22";
    public static final String ZRNWRATE23               = "zrnwrate23";
    public static final String ZRNWRATE24               = "zrnwrate24";
    public static final String ZRNWRATE25               = "zrnwrate25";
    public static final String ZRNWRATE26               = "zrnwrate26";
    public static final String ZRNWRATE27               = "zrnwrate27";
    public static final String ZRNWRATE28               = "zrnwrate28";
    public static final String ZRNWRATE29               = "zrnwrate29";
    public static final String ZRNWRATE30               = "zrnwrate30";
    public static final String ZRNWRATE31               = "zrnwrate31";
    public static final String ZRNWRATE32               = "zrnwrate32";
    public static final String ZRNWRATE33               = "zrnwrate33";
    public static final String ZRNWRATE34               = "zrnwrate34";
    public static final String ZRNWRATE35               = "zrnwrate35";
    public static final String ZRNWRATE36               = "zrnwrate36";
    public static final String ZRNWRATE37               = "zrnwrate37";
    public static final String ZRNWRATE38               = "zrnwrate38";
    public static final String ZRNWRATE39               = "zrnwrate39";
    public static final String ZRNWRATE40               = "zrnwrate40";
    public static final String ZRNWRATE41               = "zrnwrate41";
    public static final String ZRNWRATE42               = "zrnwrate42";
    public static final String ZRNWRATE43               = "zrnwrate43";
    public static final String ZRNWRATE44               = "zrnwrate44";
    public static final String ZRNWRATE45               = "zrnwrate45";
    public static final String ZRNWRATE46               = "zrnwrate46";
    public static final String ZRNWRATE47               = "zrnwrate47";
    public static final String ZRNWRATE48               = "zrnwrate48";
    public static final String ZRNWRATE49               = "zrnwrate49";
    public static final String ZRNWRATE50               = "zrnwrate50";
    public static final String ZRNWRATE51               = "zrnwrate51";
    public static final String ZRNWRATE52               = "zrnwrate52";
    public static final String ZRNWRATE53               = "zrnwrate53";
    public static final String ZRNWRATE54               = "zrnwrate54";
    public static final String ZRNWRATE55               = "zrnwrate55";
    public static final String ZRNWRATE56               = "zrnwrate56";
    public static final String ZRNWRATE57               = "zrnwrate57";
    public static final String ZRNWRATE58               = "zrnwrate58";
    public static final String ZRNWRATE59               = "zrnwrate59";
    public static final String ZRNWRATE60               = "zrnwrate60";
    public static final String ZRNWRATE61               = "zrnwrate61";
    public static final String ZRNWRATE62               = "zrnwrate62";
    public static final String ZRNWRATE63               = "zrnwrate63";
    public static final String ZRNWRATE64               = "zrnwrate64";
    public static final String ZRNWRATE65               = "zrnwrate65";
    public static final String ZRNWRATE66               = "zrnwrate66";
    public static final String ZRNWRATE67               = "zrnwrate67";
    public static final String ZRNWRATE68               = "zrnwrate68";
    public static final String ZRNWRATE69               = "zrnwrate69";
    public static final String ZRNWRATE70               = "zrnwrate70";
    public static final String ZRNWRATE71               = "zrnwrate71";
    public static final String ZRNWRATE72               = "zrnwrate72";
    public static final String ZRNWRATE73               = "zrnwrate73";
    public static final String ZRNWRATE74               = "zrnwrate74";
    public static final String ZRNWRATE75               = "zrnwrate75";
    public static final String ZRNWRATE76               = "zrnwrate76";
    public static final String ZRNWRATE77               = "zrnwrate77";
    public static final String ZRNWRATE78               = "zrnwrate78";
    public static final String ZRNWRATE79               = "zrnwrate79";
    public static final String ZRNWRATE80               = "zrnwrate80";
    public static final String ZRNWRATE81               = "zrnwrate81";
    public static final String ZRNWRATE82               = "zrnwrate82";
    public static final String ZRNWRATE83               = "zrnwrate83";
    public static final String ZRNWRATE84               = "zrnwrate84";
    public static final String ZRNWRATE85               = "zrnwrate85";
    public static final String ZRNWRATE86               = "zrnwrate86";
    public static final String ZRNWRATE87               = "zrnwrate87";
    public static final String ZRNWRATE88               = "zrnwrate88";
    public static final String ZRNWRATE89               = "zrnwrate89";
    public static final String ZRNWRATE90               = "zrnwrate90";
    public static final String ZRNWRATE91               = "zrnwrate91";
    public static final String ZRNWRATE92               = "zrnwrate92";
    public static final String ZRNWRATE93               = "zrnwrate93";
    public static final String ZRNWRATE94               = "zrnwrate94";
    public static final String ZRNWRATE95               = "zrnwrate95";
    public static final String ZRNWRATE96               = "zrnwrate96";
    public static final String ZRNWRATE97               = "zrnwrate97";
    public static final String ZRNWRATE98               = "zrnwrate98";
    public static final String ZRNWRATE99               = "zrnwrate99";

    private final PKZT_RatewRn primaryKey;

    public GenZT_RatewRn() {
        primaryKey = new PKZT_RatewRn();
    }

    public GenZT_RatewRn(
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
        String pZrnannaifuyouriyuukbn,
        String pZrntuukasyukbn,
        String pZrndai1hknkkn
    ) {
        primaryKey = new PKZT_RatewRn(
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
            pZrnannaifuyouriyuukbn,
            pZrntuukasyukbn,
            pZrndai1hknkkn
        );
    }

    @Transient
    @Override
    public PKZT_RatewRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RatewRn> getMetaClass() {
        return QZT_RatewRn.class;
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return getPrimaryKey().getZrnhknsyukigou();
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        getPrimaryKey().setZrnhknsyukigou(pZrnhknsyukigou);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return getPrimaryKey().getZrnhknsyuruikigousedaikbn();
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        getPrimaryKey().setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNYOTEIRIRITU)
    public String getZrnyoteiriritu() {
        return getPrimaryKey().getZrnyoteiriritu();
    }

    public void setZrnyoteiriritu(String pZrnyoteiriritu) {
        getPrimaryKey().setZrnyoteiriritu(pZrnyoteiriritu);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNPMENKBN)
    public String getZrnpmenkbn() {
        return getPrimaryKey().getZrnpmenkbn();
    }

    public void setZrnpmenkbn(String pZrnpmenkbn) {
        getPrimaryKey().setZrnpmenkbn(pZrnpmenkbn);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return getPrimaryKey().getZrnhrkkaisuukbn();
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        getPrimaryKey().setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNHHKNSEI)
    public String getZrnhhknsei() {
        return getPrimaryKey().getZrnhhknsei();
    }

    public void setZrnhhknsei(String pZrnhhknsei) {
        getPrimaryKey().setZrnhhknsei(pZrnhhknsei);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNKEIYAKUJIHHKNNEN)
    public String getZrnkeiyakujihhknnen() {
        return getPrimaryKey().getZrnkeiyakujihhknnen();
    }

    public void setZrnkeiyakujihhknnen(String pZrnkeiyakujihhknnen) {
        getPrimaryKey().setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return getPrimaryKey().getZrnsaimnkkykhyj();
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        getPrimaryKey().setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return getPrimaryKey().getZrnhknkkn();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        getPrimaryKey().setZrnhknkkn(pZrnhknkkn);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return getPrimaryKey().getZrnphrkkikn();
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        getPrimaryKey().setZrnphrkkikn(pZrnphrkkikn);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return getPrimaryKey().getZrnannaifuyouriyuukbn();
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        getPrimaryKey().setZrnannaifuyouriyuukbn(pZrnannaifuyouriyuukbn);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return getPrimaryKey().getZrntuukasyukbn();
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        getPrimaryKey().setZrntuukasyukbn(pZrntuukasyukbn);
    }

    @Id
    @Column(name=GenZT_RatewRn.ZRNDAI1HKNKKN)
    public String getZrndai1hknkkn() {
        return getPrimaryKey().getZrndai1hknkkn();
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        getPrimaryKey().setZrndai1hknkkn(pZrndai1hknkkn);
    }

    private Double zrnwrate00;

    @Column(name=GenZT_RatewRn.ZRNWRATE00)
    public Double getZrnwrate00() {
        return zrnwrate00;
    }

    public void setZrnwrate00(Double pZrnwrate00) {
        zrnwrate00 = pZrnwrate00;
    }

    private Double zrnwrate01;

    @Column(name=GenZT_RatewRn.ZRNWRATE01)
    public Double getZrnwrate01() {
        return zrnwrate01;
    }

    public void setZrnwrate01(Double pZrnwrate01) {
        zrnwrate01 = pZrnwrate01;
    }

    private Double zrnwrate02;

    @Column(name=GenZT_RatewRn.ZRNWRATE02)
    public Double getZrnwrate02() {
        return zrnwrate02;
    }

    public void setZrnwrate02(Double pZrnwrate02) {
        zrnwrate02 = pZrnwrate02;
    }

    private Double zrnwrate03;

    @Column(name=GenZT_RatewRn.ZRNWRATE03)
    public Double getZrnwrate03() {
        return zrnwrate03;
    }

    public void setZrnwrate03(Double pZrnwrate03) {
        zrnwrate03 = pZrnwrate03;
    }

    private Double zrnwrate04;

    @Column(name=GenZT_RatewRn.ZRNWRATE04)
    public Double getZrnwrate04() {
        return zrnwrate04;
    }

    public void setZrnwrate04(Double pZrnwrate04) {
        zrnwrate04 = pZrnwrate04;
    }

    private Double zrnwrate05;

    @Column(name=GenZT_RatewRn.ZRNWRATE05)
    public Double getZrnwrate05() {
        return zrnwrate05;
    }

    public void setZrnwrate05(Double pZrnwrate05) {
        zrnwrate05 = pZrnwrate05;
    }

    private Double zrnwrate06;

    @Column(name=GenZT_RatewRn.ZRNWRATE06)
    public Double getZrnwrate06() {
        return zrnwrate06;
    }

    public void setZrnwrate06(Double pZrnwrate06) {
        zrnwrate06 = pZrnwrate06;
    }

    private Double zrnwrate07;

    @Column(name=GenZT_RatewRn.ZRNWRATE07)
    public Double getZrnwrate07() {
        return zrnwrate07;
    }

    public void setZrnwrate07(Double pZrnwrate07) {
        zrnwrate07 = pZrnwrate07;
    }

    private Double zrnwrate08;

    @Column(name=GenZT_RatewRn.ZRNWRATE08)
    public Double getZrnwrate08() {
        return zrnwrate08;
    }

    public void setZrnwrate08(Double pZrnwrate08) {
        zrnwrate08 = pZrnwrate08;
    }

    private Double zrnwrate09;

    @Column(name=GenZT_RatewRn.ZRNWRATE09)
    public Double getZrnwrate09() {
        return zrnwrate09;
    }

    public void setZrnwrate09(Double pZrnwrate09) {
        zrnwrate09 = pZrnwrate09;
    }

    private Double zrnwrate10;

    @Column(name=GenZT_RatewRn.ZRNWRATE10)
    public Double getZrnwrate10() {
        return zrnwrate10;
    }

    public void setZrnwrate10(Double pZrnwrate10) {
        zrnwrate10 = pZrnwrate10;
    }

    private Double zrnwrate11;

    @Column(name=GenZT_RatewRn.ZRNWRATE11)
    public Double getZrnwrate11() {
        return zrnwrate11;
    }

    public void setZrnwrate11(Double pZrnwrate11) {
        zrnwrate11 = pZrnwrate11;
    }

    private Double zrnwrate12;

    @Column(name=GenZT_RatewRn.ZRNWRATE12)
    public Double getZrnwrate12() {
        return zrnwrate12;
    }

    public void setZrnwrate12(Double pZrnwrate12) {
        zrnwrate12 = pZrnwrate12;
    }

    private Double zrnwrate13;

    @Column(name=GenZT_RatewRn.ZRNWRATE13)
    public Double getZrnwrate13() {
        return zrnwrate13;
    }

    public void setZrnwrate13(Double pZrnwrate13) {
        zrnwrate13 = pZrnwrate13;
    }

    private Double zrnwrate14;

    @Column(name=GenZT_RatewRn.ZRNWRATE14)
    public Double getZrnwrate14() {
        return zrnwrate14;
    }

    public void setZrnwrate14(Double pZrnwrate14) {
        zrnwrate14 = pZrnwrate14;
    }

    private Double zrnwrate15;

    @Column(name=GenZT_RatewRn.ZRNWRATE15)
    public Double getZrnwrate15() {
        return zrnwrate15;
    }

    public void setZrnwrate15(Double pZrnwrate15) {
        zrnwrate15 = pZrnwrate15;
    }

    private Double zrnwrate16;

    @Column(name=GenZT_RatewRn.ZRNWRATE16)
    public Double getZrnwrate16() {
        return zrnwrate16;
    }

    public void setZrnwrate16(Double pZrnwrate16) {
        zrnwrate16 = pZrnwrate16;
    }

    private Double zrnwrate17;

    @Column(name=GenZT_RatewRn.ZRNWRATE17)
    public Double getZrnwrate17() {
        return zrnwrate17;
    }

    public void setZrnwrate17(Double pZrnwrate17) {
        zrnwrate17 = pZrnwrate17;
    }

    private Double zrnwrate18;

    @Column(name=GenZT_RatewRn.ZRNWRATE18)
    public Double getZrnwrate18() {
        return zrnwrate18;
    }

    public void setZrnwrate18(Double pZrnwrate18) {
        zrnwrate18 = pZrnwrate18;
    }

    private Double zrnwrate19;

    @Column(name=GenZT_RatewRn.ZRNWRATE19)
    public Double getZrnwrate19() {
        return zrnwrate19;
    }

    public void setZrnwrate19(Double pZrnwrate19) {
        zrnwrate19 = pZrnwrate19;
    }

    private Double zrnwrate20;

    @Column(name=GenZT_RatewRn.ZRNWRATE20)
    public Double getZrnwrate20() {
        return zrnwrate20;
    }

    public void setZrnwrate20(Double pZrnwrate20) {
        zrnwrate20 = pZrnwrate20;
    }

    private Double zrnwrate21;

    @Column(name=GenZT_RatewRn.ZRNWRATE21)
    public Double getZrnwrate21() {
        return zrnwrate21;
    }

    public void setZrnwrate21(Double pZrnwrate21) {
        zrnwrate21 = pZrnwrate21;
    }

    private Double zrnwrate22;

    @Column(name=GenZT_RatewRn.ZRNWRATE22)
    public Double getZrnwrate22() {
        return zrnwrate22;
    }

    public void setZrnwrate22(Double pZrnwrate22) {
        zrnwrate22 = pZrnwrate22;
    }

    private Double zrnwrate23;

    @Column(name=GenZT_RatewRn.ZRNWRATE23)
    public Double getZrnwrate23() {
        return zrnwrate23;
    }

    public void setZrnwrate23(Double pZrnwrate23) {
        zrnwrate23 = pZrnwrate23;
    }

    private Double zrnwrate24;

    @Column(name=GenZT_RatewRn.ZRNWRATE24)
    public Double getZrnwrate24() {
        return zrnwrate24;
    }

    public void setZrnwrate24(Double pZrnwrate24) {
        zrnwrate24 = pZrnwrate24;
    }

    private Double zrnwrate25;

    @Column(name=GenZT_RatewRn.ZRNWRATE25)
    public Double getZrnwrate25() {
        return zrnwrate25;
    }

    public void setZrnwrate25(Double pZrnwrate25) {
        zrnwrate25 = pZrnwrate25;
    }

    private Double zrnwrate26;

    @Column(name=GenZT_RatewRn.ZRNWRATE26)
    public Double getZrnwrate26() {
        return zrnwrate26;
    }

    public void setZrnwrate26(Double pZrnwrate26) {
        zrnwrate26 = pZrnwrate26;
    }

    private Double zrnwrate27;

    @Column(name=GenZT_RatewRn.ZRNWRATE27)
    public Double getZrnwrate27() {
        return zrnwrate27;
    }

    public void setZrnwrate27(Double pZrnwrate27) {
        zrnwrate27 = pZrnwrate27;
    }

    private Double zrnwrate28;

    @Column(name=GenZT_RatewRn.ZRNWRATE28)
    public Double getZrnwrate28() {
        return zrnwrate28;
    }

    public void setZrnwrate28(Double pZrnwrate28) {
        zrnwrate28 = pZrnwrate28;
    }

    private Double zrnwrate29;

    @Column(name=GenZT_RatewRn.ZRNWRATE29)
    public Double getZrnwrate29() {
        return zrnwrate29;
    }

    public void setZrnwrate29(Double pZrnwrate29) {
        zrnwrate29 = pZrnwrate29;
    }

    private Double zrnwrate30;

    @Column(name=GenZT_RatewRn.ZRNWRATE30)
    public Double getZrnwrate30() {
        return zrnwrate30;
    }

    public void setZrnwrate30(Double pZrnwrate30) {
        zrnwrate30 = pZrnwrate30;
    }

    private Double zrnwrate31;

    @Column(name=GenZT_RatewRn.ZRNWRATE31)
    public Double getZrnwrate31() {
        return zrnwrate31;
    }

    public void setZrnwrate31(Double pZrnwrate31) {
        zrnwrate31 = pZrnwrate31;
    }

    private Double zrnwrate32;

    @Column(name=GenZT_RatewRn.ZRNWRATE32)
    public Double getZrnwrate32() {
        return zrnwrate32;
    }

    public void setZrnwrate32(Double pZrnwrate32) {
        zrnwrate32 = pZrnwrate32;
    }

    private Double zrnwrate33;

    @Column(name=GenZT_RatewRn.ZRNWRATE33)
    public Double getZrnwrate33() {
        return zrnwrate33;
    }

    public void setZrnwrate33(Double pZrnwrate33) {
        zrnwrate33 = pZrnwrate33;
    }

    private Double zrnwrate34;

    @Column(name=GenZT_RatewRn.ZRNWRATE34)
    public Double getZrnwrate34() {
        return zrnwrate34;
    }

    public void setZrnwrate34(Double pZrnwrate34) {
        zrnwrate34 = pZrnwrate34;
    }

    private Double zrnwrate35;

    @Column(name=GenZT_RatewRn.ZRNWRATE35)
    public Double getZrnwrate35() {
        return zrnwrate35;
    }

    public void setZrnwrate35(Double pZrnwrate35) {
        zrnwrate35 = pZrnwrate35;
    }

    private Double zrnwrate36;

    @Column(name=GenZT_RatewRn.ZRNWRATE36)
    public Double getZrnwrate36() {
        return zrnwrate36;
    }

    public void setZrnwrate36(Double pZrnwrate36) {
        zrnwrate36 = pZrnwrate36;
    }

    private Double zrnwrate37;

    @Column(name=GenZT_RatewRn.ZRNWRATE37)
    public Double getZrnwrate37() {
        return zrnwrate37;
    }

    public void setZrnwrate37(Double pZrnwrate37) {
        zrnwrate37 = pZrnwrate37;
    }

    private Double zrnwrate38;

    @Column(name=GenZT_RatewRn.ZRNWRATE38)
    public Double getZrnwrate38() {
        return zrnwrate38;
    }

    public void setZrnwrate38(Double pZrnwrate38) {
        zrnwrate38 = pZrnwrate38;
    }

    private Double zrnwrate39;

    @Column(name=GenZT_RatewRn.ZRNWRATE39)
    public Double getZrnwrate39() {
        return zrnwrate39;
    }

    public void setZrnwrate39(Double pZrnwrate39) {
        zrnwrate39 = pZrnwrate39;
    }

    private Double zrnwrate40;

    @Column(name=GenZT_RatewRn.ZRNWRATE40)
    public Double getZrnwrate40() {
        return zrnwrate40;
    }

    public void setZrnwrate40(Double pZrnwrate40) {
        zrnwrate40 = pZrnwrate40;
    }

    private Double zrnwrate41;

    @Column(name=GenZT_RatewRn.ZRNWRATE41)
    public Double getZrnwrate41() {
        return zrnwrate41;
    }

    public void setZrnwrate41(Double pZrnwrate41) {
        zrnwrate41 = pZrnwrate41;
    }

    private Double zrnwrate42;

    @Column(name=GenZT_RatewRn.ZRNWRATE42)
    public Double getZrnwrate42() {
        return zrnwrate42;
    }

    public void setZrnwrate42(Double pZrnwrate42) {
        zrnwrate42 = pZrnwrate42;
    }

    private Double zrnwrate43;

    @Column(name=GenZT_RatewRn.ZRNWRATE43)
    public Double getZrnwrate43() {
        return zrnwrate43;
    }

    public void setZrnwrate43(Double pZrnwrate43) {
        zrnwrate43 = pZrnwrate43;
    }

    private Double zrnwrate44;

    @Column(name=GenZT_RatewRn.ZRNWRATE44)
    public Double getZrnwrate44() {
        return zrnwrate44;
    }

    public void setZrnwrate44(Double pZrnwrate44) {
        zrnwrate44 = pZrnwrate44;
    }

    private Double zrnwrate45;

    @Column(name=GenZT_RatewRn.ZRNWRATE45)
    public Double getZrnwrate45() {
        return zrnwrate45;
    }

    public void setZrnwrate45(Double pZrnwrate45) {
        zrnwrate45 = pZrnwrate45;
    }

    private Double zrnwrate46;

    @Column(name=GenZT_RatewRn.ZRNWRATE46)
    public Double getZrnwrate46() {
        return zrnwrate46;
    }

    public void setZrnwrate46(Double pZrnwrate46) {
        zrnwrate46 = pZrnwrate46;
    }

    private Double zrnwrate47;

    @Column(name=GenZT_RatewRn.ZRNWRATE47)
    public Double getZrnwrate47() {
        return zrnwrate47;
    }

    public void setZrnwrate47(Double pZrnwrate47) {
        zrnwrate47 = pZrnwrate47;
    }

    private Double zrnwrate48;

    @Column(name=GenZT_RatewRn.ZRNWRATE48)
    public Double getZrnwrate48() {
        return zrnwrate48;
    }

    public void setZrnwrate48(Double pZrnwrate48) {
        zrnwrate48 = pZrnwrate48;
    }

    private Double zrnwrate49;

    @Column(name=GenZT_RatewRn.ZRNWRATE49)
    public Double getZrnwrate49() {
        return zrnwrate49;
    }

    public void setZrnwrate49(Double pZrnwrate49) {
        zrnwrate49 = pZrnwrate49;
    }

    private Double zrnwrate50;

    @Column(name=GenZT_RatewRn.ZRNWRATE50)
    public Double getZrnwrate50() {
        return zrnwrate50;
    }

    public void setZrnwrate50(Double pZrnwrate50) {
        zrnwrate50 = pZrnwrate50;
    }

    private Double zrnwrate51;

    @Column(name=GenZT_RatewRn.ZRNWRATE51)
    public Double getZrnwrate51() {
        return zrnwrate51;
    }

    public void setZrnwrate51(Double pZrnwrate51) {
        zrnwrate51 = pZrnwrate51;
    }

    private Double zrnwrate52;

    @Column(name=GenZT_RatewRn.ZRNWRATE52)
    public Double getZrnwrate52() {
        return zrnwrate52;
    }

    public void setZrnwrate52(Double pZrnwrate52) {
        zrnwrate52 = pZrnwrate52;
    }

    private Double zrnwrate53;

    @Column(name=GenZT_RatewRn.ZRNWRATE53)
    public Double getZrnwrate53() {
        return zrnwrate53;
    }

    public void setZrnwrate53(Double pZrnwrate53) {
        zrnwrate53 = pZrnwrate53;
    }

    private Double zrnwrate54;

    @Column(name=GenZT_RatewRn.ZRNWRATE54)
    public Double getZrnwrate54() {
        return zrnwrate54;
    }

    public void setZrnwrate54(Double pZrnwrate54) {
        zrnwrate54 = pZrnwrate54;
    }

    private Double zrnwrate55;

    @Column(name=GenZT_RatewRn.ZRNWRATE55)
    public Double getZrnwrate55() {
        return zrnwrate55;
    }

    public void setZrnwrate55(Double pZrnwrate55) {
        zrnwrate55 = pZrnwrate55;
    }

    private Double zrnwrate56;

    @Column(name=GenZT_RatewRn.ZRNWRATE56)
    public Double getZrnwrate56() {
        return zrnwrate56;
    }

    public void setZrnwrate56(Double pZrnwrate56) {
        zrnwrate56 = pZrnwrate56;
    }

    private Double zrnwrate57;

    @Column(name=GenZT_RatewRn.ZRNWRATE57)
    public Double getZrnwrate57() {
        return zrnwrate57;
    }

    public void setZrnwrate57(Double pZrnwrate57) {
        zrnwrate57 = pZrnwrate57;
    }

    private Double zrnwrate58;

    @Column(name=GenZT_RatewRn.ZRNWRATE58)
    public Double getZrnwrate58() {
        return zrnwrate58;
    }

    public void setZrnwrate58(Double pZrnwrate58) {
        zrnwrate58 = pZrnwrate58;
    }

    private Double zrnwrate59;

    @Column(name=GenZT_RatewRn.ZRNWRATE59)
    public Double getZrnwrate59() {
        return zrnwrate59;
    }

    public void setZrnwrate59(Double pZrnwrate59) {
        zrnwrate59 = pZrnwrate59;
    }

    private Double zrnwrate60;

    @Column(name=GenZT_RatewRn.ZRNWRATE60)
    public Double getZrnwrate60() {
        return zrnwrate60;
    }

    public void setZrnwrate60(Double pZrnwrate60) {
        zrnwrate60 = pZrnwrate60;
    }

    private Double zrnwrate61;

    @Column(name=GenZT_RatewRn.ZRNWRATE61)
    public Double getZrnwrate61() {
        return zrnwrate61;
    }

    public void setZrnwrate61(Double pZrnwrate61) {
        zrnwrate61 = pZrnwrate61;
    }

    private Double zrnwrate62;

    @Column(name=GenZT_RatewRn.ZRNWRATE62)
    public Double getZrnwrate62() {
        return zrnwrate62;
    }

    public void setZrnwrate62(Double pZrnwrate62) {
        zrnwrate62 = pZrnwrate62;
    }

    private Double zrnwrate63;

    @Column(name=GenZT_RatewRn.ZRNWRATE63)
    public Double getZrnwrate63() {
        return zrnwrate63;
    }

    public void setZrnwrate63(Double pZrnwrate63) {
        zrnwrate63 = pZrnwrate63;
    }

    private Double zrnwrate64;

    @Column(name=GenZT_RatewRn.ZRNWRATE64)
    public Double getZrnwrate64() {
        return zrnwrate64;
    }

    public void setZrnwrate64(Double pZrnwrate64) {
        zrnwrate64 = pZrnwrate64;
    }

    private Double zrnwrate65;

    @Column(name=GenZT_RatewRn.ZRNWRATE65)
    public Double getZrnwrate65() {
        return zrnwrate65;
    }

    public void setZrnwrate65(Double pZrnwrate65) {
        zrnwrate65 = pZrnwrate65;
    }

    private Double zrnwrate66;

    @Column(name=GenZT_RatewRn.ZRNWRATE66)
    public Double getZrnwrate66() {
        return zrnwrate66;
    }

    public void setZrnwrate66(Double pZrnwrate66) {
        zrnwrate66 = pZrnwrate66;
    }

    private Double zrnwrate67;

    @Column(name=GenZT_RatewRn.ZRNWRATE67)
    public Double getZrnwrate67() {
        return zrnwrate67;
    }

    public void setZrnwrate67(Double pZrnwrate67) {
        zrnwrate67 = pZrnwrate67;
    }

    private Double zrnwrate68;

    @Column(name=GenZT_RatewRn.ZRNWRATE68)
    public Double getZrnwrate68() {
        return zrnwrate68;
    }

    public void setZrnwrate68(Double pZrnwrate68) {
        zrnwrate68 = pZrnwrate68;
    }

    private Double zrnwrate69;

    @Column(name=GenZT_RatewRn.ZRNWRATE69)
    public Double getZrnwrate69() {
        return zrnwrate69;
    }

    public void setZrnwrate69(Double pZrnwrate69) {
        zrnwrate69 = pZrnwrate69;
    }

    private Double zrnwrate70;

    @Column(name=GenZT_RatewRn.ZRNWRATE70)
    public Double getZrnwrate70() {
        return zrnwrate70;
    }

    public void setZrnwrate70(Double pZrnwrate70) {
        zrnwrate70 = pZrnwrate70;
    }

    private Double zrnwrate71;

    @Column(name=GenZT_RatewRn.ZRNWRATE71)
    public Double getZrnwrate71() {
        return zrnwrate71;
    }

    public void setZrnwrate71(Double pZrnwrate71) {
        zrnwrate71 = pZrnwrate71;
    }

    private Double zrnwrate72;

    @Column(name=GenZT_RatewRn.ZRNWRATE72)
    public Double getZrnwrate72() {
        return zrnwrate72;
    }

    public void setZrnwrate72(Double pZrnwrate72) {
        zrnwrate72 = pZrnwrate72;
    }

    private Double zrnwrate73;

    @Column(name=GenZT_RatewRn.ZRNWRATE73)
    public Double getZrnwrate73() {
        return zrnwrate73;
    }

    public void setZrnwrate73(Double pZrnwrate73) {
        zrnwrate73 = pZrnwrate73;
    }

    private Double zrnwrate74;

    @Column(name=GenZT_RatewRn.ZRNWRATE74)
    public Double getZrnwrate74() {
        return zrnwrate74;
    }

    public void setZrnwrate74(Double pZrnwrate74) {
        zrnwrate74 = pZrnwrate74;
    }

    private Double zrnwrate75;

    @Column(name=GenZT_RatewRn.ZRNWRATE75)
    public Double getZrnwrate75() {
        return zrnwrate75;
    }

    public void setZrnwrate75(Double pZrnwrate75) {
        zrnwrate75 = pZrnwrate75;
    }

    private Double zrnwrate76;

    @Column(name=GenZT_RatewRn.ZRNWRATE76)
    public Double getZrnwrate76() {
        return zrnwrate76;
    }

    public void setZrnwrate76(Double pZrnwrate76) {
        zrnwrate76 = pZrnwrate76;
    }

    private Double zrnwrate77;

    @Column(name=GenZT_RatewRn.ZRNWRATE77)
    public Double getZrnwrate77() {
        return zrnwrate77;
    }

    public void setZrnwrate77(Double pZrnwrate77) {
        zrnwrate77 = pZrnwrate77;
    }

    private Double zrnwrate78;

    @Column(name=GenZT_RatewRn.ZRNWRATE78)
    public Double getZrnwrate78() {
        return zrnwrate78;
    }

    public void setZrnwrate78(Double pZrnwrate78) {
        zrnwrate78 = pZrnwrate78;
    }

    private Double zrnwrate79;

    @Column(name=GenZT_RatewRn.ZRNWRATE79)
    public Double getZrnwrate79() {
        return zrnwrate79;
    }

    public void setZrnwrate79(Double pZrnwrate79) {
        zrnwrate79 = pZrnwrate79;
    }

    private Double zrnwrate80;

    @Column(name=GenZT_RatewRn.ZRNWRATE80)
    public Double getZrnwrate80() {
        return zrnwrate80;
    }

    public void setZrnwrate80(Double pZrnwrate80) {
        zrnwrate80 = pZrnwrate80;
    }

    private Double zrnwrate81;

    @Column(name=GenZT_RatewRn.ZRNWRATE81)
    public Double getZrnwrate81() {
        return zrnwrate81;
    }

    public void setZrnwrate81(Double pZrnwrate81) {
        zrnwrate81 = pZrnwrate81;
    }

    private Double zrnwrate82;

    @Column(name=GenZT_RatewRn.ZRNWRATE82)
    public Double getZrnwrate82() {
        return zrnwrate82;
    }

    public void setZrnwrate82(Double pZrnwrate82) {
        zrnwrate82 = pZrnwrate82;
    }

    private Double zrnwrate83;

    @Column(name=GenZT_RatewRn.ZRNWRATE83)
    public Double getZrnwrate83() {
        return zrnwrate83;
    }

    public void setZrnwrate83(Double pZrnwrate83) {
        zrnwrate83 = pZrnwrate83;
    }

    private Double zrnwrate84;

    @Column(name=GenZT_RatewRn.ZRNWRATE84)
    public Double getZrnwrate84() {
        return zrnwrate84;
    }

    public void setZrnwrate84(Double pZrnwrate84) {
        zrnwrate84 = pZrnwrate84;
    }

    private Double zrnwrate85;

    @Column(name=GenZT_RatewRn.ZRNWRATE85)
    public Double getZrnwrate85() {
        return zrnwrate85;
    }

    public void setZrnwrate85(Double pZrnwrate85) {
        zrnwrate85 = pZrnwrate85;
    }

    private Double zrnwrate86;

    @Column(name=GenZT_RatewRn.ZRNWRATE86)
    public Double getZrnwrate86() {
        return zrnwrate86;
    }

    public void setZrnwrate86(Double pZrnwrate86) {
        zrnwrate86 = pZrnwrate86;
    }

    private Double zrnwrate87;

    @Column(name=GenZT_RatewRn.ZRNWRATE87)
    public Double getZrnwrate87() {
        return zrnwrate87;
    }

    public void setZrnwrate87(Double pZrnwrate87) {
        zrnwrate87 = pZrnwrate87;
    }

    private Double zrnwrate88;

    @Column(name=GenZT_RatewRn.ZRNWRATE88)
    public Double getZrnwrate88() {
        return zrnwrate88;
    }

    public void setZrnwrate88(Double pZrnwrate88) {
        zrnwrate88 = pZrnwrate88;
    }

    private Double zrnwrate89;

    @Column(name=GenZT_RatewRn.ZRNWRATE89)
    public Double getZrnwrate89() {
        return zrnwrate89;
    }

    public void setZrnwrate89(Double pZrnwrate89) {
        zrnwrate89 = pZrnwrate89;
    }

    private Double zrnwrate90;

    @Column(name=GenZT_RatewRn.ZRNWRATE90)
    public Double getZrnwrate90() {
        return zrnwrate90;
    }

    public void setZrnwrate90(Double pZrnwrate90) {
        zrnwrate90 = pZrnwrate90;
    }

    private Double zrnwrate91;

    @Column(name=GenZT_RatewRn.ZRNWRATE91)
    public Double getZrnwrate91() {
        return zrnwrate91;
    }

    public void setZrnwrate91(Double pZrnwrate91) {
        zrnwrate91 = pZrnwrate91;
    }

    private Double zrnwrate92;

    @Column(name=GenZT_RatewRn.ZRNWRATE92)
    public Double getZrnwrate92() {
        return zrnwrate92;
    }

    public void setZrnwrate92(Double pZrnwrate92) {
        zrnwrate92 = pZrnwrate92;
    }

    private Double zrnwrate93;

    @Column(name=GenZT_RatewRn.ZRNWRATE93)
    public Double getZrnwrate93() {
        return zrnwrate93;
    }

    public void setZrnwrate93(Double pZrnwrate93) {
        zrnwrate93 = pZrnwrate93;
    }

    private Double zrnwrate94;

    @Column(name=GenZT_RatewRn.ZRNWRATE94)
    public Double getZrnwrate94() {
        return zrnwrate94;
    }

    public void setZrnwrate94(Double pZrnwrate94) {
        zrnwrate94 = pZrnwrate94;
    }

    private Double zrnwrate95;

    @Column(name=GenZT_RatewRn.ZRNWRATE95)
    public Double getZrnwrate95() {
        return zrnwrate95;
    }

    public void setZrnwrate95(Double pZrnwrate95) {
        zrnwrate95 = pZrnwrate95;
    }

    private Double zrnwrate96;

    @Column(name=GenZT_RatewRn.ZRNWRATE96)
    public Double getZrnwrate96() {
        return zrnwrate96;
    }

    public void setZrnwrate96(Double pZrnwrate96) {
        zrnwrate96 = pZrnwrate96;
    }

    private Double zrnwrate97;

    @Column(name=GenZT_RatewRn.ZRNWRATE97)
    public Double getZrnwrate97() {
        return zrnwrate97;
    }

    public void setZrnwrate97(Double pZrnwrate97) {
        zrnwrate97 = pZrnwrate97;
    }

    private Double zrnwrate98;

    @Column(name=GenZT_RatewRn.ZRNWRATE98)
    public Double getZrnwrate98() {
        return zrnwrate98;
    }

    public void setZrnwrate98(Double pZrnwrate98) {
        zrnwrate98 = pZrnwrate98;
    }

    private Double zrnwrate99;

    @Column(name=GenZT_RatewRn.ZRNWRATE99)
    public Double getZrnwrate99() {
        return zrnwrate99;
    }

    public void setZrnwrate99(Double pZrnwrate99) {
        zrnwrate99 = pZrnwrate99;
    }
}