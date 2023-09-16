package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.ZT_TtdkKanTy;
import yuyu.def.db.id.PKZT_TtdkKanTy;
import yuyu.def.db.meta.GenQZT_TtdkKanTy;
import yuyu.def.db.meta.QZT_TtdkKanTy;

/**
 * 手続完了Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_TtdkKanTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanTy}</td><td colspan="3">手続完了Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_TtdkKanTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymdwa ztytyouhyouymdwa}</td><td>（中継用）帳票作成日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_TtdkKanTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantousitukbn ztytantousitukbn}</td><td>（中継用）担当室区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyodouhuukbn ztysyodouhuukbn}</td><td>（中継用）証券同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">{@link PKZT_TtdkKanTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv21 ztyyobiv21}</td><td>（中継用）予備項目Ｖ２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskyno ztyshskyno}</td><td>（中継用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr1kj ztyshskadr1kj}</td><td>（中継用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr2kj ztyshskadr2kj}</td><td>（中継用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr3kj ztyshskadr3kj}</td><td>（中継用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshsnmkjttdk ztyshsnmkjttdk}</td><td>（中継用）送付先名（漢字）（手続完了）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshsnmkjttdk2 ztyshsnmkjttdk2}</td><td>（中継用）送付先名（漢字）（手続完了）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawyno ztytawyno}</td><td>（中継用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr1kj ztytawadr1kj}</td><td>（中継用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr2kj ztytawadr2kj}</td><td>（中継用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoiawasekaisyanmkj ztytoiawasekaisyanmkj}</td><td>（中継用）問合せ先会社名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawsosikikj ztytawsosikikj}</td><td>（中継用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawtelnov14 ztytawtelnov14}</td><td>（中継用）問合せ先電話番号Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou1x18keta ztytawteluktkkanou1x18keta}</td><td>（中継用）問合せ先電話受付可能時間１（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou2x18keta ztytawteluktkkanou2x18keta}</td><td>（中継用）問合せ先電話受付可能時間２（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv26 ztyyobiv26}</td><td>（中継用）予備項目Ｖ２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytetudukisyunm ztytetudukisyunm}</td><td>（中継用）手続種類名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokakmngnumkbn ztysyokakmngnumkbn}</td><td>（中継用）証券確認文言有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj ztykyknmkj}</td><td>（中継用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv28 ztyyobiv28}</td><td>（中継用）予備項目Ｖ２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyou1 ztyttdknaiyou1}</td><td>（中継用）手続内容１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyou2 ztyttdknaiyou2}</td><td>（中継用）手続内容２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyou3 ztyttdknaiyou3}</td><td>（中継用）手続内容３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyou4 ztyttdknaiyou4}</td><td>（中継用）手続内容４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyou5 ztyttdknaiyou5}</td><td>（中継用）手続内容５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyou6 ztyttdknaiyou6}</td><td>（中継用）手続内容６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyou7 ztyttdknaiyou7}</td><td>（中継用）手続内容７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyou8 ztyttdknaiyou8}</td><td>（中継用）手続内容８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyou9 ztyttdknaiyou9}</td><td>（中継用）手続内容９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyou10 ztyttdknaiyou10}</td><td>（中継用）手続内容１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyouumukbn ztyttdknaiyouumukbn}</td><td>（中継用）手続内容有無区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyuhnkkbn ztykykniyuhnkkbn}</td><td>（中継用）契約内容変更区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyuhnkymd ztykykniyuhnkymd}</td><td>（中継用）契約内容変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyuhnkinfo ztykykniyuhnkinfo}</td><td>（中継用）契約内容変更情報</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyuhnkkngkhugou1 ztykykniyuhnkkngkhugou1}</td><td>（中継用）契約内容変更金額明細符号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyuhnkkngk1 ztykykniyuhnkkngk1}</td><td>（中継用）契約内容変更金額１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyuhnkkngktuksyu1 ztykykniyuhnkkngktuksyu1}</td><td>（中継用）契約内容変更金額通貨種類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyuhnkkngkhugou2 ztykykniyuhnkkngkhugou2}</td><td>（中継用）契約内容変更金額明細符号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyuhnkkngk2 ztykykniyuhnkkngk2}</td><td>（中継用）契約内容変更金額２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyuhnkkngktuksyu2 ztykykniyuhnkkngktuksyu2}</td><td>（中継用）契約内容変更金額通貨種類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv102 ztyyobiv102}</td><td>（中継用）予備項目Ｖ１０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaibiwareki ztysiharaibiwareki}</td><td>（中継用）支払日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiyakuymdwa ztykaiyakuymdwa}</td><td>（中継用）解約日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou1 ztytekiyou1}</td><td>（中継用）摘要１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou1 ztyshrkngkmeisaihugou1}</td><td>（中継用）支払金額明細符号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai1 ztyshrgkmeisai1}</td><td>（中継用）支払金額明細１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu1 ztyshrgktuukasyu1}</td><td>（中継用）支払金額通貨種類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou1 ztybikou1}</td><td>（中継用）備考１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou2 ztytekiyou2}</td><td>（中継用）摘要２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou2 ztyshrkngkmeisaihugou2}</td><td>（中継用）支払金額明細符号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai2 ztyshrgkmeisai2}</td><td>（中継用）支払金額明細２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu2 ztyshrgktuukasyu2}</td><td>（中継用）支払金額通貨種類２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou2 ztybikou2}</td><td>（中継用）備考２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou3 ztytekiyou3}</td><td>（中継用）摘要３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou3 ztyshrkngkmeisaihugou3}</td><td>（中継用）支払金額明細符号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai3 ztyshrgkmeisai3}</td><td>（中継用）支払金額明細３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu3 ztyshrgktuukasyu3}</td><td>（中継用）支払金額通貨種類３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou3 ztybikou3}</td><td>（中継用）備考３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou4 ztytekiyou4}</td><td>（中継用）摘要４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou4 ztyshrkngkmeisaihugou4}</td><td>（中継用）支払金額明細符号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai4 ztyshrgkmeisai4}</td><td>（中継用）支払金額明細４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu4 ztyshrgktuukasyu4}</td><td>（中継用）支払金額通貨種類４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou4 ztybikou4}</td><td>（中継用）備考４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou5 ztytekiyou5}</td><td>（中継用）摘要５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou5 ztyshrkngkmeisaihugou5}</td><td>（中継用）支払金額明細符号５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai5 ztyshrgkmeisai5}</td><td>（中継用）支払金額明細５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu5 ztyshrgktuukasyu5}</td><td>（中継用）支払金額通貨種類５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou5 ztybikou5}</td><td>（中継用）備考５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou6 ztytekiyou6}</td><td>（中継用）摘要６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou6 ztyshrkngkmeisaihugou6}</td><td>（中継用）支払金額明細符号６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai6 ztyshrgkmeisai6}</td><td>（中継用）支払金額明細６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu6 ztyshrgktuukasyu6}</td><td>（中継用）支払金額通貨種類６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou6 ztybikou6}</td><td>（中継用）備考６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou7 ztytekiyou7}</td><td>（中継用）摘要７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou7 ztyshrkngkmeisaihugou7}</td><td>（中継用）支払金額明細符号７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai7 ztyshrgkmeisai7}</td><td>（中継用）支払金額明細７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu7 ztyshrgktuukasyu7}</td><td>（中継用）支払金額通貨種類７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou7 ztybikou7}</td><td>（中継用）備考７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou8 ztytekiyou8}</td><td>（中継用）摘要８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou8 ztyshrkngkmeisaihugou8}</td><td>（中継用）支払金額明細符号８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai8 ztyshrgkmeisai8}</td><td>（中継用）支払金額明細８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu8 ztyshrgktuukasyu8}</td><td>（中継用）支払金額通貨種類８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou8 ztybikou8}</td><td>（中継用）備考８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou9 ztytekiyou9}</td><td>（中継用）摘要９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou9 ztyshrkngkmeisaihugou9}</td><td>（中継用）支払金額明細符号９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai9 ztyshrgkmeisai9}</td><td>（中継用）支払金額明細９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu9 ztyshrgktuukasyu9}</td><td>（中継用）支払金額通貨種類９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou9 ztybikou9}</td><td>（中継用）備考９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou10 ztytekiyou10}</td><td>（中継用）摘要１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkngkmeisaihugou10 ztyshrkngkmeisaihugou10}</td><td>（中継用）支払金額明細符号１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai10 ztyshrgkmeisai10}</td><td>（中継用）支払金額明細１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgktuukasyu10 ztyshrgktuukasyu10}</td><td>（中継用）支払金額通貨種類１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybikou10 ztybikou10}</td><td>（中継用）備考１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkgoukei ztyshrgkgoukei}</td><td>（中継用）支払額合計</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtuukasyu ztyshrtuukasyu}</td><td>（中継用）支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydseisanshrttdknm ztydseisanshrttdknm}</td><td>（中継用）Ｄ精算支払手続名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv26x3 ztyyobiv26x3}</td><td>（中継用）予備項目Ｖ２６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybanknmkj ztybanknmkj}</td><td>（中継用）銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysitennmkj ztysitennmkj}</td><td>（中継用）支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyokinkbn ztyyokinkbn}</td><td>（中継用）預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzano12keta ztykouzano12keta}</td><td>（中継用）口座番号（１２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzmeiginmknhan ztykzmeiginmknhan}</td><td>（中継用）口座名義人氏名（カナ）（半角）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzasyuruikbn ztykouzasyuruikbn}</td><td>（中継用）口座種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv26x2 ztyyobiv26x2}</td><td>（中継用）予備項目Ｖ２６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysynykngk ztysynykngk}</td><td>（中継用）収入金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysynykngktuukasyu ztysynykngktuukasyu}</td><td>（中継用）収入金額通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtykeihi ztyhtykeihi}</td><td>（中継用）必要経費</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtykeihituukasyu ztyhtykeihituukasyu}</td><td>（中継用）必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkyksyahtykeihi ztyshrkyksyahtykeihi}</td><td>（中継用）お支払時の契約者の必要経費</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrkykhtykeihituukasyu ztyshrkykhtykeihituukasyu}</td><td>（中継用）お支払時の契約者の必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygsbnrkzthtykeihi ztygsbnrkzthtykeihi}</td><td>（中継用）源泉分離課税対象の必要経費</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygsbnrkzthtykeihituksyu ztygsbnrkzthtykeihituksyu}</td><td>（中継用）源泉分離課税対象の必要経費通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygsbnrkztsaeki ztygsbnrkztsaeki}</td><td>（中継用）源泉分離課税対象の差益</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygsbnrkztsaekituksyu ztygsbnrkztsaekituksyu}</td><td>（中継用）源泉分離課税対象の差益通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimunaiyouhensyuctrlkbn ztyzeimunaiyouhensyuctrlkbn}</td><td>（中継用）税務内容編集制御区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongonoutkbn ztyzeimumongonoutkbn}</td><td>（中継用）税務文言出力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon1 ztyzeimumongon1}</td><td>（中継用）税務文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon2 ztyzeimumongon2}</td><td>（中継用）税務文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon3 ztyzeimumongon3}</td><td>（中継用）税務文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon4 ztyzeimumongon4}</td><td>（中継用）税務文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon5 ztyzeimumongon5}</td><td>（中継用）税務文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyendthnkzeimuinfohskkbn ztyyendthnkzeimuinfohskkbn}</td><td>（中継用）円建変更時税務情報補足区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv36 ztyyobiv36}</td><td>（中継用）予備項目Ｖ３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasehyoudai ztyosirasehyoudai}</td><td>（中継用）お知らせ表題</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon1 ztyosirasemongon1}</td><td>（中継用）お知らせ文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon2 ztyosirasemongon2}</td><td>（中継用）お知らせ文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon3 ztyosirasemongon3}</td><td>（中継用）お知らせ文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon4 ztyosirasemongon4}</td><td>（中継用）お知らせ文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon5 ztyosirasemongon5}</td><td>（中継用）お知らせ文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon6 ztyosirasemongon6}</td><td>（中継用）お知らせ文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon7 ztyosirasemongon7}</td><td>（中継用）お知らせ文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon8 ztyosirasemongon8}</td><td>（中継用）お知らせ文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon9 ztyosirasemongon9}</td><td>（中継用）お知らせ文言９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon10 ztyosirasemongon10}</td><td>（中継用）お知らせ文言１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon11 ztyosirasemongon11}</td><td>（中継用）お知らせ文言１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon12 ztyosirasemongon12}</td><td>（中継用）お知らせ文言１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon13 ztyosirasemongon13}</td><td>（中継用）お知らせ文言１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon14 ztyosirasemongon14}</td><td>（中継用）お知らせ文言１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon15 ztyosirasemongon15}</td><td>（中継用）お知らせ文言１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon16 ztyosirasemongon16}</td><td>（中継用）お知らせ文言１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon17 ztyosirasemongon17}</td><td>（中継用）お知らせ文言１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon18 ztyosirasemongon18}</td><td>（中継用）お知らせ文言１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon19 ztyosirasemongon19}</td><td>（中継用）お知らせ文言１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon20 ztyosirasemongon20}</td><td>（中継用）お知らせ文言２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon21 ztyosirasemongon21}</td><td>（中継用）お知らせ文言２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon22 ztyosirasemongon22}</td><td>（中継用）お知らせ文言２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon23 ztyosirasemongon23}</td><td>（中継用）お知らせ文言２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon24 ztyosirasemongon24}</td><td>（中継用）お知らせ文言２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon25 ztyosirasemongon25}</td><td>（中継用）お知らせ文言２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon26 ztyosirasemongon26}</td><td>（中継用）お知らせ文言２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon27 ztyosirasemongon27}</td><td>（中継用）お知らせ文言２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon28 ztyosirasemongon28}</td><td>（中継用）お知らせ文言２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon29 ztyosirasemongon29}</td><td>（中継用）お知らせ文言２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon30 ztyosirasemongon30}</td><td>（中継用）お知らせ文言３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon31 ztyosirasemongon31}</td><td>（中継用）お知らせ文言３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon32 ztyosirasemongon32}</td><td>（中継用）お知らせ文言３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon33 ztyosirasemongon33}</td><td>（中継用）お知らせ文言３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon34 ztyosirasemongon34}</td><td>（中継用）お知らせ文言３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon35 ztyosirasemongon35}</td><td>（中継用）お知らせ文言３５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon36 ztyosirasemongon36}</td><td>（中継用）お知らせ文言３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon37 ztyosirasemongon37}</td><td>（中継用）お知らせ文言３７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon38 ztyosirasemongon38}</td><td>（中継用）お知らせ文言３８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon39 ztyosirasemongon39}</td><td>（中継用）お知らせ文言３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon40 ztyosirasemongon40}</td><td>（中継用）お知らせ文言４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon41 ztyosirasemongon41}</td><td>（中継用）お知らせ文言４１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon42 ztyosirasemongon42}</td><td>（中継用）お知らせ文言４２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon43 ztyosirasemongon43}</td><td>（中継用）お知らせ文言４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon44 ztyosirasemongon44}</td><td>（中継用）お知らせ文言４４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon45 ztyosirasemongon45}</td><td>（中継用）お知らせ文言４５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon46 ztyosirasemongon46}</td><td>（中継用）お知らせ文言４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon47 ztyosirasemongon47}</td><td>（中継用）お知らせ文言４７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon48 ztyosirasemongon48}</td><td>（中継用）お知らせ文言４８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon49 ztyosirasemongon49}</td><td>（中継用）お知らせ文言４９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon50 ztyosirasemongon50}</td><td>（中継用）お知らせ文言５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosiraseinjihuyouhyouji ztyosiraseinjihuyouhyouji}</td><td>（中継用）お知らせ印字不要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv254 ztyyobiv254}</td><td>（中継用）予備項目Ｖ２５４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrnaiyouhskmongon1 ztyshrnaiyouhskmongon1}</td><td>（中継用）支払内容補足文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrnaiyouhskmongon2 ztyshrnaiyouhskmongon2}</td><td>（中継用）支払内容補足文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydocumentid ztydocumentid}</td><td>（中継用）ドキュメントＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysksmongonkbn1 ztysksmongonkbn1}</td><td>（中継用）請求書文言区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysksmongonkbn2 ztysksmongonkbn2}</td><td>（中継用）請求書文言区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoritugisyasyozokunm ztytoritugisyasyozokunm}</td><td>（中継用）取次者所属名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoritugisyakjncd ztytoritugisyakjncd}</td><td>（中継用）取次者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoritugisyanm ztytoritugisyanm}</td><td>（中継用）取次者氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhozonkkny ztyhozonkkny}</td><td>（中継用）保存期間（年）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsintelno ztytsintelno}</td><td>（中継用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkkbn1 ztytrkkzkkbn1}</td><td>（中継用）登録家族区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzknmkj1 ztytrkkzknmkj1}</td><td>（中継用）登録家族名（漢字）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkseiymd1zenkaku ztytrkkzkseiymd1zenkaku}</td><td>（中継用）登録家族１人目生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkyno1 ztytrkkzkyno1}</td><td>（中継用）登録家族郵便番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkadr1kj1 ztytrkkzkadr1kj1}</td><td>（中継用）登録家族住所１（漢字）１　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkadr2kj1 ztytrkkzkadr2kj1}</td><td>（中継用）登録家族住所２（漢字）１　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkadr3kj1 ztytrkkzkadr3kj1}</td><td>（中継用）登録家族住所３（漢字）１　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzktelno1 ztytrkkzktelno1}</td><td>（中継用）登録家族電話番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzktelnomtrkhyouji1 ztytrkkzktelnomtrkhyouji1}</td><td>（中継用）登録家族電話番号未登録表示１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkkbn2 ztytrkkzkkbn2}</td><td>（中継用）登録家族区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzknmkj2 ztytrkkzknmkj2}</td><td>（中継用）登録家族名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkseiymd2zenkaku ztytrkkzkseiymd2zenkaku}</td><td>（中継用）登録家族２人目生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkyno2 ztytrkkzkyno2}</td><td>（中継用）登録家族郵便番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkadr1kj2 ztytrkkzkadr1kj2}</td><td>（中継用）登録家族住所１（漢字）２　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkadr2kj2 ztytrkkzkadr2kj2}</td><td>（中継用）登録家族住所２（漢字）２　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkadr3kj2 ztytrkkzkadr3kj2}</td><td>（中継用）登録家族住所３（漢字）２　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzktelno2 ztytrkkzktelno2}</td><td>（中継用）登録家族電話番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdairinmkj ztykykdairinmkj}</td><td>（中継用）契約者代理人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykomttutkbn ztykykomttutkbn}</td><td>（中継用）契約者用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkomttutkbn1 ztykzkomttutkbn1}</td><td>（中継用）家族１用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkomttutkbn2 ztykzkomttutkbn2}</td><td>（中継用）家族２用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkomttutkbn ztyhhkomttutkbn}</td><td>（中継用）被保険者用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdromttutkbn ztyhhkdromttutkbn}</td><td>（中継用）被保険者代理人用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdairiomttutkbn ztykykdairiomttutkbn}</td><td>（中継用）契約者代理人用表通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykurtutkbn ztykykurtutkbn}</td><td>（中継用）契約者用裏通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkurtutkbn1 ztykzkurtutkbn1}</td><td>（中継用）家族１用裏通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkurtutkbn2 ztykzkurtutkbn2}</td><td>（中継用）家族２用裏通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdrurtutkbn ztyhhkdrurtutkbn}</td><td>（中継用）被保険者代理人用裏通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdairiurtutkbn ztykykdairiurtutkbn}</td><td>（中継用）契約者代理人用裏通知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykaistmsgkbn ztykykaistmsgkbn}</td><td>（中継用）契約者用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkaistmsgkbn1 ztykzkaistmsgkbn1}</td><td>（中継用）家族１用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkaistmsgkbn2 ztykzkaistmsgkbn2}</td><td>（中継用）家族２用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkaistmsgkbn ztyhhkaistmsgkbn}</td><td>（中継用）被保険者用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdraistmsgkbn ztyhhkdraistmsgkbn}</td><td>（中継用）被保険者代理人用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdairiaistmsgkbn ztykykdairiaistmsgkbn}</td><td>（中継用）契約者代理人用挨拶ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakujyokzknmkj ztysakujyokzknmkj}</td><td>（中継用）削除家族名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdknaiyoukbn ztyttdknaiyoukbn}</td><td>（中継用）手続内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktaisyoukykkbn ztykzktaisyoukykkbn}</td><td>（中継用）家族用対象契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdrtaisyoukykkbn ztyhhkdrtaisyoukykkbn}</td><td>（中継用）被保険者代理人用対象契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdairitaisyoukykkbn ztykykdairitaisyoukykkbn}</td><td>（中継用）契約者代理人用対象契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymoshnkniymsgkbn1 ztymoshnkniymsgkbn1}</td><td>（中継用）申込変更内容ＭＳＧ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmoshnkniymsg2 ztykykmoshnkniymsg2}</td><td>（中継用）契約者用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmoshnkniymsg21 ztykzkmoshnkniymsg21}</td><td>（中継用）家族１用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmoshnkniymsg22 ztykzkmoshnkniymsg22}</td><td>（中継用）家族２用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdrmoshnkniymsg2 ztyhhkdrmoshnkniymsg2}</td><td>（中継用）被保険者代理人用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdairimoshnkniymsg2 ztykykdairimoshnkniymsg2}</td><td>（中継用）契約者代理人用申込変更内容ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrmsgkbn ztykykdrmsgkbn}</td><td>（中継用）契約者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykhhkdrmsg ztykykhhkdrmsg}</td><td>（中継用）契約者用被保険者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkhhkdrmsg1 ztykzkhhkdrmsg1}</td><td>（中継用）家族１用被保険者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkhhkdrmsg2 ztykzkhhkdrmsg2}</td><td>（中継用）家族２用被保険者代理ＭＳＧ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdrnmkj ztyhhkdrnmkj}</td><td>（中継用）被保険者代理人名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduhubutumsg1 ztyduhubutumsg1}</td><td>（中継用）同封物ＭＳＧ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduhubutumsg2 ztyduhubutumsg2}</td><td>（中継用）同封物ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduhubutumsg3 ztyduhubutumsg3}</td><td>（中継用）同封物ＭＳＧ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduhubutumsg4 ztyduhubutumsg4}</td><td>（中継用）同封物ＭＳＧ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduhubutumsg5 ztyduhubutumsg5}</td><td>（中継用）同封物ＭＳＧ区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduhubutumsg6 ztyduhubutumsg6}</td><td>（中継用）同封物ＭＳＧ区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduhubutumsg7 ztyduhubutumsg7}</td><td>（中継用）同封物ＭＳＧ区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykigaidhbtmsg1 ztykykigaidhbtmsg1}</td><td>（中継用）契約者以外用同封物ＭＳＧ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykigaidhbtmsg2 ztykykigaidhbtmsg2}</td><td>（中継用）契約者以外用同封物ＭＳＧ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykigaidhbtmsg3 ztykykigaidhbtmsg3}</td><td>（中継用）契約者以外用同封物ＭＳＧ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykigaidhbtmsg4 ztykykigaidhbtmsg4}</td><td>（中継用）契約者以外用同封物ＭＳＧ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyakkankiyakuhunyuuhyouji ztyyakkankiyakuhunyuuhyouji}</td><td>（中継用）約款規約封入表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktrktrshuunyuuhyouji ztykyktrktrshuunyuuhyouji}</td><td>（中継用）登録チラシ封入表示（契）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktrktrshuunyuuhyouji1 ztykzktrktrshuunyuuhyouji1}</td><td>（中継用）登録チラシ封入表示（家族１）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktrktrshuunyuuhyouji2 ztykzktrktrshuunyuuhyouji2}</td><td>（中継用）登録チラシ封入表示（家族２）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrhuunyuuhyouji ztykykdrhuunyuuhyouji}</td><td>（中継用）契約者代理封入表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdrhuunyuuhyouji ztyhhkdrhuunyuuhyouji}</td><td>（中継用）被保険者代理封入表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdairinmkj2 ztykykdairinmkj2}</td><td>（中継用）契約者代理人名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrseiymd ztykykdrseiymd}</td><td>（中継用）契約者代理人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdryno ztykykdryno}</td><td>（中継用）契約者代理人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdradr1kj ztykykdradr1kj}</td><td>（中継用）契約者代理人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdradr2kj ztykykdradr2kj}</td><td>（中継用）契約者代理人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdradr3kj ztykykdradr3kj}</td><td>（中継用）契約者代理人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtelno ztykykdrtelno}</td><td>（中継用）契約者代理人電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdrnmkj2 ztyhhkdrnmkj2}</td><td>（中継用）被保険者代理人名（漢字）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdrseiymd ztyhhkdrseiymd}</td><td>（中継用）被保険者代理人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdryno ztyhhkdryno}</td><td>（中継用）被保険者代理人郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdradr1kj ztyhhkdradr1kj}</td><td>（中継用）被保険者代理人住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdradr2kj ztyhhkdradr2kj}</td><td>（中継用）被保険者代理人住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdradr3kj ztyhhkdradr3kj}</td><td>（中継用）被保険者代理人住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdrtelno ztyhhkdrtelno}</td><td>（中継用）被保険者代理人電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdrtelnomtrkhyouji ztyhhkdrtelnomtrkhyouji}</td><td>（中継用）被保険者代理人電話番号未登録表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyono2 ztykhsyono2}</td><td>（中継用）（契約保全）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyono3 ztykhsyono3}</td><td>（中継用）（契約保全）証券番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyono4 ztykhsyono4}</td><td>（中継用）（契約保全）証券番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyono5 ztykhsyono5}</td><td>（中継用）（契約保全）証券番号５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyono6 ztykhsyono6}</td><td>（中継用）（契約保全）証券番号６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyono7 ztykhsyono7}</td><td>（中継用）（契約保全）証券番号７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyono8 ztykhsyono8}</td><td>（中継用）（契約保全）証券番号８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyono9 ztykhsyono9}</td><td>（中継用）（契約保全）証券番号９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyono10 ztykhsyono10}</td><td>（中継用）（契約保全）証券番号１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhmosno1 ztykhmosno1}</td><td>（中継用）（契約保全）申込番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhmosno2 ztykhmosno2}</td><td>（中継用）（契約保全）申込番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhmosno3 ztykhmosno3}</td><td>（中継用）（契約保全）申込番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhmosno4 ztykhmosno4}</td><td>（中継用）（契約保全）申込番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhmosno5 ztykhmosno5}</td><td>（中継用）（契約保全）申込番号５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhmosno6 ztykhmosno6}</td><td>（中継用）（契約保全）申込番号６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhmosno7 ztykhmosno7}</td><td>（中継用）（契約保全）申込番号７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhmosno8 ztykhmosno8}</td><td>（中継用）（契約保全）申込番号８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhmosno9 ztykhmosno9}</td><td>（中継用）（契約保全）申込番号９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhmosno10 ztykhmosno10}</td><td>（中継用）（契約保全）申込番号１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnsnhutouhuunyuuhyouji ztyhnsnhutouhuunyuuhyouji}</td><td>（中継用）返信用封筒封入表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv204 ztyyobiv204}</td><td>（中継用）予備項目Ｖ２０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv255x2 ztyyobiv255x2}</td><td>（中継用）予備項目Ｖ２５５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv255x3 ztyyobiv255x3}</td><td>（中継用）予備項目Ｖ２５５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv255x4 ztyyobiv255x4}</td><td>（中継用）予備項目Ｖ２５５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv141 ztyyobiv141}</td><td>（中継用）予備項目Ｖ１４１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanTy
 * @see     PKZT_TtdkKanTy
 * @see     QZT_TtdkKanTy
 * @see     GenQZT_TtdkKanTy
 */
@MappedSuperclass
@Table(name=GenZT_TtdkKanTy.TABLE_NAME)
@IdClass(value=PKZT_TtdkKanTy.class)
public abstract class GenZT_TtdkKanTy extends AbstractExDBEntity<ZT_TtdkKanTy, PKZT_TtdkKanTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TtdkKanTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYTYOUHYOUYMDWA         = "ztytyouhyouymdwa";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYTANTOUSITUKBN         = "ztytantousitukbn";
    public static final String ZTYSYODOUHUUKBN          = "ztysyodouhuukbn";
    public static final String ZTYSIKIBETUNO            = "ztysikibetuno";
    public static final String ZTYYOBIV21               = "ztyyobiv21";
    public static final String ZTYSHSKYNO               = "ztyshskyno";
    public static final String ZTYSHSKADR1KJ            = "ztyshskadr1kj";
    public static final String ZTYSHSKADR2KJ            = "ztyshskadr2kj";
    public static final String ZTYSHSKADR3KJ            = "ztyshskadr3kj";
    public static final String ZTYSHSNMKJTTDK           = "ztyshsnmkjttdk";
    public static final String ZTYSHSNMKJTTDK2          = "ztyshsnmkjttdk2";
    public static final String ZTYYOBIV3                = "ztyyobiv3";
    public static final String ZTYTAWYNO                = "ztytawyno";
    public static final String ZTYTAWADR1KJ             = "ztytawadr1kj";
    public static final String ZTYTAWADR2KJ             = "ztytawadr2kj";
    public static final String ZTYTOIAWASEKAISYANMKJ    = "ztytoiawasekaisyanmkj";
    public static final String ZTYTAWSOSIKIKJ           = "ztytawsosikikj";
    public static final String ZTYTAWTELNOV14           = "ztytawtelnov14";
    public static final String ZTYTAWTELUKTKKANOU1X18KETA = "ztytawteluktkkanou1x18keta";
    public static final String ZTYTAWTELUKTKKANOU2X18KETA = "ztytawteluktkkanou2x18keta";
    public static final String ZTYYOBIV26               = "ztyyobiv26";
    public static final String ZTYTETUDUKISYUNM         = "ztytetudukisyunm";
    public static final String ZTYSYOKAKMNGNUMKBN       = "ztysyokakmngnumkbn";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYKYKNMKJ               = "ztykyknmkj";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYYOBIV28               = "ztyyobiv28";
    public static final String ZTYTTDKNAIYOU1           = "ztyttdknaiyou1";
    public static final String ZTYTTDKNAIYOU2           = "ztyttdknaiyou2";
    public static final String ZTYTTDKNAIYOU3           = "ztyttdknaiyou3";
    public static final String ZTYTTDKNAIYOU4           = "ztyttdknaiyou4";
    public static final String ZTYTTDKNAIYOU5           = "ztyttdknaiyou5";
    public static final String ZTYTTDKNAIYOU6           = "ztyttdknaiyou6";
    public static final String ZTYTTDKNAIYOU7           = "ztyttdknaiyou7";
    public static final String ZTYTTDKNAIYOU8           = "ztyttdknaiyou8";
    public static final String ZTYTTDKNAIYOU9           = "ztyttdknaiyou9";
    public static final String ZTYTTDKNAIYOU10          = "ztyttdknaiyou10";
    public static final String ZTYTTDKNAIYOUUMUKBN      = "ztyttdknaiyouumukbn";
    public static final String ZTYKYKNIYUHNKKBN         = "ztykykniyuhnkkbn";
    public static final String ZTYKYKNIYUHNKYMD         = "ztykykniyuhnkymd";
    public static final String ZTYKYKNIYUHNKINFO        = "ztykykniyuhnkinfo";
    public static final String ZTYKYKNIYUHNKKNGKHUGOU1  = "ztykykniyuhnkkngkhugou1";
    public static final String ZTYKYKNIYUHNKKNGK1       = "ztykykniyuhnkkngk1";
    public static final String ZTYKYKNIYUHNKKNGKTUKSYU1 = "ztykykniyuhnkkngktuksyu1";
    public static final String ZTYKYKNIYUHNKKNGKHUGOU2  = "ztykykniyuhnkkngkhugou2";
    public static final String ZTYKYKNIYUHNKKNGK2       = "ztykykniyuhnkkngk2";
    public static final String ZTYKYKNIYUHNKKNGKTUKSYU2 = "ztykykniyuhnkkngktuksyu2";
    public static final String ZTYYOBIV102              = "ztyyobiv102";
    public static final String ZTYSIHARAIBIWAREKI       = "ztysiharaibiwareki";
    public static final String ZTYKAIYAKUYMDWA          = "ztykaiyakuymdwa";
    public static final String ZTYTEKIYOU1              = "ztytekiyou1";
    public static final String ZTYSHRKNGKMEISAIHUGOU1   = "ztyshrkngkmeisaihugou1";
    public static final String ZTYSHRGKMEISAI1          = "ztyshrgkmeisai1";
    public static final String ZTYSHRGKTUUKASYU1        = "ztyshrgktuukasyu1";
    public static final String ZTYBIKOU1                = "ztybikou1";
    public static final String ZTYTEKIYOU2              = "ztytekiyou2";
    public static final String ZTYSHRKNGKMEISAIHUGOU2   = "ztyshrkngkmeisaihugou2";
    public static final String ZTYSHRGKMEISAI2          = "ztyshrgkmeisai2";
    public static final String ZTYSHRGKTUUKASYU2        = "ztyshrgktuukasyu2";
    public static final String ZTYBIKOU2                = "ztybikou2";
    public static final String ZTYTEKIYOU3              = "ztytekiyou3";
    public static final String ZTYSHRKNGKMEISAIHUGOU3   = "ztyshrkngkmeisaihugou3";
    public static final String ZTYSHRGKMEISAI3          = "ztyshrgkmeisai3";
    public static final String ZTYSHRGKTUUKASYU3        = "ztyshrgktuukasyu3";
    public static final String ZTYBIKOU3                = "ztybikou3";
    public static final String ZTYTEKIYOU4              = "ztytekiyou4";
    public static final String ZTYSHRKNGKMEISAIHUGOU4   = "ztyshrkngkmeisaihugou4";
    public static final String ZTYSHRGKMEISAI4          = "ztyshrgkmeisai4";
    public static final String ZTYSHRGKTUUKASYU4        = "ztyshrgktuukasyu4";
    public static final String ZTYBIKOU4                = "ztybikou4";
    public static final String ZTYTEKIYOU5              = "ztytekiyou5";
    public static final String ZTYSHRKNGKMEISAIHUGOU5   = "ztyshrkngkmeisaihugou5";
    public static final String ZTYSHRGKMEISAI5          = "ztyshrgkmeisai5";
    public static final String ZTYSHRGKTUUKASYU5        = "ztyshrgktuukasyu5";
    public static final String ZTYBIKOU5                = "ztybikou5";
    public static final String ZTYTEKIYOU6              = "ztytekiyou6";
    public static final String ZTYSHRKNGKMEISAIHUGOU6   = "ztyshrkngkmeisaihugou6";
    public static final String ZTYSHRGKMEISAI6          = "ztyshrgkmeisai6";
    public static final String ZTYSHRGKTUUKASYU6        = "ztyshrgktuukasyu6";
    public static final String ZTYBIKOU6                = "ztybikou6";
    public static final String ZTYTEKIYOU7              = "ztytekiyou7";
    public static final String ZTYSHRKNGKMEISAIHUGOU7   = "ztyshrkngkmeisaihugou7";
    public static final String ZTYSHRGKMEISAI7          = "ztyshrgkmeisai7";
    public static final String ZTYSHRGKTUUKASYU7        = "ztyshrgktuukasyu7";
    public static final String ZTYBIKOU7                = "ztybikou7";
    public static final String ZTYTEKIYOU8              = "ztytekiyou8";
    public static final String ZTYSHRKNGKMEISAIHUGOU8   = "ztyshrkngkmeisaihugou8";
    public static final String ZTYSHRGKMEISAI8          = "ztyshrgkmeisai8";
    public static final String ZTYSHRGKTUUKASYU8        = "ztyshrgktuukasyu8";
    public static final String ZTYBIKOU8                = "ztybikou8";
    public static final String ZTYTEKIYOU9              = "ztytekiyou9";
    public static final String ZTYSHRKNGKMEISAIHUGOU9   = "ztyshrkngkmeisaihugou9";
    public static final String ZTYSHRGKMEISAI9          = "ztyshrgkmeisai9";
    public static final String ZTYSHRGKTUUKASYU9        = "ztyshrgktuukasyu9";
    public static final String ZTYBIKOU9                = "ztybikou9";
    public static final String ZTYTEKIYOU10             = "ztytekiyou10";
    public static final String ZTYSHRKNGKMEISAIHUGOU10  = "ztyshrkngkmeisaihugou10";
    public static final String ZTYSHRGKMEISAI10         = "ztyshrgkmeisai10";
    public static final String ZTYSHRGKTUUKASYU10       = "ztyshrgktuukasyu10";
    public static final String ZTYBIKOU10               = "ztybikou10";
    public static final String ZTYSHRGKGOUKEI           = "ztyshrgkgoukei";
    public static final String ZTYSHRTUUKASYU           = "ztyshrtuukasyu";
    public static final String ZTYDSEISANSHRTTDKNM      = "ztydseisanshrttdknm";
    public static final String ZTYYOBIV26X3             = "ztyyobiv26x3";
    public static final String ZTYBANKNMKJ              = "ztybanknmkj";
    public static final String ZTYSITENNMKJ             = "ztysitennmkj";
    public static final String ZTYYOKINKBN              = "ztyyokinkbn";
    public static final String ZTYKOUZANO12KETA         = "ztykouzano12keta";
    public static final String ZTYKZMEIGINMKNHAN        = "ztykzmeiginmknhan";
    public static final String ZTYKOUZASYURUIKBN        = "ztykouzasyuruikbn";
    public static final String ZTYYOBIV26X2             = "ztyyobiv26x2";
    public static final String ZTYSYNYKNGK              = "ztysynykngk";
    public static final String ZTYSYNYKNGKTUUKASYU      = "ztysynykngktuukasyu";
    public static final String ZTYHTYKEIHI              = "ztyhtykeihi";
    public static final String ZTYHTYKEIHITUUKASYU      = "ztyhtykeihituukasyu";
    public static final String ZTYSHRKYKSYAHTYKEIHI     = "ztyshrkyksyahtykeihi";
    public static final String ZTYSHRKYKHTYKEIHITUUKASYU = "ztyshrkykhtykeihituukasyu";
    public static final String ZTYGSBNRKZTHTYKEIHI      = "ztygsbnrkzthtykeihi";
    public static final String ZTYGSBNRKZTHTYKEIHITUKSYU = "ztygsbnrkzthtykeihituksyu";
    public static final String ZTYGSBNRKZTSAEKI         = "ztygsbnrkztsaeki";
    public static final String ZTYGSBNRKZTSAEKITUKSYU   = "ztygsbnrkztsaekituksyu";
    public static final String ZTYZEIMUNAIYOUHENSYUCTRLKBN = "ztyzeimunaiyouhensyuctrlkbn";
    public static final String ZTYZEIMUMONGONOUTKBN     = "ztyzeimumongonoutkbn";
    public static final String ZTYZEIMUMONGON1          = "ztyzeimumongon1";
    public static final String ZTYZEIMUMONGON2          = "ztyzeimumongon2";
    public static final String ZTYZEIMUMONGON3          = "ztyzeimumongon3";
    public static final String ZTYZEIMUMONGON4          = "ztyzeimumongon4";
    public static final String ZTYZEIMUMONGON5          = "ztyzeimumongon5";
    public static final String ZTYYENDTHNKZEIMUINFOHSKKBN = "ztyyendthnkzeimuinfohskkbn";
    public static final String ZTYYOBIV36               = "ztyyobiv36";
    public static final String ZTYOSIRASEHYOUDAI        = "ztyosirasehyoudai";
    public static final String ZTYOSIRASEMONGON1        = "ztyosirasemongon1";
    public static final String ZTYOSIRASEMONGON2        = "ztyosirasemongon2";
    public static final String ZTYOSIRASEMONGON3        = "ztyosirasemongon3";
    public static final String ZTYOSIRASEMONGON4        = "ztyosirasemongon4";
    public static final String ZTYOSIRASEMONGON5        = "ztyosirasemongon5";
    public static final String ZTYOSIRASEMONGON6        = "ztyosirasemongon6";
    public static final String ZTYOSIRASEMONGON7        = "ztyosirasemongon7";
    public static final String ZTYOSIRASEMONGON8        = "ztyosirasemongon8";
    public static final String ZTYOSIRASEMONGON9        = "ztyosirasemongon9";
    public static final String ZTYOSIRASEMONGON10       = "ztyosirasemongon10";
    public static final String ZTYOSIRASEMONGON11       = "ztyosirasemongon11";
    public static final String ZTYOSIRASEMONGON12       = "ztyosirasemongon12";
    public static final String ZTYOSIRASEMONGON13       = "ztyosirasemongon13";
    public static final String ZTYOSIRASEMONGON14       = "ztyosirasemongon14";
    public static final String ZTYOSIRASEMONGON15       = "ztyosirasemongon15";
    public static final String ZTYOSIRASEMONGON16       = "ztyosirasemongon16";
    public static final String ZTYOSIRASEMONGON17       = "ztyosirasemongon17";
    public static final String ZTYOSIRASEMONGON18       = "ztyosirasemongon18";
    public static final String ZTYOSIRASEMONGON19       = "ztyosirasemongon19";
    public static final String ZTYOSIRASEMONGON20       = "ztyosirasemongon20";
    public static final String ZTYOSIRASEMONGON21       = "ztyosirasemongon21";
    public static final String ZTYOSIRASEMONGON22       = "ztyosirasemongon22";
    public static final String ZTYOSIRASEMONGON23       = "ztyosirasemongon23";
    public static final String ZTYOSIRASEMONGON24       = "ztyosirasemongon24";
    public static final String ZTYOSIRASEMONGON25       = "ztyosirasemongon25";
    public static final String ZTYOSIRASEMONGON26       = "ztyosirasemongon26";
    public static final String ZTYOSIRASEMONGON27       = "ztyosirasemongon27";
    public static final String ZTYOSIRASEMONGON28       = "ztyosirasemongon28";
    public static final String ZTYOSIRASEMONGON29       = "ztyosirasemongon29";
    public static final String ZTYOSIRASEMONGON30       = "ztyosirasemongon30";
    public static final String ZTYOSIRASEMONGON31       = "ztyosirasemongon31";
    public static final String ZTYOSIRASEMONGON32       = "ztyosirasemongon32";
    public static final String ZTYOSIRASEMONGON33       = "ztyosirasemongon33";
    public static final String ZTYOSIRASEMONGON34       = "ztyosirasemongon34";
    public static final String ZTYOSIRASEMONGON35       = "ztyosirasemongon35";
    public static final String ZTYOSIRASEMONGON36       = "ztyosirasemongon36";
    public static final String ZTYOSIRASEMONGON37       = "ztyosirasemongon37";
    public static final String ZTYOSIRASEMONGON38       = "ztyosirasemongon38";
    public static final String ZTYOSIRASEMONGON39       = "ztyosirasemongon39";
    public static final String ZTYOSIRASEMONGON40       = "ztyosirasemongon40";
    public static final String ZTYOSIRASEMONGON41       = "ztyosirasemongon41";
    public static final String ZTYOSIRASEMONGON42       = "ztyosirasemongon42";
    public static final String ZTYOSIRASEMONGON43       = "ztyosirasemongon43";
    public static final String ZTYOSIRASEMONGON44       = "ztyosirasemongon44";
    public static final String ZTYOSIRASEMONGON45       = "ztyosirasemongon45";
    public static final String ZTYOSIRASEMONGON46       = "ztyosirasemongon46";
    public static final String ZTYOSIRASEMONGON47       = "ztyosirasemongon47";
    public static final String ZTYOSIRASEMONGON48       = "ztyosirasemongon48";
    public static final String ZTYOSIRASEMONGON49       = "ztyosirasemongon49";
    public static final String ZTYOSIRASEMONGON50       = "ztyosirasemongon50";
    public static final String ZTYOSIRASEINJIHUYOUHYOUJI = "ztyosiraseinjihuyouhyouji";
    public static final String ZTYYOBIV254              = "ztyyobiv254";
    public static final String ZTYSHRNAIYOUHSKMONGON1   = "ztyshrnaiyouhskmongon1";
    public static final String ZTYSHRNAIYOUHSKMONGON2   = "ztyshrnaiyouhskmongon2";
    public static final String ZTYDOCUMENTID            = "ztydocumentid";
    public static final String ZTYSKSMONGONKBN1         = "ztysksmongonkbn1";
    public static final String ZTYSKSMONGONKBN2         = "ztysksmongonkbn2";
    public static final String ZTYTORITUGISYASYOZOKUNM  = "ztytoritugisyasyozokunm";
    public static final String ZTYTORITUGISYAKJNCD      = "ztytoritugisyakjncd";
    public static final String ZTYTORITUGISYANM         = "ztytoritugisyanm";
    public static final String ZTYHOZONKKNY             = "ztyhozonkkny";
    public static final String ZTYTSINTELNO             = "ztytsintelno";
    public static final String ZTYTRKKZKKBN1            = "ztytrkkzkkbn1";
    public static final String ZTYTRKKZKNMKJ1           = "ztytrkkzknmkj1";
    public static final String ZTYTRKKZKSEIYMD1ZENKAKU  = "ztytrkkzkseiymd1zenkaku";
    public static final String ZTYTRKKZKYNO1            = "ztytrkkzkyno1";
    public static final String ZTYTRKKZKADR1KJ1         = "ztytrkkzkadr1kj1";
    public static final String ZTYTRKKZKADR2KJ1         = "ztytrkkzkadr2kj1";
    public static final String ZTYTRKKZKADR3KJ1         = "ztytrkkzkadr3kj1";
    public static final String ZTYTRKKZKTELNO1          = "ztytrkkzktelno1";
    public static final String ZTYTRKKZKTELNOMTRKHYOUJI1 = "ztytrkkzktelnomtrkhyouji1";
    public static final String ZTYTRKKZKKBN2            = "ztytrkkzkkbn2";
    public static final String ZTYTRKKZKNMKJ2           = "ztytrkkzknmkj2";
    public static final String ZTYTRKKZKSEIYMD2ZENKAKU  = "ztytrkkzkseiymd2zenkaku";
    public static final String ZTYTRKKZKYNO2            = "ztytrkkzkyno2";
    public static final String ZTYTRKKZKADR1KJ2         = "ztytrkkzkadr1kj2";
    public static final String ZTYTRKKZKADR2KJ2         = "ztytrkkzkadr2kj2";
    public static final String ZTYTRKKZKADR3KJ2         = "ztytrkkzkadr3kj2";
    public static final String ZTYTRKKZKTELNO2          = "ztytrkkzktelno2";
    public static final String ZTYKYKDAIRINMKJ          = "ztykykdairinmkj";
    public static final String ZTYKYKOMTTUTKBN          = "ztykykomttutkbn";
    public static final String ZTYKZKOMTTUTKBN1         = "ztykzkomttutkbn1";
    public static final String ZTYKZKOMTTUTKBN2         = "ztykzkomttutkbn2";
    public static final String ZTYHHKOMTTUTKBN          = "ztyhhkomttutkbn";
    public static final String ZTYHHKDROMTTUTKBN        = "ztyhhkdromttutkbn";
    public static final String ZTYKYKDAIRIOMTTUTKBN     = "ztykykdairiomttutkbn";
    public static final String ZTYKYKURTUTKBN           = "ztykykurtutkbn";
    public static final String ZTYKZKURTUTKBN1          = "ztykzkurtutkbn1";
    public static final String ZTYKZKURTUTKBN2          = "ztykzkurtutkbn2";
    public static final String ZTYHHKDRURTUTKBN         = "ztyhhkdrurtutkbn";
    public static final String ZTYKYKDAIRIURTUTKBN      = "ztykykdairiurtutkbn";
    public static final String ZTYKYKAISTMSGKBN         = "ztykykaistmsgkbn";
    public static final String ZTYKZKAISTMSGKBN1        = "ztykzkaistmsgkbn1";
    public static final String ZTYKZKAISTMSGKBN2        = "ztykzkaistmsgkbn2";
    public static final String ZTYHHKAISTMSGKBN         = "ztyhhkaistmsgkbn";
    public static final String ZTYHHKDRAISTMSGKBN       = "ztyhhkdraistmsgkbn";
    public static final String ZTYKYKDAIRIAISTMSGKBN    = "ztykykdairiaistmsgkbn";
    public static final String ZTYSAKUJYOKZKNMKJ        = "ztysakujyokzknmkj";
    public static final String ZTYTTDKNAIYOUKBN         = "ztyttdknaiyoukbn";
    public static final String ZTYKZKTAISYOUKYKKBN      = "ztykzktaisyoukykkbn";
    public static final String ZTYHHKDRTAISYOUKYKKBN    = "ztyhhkdrtaisyoukykkbn";
    public static final String ZTYKYKDAIRITAISYOUKYKKBN = "ztykykdairitaisyoukykkbn";
    public static final String ZTYMOSHNKNIYMSGKBN1      = "ztymoshnkniymsgkbn1";
    public static final String ZTYKYKMOSHNKNIYMSG2      = "ztykykmoshnkniymsg2";
    public static final String ZTYKZKMOSHNKNIYMSG21     = "ztykzkmoshnkniymsg21";
    public static final String ZTYKZKMOSHNKNIYMSG22     = "ztykzkmoshnkniymsg22";
    public static final String ZTYHHKDRMOSHNKNIYMSG2    = "ztyhhkdrmoshnkniymsg2";
    public static final String ZTYKYKDAIRIMOSHNKNIYMSG2 = "ztykykdairimoshnkniymsg2";
    public static final String ZTYKYKDRMSGKBN           = "ztykykdrmsgkbn";
    public static final String ZTYKYKHHKDRMSG           = "ztykykhhkdrmsg";
    public static final String ZTYKZKHHKDRMSG1          = "ztykzkhhkdrmsg1";
    public static final String ZTYKZKHHKDRMSG2          = "ztykzkhhkdrmsg2";
    public static final String ZTYHHKDRNMKJ             = "ztyhhkdrnmkj";
    public static final String ZTYDUHUBUTUMSG1          = "ztyduhubutumsg1";
    public static final String ZTYDUHUBUTUMSG2          = "ztyduhubutumsg2";
    public static final String ZTYDUHUBUTUMSG3          = "ztyduhubutumsg3";
    public static final String ZTYDUHUBUTUMSG4          = "ztyduhubutumsg4";
    public static final String ZTYDUHUBUTUMSG5          = "ztyduhubutumsg5";
    public static final String ZTYDUHUBUTUMSG6          = "ztyduhubutumsg6";
    public static final String ZTYDUHUBUTUMSG7          = "ztyduhubutumsg7";
    public static final String ZTYKYKIGAIDHBTMSG1       = "ztykykigaidhbtmsg1";
    public static final String ZTYKYKIGAIDHBTMSG2       = "ztykykigaidhbtmsg2";
    public static final String ZTYKYKIGAIDHBTMSG3       = "ztykykigaidhbtmsg3";
    public static final String ZTYKYKIGAIDHBTMSG4       = "ztykykigaidhbtmsg4";
    public static final String ZTYYAKKANKIYAKUHUNYUUHYOUJI = "ztyyakkankiyakuhunyuuhyouji";
    public static final String ZTYKYKTRKTRSHUUNYUUHYOUJI = "ztykyktrktrshuunyuuhyouji";
    public static final String ZTYKZKTRKTRSHUUNYUUHYOUJI1 = "ztykzktrktrshuunyuuhyouji1";
    public static final String ZTYKZKTRKTRSHUUNYUUHYOUJI2 = "ztykzktrktrshuunyuuhyouji2";
    public static final String ZTYKYKDRHUUNYUUHYOUJI    = "ztykykdrhuunyuuhyouji";
    public static final String ZTYHHKDRHUUNYUUHYOUJI    = "ztyhhkdrhuunyuuhyouji";
    public static final String ZTYKYKDAIRINMKJ2         = "ztykykdairinmkj2";
    public static final String ZTYKYKDRSEIYMD           = "ztykykdrseiymd";
    public static final String ZTYKYKDRYNO              = "ztykykdryno";
    public static final String ZTYKYKDRADR1KJ           = "ztykykdradr1kj";
    public static final String ZTYKYKDRADR2KJ           = "ztykykdradr2kj";
    public static final String ZTYKYKDRADR3KJ           = "ztykykdradr3kj";
    public static final String ZTYKYKDRTELNO            = "ztykykdrtelno";
    public static final String ZTYHHKDRNMKJ2            = "ztyhhkdrnmkj2";
    public static final String ZTYHHKDRSEIYMD           = "ztyhhkdrseiymd";
    public static final String ZTYHHKDRYNO              = "ztyhhkdryno";
    public static final String ZTYHHKDRADR1KJ           = "ztyhhkdradr1kj";
    public static final String ZTYHHKDRADR2KJ           = "ztyhhkdradr2kj";
    public static final String ZTYHHKDRADR3KJ           = "ztyhhkdradr3kj";
    public static final String ZTYHHKDRTELNO            = "ztyhhkdrtelno";
    public static final String ZTYHHKDRTELNOMTRKHYOUJI  = "ztyhhkdrtelnomtrkhyouji";
    public static final String ZTYKHSYONO2              = "ztykhsyono2";
    public static final String ZTYKHSYONO3              = "ztykhsyono3";
    public static final String ZTYKHSYONO4              = "ztykhsyono4";
    public static final String ZTYKHSYONO5              = "ztykhsyono5";
    public static final String ZTYKHSYONO6              = "ztykhsyono6";
    public static final String ZTYKHSYONO7              = "ztykhsyono7";
    public static final String ZTYKHSYONO8              = "ztykhsyono8";
    public static final String ZTYKHSYONO9              = "ztykhsyono9";
    public static final String ZTYKHSYONO10             = "ztykhsyono10";
    public static final String ZTYKHMOSNO1              = "ztykhmosno1";
    public static final String ZTYKHMOSNO2              = "ztykhmosno2";
    public static final String ZTYKHMOSNO3              = "ztykhmosno3";
    public static final String ZTYKHMOSNO4              = "ztykhmosno4";
    public static final String ZTYKHMOSNO5              = "ztykhmosno5";
    public static final String ZTYKHMOSNO6              = "ztykhmosno6";
    public static final String ZTYKHMOSNO7              = "ztykhmosno7";
    public static final String ZTYKHMOSNO8              = "ztykhmosno8";
    public static final String ZTYKHMOSNO9              = "ztykhmosno9";
    public static final String ZTYKHMOSNO10             = "ztykhmosno10";
    public static final String ZTYHNSNHUTOUHUUNYUUHYOUJI = "ztyhnsnhutouhuunyuuhyouji";
    public static final String ZTYYOBIV204              = "ztyyobiv204";
    public static final String ZTYYOBIV255X2            = "ztyyobiv255x2";
    public static final String ZTYYOBIV255X3            = "ztyyobiv255x3";
    public static final String ZTYYOBIV255X4            = "ztyyobiv255x4";
    public static final String ZTYYOBIV141              = "ztyyobiv141";

    private final PKZT_TtdkKanTy primaryKey;

    public GenZT_TtdkKanTy() {
        primaryKey = new PKZT_TtdkKanTy();
    }

    public GenZT_TtdkKanTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        primaryKey = new PKZT_TtdkKanTy(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_TtdkKanTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TtdkKanTy> getMetaClass() {
        return QZT_TtdkKanTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_TtdkKanTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_TtdkKanTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    private String ztytyouhyouymdwa;

    @Column(name=GenZT_TtdkKanTy.ZTYTYOUHYOUYMDWA)
    public String getZtytyouhyouymdwa() {
        return ztytyouhyouymdwa;
    }

    public void setZtytyouhyouymdwa(String pZtytyouhyouymdwa) {
        ztytyouhyouymdwa = pZtytyouhyouymdwa;
    }

    @Id
    @Column(name=GenZT_TtdkKanTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_TtdkKanTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztytantousitukbn;

    @Column(name=GenZT_TtdkKanTy.ZTYTANTOUSITUKBN)
    public String getZtytantousitukbn() {
        return ztytantousitukbn;
    }

    public void setZtytantousitukbn(String pZtytantousitukbn) {
        ztytantousitukbn = pZtytantousitukbn;
    }

    private String ztysyodouhuukbn;

    @Column(name=GenZT_TtdkKanTy.ZTYSYODOUHUUKBN)
    public String getZtysyodouhuukbn() {
        return ztysyodouhuukbn;
    }

    public void setZtysyodouhuukbn(String pZtysyodouhuukbn) {
        ztysyodouhuukbn = pZtysyodouhuukbn;
    }

    @Id
    @Column(name=GenZT_TtdkKanTy.ZTYSIKIBETUNO)
    public String getZtysikibetuno() {
        return getPrimaryKey().getZtysikibetuno();
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        getPrimaryKey().setZtysikibetuno(pZtysikibetuno);
    }

    private String ztyyobiv21;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV21)
    public String getZtyyobiv21() {
        return ztyyobiv21;
    }

    public void setZtyyobiv21(String pZtyyobiv21) {
        ztyyobiv21 = pZtyyobiv21;
    }

    private String ztyshskyno;

    @Column(name=GenZT_TtdkKanTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_TtdkKanTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_TtdkKanTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_TtdkKanTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkjttdk;

    @Column(name=GenZT_TtdkKanTy.ZTYSHSNMKJTTDK)
    public String getZtyshsnmkjttdk() {
        return ztyshsnmkjttdk;
    }

    public void setZtyshsnmkjttdk(String pZtyshsnmkjttdk) {
        ztyshsnmkjttdk = pZtyshsnmkjttdk;
    }

    private String ztyshsnmkjttdk2;

    @Column(name=GenZT_TtdkKanTy.ZTYSHSNMKJTTDK2)
    public String getZtyshsnmkjttdk2() {
        return ztyshsnmkjttdk2;
    }

    @DataConvert("toMultiByte")
    public void setZtyshsnmkjttdk2(String pZtyshsnmkjttdk2) {
        ztyshsnmkjttdk2 = pZtyshsnmkjttdk2;
    }

    private String ztyyobiv3;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private String ztytawyno;

    @Column(name=GenZT_TtdkKanTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_TtdkKanTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_TtdkKanTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytoiawasekaisyanmkj;

    @Column(name=GenZT_TtdkKanTy.ZTYTOIAWASEKAISYANMKJ)
    public String getZtytoiawasekaisyanmkj() {
        return ztytoiawasekaisyanmkj;
    }

    public void setZtytoiawasekaisyanmkj(String pZtytoiawasekaisyanmkj) {
        ztytoiawasekaisyanmkj = pZtytoiawasekaisyanmkj;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_TtdkKanTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawtelnov14;

    @Column(name=GenZT_TtdkKanTy.ZTYTAWTELNOV14)
    public String getZtytawtelnov14() {
        return ztytawtelnov14;
    }

    public void setZtytawtelnov14(String pZtytawtelnov14) {
        ztytawtelnov14 = pZtytawtelnov14;
    }

    private String ztytawteluktkkanou1x18keta;

    @Column(name=GenZT_TtdkKanTy.ZTYTAWTELUKTKKANOU1X18KETA)
    public String getZtytawteluktkkanou1x18keta() {
        return ztytawteluktkkanou1x18keta;
    }

    public void setZtytawteluktkkanou1x18keta(String pZtytawteluktkkanou1x18keta) {
        ztytawteluktkkanou1x18keta = pZtytawteluktkkanou1x18keta;
    }

    private String ztytawteluktkkanou2x18keta;

    @Column(name=GenZT_TtdkKanTy.ZTYTAWTELUKTKKANOU2X18KETA)
    public String getZtytawteluktkkanou2x18keta() {
        return ztytawteluktkkanou2x18keta;
    }

    public void setZtytawteluktkkanou2x18keta(String pZtytawteluktkkanou2x18keta) {
        ztytawteluktkkanou2x18keta = pZtytawteluktkkanou2x18keta;
    }

    private String ztyyobiv26;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV26)
    public String getZtyyobiv26() {
        return ztyyobiv26;
    }

    public void setZtyyobiv26(String pZtyyobiv26) {
        ztyyobiv26 = pZtyyobiv26;
    }

    private String ztytetudukisyunm;

    @Column(name=GenZT_TtdkKanTy.ZTYTETUDUKISYUNM)
    public String getZtytetudukisyunm() {
        return ztytetudukisyunm;
    }

    public void setZtytetudukisyunm(String pZtytetudukisyunm) {
        ztytetudukisyunm = pZtytetudukisyunm;
    }

    private String ztysyokakmngnumkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYSYOKAKMNGNUMKBN)
    public String getZtysyokakmngnumkbn() {
        return ztysyokakmngnumkbn;
    }

    public void setZtysyokakmngnumkbn(String pZtysyokakmngnumkbn) {
        ztysyokakmngnumkbn = pZtysyokakmngnumkbn;
    }

    private String ztysyono2;

    @Column(name=GenZT_TtdkKanTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztykyknmkj;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKNMKJ)
    public String getZtykyknmkj() {
        return ztykyknmkj;
    }

    public void setZtykyknmkj(String pZtykyknmkj) {
        ztykyknmkj = pZtykyknmkj;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztyyobiv28;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV28)
    public String getZtyyobiv28() {
        return ztyyobiv28;
    }

    public void setZtyyobiv28(String pZtyyobiv28) {
        ztyyobiv28 = pZtyyobiv28;
    }

    private String ztyttdknaiyou1;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOU1)
    public String getZtyttdknaiyou1() {
        return ztyttdknaiyou1;
    }

    public void setZtyttdknaiyou1(String pZtyttdknaiyou1) {
        ztyttdknaiyou1 = pZtyttdknaiyou1;
    }

    private String ztyttdknaiyou2;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOU2)
    public String getZtyttdknaiyou2() {
        return ztyttdknaiyou2;
    }

    public void setZtyttdknaiyou2(String pZtyttdknaiyou2) {
        ztyttdknaiyou2 = pZtyttdknaiyou2;
    }

    private String ztyttdknaiyou3;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOU3)
    public String getZtyttdknaiyou3() {
        return ztyttdknaiyou3;
    }

    public void setZtyttdknaiyou3(String pZtyttdknaiyou3) {
        ztyttdknaiyou3 = pZtyttdknaiyou3;
    }

    private String ztyttdknaiyou4;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOU4)
    public String getZtyttdknaiyou4() {
        return ztyttdknaiyou4;
    }

    public void setZtyttdknaiyou4(String pZtyttdknaiyou4) {
        ztyttdknaiyou4 = pZtyttdknaiyou4;
    }

    private String ztyttdknaiyou5;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOU5)
    public String getZtyttdknaiyou5() {
        return ztyttdknaiyou5;
    }

    public void setZtyttdknaiyou5(String pZtyttdknaiyou5) {
        ztyttdknaiyou5 = pZtyttdknaiyou5;
    }

    private String ztyttdknaiyou6;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOU6)
    public String getZtyttdknaiyou6() {
        return ztyttdknaiyou6;
    }

    public void setZtyttdknaiyou6(String pZtyttdknaiyou6) {
        ztyttdknaiyou6 = pZtyttdknaiyou6;
    }

    private String ztyttdknaiyou7;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOU7)
    public String getZtyttdknaiyou7() {
        return ztyttdknaiyou7;
    }

    public void setZtyttdknaiyou7(String pZtyttdknaiyou7) {
        ztyttdknaiyou7 = pZtyttdknaiyou7;
    }

    private String ztyttdknaiyou8;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOU8)
    public String getZtyttdknaiyou8() {
        return ztyttdknaiyou8;
    }

    public void setZtyttdknaiyou8(String pZtyttdknaiyou8) {
        ztyttdknaiyou8 = pZtyttdknaiyou8;
    }

    private String ztyttdknaiyou9;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOU9)
    public String getZtyttdknaiyou9() {
        return ztyttdknaiyou9;
    }

    public void setZtyttdknaiyou9(String pZtyttdknaiyou9) {
        ztyttdknaiyou9 = pZtyttdknaiyou9;
    }

    private String ztyttdknaiyou10;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOU10)
    public String getZtyttdknaiyou10() {
        return ztyttdknaiyou10;
    }

    public void setZtyttdknaiyou10(String pZtyttdknaiyou10) {
        ztyttdknaiyou10 = pZtyttdknaiyou10;
    }

    private String ztyttdknaiyouumukbn;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOUUMUKBN)
    public String getZtyttdknaiyouumukbn() {
        return ztyttdknaiyouumukbn;
    }

    public void setZtyttdknaiyouumukbn(String pZtyttdknaiyouumukbn) {
        ztyttdknaiyouumukbn = pZtyttdknaiyouumukbn;
    }

    private String ztykykniyuhnkkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKNIYUHNKKBN)
    public String getZtykykniyuhnkkbn() {
        return ztykykniyuhnkkbn;
    }

    public void setZtykykniyuhnkkbn(String pZtykykniyuhnkkbn) {
        ztykykniyuhnkkbn = pZtykykniyuhnkkbn;
    }

    private String ztykykniyuhnkymd;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKNIYUHNKYMD)
    public String getZtykykniyuhnkymd() {
        return ztykykniyuhnkymd;
    }

    public void setZtykykniyuhnkymd(String pZtykykniyuhnkymd) {
        ztykykniyuhnkymd = pZtykykniyuhnkymd;
    }

    private String ztykykniyuhnkinfo;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKNIYUHNKINFO)
    public String getZtykykniyuhnkinfo() {
        return ztykykniyuhnkinfo;
    }

    public void setZtykykniyuhnkinfo(String pZtykykniyuhnkinfo) {
        ztykykniyuhnkinfo = pZtykykniyuhnkinfo;
    }

    private String ztykykniyuhnkkngkhugou1;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKNIYUHNKKNGKHUGOU1)
    public String getZtykykniyuhnkkngkhugou1() {
        return ztykykniyuhnkkngkhugou1;
    }

    public void setZtykykniyuhnkkngkhugou1(String pZtykykniyuhnkkngkhugou1) {
        ztykykniyuhnkkngkhugou1 = pZtykykniyuhnkkngkhugou1;
    }

    private String ztykykniyuhnkkngk1;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKNIYUHNKKNGK1)
    public String getZtykykniyuhnkkngk1() {
        return ztykykniyuhnkkngk1;
    }

    public void setZtykykniyuhnkkngk1(String pZtykykniyuhnkkngk1) {
        ztykykniyuhnkkngk1 = pZtykykniyuhnkkngk1;
    }

    private String ztykykniyuhnkkngktuksyu1;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKNIYUHNKKNGKTUKSYU1)
    public String getZtykykniyuhnkkngktuksyu1() {
        return ztykykniyuhnkkngktuksyu1;
    }

    public void setZtykykniyuhnkkngktuksyu1(String pZtykykniyuhnkkngktuksyu1) {
        ztykykniyuhnkkngktuksyu1 = pZtykykniyuhnkkngktuksyu1;
    }

    private String ztykykniyuhnkkngkhugou2;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKNIYUHNKKNGKHUGOU2)
    public String getZtykykniyuhnkkngkhugou2() {
        return ztykykniyuhnkkngkhugou2;
    }

    public void setZtykykniyuhnkkngkhugou2(String pZtykykniyuhnkkngkhugou2) {
        ztykykniyuhnkkngkhugou2 = pZtykykniyuhnkkngkhugou2;
    }

    private String ztykykniyuhnkkngk2;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKNIYUHNKKNGK2)
    public String getZtykykniyuhnkkngk2() {
        return ztykykniyuhnkkngk2;
    }

    public void setZtykykniyuhnkkngk2(String pZtykykniyuhnkkngk2) {
        ztykykniyuhnkkngk2 = pZtykykniyuhnkkngk2;
    }

    private String ztykykniyuhnkkngktuksyu2;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKNIYUHNKKNGKTUKSYU2)
    public String getZtykykniyuhnkkngktuksyu2() {
        return ztykykniyuhnkkngktuksyu2;
    }

    public void setZtykykniyuhnkkngktuksyu2(String pZtykykniyuhnkkngktuksyu2) {
        ztykykniyuhnkkngktuksyu2 = pZtykykniyuhnkkngktuksyu2;
    }

    private String ztyyobiv102;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV102)
    public String getZtyyobiv102() {
        return ztyyobiv102;
    }

    public void setZtyyobiv102(String pZtyyobiv102) {
        ztyyobiv102 = pZtyyobiv102;
    }

    private String ztysiharaibiwareki;

    @Column(name=GenZT_TtdkKanTy.ZTYSIHARAIBIWAREKI)
    public String getZtysiharaibiwareki() {
        return ztysiharaibiwareki;
    }

    public void setZtysiharaibiwareki(String pZtysiharaibiwareki) {
        ztysiharaibiwareki = pZtysiharaibiwareki;
    }

    private String ztykaiyakuymdwa;

    @Column(name=GenZT_TtdkKanTy.ZTYKAIYAKUYMDWA)
    public String getZtykaiyakuymdwa() {
        return ztykaiyakuymdwa;
    }

    public void setZtykaiyakuymdwa(String pZtykaiyakuymdwa) {
        ztykaiyakuymdwa = pZtykaiyakuymdwa;
    }

    private String ztytekiyou1;

    @Column(name=GenZT_TtdkKanTy.ZTYTEKIYOU1)
    public String getZtytekiyou1() {
        return ztytekiyou1;
    }

    public void setZtytekiyou1(String pZtytekiyou1) {
        ztytekiyou1 = pZtytekiyou1;
    }

    private String ztyshrkngkmeisaihugou1;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKNGKMEISAIHUGOU1)
    public String getZtyshrkngkmeisaihugou1() {
        return ztyshrkngkmeisaihugou1;
    }

    public void setZtyshrkngkmeisaihugou1(String pZtyshrkngkmeisaihugou1) {
        ztyshrkngkmeisaihugou1 = pZtyshrkngkmeisaihugou1;
    }

    private String ztyshrgkmeisai1;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKMEISAI1)
    public String getZtyshrgkmeisai1() {
        return ztyshrgkmeisai1;
    }

    public void setZtyshrgkmeisai1(String pZtyshrgkmeisai1) {
        ztyshrgkmeisai1 = pZtyshrgkmeisai1;
    }

    private String ztyshrgktuukasyu1;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKTUUKASYU1)
    public String getZtyshrgktuukasyu1() {
        return ztyshrgktuukasyu1;
    }

    public void setZtyshrgktuukasyu1(String pZtyshrgktuukasyu1) {
        ztyshrgktuukasyu1 = pZtyshrgktuukasyu1;
    }

    private String ztybikou1;

    @Column(name=GenZT_TtdkKanTy.ZTYBIKOU1)
    public String getZtybikou1() {
        return ztybikou1;
    }

    public void setZtybikou1(String pZtybikou1) {
        ztybikou1 = pZtybikou1;
    }

    private String ztytekiyou2;

    @Column(name=GenZT_TtdkKanTy.ZTYTEKIYOU2)
    public String getZtytekiyou2() {
        return ztytekiyou2;
    }

    public void setZtytekiyou2(String pZtytekiyou2) {
        ztytekiyou2 = pZtytekiyou2;
    }

    private String ztyshrkngkmeisaihugou2;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKNGKMEISAIHUGOU2)
    public String getZtyshrkngkmeisaihugou2() {
        return ztyshrkngkmeisaihugou2;
    }

    public void setZtyshrkngkmeisaihugou2(String pZtyshrkngkmeisaihugou2) {
        ztyshrkngkmeisaihugou2 = pZtyshrkngkmeisaihugou2;
    }

    private String ztyshrgkmeisai2;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKMEISAI2)
    public String getZtyshrgkmeisai2() {
        return ztyshrgkmeisai2;
    }

    public void setZtyshrgkmeisai2(String pZtyshrgkmeisai2) {
        ztyshrgkmeisai2 = pZtyshrgkmeisai2;
    }

    private String ztyshrgktuukasyu2;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKTUUKASYU2)
    public String getZtyshrgktuukasyu2() {
        return ztyshrgktuukasyu2;
    }

    public void setZtyshrgktuukasyu2(String pZtyshrgktuukasyu2) {
        ztyshrgktuukasyu2 = pZtyshrgktuukasyu2;
    }

    private String ztybikou2;

    @Column(name=GenZT_TtdkKanTy.ZTYBIKOU2)
    public String getZtybikou2() {
        return ztybikou2;
    }

    public void setZtybikou2(String pZtybikou2) {
        ztybikou2 = pZtybikou2;
    }

    private String ztytekiyou3;

    @Column(name=GenZT_TtdkKanTy.ZTYTEKIYOU3)
    public String getZtytekiyou3() {
        return ztytekiyou3;
    }

    public void setZtytekiyou3(String pZtytekiyou3) {
        ztytekiyou3 = pZtytekiyou3;
    }

    private String ztyshrkngkmeisaihugou3;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKNGKMEISAIHUGOU3)
    public String getZtyshrkngkmeisaihugou3() {
        return ztyshrkngkmeisaihugou3;
    }

    public void setZtyshrkngkmeisaihugou3(String pZtyshrkngkmeisaihugou3) {
        ztyshrkngkmeisaihugou3 = pZtyshrkngkmeisaihugou3;
    }

    private String ztyshrgkmeisai3;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKMEISAI3)
    public String getZtyshrgkmeisai3() {
        return ztyshrgkmeisai3;
    }

    public void setZtyshrgkmeisai3(String pZtyshrgkmeisai3) {
        ztyshrgkmeisai3 = pZtyshrgkmeisai3;
    }

    private String ztyshrgktuukasyu3;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKTUUKASYU3)
    public String getZtyshrgktuukasyu3() {
        return ztyshrgktuukasyu3;
    }

    public void setZtyshrgktuukasyu3(String pZtyshrgktuukasyu3) {
        ztyshrgktuukasyu3 = pZtyshrgktuukasyu3;
    }

    private String ztybikou3;

    @Column(name=GenZT_TtdkKanTy.ZTYBIKOU3)
    public String getZtybikou3() {
        return ztybikou3;
    }

    public void setZtybikou3(String pZtybikou3) {
        ztybikou3 = pZtybikou3;
    }

    private String ztytekiyou4;

    @Column(name=GenZT_TtdkKanTy.ZTYTEKIYOU4)
    public String getZtytekiyou4() {
        return ztytekiyou4;
    }

    public void setZtytekiyou4(String pZtytekiyou4) {
        ztytekiyou4 = pZtytekiyou4;
    }

    private String ztyshrkngkmeisaihugou4;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKNGKMEISAIHUGOU4)
    public String getZtyshrkngkmeisaihugou4() {
        return ztyshrkngkmeisaihugou4;
    }

    public void setZtyshrkngkmeisaihugou4(String pZtyshrkngkmeisaihugou4) {
        ztyshrkngkmeisaihugou4 = pZtyshrkngkmeisaihugou4;
    }

    private String ztyshrgkmeisai4;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKMEISAI4)
    public String getZtyshrgkmeisai4() {
        return ztyshrgkmeisai4;
    }

    public void setZtyshrgkmeisai4(String pZtyshrgkmeisai4) {
        ztyshrgkmeisai4 = pZtyshrgkmeisai4;
    }

    private String ztyshrgktuukasyu4;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKTUUKASYU4)
    public String getZtyshrgktuukasyu4() {
        return ztyshrgktuukasyu4;
    }

    public void setZtyshrgktuukasyu4(String pZtyshrgktuukasyu4) {
        ztyshrgktuukasyu4 = pZtyshrgktuukasyu4;
    }

    private String ztybikou4;

    @Column(name=GenZT_TtdkKanTy.ZTYBIKOU4)
    public String getZtybikou4() {
        return ztybikou4;
    }

    public void setZtybikou4(String pZtybikou4) {
        ztybikou4 = pZtybikou4;
    }

    private String ztytekiyou5;

    @Column(name=GenZT_TtdkKanTy.ZTYTEKIYOU5)
    public String getZtytekiyou5() {
        return ztytekiyou5;
    }

    public void setZtytekiyou5(String pZtytekiyou5) {
        ztytekiyou5 = pZtytekiyou5;
    }

    private String ztyshrkngkmeisaihugou5;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKNGKMEISAIHUGOU5)
    public String getZtyshrkngkmeisaihugou5() {
        return ztyshrkngkmeisaihugou5;
    }

    public void setZtyshrkngkmeisaihugou5(String pZtyshrkngkmeisaihugou5) {
        ztyshrkngkmeisaihugou5 = pZtyshrkngkmeisaihugou5;
    }

    private String ztyshrgkmeisai5;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKMEISAI5)
    public String getZtyshrgkmeisai5() {
        return ztyshrgkmeisai5;
    }

    public void setZtyshrgkmeisai5(String pZtyshrgkmeisai5) {
        ztyshrgkmeisai5 = pZtyshrgkmeisai5;
    }

    private String ztyshrgktuukasyu5;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKTUUKASYU5)
    public String getZtyshrgktuukasyu5() {
        return ztyshrgktuukasyu5;
    }

    public void setZtyshrgktuukasyu5(String pZtyshrgktuukasyu5) {
        ztyshrgktuukasyu5 = pZtyshrgktuukasyu5;
    }

    private String ztybikou5;

    @Column(name=GenZT_TtdkKanTy.ZTYBIKOU5)
    public String getZtybikou5() {
        return ztybikou5;
    }

    public void setZtybikou5(String pZtybikou5) {
        ztybikou5 = pZtybikou5;
    }

    private String ztytekiyou6;

    @Column(name=GenZT_TtdkKanTy.ZTYTEKIYOU6)
    public String getZtytekiyou6() {
        return ztytekiyou6;
    }

    public void setZtytekiyou6(String pZtytekiyou6) {
        ztytekiyou6 = pZtytekiyou6;
    }

    private String ztyshrkngkmeisaihugou6;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKNGKMEISAIHUGOU6)
    public String getZtyshrkngkmeisaihugou6() {
        return ztyshrkngkmeisaihugou6;
    }

    public void setZtyshrkngkmeisaihugou6(String pZtyshrkngkmeisaihugou6) {
        ztyshrkngkmeisaihugou6 = pZtyshrkngkmeisaihugou6;
    }

    private String ztyshrgkmeisai6;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKMEISAI6)
    public String getZtyshrgkmeisai6() {
        return ztyshrgkmeisai6;
    }

    public void setZtyshrgkmeisai6(String pZtyshrgkmeisai6) {
        ztyshrgkmeisai6 = pZtyshrgkmeisai6;
    }

    private String ztyshrgktuukasyu6;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKTUUKASYU6)
    public String getZtyshrgktuukasyu6() {
        return ztyshrgktuukasyu6;
    }

    public void setZtyshrgktuukasyu6(String pZtyshrgktuukasyu6) {
        ztyshrgktuukasyu6 = pZtyshrgktuukasyu6;
    }

    private String ztybikou6;

    @Column(name=GenZT_TtdkKanTy.ZTYBIKOU6)
    public String getZtybikou6() {
        return ztybikou6;
    }

    public void setZtybikou6(String pZtybikou6) {
        ztybikou6 = pZtybikou6;
    }

    private String ztytekiyou7;

    @Column(name=GenZT_TtdkKanTy.ZTYTEKIYOU7)
    public String getZtytekiyou7() {
        return ztytekiyou7;
    }

    public void setZtytekiyou7(String pZtytekiyou7) {
        ztytekiyou7 = pZtytekiyou7;
    }

    private String ztyshrkngkmeisaihugou7;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKNGKMEISAIHUGOU7)
    public String getZtyshrkngkmeisaihugou7() {
        return ztyshrkngkmeisaihugou7;
    }

    public void setZtyshrkngkmeisaihugou7(String pZtyshrkngkmeisaihugou7) {
        ztyshrkngkmeisaihugou7 = pZtyshrkngkmeisaihugou7;
    }

    private String ztyshrgkmeisai7;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKMEISAI7)
    public String getZtyshrgkmeisai7() {
        return ztyshrgkmeisai7;
    }

    public void setZtyshrgkmeisai7(String pZtyshrgkmeisai7) {
        ztyshrgkmeisai7 = pZtyshrgkmeisai7;
    }

    private String ztyshrgktuukasyu7;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKTUUKASYU7)
    public String getZtyshrgktuukasyu7() {
        return ztyshrgktuukasyu7;
    }

    public void setZtyshrgktuukasyu7(String pZtyshrgktuukasyu7) {
        ztyshrgktuukasyu7 = pZtyshrgktuukasyu7;
    }

    private String ztybikou7;

    @Column(name=GenZT_TtdkKanTy.ZTYBIKOU7)
    public String getZtybikou7() {
        return ztybikou7;
    }

    public void setZtybikou7(String pZtybikou7) {
        ztybikou7 = pZtybikou7;
    }

    private String ztytekiyou8;

    @Column(name=GenZT_TtdkKanTy.ZTYTEKIYOU8)
    public String getZtytekiyou8() {
        return ztytekiyou8;
    }

    public void setZtytekiyou8(String pZtytekiyou8) {
        ztytekiyou8 = pZtytekiyou8;
    }

    private String ztyshrkngkmeisaihugou8;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKNGKMEISAIHUGOU8)
    public String getZtyshrkngkmeisaihugou8() {
        return ztyshrkngkmeisaihugou8;
    }

    public void setZtyshrkngkmeisaihugou8(String pZtyshrkngkmeisaihugou8) {
        ztyshrkngkmeisaihugou8 = pZtyshrkngkmeisaihugou8;
    }

    private String ztyshrgkmeisai8;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKMEISAI8)
    public String getZtyshrgkmeisai8() {
        return ztyshrgkmeisai8;
    }

    public void setZtyshrgkmeisai8(String pZtyshrgkmeisai8) {
        ztyshrgkmeisai8 = pZtyshrgkmeisai8;
    }

    private String ztyshrgktuukasyu8;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKTUUKASYU8)
    public String getZtyshrgktuukasyu8() {
        return ztyshrgktuukasyu8;
    }

    public void setZtyshrgktuukasyu8(String pZtyshrgktuukasyu8) {
        ztyshrgktuukasyu8 = pZtyshrgktuukasyu8;
    }

    private String ztybikou8;

    @Column(name=GenZT_TtdkKanTy.ZTYBIKOU8)
    public String getZtybikou8() {
        return ztybikou8;
    }

    public void setZtybikou8(String pZtybikou8) {
        ztybikou8 = pZtybikou8;
    }

    private String ztytekiyou9;

    @Column(name=GenZT_TtdkKanTy.ZTYTEKIYOU9)
    public String getZtytekiyou9() {
        return ztytekiyou9;
    }

    public void setZtytekiyou9(String pZtytekiyou9) {
        ztytekiyou9 = pZtytekiyou9;
    }

    private String ztyshrkngkmeisaihugou9;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKNGKMEISAIHUGOU9)
    public String getZtyshrkngkmeisaihugou9() {
        return ztyshrkngkmeisaihugou9;
    }

    public void setZtyshrkngkmeisaihugou9(String pZtyshrkngkmeisaihugou9) {
        ztyshrkngkmeisaihugou9 = pZtyshrkngkmeisaihugou9;
    }

    private String ztyshrgkmeisai9;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKMEISAI9)
    public String getZtyshrgkmeisai9() {
        return ztyshrgkmeisai9;
    }

    public void setZtyshrgkmeisai9(String pZtyshrgkmeisai9) {
        ztyshrgkmeisai9 = pZtyshrgkmeisai9;
    }

    private String ztyshrgktuukasyu9;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKTUUKASYU9)
    public String getZtyshrgktuukasyu9() {
        return ztyshrgktuukasyu9;
    }

    public void setZtyshrgktuukasyu9(String pZtyshrgktuukasyu9) {
        ztyshrgktuukasyu9 = pZtyshrgktuukasyu9;
    }

    private String ztybikou9;

    @Column(name=GenZT_TtdkKanTy.ZTYBIKOU9)
    public String getZtybikou9() {
        return ztybikou9;
    }

    public void setZtybikou9(String pZtybikou9) {
        ztybikou9 = pZtybikou9;
    }

    private String ztytekiyou10;

    @Column(name=GenZT_TtdkKanTy.ZTYTEKIYOU10)
    public String getZtytekiyou10() {
        return ztytekiyou10;
    }

    public void setZtytekiyou10(String pZtytekiyou10) {
        ztytekiyou10 = pZtytekiyou10;
    }

    private String ztyshrkngkmeisaihugou10;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKNGKMEISAIHUGOU10)
    public String getZtyshrkngkmeisaihugou10() {
        return ztyshrkngkmeisaihugou10;
    }

    public void setZtyshrkngkmeisaihugou10(String pZtyshrkngkmeisaihugou10) {
        ztyshrkngkmeisaihugou10 = pZtyshrkngkmeisaihugou10;
    }

    private String ztyshrgkmeisai10;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKMEISAI10)
    public String getZtyshrgkmeisai10() {
        return ztyshrgkmeisai10;
    }

    public void setZtyshrgkmeisai10(String pZtyshrgkmeisai10) {
        ztyshrgkmeisai10 = pZtyshrgkmeisai10;
    }

    private String ztyshrgktuukasyu10;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKTUUKASYU10)
    public String getZtyshrgktuukasyu10() {
        return ztyshrgktuukasyu10;
    }

    public void setZtyshrgktuukasyu10(String pZtyshrgktuukasyu10) {
        ztyshrgktuukasyu10 = pZtyshrgktuukasyu10;
    }

    private String ztybikou10;

    @Column(name=GenZT_TtdkKanTy.ZTYBIKOU10)
    public String getZtybikou10() {
        return ztybikou10;
    }

    public void setZtybikou10(String pZtybikou10) {
        ztybikou10 = pZtybikou10;
    }

    private String ztyshrgkgoukei;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRGKGOUKEI)
    public String getZtyshrgkgoukei() {
        return ztyshrgkgoukei;
    }

    public void setZtyshrgkgoukei(String pZtyshrgkgoukei) {
        ztyshrgkgoukei = pZtyshrgkgoukei;
    }

    private String ztyshrtuukasyu;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRTUUKASYU)
    public String getZtyshrtuukasyu() {
        return ztyshrtuukasyu;
    }

    public void setZtyshrtuukasyu(String pZtyshrtuukasyu) {
        ztyshrtuukasyu = pZtyshrtuukasyu;
    }

    private String ztydseisanshrttdknm;

    @Column(name=GenZT_TtdkKanTy.ZTYDSEISANSHRTTDKNM)
    public String getZtydseisanshrttdknm() {
        return ztydseisanshrttdknm;
    }

    public void setZtydseisanshrttdknm(String pZtydseisanshrttdknm) {
        ztydseisanshrttdknm = pZtydseisanshrttdknm;
    }

    private String ztyyobiv26x3;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV26X3)
    public String getZtyyobiv26x3() {
        return ztyyobiv26x3;
    }

    public void setZtyyobiv26x3(String pZtyyobiv26x3) {
        ztyyobiv26x3 = pZtyyobiv26x3;
    }

    private String ztybanknmkj;

    @Column(name=GenZT_TtdkKanTy.ZTYBANKNMKJ)
    public String getZtybanknmkj() {
        return ztybanknmkj;
    }

    public void setZtybanknmkj(String pZtybanknmkj) {
        ztybanknmkj = pZtybanknmkj;
    }

    private String ztysitennmkj;

    @Column(name=GenZT_TtdkKanTy.ZTYSITENNMKJ)
    public String getZtysitennmkj() {
        return ztysitennmkj;
    }

    public void setZtysitennmkj(String pZtysitennmkj) {
        ztysitennmkj = pZtysitennmkj;
    }

    private String ztyyokinkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYYOKINKBN)
    public String getZtyyokinkbn() {
        return ztyyokinkbn;
    }

    public void setZtyyokinkbn(String pZtyyokinkbn) {
        ztyyokinkbn = pZtyyokinkbn;
    }

    private String ztykouzano12keta;

    @Column(name=GenZT_TtdkKanTy.ZTYKOUZANO12KETA)
    public String getZtykouzano12keta() {
        return ztykouzano12keta;
    }

    public void setZtykouzano12keta(String pZtykouzano12keta) {
        ztykouzano12keta = pZtykouzano12keta;
    }

    private String ztykzmeiginmknhan;

    @Column(name=GenZT_TtdkKanTy.ZTYKZMEIGINMKNHAN)
    public String getZtykzmeiginmknhan() {
        return ztykzmeiginmknhan;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setZtykzmeiginmknhan(String pZtykzmeiginmknhan) {
        ztykzmeiginmknhan = pZtykzmeiginmknhan;
    }

    private String ztykouzasyuruikbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKOUZASYURUIKBN)
    public String getZtykouzasyuruikbn() {
        return ztykouzasyuruikbn;
    }

    public void setZtykouzasyuruikbn(String pZtykouzasyuruikbn) {
        ztykouzasyuruikbn = pZtykouzasyuruikbn;
    }

    private String ztyyobiv26x2;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV26X2)
    public String getZtyyobiv26x2() {
        return ztyyobiv26x2;
    }

    public void setZtyyobiv26x2(String pZtyyobiv26x2) {
        ztyyobiv26x2 = pZtyyobiv26x2;
    }

    private String ztysynykngk;

    @Column(name=GenZT_TtdkKanTy.ZTYSYNYKNGK)
    public String getZtysynykngk() {
        return ztysynykngk;
    }

    public void setZtysynykngk(String pZtysynykngk) {
        ztysynykngk = pZtysynykngk;
    }

    private String ztysynykngktuukasyu;

    @Column(name=GenZT_TtdkKanTy.ZTYSYNYKNGKTUUKASYU)
    public String getZtysynykngktuukasyu() {
        return ztysynykngktuukasyu;
    }

    public void setZtysynykngktuukasyu(String pZtysynykngktuukasyu) {
        ztysynykngktuukasyu = pZtysynykngktuukasyu;
    }

    private String ztyhtykeihi;

    @Column(name=GenZT_TtdkKanTy.ZTYHTYKEIHI)
    public String getZtyhtykeihi() {
        return ztyhtykeihi;
    }

    public void setZtyhtykeihi(String pZtyhtykeihi) {
        ztyhtykeihi = pZtyhtykeihi;
    }

    private String ztyhtykeihituukasyu;

    @Column(name=GenZT_TtdkKanTy.ZTYHTYKEIHITUUKASYU)
    public String getZtyhtykeihituukasyu() {
        return ztyhtykeihituukasyu;
    }

    public void setZtyhtykeihituukasyu(String pZtyhtykeihituukasyu) {
        ztyhtykeihituukasyu = pZtyhtykeihituukasyu;
    }

    private String ztyshrkyksyahtykeihi;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKYKSYAHTYKEIHI)
    public String getZtyshrkyksyahtykeihi() {
        return ztyshrkyksyahtykeihi;
    }

    public void setZtyshrkyksyahtykeihi(String pZtyshrkyksyahtykeihi) {
        ztyshrkyksyahtykeihi = pZtyshrkyksyahtykeihi;
    }

    private String ztyshrkykhtykeihituukasyu;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRKYKHTYKEIHITUUKASYU)
    public String getZtyshrkykhtykeihituukasyu() {
        return ztyshrkykhtykeihituukasyu;
    }

    public void setZtyshrkykhtykeihituukasyu(String pZtyshrkykhtykeihituukasyu) {
        ztyshrkykhtykeihituukasyu = pZtyshrkykhtykeihituukasyu;
    }

    private String ztygsbnrkzthtykeihi;

    @Column(name=GenZT_TtdkKanTy.ZTYGSBNRKZTHTYKEIHI)
    public String getZtygsbnrkzthtykeihi() {
        return ztygsbnrkzthtykeihi;
    }

    public void setZtygsbnrkzthtykeihi(String pZtygsbnrkzthtykeihi) {
        ztygsbnrkzthtykeihi = pZtygsbnrkzthtykeihi;
    }

    private String ztygsbnrkzthtykeihituksyu;

    @Column(name=GenZT_TtdkKanTy.ZTYGSBNRKZTHTYKEIHITUKSYU)
    public String getZtygsbnrkzthtykeihituksyu() {
        return ztygsbnrkzthtykeihituksyu;
    }

    public void setZtygsbnrkzthtykeihituksyu(String pZtygsbnrkzthtykeihituksyu) {
        ztygsbnrkzthtykeihituksyu = pZtygsbnrkzthtykeihituksyu;
    }

    private String ztygsbnrkztsaeki;

    @Column(name=GenZT_TtdkKanTy.ZTYGSBNRKZTSAEKI)
    public String getZtygsbnrkztsaeki() {
        return ztygsbnrkztsaeki;
    }

    public void setZtygsbnrkztsaeki(String pZtygsbnrkztsaeki) {
        ztygsbnrkztsaeki = pZtygsbnrkztsaeki;
    }

    private String ztygsbnrkztsaekituksyu;

    @Column(name=GenZT_TtdkKanTy.ZTYGSBNRKZTSAEKITUKSYU)
    public String getZtygsbnrkztsaekituksyu() {
        return ztygsbnrkztsaekituksyu;
    }

    public void setZtygsbnrkztsaekituksyu(String pZtygsbnrkztsaekituksyu) {
        ztygsbnrkztsaekituksyu = pZtygsbnrkztsaekituksyu;
    }

    private String ztyzeimunaiyouhensyuctrlkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYZEIMUNAIYOUHENSYUCTRLKBN)
    public String getZtyzeimunaiyouhensyuctrlkbn() {
        return ztyzeimunaiyouhensyuctrlkbn;
    }

    public void setZtyzeimunaiyouhensyuctrlkbn(String pZtyzeimunaiyouhensyuctrlkbn) {
        ztyzeimunaiyouhensyuctrlkbn = pZtyzeimunaiyouhensyuctrlkbn;
    }

    private String ztyzeimumongonoutkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYZEIMUMONGONOUTKBN)
    public String getZtyzeimumongonoutkbn() {
        return ztyzeimumongonoutkbn;
    }

    public void setZtyzeimumongonoutkbn(String pZtyzeimumongonoutkbn) {
        ztyzeimumongonoutkbn = pZtyzeimumongonoutkbn;
    }

    private String ztyzeimumongon1;

    @Column(name=GenZT_TtdkKanTy.ZTYZEIMUMONGON1)
    public String getZtyzeimumongon1() {
        return ztyzeimumongon1;
    }

    public void setZtyzeimumongon1(String pZtyzeimumongon1) {
        ztyzeimumongon1 = pZtyzeimumongon1;
    }

    private String ztyzeimumongon2;

    @Column(name=GenZT_TtdkKanTy.ZTYZEIMUMONGON2)
    public String getZtyzeimumongon2() {
        return ztyzeimumongon2;
    }

    public void setZtyzeimumongon2(String pZtyzeimumongon2) {
        ztyzeimumongon2 = pZtyzeimumongon2;
    }

    private String ztyzeimumongon3;

    @Column(name=GenZT_TtdkKanTy.ZTYZEIMUMONGON3)
    public String getZtyzeimumongon3() {
        return ztyzeimumongon3;
    }

    public void setZtyzeimumongon3(String pZtyzeimumongon3) {
        ztyzeimumongon3 = pZtyzeimumongon3;
    }

    private String ztyzeimumongon4;

    @Column(name=GenZT_TtdkKanTy.ZTYZEIMUMONGON4)
    public String getZtyzeimumongon4() {
        return ztyzeimumongon4;
    }

    public void setZtyzeimumongon4(String pZtyzeimumongon4) {
        ztyzeimumongon4 = pZtyzeimumongon4;
    }

    private String ztyzeimumongon5;

    @Column(name=GenZT_TtdkKanTy.ZTYZEIMUMONGON5)
    public String getZtyzeimumongon5() {
        return ztyzeimumongon5;
    }

    public void setZtyzeimumongon5(String pZtyzeimumongon5) {
        ztyzeimumongon5 = pZtyzeimumongon5;
    }

    private String ztyyendthnkzeimuinfohskkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYYENDTHNKZEIMUINFOHSKKBN)
    public String getZtyyendthnkzeimuinfohskkbn() {
        return ztyyendthnkzeimuinfohskkbn;
    }

    public void setZtyyendthnkzeimuinfohskkbn(String pZtyyendthnkzeimuinfohskkbn) {
        ztyyendthnkzeimuinfohskkbn = pZtyyendthnkzeimuinfohskkbn;
    }

    private String ztyyobiv36;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV36)
    public String getZtyyobiv36() {
        return ztyyobiv36;
    }

    public void setZtyyobiv36(String pZtyyobiv36) {
        ztyyobiv36 = pZtyyobiv36;
    }

    private String ztyosirasehyoudai;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEHYOUDAI)
    public String getZtyosirasehyoudai() {
        return ztyosirasehyoudai;
    }

    public void setZtyosirasehyoudai(String pZtyosirasehyoudai) {
        ztyosirasehyoudai = pZtyosirasehyoudai;
    }

    private String ztyosirasemongon1;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON1)
    public String getZtyosirasemongon1() {
        return ztyosirasemongon1;
    }

    public void setZtyosirasemongon1(String pZtyosirasemongon1) {
        ztyosirasemongon1 = pZtyosirasemongon1;
    }

    private String ztyosirasemongon2;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON2)
    public String getZtyosirasemongon2() {
        return ztyosirasemongon2;
    }

    public void setZtyosirasemongon2(String pZtyosirasemongon2) {
        ztyosirasemongon2 = pZtyosirasemongon2;
    }

    private String ztyosirasemongon3;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON3)
    public String getZtyosirasemongon3() {
        return ztyosirasemongon3;
    }

    public void setZtyosirasemongon3(String pZtyosirasemongon3) {
        ztyosirasemongon3 = pZtyosirasemongon3;
    }

    private String ztyosirasemongon4;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON4)
    public String getZtyosirasemongon4() {
        return ztyosirasemongon4;
    }

    public void setZtyosirasemongon4(String pZtyosirasemongon4) {
        ztyosirasemongon4 = pZtyosirasemongon4;
    }

    private String ztyosirasemongon5;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON5)
    public String getZtyosirasemongon5() {
        return ztyosirasemongon5;
    }

    public void setZtyosirasemongon5(String pZtyosirasemongon5) {
        ztyosirasemongon5 = pZtyosirasemongon5;
    }

    private String ztyosirasemongon6;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON6)
    public String getZtyosirasemongon6() {
        return ztyosirasemongon6;
    }

    public void setZtyosirasemongon6(String pZtyosirasemongon6) {
        ztyosirasemongon6 = pZtyosirasemongon6;
    }

    private String ztyosirasemongon7;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON7)
    public String getZtyosirasemongon7() {
        return ztyosirasemongon7;
    }

    public void setZtyosirasemongon7(String pZtyosirasemongon7) {
        ztyosirasemongon7 = pZtyosirasemongon7;
    }

    private String ztyosirasemongon8;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON8)
    public String getZtyosirasemongon8() {
        return ztyosirasemongon8;
    }

    public void setZtyosirasemongon8(String pZtyosirasemongon8) {
        ztyosirasemongon8 = pZtyosirasemongon8;
    }

    private String ztyosirasemongon9;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON9)
    public String getZtyosirasemongon9() {
        return ztyosirasemongon9;
    }

    public void setZtyosirasemongon9(String pZtyosirasemongon9) {
        ztyosirasemongon9 = pZtyosirasemongon9;
    }

    private String ztyosirasemongon10;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON10)
    public String getZtyosirasemongon10() {
        return ztyosirasemongon10;
    }

    public void setZtyosirasemongon10(String pZtyosirasemongon10) {
        ztyosirasemongon10 = pZtyosirasemongon10;
    }

    private String ztyosirasemongon11;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON11)
    public String getZtyosirasemongon11() {
        return ztyosirasemongon11;
    }

    public void setZtyosirasemongon11(String pZtyosirasemongon11) {
        ztyosirasemongon11 = pZtyosirasemongon11;
    }

    private String ztyosirasemongon12;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON12)
    public String getZtyosirasemongon12() {
        return ztyosirasemongon12;
    }

    public void setZtyosirasemongon12(String pZtyosirasemongon12) {
        ztyosirasemongon12 = pZtyosirasemongon12;
    }

    private String ztyosirasemongon13;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON13)
    public String getZtyosirasemongon13() {
        return ztyosirasemongon13;
    }

    public void setZtyosirasemongon13(String pZtyosirasemongon13) {
        ztyosirasemongon13 = pZtyosirasemongon13;
    }

    private String ztyosirasemongon14;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON14)
    public String getZtyosirasemongon14() {
        return ztyosirasemongon14;
    }

    public void setZtyosirasemongon14(String pZtyosirasemongon14) {
        ztyosirasemongon14 = pZtyosirasemongon14;
    }

    private String ztyosirasemongon15;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON15)
    public String getZtyosirasemongon15() {
        return ztyosirasemongon15;
    }

    public void setZtyosirasemongon15(String pZtyosirasemongon15) {
        ztyosirasemongon15 = pZtyosirasemongon15;
    }

    private String ztyosirasemongon16;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON16)
    public String getZtyosirasemongon16() {
        return ztyosirasemongon16;
    }

    public void setZtyosirasemongon16(String pZtyosirasemongon16) {
        ztyosirasemongon16 = pZtyosirasemongon16;
    }

    private String ztyosirasemongon17;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON17)
    public String getZtyosirasemongon17() {
        return ztyosirasemongon17;
    }

    public void setZtyosirasemongon17(String pZtyosirasemongon17) {
        ztyosirasemongon17 = pZtyosirasemongon17;
    }

    private String ztyosirasemongon18;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON18)
    public String getZtyosirasemongon18() {
        return ztyosirasemongon18;
    }

    public void setZtyosirasemongon18(String pZtyosirasemongon18) {
        ztyosirasemongon18 = pZtyosirasemongon18;
    }

    private String ztyosirasemongon19;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON19)
    public String getZtyosirasemongon19() {
        return ztyosirasemongon19;
    }

    public void setZtyosirasemongon19(String pZtyosirasemongon19) {
        ztyosirasemongon19 = pZtyosirasemongon19;
    }

    private String ztyosirasemongon20;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON20)
    public String getZtyosirasemongon20() {
        return ztyosirasemongon20;
    }

    public void setZtyosirasemongon20(String pZtyosirasemongon20) {
        ztyosirasemongon20 = pZtyosirasemongon20;
    }

    private String ztyosirasemongon21;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON21)
    public String getZtyosirasemongon21() {
        return ztyosirasemongon21;
    }

    public void setZtyosirasemongon21(String pZtyosirasemongon21) {
        ztyosirasemongon21 = pZtyosirasemongon21;
    }

    private String ztyosirasemongon22;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON22)
    public String getZtyosirasemongon22() {
        return ztyosirasemongon22;
    }

    public void setZtyosirasemongon22(String pZtyosirasemongon22) {
        ztyosirasemongon22 = pZtyosirasemongon22;
    }

    private String ztyosirasemongon23;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON23)
    public String getZtyosirasemongon23() {
        return ztyosirasemongon23;
    }

    public void setZtyosirasemongon23(String pZtyosirasemongon23) {
        ztyosirasemongon23 = pZtyosirasemongon23;
    }

    private String ztyosirasemongon24;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON24)
    public String getZtyosirasemongon24() {
        return ztyosirasemongon24;
    }

    public void setZtyosirasemongon24(String pZtyosirasemongon24) {
        ztyosirasemongon24 = pZtyosirasemongon24;
    }

    private String ztyosirasemongon25;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON25)
    public String getZtyosirasemongon25() {
        return ztyosirasemongon25;
    }

    public void setZtyosirasemongon25(String pZtyosirasemongon25) {
        ztyosirasemongon25 = pZtyosirasemongon25;
    }

    private String ztyosirasemongon26;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON26)
    public String getZtyosirasemongon26() {
        return ztyosirasemongon26;
    }

    public void setZtyosirasemongon26(String pZtyosirasemongon26) {
        ztyosirasemongon26 = pZtyosirasemongon26;
    }

    private String ztyosirasemongon27;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON27)
    public String getZtyosirasemongon27() {
        return ztyosirasemongon27;
    }

    public void setZtyosirasemongon27(String pZtyosirasemongon27) {
        ztyosirasemongon27 = pZtyosirasemongon27;
    }

    private String ztyosirasemongon28;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON28)
    public String getZtyosirasemongon28() {
        return ztyosirasemongon28;
    }

    public void setZtyosirasemongon28(String pZtyosirasemongon28) {
        ztyosirasemongon28 = pZtyosirasemongon28;
    }

    private String ztyosirasemongon29;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON29)
    public String getZtyosirasemongon29() {
        return ztyosirasemongon29;
    }

    public void setZtyosirasemongon29(String pZtyosirasemongon29) {
        ztyosirasemongon29 = pZtyosirasemongon29;
    }

    private String ztyosirasemongon30;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON30)
    public String getZtyosirasemongon30() {
        return ztyosirasemongon30;
    }

    public void setZtyosirasemongon30(String pZtyosirasemongon30) {
        ztyosirasemongon30 = pZtyosirasemongon30;
    }

    private String ztyosirasemongon31;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON31)
    public String getZtyosirasemongon31() {
        return ztyosirasemongon31;
    }

    public void setZtyosirasemongon31(String pZtyosirasemongon31) {
        ztyosirasemongon31 = pZtyosirasemongon31;
    }

    private String ztyosirasemongon32;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON32)
    public String getZtyosirasemongon32() {
        return ztyosirasemongon32;
    }

    public void setZtyosirasemongon32(String pZtyosirasemongon32) {
        ztyosirasemongon32 = pZtyosirasemongon32;
    }

    private String ztyosirasemongon33;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON33)
    public String getZtyosirasemongon33() {
        return ztyosirasemongon33;
    }

    public void setZtyosirasemongon33(String pZtyosirasemongon33) {
        ztyosirasemongon33 = pZtyosirasemongon33;
    }

    private String ztyosirasemongon34;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON34)
    public String getZtyosirasemongon34() {
        return ztyosirasemongon34;
    }

    public void setZtyosirasemongon34(String pZtyosirasemongon34) {
        ztyosirasemongon34 = pZtyosirasemongon34;
    }

    private String ztyosirasemongon35;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON35)
    public String getZtyosirasemongon35() {
        return ztyosirasemongon35;
    }

    public void setZtyosirasemongon35(String pZtyosirasemongon35) {
        ztyosirasemongon35 = pZtyosirasemongon35;
    }

    private String ztyosirasemongon36;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON36)
    public String getZtyosirasemongon36() {
        return ztyosirasemongon36;
    }

    public void setZtyosirasemongon36(String pZtyosirasemongon36) {
        ztyosirasemongon36 = pZtyosirasemongon36;
    }

    private String ztyosirasemongon37;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON37)
    public String getZtyosirasemongon37() {
        return ztyosirasemongon37;
    }

    public void setZtyosirasemongon37(String pZtyosirasemongon37) {
        ztyosirasemongon37 = pZtyosirasemongon37;
    }

    private String ztyosirasemongon38;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON38)
    public String getZtyosirasemongon38() {
        return ztyosirasemongon38;
    }

    public void setZtyosirasemongon38(String pZtyosirasemongon38) {
        ztyosirasemongon38 = pZtyosirasemongon38;
    }

    private String ztyosirasemongon39;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON39)
    public String getZtyosirasemongon39() {
        return ztyosirasemongon39;
    }

    public void setZtyosirasemongon39(String pZtyosirasemongon39) {
        ztyosirasemongon39 = pZtyosirasemongon39;
    }

    private String ztyosirasemongon40;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON40)
    public String getZtyosirasemongon40() {
        return ztyosirasemongon40;
    }

    public void setZtyosirasemongon40(String pZtyosirasemongon40) {
        ztyosirasemongon40 = pZtyosirasemongon40;
    }

    private String ztyosirasemongon41;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON41)
    public String getZtyosirasemongon41() {
        return ztyosirasemongon41;
    }

    public void setZtyosirasemongon41(String pZtyosirasemongon41) {
        ztyosirasemongon41 = pZtyosirasemongon41;
    }

    private String ztyosirasemongon42;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON42)
    public String getZtyosirasemongon42() {
        return ztyosirasemongon42;
    }

    public void setZtyosirasemongon42(String pZtyosirasemongon42) {
        ztyosirasemongon42 = pZtyosirasemongon42;
    }

    private String ztyosirasemongon43;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON43)
    public String getZtyosirasemongon43() {
        return ztyosirasemongon43;
    }

    public void setZtyosirasemongon43(String pZtyosirasemongon43) {
        ztyosirasemongon43 = pZtyosirasemongon43;
    }

    private String ztyosirasemongon44;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON44)
    public String getZtyosirasemongon44() {
        return ztyosirasemongon44;
    }

    public void setZtyosirasemongon44(String pZtyosirasemongon44) {
        ztyosirasemongon44 = pZtyosirasemongon44;
    }

    private String ztyosirasemongon45;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON45)
    public String getZtyosirasemongon45() {
        return ztyosirasemongon45;
    }

    public void setZtyosirasemongon45(String pZtyosirasemongon45) {
        ztyosirasemongon45 = pZtyosirasemongon45;
    }

    private String ztyosirasemongon46;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON46)
    public String getZtyosirasemongon46() {
        return ztyosirasemongon46;
    }

    public void setZtyosirasemongon46(String pZtyosirasemongon46) {
        ztyosirasemongon46 = pZtyosirasemongon46;
    }

    private String ztyosirasemongon47;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON47)
    public String getZtyosirasemongon47() {
        return ztyosirasemongon47;
    }

    public void setZtyosirasemongon47(String pZtyosirasemongon47) {
        ztyosirasemongon47 = pZtyosirasemongon47;
    }

    private String ztyosirasemongon48;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON48)
    public String getZtyosirasemongon48() {
        return ztyosirasemongon48;
    }

    public void setZtyosirasemongon48(String pZtyosirasemongon48) {
        ztyosirasemongon48 = pZtyosirasemongon48;
    }

    private String ztyosirasemongon49;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON49)
    public String getZtyosirasemongon49() {
        return ztyosirasemongon49;
    }

    public void setZtyosirasemongon49(String pZtyosirasemongon49) {
        ztyosirasemongon49 = pZtyosirasemongon49;
    }

    private String ztyosirasemongon50;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEMONGON50)
    public String getZtyosirasemongon50() {
        return ztyosirasemongon50;
    }

    public void setZtyosirasemongon50(String pZtyosirasemongon50) {
        ztyosirasemongon50 = pZtyosirasemongon50;
    }

    private String ztyosiraseinjihuyouhyouji;

    @Column(name=GenZT_TtdkKanTy.ZTYOSIRASEINJIHUYOUHYOUJI)
    public String getZtyosiraseinjihuyouhyouji() {
        return ztyosiraseinjihuyouhyouji;
    }

    public void setZtyosiraseinjihuyouhyouji(String pZtyosiraseinjihuyouhyouji) {
        ztyosiraseinjihuyouhyouji = pZtyosiraseinjihuyouhyouji;
    }

    private String ztyyobiv254;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV254)
    public String getZtyyobiv254() {
        return ztyyobiv254;
    }

    public void setZtyyobiv254(String pZtyyobiv254) {
        ztyyobiv254 = pZtyyobiv254;
    }

    private String ztyshrnaiyouhskmongon1;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRNAIYOUHSKMONGON1)
    public String getZtyshrnaiyouhskmongon1() {
        return ztyshrnaiyouhskmongon1;
    }

    public void setZtyshrnaiyouhskmongon1(String pZtyshrnaiyouhskmongon1) {
        ztyshrnaiyouhskmongon1 = pZtyshrnaiyouhskmongon1;
    }

    private String ztyshrnaiyouhskmongon2;

    @Column(name=GenZT_TtdkKanTy.ZTYSHRNAIYOUHSKMONGON2)
    public String getZtyshrnaiyouhskmongon2() {
        return ztyshrnaiyouhskmongon2;
    }

    public void setZtyshrnaiyouhskmongon2(String pZtyshrnaiyouhskmongon2) {
        ztyshrnaiyouhskmongon2 = pZtyshrnaiyouhskmongon2;
    }

    private String ztydocumentid;

    @Column(name=GenZT_TtdkKanTy.ZTYDOCUMENTID)
    public String getZtydocumentid() {
        return ztydocumentid;
    }

    public void setZtydocumentid(String pZtydocumentid) {
        ztydocumentid = pZtydocumentid;
    }

    private String ztysksmongonkbn1;

    @Column(name=GenZT_TtdkKanTy.ZTYSKSMONGONKBN1)
    public String getZtysksmongonkbn1() {
        return ztysksmongonkbn1;
    }

    public void setZtysksmongonkbn1(String pZtysksmongonkbn1) {
        ztysksmongonkbn1 = pZtysksmongonkbn1;
    }

    private String ztysksmongonkbn2;

    @Column(name=GenZT_TtdkKanTy.ZTYSKSMONGONKBN2)
    public String getZtysksmongonkbn2() {
        return ztysksmongonkbn2;
    }

    public void setZtysksmongonkbn2(String pZtysksmongonkbn2) {
        ztysksmongonkbn2 = pZtysksmongonkbn2;
    }

    private String ztytoritugisyasyozokunm;

    @Column(name=GenZT_TtdkKanTy.ZTYTORITUGISYASYOZOKUNM)
    public String getZtytoritugisyasyozokunm() {
        return ztytoritugisyasyozokunm;
    }

    public void setZtytoritugisyasyozokunm(String pZtytoritugisyasyozokunm) {
        ztytoritugisyasyozokunm = pZtytoritugisyasyozokunm;
    }

    private String ztytoritugisyakjncd;

    @Column(name=GenZT_TtdkKanTy.ZTYTORITUGISYAKJNCD)
    public String getZtytoritugisyakjncd() {
        return ztytoritugisyakjncd;
    }

    public void setZtytoritugisyakjncd(String pZtytoritugisyakjncd) {
        ztytoritugisyakjncd = pZtytoritugisyakjncd;
    }

    private String ztytoritugisyanm;

    @Column(name=GenZT_TtdkKanTy.ZTYTORITUGISYANM)
    public String getZtytoritugisyanm() {
        return ztytoritugisyanm;
    }

    public void setZtytoritugisyanm(String pZtytoritugisyanm) {
        ztytoritugisyanm = pZtytoritugisyanm;
    }

    private String ztyhozonkkny;

    @Column(name=GenZT_TtdkKanTy.ZTYHOZONKKNY)
    public String getZtyhozonkkny() {
        return ztyhozonkkny;
    }

    public void setZtyhozonkkny(String pZtyhozonkkny) {
        ztyhozonkkny = pZtyhozonkkny;
    }

    private String ztytsintelno;

    @Column(name=GenZT_TtdkKanTy.ZTYTSINTELNO)
    public String getZtytsintelno() {
        return ztytsintelno;
    }

    public void setZtytsintelno(String pZtytsintelno) {
        ztytsintelno = pZtytsintelno;
    }

    private String ztytrkkzkkbn1;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKKBN1)
    public String getZtytrkkzkkbn1() {
        return ztytrkkzkkbn1;
    }

    public void setZtytrkkzkkbn1(String pZtytrkkzkkbn1) {
        ztytrkkzkkbn1 = pZtytrkkzkkbn1;
    }

    private String ztytrkkzknmkj1;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKNMKJ1)
    public String getZtytrkkzknmkj1() {
        return ztytrkkzknmkj1;
    }

    public void setZtytrkkzknmkj1(String pZtytrkkzknmkj1) {
        ztytrkkzknmkj1 = pZtytrkkzknmkj1;
    }

    private String ztytrkkzkseiymd1zenkaku;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKSEIYMD1ZENKAKU)
    public String getZtytrkkzkseiymd1zenkaku() {
        return ztytrkkzkseiymd1zenkaku;
    }

    public void setZtytrkkzkseiymd1zenkaku(String pZtytrkkzkseiymd1zenkaku) {
        ztytrkkzkseiymd1zenkaku = pZtytrkkzkseiymd1zenkaku;
    }

    private String ztytrkkzkyno1;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKYNO1)
    public String getZtytrkkzkyno1() {
        return ztytrkkzkyno1;
    }

    public void setZtytrkkzkyno1(String pZtytrkkzkyno1) {
        ztytrkkzkyno1 = pZtytrkkzkyno1;
    }

    private String ztytrkkzkadr1kj1;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKADR1KJ1)
    public String getZtytrkkzkadr1kj1() {
        return ztytrkkzkadr1kj1;
    }

    public void setZtytrkkzkadr1kj1(String pZtytrkkzkadr1kj1) {
        ztytrkkzkadr1kj1 = pZtytrkkzkadr1kj1;
    }

    private String ztytrkkzkadr2kj1;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKADR2KJ1)
    public String getZtytrkkzkadr2kj1() {
        return ztytrkkzkadr2kj1;
    }

    public void setZtytrkkzkadr2kj1(String pZtytrkkzkadr2kj1) {
        ztytrkkzkadr2kj1 = pZtytrkkzkadr2kj1;
    }

    private String ztytrkkzkadr3kj1;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKADR3KJ1)
    public String getZtytrkkzkadr3kj1() {
        return ztytrkkzkadr3kj1;
    }

    public void setZtytrkkzkadr3kj1(String pZtytrkkzkadr3kj1) {
        ztytrkkzkadr3kj1 = pZtytrkkzkadr3kj1;
    }

    private String ztytrkkzktelno1;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKTELNO1)
    public String getZtytrkkzktelno1() {
        return ztytrkkzktelno1;
    }

    public void setZtytrkkzktelno1(String pZtytrkkzktelno1) {
        ztytrkkzktelno1 = pZtytrkkzktelno1;
    }

    private String ztytrkkzktelnomtrkhyouji1;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKTELNOMTRKHYOUJI1)
    public String getZtytrkkzktelnomtrkhyouji1() {
        return ztytrkkzktelnomtrkhyouji1;
    }

    public void setZtytrkkzktelnomtrkhyouji1(String pZtytrkkzktelnomtrkhyouji1) {
        ztytrkkzktelnomtrkhyouji1 = pZtytrkkzktelnomtrkhyouji1;
    }

    private String ztytrkkzkkbn2;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKKBN2)
    public String getZtytrkkzkkbn2() {
        return ztytrkkzkkbn2;
    }

    public void setZtytrkkzkkbn2(String pZtytrkkzkkbn2) {
        ztytrkkzkkbn2 = pZtytrkkzkkbn2;
    }

    private String ztytrkkzknmkj2;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKNMKJ2)
    public String getZtytrkkzknmkj2() {
        return ztytrkkzknmkj2;
    }

    public void setZtytrkkzknmkj2(String pZtytrkkzknmkj2) {
        ztytrkkzknmkj2 = pZtytrkkzknmkj2;
    }

    private String ztytrkkzkseiymd2zenkaku;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKSEIYMD2ZENKAKU)
    public String getZtytrkkzkseiymd2zenkaku() {
        return ztytrkkzkseiymd2zenkaku;
    }

    public void setZtytrkkzkseiymd2zenkaku(String pZtytrkkzkseiymd2zenkaku) {
        ztytrkkzkseiymd2zenkaku = pZtytrkkzkseiymd2zenkaku;
    }

    private String ztytrkkzkyno2;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKYNO2)
    public String getZtytrkkzkyno2() {
        return ztytrkkzkyno2;
    }

    public void setZtytrkkzkyno2(String pZtytrkkzkyno2) {
        ztytrkkzkyno2 = pZtytrkkzkyno2;
    }

    private String ztytrkkzkadr1kj2;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKADR1KJ2)
    public String getZtytrkkzkadr1kj2() {
        return ztytrkkzkadr1kj2;
    }

    public void setZtytrkkzkadr1kj2(String pZtytrkkzkadr1kj2) {
        ztytrkkzkadr1kj2 = pZtytrkkzkadr1kj2;
    }

    private String ztytrkkzkadr2kj2;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKADR2KJ2)
    public String getZtytrkkzkadr2kj2() {
        return ztytrkkzkadr2kj2;
    }

    public void setZtytrkkzkadr2kj2(String pZtytrkkzkadr2kj2) {
        ztytrkkzkadr2kj2 = pZtytrkkzkadr2kj2;
    }

    private String ztytrkkzkadr3kj2;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKADR3KJ2)
    public String getZtytrkkzkadr3kj2() {
        return ztytrkkzkadr3kj2;
    }

    public void setZtytrkkzkadr3kj2(String pZtytrkkzkadr3kj2) {
        ztytrkkzkadr3kj2 = pZtytrkkzkadr3kj2;
    }

    private String ztytrkkzktelno2;

    @Column(name=GenZT_TtdkKanTy.ZTYTRKKZKTELNO2)
    public String getZtytrkkzktelno2() {
        return ztytrkkzktelno2;
    }

    public void setZtytrkkzktelno2(String pZtytrkkzktelno2) {
        ztytrkkzktelno2 = pZtytrkkzktelno2;
    }

    private String ztykykdairinmkj;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDAIRINMKJ)
    public String getZtykykdairinmkj() {
        return ztykykdairinmkj;
    }

    public void setZtykykdairinmkj(String pZtykykdairinmkj) {
        ztykykdairinmkj = pZtykykdairinmkj;
    }

    private String ztykykomttutkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKOMTTUTKBN)
    public String getZtykykomttutkbn() {
        return ztykykomttutkbn;
    }

    public void setZtykykomttutkbn(String pZtykykomttutkbn) {
        ztykykomttutkbn = pZtykykomttutkbn;
    }

    private String ztykzkomttutkbn1;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKOMTTUTKBN1)
    public String getZtykzkomttutkbn1() {
        return ztykzkomttutkbn1;
    }

    public void setZtykzkomttutkbn1(String pZtykzkomttutkbn1) {
        ztykzkomttutkbn1 = pZtykzkomttutkbn1;
    }

    private String ztykzkomttutkbn2;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKOMTTUTKBN2)
    public String getZtykzkomttutkbn2() {
        return ztykzkomttutkbn2;
    }

    public void setZtykzkomttutkbn2(String pZtykzkomttutkbn2) {
        ztykzkomttutkbn2 = pZtykzkomttutkbn2;
    }

    private String ztyhhkomttutkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKOMTTUTKBN)
    public String getZtyhhkomttutkbn() {
        return ztyhhkomttutkbn;
    }

    public void setZtyhhkomttutkbn(String pZtyhhkomttutkbn) {
        ztyhhkomttutkbn = pZtyhhkomttutkbn;
    }

    private String ztyhhkdromttutkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDROMTTUTKBN)
    public String getZtyhhkdromttutkbn() {
        return ztyhhkdromttutkbn;
    }

    public void setZtyhhkdromttutkbn(String pZtyhhkdromttutkbn) {
        ztyhhkdromttutkbn = pZtyhhkdromttutkbn;
    }

    private String ztykykdairiomttutkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDAIRIOMTTUTKBN)
    public String getZtykykdairiomttutkbn() {
        return ztykykdairiomttutkbn;
    }

    public void setZtykykdairiomttutkbn(String pZtykykdairiomttutkbn) {
        ztykykdairiomttutkbn = pZtykykdairiomttutkbn;
    }

    private String ztykykurtutkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKURTUTKBN)
    public String getZtykykurtutkbn() {
        return ztykykurtutkbn;
    }

    public void setZtykykurtutkbn(String pZtykykurtutkbn) {
        ztykykurtutkbn = pZtykykurtutkbn;
    }

    private String ztykzkurtutkbn1;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKURTUTKBN1)
    public String getZtykzkurtutkbn1() {
        return ztykzkurtutkbn1;
    }

    public void setZtykzkurtutkbn1(String pZtykzkurtutkbn1) {
        ztykzkurtutkbn1 = pZtykzkurtutkbn1;
    }

    private String ztykzkurtutkbn2;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKURTUTKBN2)
    public String getZtykzkurtutkbn2() {
        return ztykzkurtutkbn2;
    }

    public void setZtykzkurtutkbn2(String pZtykzkurtutkbn2) {
        ztykzkurtutkbn2 = pZtykzkurtutkbn2;
    }

    private String ztyhhkdrurtutkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRURTUTKBN)
    public String getZtyhhkdrurtutkbn() {
        return ztyhhkdrurtutkbn;
    }

    public void setZtyhhkdrurtutkbn(String pZtyhhkdrurtutkbn) {
        ztyhhkdrurtutkbn = pZtyhhkdrurtutkbn;
    }

    private String ztykykdairiurtutkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDAIRIURTUTKBN)
    public String getZtykykdairiurtutkbn() {
        return ztykykdairiurtutkbn;
    }

    public void setZtykykdairiurtutkbn(String pZtykykdairiurtutkbn) {
        ztykykdairiurtutkbn = pZtykykdairiurtutkbn;
    }

    private String ztykykaistmsgkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKAISTMSGKBN)
    public String getZtykykaistmsgkbn() {
        return ztykykaistmsgkbn;
    }

    public void setZtykykaistmsgkbn(String pZtykykaistmsgkbn) {
        ztykykaistmsgkbn = pZtykykaistmsgkbn;
    }

    private String ztykzkaistmsgkbn1;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKAISTMSGKBN1)
    public String getZtykzkaistmsgkbn1() {
        return ztykzkaistmsgkbn1;
    }

    public void setZtykzkaistmsgkbn1(String pZtykzkaistmsgkbn1) {
        ztykzkaistmsgkbn1 = pZtykzkaistmsgkbn1;
    }

    private String ztykzkaistmsgkbn2;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKAISTMSGKBN2)
    public String getZtykzkaistmsgkbn2() {
        return ztykzkaistmsgkbn2;
    }

    public void setZtykzkaistmsgkbn2(String pZtykzkaistmsgkbn2) {
        ztykzkaistmsgkbn2 = pZtykzkaistmsgkbn2;
    }

    private String ztyhhkaistmsgkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKAISTMSGKBN)
    public String getZtyhhkaistmsgkbn() {
        return ztyhhkaistmsgkbn;
    }

    public void setZtyhhkaistmsgkbn(String pZtyhhkaistmsgkbn) {
        ztyhhkaistmsgkbn = pZtyhhkaistmsgkbn;
    }

    private String ztyhhkdraistmsgkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRAISTMSGKBN)
    public String getZtyhhkdraistmsgkbn() {
        return ztyhhkdraistmsgkbn;
    }

    public void setZtyhhkdraistmsgkbn(String pZtyhhkdraistmsgkbn) {
        ztyhhkdraistmsgkbn = pZtyhhkdraistmsgkbn;
    }

    private String ztykykdairiaistmsgkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDAIRIAISTMSGKBN)
    public String getZtykykdairiaistmsgkbn() {
        return ztykykdairiaistmsgkbn;
    }

    public void setZtykykdairiaistmsgkbn(String pZtykykdairiaistmsgkbn) {
        ztykykdairiaistmsgkbn = pZtykykdairiaistmsgkbn;
    }

    private String ztysakujyokzknmkj;

    @Column(name=GenZT_TtdkKanTy.ZTYSAKUJYOKZKNMKJ)
    public String getZtysakujyokzknmkj() {
        return ztysakujyokzknmkj;
    }

    public void setZtysakujyokzknmkj(String pZtysakujyokzknmkj) {
        ztysakujyokzknmkj = pZtysakujyokzknmkj;
    }

    private String ztyttdknaiyoukbn;

    @Column(name=GenZT_TtdkKanTy.ZTYTTDKNAIYOUKBN)
    public String getZtyttdknaiyoukbn() {
        return ztyttdknaiyoukbn;
    }

    public void setZtyttdknaiyoukbn(String pZtyttdknaiyoukbn) {
        ztyttdknaiyoukbn = pZtyttdknaiyoukbn;
    }

    private String ztykzktaisyoukykkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKTAISYOUKYKKBN)
    public String getZtykzktaisyoukykkbn() {
        return ztykzktaisyoukykkbn;
    }

    public void setZtykzktaisyoukykkbn(String pZtykzktaisyoukykkbn) {
        ztykzktaisyoukykkbn = pZtykzktaisyoukykkbn;
    }

    private String ztyhhkdrtaisyoukykkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRTAISYOUKYKKBN)
    public String getZtyhhkdrtaisyoukykkbn() {
        return ztyhhkdrtaisyoukykkbn;
    }

    public void setZtyhhkdrtaisyoukykkbn(String pZtyhhkdrtaisyoukykkbn) {
        ztyhhkdrtaisyoukykkbn = pZtyhhkdrtaisyoukykkbn;
    }

    private String ztykykdairitaisyoukykkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDAIRITAISYOUKYKKBN)
    public String getZtykykdairitaisyoukykkbn() {
        return ztykykdairitaisyoukykkbn;
    }

    public void setZtykykdairitaisyoukykkbn(String pZtykykdairitaisyoukykkbn) {
        ztykykdairitaisyoukykkbn = pZtykykdairitaisyoukykkbn;
    }

    private String ztymoshnkniymsgkbn1;

    @Column(name=GenZT_TtdkKanTy.ZTYMOSHNKNIYMSGKBN1)
    public String getZtymoshnkniymsgkbn1() {
        return ztymoshnkniymsgkbn1;
    }

    public void setZtymoshnkniymsgkbn1(String pZtymoshnkniymsgkbn1) {
        ztymoshnkniymsgkbn1 = pZtymoshnkniymsgkbn1;
    }

    private String ztykykmoshnkniymsg2;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKMOSHNKNIYMSG2)
    public String getZtykykmoshnkniymsg2() {
        return ztykykmoshnkniymsg2;
    }

    public void setZtykykmoshnkniymsg2(String pZtykykmoshnkniymsg2) {
        ztykykmoshnkniymsg2 = pZtykykmoshnkniymsg2;
    }

    private String ztykzkmoshnkniymsg21;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKMOSHNKNIYMSG21)
    public String getZtykzkmoshnkniymsg21() {
        return ztykzkmoshnkniymsg21;
    }

    public void setZtykzkmoshnkniymsg21(String pZtykzkmoshnkniymsg21) {
        ztykzkmoshnkniymsg21 = pZtykzkmoshnkniymsg21;
    }

    private String ztykzkmoshnkniymsg22;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKMOSHNKNIYMSG22)
    public String getZtykzkmoshnkniymsg22() {
        return ztykzkmoshnkniymsg22;
    }

    public void setZtykzkmoshnkniymsg22(String pZtykzkmoshnkniymsg22) {
        ztykzkmoshnkniymsg22 = pZtykzkmoshnkniymsg22;
    }

    private String ztyhhkdrmoshnkniymsg2;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRMOSHNKNIYMSG2)
    public String getZtyhhkdrmoshnkniymsg2() {
        return ztyhhkdrmoshnkniymsg2;
    }

    public void setZtyhhkdrmoshnkniymsg2(String pZtyhhkdrmoshnkniymsg2) {
        ztyhhkdrmoshnkniymsg2 = pZtyhhkdrmoshnkniymsg2;
    }

    private String ztykykdairimoshnkniymsg2;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDAIRIMOSHNKNIYMSG2)
    public String getZtykykdairimoshnkniymsg2() {
        return ztykykdairimoshnkniymsg2;
    }

    public void setZtykykdairimoshnkniymsg2(String pZtykykdairimoshnkniymsg2) {
        ztykykdairimoshnkniymsg2 = pZtykykdairimoshnkniymsg2;
    }

    private String ztykykdrmsgkbn;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDRMSGKBN)
    public String getZtykykdrmsgkbn() {
        return ztykykdrmsgkbn;
    }

    public void setZtykykdrmsgkbn(String pZtykykdrmsgkbn) {
        ztykykdrmsgkbn = pZtykykdrmsgkbn;
    }

    private String ztykykhhkdrmsg;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKHHKDRMSG)
    public String getZtykykhhkdrmsg() {
        return ztykykhhkdrmsg;
    }

    public void setZtykykhhkdrmsg(String pZtykykhhkdrmsg) {
        ztykykhhkdrmsg = pZtykykhhkdrmsg;
    }

    private String ztykzkhhkdrmsg1;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKHHKDRMSG1)
    public String getZtykzkhhkdrmsg1() {
        return ztykzkhhkdrmsg1;
    }

    public void setZtykzkhhkdrmsg1(String pZtykzkhhkdrmsg1) {
        ztykzkhhkdrmsg1 = pZtykzkhhkdrmsg1;
    }

    private String ztykzkhhkdrmsg2;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKHHKDRMSG2)
    public String getZtykzkhhkdrmsg2() {
        return ztykzkhhkdrmsg2;
    }

    public void setZtykzkhhkdrmsg2(String pZtykzkhhkdrmsg2) {
        ztykzkhhkdrmsg2 = pZtykzkhhkdrmsg2;
    }

    private String ztyhhkdrnmkj;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRNMKJ)
    public String getZtyhhkdrnmkj() {
        return ztyhhkdrnmkj;
    }

    public void setZtyhhkdrnmkj(String pZtyhhkdrnmkj) {
        ztyhhkdrnmkj = pZtyhhkdrnmkj;
    }

    private String ztyduhubutumsg1;

    @Column(name=GenZT_TtdkKanTy.ZTYDUHUBUTUMSG1)
    public String getZtyduhubutumsg1() {
        return ztyduhubutumsg1;
    }

    public void setZtyduhubutumsg1(String pZtyduhubutumsg1) {
        ztyduhubutumsg1 = pZtyduhubutumsg1;
    }

    private String ztyduhubutumsg2;

    @Column(name=GenZT_TtdkKanTy.ZTYDUHUBUTUMSG2)
    public String getZtyduhubutumsg2() {
        return ztyduhubutumsg2;
    }

    public void setZtyduhubutumsg2(String pZtyduhubutumsg2) {
        ztyduhubutumsg2 = pZtyduhubutumsg2;
    }

    private String ztyduhubutumsg3;

    @Column(name=GenZT_TtdkKanTy.ZTYDUHUBUTUMSG3)
    public String getZtyduhubutumsg3() {
        return ztyduhubutumsg3;
    }

    public void setZtyduhubutumsg3(String pZtyduhubutumsg3) {
        ztyduhubutumsg3 = pZtyduhubutumsg3;
    }

    private String ztyduhubutumsg4;

    @Column(name=GenZT_TtdkKanTy.ZTYDUHUBUTUMSG4)
    public String getZtyduhubutumsg4() {
        return ztyduhubutumsg4;
    }

    public void setZtyduhubutumsg4(String pZtyduhubutumsg4) {
        ztyduhubutumsg4 = pZtyduhubutumsg4;
    }

    private String ztyduhubutumsg5;

    @Column(name=GenZT_TtdkKanTy.ZTYDUHUBUTUMSG5)
    public String getZtyduhubutumsg5() {
        return ztyduhubutumsg5;
    }

    public void setZtyduhubutumsg5(String pZtyduhubutumsg5) {
        ztyduhubutumsg5 = pZtyduhubutumsg5;
    }

    private String ztyduhubutumsg6;

    @Column(name=GenZT_TtdkKanTy.ZTYDUHUBUTUMSG6)
    public String getZtyduhubutumsg6() {
        return ztyduhubutumsg6;
    }

    public void setZtyduhubutumsg6(String pZtyduhubutumsg6) {
        ztyduhubutumsg6 = pZtyduhubutumsg6;
    }

    private String ztyduhubutumsg7;

    @Column(name=GenZT_TtdkKanTy.ZTYDUHUBUTUMSG7)
    public String getZtyduhubutumsg7() {
        return ztyduhubutumsg7;
    }

    public void setZtyduhubutumsg7(String pZtyduhubutumsg7) {
        ztyduhubutumsg7 = pZtyduhubutumsg7;
    }

    private String ztykykigaidhbtmsg1;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKIGAIDHBTMSG1)
    public String getZtykykigaidhbtmsg1() {
        return ztykykigaidhbtmsg1;
    }

    public void setZtykykigaidhbtmsg1(String pZtykykigaidhbtmsg1) {
        ztykykigaidhbtmsg1 = pZtykykigaidhbtmsg1;
    }

    private String ztykykigaidhbtmsg2;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKIGAIDHBTMSG2)
    public String getZtykykigaidhbtmsg2() {
        return ztykykigaidhbtmsg2;
    }

    public void setZtykykigaidhbtmsg2(String pZtykykigaidhbtmsg2) {
        ztykykigaidhbtmsg2 = pZtykykigaidhbtmsg2;
    }

    private String ztykykigaidhbtmsg3;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKIGAIDHBTMSG3)
    public String getZtykykigaidhbtmsg3() {
        return ztykykigaidhbtmsg3;
    }

    public void setZtykykigaidhbtmsg3(String pZtykykigaidhbtmsg3) {
        ztykykigaidhbtmsg3 = pZtykykigaidhbtmsg3;
    }

    private String ztykykigaidhbtmsg4;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKIGAIDHBTMSG4)
    public String getZtykykigaidhbtmsg4() {
        return ztykykigaidhbtmsg4;
    }

    public void setZtykykigaidhbtmsg4(String pZtykykigaidhbtmsg4) {
        ztykykigaidhbtmsg4 = pZtykykigaidhbtmsg4;
    }

    private String ztyyakkankiyakuhunyuuhyouji;

    @Column(name=GenZT_TtdkKanTy.ZTYYAKKANKIYAKUHUNYUUHYOUJI)
    public String getZtyyakkankiyakuhunyuuhyouji() {
        return ztyyakkankiyakuhunyuuhyouji;
    }

    public void setZtyyakkankiyakuhunyuuhyouji(String pZtyyakkankiyakuhunyuuhyouji) {
        ztyyakkankiyakuhunyuuhyouji = pZtyyakkankiyakuhunyuuhyouji;
    }

    private String ztykyktrktrshuunyuuhyouji;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKTRKTRSHUUNYUUHYOUJI)
    public String getZtykyktrktrshuunyuuhyouji() {
        return ztykyktrktrshuunyuuhyouji;
    }

    public void setZtykyktrktrshuunyuuhyouji(String pZtykyktrktrshuunyuuhyouji) {
        ztykyktrktrshuunyuuhyouji = pZtykyktrktrshuunyuuhyouji;
    }

    private String ztykzktrktrshuunyuuhyouji1;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKTRKTRSHUUNYUUHYOUJI1)
    public String getZtykzktrktrshuunyuuhyouji1() {
        return ztykzktrktrshuunyuuhyouji1;
    }

    public void setZtykzktrktrshuunyuuhyouji1(String pZtykzktrktrshuunyuuhyouji1) {
        ztykzktrktrshuunyuuhyouji1 = pZtykzktrktrshuunyuuhyouji1;
    }

    private String ztykzktrktrshuunyuuhyouji2;

    @Column(name=GenZT_TtdkKanTy.ZTYKZKTRKTRSHUUNYUUHYOUJI2)
    public String getZtykzktrktrshuunyuuhyouji2() {
        return ztykzktrktrshuunyuuhyouji2;
    }

    public void setZtykzktrktrshuunyuuhyouji2(String pZtykzktrktrshuunyuuhyouji2) {
        ztykzktrktrshuunyuuhyouji2 = pZtykzktrktrshuunyuuhyouji2;
    }

    private String ztykykdrhuunyuuhyouji;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDRHUUNYUUHYOUJI)
    public String getZtykykdrhuunyuuhyouji() {
        return ztykykdrhuunyuuhyouji;
    }

    public void setZtykykdrhuunyuuhyouji(String pZtykykdrhuunyuuhyouji) {
        ztykykdrhuunyuuhyouji = pZtykykdrhuunyuuhyouji;
    }

    private String ztyhhkdrhuunyuuhyouji;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRHUUNYUUHYOUJI)
    public String getZtyhhkdrhuunyuuhyouji() {
        return ztyhhkdrhuunyuuhyouji;
    }

    public void setZtyhhkdrhuunyuuhyouji(String pZtyhhkdrhuunyuuhyouji) {
        ztyhhkdrhuunyuuhyouji = pZtyhhkdrhuunyuuhyouji;
    }

    private String ztykykdairinmkj2;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDAIRINMKJ2)
    public String getZtykykdairinmkj2() {
        return ztykykdairinmkj2;
    }

    @DataConvert("toMultiByte")
    public void setZtykykdairinmkj2(String pZtykykdairinmkj2) {
        ztykykdairinmkj2 = pZtykykdairinmkj2;
    }

    private String ztykykdrseiymd;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDRSEIYMD)
    public String getZtykykdrseiymd() {
        return ztykykdrseiymd;
    }

    @DataConvert("toMultiByte")
    public void setZtykykdrseiymd(String pZtykykdrseiymd) {
        ztykykdrseiymd = pZtykykdrseiymd;
    }

    private String ztykykdryno;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDRYNO)
    public String getZtykykdryno() {
        return ztykykdryno;
    }

    public void setZtykykdryno(String pZtykykdryno) {
        ztykykdryno = pZtykykdryno;
    }

    private String ztykykdradr1kj;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDRADR1KJ)
    public String getZtykykdradr1kj() {
        return ztykykdradr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZtykykdradr1kj(String pZtykykdradr1kj) {
        ztykykdradr1kj = pZtykykdradr1kj;
    }

    private String ztykykdradr2kj;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDRADR2KJ)
    public String getZtykykdradr2kj() {
        return ztykykdradr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZtykykdradr2kj(String pZtykykdradr2kj) {
        ztykykdradr2kj = pZtykykdradr2kj;
    }

    private String ztykykdradr3kj;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDRADR3KJ)
    public String getZtykykdradr3kj() {
        return ztykykdradr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZtykykdradr3kj(String pZtykykdradr3kj) {
        ztykykdradr3kj = pZtykykdradr3kj;
    }

    private String ztykykdrtelno;

    @Column(name=GenZT_TtdkKanTy.ZTYKYKDRTELNO)
    public String getZtykykdrtelno() {
        return ztykykdrtelno;
    }

    public void setZtykykdrtelno(String pZtykykdrtelno) {
        ztykykdrtelno = pZtykykdrtelno;
    }

    private String ztyhhkdrnmkj2;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRNMKJ2)
    public String getZtyhhkdrnmkj2() {
        return ztyhhkdrnmkj2;
    }

    @DataConvert("toMultiByte")
    public void setZtyhhkdrnmkj2(String pZtyhhkdrnmkj2) {
        ztyhhkdrnmkj2 = pZtyhhkdrnmkj2;
    }

    private String ztyhhkdrseiymd;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRSEIYMD)
    public String getZtyhhkdrseiymd() {
        return ztyhhkdrseiymd;
    }

    @DataConvert("toMultiByte")
    public void setZtyhhkdrseiymd(String pZtyhhkdrseiymd) {
        ztyhhkdrseiymd = pZtyhhkdrseiymd;
    }

    private String ztyhhkdryno;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRYNO)
    public String getZtyhhkdryno() {
        return ztyhhkdryno;
    }

    public void setZtyhhkdryno(String pZtyhhkdryno) {
        ztyhhkdryno = pZtyhhkdryno;
    }

    private String ztyhhkdradr1kj;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRADR1KJ)
    public String getZtyhhkdradr1kj() {
        return ztyhhkdradr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZtyhhkdradr1kj(String pZtyhhkdradr1kj) {
        ztyhhkdradr1kj = pZtyhhkdradr1kj;
    }

    private String ztyhhkdradr2kj;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRADR2KJ)
    public String getZtyhhkdradr2kj() {
        return ztyhhkdradr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZtyhhkdradr2kj(String pZtyhhkdradr2kj) {
        ztyhhkdradr2kj = pZtyhhkdradr2kj;
    }

    private String ztyhhkdradr3kj;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRADR3KJ)
    public String getZtyhhkdradr3kj() {
        return ztyhhkdradr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZtyhhkdradr3kj(String pZtyhhkdradr3kj) {
        ztyhhkdradr3kj = pZtyhhkdradr3kj;
    }

    private String ztyhhkdrtelno;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRTELNO)
    public String getZtyhhkdrtelno() {
        return ztyhhkdrtelno;
    }

    public void setZtyhhkdrtelno(String pZtyhhkdrtelno) {
        ztyhhkdrtelno = pZtyhhkdrtelno;
    }

    private String ztyhhkdrtelnomtrkhyouji;

    @Column(name=GenZT_TtdkKanTy.ZTYHHKDRTELNOMTRKHYOUJI)
    public String getZtyhhkdrtelnomtrkhyouji() {
        return ztyhhkdrtelnomtrkhyouji;
    }

    public void setZtyhhkdrtelnomtrkhyouji(String pZtyhhkdrtelnomtrkhyouji) {
        ztyhhkdrtelnomtrkhyouji = pZtyhhkdrtelnomtrkhyouji;
    }

    private String ztykhsyono2;

    @Column(name=GenZT_TtdkKanTy.ZTYKHSYONO2)
    public String getZtykhsyono2() {
        return ztykhsyono2;
    }

    public void setZtykhsyono2(String pZtykhsyono2) {
        ztykhsyono2 = pZtykhsyono2;
    }

    private String ztykhsyono3;

    @Column(name=GenZT_TtdkKanTy.ZTYKHSYONO3)
    public String getZtykhsyono3() {
        return ztykhsyono3;
    }

    public void setZtykhsyono3(String pZtykhsyono3) {
        ztykhsyono3 = pZtykhsyono3;
    }

    private String ztykhsyono4;

    @Column(name=GenZT_TtdkKanTy.ZTYKHSYONO4)
    public String getZtykhsyono4() {
        return ztykhsyono4;
    }

    public void setZtykhsyono4(String pZtykhsyono4) {
        ztykhsyono4 = pZtykhsyono4;
    }

    private String ztykhsyono5;

    @Column(name=GenZT_TtdkKanTy.ZTYKHSYONO5)
    public String getZtykhsyono5() {
        return ztykhsyono5;
    }

    public void setZtykhsyono5(String pZtykhsyono5) {
        ztykhsyono5 = pZtykhsyono5;
    }

    private String ztykhsyono6;

    @Column(name=GenZT_TtdkKanTy.ZTYKHSYONO6)
    public String getZtykhsyono6() {
        return ztykhsyono6;
    }

    public void setZtykhsyono6(String pZtykhsyono6) {
        ztykhsyono6 = pZtykhsyono6;
    }

    private String ztykhsyono7;

    @Column(name=GenZT_TtdkKanTy.ZTYKHSYONO7)
    public String getZtykhsyono7() {
        return ztykhsyono7;
    }

    public void setZtykhsyono7(String pZtykhsyono7) {
        ztykhsyono7 = pZtykhsyono7;
    }

    private String ztykhsyono8;

    @Column(name=GenZT_TtdkKanTy.ZTYKHSYONO8)
    public String getZtykhsyono8() {
        return ztykhsyono8;
    }

    public void setZtykhsyono8(String pZtykhsyono8) {
        ztykhsyono8 = pZtykhsyono8;
    }

    private String ztykhsyono9;

    @Column(name=GenZT_TtdkKanTy.ZTYKHSYONO9)
    public String getZtykhsyono9() {
        return ztykhsyono9;
    }

    public void setZtykhsyono9(String pZtykhsyono9) {
        ztykhsyono9 = pZtykhsyono9;
    }

    private String ztykhsyono10;

    @Column(name=GenZT_TtdkKanTy.ZTYKHSYONO10)
    public String getZtykhsyono10() {
        return ztykhsyono10;
    }

    public void setZtykhsyono10(String pZtykhsyono10) {
        ztykhsyono10 = pZtykhsyono10;
    }

    private String ztykhmosno1;

    @Column(name=GenZT_TtdkKanTy.ZTYKHMOSNO1)
    public String getZtykhmosno1() {
        return ztykhmosno1;
    }

    public void setZtykhmosno1(String pZtykhmosno1) {
        ztykhmosno1 = pZtykhmosno1;
    }

    private String ztykhmosno2;

    @Column(name=GenZT_TtdkKanTy.ZTYKHMOSNO2)
    public String getZtykhmosno2() {
        return ztykhmosno2;
    }

    public void setZtykhmosno2(String pZtykhmosno2) {
        ztykhmosno2 = pZtykhmosno2;
    }

    private String ztykhmosno3;

    @Column(name=GenZT_TtdkKanTy.ZTYKHMOSNO3)
    public String getZtykhmosno3() {
        return ztykhmosno3;
    }

    public void setZtykhmosno3(String pZtykhmosno3) {
        ztykhmosno3 = pZtykhmosno3;
    }

    private String ztykhmosno4;

    @Column(name=GenZT_TtdkKanTy.ZTYKHMOSNO4)
    public String getZtykhmosno4() {
        return ztykhmosno4;
    }

    public void setZtykhmosno4(String pZtykhmosno4) {
        ztykhmosno4 = pZtykhmosno4;
    }

    private String ztykhmosno5;

    @Column(name=GenZT_TtdkKanTy.ZTYKHMOSNO5)
    public String getZtykhmosno5() {
        return ztykhmosno5;
    }

    public void setZtykhmosno5(String pZtykhmosno5) {
        ztykhmosno5 = pZtykhmosno5;
    }

    private String ztykhmosno6;

    @Column(name=GenZT_TtdkKanTy.ZTYKHMOSNO6)
    public String getZtykhmosno6() {
        return ztykhmosno6;
    }

    public void setZtykhmosno6(String pZtykhmosno6) {
        ztykhmosno6 = pZtykhmosno6;
    }

    private String ztykhmosno7;

    @Column(name=GenZT_TtdkKanTy.ZTYKHMOSNO7)
    public String getZtykhmosno7() {
        return ztykhmosno7;
    }

    public void setZtykhmosno7(String pZtykhmosno7) {
        ztykhmosno7 = pZtykhmosno7;
    }

    private String ztykhmosno8;

    @Column(name=GenZT_TtdkKanTy.ZTYKHMOSNO8)
    public String getZtykhmosno8() {
        return ztykhmosno8;
    }

    public void setZtykhmosno8(String pZtykhmosno8) {
        ztykhmosno8 = pZtykhmosno8;
    }

    private String ztykhmosno9;

    @Column(name=GenZT_TtdkKanTy.ZTYKHMOSNO9)
    public String getZtykhmosno9() {
        return ztykhmosno9;
    }

    public void setZtykhmosno9(String pZtykhmosno9) {
        ztykhmosno9 = pZtykhmosno9;
    }

    private String ztykhmosno10;

    @Column(name=GenZT_TtdkKanTy.ZTYKHMOSNO10)
    public String getZtykhmosno10() {
        return ztykhmosno10;
    }

    public void setZtykhmosno10(String pZtykhmosno10) {
        ztykhmosno10 = pZtykhmosno10;
    }

    private String ztyhnsnhutouhuunyuuhyouji;

    @Column(name=GenZT_TtdkKanTy.ZTYHNSNHUTOUHUUNYUUHYOUJI)
    public String getZtyhnsnhutouhuunyuuhyouji() {
        return ztyhnsnhutouhuunyuuhyouji;
    }

    public void setZtyhnsnhutouhuunyuuhyouji(String pZtyhnsnhutouhuunyuuhyouji) {
        ztyhnsnhutouhuunyuuhyouji = pZtyhnsnhutouhuunyuuhyouji;
    }

    private String ztyyobiv204;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV204)
    public String getZtyyobiv204() {
        return ztyyobiv204;
    }

    public void setZtyyobiv204(String pZtyyobiv204) {
        ztyyobiv204 = pZtyyobiv204;
    }

    private String ztyyobiv255x2;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV255X2)
    public String getZtyyobiv255x2() {
        return ztyyobiv255x2;
    }

    public void setZtyyobiv255x2(String pZtyyobiv255x2) {
        ztyyobiv255x2 = pZtyyobiv255x2;
    }

    private String ztyyobiv255x3;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV255X3)
    public String getZtyyobiv255x3() {
        return ztyyobiv255x3;
    }

    public void setZtyyobiv255x3(String pZtyyobiv255x3) {
        ztyyobiv255x3 = pZtyyobiv255x3;
    }

    private String ztyyobiv255x4;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV255X4)
    public String getZtyyobiv255x4() {
        return ztyyobiv255x4;
    }

    public void setZtyyobiv255x4(String pZtyyobiv255x4) {
        ztyyobiv255x4 = pZtyyobiv255x4;
    }

    private String ztyyobiv141;

    @Column(name=GenZT_TtdkKanTy.ZTYYOBIV141)
    public String getZtyyobiv141() {
        return ztyyobiv141;
    }

    public void setZtyyobiv141(String pZtyyobiv141) {
        ztyyobiv141 = pZtyyobiv141;
    }
}