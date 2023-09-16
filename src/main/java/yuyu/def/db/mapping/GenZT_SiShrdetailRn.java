package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SiShrdetailRn;
import yuyu.def.db.id.PKZT_SiShrdetailRn;
import yuyu.def.db.meta.GenQZT_SiShrdetailRn;
import yuyu.def.db.meta.QZT_SiShrdetailRn;

/**
 * 保険金給付金支払明細書テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SiShrdetailRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SiShrdetailRn}</td><td colspan="3">保険金給付金支払明細書テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_SiShrdetailRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SiShrdetailRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyodouhuukbn zrnsyodouhuukbn}</td><td>（連携用）証券同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">{@link PKZT_SiShrdetailRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikytkmkyobi1 zrnsikytkmkyobi1}</td><td>（連携用）保険金共通項目予備１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskyno zrnshskyno}</td><td>（連携用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr1kj zrnshskadr1kj}</td><td>（連携用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr2kj zrnshskadr2kj}</td><td>（連携用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr3kj zrnshskadr3kj}</td><td>（連携用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshsnmkjsimisi zrnshsnmkjsimisi}</td><td>（連携用）送付先名（漢字）（支払明細）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisituutimei zrnsimisituutimei}</td><td>（連携用）支払明細書通知名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiosirasemongon1x1 zrnsimisiosirasemongon1x1}</td><td>（連携用）支払明細書お知らせ文言１－１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiosirasemongon1x2 zrnsimisiosirasemongon1x2}</td><td>（連携用）支払明細書お知らせ文言１－２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiosirasemongon2x1 zrnsimisiosirasemongon2x1}</td><td>（連携用）支払明細書お知らせ文言２－１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiosirasemongon2x2 zrnsimisiosirasemongon2x2}</td><td>（連携用）支払明細書お知らせ文言２－２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiosirasemongon2x3 zrnsimisiosirasemongon2x3}</td><td>（連携用）支払明細書お知らせ文言２－３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiosirasemongon2x4 zrnsimisiosirasemongon2x4}</td><td>（連携用）支払明細書お知らせ文言２－４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiosirasemongon2x5 zrnsimisiosirasemongon2x5}</td><td>（連携用）支払明細書お知らせ文言２－５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawyno zrntawyno}</td><td>（連携用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr1kj30 zrntawadr1kj30}</td><td>（連携用）問合せ先住所１（漢字３０桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr2kj30 zrntawadr2kj30}</td><td>（連携用）問合せ先住所２（漢字３０桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr3kj30 zrntawadr3kj30}</td><td>（連携用）問合せ先住所３（漢字３０桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawtelno zrntawtelno}</td><td>（連携用）問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiatenabuyobi1 zrnsimisiatenabuyobi1}</td><td>（連携用）支払明細書宛名部予備１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiatenabuyobi2 zrnsimisiatenabuyobi2}</td><td>（連携用）支払明細書宛名部予備２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj zrnkyknmkj}</td><td>（連携用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdwa zrntyouhyouymdwa}</td><td>（連携用）帳票作成日（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaibiwareki zrnsiharaibiwareki}</td><td>（連携用）支払日（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbanknmkj zrnbanknmkj}</td><td>（連携用）銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsitennmkj zrnsitennmkj}</td><td>（連携用）支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokinsyumokumeikanji zrnyokinsyumokumeikanji}</td><td>（連携用）預金種目名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzano12keta zrnkouzano12keta}</td><td>（連携用）口座番号（１２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzmeiginmkn zrnkzmeiginmkn}</td><td>（連携用）口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzamaskingmsg zrnkouzamaskingmsg}</td><td>（連携用）口座マスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisisummarybuyobi1 zrnsimisisummarybuyobi1}</td><td>（連携用）支払明細書サマリー部予備１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisisummarybuyobi2 zrnsimisisummarybuyobi2}</td><td>（連携用）支払明細書サマリー部予備２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyouranmidasi zrnsimisitekiyouranmidasi}</td><td>（連携用）支払明細書摘要欄見出し</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisairanmidasi zrnsimisimeisairanmidasi}</td><td>（連携用）支払金額明細欄見出し</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisibikouranmidasi zrnsimisibikouranmidasi}</td><td>（連携用）支払明細書備考欄見出し</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibumidasiyobi zrnsimisimeisaibumidasiyobi}</td><td>（連携用）支払明細書明細部見出し予備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou1 zrnsimisitekiyou1}</td><td>（連携用）支払明細書摘要１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi1 zrnsimisikngkmisi1}</td><td>（連携用）支払明細書金額明細１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu1 zrnsimisikngkmisituukasyu1}</td><td>（連携用）支払明細書金額明細通貨種類１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou1 zrnsimisimeisaibikou1}</td><td>（連携用）支払明細書明細備考１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou1 zrnsimisikngkmisihugou1}</td><td>（連携用）支払明細書金額明細符号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi1 zrnsimisimeisaiyobi1}</td><td>（連携用）支払明細書明細予備１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou2 zrnsimisitekiyou2}</td><td>（連携用）支払明細書摘要２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi2 zrnsimisikngkmisi2}</td><td>（連携用）支払明細書金額明細２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu2 zrnsimisikngkmisituukasyu2}</td><td>（連携用）支払明細書金額明細通貨種類２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou2 zrnsimisimeisaibikou2}</td><td>（連携用）支払明細書明細備考２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou2 zrnsimisikngkmisihugou2}</td><td>（連携用）支払明細書金額明細符号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi2 zrnsimisimeisaiyobi2}</td><td>（連携用）支払明細書明細予備２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou3 zrnsimisitekiyou3}</td><td>（連携用）支払明細書摘要３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi3 zrnsimisikngkmisi3}</td><td>（連携用）支払明細書金額明細３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu3 zrnsimisikngkmisituukasyu3}</td><td>（連携用）支払明細書金額明細通貨種類３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou3 zrnsimisimeisaibikou3}</td><td>（連携用）支払明細書明細備考３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou3 zrnsimisikngkmisihugou3}</td><td>（連携用）支払明細書金額明細符号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi3 zrnsimisimeisaiyobi3}</td><td>（連携用）支払明細書明細予備３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou4 zrnsimisitekiyou4}</td><td>（連携用）支払明細書摘要４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi4 zrnsimisikngkmisi4}</td><td>（連携用）支払明細書金額明細４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu4 zrnsimisikngkmisituukasyu4}</td><td>（連携用）支払明細書金額明細通貨種類４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou4 zrnsimisimeisaibikou4}</td><td>（連携用）支払明細書明細備考４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou4 zrnsimisikngkmisihugou4}</td><td>（連携用）支払明細書金額明細符号４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi4 zrnsimisimeisaiyobi4}</td><td>（連携用）支払明細書明細予備４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou5 zrnsimisitekiyou5}</td><td>（連携用）支払明細書摘要５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi5 zrnsimisikngkmisi5}</td><td>（連携用）支払明細書金額明細５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu5 zrnsimisikngkmisituukasyu5}</td><td>（連携用）支払明細書金額明細通貨種類５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou5 zrnsimisimeisaibikou5}</td><td>（連携用）支払明細書明細備考５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou5 zrnsimisikngkmisihugou5}</td><td>（連携用）支払明細書金額明細符号５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi5 zrnsimisimeisaiyobi5}</td><td>（連携用）支払明細書明細予備５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou6 zrnsimisitekiyou6}</td><td>（連携用）支払明細書摘要６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi6 zrnsimisikngkmisi6}</td><td>（連携用）支払明細書金額明細６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu6 zrnsimisikngkmisituukasyu6}</td><td>（連携用）支払明細書金額明細通貨種類６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou6 zrnsimisimeisaibikou6}</td><td>（連携用）支払明細書明細備考６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou6 zrnsimisikngkmisihugou6}</td><td>（連携用）支払明細書金額明細符号６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi6 zrnsimisimeisaiyobi6}</td><td>（連携用）支払明細書明細予備６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou7 zrnsimisitekiyou7}</td><td>（連携用）支払明細書摘要７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi7 zrnsimisikngkmisi7}</td><td>（連携用）支払明細書金額明細７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu7 zrnsimisikngkmisituukasyu7}</td><td>（連携用）支払明細書金額明細通貨種類７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou7 zrnsimisimeisaibikou7}</td><td>（連携用）支払明細書明細備考７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou7 zrnsimisikngkmisihugou7}</td><td>（連携用）支払明細書金額明細符号７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi7 zrnsimisimeisaiyobi7}</td><td>（連携用）支払明細書明細予備７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou8 zrnsimisitekiyou8}</td><td>（連携用）支払明細書摘要８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi8 zrnsimisikngkmisi8}</td><td>（連携用）支払明細書金額明細８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu8 zrnsimisikngkmisituukasyu8}</td><td>（連携用）支払明細書金額明細通貨種類８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou8 zrnsimisimeisaibikou8}</td><td>（連携用）支払明細書明細備考８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou8 zrnsimisikngkmisihugou8}</td><td>（連携用）支払明細書金額明細符号８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi8 zrnsimisimeisaiyobi8}</td><td>（連携用）支払明細書明細予備８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou9 zrnsimisitekiyou9}</td><td>（連携用）支払明細書摘要９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi9 zrnsimisikngkmisi9}</td><td>（連携用）支払明細書金額明細９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu9 zrnsimisikngkmisituukasyu9}</td><td>（連携用）支払明細書金額明細通貨種類９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou9 zrnsimisimeisaibikou9}</td><td>（連携用）支払明細書明細備考９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou9 zrnsimisikngkmisihugou9}</td><td>（連携用）支払明細書金額明細符号９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi9 zrnsimisimeisaiyobi9}</td><td>（連携用）支払明細書明細予備９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou10 zrnsimisitekiyou10}</td><td>（連携用）支払明細書摘要１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi10 zrnsimisikngkmisi10}</td><td>（連携用）支払明細書金額明細１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu10 zrnsimisikngkmisituukasyu10}</td><td>（連携用）支払明細書金額明細通貨種類１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou10 zrnsimisimeisaibikou10}</td><td>（連携用）支払明細書明細備考１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou10 zrnsimisikngkmisihugou10}</td><td>（連携用）支払明細書金額明細符号１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi10 zrnsimisimeisaiyobi10}</td><td>（連携用）支払明細書明細予備１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou11 zrnsimisitekiyou11}</td><td>（連携用）支払明細書摘要１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi11 zrnsimisikngkmisi11}</td><td>（連携用）支払明細書金額明細１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu11 zrnsimisikngkmisituukasyu11}</td><td>（連携用）支払明細書金額明細通貨種類１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou11 zrnsimisimeisaibikou11}</td><td>（連携用）支払明細書明細備考１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou11 zrnsimisikngkmisihugou11}</td><td>（連携用）支払明細書金額明細符号１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi11 zrnsimisimeisaiyobi11}</td><td>（連携用）支払明細書明細予備１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou12 zrnsimisitekiyou12}</td><td>（連携用）支払明細書摘要１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi12 zrnsimisikngkmisi12}</td><td>（連携用）支払明細書金額明細１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu12 zrnsimisikngkmisituukasyu12}</td><td>（連携用）支払明細書金額明細通貨種類１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou12 zrnsimisimeisaibikou12}</td><td>（連携用）支払明細書明細備考１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou12 zrnsimisikngkmisihugou12}</td><td>（連携用）支払明細書金額明細符号１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi12 zrnsimisimeisaiyobi12}</td><td>（連携用）支払明細書明細予備１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou13 zrnsimisitekiyou13}</td><td>（連携用）支払明細書摘要１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi13 zrnsimisikngkmisi13}</td><td>（連携用）支払明細書金額明細１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu13 zrnsimisikngkmisituukasyu13}</td><td>（連携用）支払明細書金額明細通貨種類１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou13 zrnsimisimeisaibikou13}</td><td>（連携用）支払明細書明細備考１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou13 zrnsimisikngkmisihugou13}</td><td>（連携用）支払明細書金額明細符号１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi13 zrnsimisimeisaiyobi13}</td><td>（連携用）支払明細書明細予備１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou14 zrnsimisitekiyou14}</td><td>（連携用）支払明細書摘要１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi14 zrnsimisikngkmisi14}</td><td>（連携用）支払明細書金額明細１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu14 zrnsimisikngkmisituukasyu14}</td><td>（連携用）支払明細書金額明細通貨種類１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou14 zrnsimisimeisaibikou14}</td><td>（連携用）支払明細書明細備考１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou14 zrnsimisikngkmisihugou14}</td><td>（連携用）支払明細書金額明細符号１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi14 zrnsimisimeisaiyobi14}</td><td>（連携用）支払明細書明細予備１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou15 zrnsimisitekiyou15}</td><td>（連携用）支払明細書摘要１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi15 zrnsimisikngkmisi15}</td><td>（連携用）支払明細書金額明細１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu15 zrnsimisikngkmisituukasyu15}</td><td>（連携用）支払明細書金額明細通貨種類１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou15 zrnsimisimeisaibikou15}</td><td>（連携用）支払明細書明細備考１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou15 zrnsimisikngkmisihugou15}</td><td>（連携用）支払明細書金額明細符号１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi15 zrnsimisimeisaiyobi15}</td><td>（連携用）支払明細書明細予備１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou16 zrnsimisitekiyou16}</td><td>（連携用）支払明細書摘要１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi16 zrnsimisikngkmisi16}</td><td>（連携用）支払明細書金額明細１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu16 zrnsimisikngkmisituukasyu16}</td><td>（連携用）支払明細書金額明細通貨種類１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou16 zrnsimisimeisaibikou16}</td><td>（連携用）支払明細書明細備考１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou16 zrnsimisikngkmisihugou16}</td><td>（連携用）支払明細書金額明細符号１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi16 zrnsimisimeisaiyobi16}</td><td>（連携用）支払明細書明細予備１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou17 zrnsimisitekiyou17}</td><td>（連携用）支払明細書摘要１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi17 zrnsimisikngkmisi17}</td><td>（連携用）支払明細書金額明細１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu17 zrnsimisikngkmisituukasyu17}</td><td>（連携用）支払明細書金額明細通貨種類１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou17 zrnsimisimeisaibikou17}</td><td>（連携用）支払明細書明細備考１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou17 zrnsimisikngkmisihugou17}</td><td>（連携用）支払明細書金額明細符号１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi17 zrnsimisimeisaiyobi17}</td><td>（連携用）支払明細書明細予備１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou18 zrnsimisitekiyou18}</td><td>（連携用）支払明細書摘要１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi18 zrnsimisikngkmisi18}</td><td>（連携用）支払明細書金額明細１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu18 zrnsimisikngkmisituukasyu18}</td><td>（連携用）支払明細書金額明細通貨種類１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou18 zrnsimisimeisaibikou18}</td><td>（連携用）支払明細書明細備考１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou18 zrnsimisikngkmisihugou18}</td><td>（連携用）支払明細書金額明細符号１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi18 zrnsimisimeisaiyobi18}</td><td>（連携用）支払明細書明細予備１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou19 zrnsimisitekiyou19}</td><td>（連携用）支払明細書摘要１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi19 zrnsimisikngkmisi19}</td><td>（連携用）支払明細書金額明細１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu19 zrnsimisikngkmisituukasyu19}</td><td>（連携用）支払明細書金額明細通貨種類１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou19 zrnsimisimeisaibikou19}</td><td>（連携用）支払明細書明細備考１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou19 zrnsimisikngkmisihugou19}</td><td>（連携用）支払明細書金額明細符号１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi19 zrnsimisimeisaiyobi19}</td><td>（連携用）支払明細書明細予備１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou20 zrnsimisitekiyou20}</td><td>（連携用）支払明細書摘要２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi20 zrnsimisikngkmisi20}</td><td>（連携用）支払明細書金額明細２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu20 zrnsimisikngkmisituukasyu20}</td><td>（連携用）支払明細書金額明細通貨種類２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou20 zrnsimisimeisaibikou20}</td><td>（連携用）支払明細書明細備考２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou20 zrnsimisikngkmisihugou20}</td><td>（連携用）支払明細書金額明細符号２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi20 zrnsimisimeisaiyobi20}</td><td>（連携用）支払明細書明細予備２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou21 zrnsimisitekiyou21}</td><td>（連携用）支払明細書摘要２１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi21 zrnsimisikngkmisi21}</td><td>（連携用）支払明細書金額明細２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu21 zrnsimisikngkmisituukasyu21}</td><td>（連携用）支払明細書金額明細通貨種類２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou21 zrnsimisimeisaibikou21}</td><td>（連携用）支払明細書明細備考２１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou21 zrnsimisikngkmisihugou21}</td><td>（連携用）支払明細書金額明細符号２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi21 zrnsimisimeisaiyobi21}</td><td>（連携用）支払明細書明細予備２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou22 zrnsimisitekiyou22}</td><td>（連携用）支払明細書摘要２２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi22 zrnsimisikngkmisi22}</td><td>（連携用）支払明細書金額明細２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu22 zrnsimisikngkmisituukasyu22}</td><td>（連携用）支払明細書金額明細通貨種類２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou22 zrnsimisimeisaibikou22}</td><td>（連携用）支払明細書明細備考２２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou22 zrnsimisikngkmisihugou22}</td><td>（連携用）支払明細書金額明細符号２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi22 zrnsimisimeisaiyobi22}</td><td>（連携用）支払明細書明細予備２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou23 zrnsimisitekiyou23}</td><td>（連携用）支払明細書摘要２３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi23 zrnsimisikngkmisi23}</td><td>（連携用）支払明細書金額明細２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu23 zrnsimisikngkmisituukasyu23}</td><td>（連携用）支払明細書金額明細通貨種類２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou23 zrnsimisimeisaibikou23}</td><td>（連携用）支払明細書明細備考２３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou23 zrnsimisikngkmisihugou23}</td><td>（連携用）支払明細書金額明細符号２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi23 zrnsimisimeisaiyobi23}</td><td>（連携用）支払明細書明細予備２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou24 zrnsimisitekiyou24}</td><td>（連携用）支払明細書摘要２４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi24 zrnsimisikngkmisi24}</td><td>（連携用）支払明細書金額明細２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu24 zrnsimisikngkmisituukasyu24}</td><td>（連携用）支払明細書金額明細通貨種類２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou24 zrnsimisimeisaibikou24}</td><td>（連携用）支払明細書明細備考２４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou24 zrnsimisikngkmisihugou24}</td><td>（連携用）支払明細書金額明細符号２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi24 zrnsimisimeisaiyobi24}</td><td>（連携用）支払明細書明細予備２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisitekiyou25 zrnsimisitekiyou25}</td><td>（連携用）支払明細書摘要２５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisi25 zrnsimisikngkmisi25}</td><td>（連携用）支払明細書金額明細２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisituukasyu25 zrnsimisikngkmisituukasyu25}</td><td>（連携用）支払明細書金額明細通貨種類２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibikou25 zrnsimisimeisaibikou25}</td><td>（連携用）支払明細書明細備考２５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisikngkmisihugou25 zrnsimisikngkmisihugou25}</td><td>（連携用）支払明細書金額明細符号２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaiyobi25 zrnsimisimeisaiyobi25}</td><td>（連携用）支払明細書明細予備２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibuyobi1x1 zrnsimisimeisaibuyobi1x1}</td><td>（連携用）支払明細書明細部予備１－１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibuyobi1x2 zrnsimisimeisaibuyobi1x2}</td><td>（連携用）支払明細書明細部予備１－２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibuyobi1x3 zrnsimisimeisaibuyobi1x3}</td><td>（連携用）支払明細書明細部予備１－３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibuyobi1x4 zrnsimisimeisaibuyobi1x4}</td><td>（連携用）支払明細書明細部予備１－４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibuyobi1x5 zrnsimisimeisaibuyobi1x5}</td><td>（連携用）支払明細書明細部予備１－５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibuyobi1x6 zrnsimisimeisaibuyobi1x6}</td><td>（連携用）支払明細書明細部予備１－６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisisigoukeikingaku zrnsimisisigoukeikingaku}</td><td>（連携用）支払明細書支払合計金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisisigoukeituukasyu zrnsimisisigoukeituukasyu}</td><td>（連携用）支払明細書支払合計通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibuyobi2 zrnsimisimeisaibuyobi2}</td><td>（連携用）支払明細書明細部予備２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisituutiranmidasi zrnsimisituutiranmidasi}</td><td>（連携用）支払明細書通知欄見出し</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg1 zrnsimisifreemsg1}</td><td>（連携用）支払明細書フリーメッセージ１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg2 zrnsimisifreemsg2}</td><td>（連携用）支払明細書フリーメッセージ２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg3 zrnsimisifreemsg3}</td><td>（連携用）支払明細書フリーメッセージ３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg4 zrnsimisifreemsg4}</td><td>（連携用）支払明細書フリーメッセージ４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg5 zrnsimisifreemsg5}</td><td>（連携用）支払明細書フリーメッセージ５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg6 zrnsimisifreemsg6}</td><td>（連携用）支払明細書フリーメッセージ６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg7 zrnsimisifreemsg7}</td><td>（連携用）支払明細書フリーメッセージ７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg8 zrnsimisifreemsg8}</td><td>（連携用）支払明細書フリーメッセージ８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg9 zrnsimisifreemsg9}</td><td>（連携用）支払明細書フリーメッセージ９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg10 zrnsimisifreemsg10}</td><td>（連携用）支払明細書フリーメッセージ１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg11 zrnsimisifreemsg11}</td><td>（連携用）支払明細書フリーメッセージ１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg12 zrnsimisifreemsg12}</td><td>（連携用）支払明細書フリーメッセージ１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg13 zrnsimisifreemsg13}</td><td>（連携用）支払明細書フリーメッセージ１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg14 zrnsimisifreemsg14}</td><td>（連携用）支払明細書フリーメッセージ１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg15 zrnsimisifreemsg15}</td><td>（連携用）支払明細書フリーメッセージ１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg16 zrnsimisifreemsg16}</td><td>（連携用）支払明細書フリーメッセージ１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg17 zrnsimisifreemsg17}</td><td>（連携用）支払明細書フリーメッセージ１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg18 zrnsimisifreemsg18}</td><td>（連携用）支払明細書フリーメッセージ１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg19 zrnsimisifreemsg19}</td><td>（連携用）支払明細書フリーメッセージ１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg20 zrnsimisifreemsg20}</td><td>（連携用）支払明細書フリーメッセージ２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg21 zrnsimisifreemsg21}</td><td>（連携用）支払明細書フリーメッセージ２１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg22 zrnsimisifreemsg22}</td><td>（連携用）支払明細書フリーメッセージ２２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg23 zrnsimisifreemsg23}</td><td>（連携用）支払明細書フリーメッセージ２３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg24 zrnsimisifreemsg24}</td><td>（連携用）支払明細書フリーメッセージ２４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg25 zrnsimisifreemsg25}</td><td>（連携用）支払明細書フリーメッセージ２５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg26 zrnsimisifreemsg26}</td><td>（連携用）支払明細書フリーメッセージ２６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg27 zrnsimisifreemsg27}</td><td>（連携用）支払明細書フリーメッセージ２７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg28 zrnsimisifreemsg28}</td><td>（連携用）支払明細書フリーメッセージ２８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg29 zrnsimisifreemsg29}</td><td>（連携用）支払明細書フリーメッセージ２９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg30 zrnsimisifreemsg30}</td><td>（連携用）支払明細書フリーメッセージ３０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg31 zrnsimisifreemsg31}</td><td>（連携用）支払明細書フリーメッセージ３１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg32 zrnsimisifreemsg32}</td><td>（連携用）支払明細書フリーメッセージ３２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg33 zrnsimisifreemsg33}</td><td>（連携用）支払明細書フリーメッセージ３３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg34 zrnsimisifreemsg34}</td><td>（連携用）支払明細書フリーメッセージ３４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg35 zrnsimisifreemsg35}</td><td>（連携用）支払明細書フリーメッセージ３５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg36 zrnsimisifreemsg36}</td><td>（連携用）支払明細書フリーメッセージ３６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg37 zrnsimisifreemsg37}</td><td>（連携用）支払明細書フリーメッセージ３７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg38 zrnsimisifreemsg38}</td><td>（連携用）支払明細書フリーメッセージ３８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg39 zrnsimisifreemsg39}</td><td>（連携用）支払明細書フリーメッセージ３９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg40 zrnsimisifreemsg40}</td><td>（連携用）支払明細書フリーメッセージ４０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg41 zrnsimisifreemsg41}</td><td>（連携用）支払明細書フリーメッセージ４１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg42 zrnsimisifreemsg42}</td><td>（連携用）支払明細書フリーメッセージ４２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg43 zrnsimisifreemsg43}</td><td>（連携用）支払明細書フリーメッセージ４３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg44 zrnsimisifreemsg44}</td><td>（連携用）支払明細書フリーメッセージ４４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg45 zrnsimisifreemsg45}</td><td>（連携用）支払明細書フリーメッセージ４５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisifreemsg46 zrnsimisifreemsg46}</td><td>（連携用）支払明細書フリーメッセージ４６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiosirasemongon3x1 zrnsimisiosirasemongon3x1}</td><td>（連携用）支払明細書お知らせ文言３－１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisiosirasemongon3x2 zrnsimisiosirasemongon3x2}</td><td>（連携用）支払明細書お知らせ文言３－２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisisynykngk zrnsimisisynykngk}</td><td>（連携用）支払明細書収入金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisihtykeihi zrnsimisihtykeihi}</td><td>（連携用）支払明細書必要経費</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkztkgk zrnkztkgk}</td><td>（連携用）課税対象金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeitratkikbn zrnzeitratkikbn}</td><td>（連携用）税取扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykhenkouumukbn zrnkykhenkouumukbn}</td><td>（連携用）契約者変更有無区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkykhtykeihi zrnshrkykhtykeihi}</td><td>（連携用）支払時契約者必要経費</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibuyobi3x1 zrnsimisimeisaibuyobi3x1}</td><td>（連携用）支払明細書明細部予備３－１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsimisimeisaibuyobi3x2 zrnsimisimeisaibuyobi3x2}</td><td>（連携用）支払明細書明細部予備３－２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SiShrdetailRn
 * @see     PKZT_SiShrdetailRn
 * @see     QZT_SiShrdetailRn
 * @see     GenQZT_SiShrdetailRn
 */
@MappedSuperclass
@Table(name=GenZT_SiShrdetailRn.TABLE_NAME)
@IdClass(value=PKZT_SiShrdetailRn.class)
public abstract class GenZT_SiShrdetailRn extends AbstractExDBEntityForZDB<ZT_SiShrdetailRn, PKZT_SiShrdetailRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SiShrdetailRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNSYODOUHUUKBN          = "zrnsyodouhuukbn";
    public static final String ZRNSIKIBETUNO            = "zrnsikibetuno";
    public static final String ZRNSIKYTKMKYOBI1         = "zrnsikytkmkyobi1";
    public static final String ZRNSHSKYNO               = "zrnshskyno";
    public static final String ZRNSHSKADR1KJ            = "zrnshskadr1kj";
    public static final String ZRNSHSKADR2KJ            = "zrnshskadr2kj";
    public static final String ZRNSHSKADR3KJ            = "zrnshskadr3kj";
    public static final String ZRNSHSNMKJSIMISI         = "zrnshsnmkjsimisi";
    public static final String ZRNSIMISITUUTIMEI        = "zrnsimisituutimei";
    public static final String ZRNSIMISIOSIRASEMONGON1X1 = "zrnsimisiosirasemongon1x1";
    public static final String ZRNSIMISIOSIRASEMONGON1X2 = "zrnsimisiosirasemongon1x2";
    public static final String ZRNSIMISIOSIRASEMONGON2X1 = "zrnsimisiosirasemongon2x1";
    public static final String ZRNSIMISIOSIRASEMONGON2X2 = "zrnsimisiosirasemongon2x2";
    public static final String ZRNSIMISIOSIRASEMONGON2X3 = "zrnsimisiosirasemongon2x3";
    public static final String ZRNSIMISIOSIRASEMONGON2X4 = "zrnsimisiosirasemongon2x4";
    public static final String ZRNSIMISIOSIRASEMONGON2X5 = "zrnsimisiosirasemongon2x5";
    public static final String ZRNTAWYNO                = "zrntawyno";
    public static final String ZRNTAWADR1KJ30           = "zrntawadr1kj30";
    public static final String ZRNTAWADR2KJ30           = "zrntawadr2kj30";
    public static final String ZRNTAWADR3KJ30           = "zrntawadr3kj30";
    public static final String ZRNTAWTELNO              = "zrntawtelno";
    public static final String ZRNSIMISIATENABUYOBI1    = "zrnsimisiatenabuyobi1";
    public static final String ZRNSIMISIATENABUYOBI2    = "zrnsimisiatenabuyobi2";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNKYKNMKJ               = "zrnkyknmkj";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNTYOUHYOUYMDWA         = "zrntyouhyouymdwa";
    public static final String ZRNSIHARAIBIWAREKI       = "zrnsiharaibiwareki";
    public static final String ZRNBANKNMKJ              = "zrnbanknmkj";
    public static final String ZRNSITENNMKJ             = "zrnsitennmkj";
    public static final String ZRNYOKINSYUMOKUMEIKANJI  = "zrnyokinsyumokumeikanji";
    public static final String ZRNKOUZANO12KETA         = "zrnkouzano12keta";
    public static final String ZRNKZMEIGINMKN           = "zrnkzmeiginmkn";
    public static final String ZRNKOUZAMASKINGMSG       = "zrnkouzamaskingmsg";
    public static final String ZRNSIMISISUMMARYBUYOBI1  = "zrnsimisisummarybuyobi1";
    public static final String ZRNSIMISISUMMARYBUYOBI2  = "zrnsimisisummarybuyobi2";
    public static final String ZRNSIMISITEKIYOURANMIDASI = "zrnsimisitekiyouranmidasi";
    public static final String ZRNSIMISIMEISAIRANMIDASI = "zrnsimisimeisairanmidasi";
    public static final String ZRNSIMISIBIKOURANMIDASI  = "zrnsimisibikouranmidasi";
    public static final String ZRNSIMISIMEISAIBUMIDASIYOBI = "zrnsimisimeisaibumidasiyobi";
    public static final String ZRNSIMISITEKIYOU1        = "zrnsimisitekiyou1";
    public static final String ZRNSIMISIKNGKMISI1       = "zrnsimisikngkmisi1";
    public static final String ZRNSIMISIKNGKMISITUUKASYU1 = "zrnsimisikngkmisituukasyu1";
    public static final String ZRNSIMISIMEISAIBIKOU1    = "zrnsimisimeisaibikou1";
    public static final String ZRNSIMISIKNGKMISIHUGOU1  = "zrnsimisikngkmisihugou1";
    public static final String ZRNSIMISIMEISAIYOBI1     = "zrnsimisimeisaiyobi1";
    public static final String ZRNSIMISITEKIYOU2        = "zrnsimisitekiyou2";
    public static final String ZRNSIMISIKNGKMISI2       = "zrnsimisikngkmisi2";
    public static final String ZRNSIMISIKNGKMISITUUKASYU2 = "zrnsimisikngkmisituukasyu2";
    public static final String ZRNSIMISIMEISAIBIKOU2    = "zrnsimisimeisaibikou2";
    public static final String ZRNSIMISIKNGKMISIHUGOU2  = "zrnsimisikngkmisihugou2";
    public static final String ZRNSIMISIMEISAIYOBI2     = "zrnsimisimeisaiyobi2";
    public static final String ZRNSIMISITEKIYOU3        = "zrnsimisitekiyou3";
    public static final String ZRNSIMISIKNGKMISI3       = "zrnsimisikngkmisi3";
    public static final String ZRNSIMISIKNGKMISITUUKASYU3 = "zrnsimisikngkmisituukasyu3";
    public static final String ZRNSIMISIMEISAIBIKOU3    = "zrnsimisimeisaibikou3";
    public static final String ZRNSIMISIKNGKMISIHUGOU3  = "zrnsimisikngkmisihugou3";
    public static final String ZRNSIMISIMEISAIYOBI3     = "zrnsimisimeisaiyobi3";
    public static final String ZRNSIMISITEKIYOU4        = "zrnsimisitekiyou4";
    public static final String ZRNSIMISIKNGKMISI4       = "zrnsimisikngkmisi4";
    public static final String ZRNSIMISIKNGKMISITUUKASYU4 = "zrnsimisikngkmisituukasyu4";
    public static final String ZRNSIMISIMEISAIBIKOU4    = "zrnsimisimeisaibikou4";
    public static final String ZRNSIMISIKNGKMISIHUGOU4  = "zrnsimisikngkmisihugou4";
    public static final String ZRNSIMISIMEISAIYOBI4     = "zrnsimisimeisaiyobi4";
    public static final String ZRNSIMISITEKIYOU5        = "zrnsimisitekiyou5";
    public static final String ZRNSIMISIKNGKMISI5       = "zrnsimisikngkmisi5";
    public static final String ZRNSIMISIKNGKMISITUUKASYU5 = "zrnsimisikngkmisituukasyu5";
    public static final String ZRNSIMISIMEISAIBIKOU5    = "zrnsimisimeisaibikou5";
    public static final String ZRNSIMISIKNGKMISIHUGOU5  = "zrnsimisikngkmisihugou5";
    public static final String ZRNSIMISIMEISAIYOBI5     = "zrnsimisimeisaiyobi5";
    public static final String ZRNSIMISITEKIYOU6        = "zrnsimisitekiyou6";
    public static final String ZRNSIMISIKNGKMISI6       = "zrnsimisikngkmisi6";
    public static final String ZRNSIMISIKNGKMISITUUKASYU6 = "zrnsimisikngkmisituukasyu6";
    public static final String ZRNSIMISIMEISAIBIKOU6    = "zrnsimisimeisaibikou6";
    public static final String ZRNSIMISIKNGKMISIHUGOU6  = "zrnsimisikngkmisihugou6";
    public static final String ZRNSIMISIMEISAIYOBI6     = "zrnsimisimeisaiyobi6";
    public static final String ZRNSIMISITEKIYOU7        = "zrnsimisitekiyou7";
    public static final String ZRNSIMISIKNGKMISI7       = "zrnsimisikngkmisi7";
    public static final String ZRNSIMISIKNGKMISITUUKASYU7 = "zrnsimisikngkmisituukasyu7";
    public static final String ZRNSIMISIMEISAIBIKOU7    = "zrnsimisimeisaibikou7";
    public static final String ZRNSIMISIKNGKMISIHUGOU7  = "zrnsimisikngkmisihugou7";
    public static final String ZRNSIMISIMEISAIYOBI7     = "zrnsimisimeisaiyobi7";
    public static final String ZRNSIMISITEKIYOU8        = "zrnsimisitekiyou8";
    public static final String ZRNSIMISIKNGKMISI8       = "zrnsimisikngkmisi8";
    public static final String ZRNSIMISIKNGKMISITUUKASYU8 = "zrnsimisikngkmisituukasyu8";
    public static final String ZRNSIMISIMEISAIBIKOU8    = "zrnsimisimeisaibikou8";
    public static final String ZRNSIMISIKNGKMISIHUGOU8  = "zrnsimisikngkmisihugou8";
    public static final String ZRNSIMISIMEISAIYOBI8     = "zrnsimisimeisaiyobi8";
    public static final String ZRNSIMISITEKIYOU9        = "zrnsimisitekiyou9";
    public static final String ZRNSIMISIKNGKMISI9       = "zrnsimisikngkmisi9";
    public static final String ZRNSIMISIKNGKMISITUUKASYU9 = "zrnsimisikngkmisituukasyu9";
    public static final String ZRNSIMISIMEISAIBIKOU9    = "zrnsimisimeisaibikou9";
    public static final String ZRNSIMISIKNGKMISIHUGOU9  = "zrnsimisikngkmisihugou9";
    public static final String ZRNSIMISIMEISAIYOBI9     = "zrnsimisimeisaiyobi9";
    public static final String ZRNSIMISITEKIYOU10       = "zrnsimisitekiyou10";
    public static final String ZRNSIMISIKNGKMISI10      = "zrnsimisikngkmisi10";
    public static final String ZRNSIMISIKNGKMISITUUKASYU10 = "zrnsimisikngkmisituukasyu10";
    public static final String ZRNSIMISIMEISAIBIKOU10   = "zrnsimisimeisaibikou10";
    public static final String ZRNSIMISIKNGKMISIHUGOU10 = "zrnsimisikngkmisihugou10";
    public static final String ZRNSIMISIMEISAIYOBI10    = "zrnsimisimeisaiyobi10";
    public static final String ZRNSIMISITEKIYOU11       = "zrnsimisitekiyou11";
    public static final String ZRNSIMISIKNGKMISI11      = "zrnsimisikngkmisi11";
    public static final String ZRNSIMISIKNGKMISITUUKASYU11 = "zrnsimisikngkmisituukasyu11";
    public static final String ZRNSIMISIMEISAIBIKOU11   = "zrnsimisimeisaibikou11";
    public static final String ZRNSIMISIKNGKMISIHUGOU11 = "zrnsimisikngkmisihugou11";
    public static final String ZRNSIMISIMEISAIYOBI11    = "zrnsimisimeisaiyobi11";
    public static final String ZRNSIMISITEKIYOU12       = "zrnsimisitekiyou12";
    public static final String ZRNSIMISIKNGKMISI12      = "zrnsimisikngkmisi12";
    public static final String ZRNSIMISIKNGKMISITUUKASYU12 = "zrnsimisikngkmisituukasyu12";
    public static final String ZRNSIMISIMEISAIBIKOU12   = "zrnsimisimeisaibikou12";
    public static final String ZRNSIMISIKNGKMISIHUGOU12 = "zrnsimisikngkmisihugou12";
    public static final String ZRNSIMISIMEISAIYOBI12    = "zrnsimisimeisaiyobi12";
    public static final String ZRNSIMISITEKIYOU13       = "zrnsimisitekiyou13";
    public static final String ZRNSIMISIKNGKMISI13      = "zrnsimisikngkmisi13";
    public static final String ZRNSIMISIKNGKMISITUUKASYU13 = "zrnsimisikngkmisituukasyu13";
    public static final String ZRNSIMISIMEISAIBIKOU13   = "zrnsimisimeisaibikou13";
    public static final String ZRNSIMISIKNGKMISIHUGOU13 = "zrnsimisikngkmisihugou13";
    public static final String ZRNSIMISIMEISAIYOBI13    = "zrnsimisimeisaiyobi13";
    public static final String ZRNSIMISITEKIYOU14       = "zrnsimisitekiyou14";
    public static final String ZRNSIMISIKNGKMISI14      = "zrnsimisikngkmisi14";
    public static final String ZRNSIMISIKNGKMISITUUKASYU14 = "zrnsimisikngkmisituukasyu14";
    public static final String ZRNSIMISIMEISAIBIKOU14   = "zrnsimisimeisaibikou14";
    public static final String ZRNSIMISIKNGKMISIHUGOU14 = "zrnsimisikngkmisihugou14";
    public static final String ZRNSIMISIMEISAIYOBI14    = "zrnsimisimeisaiyobi14";
    public static final String ZRNSIMISITEKIYOU15       = "zrnsimisitekiyou15";
    public static final String ZRNSIMISIKNGKMISI15      = "zrnsimisikngkmisi15";
    public static final String ZRNSIMISIKNGKMISITUUKASYU15 = "zrnsimisikngkmisituukasyu15";
    public static final String ZRNSIMISIMEISAIBIKOU15   = "zrnsimisimeisaibikou15";
    public static final String ZRNSIMISIKNGKMISIHUGOU15 = "zrnsimisikngkmisihugou15";
    public static final String ZRNSIMISIMEISAIYOBI15    = "zrnsimisimeisaiyobi15";
    public static final String ZRNSIMISITEKIYOU16       = "zrnsimisitekiyou16";
    public static final String ZRNSIMISIKNGKMISI16      = "zrnsimisikngkmisi16";
    public static final String ZRNSIMISIKNGKMISITUUKASYU16 = "zrnsimisikngkmisituukasyu16";
    public static final String ZRNSIMISIMEISAIBIKOU16   = "zrnsimisimeisaibikou16";
    public static final String ZRNSIMISIKNGKMISIHUGOU16 = "zrnsimisikngkmisihugou16";
    public static final String ZRNSIMISIMEISAIYOBI16    = "zrnsimisimeisaiyobi16";
    public static final String ZRNSIMISITEKIYOU17       = "zrnsimisitekiyou17";
    public static final String ZRNSIMISIKNGKMISI17      = "zrnsimisikngkmisi17";
    public static final String ZRNSIMISIKNGKMISITUUKASYU17 = "zrnsimisikngkmisituukasyu17";
    public static final String ZRNSIMISIMEISAIBIKOU17   = "zrnsimisimeisaibikou17";
    public static final String ZRNSIMISIKNGKMISIHUGOU17 = "zrnsimisikngkmisihugou17";
    public static final String ZRNSIMISIMEISAIYOBI17    = "zrnsimisimeisaiyobi17";
    public static final String ZRNSIMISITEKIYOU18       = "zrnsimisitekiyou18";
    public static final String ZRNSIMISIKNGKMISI18      = "zrnsimisikngkmisi18";
    public static final String ZRNSIMISIKNGKMISITUUKASYU18 = "zrnsimisikngkmisituukasyu18";
    public static final String ZRNSIMISIMEISAIBIKOU18   = "zrnsimisimeisaibikou18";
    public static final String ZRNSIMISIKNGKMISIHUGOU18 = "zrnsimisikngkmisihugou18";
    public static final String ZRNSIMISIMEISAIYOBI18    = "zrnsimisimeisaiyobi18";
    public static final String ZRNSIMISITEKIYOU19       = "zrnsimisitekiyou19";
    public static final String ZRNSIMISIKNGKMISI19      = "zrnsimisikngkmisi19";
    public static final String ZRNSIMISIKNGKMISITUUKASYU19 = "zrnsimisikngkmisituukasyu19";
    public static final String ZRNSIMISIMEISAIBIKOU19   = "zrnsimisimeisaibikou19";
    public static final String ZRNSIMISIKNGKMISIHUGOU19 = "zrnsimisikngkmisihugou19";
    public static final String ZRNSIMISIMEISAIYOBI19    = "zrnsimisimeisaiyobi19";
    public static final String ZRNSIMISITEKIYOU20       = "zrnsimisitekiyou20";
    public static final String ZRNSIMISIKNGKMISI20      = "zrnsimisikngkmisi20";
    public static final String ZRNSIMISIKNGKMISITUUKASYU20 = "zrnsimisikngkmisituukasyu20";
    public static final String ZRNSIMISIMEISAIBIKOU20   = "zrnsimisimeisaibikou20";
    public static final String ZRNSIMISIKNGKMISIHUGOU20 = "zrnsimisikngkmisihugou20";
    public static final String ZRNSIMISIMEISAIYOBI20    = "zrnsimisimeisaiyobi20";
    public static final String ZRNSIMISITEKIYOU21       = "zrnsimisitekiyou21";
    public static final String ZRNSIMISIKNGKMISI21      = "zrnsimisikngkmisi21";
    public static final String ZRNSIMISIKNGKMISITUUKASYU21 = "zrnsimisikngkmisituukasyu21";
    public static final String ZRNSIMISIMEISAIBIKOU21   = "zrnsimisimeisaibikou21";
    public static final String ZRNSIMISIKNGKMISIHUGOU21 = "zrnsimisikngkmisihugou21";
    public static final String ZRNSIMISIMEISAIYOBI21    = "zrnsimisimeisaiyobi21";
    public static final String ZRNSIMISITEKIYOU22       = "zrnsimisitekiyou22";
    public static final String ZRNSIMISIKNGKMISI22      = "zrnsimisikngkmisi22";
    public static final String ZRNSIMISIKNGKMISITUUKASYU22 = "zrnsimisikngkmisituukasyu22";
    public static final String ZRNSIMISIMEISAIBIKOU22   = "zrnsimisimeisaibikou22";
    public static final String ZRNSIMISIKNGKMISIHUGOU22 = "zrnsimisikngkmisihugou22";
    public static final String ZRNSIMISIMEISAIYOBI22    = "zrnsimisimeisaiyobi22";
    public static final String ZRNSIMISITEKIYOU23       = "zrnsimisitekiyou23";
    public static final String ZRNSIMISIKNGKMISI23      = "zrnsimisikngkmisi23";
    public static final String ZRNSIMISIKNGKMISITUUKASYU23 = "zrnsimisikngkmisituukasyu23";
    public static final String ZRNSIMISIMEISAIBIKOU23   = "zrnsimisimeisaibikou23";
    public static final String ZRNSIMISIKNGKMISIHUGOU23 = "zrnsimisikngkmisihugou23";
    public static final String ZRNSIMISIMEISAIYOBI23    = "zrnsimisimeisaiyobi23";
    public static final String ZRNSIMISITEKIYOU24       = "zrnsimisitekiyou24";
    public static final String ZRNSIMISIKNGKMISI24      = "zrnsimisikngkmisi24";
    public static final String ZRNSIMISIKNGKMISITUUKASYU24 = "zrnsimisikngkmisituukasyu24";
    public static final String ZRNSIMISIMEISAIBIKOU24   = "zrnsimisimeisaibikou24";
    public static final String ZRNSIMISIKNGKMISIHUGOU24 = "zrnsimisikngkmisihugou24";
    public static final String ZRNSIMISIMEISAIYOBI24    = "zrnsimisimeisaiyobi24";
    public static final String ZRNSIMISITEKIYOU25       = "zrnsimisitekiyou25";
    public static final String ZRNSIMISIKNGKMISI25      = "zrnsimisikngkmisi25";
    public static final String ZRNSIMISIKNGKMISITUUKASYU25 = "zrnsimisikngkmisituukasyu25";
    public static final String ZRNSIMISIMEISAIBIKOU25   = "zrnsimisimeisaibikou25";
    public static final String ZRNSIMISIKNGKMISIHUGOU25 = "zrnsimisikngkmisihugou25";
    public static final String ZRNSIMISIMEISAIYOBI25    = "zrnsimisimeisaiyobi25";
    public static final String ZRNSIMISIMEISAIBUYOBI1X1 = "zrnsimisimeisaibuyobi1x1";
    public static final String ZRNSIMISIMEISAIBUYOBI1X2 = "zrnsimisimeisaibuyobi1x2";
    public static final String ZRNSIMISIMEISAIBUYOBI1X3 = "zrnsimisimeisaibuyobi1x3";
    public static final String ZRNSIMISIMEISAIBUYOBI1X4 = "zrnsimisimeisaibuyobi1x4";
    public static final String ZRNSIMISIMEISAIBUYOBI1X5 = "zrnsimisimeisaibuyobi1x5";
    public static final String ZRNSIMISIMEISAIBUYOBI1X6 = "zrnsimisimeisaibuyobi1x6";
    public static final String ZRNSIMISISIGOUKEIKINGAKU = "zrnsimisisigoukeikingaku";
    public static final String ZRNSIMISISIGOUKEITUUKASYU = "zrnsimisisigoukeituukasyu";
    public static final String ZRNSIMISIMEISAIBUYOBI2   = "zrnsimisimeisaibuyobi2";
    public static final String ZRNSIMISITUUTIRANMIDASI  = "zrnsimisituutiranmidasi";
    public static final String ZRNSIMISIFREEMSG1        = "zrnsimisifreemsg1";
    public static final String ZRNSIMISIFREEMSG2        = "zrnsimisifreemsg2";
    public static final String ZRNSIMISIFREEMSG3        = "zrnsimisifreemsg3";
    public static final String ZRNSIMISIFREEMSG4        = "zrnsimisifreemsg4";
    public static final String ZRNSIMISIFREEMSG5        = "zrnsimisifreemsg5";
    public static final String ZRNSIMISIFREEMSG6        = "zrnsimisifreemsg6";
    public static final String ZRNSIMISIFREEMSG7        = "zrnsimisifreemsg7";
    public static final String ZRNSIMISIFREEMSG8        = "zrnsimisifreemsg8";
    public static final String ZRNSIMISIFREEMSG9        = "zrnsimisifreemsg9";
    public static final String ZRNSIMISIFREEMSG10       = "zrnsimisifreemsg10";
    public static final String ZRNSIMISIFREEMSG11       = "zrnsimisifreemsg11";
    public static final String ZRNSIMISIFREEMSG12       = "zrnsimisifreemsg12";
    public static final String ZRNSIMISIFREEMSG13       = "zrnsimisifreemsg13";
    public static final String ZRNSIMISIFREEMSG14       = "zrnsimisifreemsg14";
    public static final String ZRNSIMISIFREEMSG15       = "zrnsimisifreemsg15";
    public static final String ZRNSIMISIFREEMSG16       = "zrnsimisifreemsg16";
    public static final String ZRNSIMISIFREEMSG17       = "zrnsimisifreemsg17";
    public static final String ZRNSIMISIFREEMSG18       = "zrnsimisifreemsg18";
    public static final String ZRNSIMISIFREEMSG19       = "zrnsimisifreemsg19";
    public static final String ZRNSIMISIFREEMSG20       = "zrnsimisifreemsg20";
    public static final String ZRNSIMISIFREEMSG21       = "zrnsimisifreemsg21";
    public static final String ZRNSIMISIFREEMSG22       = "zrnsimisifreemsg22";
    public static final String ZRNSIMISIFREEMSG23       = "zrnsimisifreemsg23";
    public static final String ZRNSIMISIFREEMSG24       = "zrnsimisifreemsg24";
    public static final String ZRNSIMISIFREEMSG25       = "zrnsimisifreemsg25";
    public static final String ZRNSIMISIFREEMSG26       = "zrnsimisifreemsg26";
    public static final String ZRNSIMISIFREEMSG27       = "zrnsimisifreemsg27";
    public static final String ZRNSIMISIFREEMSG28       = "zrnsimisifreemsg28";
    public static final String ZRNSIMISIFREEMSG29       = "zrnsimisifreemsg29";
    public static final String ZRNSIMISIFREEMSG30       = "zrnsimisifreemsg30";
    public static final String ZRNSIMISIFREEMSG31       = "zrnsimisifreemsg31";
    public static final String ZRNSIMISIFREEMSG32       = "zrnsimisifreemsg32";
    public static final String ZRNSIMISIFREEMSG33       = "zrnsimisifreemsg33";
    public static final String ZRNSIMISIFREEMSG34       = "zrnsimisifreemsg34";
    public static final String ZRNSIMISIFREEMSG35       = "zrnsimisifreemsg35";
    public static final String ZRNSIMISIFREEMSG36       = "zrnsimisifreemsg36";
    public static final String ZRNSIMISIFREEMSG37       = "zrnsimisifreemsg37";
    public static final String ZRNSIMISIFREEMSG38       = "zrnsimisifreemsg38";
    public static final String ZRNSIMISIFREEMSG39       = "zrnsimisifreemsg39";
    public static final String ZRNSIMISIFREEMSG40       = "zrnsimisifreemsg40";
    public static final String ZRNSIMISIFREEMSG41       = "zrnsimisifreemsg41";
    public static final String ZRNSIMISIFREEMSG42       = "zrnsimisifreemsg42";
    public static final String ZRNSIMISIFREEMSG43       = "zrnsimisifreemsg43";
    public static final String ZRNSIMISIFREEMSG44       = "zrnsimisifreemsg44";
    public static final String ZRNSIMISIFREEMSG45       = "zrnsimisifreemsg45";
    public static final String ZRNSIMISIFREEMSG46       = "zrnsimisifreemsg46";
    public static final String ZRNSIMISIOSIRASEMONGON3X1 = "zrnsimisiosirasemongon3x1";
    public static final String ZRNSIMISIOSIRASEMONGON3X2 = "zrnsimisiosirasemongon3x2";
    public static final String ZRNSIMISISYNYKNGK        = "zrnsimisisynykngk";
    public static final String ZRNSIMISIHTYKEIHI        = "zrnsimisihtykeihi";
    public static final String ZRNKZTKGK                = "zrnkztkgk";
    public static final String ZRNZEITRATKIKBN          = "zrnzeitratkikbn";
    public static final String ZRNKYKHENKOUUMUKBN       = "zrnkykhenkouumukbn";
    public static final String ZRNSHRKYKHTYKEIHI        = "zrnshrkykhtykeihi";
    public static final String ZRNSIMISIMEISAIBUYOBI3X1 = "zrnsimisimeisaibuyobi3x1";
    public static final String ZRNSIMISIMEISAIBUYOBI3X2 = "zrnsimisimeisaibuyobi3x2";

    private final PKZT_SiShrdetailRn primaryKey;

    public GenZT_SiShrdetailRn() {
        primaryKey = new PKZT_SiShrdetailRn();
    }

    public GenZT_SiShrdetailRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsikibetuno
    ) {
        primaryKey = new PKZT_SiShrdetailRn(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_SiShrdetailRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SiShrdetailRn> getMetaClass() {
        return QZT_SiShrdetailRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_SiShrdetailRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_SiShrdetailRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SiShrdetailRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_SiShrdetailRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrnsyodouhuukbn;

    @Column(name=GenZT_SiShrdetailRn.ZRNSYODOUHUUKBN)
    public String getZrnsyodouhuukbn() {
        return zrnsyodouhuukbn;
    }

    public void setZrnsyodouhuukbn(String pZrnsyodouhuukbn) {
        zrnsyodouhuukbn = pZrnsyodouhuukbn;
    }

    @Id
    @Column(name=GenZT_SiShrdetailRn.ZRNSIKIBETUNO)
    public String getZrnsikibetuno() {
        return getPrimaryKey().getZrnsikibetuno();
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        getPrimaryKey().setZrnsikibetuno(pZrnsikibetuno);
    }

    private String zrnsikytkmkyobi1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIKYTKMKYOBI1)
    public String getZrnsikytkmkyobi1() {
        return zrnsikytkmkyobi1;
    }

    public void setZrnsikytkmkyobi1(String pZrnsikytkmkyobi1) {
        zrnsikytkmkyobi1 = pZrnsikytkmkyobi1;
    }

    private String zrnshskyno;

    @Column(name=GenZT_SiShrdetailRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_SiShrdetailRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_SiShrdetailRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_SiShrdetailRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkjsimisi;

    @Column(name=GenZT_SiShrdetailRn.ZRNSHSNMKJSIMISI)
    public String getZrnshsnmkjsimisi() {
        return zrnshsnmkjsimisi;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkjsimisi(String pZrnshsnmkjsimisi) {
        zrnshsnmkjsimisi = pZrnshsnmkjsimisi;
    }

    private String zrnsimisituutimei;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITUUTIMEI)
    public String getZrnsimisituutimei() {
        return zrnsimisituutimei;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisituutimei(String pZrnsimisituutimei) {
        zrnsimisituutimei = pZrnsimisituutimei;
    }

    private String zrnsimisiosirasemongon1x1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIOSIRASEMONGON1X1)
    public String getZrnsimisiosirasemongon1x1() {
        return zrnsimisiosirasemongon1x1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisiosirasemongon1x1(String pZrnsimisiosirasemongon1x1) {
        zrnsimisiosirasemongon1x1 = pZrnsimisiosirasemongon1x1;
    }

    private String zrnsimisiosirasemongon1x2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIOSIRASEMONGON1X2)
    public String getZrnsimisiosirasemongon1x2() {
        return zrnsimisiosirasemongon1x2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisiosirasemongon1x2(String pZrnsimisiosirasemongon1x2) {
        zrnsimisiosirasemongon1x2 = pZrnsimisiosirasemongon1x2;
    }

    private String zrnsimisiosirasemongon2x1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIOSIRASEMONGON2X1)
    public String getZrnsimisiosirasemongon2x1() {
        return zrnsimisiosirasemongon2x1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisiosirasemongon2x1(String pZrnsimisiosirasemongon2x1) {
        zrnsimisiosirasemongon2x1 = pZrnsimisiosirasemongon2x1;
    }

    private String zrnsimisiosirasemongon2x2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIOSIRASEMONGON2X2)
    public String getZrnsimisiosirasemongon2x2() {
        return zrnsimisiosirasemongon2x2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisiosirasemongon2x2(String pZrnsimisiosirasemongon2x2) {
        zrnsimisiosirasemongon2x2 = pZrnsimisiosirasemongon2x2;
    }

    private String zrnsimisiosirasemongon2x3;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIOSIRASEMONGON2X3)
    public String getZrnsimisiosirasemongon2x3() {
        return zrnsimisiosirasemongon2x3;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisiosirasemongon2x3(String pZrnsimisiosirasemongon2x3) {
        zrnsimisiosirasemongon2x3 = pZrnsimisiosirasemongon2x3;
    }

    private String zrnsimisiosirasemongon2x4;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIOSIRASEMONGON2X4)
    public String getZrnsimisiosirasemongon2x4() {
        return zrnsimisiosirasemongon2x4;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisiosirasemongon2x4(String pZrnsimisiosirasemongon2x4) {
        zrnsimisiosirasemongon2x4 = pZrnsimisiosirasemongon2x4;
    }

    private String zrnsimisiosirasemongon2x5;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIOSIRASEMONGON2X5)
    public String getZrnsimisiosirasemongon2x5() {
        return zrnsimisiosirasemongon2x5;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisiosirasemongon2x5(String pZrnsimisiosirasemongon2x5) {
        zrnsimisiosirasemongon2x5 = pZrnsimisiosirasemongon2x5;
    }

    private String zrntawyno;

    @Column(name=GenZT_SiShrdetailRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj30;

    @Column(name=GenZT_SiShrdetailRn.ZRNTAWADR1KJ30)
    public String getZrntawadr1kj30() {
        return zrntawadr1kj30;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj30(String pZrntawadr1kj30) {
        zrntawadr1kj30 = pZrntawadr1kj30;
    }

    private String zrntawadr2kj30;

    @Column(name=GenZT_SiShrdetailRn.ZRNTAWADR2KJ30)
    public String getZrntawadr2kj30() {
        return zrntawadr2kj30;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj30(String pZrntawadr2kj30) {
        zrntawadr2kj30 = pZrntawadr2kj30;
    }

    private String zrntawadr3kj30;

    @Column(name=GenZT_SiShrdetailRn.ZRNTAWADR3KJ30)
    public String getZrntawadr3kj30() {
        return zrntawadr3kj30;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj30(String pZrntawadr3kj30) {
        zrntawadr3kj30 = pZrntawadr3kj30;
    }

    private String zrntawtelno;

    @Column(name=GenZT_SiShrdetailRn.ZRNTAWTELNO)
    public String getZrntawtelno() {
        return zrntawtelno;
    }

    public void setZrntawtelno(String pZrntawtelno) {
        zrntawtelno = pZrntawtelno;
    }

    private String zrnsimisiatenabuyobi1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIATENABUYOBI1)
    public String getZrnsimisiatenabuyobi1() {
        return zrnsimisiatenabuyobi1;
    }

    public void setZrnsimisiatenabuyobi1(String pZrnsimisiatenabuyobi1) {
        zrnsimisiatenabuyobi1 = pZrnsimisiatenabuyobi1;
    }

    private String zrnsimisiatenabuyobi2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIATENABUYOBI2)
    public String getZrnsimisiatenabuyobi2() {
        return zrnsimisiatenabuyobi2;
    }

    public void setZrnsimisiatenabuyobi2(String pZrnsimisiatenabuyobi2) {
        zrnsimisiatenabuyobi2 = pZrnsimisiatenabuyobi2;
    }

    private String zrnsyono2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnkyknmkj;

    @Column(name=GenZT_SiShrdetailRn.ZRNKYKNMKJ)
    public String getZrnkyknmkj() {
        return zrnkyknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj(String pZrnkyknmkj) {
        zrnkyknmkj = pZrnkyknmkj;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_SiShrdetailRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrntyouhyouymdwa;

    @Column(name=GenZT_SiShrdetailRn.ZRNTYOUHYOUYMDWA)
    public String getZrntyouhyouymdwa() {
        return zrntyouhyouymdwa;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdwa(String pZrntyouhyouymdwa) {
        zrntyouhyouymdwa = pZrntyouhyouymdwa;
    }

    private String zrnsiharaibiwareki;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIHARAIBIWAREKI)
    public String getZrnsiharaibiwareki() {
        return zrnsiharaibiwareki;
    }

    @DataConvert("toMultiByte")
    public void setZrnsiharaibiwareki(String pZrnsiharaibiwareki) {
        zrnsiharaibiwareki = pZrnsiharaibiwareki;
    }

    private String zrnbanknmkj;

    @Column(name=GenZT_SiShrdetailRn.ZRNBANKNMKJ)
    public String getZrnbanknmkj() {
        return zrnbanknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnbanknmkj(String pZrnbanknmkj) {
        zrnbanknmkj = pZrnbanknmkj;
    }

    private String zrnsitennmkj;

    @Column(name=GenZT_SiShrdetailRn.ZRNSITENNMKJ)
    public String getZrnsitennmkj() {
        return zrnsitennmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnsitennmkj(String pZrnsitennmkj) {
        zrnsitennmkj = pZrnsitennmkj;
    }

    private String zrnyokinsyumokumeikanji;

    @Column(name=GenZT_SiShrdetailRn.ZRNYOKINSYUMOKUMEIKANJI)
    public String getZrnyokinsyumokumeikanji() {
        return zrnyokinsyumokumeikanji;
    }

    @DataConvert("toMultiByte")
    public void setZrnyokinsyumokumeikanji(String pZrnyokinsyumokumeikanji) {
        zrnyokinsyumokumeikanji = pZrnyokinsyumokumeikanji;
    }

    private String zrnkouzano12keta;

    @Column(name=GenZT_SiShrdetailRn.ZRNKOUZANO12KETA)
    public String getZrnkouzano12keta() {
        return zrnkouzano12keta;
    }

    public void setZrnkouzano12keta(String pZrnkouzano12keta) {
        zrnkouzano12keta = pZrnkouzano12keta;
    }

    private String zrnkzmeiginmkn;

    @Column(name=GenZT_SiShrdetailRn.ZRNKZMEIGINMKN)
    public String getZrnkzmeiginmkn() {
        return zrnkzmeiginmkn;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzmeiginmkn(String pZrnkzmeiginmkn) {
        zrnkzmeiginmkn = pZrnkzmeiginmkn;
    }

    private String zrnkouzamaskingmsg;

    @Column(name=GenZT_SiShrdetailRn.ZRNKOUZAMASKINGMSG)
    public String getZrnkouzamaskingmsg() {
        return zrnkouzamaskingmsg;
    }

    @DataConvert("toMultiByte")
    public void setZrnkouzamaskingmsg(String pZrnkouzamaskingmsg) {
        zrnkouzamaskingmsg = pZrnkouzamaskingmsg;
    }

    private String zrnsimisisummarybuyobi1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISISUMMARYBUYOBI1)
    public String getZrnsimisisummarybuyobi1() {
        return zrnsimisisummarybuyobi1;
    }

    public void setZrnsimisisummarybuyobi1(String pZrnsimisisummarybuyobi1) {
        zrnsimisisummarybuyobi1 = pZrnsimisisummarybuyobi1;
    }

    private String zrnsimisisummarybuyobi2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISISUMMARYBUYOBI2)
    public String getZrnsimisisummarybuyobi2() {
        return zrnsimisisummarybuyobi2;
    }

    public void setZrnsimisisummarybuyobi2(String pZrnsimisisummarybuyobi2) {
        zrnsimisisummarybuyobi2 = pZrnsimisisummarybuyobi2;
    }

    private String zrnsimisitekiyouranmidasi;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOURANMIDASI)
    public String getZrnsimisitekiyouranmidasi() {
        return zrnsimisitekiyouranmidasi;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyouranmidasi(String pZrnsimisitekiyouranmidasi) {
        zrnsimisitekiyouranmidasi = pZrnsimisitekiyouranmidasi;
    }

    private String zrnsimisimeisairanmidasi;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIRANMIDASI)
    public String getZrnsimisimeisairanmidasi() {
        return zrnsimisimeisairanmidasi;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisairanmidasi(String pZrnsimisimeisairanmidasi) {
        zrnsimisimeisairanmidasi = pZrnsimisimeisairanmidasi;
    }

    private String zrnsimisibikouranmidasi;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIBIKOURANMIDASI)
    public String getZrnsimisibikouranmidasi() {
        return zrnsimisibikouranmidasi;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisibikouranmidasi(String pZrnsimisibikouranmidasi) {
        zrnsimisibikouranmidasi = pZrnsimisibikouranmidasi;
    }

    private String zrnsimisimeisaibumidasiyobi;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBUMIDASIYOBI)
    public String getZrnsimisimeisaibumidasiyobi() {
        return zrnsimisimeisaibumidasiyobi;
    }

    public void setZrnsimisimeisaibumidasiyobi(String pZrnsimisimeisaibumidasiyobi) {
        zrnsimisimeisaibumidasiyobi = pZrnsimisimeisaibumidasiyobi;
    }

    private String zrnsimisitekiyou1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU1)
    public String getZrnsimisitekiyou1() {
        return zrnsimisitekiyou1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou1(String pZrnsimisitekiyou1) {
        zrnsimisitekiyou1 = pZrnsimisitekiyou1;
    }

    private String zrnsimisikngkmisi1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI1)
    public String getZrnsimisikngkmisi1() {
        return zrnsimisikngkmisi1;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi1(String pZrnsimisikngkmisi1) {
        zrnsimisikngkmisi1 = pZrnsimisikngkmisi1;
    }

    private String zrnsimisikngkmisituukasyu1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU1)
    public String getZrnsimisikngkmisituukasyu1() {
        return zrnsimisikngkmisituukasyu1;
    }

    public void setZrnsimisikngkmisituukasyu1(String pZrnsimisikngkmisituukasyu1) {
        zrnsimisikngkmisituukasyu1 = pZrnsimisikngkmisituukasyu1;
    }

    private String zrnsimisimeisaibikou1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU1)
    public String getZrnsimisimeisaibikou1() {
        return zrnsimisimeisaibikou1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou1(String pZrnsimisimeisaibikou1) {
        zrnsimisimeisaibikou1 = pZrnsimisimeisaibikou1;
    }

    private String zrnsimisikngkmisihugou1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU1)
    public String getZrnsimisikngkmisihugou1() {
        return zrnsimisikngkmisihugou1;
    }

    public void setZrnsimisikngkmisihugou1(String pZrnsimisikngkmisihugou1) {
        zrnsimisikngkmisihugou1 = pZrnsimisikngkmisihugou1;
    }

    private String zrnsimisimeisaiyobi1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI1)
    public String getZrnsimisimeisaiyobi1() {
        return zrnsimisimeisaiyobi1;
    }

    public void setZrnsimisimeisaiyobi1(String pZrnsimisimeisaiyobi1) {
        zrnsimisimeisaiyobi1 = pZrnsimisimeisaiyobi1;
    }

    private String zrnsimisitekiyou2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU2)
    public String getZrnsimisitekiyou2() {
        return zrnsimisitekiyou2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou2(String pZrnsimisitekiyou2) {
        zrnsimisitekiyou2 = pZrnsimisitekiyou2;
    }

    private String zrnsimisikngkmisi2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI2)
    public String getZrnsimisikngkmisi2() {
        return zrnsimisikngkmisi2;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi2(String pZrnsimisikngkmisi2) {
        zrnsimisikngkmisi2 = pZrnsimisikngkmisi2;
    }

    private String zrnsimisikngkmisituukasyu2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU2)
    public String getZrnsimisikngkmisituukasyu2() {
        return zrnsimisikngkmisituukasyu2;
    }

    public void setZrnsimisikngkmisituukasyu2(String pZrnsimisikngkmisituukasyu2) {
        zrnsimisikngkmisituukasyu2 = pZrnsimisikngkmisituukasyu2;
    }

    private String zrnsimisimeisaibikou2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU2)
    public String getZrnsimisimeisaibikou2() {
        return zrnsimisimeisaibikou2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou2(String pZrnsimisimeisaibikou2) {
        zrnsimisimeisaibikou2 = pZrnsimisimeisaibikou2;
    }

    private String zrnsimisikngkmisihugou2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU2)
    public String getZrnsimisikngkmisihugou2() {
        return zrnsimisikngkmisihugou2;
    }

    public void setZrnsimisikngkmisihugou2(String pZrnsimisikngkmisihugou2) {
        zrnsimisikngkmisihugou2 = pZrnsimisikngkmisihugou2;
    }

    private String zrnsimisimeisaiyobi2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI2)
    public String getZrnsimisimeisaiyobi2() {
        return zrnsimisimeisaiyobi2;
    }

    public void setZrnsimisimeisaiyobi2(String pZrnsimisimeisaiyobi2) {
        zrnsimisimeisaiyobi2 = pZrnsimisimeisaiyobi2;
    }

    private String zrnsimisitekiyou3;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU3)
    public String getZrnsimisitekiyou3() {
        return zrnsimisitekiyou3;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou3(String pZrnsimisitekiyou3) {
        zrnsimisitekiyou3 = pZrnsimisitekiyou3;
    }

    private String zrnsimisikngkmisi3;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI3)
    public String getZrnsimisikngkmisi3() {
        return zrnsimisikngkmisi3;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi3(String pZrnsimisikngkmisi3) {
        zrnsimisikngkmisi3 = pZrnsimisikngkmisi3;
    }

    private String zrnsimisikngkmisituukasyu3;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU3)
    public String getZrnsimisikngkmisituukasyu3() {
        return zrnsimisikngkmisituukasyu3;
    }

    public void setZrnsimisikngkmisituukasyu3(String pZrnsimisikngkmisituukasyu3) {
        zrnsimisikngkmisituukasyu3 = pZrnsimisikngkmisituukasyu3;
    }

    private String zrnsimisimeisaibikou3;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU3)
    public String getZrnsimisimeisaibikou3() {
        return zrnsimisimeisaibikou3;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou3(String pZrnsimisimeisaibikou3) {
        zrnsimisimeisaibikou3 = pZrnsimisimeisaibikou3;
    }

    private String zrnsimisikngkmisihugou3;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU3)
    public String getZrnsimisikngkmisihugou3() {
        return zrnsimisikngkmisihugou3;
    }

    public void setZrnsimisikngkmisihugou3(String pZrnsimisikngkmisihugou3) {
        zrnsimisikngkmisihugou3 = pZrnsimisikngkmisihugou3;
    }

    private String zrnsimisimeisaiyobi3;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI3)
    public String getZrnsimisimeisaiyobi3() {
        return zrnsimisimeisaiyobi3;
    }

    public void setZrnsimisimeisaiyobi3(String pZrnsimisimeisaiyobi3) {
        zrnsimisimeisaiyobi3 = pZrnsimisimeisaiyobi3;
    }

    private String zrnsimisitekiyou4;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU4)
    public String getZrnsimisitekiyou4() {
        return zrnsimisitekiyou4;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou4(String pZrnsimisitekiyou4) {
        zrnsimisitekiyou4 = pZrnsimisitekiyou4;
    }

    private String zrnsimisikngkmisi4;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI4)
    public String getZrnsimisikngkmisi4() {
        return zrnsimisikngkmisi4;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi4(String pZrnsimisikngkmisi4) {
        zrnsimisikngkmisi4 = pZrnsimisikngkmisi4;
    }

    private String zrnsimisikngkmisituukasyu4;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU4)
    public String getZrnsimisikngkmisituukasyu4() {
        return zrnsimisikngkmisituukasyu4;
    }

    public void setZrnsimisikngkmisituukasyu4(String pZrnsimisikngkmisituukasyu4) {
        zrnsimisikngkmisituukasyu4 = pZrnsimisikngkmisituukasyu4;
    }

    private String zrnsimisimeisaibikou4;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU4)
    public String getZrnsimisimeisaibikou4() {
        return zrnsimisimeisaibikou4;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou4(String pZrnsimisimeisaibikou4) {
        zrnsimisimeisaibikou4 = pZrnsimisimeisaibikou4;
    }

    private String zrnsimisikngkmisihugou4;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU4)
    public String getZrnsimisikngkmisihugou4() {
        return zrnsimisikngkmisihugou4;
    }

    public void setZrnsimisikngkmisihugou4(String pZrnsimisikngkmisihugou4) {
        zrnsimisikngkmisihugou4 = pZrnsimisikngkmisihugou4;
    }

    private String zrnsimisimeisaiyobi4;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI4)
    public String getZrnsimisimeisaiyobi4() {
        return zrnsimisimeisaiyobi4;
    }

    public void setZrnsimisimeisaiyobi4(String pZrnsimisimeisaiyobi4) {
        zrnsimisimeisaiyobi4 = pZrnsimisimeisaiyobi4;
    }

    private String zrnsimisitekiyou5;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU5)
    public String getZrnsimisitekiyou5() {
        return zrnsimisitekiyou5;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou5(String pZrnsimisitekiyou5) {
        zrnsimisitekiyou5 = pZrnsimisitekiyou5;
    }

    private String zrnsimisikngkmisi5;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI5)
    public String getZrnsimisikngkmisi5() {
        return zrnsimisikngkmisi5;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi5(String pZrnsimisikngkmisi5) {
        zrnsimisikngkmisi5 = pZrnsimisikngkmisi5;
    }

    private String zrnsimisikngkmisituukasyu5;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU5)
    public String getZrnsimisikngkmisituukasyu5() {
        return zrnsimisikngkmisituukasyu5;
    }

    public void setZrnsimisikngkmisituukasyu5(String pZrnsimisikngkmisituukasyu5) {
        zrnsimisikngkmisituukasyu5 = pZrnsimisikngkmisituukasyu5;
    }

    private String zrnsimisimeisaibikou5;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU5)
    public String getZrnsimisimeisaibikou5() {
        return zrnsimisimeisaibikou5;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou5(String pZrnsimisimeisaibikou5) {
        zrnsimisimeisaibikou5 = pZrnsimisimeisaibikou5;
    }

    private String zrnsimisikngkmisihugou5;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU5)
    public String getZrnsimisikngkmisihugou5() {
        return zrnsimisikngkmisihugou5;
    }

    public void setZrnsimisikngkmisihugou5(String pZrnsimisikngkmisihugou5) {
        zrnsimisikngkmisihugou5 = pZrnsimisikngkmisihugou5;
    }

    private String zrnsimisimeisaiyobi5;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI5)
    public String getZrnsimisimeisaiyobi5() {
        return zrnsimisimeisaiyobi5;
    }

    public void setZrnsimisimeisaiyobi5(String pZrnsimisimeisaiyobi5) {
        zrnsimisimeisaiyobi5 = pZrnsimisimeisaiyobi5;
    }

    private String zrnsimisitekiyou6;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU6)
    public String getZrnsimisitekiyou6() {
        return zrnsimisitekiyou6;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou6(String pZrnsimisitekiyou6) {
        zrnsimisitekiyou6 = pZrnsimisitekiyou6;
    }

    private String zrnsimisikngkmisi6;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI6)
    public String getZrnsimisikngkmisi6() {
        return zrnsimisikngkmisi6;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi6(String pZrnsimisikngkmisi6) {
        zrnsimisikngkmisi6 = pZrnsimisikngkmisi6;
    }

    private String zrnsimisikngkmisituukasyu6;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU6)
    public String getZrnsimisikngkmisituukasyu6() {
        return zrnsimisikngkmisituukasyu6;
    }

    public void setZrnsimisikngkmisituukasyu6(String pZrnsimisikngkmisituukasyu6) {
        zrnsimisikngkmisituukasyu6 = pZrnsimisikngkmisituukasyu6;
    }

    private String zrnsimisimeisaibikou6;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU6)
    public String getZrnsimisimeisaibikou6() {
        return zrnsimisimeisaibikou6;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou6(String pZrnsimisimeisaibikou6) {
        zrnsimisimeisaibikou6 = pZrnsimisimeisaibikou6;
    }

    private String zrnsimisikngkmisihugou6;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU6)
    public String getZrnsimisikngkmisihugou6() {
        return zrnsimisikngkmisihugou6;
    }

    public void setZrnsimisikngkmisihugou6(String pZrnsimisikngkmisihugou6) {
        zrnsimisikngkmisihugou6 = pZrnsimisikngkmisihugou6;
    }

    private String zrnsimisimeisaiyobi6;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI6)
    public String getZrnsimisimeisaiyobi6() {
        return zrnsimisimeisaiyobi6;
    }

    public void setZrnsimisimeisaiyobi6(String pZrnsimisimeisaiyobi6) {
        zrnsimisimeisaiyobi6 = pZrnsimisimeisaiyobi6;
    }

    private String zrnsimisitekiyou7;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU7)
    public String getZrnsimisitekiyou7() {
        return zrnsimisitekiyou7;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou7(String pZrnsimisitekiyou7) {
        zrnsimisitekiyou7 = pZrnsimisitekiyou7;
    }

    private String zrnsimisikngkmisi7;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI7)
    public String getZrnsimisikngkmisi7() {
        return zrnsimisikngkmisi7;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi7(String pZrnsimisikngkmisi7) {
        zrnsimisikngkmisi7 = pZrnsimisikngkmisi7;
    }

    private String zrnsimisikngkmisituukasyu7;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU7)
    public String getZrnsimisikngkmisituukasyu7() {
        return zrnsimisikngkmisituukasyu7;
    }

    public void setZrnsimisikngkmisituukasyu7(String pZrnsimisikngkmisituukasyu7) {
        zrnsimisikngkmisituukasyu7 = pZrnsimisikngkmisituukasyu7;
    }

    private String zrnsimisimeisaibikou7;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU7)
    public String getZrnsimisimeisaibikou7() {
        return zrnsimisimeisaibikou7;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou7(String pZrnsimisimeisaibikou7) {
        zrnsimisimeisaibikou7 = pZrnsimisimeisaibikou7;
    }

    private String zrnsimisikngkmisihugou7;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU7)
    public String getZrnsimisikngkmisihugou7() {
        return zrnsimisikngkmisihugou7;
    }

    public void setZrnsimisikngkmisihugou7(String pZrnsimisikngkmisihugou7) {
        zrnsimisikngkmisihugou7 = pZrnsimisikngkmisihugou7;
    }

    private String zrnsimisimeisaiyobi7;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI7)
    public String getZrnsimisimeisaiyobi7() {
        return zrnsimisimeisaiyobi7;
    }

    public void setZrnsimisimeisaiyobi7(String pZrnsimisimeisaiyobi7) {
        zrnsimisimeisaiyobi7 = pZrnsimisimeisaiyobi7;
    }

    private String zrnsimisitekiyou8;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU8)
    public String getZrnsimisitekiyou8() {
        return zrnsimisitekiyou8;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou8(String pZrnsimisitekiyou8) {
        zrnsimisitekiyou8 = pZrnsimisitekiyou8;
    }

    private String zrnsimisikngkmisi8;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI8)
    public String getZrnsimisikngkmisi8() {
        return zrnsimisikngkmisi8;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi8(String pZrnsimisikngkmisi8) {
        zrnsimisikngkmisi8 = pZrnsimisikngkmisi8;
    }

    private String zrnsimisikngkmisituukasyu8;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU8)
    public String getZrnsimisikngkmisituukasyu8() {
        return zrnsimisikngkmisituukasyu8;
    }

    public void setZrnsimisikngkmisituukasyu8(String pZrnsimisikngkmisituukasyu8) {
        zrnsimisikngkmisituukasyu8 = pZrnsimisikngkmisituukasyu8;
    }

    private String zrnsimisimeisaibikou8;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU8)
    public String getZrnsimisimeisaibikou8() {
        return zrnsimisimeisaibikou8;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou8(String pZrnsimisimeisaibikou8) {
        zrnsimisimeisaibikou8 = pZrnsimisimeisaibikou8;
    }

    private String zrnsimisikngkmisihugou8;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU8)
    public String getZrnsimisikngkmisihugou8() {
        return zrnsimisikngkmisihugou8;
    }

    public void setZrnsimisikngkmisihugou8(String pZrnsimisikngkmisihugou8) {
        zrnsimisikngkmisihugou8 = pZrnsimisikngkmisihugou8;
    }

    private String zrnsimisimeisaiyobi8;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI8)
    public String getZrnsimisimeisaiyobi8() {
        return zrnsimisimeisaiyobi8;
    }

    public void setZrnsimisimeisaiyobi8(String pZrnsimisimeisaiyobi8) {
        zrnsimisimeisaiyobi8 = pZrnsimisimeisaiyobi8;
    }

    private String zrnsimisitekiyou9;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU9)
    public String getZrnsimisitekiyou9() {
        return zrnsimisitekiyou9;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou9(String pZrnsimisitekiyou9) {
        zrnsimisitekiyou9 = pZrnsimisitekiyou9;
    }

    private String zrnsimisikngkmisi9;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI9)
    public String getZrnsimisikngkmisi9() {
        return zrnsimisikngkmisi9;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi9(String pZrnsimisikngkmisi9) {
        zrnsimisikngkmisi9 = pZrnsimisikngkmisi9;
    }

    private String zrnsimisikngkmisituukasyu9;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU9)
    public String getZrnsimisikngkmisituukasyu9() {
        return zrnsimisikngkmisituukasyu9;
    }

    public void setZrnsimisikngkmisituukasyu9(String pZrnsimisikngkmisituukasyu9) {
        zrnsimisikngkmisituukasyu9 = pZrnsimisikngkmisituukasyu9;
    }

    private String zrnsimisimeisaibikou9;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU9)
    public String getZrnsimisimeisaibikou9() {
        return zrnsimisimeisaibikou9;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou9(String pZrnsimisimeisaibikou9) {
        zrnsimisimeisaibikou9 = pZrnsimisimeisaibikou9;
    }

    private String zrnsimisikngkmisihugou9;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU9)
    public String getZrnsimisikngkmisihugou9() {
        return zrnsimisikngkmisihugou9;
    }

    public void setZrnsimisikngkmisihugou9(String pZrnsimisikngkmisihugou9) {
        zrnsimisikngkmisihugou9 = pZrnsimisikngkmisihugou9;
    }

    private String zrnsimisimeisaiyobi9;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI9)
    public String getZrnsimisimeisaiyobi9() {
        return zrnsimisimeisaiyobi9;
    }

    public void setZrnsimisimeisaiyobi9(String pZrnsimisimeisaiyobi9) {
        zrnsimisimeisaiyobi9 = pZrnsimisimeisaiyobi9;
    }

    private String zrnsimisitekiyou10;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU10)
    public String getZrnsimisitekiyou10() {
        return zrnsimisitekiyou10;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou10(String pZrnsimisitekiyou10) {
        zrnsimisitekiyou10 = pZrnsimisitekiyou10;
    }

    private String zrnsimisikngkmisi10;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI10)
    public String getZrnsimisikngkmisi10() {
        return zrnsimisikngkmisi10;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi10(String pZrnsimisikngkmisi10) {
        zrnsimisikngkmisi10 = pZrnsimisikngkmisi10;
    }

    private String zrnsimisikngkmisituukasyu10;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU10)
    public String getZrnsimisikngkmisituukasyu10() {
        return zrnsimisikngkmisituukasyu10;
    }

    public void setZrnsimisikngkmisituukasyu10(String pZrnsimisikngkmisituukasyu10) {
        zrnsimisikngkmisituukasyu10 = pZrnsimisikngkmisituukasyu10;
    }

    private String zrnsimisimeisaibikou10;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU10)
    public String getZrnsimisimeisaibikou10() {
        return zrnsimisimeisaibikou10;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou10(String pZrnsimisimeisaibikou10) {
        zrnsimisimeisaibikou10 = pZrnsimisimeisaibikou10;
    }

    private String zrnsimisikngkmisihugou10;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU10)
    public String getZrnsimisikngkmisihugou10() {
        return zrnsimisikngkmisihugou10;
    }

    public void setZrnsimisikngkmisihugou10(String pZrnsimisikngkmisihugou10) {
        zrnsimisikngkmisihugou10 = pZrnsimisikngkmisihugou10;
    }

    private String zrnsimisimeisaiyobi10;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI10)
    public String getZrnsimisimeisaiyobi10() {
        return zrnsimisimeisaiyobi10;
    }

    public void setZrnsimisimeisaiyobi10(String pZrnsimisimeisaiyobi10) {
        zrnsimisimeisaiyobi10 = pZrnsimisimeisaiyobi10;
    }

    private String zrnsimisitekiyou11;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU11)
    public String getZrnsimisitekiyou11() {
        return zrnsimisitekiyou11;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou11(String pZrnsimisitekiyou11) {
        zrnsimisitekiyou11 = pZrnsimisitekiyou11;
    }

    private String zrnsimisikngkmisi11;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI11)
    public String getZrnsimisikngkmisi11() {
        return zrnsimisikngkmisi11;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi11(String pZrnsimisikngkmisi11) {
        zrnsimisikngkmisi11 = pZrnsimisikngkmisi11;
    }

    private String zrnsimisikngkmisituukasyu11;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU11)
    public String getZrnsimisikngkmisituukasyu11() {
        return zrnsimisikngkmisituukasyu11;
    }

    public void setZrnsimisikngkmisituukasyu11(String pZrnsimisikngkmisituukasyu11) {
        zrnsimisikngkmisituukasyu11 = pZrnsimisikngkmisituukasyu11;
    }

    private String zrnsimisimeisaibikou11;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU11)
    public String getZrnsimisimeisaibikou11() {
        return zrnsimisimeisaibikou11;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou11(String pZrnsimisimeisaibikou11) {
        zrnsimisimeisaibikou11 = pZrnsimisimeisaibikou11;
    }

    private String zrnsimisikngkmisihugou11;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU11)
    public String getZrnsimisikngkmisihugou11() {
        return zrnsimisikngkmisihugou11;
    }

    public void setZrnsimisikngkmisihugou11(String pZrnsimisikngkmisihugou11) {
        zrnsimisikngkmisihugou11 = pZrnsimisikngkmisihugou11;
    }

    private String zrnsimisimeisaiyobi11;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI11)
    public String getZrnsimisimeisaiyobi11() {
        return zrnsimisimeisaiyobi11;
    }

    public void setZrnsimisimeisaiyobi11(String pZrnsimisimeisaiyobi11) {
        zrnsimisimeisaiyobi11 = pZrnsimisimeisaiyobi11;
    }

    private String zrnsimisitekiyou12;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU12)
    public String getZrnsimisitekiyou12() {
        return zrnsimisitekiyou12;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou12(String pZrnsimisitekiyou12) {
        zrnsimisitekiyou12 = pZrnsimisitekiyou12;
    }

    private String zrnsimisikngkmisi12;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI12)
    public String getZrnsimisikngkmisi12() {
        return zrnsimisikngkmisi12;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi12(String pZrnsimisikngkmisi12) {
        zrnsimisikngkmisi12 = pZrnsimisikngkmisi12;
    }

    private String zrnsimisikngkmisituukasyu12;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU12)
    public String getZrnsimisikngkmisituukasyu12() {
        return zrnsimisikngkmisituukasyu12;
    }

    public void setZrnsimisikngkmisituukasyu12(String pZrnsimisikngkmisituukasyu12) {
        zrnsimisikngkmisituukasyu12 = pZrnsimisikngkmisituukasyu12;
    }

    private String zrnsimisimeisaibikou12;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU12)
    public String getZrnsimisimeisaibikou12() {
        return zrnsimisimeisaibikou12;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou12(String pZrnsimisimeisaibikou12) {
        zrnsimisimeisaibikou12 = pZrnsimisimeisaibikou12;
    }

    private String zrnsimisikngkmisihugou12;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU12)
    public String getZrnsimisikngkmisihugou12() {
        return zrnsimisikngkmisihugou12;
    }

    public void setZrnsimisikngkmisihugou12(String pZrnsimisikngkmisihugou12) {
        zrnsimisikngkmisihugou12 = pZrnsimisikngkmisihugou12;
    }

    private String zrnsimisimeisaiyobi12;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI12)
    public String getZrnsimisimeisaiyobi12() {
        return zrnsimisimeisaiyobi12;
    }

    public void setZrnsimisimeisaiyobi12(String pZrnsimisimeisaiyobi12) {
        zrnsimisimeisaiyobi12 = pZrnsimisimeisaiyobi12;
    }

    private String zrnsimisitekiyou13;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU13)
    public String getZrnsimisitekiyou13() {
        return zrnsimisitekiyou13;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou13(String pZrnsimisitekiyou13) {
        zrnsimisitekiyou13 = pZrnsimisitekiyou13;
    }

    private String zrnsimisikngkmisi13;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI13)
    public String getZrnsimisikngkmisi13() {
        return zrnsimisikngkmisi13;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi13(String pZrnsimisikngkmisi13) {
        zrnsimisikngkmisi13 = pZrnsimisikngkmisi13;
    }

    private String zrnsimisikngkmisituukasyu13;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU13)
    public String getZrnsimisikngkmisituukasyu13() {
        return zrnsimisikngkmisituukasyu13;
    }

    public void setZrnsimisikngkmisituukasyu13(String pZrnsimisikngkmisituukasyu13) {
        zrnsimisikngkmisituukasyu13 = pZrnsimisikngkmisituukasyu13;
    }

    private String zrnsimisimeisaibikou13;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU13)
    public String getZrnsimisimeisaibikou13() {
        return zrnsimisimeisaibikou13;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou13(String pZrnsimisimeisaibikou13) {
        zrnsimisimeisaibikou13 = pZrnsimisimeisaibikou13;
    }

    private String zrnsimisikngkmisihugou13;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU13)
    public String getZrnsimisikngkmisihugou13() {
        return zrnsimisikngkmisihugou13;
    }

    public void setZrnsimisikngkmisihugou13(String pZrnsimisikngkmisihugou13) {
        zrnsimisikngkmisihugou13 = pZrnsimisikngkmisihugou13;
    }

    private String zrnsimisimeisaiyobi13;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI13)
    public String getZrnsimisimeisaiyobi13() {
        return zrnsimisimeisaiyobi13;
    }

    public void setZrnsimisimeisaiyobi13(String pZrnsimisimeisaiyobi13) {
        zrnsimisimeisaiyobi13 = pZrnsimisimeisaiyobi13;
    }

    private String zrnsimisitekiyou14;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU14)
    public String getZrnsimisitekiyou14() {
        return zrnsimisitekiyou14;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou14(String pZrnsimisitekiyou14) {
        zrnsimisitekiyou14 = pZrnsimisitekiyou14;
    }

    private String zrnsimisikngkmisi14;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI14)
    public String getZrnsimisikngkmisi14() {
        return zrnsimisikngkmisi14;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi14(String pZrnsimisikngkmisi14) {
        zrnsimisikngkmisi14 = pZrnsimisikngkmisi14;
    }

    private String zrnsimisikngkmisituukasyu14;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU14)
    public String getZrnsimisikngkmisituukasyu14() {
        return zrnsimisikngkmisituukasyu14;
    }

    public void setZrnsimisikngkmisituukasyu14(String pZrnsimisikngkmisituukasyu14) {
        zrnsimisikngkmisituukasyu14 = pZrnsimisikngkmisituukasyu14;
    }

    private String zrnsimisimeisaibikou14;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU14)
    public String getZrnsimisimeisaibikou14() {
        return zrnsimisimeisaibikou14;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou14(String pZrnsimisimeisaibikou14) {
        zrnsimisimeisaibikou14 = pZrnsimisimeisaibikou14;
    }

    private String zrnsimisikngkmisihugou14;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU14)
    public String getZrnsimisikngkmisihugou14() {
        return zrnsimisikngkmisihugou14;
    }

    public void setZrnsimisikngkmisihugou14(String pZrnsimisikngkmisihugou14) {
        zrnsimisikngkmisihugou14 = pZrnsimisikngkmisihugou14;
    }

    private String zrnsimisimeisaiyobi14;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI14)
    public String getZrnsimisimeisaiyobi14() {
        return zrnsimisimeisaiyobi14;
    }

    public void setZrnsimisimeisaiyobi14(String pZrnsimisimeisaiyobi14) {
        zrnsimisimeisaiyobi14 = pZrnsimisimeisaiyobi14;
    }

    private String zrnsimisitekiyou15;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU15)
    public String getZrnsimisitekiyou15() {
        return zrnsimisitekiyou15;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou15(String pZrnsimisitekiyou15) {
        zrnsimisitekiyou15 = pZrnsimisitekiyou15;
    }

    private String zrnsimisikngkmisi15;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI15)
    public String getZrnsimisikngkmisi15() {
        return zrnsimisikngkmisi15;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi15(String pZrnsimisikngkmisi15) {
        zrnsimisikngkmisi15 = pZrnsimisikngkmisi15;
    }

    private String zrnsimisikngkmisituukasyu15;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU15)
    public String getZrnsimisikngkmisituukasyu15() {
        return zrnsimisikngkmisituukasyu15;
    }

    public void setZrnsimisikngkmisituukasyu15(String pZrnsimisikngkmisituukasyu15) {
        zrnsimisikngkmisituukasyu15 = pZrnsimisikngkmisituukasyu15;
    }

    private String zrnsimisimeisaibikou15;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU15)
    public String getZrnsimisimeisaibikou15() {
        return zrnsimisimeisaibikou15;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou15(String pZrnsimisimeisaibikou15) {
        zrnsimisimeisaibikou15 = pZrnsimisimeisaibikou15;
    }

    private String zrnsimisikngkmisihugou15;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU15)
    public String getZrnsimisikngkmisihugou15() {
        return zrnsimisikngkmisihugou15;
    }

    public void setZrnsimisikngkmisihugou15(String pZrnsimisikngkmisihugou15) {
        zrnsimisikngkmisihugou15 = pZrnsimisikngkmisihugou15;
    }

    private String zrnsimisimeisaiyobi15;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI15)
    public String getZrnsimisimeisaiyobi15() {
        return zrnsimisimeisaiyobi15;
    }

    public void setZrnsimisimeisaiyobi15(String pZrnsimisimeisaiyobi15) {
        zrnsimisimeisaiyobi15 = pZrnsimisimeisaiyobi15;
    }

    private String zrnsimisitekiyou16;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU16)
    public String getZrnsimisitekiyou16() {
        return zrnsimisitekiyou16;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou16(String pZrnsimisitekiyou16) {
        zrnsimisitekiyou16 = pZrnsimisitekiyou16;
    }

    private String zrnsimisikngkmisi16;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI16)
    public String getZrnsimisikngkmisi16() {
        return zrnsimisikngkmisi16;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi16(String pZrnsimisikngkmisi16) {
        zrnsimisikngkmisi16 = pZrnsimisikngkmisi16;
    }

    private String zrnsimisikngkmisituukasyu16;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU16)
    public String getZrnsimisikngkmisituukasyu16() {
        return zrnsimisikngkmisituukasyu16;
    }

    public void setZrnsimisikngkmisituukasyu16(String pZrnsimisikngkmisituukasyu16) {
        zrnsimisikngkmisituukasyu16 = pZrnsimisikngkmisituukasyu16;
    }

    private String zrnsimisimeisaibikou16;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU16)
    public String getZrnsimisimeisaibikou16() {
        return zrnsimisimeisaibikou16;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou16(String pZrnsimisimeisaibikou16) {
        zrnsimisimeisaibikou16 = pZrnsimisimeisaibikou16;
    }

    private String zrnsimisikngkmisihugou16;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU16)
    public String getZrnsimisikngkmisihugou16() {
        return zrnsimisikngkmisihugou16;
    }

    public void setZrnsimisikngkmisihugou16(String pZrnsimisikngkmisihugou16) {
        zrnsimisikngkmisihugou16 = pZrnsimisikngkmisihugou16;
    }

    private String zrnsimisimeisaiyobi16;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI16)
    public String getZrnsimisimeisaiyobi16() {
        return zrnsimisimeisaiyobi16;
    }

    public void setZrnsimisimeisaiyobi16(String pZrnsimisimeisaiyobi16) {
        zrnsimisimeisaiyobi16 = pZrnsimisimeisaiyobi16;
    }

    private String zrnsimisitekiyou17;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU17)
    public String getZrnsimisitekiyou17() {
        return zrnsimisitekiyou17;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou17(String pZrnsimisitekiyou17) {
        zrnsimisitekiyou17 = pZrnsimisitekiyou17;
    }

    private String zrnsimisikngkmisi17;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI17)
    public String getZrnsimisikngkmisi17() {
        return zrnsimisikngkmisi17;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi17(String pZrnsimisikngkmisi17) {
        zrnsimisikngkmisi17 = pZrnsimisikngkmisi17;
    }

    private String zrnsimisikngkmisituukasyu17;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU17)
    public String getZrnsimisikngkmisituukasyu17() {
        return zrnsimisikngkmisituukasyu17;
    }

    public void setZrnsimisikngkmisituukasyu17(String pZrnsimisikngkmisituukasyu17) {
        zrnsimisikngkmisituukasyu17 = pZrnsimisikngkmisituukasyu17;
    }

    private String zrnsimisimeisaibikou17;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU17)
    public String getZrnsimisimeisaibikou17() {
        return zrnsimisimeisaibikou17;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou17(String pZrnsimisimeisaibikou17) {
        zrnsimisimeisaibikou17 = pZrnsimisimeisaibikou17;
    }

    private String zrnsimisikngkmisihugou17;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU17)
    public String getZrnsimisikngkmisihugou17() {
        return zrnsimisikngkmisihugou17;
    }

    public void setZrnsimisikngkmisihugou17(String pZrnsimisikngkmisihugou17) {
        zrnsimisikngkmisihugou17 = pZrnsimisikngkmisihugou17;
    }

    private String zrnsimisimeisaiyobi17;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI17)
    public String getZrnsimisimeisaiyobi17() {
        return zrnsimisimeisaiyobi17;
    }

    public void setZrnsimisimeisaiyobi17(String pZrnsimisimeisaiyobi17) {
        zrnsimisimeisaiyobi17 = pZrnsimisimeisaiyobi17;
    }

    private String zrnsimisitekiyou18;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU18)
    public String getZrnsimisitekiyou18() {
        return zrnsimisitekiyou18;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou18(String pZrnsimisitekiyou18) {
        zrnsimisitekiyou18 = pZrnsimisitekiyou18;
    }

    private String zrnsimisikngkmisi18;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI18)
    public String getZrnsimisikngkmisi18() {
        return zrnsimisikngkmisi18;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi18(String pZrnsimisikngkmisi18) {
        zrnsimisikngkmisi18 = pZrnsimisikngkmisi18;
    }

    private String zrnsimisikngkmisituukasyu18;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU18)
    public String getZrnsimisikngkmisituukasyu18() {
        return zrnsimisikngkmisituukasyu18;
    }

    public void setZrnsimisikngkmisituukasyu18(String pZrnsimisikngkmisituukasyu18) {
        zrnsimisikngkmisituukasyu18 = pZrnsimisikngkmisituukasyu18;
    }

    private String zrnsimisimeisaibikou18;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU18)
    public String getZrnsimisimeisaibikou18() {
        return zrnsimisimeisaibikou18;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou18(String pZrnsimisimeisaibikou18) {
        zrnsimisimeisaibikou18 = pZrnsimisimeisaibikou18;
    }

    private String zrnsimisikngkmisihugou18;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU18)
    public String getZrnsimisikngkmisihugou18() {
        return zrnsimisikngkmisihugou18;
    }

    public void setZrnsimisikngkmisihugou18(String pZrnsimisikngkmisihugou18) {
        zrnsimisikngkmisihugou18 = pZrnsimisikngkmisihugou18;
    }

    private String zrnsimisimeisaiyobi18;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI18)
    public String getZrnsimisimeisaiyobi18() {
        return zrnsimisimeisaiyobi18;
    }

    public void setZrnsimisimeisaiyobi18(String pZrnsimisimeisaiyobi18) {
        zrnsimisimeisaiyobi18 = pZrnsimisimeisaiyobi18;
    }

    private String zrnsimisitekiyou19;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU19)
    public String getZrnsimisitekiyou19() {
        return zrnsimisitekiyou19;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou19(String pZrnsimisitekiyou19) {
        zrnsimisitekiyou19 = pZrnsimisitekiyou19;
    }

    private String zrnsimisikngkmisi19;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI19)
    public String getZrnsimisikngkmisi19() {
        return zrnsimisikngkmisi19;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi19(String pZrnsimisikngkmisi19) {
        zrnsimisikngkmisi19 = pZrnsimisikngkmisi19;
    }

    private String zrnsimisikngkmisituukasyu19;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU19)
    public String getZrnsimisikngkmisituukasyu19() {
        return zrnsimisikngkmisituukasyu19;
    }

    public void setZrnsimisikngkmisituukasyu19(String pZrnsimisikngkmisituukasyu19) {
        zrnsimisikngkmisituukasyu19 = pZrnsimisikngkmisituukasyu19;
    }

    private String zrnsimisimeisaibikou19;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU19)
    public String getZrnsimisimeisaibikou19() {
        return zrnsimisimeisaibikou19;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou19(String pZrnsimisimeisaibikou19) {
        zrnsimisimeisaibikou19 = pZrnsimisimeisaibikou19;
    }

    private String zrnsimisikngkmisihugou19;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU19)
    public String getZrnsimisikngkmisihugou19() {
        return zrnsimisikngkmisihugou19;
    }

    public void setZrnsimisikngkmisihugou19(String pZrnsimisikngkmisihugou19) {
        zrnsimisikngkmisihugou19 = pZrnsimisikngkmisihugou19;
    }

    private String zrnsimisimeisaiyobi19;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI19)
    public String getZrnsimisimeisaiyobi19() {
        return zrnsimisimeisaiyobi19;
    }

    public void setZrnsimisimeisaiyobi19(String pZrnsimisimeisaiyobi19) {
        zrnsimisimeisaiyobi19 = pZrnsimisimeisaiyobi19;
    }

    private String zrnsimisitekiyou20;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU20)
    public String getZrnsimisitekiyou20() {
        return zrnsimisitekiyou20;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou20(String pZrnsimisitekiyou20) {
        zrnsimisitekiyou20 = pZrnsimisitekiyou20;
    }

    private String zrnsimisikngkmisi20;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI20)
    public String getZrnsimisikngkmisi20() {
        return zrnsimisikngkmisi20;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi20(String pZrnsimisikngkmisi20) {
        zrnsimisikngkmisi20 = pZrnsimisikngkmisi20;
    }

    private String zrnsimisikngkmisituukasyu20;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU20)
    public String getZrnsimisikngkmisituukasyu20() {
        return zrnsimisikngkmisituukasyu20;
    }

    public void setZrnsimisikngkmisituukasyu20(String pZrnsimisikngkmisituukasyu20) {
        zrnsimisikngkmisituukasyu20 = pZrnsimisikngkmisituukasyu20;
    }

    private String zrnsimisimeisaibikou20;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU20)
    public String getZrnsimisimeisaibikou20() {
        return zrnsimisimeisaibikou20;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou20(String pZrnsimisimeisaibikou20) {
        zrnsimisimeisaibikou20 = pZrnsimisimeisaibikou20;
    }

    private String zrnsimisikngkmisihugou20;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU20)
    public String getZrnsimisikngkmisihugou20() {
        return zrnsimisikngkmisihugou20;
    }

    public void setZrnsimisikngkmisihugou20(String pZrnsimisikngkmisihugou20) {
        zrnsimisikngkmisihugou20 = pZrnsimisikngkmisihugou20;
    }

    private String zrnsimisimeisaiyobi20;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI20)
    public String getZrnsimisimeisaiyobi20() {
        return zrnsimisimeisaiyobi20;
    }

    public void setZrnsimisimeisaiyobi20(String pZrnsimisimeisaiyobi20) {
        zrnsimisimeisaiyobi20 = pZrnsimisimeisaiyobi20;
    }

    private String zrnsimisitekiyou21;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU21)
    public String getZrnsimisitekiyou21() {
        return zrnsimisitekiyou21;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou21(String pZrnsimisitekiyou21) {
        zrnsimisitekiyou21 = pZrnsimisitekiyou21;
    }

    private String zrnsimisikngkmisi21;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI21)
    public String getZrnsimisikngkmisi21() {
        return zrnsimisikngkmisi21;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi21(String pZrnsimisikngkmisi21) {
        zrnsimisikngkmisi21 = pZrnsimisikngkmisi21;
    }

    private String zrnsimisikngkmisituukasyu21;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU21)
    public String getZrnsimisikngkmisituukasyu21() {
        return zrnsimisikngkmisituukasyu21;
    }

    public void setZrnsimisikngkmisituukasyu21(String pZrnsimisikngkmisituukasyu21) {
        zrnsimisikngkmisituukasyu21 = pZrnsimisikngkmisituukasyu21;
    }

    private String zrnsimisimeisaibikou21;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU21)
    public String getZrnsimisimeisaibikou21() {
        return zrnsimisimeisaibikou21;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou21(String pZrnsimisimeisaibikou21) {
        zrnsimisimeisaibikou21 = pZrnsimisimeisaibikou21;
    }

    private String zrnsimisikngkmisihugou21;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU21)
    public String getZrnsimisikngkmisihugou21() {
        return zrnsimisikngkmisihugou21;
    }

    public void setZrnsimisikngkmisihugou21(String pZrnsimisikngkmisihugou21) {
        zrnsimisikngkmisihugou21 = pZrnsimisikngkmisihugou21;
    }

    private String zrnsimisimeisaiyobi21;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI21)
    public String getZrnsimisimeisaiyobi21() {
        return zrnsimisimeisaiyobi21;
    }

    public void setZrnsimisimeisaiyobi21(String pZrnsimisimeisaiyobi21) {
        zrnsimisimeisaiyobi21 = pZrnsimisimeisaiyobi21;
    }

    private String zrnsimisitekiyou22;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU22)
    public String getZrnsimisitekiyou22() {
        return zrnsimisitekiyou22;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou22(String pZrnsimisitekiyou22) {
        zrnsimisitekiyou22 = pZrnsimisitekiyou22;
    }

    private String zrnsimisikngkmisi22;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI22)
    public String getZrnsimisikngkmisi22() {
        return zrnsimisikngkmisi22;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi22(String pZrnsimisikngkmisi22) {
        zrnsimisikngkmisi22 = pZrnsimisikngkmisi22;
    }

    private String zrnsimisikngkmisituukasyu22;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU22)
    public String getZrnsimisikngkmisituukasyu22() {
        return zrnsimisikngkmisituukasyu22;
    }

    public void setZrnsimisikngkmisituukasyu22(String pZrnsimisikngkmisituukasyu22) {
        zrnsimisikngkmisituukasyu22 = pZrnsimisikngkmisituukasyu22;
    }

    private String zrnsimisimeisaibikou22;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU22)
    public String getZrnsimisimeisaibikou22() {
        return zrnsimisimeisaibikou22;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou22(String pZrnsimisimeisaibikou22) {
        zrnsimisimeisaibikou22 = pZrnsimisimeisaibikou22;
    }

    private String zrnsimisikngkmisihugou22;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU22)
    public String getZrnsimisikngkmisihugou22() {
        return zrnsimisikngkmisihugou22;
    }

    public void setZrnsimisikngkmisihugou22(String pZrnsimisikngkmisihugou22) {
        zrnsimisikngkmisihugou22 = pZrnsimisikngkmisihugou22;
    }

    private String zrnsimisimeisaiyobi22;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI22)
    public String getZrnsimisimeisaiyobi22() {
        return zrnsimisimeisaiyobi22;
    }

    public void setZrnsimisimeisaiyobi22(String pZrnsimisimeisaiyobi22) {
        zrnsimisimeisaiyobi22 = pZrnsimisimeisaiyobi22;
    }

    private String zrnsimisitekiyou23;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU23)
    public String getZrnsimisitekiyou23() {
        return zrnsimisitekiyou23;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou23(String pZrnsimisitekiyou23) {
        zrnsimisitekiyou23 = pZrnsimisitekiyou23;
    }

    private String zrnsimisikngkmisi23;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI23)
    public String getZrnsimisikngkmisi23() {
        return zrnsimisikngkmisi23;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi23(String pZrnsimisikngkmisi23) {
        zrnsimisikngkmisi23 = pZrnsimisikngkmisi23;
    }

    private String zrnsimisikngkmisituukasyu23;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU23)
    public String getZrnsimisikngkmisituukasyu23() {
        return zrnsimisikngkmisituukasyu23;
    }

    public void setZrnsimisikngkmisituukasyu23(String pZrnsimisikngkmisituukasyu23) {
        zrnsimisikngkmisituukasyu23 = pZrnsimisikngkmisituukasyu23;
    }

    private String zrnsimisimeisaibikou23;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU23)
    public String getZrnsimisimeisaibikou23() {
        return zrnsimisimeisaibikou23;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou23(String pZrnsimisimeisaibikou23) {
        zrnsimisimeisaibikou23 = pZrnsimisimeisaibikou23;
    }

    private String zrnsimisikngkmisihugou23;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU23)
    public String getZrnsimisikngkmisihugou23() {
        return zrnsimisikngkmisihugou23;
    }

    public void setZrnsimisikngkmisihugou23(String pZrnsimisikngkmisihugou23) {
        zrnsimisikngkmisihugou23 = pZrnsimisikngkmisihugou23;
    }

    private String zrnsimisimeisaiyobi23;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI23)
    public String getZrnsimisimeisaiyobi23() {
        return zrnsimisimeisaiyobi23;
    }

    public void setZrnsimisimeisaiyobi23(String pZrnsimisimeisaiyobi23) {
        zrnsimisimeisaiyobi23 = pZrnsimisimeisaiyobi23;
    }

    private String zrnsimisitekiyou24;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU24)
    public String getZrnsimisitekiyou24() {
        return zrnsimisitekiyou24;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou24(String pZrnsimisitekiyou24) {
        zrnsimisitekiyou24 = pZrnsimisitekiyou24;
    }

    private String zrnsimisikngkmisi24;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI24)
    public String getZrnsimisikngkmisi24() {
        return zrnsimisikngkmisi24;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi24(String pZrnsimisikngkmisi24) {
        zrnsimisikngkmisi24 = pZrnsimisikngkmisi24;
    }

    private String zrnsimisikngkmisituukasyu24;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU24)
    public String getZrnsimisikngkmisituukasyu24() {
        return zrnsimisikngkmisituukasyu24;
    }

    public void setZrnsimisikngkmisituukasyu24(String pZrnsimisikngkmisituukasyu24) {
        zrnsimisikngkmisituukasyu24 = pZrnsimisikngkmisituukasyu24;
    }

    private String zrnsimisimeisaibikou24;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU24)
    public String getZrnsimisimeisaibikou24() {
        return zrnsimisimeisaibikou24;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou24(String pZrnsimisimeisaibikou24) {
        zrnsimisimeisaibikou24 = pZrnsimisimeisaibikou24;
    }

    private String zrnsimisikngkmisihugou24;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU24)
    public String getZrnsimisikngkmisihugou24() {
        return zrnsimisikngkmisihugou24;
    }

    public void setZrnsimisikngkmisihugou24(String pZrnsimisikngkmisihugou24) {
        zrnsimisikngkmisihugou24 = pZrnsimisikngkmisihugou24;
    }

    private String zrnsimisimeisaiyobi24;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI24)
    public String getZrnsimisimeisaiyobi24() {
        return zrnsimisimeisaiyobi24;
    }

    public void setZrnsimisimeisaiyobi24(String pZrnsimisimeisaiyobi24) {
        zrnsimisimeisaiyobi24 = pZrnsimisimeisaiyobi24;
    }

    private String zrnsimisitekiyou25;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITEKIYOU25)
    public String getZrnsimisitekiyou25() {
        return zrnsimisitekiyou25;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisitekiyou25(String pZrnsimisitekiyou25) {
        zrnsimisitekiyou25 = pZrnsimisitekiyou25;
    }

    private String zrnsimisikngkmisi25;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISI25)
    public String getZrnsimisikngkmisi25() {
        return zrnsimisikngkmisi25;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisikngkmisi25(String pZrnsimisikngkmisi25) {
        zrnsimisikngkmisi25 = pZrnsimisikngkmisi25;
    }

    private String zrnsimisikngkmisituukasyu25;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISITUUKASYU25)
    public String getZrnsimisikngkmisituukasyu25() {
        return zrnsimisikngkmisituukasyu25;
    }

    public void setZrnsimisikngkmisituukasyu25(String pZrnsimisikngkmisituukasyu25) {
        zrnsimisikngkmisituukasyu25 = pZrnsimisikngkmisituukasyu25;
    }

    private String zrnsimisimeisaibikou25;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBIKOU25)
    public String getZrnsimisimeisaibikou25() {
        return zrnsimisimeisaibikou25;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisimeisaibikou25(String pZrnsimisimeisaibikou25) {
        zrnsimisimeisaibikou25 = pZrnsimisimeisaibikou25;
    }

    private String zrnsimisikngkmisihugou25;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIKNGKMISIHUGOU25)
    public String getZrnsimisikngkmisihugou25() {
        return zrnsimisikngkmisihugou25;
    }

    public void setZrnsimisikngkmisihugou25(String pZrnsimisikngkmisihugou25) {
        zrnsimisikngkmisihugou25 = pZrnsimisikngkmisihugou25;
    }

    private String zrnsimisimeisaiyobi25;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIYOBI25)
    public String getZrnsimisimeisaiyobi25() {
        return zrnsimisimeisaiyobi25;
    }

    public void setZrnsimisimeisaiyobi25(String pZrnsimisimeisaiyobi25) {
        zrnsimisimeisaiyobi25 = pZrnsimisimeisaiyobi25;
    }

    private String zrnsimisimeisaibuyobi1x1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBUYOBI1X1)
    public String getZrnsimisimeisaibuyobi1x1() {
        return zrnsimisimeisaibuyobi1x1;
    }

    public void setZrnsimisimeisaibuyobi1x1(String pZrnsimisimeisaibuyobi1x1) {
        zrnsimisimeisaibuyobi1x1 = pZrnsimisimeisaibuyobi1x1;
    }

    private String zrnsimisimeisaibuyobi1x2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBUYOBI1X2)
    public String getZrnsimisimeisaibuyobi1x2() {
        return zrnsimisimeisaibuyobi1x2;
    }

    public void setZrnsimisimeisaibuyobi1x2(String pZrnsimisimeisaibuyobi1x2) {
        zrnsimisimeisaibuyobi1x2 = pZrnsimisimeisaibuyobi1x2;
    }

    private String zrnsimisimeisaibuyobi1x3;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBUYOBI1X3)
    public String getZrnsimisimeisaibuyobi1x3() {
        return zrnsimisimeisaibuyobi1x3;
    }

    public void setZrnsimisimeisaibuyobi1x3(String pZrnsimisimeisaibuyobi1x3) {
        zrnsimisimeisaibuyobi1x3 = pZrnsimisimeisaibuyobi1x3;
    }

    private String zrnsimisimeisaibuyobi1x4;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBUYOBI1X4)
    public String getZrnsimisimeisaibuyobi1x4() {
        return zrnsimisimeisaibuyobi1x4;
    }

    public void setZrnsimisimeisaibuyobi1x4(String pZrnsimisimeisaibuyobi1x4) {
        zrnsimisimeisaibuyobi1x4 = pZrnsimisimeisaibuyobi1x4;
    }

    private String zrnsimisimeisaibuyobi1x5;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBUYOBI1X5)
    public String getZrnsimisimeisaibuyobi1x5() {
        return zrnsimisimeisaibuyobi1x5;
    }

    public void setZrnsimisimeisaibuyobi1x5(String pZrnsimisimeisaibuyobi1x5) {
        zrnsimisimeisaibuyobi1x5 = pZrnsimisimeisaibuyobi1x5;
    }

    private String zrnsimisimeisaibuyobi1x6;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBUYOBI1X6)
    public String getZrnsimisimeisaibuyobi1x6() {
        return zrnsimisimeisaibuyobi1x6;
    }

    public void setZrnsimisimeisaibuyobi1x6(String pZrnsimisimeisaibuyobi1x6) {
        zrnsimisimeisaibuyobi1x6 = pZrnsimisimeisaibuyobi1x6;
    }

    private String zrnsimisisigoukeikingaku;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISISIGOUKEIKINGAKU)
    public String getZrnsimisisigoukeikingaku() {
        return zrnsimisisigoukeikingaku;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisisigoukeikingaku(String pZrnsimisisigoukeikingaku) {
        zrnsimisisigoukeikingaku = pZrnsimisisigoukeikingaku;
    }

    private String zrnsimisisigoukeituukasyu;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISISIGOUKEITUUKASYU)
    public String getZrnsimisisigoukeituukasyu() {
        return zrnsimisisigoukeituukasyu;
    }

    public void setZrnsimisisigoukeituukasyu(String pZrnsimisisigoukeituukasyu) {
        zrnsimisisigoukeituukasyu = pZrnsimisisigoukeituukasyu;
    }

    private String zrnsimisimeisaibuyobi2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBUYOBI2)
    public String getZrnsimisimeisaibuyobi2() {
        return zrnsimisimeisaibuyobi2;
    }

    public void setZrnsimisimeisaibuyobi2(String pZrnsimisimeisaibuyobi2) {
        zrnsimisimeisaibuyobi2 = pZrnsimisimeisaibuyobi2;
    }

    private String zrnsimisituutiranmidasi;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISITUUTIRANMIDASI)
    public String getZrnsimisituutiranmidasi() {
        return zrnsimisituutiranmidasi;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisituutiranmidasi(String pZrnsimisituutiranmidasi) {
        zrnsimisituutiranmidasi = pZrnsimisituutiranmidasi;
    }

    private String zrnsimisifreemsg1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG1)
    public String getZrnsimisifreemsg1() {
        return zrnsimisifreemsg1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg1(String pZrnsimisifreemsg1) {
        zrnsimisifreemsg1 = pZrnsimisifreemsg1;
    }

    private String zrnsimisifreemsg2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG2)
    public String getZrnsimisifreemsg2() {
        return zrnsimisifreemsg2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg2(String pZrnsimisifreemsg2) {
        zrnsimisifreemsg2 = pZrnsimisifreemsg2;
    }

    private String zrnsimisifreemsg3;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG3)
    public String getZrnsimisifreemsg3() {
        return zrnsimisifreemsg3;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg3(String pZrnsimisifreemsg3) {
        zrnsimisifreemsg3 = pZrnsimisifreemsg3;
    }

    private String zrnsimisifreemsg4;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG4)
    public String getZrnsimisifreemsg4() {
        return zrnsimisifreemsg4;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg4(String pZrnsimisifreemsg4) {
        zrnsimisifreemsg4 = pZrnsimisifreemsg4;
    }

    private String zrnsimisifreemsg5;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG5)
    public String getZrnsimisifreemsg5() {
        return zrnsimisifreemsg5;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg5(String pZrnsimisifreemsg5) {
        zrnsimisifreemsg5 = pZrnsimisifreemsg5;
    }

    private String zrnsimisifreemsg6;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG6)
    public String getZrnsimisifreemsg6() {
        return zrnsimisifreemsg6;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg6(String pZrnsimisifreemsg6) {
        zrnsimisifreemsg6 = pZrnsimisifreemsg6;
    }

    private String zrnsimisifreemsg7;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG7)
    public String getZrnsimisifreemsg7() {
        return zrnsimisifreemsg7;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg7(String pZrnsimisifreemsg7) {
        zrnsimisifreemsg7 = pZrnsimisifreemsg7;
    }

    private String zrnsimisifreemsg8;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG8)
    public String getZrnsimisifreemsg8() {
        return zrnsimisifreemsg8;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg8(String pZrnsimisifreemsg8) {
        zrnsimisifreemsg8 = pZrnsimisifreemsg8;
    }

    private String zrnsimisifreemsg9;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG9)
    public String getZrnsimisifreemsg9() {
        return zrnsimisifreemsg9;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg9(String pZrnsimisifreemsg9) {
        zrnsimisifreemsg9 = pZrnsimisifreemsg9;
    }

    private String zrnsimisifreemsg10;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG10)
    public String getZrnsimisifreemsg10() {
        return zrnsimisifreemsg10;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg10(String pZrnsimisifreemsg10) {
        zrnsimisifreemsg10 = pZrnsimisifreemsg10;
    }

    private String zrnsimisifreemsg11;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG11)
    public String getZrnsimisifreemsg11() {
        return zrnsimisifreemsg11;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg11(String pZrnsimisifreemsg11) {
        zrnsimisifreemsg11 = pZrnsimisifreemsg11;
    }

    private String zrnsimisifreemsg12;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG12)
    public String getZrnsimisifreemsg12() {
        return zrnsimisifreemsg12;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg12(String pZrnsimisifreemsg12) {
        zrnsimisifreemsg12 = pZrnsimisifreemsg12;
    }

    private String zrnsimisifreemsg13;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG13)
    public String getZrnsimisifreemsg13() {
        return zrnsimisifreemsg13;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg13(String pZrnsimisifreemsg13) {
        zrnsimisifreemsg13 = pZrnsimisifreemsg13;
    }

    private String zrnsimisifreemsg14;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG14)
    public String getZrnsimisifreemsg14() {
        return zrnsimisifreemsg14;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg14(String pZrnsimisifreemsg14) {
        zrnsimisifreemsg14 = pZrnsimisifreemsg14;
    }

    private String zrnsimisifreemsg15;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG15)
    public String getZrnsimisifreemsg15() {
        return zrnsimisifreemsg15;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg15(String pZrnsimisifreemsg15) {
        zrnsimisifreemsg15 = pZrnsimisifreemsg15;
    }

    private String zrnsimisifreemsg16;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG16)
    public String getZrnsimisifreemsg16() {
        return zrnsimisifreemsg16;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg16(String pZrnsimisifreemsg16) {
        zrnsimisifreemsg16 = pZrnsimisifreemsg16;
    }

    private String zrnsimisifreemsg17;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG17)
    public String getZrnsimisifreemsg17() {
        return zrnsimisifreemsg17;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg17(String pZrnsimisifreemsg17) {
        zrnsimisifreemsg17 = pZrnsimisifreemsg17;
    }

    private String zrnsimisifreemsg18;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG18)
    public String getZrnsimisifreemsg18() {
        return zrnsimisifreemsg18;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg18(String pZrnsimisifreemsg18) {
        zrnsimisifreemsg18 = pZrnsimisifreemsg18;
    }

    private String zrnsimisifreemsg19;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG19)
    public String getZrnsimisifreemsg19() {
        return zrnsimisifreemsg19;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg19(String pZrnsimisifreemsg19) {
        zrnsimisifreemsg19 = pZrnsimisifreemsg19;
    }

    private String zrnsimisifreemsg20;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG20)
    public String getZrnsimisifreemsg20() {
        return zrnsimisifreemsg20;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg20(String pZrnsimisifreemsg20) {
        zrnsimisifreemsg20 = pZrnsimisifreemsg20;
    }

    private String zrnsimisifreemsg21;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG21)
    public String getZrnsimisifreemsg21() {
        return zrnsimisifreemsg21;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg21(String pZrnsimisifreemsg21) {
        zrnsimisifreemsg21 = pZrnsimisifreemsg21;
    }

    private String zrnsimisifreemsg22;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG22)
    public String getZrnsimisifreemsg22() {
        return zrnsimisifreemsg22;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg22(String pZrnsimisifreemsg22) {
        zrnsimisifreemsg22 = pZrnsimisifreemsg22;
    }

    private String zrnsimisifreemsg23;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG23)
    public String getZrnsimisifreemsg23() {
        return zrnsimisifreemsg23;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg23(String pZrnsimisifreemsg23) {
        zrnsimisifreemsg23 = pZrnsimisifreemsg23;
    }

    private String zrnsimisifreemsg24;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG24)
    public String getZrnsimisifreemsg24() {
        return zrnsimisifreemsg24;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg24(String pZrnsimisifreemsg24) {
        zrnsimisifreemsg24 = pZrnsimisifreemsg24;
    }

    private String zrnsimisifreemsg25;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG25)
    public String getZrnsimisifreemsg25() {
        return zrnsimisifreemsg25;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg25(String pZrnsimisifreemsg25) {
        zrnsimisifreemsg25 = pZrnsimisifreemsg25;
    }

    private String zrnsimisifreemsg26;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG26)
    public String getZrnsimisifreemsg26() {
        return zrnsimisifreemsg26;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg26(String pZrnsimisifreemsg26) {
        zrnsimisifreemsg26 = pZrnsimisifreemsg26;
    }

    private String zrnsimisifreemsg27;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG27)
    public String getZrnsimisifreemsg27() {
        return zrnsimisifreemsg27;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg27(String pZrnsimisifreemsg27) {
        zrnsimisifreemsg27 = pZrnsimisifreemsg27;
    }

    private String zrnsimisifreemsg28;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG28)
    public String getZrnsimisifreemsg28() {
        return zrnsimisifreemsg28;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg28(String pZrnsimisifreemsg28) {
        zrnsimisifreemsg28 = pZrnsimisifreemsg28;
    }

    private String zrnsimisifreemsg29;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG29)
    public String getZrnsimisifreemsg29() {
        return zrnsimisifreemsg29;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg29(String pZrnsimisifreemsg29) {
        zrnsimisifreemsg29 = pZrnsimisifreemsg29;
    }

    private String zrnsimisifreemsg30;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG30)
    public String getZrnsimisifreemsg30() {
        return zrnsimisifreemsg30;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg30(String pZrnsimisifreemsg30) {
        zrnsimisifreemsg30 = pZrnsimisifreemsg30;
    }

    private String zrnsimisifreemsg31;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG31)
    public String getZrnsimisifreemsg31() {
        return zrnsimisifreemsg31;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg31(String pZrnsimisifreemsg31) {
        zrnsimisifreemsg31 = pZrnsimisifreemsg31;
    }

    private String zrnsimisifreemsg32;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG32)
    public String getZrnsimisifreemsg32() {
        return zrnsimisifreemsg32;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg32(String pZrnsimisifreemsg32) {
        zrnsimisifreemsg32 = pZrnsimisifreemsg32;
    }

    private String zrnsimisifreemsg33;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG33)
    public String getZrnsimisifreemsg33() {
        return zrnsimisifreemsg33;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg33(String pZrnsimisifreemsg33) {
        zrnsimisifreemsg33 = pZrnsimisifreemsg33;
    }

    private String zrnsimisifreemsg34;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG34)
    public String getZrnsimisifreemsg34() {
        return zrnsimisifreemsg34;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg34(String pZrnsimisifreemsg34) {
        zrnsimisifreemsg34 = pZrnsimisifreemsg34;
    }

    private String zrnsimisifreemsg35;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG35)
    public String getZrnsimisifreemsg35() {
        return zrnsimisifreemsg35;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg35(String pZrnsimisifreemsg35) {
        zrnsimisifreemsg35 = pZrnsimisifreemsg35;
    }

    private String zrnsimisifreemsg36;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG36)
    public String getZrnsimisifreemsg36() {
        return zrnsimisifreemsg36;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg36(String pZrnsimisifreemsg36) {
        zrnsimisifreemsg36 = pZrnsimisifreemsg36;
    }

    private String zrnsimisifreemsg37;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG37)
    public String getZrnsimisifreemsg37() {
        return zrnsimisifreemsg37;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg37(String pZrnsimisifreemsg37) {
        zrnsimisifreemsg37 = pZrnsimisifreemsg37;
    }

    private String zrnsimisifreemsg38;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG38)
    public String getZrnsimisifreemsg38() {
        return zrnsimisifreemsg38;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg38(String pZrnsimisifreemsg38) {
        zrnsimisifreemsg38 = pZrnsimisifreemsg38;
    }

    private String zrnsimisifreemsg39;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG39)
    public String getZrnsimisifreemsg39() {
        return zrnsimisifreemsg39;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg39(String pZrnsimisifreemsg39) {
        zrnsimisifreemsg39 = pZrnsimisifreemsg39;
    }

    private String zrnsimisifreemsg40;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG40)
    public String getZrnsimisifreemsg40() {
        return zrnsimisifreemsg40;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg40(String pZrnsimisifreemsg40) {
        zrnsimisifreemsg40 = pZrnsimisifreemsg40;
    }

    private String zrnsimisifreemsg41;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG41)
    public String getZrnsimisifreemsg41() {
        return zrnsimisifreemsg41;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg41(String pZrnsimisifreemsg41) {
        zrnsimisifreemsg41 = pZrnsimisifreemsg41;
    }

    private String zrnsimisifreemsg42;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG42)
    public String getZrnsimisifreemsg42() {
        return zrnsimisifreemsg42;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg42(String pZrnsimisifreemsg42) {
        zrnsimisifreemsg42 = pZrnsimisifreemsg42;
    }

    private String zrnsimisifreemsg43;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG43)
    public String getZrnsimisifreemsg43() {
        return zrnsimisifreemsg43;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg43(String pZrnsimisifreemsg43) {
        zrnsimisifreemsg43 = pZrnsimisifreemsg43;
    }

    private String zrnsimisifreemsg44;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG44)
    public String getZrnsimisifreemsg44() {
        return zrnsimisifreemsg44;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg44(String pZrnsimisifreemsg44) {
        zrnsimisifreemsg44 = pZrnsimisifreemsg44;
    }

    private String zrnsimisifreemsg45;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG45)
    public String getZrnsimisifreemsg45() {
        return zrnsimisifreemsg45;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg45(String pZrnsimisifreemsg45) {
        zrnsimisifreemsg45 = pZrnsimisifreemsg45;
    }

    private String zrnsimisifreemsg46;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIFREEMSG46)
    public String getZrnsimisifreemsg46() {
        return zrnsimisifreemsg46;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisifreemsg46(String pZrnsimisifreemsg46) {
        zrnsimisifreemsg46 = pZrnsimisifreemsg46;
    }

    private String zrnsimisiosirasemongon3x1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIOSIRASEMONGON3X1)
    public String getZrnsimisiosirasemongon3x1() {
        return zrnsimisiosirasemongon3x1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisiosirasemongon3x1(String pZrnsimisiosirasemongon3x1) {
        zrnsimisiosirasemongon3x1 = pZrnsimisiosirasemongon3x1;
    }

    private String zrnsimisiosirasemongon3x2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIOSIRASEMONGON3X2)
    public String getZrnsimisiosirasemongon3x2() {
        return zrnsimisiosirasemongon3x2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsimisiosirasemongon3x2(String pZrnsimisiosirasemongon3x2) {
        zrnsimisiosirasemongon3x2 = pZrnsimisiosirasemongon3x2;
    }

    private String zrnsimisisynykngk;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISISYNYKNGK)
    public String getZrnsimisisynykngk() {
        return zrnsimisisynykngk;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisisynykngk(String pZrnsimisisynykngk) {
        zrnsimisisynykngk = pZrnsimisisynykngk;
    }

    private String zrnsimisihtykeihi;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIHTYKEIHI)
    public String getZrnsimisihtykeihi() {
        return zrnsimisihtykeihi;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnsimisihtykeihi(String pZrnsimisihtykeihi) {
        zrnsimisihtykeihi = pZrnsimisihtykeihi;
    }

    private String zrnkztkgk;

    @Column(name=GenZT_SiShrdetailRn.ZRNKZTKGK)
    public String getZrnkztkgk() {
        return zrnkztkgk;
    }

    @Padding(mode = "left", padChar ='0', length =15)
    public void setZrnkztkgk(String pZrnkztkgk) {
        zrnkztkgk = pZrnkztkgk;
    }

    private String zrnzeitratkikbn;

    @Column(name=GenZT_SiShrdetailRn.ZRNZEITRATKIKBN)
    public String getZrnzeitratkikbn() {
        return zrnzeitratkikbn;
    }

    public void setZrnzeitratkikbn(String pZrnzeitratkikbn) {
        zrnzeitratkikbn = pZrnzeitratkikbn;
    }

    private String zrnkykhenkouumukbn;

    @Column(name=GenZT_SiShrdetailRn.ZRNKYKHENKOUUMUKBN)
    public String getZrnkykhenkouumukbn() {
        return zrnkykhenkouumukbn;
    }

    public void setZrnkykhenkouumukbn(String pZrnkykhenkouumukbn) {
        zrnkykhenkouumukbn = pZrnkykhenkouumukbn;
    }

    private String zrnshrkykhtykeihi;

    @Column(name=GenZT_SiShrdetailRn.ZRNSHRKYKHTYKEIHI)
    public String getZrnshrkykhtykeihi() {
        return zrnshrkykhtykeihi;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrkykhtykeihi(String pZrnshrkykhtykeihi) {
        zrnshrkykhtykeihi = pZrnshrkykhtykeihi;
    }

    private String zrnsimisimeisaibuyobi3x1;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBUYOBI3X1)
    public String getZrnsimisimeisaibuyobi3x1() {
        return zrnsimisimeisaibuyobi3x1;
    }

    public void setZrnsimisimeisaibuyobi3x1(String pZrnsimisimeisaibuyobi3x1) {
        zrnsimisimeisaibuyobi3x1 = pZrnsimisimeisaibuyobi3x1;
    }

    private String zrnsimisimeisaibuyobi3x2;

    @Column(name=GenZT_SiShrdetailRn.ZRNSIMISIMEISAIBUYOBI3X2)
    public String getZrnsimisimeisaibuyobi3x2() {
        return zrnsimisimeisaibuyobi3x2;
    }

    public void setZrnsimisimeisaibuyobi3x2(String pZrnsimisimeisaibuyobi3x2) {
        zrnsimisimeisaibuyobi3x2 = pZrnsimisimeisaibuyobi3x2;
    }
}