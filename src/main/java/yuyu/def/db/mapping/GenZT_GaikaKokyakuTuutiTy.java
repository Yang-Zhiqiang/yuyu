package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.id.PKZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.meta.GenQZT_GaikaKokyakuTuutiTy;
import yuyu.def.db.meta.QZT_GaikaKokyakuTuutiTy;

/**
 * 外貨建顧客通知Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_GaikaKokyakuTuutiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GaikaKokyakuTuutiTy}</td><td colspan="3">外貨建顧客通知Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_GaikaKokyakuTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_GaikaKokyakuTuutiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysclatosyono ztysclatosyono}</td><td>（中継用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydskaiyktirasidouhuukbn ztydskaiyktirasidouhuukbn}</td><td>（中継用）ＤＳ解約チラシ同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrknkanssiryodouhuukbn ztyhrknkanssiryodouhuukbn}</td><td>（中継用）返戻金請求勧奨資料同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyassistplustirasidhkbn ztyassistplustirasidhkbn}</td><td>（中継用）アシストプラスチラシ同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykoktuutireportlayoutptn ztykoktuutireportlayoutptn}</td><td>（中継用）顧客通知帳票レイアウトパターン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygengkumu ztygengkumu}</td><td>（中継用）減額有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykytkmkyobi1 ztykytkmkyobi1}</td><td>（中継用）共通項目予備項目１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuusinsakiyuubinno ztytuusinsakiyuubinno}</td><td>（中継用）通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinadr1kj ztytsinadr1kj}</td><td>（中継用）通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinadr2kj ztytsinadr2kj}</td><td>（中継用）通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinadr3kj ztytsinadr3kj}</td><td>（中継用）通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsintelno ztytsintelno}</td><td>（中継用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinnm18 ztytsinnm18}</td><td>（中継用）通信先氏名（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv19 ztyyobiv19}</td><td>（中継用）予備項目Ｖ１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoukaisakidrtennm1 ztysyoukaisakidrtennm1}</td><td>（中継用）照会先代理店名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoukaisakidrtennm2 ztysyoukaisakidrtennm2}</td><td>（中継用）照会先代理店名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv20 ztyyobiv20}</td><td>（中継用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumsgcd1 ztyaisatumsgcd1}</td><td>（中継用）挨拶文メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumsgcd2 ztyaisatumsgcd2}</td><td>（中継用）挨拶文メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisatumsgcd3 ztyaisatumsgcd3}</td><td>（中継用）挨拶文メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasetuutisakuseiymwa ztyosirasetuutisakuseiymwa}</td><td>（中継用）お知らせ通知作成年月（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisyoumeikbn ztyaisyoumeikbn}</td><td>（中継用）愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj18 ztykyknmkj18}</td><td>（中継用）契約者名（漢字）（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj18 ztyhhknnmkj18}</td><td>（中継用）被保険者名（漢字）（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn1 ztyuktmidasikbn1}</td><td>（中継用）受取人見出し区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn1 ztyuktkbn1}</td><td>（中継用）受取人区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm118 ztyuktnm118}</td><td>（中継用）受取人名１（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn2 ztyuktmidasikbn2}</td><td>（中継用）受取人見出し区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn2 ztyuktkbn2}</td><td>（中継用）受取人区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm218 ztyuktnm218}</td><td>（中継用）受取人名２（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn3 ztyuktmidasikbn3}</td><td>（中継用）受取人見出し区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn3 ztyuktkbn3}</td><td>（中継用）受取人区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm318 ztyuktnm318}</td><td>（中継用）受取人名３（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn4 ztyuktmidasikbn4}</td><td>（中継用）受取人見出し区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn4 ztyuktkbn4}</td><td>（中継用）受取人区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm418 ztyuktnm418}</td><td>（中継用）受取人名４（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn5 ztyuktmidasikbn5}</td><td>（中継用）受取人見出し区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn5 ztyuktkbn5}</td><td>（中継用）受取人区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm518 ztyuktnm518}</td><td>（中継用）受取人名５（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymdwa ztykykymdwa}</td><td>（中継用）契約年月日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1hknkknfromwa ztydai1hknkknfromwa}</td><td>（中継用）第１保険期間至（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1hknkkn ztydai1hknkkn}</td><td>（中継用）第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hknkknfromwa ztydai2hknkknfromwa}</td><td>（中継用）第２保険期間自（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hknkkntowa ztydai2hknkkntowa}</td><td>（中継用）第２保険期間至（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai3hknkknfromwa ztydai3hknkknfromwa}</td><td>（中継用）第３保険期間自（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai3hknkknto ztydai3hknkknto}</td><td>（中継用）第３保険期間至</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktuukasyuzn ztykyktuukasyuzn}</td><td>（中継用）契約通貨種類（全）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktuukatype ztykyktuukatype}</td><td>（中継用）契約通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytk1msgcd ztytk1msgcd}</td><td>（中継用）特約１メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytk2msgcd ztytk2msgcd}</td><td>（中継用）特約２メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytk3msgcd ztytk3msgcd}</td><td>（中継用）特約３メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytk4msgcd ztytk4msgcd}</td><td>（中継用）特約４メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytk5msgcd ztytk5msgcd}</td><td>（中継用）特約５メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytk6msgcd ztytk6msgcd}</td><td>（中継用）特約６メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytk7msgcd ztytk7msgcd}</td><td>（中継用）特約７メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytk8msgcd ztytk8msgcd}</td><td>（中継用）特約８メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytk9msgcd ztytk9msgcd}</td><td>（中継用）特約９メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytk10msgcd ztytk10msgcd}</td><td>（中継用）特約１０メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydstourokujyou ztydstourokujyou}</td><td>（中継用）ＤＳ登録状況</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysd1msgcd ztysd1msgcd}</td><td>（中継用）スミセイダイレクト１メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysd2msgcd ztysd2msgcd}</td><td>（中継用）スミセイダイレクト２メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysd3msgcd ztysd3msgcd}</td><td>（中継用）スミセイダイレクト３メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykrpassword ztykrpassword}</td><td>（中継用）仮パスワード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyuukoukigenwareki ztyyuukoukigenwareki}</td><td>（中継用）有効期限（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktrkjk ztykzktrkjk}</td><td>（中継用）家族登録状況</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzknm118 ztytrkkzknm118}</td><td>（中継用）登録家族名１（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzknm218 ztytrkkzknm218}</td><td>（中継用）登録家族名２（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyendthnkymd ztyyendthnkymd}</td><td>（中継用）円建変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrstartymdstr ztynkshrstartymdstr}</td><td>（中継用）年金支払開始日（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinstartnen ztynenkinstartnen}</td><td>（中継用）年金開始年齢</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruinm ztynksyuruinm}</td><td>（中継用）年金種類名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuu ztyhrkkaisuu}</td><td>（中継用）払込回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytikiktbrisyuruikbn ztytikiktbrisyuruikbn}</td><td>（中継用）定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennouumu ztyzennouumu}</td><td>（中継用）前納有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeiro ztyhrkkeiro}</td><td>（中継用）払込経路</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkkn ztyphrkkkn}</td><td>（中継用）保険料払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysueokikkn ztysueokikkn}</td><td>（中継用）据置期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyakkanbunsyono ztyyakkanbunsyono}</td><td>（中継用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygkykniyuosiraseyobi ztygkykniyuosiraseyobi}</td><td>（中継用）ご契約内容お知らせ予備項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseikijyunymdwa ztysakuseikijyunymdwa}</td><td>（中継用）作成基準日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibrpkyktuuka ztyitijibrpkyktuuka}</td><td>（中継用）一時払保険料（契約通貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonsktuuka ztykihonsktuuka}</td><td>（中継用）基本保険金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgk ztyyenhrkgk}</td><td>（中継用）円貨払込額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystigituukahrkgk ztystigituukahrkgk}</td><td>（中継用）指定外通貨払込額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrktuukasyuzn ztyhrktuukasyuzn}</td><td>（中継用）払込通貨種類（全）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrktuukatype ztyhrktuukatype}</td><td>（中継用）払込通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenkhrikmrate ztyyenkhrikmrate}</td><td>（中継用）円貨払込特約レート</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystigikwsrate ztystigikwsrate}</td><td>（中継用）指定外通貨払込特約レート</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkgkhyoujikbn ztyhrkgkhyoujikbn}</td><td>（中継用）払込額表示区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykijyunkingaku ztykijyunkingaku}</td><td>（中継用）基準金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjnkngkkawaserate ztykjnkngkkawaserate}</td><td>（中継用）基準金額為替レート</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjnkngkhyoujikbn ztykjnkngkhyoujikbn}</td><td>（中継用）基準金額表示区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseikijyunymdkwsrate ztysakuseikijyunymdkwsrate}</td><td>（中継用）作成基準日時点為替レート</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbhknkngkhknkkn ztysbhknkngkhknkkn}</td><td>（中継用）死亡保険金額保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbhknkngkhknkknfromwa ztysbhknkngkhknkknfromwa}</td><td>（中継用）死亡保険金額保険期間自（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbhknkngkhknkkntowa ztysbhknkngkhknkkntowa}</td><td>（中継用）死亡保険金額保険期間至（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbhknkngkkyktuuka ztysbhknkngkkyktuuka}</td><td>（中継用）死亡保険金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbhknkngkyen ztysbhknkngkyen}</td><td>（中継用）死亡保険金額（円貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaigaisbhknkngakuumu ztysaigaisbhknkngakuumu}</td><td>（中継用）災害死亡保険金額表示有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaigaisbhknkngakuktuuka ztysaigaisbhknkngakuktuuka}</td><td>（中継用）災害死亡保険金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaigaisbhknkngakukyen ztysaigaisbhknkngakukyen}</td><td>（中継用）災害死亡保険金額（円貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitatekngkktuuka ztytumitatekngkktuuka}</td><td>（中継用）保険料積立金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitatekngkkyen ztytumitatekngkkyen}</td><td>（中継用）保険料積立金額（円貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiyakuhrkngakkyktuuka ztykaiyakuhrkngakkyktuuka}</td><td>（中継用）解約返戻金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiyakuhrkngakyen ztykaiyakuhrkngakyen}</td><td>（中継用）解約返戻金額（円貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhgkyen ztymkhgkyen}</td><td>（中継用）目標額（円貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhgkwari ztymkhgkwari}</td><td>（中継用）目標額割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhgkhyoujikbn ztymkhgkhyoujikbn}</td><td>（中継用）目標額表示区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouhskmsgcd1 ztyhosyouhskmsgcd1}</td><td>（中継用）保障内容補足メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouhskmsgcd2 ztyhosyouhskmsgcd2}</td><td>（中継用）保障内容補足メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouhskmsgcd3 ztyhosyouhskmsgcd3}</td><td>（中継用）保障内容補足メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouhskmsgcd4 ztyhosyouhskmsgcd4}</td><td>（中継用）保障内容補足メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouhskmsgcd5 ztyhosyouhskmsgcd5}</td><td>（中継用）保障内容補足メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouhskmsgcd6 ztyhosyouhskmsgcd6}</td><td>（中継用）保障内容補足メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouhskmsgcd7 ztyhosyouhskmsgcd7}</td><td>（中継用）保障内容補足メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouhskmsgcd8 ztyhosyouhskmsgcd8}</td><td>（中継用）保障内容補足メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyouhskmsgcd9 ztyhosyouhskmsgcd9}</td><td>（中継用）保障内容補足メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonsyen ztykihonsyen}</td><td>（中継用）基本保険金額（円貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteirirituv4 ztyyoteirirituv4}</td><td>（中継用）予定利率（４桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyendthnkhrkngakyen ztyyendthnkhrkngakyen}</td><td>（中継用）円建変更時返戻金額（円貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmtthaitoukinzndkyen ztytmtthaitoukinzndkyen}</td><td>（中継用）積立配当金残高（円貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkgnsgkkyktuuka ztynkgnsgkkyktuuka}</td><td>（中継用）年金原資額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysbhknkngkhyoujikbn ztysbhknkngkhyoujikbn}</td><td>（中継用）死亡保険金額表示区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykijyunkingakukyktuuka ztykijyunkingakukyktuuka}</td><td>（中継用）基準金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkiktnkgk ztyyenhrkgkiktnkgk}</td><td>（中継用）円貨払込額（一括入金額）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoutikiktyenhrkgkkykj ztyzennoutikiktyenhrkgkkykj}</td><td>（中継用）前納定期一括払円貨払込額（契約時）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiyakusiharaigk ztykaiyakusiharaigk}</td><td>（中継用）解約時支払額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiyakusiharaigkznnuzndk ztykaiyakusiharaigkznnuzndk}</td><td>（中継用）解約時支払額（前納残高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaiyakusiharaigksntshrgk ztykaiyakusiharaigksntshrgk}</td><td>（中継用）解約時支払額（その他支払金額）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukei ztyyenhrkgkgoukei}</td><td>（中継用）円貨払込額の合計額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrritu ztyhrritu}</td><td>（中継用）返戻率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkgnsyensyourai ztynkgnsyensyourai}</td><td>（中継用）年金原資（円貨）（将来予想金額）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkgnsgaikasyourai ztynkgnsgaikasyourai}</td><td>（中継用）年金原資（契約通貨）（将来予想金額）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenhrkgkgoukeisyourai ztyyenhrkgkgoukeisyourai}</td><td>（中継用）円貨払込額の合計額（将来予想金額）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrritusyourai ztyhrritusyourai}</td><td>（中継用）返戻率（将来予想金額）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkgnshskmsgcd1 ztynkgnshskmsgcd1}</td><td>（中継用）年金原資試算補足メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkgnshskmsgcd2 ztynkgnshskmsgcd2}</td><td>（中継用）年金原資試算補足メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkgnshskmsgcd3 ztynkgnshskmsgcd3}</td><td>（中継用）年金原資試算補足メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkgnshskmsgcd4 ztynkgnshskmsgcd4}</td><td>（中継用）年金原資試算補足メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkgnshskmsgcd5 ztynkgnshskmsgcd5}</td><td>（中継用）年金原資試算補足メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyounaiyouyobi ztyhosyounaiyouyobi}</td><td>（中継用）保障内容予備項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunymd1maewa ztykwsratekijyunymd1maewa}</td><td>（中継用）為替レート基準日１ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateusdjpy1mae ztykwsrateusdjpy1mae}</td><td>（中継用）為替レート米ドル（円）１ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateaudjpy1mae ztykwsrateaudjpy1mae}</td><td>（中継用）為替レート豪ドル（円）１ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10 ztyyobiv10}</td><td>（中継用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunymd2maewa ztykwsratekijyunymd2maewa}</td><td>（中継用）為替レート基準日２ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateusdjpy2mae ztykwsrateusdjpy2mae}</td><td>（中継用）為替レート米ドル（円）２ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateaudjpy2mae ztykwsrateaudjpy2mae}</td><td>（中継用）為替レート豪ドル（円）２ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x2 ztyyobiv10x2}</td><td>（中継用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunymd3maewa ztykwsratekijyunymd3maewa}</td><td>（中継用）為替レート基準日３ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateusdjpy3mae ztykwsrateusdjpy3mae}</td><td>（中継用）為替レート米ドル（円）３ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateaudjpy3mae ztykwsrateaudjpy3mae}</td><td>（中継用）為替レート豪ドル（円）３ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x3 ztyyobiv10x3}</td><td>（中継用）予備項目Ｖ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunymd4maewa ztykwsratekijyunymd4maewa}</td><td>（中継用）為替レート基準日４ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateusdjpy4mae ztykwsrateusdjpy4mae}</td><td>（中継用）為替レート米ドル（円）４ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateaudjpy4mae ztykwsrateaudjpy4mae}</td><td>（中継用）為替レート豪ドル（円）４ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x4 ztyyobiv10x4}</td><td>（中継用）予備項目Ｖ１０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunymd5maewa ztykwsratekijyunymd5maewa}</td><td>（中継用）為替レート基準日５ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateusdjpy5mae ztykwsrateusdjpy5mae}</td><td>（中継用）為替レート米ドル（円）５ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateaudjpy5mae ztykwsrateaudjpy5mae}</td><td>（中継用）為替レート豪ドル（円）５ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x5 ztyyobiv10x5}</td><td>（中継用）予備項目Ｖ１０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunymd6maewa ztykwsratekijyunymd6maewa}</td><td>（中継用）為替レート基準日６ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateusdjpy6mae ztykwsrateusdjpy6mae}</td><td>（中継用）為替レート米ドル（円）６ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsrateaudjpy6mae ztykwsrateaudjpy6mae}</td><td>（中継用）為替レート豪ドル（円）６ヶ月前</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x6 ztyyobiv10x6}</td><td>（中継用）予備項目Ｖ１０＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratemsgcd ztykwsratemsgcd}</td><td>（中継用）為替レートメッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv23 ztyyobiv23}</td><td>（中継用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemsgcd1 ztyosirasemsgcd1}</td><td>（中継用）お知らせメッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemsgcd2 ztyosirasemsgcd2}</td><td>（中継用）お知らせメッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemsgcd3 ztyosirasemsgcd3}</td><td>（中継用）お知らせメッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemsgcd4 ztyosirasemsgcd4}</td><td>（中継用）お知らせメッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemsgcd5 ztyosirasemsgcd5}</td><td>（中継用）お知らせメッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv15 ztyyobiv15}</td><td>（中継用）予備項目Ｖ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetteibairitustr ztysetteibairitustr}</td><td>（中継用）設定倍率（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzkrtjygnstr ztytmttknzkrtjygnstr}</td><td>（中継用）積立金増加率上限（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzkrtkgnstr ztytmttknzkrtkgnstr}</td><td>（中継用）積立金増加率下限（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitateriritustr ztytumitateriritustr}</td><td>（中継用）積立利率（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuunm ztysisuunm}</td><td>（中継用）指数名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx1 ztytmttknsuiirirekikbnx1}</td><td>（中継用）積立金推移履歴区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix1 ztykeiyakuoutoubix1}</td><td>（中継用）契約応当日＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix1 ztytmttknjyoutaix1}</td><td>（中継用）積立金状態＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax1 ztyptumitatekngkktuukax1}</td><td>（中継用）保険料積立金額（契約通貨）＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx1 ztyptumitatekngkyenx1}</td><td>（中継用）保険料積立金額（円貨）＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux1 ztysisuux1}</td><td>（中継用）指数＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux1 ztysisuuuprituhugoux1}</td><td>（中継用）指数上昇率符号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux1 ztysisuuupritux1}</td><td>（中継用）指数上昇率＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx1 ztytmttknzoukaritustrx1}</td><td>（中継用）積立金増加率（文字列）＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex1 ztykawaseratex1}</td><td>（中継用）為替レート＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx2 ztytmttknsuiirirekikbnx2}</td><td>（中継用）積立金推移履歴区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix2 ztykeiyakuoutoubix2}</td><td>（中継用）契約応当日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix2 ztytmttknjyoutaix2}</td><td>（中継用）積立金状態＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax2 ztyptumitatekngkktuukax2}</td><td>（中継用）保険料積立金額（契約通貨）＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx2 ztyptumitatekngkyenx2}</td><td>（中継用）保険料積立金額（円貨）＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux2 ztysisuux2}</td><td>（中継用）指数＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux2 ztysisuuuprituhugoux2}</td><td>（中継用）指数上昇率符号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux2 ztysisuuupritux2}</td><td>（中継用）指数上昇率＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx2 ztytmttknzoukaritustrx2}</td><td>（中継用）積立金増加率（文字列）＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex2 ztykawaseratex2}</td><td>（中継用）為替レート＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx3 ztytmttknsuiirirekikbnx3}</td><td>（中継用）積立金推移履歴区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix3 ztykeiyakuoutoubix3}</td><td>（中継用）契約応当日＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix3 ztytmttknjyoutaix3}</td><td>（中継用）積立金状態＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax3 ztyptumitatekngkktuukax3}</td><td>（中継用）保険料積立金額（契約通貨）＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx3 ztyptumitatekngkyenx3}</td><td>（中継用）保険料積立金額（円貨）＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux3 ztysisuux3}</td><td>（中継用）指数＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux3 ztysisuuuprituhugoux3}</td><td>（中継用）指数上昇率符号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux3 ztysisuuupritux3}</td><td>（中継用）指数上昇率＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx3 ztytmttknzoukaritustrx3}</td><td>（中継用）積立金増加率（文字列）＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex3 ztykawaseratex3}</td><td>（中継用）為替レート＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx4 ztytmttknsuiirirekikbnx4}</td><td>（中継用）積立金推移履歴区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix4 ztykeiyakuoutoubix4}</td><td>（中継用）契約応当日＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix4 ztytmttknjyoutaix4}</td><td>（中継用）積立金状態＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax4 ztyptumitatekngkktuukax4}</td><td>（中継用）保険料積立金額（契約通貨）＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx4 ztyptumitatekngkyenx4}</td><td>（中継用）保険料積立金額（円貨）＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux4 ztysisuux4}</td><td>（中継用）指数＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux4 ztysisuuuprituhugoux4}</td><td>（中継用）指数上昇率符号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux4 ztysisuuupritux4}</td><td>（中継用）指数上昇率＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx4 ztytmttknzoukaritustrx4}</td><td>（中継用）積立金増加率（文字列）＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex4 ztykawaseratex4}</td><td>（中継用）為替レート＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx5 ztytmttknsuiirirekikbnx5}</td><td>（中継用）積立金推移履歴区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix5 ztykeiyakuoutoubix5}</td><td>（中継用）契約応当日＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix5 ztytmttknjyoutaix5}</td><td>（中継用）積立金状態＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax5 ztyptumitatekngkktuukax5}</td><td>（中継用）保険料積立金額（契約通貨）＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx5 ztyptumitatekngkyenx5}</td><td>（中継用）保険料積立金額（円貨）＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux5 ztysisuux5}</td><td>（中継用）指数＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux5 ztysisuuuprituhugoux5}</td><td>（中継用）指数上昇率符号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux5 ztysisuuupritux5}</td><td>（中継用）指数上昇率＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx5 ztytmttknzoukaritustrx5}</td><td>（中継用）積立金増加率（文字列）＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex5 ztykawaseratex5}</td><td>（中継用）為替レート＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx6 ztytmttknsuiirirekikbnx6}</td><td>（中継用）積立金推移履歴区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix6 ztykeiyakuoutoubix6}</td><td>（中継用）契約応当日＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix6 ztytmttknjyoutaix6}</td><td>（中継用）積立金状態＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax6 ztyptumitatekngkktuukax6}</td><td>（中継用）保険料積立金額（契約通貨）＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx6 ztyptumitatekngkyenx6}</td><td>（中継用）保険料積立金額（円貨）＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux6 ztysisuux6}</td><td>（中継用）指数＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux6 ztysisuuuprituhugoux6}</td><td>（中継用）指数上昇率符号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux6 ztysisuuupritux6}</td><td>（中継用）指数上昇率＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx6 ztytmttknzoukaritustrx6}</td><td>（中継用）積立金増加率（文字列）＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex6 ztykawaseratex6}</td><td>（中継用）為替レート＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx7 ztytmttknsuiirirekikbnx7}</td><td>（中継用）積立金推移履歴区分＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix7 ztykeiyakuoutoubix7}</td><td>（中継用）契約応当日＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix7 ztytmttknjyoutaix7}</td><td>（中継用）積立金状態＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax7 ztyptumitatekngkktuukax7}</td><td>（中継用）保険料積立金額（契約通貨）＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx7 ztyptumitatekngkyenx7}</td><td>（中継用）保険料積立金額（円貨）＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux7 ztysisuux7}</td><td>（中継用）指数＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux7 ztysisuuuprituhugoux7}</td><td>（中継用）指数上昇率符号＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux7 ztysisuuupritux7}</td><td>（中継用）指数上昇率＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx7 ztytmttknzoukaritustrx7}</td><td>（中継用）積立金増加率（文字列）＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex7 ztykawaseratex7}</td><td>（中継用）為替レート＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx8 ztytmttknsuiirirekikbnx8}</td><td>（中継用）積立金推移履歴区分＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix8 ztykeiyakuoutoubix8}</td><td>（中継用）契約応当日＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix8 ztytmttknjyoutaix8}</td><td>（中継用）積立金状態＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax8 ztyptumitatekngkktuukax8}</td><td>（中継用）保険料積立金額（契約通貨）＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx8 ztyptumitatekngkyenx8}</td><td>（中継用）保険料積立金額（円貨）＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux8 ztysisuux8}</td><td>（中継用）指数＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux8 ztysisuuuprituhugoux8}</td><td>（中継用）指数上昇率符号＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux8 ztysisuuupritux8}</td><td>（中継用）指数上昇率＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx8 ztytmttknzoukaritustrx8}</td><td>（中継用）積立金増加率（文字列）＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex8 ztykawaseratex8}</td><td>（中継用）為替レート＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx9 ztytmttknsuiirirekikbnx9}</td><td>（中継用）積立金推移履歴区分＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix9 ztykeiyakuoutoubix9}</td><td>（中継用）契約応当日＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix9 ztytmttknjyoutaix9}</td><td>（中継用）積立金状態＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax9 ztyptumitatekngkktuukax9}</td><td>（中継用）保険料積立金額（契約通貨）＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx9 ztyptumitatekngkyenx9}</td><td>（中継用）保険料積立金額（円貨）＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux9 ztysisuux9}</td><td>（中継用）指数＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux9 ztysisuuuprituhugoux9}</td><td>（中継用）指数上昇率符号＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux9 ztysisuuupritux9}</td><td>（中継用）指数上昇率＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx9 ztytmttknzoukaritustrx9}</td><td>（中継用）積立金増加率（文字列）＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex9 ztykawaseratex9}</td><td>（中継用）為替レート＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx10 ztytmttknsuiirirekikbnx10}</td><td>（中継用）積立金推移履歴区分＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix10 ztykeiyakuoutoubix10}</td><td>（中継用）契約応当日＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix10 ztytmttknjyoutaix10}</td><td>（中継用）積立金状態＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax10 ztyptumitatekngkktuukax10}</td><td>（中継用）保険料積立金額（契約通貨）＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx10 ztyptumitatekngkyenx10}</td><td>（中継用）保険料積立金額（円貨）＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux10 ztysisuux10}</td><td>（中継用）指数＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux10 ztysisuuuprituhugoux10}</td><td>（中継用）指数上昇率符号＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux10 ztysisuuupritux10}</td><td>（中継用）指数上昇率＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx10 ztytmttknzoukaritustrx10}</td><td>（中継用）積立金増加率（文字列）＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex10 ztykawaseratex10}</td><td>（中継用）為替レート＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiirirekikbnx11 ztytmttknsuiirirekikbnx11}</td><td>（中継用）積立金推移履歴区分＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakuoutoubix11 ztykeiyakuoutoubix11}</td><td>（中継用）契約応当日＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknjyoutaix11 ztytmttknjyoutaix11}</td><td>（中継用）積立金状態＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkktuukax11 ztyptumitatekngkktuukax11}</td><td>（中継用）保険料積立金額（契約通貨）＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptumitatekngkyenx11 ztyptumitatekngkyenx11}</td><td>（中継用）保険料積立金額（円貨）＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuux11 ztysisuux11}</td><td>（中継用）指数＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuuprituhugoux11 ztysisuuuprituhugoux11}</td><td>（中継用）指数上昇率符号＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuupritux11 ztysisuuupritux11}</td><td>（中継用）指数上昇率＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritustrx11 ztytmttknzoukaritustrx11}</td><td>（中継用）積立金増加率（文字列）＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaseratex11 ztykawaseratex11}</td><td>（中継用）為替レート＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknsuiiyobi ztytmttknsuiiyobi}</td><td>（中継用）積立金推移予備項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdkkigen ztyttdkkigen}</td><td>（中継用）お手続き期限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykrnkgnsgk ztykrnkgnsgk}</td><td>（中継用）仮年金原資額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytirtitnttdkyobi ztytirtitnttdkyobi}</td><td>（中継用）定率移転の手続き予備項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskshozonnensuu ztyskshozonnensuu}</td><td>（中継用）請求書保存年数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydocumentid ztydocumentid}</td><td>（中継用）ドキュメントＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoritugisyasyozokunm ztytoritugisyasyozokunm}</td><td>（中継用）取次者所属名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyendthnkhrsksyobi ztyyendthnkhrsksyobi}</td><td>（中継用）円建変更時返戻金請求書予備項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym1 ztyyoteiriritukijyunym1}</td><td>（中継用）予定利率基準年月＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu1 ztyyoteiriritu1}</td><td>（中継用）予定利率＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt1 ztyytirrtcalckijyunrrt1}</td><td>（中継用）予定利率計算基準利率＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym1 ztykwsratekijyunym1}</td><td>（中継用）為替レート基準年月＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate1 ztykaknsnkwsrate1}</td><td>（中継用）換算為替レート＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika1 ztypgaika1}</td><td>（中継用）保険料（契約通貨）＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen1 ztypyen1}</td><td>（中継用）保険料（円貨）＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym2 ztyyoteiriritukijyunym2}</td><td>（中継用）予定利率基準年月＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu2 ztyyoteiriritu2}</td><td>（中継用）予定利率＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt2 ztyytirrtcalckijyunrrt2}</td><td>（中継用）予定利率計算基準利率＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym2 ztykwsratekijyunym2}</td><td>（中継用）為替レート基準年月＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate2 ztykaknsnkwsrate2}</td><td>（中継用）換算為替レート＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika2 ztypgaika2}</td><td>（中継用）保険料（契約通貨）＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen2 ztypyen2}</td><td>（中継用）保険料（円貨）＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym3 ztyyoteiriritukijyunym3}</td><td>（中継用）予定利率基準年月＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu3 ztyyoteiriritu3}</td><td>（中継用）予定利率＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt3 ztyytirrtcalckijyunrrt3}</td><td>（中継用）予定利率計算基準利率＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym3 ztykwsratekijyunym3}</td><td>（中継用）為替レート基準年月＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate3 ztykaknsnkwsrate3}</td><td>（中継用）換算為替レート＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika3 ztypgaika3}</td><td>（中継用）保険料（契約通貨）＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen3 ztypyen3}</td><td>（中継用）保険料（円貨）＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym4 ztyyoteiriritukijyunym4}</td><td>（中継用）予定利率基準年月＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu4 ztyyoteiriritu4}</td><td>（中継用）予定利率＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt4 ztyytirrtcalckijyunrrt4}</td><td>（中継用）予定利率計算基準利率＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym4 ztykwsratekijyunym4}</td><td>（中継用）為替レート基準年月＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate4 ztykaknsnkwsrate4}</td><td>（中継用）換算為替レート＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika4 ztypgaika4}</td><td>（中継用）保険料（契約通貨）＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen4 ztypyen4}</td><td>（中継用）保険料（円貨）＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym5 ztyyoteiriritukijyunym5}</td><td>（中継用）予定利率基準年月＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu5 ztyyoteiriritu5}</td><td>（中継用）予定利率＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt5 ztyytirrtcalckijyunrrt5}</td><td>（中継用）予定利率計算基準利率＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym5 ztykwsratekijyunym5}</td><td>（中継用）為替レート基準年月＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate5 ztykaknsnkwsrate5}</td><td>（中継用）換算為替レート＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika5 ztypgaika5}</td><td>（中継用）保険料（契約通貨）＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen5 ztypyen5}</td><td>（中継用）保険料（円貨）＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym6 ztyyoteiriritukijyunym6}</td><td>（中継用）予定利率基準年月＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu6 ztyyoteiriritu6}</td><td>（中継用）予定利率＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt6 ztyytirrtcalckijyunrrt6}</td><td>（中継用）予定利率計算基準利率＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym6 ztykwsratekijyunym6}</td><td>（中継用）為替レート基準年月＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate6 ztykaknsnkwsrate6}</td><td>（中継用）換算為替レート＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika6 ztypgaika6}</td><td>（中継用）保険料（契約通貨）＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen6 ztypyen6}</td><td>（中継用）保険料（円貨）＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym7 ztyyoteiriritukijyunym7}</td><td>（中継用）予定利率基準年月＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu7 ztyyoteiriritu7}</td><td>（中継用）予定利率＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt7 ztyytirrtcalckijyunrrt7}</td><td>（中継用）予定利率計算基準利率＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym7 ztykwsratekijyunym7}</td><td>（中継用）為替レート基準年月＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate7 ztykaknsnkwsrate7}</td><td>（中継用）換算為替レート＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika7 ztypgaika7}</td><td>（中継用）保険料（契約通貨）＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen7 ztypyen7}</td><td>（中継用）保険料（円貨）＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym8 ztyyoteiriritukijyunym8}</td><td>（中継用）予定利率基準年月＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu8 ztyyoteiriritu8}</td><td>（中継用）予定利率＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt8 ztyytirrtcalckijyunrrt8}</td><td>（中継用）予定利率計算基準利率＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym8 ztykwsratekijyunym8}</td><td>（中継用）為替レート基準年月＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate8 ztykaknsnkwsrate8}</td><td>（中継用）換算為替レート＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika8 ztypgaika8}</td><td>（中継用）保険料（契約通貨）＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen8 ztypyen8}</td><td>（中継用）保険料（円貨）＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym9 ztyyoteiriritukijyunym9}</td><td>（中継用）予定利率基準年月＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu9 ztyyoteiriritu9}</td><td>（中継用）予定利率＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt9 ztyytirrtcalckijyunrrt9}</td><td>（中継用）予定利率計算基準利率＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym9 ztykwsratekijyunym9}</td><td>（中継用）為替レート基準年月＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate9 ztykaknsnkwsrate9}</td><td>（中継用）換算為替レート＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika9 ztypgaika9}</td><td>（中継用）保険料（契約通貨）＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen9 ztypyen9}</td><td>（中継用）保険料（円貨）＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym10 ztyyoteiriritukijyunym10}</td><td>（中継用）予定利率基準年月＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu10 ztyyoteiriritu10}</td><td>（中継用）予定利率＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt10 ztyytirrtcalckijyunrrt10}</td><td>（中継用）予定利率計算基準利率＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym10 ztykwsratekijyunym10}</td><td>（中継用）為替レート基準年月＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate10 ztykaknsnkwsrate10}</td><td>（中継用）換算為替レート＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika10 ztypgaika10}</td><td>（中継用）保険料（契約通貨）＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen10 ztypyen10}</td><td>（中継用）保険料（円貨）＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym11 ztyyoteiriritukijyunym11}</td><td>（中継用）予定利率基準年月＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu11 ztyyoteiriritu11}</td><td>（中継用）予定利率＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt11 ztyytirrtcalckijyunrrt11}</td><td>（中継用）予定利率計算基準利率＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym11 ztykwsratekijyunym11}</td><td>（中継用）為替レート基準年月＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate11 ztykaknsnkwsrate11}</td><td>（中継用）換算為替レート＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika11 ztypgaika11}</td><td>（中継用）保険料（契約通貨）＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen11 ztypyen11}</td><td>（中継用）保険料（円貨）＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritukijyunym12 ztyyoteiriritukijyunym12}</td><td>（中継用）予定利率基準年月＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritu12 ztyyoteiriritu12}</td><td>（中継用）予定利率＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtcalckijyunrrt12 ztyytirrtcalckijyunrrt12}</td><td>（中継用）予定利率計算基準利率＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykwsratekijyunym12 ztykwsratekijyunym12}</td><td>（中継用）為替レート基準年月＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaknsnkwsrate12 ztykaknsnkwsrate12}</td><td>（中継用）換算為替レート＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypgaika12 ztypgaika12}</td><td>（中継用）保険料（契約通貨）＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypyen12 ztypyen12}</td><td>（中継用）保険料（円貨）＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn1 ztyfstphyoujikbn1}</td><td>（中継用）初回保険料表示区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn2 ztyfstphyoujikbn2}</td><td>（中継用）初回保険料表示区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn3 ztyfstphyoujikbn3}</td><td>（中継用）初回保険料表示区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn4 ztyfstphyoujikbn4}</td><td>（中継用）初回保険料表示区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn5 ztyfstphyoujikbn5}</td><td>（中継用）初回保険料表示区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn6 ztyfstphyoujikbn6}</td><td>（中継用）初回保険料表示区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn7 ztyfstphyoujikbn7}</td><td>（中継用）初回保険料表示区分＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn8 ztyfstphyoujikbn8}</td><td>（中継用）初回保険料表示区分＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn9 ztyfstphyoujikbn9}</td><td>（中継用）初回保険料表示区分＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn10 ztyfstphyoujikbn10}</td><td>（中継用）初回保険料表示区分＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn11 ztyfstphyoujikbn11}</td><td>（中継用）初回保険料表示区分＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstphyoujikbn12 ztyfstphyoujikbn12}</td><td>（中継用）初回保険料表示区分＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtitrnyobi2 ztyytirrtitrnyobi2}</td><td>（中継用）予定利率一覧予備項目２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtitrnhskmsgcd1 ztyytirrtitrnhskmsgcd1}</td><td>（中継用）予定利率一覧補足メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtitrnhskmsgcd2 ztyytirrtitrnhskmsgcd2}</td><td>（中継用）予定利率一覧補足メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtitrnhskmsgcd3 ztyytirrtitrnhskmsgcd3}</td><td>（中継用）予定利率一覧補足メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtitrnhskmsgcd4 ztyytirrtitrnhskmsgcd4}</td><td>（中継用）予定利率一覧補足メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtitrnhskmsgcd5 ztyytirrtitrnhskmsgcd5}</td><td>（中継用）予定利率一覧補足メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtitrnhskmsgcd6 ztyytirrtitrnhskmsgcd6}</td><td>（中継用）予定利率一覧補足メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtitrnhskmsgcd7 ztyytirrtitrnhskmsgcd7}</td><td>（中継用）予定利率一覧補足メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtitrnhskmsgcd8 ztyytirrtitrnhskmsgcd8}</td><td>（中継用）予定利率一覧補足メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrtitrnyobi ztyytirrtitrnyobi}</td><td>（中継用）過去１年間の予定利率予備項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_GaikaKokyakuTuutiTy
 * @see     PKZT_GaikaKokyakuTuutiTy
 * @see     QZT_GaikaKokyakuTuutiTy
 * @see     GenQZT_GaikaKokyakuTuutiTy
 */
@MappedSuperclass
@Table(name=GenZT_GaikaKokyakuTuutiTy.TABLE_NAME)
@IdClass(value=PKZT_GaikaKokyakuTuutiTy.class)
public abstract class GenZT_GaikaKokyakuTuutiTy extends AbstractExDBEntity<ZT_GaikaKokyakuTuutiTy, PKZT_GaikaKokyakuTuutiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_GaikaKokyakuTuutiTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYSCLATOSYONO           = "ztysclatosyono";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYDSKAIYKTIRASIDOUHUUKBN = "ztydskaiyktirasidouhuukbn";
    public static final String ZTYHRKNKANSSIRYODOUHUUKBN = "ztyhrknkanssiryodouhuukbn";
    public static final String ZTYASSISTPLUSTIRASIDHKBN = "ztyassistplustirasidhkbn";
    public static final String ZTYKOKTUUTIREPORTLAYOUTPTN = "ztykoktuutireportlayoutptn";
    public static final String ZTYGENGKUMU              = "ztygengkumu";
    public static final String ZTYKYTKMKYOBI1           = "ztykytkmkyobi1";
    public static final String ZTYTUUSINSAKIYUUBINNO    = "ztytuusinsakiyuubinno";
    public static final String ZTYTSINADR1KJ            = "ztytsinadr1kj";
    public static final String ZTYTSINADR2KJ            = "ztytsinadr2kj";
    public static final String ZTYTSINADR3KJ            = "ztytsinadr3kj";
    public static final String ZTYTSINTELNO             = "ztytsintelno";
    public static final String ZTYTSINNM18              = "ztytsinnm18";
    public static final String ZTYYOBIV19               = "ztyyobiv19";
    public static final String ZTYSYOUKAISAKIDRTENNM1   = "ztysyoukaisakidrtennm1";
    public static final String ZTYSYOUKAISAKIDRTENNM2   = "ztysyoukaisakidrtennm2";
    public static final String ZTYYOBIV20               = "ztyyobiv20";
    public static final String ZTYAISATUMSGCD1          = "ztyaisatumsgcd1";
    public static final String ZTYAISATUMSGCD2          = "ztyaisatumsgcd2";
    public static final String ZTYAISATUMSGCD3          = "ztyaisatumsgcd3";
    public static final String ZTYOSIRASETUUTISAKUSEIYMWA = "ztyosirasetuutisakuseiymwa";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYAISYOUMEIKBN          = "ztyaisyoumeikbn";
    public static final String ZTYKYKNMKJ18             = "ztykyknmkj18";
    public static final String ZTYHHKNNMKJ18            = "ztyhhknnmkj18";
    public static final String ZTYUKTMIDASIKBN1         = "ztyuktmidasikbn1";
    public static final String ZTYUKTKBN1               = "ztyuktkbn1";
    public static final String ZTYUKTNM118              = "ztyuktnm118";
    public static final String ZTYUKTMIDASIKBN2         = "ztyuktmidasikbn2";
    public static final String ZTYUKTKBN2               = "ztyuktkbn2";
    public static final String ZTYUKTNM218              = "ztyuktnm218";
    public static final String ZTYUKTMIDASIKBN3         = "ztyuktmidasikbn3";
    public static final String ZTYUKTKBN3               = "ztyuktkbn3";
    public static final String ZTYUKTNM318              = "ztyuktnm318";
    public static final String ZTYUKTMIDASIKBN4         = "ztyuktmidasikbn4";
    public static final String ZTYUKTKBN4               = "ztyuktkbn4";
    public static final String ZTYUKTNM418              = "ztyuktnm418";
    public static final String ZTYUKTMIDASIKBN5         = "ztyuktmidasikbn5";
    public static final String ZTYUKTKBN5               = "ztyuktkbn5";
    public static final String ZTYUKTNM518              = "ztyuktnm518";
    public static final String ZTYKYKYMDWA              = "ztykykymdwa";
    public static final String ZTYDAI1HKNKKNFROMWA      = "ztydai1hknkknfromwa";
    public static final String ZTYDAI1HKNKKN            = "ztydai1hknkkn";
    public static final String ZTYDAI2HKNKKNFROMWA      = "ztydai2hknkknfromwa";
    public static final String ZTYDAI2HKNKKNTOWA        = "ztydai2hknkkntowa";
    public static final String ZTYDAI3HKNKKNFROMWA      = "ztydai3hknkknfromwa";
    public static final String ZTYDAI3HKNKKNTO          = "ztydai3hknkknto";
    public static final String ZTYKYKTUUKASYUZN         = "ztykyktuukasyuzn";
    public static final String ZTYKYKTUUKATYPE          = "ztykyktuukatype";
    public static final String ZTYTK1MSGCD              = "ztytk1msgcd";
    public static final String ZTYTK2MSGCD              = "ztytk2msgcd";
    public static final String ZTYTK3MSGCD              = "ztytk3msgcd";
    public static final String ZTYTK4MSGCD              = "ztytk4msgcd";
    public static final String ZTYTK5MSGCD              = "ztytk5msgcd";
    public static final String ZTYTK6MSGCD              = "ztytk6msgcd";
    public static final String ZTYTK7MSGCD              = "ztytk7msgcd";
    public static final String ZTYTK8MSGCD              = "ztytk8msgcd";
    public static final String ZTYTK9MSGCD              = "ztytk9msgcd";
    public static final String ZTYTK10MSGCD             = "ztytk10msgcd";
    public static final String ZTYDSTOUROKUJYOU         = "ztydstourokujyou";
    public static final String ZTYSD1MSGCD              = "ztysd1msgcd";
    public static final String ZTYSD2MSGCD              = "ztysd2msgcd";
    public static final String ZTYSD3MSGCD              = "ztysd3msgcd";
    public static final String ZTYKRPASSWORD            = "ztykrpassword";
    public static final String ZTYYUUKOUKIGENWAREKI     = "ztyyuukoukigenwareki";
    public static final String ZTYKZKTRKJK              = "ztykzktrkjk";
    public static final String ZTYTRKKZKNM118           = "ztytrkkzknm118";
    public static final String ZTYTRKKZKNM218           = "ztytrkkzknm218";
    public static final String ZTYYENDTHNKYMD           = "ztyyendthnkymd";
    public static final String ZTYNKSHRSTARTYMDSTR      = "ztynkshrstartymdstr";
    public static final String ZTYNENKINSTARTNEN        = "ztynenkinstartnen";
    public static final String ZTYNKSYURUINM            = "ztynksyuruinm";
    public static final String ZTYHRKKAISUU             = "ztyhrkkaisuu";
    public static final String ZTYTIKIKTBRISYURUIKBN    = "ztytikiktbrisyuruikbn";
    public static final String ZTYZENNOUUMU             = "ztyzennouumu";
    public static final String ZTYHRKKEIRO              = "ztyhrkkeiro";
    public static final String ZTYPHRKKKN               = "ztyphrkkkn";
    public static final String ZTYSUEOKIKKN             = "ztysueokikkn";
    public static final String ZTYYAKKANBUNSYONO        = "ztyyakkanbunsyono";
    public static final String ZTYGKYKNIYUOSIRASEYOBI   = "ztygkykniyuosiraseyobi";
    public static final String ZTYSAKUSEIKIJYUNYMDWA    = "ztysakuseikijyunymdwa";
    public static final String ZTYITIJIBRPKYKTUUKA      = "ztyitijibrpkyktuuka";
    public static final String ZTYKIHONSKTUUKA          = "ztykihonsktuuka";
    public static final String ZTYYENHRKGK              = "ztyyenhrkgk";
    public static final String ZTYSTIGITUUKAHRKGK       = "ztystigituukahrkgk";
    public static final String ZTYHRKTUUKASYUZN         = "ztyhrktuukasyuzn";
    public static final String ZTYHRKTUUKATYPE          = "ztyhrktuukatype";
    public static final String ZTYYENKHRIKMRATE         = "ztyyenkhrikmrate";
    public static final String ZTYSTIGIKWSRATE          = "ztystigikwsrate";
    public static final String ZTYHRKGKHYOUJIKBN        = "ztyhrkgkhyoujikbn";
    public static final String ZTYKIJYUNKINGAKU         = "ztykijyunkingaku";
    public static final String ZTYKJNKNGKKAWASERATE     = "ztykjnkngkkawaserate";
    public static final String ZTYKJNKNGKHYOUJIKBN      = "ztykjnkngkhyoujikbn";
    public static final String ZTYSAKUSEIKIJYUNYMDKWSRATE = "ztysakuseikijyunymdkwsrate";
    public static final String ZTYSBHKNKNGKHKNKKN       = "ztysbhknkngkhknkkn";
    public static final String ZTYSBHKNKNGKHKNKKNFROMWA = "ztysbhknkngkhknkknfromwa";
    public static final String ZTYSBHKNKNGKHKNKKNTOWA   = "ztysbhknkngkhknkkntowa";
    public static final String ZTYSBHKNKNGKKYKTUUKA     = "ztysbhknkngkkyktuuka";
    public static final String ZTYSBHKNKNGKYEN          = "ztysbhknkngkyen";
    public static final String ZTYSAIGAISBHKNKNGAKUUMU  = "ztysaigaisbhknkngakuumu";
    public static final String ZTYSAIGAISBHKNKNGAKUKTUUKA = "ztysaigaisbhknkngakuktuuka";
    public static final String ZTYSAIGAISBHKNKNGAKUKYEN = "ztysaigaisbhknkngakukyen";
    public static final String ZTYTUMITATEKNGKKTUUKA    = "ztytumitatekngkktuuka";
    public static final String ZTYTUMITATEKNGKKYEN      = "ztytumitatekngkkyen";
    public static final String ZTYKAIYAKUHRKNGAKKYKTUUKA = "ztykaiyakuhrkngakkyktuuka";
    public static final String ZTYKAIYAKUHRKNGAKYEN     = "ztykaiyakuhrkngakyen";
    public static final String ZTYMKHGKYEN              = "ztymkhgkyen";
    public static final String ZTYMKHGKWARI             = "ztymkhgkwari";
    public static final String ZTYMKHGKHYOUJIKBN        = "ztymkhgkhyoujikbn";
    public static final String ZTYHOSYOUHSKMSGCD1       = "ztyhosyouhskmsgcd1";
    public static final String ZTYHOSYOUHSKMSGCD2       = "ztyhosyouhskmsgcd2";
    public static final String ZTYHOSYOUHSKMSGCD3       = "ztyhosyouhskmsgcd3";
    public static final String ZTYHOSYOUHSKMSGCD4       = "ztyhosyouhskmsgcd4";
    public static final String ZTYHOSYOUHSKMSGCD5       = "ztyhosyouhskmsgcd5";
    public static final String ZTYHOSYOUHSKMSGCD6       = "ztyhosyouhskmsgcd6";
    public static final String ZTYHOSYOUHSKMSGCD7       = "ztyhosyouhskmsgcd7";
    public static final String ZTYHOSYOUHSKMSGCD8       = "ztyhosyouhskmsgcd8";
    public static final String ZTYHOSYOUHSKMSGCD9       = "ztyhosyouhskmsgcd9";
    public static final String ZTYKIHONSYEN             = "ztykihonsyen";
    public static final String ZTYYOTEIRIRITUV4         = "ztyyoteirirituv4";
    public static final String ZTYYENDTHNKHRKNGAKYEN    = "ztyyendthnkhrkngakyen";
    public static final String ZTYTMTTHAITOUKINZNDKYEN  = "ztytmtthaitoukinzndkyen";
    public static final String ZTYNKGNSGKKYKTUUKA       = "ztynkgnsgkkyktuuka";
    public static final String ZTYSBHKNKNGKHYOUJIKBN    = "ztysbhknkngkhyoujikbn";
    public static final String ZTYKIJYUNKINGAKUKYKTUUKA = "ztykijyunkingakukyktuuka";
    public static final String ZTYYENHRKGKIKTNKGK       = "ztyyenhrkgkiktnkgk";
    public static final String ZTYZENNOUTIKIKTYENHRKGKKYKJ = "ztyzennoutikiktyenhrkgkkykj";
    public static final String ZTYKAIYAKUSIHARAIGK      = "ztykaiyakusiharaigk";
    public static final String ZTYKAIYAKUSIHARAIGKZNNUZNDK = "ztykaiyakusiharaigkznnuzndk";
    public static final String ZTYKAIYAKUSIHARAIGKSNTSHRGK = "ztykaiyakusiharaigksntshrgk";
    public static final String ZTYYENHRKGKGOUKEI        = "ztyyenhrkgkgoukei";
    public static final String ZTYHRRITU                = "ztyhrritu";
    public static final String ZTYNKGNSYENSYOURAI       = "ztynkgnsyensyourai";
    public static final String ZTYNKGNSGAIKASYOURAI     = "ztynkgnsgaikasyourai";
    public static final String ZTYYENHRKGKGOUKEISYOURAI = "ztyyenhrkgkgoukeisyourai";
    public static final String ZTYHRRITUSYOURAI         = "ztyhrritusyourai";
    public static final String ZTYNKGNSHSKMSGCD1        = "ztynkgnshskmsgcd1";
    public static final String ZTYNKGNSHSKMSGCD2        = "ztynkgnshskmsgcd2";
    public static final String ZTYNKGNSHSKMSGCD3        = "ztynkgnshskmsgcd3";
    public static final String ZTYNKGNSHSKMSGCD4        = "ztynkgnshskmsgcd4";
    public static final String ZTYNKGNSHSKMSGCD5        = "ztynkgnshskmsgcd5";
    public static final String ZTYHOSYOUNAIYOUYOBI      = "ztyhosyounaiyouyobi";
    public static final String ZTYKWSRATEKIJYUNYMD1MAEWA = "ztykwsratekijyunymd1maewa";
    public static final String ZTYKWSRATEUSDJPY1MAE     = "ztykwsrateusdjpy1mae";
    public static final String ZTYKWSRATEAUDJPY1MAE     = "ztykwsrateaudjpy1mae";
    public static final String ZTYYOBIV10               = "ztyyobiv10";
    public static final String ZTYKWSRATEKIJYUNYMD2MAEWA = "ztykwsratekijyunymd2maewa";
    public static final String ZTYKWSRATEUSDJPY2MAE     = "ztykwsrateusdjpy2mae";
    public static final String ZTYKWSRATEAUDJPY2MAE     = "ztykwsrateaudjpy2mae";
    public static final String ZTYYOBIV10X2             = "ztyyobiv10x2";
    public static final String ZTYKWSRATEKIJYUNYMD3MAEWA = "ztykwsratekijyunymd3maewa";
    public static final String ZTYKWSRATEUSDJPY3MAE     = "ztykwsrateusdjpy3mae";
    public static final String ZTYKWSRATEAUDJPY3MAE     = "ztykwsrateaudjpy3mae";
    public static final String ZTYYOBIV10X3             = "ztyyobiv10x3";
    public static final String ZTYKWSRATEKIJYUNYMD4MAEWA = "ztykwsratekijyunymd4maewa";
    public static final String ZTYKWSRATEUSDJPY4MAE     = "ztykwsrateusdjpy4mae";
    public static final String ZTYKWSRATEAUDJPY4MAE     = "ztykwsrateaudjpy4mae";
    public static final String ZTYYOBIV10X4             = "ztyyobiv10x4";
    public static final String ZTYKWSRATEKIJYUNYMD5MAEWA = "ztykwsratekijyunymd5maewa";
    public static final String ZTYKWSRATEUSDJPY5MAE     = "ztykwsrateusdjpy5mae";
    public static final String ZTYKWSRATEAUDJPY5MAE     = "ztykwsrateaudjpy5mae";
    public static final String ZTYYOBIV10X5             = "ztyyobiv10x5";
    public static final String ZTYKWSRATEKIJYUNYMD6MAEWA = "ztykwsratekijyunymd6maewa";
    public static final String ZTYKWSRATEUSDJPY6MAE     = "ztykwsrateusdjpy6mae";
    public static final String ZTYKWSRATEAUDJPY6MAE     = "ztykwsrateaudjpy6mae";
    public static final String ZTYYOBIV10X6             = "ztyyobiv10x6";
    public static final String ZTYKWSRATEMSGCD          = "ztykwsratemsgcd";
    public static final String ZTYYOBIV23               = "ztyyobiv23";
    public static final String ZTYOSIRASEMSGCD1         = "ztyosirasemsgcd1";
    public static final String ZTYOSIRASEMSGCD2         = "ztyosirasemsgcd2";
    public static final String ZTYOSIRASEMSGCD3         = "ztyosirasemsgcd3";
    public static final String ZTYOSIRASEMSGCD4         = "ztyosirasemsgcd4";
    public static final String ZTYOSIRASEMSGCD5         = "ztyosirasemsgcd5";
    public static final String ZTYYOBIV15               = "ztyyobiv15";
    public static final String ZTYSETTEIBAIRITUSTR      = "ztysetteibairitustr";
    public static final String ZTYTMTTKNZKRTJYGNSTR     = "ztytmttknzkrtjygnstr";
    public static final String ZTYTMTTKNZKRTKGNSTR      = "ztytmttknzkrtkgnstr";
    public static final String ZTYTUMITATERIRITUSTR     = "ztytumitateriritustr";
    public static final String ZTYSISUUNM               = "ztysisuunm";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX1 = "ztytmttknsuiirirekikbnx1";
    public static final String ZTYKEIYAKUOUTOUBIX1      = "ztykeiyakuoutoubix1";
    public static final String ZTYTMTTKNJYOUTAIX1       = "ztytmttknjyoutaix1";
    public static final String ZTYPTUMITATEKNGKKTUUKAX1 = "ztyptumitatekngkktuukax1";
    public static final String ZTYPTUMITATEKNGKYENX1    = "ztyptumitatekngkyenx1";
    public static final String ZTYSISUUX1               = "ztysisuux1";
    public static final String ZTYSISUUUPRITUHUGOUX1    = "ztysisuuuprituhugoux1";
    public static final String ZTYSISUUUPRITUX1         = "ztysisuuupritux1";
    public static final String ZTYTMTTKNZOUKARITUSTRX1  = "ztytmttknzoukaritustrx1";
    public static final String ZTYKAWASERATEX1          = "ztykawaseratex1";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX2 = "ztytmttknsuiirirekikbnx2";
    public static final String ZTYKEIYAKUOUTOUBIX2      = "ztykeiyakuoutoubix2";
    public static final String ZTYTMTTKNJYOUTAIX2       = "ztytmttknjyoutaix2";
    public static final String ZTYPTUMITATEKNGKKTUUKAX2 = "ztyptumitatekngkktuukax2";
    public static final String ZTYPTUMITATEKNGKYENX2    = "ztyptumitatekngkyenx2";
    public static final String ZTYSISUUX2               = "ztysisuux2";
    public static final String ZTYSISUUUPRITUHUGOUX2    = "ztysisuuuprituhugoux2";
    public static final String ZTYSISUUUPRITUX2         = "ztysisuuupritux2";
    public static final String ZTYTMTTKNZOUKARITUSTRX2  = "ztytmttknzoukaritustrx2";
    public static final String ZTYKAWASERATEX2          = "ztykawaseratex2";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX3 = "ztytmttknsuiirirekikbnx3";
    public static final String ZTYKEIYAKUOUTOUBIX3      = "ztykeiyakuoutoubix3";
    public static final String ZTYTMTTKNJYOUTAIX3       = "ztytmttknjyoutaix3";
    public static final String ZTYPTUMITATEKNGKKTUUKAX3 = "ztyptumitatekngkktuukax3";
    public static final String ZTYPTUMITATEKNGKYENX3    = "ztyptumitatekngkyenx3";
    public static final String ZTYSISUUX3               = "ztysisuux3";
    public static final String ZTYSISUUUPRITUHUGOUX3    = "ztysisuuuprituhugoux3";
    public static final String ZTYSISUUUPRITUX3         = "ztysisuuupritux3";
    public static final String ZTYTMTTKNZOUKARITUSTRX3  = "ztytmttknzoukaritustrx3";
    public static final String ZTYKAWASERATEX3          = "ztykawaseratex3";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX4 = "ztytmttknsuiirirekikbnx4";
    public static final String ZTYKEIYAKUOUTOUBIX4      = "ztykeiyakuoutoubix4";
    public static final String ZTYTMTTKNJYOUTAIX4       = "ztytmttknjyoutaix4";
    public static final String ZTYPTUMITATEKNGKKTUUKAX4 = "ztyptumitatekngkktuukax4";
    public static final String ZTYPTUMITATEKNGKYENX4    = "ztyptumitatekngkyenx4";
    public static final String ZTYSISUUX4               = "ztysisuux4";
    public static final String ZTYSISUUUPRITUHUGOUX4    = "ztysisuuuprituhugoux4";
    public static final String ZTYSISUUUPRITUX4         = "ztysisuuupritux4";
    public static final String ZTYTMTTKNZOUKARITUSTRX4  = "ztytmttknzoukaritustrx4";
    public static final String ZTYKAWASERATEX4          = "ztykawaseratex4";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX5 = "ztytmttknsuiirirekikbnx5";
    public static final String ZTYKEIYAKUOUTOUBIX5      = "ztykeiyakuoutoubix5";
    public static final String ZTYTMTTKNJYOUTAIX5       = "ztytmttknjyoutaix5";
    public static final String ZTYPTUMITATEKNGKKTUUKAX5 = "ztyptumitatekngkktuukax5";
    public static final String ZTYPTUMITATEKNGKYENX5    = "ztyptumitatekngkyenx5";
    public static final String ZTYSISUUX5               = "ztysisuux5";
    public static final String ZTYSISUUUPRITUHUGOUX5    = "ztysisuuuprituhugoux5";
    public static final String ZTYSISUUUPRITUX5         = "ztysisuuupritux5";
    public static final String ZTYTMTTKNZOUKARITUSTRX5  = "ztytmttknzoukaritustrx5";
    public static final String ZTYKAWASERATEX5          = "ztykawaseratex5";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX6 = "ztytmttknsuiirirekikbnx6";
    public static final String ZTYKEIYAKUOUTOUBIX6      = "ztykeiyakuoutoubix6";
    public static final String ZTYTMTTKNJYOUTAIX6       = "ztytmttknjyoutaix6";
    public static final String ZTYPTUMITATEKNGKKTUUKAX6 = "ztyptumitatekngkktuukax6";
    public static final String ZTYPTUMITATEKNGKYENX6    = "ztyptumitatekngkyenx6";
    public static final String ZTYSISUUX6               = "ztysisuux6";
    public static final String ZTYSISUUUPRITUHUGOUX6    = "ztysisuuuprituhugoux6";
    public static final String ZTYSISUUUPRITUX6         = "ztysisuuupritux6";
    public static final String ZTYTMTTKNZOUKARITUSTRX6  = "ztytmttknzoukaritustrx6";
    public static final String ZTYKAWASERATEX6          = "ztykawaseratex6";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX7 = "ztytmttknsuiirirekikbnx7";
    public static final String ZTYKEIYAKUOUTOUBIX7      = "ztykeiyakuoutoubix7";
    public static final String ZTYTMTTKNJYOUTAIX7       = "ztytmttknjyoutaix7";
    public static final String ZTYPTUMITATEKNGKKTUUKAX7 = "ztyptumitatekngkktuukax7";
    public static final String ZTYPTUMITATEKNGKYENX7    = "ztyptumitatekngkyenx7";
    public static final String ZTYSISUUX7               = "ztysisuux7";
    public static final String ZTYSISUUUPRITUHUGOUX7    = "ztysisuuuprituhugoux7";
    public static final String ZTYSISUUUPRITUX7         = "ztysisuuupritux7";
    public static final String ZTYTMTTKNZOUKARITUSTRX7  = "ztytmttknzoukaritustrx7";
    public static final String ZTYKAWASERATEX7          = "ztykawaseratex7";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX8 = "ztytmttknsuiirirekikbnx8";
    public static final String ZTYKEIYAKUOUTOUBIX8      = "ztykeiyakuoutoubix8";
    public static final String ZTYTMTTKNJYOUTAIX8       = "ztytmttknjyoutaix8";
    public static final String ZTYPTUMITATEKNGKKTUUKAX8 = "ztyptumitatekngkktuukax8";
    public static final String ZTYPTUMITATEKNGKYENX8    = "ztyptumitatekngkyenx8";
    public static final String ZTYSISUUX8               = "ztysisuux8";
    public static final String ZTYSISUUUPRITUHUGOUX8    = "ztysisuuuprituhugoux8";
    public static final String ZTYSISUUUPRITUX8         = "ztysisuuupritux8";
    public static final String ZTYTMTTKNZOUKARITUSTRX8  = "ztytmttknzoukaritustrx8";
    public static final String ZTYKAWASERATEX8          = "ztykawaseratex8";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX9 = "ztytmttknsuiirirekikbnx9";
    public static final String ZTYKEIYAKUOUTOUBIX9      = "ztykeiyakuoutoubix9";
    public static final String ZTYTMTTKNJYOUTAIX9       = "ztytmttknjyoutaix9";
    public static final String ZTYPTUMITATEKNGKKTUUKAX9 = "ztyptumitatekngkktuukax9";
    public static final String ZTYPTUMITATEKNGKYENX9    = "ztyptumitatekngkyenx9";
    public static final String ZTYSISUUX9               = "ztysisuux9";
    public static final String ZTYSISUUUPRITUHUGOUX9    = "ztysisuuuprituhugoux9";
    public static final String ZTYSISUUUPRITUX9         = "ztysisuuupritux9";
    public static final String ZTYTMTTKNZOUKARITUSTRX9  = "ztytmttknzoukaritustrx9";
    public static final String ZTYKAWASERATEX9          = "ztykawaseratex9";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX10 = "ztytmttknsuiirirekikbnx10";
    public static final String ZTYKEIYAKUOUTOUBIX10     = "ztykeiyakuoutoubix10";
    public static final String ZTYTMTTKNJYOUTAIX10      = "ztytmttknjyoutaix10";
    public static final String ZTYPTUMITATEKNGKKTUUKAX10 = "ztyptumitatekngkktuukax10";
    public static final String ZTYPTUMITATEKNGKYENX10   = "ztyptumitatekngkyenx10";
    public static final String ZTYSISUUX10              = "ztysisuux10";
    public static final String ZTYSISUUUPRITUHUGOUX10   = "ztysisuuuprituhugoux10";
    public static final String ZTYSISUUUPRITUX10        = "ztysisuuupritux10";
    public static final String ZTYTMTTKNZOUKARITUSTRX10 = "ztytmttknzoukaritustrx10";
    public static final String ZTYKAWASERATEX10         = "ztykawaseratex10";
    public static final String ZTYTMTTKNSUIIRIREKIKBNX11 = "ztytmttknsuiirirekikbnx11";
    public static final String ZTYKEIYAKUOUTOUBIX11     = "ztykeiyakuoutoubix11";
    public static final String ZTYTMTTKNJYOUTAIX11      = "ztytmttknjyoutaix11";
    public static final String ZTYPTUMITATEKNGKKTUUKAX11 = "ztyptumitatekngkktuukax11";
    public static final String ZTYPTUMITATEKNGKYENX11   = "ztyptumitatekngkyenx11";
    public static final String ZTYSISUUX11              = "ztysisuux11";
    public static final String ZTYSISUUUPRITUHUGOUX11   = "ztysisuuuprituhugoux11";
    public static final String ZTYSISUUUPRITUX11        = "ztysisuuupritux11";
    public static final String ZTYTMTTKNZOUKARITUSTRX11 = "ztytmttknzoukaritustrx11";
    public static final String ZTYKAWASERATEX11         = "ztykawaseratex11";
    public static final String ZTYTMTTKNSUIIYOBI        = "ztytmttknsuiiyobi";
    public static final String ZTYTTDKKIGEN             = "ztyttdkkigen";
    public static final String ZTYKRNKGNSGK             = "ztykrnkgnsgk";
    public static final String ZTYTIRTITNTTDKYOBI       = "ztytirtitnttdkyobi";
    public static final String ZTYSKSHOZONNENSUU        = "ztyskshozonnensuu";
    public static final String ZTYDOCUMENTID            = "ztydocumentid";
    public static final String ZTYTORITUGISYASYOZOKUNM  = "ztytoritugisyasyozokunm";
    public static final String ZTYYENDTHNKHRSKSYOBI     = "ztyyendthnkhrsksyobi";
    public static final String ZTYYOTEIRIRITUKIJYUNYM1  = "ztyyoteiriritukijyunym1";
    public static final String ZTYYOTEIRIRITU1          = "ztyyoteiriritu1";
    public static final String ZTYYTIRRTCALCKIJYUNRRT1  = "ztyytirrtcalckijyunrrt1";
    public static final String ZTYKWSRATEKIJYUNYM1      = "ztykwsratekijyunym1";
    public static final String ZTYKAKNSNKWSRATE1        = "ztykaknsnkwsrate1";
    public static final String ZTYPGAIKA1               = "ztypgaika1";
    public static final String ZTYPYEN1                 = "ztypyen1";
    public static final String ZTYYOTEIRIRITUKIJYUNYM2  = "ztyyoteiriritukijyunym2";
    public static final String ZTYYOTEIRIRITU2          = "ztyyoteiriritu2";
    public static final String ZTYYTIRRTCALCKIJYUNRRT2  = "ztyytirrtcalckijyunrrt2";
    public static final String ZTYKWSRATEKIJYUNYM2      = "ztykwsratekijyunym2";
    public static final String ZTYKAKNSNKWSRATE2        = "ztykaknsnkwsrate2";
    public static final String ZTYPGAIKA2               = "ztypgaika2";
    public static final String ZTYPYEN2                 = "ztypyen2";
    public static final String ZTYYOTEIRIRITUKIJYUNYM3  = "ztyyoteiriritukijyunym3";
    public static final String ZTYYOTEIRIRITU3          = "ztyyoteiriritu3";
    public static final String ZTYYTIRRTCALCKIJYUNRRT3  = "ztyytirrtcalckijyunrrt3";
    public static final String ZTYKWSRATEKIJYUNYM3      = "ztykwsratekijyunym3";
    public static final String ZTYKAKNSNKWSRATE3        = "ztykaknsnkwsrate3";
    public static final String ZTYPGAIKA3               = "ztypgaika3";
    public static final String ZTYPYEN3                 = "ztypyen3";
    public static final String ZTYYOTEIRIRITUKIJYUNYM4  = "ztyyoteiriritukijyunym4";
    public static final String ZTYYOTEIRIRITU4          = "ztyyoteiriritu4";
    public static final String ZTYYTIRRTCALCKIJYUNRRT4  = "ztyytirrtcalckijyunrrt4";
    public static final String ZTYKWSRATEKIJYUNYM4      = "ztykwsratekijyunym4";
    public static final String ZTYKAKNSNKWSRATE4        = "ztykaknsnkwsrate4";
    public static final String ZTYPGAIKA4               = "ztypgaika4";
    public static final String ZTYPYEN4                 = "ztypyen4";
    public static final String ZTYYOTEIRIRITUKIJYUNYM5  = "ztyyoteiriritukijyunym5";
    public static final String ZTYYOTEIRIRITU5          = "ztyyoteiriritu5";
    public static final String ZTYYTIRRTCALCKIJYUNRRT5  = "ztyytirrtcalckijyunrrt5";
    public static final String ZTYKWSRATEKIJYUNYM5      = "ztykwsratekijyunym5";
    public static final String ZTYKAKNSNKWSRATE5        = "ztykaknsnkwsrate5";
    public static final String ZTYPGAIKA5               = "ztypgaika5";
    public static final String ZTYPYEN5                 = "ztypyen5";
    public static final String ZTYYOTEIRIRITUKIJYUNYM6  = "ztyyoteiriritukijyunym6";
    public static final String ZTYYOTEIRIRITU6          = "ztyyoteiriritu6";
    public static final String ZTYYTIRRTCALCKIJYUNRRT6  = "ztyytirrtcalckijyunrrt6";
    public static final String ZTYKWSRATEKIJYUNYM6      = "ztykwsratekijyunym6";
    public static final String ZTYKAKNSNKWSRATE6        = "ztykaknsnkwsrate6";
    public static final String ZTYPGAIKA6               = "ztypgaika6";
    public static final String ZTYPYEN6                 = "ztypyen6";
    public static final String ZTYYOTEIRIRITUKIJYUNYM7  = "ztyyoteiriritukijyunym7";
    public static final String ZTYYOTEIRIRITU7          = "ztyyoteiriritu7";
    public static final String ZTYYTIRRTCALCKIJYUNRRT7  = "ztyytirrtcalckijyunrrt7";
    public static final String ZTYKWSRATEKIJYUNYM7      = "ztykwsratekijyunym7";
    public static final String ZTYKAKNSNKWSRATE7        = "ztykaknsnkwsrate7";
    public static final String ZTYPGAIKA7               = "ztypgaika7";
    public static final String ZTYPYEN7                 = "ztypyen7";
    public static final String ZTYYOTEIRIRITUKIJYUNYM8  = "ztyyoteiriritukijyunym8";
    public static final String ZTYYOTEIRIRITU8          = "ztyyoteiriritu8";
    public static final String ZTYYTIRRTCALCKIJYUNRRT8  = "ztyytirrtcalckijyunrrt8";
    public static final String ZTYKWSRATEKIJYUNYM8      = "ztykwsratekijyunym8";
    public static final String ZTYKAKNSNKWSRATE8        = "ztykaknsnkwsrate8";
    public static final String ZTYPGAIKA8               = "ztypgaika8";
    public static final String ZTYPYEN8                 = "ztypyen8";
    public static final String ZTYYOTEIRIRITUKIJYUNYM9  = "ztyyoteiriritukijyunym9";
    public static final String ZTYYOTEIRIRITU9          = "ztyyoteiriritu9";
    public static final String ZTYYTIRRTCALCKIJYUNRRT9  = "ztyytirrtcalckijyunrrt9";
    public static final String ZTYKWSRATEKIJYUNYM9      = "ztykwsratekijyunym9";
    public static final String ZTYKAKNSNKWSRATE9        = "ztykaknsnkwsrate9";
    public static final String ZTYPGAIKA9               = "ztypgaika9";
    public static final String ZTYPYEN9                 = "ztypyen9";
    public static final String ZTYYOTEIRIRITUKIJYUNYM10 = "ztyyoteiriritukijyunym10";
    public static final String ZTYYOTEIRIRITU10         = "ztyyoteiriritu10";
    public static final String ZTYYTIRRTCALCKIJYUNRRT10 = "ztyytirrtcalckijyunrrt10";
    public static final String ZTYKWSRATEKIJYUNYM10     = "ztykwsratekijyunym10";
    public static final String ZTYKAKNSNKWSRATE10       = "ztykaknsnkwsrate10";
    public static final String ZTYPGAIKA10              = "ztypgaika10";
    public static final String ZTYPYEN10                = "ztypyen10";
    public static final String ZTYYOTEIRIRITUKIJYUNYM11 = "ztyyoteiriritukijyunym11";
    public static final String ZTYYOTEIRIRITU11         = "ztyyoteiriritu11";
    public static final String ZTYYTIRRTCALCKIJYUNRRT11 = "ztyytirrtcalckijyunrrt11";
    public static final String ZTYKWSRATEKIJYUNYM11     = "ztykwsratekijyunym11";
    public static final String ZTYKAKNSNKWSRATE11       = "ztykaknsnkwsrate11";
    public static final String ZTYPGAIKA11              = "ztypgaika11";
    public static final String ZTYPYEN11                = "ztypyen11";
    public static final String ZTYYOTEIRIRITUKIJYUNYM12 = "ztyyoteiriritukijyunym12";
    public static final String ZTYYOTEIRIRITU12         = "ztyyoteiriritu12";
    public static final String ZTYYTIRRTCALCKIJYUNRRT12 = "ztyytirrtcalckijyunrrt12";
    public static final String ZTYKWSRATEKIJYUNYM12     = "ztykwsratekijyunym12";
    public static final String ZTYKAKNSNKWSRATE12       = "ztykaknsnkwsrate12";
    public static final String ZTYPGAIKA12              = "ztypgaika12";
    public static final String ZTYPYEN12                = "ztypyen12";
    public static final String ZTYFSTPHYOUJIKBN1        = "ztyfstphyoujikbn1";
    public static final String ZTYFSTPHYOUJIKBN2        = "ztyfstphyoujikbn2";
    public static final String ZTYFSTPHYOUJIKBN3        = "ztyfstphyoujikbn3";
    public static final String ZTYFSTPHYOUJIKBN4        = "ztyfstphyoujikbn4";
    public static final String ZTYFSTPHYOUJIKBN5        = "ztyfstphyoujikbn5";
    public static final String ZTYFSTPHYOUJIKBN6        = "ztyfstphyoujikbn6";
    public static final String ZTYFSTPHYOUJIKBN7        = "ztyfstphyoujikbn7";
    public static final String ZTYFSTPHYOUJIKBN8        = "ztyfstphyoujikbn8";
    public static final String ZTYFSTPHYOUJIKBN9        = "ztyfstphyoujikbn9";
    public static final String ZTYFSTPHYOUJIKBN10       = "ztyfstphyoujikbn10";
    public static final String ZTYFSTPHYOUJIKBN11       = "ztyfstphyoujikbn11";
    public static final String ZTYFSTPHYOUJIKBN12       = "ztyfstphyoujikbn12";
    public static final String ZTYYTIRRTITRNYOBI2       = "ztyytirrtitrnyobi2";
    public static final String ZTYYTIRRTITRNHSKMSGCD1   = "ztyytirrtitrnhskmsgcd1";
    public static final String ZTYYTIRRTITRNHSKMSGCD2   = "ztyytirrtitrnhskmsgcd2";
    public static final String ZTYYTIRRTITRNHSKMSGCD3   = "ztyytirrtitrnhskmsgcd3";
    public static final String ZTYYTIRRTITRNHSKMSGCD4   = "ztyytirrtitrnhskmsgcd4";
    public static final String ZTYYTIRRTITRNHSKMSGCD5   = "ztyytirrtitrnhskmsgcd5";
    public static final String ZTYYTIRRTITRNHSKMSGCD6   = "ztyytirrtitrnhskmsgcd6";
    public static final String ZTYYTIRRTITRNHSKMSGCD7   = "ztyytirrtitrnhskmsgcd7";
    public static final String ZTYYTIRRTITRNHSKMSGCD8   = "ztyytirrtitrnhskmsgcd8";
    public static final String ZTYYTIRRTITRNYOBI        = "ztyytirrtitrnyobi";

    private final PKZT_GaikaKokyakuTuutiTy primaryKey;

    public GenZT_GaikaKokyakuTuutiTy() {
        primaryKey = new PKZT_GaikaKokyakuTuutiTy();
    }

    public GenZT_GaikaKokyakuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        primaryKey = new PKZT_GaikaKokyakuTuutiTy(pZtytyouhyouymd, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_GaikaKokyakuTuutiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_GaikaKokyakuTuutiTy> getMetaClass() {
        return QZT_GaikaKokyakuTuutiTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    @Id
    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztysclatosyono;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztydskaiyktirasidouhuukbn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYDSKAIYKTIRASIDOUHUUKBN)
    public String getZtydskaiyktirasidouhuukbn() {
        return ztydskaiyktirasidouhuukbn;
    }

    public void setZtydskaiyktirasidouhuukbn(String pZtydskaiyktirasidouhuukbn) {
        ztydskaiyktirasidouhuukbn = pZtydskaiyktirasidouhuukbn;
    }

    private String ztyhrknkanssiryodouhuukbn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHRKNKANSSIRYODOUHUUKBN)
    public String getZtyhrknkanssiryodouhuukbn() {
        return ztyhrknkanssiryodouhuukbn;
    }

    public void setZtyhrknkanssiryodouhuukbn(String pZtyhrknkanssiryodouhuukbn) {
        ztyhrknkanssiryodouhuukbn = pZtyhrknkanssiryodouhuukbn;
    }

    private String ztyassistplustirasidhkbn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYASSISTPLUSTIRASIDHKBN)
    public String getZtyassistplustirasidhkbn() {
        return ztyassistplustirasidhkbn;
    }

    public void setZtyassistplustirasidhkbn(String pZtyassistplustirasidhkbn) {
        ztyassistplustirasidhkbn = pZtyassistplustirasidhkbn;
    }

    private String ztykoktuutireportlayoutptn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKOKTUUTIREPORTLAYOUTPTN)
    public String getZtykoktuutireportlayoutptn() {
        return ztykoktuutireportlayoutptn;
    }

    public void setZtykoktuutireportlayoutptn(String pZtykoktuutireportlayoutptn) {
        ztykoktuutireportlayoutptn = pZtykoktuutireportlayoutptn;
    }

    private String ztygengkumu;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYGENGKUMU)
    public String getZtygengkumu() {
        return ztygengkumu;
    }

    public void setZtygengkumu(String pZtygengkumu) {
        ztygengkumu = pZtygengkumu;
    }

    private String ztykytkmkyobi1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKYTKMKYOBI1)
    public String getZtykytkmkyobi1() {
        return ztykytkmkyobi1;
    }

    public void setZtykytkmkyobi1(String pZtykytkmkyobi1) {
        ztykytkmkyobi1 = pZtykytkmkyobi1;
    }

    private String ztytuusinsakiyuubinno;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTUUSINSAKIYUUBINNO)
    public String getZtytuusinsakiyuubinno() {
        return ztytuusinsakiyuubinno;
    }

    public void setZtytuusinsakiyuubinno(String pZtytuusinsakiyuubinno) {
        ztytuusinsakiyuubinno = pZtytuusinsakiyuubinno;
    }

    private String ztytsinadr1kj;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTSINADR1KJ)
    public String getZtytsinadr1kj() {
        return ztytsinadr1kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setZtytsinadr1kj(String pZtytsinadr1kj) {
        ztytsinadr1kj = pZtytsinadr1kj;
    }

    private String ztytsinadr2kj;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTSINADR2KJ)
    public String getZtytsinadr2kj() {
        return ztytsinadr2kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setZtytsinadr2kj(String pZtytsinadr2kj) {
        ztytsinadr2kj = pZtytsinadr2kj;
    }

    private String ztytsinadr3kj;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTSINADR3KJ)
    public String getZtytsinadr3kj() {
        return ztytsinadr3kj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setZtytsinadr3kj(String pZtytsinadr3kj) {
        ztytsinadr3kj = pZtytsinadr3kj;
    }

    private String ztytsintelno;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTSINTELNO)
    public String getZtytsintelno() {
        return ztytsintelno;
    }

    public void setZtytsintelno(String pZtytsintelno) {
        ztytsintelno = pZtytsintelno;
    }

    private String ztytsinnm18;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTSINNM18)
    public String getZtytsinnm18() {
        return ztytsinnm18;
    }

    public void setZtytsinnm18(String pZtytsinnm18) {
        ztytsinnm18 = pZtytsinnm18;
    }

    private String ztyyobiv19;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOBIV19)
    public String getZtyyobiv19() {
        return ztyyobiv19;
    }

    public void setZtyyobiv19(String pZtyyobiv19) {
        ztyyobiv19 = pZtyyobiv19;
    }

    private String ztysyoukaisakidrtennm1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSYOUKAISAKIDRTENNM1)
    public String getZtysyoukaisakidrtennm1() {
        return ztysyoukaisakidrtennm1;
    }

    public void setZtysyoukaisakidrtennm1(String pZtysyoukaisakidrtennm1) {
        ztysyoukaisakidrtennm1 = pZtysyoukaisakidrtennm1;
    }

    private String ztysyoukaisakidrtennm2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSYOUKAISAKIDRTENNM2)
    public String getZtysyoukaisakidrtennm2() {
        return ztysyoukaisakidrtennm2;
    }

    public void setZtysyoukaisakidrtennm2(String pZtysyoukaisakidrtennm2) {
        ztysyoukaisakidrtennm2 = pZtysyoukaisakidrtennm2;
    }

    private String ztyyobiv20;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOBIV20)
    public String getZtyyobiv20() {
        return ztyyobiv20;
    }

    public void setZtyyobiv20(String pZtyyobiv20) {
        ztyyobiv20 = pZtyyobiv20;
    }

    private String ztyaisatumsgcd1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYAISATUMSGCD1)
    public String getZtyaisatumsgcd1() {
        return ztyaisatumsgcd1;
    }

    public void setZtyaisatumsgcd1(String pZtyaisatumsgcd1) {
        ztyaisatumsgcd1 = pZtyaisatumsgcd1;
    }

    private String ztyaisatumsgcd2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYAISATUMSGCD2)
    public String getZtyaisatumsgcd2() {
        return ztyaisatumsgcd2;
    }

    public void setZtyaisatumsgcd2(String pZtyaisatumsgcd2) {
        ztyaisatumsgcd2 = pZtyaisatumsgcd2;
    }

    private String ztyaisatumsgcd3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYAISATUMSGCD3)
    public String getZtyaisatumsgcd3() {
        return ztyaisatumsgcd3;
    }

    public void setZtyaisatumsgcd3(String pZtyaisatumsgcd3) {
        ztyaisatumsgcd3 = pZtyaisatumsgcd3;
    }

    private String ztyosirasetuutisakuseiymwa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYOSIRASETUUTISAKUSEIYMWA)
    public String getZtyosirasetuutisakuseiymwa() {
        return ztyosirasetuutisakuseiymwa;
    }

    public void setZtyosirasetuutisakuseiymwa(String pZtyosirasetuutisakuseiymwa) {
        ztyosirasetuutisakuseiymwa = pZtyosirasetuutisakuseiymwa;
    }

    private String ztysyono2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztyaisyoumeikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYAISYOUMEIKBN)
    public String getZtyaisyoumeikbn() {
        return ztyaisyoumeikbn;
    }

    public void setZtyaisyoumeikbn(String pZtyaisyoumeikbn) {
        ztyaisyoumeikbn = pZtyaisyoumeikbn;
    }

    private String ztykyknmkj18;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKYKNMKJ18)
    public String getZtykyknmkj18() {
        return ztykyknmkj18;
    }

    public void setZtykyknmkj18(String pZtykyknmkj18) {
        ztykyknmkj18 = pZtykyknmkj18;
    }

    private String ztyhhknnmkj18;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHHKNNMKJ18)
    public String getZtyhhknnmkj18() {
        return ztyhhknnmkj18;
    }

    public void setZtyhhknnmkj18(String pZtyhhknnmkj18) {
        ztyhhknnmkj18 = pZtyhhknnmkj18;
    }

    private String ztyuktmidasikbn1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTMIDASIKBN1)
    public String getZtyuktmidasikbn1() {
        return ztyuktmidasikbn1;
    }

    public void setZtyuktmidasikbn1(String pZtyuktmidasikbn1) {
        ztyuktmidasikbn1 = pZtyuktmidasikbn1;
    }

    private String ztyuktkbn1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTKBN1)
    public String getZtyuktkbn1() {
        return ztyuktkbn1;
    }

    public void setZtyuktkbn1(String pZtyuktkbn1) {
        ztyuktkbn1 = pZtyuktkbn1;
    }

    private String ztyuktnm118;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTNM118)
    public String getZtyuktnm118() {
        return ztyuktnm118;
    }

    public void setZtyuktnm118(String pZtyuktnm118) {
        ztyuktnm118 = pZtyuktnm118;
    }

    private String ztyuktmidasikbn2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTMIDASIKBN2)
    public String getZtyuktmidasikbn2() {
        return ztyuktmidasikbn2;
    }

    public void setZtyuktmidasikbn2(String pZtyuktmidasikbn2) {
        ztyuktmidasikbn2 = pZtyuktmidasikbn2;
    }

    private String ztyuktkbn2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTKBN2)
    public String getZtyuktkbn2() {
        return ztyuktkbn2;
    }

    public void setZtyuktkbn2(String pZtyuktkbn2) {
        ztyuktkbn2 = pZtyuktkbn2;
    }

    private String ztyuktnm218;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTNM218)
    public String getZtyuktnm218() {
        return ztyuktnm218;
    }

    public void setZtyuktnm218(String pZtyuktnm218) {
        ztyuktnm218 = pZtyuktnm218;
    }

    private String ztyuktmidasikbn3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTMIDASIKBN3)
    public String getZtyuktmidasikbn3() {
        return ztyuktmidasikbn3;
    }

    public void setZtyuktmidasikbn3(String pZtyuktmidasikbn3) {
        ztyuktmidasikbn3 = pZtyuktmidasikbn3;
    }

    private String ztyuktkbn3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTKBN3)
    public String getZtyuktkbn3() {
        return ztyuktkbn3;
    }

    public void setZtyuktkbn3(String pZtyuktkbn3) {
        ztyuktkbn3 = pZtyuktkbn3;
    }

    private String ztyuktnm318;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTNM318)
    public String getZtyuktnm318() {
        return ztyuktnm318;
    }

    public void setZtyuktnm318(String pZtyuktnm318) {
        ztyuktnm318 = pZtyuktnm318;
    }

    private String ztyuktmidasikbn4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTMIDASIKBN4)
    public String getZtyuktmidasikbn4() {
        return ztyuktmidasikbn4;
    }

    public void setZtyuktmidasikbn4(String pZtyuktmidasikbn4) {
        ztyuktmidasikbn4 = pZtyuktmidasikbn4;
    }

    private String ztyuktkbn4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTKBN4)
    public String getZtyuktkbn4() {
        return ztyuktkbn4;
    }

    public void setZtyuktkbn4(String pZtyuktkbn4) {
        ztyuktkbn4 = pZtyuktkbn4;
    }

    private String ztyuktnm418;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTNM418)
    public String getZtyuktnm418() {
        return ztyuktnm418;
    }

    public void setZtyuktnm418(String pZtyuktnm418) {
        ztyuktnm418 = pZtyuktnm418;
    }

    private String ztyuktmidasikbn5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTMIDASIKBN5)
    public String getZtyuktmidasikbn5() {
        return ztyuktmidasikbn5;
    }

    public void setZtyuktmidasikbn5(String pZtyuktmidasikbn5) {
        ztyuktmidasikbn5 = pZtyuktmidasikbn5;
    }

    private String ztyuktkbn5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTKBN5)
    public String getZtyuktkbn5() {
        return ztyuktkbn5;
    }

    public void setZtyuktkbn5(String pZtyuktkbn5) {
        ztyuktkbn5 = pZtyuktkbn5;
    }

    private String ztyuktnm518;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYUKTNM518)
    public String getZtyuktnm518() {
        return ztyuktnm518;
    }

    public void setZtyuktnm518(String pZtyuktnm518) {
        ztyuktnm518 = pZtyuktnm518;
    }

    private String ztykykymdwa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKYKYMDWA)
    public String getZtykykymdwa() {
        return ztykykymdwa;
    }

    public void setZtykykymdwa(String pZtykykymdwa) {
        ztykykymdwa = pZtykykymdwa;
    }

    private String ztydai1hknkknfromwa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYDAI1HKNKKNFROMWA)
    public String getZtydai1hknkknfromwa() {
        return ztydai1hknkknfromwa;
    }

    public void setZtydai1hknkknfromwa(String pZtydai1hknkknfromwa) {
        ztydai1hknkknfromwa = pZtydai1hknkknfromwa;
    }

    private String ztydai1hknkkn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYDAI1HKNKKN)
    public String getZtydai1hknkkn() {
        return ztydai1hknkkn;
    }

    public void setZtydai1hknkkn(String pZtydai1hknkkn) {
        ztydai1hknkkn = pZtydai1hknkkn;
    }

    private String ztydai2hknkknfromwa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYDAI2HKNKKNFROMWA)
    public String getZtydai2hknkknfromwa() {
        return ztydai2hknkknfromwa;
    }

    public void setZtydai2hknkknfromwa(String pZtydai2hknkknfromwa) {
        ztydai2hknkknfromwa = pZtydai2hknkknfromwa;
    }

    private String ztydai2hknkkntowa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYDAI2HKNKKNTOWA)
    public String getZtydai2hknkkntowa() {
        return ztydai2hknkkntowa;
    }

    public void setZtydai2hknkkntowa(String pZtydai2hknkkntowa) {
        ztydai2hknkkntowa = pZtydai2hknkkntowa;
    }

    private String ztydai3hknkknfromwa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYDAI3HKNKKNFROMWA)
    public String getZtydai3hknkknfromwa() {
        return ztydai3hknkknfromwa;
    }

    public void setZtydai3hknkknfromwa(String pZtydai3hknkknfromwa) {
        ztydai3hknkknfromwa = pZtydai3hknkknfromwa;
    }

    private String ztydai3hknkknto;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYDAI3HKNKKNTO)
    public String getZtydai3hknkknto() {
        return ztydai3hknkknto;
    }

    public void setZtydai3hknkknto(String pZtydai3hknkknto) {
        ztydai3hknkknto = pZtydai3hknkknto;
    }

    private String ztykyktuukasyuzn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKYKTUUKASYUZN)
    public String getZtykyktuukasyuzn() {
        return ztykyktuukasyuzn;
    }

    public void setZtykyktuukasyuzn(String pZtykyktuukasyuzn) {
        ztykyktuukasyuzn = pZtykyktuukasyuzn;
    }

    private String ztykyktuukatype;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKYKTUUKATYPE)
    public String getZtykyktuukatype() {
        return ztykyktuukatype;
    }

    public void setZtykyktuukatype(String pZtykyktuukatype) {
        ztykyktuukatype = pZtykyktuukatype;
    }

    private String ztytk1msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTK1MSGCD)
    public String getZtytk1msgcd() {
        return ztytk1msgcd;
    }

    public void setZtytk1msgcd(String pZtytk1msgcd) {
        ztytk1msgcd = pZtytk1msgcd;
    }

    private String ztytk2msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTK2MSGCD)
    public String getZtytk2msgcd() {
        return ztytk2msgcd;
    }

    public void setZtytk2msgcd(String pZtytk2msgcd) {
        ztytk2msgcd = pZtytk2msgcd;
    }

    private String ztytk3msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTK3MSGCD)
    public String getZtytk3msgcd() {
        return ztytk3msgcd;
    }

    public void setZtytk3msgcd(String pZtytk3msgcd) {
        ztytk3msgcd = pZtytk3msgcd;
    }

    private String ztytk4msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTK4MSGCD)
    public String getZtytk4msgcd() {
        return ztytk4msgcd;
    }

    public void setZtytk4msgcd(String pZtytk4msgcd) {
        ztytk4msgcd = pZtytk4msgcd;
    }

    private String ztytk5msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTK5MSGCD)
    public String getZtytk5msgcd() {
        return ztytk5msgcd;
    }

    public void setZtytk5msgcd(String pZtytk5msgcd) {
        ztytk5msgcd = pZtytk5msgcd;
    }

    private String ztytk6msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTK6MSGCD)
    public String getZtytk6msgcd() {
        return ztytk6msgcd;
    }

    public void setZtytk6msgcd(String pZtytk6msgcd) {
        ztytk6msgcd = pZtytk6msgcd;
    }

    private String ztytk7msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTK7MSGCD)
    public String getZtytk7msgcd() {
        return ztytk7msgcd;
    }

    public void setZtytk7msgcd(String pZtytk7msgcd) {
        ztytk7msgcd = pZtytk7msgcd;
    }

    private String ztytk8msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTK8MSGCD)
    public String getZtytk8msgcd() {
        return ztytk8msgcd;
    }

    public void setZtytk8msgcd(String pZtytk8msgcd) {
        ztytk8msgcd = pZtytk8msgcd;
    }

    private String ztytk9msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTK9MSGCD)
    public String getZtytk9msgcd() {
        return ztytk9msgcd;
    }

    public void setZtytk9msgcd(String pZtytk9msgcd) {
        ztytk9msgcd = pZtytk9msgcd;
    }

    private String ztytk10msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTK10MSGCD)
    public String getZtytk10msgcd() {
        return ztytk10msgcd;
    }

    public void setZtytk10msgcd(String pZtytk10msgcd) {
        ztytk10msgcd = pZtytk10msgcd;
    }

    private String ztydstourokujyou;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYDSTOUROKUJYOU)
    public String getZtydstourokujyou() {
        return ztydstourokujyou;
    }

    public void setZtydstourokujyou(String pZtydstourokujyou) {
        ztydstourokujyou = pZtydstourokujyou;
    }

    private String ztysd1msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSD1MSGCD)
    public String getZtysd1msgcd() {
        return ztysd1msgcd;
    }

    public void setZtysd1msgcd(String pZtysd1msgcd) {
        ztysd1msgcd = pZtysd1msgcd;
    }

    private String ztysd2msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSD2MSGCD)
    public String getZtysd2msgcd() {
        return ztysd2msgcd;
    }

    public void setZtysd2msgcd(String pZtysd2msgcd) {
        ztysd2msgcd = pZtysd2msgcd;
    }

    private String ztysd3msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSD3MSGCD)
    public String getZtysd3msgcd() {
        return ztysd3msgcd;
    }

    public void setZtysd3msgcd(String pZtysd3msgcd) {
        ztysd3msgcd = pZtysd3msgcd;
    }

    private String ztykrpassword;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKRPASSWORD)
    public String getZtykrpassword() {
        return ztykrpassword;
    }

    public void setZtykrpassword(String pZtykrpassword) {
        ztykrpassword = pZtykrpassword;
    }

    private String ztyyuukoukigenwareki;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYUUKOUKIGENWAREKI)
    public String getZtyyuukoukigenwareki() {
        return ztyyuukoukigenwareki;
    }

    public void setZtyyuukoukigenwareki(String pZtyyuukoukigenwareki) {
        ztyyuukoukigenwareki = pZtyyuukoukigenwareki;
    }

    private String ztykzktrkjk;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKZKTRKJK)
    public String getZtykzktrkjk() {
        return ztykzktrkjk;
    }

    public void setZtykzktrkjk(String pZtykzktrkjk) {
        ztykzktrkjk = pZtykzktrkjk;
    }

    private String ztytrkkzknm118;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTRKKZKNM118)
    public String getZtytrkkzknm118() {
        return ztytrkkzknm118;
    }

    public void setZtytrkkzknm118(String pZtytrkkzknm118) {
        ztytrkkzknm118 = pZtytrkkzknm118;
    }

    private String ztytrkkzknm218;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTRKKZKNM218)
    public String getZtytrkkzknm218() {
        return ztytrkkzknm218;
    }

    public void setZtytrkkzknm218(String pZtytrkkzknm218) {
        ztytrkkzknm218 = pZtytrkkzknm218;
    }

    private String ztyyendthnkymd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYENDTHNKYMD)
    public String getZtyyendthnkymd() {
        return ztyyendthnkymd;
    }

    public void setZtyyendthnkymd(String pZtyyendthnkymd) {
        ztyyendthnkymd = pZtyyendthnkymd;
    }

    private String ztynkshrstartymdstr;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNKSHRSTARTYMDSTR)
    public String getZtynkshrstartymdstr() {
        return ztynkshrstartymdstr;
    }

    public void setZtynkshrstartymdstr(String pZtynkshrstartymdstr) {
        ztynkshrstartymdstr = pZtynkshrstartymdstr;
    }

    private String ztynenkinstartnen;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNENKINSTARTNEN)
    public String getZtynenkinstartnen() {
        return ztynenkinstartnen;
    }

    public void setZtynenkinstartnen(String pZtynenkinstartnen) {
        ztynenkinstartnen = pZtynenkinstartnen;
    }

    private String ztynksyuruinm;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNKSYURUINM)
    public String getZtynksyuruinm() {
        return ztynksyuruinm;
    }

    public void setZtynksyuruinm(String pZtynksyuruinm) {
        ztynksyuruinm = pZtynksyuruinm;
    }

    private String ztyhrkkaisuu;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHRKKAISUU)
    public String getZtyhrkkaisuu() {
        return ztyhrkkaisuu;
    }

    public void setZtyhrkkaisuu(String pZtyhrkkaisuu) {
        ztyhrkkaisuu = pZtyhrkkaisuu;
    }

    private String ztytikiktbrisyuruikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTIKIKTBRISYURUIKBN)
    public String getZtytikiktbrisyuruikbn() {
        return ztytikiktbrisyuruikbn;
    }

    public void setZtytikiktbrisyuruikbn(String pZtytikiktbrisyuruikbn) {
        ztytikiktbrisyuruikbn = pZtytikiktbrisyuruikbn;
    }

    private String ztyzennouumu;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYZENNOUUMU)
    public String getZtyzennouumu() {
        return ztyzennouumu;
    }

    public void setZtyzennouumu(String pZtyzennouumu) {
        ztyzennouumu = pZtyzennouumu;
    }

    private String ztyhrkkeiro;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHRKKEIRO)
    public String getZtyhrkkeiro() {
        return ztyhrkkeiro;
    }

    public void setZtyhrkkeiro(String pZtyhrkkeiro) {
        ztyhrkkeiro = pZtyhrkkeiro;
    }

    private String ztyphrkkkn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPHRKKKN)
    public String getZtyphrkkkn() {
        return ztyphrkkkn;
    }

    public void setZtyphrkkkn(String pZtyphrkkkn) {
        ztyphrkkkn = pZtyphrkkkn;
    }

    private String ztysueokikkn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSUEOKIKKN)
    public String getZtysueokikkn() {
        return ztysueokikkn;
    }

    public void setZtysueokikkn(String pZtysueokikkn) {
        ztysueokikkn = pZtysueokikkn;
    }

    private String ztyyakkanbunsyono;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYAKKANBUNSYONO)
    public String getZtyyakkanbunsyono() {
        return ztyyakkanbunsyono;
    }

    public void setZtyyakkanbunsyono(String pZtyyakkanbunsyono) {
        ztyyakkanbunsyono = pZtyyakkanbunsyono;
    }

    private String ztygkykniyuosiraseyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYGKYKNIYUOSIRASEYOBI)
    public String getZtygkykniyuosiraseyobi() {
        return ztygkykniyuosiraseyobi;
    }

    public void setZtygkykniyuosiraseyobi(String pZtygkykniyuosiraseyobi) {
        ztygkykniyuosiraseyobi = pZtygkykniyuosiraseyobi;
    }

    private String ztysakuseikijyunymdwa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSAKUSEIKIJYUNYMDWA)
    public String getZtysakuseikijyunymdwa() {
        return ztysakuseikijyunymdwa;
    }

    public void setZtysakuseikijyunymdwa(String pZtysakuseikijyunymdwa) {
        ztysakuseikijyunymdwa = pZtysakuseikijyunymdwa;
    }

    private String ztyitijibrpkyktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYITIJIBRPKYKTUUKA)
    public String getZtyitijibrpkyktuuka() {
        return ztyitijibrpkyktuuka;
    }

    public void setZtyitijibrpkyktuuka(String pZtyitijibrpkyktuuka) {
        ztyitijibrpkyktuuka = pZtyitijibrpkyktuuka;
    }

    private String ztykihonsktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKIHONSKTUUKA)
    public String getZtykihonsktuuka() {
        return ztykihonsktuuka;
    }

    public void setZtykihonsktuuka(String pZtykihonsktuuka) {
        ztykihonsktuuka = pZtykihonsktuuka;
    }

    private String ztyyenhrkgk;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYENHRKGK)
    public String getZtyyenhrkgk() {
        return ztyyenhrkgk;
    }

    public void setZtyyenhrkgk(String pZtyyenhrkgk) {
        ztyyenhrkgk = pZtyyenhrkgk;
    }

    private String ztystigituukahrkgk;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSTIGITUUKAHRKGK)
    public String getZtystigituukahrkgk() {
        return ztystigituukahrkgk;
    }

    public void setZtystigituukahrkgk(String pZtystigituukahrkgk) {
        ztystigituukahrkgk = pZtystigituukahrkgk;
    }

    private String ztyhrktuukasyuzn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHRKTUUKASYUZN)
    public String getZtyhrktuukasyuzn() {
        return ztyhrktuukasyuzn;
    }

    public void setZtyhrktuukasyuzn(String pZtyhrktuukasyuzn) {
        ztyhrktuukasyuzn = pZtyhrktuukasyuzn;
    }

    private String ztyhrktuukatype;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHRKTUUKATYPE)
    public String getZtyhrktuukatype() {
        return ztyhrktuukatype;
    }

    public void setZtyhrktuukatype(String pZtyhrktuukatype) {
        ztyhrktuukatype = pZtyhrktuukatype;
    }

    private String ztyyenkhrikmrate;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYENKHRIKMRATE)
    public String getZtyyenkhrikmrate() {
        return ztyyenkhrikmrate;
    }

    public void setZtyyenkhrikmrate(String pZtyyenkhrikmrate) {
        ztyyenkhrikmrate = pZtyyenkhrikmrate;
    }

    private String ztystigikwsrate;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSTIGIKWSRATE)
    public String getZtystigikwsrate() {
        return ztystigikwsrate;
    }

    public void setZtystigikwsrate(String pZtystigikwsrate) {
        ztystigikwsrate = pZtystigikwsrate;
    }

    private String ztyhrkgkhyoujikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHRKGKHYOUJIKBN)
    public String getZtyhrkgkhyoujikbn() {
        return ztyhrkgkhyoujikbn;
    }

    public void setZtyhrkgkhyoujikbn(String pZtyhrkgkhyoujikbn) {
        ztyhrkgkhyoujikbn = pZtyhrkgkhyoujikbn;
    }

    private String ztykijyunkingaku;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKIJYUNKINGAKU)
    public String getZtykijyunkingaku() {
        return ztykijyunkingaku;
    }

    public void setZtykijyunkingaku(String pZtykijyunkingaku) {
        ztykijyunkingaku = pZtykijyunkingaku;
    }

    private String ztykjnkngkkawaserate;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKJNKNGKKAWASERATE)
    public String getZtykjnkngkkawaserate() {
        return ztykjnkngkkawaserate;
    }

    public void setZtykjnkngkkawaserate(String pZtykjnkngkkawaserate) {
        ztykjnkngkkawaserate = pZtykjnkngkkawaserate;
    }

    private String ztykjnkngkhyoujikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKJNKNGKHYOUJIKBN)
    public String getZtykjnkngkhyoujikbn() {
        return ztykjnkngkhyoujikbn;
    }

    public void setZtykjnkngkhyoujikbn(String pZtykjnkngkhyoujikbn) {
        ztykjnkngkhyoujikbn = pZtykjnkngkhyoujikbn;
    }

    private String ztysakuseikijyunymdkwsrate;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSAKUSEIKIJYUNYMDKWSRATE)
    public String getZtysakuseikijyunymdkwsrate() {
        return ztysakuseikijyunymdkwsrate;
    }

    public void setZtysakuseikijyunymdkwsrate(String pZtysakuseikijyunymdkwsrate) {
        ztysakuseikijyunymdkwsrate = pZtysakuseikijyunymdkwsrate;
    }

    private String ztysbhknkngkhknkkn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSBHKNKNGKHKNKKN)
    public String getZtysbhknkngkhknkkn() {
        return ztysbhknkngkhknkkn;
    }

    public void setZtysbhknkngkhknkkn(String pZtysbhknkngkhknkkn) {
        ztysbhknkngkhknkkn = pZtysbhknkngkhknkkn;
    }

    private String ztysbhknkngkhknkknfromwa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSBHKNKNGKHKNKKNFROMWA)
    public String getZtysbhknkngkhknkknfromwa() {
        return ztysbhknkngkhknkknfromwa;
    }

    public void setZtysbhknkngkhknkknfromwa(String pZtysbhknkngkhknkknfromwa) {
        ztysbhknkngkhknkknfromwa = pZtysbhknkngkhknkknfromwa;
    }

    private String ztysbhknkngkhknkkntowa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSBHKNKNGKHKNKKNTOWA)
    public String getZtysbhknkngkhknkkntowa() {
        return ztysbhknkngkhknkkntowa;
    }

    public void setZtysbhknkngkhknkkntowa(String pZtysbhknkngkhknkkntowa) {
        ztysbhknkngkhknkkntowa = pZtysbhknkngkhknkkntowa;
    }

    private String ztysbhknkngkkyktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSBHKNKNGKKYKTUUKA)
    public String getZtysbhknkngkkyktuuka() {
        return ztysbhknkngkkyktuuka;
    }

    public void setZtysbhknkngkkyktuuka(String pZtysbhknkngkkyktuuka) {
        ztysbhknkngkkyktuuka = pZtysbhknkngkkyktuuka;
    }

    private String ztysbhknkngkyen;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSBHKNKNGKYEN)
    public String getZtysbhknkngkyen() {
        return ztysbhknkngkyen;
    }

    public void setZtysbhknkngkyen(String pZtysbhknkngkyen) {
        ztysbhknkngkyen = pZtysbhknkngkyen;
    }

    private String ztysaigaisbhknkngakuumu;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSAIGAISBHKNKNGAKUUMU)
    public String getZtysaigaisbhknkngakuumu() {
        return ztysaigaisbhknkngakuumu;
    }

    public void setZtysaigaisbhknkngakuumu(String pZtysaigaisbhknkngakuumu) {
        ztysaigaisbhknkngakuumu = pZtysaigaisbhknkngakuumu;
    }

    private String ztysaigaisbhknkngakuktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSAIGAISBHKNKNGAKUKTUUKA)
    public String getZtysaigaisbhknkngakuktuuka() {
        return ztysaigaisbhknkngakuktuuka;
    }

    public void setZtysaigaisbhknkngakuktuuka(String pZtysaigaisbhknkngakuktuuka) {
        ztysaigaisbhknkngakuktuuka = pZtysaigaisbhknkngakuktuuka;
    }

    private String ztysaigaisbhknkngakukyen;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSAIGAISBHKNKNGAKUKYEN)
    public String getZtysaigaisbhknkngakukyen() {
        return ztysaigaisbhknkngakukyen;
    }

    public void setZtysaigaisbhknkngakukyen(String pZtysaigaisbhknkngakukyen) {
        ztysaigaisbhknkngakukyen = pZtysaigaisbhknkngakukyen;
    }

    private String ztytumitatekngkktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTUMITATEKNGKKTUUKA)
    public String getZtytumitatekngkktuuka() {
        return ztytumitatekngkktuuka;
    }

    public void setZtytumitatekngkktuuka(String pZtytumitatekngkktuuka) {
        ztytumitatekngkktuuka = pZtytumitatekngkktuuka;
    }

    private String ztytumitatekngkkyen;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTUMITATEKNGKKYEN)
    public String getZtytumitatekngkkyen() {
        return ztytumitatekngkkyen;
    }

    public void setZtytumitatekngkkyen(String pZtytumitatekngkkyen) {
        ztytumitatekngkkyen = pZtytumitatekngkkyen;
    }

    private String ztykaiyakuhrkngakkyktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAIYAKUHRKNGAKKYKTUUKA)
    public String getZtykaiyakuhrkngakkyktuuka() {
        return ztykaiyakuhrkngakkyktuuka;
    }

    public void setZtykaiyakuhrkngakkyktuuka(String pZtykaiyakuhrkngakkyktuuka) {
        ztykaiyakuhrkngakkyktuuka = pZtykaiyakuhrkngakkyktuuka;
    }

    private String ztykaiyakuhrkngakyen;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAIYAKUHRKNGAKYEN)
    public String getZtykaiyakuhrkngakyen() {
        return ztykaiyakuhrkngakyen;
    }

    public void setZtykaiyakuhrkngakyen(String pZtykaiyakuhrkngakyen) {
        ztykaiyakuhrkngakyen = pZtykaiyakuhrkngakyen;
    }

    private String ztymkhgkyen;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYMKHGKYEN)
    public String getZtymkhgkyen() {
        return ztymkhgkyen;
    }

    public void setZtymkhgkyen(String pZtymkhgkyen) {
        ztymkhgkyen = pZtymkhgkyen;
    }

    private String ztymkhgkwari;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYMKHGKWARI)
    public String getZtymkhgkwari() {
        return ztymkhgkwari;
    }

    public void setZtymkhgkwari(String pZtymkhgkwari) {
        ztymkhgkwari = pZtymkhgkwari;
    }

    private String ztymkhgkhyoujikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYMKHGKHYOUJIKBN)
    public String getZtymkhgkhyoujikbn() {
        return ztymkhgkhyoujikbn;
    }

    public void setZtymkhgkhyoujikbn(String pZtymkhgkhyoujikbn) {
        ztymkhgkhyoujikbn = pZtymkhgkhyoujikbn;
    }

    private String ztyhosyouhskmsgcd1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHOSYOUHSKMSGCD1)
    public String getZtyhosyouhskmsgcd1() {
        return ztyhosyouhskmsgcd1;
    }

    public void setZtyhosyouhskmsgcd1(String pZtyhosyouhskmsgcd1) {
        ztyhosyouhskmsgcd1 = pZtyhosyouhskmsgcd1;
    }

    private String ztyhosyouhskmsgcd2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHOSYOUHSKMSGCD2)
    public String getZtyhosyouhskmsgcd2() {
        return ztyhosyouhskmsgcd2;
    }

    public void setZtyhosyouhskmsgcd2(String pZtyhosyouhskmsgcd2) {
        ztyhosyouhskmsgcd2 = pZtyhosyouhskmsgcd2;
    }

    private String ztyhosyouhskmsgcd3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHOSYOUHSKMSGCD3)
    public String getZtyhosyouhskmsgcd3() {
        return ztyhosyouhskmsgcd3;
    }

    public void setZtyhosyouhskmsgcd3(String pZtyhosyouhskmsgcd3) {
        ztyhosyouhskmsgcd3 = pZtyhosyouhskmsgcd3;
    }

    private String ztyhosyouhskmsgcd4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHOSYOUHSKMSGCD4)
    public String getZtyhosyouhskmsgcd4() {
        return ztyhosyouhskmsgcd4;
    }

    public void setZtyhosyouhskmsgcd4(String pZtyhosyouhskmsgcd4) {
        ztyhosyouhskmsgcd4 = pZtyhosyouhskmsgcd4;
    }

    private String ztyhosyouhskmsgcd5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHOSYOUHSKMSGCD5)
    public String getZtyhosyouhskmsgcd5() {
        return ztyhosyouhskmsgcd5;
    }

    public void setZtyhosyouhskmsgcd5(String pZtyhosyouhskmsgcd5) {
        ztyhosyouhskmsgcd5 = pZtyhosyouhskmsgcd5;
    }

    private String ztyhosyouhskmsgcd6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHOSYOUHSKMSGCD6)
    public String getZtyhosyouhskmsgcd6() {
        return ztyhosyouhskmsgcd6;
    }

    public void setZtyhosyouhskmsgcd6(String pZtyhosyouhskmsgcd6) {
        ztyhosyouhskmsgcd6 = pZtyhosyouhskmsgcd6;
    }

    private String ztyhosyouhskmsgcd7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHOSYOUHSKMSGCD7)
    public String getZtyhosyouhskmsgcd7() {
        return ztyhosyouhskmsgcd7;
    }

    public void setZtyhosyouhskmsgcd7(String pZtyhosyouhskmsgcd7) {
        ztyhosyouhskmsgcd7 = pZtyhosyouhskmsgcd7;
    }

    private String ztyhosyouhskmsgcd8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHOSYOUHSKMSGCD8)
    public String getZtyhosyouhskmsgcd8() {
        return ztyhosyouhskmsgcd8;
    }

    public void setZtyhosyouhskmsgcd8(String pZtyhosyouhskmsgcd8) {
        ztyhosyouhskmsgcd8 = pZtyhosyouhskmsgcd8;
    }

    private String ztyhosyouhskmsgcd9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHOSYOUHSKMSGCD9)
    public String getZtyhosyouhskmsgcd9() {
        return ztyhosyouhskmsgcd9;
    }

    public void setZtyhosyouhskmsgcd9(String pZtyhosyouhskmsgcd9) {
        ztyhosyouhskmsgcd9 = pZtyhosyouhskmsgcd9;
    }

    private String ztykihonsyen;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKIHONSYEN)
    public String getZtykihonsyen() {
        return ztykihonsyen;
    }

    public void setZtykihonsyen(String pZtykihonsyen) {
        ztykihonsyen = pZtykihonsyen;
    }

    private String ztyyoteirirituv4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUV4)
    public String getZtyyoteirirituv4() {
        return ztyyoteirirituv4;
    }

    public void setZtyyoteirirituv4(String pZtyyoteirirituv4) {
        ztyyoteirirituv4 = pZtyyoteirirituv4;
    }

    private String ztyyendthnkhrkngakyen;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYENDTHNKHRKNGAKYEN)
    public String getZtyyendthnkhrkngakyen() {
        return ztyyendthnkhrkngakyen;
    }

    public void setZtyyendthnkhrkngakyen(String pZtyyendthnkhrkngakyen) {
        ztyyendthnkhrkngakyen = pZtyyendthnkhrkngakyen;
    }

    private String ztytmtthaitoukinzndkyen;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTHAITOUKINZNDKYEN)
    public String getZtytmtthaitoukinzndkyen() {
        return ztytmtthaitoukinzndkyen;
    }

    public void setZtytmtthaitoukinzndkyen(String pZtytmtthaitoukinzndkyen) {
        ztytmtthaitoukinzndkyen = pZtytmtthaitoukinzndkyen;
    }

    private String ztynkgnsgkkyktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNKGNSGKKYKTUUKA)
    public String getZtynkgnsgkkyktuuka() {
        return ztynkgnsgkkyktuuka;
    }

    public void setZtynkgnsgkkyktuuka(String pZtynkgnsgkkyktuuka) {
        ztynkgnsgkkyktuuka = pZtynkgnsgkkyktuuka;
    }

    private String ztysbhknkngkhyoujikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSBHKNKNGKHYOUJIKBN)
    public String getZtysbhknkngkhyoujikbn() {
        return ztysbhknkngkhyoujikbn;
    }

    public void setZtysbhknkngkhyoujikbn(String pZtysbhknkngkhyoujikbn) {
        ztysbhknkngkhyoujikbn = pZtysbhknkngkhyoujikbn;
    }

    private String ztykijyunkingakukyktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKIJYUNKINGAKUKYKTUUKA)
    public String getZtykijyunkingakukyktuuka() {
        return ztykijyunkingakukyktuuka;
    }

    public void setZtykijyunkingakukyktuuka(String pZtykijyunkingakukyktuuka) {
        ztykijyunkingakukyktuuka = pZtykijyunkingakukyktuuka;
    }

    private String ztyyenhrkgkiktnkgk;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYENHRKGKIKTNKGK)
    public String getZtyyenhrkgkiktnkgk() {
        return ztyyenhrkgkiktnkgk;
    }

    public void setZtyyenhrkgkiktnkgk(String pZtyyenhrkgkiktnkgk) {
        ztyyenhrkgkiktnkgk = pZtyyenhrkgkiktnkgk;
    }

    private String ztyzennoutikiktyenhrkgkkykj;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYZENNOUTIKIKTYENHRKGKKYKJ)
    public String getZtyzennoutikiktyenhrkgkkykj() {
        return ztyzennoutikiktyenhrkgkkykj;
    }

    public void setZtyzennoutikiktyenhrkgkkykj(String pZtyzennoutikiktyenhrkgkkykj) {
        ztyzennoutikiktyenhrkgkkykj = pZtyzennoutikiktyenhrkgkkykj;
    }

    private String ztykaiyakusiharaigk;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAIYAKUSIHARAIGK)
    public String getZtykaiyakusiharaigk() {
        return ztykaiyakusiharaigk;
    }

    public void setZtykaiyakusiharaigk(String pZtykaiyakusiharaigk) {
        ztykaiyakusiharaigk = pZtykaiyakusiharaigk;
    }

    private String ztykaiyakusiharaigkznnuzndk;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAIYAKUSIHARAIGKZNNUZNDK)
    public String getZtykaiyakusiharaigkznnuzndk() {
        return ztykaiyakusiharaigkznnuzndk;
    }

    public void setZtykaiyakusiharaigkznnuzndk(String pZtykaiyakusiharaigkznnuzndk) {
        ztykaiyakusiharaigkznnuzndk = pZtykaiyakusiharaigkznnuzndk;
    }

    private String ztykaiyakusiharaigksntshrgk;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAIYAKUSIHARAIGKSNTSHRGK)
    public String getZtykaiyakusiharaigksntshrgk() {
        return ztykaiyakusiharaigksntshrgk;
    }

    public void setZtykaiyakusiharaigksntshrgk(String pZtykaiyakusiharaigksntshrgk) {
        ztykaiyakusiharaigksntshrgk = pZtykaiyakusiharaigksntshrgk;
    }

    private String ztyyenhrkgkgoukei;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYENHRKGKGOUKEI)
    public String getZtyyenhrkgkgoukei() {
        return ztyyenhrkgkgoukei;
    }

    public void setZtyyenhrkgkgoukei(String pZtyyenhrkgkgoukei) {
        ztyyenhrkgkgoukei = pZtyyenhrkgkgoukei;
    }

    private String ztyhrritu;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHRRITU)
    public String getZtyhrritu() {
        return ztyhrritu;
    }

    public void setZtyhrritu(String pZtyhrritu) {
        ztyhrritu = pZtyhrritu;
    }

    private String ztynkgnsyensyourai;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNKGNSYENSYOURAI)
    public String getZtynkgnsyensyourai() {
        return ztynkgnsyensyourai;
    }

    public void setZtynkgnsyensyourai(String pZtynkgnsyensyourai) {
        ztynkgnsyensyourai = pZtynkgnsyensyourai;
    }

    private String ztynkgnsgaikasyourai;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNKGNSGAIKASYOURAI)
    public String getZtynkgnsgaikasyourai() {
        return ztynkgnsgaikasyourai;
    }

    public void setZtynkgnsgaikasyourai(String pZtynkgnsgaikasyourai) {
        ztynkgnsgaikasyourai = pZtynkgnsgaikasyourai;
    }

    private String ztyyenhrkgkgoukeisyourai;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYENHRKGKGOUKEISYOURAI)
    public String getZtyyenhrkgkgoukeisyourai() {
        return ztyyenhrkgkgoukeisyourai;
    }

    public void setZtyyenhrkgkgoukeisyourai(String pZtyyenhrkgkgoukeisyourai) {
        ztyyenhrkgkgoukeisyourai = pZtyyenhrkgkgoukeisyourai;
    }

    private String ztyhrritusyourai;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHRRITUSYOURAI)
    public String getZtyhrritusyourai() {
        return ztyhrritusyourai;
    }

    public void setZtyhrritusyourai(String pZtyhrritusyourai) {
        ztyhrritusyourai = pZtyhrritusyourai;
    }

    private String ztynkgnshskmsgcd1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNKGNSHSKMSGCD1)
    public String getZtynkgnshskmsgcd1() {
        return ztynkgnshskmsgcd1;
    }

    public void setZtynkgnshskmsgcd1(String pZtynkgnshskmsgcd1) {
        ztynkgnshskmsgcd1 = pZtynkgnshskmsgcd1;
    }

    private String ztynkgnshskmsgcd2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNKGNSHSKMSGCD2)
    public String getZtynkgnshskmsgcd2() {
        return ztynkgnshskmsgcd2;
    }

    public void setZtynkgnshskmsgcd2(String pZtynkgnshskmsgcd2) {
        ztynkgnshskmsgcd2 = pZtynkgnshskmsgcd2;
    }

    private String ztynkgnshskmsgcd3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNKGNSHSKMSGCD3)
    public String getZtynkgnshskmsgcd3() {
        return ztynkgnshskmsgcd3;
    }

    public void setZtynkgnshskmsgcd3(String pZtynkgnshskmsgcd3) {
        ztynkgnshskmsgcd3 = pZtynkgnshskmsgcd3;
    }

    private String ztynkgnshskmsgcd4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNKGNSHSKMSGCD4)
    public String getZtynkgnshskmsgcd4() {
        return ztynkgnshskmsgcd4;
    }

    public void setZtynkgnshskmsgcd4(String pZtynkgnshskmsgcd4) {
        ztynkgnshskmsgcd4 = pZtynkgnshskmsgcd4;
    }

    private String ztynkgnshskmsgcd5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYNKGNSHSKMSGCD5)
    public String getZtynkgnshskmsgcd5() {
        return ztynkgnshskmsgcd5;
    }

    public void setZtynkgnshskmsgcd5(String pZtynkgnshskmsgcd5) {
        ztynkgnshskmsgcd5 = pZtynkgnshskmsgcd5;
    }

    private String ztyhosyounaiyouyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYHOSYOUNAIYOUYOBI)
    public String getZtyhosyounaiyouyobi() {
        return ztyhosyounaiyouyobi;
    }

    public void setZtyhosyounaiyouyobi(String pZtyhosyounaiyouyobi) {
        ztyhosyounaiyouyobi = pZtyhosyounaiyouyobi;
    }

    private String ztykwsratekijyunymd1maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYMD1MAEWA)
    public String getZtykwsratekijyunymd1maewa() {
        return ztykwsratekijyunymd1maewa;
    }

    public void setZtykwsratekijyunymd1maewa(String pZtykwsratekijyunymd1maewa) {
        ztykwsratekijyunymd1maewa = pZtykwsratekijyunymd1maewa;
    }

    private String ztykwsrateusdjpy1mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEUSDJPY1MAE)
    public String getZtykwsrateusdjpy1mae() {
        return ztykwsrateusdjpy1mae;
    }

    public void setZtykwsrateusdjpy1mae(String pZtykwsrateusdjpy1mae) {
        ztykwsrateusdjpy1mae = pZtykwsrateusdjpy1mae;
    }

    private String ztykwsrateaudjpy1mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEAUDJPY1MAE)
    public String getZtykwsrateaudjpy1mae() {
        return ztykwsrateaudjpy1mae;
    }

    public void setZtykwsrateaudjpy1mae(String pZtykwsrateaudjpy1mae) {
        ztykwsrateaudjpy1mae = pZtykwsrateaudjpy1mae;
    }

    private String ztyyobiv10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOBIV10)
    public String getZtyyobiv10() {
        return ztyyobiv10;
    }

    public void setZtyyobiv10(String pZtyyobiv10) {
        ztyyobiv10 = pZtyyobiv10;
    }

    private String ztykwsratekijyunymd2maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYMD2MAEWA)
    public String getZtykwsratekijyunymd2maewa() {
        return ztykwsratekijyunymd2maewa;
    }

    public void setZtykwsratekijyunymd2maewa(String pZtykwsratekijyunymd2maewa) {
        ztykwsratekijyunymd2maewa = pZtykwsratekijyunymd2maewa;
    }

    private String ztykwsrateusdjpy2mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEUSDJPY2MAE)
    public String getZtykwsrateusdjpy2mae() {
        return ztykwsrateusdjpy2mae;
    }

    public void setZtykwsrateusdjpy2mae(String pZtykwsrateusdjpy2mae) {
        ztykwsrateusdjpy2mae = pZtykwsrateusdjpy2mae;
    }

    private String ztykwsrateaudjpy2mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEAUDJPY2MAE)
    public String getZtykwsrateaudjpy2mae() {
        return ztykwsrateaudjpy2mae;
    }

    public void setZtykwsrateaudjpy2mae(String pZtykwsrateaudjpy2mae) {
        ztykwsrateaudjpy2mae = pZtykwsrateaudjpy2mae;
    }

    private String ztyyobiv10x2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOBIV10X2)
    public String getZtyyobiv10x2() {
        return ztyyobiv10x2;
    }

    public void setZtyyobiv10x2(String pZtyyobiv10x2) {
        ztyyobiv10x2 = pZtyyobiv10x2;
    }

    private String ztykwsratekijyunymd3maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYMD3MAEWA)
    public String getZtykwsratekijyunymd3maewa() {
        return ztykwsratekijyunymd3maewa;
    }

    public void setZtykwsratekijyunymd3maewa(String pZtykwsratekijyunymd3maewa) {
        ztykwsratekijyunymd3maewa = pZtykwsratekijyunymd3maewa;
    }

    private String ztykwsrateusdjpy3mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEUSDJPY3MAE)
    public String getZtykwsrateusdjpy3mae() {
        return ztykwsrateusdjpy3mae;
    }

    public void setZtykwsrateusdjpy3mae(String pZtykwsrateusdjpy3mae) {
        ztykwsrateusdjpy3mae = pZtykwsrateusdjpy3mae;
    }

    private String ztykwsrateaudjpy3mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEAUDJPY3MAE)
    public String getZtykwsrateaudjpy3mae() {
        return ztykwsrateaudjpy3mae;
    }

    public void setZtykwsrateaudjpy3mae(String pZtykwsrateaudjpy3mae) {
        ztykwsrateaudjpy3mae = pZtykwsrateaudjpy3mae;
    }

    private String ztyyobiv10x3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOBIV10X3)
    public String getZtyyobiv10x3() {
        return ztyyobiv10x3;
    }

    public void setZtyyobiv10x3(String pZtyyobiv10x3) {
        ztyyobiv10x3 = pZtyyobiv10x3;
    }

    private String ztykwsratekijyunymd4maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYMD4MAEWA)
    public String getZtykwsratekijyunymd4maewa() {
        return ztykwsratekijyunymd4maewa;
    }

    public void setZtykwsratekijyunymd4maewa(String pZtykwsratekijyunymd4maewa) {
        ztykwsratekijyunymd4maewa = pZtykwsratekijyunymd4maewa;
    }

    private String ztykwsrateusdjpy4mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEUSDJPY4MAE)
    public String getZtykwsrateusdjpy4mae() {
        return ztykwsrateusdjpy4mae;
    }

    public void setZtykwsrateusdjpy4mae(String pZtykwsrateusdjpy4mae) {
        ztykwsrateusdjpy4mae = pZtykwsrateusdjpy4mae;
    }

    private String ztykwsrateaudjpy4mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEAUDJPY4MAE)
    public String getZtykwsrateaudjpy4mae() {
        return ztykwsrateaudjpy4mae;
    }

    public void setZtykwsrateaudjpy4mae(String pZtykwsrateaudjpy4mae) {
        ztykwsrateaudjpy4mae = pZtykwsrateaudjpy4mae;
    }

    private String ztyyobiv10x4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOBIV10X4)
    public String getZtyyobiv10x4() {
        return ztyyobiv10x4;
    }

    public void setZtyyobiv10x4(String pZtyyobiv10x4) {
        ztyyobiv10x4 = pZtyyobiv10x4;
    }

    private String ztykwsratekijyunymd5maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYMD5MAEWA)
    public String getZtykwsratekijyunymd5maewa() {
        return ztykwsratekijyunymd5maewa;
    }

    public void setZtykwsratekijyunymd5maewa(String pZtykwsratekijyunymd5maewa) {
        ztykwsratekijyunymd5maewa = pZtykwsratekijyunymd5maewa;
    }

    private String ztykwsrateusdjpy5mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEUSDJPY5MAE)
    public String getZtykwsrateusdjpy5mae() {
        return ztykwsrateusdjpy5mae;
    }

    public void setZtykwsrateusdjpy5mae(String pZtykwsrateusdjpy5mae) {
        ztykwsrateusdjpy5mae = pZtykwsrateusdjpy5mae;
    }

    private String ztykwsrateaudjpy5mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEAUDJPY5MAE)
    public String getZtykwsrateaudjpy5mae() {
        return ztykwsrateaudjpy5mae;
    }

    public void setZtykwsrateaudjpy5mae(String pZtykwsrateaudjpy5mae) {
        ztykwsrateaudjpy5mae = pZtykwsrateaudjpy5mae;
    }

    private String ztyyobiv10x5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOBIV10X5)
    public String getZtyyobiv10x5() {
        return ztyyobiv10x5;
    }

    public void setZtyyobiv10x5(String pZtyyobiv10x5) {
        ztyyobiv10x5 = pZtyyobiv10x5;
    }

    private String ztykwsratekijyunymd6maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYMD6MAEWA)
    public String getZtykwsratekijyunymd6maewa() {
        return ztykwsratekijyunymd6maewa;
    }

    public void setZtykwsratekijyunymd6maewa(String pZtykwsratekijyunymd6maewa) {
        ztykwsratekijyunymd6maewa = pZtykwsratekijyunymd6maewa;
    }

    private String ztykwsrateusdjpy6mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEUSDJPY6MAE)
    public String getZtykwsrateusdjpy6mae() {
        return ztykwsrateusdjpy6mae;
    }

    public void setZtykwsrateusdjpy6mae(String pZtykwsrateusdjpy6mae) {
        ztykwsrateusdjpy6mae = pZtykwsrateusdjpy6mae;
    }

    private String ztykwsrateaudjpy6mae;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEAUDJPY6MAE)
    public String getZtykwsrateaudjpy6mae() {
        return ztykwsrateaudjpy6mae;
    }

    public void setZtykwsrateaudjpy6mae(String pZtykwsrateaudjpy6mae) {
        ztykwsrateaudjpy6mae = pZtykwsrateaudjpy6mae;
    }

    private String ztyyobiv10x6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOBIV10X6)
    public String getZtyyobiv10x6() {
        return ztyyobiv10x6;
    }

    public void setZtyyobiv10x6(String pZtyyobiv10x6) {
        ztyyobiv10x6 = pZtyyobiv10x6;
    }

    private String ztykwsratemsgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEMSGCD)
    public String getZtykwsratemsgcd() {
        return ztykwsratemsgcd;
    }

    public void setZtykwsratemsgcd(String pZtykwsratemsgcd) {
        ztykwsratemsgcd = pZtykwsratemsgcd;
    }

    private String ztyyobiv23;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOBIV23)
    public String getZtyyobiv23() {
        return ztyyobiv23;
    }

    public void setZtyyobiv23(String pZtyyobiv23) {
        ztyyobiv23 = pZtyyobiv23;
    }

    private String ztyosirasemsgcd1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYOSIRASEMSGCD1)
    public String getZtyosirasemsgcd1() {
        return ztyosirasemsgcd1;
    }

    public void setZtyosirasemsgcd1(String pZtyosirasemsgcd1) {
        ztyosirasemsgcd1 = pZtyosirasemsgcd1;
    }

    private String ztyosirasemsgcd2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYOSIRASEMSGCD2)
    public String getZtyosirasemsgcd2() {
        return ztyosirasemsgcd2;
    }

    public void setZtyosirasemsgcd2(String pZtyosirasemsgcd2) {
        ztyosirasemsgcd2 = pZtyosirasemsgcd2;
    }

    private String ztyosirasemsgcd3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYOSIRASEMSGCD3)
    public String getZtyosirasemsgcd3() {
        return ztyosirasemsgcd3;
    }

    public void setZtyosirasemsgcd3(String pZtyosirasemsgcd3) {
        ztyosirasemsgcd3 = pZtyosirasemsgcd3;
    }

    private String ztyosirasemsgcd4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYOSIRASEMSGCD4)
    public String getZtyosirasemsgcd4() {
        return ztyosirasemsgcd4;
    }

    public void setZtyosirasemsgcd4(String pZtyosirasemsgcd4) {
        ztyosirasemsgcd4 = pZtyosirasemsgcd4;
    }

    private String ztyosirasemsgcd5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYOSIRASEMSGCD5)
    public String getZtyosirasemsgcd5() {
        return ztyosirasemsgcd5;
    }

    public void setZtyosirasemsgcd5(String pZtyosirasemsgcd5) {
        ztyosirasemsgcd5 = pZtyosirasemsgcd5;
    }

    private String ztyyobiv15;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOBIV15)
    public String getZtyyobiv15() {
        return ztyyobiv15;
    }

    public void setZtyyobiv15(String pZtyyobiv15) {
        ztyyobiv15 = pZtyyobiv15;
    }

    private String ztysetteibairitustr;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSETTEIBAIRITUSTR)
    public String getZtysetteibairitustr() {
        return ztysetteibairitustr;
    }

    public void setZtysetteibairitustr(String pZtysetteibairitustr) {
        ztysetteibairitustr = pZtysetteibairitustr;
    }

    private String ztytmttknzkrtjygnstr;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZKRTJYGNSTR)
    public String getZtytmttknzkrtjygnstr() {
        return ztytmttknzkrtjygnstr;
    }

    public void setZtytmttknzkrtjygnstr(String pZtytmttknzkrtjygnstr) {
        ztytmttknzkrtjygnstr = pZtytmttknzkrtjygnstr;
    }

    private String ztytmttknzkrtkgnstr;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZKRTKGNSTR)
    public String getZtytmttknzkrtkgnstr() {
        return ztytmttknzkrtkgnstr;
    }

    public void setZtytmttknzkrtkgnstr(String pZtytmttknzkrtkgnstr) {
        ztytmttknzkrtkgnstr = pZtytmttknzkrtkgnstr;
    }

    private String ztytumitateriritustr;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTUMITATERIRITUSTR)
    public String getZtytumitateriritustr() {
        return ztytumitateriritustr;
    }

    public void setZtytumitateriritustr(String pZtytumitateriritustr) {
        ztytumitateriritustr = pZtytumitateriritustr;
    }

    private String ztysisuunm;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUNM)
    public String getZtysisuunm() {
        return ztysisuunm;
    }

    public void setZtysisuunm(String pZtysisuunm) {
        ztysisuunm = pZtysisuunm;
    }

    private String ztytmttknsuiirirekikbnx1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX1)
    public String getZtytmttknsuiirirekikbnx1() {
        return ztytmttknsuiirirekikbnx1;
    }

    public void setZtytmttknsuiirirekikbnx1(String pZtytmttknsuiirirekikbnx1) {
        ztytmttknsuiirirekikbnx1 = pZtytmttknsuiirirekikbnx1;
    }

    private String ztykeiyakuoutoubix1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX1)
    public String getZtykeiyakuoutoubix1() {
        return ztykeiyakuoutoubix1;
    }

    public void setZtykeiyakuoutoubix1(String pZtykeiyakuoutoubix1) {
        ztykeiyakuoutoubix1 = pZtykeiyakuoutoubix1;
    }

    private String ztytmttknjyoutaix1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX1)
    public String getZtytmttknjyoutaix1() {
        return ztytmttknjyoutaix1;
    }

    public void setZtytmttknjyoutaix1(String pZtytmttknjyoutaix1) {
        ztytmttknjyoutaix1 = pZtytmttknjyoutaix1;
    }

    private String ztyptumitatekngkktuukax1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX1)
    public String getZtyptumitatekngkktuukax1() {
        return ztyptumitatekngkktuukax1;
    }

    public void setZtyptumitatekngkktuukax1(String pZtyptumitatekngkktuukax1) {
        ztyptumitatekngkktuukax1 = pZtyptumitatekngkktuukax1;
    }

    private String ztyptumitatekngkyenx1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX1)
    public String getZtyptumitatekngkyenx1() {
        return ztyptumitatekngkyenx1;
    }

    public void setZtyptumitatekngkyenx1(String pZtyptumitatekngkyenx1) {
        ztyptumitatekngkyenx1 = pZtyptumitatekngkyenx1;
    }

    private String ztysisuux1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX1)
    public String getZtysisuux1() {
        return ztysisuux1;
    }

    public void setZtysisuux1(String pZtysisuux1) {
        ztysisuux1 = pZtysisuux1;
    }

    private String ztysisuuuprituhugoux1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX1)
    public String getZtysisuuuprituhugoux1() {
        return ztysisuuuprituhugoux1;
    }

    public void setZtysisuuuprituhugoux1(String pZtysisuuuprituhugoux1) {
        ztysisuuuprituhugoux1 = pZtysisuuuprituhugoux1;
    }

    private String ztysisuuupritux1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX1)
    public String getZtysisuuupritux1() {
        return ztysisuuupritux1;
    }

    public void setZtysisuuupritux1(String pZtysisuuupritux1) {
        ztysisuuupritux1 = pZtysisuuupritux1;
    }

    private String ztytmttknzoukaritustrx1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX1)
    public String getZtytmttknzoukaritustrx1() {
        return ztytmttknzoukaritustrx1;
    }

    public void setZtytmttknzoukaritustrx1(String pZtytmttknzoukaritustrx1) {
        ztytmttknzoukaritustrx1 = pZtytmttknzoukaritustrx1;
    }

    private String ztykawaseratex1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX1)
    public String getZtykawaseratex1() {
        return ztykawaseratex1;
    }

    public void setZtykawaseratex1(String pZtykawaseratex1) {
        ztykawaseratex1 = pZtykawaseratex1;
    }

    private String ztytmttknsuiirirekikbnx2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX2)
    public String getZtytmttknsuiirirekikbnx2() {
        return ztytmttknsuiirirekikbnx2;
    }

    public void setZtytmttknsuiirirekikbnx2(String pZtytmttknsuiirirekikbnx2) {
        ztytmttknsuiirirekikbnx2 = pZtytmttknsuiirirekikbnx2;
    }

    private String ztykeiyakuoutoubix2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX2)
    public String getZtykeiyakuoutoubix2() {
        return ztykeiyakuoutoubix2;
    }

    public void setZtykeiyakuoutoubix2(String pZtykeiyakuoutoubix2) {
        ztykeiyakuoutoubix2 = pZtykeiyakuoutoubix2;
    }

    private String ztytmttknjyoutaix2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX2)
    public String getZtytmttknjyoutaix2() {
        return ztytmttknjyoutaix2;
    }

    public void setZtytmttknjyoutaix2(String pZtytmttknjyoutaix2) {
        ztytmttknjyoutaix2 = pZtytmttknjyoutaix2;
    }

    private String ztyptumitatekngkktuukax2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX2)
    public String getZtyptumitatekngkktuukax2() {
        return ztyptumitatekngkktuukax2;
    }

    public void setZtyptumitatekngkktuukax2(String pZtyptumitatekngkktuukax2) {
        ztyptumitatekngkktuukax2 = pZtyptumitatekngkktuukax2;
    }

    private String ztyptumitatekngkyenx2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX2)
    public String getZtyptumitatekngkyenx2() {
        return ztyptumitatekngkyenx2;
    }

    public void setZtyptumitatekngkyenx2(String pZtyptumitatekngkyenx2) {
        ztyptumitatekngkyenx2 = pZtyptumitatekngkyenx2;
    }

    private String ztysisuux2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX2)
    public String getZtysisuux2() {
        return ztysisuux2;
    }

    public void setZtysisuux2(String pZtysisuux2) {
        ztysisuux2 = pZtysisuux2;
    }

    private String ztysisuuuprituhugoux2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX2)
    public String getZtysisuuuprituhugoux2() {
        return ztysisuuuprituhugoux2;
    }

    public void setZtysisuuuprituhugoux2(String pZtysisuuuprituhugoux2) {
        ztysisuuuprituhugoux2 = pZtysisuuuprituhugoux2;
    }

    private String ztysisuuupritux2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX2)
    public String getZtysisuuupritux2() {
        return ztysisuuupritux2;
    }

    public void setZtysisuuupritux2(String pZtysisuuupritux2) {
        ztysisuuupritux2 = pZtysisuuupritux2;
    }

    private String ztytmttknzoukaritustrx2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX2)
    public String getZtytmttknzoukaritustrx2() {
        return ztytmttknzoukaritustrx2;
    }

    public void setZtytmttknzoukaritustrx2(String pZtytmttknzoukaritustrx2) {
        ztytmttknzoukaritustrx2 = pZtytmttknzoukaritustrx2;
    }

    private String ztykawaseratex2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX2)
    public String getZtykawaseratex2() {
        return ztykawaseratex2;
    }

    public void setZtykawaseratex2(String pZtykawaseratex2) {
        ztykawaseratex2 = pZtykawaseratex2;
    }

    private String ztytmttknsuiirirekikbnx3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX3)
    public String getZtytmttknsuiirirekikbnx3() {
        return ztytmttknsuiirirekikbnx3;
    }

    public void setZtytmttknsuiirirekikbnx3(String pZtytmttknsuiirirekikbnx3) {
        ztytmttknsuiirirekikbnx3 = pZtytmttknsuiirirekikbnx3;
    }

    private String ztykeiyakuoutoubix3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX3)
    public String getZtykeiyakuoutoubix3() {
        return ztykeiyakuoutoubix3;
    }

    public void setZtykeiyakuoutoubix3(String pZtykeiyakuoutoubix3) {
        ztykeiyakuoutoubix3 = pZtykeiyakuoutoubix3;
    }

    private String ztytmttknjyoutaix3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX3)
    public String getZtytmttknjyoutaix3() {
        return ztytmttknjyoutaix3;
    }

    public void setZtytmttknjyoutaix3(String pZtytmttknjyoutaix3) {
        ztytmttknjyoutaix3 = pZtytmttknjyoutaix3;
    }

    private String ztyptumitatekngkktuukax3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX3)
    public String getZtyptumitatekngkktuukax3() {
        return ztyptumitatekngkktuukax3;
    }

    public void setZtyptumitatekngkktuukax3(String pZtyptumitatekngkktuukax3) {
        ztyptumitatekngkktuukax3 = pZtyptumitatekngkktuukax3;
    }

    private String ztyptumitatekngkyenx3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX3)
    public String getZtyptumitatekngkyenx3() {
        return ztyptumitatekngkyenx3;
    }

    public void setZtyptumitatekngkyenx3(String pZtyptumitatekngkyenx3) {
        ztyptumitatekngkyenx3 = pZtyptumitatekngkyenx3;
    }

    private String ztysisuux3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX3)
    public String getZtysisuux3() {
        return ztysisuux3;
    }

    public void setZtysisuux3(String pZtysisuux3) {
        ztysisuux3 = pZtysisuux3;
    }

    private String ztysisuuuprituhugoux3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX3)
    public String getZtysisuuuprituhugoux3() {
        return ztysisuuuprituhugoux3;
    }

    public void setZtysisuuuprituhugoux3(String pZtysisuuuprituhugoux3) {
        ztysisuuuprituhugoux3 = pZtysisuuuprituhugoux3;
    }

    private String ztysisuuupritux3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX3)
    public String getZtysisuuupritux3() {
        return ztysisuuupritux3;
    }

    public void setZtysisuuupritux3(String pZtysisuuupritux3) {
        ztysisuuupritux3 = pZtysisuuupritux3;
    }

    private String ztytmttknzoukaritustrx3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX3)
    public String getZtytmttknzoukaritustrx3() {
        return ztytmttknzoukaritustrx3;
    }

    public void setZtytmttknzoukaritustrx3(String pZtytmttknzoukaritustrx3) {
        ztytmttknzoukaritustrx3 = pZtytmttknzoukaritustrx3;
    }

    private String ztykawaseratex3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX3)
    public String getZtykawaseratex3() {
        return ztykawaseratex3;
    }

    public void setZtykawaseratex3(String pZtykawaseratex3) {
        ztykawaseratex3 = pZtykawaseratex3;
    }

    private String ztytmttknsuiirirekikbnx4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX4)
    public String getZtytmttknsuiirirekikbnx4() {
        return ztytmttknsuiirirekikbnx4;
    }

    public void setZtytmttknsuiirirekikbnx4(String pZtytmttknsuiirirekikbnx4) {
        ztytmttknsuiirirekikbnx4 = pZtytmttknsuiirirekikbnx4;
    }

    private String ztykeiyakuoutoubix4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX4)
    public String getZtykeiyakuoutoubix4() {
        return ztykeiyakuoutoubix4;
    }

    public void setZtykeiyakuoutoubix4(String pZtykeiyakuoutoubix4) {
        ztykeiyakuoutoubix4 = pZtykeiyakuoutoubix4;
    }

    private String ztytmttknjyoutaix4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX4)
    public String getZtytmttknjyoutaix4() {
        return ztytmttknjyoutaix4;
    }

    public void setZtytmttknjyoutaix4(String pZtytmttknjyoutaix4) {
        ztytmttknjyoutaix4 = pZtytmttknjyoutaix4;
    }

    private String ztyptumitatekngkktuukax4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX4)
    public String getZtyptumitatekngkktuukax4() {
        return ztyptumitatekngkktuukax4;
    }

    public void setZtyptumitatekngkktuukax4(String pZtyptumitatekngkktuukax4) {
        ztyptumitatekngkktuukax4 = pZtyptumitatekngkktuukax4;
    }

    private String ztyptumitatekngkyenx4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX4)
    public String getZtyptumitatekngkyenx4() {
        return ztyptumitatekngkyenx4;
    }

    public void setZtyptumitatekngkyenx4(String pZtyptumitatekngkyenx4) {
        ztyptumitatekngkyenx4 = pZtyptumitatekngkyenx4;
    }

    private String ztysisuux4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX4)
    public String getZtysisuux4() {
        return ztysisuux4;
    }

    public void setZtysisuux4(String pZtysisuux4) {
        ztysisuux4 = pZtysisuux4;
    }

    private String ztysisuuuprituhugoux4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX4)
    public String getZtysisuuuprituhugoux4() {
        return ztysisuuuprituhugoux4;
    }

    public void setZtysisuuuprituhugoux4(String pZtysisuuuprituhugoux4) {
        ztysisuuuprituhugoux4 = pZtysisuuuprituhugoux4;
    }

    private String ztysisuuupritux4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX4)
    public String getZtysisuuupritux4() {
        return ztysisuuupritux4;
    }

    public void setZtysisuuupritux4(String pZtysisuuupritux4) {
        ztysisuuupritux4 = pZtysisuuupritux4;
    }

    private String ztytmttknzoukaritustrx4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX4)
    public String getZtytmttknzoukaritustrx4() {
        return ztytmttknzoukaritustrx4;
    }

    public void setZtytmttknzoukaritustrx4(String pZtytmttknzoukaritustrx4) {
        ztytmttknzoukaritustrx4 = pZtytmttknzoukaritustrx4;
    }

    private String ztykawaseratex4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX4)
    public String getZtykawaseratex4() {
        return ztykawaseratex4;
    }

    public void setZtykawaseratex4(String pZtykawaseratex4) {
        ztykawaseratex4 = pZtykawaseratex4;
    }

    private String ztytmttknsuiirirekikbnx5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX5)
    public String getZtytmttknsuiirirekikbnx5() {
        return ztytmttknsuiirirekikbnx5;
    }

    public void setZtytmttknsuiirirekikbnx5(String pZtytmttknsuiirirekikbnx5) {
        ztytmttknsuiirirekikbnx5 = pZtytmttknsuiirirekikbnx5;
    }

    private String ztykeiyakuoutoubix5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX5)
    public String getZtykeiyakuoutoubix5() {
        return ztykeiyakuoutoubix5;
    }

    public void setZtykeiyakuoutoubix5(String pZtykeiyakuoutoubix5) {
        ztykeiyakuoutoubix5 = pZtykeiyakuoutoubix5;
    }

    private String ztytmttknjyoutaix5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX5)
    public String getZtytmttknjyoutaix5() {
        return ztytmttknjyoutaix5;
    }

    public void setZtytmttknjyoutaix5(String pZtytmttknjyoutaix5) {
        ztytmttknjyoutaix5 = pZtytmttknjyoutaix5;
    }

    private String ztyptumitatekngkktuukax5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX5)
    public String getZtyptumitatekngkktuukax5() {
        return ztyptumitatekngkktuukax5;
    }

    public void setZtyptumitatekngkktuukax5(String pZtyptumitatekngkktuukax5) {
        ztyptumitatekngkktuukax5 = pZtyptumitatekngkktuukax5;
    }

    private String ztyptumitatekngkyenx5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX5)
    public String getZtyptumitatekngkyenx5() {
        return ztyptumitatekngkyenx5;
    }

    public void setZtyptumitatekngkyenx5(String pZtyptumitatekngkyenx5) {
        ztyptumitatekngkyenx5 = pZtyptumitatekngkyenx5;
    }

    private String ztysisuux5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX5)
    public String getZtysisuux5() {
        return ztysisuux5;
    }

    public void setZtysisuux5(String pZtysisuux5) {
        ztysisuux5 = pZtysisuux5;
    }

    private String ztysisuuuprituhugoux5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX5)
    public String getZtysisuuuprituhugoux5() {
        return ztysisuuuprituhugoux5;
    }

    public void setZtysisuuuprituhugoux5(String pZtysisuuuprituhugoux5) {
        ztysisuuuprituhugoux5 = pZtysisuuuprituhugoux5;
    }

    private String ztysisuuupritux5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX5)
    public String getZtysisuuupritux5() {
        return ztysisuuupritux5;
    }

    public void setZtysisuuupritux5(String pZtysisuuupritux5) {
        ztysisuuupritux5 = pZtysisuuupritux5;
    }

    private String ztytmttknzoukaritustrx5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX5)
    public String getZtytmttknzoukaritustrx5() {
        return ztytmttknzoukaritustrx5;
    }

    public void setZtytmttknzoukaritustrx5(String pZtytmttknzoukaritustrx5) {
        ztytmttknzoukaritustrx5 = pZtytmttknzoukaritustrx5;
    }

    private String ztykawaseratex5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX5)
    public String getZtykawaseratex5() {
        return ztykawaseratex5;
    }

    public void setZtykawaseratex5(String pZtykawaseratex5) {
        ztykawaseratex5 = pZtykawaseratex5;
    }

    private String ztytmttknsuiirirekikbnx6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX6)
    public String getZtytmttknsuiirirekikbnx6() {
        return ztytmttknsuiirirekikbnx6;
    }

    public void setZtytmttknsuiirirekikbnx6(String pZtytmttknsuiirirekikbnx6) {
        ztytmttknsuiirirekikbnx6 = pZtytmttknsuiirirekikbnx6;
    }

    private String ztykeiyakuoutoubix6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX6)
    public String getZtykeiyakuoutoubix6() {
        return ztykeiyakuoutoubix6;
    }

    public void setZtykeiyakuoutoubix6(String pZtykeiyakuoutoubix6) {
        ztykeiyakuoutoubix6 = pZtykeiyakuoutoubix6;
    }

    private String ztytmttknjyoutaix6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX6)
    public String getZtytmttknjyoutaix6() {
        return ztytmttknjyoutaix6;
    }

    public void setZtytmttknjyoutaix6(String pZtytmttknjyoutaix6) {
        ztytmttknjyoutaix6 = pZtytmttknjyoutaix6;
    }

    private String ztyptumitatekngkktuukax6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX6)
    public String getZtyptumitatekngkktuukax6() {
        return ztyptumitatekngkktuukax6;
    }

    public void setZtyptumitatekngkktuukax6(String pZtyptumitatekngkktuukax6) {
        ztyptumitatekngkktuukax6 = pZtyptumitatekngkktuukax6;
    }

    private String ztyptumitatekngkyenx6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX6)
    public String getZtyptumitatekngkyenx6() {
        return ztyptumitatekngkyenx6;
    }

    public void setZtyptumitatekngkyenx6(String pZtyptumitatekngkyenx6) {
        ztyptumitatekngkyenx6 = pZtyptumitatekngkyenx6;
    }

    private String ztysisuux6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX6)
    public String getZtysisuux6() {
        return ztysisuux6;
    }

    public void setZtysisuux6(String pZtysisuux6) {
        ztysisuux6 = pZtysisuux6;
    }

    private String ztysisuuuprituhugoux6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX6)
    public String getZtysisuuuprituhugoux6() {
        return ztysisuuuprituhugoux6;
    }

    public void setZtysisuuuprituhugoux6(String pZtysisuuuprituhugoux6) {
        ztysisuuuprituhugoux6 = pZtysisuuuprituhugoux6;
    }

    private String ztysisuuupritux6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX6)
    public String getZtysisuuupritux6() {
        return ztysisuuupritux6;
    }

    public void setZtysisuuupritux6(String pZtysisuuupritux6) {
        ztysisuuupritux6 = pZtysisuuupritux6;
    }

    private String ztytmttknzoukaritustrx6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX6)
    public String getZtytmttknzoukaritustrx6() {
        return ztytmttknzoukaritustrx6;
    }

    public void setZtytmttknzoukaritustrx6(String pZtytmttknzoukaritustrx6) {
        ztytmttknzoukaritustrx6 = pZtytmttknzoukaritustrx6;
    }

    private String ztykawaseratex6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX6)
    public String getZtykawaseratex6() {
        return ztykawaseratex6;
    }

    public void setZtykawaseratex6(String pZtykawaseratex6) {
        ztykawaseratex6 = pZtykawaseratex6;
    }

    private String ztytmttknsuiirirekikbnx7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX7)
    public String getZtytmttknsuiirirekikbnx7() {
        return ztytmttknsuiirirekikbnx7;
    }

    public void setZtytmttknsuiirirekikbnx7(String pZtytmttknsuiirirekikbnx7) {
        ztytmttknsuiirirekikbnx7 = pZtytmttknsuiirirekikbnx7;
    }

    private String ztykeiyakuoutoubix7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX7)
    public String getZtykeiyakuoutoubix7() {
        return ztykeiyakuoutoubix7;
    }

    public void setZtykeiyakuoutoubix7(String pZtykeiyakuoutoubix7) {
        ztykeiyakuoutoubix7 = pZtykeiyakuoutoubix7;
    }

    private String ztytmttknjyoutaix7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX7)
    public String getZtytmttknjyoutaix7() {
        return ztytmttknjyoutaix7;
    }

    public void setZtytmttknjyoutaix7(String pZtytmttknjyoutaix7) {
        ztytmttknjyoutaix7 = pZtytmttknjyoutaix7;
    }

    private String ztyptumitatekngkktuukax7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX7)
    public String getZtyptumitatekngkktuukax7() {
        return ztyptumitatekngkktuukax7;
    }

    public void setZtyptumitatekngkktuukax7(String pZtyptumitatekngkktuukax7) {
        ztyptumitatekngkktuukax7 = pZtyptumitatekngkktuukax7;
    }

    private String ztyptumitatekngkyenx7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX7)
    public String getZtyptumitatekngkyenx7() {
        return ztyptumitatekngkyenx7;
    }

    public void setZtyptumitatekngkyenx7(String pZtyptumitatekngkyenx7) {
        ztyptumitatekngkyenx7 = pZtyptumitatekngkyenx7;
    }

    private String ztysisuux7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX7)
    public String getZtysisuux7() {
        return ztysisuux7;
    }

    public void setZtysisuux7(String pZtysisuux7) {
        ztysisuux7 = pZtysisuux7;
    }

    private String ztysisuuuprituhugoux7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX7)
    public String getZtysisuuuprituhugoux7() {
        return ztysisuuuprituhugoux7;
    }

    public void setZtysisuuuprituhugoux7(String pZtysisuuuprituhugoux7) {
        ztysisuuuprituhugoux7 = pZtysisuuuprituhugoux7;
    }

    private String ztysisuuupritux7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX7)
    public String getZtysisuuupritux7() {
        return ztysisuuupritux7;
    }

    public void setZtysisuuupritux7(String pZtysisuuupritux7) {
        ztysisuuupritux7 = pZtysisuuupritux7;
    }

    private String ztytmttknzoukaritustrx7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX7)
    public String getZtytmttknzoukaritustrx7() {
        return ztytmttknzoukaritustrx7;
    }

    public void setZtytmttknzoukaritustrx7(String pZtytmttknzoukaritustrx7) {
        ztytmttknzoukaritustrx7 = pZtytmttknzoukaritustrx7;
    }

    private String ztykawaseratex7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX7)
    public String getZtykawaseratex7() {
        return ztykawaseratex7;
    }

    public void setZtykawaseratex7(String pZtykawaseratex7) {
        ztykawaseratex7 = pZtykawaseratex7;
    }

    private String ztytmttknsuiirirekikbnx8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX8)
    public String getZtytmttknsuiirirekikbnx8() {
        return ztytmttknsuiirirekikbnx8;
    }

    public void setZtytmttknsuiirirekikbnx8(String pZtytmttknsuiirirekikbnx8) {
        ztytmttknsuiirirekikbnx8 = pZtytmttknsuiirirekikbnx8;
    }

    private String ztykeiyakuoutoubix8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX8)
    public String getZtykeiyakuoutoubix8() {
        return ztykeiyakuoutoubix8;
    }

    public void setZtykeiyakuoutoubix8(String pZtykeiyakuoutoubix8) {
        ztykeiyakuoutoubix8 = pZtykeiyakuoutoubix8;
    }

    private String ztytmttknjyoutaix8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX8)
    public String getZtytmttknjyoutaix8() {
        return ztytmttknjyoutaix8;
    }

    public void setZtytmttknjyoutaix8(String pZtytmttknjyoutaix8) {
        ztytmttknjyoutaix8 = pZtytmttknjyoutaix8;
    }

    private String ztyptumitatekngkktuukax8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX8)
    public String getZtyptumitatekngkktuukax8() {
        return ztyptumitatekngkktuukax8;
    }

    public void setZtyptumitatekngkktuukax8(String pZtyptumitatekngkktuukax8) {
        ztyptumitatekngkktuukax8 = pZtyptumitatekngkktuukax8;
    }

    private String ztyptumitatekngkyenx8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX8)
    public String getZtyptumitatekngkyenx8() {
        return ztyptumitatekngkyenx8;
    }

    public void setZtyptumitatekngkyenx8(String pZtyptumitatekngkyenx8) {
        ztyptumitatekngkyenx8 = pZtyptumitatekngkyenx8;
    }

    private String ztysisuux8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX8)
    public String getZtysisuux8() {
        return ztysisuux8;
    }

    public void setZtysisuux8(String pZtysisuux8) {
        ztysisuux8 = pZtysisuux8;
    }

    private String ztysisuuuprituhugoux8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX8)
    public String getZtysisuuuprituhugoux8() {
        return ztysisuuuprituhugoux8;
    }

    public void setZtysisuuuprituhugoux8(String pZtysisuuuprituhugoux8) {
        ztysisuuuprituhugoux8 = pZtysisuuuprituhugoux8;
    }

    private String ztysisuuupritux8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX8)
    public String getZtysisuuupritux8() {
        return ztysisuuupritux8;
    }

    public void setZtysisuuupritux8(String pZtysisuuupritux8) {
        ztysisuuupritux8 = pZtysisuuupritux8;
    }

    private String ztytmttknzoukaritustrx8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX8)
    public String getZtytmttknzoukaritustrx8() {
        return ztytmttknzoukaritustrx8;
    }

    public void setZtytmttknzoukaritustrx8(String pZtytmttknzoukaritustrx8) {
        ztytmttknzoukaritustrx8 = pZtytmttknzoukaritustrx8;
    }

    private String ztykawaseratex8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX8)
    public String getZtykawaseratex8() {
        return ztykawaseratex8;
    }

    public void setZtykawaseratex8(String pZtykawaseratex8) {
        ztykawaseratex8 = pZtykawaseratex8;
    }

    private String ztytmttknsuiirirekikbnx9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX9)
    public String getZtytmttknsuiirirekikbnx9() {
        return ztytmttknsuiirirekikbnx9;
    }

    public void setZtytmttknsuiirirekikbnx9(String pZtytmttknsuiirirekikbnx9) {
        ztytmttknsuiirirekikbnx9 = pZtytmttknsuiirirekikbnx9;
    }

    private String ztykeiyakuoutoubix9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX9)
    public String getZtykeiyakuoutoubix9() {
        return ztykeiyakuoutoubix9;
    }

    public void setZtykeiyakuoutoubix9(String pZtykeiyakuoutoubix9) {
        ztykeiyakuoutoubix9 = pZtykeiyakuoutoubix9;
    }

    private String ztytmttknjyoutaix9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX9)
    public String getZtytmttknjyoutaix9() {
        return ztytmttknjyoutaix9;
    }

    public void setZtytmttknjyoutaix9(String pZtytmttknjyoutaix9) {
        ztytmttknjyoutaix9 = pZtytmttknjyoutaix9;
    }

    private String ztyptumitatekngkktuukax9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX9)
    public String getZtyptumitatekngkktuukax9() {
        return ztyptumitatekngkktuukax9;
    }

    public void setZtyptumitatekngkktuukax9(String pZtyptumitatekngkktuukax9) {
        ztyptumitatekngkktuukax9 = pZtyptumitatekngkktuukax9;
    }

    private String ztyptumitatekngkyenx9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX9)
    public String getZtyptumitatekngkyenx9() {
        return ztyptumitatekngkyenx9;
    }

    public void setZtyptumitatekngkyenx9(String pZtyptumitatekngkyenx9) {
        ztyptumitatekngkyenx9 = pZtyptumitatekngkyenx9;
    }

    private String ztysisuux9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX9)
    public String getZtysisuux9() {
        return ztysisuux9;
    }

    public void setZtysisuux9(String pZtysisuux9) {
        ztysisuux9 = pZtysisuux9;
    }

    private String ztysisuuuprituhugoux9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX9)
    public String getZtysisuuuprituhugoux9() {
        return ztysisuuuprituhugoux9;
    }

    public void setZtysisuuuprituhugoux9(String pZtysisuuuprituhugoux9) {
        ztysisuuuprituhugoux9 = pZtysisuuuprituhugoux9;
    }

    private String ztysisuuupritux9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX9)
    public String getZtysisuuupritux9() {
        return ztysisuuupritux9;
    }

    public void setZtysisuuupritux9(String pZtysisuuupritux9) {
        ztysisuuupritux9 = pZtysisuuupritux9;
    }

    private String ztytmttknzoukaritustrx9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX9)
    public String getZtytmttknzoukaritustrx9() {
        return ztytmttknzoukaritustrx9;
    }

    public void setZtytmttknzoukaritustrx9(String pZtytmttknzoukaritustrx9) {
        ztytmttknzoukaritustrx9 = pZtytmttknzoukaritustrx9;
    }

    private String ztykawaseratex9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX9)
    public String getZtykawaseratex9() {
        return ztykawaseratex9;
    }

    public void setZtykawaseratex9(String pZtykawaseratex9) {
        ztykawaseratex9 = pZtykawaseratex9;
    }

    private String ztytmttknsuiirirekikbnx10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX10)
    public String getZtytmttknsuiirirekikbnx10() {
        return ztytmttknsuiirirekikbnx10;
    }

    public void setZtytmttknsuiirirekikbnx10(String pZtytmttknsuiirirekikbnx10) {
        ztytmttknsuiirirekikbnx10 = pZtytmttknsuiirirekikbnx10;
    }

    private String ztykeiyakuoutoubix10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX10)
    public String getZtykeiyakuoutoubix10() {
        return ztykeiyakuoutoubix10;
    }

    public void setZtykeiyakuoutoubix10(String pZtykeiyakuoutoubix10) {
        ztykeiyakuoutoubix10 = pZtykeiyakuoutoubix10;
    }

    private String ztytmttknjyoutaix10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX10)
    public String getZtytmttknjyoutaix10() {
        return ztytmttknjyoutaix10;
    }

    public void setZtytmttknjyoutaix10(String pZtytmttknjyoutaix10) {
        ztytmttknjyoutaix10 = pZtytmttknjyoutaix10;
    }

    private String ztyptumitatekngkktuukax10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX10)
    public String getZtyptumitatekngkktuukax10() {
        return ztyptumitatekngkktuukax10;
    }

    public void setZtyptumitatekngkktuukax10(String pZtyptumitatekngkktuukax10) {
        ztyptumitatekngkktuukax10 = pZtyptumitatekngkktuukax10;
    }

    private String ztyptumitatekngkyenx10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX10)
    public String getZtyptumitatekngkyenx10() {
        return ztyptumitatekngkyenx10;
    }

    public void setZtyptumitatekngkyenx10(String pZtyptumitatekngkyenx10) {
        ztyptumitatekngkyenx10 = pZtyptumitatekngkyenx10;
    }

    private String ztysisuux10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX10)
    public String getZtysisuux10() {
        return ztysisuux10;
    }

    public void setZtysisuux10(String pZtysisuux10) {
        ztysisuux10 = pZtysisuux10;
    }

    private String ztysisuuuprituhugoux10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX10)
    public String getZtysisuuuprituhugoux10() {
        return ztysisuuuprituhugoux10;
    }

    public void setZtysisuuuprituhugoux10(String pZtysisuuuprituhugoux10) {
        ztysisuuuprituhugoux10 = pZtysisuuuprituhugoux10;
    }

    private String ztysisuuupritux10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX10)
    public String getZtysisuuupritux10() {
        return ztysisuuupritux10;
    }

    public void setZtysisuuupritux10(String pZtysisuuupritux10) {
        ztysisuuupritux10 = pZtysisuuupritux10;
    }

    private String ztytmttknzoukaritustrx10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX10)
    public String getZtytmttknzoukaritustrx10() {
        return ztytmttknzoukaritustrx10;
    }

    public void setZtytmttknzoukaritustrx10(String pZtytmttknzoukaritustrx10) {
        ztytmttknzoukaritustrx10 = pZtytmttknzoukaritustrx10;
    }

    private String ztykawaseratex10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX10)
    public String getZtykawaseratex10() {
        return ztykawaseratex10;
    }

    public void setZtykawaseratex10(String pZtykawaseratex10) {
        ztykawaseratex10 = pZtykawaseratex10;
    }

    private String ztytmttknsuiirirekikbnx11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIRIREKIKBNX11)
    public String getZtytmttknsuiirirekikbnx11() {
        return ztytmttknsuiirirekikbnx11;
    }

    public void setZtytmttknsuiirirekikbnx11(String pZtytmttknsuiirirekikbnx11) {
        ztytmttknsuiirirekikbnx11 = pZtytmttknsuiirirekikbnx11;
    }

    private String ztykeiyakuoutoubix11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKEIYAKUOUTOUBIX11)
    public String getZtykeiyakuoutoubix11() {
        return ztykeiyakuoutoubix11;
    }

    public void setZtykeiyakuoutoubix11(String pZtykeiyakuoutoubix11) {
        ztykeiyakuoutoubix11 = pZtykeiyakuoutoubix11;
    }

    private String ztytmttknjyoutaix11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNJYOUTAIX11)
    public String getZtytmttknjyoutaix11() {
        return ztytmttknjyoutaix11;
    }

    public void setZtytmttknjyoutaix11(String pZtytmttknjyoutaix11) {
        ztytmttknjyoutaix11 = pZtytmttknjyoutaix11;
    }

    private String ztyptumitatekngkktuukax11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKKTUUKAX11)
    public String getZtyptumitatekngkktuukax11() {
        return ztyptumitatekngkktuukax11;
    }

    public void setZtyptumitatekngkktuukax11(String pZtyptumitatekngkktuukax11) {
        ztyptumitatekngkktuukax11 = pZtyptumitatekngkktuukax11;
    }

    private String ztyptumitatekngkyenx11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPTUMITATEKNGKYENX11)
    public String getZtyptumitatekngkyenx11() {
        return ztyptumitatekngkyenx11;
    }

    public void setZtyptumitatekngkyenx11(String pZtyptumitatekngkyenx11) {
        ztyptumitatekngkyenx11 = pZtyptumitatekngkyenx11;
    }

    private String ztysisuux11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUX11)
    public String getZtysisuux11() {
        return ztysisuux11;
    }

    public void setZtysisuux11(String pZtysisuux11) {
        ztysisuux11 = pZtysisuux11;
    }

    private String ztysisuuuprituhugoux11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUHUGOUX11)
    public String getZtysisuuuprituhugoux11() {
        return ztysisuuuprituhugoux11;
    }

    public void setZtysisuuuprituhugoux11(String pZtysisuuuprituhugoux11) {
        ztysisuuuprituhugoux11 = pZtysisuuuprituhugoux11;
    }

    private String ztysisuuupritux11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSISUUUPRITUX11)
    public String getZtysisuuupritux11() {
        return ztysisuuupritux11;
    }

    public void setZtysisuuupritux11(String pZtysisuuupritux11) {
        ztysisuuupritux11 = pZtysisuuupritux11;
    }

    private String ztytmttknzoukaritustrx11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNZOUKARITUSTRX11)
    public String getZtytmttknzoukaritustrx11() {
        return ztytmttknzoukaritustrx11;
    }

    public void setZtytmttknzoukaritustrx11(String pZtytmttknzoukaritustrx11) {
        ztytmttknzoukaritustrx11 = pZtytmttknzoukaritustrx11;
    }

    private String ztykawaseratex11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAWASERATEX11)
    public String getZtykawaseratex11() {
        return ztykawaseratex11;
    }

    public void setZtykawaseratex11(String pZtykawaseratex11) {
        ztykawaseratex11 = pZtykawaseratex11;
    }

    private String ztytmttknsuiiyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTMTTKNSUIIYOBI)
    public String getZtytmttknsuiiyobi() {
        return ztytmttknsuiiyobi;
    }

    public void setZtytmttknsuiiyobi(String pZtytmttknsuiiyobi) {
        ztytmttknsuiiyobi = pZtytmttknsuiiyobi;
    }

    private String ztyttdkkigen;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTTDKKIGEN)
    public String getZtyttdkkigen() {
        return ztyttdkkigen;
    }

    public void setZtyttdkkigen(String pZtyttdkkigen) {
        ztyttdkkigen = pZtyttdkkigen;
    }

    private String ztykrnkgnsgk;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKRNKGNSGK)
    public String getZtykrnkgnsgk() {
        return ztykrnkgnsgk;
    }

    public void setZtykrnkgnsgk(String pZtykrnkgnsgk) {
        ztykrnkgnsgk = pZtykrnkgnsgk;
    }

    private String ztytirtitnttdkyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTIRTITNTTDKYOBI)
    public String getZtytirtitnttdkyobi() {
        return ztytirtitnttdkyobi;
    }

    public void setZtytirtitnttdkyobi(String pZtytirtitnttdkyobi) {
        ztytirtitnttdkyobi = pZtytirtitnttdkyobi;
    }

    private String ztyskshozonnensuu;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYSKSHOZONNENSUU)
    public String getZtyskshozonnensuu() {
        return ztyskshozonnensuu;
    }

    public void setZtyskshozonnensuu(String pZtyskshozonnensuu) {
        ztyskshozonnensuu = pZtyskshozonnensuu;
    }

    private String ztydocumentid;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYDOCUMENTID)
    public String getZtydocumentid() {
        return ztydocumentid;
    }

    public void setZtydocumentid(String pZtydocumentid) {
        ztydocumentid = pZtydocumentid;
    }

    private String ztytoritugisyasyozokunm;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYTORITUGISYASYOZOKUNM)
    public String getZtytoritugisyasyozokunm() {
        return ztytoritugisyasyozokunm;
    }

    public void setZtytoritugisyasyozokunm(String pZtytoritugisyasyozokunm) {
        ztytoritugisyasyozokunm = pZtytoritugisyasyozokunm;
    }

    private String ztyyendthnkhrsksyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYENDTHNKHRSKSYOBI)
    public String getZtyyendthnkhrsksyobi() {
        return ztyyendthnkhrsksyobi;
    }

    public void setZtyyendthnkhrsksyobi(String pZtyyendthnkhrsksyobi) {
        ztyyendthnkhrsksyobi = pZtyyendthnkhrsksyobi;
    }

    private String ztyyoteiriritukijyunym1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM1)
    public String getZtyyoteiriritukijyunym1() {
        return ztyyoteiriritukijyunym1;
    }

    public void setZtyyoteiriritukijyunym1(String pZtyyoteiriritukijyunym1) {
        ztyyoteiriritukijyunym1 = pZtyyoteiriritukijyunym1;
    }

    private String ztyyoteiriritu1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU1)
    public String getZtyyoteiriritu1() {
        return ztyyoteiriritu1;
    }

    public void setZtyyoteiriritu1(String pZtyyoteiriritu1) {
        ztyyoteiriritu1 = pZtyyoteiriritu1;
    }

    private String ztyytirrtcalckijyunrrt1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT1)
    public String getZtyytirrtcalckijyunrrt1() {
        return ztyytirrtcalckijyunrrt1;
    }

    public void setZtyytirrtcalckijyunrrt1(String pZtyytirrtcalckijyunrrt1) {
        ztyytirrtcalckijyunrrt1 = pZtyytirrtcalckijyunrrt1;
    }

    private String ztykwsratekijyunym1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM1)
    public String getZtykwsratekijyunym1() {
        return ztykwsratekijyunym1;
    }

    public void setZtykwsratekijyunym1(String pZtykwsratekijyunym1) {
        ztykwsratekijyunym1 = pZtykwsratekijyunym1;
    }

    private String ztykaknsnkwsrate1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE1)
    public String getZtykaknsnkwsrate1() {
        return ztykaknsnkwsrate1;
    }

    public void setZtykaknsnkwsrate1(String pZtykaknsnkwsrate1) {
        ztykaknsnkwsrate1 = pZtykaknsnkwsrate1;
    }

    private String ztypgaika1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA1)
    public String getZtypgaika1() {
        return ztypgaika1;
    }

    public void setZtypgaika1(String pZtypgaika1) {
        ztypgaika1 = pZtypgaika1;
    }

    private String ztypyen1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN1)
    public String getZtypyen1() {
        return ztypyen1;
    }

    public void setZtypyen1(String pZtypyen1) {
        ztypyen1 = pZtypyen1;
    }

    private String ztyyoteiriritukijyunym2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM2)
    public String getZtyyoteiriritukijyunym2() {
        return ztyyoteiriritukijyunym2;
    }

    public void setZtyyoteiriritukijyunym2(String pZtyyoteiriritukijyunym2) {
        ztyyoteiriritukijyunym2 = pZtyyoteiriritukijyunym2;
    }

    private String ztyyoteiriritu2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU2)
    public String getZtyyoteiriritu2() {
        return ztyyoteiriritu2;
    }

    public void setZtyyoteiriritu2(String pZtyyoteiriritu2) {
        ztyyoteiriritu2 = pZtyyoteiriritu2;
    }

    private String ztyytirrtcalckijyunrrt2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT2)
    public String getZtyytirrtcalckijyunrrt2() {
        return ztyytirrtcalckijyunrrt2;
    }

    public void setZtyytirrtcalckijyunrrt2(String pZtyytirrtcalckijyunrrt2) {
        ztyytirrtcalckijyunrrt2 = pZtyytirrtcalckijyunrrt2;
    }

    private String ztykwsratekijyunym2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM2)
    public String getZtykwsratekijyunym2() {
        return ztykwsratekijyunym2;
    }

    public void setZtykwsratekijyunym2(String pZtykwsratekijyunym2) {
        ztykwsratekijyunym2 = pZtykwsratekijyunym2;
    }

    private String ztykaknsnkwsrate2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE2)
    public String getZtykaknsnkwsrate2() {
        return ztykaknsnkwsrate2;
    }

    public void setZtykaknsnkwsrate2(String pZtykaknsnkwsrate2) {
        ztykaknsnkwsrate2 = pZtykaknsnkwsrate2;
    }

    private String ztypgaika2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA2)
    public String getZtypgaika2() {
        return ztypgaika2;
    }

    public void setZtypgaika2(String pZtypgaika2) {
        ztypgaika2 = pZtypgaika2;
    }

    private String ztypyen2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN2)
    public String getZtypyen2() {
        return ztypyen2;
    }

    public void setZtypyen2(String pZtypyen2) {
        ztypyen2 = pZtypyen2;
    }

    private String ztyyoteiriritukijyunym3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM3)
    public String getZtyyoteiriritukijyunym3() {
        return ztyyoteiriritukijyunym3;
    }

    public void setZtyyoteiriritukijyunym3(String pZtyyoteiriritukijyunym3) {
        ztyyoteiriritukijyunym3 = pZtyyoteiriritukijyunym3;
    }

    private String ztyyoteiriritu3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU3)
    public String getZtyyoteiriritu3() {
        return ztyyoteiriritu3;
    }

    public void setZtyyoteiriritu3(String pZtyyoteiriritu3) {
        ztyyoteiriritu3 = pZtyyoteiriritu3;
    }

    private String ztyytirrtcalckijyunrrt3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT3)
    public String getZtyytirrtcalckijyunrrt3() {
        return ztyytirrtcalckijyunrrt3;
    }

    public void setZtyytirrtcalckijyunrrt3(String pZtyytirrtcalckijyunrrt3) {
        ztyytirrtcalckijyunrrt3 = pZtyytirrtcalckijyunrrt3;
    }

    private String ztykwsratekijyunym3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM3)
    public String getZtykwsratekijyunym3() {
        return ztykwsratekijyunym3;
    }

    public void setZtykwsratekijyunym3(String pZtykwsratekijyunym3) {
        ztykwsratekijyunym3 = pZtykwsratekijyunym3;
    }

    private String ztykaknsnkwsrate3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE3)
    public String getZtykaknsnkwsrate3() {
        return ztykaknsnkwsrate3;
    }

    public void setZtykaknsnkwsrate3(String pZtykaknsnkwsrate3) {
        ztykaknsnkwsrate3 = pZtykaknsnkwsrate3;
    }

    private String ztypgaika3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA3)
    public String getZtypgaika3() {
        return ztypgaika3;
    }

    public void setZtypgaika3(String pZtypgaika3) {
        ztypgaika3 = pZtypgaika3;
    }

    private String ztypyen3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN3)
    public String getZtypyen3() {
        return ztypyen3;
    }

    public void setZtypyen3(String pZtypyen3) {
        ztypyen3 = pZtypyen3;
    }

    private String ztyyoteiriritukijyunym4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM4)
    public String getZtyyoteiriritukijyunym4() {
        return ztyyoteiriritukijyunym4;
    }

    public void setZtyyoteiriritukijyunym4(String pZtyyoteiriritukijyunym4) {
        ztyyoteiriritukijyunym4 = pZtyyoteiriritukijyunym4;
    }

    private String ztyyoteiriritu4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU4)
    public String getZtyyoteiriritu4() {
        return ztyyoteiriritu4;
    }

    public void setZtyyoteiriritu4(String pZtyyoteiriritu4) {
        ztyyoteiriritu4 = pZtyyoteiriritu4;
    }

    private String ztyytirrtcalckijyunrrt4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT4)
    public String getZtyytirrtcalckijyunrrt4() {
        return ztyytirrtcalckijyunrrt4;
    }

    public void setZtyytirrtcalckijyunrrt4(String pZtyytirrtcalckijyunrrt4) {
        ztyytirrtcalckijyunrrt4 = pZtyytirrtcalckijyunrrt4;
    }

    private String ztykwsratekijyunym4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM4)
    public String getZtykwsratekijyunym4() {
        return ztykwsratekijyunym4;
    }

    public void setZtykwsratekijyunym4(String pZtykwsratekijyunym4) {
        ztykwsratekijyunym4 = pZtykwsratekijyunym4;
    }

    private String ztykaknsnkwsrate4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE4)
    public String getZtykaknsnkwsrate4() {
        return ztykaknsnkwsrate4;
    }

    public void setZtykaknsnkwsrate4(String pZtykaknsnkwsrate4) {
        ztykaknsnkwsrate4 = pZtykaknsnkwsrate4;
    }

    private String ztypgaika4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA4)
    public String getZtypgaika4() {
        return ztypgaika4;
    }

    public void setZtypgaika4(String pZtypgaika4) {
        ztypgaika4 = pZtypgaika4;
    }

    private String ztypyen4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN4)
    public String getZtypyen4() {
        return ztypyen4;
    }

    public void setZtypyen4(String pZtypyen4) {
        ztypyen4 = pZtypyen4;
    }

    private String ztyyoteiriritukijyunym5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM5)
    public String getZtyyoteiriritukijyunym5() {
        return ztyyoteiriritukijyunym5;
    }

    public void setZtyyoteiriritukijyunym5(String pZtyyoteiriritukijyunym5) {
        ztyyoteiriritukijyunym5 = pZtyyoteiriritukijyunym5;
    }

    private String ztyyoteiriritu5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU5)
    public String getZtyyoteiriritu5() {
        return ztyyoteiriritu5;
    }

    public void setZtyyoteiriritu5(String pZtyyoteiriritu5) {
        ztyyoteiriritu5 = pZtyyoteiriritu5;
    }

    private String ztyytirrtcalckijyunrrt5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT5)
    public String getZtyytirrtcalckijyunrrt5() {
        return ztyytirrtcalckijyunrrt5;
    }

    public void setZtyytirrtcalckijyunrrt5(String pZtyytirrtcalckijyunrrt5) {
        ztyytirrtcalckijyunrrt5 = pZtyytirrtcalckijyunrrt5;
    }

    private String ztykwsratekijyunym5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM5)
    public String getZtykwsratekijyunym5() {
        return ztykwsratekijyunym5;
    }

    public void setZtykwsratekijyunym5(String pZtykwsratekijyunym5) {
        ztykwsratekijyunym5 = pZtykwsratekijyunym5;
    }

    private String ztykaknsnkwsrate5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE5)
    public String getZtykaknsnkwsrate5() {
        return ztykaknsnkwsrate5;
    }

    public void setZtykaknsnkwsrate5(String pZtykaknsnkwsrate5) {
        ztykaknsnkwsrate5 = pZtykaknsnkwsrate5;
    }

    private String ztypgaika5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA5)
    public String getZtypgaika5() {
        return ztypgaika5;
    }

    public void setZtypgaika5(String pZtypgaika5) {
        ztypgaika5 = pZtypgaika5;
    }

    private String ztypyen5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN5)
    public String getZtypyen5() {
        return ztypyen5;
    }

    public void setZtypyen5(String pZtypyen5) {
        ztypyen5 = pZtypyen5;
    }

    private String ztyyoteiriritukijyunym6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM6)
    public String getZtyyoteiriritukijyunym6() {
        return ztyyoteiriritukijyunym6;
    }

    public void setZtyyoteiriritukijyunym6(String pZtyyoteiriritukijyunym6) {
        ztyyoteiriritukijyunym6 = pZtyyoteiriritukijyunym6;
    }

    private String ztyyoteiriritu6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU6)
    public String getZtyyoteiriritu6() {
        return ztyyoteiriritu6;
    }

    public void setZtyyoteiriritu6(String pZtyyoteiriritu6) {
        ztyyoteiriritu6 = pZtyyoteiriritu6;
    }

    private String ztyytirrtcalckijyunrrt6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT6)
    public String getZtyytirrtcalckijyunrrt6() {
        return ztyytirrtcalckijyunrrt6;
    }

    public void setZtyytirrtcalckijyunrrt6(String pZtyytirrtcalckijyunrrt6) {
        ztyytirrtcalckijyunrrt6 = pZtyytirrtcalckijyunrrt6;
    }

    private String ztykwsratekijyunym6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM6)
    public String getZtykwsratekijyunym6() {
        return ztykwsratekijyunym6;
    }

    public void setZtykwsratekijyunym6(String pZtykwsratekijyunym6) {
        ztykwsratekijyunym6 = pZtykwsratekijyunym6;
    }

    private String ztykaknsnkwsrate6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE6)
    public String getZtykaknsnkwsrate6() {
        return ztykaknsnkwsrate6;
    }

    public void setZtykaknsnkwsrate6(String pZtykaknsnkwsrate6) {
        ztykaknsnkwsrate6 = pZtykaknsnkwsrate6;
    }

    private String ztypgaika6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA6)
    public String getZtypgaika6() {
        return ztypgaika6;
    }

    public void setZtypgaika6(String pZtypgaika6) {
        ztypgaika6 = pZtypgaika6;
    }

    private String ztypyen6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN6)
    public String getZtypyen6() {
        return ztypyen6;
    }

    public void setZtypyen6(String pZtypyen6) {
        ztypyen6 = pZtypyen6;
    }

    private String ztyyoteiriritukijyunym7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM7)
    public String getZtyyoteiriritukijyunym7() {
        return ztyyoteiriritukijyunym7;
    }

    public void setZtyyoteiriritukijyunym7(String pZtyyoteiriritukijyunym7) {
        ztyyoteiriritukijyunym7 = pZtyyoteiriritukijyunym7;
    }

    private String ztyyoteiriritu7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU7)
    public String getZtyyoteiriritu7() {
        return ztyyoteiriritu7;
    }

    public void setZtyyoteiriritu7(String pZtyyoteiriritu7) {
        ztyyoteiriritu7 = pZtyyoteiriritu7;
    }

    private String ztyytirrtcalckijyunrrt7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT7)
    public String getZtyytirrtcalckijyunrrt7() {
        return ztyytirrtcalckijyunrrt7;
    }

    public void setZtyytirrtcalckijyunrrt7(String pZtyytirrtcalckijyunrrt7) {
        ztyytirrtcalckijyunrrt7 = pZtyytirrtcalckijyunrrt7;
    }

    private String ztykwsratekijyunym7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM7)
    public String getZtykwsratekijyunym7() {
        return ztykwsratekijyunym7;
    }

    public void setZtykwsratekijyunym7(String pZtykwsratekijyunym7) {
        ztykwsratekijyunym7 = pZtykwsratekijyunym7;
    }

    private String ztykaknsnkwsrate7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE7)
    public String getZtykaknsnkwsrate7() {
        return ztykaknsnkwsrate7;
    }

    public void setZtykaknsnkwsrate7(String pZtykaknsnkwsrate7) {
        ztykaknsnkwsrate7 = pZtykaknsnkwsrate7;
    }

    private String ztypgaika7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA7)
    public String getZtypgaika7() {
        return ztypgaika7;
    }

    public void setZtypgaika7(String pZtypgaika7) {
        ztypgaika7 = pZtypgaika7;
    }

    private String ztypyen7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN7)
    public String getZtypyen7() {
        return ztypyen7;
    }

    public void setZtypyen7(String pZtypyen7) {
        ztypyen7 = pZtypyen7;
    }

    private String ztyyoteiriritukijyunym8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM8)
    public String getZtyyoteiriritukijyunym8() {
        return ztyyoteiriritukijyunym8;
    }

    public void setZtyyoteiriritukijyunym8(String pZtyyoteiriritukijyunym8) {
        ztyyoteiriritukijyunym8 = pZtyyoteiriritukijyunym8;
    }

    private String ztyyoteiriritu8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU8)
    public String getZtyyoteiriritu8() {
        return ztyyoteiriritu8;
    }

    public void setZtyyoteiriritu8(String pZtyyoteiriritu8) {
        ztyyoteiriritu8 = pZtyyoteiriritu8;
    }

    private String ztyytirrtcalckijyunrrt8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT8)
    public String getZtyytirrtcalckijyunrrt8() {
        return ztyytirrtcalckijyunrrt8;
    }

    public void setZtyytirrtcalckijyunrrt8(String pZtyytirrtcalckijyunrrt8) {
        ztyytirrtcalckijyunrrt8 = pZtyytirrtcalckijyunrrt8;
    }

    private String ztykwsratekijyunym8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM8)
    public String getZtykwsratekijyunym8() {
        return ztykwsratekijyunym8;
    }

    public void setZtykwsratekijyunym8(String pZtykwsratekijyunym8) {
        ztykwsratekijyunym8 = pZtykwsratekijyunym8;
    }

    private String ztykaknsnkwsrate8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE8)
    public String getZtykaknsnkwsrate8() {
        return ztykaknsnkwsrate8;
    }

    public void setZtykaknsnkwsrate8(String pZtykaknsnkwsrate8) {
        ztykaknsnkwsrate8 = pZtykaknsnkwsrate8;
    }

    private String ztypgaika8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA8)
    public String getZtypgaika8() {
        return ztypgaika8;
    }

    public void setZtypgaika8(String pZtypgaika8) {
        ztypgaika8 = pZtypgaika8;
    }

    private String ztypyen8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN8)
    public String getZtypyen8() {
        return ztypyen8;
    }

    public void setZtypyen8(String pZtypyen8) {
        ztypyen8 = pZtypyen8;
    }

    private String ztyyoteiriritukijyunym9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM9)
    public String getZtyyoteiriritukijyunym9() {
        return ztyyoteiriritukijyunym9;
    }

    public void setZtyyoteiriritukijyunym9(String pZtyyoteiriritukijyunym9) {
        ztyyoteiriritukijyunym9 = pZtyyoteiriritukijyunym9;
    }

    private String ztyyoteiriritu9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU9)
    public String getZtyyoteiriritu9() {
        return ztyyoteiriritu9;
    }

    public void setZtyyoteiriritu9(String pZtyyoteiriritu9) {
        ztyyoteiriritu9 = pZtyyoteiriritu9;
    }

    private String ztyytirrtcalckijyunrrt9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT9)
    public String getZtyytirrtcalckijyunrrt9() {
        return ztyytirrtcalckijyunrrt9;
    }

    public void setZtyytirrtcalckijyunrrt9(String pZtyytirrtcalckijyunrrt9) {
        ztyytirrtcalckijyunrrt9 = pZtyytirrtcalckijyunrrt9;
    }

    private String ztykwsratekijyunym9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM9)
    public String getZtykwsratekijyunym9() {
        return ztykwsratekijyunym9;
    }

    public void setZtykwsratekijyunym9(String pZtykwsratekijyunym9) {
        ztykwsratekijyunym9 = pZtykwsratekijyunym9;
    }

    private String ztykaknsnkwsrate9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE9)
    public String getZtykaknsnkwsrate9() {
        return ztykaknsnkwsrate9;
    }

    public void setZtykaknsnkwsrate9(String pZtykaknsnkwsrate9) {
        ztykaknsnkwsrate9 = pZtykaknsnkwsrate9;
    }

    private String ztypgaika9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA9)
    public String getZtypgaika9() {
        return ztypgaika9;
    }

    public void setZtypgaika9(String pZtypgaika9) {
        ztypgaika9 = pZtypgaika9;
    }

    private String ztypyen9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN9)
    public String getZtypyen9() {
        return ztypyen9;
    }

    public void setZtypyen9(String pZtypyen9) {
        ztypyen9 = pZtypyen9;
    }

    private String ztyyoteiriritukijyunym10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM10)
    public String getZtyyoteiriritukijyunym10() {
        return ztyyoteiriritukijyunym10;
    }

    public void setZtyyoteiriritukijyunym10(String pZtyyoteiriritukijyunym10) {
        ztyyoteiriritukijyunym10 = pZtyyoteiriritukijyunym10;
    }

    private String ztyyoteiriritu10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU10)
    public String getZtyyoteiriritu10() {
        return ztyyoteiriritu10;
    }

    public void setZtyyoteiriritu10(String pZtyyoteiriritu10) {
        ztyyoteiriritu10 = pZtyyoteiriritu10;
    }

    private String ztyytirrtcalckijyunrrt10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT10)
    public String getZtyytirrtcalckijyunrrt10() {
        return ztyytirrtcalckijyunrrt10;
    }

    public void setZtyytirrtcalckijyunrrt10(String pZtyytirrtcalckijyunrrt10) {
        ztyytirrtcalckijyunrrt10 = pZtyytirrtcalckijyunrrt10;
    }

    private String ztykwsratekijyunym10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM10)
    public String getZtykwsratekijyunym10() {
        return ztykwsratekijyunym10;
    }

    public void setZtykwsratekijyunym10(String pZtykwsratekijyunym10) {
        ztykwsratekijyunym10 = pZtykwsratekijyunym10;
    }

    private String ztykaknsnkwsrate10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE10)
    public String getZtykaknsnkwsrate10() {
        return ztykaknsnkwsrate10;
    }

    public void setZtykaknsnkwsrate10(String pZtykaknsnkwsrate10) {
        ztykaknsnkwsrate10 = pZtykaknsnkwsrate10;
    }

    private String ztypgaika10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA10)
    public String getZtypgaika10() {
        return ztypgaika10;
    }

    public void setZtypgaika10(String pZtypgaika10) {
        ztypgaika10 = pZtypgaika10;
    }

    private String ztypyen10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN10)
    public String getZtypyen10() {
        return ztypyen10;
    }

    public void setZtypyen10(String pZtypyen10) {
        ztypyen10 = pZtypyen10;
    }

    private String ztyyoteiriritukijyunym11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM11)
    public String getZtyyoteiriritukijyunym11() {
        return ztyyoteiriritukijyunym11;
    }

    public void setZtyyoteiriritukijyunym11(String pZtyyoteiriritukijyunym11) {
        ztyyoteiriritukijyunym11 = pZtyyoteiriritukijyunym11;
    }

    private String ztyyoteiriritu11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU11)
    public String getZtyyoteiriritu11() {
        return ztyyoteiriritu11;
    }

    public void setZtyyoteiriritu11(String pZtyyoteiriritu11) {
        ztyyoteiriritu11 = pZtyyoteiriritu11;
    }

    private String ztyytirrtcalckijyunrrt11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT11)
    public String getZtyytirrtcalckijyunrrt11() {
        return ztyytirrtcalckijyunrrt11;
    }

    public void setZtyytirrtcalckijyunrrt11(String pZtyytirrtcalckijyunrrt11) {
        ztyytirrtcalckijyunrrt11 = pZtyytirrtcalckijyunrrt11;
    }

    private String ztykwsratekijyunym11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM11)
    public String getZtykwsratekijyunym11() {
        return ztykwsratekijyunym11;
    }

    public void setZtykwsratekijyunym11(String pZtykwsratekijyunym11) {
        ztykwsratekijyunym11 = pZtykwsratekijyunym11;
    }

    private String ztykaknsnkwsrate11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE11)
    public String getZtykaknsnkwsrate11() {
        return ztykaknsnkwsrate11;
    }

    public void setZtykaknsnkwsrate11(String pZtykaknsnkwsrate11) {
        ztykaknsnkwsrate11 = pZtykaknsnkwsrate11;
    }

    private String ztypgaika11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA11)
    public String getZtypgaika11() {
        return ztypgaika11;
    }

    public void setZtypgaika11(String pZtypgaika11) {
        ztypgaika11 = pZtypgaika11;
    }

    private String ztypyen11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN11)
    public String getZtypyen11() {
        return ztypyen11;
    }

    public void setZtypyen11(String pZtypyen11) {
        ztypyen11 = pZtypyen11;
    }

    private String ztyyoteiriritukijyunym12;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITUKIJYUNYM12)
    public String getZtyyoteiriritukijyunym12() {
        return ztyyoteiriritukijyunym12;
    }

    public void setZtyyoteiriritukijyunym12(String pZtyyoteiriritukijyunym12) {
        ztyyoteiriritukijyunym12 = pZtyyoteiriritukijyunym12;
    }

    private String ztyyoteiriritu12;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYOTEIRIRITU12)
    public String getZtyyoteiriritu12() {
        return ztyyoteiriritu12;
    }

    public void setZtyyoteiriritu12(String pZtyyoteiriritu12) {
        ztyyoteiriritu12 = pZtyyoteiriritu12;
    }

    private String ztyytirrtcalckijyunrrt12;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTCALCKIJYUNRRT12)
    public String getZtyytirrtcalckijyunrrt12() {
        return ztyytirrtcalckijyunrrt12;
    }

    public void setZtyytirrtcalckijyunrrt12(String pZtyytirrtcalckijyunrrt12) {
        ztyytirrtcalckijyunrrt12 = pZtyytirrtcalckijyunrrt12;
    }

    private String ztykwsratekijyunym12;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKWSRATEKIJYUNYM12)
    public String getZtykwsratekijyunym12() {
        return ztykwsratekijyunym12;
    }

    public void setZtykwsratekijyunym12(String pZtykwsratekijyunym12) {
        ztykwsratekijyunym12 = pZtykwsratekijyunym12;
    }

    private String ztykaknsnkwsrate12;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYKAKNSNKWSRATE12)
    public String getZtykaknsnkwsrate12() {
        return ztykaknsnkwsrate12;
    }

    public void setZtykaknsnkwsrate12(String pZtykaknsnkwsrate12) {
        ztykaknsnkwsrate12 = pZtykaknsnkwsrate12;
    }

    private String ztypgaika12;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPGAIKA12)
    public String getZtypgaika12() {
        return ztypgaika12;
    }

    public void setZtypgaika12(String pZtypgaika12) {
        ztypgaika12 = pZtypgaika12;
    }

    private String ztypyen12;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYPYEN12)
    public String getZtypyen12() {
        return ztypyen12;
    }

    public void setZtypyen12(String pZtypyen12) {
        ztypyen12 = pZtypyen12;
    }

    private String ztyfstphyoujikbn1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN1)
    public String getZtyfstphyoujikbn1() {
        return ztyfstphyoujikbn1;
    }

    public void setZtyfstphyoujikbn1(String pZtyfstphyoujikbn1) {
        ztyfstphyoujikbn1 = pZtyfstphyoujikbn1;
    }

    private String ztyfstphyoujikbn2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN2)
    public String getZtyfstphyoujikbn2() {
        return ztyfstphyoujikbn2;
    }

    public void setZtyfstphyoujikbn2(String pZtyfstphyoujikbn2) {
        ztyfstphyoujikbn2 = pZtyfstphyoujikbn2;
    }

    private String ztyfstphyoujikbn3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN3)
    public String getZtyfstphyoujikbn3() {
        return ztyfstphyoujikbn3;
    }

    public void setZtyfstphyoujikbn3(String pZtyfstphyoujikbn3) {
        ztyfstphyoujikbn3 = pZtyfstphyoujikbn3;
    }

    private String ztyfstphyoujikbn4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN4)
    public String getZtyfstphyoujikbn4() {
        return ztyfstphyoujikbn4;
    }

    public void setZtyfstphyoujikbn4(String pZtyfstphyoujikbn4) {
        ztyfstphyoujikbn4 = pZtyfstphyoujikbn4;
    }

    private String ztyfstphyoujikbn5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN5)
    public String getZtyfstphyoujikbn5() {
        return ztyfstphyoujikbn5;
    }

    public void setZtyfstphyoujikbn5(String pZtyfstphyoujikbn5) {
        ztyfstphyoujikbn5 = pZtyfstphyoujikbn5;
    }

    private String ztyfstphyoujikbn6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN6)
    public String getZtyfstphyoujikbn6() {
        return ztyfstphyoujikbn6;
    }

    public void setZtyfstphyoujikbn6(String pZtyfstphyoujikbn6) {
        ztyfstphyoujikbn6 = pZtyfstphyoujikbn6;
    }

    private String ztyfstphyoujikbn7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN7)
    public String getZtyfstphyoujikbn7() {
        return ztyfstphyoujikbn7;
    }

    public void setZtyfstphyoujikbn7(String pZtyfstphyoujikbn7) {
        ztyfstphyoujikbn7 = pZtyfstphyoujikbn7;
    }

    private String ztyfstphyoujikbn8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN8)
    public String getZtyfstphyoujikbn8() {
        return ztyfstphyoujikbn8;
    }

    public void setZtyfstphyoujikbn8(String pZtyfstphyoujikbn8) {
        ztyfstphyoujikbn8 = pZtyfstphyoujikbn8;
    }

    private String ztyfstphyoujikbn9;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN9)
    public String getZtyfstphyoujikbn9() {
        return ztyfstphyoujikbn9;
    }

    public void setZtyfstphyoujikbn9(String pZtyfstphyoujikbn9) {
        ztyfstphyoujikbn9 = pZtyfstphyoujikbn9;
    }

    private String ztyfstphyoujikbn10;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN10)
    public String getZtyfstphyoujikbn10() {
        return ztyfstphyoujikbn10;
    }

    public void setZtyfstphyoujikbn10(String pZtyfstphyoujikbn10) {
        ztyfstphyoujikbn10 = pZtyfstphyoujikbn10;
    }

    private String ztyfstphyoujikbn11;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN11)
    public String getZtyfstphyoujikbn11() {
        return ztyfstphyoujikbn11;
    }

    public void setZtyfstphyoujikbn11(String pZtyfstphyoujikbn11) {
        ztyfstphyoujikbn11 = pZtyfstphyoujikbn11;
    }

    private String ztyfstphyoujikbn12;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYFSTPHYOUJIKBN12)
    public String getZtyfstphyoujikbn12() {
        return ztyfstphyoujikbn12;
    }

    public void setZtyfstphyoujikbn12(String pZtyfstphyoujikbn12) {
        ztyfstphyoujikbn12 = pZtyfstphyoujikbn12;
    }

    private String ztyytirrtitrnyobi2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTITRNYOBI2)
    public String getZtyytirrtitrnyobi2() {
        return ztyytirrtitrnyobi2;
    }

    public void setZtyytirrtitrnyobi2(String pZtyytirrtitrnyobi2) {
        ztyytirrtitrnyobi2 = pZtyytirrtitrnyobi2;
    }

    private String ztyytirrtitrnhskmsgcd1;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTITRNHSKMSGCD1)
    public String getZtyytirrtitrnhskmsgcd1() {
        return ztyytirrtitrnhskmsgcd1;
    }

    public void setZtyytirrtitrnhskmsgcd1(String pZtyytirrtitrnhskmsgcd1) {
        ztyytirrtitrnhskmsgcd1 = pZtyytirrtitrnhskmsgcd1;
    }

    private String ztyytirrtitrnhskmsgcd2;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTITRNHSKMSGCD2)
    public String getZtyytirrtitrnhskmsgcd2() {
        return ztyytirrtitrnhskmsgcd2;
    }

    public void setZtyytirrtitrnhskmsgcd2(String pZtyytirrtitrnhskmsgcd2) {
        ztyytirrtitrnhskmsgcd2 = pZtyytirrtitrnhskmsgcd2;
    }

    private String ztyytirrtitrnhskmsgcd3;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTITRNHSKMSGCD3)
    public String getZtyytirrtitrnhskmsgcd3() {
        return ztyytirrtitrnhskmsgcd3;
    }

    public void setZtyytirrtitrnhskmsgcd3(String pZtyytirrtitrnhskmsgcd3) {
        ztyytirrtitrnhskmsgcd3 = pZtyytirrtitrnhskmsgcd3;
    }

    private String ztyytirrtitrnhskmsgcd4;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTITRNHSKMSGCD4)
    public String getZtyytirrtitrnhskmsgcd4() {
        return ztyytirrtitrnhskmsgcd4;
    }

    public void setZtyytirrtitrnhskmsgcd4(String pZtyytirrtitrnhskmsgcd4) {
        ztyytirrtitrnhskmsgcd4 = pZtyytirrtitrnhskmsgcd4;
    }

    private String ztyytirrtitrnhskmsgcd5;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTITRNHSKMSGCD5)
    public String getZtyytirrtitrnhskmsgcd5() {
        return ztyytirrtitrnhskmsgcd5;
    }

    public void setZtyytirrtitrnhskmsgcd5(String pZtyytirrtitrnhskmsgcd5) {
        ztyytirrtitrnhskmsgcd5 = pZtyytirrtitrnhskmsgcd5;
    }

    private String ztyytirrtitrnhskmsgcd6;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTITRNHSKMSGCD6)
    public String getZtyytirrtitrnhskmsgcd6() {
        return ztyytirrtitrnhskmsgcd6;
    }

    public void setZtyytirrtitrnhskmsgcd6(String pZtyytirrtitrnhskmsgcd6) {
        ztyytirrtitrnhskmsgcd6 = pZtyytirrtitrnhskmsgcd6;
    }

    private String ztyytirrtitrnhskmsgcd7;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTITRNHSKMSGCD7)
    public String getZtyytirrtitrnhskmsgcd7() {
        return ztyytirrtitrnhskmsgcd7;
    }

    public void setZtyytirrtitrnhskmsgcd7(String pZtyytirrtitrnhskmsgcd7) {
        ztyytirrtitrnhskmsgcd7 = pZtyytirrtitrnhskmsgcd7;
    }

    private String ztyytirrtitrnhskmsgcd8;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTITRNHSKMSGCD8)
    public String getZtyytirrtitrnhskmsgcd8() {
        return ztyytirrtitrnhskmsgcd8;
    }

    public void setZtyytirrtitrnhskmsgcd8(String pZtyytirrtitrnhskmsgcd8) {
        ztyytirrtitrnhskmsgcd8 = pZtyytirrtitrnhskmsgcd8;
    }

    private String ztyytirrtitrnyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiTy.ZTYYTIRRTITRNYOBI)
    public String getZtyytirrtitrnyobi() {
        return ztyytirrtitrnyobi;
    }

    public void setZtyytirrtitrnyobi(String pZtyytirrtitrnyobi) {
        ztyytirrtitrnyobi = pZtyytirrtitrnyobi;
    }
}