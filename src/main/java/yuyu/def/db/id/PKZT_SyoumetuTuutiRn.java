package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_SyoumetuTuutiRn;
import yuyu.def.db.mapping.GenZT_SyoumetuTuutiRn;
import yuyu.def.db.meta.GenQZT_SyoumetuTuutiRn;
import yuyu.def.db.meta.QZT_SyoumetuTuutiRn;

/**
 * 消滅通知Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SyoumetuTuutiRn}</td><td colspan="3">消滅通知Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsyoruicd</td><td>（連携用）書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyouhyouymdkj</td><td>（連携用）帳票作成日（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn</td><td>（連携用）発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantousitukbn</td><td>（連携用）担当室区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsksdoufuukbn</td><td>（連携用）請求書同封区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmynosinkokuiraidoufuukbn</td><td>（連携用）マイナンバー申告依頼同封区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratemongonumukbn</td><td>（連携用）為替レート文言有無区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv13</td><td>（連携用）予備項目Ｖ１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10</td><td>（連携用）案内収納用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskyno</td><td>（連携用）送付先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskadr1kj</td><td>（連携用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr2kj</td><td>（連携用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr3kj</td><td>（連携用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshsnmkj</td><td>（連携用）送付先名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv44</td><td>（連携用）予備項目Ｖ４４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x2</td><td>（連携用）案内収納用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawyno</td><td>（連携用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawadr1kj</td><td>（連携用）問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr2kj</td><td>（連携用）問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr3kj</td><td>（連携用）問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntoiawasekaisyanmkj</td><td>（連携用）問合せ先会社名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawsosikikj</td><td>（連携用）問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawtelnov14</td><td>（連携用）問合せ先電話番号Ｖ１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawteluktkkanou1x18keta</td><td>（連携用）問合せ先電話受付可能時間１（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawteluktkkanou2x18keta</td><td>（連携用）問合せ先電話受付可能時間２（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv50</td><td>（連携用）予備項目Ｖ５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x3</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon50keta1</td><td>（連携用）挨拶文言（５０桁）１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon50keta2</td><td>（連携用）挨拶文言（５０桁）２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon50keta3</td><td>（連携用）挨拶文言（５０桁）３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon50keta4</td><td>（連携用）挨拶文言（５０桁）４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon50keta5</td><td>（連携用）挨拶文言（５０桁）５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon50keta6</td><td>（連携用）挨拶文言（５０桁）６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv120</td><td>（連携用）予備項目Ｖ１２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x4</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono2</td><td>（連携用）証券番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj</td><td>（連携用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj</td><td>（連携用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykymdseireki</td><td>（連携用）契約年月日（西暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhknsyurui30keta</td><td>（連携用）保険種類（３０桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyoumetuymd</td><td>（連携用）消滅日</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnoharaimodosikn</td><td>（連携用）お払戻金</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv20</td><td>（連携用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x5</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrymd11keta</td><td>（連携用）支払日（１１桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
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
 *  <tr><td>zrnyobiv215</td><td>（連携用）予備項目Ｖ２１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x6</td><td>（連携用）案内収納用予備項目Ｎ１０＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrnaiyouhskmongon1</td><td>（連携用）支払内容補足文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrnaiyouhskmongon2</td><td>（連携用）支払内容補足文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv40</td><td>（連携用）予備項目Ｖ４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x7</td><td>（連携用）案内収納用予備項目Ｎ１０＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbanknmkj</td><td>（連携用）銀行名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsitennmkj</td><td>（連携用）支店名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyokinkbn</td><td>（連携用）預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouzano12keta</td><td>（連携用）口座番号（１２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzmeiginmknhan</td><td>（連携用）口座名義人氏名（カナ）（半角）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzsyurui</td><td>（連携用）口座種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv26x2</td><td>（連携用）予備項目Ｖ２６＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x8</td><td>（連携用）案内収納用予備項目Ｎ１０＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>zrnyobiv74</td><td>（連携用）予備項目Ｖ７４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x9</td><td>（連携用）案内収納用予備項目Ｎ１０＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
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
 *  <tr><td>zrnyobiv255</td><td>（連携用）予備項目Ｖ２５５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x10</td><td>（連携用）案内収納用予備項目Ｎ１０＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteisyutusrmongon1</td><td>（連携用）ご提出いただく書類文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnteisyutusrmongon2</td><td>（連携用）ご提出いただく書類文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnteisyutusrmongon3</td><td>（連携用）ご提出いただく書類文言３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnmsgyobi1</td><td>（連携用）メッセージ予備項目１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x11</td><td>（連携用）案内収納用予備項目Ｎ１０＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyasyomeimongon1</td><td>（連携用）請求者署名欄文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyasyomeimongon2</td><td>（連携用）請求者署名欄文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyasyomeimongon3</td><td>（連携用）請求者署名欄文言３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyasyomeimongon4</td><td>（連携用）請求者署名欄文言４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyasyomeimongon5</td><td>（連携用）請求者署名欄文言５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyasyomeimongon6</td><td>（連携用）請求者署名欄文言６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyasyomeimongon7</td><td>（連携用）請求者署名欄文言７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyasyomeimongon8</td><td>（連携用）請求者署名欄文言８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyasyomeimongon9</td><td>（連携用）請求者署名欄文言９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyagenyno</td><td>（連携用）請求者現住所郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyagenadr1</td><td>（連携用）請求者現住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyagenadr2</td><td>（連携用）請求者現住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuusyagenadr3</td><td>（連携用）請求者現住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseikyuuyagentelno</td><td>（連携用）請求者現住所電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoritugisyasyozokunm</td><td>（連携用）取次者所属名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntoritugisyakjncd</td><td>（連携用）取次者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoritugisyanm</td><td>（連携用）取次者氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhozonkkny</td><td>（連携用）保存期間（年）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv168</td><td>（連携用）予備項目Ｖ１６８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x12</td><td>（連携用）案内収納用予備項目Ｎ１０＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteisyutusrmongon4</td><td>（連携用）ご提出いただく書類文言４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv155</td><td>（連携用）予備項目Ｖ１５５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv97</td><td>（連携用）予備項目Ｖ９７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SyoumetuTuutiRn
 * @see     GenZT_SyoumetuTuutiRn
 * @see     QZT_SyoumetuTuutiRn
 * @see     GenQZT_SyoumetuTuutiRn
 */
public class PKZT_SyoumetuTuutiRn extends AbstractExDBPrimaryKey<ZT_SyoumetuTuutiRn, PKZT_SyoumetuTuutiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_SyoumetuTuutiRn() {
    }

    public PKZT_SyoumetuTuutiRn(
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
    public Class<ZT_SyoumetuTuutiRn> getEntityClass() {
        return ZT_SyoumetuTuutiRn.class;
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