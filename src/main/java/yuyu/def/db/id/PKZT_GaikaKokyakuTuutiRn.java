package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.mapping.GenZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.meta.GenQZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.meta.QZT_GaikaKokyakuTuutiRn;

/**
 * 外貨建顧客通知Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GaikaKokyakuTuutiRn}</td><td colspan="3">外貨建顧客通知Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsyoruicd</td><td>（連携用）書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsclatosyono</td><td>（連携用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn</td><td>（連携用）発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndskaiyktirasidouhuukbn</td><td>（連携用）ＤＳ解約チラシ同封区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrknkanssiryodouhuukbn</td><td>（連携用）返戻金請求勧奨資料同封区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnassistplustirasidhkbn</td><td>（連携用）アシストプラスチラシ同封区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkoktuutireportlayoutptn</td><td>（連携用）顧客通知帳票レイアウトパターン</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngengkumu</td><td>（連携用）減額有無</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkytkmkyobi1</td><td>（連携用）共通項目予備項目１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuusinsakiyuubinno</td><td>（連携用）通信先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsinadr1kj</td><td>（連携用）通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsinadr2kj</td><td>（連携用）通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsinadr3kj</td><td>（連携用）通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntsintelno</td><td>（連携用）通信先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsinnm18</td><td>（連携用）通信先氏名（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv19</td><td>（連携用）予備項目Ｖ１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoukaisakidrtennm1</td><td>（連携用）照会先代理店名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyoukaisakidrtennm2</td><td>（連携用）照会先代理店名２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv20</td><td>（連携用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaisatumsgcd1</td><td>（連携用）挨拶文メッセージコード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaisatumsgcd2</td><td>（連携用）挨拶文メッセージコード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaisatumsgcd3</td><td>（連携用）挨拶文メッセージコード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnosirasetuutisakuseiymwa</td><td>（連携用）お知らせ通知作成年月（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyono2</td><td>（連携用）証券番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnaisyoumeikbn</td><td>（連携用）愛称名区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj18</td><td>（連携用）契約者名（漢字）（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj18</td><td>（連携用）被保険者名（漢字）（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnuktmidasikbn1</td><td>（連携用）受取人見出し区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktkbn1</td><td>（連携用）受取人区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktnm118</td><td>（連携用）受取人名１（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnuktmidasikbn2</td><td>（連携用）受取人見出し区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktkbn2</td><td>（連携用）受取人区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktnm218</td><td>（連携用）受取人名２（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnuktmidasikbn3</td><td>（連携用）受取人見出し区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktkbn3</td><td>（連携用）受取人区分３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktnm318</td><td>（連携用）受取人名３（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnuktmidasikbn4</td><td>（連携用）受取人見出し区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktkbn4</td><td>（連携用）受取人区分４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktnm418</td><td>（連携用）受取人名４（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnuktmidasikbn5</td><td>（連携用）受取人見出し区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktkbn5</td><td>（連携用）受取人区分５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnuktnm518</td><td>（連携用）受取人名５（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykymdwa</td><td>（連携用）契約年月日（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1hknkknfromwa</td><td>（連携用）第１保険期間至（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai1hknkkn</td><td>（連携用）第１保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2hknkknfromwa</td><td>（連携用）第２保険期間自（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai2hknkkntowa</td><td>（連携用）第２保険期間至（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai3hknkknfromwa</td><td>（連携用）第３保険期間自（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai3hknkknto</td><td>（連携用）第３保険期間至</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyktuukasyuzn</td><td>（連携用）契約通貨種類（全）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyktuukatype</td><td>（連携用）契約通貨タイプ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntk1msgcd</td><td>（連携用）特約１メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntk2msgcd</td><td>（連携用）特約２メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntk3msgcd</td><td>（連携用）特約３メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntk4msgcd</td><td>（連携用）特約４メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntk5msgcd</td><td>（連携用）特約５メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntk6msgcd</td><td>（連携用）特約６メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntk7msgcd</td><td>（連携用）特約７メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntk8msgcd</td><td>（連携用）特約８メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntk9msgcd</td><td>（連携用）特約９メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntk10msgcd</td><td>（連携用）特約１０メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndstourokujyou</td><td>（連携用）ＤＳ登録状況</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsd1msgcd</td><td>（連携用）スミセイダイレクト１メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsd2msgcd</td><td>（連携用）スミセイダイレクト２メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsd3msgcd</td><td>（連携用）スミセイダイレクト３メッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkrpassword</td><td>（連携用）仮パスワード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyuukoukigenwareki</td><td>（連携用）有効期限（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzktrkjk</td><td>（連携用）家族登録状況</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzknm118</td><td>（連携用）登録家族名１（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntrkkzknm218</td><td>（連携用）登録家族名２（１８桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyendthnkymd</td><td>（連携用）円建変更日</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnkshrstartymdstr</td><td>（連携用）年金支払開始日（文字列）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnenkinstartnen</td><td>（連携用）年金開始年齢</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruinm</td><td>（連携用）年金種類名称</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuu</td><td>（連携用）払込回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntikiktbrisyuruikbn</td><td>（連携用）定期一括払種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennouumu</td><td>（連携用）前納有無</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeiro</td><td>（連携用）払込経路</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkkn</td><td>（連携用）保険料払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsueokikkn</td><td>（連携用）据置期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyakkanbunsyono</td><td>（連携用）約款文書番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngkykniyuosiraseyobi</td><td>（連携用）ご契約内容お知らせ予備項目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuseikijyunymdwa</td><td>（連携用）作成基準日（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnitijibrpkyktuuka</td><td>（連携用）一時払保険料（契約通貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihonsktuuka</td><td>（連携用）基本保険金額（契約通貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgk</td><td>（連携用）円貨払込額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstigituukahrkgk</td><td>（連携用）指定外通貨払込額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrktuukasyuzn</td><td>（連携用）払込通貨種類（全）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrktuukatype</td><td>（連携用）払込通貨タイプ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenkhrikmrate</td><td>（連携用）円貨払込特約レート</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstigikwsrate</td><td>（連携用）指定外通貨払込特約レート</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkgkhyoujikbn</td><td>（連携用）払込額表示区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkijyunkingaku</td><td>（連携用）基準金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjnkngkkawaserate</td><td>（連携用）基準金額為替レート</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjnkngkhyoujikbn</td><td>（連携用）基準金額表示区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuseikijyunymdkwsrate</td><td>（連携用）作成基準日時点為替レート</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbhknkngkhknkkn</td><td>（連携用）死亡保険金額保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbhknkngkhknkknfromwa</td><td>（連携用）死亡保険金額保険期間自（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsbhknkngkhknkkntowa</td><td>（連携用）死亡保険金額保険期間至（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsbhknkngkkyktuuka</td><td>（連携用）死亡保険金額（契約通貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbhknkngkyen</td><td>（連携用）死亡保険金額（円貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaigaisbhknkngakuumu</td><td>（連携用）災害死亡保険金額表示有無</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaigaisbhknkngakuktuuka</td><td>（連携用）災害死亡保険金額（契約通貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaigaisbhknkngakukyen</td><td>（連携用）災害死亡保険金額（円貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntumitatekngkktuuka</td><td>（連携用）保険料積立金額（契約通貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntumitatekngkkyen</td><td>（連携用）保険料積立金額（円貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiyakuhrkngakkyktuuka</td><td>（連携用）解約返戻金額（契約通貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiyakuhrkngakyen</td><td>（連携用）解約返戻金額（円貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmkhgkyen</td><td>（連携用）目標額（円貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmkhgkwari</td><td>（連携用）目標額割合</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnmkhgkhyoujikbn</td><td>（連携用）目標額表示区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouhskmsgcd1</td><td>（連携用）保障内容補足メッセージコード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouhskmsgcd2</td><td>（連携用）保障内容補足メッセージコード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouhskmsgcd3</td><td>（連携用）保障内容補足メッセージコード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouhskmsgcd4</td><td>（連携用）保障内容補足メッセージコード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouhskmsgcd5</td><td>（連携用）保障内容補足メッセージコード５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouhskmsgcd6</td><td>（連携用）保障内容補足メッセージコード６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouhskmsgcd7</td><td>（連携用）保障内容補足メッセージコード７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouhskmsgcd8</td><td>（連携用）保障内容補足メッセージコード８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyouhskmsgcd9</td><td>（連携用）保障内容補足メッセージコード９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihonsyen</td><td>（連携用）基本保険金額（円貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteirirituv4</td><td>（連携用）予定利率（４桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyendthnkhrkngakyen</td><td>（連携用）円建変更時返戻金額（円貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmtthaitoukinzndkyen</td><td>（連携用）積立配当金残高（円貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkgnsgkkyktuuka</td><td>（連携用）年金原資額（契約通貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsbhknkngkhyoujikbn</td><td>（連携用）死亡保険金額表示区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkijyunkingakukyktuuka</td><td>（連携用）基準金額（契約通貨）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkiktnkgk</td><td>（連携用）円貨払込額（一括入金額）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnzennoutikiktyenhrkgkkykj</td><td>（連携用）前納定期一括払円貨払込額（契約時）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiyakusiharaigk</td><td>（連携用）解約時支払額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiyakusiharaigkznnuzndk</td><td>（連携用）解約時支払額（前納残高）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaiyakusiharaigksntshrgk</td><td>（連携用）解約時支払額（その他支払金額）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukei</td><td>（連携用）円貨払込額の合計額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrritu</td><td>（連携用）返戻率</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkgnsyensyourai</td><td>（連携用）年金原資（円貨）（将来予想金額）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkgnsgaikasyourai</td><td>（連携用）年金原資（契約通貨）（将来予想金額）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenhrkgkgoukeisyourai</td><td>（連携用）円貨払込額の合計額（将来予想金額）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrritusyourai</td><td>（連携用）返戻率（将来予想金額）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkgnshskmsgcd1</td><td>（連携用）年金原資試算補足メッセージコード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkgnshskmsgcd2</td><td>（連携用）年金原資試算補足メッセージコード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkgnshskmsgcd3</td><td>（連携用）年金原資試算補足メッセージコード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkgnshskmsgcd4</td><td>（連携用）年金原資試算補足メッセージコード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkgnshskmsgcd5</td><td>（連携用）年金原資試算補足メッセージコード５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhosyounaiyouyobi</td><td>（連携用）保障内容予備項目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunymd1maewa</td><td>（連携用）為替レート基準日１ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateusdjpy1mae</td><td>（連携用）為替レート米ドル（円）１ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateaudjpy1mae</td><td>（連携用）為替レート豪ドル（円）１ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10</td><td>（連携用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunymd2maewa</td><td>（連携用）為替レート基準日２ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateusdjpy2mae</td><td>（連携用）為替レート米ドル（円）２ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateaudjpy2mae</td><td>（連携用）為替レート豪ドル（円）２ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x2</td><td>（連携用）予備項目Ｖ１０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunymd3maewa</td><td>（連携用）為替レート基準日３ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateusdjpy3mae</td><td>（連携用）為替レート米ドル（円）３ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateaudjpy3mae</td><td>（連携用）為替レート豪ドル（円）３ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x3</td><td>（連携用）予備項目Ｖ１０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunymd4maewa</td><td>（連携用）為替レート基準日４ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateusdjpy4mae</td><td>（連携用）為替レート米ドル（円）４ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateaudjpy4mae</td><td>（連携用）為替レート豪ドル（円）４ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x4</td><td>（連携用）予備項目Ｖ１０＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunymd5maewa</td><td>（連携用）為替レート基準日５ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateusdjpy5mae</td><td>（連携用）為替レート米ドル（円）５ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateaudjpy5mae</td><td>（連携用）為替レート豪ドル（円）５ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x5</td><td>（連携用）予備項目Ｖ１０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunymd6maewa</td><td>（連携用）為替レート基準日６ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateusdjpy6mae</td><td>（連携用）為替レート米ドル（円）６ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsrateaudjpy6mae</td><td>（連携用）為替レート豪ドル（円）６ヶ月前</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv10x6</td><td>（連携用）予備項目Ｖ１０＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratemsgcd</td><td>（連携用）為替レートメッセージコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv23</td><td>（連携用）予備項目Ｖ２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnosirasemsgcd1</td><td>（連携用）お知らせメッセージコード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnosirasemsgcd2</td><td>（連携用）お知らせメッセージコード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnosirasemsgcd3</td><td>（連携用）お知らせメッセージコード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnosirasemsgcd4</td><td>（連携用）お知らせメッセージコード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnosirasemsgcd5</td><td>（連携用）お知らせメッセージコード５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv15</td><td>（連携用）予備項目Ｖ１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsetteibairitustr</td><td>（連携用）設定倍率（文字列）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzkrtjygnstr</td><td>（連携用）積立金増加率上限（文字列）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzkrtkgnstr</td><td>（連携用）積立金増加率下限（文字列）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntumitateriritustr</td><td>（連携用）積立利率（文字列）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuunm</td><td>（連携用）指数名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx1</td><td>（連携用）積立金推移履歴区分＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix1</td><td>（連携用）契約応当日＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix1</td><td>（連携用）積立金状態＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax1</td><td>（連携用）保険料積立金額（契約通貨）＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx1</td><td>（連携用）保険料積立金額（円貨）＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux1</td><td>（連携用）指数＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux1</td><td>（連携用）指数上昇率符号＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux1</td><td>（連携用）指数上昇率＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx1</td><td>（連携用）積立金増加率（文字列）＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex1</td><td>（連携用）為替レート＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx2</td><td>（連携用）積立金推移履歴区分＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix2</td><td>（連携用）契約応当日＿２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix2</td><td>（連携用）積立金状態＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax2</td><td>（連携用）保険料積立金額（契約通貨）＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx2</td><td>（連携用）保険料積立金額（円貨）＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux2</td><td>（連携用）指数＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux2</td><td>（連携用）指数上昇率符号＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux2</td><td>（連携用）指数上昇率＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx2</td><td>（連携用）積立金増加率（文字列）＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex2</td><td>（連携用）為替レート＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx3</td><td>（連携用）積立金推移履歴区分＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix3</td><td>（連携用）契約応当日＿３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix3</td><td>（連携用）積立金状態＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax3</td><td>（連携用）保険料積立金額（契約通貨）＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx3</td><td>（連携用）保険料積立金額（円貨）＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux3</td><td>（連携用）指数＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux3</td><td>（連携用）指数上昇率符号＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux3</td><td>（連携用）指数上昇率＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx3</td><td>（連携用）積立金増加率（文字列）＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex3</td><td>（連携用）為替レート＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx4</td><td>（連携用）積立金推移履歴区分＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix4</td><td>（連携用）契約応当日＿４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix4</td><td>（連携用）積立金状態＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax4</td><td>（連携用）保険料積立金額（契約通貨）＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx4</td><td>（連携用）保険料積立金額（円貨）＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux4</td><td>（連携用）指数＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux4</td><td>（連携用）指数上昇率符号＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux4</td><td>（連携用）指数上昇率＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx4</td><td>（連携用）積立金増加率（文字列）＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex4</td><td>（連携用）為替レート＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx5</td><td>（連携用）積立金推移履歴区分＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix5</td><td>（連携用）契約応当日＿５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix5</td><td>（連携用）積立金状態＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax5</td><td>（連携用）保険料積立金額（契約通貨）＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx5</td><td>（連携用）保険料積立金額（円貨）＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux5</td><td>（連携用）指数＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux5</td><td>（連携用）指数上昇率符号＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux5</td><td>（連携用）指数上昇率＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx5</td><td>（連携用）積立金増加率（文字列）＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex5</td><td>（連携用）為替レート＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx6</td><td>（連携用）積立金推移履歴区分＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix6</td><td>（連携用）契約応当日＿６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix6</td><td>（連携用）積立金状態＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax6</td><td>（連携用）保険料積立金額（契約通貨）＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx6</td><td>（連携用）保険料積立金額（円貨）＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux6</td><td>（連携用）指数＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux6</td><td>（連携用）指数上昇率符号＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux6</td><td>（連携用）指数上昇率＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx6</td><td>（連携用）積立金増加率（文字列）＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex6</td><td>（連携用）為替レート＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx7</td><td>（連携用）積立金推移履歴区分＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix7</td><td>（連携用）契約応当日＿７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix7</td><td>（連携用）積立金状態＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax7</td><td>（連携用）保険料積立金額（契約通貨）＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx7</td><td>（連携用）保険料積立金額（円貨）＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux7</td><td>（連携用）指数＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux7</td><td>（連携用）指数上昇率符号＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux7</td><td>（連携用）指数上昇率＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx7</td><td>（連携用）積立金増加率（文字列）＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex7</td><td>（連携用）為替レート＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx8</td><td>（連携用）積立金推移履歴区分＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix8</td><td>（連携用）契約応当日＿８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix8</td><td>（連携用）積立金状態＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax8</td><td>（連携用）保険料積立金額（契約通貨）＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx8</td><td>（連携用）保険料積立金額（円貨）＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux8</td><td>（連携用）指数＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux8</td><td>（連携用）指数上昇率符号＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux8</td><td>（連携用）指数上昇率＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx8</td><td>（連携用）積立金増加率（文字列）＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex8</td><td>（連携用）為替レート＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx9</td><td>（連携用）積立金推移履歴区分＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix9</td><td>（連携用）契約応当日＿９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix9</td><td>（連携用）積立金状態＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax9</td><td>（連携用）保険料積立金額（契約通貨）＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx9</td><td>（連携用）保険料積立金額（円貨）＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux9</td><td>（連携用）指数＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux9</td><td>（連携用）指数上昇率符号＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux9</td><td>（連携用）指数上昇率＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx9</td><td>（連携用）積立金増加率（文字列）＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex9</td><td>（連携用）為替レート＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx10</td><td>（連携用）積立金推移履歴区分＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix10</td><td>（連携用）契約応当日＿１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix10</td><td>（連携用）積立金状態＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax10</td><td>（連携用）保険料積立金額（契約通貨）＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx10</td><td>（連携用）保険料積立金額（円貨）＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux10</td><td>（連携用）指数＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux10</td><td>（連携用）指数上昇率符号＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux10</td><td>（連携用）指数上昇率＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx10</td><td>（連携用）積立金増加率（文字列）＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex10</td><td>（連携用）為替レート＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiirirekikbnx11</td><td>（連携用）積立金推移履歴区分＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakuoutoubix11</td><td>（連携用）契約応当日＿１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntmttknjyoutaix11</td><td>（連携用）積立金状態＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkktuukax11</td><td>（連携用）保険料積立金額（契約通貨）＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnptumitatekngkyenx11</td><td>（連携用）保険料積立金額（円貨）＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuux11</td><td>（連携用）指数＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuuprituhugoux11</td><td>（連携用）指数上昇率符号＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisuuupritux11</td><td>（連携用）指数上昇率＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknzoukaritustrx11</td><td>（連携用）積立金増加率（文字列）＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkawaseratex11</td><td>（連携用）為替レート＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntmttknsuiiyobi</td><td>（連携用）積立金推移予備項目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdkkigen</td><td>（連携用）お手続き期限</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkrnkgnsgk</td><td>（連携用）仮年金原資額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntirtitnttdkyobi</td><td>（連携用）定率移転の手続き予備項目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskshozonnensuu</td><td>（連携用）請求書保存年数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndocumentid</td><td>（連携用）ドキュメントＩＤ</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoritugisyasyozokunm</td><td>（連携用）取次者所属名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyendthnkhrsksyobi</td><td>（連携用）円建変更時返戻金請求書予備項目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym1</td><td>（連携用）予定利率基準年月＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu1</td><td>（連携用）予定利率＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt1</td><td>（連携用）予定利率計算基準利率＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym1</td><td>（連携用）為替レート基準年月＿１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate1</td><td>（連携用）換算為替レート＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika1</td><td>（連携用）保険料（契約通貨）＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen1</td><td>（連携用）保険料（円貨）＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym2</td><td>（連携用）予定利率基準年月＿２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu2</td><td>（連携用）予定利率＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt2</td><td>（連携用）予定利率計算基準利率＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym2</td><td>（連携用）為替レート基準年月＿２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate2</td><td>（連携用）換算為替レート＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika2</td><td>（連携用）保険料（契約通貨）＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen2</td><td>（連携用）保険料（円貨）＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym3</td><td>（連携用）予定利率基準年月＿３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu3</td><td>（連携用）予定利率＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt3</td><td>（連携用）予定利率計算基準利率＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym3</td><td>（連携用）為替レート基準年月＿３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate3</td><td>（連携用）換算為替レート＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika3</td><td>（連携用）保険料（契約通貨）＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen3</td><td>（連携用）保険料（円貨）＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym4</td><td>（連携用）予定利率基準年月＿４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu4</td><td>（連携用）予定利率＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt4</td><td>（連携用）予定利率計算基準利率＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym4</td><td>（連携用）為替レート基準年月＿４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate4</td><td>（連携用）換算為替レート＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika4</td><td>（連携用）保険料（契約通貨）＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen4</td><td>（連携用）保険料（円貨）＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym5</td><td>（連携用）予定利率基準年月＿５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu5</td><td>（連携用）予定利率＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt5</td><td>（連携用）予定利率計算基準利率＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym5</td><td>（連携用）為替レート基準年月＿５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate5</td><td>（連携用）換算為替レート＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika5</td><td>（連携用）保険料（契約通貨）＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen5</td><td>（連携用）保険料（円貨）＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym6</td><td>（連携用）予定利率基準年月＿６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu6</td><td>（連携用）予定利率＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt6</td><td>（連携用）予定利率計算基準利率＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym6</td><td>（連携用）為替レート基準年月＿６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate6</td><td>（連携用）換算為替レート＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika6</td><td>（連携用）保険料（契約通貨）＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen6</td><td>（連携用）保険料（円貨）＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym7</td><td>（連携用）予定利率基準年月＿７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu7</td><td>（連携用）予定利率＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt7</td><td>（連携用）予定利率計算基準利率＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym7</td><td>（連携用）為替レート基準年月＿７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate7</td><td>（連携用）換算為替レート＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika7</td><td>（連携用）保険料（契約通貨）＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen7</td><td>（連携用）保険料（円貨）＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym8</td><td>（連携用）予定利率基準年月＿８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu8</td><td>（連携用）予定利率＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt8</td><td>（連携用）予定利率計算基準利率＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym8</td><td>（連携用）為替レート基準年月＿８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate8</td><td>（連携用）換算為替レート＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika8</td><td>（連携用）保険料（契約通貨）＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen8</td><td>（連携用）保険料（円貨）＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym9</td><td>（連携用）予定利率基準年月＿９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu9</td><td>（連携用）予定利率＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt9</td><td>（連携用）予定利率計算基準利率＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym9</td><td>（連携用）為替レート基準年月＿９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate9</td><td>（連携用）換算為替レート＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika9</td><td>（連携用）保険料（契約通貨）＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen9</td><td>（連携用）保険料（円貨）＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym10</td><td>（連携用）予定利率基準年月＿１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu10</td><td>（連携用）予定利率＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt10</td><td>（連携用）予定利率計算基準利率＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym10</td><td>（連携用）為替レート基準年月＿１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate10</td><td>（連携用）換算為替レート＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika10</td><td>（連携用）保険料（契約通貨）＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen10</td><td>（連携用）保険料（円貨）＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym11</td><td>（連携用）予定利率基準年月＿１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu11</td><td>（連携用）予定利率＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt11</td><td>（連携用）予定利率計算基準利率＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym11</td><td>（連携用）為替レート基準年月＿１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate11</td><td>（連携用）換算為替レート＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika11</td><td>（連携用）保険料（契約通貨）＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen11</td><td>（連携用）保険料（円貨）＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritukijyunym12</td><td>（連携用）予定利率基準年月＿１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyoteiriritu12</td><td>（連携用）予定利率＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtcalckijyunrrt12</td><td>（連携用）予定利率計算基準利率＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkwsratekijyunym12</td><td>（連携用）為替レート基準年月＿１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkaknsnkwsrate12</td><td>（連携用）換算為替レート＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpgaika12</td><td>（連携用）保険料（契約通貨）＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpyen12</td><td>（連携用）保険料（円貨）＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn1</td><td>（連携用）初回保険料表示区分＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn2</td><td>（連携用）初回保険料表示区分＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn3</td><td>（連携用）初回保険料表示区分＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn4</td><td>（連携用）初回保険料表示区分＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn5</td><td>（連携用）初回保険料表示区分＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn6</td><td>（連携用）初回保険料表示区分＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn7</td><td>（連携用）初回保険料表示区分＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn8</td><td>（連携用）初回保険料表示区分＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn9</td><td>（連携用）初回保険料表示区分＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn10</td><td>（連携用）初回保険料表示区分＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn11</td><td>（連携用）初回保険料表示区分＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstphyoujikbn12</td><td>（連携用）初回保険料表示区分＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtitrnyobi2</td><td>（連携用）予定利率一覧予備項目２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtitrnhskmsgcd1</td><td>（連携用）予定利率一覧補足メッセージコード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtitrnhskmsgcd2</td><td>（連携用）予定利率一覧補足メッセージコード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtitrnhskmsgcd3</td><td>（連携用）予定利率一覧補足メッセージコード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtitrnhskmsgcd4</td><td>（連携用）予定利率一覧補足メッセージコード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtitrnhskmsgcd5</td><td>（連携用）予定利率一覧補足メッセージコード５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtitrnhskmsgcd6</td><td>（連携用）予定利率一覧補足メッセージコード６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtitrnhskmsgcd7</td><td>（連携用）予定利率一覧補足メッセージコード７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtitrnhskmsgcd8</td><td>（連携用）予定利率一覧補足メッセージコード８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnytirrtitrnyobi</td><td>（連携用）過去１年間の予定利率予備項目</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_GaikaKokyakuTuutiRn
 * @see     GenZT_GaikaKokyakuTuutiRn
 * @see     QZT_GaikaKokyakuTuutiRn
 * @see     GenQZT_GaikaKokyakuTuutiRn
 */
public class PKZT_GaikaKokyakuTuutiRn extends AbstractExDBPrimaryKey<ZT_GaikaKokyakuTuutiRn, PKZT_GaikaKokyakuTuutiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_GaikaKokyakuTuutiRn() {
    }

    public PKZT_GaikaKokyakuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_GaikaKokyakuTuutiRn> getEntityClass() {
        return ZT_GaikaKokyakuTuutiRn.class;
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

}