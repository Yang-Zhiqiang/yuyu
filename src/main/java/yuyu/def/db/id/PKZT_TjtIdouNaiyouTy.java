package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouTy;
import yuyu.def.db.mapping.GenZT_TjtIdouNaiyouTy;
import yuyu.def.db.meta.GenQZT_TjtIdouNaiyouTy;
import yuyu.def.db.meta.QZT_TjtIdouNaiyouTy;

/**
 * 当日異動内容テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TjtIdouNaiyouTy}</td><td colspan="3">当日異動内容テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhuho2kyknokbn ztyhuho2kyknokbn}</td><td>（中継用）普保Ⅱ契約番号区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyhuho2kykno ztyhuho2kykno}</td><td>（中継用）普保Ⅱ契約番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrecordsakujyohyouji</td><td>（中継用）レコード削除表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi01</td><td>（中継用）当日異動内容予備０１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyouhncd</td><td>（中継用）（契約保全）商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhkykjyoutai</td><td>（中継用）（契約保全）契約状態</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhkykymd</td><td>（中継用）（契約保全）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhyuukousyoumetukbn</td><td>（中継用）（契約保全）有効消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyoumetujiyuu</td><td>（中継用）（契約保全）消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyoumetuymd</td><td>（中継用）（契約保全）消滅年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhtsntuukasyu</td><td>（中継用）（契約保全）通算用通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhtsnyousibous</td><td>（中継用）（契約保全）通算用死亡Ｓ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhtsnyouitijip</td><td>（中継用）（契約保全）通算用一時払Ｐ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhtsnyounkgns</td><td>（中継用）（契約保全）通算用年金原資</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhhrkkkn</td><td>（中継用）（契約保全）払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsntkhoukbn</td><td>（中継用）（契約保全）選択方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhbosyuuym</td><td>（中継用）（契約保全）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhkykhhkndouhyouji</td><td>（中継用）（契約保全）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhttdktyuuikbn1</td><td>（中継用）（契約保全）手続注意区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhttdktyuuikbn2</td><td>（中継用）（契約保全）手続注意区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhttdktyuuikbn3</td><td>（中継用）（契約保全）手続注意区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhttdktyuuikbn4</td><td>（中継用）（契約保全）手続注意区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhttdktyuuikbn5</td><td>（中継用）（契約保全）手続注意区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyouhnsdno</td><td>（中継用）（契約保全）商品世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhkaigomaehrtkykarihyj</td><td>（中継用）（契約保全）介護前払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhpyennykntkykarihyj</td><td>（中継用）（契約保全）保険料円入金特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhtsnyennyknkgk</td><td>（中継用）（契約保全）通算用円入金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhskmosno</td><td>（中継用）（契約保全）新契約時申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhhouteityotksyhnhyj</td><td>（中継用）（契約保全）法定貯蓄性商品表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhseiritujitrhkjikakkbn</td><td>（中継用）（契約保全）成立時取引時確認区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhhrkkeirokbn</td><td>（中継用）（契約保全）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi02</td><td>（中継用）当日異動内容予備０２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysksyouhncd</td><td>（中継用）（新契約）商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskmosymd</td><td>（中継用）（新契約）申込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskkykymd</td><td>（中継用）（新契約）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysksknnkaisiymd</td><td>（中継用）（新契約）責任開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskseiritukbn</td><td>（中継用）（新契約）成立区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysksrsyoriymd</td><td>（中継用）（新契約）成立処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskmfrenflg</td><td>（中継用）（新契約）ＭＦ連動済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysksyono</td><td>（中継用）（新契約）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysktsntuukasyu</td><td>（中継用）（新契約）通算用通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysktsnyousibous</td><td>（中継用）（新契約）通算用死亡Ｓ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysktsnyouitijip</td><td>（中継用）（新契約）通算用一時払Ｐ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysktsnyounkgns</td><td>（中継用）（新契約）通算用年金原資</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskhrkkkn</td><td>（中継用）（新契約）払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysksntkhoukbn</td><td>（中継用）（新契約）選択方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskbosyuuym</td><td>（中継用）（新契約）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskkykhhkndouhyouji</td><td>（中継用）（新契約）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskmossyoumetukbn</td><td>（中継用）（新契約）申込消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysksyouhnsdno</td><td>（中継用）（新契約）商品世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskkaigomaehrtkykarihyj</td><td>（中継用）（新契約）介護前払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskpyennykntkykarihyj</td><td>（中継用）（新契約）保険料円入金特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysktsnyennyknkgk</td><td>（中継用）（新契約）通算用円入金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskhrkkeirokbn</td><td>（中継用）（新契約）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi03</td><td>（中継用）当日異動内容予備０３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyouhncd</td><td>（中継用）（年金支払）商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknkshrstartymd</td><td>（中継用）（年金支払）年金支払開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkkykymd</td><td>（中継用）（年金支払）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknksyoumetucd</td><td>（中継用）（年金支払）年金消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyoumtymd</td><td>（中継用）（年金支払）消滅年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrtuukasyu</td><td>（中継用）（年金支払）支払通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkteinksyu</td><td>（中継用）（年金支払）定額年金年金種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynktsnnkgns</td><td>（中継用）（年金支払）通算用年金原資</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynknkukthhkndouhyouji</td><td>（中継用）（年金支払）年金受取人被保険者同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyouhnsdno</td><td>（中継用）（年金支払）商品世代番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi04</td><td>（中継用）当日異動内容予備０４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknmei</td><td>（中継用）被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjhhknmei</td><td>（中継用）漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseiymd</td><td>（中継用）被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnewyno</td><td>（中継用）被保険者新郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknadr</td><td>（中継用）被保険者住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhkntelno</td><td>（中継用）被保険者電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknsykgycd</td><td>（中継用）被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi05</td><td>（中継用）当日異動内容予備０５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknm</td><td>（中継用）契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkyknm</td><td>（中継用）漢字契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseiymd</td><td>（中継用）契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi06</td><td>（中継用）当日異動内容予備０６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkuktnm</td><td>（中継用）年金受取人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjnkuktnm</td><td>（中継用）漢字年金受取人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinuktseiymd</td><td>（中継用）年金受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi07</td><td>（中継用）当日異動内容予備０７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsnsknewyno</td><td>（中継用）通信先新郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinadr</td><td>（中継用）通信先住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsintelno</td><td>（中継用）通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi08</td><td>（中継用）当日異動内容予備０８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnm1</td><td>（中継用）死亡受取人名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjsbuktnm1</td><td>（中継用）漢字死亡受取人名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnm2</td><td>（中継用）死亡受取人名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjsbuktnm2</td><td>（中継用）漢字死亡受取人名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnm3</td><td>（中継用）死亡受取人名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjsbuktnm3</td><td>（中継用）漢字死亡受取人名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnm4</td><td>（中継用）死亡受取人名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjsbuktnm4</td><td>（中継用）漢字死亡受取人名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi09</td><td>（中継用）当日異動内容予備０９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdrsknm</td><td>（中継用）指定代理請求人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjstdrsknm</td><td>（中継用）漢字指定代理請求人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdairinm</td><td>（中継用）契約者代理人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkykdairinm</td><td>（中継用）漢字契約者代理人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi10</td><td>（中継用）当日異動内容予備１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybankcd</td><td>（中継用）銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshitencd</td><td>（中継用）支店番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyokinkbn</td><td>（中継用）預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouzano7keta</td><td>（中継用）口座番号（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzmeiginmei</td><td>（中継用）口座名義人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkykdouhyouji</td><td>（中継用）口座名義契約者同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi12</td><td>（中継用）当日異動内容予備１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktourokunm1</td><td>（中継用）家族登録名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkzktourokunm1</td><td>（中継用）漢字家族登録名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktourokunm2</td><td>（中継用）家族登録名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkzktourokunm2</td><td>（中継用）漢字家族登録名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi13</td><td>（中継用）当日異動内容予備１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitencd1</td><td>（中継用）代理店コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybunwari1</td><td>（中継用）分担割合１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitencd2</td><td>（中継用）代理店コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybunwari2</td><td>（中継用）分担割合２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaatukaisosikicd</td><td>（中継用）Ａ扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybatukaisosikicd</td><td>（中継用）Ｂ扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytjtidounaiyouyobi11</td><td>（中継用）当日異動内容予備１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TjtIdouNaiyouTy
 * @see     GenZT_TjtIdouNaiyouTy
 * @see     QZT_TjtIdouNaiyouTy
 * @see     GenQZT_TjtIdouNaiyouTy
 */
public class PKZT_TjtIdouNaiyouTy extends AbstractExDBPrimaryKey<ZT_TjtIdouNaiyouTy, PKZT_TjtIdouNaiyouTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_TjtIdouNaiyouTy() {
    }

    public PKZT_TjtIdouNaiyouTy(String pZtyhuho2kyknokbn, String pZtyhuho2kykno) {
        ztyhuho2kyknokbn = pZtyhuho2kyknokbn;
        ztyhuho2kykno = pZtyhuho2kykno;
    }

    @Transient
    @Override
    public Class<ZT_TjtIdouNaiyouTy> getEntityClass() {
        return ZT_TjtIdouNaiyouTy.class;
    }

    private String ztyhuho2kyknokbn;

    public String getZtyhuho2kyknokbn() {
        return ztyhuho2kyknokbn;
    }

    public void setZtyhuho2kyknokbn(String pZtyhuho2kyknokbn) {
        ztyhuho2kyknokbn = pZtyhuho2kyknokbn;
    }
    private String ztyhuho2kykno;

    public String getZtyhuho2kykno() {
        return ztyhuho2kykno;
    }

    public void setZtyhuho2kykno(String pZtyhuho2kykno) {
        ztyhuho2kykno = pZtyhuho2kykno;
    }

}