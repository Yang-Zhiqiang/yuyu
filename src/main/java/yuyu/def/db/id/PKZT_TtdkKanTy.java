package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TtdkKanTy;
import yuyu.def.db.mapping.GenZT_TtdkKanTy;
import yuyu.def.db.meta.GenQZT_TtdkKanTy;
import yuyu.def.db.meta.QZT_TtdkKanTy;

/**
 * 手続完了Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanTy}</td><td colspan="3">手続完了Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouhyouymdwa</td><td>（中継用）帳票作成日（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantousitukbn</td><td>（中継用）担当室区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyodouhuukbn</td><td>（中継用）証券同封区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv21</td><td>（中継用）予備項目Ｖ２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskyno</td><td>（中継用）送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr1kj</td><td>（中継用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr2kj</td><td>（中継用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr3kj</td><td>（中継用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshsnmkjttdk</td><td>（中継用）送付先名（漢字）（手続完了）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshsnmkjttdk2</td><td>（中継用）送付先名（漢字）（手続完了）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv3</td><td>（中継用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawyno</td><td>（中継用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr1kj</td><td>（中継用）問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr2kj</td><td>（中継用）問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoiawasekaisyanmkj</td><td>（中継用）問合せ先会社名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawsosikikj</td><td>（中継用）問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawtelnov14</td><td>（中継用）問合せ先電話番号Ｖ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawteluktkkanou1x18keta</td><td>（中継用）問合せ先電話受付可能時間１（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawteluktkkanou2x18keta</td><td>（中継用）問合せ先電話受付可能時間２（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv26</td><td>（中継用）予備項目Ｖ２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytetudukisyunm</td><td>（中継用）手続種類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokakmngnumkbn</td><td>（中継用）証券確認文言有無区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono2</td><td>（中継用）証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj</td><td>（中継用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv28</td><td>（中継用）予備項目Ｖ２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyou1</td><td>（中継用）手続内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyou2</td><td>（中継用）手続内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyou3</td><td>（中継用）手続内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyou4</td><td>（中継用）手続内容４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyou5</td><td>（中継用）手続内容５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyou6</td><td>（中継用）手続内容６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyou7</td><td>（中継用）手続内容７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyou8</td><td>（中継用）手続内容８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyou9</td><td>（中継用）手続内容９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyou10</td><td>（中継用）手続内容１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyouumukbn</td><td>（中継用）手続内容有無区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyuhnkkbn</td><td>（中継用）契約内容変更区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyuhnkymd</td><td>（中継用）契約内容変更日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyuhnkinfo</td><td>（中継用）契約内容変更情報</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyuhnkkngkhugou1</td><td>（中継用）契約内容変更金額明細符号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyuhnkkngk1</td><td>（中継用）契約内容変更金額１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyuhnkkngktuksyu1</td><td>（中継用）契約内容変更金額通貨種類１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyuhnkkngkhugou2</td><td>（中継用）契約内容変更金額明細符号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyuhnkkngk2</td><td>（中継用）契約内容変更金額２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyuhnkkngktuksyu2</td><td>（中継用）契約内容変更金額通貨種類２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv102</td><td>（中継用）予備項目Ｖ１０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiharaibiwareki</td><td>（中継用）支払日（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiyakuymdwa</td><td>（中継用）解約日（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou1</td><td>（中継用）摘要１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkngkmeisaihugou1</td><td>（中継用）支払金額明細符号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai1</td><td>（中継用）支払金額明細１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgktuukasyu1</td><td>（中継用）支払金額通貨種類１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikou1</td><td>（中継用）備考１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou2</td><td>（中継用）摘要２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkngkmeisaihugou2</td><td>（中継用）支払金額明細符号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai2</td><td>（中継用）支払金額明細２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgktuukasyu2</td><td>（中継用）支払金額通貨種類２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikou2</td><td>（中継用）備考２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou3</td><td>（中継用）摘要３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkngkmeisaihugou3</td><td>（中継用）支払金額明細符号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai3</td><td>（中継用）支払金額明細３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgktuukasyu3</td><td>（中継用）支払金額通貨種類３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikou3</td><td>（中継用）備考３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou4</td><td>（中継用）摘要４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkngkmeisaihugou4</td><td>（中継用）支払金額明細符号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai4</td><td>（中継用）支払金額明細４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgktuukasyu4</td><td>（中継用）支払金額通貨種類４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikou4</td><td>（中継用）備考４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou5</td><td>（中継用）摘要５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkngkmeisaihugou5</td><td>（中継用）支払金額明細符号５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai5</td><td>（中継用）支払金額明細５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgktuukasyu5</td><td>（中継用）支払金額通貨種類５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikou5</td><td>（中継用）備考５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou6</td><td>（中継用）摘要６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkngkmeisaihugou6</td><td>（中継用）支払金額明細符号６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai6</td><td>（中継用）支払金額明細６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgktuukasyu6</td><td>（中継用）支払金額通貨種類６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikou6</td><td>（中継用）備考６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou7</td><td>（中継用）摘要７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkngkmeisaihugou7</td><td>（中継用）支払金額明細符号７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai7</td><td>（中継用）支払金額明細７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgktuukasyu7</td><td>（中継用）支払金額通貨種類７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikou7</td><td>（中継用）備考７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou8</td><td>（中継用）摘要８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkngkmeisaihugou8</td><td>（中継用）支払金額明細符号８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai8</td><td>（中継用）支払金額明細８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgktuukasyu8</td><td>（中継用）支払金額通貨種類８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikou8</td><td>（中継用）備考８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou9</td><td>（中継用）摘要９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkngkmeisaihugou9</td><td>（中継用）支払金額明細符号９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai9</td><td>（中継用）支払金額明細９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgktuukasyu9</td><td>（中継用）支払金額通貨種類９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikou9</td><td>（中継用）備考９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou10</td><td>（中継用）摘要１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkngkmeisaihugou10</td><td>（中継用）支払金額明細符号１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai10</td><td>（中継用）支払金額明細１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgktuukasyu10</td><td>（中継用）支払金額通貨種類１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybikou10</td><td>（中継用）備考１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkgoukei</td><td>（中継用）支払額合計</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrtuukasyu</td><td>（中継用）支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydseisanshrttdknm</td><td>（中継用）Ｄ精算支払手続名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv26x3</td><td>（中継用）予備項目Ｖ２６＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybanknmkj</td><td>（中継用）銀行名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysitennmkj</td><td>（中継用）支店名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyokinkbn</td><td>（中継用）預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouzano12keta</td><td>（中継用）口座番号（１２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzmeiginmknhan</td><td>（中継用）口座名義人氏名（カナ）（半角）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouzasyuruikbn</td><td>（中継用）口座種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv26x2</td><td>（中継用）予備項目Ｖ２６＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysynykngk</td><td>（中継用）収入金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysynykngktuukasyu</td><td>（中継用）収入金額通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhtykeihi</td><td>（中継用）必要経費</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhtykeihituukasyu</td><td>（中継用）必要経費通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkyksyahtykeihi</td><td>（中継用）お支払時の契約者の必要経費</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrkykhtykeihituukasyu</td><td>（中継用）お支払時の契約者の必要経費通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygsbnrkzthtykeihi</td><td>（中継用）源泉分離課税対象の必要経費</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygsbnrkzthtykeihituksyu</td><td>（中継用）源泉分離課税対象の必要経費通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygsbnrkztsaeki</td><td>（中継用）源泉分離課税対象の差益</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygsbnrkztsaekituksyu</td><td>（中継用）源泉分離課税対象の差益通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimunaiyouhensyuctrlkbn</td><td>（中継用）税務内容編集制御区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimumongonoutkbn</td><td>（中継用）税務文言出力区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimumongon1</td><td>（中継用）税務文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimumongon2</td><td>（中継用）税務文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimumongon3</td><td>（中継用）税務文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimumongon4</td><td>（中継用）税務文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimumongon5</td><td>（中継用）税務文言５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyendthnkzeimuinfohskkbn</td><td>（中継用）円建変更時税務情報補足区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv36</td><td>（中継用）予備項目Ｖ３６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasehyoudai</td><td>（中継用）お知らせ表題</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon1</td><td>（中継用）お知らせ文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon2</td><td>（中継用）お知らせ文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon3</td><td>（中継用）お知らせ文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon4</td><td>（中継用）お知らせ文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon5</td><td>（中継用）お知らせ文言５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon6</td><td>（中継用）お知らせ文言６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon7</td><td>（中継用）お知らせ文言７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon8</td><td>（中継用）お知らせ文言８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon9</td><td>（中継用）お知らせ文言９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon10</td><td>（中継用）お知らせ文言１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon11</td><td>（中継用）お知らせ文言１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon12</td><td>（中継用）お知らせ文言１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon13</td><td>（中継用）お知らせ文言１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon14</td><td>（中継用）お知らせ文言１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon15</td><td>（中継用）お知らせ文言１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon16</td><td>（中継用）お知らせ文言１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon17</td><td>（中継用）お知らせ文言１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon18</td><td>（中継用）お知らせ文言１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon19</td><td>（中継用）お知らせ文言１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon20</td><td>（中継用）お知らせ文言２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon21</td><td>（中継用）お知らせ文言２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon22</td><td>（中継用）お知らせ文言２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon23</td><td>（中継用）お知らせ文言２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon24</td><td>（中継用）お知らせ文言２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon25</td><td>（中継用）お知らせ文言２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon26</td><td>（中継用）お知らせ文言２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon27</td><td>（中継用）お知らせ文言２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon28</td><td>（中継用）お知らせ文言２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon29</td><td>（中継用）お知らせ文言２９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon30</td><td>（中継用）お知らせ文言３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon31</td><td>（中継用）お知らせ文言３１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon32</td><td>（中継用）お知らせ文言３２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon33</td><td>（中継用）お知らせ文言３３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon34</td><td>（中継用）お知らせ文言３４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon35</td><td>（中継用）お知らせ文言３５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon36</td><td>（中継用）お知らせ文言３６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon37</td><td>（中継用）お知らせ文言３７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon38</td><td>（中継用）お知らせ文言３８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon39</td><td>（中継用）お知らせ文言３９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon40</td><td>（中継用）お知らせ文言４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon41</td><td>（中継用）お知らせ文言４１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon42</td><td>（中継用）お知らせ文言４２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon43</td><td>（中継用）お知らせ文言４３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon44</td><td>（中継用）お知らせ文言４４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon45</td><td>（中継用）お知らせ文言４５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon46</td><td>（中継用）お知らせ文言４６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon47</td><td>（中継用）お知らせ文言４７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon48</td><td>（中継用）お知らせ文言４８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon49</td><td>（中継用）お知らせ文言４９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon50</td><td>（中継用）お知らせ文言５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosiraseinjihuyouhyouji</td><td>（中継用）お知らせ印字不要表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv254</td><td>（中継用）予備項目Ｖ２５４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrnaiyouhskmongon1</td><td>（中継用）支払内容補足文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrnaiyouhskmongon2</td><td>（中継用）支払内容補足文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydocumentid</td><td>（中継用）ドキュメントＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysksmongonkbn1</td><td>（中継用）請求書文言区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysksmongonkbn2</td><td>（中継用）請求書文言区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoritugisyasyozokunm</td><td>（中継用）取次者所属名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoritugisyakjncd</td><td>（中継用）取次者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoritugisyanm</td><td>（中継用）取次者氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhozonkkny</td><td>（中継用）保存期間（年）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsintelno</td><td>（中継用）通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkkbn1</td><td>（中継用）登録家族区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzknmkj1</td><td>（中継用）登録家族名（漢字）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkseiymd1zenkaku</td><td>（中継用）登録家族１人目生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkyno1</td><td>（中継用）登録家族郵便番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkadr1kj1</td><td>（中継用）登録家族住所１（漢字）１　</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkadr2kj1</td><td>（中継用）登録家族住所２（漢字）１　</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkadr3kj1</td><td>（中継用）登録家族住所３（漢字）１　</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzktelno1</td><td>（中継用）登録家族電話番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzktelnomtrkhyouji1</td><td>（中継用）登録家族電話番号未登録表示１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkkbn2</td><td>（中継用）登録家族区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzknmkj2</td><td>（中継用）登録家族名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkseiymd2zenkaku</td><td>（中継用）登録家族２人目生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkyno2</td><td>（中継用）登録家族郵便番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkadr1kj2</td><td>（中継用）登録家族住所１（漢字）２　</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkadr2kj2</td><td>（中継用）登録家族住所２（漢字）２　</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzkadr3kj2</td><td>（中継用）登録家族住所３（漢字）２　</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzktelno2</td><td>（中継用）登録家族電話番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdairinmkj</td><td>（中継用）契約者代理人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykomttutkbn</td><td>（中継用）契約者用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkomttutkbn1</td><td>（中継用）家族１用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkomttutkbn2</td><td>（中継用）家族２用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkomttutkbn</td><td>（中継用）被保険者用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdromttutkbn</td><td>（中継用）被保険者代理人用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdairiomttutkbn</td><td>（中継用）契約者代理人用表通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykurtutkbn</td><td>（中継用）契約者用裏通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkurtutkbn1</td><td>（中継用）家族１用裏通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkurtutkbn2</td><td>（中継用）家族２用裏通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdrurtutkbn</td><td>（中継用）被保険者代理人用裏通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdairiurtutkbn</td><td>（中継用）契約者代理人用裏通知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykaistmsgkbn</td><td>（中継用）契約者用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkaistmsgkbn1</td><td>（中継用）家族１用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkaistmsgkbn2</td><td>（中継用）家族２用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkaistmsgkbn</td><td>（中継用）被保険者用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdraistmsgkbn</td><td>（中継用）被保険者代理人用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdairiaistmsgkbn</td><td>（中継用）契約者代理人用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakujyokzknmkj</td><td>（中継用）削除家族名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdknaiyoukbn</td><td>（中継用）手続内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktaisyoukykkbn</td><td>（中継用）家族用対象契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdrtaisyoukykkbn</td><td>（中継用）被保険者代理人用対象契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdairitaisyoukykkbn</td><td>（中継用）契約者代理人用対象契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymoshnkniymsgkbn1</td><td>（中継用）申込変更内容ＭＳＧ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykmoshnkniymsg2</td><td>（中継用）契約者用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkmoshnkniymsg21</td><td>（中継用）家族１用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkmoshnkniymsg22</td><td>（中継用）家族２用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdrmoshnkniymsg2</td><td>（中継用）被保険者代理人用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdairimoshnkniymsg2</td><td>（中継用）契約者代理人用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrmsgkbn</td><td>（中継用）契約者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykhhkdrmsg</td><td>（中継用）契約者用被保険者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkhhkdrmsg1</td><td>（中継用）家族１用被保険者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkhhkdrmsg2</td><td>（中継用）家族２用被保険者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdrnmkj</td><td>（中継用）被保険者代理人名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyduhubutumsg1</td><td>（中継用）同封物ＭＳＧ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyduhubutumsg2</td><td>（中継用）同封物ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyduhubutumsg3</td><td>（中継用）同封物ＭＳＧ区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyduhubutumsg4</td><td>（中継用）同封物ＭＳＧ区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyduhubutumsg5</td><td>（中継用）同封物ＭＳＧ区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyduhubutumsg6</td><td>（中継用）同封物ＭＳＧ区分６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyduhubutumsg7</td><td>（中継用）同封物ＭＳＧ区分７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykigaidhbtmsg1</td><td>（中継用）契約者以外用同封物ＭＳＧ区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykigaidhbtmsg2</td><td>（中継用）契約者以外用同封物ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykigaidhbtmsg3</td><td>（中継用）契約者以外用同封物ＭＳＧ区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykigaidhbtmsg4</td><td>（中継用）契約者以外用同封物ＭＳＧ区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyakkankiyakuhunyuuhyouji</td><td>（中継用）約款規約封入表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyktrktrshuunyuuhyouji</td><td>（中継用）登録チラシ封入表示（契）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktrktrshuunyuuhyouji1</td><td>（中継用）登録チラシ封入表示（家族１）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktrktrshuunyuuhyouji2</td><td>（中継用）登録チラシ封入表示（家族２）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrhuunyuuhyouji</td><td>（中継用）契約者代理封入表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdrhuunyuuhyouji</td><td>（中継用）被保険者代理封入表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdairinmkj2</td><td>（中継用）契約者代理人名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrseiymd</td><td>（中継用）契約者代理人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdryno</td><td>（中継用）契約者代理人郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdradr1kj</td><td>（中継用）契約者代理人住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdradr2kj</td><td>（中継用）契約者代理人住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdradr3kj</td><td>（中継用）契約者代理人住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrtelno</td><td>（中継用）契約者代理人電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdrnmkj2</td><td>（中継用）被保険者代理人名（漢字）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdrseiymd</td><td>（中継用）被保険者代理人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdryno</td><td>（中継用）被保険者代理人郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdradr1kj</td><td>（中継用）被保険者代理人住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdradr2kj</td><td>（中継用）被保険者代理人住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdradr3kj</td><td>（中継用）被保険者代理人住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdrtelno</td><td>（中継用）被保険者代理人電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkdrtelnomtrkhyouji</td><td>（中継用）被保険者代理人電話番号未登録表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyono2</td><td>（中継用）（契約保全）証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyono3</td><td>（中継用）（契約保全）証券番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyono4</td><td>（中継用）（契約保全）証券番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyono5</td><td>（中継用）（契約保全）証券番号５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyono6</td><td>（中継用）（契約保全）証券番号６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyono7</td><td>（中継用）（契約保全）証券番号７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyono8</td><td>（中継用）（契約保全）証券番号８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyono9</td><td>（中継用）（契約保全）証券番号９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyono10</td><td>（中継用）（契約保全）証券番号１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhmosno1</td><td>（中継用）（契約保全）申込番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhmosno2</td><td>（中継用）（契約保全）申込番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhmosno3</td><td>（中継用）（契約保全）申込番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhmosno4</td><td>（中継用）（契約保全）申込番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhmosno5</td><td>（中継用）（契約保全）申込番号５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhmosno6</td><td>（中継用）（契約保全）申込番号６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhmosno7</td><td>（中継用）（契約保全）申込番号７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhmosno8</td><td>（中継用）（契約保全）申込番号８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhmosno9</td><td>（中継用）（契約保全）申込番号９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhmosno10</td><td>（中継用）（契約保全）申込番号１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhnsnhutouhuunyuuhyouji</td><td>（中継用）返信用封筒封入表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv204</td><td>（中継用）予備項目Ｖ２０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv255x2</td><td>（中継用）予備項目Ｖ２５５＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv255x3</td><td>（中継用）予備項目Ｖ２５５＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv255x4</td><td>（中継用）予備項目Ｖ２５５＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv141</td><td>（中継用）予備項目Ｖ１４１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanTy
 * @see     GenZT_TtdkKanTy
 * @see     QZT_TtdkKanTy
 * @see     GenQZT_TtdkKanTy
 */
public class PKZT_TtdkKanTy extends AbstractExDBPrimaryKey<ZT_TtdkKanTy, PKZT_TtdkKanTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_TtdkKanTy() {
    }

    public PKZT_TtdkKanTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
        ztysikibetuno = pZtysikibetuno;
    }

    @Transient
    @Override
    public Class<ZT_TtdkKanTy> getEntityClass() {
        return ZT_TtdkKanTy.class;
    }

    private String ztytyouhyouymd;

    public String getZtytyouhyouymd() {
        return ztytyouhyouymd;
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        ztytyouhyouymd = pZtytyouhyouymd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztysikibetuno;

    public String getZtysikibetuno() {
        return ztysikibetuno;
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        ztysikibetuno = pZtysikibetuno;
    }

}