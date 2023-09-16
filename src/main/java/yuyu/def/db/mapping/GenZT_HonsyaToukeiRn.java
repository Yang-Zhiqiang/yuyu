package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_HonsyaToukeiRn;
import yuyu.def.db.id.PKZT_HonsyaToukeiRn;
import yuyu.def.db.meta.GenQZT_HonsyaToukeiRn;
import yuyu.def.db.meta.QZT_HonsyaToukeiRn;

/**
 * 本社統計Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_HonsyaToukeiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HonsyaToukeiRn}</td><td colspan="3">本社統計Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkijyunym zrnkijyunym}</td><td>（連携用）基準年月</td><td align="center">{@link PKZT_HonsyaToukeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosym zrnmosym}</td><td>（連携用）申込月度</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">{@link PKZT_HonsyaToukeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikicd zrnsosikicd}</td><td>（連携用）組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyoumetukbn zrnmossyoumetukbn}</td><td>（連携用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyumtkktymd zrnmossyumtkktymd}</td><td>（連携用）申込消滅確定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnrenseihhknkbn zrnrenseihhknkbn}</td><td>（連携用）連生被保険者区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettikekkacd zrndakuhikettikekkacd}</td><td>（連携用）諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndkhktiymd zrndkhktiymd}</td><td>（連携用）諾否決定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketkbn zrnketkbn}</td><td>（連携用）決定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeihknsyruikbn zrntoukeihknsyruikbn}</td><td>（連携用）統計用保険種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2keta zrnhhknnen2keta}</td><td>（連携用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjykktkbn zrnhjykktkbn}</td><td>（連携用）報状告知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryouritukbn zrnryouritukbn}</td><td>（連携用）料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikts zrndakuhikts}</td><td>（連携用）諾否決定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkihons zrnkihons}</td><td>（連携用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhhkndaisansyakykkbn zrnhhkndaisansyakykkbn}</td><td>（連携用）被保険者第三者契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndainisentakuinfokakjkkbn zrndainisentakuinfokakjkkbn}</td><td>（連携用）第２選択情報確認状況区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusymd zrnmusymd}</td><td>（連携用）申込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryousyuuymd zrnryousyuuymd}</td><td>（連携用）領収年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkokutiymd zrnkokutiymd}</td><td>（連携用）告知年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikeirenrakuymd zrnseikeirenrakuymd}</td><td>（連携用）成契連絡年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknnyuuryokuymd zrnnyknnyuuryokuymd}</td><td>（連携用）入金入力年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisyaketnyuuryokuymd zrnsisyaketnyuuryokuymd}</td><td>（連携用）支社決定入力年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykkakiraiymd zrnkykkakiraiymd}</td><td>（連携用）契約確認依頼年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakukakuninsyuruikbn zrnkeiyakukakuninsyuruikbn}</td><td>（連携用）契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteidairikbn2 zrnsiteidairikbn2}</td><td>（連携用）指定代理人区分（２文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykkakjkkbn1 zrnkykkakjkkbn1}</td><td>（連携用）契約確認状況区分（１文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykkakkanryouymd zrnkykkakkanryouymd}</td><td>（連携用）契約確認完了年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykkakketymd zrnkykkakketymd}</td><td>（連携用）契約確認決定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykkakketkekkakbn zrnkykkakketkekkakbn}</td><td>（連携用）契約確認決定結果区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykkaktantoukojincd zrnkykkaktantoukojincd}</td><td>（連携用）契約確認担当者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnketsyacd zrnketsyacd}</td><td>（連携用）決定者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosakuseiymd zrnsyosakuseiymd}</td><td>（連携用）証券作成年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisekiym zrnseisekiym}</td><td>（連携用）成績計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaiharaikomip zrnsyokaiharaikomip}</td><td>（連携用）初回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmossyosakuseiymd zrnmossyosakuseiymd}</td><td>（連携用）申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx1 zrndakuhiketteiriyuucdx1}</td><td>（連携用）諾否決定理由コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx2 zrndakuhiketteiriyuucdx2}</td><td>（連携用）諾否決定理由コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx3 zrndakuhiketteiriyuucdx3}</td><td>（連携用）諾否決定理由コード＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketteiriyuucdx4 zrndakuhiketteiriyuucdx4}</td><td>（連携用）諾否決定理由コード＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhenkouteiseisyorikaisuu zrnhenkouteiseisyorikaisuu}</td><td>（連携用）変更訂正処理回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosisyatodokekibouhyj zrnsyosisyatodokekibouhyj}</td><td>（連携用）証券支社届希望表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhndketkaisuu zrnhndketkaisuu}</td><td>（連携用）ハンド決定回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiikekkacd1 zrndakuhiketkeiikekkacd1}</td><td>（連携用）諾否決定経緯結果コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiiketmd1 zrndakuhiketkeiiketmd1}</td><td>（連携用）諾否決定経緯決定月日１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiikekkacd2 zrndakuhiketkeiikekkacd2}</td><td>（連携用）諾否決定経緯結果コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiiketmd2 zrndakuhiketkeiiketmd2}</td><td>（連携用）諾否決定経緯決定月日２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiikekkacd3 zrndakuhiketkeiikekkacd3}</td><td>（連携用）諾否決定経緯結果コード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiiketmd3 zrndakuhiketkeiiketmd3}</td><td>（連携用）諾否決定経緯決定月日３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiikekkacd4 zrndakuhiketkeiikekkacd4}</td><td>（連携用）諾否決定経緯結果コード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiiketmd4 zrndakuhiketkeiiketmd4}</td><td>（連携用）諾否決定経緯決定月日４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiikekkacd5 zrndakuhiketkeiikekkacd5}</td><td>（連携用）諾否決定経緯結果コード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiiketmd5 zrndakuhiketkeiiketmd5}</td><td>（連携用）諾否決定経緯決定月日５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiikekkacd6 zrndakuhiketkeiikekkacd6}</td><td>（連携用）諾否決定経緯結果コード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiketkeiiketmd6 zrndakuhiketkeiiketmd6}</td><td>（連携用）諾否決定経緯決定月日６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkojincd zrnkojincd}</td><td>（連携用）個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipnyuukinhouhoukbn zrnsyokaipnyuukinhouhoukbn}</td><td>（連携用）初回Ｐ入金方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsentakuinfoumuhyj zrnsentakuinfoumuhyj}</td><td>（連携用）選択情報有無表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaitousiharaikbn zrnhaitousiharaikbn}</td><td>（連携用）配当支払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhonsyatkkohojyunhsys zrnhonsyatkkohojyunhsys}</td><td>（連携用）本社統計個保純保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntoukeiyousinsakbn zrntoukeiyousinsakbn}</td><td>（連携用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsknnkaisiymd zrnsknnkaisiymd}</td><td>（連携用）責任開始日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsynensyuukbn zrnhhknsynensyuukbn}</td><td>（連携用）被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokusyujimutoriatukaikbn zrntokusyujimutoriatukaikbn}</td><td>（連携用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrninputmissteiseikaisuu zrninputmissteiseikaisuu}</td><td>（連携用）インプットミス訂正処理回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm zrnkjkyknm}</td><td>（連携用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei zrnknjhhknmei}</td><td>（連携用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhonninkknnkbn zrnhonninkknnkbn}</td><td>（連携用）本人確認区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknzumihyouji zrnnyknzumihyouji}</td><td>（連携用）入金済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsykgycd zrnhhknsykgycd}</td><td>（連携用）被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknjkkbn zrnnyknjkkbn}</td><td>（連携用）入金状況区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatukaisyakojincd zrnbatukaisyakojincd}</td><td>（連携用）Ｂ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsinfstpnyknhouhoukbn zrnsinfstpnyknhouhoukbn}</td><td>（連携用）新初回Ｐ入金方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmostorikesikbn zrnmostorikesikbn}</td><td>（連携用）申込取消区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmostrkssyousairiyuukbn zrnmostrkssyousairiyuukbn}</td><td>（連携用）申込取消詳細理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossakuseino zrnmossakuseino}</td><td>（連携用）申込書作成番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibous zrnsibous}</td><td>（連携用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnharaikomip zrnharaikomip}</td><td>（連携用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknm zrnkyknm}</td><td>（連携用）契約者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktdkkbn zrnkyktdkkbn}</td><td>（連携用）契約者続柄区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen zrnkyksyanen}</td><td>（連携用）契約者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseikbn zrnkyksyaseikbn}</td><td>（連携用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosjihonninkknnkbn zrnmosjihonninkknnkbn}</td><td>（連携用）申込時本人確認区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknmei zrnhhknmei}</td><td>（連携用）被保険者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktkbn zrnsbuktkbn}</td><td>（連携用）死亡受取人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsbuktnm zrnkjsbuktnm}</td><td>（連携用）漢字死亡受取人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktnm zrnsbuktnm}</td><td>（連携用）死亡受取人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbuktseiymd zrnsbuktseiymd}</td><td>（連携用）死亡受取人生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbukttdkkbn zrnsbukttdkkbn}</td><td>（連携用）死亡受取人続柄区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsiteidairininnm zrnkjsiteidairininnm}</td><td>（連携用）漢字指定代理人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteidairininnm zrnsiteidairininnm}</td><td>（連携用）指定代理人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfatcakakkekkakbn zrnfatcakakkekkakbn}</td><td>（連携用）ＦＡＴＣＡ確認結果区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfatcamosjikakkokusekikbn zrnfatcamosjikakkokusekikbn}</td><td>（連携用）ＦＡＴＣＡ申込時確認国籍区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfatcatorjikakkokusekikbn zrnfatcatorjikakkokusekikbn}</td><td>（連携用）ＦＡＴＣＡ取引時確認国籍区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkakiraikbn zrnkzkakiraikbn}</td><td>（連携用）口座確認依頼区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkakiraiymd zrnkzkakiraiymd}</td><td>（連携用）口座確認依頼年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbankyohurikzhyouji zrnbankyohurikzhyouji}</td><td>（連携用）銀行預振口座表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzmeigikakuninzumikbn zrnkzmeigikakuninzumikbn}</td><td>（連携用）口座名義人確認済区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnznnkai zrnznnkai}</td><td>（連携用）前納回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktrkservicekbn zrnkzktrkservicekbn}</td><td>（連携用）ご家族登録サービス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrkbn zrnkykdrkbn}</td><td>（連携用）契約者代理人区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkykdairinm zrnkjkykdairinm}</td><td>（連携用）漢字契約者代理人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdairinm zrnkykdairinm}</td><td>（連携用）契約者代理人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzktdk1keta1 zrntrkkzktdk1keta1}</td><td>（連携用）登録家族続柄１（１桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkzktourokunm1 zrnkjkzktourokunm1}</td><td>（連携用）漢字家族登録名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokunm1 zrnkzktourokunm1}</td><td>（連携用）家族登録名１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzktdk2keta1 zrntrkkzktdk2keta1}</td><td>（連携用）登録家族続柄２（１桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkzktourokunm2 zrnkjkzktourokunm2}</td><td>（連携用）漢字家族登録名２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokunm2 zrnkzktourokunm2}</td><td>（連携用）家族登録名２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakkanjyuryouhoukbn zrnyakkanjyuryouhoukbn}</td><td>（連携用）約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakkanbunsyono zrnyakkanbunsyono}</td><td>（連携用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktuutityokusoukbn zrnkzktuutityokusoukbn}</td><td>（連携用）ご家族通知直送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250 zrnyobiv250}</td><td>（連携用）予備項目Ｖ２５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv27 zrnyobiv27}</td><td>（連携用）予備項目Ｖ２７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_HonsyaToukeiRn
 * @see     PKZT_HonsyaToukeiRn
 * @see     QZT_HonsyaToukeiRn
 * @see     GenQZT_HonsyaToukeiRn
 */
@MappedSuperclass
@Table(name=GenZT_HonsyaToukeiRn.TABLE_NAME)
@IdClass(value=PKZT_HonsyaToukeiRn.class)
public abstract class GenZT_HonsyaToukeiRn extends AbstractExDBEntityForZDB<ZT_HonsyaToukeiRn, PKZT_HonsyaToukeiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HonsyaToukeiRn";
    public static final String ZRNKIJYUNYM              = "zrnkijyunym";
    public static final String ZRNMOSYM                 = "zrnmosym";
    public static final String ZRNMOSNO                 = "zrnmosno";
    public static final String ZRNSOSIKICD              = "zrnsosikicd";
    public static final String ZRNMOSSYOUMETUKBN        = "zrnmossyoumetukbn";
    public static final String ZRNMOSSYUMTKKTYMD        = "zrnmossyumtkktymd";
    public static final String ZRNRENSEIHHKNKBN         = "zrnrenseihhknkbn";
    public static final String ZRNDAKUHIKETTIKEKKACD    = "zrndakuhikettikekkacd";
    public static final String ZRNDKHKTIYMD             = "zrndkhktiymd";
    public static final String ZRNKETKBN                = "zrnketkbn";
    public static final String ZRNTOUKEIHKNSYRUIKBN     = "zrntoukeihknsyruikbn";
    public static final String ZRNHHKNNEN2KETA          = "zrnhhknnen2keta";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHJYKKTKBN             = "zrnhjykktkbn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNRYOURITUKBN           = "zrnryouritukbn";
    public static final String ZRNDAKUHIKTS             = "zrndakuhikts";
    public static final String ZRNKIHONS                = "zrnkihons";
    public static final String ZRNHHKNDAISANSYAKYKKBN   = "zrnhhkndaisansyakykkbn";
    public static final String ZRNDAINISENTAKUINFOKAKJKKBN = "zrndainisentakuinfokakjkkbn";
    public static final String ZRNMUSYMD                = "zrnmusymd";
    public static final String ZRNRYOUSYUUYMD           = "zrnryousyuuymd";
    public static final String ZRNKOKUTIYMD             = "zrnkokutiymd";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNSEIKEIRENRAKUYMD      = "zrnseikeirenrakuymd";
    public static final String ZRNNYKNNYUURYOKUYMD      = "zrnnyknnyuuryokuymd";
    public static final String ZRNSISYAKETNYUURYOKUYMD  = "zrnsisyaketnyuuryokuymd";
    public static final String ZRNKYKKAKIRAIYMD         = "zrnkykkakiraiymd";
    public static final String ZRNKEIYAKUKAKUNINSYURUIKBN = "zrnkeiyakukakuninsyuruikbn";
    public static final String ZRNSITEIDAIRIKBN2        = "zrnsiteidairikbn2";
    public static final String ZRNKYKKAKJKKBN1          = "zrnkykkakjkkbn1";
    public static final String ZRNKYKKAKKANRYOUYMD      = "zrnkykkakkanryouymd";
    public static final String ZRNKYKKAKKETYMD          = "zrnkykkakketymd";
    public static final String ZRNKYKKAKKETKEKKAKBN     = "zrnkykkakketkekkakbn";
    public static final String ZRNKYKKAKTANTOUKOJINCD   = "zrnkykkaktantoukojincd";
    public static final String ZRNKETSYACD              = "zrnketsyacd";
    public static final String ZRNSYOSAKUSEIYMD         = "zrnsyosakuseiymd";
    public static final String ZRNSEISEKIYM             = "zrnseisekiym";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNSYOKAIHARAIKOMIP      = "zrnsyokaiharaikomip";
    public static final String ZRNMOSSYOSAKUSEIYMD      = "zrnmossyosakuseiymd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX1 = "zrndakuhiketteiriyuucdx1";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX2 = "zrndakuhiketteiriyuucdx2";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX3 = "zrndakuhiketteiriyuucdx3";
    public static final String ZRNDAKUHIKETTEIRIYUUCDX4 = "zrndakuhiketteiriyuucdx4";
    public static final String ZRNHENKOUTEISEISYORIKAISUU = "zrnhenkouteiseisyorikaisuu";
    public static final String ZRNSYOSISYATODOKEKIBOUHYJ = "zrnsyosisyatodokekibouhyj";
    public static final String ZRNHNDKETKAISUU          = "zrnhndketkaisuu";
    public static final String ZRNDAKUHIKETKEIIKEKKACD1 = "zrndakuhiketkeiikekkacd1";
    public static final String ZRNDAKUHIKETKEIIKETMD1   = "zrndakuhiketkeiiketmd1";
    public static final String ZRNDAKUHIKETKEIIKEKKACD2 = "zrndakuhiketkeiikekkacd2";
    public static final String ZRNDAKUHIKETKEIIKETMD2   = "zrndakuhiketkeiiketmd2";
    public static final String ZRNDAKUHIKETKEIIKEKKACD3 = "zrndakuhiketkeiikekkacd3";
    public static final String ZRNDAKUHIKETKEIIKETMD3   = "zrndakuhiketkeiiketmd3";
    public static final String ZRNDAKUHIKETKEIIKEKKACD4 = "zrndakuhiketkeiikekkacd4";
    public static final String ZRNDAKUHIKETKEIIKETMD4   = "zrndakuhiketkeiiketmd4";
    public static final String ZRNDAKUHIKETKEIIKEKKACD5 = "zrndakuhiketkeiikekkacd5";
    public static final String ZRNDAKUHIKETKEIIKETMD5   = "zrndakuhiketkeiiketmd5";
    public static final String ZRNDAKUHIKETKEIIKEKKACD6 = "zrndakuhiketkeiikekkacd6";
    public static final String ZRNDAKUHIKETKEIIKETMD6   = "zrndakuhiketkeiiketmd6";
    public static final String ZRNKOJINCD               = "zrnkojincd";
    public static final String ZRNSYOKAIPNYUUKINHOUHOUKBN = "zrnsyokaipnyuukinhouhoukbn";
    public static final String ZRNSENTAKUINFOUMUHYJ     = "zrnsentakuinfoumuhyj";
    public static final String ZRNHAITOUSIHARAIKBN      = "zrnhaitousiharaikbn";
    public static final String ZRNHONSYATKKOHOJYUNHSYS  = "zrnhonsyatkkohojyunhsys";
    public static final String ZRNTOUKEIYOUSINSAKBN     = "zrntoukeiyousinsakbn";
    public static final String ZRNSKNNKAISIYMD          = "zrnsknnkaisiymd";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNHHKNSYNENSYUUKBN      = "zrnhhknsynensyuukbn";
    public static final String ZRNTOKUSYUJIMUTORIATUKAIKBN = "zrntokusyujimutoriatukaikbn";
    public static final String ZRNINPUTMISSTEISEIKAISUU = "zrninputmissteiseikaisuu";
    public static final String ZRNKJKYKNM               = "zrnkjkyknm";
    public static final String ZRNKNJHHKNMEI            = "zrnknjhhknmei";
    public static final String ZRNHONNINKKNNKBN         = "zrnhonninkknnkbn";
    public static final String ZRNNYKNZUMIHYOUJI        = "zrnnyknzumihyouji";
    public static final String ZRNHHKNSYKGYCD           = "zrnhhknsykgycd";
    public static final String ZRNNYKNJKKBN             = "zrnnyknjkkbn";
    public static final String ZRNBATUKAISYAKOJINCD     = "zrnbatukaisyakojincd";
    public static final String ZRNSINFSTPNYKNHOUHOUKBN  = "zrnsinfstpnyknhouhoukbn";
    public static final String ZRNMOSTORIKESIKBN        = "zrnmostorikesikbn";
    public static final String ZRNMOSTRKSSYOUSAIRIYUUKBN = "zrnmostrkssyousairiyuukbn";
    public static final String ZRNMOSSAKUSEINO          = "zrnmossakuseino";
    public static final String ZRNSIBOUS                = "zrnsibous";
    public static final String ZRNHARAIKOMIP            = "zrnharaikomip";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNKYKNM                 = "zrnkyknm";
    public static final String ZRNKYKTDKKBN             = "zrnkyktdkkbn";
    public static final String ZRNKYKSYANEN             = "zrnkyksyanen";
    public static final String ZRNKYKSYASEIKBN          = "zrnkyksyaseikbn";
    public static final String ZRNMOSJIHONNINKKNNKBN    = "zrnmosjihonninkknnkbn";
    public static final String ZRNHHKNMEI               = "zrnhhknmei";
    public static final String ZRNSBUKTKBN              = "zrnsbuktkbn";
    public static final String ZRNKJSBUKTNM             = "zrnkjsbuktnm";
    public static final String ZRNSBUKTNM               = "zrnsbuktnm";
    public static final String ZRNSBUKTSEIYMD           = "zrnsbuktseiymd";
    public static final String ZRNSBUKTTDKKBN           = "zrnsbukttdkkbn";
    public static final String ZRNKJSITEIDAIRININNM     = "zrnkjsiteidairininnm";
    public static final String ZRNSITEIDAIRININNM       = "zrnsiteidairininnm";
    public static final String ZRNFATCAKAKKEKKAKBN      = "zrnfatcakakkekkakbn";
    public static final String ZRNFATCAMOSJIKAKKOKUSEKIKBN = "zrnfatcamosjikakkokusekikbn";
    public static final String ZRNFATCATORJIKAKKOKUSEKIKBN = "zrnfatcatorjikakkokusekikbn";
    public static final String ZRNKZKAKIRAIKBN          = "zrnkzkakiraikbn";
    public static final String ZRNKZKAKIRAIYMD          = "zrnkzkakiraiymd";
    public static final String ZRNBANKYOHURIKZHYOUJI    = "zrnbankyohurikzhyouji";
    public static final String ZRNKZMEIGIKAKUNINZUMIKBN = "zrnkzmeigikakuninzumikbn";
    public static final String ZRNZNNKAI                = "zrnznnkai";
    public static final String ZRNKZKTRKSERVICEKBN      = "zrnkzktrkservicekbn";
    public static final String ZRNKYKDRKBN              = "zrnkykdrkbn";
    public static final String ZRNKJKYKDAIRINM          = "zrnkjkykdairinm";
    public static final String ZRNKYKDAIRINM            = "zrnkykdairinm";
    public static final String ZRNTRKKZKTDK1KETA1       = "zrntrkkzktdk1keta1";
    public static final String ZRNKJKZKTOUROKUNM1       = "zrnkjkzktourokunm1";
    public static final String ZRNKZKTOUROKUNM1         = "zrnkzktourokunm1";
    public static final String ZRNTRKKZKTDK2KETA1       = "zrntrkkzktdk2keta1";
    public static final String ZRNKJKZKTOUROKUNM2       = "zrnkjkzktourokunm2";
    public static final String ZRNKZKTOUROKUNM2         = "zrnkzktourokunm2";
    public static final String ZRNYAKKANJYURYOUHOUKBN   = "zrnyakkanjyuryouhoukbn";
    public static final String ZRNYAKKANBUNSYONO        = "zrnyakkanbunsyono";
    public static final String ZRNKZKTUUTITYOKUSOUKBN   = "zrnkzktuutityokusoukbn";
    public static final String ZRNYOBIV250              = "zrnyobiv250";
    public static final String ZRNYOBIV27               = "zrnyobiv27";

    private final PKZT_HonsyaToukeiRn primaryKey;

    public GenZT_HonsyaToukeiRn() {
        primaryKey = new PKZT_HonsyaToukeiRn();
    }

    public GenZT_HonsyaToukeiRn(String pZrnkijyunym, String pZrnmosno) {
        primaryKey = new PKZT_HonsyaToukeiRn(pZrnkijyunym, pZrnmosno);
    }

    @Transient
    @Override
    public PKZT_HonsyaToukeiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HonsyaToukeiRn> getMetaClass() {
        return QZT_HonsyaToukeiRn.class;
    }

    @Id
    @Column(name=GenZT_HonsyaToukeiRn.ZRNKIJYUNYM)
    public String getZrnkijyunym() {
        return getPrimaryKey().getZrnkijyunym();
    }

    public void setZrnkijyunym(String pZrnkijyunym) {
        getPrimaryKey().setZrnkijyunym(pZrnkijyunym);
    }

    private String zrnmosym;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNMOSYM)
    public String getZrnmosym() {
        return zrnmosym;
    }

    public void setZrnmosym(String pZrnmosym) {
        zrnmosym = pZrnmosym;
    }

    @Id
    @Column(name=GenZT_HonsyaToukeiRn.ZRNMOSNO)
    public String getZrnmosno() {
        return getPrimaryKey().getZrnmosno();
    }

    public void setZrnmosno(String pZrnmosno) {
        getPrimaryKey().setZrnmosno(pZrnmosno);
    }

    private String zrnsosikicd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSOSIKICD)
    public String getZrnsosikicd() {
        return zrnsosikicd;
    }

    public void setZrnsosikicd(String pZrnsosikicd) {
        zrnsosikicd = pZrnsosikicd;
    }

    private String zrnmossyoumetukbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNMOSSYOUMETUKBN)
    public String getZrnmossyoumetukbn() {
        return zrnmossyoumetukbn;
    }

    public void setZrnmossyoumetukbn(String pZrnmossyoumetukbn) {
        zrnmossyoumetukbn = pZrnmossyoumetukbn;
    }

    private String zrnmossyumtkktymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNMOSSYUMTKKTYMD)
    public String getZrnmossyumtkktymd() {
        return zrnmossyumtkktymd;
    }

    public void setZrnmossyumtkktymd(String pZrnmossyumtkktymd) {
        zrnmossyumtkktymd = pZrnmossyumtkktymd;
    }

    private String zrnrenseihhknkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNRENSEIHHKNKBN)
    public String getZrnrenseihhknkbn() {
        return zrnrenseihhknkbn;
    }

    public void setZrnrenseihhknkbn(String pZrnrenseihhknkbn) {
        zrnrenseihhknkbn = pZrnrenseihhknkbn;
    }

    private String zrndakuhikettikekkacd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETTIKEKKACD)
    public String getZrndakuhikettikekkacd() {
        return zrndakuhikettikekkacd;
    }

    public void setZrndakuhikettikekkacd(String pZrndakuhikettikekkacd) {
        zrndakuhikettikekkacd = pZrndakuhikettikekkacd;
    }

    private String zrndkhktiymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDKHKTIYMD)
    public String getZrndkhktiymd() {
        return zrndkhktiymd;
    }

    public void setZrndkhktiymd(String pZrndkhktiymd) {
        zrndkhktiymd = pZrndkhktiymd;
    }

    private String zrnketkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKETKBN)
    public String getZrnketkbn() {
        return zrnketkbn;
    }

    public void setZrnketkbn(String pZrnketkbn) {
        zrnketkbn = pZrnketkbn;
    }

    private String zrntoukeihknsyruikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNTOUKEIHKNSYRUIKBN)
    public String getZrntoukeihknsyruikbn() {
        return zrntoukeihknsyruikbn;
    }

    public void setZrntoukeihknsyruikbn(String pZrntoukeihknsyruikbn) {
        zrntoukeihknsyruikbn = pZrntoukeihknsyruikbn;
    }

    private String zrnhhknnen2keta;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHHKNNEN2KETA)
    public String getZrnhhknnen2keta() {
        return zrnhhknnen2keta;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2keta(String pZrnhhknnen2keta) {
        zrnhhknnen2keta = pZrnhhknnen2keta;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhjykktkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHJYKKTKBN)
    public String getZrnhjykktkbn() {
        return zrnhjykktkbn;
    }

    public void setZrnhjykktkbn(String pZrnhjykktkbn) {
        zrnhjykktkbn = pZrnhjykktkbn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnryouritukbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNRYOURITUKBN)
    public String getZrnryouritukbn() {
        return zrnryouritukbn;
    }

    public void setZrnryouritukbn(String pZrnryouritukbn) {
        zrnryouritukbn = pZrnryouritukbn;
    }

    private Long zrndakuhikts;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKTS)
    public Long getZrndakuhikts() {
        return zrndakuhikts;
    }

    public void setZrndakuhikts(Long pZrndakuhikts) {
        zrndakuhikts = pZrndakuhikts;
    }

    private Long zrnkihons;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKIHONS)
    public Long getZrnkihons() {
        return zrnkihons;
    }

    public void setZrnkihons(Long pZrnkihons) {
        zrnkihons = pZrnkihons;
    }

    private String zrnhhkndaisansyakykkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHHKNDAISANSYAKYKKBN)
    public String getZrnhhkndaisansyakykkbn() {
        return zrnhhkndaisansyakykkbn;
    }

    public void setZrnhhkndaisansyakykkbn(String pZrnhhkndaisansyakykkbn) {
        zrnhhkndaisansyakykkbn = pZrnhhkndaisansyakykkbn;
    }

    private String zrndainisentakuinfokakjkkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAINISENTAKUINFOKAKJKKBN)
    public String getZrndainisentakuinfokakjkkbn() {
        return zrndainisentakuinfokakjkkbn;
    }

    public void setZrndainisentakuinfokakjkkbn(String pZrndainisentakuinfokakjkkbn) {
        zrndainisentakuinfokakjkkbn = pZrndainisentakuinfokakjkkbn;
    }

    private String zrnmusymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNMUSYMD)
    public String getZrnmusymd() {
        return zrnmusymd;
    }

    public void setZrnmusymd(String pZrnmusymd) {
        zrnmusymd = pZrnmusymd;
    }

    private String zrnryousyuuymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNRYOUSYUUYMD)
    public String getZrnryousyuuymd() {
        return zrnryousyuuymd;
    }

    public void setZrnryousyuuymd(String pZrnryousyuuymd) {
        zrnryousyuuymd = pZrnryousyuuymd;
    }

    private String zrnkokutiymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKOKUTIYMD)
    public String getZrnkokutiymd() {
        return zrnkokutiymd;
    }

    public void setZrnkokutiymd(String pZrnkokutiymd) {
        zrnkokutiymd = pZrnkokutiymd;
    }

    private String zrnkykymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnseikeirenrakuymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSEIKEIRENRAKUYMD)
    public String getZrnseikeirenrakuymd() {
        return zrnseikeirenrakuymd;
    }

    public void setZrnseikeirenrakuymd(String pZrnseikeirenrakuymd) {
        zrnseikeirenrakuymd = pZrnseikeirenrakuymd;
    }

    private String zrnnyknnyuuryokuymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNNYKNNYUURYOKUYMD)
    public String getZrnnyknnyuuryokuymd() {
        return zrnnyknnyuuryokuymd;
    }

    public void setZrnnyknnyuuryokuymd(String pZrnnyknnyuuryokuymd) {
        zrnnyknnyuuryokuymd = pZrnnyknnyuuryokuymd;
    }

    private String zrnsisyaketnyuuryokuymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSISYAKETNYUURYOKUYMD)
    public String getZrnsisyaketnyuuryokuymd() {
        return zrnsisyaketnyuuryokuymd;
    }

    public void setZrnsisyaketnyuuryokuymd(String pZrnsisyaketnyuuryokuymd) {
        zrnsisyaketnyuuryokuymd = pZrnsisyaketnyuuryokuymd;
    }

    private String zrnkykkakiraiymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKKAKIRAIYMD)
    public String getZrnkykkakiraiymd() {
        return zrnkykkakiraiymd;
    }

    public void setZrnkykkakiraiymd(String pZrnkykkakiraiymd) {
        zrnkykkakiraiymd = pZrnkykkakiraiymd;
    }

    private String zrnkeiyakukakuninsyuruikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKEIYAKUKAKUNINSYURUIKBN)
    public String getZrnkeiyakukakuninsyuruikbn() {
        return zrnkeiyakukakuninsyuruikbn;
    }

    public void setZrnkeiyakukakuninsyuruikbn(String pZrnkeiyakukakuninsyuruikbn) {
        zrnkeiyakukakuninsyuruikbn = pZrnkeiyakukakuninsyuruikbn;
    }

    private String zrnsiteidairikbn2;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSITEIDAIRIKBN2)
    public String getZrnsiteidairikbn2() {
        return zrnsiteidairikbn2;
    }

    public void setZrnsiteidairikbn2(String pZrnsiteidairikbn2) {
        zrnsiteidairikbn2 = pZrnsiteidairikbn2;
    }

    private String zrnkykkakjkkbn1;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKKAKJKKBN1)
    public String getZrnkykkakjkkbn1() {
        return zrnkykkakjkkbn1;
    }

    public void setZrnkykkakjkkbn1(String pZrnkykkakjkkbn1) {
        zrnkykkakjkkbn1 = pZrnkykkakjkkbn1;
    }

    private String zrnkykkakkanryouymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKKAKKANRYOUYMD)
    public String getZrnkykkakkanryouymd() {
        return zrnkykkakkanryouymd;
    }

    public void setZrnkykkakkanryouymd(String pZrnkykkakkanryouymd) {
        zrnkykkakkanryouymd = pZrnkykkakkanryouymd;
    }

    private String zrnkykkakketymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKKAKKETYMD)
    public String getZrnkykkakketymd() {
        return zrnkykkakketymd;
    }

    public void setZrnkykkakketymd(String pZrnkykkakketymd) {
        zrnkykkakketymd = pZrnkykkakketymd;
    }

    private String zrnkykkakketkekkakbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKKAKKETKEKKAKBN)
    public String getZrnkykkakketkekkakbn() {
        return zrnkykkakketkekkakbn;
    }

    public void setZrnkykkakketkekkakbn(String pZrnkykkakketkekkakbn) {
        zrnkykkakketkekkakbn = pZrnkykkakketkekkakbn;
    }

    private String zrnkykkaktantoukojincd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKKAKTANTOUKOJINCD)
    public String getZrnkykkaktantoukojincd() {
        return zrnkykkaktantoukojincd;
    }

    public void setZrnkykkaktantoukojincd(String pZrnkykkaktantoukojincd) {
        zrnkykkaktantoukojincd = pZrnkykkaktantoukojincd;
    }

    private String zrnketsyacd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKETSYACD)
    public String getZrnketsyacd() {
        return zrnketsyacd;
    }

    public void setZrnketsyacd(String pZrnketsyacd) {
        zrnketsyacd = pZrnketsyacd;
    }

    private String zrnsyosakuseiymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSYOSAKUSEIYMD)
    public String getZrnsyosakuseiymd() {
        return zrnsyosakuseiymd;
    }

    public void setZrnsyosakuseiymd(String pZrnsyosakuseiymd) {
        zrnsyosakuseiymd = pZrnsyosakuseiymd;
    }

    private String zrnseisekiym;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSEISEKIYM)
    public String getZrnseisekiym() {
        return zrnseisekiym;
    }

    public void setZrnseisekiym(String pZrnseisekiym) {
        zrnseisekiym = pZrnseisekiym;
    }

    private String zrnbsyym;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private Long zrnsyokaiharaikomip;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSYOKAIHARAIKOMIP)
    public Long getZrnsyokaiharaikomip() {
        return zrnsyokaiharaikomip;
    }

    public void setZrnsyokaiharaikomip(Long pZrnsyokaiharaikomip) {
        zrnsyokaiharaikomip = pZrnsyokaiharaikomip;
    }

    private String zrnmossyosakuseiymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNMOSSYOSAKUSEIYMD)
    public String getZrnmossyosakuseiymd() {
        return zrnmossyosakuseiymd;
    }

    public void setZrnmossyosakuseiymd(String pZrnmossyosakuseiymd) {
        zrnmossyosakuseiymd = pZrnmossyosakuseiymd;
    }

    private String zrnsyono;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrndakuhiketteiriyuucdx1;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETTEIRIYUUCDX1)
    public String getZrndakuhiketteiriyuucdx1() {
        return zrndakuhiketteiriyuucdx1;
    }

    public void setZrndakuhiketteiriyuucdx1(String pZrndakuhiketteiriyuucdx1) {
        zrndakuhiketteiriyuucdx1 = pZrndakuhiketteiriyuucdx1;
    }

    private String zrndakuhiketteiriyuucdx2;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETTEIRIYUUCDX2)
    public String getZrndakuhiketteiriyuucdx2() {
        return zrndakuhiketteiriyuucdx2;
    }

    public void setZrndakuhiketteiriyuucdx2(String pZrndakuhiketteiriyuucdx2) {
        zrndakuhiketteiriyuucdx2 = pZrndakuhiketteiriyuucdx2;
    }

    private String zrndakuhiketteiriyuucdx3;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETTEIRIYUUCDX3)
    public String getZrndakuhiketteiriyuucdx3() {
        return zrndakuhiketteiriyuucdx3;
    }

    public void setZrndakuhiketteiriyuucdx3(String pZrndakuhiketteiriyuucdx3) {
        zrndakuhiketteiriyuucdx3 = pZrndakuhiketteiriyuucdx3;
    }

    private String zrndakuhiketteiriyuucdx4;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETTEIRIYUUCDX4)
    public String getZrndakuhiketteiriyuucdx4() {
        return zrndakuhiketteiriyuucdx4;
    }

    public void setZrndakuhiketteiriyuucdx4(String pZrndakuhiketteiriyuucdx4) {
        zrndakuhiketteiriyuucdx4 = pZrndakuhiketteiriyuucdx4;
    }

    private String zrnhenkouteiseisyorikaisuu;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHENKOUTEISEISYORIKAISUU)
    public String getZrnhenkouteiseisyorikaisuu() {
        return zrnhenkouteiseisyorikaisuu;
    }

    public void setZrnhenkouteiseisyorikaisuu(String pZrnhenkouteiseisyorikaisuu) {
        zrnhenkouteiseisyorikaisuu = pZrnhenkouteiseisyorikaisuu;
    }

    private String zrnsyosisyatodokekibouhyj;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSYOSISYATODOKEKIBOUHYJ)
    public String getZrnsyosisyatodokekibouhyj() {
        return zrnsyosisyatodokekibouhyj;
    }

    public void setZrnsyosisyatodokekibouhyj(String pZrnsyosisyatodokekibouhyj) {
        zrnsyosisyatodokekibouhyj = pZrnsyosisyatodokekibouhyj;
    }

    private String zrnhndketkaisuu;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHNDKETKAISUU)
    public String getZrnhndketkaisuu() {
        return zrnhndketkaisuu;
    }

    public void setZrnhndketkaisuu(String pZrnhndketkaisuu) {
        zrnhndketkaisuu = pZrnhndketkaisuu;
    }

    private String zrndakuhiketkeiikekkacd1;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKEKKACD1)
    public String getZrndakuhiketkeiikekkacd1() {
        return zrndakuhiketkeiikekkacd1;
    }

    public void setZrndakuhiketkeiikekkacd1(String pZrndakuhiketkeiikekkacd1) {
        zrndakuhiketkeiikekkacd1 = pZrndakuhiketkeiikekkacd1;
    }

    private String zrndakuhiketkeiiketmd1;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKETMD1)
    public String getZrndakuhiketkeiiketmd1() {
        return zrndakuhiketkeiiketmd1;
    }

    public void setZrndakuhiketkeiiketmd1(String pZrndakuhiketkeiiketmd1) {
        zrndakuhiketkeiiketmd1 = pZrndakuhiketkeiiketmd1;
    }

    private String zrndakuhiketkeiikekkacd2;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKEKKACD2)
    public String getZrndakuhiketkeiikekkacd2() {
        return zrndakuhiketkeiikekkacd2;
    }

    public void setZrndakuhiketkeiikekkacd2(String pZrndakuhiketkeiikekkacd2) {
        zrndakuhiketkeiikekkacd2 = pZrndakuhiketkeiikekkacd2;
    }

    private String zrndakuhiketkeiiketmd2;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKETMD2)
    public String getZrndakuhiketkeiiketmd2() {
        return zrndakuhiketkeiiketmd2;
    }

    public void setZrndakuhiketkeiiketmd2(String pZrndakuhiketkeiiketmd2) {
        zrndakuhiketkeiiketmd2 = pZrndakuhiketkeiiketmd2;
    }

    private String zrndakuhiketkeiikekkacd3;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKEKKACD3)
    public String getZrndakuhiketkeiikekkacd3() {
        return zrndakuhiketkeiikekkacd3;
    }

    public void setZrndakuhiketkeiikekkacd3(String pZrndakuhiketkeiikekkacd3) {
        zrndakuhiketkeiikekkacd3 = pZrndakuhiketkeiikekkacd3;
    }

    private String zrndakuhiketkeiiketmd3;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKETMD3)
    public String getZrndakuhiketkeiiketmd3() {
        return zrndakuhiketkeiiketmd3;
    }

    public void setZrndakuhiketkeiiketmd3(String pZrndakuhiketkeiiketmd3) {
        zrndakuhiketkeiiketmd3 = pZrndakuhiketkeiiketmd3;
    }

    private String zrndakuhiketkeiikekkacd4;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKEKKACD4)
    public String getZrndakuhiketkeiikekkacd4() {
        return zrndakuhiketkeiikekkacd4;
    }

    public void setZrndakuhiketkeiikekkacd4(String pZrndakuhiketkeiikekkacd4) {
        zrndakuhiketkeiikekkacd4 = pZrndakuhiketkeiikekkacd4;
    }

    private String zrndakuhiketkeiiketmd4;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKETMD4)
    public String getZrndakuhiketkeiiketmd4() {
        return zrndakuhiketkeiiketmd4;
    }

    public void setZrndakuhiketkeiiketmd4(String pZrndakuhiketkeiiketmd4) {
        zrndakuhiketkeiiketmd4 = pZrndakuhiketkeiiketmd4;
    }

    private String zrndakuhiketkeiikekkacd5;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKEKKACD5)
    public String getZrndakuhiketkeiikekkacd5() {
        return zrndakuhiketkeiikekkacd5;
    }

    public void setZrndakuhiketkeiikekkacd5(String pZrndakuhiketkeiikekkacd5) {
        zrndakuhiketkeiikekkacd5 = pZrndakuhiketkeiikekkacd5;
    }

    private String zrndakuhiketkeiiketmd5;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKETMD5)
    public String getZrndakuhiketkeiiketmd5() {
        return zrndakuhiketkeiiketmd5;
    }

    public void setZrndakuhiketkeiiketmd5(String pZrndakuhiketkeiiketmd5) {
        zrndakuhiketkeiiketmd5 = pZrndakuhiketkeiiketmd5;
    }

    private String zrndakuhiketkeiikekkacd6;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKEKKACD6)
    public String getZrndakuhiketkeiikekkacd6() {
        return zrndakuhiketkeiikekkacd6;
    }

    public void setZrndakuhiketkeiikekkacd6(String pZrndakuhiketkeiikekkacd6) {
        zrndakuhiketkeiikekkacd6 = pZrndakuhiketkeiikekkacd6;
    }

    private String zrndakuhiketkeiiketmd6;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNDAKUHIKETKEIIKETMD6)
    public String getZrndakuhiketkeiiketmd6() {
        return zrndakuhiketkeiiketmd6;
    }

    public void setZrndakuhiketkeiiketmd6(String pZrndakuhiketkeiiketmd6) {
        zrndakuhiketkeiiketmd6 = pZrndakuhiketkeiiketmd6;
    }

    private String zrnkojincd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKOJINCD)
    public String getZrnkojincd() {
        return zrnkojincd;
    }

    public void setZrnkojincd(String pZrnkojincd) {
        zrnkojincd = pZrnkojincd;
    }

    private String zrnsyokaipnyuukinhouhoukbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSYOKAIPNYUUKINHOUHOUKBN)
    public String getZrnsyokaipnyuukinhouhoukbn() {
        return zrnsyokaipnyuukinhouhoukbn;
    }

    public void setZrnsyokaipnyuukinhouhoukbn(String pZrnsyokaipnyuukinhouhoukbn) {
        zrnsyokaipnyuukinhouhoukbn = pZrnsyokaipnyuukinhouhoukbn;
    }

    private String zrnsentakuinfoumuhyj;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSENTAKUINFOUMUHYJ)
    public String getZrnsentakuinfoumuhyj() {
        return zrnsentakuinfoumuhyj;
    }

    public void setZrnsentakuinfoumuhyj(String pZrnsentakuinfoumuhyj) {
        zrnsentakuinfoumuhyj = pZrnsentakuinfoumuhyj;
    }

    private String zrnhaitousiharaikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHAITOUSIHARAIKBN)
    public String getZrnhaitousiharaikbn() {
        return zrnhaitousiharaikbn;
    }

    public void setZrnhaitousiharaikbn(String pZrnhaitousiharaikbn) {
        zrnhaitousiharaikbn = pZrnhaitousiharaikbn;
    }

    private Long zrnhonsyatkkohojyunhsys;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHONSYATKKOHOJYUNHSYS)
    public Long getZrnhonsyatkkohojyunhsys() {
        return zrnhonsyatkkohojyunhsys;
    }

    public void setZrnhonsyatkkohojyunhsys(Long pZrnhonsyatkkohojyunhsys) {
        zrnhonsyatkkohojyunhsys = pZrnhonsyatkkohojyunhsys;
    }

    private String zrntoukeiyousinsakbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNTOUKEIYOUSINSAKBN)
    public String getZrntoukeiyousinsakbn() {
        return zrntoukeiyousinsakbn;
    }

    public void setZrntoukeiyousinsakbn(String pZrntoukeiyousinsakbn) {
        zrntoukeiyousinsakbn = pZrntoukeiyousinsakbn;
    }

    private String zrnsknnkaisiymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSKNNKAISIYMD)
    public String getZrnsknnkaisiymd() {
        return zrnsknnkaisiymd;
    }

    public void setZrnsknnkaisiymd(String pZrnsknnkaisiymd) {
        zrnsknnkaisiymd = pZrnsknnkaisiymd;
    }

    private String zrnbsudirtnatkikeitaikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }

    private String zrnhhknsynensyuukbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHHKNSYNENSYUUKBN)
    public String getZrnhhknsynensyuukbn() {
        return zrnhhknsynensyuukbn;
    }

    public void setZrnhhknsynensyuukbn(String pZrnhhknsynensyuukbn) {
        zrnhhknsynensyuukbn = pZrnhhknsynensyuukbn;
    }

    private String zrntokusyujimutoriatukaikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNTOKUSYUJIMUTORIATUKAIKBN)
    public String getZrntokusyujimutoriatukaikbn() {
        return zrntokusyujimutoriatukaikbn;
    }

    public void setZrntokusyujimutoriatukaikbn(String pZrntokusyujimutoriatukaikbn) {
        zrntokusyujimutoriatukaikbn = pZrntokusyujimutoriatukaikbn;
    }

    private String zrninputmissteiseikaisuu;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNINPUTMISSTEISEIKAISUU)
    public String getZrninputmissteiseikaisuu() {
        return zrninputmissteiseikaisuu;
    }

    public void setZrninputmissteiseikaisuu(String pZrninputmissteiseikaisuu) {
        zrninputmissteiseikaisuu = pZrninputmissteiseikaisuu;
    }

    private String zrnkjkyknm;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKJKYKNM)
    public String getZrnkjkyknm() {
        return zrnkjkyknm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm(String pZrnkjkyknm) {
        zrnkjkyknm = pZrnkjkyknm;
    }

    private String zrnknjhhknmei;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKNJHHKNMEI)
    public String getZrnknjhhknmei() {
        return zrnknjhhknmei;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei(String pZrnknjhhknmei) {
        zrnknjhhknmei = pZrnknjhhknmei;
    }

    private String zrnhonninkknnkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHONNINKKNNKBN)
    public String getZrnhonninkknnkbn() {
        return zrnhonninkknnkbn;
    }

    public void setZrnhonninkknnkbn(String pZrnhonninkknnkbn) {
        zrnhonninkknnkbn = pZrnhonninkknnkbn;
    }

    private String zrnnyknzumihyouji;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNNYKNZUMIHYOUJI)
    public String getZrnnyknzumihyouji() {
        return zrnnyknzumihyouji;
    }

    public void setZrnnyknzumihyouji(String pZrnnyknzumihyouji) {
        zrnnyknzumihyouji = pZrnnyknzumihyouji;
    }

    private String zrnhhknsykgycd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHHKNSYKGYCD)
    public String getZrnhhknsykgycd() {
        return zrnhhknsykgycd;
    }

    public void setZrnhhknsykgycd(String pZrnhhknsykgycd) {
        zrnhhknsykgycd = pZrnhhknsykgycd;
    }

    private String zrnnyknjkkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNNYKNJKKBN)
    public String getZrnnyknjkkbn() {
        return zrnnyknjkkbn;
    }

    public void setZrnnyknjkkbn(String pZrnnyknjkkbn) {
        zrnnyknjkkbn = pZrnnyknjkkbn;
    }

    private String zrnbatukaisyakojincd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNBATUKAISYAKOJINCD)
    public String getZrnbatukaisyakojincd() {
        return zrnbatukaisyakojincd;
    }

    public void setZrnbatukaisyakojincd(String pZrnbatukaisyakojincd) {
        zrnbatukaisyakojincd = pZrnbatukaisyakojincd;
    }

    private String zrnsinfstpnyknhouhoukbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSINFSTPNYKNHOUHOUKBN)
    public String getZrnsinfstpnyknhouhoukbn() {
        return zrnsinfstpnyknhouhoukbn;
    }

    public void setZrnsinfstpnyknhouhoukbn(String pZrnsinfstpnyknhouhoukbn) {
        zrnsinfstpnyknhouhoukbn = pZrnsinfstpnyknhouhoukbn;
    }

    private String zrnmostorikesikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNMOSTORIKESIKBN)
    public String getZrnmostorikesikbn() {
        return zrnmostorikesikbn;
    }

    public void setZrnmostorikesikbn(String pZrnmostorikesikbn) {
        zrnmostorikesikbn = pZrnmostorikesikbn;
    }

    private String zrnmostrkssyousairiyuukbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNMOSTRKSSYOUSAIRIYUUKBN)
    public String getZrnmostrkssyousairiyuukbn() {
        return zrnmostrkssyousairiyuukbn;
    }

    public void setZrnmostrkssyousairiyuukbn(String pZrnmostrkssyousairiyuukbn) {
        zrnmostrkssyousairiyuukbn = pZrnmostrkssyousairiyuukbn;
    }

    private String zrnmossakuseino;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNMOSSAKUSEINO)
    public String getZrnmossakuseino() {
        return zrnmossakuseino;
    }

    public void setZrnmossakuseino(String pZrnmossakuseino) {
        zrnmossakuseino = pZrnmossakuseino;
    }

    private Long zrnsibous;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSIBOUS)
    public Long getZrnsibous() {
        return zrnsibous;
    }

    public void setZrnsibous(Long pZrnsibous) {
        zrnsibous = pZrnsibous;
    }

    private Long zrnharaikomip;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHARAIKOMIP)
    public Long getZrnharaikomip() {
        return zrnharaikomip;
    }

    public void setZrnharaikomip(Long pZrnharaikomip) {
        zrnharaikomip = pZrnharaikomip;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnkyknm;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKNM)
    public String getZrnkyknm() {
        return zrnkyknm;
    }

    public void setZrnkyknm(String pZrnkyknm) {
        zrnkyknm = pZrnkyknm;
    }

    private String zrnkyktdkkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKTDKKBN)
    public String getZrnkyktdkkbn() {
        return zrnkyktdkkbn;
    }

    public void setZrnkyktdkkbn(String pZrnkyktdkkbn) {
        zrnkyktdkkbn = pZrnkyktdkkbn;
    }

    private String zrnkyksyanen;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKSYANEN)
    public String getZrnkyksyanen() {
        return zrnkyksyanen;
    }

    public void setZrnkyksyanen(String pZrnkyksyanen) {
        zrnkyksyanen = pZrnkyksyanen;
    }

    private String zrnkyksyaseikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKSYASEIKBN)
    public String getZrnkyksyaseikbn() {
        return zrnkyksyaseikbn;
    }

    public void setZrnkyksyaseikbn(String pZrnkyksyaseikbn) {
        zrnkyksyaseikbn = pZrnkyksyaseikbn;
    }

    private String zrnmosjihonninkknnkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNMOSJIHONNINKKNNKBN)
    public String getZrnmosjihonninkknnkbn() {
        return zrnmosjihonninkknnkbn;
    }

    public void setZrnmosjihonninkknnkbn(String pZrnmosjihonninkknnkbn) {
        zrnmosjihonninkknnkbn = pZrnmosjihonninkknnkbn;
    }

    private String zrnhhknmei;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNHHKNMEI)
    public String getZrnhhknmei() {
        return zrnhhknmei;
    }

    public void setZrnhhknmei(String pZrnhhknmei) {
        zrnhhknmei = pZrnhhknmei;
    }

    private String zrnsbuktkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSBUKTKBN)
    public String getZrnsbuktkbn() {
        return zrnsbuktkbn;
    }

    public void setZrnsbuktkbn(String pZrnsbuktkbn) {
        zrnsbuktkbn = pZrnsbuktkbn;
    }

    private String zrnkjsbuktnm;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKJSBUKTNM)
    public String getZrnkjsbuktnm() {
        return zrnkjsbuktnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsbuktnm(String pZrnkjsbuktnm) {
        zrnkjsbuktnm = pZrnkjsbuktnm;
    }

    private String zrnsbuktnm;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSBUKTNM)
    public String getZrnsbuktnm() {
        return zrnsbuktnm;
    }

    public void setZrnsbuktnm(String pZrnsbuktnm) {
        zrnsbuktnm = pZrnsbuktnm;
    }

    private String zrnsbuktseiymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSBUKTSEIYMD)
    public String getZrnsbuktseiymd() {
        return zrnsbuktseiymd;
    }

    public void setZrnsbuktseiymd(String pZrnsbuktseiymd) {
        zrnsbuktseiymd = pZrnsbuktseiymd;
    }

    private String zrnsbukttdkkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSBUKTTDKKBN)
    public String getZrnsbukttdkkbn() {
        return zrnsbukttdkkbn;
    }

    public void setZrnsbukttdkkbn(String pZrnsbukttdkkbn) {
        zrnsbukttdkkbn = pZrnsbukttdkkbn;
    }

    private String zrnkjsiteidairininnm;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKJSITEIDAIRININNM)
    public String getZrnkjsiteidairininnm() {
        return zrnkjsiteidairininnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsiteidairininnm(String pZrnkjsiteidairininnm) {
        zrnkjsiteidairininnm = pZrnkjsiteidairininnm;
    }

    private String zrnsiteidairininnm;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNSITEIDAIRININNM)
    public String getZrnsiteidairininnm() {
        return zrnsiteidairininnm;
    }

    public void setZrnsiteidairininnm(String pZrnsiteidairininnm) {
        zrnsiteidairininnm = pZrnsiteidairininnm;
    }

    private String zrnfatcakakkekkakbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNFATCAKAKKEKKAKBN)
    public String getZrnfatcakakkekkakbn() {
        return zrnfatcakakkekkakbn;
    }

    public void setZrnfatcakakkekkakbn(String pZrnfatcakakkekkakbn) {
        zrnfatcakakkekkakbn = pZrnfatcakakkekkakbn;
    }

    private String zrnfatcamosjikakkokusekikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNFATCAMOSJIKAKKOKUSEKIKBN)
    public String getZrnfatcamosjikakkokusekikbn() {
        return zrnfatcamosjikakkokusekikbn;
    }

    public void setZrnfatcamosjikakkokusekikbn(String pZrnfatcamosjikakkokusekikbn) {
        zrnfatcamosjikakkokusekikbn = pZrnfatcamosjikakkokusekikbn;
    }

    private String zrnfatcatorjikakkokusekikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNFATCATORJIKAKKOKUSEKIKBN)
    public String getZrnfatcatorjikakkokusekikbn() {
        return zrnfatcatorjikakkokusekikbn;
    }

    public void setZrnfatcatorjikakkokusekikbn(String pZrnfatcatorjikakkokusekikbn) {
        zrnfatcatorjikakkokusekikbn = pZrnfatcatorjikakkokusekikbn;
    }

    private String zrnkzkakiraikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKZKAKIRAIKBN)
    public String getZrnkzkakiraikbn() {
        return zrnkzkakiraikbn;
    }

    public void setZrnkzkakiraikbn(String pZrnkzkakiraikbn) {
        zrnkzkakiraikbn = pZrnkzkakiraikbn;
    }

    private String zrnkzkakiraiymd;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKZKAKIRAIYMD)
    public String getZrnkzkakiraiymd() {
        return zrnkzkakiraiymd;
    }

    public void setZrnkzkakiraiymd(String pZrnkzkakiraiymd) {
        zrnkzkakiraiymd = pZrnkzkakiraiymd;
    }

    private String zrnbankyohurikzhyouji;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNBANKYOHURIKZHYOUJI)
    public String getZrnbankyohurikzhyouji() {
        return zrnbankyohurikzhyouji;
    }

    public void setZrnbankyohurikzhyouji(String pZrnbankyohurikzhyouji) {
        zrnbankyohurikzhyouji = pZrnbankyohurikzhyouji;
    }

    private String zrnkzmeigikakuninzumikbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKZMEIGIKAKUNINZUMIKBN)
    public String getZrnkzmeigikakuninzumikbn() {
        return zrnkzmeigikakuninzumikbn;
    }

    public void setZrnkzmeigikakuninzumikbn(String pZrnkzmeigikakuninzumikbn) {
        zrnkzmeigikakuninzumikbn = pZrnkzmeigikakuninzumikbn;
    }

    private String zrnznnkai;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNZNNKAI)
    public String getZrnznnkai() {
        return zrnznnkai;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnznnkai(String pZrnznnkai) {
        zrnznnkai = pZrnznnkai;
    }

    private String zrnkzktrkservicekbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKZKTRKSERVICEKBN)
    public String getZrnkzktrkservicekbn() {
        return zrnkzktrkservicekbn;
    }

    public void setZrnkzktrkservicekbn(String pZrnkzktrkservicekbn) {
        zrnkzktrkservicekbn = pZrnkzktrkservicekbn;
    }

    private String zrnkykdrkbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKDRKBN)
    public String getZrnkykdrkbn() {
        return zrnkykdrkbn;
    }

    public void setZrnkykdrkbn(String pZrnkykdrkbn) {
        zrnkykdrkbn = pZrnkykdrkbn;
    }

    private String zrnkjkykdairinm;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKJKYKDAIRINM)
    public String getZrnkjkykdairinm() {
        return zrnkjkykdairinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkykdairinm(String pZrnkjkykdairinm) {
        zrnkjkykdairinm = pZrnkjkykdairinm;
    }

    private String zrnkykdairinm;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKYKDAIRINM)
    public String getZrnkykdairinm() {
        return zrnkykdairinm;
    }

    public void setZrnkykdairinm(String pZrnkykdairinm) {
        zrnkykdairinm = pZrnkykdairinm;
    }

    private String zrntrkkzktdk1keta1;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNTRKKZKTDK1KETA1)
    public String getZrntrkkzktdk1keta1() {
        return zrntrkkzktdk1keta1;
    }

    public void setZrntrkkzktdk1keta1(String pZrntrkkzktdk1keta1) {
        zrntrkkzktdk1keta1 = pZrntrkkzktdk1keta1;
    }

    private String zrnkjkzktourokunm1;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKJKZKTOUROKUNM1)
    public String getZrnkjkzktourokunm1() {
        return zrnkjkzktourokunm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkzktourokunm1(String pZrnkjkzktourokunm1) {
        zrnkjkzktourokunm1 = pZrnkjkzktourokunm1;
    }

    private String zrnkzktourokunm1;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKZKTOUROKUNM1)
    public String getZrnkzktourokunm1() {
        return zrnkzktourokunm1;
    }

    public void setZrnkzktourokunm1(String pZrnkzktourokunm1) {
        zrnkzktourokunm1 = pZrnkzktourokunm1;
    }

    private String zrntrkkzktdk2keta1;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNTRKKZKTDK2KETA1)
    public String getZrntrkkzktdk2keta1() {
        return zrntrkkzktdk2keta1;
    }

    public void setZrntrkkzktdk2keta1(String pZrntrkkzktdk2keta1) {
        zrntrkkzktdk2keta1 = pZrntrkkzktdk2keta1;
    }

    private String zrnkjkzktourokunm2;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKJKZKTOUROKUNM2)
    public String getZrnkjkzktourokunm2() {
        return zrnkjkzktourokunm2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkzktourokunm2(String pZrnkjkzktourokunm2) {
        zrnkjkzktourokunm2 = pZrnkjkzktourokunm2;
    }

    private String zrnkzktourokunm2;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKZKTOUROKUNM2)
    public String getZrnkzktourokunm2() {
        return zrnkzktourokunm2;
    }

    public void setZrnkzktourokunm2(String pZrnkzktourokunm2) {
        zrnkzktourokunm2 = pZrnkzktourokunm2;
    }

    private String zrnyakkanjyuryouhoukbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNYAKKANJYURYOUHOUKBN)
    public String getZrnyakkanjyuryouhoukbn() {
        return zrnyakkanjyuryouhoukbn;
    }

    public void setZrnyakkanjyuryouhoukbn(String pZrnyakkanjyuryouhoukbn) {
        zrnyakkanjyuryouhoukbn = pZrnyakkanjyuryouhoukbn;
    }

    private String zrnyakkanbunsyono;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNYAKKANBUNSYONO)
    public String getZrnyakkanbunsyono() {
        return zrnyakkanbunsyono;
    }

    public void setZrnyakkanbunsyono(String pZrnyakkanbunsyono) {
        zrnyakkanbunsyono = pZrnyakkanbunsyono;
    }

    private String zrnkzktuutityokusoukbn;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNKZKTUUTITYOKUSOUKBN)
    public String getZrnkzktuutityokusoukbn() {
        return zrnkzktuutityokusoukbn;
    }

    public void setZrnkzktuutityokusoukbn(String pZrnkzktuutityokusoukbn) {
        zrnkzktuutityokusoukbn = pZrnkzktuutityokusoukbn;
    }

    private String zrnyobiv250;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNYOBIV250)
    public String getZrnyobiv250() {
        return zrnyobiv250;
    }

    public void setZrnyobiv250(String pZrnyobiv250) {
        zrnyobiv250 = pZrnyobiv250;
    }

    private String zrnyobiv27;

    @Column(name=GenZT_HonsyaToukeiRn.ZRNYOBIV27)
    public String getZrnyobiv27() {
        return zrnyobiv27;
    }

    public void setZrnyobiv27(String pZrnyobiv27) {
        zrnyobiv27 = pZrnyobiv27;
    }
}