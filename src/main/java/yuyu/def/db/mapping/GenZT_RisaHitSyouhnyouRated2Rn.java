package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.db.id.PKZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.db.meta.GenQZT_RisaHitSyouhnyouRated2Rn;
import yuyu.def.db.meta.QZT_RisaHitSyouhnyouRated2Rn;

/**
 * 利差配当商品用Ｄレートテーブル２（連） テーブルのマッピング情報クラスで、 {@link ZT_RisaHitSyouhnyouRated2Rn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RisaHitSyouhnyouRated2Rn}</td><td colspan="3">利差配当商品用Ｄレートテーブル２（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu zrnyoteiriritu}</td><td>（連携用）予定利率</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbn zrnpmenkbn}</td><td>（連携用）Ｐ免区分</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsei zrnhhknsei}</td><td>（連携用）被保険者性別</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujihhknnen zrnkeiyakujihhknnen}</td><td>（連携用）契約時被保険者年令</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndnendo zrndnendo}</td><td>（連携用）Ｄ年度</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaiteikakuteikbn zrnnaiteikakuteikbn}</td><td>（連携用）Ｄレート内定確定区分</td><td align="center">{@link PKZT_RisaHitSyouhnyouRated2Rn ○}</td><td align="center">C</td><td>String</td></tr>
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
 * </table>
 * @see     ZT_RisaHitSyouhnyouRated2Rn
 * @see     PKZT_RisaHitSyouhnyouRated2Rn
 * @see     QZT_RisaHitSyouhnyouRated2Rn
 * @see     GenQZT_RisaHitSyouhnyouRated2Rn
 */
@MappedSuperclass
@Table(name=GenZT_RisaHitSyouhnyouRated2Rn.TABLE_NAME)
@IdClass(value=PKZT_RisaHitSyouhnyouRated2Rn.class)
public abstract class GenZT_RisaHitSyouhnyouRated2Rn extends AbstractExDBEntityForZDB<ZT_RisaHitSyouhnyouRated2Rn, PKZT_RisaHitSyouhnyouRated2Rn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_RisaHitSyouhnyouRated2Rn";
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

    private final PKZT_RisaHitSyouhnyouRated2Rn primaryKey;

    public GenZT_RisaHitSyouhnyouRated2Rn() {
        primaryKey = new PKZT_RisaHitSyouhnyouRated2Rn();
    }

    public GenZT_RisaHitSyouhnyouRated2Rn(
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
        String pZrndai1hknkkn,
        String pZrndnendo,
        String pZrnnaiteikakuteikbn
    ) {
        primaryKey = new PKZT_RisaHitSyouhnyouRated2Rn(
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
            pZrndai1hknkkn,
            pZrndnendo,
            pZrnnaiteikakuteikbn
        );
    }

    @Transient
    @Override
    public PKZT_RisaHitSyouhnyouRated2Rn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_RisaHitSyouhnyouRated2Rn> getMetaClass() {
        return QZT_RisaHitSyouhnyouRated2Rn.class;
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return getPrimaryKey().getZrnhknsyukigou();
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        getPrimaryKey().setZrnhknsyukigou(pZrnhknsyukigou);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return getPrimaryKey().getZrnhknsyuruikigousedaikbn();
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        getPrimaryKey().setZrnhknsyuruikigousedaikbn(pZrnhknsyuruikigousedaikbn);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNYOTEIRIRITU)
    public String getZrnyoteiriritu() {
        return getPrimaryKey().getZrnyoteiriritu();
    }

    public void setZrnyoteiriritu(String pZrnyoteiriritu) {
        getPrimaryKey().setZrnyoteiriritu(pZrnyoteiriritu);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNPMENKBN)
    public String getZrnpmenkbn() {
        return getPrimaryKey().getZrnpmenkbn();
    }

    public void setZrnpmenkbn(String pZrnpmenkbn) {
        getPrimaryKey().setZrnpmenkbn(pZrnpmenkbn);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return getPrimaryKey().getZrnhrkkaisuukbn();
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        getPrimaryKey().setZrnhrkkaisuukbn(pZrnhrkkaisuukbn);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNHHKNSEI)
    public String getZrnhhknsei() {
        return getPrimaryKey().getZrnhhknsei();
    }

    public void setZrnhhknsei(String pZrnhhknsei) {
        getPrimaryKey().setZrnhhknsei(pZrnhhknsei);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNKEIYAKUJIHHKNNEN)
    public String getZrnkeiyakujihhknnen() {
        return getPrimaryKey().getZrnkeiyakujihhknnen();
    }

    public void setZrnkeiyakujihhknnen(String pZrnkeiyakujihhknnen) {
        getPrimaryKey().setZrnkeiyakujihhknnen(pZrnkeiyakujihhknnen);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return getPrimaryKey().getZrnsaimnkkykhyj();
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        getPrimaryKey().setZrnsaimnkkykhyj(pZrnsaimnkkykhyj);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return getPrimaryKey().getZrnhknkkn();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        getPrimaryKey().setZrnhknkkn(pZrnhknkkn);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return getPrimaryKey().getZrnphrkkikn();
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        getPrimaryKey().setZrnphrkkikn(pZrnphrkkikn);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return getPrimaryKey().getZrnannaifuyouriyuukbn();
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        getPrimaryKey().setZrnannaifuyouriyuukbn(pZrnannaifuyouriyuukbn);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return getPrimaryKey().getZrntuukasyukbn();
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        getPrimaryKey().setZrntuukasyukbn(pZrntuukasyukbn);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDAI1HKNKKN)
    public String getZrndai1hknkkn() {
        return getPrimaryKey().getZrndai1hknkkn();
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        getPrimaryKey().setZrndai1hknkkn(pZrndai1hknkkn);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDNENDO)
    public String getZrndnendo() {
        return getPrimaryKey().getZrndnendo();
    }

    public void setZrndnendo(String pZrndnendo) {
        getPrimaryKey().setZrndnendo(pZrndnendo);
    }

    @Id
    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNNAITEIKAKUTEIKBN)
    public String getZrnnaiteikakuteikbn() {
        return getPrimaryKey().getZrnnaiteikakuteikbn();
    }

    public void setZrnnaiteikakuteikbn(String pZrnnaiteikakuteikbn) {
        getPrimaryKey().setZrnnaiteikakuteikbn(pZrnnaiteikakuteikbn);
    }

    private Double zrndrate00;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE00)
    public Double getZrndrate00() {
        return zrndrate00;
    }

    public void setZrndrate00(Double pZrndrate00) {
        zrndrate00 = pZrndrate00;
    }

    private Double zrndrate01;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE01)
    public Double getZrndrate01() {
        return zrndrate01;
    }

    public void setZrndrate01(Double pZrndrate01) {
        zrndrate01 = pZrndrate01;
    }

    private Double zrndrate02;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE02)
    public Double getZrndrate02() {
        return zrndrate02;
    }

    public void setZrndrate02(Double pZrndrate02) {
        zrndrate02 = pZrndrate02;
    }

    private Double zrndrate03;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE03)
    public Double getZrndrate03() {
        return zrndrate03;
    }

    public void setZrndrate03(Double pZrndrate03) {
        zrndrate03 = pZrndrate03;
    }

    private Double zrndrate04;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE04)
    public Double getZrndrate04() {
        return zrndrate04;
    }

    public void setZrndrate04(Double pZrndrate04) {
        zrndrate04 = pZrndrate04;
    }

    private Double zrndrate05;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE05)
    public Double getZrndrate05() {
        return zrndrate05;
    }

    public void setZrndrate05(Double pZrndrate05) {
        zrndrate05 = pZrndrate05;
    }

    private Double zrndrate06;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE06)
    public Double getZrndrate06() {
        return zrndrate06;
    }

    public void setZrndrate06(Double pZrndrate06) {
        zrndrate06 = pZrndrate06;
    }

    private Double zrndrate07;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE07)
    public Double getZrndrate07() {
        return zrndrate07;
    }

    public void setZrndrate07(Double pZrndrate07) {
        zrndrate07 = pZrndrate07;
    }

    private Double zrndrate08;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE08)
    public Double getZrndrate08() {
        return zrndrate08;
    }

    public void setZrndrate08(Double pZrndrate08) {
        zrndrate08 = pZrndrate08;
    }

    private Double zrndrate09;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE09)
    public Double getZrndrate09() {
        return zrndrate09;
    }

    public void setZrndrate09(Double pZrndrate09) {
        zrndrate09 = pZrndrate09;
    }

    private Double zrndrate10;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE10)
    public Double getZrndrate10() {
        return zrndrate10;
    }

    public void setZrndrate10(Double pZrndrate10) {
        zrndrate10 = pZrndrate10;
    }

    private Double zrndrate11;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE11)
    public Double getZrndrate11() {
        return zrndrate11;
    }

    public void setZrndrate11(Double pZrndrate11) {
        zrndrate11 = pZrndrate11;
    }

    private Double zrndrate12;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE12)
    public Double getZrndrate12() {
        return zrndrate12;
    }

    public void setZrndrate12(Double pZrndrate12) {
        zrndrate12 = pZrndrate12;
    }

    private Double zrndrate13;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE13)
    public Double getZrndrate13() {
        return zrndrate13;
    }

    public void setZrndrate13(Double pZrndrate13) {
        zrndrate13 = pZrndrate13;
    }

    private Double zrndrate14;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE14)
    public Double getZrndrate14() {
        return zrndrate14;
    }

    public void setZrndrate14(Double pZrndrate14) {
        zrndrate14 = pZrndrate14;
    }

    private Double zrndrate15;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE15)
    public Double getZrndrate15() {
        return zrndrate15;
    }

    public void setZrndrate15(Double pZrndrate15) {
        zrndrate15 = pZrndrate15;
    }

    private Double zrndrate16;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE16)
    public Double getZrndrate16() {
        return zrndrate16;
    }

    public void setZrndrate16(Double pZrndrate16) {
        zrndrate16 = pZrndrate16;
    }

    private Double zrndrate17;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE17)
    public Double getZrndrate17() {
        return zrndrate17;
    }

    public void setZrndrate17(Double pZrndrate17) {
        zrndrate17 = pZrndrate17;
    }

    private Double zrndrate18;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE18)
    public Double getZrndrate18() {
        return zrndrate18;
    }

    public void setZrndrate18(Double pZrndrate18) {
        zrndrate18 = pZrndrate18;
    }

    private Double zrndrate19;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE19)
    public Double getZrndrate19() {
        return zrndrate19;
    }

    public void setZrndrate19(Double pZrndrate19) {
        zrndrate19 = pZrndrate19;
    }

    private Double zrndrate20;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE20)
    public Double getZrndrate20() {
        return zrndrate20;
    }

    public void setZrndrate20(Double pZrndrate20) {
        zrndrate20 = pZrndrate20;
    }

    private Double zrndrate21;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE21)
    public Double getZrndrate21() {
        return zrndrate21;
    }

    public void setZrndrate21(Double pZrndrate21) {
        zrndrate21 = pZrndrate21;
    }

    private Double zrndrate22;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE22)
    public Double getZrndrate22() {
        return zrndrate22;
    }

    public void setZrndrate22(Double pZrndrate22) {
        zrndrate22 = pZrndrate22;
    }

    private Double zrndrate23;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE23)
    public Double getZrndrate23() {
        return zrndrate23;
    }

    public void setZrndrate23(Double pZrndrate23) {
        zrndrate23 = pZrndrate23;
    }

    private Double zrndrate24;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE24)
    public Double getZrndrate24() {
        return zrndrate24;
    }

    public void setZrndrate24(Double pZrndrate24) {
        zrndrate24 = pZrndrate24;
    }

    private Double zrndrate25;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE25)
    public Double getZrndrate25() {
        return zrndrate25;
    }

    public void setZrndrate25(Double pZrndrate25) {
        zrndrate25 = pZrndrate25;
    }

    private Double zrndrate26;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE26)
    public Double getZrndrate26() {
        return zrndrate26;
    }

    public void setZrndrate26(Double pZrndrate26) {
        zrndrate26 = pZrndrate26;
    }

    private Double zrndrate27;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE27)
    public Double getZrndrate27() {
        return zrndrate27;
    }

    public void setZrndrate27(Double pZrndrate27) {
        zrndrate27 = pZrndrate27;
    }

    private Double zrndrate28;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE28)
    public Double getZrndrate28() {
        return zrndrate28;
    }

    public void setZrndrate28(Double pZrndrate28) {
        zrndrate28 = pZrndrate28;
    }

    private Double zrndrate29;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE29)
    public Double getZrndrate29() {
        return zrndrate29;
    }

    public void setZrndrate29(Double pZrndrate29) {
        zrndrate29 = pZrndrate29;
    }

    private Double zrndrate30;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE30)
    public Double getZrndrate30() {
        return zrndrate30;
    }

    public void setZrndrate30(Double pZrndrate30) {
        zrndrate30 = pZrndrate30;
    }

    private Double zrndrate31;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE31)
    public Double getZrndrate31() {
        return zrndrate31;
    }

    public void setZrndrate31(Double pZrndrate31) {
        zrndrate31 = pZrndrate31;
    }

    private Double zrndrate32;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE32)
    public Double getZrndrate32() {
        return zrndrate32;
    }

    public void setZrndrate32(Double pZrndrate32) {
        zrndrate32 = pZrndrate32;
    }

    private Double zrndrate33;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE33)
    public Double getZrndrate33() {
        return zrndrate33;
    }

    public void setZrndrate33(Double pZrndrate33) {
        zrndrate33 = pZrndrate33;
    }

    private Double zrndrate34;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE34)
    public Double getZrndrate34() {
        return zrndrate34;
    }

    public void setZrndrate34(Double pZrndrate34) {
        zrndrate34 = pZrndrate34;
    }

    private Double zrndrate35;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE35)
    public Double getZrndrate35() {
        return zrndrate35;
    }

    public void setZrndrate35(Double pZrndrate35) {
        zrndrate35 = pZrndrate35;
    }

    private Double zrndrate36;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE36)
    public Double getZrndrate36() {
        return zrndrate36;
    }

    public void setZrndrate36(Double pZrndrate36) {
        zrndrate36 = pZrndrate36;
    }

    private Double zrndrate37;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE37)
    public Double getZrndrate37() {
        return zrndrate37;
    }

    public void setZrndrate37(Double pZrndrate37) {
        zrndrate37 = pZrndrate37;
    }

    private Double zrndrate38;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE38)
    public Double getZrndrate38() {
        return zrndrate38;
    }

    public void setZrndrate38(Double pZrndrate38) {
        zrndrate38 = pZrndrate38;
    }

    private Double zrndrate39;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE39)
    public Double getZrndrate39() {
        return zrndrate39;
    }

    public void setZrndrate39(Double pZrndrate39) {
        zrndrate39 = pZrndrate39;
    }

    private Double zrndrate40;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE40)
    public Double getZrndrate40() {
        return zrndrate40;
    }

    public void setZrndrate40(Double pZrndrate40) {
        zrndrate40 = pZrndrate40;
    }

    private Double zrndrate41;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE41)
    public Double getZrndrate41() {
        return zrndrate41;
    }

    public void setZrndrate41(Double pZrndrate41) {
        zrndrate41 = pZrndrate41;
    }

    private Double zrndrate42;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE42)
    public Double getZrndrate42() {
        return zrndrate42;
    }

    public void setZrndrate42(Double pZrndrate42) {
        zrndrate42 = pZrndrate42;
    }

    private Double zrndrate43;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE43)
    public Double getZrndrate43() {
        return zrndrate43;
    }

    public void setZrndrate43(Double pZrndrate43) {
        zrndrate43 = pZrndrate43;
    }

    private Double zrndrate44;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE44)
    public Double getZrndrate44() {
        return zrndrate44;
    }

    public void setZrndrate44(Double pZrndrate44) {
        zrndrate44 = pZrndrate44;
    }

    private Double zrndrate45;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE45)
    public Double getZrndrate45() {
        return zrndrate45;
    }

    public void setZrndrate45(Double pZrndrate45) {
        zrndrate45 = pZrndrate45;
    }

    private Double zrndrate46;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE46)
    public Double getZrndrate46() {
        return zrndrate46;
    }

    public void setZrndrate46(Double pZrndrate46) {
        zrndrate46 = pZrndrate46;
    }

    private Double zrndrate47;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE47)
    public Double getZrndrate47() {
        return zrndrate47;
    }

    public void setZrndrate47(Double pZrndrate47) {
        zrndrate47 = pZrndrate47;
    }

    private Double zrndrate48;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE48)
    public Double getZrndrate48() {
        return zrndrate48;
    }

    public void setZrndrate48(Double pZrndrate48) {
        zrndrate48 = pZrndrate48;
    }

    private Double zrndrate49;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE49)
    public Double getZrndrate49() {
        return zrndrate49;
    }

    public void setZrndrate49(Double pZrndrate49) {
        zrndrate49 = pZrndrate49;
    }

    private Double zrndrate50;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE50)
    public Double getZrndrate50() {
        return zrndrate50;
    }

    public void setZrndrate50(Double pZrndrate50) {
        zrndrate50 = pZrndrate50;
    }

    private Double zrndrate51;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE51)
    public Double getZrndrate51() {
        return zrndrate51;
    }

    public void setZrndrate51(Double pZrndrate51) {
        zrndrate51 = pZrndrate51;
    }

    private Double zrndrate52;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE52)
    public Double getZrndrate52() {
        return zrndrate52;
    }

    public void setZrndrate52(Double pZrndrate52) {
        zrndrate52 = pZrndrate52;
    }

    private Double zrndrate53;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE53)
    public Double getZrndrate53() {
        return zrndrate53;
    }

    public void setZrndrate53(Double pZrndrate53) {
        zrndrate53 = pZrndrate53;
    }

    private Double zrndrate54;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE54)
    public Double getZrndrate54() {
        return zrndrate54;
    }

    public void setZrndrate54(Double pZrndrate54) {
        zrndrate54 = pZrndrate54;
    }

    private Double zrndrate55;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE55)
    public Double getZrndrate55() {
        return zrndrate55;
    }

    public void setZrndrate55(Double pZrndrate55) {
        zrndrate55 = pZrndrate55;
    }

    private Double zrndrate56;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE56)
    public Double getZrndrate56() {
        return zrndrate56;
    }

    public void setZrndrate56(Double pZrndrate56) {
        zrndrate56 = pZrndrate56;
    }

    private Double zrndrate57;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE57)
    public Double getZrndrate57() {
        return zrndrate57;
    }

    public void setZrndrate57(Double pZrndrate57) {
        zrndrate57 = pZrndrate57;
    }

    private Double zrndrate58;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE58)
    public Double getZrndrate58() {
        return zrndrate58;
    }

    public void setZrndrate58(Double pZrndrate58) {
        zrndrate58 = pZrndrate58;
    }

    private Double zrndrate59;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE59)
    public Double getZrndrate59() {
        return zrndrate59;
    }

    public void setZrndrate59(Double pZrndrate59) {
        zrndrate59 = pZrndrate59;
    }

    private Double zrndrate60;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE60)
    public Double getZrndrate60() {
        return zrndrate60;
    }

    public void setZrndrate60(Double pZrndrate60) {
        zrndrate60 = pZrndrate60;
    }

    private Double zrndrate61;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE61)
    public Double getZrndrate61() {
        return zrndrate61;
    }

    public void setZrndrate61(Double pZrndrate61) {
        zrndrate61 = pZrndrate61;
    }

    private Double zrndrate62;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE62)
    public Double getZrndrate62() {
        return zrndrate62;
    }

    public void setZrndrate62(Double pZrndrate62) {
        zrndrate62 = pZrndrate62;
    }

    private Double zrndrate63;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE63)
    public Double getZrndrate63() {
        return zrndrate63;
    }

    public void setZrndrate63(Double pZrndrate63) {
        zrndrate63 = pZrndrate63;
    }

    private Double zrndrate64;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE64)
    public Double getZrndrate64() {
        return zrndrate64;
    }

    public void setZrndrate64(Double pZrndrate64) {
        zrndrate64 = pZrndrate64;
    }

    private Double zrndrate65;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE65)
    public Double getZrndrate65() {
        return zrndrate65;
    }

    public void setZrndrate65(Double pZrndrate65) {
        zrndrate65 = pZrndrate65;
    }

    private Double zrndrate66;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE66)
    public Double getZrndrate66() {
        return zrndrate66;
    }

    public void setZrndrate66(Double pZrndrate66) {
        zrndrate66 = pZrndrate66;
    }

    private Double zrndrate67;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE67)
    public Double getZrndrate67() {
        return zrndrate67;
    }

    public void setZrndrate67(Double pZrndrate67) {
        zrndrate67 = pZrndrate67;
    }

    private Double zrndrate68;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE68)
    public Double getZrndrate68() {
        return zrndrate68;
    }

    public void setZrndrate68(Double pZrndrate68) {
        zrndrate68 = pZrndrate68;
    }

    private Double zrndrate69;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE69)
    public Double getZrndrate69() {
        return zrndrate69;
    }

    public void setZrndrate69(Double pZrndrate69) {
        zrndrate69 = pZrndrate69;
    }

    private Double zrndrate70;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE70)
    public Double getZrndrate70() {
        return zrndrate70;
    }

    public void setZrndrate70(Double pZrndrate70) {
        zrndrate70 = pZrndrate70;
    }

    private Double zrndrate71;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE71)
    public Double getZrndrate71() {
        return zrndrate71;
    }

    public void setZrndrate71(Double pZrndrate71) {
        zrndrate71 = pZrndrate71;
    }

    private Double zrndrate72;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE72)
    public Double getZrndrate72() {
        return zrndrate72;
    }

    public void setZrndrate72(Double pZrndrate72) {
        zrndrate72 = pZrndrate72;
    }

    private Double zrndrate73;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE73)
    public Double getZrndrate73() {
        return zrndrate73;
    }

    public void setZrndrate73(Double pZrndrate73) {
        zrndrate73 = pZrndrate73;
    }

    private Double zrndrate74;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE74)
    public Double getZrndrate74() {
        return zrndrate74;
    }

    public void setZrndrate74(Double pZrndrate74) {
        zrndrate74 = pZrndrate74;
    }

    private Double zrndrate75;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE75)
    public Double getZrndrate75() {
        return zrndrate75;
    }

    public void setZrndrate75(Double pZrndrate75) {
        zrndrate75 = pZrndrate75;
    }

    private Double zrndrate76;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE76)
    public Double getZrndrate76() {
        return zrndrate76;
    }

    public void setZrndrate76(Double pZrndrate76) {
        zrndrate76 = pZrndrate76;
    }

    private Double zrndrate77;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE77)
    public Double getZrndrate77() {
        return zrndrate77;
    }

    public void setZrndrate77(Double pZrndrate77) {
        zrndrate77 = pZrndrate77;
    }

    private Double zrndrate78;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE78)
    public Double getZrndrate78() {
        return zrndrate78;
    }

    public void setZrndrate78(Double pZrndrate78) {
        zrndrate78 = pZrndrate78;
    }

    private Double zrndrate79;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE79)
    public Double getZrndrate79() {
        return zrndrate79;
    }

    public void setZrndrate79(Double pZrndrate79) {
        zrndrate79 = pZrndrate79;
    }

    private Double zrndrate80;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE80)
    public Double getZrndrate80() {
        return zrndrate80;
    }

    public void setZrndrate80(Double pZrndrate80) {
        zrndrate80 = pZrndrate80;
    }

    private Double zrndrate81;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE81)
    public Double getZrndrate81() {
        return zrndrate81;
    }

    public void setZrndrate81(Double pZrndrate81) {
        zrndrate81 = pZrndrate81;
    }

    private Double zrndrate82;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE82)
    public Double getZrndrate82() {
        return zrndrate82;
    }

    public void setZrndrate82(Double pZrndrate82) {
        zrndrate82 = pZrndrate82;
    }

    private Double zrndrate83;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE83)
    public Double getZrndrate83() {
        return zrndrate83;
    }

    public void setZrndrate83(Double pZrndrate83) {
        zrndrate83 = pZrndrate83;
    }

    private Double zrndrate84;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE84)
    public Double getZrndrate84() {
        return zrndrate84;
    }

    public void setZrndrate84(Double pZrndrate84) {
        zrndrate84 = pZrndrate84;
    }

    private Double zrndrate85;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE85)
    public Double getZrndrate85() {
        return zrndrate85;
    }

    public void setZrndrate85(Double pZrndrate85) {
        zrndrate85 = pZrndrate85;
    }

    private Double zrndrate86;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE86)
    public Double getZrndrate86() {
        return zrndrate86;
    }

    public void setZrndrate86(Double pZrndrate86) {
        zrndrate86 = pZrndrate86;
    }

    private Double zrndrate87;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE87)
    public Double getZrndrate87() {
        return zrndrate87;
    }

    public void setZrndrate87(Double pZrndrate87) {
        zrndrate87 = pZrndrate87;
    }

    private Double zrndrate88;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE88)
    public Double getZrndrate88() {
        return zrndrate88;
    }

    public void setZrndrate88(Double pZrndrate88) {
        zrndrate88 = pZrndrate88;
    }

    private Double zrndrate89;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE89)
    public Double getZrndrate89() {
        return zrndrate89;
    }

    public void setZrndrate89(Double pZrndrate89) {
        zrndrate89 = pZrndrate89;
    }

    private Double zrndrate90;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE90)
    public Double getZrndrate90() {
        return zrndrate90;
    }

    public void setZrndrate90(Double pZrndrate90) {
        zrndrate90 = pZrndrate90;
    }

    private Double zrndrate91;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE91)
    public Double getZrndrate91() {
        return zrndrate91;
    }

    public void setZrndrate91(Double pZrndrate91) {
        zrndrate91 = pZrndrate91;
    }

    private Double zrndrate92;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE92)
    public Double getZrndrate92() {
        return zrndrate92;
    }

    public void setZrndrate92(Double pZrndrate92) {
        zrndrate92 = pZrndrate92;
    }

    private Double zrndrate93;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE93)
    public Double getZrndrate93() {
        return zrndrate93;
    }

    public void setZrndrate93(Double pZrndrate93) {
        zrndrate93 = pZrndrate93;
    }

    private Double zrndrate94;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE94)
    public Double getZrndrate94() {
        return zrndrate94;
    }

    public void setZrndrate94(Double pZrndrate94) {
        zrndrate94 = pZrndrate94;
    }

    private Double zrndrate95;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE95)
    public Double getZrndrate95() {
        return zrndrate95;
    }

    public void setZrndrate95(Double pZrndrate95) {
        zrndrate95 = pZrndrate95;
    }

    private Double zrndrate96;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE96)
    public Double getZrndrate96() {
        return zrndrate96;
    }

    public void setZrndrate96(Double pZrndrate96) {
        zrndrate96 = pZrndrate96;
    }

    private Double zrndrate97;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE97)
    public Double getZrndrate97() {
        return zrndrate97;
    }

    public void setZrndrate97(Double pZrndrate97) {
        zrndrate97 = pZrndrate97;
    }

    private Double zrndrate98;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE98)
    public Double getZrndrate98() {
        return zrndrate98;
    }

    public void setZrndrate98(Double pZrndrate98) {
        zrndrate98 = pZrndrate98;
    }

    private Double zrndrate99;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDRATE99)
    public Double getZrndrate99() {
        return zrndrate99;
    }

    public void setZrndrate99(Double pZrndrate99) {
        zrndrate99 = pZrndrate99;
    }

    private Double zrndyouvrate00;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE00)
    public Double getZrndyouvrate00() {
        return zrndyouvrate00;
    }

    public void setZrndyouvrate00(Double pZrndyouvrate00) {
        zrndyouvrate00 = pZrndyouvrate00;
    }

    private Double zrndyouvrate01;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE01)
    public Double getZrndyouvrate01() {
        return zrndyouvrate01;
    }

    public void setZrndyouvrate01(Double pZrndyouvrate01) {
        zrndyouvrate01 = pZrndyouvrate01;
    }

    private Double zrndyouvrate02;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE02)
    public Double getZrndyouvrate02() {
        return zrndyouvrate02;
    }

    public void setZrndyouvrate02(Double pZrndyouvrate02) {
        zrndyouvrate02 = pZrndyouvrate02;
    }

    private Double zrndyouvrate03;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE03)
    public Double getZrndyouvrate03() {
        return zrndyouvrate03;
    }

    public void setZrndyouvrate03(Double pZrndyouvrate03) {
        zrndyouvrate03 = pZrndyouvrate03;
    }

    private Double zrndyouvrate04;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE04)
    public Double getZrndyouvrate04() {
        return zrndyouvrate04;
    }

    public void setZrndyouvrate04(Double pZrndyouvrate04) {
        zrndyouvrate04 = pZrndyouvrate04;
    }

    private Double zrndyouvrate05;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE05)
    public Double getZrndyouvrate05() {
        return zrndyouvrate05;
    }

    public void setZrndyouvrate05(Double pZrndyouvrate05) {
        zrndyouvrate05 = pZrndyouvrate05;
    }

    private Double zrndyouvrate06;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE06)
    public Double getZrndyouvrate06() {
        return zrndyouvrate06;
    }

    public void setZrndyouvrate06(Double pZrndyouvrate06) {
        zrndyouvrate06 = pZrndyouvrate06;
    }

    private Double zrndyouvrate07;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE07)
    public Double getZrndyouvrate07() {
        return zrndyouvrate07;
    }

    public void setZrndyouvrate07(Double pZrndyouvrate07) {
        zrndyouvrate07 = pZrndyouvrate07;
    }

    private Double zrndyouvrate08;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE08)
    public Double getZrndyouvrate08() {
        return zrndyouvrate08;
    }

    public void setZrndyouvrate08(Double pZrndyouvrate08) {
        zrndyouvrate08 = pZrndyouvrate08;
    }

    private Double zrndyouvrate09;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE09)
    public Double getZrndyouvrate09() {
        return zrndyouvrate09;
    }

    public void setZrndyouvrate09(Double pZrndyouvrate09) {
        zrndyouvrate09 = pZrndyouvrate09;
    }

    private Double zrndyouvrate10;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE10)
    public Double getZrndyouvrate10() {
        return zrndyouvrate10;
    }

    public void setZrndyouvrate10(Double pZrndyouvrate10) {
        zrndyouvrate10 = pZrndyouvrate10;
    }

    private Double zrndyouvrate11;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE11)
    public Double getZrndyouvrate11() {
        return zrndyouvrate11;
    }

    public void setZrndyouvrate11(Double pZrndyouvrate11) {
        zrndyouvrate11 = pZrndyouvrate11;
    }

    private Double zrndyouvrate12;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE12)
    public Double getZrndyouvrate12() {
        return zrndyouvrate12;
    }

    public void setZrndyouvrate12(Double pZrndyouvrate12) {
        zrndyouvrate12 = pZrndyouvrate12;
    }

    private Double zrndyouvrate13;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE13)
    public Double getZrndyouvrate13() {
        return zrndyouvrate13;
    }

    public void setZrndyouvrate13(Double pZrndyouvrate13) {
        zrndyouvrate13 = pZrndyouvrate13;
    }

    private Double zrndyouvrate14;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE14)
    public Double getZrndyouvrate14() {
        return zrndyouvrate14;
    }

    public void setZrndyouvrate14(Double pZrndyouvrate14) {
        zrndyouvrate14 = pZrndyouvrate14;
    }

    private Double zrndyouvrate15;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE15)
    public Double getZrndyouvrate15() {
        return zrndyouvrate15;
    }

    public void setZrndyouvrate15(Double pZrndyouvrate15) {
        zrndyouvrate15 = pZrndyouvrate15;
    }

    private Double zrndyouvrate16;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE16)
    public Double getZrndyouvrate16() {
        return zrndyouvrate16;
    }

    public void setZrndyouvrate16(Double pZrndyouvrate16) {
        zrndyouvrate16 = pZrndyouvrate16;
    }

    private Double zrndyouvrate17;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE17)
    public Double getZrndyouvrate17() {
        return zrndyouvrate17;
    }

    public void setZrndyouvrate17(Double pZrndyouvrate17) {
        zrndyouvrate17 = pZrndyouvrate17;
    }

    private Double zrndyouvrate18;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE18)
    public Double getZrndyouvrate18() {
        return zrndyouvrate18;
    }

    public void setZrndyouvrate18(Double pZrndyouvrate18) {
        zrndyouvrate18 = pZrndyouvrate18;
    }

    private Double zrndyouvrate19;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE19)
    public Double getZrndyouvrate19() {
        return zrndyouvrate19;
    }

    public void setZrndyouvrate19(Double pZrndyouvrate19) {
        zrndyouvrate19 = pZrndyouvrate19;
    }

    private Double zrndyouvrate20;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE20)
    public Double getZrndyouvrate20() {
        return zrndyouvrate20;
    }

    public void setZrndyouvrate20(Double pZrndyouvrate20) {
        zrndyouvrate20 = pZrndyouvrate20;
    }

    private Double zrndyouvrate21;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE21)
    public Double getZrndyouvrate21() {
        return zrndyouvrate21;
    }

    public void setZrndyouvrate21(Double pZrndyouvrate21) {
        zrndyouvrate21 = pZrndyouvrate21;
    }

    private Double zrndyouvrate22;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE22)
    public Double getZrndyouvrate22() {
        return zrndyouvrate22;
    }

    public void setZrndyouvrate22(Double pZrndyouvrate22) {
        zrndyouvrate22 = pZrndyouvrate22;
    }

    private Double zrndyouvrate23;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE23)
    public Double getZrndyouvrate23() {
        return zrndyouvrate23;
    }

    public void setZrndyouvrate23(Double pZrndyouvrate23) {
        zrndyouvrate23 = pZrndyouvrate23;
    }

    private Double zrndyouvrate24;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE24)
    public Double getZrndyouvrate24() {
        return zrndyouvrate24;
    }

    public void setZrndyouvrate24(Double pZrndyouvrate24) {
        zrndyouvrate24 = pZrndyouvrate24;
    }

    private Double zrndyouvrate25;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE25)
    public Double getZrndyouvrate25() {
        return zrndyouvrate25;
    }

    public void setZrndyouvrate25(Double pZrndyouvrate25) {
        zrndyouvrate25 = pZrndyouvrate25;
    }

    private Double zrndyouvrate26;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE26)
    public Double getZrndyouvrate26() {
        return zrndyouvrate26;
    }

    public void setZrndyouvrate26(Double pZrndyouvrate26) {
        zrndyouvrate26 = pZrndyouvrate26;
    }

    private Double zrndyouvrate27;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE27)
    public Double getZrndyouvrate27() {
        return zrndyouvrate27;
    }

    public void setZrndyouvrate27(Double pZrndyouvrate27) {
        zrndyouvrate27 = pZrndyouvrate27;
    }

    private Double zrndyouvrate28;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE28)
    public Double getZrndyouvrate28() {
        return zrndyouvrate28;
    }

    public void setZrndyouvrate28(Double pZrndyouvrate28) {
        zrndyouvrate28 = pZrndyouvrate28;
    }

    private Double zrndyouvrate29;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE29)
    public Double getZrndyouvrate29() {
        return zrndyouvrate29;
    }

    public void setZrndyouvrate29(Double pZrndyouvrate29) {
        zrndyouvrate29 = pZrndyouvrate29;
    }

    private Double zrndyouvrate30;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE30)
    public Double getZrndyouvrate30() {
        return zrndyouvrate30;
    }

    public void setZrndyouvrate30(Double pZrndyouvrate30) {
        zrndyouvrate30 = pZrndyouvrate30;
    }

    private Double zrndyouvrate31;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE31)
    public Double getZrndyouvrate31() {
        return zrndyouvrate31;
    }

    public void setZrndyouvrate31(Double pZrndyouvrate31) {
        zrndyouvrate31 = pZrndyouvrate31;
    }

    private Double zrndyouvrate32;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE32)
    public Double getZrndyouvrate32() {
        return zrndyouvrate32;
    }

    public void setZrndyouvrate32(Double pZrndyouvrate32) {
        zrndyouvrate32 = pZrndyouvrate32;
    }

    private Double zrndyouvrate33;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE33)
    public Double getZrndyouvrate33() {
        return zrndyouvrate33;
    }

    public void setZrndyouvrate33(Double pZrndyouvrate33) {
        zrndyouvrate33 = pZrndyouvrate33;
    }

    private Double zrndyouvrate34;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE34)
    public Double getZrndyouvrate34() {
        return zrndyouvrate34;
    }

    public void setZrndyouvrate34(Double pZrndyouvrate34) {
        zrndyouvrate34 = pZrndyouvrate34;
    }

    private Double zrndyouvrate35;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE35)
    public Double getZrndyouvrate35() {
        return zrndyouvrate35;
    }

    public void setZrndyouvrate35(Double pZrndyouvrate35) {
        zrndyouvrate35 = pZrndyouvrate35;
    }

    private Double zrndyouvrate36;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE36)
    public Double getZrndyouvrate36() {
        return zrndyouvrate36;
    }

    public void setZrndyouvrate36(Double pZrndyouvrate36) {
        zrndyouvrate36 = pZrndyouvrate36;
    }

    private Double zrndyouvrate37;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE37)
    public Double getZrndyouvrate37() {
        return zrndyouvrate37;
    }

    public void setZrndyouvrate37(Double pZrndyouvrate37) {
        zrndyouvrate37 = pZrndyouvrate37;
    }

    private Double zrndyouvrate38;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE38)
    public Double getZrndyouvrate38() {
        return zrndyouvrate38;
    }

    public void setZrndyouvrate38(Double pZrndyouvrate38) {
        zrndyouvrate38 = pZrndyouvrate38;
    }

    private Double zrndyouvrate39;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE39)
    public Double getZrndyouvrate39() {
        return zrndyouvrate39;
    }

    public void setZrndyouvrate39(Double pZrndyouvrate39) {
        zrndyouvrate39 = pZrndyouvrate39;
    }

    private Double zrndyouvrate40;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE40)
    public Double getZrndyouvrate40() {
        return zrndyouvrate40;
    }

    public void setZrndyouvrate40(Double pZrndyouvrate40) {
        zrndyouvrate40 = pZrndyouvrate40;
    }

    private Double zrndyouvrate41;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE41)
    public Double getZrndyouvrate41() {
        return zrndyouvrate41;
    }

    public void setZrndyouvrate41(Double pZrndyouvrate41) {
        zrndyouvrate41 = pZrndyouvrate41;
    }

    private Double zrndyouvrate42;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE42)
    public Double getZrndyouvrate42() {
        return zrndyouvrate42;
    }

    public void setZrndyouvrate42(Double pZrndyouvrate42) {
        zrndyouvrate42 = pZrndyouvrate42;
    }

    private Double zrndyouvrate43;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE43)
    public Double getZrndyouvrate43() {
        return zrndyouvrate43;
    }

    public void setZrndyouvrate43(Double pZrndyouvrate43) {
        zrndyouvrate43 = pZrndyouvrate43;
    }

    private Double zrndyouvrate44;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE44)
    public Double getZrndyouvrate44() {
        return zrndyouvrate44;
    }

    public void setZrndyouvrate44(Double pZrndyouvrate44) {
        zrndyouvrate44 = pZrndyouvrate44;
    }

    private Double zrndyouvrate45;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE45)
    public Double getZrndyouvrate45() {
        return zrndyouvrate45;
    }

    public void setZrndyouvrate45(Double pZrndyouvrate45) {
        zrndyouvrate45 = pZrndyouvrate45;
    }

    private Double zrndyouvrate46;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE46)
    public Double getZrndyouvrate46() {
        return zrndyouvrate46;
    }

    public void setZrndyouvrate46(Double pZrndyouvrate46) {
        zrndyouvrate46 = pZrndyouvrate46;
    }

    private Double zrndyouvrate47;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE47)
    public Double getZrndyouvrate47() {
        return zrndyouvrate47;
    }

    public void setZrndyouvrate47(Double pZrndyouvrate47) {
        zrndyouvrate47 = pZrndyouvrate47;
    }

    private Double zrndyouvrate48;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE48)
    public Double getZrndyouvrate48() {
        return zrndyouvrate48;
    }

    public void setZrndyouvrate48(Double pZrndyouvrate48) {
        zrndyouvrate48 = pZrndyouvrate48;
    }

    private Double zrndyouvrate49;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE49)
    public Double getZrndyouvrate49() {
        return zrndyouvrate49;
    }

    public void setZrndyouvrate49(Double pZrndyouvrate49) {
        zrndyouvrate49 = pZrndyouvrate49;
    }

    private Double zrndyouvrate50;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE50)
    public Double getZrndyouvrate50() {
        return zrndyouvrate50;
    }

    public void setZrndyouvrate50(Double pZrndyouvrate50) {
        zrndyouvrate50 = pZrndyouvrate50;
    }

    private Double zrndyouvrate51;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE51)
    public Double getZrndyouvrate51() {
        return zrndyouvrate51;
    }

    public void setZrndyouvrate51(Double pZrndyouvrate51) {
        zrndyouvrate51 = pZrndyouvrate51;
    }

    private Double zrndyouvrate52;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE52)
    public Double getZrndyouvrate52() {
        return zrndyouvrate52;
    }

    public void setZrndyouvrate52(Double pZrndyouvrate52) {
        zrndyouvrate52 = pZrndyouvrate52;
    }

    private Double zrndyouvrate53;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE53)
    public Double getZrndyouvrate53() {
        return zrndyouvrate53;
    }

    public void setZrndyouvrate53(Double pZrndyouvrate53) {
        zrndyouvrate53 = pZrndyouvrate53;
    }

    private Double zrndyouvrate54;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE54)
    public Double getZrndyouvrate54() {
        return zrndyouvrate54;
    }

    public void setZrndyouvrate54(Double pZrndyouvrate54) {
        zrndyouvrate54 = pZrndyouvrate54;
    }

    private Double zrndyouvrate55;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE55)
    public Double getZrndyouvrate55() {
        return zrndyouvrate55;
    }

    public void setZrndyouvrate55(Double pZrndyouvrate55) {
        zrndyouvrate55 = pZrndyouvrate55;
    }

    private Double zrndyouvrate56;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE56)
    public Double getZrndyouvrate56() {
        return zrndyouvrate56;
    }

    public void setZrndyouvrate56(Double pZrndyouvrate56) {
        zrndyouvrate56 = pZrndyouvrate56;
    }

    private Double zrndyouvrate57;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE57)
    public Double getZrndyouvrate57() {
        return zrndyouvrate57;
    }

    public void setZrndyouvrate57(Double pZrndyouvrate57) {
        zrndyouvrate57 = pZrndyouvrate57;
    }

    private Double zrndyouvrate58;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE58)
    public Double getZrndyouvrate58() {
        return zrndyouvrate58;
    }

    public void setZrndyouvrate58(Double pZrndyouvrate58) {
        zrndyouvrate58 = pZrndyouvrate58;
    }

    private Double zrndyouvrate59;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE59)
    public Double getZrndyouvrate59() {
        return zrndyouvrate59;
    }

    public void setZrndyouvrate59(Double pZrndyouvrate59) {
        zrndyouvrate59 = pZrndyouvrate59;
    }

    private Double zrndyouvrate60;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE60)
    public Double getZrndyouvrate60() {
        return zrndyouvrate60;
    }

    public void setZrndyouvrate60(Double pZrndyouvrate60) {
        zrndyouvrate60 = pZrndyouvrate60;
    }

    private Double zrndyouvrate61;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE61)
    public Double getZrndyouvrate61() {
        return zrndyouvrate61;
    }

    public void setZrndyouvrate61(Double pZrndyouvrate61) {
        zrndyouvrate61 = pZrndyouvrate61;
    }

    private Double zrndyouvrate62;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE62)
    public Double getZrndyouvrate62() {
        return zrndyouvrate62;
    }

    public void setZrndyouvrate62(Double pZrndyouvrate62) {
        zrndyouvrate62 = pZrndyouvrate62;
    }

    private Double zrndyouvrate63;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE63)
    public Double getZrndyouvrate63() {
        return zrndyouvrate63;
    }

    public void setZrndyouvrate63(Double pZrndyouvrate63) {
        zrndyouvrate63 = pZrndyouvrate63;
    }

    private Double zrndyouvrate64;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE64)
    public Double getZrndyouvrate64() {
        return zrndyouvrate64;
    }

    public void setZrndyouvrate64(Double pZrndyouvrate64) {
        zrndyouvrate64 = pZrndyouvrate64;
    }

    private Double zrndyouvrate65;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE65)
    public Double getZrndyouvrate65() {
        return zrndyouvrate65;
    }

    public void setZrndyouvrate65(Double pZrndyouvrate65) {
        zrndyouvrate65 = pZrndyouvrate65;
    }

    private Double zrndyouvrate66;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE66)
    public Double getZrndyouvrate66() {
        return zrndyouvrate66;
    }

    public void setZrndyouvrate66(Double pZrndyouvrate66) {
        zrndyouvrate66 = pZrndyouvrate66;
    }

    private Double zrndyouvrate67;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE67)
    public Double getZrndyouvrate67() {
        return zrndyouvrate67;
    }

    public void setZrndyouvrate67(Double pZrndyouvrate67) {
        zrndyouvrate67 = pZrndyouvrate67;
    }

    private Double zrndyouvrate68;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE68)
    public Double getZrndyouvrate68() {
        return zrndyouvrate68;
    }

    public void setZrndyouvrate68(Double pZrndyouvrate68) {
        zrndyouvrate68 = pZrndyouvrate68;
    }

    private Double zrndyouvrate69;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE69)
    public Double getZrndyouvrate69() {
        return zrndyouvrate69;
    }

    public void setZrndyouvrate69(Double pZrndyouvrate69) {
        zrndyouvrate69 = pZrndyouvrate69;
    }

    private Double zrndyouvrate70;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE70)
    public Double getZrndyouvrate70() {
        return zrndyouvrate70;
    }

    public void setZrndyouvrate70(Double pZrndyouvrate70) {
        zrndyouvrate70 = pZrndyouvrate70;
    }

    private Double zrndyouvrate71;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE71)
    public Double getZrndyouvrate71() {
        return zrndyouvrate71;
    }

    public void setZrndyouvrate71(Double pZrndyouvrate71) {
        zrndyouvrate71 = pZrndyouvrate71;
    }

    private Double zrndyouvrate72;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE72)
    public Double getZrndyouvrate72() {
        return zrndyouvrate72;
    }

    public void setZrndyouvrate72(Double pZrndyouvrate72) {
        zrndyouvrate72 = pZrndyouvrate72;
    }

    private Double zrndyouvrate73;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE73)
    public Double getZrndyouvrate73() {
        return zrndyouvrate73;
    }

    public void setZrndyouvrate73(Double pZrndyouvrate73) {
        zrndyouvrate73 = pZrndyouvrate73;
    }

    private Double zrndyouvrate74;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE74)
    public Double getZrndyouvrate74() {
        return zrndyouvrate74;
    }

    public void setZrndyouvrate74(Double pZrndyouvrate74) {
        zrndyouvrate74 = pZrndyouvrate74;
    }

    private Double zrndyouvrate75;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE75)
    public Double getZrndyouvrate75() {
        return zrndyouvrate75;
    }

    public void setZrndyouvrate75(Double pZrndyouvrate75) {
        zrndyouvrate75 = pZrndyouvrate75;
    }

    private Double zrndyouvrate76;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE76)
    public Double getZrndyouvrate76() {
        return zrndyouvrate76;
    }

    public void setZrndyouvrate76(Double pZrndyouvrate76) {
        zrndyouvrate76 = pZrndyouvrate76;
    }

    private Double zrndyouvrate77;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE77)
    public Double getZrndyouvrate77() {
        return zrndyouvrate77;
    }

    public void setZrndyouvrate77(Double pZrndyouvrate77) {
        zrndyouvrate77 = pZrndyouvrate77;
    }

    private Double zrndyouvrate78;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE78)
    public Double getZrndyouvrate78() {
        return zrndyouvrate78;
    }

    public void setZrndyouvrate78(Double pZrndyouvrate78) {
        zrndyouvrate78 = pZrndyouvrate78;
    }

    private Double zrndyouvrate79;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE79)
    public Double getZrndyouvrate79() {
        return zrndyouvrate79;
    }

    public void setZrndyouvrate79(Double pZrndyouvrate79) {
        zrndyouvrate79 = pZrndyouvrate79;
    }

    private Double zrndyouvrate80;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE80)
    public Double getZrndyouvrate80() {
        return zrndyouvrate80;
    }

    public void setZrndyouvrate80(Double pZrndyouvrate80) {
        zrndyouvrate80 = pZrndyouvrate80;
    }

    private Double zrndyouvrate81;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE81)
    public Double getZrndyouvrate81() {
        return zrndyouvrate81;
    }

    public void setZrndyouvrate81(Double pZrndyouvrate81) {
        zrndyouvrate81 = pZrndyouvrate81;
    }

    private Double zrndyouvrate82;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE82)
    public Double getZrndyouvrate82() {
        return zrndyouvrate82;
    }

    public void setZrndyouvrate82(Double pZrndyouvrate82) {
        zrndyouvrate82 = pZrndyouvrate82;
    }

    private Double zrndyouvrate83;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE83)
    public Double getZrndyouvrate83() {
        return zrndyouvrate83;
    }

    public void setZrndyouvrate83(Double pZrndyouvrate83) {
        zrndyouvrate83 = pZrndyouvrate83;
    }

    private Double zrndyouvrate84;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE84)
    public Double getZrndyouvrate84() {
        return zrndyouvrate84;
    }

    public void setZrndyouvrate84(Double pZrndyouvrate84) {
        zrndyouvrate84 = pZrndyouvrate84;
    }

    private Double zrndyouvrate85;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE85)
    public Double getZrndyouvrate85() {
        return zrndyouvrate85;
    }

    public void setZrndyouvrate85(Double pZrndyouvrate85) {
        zrndyouvrate85 = pZrndyouvrate85;
    }

    private Double zrndyouvrate86;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE86)
    public Double getZrndyouvrate86() {
        return zrndyouvrate86;
    }

    public void setZrndyouvrate86(Double pZrndyouvrate86) {
        zrndyouvrate86 = pZrndyouvrate86;
    }

    private Double zrndyouvrate87;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE87)
    public Double getZrndyouvrate87() {
        return zrndyouvrate87;
    }

    public void setZrndyouvrate87(Double pZrndyouvrate87) {
        zrndyouvrate87 = pZrndyouvrate87;
    }

    private Double zrndyouvrate88;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE88)
    public Double getZrndyouvrate88() {
        return zrndyouvrate88;
    }

    public void setZrndyouvrate88(Double pZrndyouvrate88) {
        zrndyouvrate88 = pZrndyouvrate88;
    }

    private Double zrndyouvrate89;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE89)
    public Double getZrndyouvrate89() {
        return zrndyouvrate89;
    }

    public void setZrndyouvrate89(Double pZrndyouvrate89) {
        zrndyouvrate89 = pZrndyouvrate89;
    }

    private Double zrndyouvrate90;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE90)
    public Double getZrndyouvrate90() {
        return zrndyouvrate90;
    }

    public void setZrndyouvrate90(Double pZrndyouvrate90) {
        zrndyouvrate90 = pZrndyouvrate90;
    }

    private Double zrndyouvrate91;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE91)
    public Double getZrndyouvrate91() {
        return zrndyouvrate91;
    }

    public void setZrndyouvrate91(Double pZrndyouvrate91) {
        zrndyouvrate91 = pZrndyouvrate91;
    }

    private Double zrndyouvrate92;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE92)
    public Double getZrndyouvrate92() {
        return zrndyouvrate92;
    }

    public void setZrndyouvrate92(Double pZrndyouvrate92) {
        zrndyouvrate92 = pZrndyouvrate92;
    }

    private Double zrndyouvrate93;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE93)
    public Double getZrndyouvrate93() {
        return zrndyouvrate93;
    }

    public void setZrndyouvrate93(Double pZrndyouvrate93) {
        zrndyouvrate93 = pZrndyouvrate93;
    }

    private Double zrndyouvrate94;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE94)
    public Double getZrndyouvrate94() {
        return zrndyouvrate94;
    }

    public void setZrndyouvrate94(Double pZrndyouvrate94) {
        zrndyouvrate94 = pZrndyouvrate94;
    }

    private Double zrndyouvrate95;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE95)
    public Double getZrndyouvrate95() {
        return zrndyouvrate95;
    }

    public void setZrndyouvrate95(Double pZrndyouvrate95) {
        zrndyouvrate95 = pZrndyouvrate95;
    }

    private Double zrndyouvrate96;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE96)
    public Double getZrndyouvrate96() {
        return zrndyouvrate96;
    }

    public void setZrndyouvrate96(Double pZrndyouvrate96) {
        zrndyouvrate96 = pZrndyouvrate96;
    }

    private Double zrndyouvrate97;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE97)
    public Double getZrndyouvrate97() {
        return zrndyouvrate97;
    }

    public void setZrndyouvrate97(Double pZrndyouvrate97) {
        zrndyouvrate97 = pZrndyouvrate97;
    }

    private Double zrndyouvrate98;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE98)
    public Double getZrndyouvrate98() {
        return zrndyouvrate98;
    }

    public void setZrndyouvrate98(Double pZrndyouvrate98) {
        zrndyouvrate98 = pZrndyouvrate98;
    }

    private Double zrndyouvrate99;

    @Column(name=GenZT_RisaHitSyouhnyouRated2Rn.ZRNDYOUVRATE99)
    public Double getZrndyouvrate99() {
        return zrndyouvrate99;
    }

    public void setZrndyouvrate99(Double pZrndyouvrate99) {
        zrndyouvrate99 = pZrndyouvrate99;
    }
}