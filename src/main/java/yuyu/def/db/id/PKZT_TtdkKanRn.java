package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TtdkKanRn;
import yuyu.def.db.mapping.GenZT_TtdkKanRn;
import yuyu.def.db.meta.GenQZT_TtdkKanRn;
import yuyu.def.db.meta.QZT_TtdkKanRn;

/**
 * 手続完了Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanRn}</td><td colspan="3">手続完了Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsyoruicd</td><td>（連携用）書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyouhyouymdwa</td><td>（連携用）帳票作成日（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn</td><td>（連携用）発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantousitukbn</td><td>（連携用）担当室区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyodouhuukbn</td><td>（連携用）証券同封区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv21</td><td>（連携用）予備項目Ｖ２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskyno</td><td>（連携用）送付先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskadr1kj</td><td>（連携用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr2kj</td><td>（連携用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr3kj</td><td>（連携用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshsnmkjttdk</td><td>（連携用）送付先名（漢字）（手続完了）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshsnmkjttdk2</td><td>（連携用）送付先名（漢字）（手続完了）２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv3</td><td>（連携用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawyno</td><td>（連携用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawadr1kj</td><td>（連携用）問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr2kj</td><td>（連携用）問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntoiawasekaisyanmkj</td><td>（連携用）問合せ先会社名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawsosikikj</td><td>（連携用）問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawtelnov14</td><td>（連携用）問合せ先電話番号Ｖ１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawteluktkkanou1x18keta</td><td>（連携用）問合せ先電話受付可能時間１（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawteluktkkanou2x18keta</td><td>（連携用）問合せ先電話受付可能時間２（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv26</td><td>（連携用）予備項目Ｖ２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntetudukisyunm</td><td>（連携用）手続種類名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyokakmngnumkbn</td><td>（連携用）証券確認文言有無区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono2</td><td>（連携用）証券番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj</td><td>（連携用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj</td><td>（連携用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv28</td><td>（連携用）予備項目Ｖ２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyou1</td><td>（連携用）手続内容１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyou2</td><td>（連携用）手続内容２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyou3</td><td>（連携用）手続内容３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyou4</td><td>（連携用）手続内容４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyou5</td><td>（連携用）手続内容５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyou6</td><td>（連携用）手続内容６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyou7</td><td>（連携用）手続内容７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyou8</td><td>（連携用）手続内容８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyou9</td><td>（連携用）手続内容９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyou10</td><td>（連携用）手続内容１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyouumukbn</td><td>（連携用）手続内容有無区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykniyuhnkkbn</td><td>（連携用）契約内容変更区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykniyuhnkymd</td><td>（連携用）契約内容変更日</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykniyuhnkinfo</td><td>（連携用）契約内容変更情報</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykniyuhnkkngkhugou1</td><td>（連携用）契約内容変更金額明細符号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykniyuhnkkngk1</td><td>（連携用）契約内容変更金額１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykniyuhnkkngktuksyu1</td><td>（連携用）契約内容変更金額通貨種類１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykniyuhnkkngkhugou2</td><td>（連携用）契約内容変更金額明細符号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykniyuhnkkngk2</td><td>（連携用）契約内容変更金額２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykniyuhnkkngktuksyu2</td><td>（連携用）契約内容変更金額通貨種類２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv102</td><td>（連携用）予備項目Ｖ１０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiharaibiwareki</td><td>（連携用）支払日（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaiyakuymdwa</td><td>（連携用）解約日（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntekiyou1</td><td>（連携用）摘要１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrkngkmeisaihugou1</td><td>（連携用）支払金額明細符号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai1</td><td>（連携用）支払金額明細１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgktuukasyu1</td><td>（連携用）支払金額通貨種類１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikou1</td><td>（連携用）備考１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntekiyou2</td><td>（連携用）摘要２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrkngkmeisaihugou2</td><td>（連携用）支払金額明細符号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai2</td><td>（連携用）支払金額明細２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgktuukasyu2</td><td>（連携用）支払金額通貨種類２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikou2</td><td>（連携用）備考２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntekiyou3</td><td>（連携用）摘要３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrkngkmeisaihugou3</td><td>（連携用）支払金額明細符号３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai3</td><td>（連携用）支払金額明細３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgktuukasyu3</td><td>（連携用）支払金額通貨種類３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikou3</td><td>（連携用）備考３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntekiyou4</td><td>（連携用）摘要４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrkngkmeisaihugou4</td><td>（連携用）支払金額明細符号４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai4</td><td>（連携用）支払金額明細４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgktuukasyu4</td><td>（連携用）支払金額通貨種類４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikou4</td><td>（連携用）備考４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntekiyou5</td><td>（連携用）摘要５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrkngkmeisaihugou5</td><td>（連携用）支払金額明細符号５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai5</td><td>（連携用）支払金額明細５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgktuukasyu5</td><td>（連携用）支払金額通貨種類５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikou5</td><td>（連携用）備考５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntekiyou6</td><td>（連携用）摘要６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrkngkmeisaihugou6</td><td>（連携用）支払金額明細符号６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai6</td><td>（連携用）支払金額明細６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgktuukasyu6</td><td>（連携用）支払金額通貨種類６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikou6</td><td>（連携用）備考６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntekiyou7</td><td>（連携用）摘要７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrkngkmeisaihugou7</td><td>（連携用）支払金額明細符号７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai7</td><td>（連携用）支払金額明細７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgktuukasyu7</td><td>（連携用）支払金額通貨種類７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikou7</td><td>（連携用）備考７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntekiyou8</td><td>（連携用）摘要８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrkngkmeisaihugou8</td><td>（連携用）支払金額明細符号８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai8</td><td>（連携用）支払金額明細８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgktuukasyu8</td><td>（連携用）支払金額通貨種類８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikou8</td><td>（連携用）備考８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntekiyou9</td><td>（連携用）摘要９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrkngkmeisaihugou9</td><td>（連携用）支払金額明細符号９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai9</td><td>（連携用）支払金額明細９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgktuukasyu9</td><td>（連携用）支払金額通貨種類９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikou9</td><td>（連携用）備考９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntekiyou10</td><td>（連携用）摘要１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrkngkmeisaihugou10</td><td>（連携用）支払金額明細符号１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai10</td><td>（連携用）支払金額明細１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgktuukasyu10</td><td>（連携用）支払金額通貨種類１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbikou10</td><td>（連携用）備考１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrgkgoukei</td><td>（連携用）支払額合計</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrtuukasyu</td><td>（連携用）支払通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndseisanshrttdknm</td><td>（連携用）Ｄ精算支払手続名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv26x3</td><td>（連携用）予備項目Ｖ２６＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbanknmkj</td><td>（連携用）銀行名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsitennmkj</td><td>（連携用）支店名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyokinkbn</td><td>（連携用）預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouzano12keta</td><td>（連携用）口座番号（１２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzmeiginmknhan</td><td>（連携用）口座名義人氏名（カナ）（半角）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouzasyuruikbn</td><td>（連携用）口座種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv26x2</td><td>（連携用）予備項目Ｖ２６＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsynykngk</td><td>（連携用）収入金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsynykngktuukasyu</td><td>（連携用）収入金額通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtykeihi</td><td>（連携用）必要経費</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtykeihituukasyu</td><td>（連携用）必要経費通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrkyksyahtykeihi</td><td>（連携用）お支払時の契約者の必要経費</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrkykhtykeihituukasyu</td><td>（連携用）お支払時の契約者の必要経費通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngsbnrkzthtykeihi</td><td>（連携用）源泉分離課税対象の必要経費</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngsbnrkzthtykeihituksyu</td><td>（連携用）源泉分離課税対象の必要経費通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngsbnrkztsaeki</td><td>（連携用）源泉分離課税対象の差益</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngsbnrkztsaekituksyu</td><td>（連携用）源泉分離課税対象の差益通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzeimunaiyouhensyuctrlkbn</td><td>（連携用）税務内容編集制御区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzeimumongonoutkbn</td><td>（連携用）税務文言出力区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzeimumongon1</td><td>（連携用）税務文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzeimumongon2</td><td>（連携用）税務文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzeimumongon3</td><td>（連携用）税務文言３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzeimumongon4</td><td>（連携用）税務文言４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzeimumongon5</td><td>（連携用）税務文言５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyendthnkzeimuinfohskkbn</td><td>（連携用）円建変更時税務情報補足区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv36</td><td>（連携用）予備項目Ｖ３６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnosirasehyoudai</td><td>（連携用）お知らせ表題</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon1</td><td>（連携用）お知らせ文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon2</td><td>（連携用）お知らせ文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon3</td><td>（連携用）お知らせ文言３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon4</td><td>（連携用）お知らせ文言４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon5</td><td>（連携用）お知らせ文言５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon6</td><td>（連携用）お知らせ文言６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon7</td><td>（連携用）お知らせ文言７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon8</td><td>（連携用）お知らせ文言８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon9</td><td>（連携用）お知らせ文言９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon10</td><td>（連携用）お知らせ文言１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon11</td><td>（連携用）お知らせ文言１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon12</td><td>（連携用）お知らせ文言１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon13</td><td>（連携用）お知らせ文言１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon14</td><td>（連携用）お知らせ文言１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon15</td><td>（連携用）お知らせ文言１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon16</td><td>（連携用）お知らせ文言１６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon17</td><td>（連携用）お知らせ文言１７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon18</td><td>（連携用）お知らせ文言１８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon19</td><td>（連携用）お知らせ文言１９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon20</td><td>（連携用）お知らせ文言２０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon21</td><td>（連携用）お知らせ文言２１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon22</td><td>（連携用）お知らせ文言２２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon23</td><td>（連携用）お知らせ文言２３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon24</td><td>（連携用）お知らせ文言２４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon25</td><td>（連携用）お知らせ文言２５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon26</td><td>（連携用）お知らせ文言２６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon27</td><td>（連携用）お知らせ文言２７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon28</td><td>（連携用）お知らせ文言２８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon29</td><td>（連携用）お知らせ文言２９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon30</td><td>（連携用）お知らせ文言３０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon31</td><td>（連携用）お知らせ文言３１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon32</td><td>（連携用）お知らせ文言３２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon33</td><td>（連携用）お知らせ文言３３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon34</td><td>（連携用）お知らせ文言３４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon35</td><td>（連携用）お知らせ文言３５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon36</td><td>（連携用）お知らせ文言３６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon37</td><td>（連携用）お知らせ文言３７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon38</td><td>（連携用）お知らせ文言３８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon39</td><td>（連携用）お知らせ文言３９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon40</td><td>（連携用）お知らせ文言４０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon41</td><td>（連携用）お知らせ文言４１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon42</td><td>（連携用）お知らせ文言４２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon43</td><td>（連携用）お知らせ文言４３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon44</td><td>（連携用）お知らせ文言４４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon45</td><td>（連携用）お知らせ文言４５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46</td><td>（連携用）お知らせ文言４６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon47</td><td>（連携用）お知らせ文言４７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon48</td><td>（連携用）お知らせ文言４８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon49</td><td>（連携用）お知らせ文言４９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon50</td><td>（連携用）お知らせ文言５０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosiraseinjihuyouhyouji</td><td>（連携用）お知らせ印字不要表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv254</td><td>（連携用）予備項目Ｖ２５４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrnaiyouhskmongon1</td><td>（連携用）支払内容補足文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrnaiyouhskmongon2</td><td>（連携用）支払内容補足文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndocumentid</td><td>（連携用）ドキュメントＩＤ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsksmongonkbn1</td><td>（連携用）請求書文言区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsksmongonkbn2</td><td>（連携用）請求書文言区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoritugisyasyozokunm</td><td>（連携用）取次者所属名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntoritugisyakjncd</td><td>（連携用）取次者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoritugisyanm</td><td>（連携用）取次者氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhozonkkny</td><td>（連携用）保存期間（年）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsintelno</td><td>（連携用）通信先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv141</td><td>（連携用）予備項目Ｖ１４１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkkbn1</td><td>（連携用）登録家族区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzknmkj1</td><td>（連携用）登録家族名（漢字）１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkseiymd1zenkaku</td><td>（連携用）登録家族１人目生年月日</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkyno1</td><td>（連携用）登録家族郵便番号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkadr1kj1</td><td>（連携用）登録家族住所１（漢字）１　</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkadr2kj1</td><td>（連携用）登録家族住所２（漢字）１　</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkadr3kj1</td><td>（連携用）登録家族住所３（漢字）１　</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzktelno1</td><td>（連携用）登録家族電話番号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzktelnomtrkhyouji1</td><td>（連携用）登録家族電話番号未登録表示１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkkbn2</td><td>（連携用）登録家族区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzknmkj2</td><td>（連携用）登録家族名（漢字）２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkseiymd2zenkaku</td><td>（連携用）登録家族２人目生年月日</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkyno2</td><td>（連携用）登録家族郵便番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkadr1kj2</td><td>（連携用）登録家族住所１（漢字）２　</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkadr2kj2</td><td>（連携用）登録家族住所２（漢字）２　</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzkadr3kj2</td><td>（連携用）登録家族住所３（漢字）２　</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzktelno2</td><td>（連携用）登録家族電話番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdairinmkj</td><td>（連携用）契約者代理人名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykomttutkbn</td><td>（連携用）契約者用表通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkomttutkbn1</td><td>（連携用）家族１用表通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkomttutkbn2</td><td>（連携用）家族２用表通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkomttutkbn</td><td>（連携用）被保険者用表通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkdromttutkbn</td><td>（連携用）被保険者代理人用表通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdairiomttutkbn</td><td>（連携用）契約者代理人用表通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykurtutkbn</td><td>（連携用）契約者用裏通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkurtutkbn1</td><td>（連携用）家族１用裏通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkurtutkbn2</td><td>（連携用）家族２用裏通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkdrurtutkbn</td><td>（連携用）被保険者代理人用裏通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdairiurtutkbn</td><td>（連携用）契約者代理人用裏通知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykaistmsgkbn</td><td>（連携用）契約者用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkaistmsgkbn1</td><td>（連携用）家族１用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkaistmsgkbn2</td><td>（連携用）家族２用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkaistmsgkbn</td><td>（連携用）被保険者用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkdraistmsgkbn</td><td>（連携用）被保険者代理人用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdairiaistmsgkbn</td><td>（連携用）契約者代理人用挨拶ＭＳＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakujyokzknmkj</td><td>（連携用）削除家族名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnttdknaiyoukbn</td><td>（連携用）手続内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktaisyoukykkbn</td><td>（連携用）家族用対象契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkdrtaisyoukykkbn</td><td>（連携用）被保険者代理人用対象契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdairitaisyoukykkbn</td><td>（連携用）契約者代理人用対象契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmoshnkniymsgkbn1</td><td>（連携用）申込変更内容ＭＳＧ区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykmoshnkniymsg2</td><td>（連携用）契約者用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkmoshnkniymsg21</td><td>（連携用）家族１用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkmoshnkniymsg22</td><td>（連携用）家族２用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkdrmoshnkniymsg2</td><td>（連携用）被保険者代理人用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdairimoshnkniymsg2</td><td>（連携用）契約者代理人用申込変更内容ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdrmsgkbn</td><td>（連携用）契約者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykhhkdrmsg</td><td>（連携用）契約者用被保険者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkhhkdrmsg1</td><td>（連携用）家族１用被保険者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkhhkdrmsg2</td><td>（連携用）家族２用被保険者代理ＭＳＧ区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkdrnmkj</td><td>（連携用）被保険者代理人名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnduhubutumsg1</td><td>（連携用）同封物ＭＳＧ区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnduhubutumsg2</td><td>（連携用）同封物ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnduhubutumsg3</td><td>（連携用）同封物ＭＳＧ区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnduhubutumsg4</td><td>（連携用）同封物ＭＳＧ区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnduhubutumsg5</td><td>（連携用）同封物ＭＳＧ区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnduhubutumsg6</td><td>（連携用）同封物ＭＳＧ区分６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnduhubutumsg7</td><td>（連携用）同封物ＭＳＧ区分７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykigaidhbtmsg1</td><td>（連携用）契約者以外用同封物ＭＳＧ区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykigaidhbtmsg2</td><td>（連携用）契約者以外用同封物ＭＳＧ区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykigaidhbtmsg3</td><td>（連携用）契約者以外用同封物ＭＳＧ区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykigaidhbtmsg4</td><td>（連携用）契約者以外用同封物ＭＳＧ区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyakkankiyakuhunyuuhyouji</td><td>（連携用）約款規約封入表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyktrktrshuunyuuhyouji</td><td>（連携用）登録チラシ封入表示（契）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktrktrshuunyuuhyouji1</td><td>（連携用）登録チラシ封入表示（家族１）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktrktrshuunyuuhyouji2</td><td>（連携用）登録チラシ封入表示（家族２）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdrhuunyuuhyouji</td><td>（連携用）契約者代理封入表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkdrhuunyuuhyouji</td><td>（連携用）被保険者代理封入表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdairinmkj2</td><td>（連携用）契約者代理人名（漢字）２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykdrseiymd</td><td>（連携用）契約者代理人生年月日</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykdryno</td><td>（連携用）契約者代理人郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdradr1kj</td><td>（連携用）契約者代理人住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykdradr2kj</td><td>（連携用）契約者代理人住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykdradr3kj</td><td>（連携用）契約者代理人住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykdrtelno</td><td>（連携用）契約者代理人電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkdrnmkj2</td><td>（連携用）被保険者代理人名（漢字）２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhkdrseiymd</td><td>（連携用）被保険者代理人生年月日</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhkdryno</td><td>（連携用）被保険者代理人郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkdradr1kj</td><td>（連携用）被保険者代理人住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhkdradr2kj</td><td>（連携用）被保険者代理人住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhkdradr3kj</td><td>（連携用）被保険者代理人住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhkdrtelno</td><td>（連携用）被保険者代理人電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhkdrtelnomtrkhyouji</td><td>（連携用）被保険者代理人電話番号未登録表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyono2</td><td>（連携用）（契約保全）証券番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyono3</td><td>（連携用）（契約保全）証券番号３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyono4</td><td>（連携用）（契約保全）証券番号４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyono5</td><td>（連携用）（契約保全）証券番号５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyono6</td><td>（連携用）（契約保全）証券番号６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyono7</td><td>（連携用）（契約保全）証券番号７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyono8</td><td>（連携用）（契約保全）証券番号８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyono9</td><td>（連携用）（契約保全）証券番号９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyono10</td><td>（連携用）（契約保全）証券番号１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhmosno1</td><td>（連携用）（契約保全）申込番号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhmosno2</td><td>（連携用）（契約保全）申込番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhmosno3</td><td>（連携用）（契約保全）申込番号３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhmosno4</td><td>（連携用）（契約保全）申込番号４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhmosno5</td><td>（連携用）（契約保全）申込番号５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhmosno6</td><td>（連携用）（契約保全）申込番号６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhmosno7</td><td>（連携用）（契約保全）申込番号７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhmosno8</td><td>（連携用）（契約保全）申込番号８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhmosno9</td><td>（連携用）（契約保全）申込番号９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhmosno10</td><td>（連携用）（契約保全）申込番号１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhnsnhutouhuunyuuhyouji</td><td>（連携用）返信用封筒封入表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv204</td><td>（連携用）予備項目Ｖ２０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv255x2</td><td>（連携用）予備項目Ｖ２５５＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv255x3</td><td>（連携用）予備項目Ｖ２５５＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv255x4</td><td>（連携用）予備項目Ｖ２５５＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanRn
 * @see     GenZT_TtdkKanRn
 * @see     QZT_TtdkKanRn
 * @see     GenQZT_TtdkKanRn
 */
public class PKZT_TtdkKanRn extends AbstractExDBPrimaryKey<ZT_TtdkKanRn, PKZT_TtdkKanRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_TtdkKanRn() {
    }

    public PKZT_TtdkKanRn(
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
    public Class<ZT_TtdkKanRn> getEntityClass() {
        return ZT_TtdkKanRn.class;
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