package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_TtdkKanRn;
import yuyu.def.db.id.PKZT_TtdkKanRn;
import yuyu.def.db.meta.GenQZT_TtdkKanRn;
import yuyu.def.db.meta.QZT_TtdkKanRn;

/**
 * 手続完了Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TtdkKanRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanRn}</td><td colspan="3">手続完了Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_TtdkKanRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymdwa zrntyouhyouymdwa}</td><td>（連携用）帳票作成日（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_TtdkKanRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantousitukbn zrntantousitukbn}</td><td>（連携用）担当室区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyodouhuukbn zrnsyodouhuukbn}</td><td>（連携用）証券同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">{@link PKZT_TtdkKanRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv21 zrnyobiv21}</td><td>（連携用）予備項目Ｖ２１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskyno zrnshskyno}</td><td>（連携用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr1kj zrnshskadr1kj}</td><td>（連携用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr2kj zrnshskadr2kj}</td><td>（連携用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr3kj zrnshskadr3kj}</td><td>（連携用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshsnmkjttdk zrnshsnmkjttdk}</td><td>（連携用）送付先名（漢字）（手続完了）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshsnmkjttdk2 zrnshsnmkjttdk2}</td><td>（連携用）送付先名（漢字）（手続完了）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawyno zrntawyno}</td><td>（連携用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr1kj zrntawadr1kj}</td><td>（連携用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr2kj zrntawadr2kj}</td><td>（連携用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoiawasekaisyanmkj zrntoiawasekaisyanmkj}</td><td>（連携用）問合せ先会社名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawsosikikj zrntawsosikikj}</td><td>（連携用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawtelnov14 zrntawtelnov14}</td><td>（連携用）問合せ先電話番号Ｖ１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou1x18keta zrntawteluktkkanou1x18keta}</td><td>（連携用）問合せ先電話受付可能時間１（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou2x18keta zrntawteluktkkanou2x18keta}</td><td>（連携用）問合せ先電話受付可能時間２（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv26 zrnyobiv26}</td><td>（連携用）予備項目Ｖ２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntetudukisyunm zrntetudukisyunm}</td><td>（連携用）手続種類名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokakmngnumkbn zrnsyokakmngnumkbn}</td><td>（連携用）証券確認文言有無区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj zrnkyknmkj}</td><td>（連携用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv28 zrnyobiv28}</td><td>（連携用）予備項目Ｖ２８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyou1 zrnttdknaiyou1}</td><td>（連携用）手続内容１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyou2 zrnttdknaiyou2}</td><td>（連携用）手続内容２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyou3 zrnttdknaiyou3}</td><td>（連携用）手続内容３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyou4 zrnttdknaiyou4}</td><td>（連携用）手続内容４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyou5 zrnttdknaiyou5}</td><td>（連携用）手続内容５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyou6 zrnttdknaiyou6}</td><td>（連携用）手続内容６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyou7 zrnttdknaiyou7}</td><td>（連携用）手続内容７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyou8 zrnttdknaiyou8}</td><td>（連携用）手続内容８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyou9 zrnttdknaiyou9}</td><td>（連携用）手続内容９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyou10 zrnttdknaiyou10}</td><td>（連携用）手続内容１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyouumukbn zrnttdknaiyouumukbn}</td><td>（連携用）手続内容有無区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyuhnkkbn zrnkykniyuhnkkbn}</td><td>（連携用）契約内容変更区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyuhnkymd zrnkykniyuhnkymd}</td><td>（連携用）契約内容変更日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyuhnkinfo zrnkykniyuhnkinfo}</td><td>（連携用）契約内容変更情報</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyuhnkkngkhugou1 zrnkykniyuhnkkngkhugou1}</td><td>（連携用）契約内容変更金額明細符号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyuhnkkngk1 zrnkykniyuhnkkngk1}</td><td>（連携用）契約内容変更金額１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyuhnkkngktuksyu1 zrnkykniyuhnkkngktuksyu1}</td><td>（連携用）契約内容変更金額通貨種類１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyuhnkkngkhugou2 zrnkykniyuhnkkngkhugou2}</td><td>（連携用）契約内容変更金額明細符号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyuhnkkngk2 zrnkykniyuhnkkngk2}</td><td>（連携用）契約内容変更金額２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyuhnkkngktuksyu2 zrnkykniyuhnkkngktuksyu2}</td><td>（連携用）契約内容変更金額通貨種類２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv102 zrnyobiv102}</td><td>（連携用）予備項目Ｖ１０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiharaibiwareki zrnsiharaibiwareki}</td><td>（連携用）支払日（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuymdwa zrnkaiyakuymdwa}</td><td>（連携用）解約日（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou1 zrntekiyou1}</td><td>（連携用）摘要１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou1 zrnshrkngkmeisaihugou1}</td><td>（連携用）支払金額明細符号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai1 zrnshrgkmeisai1}</td><td>（連携用）支払金額明細１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu1 zrnshrgktuukasyu1}</td><td>（連携用）支払金額通貨種類１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou1 zrnbikou1}</td><td>（連携用）備考１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou2 zrntekiyou2}</td><td>（連携用）摘要２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou2 zrnshrkngkmeisaihugou2}</td><td>（連携用）支払金額明細符号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai2 zrnshrgkmeisai2}</td><td>（連携用）支払金額明細２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu2 zrnshrgktuukasyu2}</td><td>（連携用）支払金額通貨種類２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou2 zrnbikou2}</td><td>（連携用）備考２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou3 zrntekiyou3}</td><td>（連携用）摘要３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou3 zrnshrkngkmeisaihugou3}</td><td>（連携用）支払金額明細符号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai3 zrnshrgkmeisai3}</td><td>（連携用）支払金額明細３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu3 zrnshrgktuukasyu3}</td><td>（連携用）支払金額通貨種類３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou3 zrnbikou3}</td><td>（連携用）備考３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou4 zrntekiyou4}</td><td>（連携用）摘要４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou4 zrnshrkngkmeisaihugou4}</td><td>（連携用）支払金額明細符号４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai4 zrnshrgkmeisai4}</td><td>（連携用）支払金額明細４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu4 zrnshrgktuukasyu4}</td><td>（連携用）支払金額通貨種類４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou4 zrnbikou4}</td><td>（連携用）備考４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou5 zrntekiyou5}</td><td>（連携用）摘要５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou5 zrnshrkngkmeisaihugou5}</td><td>（連携用）支払金額明細符号５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai5 zrnshrgkmeisai5}</td><td>（連携用）支払金額明細５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu5 zrnshrgktuukasyu5}</td><td>（連携用）支払金額通貨種類５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou5 zrnbikou5}</td><td>（連携用）備考５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou6 zrntekiyou6}</td><td>（連携用）摘要６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou6 zrnshrkngkmeisaihugou6}</td><td>（連携用）支払金額明細符号６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai6 zrnshrgkmeisai6}</td><td>（連携用）支払金額明細６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu6 zrnshrgktuukasyu6}</td><td>（連携用）支払金額通貨種類６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou6 zrnbikou6}</td><td>（連携用）備考６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou7 zrntekiyou7}</td><td>（連携用）摘要７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou7 zrnshrkngkmeisaihugou7}</td><td>（連携用）支払金額明細符号７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai7 zrnshrgkmeisai7}</td><td>（連携用）支払金額明細７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu7 zrnshrgktuukasyu7}</td><td>（連携用）支払金額通貨種類７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou7 zrnbikou7}</td><td>（連携用）備考７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou8 zrntekiyou8}</td><td>（連携用）摘要８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou8 zrnshrkngkmeisaihugou8}</td><td>（連携用）支払金額明細符号８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai8 zrnshrgkmeisai8}</td><td>（連携用）支払金額明細８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu8 zrnshrgktuukasyu8}</td><td>（連携用）支払金額通貨種類８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou8 zrnbikou8}</td><td>（連携用）備考８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou9 zrntekiyou9}</td><td>（連携用）摘要９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou9 zrnshrkngkmeisaihugou9}</td><td>（連携用）支払金額明細符号９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai9 zrnshrgkmeisai9}</td><td>（連携用）支払金額明細９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu9 zrnshrgktuukasyu9}</td><td>（連携用）支払金額通貨種類９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou9 zrnbikou9}</td><td>（連携用）備考９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou10 zrntekiyou10}</td><td>（連携用）摘要１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkngkmeisaihugou10 zrnshrkngkmeisaihugou10}</td><td>（連携用）支払金額明細符号１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai10 zrnshrgkmeisai10}</td><td>（連携用）支払金額明細１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgktuukasyu10 zrnshrgktuukasyu10}</td><td>（連携用）支払金額通貨種類１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbikou10 zrnbikou10}</td><td>（連携用）備考１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkgoukei zrnshrgkgoukei}</td><td>（連携用）支払額合計</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtuukasyu zrnshrtuukasyu}</td><td>（連携用）支払通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndseisanshrttdknm zrndseisanshrttdknm}</td><td>（連携用）Ｄ精算支払手続名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv26x3 zrnyobiv26x3}</td><td>（連携用）予備項目Ｖ２６＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbanknmkj zrnbanknmkj}</td><td>（連携用）銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsitennmkj zrnsitennmkj}</td><td>（連携用）支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokinkbn zrnyokinkbn}</td><td>（連携用）預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzano12keta zrnkouzano12keta}</td><td>（連携用）口座番号（１２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzmeiginmknhan zrnkzmeiginmknhan}</td><td>（連携用）口座名義人氏名（カナ）（半角）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzasyuruikbn zrnkouzasyuruikbn}</td><td>（連携用）口座種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv26x2 zrnyobiv26x2}</td><td>（連携用）予備項目Ｖ２６＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsynykngk zrnsynykngk}</td><td>（連携用）収入金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsynykngktuukasyu zrnsynykngktuukasyu}</td><td>（連携用）収入金額通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtykeihi zrnhtykeihi}</td><td>（連携用）必要経費</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtykeihituukasyu zrnhtykeihituukasyu}</td><td>（連携用）必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkyksyahtykeihi zrnshrkyksyahtykeihi}</td><td>（連携用）お支払時の契約者の必要経費</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrkykhtykeihituukasyu zrnshrkykhtykeihituukasyu}</td><td>（連携用）お支払時の契約者の必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngsbnrkzthtykeihi zrngsbnrkzthtykeihi}</td><td>（連携用）源泉分離課税対象の必要経費</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngsbnrkzthtykeihituksyu zrngsbnrkzthtykeihituksyu}</td><td>（連携用）源泉分離課税対象の必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngsbnrkztsaeki zrngsbnrkztsaeki}</td><td>（連携用）源泉分離課税対象の差益</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngsbnrkztsaekituksyu zrngsbnrkztsaekituksyu}</td><td>（連携用）源泉分離課税対象の差益通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimunaiyouhensyuctrlkbn zrnzeimunaiyouhensyuctrlkbn}</td><td>（連携用）税務内容編集制御区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongonoutkbn zrnzeimumongonoutkbn}</td><td>（連携用）税務文言出力区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon1 zrnzeimumongon1}</td><td>（連携用）税務文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon2 zrnzeimumongon2}</td><td>（連携用）税務文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon3 zrnzeimumongon3}</td><td>（連携用）税務文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon4 zrnzeimumongon4}</td><td>（連携用）税務文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon5 zrnzeimumongon5}</td><td>（連携用）税務文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyendthnkzeimuinfohskkbn zrnyendthnkzeimuinfohskkbn}</td><td>（連携用）円建変更時税務情報補足区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv36 zrnyobiv36}</td><td>（連携用）予備項目Ｖ３６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasehyoudai zrnosirasehyoudai}</td><td>（連携用）お知らせ表題</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon1 zrnosirasemongon1}</td><td>（連携用）お知らせ文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon2 zrnosirasemongon2}</td><td>（連携用）お知らせ文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon3 zrnosirasemongon3}</td><td>（連携用）お知らせ文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon4 zrnosirasemongon4}</td><td>（連携用）お知らせ文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon5 zrnosirasemongon5}</td><td>（連携用）お知らせ文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon6 zrnosirasemongon6}</td><td>（連携用）お知らせ文言６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon7 zrnosirasemongon7}</td><td>（連携用）お知らせ文言７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon8 zrnosirasemongon8}</td><td>（連携用）お知らせ文言８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon9 zrnosirasemongon9}</td><td>（連携用）お知らせ文言９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon10 zrnosirasemongon10}</td><td>（連携用）お知らせ文言１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon11 zrnosirasemongon11}</td><td>（連携用）お知らせ文言１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon12 zrnosirasemongon12}</td><td>（連携用）お知らせ文言１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon13 zrnosirasemongon13}</td><td>（連携用）お知らせ文言１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon14 zrnosirasemongon14}</td><td>（連携用）お知らせ文言１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon15 zrnosirasemongon15}</td><td>（連携用）お知らせ文言１５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon16 zrnosirasemongon16}</td><td>（連携用）お知らせ文言１６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon17 zrnosirasemongon17}</td><td>（連携用）お知らせ文言１７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon18 zrnosirasemongon18}</td><td>（連携用）お知らせ文言１８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon19 zrnosirasemongon19}</td><td>（連携用）お知らせ文言１９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon20 zrnosirasemongon20}</td><td>（連携用）お知らせ文言２０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon21 zrnosirasemongon21}</td><td>（連携用）お知らせ文言２１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon22 zrnosirasemongon22}</td><td>（連携用）お知らせ文言２２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon23 zrnosirasemongon23}</td><td>（連携用）お知らせ文言２３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon24 zrnosirasemongon24}</td><td>（連携用）お知らせ文言２４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon25 zrnosirasemongon25}</td><td>（連携用）お知らせ文言２５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon26 zrnosirasemongon26}</td><td>（連携用）お知らせ文言２６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon27 zrnosirasemongon27}</td><td>（連携用）お知らせ文言２７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon28 zrnosirasemongon28}</td><td>（連携用）お知らせ文言２８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon29 zrnosirasemongon29}</td><td>（連携用）お知らせ文言２９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon30 zrnosirasemongon30}</td><td>（連携用）お知らせ文言３０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon31 zrnosirasemongon31}</td><td>（連携用）お知らせ文言３１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon32 zrnosirasemongon32}</td><td>（連携用）お知らせ文言３２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon33 zrnosirasemongon33}</td><td>（連携用）お知らせ文言３３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon34 zrnosirasemongon34}</td><td>（連携用）お知らせ文言３４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon35 zrnosirasemongon35}</td><td>（連携用）お知らせ文言３５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon36 zrnosirasemongon36}</td><td>（連携用）お知らせ文言３６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon37 zrnosirasemongon37}</td><td>（連携用）お知らせ文言３７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon38 zrnosirasemongon38}</td><td>（連携用）お知らせ文言３８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon39 zrnosirasemongon39}</td><td>（連携用）お知らせ文言３９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon40 zrnosirasemongon40}</td><td>（連携用）お知らせ文言４０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon41 zrnosirasemongon41}</td><td>（連携用）お知らせ文言４１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon42 zrnosirasemongon42}</td><td>（連携用）お知らせ文言４２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon43 zrnosirasemongon43}</td><td>（連携用）お知らせ文言４３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon44 zrnosirasemongon44}</td><td>（連携用）お知らせ文言４４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon45 zrnosirasemongon45}</td><td>（連携用）お知らせ文言４５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon46 zrnosirasemongon46}</td><td>（連携用）お知らせ文言４６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon47 zrnosirasemongon47}</td><td>（連携用）お知らせ文言４７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon48 zrnosirasemongon48}</td><td>（連携用）お知らせ文言４８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon49 zrnosirasemongon49}</td><td>（連携用）お知らせ文言４９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon50 zrnosirasemongon50}</td><td>（連携用）お知らせ文言５０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosiraseinjihuyouhyouji zrnosiraseinjihuyouhyouji}</td><td>（連携用）お知らせ印字不要表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv254 zrnyobiv254}</td><td>（連携用）予備項目Ｖ２５４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrnaiyouhskmongon1 zrnshrnaiyouhskmongon1}</td><td>（連携用）支払内容補足文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrnaiyouhskmongon2 zrnshrnaiyouhskmongon2}</td><td>（連携用）支払内容補足文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndocumentid zrndocumentid}</td><td>（連携用）ドキュメントＩＤ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsksmongonkbn1 zrnsksmongonkbn1}</td><td>（連携用）請求書文言区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsksmongonkbn2 zrnsksmongonkbn2}</td><td>（連携用）請求書文言区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoritugisyasyozokunm zrntoritugisyasyozokunm}</td><td>（連携用）取次者所属名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoritugisyakjncd zrntoritugisyakjncd}</td><td>（連携用）取次者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoritugisyanm zrntoritugisyanm}</td><td>（連携用）取次者氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhozonkkny zrnhozonkkny}</td><td>（連携用）保存期間（年）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsintelno zrntsintelno}</td><td>（連携用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv141 zrnyobiv141}</td><td>（連携用）予備項目Ｖ１４１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkkbn1 zrntrkkzkkbn1}</td><td>（連携用）登録家族区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzknmkj1 zrntrkkzknmkj1}</td><td>（連携用）登録家族名（漢字）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkseiymd1zenkaku zrntrkkzkseiymd1zenkaku}</td><td>（連携用）登録家族１人目生年月日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkyno1 zrntrkkzkyno1}</td><td>（連携用）登録家族郵便番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkadr1kj1 zrntrkkzkadr1kj1}</td><td>（連携用）登録家族住所１（漢字）１　</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkadr2kj1 zrntrkkzkadr2kj1}</td><td>（連携用）登録家族住所２（漢字）１　</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkadr3kj1 zrntrkkzkadr3kj1}</td><td>（連携用）登録家族住所３（漢字）１　</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzktelno1 zrntrkkzktelno1}</td><td>（連携用）登録家族電話番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzktelnomtrkhyouji1 zrntrkkzktelnomtrkhyouji1}</td><td>（連携用）登録家族電話番号未登録表示１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkkbn2 zrntrkkzkkbn2}</td><td>（連携用）登録家族区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzknmkj2 zrntrkkzknmkj2}</td><td>（連携用）登録家族名（漢字）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkseiymd2zenkaku zrntrkkzkseiymd2zenkaku}</td><td>（連携用）登録家族２人目生年月日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkyno2 zrntrkkzkyno2}</td><td>（連携用）登録家族郵便番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkadr1kj2 zrntrkkzkadr1kj2}</td><td>（連携用）登録家族住所１（漢字）２　</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkadr2kj2 zrntrkkzkadr2kj2}</td><td>（連携用）登録家族住所２（漢字）２　</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkadr3kj2 zrntrkkzkadr3kj2}</td><td>（連携用）登録家族住所３（漢字）２　</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzktelno2 zrntrkkzktelno2}</td><td>（連携用）登録家族電話番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdairinmkj zrnkykdairinmkj}</td><td>（連携用）契約者代理人名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykomttutkbn zrnkykomttutkbn}</td><td>（連携用）契約者用表通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkomttutkbn1 zrnkzkomttutkbn1}</td><td>（連携用）家族１用表通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkomttutkbn2 zrnkzkomttutkbn2}</td><td>（連携用）家族２用表通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkomttutkbn zrnhhkomttutkbn}</td><td>（連携用）被保険者用表通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdromttutkbn zrnhhkdromttutkbn}</td><td>（連携用）被保険者代理人用表通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdairiomttutkbn zrnkykdairiomttutkbn}</td><td>（連携用）契約者代理人用表通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykurtutkbn zrnkykurtutkbn}</td><td>（連携用）契約者用裏通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkurtutkbn1 zrnkzkurtutkbn1}</td><td>（連携用）家族１用裏通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkurtutkbn2 zrnkzkurtutkbn2}</td><td>（連携用）家族２用裏通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdrurtutkbn zrnhhkdrurtutkbn}</td><td>（連携用）被保険者代理人用裏通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdairiurtutkbn zrnkykdairiurtutkbn}</td><td>（連携用）契約者代理人用裏通知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykaistmsgkbn zrnkykaistmsgkbn}</td><td>（連携用）契約者用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkaistmsgkbn1 zrnkzkaistmsgkbn1}</td><td>（連携用）家族１用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkaistmsgkbn2 zrnkzkaistmsgkbn2}</td><td>（連携用）家族２用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkaistmsgkbn zrnhhkaistmsgkbn}</td><td>（連携用）被保険者用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdraistmsgkbn zrnhhkdraistmsgkbn}</td><td>（連携用）被保険者代理人用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdairiaistmsgkbn zrnkykdairiaistmsgkbn}</td><td>（連携用）契約者代理人用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakujyokzknmkj zrnsakujyokzknmkj}</td><td>（連携用）削除家族名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdknaiyoukbn zrnttdknaiyoukbn}</td><td>（連携用）手続内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktaisyoukykkbn zrnkzktaisyoukykkbn}</td><td>（連携用）家族用対象契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdrtaisyoukykkbn zrnhhkdrtaisyoukykkbn}</td><td>（連携用）被保険者代理人用対象契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdairitaisyoukykkbn zrnkykdairitaisyoukykkbn}</td><td>（連携用）契約者代理人用対象契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmoshnkniymsgkbn1 zrnmoshnkniymsgkbn1}</td><td>（連携用）申込変更内容ＭＳＧ区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykmoshnkniymsg2 zrnkykmoshnkniymsg2}</td><td>（連携用）契約者用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmoshnkniymsg21 zrnkzkmoshnkniymsg21}</td><td>（連携用）家族１用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmoshnkniymsg22 zrnkzkmoshnkniymsg22}</td><td>（連携用）家族２用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdrmoshnkniymsg2 zrnhhkdrmoshnkniymsg2}</td><td>（連携用）被保険者代理人用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdairimoshnkniymsg2 zrnkykdairimoshnkniymsg2}</td><td>（連携用）契約者代理人用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrmsgkbn zrnkykdrmsgkbn}</td><td>（連携用）契約者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykhhkdrmsg zrnkykhhkdrmsg}</td><td>（連携用）契約者用被保険者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkhhkdrmsg1 zrnkzkhhkdrmsg1}</td><td>（連携用）家族１用被保険者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkhhkdrmsg2 zrnkzkhhkdrmsg2}</td><td>（連携用）家族２用被保険者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdrnmkj zrnhhkdrnmkj}</td><td>（連携用）被保険者代理人名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduhubutumsg1 zrnduhubutumsg1}</td><td>（連携用）同封物ＭＳＧ区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduhubutumsg2 zrnduhubutumsg2}</td><td>（連携用）同封物ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduhubutumsg3 zrnduhubutumsg3}</td><td>（連携用）同封物ＭＳＧ区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduhubutumsg4 zrnduhubutumsg4}</td><td>（連携用）同封物ＭＳＧ区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduhubutumsg5 zrnduhubutumsg5}</td><td>（連携用）同封物ＭＳＧ区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduhubutumsg6 zrnduhubutumsg6}</td><td>（連携用）同封物ＭＳＧ区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduhubutumsg7 zrnduhubutumsg7}</td><td>（連携用）同封物ＭＳＧ区分７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykigaidhbtmsg1 zrnkykigaidhbtmsg1}</td><td>（連携用）契約者以外用同封物ＭＳＧ区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykigaidhbtmsg2 zrnkykigaidhbtmsg2}</td><td>（連携用）契約者以外用同封物ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykigaidhbtmsg3 zrnkykigaidhbtmsg3}</td><td>（連携用）契約者以外用同封物ＭＳＧ区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykigaidhbtmsg4 zrnkykigaidhbtmsg4}</td><td>（連携用）契約者以外用同封物ＭＳＧ区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakkankiyakuhunyuuhyouji zrnyakkankiyakuhunyuuhyouji}</td><td>（連携用）約款規約封入表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktrktrshuunyuuhyouji zrnkyktrktrshuunyuuhyouji}</td><td>（連携用）登録チラシ封入表示（契）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktrktrshuunyuuhyouji1 zrnkzktrktrshuunyuuhyouji1}</td><td>（連携用）登録チラシ封入表示（家族１）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktrktrshuunyuuhyouji2 zrnkzktrktrshuunyuuhyouji2}</td><td>（連携用）登録チラシ封入表示（家族２）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrhuunyuuhyouji zrnkykdrhuunyuuhyouji}</td><td>（連携用）契約者代理封入表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdrhuunyuuhyouji zrnhhkdrhuunyuuhyouji}</td><td>（連携用）被保険者代理封入表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdairinmkj2 zrnkykdairinmkj2}</td><td>（連携用）契約者代理人名（漢字）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrseiymd zrnkykdrseiymd}</td><td>（連携用）契約者代理人生年月日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdryno zrnkykdryno}</td><td>（連携用）契約者代理人郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdradr1kj zrnkykdradr1kj}</td><td>（連携用）契約者代理人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdradr2kj zrnkykdradr2kj}</td><td>（連携用）契約者代理人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdradr3kj zrnkykdradr3kj}</td><td>（連携用）契約者代理人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrtelno zrnkykdrtelno}</td><td>（連携用）契約者代理人電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdrnmkj2 zrnhhkdrnmkj2}</td><td>（連携用）被保険者代理人名（漢字）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdrseiymd zrnhhkdrseiymd}</td><td>（連携用）被保険者代理人生年月日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdryno zrnhhkdryno}</td><td>（連携用）被保険者代理人郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdradr1kj zrnhhkdradr1kj}</td><td>（連携用）被保険者代理人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdradr2kj zrnhhkdradr2kj}</td><td>（連携用）被保険者代理人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdradr3kj zrnhhkdradr3kj}</td><td>（連携用）被保険者代理人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdrtelno zrnhhkdrtelno}</td><td>（連携用）被保険者代理人電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkdrtelnomtrkhyouji zrnhhkdrtelnomtrkhyouji}</td><td>（連携用）被保険者代理人電話番号未登録表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyono2 zrnkhsyono2}</td><td>（連携用）（契約保全）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyono3 zrnkhsyono3}</td><td>（連携用）（契約保全）証券番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyono4 zrnkhsyono4}</td><td>（連携用）（契約保全）証券番号４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyono5 zrnkhsyono5}</td><td>（連携用）（契約保全）証券番号５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyono6 zrnkhsyono6}</td><td>（連携用）（契約保全）証券番号６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyono7 zrnkhsyono7}</td><td>（連携用）（契約保全）証券番号７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyono8 zrnkhsyono8}</td><td>（連携用）（契約保全）証券番号８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyono9 zrnkhsyono9}</td><td>（連携用）（契約保全）証券番号９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyono10 zrnkhsyono10}</td><td>（連携用）（契約保全）証券番号１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhmosno1 zrnkhmosno1}</td><td>（連携用）（契約保全）申込番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhmosno2 zrnkhmosno2}</td><td>（連携用）（契約保全）申込番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhmosno3 zrnkhmosno3}</td><td>（連携用）（契約保全）申込番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhmosno4 zrnkhmosno4}</td><td>（連携用）（契約保全）申込番号４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhmosno5 zrnkhmosno5}</td><td>（連携用）（契約保全）申込番号５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhmosno6 zrnkhmosno6}</td><td>（連携用）（契約保全）申込番号６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhmosno7 zrnkhmosno7}</td><td>（連携用）（契約保全）申込番号７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhmosno8 zrnkhmosno8}</td><td>（連携用）（契約保全）申込番号８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhmosno9 zrnkhmosno9}</td><td>（連携用）（契約保全）申込番号９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhmosno10 zrnkhmosno10}</td><td>（連携用）（契約保全）申込番号１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnsnhutouhuunyuuhyouji zrnhnsnhutouhuunyuuhyouji}</td><td>（連携用）返信用封筒封入表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv204 zrnyobiv204}</td><td>（連携用）予備項目Ｖ２０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv255x2 zrnyobiv255x2}</td><td>（連携用）予備項目Ｖ２５５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv255x3 zrnyobiv255x3}</td><td>（連携用）予備項目Ｖ２５５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv255x4 zrnyobiv255x4}</td><td>（連携用）予備項目Ｖ２５５＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanRn
 * @see     PKZT_TtdkKanRn
 * @see     QZT_TtdkKanRn
 * @see     GenQZT_TtdkKanRn
 */
@MappedSuperclass
@Table(name=GenZT_TtdkKanRn.TABLE_NAME)
@IdClass(value=PKZT_TtdkKanRn.class)
public abstract class GenZT_TtdkKanRn extends AbstractExDBEntityForZDB<ZT_TtdkKanRn, PKZT_TtdkKanRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TtdkKanRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNTYOUHYOUYMDWA         = "zrntyouhyouymdwa";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNTANTOUSITUKBN         = "zrntantousitukbn";
    public static final String ZRNSYODOUHUUKBN          = "zrnsyodouhuukbn";
    public static final String ZRNSIKIBETUNO            = "zrnsikibetuno";
    public static final String ZRNYOBIV21               = "zrnyobiv21";
    public static final String ZRNSHSKYNO               = "zrnshskyno";
    public static final String ZRNSHSKADR1KJ            = "zrnshskadr1kj";
    public static final String ZRNSHSKADR2KJ            = "zrnshskadr2kj";
    public static final String ZRNSHSKADR3KJ            = "zrnshskadr3kj";
    public static final String ZRNSHSNMKJTTDK           = "zrnshsnmkjttdk";
    public static final String ZRNSHSNMKJTTDK2          = "zrnshsnmkjttdk2";
    public static final String ZRNYOBIV3                = "zrnyobiv3";
    public static final String ZRNTAWYNO                = "zrntawyno";
    public static final String ZRNTAWADR1KJ             = "zrntawadr1kj";
    public static final String ZRNTAWADR2KJ             = "zrntawadr2kj";
    public static final String ZRNTOIAWASEKAISYANMKJ    = "zrntoiawasekaisyanmkj";
    public static final String ZRNTAWSOSIKIKJ           = "zrntawsosikikj";
    public static final String ZRNTAWTELNOV14           = "zrntawtelnov14";
    public static final String ZRNTAWTELUKTKKANOU1X18KETA = "zrntawteluktkkanou1x18keta";
    public static final String ZRNTAWTELUKTKKANOU2X18KETA = "zrntawteluktkkanou2x18keta";
    public static final String ZRNYOBIV26               = "zrnyobiv26";
    public static final String ZRNTETUDUKISYUNM         = "zrntetudukisyunm";
    public static final String ZRNSYOKAKMNGNUMKBN       = "zrnsyokakmngnumkbn";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNKYKNMKJ               = "zrnkyknmkj";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNYOBIV28               = "zrnyobiv28";
    public static final String ZRNTTDKNAIYOU1           = "zrnttdknaiyou1";
    public static final String ZRNTTDKNAIYOU2           = "zrnttdknaiyou2";
    public static final String ZRNTTDKNAIYOU3           = "zrnttdknaiyou3";
    public static final String ZRNTTDKNAIYOU4           = "zrnttdknaiyou4";
    public static final String ZRNTTDKNAIYOU5           = "zrnttdknaiyou5";
    public static final String ZRNTTDKNAIYOU6           = "zrnttdknaiyou6";
    public static final String ZRNTTDKNAIYOU7           = "zrnttdknaiyou7";
    public static final String ZRNTTDKNAIYOU8           = "zrnttdknaiyou8";
    public static final String ZRNTTDKNAIYOU9           = "zrnttdknaiyou9";
    public static final String ZRNTTDKNAIYOU10          = "zrnttdknaiyou10";
    public static final String ZRNTTDKNAIYOUUMUKBN      = "zrnttdknaiyouumukbn";
    public static final String ZRNKYKNIYUHNKKBN         = "zrnkykniyuhnkkbn";
    public static final String ZRNKYKNIYUHNKYMD         = "zrnkykniyuhnkymd";
    public static final String ZRNKYKNIYUHNKINFO        = "zrnkykniyuhnkinfo";
    public static final String ZRNKYKNIYUHNKKNGKHUGOU1  = "zrnkykniyuhnkkngkhugou1";
    public static final String ZRNKYKNIYUHNKKNGK1       = "zrnkykniyuhnkkngk1";
    public static final String ZRNKYKNIYUHNKKNGKTUKSYU1 = "zrnkykniyuhnkkngktuksyu1";
    public static final String ZRNKYKNIYUHNKKNGKHUGOU2  = "zrnkykniyuhnkkngkhugou2";
    public static final String ZRNKYKNIYUHNKKNGK2       = "zrnkykniyuhnkkngk2";
    public static final String ZRNKYKNIYUHNKKNGKTUKSYU2 = "zrnkykniyuhnkkngktuksyu2";
    public static final String ZRNYOBIV102              = "zrnyobiv102";
    public static final String ZRNSIHARAIBIWAREKI       = "zrnsiharaibiwareki";
    public static final String ZRNKAIYAKUYMDWA          = "zrnkaiyakuymdwa";
    public static final String ZRNTEKIYOU1              = "zrntekiyou1";
    public static final String ZRNSHRKNGKMEISAIHUGOU1   = "zrnshrkngkmeisaihugou1";
    public static final String ZRNSHRGKMEISAI1          = "zrnshrgkmeisai1";
    public static final String ZRNSHRGKTUUKASYU1        = "zrnshrgktuukasyu1";
    public static final String ZRNBIKOU1                = "zrnbikou1";
    public static final String ZRNTEKIYOU2              = "zrntekiyou2";
    public static final String ZRNSHRKNGKMEISAIHUGOU2   = "zrnshrkngkmeisaihugou2";
    public static final String ZRNSHRGKMEISAI2          = "zrnshrgkmeisai2";
    public static final String ZRNSHRGKTUUKASYU2        = "zrnshrgktuukasyu2";
    public static final String ZRNBIKOU2                = "zrnbikou2";
    public static final String ZRNTEKIYOU3              = "zrntekiyou3";
    public static final String ZRNSHRKNGKMEISAIHUGOU3   = "zrnshrkngkmeisaihugou3";
    public static final String ZRNSHRGKMEISAI3          = "zrnshrgkmeisai3";
    public static final String ZRNSHRGKTUUKASYU3        = "zrnshrgktuukasyu3";
    public static final String ZRNBIKOU3                = "zrnbikou3";
    public static final String ZRNTEKIYOU4              = "zrntekiyou4";
    public static final String ZRNSHRKNGKMEISAIHUGOU4   = "zrnshrkngkmeisaihugou4";
    public static final String ZRNSHRGKMEISAI4          = "zrnshrgkmeisai4";
    public static final String ZRNSHRGKTUUKASYU4        = "zrnshrgktuukasyu4";
    public static final String ZRNBIKOU4                = "zrnbikou4";
    public static final String ZRNTEKIYOU5              = "zrntekiyou5";
    public static final String ZRNSHRKNGKMEISAIHUGOU5   = "zrnshrkngkmeisaihugou5";
    public static final String ZRNSHRGKMEISAI5          = "zrnshrgkmeisai5";
    public static final String ZRNSHRGKTUUKASYU5        = "zrnshrgktuukasyu5";
    public static final String ZRNBIKOU5                = "zrnbikou5";
    public static final String ZRNTEKIYOU6              = "zrntekiyou6";
    public static final String ZRNSHRKNGKMEISAIHUGOU6   = "zrnshrkngkmeisaihugou6";
    public static final String ZRNSHRGKMEISAI6          = "zrnshrgkmeisai6";
    public static final String ZRNSHRGKTUUKASYU6        = "zrnshrgktuukasyu6";
    public static final String ZRNBIKOU6                = "zrnbikou6";
    public static final String ZRNTEKIYOU7              = "zrntekiyou7";
    public static final String ZRNSHRKNGKMEISAIHUGOU7   = "zrnshrkngkmeisaihugou7";
    public static final String ZRNSHRGKMEISAI7          = "zrnshrgkmeisai7";
    public static final String ZRNSHRGKTUUKASYU7        = "zrnshrgktuukasyu7";
    public static final String ZRNBIKOU7                = "zrnbikou7";
    public static final String ZRNTEKIYOU8              = "zrntekiyou8";
    public static final String ZRNSHRKNGKMEISAIHUGOU8   = "zrnshrkngkmeisaihugou8";
    public static final String ZRNSHRGKMEISAI8          = "zrnshrgkmeisai8";
    public static final String ZRNSHRGKTUUKASYU8        = "zrnshrgktuukasyu8";
    public static final String ZRNBIKOU8                = "zrnbikou8";
    public static final String ZRNTEKIYOU9              = "zrntekiyou9";
    public static final String ZRNSHRKNGKMEISAIHUGOU9   = "zrnshrkngkmeisaihugou9";
    public static final String ZRNSHRGKMEISAI9          = "zrnshrgkmeisai9";
    public static final String ZRNSHRGKTUUKASYU9        = "zrnshrgktuukasyu9";
    public static final String ZRNBIKOU9                = "zrnbikou9";
    public static final String ZRNTEKIYOU10             = "zrntekiyou10";
    public static final String ZRNSHRKNGKMEISAIHUGOU10  = "zrnshrkngkmeisaihugou10";
    public static final String ZRNSHRGKMEISAI10         = "zrnshrgkmeisai10";
    public static final String ZRNSHRGKTUUKASYU10       = "zrnshrgktuukasyu10";
    public static final String ZRNBIKOU10               = "zrnbikou10";
    public static final String ZRNSHRGKGOUKEI           = "zrnshrgkgoukei";
    public static final String ZRNSHRTUUKASYU           = "zrnshrtuukasyu";
    public static final String ZRNDSEISANSHRTTDKNM      = "zrndseisanshrttdknm";
    public static final String ZRNYOBIV26X3             = "zrnyobiv26x3";
    public static final String ZRNBANKNMKJ              = "zrnbanknmkj";
    public static final String ZRNSITENNMKJ             = "zrnsitennmkj";
    public static final String ZRNYOKINKBN              = "zrnyokinkbn";
    public static final String ZRNKOUZANO12KETA         = "zrnkouzano12keta";
    public static final String ZRNKZMEIGINMKNHAN        = "zrnkzmeiginmknhan";
    public static final String ZRNKOUZASYURUIKBN        = "zrnkouzasyuruikbn";
    public static final String ZRNYOBIV26X2             = "zrnyobiv26x2";
    public static final String ZRNSYNYKNGK              = "zrnsynykngk";
    public static final String ZRNSYNYKNGKTUUKASYU      = "zrnsynykngktuukasyu";
    public static final String ZRNHTYKEIHI              = "zrnhtykeihi";
    public static final String ZRNHTYKEIHITUUKASYU      = "zrnhtykeihituukasyu";
    public static final String ZRNSHRKYKSYAHTYKEIHI     = "zrnshrkyksyahtykeihi";
    public static final String ZRNSHRKYKHTYKEIHITUUKASYU = "zrnshrkykhtykeihituukasyu";
    public static final String ZRNGSBNRKZTHTYKEIHI      = "zrngsbnrkzthtykeihi";
    public static final String ZRNGSBNRKZTHTYKEIHITUKSYU = "zrngsbnrkzthtykeihituksyu";
    public static final String ZRNGSBNRKZTSAEKI         = "zrngsbnrkztsaeki";
    public static final String ZRNGSBNRKZTSAEKITUKSYU   = "zrngsbnrkztsaekituksyu";
    public static final String ZRNZEIMUNAIYOUHENSYUCTRLKBN = "zrnzeimunaiyouhensyuctrlkbn";
    public static final String ZRNZEIMUMONGONOUTKBN     = "zrnzeimumongonoutkbn";
    public static final String ZRNZEIMUMONGON1          = "zrnzeimumongon1";
    public static final String ZRNZEIMUMONGON2          = "zrnzeimumongon2";
    public static final String ZRNZEIMUMONGON3          = "zrnzeimumongon3";
    public static final String ZRNZEIMUMONGON4          = "zrnzeimumongon4";
    public static final String ZRNZEIMUMONGON5          = "zrnzeimumongon5";
    public static final String ZRNYENDTHNKZEIMUINFOHSKKBN = "zrnyendthnkzeimuinfohskkbn";
    public static final String ZRNYOBIV36               = "zrnyobiv36";
    public static final String ZRNOSIRASEHYOUDAI        = "zrnosirasehyoudai";
    public static final String ZRNOSIRASEMONGON1        = "zrnosirasemongon1";
    public static final String ZRNOSIRASEMONGON2        = "zrnosirasemongon2";
    public static final String ZRNOSIRASEMONGON3        = "zrnosirasemongon3";
    public static final String ZRNOSIRASEMONGON4        = "zrnosirasemongon4";
    public static final String ZRNOSIRASEMONGON5        = "zrnosirasemongon5";
    public static final String ZRNOSIRASEMONGON6        = "zrnosirasemongon6";
    public static final String ZRNOSIRASEMONGON7        = "zrnosirasemongon7";
    public static final String ZRNOSIRASEMONGON8        = "zrnosirasemongon8";
    public static final String ZRNOSIRASEMONGON9        = "zrnosirasemongon9";
    public static final String ZRNOSIRASEMONGON10       = "zrnosirasemongon10";
    public static final String ZRNOSIRASEMONGON11       = "zrnosirasemongon11";
    public static final String ZRNOSIRASEMONGON12       = "zrnosirasemongon12";
    public static final String ZRNOSIRASEMONGON13       = "zrnosirasemongon13";
    public static final String ZRNOSIRASEMONGON14       = "zrnosirasemongon14";
    public static final String ZRNOSIRASEMONGON15       = "zrnosirasemongon15";
    public static final String ZRNOSIRASEMONGON16       = "zrnosirasemongon16";
    public static final String ZRNOSIRASEMONGON17       = "zrnosirasemongon17";
    public static final String ZRNOSIRASEMONGON18       = "zrnosirasemongon18";
    public static final String ZRNOSIRASEMONGON19       = "zrnosirasemongon19";
    public static final String ZRNOSIRASEMONGON20       = "zrnosirasemongon20";
    public static final String ZRNOSIRASEMONGON21       = "zrnosirasemongon21";
    public static final String ZRNOSIRASEMONGON22       = "zrnosirasemongon22";
    public static final String ZRNOSIRASEMONGON23       = "zrnosirasemongon23";
    public static final String ZRNOSIRASEMONGON24       = "zrnosirasemongon24";
    public static final String ZRNOSIRASEMONGON25       = "zrnosirasemongon25";
    public static final String ZRNOSIRASEMONGON26       = "zrnosirasemongon26";
    public static final String ZRNOSIRASEMONGON27       = "zrnosirasemongon27";
    public static final String ZRNOSIRASEMONGON28       = "zrnosirasemongon28";
    public static final String ZRNOSIRASEMONGON29       = "zrnosirasemongon29";
    public static final String ZRNOSIRASEMONGON30       = "zrnosirasemongon30";
    public static final String ZRNOSIRASEMONGON31       = "zrnosirasemongon31";
    public static final String ZRNOSIRASEMONGON32       = "zrnosirasemongon32";
    public static final String ZRNOSIRASEMONGON33       = "zrnosirasemongon33";
    public static final String ZRNOSIRASEMONGON34       = "zrnosirasemongon34";
    public static final String ZRNOSIRASEMONGON35       = "zrnosirasemongon35";
    public static final String ZRNOSIRASEMONGON36       = "zrnosirasemongon36";
    public static final String ZRNOSIRASEMONGON37       = "zrnosirasemongon37";
    public static final String ZRNOSIRASEMONGON38       = "zrnosirasemongon38";
    public static final String ZRNOSIRASEMONGON39       = "zrnosirasemongon39";
    public static final String ZRNOSIRASEMONGON40       = "zrnosirasemongon40";
    public static final String ZRNOSIRASEMONGON41       = "zrnosirasemongon41";
    public static final String ZRNOSIRASEMONGON42       = "zrnosirasemongon42";
    public static final String ZRNOSIRASEMONGON43       = "zrnosirasemongon43";
    public static final String ZRNOSIRASEMONGON44       = "zrnosirasemongon44";
    public static final String ZRNOSIRASEMONGON45       = "zrnosirasemongon45";
    public static final String ZRNOSIRASEMONGON46       = "zrnosirasemongon46";
    public static final String ZRNOSIRASEMONGON47       = "zrnosirasemongon47";
    public static final String ZRNOSIRASEMONGON48       = "zrnosirasemongon48";
    public static final String ZRNOSIRASEMONGON49       = "zrnosirasemongon49";
    public static final String ZRNOSIRASEMONGON50       = "zrnosirasemongon50";
    public static final String ZRNOSIRASEINJIHUYOUHYOUJI = "zrnosiraseinjihuyouhyouji";
    public static final String ZRNYOBIV254              = "zrnyobiv254";
    public static final String ZRNSHRNAIYOUHSKMONGON1   = "zrnshrnaiyouhskmongon1";
    public static final String ZRNSHRNAIYOUHSKMONGON2   = "zrnshrnaiyouhskmongon2";
    public static final String ZRNDOCUMENTID            = "zrndocumentid";
    public static final String ZRNSKSMONGONKBN1         = "zrnsksmongonkbn1";
    public static final String ZRNSKSMONGONKBN2         = "zrnsksmongonkbn2";
    public static final String ZRNTORITUGISYASYOZOKUNM  = "zrntoritugisyasyozokunm";
    public static final String ZRNTORITUGISYAKJNCD      = "zrntoritugisyakjncd";
    public static final String ZRNTORITUGISYANM         = "zrntoritugisyanm";
    public static final String ZRNHOZONKKNY             = "zrnhozonkkny";
    public static final String ZRNTSINTELNO             = "zrntsintelno";
    public static final String ZRNYOBIV141              = "zrnyobiv141";
    public static final String ZRNTRKKZKKBN1            = "zrntrkkzkkbn1";
    public static final String ZRNTRKKZKNMKJ1           = "zrntrkkzknmkj1";
    public static final String ZRNTRKKZKSEIYMD1ZENKAKU  = "zrntrkkzkseiymd1zenkaku";
    public static final String ZRNTRKKZKYNO1            = "zrntrkkzkyno1";
    public static final String ZRNTRKKZKADR1KJ1         = "zrntrkkzkadr1kj1";
    public static final String ZRNTRKKZKADR2KJ1         = "zrntrkkzkadr2kj1";
    public static final String ZRNTRKKZKADR3KJ1         = "zrntrkkzkadr3kj1";
    public static final String ZRNTRKKZKTELNO1          = "zrntrkkzktelno1";
    public static final String ZRNTRKKZKTELNOMTRKHYOUJI1 = "zrntrkkzktelnomtrkhyouji1";
    public static final String ZRNTRKKZKKBN2            = "zrntrkkzkkbn2";
    public static final String ZRNTRKKZKNMKJ2           = "zrntrkkzknmkj2";
    public static final String ZRNTRKKZKSEIYMD2ZENKAKU  = "zrntrkkzkseiymd2zenkaku";
    public static final String ZRNTRKKZKYNO2            = "zrntrkkzkyno2";
    public static final String ZRNTRKKZKADR1KJ2         = "zrntrkkzkadr1kj2";
    public static final String ZRNTRKKZKADR2KJ2         = "zrntrkkzkadr2kj2";
    public static final String ZRNTRKKZKADR3KJ2         = "zrntrkkzkadr3kj2";
    public static final String ZRNTRKKZKTELNO2          = "zrntrkkzktelno2";
    public static final String ZRNKYKDAIRINMKJ          = "zrnkykdairinmkj";
    public static final String ZRNKYKOMTTUTKBN          = "zrnkykomttutkbn";
    public static final String ZRNKZKOMTTUTKBN1         = "zrnkzkomttutkbn1";
    public static final String ZRNKZKOMTTUTKBN2         = "zrnkzkomttutkbn2";
    public static final String ZRNHHKOMTTUTKBN          = "zrnhhkomttutkbn";
    public static final String ZRNHHKDROMTTUTKBN        = "zrnhhkdromttutkbn";
    public static final String ZRNKYKDAIRIOMTTUTKBN     = "zrnkykdairiomttutkbn";
    public static final String ZRNKYKURTUTKBN           = "zrnkykurtutkbn";
    public static final String ZRNKZKURTUTKBN1          = "zrnkzkurtutkbn1";
    public static final String ZRNKZKURTUTKBN2          = "zrnkzkurtutkbn2";
    public static final String ZRNHHKDRURTUTKBN         = "zrnhhkdrurtutkbn";
    public static final String ZRNKYKDAIRIURTUTKBN      = "zrnkykdairiurtutkbn";
    public static final String ZRNKYKAISTMSGKBN         = "zrnkykaistmsgkbn";
    public static final String ZRNKZKAISTMSGKBN1        = "zrnkzkaistmsgkbn1";
    public static final String ZRNKZKAISTMSGKBN2        = "zrnkzkaistmsgkbn2";
    public static final String ZRNHHKAISTMSGKBN         = "zrnhhkaistmsgkbn";
    public static final String ZRNHHKDRAISTMSGKBN       = "zrnhhkdraistmsgkbn";
    public static final String ZRNKYKDAIRIAISTMSGKBN    = "zrnkykdairiaistmsgkbn";
    public static final String ZRNSAKUJYOKZKNMKJ        = "zrnsakujyokzknmkj";
    public static final String ZRNTTDKNAIYOUKBN         = "zrnttdknaiyoukbn";
    public static final String ZRNKZKTAISYOUKYKKBN      = "zrnkzktaisyoukykkbn";
    public static final String ZRNHHKDRTAISYOUKYKKBN    = "zrnhhkdrtaisyoukykkbn";
    public static final String ZRNKYKDAIRITAISYOUKYKKBN = "zrnkykdairitaisyoukykkbn";
    public static final String ZRNMOSHNKNIYMSGKBN1      = "zrnmoshnkniymsgkbn1";
    public static final String ZRNKYKMOSHNKNIYMSG2      = "zrnkykmoshnkniymsg2";
    public static final String ZRNKZKMOSHNKNIYMSG21     = "zrnkzkmoshnkniymsg21";
    public static final String ZRNKZKMOSHNKNIYMSG22     = "zrnkzkmoshnkniymsg22";
    public static final String ZRNHHKDRMOSHNKNIYMSG2    = "zrnhhkdrmoshnkniymsg2";
    public static final String ZRNKYKDAIRIMOSHNKNIYMSG2 = "zrnkykdairimoshnkniymsg2";
    public static final String ZRNKYKDRMSGKBN           = "zrnkykdrmsgkbn";
    public static final String ZRNKYKHHKDRMSG           = "zrnkykhhkdrmsg";
    public static final String ZRNKZKHHKDRMSG1          = "zrnkzkhhkdrmsg1";
    public static final String ZRNKZKHHKDRMSG2          = "zrnkzkhhkdrmsg2";
    public static final String ZRNHHKDRNMKJ             = "zrnhhkdrnmkj";
    public static final String ZRNDUHUBUTUMSG1          = "zrnduhubutumsg1";
    public static final String ZRNDUHUBUTUMSG2          = "zrnduhubutumsg2";
    public static final String ZRNDUHUBUTUMSG3          = "zrnduhubutumsg3";
    public static final String ZRNDUHUBUTUMSG4          = "zrnduhubutumsg4";
    public static final String ZRNDUHUBUTUMSG5          = "zrnduhubutumsg5";
    public static final String ZRNDUHUBUTUMSG6          = "zrnduhubutumsg6";
    public static final String ZRNDUHUBUTUMSG7          = "zrnduhubutumsg7";
    public static final String ZRNKYKIGAIDHBTMSG1       = "zrnkykigaidhbtmsg1";
    public static final String ZRNKYKIGAIDHBTMSG2       = "zrnkykigaidhbtmsg2";
    public static final String ZRNKYKIGAIDHBTMSG3       = "zrnkykigaidhbtmsg3";
    public static final String ZRNKYKIGAIDHBTMSG4       = "zrnkykigaidhbtmsg4";
    public static final String ZRNYAKKANKIYAKUHUNYUUHYOUJI = "zrnyakkankiyakuhunyuuhyouji";
    public static final String ZRNKYKTRKTRSHUUNYUUHYOUJI = "zrnkyktrktrshuunyuuhyouji";
    public static final String ZRNKZKTRKTRSHUUNYUUHYOUJI1 = "zrnkzktrktrshuunyuuhyouji1";
    public static final String ZRNKZKTRKTRSHUUNYUUHYOUJI2 = "zrnkzktrktrshuunyuuhyouji2";
    public static final String ZRNKYKDRHUUNYUUHYOUJI    = "zrnkykdrhuunyuuhyouji";
    public static final String ZRNHHKDRHUUNYUUHYOUJI    = "zrnhhkdrhuunyuuhyouji";
    public static final String ZRNKYKDAIRINMKJ2         = "zrnkykdairinmkj2";
    public static final String ZRNKYKDRSEIYMD           = "zrnkykdrseiymd";
    public static final String ZRNKYKDRYNO              = "zrnkykdryno";
    public static final String ZRNKYKDRADR1KJ           = "zrnkykdradr1kj";
    public static final String ZRNKYKDRADR2KJ           = "zrnkykdradr2kj";
    public static final String ZRNKYKDRADR3KJ           = "zrnkykdradr3kj";
    public static final String ZRNKYKDRTELNO            = "zrnkykdrtelno";
    public static final String ZRNHHKDRNMKJ2            = "zrnhhkdrnmkj2";
    public static final String ZRNHHKDRSEIYMD           = "zrnhhkdrseiymd";
    public static final String ZRNHHKDRYNO              = "zrnhhkdryno";
    public static final String ZRNHHKDRADR1KJ           = "zrnhhkdradr1kj";
    public static final String ZRNHHKDRADR2KJ           = "zrnhhkdradr2kj";
    public static final String ZRNHHKDRADR3KJ           = "zrnhhkdradr3kj";
    public static final String ZRNHHKDRTELNO            = "zrnhhkdrtelno";
    public static final String ZRNHHKDRTELNOMTRKHYOUJI  = "zrnhhkdrtelnomtrkhyouji";
    public static final String ZRNKHSYONO2              = "zrnkhsyono2";
    public static final String ZRNKHSYONO3              = "zrnkhsyono3";
    public static final String ZRNKHSYONO4              = "zrnkhsyono4";
    public static final String ZRNKHSYONO5              = "zrnkhsyono5";
    public static final String ZRNKHSYONO6              = "zrnkhsyono6";
    public static final String ZRNKHSYONO7              = "zrnkhsyono7";
    public static final String ZRNKHSYONO8              = "zrnkhsyono8";
    public static final String ZRNKHSYONO9              = "zrnkhsyono9";
    public static final String ZRNKHSYONO10             = "zrnkhsyono10";
    public static final String ZRNKHMOSNO1              = "zrnkhmosno1";
    public static final String ZRNKHMOSNO2              = "zrnkhmosno2";
    public static final String ZRNKHMOSNO3              = "zrnkhmosno3";
    public static final String ZRNKHMOSNO4              = "zrnkhmosno4";
    public static final String ZRNKHMOSNO5              = "zrnkhmosno5";
    public static final String ZRNKHMOSNO6              = "zrnkhmosno6";
    public static final String ZRNKHMOSNO7              = "zrnkhmosno7";
    public static final String ZRNKHMOSNO8              = "zrnkhmosno8";
    public static final String ZRNKHMOSNO9              = "zrnkhmosno9";
    public static final String ZRNKHMOSNO10             = "zrnkhmosno10";
    public static final String ZRNHNSNHUTOUHUUNYUUHYOUJI = "zrnhnsnhutouhuunyuuhyouji";
    public static final String ZRNYOBIV204              = "zrnyobiv204";
    public static final String ZRNYOBIV255X2            = "zrnyobiv255x2";
    public static final String ZRNYOBIV255X3            = "zrnyobiv255x3";
    public static final String ZRNYOBIV255X4            = "zrnyobiv255x4";

    private final PKZT_TtdkKanRn primaryKey;

    public GenZT_TtdkKanRn() {
        primaryKey = new PKZT_TtdkKanRn();
    }

    public GenZT_TtdkKanRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsikibetuno
    ) {
        primaryKey = new PKZT_TtdkKanRn(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_TtdkKanRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TtdkKanRn> getMetaClass() {
        return QZT_TtdkKanRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_TtdkKanRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_TtdkKanRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    private String zrntyouhyouymdwa;

    @Column(name=GenZT_TtdkKanRn.ZRNTYOUHYOUYMDWA)
    public String getZrntyouhyouymdwa() {
        return zrntyouhyouymdwa;
    }

    @DataConvert("toMultiByte")
    public void setZrntyouhyouymdwa(String pZrntyouhyouymdwa) {
        zrntyouhyouymdwa = pZrntyouhyouymdwa;
    }

    @Id
    @Column(name=GenZT_TtdkKanRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_TtdkKanRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrntantousitukbn;

    @Column(name=GenZT_TtdkKanRn.ZRNTANTOUSITUKBN)
    public String getZrntantousitukbn() {
        return zrntantousitukbn;
    }

    public void setZrntantousitukbn(String pZrntantousitukbn) {
        zrntantousitukbn = pZrntantousitukbn;
    }

    private String zrnsyodouhuukbn;

    @Column(name=GenZT_TtdkKanRn.ZRNSYODOUHUUKBN)
    public String getZrnsyodouhuukbn() {
        return zrnsyodouhuukbn;
    }

    public void setZrnsyodouhuukbn(String pZrnsyodouhuukbn) {
        zrnsyodouhuukbn = pZrnsyodouhuukbn;
    }

    @Id
    @Column(name=GenZT_TtdkKanRn.ZRNSIKIBETUNO)
    public String getZrnsikibetuno() {
        return getPrimaryKey().getZrnsikibetuno();
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        getPrimaryKey().setZrnsikibetuno(pZrnsikibetuno);
    }

    private String zrnyobiv21;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV21)
    public String getZrnyobiv21() {
        return zrnyobiv21;
    }

    public void setZrnyobiv21(String pZrnyobiv21) {
        zrnyobiv21 = pZrnyobiv21;
    }

    private String zrnshskyno;

    @Column(name=GenZT_TtdkKanRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_TtdkKanRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_TtdkKanRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_TtdkKanRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkjttdk;

    @Column(name=GenZT_TtdkKanRn.ZRNSHSNMKJTTDK)
    public String getZrnshsnmkjttdk() {
        return zrnshsnmkjttdk;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkjttdk(String pZrnshsnmkjttdk) {
        zrnshsnmkjttdk = pZrnshsnmkjttdk;
    }

    private String zrnshsnmkjttdk2;

    @Column(name=GenZT_TtdkKanRn.ZRNSHSNMKJTTDK2)
    public String getZrnshsnmkjttdk2() {
        return zrnshsnmkjttdk2;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkjttdk2(String pZrnshsnmkjttdk2) {
        zrnshsnmkjttdk2 = pZrnshsnmkjttdk2;
    }

    private String zrnyobiv3;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }

    private String zrntawyno;

    @Column(name=GenZT_TtdkKanRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_TtdkKanRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_TtdkKanRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntoiawasekaisyanmkj;

    @Column(name=GenZT_TtdkKanRn.ZRNTOIAWASEKAISYANMKJ)
    public String getZrntoiawasekaisyanmkj() {
        return zrntoiawasekaisyanmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrntoiawasekaisyanmkj(String pZrntoiawasekaisyanmkj) {
        zrntoiawasekaisyanmkj = pZrntoiawasekaisyanmkj;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_TtdkKanRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawtelnov14;

    @Column(name=GenZT_TtdkKanRn.ZRNTAWTELNOV14)
    public String getZrntawtelnov14() {
        return zrntawtelnov14;
    }

    public void setZrntawtelnov14(String pZrntawtelnov14) {
        zrntawtelnov14 = pZrntawtelnov14;
    }

    private String zrntawteluktkkanou1x18keta;

    @Column(name=GenZT_TtdkKanRn.ZRNTAWTELUKTKKANOU1X18KETA)
    public String getZrntawteluktkkanou1x18keta() {
        return zrntawteluktkkanou1x18keta;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1x18keta(String pZrntawteluktkkanou1x18keta) {
        zrntawteluktkkanou1x18keta = pZrntawteluktkkanou1x18keta;
    }

    private String zrntawteluktkkanou2x18keta;

    @Column(name=GenZT_TtdkKanRn.ZRNTAWTELUKTKKANOU2X18KETA)
    public String getZrntawteluktkkanou2x18keta() {
        return zrntawteluktkkanou2x18keta;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2x18keta(String pZrntawteluktkkanou2x18keta) {
        zrntawteluktkkanou2x18keta = pZrntawteluktkkanou2x18keta;
    }

    private String zrnyobiv26;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV26)
    public String getZrnyobiv26() {
        return zrnyobiv26;
    }

    public void setZrnyobiv26(String pZrnyobiv26) {
        zrnyobiv26 = pZrnyobiv26;
    }

    private String zrntetudukisyunm;

    @Column(name=GenZT_TtdkKanRn.ZRNTETUDUKISYUNM)
    public String getZrntetudukisyunm() {
        return zrntetudukisyunm;
    }

    @DataConvert("toMultiByte")
    public void setZrntetudukisyunm(String pZrntetudukisyunm) {
        zrntetudukisyunm = pZrntetudukisyunm;
    }

    private String zrnsyokakmngnumkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNSYOKAKMNGNUMKBN)
    public String getZrnsyokakmngnumkbn() {
        return zrnsyokakmngnumkbn;
    }

    public void setZrnsyokakmngnumkbn(String pZrnsyokakmngnumkbn) {
        zrnsyokakmngnumkbn = pZrnsyokakmngnumkbn;
    }

    private String zrnsyono2;

    @Column(name=GenZT_TtdkKanRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnkyknmkj;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKNMKJ)
    public String getZrnkyknmkj() {
        return zrnkyknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj(String pZrnkyknmkj) {
        zrnkyknmkj = pZrnkyknmkj;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnyobiv28;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV28)
    public String getZrnyobiv28() {
        return zrnyobiv28;
    }

    public void setZrnyobiv28(String pZrnyobiv28) {
        zrnyobiv28 = pZrnyobiv28;
    }

    private String zrnttdknaiyou1;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOU1)
    public String getZrnttdknaiyou1() {
        return zrnttdknaiyou1;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdknaiyou1(String pZrnttdknaiyou1) {
        zrnttdknaiyou1 = pZrnttdknaiyou1;
    }

    private String zrnttdknaiyou2;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOU2)
    public String getZrnttdknaiyou2() {
        return zrnttdknaiyou2;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdknaiyou2(String pZrnttdknaiyou2) {
        zrnttdknaiyou2 = pZrnttdknaiyou2;
    }

    private String zrnttdknaiyou3;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOU3)
    public String getZrnttdknaiyou3() {
        return zrnttdknaiyou3;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdknaiyou3(String pZrnttdknaiyou3) {
        zrnttdknaiyou3 = pZrnttdknaiyou3;
    }

    private String zrnttdknaiyou4;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOU4)
    public String getZrnttdknaiyou4() {
        return zrnttdknaiyou4;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdknaiyou4(String pZrnttdknaiyou4) {
        zrnttdknaiyou4 = pZrnttdknaiyou4;
    }

    private String zrnttdknaiyou5;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOU5)
    public String getZrnttdknaiyou5() {
        return zrnttdknaiyou5;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdknaiyou5(String pZrnttdknaiyou5) {
        zrnttdknaiyou5 = pZrnttdknaiyou5;
    }

    private String zrnttdknaiyou6;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOU6)
    public String getZrnttdknaiyou6() {
        return zrnttdknaiyou6;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdknaiyou6(String pZrnttdknaiyou6) {
        zrnttdknaiyou6 = pZrnttdknaiyou6;
    }

    private String zrnttdknaiyou7;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOU7)
    public String getZrnttdknaiyou7() {
        return zrnttdknaiyou7;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdknaiyou7(String pZrnttdknaiyou7) {
        zrnttdknaiyou7 = pZrnttdknaiyou7;
    }

    private String zrnttdknaiyou8;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOU8)
    public String getZrnttdknaiyou8() {
        return zrnttdknaiyou8;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdknaiyou8(String pZrnttdknaiyou8) {
        zrnttdknaiyou8 = pZrnttdknaiyou8;
    }

    private String zrnttdknaiyou9;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOU9)
    public String getZrnttdknaiyou9() {
        return zrnttdknaiyou9;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdknaiyou9(String pZrnttdknaiyou9) {
        zrnttdknaiyou9 = pZrnttdknaiyou9;
    }

    private String zrnttdknaiyou10;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOU10)
    public String getZrnttdknaiyou10() {
        return zrnttdknaiyou10;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdknaiyou10(String pZrnttdknaiyou10) {
        zrnttdknaiyou10 = pZrnttdknaiyou10;
    }

    private String zrnttdknaiyouumukbn;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOUUMUKBN)
    public String getZrnttdknaiyouumukbn() {
        return zrnttdknaiyouumukbn;
    }

    public void setZrnttdknaiyouumukbn(String pZrnttdknaiyouumukbn) {
        zrnttdknaiyouumukbn = pZrnttdknaiyouumukbn;
    }

    private String zrnkykniyuhnkkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKNIYUHNKKBN)
    public String getZrnkykniyuhnkkbn() {
        return zrnkykniyuhnkkbn;
    }

    public void setZrnkykniyuhnkkbn(String pZrnkykniyuhnkkbn) {
        zrnkykniyuhnkkbn = pZrnkykniyuhnkkbn;
    }

    private String zrnkykniyuhnkymd;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKNIYUHNKYMD)
    public String getZrnkykniyuhnkymd() {
        return zrnkykniyuhnkymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykniyuhnkymd(String pZrnkykniyuhnkymd) {
        zrnkykniyuhnkymd = pZrnkykniyuhnkymd;
    }

    private String zrnkykniyuhnkinfo;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKNIYUHNKINFO)
    public String getZrnkykniyuhnkinfo() {
        return zrnkykniyuhnkinfo;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykniyuhnkinfo(String pZrnkykniyuhnkinfo) {
        zrnkykniyuhnkinfo = pZrnkykniyuhnkinfo;
    }

    private String zrnkykniyuhnkkngkhugou1;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKNIYUHNKKNGKHUGOU1)
    public String getZrnkykniyuhnkkngkhugou1() {
        return zrnkykniyuhnkkngkhugou1;
    }

    public void setZrnkykniyuhnkkngkhugou1(String pZrnkykniyuhnkkngkhugou1) {
        zrnkykniyuhnkkngkhugou1 = pZrnkykniyuhnkkngkhugou1;
    }

    private String zrnkykniyuhnkkngk1;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKNIYUHNKKNGK1)
    public String getZrnkykniyuhnkkngk1() {
        return zrnkykniyuhnkkngk1;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkykniyuhnkkngk1(String pZrnkykniyuhnkkngk1) {
        zrnkykniyuhnkkngk1 = pZrnkykniyuhnkkngk1;
    }

    private String zrnkykniyuhnkkngktuksyu1;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKNIYUHNKKNGKTUKSYU1)
    public String getZrnkykniyuhnkkngktuksyu1() {
        return zrnkykniyuhnkkngktuksyu1;
    }

    public void setZrnkykniyuhnkkngktuksyu1(String pZrnkykniyuhnkkngktuksyu1) {
        zrnkykniyuhnkkngktuksyu1 = pZrnkykniyuhnkkngktuksyu1;
    }

    private String zrnkykniyuhnkkngkhugou2;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKNIYUHNKKNGKHUGOU2)
    public String getZrnkykniyuhnkkngkhugou2() {
        return zrnkykniyuhnkkngkhugou2;
    }

    public void setZrnkykniyuhnkkngkhugou2(String pZrnkykniyuhnkkngkhugou2) {
        zrnkykniyuhnkkngkhugou2 = pZrnkykniyuhnkkngkhugou2;
    }

    private String zrnkykniyuhnkkngk2;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKNIYUHNKKNGK2)
    public String getZrnkykniyuhnkkngk2() {
        return zrnkykniyuhnkkngk2;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkykniyuhnkkngk2(String pZrnkykniyuhnkkngk2) {
        zrnkykniyuhnkkngk2 = pZrnkykniyuhnkkngk2;
    }

    private String zrnkykniyuhnkkngktuksyu2;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKNIYUHNKKNGKTUKSYU2)
    public String getZrnkykniyuhnkkngktuksyu2() {
        return zrnkykniyuhnkkngktuksyu2;
    }

    public void setZrnkykniyuhnkkngktuksyu2(String pZrnkykniyuhnkkngktuksyu2) {
        zrnkykniyuhnkkngktuksyu2 = pZrnkykniyuhnkkngktuksyu2;
    }

    private String zrnyobiv102;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV102)
    public String getZrnyobiv102() {
        return zrnyobiv102;
    }

    public void setZrnyobiv102(String pZrnyobiv102) {
        zrnyobiv102 = pZrnyobiv102;
    }

    private String zrnsiharaibiwareki;

    @Column(name=GenZT_TtdkKanRn.ZRNSIHARAIBIWAREKI)
    public String getZrnsiharaibiwareki() {
        return zrnsiharaibiwareki;
    }

    @DataConvert("toMultiByte")
    public void setZrnsiharaibiwareki(String pZrnsiharaibiwareki) {
        zrnsiharaibiwareki = pZrnsiharaibiwareki;
    }

    private String zrnkaiyakuymdwa;

    @Column(name=GenZT_TtdkKanRn.ZRNKAIYAKUYMDWA)
    public String getZrnkaiyakuymdwa() {
        return zrnkaiyakuymdwa;
    }

    @DataConvert("toMultiByte")
    public void setZrnkaiyakuymdwa(String pZrnkaiyakuymdwa) {
        zrnkaiyakuymdwa = pZrnkaiyakuymdwa;
    }

    private String zrntekiyou1;

    @Column(name=GenZT_TtdkKanRn.ZRNTEKIYOU1)
    public String getZrntekiyou1() {
        return zrntekiyou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou1(String pZrntekiyou1) {
        zrntekiyou1 = pZrntekiyou1;
    }

    private String zrnshrkngkmeisaihugou1;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKNGKMEISAIHUGOU1)
    public String getZrnshrkngkmeisaihugou1() {
        return zrnshrkngkmeisaihugou1;
    }

    public void setZrnshrkngkmeisaihugou1(String pZrnshrkngkmeisaihugou1) {
        zrnshrkngkmeisaihugou1 = pZrnshrkngkmeisaihugou1;
    }

    private String zrnshrgkmeisai1;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKMEISAI1)
    public String getZrnshrgkmeisai1() {
        return zrnshrgkmeisai1;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai1(String pZrnshrgkmeisai1) {
        zrnshrgkmeisai1 = pZrnshrgkmeisai1;
    }

    private String zrnshrgktuukasyu1;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKTUUKASYU1)
    public String getZrnshrgktuukasyu1() {
        return zrnshrgktuukasyu1;
    }

    public void setZrnshrgktuukasyu1(String pZrnshrgktuukasyu1) {
        zrnshrgktuukasyu1 = pZrnshrgktuukasyu1;
    }

    private String zrnbikou1;

    @Column(name=GenZT_TtdkKanRn.ZRNBIKOU1)
    public String getZrnbikou1() {
        return zrnbikou1;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou1(String pZrnbikou1) {
        zrnbikou1 = pZrnbikou1;
    }

    private String zrntekiyou2;

    @Column(name=GenZT_TtdkKanRn.ZRNTEKIYOU2)
    public String getZrntekiyou2() {
        return zrntekiyou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou2(String pZrntekiyou2) {
        zrntekiyou2 = pZrntekiyou2;
    }

    private String zrnshrkngkmeisaihugou2;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKNGKMEISAIHUGOU2)
    public String getZrnshrkngkmeisaihugou2() {
        return zrnshrkngkmeisaihugou2;
    }

    public void setZrnshrkngkmeisaihugou2(String pZrnshrkngkmeisaihugou2) {
        zrnshrkngkmeisaihugou2 = pZrnshrkngkmeisaihugou2;
    }

    private String zrnshrgkmeisai2;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKMEISAI2)
    public String getZrnshrgkmeisai2() {
        return zrnshrgkmeisai2;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai2(String pZrnshrgkmeisai2) {
        zrnshrgkmeisai2 = pZrnshrgkmeisai2;
    }

    private String zrnshrgktuukasyu2;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKTUUKASYU2)
    public String getZrnshrgktuukasyu2() {
        return zrnshrgktuukasyu2;
    }

    public void setZrnshrgktuukasyu2(String pZrnshrgktuukasyu2) {
        zrnshrgktuukasyu2 = pZrnshrgktuukasyu2;
    }

    private String zrnbikou2;

    @Column(name=GenZT_TtdkKanRn.ZRNBIKOU2)
    public String getZrnbikou2() {
        return zrnbikou2;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou2(String pZrnbikou2) {
        zrnbikou2 = pZrnbikou2;
    }

    private String zrntekiyou3;

    @Column(name=GenZT_TtdkKanRn.ZRNTEKIYOU3)
    public String getZrntekiyou3() {
        return zrntekiyou3;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou3(String pZrntekiyou3) {
        zrntekiyou3 = pZrntekiyou3;
    }

    private String zrnshrkngkmeisaihugou3;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKNGKMEISAIHUGOU3)
    public String getZrnshrkngkmeisaihugou3() {
        return zrnshrkngkmeisaihugou3;
    }

    public void setZrnshrkngkmeisaihugou3(String pZrnshrkngkmeisaihugou3) {
        zrnshrkngkmeisaihugou3 = pZrnshrkngkmeisaihugou3;
    }

    private String zrnshrgkmeisai3;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKMEISAI3)
    public String getZrnshrgkmeisai3() {
        return zrnshrgkmeisai3;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai3(String pZrnshrgkmeisai3) {
        zrnshrgkmeisai3 = pZrnshrgkmeisai3;
    }

    private String zrnshrgktuukasyu3;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKTUUKASYU3)
    public String getZrnshrgktuukasyu3() {
        return zrnshrgktuukasyu3;
    }

    public void setZrnshrgktuukasyu3(String pZrnshrgktuukasyu3) {
        zrnshrgktuukasyu3 = pZrnshrgktuukasyu3;
    }

    private String zrnbikou3;

    @Column(name=GenZT_TtdkKanRn.ZRNBIKOU3)
    public String getZrnbikou3() {
        return zrnbikou3;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou3(String pZrnbikou3) {
        zrnbikou3 = pZrnbikou3;
    }

    private String zrntekiyou4;

    @Column(name=GenZT_TtdkKanRn.ZRNTEKIYOU4)
    public String getZrntekiyou4() {
        return zrntekiyou4;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou4(String pZrntekiyou4) {
        zrntekiyou4 = pZrntekiyou4;
    }

    private String zrnshrkngkmeisaihugou4;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKNGKMEISAIHUGOU4)
    public String getZrnshrkngkmeisaihugou4() {
        return zrnshrkngkmeisaihugou4;
    }

    public void setZrnshrkngkmeisaihugou4(String pZrnshrkngkmeisaihugou4) {
        zrnshrkngkmeisaihugou4 = pZrnshrkngkmeisaihugou4;
    }

    private String zrnshrgkmeisai4;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKMEISAI4)
    public String getZrnshrgkmeisai4() {
        return zrnshrgkmeisai4;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai4(String pZrnshrgkmeisai4) {
        zrnshrgkmeisai4 = pZrnshrgkmeisai4;
    }

    private String zrnshrgktuukasyu4;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKTUUKASYU4)
    public String getZrnshrgktuukasyu4() {
        return zrnshrgktuukasyu4;
    }

    public void setZrnshrgktuukasyu4(String pZrnshrgktuukasyu4) {
        zrnshrgktuukasyu4 = pZrnshrgktuukasyu4;
    }

    private String zrnbikou4;

    @Column(name=GenZT_TtdkKanRn.ZRNBIKOU4)
    public String getZrnbikou4() {
        return zrnbikou4;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou4(String pZrnbikou4) {
        zrnbikou4 = pZrnbikou4;
    }

    private String zrntekiyou5;

    @Column(name=GenZT_TtdkKanRn.ZRNTEKIYOU5)
    public String getZrntekiyou5() {
        return zrntekiyou5;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou5(String pZrntekiyou5) {
        zrntekiyou5 = pZrntekiyou5;
    }

    private String zrnshrkngkmeisaihugou5;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKNGKMEISAIHUGOU5)
    public String getZrnshrkngkmeisaihugou5() {
        return zrnshrkngkmeisaihugou5;
    }

    public void setZrnshrkngkmeisaihugou5(String pZrnshrkngkmeisaihugou5) {
        zrnshrkngkmeisaihugou5 = pZrnshrkngkmeisaihugou5;
    }

    private String zrnshrgkmeisai5;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKMEISAI5)
    public String getZrnshrgkmeisai5() {
        return zrnshrgkmeisai5;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai5(String pZrnshrgkmeisai5) {
        zrnshrgkmeisai5 = pZrnshrgkmeisai5;
    }

    private String zrnshrgktuukasyu5;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKTUUKASYU5)
    public String getZrnshrgktuukasyu5() {
        return zrnshrgktuukasyu5;
    }

    public void setZrnshrgktuukasyu5(String pZrnshrgktuukasyu5) {
        zrnshrgktuukasyu5 = pZrnshrgktuukasyu5;
    }

    private String zrnbikou5;

    @Column(name=GenZT_TtdkKanRn.ZRNBIKOU5)
    public String getZrnbikou5() {
        return zrnbikou5;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou5(String pZrnbikou5) {
        zrnbikou5 = pZrnbikou5;
    }

    private String zrntekiyou6;

    @Column(name=GenZT_TtdkKanRn.ZRNTEKIYOU6)
    public String getZrntekiyou6() {
        return zrntekiyou6;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou6(String pZrntekiyou6) {
        zrntekiyou6 = pZrntekiyou6;
    }

    private String zrnshrkngkmeisaihugou6;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKNGKMEISAIHUGOU6)
    public String getZrnshrkngkmeisaihugou6() {
        return zrnshrkngkmeisaihugou6;
    }

    public void setZrnshrkngkmeisaihugou6(String pZrnshrkngkmeisaihugou6) {
        zrnshrkngkmeisaihugou6 = pZrnshrkngkmeisaihugou6;
    }

    private String zrnshrgkmeisai6;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKMEISAI6)
    public String getZrnshrgkmeisai6() {
        return zrnshrgkmeisai6;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai6(String pZrnshrgkmeisai6) {
        zrnshrgkmeisai6 = pZrnshrgkmeisai6;
    }

    private String zrnshrgktuukasyu6;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKTUUKASYU6)
    public String getZrnshrgktuukasyu6() {
        return zrnshrgktuukasyu6;
    }

    public void setZrnshrgktuukasyu6(String pZrnshrgktuukasyu6) {
        zrnshrgktuukasyu6 = pZrnshrgktuukasyu6;
    }

    private String zrnbikou6;

    @Column(name=GenZT_TtdkKanRn.ZRNBIKOU6)
    public String getZrnbikou6() {
        return zrnbikou6;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou6(String pZrnbikou6) {
        zrnbikou6 = pZrnbikou6;
    }

    private String zrntekiyou7;

    @Column(name=GenZT_TtdkKanRn.ZRNTEKIYOU7)
    public String getZrntekiyou7() {
        return zrntekiyou7;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou7(String pZrntekiyou7) {
        zrntekiyou7 = pZrntekiyou7;
    }

    private String zrnshrkngkmeisaihugou7;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKNGKMEISAIHUGOU7)
    public String getZrnshrkngkmeisaihugou7() {
        return zrnshrkngkmeisaihugou7;
    }

    public void setZrnshrkngkmeisaihugou7(String pZrnshrkngkmeisaihugou7) {
        zrnshrkngkmeisaihugou7 = pZrnshrkngkmeisaihugou7;
    }

    private String zrnshrgkmeisai7;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKMEISAI7)
    public String getZrnshrgkmeisai7() {
        return zrnshrgkmeisai7;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai7(String pZrnshrgkmeisai7) {
        zrnshrgkmeisai7 = pZrnshrgkmeisai7;
    }

    private String zrnshrgktuukasyu7;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKTUUKASYU7)
    public String getZrnshrgktuukasyu7() {
        return zrnshrgktuukasyu7;
    }

    public void setZrnshrgktuukasyu7(String pZrnshrgktuukasyu7) {
        zrnshrgktuukasyu7 = pZrnshrgktuukasyu7;
    }

    private String zrnbikou7;

    @Column(name=GenZT_TtdkKanRn.ZRNBIKOU7)
    public String getZrnbikou7() {
        return zrnbikou7;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou7(String pZrnbikou7) {
        zrnbikou7 = pZrnbikou7;
    }

    private String zrntekiyou8;

    @Column(name=GenZT_TtdkKanRn.ZRNTEKIYOU8)
    public String getZrntekiyou8() {
        return zrntekiyou8;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou8(String pZrntekiyou8) {
        zrntekiyou8 = pZrntekiyou8;
    }

    private String zrnshrkngkmeisaihugou8;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKNGKMEISAIHUGOU8)
    public String getZrnshrkngkmeisaihugou8() {
        return zrnshrkngkmeisaihugou8;
    }

    public void setZrnshrkngkmeisaihugou8(String pZrnshrkngkmeisaihugou8) {
        zrnshrkngkmeisaihugou8 = pZrnshrkngkmeisaihugou8;
    }

    private String zrnshrgkmeisai8;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKMEISAI8)
    public String getZrnshrgkmeisai8() {
        return zrnshrgkmeisai8;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai8(String pZrnshrgkmeisai8) {
        zrnshrgkmeisai8 = pZrnshrgkmeisai8;
    }

    private String zrnshrgktuukasyu8;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKTUUKASYU8)
    public String getZrnshrgktuukasyu8() {
        return zrnshrgktuukasyu8;
    }

    public void setZrnshrgktuukasyu8(String pZrnshrgktuukasyu8) {
        zrnshrgktuukasyu8 = pZrnshrgktuukasyu8;
    }

    private String zrnbikou8;

    @Column(name=GenZT_TtdkKanRn.ZRNBIKOU8)
    public String getZrnbikou8() {
        return zrnbikou8;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou8(String pZrnbikou8) {
        zrnbikou8 = pZrnbikou8;
    }

    private String zrntekiyou9;

    @Column(name=GenZT_TtdkKanRn.ZRNTEKIYOU9)
    public String getZrntekiyou9() {
        return zrntekiyou9;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou9(String pZrntekiyou9) {
        zrntekiyou9 = pZrntekiyou9;
    }

    private String zrnshrkngkmeisaihugou9;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKNGKMEISAIHUGOU9)
    public String getZrnshrkngkmeisaihugou9() {
        return zrnshrkngkmeisaihugou9;
    }

    public void setZrnshrkngkmeisaihugou9(String pZrnshrkngkmeisaihugou9) {
        zrnshrkngkmeisaihugou9 = pZrnshrkngkmeisaihugou9;
    }

    private String zrnshrgkmeisai9;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKMEISAI9)
    public String getZrnshrgkmeisai9() {
        return zrnshrgkmeisai9;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai9(String pZrnshrgkmeisai9) {
        zrnshrgkmeisai9 = pZrnshrgkmeisai9;
    }

    private String zrnshrgktuukasyu9;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKTUUKASYU9)
    public String getZrnshrgktuukasyu9() {
        return zrnshrgktuukasyu9;
    }

    public void setZrnshrgktuukasyu9(String pZrnshrgktuukasyu9) {
        zrnshrgktuukasyu9 = pZrnshrgktuukasyu9;
    }

    private String zrnbikou9;

    @Column(name=GenZT_TtdkKanRn.ZRNBIKOU9)
    public String getZrnbikou9() {
        return zrnbikou9;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou9(String pZrnbikou9) {
        zrnbikou9 = pZrnbikou9;
    }

    private String zrntekiyou10;

    @Column(name=GenZT_TtdkKanRn.ZRNTEKIYOU10)
    public String getZrntekiyou10() {
        return zrntekiyou10;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou10(String pZrntekiyou10) {
        zrntekiyou10 = pZrntekiyou10;
    }

    private String zrnshrkngkmeisaihugou10;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKNGKMEISAIHUGOU10)
    public String getZrnshrkngkmeisaihugou10() {
        return zrnshrkngkmeisaihugou10;
    }

    public void setZrnshrkngkmeisaihugou10(String pZrnshrkngkmeisaihugou10) {
        zrnshrkngkmeisaihugou10 = pZrnshrkngkmeisaihugou10;
    }

    private String zrnshrgkmeisai10;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKMEISAI10)
    public String getZrnshrgkmeisai10() {
        return zrnshrgkmeisai10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai10(String pZrnshrgkmeisai10) {
        zrnshrgkmeisai10 = pZrnshrgkmeisai10;
    }

    private String zrnshrgktuukasyu10;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKTUUKASYU10)
    public String getZrnshrgktuukasyu10() {
        return zrnshrgktuukasyu10;
    }

    public void setZrnshrgktuukasyu10(String pZrnshrgktuukasyu10) {
        zrnshrgktuukasyu10 = pZrnshrgktuukasyu10;
    }

    private String zrnbikou10;

    @Column(name=GenZT_TtdkKanRn.ZRNBIKOU10)
    public String getZrnbikou10() {
        return zrnbikou10;
    }

    @DataConvert("toMultiByte")
    public void setZrnbikou10(String pZrnbikou10) {
        zrnbikou10 = pZrnbikou10;
    }

    private String zrnshrgkgoukei;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRGKGOUKEI)
    public String getZrnshrgkgoukei() {
        return zrnshrgkgoukei;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkgoukei(String pZrnshrgkgoukei) {
        zrnshrgkgoukei = pZrnshrgkgoukei;
    }

    private String zrnshrtuukasyu;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRTUUKASYU)
    public String getZrnshrtuukasyu() {
        return zrnshrtuukasyu;
    }

    public void setZrnshrtuukasyu(String pZrnshrtuukasyu) {
        zrnshrtuukasyu = pZrnshrtuukasyu;
    }

    private String zrndseisanshrttdknm;

    @Column(name=GenZT_TtdkKanRn.ZRNDSEISANSHRTTDKNM)
    public String getZrndseisanshrttdknm() {
        return zrndseisanshrttdknm;
    }

    @DataConvert("toMultiByte")
    public void setZrndseisanshrttdknm(String pZrndseisanshrttdknm) {
        zrndseisanshrttdknm = pZrndseisanshrttdknm;
    }

    private String zrnyobiv26x3;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV26X3)
    public String getZrnyobiv26x3() {
        return zrnyobiv26x3;
    }

    public void setZrnyobiv26x3(String pZrnyobiv26x3) {
        zrnyobiv26x3 = pZrnyobiv26x3;
    }

    private String zrnbanknmkj;

    @Column(name=GenZT_TtdkKanRn.ZRNBANKNMKJ)
    public String getZrnbanknmkj() {
        return zrnbanknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnbanknmkj(String pZrnbanknmkj) {
        zrnbanknmkj = pZrnbanknmkj;
    }

    private String zrnsitennmkj;

    @Column(name=GenZT_TtdkKanRn.ZRNSITENNMKJ)
    public String getZrnsitennmkj() {
        return zrnsitennmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnsitennmkj(String pZrnsitennmkj) {
        zrnsitennmkj = pZrnsitennmkj;
    }

    private String zrnyokinkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNYOKINKBN)
    public String getZrnyokinkbn() {
        return zrnyokinkbn;
    }

    public void setZrnyokinkbn(String pZrnyokinkbn) {
        zrnyokinkbn = pZrnyokinkbn;
    }

    private String zrnkouzano12keta;

    @Column(name=GenZT_TtdkKanRn.ZRNKOUZANO12KETA)
    public String getZrnkouzano12keta() {
        return zrnkouzano12keta;
    }

    public void setZrnkouzano12keta(String pZrnkouzano12keta) {
        zrnkouzano12keta = pZrnkouzano12keta;
    }

    private String zrnkzmeiginmknhan;

    @Column(name=GenZT_TtdkKanRn.ZRNKZMEIGINMKNHAN)
    public String getZrnkzmeiginmknhan() {
        return zrnkzmeiginmknhan;
    }

    public void setZrnkzmeiginmknhan(String pZrnkzmeiginmknhan) {
        zrnkzmeiginmknhan = pZrnkzmeiginmknhan;
    }

    private String zrnkouzasyuruikbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKOUZASYURUIKBN)
    public String getZrnkouzasyuruikbn() {
        return zrnkouzasyuruikbn;
    }

    public void setZrnkouzasyuruikbn(String pZrnkouzasyuruikbn) {
        zrnkouzasyuruikbn = pZrnkouzasyuruikbn;
    }

    private String zrnyobiv26x2;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV26X2)
    public String getZrnyobiv26x2() {
        return zrnyobiv26x2;
    }

    public void setZrnyobiv26x2(String pZrnyobiv26x2) {
        zrnyobiv26x2 = pZrnyobiv26x2;
    }

    private String zrnsynykngk;

    @Column(name=GenZT_TtdkKanRn.ZRNSYNYKNGK)
    public String getZrnsynykngk() {
        return zrnsynykngk;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnsynykngk(String pZrnsynykngk) {
        zrnsynykngk = pZrnsynykngk;
    }

    private String zrnsynykngktuukasyu;

    @Column(name=GenZT_TtdkKanRn.ZRNSYNYKNGKTUUKASYU)
    public String getZrnsynykngktuukasyu() {
        return zrnsynykngktuukasyu;
    }

    public void setZrnsynykngktuukasyu(String pZrnsynykngktuukasyu) {
        zrnsynykngktuukasyu = pZrnsynykngktuukasyu;
    }

    private String zrnhtykeihi;

    @Column(name=GenZT_TtdkKanRn.ZRNHTYKEIHI)
    public String getZrnhtykeihi() {
        return zrnhtykeihi;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnhtykeihi(String pZrnhtykeihi) {
        zrnhtykeihi = pZrnhtykeihi;
    }

    private String zrnhtykeihituukasyu;

    @Column(name=GenZT_TtdkKanRn.ZRNHTYKEIHITUUKASYU)
    public String getZrnhtykeihituukasyu() {
        return zrnhtykeihituukasyu;
    }

    public void setZrnhtykeihituukasyu(String pZrnhtykeihituukasyu) {
        zrnhtykeihituukasyu = pZrnhtykeihituukasyu;
    }

    private String zrnshrkyksyahtykeihi;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKYKSYAHTYKEIHI)
    public String getZrnshrkyksyahtykeihi() {
        return zrnshrkyksyahtykeihi;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnshrkyksyahtykeihi(String pZrnshrkyksyahtykeihi) {
        zrnshrkyksyahtykeihi = pZrnshrkyksyahtykeihi;
    }

    private String zrnshrkykhtykeihituukasyu;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRKYKHTYKEIHITUUKASYU)
    public String getZrnshrkykhtykeihituukasyu() {
        return zrnshrkykhtykeihituukasyu;
    }

    public void setZrnshrkykhtykeihituukasyu(String pZrnshrkykhtykeihituukasyu) {
        zrnshrkykhtykeihituukasyu = pZrnshrkykhtykeihituukasyu;
    }

    private String zrngsbnrkzthtykeihi;

    @Column(name=GenZT_TtdkKanRn.ZRNGSBNRKZTHTYKEIHI)
    public String getZrngsbnrkzthtykeihi() {
        return zrngsbnrkzthtykeihi;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrngsbnrkzthtykeihi(String pZrngsbnrkzthtykeihi) {
        zrngsbnrkzthtykeihi = pZrngsbnrkzthtykeihi;
    }

    private String zrngsbnrkzthtykeihituksyu;

    @Column(name=GenZT_TtdkKanRn.ZRNGSBNRKZTHTYKEIHITUKSYU)
    public String getZrngsbnrkzthtykeihituksyu() {
        return zrngsbnrkzthtykeihituksyu;
    }

    public void setZrngsbnrkzthtykeihituksyu(String pZrngsbnrkzthtykeihituksyu) {
        zrngsbnrkzthtykeihituksyu = pZrngsbnrkzthtykeihituksyu;
    }

    private String zrngsbnrkztsaeki;

    @Column(name=GenZT_TtdkKanRn.ZRNGSBNRKZTSAEKI)
    public String getZrngsbnrkztsaeki() {
        return zrngsbnrkztsaeki;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrngsbnrkztsaeki(String pZrngsbnrkztsaeki) {
        zrngsbnrkztsaeki = pZrngsbnrkztsaeki;
    }

    private String zrngsbnrkztsaekituksyu;

    @Column(name=GenZT_TtdkKanRn.ZRNGSBNRKZTSAEKITUKSYU)
    public String getZrngsbnrkztsaekituksyu() {
        return zrngsbnrkztsaekituksyu;
    }

    public void setZrngsbnrkztsaekituksyu(String pZrngsbnrkztsaekituksyu) {
        zrngsbnrkztsaekituksyu = pZrngsbnrkztsaekituksyu;
    }

    private String zrnzeimunaiyouhensyuctrlkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNZEIMUNAIYOUHENSYUCTRLKBN)
    public String getZrnzeimunaiyouhensyuctrlkbn() {
        return zrnzeimunaiyouhensyuctrlkbn;
    }

    public void setZrnzeimunaiyouhensyuctrlkbn(String pZrnzeimunaiyouhensyuctrlkbn) {
        zrnzeimunaiyouhensyuctrlkbn = pZrnzeimunaiyouhensyuctrlkbn;
    }

    private String zrnzeimumongonoutkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNZEIMUMONGONOUTKBN)
    public String getZrnzeimumongonoutkbn() {
        return zrnzeimumongonoutkbn;
    }

    public void setZrnzeimumongonoutkbn(String pZrnzeimumongonoutkbn) {
        zrnzeimumongonoutkbn = pZrnzeimumongonoutkbn;
    }

    private String zrnzeimumongon1;

    @Column(name=GenZT_TtdkKanRn.ZRNZEIMUMONGON1)
    public String getZrnzeimumongon1() {
        return zrnzeimumongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon1(String pZrnzeimumongon1) {
        zrnzeimumongon1 = pZrnzeimumongon1;
    }

    private String zrnzeimumongon2;

    @Column(name=GenZT_TtdkKanRn.ZRNZEIMUMONGON2)
    public String getZrnzeimumongon2() {
        return zrnzeimumongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon2(String pZrnzeimumongon2) {
        zrnzeimumongon2 = pZrnzeimumongon2;
    }

    private String zrnzeimumongon3;

    @Column(name=GenZT_TtdkKanRn.ZRNZEIMUMONGON3)
    public String getZrnzeimumongon3() {
        return zrnzeimumongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon3(String pZrnzeimumongon3) {
        zrnzeimumongon3 = pZrnzeimumongon3;
    }

    private String zrnzeimumongon4;

    @Column(name=GenZT_TtdkKanRn.ZRNZEIMUMONGON4)
    public String getZrnzeimumongon4() {
        return zrnzeimumongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon4(String pZrnzeimumongon4) {
        zrnzeimumongon4 = pZrnzeimumongon4;
    }

    private String zrnzeimumongon5;

    @Column(name=GenZT_TtdkKanRn.ZRNZEIMUMONGON5)
    public String getZrnzeimumongon5() {
        return zrnzeimumongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon5(String pZrnzeimumongon5) {
        zrnzeimumongon5 = pZrnzeimumongon5;
    }

    private String zrnyendthnkzeimuinfohskkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNYENDTHNKZEIMUINFOHSKKBN)
    public String getZrnyendthnkzeimuinfohskkbn() {
        return zrnyendthnkzeimuinfohskkbn;
    }

    public void setZrnyendthnkzeimuinfohskkbn(String pZrnyendthnkzeimuinfohskkbn) {
        zrnyendthnkzeimuinfohskkbn = pZrnyendthnkzeimuinfohskkbn;
    }

    private String zrnyobiv36;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV36)
    public String getZrnyobiv36() {
        return zrnyobiv36;
    }

    public void setZrnyobiv36(String pZrnyobiv36) {
        zrnyobiv36 = pZrnyobiv36;
    }

    private String zrnosirasehyoudai;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEHYOUDAI)
    public String getZrnosirasehyoudai() {
        return zrnosirasehyoudai;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasehyoudai(String pZrnosirasehyoudai) {
        zrnosirasehyoudai = pZrnosirasehyoudai;
    }

    private String zrnosirasemongon1;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON1)
    public String getZrnosirasemongon1() {
        return zrnosirasemongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon1(String pZrnosirasemongon1) {
        zrnosirasemongon1 = pZrnosirasemongon1;
    }

    private String zrnosirasemongon2;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON2)
    public String getZrnosirasemongon2() {
        return zrnosirasemongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon2(String pZrnosirasemongon2) {
        zrnosirasemongon2 = pZrnosirasemongon2;
    }

    private String zrnosirasemongon3;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON3)
    public String getZrnosirasemongon3() {
        return zrnosirasemongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon3(String pZrnosirasemongon3) {
        zrnosirasemongon3 = pZrnosirasemongon3;
    }

    private String zrnosirasemongon4;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON4)
    public String getZrnosirasemongon4() {
        return zrnosirasemongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon4(String pZrnosirasemongon4) {
        zrnosirasemongon4 = pZrnosirasemongon4;
    }

    private String zrnosirasemongon5;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON5)
    public String getZrnosirasemongon5() {
        return zrnosirasemongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon5(String pZrnosirasemongon5) {
        zrnosirasemongon5 = pZrnosirasemongon5;
    }

    private String zrnosirasemongon6;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON6)
    public String getZrnosirasemongon6() {
        return zrnosirasemongon6;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon6(String pZrnosirasemongon6) {
        zrnosirasemongon6 = pZrnosirasemongon6;
    }

    private String zrnosirasemongon7;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON7)
    public String getZrnosirasemongon7() {
        return zrnosirasemongon7;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon7(String pZrnosirasemongon7) {
        zrnosirasemongon7 = pZrnosirasemongon7;
    }

    private String zrnosirasemongon8;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON8)
    public String getZrnosirasemongon8() {
        return zrnosirasemongon8;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon8(String pZrnosirasemongon8) {
        zrnosirasemongon8 = pZrnosirasemongon8;
    }

    private String zrnosirasemongon9;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON9)
    public String getZrnosirasemongon9() {
        return zrnosirasemongon9;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon9(String pZrnosirasemongon9) {
        zrnosirasemongon9 = pZrnosirasemongon9;
    }

    private String zrnosirasemongon10;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON10)
    public String getZrnosirasemongon10() {
        return zrnosirasemongon10;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon10(String pZrnosirasemongon10) {
        zrnosirasemongon10 = pZrnosirasemongon10;
    }

    private String zrnosirasemongon11;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON11)
    public String getZrnosirasemongon11() {
        return zrnosirasemongon11;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon11(String pZrnosirasemongon11) {
        zrnosirasemongon11 = pZrnosirasemongon11;
    }

    private String zrnosirasemongon12;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON12)
    public String getZrnosirasemongon12() {
        return zrnosirasemongon12;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon12(String pZrnosirasemongon12) {
        zrnosirasemongon12 = pZrnosirasemongon12;
    }

    private String zrnosirasemongon13;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON13)
    public String getZrnosirasemongon13() {
        return zrnosirasemongon13;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon13(String pZrnosirasemongon13) {
        zrnosirasemongon13 = pZrnosirasemongon13;
    }

    private String zrnosirasemongon14;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON14)
    public String getZrnosirasemongon14() {
        return zrnosirasemongon14;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon14(String pZrnosirasemongon14) {
        zrnosirasemongon14 = pZrnosirasemongon14;
    }

    private String zrnosirasemongon15;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON15)
    public String getZrnosirasemongon15() {
        return zrnosirasemongon15;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon15(String pZrnosirasemongon15) {
        zrnosirasemongon15 = pZrnosirasemongon15;
    }

    private String zrnosirasemongon16;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON16)
    public String getZrnosirasemongon16() {
        return zrnosirasemongon16;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon16(String pZrnosirasemongon16) {
        zrnosirasemongon16 = pZrnosirasemongon16;
    }

    private String zrnosirasemongon17;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON17)
    public String getZrnosirasemongon17() {
        return zrnosirasemongon17;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon17(String pZrnosirasemongon17) {
        zrnosirasemongon17 = pZrnosirasemongon17;
    }

    private String zrnosirasemongon18;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON18)
    public String getZrnosirasemongon18() {
        return zrnosirasemongon18;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon18(String pZrnosirasemongon18) {
        zrnosirasemongon18 = pZrnosirasemongon18;
    }

    private String zrnosirasemongon19;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON19)
    public String getZrnosirasemongon19() {
        return zrnosirasemongon19;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon19(String pZrnosirasemongon19) {
        zrnosirasemongon19 = pZrnosirasemongon19;
    }

    private String zrnosirasemongon20;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON20)
    public String getZrnosirasemongon20() {
        return zrnosirasemongon20;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon20(String pZrnosirasemongon20) {
        zrnosirasemongon20 = pZrnosirasemongon20;
    }

    private String zrnosirasemongon21;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON21)
    public String getZrnosirasemongon21() {
        return zrnosirasemongon21;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon21(String pZrnosirasemongon21) {
        zrnosirasemongon21 = pZrnosirasemongon21;
    }

    private String zrnosirasemongon22;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON22)
    public String getZrnosirasemongon22() {
        return zrnosirasemongon22;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon22(String pZrnosirasemongon22) {
        zrnosirasemongon22 = pZrnosirasemongon22;
    }

    private String zrnosirasemongon23;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON23)
    public String getZrnosirasemongon23() {
        return zrnosirasemongon23;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon23(String pZrnosirasemongon23) {
        zrnosirasemongon23 = pZrnosirasemongon23;
    }

    private String zrnosirasemongon24;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON24)
    public String getZrnosirasemongon24() {
        return zrnosirasemongon24;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon24(String pZrnosirasemongon24) {
        zrnosirasemongon24 = pZrnosirasemongon24;
    }

    private String zrnosirasemongon25;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON25)
    public String getZrnosirasemongon25() {
        return zrnosirasemongon25;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon25(String pZrnosirasemongon25) {
        zrnosirasemongon25 = pZrnosirasemongon25;
    }

    private String zrnosirasemongon26;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON26)
    public String getZrnosirasemongon26() {
        return zrnosirasemongon26;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon26(String pZrnosirasemongon26) {
        zrnosirasemongon26 = pZrnosirasemongon26;
    }

    private String zrnosirasemongon27;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON27)
    public String getZrnosirasemongon27() {
        return zrnosirasemongon27;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon27(String pZrnosirasemongon27) {
        zrnosirasemongon27 = pZrnosirasemongon27;
    }

    private String zrnosirasemongon28;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON28)
    public String getZrnosirasemongon28() {
        return zrnosirasemongon28;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon28(String pZrnosirasemongon28) {
        zrnosirasemongon28 = pZrnosirasemongon28;
    }

    private String zrnosirasemongon29;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON29)
    public String getZrnosirasemongon29() {
        return zrnosirasemongon29;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon29(String pZrnosirasemongon29) {
        zrnosirasemongon29 = pZrnosirasemongon29;
    }

    private String zrnosirasemongon30;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON30)
    public String getZrnosirasemongon30() {
        return zrnosirasemongon30;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon30(String pZrnosirasemongon30) {
        zrnosirasemongon30 = pZrnosirasemongon30;
    }

    private String zrnosirasemongon31;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON31)
    public String getZrnosirasemongon31() {
        return zrnosirasemongon31;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon31(String pZrnosirasemongon31) {
        zrnosirasemongon31 = pZrnosirasemongon31;
    }

    private String zrnosirasemongon32;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON32)
    public String getZrnosirasemongon32() {
        return zrnosirasemongon32;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon32(String pZrnosirasemongon32) {
        zrnosirasemongon32 = pZrnosirasemongon32;
    }

    private String zrnosirasemongon33;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON33)
    public String getZrnosirasemongon33() {
        return zrnosirasemongon33;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon33(String pZrnosirasemongon33) {
        zrnosirasemongon33 = pZrnosirasemongon33;
    }

    private String zrnosirasemongon34;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON34)
    public String getZrnosirasemongon34() {
        return zrnosirasemongon34;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon34(String pZrnosirasemongon34) {
        zrnosirasemongon34 = pZrnosirasemongon34;
    }

    private String zrnosirasemongon35;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON35)
    public String getZrnosirasemongon35() {
        return zrnosirasemongon35;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon35(String pZrnosirasemongon35) {
        zrnosirasemongon35 = pZrnosirasemongon35;
    }

    private String zrnosirasemongon36;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON36)
    public String getZrnosirasemongon36() {
        return zrnosirasemongon36;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon36(String pZrnosirasemongon36) {
        zrnosirasemongon36 = pZrnosirasemongon36;
    }

    private String zrnosirasemongon37;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON37)
    public String getZrnosirasemongon37() {
        return zrnosirasemongon37;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon37(String pZrnosirasemongon37) {
        zrnosirasemongon37 = pZrnosirasemongon37;
    }

    private String zrnosirasemongon38;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON38)
    public String getZrnosirasemongon38() {
        return zrnosirasemongon38;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon38(String pZrnosirasemongon38) {
        zrnosirasemongon38 = pZrnosirasemongon38;
    }

    private String zrnosirasemongon39;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON39)
    public String getZrnosirasemongon39() {
        return zrnosirasemongon39;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon39(String pZrnosirasemongon39) {
        zrnosirasemongon39 = pZrnosirasemongon39;
    }

    private String zrnosirasemongon40;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON40)
    public String getZrnosirasemongon40() {
        return zrnosirasemongon40;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon40(String pZrnosirasemongon40) {
        zrnosirasemongon40 = pZrnosirasemongon40;
    }

    private String zrnosirasemongon41;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON41)
    public String getZrnosirasemongon41() {
        return zrnosirasemongon41;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon41(String pZrnosirasemongon41) {
        zrnosirasemongon41 = pZrnosirasemongon41;
    }

    private String zrnosirasemongon42;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON42)
    public String getZrnosirasemongon42() {
        return zrnosirasemongon42;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon42(String pZrnosirasemongon42) {
        zrnosirasemongon42 = pZrnosirasemongon42;
    }

    private String zrnosirasemongon43;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON43)
    public String getZrnosirasemongon43() {
        return zrnosirasemongon43;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon43(String pZrnosirasemongon43) {
        zrnosirasemongon43 = pZrnosirasemongon43;
    }

    private String zrnosirasemongon44;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON44)
    public String getZrnosirasemongon44() {
        return zrnosirasemongon44;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon44(String pZrnosirasemongon44) {
        zrnosirasemongon44 = pZrnosirasemongon44;
    }

    private String zrnosirasemongon45;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON45)
    public String getZrnosirasemongon45() {
        return zrnosirasemongon45;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon45(String pZrnosirasemongon45) {
        zrnosirasemongon45 = pZrnosirasemongon45;
    }

    private String zrnosirasemongon46;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON46)
    public String getZrnosirasemongon46() {
        return zrnosirasemongon46;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon46(String pZrnosirasemongon46) {
        zrnosirasemongon46 = pZrnosirasemongon46;
    }

    private String zrnosirasemongon47;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON47)
    public String getZrnosirasemongon47() {
        return zrnosirasemongon47;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon47(String pZrnosirasemongon47) {
        zrnosirasemongon47 = pZrnosirasemongon47;
    }

    private String zrnosirasemongon48;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON48)
    public String getZrnosirasemongon48() {
        return zrnosirasemongon48;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon48(String pZrnosirasemongon48) {
        zrnosirasemongon48 = pZrnosirasemongon48;
    }

    private String zrnosirasemongon49;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON49)
    public String getZrnosirasemongon49() {
        return zrnosirasemongon49;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon49(String pZrnosirasemongon49) {
        zrnosirasemongon49 = pZrnosirasemongon49;
    }

    private String zrnosirasemongon50;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEMONGON50)
    public String getZrnosirasemongon50() {
        return zrnosirasemongon50;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon50(String pZrnosirasemongon50) {
        zrnosirasemongon50 = pZrnosirasemongon50;
    }

    private String zrnosiraseinjihuyouhyouji;

    @Column(name=GenZT_TtdkKanRn.ZRNOSIRASEINJIHUYOUHYOUJI)
    public String getZrnosiraseinjihuyouhyouji() {
        return zrnosiraseinjihuyouhyouji;
    }

    public void setZrnosiraseinjihuyouhyouji(String pZrnosiraseinjihuyouhyouji) {
        zrnosiraseinjihuyouhyouji = pZrnosiraseinjihuyouhyouji;
    }

    private String zrnyobiv254;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV254)
    public String getZrnyobiv254() {
        return zrnyobiv254;
    }

    public void setZrnyobiv254(String pZrnyobiv254) {
        zrnyobiv254 = pZrnyobiv254;
    }

    private String zrnshrnaiyouhskmongon1;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRNAIYOUHSKMONGON1)
    public String getZrnshrnaiyouhskmongon1() {
        return zrnshrnaiyouhskmongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnshrnaiyouhskmongon1(String pZrnshrnaiyouhskmongon1) {
        zrnshrnaiyouhskmongon1 = pZrnshrnaiyouhskmongon1;
    }

    private String zrnshrnaiyouhskmongon2;

    @Column(name=GenZT_TtdkKanRn.ZRNSHRNAIYOUHSKMONGON2)
    public String getZrnshrnaiyouhskmongon2() {
        return zrnshrnaiyouhskmongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnshrnaiyouhskmongon2(String pZrnshrnaiyouhskmongon2) {
        zrnshrnaiyouhskmongon2 = pZrnshrnaiyouhskmongon2;
    }

    private String zrndocumentid;

    @Column(name=GenZT_TtdkKanRn.ZRNDOCUMENTID)
    public String getZrndocumentid() {
        return zrndocumentid;
    }

    public void setZrndocumentid(String pZrndocumentid) {
        zrndocumentid = pZrndocumentid;
    }

    private String zrnsksmongonkbn1;

    @Column(name=GenZT_TtdkKanRn.ZRNSKSMONGONKBN1)
    public String getZrnsksmongonkbn1() {
        return zrnsksmongonkbn1;
    }

    public void setZrnsksmongonkbn1(String pZrnsksmongonkbn1) {
        zrnsksmongonkbn1 = pZrnsksmongonkbn1;
    }

    private String zrnsksmongonkbn2;

    @Column(name=GenZT_TtdkKanRn.ZRNSKSMONGONKBN2)
    public String getZrnsksmongonkbn2() {
        return zrnsksmongonkbn2;
    }

    public void setZrnsksmongonkbn2(String pZrnsksmongonkbn2) {
        zrnsksmongonkbn2 = pZrnsksmongonkbn2;
    }

    private String zrntoritugisyasyozokunm;

    @Column(name=GenZT_TtdkKanRn.ZRNTORITUGISYASYOZOKUNM)
    public String getZrntoritugisyasyozokunm() {
        return zrntoritugisyasyozokunm;
    }

    @DataConvert("toMultiByte")
    public void setZrntoritugisyasyozokunm(String pZrntoritugisyasyozokunm) {
        zrntoritugisyasyozokunm = pZrntoritugisyasyozokunm;
    }

    private String zrntoritugisyakjncd;

    @Column(name=GenZT_TtdkKanRn.ZRNTORITUGISYAKJNCD)
    public String getZrntoritugisyakjncd() {
        return zrntoritugisyakjncd;
    }

    public void setZrntoritugisyakjncd(String pZrntoritugisyakjncd) {
        zrntoritugisyakjncd = pZrntoritugisyakjncd;
    }

    private String zrntoritugisyanm;

    @Column(name=GenZT_TtdkKanRn.ZRNTORITUGISYANM)
    public String getZrntoritugisyanm() {
        return zrntoritugisyanm;
    }

    @DataConvert("toMultiByte")
    public void setZrntoritugisyanm(String pZrntoritugisyanm) {
        zrntoritugisyanm = pZrntoritugisyanm;
    }

    private String zrnhozonkkny;

    @Column(name=GenZT_TtdkKanRn.ZRNHOZONKKNY)
    public String getZrnhozonkkny() {
        return zrnhozonkkny;
    }

    public void setZrnhozonkkny(String pZrnhozonkkny) {
        zrnhozonkkny = pZrnhozonkkny;
    }

    private String zrntsintelno;

    @Column(name=GenZT_TtdkKanRn.ZRNTSINTELNO)
    public String getZrntsintelno() {
        return zrntsintelno;
    }

    public void setZrntsintelno(String pZrntsintelno) {
        zrntsintelno = pZrntsintelno;
    }

    private String zrnyobiv141;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV141)
    public String getZrnyobiv141() {
        return zrnyobiv141;
    }

    public void setZrnyobiv141(String pZrnyobiv141) {
        zrnyobiv141 = pZrnyobiv141;
    }

    private String zrntrkkzkkbn1;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKKBN1)
    public String getZrntrkkzkkbn1() {
        return zrntrkkzkkbn1;
    }

    public void setZrntrkkzkkbn1(String pZrntrkkzkkbn1) {
        zrntrkkzkkbn1 = pZrntrkkzkkbn1;
    }

    private String zrntrkkzknmkj1;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKNMKJ1)
    public String getZrntrkkzknmkj1() {
        return zrntrkkzknmkj1;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzknmkj1(String pZrntrkkzknmkj1) {
        zrntrkkzknmkj1 = pZrntrkkzknmkj1;
    }

    private String zrntrkkzkseiymd1zenkaku;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKSEIYMD1ZENKAKU)
    public String getZrntrkkzkseiymd1zenkaku() {
        return zrntrkkzkseiymd1zenkaku;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkseiymd1zenkaku(String pZrntrkkzkseiymd1zenkaku) {
        zrntrkkzkseiymd1zenkaku = pZrntrkkzkseiymd1zenkaku;
    }

    private String zrntrkkzkyno1;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKYNO1)
    public String getZrntrkkzkyno1() {
        return zrntrkkzkyno1;
    }

    public void setZrntrkkzkyno1(String pZrntrkkzkyno1) {
        zrntrkkzkyno1 = pZrntrkkzkyno1;
    }

    private String zrntrkkzkadr1kj1;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKADR1KJ1)
    public String getZrntrkkzkadr1kj1() {
        return zrntrkkzkadr1kj1;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkadr1kj1(String pZrntrkkzkadr1kj1) {
        zrntrkkzkadr1kj1 = pZrntrkkzkadr1kj1;
    }

    private String zrntrkkzkadr2kj1;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKADR2KJ1)
    public String getZrntrkkzkadr2kj1() {
        return zrntrkkzkadr2kj1;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkadr2kj1(String pZrntrkkzkadr2kj1) {
        zrntrkkzkadr2kj1 = pZrntrkkzkadr2kj1;
    }

    private String zrntrkkzkadr3kj1;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKADR3KJ1)
    public String getZrntrkkzkadr3kj1() {
        return zrntrkkzkadr3kj1;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkadr3kj1(String pZrntrkkzkadr3kj1) {
        zrntrkkzkadr3kj1 = pZrntrkkzkadr3kj1;
    }

    private String zrntrkkzktelno1;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKTELNO1)
    public String getZrntrkkzktelno1() {
        return zrntrkkzktelno1;
    }

    public void setZrntrkkzktelno1(String pZrntrkkzktelno1) {
        zrntrkkzktelno1 = pZrntrkkzktelno1;
    }

    private String zrntrkkzktelnomtrkhyouji1;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKTELNOMTRKHYOUJI1)
    public String getZrntrkkzktelnomtrkhyouji1() {
        return zrntrkkzktelnomtrkhyouji1;
    }

    public void setZrntrkkzktelnomtrkhyouji1(String pZrntrkkzktelnomtrkhyouji1) {
        zrntrkkzktelnomtrkhyouji1 = pZrntrkkzktelnomtrkhyouji1;
    }

    private String zrntrkkzkkbn2;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKKBN2)
    public String getZrntrkkzkkbn2() {
        return zrntrkkzkkbn2;
    }

    public void setZrntrkkzkkbn2(String pZrntrkkzkkbn2) {
        zrntrkkzkkbn2 = pZrntrkkzkkbn2;
    }

    private String zrntrkkzknmkj2;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKNMKJ2)
    public String getZrntrkkzknmkj2() {
        return zrntrkkzknmkj2;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzknmkj2(String pZrntrkkzknmkj2) {
        zrntrkkzknmkj2 = pZrntrkkzknmkj2;
    }

    private String zrntrkkzkseiymd2zenkaku;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKSEIYMD2ZENKAKU)
    public String getZrntrkkzkseiymd2zenkaku() {
        return zrntrkkzkseiymd2zenkaku;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkseiymd2zenkaku(String pZrntrkkzkseiymd2zenkaku) {
        zrntrkkzkseiymd2zenkaku = pZrntrkkzkseiymd2zenkaku;
    }

    private String zrntrkkzkyno2;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKYNO2)
    public String getZrntrkkzkyno2() {
        return zrntrkkzkyno2;
    }

    public void setZrntrkkzkyno2(String pZrntrkkzkyno2) {
        zrntrkkzkyno2 = pZrntrkkzkyno2;
    }

    private String zrntrkkzkadr1kj2;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKADR1KJ2)
    public String getZrntrkkzkadr1kj2() {
        return zrntrkkzkadr1kj2;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkadr1kj2(String pZrntrkkzkadr1kj2) {
        zrntrkkzkadr1kj2 = pZrntrkkzkadr1kj2;
    }

    private String zrntrkkzkadr2kj2;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKADR2KJ2)
    public String getZrntrkkzkadr2kj2() {
        return zrntrkkzkadr2kj2;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkadr2kj2(String pZrntrkkzkadr2kj2) {
        zrntrkkzkadr2kj2 = pZrntrkkzkadr2kj2;
    }

    private String zrntrkkzkadr3kj2;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKADR3KJ2)
    public String getZrntrkkzkadr3kj2() {
        return zrntrkkzkadr3kj2;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkadr3kj2(String pZrntrkkzkadr3kj2) {
        zrntrkkzkadr3kj2 = pZrntrkkzkadr3kj2;
    }

    private String zrntrkkzktelno2;

    @Column(name=GenZT_TtdkKanRn.ZRNTRKKZKTELNO2)
    public String getZrntrkkzktelno2() {
        return zrntrkkzktelno2;
    }

    public void setZrntrkkzktelno2(String pZrntrkkzktelno2) {
        zrntrkkzktelno2 = pZrntrkkzktelno2;
    }

    private String zrnkykdairinmkj;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDAIRINMKJ)
    public String getZrnkykdairinmkj() {
        return zrnkykdairinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykdairinmkj(String pZrnkykdairinmkj) {
        zrnkykdairinmkj = pZrnkykdairinmkj;
    }

    private String zrnkykomttutkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKOMTTUTKBN)
    public String getZrnkykomttutkbn() {
        return zrnkykomttutkbn;
    }

    public void setZrnkykomttutkbn(String pZrnkykomttutkbn) {
        zrnkykomttutkbn = pZrnkykomttutkbn;
    }

    private String zrnkzkomttutkbn1;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKOMTTUTKBN1)
    public String getZrnkzkomttutkbn1() {
        return zrnkzkomttutkbn1;
    }

    public void setZrnkzkomttutkbn1(String pZrnkzkomttutkbn1) {
        zrnkzkomttutkbn1 = pZrnkzkomttutkbn1;
    }

    private String zrnkzkomttutkbn2;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKOMTTUTKBN2)
    public String getZrnkzkomttutkbn2() {
        return zrnkzkomttutkbn2;
    }

    public void setZrnkzkomttutkbn2(String pZrnkzkomttutkbn2) {
        zrnkzkomttutkbn2 = pZrnkzkomttutkbn2;
    }

    private String zrnhhkomttutkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKOMTTUTKBN)
    public String getZrnhhkomttutkbn() {
        return zrnhhkomttutkbn;
    }

    public void setZrnhhkomttutkbn(String pZrnhhkomttutkbn) {
        zrnhhkomttutkbn = pZrnhhkomttutkbn;
    }

    private String zrnhhkdromttutkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDROMTTUTKBN)
    public String getZrnhhkdromttutkbn() {
        return zrnhhkdromttutkbn;
    }

    public void setZrnhhkdromttutkbn(String pZrnhhkdromttutkbn) {
        zrnhhkdromttutkbn = pZrnhhkdromttutkbn;
    }

    private String zrnkykdairiomttutkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDAIRIOMTTUTKBN)
    public String getZrnkykdairiomttutkbn() {
        return zrnkykdairiomttutkbn;
    }

    public void setZrnkykdairiomttutkbn(String pZrnkykdairiomttutkbn) {
        zrnkykdairiomttutkbn = pZrnkykdairiomttutkbn;
    }

    private String zrnkykurtutkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKURTUTKBN)
    public String getZrnkykurtutkbn() {
        return zrnkykurtutkbn;
    }

    public void setZrnkykurtutkbn(String pZrnkykurtutkbn) {
        zrnkykurtutkbn = pZrnkykurtutkbn;
    }

    private String zrnkzkurtutkbn1;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKURTUTKBN1)
    public String getZrnkzkurtutkbn1() {
        return zrnkzkurtutkbn1;
    }

    public void setZrnkzkurtutkbn1(String pZrnkzkurtutkbn1) {
        zrnkzkurtutkbn1 = pZrnkzkurtutkbn1;
    }

    private String zrnkzkurtutkbn2;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKURTUTKBN2)
    public String getZrnkzkurtutkbn2() {
        return zrnkzkurtutkbn2;
    }

    public void setZrnkzkurtutkbn2(String pZrnkzkurtutkbn2) {
        zrnkzkurtutkbn2 = pZrnkzkurtutkbn2;
    }

    private String zrnhhkdrurtutkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRURTUTKBN)
    public String getZrnhhkdrurtutkbn() {
        return zrnhhkdrurtutkbn;
    }

    public void setZrnhhkdrurtutkbn(String pZrnhhkdrurtutkbn) {
        zrnhhkdrurtutkbn = pZrnhhkdrurtutkbn;
    }

    private String zrnkykdairiurtutkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDAIRIURTUTKBN)
    public String getZrnkykdairiurtutkbn() {
        return zrnkykdairiurtutkbn;
    }

    public void setZrnkykdairiurtutkbn(String pZrnkykdairiurtutkbn) {
        zrnkykdairiurtutkbn = pZrnkykdairiurtutkbn;
    }

    private String zrnkykaistmsgkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKAISTMSGKBN)
    public String getZrnkykaistmsgkbn() {
        return zrnkykaistmsgkbn;
    }

    public void setZrnkykaistmsgkbn(String pZrnkykaistmsgkbn) {
        zrnkykaistmsgkbn = pZrnkykaistmsgkbn;
    }

    private String zrnkzkaistmsgkbn1;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKAISTMSGKBN1)
    public String getZrnkzkaistmsgkbn1() {
        return zrnkzkaistmsgkbn1;
    }

    public void setZrnkzkaistmsgkbn1(String pZrnkzkaistmsgkbn1) {
        zrnkzkaistmsgkbn1 = pZrnkzkaistmsgkbn1;
    }

    private String zrnkzkaistmsgkbn2;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKAISTMSGKBN2)
    public String getZrnkzkaistmsgkbn2() {
        return zrnkzkaistmsgkbn2;
    }

    public void setZrnkzkaistmsgkbn2(String pZrnkzkaistmsgkbn2) {
        zrnkzkaistmsgkbn2 = pZrnkzkaistmsgkbn2;
    }

    private String zrnhhkaistmsgkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKAISTMSGKBN)
    public String getZrnhhkaistmsgkbn() {
        return zrnhhkaistmsgkbn;
    }

    public void setZrnhhkaistmsgkbn(String pZrnhhkaistmsgkbn) {
        zrnhhkaistmsgkbn = pZrnhhkaistmsgkbn;
    }

    private String zrnhhkdraistmsgkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRAISTMSGKBN)
    public String getZrnhhkdraistmsgkbn() {
        return zrnhhkdraistmsgkbn;
    }

    public void setZrnhhkdraistmsgkbn(String pZrnhhkdraistmsgkbn) {
        zrnhhkdraistmsgkbn = pZrnhhkdraistmsgkbn;
    }

    private String zrnkykdairiaistmsgkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDAIRIAISTMSGKBN)
    public String getZrnkykdairiaistmsgkbn() {
        return zrnkykdairiaistmsgkbn;
    }

    public void setZrnkykdairiaistmsgkbn(String pZrnkykdairiaistmsgkbn) {
        zrnkykdairiaistmsgkbn = pZrnkykdairiaistmsgkbn;
    }

    private String zrnsakujyokzknmkj;

    @Column(name=GenZT_TtdkKanRn.ZRNSAKUJYOKZKNMKJ)
    public String getZrnsakujyokzknmkj() {
        return zrnsakujyokzknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnsakujyokzknmkj(String pZrnsakujyokzknmkj) {
        zrnsakujyokzknmkj = pZrnsakujyokzknmkj;
    }

    private String zrnttdknaiyoukbn;

    @Column(name=GenZT_TtdkKanRn.ZRNTTDKNAIYOUKBN)
    public String getZrnttdknaiyoukbn() {
        return zrnttdknaiyoukbn;
    }

    public void setZrnttdknaiyoukbn(String pZrnttdknaiyoukbn) {
        zrnttdknaiyoukbn = pZrnttdknaiyoukbn;
    }

    private String zrnkzktaisyoukykkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKTAISYOUKYKKBN)
    public String getZrnkzktaisyoukykkbn() {
        return zrnkzktaisyoukykkbn;
    }

    public void setZrnkzktaisyoukykkbn(String pZrnkzktaisyoukykkbn) {
        zrnkzktaisyoukykkbn = pZrnkzktaisyoukykkbn;
    }

    private String zrnhhkdrtaisyoukykkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRTAISYOUKYKKBN)
    public String getZrnhhkdrtaisyoukykkbn() {
        return zrnhhkdrtaisyoukykkbn;
    }

    public void setZrnhhkdrtaisyoukykkbn(String pZrnhhkdrtaisyoukykkbn) {
        zrnhhkdrtaisyoukykkbn = pZrnhhkdrtaisyoukykkbn;
    }

    private String zrnkykdairitaisyoukykkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDAIRITAISYOUKYKKBN)
    public String getZrnkykdairitaisyoukykkbn() {
        return zrnkykdairitaisyoukykkbn;
    }

    public void setZrnkykdairitaisyoukykkbn(String pZrnkykdairitaisyoukykkbn) {
        zrnkykdairitaisyoukykkbn = pZrnkykdairitaisyoukykkbn;
    }

    private String zrnmoshnkniymsgkbn1;

    @Column(name=GenZT_TtdkKanRn.ZRNMOSHNKNIYMSGKBN1)
    public String getZrnmoshnkniymsgkbn1() {
        return zrnmoshnkniymsgkbn1;
    }

    public void setZrnmoshnkniymsgkbn1(String pZrnmoshnkniymsgkbn1) {
        zrnmoshnkniymsgkbn1 = pZrnmoshnkniymsgkbn1;
    }

    private String zrnkykmoshnkniymsg2;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKMOSHNKNIYMSG2)
    public String getZrnkykmoshnkniymsg2() {
        return zrnkykmoshnkniymsg2;
    }

    public void setZrnkykmoshnkniymsg2(String pZrnkykmoshnkniymsg2) {
        zrnkykmoshnkniymsg2 = pZrnkykmoshnkniymsg2;
    }

    private String zrnkzkmoshnkniymsg21;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKMOSHNKNIYMSG21)
    public String getZrnkzkmoshnkniymsg21() {
        return zrnkzkmoshnkniymsg21;
    }

    public void setZrnkzkmoshnkniymsg21(String pZrnkzkmoshnkniymsg21) {
        zrnkzkmoshnkniymsg21 = pZrnkzkmoshnkniymsg21;
    }

    private String zrnkzkmoshnkniymsg22;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKMOSHNKNIYMSG22)
    public String getZrnkzkmoshnkniymsg22() {
        return zrnkzkmoshnkniymsg22;
    }

    public void setZrnkzkmoshnkniymsg22(String pZrnkzkmoshnkniymsg22) {
        zrnkzkmoshnkniymsg22 = pZrnkzkmoshnkniymsg22;
    }

    private String zrnhhkdrmoshnkniymsg2;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRMOSHNKNIYMSG2)
    public String getZrnhhkdrmoshnkniymsg2() {
        return zrnhhkdrmoshnkniymsg2;
    }

    public void setZrnhhkdrmoshnkniymsg2(String pZrnhhkdrmoshnkniymsg2) {
        zrnhhkdrmoshnkniymsg2 = pZrnhhkdrmoshnkniymsg2;
    }

    private String zrnkykdairimoshnkniymsg2;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDAIRIMOSHNKNIYMSG2)
    public String getZrnkykdairimoshnkniymsg2() {
        return zrnkykdairimoshnkniymsg2;
    }

    public void setZrnkykdairimoshnkniymsg2(String pZrnkykdairimoshnkniymsg2) {
        zrnkykdairimoshnkniymsg2 = pZrnkykdairimoshnkniymsg2;
    }

    private String zrnkykdrmsgkbn;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDRMSGKBN)
    public String getZrnkykdrmsgkbn() {
        return zrnkykdrmsgkbn;
    }

    public void setZrnkykdrmsgkbn(String pZrnkykdrmsgkbn) {
        zrnkykdrmsgkbn = pZrnkykdrmsgkbn;
    }

    private String zrnkykhhkdrmsg;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKHHKDRMSG)
    public String getZrnkykhhkdrmsg() {
        return zrnkykhhkdrmsg;
    }

    public void setZrnkykhhkdrmsg(String pZrnkykhhkdrmsg) {
        zrnkykhhkdrmsg = pZrnkykhhkdrmsg;
    }

    private String zrnkzkhhkdrmsg1;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKHHKDRMSG1)
    public String getZrnkzkhhkdrmsg1() {
        return zrnkzkhhkdrmsg1;
    }

    public void setZrnkzkhhkdrmsg1(String pZrnkzkhhkdrmsg1) {
        zrnkzkhhkdrmsg1 = pZrnkzkhhkdrmsg1;
    }

    private String zrnkzkhhkdrmsg2;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKHHKDRMSG2)
    public String getZrnkzkhhkdrmsg2() {
        return zrnkzkhhkdrmsg2;
    }

    public void setZrnkzkhhkdrmsg2(String pZrnkzkhhkdrmsg2) {
        zrnkzkhhkdrmsg2 = pZrnkzkhhkdrmsg2;
    }

    private String zrnhhkdrnmkj;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRNMKJ)
    public String getZrnhhkdrnmkj() {
        return zrnhhkdrnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhkdrnmkj(String pZrnhhkdrnmkj) {
        zrnhhkdrnmkj = pZrnhhkdrnmkj;
    }

    private String zrnduhubutumsg1;

    @Column(name=GenZT_TtdkKanRn.ZRNDUHUBUTUMSG1)
    public String getZrnduhubutumsg1() {
        return zrnduhubutumsg1;
    }

    public void setZrnduhubutumsg1(String pZrnduhubutumsg1) {
        zrnduhubutumsg1 = pZrnduhubutumsg1;
    }

    private String zrnduhubutumsg2;

    @Column(name=GenZT_TtdkKanRn.ZRNDUHUBUTUMSG2)
    public String getZrnduhubutumsg2() {
        return zrnduhubutumsg2;
    }

    public void setZrnduhubutumsg2(String pZrnduhubutumsg2) {
        zrnduhubutumsg2 = pZrnduhubutumsg2;
    }

    private String zrnduhubutumsg3;

    @Column(name=GenZT_TtdkKanRn.ZRNDUHUBUTUMSG3)
    public String getZrnduhubutumsg3() {
        return zrnduhubutumsg3;
    }

    public void setZrnduhubutumsg3(String pZrnduhubutumsg3) {
        zrnduhubutumsg3 = pZrnduhubutumsg3;
    }

    private String zrnduhubutumsg4;

    @Column(name=GenZT_TtdkKanRn.ZRNDUHUBUTUMSG4)
    public String getZrnduhubutumsg4() {
        return zrnduhubutumsg4;
    }

    public void setZrnduhubutumsg4(String pZrnduhubutumsg4) {
        zrnduhubutumsg4 = pZrnduhubutumsg4;
    }

    private String zrnduhubutumsg5;

    @Column(name=GenZT_TtdkKanRn.ZRNDUHUBUTUMSG5)
    public String getZrnduhubutumsg5() {
        return zrnduhubutumsg5;
    }

    public void setZrnduhubutumsg5(String pZrnduhubutumsg5) {
        zrnduhubutumsg5 = pZrnduhubutumsg5;
    }

    private String zrnduhubutumsg6;

    @Column(name=GenZT_TtdkKanRn.ZRNDUHUBUTUMSG6)
    public String getZrnduhubutumsg6() {
        return zrnduhubutumsg6;
    }

    public void setZrnduhubutumsg6(String pZrnduhubutumsg6) {
        zrnduhubutumsg6 = pZrnduhubutumsg6;
    }

    private String zrnduhubutumsg7;

    @Column(name=GenZT_TtdkKanRn.ZRNDUHUBUTUMSG7)
    public String getZrnduhubutumsg7() {
        return zrnduhubutumsg7;
    }

    public void setZrnduhubutumsg7(String pZrnduhubutumsg7) {
        zrnduhubutumsg7 = pZrnduhubutumsg7;
    }

    private String zrnkykigaidhbtmsg1;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKIGAIDHBTMSG1)
    public String getZrnkykigaidhbtmsg1() {
        return zrnkykigaidhbtmsg1;
    }

    public void setZrnkykigaidhbtmsg1(String pZrnkykigaidhbtmsg1) {
        zrnkykigaidhbtmsg1 = pZrnkykigaidhbtmsg1;
    }

    private String zrnkykigaidhbtmsg2;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKIGAIDHBTMSG2)
    public String getZrnkykigaidhbtmsg2() {
        return zrnkykigaidhbtmsg2;
    }

    public void setZrnkykigaidhbtmsg2(String pZrnkykigaidhbtmsg2) {
        zrnkykigaidhbtmsg2 = pZrnkykigaidhbtmsg2;
    }

    private String zrnkykigaidhbtmsg3;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKIGAIDHBTMSG3)
    public String getZrnkykigaidhbtmsg3() {
        return zrnkykigaidhbtmsg3;
    }

    public void setZrnkykigaidhbtmsg3(String pZrnkykigaidhbtmsg3) {
        zrnkykigaidhbtmsg3 = pZrnkykigaidhbtmsg3;
    }

    private String zrnkykigaidhbtmsg4;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKIGAIDHBTMSG4)
    public String getZrnkykigaidhbtmsg4() {
        return zrnkykigaidhbtmsg4;
    }

    public void setZrnkykigaidhbtmsg4(String pZrnkykigaidhbtmsg4) {
        zrnkykigaidhbtmsg4 = pZrnkykigaidhbtmsg4;
    }

    private String zrnyakkankiyakuhunyuuhyouji;

    @Column(name=GenZT_TtdkKanRn.ZRNYAKKANKIYAKUHUNYUUHYOUJI)
    public String getZrnyakkankiyakuhunyuuhyouji() {
        return zrnyakkankiyakuhunyuuhyouji;
    }

    public void setZrnyakkankiyakuhunyuuhyouji(String pZrnyakkankiyakuhunyuuhyouji) {
        zrnyakkankiyakuhunyuuhyouji = pZrnyakkankiyakuhunyuuhyouji;
    }

    private String zrnkyktrktrshuunyuuhyouji;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKTRKTRSHUUNYUUHYOUJI)
    public String getZrnkyktrktrshuunyuuhyouji() {
        return zrnkyktrktrshuunyuuhyouji;
    }

    public void setZrnkyktrktrshuunyuuhyouji(String pZrnkyktrktrshuunyuuhyouji) {
        zrnkyktrktrshuunyuuhyouji = pZrnkyktrktrshuunyuuhyouji;
    }

    private String zrnkzktrktrshuunyuuhyouji1;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKTRKTRSHUUNYUUHYOUJI1)
    public String getZrnkzktrktrshuunyuuhyouji1() {
        return zrnkzktrktrshuunyuuhyouji1;
    }

    public void setZrnkzktrktrshuunyuuhyouji1(String pZrnkzktrktrshuunyuuhyouji1) {
        zrnkzktrktrshuunyuuhyouji1 = pZrnkzktrktrshuunyuuhyouji1;
    }

    private String zrnkzktrktrshuunyuuhyouji2;

    @Column(name=GenZT_TtdkKanRn.ZRNKZKTRKTRSHUUNYUUHYOUJI2)
    public String getZrnkzktrktrshuunyuuhyouji2() {
        return zrnkzktrktrshuunyuuhyouji2;
    }

    public void setZrnkzktrktrshuunyuuhyouji2(String pZrnkzktrktrshuunyuuhyouji2) {
        zrnkzktrktrshuunyuuhyouji2 = pZrnkzktrktrshuunyuuhyouji2;
    }

    private String zrnkykdrhuunyuuhyouji;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDRHUUNYUUHYOUJI)
    public String getZrnkykdrhuunyuuhyouji() {
        return zrnkykdrhuunyuuhyouji;
    }

    public void setZrnkykdrhuunyuuhyouji(String pZrnkykdrhuunyuuhyouji) {
        zrnkykdrhuunyuuhyouji = pZrnkykdrhuunyuuhyouji;
    }

    private String zrnhhkdrhuunyuuhyouji;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRHUUNYUUHYOUJI)
    public String getZrnhhkdrhuunyuuhyouji() {
        return zrnhhkdrhuunyuuhyouji;
    }

    public void setZrnhhkdrhuunyuuhyouji(String pZrnhhkdrhuunyuuhyouji) {
        zrnhhkdrhuunyuuhyouji = pZrnhhkdrhuunyuuhyouji;
    }

    private String zrnkykdairinmkj2;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDAIRINMKJ2)
    public String getZrnkykdairinmkj2() {
        return zrnkykdairinmkj2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykdairinmkj2(String pZrnkykdairinmkj2) {
        zrnkykdairinmkj2 = pZrnkykdairinmkj2;
    }

    private String zrnkykdrseiymd;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDRSEIYMD)
    public String getZrnkykdrseiymd() {
        return zrnkykdrseiymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykdrseiymd(String pZrnkykdrseiymd) {
        zrnkykdrseiymd = pZrnkykdrseiymd;
    }

    private String zrnkykdryno;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDRYNO)
    public String getZrnkykdryno() {
        return zrnkykdryno;
    }

    public void setZrnkykdryno(String pZrnkykdryno) {
        zrnkykdryno = pZrnkykdryno;
    }

    private String zrnkykdradr1kj;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDRADR1KJ)
    public String getZrnkykdradr1kj() {
        return zrnkykdradr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykdradr1kj(String pZrnkykdradr1kj) {
        zrnkykdradr1kj = pZrnkykdradr1kj;
    }

    private String zrnkykdradr2kj;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDRADR2KJ)
    public String getZrnkykdradr2kj() {
        return zrnkykdradr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykdradr2kj(String pZrnkykdradr2kj) {
        zrnkykdradr2kj = pZrnkykdradr2kj;
    }

    private String zrnkykdradr3kj;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDRADR3KJ)
    public String getZrnkykdradr3kj() {
        return zrnkykdradr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykdradr3kj(String pZrnkykdradr3kj) {
        zrnkykdradr3kj = pZrnkykdradr3kj;
    }

    private String zrnkykdrtelno;

    @Column(name=GenZT_TtdkKanRn.ZRNKYKDRTELNO)
    public String getZrnkykdrtelno() {
        return zrnkykdrtelno;
    }

    public void setZrnkykdrtelno(String pZrnkykdrtelno) {
        zrnkykdrtelno = pZrnkykdrtelno;
    }

    private String zrnhhkdrnmkj2;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRNMKJ2)
    public String getZrnhhkdrnmkj2() {
        return zrnhhkdrnmkj2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhkdrnmkj2(String pZrnhhkdrnmkj2) {
        zrnhhkdrnmkj2 = pZrnhhkdrnmkj2;
    }

    private String zrnhhkdrseiymd;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRSEIYMD)
    public String getZrnhhkdrseiymd() {
        return zrnhhkdrseiymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhkdrseiymd(String pZrnhhkdrseiymd) {
        zrnhhkdrseiymd = pZrnhhkdrseiymd;
    }

    private String zrnhhkdryno;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRYNO)
    public String getZrnhhkdryno() {
        return zrnhhkdryno;
    }

    public void setZrnhhkdryno(String pZrnhhkdryno) {
        zrnhhkdryno = pZrnhhkdryno;
    }

    private String zrnhhkdradr1kj;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRADR1KJ)
    public String getZrnhhkdradr1kj() {
        return zrnhhkdradr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhkdradr1kj(String pZrnhhkdradr1kj) {
        zrnhhkdradr1kj = pZrnhhkdradr1kj;
    }

    private String zrnhhkdradr2kj;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRADR2KJ)
    public String getZrnhhkdradr2kj() {
        return zrnhhkdradr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhkdradr2kj(String pZrnhhkdradr2kj) {
        zrnhhkdradr2kj = pZrnhhkdradr2kj;
    }

    private String zrnhhkdradr3kj;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRADR3KJ)
    public String getZrnhhkdradr3kj() {
        return zrnhhkdradr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhkdradr3kj(String pZrnhhkdradr3kj) {
        zrnhhkdradr3kj = pZrnhhkdradr3kj;
    }

    private String zrnhhkdrtelno;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRTELNO)
    public String getZrnhhkdrtelno() {
        return zrnhhkdrtelno;
    }

    public void setZrnhhkdrtelno(String pZrnhhkdrtelno) {
        zrnhhkdrtelno = pZrnhhkdrtelno;
    }

    private String zrnhhkdrtelnomtrkhyouji;

    @Column(name=GenZT_TtdkKanRn.ZRNHHKDRTELNOMTRKHYOUJI)
    public String getZrnhhkdrtelnomtrkhyouji() {
        return zrnhhkdrtelnomtrkhyouji;
    }

    public void setZrnhhkdrtelnomtrkhyouji(String pZrnhhkdrtelnomtrkhyouji) {
        zrnhhkdrtelnomtrkhyouji = pZrnhhkdrtelnomtrkhyouji;
    }

    private String zrnkhsyono2;

    @Column(name=GenZT_TtdkKanRn.ZRNKHSYONO2)
    public String getZrnkhsyono2() {
        return zrnkhsyono2;
    }

    public void setZrnkhsyono2(String pZrnkhsyono2) {
        zrnkhsyono2 = pZrnkhsyono2;
    }

    private String zrnkhsyono3;

    @Column(name=GenZT_TtdkKanRn.ZRNKHSYONO3)
    public String getZrnkhsyono3() {
        return zrnkhsyono3;
    }

    public void setZrnkhsyono3(String pZrnkhsyono3) {
        zrnkhsyono3 = pZrnkhsyono3;
    }

    private String zrnkhsyono4;

    @Column(name=GenZT_TtdkKanRn.ZRNKHSYONO4)
    public String getZrnkhsyono4() {
        return zrnkhsyono4;
    }

    public void setZrnkhsyono4(String pZrnkhsyono4) {
        zrnkhsyono4 = pZrnkhsyono4;
    }

    private String zrnkhsyono5;

    @Column(name=GenZT_TtdkKanRn.ZRNKHSYONO5)
    public String getZrnkhsyono5() {
        return zrnkhsyono5;
    }

    public void setZrnkhsyono5(String pZrnkhsyono5) {
        zrnkhsyono5 = pZrnkhsyono5;
    }

    private String zrnkhsyono6;

    @Column(name=GenZT_TtdkKanRn.ZRNKHSYONO6)
    public String getZrnkhsyono6() {
        return zrnkhsyono6;
    }

    public void setZrnkhsyono6(String pZrnkhsyono6) {
        zrnkhsyono6 = pZrnkhsyono6;
    }

    private String zrnkhsyono7;

    @Column(name=GenZT_TtdkKanRn.ZRNKHSYONO7)
    public String getZrnkhsyono7() {
        return zrnkhsyono7;
    }

    public void setZrnkhsyono7(String pZrnkhsyono7) {
        zrnkhsyono7 = pZrnkhsyono7;
    }

    private String zrnkhsyono8;

    @Column(name=GenZT_TtdkKanRn.ZRNKHSYONO8)
    public String getZrnkhsyono8() {
        return zrnkhsyono8;
    }

    public void setZrnkhsyono8(String pZrnkhsyono8) {
        zrnkhsyono8 = pZrnkhsyono8;
    }

    private String zrnkhsyono9;

    @Column(name=GenZT_TtdkKanRn.ZRNKHSYONO9)
    public String getZrnkhsyono9() {
        return zrnkhsyono9;
    }

    public void setZrnkhsyono9(String pZrnkhsyono9) {
        zrnkhsyono9 = pZrnkhsyono9;
    }

    private String zrnkhsyono10;

    @Column(name=GenZT_TtdkKanRn.ZRNKHSYONO10)
    public String getZrnkhsyono10() {
        return zrnkhsyono10;
    }

    public void setZrnkhsyono10(String pZrnkhsyono10) {
        zrnkhsyono10 = pZrnkhsyono10;
    }

    private String zrnkhmosno1;

    @Column(name=GenZT_TtdkKanRn.ZRNKHMOSNO1)
    public String getZrnkhmosno1() {
        return zrnkhmosno1;
    }

    public void setZrnkhmosno1(String pZrnkhmosno1) {
        zrnkhmosno1 = pZrnkhmosno1;
    }

    private String zrnkhmosno2;

    @Column(name=GenZT_TtdkKanRn.ZRNKHMOSNO2)
    public String getZrnkhmosno2() {
        return zrnkhmosno2;
    }

    public void setZrnkhmosno2(String pZrnkhmosno2) {
        zrnkhmosno2 = pZrnkhmosno2;
    }

    private String zrnkhmosno3;

    @Column(name=GenZT_TtdkKanRn.ZRNKHMOSNO3)
    public String getZrnkhmosno3() {
        return zrnkhmosno3;
    }

    public void setZrnkhmosno3(String pZrnkhmosno3) {
        zrnkhmosno3 = pZrnkhmosno3;
    }

    private String zrnkhmosno4;

    @Column(name=GenZT_TtdkKanRn.ZRNKHMOSNO4)
    public String getZrnkhmosno4() {
        return zrnkhmosno4;
    }

    public void setZrnkhmosno4(String pZrnkhmosno4) {
        zrnkhmosno4 = pZrnkhmosno4;
    }

    private String zrnkhmosno5;

    @Column(name=GenZT_TtdkKanRn.ZRNKHMOSNO5)
    public String getZrnkhmosno5() {
        return zrnkhmosno5;
    }

    public void setZrnkhmosno5(String pZrnkhmosno5) {
        zrnkhmosno5 = pZrnkhmosno5;
    }

    private String zrnkhmosno6;

    @Column(name=GenZT_TtdkKanRn.ZRNKHMOSNO6)
    public String getZrnkhmosno6() {
        return zrnkhmosno6;
    }

    public void setZrnkhmosno6(String pZrnkhmosno6) {
        zrnkhmosno6 = pZrnkhmosno6;
    }

    private String zrnkhmosno7;

    @Column(name=GenZT_TtdkKanRn.ZRNKHMOSNO7)
    public String getZrnkhmosno7() {
        return zrnkhmosno7;
    }

    public void setZrnkhmosno7(String pZrnkhmosno7) {
        zrnkhmosno7 = pZrnkhmosno7;
    }

    private String zrnkhmosno8;

    @Column(name=GenZT_TtdkKanRn.ZRNKHMOSNO8)
    public String getZrnkhmosno8() {
        return zrnkhmosno8;
    }

    public void setZrnkhmosno8(String pZrnkhmosno8) {
        zrnkhmosno8 = pZrnkhmosno8;
    }

    private String zrnkhmosno9;

    @Column(name=GenZT_TtdkKanRn.ZRNKHMOSNO9)
    public String getZrnkhmosno9() {
        return zrnkhmosno9;
    }

    public void setZrnkhmosno9(String pZrnkhmosno9) {
        zrnkhmosno9 = pZrnkhmosno9;
    }

    private String zrnkhmosno10;

    @Column(name=GenZT_TtdkKanRn.ZRNKHMOSNO10)
    public String getZrnkhmosno10() {
        return zrnkhmosno10;
    }

    public void setZrnkhmosno10(String pZrnkhmosno10) {
        zrnkhmosno10 = pZrnkhmosno10;
    }

    private String zrnhnsnhutouhuunyuuhyouji;

    @Column(name=GenZT_TtdkKanRn.ZRNHNSNHUTOUHUUNYUUHYOUJI)
    public String getZrnhnsnhutouhuunyuuhyouji() {
        return zrnhnsnhutouhuunyuuhyouji;
    }

    public void setZrnhnsnhutouhuunyuuhyouji(String pZrnhnsnhutouhuunyuuhyouji) {
        zrnhnsnhutouhuunyuuhyouji = pZrnhnsnhutouhuunyuuhyouji;
    }

    private String zrnyobiv204;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV204)
    public String getZrnyobiv204() {
        return zrnyobiv204;
    }

    public void setZrnyobiv204(String pZrnyobiv204) {
        zrnyobiv204 = pZrnyobiv204;
    }

    private String zrnyobiv255x2;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV255X2)
    public String getZrnyobiv255x2() {
        return zrnyobiv255x2;
    }

    public void setZrnyobiv255x2(String pZrnyobiv255x2) {
        zrnyobiv255x2 = pZrnyobiv255x2;
    }

    private String zrnyobiv255x3;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV255X3)
    public String getZrnyobiv255x3() {
        return zrnyobiv255x3;
    }

    public void setZrnyobiv255x3(String pZrnyobiv255x3) {
        zrnyobiv255x3 = pZrnyobiv255x3;
    }

    private String zrnyobiv255x4;

    @Column(name=GenZT_TtdkKanRn.ZRNYOBIV255X4)
    public String getZrnyobiv255x4() {
        return zrnyobiv255x4;
    }

    public void setZrnyobiv255x4(String pZrnyobiv255x4) {
        zrnyobiv255x4 = pZrnyobiv255x4;
    }
}