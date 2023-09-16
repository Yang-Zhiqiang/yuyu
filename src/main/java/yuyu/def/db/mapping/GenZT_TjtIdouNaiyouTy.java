package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_TjtIdouNaiyouTy;
import yuyu.def.db.id.PKZT_TjtIdouNaiyouTy;
import yuyu.def.db.meta.GenQZT_TjtIdouNaiyouTy;
import yuyu.def.db.meta.QZT_TjtIdouNaiyouTy;

/**
 * 当日異動内容テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_TjtIdouNaiyouTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TjtIdouNaiyouTy}</td><td colspan="3">当日異動内容テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyhuho2kyknokbn ztyhuho2kyknokbn}</td><td>（中継用）普保Ⅱ契約番号区分</td><td align="center">{@link PKZT_TjtIdouNaiyouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhuho2kykno ztyhuho2kykno}</td><td>（中継用）普保Ⅱ契約番号</td><td align="center">{@link PKZT_TjtIdouNaiyouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordsakujyohyouji ztyrecordsakujyohyouji}</td><td>（中継用）レコード削除表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi01 ztytjtidounaiyouyobi01}</td><td>（中継用）当日異動内容予備０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyouhncd ztykhsyouhncd}</td><td>（中継用）（契約保全）商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhkykjyoutai ztykhkykjyoutai}</td><td>（中継用）（契約保全）契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhkykymd ztykhkykymd}</td><td>（中継用）（契約保全）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhyuukousyoumetukbn ztykhyuukousyoumetukbn}</td><td>（中継用）（契約保全）有効消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyoumetujiyuu ztykhsyoumetujiyuu}</td><td>（中継用）（契約保全）消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyoumetuymd ztykhsyoumetuymd}</td><td>（中継用）（契約保全）消滅年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhtsntuukasyu ztykhtsntuukasyu}</td><td>（中継用）（契約保全）通算用通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhtsnyousibous ztykhtsnyousibous}</td><td>（中継用）（契約保全）通算用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhtsnyouitijip ztykhtsnyouitijip}</td><td>（中継用）（契約保全）通算用一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhtsnyounkgns ztykhtsnyounkgns}</td><td>（中継用）（契約保全）通算用年金原資</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhhrkkkn ztykhhrkkkn}</td><td>（中継用）（契約保全）払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsntkhoukbn ztykhsntkhoukbn}</td><td>（中継用）（契約保全）選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhbosyuuym ztykhbosyuuym}</td><td>（中継用）（契約保全）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhkykhhkndouhyouji ztykhkykhhkndouhyouji}</td><td>（中継用）（契約保全）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhttdktyuuikbn1 ztykhttdktyuuikbn1}</td><td>（中継用）（契約保全）手続注意区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhttdktyuuikbn2 ztykhttdktyuuikbn2}</td><td>（中継用）（契約保全）手続注意区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhttdktyuuikbn3 ztykhttdktyuuikbn3}</td><td>（中継用）（契約保全）手続注意区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhttdktyuuikbn4 ztykhttdktyuuikbn4}</td><td>（中継用）（契約保全）手続注意区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhttdktyuuikbn5 ztykhttdktyuuikbn5}</td><td>（中継用）（契約保全）手続注意区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyouhnsdno ztykhsyouhnsdno}</td><td>（中継用）（契約保全）商品世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhkaigomaehrtkykarihyj ztykhkaigomaehrtkykarihyj}</td><td>（中継用）（契約保全）介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhpyennykntkykarihyj ztykhpyennykntkykarihyj}</td><td>（中継用）（契約保全）保険料円入金特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhtsnyennyknkgk ztykhtsnyennyknkgk}</td><td>（中継用）（契約保全）通算用円入金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhskmosno ztykhskmosno}</td><td>（中継用）（契約保全）新契約時申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhhouteityotksyhnhyj ztykhhouteityotksyhnhyj}</td><td>（中継用）（契約保全）法定貯蓄性商品表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhseiritujitrhkjikakkbn ztykhseiritujitrhkjikakkbn}</td><td>（中継用）（契約保全）成立時取引時確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhhrkkeirokbn ztykhhrkkeirokbn}</td><td>（中継用）（契約保全）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi02 ztytjtidounaiyouyobi02}</td><td>（中継用）当日異動内容予備０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysksyouhncd ztysksyouhncd}</td><td>（中継用）（新契約）商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskmosymd ztyskmosymd}</td><td>（中継用）（新契約）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskkykymd ztyskkykymd}</td><td>（中継用）（新契約）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysksknnkaisiymd ztysksknnkaisiymd}</td><td>（中継用）（新契約）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskseiritukbn ztyskseiritukbn}</td><td>（中継用）（新契約）成立区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysksrsyoriymd ztysksrsyoriymd}</td><td>（中継用）（新契約）成立処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskmfrenflg ztyskmfrenflg}</td><td>（中継用）（新契約）ＭＦ連動済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysksyono ztysksyono}</td><td>（中継用）（新契約）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysktsntuukasyu ztysktsntuukasyu}</td><td>（中継用）（新契約）通算用通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysktsnyousibous ztysktsnyousibous}</td><td>（中継用）（新契約）通算用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysktsnyouitijip ztysktsnyouitijip}</td><td>（中継用）（新契約）通算用一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysktsnyounkgns ztysktsnyounkgns}</td><td>（中継用）（新契約）通算用年金原資</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskhrkkkn ztyskhrkkkn}</td><td>（中継用）（新契約）払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysksntkhoukbn ztysksntkhoukbn}</td><td>（中継用）（新契約）選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskbosyuuym ztyskbosyuuym}</td><td>（中継用）（新契約）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskkykhhkndouhyouji ztyskkykhhkndouhyouji}</td><td>（中継用）（新契約）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskmossyoumetukbn ztyskmossyoumetukbn}</td><td>（中継用）（新契約）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysksyouhnsdno ztysksyouhnsdno}</td><td>（中継用）（新契約）商品世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskkaigomaehrtkykarihyj ztyskkaigomaehrtkykarihyj}</td><td>（中継用）（新契約）介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskpyennykntkykarihyj ztyskpyennykntkykarihyj}</td><td>（中継用）（新契約）保険料円入金特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysktsnyennyknkgk ztysktsnyennyknkgk}</td><td>（中継用）（新契約）通算用円入金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskhrkkeirokbn ztyskhrkkeirokbn}</td><td>（中継用）（新契約）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi03 ztytjtidounaiyouyobi03}</td><td>（中継用）当日異動内容予備０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyouhncd ztynksyouhncd}</td><td>（中継用）（年金支払）商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknkshrstartymd ztynknkshrstartymd}</td><td>（中継用）（年金支払）年金支払開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkkykymd ztynkkykymd}</td><td>（中継用）（年金支払）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknksyoumetucd ztynknksyoumetucd}</td><td>（中継用）（年金支払）年金消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyoumtymd ztynksyoumtymd}</td><td>（中継用）（年金支払）消滅年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrtuukasyu ztynkshrtuukasyu}</td><td>（中継用）（年金支払）支払通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkteinksyu ztynkteinksyu}</td><td>（中継用）（年金支払）定額年金年金種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynktsnnkgns ztynktsnnkgns}</td><td>（中継用）（年金支払）通算用年金原資</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknkukthhkndouhyouji ztynknkukthhkndouhyouji}</td><td>（中継用）（年金支払）年金受取人被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyouhnsdno ztynksyouhnsdno}</td><td>（中継用）（年金支払）商品世代番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi04 ztytjtidounaiyouyobi04}</td><td>（中継用）当日異動内容予備０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknmei ztyhhknmei}</td><td>（中継用）被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei ztyknjhhknmei}</td><td>（中継用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnewyno ztyhhknnewyno}</td><td>（中継用）被保険者新郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknadr ztyhhknadr}</td><td>（中継用）被保険者住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkntelno ztyhhkntelno}</td><td>（中継用）被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsykgycd ztyhhknsykgycd}</td><td>（中継用）被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi05 ztytjtidounaiyouyobi05}</td><td>（中継用）当日異動内容予備０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknm ztykyknm}</td><td>（中継用）契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm ztykjkyknm}</td><td>（中継用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseiymd ztykyksyaseiymd}</td><td>（中継用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi06 ztytjtidounaiyouyobi06}</td><td>（中継用）当日異動内容予備０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkuktnm ztynkuktnm}</td><td>（中継用）年金受取人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjnkuktnm ztykjnkuktnm}</td><td>（中継用）漢字年金受取人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinuktseiymd ztynenkinuktseiymd}</td><td>（中継用）年金受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi07 ztytjtidounaiyouyobi07}</td><td>（中継用）当日異動内容予備０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsnsknewyno ztytsnsknewyno}</td><td>（中継用）通信先新郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinadr ztytsinadr}</td><td>（中継用）通信先住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsintelno ztytsintelno}</td><td>（中継用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi08 ztytjtidounaiyouyobi08}</td><td>（中継用）当日異動内容予備０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnm1 ztysbuktnm1}</td><td>（中継用）死亡受取人名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjsbuktnm1 ztykjsbuktnm1}</td><td>（中継用）漢字死亡受取人名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnm2 ztysbuktnm2}</td><td>（中継用）死亡受取人名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjsbuktnm2 ztykjsbuktnm2}</td><td>（中継用）漢字死亡受取人名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnm3 ztysbuktnm3}</td><td>（中継用）死亡受取人名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjsbuktnm3 ztykjsbuktnm3}</td><td>（中継用）漢字死亡受取人名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnm4 ztysbuktnm4}</td><td>（中継用）死亡受取人名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjsbuktnm4 ztykjsbuktnm4}</td><td>（中継用）漢字死亡受取人名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi09 ztytjtidounaiyouyobi09}</td><td>（中継用）当日異動内容予備０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdrsknm ztystdrsknm}</td><td>（中継用）指定代理請求人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjstdrsknm ztykjstdrsknm}</td><td>（中継用）漢字指定代理請求人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdairinm ztykykdairinm}</td><td>（中継用）契約者代理人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkykdairinm ztykjkykdairinm}</td><td>（中継用）漢字契約者代理人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi10 ztytjtidounaiyouyobi10}</td><td>（中継用）当日異動内容予備１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybankcd ztybankcd}</td><td>（中継用）銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshitencd ztyshitencd}</td><td>（中継用）支店番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyokinkbn ztyyokinkbn}</td><td>（中継用）預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzano7keta ztykouzano7keta}</td><td>（中継用）口座番号（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzmeiginmei ztykzmeiginmei}</td><td>（中継用）口座名義人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkykdouhyouji ztykzkykdouhyouji}</td><td>（中継用）口座名義契約者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi12 ztytjtidounaiyouyobi12}</td><td>（中継用）当日異動内容予備１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokunm1 ztykzktourokunm1}</td><td>（中継用）家族登録名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkzktourokunm1 ztykjkzktourokunm1}</td><td>（中継用）漢字家族登録名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokunm2 ztykzktourokunm2}</td><td>（中継用）家族登録名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkzktourokunm2 ztykjkzktourokunm2}</td><td>（中継用）漢字家族登録名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi13 ztytjtidounaiyouyobi13}</td><td>（中継用）当日異動内容予備１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitencd1 ztydairitencd1}</td><td>（中継用）代理店コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybunwari1 ztybunwari1}</td><td>（中継用）分担割合１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitencd2 ztydairitencd2}</td><td>（中継用）代理店コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybunwari2 ztybunwari2}</td><td>（中継用）分担割合２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatukaisosikicd ztybatukaisosikicd}</td><td>（中継用）Ｂ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytjtidounaiyouyobi11 ztytjtidounaiyouyobi11}</td><td>（中継用）当日異動内容予備１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TjtIdouNaiyouTy
 * @see     PKZT_TjtIdouNaiyouTy
 * @see     QZT_TjtIdouNaiyouTy
 * @see     GenQZT_TjtIdouNaiyouTy
 */
@MappedSuperclass
@Table(name=GenZT_TjtIdouNaiyouTy.TABLE_NAME)
@IdClass(value=PKZT_TjtIdouNaiyouTy.class)
public abstract class GenZT_TjtIdouNaiyouTy extends AbstractExDBEntity<ZT_TjtIdouNaiyouTy, PKZT_TjtIdouNaiyouTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TjtIdouNaiyouTy";
    public static final String ZTYHUHO2KYKNOKBN         = "ztyhuho2kyknokbn";
    public static final String ZTYHUHO2KYKNO            = "ztyhuho2kykno";
    public static final String ZTYRECORDSAKUJYOHYOUJI   = "ztyrecordsakujyohyouji";
    public static final String ZTYTJTIDOUNAIYOUYOBI01   = "ztytjtidounaiyouyobi01";
    public static final String ZTYKHSYOUHNCD            = "ztykhsyouhncd";
    public static final String ZTYKHKYKJYOUTAI          = "ztykhkykjyoutai";
    public static final String ZTYKHKYKYMD              = "ztykhkykymd";
    public static final String ZTYKHYUUKOUSYOUMETUKBN   = "ztykhyuukousyoumetukbn";
    public static final String ZTYKHSYOUMETUJIYUU       = "ztykhsyoumetujiyuu";
    public static final String ZTYKHSYOUMETUYMD         = "ztykhsyoumetuymd";
    public static final String ZTYKHTSNTUUKASYU         = "ztykhtsntuukasyu";
    public static final String ZTYKHTSNYOUSIBOUS        = "ztykhtsnyousibous";
    public static final String ZTYKHTSNYOUITIJIP        = "ztykhtsnyouitijip";
    public static final String ZTYKHTSNYOUNKGNS         = "ztykhtsnyounkgns";
    public static final String ZTYKHHRKKKN              = "ztykhhrkkkn";
    public static final String ZTYKHSNTKHOUKBN          = "ztykhsntkhoukbn";
    public static final String ZTYKHBOSYUUYM            = "ztykhbosyuuym";
    public static final String ZTYKHKYKHHKNDOUHYOUJI    = "ztykhkykhhkndouhyouji";
    public static final String ZTYKHTTDKTYUUIKBN1       = "ztykhttdktyuuikbn1";
    public static final String ZTYKHTTDKTYUUIKBN2       = "ztykhttdktyuuikbn2";
    public static final String ZTYKHTTDKTYUUIKBN3       = "ztykhttdktyuuikbn3";
    public static final String ZTYKHTTDKTYUUIKBN4       = "ztykhttdktyuuikbn4";
    public static final String ZTYKHTTDKTYUUIKBN5       = "ztykhttdktyuuikbn5";
    public static final String ZTYKHSYOUHNSDNO          = "ztykhsyouhnsdno";
    public static final String ZTYKHKAIGOMAEHRTKYKARIHYJ = "ztykhkaigomaehrtkykarihyj";
    public static final String ZTYKHPYENNYKNTKYKARIHYJ  = "ztykhpyennykntkykarihyj";
    public static final String ZTYKHTSNYENNYKNKGK       = "ztykhtsnyennyknkgk";
    public static final String ZTYKHSKMOSNO             = "ztykhskmosno";
    public static final String ZTYKHHOUTEITYOTKSYHNHYJ  = "ztykhhouteityotksyhnhyj";
    public static final String ZTYKHSEIRITUJITRHKJIKAKKBN = "ztykhseiritujitrhkjikakkbn";
    public static final String ZTYKHHRKKEIROKBN         = "ztykhhrkkeirokbn";
    public static final String ZTYTJTIDOUNAIYOUYOBI02   = "ztytjtidounaiyouyobi02";
    public static final String ZTYSKSYOUHNCD            = "ztysksyouhncd";
    public static final String ZTYSKMOSYMD              = "ztyskmosymd";
    public static final String ZTYSKKYKYMD              = "ztyskkykymd";
    public static final String ZTYSKSKNNKAISIYMD        = "ztysksknnkaisiymd";
    public static final String ZTYSKSEIRITUKBN          = "ztyskseiritukbn";
    public static final String ZTYSKSRSYORIYMD          = "ztysksrsyoriymd";
    public static final String ZTYSKMFRENFLG            = "ztyskmfrenflg";
    public static final String ZTYSKSYONO               = "ztysksyono";
    public static final String ZTYSKTSNTUUKASYU         = "ztysktsntuukasyu";
    public static final String ZTYSKTSNYOUSIBOUS        = "ztysktsnyousibous";
    public static final String ZTYSKTSNYOUITIJIP        = "ztysktsnyouitijip";
    public static final String ZTYSKTSNYOUNKGNS         = "ztysktsnyounkgns";
    public static final String ZTYSKHRKKKN              = "ztyskhrkkkn";
    public static final String ZTYSKSNTKHOUKBN          = "ztysksntkhoukbn";
    public static final String ZTYSKBOSYUUYM            = "ztyskbosyuuym";
    public static final String ZTYSKKYKHHKNDOUHYOUJI    = "ztyskkykhhkndouhyouji";
    public static final String ZTYSKMOSSYOUMETUKBN      = "ztyskmossyoumetukbn";
    public static final String ZTYSKSYOUHNSDNO          = "ztysksyouhnsdno";
    public static final String ZTYSKKAIGOMAEHRTKYKARIHYJ = "ztyskkaigomaehrtkykarihyj";
    public static final String ZTYSKPYENNYKNTKYKARIHYJ  = "ztyskpyennykntkykarihyj";
    public static final String ZTYSKTSNYENNYKNKGK       = "ztysktsnyennyknkgk";
    public static final String ZTYSKHRKKEIROKBN         = "ztyskhrkkeirokbn";
    public static final String ZTYTJTIDOUNAIYOUYOBI03   = "ztytjtidounaiyouyobi03";
    public static final String ZTYNKSYOUHNCD            = "ztynksyouhncd";
    public static final String ZTYNKNKSHRSTARTYMD       = "ztynknkshrstartymd";
    public static final String ZTYNKKYKYMD              = "ztynkkykymd";
    public static final String ZTYNKNKSYOUMETUCD        = "ztynknksyoumetucd";
    public static final String ZTYNKSYOUMTYMD           = "ztynksyoumtymd";
    public static final String ZTYNKSHRTUUKASYU         = "ztynkshrtuukasyu";
    public static final String ZTYNKTEINKSYU            = "ztynkteinksyu";
    public static final String ZTYNKTSNNKGNS            = "ztynktsnnkgns";
    public static final String ZTYNKNKUKTHHKNDOUHYOUJI  = "ztynknkukthhkndouhyouji";
    public static final String ZTYNKSYOUHNSDNO          = "ztynksyouhnsdno";
    public static final String ZTYTJTIDOUNAIYOUYOBI04   = "ztytjtidounaiyouyobi04";
    public static final String ZTYHHKNMEI               = "ztyhhknmei";
    public static final String ZTYKNJHHKNMEI            = "ztyknjhhknmei";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHHKNNEWYNO            = "ztyhhknnewyno";
    public static final String ZTYHHKNADR               = "ztyhhknadr";
    public static final String ZTYHHKNTELNO             = "ztyhhkntelno";
    public static final String ZTYHHKNSYKGYCD           = "ztyhhknsykgycd";
    public static final String ZTYTJTIDOUNAIYOUYOBI05   = "ztytjtidounaiyouyobi05";
    public static final String ZTYKYKNM                 = "ztykyknm";
    public static final String ZTYKJKYKNM               = "ztykjkyknm";
    public static final String ZTYKYKSYASEIYMD          = "ztykyksyaseiymd";
    public static final String ZTYTJTIDOUNAIYOUYOBI06   = "ztytjtidounaiyouyobi06";
    public static final String ZTYNKUKTNM               = "ztynkuktnm";
    public static final String ZTYKJNKUKTNM             = "ztykjnkuktnm";
    public static final String ZTYNENKINUKTSEIYMD       = "ztynenkinuktseiymd";
    public static final String ZTYTJTIDOUNAIYOUYOBI07   = "ztytjtidounaiyouyobi07";
    public static final String ZTYTSNSKNEWYNO           = "ztytsnsknewyno";
    public static final String ZTYTSINADR               = "ztytsinadr";
    public static final String ZTYTSINTELNO             = "ztytsintelno";
    public static final String ZTYTJTIDOUNAIYOUYOBI08   = "ztytjtidounaiyouyobi08";
    public static final String ZTYSBUKTNM1              = "ztysbuktnm1";
    public static final String ZTYKJSBUKTNM1            = "ztykjsbuktnm1";
    public static final String ZTYSBUKTNM2              = "ztysbuktnm2";
    public static final String ZTYKJSBUKTNM2            = "ztykjsbuktnm2";
    public static final String ZTYSBUKTNM3              = "ztysbuktnm3";
    public static final String ZTYKJSBUKTNM3            = "ztykjsbuktnm3";
    public static final String ZTYSBUKTNM4              = "ztysbuktnm4";
    public static final String ZTYKJSBUKTNM4            = "ztykjsbuktnm4";
    public static final String ZTYTJTIDOUNAIYOUYOBI09   = "ztytjtidounaiyouyobi09";
    public static final String ZTYSTDRSKNM              = "ztystdrsknm";
    public static final String ZTYKJSTDRSKNM            = "ztykjstdrsknm";
    public static final String ZTYKYKDAIRINM            = "ztykykdairinm";
    public static final String ZTYKJKYKDAIRINM          = "ztykjkykdairinm";
    public static final String ZTYTJTIDOUNAIYOUYOBI10   = "ztytjtidounaiyouyobi10";
    public static final String ZTYBANKCD                = "ztybankcd";
    public static final String ZTYSHITENCD              = "ztyshitencd";
    public static final String ZTYYOKINKBN              = "ztyyokinkbn";
    public static final String ZTYKOUZANO7KETA          = "ztykouzano7keta";
    public static final String ZTYKZMEIGINMEI           = "ztykzmeiginmei";
    public static final String ZTYKZKYKDOUHYOUJI        = "ztykzkykdouhyouji";
    public static final String ZTYTJTIDOUNAIYOUYOBI12   = "ztytjtidounaiyouyobi12";
    public static final String ZTYKZKTOUROKUNM1         = "ztykzktourokunm1";
    public static final String ZTYKJKZKTOUROKUNM1       = "ztykjkzktourokunm1";
    public static final String ZTYKZKTOUROKUNM2         = "ztykzktourokunm2";
    public static final String ZTYKJKZKTOUROKUNM2       = "ztykjkzktourokunm2";
    public static final String ZTYTJTIDOUNAIYOUYOBI13   = "ztytjtidounaiyouyobi13";
    public static final String ZTYDAIRITENCD1           = "ztydairitencd1";
    public static final String ZTYBUNWARI1              = "ztybunwari1";
    public static final String ZTYDAIRITENCD2           = "ztydairitencd2";
    public static final String ZTYBUNWARI2              = "ztybunwari2";
    public static final String ZTYAATUKAISOSIKICD       = "ztyaatukaisosikicd";
    public static final String ZTYBATUKAISOSIKICD       = "ztybatukaisosikicd";
    public static final String ZTYTJTIDOUNAIYOUYOBI11   = "ztytjtidounaiyouyobi11";

    private final PKZT_TjtIdouNaiyouTy primaryKey;

    public GenZT_TjtIdouNaiyouTy() {
        primaryKey = new PKZT_TjtIdouNaiyouTy();
    }

    public GenZT_TjtIdouNaiyouTy(String pZtyhuho2kyknokbn, String pZtyhuho2kykno) {
        primaryKey = new PKZT_TjtIdouNaiyouTy(pZtyhuho2kyknokbn, pZtyhuho2kykno);
    }

    @Transient
    @Override
    public PKZT_TjtIdouNaiyouTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TjtIdouNaiyouTy> getMetaClass() {
        return QZT_TjtIdouNaiyouTy.class;
    }

    @Id
    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYHUHO2KYKNOKBN)
    public String getZtyhuho2kyknokbn() {
        return getPrimaryKey().getZtyhuho2kyknokbn();
    }

    public void setZtyhuho2kyknokbn(String pZtyhuho2kyknokbn) {
        getPrimaryKey().setZtyhuho2kyknokbn(pZtyhuho2kyknokbn);
    }

    @Id
    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYHUHO2KYKNO)
    public String getZtyhuho2kykno() {
        return getPrimaryKey().getZtyhuho2kykno();
    }

    public void setZtyhuho2kykno(String pZtyhuho2kykno) {
        getPrimaryKey().setZtyhuho2kykno(pZtyhuho2kykno);
    }

    private String ztyrecordsakujyohyouji;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYRECORDSAKUJYOHYOUJI)
    public String getZtyrecordsakujyohyouji() {
        return ztyrecordsakujyohyouji;
    }

    public void setZtyrecordsakujyohyouji(String pZtyrecordsakujyohyouji) {
        ztyrecordsakujyohyouji = pZtyrecordsakujyohyouji;
    }

    private String ztytjtidounaiyouyobi01;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI01)
    public String getZtytjtidounaiyouyobi01() {
        return ztytjtidounaiyouyobi01;
    }

    public void setZtytjtidounaiyouyobi01(String pZtytjtidounaiyouyobi01) {
        ztytjtidounaiyouyobi01 = pZtytjtidounaiyouyobi01;
    }

    private String ztykhsyouhncd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHSYOUHNCD)
    public String getZtykhsyouhncd() {
        return ztykhsyouhncd;
    }

    public void setZtykhsyouhncd(String pZtykhsyouhncd) {
        ztykhsyouhncd = pZtykhsyouhncd;
    }

    private String ztykhkykjyoutai;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHKYKJYOUTAI)
    public String getZtykhkykjyoutai() {
        return ztykhkykjyoutai;
    }

    public void setZtykhkykjyoutai(String pZtykhkykjyoutai) {
        ztykhkykjyoutai = pZtykhkykjyoutai;
    }

    private String ztykhkykymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHKYKYMD)
    public String getZtykhkykymd() {
        return ztykhkykymd;
    }

    public void setZtykhkykymd(String pZtykhkykymd) {
        ztykhkykymd = pZtykhkykymd;
    }

    private String ztykhyuukousyoumetukbn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHYUUKOUSYOUMETUKBN)
    public String getZtykhyuukousyoumetukbn() {
        return ztykhyuukousyoumetukbn;
    }

    public void setZtykhyuukousyoumetukbn(String pZtykhyuukousyoumetukbn) {
        ztykhyuukousyoumetukbn = pZtykhyuukousyoumetukbn;
    }

    private String ztykhsyoumetujiyuu;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHSYOUMETUJIYUU)
    public String getZtykhsyoumetujiyuu() {
        return ztykhsyoumetujiyuu;
    }

    public void setZtykhsyoumetujiyuu(String pZtykhsyoumetujiyuu) {
        ztykhsyoumetujiyuu = pZtykhsyoumetujiyuu;
    }

    private String ztykhsyoumetuymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHSYOUMETUYMD)
    public String getZtykhsyoumetuymd() {
        return ztykhsyoumetuymd;
    }

    public void setZtykhsyoumetuymd(String pZtykhsyoumetuymd) {
        ztykhsyoumetuymd = pZtykhsyoumetuymd;
    }

    private String ztykhtsntuukasyu;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHTSNTUUKASYU)
    public String getZtykhtsntuukasyu() {
        return ztykhtsntuukasyu;
    }

    public void setZtykhtsntuukasyu(String pZtykhtsntuukasyu) {
        ztykhtsntuukasyu = pZtykhtsntuukasyu;
    }

    private String ztykhtsnyousibous;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHTSNYOUSIBOUS)
    public String getZtykhtsnyousibous() {
        return ztykhtsnyousibous;
    }

    public void setZtykhtsnyousibous(String pZtykhtsnyousibous) {
        ztykhtsnyousibous = pZtykhtsnyousibous;
    }

    private String ztykhtsnyouitijip;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHTSNYOUITIJIP)
    public String getZtykhtsnyouitijip() {
        return ztykhtsnyouitijip;
    }

    public void setZtykhtsnyouitijip(String pZtykhtsnyouitijip) {
        ztykhtsnyouitijip = pZtykhtsnyouitijip;
    }

    private String ztykhtsnyounkgns;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHTSNYOUNKGNS)
    public String getZtykhtsnyounkgns() {
        return ztykhtsnyounkgns;
    }

    public void setZtykhtsnyounkgns(String pZtykhtsnyounkgns) {
        ztykhtsnyounkgns = pZtykhtsnyounkgns;
    }

    private String ztykhhrkkkn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHHRKKKN)
    public String getZtykhhrkkkn() {
        return ztykhhrkkkn;
    }

    public void setZtykhhrkkkn(String pZtykhhrkkkn) {
        ztykhhrkkkn = pZtykhhrkkkn;
    }

    private String ztykhsntkhoukbn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHSNTKHOUKBN)
    public String getZtykhsntkhoukbn() {
        return ztykhsntkhoukbn;
    }

    public void setZtykhsntkhoukbn(String pZtykhsntkhoukbn) {
        ztykhsntkhoukbn = pZtykhsntkhoukbn;
    }

    private String ztykhbosyuuym;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHBOSYUUYM)
    public String getZtykhbosyuuym() {
        return ztykhbosyuuym;
    }

    public void setZtykhbosyuuym(String pZtykhbosyuuym) {
        ztykhbosyuuym = pZtykhbosyuuym;
    }

    private String ztykhkykhhkndouhyouji;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHKYKHHKNDOUHYOUJI)
    public String getZtykhkykhhkndouhyouji() {
        return ztykhkykhhkndouhyouji;
    }

    public void setZtykhkykhhkndouhyouji(String pZtykhkykhhkndouhyouji) {
        ztykhkykhhkndouhyouji = pZtykhkykhhkndouhyouji;
    }

    private String ztykhttdktyuuikbn1;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHTTDKTYUUIKBN1)
    public String getZtykhttdktyuuikbn1() {
        return ztykhttdktyuuikbn1;
    }

    public void setZtykhttdktyuuikbn1(String pZtykhttdktyuuikbn1) {
        ztykhttdktyuuikbn1 = pZtykhttdktyuuikbn1;
    }

    private String ztykhttdktyuuikbn2;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHTTDKTYUUIKBN2)
    public String getZtykhttdktyuuikbn2() {
        return ztykhttdktyuuikbn2;
    }

    public void setZtykhttdktyuuikbn2(String pZtykhttdktyuuikbn2) {
        ztykhttdktyuuikbn2 = pZtykhttdktyuuikbn2;
    }

    private String ztykhttdktyuuikbn3;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHTTDKTYUUIKBN3)
    public String getZtykhttdktyuuikbn3() {
        return ztykhttdktyuuikbn3;
    }

    public void setZtykhttdktyuuikbn3(String pZtykhttdktyuuikbn3) {
        ztykhttdktyuuikbn3 = pZtykhttdktyuuikbn3;
    }

    private String ztykhttdktyuuikbn4;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHTTDKTYUUIKBN4)
    public String getZtykhttdktyuuikbn4() {
        return ztykhttdktyuuikbn4;
    }

    public void setZtykhttdktyuuikbn4(String pZtykhttdktyuuikbn4) {
        ztykhttdktyuuikbn4 = pZtykhttdktyuuikbn4;
    }

    private String ztykhttdktyuuikbn5;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHTTDKTYUUIKBN5)
    public String getZtykhttdktyuuikbn5() {
        return ztykhttdktyuuikbn5;
    }

    public void setZtykhttdktyuuikbn5(String pZtykhttdktyuuikbn5) {
        ztykhttdktyuuikbn5 = pZtykhttdktyuuikbn5;
    }

    private String ztykhsyouhnsdno;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHSYOUHNSDNO)
    public String getZtykhsyouhnsdno() {
        return ztykhsyouhnsdno;
    }

    public void setZtykhsyouhnsdno(String pZtykhsyouhnsdno) {
        ztykhsyouhnsdno = pZtykhsyouhnsdno;
    }

    private String ztykhkaigomaehrtkykarihyj;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHKAIGOMAEHRTKYKARIHYJ)
    public String getZtykhkaigomaehrtkykarihyj() {
        return ztykhkaigomaehrtkykarihyj;
    }

    public void setZtykhkaigomaehrtkykarihyj(String pZtykhkaigomaehrtkykarihyj) {
        ztykhkaigomaehrtkykarihyj = pZtykhkaigomaehrtkykarihyj;
    }

    private String ztykhpyennykntkykarihyj;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHPYENNYKNTKYKARIHYJ)
    public String getZtykhpyennykntkykarihyj() {
        return ztykhpyennykntkykarihyj;
    }

    public void setZtykhpyennykntkykarihyj(String pZtykhpyennykntkykarihyj) {
        ztykhpyennykntkykarihyj = pZtykhpyennykntkykarihyj;
    }

    private String ztykhtsnyennyknkgk;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHTSNYENNYKNKGK)
    public String getZtykhtsnyennyknkgk() {
        return ztykhtsnyennyknkgk;
    }

    public void setZtykhtsnyennyknkgk(String pZtykhtsnyennyknkgk) {
        ztykhtsnyennyknkgk = pZtykhtsnyennyknkgk;
    }

    private String ztykhskmosno;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHSKMOSNO)
    public String getZtykhskmosno() {
        return ztykhskmosno;
    }

    public void setZtykhskmosno(String pZtykhskmosno) {
        ztykhskmosno = pZtykhskmosno;
    }

    private String ztykhhouteityotksyhnhyj;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHHOUTEITYOTKSYHNHYJ)
    public String getZtykhhouteityotksyhnhyj() {
        return ztykhhouteityotksyhnhyj;
    }

    public void setZtykhhouteityotksyhnhyj(String pZtykhhouteityotksyhnhyj) {
        ztykhhouteityotksyhnhyj = pZtykhhouteityotksyhnhyj;
    }

    private String ztykhseiritujitrhkjikakkbn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHSEIRITUJITRHKJIKAKKBN)
    public String getZtykhseiritujitrhkjikakkbn() {
        return ztykhseiritujitrhkjikakkbn;
    }

    public void setZtykhseiritujitrhkjikakkbn(String pZtykhseiritujitrhkjikakkbn) {
        ztykhseiritujitrhkjikakkbn = pZtykhseiritujitrhkjikakkbn;
    }

    private String ztykhhrkkeirokbn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKHHRKKEIROKBN)
    public String getZtykhhrkkeirokbn() {
        return ztykhhrkkeirokbn;
    }

    public void setZtykhhrkkeirokbn(String pZtykhhrkkeirokbn) {
        ztykhhrkkeirokbn = pZtykhhrkkeirokbn;
    }

    private String ztytjtidounaiyouyobi02;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI02)
    public String getZtytjtidounaiyouyobi02() {
        return ztytjtidounaiyouyobi02;
    }

    public void setZtytjtidounaiyouyobi02(String pZtytjtidounaiyouyobi02) {
        ztytjtidounaiyouyobi02 = pZtytjtidounaiyouyobi02;
    }

    private String ztysksyouhncd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKSYOUHNCD)
    public String getZtysksyouhncd() {
        return ztysksyouhncd;
    }

    public void setZtysksyouhncd(String pZtysksyouhncd) {
        ztysksyouhncd = pZtysksyouhncd;
    }

    private String ztyskmosymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKMOSYMD)
    public String getZtyskmosymd() {
        return ztyskmosymd;
    }

    public void setZtyskmosymd(String pZtyskmosymd) {
        ztyskmosymd = pZtyskmosymd;
    }

    private String ztyskkykymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKKYKYMD)
    public String getZtyskkykymd() {
        return ztyskkykymd;
    }

    public void setZtyskkykymd(String pZtyskkykymd) {
        ztyskkykymd = pZtyskkykymd;
    }

    private String ztysksknnkaisiymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKSKNNKAISIYMD)
    public String getZtysksknnkaisiymd() {
        return ztysksknnkaisiymd;
    }

    public void setZtysksknnkaisiymd(String pZtysksknnkaisiymd) {
        ztysksknnkaisiymd = pZtysksknnkaisiymd;
    }

    private String ztyskseiritukbn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKSEIRITUKBN)
    public String getZtyskseiritukbn() {
        return ztyskseiritukbn;
    }

    public void setZtyskseiritukbn(String pZtyskseiritukbn) {
        ztyskseiritukbn = pZtyskseiritukbn;
    }

    private String ztysksrsyoriymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKSRSYORIYMD)
    public String getZtysksrsyoriymd() {
        return ztysksrsyoriymd;
    }

    public void setZtysksrsyoriymd(String pZtysksrsyoriymd) {
        ztysksrsyoriymd = pZtysksrsyoriymd;
    }

    private String ztyskmfrenflg;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKMFRENFLG)
    public String getZtyskmfrenflg() {
        return ztyskmfrenflg;
    }

    public void setZtyskmfrenflg(String pZtyskmfrenflg) {
        ztyskmfrenflg = pZtyskmfrenflg;
    }

    private String ztysksyono;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKSYONO)
    public String getZtysksyono() {
        return ztysksyono;
    }

    public void setZtysksyono(String pZtysksyono) {
        ztysksyono = pZtysksyono;
    }

    private String ztysktsntuukasyu;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKTSNTUUKASYU)
    public String getZtysktsntuukasyu() {
        return ztysktsntuukasyu;
    }

    public void setZtysktsntuukasyu(String pZtysktsntuukasyu) {
        ztysktsntuukasyu = pZtysktsntuukasyu;
    }

    private String ztysktsnyousibous;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKTSNYOUSIBOUS)
    public String getZtysktsnyousibous() {
        return ztysktsnyousibous;
    }

    public void setZtysktsnyousibous(String pZtysktsnyousibous) {
        ztysktsnyousibous = pZtysktsnyousibous;
    }

    private String ztysktsnyouitijip;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKTSNYOUITIJIP)
    public String getZtysktsnyouitijip() {
        return ztysktsnyouitijip;
    }

    public void setZtysktsnyouitijip(String pZtysktsnyouitijip) {
        ztysktsnyouitijip = pZtysktsnyouitijip;
    }

    private String ztysktsnyounkgns;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKTSNYOUNKGNS)
    public String getZtysktsnyounkgns() {
        return ztysktsnyounkgns;
    }

    public void setZtysktsnyounkgns(String pZtysktsnyounkgns) {
        ztysktsnyounkgns = pZtysktsnyounkgns;
    }

    private String ztyskhrkkkn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKHRKKKN)
    public String getZtyskhrkkkn() {
        return ztyskhrkkkn;
    }

    public void setZtyskhrkkkn(String pZtyskhrkkkn) {
        ztyskhrkkkn = pZtyskhrkkkn;
    }

    private String ztysksntkhoukbn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKSNTKHOUKBN)
    public String getZtysksntkhoukbn() {
        return ztysksntkhoukbn;
    }

    public void setZtysksntkhoukbn(String pZtysksntkhoukbn) {
        ztysksntkhoukbn = pZtysksntkhoukbn;
    }

    private String ztyskbosyuuym;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKBOSYUUYM)
    public String getZtyskbosyuuym() {
        return ztyskbosyuuym;
    }

    public void setZtyskbosyuuym(String pZtyskbosyuuym) {
        ztyskbosyuuym = pZtyskbosyuuym;
    }

    private String ztyskkykhhkndouhyouji;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKKYKHHKNDOUHYOUJI)
    public String getZtyskkykhhkndouhyouji() {
        return ztyskkykhhkndouhyouji;
    }

    public void setZtyskkykhhkndouhyouji(String pZtyskkykhhkndouhyouji) {
        ztyskkykhhkndouhyouji = pZtyskkykhhkndouhyouji;
    }

    private String ztyskmossyoumetukbn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKMOSSYOUMETUKBN)
    public String getZtyskmossyoumetukbn() {
        return ztyskmossyoumetukbn;
    }

    public void setZtyskmossyoumetukbn(String pZtyskmossyoumetukbn) {
        ztyskmossyoumetukbn = pZtyskmossyoumetukbn;
    }

    private String ztysksyouhnsdno;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKSYOUHNSDNO)
    public String getZtysksyouhnsdno() {
        return ztysksyouhnsdno;
    }

    public void setZtysksyouhnsdno(String pZtysksyouhnsdno) {
        ztysksyouhnsdno = pZtysksyouhnsdno;
    }

    private String ztyskkaigomaehrtkykarihyj;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKKAIGOMAEHRTKYKARIHYJ)
    public String getZtyskkaigomaehrtkykarihyj() {
        return ztyskkaigomaehrtkykarihyj;
    }

    public void setZtyskkaigomaehrtkykarihyj(String pZtyskkaigomaehrtkykarihyj) {
        ztyskkaigomaehrtkykarihyj = pZtyskkaigomaehrtkykarihyj;
    }

    private String ztyskpyennykntkykarihyj;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKPYENNYKNTKYKARIHYJ)
    public String getZtyskpyennykntkykarihyj() {
        return ztyskpyennykntkykarihyj;
    }

    public void setZtyskpyennykntkykarihyj(String pZtyskpyennykntkykarihyj) {
        ztyskpyennykntkykarihyj = pZtyskpyennykntkykarihyj;
    }

    private String ztysktsnyennyknkgk;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKTSNYENNYKNKGK)
    public String getZtysktsnyennyknkgk() {
        return ztysktsnyennyknkgk;
    }

    public void setZtysktsnyennyknkgk(String pZtysktsnyennyknkgk) {
        ztysktsnyennyknkgk = pZtysktsnyennyknkgk;
    }

    private String ztyskhrkkeirokbn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSKHRKKEIROKBN)
    public String getZtyskhrkkeirokbn() {
        return ztyskhrkkeirokbn;
    }

    public void setZtyskhrkkeirokbn(String pZtyskhrkkeirokbn) {
        ztyskhrkkeirokbn = pZtyskhrkkeirokbn;
    }

    private String ztytjtidounaiyouyobi03;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI03)
    public String getZtytjtidounaiyouyobi03() {
        return ztytjtidounaiyouyobi03;
    }

    public void setZtytjtidounaiyouyobi03(String pZtytjtidounaiyouyobi03) {
        ztytjtidounaiyouyobi03 = pZtytjtidounaiyouyobi03;
    }

    private String ztynksyouhncd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKSYOUHNCD)
    public String getZtynksyouhncd() {
        return ztynksyouhncd;
    }

    public void setZtynksyouhncd(String pZtynksyouhncd) {
        ztynksyouhncd = pZtynksyouhncd;
    }

    private String ztynknkshrstartymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKNKSHRSTARTYMD)
    public String getZtynknkshrstartymd() {
        return ztynknkshrstartymd;
    }

    public void setZtynknkshrstartymd(String pZtynknkshrstartymd) {
        ztynknkshrstartymd = pZtynknkshrstartymd;
    }

    private String ztynkkykymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKKYKYMD)
    public String getZtynkkykymd() {
        return ztynkkykymd;
    }

    public void setZtynkkykymd(String pZtynkkykymd) {
        ztynkkykymd = pZtynkkykymd;
    }

    private String ztynknksyoumetucd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKNKSYOUMETUCD)
    public String getZtynknksyoumetucd() {
        return ztynknksyoumetucd;
    }

    public void setZtynknksyoumetucd(String pZtynknksyoumetucd) {
        ztynknksyoumetucd = pZtynknksyoumetucd;
    }

    private String ztynksyoumtymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKSYOUMTYMD)
    public String getZtynksyoumtymd() {
        return ztynksyoumtymd;
    }

    public void setZtynksyoumtymd(String pZtynksyoumtymd) {
        ztynksyoumtymd = pZtynksyoumtymd;
    }

    private String ztynkshrtuukasyu;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKSHRTUUKASYU)
    public String getZtynkshrtuukasyu() {
        return ztynkshrtuukasyu;
    }

    public void setZtynkshrtuukasyu(String pZtynkshrtuukasyu) {
        ztynkshrtuukasyu = pZtynkshrtuukasyu;
    }

    private String ztynkteinksyu;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKTEINKSYU)
    public String getZtynkteinksyu() {
        return ztynkteinksyu;
    }

    public void setZtynkteinksyu(String pZtynkteinksyu) {
        ztynkteinksyu = pZtynkteinksyu;
    }

    private String ztynktsnnkgns;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKTSNNKGNS)
    public String getZtynktsnnkgns() {
        return ztynktsnnkgns;
    }

    public void setZtynktsnnkgns(String pZtynktsnnkgns) {
        ztynktsnnkgns = pZtynktsnnkgns;
    }

    private String ztynknkukthhkndouhyouji;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKNKUKTHHKNDOUHYOUJI)
    public String getZtynknkukthhkndouhyouji() {
        return ztynknkukthhkndouhyouji;
    }

    public void setZtynknkukthhkndouhyouji(String pZtynknkukthhkndouhyouji) {
        ztynknkukthhkndouhyouji = pZtynknkukthhkndouhyouji;
    }

    private String ztynksyouhnsdno;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKSYOUHNSDNO)
    public String getZtynksyouhnsdno() {
        return ztynksyouhnsdno;
    }

    public void setZtynksyouhnsdno(String pZtynksyouhnsdno) {
        ztynksyouhnsdno = pZtynksyouhnsdno;
    }

    private String ztytjtidounaiyouyobi04;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI04)
    public String getZtytjtidounaiyouyobi04() {
        return ztytjtidounaiyouyobi04;
    }

    public void setZtytjtidounaiyouyobi04(String pZtytjtidounaiyouyobi04) {
        ztytjtidounaiyouyobi04 = pZtytjtidounaiyouyobi04;
    }

    private String ztyhhknmei;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYHHKNMEI)
    public String getZtyhhknmei() {
        return ztyhhknmei;
    }

    public void setZtyhhknmei(String pZtyhhknmei) {
        ztyhhknmei = pZtyhhknmei;
    }

    private String ztyknjhhknmei;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKNJHHKNMEI)
    public String getZtyknjhhknmei() {
        return ztyknjhhknmei;
    }

    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        ztyknjhhknmei = pZtyknjhhknmei;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhhknnewyno;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYHHKNNEWYNO)
    public String getZtyhhknnewyno() {
        return ztyhhknnewyno;
    }

    public void setZtyhhknnewyno(String pZtyhhknnewyno) {
        ztyhhknnewyno = pZtyhhknnewyno;
    }

    private String ztyhhknadr;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYHHKNADR)
    public String getZtyhhknadr() {
        return ztyhhknadr;
    }

    public void setZtyhhknadr(String pZtyhhknadr) {
        ztyhhknadr = pZtyhhknadr;
    }

    private String ztyhhkntelno;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYHHKNTELNO)
    public String getZtyhhkntelno() {
        return ztyhhkntelno;
    }

    public void setZtyhhkntelno(String pZtyhhkntelno) {
        ztyhhkntelno = pZtyhhkntelno;
    }

    private String ztyhhknsykgycd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYHHKNSYKGYCD)
    public String getZtyhhknsykgycd() {
        return ztyhhknsykgycd;
    }

    public void setZtyhhknsykgycd(String pZtyhhknsykgycd) {
        ztyhhknsykgycd = pZtyhhknsykgycd;
    }

    private String ztytjtidounaiyouyobi05;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI05)
    public String getZtytjtidounaiyouyobi05() {
        return ztytjtidounaiyouyobi05;
    }

    public void setZtytjtidounaiyouyobi05(String pZtytjtidounaiyouyobi05) {
        ztytjtidounaiyouyobi05 = pZtytjtidounaiyouyobi05;
    }

    private String ztykyknm;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKYKNM)
    public String getZtykyknm() {
        return ztykyknm;
    }

    public void setZtykyknm(String pZtykyknm) {
        ztykyknm = pZtykyknm;
    }

    private String ztykjkyknm;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKJKYKNM)
    public String getZtykjkyknm() {
        return ztykjkyknm;
    }

    public void setZtykjkyknm(String pZtykjkyknm) {
        ztykjkyknm = pZtykjkyknm;
    }

    private String ztykyksyaseiymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKYKSYASEIYMD)
    public String getZtykyksyaseiymd() {
        return ztykyksyaseiymd;
    }

    public void setZtykyksyaseiymd(String pZtykyksyaseiymd) {
        ztykyksyaseiymd = pZtykyksyaseiymd;
    }

    private String ztytjtidounaiyouyobi06;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI06)
    public String getZtytjtidounaiyouyobi06() {
        return ztytjtidounaiyouyobi06;
    }

    public void setZtytjtidounaiyouyobi06(String pZtytjtidounaiyouyobi06) {
        ztytjtidounaiyouyobi06 = pZtytjtidounaiyouyobi06;
    }

    private String ztynkuktnm;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNKUKTNM)
    public String getZtynkuktnm() {
        return ztynkuktnm;
    }

    public void setZtynkuktnm(String pZtynkuktnm) {
        ztynkuktnm = pZtynkuktnm;
    }

    private String ztykjnkuktnm;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKJNKUKTNM)
    public String getZtykjnkuktnm() {
        return ztykjnkuktnm;
    }

    public void setZtykjnkuktnm(String pZtykjnkuktnm) {
        ztykjnkuktnm = pZtykjnkuktnm;
    }

    private String ztynenkinuktseiymd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYNENKINUKTSEIYMD)
    public String getZtynenkinuktseiymd() {
        return ztynenkinuktseiymd;
    }

    public void setZtynenkinuktseiymd(String pZtynenkinuktseiymd) {
        ztynenkinuktseiymd = pZtynenkinuktseiymd;
    }

    private String ztytjtidounaiyouyobi07;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI07)
    public String getZtytjtidounaiyouyobi07() {
        return ztytjtidounaiyouyobi07;
    }

    public void setZtytjtidounaiyouyobi07(String pZtytjtidounaiyouyobi07) {
        ztytjtidounaiyouyobi07 = pZtytjtidounaiyouyobi07;
    }

    private String ztytsnsknewyno;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTSNSKNEWYNO)
    public String getZtytsnsknewyno() {
        return ztytsnsknewyno;
    }

    public void setZtytsnsknewyno(String pZtytsnsknewyno) {
        ztytsnsknewyno = pZtytsnsknewyno;
    }

    private String ztytsinadr;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTSINADR)
    public String getZtytsinadr() {
        return ztytsinadr;
    }

    public void setZtytsinadr(String pZtytsinadr) {
        ztytsinadr = pZtytsinadr;
    }

    private String ztytsintelno;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTSINTELNO)
    public String getZtytsintelno() {
        return ztytsintelno;
    }

    public void setZtytsintelno(String pZtytsintelno) {
        ztytsintelno = pZtytsintelno;
    }

    private String ztytjtidounaiyouyobi08;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI08)
    public String getZtytjtidounaiyouyobi08() {
        return ztytjtidounaiyouyobi08;
    }

    public void setZtytjtidounaiyouyobi08(String pZtytjtidounaiyouyobi08) {
        ztytjtidounaiyouyobi08 = pZtytjtidounaiyouyobi08;
    }

    private String ztysbuktnm1;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSBUKTNM1)
    public String getZtysbuktnm1() {
        return ztysbuktnm1;
    }

    public void setZtysbuktnm1(String pZtysbuktnm1) {
        ztysbuktnm1 = pZtysbuktnm1;
    }

    private String ztykjsbuktnm1;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKJSBUKTNM1)
    public String getZtykjsbuktnm1() {
        return ztykjsbuktnm1;
    }

    public void setZtykjsbuktnm1(String pZtykjsbuktnm1) {
        ztykjsbuktnm1 = pZtykjsbuktnm1;
    }

    private String ztysbuktnm2;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSBUKTNM2)
    public String getZtysbuktnm2() {
        return ztysbuktnm2;
    }

    public void setZtysbuktnm2(String pZtysbuktnm2) {
        ztysbuktnm2 = pZtysbuktnm2;
    }

    private String ztykjsbuktnm2;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKJSBUKTNM2)
    public String getZtykjsbuktnm2() {
        return ztykjsbuktnm2;
    }

    public void setZtykjsbuktnm2(String pZtykjsbuktnm2) {
        ztykjsbuktnm2 = pZtykjsbuktnm2;
    }

    private String ztysbuktnm3;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSBUKTNM3)
    public String getZtysbuktnm3() {
        return ztysbuktnm3;
    }

    public void setZtysbuktnm3(String pZtysbuktnm3) {
        ztysbuktnm3 = pZtysbuktnm3;
    }

    private String ztykjsbuktnm3;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKJSBUKTNM3)
    public String getZtykjsbuktnm3() {
        return ztykjsbuktnm3;
    }

    public void setZtykjsbuktnm3(String pZtykjsbuktnm3) {
        ztykjsbuktnm3 = pZtykjsbuktnm3;
    }

    private String ztysbuktnm4;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSBUKTNM4)
    public String getZtysbuktnm4() {
        return ztysbuktnm4;
    }

    public void setZtysbuktnm4(String pZtysbuktnm4) {
        ztysbuktnm4 = pZtysbuktnm4;
    }

    private String ztykjsbuktnm4;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKJSBUKTNM4)
    public String getZtykjsbuktnm4() {
        return ztykjsbuktnm4;
    }

    public void setZtykjsbuktnm4(String pZtykjsbuktnm4) {
        ztykjsbuktnm4 = pZtykjsbuktnm4;
    }

    private String ztytjtidounaiyouyobi09;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI09)
    public String getZtytjtidounaiyouyobi09() {
        return ztytjtidounaiyouyobi09;
    }

    public void setZtytjtidounaiyouyobi09(String pZtytjtidounaiyouyobi09) {
        ztytjtidounaiyouyobi09 = pZtytjtidounaiyouyobi09;
    }

    private String ztystdrsknm;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSTDRSKNM)
    public String getZtystdrsknm() {
        return ztystdrsknm;
    }

    public void setZtystdrsknm(String pZtystdrsknm) {
        ztystdrsknm = pZtystdrsknm;
    }

    private String ztykjstdrsknm;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKJSTDRSKNM)
    public String getZtykjstdrsknm() {
        return ztykjstdrsknm;
    }

    public void setZtykjstdrsknm(String pZtykjstdrsknm) {
        ztykjstdrsknm = pZtykjstdrsknm;
    }

    private String ztykykdairinm;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKYKDAIRINM)
    public String getZtykykdairinm() {
        return ztykykdairinm;
    }

    public void setZtykykdairinm(String pZtykykdairinm) {
        ztykykdairinm = pZtykykdairinm;
    }

    private String ztykjkykdairinm;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKJKYKDAIRINM)
    public String getZtykjkykdairinm() {
        return ztykjkykdairinm;
    }

    public void setZtykjkykdairinm(String pZtykjkykdairinm) {
        ztykjkykdairinm = pZtykjkykdairinm;
    }

    private String ztytjtidounaiyouyobi10;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI10)
    public String getZtytjtidounaiyouyobi10() {
        return ztytjtidounaiyouyobi10;
    }

    public void setZtytjtidounaiyouyobi10(String pZtytjtidounaiyouyobi10) {
        ztytjtidounaiyouyobi10 = pZtytjtidounaiyouyobi10;
    }

    private String ztybankcd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYBANKCD)
    public String getZtybankcd() {
        return ztybankcd;
    }

    public void setZtybankcd(String pZtybankcd) {
        ztybankcd = pZtybankcd;
    }

    private String ztyshitencd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYSHITENCD)
    public String getZtyshitencd() {
        return ztyshitencd;
    }

    public void setZtyshitencd(String pZtyshitencd) {
        ztyshitencd = pZtyshitencd;
    }

    private String ztyyokinkbn;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYYOKINKBN)
    public String getZtyyokinkbn() {
        return ztyyokinkbn;
    }

    public void setZtyyokinkbn(String pZtyyokinkbn) {
        ztyyokinkbn = pZtyyokinkbn;
    }

    private String ztykouzano7keta;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKOUZANO7KETA)
    public String getZtykouzano7keta() {
        return ztykouzano7keta;
    }

    public void setZtykouzano7keta(String pZtykouzano7keta) {
        ztykouzano7keta = pZtykouzano7keta;
    }

    private String ztykzmeiginmei;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKZMEIGINMEI)
    public String getZtykzmeiginmei() {
        return ztykzmeiginmei;
    }

    public void setZtykzmeiginmei(String pZtykzmeiginmei) {
        ztykzmeiginmei = pZtykzmeiginmei;
    }

    private String ztykzkykdouhyouji;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKZKYKDOUHYOUJI)
    public String getZtykzkykdouhyouji() {
        return ztykzkykdouhyouji;
    }

    public void setZtykzkykdouhyouji(String pZtykzkykdouhyouji) {
        ztykzkykdouhyouji = pZtykzkykdouhyouji;
    }

    private String ztytjtidounaiyouyobi12;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI12)
    public String getZtytjtidounaiyouyobi12() {
        return ztytjtidounaiyouyobi12;
    }

    public void setZtytjtidounaiyouyobi12(String pZtytjtidounaiyouyobi12) {
        ztytjtidounaiyouyobi12 = pZtytjtidounaiyouyobi12;
    }

    private String ztykzktourokunm1;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKZKTOUROKUNM1)
    public String getZtykzktourokunm1() {
        return ztykzktourokunm1;
    }

    public void setZtykzktourokunm1(String pZtykzktourokunm1) {
        ztykzktourokunm1 = pZtykzktourokunm1;
    }

    private String ztykjkzktourokunm1;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKJKZKTOUROKUNM1)
    public String getZtykjkzktourokunm1() {
        return ztykjkzktourokunm1;
    }

    public void setZtykjkzktourokunm1(String pZtykjkzktourokunm1) {
        ztykjkzktourokunm1 = pZtykjkzktourokunm1;
    }

    private String ztykzktourokunm2;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKZKTOUROKUNM2)
    public String getZtykzktourokunm2() {
        return ztykzktourokunm2;
    }

    public void setZtykzktourokunm2(String pZtykzktourokunm2) {
        ztykzktourokunm2 = pZtykzktourokunm2;
    }

    private String ztykjkzktourokunm2;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYKJKZKTOUROKUNM2)
    public String getZtykjkzktourokunm2() {
        return ztykjkzktourokunm2;
    }

    public void setZtykjkzktourokunm2(String pZtykjkzktourokunm2) {
        ztykjkzktourokunm2 = pZtykjkzktourokunm2;
    }

    private String ztytjtidounaiyouyobi13;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI13)
    public String getZtytjtidounaiyouyobi13() {
        return ztytjtidounaiyouyobi13;
    }

    public void setZtytjtidounaiyouyobi13(String pZtytjtidounaiyouyobi13) {
        ztytjtidounaiyouyobi13 = pZtytjtidounaiyouyobi13;
    }

    private String ztydairitencd1;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYDAIRITENCD1)
    public String getZtydairitencd1() {
        return ztydairitencd1;
    }

    public void setZtydairitencd1(String pZtydairitencd1) {
        ztydairitencd1 = pZtydairitencd1;
    }

    private String ztybunwari1;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYBUNWARI1)
    public String getZtybunwari1() {
        return ztybunwari1;
    }

    public void setZtybunwari1(String pZtybunwari1) {
        ztybunwari1 = pZtybunwari1;
    }

    private String ztydairitencd2;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYDAIRITENCD2)
    public String getZtydairitencd2() {
        return ztydairitencd2;
    }

    public void setZtydairitencd2(String pZtydairitencd2) {
        ztydairitencd2 = pZtydairitencd2;
    }

    private String ztybunwari2;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYBUNWARI2)
    public String getZtybunwari2() {
        return ztybunwari2;
    }

    public void setZtybunwari2(String pZtybunwari2) {
        ztybunwari2 = pZtybunwari2;
    }

    private String ztyaatukaisosikicd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }

    private String ztybatukaisosikicd;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYBATUKAISOSIKICD)
    public String getZtybatukaisosikicd() {
        return ztybatukaisosikicd;
    }

    public void setZtybatukaisosikicd(String pZtybatukaisosikicd) {
        ztybatukaisosikicd = pZtybatukaisosikicd;
    }

    private String ztytjtidounaiyouyobi11;

    @Column(name=GenZT_TjtIdouNaiyouTy.ZTYTJTIDOUNAIYOUYOBI11)
    public String getZtytjtidounaiyouyobi11() {
        return ztytjtidounaiyouyobi11;
    }

    public void setZtytjtidounaiyouyobi11(String pZtytjtidounaiyouyobi11) {
        ztytjtidounaiyouyobi11 = pZtytjtidounaiyouyobi11;
    }
}