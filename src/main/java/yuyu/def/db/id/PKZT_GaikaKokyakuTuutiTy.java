package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.mapping.GenZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.meta.GenQZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.meta.QZT_GaikaKokyakuTuutiTy;

/**
 * 外貨建顧客通知Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GaikaKokyakuTuutiTy}</td><td colspan="3">外貨建顧客通知Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysclatosyono</td><td>（中継用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydskaiyktirasidouhuukbn</td><td>（中継用）ＤＳ解約チラシ同封区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrknkanssiryodouhuukbn</td><td>（中継用）返戻金請求勧奨資料同封区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyassistplustirasidhkbn</td><td>（中継用）アシストプラスチラシ同封区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykoktuutireportlayoutptn</td><td>（中継用）顧客通知帳票レイアウトパターン</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygengkumu</td><td>（中継用）減額有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykytkmkyobi1</td><td>（中継用）共通項目予備項目１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuusinsakiyuubinno</td><td>（中継用）通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinadr1kj</td><td>（中継用）通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinadr2kj</td><td>（中継用）通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinadr3kj</td><td>（中継用）通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsintelno</td><td>（中継用）通信先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsinnm18</td><td>（中継用）通信先氏名（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv19</td><td>（中継用）予備項目Ｖ１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoukaisakidrtennm1</td><td>（中継用）照会先代理店名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoukaisakidrtennm2</td><td>（中継用）照会先代理店名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv20</td><td>（中継用）予備項目Ｖ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisatumsgcd1</td><td>（中継用）挨拶文メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisatumsgcd2</td><td>（中継用）挨拶文メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisatumsgcd3</td><td>（中継用）挨拶文メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasetuutisakuseiymwa</td><td>（中継用）お知らせ通知作成年月（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono2</td><td>（中継用）証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisyoumeikbn</td><td>（中継用）愛称名区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj18</td><td>（中継用）契約者名（漢字）（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj18</td><td>（中継用）被保険者名（漢字）（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktmidasikbn1</td><td>（中継用）受取人見出し区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktkbn1</td><td>（中継用）受取人区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktnm118</td><td>（中継用）受取人名１（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktmidasikbn2</td><td>（中継用）受取人見出し区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktkbn2</td><td>（中継用）受取人区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktnm218</td><td>（中継用）受取人名２（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktmidasikbn3</td><td>（中継用）受取人見出し区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktkbn3</td><td>（中継用）受取人区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktnm318</td><td>（中継用）受取人名３（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktmidasikbn4</td><td>（中継用）受取人見出し区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktkbn4</td><td>（中継用）受取人区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktnm418</td><td>（中継用）受取人名４（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktmidasikbn5</td><td>（中継用）受取人見出し区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktkbn5</td><td>（中継用）受取人区分５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyuktnm518</td><td>（中継用）受取人名５（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymdwa</td><td>（中継用）契約年月日（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1hknkknfromwa</td><td>（中継用）第１保険期間至（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1hknkkn</td><td>（中継用）第１保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hknkknfromwa</td><td>（中継用）第２保険期間自（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2hknkkntowa</td><td>（中継用）第２保険期間至（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai3hknkknfromwa</td><td>（中継用）第３保険期間自（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai3hknkknto</td><td>（中継用）第３保険期間至</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyktuukasyuzn</td><td>（中継用）契約通貨種類（全）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyktuukatype</td><td>（中継用）契約通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytk1msgcd</td><td>（中継用）特約１メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytk2msgcd</td><td>（中継用）特約２メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytk3msgcd</td><td>（中継用）特約３メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytk4msgcd</td><td>（中継用）特約４メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytk5msgcd</td><td>（中継用）特約５メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytk6msgcd</td><td>（中継用）特約６メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytk7msgcd</td><td>（中継用）特約７メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytk8msgcd</td><td>（中継用）特約８メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytk9msgcd</td><td>（中継用）特約９メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytk10msgcd</td><td>（中継用）特約１０メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydstourokujyou</td><td>（中継用）ＤＳ登録状況</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysd1msgcd</td><td>（中継用）スミセイダイレクト１メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysd2msgcd</td><td>（中継用）スミセイダイレクト２メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysd3msgcd</td><td>（中継用）スミセイダイレクト３メッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykrpassword</td><td>（中継用）仮パスワード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyuukoukigenwareki</td><td>（中継用）有効期限（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktrkjk</td><td>（中継用）家族登録状況</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzknm118</td><td>（中継用）登録家族名１（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzknm218</td><td>（中継用）登録家族名２（１８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyendthnkymd</td><td>（中継用）円建変更日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkshrstartymdstr</td><td>（中継用）年金支払開始日（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkinstartnen</td><td>（中継用）年金開始年齢</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruinm</td><td>（中継用）年金種類名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuu</td><td>（中継用）払込回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytikiktbrisyuruikbn</td><td>（中継用）定期一括払種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennouumu</td><td>（中継用）前納有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeiro</td><td>（中継用）払込経路</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkkn</td><td>（中継用）保険料払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysueokikkn</td><td>（中継用）据置期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyakkanbunsyono</td><td>（中継用）約款文書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygkykniyuosiraseyobi</td><td>（中継用）ご契約内容お知らせ予備項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseikijyunymdwa</td><td>（中継用）作成基準日（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijibrpkyktuuka</td><td>（中継用）一時払保険料（契約通貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihonsktuuka</td><td>（中継用）基本保険金額（契約通貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgk</td><td>（中継用）円貨払込額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystigituukahrkgk</td><td>（中継用）指定外通貨払込額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrktuukasyuzn</td><td>（中継用）払込通貨種類（全）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrktuukatype</td><td>（中継用）払込通貨タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenkhrikmrate</td><td>（中継用）円貨払込特約レート</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystigikwsrate</td><td>（中継用）指定外通貨払込特約レート</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkgkhyoujikbn</td><td>（中継用）払込額表示区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykijyunkingaku</td><td>（中継用）基準金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjnkngkkawaserate</td><td>（中継用）基準金額為替レート</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjnkngkhyoujikbn</td><td>（中継用）基準金額表示区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseikijyunymdkwsrate</td><td>（中継用）作成基準日時点為替レート</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbhknkngkhknkkn</td><td>（中継用）死亡保険金額保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbhknkngkhknkknfromwa</td><td>（中継用）死亡保険金額保険期間自（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbhknkngkhknkkntowa</td><td>（中継用）死亡保険金額保険期間至（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbhknkngkkyktuuka</td><td>（中継用）死亡保険金額（契約通貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbhknkngkyen</td><td>（中継用）死亡保険金額（円貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaigaisbhknkngakuumu</td><td>（中継用）災害死亡保険金額表示有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaigaisbhknkngakuktuuka</td><td>（中継用）災害死亡保険金額（契約通貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaigaisbhknkngakukyen</td><td>（中継用）災害死亡保険金額（円貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytumitatekngkktuuka</td><td>（中継用）保険料積立金額（契約通貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytumitatekngkkyen</td><td>（中継用）保険料積立金額（円貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiyakuhrkngakkyktuuka</td><td>（中継用）解約返戻金額（契約通貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiyakuhrkngakyen</td><td>（中継用）解約返戻金額（円貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymkhgkyen</td><td>（中継用）目標額（円貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymkhgkwari</td><td>（中継用）目標額割合</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymkhgkhyoujikbn</td><td>（中継用）目標額表示区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouhskmsgcd1</td><td>（中継用）保障内容補足メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouhskmsgcd2</td><td>（中継用）保障内容補足メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouhskmsgcd3</td><td>（中継用）保障内容補足メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouhskmsgcd4</td><td>（中継用）保障内容補足メッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouhskmsgcd5</td><td>（中継用）保障内容補足メッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouhskmsgcd6</td><td>（中継用）保障内容補足メッセージコード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouhskmsgcd7</td><td>（中継用）保障内容補足メッセージコード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouhskmsgcd8</td><td>（中継用）保障内容補足メッセージコード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyouhskmsgcd9</td><td>（中継用）保障内容補足メッセージコード９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihonsyen</td><td>（中継用）基本保険金額（円貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteirirituv4</td><td>（中継用）予定利率（４桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyendthnkhrkngakyen</td><td>（中継用）円建変更時返戻金額（円貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmtthaitoukinzndkyen</td><td>（中継用）積立配当金残高（円貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkgnsgkkyktuuka</td><td>（中継用）年金原資額（契約通貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysbhknkngkhyoujikbn</td><td>（中継用）死亡保険金額表示区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykijyunkingakukyktuuka</td><td>（中継用）基準金額（契約通貨）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkiktnkgk</td><td>（中継用）円貨払込額（一括入金額）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoutikiktyenhrkgkkykj</td><td>（中継用）前納定期一括払円貨払込額（契約時）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiyakusiharaigk</td><td>（中継用）解約時支払額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiyakusiharaigkznnuzndk</td><td>（中継用）解約時支払額（前納残高）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaiyakusiharaigksntshrgk</td><td>（中継用）解約時支払額（その他支払金額）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukei</td><td>（中継用）円貨払込額の合計額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrritu</td><td>（中継用）返戻率</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkgnsyensyourai</td><td>（中継用）年金原資（円貨）（将来予想金額）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkgnsgaikasyourai</td><td>（中継用）年金原資（契約通貨）（将来予想金額）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenhrkgkgoukeisyourai</td><td>（中継用）円貨払込額の合計額（将来予想金額）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrritusyourai</td><td>（中継用）返戻率（将来予想金額）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkgnshskmsgcd1</td><td>（中継用）年金原資試算補足メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkgnshskmsgcd2</td><td>（中継用）年金原資試算補足メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkgnshskmsgcd3</td><td>（中継用）年金原資試算補足メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkgnshskmsgcd4</td><td>（中継用）年金原資試算補足メッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynkgnshskmsgcd5</td><td>（中継用）年金原資試算補足メッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhosyounaiyouyobi</td><td>（中継用）保障内容予備項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunymd1maewa</td><td>（中継用）為替レート基準日１ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateusdjpy1mae</td><td>（中継用）為替レート米ドル（円）１ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateaudjpy1mae</td><td>（中継用）為替レート豪ドル（円）１ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10</td><td>（中継用）予備項目Ｖ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunymd2maewa</td><td>（中継用）為替レート基準日２ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateusdjpy2mae</td><td>（中継用）為替レート米ドル（円）２ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateaudjpy2mae</td><td>（中継用）為替レート豪ドル（円）２ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x2</td><td>（中継用）予備項目Ｖ１０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunymd3maewa</td><td>（中継用）為替レート基準日３ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateusdjpy3mae</td><td>（中継用）為替レート米ドル（円）３ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateaudjpy3mae</td><td>（中継用）為替レート豪ドル（円）３ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x3</td><td>（中継用）予備項目Ｖ１０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunymd4maewa</td><td>（中継用）為替レート基準日４ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateusdjpy4mae</td><td>（中継用）為替レート米ドル（円）４ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateaudjpy4mae</td><td>（中継用）為替レート豪ドル（円）４ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x4</td><td>（中継用）予備項目Ｖ１０＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunymd5maewa</td><td>（中継用）為替レート基準日５ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateusdjpy5mae</td><td>（中継用）為替レート米ドル（円）５ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateaudjpy5mae</td><td>（中継用）為替レート豪ドル（円）５ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x5</td><td>（中継用）予備項目Ｖ１０＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunymd6maewa</td><td>（中継用）為替レート基準日６ヶ月前（和暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateusdjpy6mae</td><td>（中継用）為替レート米ドル（円）６ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsrateaudjpy6mae</td><td>（中継用）為替レート豪ドル（円）６ヶ月前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv10x6</td><td>（中継用）予備項目Ｖ１０＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratemsgcd</td><td>（中継用）為替レートメッセージコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv23</td><td>（中継用）予備項目Ｖ２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemsgcd1</td><td>（中継用）お知らせメッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemsgcd2</td><td>（中継用）お知らせメッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemsgcd3</td><td>（中継用）お知らせメッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemsgcd4</td><td>（中継用）お知らせメッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemsgcd5</td><td>（中継用）お知らせメッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv15</td><td>（中継用）予備項目Ｖ１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysetteibairitustr</td><td>（中継用）設定倍率（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzkrtjygnstr</td><td>（中継用）積立金増加率上限（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzkrtkgnstr</td><td>（中継用）積立金増加率下限（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytumitateriritustr</td><td>（中継用）積立利率（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuunm</td><td>（中継用）指数名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx1</td><td>（中継用）積立金推移履歴区分＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix1</td><td>（中継用）契約応当日＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix1</td><td>（中継用）積立金状態＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax1</td><td>（中継用）保険料積立金額（契約通貨）＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx1</td><td>（中継用）保険料積立金額（円貨）＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux1</td><td>（中継用）指数＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux1</td><td>（中継用）指数上昇率符号＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux1</td><td>（中継用）指数上昇率＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx1</td><td>（中継用）積立金増加率（文字列）＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex1</td><td>（中継用）為替レート＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx2</td><td>（中継用）積立金推移履歴区分＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix2</td><td>（中継用）契約応当日＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix2</td><td>（中継用）積立金状態＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax2</td><td>（中継用）保険料積立金額（契約通貨）＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx2</td><td>（中継用）保険料積立金額（円貨）＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux2</td><td>（中継用）指数＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux2</td><td>（中継用）指数上昇率符号＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux2</td><td>（中継用）指数上昇率＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx2</td><td>（中継用）積立金増加率（文字列）＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex2</td><td>（中継用）為替レート＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx3</td><td>（中継用）積立金推移履歴区分＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix3</td><td>（中継用）契約応当日＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix3</td><td>（中継用）積立金状態＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax3</td><td>（中継用）保険料積立金額（契約通貨）＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx3</td><td>（中継用）保険料積立金額（円貨）＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux3</td><td>（中継用）指数＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux3</td><td>（中継用）指数上昇率符号＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux3</td><td>（中継用）指数上昇率＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx3</td><td>（中継用）積立金増加率（文字列）＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex3</td><td>（中継用）為替レート＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx4</td><td>（中継用）積立金推移履歴区分＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix4</td><td>（中継用）契約応当日＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix4</td><td>（中継用）積立金状態＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax4</td><td>（中継用）保険料積立金額（契約通貨）＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx4</td><td>（中継用）保険料積立金額（円貨）＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux4</td><td>（中継用）指数＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux4</td><td>（中継用）指数上昇率符号＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux4</td><td>（中継用）指数上昇率＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx4</td><td>（中継用）積立金増加率（文字列）＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex4</td><td>（中継用）為替レート＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx5</td><td>（中継用）積立金推移履歴区分＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix5</td><td>（中継用）契約応当日＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix5</td><td>（中継用）積立金状態＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax5</td><td>（中継用）保険料積立金額（契約通貨）＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx5</td><td>（中継用）保険料積立金額（円貨）＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux5</td><td>（中継用）指数＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux5</td><td>（中継用）指数上昇率符号＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux5</td><td>（中継用）指数上昇率＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx5</td><td>（中継用）積立金増加率（文字列）＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex5</td><td>（中継用）為替レート＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx6</td><td>（中継用）積立金推移履歴区分＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix6</td><td>（中継用）契約応当日＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix6</td><td>（中継用）積立金状態＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax6</td><td>（中継用）保険料積立金額（契約通貨）＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx6</td><td>（中継用）保険料積立金額（円貨）＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux6</td><td>（中継用）指数＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux6</td><td>（中継用）指数上昇率符号＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux6</td><td>（中継用）指数上昇率＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx6</td><td>（中継用）積立金増加率（文字列）＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex6</td><td>（中継用）為替レート＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx7</td><td>（中継用）積立金推移履歴区分＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix7</td><td>（中継用）契約応当日＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix7</td><td>（中継用）積立金状態＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax7</td><td>（中継用）保険料積立金額（契約通貨）＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx7</td><td>（中継用）保険料積立金額（円貨）＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux7</td><td>（中継用）指数＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux7</td><td>（中継用）指数上昇率符号＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux7</td><td>（中継用）指数上昇率＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx7</td><td>（中継用）積立金増加率（文字列）＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex7</td><td>（中継用）為替レート＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx8</td><td>（中継用）積立金推移履歴区分＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix8</td><td>（中継用）契約応当日＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix8</td><td>（中継用）積立金状態＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax8</td><td>（中継用）保険料積立金額（契約通貨）＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx8</td><td>（中継用）保険料積立金額（円貨）＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux8</td><td>（中継用）指数＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux8</td><td>（中継用）指数上昇率符号＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux8</td><td>（中継用）指数上昇率＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx8</td><td>（中継用）積立金増加率（文字列）＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex8</td><td>（中継用）為替レート＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx9</td><td>（中継用）積立金推移履歴区分＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix9</td><td>（中継用）契約応当日＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix9</td><td>（中継用）積立金状態＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax9</td><td>（中継用）保険料積立金額（契約通貨）＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx9</td><td>（中継用）保険料積立金額（円貨）＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux9</td><td>（中継用）指数＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux9</td><td>（中継用）指数上昇率符号＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux9</td><td>（中継用）指数上昇率＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx9</td><td>（中継用）積立金増加率（文字列）＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex9</td><td>（中継用）為替レート＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx10</td><td>（中継用）積立金推移履歴区分＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix10</td><td>（中継用）契約応当日＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix10</td><td>（中継用）積立金状態＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax10</td><td>（中継用）保険料積立金額（契約通貨）＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx10</td><td>（中継用）保険料積立金額（円貨）＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux10</td><td>（中継用）指数＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux10</td><td>（中継用）指数上昇率符号＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux10</td><td>（中継用）指数上昇率＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx10</td><td>（中継用）積立金増加率（文字列）＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex10</td><td>（中継用）為替レート＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiirirekikbnx11</td><td>（中継用）積立金推移履歴区分＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakuoutoubix11</td><td>（中継用）契約応当日＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknjyoutaix11</td><td>（中継用）積立金状態＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkktuukax11</td><td>（中継用）保険料積立金額（契約通貨）＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyptumitatekngkyenx11</td><td>（中継用）保険料積立金額（円貨）＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuux11</td><td>（中継用）指数＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuuprituhugoux11</td><td>（中継用）指数上昇率符号＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisuuupritux11</td><td>（中継用）指数上昇率＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknzoukaritustrx11</td><td>（中継用）積立金増加率（文字列）＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykawaseratex11</td><td>（中継用）為替レート＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytmttknsuiiyobi</td><td>（中継用）積立金推移予備項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdkkigen</td><td>（中継用）お手続き期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykrnkgnsgk</td><td>（中継用）仮年金原資額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytirtitnttdkyobi</td><td>（中継用）定率移転の手続き予備項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskshozonnensuu</td><td>（中継用）請求書保存年数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydocumentid</td><td>（中継用）ドキュメントＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoritugisyasyozokunm</td><td>（中継用）取次者所属名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyendthnkhrsksyobi</td><td>（中継用）円建変更時返戻金請求書予備項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym1</td><td>（中継用）予定利率基準年月＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu1</td><td>（中継用）予定利率＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt1</td><td>（中継用）予定利率計算基準利率＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym1</td><td>（中継用）為替レート基準年月＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate1</td><td>（中継用）換算為替レート＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika1</td><td>（中継用）保険料（契約通貨）＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen1</td><td>（中継用）保険料（円貨）＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym2</td><td>（中継用）予定利率基準年月＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu2</td><td>（中継用）予定利率＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt2</td><td>（中継用）予定利率計算基準利率＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym2</td><td>（中継用）為替レート基準年月＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate2</td><td>（中継用）換算為替レート＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika2</td><td>（中継用）保険料（契約通貨）＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen2</td><td>（中継用）保険料（円貨）＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym3</td><td>（中継用）予定利率基準年月＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu3</td><td>（中継用）予定利率＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt3</td><td>（中継用）予定利率計算基準利率＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym3</td><td>（中継用）為替レート基準年月＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate3</td><td>（中継用）換算為替レート＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika3</td><td>（中継用）保険料（契約通貨）＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen3</td><td>（中継用）保険料（円貨）＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym4</td><td>（中継用）予定利率基準年月＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu4</td><td>（中継用）予定利率＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt4</td><td>（中継用）予定利率計算基準利率＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym4</td><td>（中継用）為替レート基準年月＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate4</td><td>（中継用）換算為替レート＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika4</td><td>（中継用）保険料（契約通貨）＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen4</td><td>（中継用）保険料（円貨）＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym5</td><td>（中継用）予定利率基準年月＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu5</td><td>（中継用）予定利率＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt5</td><td>（中継用）予定利率計算基準利率＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym5</td><td>（中継用）為替レート基準年月＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate5</td><td>（中継用）換算為替レート＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika5</td><td>（中継用）保険料（契約通貨）＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen5</td><td>（中継用）保険料（円貨）＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym6</td><td>（中継用）予定利率基準年月＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu6</td><td>（中継用）予定利率＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt6</td><td>（中継用）予定利率計算基準利率＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym6</td><td>（中継用）為替レート基準年月＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate6</td><td>（中継用）換算為替レート＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika6</td><td>（中継用）保険料（契約通貨）＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen6</td><td>（中継用）保険料（円貨）＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym7</td><td>（中継用）予定利率基準年月＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu7</td><td>（中継用）予定利率＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt7</td><td>（中継用）予定利率計算基準利率＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym7</td><td>（中継用）為替レート基準年月＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate7</td><td>（中継用）換算為替レート＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika7</td><td>（中継用）保険料（契約通貨）＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen7</td><td>（中継用）保険料（円貨）＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym8</td><td>（中継用）予定利率基準年月＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu8</td><td>（中継用）予定利率＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt8</td><td>（中継用）予定利率計算基準利率＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym8</td><td>（中継用）為替レート基準年月＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate8</td><td>（中継用）換算為替レート＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika8</td><td>（中継用）保険料（契約通貨）＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen8</td><td>（中継用）保険料（円貨）＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym9</td><td>（中継用）予定利率基準年月＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu9</td><td>（中継用）予定利率＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt9</td><td>（中継用）予定利率計算基準利率＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym9</td><td>（中継用）為替レート基準年月＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate9</td><td>（中継用）換算為替レート＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika9</td><td>（中継用）保険料（契約通貨）＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen9</td><td>（中継用）保険料（円貨）＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym10</td><td>（中継用）予定利率基準年月＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu10</td><td>（中継用）予定利率＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt10</td><td>（中継用）予定利率計算基準利率＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym10</td><td>（中継用）為替レート基準年月＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate10</td><td>（中継用）換算為替レート＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika10</td><td>（中継用）保険料（契約通貨）＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen10</td><td>（中継用）保険料（円貨）＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym11</td><td>（中継用）予定利率基準年月＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu11</td><td>（中継用）予定利率＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt11</td><td>（中継用）予定利率計算基準利率＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym11</td><td>（中継用）為替レート基準年月＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate11</td><td>（中継用）換算為替レート＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika11</td><td>（中継用）保険料（契約通貨）＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen11</td><td>（中継用）保険料（円貨）＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritukijyunym12</td><td>（中継用）予定利率基準年月＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyoteiriritu12</td><td>（中継用）予定利率＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtcalckijyunrrt12</td><td>（中継用）予定利率計算基準利率＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykwsratekijyunym12</td><td>（中継用）為替レート基準年月＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaknsnkwsrate12</td><td>（中継用）換算為替レート＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypgaika12</td><td>（中継用）保険料（契約通貨）＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypyen12</td><td>（中継用）保険料（円貨）＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn1</td><td>（中継用）初回保険料表示区分＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn2</td><td>（中継用）初回保険料表示区分＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn3</td><td>（中継用）初回保険料表示区分＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn4</td><td>（中継用）初回保険料表示区分＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn5</td><td>（中継用）初回保険料表示区分＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn6</td><td>（中継用）初回保険料表示区分＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn7</td><td>（中継用）初回保険料表示区分＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn8</td><td>（中継用）初回保険料表示区分＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn9</td><td>（中継用）初回保険料表示区分＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn10</td><td>（中継用）初回保険料表示区分＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn11</td><td>（中継用）初回保険料表示区分＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstphyoujikbn12</td><td>（中継用）初回保険料表示区分＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtitrnyobi2</td><td>（中継用）予定利率一覧予備項目２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>ztyytirrtitrnhskmsgcd1</td><td>（中継用）予定利率一覧補足メッセージコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtitrnhskmsgcd2</td><td>（中継用）予定利率一覧補足メッセージコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtitrnhskmsgcd3</td><td>（中継用）予定利率一覧補足メッセージコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtitrnhskmsgcd4</td><td>（中継用）予定利率一覧補足メッセージコード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtitrnhskmsgcd5</td><td>（中継用）予定利率一覧補足メッセージコード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtitrnhskmsgcd6</td><td>（中継用）予定利率一覧補足メッセージコード６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtitrnhskmsgcd7</td><td>（中継用）予定利率一覧補足メッセージコード７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtitrnhskmsgcd8</td><td>（中継用）予定利率一覧補足メッセージコード８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyytirrtitrnyobi</td><td>（中継用）過去１年間の予定利率予備項目</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_GaikaKokyakuTuutiTy
 * @see     GenZT_GaikaKokyakuTuutiTy
 * @see     QZT_GaikaKokyakuTuutiTy
 * @see     GenQZT_GaikaKokyakuTuutiTy
 */
public class PKZT_GaikaKokyakuTuutiTy extends AbstractExDBPrimaryKey<ZT_GaikaKokyakuTuutiTy, PKZT_GaikaKokyakuTuutiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_GaikaKokyakuTuutiTy() {
    }

    public PKZT_GaikaKokyakuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_GaikaKokyakuTuutiTy> getEntityClass() {
        return ZT_GaikaKokyakuTuutiTy.class;
    }

    private String ztytyouhyouymd;

    public String getZtytyouhyouymd() {
        return ztytyouhyouymd;
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        ztytyouhyouymd = pZtytyouhyouymd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

}