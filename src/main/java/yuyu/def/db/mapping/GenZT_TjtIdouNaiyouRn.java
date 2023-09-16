package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouRn;
import yuyu.def.db.id.PKZT_TjtIdouNaiyouRn;
import yuyu.def.db.meta.GenQZT_TjtIdouNaiyouRn;
import yuyu.def.db.meta.QZT_TjtIdouNaiyouRn;

/**
 * 当日異動内容テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TjtIdouNaiyouRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TjtIdouNaiyouRn}</td><td colspan="3">当日異動内容テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnhuho2kyknokbn zrnhuho2kyknokbn}</td><td>（連携用）普保Ⅱ契約番号区分</td><td align="center">{@link PKZT_TjtIdouNaiyouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhuho2kykno zrnhuho2kykno}</td><td>（連携用）普保Ⅱ契約番号</td><td align="center">{@link PKZT_TjtIdouNaiyouRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrecordsakujyohyouji zrnrecordsakujyohyouji}</td><td>（連携用）レコード削除表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi01 zrntjtidounaiyouyobi01}</td><td>（連携用）当日異動内容予備０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyouhncd zrnkhsyouhncd}</td><td>（連携用）（契約保全）商品コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhkykjyoutai zrnkhkykjyoutai}</td><td>（連携用）（契約保全）契約状態</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhkykymd zrnkhkykymd}</td><td>（連携用）（契約保全）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhyuukousyoumetukbn zrnkhyuukousyoumetukbn}</td><td>（連携用）（契約保全）有効消滅区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyoumetujiyuu zrnkhsyoumetujiyuu}</td><td>（連携用）（契約保全）消滅事由</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyoumetuymd zrnkhsyoumetuymd}</td><td>（連携用）（契約保全）消滅年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhtsntuukasyu zrnkhtsntuukasyu}</td><td>（連携用）（契約保全）通算用通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhtsnyousibous zrnkhtsnyousibous}</td><td>（連携用）（契約保全）通算用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhtsnyouitijip zrnkhtsnyouitijip}</td><td>（連携用）（契約保全）通算用一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhtsnyounkgns zrnkhtsnyounkgns}</td><td>（連携用）（契約保全）通算用年金原資</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhhrkkkn zrnkhhrkkkn}</td><td>（連携用）（契約保全）払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsntkhoukbn zrnkhsntkhoukbn}</td><td>（連携用）（契約保全）選択方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhbosyuuym zrnkhbosyuuym}</td><td>（連携用）（契約保全）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhkykhhkndouhyouji zrnkhkykhhkndouhyouji}</td><td>（連携用）（契約保全）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhttdktyuuikbn1 zrnkhttdktyuuikbn1}</td><td>（連携用）（契約保全）手続注意区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhttdktyuuikbn2 zrnkhttdktyuuikbn2}</td><td>（連携用）（契約保全）手続注意区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhttdktyuuikbn3 zrnkhttdktyuuikbn3}</td><td>（連携用）（契約保全）手続注意区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhttdktyuuikbn4 zrnkhttdktyuuikbn4}</td><td>（連携用）（契約保全）手続注意区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhttdktyuuikbn5 zrnkhttdktyuuikbn5}</td><td>（連携用）（契約保全）手続注意区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyouhnsdno zrnkhsyouhnsdno}</td><td>（連携用）（契約保全）商品世代番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhkaigomaehrtkykarihyj zrnkhkaigomaehrtkykarihyj}</td><td>（連携用）（契約保全）介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhpyennykntkykarihyj zrnkhpyennykntkykarihyj}</td><td>（連携用）（契約保全）保険料円入金特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhtsnyennyknkgk zrnkhtsnyennyknkgk}</td><td>（連携用）（契約保全）通算用円入金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhskmosno zrnkhskmosno}</td><td>（連携用）（契約保全）新契約時申込番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhhouteityotksyhnhyj zrnkhhouteityotksyhnhyj}</td><td>（連携用）（契約保全）法定貯蓄性商品表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhseiritujitrhkjikakkbn zrnkhseiritujitrhkjikakkbn}</td><td>（連携用）（契約保全）成立時取引時確認区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhhrkkeirokbn zrnkhhrkkeirokbn}</td><td>（連携用）（契約保全）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi02 zrntjtidounaiyouyobi02}</td><td>（連携用）当日異動内容予備０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsksyouhncd zrnsksyouhncd}</td><td>（連携用）（新契約）商品コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskmosymd zrnskmosymd}</td><td>（連携用）（新契約）申込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskkykymd zrnskkykymd}</td><td>（連携用）（新契約）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsksknnkaisiymd zrnsksknnkaisiymd}</td><td>（連携用）（新契約）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskseiritukbn zrnskseiritukbn}</td><td>（連携用）（新契約）成立区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsksrsyoriymd zrnsksrsyoriymd}</td><td>（連携用）（新契約）成立処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskmfrenflg zrnskmfrenflg}</td><td>（連携用）（新契約）ＭＦ連動済フラグ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsksyono zrnsksyono}</td><td>（連携用）（新契約）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsktsntuukasyu zrnsktsntuukasyu}</td><td>（連携用）（新契約）通算用通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsktsnyousibous zrnsktsnyousibous}</td><td>（連携用）（新契約）通算用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsktsnyouitijip zrnsktsnyouitijip}</td><td>（連携用）（新契約）通算用一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsktsnyounkgns zrnsktsnyounkgns}</td><td>（連携用）（新契約）通算用年金原資</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskhrkkkn zrnskhrkkkn}</td><td>（連携用）（新契約）払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsksntkhoukbn zrnsksntkhoukbn}</td><td>（連携用）（新契約）選択方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskbosyuuym zrnskbosyuuym}</td><td>（連携用）（新契約）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskkykhhkndouhyouji zrnskkykhhkndouhyouji}</td><td>（連携用）（新契約）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskmossyoumetukbn zrnskmossyoumetukbn}</td><td>（連携用）（新契約）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsksyouhnsdno zrnsksyouhnsdno}</td><td>（連携用）（新契約）商品世代番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskkaigomaehrtkykarihyj zrnskkaigomaehrtkykarihyj}</td><td>（連携用）（新契約）介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskpyennykntkykarihyj zrnskpyennykntkykarihyj}</td><td>（連携用）（新契約）保険料円入金特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsktsnyennyknkgk zrnsktsnyennyknkgk}</td><td>（連携用）（新契約）通算用円入金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskhrkkeirokbn zrnskhrkkeirokbn}</td><td>（連携用）（新契約）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi03 zrntjtidounaiyouyobi03}</td><td>（連携用）当日異動内容予備０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyouhncd zrnnksyouhncd}</td><td>（連携用）（年金支払）商品コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknkshrstartymd zrnnknkshrstartymd}</td><td>（連携用）（年金支払）年金支払開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkkykymd zrnnkkykymd}</td><td>（連携用）（年金支払）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknksyoumetucd zrnnknksyoumetucd}</td><td>（連携用）（年金支払）年金消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyoumtymd zrnnksyoumtymd}</td><td>（連携用）（年金支払）消滅年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrtuukasyu zrnnkshrtuukasyu}</td><td>（連携用）（年金支払）支払通貨種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkteinksyu zrnnkteinksyu}</td><td>（連携用）（年金支払）定額年金年金種類</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnktsnnkgns zrnnktsnnkgns}</td><td>（連携用）（年金支払）通算用年金原資</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnknkukthhkndouhyouji zrnnknkukthhkndouhyouji}</td><td>（連携用）（年金支払）年金受取人被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyouhnsdno zrnnksyouhnsdno}</td><td>（連携用）（年金支払）商品世代番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi04 zrntjtidounaiyouyobi04}</td><td>（連携用）当日異動内容予備０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknmei zrnhhknmei}</td><td>（連携用）被保険者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei zrnknjhhknmei}</td><td>（連携用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseiymd zrnhhknseiymd}</td><td>（連携用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnewyno zrnhhknnewyno}</td><td>（連携用）被保険者新郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknadr zrnhhknadr}</td><td>（連携用）被保険者住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkntelno zrnhhkntelno}</td><td>（連携用）被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsykgycd zrnhhknsykgycd}</td><td>（連携用）被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi05 zrntjtidounaiyouyobi05}</td><td>（連携用）当日異動内容予備０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknm zrnkyknm}</td><td>（連携用）契約者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm zrnkjkyknm}</td><td>（連携用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseiymd zrnkyksyaseiymd}</td><td>（連携用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi06 zrntjtidounaiyouyobi06}</td><td>（連携用）当日異動内容予備０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkuktnm zrnnkuktnm}</td><td>（連携用）年金受取人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjnkuktnm zrnkjnkuktnm}</td><td>（連携用）漢字年金受取人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinuktseiymd zrnnenkinuktseiymd}</td><td>（連携用）年金受取人生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi07 zrntjtidounaiyouyobi07}</td><td>（連携用）当日異動内容予備０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsnsknewyno zrntsnsknewyno}</td><td>（連携用）通信先新郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinadr zrntsinadr}</td><td>（連携用）通信先住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsintelno zrntsintelno}</td><td>（連携用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi08 zrntjtidounaiyouyobi08}</td><td>（連携用）当日異動内容予備０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnm1 zrnsbuktnm1}</td><td>（連携用）死亡受取人名１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsbuktnm1 zrnkjsbuktnm1}</td><td>（連携用）漢字死亡受取人名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnm2 zrnsbuktnm2}</td><td>（連携用）死亡受取人名２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsbuktnm2 zrnkjsbuktnm2}</td><td>（連携用）漢字死亡受取人名２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnm3 zrnsbuktnm3}</td><td>（連携用）死亡受取人名３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsbuktnm3 zrnkjsbuktnm3}</td><td>（連携用）漢字死亡受取人名３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnm4 zrnsbuktnm4}</td><td>（連携用）死亡受取人名４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsbuktnm4 zrnkjsbuktnm4}</td><td>（連携用）漢字死亡受取人名４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi09 zrntjtidounaiyouyobi09}</td><td>（連携用）当日異動内容予備０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdrsknm zrnstdrsknm}</td><td>（連携用）指定代理請求人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjstdrsknm zrnkjstdrsknm}</td><td>（連携用）漢字指定代理請求人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdairinm zrnkykdairinm}</td><td>（連携用）契約者代理人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkykdairinm zrnkjkykdairinm}</td><td>（連携用）漢字契約者代理人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi10 zrntjtidounaiyouyobi10}</td><td>（連携用）当日異動内容予備１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbankcd zrnbankcd}</td><td>（連携用）銀行番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshitencd zrnshitencd}</td><td>（連携用）支店番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokinkbn zrnyokinkbn}</td><td>（連携用）預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzano7keta zrnkouzano7keta}</td><td>（連携用）口座番号（７桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzmeiginmei zrnkzmeiginmei}</td><td>（連携用）口座名義人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkykdouhyouji zrnkzkykdouhyouji}</td><td>（連携用）口座名義契約者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi12 zrntjtidounaiyouyobi12}</td><td>（連携用）当日異動内容予備１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokunm1 zrnkzktourokunm1}</td><td>（連携用）家族登録名１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkzktourokunm1 zrnkjkzktourokunm1}</td><td>（連携用）漢字家族登録名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokunm2 zrnkzktourokunm2}</td><td>（連携用）家族登録名２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkzktourokunm2 zrnkjkzktourokunm2}</td><td>（連携用）漢字家族登録名２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi13 zrntjtidounaiyouyobi13}</td><td>（連携用）当日異動内容予備１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitencd1 zrndairitencd1}</td><td>（連携用）代理店コード（１）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbunwari1 zrnbunwari1}</td><td>（連携用）分担割合１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitencd2 zrndairitencd2}</td><td>（連携用）代理店コード（２）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbunwari2 zrnbunwari2}</td><td>（連携用）分担割合２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatukaisosikicd zrnbatukaisosikicd}</td><td>（連携用）Ｂ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntjtidounaiyouyobi11 zrntjtidounaiyouyobi11}</td><td>（連携用）当日異動内容予備１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TjtIdouNaiyouRn
 * @see     PKZT_TjtIdouNaiyouRn
 * @see     QZT_TjtIdouNaiyouRn
 * @see     GenQZT_TjtIdouNaiyouRn
 */
@MappedSuperclass
@Table(name=GenZT_TjtIdouNaiyouRn.TABLE_NAME)
@IdClass(value=PKZT_TjtIdouNaiyouRn.class)
public abstract class GenZT_TjtIdouNaiyouRn extends AbstractExDBEntityForZDB<ZT_TjtIdouNaiyouRn, PKZT_TjtIdouNaiyouRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TjtIdouNaiyouRn";
    public static final String ZRNHUHO2KYKNOKBN         = "zrnhuho2kyknokbn";
    public static final String ZRNHUHO2KYKNO            = "zrnhuho2kykno";
    public static final String ZRNRECORDSAKUJYOHYOUJI   = "zrnrecordsakujyohyouji";
    public static final String ZRNTJTIDOUNAIYOUYOBI01   = "zrntjtidounaiyouyobi01";
    public static final String ZRNKHSYOUHNCD            = "zrnkhsyouhncd";
    public static final String ZRNKHKYKJYOUTAI          = "zrnkhkykjyoutai";
    public static final String ZRNKHKYKYMD              = "zrnkhkykymd";
    public static final String ZRNKHYUUKOUSYOUMETUKBN   = "zrnkhyuukousyoumetukbn";
    public static final String ZRNKHSYOUMETUJIYUU       = "zrnkhsyoumetujiyuu";
    public static final String ZRNKHSYOUMETUYMD         = "zrnkhsyoumetuymd";
    public static final String ZRNKHTSNTUUKASYU         = "zrnkhtsntuukasyu";
    public static final String ZRNKHTSNYOUSIBOUS        = "zrnkhtsnyousibous";
    public static final String ZRNKHTSNYOUITIJIP        = "zrnkhtsnyouitijip";
    public static final String ZRNKHTSNYOUNKGNS         = "zrnkhtsnyounkgns";
    public static final String ZRNKHHRKKKN              = "zrnkhhrkkkn";
    public static final String ZRNKHSNTKHOUKBN          = "zrnkhsntkhoukbn";
    public static final String ZRNKHBOSYUUYM            = "zrnkhbosyuuym";
    public static final String ZRNKHKYKHHKNDOUHYOUJI    = "zrnkhkykhhkndouhyouji";
    public static final String ZRNKHTTDKTYUUIKBN1       = "zrnkhttdktyuuikbn1";
    public static final String ZRNKHTTDKTYUUIKBN2       = "zrnkhttdktyuuikbn2";
    public static final String ZRNKHTTDKTYUUIKBN3       = "zrnkhttdktyuuikbn3";
    public static final String ZRNKHTTDKTYUUIKBN4       = "zrnkhttdktyuuikbn4";
    public static final String ZRNKHTTDKTYUUIKBN5       = "zrnkhttdktyuuikbn5";
    public static final String ZRNKHSYOUHNSDNO          = "zrnkhsyouhnsdno";
    public static final String ZRNKHKAIGOMAEHRTKYKARIHYJ = "zrnkhkaigomaehrtkykarihyj";
    public static final String ZRNKHPYENNYKNTKYKARIHYJ  = "zrnkhpyennykntkykarihyj";
    public static final String ZRNKHTSNYENNYKNKGK       = "zrnkhtsnyennyknkgk";
    public static final String ZRNKHSKMOSNO             = "zrnkhskmosno";
    public static final String ZRNKHHOUTEITYOTKSYHNHYJ  = "zrnkhhouteityotksyhnhyj";
    public static final String ZRNKHSEIRITUJITRHKJIKAKKBN = "zrnkhseiritujitrhkjikakkbn";
    public static final String ZRNKHHRKKEIROKBN         = "zrnkhhrkkeirokbn";
    public static final String ZRNTJTIDOUNAIYOUYOBI02   = "zrntjtidounaiyouyobi02";
    public static final String ZRNSKSYOUHNCD            = "zrnsksyouhncd";
    public static final String ZRNSKMOSYMD              = "zrnskmosymd";
    public static final String ZRNSKKYKYMD              = "zrnskkykymd";
    public static final String ZRNSKSKNNKAISIYMD        = "zrnsksknnkaisiymd";
    public static final String ZRNSKSEIRITUKBN          = "zrnskseiritukbn";
    public static final String ZRNSKSRSYORIYMD          = "zrnsksrsyoriymd";
    public static final String ZRNSKMFRENFLG            = "zrnskmfrenflg";
    public static final String ZRNSKSYONO               = "zrnsksyono";
    public static final String ZRNSKTSNTUUKASYU         = "zrnsktsntuukasyu";
    public static final String ZRNSKTSNYOUSIBOUS        = "zrnsktsnyousibous";
    public static final String ZRNSKTSNYOUITIJIP        = "zrnsktsnyouitijip";
    public static final String ZRNSKTSNYOUNKGNS         = "zrnsktsnyounkgns";
    public static final String ZRNSKHRKKKN              = "zrnskhrkkkn";
    public static final String ZRNSKSNTKHOUKBN          = "zrnsksntkhoukbn";
    public static final String ZRNSKBOSYUUYM            = "zrnskbosyuuym";
    public static final String ZRNSKKYKHHKNDOUHYOUJI    = "zrnskkykhhkndouhyouji";
    public static final String ZRNSKMOSSYOUMETUKBN      = "zrnskmossyoumetukbn";
    public static final String ZRNSKSYOUHNSDNO          = "zrnsksyouhnsdno";
    public static final String ZRNSKKAIGOMAEHRTKYKARIHYJ = "zrnskkaigomaehrtkykarihyj";
    public static final String ZRNSKPYENNYKNTKYKARIHYJ  = "zrnskpyennykntkykarihyj";
    public static final String ZRNSKTSNYENNYKNKGK       = "zrnsktsnyennyknkgk";
    public static final String ZRNSKHRKKEIROKBN         = "zrnskhrkkeirokbn";
    public static final String ZRNTJTIDOUNAIYOUYOBI03   = "zrntjtidounaiyouyobi03";
    public static final String ZRNNKSYOUHNCD            = "zrnnksyouhncd";
    public static final String ZRNNKNKSHRSTARTYMD       = "zrnnknkshrstartymd";
    public static final String ZRNNKKYKYMD              = "zrnnkkykymd";
    public static final String ZRNNKNKSYOUMETUCD        = "zrnnknksyoumetucd";
    public static final String ZRNNKSYOUMTYMD           = "zrnnksyoumtymd";
    public static final String ZRNNKSHRTUUKASYU         = "zrnnkshrtuukasyu";
    public static final String ZRNNKTEINKSYU            = "zrnnkteinksyu";
    public static final String ZRNNKTSNNKGNS            = "zrnnktsnnkgns";
    public static final String ZRNNKNKUKTHHKNDOUHYOUJI  = "zrnnknkukthhkndouhyouji";
    public static final String ZRNNKSYOUHNSDNO          = "zrnnksyouhnsdno";
    public static final String ZRNTJTIDOUNAIYOUYOBI04   = "zrntjtidounaiyouyobi04";
    public static final String ZRNHHKNMEI               = "zrnhhknmei";
    public static final String ZRNKNJHHKNMEI            = "zrnknjhhknmei";
    public static final String ZRNHHKNSEIYMD            = "zrnhhknseiymd";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHHKNNEWYNO            = "zrnhhknnewyno";
    public static final String ZRNHHKNADR               = "zrnhhknadr";
    public static final String ZRNHHKNTELNO             = "zrnhhkntelno";
    public static final String ZRNHHKNSYKGYCD           = "zrnhhknsykgycd";
    public static final String ZRNTJTIDOUNAIYOUYOBI05   = "zrntjtidounaiyouyobi05";
    public static final String ZRNKYKNM                 = "zrnkyknm";
    public static final String ZRNKJKYKNM               = "zrnkjkyknm";
    public static final String ZRNKYKSYASEIYMD          = "zrnkyksyaseiymd";
    public static final String ZRNTJTIDOUNAIYOUYOBI06   = "zrntjtidounaiyouyobi06";
    public static final String ZRNNKUKTNM               = "zrnnkuktnm";
    public static final String ZRNKJNKUKTNM             = "zrnkjnkuktnm";
    public static final String ZRNNENKINUKTSEIYMD       = "zrnnenkinuktseiymd";
    public static final String ZRNTJTIDOUNAIYOUYOBI07   = "zrntjtidounaiyouyobi07";
    public static final String ZRNTSNSKNEWYNO           = "zrntsnsknewyno";
    public static final String ZRNTSINADR               = "zrntsinadr";
    public static final String ZRNTSINTELNO             = "zrntsintelno";
    public static final String ZRNTJTIDOUNAIYOUYOBI08   = "zrntjtidounaiyouyobi08";
    public static final String ZRNSBUKTNM1              = "zrnsbuktnm1";
    public static final String ZRNKJSBUKTNM1            = "zrnkjsbuktnm1";
    public static final String ZRNSBUKTNM2              = "zrnsbuktnm2";
    public static final String ZRNKJSBUKTNM2            = "zrnkjsbuktnm2";
    public static final String ZRNSBUKTNM3              = "zrnsbuktnm3";
    public static final String ZRNKJSBUKTNM3            = "zrnkjsbuktnm3";
    public static final String ZRNSBUKTNM4              = "zrnsbuktnm4";
    public static final String ZRNKJSBUKTNM4            = "zrnkjsbuktnm4";
    public static final String ZRNTJTIDOUNAIYOUYOBI09   = "zrntjtidounaiyouyobi09";
    public static final String ZRNSTDRSKNM              = "zrnstdrsknm";
    public static final String ZRNKJSTDRSKNM            = "zrnkjstdrsknm";
    public static final String ZRNKYKDAIRINM            = "zrnkykdairinm";
    public static final String ZRNKJKYKDAIRINM          = "zrnkjkykdairinm";
    public static final String ZRNTJTIDOUNAIYOUYOBI10   = "zrntjtidounaiyouyobi10";
    public static final String ZRNBANKCD                = "zrnbankcd";
    public static final String ZRNSHITENCD              = "zrnshitencd";
    public static final String ZRNYOKINKBN              = "zrnyokinkbn";
    public static final String ZRNKOUZANO7KETA          = "zrnkouzano7keta";
    public static final String ZRNKZMEIGINMEI           = "zrnkzmeiginmei";
    public static final String ZRNKZKYKDOUHYOUJI        = "zrnkzkykdouhyouji";
    public static final String ZRNTJTIDOUNAIYOUYOBI12   = "zrntjtidounaiyouyobi12";
    public static final String ZRNKZKTOUROKUNM1         = "zrnkzktourokunm1";
    public static final String ZRNKJKZKTOUROKUNM1       = "zrnkjkzktourokunm1";
    public static final String ZRNKZKTOUROKUNM2         = "zrnkzktourokunm2";
    public static final String ZRNKJKZKTOUROKUNM2       = "zrnkjkzktourokunm2";
    public static final String ZRNTJTIDOUNAIYOUYOBI13   = "zrntjtidounaiyouyobi13";
    public static final String ZRNDAIRITENCD1           = "zrndairitencd1";
    public static final String ZRNBUNWARI1              = "zrnbunwari1";
    public static final String ZRNDAIRITENCD2           = "zrndairitencd2";
    public static final String ZRNBUNWARI2              = "zrnbunwari2";
    public static final String ZRNAATUKAISOSIKICD       = "zrnaatukaisosikicd";
    public static final String ZRNBATUKAISOSIKICD       = "zrnbatukaisosikicd";
    public static final String ZRNTJTIDOUNAIYOUYOBI11   = "zrntjtidounaiyouyobi11";

    private final PKZT_TjtIdouNaiyouRn primaryKey;

    public GenZT_TjtIdouNaiyouRn() {
        primaryKey = new PKZT_TjtIdouNaiyouRn();
    }

    public GenZT_TjtIdouNaiyouRn(String pZrnhuho2kyknokbn, String pZrnhuho2kykno) {
        primaryKey = new PKZT_TjtIdouNaiyouRn(pZrnhuho2kyknokbn, pZrnhuho2kykno);
    }

    @Transient
    @Override
    public PKZT_TjtIdouNaiyouRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TjtIdouNaiyouRn> getMetaClass() {
        return QZT_TjtIdouNaiyouRn.class;
    }

    @Id
    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNHUHO2KYKNOKBN)
    public String getZrnhuho2kyknokbn() {
        return getPrimaryKey().getZrnhuho2kyknokbn();
    }

    public void setZrnhuho2kyknokbn(String pZrnhuho2kyknokbn) {
        getPrimaryKey().setZrnhuho2kyknokbn(pZrnhuho2kyknokbn);
    }

    @Id
    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNHUHO2KYKNO)
    public String getZrnhuho2kykno() {
        return getPrimaryKey().getZrnhuho2kykno();
    }

    public void setZrnhuho2kykno(String pZrnhuho2kykno) {
        getPrimaryKey().setZrnhuho2kykno(pZrnhuho2kykno);
    }

    private String zrnrecordsakujyohyouji;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNRECORDSAKUJYOHYOUJI)
    public String getZrnrecordsakujyohyouji() {
        return zrnrecordsakujyohyouji;
    }

    public void setZrnrecordsakujyohyouji(String pZrnrecordsakujyohyouji) {
        zrnrecordsakujyohyouji = pZrnrecordsakujyohyouji;
    }

    private String zrntjtidounaiyouyobi01;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI01)
    public String getZrntjtidounaiyouyobi01() {
        return zrntjtidounaiyouyobi01;
    }

    public void setZrntjtidounaiyouyobi01(String pZrntjtidounaiyouyobi01) {
        zrntjtidounaiyouyobi01 = pZrntjtidounaiyouyobi01;
    }

    private String zrnkhsyouhncd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHSYOUHNCD)
    public String getZrnkhsyouhncd() {
        return zrnkhsyouhncd;
    }

    public void setZrnkhsyouhncd(String pZrnkhsyouhncd) {
        zrnkhsyouhncd = pZrnkhsyouhncd;
    }

    private String zrnkhkykjyoutai;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHKYKJYOUTAI)
    public String getZrnkhkykjyoutai() {
        return zrnkhkykjyoutai;
    }

    public void setZrnkhkykjyoutai(String pZrnkhkykjyoutai) {
        zrnkhkykjyoutai = pZrnkhkykjyoutai;
    }

    private String zrnkhkykymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHKYKYMD)
    public String getZrnkhkykymd() {
        return zrnkhkykymd;
    }

    public void setZrnkhkykymd(String pZrnkhkykymd) {
        zrnkhkykymd = pZrnkhkykymd;
    }

    private String zrnkhyuukousyoumetukbn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHYUUKOUSYOUMETUKBN)
    public String getZrnkhyuukousyoumetukbn() {
        return zrnkhyuukousyoumetukbn;
    }

    public void setZrnkhyuukousyoumetukbn(String pZrnkhyuukousyoumetukbn) {
        zrnkhyuukousyoumetukbn = pZrnkhyuukousyoumetukbn;
    }

    private String zrnkhsyoumetujiyuu;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHSYOUMETUJIYUU)
    public String getZrnkhsyoumetujiyuu() {
        return zrnkhsyoumetujiyuu;
    }

    public void setZrnkhsyoumetujiyuu(String pZrnkhsyoumetujiyuu) {
        zrnkhsyoumetujiyuu = pZrnkhsyoumetujiyuu;
    }

    private String zrnkhsyoumetuymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHSYOUMETUYMD)
    public String getZrnkhsyoumetuymd() {
        return zrnkhsyoumetuymd;
    }

    public void setZrnkhsyoumetuymd(String pZrnkhsyoumetuymd) {
        zrnkhsyoumetuymd = pZrnkhsyoumetuymd;
    }

    private String zrnkhtsntuukasyu;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHTSNTUUKASYU)
    public String getZrnkhtsntuukasyu() {
        return zrnkhtsntuukasyu;
    }

    public void setZrnkhtsntuukasyu(String pZrnkhtsntuukasyu) {
        zrnkhtsntuukasyu = pZrnkhtsntuukasyu;
    }

    private String zrnkhtsnyousibous;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHTSNYOUSIBOUS)
    public String getZrnkhtsnyousibous() {
        return zrnkhtsnyousibous;
    }

    public void setZrnkhtsnyousibous(String pZrnkhtsnyousibous) {
        zrnkhtsnyousibous = pZrnkhtsnyousibous;
    }

    private String zrnkhtsnyouitijip;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHTSNYOUITIJIP)
    public String getZrnkhtsnyouitijip() {
        return zrnkhtsnyouitijip;
    }

    public void setZrnkhtsnyouitijip(String pZrnkhtsnyouitijip) {
        zrnkhtsnyouitijip = pZrnkhtsnyouitijip;
    }

    private String zrnkhtsnyounkgns;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHTSNYOUNKGNS)
    public String getZrnkhtsnyounkgns() {
        return zrnkhtsnyounkgns;
    }

    public void setZrnkhtsnyounkgns(String pZrnkhtsnyounkgns) {
        zrnkhtsnyounkgns = pZrnkhtsnyounkgns;
    }

    private String zrnkhhrkkkn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHHRKKKN)
    public String getZrnkhhrkkkn() {
        return zrnkhhrkkkn;
    }

    public void setZrnkhhrkkkn(String pZrnkhhrkkkn) {
        zrnkhhrkkkn = pZrnkhhrkkkn;
    }

    private String zrnkhsntkhoukbn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHSNTKHOUKBN)
    public String getZrnkhsntkhoukbn() {
        return zrnkhsntkhoukbn;
    }

    public void setZrnkhsntkhoukbn(String pZrnkhsntkhoukbn) {
        zrnkhsntkhoukbn = pZrnkhsntkhoukbn;
    }

    private String zrnkhbosyuuym;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHBOSYUUYM)
    public String getZrnkhbosyuuym() {
        return zrnkhbosyuuym;
    }

    public void setZrnkhbosyuuym(String pZrnkhbosyuuym) {
        zrnkhbosyuuym = pZrnkhbosyuuym;
    }

    private String zrnkhkykhhkndouhyouji;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHKYKHHKNDOUHYOUJI)
    public String getZrnkhkykhhkndouhyouji() {
        return zrnkhkykhhkndouhyouji;
    }

    public void setZrnkhkykhhkndouhyouji(String pZrnkhkykhhkndouhyouji) {
        zrnkhkykhhkndouhyouji = pZrnkhkykhhkndouhyouji;
    }

    private String zrnkhttdktyuuikbn1;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHTTDKTYUUIKBN1)
    public String getZrnkhttdktyuuikbn1() {
        return zrnkhttdktyuuikbn1;
    }

    public void setZrnkhttdktyuuikbn1(String pZrnkhttdktyuuikbn1) {
        zrnkhttdktyuuikbn1 = pZrnkhttdktyuuikbn1;
    }

    private String zrnkhttdktyuuikbn2;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHTTDKTYUUIKBN2)
    public String getZrnkhttdktyuuikbn2() {
        return zrnkhttdktyuuikbn2;
    }

    public void setZrnkhttdktyuuikbn2(String pZrnkhttdktyuuikbn2) {
        zrnkhttdktyuuikbn2 = pZrnkhttdktyuuikbn2;
    }

    private String zrnkhttdktyuuikbn3;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHTTDKTYUUIKBN3)
    public String getZrnkhttdktyuuikbn3() {
        return zrnkhttdktyuuikbn3;
    }

    public void setZrnkhttdktyuuikbn3(String pZrnkhttdktyuuikbn3) {
        zrnkhttdktyuuikbn3 = pZrnkhttdktyuuikbn3;
    }

    private String zrnkhttdktyuuikbn4;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHTTDKTYUUIKBN4)
    public String getZrnkhttdktyuuikbn4() {
        return zrnkhttdktyuuikbn4;
    }

    public void setZrnkhttdktyuuikbn4(String pZrnkhttdktyuuikbn4) {
        zrnkhttdktyuuikbn4 = pZrnkhttdktyuuikbn4;
    }

    private String zrnkhttdktyuuikbn5;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHTTDKTYUUIKBN5)
    public String getZrnkhttdktyuuikbn5() {
        return zrnkhttdktyuuikbn5;
    }

    public void setZrnkhttdktyuuikbn5(String pZrnkhttdktyuuikbn5) {
        zrnkhttdktyuuikbn5 = pZrnkhttdktyuuikbn5;
    }

    private String zrnkhsyouhnsdno;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHSYOUHNSDNO)
    public String getZrnkhsyouhnsdno() {
        return zrnkhsyouhnsdno;
    }

    public void setZrnkhsyouhnsdno(String pZrnkhsyouhnsdno) {
        zrnkhsyouhnsdno = pZrnkhsyouhnsdno;
    }

    private String zrnkhkaigomaehrtkykarihyj;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHKAIGOMAEHRTKYKARIHYJ)
    public String getZrnkhkaigomaehrtkykarihyj() {
        return zrnkhkaigomaehrtkykarihyj;
    }

    public void setZrnkhkaigomaehrtkykarihyj(String pZrnkhkaigomaehrtkykarihyj) {
        zrnkhkaigomaehrtkykarihyj = pZrnkhkaigomaehrtkykarihyj;
    }

    private String zrnkhpyennykntkykarihyj;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHPYENNYKNTKYKARIHYJ)
    public String getZrnkhpyennykntkykarihyj() {
        return zrnkhpyennykntkykarihyj;
    }

    public void setZrnkhpyennykntkykarihyj(String pZrnkhpyennykntkykarihyj) {
        zrnkhpyennykntkykarihyj = pZrnkhpyennykntkykarihyj;
    }

    private String zrnkhtsnyennyknkgk;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHTSNYENNYKNKGK)
    public String getZrnkhtsnyennyknkgk() {
        return zrnkhtsnyennyknkgk;
    }

    public void setZrnkhtsnyennyknkgk(String pZrnkhtsnyennyknkgk) {
        zrnkhtsnyennyknkgk = pZrnkhtsnyennyknkgk;
    }

    private String zrnkhskmosno;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHSKMOSNO)
    public String getZrnkhskmosno() {
        return zrnkhskmosno;
    }

    public void setZrnkhskmosno(String pZrnkhskmosno) {
        zrnkhskmosno = pZrnkhskmosno;
    }

    private String zrnkhhouteityotksyhnhyj;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHHOUTEITYOTKSYHNHYJ)
    public String getZrnkhhouteityotksyhnhyj() {
        return zrnkhhouteityotksyhnhyj;
    }

    public void setZrnkhhouteityotksyhnhyj(String pZrnkhhouteityotksyhnhyj) {
        zrnkhhouteityotksyhnhyj = pZrnkhhouteityotksyhnhyj;
    }

    private String zrnkhseiritujitrhkjikakkbn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHSEIRITUJITRHKJIKAKKBN)
    public String getZrnkhseiritujitrhkjikakkbn() {
        return zrnkhseiritujitrhkjikakkbn;
    }

    public void setZrnkhseiritujitrhkjikakkbn(String pZrnkhseiritujitrhkjikakkbn) {
        zrnkhseiritujitrhkjikakkbn = pZrnkhseiritujitrhkjikakkbn;
    }

    private String zrnkhhrkkeirokbn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKHHRKKEIROKBN)
    public String getZrnkhhrkkeirokbn() {
        return zrnkhhrkkeirokbn;
    }

    public void setZrnkhhrkkeirokbn(String pZrnkhhrkkeirokbn) {
        zrnkhhrkkeirokbn = pZrnkhhrkkeirokbn;
    }

    private String zrntjtidounaiyouyobi02;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI02)
    public String getZrntjtidounaiyouyobi02() {
        return zrntjtidounaiyouyobi02;
    }

    public void setZrntjtidounaiyouyobi02(String pZrntjtidounaiyouyobi02) {
        zrntjtidounaiyouyobi02 = pZrntjtidounaiyouyobi02;
    }

    private String zrnsksyouhncd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKSYOUHNCD)
    public String getZrnsksyouhncd() {
        return zrnsksyouhncd;
    }

    public void setZrnsksyouhncd(String pZrnsksyouhncd) {
        zrnsksyouhncd = pZrnsksyouhncd;
    }

    private String zrnskmosymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKMOSYMD)
    public String getZrnskmosymd() {
        return zrnskmosymd;
    }

    public void setZrnskmosymd(String pZrnskmosymd) {
        zrnskmosymd = pZrnskmosymd;
    }

    private String zrnskkykymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKKYKYMD)
    public String getZrnskkykymd() {
        return zrnskkykymd;
    }

    public void setZrnskkykymd(String pZrnskkykymd) {
        zrnskkykymd = pZrnskkykymd;
    }

    private String zrnsksknnkaisiymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKSKNNKAISIYMD)
    public String getZrnsksknnkaisiymd() {
        return zrnsksknnkaisiymd;
    }

    public void setZrnsksknnkaisiymd(String pZrnsksknnkaisiymd) {
        zrnsksknnkaisiymd = pZrnsksknnkaisiymd;
    }

    private String zrnskseiritukbn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKSEIRITUKBN)
    public String getZrnskseiritukbn() {
        return zrnskseiritukbn;
    }

    public void setZrnskseiritukbn(String pZrnskseiritukbn) {
        zrnskseiritukbn = pZrnskseiritukbn;
    }

    private String zrnsksrsyoriymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKSRSYORIYMD)
    public String getZrnsksrsyoriymd() {
        return zrnsksrsyoriymd;
    }

    public void setZrnsksrsyoriymd(String pZrnsksrsyoriymd) {
        zrnsksrsyoriymd = pZrnsksrsyoriymd;
    }

    private String zrnskmfrenflg;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKMFRENFLG)
    public String getZrnskmfrenflg() {
        return zrnskmfrenflg;
    }

    public void setZrnskmfrenflg(String pZrnskmfrenflg) {
        zrnskmfrenflg = pZrnskmfrenflg;
    }

    private String zrnsksyono;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKSYONO)
    public String getZrnsksyono() {
        return zrnsksyono;
    }

    public void setZrnsksyono(String pZrnsksyono) {
        zrnsksyono = pZrnsksyono;
    }

    private String zrnsktsntuukasyu;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKTSNTUUKASYU)
    public String getZrnsktsntuukasyu() {
        return zrnsktsntuukasyu;
    }

    public void setZrnsktsntuukasyu(String pZrnsktsntuukasyu) {
        zrnsktsntuukasyu = pZrnsktsntuukasyu;
    }

    private String zrnsktsnyousibous;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKTSNYOUSIBOUS)
    public String getZrnsktsnyousibous() {
        return zrnsktsnyousibous;
    }

    public void setZrnsktsnyousibous(String pZrnsktsnyousibous) {
        zrnsktsnyousibous = pZrnsktsnyousibous;
    }

    private String zrnsktsnyouitijip;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKTSNYOUITIJIP)
    public String getZrnsktsnyouitijip() {
        return zrnsktsnyouitijip;
    }

    public void setZrnsktsnyouitijip(String pZrnsktsnyouitijip) {
        zrnsktsnyouitijip = pZrnsktsnyouitijip;
    }

    private String zrnsktsnyounkgns;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKTSNYOUNKGNS)
    public String getZrnsktsnyounkgns() {
        return zrnsktsnyounkgns;
    }

    public void setZrnsktsnyounkgns(String pZrnsktsnyounkgns) {
        zrnsktsnyounkgns = pZrnsktsnyounkgns;
    }

    private String zrnskhrkkkn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKHRKKKN)
    public String getZrnskhrkkkn() {
        return zrnskhrkkkn;
    }

    public void setZrnskhrkkkn(String pZrnskhrkkkn) {
        zrnskhrkkkn = pZrnskhrkkkn;
    }

    private String zrnsksntkhoukbn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKSNTKHOUKBN)
    public String getZrnsksntkhoukbn() {
        return zrnsksntkhoukbn;
    }

    public void setZrnsksntkhoukbn(String pZrnsksntkhoukbn) {
        zrnsksntkhoukbn = pZrnsksntkhoukbn;
    }

    private String zrnskbosyuuym;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKBOSYUUYM)
    public String getZrnskbosyuuym() {
        return zrnskbosyuuym;
    }

    public void setZrnskbosyuuym(String pZrnskbosyuuym) {
        zrnskbosyuuym = pZrnskbosyuuym;
    }

    private String zrnskkykhhkndouhyouji;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKKYKHHKNDOUHYOUJI)
    public String getZrnskkykhhkndouhyouji() {
        return zrnskkykhhkndouhyouji;
    }

    public void setZrnskkykhhkndouhyouji(String pZrnskkykhhkndouhyouji) {
        zrnskkykhhkndouhyouji = pZrnskkykhhkndouhyouji;
    }

    private String zrnskmossyoumetukbn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKMOSSYOUMETUKBN)
    public String getZrnskmossyoumetukbn() {
        return zrnskmossyoumetukbn;
    }

    public void setZrnskmossyoumetukbn(String pZrnskmossyoumetukbn) {
        zrnskmossyoumetukbn = pZrnskmossyoumetukbn;
    }

    private String zrnsksyouhnsdno;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKSYOUHNSDNO)
    public String getZrnsksyouhnsdno() {
        return zrnsksyouhnsdno;
    }

    public void setZrnsksyouhnsdno(String pZrnsksyouhnsdno) {
        zrnsksyouhnsdno = pZrnsksyouhnsdno;
    }

    private String zrnskkaigomaehrtkykarihyj;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKKAIGOMAEHRTKYKARIHYJ)
    public String getZrnskkaigomaehrtkykarihyj() {
        return zrnskkaigomaehrtkykarihyj;
    }

    public void setZrnskkaigomaehrtkykarihyj(String pZrnskkaigomaehrtkykarihyj) {
        zrnskkaigomaehrtkykarihyj = pZrnskkaigomaehrtkykarihyj;
    }

    private String zrnskpyennykntkykarihyj;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKPYENNYKNTKYKARIHYJ)
    public String getZrnskpyennykntkykarihyj() {
        return zrnskpyennykntkykarihyj;
    }

    public void setZrnskpyennykntkykarihyj(String pZrnskpyennykntkykarihyj) {
        zrnskpyennykntkykarihyj = pZrnskpyennykntkykarihyj;
    }

    private String zrnsktsnyennyknkgk;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKTSNYENNYKNKGK)
    public String getZrnsktsnyennyknkgk() {
        return zrnsktsnyennyknkgk;
    }

    public void setZrnsktsnyennyknkgk(String pZrnsktsnyennyknkgk) {
        zrnsktsnyennyknkgk = pZrnsktsnyennyknkgk;
    }

    private String zrnskhrkkeirokbn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSKHRKKEIROKBN)
    public String getZrnskhrkkeirokbn() {
        return zrnskhrkkeirokbn;
    }

    public void setZrnskhrkkeirokbn(String pZrnskhrkkeirokbn) {
        zrnskhrkkeirokbn = pZrnskhrkkeirokbn;
    }

    private String zrntjtidounaiyouyobi03;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI03)
    public String getZrntjtidounaiyouyobi03() {
        return zrntjtidounaiyouyobi03;
    }

    public void setZrntjtidounaiyouyobi03(String pZrntjtidounaiyouyobi03) {
        zrntjtidounaiyouyobi03 = pZrntjtidounaiyouyobi03;
    }

    private String zrnnksyouhncd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKSYOUHNCD)
    public String getZrnnksyouhncd() {
        return zrnnksyouhncd;
    }

    public void setZrnnksyouhncd(String pZrnnksyouhncd) {
        zrnnksyouhncd = pZrnnksyouhncd;
    }

    private String zrnnknkshrstartymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKNKSHRSTARTYMD)
    public String getZrnnknkshrstartymd() {
        return zrnnknkshrstartymd;
    }

    public void setZrnnknkshrstartymd(String pZrnnknkshrstartymd) {
        zrnnknkshrstartymd = pZrnnknkshrstartymd;
    }

    private String zrnnkkykymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKKYKYMD)
    public String getZrnnkkykymd() {
        return zrnnkkykymd;
    }

    public void setZrnnkkykymd(String pZrnnkkykymd) {
        zrnnkkykymd = pZrnnkkykymd;
    }

    private String zrnnknksyoumetucd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKNKSYOUMETUCD)
    public String getZrnnknksyoumetucd() {
        return zrnnknksyoumetucd;
    }

    public void setZrnnknksyoumetucd(String pZrnnknksyoumetucd) {
        zrnnknksyoumetucd = pZrnnknksyoumetucd;
    }

    private String zrnnksyoumtymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKSYOUMTYMD)
    public String getZrnnksyoumtymd() {
        return zrnnksyoumtymd;
    }

    public void setZrnnksyoumtymd(String pZrnnksyoumtymd) {
        zrnnksyoumtymd = pZrnnksyoumtymd;
    }

    private String zrnnkshrtuukasyu;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKSHRTUUKASYU)
    public String getZrnnkshrtuukasyu() {
        return zrnnkshrtuukasyu;
    }

    public void setZrnnkshrtuukasyu(String pZrnnkshrtuukasyu) {
        zrnnkshrtuukasyu = pZrnnkshrtuukasyu;
    }

    private String zrnnkteinksyu;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKTEINKSYU)
    public String getZrnnkteinksyu() {
        return zrnnkteinksyu;
    }

    public void setZrnnkteinksyu(String pZrnnkteinksyu) {
        zrnnkteinksyu = pZrnnkteinksyu;
    }

    private String zrnnktsnnkgns;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKTSNNKGNS)
    public String getZrnnktsnnkgns() {
        return zrnnktsnnkgns;
    }

    public void setZrnnktsnnkgns(String pZrnnktsnnkgns) {
        zrnnktsnnkgns = pZrnnktsnnkgns;
    }

    private String zrnnknkukthhkndouhyouji;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKNKUKTHHKNDOUHYOUJI)
    public String getZrnnknkukthhkndouhyouji() {
        return zrnnknkukthhkndouhyouji;
    }

    public void setZrnnknkukthhkndouhyouji(String pZrnnknkukthhkndouhyouji) {
        zrnnknkukthhkndouhyouji = pZrnnknkukthhkndouhyouji;
    }

    private String zrnnksyouhnsdno;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKSYOUHNSDNO)
    public String getZrnnksyouhnsdno() {
        return zrnnksyouhnsdno;
    }

    public void setZrnnksyouhnsdno(String pZrnnksyouhnsdno) {
        zrnnksyouhnsdno = pZrnnksyouhnsdno;
    }

    private String zrntjtidounaiyouyobi04;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI04)
    public String getZrntjtidounaiyouyobi04() {
        return zrntjtidounaiyouyobi04;
    }

    public void setZrntjtidounaiyouyobi04(String pZrntjtidounaiyouyobi04) {
        zrntjtidounaiyouyobi04 = pZrntjtidounaiyouyobi04;
    }

    private String zrnhhknmei;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNHHKNMEI)
    public String getZrnhhknmei() {
        return zrnhhknmei;
    }

    public void setZrnhhknmei(String pZrnhhknmei) {
        zrnhhknmei = pZrnhhknmei;
    }

    private String zrnknjhhknmei;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKNJHHKNMEI)
    public String getZrnknjhhknmei() {
        return zrnknjhhknmei;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei(String pZrnknjhhknmei) {
        zrnknjhhknmei = pZrnknjhhknmei;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhhknnewyno;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNHHKNNEWYNO)
    public String getZrnhhknnewyno() {
        return zrnhhknnewyno;
    }

    public void setZrnhhknnewyno(String pZrnhhknnewyno) {
        zrnhhknnewyno = pZrnhhknnewyno;
    }

    private String zrnhhknadr;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNHHKNADR)
    public String getZrnhhknadr() {
        return zrnhhknadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknadr(String pZrnhhknadr) {
        zrnhhknadr = pZrnhhknadr;
    }

    private String zrnhhkntelno;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNHHKNTELNO)
    public String getZrnhhkntelno() {
        return zrnhhkntelno;
    }

    public void setZrnhhkntelno(String pZrnhhkntelno) {
        zrnhhkntelno = pZrnhhkntelno;
    }

    private String zrnhhknsykgycd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNHHKNSYKGYCD)
    public String getZrnhhknsykgycd() {
        return zrnhhknsykgycd;
    }

    public void setZrnhhknsykgycd(String pZrnhhknsykgycd) {
        zrnhhknsykgycd = pZrnhhknsykgycd;
    }

    private String zrntjtidounaiyouyobi05;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI05)
    public String getZrntjtidounaiyouyobi05() {
        return zrntjtidounaiyouyobi05;
    }

    public void setZrntjtidounaiyouyobi05(String pZrntjtidounaiyouyobi05) {
        zrntjtidounaiyouyobi05 = pZrntjtidounaiyouyobi05;
    }

    private String zrnkyknm;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKYKNM)
    public String getZrnkyknm() {
        return zrnkyknm;
    }

    public void setZrnkyknm(String pZrnkyknm) {
        zrnkyknm = pZrnkyknm;
    }

    private String zrnkjkyknm;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKJKYKNM)
    public String getZrnkjkyknm() {
        return zrnkjkyknm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm(String pZrnkjkyknm) {
        zrnkjkyknm = pZrnkjkyknm;
    }

    private String zrnkyksyaseiymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKYKSYASEIYMD)
    public String getZrnkyksyaseiymd() {
        return zrnkyksyaseiymd;
    }

    public void setZrnkyksyaseiymd(String pZrnkyksyaseiymd) {
        zrnkyksyaseiymd = pZrnkyksyaseiymd;
    }

    private String zrntjtidounaiyouyobi06;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI06)
    public String getZrntjtidounaiyouyobi06() {
        return zrntjtidounaiyouyobi06;
    }

    public void setZrntjtidounaiyouyobi06(String pZrntjtidounaiyouyobi06) {
        zrntjtidounaiyouyobi06 = pZrntjtidounaiyouyobi06;
    }

    private String zrnnkuktnm;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNKUKTNM)
    public String getZrnnkuktnm() {
        return zrnnkuktnm;
    }

    public void setZrnnkuktnm(String pZrnnkuktnm) {
        zrnnkuktnm = pZrnnkuktnm;
    }

    private String zrnkjnkuktnm;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKJNKUKTNM)
    public String getZrnkjnkuktnm() {
        return zrnkjnkuktnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjnkuktnm(String pZrnkjnkuktnm) {
        zrnkjnkuktnm = pZrnkjnkuktnm;
    }

    private String zrnnenkinuktseiymd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNNENKINUKTSEIYMD)
    public String getZrnnenkinuktseiymd() {
        return zrnnenkinuktseiymd;
    }

    public void setZrnnenkinuktseiymd(String pZrnnenkinuktseiymd) {
        zrnnenkinuktseiymd = pZrnnenkinuktseiymd;
    }

    private String zrntjtidounaiyouyobi07;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI07)
    public String getZrntjtidounaiyouyobi07() {
        return zrntjtidounaiyouyobi07;
    }

    public void setZrntjtidounaiyouyobi07(String pZrntjtidounaiyouyobi07) {
        zrntjtidounaiyouyobi07 = pZrntjtidounaiyouyobi07;
    }

    private String zrntsnsknewyno;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTSNSKNEWYNO)
    public String getZrntsnsknewyno() {
        return zrntsnsknewyno;
    }

    public void setZrntsnsknewyno(String pZrntsnsknewyno) {
        zrntsnsknewyno = pZrntsnsknewyno;
    }

    private String zrntsinadr;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTSINADR)
    public String getZrntsinadr() {
        return zrntsinadr;
    }

    @DataConvert("toMultiByte")
    public void setZrntsinadr(String pZrntsinadr) {
        zrntsinadr = pZrntsinadr;
    }

    private String zrntsintelno;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTSINTELNO)
    public String getZrntsintelno() {
        return zrntsintelno;
    }

    public void setZrntsintelno(String pZrntsintelno) {
        zrntsintelno = pZrntsintelno;
    }

    private String zrntjtidounaiyouyobi08;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI08)
    public String getZrntjtidounaiyouyobi08() {
        return zrntjtidounaiyouyobi08;
    }

    public void setZrntjtidounaiyouyobi08(String pZrntjtidounaiyouyobi08) {
        zrntjtidounaiyouyobi08 = pZrntjtidounaiyouyobi08;
    }

    private String zrnsbuktnm1;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSBUKTNM1)
    public String getZrnsbuktnm1() {
        return zrnsbuktnm1;
    }

    public void setZrnsbuktnm1(String pZrnsbuktnm1) {
        zrnsbuktnm1 = pZrnsbuktnm1;
    }

    private String zrnkjsbuktnm1;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKJSBUKTNM1)
    public String getZrnkjsbuktnm1() {
        return zrnkjsbuktnm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsbuktnm1(String pZrnkjsbuktnm1) {
        zrnkjsbuktnm1 = pZrnkjsbuktnm1;
    }

    private String zrnsbuktnm2;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSBUKTNM2)
    public String getZrnsbuktnm2() {
        return zrnsbuktnm2;
    }

    public void setZrnsbuktnm2(String pZrnsbuktnm2) {
        zrnsbuktnm2 = pZrnsbuktnm2;
    }

    private String zrnkjsbuktnm2;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKJSBUKTNM2)
    public String getZrnkjsbuktnm2() {
        return zrnkjsbuktnm2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsbuktnm2(String pZrnkjsbuktnm2) {
        zrnkjsbuktnm2 = pZrnkjsbuktnm2;
    }

    private String zrnsbuktnm3;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSBUKTNM3)
    public String getZrnsbuktnm3() {
        return zrnsbuktnm3;
    }

    public void setZrnsbuktnm3(String pZrnsbuktnm3) {
        zrnsbuktnm3 = pZrnsbuktnm3;
    }

    private String zrnkjsbuktnm3;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKJSBUKTNM3)
    public String getZrnkjsbuktnm3() {
        return zrnkjsbuktnm3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsbuktnm3(String pZrnkjsbuktnm3) {
        zrnkjsbuktnm3 = pZrnkjsbuktnm3;
    }

    private String zrnsbuktnm4;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSBUKTNM4)
    public String getZrnsbuktnm4() {
        return zrnsbuktnm4;
    }

    public void setZrnsbuktnm4(String pZrnsbuktnm4) {
        zrnsbuktnm4 = pZrnsbuktnm4;
    }

    private String zrnkjsbuktnm4;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKJSBUKTNM4)
    public String getZrnkjsbuktnm4() {
        return zrnkjsbuktnm4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsbuktnm4(String pZrnkjsbuktnm4) {
        zrnkjsbuktnm4 = pZrnkjsbuktnm4;
    }

    private String zrntjtidounaiyouyobi09;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI09)
    public String getZrntjtidounaiyouyobi09() {
        return zrntjtidounaiyouyobi09;
    }

    public void setZrntjtidounaiyouyobi09(String pZrntjtidounaiyouyobi09) {
        zrntjtidounaiyouyobi09 = pZrntjtidounaiyouyobi09;
    }

    private String zrnstdrsknm;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSTDRSKNM)
    public String getZrnstdrsknm() {
        return zrnstdrsknm;
    }

    public void setZrnstdrsknm(String pZrnstdrsknm) {
        zrnstdrsknm = pZrnstdrsknm;
    }

    private String zrnkjstdrsknm;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKJSTDRSKNM)
    public String getZrnkjstdrsknm() {
        return zrnkjstdrsknm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjstdrsknm(String pZrnkjstdrsknm) {
        zrnkjstdrsknm = pZrnkjstdrsknm;
    }

    private String zrnkykdairinm;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKYKDAIRINM)
    public String getZrnkykdairinm() {
        return zrnkykdairinm;
    }

    public void setZrnkykdairinm(String pZrnkykdairinm) {
        zrnkykdairinm = pZrnkykdairinm;
    }

    private String zrnkjkykdairinm;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKJKYKDAIRINM)
    public String getZrnkjkykdairinm() {
        return zrnkjkykdairinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkykdairinm(String pZrnkjkykdairinm) {
        zrnkjkykdairinm = pZrnkjkykdairinm;
    }

    private String zrntjtidounaiyouyobi10;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI10)
    public String getZrntjtidounaiyouyobi10() {
        return zrntjtidounaiyouyobi10;
    }

    public void setZrntjtidounaiyouyobi10(String pZrntjtidounaiyouyobi10) {
        zrntjtidounaiyouyobi10 = pZrntjtidounaiyouyobi10;
    }

    private String zrnbankcd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNBANKCD)
    public String getZrnbankcd() {
        return zrnbankcd;
    }

    public void setZrnbankcd(String pZrnbankcd) {
        zrnbankcd = pZrnbankcd;
    }

    private String zrnshitencd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNSHITENCD)
    public String getZrnshitencd() {
        return zrnshitencd;
    }

    public void setZrnshitencd(String pZrnshitencd) {
        zrnshitencd = pZrnshitencd;
    }

    private String zrnyokinkbn;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNYOKINKBN)
    public String getZrnyokinkbn() {
        return zrnyokinkbn;
    }

    public void setZrnyokinkbn(String pZrnyokinkbn) {
        zrnyokinkbn = pZrnyokinkbn;
    }

    private String zrnkouzano7keta;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKOUZANO7KETA)
    public String getZrnkouzano7keta() {
        return zrnkouzano7keta;
    }

    public void setZrnkouzano7keta(String pZrnkouzano7keta) {
        zrnkouzano7keta = pZrnkouzano7keta;
    }

    private String zrnkzmeiginmei;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKZMEIGINMEI)
    public String getZrnkzmeiginmei() {
        return zrnkzmeiginmei;
    }

    @DataConvert("toSingleByte")
    public void setZrnkzmeiginmei(String pZrnkzmeiginmei) {
        zrnkzmeiginmei = pZrnkzmeiginmei;
    }

    private String zrnkzkykdouhyouji;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKZKYKDOUHYOUJI)
    public String getZrnkzkykdouhyouji() {
        return zrnkzkykdouhyouji;
    }

    public void setZrnkzkykdouhyouji(String pZrnkzkykdouhyouji) {
        zrnkzkykdouhyouji = pZrnkzkykdouhyouji;
    }

    private String zrntjtidounaiyouyobi12;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI12)
    public String getZrntjtidounaiyouyobi12() {
        return zrntjtidounaiyouyobi12;
    }

    public void setZrntjtidounaiyouyobi12(String pZrntjtidounaiyouyobi12) {
        zrntjtidounaiyouyobi12 = pZrntjtidounaiyouyobi12;
    }

    private String zrnkzktourokunm1;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKZKTOUROKUNM1)
    public String getZrnkzktourokunm1() {
        return zrnkzktourokunm1;
    }

    public void setZrnkzktourokunm1(String pZrnkzktourokunm1) {
        zrnkzktourokunm1 = pZrnkzktourokunm1;
    }

    private String zrnkjkzktourokunm1;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKJKZKTOUROKUNM1)
    public String getZrnkjkzktourokunm1() {
        return zrnkjkzktourokunm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkzktourokunm1(String pZrnkjkzktourokunm1) {
        zrnkjkzktourokunm1 = pZrnkjkzktourokunm1;
    }

    private String zrnkzktourokunm2;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKZKTOUROKUNM2)
    public String getZrnkzktourokunm2() {
        return zrnkzktourokunm2;
    }

    public void setZrnkzktourokunm2(String pZrnkzktourokunm2) {
        zrnkzktourokunm2 = pZrnkzktourokunm2;
    }

    private String zrnkjkzktourokunm2;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNKJKZKTOUROKUNM2)
    public String getZrnkjkzktourokunm2() {
        return zrnkjkzktourokunm2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkzktourokunm2(String pZrnkjkzktourokunm2) {
        zrnkjkzktourokunm2 = pZrnkjkzktourokunm2;
    }

    private String zrntjtidounaiyouyobi13;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI13)
    public String getZrntjtidounaiyouyobi13() {
        return zrntjtidounaiyouyobi13;
    }

    public void setZrntjtidounaiyouyobi13(String pZrntjtidounaiyouyobi13) {
        zrntjtidounaiyouyobi13 = pZrntjtidounaiyouyobi13;
    }

    private String zrndairitencd1;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNDAIRITENCD1)
    public String getZrndairitencd1() {
        return zrndairitencd1;
    }

    public void setZrndairitencd1(String pZrndairitencd1) {
        zrndairitencd1 = pZrndairitencd1;
    }

    private String zrnbunwari1;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNBUNWARI1)
    public String getZrnbunwari1() {
        return zrnbunwari1;
    }

    public void setZrnbunwari1(String pZrnbunwari1) {
        zrnbunwari1 = pZrnbunwari1;
    }

    private String zrndairitencd2;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNDAIRITENCD2)
    public String getZrndairitencd2() {
        return zrndairitencd2;
    }

    public void setZrndairitencd2(String pZrndairitencd2) {
        zrndairitencd2 = pZrndairitencd2;
    }

    private String zrnbunwari2;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNBUNWARI2)
    public String getZrnbunwari2() {
        return zrnbunwari2;
    }

    public void setZrnbunwari2(String pZrnbunwari2) {
        zrnbunwari2 = pZrnbunwari2;
    }

    private String zrnaatukaisosikicd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNAATUKAISOSIKICD)
    public String getZrnaatukaisosikicd() {
        return zrnaatukaisosikicd;
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
    }

    private String zrnbatukaisosikicd;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNBATUKAISOSIKICD)
    public String getZrnbatukaisosikicd() {
        return zrnbatukaisosikicd;
    }

    public void setZrnbatukaisosikicd(String pZrnbatukaisosikicd) {
        zrnbatukaisosikicd = pZrnbatukaisosikicd;
    }

    private String zrntjtidounaiyouyobi11;

    @Column(name=GenZT_TjtIdouNaiyouRn.ZRNTJTIDOUNAIYOUYOBI11)
    public String getZrntjtidounaiyouyobi11() {
        return zrntjtidounaiyouyobi11;
    }

    public void setZrntjtidounaiyouyobi11(String pZrntjtidounaiyouyobi11) {
        zrntjtidounaiyouyobi11 = pZrntjtidounaiyouyobi11;
    }
}