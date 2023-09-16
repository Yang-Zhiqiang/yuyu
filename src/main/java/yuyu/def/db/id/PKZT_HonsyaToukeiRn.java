package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_HonsyaToukeiRn;
import yuyu.def.db.mapping.GenZT_HonsyaToukeiRn;
import yuyu.def.db.meta.GenQZT_HonsyaToukeiRn;
import yuyu.def.db.meta.QZT_HonsyaToukeiRn;

/**
 * 本社統計Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HonsyaToukeiRn}</td><td colspan="3">本社統計Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkijyunym zrnkijyunym}</td><td>（連携用）基準年月</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosym</td><td>（連携用）申込月度</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsosikicd</td><td>（連携用）組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyoumetukbn</td><td>（連携用）申込消滅区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyumtkktymd</td><td>（連携用）申込消滅確定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnrenseihhknkbn</td><td>（連携用）連生被保険者区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhikettikekkacd</td><td>（連携用）諾否決定結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndkhktiymd</td><td>（連携用）諾否決定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketkbn</td><td>（連携用）決定区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeihknsyruikbn</td><td>（連携用）統計用保険種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2keta</td><td>（連携用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjykktkbn</td><td>（連携用）報状告知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnryouritukbn</td><td>（連携用）料率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhikts</td><td>（連携用）諾否決定Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkihons</td><td>（連携用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhhkndaisansyakykkbn</td><td>（連携用）被保険者第三者契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndainisentakuinfokakjkkbn</td><td>（連携用）第２選択情報確認状況区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmusymd</td><td>（連携用）申込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnryousyuuymd</td><td>（連携用）領収年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkokutiymd</td><td>（連携用）告知年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseikeirenrakuymd</td><td>（連携用）成契連絡年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknnyuuryokuymd</td><td>（連携用）入金入力年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisyaketnyuuryokuymd</td><td>（連携用）支社決定入力年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykkakiraiymd</td><td>（連携用）契約確認依頼年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakukakuninsyuruikbn</td><td>（連携用）契約確認種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiteidairikbn2</td><td>（連携用）指定代理人区分（２文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykkakjkkbn1</td><td>（連携用）契約確認状況区分（１文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykkakkanryouymd</td><td>（連携用）契約確認完了年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykkakketymd</td><td>（連携用）契約確認決定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykkakketkekkakbn</td><td>（連携用）契約確認決定結果区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykkaktantoukojincd</td><td>（連携用）契約確認担当者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnketsyacd</td><td>（連携用）決定者コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyosakuseiymd</td><td>（連携用）証券作成年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseisekiym</td><td>（連携用）成績計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaiharaikomip</td><td>（連携用）初回払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnmossyosakuseiymd</td><td>（連携用）申込書作成年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketteiriyuucdx1</td><td>（連携用）諾否決定理由コード＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketteiriyuucdx2</td><td>（連携用）諾否決定理由コード＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketteiriyuucdx3</td><td>（連携用）諾否決定理由コード＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketteiriyuucdx4</td><td>（連携用）諾否決定理由コード＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhenkouteiseisyorikaisuu</td><td>（連携用）変更訂正処理回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyosisyatodokekibouhyj</td><td>（連携用）証券支社届希望表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhndketkaisuu</td><td>（連携用）ハンド決定回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiikekkacd1</td><td>（連携用）諾否決定経緯結果コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiiketmd1</td><td>（連携用）諾否決定経緯決定月日１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiikekkacd2</td><td>（連携用）諾否決定経緯結果コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiiketmd2</td><td>（連携用）諾否決定経緯決定月日２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiikekkacd3</td><td>（連携用）諾否決定経緯結果コード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiiketmd3</td><td>（連携用）諾否決定経緯決定月日３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiikekkacd4</td><td>（連携用）諾否決定経緯結果コード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiiketmd4</td><td>（連携用）諾否決定経緯決定月日４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiikekkacd5</td><td>（連携用）諾否決定経緯結果コード５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiiketmd5</td><td>（連携用）諾否決定経緯決定月日５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiikekkacd6</td><td>（連携用）諾否決定経緯結果コード６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiketkeiiketmd6</td><td>（連携用）諾否決定経緯決定月日６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkojincd</td><td>（連携用）個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaipnyuukinhouhoukbn</td><td>（連携用）初回Ｐ入金方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsentakuinfoumuhyj</td><td>（連携用）選択情報有無表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhaitousiharaikbn</td><td>（連携用）配当支払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhonsyatkkohojyunhsys</td><td>（連携用）本社統計個保純保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntoukeiyousinsakbn</td><td>（連携用）統計用診査区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsknnkaisiymd</td><td>（連携用）責任開始日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsudirtnatkikeitaikbn</td><td>（連携用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknsynensyuukbn</td><td>（連携用）被保険者年収区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokusyujimutoriatukaikbn</td><td>（連携用）特殊事務取扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrninputmissteiseikaisuu</td><td>（連携用）インプットミス訂正処理回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkyknm</td><td>（連携用）漢字契約者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnknjhhknmei</td><td>（連携用）漢字被保険者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhonninkknnkbn</td><td>（連携用）本人確認区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknzumihyouji</td><td>（連携用）入金済表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknsykgycd</td><td>（連携用）被保険者職業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknjkkbn</td><td>（連携用）入金状況区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbatukaisyakojincd</td><td>（連携用）Ｂ扱者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsinfstpnyknhouhoukbn</td><td>（連携用）新初回Ｐ入金方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmostorikesikbn</td><td>（連携用）申込取消区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmostrkssyousairiyuukbn</td><td>（連携用）申込取消詳細理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossakuseino</td><td>（連携用）申込書作成番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsibous</td><td>（連携用）死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnharaikomip</td><td>（連携用）払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknm</td><td>（連携用）契約者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyktdkkbn</td><td>（連携用）契約者続柄区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyanen</td><td>（連携用）契約者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseikbn</td><td>（連携用）契約者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosjihonninkknnkbn</td><td>（連携用）申込時本人確認区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknmei</td><td>（連携用）被保険者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktkbn</td><td>（連携用）死亡受取人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjsbuktnm</td><td>（連携用）漢字死亡受取人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsbuktnm</td><td>（連携用）死亡受取人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbuktseiymd</td><td>（連携用）死亡受取人生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbukttdkkbn</td><td>（連携用）死亡受取人続柄区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjsiteidairininnm</td><td>（連携用）漢字指定代理人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsiteidairininnm</td><td>（連携用）指定代理人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfatcakakkekkakbn</td><td>（連携用）ＦＡＴＣＡ確認結果区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfatcamosjikakkokusekikbn</td><td>（連携用）ＦＡＴＣＡ申込時確認国籍区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfatcatorjikakkokusekikbn</td><td>（連携用）ＦＡＴＣＡ取引時確認国籍区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkakiraikbn</td><td>（連携用）口座確認依頼区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzkakiraiymd</td><td>（連携用）口座確認依頼年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbankyohurikzhyouji</td><td>（連携用）銀行預振口座表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzmeigikakuninzumikbn</td><td>（連携用）口座名義人確認済区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnznnkai</td><td>（連携用）前納回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktrkservicekbn</td><td>（連携用）ご家族登録サービス区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdrkbn</td><td>（連携用）契約者代理人区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkykdairinm</td><td>（連携用）漢字契約者代理人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykdairinm</td><td>（連携用）契約者代理人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzktdk1keta1</td><td>（連携用）登録家族続柄１（１桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkzktourokunm1</td><td>（連携用）漢字家族登録名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzktourokunm1</td><td>（連携用）家族登録名１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzktdk2keta1</td><td>（連携用）登録家族続柄２（１桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkzktourokunm2</td><td>（連携用）漢字家族登録名２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzktourokunm2</td><td>（連携用）家族登録名２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyakkanjyuryouhoukbn</td><td>（連携用）約款受領方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyakkanbunsyono</td><td>（連携用）約款文書番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktuutityokusoukbn</td><td>（連携用）ご家族通知直送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250</td><td>（連携用）予備項目Ｖ２５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv27</td><td>（連携用）予備項目Ｖ２７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_HonsyaToukeiRn
 * @see     GenZT_HonsyaToukeiRn
 * @see     QZT_HonsyaToukeiRn
 * @see     GenQZT_HonsyaToukeiRn
 */
public class PKZT_HonsyaToukeiRn extends AbstractExDBPrimaryKey<ZT_HonsyaToukeiRn, PKZT_HonsyaToukeiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_HonsyaToukeiRn() {
    }

    public PKZT_HonsyaToukeiRn(String pZrnkijyunym, String pZrnmosno) {
        zrnkijyunym = pZrnkijyunym;
        zrnmosno = pZrnmosno;
    }

    @Transient
    @Override
    public Class<ZT_HonsyaToukeiRn> getEntityClass() {
        return ZT_HonsyaToukeiRn.class;
    }

    private String zrnkijyunym;

    public String getZrnkijyunym() {
        return zrnkijyunym;
    }

    public void setZrnkijyunym(String pZrnkijyunym) {
        zrnkijyunym = pZrnkijyunym;
    }
    private String zrnmosno;

    public String getZrnmosno() {
        return zrnmosno;
    }

    public void setZrnmosno(String pZrnmosno) {
        zrnmosno = pZrnmosno;
    }

}