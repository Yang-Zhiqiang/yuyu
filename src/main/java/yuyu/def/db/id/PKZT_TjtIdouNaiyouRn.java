package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouRn;
import yuyu.def.db.mapping.GenZT_TjtIdouNaiyouRn;
import yuyu.def.db.meta.GenQZT_TjtIdouNaiyouRn;
import yuyu.def.db.meta.QZT_TjtIdouNaiyouRn;

/**
 * 当日異動内容テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TjtIdouNaiyouRn}</td><td colspan="3">当日異動内容テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhuho2kyknokbn zrnhuho2kyknokbn}</td><td>（連携用）普保Ⅱ契約番号区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhuho2kykno zrnhuho2kykno}</td><td>（連携用）普保Ⅱ契約番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrecordsakujyohyouji</td><td>（連携用）レコード削除表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi01</td><td>（連携用）当日異動内容予備０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyouhncd</td><td>（連携用）（契約保全）商品コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhkykjyoutai</td><td>（連携用）（契約保全）契約状態</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhkykymd</td><td>（連携用）（契約保全）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhyuukousyoumetukbn</td><td>（連携用）（契約保全）有効消滅区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyoumetujiyuu</td><td>（連携用）（契約保全）消滅事由</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyoumetuymd</td><td>（連携用）（契約保全）消滅年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhtsntuukasyu</td><td>（連携用）（契約保全）通算用通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhtsnyousibous</td><td>（連携用）（契約保全）通算用死亡Ｓ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhtsnyouitijip</td><td>（連携用）（契約保全）通算用一時払Ｐ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhtsnyounkgns</td><td>（連携用）（契約保全）通算用年金原資</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhhrkkkn</td><td>（連携用）（契約保全）払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsntkhoukbn</td><td>（連携用）（契約保全）選択方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhbosyuuym</td><td>（連携用）（契約保全）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhkykhhkndouhyouji</td><td>（連携用）（契約保全）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhttdktyuuikbn1</td><td>（連携用）（契約保全）手続注意区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhttdktyuuikbn2</td><td>（連携用）（契約保全）手続注意区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhttdktyuuikbn3</td><td>（連携用）（契約保全）手続注意区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhttdktyuuikbn4</td><td>（連携用）（契約保全）手続注意区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhttdktyuuikbn5</td><td>（連携用）（契約保全）手続注意区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyouhnsdno</td><td>（連携用）（契約保全）商品世代番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhkaigomaehrtkykarihyj</td><td>（連携用）（契約保全）介護前払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhpyennykntkykarihyj</td><td>（連携用）（契約保全）保険料円入金特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhtsnyennyknkgk</td><td>（連携用）（契約保全）通算用円入金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhskmosno</td><td>（連携用）（契約保全）新契約時申込番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhhouteityotksyhnhyj</td><td>（連携用）（契約保全）法定貯蓄性商品表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhseiritujitrhkjikakkbn</td><td>（連携用）（契約保全）成立時取引時確認区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhhrkkeirokbn</td><td>（連携用）（契約保全）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi02</td><td>（連携用）当日異動内容予備０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsksyouhncd</td><td>（連携用）（新契約）商品コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskmosymd</td><td>（連携用）（新契約）申込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskkykymd</td><td>（連携用）（新契約）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsksknnkaisiymd</td><td>（連携用）（新契約）責任開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskseiritukbn</td><td>（連携用）（新契約）成立区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsksrsyoriymd</td><td>（連携用）（新契約）成立処理年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskmfrenflg</td><td>（連携用）（新契約）ＭＦ連動済フラグ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsksyono</td><td>（連携用）（新契約）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsktsntuukasyu</td><td>（連携用）（新契約）通算用通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsktsnyousibous</td><td>（連携用）（新契約）通算用死亡Ｓ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsktsnyouitijip</td><td>（連携用）（新契約）通算用一時払Ｐ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsktsnyounkgns</td><td>（連携用）（新契約）通算用年金原資</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskhrkkkn</td><td>（連携用）（新契約）払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsksntkhoukbn</td><td>（連携用）（新契約）選択方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskbosyuuym</td><td>（連携用）（新契約）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskkykhhkndouhyouji</td><td>（連携用）（新契約）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskmossyoumetukbn</td><td>（連携用）（新契約）申込消滅区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsksyouhnsdno</td><td>（連携用）（新契約）商品世代番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskkaigomaehrtkykarihyj</td><td>（連携用）（新契約）介護前払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskpyennykntkykarihyj</td><td>（連携用）（新契約）保険料円入金特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsktsnyennyknkgk</td><td>（連携用）（新契約）通算用円入金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskhrkkeirokbn</td><td>（連携用）（新契約）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi03</td><td>（連携用）当日異動内容予備０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyouhncd</td><td>（連携用）（年金支払）商品コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnknkshrstartymd</td><td>（連携用）（年金支払）年金支払開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkykymd</td><td>（連携用）（年金支払）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnknksyoumetucd</td><td>（連携用）（年金支払）年金消滅コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyoumtymd</td><td>（連携用）（年金支払）消滅年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkshrtuukasyu</td><td>（連携用）（年金支払）支払通貨種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkteinksyu</td><td>（連携用）（年金支払）定額年金年金種類</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnktsnnkgns</td><td>（連携用）（年金支払）通算用年金原資</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnknkukthhkndouhyouji</td><td>（連携用）（年金支払）年金受取人被保険者同一表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyouhnsdno</td><td>（連携用）（年金支払）商品世代番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi04</td><td>（連携用）当日異動内容予備０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknmei</td><td>（連携用）被保険者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjhhknmei</td><td>（連携用）漢字被保険者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknseiymd</td><td>（連携用）被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnewyno</td><td>（連携用）被保険者新郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknadr</td><td>（連携用）被保険者住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhkntelno</td><td>（連携用）被保険者電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknsykgycd</td><td>（連携用）被保険者職業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi05</td><td>（連携用）当日異動内容予備０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknm</td><td>（連携用）契約者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkyknm</td><td>（連携用）漢字契約者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseiymd</td><td>（連携用）契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi06</td><td>（連携用）当日異動内容予備０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkuktnm</td><td>（連携用）年金受取人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjnkuktnm</td><td>（連携用）漢字年金受取人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnenkinuktseiymd</td><td>（連携用）年金受取人生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi07</td><td>（連携用）当日異動内容予備０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsnsknewyno</td><td>（連携用）通信先新郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsinadr</td><td>（連携用）通信先住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsintelno</td><td>（連携用）通信先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi08</td><td>（連携用）当日異動内容予備０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnm1</td><td>（連携用）死亡受取人名１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjsbuktnm1</td><td>（連携用）漢字死亡受取人名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnm2</td><td>（連携用）死亡受取人名２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjsbuktnm2</td><td>（連携用）漢字死亡受取人名２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnm3</td><td>（連携用）死亡受取人名３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjsbuktnm3</td><td>（連携用）漢字死亡受取人名３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnm4</td><td>（連携用）死亡受取人名４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjsbuktnm4</td><td>（連携用）漢字死亡受取人名４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi09</td><td>（連携用）当日異動内容予備０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdrsknm</td><td>（連携用）指定代理請求人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjstdrsknm</td><td>（連携用）漢字指定代理請求人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykdairinm</td><td>（連携用）契約者代理人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkykdairinm</td><td>（連携用）漢字契約者代理人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi10</td><td>（連携用）当日異動内容予備１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbankcd</td><td>（連携用）銀行番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshitencd</td><td>（連携用）支店番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyokinkbn</td><td>（連携用）預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouzano7keta</td><td>（連携用）口座番号（７桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzmeiginmei</td><td>（連携用）口座名義人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkykdouhyouji</td><td>（連携用）口座名義契約者同一表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi12</td><td>（連携用）当日異動内容予備１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktourokunm1</td><td>（連携用）家族登録名１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkzktourokunm1</td><td>（連携用）漢字家族登録名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzktourokunm2</td><td>（連携用）家族登録名２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkzktourokunm2</td><td>（連携用）漢字家族登録名２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi13</td><td>（連携用）当日異動内容予備１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitencd1</td><td>（連携用）代理店コード（１）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbunwari1</td><td>（連携用）分担割合１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitencd2</td><td>（連携用）代理店コード（２）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbunwari2</td><td>（連携用）分担割合２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaatukaisosikicd</td><td>（連携用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbatukaisosikicd</td><td>（連携用）Ｂ扱者組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntjtidounaiyouyobi11</td><td>（連携用）当日異動内容予備１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TjtIdouNaiyouRn
 * @see     GenZT_TjtIdouNaiyouRn
 * @see     QZT_TjtIdouNaiyouRn
 * @see     GenQZT_TjtIdouNaiyouRn
 */
public class PKZT_TjtIdouNaiyouRn extends AbstractExDBPrimaryKey<ZT_TjtIdouNaiyouRn, PKZT_TjtIdouNaiyouRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_TjtIdouNaiyouRn() {
    }

    public PKZT_TjtIdouNaiyouRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {
        zrnhuho2kyknokbn = pZrnhuho2kyknokbn;
        zrnhuho2kykno = pZrnhuho2kykno;
    }

    @Transient
    @Override
    public Class<ZT_TjtIdouNaiyouRn> getEntityClass() {
        return ZT_TjtIdouNaiyouRn.class;
    }

    private String zrnhuho2kyknokbn;

    public String getZrnhuho2kyknokbn() {
        return zrnhuho2kyknokbn;
    }

    public void setZrnhuho2kyknokbn(String pZrnhuho2kyknokbn) {
        zrnhuho2kyknokbn = pZrnhuho2kyknokbn;
    }
    private String zrnhuho2kykno;

    public String getZrnhuho2kykno() {
        return zrnhuho2kykno;
    }

    public void setZrnhuho2kykno(String pZrnhuho2kykno) {
        zrnhuho2kykno = pZrnhuho2kykno;
    }

}