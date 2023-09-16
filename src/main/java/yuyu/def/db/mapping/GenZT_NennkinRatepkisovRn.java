package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_NennkinRatepkisovRn;
import yuyu.def.db.id.PKZT_NennkinRatepkisovRn;
import yuyu.def.db.meta.GenQZT_NennkinRatepkisovRn;
import yuyu.def.db.meta.QZT_NennkinRatepkisovRn;

/**
 * 年金開始後Ｐ基礎Ｖレートテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_NennkinRatepkisovRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NennkinRatepkisovRn}</td><td colspan="3">年金開始後Ｐ基礎Ｖレートテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnnenkinkbn zrnnenkinkbn}</td><td>（連携用）年金区分</td><td align="center">{@link PKZT_NennkinRatepkisovRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinsyu zrnnenkinsyu}</td><td>（連携用）年金種類記号</td><td align="center">{@link PKZT_NennkinRatepkisovRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinkigousedaikbn zrnnenkinkigousedaikbn}</td><td>（連携用）年金記号世代区分</td><td align="center">{@link PKZT_NennkinRatepkisovRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">{@link PKZT_NennkinRatepkisovRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigoyoteiriritukbn zrnnkkaisigoyoteiriritukbn}</td><td>（連携用）年金開始後予定利率区分</td><td align="center">{@link PKZT_NennkinRatepkisovRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinjimutesuuryoukbn zrnnenkinjimutesuuryoukbn}</td><td>（連携用）年金事務手数料区分</td><td align="center">{@link PKZT_NennkinRatepkisovRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate00 zrnnkkaisigopkisovrate00}</td><td>（連携用）年金開始後Ｖレート００</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate01 zrnnkkaisigopkisovrate01}</td><td>（連携用）年金開始後Ｖレート０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate02 zrnnkkaisigopkisovrate02}</td><td>（連携用）年金開始後Ｖレート０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate03 zrnnkkaisigopkisovrate03}</td><td>（連携用）年金開始後Ｖレート０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate04 zrnnkkaisigopkisovrate04}</td><td>（連携用）年金開始後Ｖレート０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate05 zrnnkkaisigopkisovrate05}</td><td>（連携用）年金開始後Ｖレート０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate06 zrnnkkaisigopkisovrate06}</td><td>（連携用）年金開始後Ｖレート０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate07 zrnnkkaisigopkisovrate07}</td><td>（連携用）年金開始後Ｖレート０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate08 zrnnkkaisigopkisovrate08}</td><td>（連携用）年金開始後Ｖレート０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate09 zrnnkkaisigopkisovrate09}</td><td>（連携用）年金開始後Ｖレート０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate10 zrnnkkaisigopkisovrate10}</td><td>（連携用）年金開始後Ｖレート１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate11 zrnnkkaisigopkisovrate11}</td><td>（連携用）年金開始後Ｖレート１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate12 zrnnkkaisigopkisovrate12}</td><td>（連携用）年金開始後Ｖレート１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate13 zrnnkkaisigopkisovrate13}</td><td>（連携用）年金開始後Ｖレート１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate14 zrnnkkaisigopkisovrate14}</td><td>（連携用）年金開始後Ｖレート１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate15 zrnnkkaisigopkisovrate15}</td><td>（連携用）年金開始後Ｖレート１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate16 zrnnkkaisigopkisovrate16}</td><td>（連携用）年金開始後Ｖレート１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate17 zrnnkkaisigopkisovrate17}</td><td>（連携用）年金開始後Ｖレート１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate18 zrnnkkaisigopkisovrate18}</td><td>（連携用）年金開始後Ｖレート１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate19 zrnnkkaisigopkisovrate19}</td><td>（連携用）年金開始後Ｖレート１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate20 zrnnkkaisigopkisovrate20}</td><td>（連携用）年金開始後Ｖレート２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate21 zrnnkkaisigopkisovrate21}</td><td>（連携用）年金開始後Ｖレート２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate22 zrnnkkaisigopkisovrate22}</td><td>（連携用）年金開始後Ｖレート２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate23 zrnnkkaisigopkisovrate23}</td><td>（連携用）年金開始後Ｖレート２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate24 zrnnkkaisigopkisovrate24}</td><td>（連携用）年金開始後Ｖレート２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate25 zrnnkkaisigopkisovrate25}</td><td>（連携用）年金開始後Ｖレート２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate26 zrnnkkaisigopkisovrate26}</td><td>（連携用）年金開始後Ｖレート２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate27 zrnnkkaisigopkisovrate27}</td><td>（連携用）年金開始後Ｖレート２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate28 zrnnkkaisigopkisovrate28}</td><td>（連携用）年金開始後Ｖレート２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate29 zrnnkkaisigopkisovrate29}</td><td>（連携用）年金開始後Ｖレート２９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate30 zrnnkkaisigopkisovrate30}</td><td>（連携用）年金開始後Ｖレート３０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate31 zrnnkkaisigopkisovrate31}</td><td>（連携用）年金開始後Ｖレート３１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate32 zrnnkkaisigopkisovrate32}</td><td>（連携用）年金開始後Ｖレート３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate33 zrnnkkaisigopkisovrate33}</td><td>（連携用）年金開始後Ｖレート３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate34 zrnnkkaisigopkisovrate34}</td><td>（連携用）年金開始後Ｖレート３４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate35 zrnnkkaisigopkisovrate35}</td><td>（連携用）年金開始後Ｖレート３５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate36 zrnnkkaisigopkisovrate36}</td><td>（連携用）年金開始後Ｖレート３６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate37 zrnnkkaisigopkisovrate37}</td><td>（連携用）年金開始後Ｖレート３７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate38 zrnnkkaisigopkisovrate38}</td><td>（連携用）年金開始後Ｖレート３８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate39 zrnnkkaisigopkisovrate39}</td><td>（連携用）年金開始後Ｖレート３９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate40 zrnnkkaisigopkisovrate40}</td><td>（連携用）年金開始後Ｖレート４０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate41 zrnnkkaisigopkisovrate41}</td><td>（連携用）年金開始後Ｖレート４１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate42 zrnnkkaisigopkisovrate42}</td><td>（連携用）年金開始後Ｖレート４２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate43 zrnnkkaisigopkisovrate43}</td><td>（連携用）年金開始後Ｖレート４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate44 zrnnkkaisigopkisovrate44}</td><td>（連携用）年金開始後Ｖレート４４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate45 zrnnkkaisigopkisovrate45}</td><td>（連携用）年金開始後Ｖレート４５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate46 zrnnkkaisigopkisovrate46}</td><td>（連携用）年金開始後Ｖレート４６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate47 zrnnkkaisigopkisovrate47}</td><td>（連携用）年金開始後Ｖレート４７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate48 zrnnkkaisigopkisovrate48}</td><td>（連携用）年金開始後Ｖレート４８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate49 zrnnkkaisigopkisovrate49}</td><td>（連携用）年金開始後Ｖレート４９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate50 zrnnkkaisigopkisovrate50}</td><td>（連携用）年金開始後Ｖレート５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate51 zrnnkkaisigopkisovrate51}</td><td>（連携用）年金開始後Ｖレート５１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate52 zrnnkkaisigopkisovrate52}</td><td>（連携用）年金開始後Ｖレート５２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate53 zrnnkkaisigopkisovrate53}</td><td>（連携用）年金開始後Ｖレート５３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate54 zrnnkkaisigopkisovrate54}</td><td>（連携用）年金開始後Ｖレート５４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate55 zrnnkkaisigopkisovrate55}</td><td>（連携用）年金開始後Ｖレート５５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate56 zrnnkkaisigopkisovrate56}</td><td>（連携用）年金開始後Ｖレート５６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate57 zrnnkkaisigopkisovrate57}</td><td>（連携用）年金開始後Ｖレート５７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate58 zrnnkkaisigopkisovrate58}</td><td>（連携用）年金開始後Ｖレート５８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate59 zrnnkkaisigopkisovrate59}</td><td>（連携用）年金開始後Ｖレート５９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate60 zrnnkkaisigopkisovrate60}</td><td>（連携用）年金開始後Ｖレート６０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate61 zrnnkkaisigopkisovrate61}</td><td>（連携用）年金開始後Ｖレート６１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate62 zrnnkkaisigopkisovrate62}</td><td>（連携用）年金開始後Ｖレート６２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate63 zrnnkkaisigopkisovrate63}</td><td>（連携用）年金開始後Ｖレート６３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate64 zrnnkkaisigopkisovrate64}</td><td>（連携用）年金開始後Ｖレート６４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate65 zrnnkkaisigopkisovrate65}</td><td>（連携用）年金開始後Ｖレート６５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate66 zrnnkkaisigopkisovrate66}</td><td>（連携用）年金開始後Ｖレート６６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate67 zrnnkkaisigopkisovrate67}</td><td>（連携用）年金開始後Ｖレート６７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate68 zrnnkkaisigopkisovrate68}</td><td>（連携用）年金開始後Ｖレート６８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate69 zrnnkkaisigopkisovrate69}</td><td>（連携用）年金開始後Ｖレート６９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate70 zrnnkkaisigopkisovrate70}</td><td>（連携用）年金開始後Ｖレート７０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate71 zrnnkkaisigopkisovrate71}</td><td>（連携用）年金開始後Ｖレート７１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate72 zrnnkkaisigopkisovrate72}</td><td>（連携用）年金開始後Ｖレート７２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate73 zrnnkkaisigopkisovrate73}</td><td>（連携用）年金開始後Ｖレート７３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate74 zrnnkkaisigopkisovrate74}</td><td>（連携用）年金開始後Ｖレート７４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate75 zrnnkkaisigopkisovrate75}</td><td>（連携用）年金開始後Ｖレート７５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate76 zrnnkkaisigopkisovrate76}</td><td>（連携用）年金開始後Ｖレート７６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate77 zrnnkkaisigopkisovrate77}</td><td>（連携用）年金開始後Ｖレート７７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate78 zrnnkkaisigopkisovrate78}</td><td>（連携用）年金開始後Ｖレート７８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate79 zrnnkkaisigopkisovrate79}</td><td>（連携用）年金開始後Ｖレート７９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate80 zrnnkkaisigopkisovrate80}</td><td>（連携用）年金開始後Ｖレート８０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate81 zrnnkkaisigopkisovrate81}</td><td>（連携用）年金開始後Ｖレート８１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate82 zrnnkkaisigopkisovrate82}</td><td>（連携用）年金開始後Ｖレート８２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate83 zrnnkkaisigopkisovrate83}</td><td>（連携用）年金開始後Ｖレート８３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate84 zrnnkkaisigopkisovrate84}</td><td>（連携用）年金開始後Ｖレート８４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate85 zrnnkkaisigopkisovrate85}</td><td>（連携用）年金開始後Ｖレート８５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate86 zrnnkkaisigopkisovrate86}</td><td>（連携用）年金開始後Ｖレート８６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate87 zrnnkkaisigopkisovrate87}</td><td>（連携用）年金開始後Ｖレート８７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate88 zrnnkkaisigopkisovrate88}</td><td>（連携用）年金開始後Ｖレート８８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate89 zrnnkkaisigopkisovrate89}</td><td>（連携用）年金開始後Ｖレート８９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate90 zrnnkkaisigopkisovrate90}</td><td>（連携用）年金開始後Ｖレート９０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate91 zrnnkkaisigopkisovrate91}</td><td>（連携用）年金開始後Ｖレート９１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate92 zrnnkkaisigopkisovrate92}</td><td>（連携用）年金開始後Ｖレート９２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate93 zrnnkkaisigopkisovrate93}</td><td>（連携用）年金開始後Ｖレート９３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate94 zrnnkkaisigopkisovrate94}</td><td>（連携用）年金開始後Ｖレート９４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate95 zrnnkkaisigopkisovrate95}</td><td>（連携用）年金開始後Ｖレート９５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate96 zrnnkkaisigopkisovrate96}</td><td>（連携用）年金開始後Ｖレート９６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate97 zrnnkkaisigopkisovrate97}</td><td>（連携用）年金開始後Ｖレート９７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate98 zrnnkkaisigopkisovrate98}</td><td>（連携用）年金開始後Ｖレート９８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkaisigopkisovrate99 zrnnkkaisigopkisovrate99}</td><td>（連携用）年金開始後Ｖレート９９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NennkinRatepkisovRn
 * @see     PKZT_NennkinRatepkisovRn
 * @see     QZT_NennkinRatepkisovRn
 * @see     GenQZT_NennkinRatepkisovRn
 */
@MappedSuperclass
@Table(name=GenZT_NennkinRatepkisovRn.TABLE_NAME)
@IdClass(value=PKZT_NennkinRatepkisovRn.class)
public abstract class GenZT_NennkinRatepkisovRn extends AbstractExDBEntityForZDB<ZT_NennkinRatepkisovRn, PKZT_NennkinRatepkisovRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_NennkinRatepkisovRn";
    public static final String ZRNNENKINKBN             = "zrnnenkinkbn";
    public static final String ZRNNENKINSYU             = "zrnnenkinsyu";
    public static final String ZRNNENKINKIGOUSEDAIKBN   = "zrnnenkinkigousedaikbn";
    public static final String ZRNNKNSHRY               = "zrnnknshry";
    public static final String ZRNNKKAISIGOYOTEIRIRITUKBN = "zrnnkkaisigoyoteiriritukbn";
    public static final String ZRNNENKINJIMUTESUURYOUKBN = "zrnnenkinjimutesuuryoukbn";
    public static final String ZRNNKKAISIGOPKISOVRATE00 = "zrnnkkaisigopkisovrate00";
    public static final String ZRNNKKAISIGOPKISOVRATE01 = "zrnnkkaisigopkisovrate01";
    public static final String ZRNNKKAISIGOPKISOVRATE02 = "zrnnkkaisigopkisovrate02";
    public static final String ZRNNKKAISIGOPKISOVRATE03 = "zrnnkkaisigopkisovrate03";
    public static final String ZRNNKKAISIGOPKISOVRATE04 = "zrnnkkaisigopkisovrate04";
    public static final String ZRNNKKAISIGOPKISOVRATE05 = "zrnnkkaisigopkisovrate05";
    public static final String ZRNNKKAISIGOPKISOVRATE06 = "zrnnkkaisigopkisovrate06";
    public static final String ZRNNKKAISIGOPKISOVRATE07 = "zrnnkkaisigopkisovrate07";
    public static final String ZRNNKKAISIGOPKISOVRATE08 = "zrnnkkaisigopkisovrate08";
    public static final String ZRNNKKAISIGOPKISOVRATE09 = "zrnnkkaisigopkisovrate09";
    public static final String ZRNNKKAISIGOPKISOVRATE10 = "zrnnkkaisigopkisovrate10";
    public static final String ZRNNKKAISIGOPKISOVRATE11 = "zrnnkkaisigopkisovrate11";
    public static final String ZRNNKKAISIGOPKISOVRATE12 = "zrnnkkaisigopkisovrate12";
    public static final String ZRNNKKAISIGOPKISOVRATE13 = "zrnnkkaisigopkisovrate13";
    public static final String ZRNNKKAISIGOPKISOVRATE14 = "zrnnkkaisigopkisovrate14";
    public static final String ZRNNKKAISIGOPKISOVRATE15 = "zrnnkkaisigopkisovrate15";
    public static final String ZRNNKKAISIGOPKISOVRATE16 = "zrnnkkaisigopkisovrate16";
    public static final String ZRNNKKAISIGOPKISOVRATE17 = "zrnnkkaisigopkisovrate17";
    public static final String ZRNNKKAISIGOPKISOVRATE18 = "zrnnkkaisigopkisovrate18";
    public static final String ZRNNKKAISIGOPKISOVRATE19 = "zrnnkkaisigopkisovrate19";
    public static final String ZRNNKKAISIGOPKISOVRATE20 = "zrnnkkaisigopkisovrate20";
    public static final String ZRNNKKAISIGOPKISOVRATE21 = "zrnnkkaisigopkisovrate21";
    public static final String ZRNNKKAISIGOPKISOVRATE22 = "zrnnkkaisigopkisovrate22";
    public static final String ZRNNKKAISIGOPKISOVRATE23 = "zrnnkkaisigopkisovrate23";
    public static final String ZRNNKKAISIGOPKISOVRATE24 = "zrnnkkaisigopkisovrate24";
    public static final String ZRNNKKAISIGOPKISOVRATE25 = "zrnnkkaisigopkisovrate25";
    public static final String ZRNNKKAISIGOPKISOVRATE26 = "zrnnkkaisigopkisovrate26";
    public static final String ZRNNKKAISIGOPKISOVRATE27 = "zrnnkkaisigopkisovrate27";
    public static final String ZRNNKKAISIGOPKISOVRATE28 = "zrnnkkaisigopkisovrate28";
    public static final String ZRNNKKAISIGOPKISOVRATE29 = "zrnnkkaisigopkisovrate29";
    public static final String ZRNNKKAISIGOPKISOVRATE30 = "zrnnkkaisigopkisovrate30";
    public static final String ZRNNKKAISIGOPKISOVRATE31 = "zrnnkkaisigopkisovrate31";
    public static final String ZRNNKKAISIGOPKISOVRATE32 = "zrnnkkaisigopkisovrate32";
    public static final String ZRNNKKAISIGOPKISOVRATE33 = "zrnnkkaisigopkisovrate33";
    public static final String ZRNNKKAISIGOPKISOVRATE34 = "zrnnkkaisigopkisovrate34";
    public static final String ZRNNKKAISIGOPKISOVRATE35 = "zrnnkkaisigopkisovrate35";
    public static final String ZRNNKKAISIGOPKISOVRATE36 = "zrnnkkaisigopkisovrate36";
    public static final String ZRNNKKAISIGOPKISOVRATE37 = "zrnnkkaisigopkisovrate37";
    public static final String ZRNNKKAISIGOPKISOVRATE38 = "zrnnkkaisigopkisovrate38";
    public static final String ZRNNKKAISIGOPKISOVRATE39 = "zrnnkkaisigopkisovrate39";
    public static final String ZRNNKKAISIGOPKISOVRATE40 = "zrnnkkaisigopkisovrate40";
    public static final String ZRNNKKAISIGOPKISOVRATE41 = "zrnnkkaisigopkisovrate41";
    public static final String ZRNNKKAISIGOPKISOVRATE42 = "zrnnkkaisigopkisovrate42";
    public static final String ZRNNKKAISIGOPKISOVRATE43 = "zrnnkkaisigopkisovrate43";
    public static final String ZRNNKKAISIGOPKISOVRATE44 = "zrnnkkaisigopkisovrate44";
    public static final String ZRNNKKAISIGOPKISOVRATE45 = "zrnnkkaisigopkisovrate45";
    public static final String ZRNNKKAISIGOPKISOVRATE46 = "zrnnkkaisigopkisovrate46";
    public static final String ZRNNKKAISIGOPKISOVRATE47 = "zrnnkkaisigopkisovrate47";
    public static final String ZRNNKKAISIGOPKISOVRATE48 = "zrnnkkaisigopkisovrate48";
    public static final String ZRNNKKAISIGOPKISOVRATE49 = "zrnnkkaisigopkisovrate49";
    public static final String ZRNNKKAISIGOPKISOVRATE50 = "zrnnkkaisigopkisovrate50";
    public static final String ZRNNKKAISIGOPKISOVRATE51 = "zrnnkkaisigopkisovrate51";
    public static final String ZRNNKKAISIGOPKISOVRATE52 = "zrnnkkaisigopkisovrate52";
    public static final String ZRNNKKAISIGOPKISOVRATE53 = "zrnnkkaisigopkisovrate53";
    public static final String ZRNNKKAISIGOPKISOVRATE54 = "zrnnkkaisigopkisovrate54";
    public static final String ZRNNKKAISIGOPKISOVRATE55 = "zrnnkkaisigopkisovrate55";
    public static final String ZRNNKKAISIGOPKISOVRATE56 = "zrnnkkaisigopkisovrate56";
    public static final String ZRNNKKAISIGOPKISOVRATE57 = "zrnnkkaisigopkisovrate57";
    public static final String ZRNNKKAISIGOPKISOVRATE58 = "zrnnkkaisigopkisovrate58";
    public static final String ZRNNKKAISIGOPKISOVRATE59 = "zrnnkkaisigopkisovrate59";
    public static final String ZRNNKKAISIGOPKISOVRATE60 = "zrnnkkaisigopkisovrate60";
    public static final String ZRNNKKAISIGOPKISOVRATE61 = "zrnnkkaisigopkisovrate61";
    public static final String ZRNNKKAISIGOPKISOVRATE62 = "zrnnkkaisigopkisovrate62";
    public static final String ZRNNKKAISIGOPKISOVRATE63 = "zrnnkkaisigopkisovrate63";
    public static final String ZRNNKKAISIGOPKISOVRATE64 = "zrnnkkaisigopkisovrate64";
    public static final String ZRNNKKAISIGOPKISOVRATE65 = "zrnnkkaisigopkisovrate65";
    public static final String ZRNNKKAISIGOPKISOVRATE66 = "zrnnkkaisigopkisovrate66";
    public static final String ZRNNKKAISIGOPKISOVRATE67 = "zrnnkkaisigopkisovrate67";
    public static final String ZRNNKKAISIGOPKISOVRATE68 = "zrnnkkaisigopkisovrate68";
    public static final String ZRNNKKAISIGOPKISOVRATE69 = "zrnnkkaisigopkisovrate69";
    public static final String ZRNNKKAISIGOPKISOVRATE70 = "zrnnkkaisigopkisovrate70";
    public static final String ZRNNKKAISIGOPKISOVRATE71 = "zrnnkkaisigopkisovrate71";
    public static final String ZRNNKKAISIGOPKISOVRATE72 = "zrnnkkaisigopkisovrate72";
    public static final String ZRNNKKAISIGOPKISOVRATE73 = "zrnnkkaisigopkisovrate73";
    public static final String ZRNNKKAISIGOPKISOVRATE74 = "zrnnkkaisigopkisovrate74";
    public static final String ZRNNKKAISIGOPKISOVRATE75 = "zrnnkkaisigopkisovrate75";
    public static final String ZRNNKKAISIGOPKISOVRATE76 = "zrnnkkaisigopkisovrate76";
    public static final String ZRNNKKAISIGOPKISOVRATE77 = "zrnnkkaisigopkisovrate77";
    public static final String ZRNNKKAISIGOPKISOVRATE78 = "zrnnkkaisigopkisovrate78";
    public static final String ZRNNKKAISIGOPKISOVRATE79 = "zrnnkkaisigopkisovrate79";
    public static final String ZRNNKKAISIGOPKISOVRATE80 = "zrnnkkaisigopkisovrate80";
    public static final String ZRNNKKAISIGOPKISOVRATE81 = "zrnnkkaisigopkisovrate81";
    public static final String ZRNNKKAISIGOPKISOVRATE82 = "zrnnkkaisigopkisovrate82";
    public static final String ZRNNKKAISIGOPKISOVRATE83 = "zrnnkkaisigopkisovrate83";
    public static final String ZRNNKKAISIGOPKISOVRATE84 = "zrnnkkaisigopkisovrate84";
    public static final String ZRNNKKAISIGOPKISOVRATE85 = "zrnnkkaisigopkisovrate85";
    public static final String ZRNNKKAISIGOPKISOVRATE86 = "zrnnkkaisigopkisovrate86";
    public static final String ZRNNKKAISIGOPKISOVRATE87 = "zrnnkkaisigopkisovrate87";
    public static final String ZRNNKKAISIGOPKISOVRATE88 = "zrnnkkaisigopkisovrate88";
    public static final String ZRNNKKAISIGOPKISOVRATE89 = "zrnnkkaisigopkisovrate89";
    public static final String ZRNNKKAISIGOPKISOVRATE90 = "zrnnkkaisigopkisovrate90";
    public static final String ZRNNKKAISIGOPKISOVRATE91 = "zrnnkkaisigopkisovrate91";
    public static final String ZRNNKKAISIGOPKISOVRATE92 = "zrnnkkaisigopkisovrate92";
    public static final String ZRNNKKAISIGOPKISOVRATE93 = "zrnnkkaisigopkisovrate93";
    public static final String ZRNNKKAISIGOPKISOVRATE94 = "zrnnkkaisigopkisovrate94";
    public static final String ZRNNKKAISIGOPKISOVRATE95 = "zrnnkkaisigopkisovrate95";
    public static final String ZRNNKKAISIGOPKISOVRATE96 = "zrnnkkaisigopkisovrate96";
    public static final String ZRNNKKAISIGOPKISOVRATE97 = "zrnnkkaisigopkisovrate97";
    public static final String ZRNNKKAISIGOPKISOVRATE98 = "zrnnkkaisigopkisovrate98";
    public static final String ZRNNKKAISIGOPKISOVRATE99 = "zrnnkkaisigopkisovrate99";

    private final PKZT_NennkinRatepkisovRn primaryKey;

    public GenZT_NennkinRatepkisovRn() {
        primaryKey = new PKZT_NennkinRatepkisovRn();
    }

    public GenZT_NennkinRatepkisovRn(
        String pZrnnenkinkbn,
        String pZrnnenkinsyu,
        String pZrnnenkinkigousedaikbn,
        String pZrnnknshry,
        String pZrnnkkaisigoyoteiriritukbn,
        String pZrnnenkinjimutesuuryoukbn
    ) {
        primaryKey = new PKZT_NennkinRatepkisovRn(
            pZrnnenkinkbn,
            pZrnnenkinsyu,
            pZrnnenkinkigousedaikbn,
            pZrnnknshry,
            pZrnnkkaisigoyoteiriritukbn,
            pZrnnenkinjimutesuuryoukbn
        );
    }

    @Transient
    @Override
    public PKZT_NennkinRatepkisovRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_NennkinRatepkisovRn> getMetaClass() {
        return QZT_NennkinRatepkisovRn.class;
    }

    @Id
    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNENKINKBN)
    public String getZrnnenkinkbn() {
        return getPrimaryKey().getZrnnenkinkbn();
    }

    public void setZrnnenkinkbn(String pZrnnenkinkbn) {
        getPrimaryKey().setZrnnenkinkbn(pZrnnenkinkbn);
    }

    @Id
    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNENKINSYU)
    public String getZrnnenkinsyu() {
        return getPrimaryKey().getZrnnenkinsyu();
    }

    public void setZrnnenkinsyu(String pZrnnenkinsyu) {
        getPrimaryKey().setZrnnenkinsyu(pZrnnenkinsyu);
    }

    @Id
    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNENKINKIGOUSEDAIKBN)
    public String getZrnnenkinkigousedaikbn() {
        return getPrimaryKey().getZrnnenkinkigousedaikbn();
    }

    public void setZrnnenkinkigousedaikbn(String pZrnnenkinkigousedaikbn) {
        getPrimaryKey().setZrnnenkinkigousedaikbn(pZrnnenkinkigousedaikbn);
    }

    @Id
    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKNSHRY)
    public String getZrnnknshry() {
        return getPrimaryKey().getZrnnknshry();
    }

    public void setZrnnknshry(String pZrnnknshry) {
        getPrimaryKey().setZrnnknshry(pZrnnknshry);
    }

    @Id
    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOYOTEIRIRITUKBN)
    public String getZrnnkkaisigoyoteiriritukbn() {
        return getPrimaryKey().getZrnnkkaisigoyoteiriritukbn();
    }

    public void setZrnnkkaisigoyoteiriritukbn(String pZrnnkkaisigoyoteiriritukbn) {
        getPrimaryKey().setZrnnkkaisigoyoteiriritukbn(pZrnnkkaisigoyoteiriritukbn);
    }

    @Id
    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNENKINJIMUTESUURYOUKBN)
    public String getZrnnenkinjimutesuuryoukbn() {
        return getPrimaryKey().getZrnnenkinjimutesuuryoukbn();
    }

    public void setZrnnenkinjimutesuuryoukbn(String pZrnnenkinjimutesuuryoukbn) {
        getPrimaryKey().setZrnnenkinjimutesuuryoukbn(pZrnnenkinjimutesuuryoukbn);
    }

    private String zrnnkkaisigopkisovrate00;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE00)
    public String getZrnnkkaisigopkisovrate00() {
        return zrnnkkaisigopkisovrate00;
    }

    public void setZrnnkkaisigopkisovrate00(String pZrnnkkaisigopkisovrate00) {
        zrnnkkaisigopkisovrate00 = pZrnnkkaisigopkisovrate00;
    }

    private String zrnnkkaisigopkisovrate01;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE01)
    public String getZrnnkkaisigopkisovrate01() {
        return zrnnkkaisigopkisovrate01;
    }

    public void setZrnnkkaisigopkisovrate01(String pZrnnkkaisigopkisovrate01) {
        zrnnkkaisigopkisovrate01 = pZrnnkkaisigopkisovrate01;
    }

    private String zrnnkkaisigopkisovrate02;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE02)
    public String getZrnnkkaisigopkisovrate02() {
        return zrnnkkaisigopkisovrate02;
    }

    public void setZrnnkkaisigopkisovrate02(String pZrnnkkaisigopkisovrate02) {
        zrnnkkaisigopkisovrate02 = pZrnnkkaisigopkisovrate02;
    }

    private String zrnnkkaisigopkisovrate03;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE03)
    public String getZrnnkkaisigopkisovrate03() {
        return zrnnkkaisigopkisovrate03;
    }

    public void setZrnnkkaisigopkisovrate03(String pZrnnkkaisigopkisovrate03) {
        zrnnkkaisigopkisovrate03 = pZrnnkkaisigopkisovrate03;
    }

    private String zrnnkkaisigopkisovrate04;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE04)
    public String getZrnnkkaisigopkisovrate04() {
        return zrnnkkaisigopkisovrate04;
    }

    public void setZrnnkkaisigopkisovrate04(String pZrnnkkaisigopkisovrate04) {
        zrnnkkaisigopkisovrate04 = pZrnnkkaisigopkisovrate04;
    }

    private String zrnnkkaisigopkisovrate05;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE05)
    public String getZrnnkkaisigopkisovrate05() {
        return zrnnkkaisigopkisovrate05;
    }

    public void setZrnnkkaisigopkisovrate05(String pZrnnkkaisigopkisovrate05) {
        zrnnkkaisigopkisovrate05 = pZrnnkkaisigopkisovrate05;
    }

    private String zrnnkkaisigopkisovrate06;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE06)
    public String getZrnnkkaisigopkisovrate06() {
        return zrnnkkaisigopkisovrate06;
    }

    public void setZrnnkkaisigopkisovrate06(String pZrnnkkaisigopkisovrate06) {
        zrnnkkaisigopkisovrate06 = pZrnnkkaisigopkisovrate06;
    }

    private String zrnnkkaisigopkisovrate07;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE07)
    public String getZrnnkkaisigopkisovrate07() {
        return zrnnkkaisigopkisovrate07;
    }

    public void setZrnnkkaisigopkisovrate07(String pZrnnkkaisigopkisovrate07) {
        zrnnkkaisigopkisovrate07 = pZrnnkkaisigopkisovrate07;
    }

    private String zrnnkkaisigopkisovrate08;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE08)
    public String getZrnnkkaisigopkisovrate08() {
        return zrnnkkaisigopkisovrate08;
    }

    public void setZrnnkkaisigopkisovrate08(String pZrnnkkaisigopkisovrate08) {
        zrnnkkaisigopkisovrate08 = pZrnnkkaisigopkisovrate08;
    }

    private String zrnnkkaisigopkisovrate09;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE09)
    public String getZrnnkkaisigopkisovrate09() {
        return zrnnkkaisigopkisovrate09;
    }

    public void setZrnnkkaisigopkisovrate09(String pZrnnkkaisigopkisovrate09) {
        zrnnkkaisigopkisovrate09 = pZrnnkkaisigopkisovrate09;
    }

    private String zrnnkkaisigopkisovrate10;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE10)
    public String getZrnnkkaisigopkisovrate10() {
        return zrnnkkaisigopkisovrate10;
    }

    public void setZrnnkkaisigopkisovrate10(String pZrnnkkaisigopkisovrate10) {
        zrnnkkaisigopkisovrate10 = pZrnnkkaisigopkisovrate10;
    }

    private String zrnnkkaisigopkisovrate11;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE11)
    public String getZrnnkkaisigopkisovrate11() {
        return zrnnkkaisigopkisovrate11;
    }

    public void setZrnnkkaisigopkisovrate11(String pZrnnkkaisigopkisovrate11) {
        zrnnkkaisigopkisovrate11 = pZrnnkkaisigopkisovrate11;
    }

    private String zrnnkkaisigopkisovrate12;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE12)
    public String getZrnnkkaisigopkisovrate12() {
        return zrnnkkaisigopkisovrate12;
    }

    public void setZrnnkkaisigopkisovrate12(String pZrnnkkaisigopkisovrate12) {
        zrnnkkaisigopkisovrate12 = pZrnnkkaisigopkisovrate12;
    }

    private String zrnnkkaisigopkisovrate13;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE13)
    public String getZrnnkkaisigopkisovrate13() {
        return zrnnkkaisigopkisovrate13;
    }

    public void setZrnnkkaisigopkisovrate13(String pZrnnkkaisigopkisovrate13) {
        zrnnkkaisigopkisovrate13 = pZrnnkkaisigopkisovrate13;
    }

    private String zrnnkkaisigopkisovrate14;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE14)
    public String getZrnnkkaisigopkisovrate14() {
        return zrnnkkaisigopkisovrate14;
    }

    public void setZrnnkkaisigopkisovrate14(String pZrnnkkaisigopkisovrate14) {
        zrnnkkaisigopkisovrate14 = pZrnnkkaisigopkisovrate14;
    }

    private String zrnnkkaisigopkisovrate15;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE15)
    public String getZrnnkkaisigopkisovrate15() {
        return zrnnkkaisigopkisovrate15;
    }

    public void setZrnnkkaisigopkisovrate15(String pZrnnkkaisigopkisovrate15) {
        zrnnkkaisigopkisovrate15 = pZrnnkkaisigopkisovrate15;
    }

    private String zrnnkkaisigopkisovrate16;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE16)
    public String getZrnnkkaisigopkisovrate16() {
        return zrnnkkaisigopkisovrate16;
    }

    public void setZrnnkkaisigopkisovrate16(String pZrnnkkaisigopkisovrate16) {
        zrnnkkaisigopkisovrate16 = pZrnnkkaisigopkisovrate16;
    }

    private String zrnnkkaisigopkisovrate17;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE17)
    public String getZrnnkkaisigopkisovrate17() {
        return zrnnkkaisigopkisovrate17;
    }

    public void setZrnnkkaisigopkisovrate17(String pZrnnkkaisigopkisovrate17) {
        zrnnkkaisigopkisovrate17 = pZrnnkkaisigopkisovrate17;
    }

    private String zrnnkkaisigopkisovrate18;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE18)
    public String getZrnnkkaisigopkisovrate18() {
        return zrnnkkaisigopkisovrate18;
    }

    public void setZrnnkkaisigopkisovrate18(String pZrnnkkaisigopkisovrate18) {
        zrnnkkaisigopkisovrate18 = pZrnnkkaisigopkisovrate18;
    }

    private String zrnnkkaisigopkisovrate19;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE19)
    public String getZrnnkkaisigopkisovrate19() {
        return zrnnkkaisigopkisovrate19;
    }

    public void setZrnnkkaisigopkisovrate19(String pZrnnkkaisigopkisovrate19) {
        zrnnkkaisigopkisovrate19 = pZrnnkkaisigopkisovrate19;
    }

    private String zrnnkkaisigopkisovrate20;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE20)
    public String getZrnnkkaisigopkisovrate20() {
        return zrnnkkaisigopkisovrate20;
    }

    public void setZrnnkkaisigopkisovrate20(String pZrnnkkaisigopkisovrate20) {
        zrnnkkaisigopkisovrate20 = pZrnnkkaisigopkisovrate20;
    }

    private String zrnnkkaisigopkisovrate21;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE21)
    public String getZrnnkkaisigopkisovrate21() {
        return zrnnkkaisigopkisovrate21;
    }

    public void setZrnnkkaisigopkisovrate21(String pZrnnkkaisigopkisovrate21) {
        zrnnkkaisigopkisovrate21 = pZrnnkkaisigopkisovrate21;
    }

    private String zrnnkkaisigopkisovrate22;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE22)
    public String getZrnnkkaisigopkisovrate22() {
        return zrnnkkaisigopkisovrate22;
    }

    public void setZrnnkkaisigopkisovrate22(String pZrnnkkaisigopkisovrate22) {
        zrnnkkaisigopkisovrate22 = pZrnnkkaisigopkisovrate22;
    }

    private String zrnnkkaisigopkisovrate23;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE23)
    public String getZrnnkkaisigopkisovrate23() {
        return zrnnkkaisigopkisovrate23;
    }

    public void setZrnnkkaisigopkisovrate23(String pZrnnkkaisigopkisovrate23) {
        zrnnkkaisigopkisovrate23 = pZrnnkkaisigopkisovrate23;
    }

    private String zrnnkkaisigopkisovrate24;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE24)
    public String getZrnnkkaisigopkisovrate24() {
        return zrnnkkaisigopkisovrate24;
    }

    public void setZrnnkkaisigopkisovrate24(String pZrnnkkaisigopkisovrate24) {
        zrnnkkaisigopkisovrate24 = pZrnnkkaisigopkisovrate24;
    }

    private String zrnnkkaisigopkisovrate25;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE25)
    public String getZrnnkkaisigopkisovrate25() {
        return zrnnkkaisigopkisovrate25;
    }

    public void setZrnnkkaisigopkisovrate25(String pZrnnkkaisigopkisovrate25) {
        zrnnkkaisigopkisovrate25 = pZrnnkkaisigopkisovrate25;
    }

    private String zrnnkkaisigopkisovrate26;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE26)
    public String getZrnnkkaisigopkisovrate26() {
        return zrnnkkaisigopkisovrate26;
    }

    public void setZrnnkkaisigopkisovrate26(String pZrnnkkaisigopkisovrate26) {
        zrnnkkaisigopkisovrate26 = pZrnnkkaisigopkisovrate26;
    }

    private String zrnnkkaisigopkisovrate27;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE27)
    public String getZrnnkkaisigopkisovrate27() {
        return zrnnkkaisigopkisovrate27;
    }

    public void setZrnnkkaisigopkisovrate27(String pZrnnkkaisigopkisovrate27) {
        zrnnkkaisigopkisovrate27 = pZrnnkkaisigopkisovrate27;
    }

    private String zrnnkkaisigopkisovrate28;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE28)
    public String getZrnnkkaisigopkisovrate28() {
        return zrnnkkaisigopkisovrate28;
    }

    public void setZrnnkkaisigopkisovrate28(String pZrnnkkaisigopkisovrate28) {
        zrnnkkaisigopkisovrate28 = pZrnnkkaisigopkisovrate28;
    }

    private String zrnnkkaisigopkisovrate29;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE29)
    public String getZrnnkkaisigopkisovrate29() {
        return zrnnkkaisigopkisovrate29;
    }

    public void setZrnnkkaisigopkisovrate29(String pZrnnkkaisigopkisovrate29) {
        zrnnkkaisigopkisovrate29 = pZrnnkkaisigopkisovrate29;
    }

    private String zrnnkkaisigopkisovrate30;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE30)
    public String getZrnnkkaisigopkisovrate30() {
        return zrnnkkaisigopkisovrate30;
    }

    public void setZrnnkkaisigopkisovrate30(String pZrnnkkaisigopkisovrate30) {
        zrnnkkaisigopkisovrate30 = pZrnnkkaisigopkisovrate30;
    }

    private String zrnnkkaisigopkisovrate31;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE31)
    public String getZrnnkkaisigopkisovrate31() {
        return zrnnkkaisigopkisovrate31;
    }

    public void setZrnnkkaisigopkisovrate31(String pZrnnkkaisigopkisovrate31) {
        zrnnkkaisigopkisovrate31 = pZrnnkkaisigopkisovrate31;
    }

    private String zrnnkkaisigopkisovrate32;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE32)
    public String getZrnnkkaisigopkisovrate32() {
        return zrnnkkaisigopkisovrate32;
    }

    public void setZrnnkkaisigopkisovrate32(String pZrnnkkaisigopkisovrate32) {
        zrnnkkaisigopkisovrate32 = pZrnnkkaisigopkisovrate32;
    }

    private String zrnnkkaisigopkisovrate33;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE33)
    public String getZrnnkkaisigopkisovrate33() {
        return zrnnkkaisigopkisovrate33;
    }

    public void setZrnnkkaisigopkisovrate33(String pZrnnkkaisigopkisovrate33) {
        zrnnkkaisigopkisovrate33 = pZrnnkkaisigopkisovrate33;
    }

    private String zrnnkkaisigopkisovrate34;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE34)
    public String getZrnnkkaisigopkisovrate34() {
        return zrnnkkaisigopkisovrate34;
    }

    public void setZrnnkkaisigopkisovrate34(String pZrnnkkaisigopkisovrate34) {
        zrnnkkaisigopkisovrate34 = pZrnnkkaisigopkisovrate34;
    }

    private String zrnnkkaisigopkisovrate35;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE35)
    public String getZrnnkkaisigopkisovrate35() {
        return zrnnkkaisigopkisovrate35;
    }

    public void setZrnnkkaisigopkisovrate35(String pZrnnkkaisigopkisovrate35) {
        zrnnkkaisigopkisovrate35 = pZrnnkkaisigopkisovrate35;
    }

    private String zrnnkkaisigopkisovrate36;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE36)
    public String getZrnnkkaisigopkisovrate36() {
        return zrnnkkaisigopkisovrate36;
    }

    public void setZrnnkkaisigopkisovrate36(String pZrnnkkaisigopkisovrate36) {
        zrnnkkaisigopkisovrate36 = pZrnnkkaisigopkisovrate36;
    }

    private String zrnnkkaisigopkisovrate37;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE37)
    public String getZrnnkkaisigopkisovrate37() {
        return zrnnkkaisigopkisovrate37;
    }

    public void setZrnnkkaisigopkisovrate37(String pZrnnkkaisigopkisovrate37) {
        zrnnkkaisigopkisovrate37 = pZrnnkkaisigopkisovrate37;
    }

    private String zrnnkkaisigopkisovrate38;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE38)
    public String getZrnnkkaisigopkisovrate38() {
        return zrnnkkaisigopkisovrate38;
    }

    public void setZrnnkkaisigopkisovrate38(String pZrnnkkaisigopkisovrate38) {
        zrnnkkaisigopkisovrate38 = pZrnnkkaisigopkisovrate38;
    }

    private String zrnnkkaisigopkisovrate39;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE39)
    public String getZrnnkkaisigopkisovrate39() {
        return zrnnkkaisigopkisovrate39;
    }

    public void setZrnnkkaisigopkisovrate39(String pZrnnkkaisigopkisovrate39) {
        zrnnkkaisigopkisovrate39 = pZrnnkkaisigopkisovrate39;
    }

    private String zrnnkkaisigopkisovrate40;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE40)
    public String getZrnnkkaisigopkisovrate40() {
        return zrnnkkaisigopkisovrate40;
    }

    public void setZrnnkkaisigopkisovrate40(String pZrnnkkaisigopkisovrate40) {
        zrnnkkaisigopkisovrate40 = pZrnnkkaisigopkisovrate40;
    }

    private String zrnnkkaisigopkisovrate41;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE41)
    public String getZrnnkkaisigopkisovrate41() {
        return zrnnkkaisigopkisovrate41;
    }

    public void setZrnnkkaisigopkisovrate41(String pZrnnkkaisigopkisovrate41) {
        zrnnkkaisigopkisovrate41 = pZrnnkkaisigopkisovrate41;
    }

    private String zrnnkkaisigopkisovrate42;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE42)
    public String getZrnnkkaisigopkisovrate42() {
        return zrnnkkaisigopkisovrate42;
    }

    public void setZrnnkkaisigopkisovrate42(String pZrnnkkaisigopkisovrate42) {
        zrnnkkaisigopkisovrate42 = pZrnnkkaisigopkisovrate42;
    }

    private String zrnnkkaisigopkisovrate43;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE43)
    public String getZrnnkkaisigopkisovrate43() {
        return zrnnkkaisigopkisovrate43;
    }

    public void setZrnnkkaisigopkisovrate43(String pZrnnkkaisigopkisovrate43) {
        zrnnkkaisigopkisovrate43 = pZrnnkkaisigopkisovrate43;
    }

    private String zrnnkkaisigopkisovrate44;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE44)
    public String getZrnnkkaisigopkisovrate44() {
        return zrnnkkaisigopkisovrate44;
    }

    public void setZrnnkkaisigopkisovrate44(String pZrnnkkaisigopkisovrate44) {
        zrnnkkaisigopkisovrate44 = pZrnnkkaisigopkisovrate44;
    }

    private String zrnnkkaisigopkisovrate45;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE45)
    public String getZrnnkkaisigopkisovrate45() {
        return zrnnkkaisigopkisovrate45;
    }

    public void setZrnnkkaisigopkisovrate45(String pZrnnkkaisigopkisovrate45) {
        zrnnkkaisigopkisovrate45 = pZrnnkkaisigopkisovrate45;
    }

    private String zrnnkkaisigopkisovrate46;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE46)
    public String getZrnnkkaisigopkisovrate46() {
        return zrnnkkaisigopkisovrate46;
    }

    public void setZrnnkkaisigopkisovrate46(String pZrnnkkaisigopkisovrate46) {
        zrnnkkaisigopkisovrate46 = pZrnnkkaisigopkisovrate46;
    }

    private String zrnnkkaisigopkisovrate47;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE47)
    public String getZrnnkkaisigopkisovrate47() {
        return zrnnkkaisigopkisovrate47;
    }

    public void setZrnnkkaisigopkisovrate47(String pZrnnkkaisigopkisovrate47) {
        zrnnkkaisigopkisovrate47 = pZrnnkkaisigopkisovrate47;
    }

    private String zrnnkkaisigopkisovrate48;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE48)
    public String getZrnnkkaisigopkisovrate48() {
        return zrnnkkaisigopkisovrate48;
    }

    public void setZrnnkkaisigopkisovrate48(String pZrnnkkaisigopkisovrate48) {
        zrnnkkaisigopkisovrate48 = pZrnnkkaisigopkisovrate48;
    }

    private String zrnnkkaisigopkisovrate49;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE49)
    public String getZrnnkkaisigopkisovrate49() {
        return zrnnkkaisigopkisovrate49;
    }

    public void setZrnnkkaisigopkisovrate49(String pZrnnkkaisigopkisovrate49) {
        zrnnkkaisigopkisovrate49 = pZrnnkkaisigopkisovrate49;
    }

    private String zrnnkkaisigopkisovrate50;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE50)
    public String getZrnnkkaisigopkisovrate50() {
        return zrnnkkaisigopkisovrate50;
    }

    public void setZrnnkkaisigopkisovrate50(String pZrnnkkaisigopkisovrate50) {
        zrnnkkaisigopkisovrate50 = pZrnnkkaisigopkisovrate50;
    }

    private String zrnnkkaisigopkisovrate51;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE51)
    public String getZrnnkkaisigopkisovrate51() {
        return zrnnkkaisigopkisovrate51;
    }

    public void setZrnnkkaisigopkisovrate51(String pZrnnkkaisigopkisovrate51) {
        zrnnkkaisigopkisovrate51 = pZrnnkkaisigopkisovrate51;
    }

    private String zrnnkkaisigopkisovrate52;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE52)
    public String getZrnnkkaisigopkisovrate52() {
        return zrnnkkaisigopkisovrate52;
    }

    public void setZrnnkkaisigopkisovrate52(String pZrnnkkaisigopkisovrate52) {
        zrnnkkaisigopkisovrate52 = pZrnnkkaisigopkisovrate52;
    }

    private String zrnnkkaisigopkisovrate53;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE53)
    public String getZrnnkkaisigopkisovrate53() {
        return zrnnkkaisigopkisovrate53;
    }

    public void setZrnnkkaisigopkisovrate53(String pZrnnkkaisigopkisovrate53) {
        zrnnkkaisigopkisovrate53 = pZrnnkkaisigopkisovrate53;
    }

    private String zrnnkkaisigopkisovrate54;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE54)
    public String getZrnnkkaisigopkisovrate54() {
        return zrnnkkaisigopkisovrate54;
    }

    public void setZrnnkkaisigopkisovrate54(String pZrnnkkaisigopkisovrate54) {
        zrnnkkaisigopkisovrate54 = pZrnnkkaisigopkisovrate54;
    }

    private String zrnnkkaisigopkisovrate55;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE55)
    public String getZrnnkkaisigopkisovrate55() {
        return zrnnkkaisigopkisovrate55;
    }

    public void setZrnnkkaisigopkisovrate55(String pZrnnkkaisigopkisovrate55) {
        zrnnkkaisigopkisovrate55 = pZrnnkkaisigopkisovrate55;
    }

    private String zrnnkkaisigopkisovrate56;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE56)
    public String getZrnnkkaisigopkisovrate56() {
        return zrnnkkaisigopkisovrate56;
    }

    public void setZrnnkkaisigopkisovrate56(String pZrnnkkaisigopkisovrate56) {
        zrnnkkaisigopkisovrate56 = pZrnnkkaisigopkisovrate56;
    }

    private String zrnnkkaisigopkisovrate57;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE57)
    public String getZrnnkkaisigopkisovrate57() {
        return zrnnkkaisigopkisovrate57;
    }

    public void setZrnnkkaisigopkisovrate57(String pZrnnkkaisigopkisovrate57) {
        zrnnkkaisigopkisovrate57 = pZrnnkkaisigopkisovrate57;
    }

    private String zrnnkkaisigopkisovrate58;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE58)
    public String getZrnnkkaisigopkisovrate58() {
        return zrnnkkaisigopkisovrate58;
    }

    public void setZrnnkkaisigopkisovrate58(String pZrnnkkaisigopkisovrate58) {
        zrnnkkaisigopkisovrate58 = pZrnnkkaisigopkisovrate58;
    }

    private String zrnnkkaisigopkisovrate59;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE59)
    public String getZrnnkkaisigopkisovrate59() {
        return zrnnkkaisigopkisovrate59;
    }

    public void setZrnnkkaisigopkisovrate59(String pZrnnkkaisigopkisovrate59) {
        zrnnkkaisigopkisovrate59 = pZrnnkkaisigopkisovrate59;
    }

    private String zrnnkkaisigopkisovrate60;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE60)
    public String getZrnnkkaisigopkisovrate60() {
        return zrnnkkaisigopkisovrate60;
    }

    public void setZrnnkkaisigopkisovrate60(String pZrnnkkaisigopkisovrate60) {
        zrnnkkaisigopkisovrate60 = pZrnnkkaisigopkisovrate60;
    }

    private String zrnnkkaisigopkisovrate61;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE61)
    public String getZrnnkkaisigopkisovrate61() {
        return zrnnkkaisigopkisovrate61;
    }

    public void setZrnnkkaisigopkisovrate61(String pZrnnkkaisigopkisovrate61) {
        zrnnkkaisigopkisovrate61 = pZrnnkkaisigopkisovrate61;
    }

    private String zrnnkkaisigopkisovrate62;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE62)
    public String getZrnnkkaisigopkisovrate62() {
        return zrnnkkaisigopkisovrate62;
    }

    public void setZrnnkkaisigopkisovrate62(String pZrnnkkaisigopkisovrate62) {
        zrnnkkaisigopkisovrate62 = pZrnnkkaisigopkisovrate62;
    }

    private String zrnnkkaisigopkisovrate63;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE63)
    public String getZrnnkkaisigopkisovrate63() {
        return zrnnkkaisigopkisovrate63;
    }

    public void setZrnnkkaisigopkisovrate63(String pZrnnkkaisigopkisovrate63) {
        zrnnkkaisigopkisovrate63 = pZrnnkkaisigopkisovrate63;
    }

    private String zrnnkkaisigopkisovrate64;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE64)
    public String getZrnnkkaisigopkisovrate64() {
        return zrnnkkaisigopkisovrate64;
    }

    public void setZrnnkkaisigopkisovrate64(String pZrnnkkaisigopkisovrate64) {
        zrnnkkaisigopkisovrate64 = pZrnnkkaisigopkisovrate64;
    }

    private String zrnnkkaisigopkisovrate65;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE65)
    public String getZrnnkkaisigopkisovrate65() {
        return zrnnkkaisigopkisovrate65;
    }

    public void setZrnnkkaisigopkisovrate65(String pZrnnkkaisigopkisovrate65) {
        zrnnkkaisigopkisovrate65 = pZrnnkkaisigopkisovrate65;
    }

    private String zrnnkkaisigopkisovrate66;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE66)
    public String getZrnnkkaisigopkisovrate66() {
        return zrnnkkaisigopkisovrate66;
    }

    public void setZrnnkkaisigopkisovrate66(String pZrnnkkaisigopkisovrate66) {
        zrnnkkaisigopkisovrate66 = pZrnnkkaisigopkisovrate66;
    }

    private String zrnnkkaisigopkisovrate67;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE67)
    public String getZrnnkkaisigopkisovrate67() {
        return zrnnkkaisigopkisovrate67;
    }

    public void setZrnnkkaisigopkisovrate67(String pZrnnkkaisigopkisovrate67) {
        zrnnkkaisigopkisovrate67 = pZrnnkkaisigopkisovrate67;
    }

    private String zrnnkkaisigopkisovrate68;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE68)
    public String getZrnnkkaisigopkisovrate68() {
        return zrnnkkaisigopkisovrate68;
    }

    public void setZrnnkkaisigopkisovrate68(String pZrnnkkaisigopkisovrate68) {
        zrnnkkaisigopkisovrate68 = pZrnnkkaisigopkisovrate68;
    }

    private String zrnnkkaisigopkisovrate69;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE69)
    public String getZrnnkkaisigopkisovrate69() {
        return zrnnkkaisigopkisovrate69;
    }

    public void setZrnnkkaisigopkisovrate69(String pZrnnkkaisigopkisovrate69) {
        zrnnkkaisigopkisovrate69 = pZrnnkkaisigopkisovrate69;
    }

    private String zrnnkkaisigopkisovrate70;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE70)
    public String getZrnnkkaisigopkisovrate70() {
        return zrnnkkaisigopkisovrate70;
    }

    public void setZrnnkkaisigopkisovrate70(String pZrnnkkaisigopkisovrate70) {
        zrnnkkaisigopkisovrate70 = pZrnnkkaisigopkisovrate70;
    }

    private String zrnnkkaisigopkisovrate71;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE71)
    public String getZrnnkkaisigopkisovrate71() {
        return zrnnkkaisigopkisovrate71;
    }

    public void setZrnnkkaisigopkisovrate71(String pZrnnkkaisigopkisovrate71) {
        zrnnkkaisigopkisovrate71 = pZrnnkkaisigopkisovrate71;
    }

    private String zrnnkkaisigopkisovrate72;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE72)
    public String getZrnnkkaisigopkisovrate72() {
        return zrnnkkaisigopkisovrate72;
    }

    public void setZrnnkkaisigopkisovrate72(String pZrnnkkaisigopkisovrate72) {
        zrnnkkaisigopkisovrate72 = pZrnnkkaisigopkisovrate72;
    }

    private String zrnnkkaisigopkisovrate73;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE73)
    public String getZrnnkkaisigopkisovrate73() {
        return zrnnkkaisigopkisovrate73;
    }

    public void setZrnnkkaisigopkisovrate73(String pZrnnkkaisigopkisovrate73) {
        zrnnkkaisigopkisovrate73 = pZrnnkkaisigopkisovrate73;
    }

    private String zrnnkkaisigopkisovrate74;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE74)
    public String getZrnnkkaisigopkisovrate74() {
        return zrnnkkaisigopkisovrate74;
    }

    public void setZrnnkkaisigopkisovrate74(String pZrnnkkaisigopkisovrate74) {
        zrnnkkaisigopkisovrate74 = pZrnnkkaisigopkisovrate74;
    }

    private String zrnnkkaisigopkisovrate75;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE75)
    public String getZrnnkkaisigopkisovrate75() {
        return zrnnkkaisigopkisovrate75;
    }

    public void setZrnnkkaisigopkisovrate75(String pZrnnkkaisigopkisovrate75) {
        zrnnkkaisigopkisovrate75 = pZrnnkkaisigopkisovrate75;
    }

    private String zrnnkkaisigopkisovrate76;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE76)
    public String getZrnnkkaisigopkisovrate76() {
        return zrnnkkaisigopkisovrate76;
    }

    public void setZrnnkkaisigopkisovrate76(String pZrnnkkaisigopkisovrate76) {
        zrnnkkaisigopkisovrate76 = pZrnnkkaisigopkisovrate76;
    }

    private String zrnnkkaisigopkisovrate77;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE77)
    public String getZrnnkkaisigopkisovrate77() {
        return zrnnkkaisigopkisovrate77;
    }

    public void setZrnnkkaisigopkisovrate77(String pZrnnkkaisigopkisovrate77) {
        zrnnkkaisigopkisovrate77 = pZrnnkkaisigopkisovrate77;
    }

    private String zrnnkkaisigopkisovrate78;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE78)
    public String getZrnnkkaisigopkisovrate78() {
        return zrnnkkaisigopkisovrate78;
    }

    public void setZrnnkkaisigopkisovrate78(String pZrnnkkaisigopkisovrate78) {
        zrnnkkaisigopkisovrate78 = pZrnnkkaisigopkisovrate78;
    }

    private String zrnnkkaisigopkisovrate79;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE79)
    public String getZrnnkkaisigopkisovrate79() {
        return zrnnkkaisigopkisovrate79;
    }

    public void setZrnnkkaisigopkisovrate79(String pZrnnkkaisigopkisovrate79) {
        zrnnkkaisigopkisovrate79 = pZrnnkkaisigopkisovrate79;
    }

    private String zrnnkkaisigopkisovrate80;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE80)
    public String getZrnnkkaisigopkisovrate80() {
        return zrnnkkaisigopkisovrate80;
    }

    public void setZrnnkkaisigopkisovrate80(String pZrnnkkaisigopkisovrate80) {
        zrnnkkaisigopkisovrate80 = pZrnnkkaisigopkisovrate80;
    }

    private String zrnnkkaisigopkisovrate81;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE81)
    public String getZrnnkkaisigopkisovrate81() {
        return zrnnkkaisigopkisovrate81;
    }

    public void setZrnnkkaisigopkisovrate81(String pZrnnkkaisigopkisovrate81) {
        zrnnkkaisigopkisovrate81 = pZrnnkkaisigopkisovrate81;
    }

    private String zrnnkkaisigopkisovrate82;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE82)
    public String getZrnnkkaisigopkisovrate82() {
        return zrnnkkaisigopkisovrate82;
    }

    public void setZrnnkkaisigopkisovrate82(String pZrnnkkaisigopkisovrate82) {
        zrnnkkaisigopkisovrate82 = pZrnnkkaisigopkisovrate82;
    }

    private String zrnnkkaisigopkisovrate83;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE83)
    public String getZrnnkkaisigopkisovrate83() {
        return zrnnkkaisigopkisovrate83;
    }

    public void setZrnnkkaisigopkisovrate83(String pZrnnkkaisigopkisovrate83) {
        zrnnkkaisigopkisovrate83 = pZrnnkkaisigopkisovrate83;
    }

    private String zrnnkkaisigopkisovrate84;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE84)
    public String getZrnnkkaisigopkisovrate84() {
        return zrnnkkaisigopkisovrate84;
    }

    public void setZrnnkkaisigopkisovrate84(String pZrnnkkaisigopkisovrate84) {
        zrnnkkaisigopkisovrate84 = pZrnnkkaisigopkisovrate84;
    }

    private String zrnnkkaisigopkisovrate85;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE85)
    public String getZrnnkkaisigopkisovrate85() {
        return zrnnkkaisigopkisovrate85;
    }

    public void setZrnnkkaisigopkisovrate85(String pZrnnkkaisigopkisovrate85) {
        zrnnkkaisigopkisovrate85 = pZrnnkkaisigopkisovrate85;
    }

    private String zrnnkkaisigopkisovrate86;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE86)
    public String getZrnnkkaisigopkisovrate86() {
        return zrnnkkaisigopkisovrate86;
    }

    public void setZrnnkkaisigopkisovrate86(String pZrnnkkaisigopkisovrate86) {
        zrnnkkaisigopkisovrate86 = pZrnnkkaisigopkisovrate86;
    }

    private String zrnnkkaisigopkisovrate87;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE87)
    public String getZrnnkkaisigopkisovrate87() {
        return zrnnkkaisigopkisovrate87;
    }

    public void setZrnnkkaisigopkisovrate87(String pZrnnkkaisigopkisovrate87) {
        zrnnkkaisigopkisovrate87 = pZrnnkkaisigopkisovrate87;
    }

    private String zrnnkkaisigopkisovrate88;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE88)
    public String getZrnnkkaisigopkisovrate88() {
        return zrnnkkaisigopkisovrate88;
    }

    public void setZrnnkkaisigopkisovrate88(String pZrnnkkaisigopkisovrate88) {
        zrnnkkaisigopkisovrate88 = pZrnnkkaisigopkisovrate88;
    }

    private String zrnnkkaisigopkisovrate89;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE89)
    public String getZrnnkkaisigopkisovrate89() {
        return zrnnkkaisigopkisovrate89;
    }

    public void setZrnnkkaisigopkisovrate89(String pZrnnkkaisigopkisovrate89) {
        zrnnkkaisigopkisovrate89 = pZrnnkkaisigopkisovrate89;
    }

    private String zrnnkkaisigopkisovrate90;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE90)
    public String getZrnnkkaisigopkisovrate90() {
        return zrnnkkaisigopkisovrate90;
    }

    public void setZrnnkkaisigopkisovrate90(String pZrnnkkaisigopkisovrate90) {
        zrnnkkaisigopkisovrate90 = pZrnnkkaisigopkisovrate90;
    }

    private String zrnnkkaisigopkisovrate91;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE91)
    public String getZrnnkkaisigopkisovrate91() {
        return zrnnkkaisigopkisovrate91;
    }

    public void setZrnnkkaisigopkisovrate91(String pZrnnkkaisigopkisovrate91) {
        zrnnkkaisigopkisovrate91 = pZrnnkkaisigopkisovrate91;
    }

    private String zrnnkkaisigopkisovrate92;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE92)
    public String getZrnnkkaisigopkisovrate92() {
        return zrnnkkaisigopkisovrate92;
    }

    public void setZrnnkkaisigopkisovrate92(String pZrnnkkaisigopkisovrate92) {
        zrnnkkaisigopkisovrate92 = pZrnnkkaisigopkisovrate92;
    }

    private String zrnnkkaisigopkisovrate93;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE93)
    public String getZrnnkkaisigopkisovrate93() {
        return zrnnkkaisigopkisovrate93;
    }

    public void setZrnnkkaisigopkisovrate93(String pZrnnkkaisigopkisovrate93) {
        zrnnkkaisigopkisovrate93 = pZrnnkkaisigopkisovrate93;
    }

    private String zrnnkkaisigopkisovrate94;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE94)
    public String getZrnnkkaisigopkisovrate94() {
        return zrnnkkaisigopkisovrate94;
    }

    public void setZrnnkkaisigopkisovrate94(String pZrnnkkaisigopkisovrate94) {
        zrnnkkaisigopkisovrate94 = pZrnnkkaisigopkisovrate94;
    }

    private String zrnnkkaisigopkisovrate95;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE95)
    public String getZrnnkkaisigopkisovrate95() {
        return zrnnkkaisigopkisovrate95;
    }

    public void setZrnnkkaisigopkisovrate95(String pZrnnkkaisigopkisovrate95) {
        zrnnkkaisigopkisovrate95 = pZrnnkkaisigopkisovrate95;
    }

    private String zrnnkkaisigopkisovrate96;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE96)
    public String getZrnnkkaisigopkisovrate96() {
        return zrnnkkaisigopkisovrate96;
    }

    public void setZrnnkkaisigopkisovrate96(String pZrnnkkaisigopkisovrate96) {
        zrnnkkaisigopkisovrate96 = pZrnnkkaisigopkisovrate96;
    }

    private String zrnnkkaisigopkisovrate97;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE97)
    public String getZrnnkkaisigopkisovrate97() {
        return zrnnkkaisigopkisovrate97;
    }

    public void setZrnnkkaisigopkisovrate97(String pZrnnkkaisigopkisovrate97) {
        zrnnkkaisigopkisovrate97 = pZrnnkkaisigopkisovrate97;
    }

    private String zrnnkkaisigopkisovrate98;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE98)
    public String getZrnnkkaisigopkisovrate98() {
        return zrnnkkaisigopkisovrate98;
    }

    public void setZrnnkkaisigopkisovrate98(String pZrnnkkaisigopkisovrate98) {
        zrnnkkaisigopkisovrate98 = pZrnnkkaisigopkisovrate98;
    }

    private String zrnnkkaisigopkisovrate99;

    @Column(name=GenZT_NennkinRatepkisovRn.ZRNNKKAISIGOPKISOVRATE99)
    public String getZrnnkkaisigopkisovrate99() {
        return zrnnkkaisigopkisovrate99;
    }

    public void setZrnnkkaisigopkisovrate99(String pZrnnkkaisigopkisovrate99) {
        zrnnkkaisigopkisovrate99 = pZrnnkkaisigopkisovrate99;
    }
}