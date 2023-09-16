package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_NennkinRatedRn;
import yuyu.def.db.id.PKZT_NennkinRatedRn;
import yuyu.def.db.meta.GenQZT_NennkinRatedRn;
import yuyu.def.db.meta.QZT_NennkinRatedRn;

/**
 * 年金開始後Ｄレートテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_NennkinRatedRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NennkinRatedRn}</td><td colspan="3">年金開始後Ｄレートテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnnenkinkbn zrnnenkinkbn}</td><td>（連携用）年金区分</td><td align="center">{@link PKZT_NennkinRatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsyu zrnnenkinsyu}</td><td>（連携用）年金種類記号</td><td align="center">{@link PKZT_NennkinRatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkigousedaikbn zrnnenkinkigousedaikbn}</td><td>（連携用）年金記号世代区分</td><td align="center">{@link PKZT_NennkinRatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">{@link PKZT_NennkinRatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigoyoteiriritukbn zrnnkkaisigoyoteiriritukbn}</td><td>（連携用）年金開始後予定利率区分</td><td align="center">{@link PKZT_NennkinRatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinjimutesuuryoukbn zrnnenkinjimutesuuryoukbn}</td><td>（連携用）年金事務手数料区分</td><td align="center">{@link PKZT_NennkinRatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndnendo zrndnendo}</td><td>（連携用）Ｄ年度</td><td align="center">{@link PKZT_NennkinRatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaiteikakuteikbn zrnnaiteikakuteikbn}</td><td>（連携用）Ｄレート内定確定区分</td><td align="center">{@link PKZT_NennkinRatedRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate00 zrnnenkinkaisigodrate00}</td><td>（連携用）年金開始後Ｄレート００</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate01 zrnnenkinkaisigodrate01}</td><td>（連携用）年金開始後Ｄレート０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate02 zrnnenkinkaisigodrate02}</td><td>（連携用）年金開始後Ｄレート０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate03 zrnnenkinkaisigodrate03}</td><td>（連携用）年金開始後Ｄレート０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate04 zrnnenkinkaisigodrate04}</td><td>（連携用）年金開始後Ｄレート０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate05 zrnnenkinkaisigodrate05}</td><td>（連携用）年金開始後Ｄレート０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate06 zrnnenkinkaisigodrate06}</td><td>（連携用）年金開始後Ｄレート０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate07 zrnnenkinkaisigodrate07}</td><td>（連携用）年金開始後Ｄレート０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate08 zrnnenkinkaisigodrate08}</td><td>（連携用）年金開始後Ｄレート０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate09 zrnnenkinkaisigodrate09}</td><td>（連携用）年金開始後Ｄレート０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate10 zrnnenkinkaisigodrate10}</td><td>（連携用）年金開始後Ｄレート１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate11 zrnnenkinkaisigodrate11}</td><td>（連携用）年金開始後Ｄレート１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate12 zrnnenkinkaisigodrate12}</td><td>（連携用）年金開始後Ｄレート１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate13 zrnnenkinkaisigodrate13}</td><td>（連携用）年金開始後Ｄレート１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate14 zrnnenkinkaisigodrate14}</td><td>（連携用）年金開始後Ｄレート１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate15 zrnnenkinkaisigodrate15}</td><td>（連携用）年金開始後Ｄレート１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate16 zrnnenkinkaisigodrate16}</td><td>（連携用）年金開始後Ｄレート１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate17 zrnnenkinkaisigodrate17}</td><td>（連携用）年金開始後Ｄレート１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate18 zrnnenkinkaisigodrate18}</td><td>（連携用）年金開始後Ｄレート１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate19 zrnnenkinkaisigodrate19}</td><td>（連携用）年金開始後Ｄレート１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate20 zrnnenkinkaisigodrate20}</td><td>（連携用）年金開始後Ｄレート２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate21 zrnnenkinkaisigodrate21}</td><td>（連携用）年金開始後Ｄレート２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate22 zrnnenkinkaisigodrate22}</td><td>（連携用）年金開始後Ｄレート２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate23 zrnnenkinkaisigodrate23}</td><td>（連携用）年金開始後Ｄレート２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate24 zrnnenkinkaisigodrate24}</td><td>（連携用）年金開始後Ｄレート２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate25 zrnnenkinkaisigodrate25}</td><td>（連携用）年金開始後Ｄレート２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate26 zrnnenkinkaisigodrate26}</td><td>（連携用）年金開始後Ｄレート２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate27 zrnnenkinkaisigodrate27}</td><td>（連携用）年金開始後Ｄレート２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate28 zrnnenkinkaisigodrate28}</td><td>（連携用）年金開始後Ｄレート２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate29 zrnnenkinkaisigodrate29}</td><td>（連携用）年金開始後Ｄレート２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate30 zrnnenkinkaisigodrate30}</td><td>（連携用）年金開始後Ｄレート３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate31 zrnnenkinkaisigodrate31}</td><td>（連携用）年金開始後Ｄレート３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate32 zrnnenkinkaisigodrate32}</td><td>（連携用）年金開始後Ｄレート３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate33 zrnnenkinkaisigodrate33}</td><td>（連携用）年金開始後Ｄレート３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate34 zrnnenkinkaisigodrate34}</td><td>（連携用）年金開始後Ｄレート３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate35 zrnnenkinkaisigodrate35}</td><td>（連携用）年金開始後Ｄレート３５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate36 zrnnenkinkaisigodrate36}</td><td>（連携用）年金開始後Ｄレート３６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate37 zrnnenkinkaisigodrate37}</td><td>（連携用）年金開始後Ｄレート３７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate38 zrnnenkinkaisigodrate38}</td><td>（連携用）年金開始後Ｄレート３８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate39 zrnnenkinkaisigodrate39}</td><td>（連携用）年金開始後Ｄレート３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate40 zrnnenkinkaisigodrate40}</td><td>（連携用）年金開始後Ｄレート４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate41 zrnnenkinkaisigodrate41}</td><td>（連携用）年金開始後Ｄレート４１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate42 zrnnenkinkaisigodrate42}</td><td>（連携用）年金開始後Ｄレート４２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate43 zrnnenkinkaisigodrate43}</td><td>（連携用）年金開始後Ｄレート４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate44 zrnnenkinkaisigodrate44}</td><td>（連携用）年金開始後Ｄレート４４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate45 zrnnenkinkaisigodrate45}</td><td>（連携用）年金開始後Ｄレート４５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate46 zrnnenkinkaisigodrate46}</td><td>（連携用）年金開始後Ｄレート４６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate47 zrnnenkinkaisigodrate47}</td><td>（連携用）年金開始後Ｄレート４７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate48 zrnnenkinkaisigodrate48}</td><td>（連携用）年金開始後Ｄレート４８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate49 zrnnenkinkaisigodrate49}</td><td>（連携用）年金開始後Ｄレート４９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate50 zrnnenkinkaisigodrate50}</td><td>（連携用）年金開始後Ｄレート５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate51 zrnnenkinkaisigodrate51}</td><td>（連携用）年金開始後Ｄレート５１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate52 zrnnenkinkaisigodrate52}</td><td>（連携用）年金開始後Ｄレート５２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate53 zrnnenkinkaisigodrate53}</td><td>（連携用）年金開始後Ｄレート５３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate54 zrnnenkinkaisigodrate54}</td><td>（連携用）年金開始後Ｄレート５４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate55 zrnnenkinkaisigodrate55}</td><td>（連携用）年金開始後Ｄレート５５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate56 zrnnenkinkaisigodrate56}</td><td>（連携用）年金開始後Ｄレート５６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate57 zrnnenkinkaisigodrate57}</td><td>（連携用）年金開始後Ｄレート５７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate58 zrnnenkinkaisigodrate58}</td><td>（連携用）年金開始後Ｄレート５８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate59 zrnnenkinkaisigodrate59}</td><td>（連携用）年金開始後Ｄレート５９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate60 zrnnenkinkaisigodrate60}</td><td>（連携用）年金開始後Ｄレート６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate61 zrnnenkinkaisigodrate61}</td><td>（連携用）年金開始後Ｄレート６１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate62 zrnnenkinkaisigodrate62}</td><td>（連携用）年金開始後Ｄレート６２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate63 zrnnenkinkaisigodrate63}</td><td>（連携用）年金開始後Ｄレート６３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate64 zrnnenkinkaisigodrate64}</td><td>（連携用）年金開始後Ｄレート６４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate65 zrnnenkinkaisigodrate65}</td><td>（連携用）年金開始後Ｄレート６５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate66 zrnnenkinkaisigodrate66}</td><td>（連携用）年金開始後Ｄレート６６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate67 zrnnenkinkaisigodrate67}</td><td>（連携用）年金開始後Ｄレート６７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate68 zrnnenkinkaisigodrate68}</td><td>（連携用）年金開始後Ｄレート６８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate69 zrnnenkinkaisigodrate69}</td><td>（連携用）年金開始後Ｄレート６９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate70 zrnnenkinkaisigodrate70}</td><td>（連携用）年金開始後Ｄレート７０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate71 zrnnenkinkaisigodrate71}</td><td>（連携用）年金開始後Ｄレート７１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate72 zrnnenkinkaisigodrate72}</td><td>（連携用）年金開始後Ｄレート７２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate73 zrnnenkinkaisigodrate73}</td><td>（連携用）年金開始後Ｄレート７３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate74 zrnnenkinkaisigodrate74}</td><td>（連携用）年金開始後Ｄレート７４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate75 zrnnenkinkaisigodrate75}</td><td>（連携用）年金開始後Ｄレート７５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate76 zrnnenkinkaisigodrate76}</td><td>（連携用）年金開始後Ｄレート７６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate77 zrnnenkinkaisigodrate77}</td><td>（連携用）年金開始後Ｄレート７７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate78 zrnnenkinkaisigodrate78}</td><td>（連携用）年金開始後Ｄレート７８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate79 zrnnenkinkaisigodrate79}</td><td>（連携用）年金開始後Ｄレート７９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate80 zrnnenkinkaisigodrate80}</td><td>（連携用）年金開始後Ｄレート８０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate81 zrnnenkinkaisigodrate81}</td><td>（連携用）年金開始後Ｄレート８１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate82 zrnnenkinkaisigodrate82}</td><td>（連携用）年金開始後Ｄレート８２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate83 zrnnenkinkaisigodrate83}</td><td>（連携用）年金開始後Ｄレート８３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate84 zrnnenkinkaisigodrate84}</td><td>（連携用）年金開始後Ｄレート８４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate85 zrnnenkinkaisigodrate85}</td><td>（連携用）年金開始後Ｄレート８５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate86 zrnnenkinkaisigodrate86}</td><td>（連携用）年金開始後Ｄレート８６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate87 zrnnenkinkaisigodrate87}</td><td>（連携用）年金開始後Ｄレート８７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate88 zrnnenkinkaisigodrate88}</td><td>（連携用）年金開始後Ｄレート８８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate89 zrnnenkinkaisigodrate89}</td><td>（連携用）年金開始後Ｄレート８９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate90 zrnnenkinkaisigodrate90}</td><td>（連携用）年金開始後Ｄレート９０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate91 zrnnenkinkaisigodrate91}</td><td>（連携用）年金開始後Ｄレート９１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate92 zrnnenkinkaisigodrate92}</td><td>（連携用）年金開始後Ｄレート９２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate93 zrnnenkinkaisigodrate93}</td><td>（連携用）年金開始後Ｄレート９３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate94 zrnnenkinkaisigodrate94}</td><td>（連携用）年金開始後Ｄレート９４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate95 zrnnenkinkaisigodrate95}</td><td>（連携用）年金開始後Ｄレート９５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate96 zrnnenkinkaisigodrate96}</td><td>（連携用）年金開始後Ｄレート９６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate97 zrnnenkinkaisigodrate97}</td><td>（連携用）年金開始後Ｄレート９７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate98 zrnnenkinkaisigodrate98}</td><td>（連携用）年金開始後Ｄレート９８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkaisigodrate99 zrnnenkinkaisigodrate99}</td><td>（連携用）年金開始後Ｄレート９９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NennkinRatedRn
 * @see     PKZT_NennkinRatedRn
 * @see     QZT_NennkinRatedRn
 * @see     GenQZT_NennkinRatedRn
 */
@MappedSuperclass
@Table(name=GenZT_NennkinRatedRn.TABLE_NAME)
@IdClass(value=PKZT_NennkinRatedRn.class)
public abstract class GenZT_NennkinRatedRn extends AbstractExDBEntityForZDB<ZT_NennkinRatedRn, PKZT_NennkinRatedRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NennkinRatedRn";
    public static final String ZRNNENKINKBN             = "zrnnenkinkbn";
    public static final String ZRNNENKINSYU             = "zrnnenkinsyu";
    public static final String ZRNNENKINKIGOUSEDAIKBN   = "zrnnenkinkigousedaikbn";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNNKKAISIGOYOTEIRIRITUKBN = "zrnnkkaisigoyoteiriritukbn";
    public static final String ZRNNENKINJIMUTESUURYOUKBN = "zrnnenkinjimutesuuryoukbn";
    public static final String ZRNDNENDO                = "zrndnendo";
    public static final String ZRNNAITEIKAKUTEIKBN      = "zrnnaiteikakuteikbn";
    public static final String ZRNNENKINKAISIGODRATE00  = "zrnnenkinkaisigodrate00";
    public static final String ZRNNENKINKAISIGODRATE01  = "zrnnenkinkaisigodrate01";
    public static final String ZRNNENKINKAISIGODRATE02  = "zrnnenkinkaisigodrate02";
    public static final String ZRNNENKINKAISIGODRATE03  = "zrnnenkinkaisigodrate03";
    public static final String ZRNNENKINKAISIGODRATE04  = "zrnnenkinkaisigodrate04";
    public static final String ZRNNENKINKAISIGODRATE05  = "zrnnenkinkaisigodrate05";
    public static final String ZRNNENKINKAISIGODRATE06  = "zrnnenkinkaisigodrate06";
    public static final String ZRNNENKINKAISIGODRATE07  = "zrnnenkinkaisigodrate07";
    public static final String ZRNNENKINKAISIGODRATE08  = "zrnnenkinkaisigodrate08";
    public static final String ZRNNENKINKAISIGODRATE09  = "zrnnenkinkaisigodrate09";
    public static final String ZRNNENKINKAISIGODRATE10  = "zrnnenkinkaisigodrate10";
    public static final String ZRNNENKINKAISIGODRATE11  = "zrnnenkinkaisigodrate11";
    public static final String ZRNNENKINKAISIGODRATE12  = "zrnnenkinkaisigodrate12";
    public static final String ZRNNENKINKAISIGODRATE13  = "zrnnenkinkaisigodrate13";
    public static final String ZRNNENKINKAISIGODRATE14  = "zrnnenkinkaisigodrate14";
    public static final String ZRNNENKINKAISIGODRATE15  = "zrnnenkinkaisigodrate15";
    public static final String ZRNNENKINKAISIGODRATE16  = "zrnnenkinkaisigodrate16";
    public static final String ZRNNENKINKAISIGODRATE17  = "zrnnenkinkaisigodrate17";
    public static final String ZRNNENKINKAISIGODRATE18  = "zrnnenkinkaisigodrate18";
    public static final String ZRNNENKINKAISIGODRATE19  = "zrnnenkinkaisigodrate19";
    public static final String ZRNNENKINKAISIGODRATE20  = "zrnnenkinkaisigodrate20";
    public static final String ZRNNENKINKAISIGODRATE21  = "zrnnenkinkaisigodrate21";
    public static final String ZRNNENKINKAISIGODRATE22  = "zrnnenkinkaisigodrate22";
    public static final String ZRNNENKINKAISIGODRATE23  = "zrnnenkinkaisigodrate23";
    public static final String ZRNNENKINKAISIGODRATE24  = "zrnnenkinkaisigodrate24";
    public static final String ZRNNENKINKAISIGODRATE25  = "zrnnenkinkaisigodrate25";
    public static final String ZRNNENKINKAISIGODRATE26  = "zrnnenkinkaisigodrate26";
    public static final String ZRNNENKINKAISIGODRATE27  = "zrnnenkinkaisigodrate27";
    public static final String ZRNNENKINKAISIGODRATE28  = "zrnnenkinkaisigodrate28";
    public static final String ZRNNENKINKAISIGODRATE29  = "zrnnenkinkaisigodrate29";
    public static final String ZRNNENKINKAISIGODRATE30  = "zrnnenkinkaisigodrate30";
    public static final String ZRNNENKINKAISIGODRATE31  = "zrnnenkinkaisigodrate31";
    public static final String ZRNNENKINKAISIGODRATE32  = "zrnnenkinkaisigodrate32";
    public static final String ZRNNENKINKAISIGODRATE33  = "zrnnenkinkaisigodrate33";
    public static final String ZRNNENKINKAISIGODRATE34  = "zrnnenkinkaisigodrate34";
    public static final String ZRNNENKINKAISIGODRATE35  = "zrnnenkinkaisigodrate35";
    public static final String ZRNNENKINKAISIGODRATE36  = "zrnnenkinkaisigodrate36";
    public static final String ZRNNENKINKAISIGODRATE37  = "zrnnenkinkaisigodrate37";
    public static final String ZRNNENKINKAISIGODRATE38  = "zrnnenkinkaisigodrate38";
    public static final String ZRNNENKINKAISIGODRATE39  = "zrnnenkinkaisigodrate39";
    public static final String ZRNNENKINKAISIGODRATE40  = "zrnnenkinkaisigodrate40";
    public static final String ZRNNENKINKAISIGODRATE41  = "zrnnenkinkaisigodrate41";
    public static final String ZRNNENKINKAISIGODRATE42  = "zrnnenkinkaisigodrate42";
    public static final String ZRNNENKINKAISIGODRATE43  = "zrnnenkinkaisigodrate43";
    public static final String ZRNNENKINKAISIGODRATE44  = "zrnnenkinkaisigodrate44";
    public static final String ZRNNENKINKAISIGODRATE45  = "zrnnenkinkaisigodrate45";
    public static final String ZRNNENKINKAISIGODRATE46  = "zrnnenkinkaisigodrate46";
    public static final String ZRNNENKINKAISIGODRATE47  = "zrnnenkinkaisigodrate47";
    public static final String ZRNNENKINKAISIGODRATE48  = "zrnnenkinkaisigodrate48";
    public static final String ZRNNENKINKAISIGODRATE49  = "zrnnenkinkaisigodrate49";
    public static final String ZRNNENKINKAISIGODRATE50  = "zrnnenkinkaisigodrate50";
    public static final String ZRNNENKINKAISIGODRATE51  = "zrnnenkinkaisigodrate51";
    public static final String ZRNNENKINKAISIGODRATE52  = "zrnnenkinkaisigodrate52";
    public static final String ZRNNENKINKAISIGODRATE53  = "zrnnenkinkaisigodrate53";
    public static final String ZRNNENKINKAISIGODRATE54  = "zrnnenkinkaisigodrate54";
    public static final String ZRNNENKINKAISIGODRATE55  = "zrnnenkinkaisigodrate55";
    public static final String ZRNNENKINKAISIGODRATE56  = "zrnnenkinkaisigodrate56";
    public static final String ZRNNENKINKAISIGODRATE57  = "zrnnenkinkaisigodrate57";
    public static final String ZRNNENKINKAISIGODRATE58  = "zrnnenkinkaisigodrate58";
    public static final String ZRNNENKINKAISIGODRATE59  = "zrnnenkinkaisigodrate59";
    public static final String ZRNNENKINKAISIGODRATE60  = "zrnnenkinkaisigodrate60";
    public static final String ZRNNENKINKAISIGODRATE61  = "zrnnenkinkaisigodrate61";
    public static final String ZRNNENKINKAISIGODRATE62  = "zrnnenkinkaisigodrate62";
    public static final String ZRNNENKINKAISIGODRATE63  = "zrnnenkinkaisigodrate63";
    public static final String ZRNNENKINKAISIGODRATE64  = "zrnnenkinkaisigodrate64";
    public static final String ZRNNENKINKAISIGODRATE65  = "zrnnenkinkaisigodrate65";
    public static final String ZRNNENKINKAISIGODRATE66  = "zrnnenkinkaisigodrate66";
    public static final String ZRNNENKINKAISIGODRATE67  = "zrnnenkinkaisigodrate67";
    public static final String ZRNNENKINKAISIGODRATE68  = "zrnnenkinkaisigodrate68";
    public static final String ZRNNENKINKAISIGODRATE69  = "zrnnenkinkaisigodrate69";
    public static final String ZRNNENKINKAISIGODRATE70  = "zrnnenkinkaisigodrate70";
    public static final String ZRNNENKINKAISIGODRATE71  = "zrnnenkinkaisigodrate71";
    public static final String ZRNNENKINKAISIGODRATE72  = "zrnnenkinkaisigodrate72";
    public static final String ZRNNENKINKAISIGODRATE73  = "zrnnenkinkaisigodrate73";
    public static final String ZRNNENKINKAISIGODRATE74  = "zrnnenkinkaisigodrate74";
    public static final String ZRNNENKINKAISIGODRATE75  = "zrnnenkinkaisigodrate75";
    public static final String ZRNNENKINKAISIGODRATE76  = "zrnnenkinkaisigodrate76";
    public static final String ZRNNENKINKAISIGODRATE77  = "zrnnenkinkaisigodrate77";
    public static final String ZRNNENKINKAISIGODRATE78  = "zrnnenkinkaisigodrate78";
    public static final String ZRNNENKINKAISIGODRATE79  = "zrnnenkinkaisigodrate79";
    public static final String ZRNNENKINKAISIGODRATE80  = "zrnnenkinkaisigodrate80";
    public static final String ZRNNENKINKAISIGODRATE81  = "zrnnenkinkaisigodrate81";
    public static final String ZRNNENKINKAISIGODRATE82  = "zrnnenkinkaisigodrate82";
    public static final String ZRNNENKINKAISIGODRATE83  = "zrnnenkinkaisigodrate83";
    public static final String ZRNNENKINKAISIGODRATE84  = "zrnnenkinkaisigodrate84";
    public static final String ZRNNENKINKAISIGODRATE85  = "zrnnenkinkaisigodrate85";
    public static final String ZRNNENKINKAISIGODRATE86  = "zrnnenkinkaisigodrate86";
    public static final String ZRNNENKINKAISIGODRATE87  = "zrnnenkinkaisigodrate87";
    public static final String ZRNNENKINKAISIGODRATE88  = "zrnnenkinkaisigodrate88";
    public static final String ZRNNENKINKAISIGODRATE89  = "zrnnenkinkaisigodrate89";
    public static final String ZRNNENKINKAISIGODRATE90  = "zrnnenkinkaisigodrate90";
    public static final String ZRNNENKINKAISIGODRATE91  = "zrnnenkinkaisigodrate91";
    public static final String ZRNNENKINKAISIGODRATE92  = "zrnnenkinkaisigodrate92";
    public static final String ZRNNENKINKAISIGODRATE93  = "zrnnenkinkaisigodrate93";
    public static final String ZRNNENKINKAISIGODRATE94  = "zrnnenkinkaisigodrate94";
    public static final String ZRNNENKINKAISIGODRATE95  = "zrnnenkinkaisigodrate95";
    public static final String ZRNNENKINKAISIGODRATE96  = "zrnnenkinkaisigodrate96";
    public static final String ZRNNENKINKAISIGODRATE97  = "zrnnenkinkaisigodrate97";
    public static final String ZRNNENKINKAISIGODRATE98  = "zrnnenkinkaisigodrate98";
    public static final String ZRNNENKINKAISIGODRATE99  = "zrnnenkinkaisigodrate99";

    private final PKZT_NennkinRatedRn primaryKey;

    public GenZT_NennkinRatedRn() {
        primaryKey = new PKZT_NennkinRatedRn();
    }

    public GenZT_NennkinRatedRn(
        String pZrnnenkinkbn,
        String pZrnnenkinsyu,
        String pZrnnenkinkigousedaikbn,
        String pZrnnknshry,
        String pZrnnkkaisigoyoteiriritukbn,
        String pZrnnenkinjimutesuuryoukbn,
        String pZrndnendo,
        String pZrnnaiteikakuteikbn
    ) {
        primaryKey = new PKZT_NennkinRatedRn(
            pZrnnenkinkbn,
            pZrnnenkinsyu,
            pZrnnenkinkigousedaikbn,
            pZrnnknshry,
            pZrnnkkaisigoyoteiriritukbn,
            pZrnnenkinjimutesuuryoukbn,
            pZrndnendo,
            pZrnnaiteikakuteikbn
        );
    }

    @Transient
    @Override
    public PKZT_NennkinRatedRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NennkinRatedRn> getMetaClass() {
        return QZT_NennkinRatedRn.class;
    }

    @Id
    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKBN)
    public String getZrnnenkinkbn() {
        return getPrimaryKey().getZrnnenkinkbn();
    }

    public void setZrnnenkinkbn(String pZrnnenkinkbn) {
        getPrimaryKey().setZrnnenkinkbn(pZrnnenkinkbn);
    }

    @Id
    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINSYU)
    public String getZrnnenkinsyu() {
        return getPrimaryKey().getZrnnenkinsyu();
    }

    public void setZrnnenkinsyu(String pZrnnenkinsyu) {
        getPrimaryKey().setZrnnenkinsyu(pZrnnenkinsyu);
    }

    @Id
    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKIGOUSEDAIKBN)
    public String getZrnnenkinkigousedaikbn() {
        return getPrimaryKey().getZrnnenkinkigousedaikbn();
    }

    public void setZrnnenkinkigousedaikbn(String pZrnnenkinkigousedaikbn) {
        getPrimaryKey().setZrnnenkinkigousedaikbn(pZrnnenkinkigousedaikbn);
    }

    @Id
    @Column(name=GenZT_NennkinRatedRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return getPrimaryKey().getZrnnknshry();
    }

    public void setZrnnknshry(String pZrnnknshry) {
        getPrimaryKey().setZrnnknshry(pZrnnknshry);
    }

    @Id
    @Column(name=GenZT_NennkinRatedRn.ZRNNKKAISIGOYOTEIRIRITUKBN)
    public String getZrnnkkaisigoyoteiriritukbn() {
        return getPrimaryKey().getZrnnkkaisigoyoteiriritukbn();
    }

    public void setZrnnkkaisigoyoteiriritukbn(String pZrnnkkaisigoyoteiriritukbn) {
        getPrimaryKey().setZrnnkkaisigoyoteiriritukbn(pZrnnkkaisigoyoteiriritukbn);
    }

    @Id
    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINJIMUTESUURYOUKBN)
    public String getZrnnenkinjimutesuuryoukbn() {
        return getPrimaryKey().getZrnnenkinjimutesuuryoukbn();
    }

    public void setZrnnenkinjimutesuuryoukbn(String pZrnnenkinjimutesuuryoukbn) {
        getPrimaryKey().setZrnnenkinjimutesuuryoukbn(pZrnnenkinjimutesuuryoukbn);
    }

    @Id
    @Column(name=GenZT_NennkinRatedRn.ZRNDNENDO)
    public String getZrndnendo() {
        return getPrimaryKey().getZrndnendo();
    }

    public void setZrndnendo(String pZrndnendo) {
        getPrimaryKey().setZrndnendo(pZrndnendo);
    }

    @Id
    @Column(name=GenZT_NennkinRatedRn.ZRNNAITEIKAKUTEIKBN)
    public String getZrnnaiteikakuteikbn() {
        return getPrimaryKey().getZrnnaiteikakuteikbn();
    }

    public void setZrnnaiteikakuteikbn(String pZrnnaiteikakuteikbn) {
        getPrimaryKey().setZrnnaiteikakuteikbn(pZrnnaiteikakuteikbn);
    }

    private String zrnnenkinkaisigodrate00;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE00)
    public String getZrnnenkinkaisigodrate00() {
        return zrnnenkinkaisigodrate00;
    }

    public void setZrnnenkinkaisigodrate00(String pZrnnenkinkaisigodrate00) {
        zrnnenkinkaisigodrate00 = pZrnnenkinkaisigodrate00;
    }

    private String zrnnenkinkaisigodrate01;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE01)
    public String getZrnnenkinkaisigodrate01() {
        return zrnnenkinkaisigodrate01;
    }

    public void setZrnnenkinkaisigodrate01(String pZrnnenkinkaisigodrate01) {
        zrnnenkinkaisigodrate01 = pZrnnenkinkaisigodrate01;
    }

    private String zrnnenkinkaisigodrate02;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE02)
    public String getZrnnenkinkaisigodrate02() {
        return zrnnenkinkaisigodrate02;
    }

    public void setZrnnenkinkaisigodrate02(String pZrnnenkinkaisigodrate02) {
        zrnnenkinkaisigodrate02 = pZrnnenkinkaisigodrate02;
    }

    private String zrnnenkinkaisigodrate03;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE03)
    public String getZrnnenkinkaisigodrate03() {
        return zrnnenkinkaisigodrate03;
    }

    public void setZrnnenkinkaisigodrate03(String pZrnnenkinkaisigodrate03) {
        zrnnenkinkaisigodrate03 = pZrnnenkinkaisigodrate03;
    }

    private String zrnnenkinkaisigodrate04;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE04)
    public String getZrnnenkinkaisigodrate04() {
        return zrnnenkinkaisigodrate04;
    }

    public void setZrnnenkinkaisigodrate04(String pZrnnenkinkaisigodrate04) {
        zrnnenkinkaisigodrate04 = pZrnnenkinkaisigodrate04;
    }

    private String zrnnenkinkaisigodrate05;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE05)
    public String getZrnnenkinkaisigodrate05() {
        return zrnnenkinkaisigodrate05;
    }

    public void setZrnnenkinkaisigodrate05(String pZrnnenkinkaisigodrate05) {
        zrnnenkinkaisigodrate05 = pZrnnenkinkaisigodrate05;
    }

    private String zrnnenkinkaisigodrate06;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE06)
    public String getZrnnenkinkaisigodrate06() {
        return zrnnenkinkaisigodrate06;
    }

    public void setZrnnenkinkaisigodrate06(String pZrnnenkinkaisigodrate06) {
        zrnnenkinkaisigodrate06 = pZrnnenkinkaisigodrate06;
    }

    private String zrnnenkinkaisigodrate07;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE07)
    public String getZrnnenkinkaisigodrate07() {
        return zrnnenkinkaisigodrate07;
    }

    public void setZrnnenkinkaisigodrate07(String pZrnnenkinkaisigodrate07) {
        zrnnenkinkaisigodrate07 = pZrnnenkinkaisigodrate07;
    }

    private String zrnnenkinkaisigodrate08;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE08)
    public String getZrnnenkinkaisigodrate08() {
        return zrnnenkinkaisigodrate08;
    }

    public void setZrnnenkinkaisigodrate08(String pZrnnenkinkaisigodrate08) {
        zrnnenkinkaisigodrate08 = pZrnnenkinkaisigodrate08;
    }

    private String zrnnenkinkaisigodrate09;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE09)
    public String getZrnnenkinkaisigodrate09() {
        return zrnnenkinkaisigodrate09;
    }

    public void setZrnnenkinkaisigodrate09(String pZrnnenkinkaisigodrate09) {
        zrnnenkinkaisigodrate09 = pZrnnenkinkaisigodrate09;
    }

    private String zrnnenkinkaisigodrate10;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE10)
    public String getZrnnenkinkaisigodrate10() {
        return zrnnenkinkaisigodrate10;
    }

    public void setZrnnenkinkaisigodrate10(String pZrnnenkinkaisigodrate10) {
        zrnnenkinkaisigodrate10 = pZrnnenkinkaisigodrate10;
    }

    private String zrnnenkinkaisigodrate11;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE11)
    public String getZrnnenkinkaisigodrate11() {
        return zrnnenkinkaisigodrate11;
    }

    public void setZrnnenkinkaisigodrate11(String pZrnnenkinkaisigodrate11) {
        zrnnenkinkaisigodrate11 = pZrnnenkinkaisigodrate11;
    }

    private String zrnnenkinkaisigodrate12;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE12)
    public String getZrnnenkinkaisigodrate12() {
        return zrnnenkinkaisigodrate12;
    }

    public void setZrnnenkinkaisigodrate12(String pZrnnenkinkaisigodrate12) {
        zrnnenkinkaisigodrate12 = pZrnnenkinkaisigodrate12;
    }

    private String zrnnenkinkaisigodrate13;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE13)
    public String getZrnnenkinkaisigodrate13() {
        return zrnnenkinkaisigodrate13;
    }

    public void setZrnnenkinkaisigodrate13(String pZrnnenkinkaisigodrate13) {
        zrnnenkinkaisigodrate13 = pZrnnenkinkaisigodrate13;
    }

    private String zrnnenkinkaisigodrate14;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE14)
    public String getZrnnenkinkaisigodrate14() {
        return zrnnenkinkaisigodrate14;
    }

    public void setZrnnenkinkaisigodrate14(String pZrnnenkinkaisigodrate14) {
        zrnnenkinkaisigodrate14 = pZrnnenkinkaisigodrate14;
    }

    private String zrnnenkinkaisigodrate15;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE15)
    public String getZrnnenkinkaisigodrate15() {
        return zrnnenkinkaisigodrate15;
    }

    public void setZrnnenkinkaisigodrate15(String pZrnnenkinkaisigodrate15) {
        zrnnenkinkaisigodrate15 = pZrnnenkinkaisigodrate15;
    }

    private String zrnnenkinkaisigodrate16;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE16)
    public String getZrnnenkinkaisigodrate16() {
        return zrnnenkinkaisigodrate16;
    }

    public void setZrnnenkinkaisigodrate16(String pZrnnenkinkaisigodrate16) {
        zrnnenkinkaisigodrate16 = pZrnnenkinkaisigodrate16;
    }

    private String zrnnenkinkaisigodrate17;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE17)
    public String getZrnnenkinkaisigodrate17() {
        return zrnnenkinkaisigodrate17;
    }

    public void setZrnnenkinkaisigodrate17(String pZrnnenkinkaisigodrate17) {
        zrnnenkinkaisigodrate17 = pZrnnenkinkaisigodrate17;
    }

    private String zrnnenkinkaisigodrate18;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE18)
    public String getZrnnenkinkaisigodrate18() {
        return zrnnenkinkaisigodrate18;
    }

    public void setZrnnenkinkaisigodrate18(String pZrnnenkinkaisigodrate18) {
        zrnnenkinkaisigodrate18 = pZrnnenkinkaisigodrate18;
    }

    private String zrnnenkinkaisigodrate19;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE19)
    public String getZrnnenkinkaisigodrate19() {
        return zrnnenkinkaisigodrate19;
    }

    public void setZrnnenkinkaisigodrate19(String pZrnnenkinkaisigodrate19) {
        zrnnenkinkaisigodrate19 = pZrnnenkinkaisigodrate19;
    }

    private String zrnnenkinkaisigodrate20;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE20)
    public String getZrnnenkinkaisigodrate20() {
        return zrnnenkinkaisigodrate20;
    }

    public void setZrnnenkinkaisigodrate20(String pZrnnenkinkaisigodrate20) {
        zrnnenkinkaisigodrate20 = pZrnnenkinkaisigodrate20;
    }

    private String zrnnenkinkaisigodrate21;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE21)
    public String getZrnnenkinkaisigodrate21() {
        return zrnnenkinkaisigodrate21;
    }

    public void setZrnnenkinkaisigodrate21(String pZrnnenkinkaisigodrate21) {
        zrnnenkinkaisigodrate21 = pZrnnenkinkaisigodrate21;
    }

    private String zrnnenkinkaisigodrate22;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE22)
    public String getZrnnenkinkaisigodrate22() {
        return zrnnenkinkaisigodrate22;
    }

    public void setZrnnenkinkaisigodrate22(String pZrnnenkinkaisigodrate22) {
        zrnnenkinkaisigodrate22 = pZrnnenkinkaisigodrate22;
    }

    private String zrnnenkinkaisigodrate23;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE23)
    public String getZrnnenkinkaisigodrate23() {
        return zrnnenkinkaisigodrate23;
    }

    public void setZrnnenkinkaisigodrate23(String pZrnnenkinkaisigodrate23) {
        zrnnenkinkaisigodrate23 = pZrnnenkinkaisigodrate23;
    }

    private String zrnnenkinkaisigodrate24;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE24)
    public String getZrnnenkinkaisigodrate24() {
        return zrnnenkinkaisigodrate24;
    }

    public void setZrnnenkinkaisigodrate24(String pZrnnenkinkaisigodrate24) {
        zrnnenkinkaisigodrate24 = pZrnnenkinkaisigodrate24;
    }

    private String zrnnenkinkaisigodrate25;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE25)
    public String getZrnnenkinkaisigodrate25() {
        return zrnnenkinkaisigodrate25;
    }

    public void setZrnnenkinkaisigodrate25(String pZrnnenkinkaisigodrate25) {
        zrnnenkinkaisigodrate25 = pZrnnenkinkaisigodrate25;
    }

    private String zrnnenkinkaisigodrate26;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE26)
    public String getZrnnenkinkaisigodrate26() {
        return zrnnenkinkaisigodrate26;
    }

    public void setZrnnenkinkaisigodrate26(String pZrnnenkinkaisigodrate26) {
        zrnnenkinkaisigodrate26 = pZrnnenkinkaisigodrate26;
    }

    private String zrnnenkinkaisigodrate27;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE27)
    public String getZrnnenkinkaisigodrate27() {
        return zrnnenkinkaisigodrate27;
    }

    public void setZrnnenkinkaisigodrate27(String pZrnnenkinkaisigodrate27) {
        zrnnenkinkaisigodrate27 = pZrnnenkinkaisigodrate27;
    }

    private String zrnnenkinkaisigodrate28;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE28)
    public String getZrnnenkinkaisigodrate28() {
        return zrnnenkinkaisigodrate28;
    }

    public void setZrnnenkinkaisigodrate28(String pZrnnenkinkaisigodrate28) {
        zrnnenkinkaisigodrate28 = pZrnnenkinkaisigodrate28;
    }

    private String zrnnenkinkaisigodrate29;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE29)
    public String getZrnnenkinkaisigodrate29() {
        return zrnnenkinkaisigodrate29;
    }

    public void setZrnnenkinkaisigodrate29(String pZrnnenkinkaisigodrate29) {
        zrnnenkinkaisigodrate29 = pZrnnenkinkaisigodrate29;
    }

    private String zrnnenkinkaisigodrate30;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE30)
    public String getZrnnenkinkaisigodrate30() {
        return zrnnenkinkaisigodrate30;
    }

    public void setZrnnenkinkaisigodrate30(String pZrnnenkinkaisigodrate30) {
        zrnnenkinkaisigodrate30 = pZrnnenkinkaisigodrate30;
    }

    private String zrnnenkinkaisigodrate31;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE31)
    public String getZrnnenkinkaisigodrate31() {
        return zrnnenkinkaisigodrate31;
    }

    public void setZrnnenkinkaisigodrate31(String pZrnnenkinkaisigodrate31) {
        zrnnenkinkaisigodrate31 = pZrnnenkinkaisigodrate31;
    }

    private String zrnnenkinkaisigodrate32;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE32)
    public String getZrnnenkinkaisigodrate32() {
        return zrnnenkinkaisigodrate32;
    }

    public void setZrnnenkinkaisigodrate32(String pZrnnenkinkaisigodrate32) {
        zrnnenkinkaisigodrate32 = pZrnnenkinkaisigodrate32;
    }

    private String zrnnenkinkaisigodrate33;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE33)
    public String getZrnnenkinkaisigodrate33() {
        return zrnnenkinkaisigodrate33;
    }

    public void setZrnnenkinkaisigodrate33(String pZrnnenkinkaisigodrate33) {
        zrnnenkinkaisigodrate33 = pZrnnenkinkaisigodrate33;
    }

    private String zrnnenkinkaisigodrate34;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE34)
    public String getZrnnenkinkaisigodrate34() {
        return zrnnenkinkaisigodrate34;
    }

    public void setZrnnenkinkaisigodrate34(String pZrnnenkinkaisigodrate34) {
        zrnnenkinkaisigodrate34 = pZrnnenkinkaisigodrate34;
    }

    private String zrnnenkinkaisigodrate35;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE35)
    public String getZrnnenkinkaisigodrate35() {
        return zrnnenkinkaisigodrate35;
    }

    public void setZrnnenkinkaisigodrate35(String pZrnnenkinkaisigodrate35) {
        zrnnenkinkaisigodrate35 = pZrnnenkinkaisigodrate35;
    }

    private String zrnnenkinkaisigodrate36;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE36)
    public String getZrnnenkinkaisigodrate36() {
        return zrnnenkinkaisigodrate36;
    }

    public void setZrnnenkinkaisigodrate36(String pZrnnenkinkaisigodrate36) {
        zrnnenkinkaisigodrate36 = pZrnnenkinkaisigodrate36;
    }

    private String zrnnenkinkaisigodrate37;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE37)
    public String getZrnnenkinkaisigodrate37() {
        return zrnnenkinkaisigodrate37;
    }

    public void setZrnnenkinkaisigodrate37(String pZrnnenkinkaisigodrate37) {
        zrnnenkinkaisigodrate37 = pZrnnenkinkaisigodrate37;
    }

    private String zrnnenkinkaisigodrate38;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE38)
    public String getZrnnenkinkaisigodrate38() {
        return zrnnenkinkaisigodrate38;
    }

    public void setZrnnenkinkaisigodrate38(String pZrnnenkinkaisigodrate38) {
        zrnnenkinkaisigodrate38 = pZrnnenkinkaisigodrate38;
    }

    private String zrnnenkinkaisigodrate39;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE39)
    public String getZrnnenkinkaisigodrate39() {
        return zrnnenkinkaisigodrate39;
    }

    public void setZrnnenkinkaisigodrate39(String pZrnnenkinkaisigodrate39) {
        zrnnenkinkaisigodrate39 = pZrnnenkinkaisigodrate39;
    }

    private String zrnnenkinkaisigodrate40;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE40)
    public String getZrnnenkinkaisigodrate40() {
        return zrnnenkinkaisigodrate40;
    }

    public void setZrnnenkinkaisigodrate40(String pZrnnenkinkaisigodrate40) {
        zrnnenkinkaisigodrate40 = pZrnnenkinkaisigodrate40;
    }

    private String zrnnenkinkaisigodrate41;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE41)
    public String getZrnnenkinkaisigodrate41() {
        return zrnnenkinkaisigodrate41;
    }

    public void setZrnnenkinkaisigodrate41(String pZrnnenkinkaisigodrate41) {
        zrnnenkinkaisigodrate41 = pZrnnenkinkaisigodrate41;
    }

    private String zrnnenkinkaisigodrate42;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE42)
    public String getZrnnenkinkaisigodrate42() {
        return zrnnenkinkaisigodrate42;
    }

    public void setZrnnenkinkaisigodrate42(String pZrnnenkinkaisigodrate42) {
        zrnnenkinkaisigodrate42 = pZrnnenkinkaisigodrate42;
    }

    private String zrnnenkinkaisigodrate43;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE43)
    public String getZrnnenkinkaisigodrate43() {
        return zrnnenkinkaisigodrate43;
    }

    public void setZrnnenkinkaisigodrate43(String pZrnnenkinkaisigodrate43) {
        zrnnenkinkaisigodrate43 = pZrnnenkinkaisigodrate43;
    }

    private String zrnnenkinkaisigodrate44;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE44)
    public String getZrnnenkinkaisigodrate44() {
        return zrnnenkinkaisigodrate44;
    }

    public void setZrnnenkinkaisigodrate44(String pZrnnenkinkaisigodrate44) {
        zrnnenkinkaisigodrate44 = pZrnnenkinkaisigodrate44;
    }

    private String zrnnenkinkaisigodrate45;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE45)
    public String getZrnnenkinkaisigodrate45() {
        return zrnnenkinkaisigodrate45;
    }

    public void setZrnnenkinkaisigodrate45(String pZrnnenkinkaisigodrate45) {
        zrnnenkinkaisigodrate45 = pZrnnenkinkaisigodrate45;
    }

    private String zrnnenkinkaisigodrate46;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE46)
    public String getZrnnenkinkaisigodrate46() {
        return zrnnenkinkaisigodrate46;
    }

    public void setZrnnenkinkaisigodrate46(String pZrnnenkinkaisigodrate46) {
        zrnnenkinkaisigodrate46 = pZrnnenkinkaisigodrate46;
    }

    private String zrnnenkinkaisigodrate47;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE47)
    public String getZrnnenkinkaisigodrate47() {
        return zrnnenkinkaisigodrate47;
    }

    public void setZrnnenkinkaisigodrate47(String pZrnnenkinkaisigodrate47) {
        zrnnenkinkaisigodrate47 = pZrnnenkinkaisigodrate47;
    }

    private String zrnnenkinkaisigodrate48;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE48)
    public String getZrnnenkinkaisigodrate48() {
        return zrnnenkinkaisigodrate48;
    }

    public void setZrnnenkinkaisigodrate48(String pZrnnenkinkaisigodrate48) {
        zrnnenkinkaisigodrate48 = pZrnnenkinkaisigodrate48;
    }

    private String zrnnenkinkaisigodrate49;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE49)
    public String getZrnnenkinkaisigodrate49() {
        return zrnnenkinkaisigodrate49;
    }

    public void setZrnnenkinkaisigodrate49(String pZrnnenkinkaisigodrate49) {
        zrnnenkinkaisigodrate49 = pZrnnenkinkaisigodrate49;
    }

    private String zrnnenkinkaisigodrate50;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE50)
    public String getZrnnenkinkaisigodrate50() {
        return zrnnenkinkaisigodrate50;
    }

    public void setZrnnenkinkaisigodrate50(String pZrnnenkinkaisigodrate50) {
        zrnnenkinkaisigodrate50 = pZrnnenkinkaisigodrate50;
    }

    private String zrnnenkinkaisigodrate51;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE51)
    public String getZrnnenkinkaisigodrate51() {
        return zrnnenkinkaisigodrate51;
    }

    public void setZrnnenkinkaisigodrate51(String pZrnnenkinkaisigodrate51) {
        zrnnenkinkaisigodrate51 = pZrnnenkinkaisigodrate51;
    }

    private String zrnnenkinkaisigodrate52;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE52)
    public String getZrnnenkinkaisigodrate52() {
        return zrnnenkinkaisigodrate52;
    }

    public void setZrnnenkinkaisigodrate52(String pZrnnenkinkaisigodrate52) {
        zrnnenkinkaisigodrate52 = pZrnnenkinkaisigodrate52;
    }

    private String zrnnenkinkaisigodrate53;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE53)
    public String getZrnnenkinkaisigodrate53() {
        return zrnnenkinkaisigodrate53;
    }

    public void setZrnnenkinkaisigodrate53(String pZrnnenkinkaisigodrate53) {
        zrnnenkinkaisigodrate53 = pZrnnenkinkaisigodrate53;
    }

    private String zrnnenkinkaisigodrate54;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE54)
    public String getZrnnenkinkaisigodrate54() {
        return zrnnenkinkaisigodrate54;
    }

    public void setZrnnenkinkaisigodrate54(String pZrnnenkinkaisigodrate54) {
        zrnnenkinkaisigodrate54 = pZrnnenkinkaisigodrate54;
    }

    private String zrnnenkinkaisigodrate55;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE55)
    public String getZrnnenkinkaisigodrate55() {
        return zrnnenkinkaisigodrate55;
    }

    public void setZrnnenkinkaisigodrate55(String pZrnnenkinkaisigodrate55) {
        zrnnenkinkaisigodrate55 = pZrnnenkinkaisigodrate55;
    }

    private String zrnnenkinkaisigodrate56;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE56)
    public String getZrnnenkinkaisigodrate56() {
        return zrnnenkinkaisigodrate56;
    }

    public void setZrnnenkinkaisigodrate56(String pZrnnenkinkaisigodrate56) {
        zrnnenkinkaisigodrate56 = pZrnnenkinkaisigodrate56;
    }

    private String zrnnenkinkaisigodrate57;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE57)
    public String getZrnnenkinkaisigodrate57() {
        return zrnnenkinkaisigodrate57;
    }

    public void setZrnnenkinkaisigodrate57(String pZrnnenkinkaisigodrate57) {
        zrnnenkinkaisigodrate57 = pZrnnenkinkaisigodrate57;
    }

    private String zrnnenkinkaisigodrate58;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE58)
    public String getZrnnenkinkaisigodrate58() {
        return zrnnenkinkaisigodrate58;
    }

    public void setZrnnenkinkaisigodrate58(String pZrnnenkinkaisigodrate58) {
        zrnnenkinkaisigodrate58 = pZrnnenkinkaisigodrate58;
    }

    private String zrnnenkinkaisigodrate59;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE59)
    public String getZrnnenkinkaisigodrate59() {
        return zrnnenkinkaisigodrate59;
    }

    public void setZrnnenkinkaisigodrate59(String pZrnnenkinkaisigodrate59) {
        zrnnenkinkaisigodrate59 = pZrnnenkinkaisigodrate59;
    }

    private String zrnnenkinkaisigodrate60;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE60)
    public String getZrnnenkinkaisigodrate60() {
        return zrnnenkinkaisigodrate60;
    }

    public void setZrnnenkinkaisigodrate60(String pZrnnenkinkaisigodrate60) {
        zrnnenkinkaisigodrate60 = pZrnnenkinkaisigodrate60;
    }

    private String zrnnenkinkaisigodrate61;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE61)
    public String getZrnnenkinkaisigodrate61() {
        return zrnnenkinkaisigodrate61;
    }

    public void setZrnnenkinkaisigodrate61(String pZrnnenkinkaisigodrate61) {
        zrnnenkinkaisigodrate61 = pZrnnenkinkaisigodrate61;
    }

    private String zrnnenkinkaisigodrate62;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE62)
    public String getZrnnenkinkaisigodrate62() {
        return zrnnenkinkaisigodrate62;
    }

    public void setZrnnenkinkaisigodrate62(String pZrnnenkinkaisigodrate62) {
        zrnnenkinkaisigodrate62 = pZrnnenkinkaisigodrate62;
    }

    private String zrnnenkinkaisigodrate63;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE63)
    public String getZrnnenkinkaisigodrate63() {
        return zrnnenkinkaisigodrate63;
    }

    public void setZrnnenkinkaisigodrate63(String pZrnnenkinkaisigodrate63) {
        zrnnenkinkaisigodrate63 = pZrnnenkinkaisigodrate63;
    }

    private String zrnnenkinkaisigodrate64;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE64)
    public String getZrnnenkinkaisigodrate64() {
        return zrnnenkinkaisigodrate64;
    }

    public void setZrnnenkinkaisigodrate64(String pZrnnenkinkaisigodrate64) {
        zrnnenkinkaisigodrate64 = pZrnnenkinkaisigodrate64;
    }

    private String zrnnenkinkaisigodrate65;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE65)
    public String getZrnnenkinkaisigodrate65() {
        return zrnnenkinkaisigodrate65;
    }

    public void setZrnnenkinkaisigodrate65(String pZrnnenkinkaisigodrate65) {
        zrnnenkinkaisigodrate65 = pZrnnenkinkaisigodrate65;
    }

    private String zrnnenkinkaisigodrate66;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE66)
    public String getZrnnenkinkaisigodrate66() {
        return zrnnenkinkaisigodrate66;
    }

    public void setZrnnenkinkaisigodrate66(String pZrnnenkinkaisigodrate66) {
        zrnnenkinkaisigodrate66 = pZrnnenkinkaisigodrate66;
    }

    private String zrnnenkinkaisigodrate67;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE67)
    public String getZrnnenkinkaisigodrate67() {
        return zrnnenkinkaisigodrate67;
    }

    public void setZrnnenkinkaisigodrate67(String pZrnnenkinkaisigodrate67) {
        zrnnenkinkaisigodrate67 = pZrnnenkinkaisigodrate67;
    }

    private String zrnnenkinkaisigodrate68;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE68)
    public String getZrnnenkinkaisigodrate68() {
        return zrnnenkinkaisigodrate68;
    }

    public void setZrnnenkinkaisigodrate68(String pZrnnenkinkaisigodrate68) {
        zrnnenkinkaisigodrate68 = pZrnnenkinkaisigodrate68;
    }

    private String zrnnenkinkaisigodrate69;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE69)
    public String getZrnnenkinkaisigodrate69() {
        return zrnnenkinkaisigodrate69;
    }

    public void setZrnnenkinkaisigodrate69(String pZrnnenkinkaisigodrate69) {
        zrnnenkinkaisigodrate69 = pZrnnenkinkaisigodrate69;
    }

    private String zrnnenkinkaisigodrate70;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE70)
    public String getZrnnenkinkaisigodrate70() {
        return zrnnenkinkaisigodrate70;
    }

    public void setZrnnenkinkaisigodrate70(String pZrnnenkinkaisigodrate70) {
        zrnnenkinkaisigodrate70 = pZrnnenkinkaisigodrate70;
    }

    private String zrnnenkinkaisigodrate71;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE71)
    public String getZrnnenkinkaisigodrate71() {
        return zrnnenkinkaisigodrate71;
    }

    public void setZrnnenkinkaisigodrate71(String pZrnnenkinkaisigodrate71) {
        zrnnenkinkaisigodrate71 = pZrnnenkinkaisigodrate71;
    }

    private String zrnnenkinkaisigodrate72;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE72)
    public String getZrnnenkinkaisigodrate72() {
        return zrnnenkinkaisigodrate72;
    }

    public void setZrnnenkinkaisigodrate72(String pZrnnenkinkaisigodrate72) {
        zrnnenkinkaisigodrate72 = pZrnnenkinkaisigodrate72;
    }

    private String zrnnenkinkaisigodrate73;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE73)
    public String getZrnnenkinkaisigodrate73() {
        return zrnnenkinkaisigodrate73;
    }

    public void setZrnnenkinkaisigodrate73(String pZrnnenkinkaisigodrate73) {
        zrnnenkinkaisigodrate73 = pZrnnenkinkaisigodrate73;
    }

    private String zrnnenkinkaisigodrate74;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE74)
    public String getZrnnenkinkaisigodrate74() {
        return zrnnenkinkaisigodrate74;
    }

    public void setZrnnenkinkaisigodrate74(String pZrnnenkinkaisigodrate74) {
        zrnnenkinkaisigodrate74 = pZrnnenkinkaisigodrate74;
    }

    private String zrnnenkinkaisigodrate75;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE75)
    public String getZrnnenkinkaisigodrate75() {
        return zrnnenkinkaisigodrate75;
    }

    public void setZrnnenkinkaisigodrate75(String pZrnnenkinkaisigodrate75) {
        zrnnenkinkaisigodrate75 = pZrnnenkinkaisigodrate75;
    }

    private String zrnnenkinkaisigodrate76;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE76)
    public String getZrnnenkinkaisigodrate76() {
        return zrnnenkinkaisigodrate76;
    }

    public void setZrnnenkinkaisigodrate76(String pZrnnenkinkaisigodrate76) {
        zrnnenkinkaisigodrate76 = pZrnnenkinkaisigodrate76;
    }

    private String zrnnenkinkaisigodrate77;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE77)
    public String getZrnnenkinkaisigodrate77() {
        return zrnnenkinkaisigodrate77;
    }

    public void setZrnnenkinkaisigodrate77(String pZrnnenkinkaisigodrate77) {
        zrnnenkinkaisigodrate77 = pZrnnenkinkaisigodrate77;
    }

    private String zrnnenkinkaisigodrate78;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE78)
    public String getZrnnenkinkaisigodrate78() {
        return zrnnenkinkaisigodrate78;
    }

    public void setZrnnenkinkaisigodrate78(String pZrnnenkinkaisigodrate78) {
        zrnnenkinkaisigodrate78 = pZrnnenkinkaisigodrate78;
    }

    private String zrnnenkinkaisigodrate79;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE79)
    public String getZrnnenkinkaisigodrate79() {
        return zrnnenkinkaisigodrate79;
    }

    public void setZrnnenkinkaisigodrate79(String pZrnnenkinkaisigodrate79) {
        zrnnenkinkaisigodrate79 = pZrnnenkinkaisigodrate79;
    }

    private String zrnnenkinkaisigodrate80;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE80)
    public String getZrnnenkinkaisigodrate80() {
        return zrnnenkinkaisigodrate80;
    }

    public void setZrnnenkinkaisigodrate80(String pZrnnenkinkaisigodrate80) {
        zrnnenkinkaisigodrate80 = pZrnnenkinkaisigodrate80;
    }

    private String zrnnenkinkaisigodrate81;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE81)
    public String getZrnnenkinkaisigodrate81() {
        return zrnnenkinkaisigodrate81;
    }

    public void setZrnnenkinkaisigodrate81(String pZrnnenkinkaisigodrate81) {
        zrnnenkinkaisigodrate81 = pZrnnenkinkaisigodrate81;
    }

    private String zrnnenkinkaisigodrate82;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE82)
    public String getZrnnenkinkaisigodrate82() {
        return zrnnenkinkaisigodrate82;
    }

    public void setZrnnenkinkaisigodrate82(String pZrnnenkinkaisigodrate82) {
        zrnnenkinkaisigodrate82 = pZrnnenkinkaisigodrate82;
    }

    private String zrnnenkinkaisigodrate83;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE83)
    public String getZrnnenkinkaisigodrate83() {
        return zrnnenkinkaisigodrate83;
    }

    public void setZrnnenkinkaisigodrate83(String pZrnnenkinkaisigodrate83) {
        zrnnenkinkaisigodrate83 = pZrnnenkinkaisigodrate83;
    }

    private String zrnnenkinkaisigodrate84;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE84)
    public String getZrnnenkinkaisigodrate84() {
        return zrnnenkinkaisigodrate84;
    }

    public void setZrnnenkinkaisigodrate84(String pZrnnenkinkaisigodrate84) {
        zrnnenkinkaisigodrate84 = pZrnnenkinkaisigodrate84;
    }

    private String zrnnenkinkaisigodrate85;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE85)
    public String getZrnnenkinkaisigodrate85() {
        return zrnnenkinkaisigodrate85;
    }

    public void setZrnnenkinkaisigodrate85(String pZrnnenkinkaisigodrate85) {
        zrnnenkinkaisigodrate85 = pZrnnenkinkaisigodrate85;
    }

    private String zrnnenkinkaisigodrate86;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE86)
    public String getZrnnenkinkaisigodrate86() {
        return zrnnenkinkaisigodrate86;
    }

    public void setZrnnenkinkaisigodrate86(String pZrnnenkinkaisigodrate86) {
        zrnnenkinkaisigodrate86 = pZrnnenkinkaisigodrate86;
    }

    private String zrnnenkinkaisigodrate87;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE87)
    public String getZrnnenkinkaisigodrate87() {
        return zrnnenkinkaisigodrate87;
    }

    public void setZrnnenkinkaisigodrate87(String pZrnnenkinkaisigodrate87) {
        zrnnenkinkaisigodrate87 = pZrnnenkinkaisigodrate87;
    }

    private String zrnnenkinkaisigodrate88;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE88)
    public String getZrnnenkinkaisigodrate88() {
        return zrnnenkinkaisigodrate88;
    }

    public void setZrnnenkinkaisigodrate88(String pZrnnenkinkaisigodrate88) {
        zrnnenkinkaisigodrate88 = pZrnnenkinkaisigodrate88;
    }

    private String zrnnenkinkaisigodrate89;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE89)
    public String getZrnnenkinkaisigodrate89() {
        return zrnnenkinkaisigodrate89;
    }

    public void setZrnnenkinkaisigodrate89(String pZrnnenkinkaisigodrate89) {
        zrnnenkinkaisigodrate89 = pZrnnenkinkaisigodrate89;
    }

    private String zrnnenkinkaisigodrate90;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE90)
    public String getZrnnenkinkaisigodrate90() {
        return zrnnenkinkaisigodrate90;
    }

    public void setZrnnenkinkaisigodrate90(String pZrnnenkinkaisigodrate90) {
        zrnnenkinkaisigodrate90 = pZrnnenkinkaisigodrate90;
    }

    private String zrnnenkinkaisigodrate91;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE91)
    public String getZrnnenkinkaisigodrate91() {
        return zrnnenkinkaisigodrate91;
    }

    public void setZrnnenkinkaisigodrate91(String pZrnnenkinkaisigodrate91) {
        zrnnenkinkaisigodrate91 = pZrnnenkinkaisigodrate91;
    }

    private String zrnnenkinkaisigodrate92;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE92)
    public String getZrnnenkinkaisigodrate92() {
        return zrnnenkinkaisigodrate92;
    }

    public void setZrnnenkinkaisigodrate92(String pZrnnenkinkaisigodrate92) {
        zrnnenkinkaisigodrate92 = pZrnnenkinkaisigodrate92;
    }

    private String zrnnenkinkaisigodrate93;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE93)
    public String getZrnnenkinkaisigodrate93() {
        return zrnnenkinkaisigodrate93;
    }

    public void setZrnnenkinkaisigodrate93(String pZrnnenkinkaisigodrate93) {
        zrnnenkinkaisigodrate93 = pZrnnenkinkaisigodrate93;
    }

    private String zrnnenkinkaisigodrate94;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE94)
    public String getZrnnenkinkaisigodrate94() {
        return zrnnenkinkaisigodrate94;
    }

    public void setZrnnenkinkaisigodrate94(String pZrnnenkinkaisigodrate94) {
        zrnnenkinkaisigodrate94 = pZrnnenkinkaisigodrate94;
    }

    private String zrnnenkinkaisigodrate95;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE95)
    public String getZrnnenkinkaisigodrate95() {
        return zrnnenkinkaisigodrate95;
    }

    public void setZrnnenkinkaisigodrate95(String pZrnnenkinkaisigodrate95) {
        zrnnenkinkaisigodrate95 = pZrnnenkinkaisigodrate95;
    }

    private String zrnnenkinkaisigodrate96;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE96)
    public String getZrnnenkinkaisigodrate96() {
        return zrnnenkinkaisigodrate96;
    }

    public void setZrnnenkinkaisigodrate96(String pZrnnenkinkaisigodrate96) {
        zrnnenkinkaisigodrate96 = pZrnnenkinkaisigodrate96;
    }

    private String zrnnenkinkaisigodrate97;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE97)
    public String getZrnnenkinkaisigodrate97() {
        return zrnnenkinkaisigodrate97;
    }

    public void setZrnnenkinkaisigodrate97(String pZrnnenkinkaisigodrate97) {
        zrnnenkinkaisigodrate97 = pZrnnenkinkaisigodrate97;
    }

    private String zrnnenkinkaisigodrate98;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE98)
    public String getZrnnenkinkaisigodrate98() {
        return zrnnenkinkaisigodrate98;
    }

    public void setZrnnenkinkaisigodrate98(String pZrnnenkinkaisigodrate98) {
        zrnnenkinkaisigodrate98 = pZrnnenkinkaisigodrate98;
    }

    private String zrnnenkinkaisigodrate99;

    @Column(name=GenZT_NennkinRatedRn.ZRNNENKINKAISIGODRATE99)
    public String getZrnnenkinkaisigodrate99() {
        return zrnnenkinkaisigodrate99;
    }

    public void setZrnnenkinkaisigodrate99(String pZrnnenkinkaisigodrate99) {
        zrnnenkinkaisigodrate99 = pZrnnenkinkaisigodrate99;
    }
}