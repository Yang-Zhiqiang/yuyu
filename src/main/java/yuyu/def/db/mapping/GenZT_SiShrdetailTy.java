package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.ZT_SiShrdetailTy;
import yuyu.def.db.id.PKZT_SiShrdetailTy;
import yuyu.def.db.meta.GenQZT_SiShrdetailTy;
import yuyu.def.db.meta.QZT_SiShrdetailTy;

/**
 * 保険金給付金支払明細書テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SiShrdetailTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SiShrdetailTy}</td><td colspan="3">保険金給付金支払明細書テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_SiShrdetailTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SiShrdetailTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyodouhuukbn ztysyodouhuukbn}</td><td>（中継用）証券同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">{@link PKZT_SiShrdetailTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikytkmkyobi1 ztysikytkmkyobi1}</td><td>（中継用）保険金共通項目予備１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskyno ztyshskyno}</td><td>（中継用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr1kj ztyshskadr1kj}</td><td>（中継用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr2kj ztyshskadr2kj}</td><td>（中継用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr3kj ztyshskadr3kj}</td><td>（中継用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshsnmkjsimisi ztyshsnmkjsimisi}</td><td>（中継用）送付先名（漢字）（支払明細）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisituutimei ztysimisituutimei}</td><td>（中継用）支払明細書通知名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiosirasemongon1x1 ztysimisiosirasemongon1x1}</td><td>（中継用）支払明細書お知らせ文言１－１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiosirasemongon1x2 ztysimisiosirasemongon1x2}</td><td>（中継用）支払明細書お知らせ文言１－２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiosirasemongon2x1 ztysimisiosirasemongon2x1}</td><td>（中継用）支払明細書お知らせ文言２－１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiosirasemongon2x2 ztysimisiosirasemongon2x2}</td><td>（中継用）支払明細書お知らせ文言２－２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiosirasemongon2x3 ztysimisiosirasemongon2x3}</td><td>（中継用）支払明細書お知らせ文言２－３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiosirasemongon2x4 ztysimisiosirasemongon2x4}</td><td>（中継用）支払明細書お知らせ文言２－４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiosirasemongon2x5 ztysimisiosirasemongon2x5}</td><td>（中継用）支払明細書お知らせ文言２－５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawyno ztytawyno}</td><td>（中継用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr1kj30 ztytawadr1kj30}</td><td>（中継用）問合せ先住所１（漢字３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr2kj30 ztytawadr2kj30}</td><td>（中継用）問合せ先住所２（漢字３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr3kj30 ztytawadr3kj30}</td><td>（中継用）問合せ先住所３（漢字３０桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawtelno ztytawtelno}</td><td>（中継用）問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiatenabuyobi1 ztysimisiatenabuyobi1}</td><td>（中継用）支払明細書宛名部予備１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiatenabuyobi2 ztysimisiatenabuyobi2}</td><td>（中継用）支払明細書宛名部予備２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj ztykyknmkj}</td><td>（中継用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdwa ztytyouhyouymdwa}</td><td>（中継用）帳票作成日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaibiwareki ztysiharaibiwareki}</td><td>（中継用）支払日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybanknmkj ztybanknmkj}</td><td>（中継用）銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysitennmkj ztysitennmkj}</td><td>（中継用）支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyokinsyumokumeikanji ztyyokinsyumokumeikanji}</td><td>（中継用）預金種目名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzano12keta ztykouzano12keta}</td><td>（中継用）口座番号（１２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzmeiginmkn ztykzmeiginmkn}</td><td>（中継用）口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzamaskingmsg ztykouzamaskingmsg}</td><td>（中継用）口座マスキングＭＳＧ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisisummarybuyobi1 ztysimisisummarybuyobi1}</td><td>（中継用）支払明細書サマリー部予備１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisisummarybuyobi2 ztysimisisummarybuyobi2}</td><td>（中継用）支払明細書サマリー部予備２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyouranmidasi ztysimisitekiyouranmidasi}</td><td>（中継用）支払明細書摘要欄見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisairanmidasi ztysimisimeisairanmidasi}</td><td>（中継用）支払金額明細欄見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisibikouranmidasi ztysimisibikouranmidasi}</td><td>（中継用）支払明細書備考欄見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibumidasiyobi ztysimisimeisaibumidasiyobi}</td><td>（中継用）支払明細書明細部見出し予備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou1 ztysimisitekiyou1}</td><td>（中継用）支払明細書摘要１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi1 ztysimisikngkmisi1}</td><td>（中継用）支払明細書金額明細１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu1 ztysimisikngkmisituukasyu1}</td><td>（中継用）支払明細書金額明細通貨種類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou1 ztysimisimeisaibikou1}</td><td>（中継用）支払明細書明細備考１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou1 ztysimisikngkmisihugou1}</td><td>（中継用）支払明細書金額明細符号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi1 ztysimisimeisaiyobi1}</td><td>（中継用）支払明細書明細予備１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou2 ztysimisitekiyou2}</td><td>（中継用）支払明細書摘要２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi2 ztysimisikngkmisi2}</td><td>（中継用）支払明細書金額明細２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu2 ztysimisikngkmisituukasyu2}</td><td>（中継用）支払明細書金額明細通貨種類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou2 ztysimisimeisaibikou2}</td><td>（中継用）支払明細書明細備考２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou2 ztysimisikngkmisihugou2}</td><td>（中継用）支払明細書金額明細符号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi2 ztysimisimeisaiyobi2}</td><td>（中継用）支払明細書明細予備２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou3 ztysimisitekiyou3}</td><td>（中継用）支払明細書摘要３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi3 ztysimisikngkmisi3}</td><td>（中継用）支払明細書金額明細３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu3 ztysimisikngkmisituukasyu3}</td><td>（中継用）支払明細書金額明細通貨種類３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou3 ztysimisimeisaibikou3}</td><td>（中継用）支払明細書明細備考３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou3 ztysimisikngkmisihugou3}</td><td>（中継用）支払明細書金額明細符号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi3 ztysimisimeisaiyobi3}</td><td>（中継用）支払明細書明細予備３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou4 ztysimisitekiyou4}</td><td>（中継用）支払明細書摘要４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi4 ztysimisikngkmisi4}</td><td>（中継用）支払明細書金額明細４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu4 ztysimisikngkmisituukasyu4}</td><td>（中継用）支払明細書金額明細通貨種類４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou4 ztysimisimeisaibikou4}</td><td>（中継用）支払明細書明細備考４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou4 ztysimisikngkmisihugou4}</td><td>（中継用）支払明細書金額明細符号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi4 ztysimisimeisaiyobi4}</td><td>（中継用）支払明細書明細予備４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou5 ztysimisitekiyou5}</td><td>（中継用）支払明細書摘要５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi5 ztysimisikngkmisi5}</td><td>（中継用）支払明細書金額明細５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu5 ztysimisikngkmisituukasyu5}</td><td>（中継用）支払明細書金額明細通貨種類５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou5 ztysimisimeisaibikou5}</td><td>（中継用）支払明細書明細備考５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou5 ztysimisikngkmisihugou5}</td><td>（中継用）支払明細書金額明細符号５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi5 ztysimisimeisaiyobi5}</td><td>（中継用）支払明細書明細予備５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou6 ztysimisitekiyou6}</td><td>（中継用）支払明細書摘要６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi6 ztysimisikngkmisi6}</td><td>（中継用）支払明細書金額明細６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu6 ztysimisikngkmisituukasyu6}</td><td>（中継用）支払明細書金額明細通貨種類６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou6 ztysimisimeisaibikou6}</td><td>（中継用）支払明細書明細備考６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou6 ztysimisikngkmisihugou6}</td><td>（中継用）支払明細書金額明細符号６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi6 ztysimisimeisaiyobi6}</td><td>（中継用）支払明細書明細予備６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou7 ztysimisitekiyou7}</td><td>（中継用）支払明細書摘要７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi7 ztysimisikngkmisi7}</td><td>（中継用）支払明細書金額明細７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu7 ztysimisikngkmisituukasyu7}</td><td>（中継用）支払明細書金額明細通貨種類７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou7 ztysimisimeisaibikou7}</td><td>（中継用）支払明細書明細備考７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou7 ztysimisikngkmisihugou7}</td><td>（中継用）支払明細書金額明細符号７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi7 ztysimisimeisaiyobi7}</td><td>（中継用）支払明細書明細予備７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou8 ztysimisitekiyou8}</td><td>（中継用）支払明細書摘要８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi8 ztysimisikngkmisi8}</td><td>（中継用）支払明細書金額明細８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu8 ztysimisikngkmisituukasyu8}</td><td>（中継用）支払明細書金額明細通貨種類８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou8 ztysimisimeisaibikou8}</td><td>（中継用）支払明細書明細備考８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou8 ztysimisikngkmisihugou8}</td><td>（中継用）支払明細書金額明細符号８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi8 ztysimisimeisaiyobi8}</td><td>（中継用）支払明細書明細予備８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou9 ztysimisitekiyou9}</td><td>（中継用）支払明細書摘要９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi9 ztysimisikngkmisi9}</td><td>（中継用）支払明細書金額明細９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu9 ztysimisikngkmisituukasyu9}</td><td>（中継用）支払明細書金額明細通貨種類９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou9 ztysimisimeisaibikou9}</td><td>（中継用）支払明細書明細備考９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou9 ztysimisikngkmisihugou9}</td><td>（中継用）支払明細書金額明細符号９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi9 ztysimisimeisaiyobi9}</td><td>（中継用）支払明細書明細予備９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou10 ztysimisitekiyou10}</td><td>（中継用）支払明細書摘要１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi10 ztysimisikngkmisi10}</td><td>（中継用）支払明細書金額明細１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu10 ztysimisikngkmisituukasyu10}</td><td>（中継用）支払明細書金額明細通貨種類１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou10 ztysimisimeisaibikou10}</td><td>（中継用）支払明細書明細備考１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou10 ztysimisikngkmisihugou10}</td><td>（中継用）支払明細書金額明細符号１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi10 ztysimisimeisaiyobi10}</td><td>（中継用）支払明細書明細予備１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou11 ztysimisitekiyou11}</td><td>（中継用）支払明細書摘要１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi11 ztysimisikngkmisi11}</td><td>（中継用）支払明細書金額明細１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu11 ztysimisikngkmisituukasyu11}</td><td>（中継用）支払明細書金額明細通貨種類１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou11 ztysimisimeisaibikou11}</td><td>（中継用）支払明細書明細備考１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou11 ztysimisikngkmisihugou11}</td><td>（中継用）支払明細書金額明細符号１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi11 ztysimisimeisaiyobi11}</td><td>（中継用）支払明細書明細予備１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou12 ztysimisitekiyou12}</td><td>（中継用）支払明細書摘要１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi12 ztysimisikngkmisi12}</td><td>（中継用）支払明細書金額明細１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu12 ztysimisikngkmisituukasyu12}</td><td>（中継用）支払明細書金額明細通貨種類１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou12 ztysimisimeisaibikou12}</td><td>（中継用）支払明細書明細備考１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou12 ztysimisikngkmisihugou12}</td><td>（中継用）支払明細書金額明細符号１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi12 ztysimisimeisaiyobi12}</td><td>（中継用）支払明細書明細予備１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou13 ztysimisitekiyou13}</td><td>（中継用）支払明細書摘要１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi13 ztysimisikngkmisi13}</td><td>（中継用）支払明細書金額明細１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu13 ztysimisikngkmisituukasyu13}</td><td>（中継用）支払明細書金額明細通貨種類１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou13 ztysimisimeisaibikou13}</td><td>（中継用）支払明細書明細備考１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou13 ztysimisikngkmisihugou13}</td><td>（中継用）支払明細書金額明細符号１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi13 ztysimisimeisaiyobi13}</td><td>（中継用）支払明細書明細予備１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou14 ztysimisitekiyou14}</td><td>（中継用）支払明細書摘要１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi14 ztysimisikngkmisi14}</td><td>（中継用）支払明細書金額明細１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu14 ztysimisikngkmisituukasyu14}</td><td>（中継用）支払明細書金額明細通貨種類１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou14 ztysimisimeisaibikou14}</td><td>（中継用）支払明細書明細備考１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou14 ztysimisikngkmisihugou14}</td><td>（中継用）支払明細書金額明細符号１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi14 ztysimisimeisaiyobi14}</td><td>（中継用）支払明細書明細予備１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou15 ztysimisitekiyou15}</td><td>（中継用）支払明細書摘要１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi15 ztysimisikngkmisi15}</td><td>（中継用）支払明細書金額明細１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu15 ztysimisikngkmisituukasyu15}</td><td>（中継用）支払明細書金額明細通貨種類１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou15 ztysimisimeisaibikou15}</td><td>（中継用）支払明細書明細備考１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou15 ztysimisikngkmisihugou15}</td><td>（中継用）支払明細書金額明細符号１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi15 ztysimisimeisaiyobi15}</td><td>（中継用）支払明細書明細予備１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou16 ztysimisitekiyou16}</td><td>（中継用）支払明細書摘要１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi16 ztysimisikngkmisi16}</td><td>（中継用）支払明細書金額明細１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu16 ztysimisikngkmisituukasyu16}</td><td>（中継用）支払明細書金額明細通貨種類１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou16 ztysimisimeisaibikou16}</td><td>（中継用）支払明細書明細備考１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou16 ztysimisikngkmisihugou16}</td><td>（中継用）支払明細書金額明細符号１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi16 ztysimisimeisaiyobi16}</td><td>（中継用）支払明細書明細予備１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou17 ztysimisitekiyou17}</td><td>（中継用）支払明細書摘要１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi17 ztysimisikngkmisi17}</td><td>（中継用）支払明細書金額明細１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu17 ztysimisikngkmisituukasyu17}</td><td>（中継用）支払明細書金額明細通貨種類１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou17 ztysimisimeisaibikou17}</td><td>（中継用）支払明細書明細備考１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou17 ztysimisikngkmisihugou17}</td><td>（中継用）支払明細書金額明細符号１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi17 ztysimisimeisaiyobi17}</td><td>（中継用）支払明細書明細予備１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou18 ztysimisitekiyou18}</td><td>（中継用）支払明細書摘要１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi18 ztysimisikngkmisi18}</td><td>（中継用）支払明細書金額明細１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu18 ztysimisikngkmisituukasyu18}</td><td>（中継用）支払明細書金額明細通貨種類１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou18 ztysimisimeisaibikou18}</td><td>（中継用）支払明細書明細備考１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou18 ztysimisikngkmisihugou18}</td><td>（中継用）支払明細書金額明細符号１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi18 ztysimisimeisaiyobi18}</td><td>（中継用）支払明細書明細予備１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou19 ztysimisitekiyou19}</td><td>（中継用）支払明細書摘要１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi19 ztysimisikngkmisi19}</td><td>（中継用）支払明細書金額明細１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu19 ztysimisikngkmisituukasyu19}</td><td>（中継用）支払明細書金額明細通貨種類１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou19 ztysimisimeisaibikou19}</td><td>（中継用）支払明細書明細備考１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou19 ztysimisikngkmisihugou19}</td><td>（中継用）支払明細書金額明細符号１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi19 ztysimisimeisaiyobi19}</td><td>（中継用）支払明細書明細予備１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou20 ztysimisitekiyou20}</td><td>（中継用）支払明細書摘要２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi20 ztysimisikngkmisi20}</td><td>（中継用）支払明細書金額明細２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu20 ztysimisikngkmisituukasyu20}</td><td>（中継用）支払明細書金額明細通貨種類２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou20 ztysimisimeisaibikou20}</td><td>（中継用）支払明細書明細備考２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou20 ztysimisikngkmisihugou20}</td><td>（中継用）支払明細書金額明細符号２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi20 ztysimisimeisaiyobi20}</td><td>（中継用）支払明細書明細予備２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou21 ztysimisitekiyou21}</td><td>（中継用）支払明細書摘要２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi21 ztysimisikngkmisi21}</td><td>（中継用）支払明細書金額明細２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu21 ztysimisikngkmisituukasyu21}</td><td>（中継用）支払明細書金額明細通貨種類２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou21 ztysimisimeisaibikou21}</td><td>（中継用）支払明細書明細備考２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou21 ztysimisikngkmisihugou21}</td><td>（中継用）支払明細書金額明細符号２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi21 ztysimisimeisaiyobi21}</td><td>（中継用）支払明細書明細予備２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou22 ztysimisitekiyou22}</td><td>（中継用）支払明細書摘要２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi22 ztysimisikngkmisi22}</td><td>（中継用）支払明細書金額明細２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu22 ztysimisikngkmisituukasyu22}</td><td>（中継用）支払明細書金額明細通貨種類２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou22 ztysimisimeisaibikou22}</td><td>（中継用）支払明細書明細備考２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou22 ztysimisikngkmisihugou22}</td><td>（中継用）支払明細書金額明細符号２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi22 ztysimisimeisaiyobi22}</td><td>（中継用）支払明細書明細予備２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou23 ztysimisitekiyou23}</td><td>（中継用）支払明細書摘要２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi23 ztysimisikngkmisi23}</td><td>（中継用）支払明細書金額明細２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu23 ztysimisikngkmisituukasyu23}</td><td>（中継用）支払明細書金額明細通貨種類２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou23 ztysimisimeisaibikou23}</td><td>（中継用）支払明細書明細備考２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou23 ztysimisikngkmisihugou23}</td><td>（中継用）支払明細書金額明細符号２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi23 ztysimisimeisaiyobi23}</td><td>（中継用）支払明細書明細予備２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou24 ztysimisitekiyou24}</td><td>（中継用）支払明細書摘要２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi24 ztysimisikngkmisi24}</td><td>（中継用）支払明細書金額明細２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu24 ztysimisikngkmisituukasyu24}</td><td>（中継用）支払明細書金額明細通貨種類２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou24 ztysimisimeisaibikou24}</td><td>（中継用）支払明細書明細備考２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou24 ztysimisikngkmisihugou24}</td><td>（中継用）支払明細書金額明細符号２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi24 ztysimisimeisaiyobi24}</td><td>（中継用）支払明細書明細予備２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisitekiyou25 ztysimisitekiyou25}</td><td>（中継用）支払明細書摘要２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisi25 ztysimisikngkmisi25}</td><td>（中継用）支払明細書金額明細２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisituukasyu25 ztysimisikngkmisituukasyu25}</td><td>（中継用）支払明細書金額明細通貨種類２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibikou25 ztysimisimeisaibikou25}</td><td>（中継用）支払明細書明細備考２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisikngkmisihugou25 ztysimisikngkmisihugou25}</td><td>（中継用）支払明細書金額明細符号２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaiyobi25 ztysimisimeisaiyobi25}</td><td>（中継用）支払明細書明細予備２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibuyobi1x1 ztysimisimeisaibuyobi1x1}</td><td>（中継用）支払明細書明細部予備１－１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibuyobi1x2 ztysimisimeisaibuyobi1x2}</td><td>（中継用）支払明細書明細部予備１－２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibuyobi1x3 ztysimisimeisaibuyobi1x3}</td><td>（中継用）支払明細書明細部予備１－３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibuyobi1x4 ztysimisimeisaibuyobi1x4}</td><td>（中継用）支払明細書明細部予備１－４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibuyobi1x5 ztysimisimeisaibuyobi1x5}</td><td>（中継用）支払明細書明細部予備１－５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibuyobi1x6 ztysimisimeisaibuyobi1x6}</td><td>（中継用）支払明細書明細部予備１－６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisisigoukeikingaku ztysimisisigoukeikingaku}</td><td>（中継用）支払明細書支払合計金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisisigoukeituukasyu ztysimisisigoukeituukasyu}</td><td>（中継用）支払明細書支払合計通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibuyobi2 ztysimisimeisaibuyobi2}</td><td>（中継用）支払明細書明細部予備２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisituutiranmidasi ztysimisituutiranmidasi}</td><td>（中継用）支払明細書通知欄見出し</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg1 ztysimisifreemsg1}</td><td>（中継用）支払明細書フリーメッセージ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg2 ztysimisifreemsg2}</td><td>（中継用）支払明細書フリーメッセージ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg3 ztysimisifreemsg3}</td><td>（中継用）支払明細書フリーメッセージ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg4 ztysimisifreemsg4}</td><td>（中継用）支払明細書フリーメッセージ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg5 ztysimisifreemsg5}</td><td>（中継用）支払明細書フリーメッセージ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg6 ztysimisifreemsg6}</td><td>（中継用）支払明細書フリーメッセージ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg7 ztysimisifreemsg7}</td><td>（中継用）支払明細書フリーメッセージ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg8 ztysimisifreemsg8}</td><td>（中継用）支払明細書フリーメッセージ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg9 ztysimisifreemsg9}</td><td>（中継用）支払明細書フリーメッセージ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg10 ztysimisifreemsg10}</td><td>（中継用）支払明細書フリーメッセージ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg11 ztysimisifreemsg11}</td><td>（中継用）支払明細書フリーメッセージ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg12 ztysimisifreemsg12}</td><td>（中継用）支払明細書フリーメッセージ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg13 ztysimisifreemsg13}</td><td>（中継用）支払明細書フリーメッセージ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg14 ztysimisifreemsg14}</td><td>（中継用）支払明細書フリーメッセージ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg15 ztysimisifreemsg15}</td><td>（中継用）支払明細書フリーメッセージ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg16 ztysimisifreemsg16}</td><td>（中継用）支払明細書フリーメッセージ１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg17 ztysimisifreemsg17}</td><td>（中継用）支払明細書フリーメッセージ１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg18 ztysimisifreemsg18}</td><td>（中継用）支払明細書フリーメッセージ１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg19 ztysimisifreemsg19}</td><td>（中継用）支払明細書フリーメッセージ１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg20 ztysimisifreemsg20}</td><td>（中継用）支払明細書フリーメッセージ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg21 ztysimisifreemsg21}</td><td>（中継用）支払明細書フリーメッセージ２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg22 ztysimisifreemsg22}</td><td>（中継用）支払明細書フリーメッセージ２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg23 ztysimisifreemsg23}</td><td>（中継用）支払明細書フリーメッセージ２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg24 ztysimisifreemsg24}</td><td>（中継用）支払明細書フリーメッセージ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg25 ztysimisifreemsg25}</td><td>（中継用）支払明細書フリーメッセージ２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg26 ztysimisifreemsg26}</td><td>（中継用）支払明細書フリーメッセージ２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg27 ztysimisifreemsg27}</td><td>（中継用）支払明細書フリーメッセージ２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg28 ztysimisifreemsg28}</td><td>（中継用）支払明細書フリーメッセージ２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg29 ztysimisifreemsg29}</td><td>（中継用）支払明細書フリーメッセージ２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg30 ztysimisifreemsg30}</td><td>（中継用）支払明細書フリーメッセージ３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg31 ztysimisifreemsg31}</td><td>（中継用）支払明細書フリーメッセージ３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg32 ztysimisifreemsg32}</td><td>（中継用）支払明細書フリーメッセージ３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg33 ztysimisifreemsg33}</td><td>（中継用）支払明細書フリーメッセージ３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg34 ztysimisifreemsg34}</td><td>（中継用）支払明細書フリーメッセージ３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg35 ztysimisifreemsg35}</td><td>（中継用）支払明細書フリーメッセージ３５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg36 ztysimisifreemsg36}</td><td>（中継用）支払明細書フリーメッセージ３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg37 ztysimisifreemsg37}</td><td>（中継用）支払明細書フリーメッセージ３７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg38 ztysimisifreemsg38}</td><td>（中継用）支払明細書フリーメッセージ３８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg39 ztysimisifreemsg39}</td><td>（中継用）支払明細書フリーメッセージ３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg40 ztysimisifreemsg40}</td><td>（中継用）支払明細書フリーメッセージ４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg41 ztysimisifreemsg41}</td><td>（中継用）支払明細書フリーメッセージ４１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg42 ztysimisifreemsg42}</td><td>（中継用）支払明細書フリーメッセージ４２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg43 ztysimisifreemsg43}</td><td>（中継用）支払明細書フリーメッセージ４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg44 ztysimisifreemsg44}</td><td>（中継用）支払明細書フリーメッセージ４４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg45 ztysimisifreemsg45}</td><td>（中継用）支払明細書フリーメッセージ４５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisifreemsg46 ztysimisifreemsg46}</td><td>（中継用）支払明細書フリーメッセージ４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiosirasemongon3x1 ztysimisiosirasemongon3x1}</td><td>（中継用）支払明細書お知らせ文言３－１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisiosirasemongon3x2 ztysimisiosirasemongon3x2}</td><td>（中継用）支払明細書お知らせ文言３－２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisisynykngk ztysimisisynykngk}</td><td>（中継用）支払明細書収入金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisihtykeihi ztysimisihtykeihi}</td><td>（中継用）支払明細書必要経費</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykztkgk ztykztkgk}</td><td>（中継用）課税対象金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeitratkikbn ztyzeitratkikbn}</td><td>（中継用）税取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykhenkouumukbn ztykykhenkouumukbn}</td><td>（中継用）契約者変更有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkykhtykeihi ztyshrkykhtykeihi}</td><td>（中継用）支払時契約者必要経費</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibuyobi3x1 ztysimisimeisaibuyobi3x1}</td><td>（中継用）支払明細書明細部予備３－１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysimisimeisaibuyobi3x2 ztysimisimeisaibuyobi3x2}</td><td>（中継用）支払明細書明細部予備３－２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SiShrdetailTy
 * @see     PKZT_SiShrdetailTy
 * @see     QZT_SiShrdetailTy
 * @see     GenQZT_SiShrdetailTy
 */
@MappedSuperclass
@Table(name=GenZT_SiShrdetailTy.TABLE_NAME)
@IdClass(value=PKZT_SiShrdetailTy.class)
public abstract class GenZT_SiShrdetailTy extends AbstractExDBEntity<ZT_SiShrdetailTy, PKZT_SiShrdetailTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SiShrdetailTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYSYODOUHUUKBN          = "ztysyodouhuukbn";
    public static final String ZTYSIKIBETUNO            = "ztysikibetuno";
    public static final String ZTYSIKYTKMKYOBI1         = "ztysikytkmkyobi1";
    public static final String ZTYSHSKYNO               = "ztyshskyno";
    public static final String ZTYSHSKADR1KJ            = "ztyshskadr1kj";
    public static final String ZTYSHSKADR2KJ            = "ztyshskadr2kj";
    public static final String ZTYSHSKADR3KJ            = "ztyshskadr3kj";
    public static final String ZTYSHSNMKJSIMISI         = "ztyshsnmkjsimisi";
    public static final String ZTYSIMISITUUTIMEI        = "ztysimisituutimei";
    public static final String ZTYSIMISIOSIRASEMONGON1X1 = "ztysimisiosirasemongon1x1";
    public static final String ZTYSIMISIOSIRASEMONGON1X2 = "ztysimisiosirasemongon1x2";
    public static final String ZTYSIMISIOSIRASEMONGON2X1 = "ztysimisiosirasemongon2x1";
    public static final String ZTYSIMISIOSIRASEMONGON2X2 = "ztysimisiosirasemongon2x2";
    public static final String ZTYSIMISIOSIRASEMONGON2X3 = "ztysimisiosirasemongon2x3";
    public static final String ZTYSIMISIOSIRASEMONGON2X4 = "ztysimisiosirasemongon2x4";
    public static final String ZTYSIMISIOSIRASEMONGON2X5 = "ztysimisiosirasemongon2x5";
    public static final String ZTYTAWYNO                = "ztytawyno";
    public static final String ZTYTAWADR1KJ30           = "ztytawadr1kj30";
    public static final String ZTYTAWADR2KJ30           = "ztytawadr2kj30";
    public static final String ZTYTAWADR3KJ30           = "ztytawadr3kj30";
    public static final String ZTYTAWTELNO              = "ztytawtelno";
    public static final String ZTYSIMISIATENABUYOBI1    = "ztysimisiatenabuyobi1";
    public static final String ZTYSIMISIATENABUYOBI2    = "ztysimisiatenabuyobi2";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYKYKNMKJ               = "ztykyknmkj";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYTYOUHYOUYMDWA         = "ztytyouhyouymdwa";
    public static final String ZTYSIHARAIBIWAREKI       = "ztysiharaibiwareki";
    public static final String ZTYBANKNMKJ              = "ztybanknmkj";
    public static final String ZTYSITENNMKJ             = "ztysitennmkj";
    public static final String ZTYYOKINSYUMOKUMEIKANJI  = "ztyyokinsyumokumeikanji";
    public static final String ZTYKOUZANO12KETA         = "ztykouzano12keta";
    public static final String ZTYKZMEIGINMKN           = "ztykzmeiginmkn";
    public static final String ZTYKOUZAMASKINGMSG       = "ztykouzamaskingmsg";
    public static final String ZTYSIMISISUMMARYBUYOBI1  = "ztysimisisummarybuyobi1";
    public static final String ZTYSIMISISUMMARYBUYOBI2  = "ztysimisisummarybuyobi2";
    public static final String ZTYSIMISITEKIYOURANMIDASI = "ztysimisitekiyouranmidasi";
    public static final String ZTYSIMISIMEISAIRANMIDASI = "ztysimisimeisairanmidasi";
    public static final String ZTYSIMISIBIKOURANMIDASI  = "ztysimisibikouranmidasi";
    public static final String ZTYSIMISIMEISAIBUMIDASIYOBI = "ztysimisimeisaibumidasiyobi";
    public static final String ZTYSIMISITEKIYOU1        = "ztysimisitekiyou1";
    public static final String ZTYSIMISIKNGKMISI1       = "ztysimisikngkmisi1";
    public static final String ZTYSIMISIKNGKMISITUUKASYU1 = "ztysimisikngkmisituukasyu1";
    public static final String ZTYSIMISIMEISAIBIKOU1    = "ztysimisimeisaibikou1";
    public static final String ZTYSIMISIKNGKMISIHUGOU1  = "ztysimisikngkmisihugou1";
    public static final String ZTYSIMISIMEISAIYOBI1     = "ztysimisimeisaiyobi1";
    public static final String ZTYSIMISITEKIYOU2        = "ztysimisitekiyou2";
    public static final String ZTYSIMISIKNGKMISI2       = "ztysimisikngkmisi2";
    public static final String ZTYSIMISIKNGKMISITUUKASYU2 = "ztysimisikngkmisituukasyu2";
    public static final String ZTYSIMISIMEISAIBIKOU2    = "ztysimisimeisaibikou2";
    public static final String ZTYSIMISIKNGKMISIHUGOU2  = "ztysimisikngkmisihugou2";
    public static final String ZTYSIMISIMEISAIYOBI2     = "ztysimisimeisaiyobi2";
    public static final String ZTYSIMISITEKIYOU3        = "ztysimisitekiyou3";
    public static final String ZTYSIMISIKNGKMISI3       = "ztysimisikngkmisi3";
    public static final String ZTYSIMISIKNGKMISITUUKASYU3 = "ztysimisikngkmisituukasyu3";
    public static final String ZTYSIMISIMEISAIBIKOU3    = "ztysimisimeisaibikou3";
    public static final String ZTYSIMISIKNGKMISIHUGOU3  = "ztysimisikngkmisihugou3";
    public static final String ZTYSIMISIMEISAIYOBI3     = "ztysimisimeisaiyobi3";
    public static final String ZTYSIMISITEKIYOU4        = "ztysimisitekiyou4";
    public static final String ZTYSIMISIKNGKMISI4       = "ztysimisikngkmisi4";
    public static final String ZTYSIMISIKNGKMISITUUKASYU4 = "ztysimisikngkmisituukasyu4";
    public static final String ZTYSIMISIMEISAIBIKOU4    = "ztysimisimeisaibikou4";
    public static final String ZTYSIMISIKNGKMISIHUGOU4  = "ztysimisikngkmisihugou4";
    public static final String ZTYSIMISIMEISAIYOBI4     = "ztysimisimeisaiyobi4";
    public static final String ZTYSIMISITEKIYOU5        = "ztysimisitekiyou5";
    public static final String ZTYSIMISIKNGKMISI5       = "ztysimisikngkmisi5";
    public static final String ZTYSIMISIKNGKMISITUUKASYU5 = "ztysimisikngkmisituukasyu5";
    public static final String ZTYSIMISIMEISAIBIKOU5    = "ztysimisimeisaibikou5";
    public static final String ZTYSIMISIKNGKMISIHUGOU5  = "ztysimisikngkmisihugou5";
    public static final String ZTYSIMISIMEISAIYOBI5     = "ztysimisimeisaiyobi5";
    public static final String ZTYSIMISITEKIYOU6        = "ztysimisitekiyou6";
    public static final String ZTYSIMISIKNGKMISI6       = "ztysimisikngkmisi6";
    public static final String ZTYSIMISIKNGKMISITUUKASYU6 = "ztysimisikngkmisituukasyu6";
    public static final String ZTYSIMISIMEISAIBIKOU6    = "ztysimisimeisaibikou6";
    public static final String ZTYSIMISIKNGKMISIHUGOU6  = "ztysimisikngkmisihugou6";
    public static final String ZTYSIMISIMEISAIYOBI6     = "ztysimisimeisaiyobi6";
    public static final String ZTYSIMISITEKIYOU7        = "ztysimisitekiyou7";
    public static final String ZTYSIMISIKNGKMISI7       = "ztysimisikngkmisi7";
    public static final String ZTYSIMISIKNGKMISITUUKASYU7 = "ztysimisikngkmisituukasyu7";
    public static final String ZTYSIMISIMEISAIBIKOU7    = "ztysimisimeisaibikou7";
    public static final String ZTYSIMISIKNGKMISIHUGOU7  = "ztysimisikngkmisihugou7";
    public static final String ZTYSIMISIMEISAIYOBI7     = "ztysimisimeisaiyobi7";
    public static final String ZTYSIMISITEKIYOU8        = "ztysimisitekiyou8";
    public static final String ZTYSIMISIKNGKMISI8       = "ztysimisikngkmisi8";
    public static final String ZTYSIMISIKNGKMISITUUKASYU8 = "ztysimisikngkmisituukasyu8";
    public static final String ZTYSIMISIMEISAIBIKOU8    = "ztysimisimeisaibikou8";
    public static final String ZTYSIMISIKNGKMISIHUGOU8  = "ztysimisikngkmisihugou8";
    public static final String ZTYSIMISIMEISAIYOBI8     = "ztysimisimeisaiyobi8";
    public static final String ZTYSIMISITEKIYOU9        = "ztysimisitekiyou9";
    public static final String ZTYSIMISIKNGKMISI9       = "ztysimisikngkmisi9";
    public static final String ZTYSIMISIKNGKMISITUUKASYU9 = "ztysimisikngkmisituukasyu9";
    public static final String ZTYSIMISIMEISAIBIKOU9    = "ztysimisimeisaibikou9";
    public static final String ZTYSIMISIKNGKMISIHUGOU9  = "ztysimisikngkmisihugou9";
    public static final String ZTYSIMISIMEISAIYOBI9     = "ztysimisimeisaiyobi9";
    public static final String ZTYSIMISITEKIYOU10       = "ztysimisitekiyou10";
    public static final String ZTYSIMISIKNGKMISI10      = "ztysimisikngkmisi10";
    public static final String ZTYSIMISIKNGKMISITUUKASYU10 = "ztysimisikngkmisituukasyu10";
    public static final String ZTYSIMISIMEISAIBIKOU10   = "ztysimisimeisaibikou10";
    public static final String ZTYSIMISIKNGKMISIHUGOU10 = "ztysimisikngkmisihugou10";
    public static final String ZTYSIMISIMEISAIYOBI10    = "ztysimisimeisaiyobi10";
    public static final String ZTYSIMISITEKIYOU11       = "ztysimisitekiyou11";
    public static final String ZTYSIMISIKNGKMISI11      = "ztysimisikngkmisi11";
    public static final String ZTYSIMISIKNGKMISITUUKASYU11 = "ztysimisikngkmisituukasyu11";
    public static final String ZTYSIMISIMEISAIBIKOU11   = "ztysimisimeisaibikou11";
    public static final String ZTYSIMISIKNGKMISIHUGOU11 = "ztysimisikngkmisihugou11";
    public static final String ZTYSIMISIMEISAIYOBI11    = "ztysimisimeisaiyobi11";
    public static final String ZTYSIMISITEKIYOU12       = "ztysimisitekiyou12";
    public static final String ZTYSIMISIKNGKMISI12      = "ztysimisikngkmisi12";
    public static final String ZTYSIMISIKNGKMISITUUKASYU12 = "ztysimisikngkmisituukasyu12";
    public static final String ZTYSIMISIMEISAIBIKOU12   = "ztysimisimeisaibikou12";
    public static final String ZTYSIMISIKNGKMISIHUGOU12 = "ztysimisikngkmisihugou12";
    public static final String ZTYSIMISIMEISAIYOBI12    = "ztysimisimeisaiyobi12";
    public static final String ZTYSIMISITEKIYOU13       = "ztysimisitekiyou13";
    public static final String ZTYSIMISIKNGKMISI13      = "ztysimisikngkmisi13";
    public static final String ZTYSIMISIKNGKMISITUUKASYU13 = "ztysimisikngkmisituukasyu13";
    public static final String ZTYSIMISIMEISAIBIKOU13   = "ztysimisimeisaibikou13";
    public static final String ZTYSIMISIKNGKMISIHUGOU13 = "ztysimisikngkmisihugou13";
    public static final String ZTYSIMISIMEISAIYOBI13    = "ztysimisimeisaiyobi13";
    public static final String ZTYSIMISITEKIYOU14       = "ztysimisitekiyou14";
    public static final String ZTYSIMISIKNGKMISI14      = "ztysimisikngkmisi14";
    public static final String ZTYSIMISIKNGKMISITUUKASYU14 = "ztysimisikngkmisituukasyu14";
    public static final String ZTYSIMISIMEISAIBIKOU14   = "ztysimisimeisaibikou14";
    public static final String ZTYSIMISIKNGKMISIHUGOU14 = "ztysimisikngkmisihugou14";
    public static final String ZTYSIMISIMEISAIYOBI14    = "ztysimisimeisaiyobi14";
    public static final String ZTYSIMISITEKIYOU15       = "ztysimisitekiyou15";
    public static final String ZTYSIMISIKNGKMISI15      = "ztysimisikngkmisi15";
    public static final String ZTYSIMISIKNGKMISITUUKASYU15 = "ztysimisikngkmisituukasyu15";
    public static final String ZTYSIMISIMEISAIBIKOU15   = "ztysimisimeisaibikou15";
    public static final String ZTYSIMISIKNGKMISIHUGOU15 = "ztysimisikngkmisihugou15";
    public static final String ZTYSIMISIMEISAIYOBI15    = "ztysimisimeisaiyobi15";
    public static final String ZTYSIMISITEKIYOU16       = "ztysimisitekiyou16";
    public static final String ZTYSIMISIKNGKMISI16      = "ztysimisikngkmisi16";
    public static final String ZTYSIMISIKNGKMISITUUKASYU16 = "ztysimisikngkmisituukasyu16";
    public static final String ZTYSIMISIMEISAIBIKOU16   = "ztysimisimeisaibikou16";
    public static final String ZTYSIMISIKNGKMISIHUGOU16 = "ztysimisikngkmisihugou16";
    public static final String ZTYSIMISIMEISAIYOBI16    = "ztysimisimeisaiyobi16";
    public static final String ZTYSIMISITEKIYOU17       = "ztysimisitekiyou17";
    public static final String ZTYSIMISIKNGKMISI17      = "ztysimisikngkmisi17";
    public static final String ZTYSIMISIKNGKMISITUUKASYU17 = "ztysimisikngkmisituukasyu17";
    public static final String ZTYSIMISIMEISAIBIKOU17   = "ztysimisimeisaibikou17";
    public static final String ZTYSIMISIKNGKMISIHUGOU17 = "ztysimisikngkmisihugou17";
    public static final String ZTYSIMISIMEISAIYOBI17    = "ztysimisimeisaiyobi17";
    public static final String ZTYSIMISITEKIYOU18       = "ztysimisitekiyou18";
    public static final String ZTYSIMISIKNGKMISI18      = "ztysimisikngkmisi18";
    public static final String ZTYSIMISIKNGKMISITUUKASYU18 = "ztysimisikngkmisituukasyu18";
    public static final String ZTYSIMISIMEISAIBIKOU18   = "ztysimisimeisaibikou18";
    public static final String ZTYSIMISIKNGKMISIHUGOU18 = "ztysimisikngkmisihugou18";
    public static final String ZTYSIMISIMEISAIYOBI18    = "ztysimisimeisaiyobi18";
    public static final String ZTYSIMISITEKIYOU19       = "ztysimisitekiyou19";
    public static final String ZTYSIMISIKNGKMISI19      = "ztysimisikngkmisi19";
    public static final String ZTYSIMISIKNGKMISITUUKASYU19 = "ztysimisikngkmisituukasyu19";
    public static final String ZTYSIMISIMEISAIBIKOU19   = "ztysimisimeisaibikou19";
    public static final String ZTYSIMISIKNGKMISIHUGOU19 = "ztysimisikngkmisihugou19";
    public static final String ZTYSIMISIMEISAIYOBI19    = "ztysimisimeisaiyobi19";
    public static final String ZTYSIMISITEKIYOU20       = "ztysimisitekiyou20";
    public static final String ZTYSIMISIKNGKMISI20      = "ztysimisikngkmisi20";
    public static final String ZTYSIMISIKNGKMISITUUKASYU20 = "ztysimisikngkmisituukasyu20";
    public static final String ZTYSIMISIMEISAIBIKOU20   = "ztysimisimeisaibikou20";
    public static final String ZTYSIMISIKNGKMISIHUGOU20 = "ztysimisikngkmisihugou20";
    public static final String ZTYSIMISIMEISAIYOBI20    = "ztysimisimeisaiyobi20";
    public static final String ZTYSIMISITEKIYOU21       = "ztysimisitekiyou21";
    public static final String ZTYSIMISIKNGKMISI21      = "ztysimisikngkmisi21";
    public static final String ZTYSIMISIKNGKMISITUUKASYU21 = "ztysimisikngkmisituukasyu21";
    public static final String ZTYSIMISIMEISAIBIKOU21   = "ztysimisimeisaibikou21";
    public static final String ZTYSIMISIKNGKMISIHUGOU21 = "ztysimisikngkmisihugou21";
    public static final String ZTYSIMISIMEISAIYOBI21    = "ztysimisimeisaiyobi21";
    public static final String ZTYSIMISITEKIYOU22       = "ztysimisitekiyou22";
    public static final String ZTYSIMISIKNGKMISI22      = "ztysimisikngkmisi22";
    public static final String ZTYSIMISIKNGKMISITUUKASYU22 = "ztysimisikngkmisituukasyu22";
    public static final String ZTYSIMISIMEISAIBIKOU22   = "ztysimisimeisaibikou22";
    public static final String ZTYSIMISIKNGKMISIHUGOU22 = "ztysimisikngkmisihugou22";
    public static final String ZTYSIMISIMEISAIYOBI22    = "ztysimisimeisaiyobi22";
    public static final String ZTYSIMISITEKIYOU23       = "ztysimisitekiyou23";
    public static final String ZTYSIMISIKNGKMISI23      = "ztysimisikngkmisi23";
    public static final String ZTYSIMISIKNGKMISITUUKASYU23 = "ztysimisikngkmisituukasyu23";
    public static final String ZTYSIMISIMEISAIBIKOU23   = "ztysimisimeisaibikou23";
    public static final String ZTYSIMISIKNGKMISIHUGOU23 = "ztysimisikngkmisihugou23";
    public static final String ZTYSIMISIMEISAIYOBI23    = "ztysimisimeisaiyobi23";
    public static final String ZTYSIMISITEKIYOU24       = "ztysimisitekiyou24";
    public static final String ZTYSIMISIKNGKMISI24      = "ztysimisikngkmisi24";
    public static final String ZTYSIMISIKNGKMISITUUKASYU24 = "ztysimisikngkmisituukasyu24";
    public static final String ZTYSIMISIMEISAIBIKOU24   = "ztysimisimeisaibikou24";
    public static final String ZTYSIMISIKNGKMISIHUGOU24 = "ztysimisikngkmisihugou24";
    public static final String ZTYSIMISIMEISAIYOBI24    = "ztysimisimeisaiyobi24";
    public static final String ZTYSIMISITEKIYOU25       = "ztysimisitekiyou25";
    public static final String ZTYSIMISIKNGKMISI25      = "ztysimisikngkmisi25";
    public static final String ZTYSIMISIKNGKMISITUUKASYU25 = "ztysimisikngkmisituukasyu25";
    public static final String ZTYSIMISIMEISAIBIKOU25   = "ztysimisimeisaibikou25";
    public static final String ZTYSIMISIKNGKMISIHUGOU25 = "ztysimisikngkmisihugou25";
    public static final String ZTYSIMISIMEISAIYOBI25    = "ztysimisimeisaiyobi25";
    public static final String ZTYSIMISIMEISAIBUYOBI1X1 = "ztysimisimeisaibuyobi1x1";
    public static final String ZTYSIMISIMEISAIBUYOBI1X2 = "ztysimisimeisaibuyobi1x2";
    public static final String ZTYSIMISIMEISAIBUYOBI1X3 = "ztysimisimeisaibuyobi1x3";
    public static final String ZTYSIMISIMEISAIBUYOBI1X4 = "ztysimisimeisaibuyobi1x4";
    public static final String ZTYSIMISIMEISAIBUYOBI1X5 = "ztysimisimeisaibuyobi1x5";
    public static final String ZTYSIMISIMEISAIBUYOBI1X6 = "ztysimisimeisaibuyobi1x6";
    public static final String ZTYSIMISISIGOUKEIKINGAKU = "ztysimisisigoukeikingaku";
    public static final String ZTYSIMISISIGOUKEITUUKASYU = "ztysimisisigoukeituukasyu";
    public static final String ZTYSIMISIMEISAIBUYOBI2   = "ztysimisimeisaibuyobi2";
    public static final String ZTYSIMISITUUTIRANMIDASI  = "ztysimisituutiranmidasi";
    public static final String ZTYSIMISIFREEMSG1        = "ztysimisifreemsg1";
    public static final String ZTYSIMISIFREEMSG2        = "ztysimisifreemsg2";
    public static final String ZTYSIMISIFREEMSG3        = "ztysimisifreemsg3";
    public static final String ZTYSIMISIFREEMSG4        = "ztysimisifreemsg4";
    public static final String ZTYSIMISIFREEMSG5        = "ztysimisifreemsg5";
    public static final String ZTYSIMISIFREEMSG6        = "ztysimisifreemsg6";
    public static final String ZTYSIMISIFREEMSG7        = "ztysimisifreemsg7";
    public static final String ZTYSIMISIFREEMSG8        = "ztysimisifreemsg8";
    public static final String ZTYSIMISIFREEMSG9        = "ztysimisifreemsg9";
    public static final String ZTYSIMISIFREEMSG10       = "ztysimisifreemsg10";
    public static final String ZTYSIMISIFREEMSG11       = "ztysimisifreemsg11";
    public static final String ZTYSIMISIFREEMSG12       = "ztysimisifreemsg12";
    public static final String ZTYSIMISIFREEMSG13       = "ztysimisifreemsg13";
    public static final String ZTYSIMISIFREEMSG14       = "ztysimisifreemsg14";
    public static final String ZTYSIMISIFREEMSG15       = "ztysimisifreemsg15";
    public static final String ZTYSIMISIFREEMSG16       = "ztysimisifreemsg16";
    public static final String ZTYSIMISIFREEMSG17       = "ztysimisifreemsg17";
    public static final String ZTYSIMISIFREEMSG18       = "ztysimisifreemsg18";
    public static final String ZTYSIMISIFREEMSG19       = "ztysimisifreemsg19";
    public static final String ZTYSIMISIFREEMSG20       = "ztysimisifreemsg20";
    public static final String ZTYSIMISIFREEMSG21       = "ztysimisifreemsg21";
    public static final String ZTYSIMISIFREEMSG22       = "ztysimisifreemsg22";
    public static final String ZTYSIMISIFREEMSG23       = "ztysimisifreemsg23";
    public static final String ZTYSIMISIFREEMSG24       = "ztysimisifreemsg24";
    public static final String ZTYSIMISIFREEMSG25       = "ztysimisifreemsg25";
    public static final String ZTYSIMISIFREEMSG26       = "ztysimisifreemsg26";
    public static final String ZTYSIMISIFREEMSG27       = "ztysimisifreemsg27";
    public static final String ZTYSIMISIFREEMSG28       = "ztysimisifreemsg28";
    public static final String ZTYSIMISIFREEMSG29       = "ztysimisifreemsg29";
    public static final String ZTYSIMISIFREEMSG30       = "ztysimisifreemsg30";
    public static final String ZTYSIMISIFREEMSG31       = "ztysimisifreemsg31";
    public static final String ZTYSIMISIFREEMSG32       = "ztysimisifreemsg32";
    public static final String ZTYSIMISIFREEMSG33       = "ztysimisifreemsg33";
    public static final String ZTYSIMISIFREEMSG34       = "ztysimisifreemsg34";
    public static final String ZTYSIMISIFREEMSG35       = "ztysimisifreemsg35";
    public static final String ZTYSIMISIFREEMSG36       = "ztysimisifreemsg36";
    public static final String ZTYSIMISIFREEMSG37       = "ztysimisifreemsg37";
    public static final String ZTYSIMISIFREEMSG38       = "ztysimisifreemsg38";
    public static final String ZTYSIMISIFREEMSG39       = "ztysimisifreemsg39";
    public static final String ZTYSIMISIFREEMSG40       = "ztysimisifreemsg40";
    public static final String ZTYSIMISIFREEMSG41       = "ztysimisifreemsg41";
    public static final String ZTYSIMISIFREEMSG42       = "ztysimisifreemsg42";
    public static final String ZTYSIMISIFREEMSG43       = "ztysimisifreemsg43";
    public static final String ZTYSIMISIFREEMSG44       = "ztysimisifreemsg44";
    public static final String ZTYSIMISIFREEMSG45       = "ztysimisifreemsg45";
    public static final String ZTYSIMISIFREEMSG46       = "ztysimisifreemsg46";
    public static final String ZTYSIMISIOSIRASEMONGON3X1 = "ztysimisiosirasemongon3x1";
    public static final String ZTYSIMISIOSIRASEMONGON3X2 = "ztysimisiosirasemongon3x2";
    public static final String ZTYSIMISISYNYKNGK        = "ztysimisisynykngk";
    public static final String ZTYSIMISIHTYKEIHI        = "ztysimisihtykeihi";
    public static final String ZTYKZTKGK                = "ztykztkgk";
    public static final String ZTYZEITRATKIKBN          = "ztyzeitratkikbn";
    public static final String ZTYKYKHENKOUUMUKBN       = "ztykykhenkouumukbn";
    public static final String ZTYSHRKYKHTYKEIHI        = "ztyshrkykhtykeihi";
    public static final String ZTYSIMISIMEISAIBUYOBI3X1 = "ztysimisimeisaibuyobi3x1";
    public static final String ZTYSIMISIMEISAIBUYOBI3X2 = "ztysimisimeisaibuyobi3x2";

    private final PKZT_SiShrdetailTy primaryKey;

    public GenZT_SiShrdetailTy() {
        primaryKey = new PKZT_SiShrdetailTy();
    }

    public GenZT_SiShrdetailTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        primaryKey = new PKZT_SiShrdetailTy(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_SiShrdetailTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SiShrdetailTy> getMetaClass() {
        return QZT_SiShrdetailTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_SiShrdetailTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_SiShrdetailTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SiShrdetailTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_SiShrdetailTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztysyodouhuukbn;

    @Column(name=GenZT_SiShrdetailTy.ZTYSYODOUHUUKBN)
    public String getZtysyodouhuukbn() {
        return ztysyodouhuukbn;
    }

    public void setZtysyodouhuukbn(String pZtysyodouhuukbn) {
        ztysyodouhuukbn = pZtysyodouhuukbn;
    }

    @Id
    @Column(name=GenZT_SiShrdetailTy.ZTYSIKIBETUNO)
    public String getZtysikibetuno() {
        return getPrimaryKey().getZtysikibetuno();
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        getPrimaryKey().setZtysikibetuno(pZtysikibetuno);
    }

    private String ztysikytkmkyobi1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIKYTKMKYOBI1)
    public String getZtysikytkmkyobi1() {
        return ztysikytkmkyobi1;
    }

    public void setZtysikytkmkyobi1(String pZtysikytkmkyobi1) {
        ztysikytkmkyobi1 = pZtysikytkmkyobi1;
    }

    private String ztyshskyno;

    @Column(name=GenZT_SiShrdetailTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_SiShrdetailTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_SiShrdetailTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_SiShrdetailTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkjsimisi;

    @Column(name=GenZT_SiShrdetailTy.ZTYSHSNMKJSIMISI)
    public String getZtyshsnmkjsimisi() {
        return ztyshsnmkjsimisi;
    }

    public void setZtyshsnmkjsimisi(String pZtyshsnmkjsimisi) {
        ztyshsnmkjsimisi = pZtyshsnmkjsimisi;
    }

    private String ztysimisituutimei;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITUUTIMEI)
    public String getZtysimisituutimei() {
        return ztysimisituutimei;
    }

    public void setZtysimisituutimei(String pZtysimisituutimei) {
        ztysimisituutimei = pZtysimisituutimei;
    }

    private String ztysimisiosirasemongon1x1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIOSIRASEMONGON1X1)
    public String getZtysimisiosirasemongon1x1() {
        return ztysimisiosirasemongon1x1;
    }

    public void setZtysimisiosirasemongon1x1(String pZtysimisiosirasemongon1x1) {
        ztysimisiosirasemongon1x1 = pZtysimisiosirasemongon1x1;
    }

    private String ztysimisiosirasemongon1x2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIOSIRASEMONGON1X2)
    public String getZtysimisiosirasemongon1x2() {
        return ztysimisiosirasemongon1x2;
    }

    public void setZtysimisiosirasemongon1x2(String pZtysimisiosirasemongon1x2) {
        ztysimisiosirasemongon1x2 = pZtysimisiosirasemongon1x2;
    }

    private String ztysimisiosirasemongon2x1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIOSIRASEMONGON2X1)
    public String getZtysimisiosirasemongon2x1() {
        return ztysimisiosirasemongon2x1;
    }

    public void setZtysimisiosirasemongon2x1(String pZtysimisiosirasemongon2x1) {
        ztysimisiosirasemongon2x1 = pZtysimisiosirasemongon2x1;
    }

    private String ztysimisiosirasemongon2x2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIOSIRASEMONGON2X2)
    public String getZtysimisiosirasemongon2x2() {
        return ztysimisiosirasemongon2x2;
    }

    public void setZtysimisiosirasemongon2x2(String pZtysimisiosirasemongon2x2) {
        ztysimisiosirasemongon2x2 = pZtysimisiosirasemongon2x2;
    }

    private String ztysimisiosirasemongon2x3;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIOSIRASEMONGON2X3)
    public String getZtysimisiosirasemongon2x3() {
        return ztysimisiosirasemongon2x3;
    }

    public void setZtysimisiosirasemongon2x3(String pZtysimisiosirasemongon2x3) {
        ztysimisiosirasemongon2x3 = pZtysimisiosirasemongon2x3;
    }

    private String ztysimisiosirasemongon2x4;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIOSIRASEMONGON2X4)
    public String getZtysimisiosirasemongon2x4() {
        return ztysimisiosirasemongon2x4;
    }

    public void setZtysimisiosirasemongon2x4(String pZtysimisiosirasemongon2x4) {
        ztysimisiosirasemongon2x4 = pZtysimisiosirasemongon2x4;
    }

    private String ztysimisiosirasemongon2x5;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIOSIRASEMONGON2X5)
    public String getZtysimisiosirasemongon2x5() {
        return ztysimisiosirasemongon2x5;
    }

    public void setZtysimisiosirasemongon2x5(String pZtysimisiosirasemongon2x5) {
        ztysimisiosirasemongon2x5 = pZtysimisiosirasemongon2x5;
    }

    private String ztytawyno;

    @Column(name=GenZT_SiShrdetailTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj30;

    @Column(name=GenZT_SiShrdetailTy.ZTYTAWADR1KJ30)
    public String getZtytawadr1kj30() {
        return ztytawadr1kj30;
    }

    public void setZtytawadr1kj30(String pZtytawadr1kj30) {
        ztytawadr1kj30 = pZtytawadr1kj30;
    }

    private String ztytawadr2kj30;

    @Column(name=GenZT_SiShrdetailTy.ZTYTAWADR2KJ30)
    public String getZtytawadr2kj30() {
        return ztytawadr2kj30;
    }

    public void setZtytawadr2kj30(String pZtytawadr2kj30) {
        ztytawadr2kj30 = pZtytawadr2kj30;
    }

    private String ztytawadr3kj30;

    @Column(name=GenZT_SiShrdetailTy.ZTYTAWADR3KJ30)
    public String getZtytawadr3kj30() {
        return ztytawadr3kj30;
    }

    public void setZtytawadr3kj30(String pZtytawadr3kj30) {
        ztytawadr3kj30 = pZtytawadr3kj30;
    }

    private String ztytawtelno;

    @Column(name=GenZT_SiShrdetailTy.ZTYTAWTELNO)
    public String getZtytawtelno() {
        return ztytawtelno;
    }

    public void setZtytawtelno(String pZtytawtelno) {
        ztytawtelno = pZtytawtelno;
    }

    private String ztysimisiatenabuyobi1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIATENABUYOBI1)
    public String getZtysimisiatenabuyobi1() {
        return ztysimisiatenabuyobi1;
    }

    public void setZtysimisiatenabuyobi1(String pZtysimisiatenabuyobi1) {
        ztysimisiatenabuyobi1 = pZtysimisiatenabuyobi1;
    }

    private String ztysimisiatenabuyobi2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIATENABUYOBI2)
    public String getZtysimisiatenabuyobi2() {
        return ztysimisiatenabuyobi2;
    }

    public void setZtysimisiatenabuyobi2(String pZtysimisiatenabuyobi2) {
        ztysimisiatenabuyobi2 = pZtysimisiatenabuyobi2;
    }

    private String ztysyono2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztykyknmkj;

    @Column(name=GenZT_SiShrdetailTy.ZTYKYKNMKJ)
    public String getZtykyknmkj() {
        return ztykyknmkj;
    }

    public void setZtykyknmkj(String pZtykyknmkj) {
        ztykyknmkj = pZtykyknmkj;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_SiShrdetailTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztytyouhyouymdwa;

    @Column(name=GenZT_SiShrdetailTy.ZTYTYOUHYOUYMDWA)
    public String getZtytyouhyouymdwa() {
        return ztytyouhyouymdwa;
    }

    public void setZtytyouhyouymdwa(String pZtytyouhyouymdwa) {
        ztytyouhyouymdwa = pZtytyouhyouymdwa;
    }

    private String ztysiharaibiwareki;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIHARAIBIWAREKI)
    public String getZtysiharaibiwareki() {
        return ztysiharaibiwareki;
    }

    public void setZtysiharaibiwareki(String pZtysiharaibiwareki) {
        ztysiharaibiwareki = pZtysiharaibiwareki;
    }

    private String ztybanknmkj;

    @Column(name=GenZT_SiShrdetailTy.ZTYBANKNMKJ)
    public String getZtybanknmkj() {
        return ztybanknmkj;
    }

    public void setZtybanknmkj(String pZtybanknmkj) {
        ztybanknmkj = pZtybanknmkj;
    }

    private String ztysitennmkj;

    @Column(name=GenZT_SiShrdetailTy.ZTYSITENNMKJ)
    public String getZtysitennmkj() {
        return ztysitennmkj;
    }

    public void setZtysitennmkj(String pZtysitennmkj) {
        ztysitennmkj = pZtysitennmkj;
    }

    private String ztyyokinsyumokumeikanji;

    @Column(name=GenZT_SiShrdetailTy.ZTYYOKINSYUMOKUMEIKANJI)
    public String getZtyyokinsyumokumeikanji() {
        return ztyyokinsyumokumeikanji;
    }

    public void setZtyyokinsyumokumeikanji(String pZtyyokinsyumokumeikanji) {
        ztyyokinsyumokumeikanji = pZtyyokinsyumokumeikanji;
    }

    private String ztykouzano12keta;

    @Column(name=GenZT_SiShrdetailTy.ZTYKOUZANO12KETA)
    public String getZtykouzano12keta() {
        return ztykouzano12keta;
    }

    public void setZtykouzano12keta(String pZtykouzano12keta) {
        ztykouzano12keta = pZtykouzano12keta;
    }

    private String ztykzmeiginmkn;

    @Column(name=GenZT_SiShrdetailTy.ZTYKZMEIGINMKN)
    public String getZtykzmeiginmkn() {
        return ztykzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setZtykzmeiginmkn(String pZtykzmeiginmkn) {
        ztykzmeiginmkn = pZtykzmeiginmkn;
    }

    private String ztykouzamaskingmsg;

    @Column(name=GenZT_SiShrdetailTy.ZTYKOUZAMASKINGMSG)
    public String getZtykouzamaskingmsg() {
        return ztykouzamaskingmsg;
    }

    public void setZtykouzamaskingmsg(String pZtykouzamaskingmsg) {
        ztykouzamaskingmsg = pZtykouzamaskingmsg;
    }

    private String ztysimisisummarybuyobi1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISISUMMARYBUYOBI1)
    public String getZtysimisisummarybuyobi1() {
        return ztysimisisummarybuyobi1;
    }

    public void setZtysimisisummarybuyobi1(String pZtysimisisummarybuyobi1) {
        ztysimisisummarybuyobi1 = pZtysimisisummarybuyobi1;
    }

    private String ztysimisisummarybuyobi2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISISUMMARYBUYOBI2)
    public String getZtysimisisummarybuyobi2() {
        return ztysimisisummarybuyobi2;
    }

    public void setZtysimisisummarybuyobi2(String pZtysimisisummarybuyobi2) {
        ztysimisisummarybuyobi2 = pZtysimisisummarybuyobi2;
    }

    private String ztysimisitekiyouranmidasi;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOURANMIDASI)
    public String getZtysimisitekiyouranmidasi() {
        return ztysimisitekiyouranmidasi;
    }

    public void setZtysimisitekiyouranmidasi(String pZtysimisitekiyouranmidasi) {
        ztysimisitekiyouranmidasi = pZtysimisitekiyouranmidasi;
    }

    private String ztysimisimeisairanmidasi;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIRANMIDASI)
    public String getZtysimisimeisairanmidasi() {
        return ztysimisimeisairanmidasi;
    }

    public void setZtysimisimeisairanmidasi(String pZtysimisimeisairanmidasi) {
        ztysimisimeisairanmidasi = pZtysimisimeisairanmidasi;
    }

    private String ztysimisibikouranmidasi;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIBIKOURANMIDASI)
    public String getZtysimisibikouranmidasi() {
        return ztysimisibikouranmidasi;
    }

    public void setZtysimisibikouranmidasi(String pZtysimisibikouranmidasi) {
        ztysimisibikouranmidasi = pZtysimisibikouranmidasi;
    }

    private String ztysimisimeisaibumidasiyobi;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBUMIDASIYOBI)
    public String getZtysimisimeisaibumidasiyobi() {
        return ztysimisimeisaibumidasiyobi;
    }

    public void setZtysimisimeisaibumidasiyobi(String pZtysimisimeisaibumidasiyobi) {
        ztysimisimeisaibumidasiyobi = pZtysimisimeisaibumidasiyobi;
    }

    private String ztysimisitekiyou1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU1)
    public String getZtysimisitekiyou1() {
        return ztysimisitekiyou1;
    }

    public void setZtysimisitekiyou1(String pZtysimisitekiyou1) {
        ztysimisitekiyou1 = pZtysimisitekiyou1;
    }

    private String ztysimisikngkmisi1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI1)
    public String getZtysimisikngkmisi1() {
        return ztysimisikngkmisi1;
    }

    public void setZtysimisikngkmisi1(String pZtysimisikngkmisi1) {
        ztysimisikngkmisi1 = pZtysimisikngkmisi1;
    }

    private String ztysimisikngkmisituukasyu1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU1)
    public String getZtysimisikngkmisituukasyu1() {
        return ztysimisikngkmisituukasyu1;
    }

    public void setZtysimisikngkmisituukasyu1(String pZtysimisikngkmisituukasyu1) {
        ztysimisikngkmisituukasyu1 = pZtysimisikngkmisituukasyu1;
    }

    private String ztysimisimeisaibikou1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU1)
    public String getZtysimisimeisaibikou1() {
        return ztysimisimeisaibikou1;
    }

    public void setZtysimisimeisaibikou1(String pZtysimisimeisaibikou1) {
        ztysimisimeisaibikou1 = pZtysimisimeisaibikou1;
    }

    private String ztysimisikngkmisihugou1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU1)
    public String getZtysimisikngkmisihugou1() {
        return ztysimisikngkmisihugou1;
    }

    public void setZtysimisikngkmisihugou1(String pZtysimisikngkmisihugou1) {
        ztysimisikngkmisihugou1 = pZtysimisikngkmisihugou1;
    }

    private String ztysimisimeisaiyobi1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI1)
    public String getZtysimisimeisaiyobi1() {
        return ztysimisimeisaiyobi1;
    }

    public void setZtysimisimeisaiyobi1(String pZtysimisimeisaiyobi1) {
        ztysimisimeisaiyobi1 = pZtysimisimeisaiyobi1;
    }

    private String ztysimisitekiyou2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU2)
    public String getZtysimisitekiyou2() {
        return ztysimisitekiyou2;
    }

    public void setZtysimisitekiyou2(String pZtysimisitekiyou2) {
        ztysimisitekiyou2 = pZtysimisitekiyou2;
    }

    private String ztysimisikngkmisi2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI2)
    public String getZtysimisikngkmisi2() {
        return ztysimisikngkmisi2;
    }

    public void setZtysimisikngkmisi2(String pZtysimisikngkmisi2) {
        ztysimisikngkmisi2 = pZtysimisikngkmisi2;
    }

    private String ztysimisikngkmisituukasyu2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU2)
    public String getZtysimisikngkmisituukasyu2() {
        return ztysimisikngkmisituukasyu2;
    }

    public void setZtysimisikngkmisituukasyu2(String pZtysimisikngkmisituukasyu2) {
        ztysimisikngkmisituukasyu2 = pZtysimisikngkmisituukasyu2;
    }

    private String ztysimisimeisaibikou2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU2)
    public String getZtysimisimeisaibikou2() {
        return ztysimisimeisaibikou2;
    }

    public void setZtysimisimeisaibikou2(String pZtysimisimeisaibikou2) {
        ztysimisimeisaibikou2 = pZtysimisimeisaibikou2;
    }

    private String ztysimisikngkmisihugou2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU2)
    public String getZtysimisikngkmisihugou2() {
        return ztysimisikngkmisihugou2;
    }

    public void setZtysimisikngkmisihugou2(String pZtysimisikngkmisihugou2) {
        ztysimisikngkmisihugou2 = pZtysimisikngkmisihugou2;
    }

    private String ztysimisimeisaiyobi2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI2)
    public String getZtysimisimeisaiyobi2() {
        return ztysimisimeisaiyobi2;
    }

    public void setZtysimisimeisaiyobi2(String pZtysimisimeisaiyobi2) {
        ztysimisimeisaiyobi2 = pZtysimisimeisaiyobi2;
    }

    private String ztysimisitekiyou3;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU3)
    public String getZtysimisitekiyou3() {
        return ztysimisitekiyou3;
    }

    public void setZtysimisitekiyou3(String pZtysimisitekiyou3) {
        ztysimisitekiyou3 = pZtysimisitekiyou3;
    }

    private String ztysimisikngkmisi3;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI3)
    public String getZtysimisikngkmisi3() {
        return ztysimisikngkmisi3;
    }

    public void setZtysimisikngkmisi3(String pZtysimisikngkmisi3) {
        ztysimisikngkmisi3 = pZtysimisikngkmisi3;
    }

    private String ztysimisikngkmisituukasyu3;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU3)
    public String getZtysimisikngkmisituukasyu3() {
        return ztysimisikngkmisituukasyu3;
    }

    public void setZtysimisikngkmisituukasyu3(String pZtysimisikngkmisituukasyu3) {
        ztysimisikngkmisituukasyu3 = pZtysimisikngkmisituukasyu3;
    }

    private String ztysimisimeisaibikou3;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU3)
    public String getZtysimisimeisaibikou3() {
        return ztysimisimeisaibikou3;
    }

    public void setZtysimisimeisaibikou3(String pZtysimisimeisaibikou3) {
        ztysimisimeisaibikou3 = pZtysimisimeisaibikou3;
    }

    private String ztysimisikngkmisihugou3;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU3)
    public String getZtysimisikngkmisihugou3() {
        return ztysimisikngkmisihugou3;
    }

    public void setZtysimisikngkmisihugou3(String pZtysimisikngkmisihugou3) {
        ztysimisikngkmisihugou3 = pZtysimisikngkmisihugou3;
    }

    private String ztysimisimeisaiyobi3;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI3)
    public String getZtysimisimeisaiyobi3() {
        return ztysimisimeisaiyobi3;
    }

    public void setZtysimisimeisaiyobi3(String pZtysimisimeisaiyobi3) {
        ztysimisimeisaiyobi3 = pZtysimisimeisaiyobi3;
    }

    private String ztysimisitekiyou4;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU4)
    public String getZtysimisitekiyou4() {
        return ztysimisitekiyou4;
    }

    public void setZtysimisitekiyou4(String pZtysimisitekiyou4) {
        ztysimisitekiyou4 = pZtysimisitekiyou4;
    }

    private String ztysimisikngkmisi4;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI4)
    public String getZtysimisikngkmisi4() {
        return ztysimisikngkmisi4;
    }

    public void setZtysimisikngkmisi4(String pZtysimisikngkmisi4) {
        ztysimisikngkmisi4 = pZtysimisikngkmisi4;
    }

    private String ztysimisikngkmisituukasyu4;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU4)
    public String getZtysimisikngkmisituukasyu4() {
        return ztysimisikngkmisituukasyu4;
    }

    public void setZtysimisikngkmisituukasyu4(String pZtysimisikngkmisituukasyu4) {
        ztysimisikngkmisituukasyu4 = pZtysimisikngkmisituukasyu4;
    }

    private String ztysimisimeisaibikou4;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU4)
    public String getZtysimisimeisaibikou4() {
        return ztysimisimeisaibikou4;
    }

    public void setZtysimisimeisaibikou4(String pZtysimisimeisaibikou4) {
        ztysimisimeisaibikou4 = pZtysimisimeisaibikou4;
    }

    private String ztysimisikngkmisihugou4;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU4)
    public String getZtysimisikngkmisihugou4() {
        return ztysimisikngkmisihugou4;
    }

    public void setZtysimisikngkmisihugou4(String pZtysimisikngkmisihugou4) {
        ztysimisikngkmisihugou4 = pZtysimisikngkmisihugou4;
    }

    private String ztysimisimeisaiyobi4;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI4)
    public String getZtysimisimeisaiyobi4() {
        return ztysimisimeisaiyobi4;
    }

    public void setZtysimisimeisaiyobi4(String pZtysimisimeisaiyobi4) {
        ztysimisimeisaiyobi4 = pZtysimisimeisaiyobi4;
    }

    private String ztysimisitekiyou5;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU5)
    public String getZtysimisitekiyou5() {
        return ztysimisitekiyou5;
    }

    public void setZtysimisitekiyou5(String pZtysimisitekiyou5) {
        ztysimisitekiyou5 = pZtysimisitekiyou5;
    }

    private String ztysimisikngkmisi5;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI5)
    public String getZtysimisikngkmisi5() {
        return ztysimisikngkmisi5;
    }

    public void setZtysimisikngkmisi5(String pZtysimisikngkmisi5) {
        ztysimisikngkmisi5 = pZtysimisikngkmisi5;
    }

    private String ztysimisikngkmisituukasyu5;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU5)
    public String getZtysimisikngkmisituukasyu5() {
        return ztysimisikngkmisituukasyu5;
    }

    public void setZtysimisikngkmisituukasyu5(String pZtysimisikngkmisituukasyu5) {
        ztysimisikngkmisituukasyu5 = pZtysimisikngkmisituukasyu5;
    }

    private String ztysimisimeisaibikou5;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU5)
    public String getZtysimisimeisaibikou5() {
        return ztysimisimeisaibikou5;
    }

    public void setZtysimisimeisaibikou5(String pZtysimisimeisaibikou5) {
        ztysimisimeisaibikou5 = pZtysimisimeisaibikou5;
    }

    private String ztysimisikngkmisihugou5;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU5)
    public String getZtysimisikngkmisihugou5() {
        return ztysimisikngkmisihugou5;
    }

    public void setZtysimisikngkmisihugou5(String pZtysimisikngkmisihugou5) {
        ztysimisikngkmisihugou5 = pZtysimisikngkmisihugou5;
    }

    private String ztysimisimeisaiyobi5;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI5)
    public String getZtysimisimeisaiyobi5() {
        return ztysimisimeisaiyobi5;
    }

    public void setZtysimisimeisaiyobi5(String pZtysimisimeisaiyobi5) {
        ztysimisimeisaiyobi5 = pZtysimisimeisaiyobi5;
    }

    private String ztysimisitekiyou6;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU6)
    public String getZtysimisitekiyou6() {
        return ztysimisitekiyou6;
    }

    public void setZtysimisitekiyou6(String pZtysimisitekiyou6) {
        ztysimisitekiyou6 = pZtysimisitekiyou6;
    }

    private String ztysimisikngkmisi6;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI6)
    public String getZtysimisikngkmisi6() {
        return ztysimisikngkmisi6;
    }

    public void setZtysimisikngkmisi6(String pZtysimisikngkmisi6) {
        ztysimisikngkmisi6 = pZtysimisikngkmisi6;
    }

    private String ztysimisikngkmisituukasyu6;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU6)
    public String getZtysimisikngkmisituukasyu6() {
        return ztysimisikngkmisituukasyu6;
    }

    public void setZtysimisikngkmisituukasyu6(String pZtysimisikngkmisituukasyu6) {
        ztysimisikngkmisituukasyu6 = pZtysimisikngkmisituukasyu6;
    }

    private String ztysimisimeisaibikou6;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU6)
    public String getZtysimisimeisaibikou6() {
        return ztysimisimeisaibikou6;
    }

    public void setZtysimisimeisaibikou6(String pZtysimisimeisaibikou6) {
        ztysimisimeisaibikou6 = pZtysimisimeisaibikou6;
    }

    private String ztysimisikngkmisihugou6;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU6)
    public String getZtysimisikngkmisihugou6() {
        return ztysimisikngkmisihugou6;
    }

    public void setZtysimisikngkmisihugou6(String pZtysimisikngkmisihugou6) {
        ztysimisikngkmisihugou6 = pZtysimisikngkmisihugou6;
    }

    private String ztysimisimeisaiyobi6;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI6)
    public String getZtysimisimeisaiyobi6() {
        return ztysimisimeisaiyobi6;
    }

    public void setZtysimisimeisaiyobi6(String pZtysimisimeisaiyobi6) {
        ztysimisimeisaiyobi6 = pZtysimisimeisaiyobi6;
    }

    private String ztysimisitekiyou7;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU7)
    public String getZtysimisitekiyou7() {
        return ztysimisitekiyou7;
    }

    public void setZtysimisitekiyou7(String pZtysimisitekiyou7) {
        ztysimisitekiyou7 = pZtysimisitekiyou7;
    }

    private String ztysimisikngkmisi7;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI7)
    public String getZtysimisikngkmisi7() {
        return ztysimisikngkmisi7;
    }

    public void setZtysimisikngkmisi7(String pZtysimisikngkmisi7) {
        ztysimisikngkmisi7 = pZtysimisikngkmisi7;
    }

    private String ztysimisikngkmisituukasyu7;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU7)
    public String getZtysimisikngkmisituukasyu7() {
        return ztysimisikngkmisituukasyu7;
    }

    public void setZtysimisikngkmisituukasyu7(String pZtysimisikngkmisituukasyu7) {
        ztysimisikngkmisituukasyu7 = pZtysimisikngkmisituukasyu7;
    }

    private String ztysimisimeisaibikou7;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU7)
    public String getZtysimisimeisaibikou7() {
        return ztysimisimeisaibikou7;
    }

    public void setZtysimisimeisaibikou7(String pZtysimisimeisaibikou7) {
        ztysimisimeisaibikou7 = pZtysimisimeisaibikou7;
    }

    private String ztysimisikngkmisihugou7;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU7)
    public String getZtysimisikngkmisihugou7() {
        return ztysimisikngkmisihugou7;
    }

    public void setZtysimisikngkmisihugou7(String pZtysimisikngkmisihugou7) {
        ztysimisikngkmisihugou7 = pZtysimisikngkmisihugou7;
    }

    private String ztysimisimeisaiyobi7;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI7)
    public String getZtysimisimeisaiyobi7() {
        return ztysimisimeisaiyobi7;
    }

    public void setZtysimisimeisaiyobi7(String pZtysimisimeisaiyobi7) {
        ztysimisimeisaiyobi7 = pZtysimisimeisaiyobi7;
    }

    private String ztysimisitekiyou8;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU8)
    public String getZtysimisitekiyou8() {
        return ztysimisitekiyou8;
    }

    public void setZtysimisitekiyou8(String pZtysimisitekiyou8) {
        ztysimisitekiyou8 = pZtysimisitekiyou8;
    }

    private String ztysimisikngkmisi8;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI8)
    public String getZtysimisikngkmisi8() {
        return ztysimisikngkmisi8;
    }

    public void setZtysimisikngkmisi8(String pZtysimisikngkmisi8) {
        ztysimisikngkmisi8 = pZtysimisikngkmisi8;
    }

    private String ztysimisikngkmisituukasyu8;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU8)
    public String getZtysimisikngkmisituukasyu8() {
        return ztysimisikngkmisituukasyu8;
    }

    public void setZtysimisikngkmisituukasyu8(String pZtysimisikngkmisituukasyu8) {
        ztysimisikngkmisituukasyu8 = pZtysimisikngkmisituukasyu8;
    }

    private String ztysimisimeisaibikou8;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU8)
    public String getZtysimisimeisaibikou8() {
        return ztysimisimeisaibikou8;
    }

    public void setZtysimisimeisaibikou8(String pZtysimisimeisaibikou8) {
        ztysimisimeisaibikou8 = pZtysimisimeisaibikou8;
    }

    private String ztysimisikngkmisihugou8;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU8)
    public String getZtysimisikngkmisihugou8() {
        return ztysimisikngkmisihugou8;
    }

    public void setZtysimisikngkmisihugou8(String pZtysimisikngkmisihugou8) {
        ztysimisikngkmisihugou8 = pZtysimisikngkmisihugou8;
    }

    private String ztysimisimeisaiyobi8;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI8)
    public String getZtysimisimeisaiyobi8() {
        return ztysimisimeisaiyobi8;
    }

    public void setZtysimisimeisaiyobi8(String pZtysimisimeisaiyobi8) {
        ztysimisimeisaiyobi8 = pZtysimisimeisaiyobi8;
    }

    private String ztysimisitekiyou9;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU9)
    public String getZtysimisitekiyou9() {
        return ztysimisitekiyou9;
    }

    public void setZtysimisitekiyou9(String pZtysimisitekiyou9) {
        ztysimisitekiyou9 = pZtysimisitekiyou9;
    }

    private String ztysimisikngkmisi9;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI9)
    public String getZtysimisikngkmisi9() {
        return ztysimisikngkmisi9;
    }

    public void setZtysimisikngkmisi9(String pZtysimisikngkmisi9) {
        ztysimisikngkmisi9 = pZtysimisikngkmisi9;
    }

    private String ztysimisikngkmisituukasyu9;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU9)
    public String getZtysimisikngkmisituukasyu9() {
        return ztysimisikngkmisituukasyu9;
    }

    public void setZtysimisikngkmisituukasyu9(String pZtysimisikngkmisituukasyu9) {
        ztysimisikngkmisituukasyu9 = pZtysimisikngkmisituukasyu9;
    }

    private String ztysimisimeisaibikou9;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU9)
    public String getZtysimisimeisaibikou9() {
        return ztysimisimeisaibikou9;
    }

    public void setZtysimisimeisaibikou9(String pZtysimisimeisaibikou9) {
        ztysimisimeisaibikou9 = pZtysimisimeisaibikou9;
    }

    private String ztysimisikngkmisihugou9;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU9)
    public String getZtysimisikngkmisihugou9() {
        return ztysimisikngkmisihugou9;
    }

    public void setZtysimisikngkmisihugou9(String pZtysimisikngkmisihugou9) {
        ztysimisikngkmisihugou9 = pZtysimisikngkmisihugou9;
    }

    private String ztysimisimeisaiyobi9;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI9)
    public String getZtysimisimeisaiyobi9() {
        return ztysimisimeisaiyobi9;
    }

    public void setZtysimisimeisaiyobi9(String pZtysimisimeisaiyobi9) {
        ztysimisimeisaiyobi9 = pZtysimisimeisaiyobi9;
    }

    private String ztysimisitekiyou10;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU10)
    public String getZtysimisitekiyou10() {
        return ztysimisitekiyou10;
    }

    public void setZtysimisitekiyou10(String pZtysimisitekiyou10) {
        ztysimisitekiyou10 = pZtysimisitekiyou10;
    }

    private String ztysimisikngkmisi10;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI10)
    public String getZtysimisikngkmisi10() {
        return ztysimisikngkmisi10;
    }

    public void setZtysimisikngkmisi10(String pZtysimisikngkmisi10) {
        ztysimisikngkmisi10 = pZtysimisikngkmisi10;
    }

    private String ztysimisikngkmisituukasyu10;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU10)
    public String getZtysimisikngkmisituukasyu10() {
        return ztysimisikngkmisituukasyu10;
    }

    public void setZtysimisikngkmisituukasyu10(String pZtysimisikngkmisituukasyu10) {
        ztysimisikngkmisituukasyu10 = pZtysimisikngkmisituukasyu10;
    }

    private String ztysimisimeisaibikou10;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU10)
    public String getZtysimisimeisaibikou10() {
        return ztysimisimeisaibikou10;
    }

    public void setZtysimisimeisaibikou10(String pZtysimisimeisaibikou10) {
        ztysimisimeisaibikou10 = pZtysimisimeisaibikou10;
    }

    private String ztysimisikngkmisihugou10;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU10)
    public String getZtysimisikngkmisihugou10() {
        return ztysimisikngkmisihugou10;
    }

    public void setZtysimisikngkmisihugou10(String pZtysimisikngkmisihugou10) {
        ztysimisikngkmisihugou10 = pZtysimisikngkmisihugou10;
    }

    private String ztysimisimeisaiyobi10;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI10)
    public String getZtysimisimeisaiyobi10() {
        return ztysimisimeisaiyobi10;
    }

    public void setZtysimisimeisaiyobi10(String pZtysimisimeisaiyobi10) {
        ztysimisimeisaiyobi10 = pZtysimisimeisaiyobi10;
    }

    private String ztysimisitekiyou11;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU11)
    public String getZtysimisitekiyou11() {
        return ztysimisitekiyou11;
    }

    public void setZtysimisitekiyou11(String pZtysimisitekiyou11) {
        ztysimisitekiyou11 = pZtysimisitekiyou11;
    }

    private String ztysimisikngkmisi11;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI11)
    public String getZtysimisikngkmisi11() {
        return ztysimisikngkmisi11;
    }

    public void setZtysimisikngkmisi11(String pZtysimisikngkmisi11) {
        ztysimisikngkmisi11 = pZtysimisikngkmisi11;
    }

    private String ztysimisikngkmisituukasyu11;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU11)
    public String getZtysimisikngkmisituukasyu11() {
        return ztysimisikngkmisituukasyu11;
    }

    public void setZtysimisikngkmisituukasyu11(String pZtysimisikngkmisituukasyu11) {
        ztysimisikngkmisituukasyu11 = pZtysimisikngkmisituukasyu11;
    }

    private String ztysimisimeisaibikou11;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU11)
    public String getZtysimisimeisaibikou11() {
        return ztysimisimeisaibikou11;
    }

    public void setZtysimisimeisaibikou11(String pZtysimisimeisaibikou11) {
        ztysimisimeisaibikou11 = pZtysimisimeisaibikou11;
    }

    private String ztysimisikngkmisihugou11;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU11)
    public String getZtysimisikngkmisihugou11() {
        return ztysimisikngkmisihugou11;
    }

    public void setZtysimisikngkmisihugou11(String pZtysimisikngkmisihugou11) {
        ztysimisikngkmisihugou11 = pZtysimisikngkmisihugou11;
    }

    private String ztysimisimeisaiyobi11;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI11)
    public String getZtysimisimeisaiyobi11() {
        return ztysimisimeisaiyobi11;
    }

    public void setZtysimisimeisaiyobi11(String pZtysimisimeisaiyobi11) {
        ztysimisimeisaiyobi11 = pZtysimisimeisaiyobi11;
    }

    private String ztysimisitekiyou12;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU12)
    public String getZtysimisitekiyou12() {
        return ztysimisitekiyou12;
    }

    public void setZtysimisitekiyou12(String pZtysimisitekiyou12) {
        ztysimisitekiyou12 = pZtysimisitekiyou12;
    }

    private String ztysimisikngkmisi12;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI12)
    public String getZtysimisikngkmisi12() {
        return ztysimisikngkmisi12;
    }

    public void setZtysimisikngkmisi12(String pZtysimisikngkmisi12) {
        ztysimisikngkmisi12 = pZtysimisikngkmisi12;
    }

    private String ztysimisikngkmisituukasyu12;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU12)
    public String getZtysimisikngkmisituukasyu12() {
        return ztysimisikngkmisituukasyu12;
    }

    public void setZtysimisikngkmisituukasyu12(String pZtysimisikngkmisituukasyu12) {
        ztysimisikngkmisituukasyu12 = pZtysimisikngkmisituukasyu12;
    }

    private String ztysimisimeisaibikou12;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU12)
    public String getZtysimisimeisaibikou12() {
        return ztysimisimeisaibikou12;
    }

    public void setZtysimisimeisaibikou12(String pZtysimisimeisaibikou12) {
        ztysimisimeisaibikou12 = pZtysimisimeisaibikou12;
    }

    private String ztysimisikngkmisihugou12;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU12)
    public String getZtysimisikngkmisihugou12() {
        return ztysimisikngkmisihugou12;
    }

    public void setZtysimisikngkmisihugou12(String pZtysimisikngkmisihugou12) {
        ztysimisikngkmisihugou12 = pZtysimisikngkmisihugou12;
    }

    private String ztysimisimeisaiyobi12;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI12)
    public String getZtysimisimeisaiyobi12() {
        return ztysimisimeisaiyobi12;
    }

    public void setZtysimisimeisaiyobi12(String pZtysimisimeisaiyobi12) {
        ztysimisimeisaiyobi12 = pZtysimisimeisaiyobi12;
    }

    private String ztysimisitekiyou13;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU13)
    public String getZtysimisitekiyou13() {
        return ztysimisitekiyou13;
    }

    public void setZtysimisitekiyou13(String pZtysimisitekiyou13) {
        ztysimisitekiyou13 = pZtysimisitekiyou13;
    }

    private String ztysimisikngkmisi13;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI13)
    public String getZtysimisikngkmisi13() {
        return ztysimisikngkmisi13;
    }

    public void setZtysimisikngkmisi13(String pZtysimisikngkmisi13) {
        ztysimisikngkmisi13 = pZtysimisikngkmisi13;
    }

    private String ztysimisikngkmisituukasyu13;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU13)
    public String getZtysimisikngkmisituukasyu13() {
        return ztysimisikngkmisituukasyu13;
    }

    public void setZtysimisikngkmisituukasyu13(String pZtysimisikngkmisituukasyu13) {
        ztysimisikngkmisituukasyu13 = pZtysimisikngkmisituukasyu13;
    }

    private String ztysimisimeisaibikou13;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU13)
    public String getZtysimisimeisaibikou13() {
        return ztysimisimeisaibikou13;
    }

    public void setZtysimisimeisaibikou13(String pZtysimisimeisaibikou13) {
        ztysimisimeisaibikou13 = pZtysimisimeisaibikou13;
    }

    private String ztysimisikngkmisihugou13;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU13)
    public String getZtysimisikngkmisihugou13() {
        return ztysimisikngkmisihugou13;
    }

    public void setZtysimisikngkmisihugou13(String pZtysimisikngkmisihugou13) {
        ztysimisikngkmisihugou13 = pZtysimisikngkmisihugou13;
    }

    private String ztysimisimeisaiyobi13;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI13)
    public String getZtysimisimeisaiyobi13() {
        return ztysimisimeisaiyobi13;
    }

    public void setZtysimisimeisaiyobi13(String pZtysimisimeisaiyobi13) {
        ztysimisimeisaiyobi13 = pZtysimisimeisaiyobi13;
    }

    private String ztysimisitekiyou14;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU14)
    public String getZtysimisitekiyou14() {
        return ztysimisitekiyou14;
    }

    public void setZtysimisitekiyou14(String pZtysimisitekiyou14) {
        ztysimisitekiyou14 = pZtysimisitekiyou14;
    }

    private String ztysimisikngkmisi14;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI14)
    public String getZtysimisikngkmisi14() {
        return ztysimisikngkmisi14;
    }

    public void setZtysimisikngkmisi14(String pZtysimisikngkmisi14) {
        ztysimisikngkmisi14 = pZtysimisikngkmisi14;
    }

    private String ztysimisikngkmisituukasyu14;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU14)
    public String getZtysimisikngkmisituukasyu14() {
        return ztysimisikngkmisituukasyu14;
    }

    public void setZtysimisikngkmisituukasyu14(String pZtysimisikngkmisituukasyu14) {
        ztysimisikngkmisituukasyu14 = pZtysimisikngkmisituukasyu14;
    }

    private String ztysimisimeisaibikou14;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU14)
    public String getZtysimisimeisaibikou14() {
        return ztysimisimeisaibikou14;
    }

    public void setZtysimisimeisaibikou14(String pZtysimisimeisaibikou14) {
        ztysimisimeisaibikou14 = pZtysimisimeisaibikou14;
    }

    private String ztysimisikngkmisihugou14;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU14)
    public String getZtysimisikngkmisihugou14() {
        return ztysimisikngkmisihugou14;
    }

    public void setZtysimisikngkmisihugou14(String pZtysimisikngkmisihugou14) {
        ztysimisikngkmisihugou14 = pZtysimisikngkmisihugou14;
    }

    private String ztysimisimeisaiyobi14;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI14)
    public String getZtysimisimeisaiyobi14() {
        return ztysimisimeisaiyobi14;
    }

    public void setZtysimisimeisaiyobi14(String pZtysimisimeisaiyobi14) {
        ztysimisimeisaiyobi14 = pZtysimisimeisaiyobi14;
    }

    private String ztysimisitekiyou15;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU15)
    public String getZtysimisitekiyou15() {
        return ztysimisitekiyou15;
    }

    public void setZtysimisitekiyou15(String pZtysimisitekiyou15) {
        ztysimisitekiyou15 = pZtysimisitekiyou15;
    }

    private String ztysimisikngkmisi15;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI15)
    public String getZtysimisikngkmisi15() {
        return ztysimisikngkmisi15;
    }

    public void setZtysimisikngkmisi15(String pZtysimisikngkmisi15) {
        ztysimisikngkmisi15 = pZtysimisikngkmisi15;
    }

    private String ztysimisikngkmisituukasyu15;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU15)
    public String getZtysimisikngkmisituukasyu15() {
        return ztysimisikngkmisituukasyu15;
    }

    public void setZtysimisikngkmisituukasyu15(String pZtysimisikngkmisituukasyu15) {
        ztysimisikngkmisituukasyu15 = pZtysimisikngkmisituukasyu15;
    }

    private String ztysimisimeisaibikou15;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU15)
    public String getZtysimisimeisaibikou15() {
        return ztysimisimeisaibikou15;
    }

    public void setZtysimisimeisaibikou15(String pZtysimisimeisaibikou15) {
        ztysimisimeisaibikou15 = pZtysimisimeisaibikou15;
    }

    private String ztysimisikngkmisihugou15;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU15)
    public String getZtysimisikngkmisihugou15() {
        return ztysimisikngkmisihugou15;
    }

    public void setZtysimisikngkmisihugou15(String pZtysimisikngkmisihugou15) {
        ztysimisikngkmisihugou15 = pZtysimisikngkmisihugou15;
    }

    private String ztysimisimeisaiyobi15;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI15)
    public String getZtysimisimeisaiyobi15() {
        return ztysimisimeisaiyobi15;
    }

    public void setZtysimisimeisaiyobi15(String pZtysimisimeisaiyobi15) {
        ztysimisimeisaiyobi15 = pZtysimisimeisaiyobi15;
    }

    private String ztysimisitekiyou16;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU16)
    public String getZtysimisitekiyou16() {
        return ztysimisitekiyou16;
    }

    public void setZtysimisitekiyou16(String pZtysimisitekiyou16) {
        ztysimisitekiyou16 = pZtysimisitekiyou16;
    }

    private String ztysimisikngkmisi16;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI16)
    public String getZtysimisikngkmisi16() {
        return ztysimisikngkmisi16;
    }

    public void setZtysimisikngkmisi16(String pZtysimisikngkmisi16) {
        ztysimisikngkmisi16 = pZtysimisikngkmisi16;
    }

    private String ztysimisikngkmisituukasyu16;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU16)
    public String getZtysimisikngkmisituukasyu16() {
        return ztysimisikngkmisituukasyu16;
    }

    public void setZtysimisikngkmisituukasyu16(String pZtysimisikngkmisituukasyu16) {
        ztysimisikngkmisituukasyu16 = pZtysimisikngkmisituukasyu16;
    }

    private String ztysimisimeisaibikou16;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU16)
    public String getZtysimisimeisaibikou16() {
        return ztysimisimeisaibikou16;
    }

    public void setZtysimisimeisaibikou16(String pZtysimisimeisaibikou16) {
        ztysimisimeisaibikou16 = pZtysimisimeisaibikou16;
    }

    private String ztysimisikngkmisihugou16;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU16)
    public String getZtysimisikngkmisihugou16() {
        return ztysimisikngkmisihugou16;
    }

    public void setZtysimisikngkmisihugou16(String pZtysimisikngkmisihugou16) {
        ztysimisikngkmisihugou16 = pZtysimisikngkmisihugou16;
    }

    private String ztysimisimeisaiyobi16;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI16)
    public String getZtysimisimeisaiyobi16() {
        return ztysimisimeisaiyobi16;
    }

    public void setZtysimisimeisaiyobi16(String pZtysimisimeisaiyobi16) {
        ztysimisimeisaiyobi16 = pZtysimisimeisaiyobi16;
    }

    private String ztysimisitekiyou17;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU17)
    public String getZtysimisitekiyou17() {
        return ztysimisitekiyou17;
    }

    public void setZtysimisitekiyou17(String pZtysimisitekiyou17) {
        ztysimisitekiyou17 = pZtysimisitekiyou17;
    }

    private String ztysimisikngkmisi17;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI17)
    public String getZtysimisikngkmisi17() {
        return ztysimisikngkmisi17;
    }

    public void setZtysimisikngkmisi17(String pZtysimisikngkmisi17) {
        ztysimisikngkmisi17 = pZtysimisikngkmisi17;
    }

    private String ztysimisikngkmisituukasyu17;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU17)
    public String getZtysimisikngkmisituukasyu17() {
        return ztysimisikngkmisituukasyu17;
    }

    public void setZtysimisikngkmisituukasyu17(String pZtysimisikngkmisituukasyu17) {
        ztysimisikngkmisituukasyu17 = pZtysimisikngkmisituukasyu17;
    }

    private String ztysimisimeisaibikou17;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU17)
    public String getZtysimisimeisaibikou17() {
        return ztysimisimeisaibikou17;
    }

    public void setZtysimisimeisaibikou17(String pZtysimisimeisaibikou17) {
        ztysimisimeisaibikou17 = pZtysimisimeisaibikou17;
    }

    private String ztysimisikngkmisihugou17;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU17)
    public String getZtysimisikngkmisihugou17() {
        return ztysimisikngkmisihugou17;
    }

    public void setZtysimisikngkmisihugou17(String pZtysimisikngkmisihugou17) {
        ztysimisikngkmisihugou17 = pZtysimisikngkmisihugou17;
    }

    private String ztysimisimeisaiyobi17;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI17)
    public String getZtysimisimeisaiyobi17() {
        return ztysimisimeisaiyobi17;
    }

    public void setZtysimisimeisaiyobi17(String pZtysimisimeisaiyobi17) {
        ztysimisimeisaiyobi17 = pZtysimisimeisaiyobi17;
    }

    private String ztysimisitekiyou18;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU18)
    public String getZtysimisitekiyou18() {
        return ztysimisitekiyou18;
    }

    public void setZtysimisitekiyou18(String pZtysimisitekiyou18) {
        ztysimisitekiyou18 = pZtysimisitekiyou18;
    }

    private String ztysimisikngkmisi18;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI18)
    public String getZtysimisikngkmisi18() {
        return ztysimisikngkmisi18;
    }

    public void setZtysimisikngkmisi18(String pZtysimisikngkmisi18) {
        ztysimisikngkmisi18 = pZtysimisikngkmisi18;
    }

    private String ztysimisikngkmisituukasyu18;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU18)
    public String getZtysimisikngkmisituukasyu18() {
        return ztysimisikngkmisituukasyu18;
    }

    public void setZtysimisikngkmisituukasyu18(String pZtysimisikngkmisituukasyu18) {
        ztysimisikngkmisituukasyu18 = pZtysimisikngkmisituukasyu18;
    }

    private String ztysimisimeisaibikou18;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU18)
    public String getZtysimisimeisaibikou18() {
        return ztysimisimeisaibikou18;
    }

    public void setZtysimisimeisaibikou18(String pZtysimisimeisaibikou18) {
        ztysimisimeisaibikou18 = pZtysimisimeisaibikou18;
    }

    private String ztysimisikngkmisihugou18;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU18)
    public String getZtysimisikngkmisihugou18() {
        return ztysimisikngkmisihugou18;
    }

    public void setZtysimisikngkmisihugou18(String pZtysimisikngkmisihugou18) {
        ztysimisikngkmisihugou18 = pZtysimisikngkmisihugou18;
    }

    private String ztysimisimeisaiyobi18;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI18)
    public String getZtysimisimeisaiyobi18() {
        return ztysimisimeisaiyobi18;
    }

    public void setZtysimisimeisaiyobi18(String pZtysimisimeisaiyobi18) {
        ztysimisimeisaiyobi18 = pZtysimisimeisaiyobi18;
    }

    private String ztysimisitekiyou19;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU19)
    public String getZtysimisitekiyou19() {
        return ztysimisitekiyou19;
    }

    public void setZtysimisitekiyou19(String pZtysimisitekiyou19) {
        ztysimisitekiyou19 = pZtysimisitekiyou19;
    }

    private String ztysimisikngkmisi19;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI19)
    public String getZtysimisikngkmisi19() {
        return ztysimisikngkmisi19;
    }

    public void setZtysimisikngkmisi19(String pZtysimisikngkmisi19) {
        ztysimisikngkmisi19 = pZtysimisikngkmisi19;
    }

    private String ztysimisikngkmisituukasyu19;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU19)
    public String getZtysimisikngkmisituukasyu19() {
        return ztysimisikngkmisituukasyu19;
    }

    public void setZtysimisikngkmisituukasyu19(String pZtysimisikngkmisituukasyu19) {
        ztysimisikngkmisituukasyu19 = pZtysimisikngkmisituukasyu19;
    }

    private String ztysimisimeisaibikou19;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU19)
    public String getZtysimisimeisaibikou19() {
        return ztysimisimeisaibikou19;
    }

    public void setZtysimisimeisaibikou19(String pZtysimisimeisaibikou19) {
        ztysimisimeisaibikou19 = pZtysimisimeisaibikou19;
    }

    private String ztysimisikngkmisihugou19;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU19)
    public String getZtysimisikngkmisihugou19() {
        return ztysimisikngkmisihugou19;
    }

    public void setZtysimisikngkmisihugou19(String pZtysimisikngkmisihugou19) {
        ztysimisikngkmisihugou19 = pZtysimisikngkmisihugou19;
    }

    private String ztysimisimeisaiyobi19;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI19)
    public String getZtysimisimeisaiyobi19() {
        return ztysimisimeisaiyobi19;
    }

    public void setZtysimisimeisaiyobi19(String pZtysimisimeisaiyobi19) {
        ztysimisimeisaiyobi19 = pZtysimisimeisaiyobi19;
    }

    private String ztysimisitekiyou20;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU20)
    public String getZtysimisitekiyou20() {
        return ztysimisitekiyou20;
    }

    public void setZtysimisitekiyou20(String pZtysimisitekiyou20) {
        ztysimisitekiyou20 = pZtysimisitekiyou20;
    }

    private String ztysimisikngkmisi20;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI20)
    public String getZtysimisikngkmisi20() {
        return ztysimisikngkmisi20;
    }

    public void setZtysimisikngkmisi20(String pZtysimisikngkmisi20) {
        ztysimisikngkmisi20 = pZtysimisikngkmisi20;
    }

    private String ztysimisikngkmisituukasyu20;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU20)
    public String getZtysimisikngkmisituukasyu20() {
        return ztysimisikngkmisituukasyu20;
    }

    public void setZtysimisikngkmisituukasyu20(String pZtysimisikngkmisituukasyu20) {
        ztysimisikngkmisituukasyu20 = pZtysimisikngkmisituukasyu20;
    }

    private String ztysimisimeisaibikou20;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU20)
    public String getZtysimisimeisaibikou20() {
        return ztysimisimeisaibikou20;
    }

    public void setZtysimisimeisaibikou20(String pZtysimisimeisaibikou20) {
        ztysimisimeisaibikou20 = pZtysimisimeisaibikou20;
    }

    private String ztysimisikngkmisihugou20;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU20)
    public String getZtysimisikngkmisihugou20() {
        return ztysimisikngkmisihugou20;
    }

    public void setZtysimisikngkmisihugou20(String pZtysimisikngkmisihugou20) {
        ztysimisikngkmisihugou20 = pZtysimisikngkmisihugou20;
    }

    private String ztysimisimeisaiyobi20;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI20)
    public String getZtysimisimeisaiyobi20() {
        return ztysimisimeisaiyobi20;
    }

    public void setZtysimisimeisaiyobi20(String pZtysimisimeisaiyobi20) {
        ztysimisimeisaiyobi20 = pZtysimisimeisaiyobi20;
    }

    private String ztysimisitekiyou21;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU21)
    public String getZtysimisitekiyou21() {
        return ztysimisitekiyou21;
    }

    public void setZtysimisitekiyou21(String pZtysimisitekiyou21) {
        ztysimisitekiyou21 = pZtysimisitekiyou21;
    }

    private String ztysimisikngkmisi21;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI21)
    public String getZtysimisikngkmisi21() {
        return ztysimisikngkmisi21;
    }

    public void setZtysimisikngkmisi21(String pZtysimisikngkmisi21) {
        ztysimisikngkmisi21 = pZtysimisikngkmisi21;
    }

    private String ztysimisikngkmisituukasyu21;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU21)
    public String getZtysimisikngkmisituukasyu21() {
        return ztysimisikngkmisituukasyu21;
    }

    public void setZtysimisikngkmisituukasyu21(String pZtysimisikngkmisituukasyu21) {
        ztysimisikngkmisituukasyu21 = pZtysimisikngkmisituukasyu21;
    }

    private String ztysimisimeisaibikou21;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU21)
    public String getZtysimisimeisaibikou21() {
        return ztysimisimeisaibikou21;
    }

    public void setZtysimisimeisaibikou21(String pZtysimisimeisaibikou21) {
        ztysimisimeisaibikou21 = pZtysimisimeisaibikou21;
    }

    private String ztysimisikngkmisihugou21;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU21)
    public String getZtysimisikngkmisihugou21() {
        return ztysimisikngkmisihugou21;
    }

    public void setZtysimisikngkmisihugou21(String pZtysimisikngkmisihugou21) {
        ztysimisikngkmisihugou21 = pZtysimisikngkmisihugou21;
    }

    private String ztysimisimeisaiyobi21;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI21)
    public String getZtysimisimeisaiyobi21() {
        return ztysimisimeisaiyobi21;
    }

    public void setZtysimisimeisaiyobi21(String pZtysimisimeisaiyobi21) {
        ztysimisimeisaiyobi21 = pZtysimisimeisaiyobi21;
    }

    private String ztysimisitekiyou22;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU22)
    public String getZtysimisitekiyou22() {
        return ztysimisitekiyou22;
    }

    public void setZtysimisitekiyou22(String pZtysimisitekiyou22) {
        ztysimisitekiyou22 = pZtysimisitekiyou22;
    }

    private String ztysimisikngkmisi22;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI22)
    public String getZtysimisikngkmisi22() {
        return ztysimisikngkmisi22;
    }

    public void setZtysimisikngkmisi22(String pZtysimisikngkmisi22) {
        ztysimisikngkmisi22 = pZtysimisikngkmisi22;
    }

    private String ztysimisikngkmisituukasyu22;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU22)
    public String getZtysimisikngkmisituukasyu22() {
        return ztysimisikngkmisituukasyu22;
    }

    public void setZtysimisikngkmisituukasyu22(String pZtysimisikngkmisituukasyu22) {
        ztysimisikngkmisituukasyu22 = pZtysimisikngkmisituukasyu22;
    }

    private String ztysimisimeisaibikou22;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU22)
    public String getZtysimisimeisaibikou22() {
        return ztysimisimeisaibikou22;
    }

    public void setZtysimisimeisaibikou22(String pZtysimisimeisaibikou22) {
        ztysimisimeisaibikou22 = pZtysimisimeisaibikou22;
    }

    private String ztysimisikngkmisihugou22;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU22)
    public String getZtysimisikngkmisihugou22() {
        return ztysimisikngkmisihugou22;
    }

    public void setZtysimisikngkmisihugou22(String pZtysimisikngkmisihugou22) {
        ztysimisikngkmisihugou22 = pZtysimisikngkmisihugou22;
    }

    private String ztysimisimeisaiyobi22;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI22)
    public String getZtysimisimeisaiyobi22() {
        return ztysimisimeisaiyobi22;
    }

    public void setZtysimisimeisaiyobi22(String pZtysimisimeisaiyobi22) {
        ztysimisimeisaiyobi22 = pZtysimisimeisaiyobi22;
    }

    private String ztysimisitekiyou23;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU23)
    public String getZtysimisitekiyou23() {
        return ztysimisitekiyou23;
    }

    public void setZtysimisitekiyou23(String pZtysimisitekiyou23) {
        ztysimisitekiyou23 = pZtysimisitekiyou23;
    }

    private String ztysimisikngkmisi23;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI23)
    public String getZtysimisikngkmisi23() {
        return ztysimisikngkmisi23;
    }

    public void setZtysimisikngkmisi23(String pZtysimisikngkmisi23) {
        ztysimisikngkmisi23 = pZtysimisikngkmisi23;
    }

    private String ztysimisikngkmisituukasyu23;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU23)
    public String getZtysimisikngkmisituukasyu23() {
        return ztysimisikngkmisituukasyu23;
    }

    public void setZtysimisikngkmisituukasyu23(String pZtysimisikngkmisituukasyu23) {
        ztysimisikngkmisituukasyu23 = pZtysimisikngkmisituukasyu23;
    }

    private String ztysimisimeisaibikou23;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU23)
    public String getZtysimisimeisaibikou23() {
        return ztysimisimeisaibikou23;
    }

    public void setZtysimisimeisaibikou23(String pZtysimisimeisaibikou23) {
        ztysimisimeisaibikou23 = pZtysimisimeisaibikou23;
    }

    private String ztysimisikngkmisihugou23;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU23)
    public String getZtysimisikngkmisihugou23() {
        return ztysimisikngkmisihugou23;
    }

    public void setZtysimisikngkmisihugou23(String pZtysimisikngkmisihugou23) {
        ztysimisikngkmisihugou23 = pZtysimisikngkmisihugou23;
    }

    private String ztysimisimeisaiyobi23;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI23)
    public String getZtysimisimeisaiyobi23() {
        return ztysimisimeisaiyobi23;
    }

    public void setZtysimisimeisaiyobi23(String pZtysimisimeisaiyobi23) {
        ztysimisimeisaiyobi23 = pZtysimisimeisaiyobi23;
    }

    private String ztysimisitekiyou24;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU24)
    public String getZtysimisitekiyou24() {
        return ztysimisitekiyou24;
    }

    public void setZtysimisitekiyou24(String pZtysimisitekiyou24) {
        ztysimisitekiyou24 = pZtysimisitekiyou24;
    }

    private String ztysimisikngkmisi24;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI24)
    public String getZtysimisikngkmisi24() {
        return ztysimisikngkmisi24;
    }

    public void setZtysimisikngkmisi24(String pZtysimisikngkmisi24) {
        ztysimisikngkmisi24 = pZtysimisikngkmisi24;
    }

    private String ztysimisikngkmisituukasyu24;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU24)
    public String getZtysimisikngkmisituukasyu24() {
        return ztysimisikngkmisituukasyu24;
    }

    public void setZtysimisikngkmisituukasyu24(String pZtysimisikngkmisituukasyu24) {
        ztysimisikngkmisituukasyu24 = pZtysimisikngkmisituukasyu24;
    }

    private String ztysimisimeisaibikou24;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU24)
    public String getZtysimisimeisaibikou24() {
        return ztysimisimeisaibikou24;
    }

    public void setZtysimisimeisaibikou24(String pZtysimisimeisaibikou24) {
        ztysimisimeisaibikou24 = pZtysimisimeisaibikou24;
    }

    private String ztysimisikngkmisihugou24;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU24)
    public String getZtysimisikngkmisihugou24() {
        return ztysimisikngkmisihugou24;
    }

    public void setZtysimisikngkmisihugou24(String pZtysimisikngkmisihugou24) {
        ztysimisikngkmisihugou24 = pZtysimisikngkmisihugou24;
    }

    private String ztysimisimeisaiyobi24;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI24)
    public String getZtysimisimeisaiyobi24() {
        return ztysimisimeisaiyobi24;
    }

    public void setZtysimisimeisaiyobi24(String pZtysimisimeisaiyobi24) {
        ztysimisimeisaiyobi24 = pZtysimisimeisaiyobi24;
    }

    private String ztysimisitekiyou25;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITEKIYOU25)
    public String getZtysimisitekiyou25() {
        return ztysimisitekiyou25;
    }

    public void setZtysimisitekiyou25(String pZtysimisitekiyou25) {
        ztysimisitekiyou25 = pZtysimisitekiyou25;
    }

    private String ztysimisikngkmisi25;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISI25)
    public String getZtysimisikngkmisi25() {
        return ztysimisikngkmisi25;
    }

    public void setZtysimisikngkmisi25(String pZtysimisikngkmisi25) {
        ztysimisikngkmisi25 = pZtysimisikngkmisi25;
    }

    private String ztysimisikngkmisituukasyu25;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISITUUKASYU25)
    public String getZtysimisikngkmisituukasyu25() {
        return ztysimisikngkmisituukasyu25;
    }

    public void setZtysimisikngkmisituukasyu25(String pZtysimisikngkmisituukasyu25) {
        ztysimisikngkmisituukasyu25 = pZtysimisikngkmisituukasyu25;
    }

    private String ztysimisimeisaibikou25;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBIKOU25)
    public String getZtysimisimeisaibikou25() {
        return ztysimisimeisaibikou25;
    }

    public void setZtysimisimeisaibikou25(String pZtysimisimeisaibikou25) {
        ztysimisimeisaibikou25 = pZtysimisimeisaibikou25;
    }

    private String ztysimisikngkmisihugou25;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIKNGKMISIHUGOU25)
    public String getZtysimisikngkmisihugou25() {
        return ztysimisikngkmisihugou25;
    }

    public void setZtysimisikngkmisihugou25(String pZtysimisikngkmisihugou25) {
        ztysimisikngkmisihugou25 = pZtysimisikngkmisihugou25;
    }

    private String ztysimisimeisaiyobi25;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIYOBI25)
    public String getZtysimisimeisaiyobi25() {
        return ztysimisimeisaiyobi25;
    }

    public void setZtysimisimeisaiyobi25(String pZtysimisimeisaiyobi25) {
        ztysimisimeisaiyobi25 = pZtysimisimeisaiyobi25;
    }

    private String ztysimisimeisaibuyobi1x1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBUYOBI1X1)
    public String getZtysimisimeisaibuyobi1x1() {
        return ztysimisimeisaibuyobi1x1;
    }

    public void setZtysimisimeisaibuyobi1x1(String pZtysimisimeisaibuyobi1x1) {
        ztysimisimeisaibuyobi1x1 = pZtysimisimeisaibuyobi1x1;
    }

    private String ztysimisimeisaibuyobi1x2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBUYOBI1X2)
    public String getZtysimisimeisaibuyobi1x2() {
        return ztysimisimeisaibuyobi1x2;
    }

    public void setZtysimisimeisaibuyobi1x2(String pZtysimisimeisaibuyobi1x2) {
        ztysimisimeisaibuyobi1x2 = pZtysimisimeisaibuyobi1x2;
    }

    private String ztysimisimeisaibuyobi1x3;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBUYOBI1X3)
    public String getZtysimisimeisaibuyobi1x3() {
        return ztysimisimeisaibuyobi1x3;
    }

    public void setZtysimisimeisaibuyobi1x3(String pZtysimisimeisaibuyobi1x3) {
        ztysimisimeisaibuyobi1x3 = pZtysimisimeisaibuyobi1x3;
    }

    private String ztysimisimeisaibuyobi1x4;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBUYOBI1X4)
    public String getZtysimisimeisaibuyobi1x4() {
        return ztysimisimeisaibuyobi1x4;
    }

    public void setZtysimisimeisaibuyobi1x4(String pZtysimisimeisaibuyobi1x4) {
        ztysimisimeisaibuyobi1x4 = pZtysimisimeisaibuyobi1x4;
    }

    private String ztysimisimeisaibuyobi1x5;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBUYOBI1X5)
    public String getZtysimisimeisaibuyobi1x5() {
        return ztysimisimeisaibuyobi1x5;
    }

    public void setZtysimisimeisaibuyobi1x5(String pZtysimisimeisaibuyobi1x5) {
        ztysimisimeisaibuyobi1x5 = pZtysimisimeisaibuyobi1x5;
    }

    private String ztysimisimeisaibuyobi1x6;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBUYOBI1X6)
    public String getZtysimisimeisaibuyobi1x6() {
        return ztysimisimeisaibuyobi1x6;
    }

    public void setZtysimisimeisaibuyobi1x6(String pZtysimisimeisaibuyobi1x6) {
        ztysimisimeisaibuyobi1x6 = pZtysimisimeisaibuyobi1x6;
    }

    private String ztysimisisigoukeikingaku;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISISIGOUKEIKINGAKU)
    public String getZtysimisisigoukeikingaku() {
        return ztysimisisigoukeikingaku;
    }

    public void setZtysimisisigoukeikingaku(String pZtysimisisigoukeikingaku) {
        ztysimisisigoukeikingaku = pZtysimisisigoukeikingaku;
    }

    private String ztysimisisigoukeituukasyu;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISISIGOUKEITUUKASYU)
    public String getZtysimisisigoukeituukasyu() {
        return ztysimisisigoukeituukasyu;
    }

    public void setZtysimisisigoukeituukasyu(String pZtysimisisigoukeituukasyu) {
        ztysimisisigoukeituukasyu = pZtysimisisigoukeituukasyu;
    }

    private String ztysimisimeisaibuyobi2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBUYOBI2)
    public String getZtysimisimeisaibuyobi2() {
        return ztysimisimeisaibuyobi2;
    }

    public void setZtysimisimeisaibuyobi2(String pZtysimisimeisaibuyobi2) {
        ztysimisimeisaibuyobi2 = pZtysimisimeisaibuyobi2;
    }

    private String ztysimisituutiranmidasi;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISITUUTIRANMIDASI)
    public String getZtysimisituutiranmidasi() {
        return ztysimisituutiranmidasi;
    }

    public void setZtysimisituutiranmidasi(String pZtysimisituutiranmidasi) {
        ztysimisituutiranmidasi = pZtysimisituutiranmidasi;
    }

    private String ztysimisifreemsg1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG1)
    public String getZtysimisifreemsg1() {
        return ztysimisifreemsg1;
    }

    public void setZtysimisifreemsg1(String pZtysimisifreemsg1) {
        ztysimisifreemsg1 = pZtysimisifreemsg1;
    }

    private String ztysimisifreemsg2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG2)
    public String getZtysimisifreemsg2() {
        return ztysimisifreemsg2;
    }

    public void setZtysimisifreemsg2(String pZtysimisifreemsg2) {
        ztysimisifreemsg2 = pZtysimisifreemsg2;
    }

    private String ztysimisifreemsg3;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG3)
    public String getZtysimisifreemsg3() {
        return ztysimisifreemsg3;
    }

    public void setZtysimisifreemsg3(String pZtysimisifreemsg3) {
        ztysimisifreemsg3 = pZtysimisifreemsg3;
    }

    private String ztysimisifreemsg4;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG4)
    public String getZtysimisifreemsg4() {
        return ztysimisifreemsg4;
    }

    public void setZtysimisifreemsg4(String pZtysimisifreemsg4) {
        ztysimisifreemsg4 = pZtysimisifreemsg4;
    }

    private String ztysimisifreemsg5;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG5)
    public String getZtysimisifreemsg5() {
        return ztysimisifreemsg5;
    }

    public void setZtysimisifreemsg5(String pZtysimisifreemsg5) {
        ztysimisifreemsg5 = pZtysimisifreemsg5;
    }

    private String ztysimisifreemsg6;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG6)
    public String getZtysimisifreemsg6() {
        return ztysimisifreemsg6;
    }

    public void setZtysimisifreemsg6(String pZtysimisifreemsg6) {
        ztysimisifreemsg6 = pZtysimisifreemsg6;
    }

    private String ztysimisifreemsg7;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG7)
    public String getZtysimisifreemsg7() {
        return ztysimisifreemsg7;
    }

    public void setZtysimisifreemsg7(String pZtysimisifreemsg7) {
        ztysimisifreemsg7 = pZtysimisifreemsg7;
    }

    private String ztysimisifreemsg8;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG8)
    public String getZtysimisifreemsg8() {
        return ztysimisifreemsg8;
    }

    public void setZtysimisifreemsg8(String pZtysimisifreemsg8) {
        ztysimisifreemsg8 = pZtysimisifreemsg8;
    }

    private String ztysimisifreemsg9;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG9)
    public String getZtysimisifreemsg9() {
        return ztysimisifreemsg9;
    }

    public void setZtysimisifreemsg9(String pZtysimisifreemsg9) {
        ztysimisifreemsg9 = pZtysimisifreemsg9;
    }

    private String ztysimisifreemsg10;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG10)
    public String getZtysimisifreemsg10() {
        return ztysimisifreemsg10;
    }

    public void setZtysimisifreemsg10(String pZtysimisifreemsg10) {
        ztysimisifreemsg10 = pZtysimisifreemsg10;
    }

    private String ztysimisifreemsg11;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG11)
    public String getZtysimisifreemsg11() {
        return ztysimisifreemsg11;
    }

    public void setZtysimisifreemsg11(String pZtysimisifreemsg11) {
        ztysimisifreemsg11 = pZtysimisifreemsg11;
    }

    private String ztysimisifreemsg12;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG12)
    public String getZtysimisifreemsg12() {
        return ztysimisifreemsg12;
    }

    public void setZtysimisifreemsg12(String pZtysimisifreemsg12) {
        ztysimisifreemsg12 = pZtysimisifreemsg12;
    }

    private String ztysimisifreemsg13;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG13)
    public String getZtysimisifreemsg13() {
        return ztysimisifreemsg13;
    }

    public void setZtysimisifreemsg13(String pZtysimisifreemsg13) {
        ztysimisifreemsg13 = pZtysimisifreemsg13;
    }

    private String ztysimisifreemsg14;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG14)
    public String getZtysimisifreemsg14() {
        return ztysimisifreemsg14;
    }

    public void setZtysimisifreemsg14(String pZtysimisifreemsg14) {
        ztysimisifreemsg14 = pZtysimisifreemsg14;
    }

    private String ztysimisifreemsg15;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG15)
    public String getZtysimisifreemsg15() {
        return ztysimisifreemsg15;
    }

    public void setZtysimisifreemsg15(String pZtysimisifreemsg15) {
        ztysimisifreemsg15 = pZtysimisifreemsg15;
    }

    private String ztysimisifreemsg16;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG16)
    public String getZtysimisifreemsg16() {
        return ztysimisifreemsg16;
    }

    public void setZtysimisifreemsg16(String pZtysimisifreemsg16) {
        ztysimisifreemsg16 = pZtysimisifreemsg16;
    }

    private String ztysimisifreemsg17;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG17)
    public String getZtysimisifreemsg17() {
        return ztysimisifreemsg17;
    }

    public void setZtysimisifreemsg17(String pZtysimisifreemsg17) {
        ztysimisifreemsg17 = pZtysimisifreemsg17;
    }

    private String ztysimisifreemsg18;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG18)
    public String getZtysimisifreemsg18() {
        return ztysimisifreemsg18;
    }

    public void setZtysimisifreemsg18(String pZtysimisifreemsg18) {
        ztysimisifreemsg18 = pZtysimisifreemsg18;
    }

    private String ztysimisifreemsg19;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG19)
    public String getZtysimisifreemsg19() {
        return ztysimisifreemsg19;
    }

    public void setZtysimisifreemsg19(String pZtysimisifreemsg19) {
        ztysimisifreemsg19 = pZtysimisifreemsg19;
    }

    private String ztysimisifreemsg20;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG20)
    public String getZtysimisifreemsg20() {
        return ztysimisifreemsg20;
    }

    public void setZtysimisifreemsg20(String pZtysimisifreemsg20) {
        ztysimisifreemsg20 = pZtysimisifreemsg20;
    }

    private String ztysimisifreemsg21;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG21)
    public String getZtysimisifreemsg21() {
        return ztysimisifreemsg21;
    }

    public void setZtysimisifreemsg21(String pZtysimisifreemsg21) {
        ztysimisifreemsg21 = pZtysimisifreemsg21;
    }

    private String ztysimisifreemsg22;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG22)
    public String getZtysimisifreemsg22() {
        return ztysimisifreemsg22;
    }

    public void setZtysimisifreemsg22(String pZtysimisifreemsg22) {
        ztysimisifreemsg22 = pZtysimisifreemsg22;
    }

    private String ztysimisifreemsg23;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG23)
    public String getZtysimisifreemsg23() {
        return ztysimisifreemsg23;
    }

    public void setZtysimisifreemsg23(String pZtysimisifreemsg23) {
        ztysimisifreemsg23 = pZtysimisifreemsg23;
    }

    private String ztysimisifreemsg24;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG24)
    public String getZtysimisifreemsg24() {
        return ztysimisifreemsg24;
    }

    public void setZtysimisifreemsg24(String pZtysimisifreemsg24) {
        ztysimisifreemsg24 = pZtysimisifreemsg24;
    }

    private String ztysimisifreemsg25;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG25)
    public String getZtysimisifreemsg25() {
        return ztysimisifreemsg25;
    }

    public void setZtysimisifreemsg25(String pZtysimisifreemsg25) {
        ztysimisifreemsg25 = pZtysimisifreemsg25;
    }

    private String ztysimisifreemsg26;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG26)
    public String getZtysimisifreemsg26() {
        return ztysimisifreemsg26;
    }

    public void setZtysimisifreemsg26(String pZtysimisifreemsg26) {
        ztysimisifreemsg26 = pZtysimisifreemsg26;
    }

    private String ztysimisifreemsg27;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG27)
    public String getZtysimisifreemsg27() {
        return ztysimisifreemsg27;
    }

    public void setZtysimisifreemsg27(String pZtysimisifreemsg27) {
        ztysimisifreemsg27 = pZtysimisifreemsg27;
    }

    private String ztysimisifreemsg28;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG28)
    public String getZtysimisifreemsg28() {
        return ztysimisifreemsg28;
    }

    public void setZtysimisifreemsg28(String pZtysimisifreemsg28) {
        ztysimisifreemsg28 = pZtysimisifreemsg28;
    }

    private String ztysimisifreemsg29;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG29)
    public String getZtysimisifreemsg29() {
        return ztysimisifreemsg29;
    }

    public void setZtysimisifreemsg29(String pZtysimisifreemsg29) {
        ztysimisifreemsg29 = pZtysimisifreemsg29;
    }

    private String ztysimisifreemsg30;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG30)
    public String getZtysimisifreemsg30() {
        return ztysimisifreemsg30;
    }

    public void setZtysimisifreemsg30(String pZtysimisifreemsg30) {
        ztysimisifreemsg30 = pZtysimisifreemsg30;
    }

    private String ztysimisifreemsg31;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG31)
    public String getZtysimisifreemsg31() {
        return ztysimisifreemsg31;
    }

    public void setZtysimisifreemsg31(String pZtysimisifreemsg31) {
        ztysimisifreemsg31 = pZtysimisifreemsg31;
    }

    private String ztysimisifreemsg32;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG32)
    public String getZtysimisifreemsg32() {
        return ztysimisifreemsg32;
    }

    public void setZtysimisifreemsg32(String pZtysimisifreemsg32) {
        ztysimisifreemsg32 = pZtysimisifreemsg32;
    }

    private String ztysimisifreemsg33;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG33)
    public String getZtysimisifreemsg33() {
        return ztysimisifreemsg33;
    }

    public void setZtysimisifreemsg33(String pZtysimisifreemsg33) {
        ztysimisifreemsg33 = pZtysimisifreemsg33;
    }

    private String ztysimisifreemsg34;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG34)
    public String getZtysimisifreemsg34() {
        return ztysimisifreemsg34;
    }

    public void setZtysimisifreemsg34(String pZtysimisifreemsg34) {
        ztysimisifreemsg34 = pZtysimisifreemsg34;
    }

    private String ztysimisifreemsg35;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG35)
    public String getZtysimisifreemsg35() {
        return ztysimisifreemsg35;
    }

    public void setZtysimisifreemsg35(String pZtysimisifreemsg35) {
        ztysimisifreemsg35 = pZtysimisifreemsg35;
    }

    private String ztysimisifreemsg36;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG36)
    public String getZtysimisifreemsg36() {
        return ztysimisifreemsg36;
    }

    public void setZtysimisifreemsg36(String pZtysimisifreemsg36) {
        ztysimisifreemsg36 = pZtysimisifreemsg36;
    }

    private String ztysimisifreemsg37;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG37)
    public String getZtysimisifreemsg37() {
        return ztysimisifreemsg37;
    }

    public void setZtysimisifreemsg37(String pZtysimisifreemsg37) {
        ztysimisifreemsg37 = pZtysimisifreemsg37;
    }

    private String ztysimisifreemsg38;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG38)
    public String getZtysimisifreemsg38() {
        return ztysimisifreemsg38;
    }

    public void setZtysimisifreemsg38(String pZtysimisifreemsg38) {
        ztysimisifreemsg38 = pZtysimisifreemsg38;
    }

    private String ztysimisifreemsg39;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG39)
    public String getZtysimisifreemsg39() {
        return ztysimisifreemsg39;
    }

    public void setZtysimisifreemsg39(String pZtysimisifreemsg39) {
        ztysimisifreemsg39 = pZtysimisifreemsg39;
    }

    private String ztysimisifreemsg40;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG40)
    public String getZtysimisifreemsg40() {
        return ztysimisifreemsg40;
    }

    public void setZtysimisifreemsg40(String pZtysimisifreemsg40) {
        ztysimisifreemsg40 = pZtysimisifreemsg40;
    }

    private String ztysimisifreemsg41;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG41)
    public String getZtysimisifreemsg41() {
        return ztysimisifreemsg41;
    }

    public void setZtysimisifreemsg41(String pZtysimisifreemsg41) {
        ztysimisifreemsg41 = pZtysimisifreemsg41;
    }

    private String ztysimisifreemsg42;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG42)
    public String getZtysimisifreemsg42() {
        return ztysimisifreemsg42;
    }

    public void setZtysimisifreemsg42(String pZtysimisifreemsg42) {
        ztysimisifreemsg42 = pZtysimisifreemsg42;
    }

    private String ztysimisifreemsg43;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG43)
    public String getZtysimisifreemsg43() {
        return ztysimisifreemsg43;
    }

    public void setZtysimisifreemsg43(String pZtysimisifreemsg43) {
        ztysimisifreemsg43 = pZtysimisifreemsg43;
    }

    private String ztysimisifreemsg44;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG44)
    public String getZtysimisifreemsg44() {
        return ztysimisifreemsg44;
    }

    public void setZtysimisifreemsg44(String pZtysimisifreemsg44) {
        ztysimisifreemsg44 = pZtysimisifreemsg44;
    }

    private String ztysimisifreemsg45;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG45)
    public String getZtysimisifreemsg45() {
        return ztysimisifreemsg45;
    }

    public void setZtysimisifreemsg45(String pZtysimisifreemsg45) {
        ztysimisifreemsg45 = pZtysimisifreemsg45;
    }

    private String ztysimisifreemsg46;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIFREEMSG46)
    public String getZtysimisifreemsg46() {
        return ztysimisifreemsg46;
    }

    public void setZtysimisifreemsg46(String pZtysimisifreemsg46) {
        ztysimisifreemsg46 = pZtysimisifreemsg46;
    }

    private String ztysimisiosirasemongon3x1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIOSIRASEMONGON3X1)
    public String getZtysimisiosirasemongon3x1() {
        return ztysimisiosirasemongon3x1;
    }

    public void setZtysimisiosirasemongon3x1(String pZtysimisiosirasemongon3x1) {
        ztysimisiosirasemongon3x1 = pZtysimisiosirasemongon3x1;
    }

    private String ztysimisiosirasemongon3x2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIOSIRASEMONGON3X2)
    public String getZtysimisiosirasemongon3x2() {
        return ztysimisiosirasemongon3x2;
    }

    public void setZtysimisiosirasemongon3x2(String pZtysimisiosirasemongon3x2) {
        ztysimisiosirasemongon3x2 = pZtysimisiosirasemongon3x2;
    }

    private String ztysimisisynykngk;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISISYNYKNGK)
    public String getZtysimisisynykngk() {
        return ztysimisisynykngk;
    }

    public void setZtysimisisynykngk(String pZtysimisisynykngk) {
        ztysimisisynykngk = pZtysimisisynykngk;
    }

    private String ztysimisihtykeihi;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIHTYKEIHI)
    public String getZtysimisihtykeihi() {
        return ztysimisihtykeihi;
    }

    public void setZtysimisihtykeihi(String pZtysimisihtykeihi) {
        ztysimisihtykeihi = pZtysimisihtykeihi;
    }

    private String ztykztkgk;

    @Column(name=GenZT_SiShrdetailTy.ZTYKZTKGK)
    public String getZtykztkgk() {
        return ztykztkgk;
    }

    public void setZtykztkgk(String pZtykztkgk) {
        ztykztkgk = pZtykztkgk;
    }

    private String ztyzeitratkikbn;

    @Column(name=GenZT_SiShrdetailTy.ZTYZEITRATKIKBN)
    public String getZtyzeitratkikbn() {
        return ztyzeitratkikbn;
    }

    public void setZtyzeitratkikbn(String pZtyzeitratkikbn) {
        ztyzeitratkikbn = pZtyzeitratkikbn;
    }

    private String ztykykhenkouumukbn;

    @Column(name=GenZT_SiShrdetailTy.ZTYKYKHENKOUUMUKBN)
    public String getZtykykhenkouumukbn() {
        return ztykykhenkouumukbn;
    }

    public void setZtykykhenkouumukbn(String pZtykykhenkouumukbn) {
        ztykykhenkouumukbn = pZtykykhenkouumukbn;
    }

    private String ztyshrkykhtykeihi;

    @Column(name=GenZT_SiShrdetailTy.ZTYSHRKYKHTYKEIHI)
    public String getZtyshrkykhtykeihi() {
        return ztyshrkykhtykeihi;
    }

    public void setZtyshrkykhtykeihi(String pZtyshrkykhtykeihi) {
        ztyshrkykhtykeihi = pZtyshrkykhtykeihi;
    }

    private String ztysimisimeisaibuyobi3x1;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBUYOBI3X1)
    public String getZtysimisimeisaibuyobi3x1() {
        return ztysimisimeisaibuyobi3x1;
    }

    public void setZtysimisimeisaibuyobi3x1(String pZtysimisimeisaibuyobi3x1) {
        ztysimisimeisaibuyobi3x1 = pZtysimisimeisaibuyobi3x1;
    }

    private String ztysimisimeisaibuyobi3x2;

    @Column(name=GenZT_SiShrdetailTy.ZTYSIMISIMEISAIBUYOBI3X2)
    public String getZtysimisimeisaibuyobi3x2() {
        return ztysimisimeisaibuyobi3x2;
    }

    public void setZtysimisimeisaibuyobi3x2(String pZtysimisimeisaibuyobi3x2) {
        ztysimisimeisaibuyobi3x2 = pZtysimisimeisaibuyobi3x2;
    }
}