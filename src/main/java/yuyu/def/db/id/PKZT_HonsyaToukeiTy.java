package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_HonsyaToukeiTy;
import yuyu.def.db.mapping.GenZT_HonsyaToukeiTy;
import yuyu.def.db.meta.GenQZT_HonsyaToukeiTy;
import yuyu.def.db.meta.QZT_HonsyaToukeiTy;

/**
 * 本社統計Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HonsyaToukeiTy}</td><td colspan="3">本社統計Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykijyunym ztykijyunym}</td><td>（中継用）基準年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosym</td><td>（中継用）申込月度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysosikicd</td><td>（中継用）組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossyoumetukbn</td><td>（中継用）申込消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossyumtkktymd</td><td>（中継用）申込消滅確定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrenseihhknkbn</td><td>（中継用）連生被保険者区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhikettikekkacd</td><td>（中継用）諾否決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydkhktiymd</td><td>（中継用）諾否決定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketkbn</td><td>（中継用）決定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeihknsyruikbn</td><td>（中継用）統計用保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen2keta</td><td>（中継用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjykktkbn</td><td>（中継用）報状告知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyryouritukbn</td><td>（中継用）料率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhikts</td><td>（中継用）諾否決定Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykihons</td><td>（中継用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhhkndaisansyakykkbn</td><td>（中継用）被保険者第三者契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydainisentakuinfokakjkkbn</td><td>（中継用）第２選択情報確認状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymusymd</td><td>（中継用）申込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyryousyuuymd</td><td>（中継用）領収年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykokutiymd</td><td>（中継用）告知年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseikeirenrakuymd</td><td>（中継用）成契連絡年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknnyuuryokuymd</td><td>（中継用）入金入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisyaketnyuuryokuymd</td><td>（中継用）支社決定入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykkakiraiymd</td><td>（中継用）契約確認依頼年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakukakuninsyuruikbn</td><td>（中継用）契約確認種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiteidairikbn2</td><td>（中継用）指定代理人区分（２文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykkakjkkbn1</td><td>（中継用）契約確認状況区分（1文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykkakkanryouymd</td><td>（中継用）契約確認完了年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykkakketymd</td><td>（中継用）契約確認決定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykkakketkekkakbn</td><td>（中継用）契約確認決定結果区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykkaktantoukojincd</td><td>（中継用）契約確認担当者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyketsyacd</td><td>（中継用）決定者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyosakuseiymd</td><td>（中継用）証券作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseisekiym</td><td>（中継用）成績計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaiharaikomip</td><td>（中継用）初回払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztymossyosakuseiymd</td><td>（中継用）申込書作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono</td><td>（中継用）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketteiriyuucdx1</td><td>（中継用）諾否決定理由コード＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketteiriyuucdx2</td><td>（中継用）諾否決定理由コード＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketteiriyuucdx3</td><td>（中継用）諾否決定理由コード＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketteiriyuucdx4</td><td>（中継用）諾否決定理由コード＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhenkouteiseisyorikaisuu</td><td>（中継用）変更訂正処理回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyosisyatodokekibouhyj</td><td>（中継用）証券支社届希望表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhndketkaisuu</td><td>（中継用）ハンド決定回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiikekkacd1</td><td>（中継用）諾否決定経緯結果コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiiketmd1</td><td>（中継用）諾否決定経緯決定月日１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiikekkacd2</td><td>（中継用）諾否決定経緯結果コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiiketmd2</td><td>（中継用）諾否決定経緯決定月日２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiikekkacd3</td><td>（中継用）諾否決定経緯結果コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiiketmd3</td><td>（中継用）諾否決定経緯決定月日３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiikekkacd4</td><td>（中継用）諾否決定経緯結果コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiiketmd4</td><td>（中継用）諾否決定経緯決定月日４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiikekkacd5</td><td>（中継用）諾否決定経緯結果コード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiiketmd5</td><td>（中継用）諾否決定経緯決定月日５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiikekkacd6</td><td>（中継用）諾否決定経緯結果コード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiketkeiiketmd6</td><td>（中継用）諾否決定経緯決定月日６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykojincd</td><td>（中継用）個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaipnyuukinhouhoukbn</td><td>（中継用）初回Ｐ入金方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysentakuinfoumuhyj</td><td>（中継用）選択情報有無表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhaitousiharaikbn</td><td>（中継用）配当支払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhonsyatkkohojyunhsys</td><td>（中継用）本社統計個保純保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytoukeiyousinsakbn</td><td>（中継用）統計用診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysknnkaisiymd</td><td>（中継用）責任開始日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsudirtnatkikeitaikbn</td><td>（中継用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknsynensyuukbn</td><td>（中継用）被保険者年収区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokusyujimutoriatukaikbn</td><td>（中継用）特殊事務取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyinputmissteiseikaisuu</td><td>（中継用）インプットミス訂正処理回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkyknm</td><td>（中継用）漢字契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjhhknmei</td><td>（中継用）漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhonninkknnkbn</td><td>（中継用）本人確認区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknzumihyouji</td><td>（中継用）入金済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknsykgycd</td><td>（中継用）被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknjkkbn</td><td>（中継用）入金状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybatukaisyakojincd</td><td>（中継用）Ｂ扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysinfstpnyknhouhoukbn</td><td>（中継用）新初回Ｐ入金方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymostorikesikbn</td><td>（中継用）申込取消区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymostrkssyousairiyuukbn</td><td>（中継用）申込取消詳細理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossakuseino</td><td>（中継用）申込書作成番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysibous</td><td>（中継用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyharaikomip</td><td>（中継用）払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknm</td><td>（中継用）契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyktdkkbn</td><td>（中継用）契約者続柄区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyanen</td><td>（中継用）契約者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseikbn</td><td>（中継用）契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosjihonninkknnkbn</td><td>（中継用）申込時本人確認区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknmei</td><td>（中継用）被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktkbn</td><td>（中継用）死亡受取人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjsbuktnm</td><td>（中継用）漢字死亡受取人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktnm</td><td>（中継用）死亡受取人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbuktseiymd</td><td>（中継用）死亡受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbukttdkkbn</td><td>（中継用）死亡受取人続柄区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjsiteidairininnm</td><td>（中継用）漢字指定代理人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiteidairininnm</td><td>（中継用）指定代理人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfatcakakkekkakbn</td><td>（中継用）ＦＡＴＣＡ確認結果区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfatcamosjikakkokusekikbn</td><td>（中継用）ＦＡＴＣＡ申込時確認国籍区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfatcatorjikakkokusekikbn</td><td>（中継用）ＦＡＴＣＡ取引時確認国籍区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkakiraikbn</td><td>（中継用）口座確認依頼区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzkakiraiymd</td><td>（中継用）口座確認依頼年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybankyohurikzhyouji</td><td>（中継用）銀行預振口座表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzmeigikakuninzumikbn</td><td>（中継用）口座名義人確認済区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyznnkai</td><td>（中継用）前納回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktrkservicekbn</td><td>（中継用）ご家族登録サービス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrkbn</td><td>（中継用）契約者代理人区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkykdairinm</td><td>（中継用）漢字契約者代理人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdairinm</td><td>（中継用）契約者代理人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzktdk1keta1</td><td>（中継用）登録家族続柄１（１桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkzktourokunm1</td><td>（中継用）漢字家族登録名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktourokunm1</td><td>（中継用）家族登録名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzktdk2keta1</td><td>（中継用）登録家族続柄２（１桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkzktourokunm2</td><td>（中継用）漢字家族登録名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktourokunm2</td><td>（中継用）家族登録名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyakkanjyuryouhoukbn</td><td>（中継用）約款受領方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyakkanbunsyono</td><td>（中継用）約款文書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktuutityokusoukbn</td><td>（中継用）ご家族通知直送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250</td><td>（中継用）予備項目Ｖ２５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv27</td><td>（中継用）予備項目Ｖ２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_HonsyaToukeiTy
 * @see     GenZT_HonsyaToukeiTy
 * @see     QZT_HonsyaToukeiTy
 * @see     GenQZT_HonsyaToukeiTy
 */
public class PKZT_HonsyaToukeiTy extends AbstractExDBPrimaryKey<ZT_HonsyaToukeiTy, PKZT_HonsyaToukeiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_HonsyaToukeiTy() {
    }

    public PKZT_HonsyaToukeiTy(String pZtykijyunym, String pZtymosno) {
        ztykijyunym = pZtykijyunym;
        ztymosno = pZtymosno;
    }

    @Transient
    @Override
    public Class<ZT_HonsyaToukeiTy> getEntityClass() {
        return ZT_HonsyaToukeiTy.class;
    }

    private String ztykijyunym;

    public String getZtykijyunym() {
        return ztykijyunym;
    }

    public void setZtykijyunym(String pZtykijyunym) {
        ztykijyunym = pZtykijyunym;
    }
    private String ztymosno;

    public String getZtymosno() {
        return ztymosno;
    }

    public void setZtymosno(String pZtymosno) {
        ztymosno = pZtymosno;
    }

}