package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.id.PKZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.meta.GenQZT_GaikaKokyakuTuutiRn;
import yuyu.def.db.meta.QZT_GaikaKokyakuTuutiRn;

/**
 * 外貨建顧客通知Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_GaikaKokyakuTuutiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_GaikaKokyakuTuutiRn}</td><td colspan="3">外貨建顧客通知Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_GaikaKokyakuTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_GaikaKokyakuTuutiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsclatosyono zrnsclatosyono}</td><td>（連携用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndskaiyktirasidouhuukbn zrndskaiyktirasidouhuukbn}</td><td>（連携用）ＤＳ解約チラシ同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrknkanssiryodouhuukbn zrnhrknkanssiryodouhuukbn}</td><td>（連携用）返戻金請求勧奨資料同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnassistplustirasidhkbn zrnassistplustirasidhkbn}</td><td>（連携用）アシストプラスチラシ同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkoktuutireportlayoutptn zrnkoktuutireportlayoutptn}</td><td>（連携用）顧客通知帳票レイアウトパターン</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngengkumu zrngengkumu}</td><td>（連携用）減額有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkytkmkyobi1 zrnkytkmkyobi1}</td><td>（連携用）共通項目予備項目１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuusinsakiyuubinno zrntuusinsakiyuubinno}</td><td>（連携用）通信先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinadr1kj zrntsinadr1kj}</td><td>（連携用）通信先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinadr2kj zrntsinadr2kj}</td><td>（連携用）通信先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinadr3kj zrntsinadr3kj}</td><td>（連携用）通信先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsintelno zrntsintelno}</td><td>（連携用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsinnm18 zrntsinnm18}</td><td>（連携用）通信先氏名（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv19 zrnyobiv19}</td><td>（連携用）予備項目Ｖ１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoukaisakidrtennm1 zrnsyoukaisakidrtennm1}</td><td>（連携用）照会先代理店名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoukaisakidrtennm2 zrnsyoukaisakidrtennm2}</td><td>（連携用）照会先代理店名２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv20 zrnyobiv20}</td><td>（連携用）予備項目Ｖ２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumsgcd1 zrnaisatumsgcd1}</td><td>（連携用）挨拶文メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumsgcd2 zrnaisatumsgcd2}</td><td>（連携用）挨拶文メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisatumsgcd3 zrnaisatumsgcd3}</td><td>（連携用）挨拶文メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasetuutisakuseiymwa zrnosirasetuutisakuseiymwa}</td><td>（連携用）お知らせ通知作成年月（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisyoumeikbn zrnaisyoumeikbn}</td><td>（連携用）愛称名区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj18 zrnkyknmkj18}</td><td>（連携用）契約者名（漢字）（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj18 zrnhhknnmkj18}</td><td>（連携用）被保険者名（漢字）（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn1 zrnuktmidasikbn1}</td><td>（連携用）受取人見出し区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn1 zrnuktkbn1}</td><td>（連携用）受取人区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm118 zrnuktnm118}</td><td>（連携用）受取人名１（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn2 zrnuktmidasikbn2}</td><td>（連携用）受取人見出し区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn2 zrnuktkbn2}</td><td>（連携用）受取人区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm218 zrnuktnm218}</td><td>（連携用）受取人名２（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn3 zrnuktmidasikbn3}</td><td>（連携用）受取人見出し区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn3 zrnuktkbn3}</td><td>（連携用）受取人区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm318 zrnuktnm318}</td><td>（連携用）受取人名３（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn4 zrnuktmidasikbn4}</td><td>（連携用）受取人見出し区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn4 zrnuktkbn4}</td><td>（連携用）受取人区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm418 zrnuktnm418}</td><td>（連携用）受取人名４（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn5 zrnuktmidasikbn5}</td><td>（連携用）受取人見出し区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn5 zrnuktkbn5}</td><td>（連携用）受取人区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm518 zrnuktnm518}</td><td>（連携用）受取人名５（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymdwa zrnkykymdwa}</td><td>（連携用）契約年月日（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1hknkknfromwa zrndai1hknkknfromwa}</td><td>（連携用）第１保険期間至（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hknkknfromwa zrndai2hknkknfromwa}</td><td>（連携用）第２保険期間自（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hknkkntowa zrndai2hknkkntowa}</td><td>（連携用）第２保険期間至（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai3hknkknfromwa zrndai3hknkknfromwa}</td><td>（連携用）第３保険期間自（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai3hknkknto zrndai3hknkknto}</td><td>（連携用）第３保険期間至</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktuukasyuzn zrnkyktuukasyuzn}</td><td>（連携用）契約通貨種類（全）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktuukatype zrnkyktuukatype}</td><td>（連携用）契約通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntk1msgcd zrntk1msgcd}</td><td>（連携用）特約１メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntk2msgcd zrntk2msgcd}</td><td>（連携用）特約２メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntk3msgcd zrntk3msgcd}</td><td>（連携用）特約３メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntk4msgcd zrntk4msgcd}</td><td>（連携用）特約４メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntk5msgcd zrntk5msgcd}</td><td>（連携用）特約５メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntk6msgcd zrntk6msgcd}</td><td>（連携用）特約６メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntk7msgcd zrntk7msgcd}</td><td>（連携用）特約７メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntk8msgcd zrntk8msgcd}</td><td>（連携用）特約８メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntk9msgcd zrntk9msgcd}</td><td>（連携用）特約９メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntk10msgcd zrntk10msgcd}</td><td>（連携用）特約１０メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndstourokujyou zrndstourokujyou}</td><td>（連携用）ＤＳ登録状況</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsd1msgcd zrnsd1msgcd}</td><td>（連携用）スミセイダイレクト１メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsd2msgcd zrnsd2msgcd}</td><td>（連携用）スミセイダイレクト２メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsd3msgcd zrnsd3msgcd}</td><td>（連携用）スミセイダイレクト３メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkrpassword zrnkrpassword}</td><td>（連携用）仮パスワード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyuukoukigenwareki zrnyuukoukigenwareki}</td><td>（連携用）有効期限（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktrkjk zrnkzktrkjk}</td><td>（連携用）家族登録状況</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzknm118 zrntrkkzknm118}</td><td>（連携用）登録家族名１（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzknm218 zrntrkkzknm218}</td><td>（連携用）登録家族名２（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyendthnkymd zrnyendthnkymd}</td><td>（連携用）円建変更日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrstartymdstr zrnnkshrstartymdstr}</td><td>（連携用）年金支払開始日（文字列）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinstartnen zrnnenkinstartnen}</td><td>（連携用）年金開始年齢</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruinm zrnnksyuruinm}</td><td>（連携用）年金種類名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuu zrnhrkkaisuu}</td><td>（連携用）払込回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntikiktbrisyuruikbn zrntikiktbrisyuruikbn}</td><td>（連携用）定期一括払種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennouumu zrnzennouumu}</td><td>（連携用）前納有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeiro zrnhrkkeiro}</td><td>（連携用）払込経路</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkkn zrnphrkkkn}</td><td>（連携用）保険料払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsueokikkn zrnsueokikkn}</td><td>（連携用）据置期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakkanbunsyono zrnyakkanbunsyono}</td><td>（連携用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngkykniyuosiraseyobi zrngkykniyuosiraseyobi}</td><td>（連携用）ご契約内容お知らせ予備項目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseikijyunymdwa zrnsakuseikijyunymdwa}</td><td>（連携用）作成基準日（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibrpkyktuuka zrnitijibrpkyktuuka}</td><td>（連携用）一時払保険料（契約通貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonsktuuka zrnkihonsktuuka}</td><td>（連携用）基本保険金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgk zrnyenhrkgk}</td><td>（連携用）円貨払込額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstigituukahrkgk zrnstigituukahrkgk}</td><td>（連携用）指定外通貨払込額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrktuukasyuzn zrnhrktuukasyuzn}</td><td>（連携用）払込通貨種類（全）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrktuukatype zrnhrktuukatype}</td><td>（連携用）払込通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenkhrikmrate zrnyenkhrikmrate}</td><td>（連携用）円貨払込特約レート</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstigikwsrate zrnstigikwsrate}</td><td>（連携用）指定外通貨払込特約レート</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkgkhyoujikbn zrnhrkgkhyoujikbn}</td><td>（連携用）払込額表示区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkijyunkingaku zrnkijyunkingaku}</td><td>（連携用）基準金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjnkngkkawaserate zrnkjnkngkkawaserate}</td><td>（連携用）基準金額為替レート</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjnkngkhyoujikbn zrnkjnkngkhyoujikbn}</td><td>（連携用）基準金額表示区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseikijyunymdkwsrate zrnsakuseikijyunymdkwsrate}</td><td>（連携用）作成基準日時点為替レート</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbhknkngkhknkkn zrnsbhknkngkhknkkn}</td><td>（連携用）死亡保険金額保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbhknkngkhknkknfromwa zrnsbhknkngkhknkknfromwa}</td><td>（連携用）死亡保険金額保険期間自（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbhknkngkhknkkntowa zrnsbhknkngkhknkkntowa}</td><td>（連携用）死亡保険金額保険期間至（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbhknkngkkyktuuka zrnsbhknkngkkyktuuka}</td><td>（連携用）死亡保険金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbhknkngkyen zrnsbhknkngkyen}</td><td>（連携用）死亡保険金額（円貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaigaisbhknkngakuumu zrnsaigaisbhknkngakuumu}</td><td>（連携用）災害死亡保険金額表示有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaigaisbhknkngakuktuuka zrnsaigaisbhknkngakuktuuka}</td><td>（連携用）災害死亡保険金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaigaisbhknkngakukyen zrnsaigaisbhknkngakukyen}</td><td>（連携用）災害死亡保険金額（円貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitatekngkktuuka zrntumitatekngkktuuka}</td><td>（連携用）保険料積立金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitatekngkkyen zrntumitatekngkkyen}</td><td>（連携用）保険料積立金額（円貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuhrkngakkyktuuka zrnkaiyakuhrkngakkyktuuka}</td><td>（連携用）解約返戻金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiyakuhrkngakyen zrnkaiyakuhrkngakyen}</td><td>（連携用）解約返戻金額（円貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhgkyen zrnmkhgkyen}</td><td>（連携用）目標額（円貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhgkwari zrnmkhgkwari}</td><td>（連携用）目標額割合</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhgkhyoujikbn zrnmkhgkhyoujikbn}</td><td>（連携用）目標額表示区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouhskmsgcd1 zrnhosyouhskmsgcd1}</td><td>（連携用）保障内容補足メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouhskmsgcd2 zrnhosyouhskmsgcd2}</td><td>（連携用）保障内容補足メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouhskmsgcd3 zrnhosyouhskmsgcd3}</td><td>（連携用）保障内容補足メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouhskmsgcd4 zrnhosyouhskmsgcd4}</td><td>（連携用）保障内容補足メッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouhskmsgcd5 zrnhosyouhskmsgcd5}</td><td>（連携用）保障内容補足メッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouhskmsgcd6 zrnhosyouhskmsgcd6}</td><td>（連携用）保障内容補足メッセージコード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouhskmsgcd7 zrnhosyouhskmsgcd7}</td><td>（連携用）保障内容補足メッセージコード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouhskmsgcd8 zrnhosyouhskmsgcd8}</td><td>（連携用）保障内容補足メッセージコード８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyouhskmsgcd9 zrnhosyouhskmsgcd9}</td><td>（連携用）保障内容補足メッセージコード９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonsyen zrnkihonsyen}</td><td>（連携用）基本保険金額（円貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteirirituv4 zrnyoteirirituv4}</td><td>（連携用）予定利率（４桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyendthnkhrkngakyen zrnyendthnkhrkngakyen}</td><td>（連携用）円建変更時返戻金額（円貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmtthaitoukinzndkyen zrntmtthaitoukinzndkyen}</td><td>（連携用）積立配当金残高（円貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkgnsgkkyktuuka zrnnkgnsgkkyktuuka}</td><td>（連携用）年金原資額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsbhknkngkhyoujikbn zrnsbhknkngkhyoujikbn}</td><td>（連携用）死亡保険金額表示区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkijyunkingakukyktuuka zrnkijyunkingakukyktuuka}</td><td>（連携用）基準金額（契約通貨）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkiktnkgk zrnyenhrkgkiktnkgk}</td><td>（連携用）円貨払込額（一括入金額）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzennoutikiktyenhrkgkkykj zrnzennoutikiktyenhrkgkkykj}</td><td>（連携用）前納定期一括払円貨払込額（契約時）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiyakusiharaigk zrnkaiyakusiharaigk}</td><td>（連携用）解約時支払額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiyakusiharaigkznnuzndk zrnkaiyakusiharaigkznnuzndk}</td><td>（連携用）解約時支払額（前納残高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaiyakusiharaigksntshrgk zrnkaiyakusiharaigksntshrgk}</td><td>（連携用）解約時支払額（その他支払金額）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukei zrnyenhrkgkgoukei}</td><td>（連携用）円貨払込額の合計額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrritu zrnhrritu}</td><td>（連携用）返戻率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkgnsyensyourai zrnnkgnsyensyourai}</td><td>（連携用）年金原資（円貨）（将来予想金額）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkgnsgaikasyourai zrnnkgnsgaikasyourai}</td><td>（連携用）年金原資（契約通貨）（将来予想金額）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenhrkgkgoukeisyourai zrnyenhrkgkgoukeisyourai}</td><td>（連携用）円貨払込額の合計額（将来予想金額）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrritusyourai zrnhrritusyourai}</td><td>（連携用）返戻率（将来予想金額）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkgnshskmsgcd1 zrnnkgnshskmsgcd1}</td><td>（連携用）年金原資試算補足メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkgnshskmsgcd2 zrnnkgnshskmsgcd2}</td><td>（連携用）年金原資試算補足メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkgnshskmsgcd3 zrnnkgnshskmsgcd3}</td><td>（連携用）年金原資試算補足メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkgnshskmsgcd4 zrnnkgnshskmsgcd4}</td><td>（連携用）年金原資試算補足メッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkgnshskmsgcd5 zrnnkgnshskmsgcd5}</td><td>（連携用）年金原資試算補足メッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyounaiyouyobi zrnhosyounaiyouyobi}</td><td>（連携用）保障内容予備項目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunymd1maewa zrnkwsratekijyunymd1maewa}</td><td>（連携用）為替レート基準日１ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateusdjpy1mae zrnkwsrateusdjpy1mae}</td><td>（連携用）為替レート米ドル（円）１ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateaudjpy1mae zrnkwsrateaudjpy1mae}</td><td>（連携用）為替レート豪ドル（円）１ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10 zrnyobiv10}</td><td>（連携用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunymd2maewa zrnkwsratekijyunymd2maewa}</td><td>（連携用）為替レート基準日２ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateusdjpy2mae zrnkwsrateusdjpy2mae}</td><td>（連携用）為替レート米ドル（円）２ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateaudjpy2mae zrnkwsrateaudjpy2mae}</td><td>（連携用）為替レート豪ドル（円）２ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x2 zrnyobiv10x2}</td><td>（連携用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunymd3maewa zrnkwsratekijyunymd3maewa}</td><td>（連携用）為替レート基準日３ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateusdjpy3mae zrnkwsrateusdjpy3mae}</td><td>（連携用）為替レート米ドル（円）３ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateaudjpy3mae zrnkwsrateaudjpy3mae}</td><td>（連携用）為替レート豪ドル（円）３ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x3 zrnyobiv10x3}</td><td>（連携用）予備項目Ｖ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunymd4maewa zrnkwsratekijyunymd4maewa}</td><td>（連携用）為替レート基準日４ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateusdjpy4mae zrnkwsrateusdjpy4mae}</td><td>（連携用）為替レート米ドル（円）４ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateaudjpy4mae zrnkwsrateaudjpy4mae}</td><td>（連携用）為替レート豪ドル（円）４ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x4 zrnyobiv10x4}</td><td>（連携用）予備項目Ｖ１０＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunymd5maewa zrnkwsratekijyunymd5maewa}</td><td>（連携用）為替レート基準日５ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateusdjpy5mae zrnkwsrateusdjpy5mae}</td><td>（連携用）為替レート米ドル（円）５ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateaudjpy5mae zrnkwsrateaudjpy5mae}</td><td>（連携用）為替レート豪ドル（円）５ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x5 zrnyobiv10x5}</td><td>（連携用）予備項目Ｖ１０＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunymd6maewa zrnkwsratekijyunymd6maewa}</td><td>（連携用）為替レート基準日６ヶ月前（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateusdjpy6mae zrnkwsrateusdjpy6mae}</td><td>（連携用）為替レート米ドル（円）６ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsrateaudjpy6mae zrnkwsrateaudjpy6mae}</td><td>（連携用）為替レート豪ドル（円）６ヶ月前</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x6 zrnyobiv10x6}</td><td>（連携用）予備項目Ｖ１０＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratemsgcd zrnkwsratemsgcd}</td><td>（連携用）為替レートメッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv23 zrnyobiv23}</td><td>（連携用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemsgcd1 zrnosirasemsgcd1}</td><td>（連携用）お知らせメッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemsgcd2 zrnosirasemsgcd2}</td><td>（連携用）お知らせメッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemsgcd3 zrnosirasemsgcd3}</td><td>（連携用）お知らせメッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemsgcd4 zrnosirasemsgcd4}</td><td>（連携用）お知らせメッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemsgcd5 zrnosirasemsgcd5}</td><td>（連携用）お知らせメッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv15 zrnyobiv15}</td><td>（連携用）予備項目Ｖ１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetteibairitustr zrnsetteibairitustr}</td><td>（連携用）設定倍率（文字列）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzkrtjygnstr zrntmttknzkrtjygnstr}</td><td>（連携用）積立金増加率上限（文字列）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzkrtkgnstr zrntmttknzkrtkgnstr}</td><td>（連携用）積立金増加率下限（文字列）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitateriritustr zrntumitateriritustr}</td><td>（連携用）積立利率（文字列）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuunm zrnsisuunm}</td><td>（連携用）指数名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx1 zrntmttknsuiirirekikbnx1}</td><td>（連携用）積立金推移履歴区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix1 zrnkeiyakuoutoubix1}</td><td>（連携用）契約応当日＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix1 zrntmttknjyoutaix1}</td><td>（連携用）積立金状態＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax1 zrnptumitatekngkktuukax1}</td><td>（連携用）保険料積立金額（契約通貨）＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx1 zrnptumitatekngkyenx1}</td><td>（連携用）保険料積立金額（円貨）＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux1 zrnsisuux1}</td><td>（連携用）指数＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux1 zrnsisuuuprituhugoux1}</td><td>（連携用）指数上昇率符号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux1 zrnsisuuupritux1}</td><td>（連携用）指数上昇率＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx1 zrntmttknzoukaritustrx1}</td><td>（連携用）積立金増加率（文字列）＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex1 zrnkawaseratex1}</td><td>（連携用）為替レート＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx2 zrntmttknsuiirirekikbnx2}</td><td>（連携用）積立金推移履歴区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix2 zrnkeiyakuoutoubix2}</td><td>（連携用）契約応当日＿２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix2 zrntmttknjyoutaix2}</td><td>（連携用）積立金状態＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax2 zrnptumitatekngkktuukax2}</td><td>（連携用）保険料積立金額（契約通貨）＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx2 zrnptumitatekngkyenx2}</td><td>（連携用）保険料積立金額（円貨）＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux2 zrnsisuux2}</td><td>（連携用）指数＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux2 zrnsisuuuprituhugoux2}</td><td>（連携用）指数上昇率符号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux2 zrnsisuuupritux2}</td><td>（連携用）指数上昇率＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx2 zrntmttknzoukaritustrx2}</td><td>（連携用）積立金増加率（文字列）＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex2 zrnkawaseratex2}</td><td>（連携用）為替レート＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx3 zrntmttknsuiirirekikbnx3}</td><td>（連携用）積立金推移履歴区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix3 zrnkeiyakuoutoubix3}</td><td>（連携用）契約応当日＿３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix3 zrntmttknjyoutaix3}</td><td>（連携用）積立金状態＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax3 zrnptumitatekngkktuukax3}</td><td>（連携用）保険料積立金額（契約通貨）＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx3 zrnptumitatekngkyenx3}</td><td>（連携用）保険料積立金額（円貨）＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux3 zrnsisuux3}</td><td>（連携用）指数＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux3 zrnsisuuuprituhugoux3}</td><td>（連携用）指数上昇率符号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux3 zrnsisuuupritux3}</td><td>（連携用）指数上昇率＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx3 zrntmttknzoukaritustrx3}</td><td>（連携用）積立金増加率（文字列）＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex3 zrnkawaseratex3}</td><td>（連携用）為替レート＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx4 zrntmttknsuiirirekikbnx4}</td><td>（連携用）積立金推移履歴区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix4 zrnkeiyakuoutoubix4}</td><td>（連携用）契約応当日＿４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix4 zrntmttknjyoutaix4}</td><td>（連携用）積立金状態＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax4 zrnptumitatekngkktuukax4}</td><td>（連携用）保険料積立金額（契約通貨）＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx4 zrnptumitatekngkyenx4}</td><td>（連携用）保険料積立金額（円貨）＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux4 zrnsisuux4}</td><td>（連携用）指数＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux4 zrnsisuuuprituhugoux4}</td><td>（連携用）指数上昇率符号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux4 zrnsisuuupritux4}</td><td>（連携用）指数上昇率＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx4 zrntmttknzoukaritustrx4}</td><td>（連携用）積立金増加率（文字列）＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex4 zrnkawaseratex4}</td><td>（連携用）為替レート＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx5 zrntmttknsuiirirekikbnx5}</td><td>（連携用）積立金推移履歴区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix5 zrnkeiyakuoutoubix5}</td><td>（連携用）契約応当日＿５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix5 zrntmttknjyoutaix5}</td><td>（連携用）積立金状態＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax5 zrnptumitatekngkktuukax5}</td><td>（連携用）保険料積立金額（契約通貨）＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx5 zrnptumitatekngkyenx5}</td><td>（連携用）保険料積立金額（円貨）＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux5 zrnsisuux5}</td><td>（連携用）指数＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux5 zrnsisuuuprituhugoux5}</td><td>（連携用）指数上昇率符号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux5 zrnsisuuupritux5}</td><td>（連携用）指数上昇率＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx5 zrntmttknzoukaritustrx5}</td><td>（連携用）積立金増加率（文字列）＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex5 zrnkawaseratex5}</td><td>（連携用）為替レート＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx6 zrntmttknsuiirirekikbnx6}</td><td>（連携用）積立金推移履歴区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix6 zrnkeiyakuoutoubix6}</td><td>（連携用）契約応当日＿６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix6 zrntmttknjyoutaix6}</td><td>（連携用）積立金状態＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax6 zrnptumitatekngkktuukax6}</td><td>（連携用）保険料積立金額（契約通貨）＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx6 zrnptumitatekngkyenx6}</td><td>（連携用）保険料積立金額（円貨）＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux6 zrnsisuux6}</td><td>（連携用）指数＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux6 zrnsisuuuprituhugoux6}</td><td>（連携用）指数上昇率符号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux6 zrnsisuuupritux6}</td><td>（連携用）指数上昇率＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx6 zrntmttknzoukaritustrx6}</td><td>（連携用）積立金増加率（文字列）＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex6 zrnkawaseratex6}</td><td>（連携用）為替レート＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx7 zrntmttknsuiirirekikbnx7}</td><td>（連携用）積立金推移履歴区分＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix7 zrnkeiyakuoutoubix7}</td><td>（連携用）契約応当日＿７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix7 zrntmttknjyoutaix7}</td><td>（連携用）積立金状態＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax7 zrnptumitatekngkktuukax7}</td><td>（連携用）保険料積立金額（契約通貨）＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx7 zrnptumitatekngkyenx7}</td><td>（連携用）保険料積立金額（円貨）＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux7 zrnsisuux7}</td><td>（連携用）指数＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux7 zrnsisuuuprituhugoux7}</td><td>（連携用）指数上昇率符号＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux7 zrnsisuuupritux7}</td><td>（連携用）指数上昇率＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx7 zrntmttknzoukaritustrx7}</td><td>（連携用）積立金増加率（文字列）＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex7 zrnkawaseratex7}</td><td>（連携用）為替レート＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx8 zrntmttknsuiirirekikbnx8}</td><td>（連携用）積立金推移履歴区分＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix8 zrnkeiyakuoutoubix8}</td><td>（連携用）契約応当日＿８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix8 zrntmttknjyoutaix8}</td><td>（連携用）積立金状態＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax8 zrnptumitatekngkktuukax8}</td><td>（連携用）保険料積立金額（契約通貨）＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx8 zrnptumitatekngkyenx8}</td><td>（連携用）保険料積立金額（円貨）＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux8 zrnsisuux8}</td><td>（連携用）指数＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux8 zrnsisuuuprituhugoux8}</td><td>（連携用）指数上昇率符号＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux8 zrnsisuuupritux8}</td><td>（連携用）指数上昇率＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx8 zrntmttknzoukaritustrx8}</td><td>（連携用）積立金増加率（文字列）＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex8 zrnkawaseratex8}</td><td>（連携用）為替レート＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx9 zrntmttknsuiirirekikbnx9}</td><td>（連携用）積立金推移履歴区分＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix9 zrnkeiyakuoutoubix9}</td><td>（連携用）契約応当日＿９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix9 zrntmttknjyoutaix9}</td><td>（連携用）積立金状態＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax9 zrnptumitatekngkktuukax9}</td><td>（連携用）保険料積立金額（契約通貨）＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx9 zrnptumitatekngkyenx9}</td><td>（連携用）保険料積立金額（円貨）＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux9 zrnsisuux9}</td><td>（連携用）指数＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux9 zrnsisuuuprituhugoux9}</td><td>（連携用）指数上昇率符号＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux9 zrnsisuuupritux9}</td><td>（連携用）指数上昇率＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx9 zrntmttknzoukaritustrx9}</td><td>（連携用）積立金増加率（文字列）＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex9 zrnkawaseratex9}</td><td>（連携用）為替レート＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx10 zrntmttknsuiirirekikbnx10}</td><td>（連携用）積立金推移履歴区分＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix10 zrnkeiyakuoutoubix10}</td><td>（連携用）契約応当日＿１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix10 zrntmttknjyoutaix10}</td><td>（連携用）積立金状態＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax10 zrnptumitatekngkktuukax10}</td><td>（連携用）保険料積立金額（契約通貨）＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx10 zrnptumitatekngkyenx10}</td><td>（連携用）保険料積立金額（円貨）＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux10 zrnsisuux10}</td><td>（連携用）指数＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux10 zrnsisuuuprituhugoux10}</td><td>（連携用）指数上昇率符号＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux10 zrnsisuuupritux10}</td><td>（連携用）指数上昇率＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx10 zrntmttknzoukaritustrx10}</td><td>（連携用）積立金増加率（文字列）＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex10 zrnkawaseratex10}</td><td>（連携用）為替レート＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiirirekikbnx11 zrntmttknsuiirirekikbnx11}</td><td>（連携用）積立金推移履歴区分＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakuoutoubix11 zrnkeiyakuoutoubix11}</td><td>（連携用）契約応当日＿１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknjyoutaix11 zrntmttknjyoutaix11}</td><td>（連携用）積立金状態＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkktuukax11 zrnptumitatekngkktuukax11}</td><td>（連携用）保険料積立金額（契約通貨）＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptumitatekngkyenx11 zrnptumitatekngkyenx11}</td><td>（連携用）保険料積立金額（円貨）＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuux11 zrnsisuux11}</td><td>（連携用）指数＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuuprituhugoux11 zrnsisuuuprituhugoux11}</td><td>（連携用）指数上昇率符号＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuupritux11 zrnsisuuupritux11}</td><td>（連携用）指数上昇率＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritustrx11 zrntmttknzoukaritustrx11}</td><td>（連携用）積立金増加率（文字列）＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaseratex11 zrnkawaseratex11}</td><td>（連携用）為替レート＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknsuiiyobi zrntmttknsuiiyobi}</td><td>（連携用）積立金推移予備項目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdkkigen zrnttdkkigen}</td><td>（連携用）お手続き期限</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkrnkgnsgk zrnkrnkgnsgk}</td><td>（連携用）仮年金原資額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntirtitnttdkyobi zrntirtitnttdkyobi}</td><td>（連携用）定率移転の手続き予備項目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskshozonnensuu zrnskshozonnensuu}</td><td>（連携用）請求書保存年数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndocumentid zrndocumentid}</td><td>（連携用）ドキュメントＩＤ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoritugisyasyozokunm zrntoritugisyasyozokunm}</td><td>（連携用）取次者所属名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyendthnkhrsksyobi zrnyendthnkhrsksyobi}</td><td>（連携用）円建変更時返戻金請求書予備項目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym1 zrnyoteiriritukijyunym1}</td><td>（連携用）予定利率基準年月＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu1 zrnyoteiriritu1}</td><td>（連携用）予定利率＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt1 zrnytirrtcalckijyunrrt1}</td><td>（連携用）予定利率計算基準利率＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym1 zrnkwsratekijyunym1}</td><td>（連携用）為替レート基準年月＿１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate1 zrnkaknsnkwsrate1}</td><td>（連携用）換算為替レート＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika1 zrnpgaika1}</td><td>（連携用）保険料（契約通貨）＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen1 zrnpyen1}</td><td>（連携用）保険料（円貨）＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym2 zrnyoteiriritukijyunym2}</td><td>（連携用）予定利率基準年月＿２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu2 zrnyoteiriritu2}</td><td>（連携用）予定利率＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt2 zrnytirrtcalckijyunrrt2}</td><td>（連携用）予定利率計算基準利率＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym2 zrnkwsratekijyunym2}</td><td>（連携用）為替レート基準年月＿２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate2 zrnkaknsnkwsrate2}</td><td>（連携用）換算為替レート＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika2 zrnpgaika2}</td><td>（連携用）保険料（契約通貨）＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen2 zrnpyen2}</td><td>（連携用）保険料（円貨）＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym3 zrnyoteiriritukijyunym3}</td><td>（連携用）予定利率基準年月＿３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu3 zrnyoteiriritu3}</td><td>（連携用）予定利率＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt3 zrnytirrtcalckijyunrrt3}</td><td>（連携用）予定利率計算基準利率＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym3 zrnkwsratekijyunym3}</td><td>（連携用）為替レート基準年月＿３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate3 zrnkaknsnkwsrate3}</td><td>（連携用）換算為替レート＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika3 zrnpgaika3}</td><td>（連携用）保険料（契約通貨）＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen3 zrnpyen3}</td><td>（連携用）保険料（円貨）＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym4 zrnyoteiriritukijyunym4}</td><td>（連携用）予定利率基準年月＿４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu4 zrnyoteiriritu4}</td><td>（連携用）予定利率＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt4 zrnytirrtcalckijyunrrt4}</td><td>（連携用）予定利率計算基準利率＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym4 zrnkwsratekijyunym4}</td><td>（連携用）為替レート基準年月＿４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate4 zrnkaknsnkwsrate4}</td><td>（連携用）換算為替レート＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika4 zrnpgaika4}</td><td>（連携用）保険料（契約通貨）＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen4 zrnpyen4}</td><td>（連携用）保険料（円貨）＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym5 zrnyoteiriritukijyunym5}</td><td>（連携用）予定利率基準年月＿５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu5 zrnyoteiriritu5}</td><td>（連携用）予定利率＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt5 zrnytirrtcalckijyunrrt5}</td><td>（連携用）予定利率計算基準利率＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym5 zrnkwsratekijyunym5}</td><td>（連携用）為替レート基準年月＿５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate5 zrnkaknsnkwsrate5}</td><td>（連携用）換算為替レート＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika5 zrnpgaika5}</td><td>（連携用）保険料（契約通貨）＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen5 zrnpyen5}</td><td>（連携用）保険料（円貨）＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym6 zrnyoteiriritukijyunym6}</td><td>（連携用）予定利率基準年月＿６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu6 zrnyoteiriritu6}</td><td>（連携用）予定利率＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt6 zrnytirrtcalckijyunrrt6}</td><td>（連携用）予定利率計算基準利率＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym6 zrnkwsratekijyunym6}</td><td>（連携用）為替レート基準年月＿６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate6 zrnkaknsnkwsrate6}</td><td>（連携用）換算為替レート＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika6 zrnpgaika6}</td><td>（連携用）保険料（契約通貨）＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen6 zrnpyen6}</td><td>（連携用）保険料（円貨）＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym7 zrnyoteiriritukijyunym7}</td><td>（連携用）予定利率基準年月＿７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu7 zrnyoteiriritu7}</td><td>（連携用）予定利率＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt7 zrnytirrtcalckijyunrrt7}</td><td>（連携用）予定利率計算基準利率＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym7 zrnkwsratekijyunym7}</td><td>（連携用）為替レート基準年月＿７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate7 zrnkaknsnkwsrate7}</td><td>（連携用）換算為替レート＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika7 zrnpgaika7}</td><td>（連携用）保険料（契約通貨）＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen7 zrnpyen7}</td><td>（連携用）保険料（円貨）＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym8 zrnyoteiriritukijyunym8}</td><td>（連携用）予定利率基準年月＿８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu8 zrnyoteiriritu8}</td><td>（連携用）予定利率＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt8 zrnytirrtcalckijyunrrt8}</td><td>（連携用）予定利率計算基準利率＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym8 zrnkwsratekijyunym8}</td><td>（連携用）為替レート基準年月＿８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate8 zrnkaknsnkwsrate8}</td><td>（連携用）換算為替レート＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika8 zrnpgaika8}</td><td>（連携用）保険料（契約通貨）＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen8 zrnpyen8}</td><td>（連携用）保険料（円貨）＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym9 zrnyoteiriritukijyunym9}</td><td>（連携用）予定利率基準年月＿９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu9 zrnyoteiriritu9}</td><td>（連携用）予定利率＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt9 zrnytirrtcalckijyunrrt9}</td><td>（連携用）予定利率計算基準利率＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym9 zrnkwsratekijyunym9}</td><td>（連携用）為替レート基準年月＿９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate9 zrnkaknsnkwsrate9}</td><td>（連携用）換算為替レート＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika9 zrnpgaika9}</td><td>（連携用）保険料（契約通貨）＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen9 zrnpyen9}</td><td>（連携用）保険料（円貨）＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym10 zrnyoteiriritukijyunym10}</td><td>（連携用）予定利率基準年月＿１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu10 zrnyoteiriritu10}</td><td>（連携用）予定利率＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt10 zrnytirrtcalckijyunrrt10}</td><td>（連携用）予定利率計算基準利率＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym10 zrnkwsratekijyunym10}</td><td>（連携用）為替レート基準年月＿１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate10 zrnkaknsnkwsrate10}</td><td>（連携用）換算為替レート＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika10 zrnpgaika10}</td><td>（連携用）保険料（契約通貨）＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen10 zrnpyen10}</td><td>（連携用）保険料（円貨）＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym11 zrnyoteiriritukijyunym11}</td><td>（連携用）予定利率基準年月＿１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu11 zrnyoteiriritu11}</td><td>（連携用）予定利率＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt11 zrnytirrtcalckijyunrrt11}</td><td>（連携用）予定利率計算基準利率＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym11 zrnkwsratekijyunym11}</td><td>（連携用）為替レート基準年月＿１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate11 zrnkaknsnkwsrate11}</td><td>（連携用）換算為替レート＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika11 zrnpgaika11}</td><td>（連携用）保険料（契約通貨）＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen11 zrnpyen11}</td><td>（連携用）保険料（円貨）＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritukijyunym12 zrnyoteiriritukijyunym12}</td><td>（連携用）予定利率基準年月＿１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyoteiriritu12 zrnyoteiriritu12}</td><td>（連携用）予定利率＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtcalckijyunrrt12 zrnytirrtcalckijyunrrt12}</td><td>（連携用）予定利率計算基準利率＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkwsratekijyunym12 zrnkwsratekijyunym12}</td><td>（連携用）為替レート基準年月＿１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaknsnkwsrate12 zrnkaknsnkwsrate12}</td><td>（連携用）換算為替レート＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpgaika12 zrnpgaika12}</td><td>（連携用）保険料（契約通貨）＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpyen12 zrnpyen12}</td><td>（連携用）保険料（円貨）＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn1 zrnfstphyoujikbn1}</td><td>（連携用）初回保険料表示区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn2 zrnfstphyoujikbn2}</td><td>（連携用）初回保険料表示区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn3 zrnfstphyoujikbn3}</td><td>（連携用）初回保険料表示区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn4 zrnfstphyoujikbn4}</td><td>（連携用）初回保険料表示区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn5 zrnfstphyoujikbn5}</td><td>（連携用）初回保険料表示区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn6 zrnfstphyoujikbn6}</td><td>（連携用）初回保険料表示区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn7 zrnfstphyoujikbn7}</td><td>（連携用）初回保険料表示区分＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn8 zrnfstphyoujikbn8}</td><td>（連携用）初回保険料表示区分＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn9 zrnfstphyoujikbn9}</td><td>（連携用）初回保険料表示区分＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn10 zrnfstphyoujikbn10}</td><td>（連携用）初回保険料表示区分＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn11 zrnfstphyoujikbn11}</td><td>（連携用）初回保険料表示区分＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstphyoujikbn12 zrnfstphyoujikbn12}</td><td>（連携用）初回保険料表示区分＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtitrnyobi2 zrnytirrtitrnyobi2}</td><td>（連携用）予定利率一覧予備項目２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtitrnhskmsgcd1 zrnytirrtitrnhskmsgcd1}</td><td>（連携用）予定利率一覧補足メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtitrnhskmsgcd2 zrnytirrtitrnhskmsgcd2}</td><td>（連携用）予定利率一覧補足メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtitrnhskmsgcd3 zrnytirrtitrnhskmsgcd3}</td><td>（連携用）予定利率一覧補足メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtitrnhskmsgcd4 zrnytirrtitrnhskmsgcd4}</td><td>（連携用）予定利率一覧補足メッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtitrnhskmsgcd5 zrnytirrtitrnhskmsgcd5}</td><td>（連携用）予定利率一覧補足メッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtitrnhskmsgcd6 zrnytirrtitrnhskmsgcd6}</td><td>（連携用）予定利率一覧補足メッセージコード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtitrnhskmsgcd7 zrnytirrtitrnhskmsgcd7}</td><td>（連携用）予定利率一覧補足メッセージコード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtitrnhskmsgcd8 zrnytirrtitrnhskmsgcd8}</td><td>（連携用）予定利率一覧補足メッセージコード８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnytirrtitrnyobi zrnytirrtitrnyobi}</td><td>（連携用）過去１年間の予定利率予備項目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_GaikaKokyakuTuutiRn
 * @see     PKZT_GaikaKokyakuTuutiRn
 * @see     QZT_GaikaKokyakuTuutiRn
 * @see     GenQZT_GaikaKokyakuTuutiRn
 */
@MappedSuperclass
@Table(name=GenZT_GaikaKokyakuTuutiRn.TABLE_NAME)
@IdClass(value=PKZT_GaikaKokyakuTuutiRn.class)
public abstract class GenZT_GaikaKokyakuTuutiRn extends AbstractExDBEntityForZDB<ZT_GaikaKokyakuTuutiRn, PKZT_GaikaKokyakuTuutiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_GaikaKokyakuTuutiRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNSCLATOSYONO           = "zrnsclatosyono";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNDSKAIYKTIRASIDOUHUUKBN = "zrndskaiyktirasidouhuukbn";
    public static final String ZRNHRKNKANSSIRYODOUHUUKBN = "zrnhrknkanssiryodouhuukbn";
    public static final String ZRNASSISTPLUSTIRASIDHKBN = "zrnassistplustirasidhkbn";
    public static final String ZRNKOKTUUTIREPORTLAYOUTPTN = "zrnkoktuutireportlayoutptn";
    public static final String ZRNGENGKUMU              = "zrngengkumu";
    public static final String ZRNKYTKMKYOBI1           = "zrnkytkmkyobi1";
    public static final String ZRNTUUSINSAKIYUUBINNO    = "zrntuusinsakiyuubinno";
    public static final String ZRNTSINADR1KJ            = "zrntsinadr1kj";
    public static final String ZRNTSINADR2KJ            = "zrntsinadr2kj";
    public static final String ZRNTSINADR3KJ            = "zrntsinadr3kj";
    public static final String ZRNTSINTELNO             = "zrntsintelno";
    public static final String ZRNTSINNM18              = "zrntsinnm18";
    public static final String ZRNYOBIV19               = "zrnyobiv19";
    public static final String ZRNSYOUKAISAKIDRTENNM1   = "zrnsyoukaisakidrtennm1";
    public static final String ZRNSYOUKAISAKIDRTENNM2   = "zrnsyoukaisakidrtennm2";
    public static final String ZRNYOBIV20               = "zrnyobiv20";
    public static final String ZRNAISATUMSGCD1          = "zrnaisatumsgcd1";
    public static final String ZRNAISATUMSGCD2          = "zrnaisatumsgcd2";
    public static final String ZRNAISATUMSGCD3          = "zrnaisatumsgcd3";
    public static final String ZRNOSIRASETUUTISAKUSEIYMWA = "zrnosirasetuutisakuseiymwa";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNAISYOUMEIKBN          = "zrnaisyoumeikbn";
    public static final String ZRNKYKNMKJ18             = "zrnkyknmkj18";
    public static final String ZRNHHKNNMKJ18            = "zrnhhknnmkj18";
    public static final String ZRNUKTMIDASIKBN1         = "zrnuktmidasikbn1";
    public static final String ZRNUKTKBN1               = "zrnuktkbn1";
    public static final String ZRNUKTNM118              = "zrnuktnm118";
    public static final String ZRNUKTMIDASIKBN2         = "zrnuktmidasikbn2";
    public static final String ZRNUKTKBN2               = "zrnuktkbn2";
    public static final String ZRNUKTNM218              = "zrnuktnm218";
    public static final String ZRNUKTMIDASIKBN3         = "zrnuktmidasikbn3";
    public static final String ZRNUKTKBN3               = "zrnuktkbn3";
    public static final String ZRNUKTNM318              = "zrnuktnm318";
    public static final String ZRNUKTMIDASIKBN4         = "zrnuktmidasikbn4";
    public static final String ZRNUKTKBN4               = "zrnuktkbn4";
    public static final String ZRNUKTNM418              = "zrnuktnm418";
    public static final String ZRNUKTMIDASIKBN5         = "zrnuktmidasikbn5";
    public static final String ZRNUKTKBN5               = "zrnuktkbn5";
    public static final String ZRNUKTNM518              = "zrnuktnm518";
    public static final String ZRNKYKYMDWA              = "zrnkykymdwa";
    public static final String ZRNDAI1HKNKKNFROMWA      = "zrndai1hknkknfromwa";
    public static final String ZRNDAI1HKNKKN            = "zrndai1hknkkn";
    public static final String ZRNDAI2HKNKKNFROMWA      = "zrndai2hknkknfromwa";
    public static final String ZRNDAI2HKNKKNTOWA        = "zrndai2hknkkntowa";
    public static final String ZRNDAI3HKNKKNFROMWA      = "zrndai3hknkknfromwa";
    public static final String ZRNDAI3HKNKKNTO          = "zrndai3hknkknto";
    public static final String ZRNKYKTUUKASYUZN         = "zrnkyktuukasyuzn";
    public static final String ZRNKYKTUUKATYPE          = "zrnkyktuukatype";
    public static final String ZRNTK1MSGCD              = "zrntk1msgcd";
    public static final String ZRNTK2MSGCD              = "zrntk2msgcd";
    public static final String ZRNTK3MSGCD              = "zrntk3msgcd";
    public static final String ZRNTK4MSGCD              = "zrntk4msgcd";
    public static final String ZRNTK5MSGCD              = "zrntk5msgcd";
    public static final String ZRNTK6MSGCD              = "zrntk6msgcd";
    public static final String ZRNTK7MSGCD              = "zrntk7msgcd";
    public static final String ZRNTK8MSGCD              = "zrntk8msgcd";
    public static final String ZRNTK9MSGCD              = "zrntk9msgcd";
    public static final String ZRNTK10MSGCD             = "zrntk10msgcd";
    public static final String ZRNDSTOUROKUJYOU         = "zrndstourokujyou";
    public static final String ZRNSD1MSGCD              = "zrnsd1msgcd";
    public static final String ZRNSD2MSGCD              = "zrnsd2msgcd";
    public static final String ZRNSD3MSGCD              = "zrnsd3msgcd";
    public static final String ZRNKRPASSWORD            = "zrnkrpassword";
    public static final String ZRNYUUKOUKIGENWAREKI     = "zrnyuukoukigenwareki";
    public static final String ZRNKZKTRKJK              = "zrnkzktrkjk";
    public static final String ZRNTRKKZKNM118           = "zrntrkkzknm118";
    public static final String ZRNTRKKZKNM218           = "zrntrkkzknm218";
    public static final String ZRNYENDTHNKYMD           = "zrnyendthnkymd";
    public static final String ZRNNKSHRSTARTYMDSTR      = "zrnnkshrstartymdstr";
    public static final String ZRNNENKINSTARTNEN        = "zrnnenkinstartnen";
    public static final String ZRNNKSYURUINM            = "zrnnksyuruinm";
    public static final String ZRNHRKKAISUU             = "zrnhrkkaisuu";
    public static final String ZRNTIKIKTBRISYURUIKBN    = "zrntikiktbrisyuruikbn";
    public static final String ZRNZENNOUUMU             = "zrnzennouumu";
    public static final String ZRNHRKKEIRO              = "zrnhrkkeiro";
    public static final String ZRNPHRKKKN               = "zrnphrkkkn";
    public static final String ZRNSUEOKIKKN             = "zrnsueokikkn";
    public static final String ZRNYAKKANBUNSYONO        = "zrnyakkanbunsyono";
    public static final String ZRNGKYKNIYUOSIRASEYOBI   = "zrngkykniyuosiraseyobi";
    public static final String ZRNSAKUSEIKIJYUNYMDWA    = "zrnsakuseikijyunymdwa";
    public static final String ZRNITIJIBRPKYKTUUKA      = "zrnitijibrpkyktuuka";
    public static final String ZRNKIHONSKTUUKA          = "zrnkihonsktuuka";
    public static final String ZRNYENHRKGK              = "zrnyenhrkgk";
    public static final String ZRNSTIGITUUKAHRKGK       = "zrnstigituukahrkgk";
    public static final String ZRNHRKTUUKASYUZN         = "zrnhrktuukasyuzn";
    public static final String ZRNHRKTUUKATYPE          = "zrnhrktuukatype";
    public static final String ZRNYENKHRIKMRATE         = "zrnyenkhrikmrate";
    public static final String ZRNSTIGIKWSRATE          = "zrnstigikwsrate";
    public static final String ZRNHRKGKHYOUJIKBN        = "zrnhrkgkhyoujikbn";
    public static final String ZRNKIJYUNKINGAKU         = "zrnkijyunkingaku";
    public static final String ZRNKJNKNGKKAWASERATE     = "zrnkjnkngkkawaserate";
    public static final String ZRNKJNKNGKHYOUJIKBN      = "zrnkjnkngkhyoujikbn";
    public static final String ZRNSAKUSEIKIJYUNYMDKWSRATE = "zrnsakuseikijyunymdkwsrate";
    public static final String ZRNSBHKNKNGKHKNKKN       = "zrnsbhknkngkhknkkn";
    public static final String ZRNSBHKNKNGKHKNKKNFROMWA = "zrnsbhknkngkhknkknfromwa";
    public static final String ZRNSBHKNKNGKHKNKKNTOWA   = "zrnsbhknkngkhknkkntowa";
    public static final String ZRNSBHKNKNGKKYKTUUKA     = "zrnsbhknkngkkyktuuka";
    public static final String ZRNSBHKNKNGKYEN          = "zrnsbhknkngkyen";
    public static final String ZRNSAIGAISBHKNKNGAKUUMU  = "zrnsaigaisbhknkngakuumu";
    public static final String ZRNSAIGAISBHKNKNGAKUKTUUKA = "zrnsaigaisbhknkngakuktuuka";
    public static final String ZRNSAIGAISBHKNKNGAKUKYEN = "zrnsaigaisbhknkngakukyen";
    public static final String ZRNTUMITATEKNGKKTUUKA    = "zrntumitatekngkktuuka";
    public static final String ZRNTUMITATEKNGKKYEN      = "zrntumitatekngkkyen";
    public static final String ZRNKAIYAKUHRKNGAKKYKTUUKA = "zrnkaiyakuhrkngakkyktuuka";
    public static final String ZRNKAIYAKUHRKNGAKYEN     = "zrnkaiyakuhrkngakyen";
    public static final String ZRNMKHGKYEN              = "zrnmkhgkyen";
    public static final String ZRNMKHGKWARI             = "zrnmkhgkwari";
    public static final String ZRNMKHGKHYOUJIKBN        = "zrnmkhgkhyoujikbn";
    public static final String ZRNHOSYOUHSKMSGCD1       = "zrnhosyouhskmsgcd1";
    public static final String ZRNHOSYOUHSKMSGCD2       = "zrnhosyouhskmsgcd2";
    public static final String ZRNHOSYOUHSKMSGCD3       = "zrnhosyouhskmsgcd3";
    public static final String ZRNHOSYOUHSKMSGCD4       = "zrnhosyouhskmsgcd4";
    public static final String ZRNHOSYOUHSKMSGCD5       = "zrnhosyouhskmsgcd5";
    public static final String ZRNHOSYOUHSKMSGCD6       = "zrnhosyouhskmsgcd6";
    public static final String ZRNHOSYOUHSKMSGCD7       = "zrnhosyouhskmsgcd7";
    public static final String ZRNHOSYOUHSKMSGCD8       = "zrnhosyouhskmsgcd8";
    public static final String ZRNHOSYOUHSKMSGCD9       = "zrnhosyouhskmsgcd9";
    public static final String ZRNKIHONSYEN             = "zrnkihonsyen";
    public static final String ZRNYOTEIRIRITUV4         = "zrnyoteirirituv4";
    public static final String ZRNYENDTHNKHRKNGAKYEN    = "zrnyendthnkhrkngakyen";
    public static final String ZRNTMTTHAITOUKINZNDKYEN  = "zrntmtthaitoukinzndkyen";
    public static final String ZRNNKGNSGKKYKTUUKA       = "zrnnkgnsgkkyktuuka";
    public static final String ZRNSBHKNKNGKHYOUJIKBN    = "zrnsbhknkngkhyoujikbn";
    public static final String ZRNKIJYUNKINGAKUKYKTUUKA = "zrnkijyunkingakukyktuuka";
    public static final String ZRNYENHRKGKIKTNKGK       = "zrnyenhrkgkiktnkgk";
    public static final String ZRNZENNOUTIKIKTYENHRKGKKYKJ = "zrnzennoutikiktyenhrkgkkykj";
    public static final String ZRNKAIYAKUSIHARAIGK      = "zrnkaiyakusiharaigk";
    public static final String ZRNKAIYAKUSIHARAIGKZNNUZNDK = "zrnkaiyakusiharaigkznnuzndk";
    public static final String ZRNKAIYAKUSIHARAIGKSNTSHRGK = "zrnkaiyakusiharaigksntshrgk";
    public static final String ZRNYENHRKGKGOUKEI        = "zrnyenhrkgkgoukei";
    public static final String ZRNHRRITU                = "zrnhrritu";
    public static final String ZRNNKGNSYENSYOURAI       = "zrnnkgnsyensyourai";
    public static final String ZRNNKGNSGAIKASYOURAI     = "zrnnkgnsgaikasyourai";
    public static final String ZRNYENHRKGKGOUKEISYOURAI = "zrnyenhrkgkgoukeisyourai";
    public static final String ZRNHRRITUSYOURAI         = "zrnhrritusyourai";
    public static final String ZRNNKGNSHSKMSGCD1        = "zrnnkgnshskmsgcd1";
    public static final String ZRNNKGNSHSKMSGCD2        = "zrnnkgnshskmsgcd2";
    public static final String ZRNNKGNSHSKMSGCD3        = "zrnnkgnshskmsgcd3";
    public static final String ZRNNKGNSHSKMSGCD4        = "zrnnkgnshskmsgcd4";
    public static final String ZRNNKGNSHSKMSGCD5        = "zrnnkgnshskmsgcd5";
    public static final String ZRNHOSYOUNAIYOUYOBI      = "zrnhosyounaiyouyobi";
    public static final String ZRNKWSRATEKIJYUNYMD1MAEWA = "zrnkwsratekijyunymd1maewa";
    public static final String ZRNKWSRATEUSDJPY1MAE     = "zrnkwsrateusdjpy1mae";
    public static final String ZRNKWSRATEAUDJPY1MAE     = "zrnkwsrateaudjpy1mae";
    public static final String ZRNYOBIV10               = "zrnyobiv10";
    public static final String ZRNKWSRATEKIJYUNYMD2MAEWA = "zrnkwsratekijyunymd2maewa";
    public static final String ZRNKWSRATEUSDJPY2MAE     = "zrnkwsrateusdjpy2mae";
    public static final String ZRNKWSRATEAUDJPY2MAE     = "zrnkwsrateaudjpy2mae";
    public static final String ZRNYOBIV10X2             = "zrnyobiv10x2";
    public static final String ZRNKWSRATEKIJYUNYMD3MAEWA = "zrnkwsratekijyunymd3maewa";
    public static final String ZRNKWSRATEUSDJPY3MAE     = "zrnkwsrateusdjpy3mae";
    public static final String ZRNKWSRATEAUDJPY3MAE     = "zrnkwsrateaudjpy3mae";
    public static final String ZRNYOBIV10X3             = "zrnyobiv10x3";
    public static final String ZRNKWSRATEKIJYUNYMD4MAEWA = "zrnkwsratekijyunymd4maewa";
    public static final String ZRNKWSRATEUSDJPY4MAE     = "zrnkwsrateusdjpy4mae";
    public static final String ZRNKWSRATEAUDJPY4MAE     = "zrnkwsrateaudjpy4mae";
    public static final String ZRNYOBIV10X4             = "zrnyobiv10x4";
    public static final String ZRNKWSRATEKIJYUNYMD5MAEWA = "zrnkwsratekijyunymd5maewa";
    public static final String ZRNKWSRATEUSDJPY5MAE     = "zrnkwsrateusdjpy5mae";
    public static final String ZRNKWSRATEAUDJPY5MAE     = "zrnkwsrateaudjpy5mae";
    public static final String ZRNYOBIV10X5             = "zrnyobiv10x5";
    public static final String ZRNKWSRATEKIJYUNYMD6MAEWA = "zrnkwsratekijyunymd6maewa";
    public static final String ZRNKWSRATEUSDJPY6MAE     = "zrnkwsrateusdjpy6mae";
    public static final String ZRNKWSRATEAUDJPY6MAE     = "zrnkwsrateaudjpy6mae";
    public static final String ZRNYOBIV10X6             = "zrnyobiv10x6";
    public static final String ZRNKWSRATEMSGCD          = "zrnkwsratemsgcd";
    public static final String ZRNYOBIV23               = "zrnyobiv23";
    public static final String ZRNOSIRASEMSGCD1         = "zrnosirasemsgcd1";
    public static final String ZRNOSIRASEMSGCD2         = "zrnosirasemsgcd2";
    public static final String ZRNOSIRASEMSGCD3         = "zrnosirasemsgcd3";
    public static final String ZRNOSIRASEMSGCD4         = "zrnosirasemsgcd4";
    public static final String ZRNOSIRASEMSGCD5         = "zrnosirasemsgcd5";
    public static final String ZRNYOBIV15               = "zrnyobiv15";
    public static final String ZRNSETTEIBAIRITUSTR      = "zrnsetteibairitustr";
    public static final String ZRNTMTTKNZKRTJYGNSTR     = "zrntmttknzkrtjygnstr";
    public static final String ZRNTMTTKNZKRTKGNSTR      = "zrntmttknzkrtkgnstr";
    public static final String ZRNTUMITATERIRITUSTR     = "zrntumitateriritustr";
    public static final String ZRNSISUUNM               = "zrnsisuunm";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX1 = "zrntmttknsuiirirekikbnx1";
    public static final String ZRNKEIYAKUOUTOUBIX1      = "zrnkeiyakuoutoubix1";
    public static final String ZRNTMTTKNJYOUTAIX1       = "zrntmttknjyoutaix1";
    public static final String ZRNPTUMITATEKNGKKTUUKAX1 = "zrnptumitatekngkktuukax1";
    public static final String ZRNPTUMITATEKNGKYENX1    = "zrnptumitatekngkyenx1";
    public static final String ZRNSISUUX1               = "zrnsisuux1";
    public static final String ZRNSISUUUPRITUHUGOUX1    = "zrnsisuuuprituhugoux1";
    public static final String ZRNSISUUUPRITUX1         = "zrnsisuuupritux1";
    public static final String ZRNTMTTKNZOUKARITUSTRX1  = "zrntmttknzoukaritustrx1";
    public static final String ZRNKAWASERATEX1          = "zrnkawaseratex1";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX2 = "zrntmttknsuiirirekikbnx2";
    public static final String ZRNKEIYAKUOUTOUBIX2      = "zrnkeiyakuoutoubix2";
    public static final String ZRNTMTTKNJYOUTAIX2       = "zrntmttknjyoutaix2";
    public static final String ZRNPTUMITATEKNGKKTUUKAX2 = "zrnptumitatekngkktuukax2";
    public static final String ZRNPTUMITATEKNGKYENX2    = "zrnptumitatekngkyenx2";
    public static final String ZRNSISUUX2               = "zrnsisuux2";
    public static final String ZRNSISUUUPRITUHUGOUX2    = "zrnsisuuuprituhugoux2";
    public static final String ZRNSISUUUPRITUX2         = "zrnsisuuupritux2";
    public static final String ZRNTMTTKNZOUKARITUSTRX2  = "zrntmttknzoukaritustrx2";
    public static final String ZRNKAWASERATEX2          = "zrnkawaseratex2";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX3 = "zrntmttknsuiirirekikbnx3";
    public static final String ZRNKEIYAKUOUTOUBIX3      = "zrnkeiyakuoutoubix3";
    public static final String ZRNTMTTKNJYOUTAIX3       = "zrntmttknjyoutaix3";
    public static final String ZRNPTUMITATEKNGKKTUUKAX3 = "zrnptumitatekngkktuukax3";
    public static final String ZRNPTUMITATEKNGKYENX3    = "zrnptumitatekngkyenx3";
    public static final String ZRNSISUUX3               = "zrnsisuux3";
    public static final String ZRNSISUUUPRITUHUGOUX3    = "zrnsisuuuprituhugoux3";
    public static final String ZRNSISUUUPRITUX3         = "zrnsisuuupritux3";
    public static final String ZRNTMTTKNZOUKARITUSTRX3  = "zrntmttknzoukaritustrx3";
    public static final String ZRNKAWASERATEX3          = "zrnkawaseratex3";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX4 = "zrntmttknsuiirirekikbnx4";
    public static final String ZRNKEIYAKUOUTOUBIX4      = "zrnkeiyakuoutoubix4";
    public static final String ZRNTMTTKNJYOUTAIX4       = "zrntmttknjyoutaix4";
    public static final String ZRNPTUMITATEKNGKKTUUKAX4 = "zrnptumitatekngkktuukax4";
    public static final String ZRNPTUMITATEKNGKYENX4    = "zrnptumitatekngkyenx4";
    public static final String ZRNSISUUX4               = "zrnsisuux4";
    public static final String ZRNSISUUUPRITUHUGOUX4    = "zrnsisuuuprituhugoux4";
    public static final String ZRNSISUUUPRITUX4         = "zrnsisuuupritux4";
    public static final String ZRNTMTTKNZOUKARITUSTRX4  = "zrntmttknzoukaritustrx4";
    public static final String ZRNKAWASERATEX4          = "zrnkawaseratex4";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX5 = "zrntmttknsuiirirekikbnx5";
    public static final String ZRNKEIYAKUOUTOUBIX5      = "zrnkeiyakuoutoubix5";
    public static final String ZRNTMTTKNJYOUTAIX5       = "zrntmttknjyoutaix5";
    public static final String ZRNPTUMITATEKNGKKTUUKAX5 = "zrnptumitatekngkktuukax5";
    public static final String ZRNPTUMITATEKNGKYENX5    = "zrnptumitatekngkyenx5";
    public static final String ZRNSISUUX5               = "zrnsisuux5";
    public static final String ZRNSISUUUPRITUHUGOUX5    = "zrnsisuuuprituhugoux5";
    public static final String ZRNSISUUUPRITUX5         = "zrnsisuuupritux5";
    public static final String ZRNTMTTKNZOUKARITUSTRX5  = "zrntmttknzoukaritustrx5";
    public static final String ZRNKAWASERATEX5          = "zrnkawaseratex5";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX6 = "zrntmttknsuiirirekikbnx6";
    public static final String ZRNKEIYAKUOUTOUBIX6      = "zrnkeiyakuoutoubix6";
    public static final String ZRNTMTTKNJYOUTAIX6       = "zrntmttknjyoutaix6";
    public static final String ZRNPTUMITATEKNGKKTUUKAX6 = "zrnptumitatekngkktuukax6";
    public static final String ZRNPTUMITATEKNGKYENX6    = "zrnptumitatekngkyenx6";
    public static final String ZRNSISUUX6               = "zrnsisuux6";
    public static final String ZRNSISUUUPRITUHUGOUX6    = "zrnsisuuuprituhugoux6";
    public static final String ZRNSISUUUPRITUX6         = "zrnsisuuupritux6";
    public static final String ZRNTMTTKNZOUKARITUSTRX6  = "zrntmttknzoukaritustrx6";
    public static final String ZRNKAWASERATEX6          = "zrnkawaseratex6";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX7 = "zrntmttknsuiirirekikbnx7";
    public static final String ZRNKEIYAKUOUTOUBIX7      = "zrnkeiyakuoutoubix7";
    public static final String ZRNTMTTKNJYOUTAIX7       = "zrntmttknjyoutaix7";
    public static final String ZRNPTUMITATEKNGKKTUUKAX7 = "zrnptumitatekngkktuukax7";
    public static final String ZRNPTUMITATEKNGKYENX7    = "zrnptumitatekngkyenx7";
    public static final String ZRNSISUUX7               = "zrnsisuux7";
    public static final String ZRNSISUUUPRITUHUGOUX7    = "zrnsisuuuprituhugoux7";
    public static final String ZRNSISUUUPRITUX7         = "zrnsisuuupritux7";
    public static final String ZRNTMTTKNZOUKARITUSTRX7  = "zrntmttknzoukaritustrx7";
    public static final String ZRNKAWASERATEX7          = "zrnkawaseratex7";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX8 = "zrntmttknsuiirirekikbnx8";
    public static final String ZRNKEIYAKUOUTOUBIX8      = "zrnkeiyakuoutoubix8";
    public static final String ZRNTMTTKNJYOUTAIX8       = "zrntmttknjyoutaix8";
    public static final String ZRNPTUMITATEKNGKKTUUKAX8 = "zrnptumitatekngkktuukax8";
    public static final String ZRNPTUMITATEKNGKYENX8    = "zrnptumitatekngkyenx8";
    public static final String ZRNSISUUX8               = "zrnsisuux8";
    public static final String ZRNSISUUUPRITUHUGOUX8    = "zrnsisuuuprituhugoux8";
    public static final String ZRNSISUUUPRITUX8         = "zrnsisuuupritux8";
    public static final String ZRNTMTTKNZOUKARITUSTRX8  = "zrntmttknzoukaritustrx8";
    public static final String ZRNKAWASERATEX8          = "zrnkawaseratex8";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX9 = "zrntmttknsuiirirekikbnx9";
    public static final String ZRNKEIYAKUOUTOUBIX9      = "zrnkeiyakuoutoubix9";
    public static final String ZRNTMTTKNJYOUTAIX9       = "zrntmttknjyoutaix9";
    public static final String ZRNPTUMITATEKNGKKTUUKAX9 = "zrnptumitatekngkktuukax9";
    public static final String ZRNPTUMITATEKNGKYENX9    = "zrnptumitatekngkyenx9";
    public static final String ZRNSISUUX9               = "zrnsisuux9";
    public static final String ZRNSISUUUPRITUHUGOUX9    = "zrnsisuuuprituhugoux9";
    public static final String ZRNSISUUUPRITUX9         = "zrnsisuuupritux9";
    public static final String ZRNTMTTKNZOUKARITUSTRX9  = "zrntmttknzoukaritustrx9";
    public static final String ZRNKAWASERATEX9          = "zrnkawaseratex9";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX10 = "zrntmttknsuiirirekikbnx10";
    public static final String ZRNKEIYAKUOUTOUBIX10     = "zrnkeiyakuoutoubix10";
    public static final String ZRNTMTTKNJYOUTAIX10      = "zrntmttknjyoutaix10";
    public static final String ZRNPTUMITATEKNGKKTUUKAX10 = "zrnptumitatekngkktuukax10";
    public static final String ZRNPTUMITATEKNGKYENX10   = "zrnptumitatekngkyenx10";
    public static final String ZRNSISUUX10              = "zrnsisuux10";
    public static final String ZRNSISUUUPRITUHUGOUX10   = "zrnsisuuuprituhugoux10";
    public static final String ZRNSISUUUPRITUX10        = "zrnsisuuupritux10";
    public static final String ZRNTMTTKNZOUKARITUSTRX10 = "zrntmttknzoukaritustrx10";
    public static final String ZRNKAWASERATEX10         = "zrnkawaseratex10";
    public static final String ZRNTMTTKNSUIIRIREKIKBNX11 = "zrntmttknsuiirirekikbnx11";
    public static final String ZRNKEIYAKUOUTOUBIX11     = "zrnkeiyakuoutoubix11";
    public static final String ZRNTMTTKNJYOUTAIX11      = "zrntmttknjyoutaix11";
    public static final String ZRNPTUMITATEKNGKKTUUKAX11 = "zrnptumitatekngkktuukax11";
    public static final String ZRNPTUMITATEKNGKYENX11   = "zrnptumitatekngkyenx11";
    public static final String ZRNSISUUX11              = "zrnsisuux11";
    public static final String ZRNSISUUUPRITUHUGOUX11   = "zrnsisuuuprituhugoux11";
    public static final String ZRNSISUUUPRITUX11        = "zrnsisuuupritux11";
    public static final String ZRNTMTTKNZOUKARITUSTRX11 = "zrntmttknzoukaritustrx11";
    public static final String ZRNKAWASERATEX11         = "zrnkawaseratex11";
    public static final String ZRNTMTTKNSUIIYOBI        = "zrntmttknsuiiyobi";
    public static final String ZRNTTDKKIGEN             = "zrnttdkkigen";
    public static final String ZRNKRNKGNSGK             = "zrnkrnkgnsgk";
    public static final String ZRNTIRTITNTTDKYOBI       = "zrntirtitnttdkyobi";
    public static final String ZRNSKSHOZONNENSUU        = "zrnskshozonnensuu";
    public static final String ZRNDOCUMENTID            = "zrndocumentid";
    public static final String ZRNTORITUGISYASYOZOKUNM  = "zrntoritugisyasyozokunm";
    public static final String ZRNYENDTHNKHRSKSYOBI     = "zrnyendthnkhrsksyobi";
    public static final String ZRNYOTEIRIRITUKIJYUNYM1  = "zrnyoteiriritukijyunym1";
    public static final String ZRNYOTEIRIRITU1          = "zrnyoteiriritu1";
    public static final String ZRNYTIRRTCALCKIJYUNRRT1  = "zrnytirrtcalckijyunrrt1";
    public static final String ZRNKWSRATEKIJYUNYM1      = "zrnkwsratekijyunym1";
    public static final String ZRNKAKNSNKWSRATE1        = "zrnkaknsnkwsrate1";
    public static final String ZRNPGAIKA1               = "zrnpgaika1";
    public static final String ZRNPYEN1                 = "zrnpyen1";
    public static final String ZRNYOTEIRIRITUKIJYUNYM2  = "zrnyoteiriritukijyunym2";
    public static final String ZRNYOTEIRIRITU2          = "zrnyoteiriritu2";
    public static final String ZRNYTIRRTCALCKIJYUNRRT2  = "zrnytirrtcalckijyunrrt2";
    public static final String ZRNKWSRATEKIJYUNYM2      = "zrnkwsratekijyunym2";
    public static final String ZRNKAKNSNKWSRATE2        = "zrnkaknsnkwsrate2";
    public static final String ZRNPGAIKA2               = "zrnpgaika2";
    public static final String ZRNPYEN2                 = "zrnpyen2";
    public static final String ZRNYOTEIRIRITUKIJYUNYM3  = "zrnyoteiriritukijyunym3";
    public static final String ZRNYOTEIRIRITU3          = "zrnyoteiriritu3";
    public static final String ZRNYTIRRTCALCKIJYUNRRT3  = "zrnytirrtcalckijyunrrt3";
    public static final String ZRNKWSRATEKIJYUNYM3      = "zrnkwsratekijyunym3";
    public static final String ZRNKAKNSNKWSRATE3        = "zrnkaknsnkwsrate3";
    public static final String ZRNPGAIKA3               = "zrnpgaika3";
    public static final String ZRNPYEN3                 = "zrnpyen3";
    public static final String ZRNYOTEIRIRITUKIJYUNYM4  = "zrnyoteiriritukijyunym4";
    public static final String ZRNYOTEIRIRITU4          = "zrnyoteiriritu4";
    public static final String ZRNYTIRRTCALCKIJYUNRRT4  = "zrnytirrtcalckijyunrrt4";
    public static final String ZRNKWSRATEKIJYUNYM4      = "zrnkwsratekijyunym4";
    public static final String ZRNKAKNSNKWSRATE4        = "zrnkaknsnkwsrate4";
    public static final String ZRNPGAIKA4               = "zrnpgaika4";
    public static final String ZRNPYEN4                 = "zrnpyen4";
    public static final String ZRNYOTEIRIRITUKIJYUNYM5  = "zrnyoteiriritukijyunym5";
    public static final String ZRNYOTEIRIRITU5          = "zrnyoteiriritu5";
    public static final String ZRNYTIRRTCALCKIJYUNRRT5  = "zrnytirrtcalckijyunrrt5";
    public static final String ZRNKWSRATEKIJYUNYM5      = "zrnkwsratekijyunym5";
    public static final String ZRNKAKNSNKWSRATE5        = "zrnkaknsnkwsrate5";
    public static final String ZRNPGAIKA5               = "zrnpgaika5";
    public static final String ZRNPYEN5                 = "zrnpyen5";
    public static final String ZRNYOTEIRIRITUKIJYUNYM6  = "zrnyoteiriritukijyunym6";
    public static final String ZRNYOTEIRIRITU6          = "zrnyoteiriritu6";
    public static final String ZRNYTIRRTCALCKIJYUNRRT6  = "zrnytirrtcalckijyunrrt6";
    public static final String ZRNKWSRATEKIJYUNYM6      = "zrnkwsratekijyunym6";
    public static final String ZRNKAKNSNKWSRATE6        = "zrnkaknsnkwsrate6";
    public static final String ZRNPGAIKA6               = "zrnpgaika6";
    public static final String ZRNPYEN6                 = "zrnpyen6";
    public static final String ZRNYOTEIRIRITUKIJYUNYM7  = "zrnyoteiriritukijyunym7";
    public static final String ZRNYOTEIRIRITU7          = "zrnyoteiriritu7";
    public static final String ZRNYTIRRTCALCKIJYUNRRT7  = "zrnytirrtcalckijyunrrt7";
    public static final String ZRNKWSRATEKIJYUNYM7      = "zrnkwsratekijyunym7";
    public static final String ZRNKAKNSNKWSRATE7        = "zrnkaknsnkwsrate7";
    public static final String ZRNPGAIKA7               = "zrnpgaika7";
    public static final String ZRNPYEN7                 = "zrnpyen7";
    public static final String ZRNYOTEIRIRITUKIJYUNYM8  = "zrnyoteiriritukijyunym8";
    public static final String ZRNYOTEIRIRITU8          = "zrnyoteiriritu8";
    public static final String ZRNYTIRRTCALCKIJYUNRRT8  = "zrnytirrtcalckijyunrrt8";
    public static final String ZRNKWSRATEKIJYUNYM8      = "zrnkwsratekijyunym8";
    public static final String ZRNKAKNSNKWSRATE8        = "zrnkaknsnkwsrate8";
    public static final String ZRNPGAIKA8               = "zrnpgaika8";
    public static final String ZRNPYEN8                 = "zrnpyen8";
    public static final String ZRNYOTEIRIRITUKIJYUNYM9  = "zrnyoteiriritukijyunym9";
    public static final String ZRNYOTEIRIRITU9          = "zrnyoteiriritu9";
    public static final String ZRNYTIRRTCALCKIJYUNRRT9  = "zrnytirrtcalckijyunrrt9";
    public static final String ZRNKWSRATEKIJYUNYM9      = "zrnkwsratekijyunym9";
    public static final String ZRNKAKNSNKWSRATE9        = "zrnkaknsnkwsrate9";
    public static final String ZRNPGAIKA9               = "zrnpgaika9";
    public static final String ZRNPYEN9                 = "zrnpyen9";
    public static final String ZRNYOTEIRIRITUKIJYUNYM10 = "zrnyoteiriritukijyunym10";
    public static final String ZRNYOTEIRIRITU10         = "zrnyoteiriritu10";
    public static final String ZRNYTIRRTCALCKIJYUNRRT10 = "zrnytirrtcalckijyunrrt10";
    public static final String ZRNKWSRATEKIJYUNYM10     = "zrnkwsratekijyunym10";
    public static final String ZRNKAKNSNKWSRATE10       = "zrnkaknsnkwsrate10";
    public static final String ZRNPGAIKA10              = "zrnpgaika10";
    public static final String ZRNPYEN10                = "zrnpyen10";
    public static final String ZRNYOTEIRIRITUKIJYUNYM11 = "zrnyoteiriritukijyunym11";
    public static final String ZRNYOTEIRIRITU11         = "zrnyoteiriritu11";
    public static final String ZRNYTIRRTCALCKIJYUNRRT11 = "zrnytirrtcalckijyunrrt11";
    public static final String ZRNKWSRATEKIJYUNYM11     = "zrnkwsratekijyunym11";
    public static final String ZRNKAKNSNKWSRATE11       = "zrnkaknsnkwsrate11";
    public static final String ZRNPGAIKA11              = "zrnpgaika11";
    public static final String ZRNPYEN11                = "zrnpyen11";
    public static final String ZRNYOTEIRIRITUKIJYUNYM12 = "zrnyoteiriritukijyunym12";
    public static final String ZRNYOTEIRIRITU12         = "zrnyoteiriritu12";
    public static final String ZRNYTIRRTCALCKIJYUNRRT12 = "zrnytirrtcalckijyunrrt12";
    public static final String ZRNKWSRATEKIJYUNYM12     = "zrnkwsratekijyunym12";
    public static final String ZRNKAKNSNKWSRATE12       = "zrnkaknsnkwsrate12";
    public static final String ZRNPGAIKA12              = "zrnpgaika12";
    public static final String ZRNPYEN12                = "zrnpyen12";
    public static final String ZRNFSTPHYOUJIKBN1        = "zrnfstphyoujikbn1";
    public static final String ZRNFSTPHYOUJIKBN2        = "zrnfstphyoujikbn2";
    public static final String ZRNFSTPHYOUJIKBN3        = "zrnfstphyoujikbn3";
    public static final String ZRNFSTPHYOUJIKBN4        = "zrnfstphyoujikbn4";
    public static final String ZRNFSTPHYOUJIKBN5        = "zrnfstphyoujikbn5";
    public static final String ZRNFSTPHYOUJIKBN6        = "zrnfstphyoujikbn6";
    public static final String ZRNFSTPHYOUJIKBN7        = "zrnfstphyoujikbn7";
    public static final String ZRNFSTPHYOUJIKBN8        = "zrnfstphyoujikbn8";
    public static final String ZRNFSTPHYOUJIKBN9        = "zrnfstphyoujikbn9";
    public static final String ZRNFSTPHYOUJIKBN10       = "zrnfstphyoujikbn10";
    public static final String ZRNFSTPHYOUJIKBN11       = "zrnfstphyoujikbn11";
    public static final String ZRNFSTPHYOUJIKBN12       = "zrnfstphyoujikbn12";
    public static final String ZRNYTIRRTITRNYOBI2       = "zrnytirrtitrnyobi2";
    public static final String ZRNYTIRRTITRNHSKMSGCD1   = "zrnytirrtitrnhskmsgcd1";
    public static final String ZRNYTIRRTITRNHSKMSGCD2   = "zrnytirrtitrnhskmsgcd2";
    public static final String ZRNYTIRRTITRNHSKMSGCD3   = "zrnytirrtitrnhskmsgcd3";
    public static final String ZRNYTIRRTITRNHSKMSGCD4   = "zrnytirrtitrnhskmsgcd4";
    public static final String ZRNYTIRRTITRNHSKMSGCD5   = "zrnytirrtitrnhskmsgcd5";
    public static final String ZRNYTIRRTITRNHSKMSGCD6   = "zrnytirrtitrnhskmsgcd6";
    public static final String ZRNYTIRRTITRNHSKMSGCD7   = "zrnytirrtitrnhskmsgcd7";
    public static final String ZRNYTIRRTITRNHSKMSGCD8   = "zrnytirrtitrnhskmsgcd8";
    public static final String ZRNYTIRRTITRNYOBI        = "zrnytirrtitrnyobi";

    private final PKZT_GaikaKokyakuTuutiRn primaryKey;

    public GenZT_GaikaKokyakuTuutiRn() {
        primaryKey = new PKZT_GaikaKokyakuTuutiRn();
    }

    public GenZT_GaikaKokyakuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        primaryKey = new PKZT_GaikaKokyakuTuutiRn(pZrntyouhyouymd, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_GaikaKokyakuTuutiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_GaikaKokyakuTuutiRn> getMetaClass() {
        return QZT_GaikaKokyakuTuutiRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    @Id
    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrndskaiyktirasidouhuukbn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNDSKAIYKTIRASIDOUHUUKBN)
    public String getZrndskaiyktirasidouhuukbn() {
        return zrndskaiyktirasidouhuukbn;
    }

    public void setZrndskaiyktirasidouhuukbn(String pZrndskaiyktirasidouhuukbn) {
        zrndskaiyktirasidouhuukbn = pZrndskaiyktirasidouhuukbn;
    }

    private String zrnhrknkanssiryodouhuukbn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHRKNKANSSIRYODOUHUUKBN)
    public String getZrnhrknkanssiryodouhuukbn() {
        return zrnhrknkanssiryodouhuukbn;
    }

    public void setZrnhrknkanssiryodouhuukbn(String pZrnhrknkanssiryodouhuukbn) {
        zrnhrknkanssiryodouhuukbn = pZrnhrknkanssiryodouhuukbn;
    }

    private String zrnassistplustirasidhkbn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNASSISTPLUSTIRASIDHKBN)
    public String getZrnassistplustirasidhkbn() {
        return zrnassistplustirasidhkbn;
    }

    public void setZrnassistplustirasidhkbn(String pZrnassistplustirasidhkbn) {
        zrnassistplustirasidhkbn = pZrnassistplustirasidhkbn;
    }

    private String zrnkoktuutireportlayoutptn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKOKTUUTIREPORTLAYOUTPTN)
    public String getZrnkoktuutireportlayoutptn() {
        return zrnkoktuutireportlayoutptn;
    }

    public void setZrnkoktuutireportlayoutptn(String pZrnkoktuutireportlayoutptn) {
        zrnkoktuutireportlayoutptn = pZrnkoktuutireportlayoutptn;
    }

    private String zrngengkumu;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNGENGKUMU)
    public String getZrngengkumu() {
        return zrngengkumu;
    }

    public void setZrngengkumu(String pZrngengkumu) {
        zrngengkumu = pZrngengkumu;
    }

    private String zrnkytkmkyobi1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKYTKMKYOBI1)
    public String getZrnkytkmkyobi1() {
        return zrnkytkmkyobi1;
    }

    public void setZrnkytkmkyobi1(String pZrnkytkmkyobi1) {
        zrnkytkmkyobi1 = pZrnkytkmkyobi1;
    }

    private String zrntuusinsakiyuubinno;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTUUSINSAKIYUUBINNO)
    public String getZrntuusinsakiyuubinno() {
        return zrntuusinsakiyuubinno;
    }

    public void setZrntuusinsakiyuubinno(String pZrntuusinsakiyuubinno) {
        zrntuusinsakiyuubinno = pZrntuusinsakiyuubinno;
    }

    private String zrntsinadr1kj;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTSINADR1KJ)
    public String getZrntsinadr1kj() {
        return zrntsinadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntsinadr1kj(String pZrntsinadr1kj) {
        zrntsinadr1kj = pZrntsinadr1kj;
    }

    private String zrntsinadr2kj;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTSINADR2KJ)
    public String getZrntsinadr2kj() {
        return zrntsinadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntsinadr2kj(String pZrntsinadr2kj) {
        zrntsinadr2kj = pZrntsinadr2kj;
    }

    private String zrntsinadr3kj;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTSINADR3KJ)
    public String getZrntsinadr3kj() {
        return zrntsinadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntsinadr3kj(String pZrntsinadr3kj) {
        zrntsinadr3kj = pZrntsinadr3kj;
    }

    private String zrntsintelno;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTSINTELNO)
    public String getZrntsintelno() {
        return zrntsintelno;
    }

    public void setZrntsintelno(String pZrntsintelno) {
        zrntsintelno = pZrntsintelno;
    }

    private String zrntsinnm18;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTSINNM18)
    public String getZrntsinnm18() {
        return zrntsinnm18;
    }

    @DataConvert("toMultiByte")
    public void setZrntsinnm18(String pZrntsinnm18) {
        zrntsinnm18 = pZrntsinnm18;
    }

    private String zrnyobiv19;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOBIV19)
    public String getZrnyobiv19() {
        return zrnyobiv19;
    }

    public void setZrnyobiv19(String pZrnyobiv19) {
        zrnyobiv19 = pZrnyobiv19;
    }

    private String zrnsyoukaisakidrtennm1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSYOUKAISAKIDRTENNM1)
    public String getZrnsyoukaisakidrtennm1() {
        return zrnsyoukaisakidrtennm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyoukaisakidrtennm1(String pZrnsyoukaisakidrtennm1) {
        zrnsyoukaisakidrtennm1 = pZrnsyoukaisakidrtennm1;
    }

    private String zrnsyoukaisakidrtennm2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSYOUKAISAKIDRTENNM2)
    public String getZrnsyoukaisakidrtennm2() {
        return zrnsyoukaisakidrtennm2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyoukaisakidrtennm2(String pZrnsyoukaisakidrtennm2) {
        zrnsyoukaisakidrtennm2 = pZrnsyoukaisakidrtennm2;
    }

    private String zrnyobiv20;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOBIV20)
    public String getZrnyobiv20() {
        return zrnyobiv20;
    }

    public void setZrnyobiv20(String pZrnyobiv20) {
        zrnyobiv20 = pZrnyobiv20;
    }

    private String zrnaisatumsgcd1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNAISATUMSGCD1)
    public String getZrnaisatumsgcd1() {
        return zrnaisatumsgcd1;
    }

    public void setZrnaisatumsgcd1(String pZrnaisatumsgcd1) {
        zrnaisatumsgcd1 = pZrnaisatumsgcd1;
    }

    private String zrnaisatumsgcd2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNAISATUMSGCD2)
    public String getZrnaisatumsgcd2() {
        return zrnaisatumsgcd2;
    }

    public void setZrnaisatumsgcd2(String pZrnaisatumsgcd2) {
        zrnaisatumsgcd2 = pZrnaisatumsgcd2;
    }

    private String zrnaisatumsgcd3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNAISATUMSGCD3)
    public String getZrnaisatumsgcd3() {
        return zrnaisatumsgcd3;
    }

    public void setZrnaisatumsgcd3(String pZrnaisatumsgcd3) {
        zrnaisatumsgcd3 = pZrnaisatumsgcd3;
    }

    private String zrnosirasetuutisakuseiymwa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNOSIRASETUUTISAKUSEIYMWA)
    public String getZrnosirasetuutisakuseiymwa() {
        return zrnosirasetuutisakuseiymwa;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasetuutisakuseiymwa(String pZrnosirasetuutisakuseiymwa) {
        zrnosirasetuutisakuseiymwa = pZrnosirasetuutisakuseiymwa;
    }

    private String zrnsyono2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnaisyoumeikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNAISYOUMEIKBN)
    public String getZrnaisyoumeikbn() {
        return zrnaisyoumeikbn;
    }

    public void setZrnaisyoumeikbn(String pZrnaisyoumeikbn) {
        zrnaisyoumeikbn = pZrnaisyoumeikbn;
    }

    private String zrnkyknmkj18;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKYKNMKJ18)
    public String getZrnkyknmkj18() {
        return zrnkyknmkj18;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj18(String pZrnkyknmkj18) {
        zrnkyknmkj18 = pZrnkyknmkj18;
    }

    private String zrnhhknnmkj18;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHHKNNMKJ18)
    public String getZrnhhknnmkj18() {
        return zrnhhknnmkj18;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj18(String pZrnhhknnmkj18) {
        zrnhhknnmkj18 = pZrnhhknnmkj18;
    }

    private String zrnuktmidasikbn1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTMIDASIKBN1)
    public String getZrnuktmidasikbn1() {
        return zrnuktmidasikbn1;
    }

    public void setZrnuktmidasikbn1(String pZrnuktmidasikbn1) {
        zrnuktmidasikbn1 = pZrnuktmidasikbn1;
    }

    private String zrnuktkbn1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTKBN1)
    public String getZrnuktkbn1() {
        return zrnuktkbn1;
    }

    public void setZrnuktkbn1(String pZrnuktkbn1) {
        zrnuktkbn1 = pZrnuktkbn1;
    }

    private String zrnuktnm118;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTNM118)
    public String getZrnuktnm118() {
        return zrnuktnm118;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm118(String pZrnuktnm118) {
        zrnuktnm118 = pZrnuktnm118;
    }

    private String zrnuktmidasikbn2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTMIDASIKBN2)
    public String getZrnuktmidasikbn2() {
        return zrnuktmidasikbn2;
    }

    public void setZrnuktmidasikbn2(String pZrnuktmidasikbn2) {
        zrnuktmidasikbn2 = pZrnuktmidasikbn2;
    }

    private String zrnuktkbn2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTKBN2)
    public String getZrnuktkbn2() {
        return zrnuktkbn2;
    }

    public void setZrnuktkbn2(String pZrnuktkbn2) {
        zrnuktkbn2 = pZrnuktkbn2;
    }

    private String zrnuktnm218;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTNM218)
    public String getZrnuktnm218() {
        return zrnuktnm218;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm218(String pZrnuktnm218) {
        zrnuktnm218 = pZrnuktnm218;
    }

    private String zrnuktmidasikbn3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTMIDASIKBN3)
    public String getZrnuktmidasikbn3() {
        return zrnuktmidasikbn3;
    }

    public void setZrnuktmidasikbn3(String pZrnuktmidasikbn3) {
        zrnuktmidasikbn3 = pZrnuktmidasikbn3;
    }

    private String zrnuktkbn3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTKBN3)
    public String getZrnuktkbn3() {
        return zrnuktkbn3;
    }

    public void setZrnuktkbn3(String pZrnuktkbn3) {
        zrnuktkbn3 = pZrnuktkbn3;
    }

    private String zrnuktnm318;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTNM318)
    public String getZrnuktnm318() {
        return zrnuktnm318;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm318(String pZrnuktnm318) {
        zrnuktnm318 = pZrnuktnm318;
    }

    private String zrnuktmidasikbn4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTMIDASIKBN4)
    public String getZrnuktmidasikbn4() {
        return zrnuktmidasikbn4;
    }

    public void setZrnuktmidasikbn4(String pZrnuktmidasikbn4) {
        zrnuktmidasikbn4 = pZrnuktmidasikbn4;
    }

    private String zrnuktkbn4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTKBN4)
    public String getZrnuktkbn4() {
        return zrnuktkbn4;
    }

    public void setZrnuktkbn4(String pZrnuktkbn4) {
        zrnuktkbn4 = pZrnuktkbn4;
    }

    private String zrnuktnm418;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTNM418)
    public String getZrnuktnm418() {
        return zrnuktnm418;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm418(String pZrnuktnm418) {
        zrnuktnm418 = pZrnuktnm418;
    }

    private String zrnuktmidasikbn5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTMIDASIKBN5)
    public String getZrnuktmidasikbn5() {
        return zrnuktmidasikbn5;
    }

    public void setZrnuktmidasikbn5(String pZrnuktmidasikbn5) {
        zrnuktmidasikbn5 = pZrnuktmidasikbn5;
    }

    private String zrnuktkbn5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTKBN5)
    public String getZrnuktkbn5() {
        return zrnuktkbn5;
    }

    public void setZrnuktkbn5(String pZrnuktkbn5) {
        zrnuktkbn5 = pZrnuktkbn5;
    }

    private String zrnuktnm518;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNUKTNM518)
    public String getZrnuktnm518() {
        return zrnuktnm518;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm518(String pZrnuktnm518) {
        zrnuktnm518 = pZrnuktnm518;
    }

    private String zrnkykymdwa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKYKYMDWA)
    public String getZrnkykymdwa() {
        return zrnkykymdwa;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykymdwa(String pZrnkykymdwa) {
        zrnkykymdwa = pZrnkykymdwa;
    }

    private String zrndai1hknkknfromwa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNDAI1HKNKKNFROMWA)
    public String getZrndai1hknkknfromwa() {
        return zrndai1hknkknfromwa;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1hknkknfromwa(String pZrndai1hknkknfromwa) {
        zrndai1hknkknfromwa = pZrndai1hknkknfromwa;
    }

    private String zrndai1hknkkn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNDAI1HKNKKN)
    public String getZrndai1hknkkn() {
        return zrndai1hknkkn;
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        zrndai1hknkkn = pZrndai1hknkkn;
    }

    private String zrndai2hknkknfromwa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNDAI2HKNKKNFROMWA)
    public String getZrndai2hknkknfromwa() {
        return zrndai2hknkknfromwa;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2hknkknfromwa(String pZrndai2hknkknfromwa) {
        zrndai2hknkknfromwa = pZrndai2hknkknfromwa;
    }

    private String zrndai2hknkkntowa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNDAI2HKNKKNTOWA)
    public String getZrndai2hknkkntowa() {
        return zrndai2hknkkntowa;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2hknkkntowa(String pZrndai2hknkkntowa) {
        zrndai2hknkkntowa = pZrndai2hknkkntowa;
    }

    private String zrndai3hknkknfromwa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNDAI3HKNKKNFROMWA)
    public String getZrndai3hknkknfromwa() {
        return zrndai3hknkknfromwa;
    }

    @DataConvert("toMultiByte")
    public void setZrndai3hknkknfromwa(String pZrndai3hknkknfromwa) {
        zrndai3hknkknfromwa = pZrndai3hknkknfromwa;
    }

    private String zrndai3hknkknto;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNDAI3HKNKKNTO)
    public String getZrndai3hknkknto() {
        return zrndai3hknkknto;
    }

    @DataConvert("toMultiByte")
    public void setZrndai3hknkknto(String pZrndai3hknkknto) {
        zrndai3hknkknto = pZrndai3hknkknto;
    }

    private String zrnkyktuukasyuzn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKYKTUUKASYUZN)
    public String getZrnkyktuukasyuzn() {
        return zrnkyktuukasyuzn;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyktuukasyuzn(String pZrnkyktuukasyuzn) {
        zrnkyktuukasyuzn = pZrnkyktuukasyuzn;
    }

    private String zrnkyktuukatype;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKYKTUUKATYPE)
    public String getZrnkyktuukatype() {
        return zrnkyktuukatype;
    }

    public void setZrnkyktuukatype(String pZrnkyktuukatype) {
        zrnkyktuukatype = pZrnkyktuukatype;
    }

    private String zrntk1msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTK1MSGCD)
    public String getZrntk1msgcd() {
        return zrntk1msgcd;
    }

    public void setZrntk1msgcd(String pZrntk1msgcd) {
        zrntk1msgcd = pZrntk1msgcd;
    }

    private String zrntk2msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTK2MSGCD)
    public String getZrntk2msgcd() {
        return zrntk2msgcd;
    }

    public void setZrntk2msgcd(String pZrntk2msgcd) {
        zrntk2msgcd = pZrntk2msgcd;
    }

    private String zrntk3msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTK3MSGCD)
    public String getZrntk3msgcd() {
        return zrntk3msgcd;
    }

    public void setZrntk3msgcd(String pZrntk3msgcd) {
        zrntk3msgcd = pZrntk3msgcd;
    }

    private String zrntk4msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTK4MSGCD)
    public String getZrntk4msgcd() {
        return zrntk4msgcd;
    }

    public void setZrntk4msgcd(String pZrntk4msgcd) {
        zrntk4msgcd = pZrntk4msgcd;
    }

    private String zrntk5msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTK5MSGCD)
    public String getZrntk5msgcd() {
        return zrntk5msgcd;
    }

    public void setZrntk5msgcd(String pZrntk5msgcd) {
        zrntk5msgcd = pZrntk5msgcd;
    }

    private String zrntk6msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTK6MSGCD)
    public String getZrntk6msgcd() {
        return zrntk6msgcd;
    }

    public void setZrntk6msgcd(String pZrntk6msgcd) {
        zrntk6msgcd = pZrntk6msgcd;
    }

    private String zrntk7msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTK7MSGCD)
    public String getZrntk7msgcd() {
        return zrntk7msgcd;
    }

    public void setZrntk7msgcd(String pZrntk7msgcd) {
        zrntk7msgcd = pZrntk7msgcd;
    }

    private String zrntk8msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTK8MSGCD)
    public String getZrntk8msgcd() {
        return zrntk8msgcd;
    }

    public void setZrntk8msgcd(String pZrntk8msgcd) {
        zrntk8msgcd = pZrntk8msgcd;
    }

    private String zrntk9msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTK9MSGCD)
    public String getZrntk9msgcd() {
        return zrntk9msgcd;
    }

    public void setZrntk9msgcd(String pZrntk9msgcd) {
        zrntk9msgcd = pZrntk9msgcd;
    }

    private String zrntk10msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTK10MSGCD)
    public String getZrntk10msgcd() {
        return zrntk10msgcd;
    }

    public void setZrntk10msgcd(String pZrntk10msgcd) {
        zrntk10msgcd = pZrntk10msgcd;
    }

    private String zrndstourokujyou;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNDSTOUROKUJYOU)
    public String getZrndstourokujyou() {
        return zrndstourokujyou;
    }

    public void setZrndstourokujyou(String pZrndstourokujyou) {
        zrndstourokujyou = pZrndstourokujyou;
    }

    private String zrnsd1msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSD1MSGCD)
    public String getZrnsd1msgcd() {
        return zrnsd1msgcd;
    }

    public void setZrnsd1msgcd(String pZrnsd1msgcd) {
        zrnsd1msgcd = pZrnsd1msgcd;
    }

    private String zrnsd2msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSD2MSGCD)
    public String getZrnsd2msgcd() {
        return zrnsd2msgcd;
    }

    public void setZrnsd2msgcd(String pZrnsd2msgcd) {
        zrnsd2msgcd = pZrnsd2msgcd;
    }

    private String zrnsd3msgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSD3MSGCD)
    public String getZrnsd3msgcd() {
        return zrnsd3msgcd;
    }

    public void setZrnsd3msgcd(String pZrnsd3msgcd) {
        zrnsd3msgcd = pZrnsd3msgcd;
    }

    private String zrnkrpassword;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKRPASSWORD)
    public String getZrnkrpassword() {
        return zrnkrpassword;
    }

    public void setZrnkrpassword(String pZrnkrpassword) {
        zrnkrpassword = pZrnkrpassword;
    }

    private String zrnyuukoukigenwareki;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYUUKOUKIGENWAREKI)
    public String getZrnyuukoukigenwareki() {
        return zrnyuukoukigenwareki;
    }

    @DataConvert("toMultiByte")
    public void setZrnyuukoukigenwareki(String pZrnyuukoukigenwareki) {
        zrnyuukoukigenwareki = pZrnyuukoukigenwareki;
    }

    private String zrnkzktrkjk;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKZKTRKJK)
    public String getZrnkzktrkjk() {
        return zrnkzktrkjk;
    }

    public void setZrnkzktrkjk(String pZrnkzktrkjk) {
        zrnkzktrkjk = pZrnkzktrkjk;
    }

    private String zrntrkkzknm118;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTRKKZKNM118)
    public String getZrntrkkzknm118() {
        return zrntrkkzknm118;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzknm118(String pZrntrkkzknm118) {
        zrntrkkzknm118 = pZrntrkkzknm118;
    }

    private String zrntrkkzknm218;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTRKKZKNM218)
    public String getZrntrkkzknm218() {
        return zrntrkkzknm218;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzknm218(String pZrntrkkzknm218) {
        zrntrkkzknm218 = pZrntrkkzknm218;
    }

    private String zrnyendthnkymd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYENDTHNKYMD)
    public String getZrnyendthnkymd() {
        return zrnyendthnkymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnyendthnkymd(String pZrnyendthnkymd) {
        zrnyendthnkymd = pZrnyendthnkymd;
    }

    private String zrnnkshrstartymdstr;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNKSHRSTARTYMDSTR)
    public String getZrnnkshrstartymdstr() {
        return zrnnkshrstartymdstr;
    }

    @DataConvert("toMultiByte")
    public void setZrnnkshrstartymdstr(String pZrnnkshrstartymdstr) {
        zrnnkshrstartymdstr = pZrnnkshrstartymdstr;
    }

    private String zrnnenkinstartnen;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNENKINSTARTNEN)
    public String getZrnnenkinstartnen() {
        return zrnnenkinstartnen;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnnenkinstartnen(String pZrnnenkinstartnen) {
        zrnnenkinstartnen = pZrnnenkinstartnen;
    }

    private String zrnnksyuruinm;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNKSYURUINM)
    public String getZrnnksyuruinm() {
        return zrnnksyuruinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnnksyuruinm(String pZrnnksyuruinm) {
        zrnnksyuruinm = pZrnnksyuruinm;
    }

    private String zrnhrkkaisuu;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHRKKAISUU)
    public String getZrnhrkkaisuu() {
        return zrnhrkkaisuu;
    }

    public void setZrnhrkkaisuu(String pZrnhrkkaisuu) {
        zrnhrkkaisuu = pZrnhrkkaisuu;
    }

    private String zrntikiktbrisyuruikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTIKIKTBRISYURUIKBN)
    public String getZrntikiktbrisyuruikbn() {
        return zrntikiktbrisyuruikbn;
    }

    public void setZrntikiktbrisyuruikbn(String pZrntikiktbrisyuruikbn) {
        zrntikiktbrisyuruikbn = pZrntikiktbrisyuruikbn;
    }

    private String zrnzennouumu;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNZENNOUUMU)
    public String getZrnzennouumu() {
        return zrnzennouumu;
    }

    public void setZrnzennouumu(String pZrnzennouumu) {
        zrnzennouumu = pZrnzennouumu;
    }

    private String zrnhrkkeiro;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHRKKEIRO)
    public String getZrnhrkkeiro() {
        return zrnhrkkeiro;
    }

    public void setZrnhrkkeiro(String pZrnhrkkeiro) {
        zrnhrkkeiro = pZrnhrkkeiro;
    }

    private String zrnphrkkkn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPHRKKKN)
    public String getZrnphrkkkn() {
        return zrnphrkkkn;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnphrkkkn(String pZrnphrkkkn) {
        zrnphrkkkn = pZrnphrkkkn;
    }

    private String zrnsueokikkn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSUEOKIKKN)
    public String getZrnsueokikkn() {
        return zrnsueokikkn;
    }

    public void setZrnsueokikkn(String pZrnsueokikkn) {
        zrnsueokikkn = pZrnsueokikkn;
    }

    private String zrnyakkanbunsyono;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYAKKANBUNSYONO)
    public String getZrnyakkanbunsyono() {
        return zrnyakkanbunsyono;
    }

    public void setZrnyakkanbunsyono(String pZrnyakkanbunsyono) {
        zrnyakkanbunsyono = pZrnyakkanbunsyono;
    }

    private String zrngkykniyuosiraseyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNGKYKNIYUOSIRASEYOBI)
    public String getZrngkykniyuosiraseyobi() {
        return zrngkykniyuosiraseyobi;
    }

    public void setZrngkykniyuosiraseyobi(String pZrngkykniyuosiraseyobi) {
        zrngkykniyuosiraseyobi = pZrngkykniyuosiraseyobi;
    }

    private String zrnsakuseikijyunymdwa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSAKUSEIKIJYUNYMDWA)
    public String getZrnsakuseikijyunymdwa() {
        return zrnsakuseikijyunymdwa;
    }

    @DataConvert("toMultiByte")
    public void setZrnsakuseikijyunymdwa(String pZrnsakuseikijyunymdwa) {
        zrnsakuseikijyunymdwa = pZrnsakuseikijyunymdwa;
    }

    private String zrnitijibrpkyktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNITIJIBRPKYKTUUKA)
    public String getZrnitijibrpkyktuuka() {
        return zrnitijibrpkyktuuka;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnitijibrpkyktuuka(String pZrnitijibrpkyktuuka) {
        zrnitijibrpkyktuuka = pZrnitijibrpkyktuuka;
    }

    private String zrnkihonsktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKIHONSKTUUKA)
    public String getZrnkihonsktuuka() {
        return zrnkihonsktuuka;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkihonsktuuka(String pZrnkihonsktuuka) {
        zrnkihonsktuuka = pZrnkihonsktuuka;
    }

    private String zrnyenhrkgk;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYENHRKGK)
    public String getZrnyenhrkgk() {
        return zrnyenhrkgk;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnyenhrkgk(String pZrnyenhrkgk) {
        zrnyenhrkgk = pZrnyenhrkgk;
    }

    private String zrnstigituukahrkgk;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSTIGITUUKAHRKGK)
    public String getZrnstigituukahrkgk() {
        return zrnstigituukahrkgk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnstigituukahrkgk(String pZrnstigituukahrkgk) {
        zrnstigituukahrkgk = pZrnstigituukahrkgk;
    }

    private String zrnhrktuukasyuzn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHRKTUUKASYUZN)
    public String getZrnhrktuukasyuzn() {
        return zrnhrktuukasyuzn;
    }

    @DataConvert("toMultiByte")
    public void setZrnhrktuukasyuzn(String pZrnhrktuukasyuzn) {
        zrnhrktuukasyuzn = pZrnhrktuukasyuzn;
    }

    private String zrnhrktuukatype;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHRKTUUKATYPE)
    public String getZrnhrktuukatype() {
        return zrnhrktuukatype;
    }

    public void setZrnhrktuukatype(String pZrnhrktuukatype) {
        zrnhrktuukatype = pZrnhrktuukatype;
    }

    private String zrnyenkhrikmrate;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYENKHRIKMRATE)
    public String getZrnyenkhrikmrate() {
        return zrnyenkhrikmrate;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnyenkhrikmrate(String pZrnyenkhrikmrate) {
        zrnyenkhrikmrate = pZrnyenkhrikmrate;
    }

    private String zrnstigikwsrate;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSTIGIKWSRATE)
    public String getZrnstigikwsrate() {
        return zrnstigikwsrate;
    }

    @Padding(mode = "left", padChar ='0', length =7)
    public void setZrnstigikwsrate(String pZrnstigikwsrate) {
        zrnstigikwsrate = pZrnstigikwsrate;
    }

    private String zrnhrkgkhyoujikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHRKGKHYOUJIKBN)
    public String getZrnhrkgkhyoujikbn() {
        return zrnhrkgkhyoujikbn;
    }

    public void setZrnhrkgkhyoujikbn(String pZrnhrkgkhyoujikbn) {
        zrnhrkgkhyoujikbn = pZrnhrkgkhyoujikbn;
    }

    private String zrnkijyunkingaku;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKIJYUNKINGAKU)
    public String getZrnkijyunkingaku() {
        return zrnkijyunkingaku;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnkijyunkingaku(String pZrnkijyunkingaku) {
        zrnkijyunkingaku = pZrnkijyunkingaku;
    }

    private String zrnkjnkngkkawaserate;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKJNKNGKKAWASERATE)
    public String getZrnkjnkngkkawaserate() {
        return zrnkjnkngkkawaserate;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkjnkngkkawaserate(String pZrnkjnkngkkawaserate) {
        zrnkjnkngkkawaserate = pZrnkjnkngkkawaserate;
    }

    private String zrnkjnkngkhyoujikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKJNKNGKHYOUJIKBN)
    public String getZrnkjnkngkhyoujikbn() {
        return zrnkjnkngkhyoujikbn;
    }

    public void setZrnkjnkngkhyoujikbn(String pZrnkjnkngkhyoujikbn) {
        zrnkjnkngkhyoujikbn = pZrnkjnkngkhyoujikbn;
    }

    private String zrnsakuseikijyunymdkwsrate;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSAKUSEIKIJYUNYMDKWSRATE)
    public String getZrnsakuseikijyunymdkwsrate() {
        return zrnsakuseikijyunymdkwsrate;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsakuseikijyunymdkwsrate(String pZrnsakuseikijyunymdkwsrate) {
        zrnsakuseikijyunymdkwsrate = pZrnsakuseikijyunymdkwsrate;
    }

    private String zrnsbhknkngkhknkkn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSBHKNKNGKHKNKKN)
    public String getZrnsbhknkngkhknkkn() {
        return zrnsbhknkngkhknkkn;
    }

    public void setZrnsbhknkngkhknkkn(String pZrnsbhknkngkhknkkn) {
        zrnsbhknkngkhknkkn = pZrnsbhknkngkhknkkn;
    }

    private String zrnsbhknkngkhknkknfromwa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSBHKNKNGKHKNKKNFROMWA)
    public String getZrnsbhknkngkhknkknfromwa() {
        return zrnsbhknkngkhknkknfromwa;
    }

    @DataConvert("toMultiByte")
    public void setZrnsbhknkngkhknkknfromwa(String pZrnsbhknkngkhknkknfromwa) {
        zrnsbhknkngkhknkknfromwa = pZrnsbhknkngkhknkknfromwa;
    }

    private String zrnsbhknkngkhknkkntowa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSBHKNKNGKHKNKKNTOWA)
    public String getZrnsbhknkngkhknkkntowa() {
        return zrnsbhknkngkhknkkntowa;
    }

    @DataConvert("toMultiByte")
    public void setZrnsbhknkngkhknkkntowa(String pZrnsbhknkngkhknkkntowa) {
        zrnsbhknkngkhknkkntowa = pZrnsbhknkngkhknkkntowa;
    }

    private String zrnsbhknkngkkyktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSBHKNKNGKKYKTUUKA)
    public String getZrnsbhknkngkkyktuuka() {
        return zrnsbhknkngkkyktuuka;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsbhknkngkkyktuuka(String pZrnsbhknkngkkyktuuka) {
        zrnsbhknkngkkyktuuka = pZrnsbhknkngkkyktuuka;
    }

    private String zrnsbhknkngkyen;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSBHKNKNGKYEN)
    public String getZrnsbhknkngkyen() {
        return zrnsbhknkngkyen;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnsbhknkngkyen(String pZrnsbhknkngkyen) {
        zrnsbhknkngkyen = pZrnsbhknkngkyen;
    }

    private String zrnsaigaisbhknkngakuumu;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSAIGAISBHKNKNGAKUUMU)
    public String getZrnsaigaisbhknkngakuumu() {
        return zrnsaigaisbhknkngakuumu;
    }

    public void setZrnsaigaisbhknkngakuumu(String pZrnsaigaisbhknkngakuumu) {
        zrnsaigaisbhknkngakuumu = pZrnsaigaisbhknkngakuumu;
    }

    private String zrnsaigaisbhknkngakuktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSAIGAISBHKNKNGAKUKTUUKA)
    public String getZrnsaigaisbhknkngakuktuuka() {
        return zrnsaigaisbhknkngakuktuuka;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsaigaisbhknkngakuktuuka(String pZrnsaigaisbhknkngakuktuuka) {
        zrnsaigaisbhknkngakuktuuka = pZrnsaigaisbhknkngakuktuuka;
    }

    private String zrnsaigaisbhknkngakukyen;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSAIGAISBHKNKNGAKUKYEN)
    public String getZrnsaigaisbhknkngakukyen() {
        return zrnsaigaisbhknkngakukyen;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnsaigaisbhknkngakukyen(String pZrnsaigaisbhknkngakukyen) {
        zrnsaigaisbhknkngakukyen = pZrnsaigaisbhknkngakukyen;
    }

    private String zrntumitatekngkktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTUMITATEKNGKKTUUKA)
    public String getZrntumitatekngkktuuka() {
        return zrntumitatekngkktuuka;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrntumitatekngkktuuka(String pZrntumitatekngkktuuka) {
        zrntumitatekngkktuuka = pZrntumitatekngkktuuka;
    }

    private String zrntumitatekngkkyen;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTUMITATEKNGKKYEN)
    public String getZrntumitatekngkkyen() {
        return zrntumitatekngkkyen;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrntumitatekngkkyen(String pZrntumitatekngkkyen) {
        zrntumitatekngkkyen = pZrntumitatekngkkyen;
    }

    private String zrnkaiyakuhrkngakkyktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAIYAKUHRKNGAKKYKTUUKA)
    public String getZrnkaiyakuhrkngakkyktuuka() {
        return zrnkaiyakuhrkngakkyktuuka;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaiyakuhrkngakkyktuuka(String pZrnkaiyakuhrkngakkyktuuka) {
        zrnkaiyakuhrkngakkyktuuka = pZrnkaiyakuhrkngakkyktuuka;
    }

    private String zrnkaiyakuhrkngakyen;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAIYAKUHRKNGAKYEN)
    public String getZrnkaiyakuhrkngakyen() {
        return zrnkaiyakuhrkngakyen;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnkaiyakuhrkngakyen(String pZrnkaiyakuhrkngakyen) {
        zrnkaiyakuhrkngakyen = pZrnkaiyakuhrkngakyen;
    }

    private String zrnmkhgkyen;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNMKHGKYEN)
    public String getZrnmkhgkyen() {
        return zrnmkhgkyen;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnmkhgkyen(String pZrnmkhgkyen) {
        zrnmkhgkyen = pZrnmkhgkyen;
    }

    private String zrnmkhgkwari;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNMKHGKWARI)
    public String getZrnmkhgkwari() {
        return zrnmkhgkwari;
    }

    @DataConvert("toMultiByte")
    public void setZrnmkhgkwari(String pZrnmkhgkwari) {
        zrnmkhgkwari = pZrnmkhgkwari;
    }

    private String zrnmkhgkhyoujikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNMKHGKHYOUJIKBN)
    public String getZrnmkhgkhyoujikbn() {
        return zrnmkhgkhyoujikbn;
    }

    public void setZrnmkhgkhyoujikbn(String pZrnmkhgkhyoujikbn) {
        zrnmkhgkhyoujikbn = pZrnmkhgkhyoujikbn;
    }

    private String zrnhosyouhskmsgcd1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHOSYOUHSKMSGCD1)
    public String getZrnhosyouhskmsgcd1() {
        return zrnhosyouhskmsgcd1;
    }

    public void setZrnhosyouhskmsgcd1(String pZrnhosyouhskmsgcd1) {
        zrnhosyouhskmsgcd1 = pZrnhosyouhskmsgcd1;
    }

    private String zrnhosyouhskmsgcd2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHOSYOUHSKMSGCD2)
    public String getZrnhosyouhskmsgcd2() {
        return zrnhosyouhskmsgcd2;
    }

    public void setZrnhosyouhskmsgcd2(String pZrnhosyouhskmsgcd2) {
        zrnhosyouhskmsgcd2 = pZrnhosyouhskmsgcd2;
    }

    private String zrnhosyouhskmsgcd3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHOSYOUHSKMSGCD3)
    public String getZrnhosyouhskmsgcd3() {
        return zrnhosyouhskmsgcd3;
    }

    public void setZrnhosyouhskmsgcd3(String pZrnhosyouhskmsgcd3) {
        zrnhosyouhskmsgcd3 = pZrnhosyouhskmsgcd3;
    }

    private String zrnhosyouhskmsgcd4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHOSYOUHSKMSGCD4)
    public String getZrnhosyouhskmsgcd4() {
        return zrnhosyouhskmsgcd4;
    }

    public void setZrnhosyouhskmsgcd4(String pZrnhosyouhskmsgcd4) {
        zrnhosyouhskmsgcd4 = pZrnhosyouhskmsgcd4;
    }

    private String zrnhosyouhskmsgcd5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHOSYOUHSKMSGCD5)
    public String getZrnhosyouhskmsgcd5() {
        return zrnhosyouhskmsgcd5;
    }

    public void setZrnhosyouhskmsgcd5(String pZrnhosyouhskmsgcd5) {
        zrnhosyouhskmsgcd5 = pZrnhosyouhskmsgcd5;
    }

    private String zrnhosyouhskmsgcd6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHOSYOUHSKMSGCD6)
    public String getZrnhosyouhskmsgcd6() {
        return zrnhosyouhskmsgcd6;
    }

    public void setZrnhosyouhskmsgcd6(String pZrnhosyouhskmsgcd6) {
        zrnhosyouhskmsgcd6 = pZrnhosyouhskmsgcd6;
    }

    private String zrnhosyouhskmsgcd7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHOSYOUHSKMSGCD7)
    public String getZrnhosyouhskmsgcd7() {
        return zrnhosyouhskmsgcd7;
    }

    public void setZrnhosyouhskmsgcd7(String pZrnhosyouhskmsgcd7) {
        zrnhosyouhskmsgcd7 = pZrnhosyouhskmsgcd7;
    }

    private String zrnhosyouhskmsgcd8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHOSYOUHSKMSGCD8)
    public String getZrnhosyouhskmsgcd8() {
        return zrnhosyouhskmsgcd8;
    }

    public void setZrnhosyouhskmsgcd8(String pZrnhosyouhskmsgcd8) {
        zrnhosyouhskmsgcd8 = pZrnhosyouhskmsgcd8;
    }

    private String zrnhosyouhskmsgcd9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHOSYOUHSKMSGCD9)
    public String getZrnhosyouhskmsgcd9() {
        return zrnhosyouhskmsgcd9;
    }

    public void setZrnhosyouhskmsgcd9(String pZrnhosyouhskmsgcd9) {
        zrnhosyouhskmsgcd9 = pZrnhosyouhskmsgcd9;
    }

    private String zrnkihonsyen;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKIHONSYEN)
    public String getZrnkihonsyen() {
        return zrnkihonsyen;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnkihonsyen(String pZrnkihonsyen) {
        zrnkihonsyen = pZrnkihonsyen;
    }

    private String zrnyoteirirituv4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUV4)
    public String getZrnyoteirirituv4() {
        return zrnyoteirirituv4;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteirirituv4(String pZrnyoteirirituv4) {
        zrnyoteirirituv4 = pZrnyoteirirituv4;
    }

    private String zrnyendthnkhrkngakyen;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYENDTHNKHRKNGAKYEN)
    public String getZrnyendthnkhrkngakyen() {
        return zrnyendthnkhrkngakyen;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnyendthnkhrkngakyen(String pZrnyendthnkhrkngakyen) {
        zrnyendthnkhrkngakyen = pZrnyendthnkhrkngakyen;
    }

    private String zrntmtthaitoukinzndkyen;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTHAITOUKINZNDKYEN)
    public String getZrntmtthaitoukinzndkyen() {
        return zrntmtthaitoukinzndkyen;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrntmtthaitoukinzndkyen(String pZrntmtthaitoukinzndkyen) {
        zrntmtthaitoukinzndkyen = pZrntmtthaitoukinzndkyen;
    }

    private String zrnnkgnsgkkyktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNKGNSGKKYKTUUKA)
    public String getZrnnkgnsgkkyktuuka() {
        return zrnnkgnsgkkyktuuka;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnnkgnsgkkyktuuka(String pZrnnkgnsgkkyktuuka) {
        zrnnkgnsgkkyktuuka = pZrnnkgnsgkkyktuuka;
    }

    private String zrnsbhknkngkhyoujikbn;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSBHKNKNGKHYOUJIKBN)
    public String getZrnsbhknkngkhyoujikbn() {
        return zrnsbhknkngkhyoujikbn;
    }

    public void setZrnsbhknkngkhyoujikbn(String pZrnsbhknkngkhyoujikbn) {
        zrnsbhknkngkhyoujikbn = pZrnsbhknkngkhyoujikbn;
    }

    private String zrnkijyunkingakukyktuuka;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKIJYUNKINGAKUKYKTUUKA)
    public String getZrnkijyunkingakukyktuuka() {
        return zrnkijyunkingakukyktuuka;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkijyunkingakukyktuuka(String pZrnkijyunkingakukyktuuka) {
        zrnkijyunkingakukyktuuka = pZrnkijyunkingakukyktuuka;
    }

    private String zrnyenhrkgkiktnkgk;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYENHRKGKIKTNKGK)
    public String getZrnyenhrkgkiktnkgk() {
        return zrnyenhrkgkiktnkgk;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnyenhrkgkiktnkgk(String pZrnyenhrkgkiktnkgk) {
        zrnyenhrkgkiktnkgk = pZrnyenhrkgkiktnkgk;
    }

    private String zrnzennoutikiktyenhrkgkkykj;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNZENNOUTIKIKTYENHRKGKKYKJ)
    public String getZrnzennoutikiktyenhrkgkkykj() {
        return zrnzennoutikiktyenhrkgkkykj;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnzennoutikiktyenhrkgkkykj(String pZrnzennoutikiktyenhrkgkkykj) {
        zrnzennoutikiktyenhrkgkkykj = pZrnzennoutikiktyenhrkgkkykj;
    }

    private String zrnkaiyakusiharaigk;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAIYAKUSIHARAIGK)
    public String getZrnkaiyakusiharaigk() {
        return zrnkaiyakusiharaigk;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnkaiyakusiharaigk(String pZrnkaiyakusiharaigk) {
        zrnkaiyakusiharaigk = pZrnkaiyakusiharaigk;
    }

    private String zrnkaiyakusiharaigkznnuzndk;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAIYAKUSIHARAIGKZNNUZNDK)
    public String getZrnkaiyakusiharaigkznnuzndk() {
        return zrnkaiyakusiharaigkznnuzndk;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnkaiyakusiharaigkznnuzndk(String pZrnkaiyakusiharaigkznnuzndk) {
        zrnkaiyakusiharaigkznnuzndk = pZrnkaiyakusiharaigkznnuzndk;
    }

    private String zrnkaiyakusiharaigksntshrgk;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAIYAKUSIHARAIGKSNTSHRGK)
    public String getZrnkaiyakusiharaigksntshrgk() {
        return zrnkaiyakusiharaigksntshrgk;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnkaiyakusiharaigksntshrgk(String pZrnkaiyakusiharaigksntshrgk) {
        zrnkaiyakusiharaigksntshrgk = pZrnkaiyakusiharaigksntshrgk;
    }

    private String zrnyenhrkgkgoukei;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYENHRKGKGOUKEI)
    public String getZrnyenhrkgkgoukei() {
        return zrnyenhrkgkgoukei;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnyenhrkgkgoukei(String pZrnyenhrkgkgoukei) {
        zrnyenhrkgkgoukei = pZrnyenhrkgkgoukei;
    }

    private String zrnhrritu;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHRRITU)
    public String getZrnhrritu() {
        return zrnhrritu;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnhrritu(String pZrnhrritu) {
        zrnhrritu = pZrnhrritu;
    }

    private String zrnnkgnsyensyourai;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNKGNSYENSYOURAI)
    public String getZrnnkgnsyensyourai() {
        return zrnnkgnsyensyourai;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnnkgnsyensyourai(String pZrnnkgnsyensyourai) {
        zrnnkgnsyensyourai = pZrnnkgnsyensyourai;
    }

    private String zrnnkgnsgaikasyourai;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNKGNSGAIKASYOURAI)
    public String getZrnnkgnsgaikasyourai() {
        return zrnnkgnsgaikasyourai;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnnkgnsgaikasyourai(String pZrnnkgnsgaikasyourai) {
        zrnnkgnsgaikasyourai = pZrnnkgnsgaikasyourai;
    }

    private String zrnyenhrkgkgoukeisyourai;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYENHRKGKGOUKEISYOURAI)
    public String getZrnyenhrkgkgoukeisyourai() {
        return zrnyenhrkgkgoukeisyourai;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnyenhrkgkgoukeisyourai(String pZrnyenhrkgkgoukeisyourai) {
        zrnyenhrkgkgoukeisyourai = pZrnyenhrkgkgoukeisyourai;
    }

    private String zrnhrritusyourai;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHRRITUSYOURAI)
    public String getZrnhrritusyourai() {
        return zrnhrritusyourai;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnhrritusyourai(String pZrnhrritusyourai) {
        zrnhrritusyourai = pZrnhrritusyourai;
    }

    private String zrnnkgnshskmsgcd1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNKGNSHSKMSGCD1)
    public String getZrnnkgnshskmsgcd1() {
        return zrnnkgnshskmsgcd1;
    }

    public void setZrnnkgnshskmsgcd1(String pZrnnkgnshskmsgcd1) {
        zrnnkgnshskmsgcd1 = pZrnnkgnshskmsgcd1;
    }

    private String zrnnkgnshskmsgcd2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNKGNSHSKMSGCD2)
    public String getZrnnkgnshskmsgcd2() {
        return zrnnkgnshskmsgcd2;
    }

    public void setZrnnkgnshskmsgcd2(String pZrnnkgnshskmsgcd2) {
        zrnnkgnshskmsgcd2 = pZrnnkgnshskmsgcd2;
    }

    private String zrnnkgnshskmsgcd3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNKGNSHSKMSGCD3)
    public String getZrnnkgnshskmsgcd3() {
        return zrnnkgnshskmsgcd3;
    }

    public void setZrnnkgnshskmsgcd3(String pZrnnkgnshskmsgcd3) {
        zrnnkgnshskmsgcd3 = pZrnnkgnshskmsgcd3;
    }

    private String zrnnkgnshskmsgcd4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNKGNSHSKMSGCD4)
    public String getZrnnkgnshskmsgcd4() {
        return zrnnkgnshskmsgcd4;
    }

    public void setZrnnkgnshskmsgcd4(String pZrnnkgnshskmsgcd4) {
        zrnnkgnshskmsgcd4 = pZrnnkgnshskmsgcd4;
    }

    private String zrnnkgnshskmsgcd5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNNKGNSHSKMSGCD5)
    public String getZrnnkgnshskmsgcd5() {
        return zrnnkgnshskmsgcd5;
    }

    public void setZrnnkgnshskmsgcd5(String pZrnnkgnshskmsgcd5) {
        zrnnkgnshskmsgcd5 = pZrnnkgnshskmsgcd5;
    }

    private String zrnhosyounaiyouyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNHOSYOUNAIYOUYOBI)
    public String getZrnhosyounaiyouyobi() {
        return zrnhosyounaiyouyobi;
    }

    public void setZrnhosyounaiyouyobi(String pZrnhosyounaiyouyobi) {
        zrnhosyounaiyouyobi = pZrnhosyounaiyouyobi;
    }

    private String zrnkwsratekijyunymd1maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYMD1MAEWA)
    public String getZrnkwsratekijyunymd1maewa() {
        return zrnkwsratekijyunymd1maewa;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunymd1maewa(String pZrnkwsratekijyunymd1maewa) {
        zrnkwsratekijyunymd1maewa = pZrnkwsratekijyunymd1maewa;
    }

    private String zrnkwsrateusdjpy1mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEUSDJPY1MAE)
    public String getZrnkwsrateusdjpy1mae() {
        return zrnkwsrateusdjpy1mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateusdjpy1mae(String pZrnkwsrateusdjpy1mae) {
        zrnkwsrateusdjpy1mae = pZrnkwsrateusdjpy1mae;
    }

    private String zrnkwsrateaudjpy1mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEAUDJPY1MAE)
    public String getZrnkwsrateaudjpy1mae() {
        return zrnkwsrateaudjpy1mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateaudjpy1mae(String pZrnkwsrateaudjpy1mae) {
        zrnkwsrateaudjpy1mae = pZrnkwsrateaudjpy1mae;
    }

    private String zrnyobiv10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOBIV10)
    public String getZrnyobiv10() {
        return zrnyobiv10;
    }

    public void setZrnyobiv10(String pZrnyobiv10) {
        zrnyobiv10 = pZrnyobiv10;
    }

    private String zrnkwsratekijyunymd2maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYMD2MAEWA)
    public String getZrnkwsratekijyunymd2maewa() {
        return zrnkwsratekijyunymd2maewa;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunymd2maewa(String pZrnkwsratekijyunymd2maewa) {
        zrnkwsratekijyunymd2maewa = pZrnkwsratekijyunymd2maewa;
    }

    private String zrnkwsrateusdjpy2mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEUSDJPY2MAE)
    public String getZrnkwsrateusdjpy2mae() {
        return zrnkwsrateusdjpy2mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateusdjpy2mae(String pZrnkwsrateusdjpy2mae) {
        zrnkwsrateusdjpy2mae = pZrnkwsrateusdjpy2mae;
    }

    private String zrnkwsrateaudjpy2mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEAUDJPY2MAE)
    public String getZrnkwsrateaudjpy2mae() {
        return zrnkwsrateaudjpy2mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateaudjpy2mae(String pZrnkwsrateaudjpy2mae) {
        zrnkwsrateaudjpy2mae = pZrnkwsrateaudjpy2mae;
    }

    private String zrnyobiv10x2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOBIV10X2)
    public String getZrnyobiv10x2() {
        return zrnyobiv10x2;
    }

    public void setZrnyobiv10x2(String pZrnyobiv10x2) {
        zrnyobiv10x2 = pZrnyobiv10x2;
    }

    private String zrnkwsratekijyunymd3maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYMD3MAEWA)
    public String getZrnkwsratekijyunymd3maewa() {
        return zrnkwsratekijyunymd3maewa;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunymd3maewa(String pZrnkwsratekijyunymd3maewa) {
        zrnkwsratekijyunymd3maewa = pZrnkwsratekijyunymd3maewa;
    }

    private String zrnkwsrateusdjpy3mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEUSDJPY3MAE)
    public String getZrnkwsrateusdjpy3mae() {
        return zrnkwsrateusdjpy3mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateusdjpy3mae(String pZrnkwsrateusdjpy3mae) {
        zrnkwsrateusdjpy3mae = pZrnkwsrateusdjpy3mae;
    }

    private String zrnkwsrateaudjpy3mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEAUDJPY3MAE)
    public String getZrnkwsrateaudjpy3mae() {
        return zrnkwsrateaudjpy3mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateaudjpy3mae(String pZrnkwsrateaudjpy3mae) {
        zrnkwsrateaudjpy3mae = pZrnkwsrateaudjpy3mae;
    }

    private String zrnyobiv10x3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOBIV10X3)
    public String getZrnyobiv10x3() {
        return zrnyobiv10x3;
    }

    public void setZrnyobiv10x3(String pZrnyobiv10x3) {
        zrnyobiv10x3 = pZrnyobiv10x3;
    }

    private String zrnkwsratekijyunymd4maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYMD4MAEWA)
    public String getZrnkwsratekijyunymd4maewa() {
        return zrnkwsratekijyunymd4maewa;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunymd4maewa(String pZrnkwsratekijyunymd4maewa) {
        zrnkwsratekijyunymd4maewa = pZrnkwsratekijyunymd4maewa;
    }

    private String zrnkwsrateusdjpy4mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEUSDJPY4MAE)
    public String getZrnkwsrateusdjpy4mae() {
        return zrnkwsrateusdjpy4mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateusdjpy4mae(String pZrnkwsrateusdjpy4mae) {
        zrnkwsrateusdjpy4mae = pZrnkwsrateusdjpy4mae;
    }

    private String zrnkwsrateaudjpy4mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEAUDJPY4MAE)
    public String getZrnkwsrateaudjpy4mae() {
        return zrnkwsrateaudjpy4mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateaudjpy4mae(String pZrnkwsrateaudjpy4mae) {
        zrnkwsrateaudjpy4mae = pZrnkwsrateaudjpy4mae;
    }

    private String zrnyobiv10x4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOBIV10X4)
    public String getZrnyobiv10x4() {
        return zrnyobiv10x4;
    }

    public void setZrnyobiv10x4(String pZrnyobiv10x4) {
        zrnyobiv10x4 = pZrnyobiv10x4;
    }

    private String zrnkwsratekijyunymd5maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYMD5MAEWA)
    public String getZrnkwsratekijyunymd5maewa() {
        return zrnkwsratekijyunymd5maewa;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunymd5maewa(String pZrnkwsratekijyunymd5maewa) {
        zrnkwsratekijyunymd5maewa = pZrnkwsratekijyunymd5maewa;
    }

    private String zrnkwsrateusdjpy5mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEUSDJPY5MAE)
    public String getZrnkwsrateusdjpy5mae() {
        return zrnkwsrateusdjpy5mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateusdjpy5mae(String pZrnkwsrateusdjpy5mae) {
        zrnkwsrateusdjpy5mae = pZrnkwsrateusdjpy5mae;
    }

    private String zrnkwsrateaudjpy5mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEAUDJPY5MAE)
    public String getZrnkwsrateaudjpy5mae() {
        return zrnkwsrateaudjpy5mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateaudjpy5mae(String pZrnkwsrateaudjpy5mae) {
        zrnkwsrateaudjpy5mae = pZrnkwsrateaudjpy5mae;
    }

    private String zrnyobiv10x5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOBIV10X5)
    public String getZrnyobiv10x5() {
        return zrnyobiv10x5;
    }

    public void setZrnyobiv10x5(String pZrnyobiv10x5) {
        zrnyobiv10x5 = pZrnyobiv10x5;
    }

    private String zrnkwsratekijyunymd6maewa;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYMD6MAEWA)
    public String getZrnkwsratekijyunymd6maewa() {
        return zrnkwsratekijyunymd6maewa;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunymd6maewa(String pZrnkwsratekijyunymd6maewa) {
        zrnkwsratekijyunymd6maewa = pZrnkwsratekijyunymd6maewa;
    }

    private String zrnkwsrateusdjpy6mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEUSDJPY6MAE)
    public String getZrnkwsrateusdjpy6mae() {
        return zrnkwsrateusdjpy6mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateusdjpy6mae(String pZrnkwsrateusdjpy6mae) {
        zrnkwsrateusdjpy6mae = pZrnkwsrateusdjpy6mae;
    }

    private String zrnkwsrateaudjpy6mae;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEAUDJPY6MAE)
    public String getZrnkwsrateaudjpy6mae() {
        return zrnkwsrateaudjpy6mae;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkwsrateaudjpy6mae(String pZrnkwsrateaudjpy6mae) {
        zrnkwsrateaudjpy6mae = pZrnkwsrateaudjpy6mae;
    }

    private String zrnyobiv10x6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOBIV10X6)
    public String getZrnyobiv10x6() {
        return zrnyobiv10x6;
    }

    public void setZrnyobiv10x6(String pZrnyobiv10x6) {
        zrnyobiv10x6 = pZrnyobiv10x6;
    }

    private String zrnkwsratemsgcd;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEMSGCD)
    public String getZrnkwsratemsgcd() {
        return zrnkwsratemsgcd;
    }

    public void setZrnkwsratemsgcd(String pZrnkwsratemsgcd) {
        zrnkwsratemsgcd = pZrnkwsratemsgcd;
    }

    private String zrnyobiv23;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOBIV23)
    public String getZrnyobiv23() {
        return zrnyobiv23;
    }

    public void setZrnyobiv23(String pZrnyobiv23) {
        zrnyobiv23 = pZrnyobiv23;
    }

    private String zrnosirasemsgcd1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNOSIRASEMSGCD1)
    public String getZrnosirasemsgcd1() {
        return zrnosirasemsgcd1;
    }

    public void setZrnosirasemsgcd1(String pZrnosirasemsgcd1) {
        zrnosirasemsgcd1 = pZrnosirasemsgcd1;
    }

    private String zrnosirasemsgcd2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNOSIRASEMSGCD2)
    public String getZrnosirasemsgcd2() {
        return zrnosirasemsgcd2;
    }

    public void setZrnosirasemsgcd2(String pZrnosirasemsgcd2) {
        zrnosirasemsgcd2 = pZrnosirasemsgcd2;
    }

    private String zrnosirasemsgcd3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNOSIRASEMSGCD3)
    public String getZrnosirasemsgcd3() {
        return zrnosirasemsgcd3;
    }

    public void setZrnosirasemsgcd3(String pZrnosirasemsgcd3) {
        zrnosirasemsgcd3 = pZrnosirasemsgcd3;
    }

    private String zrnosirasemsgcd4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNOSIRASEMSGCD4)
    public String getZrnosirasemsgcd4() {
        return zrnosirasemsgcd4;
    }

    public void setZrnosirasemsgcd4(String pZrnosirasemsgcd4) {
        zrnosirasemsgcd4 = pZrnosirasemsgcd4;
    }

    private String zrnosirasemsgcd5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNOSIRASEMSGCD5)
    public String getZrnosirasemsgcd5() {
        return zrnosirasemsgcd5;
    }

    public void setZrnosirasemsgcd5(String pZrnosirasemsgcd5) {
        zrnosirasemsgcd5 = pZrnosirasemsgcd5;
    }

    private String zrnyobiv15;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOBIV15)
    public String getZrnyobiv15() {
        return zrnyobiv15;
    }

    public void setZrnyobiv15(String pZrnyobiv15) {
        zrnyobiv15 = pZrnyobiv15;
    }

    private String zrnsetteibairitustr;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSETTEIBAIRITUSTR)
    public String getZrnsetteibairitustr() {
        return zrnsetteibairitustr;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsetteibairitustr(String pZrnsetteibairitustr) {
        zrnsetteibairitustr = pZrnsetteibairitustr;
    }

    private String zrntmttknzkrtjygnstr;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZKRTJYGNSTR)
    public String getZrntmttknzkrtjygnstr() {
        return zrntmttknzkrtjygnstr;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrntmttknzkrtjygnstr(String pZrntmttknzkrtjygnstr) {
        zrntmttknzkrtjygnstr = pZrntmttknzkrtjygnstr;
    }

    private String zrntmttknzkrtkgnstr;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZKRTKGNSTR)
    public String getZrntmttknzkrtkgnstr() {
        return zrntmttknzkrtkgnstr;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrntmttknzkrtkgnstr(String pZrntmttknzkrtkgnstr) {
        zrntmttknzkrtkgnstr = pZrntmttknzkrtkgnstr;
    }

    private String zrntumitateriritustr;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTUMITATERIRITUSTR)
    public String getZrntumitateriritustr() {
        return zrntumitateriritustr;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntumitateriritustr(String pZrntumitateriritustr) {
        zrntumitateriritustr = pZrntumitateriritustr;
    }

    private String zrnsisuunm;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUNM)
    public String getZrnsisuunm() {
        return zrnsisuunm;
    }

    @DataConvert("toMultiByte")
    public void setZrnsisuunm(String pZrnsisuunm) {
        zrnsisuunm = pZrnsisuunm;
    }

    private String zrntmttknsuiirirekikbnx1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX1)
    public String getZrntmttknsuiirirekikbnx1() {
        return zrntmttknsuiirirekikbnx1;
    }

    public void setZrntmttknsuiirirekikbnx1(String pZrntmttknsuiirirekikbnx1) {
        zrntmttknsuiirirekikbnx1 = pZrntmttknsuiirirekikbnx1;
    }

    private String zrnkeiyakuoutoubix1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX1)
    public String getZrnkeiyakuoutoubix1() {
        return zrnkeiyakuoutoubix1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix1(String pZrnkeiyakuoutoubix1) {
        zrnkeiyakuoutoubix1 = pZrnkeiyakuoutoubix1;
    }

    private String zrntmttknjyoutaix1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX1)
    public String getZrntmttknjyoutaix1() {
        return zrntmttknjyoutaix1;
    }

    public void setZrntmttknjyoutaix1(String pZrntmttknjyoutaix1) {
        zrntmttknjyoutaix1 = pZrntmttknjyoutaix1;
    }

    private String zrnptumitatekngkktuukax1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX1)
    public String getZrnptumitatekngkktuukax1() {
        return zrnptumitatekngkktuukax1;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax1(String pZrnptumitatekngkktuukax1) {
        zrnptumitatekngkktuukax1 = pZrnptumitatekngkktuukax1;
    }

    private String zrnptumitatekngkyenx1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX1)
    public String getZrnptumitatekngkyenx1() {
        return zrnptumitatekngkyenx1;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx1(String pZrnptumitatekngkyenx1) {
        zrnptumitatekngkyenx1 = pZrnptumitatekngkyenx1;
    }

    private String zrnsisuux1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX1)
    public String getZrnsisuux1() {
        return zrnsisuux1;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux1(String pZrnsisuux1) {
        zrnsisuux1 = pZrnsisuux1;
    }

    private String zrnsisuuuprituhugoux1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX1)
    public String getZrnsisuuuprituhugoux1() {
        return zrnsisuuuprituhugoux1;
    }

    public void setZrnsisuuuprituhugoux1(String pZrnsisuuuprituhugoux1) {
        zrnsisuuuprituhugoux1 = pZrnsisuuuprituhugoux1;
    }

    private String zrnsisuuupritux1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX1)
    public String getZrnsisuuupritux1() {
        return zrnsisuuupritux1;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux1(String pZrnsisuuupritux1) {
        zrnsisuuupritux1 = pZrnsisuuupritux1;
    }

    private String zrntmttknzoukaritustrx1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX1)
    public String getZrntmttknzoukaritustrx1() {
        return zrntmttknzoukaritustrx1;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx1(String pZrntmttknzoukaritustrx1) {
        zrntmttknzoukaritustrx1 = pZrntmttknzoukaritustrx1;
    }

    private String zrnkawaseratex1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX1)
    public String getZrnkawaseratex1() {
        return zrnkawaseratex1;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex1(String pZrnkawaseratex1) {
        zrnkawaseratex1 = pZrnkawaseratex1;
    }

    private String zrntmttknsuiirirekikbnx2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX2)
    public String getZrntmttknsuiirirekikbnx2() {
        return zrntmttknsuiirirekikbnx2;
    }

    public void setZrntmttknsuiirirekikbnx2(String pZrntmttknsuiirirekikbnx2) {
        zrntmttknsuiirirekikbnx2 = pZrntmttknsuiirirekikbnx2;
    }

    private String zrnkeiyakuoutoubix2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX2)
    public String getZrnkeiyakuoutoubix2() {
        return zrnkeiyakuoutoubix2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix2(String pZrnkeiyakuoutoubix2) {
        zrnkeiyakuoutoubix2 = pZrnkeiyakuoutoubix2;
    }

    private String zrntmttknjyoutaix2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX2)
    public String getZrntmttknjyoutaix2() {
        return zrntmttknjyoutaix2;
    }

    public void setZrntmttknjyoutaix2(String pZrntmttknjyoutaix2) {
        zrntmttknjyoutaix2 = pZrntmttknjyoutaix2;
    }

    private String zrnptumitatekngkktuukax2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX2)
    public String getZrnptumitatekngkktuukax2() {
        return zrnptumitatekngkktuukax2;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax2(String pZrnptumitatekngkktuukax2) {
        zrnptumitatekngkktuukax2 = pZrnptumitatekngkktuukax2;
    }

    private String zrnptumitatekngkyenx2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX2)
    public String getZrnptumitatekngkyenx2() {
        return zrnptumitatekngkyenx2;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx2(String pZrnptumitatekngkyenx2) {
        zrnptumitatekngkyenx2 = pZrnptumitatekngkyenx2;
    }

    private String zrnsisuux2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX2)
    public String getZrnsisuux2() {
        return zrnsisuux2;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux2(String pZrnsisuux2) {
        zrnsisuux2 = pZrnsisuux2;
    }

    private String zrnsisuuuprituhugoux2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX2)
    public String getZrnsisuuuprituhugoux2() {
        return zrnsisuuuprituhugoux2;
    }

    public void setZrnsisuuuprituhugoux2(String pZrnsisuuuprituhugoux2) {
        zrnsisuuuprituhugoux2 = pZrnsisuuuprituhugoux2;
    }

    private String zrnsisuuupritux2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX2)
    public String getZrnsisuuupritux2() {
        return zrnsisuuupritux2;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux2(String pZrnsisuuupritux2) {
        zrnsisuuupritux2 = pZrnsisuuupritux2;
    }

    private String zrntmttknzoukaritustrx2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX2)
    public String getZrntmttknzoukaritustrx2() {
        return zrntmttknzoukaritustrx2;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx2(String pZrntmttknzoukaritustrx2) {
        zrntmttknzoukaritustrx2 = pZrntmttknzoukaritustrx2;
    }

    private String zrnkawaseratex2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX2)
    public String getZrnkawaseratex2() {
        return zrnkawaseratex2;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex2(String pZrnkawaseratex2) {
        zrnkawaseratex2 = pZrnkawaseratex2;
    }

    private String zrntmttknsuiirirekikbnx3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX3)
    public String getZrntmttknsuiirirekikbnx3() {
        return zrntmttknsuiirirekikbnx3;
    }

    public void setZrntmttknsuiirirekikbnx3(String pZrntmttknsuiirirekikbnx3) {
        zrntmttknsuiirirekikbnx3 = pZrntmttknsuiirirekikbnx3;
    }

    private String zrnkeiyakuoutoubix3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX3)
    public String getZrnkeiyakuoutoubix3() {
        return zrnkeiyakuoutoubix3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix3(String pZrnkeiyakuoutoubix3) {
        zrnkeiyakuoutoubix3 = pZrnkeiyakuoutoubix3;
    }

    private String zrntmttknjyoutaix3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX3)
    public String getZrntmttknjyoutaix3() {
        return zrntmttknjyoutaix3;
    }

    public void setZrntmttknjyoutaix3(String pZrntmttknjyoutaix3) {
        zrntmttknjyoutaix3 = pZrntmttknjyoutaix3;
    }

    private String zrnptumitatekngkktuukax3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX3)
    public String getZrnptumitatekngkktuukax3() {
        return zrnptumitatekngkktuukax3;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax3(String pZrnptumitatekngkktuukax3) {
        zrnptumitatekngkktuukax3 = pZrnptumitatekngkktuukax3;
    }

    private String zrnptumitatekngkyenx3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX3)
    public String getZrnptumitatekngkyenx3() {
        return zrnptumitatekngkyenx3;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx3(String pZrnptumitatekngkyenx3) {
        zrnptumitatekngkyenx3 = pZrnptumitatekngkyenx3;
    }

    private String zrnsisuux3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX3)
    public String getZrnsisuux3() {
        return zrnsisuux3;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux3(String pZrnsisuux3) {
        zrnsisuux3 = pZrnsisuux3;
    }

    private String zrnsisuuuprituhugoux3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX3)
    public String getZrnsisuuuprituhugoux3() {
        return zrnsisuuuprituhugoux3;
    }

    public void setZrnsisuuuprituhugoux3(String pZrnsisuuuprituhugoux3) {
        zrnsisuuuprituhugoux3 = pZrnsisuuuprituhugoux3;
    }

    private String zrnsisuuupritux3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX3)
    public String getZrnsisuuupritux3() {
        return zrnsisuuupritux3;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux3(String pZrnsisuuupritux3) {
        zrnsisuuupritux3 = pZrnsisuuupritux3;
    }

    private String zrntmttknzoukaritustrx3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX3)
    public String getZrntmttknzoukaritustrx3() {
        return zrntmttknzoukaritustrx3;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx3(String pZrntmttknzoukaritustrx3) {
        zrntmttknzoukaritustrx3 = pZrntmttknzoukaritustrx3;
    }

    private String zrnkawaseratex3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX3)
    public String getZrnkawaseratex3() {
        return zrnkawaseratex3;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex3(String pZrnkawaseratex3) {
        zrnkawaseratex3 = pZrnkawaseratex3;
    }

    private String zrntmttknsuiirirekikbnx4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX4)
    public String getZrntmttknsuiirirekikbnx4() {
        return zrntmttknsuiirirekikbnx4;
    }

    public void setZrntmttknsuiirirekikbnx4(String pZrntmttknsuiirirekikbnx4) {
        zrntmttknsuiirirekikbnx4 = pZrntmttknsuiirirekikbnx4;
    }

    private String zrnkeiyakuoutoubix4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX4)
    public String getZrnkeiyakuoutoubix4() {
        return zrnkeiyakuoutoubix4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix4(String pZrnkeiyakuoutoubix4) {
        zrnkeiyakuoutoubix4 = pZrnkeiyakuoutoubix4;
    }

    private String zrntmttknjyoutaix4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX4)
    public String getZrntmttknjyoutaix4() {
        return zrntmttknjyoutaix4;
    }

    public void setZrntmttknjyoutaix4(String pZrntmttknjyoutaix4) {
        zrntmttknjyoutaix4 = pZrntmttknjyoutaix4;
    }

    private String zrnptumitatekngkktuukax4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX4)
    public String getZrnptumitatekngkktuukax4() {
        return zrnptumitatekngkktuukax4;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax4(String pZrnptumitatekngkktuukax4) {
        zrnptumitatekngkktuukax4 = pZrnptumitatekngkktuukax4;
    }

    private String zrnptumitatekngkyenx4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX4)
    public String getZrnptumitatekngkyenx4() {
        return zrnptumitatekngkyenx4;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx4(String pZrnptumitatekngkyenx4) {
        zrnptumitatekngkyenx4 = pZrnptumitatekngkyenx4;
    }

    private String zrnsisuux4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX4)
    public String getZrnsisuux4() {
        return zrnsisuux4;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux4(String pZrnsisuux4) {
        zrnsisuux4 = pZrnsisuux4;
    }

    private String zrnsisuuuprituhugoux4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX4)
    public String getZrnsisuuuprituhugoux4() {
        return zrnsisuuuprituhugoux4;
    }

    public void setZrnsisuuuprituhugoux4(String pZrnsisuuuprituhugoux4) {
        zrnsisuuuprituhugoux4 = pZrnsisuuuprituhugoux4;
    }

    private String zrnsisuuupritux4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX4)
    public String getZrnsisuuupritux4() {
        return zrnsisuuupritux4;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux4(String pZrnsisuuupritux4) {
        zrnsisuuupritux4 = pZrnsisuuupritux4;
    }

    private String zrntmttknzoukaritustrx4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX4)
    public String getZrntmttknzoukaritustrx4() {
        return zrntmttknzoukaritustrx4;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx4(String pZrntmttknzoukaritustrx4) {
        zrntmttknzoukaritustrx4 = pZrntmttknzoukaritustrx4;
    }

    private String zrnkawaseratex4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX4)
    public String getZrnkawaseratex4() {
        return zrnkawaseratex4;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex4(String pZrnkawaseratex4) {
        zrnkawaseratex4 = pZrnkawaseratex4;
    }

    private String zrntmttknsuiirirekikbnx5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX5)
    public String getZrntmttknsuiirirekikbnx5() {
        return zrntmttknsuiirirekikbnx5;
    }

    public void setZrntmttknsuiirirekikbnx5(String pZrntmttknsuiirirekikbnx5) {
        zrntmttknsuiirirekikbnx5 = pZrntmttknsuiirirekikbnx5;
    }

    private String zrnkeiyakuoutoubix5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX5)
    public String getZrnkeiyakuoutoubix5() {
        return zrnkeiyakuoutoubix5;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix5(String pZrnkeiyakuoutoubix5) {
        zrnkeiyakuoutoubix5 = pZrnkeiyakuoutoubix5;
    }

    private String zrntmttknjyoutaix5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX5)
    public String getZrntmttknjyoutaix5() {
        return zrntmttknjyoutaix5;
    }

    public void setZrntmttknjyoutaix5(String pZrntmttknjyoutaix5) {
        zrntmttknjyoutaix5 = pZrntmttknjyoutaix5;
    }

    private String zrnptumitatekngkktuukax5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX5)
    public String getZrnptumitatekngkktuukax5() {
        return zrnptumitatekngkktuukax5;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax5(String pZrnptumitatekngkktuukax5) {
        zrnptumitatekngkktuukax5 = pZrnptumitatekngkktuukax5;
    }

    private String zrnptumitatekngkyenx5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX5)
    public String getZrnptumitatekngkyenx5() {
        return zrnptumitatekngkyenx5;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx5(String pZrnptumitatekngkyenx5) {
        zrnptumitatekngkyenx5 = pZrnptumitatekngkyenx5;
    }

    private String zrnsisuux5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX5)
    public String getZrnsisuux5() {
        return zrnsisuux5;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux5(String pZrnsisuux5) {
        zrnsisuux5 = pZrnsisuux5;
    }

    private String zrnsisuuuprituhugoux5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX5)
    public String getZrnsisuuuprituhugoux5() {
        return zrnsisuuuprituhugoux5;
    }

    public void setZrnsisuuuprituhugoux5(String pZrnsisuuuprituhugoux5) {
        zrnsisuuuprituhugoux5 = pZrnsisuuuprituhugoux5;
    }

    private String zrnsisuuupritux5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX5)
    public String getZrnsisuuupritux5() {
        return zrnsisuuupritux5;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux5(String pZrnsisuuupritux5) {
        zrnsisuuupritux5 = pZrnsisuuupritux5;
    }

    private String zrntmttknzoukaritustrx5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX5)
    public String getZrntmttknzoukaritustrx5() {
        return zrntmttknzoukaritustrx5;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx5(String pZrntmttknzoukaritustrx5) {
        zrntmttknzoukaritustrx5 = pZrntmttknzoukaritustrx5;
    }

    private String zrnkawaseratex5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX5)
    public String getZrnkawaseratex5() {
        return zrnkawaseratex5;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex5(String pZrnkawaseratex5) {
        zrnkawaseratex5 = pZrnkawaseratex5;
    }

    private String zrntmttknsuiirirekikbnx6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX6)
    public String getZrntmttknsuiirirekikbnx6() {
        return zrntmttknsuiirirekikbnx6;
    }

    public void setZrntmttknsuiirirekikbnx6(String pZrntmttknsuiirirekikbnx6) {
        zrntmttknsuiirirekikbnx6 = pZrntmttknsuiirirekikbnx6;
    }

    private String zrnkeiyakuoutoubix6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX6)
    public String getZrnkeiyakuoutoubix6() {
        return zrnkeiyakuoutoubix6;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix6(String pZrnkeiyakuoutoubix6) {
        zrnkeiyakuoutoubix6 = pZrnkeiyakuoutoubix6;
    }

    private String zrntmttknjyoutaix6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX6)
    public String getZrntmttknjyoutaix6() {
        return zrntmttknjyoutaix6;
    }

    public void setZrntmttknjyoutaix6(String pZrntmttknjyoutaix6) {
        zrntmttknjyoutaix6 = pZrntmttknjyoutaix6;
    }

    private String zrnptumitatekngkktuukax6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX6)
    public String getZrnptumitatekngkktuukax6() {
        return zrnptumitatekngkktuukax6;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax6(String pZrnptumitatekngkktuukax6) {
        zrnptumitatekngkktuukax6 = pZrnptumitatekngkktuukax6;
    }

    private String zrnptumitatekngkyenx6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX6)
    public String getZrnptumitatekngkyenx6() {
        return zrnptumitatekngkyenx6;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx6(String pZrnptumitatekngkyenx6) {
        zrnptumitatekngkyenx6 = pZrnptumitatekngkyenx6;
    }

    private String zrnsisuux6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX6)
    public String getZrnsisuux6() {
        return zrnsisuux6;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux6(String pZrnsisuux6) {
        zrnsisuux6 = pZrnsisuux6;
    }

    private String zrnsisuuuprituhugoux6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX6)
    public String getZrnsisuuuprituhugoux6() {
        return zrnsisuuuprituhugoux6;
    }

    public void setZrnsisuuuprituhugoux6(String pZrnsisuuuprituhugoux6) {
        zrnsisuuuprituhugoux6 = pZrnsisuuuprituhugoux6;
    }

    private String zrnsisuuupritux6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX6)
    public String getZrnsisuuupritux6() {
        return zrnsisuuupritux6;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux6(String pZrnsisuuupritux6) {
        zrnsisuuupritux6 = pZrnsisuuupritux6;
    }

    private String zrntmttknzoukaritustrx6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX6)
    public String getZrntmttknzoukaritustrx6() {
        return zrntmttknzoukaritustrx6;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx6(String pZrntmttknzoukaritustrx6) {
        zrntmttknzoukaritustrx6 = pZrntmttknzoukaritustrx6;
    }

    private String zrnkawaseratex6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX6)
    public String getZrnkawaseratex6() {
        return zrnkawaseratex6;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex6(String pZrnkawaseratex6) {
        zrnkawaseratex6 = pZrnkawaseratex6;
    }

    private String zrntmttknsuiirirekikbnx7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX7)
    public String getZrntmttknsuiirirekikbnx7() {
        return zrntmttknsuiirirekikbnx7;
    }

    public void setZrntmttknsuiirirekikbnx7(String pZrntmttknsuiirirekikbnx7) {
        zrntmttknsuiirirekikbnx7 = pZrntmttknsuiirirekikbnx7;
    }

    private String zrnkeiyakuoutoubix7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX7)
    public String getZrnkeiyakuoutoubix7() {
        return zrnkeiyakuoutoubix7;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix7(String pZrnkeiyakuoutoubix7) {
        zrnkeiyakuoutoubix7 = pZrnkeiyakuoutoubix7;
    }

    private String zrntmttknjyoutaix7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX7)
    public String getZrntmttknjyoutaix7() {
        return zrntmttknjyoutaix7;
    }

    public void setZrntmttknjyoutaix7(String pZrntmttknjyoutaix7) {
        zrntmttknjyoutaix7 = pZrntmttknjyoutaix7;
    }

    private String zrnptumitatekngkktuukax7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX7)
    public String getZrnptumitatekngkktuukax7() {
        return zrnptumitatekngkktuukax7;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax7(String pZrnptumitatekngkktuukax7) {
        zrnptumitatekngkktuukax7 = pZrnptumitatekngkktuukax7;
    }

    private String zrnptumitatekngkyenx7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX7)
    public String getZrnptumitatekngkyenx7() {
        return zrnptumitatekngkyenx7;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx7(String pZrnptumitatekngkyenx7) {
        zrnptumitatekngkyenx7 = pZrnptumitatekngkyenx7;
    }

    private String zrnsisuux7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX7)
    public String getZrnsisuux7() {
        return zrnsisuux7;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux7(String pZrnsisuux7) {
        zrnsisuux7 = pZrnsisuux7;
    }

    private String zrnsisuuuprituhugoux7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX7)
    public String getZrnsisuuuprituhugoux7() {
        return zrnsisuuuprituhugoux7;
    }

    public void setZrnsisuuuprituhugoux7(String pZrnsisuuuprituhugoux7) {
        zrnsisuuuprituhugoux7 = pZrnsisuuuprituhugoux7;
    }

    private String zrnsisuuupritux7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX7)
    public String getZrnsisuuupritux7() {
        return zrnsisuuupritux7;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux7(String pZrnsisuuupritux7) {
        zrnsisuuupritux7 = pZrnsisuuupritux7;
    }

    private String zrntmttknzoukaritustrx7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX7)
    public String getZrntmttknzoukaritustrx7() {
        return zrntmttknzoukaritustrx7;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx7(String pZrntmttknzoukaritustrx7) {
        zrntmttknzoukaritustrx7 = pZrntmttknzoukaritustrx7;
    }

    private String zrnkawaseratex7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX7)
    public String getZrnkawaseratex7() {
        return zrnkawaseratex7;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex7(String pZrnkawaseratex7) {
        zrnkawaseratex7 = pZrnkawaseratex7;
    }

    private String zrntmttknsuiirirekikbnx8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX8)
    public String getZrntmttknsuiirirekikbnx8() {
        return zrntmttknsuiirirekikbnx8;
    }

    public void setZrntmttknsuiirirekikbnx8(String pZrntmttknsuiirirekikbnx8) {
        zrntmttknsuiirirekikbnx8 = pZrntmttknsuiirirekikbnx8;
    }

    private String zrnkeiyakuoutoubix8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX8)
    public String getZrnkeiyakuoutoubix8() {
        return zrnkeiyakuoutoubix8;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix8(String pZrnkeiyakuoutoubix8) {
        zrnkeiyakuoutoubix8 = pZrnkeiyakuoutoubix8;
    }

    private String zrntmttknjyoutaix8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX8)
    public String getZrntmttknjyoutaix8() {
        return zrntmttknjyoutaix8;
    }

    public void setZrntmttknjyoutaix8(String pZrntmttknjyoutaix8) {
        zrntmttknjyoutaix8 = pZrntmttknjyoutaix8;
    }

    private String zrnptumitatekngkktuukax8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX8)
    public String getZrnptumitatekngkktuukax8() {
        return zrnptumitatekngkktuukax8;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax8(String pZrnptumitatekngkktuukax8) {
        zrnptumitatekngkktuukax8 = pZrnptumitatekngkktuukax8;
    }

    private String zrnptumitatekngkyenx8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX8)
    public String getZrnptumitatekngkyenx8() {
        return zrnptumitatekngkyenx8;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx8(String pZrnptumitatekngkyenx8) {
        zrnptumitatekngkyenx8 = pZrnptumitatekngkyenx8;
    }

    private String zrnsisuux8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX8)
    public String getZrnsisuux8() {
        return zrnsisuux8;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux8(String pZrnsisuux8) {
        zrnsisuux8 = pZrnsisuux8;
    }

    private String zrnsisuuuprituhugoux8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX8)
    public String getZrnsisuuuprituhugoux8() {
        return zrnsisuuuprituhugoux8;
    }

    public void setZrnsisuuuprituhugoux8(String pZrnsisuuuprituhugoux8) {
        zrnsisuuuprituhugoux8 = pZrnsisuuuprituhugoux8;
    }

    private String zrnsisuuupritux8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX8)
    public String getZrnsisuuupritux8() {
        return zrnsisuuupritux8;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux8(String pZrnsisuuupritux8) {
        zrnsisuuupritux8 = pZrnsisuuupritux8;
    }

    private String zrntmttknzoukaritustrx8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX8)
    public String getZrntmttknzoukaritustrx8() {
        return zrntmttknzoukaritustrx8;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx8(String pZrntmttknzoukaritustrx8) {
        zrntmttknzoukaritustrx8 = pZrntmttknzoukaritustrx8;
    }

    private String zrnkawaseratex8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX8)
    public String getZrnkawaseratex8() {
        return zrnkawaseratex8;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex8(String pZrnkawaseratex8) {
        zrnkawaseratex8 = pZrnkawaseratex8;
    }

    private String zrntmttknsuiirirekikbnx9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX9)
    public String getZrntmttknsuiirirekikbnx9() {
        return zrntmttknsuiirirekikbnx9;
    }

    public void setZrntmttknsuiirirekikbnx9(String pZrntmttknsuiirirekikbnx9) {
        zrntmttknsuiirirekikbnx9 = pZrntmttknsuiirirekikbnx9;
    }

    private String zrnkeiyakuoutoubix9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX9)
    public String getZrnkeiyakuoutoubix9() {
        return zrnkeiyakuoutoubix9;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix9(String pZrnkeiyakuoutoubix9) {
        zrnkeiyakuoutoubix9 = pZrnkeiyakuoutoubix9;
    }

    private String zrntmttknjyoutaix9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX9)
    public String getZrntmttknjyoutaix9() {
        return zrntmttknjyoutaix9;
    }

    public void setZrntmttknjyoutaix9(String pZrntmttknjyoutaix9) {
        zrntmttknjyoutaix9 = pZrntmttknjyoutaix9;
    }

    private String zrnptumitatekngkktuukax9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX9)
    public String getZrnptumitatekngkktuukax9() {
        return zrnptumitatekngkktuukax9;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax9(String pZrnptumitatekngkktuukax9) {
        zrnptumitatekngkktuukax9 = pZrnptumitatekngkktuukax9;
    }

    private String zrnptumitatekngkyenx9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX9)
    public String getZrnptumitatekngkyenx9() {
        return zrnptumitatekngkyenx9;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx9(String pZrnptumitatekngkyenx9) {
        zrnptumitatekngkyenx9 = pZrnptumitatekngkyenx9;
    }

    private String zrnsisuux9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX9)
    public String getZrnsisuux9() {
        return zrnsisuux9;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux9(String pZrnsisuux9) {
        zrnsisuux9 = pZrnsisuux9;
    }

    private String zrnsisuuuprituhugoux9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX9)
    public String getZrnsisuuuprituhugoux9() {
        return zrnsisuuuprituhugoux9;
    }

    public void setZrnsisuuuprituhugoux9(String pZrnsisuuuprituhugoux9) {
        zrnsisuuuprituhugoux9 = pZrnsisuuuprituhugoux9;
    }

    private String zrnsisuuupritux9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX9)
    public String getZrnsisuuupritux9() {
        return zrnsisuuupritux9;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux9(String pZrnsisuuupritux9) {
        zrnsisuuupritux9 = pZrnsisuuupritux9;
    }

    private String zrntmttknzoukaritustrx9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX9)
    public String getZrntmttknzoukaritustrx9() {
        return zrntmttknzoukaritustrx9;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx9(String pZrntmttknzoukaritustrx9) {
        zrntmttknzoukaritustrx9 = pZrntmttknzoukaritustrx9;
    }

    private String zrnkawaseratex9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX9)
    public String getZrnkawaseratex9() {
        return zrnkawaseratex9;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex9(String pZrnkawaseratex9) {
        zrnkawaseratex9 = pZrnkawaseratex9;
    }

    private String zrntmttknsuiirirekikbnx10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX10)
    public String getZrntmttknsuiirirekikbnx10() {
        return zrntmttknsuiirirekikbnx10;
    }

    public void setZrntmttknsuiirirekikbnx10(String pZrntmttknsuiirirekikbnx10) {
        zrntmttknsuiirirekikbnx10 = pZrntmttknsuiirirekikbnx10;
    }

    private String zrnkeiyakuoutoubix10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX10)
    public String getZrnkeiyakuoutoubix10() {
        return zrnkeiyakuoutoubix10;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix10(String pZrnkeiyakuoutoubix10) {
        zrnkeiyakuoutoubix10 = pZrnkeiyakuoutoubix10;
    }

    private String zrntmttknjyoutaix10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX10)
    public String getZrntmttknjyoutaix10() {
        return zrntmttknjyoutaix10;
    }

    public void setZrntmttknjyoutaix10(String pZrntmttknjyoutaix10) {
        zrntmttknjyoutaix10 = pZrntmttknjyoutaix10;
    }

    private String zrnptumitatekngkktuukax10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX10)
    public String getZrnptumitatekngkktuukax10() {
        return zrnptumitatekngkktuukax10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax10(String pZrnptumitatekngkktuukax10) {
        zrnptumitatekngkktuukax10 = pZrnptumitatekngkktuukax10;
    }

    private String zrnptumitatekngkyenx10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX10)
    public String getZrnptumitatekngkyenx10() {
        return zrnptumitatekngkyenx10;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx10(String pZrnptumitatekngkyenx10) {
        zrnptumitatekngkyenx10 = pZrnptumitatekngkyenx10;
    }

    private String zrnsisuux10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX10)
    public String getZrnsisuux10() {
        return zrnsisuux10;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux10(String pZrnsisuux10) {
        zrnsisuux10 = pZrnsisuux10;
    }

    private String zrnsisuuuprituhugoux10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX10)
    public String getZrnsisuuuprituhugoux10() {
        return zrnsisuuuprituhugoux10;
    }

    public void setZrnsisuuuprituhugoux10(String pZrnsisuuuprituhugoux10) {
        zrnsisuuuprituhugoux10 = pZrnsisuuuprituhugoux10;
    }

    private String zrnsisuuupritux10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX10)
    public String getZrnsisuuupritux10() {
        return zrnsisuuupritux10;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux10(String pZrnsisuuupritux10) {
        zrnsisuuupritux10 = pZrnsisuuupritux10;
    }

    private String zrntmttknzoukaritustrx10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX10)
    public String getZrntmttknzoukaritustrx10() {
        return zrntmttknzoukaritustrx10;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx10(String pZrntmttknzoukaritustrx10) {
        zrntmttknzoukaritustrx10 = pZrntmttknzoukaritustrx10;
    }

    private String zrnkawaseratex10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX10)
    public String getZrnkawaseratex10() {
        return zrnkawaseratex10;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex10(String pZrnkawaseratex10) {
        zrnkawaseratex10 = pZrnkawaseratex10;
    }

    private String zrntmttknsuiirirekikbnx11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIRIREKIKBNX11)
    public String getZrntmttknsuiirirekikbnx11() {
        return zrntmttknsuiirirekikbnx11;
    }

    public void setZrntmttknsuiirirekikbnx11(String pZrntmttknsuiirirekikbnx11) {
        zrntmttknsuiirirekikbnx11 = pZrntmttknsuiirirekikbnx11;
    }

    private String zrnkeiyakuoutoubix11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKEIYAKUOUTOUBIX11)
    public String getZrnkeiyakuoutoubix11() {
        return zrnkeiyakuoutoubix11;
    }

    @DataConvert("toMultiByte")
    public void setZrnkeiyakuoutoubix11(String pZrnkeiyakuoutoubix11) {
        zrnkeiyakuoutoubix11 = pZrnkeiyakuoutoubix11;
    }

    private String zrntmttknjyoutaix11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNJYOUTAIX11)
    public String getZrntmttknjyoutaix11() {
        return zrntmttknjyoutaix11;
    }

    public void setZrntmttknjyoutaix11(String pZrntmttknjyoutaix11) {
        zrntmttknjyoutaix11 = pZrntmttknjyoutaix11;
    }

    private String zrnptumitatekngkktuukax11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKKTUUKAX11)
    public String getZrnptumitatekngkktuukax11() {
        return zrnptumitatekngkktuukax11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnptumitatekngkktuukax11(String pZrnptumitatekngkktuukax11) {
        zrnptumitatekngkktuukax11 = pZrnptumitatekngkktuukax11;
    }

    private String zrnptumitatekngkyenx11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPTUMITATEKNGKYENX11)
    public String getZrnptumitatekngkyenx11() {
        return zrnptumitatekngkyenx11;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnptumitatekngkyenx11(String pZrnptumitatekngkyenx11) {
        zrnptumitatekngkyenx11 = pZrnptumitatekngkyenx11;
    }

    private String zrnsisuux11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUX11)
    public String getZrnsisuux11() {
        return zrnsisuux11;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsisuux11(String pZrnsisuux11) {
        zrnsisuux11 = pZrnsisuux11;
    }

    private String zrnsisuuuprituhugoux11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUHUGOUX11)
    public String getZrnsisuuuprituhugoux11() {
        return zrnsisuuuprituhugoux11;
    }

    public void setZrnsisuuuprituhugoux11(String pZrnsisuuuprituhugoux11) {
        zrnsisuuuprituhugoux11 = pZrnsisuuuprituhugoux11;
    }

    private String zrnsisuuupritux11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSISUUUPRITUX11)
    public String getZrnsisuuupritux11() {
        return zrnsisuuupritux11;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnsisuuupritux11(String pZrnsisuuupritux11) {
        zrnsisuuupritux11 = pZrnsisuuupritux11;
    }

    private String zrntmttknzoukaritustrx11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNZOUKARITUSTRX11)
    public String getZrntmttknzoukaritustrx11() {
        return zrntmttknzoukaritustrx11;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrntmttknzoukaritustrx11(String pZrntmttknzoukaritustrx11) {
        zrntmttknzoukaritustrx11 = pZrntmttknzoukaritustrx11;
    }

    private String zrnkawaseratex11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAWASERATEX11)
    public String getZrnkawaseratex11() {
        return zrnkawaseratex11;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkawaseratex11(String pZrnkawaseratex11) {
        zrnkawaseratex11 = pZrnkawaseratex11;
    }

    private String zrntmttknsuiiyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTMTTKNSUIIYOBI)
    public String getZrntmttknsuiiyobi() {
        return zrntmttknsuiiyobi;
    }

    public void setZrntmttknsuiiyobi(String pZrntmttknsuiiyobi) {
        zrntmttknsuiiyobi = pZrntmttknsuiiyobi;
    }

    private String zrnttdkkigen;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTTDKKIGEN)
    public String getZrnttdkkigen() {
        return zrnttdkkigen;
    }

    @DataConvert("toMultiByte")
    public void setZrnttdkkigen(String pZrnttdkkigen) {
        zrnttdkkigen = pZrnttdkkigen;
    }

    private String zrnkrnkgnsgk;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKRNKGNSGK)
    public String getZrnkrnkgnsgk() {
        return zrnkrnkgnsgk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkrnkgnsgk(String pZrnkrnkgnsgk) {
        zrnkrnkgnsgk = pZrnkrnkgnsgk;
    }

    private String zrntirtitnttdkyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTIRTITNTTDKYOBI)
    public String getZrntirtitnttdkyobi() {
        return zrntirtitnttdkyobi;
    }

    public void setZrntirtitnttdkyobi(String pZrntirtitnttdkyobi) {
        zrntirtitnttdkyobi = pZrntirtitnttdkyobi;
    }

    private String zrnskshozonnensuu;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNSKSHOZONNENSUU)
    public String getZrnskshozonnensuu() {
        return zrnskshozonnensuu;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnskshozonnensuu(String pZrnskshozonnensuu) {
        zrnskshozonnensuu = pZrnskshozonnensuu;
    }

    private String zrndocumentid;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNDOCUMENTID)
    public String getZrndocumentid() {
        return zrndocumentid;
    }

    public void setZrndocumentid(String pZrndocumentid) {
        zrndocumentid = pZrndocumentid;
    }

    private String zrntoritugisyasyozokunm;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNTORITUGISYASYOZOKUNM)
    public String getZrntoritugisyasyozokunm() {
        return zrntoritugisyasyozokunm;
    }

    @DataConvert("toMultiByte")
    public void setZrntoritugisyasyozokunm(String pZrntoritugisyasyozokunm) {
        zrntoritugisyasyozokunm = pZrntoritugisyasyozokunm;
    }

    private String zrnyendthnkhrsksyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYENDTHNKHRSKSYOBI)
    public String getZrnyendthnkhrsksyobi() {
        return zrnyendthnkhrsksyobi;
    }

    public void setZrnyendthnkhrsksyobi(String pZrnyendthnkhrsksyobi) {
        zrnyendthnkhrsksyobi = pZrnyendthnkhrsksyobi;
    }

    private String zrnyoteiriritukijyunym1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM1)
    public String getZrnyoteiriritukijyunym1() {
        return zrnyoteiriritukijyunym1;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym1(String pZrnyoteiriritukijyunym1) {
        zrnyoteiriritukijyunym1 = pZrnyoteiriritukijyunym1;
    }

    private String zrnyoteiriritu1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU1)
    public String getZrnyoteiriritu1() {
        return zrnyoteiriritu1;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu1(String pZrnyoteiriritu1) {
        zrnyoteiriritu1 = pZrnyoteiriritu1;
    }

    private String zrnytirrtcalckijyunrrt1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT1)
    public String getZrnytirrtcalckijyunrrt1() {
        return zrnytirrtcalckijyunrrt1;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt1(String pZrnytirrtcalckijyunrrt1) {
        zrnytirrtcalckijyunrrt1 = pZrnytirrtcalckijyunrrt1;
    }

    private String zrnkwsratekijyunym1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM1)
    public String getZrnkwsratekijyunym1() {
        return zrnkwsratekijyunym1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym1(String pZrnkwsratekijyunym1) {
        zrnkwsratekijyunym1 = pZrnkwsratekijyunym1;
    }

    private String zrnkaknsnkwsrate1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE1)
    public String getZrnkaknsnkwsrate1() {
        return zrnkaknsnkwsrate1;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate1(String pZrnkaknsnkwsrate1) {
        zrnkaknsnkwsrate1 = pZrnkaknsnkwsrate1;
    }

    private String zrnpgaika1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA1)
    public String getZrnpgaika1() {
        return zrnpgaika1;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika1(String pZrnpgaika1) {
        zrnpgaika1 = pZrnpgaika1;
    }

    private String zrnpyen1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN1)
    public String getZrnpyen1() {
        return zrnpyen1;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen1(String pZrnpyen1) {
        zrnpyen1 = pZrnpyen1;
    }

    private String zrnyoteiriritukijyunym2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM2)
    public String getZrnyoteiriritukijyunym2() {
        return zrnyoteiriritukijyunym2;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym2(String pZrnyoteiriritukijyunym2) {
        zrnyoteiriritukijyunym2 = pZrnyoteiriritukijyunym2;
    }

    private String zrnyoteiriritu2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU2)
    public String getZrnyoteiriritu2() {
        return zrnyoteiriritu2;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu2(String pZrnyoteiriritu2) {
        zrnyoteiriritu2 = pZrnyoteiriritu2;
    }

    private String zrnytirrtcalckijyunrrt2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT2)
    public String getZrnytirrtcalckijyunrrt2() {
        return zrnytirrtcalckijyunrrt2;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt2(String pZrnytirrtcalckijyunrrt2) {
        zrnytirrtcalckijyunrrt2 = pZrnytirrtcalckijyunrrt2;
    }

    private String zrnkwsratekijyunym2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM2)
    public String getZrnkwsratekijyunym2() {
        return zrnkwsratekijyunym2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym2(String pZrnkwsratekijyunym2) {
        zrnkwsratekijyunym2 = pZrnkwsratekijyunym2;
    }

    private String zrnkaknsnkwsrate2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE2)
    public String getZrnkaknsnkwsrate2() {
        return zrnkaknsnkwsrate2;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate2(String pZrnkaknsnkwsrate2) {
        zrnkaknsnkwsrate2 = pZrnkaknsnkwsrate2;
    }

    private String zrnpgaika2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA2)
    public String getZrnpgaika2() {
        return zrnpgaika2;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika2(String pZrnpgaika2) {
        zrnpgaika2 = pZrnpgaika2;
    }

    private String zrnpyen2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN2)
    public String getZrnpyen2() {
        return zrnpyen2;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen2(String pZrnpyen2) {
        zrnpyen2 = pZrnpyen2;
    }

    private String zrnyoteiriritukijyunym3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM3)
    public String getZrnyoteiriritukijyunym3() {
        return zrnyoteiriritukijyunym3;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym3(String pZrnyoteiriritukijyunym3) {
        zrnyoteiriritukijyunym3 = pZrnyoteiriritukijyunym3;
    }

    private String zrnyoteiriritu3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU3)
    public String getZrnyoteiriritu3() {
        return zrnyoteiriritu3;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu3(String pZrnyoteiriritu3) {
        zrnyoteiriritu3 = pZrnyoteiriritu3;
    }

    private String zrnytirrtcalckijyunrrt3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT3)
    public String getZrnytirrtcalckijyunrrt3() {
        return zrnytirrtcalckijyunrrt3;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt3(String pZrnytirrtcalckijyunrrt3) {
        zrnytirrtcalckijyunrrt3 = pZrnytirrtcalckijyunrrt3;
    }

    private String zrnkwsratekijyunym3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM3)
    public String getZrnkwsratekijyunym3() {
        return zrnkwsratekijyunym3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym3(String pZrnkwsratekijyunym3) {
        zrnkwsratekijyunym3 = pZrnkwsratekijyunym3;
    }

    private String zrnkaknsnkwsrate3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE3)
    public String getZrnkaknsnkwsrate3() {
        return zrnkaknsnkwsrate3;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate3(String pZrnkaknsnkwsrate3) {
        zrnkaknsnkwsrate3 = pZrnkaknsnkwsrate3;
    }

    private String zrnpgaika3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA3)
    public String getZrnpgaika3() {
        return zrnpgaika3;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika3(String pZrnpgaika3) {
        zrnpgaika3 = pZrnpgaika3;
    }

    private String zrnpyen3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN3)
    public String getZrnpyen3() {
        return zrnpyen3;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen3(String pZrnpyen3) {
        zrnpyen3 = pZrnpyen3;
    }

    private String zrnyoteiriritukijyunym4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM4)
    public String getZrnyoteiriritukijyunym4() {
        return zrnyoteiriritukijyunym4;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym4(String pZrnyoteiriritukijyunym4) {
        zrnyoteiriritukijyunym4 = pZrnyoteiriritukijyunym4;
    }

    private String zrnyoteiriritu4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU4)
    public String getZrnyoteiriritu4() {
        return zrnyoteiriritu4;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu4(String pZrnyoteiriritu4) {
        zrnyoteiriritu4 = pZrnyoteiriritu4;
    }

    private String zrnytirrtcalckijyunrrt4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT4)
    public String getZrnytirrtcalckijyunrrt4() {
        return zrnytirrtcalckijyunrrt4;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt4(String pZrnytirrtcalckijyunrrt4) {
        zrnytirrtcalckijyunrrt4 = pZrnytirrtcalckijyunrrt4;
    }

    private String zrnkwsratekijyunym4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM4)
    public String getZrnkwsratekijyunym4() {
        return zrnkwsratekijyunym4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym4(String pZrnkwsratekijyunym4) {
        zrnkwsratekijyunym4 = pZrnkwsratekijyunym4;
    }

    private String zrnkaknsnkwsrate4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE4)
    public String getZrnkaknsnkwsrate4() {
        return zrnkaknsnkwsrate4;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate4(String pZrnkaknsnkwsrate4) {
        zrnkaknsnkwsrate4 = pZrnkaknsnkwsrate4;
    }

    private String zrnpgaika4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA4)
    public String getZrnpgaika4() {
        return zrnpgaika4;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika4(String pZrnpgaika4) {
        zrnpgaika4 = pZrnpgaika4;
    }

    private String zrnpyen4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN4)
    public String getZrnpyen4() {
        return zrnpyen4;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen4(String pZrnpyen4) {
        zrnpyen4 = pZrnpyen4;
    }

    private String zrnyoteiriritukijyunym5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM5)
    public String getZrnyoteiriritukijyunym5() {
        return zrnyoteiriritukijyunym5;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym5(String pZrnyoteiriritukijyunym5) {
        zrnyoteiriritukijyunym5 = pZrnyoteiriritukijyunym5;
    }

    private String zrnyoteiriritu5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU5)
    public String getZrnyoteiriritu5() {
        return zrnyoteiriritu5;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu5(String pZrnyoteiriritu5) {
        zrnyoteiriritu5 = pZrnyoteiriritu5;
    }

    private String zrnytirrtcalckijyunrrt5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT5)
    public String getZrnytirrtcalckijyunrrt5() {
        return zrnytirrtcalckijyunrrt5;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt5(String pZrnytirrtcalckijyunrrt5) {
        zrnytirrtcalckijyunrrt5 = pZrnytirrtcalckijyunrrt5;
    }

    private String zrnkwsratekijyunym5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM5)
    public String getZrnkwsratekijyunym5() {
        return zrnkwsratekijyunym5;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym5(String pZrnkwsratekijyunym5) {
        zrnkwsratekijyunym5 = pZrnkwsratekijyunym5;
    }

    private String zrnkaknsnkwsrate5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE5)
    public String getZrnkaknsnkwsrate5() {
        return zrnkaknsnkwsrate5;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate5(String pZrnkaknsnkwsrate5) {
        zrnkaknsnkwsrate5 = pZrnkaknsnkwsrate5;
    }

    private String zrnpgaika5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA5)
    public String getZrnpgaika5() {
        return zrnpgaika5;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika5(String pZrnpgaika5) {
        zrnpgaika5 = pZrnpgaika5;
    }

    private String zrnpyen5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN5)
    public String getZrnpyen5() {
        return zrnpyen5;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen5(String pZrnpyen5) {
        zrnpyen5 = pZrnpyen5;
    }

    private String zrnyoteiriritukijyunym6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM6)
    public String getZrnyoteiriritukijyunym6() {
        return zrnyoteiriritukijyunym6;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym6(String pZrnyoteiriritukijyunym6) {
        zrnyoteiriritukijyunym6 = pZrnyoteiriritukijyunym6;
    }

    private String zrnyoteiriritu6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU6)
    public String getZrnyoteiriritu6() {
        return zrnyoteiriritu6;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu6(String pZrnyoteiriritu6) {
        zrnyoteiriritu6 = pZrnyoteiriritu6;
    }

    private String zrnytirrtcalckijyunrrt6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT6)
    public String getZrnytirrtcalckijyunrrt6() {
        return zrnytirrtcalckijyunrrt6;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt6(String pZrnytirrtcalckijyunrrt6) {
        zrnytirrtcalckijyunrrt6 = pZrnytirrtcalckijyunrrt6;
    }

    private String zrnkwsratekijyunym6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM6)
    public String getZrnkwsratekijyunym6() {
        return zrnkwsratekijyunym6;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym6(String pZrnkwsratekijyunym6) {
        zrnkwsratekijyunym6 = pZrnkwsratekijyunym6;
    }

    private String zrnkaknsnkwsrate6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE6)
    public String getZrnkaknsnkwsrate6() {
        return zrnkaknsnkwsrate6;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate6(String pZrnkaknsnkwsrate6) {
        zrnkaknsnkwsrate6 = pZrnkaknsnkwsrate6;
    }

    private String zrnpgaika6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA6)
    public String getZrnpgaika6() {
        return zrnpgaika6;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika6(String pZrnpgaika6) {
        zrnpgaika6 = pZrnpgaika6;
    }

    private String zrnpyen6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN6)
    public String getZrnpyen6() {
        return zrnpyen6;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen6(String pZrnpyen6) {
        zrnpyen6 = pZrnpyen6;
    }

    private String zrnyoteiriritukijyunym7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM7)
    public String getZrnyoteiriritukijyunym7() {
        return zrnyoteiriritukijyunym7;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym7(String pZrnyoteiriritukijyunym7) {
        zrnyoteiriritukijyunym7 = pZrnyoteiriritukijyunym7;
    }

    private String zrnyoteiriritu7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU7)
    public String getZrnyoteiriritu7() {
        return zrnyoteiriritu7;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu7(String pZrnyoteiriritu7) {
        zrnyoteiriritu7 = pZrnyoteiriritu7;
    }

    private String zrnytirrtcalckijyunrrt7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT7)
    public String getZrnytirrtcalckijyunrrt7() {
        return zrnytirrtcalckijyunrrt7;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt7(String pZrnytirrtcalckijyunrrt7) {
        zrnytirrtcalckijyunrrt7 = pZrnytirrtcalckijyunrrt7;
    }

    private String zrnkwsratekijyunym7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM7)
    public String getZrnkwsratekijyunym7() {
        return zrnkwsratekijyunym7;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym7(String pZrnkwsratekijyunym7) {
        zrnkwsratekijyunym7 = pZrnkwsratekijyunym7;
    }

    private String zrnkaknsnkwsrate7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE7)
    public String getZrnkaknsnkwsrate7() {
        return zrnkaknsnkwsrate7;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate7(String pZrnkaknsnkwsrate7) {
        zrnkaknsnkwsrate7 = pZrnkaknsnkwsrate7;
    }

    private String zrnpgaika7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA7)
    public String getZrnpgaika7() {
        return zrnpgaika7;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika7(String pZrnpgaika7) {
        zrnpgaika7 = pZrnpgaika7;
    }

    private String zrnpyen7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN7)
    public String getZrnpyen7() {
        return zrnpyen7;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen7(String pZrnpyen7) {
        zrnpyen7 = pZrnpyen7;
    }

    private String zrnyoteiriritukijyunym8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM8)
    public String getZrnyoteiriritukijyunym8() {
        return zrnyoteiriritukijyunym8;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym8(String pZrnyoteiriritukijyunym8) {
        zrnyoteiriritukijyunym8 = pZrnyoteiriritukijyunym8;
    }

    private String zrnyoteiriritu8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU8)
    public String getZrnyoteiriritu8() {
        return zrnyoteiriritu8;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu8(String pZrnyoteiriritu8) {
        zrnyoteiriritu8 = pZrnyoteiriritu8;
    }

    private String zrnytirrtcalckijyunrrt8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT8)
    public String getZrnytirrtcalckijyunrrt8() {
        return zrnytirrtcalckijyunrrt8;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt8(String pZrnytirrtcalckijyunrrt8) {
        zrnytirrtcalckijyunrrt8 = pZrnytirrtcalckijyunrrt8;
    }

    private String zrnkwsratekijyunym8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM8)
    public String getZrnkwsratekijyunym8() {
        return zrnkwsratekijyunym8;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym8(String pZrnkwsratekijyunym8) {
        zrnkwsratekijyunym8 = pZrnkwsratekijyunym8;
    }

    private String zrnkaknsnkwsrate8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE8)
    public String getZrnkaknsnkwsrate8() {
        return zrnkaknsnkwsrate8;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate8(String pZrnkaknsnkwsrate8) {
        zrnkaknsnkwsrate8 = pZrnkaknsnkwsrate8;
    }

    private String zrnpgaika8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA8)
    public String getZrnpgaika8() {
        return zrnpgaika8;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika8(String pZrnpgaika8) {
        zrnpgaika8 = pZrnpgaika8;
    }

    private String zrnpyen8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN8)
    public String getZrnpyen8() {
        return zrnpyen8;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen8(String pZrnpyen8) {
        zrnpyen8 = pZrnpyen8;
    }

    private String zrnyoteiriritukijyunym9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM9)
    public String getZrnyoteiriritukijyunym9() {
        return zrnyoteiriritukijyunym9;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym9(String pZrnyoteiriritukijyunym9) {
        zrnyoteiriritukijyunym9 = pZrnyoteiriritukijyunym9;
    }

    private String zrnyoteiriritu9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU9)
    public String getZrnyoteiriritu9() {
        return zrnyoteiriritu9;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu9(String pZrnyoteiriritu9) {
        zrnyoteiriritu9 = pZrnyoteiriritu9;
    }

    private String zrnytirrtcalckijyunrrt9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT9)
    public String getZrnytirrtcalckijyunrrt9() {
        return zrnytirrtcalckijyunrrt9;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt9(String pZrnytirrtcalckijyunrrt9) {
        zrnytirrtcalckijyunrrt9 = pZrnytirrtcalckijyunrrt9;
    }

    private String zrnkwsratekijyunym9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM9)
    public String getZrnkwsratekijyunym9() {
        return zrnkwsratekijyunym9;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym9(String pZrnkwsratekijyunym9) {
        zrnkwsratekijyunym9 = pZrnkwsratekijyunym9;
    }

    private String zrnkaknsnkwsrate9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE9)
    public String getZrnkaknsnkwsrate9() {
        return zrnkaknsnkwsrate9;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate9(String pZrnkaknsnkwsrate9) {
        zrnkaknsnkwsrate9 = pZrnkaknsnkwsrate9;
    }

    private String zrnpgaika9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA9)
    public String getZrnpgaika9() {
        return zrnpgaika9;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika9(String pZrnpgaika9) {
        zrnpgaika9 = pZrnpgaika9;
    }

    private String zrnpyen9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN9)
    public String getZrnpyen9() {
        return zrnpyen9;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen9(String pZrnpyen9) {
        zrnpyen9 = pZrnpyen9;
    }

    private String zrnyoteiriritukijyunym10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM10)
    public String getZrnyoteiriritukijyunym10() {
        return zrnyoteiriritukijyunym10;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym10(String pZrnyoteiriritukijyunym10) {
        zrnyoteiriritukijyunym10 = pZrnyoteiriritukijyunym10;
    }

    private String zrnyoteiriritu10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU10)
    public String getZrnyoteiriritu10() {
        return zrnyoteiriritu10;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu10(String pZrnyoteiriritu10) {
        zrnyoteiriritu10 = pZrnyoteiriritu10;
    }

    private String zrnytirrtcalckijyunrrt10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT10)
    public String getZrnytirrtcalckijyunrrt10() {
        return zrnytirrtcalckijyunrrt10;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt10(String pZrnytirrtcalckijyunrrt10) {
        zrnytirrtcalckijyunrrt10 = pZrnytirrtcalckijyunrrt10;
    }

    private String zrnkwsratekijyunym10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM10)
    public String getZrnkwsratekijyunym10() {
        return zrnkwsratekijyunym10;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym10(String pZrnkwsratekijyunym10) {
        zrnkwsratekijyunym10 = pZrnkwsratekijyunym10;
    }

    private String zrnkaknsnkwsrate10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE10)
    public String getZrnkaknsnkwsrate10() {
        return zrnkaknsnkwsrate10;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate10(String pZrnkaknsnkwsrate10) {
        zrnkaknsnkwsrate10 = pZrnkaknsnkwsrate10;
    }

    private String zrnpgaika10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA10)
    public String getZrnpgaika10() {
        return zrnpgaika10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika10(String pZrnpgaika10) {
        zrnpgaika10 = pZrnpgaika10;
    }

    private String zrnpyen10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN10)
    public String getZrnpyen10() {
        return zrnpyen10;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen10(String pZrnpyen10) {
        zrnpyen10 = pZrnpyen10;
    }

    private String zrnyoteiriritukijyunym11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM11)
    public String getZrnyoteiriritukijyunym11() {
        return zrnyoteiriritukijyunym11;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym11(String pZrnyoteiriritukijyunym11) {
        zrnyoteiriritukijyunym11 = pZrnyoteiriritukijyunym11;
    }

    private String zrnyoteiriritu11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU11)
    public String getZrnyoteiriritu11() {
        return zrnyoteiriritu11;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu11(String pZrnyoteiriritu11) {
        zrnyoteiriritu11 = pZrnyoteiriritu11;
    }

    private String zrnytirrtcalckijyunrrt11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT11)
    public String getZrnytirrtcalckijyunrrt11() {
        return zrnytirrtcalckijyunrrt11;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt11(String pZrnytirrtcalckijyunrrt11) {
        zrnytirrtcalckijyunrrt11 = pZrnytirrtcalckijyunrrt11;
    }

    private String zrnkwsratekijyunym11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM11)
    public String getZrnkwsratekijyunym11() {
        return zrnkwsratekijyunym11;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym11(String pZrnkwsratekijyunym11) {
        zrnkwsratekijyunym11 = pZrnkwsratekijyunym11;
    }

    private String zrnkaknsnkwsrate11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE11)
    public String getZrnkaknsnkwsrate11() {
        return zrnkaknsnkwsrate11;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate11(String pZrnkaknsnkwsrate11) {
        zrnkaknsnkwsrate11 = pZrnkaknsnkwsrate11;
    }

    private String zrnpgaika11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA11)
    public String getZrnpgaika11() {
        return zrnpgaika11;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika11(String pZrnpgaika11) {
        zrnpgaika11 = pZrnpgaika11;
    }

    private String zrnpyen11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN11)
    public String getZrnpyen11() {
        return zrnpyen11;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen11(String pZrnpyen11) {
        zrnpyen11 = pZrnpyen11;
    }

    private String zrnyoteiriritukijyunym12;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITUKIJYUNYM12)
    public String getZrnyoteiriritukijyunym12() {
        return zrnyoteiriritukijyunym12;
    }

    @DataConvert("toMultiByte")
    public void setZrnyoteiriritukijyunym12(String pZrnyoteiriritukijyunym12) {
        zrnyoteiriritukijyunym12 = pZrnyoteiriritukijyunym12;
    }

    private String zrnyoteiriritu12;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYOTEIRIRITU12)
    public String getZrnyoteiriritu12() {
        return zrnyoteiriritu12;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnyoteiriritu12(String pZrnyoteiriritu12) {
        zrnyoteiriritu12 = pZrnyoteiriritu12;
    }

    private String zrnytirrtcalckijyunrrt12;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTCALCKIJYUNRRT12)
    public String getZrnytirrtcalckijyunrrt12() {
        return zrnytirrtcalckijyunrrt12;
    }

    @Padding(mode = "left", padChar ='0', length =4)
    public void setZrnytirrtcalckijyunrrt12(String pZrnytirrtcalckijyunrrt12) {
        zrnytirrtcalckijyunrrt12 = pZrnytirrtcalckijyunrrt12;
    }

    private String zrnkwsratekijyunym12;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKWSRATEKIJYUNYM12)
    public String getZrnkwsratekijyunym12() {
        return zrnkwsratekijyunym12;
    }

    @DataConvert("toMultiByte")
    public void setZrnkwsratekijyunym12(String pZrnkwsratekijyunym12) {
        zrnkwsratekijyunym12 = pZrnkwsratekijyunym12;
    }

    private String zrnkaknsnkwsrate12;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNKAKNSNKWSRATE12)
    public String getZrnkaknsnkwsrate12() {
        return zrnkaknsnkwsrate12;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnkaknsnkwsrate12(String pZrnkaknsnkwsrate12) {
        zrnkaknsnkwsrate12 = pZrnkaknsnkwsrate12;
    }

    private String zrnpgaika12;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPGAIKA12)
    public String getZrnpgaika12() {
        return zrnpgaika12;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpgaika12(String pZrnpgaika12) {
        zrnpgaika12 = pZrnpgaika12;
    }

    private String zrnpyen12;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNPYEN12)
    public String getZrnpyen12() {
        return zrnpyen12;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnpyen12(String pZrnpyen12) {
        zrnpyen12 = pZrnpyen12;
    }

    private String zrnfstphyoujikbn1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN1)
    public String getZrnfstphyoujikbn1() {
        return zrnfstphyoujikbn1;
    }

    public void setZrnfstphyoujikbn1(String pZrnfstphyoujikbn1) {
        zrnfstphyoujikbn1 = pZrnfstphyoujikbn1;
    }

    private String zrnfstphyoujikbn2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN2)
    public String getZrnfstphyoujikbn2() {
        return zrnfstphyoujikbn2;
    }

    public void setZrnfstphyoujikbn2(String pZrnfstphyoujikbn2) {
        zrnfstphyoujikbn2 = pZrnfstphyoujikbn2;
    }

    private String zrnfstphyoujikbn3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN3)
    public String getZrnfstphyoujikbn3() {
        return zrnfstphyoujikbn3;
    }

    public void setZrnfstphyoujikbn3(String pZrnfstphyoujikbn3) {
        zrnfstphyoujikbn3 = pZrnfstphyoujikbn3;
    }

    private String zrnfstphyoujikbn4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN4)
    public String getZrnfstphyoujikbn4() {
        return zrnfstphyoujikbn4;
    }

    public void setZrnfstphyoujikbn4(String pZrnfstphyoujikbn4) {
        zrnfstphyoujikbn4 = pZrnfstphyoujikbn4;
    }

    private String zrnfstphyoujikbn5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN5)
    public String getZrnfstphyoujikbn5() {
        return zrnfstphyoujikbn5;
    }

    public void setZrnfstphyoujikbn5(String pZrnfstphyoujikbn5) {
        zrnfstphyoujikbn5 = pZrnfstphyoujikbn5;
    }

    private String zrnfstphyoujikbn6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN6)
    public String getZrnfstphyoujikbn6() {
        return zrnfstphyoujikbn6;
    }

    public void setZrnfstphyoujikbn6(String pZrnfstphyoujikbn6) {
        zrnfstphyoujikbn6 = pZrnfstphyoujikbn6;
    }

    private String zrnfstphyoujikbn7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN7)
    public String getZrnfstphyoujikbn7() {
        return zrnfstphyoujikbn7;
    }

    public void setZrnfstphyoujikbn7(String pZrnfstphyoujikbn7) {
        zrnfstphyoujikbn7 = pZrnfstphyoujikbn7;
    }

    private String zrnfstphyoujikbn8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN8)
    public String getZrnfstphyoujikbn8() {
        return zrnfstphyoujikbn8;
    }

    public void setZrnfstphyoujikbn8(String pZrnfstphyoujikbn8) {
        zrnfstphyoujikbn8 = pZrnfstphyoujikbn8;
    }

    private String zrnfstphyoujikbn9;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN9)
    public String getZrnfstphyoujikbn9() {
        return zrnfstphyoujikbn9;
    }

    public void setZrnfstphyoujikbn9(String pZrnfstphyoujikbn9) {
        zrnfstphyoujikbn9 = pZrnfstphyoujikbn9;
    }

    private String zrnfstphyoujikbn10;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN10)
    public String getZrnfstphyoujikbn10() {
        return zrnfstphyoujikbn10;
    }

    public void setZrnfstphyoujikbn10(String pZrnfstphyoujikbn10) {
        zrnfstphyoujikbn10 = pZrnfstphyoujikbn10;
    }

    private String zrnfstphyoujikbn11;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN11)
    public String getZrnfstphyoujikbn11() {
        return zrnfstphyoujikbn11;
    }

    public void setZrnfstphyoujikbn11(String pZrnfstphyoujikbn11) {
        zrnfstphyoujikbn11 = pZrnfstphyoujikbn11;
    }

    private String zrnfstphyoujikbn12;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNFSTPHYOUJIKBN12)
    public String getZrnfstphyoujikbn12() {
        return zrnfstphyoujikbn12;
    }

    public void setZrnfstphyoujikbn12(String pZrnfstphyoujikbn12) {
        zrnfstphyoujikbn12 = pZrnfstphyoujikbn12;
    }

    private String zrnytirrtitrnyobi2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTITRNYOBI2)
    public String getZrnytirrtitrnyobi2() {
        return zrnytirrtitrnyobi2;
    }

    public void setZrnytirrtitrnyobi2(String pZrnytirrtitrnyobi2) {
        zrnytirrtitrnyobi2 = pZrnytirrtitrnyobi2;
    }

    private String zrnytirrtitrnhskmsgcd1;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTITRNHSKMSGCD1)
    public String getZrnytirrtitrnhskmsgcd1() {
        return zrnytirrtitrnhskmsgcd1;
    }

    public void setZrnytirrtitrnhskmsgcd1(String pZrnytirrtitrnhskmsgcd1) {
        zrnytirrtitrnhskmsgcd1 = pZrnytirrtitrnhskmsgcd1;
    }

    private String zrnytirrtitrnhskmsgcd2;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTITRNHSKMSGCD2)
    public String getZrnytirrtitrnhskmsgcd2() {
        return zrnytirrtitrnhskmsgcd2;
    }

    public void setZrnytirrtitrnhskmsgcd2(String pZrnytirrtitrnhskmsgcd2) {
        zrnytirrtitrnhskmsgcd2 = pZrnytirrtitrnhskmsgcd2;
    }

    private String zrnytirrtitrnhskmsgcd3;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTITRNHSKMSGCD3)
    public String getZrnytirrtitrnhskmsgcd3() {
        return zrnytirrtitrnhskmsgcd3;
    }

    public void setZrnytirrtitrnhskmsgcd3(String pZrnytirrtitrnhskmsgcd3) {
        zrnytirrtitrnhskmsgcd3 = pZrnytirrtitrnhskmsgcd3;
    }

    private String zrnytirrtitrnhskmsgcd4;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTITRNHSKMSGCD4)
    public String getZrnytirrtitrnhskmsgcd4() {
        return zrnytirrtitrnhskmsgcd4;
    }

    public void setZrnytirrtitrnhskmsgcd4(String pZrnytirrtitrnhskmsgcd4) {
        zrnytirrtitrnhskmsgcd4 = pZrnytirrtitrnhskmsgcd4;
    }

    private String zrnytirrtitrnhskmsgcd5;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTITRNHSKMSGCD5)
    public String getZrnytirrtitrnhskmsgcd5() {
        return zrnytirrtitrnhskmsgcd5;
    }

    public void setZrnytirrtitrnhskmsgcd5(String pZrnytirrtitrnhskmsgcd5) {
        zrnytirrtitrnhskmsgcd5 = pZrnytirrtitrnhskmsgcd5;
    }

    private String zrnytirrtitrnhskmsgcd6;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTITRNHSKMSGCD6)
    public String getZrnytirrtitrnhskmsgcd6() {
        return zrnytirrtitrnhskmsgcd6;
    }

    public void setZrnytirrtitrnhskmsgcd6(String pZrnytirrtitrnhskmsgcd6) {
        zrnytirrtitrnhskmsgcd6 = pZrnytirrtitrnhskmsgcd6;
    }

    private String zrnytirrtitrnhskmsgcd7;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTITRNHSKMSGCD7)
    public String getZrnytirrtitrnhskmsgcd7() {
        return zrnytirrtitrnhskmsgcd7;
    }

    public void setZrnytirrtitrnhskmsgcd7(String pZrnytirrtitrnhskmsgcd7) {
        zrnytirrtitrnhskmsgcd7 = pZrnytirrtitrnhskmsgcd7;
    }

    private String zrnytirrtitrnhskmsgcd8;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTITRNHSKMSGCD8)
    public String getZrnytirrtitrnhskmsgcd8() {
        return zrnytirrtitrnhskmsgcd8;
    }

    public void setZrnytirrtitrnhskmsgcd8(String pZrnytirrtitrnhskmsgcd8) {
        zrnytirrtitrnhskmsgcd8 = pZrnytirrtitrnhskmsgcd8;
    }

    private String zrnytirrtitrnyobi;

    @Column(name=GenZT_GaikaKokyakuTuutiRn.ZRNYTIRRTITRNYOBI)
    public String getZrnytirrtitrnyobi() {
        return zrnytirrtitrnyobi;
    }

    public void setZrnytirrtitrnyobi(String pZrnytirrtitrnyobi) {
        zrnytirrtitrnyobi = pZrnytirrtitrnyobi;
    }
}