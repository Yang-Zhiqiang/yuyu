package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SiShrdetailRn;
import yuyu.def.db.mapping.GenZT_SiShrdetailRn;
import yuyu.def.db.meta.GenQZT_SiShrdetailRn;
import yuyu.def.db.meta.QZT_SiShrdetailRn;

/**
 * 保険金給付金支払明細書テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SiShrdetailRn}</td><td colspan="3">保険金給付金支払明細書テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsyoruicd</td><td>（連携用）書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn</td><td>（連携用）発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyodouhuukbn</td><td>（連携用）証券同封区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsikytkmkyobi1</td><td>（連携用）保険金共通項目予備１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskyno</td><td>（連携用）送付先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskadr1kj</td><td>（連携用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr2kj</td><td>（連携用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr3kj</td><td>（連携用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshsnmkjsimisi</td><td>（連携用）送付先名（漢字）（支払明細）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisituutimei</td><td>（連携用）支払明細書通知名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisiosirasemongon1x1</td><td>（連携用）支払明細書お知らせ文言１－１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisiosirasemongon1x2</td><td>（連携用）支払明細書お知らせ文言１－２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisiosirasemongon2x1</td><td>（連携用）支払明細書お知らせ文言２－１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisiosirasemongon2x2</td><td>（連携用）支払明細書お知らせ文言２－２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisiosirasemongon2x3</td><td>（連携用）支払明細書お知らせ文言２－３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisiosirasemongon2x4</td><td>（連携用）支払明細書お知らせ文言２－４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisiosirasemongon2x5</td><td>（連携用）支払明細書お知らせ文言２－５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawyno</td><td>（連携用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawadr1kj30</td><td>（連携用）問合せ先住所１（漢字３０桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr2kj30</td><td>（連携用）問合せ先住所２（漢字３０桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr3kj30</td><td>（連携用）問合せ先住所３（漢字３０桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawtelno</td><td>（連携用）問合せ先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisiatenabuyobi1</td><td>（連携用）支払明細書宛名部予備１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisiatenabuyobi2</td><td>（連携用）支払明細書宛名部予備２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono2</td><td>（連携用）証券番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj</td><td>（連携用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj</td><td>（連携用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntyouhyouymdwa</td><td>（連携用）帳票作成日（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsiharaibiwareki</td><td>（連携用）支払日（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnbanknmkj</td><td>（連携用）銀行名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsitennmkj</td><td>（連携用）支店名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyokinsyumokumeikanji</td><td>（連携用）預金種目名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkouzano12keta</td><td>（連携用）口座番号（１２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzmeiginmkn</td><td>（連携用）口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkouzamaskingmsg</td><td>（連携用）口座マスキングＭＳＧ</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisisummarybuyobi1</td><td>（連携用）支払明細書サマリー部予備１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisisummarybuyobi2</td><td>（連携用）支払明細書サマリー部予備２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyouranmidasi</td><td>（連携用）支払明細書摘要欄見出し</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisairanmidasi</td><td>（連携用）支払金額明細欄見出し</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisibikouranmidasi</td><td>（連携用）支払明細書備考欄見出し</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibumidasiyobi</td><td>（連携用）支払明細書明細部見出し予備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou1</td><td>（連携用）支払明細書摘要１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi1</td><td>（連携用）支払明細書金額明細１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu1</td><td>（連携用）支払明細書金額明細通貨種類１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou1</td><td>（連携用）支払明細書明細備考１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou1</td><td>（連携用）支払明細書金額明細符号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi1</td><td>（連携用）支払明細書明細予備１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou2</td><td>（連携用）支払明細書摘要２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi2</td><td>（連携用）支払明細書金額明細２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu2</td><td>（連携用）支払明細書金額明細通貨種類２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou2</td><td>（連携用）支払明細書明細備考２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou2</td><td>（連携用）支払明細書金額明細符号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi2</td><td>（連携用）支払明細書明細予備２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou3</td><td>（連携用）支払明細書摘要３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi3</td><td>（連携用）支払明細書金額明細３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu3</td><td>（連携用）支払明細書金額明細通貨種類３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou3</td><td>（連携用）支払明細書明細備考３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou3</td><td>（連携用）支払明細書金額明細符号３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi3</td><td>（連携用）支払明細書明細予備３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou4</td><td>（連携用）支払明細書摘要４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi4</td><td>（連携用）支払明細書金額明細４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu4</td><td>（連携用）支払明細書金額明細通貨種類４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou4</td><td>（連携用）支払明細書明細備考４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou4</td><td>（連携用）支払明細書金額明細符号４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi4</td><td>（連携用）支払明細書明細予備４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou5</td><td>（連携用）支払明細書摘要５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi5</td><td>（連携用）支払明細書金額明細５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu5</td><td>（連携用）支払明細書金額明細通貨種類５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou5</td><td>（連携用）支払明細書明細備考５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou5</td><td>（連携用）支払明細書金額明細符号５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi5</td><td>（連携用）支払明細書明細予備５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou6</td><td>（連携用）支払明細書摘要６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi6</td><td>（連携用）支払明細書金額明細６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu6</td><td>（連携用）支払明細書金額明細通貨種類６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou6</td><td>（連携用）支払明細書明細備考６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou6</td><td>（連携用）支払明細書金額明細符号６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi6</td><td>（連携用）支払明細書明細予備６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou7</td><td>（連携用）支払明細書摘要７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi7</td><td>（連携用）支払明細書金額明細７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu7</td><td>（連携用）支払明細書金額明細通貨種類７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou7</td><td>（連携用）支払明細書明細備考７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou7</td><td>（連携用）支払明細書金額明細符号７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi7</td><td>（連携用）支払明細書明細予備７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou8</td><td>（連携用）支払明細書摘要８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi8</td><td>（連携用）支払明細書金額明細８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu8</td><td>（連携用）支払明細書金額明細通貨種類８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou8</td><td>（連携用）支払明細書明細備考８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou8</td><td>（連携用）支払明細書金額明細符号８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi8</td><td>（連携用）支払明細書明細予備８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou9</td><td>（連携用）支払明細書摘要９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi9</td><td>（連携用）支払明細書金額明細９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu9</td><td>（連携用）支払明細書金額明細通貨種類９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou9</td><td>（連携用）支払明細書明細備考９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou9</td><td>（連携用）支払明細書金額明細符号９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi9</td><td>（連携用）支払明細書明細予備９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou10</td><td>（連携用）支払明細書摘要１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi10</td><td>（連携用）支払明細書金額明細１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu10</td><td>（連携用）支払明細書金額明細通貨種類１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou10</td><td>（連携用）支払明細書明細備考１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou10</td><td>（連携用）支払明細書金額明細符号１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi10</td><td>（連携用）支払明細書明細予備１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou11</td><td>（連携用）支払明細書摘要１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi11</td><td>（連携用）支払明細書金額明細１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu11</td><td>（連携用）支払明細書金額明細通貨種類１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou11</td><td>（連携用）支払明細書明細備考１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou11</td><td>（連携用）支払明細書金額明細符号１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi11</td><td>（連携用）支払明細書明細予備１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou12</td><td>（連携用）支払明細書摘要１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi12</td><td>（連携用）支払明細書金額明細１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu12</td><td>（連携用）支払明細書金額明細通貨種類１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou12</td><td>（連携用）支払明細書明細備考１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou12</td><td>（連携用）支払明細書金額明細符号１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi12</td><td>（連携用）支払明細書明細予備１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou13</td><td>（連携用）支払明細書摘要１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi13</td><td>（連携用）支払明細書金額明細１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu13</td><td>（連携用）支払明細書金額明細通貨種類１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou13</td><td>（連携用）支払明細書明細備考１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou13</td><td>（連携用）支払明細書金額明細符号１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi13</td><td>（連携用）支払明細書明細予備１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou14</td><td>（連携用）支払明細書摘要１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi14</td><td>（連携用）支払明細書金額明細１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu14</td><td>（連携用）支払明細書金額明細通貨種類１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou14</td><td>（連携用）支払明細書明細備考１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou14</td><td>（連携用）支払明細書金額明細符号１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi14</td><td>（連携用）支払明細書明細予備１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou15</td><td>（連携用）支払明細書摘要１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi15</td><td>（連携用）支払明細書金額明細１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu15</td><td>（連携用）支払明細書金額明細通貨種類１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou15</td><td>（連携用）支払明細書明細備考１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou15</td><td>（連携用）支払明細書金額明細符号１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi15</td><td>（連携用）支払明細書明細予備１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou16</td><td>（連携用）支払明細書摘要１６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi16</td><td>（連携用）支払明細書金額明細１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu16</td><td>（連携用）支払明細書金額明細通貨種類１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou16</td><td>（連携用）支払明細書明細備考１６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou16</td><td>（連携用）支払明細書金額明細符号１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi16</td><td>（連携用）支払明細書明細予備１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou17</td><td>（連携用）支払明細書摘要１７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi17</td><td>（連携用）支払明細書金額明細１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu17</td><td>（連携用）支払明細書金額明細通貨種類１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou17</td><td>（連携用）支払明細書明細備考１７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou17</td><td>（連携用）支払明細書金額明細符号１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi17</td><td>（連携用）支払明細書明細予備１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou18</td><td>（連携用）支払明細書摘要１８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi18</td><td>（連携用）支払明細書金額明細１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu18</td><td>（連携用）支払明細書金額明細通貨種類１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou18</td><td>（連携用）支払明細書明細備考１８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou18</td><td>（連携用）支払明細書金額明細符号１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi18</td><td>（連携用）支払明細書明細予備１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou19</td><td>（連携用）支払明細書摘要１９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi19</td><td>（連携用）支払明細書金額明細１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu19</td><td>（連携用）支払明細書金額明細通貨種類１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou19</td><td>（連携用）支払明細書明細備考１９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou19</td><td>（連携用）支払明細書金額明細符号１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi19</td><td>（連携用）支払明細書明細予備１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou20</td><td>（連携用）支払明細書摘要２０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi20</td><td>（連携用）支払明細書金額明細２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu20</td><td>（連携用）支払明細書金額明細通貨種類２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou20</td><td>（連携用）支払明細書明細備考２０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou20</td><td>（連携用）支払明細書金額明細符号２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi20</td><td>（連携用）支払明細書明細予備２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou21</td><td>（連携用）支払明細書摘要２１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi21</td><td>（連携用）支払明細書金額明細２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu21</td><td>（連携用）支払明細書金額明細通貨種類２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou21</td><td>（連携用）支払明細書明細備考２１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou21</td><td>（連携用）支払明細書金額明細符号２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi21</td><td>（連携用）支払明細書明細予備２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou22</td><td>（連携用）支払明細書摘要２２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi22</td><td>（連携用）支払明細書金額明細２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu22</td><td>（連携用）支払明細書金額明細通貨種類２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou22</td><td>（連携用）支払明細書明細備考２２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou22</td><td>（連携用）支払明細書金額明細符号２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi22</td><td>（連携用）支払明細書明細予備２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou23</td><td>（連携用）支払明細書摘要２３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi23</td><td>（連携用）支払明細書金額明細２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu23</td><td>（連携用）支払明細書金額明細通貨種類２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou23</td><td>（連携用）支払明細書明細備考２３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou23</td><td>（連携用）支払明細書金額明細符号２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi23</td><td>（連携用）支払明細書明細予備２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou24</td><td>（連携用）支払明細書摘要２４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi24</td><td>（連携用）支払明細書金額明細２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu24</td><td>（連携用）支払明細書金額明細通貨種類２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou24</td><td>（連携用）支払明細書明細備考２４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou24</td><td>（連携用）支払明細書金額明細符号２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi24</td><td>（連携用）支払明細書明細予備２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisitekiyou25</td><td>（連携用）支払明細書摘要２５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisi25</td><td>（連携用）支払明細書金額明細２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisituukasyu25</td><td>（連携用）支払明細書金額明細通貨種類２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibikou25</td><td>（連携用）支払明細書明細備考２５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisikngkmisihugou25</td><td>（連携用）支払明細書金額明細符号２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaiyobi25</td><td>（連携用）支払明細書明細予備２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibuyobi1x1</td><td>（連携用）支払明細書明細部予備１－１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibuyobi1x2</td><td>（連携用）支払明細書明細部予備１－２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibuyobi1x3</td><td>（連携用）支払明細書明細部予備１－３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibuyobi1x4</td><td>（連携用）支払明細書明細部予備１－４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibuyobi1x5</td><td>（連携用）支払明細書明細部予備１－５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibuyobi1x6</td><td>（連携用）支払明細書明細部予備１－６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisisigoukeikingaku</td><td>（連携用）支払明細書支払合計金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisisigoukeituukasyu</td><td>（連携用）支払明細書支払合計通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibuyobi2</td><td>（連携用）支払明細書明細部予備２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisituutiranmidasi</td><td>（連携用）支払明細書通知欄見出し</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg1</td><td>（連携用）支払明細書フリーメッセージ１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg2</td><td>（連携用）支払明細書フリーメッセージ２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg3</td><td>（連携用）支払明細書フリーメッセージ３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg4</td><td>（連携用）支払明細書フリーメッセージ４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg5</td><td>（連携用）支払明細書フリーメッセージ５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg6</td><td>（連携用）支払明細書フリーメッセージ６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg7</td><td>（連携用）支払明細書フリーメッセージ７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg8</td><td>（連携用）支払明細書フリーメッセージ８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg9</td><td>（連携用）支払明細書フリーメッセージ９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg10</td><td>（連携用）支払明細書フリーメッセージ１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg11</td><td>（連携用）支払明細書フリーメッセージ１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg12</td><td>（連携用）支払明細書フリーメッセージ１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg13</td><td>（連携用）支払明細書フリーメッセージ１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg14</td><td>（連携用）支払明細書フリーメッセージ１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg15</td><td>（連携用）支払明細書フリーメッセージ１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg16</td><td>（連携用）支払明細書フリーメッセージ１６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg17</td><td>（連携用）支払明細書フリーメッセージ１７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg18</td><td>（連携用）支払明細書フリーメッセージ１８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg19</td><td>（連携用）支払明細書フリーメッセージ１９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg20</td><td>（連携用）支払明細書フリーメッセージ２０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg21</td><td>（連携用）支払明細書フリーメッセージ２１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg22</td><td>（連携用）支払明細書フリーメッセージ２２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg23</td><td>（連携用）支払明細書フリーメッセージ２３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg24</td><td>（連携用）支払明細書フリーメッセージ２４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg25</td><td>（連携用）支払明細書フリーメッセージ２５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg26</td><td>（連携用）支払明細書フリーメッセージ２６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg27</td><td>（連携用）支払明細書フリーメッセージ２７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg28</td><td>（連携用）支払明細書フリーメッセージ２８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg29</td><td>（連携用）支払明細書フリーメッセージ２９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg30</td><td>（連携用）支払明細書フリーメッセージ３０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg31</td><td>（連携用）支払明細書フリーメッセージ３１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg32</td><td>（連携用）支払明細書フリーメッセージ３２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg33</td><td>（連携用）支払明細書フリーメッセージ３３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg34</td><td>（連携用）支払明細書フリーメッセージ３４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg35</td><td>（連携用）支払明細書フリーメッセージ３５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg36</td><td>（連携用）支払明細書フリーメッセージ３６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg37</td><td>（連携用）支払明細書フリーメッセージ３７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg38</td><td>（連携用）支払明細書フリーメッセージ３８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg39</td><td>（連携用）支払明細書フリーメッセージ３９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg40</td><td>（連携用）支払明細書フリーメッセージ４０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg41</td><td>（連携用）支払明細書フリーメッセージ４１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg42</td><td>（連携用）支払明細書フリーメッセージ４２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg43</td><td>（連携用）支払明細書フリーメッセージ４３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg44</td><td>（連携用）支払明細書フリーメッセージ４４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg45</td><td>（連携用）支払明細書フリーメッセージ４５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisifreemsg46</td><td>（連携用）支払明細書フリーメッセージ４６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisiosirasemongon3x1</td><td>（連携用）支払明細書お知らせ文言３－１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisiosirasemongon3x2</td><td>（連携用）支払明細書お知らせ文言３－２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsimisisynykngk</td><td>（連携用）支払明細書収入金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisihtykeihi</td><td>（連携用）支払明細書必要経費</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkztkgk</td><td>（連携用）課税対象金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzeitratkikbn</td><td>（連携用）税取扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykhenkouumukbn</td><td>（連携用）契約者変更有無区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrkykhtykeihi</td><td>（連携用）支払時契約者必要経費</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibuyobi3x1</td><td>（連携用）支払明細書明細部予備３－１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsimisimeisaibuyobi3x2</td><td>（連携用）支払明細書明細部予備３－２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SiShrdetailRn
 * @see     GenZT_SiShrdetailRn
 * @see     QZT_SiShrdetailRn
 * @see     GenQZT_SiShrdetailRn
 */
public class PKZT_SiShrdetailRn extends AbstractExDBPrimaryKey<ZT_SiShrdetailRn, PKZT_SiShrdetailRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SiShrdetailRn() {
    }

    public PKZT_SiShrdetailRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsikibetuno
    ) {
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnsyono = pZrnsyono;
        zrnsikibetuno = pZrnsikibetuno;
    }

    @Transient
    @Override
    public Class<ZT_SiShrdetailRn> getEntityClass() {
        return ZT_SiShrdetailRn.class;
    }

    private String zrntyouhyouymd;

    public String getZrntyouhyouymd() {
        return zrntyouhyouymd;
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        zrntyouhyouymd = pZrntyouhyouymd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnsikibetuno;

    public String getZrnsikibetuno() {
        return zrnsikibetuno;
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        zrnsikibetuno = pZrnsikibetuno;
    }

}