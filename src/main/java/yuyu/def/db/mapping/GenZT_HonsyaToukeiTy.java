package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import yuyu.def.db.entity.ZT_HonsyaToukeiTy;
import yuyu.def.db.id.PKZT_HonsyaToukeiTy;
import yuyu.def.db.meta.GenQZT_HonsyaToukeiTy;
import yuyu.def.db.meta.QZT_HonsyaToukeiTy;

/**
 * 本社統計Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_HonsyaToukeiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HonsyaToukeiTy}</td><td colspan="3">本社統計Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtykijyunym ztykijyunym}</td><td>（中継用）基準年月</td><td align="center">{@link PKZT_HonsyaToukeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosym ztymosym}</td><td>（中継用）申込月度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">{@link PKZT_HonsyaToukeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysosikicd ztysosikicd}</td><td>（中継用）組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyoumetukbn ztymossyoumetukbn}</td><td>（中継用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyumtkktymd ztymossyumtkktymd}</td><td>（中継用）申込消滅確定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrenseihhknkbn ztyrenseihhknkbn}</td><td>（中継用）連生被保険者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettikekkacd ztydakuhikettikekkacd}</td><td>（中継用）諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydkhktiymd ztydkhktiymd}</td><td>（中継用）諾否決定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketkbn ztyketkbn}</td><td>（中継用）決定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeihknsyruikbn ztytoukeihknsyruikbn}</td><td>（中継用）統計用保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2keta ztyhhknnen2keta}</td><td>（中継用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjykktkbn ztyhjykktkbn}</td><td>（中継用）報状告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryouritukbn ztyryouritukbn}</td><td>（中継用）料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikts ztydakuhikts}</td><td>（中継用）諾否決定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykihons ztykihons}</td><td>（中継用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhhkndaisansyakykkbn ztyhhkndaisansyakykkbn}</td><td>（中継用）被保険者第三者契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydainisentakuinfokakjkkbn ztydainisentakuinfokakjkkbn}</td><td>（中継用）第２選択情報確認状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusymd ztymusymd}</td><td>（中継用）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryousyuuymd ztyryousyuuymd}</td><td>（中継用）領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykokutiymd ztykokutiymd}</td><td>（中継用）告知年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikeirenrakuymd ztyseikeirenrakuymd}</td><td>（中継用）成契連絡年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknnyuuryokuymd ztynyknnyuuryokuymd}</td><td>（中継用）入金入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisyaketnyuuryokuymd ztysisyaketnyuuryokuymd}</td><td>（中継用）支社決定入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykkakiraiymd ztykykkakiraiymd}</td><td>（中継用）契約確認依頼年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakukakuninsyuruikbn ztykeiyakukakuninsyuruikbn}</td><td>（中継用）契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteidairikbn2 ztysiteidairikbn2}</td><td>（中継用）指定代理人区分（２文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykkakjkkbn1 ztykykkakjkkbn1}</td><td>（中継用）契約確認状況区分（1文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykkakkanryouymd ztykykkakkanryouymd}</td><td>（中継用）契約確認完了年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykkakketymd ztykykkakketymd}</td><td>（中継用）契約確認決定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykkakketkekkakbn ztykykkakketkekkakbn}</td><td>（中継用）契約確認決定結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykkaktantoukojincd ztykykkaktantoukojincd}</td><td>（中継用）契約確認担当者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketsyacd ztyketsyacd}</td><td>（中継用）決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosakuseiymd ztysyosakuseiymd}</td><td>（中継用）証券作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisekiym ztyseisekiym}</td><td>（中継用）成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaiharaikomip ztysyokaiharaikomip}</td><td>（中継用）初回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymossyosakuseiymd ztymossyosakuseiymd}</td><td>（中継用）申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx1 ztydakuhiketteiriyuucdx1}</td><td>（中継用）諾否決定理由コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx2 ztydakuhiketteiriyuucdx2}</td><td>（中継用）諾否決定理由コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx3 ztydakuhiketteiriyuucdx3}</td><td>（中継用）諾否決定理由コード＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketteiriyuucdx4 ztydakuhiketteiriyuucdx4}</td><td>（中継用）諾否決定理由コード＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhenkouteiseisyorikaisuu ztyhenkouteiseisyorikaisuu}</td><td>（中継用）変更訂正処理回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosisyatodokekibouhyj ztysyosisyatodokekibouhyj}</td><td>（中継用）証券支社届希望表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhndketkaisuu ztyhndketkaisuu}</td><td>（中継用）ハンド決定回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiikekkacd1 ztydakuhiketkeiikekkacd1}</td><td>（中継用）諾否決定経緯結果コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiiketmd1 ztydakuhiketkeiiketmd1}</td><td>（中継用）諾否決定経緯決定月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiikekkacd2 ztydakuhiketkeiikekkacd2}</td><td>（中継用）諾否決定経緯結果コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiiketmd2 ztydakuhiketkeiiketmd2}</td><td>（中継用）諾否決定経緯決定月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiikekkacd3 ztydakuhiketkeiikekkacd3}</td><td>（中継用）諾否決定経緯結果コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiiketmd3 ztydakuhiketkeiiketmd3}</td><td>（中継用）諾否決定経緯決定月日３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiikekkacd4 ztydakuhiketkeiikekkacd4}</td><td>（中継用）諾否決定経緯結果コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiiketmd4 ztydakuhiketkeiiketmd4}</td><td>（中継用）諾否決定経緯決定月日４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiikekkacd5 ztydakuhiketkeiikekkacd5}</td><td>（中継用）諾否決定経緯結果コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiiketmd5 ztydakuhiketkeiiketmd5}</td><td>（中継用）諾否決定経緯決定月日５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiikekkacd6 ztydakuhiketkeiikekkacd6}</td><td>（中継用）諾否決定経緯結果コード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiketkeiiketmd6 ztydakuhiketkeiiketmd6}</td><td>（中継用）諾否決定経緯決定月日６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykojincd ztykojincd}</td><td>（中継用）個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipnyuukinhouhoukbn ztysyokaipnyuukinhouhoukbn}</td><td>（中継用）初回Ｐ入金方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysentakuinfoumuhyj ztysentakuinfoumuhyj}</td><td>（中継用）選択情報有無表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitousiharaikbn ztyhaitousiharaikbn}</td><td>（中継用）配当支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhonsyatkkohojyunhsys ztyhonsyatkkohojyunhsys}</td><td>（中継用）本社統計個保純保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytoukeiyousinsakbn ztytoukeiyousinsakbn}</td><td>（中継用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysknnkaisiymd ztysknnkaisiymd}</td><td>（中継用）責任開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsynensyuukbn ztyhhknsynensyuukbn}</td><td>（中継用）被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokusyujimutoriatukaikbn ztytokusyujimutoriatukaikbn}</td><td>（中継用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyinputmissteiseikaisuu ztyinputmissteiseikaisuu}</td><td>（中継用）インプットミス訂正処理回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm ztykjkyknm}</td><td>（中継用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei ztyknjhhknmei}</td><td>（中継用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhonninkknnkbn ztyhonninkknnkbn}</td><td>（中継用）本人確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknzumihyouji ztynyknzumihyouji}</td><td>（中継用）入金済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsykgycd ztyhhknsykgycd}</td><td>（中継用）被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknjkkbn ztynyknjkkbn}</td><td>（中継用）入金状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatukaisyakojincd ztybatukaisyakojincd}</td><td>（中継用）Ｂ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinfstpnyknhouhoukbn ztysinfstpnyknhouhoukbn}</td><td>（中継用）新初回Ｐ入金方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymostorikesikbn ztymostorikesikbn}</td><td>（中継用）申込取消区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymostrkssyousairiyuukbn ztymostrkssyousairiyuukbn}</td><td>（中継用）申込取消詳細理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossakuseino ztymossakuseino}</td><td>（中継用）申込書作成番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibous ztysibous}</td><td>（中継用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyharaikomip ztyharaikomip}</td><td>（中継用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknm ztykyknm}</td><td>（中継用）契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktdkkbn ztykyktdkkbn}</td><td>（中継用）契約者続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseikbn ztykyksyaseikbn}</td><td>（中継用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosjihonninkknnkbn ztymosjihonninkknnkbn}</td><td>（中継用）申込時本人確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknmei ztyhhknmei}</td><td>（中継用）被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktkbn ztysbuktkbn}</td><td>（中継用）死亡受取人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjsbuktnm ztykjsbuktnm}</td><td>（中継用）漢字死亡受取人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktnm ztysbuktnm}</td><td>（中継用）死亡受取人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbuktseiymd ztysbuktseiymd}</td><td>（中継用）死亡受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbukttdkkbn ztysbukttdkkbn}</td><td>（中継用）死亡受取人続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjsiteidairininnm ztykjsiteidairininnm}</td><td>（中継用）漢字指定代理人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteidairininnm ztysiteidairininnm}</td><td>（中継用）指定代理人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfatcakakkekkakbn ztyfatcakakkekkakbn}</td><td>（中継用）ＦＡＴＣＡ確認結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfatcamosjikakkokusekikbn ztyfatcamosjikakkokusekikbn}</td><td>（中継用）ＦＡＴＣＡ申込時確認国籍区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfatcatorjikakkokusekikbn ztyfatcatorjikakkokusekikbn}</td><td>（中継用）ＦＡＴＣＡ取引時確認国籍区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkakiraikbn ztykzkakiraikbn}</td><td>（中継用）口座確認依頼区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkakiraiymd ztykzkakiraiymd}</td><td>（中継用）口座確認依頼年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybankyohurikzhyouji ztybankyohurikzhyouji}</td><td>（中継用）銀行預振口座表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzmeigikakuninzumikbn ztykzmeigikakuninzumikbn}</td><td>（中継用）口座名義人確認済区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyznnkai ztyznnkai}</td><td>（中継用）前納回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktrkservicekbn ztykzktrkservicekbn}</td><td>（中継用）ご家族登録サービス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrkbn ztykykdrkbn}</td><td>（中継用）契約者代理人区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkykdairinm ztykjkykdairinm}</td><td>（中継用）漢字契約者代理人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdairinm ztykykdairinm}</td><td>（中継用）契約者代理人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzktdk1keta1 ztytrkkzktdk1keta1}</td><td>（中継用）登録家族続柄１（１桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkzktourokunm1 ztykjkzktourokunm1}</td><td>（中継用）漢字家族登録名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokunm1 ztykzktourokunm1}</td><td>（中継用）家族登録名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzktdk2keta1 ztytrkkzktdk2keta1}</td><td>（中継用）登録家族続柄２（１桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkzktourokunm2 ztykjkzktourokunm2}</td><td>（中継用）漢字家族登録名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokunm2 ztykzktourokunm2}</td><td>（中継用）家族登録名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyakkanjyuryouhoukbn ztyyakkanjyuryouhoukbn}</td><td>（中継用）約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyakkanbunsyono ztyyakkanbunsyono}</td><td>（中継用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktuutityokusoukbn ztykzktuutityokusoukbn}</td><td>（中継用）ご家族通知直送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250 ztyyobiv250}</td><td>（中継用）予備項目Ｖ２５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv27 ztyyobiv27}</td><td>（中継用）予備項目Ｖ２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_HonsyaToukeiTy
 * @see     PKZT_HonsyaToukeiTy
 * @see     QZT_HonsyaToukeiTy
 * @see     GenQZT_HonsyaToukeiTy
 */
@MappedSuperclass
@Table(name=GenZT_HonsyaToukeiTy.TABLE_NAME)
@IdClass(value=PKZT_HonsyaToukeiTy.class)
public abstract class GenZT_HonsyaToukeiTy extends AbstractExDBEntity<ZT_HonsyaToukeiTy, PKZT_HonsyaToukeiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HonsyaToukeiTy";
    public static final String ZTYKIJYUNYM              = "ztykijyunym";
    public static final String ZTYMOSYM                 = "ztymosym";
    public static final String ZTYMOSNO                 = "ztymosno";
    public static final String ZTYSOSIKICD              = "ztysosikicd";
    public static final String ZTYMOSSYOUMETUKBN        = "ztymossyoumetukbn";
    public static final String ZTYMOSSYUMTKKTYMD        = "ztymossyumtkktymd";
    public static final String ZTYRENSEIHHKNKBN         = "ztyrenseihhknkbn";
    public static final String ZTYDAKUHIKETTIKEKKACD    = "ztydakuhikettikekkacd";
    public static final String ZTYDKHKTIYMD             = "ztydkhktiymd";
    public static final String ZTYKETKBN                = "ztyketkbn";
    public static final String ZTYTOUKEIHKNSYRUIKBN     = "ztytoukeihknsyruikbn";
    public static final String ZTYHHKNNEN2KETA          = "ztyhhknnen2keta";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHJYKKTKBN             = "ztyhjykktkbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYRYOURITUKBN           = "ztyryouritukbn";
    public static final String ZTYDAKUHIKTS             = "ztydakuhikts";
    public static final String ZTYKIHONS                = "ztykihons";
    public static final String ZTYHHKNDAISANSYAKYKKBN   = "ztyhhkndaisansyakykkbn";
    public static final String ZTYDAINISENTAKUINFOKAKJKKBN = "ztydainisentakuinfokakjkkbn";
    public static final String ZTYMUSYMD                = "ztymusymd";
    public static final String ZTYRYOUSYUUYMD           = "ztyryousyuuymd";
    public static final String ZTYKOKUTIYMD             = "ztykokutiymd";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYSEIKEIRENRAKUYMD      = "ztyseikeirenrakuymd";
    public static final String ZTYNYKNNYUURYOKUYMD      = "ztynyknnyuuryokuymd";
    public static final String ZTYSISYAKETNYUURYOKUYMD  = "ztysisyaketnyuuryokuymd";
    public static final String ZTYKYKKAKIRAIYMD         = "ztykykkakiraiymd";
    public static final String ZTYKEIYAKUKAKUNINSYURUIKBN = "ztykeiyakukakuninsyuruikbn";
    public static final String ZTYSITEIDAIRIKBN2        = "ztysiteidairikbn2";
    public static final String ZTYKYKKAKJKKBN1          = "ztykykkakjkkbn1";
    public static final String ZTYKYKKAKKANRYOUYMD      = "ztykykkakkanryouymd";
    public static final String ZTYKYKKAKKETYMD          = "ztykykkakketymd";
    public static final String ZTYKYKKAKKETKEKKAKBN     = "ztykykkakketkekkakbn";
    public static final String ZTYKYKKAKTANTOUKOJINCD   = "ztykykkaktantoukojincd";
    public static final String ZTYKETSYACD              = "ztyketsyacd";
    public static final String ZTYSYOSAKUSEIYMD         = "ztysyosakuseiymd";
    public static final String ZTYSEISEKIYM             = "ztyseisekiym";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYSYOKAIHARAIKOMIP      = "ztysyokaiharaikomip";
    public static final String ZTYMOSSYOSAKUSEIYMD      = "ztymossyosakuseiymd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX1 = "ztydakuhiketteiriyuucdx1";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX2 = "ztydakuhiketteiriyuucdx2";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX3 = "ztydakuhiketteiriyuucdx3";
    public static final String ZTYDAKUHIKETTEIRIYUUCDX4 = "ztydakuhiketteiriyuucdx4";
    public static final String ZTYHENKOUTEISEISYORIKAISUU = "ztyhenkouteiseisyorikaisuu";
    public static final String ZTYSYOSISYATODOKEKIBOUHYJ = "ztysyosisyatodokekibouhyj";
    public static final String ZTYHNDKETKAISUU          = "ztyhndketkaisuu";
    public static final String ZTYDAKUHIKETKEIIKEKKACD1 = "ztydakuhiketkeiikekkacd1";
    public static final String ZTYDAKUHIKETKEIIKETMD1   = "ztydakuhiketkeiiketmd1";
    public static final String ZTYDAKUHIKETKEIIKEKKACD2 = "ztydakuhiketkeiikekkacd2";
    public static final String ZTYDAKUHIKETKEIIKETMD2   = "ztydakuhiketkeiiketmd2";
    public static final String ZTYDAKUHIKETKEIIKEKKACD3 = "ztydakuhiketkeiikekkacd3";
    public static final String ZTYDAKUHIKETKEIIKETMD3   = "ztydakuhiketkeiiketmd3";
    public static final String ZTYDAKUHIKETKEIIKEKKACD4 = "ztydakuhiketkeiikekkacd4";
    public static final String ZTYDAKUHIKETKEIIKETMD4   = "ztydakuhiketkeiiketmd4";
    public static final String ZTYDAKUHIKETKEIIKEKKACD5 = "ztydakuhiketkeiikekkacd5";
    public static final String ZTYDAKUHIKETKEIIKETMD5   = "ztydakuhiketkeiiketmd5";
    public static final String ZTYDAKUHIKETKEIIKEKKACD6 = "ztydakuhiketkeiikekkacd6";
    public static final String ZTYDAKUHIKETKEIIKETMD6   = "ztydakuhiketkeiiketmd6";
    public static final String ZTYKOJINCD               = "ztykojincd";
    public static final String ZTYSYOKAIPNYUUKINHOUHOUKBN = "ztysyokaipnyuukinhouhoukbn";
    public static final String ZTYSENTAKUINFOUMUHYJ     = "ztysentakuinfoumuhyj";
    public static final String ZTYHAITOUSIHARAIKBN      = "ztyhaitousiharaikbn";
    public static final String ZTYHONSYATKKOHOJYUNHSYS  = "ztyhonsyatkkohojyunhsys";
    public static final String ZTYTOUKEIYOUSINSAKBN     = "ztytoukeiyousinsakbn";
    public static final String ZTYSKNNKAISIYMD          = "ztysknnkaisiymd";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYHHKNSYNENSYUUKBN      = "ztyhhknsynensyuukbn";
    public static final String ZTYTOKUSYUJIMUTORIATUKAIKBN = "ztytokusyujimutoriatukaikbn";
    public static final String ZTYINPUTMISSTEISEIKAISUU = "ztyinputmissteiseikaisuu";
    public static final String ZTYKJKYKNM               = "ztykjkyknm";
    public static final String ZTYKNJHHKNMEI            = "ztyknjhhknmei";
    public static final String ZTYHONNINKKNNKBN         = "ztyhonninkknnkbn";
    public static final String ZTYNYKNZUMIHYOUJI        = "ztynyknzumihyouji";
    public static final String ZTYHHKNSYKGYCD           = "ztyhhknsykgycd";
    public static final String ZTYNYKNJKKBN             = "ztynyknjkkbn";
    public static final String ZTYBATUKAISYAKOJINCD     = "ztybatukaisyakojincd";
    public static final String ZTYSINFSTPNYKNHOUHOUKBN  = "ztysinfstpnyknhouhoukbn";
    public static final String ZTYMOSTORIKESIKBN        = "ztymostorikesikbn";
    public static final String ZTYMOSTRKSSYOUSAIRIYUUKBN = "ztymostrkssyousairiyuukbn";
    public static final String ZTYMOSSAKUSEINO          = "ztymossakuseino";
    public static final String ZTYSIBOUS                = "ztysibous";
    public static final String ZTYHARAIKOMIP            = "ztyharaikomip";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYKYKNM                 = "ztykyknm";
    public static final String ZTYKYKTDKKBN             = "ztykyktdkkbn";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYKYKSYASEIKBN          = "ztykyksyaseikbn";
    public static final String ZTYMOSJIHONNINKKNNKBN    = "ztymosjihonninkknnkbn";
    public static final String ZTYHHKNMEI               = "ztyhhknmei";
    public static final String ZTYSBUKTKBN              = "ztysbuktkbn";
    public static final String ZTYKJSBUKTNM             = "ztykjsbuktnm";
    public static final String ZTYSBUKTNM               = "ztysbuktnm";
    public static final String ZTYSBUKTSEIYMD           = "ztysbuktseiymd";
    public static final String ZTYSBUKTTDKKBN           = "ztysbukttdkkbn";
    public static final String ZTYKJSITEIDAIRININNM     = "ztykjsiteidairininnm";
    public static final String ZTYSITEIDAIRININNM       = "ztysiteidairininnm";
    public static final String ZTYFATCAKAKKEKKAKBN      = "ztyfatcakakkekkakbn";
    public static final String ZTYFATCAMOSJIKAKKOKUSEKIKBN = "ztyfatcamosjikakkokusekikbn";
    public static final String ZTYFATCATORJIKAKKOKUSEKIKBN = "ztyfatcatorjikakkokusekikbn";
    public static final String ZTYKZKAKIRAIKBN          = "ztykzkakiraikbn";
    public static final String ZTYKZKAKIRAIYMD          = "ztykzkakiraiymd";
    public static final String ZTYBANKYOHURIKZHYOUJI    = "ztybankyohurikzhyouji";
    public static final String ZTYKZMEIGIKAKUNINZUMIKBN = "ztykzmeigikakuninzumikbn";
    public static final String ZTYZNNKAI                = "ztyznnkai";
    public static final String ZTYKZKTRKSERVICEKBN      = "ztykzktrkservicekbn";
    public static final String ZTYKYKDRKBN              = "ztykykdrkbn";
    public static final String ZTYKJKYKDAIRINM          = "ztykjkykdairinm";
    public static final String ZTYKYKDAIRINM            = "ztykykdairinm";
    public static final String ZTYTRKKZKTDK1KETA1       = "ztytrkkzktdk1keta1";
    public static final String ZTYKJKZKTOUROKUNM1       = "ztykjkzktourokunm1";
    public static final String ZTYKZKTOUROKUNM1         = "ztykzktourokunm1";
    public static final String ZTYTRKKZKTDK2KETA1       = "ztytrkkzktdk2keta1";
    public static final String ZTYKJKZKTOUROKUNM2       = "ztykjkzktourokunm2";
    public static final String ZTYKZKTOUROKUNM2         = "ztykzktourokunm2";
    public static final String ZTYYAKKANJYURYOUHOUKBN   = "ztyyakkanjyuryouhoukbn";
    public static final String ZTYYAKKANBUNSYONO        = "ztyyakkanbunsyono";
    public static final String ZTYKZKTUUTITYOKUSOUKBN   = "ztykzktuutityokusoukbn";
    public static final String ZTYYOBIV250              = "ztyyobiv250";
    public static final String ZTYYOBIV27               = "ztyyobiv27";

    private final PKZT_HonsyaToukeiTy primaryKey;

    public GenZT_HonsyaToukeiTy() {
        primaryKey = new PKZT_HonsyaToukeiTy();
    }

    public GenZT_HonsyaToukeiTy(String pZtykijyunym, String pZtymosno) {
        primaryKey = new PKZT_HonsyaToukeiTy(pZtykijyunym, pZtymosno);
    }

    @Transient
    @Override
    public PKZT_HonsyaToukeiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HonsyaToukeiTy> getMetaClass() {
        return QZT_HonsyaToukeiTy.class;
    }

    @Id
    @Column(name=GenZT_HonsyaToukeiTy.ZTYKIJYUNYM)
    public String getZtykijyunym() {
        return getPrimaryKey().getZtykijyunym();
    }

    public void setZtykijyunym(String pZtykijyunym) {
        getPrimaryKey().setZtykijyunym(pZtykijyunym);
    }

    private String ztymosym;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYMOSYM)
    public String getZtymosym() {
        return ztymosym;
    }

    public void setZtymosym(String pZtymosym) {
        ztymosym = pZtymosym;
    }

    @Id
    @Column(name=GenZT_HonsyaToukeiTy.ZTYMOSNO)
    public String getZtymosno() {
        return getPrimaryKey().getZtymosno();
    }

    public void setZtymosno(String pZtymosno) {
        getPrimaryKey().setZtymosno(pZtymosno);
    }

    private String ztysosikicd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSOSIKICD)
    public String getZtysosikicd() {
        return ztysosikicd;
    }

    public void setZtysosikicd(String pZtysosikicd) {
        ztysosikicd = pZtysosikicd;
    }

    private String ztymossyoumetukbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYMOSSYOUMETUKBN)
    public String getZtymossyoumetukbn() {
        return ztymossyoumetukbn;
    }

    public void setZtymossyoumetukbn(String pZtymossyoumetukbn) {
        ztymossyoumetukbn = pZtymossyoumetukbn;
    }

    private String ztymossyumtkktymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYMOSSYUMTKKTYMD)
    public String getZtymossyumtkktymd() {
        return ztymossyumtkktymd;
    }

    public void setZtymossyumtkktymd(String pZtymossyumtkktymd) {
        ztymossyumtkktymd = pZtymossyumtkktymd;
    }

    private String ztyrenseihhknkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYRENSEIHHKNKBN)
    public String getZtyrenseihhknkbn() {
        return ztyrenseihhknkbn;
    }

    public void setZtyrenseihhknkbn(String pZtyrenseihhknkbn) {
        ztyrenseihhknkbn = pZtyrenseihhknkbn;
    }

    private String ztydakuhikettikekkacd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETTIKEKKACD)
    public String getZtydakuhikettikekkacd() {
        return ztydakuhikettikekkacd;
    }

    public void setZtydakuhikettikekkacd(String pZtydakuhikettikekkacd) {
        ztydakuhikettikekkacd = pZtydakuhikettikekkacd;
    }

    private String ztydkhktiymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDKHKTIYMD)
    public String getZtydkhktiymd() {
        return ztydkhktiymd;
    }

    public void setZtydkhktiymd(String pZtydkhktiymd) {
        ztydkhktiymd = pZtydkhktiymd;
    }

    private String ztyketkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKETKBN)
    public String getZtyketkbn() {
        return ztyketkbn;
    }

    public void setZtyketkbn(String pZtyketkbn) {
        ztyketkbn = pZtyketkbn;
    }

    private String ztytoukeihknsyruikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYTOUKEIHKNSYRUIKBN)
    public String getZtytoukeihknsyruikbn() {
        return ztytoukeihknsyruikbn;
    }

    public void setZtytoukeihknsyruikbn(String pZtytoukeihknsyruikbn) {
        ztytoukeihknsyruikbn = pZtytoukeihknsyruikbn;
    }

    private String ztyhhknnen2keta;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHHKNNEN2KETA)
    public String getZtyhhknnen2keta() {
        return ztyhhknnen2keta;
    }

    public void setZtyhhknnen2keta(String pZtyhhknnen2keta) {
        ztyhhknnen2keta = pZtyhhknnen2keta;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhjykktkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHJYKKTKBN)
    public String getZtyhjykktkbn() {
        return ztyhjykktkbn;
    }

    public void setZtyhjykktkbn(String pZtyhjykktkbn) {
        ztyhjykktkbn = pZtyhjykktkbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyryouritukbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYRYOURITUKBN)
    public String getZtyryouritukbn() {
        return ztyryouritukbn;
    }

    public void setZtyryouritukbn(String pZtyryouritukbn) {
        ztyryouritukbn = pZtyryouritukbn;
    }

    private Long ztydakuhikts;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKTS)
    public Long getZtydakuhikts() {
        return ztydakuhikts;
    }

    public void setZtydakuhikts(Long pZtydakuhikts) {
        ztydakuhikts = pZtydakuhikts;
    }

    private Long ztykihons;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private String ztyhhkndaisansyakykkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHHKNDAISANSYAKYKKBN)
    public String getZtyhhkndaisansyakykkbn() {
        return ztyhhkndaisansyakykkbn;
    }

    public void setZtyhhkndaisansyakykkbn(String pZtyhhkndaisansyakykkbn) {
        ztyhhkndaisansyakykkbn = pZtyhhkndaisansyakykkbn;
    }

    private String ztydainisentakuinfokakjkkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAINISENTAKUINFOKAKJKKBN)
    public String getZtydainisentakuinfokakjkkbn() {
        return ztydainisentakuinfokakjkkbn;
    }

    public void setZtydainisentakuinfokakjkkbn(String pZtydainisentakuinfokakjkkbn) {
        ztydainisentakuinfokakjkkbn = pZtydainisentakuinfokakjkkbn;
    }

    private String ztymusymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYMUSYMD)
    public String getZtymusymd() {
        return ztymusymd;
    }

    public void setZtymusymd(String pZtymusymd) {
        ztymusymd = pZtymusymd;
    }

    private String ztyryousyuuymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYRYOUSYUUYMD)
    public String getZtyryousyuuymd() {
        return ztyryousyuuymd;
    }

    public void setZtyryousyuuymd(String pZtyryousyuuymd) {
        ztyryousyuuymd = pZtyryousyuuymd;
    }

    private String ztykokutiymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKOKUTIYMD)
    public String getZtykokutiymd() {
        return ztykokutiymd;
    }

    public void setZtykokutiymd(String pZtykokutiymd) {
        ztykokutiymd = pZtykokutiymd;
    }

    private String ztykykymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyseikeirenrakuymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSEIKEIRENRAKUYMD)
    public String getZtyseikeirenrakuymd() {
        return ztyseikeirenrakuymd;
    }

    public void setZtyseikeirenrakuymd(String pZtyseikeirenrakuymd) {
        ztyseikeirenrakuymd = pZtyseikeirenrakuymd;
    }

    private String ztynyknnyuuryokuymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYNYKNNYUURYOKUYMD)
    public String getZtynyknnyuuryokuymd() {
        return ztynyknnyuuryokuymd;
    }

    public void setZtynyknnyuuryokuymd(String pZtynyknnyuuryokuymd) {
        ztynyknnyuuryokuymd = pZtynyknnyuuryokuymd;
    }

    private String ztysisyaketnyuuryokuymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSISYAKETNYUURYOKUYMD)
    public String getZtysisyaketnyuuryokuymd() {
        return ztysisyaketnyuuryokuymd;
    }

    public void setZtysisyaketnyuuryokuymd(String pZtysisyaketnyuuryokuymd) {
        ztysisyaketnyuuryokuymd = pZtysisyaketnyuuryokuymd;
    }

    private String ztykykkakiraiymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKKAKIRAIYMD)
    public String getZtykykkakiraiymd() {
        return ztykykkakiraiymd;
    }

    public void setZtykykkakiraiymd(String pZtykykkakiraiymd) {
        ztykykkakiraiymd = pZtykykkakiraiymd;
    }

    private String ztykeiyakukakuninsyuruikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKEIYAKUKAKUNINSYURUIKBN)
    public String getZtykeiyakukakuninsyuruikbn() {
        return ztykeiyakukakuninsyuruikbn;
    }

    public void setZtykeiyakukakuninsyuruikbn(String pZtykeiyakukakuninsyuruikbn) {
        ztykeiyakukakuninsyuruikbn = pZtykeiyakukakuninsyuruikbn;
    }

    private String ztysiteidairikbn2;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSITEIDAIRIKBN2)
    public String getZtysiteidairikbn2() {
        return ztysiteidairikbn2;
    }

    public void setZtysiteidairikbn2(String pZtysiteidairikbn2) {
        ztysiteidairikbn2 = pZtysiteidairikbn2;
    }

    private String ztykykkakjkkbn1;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKKAKJKKBN1)
    public String getZtykykkakjkkbn1() {
        return ztykykkakjkkbn1;
    }

    public void setZtykykkakjkkbn1(String pZtykykkakjkkbn1) {
        ztykykkakjkkbn1 = pZtykykkakjkkbn1;
    }

    private String ztykykkakkanryouymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKKAKKANRYOUYMD)
    public String getZtykykkakkanryouymd() {
        return ztykykkakkanryouymd;
    }

    public void setZtykykkakkanryouymd(String pZtykykkakkanryouymd) {
        ztykykkakkanryouymd = pZtykykkakkanryouymd;
    }

    private String ztykykkakketymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKKAKKETYMD)
    public String getZtykykkakketymd() {
        return ztykykkakketymd;
    }

    public void setZtykykkakketymd(String pZtykykkakketymd) {
        ztykykkakketymd = pZtykykkakketymd;
    }

    private String ztykykkakketkekkakbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKKAKKETKEKKAKBN)
    public String getZtykykkakketkekkakbn() {
        return ztykykkakketkekkakbn;
    }

    public void setZtykykkakketkekkakbn(String pZtykykkakketkekkakbn) {
        ztykykkakketkekkakbn = pZtykykkakketkekkakbn;
    }

    private String ztykykkaktantoukojincd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKKAKTANTOUKOJINCD)
    public String getZtykykkaktantoukojincd() {
        return ztykykkaktantoukojincd;
    }

    public void setZtykykkaktantoukojincd(String pZtykykkaktantoukojincd) {
        ztykykkaktantoukojincd = pZtykykkaktantoukojincd;
    }

    private String ztyketsyacd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKETSYACD)
    public String getZtyketsyacd() {
        return ztyketsyacd;
    }

    public void setZtyketsyacd(String pZtyketsyacd) {
        ztyketsyacd = pZtyketsyacd;
    }

    private String ztysyosakuseiymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSYOSAKUSEIYMD)
    public String getZtysyosakuseiymd() {
        return ztysyosakuseiymd;
    }

    public void setZtysyosakuseiymd(String pZtysyosakuseiymd) {
        ztysyosakuseiymd = pZtysyosakuseiymd;
    }

    private String ztyseisekiym;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSEISEKIYM)
    public String getZtyseisekiym() {
        return ztyseisekiym;
    }

    public void setZtyseisekiym(String pZtyseisekiym) {
        ztyseisekiym = pZtyseisekiym;
    }

    private String ztybsyym;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private Long ztysyokaiharaikomip;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSYOKAIHARAIKOMIP)
    public Long getZtysyokaiharaikomip() {
        return ztysyokaiharaikomip;
    }

    public void setZtysyokaiharaikomip(Long pZtysyokaiharaikomip) {
        ztysyokaiharaikomip = pZtysyokaiharaikomip;
    }

    private String ztymossyosakuseiymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYMOSSYOSAKUSEIYMD)
    public String getZtymossyosakuseiymd() {
        return ztymossyosakuseiymd;
    }

    public void setZtymossyosakuseiymd(String pZtymossyosakuseiymd) {
        ztymossyosakuseiymd = pZtymossyosakuseiymd;
    }

    private String ztysyono;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztydakuhiketteiriyuucdx1;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETTEIRIYUUCDX1)
    public String getZtydakuhiketteiriyuucdx1() {
        return ztydakuhiketteiriyuucdx1;
    }

    public void setZtydakuhiketteiriyuucdx1(String pZtydakuhiketteiriyuucdx1) {
        ztydakuhiketteiriyuucdx1 = pZtydakuhiketteiriyuucdx1;
    }

    private String ztydakuhiketteiriyuucdx2;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETTEIRIYUUCDX2)
    public String getZtydakuhiketteiriyuucdx2() {
        return ztydakuhiketteiriyuucdx2;
    }

    public void setZtydakuhiketteiriyuucdx2(String pZtydakuhiketteiriyuucdx2) {
        ztydakuhiketteiriyuucdx2 = pZtydakuhiketteiriyuucdx2;
    }

    private String ztydakuhiketteiriyuucdx3;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETTEIRIYUUCDX3)
    public String getZtydakuhiketteiriyuucdx3() {
        return ztydakuhiketteiriyuucdx3;
    }

    public void setZtydakuhiketteiriyuucdx3(String pZtydakuhiketteiriyuucdx3) {
        ztydakuhiketteiriyuucdx3 = pZtydakuhiketteiriyuucdx3;
    }

    private String ztydakuhiketteiriyuucdx4;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETTEIRIYUUCDX4)
    public String getZtydakuhiketteiriyuucdx4() {
        return ztydakuhiketteiriyuucdx4;
    }

    public void setZtydakuhiketteiriyuucdx4(String pZtydakuhiketteiriyuucdx4) {
        ztydakuhiketteiriyuucdx4 = pZtydakuhiketteiriyuucdx4;
    }

    private String ztyhenkouteiseisyorikaisuu;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHENKOUTEISEISYORIKAISUU)
    public String getZtyhenkouteiseisyorikaisuu() {
        return ztyhenkouteiseisyorikaisuu;
    }

    public void setZtyhenkouteiseisyorikaisuu(String pZtyhenkouteiseisyorikaisuu) {
        ztyhenkouteiseisyorikaisuu = pZtyhenkouteiseisyorikaisuu;
    }

    private String ztysyosisyatodokekibouhyj;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSYOSISYATODOKEKIBOUHYJ)
    public String getZtysyosisyatodokekibouhyj() {
        return ztysyosisyatodokekibouhyj;
    }

    public void setZtysyosisyatodokekibouhyj(String pZtysyosisyatodokekibouhyj) {
        ztysyosisyatodokekibouhyj = pZtysyosisyatodokekibouhyj;
    }

    private String ztyhndketkaisuu;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHNDKETKAISUU)
    public String getZtyhndketkaisuu() {
        return ztyhndketkaisuu;
    }

    public void setZtyhndketkaisuu(String pZtyhndketkaisuu) {
        ztyhndketkaisuu = pZtyhndketkaisuu;
    }

    private String ztydakuhiketkeiikekkacd1;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKEKKACD1)
    public String getZtydakuhiketkeiikekkacd1() {
        return ztydakuhiketkeiikekkacd1;
    }

    public void setZtydakuhiketkeiikekkacd1(String pZtydakuhiketkeiikekkacd1) {
        ztydakuhiketkeiikekkacd1 = pZtydakuhiketkeiikekkacd1;
    }

    private String ztydakuhiketkeiiketmd1;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKETMD1)
    public String getZtydakuhiketkeiiketmd1() {
        return ztydakuhiketkeiiketmd1;
    }

    public void setZtydakuhiketkeiiketmd1(String pZtydakuhiketkeiiketmd1) {
        ztydakuhiketkeiiketmd1 = pZtydakuhiketkeiiketmd1;
    }

    private String ztydakuhiketkeiikekkacd2;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKEKKACD2)
    public String getZtydakuhiketkeiikekkacd2() {
        return ztydakuhiketkeiikekkacd2;
    }

    public void setZtydakuhiketkeiikekkacd2(String pZtydakuhiketkeiikekkacd2) {
        ztydakuhiketkeiikekkacd2 = pZtydakuhiketkeiikekkacd2;
    }

    private String ztydakuhiketkeiiketmd2;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKETMD2)
    public String getZtydakuhiketkeiiketmd2() {
        return ztydakuhiketkeiiketmd2;
    }

    public void setZtydakuhiketkeiiketmd2(String pZtydakuhiketkeiiketmd2) {
        ztydakuhiketkeiiketmd2 = pZtydakuhiketkeiiketmd2;
    }

    private String ztydakuhiketkeiikekkacd3;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKEKKACD3)
    public String getZtydakuhiketkeiikekkacd3() {
        return ztydakuhiketkeiikekkacd3;
    }

    public void setZtydakuhiketkeiikekkacd3(String pZtydakuhiketkeiikekkacd3) {
        ztydakuhiketkeiikekkacd3 = pZtydakuhiketkeiikekkacd3;
    }

    private String ztydakuhiketkeiiketmd3;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKETMD3)
    public String getZtydakuhiketkeiiketmd3() {
        return ztydakuhiketkeiiketmd3;
    }

    public void setZtydakuhiketkeiiketmd3(String pZtydakuhiketkeiiketmd3) {
        ztydakuhiketkeiiketmd3 = pZtydakuhiketkeiiketmd3;
    }

    private String ztydakuhiketkeiikekkacd4;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKEKKACD4)
    public String getZtydakuhiketkeiikekkacd4() {
        return ztydakuhiketkeiikekkacd4;
    }

    public void setZtydakuhiketkeiikekkacd4(String pZtydakuhiketkeiikekkacd4) {
        ztydakuhiketkeiikekkacd4 = pZtydakuhiketkeiikekkacd4;
    }

    private String ztydakuhiketkeiiketmd4;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKETMD4)
    public String getZtydakuhiketkeiiketmd4() {
        return ztydakuhiketkeiiketmd4;
    }

    public void setZtydakuhiketkeiiketmd4(String pZtydakuhiketkeiiketmd4) {
        ztydakuhiketkeiiketmd4 = pZtydakuhiketkeiiketmd4;
    }

    private String ztydakuhiketkeiikekkacd5;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKEKKACD5)
    public String getZtydakuhiketkeiikekkacd5() {
        return ztydakuhiketkeiikekkacd5;
    }

    public void setZtydakuhiketkeiikekkacd5(String pZtydakuhiketkeiikekkacd5) {
        ztydakuhiketkeiikekkacd5 = pZtydakuhiketkeiikekkacd5;
    }

    private String ztydakuhiketkeiiketmd5;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKETMD5)
    public String getZtydakuhiketkeiiketmd5() {
        return ztydakuhiketkeiiketmd5;
    }

    public void setZtydakuhiketkeiiketmd5(String pZtydakuhiketkeiiketmd5) {
        ztydakuhiketkeiiketmd5 = pZtydakuhiketkeiiketmd5;
    }

    private String ztydakuhiketkeiikekkacd6;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKEKKACD6)
    public String getZtydakuhiketkeiikekkacd6() {
        return ztydakuhiketkeiikekkacd6;
    }

    public void setZtydakuhiketkeiikekkacd6(String pZtydakuhiketkeiikekkacd6) {
        ztydakuhiketkeiikekkacd6 = pZtydakuhiketkeiikekkacd6;
    }

    private String ztydakuhiketkeiiketmd6;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYDAKUHIKETKEIIKETMD6)
    public String getZtydakuhiketkeiiketmd6() {
        return ztydakuhiketkeiiketmd6;
    }

    public void setZtydakuhiketkeiiketmd6(String pZtydakuhiketkeiiketmd6) {
        ztydakuhiketkeiiketmd6 = pZtydakuhiketkeiiketmd6;
    }

    private String ztykojincd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKOJINCD)
    public String getZtykojincd() {
        return ztykojincd;
    }

    public void setZtykojincd(String pZtykojincd) {
        ztykojincd = pZtykojincd;
    }

    private String ztysyokaipnyuukinhouhoukbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSYOKAIPNYUUKINHOUHOUKBN)
    public String getZtysyokaipnyuukinhouhoukbn() {
        return ztysyokaipnyuukinhouhoukbn;
    }

    public void setZtysyokaipnyuukinhouhoukbn(String pZtysyokaipnyuukinhouhoukbn) {
        ztysyokaipnyuukinhouhoukbn = pZtysyokaipnyuukinhouhoukbn;
    }

    private String ztysentakuinfoumuhyj;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSENTAKUINFOUMUHYJ)
    public String getZtysentakuinfoumuhyj() {
        return ztysentakuinfoumuhyj;
    }

    public void setZtysentakuinfoumuhyj(String pZtysentakuinfoumuhyj) {
        ztysentakuinfoumuhyj = pZtysentakuinfoumuhyj;
    }

    private String ztyhaitousiharaikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHAITOUSIHARAIKBN)
    public String getZtyhaitousiharaikbn() {
        return ztyhaitousiharaikbn;
    }

    public void setZtyhaitousiharaikbn(String pZtyhaitousiharaikbn) {
        ztyhaitousiharaikbn = pZtyhaitousiharaikbn;
    }

    private Long ztyhonsyatkkohojyunhsys;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHONSYATKKOHOJYUNHSYS)
    public Long getZtyhonsyatkkohojyunhsys() {
        return ztyhonsyatkkohojyunhsys;
    }

    public void setZtyhonsyatkkohojyunhsys(Long pZtyhonsyatkkohojyunhsys) {
        ztyhonsyatkkohojyunhsys = pZtyhonsyatkkohojyunhsys;
    }

    private String ztytoukeiyousinsakbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYTOUKEIYOUSINSAKBN)
    public String getZtytoukeiyousinsakbn() {
        return ztytoukeiyousinsakbn;
    }

    public void setZtytoukeiyousinsakbn(String pZtytoukeiyousinsakbn) {
        ztytoukeiyousinsakbn = pZtytoukeiyousinsakbn;
    }

    private String ztysknnkaisiymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSKNNKAISIYMD)
    public String getZtysknnkaisiymd() {
        return ztysknnkaisiymd;
    }

    public void setZtysknnkaisiymd(String pZtysknnkaisiymd) {
        ztysknnkaisiymd = pZtysknnkaisiymd;
    }

    private String ztybsudirtnatkikeitaikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }

    private String ztyhhknsynensyuukbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHHKNSYNENSYUUKBN)
    public String getZtyhhknsynensyuukbn() {
        return ztyhhknsynensyuukbn;
    }

    public void setZtyhhknsynensyuukbn(String pZtyhhknsynensyuukbn) {
        ztyhhknsynensyuukbn = pZtyhhknsynensyuukbn;
    }

    private String ztytokusyujimutoriatukaikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYTOKUSYUJIMUTORIATUKAIKBN)
    public String getZtytokusyujimutoriatukaikbn() {
        return ztytokusyujimutoriatukaikbn;
    }

    public void setZtytokusyujimutoriatukaikbn(String pZtytokusyujimutoriatukaikbn) {
        ztytokusyujimutoriatukaikbn = pZtytokusyujimutoriatukaikbn;
    }

    private String ztyinputmissteiseikaisuu;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYINPUTMISSTEISEIKAISUU)
    public String getZtyinputmissteiseikaisuu() {
        return ztyinputmissteiseikaisuu;
    }

    public void setZtyinputmissteiseikaisuu(String pZtyinputmissteiseikaisuu) {
        ztyinputmissteiseikaisuu = pZtyinputmissteiseikaisuu;
    }

    private String ztykjkyknm;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKJKYKNM)
    public String getZtykjkyknm() {
        return ztykjkyknm;
    }

    public void setZtykjkyknm(String pZtykjkyknm) {
        ztykjkyknm = pZtykjkyknm;
    }

    private String ztyknjhhknmei;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKNJHHKNMEI)
    public String getZtyknjhhknmei() {
        return ztyknjhhknmei;
    }

    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        ztyknjhhknmei = pZtyknjhhknmei;
    }

    private String ztyhonninkknnkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHONNINKKNNKBN)
    public String getZtyhonninkknnkbn() {
        return ztyhonninkknnkbn;
    }

    public void setZtyhonninkknnkbn(String pZtyhonninkknnkbn) {
        ztyhonninkknnkbn = pZtyhonninkknnkbn;
    }

    private String ztynyknzumihyouji;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYNYKNZUMIHYOUJI)
    public String getZtynyknzumihyouji() {
        return ztynyknzumihyouji;
    }

    public void setZtynyknzumihyouji(String pZtynyknzumihyouji) {
        ztynyknzumihyouji = pZtynyknzumihyouji;
    }

    private String ztyhhknsykgycd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHHKNSYKGYCD)
    public String getZtyhhknsykgycd() {
        return ztyhhknsykgycd;
    }

    public void setZtyhhknsykgycd(String pZtyhhknsykgycd) {
        ztyhhknsykgycd = pZtyhhknsykgycd;
    }

    private String ztynyknjkkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYNYKNJKKBN)
    public String getZtynyknjkkbn() {
        return ztynyknjkkbn;
    }

    public void setZtynyknjkkbn(String pZtynyknjkkbn) {
        ztynyknjkkbn = pZtynyknjkkbn;
    }

    private String ztybatukaisyakojincd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYBATUKAISYAKOJINCD)
    public String getZtybatukaisyakojincd() {
        return ztybatukaisyakojincd;
    }

    public void setZtybatukaisyakojincd(String pZtybatukaisyakojincd) {
        ztybatukaisyakojincd = pZtybatukaisyakojincd;
    }

    private String ztysinfstpnyknhouhoukbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSINFSTPNYKNHOUHOUKBN)
    public String getZtysinfstpnyknhouhoukbn() {
        return ztysinfstpnyknhouhoukbn;
    }

    public void setZtysinfstpnyknhouhoukbn(String pZtysinfstpnyknhouhoukbn) {
        ztysinfstpnyknhouhoukbn = pZtysinfstpnyknhouhoukbn;
    }

    private String ztymostorikesikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYMOSTORIKESIKBN)
    public String getZtymostorikesikbn() {
        return ztymostorikesikbn;
    }

    public void setZtymostorikesikbn(String pZtymostorikesikbn) {
        ztymostorikesikbn = pZtymostorikesikbn;
    }

    private String ztymostrkssyousairiyuukbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYMOSTRKSSYOUSAIRIYUUKBN)
    public String getZtymostrkssyousairiyuukbn() {
        return ztymostrkssyousairiyuukbn;
    }

    public void setZtymostrkssyousairiyuukbn(String pZtymostrkssyousairiyuukbn) {
        ztymostrkssyousairiyuukbn = pZtymostrkssyousairiyuukbn;
    }

    private String ztymossakuseino;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYMOSSAKUSEINO)
    public String getZtymossakuseino() {
        return ztymossakuseino;
    }

    public void setZtymossakuseino(String pZtymossakuseino) {
        ztymossakuseino = pZtymossakuseino;
    }

    private Long ztysibous;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSIBOUS)
    public Long getZtysibous() {
        return ztysibous;
    }

    public void setZtysibous(Long pZtysibous) {
        ztysibous = pZtysibous;
    }

    private Long ztyharaikomip;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHARAIKOMIP)
    public Long getZtyharaikomip() {
        return ztyharaikomip;
    }

    public void setZtyharaikomip(Long pZtyharaikomip) {
        ztyharaikomip = pZtyharaikomip;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztykyknm;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKNM)
    public String getZtykyknm() {
        return ztykyknm;
    }

    public void setZtykyknm(String pZtykyknm) {
        ztykyknm = pZtykyknm;
    }

    private String ztykyktdkkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKTDKKBN)
    public String getZtykyktdkkbn() {
        return ztykyktdkkbn;
    }

    public void setZtykyktdkkbn(String pZtykyktdkkbn) {
        ztykyktdkkbn = pZtykyktdkkbn;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztykyksyaseikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKSYASEIKBN)
    public String getZtykyksyaseikbn() {
        return ztykyksyaseikbn;
    }

    public void setZtykyksyaseikbn(String pZtykyksyaseikbn) {
        ztykyksyaseikbn = pZtykyksyaseikbn;
    }

    private String ztymosjihonninkknnkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYMOSJIHONNINKKNNKBN)
    public String getZtymosjihonninkknnkbn() {
        return ztymosjihonninkknnkbn;
    }

    public void setZtymosjihonninkknnkbn(String pZtymosjihonninkknnkbn) {
        ztymosjihonninkknnkbn = pZtymosjihonninkknnkbn;
    }

    private String ztyhhknmei;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYHHKNMEI)
    public String getZtyhhknmei() {
        return ztyhhknmei;
    }

    public void setZtyhhknmei(String pZtyhhknmei) {
        ztyhhknmei = pZtyhhknmei;
    }

    private String ztysbuktkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSBUKTKBN)
    public String getZtysbuktkbn() {
        return ztysbuktkbn;
    }

    public void setZtysbuktkbn(String pZtysbuktkbn) {
        ztysbuktkbn = pZtysbuktkbn;
    }

    private String ztykjsbuktnm;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKJSBUKTNM)
    public String getZtykjsbuktnm() {
        return ztykjsbuktnm;
    }

    public void setZtykjsbuktnm(String pZtykjsbuktnm) {
        ztykjsbuktnm = pZtykjsbuktnm;
    }

    private String ztysbuktnm;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSBUKTNM)
    public String getZtysbuktnm() {
        return ztysbuktnm;
    }

    public void setZtysbuktnm(String pZtysbuktnm) {
        ztysbuktnm = pZtysbuktnm;
    }

    private String ztysbuktseiymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSBUKTSEIYMD)
    public String getZtysbuktseiymd() {
        return ztysbuktseiymd;
    }

    public void setZtysbuktseiymd(String pZtysbuktseiymd) {
        ztysbuktseiymd = pZtysbuktseiymd;
    }

    private String ztysbukttdkkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSBUKTTDKKBN)
    public String getZtysbukttdkkbn() {
        return ztysbukttdkkbn;
    }

    public void setZtysbukttdkkbn(String pZtysbukttdkkbn) {
        ztysbukttdkkbn = pZtysbukttdkkbn;
    }

    private String ztykjsiteidairininnm;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKJSITEIDAIRININNM)
    public String getZtykjsiteidairininnm() {
        return ztykjsiteidairininnm;
    }

    public void setZtykjsiteidairininnm(String pZtykjsiteidairininnm) {
        ztykjsiteidairininnm = pZtykjsiteidairininnm;
    }

    private String ztysiteidairininnm;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYSITEIDAIRININNM)
    public String getZtysiteidairininnm() {
        return ztysiteidairininnm;
    }

    public void setZtysiteidairininnm(String pZtysiteidairininnm) {
        ztysiteidairininnm = pZtysiteidairininnm;
    }

    private String ztyfatcakakkekkakbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYFATCAKAKKEKKAKBN)
    public String getZtyfatcakakkekkakbn() {
        return ztyfatcakakkekkakbn;
    }

    public void setZtyfatcakakkekkakbn(String pZtyfatcakakkekkakbn) {
        ztyfatcakakkekkakbn = pZtyfatcakakkekkakbn;
    }

    private String ztyfatcamosjikakkokusekikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYFATCAMOSJIKAKKOKUSEKIKBN)
    public String getZtyfatcamosjikakkokusekikbn() {
        return ztyfatcamosjikakkokusekikbn;
    }

    public void setZtyfatcamosjikakkokusekikbn(String pZtyfatcamosjikakkokusekikbn) {
        ztyfatcamosjikakkokusekikbn = pZtyfatcamosjikakkokusekikbn;
    }

    private String ztyfatcatorjikakkokusekikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYFATCATORJIKAKKOKUSEKIKBN)
    public String getZtyfatcatorjikakkokusekikbn() {
        return ztyfatcatorjikakkokusekikbn;
    }

    public void setZtyfatcatorjikakkokusekikbn(String pZtyfatcatorjikakkokusekikbn) {
        ztyfatcatorjikakkokusekikbn = pZtyfatcatorjikakkokusekikbn;
    }

    private String ztykzkakiraikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKZKAKIRAIKBN)
    public String getZtykzkakiraikbn() {
        return ztykzkakiraikbn;
    }

    public void setZtykzkakiraikbn(String pZtykzkakiraikbn) {
        ztykzkakiraikbn = pZtykzkakiraikbn;
    }

    private String ztykzkakiraiymd;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKZKAKIRAIYMD)
    public String getZtykzkakiraiymd() {
        return ztykzkakiraiymd;
    }

    public void setZtykzkakiraiymd(String pZtykzkakiraiymd) {
        ztykzkakiraiymd = pZtykzkakiraiymd;
    }

    private String ztybankyohurikzhyouji;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYBANKYOHURIKZHYOUJI)
    public String getZtybankyohurikzhyouji() {
        return ztybankyohurikzhyouji;
    }

    public void setZtybankyohurikzhyouji(String pZtybankyohurikzhyouji) {
        ztybankyohurikzhyouji = pZtybankyohurikzhyouji;
    }

    private String ztykzmeigikakuninzumikbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKZMEIGIKAKUNINZUMIKBN)
    public String getZtykzmeigikakuninzumikbn() {
        return ztykzmeigikakuninzumikbn;
    }

    public void setZtykzmeigikakuninzumikbn(String pZtykzmeigikakuninzumikbn) {
        ztykzmeigikakuninzumikbn = pZtykzmeigikakuninzumikbn;
    }

    private String ztyznnkai;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYZNNKAI)
    public String getZtyznnkai() {
        return ztyznnkai;
    }

    public void setZtyznnkai(String pZtyznnkai) {
        ztyznnkai = pZtyznnkai;
    }

    private String ztykzktrkservicekbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKZKTRKSERVICEKBN)
    public String getZtykzktrkservicekbn() {
        return ztykzktrkservicekbn;
    }

    public void setZtykzktrkservicekbn(String pZtykzktrkservicekbn) {
        ztykzktrkservicekbn = pZtykzktrkservicekbn;
    }

    private String ztykykdrkbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKDRKBN)
    public String getZtykykdrkbn() {
        return ztykykdrkbn;
    }

    public void setZtykykdrkbn(String pZtykykdrkbn) {
        ztykykdrkbn = pZtykykdrkbn;
    }

    private String ztykjkykdairinm;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKJKYKDAIRINM)
    public String getZtykjkykdairinm() {
        return ztykjkykdairinm;
    }

    public void setZtykjkykdairinm(String pZtykjkykdairinm) {
        ztykjkykdairinm = pZtykjkykdairinm;
    }

    private String ztykykdairinm;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKYKDAIRINM)
    public String getZtykykdairinm() {
        return ztykykdairinm;
    }

    public void setZtykykdairinm(String pZtykykdairinm) {
        ztykykdairinm = pZtykykdairinm;
    }

    private String ztytrkkzktdk1keta1;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYTRKKZKTDK1KETA1)
    public String getZtytrkkzktdk1keta1() {
        return ztytrkkzktdk1keta1;
    }

    public void setZtytrkkzktdk1keta1(String pZtytrkkzktdk1keta1) {
        ztytrkkzktdk1keta1 = pZtytrkkzktdk1keta1;
    }

    private String ztykjkzktourokunm1;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKJKZKTOUROKUNM1)
    public String getZtykjkzktourokunm1() {
        return ztykjkzktourokunm1;
    }

    public void setZtykjkzktourokunm1(String pZtykjkzktourokunm1) {
        ztykjkzktourokunm1 = pZtykjkzktourokunm1;
    }

    private String ztykzktourokunm1;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKZKTOUROKUNM1)
    public String getZtykzktourokunm1() {
        return ztykzktourokunm1;
    }

    public void setZtykzktourokunm1(String pZtykzktourokunm1) {
        ztykzktourokunm1 = pZtykzktourokunm1;
    }

    private String ztytrkkzktdk2keta1;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYTRKKZKTDK2KETA1)
    public String getZtytrkkzktdk2keta1() {
        return ztytrkkzktdk2keta1;
    }

    public void setZtytrkkzktdk2keta1(String pZtytrkkzktdk2keta1) {
        ztytrkkzktdk2keta1 = pZtytrkkzktdk2keta1;
    }

    private String ztykjkzktourokunm2;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKJKZKTOUROKUNM2)
    public String getZtykjkzktourokunm2() {
        return ztykjkzktourokunm2;
    }

    public void setZtykjkzktourokunm2(String pZtykjkzktourokunm2) {
        ztykjkzktourokunm2 = pZtykjkzktourokunm2;
    }

    private String ztykzktourokunm2;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKZKTOUROKUNM2)
    public String getZtykzktourokunm2() {
        return ztykzktourokunm2;
    }

    public void setZtykzktourokunm2(String pZtykzktourokunm2) {
        ztykzktourokunm2 = pZtykzktourokunm2;
    }

    private String ztyyakkanjyuryouhoukbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYYAKKANJYURYOUHOUKBN)
    public String getZtyyakkanjyuryouhoukbn() {
        return ztyyakkanjyuryouhoukbn;
    }

    public void setZtyyakkanjyuryouhoukbn(String pZtyyakkanjyuryouhoukbn) {
        ztyyakkanjyuryouhoukbn = pZtyyakkanjyuryouhoukbn;
    }

    private String ztyyakkanbunsyono;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYYAKKANBUNSYONO)
    public String getZtyyakkanbunsyono() {
        return ztyyakkanbunsyono;
    }

    public void setZtyyakkanbunsyono(String pZtyyakkanbunsyono) {
        ztyyakkanbunsyono = pZtyyakkanbunsyono;
    }

    private String ztykzktuutityokusoukbn;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYKZKTUUTITYOKUSOUKBN)
    public String getZtykzktuutityokusoukbn() {
        return ztykzktuutityokusoukbn;
    }

    public void setZtykzktuutityokusoukbn(String pZtykzktuutityokusoukbn) {
        ztykzktuutityokusoukbn = pZtykzktuutityokusoukbn;
    }

    private String ztyyobiv250;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYYOBIV250)
    public String getZtyyobiv250() {
        return ztyyobiv250;
    }

    public void setZtyyobiv250(String pZtyyobiv250) {
        ztyyobiv250 = pZtyyobiv250;
    }

    private String ztyyobiv27;

    @Column(name=GenZT_HonsyaToukeiTy.ZTYYOBIV27)
    public String getZtyyobiv27() {
        return ztyyobiv27;
    }

    public void setZtyyobiv27(String pZtyyobiv27) {
        ztyyobiv27 = pZtyyobiv27;
    }
}