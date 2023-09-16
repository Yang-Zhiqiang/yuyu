package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_SaihakkouHokensyoukenTy;
import yuyu.def.db.id.PKZT_SaihakkouHokensyoukenTy;
import yuyu.def.db.meta.GenQZT_SaihakkouHokensyoukenTy;
import yuyu.def.db.meta.QZT_SaihakkouHokensyoukenTy;

/**
 * 再発行保険証券Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SaihakkouHokensyoukenTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SaihakkouHokensyoukenTy}</td><td colspan="3">再発行保険証券Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_SaihakkouHokensyoukenTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SaihakkouHokensyoukenTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanryoutuutidouhuukbn ztykanryoutuutidouhuukbn}</td><td>（中継用）完了通知同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdrsktirasidouhuukbn ztystdrsktirasidouhuukbn}</td><td>（中継用）被保険者代理人チラシ同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaisyoumeikbn ztyaisyoumeikbn}</td><td>（中継用）愛称名区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysagyoukbn ztysagyoukbn}</td><td>（中継用）作業区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyakkanbunsyono ztyyakkanbunsyono}</td><td>（中継用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv23x2 ztyyobiv23x2}</td><td>（中継用）予備項目Ｖ２３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd1 ztyhyoujiranhidarimsgcd1}</td><td>（中継用）表示欄左メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd2 ztyhyoujiranhidarimsgcd2}</td><td>（中継用）表示欄左メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd3 ztyhyoujiranhidarimsgcd3}</td><td>（中継用）表示欄左メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd4 ztyhyoujiranhidarimsgcd4}</td><td>（中継用）表示欄左メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd5 ztyhyoujiranhidarimsgcd5}</td><td>（中継用）表示欄左メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd6 ztyhyoujiranhidarimsgcd6}</td><td>（中継用）表示欄左メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd7 ztyhyoujiranhidarimsgcd7}</td><td>（中継用）表示欄左メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd8 ztyhyoujiranhidarimsgcd8}</td><td>（中継用）表示欄左メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd9 ztyhyoujiranhidarimsgcd9}</td><td>（中継用）表示欄左メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd10 ztyhyoujiranhidarimsgcd10}</td><td>（中継用）表示欄左メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd11 ztyhyoujiranhidarimsgcd11}</td><td>（中継用）表示欄左メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd12 ztyhyoujiranhidarimsgcd12}</td><td>（中継用）表示欄左メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd13 ztyhyoujiranhidarimsgcd13}</td><td>（中継用）表示欄左メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd14 ztyhyoujiranhidarimsgcd14}</td><td>（中継用）表示欄左メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd15 ztyhyoujiranhidarimsgcd15}</td><td>（中継用）表示欄左メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd16 ztyhyoujiranhidarimsgcd16}</td><td>（中継用）表示欄左メッセージコード１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd17 ztyhyoujiranhidarimsgcd17}</td><td>（中継用）表示欄左メッセージコード１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd18 ztyhyoujiranhidarimsgcd18}</td><td>（中継用）表示欄左メッセージコード１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd19 ztyhyoujiranhidarimsgcd19}</td><td>（中継用）表示欄左メッセージコード１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranhidarimsgcd20 ztyhyoujiranhidarimsgcd20}</td><td>（中継用）表示欄左メッセージコード２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd1 ztyhyoujiranmigimsgcd1}</td><td>（中継用）表示欄右メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd2 ztyhyoujiranmigimsgcd2}</td><td>（中継用）表示欄右メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd3 ztyhyoujiranmigimsgcd3}</td><td>（中継用）表示欄右メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd4 ztyhyoujiranmigimsgcd4}</td><td>（中継用）表示欄右メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd5 ztyhyoujiranmigimsgcd5}</td><td>（中継用）表示欄右メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd6 ztyhyoujiranmigimsgcd6}</td><td>（中継用）表示欄右メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd7 ztyhyoujiranmigimsgcd7}</td><td>（中継用）表示欄右メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd8 ztyhyoujiranmigimsgcd8}</td><td>（中継用）表示欄右メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd9 ztyhyoujiranmigimsgcd9}</td><td>（中継用）表示欄右メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd10 ztyhyoujiranmigimsgcd10}</td><td>（中継用）表示欄右メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd11 ztyhyoujiranmigimsgcd11}</td><td>（中継用）表示欄右メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd12 ztyhyoujiranmigimsgcd12}</td><td>（中継用）表示欄右メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd13 ztyhyoujiranmigimsgcd13}</td><td>（中継用）表示欄右メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd14 ztyhyoujiranmigimsgcd14}</td><td>（中継用）表示欄右メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd15 ztyhyoujiranmigimsgcd15}</td><td>（中継用）表示欄右メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd16 ztyhyoujiranmigimsgcd16}</td><td>（中継用）表示欄右メッセージコード１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd17 ztyhyoujiranmigimsgcd17}</td><td>（中継用）表示欄右メッセージコード１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd18 ztyhyoujiranmigimsgcd18}</td><td>（中継用）表示欄右メッセージコード１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd19 ztyhyoujiranmigimsgcd19}</td><td>（中継用）表示欄右メッセージコード１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranmigimsgcd20 ztyhyoujiranmigimsgcd20}</td><td>（中継用）表示欄右メッセージコード２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysknnkaisiymdseireki ztysknnkaisiymdseireki}</td><td>（中継用）責任開始日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiranytirrt ztyhyoujiranytirrt}</td><td>（中継用）表示欄予定利率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiransjkkktusirrt ztyhyoujiransjkkktusirrt}</td><td>（中継用）表示欄市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujirantumitateriritu ztyhyoujirantumitateriritu}</td><td>（中継用）表示欄積立利率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujirantumitateriritu2 ztyhyoujirantumitateriritu2}</td><td>（中継用）表示欄積立利率２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujirantmttknzkrtjygn ztyhyoujirantmttknzkrtjygn}</td><td>（中継用）表示欄積立金増加率の上限</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyoujiransetteibairitu ztyhyoujiransetteibairitu}</td><td>（中継用）表示欄設定倍率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22x11 ztyyobiv22x11}</td><td>（中継用）予備項目Ｖ２２＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoukenhakkouymd ztysyoukenhakkouymd}</td><td>（中継用）証券発行年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouryokukaisimsg ztykouryokukaisimsg}</td><td>（中継用）効力開始メッセージ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisikihknnmsyouken ztyseisikihknnmsyouken}</td><td>（中継用）正式保険名称（証券）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruinmsyouken ztynksyuruinmsyouken}</td><td>（中継用）年金種類名称（証券用）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv116 ztyyobiv116}</td><td>（中継用）予備項目Ｖ１１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj ztykyknmkj}</td><td>（中継用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihknsyaseiymdwareki ztyhihknsyaseiymdwareki}</td><td>（中継用）被保険者生年月日（和暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsei ztyhhknsei}</td><td>（中継用）被保険者性別</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2 ztyhhknnen2}</td><td>（中継用）被保険者年齢Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn1 ztyuktmidasikbn1}</td><td>（中継用）受取人見出し区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn1 ztyuktkbn1}</td><td>（中継用）受取人区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm1 ztyuktnm1}</td><td>（中継用）受取人名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktbnwari1 ztyuktbnwari1}</td><td>（中継用）受取人分割割合１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn2 ztyuktmidasikbn2}</td><td>（中継用）受取人見出し区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn2 ztyuktkbn2}</td><td>（中継用）受取人区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm2 ztyuktnm2}</td><td>（中継用）受取人名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktbnwari2 ztyuktbnwari2}</td><td>（中継用）受取人分割割合２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn3 ztyuktmidasikbn3}</td><td>（中継用）受取人見出し区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn3 ztyuktkbn3}</td><td>（中継用）受取人区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm3 ztyuktnm3}</td><td>（中継用）受取人名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktbnwari3 ztyuktbnwari3}</td><td>（中継用）受取人分割割合３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn4 ztyuktmidasikbn4}</td><td>（中継用）受取人見出し区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn4 ztyuktkbn4}</td><td>（中継用）受取人区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm4 ztyuktnm4}</td><td>（中継用）受取人名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktbnwari4 ztyuktbnwari4}</td><td>（中継用）受取人分割割合４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn5 ztyuktmidasikbn5}</td><td>（中継用）受取人見出し区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn5 ztyuktkbn5}</td><td>（中継用）受取人区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm5 ztyuktnm5}</td><td>（中継用）受取人名５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktbnwari5 ztyuktbnwari5}</td><td>（中継用）受取人分割割合５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn6 ztyuktmidasikbn6}</td><td>（中継用）受取人見出し区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn6 ztyuktkbn6}</td><td>（中継用）受取人区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm6 ztyuktnm6}</td><td>（中継用）受取人名６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktbnwari6 ztyuktbnwari6}</td><td>（中継用）受取人分割割合６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn7 ztyuktmidasikbn7}</td><td>（中継用）受取人見出し区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn7 ztyuktkbn7}</td><td>（中継用）受取人区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm7 ztyuktnm7}</td><td>（中継用）受取人名７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktbnwari7 ztyuktbnwari7}</td><td>（中継用）受取人分割割合７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn8 ztyuktmidasikbn8}</td><td>（中継用）受取人見出し区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn8 ztyuktkbn8}</td><td>（中継用）受取人区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm8 ztyuktnm8}</td><td>（中継用）受取人名８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktbnwari8 ztyuktbnwari8}</td><td>（中継用）受取人分割割合８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn9 ztyuktmidasikbn9}</td><td>（中継用）受取人見出し区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn9 ztyuktkbn9}</td><td>（中継用）受取人区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm9 ztyuktnm9}</td><td>（中継用）受取人名９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktbnwari9 ztyuktbnwari9}</td><td>（中継用）受取人分割割合９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktmidasikbn10 ztyuktmidasikbn10}</td><td>（中継用）受取人見出し区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktkbn10 ztyuktkbn10}</td><td>（中継用）受取人区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktnm10 ztyuktnm10}</td><td>（中継用）受取人名１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyuktbnwari10 ztyuktbnwari10}</td><td>（中継用）受取人分割割合１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv45 ztyyobiv45}</td><td>（中継用）予備項目Ｖ４５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmsgcd1 ztypmsgcd1}</td><td>（中継用）保険料メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmsgcd2 ztypmsgcd2}</td><td>（中継用）保険料メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmsgcd3 ztypmsgcd3}</td><td>（中継用）保険料メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10 ztyyobiv10}</td><td>（中継用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptuukatype ztyptuukatype}</td><td>（中継用）保険料金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypkngk ztypkngk}</td><td>（中継用）保険料金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypkngktuuka ztypkngktuuka}</td><td>（中継用）保険料金額通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikiikkatubaraitukisuu ztyteikiikkatubaraitukisuu}</td><td>（中継用）定期一括払月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyztikiktbriyhrkgktuktype ztyztikiktbriyhrkgktuktype}</td><td>（中継用）前納定期一括払円貨払込額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyznntikiktbriyenhrkgk ztyznntikiktbriyenhrkgk}</td><td>（中継用）前納定期一括払円貨払込額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyznnkai ztyznnkai}</td><td>（中継用）前納回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyptokuyakumsgcd ztyptokuyakumsgcd}</td><td>（中継用）保険料特約メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytikiktbriyhrkgktuktype ztytikiktbriyhrkgktuktype}</td><td>（中継用）定期一括払円貨払込額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytikiktbriyenhrkgk ztytikiktbriyenhrkgk}</td><td>（中継用）定期一括払円貨払込額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv32 ztyyobiv32}</td><td>（中継用）予備項目Ｖ３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymdseireki ztykykymdseireki}</td><td>（中継用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkknmidasikbn ztyphrkkknmidasikbn}</td><td>（中継用）保険料払込期間見出し区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkknmsgkbn ztyhrkkknmsgkbn}</td><td>（中継用）払込期間メッセージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuumsgkbn ztyhrkkaisuumsgkbn}</td><td>（中継用）払込回数メッセージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkktuki ztyphrkktuki}</td><td>（中継用）保険料払込期月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkhouhoumsgkbn ztyhrkhouhoumsgkbn}</td><td>（中継用）払込方法メッセージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv18 ztyyobiv18}</td><td>（中継用）予備項目Ｖ１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykrenban1 ztysyukyktkykrenban1}</td><td>（中継用）主契約特約連番１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykmsgkbn1 ztysyukyktkykmsgkbn1}</td><td>（中継用）主契約特約メッセージ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkyksmsgkbn1 ztysyukyktkyksmsgkbn1}</td><td>（中継用）主契約特約保険金額メッセージ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkknmsgkbn1 ztysyukyktkykhknkknmsgkbn1}</td><td>（中継用）主契約特約保険期間メッセージ区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykstuukatype1 ztysyukyktkykstuukatype1}</td><td>（中継用）主契約特約保険金額通貨タイプ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkngk1 ztysyukyktkykhknkngk1}</td><td>（中継用）主契約特約保険金額１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai1hknkknymdto1 ztysyutkdai1hknkknymdto1}</td><td>（中継用）主契約特約第１保険期間年月日（至）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai2hknkknymdto1 ztysyutkdai2hknkknymdto1}</td><td>（中継用）主契約特約第２保険期間年月日（至）１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22 ztyyobiv22}</td><td>（中継用）予備項目Ｖ２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykrenban2 ztysyukyktkykrenban2}</td><td>（中継用）主契約特約連番２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykmsgkbn2 ztysyukyktkykmsgkbn2}</td><td>（中継用）主契約特約メッセージ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkyksmsgkbn2 ztysyukyktkyksmsgkbn2}</td><td>（中継用）主契約特約保険金額メッセージ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkknmsgkbn2 ztysyukyktkykhknkknmsgkbn2}</td><td>（中継用）主契約特約保険期間メッセージ区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykstuukatype2 ztysyukyktkykstuukatype2}</td><td>（中継用）主契約特約保険金額通貨タイプ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkngk2 ztysyukyktkykhknkngk2}</td><td>（中継用）主契約特約保険金額２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai1hknkknymdto2 ztysyutkdai1hknkknymdto2}</td><td>（中継用）主契約特約第１保険期間年月日（至）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai2hknkknymdto2 ztysyutkdai2hknkknymdto2}</td><td>（中継用）主契約特約第２保険期間年月日（至）２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22x2 ztyyobiv22x2}</td><td>（中継用）予備項目Ｖ２２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykrenban3 ztysyukyktkykrenban3}</td><td>（中継用）主契約特約連番３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykmsgkbn3 ztysyukyktkykmsgkbn3}</td><td>（中継用）主契約特約メッセージ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkyksmsgkbn3 ztysyukyktkyksmsgkbn3}</td><td>（中継用）主契約特約保険金額メッセージ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkknmsgkbn3 ztysyukyktkykhknkknmsgkbn3}</td><td>（中継用）主契約特約保険期間メッセージ区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykstuukatype3 ztysyukyktkykstuukatype3}</td><td>（中継用）主契約特約保険金額通貨タイプ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkngk3 ztysyukyktkykhknkngk3}</td><td>（中継用）主契約特約保険金額３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai1hknkknymdto3 ztysyutkdai1hknkknymdto3}</td><td>（中継用）主契約特約第１保険期間年月日（至）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai2hknkknymdto3 ztysyutkdai2hknkknymdto3}</td><td>（中継用）主契約特約第２保険期間年月日（至）３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22x3 ztyyobiv22x3}</td><td>（中継用）予備項目Ｖ２２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykrenban4 ztysyukyktkykrenban4}</td><td>（中継用）主契約特約連番４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykmsgkbn4 ztysyukyktkykmsgkbn4}</td><td>（中継用）主契約特約メッセージ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkyksmsgkbn4 ztysyukyktkyksmsgkbn4}</td><td>（中継用）主契約特約保険金額メッセージ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkknmsgkbn4 ztysyukyktkykhknkknmsgkbn4}</td><td>（中継用）主契約特約保険期間メッセージ区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykstuukatype4 ztysyukyktkykstuukatype4}</td><td>（中継用）主契約特約保険金額通貨タイプ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkngk4 ztysyukyktkykhknkngk4}</td><td>（中継用）主契約特約保険金額４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai1hknkknymdto4 ztysyutkdai1hknkknymdto4}</td><td>（中継用）主契約特約第１保険期間年月日（至）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai2hknkknymdto4 ztysyutkdai2hknkknymdto4}</td><td>（中継用）主契約特約第２保険期間年月日（至）４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22x4 ztyyobiv22x4}</td><td>（中継用）予備項目Ｖ２２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykrenban5 ztysyukyktkykrenban5}</td><td>（中継用）主契約特約連番５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykmsgkbn5 ztysyukyktkykmsgkbn5}</td><td>（中継用）主契約特約メッセージ区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkyksmsgkbn5 ztysyukyktkyksmsgkbn5}</td><td>（中継用）主契約特約保険金額メッセージ区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkknmsgkbn5 ztysyukyktkykhknkknmsgkbn5}</td><td>（中継用）主契約特約保険期間メッセージ区分５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykstuukatype5 ztysyukyktkykstuukatype5}</td><td>（中継用）主契約特約保険金額通貨タイプ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkngk5 ztysyukyktkykhknkngk5}</td><td>（中継用）主契約特約保険金額５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai1hknkknymdto5 ztysyutkdai1hknkknymdto5}</td><td>（中継用）主契約特約第１保険期間年月日（至）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai2hknkknymdto5 ztysyutkdai2hknkknymdto5}</td><td>（中継用）主契約特約第２保険期間年月日（至）５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22x5 ztyyobiv22x5}</td><td>（中継用）予備項目Ｖ２２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykrenban6 ztysyukyktkykrenban6}</td><td>（中継用）主契約特約連番６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykmsgkbn6 ztysyukyktkykmsgkbn6}</td><td>（中継用）主契約特約メッセージ区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkyksmsgkbn6 ztysyukyktkyksmsgkbn6}</td><td>（中継用）主契約特約保険金額メッセージ区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkknmsgkbn6 ztysyukyktkykhknkknmsgkbn6}</td><td>（中継用）主契約特約保険期間メッセージ区分６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykstuukatype6 ztysyukyktkykstuukatype6}</td><td>（中継用）主契約特約保険金額通貨タイプ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkngk6 ztysyukyktkykhknkngk6}</td><td>（中継用）主契約特約保険金額６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai1hknkknymdto6 ztysyutkdai1hknkknymdto6}</td><td>（中継用）主契約特約第１保険期間年月日（至）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai2hknkknymdto6 ztysyutkdai2hknkknymdto6}</td><td>（中継用）主契約特約第２保険期間年月日（至）６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22x6 ztyyobiv22x6}</td><td>（中継用）予備項目Ｖ２２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykrenban7 ztysyukyktkykrenban7}</td><td>（中継用）主契約特約連番７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykmsgkbn7 ztysyukyktkykmsgkbn7}</td><td>（中継用）主契約特約メッセージ区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkyksmsgkbn7 ztysyukyktkyksmsgkbn7}</td><td>（中継用）主契約特約保険金額メッセージ区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkknmsgkbn7 ztysyukyktkykhknkknmsgkbn7}</td><td>（中継用）主契約特約保険期間メッセージ区分７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykstuukatype7 ztysyukyktkykstuukatype7}</td><td>（中継用）主契約特約保険金額通貨タイプ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkngk7 ztysyukyktkykhknkngk7}</td><td>（中継用）主契約特約保険金額７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai1hknkknymdto7 ztysyutkdai1hknkknymdto7}</td><td>（中継用）主契約特約第１保険期間年月日（至）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai2hknkknymdto7 ztysyutkdai2hknkknymdto7}</td><td>（中継用）主契約特約第２保険期間年月日（至）７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22x7 ztyyobiv22x7}</td><td>（中継用）予備項目Ｖ２２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykrenban8 ztysyukyktkykrenban8}</td><td>（中継用）主契約特約連番８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykmsgkbn8 ztysyukyktkykmsgkbn8}</td><td>（中継用）主契約特約メッセージ区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkyksmsgkbn8 ztysyukyktkyksmsgkbn8}</td><td>（中継用）主契約特約保険金額メッセージ区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkknmsgkbn8 ztysyukyktkykhknkknmsgkbn8}</td><td>（中継用）主契約特約保険期間メッセージ区分８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykstuukatype8 ztysyukyktkykstuukatype8}</td><td>（中継用）主契約特約保険金額通貨タイプ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkngk8 ztysyukyktkykhknkngk8}</td><td>（中継用）主契約特約保険金額８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai1hknkknymdto8 ztysyutkdai1hknkknymdto8}</td><td>（中継用）主契約特約第１保険期間年月日（至）８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai2hknkknymdto8 ztysyutkdai2hknkknymdto8}</td><td>（中継用）主契約特約第２保険期間年月日（至）８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22x8 ztyyobiv22x8}</td><td>（中継用）予備項目Ｖ２２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykrenban9 ztysyukyktkykrenban9}</td><td>（中継用）主契約特約連番９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykmsgkbn9 ztysyukyktkykmsgkbn9}</td><td>（中継用）主契約特約メッセージ区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkyksmsgkbn9 ztysyukyktkyksmsgkbn9}</td><td>（中継用）主契約特約保険金額メッセージ区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkknmsgkbn9 ztysyukyktkykhknkknmsgkbn9}</td><td>（中継用）主契約特約保険期間メッセージ区分９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykstuukatype9 ztysyukyktkykstuukatype9}</td><td>（中継用）主契約特約保険金額通貨タイプ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkngk9 ztysyukyktkykhknkngk9}</td><td>（中継用）主契約特約保険金額９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai1hknkknymdto9 ztysyutkdai1hknkknymdto9}</td><td>（中継用）主契約特約第１保険期間年月日（至）９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai2hknkknymdto9 ztysyutkdai2hknkknymdto9}</td><td>（中継用）主契約特約第２保険期間年月日（至）９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22x9 ztyyobiv22x9}</td><td>（中継用）予備項目Ｖ２２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykrenban10 ztysyukyktkykrenban10}</td><td>（中継用）主契約特約連番１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykmsgkbn10 ztysyukyktkykmsgkbn10}</td><td>（中継用）主契約特約メッセージ区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkyksmsgkbn10 ztysyukyktkyksmsgkbn10}</td><td>（中継用）主契約特約保険金額メッセージ区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkknmsgkbn10 ztysyukyktkykhknkknmsgkbn10}</td><td>（中継用）主契約特約保険期間メッセージ区分１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykstuukatype10 ztysyukyktkykstuukatype10}</td><td>（中継用）主契約特約保険金額通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukyktkykhknkngk10 ztysyukyktkykhknkngk10}</td><td>（中継用）主契約特約保険金額１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai1hknkknymdto10 ztysyutkdai1hknkknymdto10}</td><td>（中継用）主契約特約第１保険期間年月日（至）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyutkdai2hknkknymdto10 ztysyutkdai2hknkknymdto10}</td><td>（中継用）主契約特約第２保険期間年月日（至）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv22x10 ztyyobiv22x10}</td><td>（中継用）予備項目Ｖ２２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv50 ztyyobiv50}</td><td>（中継用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd1 ztykykniyustmsgcd1}</td><td>（中継用）契約内容欄下メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd2 ztykykniyustmsgcd2}</td><td>（中継用）契約内容欄下メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd3 ztykykniyustmsgcd3}</td><td>（中継用）契約内容欄下メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd4 ztykykniyustmsgcd4}</td><td>（中継用）契約内容欄下メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd5 ztykykniyustmsgcd5}</td><td>（中継用）契約内容欄下メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd6 ztykykniyustmsgcd6}</td><td>（中継用）契約内容欄下メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd7 ztykykniyustmsgcd7}</td><td>（中継用）契約内容欄下メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd8 ztykykniyustmsgcd8}</td><td>（中継用）契約内容欄下メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd9 ztykykniyustmsgcd9}</td><td>（中継用）契約内容欄下メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd10 ztykykniyustmsgcd10}</td><td>（中継用）契約内容欄下メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd11 ztykykniyustmsgcd11}</td><td>（中継用）契約内容欄下メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd12 ztykykniyustmsgcd12}</td><td>（中継用）契約内容欄下メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd13 ztykykniyustmsgcd13}</td><td>（中継用）契約内容欄下メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd14 ztykykniyustmsgcd14}</td><td>（中継用）契約内容欄下メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustmsgcd15 ztykykniyustmsgcd15}</td><td>（中継用）契約内容欄下メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustitjbrptuuktype ztykykniyustitjbrptuuktype}</td><td>（中継用）契約内容欄下一時払保険料通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustitjbrp ztykykniyustitjbrp}</td><td>（中継用）契約内容欄下一時払保険料</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustkihonstype ztykykniyustkihonstype}</td><td>（中継用）契約内容欄下基本保険金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyustkihons ztykykniyustkihons}</td><td>（中継用）契約内容欄下基本保険金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd1 ztysonotanyranmsgcd1}</td><td>（中継用）その他内容欄メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd2 ztysonotanyranmsgcd2}</td><td>（中継用）その他内容欄メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd3 ztysonotanyranmsgcd3}</td><td>（中継用）その他内容欄メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd4 ztysonotanyranmsgcd4}</td><td>（中継用）その他内容欄メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd5 ztysonotanyranmsgcd5}</td><td>（中継用）その他内容欄メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd6 ztysonotanyranmsgcd6}</td><td>（中継用）その他内容欄メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd7 ztysonotanyranmsgcd7}</td><td>（中継用）その他内容欄メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd8 ztysonotanyranmsgcd8}</td><td>（中継用）その他内容欄メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd9 ztysonotanyranmsgcd9}</td><td>（中継用）その他内容欄メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd10 ztysonotanyranmsgcd10}</td><td>（中継用）その他内容欄メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd11 ztysonotanyranmsgcd11}</td><td>（中継用）その他内容欄メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd12 ztysonotanyranmsgcd12}</td><td>（中継用）その他内容欄メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd13 ztysonotanyranmsgcd13}</td><td>（中継用）その他内容欄メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd14 ztysonotanyranmsgcd14}</td><td>（中継用）その他内容欄メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd15 ztysonotanyranmsgcd15}</td><td>（中継用）その他内容欄メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd16 ztysonotanyranmsgcd16}</td><td>（中継用）その他内容欄メッセージコード１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd17 ztysonotanyranmsgcd17}</td><td>（中継用）その他内容欄メッセージコード１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd18 ztysonotanyranmsgcd18}</td><td>（中継用）その他内容欄メッセージコード１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd19 ztysonotanyranmsgcd19}</td><td>（中継用）その他内容欄メッセージコード１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmsgcd20 ztysonotanyranmsgcd20}</td><td>（中継用）その他内容欄メッセージコード２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyransiteituuka ztysonotanyransiteituuka}</td><td>（中継用）その他内容欄指定通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyrannykntuktype ztysonotanyrannykntuktype}</td><td>（中継用）その他内容欄入金通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyrannykntuukap ztysonotanyrannykntuukap}</td><td>（中継用）その他内容欄入金通貨保険料</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyrannykntuukasyu ztysonotanyrannykntuukasyu}</td><td>（中継用）その他内容欄入金通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranenkhrikmrate ztysonotanyranenkhrikmrate}</td><td>（中継用）その他内容欄円貨払込特約レート</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranstigikwsrate ztysonotanyranstigikwsrate}</td><td>（中継用）その他内容欄指定外通貨払込特約レート</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanykjnkngktuktype ztysonotanykjnkngktuktype}</td><td>（中継用）その他内容欄基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanykjnkngk ztysonotanykjnkngk}</td><td>（中継用）その他内容欄基準金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanykjnkngkrate ztysonotanykjnkngkrate}</td><td>（中継用）その他内容欄基準金額換算レート</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanykjnkngktuuka ztysonotanykjnkngktuuka}</td><td>（中継用）その他内容欄基準金額通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranpentuktype ztysonotanyranpentuktype}</td><td>（中継用）その他内容欄保険料円換算通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranpenknsngk ztysonotanyranpenknsngk}</td><td>（中継用）その他内容欄保険料円換算額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmkhtoutatuwariai ztypmkhtoutatuwariai}</td><td>（中継用）その他内容欄目標到達割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyranmkhgk ztysonotanyranmkhgk}</td><td>（中継用）その他内容欄目標額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyrannkshrstartymd ztysonotanyrannkshrstartymd}</td><td>（中継用）その他内容欄年金支払開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyrannkkkn ztysonotanyrannkkkn}</td><td>（中継用）その他内容欄年金期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyyensysnhkhnkymd ztysonotanyyensysnhkhnkymd}</td><td>（中継用）その他内容欄円建終身保険変更日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanytmttkngktuktype ztysonotanytmttkngktuktype}</td><td>（中継用）その他内容欄積立金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyteiritutmttkngk ztysonotanyteiritutmttkngk}</td><td>（中継用）その他内容欄定率積立金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyransisuutmttkngk ztysonotanyransisuutmttkngk}</td><td>（中継用）その他内容欄指数積立金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyransisuunm ztysonotanyransisuunm}</td><td>（中継用）その他内容欄指数名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyrendouritu ztysonotanyrendouritu}</td><td>（中継用）その他内容欄連動率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyteikisiharaikin ztysonotanyteikisiharaikin}</td><td>（中継用）その他内容欄定期支払金</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotanyrangaimsgcd ztysonotanyrangaimsgcd}</td><td>（中継用）その他内容欄外メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyounymsgcd ztyhosyounymsgcd}</td><td>（中継用）保障内容メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv15 ztyyobiv15}</td><td>（中継用）予備項目Ｖ１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyounyhihknsyanmkanji ztyhosyounyhihknsyanmkanji}</td><td>（中継用）保障内容被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24 ztyyobiv24}</td><td>（中継用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboumidasimsgcd ztysiboumidasimsgcd}</td><td>（中継用）死亡保障見出しメッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboumidasimsgcd2 ztysiboumidasimsgcd2}</td><td>（中継用）死亡保障見出しメッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai1hknkknmsgcd1 ztysiboudai1hknkknmsgcd1}</td><td>（中継用）死亡保障第１保険期間メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai1hknkknmsgcd2 ztysiboudai1hknkknmsgcd2}</td><td>（中継用）死亡保障第１保険期間メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai1hknkknigimsgcd ztysiboudai1hknkknigimsgcd}</td><td>（中継用）死亡保障第１保険期間不慮の事故以外Ｓ表メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai1hknkknigimsgcd2 ztysiboudai1hknkknigimsgcd2}</td><td>（中継用）死亡保障第１保険期間不慮の事故以外Ｓ表メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai1hknkknhrsmsgcd ztysiboudai1hknkknhrsmsgcd}</td><td>（中継用）死亡保障第１保険期間不慮の事故Ｓ表メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai1hknkknhrsmsgcd2 ztysiboudai1hknkknhrsmsgcd2}</td><td>（中継用）死亡保障第１保険期間不慮の事故Ｓ表メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai1hknkknsmrmsgcd ztysiboudai1hknkknsmrmsgcd}</td><td>（中継用）死亡保障第１保険期間Ｓ表丸印メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai2hknkknmsgcd1 ztysiboudai2hknkknmsgcd1}</td><td>（中継用）死亡保障第２保険期間メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai2hknkknmsgcd2 ztysiboudai2hknkknmsgcd2}</td><td>（中継用）死亡保障第２保険期間メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai2hknkknsmsgcd ztysiboudai2hknkknsmsgcd}</td><td>（中継用）死亡保障第２保険期間Ｓ表メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai2hknkknsmsgcd2 ztysiboudai2hknkknsmsgcd2}</td><td>（中継用）死亡保障第２保険期間Ｓ表メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai3hknkknmsgcd1 ztysiboudai3hknkknmsgcd1}</td><td>（中継用）死亡保障第３保険期間メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai3hknkknmsgcd2 ztysiboudai3hknkknmsgcd2}</td><td>（中継用）死亡保障第３保険期間メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv15x2 ztyyobiv15x2}</td><td>（中継用）予備項目Ｖ１５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai1hknkknymdto ztysiboudai1hknkknymdto}</td><td>（中継用）死亡保障第１保険期間年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibouitjbrpyentuuktype ztysibouitjbrpyentuuktype}</td><td>（中継用）死亡保障一時払保険料相当円換算額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibouitjbrpyentuukgk ztysibouitjbrpyentuukgk}</td><td>（中継用）死亡保障一時払保険料相当円換算額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai1kjnkngktuktype ztysiboudai1kjnkngktuktype}</td><td>（中継用）死亡保障第１基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai1kjnkngk ztysiboudai1kjnkngk}</td><td>（中継用）死亡保障第１基準金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai2hknkknymdto ztysiboudai2hknkknymdto}</td><td>（中継用）死亡保障第２保険期間年月日（至）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai2kjnkngktuktype ztysiboudai2kjnkngktuktype}</td><td>（中継用）死亡保障第２基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai2kjnkngk ztysiboudai2kjnkngk}</td><td>（中継用）死亡保障第２基準金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai3kjnkngktuktype ztysiboudai3kjnkngktuktype}</td><td>（中継用）死亡保障第３基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboudai3kjnkngk ztysiboudai3kjnkngk}</td><td>（中継用）死亡保障第３基準金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv23 ztyyobiv23}</td><td>（中継用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1skwsrateyendaka ztydai1skwsrateyendaka}</td><td>（中継用）第１死亡保険金額為替レート（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1skwsrateyenkijyun ztydai1skwsrateyenkijyun}</td><td>（中継用）第１死亡保険金額為替レート（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1skwsrateyenyasu ztydai1skwsrateyenyasu}</td><td>（中継用）第１死亡保険金額為替レート（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sibousnenoutouymd1 ztydai1sibousnenoutouymd1}</td><td>（中継用）第１死亡保険金額年単位応当年月日０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktype01 ztydai1stuuktype01}</td><td>（中継用）第１死亡保険金額通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1s01 ztydai1s01}</td><td>（中継用）第１死亡保険金額０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumu01 ztydai1syenyendakaumu01}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunumu01 ztydai1syenyenkijyunumu01}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumu01 ztydai1syenyenyasuumu01}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktype01 ztydai1syentuuktype01}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendaka01 ztydai1syenyendaka01}</td><td>（中継用）第１死亡保険金額（円貨）（円高）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyun01 ztydai1syenyenkijyun01}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasu01 ztydai1syenyenyasu01}</td><td>（中継用）第１死亡保険金額（円貨）（円安）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndk01 ztydai1zennouzndk01}</td><td>（中継用）第１前納残高０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndktype01 ztydai1zennouzndktype01}</td><td>（中継用）第１前納残高通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgk01 ztydai1sbjiuktgk01}</td><td>（中継用）第１死亡時受取額０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgktype01 ztydai1sbjiuktgktype01}</td><td>（中継用）第１死亡時受取額通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkytype01 ztydai1sbjiuktgkytype01}</td><td>（中継用）第１死亡時受取額（円貨）通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkydaka01 ztydai1sbjiuktgkydaka01}</td><td>（中継用）第１死亡時受取額（円貨）（円高）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkykijyun01 ztydai1sbjiuktgkykijyun01}</td><td>（中継用）第１死亡時受取額（円貨）（中央値）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkyyasu01 ztydai1sbjiuktgkyyasu01}</td><td>（中継用）第１死亡時受取額（円貨）（円安）０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sibousnenoutouymd2 ztydai1sibousnenoutouymd2}</td><td>（中継用）第１死亡保険金額年単位応当年月日０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktype02 ztydai1stuuktype02}</td><td>（中継用）第１死亡保険金額通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1s02 ztydai1s02}</td><td>（中継用）第１死亡保険金額０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumu02 ztydai1syenyendakaumu02}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunumu02 ztydai1syenyenkijyunumu02}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumu02 ztydai1syenyenyasuumu02}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktype02 ztydai1syentuuktype02}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendaka02 ztydai1syenyendaka02}</td><td>（中継用）第１死亡保険金額（円貨）（円高）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyun02 ztydai1syenyenkijyun02}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasu02 ztydai1syenyenyasu02}</td><td>（中継用）第１死亡保険金額（円貨）（円安）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndk02 ztydai1zennouzndk02}</td><td>（中継用）第１前納残高０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndktype02 ztydai1zennouzndktype02}</td><td>（中継用）第１前納残高通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgk02 ztydai1sbjiuktgk02}</td><td>（中継用）第１死亡時受取額０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgktype02 ztydai1sbjiuktgktype02}</td><td>（中継用）第１死亡時受取額通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkytype02 ztydai1sbjiuktgkytype02}</td><td>（中継用）第１死亡時受取額（円貨）通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkydaka02 ztydai1sbjiuktgkydaka02}</td><td>（中継用）第１死亡時受取額（円貨）（円高）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkykijyun02 ztydai1sbjiuktgkykijyun02}</td><td>（中継用）第１死亡時受取額（円貨）（中央値）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkyyasu02 ztydai1sbjiuktgkyyasu02}</td><td>（中継用）第１死亡時受取額（円貨）（円安）０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sibousnenoutouymd3 ztydai1sibousnenoutouymd3}</td><td>（中継用）第１死亡保険金額年単位応当年月日０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktype03 ztydai1stuuktype03}</td><td>（中継用）第１死亡保険金額通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1s03 ztydai1s03}</td><td>（中継用）第１死亡保険金額０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumu03 ztydai1syenyendakaumu03}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunumu03 ztydai1syenyenkijyunumu03}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumu03 ztydai1syenyenyasuumu03}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktype03 ztydai1syentuuktype03}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendaka03 ztydai1syenyendaka03}</td><td>（中継用）第１死亡保険金額（円貨）（円高）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyun03 ztydai1syenyenkijyun03}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasu03 ztydai1syenyenyasu03}</td><td>（中継用）第１死亡保険金額（円貨）（円安）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndk03 ztydai1zennouzndk03}</td><td>（中継用）第１前納残高０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndktype03 ztydai1zennouzndktype03}</td><td>（中継用）第１前納残高通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgk03 ztydai1sbjiuktgk03}</td><td>（中継用）第１死亡時受取額０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgktype03 ztydai1sbjiuktgktype03}</td><td>（中継用）第１死亡時受取額通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkytype03 ztydai1sbjiuktgkytype03}</td><td>（中継用）第１死亡時受取額（円貨）通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkydaka03 ztydai1sbjiuktgkydaka03}</td><td>（中継用）第１死亡時受取額（円貨）（円高）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkykijyun03 ztydai1sbjiuktgkykijyun03}</td><td>（中継用）第１死亡時受取額（円貨）（中央値）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkyyasu03 ztydai1sbjiuktgkyyasu03}</td><td>（中継用）第１死亡時受取額（円貨）（円安）０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sibousnenoutouymd4 ztydai1sibousnenoutouymd4}</td><td>（中継用）第１死亡保険金額年単位応当年月日０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktype04 ztydai1stuuktype04}</td><td>（中継用）第１死亡保険金額通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1s04 ztydai1s04}</td><td>（中継用）第１死亡保険金額０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumu04 ztydai1syenyendakaumu04}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunumu04 ztydai1syenyenkijyunumu04}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumu04 ztydai1syenyenyasuumu04}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktype04 ztydai1syentuuktype04}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendaka04 ztydai1syenyendaka04}</td><td>（中継用）第１死亡保険金額（円貨）（円高）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyun04 ztydai1syenyenkijyun04}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasu04 ztydai1syenyenyasu04}</td><td>（中継用）第１死亡保険金額（円貨）（円安）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndk04 ztydai1zennouzndk04}</td><td>（中継用）第１前納残高０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndktype04 ztydai1zennouzndktype04}</td><td>（中継用）第１前納残高通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgk04 ztydai1sbjiuktgk04}</td><td>（中継用）第１死亡時受取額０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgktype04 ztydai1sbjiuktgktype04}</td><td>（中継用）第１死亡時受取額通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkytype04 ztydai1sbjiuktgkytype04}</td><td>（中継用）第１死亡時受取額（円貨）通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkydaka04 ztydai1sbjiuktgkydaka04}</td><td>（中継用）第１死亡時受取額（円貨）（円高）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkykijyun04 ztydai1sbjiuktgkykijyun04}</td><td>（中継用）第１死亡時受取額（円貨）（中央値）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkyyasu04 ztydai1sbjiuktgkyyasu04}</td><td>（中継用）第１死亡時受取額（円貨）（円安）０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sibousnenoutouymd5 ztydai1sibousnenoutouymd5}</td><td>（中継用）第１死亡保険金額年単位応当年月日０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktype05 ztydai1stuuktype05}</td><td>（中継用）第１死亡保険金額通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1s05 ztydai1s05}</td><td>（中継用）第１死亡保険金額０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumu05 ztydai1syenyendakaumu05}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunumu05 ztydai1syenyenkijyunumu05}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumu05 ztydai1syenyenyasuumu05}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktype05 ztydai1syentuuktype05}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendaka05 ztydai1syenyendaka05}</td><td>（中継用）第１死亡保険金額（円貨）（円高）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyun05 ztydai1syenyenkijyun05}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasu05 ztydai1syenyenyasu05}</td><td>（中継用）第１死亡保険金額（円貨）（円安）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndk05 ztydai1zennouzndk05}</td><td>（中継用）第１前納残高０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndktype05 ztydai1zennouzndktype05}</td><td>（中継用）第１前納残高通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgk05 ztydai1sbjiuktgk05}</td><td>（中継用）第１死亡時受取額０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgktype05 ztydai1sbjiuktgktype05}</td><td>（中継用）第１死亡時受取額通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkytype05 ztydai1sbjiuktgkytype05}</td><td>（中継用）第１死亡時受取額（円貨）通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkydaka05 ztydai1sbjiuktgkydaka05}</td><td>（中継用）第１死亡時受取額（円貨）（円高）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkykijyun05 ztydai1sbjiuktgkykijyun05}</td><td>（中継用）第１死亡時受取額（円貨）（中央値）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkyyasu05 ztydai1sbjiuktgkyyasu05}</td><td>（中継用）第１死亡時受取額（円貨）（円安）０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sibousnenoutouymd6 ztydai1sibousnenoutouymd6}</td><td>（中継用）第１死亡保険金額年単位応当年月日０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktype06 ztydai1stuuktype06}</td><td>（中継用）第１死亡保険金額通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1s06 ztydai1s06}</td><td>（中継用）第１死亡保険金額０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumu06 ztydai1syenyendakaumu06}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunumu06 ztydai1syenyenkijyunumu06}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumu06 ztydai1syenyenyasuumu06}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktype06 ztydai1syentuuktype06}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendaka06 ztydai1syenyendaka06}</td><td>（中継用）第１死亡保険金額（円貨）（円高）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyun06 ztydai1syenyenkijyun06}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasu06 ztydai1syenyenyasu06}</td><td>（中継用）第１死亡保険金額（円貨）（円安）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndk06 ztydai1zennouzndk06}</td><td>（中継用）第１前納残高０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1zennouzndktype06 ztydai1zennouzndktype06}</td><td>（中継用）第１前納残高通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgk06 ztydai1sbjiuktgk06}</td><td>（中継用）第１死亡時受取額０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgktype06 ztydai1sbjiuktgktype06}</td><td>（中継用）第１死亡時受取額通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkytype06 ztydai1sbjiuktgkytype06}</td><td>（中継用）第１死亡時受取額（円貨）通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkydaka06 ztydai1sbjiuktgkydaka06}</td><td>（中継用）第１死亡時受取額（円貨）（円高）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkykijyun06 ztydai1sbjiuktgkykijyun06}</td><td>（中継用）第１死亡時受取額（円貨）（中央値）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sbjiuktgkyyasu06 ztydai1sbjiuktgkyyasu06}</td><td>（中継用）第１死亡時受取額（円貨）（円安）０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sibousnenoutouymd7 ztydai1sibousnenoutouymd7}</td><td>（中継用）第１死亡保険金額年単位応当年月日０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktype07 ztydai1stuuktype07}</td><td>（中継用）第１死亡保険金額通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1s07 ztydai1s07}</td><td>（中継用）第１死亡保険金額０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumu07 ztydai1syenyendakaumu07}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunumu07 ztydai1syenyenkijyunumu07}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumu07 ztydai1syenyenyasuumu07}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktype07 ztydai1syentuuktype07}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendaka07 ztydai1syenyendaka07}</td><td>（中継用）第１死亡保険金額（円貨）（円高）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyun07 ztydai1syenyenkijyun07}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasu07 ztydai1syenyenyasu07}</td><td>（中継用）第１死亡保険金額（円貨）（円安）０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sibousnenoutouymd8 ztydai1sibousnenoutouymd8}</td><td>（中継用）第１死亡保険金額年単位応当年月日０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktype08 ztydai1stuuktype08}</td><td>（中継用）第１死亡保険金額通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1s08 ztydai1s08}</td><td>（中継用）第１死亡保険金額０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumu08 ztydai1syenyendakaumu08}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunumu08 ztydai1syenyenkijyunumu08}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumu08 ztydai1syenyenyasuumu08}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktype08 ztydai1syentuuktype08}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendaka08 ztydai1syenyendaka08}</td><td>（中継用）第１死亡保険金額（円貨）（円高）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyun08 ztydai1syenyenkijyun08}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasu08 ztydai1syenyenyasu08}</td><td>（中継用）第１死亡保険金額（円貨）（円安）０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sibousnenoutouymd9 ztydai1sibousnenoutouymd9}</td><td>（中継用）第１死亡保険金額年単位応当年月日０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktype09 ztydai1stuuktype09}</td><td>（中継用）第１死亡保険金額通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1s09 ztydai1s09}</td><td>（中継用）第１死亡保険金額０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumu09 ztydai1syenyendakaumu09}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunumu09 ztydai1syenyenkijyunumu09}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumu09 ztydai1syenyenyasuumu09}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktype09 ztydai1syentuuktype09}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendaka09 ztydai1syenyendaka09}</td><td>（中継用）第１死亡保険金額（円貨）（円高）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyun09 ztydai1syenyenkijyun09}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasu09 ztydai1syenyenyasu09}</td><td>（中継用）第１死亡保険金額（円貨）（円安）０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1sibousnenoutouymd10 ztydai1sibousnenoutouymd10}</td><td>（中継用）第１死亡保険金額年単位応当年月日１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktype10 ztydai1stuuktype10}</td><td>（中継用）第１死亡保険金額通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1s10 ztydai1s10}</td><td>（中継用）第１死亡保険金額１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumu10 ztydai1syenyendakaumu10}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunumu10 ztydai1syenyenkijyunumu10}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumu10 ztydai1syenyenyasuumu10}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktype10 ztydai1syentuuktype10}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendaka10 ztydai1syenyendaka10}</td><td>（中継用）第１死亡保険金額（円貨）（円高）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyun10 ztydai1syenyenkijyun10}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasu10 ztydai1syenyenyasu10}</td><td>（中継用）第１死亡保険金額（円貨）（円安）１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1stuuktypehuryo ztydai1stuuktypehuryo}</td><td>（中継用）第１死亡保険金額通貨タイプ（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1shuryo ztydai1shuryo}</td><td>（中継用）第１死亡保険金額（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakaumuhuryo ztydai1syenyendakaumuhuryo}</td><td>（中継用）第１死亡保険金額（円貨）（円高）丸印有無（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkjnumuhuryo ztydai1syenyenkjnumuhuryo}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）丸印有無（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuumuhuryo ztydai1syenyenyasuumuhuryo}</td><td>（中継用）第１死亡保険金額（円貨）（円安）丸印有無（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syentuuktypehuryo ztydai1syentuuktypehuryo}</td><td>（中継用）第１死亡保険金額（円貨）通貨タイプ（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyendakahuryo ztydai1syenyendakahuryo}</td><td>（中継用）第１死亡保険金額（円貨）（円高）（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenkijyunhuryo ztydai1syenyenkijyunhuryo}</td><td>（中継用）第１死亡保険金額（円貨）（中央値）（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1syenyenyasuhuryo ztydai1syenyenyasuhuryo}</td><td>（中継用）第１死亡保険金額（円貨）（円安）（不慮）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2stuuktype ztydai2stuuktype}</td><td>（中継用）第２死亡保険金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2s ztydai2s}</td><td>（中継用）第２死亡保険金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2syentuuktype ztydai2syentuuktype}</td><td>（中継用）第２死亡保険金額（円貨）通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2syenyendaka ztydai2syenyendaka}</td><td>（中継用）第２死亡保険金額（円貨）（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2syenyenkijyun ztydai2syenyenkijyun}</td><td>（中継用）第２死亡保険金額（円貨）（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2syenyenyasu ztydai2syenyenyasu}</td><td>（中継用）第２死亡保険金額（円貨）（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai3stuuktype ztydai3stuuktype}</td><td>（中継用）第３死亡保険金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai3s ztydai3s}</td><td>（中継用）第３死亡保険金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai3syentuuktype ztydai3syentuuktype}</td><td>（中継用）第３死亡保険金額（円貨）通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai3syenyendaka ztydai3syenyendaka}</td><td>（中継用）第３死亡保険金額（円貨）（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai3syenyenkijyun ztydai3syenyenkijyun}</td><td>（中継用）第３死亡保険金額（円貨）（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai3syenyenyasu ztydai3syenyenyasu}</td><td>（中継用）第３死亡保険金額（円貨）（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibouinjiptnkbn ztysibouinjiptnkbn}</td><td>（中継用）死亡保障印字パターン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv25 ztyyobiv25}</td><td>（中継用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkmsgcd1 ztynkmsgcd1}</td><td>（中継用）年金メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkmsgcd2 ztynkmsgcd2}</td><td>（中継用）年金メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkmsgcd3 ztynkmsgcd3}</td><td>（中継用）年金メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkmsgcd4 ztynkmsgcd4}</td><td>（中継用）年金メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkmsgcd5 ztynkmsgcd5}</td><td>（中継用）年金メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkmsgcd6 ztynkmsgcd6}</td><td>（中継用）年金メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkmsgcd7 ztynkmsgcd7}</td><td>（中継用）年金メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkmsgcd8 ztynkmsgcd8}</td><td>（中継用）年金メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkmsgcd9 ztynkmsgcd9}</td><td>（中継用）年金メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkmsgcd10 ztynkmsgcd10}</td><td>（中継用）年金メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukinmsgcd1 ztysiboukyuuhukinmsgcd1}</td><td>（中継用）死亡給付金メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukinmsgcd2 ztysiboukyuuhukinmsgcd2}</td><td>（中継用）死亡給付金メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukinmsgcd3 ztysiboukyuuhukinmsgcd3}</td><td>（中継用）死亡給付金メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukinmsgcd4 ztysiboukyuuhukinmsgcd4}</td><td>（中継用）死亡給付金メッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukinmsgcd5 ztysiboukyuuhukinmsgcd5}</td><td>（中継用）死亡給付金メッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukinmsgcd6 ztysiboukyuuhukinmsgcd6}</td><td>（中継用）死亡給付金メッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukinmsgcd7 ztysiboukyuuhukinmsgcd7}</td><td>（中継用）死亡給付金メッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukinmsgcd8 ztysiboukyuuhukinmsgcd8}</td><td>（中継用）死亡給付金メッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukinmsgcd9 ztysiboukyuuhukinmsgcd9}</td><td>（中継用）死亡給付金メッセージコード９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukinmsgcd10 ztysiboukyuuhukinmsgcd10}</td><td>（中継用）死亡給付金メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrstartzenymd ztynkshrstartzenymd}</td><td>（中継用）年金支払開始日前日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyouyennkhknhentktype ztymkhyouyennkhknhentktype}</td><td>（中継用）目標到達時円建年金保険変更特約目標額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyouyennkhknhentkmkhgk ztymkhyouyennkhknhentkmkhgk}</td><td>（中継用）目標到達時円建年金保険変更特約目標額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyennkhknhentkmkhwari ztymkhyennkhknhentkmkhwari}</td><td>（中継用）目標到達時円建年金保険変更特約目標割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaibunwarimsgcd1 ztyhaibunwarimsgcd1}</td><td>（中継用）配分割合メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaibunwarimsgcd2 ztyhaibunwarimsgcd2}</td><td>（中継用）配分割合メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaibunwarimsgcd3 ztyhaibunwarimsgcd3}</td><td>（中継用）配分割合メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteiritutmtthbnwr ztyteiritutmtthbnwr}</td><td>（中継用）定率積立部分配分割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuutmtthbnwr ztysisuutmtthbnwr}</td><td>（中継用）指数積立部分配分割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuannaimsg1 ztysisuuannaimsg1}</td><td>（中継用）指数案内メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuannaimsg2 ztysisuuannaimsg2}</td><td>（中継用）指数案内メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuuannaimsg3 ztysisuuannaimsg3}</td><td>（中継用）指数案内メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyouyensysnikoumsgcd ztymkhyouyensysnikoumsgcd}</td><td>（中継用）目標到達時円建終身保険移行特約メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyouyensysnikoumsgcd2 ztymkhyouyensysnikoumsgcd2}</td><td>（中継用）目標到達時円建終身保険移行特約メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyouyensysnikoumsgcd3 ztymkhyouyensysnikoumsgcd3}</td><td>（中継用）目標到達時円建終身保険移行特約メッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyouyensysnikougktype ztymkhyouyensysnikougktype}</td><td>（中継用）目標到達時円建終身保険移行特約目標額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyouyensysnikougk ztymkhyouyensysnikougk}</td><td>（中継用）目標到達時円建終身保険移行特約目標額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyouyensysnikouwra ztymkhyouyensysnikouwra}</td><td>（中継用）目標到達時円建終身保険移行特約目標割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyouysysnikcurrentgk ztymkhyouysysnikcurrentgk}</td><td>（中継用）目標到達時円建終身保険移行特約現在の目標額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv12 ztyyobiv12}</td><td>（中継用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrtkykmsgcd1 ztykaigomaehrtkykmsgcd1}</td><td>（中継用）介護前払特約メッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrtkykmsgcd2 ztykaigomaehrtkykmsgcd2}</td><td>（中継用）介護前払特約メッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrtkykmsgcdst1 ztykaigomaehrtkykmsgcdst1}</td><td>（中継用）介護前払特約メッセージコード表下１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrtkykmsgcdst2 ztykaigomaehrtkykmsgcdst2}</td><td>（中継用）介護前払特約メッセージコード表下２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrtkhknkkn1mnryymd ztykgmaehrtkhknkkn1mnryymd}</td><td>（中継用）介護前払特約第１保険期間満了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrtkykitrnumu ztykaigomaehrtkykitrnumu}</td><td>（中継用）介護前払特約受取額一覧有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrtkykkyktuuka ztykaigomaehrtkykkyktuuka}</td><td>（中継用）介護前払特約契約通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrtkykstdmsgcd ztykaigomaehrtkykstdmsgcd}</td><td>（中継用）介護前払特約指定代理メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugktype ztykaigomaehrjrugktype}</td><td>（中継用）介護前払受領額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrsikuhhknnen01 ztykaigomaehrsikuhhknnen01}</td><td>（中継用）介護前払請求日時点被保険者年齢０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrstikkn01 ztykaigomaehrstikkn01}</td><td>（中継用）介護前払所定期間０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugk01 ztykaigomaehrjrugk01}</td><td>（中継用）介護前払受領額０１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrsikuhhknnen02 ztykaigomaehrsikuhhknnen02}</td><td>（中継用）介護前払請求日時点被保険者年齢０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrstikkn02 ztykaigomaehrstikkn02}</td><td>（中継用）介護前払所定期間０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugk02 ztykaigomaehrjrugk02}</td><td>（中継用）介護前払受領額０２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrsikuhhknnen03 ztykaigomaehrsikuhhknnen03}</td><td>（中継用）介護前払請求日時点被保険者年齢０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrstikkn03 ztykaigomaehrstikkn03}</td><td>（中継用）介護前払所定期間０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugk03 ztykaigomaehrjrugk03}</td><td>（中継用）介護前払受領額０３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrsikuhhknnen04 ztykaigomaehrsikuhhknnen04}</td><td>（中継用）介護前払請求日時点被保険者年齢０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrstikkn04 ztykaigomaehrstikkn04}</td><td>（中継用）介護前払所定期間０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugk04 ztykaigomaehrjrugk04}</td><td>（中継用）介護前払受領額０４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrsikuhhknnen05 ztykaigomaehrsikuhhknnen05}</td><td>（中継用）介護前払請求日時点被保険者年齢０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrstikkn05 ztykaigomaehrstikkn05}</td><td>（中継用）介護前払所定期間０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugk05 ztykaigomaehrjrugk05}</td><td>（中継用）介護前払受領額０５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrsikuhhknnen06 ztykaigomaehrsikuhhknnen06}</td><td>（中継用）介護前払請求日時点被保険者年齢０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrstikkn06 ztykaigomaehrstikkn06}</td><td>（中継用）介護前払所定期間０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugk06 ztykaigomaehrjrugk06}</td><td>（中継用）介護前払受領額０６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrsikuhhknnen07 ztykaigomaehrsikuhhknnen07}</td><td>（中継用）介護前払請求日時点被保険者年齢０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrstikkn07 ztykaigomaehrstikkn07}</td><td>（中継用）介護前払所定期間０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugk07 ztykaigomaehrjrugk07}</td><td>（中継用）介護前払受領額０７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrsikuhhknnen08 ztykaigomaehrsikuhhknnen08}</td><td>（中継用）介護前払請求日時点被保険者年齢０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrstikkn08 ztykaigomaehrstikkn08}</td><td>（中継用）介護前払所定期間０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugk08 ztykaigomaehrjrugk08}</td><td>（中継用）介護前払受領額０８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrsikuhhknnen09 ztykaigomaehrsikuhhknnen09}</td><td>（中継用）介護前払請求日時点被保険者年齢０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrstikkn09 ztykaigomaehrstikkn09}</td><td>（中継用）介護前払所定期間０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugk09 ztykaigomaehrjrugk09}</td><td>（中継用）介護前払受領額０９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrsikuhhknnen10 ztykaigomaehrsikuhhknnen10}</td><td>（中継用）介護前払請求日時点被保険者年齢１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrstikkn10 ztykaigomaehrstikkn10}</td><td>（中継用）介護前払所定期間１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugk10 ztykaigomaehrjrugk10}</td><td>（中継用）介護前払受領額１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugkydaka01 ztykaigomaehrjrugkydaka01}</td><td>（中継用）介護前払受領額０１（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkykijyun01 ztykgmaehrjrugkykijyun01}</td><td>（中継用）介護前払受領額０１（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkyyasu01 ztykgmaehrjrugkyyasu01}</td><td>（中継用）介護前払受領額０１（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugkydaka02 ztykaigomaehrjrugkydaka02}</td><td>（中継用）介護前払受領額０２（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkykijyun02 ztykgmaehrjrugkykijyun02}</td><td>（中継用）介護前払受領額０２（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkyyasu02 ztykgmaehrjrugkyyasu02}</td><td>（中継用）介護前払受領額０２（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugkydaka03 ztykaigomaehrjrugkydaka03}</td><td>（中継用）介護前払受領額０３（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkykijyun03 ztykgmaehrjrugkykijyun03}</td><td>（中継用）介護前払受領額０３（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkyyasu03 ztykgmaehrjrugkyyasu03}</td><td>（中継用）介護前払受領額０３（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugkydaka04 ztykaigomaehrjrugkydaka04}</td><td>（中継用）介護前払受領額０４（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkykijyun04 ztykgmaehrjrugkykijyun04}</td><td>（中継用）介護前払受領額０４（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkyyasu04 ztykgmaehrjrugkyyasu04}</td><td>（中継用）介護前払受領額０４（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugkydaka05 ztykaigomaehrjrugkydaka05}</td><td>（中継用）介護前払受領額０５（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkykijyun05 ztykgmaehrjrugkykijyun05}</td><td>（中継用）介護前払受領額０５（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkyyasu05 ztykgmaehrjrugkyyasu05}</td><td>（中継用）介護前払受領額０５（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugkydaka06 ztykaigomaehrjrugkydaka06}</td><td>（中継用）介護前払受領額０６（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkykijyun06 ztykgmaehrjrugkykijyun06}</td><td>（中継用）介護前払受領額０６（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkyyasu06 ztykgmaehrjrugkyyasu06}</td><td>（中継用）介護前払受領額０６（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugkydaka07 ztykaigomaehrjrugkydaka07}</td><td>（中継用）介護前払受領額０７（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkykijyun07 ztykgmaehrjrugkykijyun07}</td><td>（中継用）介護前払受領額０７（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkyyasu07 ztykgmaehrjrugkyyasu07}</td><td>（中継用）介護前払受領額０７（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugkydaka08 ztykaigomaehrjrugkydaka08}</td><td>（中継用）介護前払受領額０８（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkykijyun08 ztykgmaehrjrugkykijyun08}</td><td>（中継用）介護前払受領額０８（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkyyasu08 ztykgmaehrjrugkyyasu08}</td><td>（中継用）介護前払受領額０８（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugkydaka09 ztykaigomaehrjrugkydaka09}</td><td>（中継用）介護前払受領額０９（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkykijyun09 ztykgmaehrjrugkykijyun09}</td><td>（中継用）介護前払受領額０９（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkyyasu09 ztykgmaehrjrugkyyasu09}</td><td>（中継用）介護前払受領額０９（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomaehrjrugkydaka10 ztykaigomaehrjrugkydaka10}</td><td>（中継用）介護前払受領額１０（円高）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkykijyun10 ztykgmaehrjrugkykijyun10}</td><td>（中継用）介護前払受領額１０（中央値）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykgmaehrjrugkyyasu10 ztykgmaehrjrugkyyasu10}</td><td>（中継用）介護前払受領額１０（円安）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicemsg1 ztykzktourokuservicemsg1}</td><td>（中継用）ご家族登録サービスメッセージコード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicemsg2 ztykzktourokuservicemsg2}</td><td>（中継用）ご家族登録サービスメッセージコード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicemsg3 ztykzktourokuservicemsg3}</td><td>（中継用）ご家族登録サービスメッセージコード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicemsg4 ztykzktourokuservicemsg4}</td><td>（中継用）ご家族登録サービスメッセージコード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicemsg5 ztykzktourokuservicemsg5}</td><td>（中継用）ご家族登録サービスメッセージコード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicemsg6 ztykzktourokuservicemsg6}</td><td>（中継用）ご家族登録サービスメッセージコード６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicemsg7 ztykzktourokuservicemsg7}</td><td>（中継用）ご家族登録サービスメッセージコード７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicemsg8 ztykzktourokuservicemsg8}</td><td>（中継用）ご家族登録サービスメッセージコード８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzknm118 ztytrkkzknm118}</td><td>（中継用）登録家族名１（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzksei1 ztytrkkzksei1}</td><td>（中継用）登録家族性別１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkseiymd1zenkaku ztytrkkzkseiymd1zenkaku}</td><td>（中継用）登録家族１人目生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkyno1zenkaku ztytrkkzkyno1zenkaku}</td><td>（中継用）登録家族１人目郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkadrkj1 ztytrkkzkadrkj1}</td><td>（中継用）登録家族１人目住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzktelno1zenkaku ztytrkkzktelno1zenkaku}</td><td>（中継用）登録家族１人目電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzknm218 ztytrkkzknm218}</td><td>（中継用）登録家族名２（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzksei2 ztytrkkzksei2}</td><td>（中継用）登録家族性別２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkseiymd2zenkaku ztytrkkzkseiymd2zenkaku}</td><td>（中継用）登録家族２人目生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkyno2zenkaku ztytrkkzkyno2zenkaku}</td><td>（中継用）登録家族２人目郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzkadrkj2 ztytrkkzkadrkj2}</td><td>（中継用）登録家族２人目住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzktelno2zenkaku ztytrkkzktelno2zenkaku}</td><td>（中継用）登録家族２人目電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdairinm18 ztykykdairinm18}</td><td>（中継用）契約者代理人名（１８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkndairinm ztyhhkndairinm}</td><td>（中継用）被保険者代理人氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv100 ztyyobiv100}</td><td>（中継用）予備項目Ｖ１００</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmmsgcdue01 ztyhutanhiyustmmsgcdue01}</td><td>（中継用）ご負担費用説明欄メッセージコード表上１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmmsgcdue02 ztyhutanhiyustmmsgcdue02}</td><td>（中継用）ご負担費用説明欄メッセージコード表上２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmmsgcdue03 ztyhutanhiyustmmsgcdue03}</td><td>（中継用）ご負担費用説明欄メッセージコード表上３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmmsgcdue04 ztyhutanhiyustmmsgcdue04}</td><td>（中継用）ご負担費用説明欄メッセージコード表上４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmknsnhyuptn ztyhutanhiyustmknsnhyuptn}</td><td>（中継用）ご負担費用説明欄換算費用パターン</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmmsgcdst01 ztyhutanhiyustmmsgcdst01}</td><td>（中継用）ご負担費用説明欄メッセージコード表下１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmmsgcdst02 ztyhutanhiyustmmsgcdst02}</td><td>（中継用）ご負担費用説明欄メッセージコード表下２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmmsgcdst03 ztyhutanhiyustmmsgcdst03}</td><td>（中継用）ご負担費用説明欄メッセージコード表下３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmytijihiritu ztyhutanhiyustmytijihiritu}</td><td>（中継用）ご負担費用説明欄予定維持費率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmkyakkjrtmin ztyhutanhiyustmkyakkjrtmin}</td><td>（中継用）ご負担費用説明欄解約控除率最小</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhutanhiyustmkyakkjrtmax ztyhutanhiyustmkyakkjrtmax}</td><td>（中継用）ご負担費用説明欄解約控除率最大</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7x2 ztyyobiv7x2}</td><td>（中継用）予備項目Ｖ７＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdstmmsgcd ztystdstmmsgcd}</td><td>（中継用）指定代理請求特約説明欄メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysioriwebuktriannaimsgcd ztysioriwebuktriannaimsgcd}</td><td>（中継用）しおりＷＥＢ受取案内メッセージコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x2 ztyyobiv10x2}</td><td>（中継用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv69 ztyyobiv69}</td><td>（中継用）予備項目Ｖ６９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SaihakkouHokensyoukenTy
 * @see     PKZT_SaihakkouHokensyoukenTy
 * @see     QZT_SaihakkouHokensyoukenTy
 * @see     GenQZT_SaihakkouHokensyoukenTy
 */
@MappedSuperclass
@Table(name=GenZT_SaihakkouHokensyoukenTy.TABLE_NAME)
@IdClass(value=PKZT_SaihakkouHokensyoukenTy.class)
public abstract class GenZT_SaihakkouHokensyoukenTy extends AbstractExDBEntity<ZT_SaihakkouHokensyoukenTy, PKZT_SaihakkouHokensyoukenTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SaihakkouHokensyoukenTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYKANRYOUTUUTIDOUHUUKBN = "ztykanryoutuutidouhuukbn";
    public static final String ZTYSIKIBETUNO            = "ztysikibetuno";
    public static final String ZTYSTDRSKTIRASIDOUHUUKBN = "ztystdrsktirasidouhuukbn";
    public static final String ZTYAISYOUMEIKBN          = "ztyaisyoumeikbn";
    public static final String ZTYSAGYOUKBN             = "ztysagyoukbn";
    public static final String ZTYYAKKANBUNSYONO        = "ztyyakkanbunsyono";
    public static final String ZTYYOBIV23X2             = "ztyyobiv23x2";
    public static final String ZTYHYOUJIRANHIDARIMSGCD1 = "ztyhyoujiranhidarimsgcd1";
    public static final String ZTYHYOUJIRANHIDARIMSGCD2 = "ztyhyoujiranhidarimsgcd2";
    public static final String ZTYHYOUJIRANHIDARIMSGCD3 = "ztyhyoujiranhidarimsgcd3";
    public static final String ZTYHYOUJIRANHIDARIMSGCD4 = "ztyhyoujiranhidarimsgcd4";
    public static final String ZTYHYOUJIRANHIDARIMSGCD5 = "ztyhyoujiranhidarimsgcd5";
    public static final String ZTYHYOUJIRANHIDARIMSGCD6 = "ztyhyoujiranhidarimsgcd6";
    public static final String ZTYHYOUJIRANHIDARIMSGCD7 = "ztyhyoujiranhidarimsgcd7";
    public static final String ZTYHYOUJIRANHIDARIMSGCD8 = "ztyhyoujiranhidarimsgcd8";
    public static final String ZTYHYOUJIRANHIDARIMSGCD9 = "ztyhyoujiranhidarimsgcd9";
    public static final String ZTYHYOUJIRANHIDARIMSGCD10 = "ztyhyoujiranhidarimsgcd10";
    public static final String ZTYHYOUJIRANHIDARIMSGCD11 = "ztyhyoujiranhidarimsgcd11";
    public static final String ZTYHYOUJIRANHIDARIMSGCD12 = "ztyhyoujiranhidarimsgcd12";
    public static final String ZTYHYOUJIRANHIDARIMSGCD13 = "ztyhyoujiranhidarimsgcd13";
    public static final String ZTYHYOUJIRANHIDARIMSGCD14 = "ztyhyoujiranhidarimsgcd14";
    public static final String ZTYHYOUJIRANHIDARIMSGCD15 = "ztyhyoujiranhidarimsgcd15";
    public static final String ZTYHYOUJIRANHIDARIMSGCD16 = "ztyhyoujiranhidarimsgcd16";
    public static final String ZTYHYOUJIRANHIDARIMSGCD17 = "ztyhyoujiranhidarimsgcd17";
    public static final String ZTYHYOUJIRANHIDARIMSGCD18 = "ztyhyoujiranhidarimsgcd18";
    public static final String ZTYHYOUJIRANHIDARIMSGCD19 = "ztyhyoujiranhidarimsgcd19";
    public static final String ZTYHYOUJIRANHIDARIMSGCD20 = "ztyhyoujiranhidarimsgcd20";
    public static final String ZTYHYOUJIRANMIGIMSGCD1   = "ztyhyoujiranmigimsgcd1";
    public static final String ZTYHYOUJIRANMIGIMSGCD2   = "ztyhyoujiranmigimsgcd2";
    public static final String ZTYHYOUJIRANMIGIMSGCD3   = "ztyhyoujiranmigimsgcd3";
    public static final String ZTYHYOUJIRANMIGIMSGCD4   = "ztyhyoujiranmigimsgcd4";
    public static final String ZTYHYOUJIRANMIGIMSGCD5   = "ztyhyoujiranmigimsgcd5";
    public static final String ZTYHYOUJIRANMIGIMSGCD6   = "ztyhyoujiranmigimsgcd6";
    public static final String ZTYHYOUJIRANMIGIMSGCD7   = "ztyhyoujiranmigimsgcd7";
    public static final String ZTYHYOUJIRANMIGIMSGCD8   = "ztyhyoujiranmigimsgcd8";
    public static final String ZTYHYOUJIRANMIGIMSGCD9   = "ztyhyoujiranmigimsgcd9";
    public static final String ZTYHYOUJIRANMIGIMSGCD10  = "ztyhyoujiranmigimsgcd10";
    public static final String ZTYHYOUJIRANMIGIMSGCD11  = "ztyhyoujiranmigimsgcd11";
    public static final String ZTYHYOUJIRANMIGIMSGCD12  = "ztyhyoujiranmigimsgcd12";
    public static final String ZTYHYOUJIRANMIGIMSGCD13  = "ztyhyoujiranmigimsgcd13";
    public static final String ZTYHYOUJIRANMIGIMSGCD14  = "ztyhyoujiranmigimsgcd14";
    public static final String ZTYHYOUJIRANMIGIMSGCD15  = "ztyhyoujiranmigimsgcd15";
    public static final String ZTYHYOUJIRANMIGIMSGCD16  = "ztyhyoujiranmigimsgcd16";
    public static final String ZTYHYOUJIRANMIGIMSGCD17  = "ztyhyoujiranmigimsgcd17";
    public static final String ZTYHYOUJIRANMIGIMSGCD18  = "ztyhyoujiranmigimsgcd18";
    public static final String ZTYHYOUJIRANMIGIMSGCD19  = "ztyhyoujiranmigimsgcd19";
    public static final String ZTYHYOUJIRANMIGIMSGCD20  = "ztyhyoujiranmigimsgcd20";
    public static final String ZTYSKNNKAISIYMDSEIREKI   = "ztysknnkaisiymdseireki";
    public static final String ZTYHYOUJIRANYTIRRT       = "ztyhyoujiranytirrt";
    public static final String ZTYHYOUJIRANSJKKKTUSIRRT = "ztyhyoujiransjkkktusirrt";
    public static final String ZTYHYOUJIRANTUMITATERIRITU = "ztyhyoujirantumitateriritu";
    public static final String ZTYHYOUJIRANTUMITATERIRITU2 = "ztyhyoujirantumitateriritu2";
    public static final String ZTYHYOUJIRANTMTTKNZKRTJYGN = "ztyhyoujirantmttknzkrtjygn";
    public static final String ZTYHYOUJIRANSETTEIBAIRITU = "ztyhyoujiransetteibairitu";
    public static final String ZTYYOBIV22X11            = "ztyyobiv22x11";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYSYOUKENHAKKOUYMD      = "ztysyoukenhakkouymd";
    public static final String ZTYKOURYOKUKAISIMSG      = "ztykouryokukaisimsg";
    public static final String ZTYSEISIKIHKNNMSYOUKEN   = "ztyseisikihknnmsyouken";
    public static final String ZTYNKSYURUINMSYOUKEN     = "ztynksyuruinmsyouken";
    public static final String ZTYYOBIV116              = "ztyyobiv116";
    public static final String ZTYKYKNMKJ               = "ztykyknmkj";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYHIHKNSYASEIYMDWAREKI  = "ztyhihknsyaseiymdwareki";
    public static final String ZTYHHKNSEI               = "ztyhhknsei";
    public static final String ZTYHHKNNEN2              = "ztyhhknnen2";
    public static final String ZTYUKTMIDASIKBN1         = "ztyuktmidasikbn1";
    public static final String ZTYUKTKBN1               = "ztyuktkbn1";
    public static final String ZTYUKTNM1                = "ztyuktnm1";
    public static final String ZTYUKTBNWARI1            = "ztyuktbnwari1";
    public static final String ZTYUKTMIDASIKBN2         = "ztyuktmidasikbn2";
    public static final String ZTYUKTKBN2               = "ztyuktkbn2";
    public static final String ZTYUKTNM2                = "ztyuktnm2";
    public static final String ZTYUKTBNWARI2            = "ztyuktbnwari2";
    public static final String ZTYUKTMIDASIKBN3         = "ztyuktmidasikbn3";
    public static final String ZTYUKTKBN3               = "ztyuktkbn3";
    public static final String ZTYUKTNM3                = "ztyuktnm3";
    public static final String ZTYUKTBNWARI3            = "ztyuktbnwari3";
    public static final String ZTYUKTMIDASIKBN4         = "ztyuktmidasikbn4";
    public static final String ZTYUKTKBN4               = "ztyuktkbn4";
    public static final String ZTYUKTNM4                = "ztyuktnm4";
    public static final String ZTYUKTBNWARI4            = "ztyuktbnwari4";
    public static final String ZTYUKTMIDASIKBN5         = "ztyuktmidasikbn5";
    public static final String ZTYUKTKBN5               = "ztyuktkbn5";
    public static final String ZTYUKTNM5                = "ztyuktnm5";
    public static final String ZTYUKTBNWARI5            = "ztyuktbnwari5";
    public static final String ZTYUKTMIDASIKBN6         = "ztyuktmidasikbn6";
    public static final String ZTYUKTKBN6               = "ztyuktkbn6";
    public static final String ZTYUKTNM6                = "ztyuktnm6";
    public static final String ZTYUKTBNWARI6            = "ztyuktbnwari6";
    public static final String ZTYUKTMIDASIKBN7         = "ztyuktmidasikbn7";
    public static final String ZTYUKTKBN7               = "ztyuktkbn7";
    public static final String ZTYUKTNM7                = "ztyuktnm7";
    public static final String ZTYUKTBNWARI7            = "ztyuktbnwari7";
    public static final String ZTYUKTMIDASIKBN8         = "ztyuktmidasikbn8";
    public static final String ZTYUKTKBN8               = "ztyuktkbn8";
    public static final String ZTYUKTNM8                = "ztyuktnm8";
    public static final String ZTYUKTBNWARI8            = "ztyuktbnwari8";
    public static final String ZTYUKTMIDASIKBN9         = "ztyuktmidasikbn9";
    public static final String ZTYUKTKBN9               = "ztyuktkbn9";
    public static final String ZTYUKTNM9                = "ztyuktnm9";
    public static final String ZTYUKTBNWARI9            = "ztyuktbnwari9";
    public static final String ZTYUKTMIDASIKBN10        = "ztyuktmidasikbn10";
    public static final String ZTYUKTKBN10              = "ztyuktkbn10";
    public static final String ZTYUKTNM10               = "ztyuktnm10";
    public static final String ZTYUKTBNWARI10           = "ztyuktbnwari10";
    public static final String ZTYYOBIV45               = "ztyyobiv45";
    public static final String ZTYPMSGCD1               = "ztypmsgcd1";
    public static final String ZTYPMSGCD2               = "ztypmsgcd2";
    public static final String ZTYPMSGCD3               = "ztypmsgcd3";
    public static final String ZTYYOBIV10               = "ztyyobiv10";
    public static final String ZTYPTUUKATYPE            = "ztyptuukatype";
    public static final String ZTYPKNGK                 = "ztypkngk";
    public static final String ZTYPKNGKTUUKA            = "ztypkngktuuka";
    public static final String ZTYTEIKIIKKATUBARAITUKISUU = "ztyteikiikkatubaraitukisuu";
    public static final String ZTYZTIKIKTBRIYHRKGKTUKTYPE = "ztyztikiktbriyhrkgktuktype";
    public static final String ZTYZNNTIKIKTBRIYENHRKGK  = "ztyznntikiktbriyenhrkgk";
    public static final String ZTYZNNKAI                = "ztyznnkai";
    public static final String ZTYPTOKUYAKUMSGCD        = "ztyptokuyakumsgcd";
    public static final String ZTYTIKIKTBRIYHRKGKTUKTYPE = "ztytikiktbriyhrkgktuktype";
    public static final String ZTYTIKIKTBRIYENHRKGK     = "ztytikiktbriyenhrkgk";
    public static final String ZTYYOBIV32               = "ztyyobiv32";
    public static final String ZTYKYKYMDSEIREKI         = "ztykykymdseireki";
    public static final String ZTYPHRKKKNMIDASIKBN      = "ztyphrkkknmidasikbn";
    public static final String ZTYHRKKKNMSGKBN          = "ztyhrkkknmsgkbn";
    public static final String ZTYHRKKAISUUMSGKBN       = "ztyhrkkaisuumsgkbn";
    public static final String ZTYPHRKKTUKI             = "ztyphrkktuki";
    public static final String ZTYHRKHOUHOUMSGKBN       = "ztyhrkhouhoumsgkbn";
    public static final String ZTYYOBIV18               = "ztyyobiv18";
    public static final String ZTYSYUKYKTKYKRENBAN1     = "ztysyukyktkykrenban1";
    public static final String ZTYSYUKYKTKYKMSGKBN1     = "ztysyukyktkykmsgkbn1";
    public static final String ZTYSYUKYKTKYKSMSGKBN1    = "ztysyukyktkyksmsgkbn1";
    public static final String ZTYSYUKYKTKYKHKNKKNMSGKBN1 = "ztysyukyktkykhknkknmsgkbn1";
    public static final String ZTYSYUKYKTKYKSTUUKATYPE1 = "ztysyukyktkykstuukatype1";
    public static final String ZTYSYUKYKTKYKHKNKNGK1    = "ztysyukyktkykhknkngk1";
    public static final String ZTYSYUTKDAI1HKNKKNYMDTO1 = "ztysyutkdai1hknkknymdto1";
    public static final String ZTYSYUTKDAI2HKNKKNYMDTO1 = "ztysyutkdai2hknkknymdto1";
    public static final String ZTYYOBIV22               = "ztyyobiv22";
    public static final String ZTYSYUKYKTKYKRENBAN2     = "ztysyukyktkykrenban2";
    public static final String ZTYSYUKYKTKYKMSGKBN2     = "ztysyukyktkykmsgkbn2";
    public static final String ZTYSYUKYKTKYKSMSGKBN2    = "ztysyukyktkyksmsgkbn2";
    public static final String ZTYSYUKYKTKYKHKNKKNMSGKBN2 = "ztysyukyktkykhknkknmsgkbn2";
    public static final String ZTYSYUKYKTKYKSTUUKATYPE2 = "ztysyukyktkykstuukatype2";
    public static final String ZTYSYUKYKTKYKHKNKNGK2    = "ztysyukyktkykhknkngk2";
    public static final String ZTYSYUTKDAI1HKNKKNYMDTO2 = "ztysyutkdai1hknkknymdto2";
    public static final String ZTYSYUTKDAI2HKNKKNYMDTO2 = "ztysyutkdai2hknkknymdto2";
    public static final String ZTYYOBIV22X2             = "ztyyobiv22x2";
    public static final String ZTYSYUKYKTKYKRENBAN3     = "ztysyukyktkykrenban3";
    public static final String ZTYSYUKYKTKYKMSGKBN3     = "ztysyukyktkykmsgkbn3";
    public static final String ZTYSYUKYKTKYKSMSGKBN3    = "ztysyukyktkyksmsgkbn3";
    public static final String ZTYSYUKYKTKYKHKNKKNMSGKBN3 = "ztysyukyktkykhknkknmsgkbn3";
    public static final String ZTYSYUKYKTKYKSTUUKATYPE3 = "ztysyukyktkykstuukatype3";
    public static final String ZTYSYUKYKTKYKHKNKNGK3    = "ztysyukyktkykhknkngk3";
    public static final String ZTYSYUTKDAI1HKNKKNYMDTO3 = "ztysyutkdai1hknkknymdto3";
    public static final String ZTYSYUTKDAI2HKNKKNYMDTO3 = "ztysyutkdai2hknkknymdto3";
    public static final String ZTYYOBIV22X3             = "ztyyobiv22x3";
    public static final String ZTYSYUKYKTKYKRENBAN4     = "ztysyukyktkykrenban4";
    public static final String ZTYSYUKYKTKYKMSGKBN4     = "ztysyukyktkykmsgkbn4";
    public static final String ZTYSYUKYKTKYKSMSGKBN4    = "ztysyukyktkyksmsgkbn4";
    public static final String ZTYSYUKYKTKYKHKNKKNMSGKBN4 = "ztysyukyktkykhknkknmsgkbn4";
    public static final String ZTYSYUKYKTKYKSTUUKATYPE4 = "ztysyukyktkykstuukatype4";
    public static final String ZTYSYUKYKTKYKHKNKNGK4    = "ztysyukyktkykhknkngk4";
    public static final String ZTYSYUTKDAI1HKNKKNYMDTO4 = "ztysyutkdai1hknkknymdto4";
    public static final String ZTYSYUTKDAI2HKNKKNYMDTO4 = "ztysyutkdai2hknkknymdto4";
    public static final String ZTYYOBIV22X4             = "ztyyobiv22x4";
    public static final String ZTYSYUKYKTKYKRENBAN5     = "ztysyukyktkykrenban5";
    public static final String ZTYSYUKYKTKYKMSGKBN5     = "ztysyukyktkykmsgkbn5";
    public static final String ZTYSYUKYKTKYKSMSGKBN5    = "ztysyukyktkyksmsgkbn5";
    public static final String ZTYSYUKYKTKYKHKNKKNMSGKBN5 = "ztysyukyktkykhknkknmsgkbn5";
    public static final String ZTYSYUKYKTKYKSTUUKATYPE5 = "ztysyukyktkykstuukatype5";
    public static final String ZTYSYUKYKTKYKHKNKNGK5    = "ztysyukyktkykhknkngk5";
    public static final String ZTYSYUTKDAI1HKNKKNYMDTO5 = "ztysyutkdai1hknkknymdto5";
    public static final String ZTYSYUTKDAI2HKNKKNYMDTO5 = "ztysyutkdai2hknkknymdto5";
    public static final String ZTYYOBIV22X5             = "ztyyobiv22x5";
    public static final String ZTYSYUKYKTKYKRENBAN6     = "ztysyukyktkykrenban6";
    public static final String ZTYSYUKYKTKYKMSGKBN6     = "ztysyukyktkykmsgkbn6";
    public static final String ZTYSYUKYKTKYKSMSGKBN6    = "ztysyukyktkyksmsgkbn6";
    public static final String ZTYSYUKYKTKYKHKNKKNMSGKBN6 = "ztysyukyktkykhknkknmsgkbn6";
    public static final String ZTYSYUKYKTKYKSTUUKATYPE6 = "ztysyukyktkykstuukatype6";
    public static final String ZTYSYUKYKTKYKHKNKNGK6    = "ztysyukyktkykhknkngk6";
    public static final String ZTYSYUTKDAI1HKNKKNYMDTO6 = "ztysyutkdai1hknkknymdto6";
    public static final String ZTYSYUTKDAI2HKNKKNYMDTO6 = "ztysyutkdai2hknkknymdto6";
    public static final String ZTYYOBIV22X6             = "ztyyobiv22x6";
    public static final String ZTYSYUKYKTKYKRENBAN7     = "ztysyukyktkykrenban7";
    public static final String ZTYSYUKYKTKYKMSGKBN7     = "ztysyukyktkykmsgkbn7";
    public static final String ZTYSYUKYKTKYKSMSGKBN7    = "ztysyukyktkyksmsgkbn7";
    public static final String ZTYSYUKYKTKYKHKNKKNMSGKBN7 = "ztysyukyktkykhknkknmsgkbn7";
    public static final String ZTYSYUKYKTKYKSTUUKATYPE7 = "ztysyukyktkykstuukatype7";
    public static final String ZTYSYUKYKTKYKHKNKNGK7    = "ztysyukyktkykhknkngk7";
    public static final String ZTYSYUTKDAI1HKNKKNYMDTO7 = "ztysyutkdai1hknkknymdto7";
    public static final String ZTYSYUTKDAI2HKNKKNYMDTO7 = "ztysyutkdai2hknkknymdto7";
    public static final String ZTYYOBIV22X7             = "ztyyobiv22x7";
    public static final String ZTYSYUKYKTKYKRENBAN8     = "ztysyukyktkykrenban8";
    public static final String ZTYSYUKYKTKYKMSGKBN8     = "ztysyukyktkykmsgkbn8";
    public static final String ZTYSYUKYKTKYKSMSGKBN8    = "ztysyukyktkyksmsgkbn8";
    public static final String ZTYSYUKYKTKYKHKNKKNMSGKBN8 = "ztysyukyktkykhknkknmsgkbn8";
    public static final String ZTYSYUKYKTKYKSTUUKATYPE8 = "ztysyukyktkykstuukatype8";
    public static final String ZTYSYUKYKTKYKHKNKNGK8    = "ztysyukyktkykhknkngk8";
    public static final String ZTYSYUTKDAI1HKNKKNYMDTO8 = "ztysyutkdai1hknkknymdto8";
    public static final String ZTYSYUTKDAI2HKNKKNYMDTO8 = "ztysyutkdai2hknkknymdto8";
    public static final String ZTYYOBIV22X8             = "ztyyobiv22x8";
    public static final String ZTYSYUKYKTKYKRENBAN9     = "ztysyukyktkykrenban9";
    public static final String ZTYSYUKYKTKYKMSGKBN9     = "ztysyukyktkykmsgkbn9";
    public static final String ZTYSYUKYKTKYKSMSGKBN9    = "ztysyukyktkyksmsgkbn9";
    public static final String ZTYSYUKYKTKYKHKNKKNMSGKBN9 = "ztysyukyktkykhknkknmsgkbn9";
    public static final String ZTYSYUKYKTKYKSTUUKATYPE9 = "ztysyukyktkykstuukatype9";
    public static final String ZTYSYUKYKTKYKHKNKNGK9    = "ztysyukyktkykhknkngk9";
    public static final String ZTYSYUTKDAI1HKNKKNYMDTO9 = "ztysyutkdai1hknkknymdto9";
    public static final String ZTYSYUTKDAI2HKNKKNYMDTO9 = "ztysyutkdai2hknkknymdto9";
    public static final String ZTYYOBIV22X9             = "ztyyobiv22x9";
    public static final String ZTYSYUKYKTKYKRENBAN10    = "ztysyukyktkykrenban10";
    public static final String ZTYSYUKYKTKYKMSGKBN10    = "ztysyukyktkykmsgkbn10";
    public static final String ZTYSYUKYKTKYKSMSGKBN10   = "ztysyukyktkyksmsgkbn10";
    public static final String ZTYSYUKYKTKYKHKNKKNMSGKBN10 = "ztysyukyktkykhknkknmsgkbn10";
    public static final String ZTYSYUKYKTKYKSTUUKATYPE10 = "ztysyukyktkykstuukatype10";
    public static final String ZTYSYUKYKTKYKHKNKNGK10   = "ztysyukyktkykhknkngk10";
    public static final String ZTYSYUTKDAI1HKNKKNYMDTO10 = "ztysyutkdai1hknkknymdto10";
    public static final String ZTYSYUTKDAI2HKNKKNYMDTO10 = "ztysyutkdai2hknkknymdto10";
    public static final String ZTYYOBIV22X10            = "ztyyobiv22x10";
    public static final String ZTYYOBIV50               = "ztyyobiv50";
    public static final String ZTYKYKNIYUSTMSGCD1       = "ztykykniyustmsgcd1";
    public static final String ZTYKYKNIYUSTMSGCD2       = "ztykykniyustmsgcd2";
    public static final String ZTYKYKNIYUSTMSGCD3       = "ztykykniyustmsgcd3";
    public static final String ZTYKYKNIYUSTMSGCD4       = "ztykykniyustmsgcd4";
    public static final String ZTYKYKNIYUSTMSGCD5       = "ztykykniyustmsgcd5";
    public static final String ZTYKYKNIYUSTMSGCD6       = "ztykykniyustmsgcd6";
    public static final String ZTYKYKNIYUSTMSGCD7       = "ztykykniyustmsgcd7";
    public static final String ZTYKYKNIYUSTMSGCD8       = "ztykykniyustmsgcd8";
    public static final String ZTYKYKNIYUSTMSGCD9       = "ztykykniyustmsgcd9";
    public static final String ZTYKYKNIYUSTMSGCD10      = "ztykykniyustmsgcd10";
    public static final String ZTYKYKNIYUSTMSGCD11      = "ztykykniyustmsgcd11";
    public static final String ZTYKYKNIYUSTMSGCD12      = "ztykykniyustmsgcd12";
    public static final String ZTYKYKNIYUSTMSGCD13      = "ztykykniyustmsgcd13";
    public static final String ZTYKYKNIYUSTMSGCD14      = "ztykykniyustmsgcd14";
    public static final String ZTYKYKNIYUSTMSGCD15      = "ztykykniyustmsgcd15";
    public static final String ZTYKYKNIYUSTITJBRPTUUKTYPE = "ztykykniyustitjbrptuuktype";
    public static final String ZTYKYKNIYUSTITJBRP       = "ztykykniyustitjbrp";
    public static final String ZTYKYKNIYUSTKIHONSTYPE   = "ztykykniyustkihonstype";
    public static final String ZTYKYKNIYUSTKIHONS       = "ztykykniyustkihons";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYSONOTANYRANMSGCD1     = "ztysonotanyranmsgcd1";
    public static final String ZTYSONOTANYRANMSGCD2     = "ztysonotanyranmsgcd2";
    public static final String ZTYSONOTANYRANMSGCD3     = "ztysonotanyranmsgcd3";
    public static final String ZTYSONOTANYRANMSGCD4     = "ztysonotanyranmsgcd4";
    public static final String ZTYSONOTANYRANMSGCD5     = "ztysonotanyranmsgcd5";
    public static final String ZTYSONOTANYRANMSGCD6     = "ztysonotanyranmsgcd6";
    public static final String ZTYSONOTANYRANMSGCD7     = "ztysonotanyranmsgcd7";
    public static final String ZTYSONOTANYRANMSGCD8     = "ztysonotanyranmsgcd8";
    public static final String ZTYSONOTANYRANMSGCD9     = "ztysonotanyranmsgcd9";
    public static final String ZTYSONOTANYRANMSGCD10    = "ztysonotanyranmsgcd10";
    public static final String ZTYSONOTANYRANMSGCD11    = "ztysonotanyranmsgcd11";
    public static final String ZTYSONOTANYRANMSGCD12    = "ztysonotanyranmsgcd12";
    public static final String ZTYSONOTANYRANMSGCD13    = "ztysonotanyranmsgcd13";
    public static final String ZTYSONOTANYRANMSGCD14    = "ztysonotanyranmsgcd14";
    public static final String ZTYSONOTANYRANMSGCD15    = "ztysonotanyranmsgcd15";
    public static final String ZTYSONOTANYRANMSGCD16    = "ztysonotanyranmsgcd16";
    public static final String ZTYSONOTANYRANMSGCD17    = "ztysonotanyranmsgcd17";
    public static final String ZTYSONOTANYRANMSGCD18    = "ztysonotanyranmsgcd18";
    public static final String ZTYSONOTANYRANMSGCD19    = "ztysonotanyranmsgcd19";
    public static final String ZTYSONOTANYRANMSGCD20    = "ztysonotanyranmsgcd20";
    public static final String ZTYSONOTANYRANSITEITUUKA = "ztysonotanyransiteituuka";
    public static final String ZTYSONOTANYRANNYKNTUKTYPE = "ztysonotanyrannykntuktype";
    public static final String ZTYSONOTANYRANNYKNTUUKAP = "ztysonotanyrannykntuukap";
    public static final String ZTYSONOTANYRANNYKNTUUKASYU = "ztysonotanyrannykntuukasyu";
    public static final String ZTYSONOTANYRANENKHRIKMRATE = "ztysonotanyranenkhrikmrate";
    public static final String ZTYSONOTANYRANSTIGIKWSRATE = "ztysonotanyranstigikwsrate";
    public static final String ZTYSONOTANYKJNKNGKTUKTYPE = "ztysonotanykjnkngktuktype";
    public static final String ZTYSONOTANYKJNKNGK       = "ztysonotanykjnkngk";
    public static final String ZTYSONOTANYKJNKNGKRATE   = "ztysonotanykjnkngkrate";
    public static final String ZTYSONOTANYKJNKNGKTUUKA  = "ztysonotanykjnkngktuuka";
    public static final String ZTYSONOTANYRANPENTUKTYPE = "ztysonotanyranpentuktype";
    public static final String ZTYSONOTANYRANPENKNSNGK  = "ztysonotanyranpenknsngk";
    public static final String ZTYPMKHTOUTATUWARIAI     = "ztypmkhtoutatuwariai";
    public static final String ZTYSONOTANYRANMKHGK      = "ztysonotanyranmkhgk";
    public static final String ZTYSONOTANYRANNKSHRSTARTYMD = "ztysonotanyrannkshrstartymd";
    public static final String ZTYSONOTANYRANNKKKN      = "ztysonotanyrannkkkn";
    public static final String ZTYSONOTANYYENSYSNHKHNKYMD = "ztysonotanyyensysnhkhnkymd";
    public static final String ZTYSONOTANYTMTTKNGKTUKTYPE = "ztysonotanytmttkngktuktype";
    public static final String ZTYSONOTANYTEIRITUTMTTKNGK = "ztysonotanyteiritutmttkngk";
    public static final String ZTYSONOTANYRANSISUUTMTTKNGK = "ztysonotanyransisuutmttkngk";
    public static final String ZTYSONOTANYRANSISUUNM    = "ztysonotanyransisuunm";
    public static final String ZTYSONOTANYRENDOURITU    = "ztysonotanyrendouritu";
    public static final String ZTYSONOTANYTEIKISIHARAIKIN = "ztysonotanyteikisiharaikin";
    public static final String ZTYSONOTANYRANGAIMSGCD   = "ztysonotanyrangaimsgcd";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYHOSYOUNYMSGCD         = "ztyhosyounymsgcd";
    public static final String ZTYYOBIV15               = "ztyyobiv15";
    public static final String ZTYHOSYOUNYHIHKNSYANMKANJI = "ztyhosyounyhihknsyanmkanji";
    public static final String ZTYYOBIV24               = "ztyyobiv24";
    public static final String ZTYSIBOUMIDASIMSGCD      = "ztysiboumidasimsgcd";
    public static final String ZTYSIBOUMIDASIMSGCD2     = "ztysiboumidasimsgcd2";
    public static final String ZTYSIBOUDAI1HKNKKNMSGCD1 = "ztysiboudai1hknkknmsgcd1";
    public static final String ZTYSIBOUDAI1HKNKKNMSGCD2 = "ztysiboudai1hknkknmsgcd2";
    public static final String ZTYSIBOUDAI1HKNKKNIGIMSGCD = "ztysiboudai1hknkknigimsgcd";
    public static final String ZTYSIBOUDAI1HKNKKNIGIMSGCD2 = "ztysiboudai1hknkknigimsgcd2";
    public static final String ZTYSIBOUDAI1HKNKKNHRSMSGCD = "ztysiboudai1hknkknhrsmsgcd";
    public static final String ZTYSIBOUDAI1HKNKKNHRSMSGCD2 = "ztysiboudai1hknkknhrsmsgcd2";
    public static final String ZTYSIBOUDAI1HKNKKNSMRMSGCD = "ztysiboudai1hknkknsmrmsgcd";
    public static final String ZTYSIBOUDAI2HKNKKNMSGCD1 = "ztysiboudai2hknkknmsgcd1";
    public static final String ZTYSIBOUDAI2HKNKKNMSGCD2 = "ztysiboudai2hknkknmsgcd2";
    public static final String ZTYSIBOUDAI2HKNKKNSMSGCD = "ztysiboudai2hknkknsmsgcd";
    public static final String ZTYSIBOUDAI2HKNKKNSMSGCD2 = "ztysiboudai2hknkknsmsgcd2";
    public static final String ZTYSIBOUDAI3HKNKKNMSGCD1 = "ztysiboudai3hknkknmsgcd1";
    public static final String ZTYSIBOUDAI3HKNKKNMSGCD2 = "ztysiboudai3hknkknmsgcd2";
    public static final String ZTYYOBIV15X2             = "ztyyobiv15x2";
    public static final String ZTYSIBOUDAI1HKNKKNYMDTO  = "ztysiboudai1hknkknymdto";
    public static final String ZTYSIBOUITJBRPYENTUUKTYPE = "ztysibouitjbrpyentuuktype";
    public static final String ZTYSIBOUITJBRPYENTUUKGK  = "ztysibouitjbrpyentuukgk";
    public static final String ZTYSIBOUDAI1KJNKNGKTUKTYPE = "ztysiboudai1kjnkngktuktype";
    public static final String ZTYSIBOUDAI1KJNKNGK      = "ztysiboudai1kjnkngk";
    public static final String ZTYSIBOUDAI2HKNKKNYMDTO  = "ztysiboudai2hknkknymdto";
    public static final String ZTYSIBOUDAI2KJNKNGKTUKTYPE = "ztysiboudai2kjnkngktuktype";
    public static final String ZTYSIBOUDAI2KJNKNGK      = "ztysiboudai2kjnkngk";
    public static final String ZTYSIBOUDAI3KJNKNGKTUKTYPE = "ztysiboudai3kjnkngktuktype";
    public static final String ZTYSIBOUDAI3KJNKNGK      = "ztysiboudai3kjnkngk";
    public static final String ZTYYOBIV23               = "ztyyobiv23";
    public static final String ZTYDAI1SKWSRATEYENDAKA   = "ztydai1skwsrateyendaka";
    public static final String ZTYDAI1SKWSRATEYENKIJYUN = "ztydai1skwsrateyenkijyun";
    public static final String ZTYDAI1SKWSRATEYENYASU   = "ztydai1skwsrateyenyasu";
    public static final String ZTYDAI1SIBOUSNENOUTOUYMD1 = "ztydai1sibousnenoutouymd1";
    public static final String ZTYDAI1STUUKTYPE01       = "ztydai1stuuktype01";
    public static final String ZTYDAI1S01               = "ztydai1s01";
    public static final String ZTYDAI1SYENYENDAKAUMU01  = "ztydai1syenyendakaumu01";
    public static final String ZTYDAI1SYENYENKIJYUNUMU01 = "ztydai1syenyenkijyunumu01";
    public static final String ZTYDAI1SYENYENYASUUMU01  = "ztydai1syenyenyasuumu01";
    public static final String ZTYDAI1SYENTUUKTYPE01    = "ztydai1syentuuktype01";
    public static final String ZTYDAI1SYENYENDAKA01     = "ztydai1syenyendaka01";
    public static final String ZTYDAI1SYENYENKIJYUN01   = "ztydai1syenyenkijyun01";
    public static final String ZTYDAI1SYENYENYASU01     = "ztydai1syenyenyasu01";
    public static final String ZTYDAI1ZENNOUZNDK01      = "ztydai1zennouzndk01";
    public static final String ZTYDAI1ZENNOUZNDKTYPE01  = "ztydai1zennouzndktype01";
    public static final String ZTYDAI1SBJIUKTGK01       = "ztydai1sbjiuktgk01";
    public static final String ZTYDAI1SBJIUKTGKTYPE01   = "ztydai1sbjiuktgktype01";
    public static final String ZTYDAI1SBJIUKTGKYTYPE01  = "ztydai1sbjiuktgkytype01";
    public static final String ZTYDAI1SBJIUKTGKYDAKA01  = "ztydai1sbjiuktgkydaka01";
    public static final String ZTYDAI1SBJIUKTGKYKIJYUN01 = "ztydai1sbjiuktgkykijyun01";
    public static final String ZTYDAI1SBJIUKTGKYYASU01  = "ztydai1sbjiuktgkyyasu01";
    public static final String ZTYDAI1SIBOUSNENOUTOUYMD2 = "ztydai1sibousnenoutouymd2";
    public static final String ZTYDAI1STUUKTYPE02       = "ztydai1stuuktype02";
    public static final String ZTYDAI1S02               = "ztydai1s02";
    public static final String ZTYDAI1SYENYENDAKAUMU02  = "ztydai1syenyendakaumu02";
    public static final String ZTYDAI1SYENYENKIJYUNUMU02 = "ztydai1syenyenkijyunumu02";
    public static final String ZTYDAI1SYENYENYASUUMU02  = "ztydai1syenyenyasuumu02";
    public static final String ZTYDAI1SYENTUUKTYPE02    = "ztydai1syentuuktype02";
    public static final String ZTYDAI1SYENYENDAKA02     = "ztydai1syenyendaka02";
    public static final String ZTYDAI1SYENYENKIJYUN02   = "ztydai1syenyenkijyun02";
    public static final String ZTYDAI1SYENYENYASU02     = "ztydai1syenyenyasu02";
    public static final String ZTYDAI1ZENNOUZNDK02      = "ztydai1zennouzndk02";
    public static final String ZTYDAI1ZENNOUZNDKTYPE02  = "ztydai1zennouzndktype02";
    public static final String ZTYDAI1SBJIUKTGK02       = "ztydai1sbjiuktgk02";
    public static final String ZTYDAI1SBJIUKTGKTYPE02   = "ztydai1sbjiuktgktype02";
    public static final String ZTYDAI1SBJIUKTGKYTYPE02  = "ztydai1sbjiuktgkytype02";
    public static final String ZTYDAI1SBJIUKTGKYDAKA02  = "ztydai1sbjiuktgkydaka02";
    public static final String ZTYDAI1SBJIUKTGKYKIJYUN02 = "ztydai1sbjiuktgkykijyun02";
    public static final String ZTYDAI1SBJIUKTGKYYASU02  = "ztydai1sbjiuktgkyyasu02";
    public static final String ZTYDAI1SIBOUSNENOUTOUYMD3 = "ztydai1sibousnenoutouymd3";
    public static final String ZTYDAI1STUUKTYPE03       = "ztydai1stuuktype03";
    public static final String ZTYDAI1S03               = "ztydai1s03";
    public static final String ZTYDAI1SYENYENDAKAUMU03  = "ztydai1syenyendakaumu03";
    public static final String ZTYDAI1SYENYENKIJYUNUMU03 = "ztydai1syenyenkijyunumu03";
    public static final String ZTYDAI1SYENYENYASUUMU03  = "ztydai1syenyenyasuumu03";
    public static final String ZTYDAI1SYENTUUKTYPE03    = "ztydai1syentuuktype03";
    public static final String ZTYDAI1SYENYENDAKA03     = "ztydai1syenyendaka03";
    public static final String ZTYDAI1SYENYENKIJYUN03   = "ztydai1syenyenkijyun03";
    public static final String ZTYDAI1SYENYENYASU03     = "ztydai1syenyenyasu03";
    public static final String ZTYDAI1ZENNOUZNDK03      = "ztydai1zennouzndk03";
    public static final String ZTYDAI1ZENNOUZNDKTYPE03  = "ztydai1zennouzndktype03";
    public static final String ZTYDAI1SBJIUKTGK03       = "ztydai1sbjiuktgk03";
    public static final String ZTYDAI1SBJIUKTGKTYPE03   = "ztydai1sbjiuktgktype03";
    public static final String ZTYDAI1SBJIUKTGKYTYPE03  = "ztydai1sbjiuktgkytype03";
    public static final String ZTYDAI1SBJIUKTGKYDAKA03  = "ztydai1sbjiuktgkydaka03";
    public static final String ZTYDAI1SBJIUKTGKYKIJYUN03 = "ztydai1sbjiuktgkykijyun03";
    public static final String ZTYDAI1SBJIUKTGKYYASU03  = "ztydai1sbjiuktgkyyasu03";
    public static final String ZTYDAI1SIBOUSNENOUTOUYMD4 = "ztydai1sibousnenoutouymd4";
    public static final String ZTYDAI1STUUKTYPE04       = "ztydai1stuuktype04";
    public static final String ZTYDAI1S04               = "ztydai1s04";
    public static final String ZTYDAI1SYENYENDAKAUMU04  = "ztydai1syenyendakaumu04";
    public static final String ZTYDAI1SYENYENKIJYUNUMU04 = "ztydai1syenyenkijyunumu04";
    public static final String ZTYDAI1SYENYENYASUUMU04  = "ztydai1syenyenyasuumu04";
    public static final String ZTYDAI1SYENTUUKTYPE04    = "ztydai1syentuuktype04";
    public static final String ZTYDAI1SYENYENDAKA04     = "ztydai1syenyendaka04";
    public static final String ZTYDAI1SYENYENKIJYUN04   = "ztydai1syenyenkijyun04";
    public static final String ZTYDAI1SYENYENYASU04     = "ztydai1syenyenyasu04";
    public static final String ZTYDAI1ZENNOUZNDK04      = "ztydai1zennouzndk04";
    public static final String ZTYDAI1ZENNOUZNDKTYPE04  = "ztydai1zennouzndktype04";
    public static final String ZTYDAI1SBJIUKTGK04       = "ztydai1sbjiuktgk04";
    public static final String ZTYDAI1SBJIUKTGKTYPE04   = "ztydai1sbjiuktgktype04";
    public static final String ZTYDAI1SBJIUKTGKYTYPE04  = "ztydai1sbjiuktgkytype04";
    public static final String ZTYDAI1SBJIUKTGKYDAKA04  = "ztydai1sbjiuktgkydaka04";
    public static final String ZTYDAI1SBJIUKTGKYKIJYUN04 = "ztydai1sbjiuktgkykijyun04";
    public static final String ZTYDAI1SBJIUKTGKYYASU04  = "ztydai1sbjiuktgkyyasu04";
    public static final String ZTYDAI1SIBOUSNENOUTOUYMD5 = "ztydai1sibousnenoutouymd5";
    public static final String ZTYDAI1STUUKTYPE05       = "ztydai1stuuktype05";
    public static final String ZTYDAI1S05               = "ztydai1s05";
    public static final String ZTYDAI1SYENYENDAKAUMU05  = "ztydai1syenyendakaumu05";
    public static final String ZTYDAI1SYENYENKIJYUNUMU05 = "ztydai1syenyenkijyunumu05";
    public static final String ZTYDAI1SYENYENYASUUMU05  = "ztydai1syenyenyasuumu05";
    public static final String ZTYDAI1SYENTUUKTYPE05    = "ztydai1syentuuktype05";
    public static final String ZTYDAI1SYENYENDAKA05     = "ztydai1syenyendaka05";
    public static final String ZTYDAI1SYENYENKIJYUN05   = "ztydai1syenyenkijyun05";
    public static final String ZTYDAI1SYENYENYASU05     = "ztydai1syenyenyasu05";
    public static final String ZTYDAI1ZENNOUZNDK05      = "ztydai1zennouzndk05";
    public static final String ZTYDAI1ZENNOUZNDKTYPE05  = "ztydai1zennouzndktype05";
    public static final String ZTYDAI1SBJIUKTGK05       = "ztydai1sbjiuktgk05";
    public static final String ZTYDAI1SBJIUKTGKTYPE05   = "ztydai1sbjiuktgktype05";
    public static final String ZTYDAI1SBJIUKTGKYTYPE05  = "ztydai1sbjiuktgkytype05";
    public static final String ZTYDAI1SBJIUKTGKYDAKA05  = "ztydai1sbjiuktgkydaka05";
    public static final String ZTYDAI1SBJIUKTGKYKIJYUN05 = "ztydai1sbjiuktgkykijyun05";
    public static final String ZTYDAI1SBJIUKTGKYYASU05  = "ztydai1sbjiuktgkyyasu05";
    public static final String ZTYDAI1SIBOUSNENOUTOUYMD6 = "ztydai1sibousnenoutouymd6";
    public static final String ZTYDAI1STUUKTYPE06       = "ztydai1stuuktype06";
    public static final String ZTYDAI1S06               = "ztydai1s06";
    public static final String ZTYDAI1SYENYENDAKAUMU06  = "ztydai1syenyendakaumu06";
    public static final String ZTYDAI1SYENYENKIJYUNUMU06 = "ztydai1syenyenkijyunumu06";
    public static final String ZTYDAI1SYENYENYASUUMU06  = "ztydai1syenyenyasuumu06";
    public static final String ZTYDAI1SYENTUUKTYPE06    = "ztydai1syentuuktype06";
    public static final String ZTYDAI1SYENYENDAKA06     = "ztydai1syenyendaka06";
    public static final String ZTYDAI1SYENYENKIJYUN06   = "ztydai1syenyenkijyun06";
    public static final String ZTYDAI1SYENYENYASU06     = "ztydai1syenyenyasu06";
    public static final String ZTYDAI1ZENNOUZNDK06      = "ztydai1zennouzndk06";
    public static final String ZTYDAI1ZENNOUZNDKTYPE06  = "ztydai1zennouzndktype06";
    public static final String ZTYDAI1SBJIUKTGK06       = "ztydai1sbjiuktgk06";
    public static final String ZTYDAI1SBJIUKTGKTYPE06   = "ztydai1sbjiuktgktype06";
    public static final String ZTYDAI1SBJIUKTGKYTYPE06  = "ztydai1sbjiuktgkytype06";
    public static final String ZTYDAI1SBJIUKTGKYDAKA06  = "ztydai1sbjiuktgkydaka06";
    public static final String ZTYDAI1SBJIUKTGKYKIJYUN06 = "ztydai1sbjiuktgkykijyun06";
    public static final String ZTYDAI1SBJIUKTGKYYASU06  = "ztydai1sbjiuktgkyyasu06";
    public static final String ZTYDAI1SIBOUSNENOUTOUYMD7 = "ztydai1sibousnenoutouymd7";
    public static final String ZTYDAI1STUUKTYPE07       = "ztydai1stuuktype07";
    public static final String ZTYDAI1S07               = "ztydai1s07";
    public static final String ZTYDAI1SYENYENDAKAUMU07  = "ztydai1syenyendakaumu07";
    public static final String ZTYDAI1SYENYENKIJYUNUMU07 = "ztydai1syenyenkijyunumu07";
    public static final String ZTYDAI1SYENYENYASUUMU07  = "ztydai1syenyenyasuumu07";
    public static final String ZTYDAI1SYENTUUKTYPE07    = "ztydai1syentuuktype07";
    public static final String ZTYDAI1SYENYENDAKA07     = "ztydai1syenyendaka07";
    public static final String ZTYDAI1SYENYENKIJYUN07   = "ztydai1syenyenkijyun07";
    public static final String ZTYDAI1SYENYENYASU07     = "ztydai1syenyenyasu07";
    public static final String ZTYDAI1SIBOUSNENOUTOUYMD8 = "ztydai1sibousnenoutouymd8";
    public static final String ZTYDAI1STUUKTYPE08       = "ztydai1stuuktype08";
    public static final String ZTYDAI1S08               = "ztydai1s08";
    public static final String ZTYDAI1SYENYENDAKAUMU08  = "ztydai1syenyendakaumu08";
    public static final String ZTYDAI1SYENYENKIJYUNUMU08 = "ztydai1syenyenkijyunumu08";
    public static final String ZTYDAI1SYENYENYASUUMU08  = "ztydai1syenyenyasuumu08";
    public static final String ZTYDAI1SYENTUUKTYPE08    = "ztydai1syentuuktype08";
    public static final String ZTYDAI1SYENYENDAKA08     = "ztydai1syenyendaka08";
    public static final String ZTYDAI1SYENYENKIJYUN08   = "ztydai1syenyenkijyun08";
    public static final String ZTYDAI1SYENYENYASU08     = "ztydai1syenyenyasu08";
    public static final String ZTYDAI1SIBOUSNENOUTOUYMD9 = "ztydai1sibousnenoutouymd9";
    public static final String ZTYDAI1STUUKTYPE09       = "ztydai1stuuktype09";
    public static final String ZTYDAI1S09               = "ztydai1s09";
    public static final String ZTYDAI1SYENYENDAKAUMU09  = "ztydai1syenyendakaumu09";
    public static final String ZTYDAI1SYENYENKIJYUNUMU09 = "ztydai1syenyenkijyunumu09";
    public static final String ZTYDAI1SYENYENYASUUMU09  = "ztydai1syenyenyasuumu09";
    public static final String ZTYDAI1SYENTUUKTYPE09    = "ztydai1syentuuktype09";
    public static final String ZTYDAI1SYENYENDAKA09     = "ztydai1syenyendaka09";
    public static final String ZTYDAI1SYENYENKIJYUN09   = "ztydai1syenyenkijyun09";
    public static final String ZTYDAI1SYENYENYASU09     = "ztydai1syenyenyasu09";
    public static final String ZTYDAI1SIBOUSNENOUTOUYMD10 = "ztydai1sibousnenoutouymd10";
    public static final String ZTYDAI1STUUKTYPE10       = "ztydai1stuuktype10";
    public static final String ZTYDAI1S10               = "ztydai1s10";
    public static final String ZTYDAI1SYENYENDAKAUMU10  = "ztydai1syenyendakaumu10";
    public static final String ZTYDAI1SYENYENKIJYUNUMU10 = "ztydai1syenyenkijyunumu10";
    public static final String ZTYDAI1SYENYENYASUUMU10  = "ztydai1syenyenyasuumu10";
    public static final String ZTYDAI1SYENTUUKTYPE10    = "ztydai1syentuuktype10";
    public static final String ZTYDAI1SYENYENDAKA10     = "ztydai1syenyendaka10";
    public static final String ZTYDAI1SYENYENKIJYUN10   = "ztydai1syenyenkijyun10";
    public static final String ZTYDAI1SYENYENYASU10     = "ztydai1syenyenyasu10";
    public static final String ZTYDAI1STUUKTYPEHURYO    = "ztydai1stuuktypehuryo";
    public static final String ZTYDAI1SHURYO            = "ztydai1shuryo";
    public static final String ZTYDAI1SYENYENDAKAUMUHURYO = "ztydai1syenyendakaumuhuryo";
    public static final String ZTYDAI1SYENYENKJNUMUHURYO = "ztydai1syenyenkjnumuhuryo";
    public static final String ZTYDAI1SYENYENYASUUMUHURYO = "ztydai1syenyenyasuumuhuryo";
    public static final String ZTYDAI1SYENTUUKTYPEHURYO = "ztydai1syentuuktypehuryo";
    public static final String ZTYDAI1SYENYENDAKAHURYO  = "ztydai1syenyendakahuryo";
    public static final String ZTYDAI1SYENYENKIJYUNHURYO = "ztydai1syenyenkijyunhuryo";
    public static final String ZTYDAI1SYENYENYASUHURYO  = "ztydai1syenyenyasuhuryo";
    public static final String ZTYDAI2STUUKTYPE         = "ztydai2stuuktype";
    public static final String ZTYDAI2S                 = "ztydai2s";
    public static final String ZTYDAI2SYENTUUKTYPE      = "ztydai2syentuuktype";
    public static final String ZTYDAI2SYENYENDAKA       = "ztydai2syenyendaka";
    public static final String ZTYDAI2SYENYENKIJYUN     = "ztydai2syenyenkijyun";
    public static final String ZTYDAI2SYENYENYASU       = "ztydai2syenyenyasu";
    public static final String ZTYDAI3STUUKTYPE         = "ztydai3stuuktype";
    public static final String ZTYDAI3S                 = "ztydai3s";
    public static final String ZTYDAI3SYENTUUKTYPE      = "ztydai3syentuuktype";
    public static final String ZTYDAI3SYENYENDAKA       = "ztydai3syenyendaka";
    public static final String ZTYDAI3SYENYENKIJYUN     = "ztydai3syenyenkijyun";
    public static final String ZTYDAI3SYENYENYASU       = "ztydai3syenyenyasu";
    public static final String ZTYSIBOUINJIPTNKBN       = "ztysibouinjiptnkbn";
    public static final String ZTYYOBIV25               = "ztyyobiv25";
    public static final String ZTYNKMSGCD1              = "ztynkmsgcd1";
    public static final String ZTYNKMSGCD2              = "ztynkmsgcd2";
    public static final String ZTYNKMSGCD3              = "ztynkmsgcd3";
    public static final String ZTYNKMSGCD4              = "ztynkmsgcd4";
    public static final String ZTYNKMSGCD5              = "ztynkmsgcd5";
    public static final String ZTYNKMSGCD6              = "ztynkmsgcd6";
    public static final String ZTYNKMSGCD7              = "ztynkmsgcd7";
    public static final String ZTYNKMSGCD8              = "ztynkmsgcd8";
    public static final String ZTYNKMSGCD9              = "ztynkmsgcd9";
    public static final String ZTYNKMSGCD10             = "ztynkmsgcd10";
    public static final String ZTYSIBOUKYUUHUKINMSGCD1  = "ztysiboukyuuhukinmsgcd1";
    public static final String ZTYSIBOUKYUUHUKINMSGCD2  = "ztysiboukyuuhukinmsgcd2";
    public static final String ZTYSIBOUKYUUHUKINMSGCD3  = "ztysiboukyuuhukinmsgcd3";
    public static final String ZTYSIBOUKYUUHUKINMSGCD4  = "ztysiboukyuuhukinmsgcd4";
    public static final String ZTYSIBOUKYUUHUKINMSGCD5  = "ztysiboukyuuhukinmsgcd5";
    public static final String ZTYSIBOUKYUUHUKINMSGCD6  = "ztysiboukyuuhukinmsgcd6";
    public static final String ZTYSIBOUKYUUHUKINMSGCD7  = "ztysiboukyuuhukinmsgcd7";
    public static final String ZTYSIBOUKYUUHUKINMSGCD8  = "ztysiboukyuuhukinmsgcd8";
    public static final String ZTYSIBOUKYUUHUKINMSGCD9  = "ztysiboukyuuhukinmsgcd9";
    public static final String ZTYSIBOUKYUUHUKINMSGCD10 = "ztysiboukyuuhukinmsgcd10";
    public static final String ZTYNKSHRSTARTZENYMD      = "ztynkshrstartzenymd";
    public static final String ZTYMKHYOUYENNKHKNHENTKTYPE = "ztymkhyouyennkhknhentktype";
    public static final String ZTYMKHYOUYENNKHKNHENTKMKHGK = "ztymkhyouyennkhknhentkmkhgk";
    public static final String ZTYMKHYENNKHKNHENTKMKHWARI = "ztymkhyennkhknhentkmkhwari";
    public static final String ZTYHAIBUNWARIMSGCD1      = "ztyhaibunwarimsgcd1";
    public static final String ZTYHAIBUNWARIMSGCD2      = "ztyhaibunwarimsgcd2";
    public static final String ZTYHAIBUNWARIMSGCD3      = "ztyhaibunwarimsgcd3";
    public static final String ZTYTEIRITUTMTTHBNWR      = "ztyteiritutmtthbnwr";
    public static final String ZTYSISUUTMTTHBNWR        = "ztysisuutmtthbnwr";
    public static final String ZTYSISUUANNAIMSG1        = "ztysisuuannaimsg1";
    public static final String ZTYSISUUANNAIMSG2        = "ztysisuuannaimsg2";
    public static final String ZTYSISUUANNAIMSG3        = "ztysisuuannaimsg3";
    public static final String ZTYMKHYOUYENSYSNIKOUMSGCD = "ztymkhyouyensysnikoumsgcd";
    public static final String ZTYMKHYOUYENSYSNIKOUMSGCD2 = "ztymkhyouyensysnikoumsgcd2";
    public static final String ZTYMKHYOUYENSYSNIKOUMSGCD3 = "ztymkhyouyensysnikoumsgcd3";
    public static final String ZTYMKHYOUYENSYSNIKOUGKTYPE = "ztymkhyouyensysnikougktype";
    public static final String ZTYMKHYOUYENSYSNIKOUGK   = "ztymkhyouyensysnikougk";
    public static final String ZTYMKHYOUYENSYSNIKOUWRA  = "ztymkhyouyensysnikouwra";
    public static final String ZTYMKHYOUYSYSNIKCURRENTGK = "ztymkhyouysysnikcurrentgk";
    public static final String ZTYYOBIV12               = "ztyyobiv12";
    public static final String ZTYKAIGOMAEHRTKYKMSGCD1  = "ztykaigomaehrtkykmsgcd1";
    public static final String ZTYKAIGOMAEHRTKYKMSGCD2  = "ztykaigomaehrtkykmsgcd2";
    public static final String ZTYKAIGOMAEHRTKYKMSGCDST1 = "ztykaigomaehrtkykmsgcdst1";
    public static final String ZTYKAIGOMAEHRTKYKMSGCDST2 = "ztykaigomaehrtkykmsgcdst2";
    public static final String ZTYKGMAEHRTKHKNKKN1MNRYYMD = "ztykgmaehrtkhknkkn1mnryymd";
    public static final String ZTYKAIGOMAEHRTKYKITRNUMU = "ztykaigomaehrtkykitrnumu";
    public static final String ZTYKAIGOMAEHRTKYKKYKTUUKA = "ztykaigomaehrtkykkyktuuka";
    public static final String ZTYKAIGOMAEHRTKYKSTDMSGCD = "ztykaigomaehrtkykstdmsgcd";
    public static final String ZTYKAIGOMAEHRJRUGKTYPE   = "ztykaigomaehrjrugktype";
    public static final String ZTYKAIGOMAEHRSIKUHHKNNEN01 = "ztykaigomaehrsikuhhknnen01";
    public static final String ZTYKAIGOMAEHRSTIKKN01    = "ztykaigomaehrstikkn01";
    public static final String ZTYKAIGOMAEHRJRUGK01     = "ztykaigomaehrjrugk01";
    public static final String ZTYKAIGOMAEHRSIKUHHKNNEN02 = "ztykaigomaehrsikuhhknnen02";
    public static final String ZTYKAIGOMAEHRSTIKKN02    = "ztykaigomaehrstikkn02";
    public static final String ZTYKAIGOMAEHRJRUGK02     = "ztykaigomaehrjrugk02";
    public static final String ZTYKAIGOMAEHRSIKUHHKNNEN03 = "ztykaigomaehrsikuhhknnen03";
    public static final String ZTYKAIGOMAEHRSTIKKN03    = "ztykaigomaehrstikkn03";
    public static final String ZTYKAIGOMAEHRJRUGK03     = "ztykaigomaehrjrugk03";
    public static final String ZTYKAIGOMAEHRSIKUHHKNNEN04 = "ztykaigomaehrsikuhhknnen04";
    public static final String ZTYKAIGOMAEHRSTIKKN04    = "ztykaigomaehrstikkn04";
    public static final String ZTYKAIGOMAEHRJRUGK04     = "ztykaigomaehrjrugk04";
    public static final String ZTYKAIGOMAEHRSIKUHHKNNEN05 = "ztykaigomaehrsikuhhknnen05";
    public static final String ZTYKAIGOMAEHRSTIKKN05    = "ztykaigomaehrstikkn05";
    public static final String ZTYKAIGOMAEHRJRUGK05     = "ztykaigomaehrjrugk05";
    public static final String ZTYKAIGOMAEHRSIKUHHKNNEN06 = "ztykaigomaehrsikuhhknnen06";
    public static final String ZTYKAIGOMAEHRSTIKKN06    = "ztykaigomaehrstikkn06";
    public static final String ZTYKAIGOMAEHRJRUGK06     = "ztykaigomaehrjrugk06";
    public static final String ZTYKAIGOMAEHRSIKUHHKNNEN07 = "ztykaigomaehrsikuhhknnen07";
    public static final String ZTYKAIGOMAEHRSTIKKN07    = "ztykaigomaehrstikkn07";
    public static final String ZTYKAIGOMAEHRJRUGK07     = "ztykaigomaehrjrugk07";
    public static final String ZTYKAIGOMAEHRSIKUHHKNNEN08 = "ztykaigomaehrsikuhhknnen08";
    public static final String ZTYKAIGOMAEHRSTIKKN08    = "ztykaigomaehrstikkn08";
    public static final String ZTYKAIGOMAEHRJRUGK08     = "ztykaigomaehrjrugk08";
    public static final String ZTYKAIGOMAEHRSIKUHHKNNEN09 = "ztykaigomaehrsikuhhknnen09";
    public static final String ZTYKAIGOMAEHRSTIKKN09    = "ztykaigomaehrstikkn09";
    public static final String ZTYKAIGOMAEHRJRUGK09     = "ztykaigomaehrjrugk09";
    public static final String ZTYKAIGOMAEHRSIKUHHKNNEN10 = "ztykaigomaehrsikuhhknnen10";
    public static final String ZTYKAIGOMAEHRSTIKKN10    = "ztykaigomaehrstikkn10";
    public static final String ZTYKAIGOMAEHRJRUGK10     = "ztykaigomaehrjrugk10";
    public static final String ZTYKAIGOMAEHRJRUGKYDAKA01 = "ztykaigomaehrjrugkydaka01";
    public static final String ZTYKGMAEHRJRUGKYKIJYUN01 = "ztykgmaehrjrugkykijyun01";
    public static final String ZTYKGMAEHRJRUGKYYASU01   = "ztykgmaehrjrugkyyasu01";
    public static final String ZTYKAIGOMAEHRJRUGKYDAKA02 = "ztykaigomaehrjrugkydaka02";
    public static final String ZTYKGMAEHRJRUGKYKIJYUN02 = "ztykgmaehrjrugkykijyun02";
    public static final String ZTYKGMAEHRJRUGKYYASU02   = "ztykgmaehrjrugkyyasu02";
    public static final String ZTYKAIGOMAEHRJRUGKYDAKA03 = "ztykaigomaehrjrugkydaka03";
    public static final String ZTYKGMAEHRJRUGKYKIJYUN03 = "ztykgmaehrjrugkykijyun03";
    public static final String ZTYKGMAEHRJRUGKYYASU03   = "ztykgmaehrjrugkyyasu03";
    public static final String ZTYKAIGOMAEHRJRUGKYDAKA04 = "ztykaigomaehrjrugkydaka04";
    public static final String ZTYKGMAEHRJRUGKYKIJYUN04 = "ztykgmaehrjrugkykijyun04";
    public static final String ZTYKGMAEHRJRUGKYYASU04   = "ztykgmaehrjrugkyyasu04";
    public static final String ZTYKAIGOMAEHRJRUGKYDAKA05 = "ztykaigomaehrjrugkydaka05";
    public static final String ZTYKGMAEHRJRUGKYKIJYUN05 = "ztykgmaehrjrugkykijyun05";
    public static final String ZTYKGMAEHRJRUGKYYASU05   = "ztykgmaehrjrugkyyasu05";
    public static final String ZTYKAIGOMAEHRJRUGKYDAKA06 = "ztykaigomaehrjrugkydaka06";
    public static final String ZTYKGMAEHRJRUGKYKIJYUN06 = "ztykgmaehrjrugkykijyun06";
    public static final String ZTYKGMAEHRJRUGKYYASU06   = "ztykgmaehrjrugkyyasu06";
    public static final String ZTYKAIGOMAEHRJRUGKYDAKA07 = "ztykaigomaehrjrugkydaka07";
    public static final String ZTYKGMAEHRJRUGKYKIJYUN07 = "ztykgmaehrjrugkykijyun07";
    public static final String ZTYKGMAEHRJRUGKYYASU07   = "ztykgmaehrjrugkyyasu07";
    public static final String ZTYKAIGOMAEHRJRUGKYDAKA08 = "ztykaigomaehrjrugkydaka08";
    public static final String ZTYKGMAEHRJRUGKYKIJYUN08 = "ztykgmaehrjrugkykijyun08";
    public static final String ZTYKGMAEHRJRUGKYYASU08   = "ztykgmaehrjrugkyyasu08";
    public static final String ZTYKAIGOMAEHRJRUGKYDAKA09 = "ztykaigomaehrjrugkydaka09";
    public static final String ZTYKGMAEHRJRUGKYKIJYUN09 = "ztykgmaehrjrugkykijyun09";
    public static final String ZTYKGMAEHRJRUGKYYASU09   = "ztykgmaehrjrugkyyasu09";
    public static final String ZTYKAIGOMAEHRJRUGKYDAKA10 = "ztykaigomaehrjrugkydaka10";
    public static final String ZTYKGMAEHRJRUGKYKIJYUN10 = "ztykgmaehrjrugkykijyun10";
    public static final String ZTYKGMAEHRJRUGKYYASU10   = "ztykgmaehrjrugkyyasu10";
    public static final String ZTYKZKTOUROKUSERVICEMSG1 = "ztykzktourokuservicemsg1";
    public static final String ZTYKZKTOUROKUSERVICEMSG2 = "ztykzktourokuservicemsg2";
    public static final String ZTYKZKTOUROKUSERVICEMSG3 = "ztykzktourokuservicemsg3";
    public static final String ZTYKZKTOUROKUSERVICEMSG4 = "ztykzktourokuservicemsg4";
    public static final String ZTYKZKTOUROKUSERVICEMSG5 = "ztykzktourokuservicemsg5";
    public static final String ZTYKZKTOUROKUSERVICEMSG6 = "ztykzktourokuservicemsg6";
    public static final String ZTYKZKTOUROKUSERVICEMSG7 = "ztykzktourokuservicemsg7";
    public static final String ZTYKZKTOUROKUSERVICEMSG8 = "ztykzktourokuservicemsg8";
    public static final String ZTYTRKKZKNM118           = "ztytrkkzknm118";
    public static final String ZTYTRKKZKSEI1            = "ztytrkkzksei1";
    public static final String ZTYTRKKZKSEIYMD1ZENKAKU  = "ztytrkkzkseiymd1zenkaku";
    public static final String ZTYTRKKZKYNO1ZENKAKU     = "ztytrkkzkyno1zenkaku";
    public static final String ZTYTRKKZKADRKJ1          = "ztytrkkzkadrkj1";
    public static final String ZTYTRKKZKTELNO1ZENKAKU   = "ztytrkkzktelno1zenkaku";
    public static final String ZTYTRKKZKNM218           = "ztytrkkzknm218";
    public static final String ZTYTRKKZKSEI2            = "ztytrkkzksei2";
    public static final String ZTYTRKKZKSEIYMD2ZENKAKU  = "ztytrkkzkseiymd2zenkaku";
    public static final String ZTYTRKKZKYNO2ZENKAKU     = "ztytrkkzkyno2zenkaku";
    public static final String ZTYTRKKZKADRKJ2          = "ztytrkkzkadrkj2";
    public static final String ZTYTRKKZKTELNO2ZENKAKU   = "ztytrkkzktelno2zenkaku";
    public static final String ZTYKYKDAIRINM18          = "ztykykdairinm18";
    public static final String ZTYHHKNDAIRINM           = "ztyhhkndairinm";
    public static final String ZTYYOBIV100              = "ztyyobiv100";
    public static final String ZTYHUTANHIYUSTMMSGCDUE01 = "ztyhutanhiyustmmsgcdue01";
    public static final String ZTYHUTANHIYUSTMMSGCDUE02 = "ztyhutanhiyustmmsgcdue02";
    public static final String ZTYHUTANHIYUSTMMSGCDUE03 = "ztyhutanhiyustmmsgcdue03";
    public static final String ZTYHUTANHIYUSTMMSGCDUE04 = "ztyhutanhiyustmmsgcdue04";
    public static final String ZTYHUTANHIYUSTMKNSNHYUPTN = "ztyhutanhiyustmknsnhyuptn";
    public static final String ZTYHUTANHIYUSTMMSGCDST01 = "ztyhutanhiyustmmsgcdst01";
    public static final String ZTYHUTANHIYUSTMMSGCDST02 = "ztyhutanhiyustmmsgcdst02";
    public static final String ZTYHUTANHIYUSTMMSGCDST03 = "ztyhutanhiyustmmsgcdst03";
    public static final String ZTYHUTANHIYUSTMYTIJIHIRITU = "ztyhutanhiyustmytijihiritu";
    public static final String ZTYHUTANHIYUSTMKYAKKJRTMIN = "ztyhutanhiyustmkyakkjrtmin";
    public static final String ZTYHUTANHIYUSTMKYAKKJRTMAX = "ztyhutanhiyustmkyakkjrtmax";
    public static final String ZTYYOBIV7X2              = "ztyyobiv7x2";
    public static final String ZTYSTDSTMMSGCD           = "ztystdstmmsgcd";
    public static final String ZTYSIORIWEBUKTRIANNAIMSGCD = "ztysioriwebuktriannaimsgcd";
    public static final String ZTYYOBIV10X2             = "ztyyobiv10x2";
    public static final String ZTYYOBIV69               = "ztyyobiv69";

    private final PKZT_SaihakkouHokensyoukenTy primaryKey;

    public GenZT_SaihakkouHokensyoukenTy() {
        primaryKey = new PKZT_SaihakkouHokensyoukenTy();
    }

    public GenZT_SaihakkouHokensyoukenTy(String pZtytyouhyouymd, String pZtysyono) {
        primaryKey = new PKZT_SaihakkouHokensyoukenTy(pZtytyouhyouymd, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_SaihakkouHokensyoukenTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SaihakkouHokensyoukenTy> getMetaClass() {
        return QZT_SaihakkouHokensyoukenTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztykanryoutuutidouhuukbn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKANRYOUTUUTIDOUHUUKBN)
    public String getZtykanryoutuutidouhuukbn() {
        return ztykanryoutuutidouhuukbn;
    }

    public void setZtykanryoutuutidouhuukbn(String pZtykanryoutuutidouhuukbn) {
        ztykanryoutuutidouhuukbn = pZtykanryoutuutidouhuukbn;
    }

    private String ztysikibetuno;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIKIBETUNO)
    public String getZtysikibetuno() {
        return ztysikibetuno;
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        ztysikibetuno = pZtysikibetuno;
    }

    private String ztystdrsktirasidouhuukbn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSTDRSKTIRASIDOUHUUKBN)
    public String getZtystdrsktirasidouhuukbn() {
        return ztystdrsktirasidouhuukbn;
    }

    public void setZtystdrsktirasidouhuukbn(String pZtystdrsktirasidouhuukbn) {
        ztystdrsktirasidouhuukbn = pZtystdrsktirasidouhuukbn;
    }

    private String ztyaisyoumeikbn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYAISYOUMEIKBN)
    public String getZtyaisyoumeikbn() {
        return ztyaisyoumeikbn;
    }

    public void setZtyaisyoumeikbn(String pZtyaisyoumeikbn) {
        ztyaisyoumeikbn = pZtyaisyoumeikbn;
    }

    private String ztysagyoukbn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSAGYOUKBN)
    public String getZtysagyoukbn() {
        return ztysagyoukbn;
    }

    public void setZtysagyoukbn(String pZtysagyoukbn) {
        ztysagyoukbn = pZtysagyoukbn;
    }

    private String ztyyakkanbunsyono;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYAKKANBUNSYONO)
    public String getZtyyakkanbunsyono() {
        return ztyyakkanbunsyono;
    }

    public void setZtyyakkanbunsyono(String pZtyyakkanbunsyono) {
        ztyyakkanbunsyono = pZtyyakkanbunsyono;
    }

    private String ztyyobiv23x2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV23X2)
    public String getZtyyobiv23x2() {
        return ztyyobiv23x2;
    }

    public void setZtyyobiv23x2(String pZtyyobiv23x2) {
        ztyyobiv23x2 = pZtyyobiv23x2;
    }

    private String ztyhyoujiranhidarimsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD1)
    public String getZtyhyoujiranhidarimsgcd1() {
        return ztyhyoujiranhidarimsgcd1;
    }

    public void setZtyhyoujiranhidarimsgcd1(String pZtyhyoujiranhidarimsgcd1) {
        ztyhyoujiranhidarimsgcd1 = pZtyhyoujiranhidarimsgcd1;
    }

    private String ztyhyoujiranhidarimsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD2)
    public String getZtyhyoujiranhidarimsgcd2() {
        return ztyhyoujiranhidarimsgcd2;
    }

    public void setZtyhyoujiranhidarimsgcd2(String pZtyhyoujiranhidarimsgcd2) {
        ztyhyoujiranhidarimsgcd2 = pZtyhyoujiranhidarimsgcd2;
    }

    private String ztyhyoujiranhidarimsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD3)
    public String getZtyhyoujiranhidarimsgcd3() {
        return ztyhyoujiranhidarimsgcd3;
    }

    public void setZtyhyoujiranhidarimsgcd3(String pZtyhyoujiranhidarimsgcd3) {
        ztyhyoujiranhidarimsgcd3 = pZtyhyoujiranhidarimsgcd3;
    }

    private String ztyhyoujiranhidarimsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD4)
    public String getZtyhyoujiranhidarimsgcd4() {
        return ztyhyoujiranhidarimsgcd4;
    }

    public void setZtyhyoujiranhidarimsgcd4(String pZtyhyoujiranhidarimsgcd4) {
        ztyhyoujiranhidarimsgcd4 = pZtyhyoujiranhidarimsgcd4;
    }

    private String ztyhyoujiranhidarimsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD5)
    public String getZtyhyoujiranhidarimsgcd5() {
        return ztyhyoujiranhidarimsgcd5;
    }

    public void setZtyhyoujiranhidarimsgcd5(String pZtyhyoujiranhidarimsgcd5) {
        ztyhyoujiranhidarimsgcd5 = pZtyhyoujiranhidarimsgcd5;
    }

    private String ztyhyoujiranhidarimsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD6)
    public String getZtyhyoujiranhidarimsgcd6() {
        return ztyhyoujiranhidarimsgcd6;
    }

    public void setZtyhyoujiranhidarimsgcd6(String pZtyhyoujiranhidarimsgcd6) {
        ztyhyoujiranhidarimsgcd6 = pZtyhyoujiranhidarimsgcd6;
    }

    private String ztyhyoujiranhidarimsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD7)
    public String getZtyhyoujiranhidarimsgcd7() {
        return ztyhyoujiranhidarimsgcd7;
    }

    public void setZtyhyoujiranhidarimsgcd7(String pZtyhyoujiranhidarimsgcd7) {
        ztyhyoujiranhidarimsgcd7 = pZtyhyoujiranhidarimsgcd7;
    }

    private String ztyhyoujiranhidarimsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD8)
    public String getZtyhyoujiranhidarimsgcd8() {
        return ztyhyoujiranhidarimsgcd8;
    }

    public void setZtyhyoujiranhidarimsgcd8(String pZtyhyoujiranhidarimsgcd8) {
        ztyhyoujiranhidarimsgcd8 = pZtyhyoujiranhidarimsgcd8;
    }

    private String ztyhyoujiranhidarimsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD9)
    public String getZtyhyoujiranhidarimsgcd9() {
        return ztyhyoujiranhidarimsgcd9;
    }

    public void setZtyhyoujiranhidarimsgcd9(String pZtyhyoujiranhidarimsgcd9) {
        ztyhyoujiranhidarimsgcd9 = pZtyhyoujiranhidarimsgcd9;
    }

    private String ztyhyoujiranhidarimsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD10)
    public String getZtyhyoujiranhidarimsgcd10() {
        return ztyhyoujiranhidarimsgcd10;
    }

    public void setZtyhyoujiranhidarimsgcd10(String pZtyhyoujiranhidarimsgcd10) {
        ztyhyoujiranhidarimsgcd10 = pZtyhyoujiranhidarimsgcd10;
    }

    private String ztyhyoujiranhidarimsgcd11;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD11)
    public String getZtyhyoujiranhidarimsgcd11() {
        return ztyhyoujiranhidarimsgcd11;
    }

    public void setZtyhyoujiranhidarimsgcd11(String pZtyhyoujiranhidarimsgcd11) {
        ztyhyoujiranhidarimsgcd11 = pZtyhyoujiranhidarimsgcd11;
    }

    private String ztyhyoujiranhidarimsgcd12;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD12)
    public String getZtyhyoujiranhidarimsgcd12() {
        return ztyhyoujiranhidarimsgcd12;
    }

    public void setZtyhyoujiranhidarimsgcd12(String pZtyhyoujiranhidarimsgcd12) {
        ztyhyoujiranhidarimsgcd12 = pZtyhyoujiranhidarimsgcd12;
    }

    private String ztyhyoujiranhidarimsgcd13;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD13)
    public String getZtyhyoujiranhidarimsgcd13() {
        return ztyhyoujiranhidarimsgcd13;
    }

    public void setZtyhyoujiranhidarimsgcd13(String pZtyhyoujiranhidarimsgcd13) {
        ztyhyoujiranhidarimsgcd13 = pZtyhyoujiranhidarimsgcd13;
    }

    private String ztyhyoujiranhidarimsgcd14;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD14)
    public String getZtyhyoujiranhidarimsgcd14() {
        return ztyhyoujiranhidarimsgcd14;
    }

    public void setZtyhyoujiranhidarimsgcd14(String pZtyhyoujiranhidarimsgcd14) {
        ztyhyoujiranhidarimsgcd14 = pZtyhyoujiranhidarimsgcd14;
    }

    private String ztyhyoujiranhidarimsgcd15;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD15)
    public String getZtyhyoujiranhidarimsgcd15() {
        return ztyhyoujiranhidarimsgcd15;
    }

    public void setZtyhyoujiranhidarimsgcd15(String pZtyhyoujiranhidarimsgcd15) {
        ztyhyoujiranhidarimsgcd15 = pZtyhyoujiranhidarimsgcd15;
    }

    private String ztyhyoujiranhidarimsgcd16;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD16)
    public String getZtyhyoujiranhidarimsgcd16() {
        return ztyhyoujiranhidarimsgcd16;
    }

    public void setZtyhyoujiranhidarimsgcd16(String pZtyhyoujiranhidarimsgcd16) {
        ztyhyoujiranhidarimsgcd16 = pZtyhyoujiranhidarimsgcd16;
    }

    private String ztyhyoujiranhidarimsgcd17;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD17)
    public String getZtyhyoujiranhidarimsgcd17() {
        return ztyhyoujiranhidarimsgcd17;
    }

    public void setZtyhyoujiranhidarimsgcd17(String pZtyhyoujiranhidarimsgcd17) {
        ztyhyoujiranhidarimsgcd17 = pZtyhyoujiranhidarimsgcd17;
    }

    private String ztyhyoujiranhidarimsgcd18;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD18)
    public String getZtyhyoujiranhidarimsgcd18() {
        return ztyhyoujiranhidarimsgcd18;
    }

    public void setZtyhyoujiranhidarimsgcd18(String pZtyhyoujiranhidarimsgcd18) {
        ztyhyoujiranhidarimsgcd18 = pZtyhyoujiranhidarimsgcd18;
    }

    private String ztyhyoujiranhidarimsgcd19;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD19)
    public String getZtyhyoujiranhidarimsgcd19() {
        return ztyhyoujiranhidarimsgcd19;
    }

    public void setZtyhyoujiranhidarimsgcd19(String pZtyhyoujiranhidarimsgcd19) {
        ztyhyoujiranhidarimsgcd19 = pZtyhyoujiranhidarimsgcd19;
    }

    private String ztyhyoujiranhidarimsgcd20;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANHIDARIMSGCD20)
    public String getZtyhyoujiranhidarimsgcd20() {
        return ztyhyoujiranhidarimsgcd20;
    }

    public void setZtyhyoujiranhidarimsgcd20(String pZtyhyoujiranhidarimsgcd20) {
        ztyhyoujiranhidarimsgcd20 = pZtyhyoujiranhidarimsgcd20;
    }

    private String ztyhyoujiranmigimsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD1)
    public String getZtyhyoujiranmigimsgcd1() {
        return ztyhyoujiranmigimsgcd1;
    }

    public void setZtyhyoujiranmigimsgcd1(String pZtyhyoujiranmigimsgcd1) {
        ztyhyoujiranmigimsgcd1 = pZtyhyoujiranmigimsgcd1;
    }

    private String ztyhyoujiranmigimsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD2)
    public String getZtyhyoujiranmigimsgcd2() {
        return ztyhyoujiranmigimsgcd2;
    }

    public void setZtyhyoujiranmigimsgcd2(String pZtyhyoujiranmigimsgcd2) {
        ztyhyoujiranmigimsgcd2 = pZtyhyoujiranmigimsgcd2;
    }

    private String ztyhyoujiranmigimsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD3)
    public String getZtyhyoujiranmigimsgcd3() {
        return ztyhyoujiranmigimsgcd3;
    }

    public void setZtyhyoujiranmigimsgcd3(String pZtyhyoujiranmigimsgcd3) {
        ztyhyoujiranmigimsgcd3 = pZtyhyoujiranmigimsgcd3;
    }

    private String ztyhyoujiranmigimsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD4)
    public String getZtyhyoujiranmigimsgcd4() {
        return ztyhyoujiranmigimsgcd4;
    }

    public void setZtyhyoujiranmigimsgcd4(String pZtyhyoujiranmigimsgcd4) {
        ztyhyoujiranmigimsgcd4 = pZtyhyoujiranmigimsgcd4;
    }

    private String ztyhyoujiranmigimsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD5)
    public String getZtyhyoujiranmigimsgcd5() {
        return ztyhyoujiranmigimsgcd5;
    }

    public void setZtyhyoujiranmigimsgcd5(String pZtyhyoujiranmigimsgcd5) {
        ztyhyoujiranmigimsgcd5 = pZtyhyoujiranmigimsgcd5;
    }

    private String ztyhyoujiranmigimsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD6)
    public String getZtyhyoujiranmigimsgcd6() {
        return ztyhyoujiranmigimsgcd6;
    }

    public void setZtyhyoujiranmigimsgcd6(String pZtyhyoujiranmigimsgcd6) {
        ztyhyoujiranmigimsgcd6 = pZtyhyoujiranmigimsgcd6;
    }

    private String ztyhyoujiranmigimsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD7)
    public String getZtyhyoujiranmigimsgcd7() {
        return ztyhyoujiranmigimsgcd7;
    }

    public void setZtyhyoujiranmigimsgcd7(String pZtyhyoujiranmigimsgcd7) {
        ztyhyoujiranmigimsgcd7 = pZtyhyoujiranmigimsgcd7;
    }

    private String ztyhyoujiranmigimsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD8)
    public String getZtyhyoujiranmigimsgcd8() {
        return ztyhyoujiranmigimsgcd8;
    }

    public void setZtyhyoujiranmigimsgcd8(String pZtyhyoujiranmigimsgcd8) {
        ztyhyoujiranmigimsgcd8 = pZtyhyoujiranmigimsgcd8;
    }

    private String ztyhyoujiranmigimsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD9)
    public String getZtyhyoujiranmigimsgcd9() {
        return ztyhyoujiranmigimsgcd9;
    }

    public void setZtyhyoujiranmigimsgcd9(String pZtyhyoujiranmigimsgcd9) {
        ztyhyoujiranmigimsgcd9 = pZtyhyoujiranmigimsgcd9;
    }

    private String ztyhyoujiranmigimsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD10)
    public String getZtyhyoujiranmigimsgcd10() {
        return ztyhyoujiranmigimsgcd10;
    }

    public void setZtyhyoujiranmigimsgcd10(String pZtyhyoujiranmigimsgcd10) {
        ztyhyoujiranmigimsgcd10 = pZtyhyoujiranmigimsgcd10;
    }

    private String ztyhyoujiranmigimsgcd11;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD11)
    public String getZtyhyoujiranmigimsgcd11() {
        return ztyhyoujiranmigimsgcd11;
    }

    public void setZtyhyoujiranmigimsgcd11(String pZtyhyoujiranmigimsgcd11) {
        ztyhyoujiranmigimsgcd11 = pZtyhyoujiranmigimsgcd11;
    }

    private String ztyhyoujiranmigimsgcd12;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD12)
    public String getZtyhyoujiranmigimsgcd12() {
        return ztyhyoujiranmigimsgcd12;
    }

    public void setZtyhyoujiranmigimsgcd12(String pZtyhyoujiranmigimsgcd12) {
        ztyhyoujiranmigimsgcd12 = pZtyhyoujiranmigimsgcd12;
    }

    private String ztyhyoujiranmigimsgcd13;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD13)
    public String getZtyhyoujiranmigimsgcd13() {
        return ztyhyoujiranmigimsgcd13;
    }

    public void setZtyhyoujiranmigimsgcd13(String pZtyhyoujiranmigimsgcd13) {
        ztyhyoujiranmigimsgcd13 = pZtyhyoujiranmigimsgcd13;
    }

    private String ztyhyoujiranmigimsgcd14;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD14)
    public String getZtyhyoujiranmigimsgcd14() {
        return ztyhyoujiranmigimsgcd14;
    }

    public void setZtyhyoujiranmigimsgcd14(String pZtyhyoujiranmigimsgcd14) {
        ztyhyoujiranmigimsgcd14 = pZtyhyoujiranmigimsgcd14;
    }

    private String ztyhyoujiranmigimsgcd15;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD15)
    public String getZtyhyoujiranmigimsgcd15() {
        return ztyhyoujiranmigimsgcd15;
    }

    public void setZtyhyoujiranmigimsgcd15(String pZtyhyoujiranmigimsgcd15) {
        ztyhyoujiranmigimsgcd15 = pZtyhyoujiranmigimsgcd15;
    }

    private String ztyhyoujiranmigimsgcd16;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD16)
    public String getZtyhyoujiranmigimsgcd16() {
        return ztyhyoujiranmigimsgcd16;
    }

    public void setZtyhyoujiranmigimsgcd16(String pZtyhyoujiranmigimsgcd16) {
        ztyhyoujiranmigimsgcd16 = pZtyhyoujiranmigimsgcd16;
    }

    private String ztyhyoujiranmigimsgcd17;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD17)
    public String getZtyhyoujiranmigimsgcd17() {
        return ztyhyoujiranmigimsgcd17;
    }

    public void setZtyhyoujiranmigimsgcd17(String pZtyhyoujiranmigimsgcd17) {
        ztyhyoujiranmigimsgcd17 = pZtyhyoujiranmigimsgcd17;
    }

    private String ztyhyoujiranmigimsgcd18;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD18)
    public String getZtyhyoujiranmigimsgcd18() {
        return ztyhyoujiranmigimsgcd18;
    }

    public void setZtyhyoujiranmigimsgcd18(String pZtyhyoujiranmigimsgcd18) {
        ztyhyoujiranmigimsgcd18 = pZtyhyoujiranmigimsgcd18;
    }

    private String ztyhyoujiranmigimsgcd19;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD19)
    public String getZtyhyoujiranmigimsgcd19() {
        return ztyhyoujiranmigimsgcd19;
    }

    public void setZtyhyoujiranmigimsgcd19(String pZtyhyoujiranmigimsgcd19) {
        ztyhyoujiranmigimsgcd19 = pZtyhyoujiranmigimsgcd19;
    }

    private String ztyhyoujiranmigimsgcd20;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANMIGIMSGCD20)
    public String getZtyhyoujiranmigimsgcd20() {
        return ztyhyoujiranmigimsgcd20;
    }

    public void setZtyhyoujiranmigimsgcd20(String pZtyhyoujiranmigimsgcd20) {
        ztyhyoujiranmigimsgcd20 = pZtyhyoujiranmigimsgcd20;
    }

    private String ztysknnkaisiymdseireki;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSKNNKAISIYMDSEIREKI)
    public String getZtysknnkaisiymdseireki() {
        return ztysknnkaisiymdseireki;
    }

    public void setZtysknnkaisiymdseireki(String pZtysknnkaisiymdseireki) {
        ztysknnkaisiymdseireki = pZtysknnkaisiymdseireki;
    }

    private String ztyhyoujiranytirrt;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANYTIRRT)
    public String getZtyhyoujiranytirrt() {
        return ztyhyoujiranytirrt;
    }

    public void setZtyhyoujiranytirrt(String pZtyhyoujiranytirrt) {
        ztyhyoujiranytirrt = pZtyhyoujiranytirrt;
    }

    private String ztyhyoujiransjkkktusirrt;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANSJKKKTUSIRRT)
    public String getZtyhyoujiransjkkktusirrt() {
        return ztyhyoujiransjkkktusirrt;
    }

    public void setZtyhyoujiransjkkktusirrt(String pZtyhyoujiransjkkktusirrt) {
        ztyhyoujiransjkkktusirrt = pZtyhyoujiransjkkktusirrt;
    }

    private String ztyhyoujirantumitateriritu;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANTUMITATERIRITU)
    public String getZtyhyoujirantumitateriritu() {
        return ztyhyoujirantumitateriritu;
    }

    public void setZtyhyoujirantumitateriritu(String pZtyhyoujirantumitateriritu) {
        ztyhyoujirantumitateriritu = pZtyhyoujirantumitateriritu;
    }

    private String ztyhyoujirantumitateriritu2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANTUMITATERIRITU2)
    public String getZtyhyoujirantumitateriritu2() {
        return ztyhyoujirantumitateriritu2;
    }

    public void setZtyhyoujirantumitateriritu2(String pZtyhyoujirantumitateriritu2) {
        ztyhyoujirantumitateriritu2 = pZtyhyoujirantumitateriritu2;
    }

    private String ztyhyoujirantmttknzkrtjygn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANTMTTKNZKRTJYGN)
    public String getZtyhyoujirantmttknzkrtjygn() {
        return ztyhyoujirantmttknzkrtjygn;
    }

    public void setZtyhyoujirantmttknzkrtjygn(String pZtyhyoujirantmttknzkrtjygn) {
        ztyhyoujirantmttknzkrtjygn = pZtyhyoujirantmttknzkrtjygn;
    }

    private String ztyhyoujiransetteibairitu;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHYOUJIRANSETTEIBAIRITU)
    public String getZtyhyoujiransetteibairitu() {
        return ztyhyoujiransetteibairitu;
    }

    public void setZtyhyoujiransetteibairitu(String pZtyhyoujiransetteibairitu) {
        ztyhyoujiransetteibairitu = pZtyhyoujiransetteibairitu;
    }

    private String ztyyobiv22x11;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22X11)
    public String getZtyyobiv22x11() {
        return ztyyobiv22x11;
    }

    public void setZtyyobiv22x11(String pZtyyobiv22x11) {
        ztyyobiv22x11 = pZtyyobiv22x11;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztysyoukenhakkouymd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYOUKENHAKKOUYMD)
    public String getZtysyoukenhakkouymd() {
        return ztysyoukenhakkouymd;
    }

    public void setZtysyoukenhakkouymd(String pZtysyoukenhakkouymd) {
        ztysyoukenhakkouymd = pZtysyoukenhakkouymd;
    }

    private String ztykouryokukaisimsg;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKOURYOKUKAISIMSG)
    public String getZtykouryokukaisimsg() {
        return ztykouryokukaisimsg;
    }

    public void setZtykouryokukaisimsg(String pZtykouryokukaisimsg) {
        ztykouryokukaisimsg = pZtykouryokukaisimsg;
    }

    private String ztyseisikihknnmsyouken;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSEISIKIHKNNMSYOUKEN)
    public String getZtyseisikihknnmsyouken() {
        return ztyseisikihknnmsyouken;
    }

    public void setZtyseisikihknnmsyouken(String pZtyseisikihknnmsyouken) {
        ztyseisikihknnmsyouken = pZtyseisikihknnmsyouken;
    }

    private String ztynksyuruinmsyouken;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKSYURUINMSYOUKEN)
    public String getZtynksyuruinmsyouken() {
        return ztynksyuruinmsyouken;
    }

    public void setZtynksyuruinmsyouken(String pZtynksyuruinmsyouken) {
        ztynksyuruinmsyouken = pZtynksyuruinmsyouken;
    }

    private String ztyyobiv116;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV116)
    public String getZtyyobiv116() {
        return ztyyobiv116;
    }

    public void setZtyyobiv116(String pZtyyobiv116) {
        ztyyobiv116 = pZtyyobiv116;
    }

    private String ztykyknmkj;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNMKJ)
    public String getZtykyknmkj() {
        return ztykyknmkj;
    }

    public void setZtykyknmkj(String pZtykyknmkj) {
        ztykyknmkj = pZtykyknmkj;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztyhihknsyaseiymdwareki;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHIHKNSYASEIYMDWAREKI)
    public String getZtyhihknsyaseiymdwareki() {
        return ztyhihknsyaseiymdwareki;
    }

    public void setZtyhihknsyaseiymdwareki(String pZtyhihknsyaseiymdwareki) {
        ztyhihknsyaseiymdwareki = pZtyhihknsyaseiymdwareki;
    }

    private String ztyhhknsei;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHHKNSEI)
    public String getZtyhhknsei() {
        return ztyhhknsei;
    }

    public void setZtyhhknsei(String pZtyhhknsei) {
        ztyhhknsei = pZtyhhknsei;
    }

    private String ztyhhknnen2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHHKNNEN2)
    public String getZtyhhknnen2() {
        return ztyhhknnen2;
    }

    public void setZtyhhknnen2(String pZtyhhknnen2) {
        ztyhhknnen2 = pZtyhhknnen2;
    }

    private String ztyuktmidasikbn1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTMIDASIKBN1)
    public String getZtyuktmidasikbn1() {
        return ztyuktmidasikbn1;
    }

    public void setZtyuktmidasikbn1(String pZtyuktmidasikbn1) {
        ztyuktmidasikbn1 = pZtyuktmidasikbn1;
    }

    private String ztyuktkbn1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTKBN1)
    public String getZtyuktkbn1() {
        return ztyuktkbn1;
    }

    public void setZtyuktkbn1(String pZtyuktkbn1) {
        ztyuktkbn1 = pZtyuktkbn1;
    }

    private String ztyuktnm1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTNM1)
    public String getZtyuktnm1() {
        return ztyuktnm1;
    }

    public void setZtyuktnm1(String pZtyuktnm1) {
        ztyuktnm1 = pZtyuktnm1;
    }

    private String ztyuktbnwari1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTBNWARI1)
    public String getZtyuktbnwari1() {
        return ztyuktbnwari1;
    }

    public void setZtyuktbnwari1(String pZtyuktbnwari1) {
        ztyuktbnwari1 = pZtyuktbnwari1;
    }

    private String ztyuktmidasikbn2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTMIDASIKBN2)
    public String getZtyuktmidasikbn2() {
        return ztyuktmidasikbn2;
    }

    public void setZtyuktmidasikbn2(String pZtyuktmidasikbn2) {
        ztyuktmidasikbn2 = pZtyuktmidasikbn2;
    }

    private String ztyuktkbn2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTKBN2)
    public String getZtyuktkbn2() {
        return ztyuktkbn2;
    }

    public void setZtyuktkbn2(String pZtyuktkbn2) {
        ztyuktkbn2 = pZtyuktkbn2;
    }

    private String ztyuktnm2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTNM2)
    public String getZtyuktnm2() {
        return ztyuktnm2;
    }

    public void setZtyuktnm2(String pZtyuktnm2) {
        ztyuktnm2 = pZtyuktnm2;
    }

    private String ztyuktbnwari2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTBNWARI2)
    public String getZtyuktbnwari2() {
        return ztyuktbnwari2;
    }

    public void setZtyuktbnwari2(String pZtyuktbnwari2) {
        ztyuktbnwari2 = pZtyuktbnwari2;
    }

    private String ztyuktmidasikbn3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTMIDASIKBN3)
    public String getZtyuktmidasikbn3() {
        return ztyuktmidasikbn3;
    }

    public void setZtyuktmidasikbn3(String pZtyuktmidasikbn3) {
        ztyuktmidasikbn3 = pZtyuktmidasikbn3;
    }

    private String ztyuktkbn3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTKBN3)
    public String getZtyuktkbn3() {
        return ztyuktkbn3;
    }

    public void setZtyuktkbn3(String pZtyuktkbn3) {
        ztyuktkbn3 = pZtyuktkbn3;
    }

    private String ztyuktnm3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTNM3)
    public String getZtyuktnm3() {
        return ztyuktnm3;
    }

    public void setZtyuktnm3(String pZtyuktnm3) {
        ztyuktnm3 = pZtyuktnm3;
    }

    private String ztyuktbnwari3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTBNWARI3)
    public String getZtyuktbnwari3() {
        return ztyuktbnwari3;
    }

    public void setZtyuktbnwari3(String pZtyuktbnwari3) {
        ztyuktbnwari3 = pZtyuktbnwari3;
    }

    private String ztyuktmidasikbn4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTMIDASIKBN4)
    public String getZtyuktmidasikbn4() {
        return ztyuktmidasikbn4;
    }

    public void setZtyuktmidasikbn4(String pZtyuktmidasikbn4) {
        ztyuktmidasikbn4 = pZtyuktmidasikbn4;
    }

    private String ztyuktkbn4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTKBN4)
    public String getZtyuktkbn4() {
        return ztyuktkbn4;
    }

    public void setZtyuktkbn4(String pZtyuktkbn4) {
        ztyuktkbn4 = pZtyuktkbn4;
    }

    private String ztyuktnm4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTNM4)
    public String getZtyuktnm4() {
        return ztyuktnm4;
    }

    public void setZtyuktnm4(String pZtyuktnm4) {
        ztyuktnm4 = pZtyuktnm4;
    }

    private String ztyuktbnwari4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTBNWARI4)
    public String getZtyuktbnwari4() {
        return ztyuktbnwari4;
    }

    public void setZtyuktbnwari4(String pZtyuktbnwari4) {
        ztyuktbnwari4 = pZtyuktbnwari4;
    }

    private String ztyuktmidasikbn5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTMIDASIKBN5)
    public String getZtyuktmidasikbn5() {
        return ztyuktmidasikbn5;
    }

    public void setZtyuktmidasikbn5(String pZtyuktmidasikbn5) {
        ztyuktmidasikbn5 = pZtyuktmidasikbn5;
    }

    private String ztyuktkbn5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTKBN5)
    public String getZtyuktkbn5() {
        return ztyuktkbn5;
    }

    public void setZtyuktkbn5(String pZtyuktkbn5) {
        ztyuktkbn5 = pZtyuktkbn5;
    }

    private String ztyuktnm5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTNM5)
    public String getZtyuktnm5() {
        return ztyuktnm5;
    }

    public void setZtyuktnm5(String pZtyuktnm5) {
        ztyuktnm5 = pZtyuktnm5;
    }

    private String ztyuktbnwari5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTBNWARI5)
    public String getZtyuktbnwari5() {
        return ztyuktbnwari5;
    }

    public void setZtyuktbnwari5(String pZtyuktbnwari5) {
        ztyuktbnwari5 = pZtyuktbnwari5;
    }

    private String ztyuktmidasikbn6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTMIDASIKBN6)
    public String getZtyuktmidasikbn6() {
        return ztyuktmidasikbn6;
    }

    public void setZtyuktmidasikbn6(String pZtyuktmidasikbn6) {
        ztyuktmidasikbn6 = pZtyuktmidasikbn6;
    }

    private String ztyuktkbn6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTKBN6)
    public String getZtyuktkbn6() {
        return ztyuktkbn6;
    }

    public void setZtyuktkbn6(String pZtyuktkbn6) {
        ztyuktkbn6 = pZtyuktkbn6;
    }

    private String ztyuktnm6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTNM6)
    public String getZtyuktnm6() {
        return ztyuktnm6;
    }

    public void setZtyuktnm6(String pZtyuktnm6) {
        ztyuktnm6 = pZtyuktnm6;
    }

    private String ztyuktbnwari6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTBNWARI6)
    public String getZtyuktbnwari6() {
        return ztyuktbnwari6;
    }

    public void setZtyuktbnwari6(String pZtyuktbnwari6) {
        ztyuktbnwari6 = pZtyuktbnwari6;
    }

    private String ztyuktmidasikbn7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTMIDASIKBN7)
    public String getZtyuktmidasikbn7() {
        return ztyuktmidasikbn7;
    }

    public void setZtyuktmidasikbn7(String pZtyuktmidasikbn7) {
        ztyuktmidasikbn7 = pZtyuktmidasikbn7;
    }

    private String ztyuktkbn7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTKBN7)
    public String getZtyuktkbn7() {
        return ztyuktkbn7;
    }

    public void setZtyuktkbn7(String pZtyuktkbn7) {
        ztyuktkbn7 = pZtyuktkbn7;
    }

    private String ztyuktnm7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTNM7)
    public String getZtyuktnm7() {
        return ztyuktnm7;
    }

    public void setZtyuktnm7(String pZtyuktnm7) {
        ztyuktnm7 = pZtyuktnm7;
    }

    private String ztyuktbnwari7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTBNWARI7)
    public String getZtyuktbnwari7() {
        return ztyuktbnwari7;
    }

    public void setZtyuktbnwari7(String pZtyuktbnwari7) {
        ztyuktbnwari7 = pZtyuktbnwari7;
    }

    private String ztyuktmidasikbn8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTMIDASIKBN8)
    public String getZtyuktmidasikbn8() {
        return ztyuktmidasikbn8;
    }

    public void setZtyuktmidasikbn8(String pZtyuktmidasikbn8) {
        ztyuktmidasikbn8 = pZtyuktmidasikbn8;
    }

    private String ztyuktkbn8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTKBN8)
    public String getZtyuktkbn8() {
        return ztyuktkbn8;
    }

    public void setZtyuktkbn8(String pZtyuktkbn8) {
        ztyuktkbn8 = pZtyuktkbn8;
    }

    private String ztyuktnm8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTNM8)
    public String getZtyuktnm8() {
        return ztyuktnm8;
    }

    public void setZtyuktnm8(String pZtyuktnm8) {
        ztyuktnm8 = pZtyuktnm8;
    }

    private String ztyuktbnwari8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTBNWARI8)
    public String getZtyuktbnwari8() {
        return ztyuktbnwari8;
    }

    public void setZtyuktbnwari8(String pZtyuktbnwari8) {
        ztyuktbnwari8 = pZtyuktbnwari8;
    }

    private String ztyuktmidasikbn9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTMIDASIKBN9)
    public String getZtyuktmidasikbn9() {
        return ztyuktmidasikbn9;
    }

    public void setZtyuktmidasikbn9(String pZtyuktmidasikbn9) {
        ztyuktmidasikbn9 = pZtyuktmidasikbn9;
    }

    private String ztyuktkbn9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTKBN9)
    public String getZtyuktkbn9() {
        return ztyuktkbn9;
    }

    public void setZtyuktkbn9(String pZtyuktkbn9) {
        ztyuktkbn9 = pZtyuktkbn9;
    }

    private String ztyuktnm9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTNM9)
    public String getZtyuktnm9() {
        return ztyuktnm9;
    }

    public void setZtyuktnm9(String pZtyuktnm9) {
        ztyuktnm9 = pZtyuktnm9;
    }

    private String ztyuktbnwari9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTBNWARI9)
    public String getZtyuktbnwari9() {
        return ztyuktbnwari9;
    }

    public void setZtyuktbnwari9(String pZtyuktbnwari9) {
        ztyuktbnwari9 = pZtyuktbnwari9;
    }

    private String ztyuktmidasikbn10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTMIDASIKBN10)
    public String getZtyuktmidasikbn10() {
        return ztyuktmidasikbn10;
    }

    public void setZtyuktmidasikbn10(String pZtyuktmidasikbn10) {
        ztyuktmidasikbn10 = pZtyuktmidasikbn10;
    }

    private String ztyuktkbn10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTKBN10)
    public String getZtyuktkbn10() {
        return ztyuktkbn10;
    }

    public void setZtyuktkbn10(String pZtyuktkbn10) {
        ztyuktkbn10 = pZtyuktkbn10;
    }

    private String ztyuktnm10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTNM10)
    public String getZtyuktnm10() {
        return ztyuktnm10;
    }

    public void setZtyuktnm10(String pZtyuktnm10) {
        ztyuktnm10 = pZtyuktnm10;
    }

    private String ztyuktbnwari10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYUKTBNWARI10)
    public String getZtyuktbnwari10() {
        return ztyuktbnwari10;
    }

    public void setZtyuktbnwari10(String pZtyuktbnwari10) {
        ztyuktbnwari10 = pZtyuktbnwari10;
    }

    private String ztyyobiv45;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV45)
    public String getZtyyobiv45() {
        return ztyyobiv45;
    }

    public void setZtyyobiv45(String pZtyyobiv45) {
        ztyyobiv45 = pZtyyobiv45;
    }

    private String ztypmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYPMSGCD1)
    public String getZtypmsgcd1() {
        return ztypmsgcd1;
    }

    public void setZtypmsgcd1(String pZtypmsgcd1) {
        ztypmsgcd1 = pZtypmsgcd1;
    }

    private String ztypmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYPMSGCD2)
    public String getZtypmsgcd2() {
        return ztypmsgcd2;
    }

    public void setZtypmsgcd2(String pZtypmsgcd2) {
        ztypmsgcd2 = pZtypmsgcd2;
    }

    private String ztypmsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYPMSGCD3)
    public String getZtypmsgcd3() {
        return ztypmsgcd3;
    }

    public void setZtypmsgcd3(String pZtypmsgcd3) {
        ztypmsgcd3 = pZtypmsgcd3;
    }

    private String ztyyobiv10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV10)
    public String getZtyyobiv10() {
        return ztyyobiv10;
    }

    public void setZtyyobiv10(String pZtyyobiv10) {
        ztyyobiv10 = pZtyyobiv10;
    }

    private String ztyptuukatype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYPTUUKATYPE)
    public String getZtyptuukatype() {
        return ztyptuukatype;
    }

    public void setZtyptuukatype(String pZtyptuukatype) {
        ztyptuukatype = pZtyptuukatype;
    }

    private String ztypkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYPKNGK)
    public String getZtypkngk() {
        return ztypkngk;
    }

    public void setZtypkngk(String pZtypkngk) {
        ztypkngk = pZtypkngk;
    }

    private String ztypkngktuuka;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYPKNGKTUUKA)
    public String getZtypkngktuuka() {
        return ztypkngktuuka;
    }

    public void setZtypkngktuuka(String pZtypkngktuuka) {
        ztypkngktuuka = pZtypkngktuuka;
    }

    private String ztyteikiikkatubaraitukisuu;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTEIKIIKKATUBARAITUKISUU)
    public String getZtyteikiikkatubaraitukisuu() {
        return ztyteikiikkatubaraitukisuu;
    }

    public void setZtyteikiikkatubaraitukisuu(String pZtyteikiikkatubaraitukisuu) {
        ztyteikiikkatubaraitukisuu = pZtyteikiikkatubaraitukisuu;
    }

    private String ztyztikiktbriyhrkgktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYZTIKIKTBRIYHRKGKTUKTYPE)
    public String getZtyztikiktbriyhrkgktuktype() {
        return ztyztikiktbriyhrkgktuktype;
    }

    public void setZtyztikiktbriyhrkgktuktype(String pZtyztikiktbriyhrkgktuktype) {
        ztyztikiktbriyhrkgktuktype = pZtyztikiktbriyhrkgktuktype;
    }

    private String ztyznntikiktbriyenhrkgk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYZNNTIKIKTBRIYENHRKGK)
    public String getZtyznntikiktbriyenhrkgk() {
        return ztyznntikiktbriyenhrkgk;
    }

    public void setZtyznntikiktbriyenhrkgk(String pZtyznntikiktbriyenhrkgk) {
        ztyznntikiktbriyenhrkgk = pZtyznntikiktbriyenhrkgk;
    }

    private String ztyznnkai;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYZNNKAI)
    public String getZtyznnkai() {
        return ztyznnkai;
    }

    public void setZtyznnkai(String pZtyznnkai) {
        ztyznnkai = pZtyznnkai;
    }

    private String ztyptokuyakumsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYPTOKUYAKUMSGCD)
    public String getZtyptokuyakumsgcd() {
        return ztyptokuyakumsgcd;
    }

    public void setZtyptokuyakumsgcd(String pZtyptokuyakumsgcd) {
        ztyptokuyakumsgcd = pZtyptokuyakumsgcd;
    }

    private String ztytikiktbriyhrkgktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTIKIKTBRIYHRKGKTUKTYPE)
    public String getZtytikiktbriyhrkgktuktype() {
        return ztytikiktbriyhrkgktuktype;
    }

    public void setZtytikiktbriyhrkgktuktype(String pZtytikiktbriyhrkgktuktype) {
        ztytikiktbriyhrkgktuktype = pZtytikiktbriyhrkgktuktype;
    }

    private String ztytikiktbriyenhrkgk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTIKIKTBRIYENHRKGK)
    public String getZtytikiktbriyenhrkgk() {
        return ztytikiktbriyenhrkgk;
    }

    public void setZtytikiktbriyenhrkgk(String pZtytikiktbriyenhrkgk) {
        ztytikiktbriyenhrkgk = pZtytikiktbriyenhrkgk;
    }

    private String ztyyobiv32;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV32)
    public String getZtyyobiv32() {
        return ztyyobiv32;
    }

    public void setZtyyobiv32(String pZtyyobiv32) {
        ztyyobiv32 = pZtyyobiv32;
    }

    private String ztykykymdseireki;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKYMDSEIREKI)
    public String getZtykykymdseireki() {
        return ztykykymdseireki;
    }

    public void setZtykykymdseireki(String pZtykykymdseireki) {
        ztykykymdseireki = pZtykykymdseireki;
    }

    private String ztyphrkkknmidasikbn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYPHRKKKNMIDASIKBN)
    public String getZtyphrkkknmidasikbn() {
        return ztyphrkkknmidasikbn;
    }

    public void setZtyphrkkknmidasikbn(String pZtyphrkkknmidasikbn) {
        ztyphrkkknmidasikbn = pZtyphrkkknmidasikbn;
    }

    private String ztyhrkkknmsgkbn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHRKKKNMSGKBN)
    public String getZtyhrkkknmsgkbn() {
        return ztyhrkkknmsgkbn;
    }

    public void setZtyhrkkknmsgkbn(String pZtyhrkkknmsgkbn) {
        ztyhrkkknmsgkbn = pZtyhrkkknmsgkbn;
    }

    private String ztyhrkkaisuumsgkbn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHRKKAISUUMSGKBN)
    public String getZtyhrkkaisuumsgkbn() {
        return ztyhrkkaisuumsgkbn;
    }

    public void setZtyhrkkaisuumsgkbn(String pZtyhrkkaisuumsgkbn) {
        ztyhrkkaisuumsgkbn = pZtyhrkkaisuumsgkbn;
    }

    private String ztyphrkktuki;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYPHRKKTUKI)
    public String getZtyphrkktuki() {
        return ztyphrkktuki;
    }

    public void setZtyphrkktuki(String pZtyphrkktuki) {
        ztyphrkktuki = pZtyphrkktuki;
    }

    private String ztyhrkhouhoumsgkbn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHRKHOUHOUMSGKBN)
    public String getZtyhrkhouhoumsgkbn() {
        return ztyhrkhouhoumsgkbn;
    }

    public void setZtyhrkhouhoumsgkbn(String pZtyhrkhouhoumsgkbn) {
        ztyhrkhouhoumsgkbn = pZtyhrkhouhoumsgkbn;
    }

    private String ztyyobiv18;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV18)
    public String getZtyyobiv18() {
        return ztyyobiv18;
    }

    public void setZtyyobiv18(String pZtyyobiv18) {
        ztyyobiv18 = pZtyyobiv18;
    }

    private String ztysyukyktkykrenban1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKRENBAN1)
    public String getZtysyukyktkykrenban1() {
        return ztysyukyktkykrenban1;
    }

    public void setZtysyukyktkykrenban1(String pZtysyukyktkykrenban1) {
        ztysyukyktkykrenban1 = pZtysyukyktkykrenban1;
    }

    private String ztysyukyktkykmsgkbn1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKMSGKBN1)
    public String getZtysyukyktkykmsgkbn1() {
        return ztysyukyktkykmsgkbn1;
    }

    public void setZtysyukyktkykmsgkbn1(String pZtysyukyktkykmsgkbn1) {
        ztysyukyktkykmsgkbn1 = pZtysyukyktkykmsgkbn1;
    }

    private String ztysyukyktkyksmsgkbn1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSMSGKBN1)
    public String getZtysyukyktkyksmsgkbn1() {
        return ztysyukyktkyksmsgkbn1;
    }

    public void setZtysyukyktkyksmsgkbn1(String pZtysyukyktkyksmsgkbn1) {
        ztysyukyktkyksmsgkbn1 = pZtysyukyktkyksmsgkbn1;
    }

    private String ztysyukyktkykhknkknmsgkbn1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKKNMSGKBN1)
    public String getZtysyukyktkykhknkknmsgkbn1() {
        return ztysyukyktkykhknkknmsgkbn1;
    }

    public void setZtysyukyktkykhknkknmsgkbn1(String pZtysyukyktkykhknkknmsgkbn1) {
        ztysyukyktkykhknkknmsgkbn1 = pZtysyukyktkykhknkknmsgkbn1;
    }

    private String ztysyukyktkykstuukatype1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSTUUKATYPE1)
    public String getZtysyukyktkykstuukatype1() {
        return ztysyukyktkykstuukatype1;
    }

    public void setZtysyukyktkykstuukatype1(String pZtysyukyktkykstuukatype1) {
        ztysyukyktkykstuukatype1 = pZtysyukyktkykstuukatype1;
    }

    private String ztysyukyktkykhknkngk1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKNGK1)
    public String getZtysyukyktkykhknkngk1() {
        return ztysyukyktkykhknkngk1;
    }

    public void setZtysyukyktkykhknkngk1(String pZtysyukyktkykhknkngk1) {
        ztysyukyktkykhknkngk1 = pZtysyukyktkykhknkngk1;
    }

    private String ztysyutkdai1hknkknymdto1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI1HKNKKNYMDTO1)
    public String getZtysyutkdai1hknkknymdto1() {
        return ztysyutkdai1hknkknymdto1;
    }

    public void setZtysyutkdai1hknkknymdto1(String pZtysyutkdai1hknkknymdto1) {
        ztysyutkdai1hknkknymdto1 = pZtysyutkdai1hknkknymdto1;
    }

    private String ztysyutkdai2hknkknymdto1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI2HKNKKNYMDTO1)
    public String getZtysyutkdai2hknkknymdto1() {
        return ztysyutkdai2hknkknymdto1;
    }

    public void setZtysyutkdai2hknkknymdto1(String pZtysyutkdai2hknkknymdto1) {
        ztysyutkdai2hknkknymdto1 = pZtysyutkdai2hknkknymdto1;
    }

    private String ztyyobiv22;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22)
    public String getZtyyobiv22() {
        return ztyyobiv22;
    }

    public void setZtyyobiv22(String pZtyyobiv22) {
        ztyyobiv22 = pZtyyobiv22;
    }

    private String ztysyukyktkykrenban2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKRENBAN2)
    public String getZtysyukyktkykrenban2() {
        return ztysyukyktkykrenban2;
    }

    public void setZtysyukyktkykrenban2(String pZtysyukyktkykrenban2) {
        ztysyukyktkykrenban2 = pZtysyukyktkykrenban2;
    }

    private String ztysyukyktkykmsgkbn2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKMSGKBN2)
    public String getZtysyukyktkykmsgkbn2() {
        return ztysyukyktkykmsgkbn2;
    }

    public void setZtysyukyktkykmsgkbn2(String pZtysyukyktkykmsgkbn2) {
        ztysyukyktkykmsgkbn2 = pZtysyukyktkykmsgkbn2;
    }

    private String ztysyukyktkyksmsgkbn2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSMSGKBN2)
    public String getZtysyukyktkyksmsgkbn2() {
        return ztysyukyktkyksmsgkbn2;
    }

    public void setZtysyukyktkyksmsgkbn2(String pZtysyukyktkyksmsgkbn2) {
        ztysyukyktkyksmsgkbn2 = pZtysyukyktkyksmsgkbn2;
    }

    private String ztysyukyktkykhknkknmsgkbn2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKKNMSGKBN2)
    public String getZtysyukyktkykhknkknmsgkbn2() {
        return ztysyukyktkykhknkknmsgkbn2;
    }

    public void setZtysyukyktkykhknkknmsgkbn2(String pZtysyukyktkykhknkknmsgkbn2) {
        ztysyukyktkykhknkknmsgkbn2 = pZtysyukyktkykhknkknmsgkbn2;
    }

    private String ztysyukyktkykstuukatype2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSTUUKATYPE2)
    public String getZtysyukyktkykstuukatype2() {
        return ztysyukyktkykstuukatype2;
    }

    public void setZtysyukyktkykstuukatype2(String pZtysyukyktkykstuukatype2) {
        ztysyukyktkykstuukatype2 = pZtysyukyktkykstuukatype2;
    }

    private String ztysyukyktkykhknkngk2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKNGK2)
    public String getZtysyukyktkykhknkngk2() {
        return ztysyukyktkykhknkngk2;
    }

    public void setZtysyukyktkykhknkngk2(String pZtysyukyktkykhknkngk2) {
        ztysyukyktkykhknkngk2 = pZtysyukyktkykhknkngk2;
    }

    private String ztysyutkdai1hknkknymdto2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI1HKNKKNYMDTO2)
    public String getZtysyutkdai1hknkknymdto2() {
        return ztysyutkdai1hknkknymdto2;
    }

    public void setZtysyutkdai1hknkknymdto2(String pZtysyutkdai1hknkknymdto2) {
        ztysyutkdai1hknkknymdto2 = pZtysyutkdai1hknkknymdto2;
    }

    private String ztysyutkdai2hknkknymdto2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI2HKNKKNYMDTO2)
    public String getZtysyutkdai2hknkknymdto2() {
        return ztysyutkdai2hknkknymdto2;
    }

    public void setZtysyutkdai2hknkknymdto2(String pZtysyutkdai2hknkknymdto2) {
        ztysyutkdai2hknkknymdto2 = pZtysyutkdai2hknkknymdto2;
    }

    private String ztyyobiv22x2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22X2)
    public String getZtyyobiv22x2() {
        return ztyyobiv22x2;
    }

    public void setZtyyobiv22x2(String pZtyyobiv22x2) {
        ztyyobiv22x2 = pZtyyobiv22x2;
    }

    private String ztysyukyktkykrenban3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKRENBAN3)
    public String getZtysyukyktkykrenban3() {
        return ztysyukyktkykrenban3;
    }

    public void setZtysyukyktkykrenban3(String pZtysyukyktkykrenban3) {
        ztysyukyktkykrenban3 = pZtysyukyktkykrenban3;
    }

    private String ztysyukyktkykmsgkbn3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKMSGKBN3)
    public String getZtysyukyktkykmsgkbn3() {
        return ztysyukyktkykmsgkbn3;
    }

    public void setZtysyukyktkykmsgkbn3(String pZtysyukyktkykmsgkbn3) {
        ztysyukyktkykmsgkbn3 = pZtysyukyktkykmsgkbn3;
    }

    private String ztysyukyktkyksmsgkbn3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSMSGKBN3)
    public String getZtysyukyktkyksmsgkbn3() {
        return ztysyukyktkyksmsgkbn3;
    }

    public void setZtysyukyktkyksmsgkbn3(String pZtysyukyktkyksmsgkbn3) {
        ztysyukyktkyksmsgkbn3 = pZtysyukyktkyksmsgkbn3;
    }

    private String ztysyukyktkykhknkknmsgkbn3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKKNMSGKBN3)
    public String getZtysyukyktkykhknkknmsgkbn3() {
        return ztysyukyktkykhknkknmsgkbn3;
    }

    public void setZtysyukyktkykhknkknmsgkbn3(String pZtysyukyktkykhknkknmsgkbn3) {
        ztysyukyktkykhknkknmsgkbn3 = pZtysyukyktkykhknkknmsgkbn3;
    }

    private String ztysyukyktkykstuukatype3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSTUUKATYPE3)
    public String getZtysyukyktkykstuukatype3() {
        return ztysyukyktkykstuukatype3;
    }

    public void setZtysyukyktkykstuukatype3(String pZtysyukyktkykstuukatype3) {
        ztysyukyktkykstuukatype3 = pZtysyukyktkykstuukatype3;
    }

    private String ztysyukyktkykhknkngk3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKNGK3)
    public String getZtysyukyktkykhknkngk3() {
        return ztysyukyktkykhknkngk3;
    }

    public void setZtysyukyktkykhknkngk3(String pZtysyukyktkykhknkngk3) {
        ztysyukyktkykhknkngk3 = pZtysyukyktkykhknkngk3;
    }

    private String ztysyutkdai1hknkknymdto3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI1HKNKKNYMDTO3)
    public String getZtysyutkdai1hknkknymdto3() {
        return ztysyutkdai1hknkknymdto3;
    }

    public void setZtysyutkdai1hknkknymdto3(String pZtysyutkdai1hknkknymdto3) {
        ztysyutkdai1hknkknymdto3 = pZtysyutkdai1hknkknymdto3;
    }

    private String ztysyutkdai2hknkknymdto3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI2HKNKKNYMDTO3)
    public String getZtysyutkdai2hknkknymdto3() {
        return ztysyutkdai2hknkknymdto3;
    }

    public void setZtysyutkdai2hknkknymdto3(String pZtysyutkdai2hknkknymdto3) {
        ztysyutkdai2hknkknymdto3 = pZtysyutkdai2hknkknymdto3;
    }

    private String ztyyobiv22x3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22X3)
    public String getZtyyobiv22x3() {
        return ztyyobiv22x3;
    }

    public void setZtyyobiv22x3(String pZtyyobiv22x3) {
        ztyyobiv22x3 = pZtyyobiv22x3;
    }

    private String ztysyukyktkykrenban4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKRENBAN4)
    public String getZtysyukyktkykrenban4() {
        return ztysyukyktkykrenban4;
    }

    public void setZtysyukyktkykrenban4(String pZtysyukyktkykrenban4) {
        ztysyukyktkykrenban4 = pZtysyukyktkykrenban4;
    }

    private String ztysyukyktkykmsgkbn4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKMSGKBN4)
    public String getZtysyukyktkykmsgkbn4() {
        return ztysyukyktkykmsgkbn4;
    }

    public void setZtysyukyktkykmsgkbn4(String pZtysyukyktkykmsgkbn4) {
        ztysyukyktkykmsgkbn4 = pZtysyukyktkykmsgkbn4;
    }

    private String ztysyukyktkyksmsgkbn4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSMSGKBN4)
    public String getZtysyukyktkyksmsgkbn4() {
        return ztysyukyktkyksmsgkbn4;
    }

    public void setZtysyukyktkyksmsgkbn4(String pZtysyukyktkyksmsgkbn4) {
        ztysyukyktkyksmsgkbn4 = pZtysyukyktkyksmsgkbn4;
    }

    private String ztysyukyktkykhknkknmsgkbn4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKKNMSGKBN4)
    public String getZtysyukyktkykhknkknmsgkbn4() {
        return ztysyukyktkykhknkknmsgkbn4;
    }

    public void setZtysyukyktkykhknkknmsgkbn4(String pZtysyukyktkykhknkknmsgkbn4) {
        ztysyukyktkykhknkknmsgkbn4 = pZtysyukyktkykhknkknmsgkbn4;
    }

    private String ztysyukyktkykstuukatype4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSTUUKATYPE4)
    public String getZtysyukyktkykstuukatype4() {
        return ztysyukyktkykstuukatype4;
    }

    public void setZtysyukyktkykstuukatype4(String pZtysyukyktkykstuukatype4) {
        ztysyukyktkykstuukatype4 = pZtysyukyktkykstuukatype4;
    }

    private String ztysyukyktkykhknkngk4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKNGK4)
    public String getZtysyukyktkykhknkngk4() {
        return ztysyukyktkykhknkngk4;
    }

    public void setZtysyukyktkykhknkngk4(String pZtysyukyktkykhknkngk4) {
        ztysyukyktkykhknkngk4 = pZtysyukyktkykhknkngk4;
    }

    private String ztysyutkdai1hknkknymdto4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI1HKNKKNYMDTO4)
    public String getZtysyutkdai1hknkknymdto4() {
        return ztysyutkdai1hknkknymdto4;
    }

    public void setZtysyutkdai1hknkknymdto4(String pZtysyutkdai1hknkknymdto4) {
        ztysyutkdai1hknkknymdto4 = pZtysyutkdai1hknkknymdto4;
    }

    private String ztysyutkdai2hknkknymdto4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI2HKNKKNYMDTO4)
    public String getZtysyutkdai2hknkknymdto4() {
        return ztysyutkdai2hknkknymdto4;
    }

    public void setZtysyutkdai2hknkknymdto4(String pZtysyutkdai2hknkknymdto4) {
        ztysyutkdai2hknkknymdto4 = pZtysyutkdai2hknkknymdto4;
    }

    private String ztyyobiv22x4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22X4)
    public String getZtyyobiv22x4() {
        return ztyyobiv22x4;
    }

    public void setZtyyobiv22x4(String pZtyyobiv22x4) {
        ztyyobiv22x4 = pZtyyobiv22x4;
    }

    private String ztysyukyktkykrenban5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKRENBAN5)
    public String getZtysyukyktkykrenban5() {
        return ztysyukyktkykrenban5;
    }

    public void setZtysyukyktkykrenban5(String pZtysyukyktkykrenban5) {
        ztysyukyktkykrenban5 = pZtysyukyktkykrenban5;
    }

    private String ztysyukyktkykmsgkbn5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKMSGKBN5)
    public String getZtysyukyktkykmsgkbn5() {
        return ztysyukyktkykmsgkbn5;
    }

    public void setZtysyukyktkykmsgkbn5(String pZtysyukyktkykmsgkbn5) {
        ztysyukyktkykmsgkbn5 = pZtysyukyktkykmsgkbn5;
    }

    private String ztysyukyktkyksmsgkbn5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSMSGKBN5)
    public String getZtysyukyktkyksmsgkbn5() {
        return ztysyukyktkyksmsgkbn5;
    }

    public void setZtysyukyktkyksmsgkbn5(String pZtysyukyktkyksmsgkbn5) {
        ztysyukyktkyksmsgkbn5 = pZtysyukyktkyksmsgkbn5;
    }

    private String ztysyukyktkykhknkknmsgkbn5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKKNMSGKBN5)
    public String getZtysyukyktkykhknkknmsgkbn5() {
        return ztysyukyktkykhknkknmsgkbn5;
    }

    public void setZtysyukyktkykhknkknmsgkbn5(String pZtysyukyktkykhknkknmsgkbn5) {
        ztysyukyktkykhknkknmsgkbn5 = pZtysyukyktkykhknkknmsgkbn5;
    }

    private String ztysyukyktkykstuukatype5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSTUUKATYPE5)
    public String getZtysyukyktkykstuukatype5() {
        return ztysyukyktkykstuukatype5;
    }

    public void setZtysyukyktkykstuukatype5(String pZtysyukyktkykstuukatype5) {
        ztysyukyktkykstuukatype5 = pZtysyukyktkykstuukatype5;
    }

    private String ztysyukyktkykhknkngk5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKNGK5)
    public String getZtysyukyktkykhknkngk5() {
        return ztysyukyktkykhknkngk5;
    }

    public void setZtysyukyktkykhknkngk5(String pZtysyukyktkykhknkngk5) {
        ztysyukyktkykhknkngk5 = pZtysyukyktkykhknkngk5;
    }

    private String ztysyutkdai1hknkknymdto5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI1HKNKKNYMDTO5)
    public String getZtysyutkdai1hknkknymdto5() {
        return ztysyutkdai1hknkknymdto5;
    }

    public void setZtysyutkdai1hknkknymdto5(String pZtysyutkdai1hknkknymdto5) {
        ztysyutkdai1hknkknymdto5 = pZtysyutkdai1hknkknymdto5;
    }

    private String ztysyutkdai2hknkknymdto5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI2HKNKKNYMDTO5)
    public String getZtysyutkdai2hknkknymdto5() {
        return ztysyutkdai2hknkknymdto5;
    }

    public void setZtysyutkdai2hknkknymdto5(String pZtysyutkdai2hknkknymdto5) {
        ztysyutkdai2hknkknymdto5 = pZtysyutkdai2hknkknymdto5;
    }

    private String ztyyobiv22x5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22X5)
    public String getZtyyobiv22x5() {
        return ztyyobiv22x5;
    }

    public void setZtyyobiv22x5(String pZtyyobiv22x5) {
        ztyyobiv22x5 = pZtyyobiv22x5;
    }

    private String ztysyukyktkykrenban6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKRENBAN6)
    public String getZtysyukyktkykrenban6() {
        return ztysyukyktkykrenban6;
    }

    public void setZtysyukyktkykrenban6(String pZtysyukyktkykrenban6) {
        ztysyukyktkykrenban6 = pZtysyukyktkykrenban6;
    }

    private String ztysyukyktkykmsgkbn6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKMSGKBN6)
    public String getZtysyukyktkykmsgkbn6() {
        return ztysyukyktkykmsgkbn6;
    }

    public void setZtysyukyktkykmsgkbn6(String pZtysyukyktkykmsgkbn6) {
        ztysyukyktkykmsgkbn6 = pZtysyukyktkykmsgkbn6;
    }

    private String ztysyukyktkyksmsgkbn6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSMSGKBN6)
    public String getZtysyukyktkyksmsgkbn6() {
        return ztysyukyktkyksmsgkbn6;
    }

    public void setZtysyukyktkyksmsgkbn6(String pZtysyukyktkyksmsgkbn6) {
        ztysyukyktkyksmsgkbn6 = pZtysyukyktkyksmsgkbn6;
    }

    private String ztysyukyktkykhknkknmsgkbn6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKKNMSGKBN6)
    public String getZtysyukyktkykhknkknmsgkbn6() {
        return ztysyukyktkykhknkknmsgkbn6;
    }

    public void setZtysyukyktkykhknkknmsgkbn6(String pZtysyukyktkykhknkknmsgkbn6) {
        ztysyukyktkykhknkknmsgkbn6 = pZtysyukyktkykhknkknmsgkbn6;
    }

    private String ztysyukyktkykstuukatype6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSTUUKATYPE6)
    public String getZtysyukyktkykstuukatype6() {
        return ztysyukyktkykstuukatype6;
    }

    public void setZtysyukyktkykstuukatype6(String pZtysyukyktkykstuukatype6) {
        ztysyukyktkykstuukatype6 = pZtysyukyktkykstuukatype6;
    }

    private String ztysyukyktkykhknkngk6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKNGK6)
    public String getZtysyukyktkykhknkngk6() {
        return ztysyukyktkykhknkngk6;
    }

    public void setZtysyukyktkykhknkngk6(String pZtysyukyktkykhknkngk6) {
        ztysyukyktkykhknkngk6 = pZtysyukyktkykhknkngk6;
    }

    private String ztysyutkdai1hknkknymdto6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI1HKNKKNYMDTO6)
    public String getZtysyutkdai1hknkknymdto6() {
        return ztysyutkdai1hknkknymdto6;
    }

    public void setZtysyutkdai1hknkknymdto6(String pZtysyutkdai1hknkknymdto6) {
        ztysyutkdai1hknkknymdto6 = pZtysyutkdai1hknkknymdto6;
    }

    private String ztysyutkdai2hknkknymdto6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI2HKNKKNYMDTO6)
    public String getZtysyutkdai2hknkknymdto6() {
        return ztysyutkdai2hknkknymdto6;
    }

    public void setZtysyutkdai2hknkknymdto6(String pZtysyutkdai2hknkknymdto6) {
        ztysyutkdai2hknkknymdto6 = pZtysyutkdai2hknkknymdto6;
    }

    private String ztyyobiv22x6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22X6)
    public String getZtyyobiv22x6() {
        return ztyyobiv22x6;
    }

    public void setZtyyobiv22x6(String pZtyyobiv22x6) {
        ztyyobiv22x6 = pZtyyobiv22x6;
    }

    private String ztysyukyktkykrenban7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKRENBAN7)
    public String getZtysyukyktkykrenban7() {
        return ztysyukyktkykrenban7;
    }

    public void setZtysyukyktkykrenban7(String pZtysyukyktkykrenban7) {
        ztysyukyktkykrenban7 = pZtysyukyktkykrenban7;
    }

    private String ztysyukyktkykmsgkbn7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKMSGKBN7)
    public String getZtysyukyktkykmsgkbn7() {
        return ztysyukyktkykmsgkbn7;
    }

    public void setZtysyukyktkykmsgkbn7(String pZtysyukyktkykmsgkbn7) {
        ztysyukyktkykmsgkbn7 = pZtysyukyktkykmsgkbn7;
    }

    private String ztysyukyktkyksmsgkbn7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSMSGKBN7)
    public String getZtysyukyktkyksmsgkbn7() {
        return ztysyukyktkyksmsgkbn7;
    }

    public void setZtysyukyktkyksmsgkbn7(String pZtysyukyktkyksmsgkbn7) {
        ztysyukyktkyksmsgkbn7 = pZtysyukyktkyksmsgkbn7;
    }

    private String ztysyukyktkykhknkknmsgkbn7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKKNMSGKBN7)
    public String getZtysyukyktkykhknkknmsgkbn7() {
        return ztysyukyktkykhknkknmsgkbn7;
    }

    public void setZtysyukyktkykhknkknmsgkbn7(String pZtysyukyktkykhknkknmsgkbn7) {
        ztysyukyktkykhknkknmsgkbn7 = pZtysyukyktkykhknkknmsgkbn7;
    }

    private String ztysyukyktkykstuukatype7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSTUUKATYPE7)
    public String getZtysyukyktkykstuukatype7() {
        return ztysyukyktkykstuukatype7;
    }

    public void setZtysyukyktkykstuukatype7(String pZtysyukyktkykstuukatype7) {
        ztysyukyktkykstuukatype7 = pZtysyukyktkykstuukatype7;
    }

    private String ztysyukyktkykhknkngk7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKNGK7)
    public String getZtysyukyktkykhknkngk7() {
        return ztysyukyktkykhknkngk7;
    }

    public void setZtysyukyktkykhknkngk7(String pZtysyukyktkykhknkngk7) {
        ztysyukyktkykhknkngk7 = pZtysyukyktkykhknkngk7;
    }

    private String ztysyutkdai1hknkknymdto7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI1HKNKKNYMDTO7)
    public String getZtysyutkdai1hknkknymdto7() {
        return ztysyutkdai1hknkknymdto7;
    }

    public void setZtysyutkdai1hknkknymdto7(String pZtysyutkdai1hknkknymdto7) {
        ztysyutkdai1hknkknymdto7 = pZtysyutkdai1hknkknymdto7;
    }

    private String ztysyutkdai2hknkknymdto7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI2HKNKKNYMDTO7)
    public String getZtysyutkdai2hknkknymdto7() {
        return ztysyutkdai2hknkknymdto7;
    }

    public void setZtysyutkdai2hknkknymdto7(String pZtysyutkdai2hknkknymdto7) {
        ztysyutkdai2hknkknymdto7 = pZtysyutkdai2hknkknymdto7;
    }

    private String ztyyobiv22x7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22X7)
    public String getZtyyobiv22x7() {
        return ztyyobiv22x7;
    }

    public void setZtyyobiv22x7(String pZtyyobiv22x7) {
        ztyyobiv22x7 = pZtyyobiv22x7;
    }

    private String ztysyukyktkykrenban8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKRENBAN8)
    public String getZtysyukyktkykrenban8() {
        return ztysyukyktkykrenban8;
    }

    public void setZtysyukyktkykrenban8(String pZtysyukyktkykrenban8) {
        ztysyukyktkykrenban8 = pZtysyukyktkykrenban8;
    }

    private String ztysyukyktkykmsgkbn8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKMSGKBN8)
    public String getZtysyukyktkykmsgkbn8() {
        return ztysyukyktkykmsgkbn8;
    }

    public void setZtysyukyktkykmsgkbn8(String pZtysyukyktkykmsgkbn8) {
        ztysyukyktkykmsgkbn8 = pZtysyukyktkykmsgkbn8;
    }

    private String ztysyukyktkyksmsgkbn8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSMSGKBN8)
    public String getZtysyukyktkyksmsgkbn8() {
        return ztysyukyktkyksmsgkbn8;
    }

    public void setZtysyukyktkyksmsgkbn8(String pZtysyukyktkyksmsgkbn8) {
        ztysyukyktkyksmsgkbn8 = pZtysyukyktkyksmsgkbn8;
    }

    private String ztysyukyktkykhknkknmsgkbn8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKKNMSGKBN8)
    public String getZtysyukyktkykhknkknmsgkbn8() {
        return ztysyukyktkykhknkknmsgkbn8;
    }

    public void setZtysyukyktkykhknkknmsgkbn8(String pZtysyukyktkykhknkknmsgkbn8) {
        ztysyukyktkykhknkknmsgkbn8 = pZtysyukyktkykhknkknmsgkbn8;
    }

    private String ztysyukyktkykstuukatype8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSTUUKATYPE8)
    public String getZtysyukyktkykstuukatype8() {
        return ztysyukyktkykstuukatype8;
    }

    public void setZtysyukyktkykstuukatype8(String pZtysyukyktkykstuukatype8) {
        ztysyukyktkykstuukatype8 = pZtysyukyktkykstuukatype8;
    }

    private String ztysyukyktkykhknkngk8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKNGK8)
    public String getZtysyukyktkykhknkngk8() {
        return ztysyukyktkykhknkngk8;
    }

    public void setZtysyukyktkykhknkngk8(String pZtysyukyktkykhknkngk8) {
        ztysyukyktkykhknkngk8 = pZtysyukyktkykhknkngk8;
    }

    private String ztysyutkdai1hknkknymdto8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI1HKNKKNYMDTO8)
    public String getZtysyutkdai1hknkknymdto8() {
        return ztysyutkdai1hknkknymdto8;
    }

    public void setZtysyutkdai1hknkknymdto8(String pZtysyutkdai1hknkknymdto8) {
        ztysyutkdai1hknkknymdto8 = pZtysyutkdai1hknkknymdto8;
    }

    private String ztysyutkdai2hknkknymdto8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI2HKNKKNYMDTO8)
    public String getZtysyutkdai2hknkknymdto8() {
        return ztysyutkdai2hknkknymdto8;
    }

    public void setZtysyutkdai2hknkknymdto8(String pZtysyutkdai2hknkknymdto8) {
        ztysyutkdai2hknkknymdto8 = pZtysyutkdai2hknkknymdto8;
    }

    private String ztyyobiv22x8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22X8)
    public String getZtyyobiv22x8() {
        return ztyyobiv22x8;
    }

    public void setZtyyobiv22x8(String pZtyyobiv22x8) {
        ztyyobiv22x8 = pZtyyobiv22x8;
    }

    private String ztysyukyktkykrenban9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKRENBAN9)
    public String getZtysyukyktkykrenban9() {
        return ztysyukyktkykrenban9;
    }

    public void setZtysyukyktkykrenban9(String pZtysyukyktkykrenban9) {
        ztysyukyktkykrenban9 = pZtysyukyktkykrenban9;
    }

    private String ztysyukyktkykmsgkbn9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKMSGKBN9)
    public String getZtysyukyktkykmsgkbn9() {
        return ztysyukyktkykmsgkbn9;
    }

    public void setZtysyukyktkykmsgkbn9(String pZtysyukyktkykmsgkbn9) {
        ztysyukyktkykmsgkbn9 = pZtysyukyktkykmsgkbn9;
    }

    private String ztysyukyktkyksmsgkbn9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSMSGKBN9)
    public String getZtysyukyktkyksmsgkbn9() {
        return ztysyukyktkyksmsgkbn9;
    }

    public void setZtysyukyktkyksmsgkbn9(String pZtysyukyktkyksmsgkbn9) {
        ztysyukyktkyksmsgkbn9 = pZtysyukyktkyksmsgkbn9;
    }

    private String ztysyukyktkykhknkknmsgkbn9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKKNMSGKBN9)
    public String getZtysyukyktkykhknkknmsgkbn9() {
        return ztysyukyktkykhknkknmsgkbn9;
    }

    public void setZtysyukyktkykhknkknmsgkbn9(String pZtysyukyktkykhknkknmsgkbn9) {
        ztysyukyktkykhknkknmsgkbn9 = pZtysyukyktkykhknkknmsgkbn9;
    }

    private String ztysyukyktkykstuukatype9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSTUUKATYPE9)
    public String getZtysyukyktkykstuukatype9() {
        return ztysyukyktkykstuukatype9;
    }

    public void setZtysyukyktkykstuukatype9(String pZtysyukyktkykstuukatype9) {
        ztysyukyktkykstuukatype9 = pZtysyukyktkykstuukatype9;
    }

    private String ztysyukyktkykhknkngk9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKNGK9)
    public String getZtysyukyktkykhknkngk9() {
        return ztysyukyktkykhknkngk9;
    }

    public void setZtysyukyktkykhknkngk9(String pZtysyukyktkykhknkngk9) {
        ztysyukyktkykhknkngk9 = pZtysyukyktkykhknkngk9;
    }

    private String ztysyutkdai1hknkknymdto9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI1HKNKKNYMDTO9)
    public String getZtysyutkdai1hknkknymdto9() {
        return ztysyutkdai1hknkknymdto9;
    }

    public void setZtysyutkdai1hknkknymdto9(String pZtysyutkdai1hknkknymdto9) {
        ztysyutkdai1hknkknymdto9 = pZtysyutkdai1hknkknymdto9;
    }

    private String ztysyutkdai2hknkknymdto9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI2HKNKKNYMDTO9)
    public String getZtysyutkdai2hknkknymdto9() {
        return ztysyutkdai2hknkknymdto9;
    }

    public void setZtysyutkdai2hknkknymdto9(String pZtysyutkdai2hknkknymdto9) {
        ztysyutkdai2hknkknymdto9 = pZtysyutkdai2hknkknymdto9;
    }

    private String ztyyobiv22x9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22X9)
    public String getZtyyobiv22x9() {
        return ztyyobiv22x9;
    }

    public void setZtyyobiv22x9(String pZtyyobiv22x9) {
        ztyyobiv22x9 = pZtyyobiv22x9;
    }

    private String ztysyukyktkykrenban10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKRENBAN10)
    public String getZtysyukyktkykrenban10() {
        return ztysyukyktkykrenban10;
    }

    public void setZtysyukyktkykrenban10(String pZtysyukyktkykrenban10) {
        ztysyukyktkykrenban10 = pZtysyukyktkykrenban10;
    }

    private String ztysyukyktkykmsgkbn10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKMSGKBN10)
    public String getZtysyukyktkykmsgkbn10() {
        return ztysyukyktkykmsgkbn10;
    }

    public void setZtysyukyktkykmsgkbn10(String pZtysyukyktkykmsgkbn10) {
        ztysyukyktkykmsgkbn10 = pZtysyukyktkykmsgkbn10;
    }

    private String ztysyukyktkyksmsgkbn10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSMSGKBN10)
    public String getZtysyukyktkyksmsgkbn10() {
        return ztysyukyktkyksmsgkbn10;
    }

    public void setZtysyukyktkyksmsgkbn10(String pZtysyukyktkyksmsgkbn10) {
        ztysyukyktkyksmsgkbn10 = pZtysyukyktkyksmsgkbn10;
    }

    private String ztysyukyktkykhknkknmsgkbn10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKKNMSGKBN10)
    public String getZtysyukyktkykhknkknmsgkbn10() {
        return ztysyukyktkykhknkknmsgkbn10;
    }

    public void setZtysyukyktkykhknkknmsgkbn10(String pZtysyukyktkykhknkknmsgkbn10) {
        ztysyukyktkykhknkknmsgkbn10 = pZtysyukyktkykhknkknmsgkbn10;
    }

    private String ztysyukyktkykstuukatype10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKSTUUKATYPE10)
    public String getZtysyukyktkykstuukatype10() {
        return ztysyukyktkykstuukatype10;
    }

    public void setZtysyukyktkykstuukatype10(String pZtysyukyktkykstuukatype10) {
        ztysyukyktkykstuukatype10 = pZtysyukyktkykstuukatype10;
    }

    private String ztysyukyktkykhknkngk10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUKYKTKYKHKNKNGK10)
    public String getZtysyukyktkykhknkngk10() {
        return ztysyukyktkykhknkngk10;
    }

    public void setZtysyukyktkykhknkngk10(String pZtysyukyktkykhknkngk10) {
        ztysyukyktkykhknkngk10 = pZtysyukyktkykhknkngk10;
    }

    private String ztysyutkdai1hknkknymdto10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI1HKNKKNYMDTO10)
    public String getZtysyutkdai1hknkknymdto10() {
        return ztysyutkdai1hknkknymdto10;
    }

    public void setZtysyutkdai1hknkknymdto10(String pZtysyutkdai1hknkknymdto10) {
        ztysyutkdai1hknkknymdto10 = pZtysyutkdai1hknkknymdto10;
    }

    private String ztysyutkdai2hknkknymdto10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSYUTKDAI2HKNKKNYMDTO10)
    public String getZtysyutkdai2hknkknymdto10() {
        return ztysyutkdai2hknkknymdto10;
    }

    public void setZtysyutkdai2hknkknymdto10(String pZtysyutkdai2hknkknymdto10) {
        ztysyutkdai2hknkknymdto10 = pZtysyutkdai2hknkknymdto10;
    }

    private String ztyyobiv22x10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV22X10)
    public String getZtyyobiv22x10() {
        return ztyyobiv22x10;
    }

    public void setZtyyobiv22x10(String pZtyyobiv22x10) {
        ztyyobiv22x10 = pZtyyobiv22x10;
    }

    private String ztyyobiv50;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV50)
    public String getZtyyobiv50() {
        return ztyyobiv50;
    }

    public void setZtyyobiv50(String pZtyyobiv50) {
        ztyyobiv50 = pZtyyobiv50;
    }

    private String ztykykniyustmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD1)
    public String getZtykykniyustmsgcd1() {
        return ztykykniyustmsgcd1;
    }

    public void setZtykykniyustmsgcd1(String pZtykykniyustmsgcd1) {
        ztykykniyustmsgcd1 = pZtykykniyustmsgcd1;
    }

    private String ztykykniyustmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD2)
    public String getZtykykniyustmsgcd2() {
        return ztykykniyustmsgcd2;
    }

    public void setZtykykniyustmsgcd2(String pZtykykniyustmsgcd2) {
        ztykykniyustmsgcd2 = pZtykykniyustmsgcd2;
    }

    private String ztykykniyustmsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD3)
    public String getZtykykniyustmsgcd3() {
        return ztykykniyustmsgcd3;
    }

    public void setZtykykniyustmsgcd3(String pZtykykniyustmsgcd3) {
        ztykykniyustmsgcd3 = pZtykykniyustmsgcd3;
    }

    private String ztykykniyustmsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD4)
    public String getZtykykniyustmsgcd4() {
        return ztykykniyustmsgcd4;
    }

    public void setZtykykniyustmsgcd4(String pZtykykniyustmsgcd4) {
        ztykykniyustmsgcd4 = pZtykykniyustmsgcd4;
    }

    private String ztykykniyustmsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD5)
    public String getZtykykniyustmsgcd5() {
        return ztykykniyustmsgcd5;
    }

    public void setZtykykniyustmsgcd5(String pZtykykniyustmsgcd5) {
        ztykykniyustmsgcd5 = pZtykykniyustmsgcd5;
    }

    private String ztykykniyustmsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD6)
    public String getZtykykniyustmsgcd6() {
        return ztykykniyustmsgcd6;
    }

    public void setZtykykniyustmsgcd6(String pZtykykniyustmsgcd6) {
        ztykykniyustmsgcd6 = pZtykykniyustmsgcd6;
    }

    private String ztykykniyustmsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD7)
    public String getZtykykniyustmsgcd7() {
        return ztykykniyustmsgcd7;
    }

    public void setZtykykniyustmsgcd7(String pZtykykniyustmsgcd7) {
        ztykykniyustmsgcd7 = pZtykykniyustmsgcd7;
    }

    private String ztykykniyustmsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD8)
    public String getZtykykniyustmsgcd8() {
        return ztykykniyustmsgcd8;
    }

    public void setZtykykniyustmsgcd8(String pZtykykniyustmsgcd8) {
        ztykykniyustmsgcd8 = pZtykykniyustmsgcd8;
    }

    private String ztykykniyustmsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD9)
    public String getZtykykniyustmsgcd9() {
        return ztykykniyustmsgcd9;
    }

    public void setZtykykniyustmsgcd9(String pZtykykniyustmsgcd9) {
        ztykykniyustmsgcd9 = pZtykykniyustmsgcd9;
    }

    private String ztykykniyustmsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD10)
    public String getZtykykniyustmsgcd10() {
        return ztykykniyustmsgcd10;
    }

    public void setZtykykniyustmsgcd10(String pZtykykniyustmsgcd10) {
        ztykykniyustmsgcd10 = pZtykykniyustmsgcd10;
    }

    private String ztykykniyustmsgcd11;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD11)
    public String getZtykykniyustmsgcd11() {
        return ztykykniyustmsgcd11;
    }

    public void setZtykykniyustmsgcd11(String pZtykykniyustmsgcd11) {
        ztykykniyustmsgcd11 = pZtykykniyustmsgcd11;
    }

    private String ztykykniyustmsgcd12;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD12)
    public String getZtykykniyustmsgcd12() {
        return ztykykniyustmsgcd12;
    }

    public void setZtykykniyustmsgcd12(String pZtykykniyustmsgcd12) {
        ztykykniyustmsgcd12 = pZtykykniyustmsgcd12;
    }

    private String ztykykniyustmsgcd13;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD13)
    public String getZtykykniyustmsgcd13() {
        return ztykykniyustmsgcd13;
    }

    public void setZtykykniyustmsgcd13(String pZtykykniyustmsgcd13) {
        ztykykniyustmsgcd13 = pZtykykniyustmsgcd13;
    }

    private String ztykykniyustmsgcd14;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD14)
    public String getZtykykniyustmsgcd14() {
        return ztykykniyustmsgcd14;
    }

    public void setZtykykniyustmsgcd14(String pZtykykniyustmsgcd14) {
        ztykykniyustmsgcd14 = pZtykykniyustmsgcd14;
    }

    private String ztykykniyustmsgcd15;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTMSGCD15)
    public String getZtykykniyustmsgcd15() {
        return ztykykniyustmsgcd15;
    }

    public void setZtykykniyustmsgcd15(String pZtykykniyustmsgcd15) {
        ztykykniyustmsgcd15 = pZtykykniyustmsgcd15;
    }

    private String ztykykniyustitjbrptuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTITJBRPTUUKTYPE)
    public String getZtykykniyustitjbrptuuktype() {
        return ztykykniyustitjbrptuuktype;
    }

    public void setZtykykniyustitjbrptuuktype(String pZtykykniyustitjbrptuuktype) {
        ztykykniyustitjbrptuuktype = pZtykykniyustitjbrptuuktype;
    }

    private String ztykykniyustitjbrp;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTITJBRP)
    public String getZtykykniyustitjbrp() {
        return ztykykniyustitjbrp;
    }

    public void setZtykykniyustitjbrp(String pZtykykniyustitjbrp) {
        ztykykniyustitjbrp = pZtykykniyustitjbrp;
    }

    private String ztykykniyustkihonstype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTKIHONSTYPE)
    public String getZtykykniyustkihonstype() {
        return ztykykniyustkihonstype;
    }

    public void setZtykykniyustkihonstype(String pZtykykniyustkihonstype) {
        ztykykniyustkihonstype = pZtykykniyustkihonstype;
    }

    private String ztykykniyustkihons;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKNIYUSTKIHONS)
    public String getZtykykniyustkihons() {
        return ztykykniyustkihons;
    }

    public void setZtykykniyustkihons(String pZtykykniyustkihons) {
        ztykykniyustkihons = pZtykykniyustkihons;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    private String ztysonotanyranmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD1)
    public String getZtysonotanyranmsgcd1() {
        return ztysonotanyranmsgcd1;
    }

    public void setZtysonotanyranmsgcd1(String pZtysonotanyranmsgcd1) {
        ztysonotanyranmsgcd1 = pZtysonotanyranmsgcd1;
    }

    private String ztysonotanyranmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD2)
    public String getZtysonotanyranmsgcd2() {
        return ztysonotanyranmsgcd2;
    }

    public void setZtysonotanyranmsgcd2(String pZtysonotanyranmsgcd2) {
        ztysonotanyranmsgcd2 = pZtysonotanyranmsgcd2;
    }

    private String ztysonotanyranmsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD3)
    public String getZtysonotanyranmsgcd3() {
        return ztysonotanyranmsgcd3;
    }

    public void setZtysonotanyranmsgcd3(String pZtysonotanyranmsgcd3) {
        ztysonotanyranmsgcd3 = pZtysonotanyranmsgcd3;
    }

    private String ztysonotanyranmsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD4)
    public String getZtysonotanyranmsgcd4() {
        return ztysonotanyranmsgcd4;
    }

    public void setZtysonotanyranmsgcd4(String pZtysonotanyranmsgcd4) {
        ztysonotanyranmsgcd4 = pZtysonotanyranmsgcd4;
    }

    private String ztysonotanyranmsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD5)
    public String getZtysonotanyranmsgcd5() {
        return ztysonotanyranmsgcd5;
    }

    public void setZtysonotanyranmsgcd5(String pZtysonotanyranmsgcd5) {
        ztysonotanyranmsgcd5 = pZtysonotanyranmsgcd5;
    }

    private String ztysonotanyranmsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD6)
    public String getZtysonotanyranmsgcd6() {
        return ztysonotanyranmsgcd6;
    }

    public void setZtysonotanyranmsgcd6(String pZtysonotanyranmsgcd6) {
        ztysonotanyranmsgcd6 = pZtysonotanyranmsgcd6;
    }

    private String ztysonotanyranmsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD7)
    public String getZtysonotanyranmsgcd7() {
        return ztysonotanyranmsgcd7;
    }

    public void setZtysonotanyranmsgcd7(String pZtysonotanyranmsgcd7) {
        ztysonotanyranmsgcd7 = pZtysonotanyranmsgcd7;
    }

    private String ztysonotanyranmsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD8)
    public String getZtysonotanyranmsgcd8() {
        return ztysonotanyranmsgcd8;
    }

    public void setZtysonotanyranmsgcd8(String pZtysonotanyranmsgcd8) {
        ztysonotanyranmsgcd8 = pZtysonotanyranmsgcd8;
    }

    private String ztysonotanyranmsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD9)
    public String getZtysonotanyranmsgcd9() {
        return ztysonotanyranmsgcd9;
    }

    public void setZtysonotanyranmsgcd9(String pZtysonotanyranmsgcd9) {
        ztysonotanyranmsgcd9 = pZtysonotanyranmsgcd9;
    }

    private String ztysonotanyranmsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD10)
    public String getZtysonotanyranmsgcd10() {
        return ztysonotanyranmsgcd10;
    }

    public void setZtysonotanyranmsgcd10(String pZtysonotanyranmsgcd10) {
        ztysonotanyranmsgcd10 = pZtysonotanyranmsgcd10;
    }

    private String ztysonotanyranmsgcd11;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD11)
    public String getZtysonotanyranmsgcd11() {
        return ztysonotanyranmsgcd11;
    }

    public void setZtysonotanyranmsgcd11(String pZtysonotanyranmsgcd11) {
        ztysonotanyranmsgcd11 = pZtysonotanyranmsgcd11;
    }

    private String ztysonotanyranmsgcd12;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD12)
    public String getZtysonotanyranmsgcd12() {
        return ztysonotanyranmsgcd12;
    }

    public void setZtysonotanyranmsgcd12(String pZtysonotanyranmsgcd12) {
        ztysonotanyranmsgcd12 = pZtysonotanyranmsgcd12;
    }

    private String ztysonotanyranmsgcd13;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD13)
    public String getZtysonotanyranmsgcd13() {
        return ztysonotanyranmsgcd13;
    }

    public void setZtysonotanyranmsgcd13(String pZtysonotanyranmsgcd13) {
        ztysonotanyranmsgcd13 = pZtysonotanyranmsgcd13;
    }

    private String ztysonotanyranmsgcd14;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD14)
    public String getZtysonotanyranmsgcd14() {
        return ztysonotanyranmsgcd14;
    }

    public void setZtysonotanyranmsgcd14(String pZtysonotanyranmsgcd14) {
        ztysonotanyranmsgcd14 = pZtysonotanyranmsgcd14;
    }

    private String ztysonotanyranmsgcd15;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD15)
    public String getZtysonotanyranmsgcd15() {
        return ztysonotanyranmsgcd15;
    }

    public void setZtysonotanyranmsgcd15(String pZtysonotanyranmsgcd15) {
        ztysonotanyranmsgcd15 = pZtysonotanyranmsgcd15;
    }

    private String ztysonotanyranmsgcd16;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD16)
    public String getZtysonotanyranmsgcd16() {
        return ztysonotanyranmsgcd16;
    }

    public void setZtysonotanyranmsgcd16(String pZtysonotanyranmsgcd16) {
        ztysonotanyranmsgcd16 = pZtysonotanyranmsgcd16;
    }

    private String ztysonotanyranmsgcd17;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD17)
    public String getZtysonotanyranmsgcd17() {
        return ztysonotanyranmsgcd17;
    }

    public void setZtysonotanyranmsgcd17(String pZtysonotanyranmsgcd17) {
        ztysonotanyranmsgcd17 = pZtysonotanyranmsgcd17;
    }

    private String ztysonotanyranmsgcd18;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD18)
    public String getZtysonotanyranmsgcd18() {
        return ztysonotanyranmsgcd18;
    }

    public void setZtysonotanyranmsgcd18(String pZtysonotanyranmsgcd18) {
        ztysonotanyranmsgcd18 = pZtysonotanyranmsgcd18;
    }

    private String ztysonotanyranmsgcd19;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD19)
    public String getZtysonotanyranmsgcd19() {
        return ztysonotanyranmsgcd19;
    }

    public void setZtysonotanyranmsgcd19(String pZtysonotanyranmsgcd19) {
        ztysonotanyranmsgcd19 = pZtysonotanyranmsgcd19;
    }

    private String ztysonotanyranmsgcd20;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMSGCD20)
    public String getZtysonotanyranmsgcd20() {
        return ztysonotanyranmsgcd20;
    }

    public void setZtysonotanyranmsgcd20(String pZtysonotanyranmsgcd20) {
        ztysonotanyranmsgcd20 = pZtysonotanyranmsgcd20;
    }

    private String ztysonotanyransiteituuka;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANSITEITUUKA)
    public String getZtysonotanyransiteituuka() {
        return ztysonotanyransiteituuka;
    }

    public void setZtysonotanyransiteituuka(String pZtysonotanyransiteituuka) {
        ztysonotanyransiteituuka = pZtysonotanyransiteituuka;
    }

    private String ztysonotanyrannykntuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANNYKNTUKTYPE)
    public String getZtysonotanyrannykntuktype() {
        return ztysonotanyrannykntuktype;
    }

    public void setZtysonotanyrannykntuktype(String pZtysonotanyrannykntuktype) {
        ztysonotanyrannykntuktype = pZtysonotanyrannykntuktype;
    }

    private String ztysonotanyrannykntuukap;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANNYKNTUUKAP)
    public String getZtysonotanyrannykntuukap() {
        return ztysonotanyrannykntuukap;
    }

    public void setZtysonotanyrannykntuukap(String pZtysonotanyrannykntuukap) {
        ztysonotanyrannykntuukap = pZtysonotanyrannykntuukap;
    }

    private String ztysonotanyrannykntuukasyu;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANNYKNTUUKASYU)
    public String getZtysonotanyrannykntuukasyu() {
        return ztysonotanyrannykntuukasyu;
    }

    public void setZtysonotanyrannykntuukasyu(String pZtysonotanyrannykntuukasyu) {
        ztysonotanyrannykntuukasyu = pZtysonotanyrannykntuukasyu;
    }

    private String ztysonotanyranenkhrikmrate;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANENKHRIKMRATE)
    public String getZtysonotanyranenkhrikmrate() {
        return ztysonotanyranenkhrikmrate;
    }

    public void setZtysonotanyranenkhrikmrate(String pZtysonotanyranenkhrikmrate) {
        ztysonotanyranenkhrikmrate = pZtysonotanyranenkhrikmrate;
    }

    private String ztysonotanyranstigikwsrate;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANSTIGIKWSRATE)
    public String getZtysonotanyranstigikwsrate() {
        return ztysonotanyranstigikwsrate;
    }

    public void setZtysonotanyranstigikwsrate(String pZtysonotanyranstigikwsrate) {
        ztysonotanyranstigikwsrate = pZtysonotanyranstigikwsrate;
    }

    private String ztysonotanykjnkngktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYKJNKNGKTUKTYPE)
    public String getZtysonotanykjnkngktuktype() {
        return ztysonotanykjnkngktuktype;
    }

    public void setZtysonotanykjnkngktuktype(String pZtysonotanykjnkngktuktype) {
        ztysonotanykjnkngktuktype = pZtysonotanykjnkngktuktype;
    }

    private String ztysonotanykjnkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYKJNKNGK)
    public String getZtysonotanykjnkngk() {
        return ztysonotanykjnkngk;
    }

    public void setZtysonotanykjnkngk(String pZtysonotanykjnkngk) {
        ztysonotanykjnkngk = pZtysonotanykjnkngk;
    }

    private String ztysonotanykjnkngkrate;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYKJNKNGKRATE)
    public String getZtysonotanykjnkngkrate() {
        return ztysonotanykjnkngkrate;
    }

    public void setZtysonotanykjnkngkrate(String pZtysonotanykjnkngkrate) {
        ztysonotanykjnkngkrate = pZtysonotanykjnkngkrate;
    }

    private String ztysonotanykjnkngktuuka;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYKJNKNGKTUUKA)
    public String getZtysonotanykjnkngktuuka() {
        return ztysonotanykjnkngktuuka;
    }

    public void setZtysonotanykjnkngktuuka(String pZtysonotanykjnkngktuuka) {
        ztysonotanykjnkngktuuka = pZtysonotanykjnkngktuuka;
    }

    private String ztysonotanyranpentuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANPENTUKTYPE)
    public String getZtysonotanyranpentuktype() {
        return ztysonotanyranpentuktype;
    }

    public void setZtysonotanyranpentuktype(String pZtysonotanyranpentuktype) {
        ztysonotanyranpentuktype = pZtysonotanyranpentuktype;
    }

    private String ztysonotanyranpenknsngk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANPENKNSNGK)
    public String getZtysonotanyranpenknsngk() {
        return ztysonotanyranpenknsngk;
    }

    public void setZtysonotanyranpenknsngk(String pZtysonotanyranpenknsngk) {
        ztysonotanyranpenknsngk = pZtysonotanyranpenknsngk;
    }

    private String ztypmkhtoutatuwariai;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYPMKHTOUTATUWARIAI)
    public String getZtypmkhtoutatuwariai() {
        return ztypmkhtoutatuwariai;
    }

    public void setZtypmkhtoutatuwariai(String pZtypmkhtoutatuwariai) {
        ztypmkhtoutatuwariai = pZtypmkhtoutatuwariai;
    }

    private String ztysonotanyranmkhgk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANMKHGK)
    public String getZtysonotanyranmkhgk() {
        return ztysonotanyranmkhgk;
    }

    public void setZtysonotanyranmkhgk(String pZtysonotanyranmkhgk) {
        ztysonotanyranmkhgk = pZtysonotanyranmkhgk;
    }

    private String ztysonotanyrannkshrstartymd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANNKSHRSTARTYMD)
    public String getZtysonotanyrannkshrstartymd() {
        return ztysonotanyrannkshrstartymd;
    }

    public void setZtysonotanyrannkshrstartymd(String pZtysonotanyrannkshrstartymd) {
        ztysonotanyrannkshrstartymd = pZtysonotanyrannkshrstartymd;
    }

    private String ztysonotanyrannkkkn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANNKKKN)
    public String getZtysonotanyrannkkkn() {
        return ztysonotanyrannkkkn;
    }

    public void setZtysonotanyrannkkkn(String pZtysonotanyrannkkkn) {
        ztysonotanyrannkkkn = pZtysonotanyrannkkkn;
    }

    private String ztysonotanyyensysnhkhnkymd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYYENSYSNHKHNKYMD)
    public String getZtysonotanyyensysnhkhnkymd() {
        return ztysonotanyyensysnhkhnkymd;
    }

    public void setZtysonotanyyensysnhkhnkymd(String pZtysonotanyyensysnhkhnkymd) {
        ztysonotanyyensysnhkhnkymd = pZtysonotanyyensysnhkhnkymd;
    }

    private String ztysonotanytmttkngktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYTMTTKNGKTUKTYPE)
    public String getZtysonotanytmttkngktuktype() {
        return ztysonotanytmttkngktuktype;
    }

    public void setZtysonotanytmttkngktuktype(String pZtysonotanytmttkngktuktype) {
        ztysonotanytmttkngktuktype = pZtysonotanytmttkngktuktype;
    }

    private String ztysonotanyteiritutmttkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYTEIRITUTMTTKNGK)
    public String getZtysonotanyteiritutmttkngk() {
        return ztysonotanyteiritutmttkngk;
    }

    public void setZtysonotanyteiritutmttkngk(String pZtysonotanyteiritutmttkngk) {
        ztysonotanyteiritutmttkngk = pZtysonotanyteiritutmttkngk;
    }

    private String ztysonotanyransisuutmttkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANSISUUTMTTKNGK)
    public String getZtysonotanyransisuutmttkngk() {
        return ztysonotanyransisuutmttkngk;
    }

    public void setZtysonotanyransisuutmttkngk(String pZtysonotanyransisuutmttkngk) {
        ztysonotanyransisuutmttkngk = pZtysonotanyransisuutmttkngk;
    }

    private String ztysonotanyransisuunm;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANSISUUNM)
    public String getZtysonotanyransisuunm() {
        return ztysonotanyransisuunm;
    }

    public void setZtysonotanyransisuunm(String pZtysonotanyransisuunm) {
        ztysonotanyransisuunm = pZtysonotanyransisuunm;
    }

    private String ztysonotanyrendouritu;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRENDOURITU)
    public String getZtysonotanyrendouritu() {
        return ztysonotanyrendouritu;
    }

    public void setZtysonotanyrendouritu(String pZtysonotanyrendouritu) {
        ztysonotanyrendouritu = pZtysonotanyrendouritu;
    }

    private String ztysonotanyteikisiharaikin;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYTEIKISIHARAIKIN)
    public String getZtysonotanyteikisiharaikin() {
        return ztysonotanyteikisiharaikin;
    }

    public void setZtysonotanyteikisiharaikin(String pZtysonotanyteikisiharaikin) {
        ztysonotanyteikisiharaikin = pZtysonotanyteikisiharaikin;
    }

    private String ztysonotanyrangaimsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSONOTANYRANGAIMSGCD)
    public String getZtysonotanyrangaimsgcd() {
        return ztysonotanyrangaimsgcd;
    }

    public void setZtysonotanyrangaimsgcd(String pZtysonotanyrangaimsgcd) {
        ztysonotanyrangaimsgcd = pZtysonotanyrangaimsgcd;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztyhosyounymsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHOSYOUNYMSGCD)
    public String getZtyhosyounymsgcd() {
        return ztyhosyounymsgcd;
    }

    public void setZtyhosyounymsgcd(String pZtyhosyounymsgcd) {
        ztyhosyounymsgcd = pZtyhosyounymsgcd;
    }

    private String ztyyobiv15;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV15)
    public String getZtyyobiv15() {
        return ztyyobiv15;
    }

    public void setZtyyobiv15(String pZtyyobiv15) {
        ztyyobiv15 = pZtyyobiv15;
    }

    private String ztyhosyounyhihknsyanmkanji;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHOSYOUNYHIHKNSYANMKANJI)
    public String getZtyhosyounyhihknsyanmkanji() {
        return ztyhosyounyhihknsyanmkanji;
    }

    public void setZtyhosyounyhihknsyanmkanji(String pZtyhosyounyhihknsyanmkanji) {
        ztyhosyounyhihknsyanmkanji = pZtyhosyounyhihknsyanmkanji;
    }

    private String ztyyobiv24;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV24)
    public String getZtyyobiv24() {
        return ztyyobiv24;
    }

    public void setZtyyobiv24(String pZtyyobiv24) {
        ztyyobiv24 = pZtyyobiv24;
    }

    private String ztysiboumidasimsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUMIDASIMSGCD)
    public String getZtysiboumidasimsgcd() {
        return ztysiboumidasimsgcd;
    }

    public void setZtysiboumidasimsgcd(String pZtysiboumidasimsgcd) {
        ztysiboumidasimsgcd = pZtysiboumidasimsgcd;
    }

    private String ztysiboumidasimsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUMIDASIMSGCD2)
    public String getZtysiboumidasimsgcd2() {
        return ztysiboumidasimsgcd2;
    }

    public void setZtysiboumidasimsgcd2(String pZtysiboumidasimsgcd2) {
        ztysiboumidasimsgcd2 = pZtysiboumidasimsgcd2;
    }

    private String ztysiboudai1hknkknmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI1HKNKKNMSGCD1)
    public String getZtysiboudai1hknkknmsgcd1() {
        return ztysiboudai1hknkknmsgcd1;
    }

    public void setZtysiboudai1hknkknmsgcd1(String pZtysiboudai1hknkknmsgcd1) {
        ztysiboudai1hknkknmsgcd1 = pZtysiboudai1hknkknmsgcd1;
    }

    private String ztysiboudai1hknkknmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI1HKNKKNMSGCD2)
    public String getZtysiboudai1hknkknmsgcd2() {
        return ztysiboudai1hknkknmsgcd2;
    }

    public void setZtysiboudai1hknkknmsgcd2(String pZtysiboudai1hknkknmsgcd2) {
        ztysiboudai1hknkknmsgcd2 = pZtysiboudai1hknkknmsgcd2;
    }

    private String ztysiboudai1hknkknigimsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI1HKNKKNIGIMSGCD)
    public String getZtysiboudai1hknkknigimsgcd() {
        return ztysiboudai1hknkknigimsgcd;
    }

    public void setZtysiboudai1hknkknigimsgcd(String pZtysiboudai1hknkknigimsgcd) {
        ztysiboudai1hknkknigimsgcd = pZtysiboudai1hknkknigimsgcd;
    }

    private String ztysiboudai1hknkknigimsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI1HKNKKNIGIMSGCD2)
    public String getZtysiboudai1hknkknigimsgcd2() {
        return ztysiboudai1hknkknigimsgcd2;
    }

    public void setZtysiboudai1hknkknigimsgcd2(String pZtysiboudai1hknkknigimsgcd2) {
        ztysiboudai1hknkknigimsgcd2 = pZtysiboudai1hknkknigimsgcd2;
    }

    private String ztysiboudai1hknkknhrsmsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI1HKNKKNHRSMSGCD)
    public String getZtysiboudai1hknkknhrsmsgcd() {
        return ztysiboudai1hknkknhrsmsgcd;
    }

    public void setZtysiboudai1hknkknhrsmsgcd(String pZtysiboudai1hknkknhrsmsgcd) {
        ztysiboudai1hknkknhrsmsgcd = pZtysiboudai1hknkknhrsmsgcd;
    }

    private String ztysiboudai1hknkknhrsmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI1HKNKKNHRSMSGCD2)
    public String getZtysiboudai1hknkknhrsmsgcd2() {
        return ztysiboudai1hknkknhrsmsgcd2;
    }

    public void setZtysiboudai1hknkknhrsmsgcd2(String pZtysiboudai1hknkknhrsmsgcd2) {
        ztysiboudai1hknkknhrsmsgcd2 = pZtysiboudai1hknkknhrsmsgcd2;
    }

    private String ztysiboudai1hknkknsmrmsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI1HKNKKNSMRMSGCD)
    public String getZtysiboudai1hknkknsmrmsgcd() {
        return ztysiboudai1hknkknsmrmsgcd;
    }

    public void setZtysiboudai1hknkknsmrmsgcd(String pZtysiboudai1hknkknsmrmsgcd) {
        ztysiboudai1hknkknsmrmsgcd = pZtysiboudai1hknkknsmrmsgcd;
    }

    private String ztysiboudai2hknkknmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI2HKNKKNMSGCD1)
    public String getZtysiboudai2hknkknmsgcd1() {
        return ztysiboudai2hknkknmsgcd1;
    }

    public void setZtysiboudai2hknkknmsgcd1(String pZtysiboudai2hknkknmsgcd1) {
        ztysiboudai2hknkknmsgcd1 = pZtysiboudai2hknkknmsgcd1;
    }

    private String ztysiboudai2hknkknmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI2HKNKKNMSGCD2)
    public String getZtysiboudai2hknkknmsgcd2() {
        return ztysiboudai2hknkknmsgcd2;
    }

    public void setZtysiboudai2hknkknmsgcd2(String pZtysiboudai2hknkknmsgcd2) {
        ztysiboudai2hknkknmsgcd2 = pZtysiboudai2hknkknmsgcd2;
    }

    private String ztysiboudai2hknkknsmsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI2HKNKKNSMSGCD)
    public String getZtysiboudai2hknkknsmsgcd() {
        return ztysiboudai2hknkknsmsgcd;
    }

    public void setZtysiboudai2hknkknsmsgcd(String pZtysiboudai2hknkknsmsgcd) {
        ztysiboudai2hknkknsmsgcd = pZtysiboudai2hknkknsmsgcd;
    }

    private String ztysiboudai2hknkknsmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI2HKNKKNSMSGCD2)
    public String getZtysiboudai2hknkknsmsgcd2() {
        return ztysiboudai2hknkknsmsgcd2;
    }

    public void setZtysiboudai2hknkknsmsgcd2(String pZtysiboudai2hknkknsmsgcd2) {
        ztysiboudai2hknkknsmsgcd2 = pZtysiboudai2hknkknsmsgcd2;
    }

    private String ztysiboudai3hknkknmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI3HKNKKNMSGCD1)
    public String getZtysiboudai3hknkknmsgcd1() {
        return ztysiboudai3hknkknmsgcd1;
    }

    public void setZtysiboudai3hknkknmsgcd1(String pZtysiboudai3hknkknmsgcd1) {
        ztysiboudai3hknkknmsgcd1 = pZtysiboudai3hknkknmsgcd1;
    }

    private String ztysiboudai3hknkknmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI3HKNKKNMSGCD2)
    public String getZtysiboudai3hknkknmsgcd2() {
        return ztysiboudai3hknkknmsgcd2;
    }

    public void setZtysiboudai3hknkknmsgcd2(String pZtysiboudai3hknkknmsgcd2) {
        ztysiboudai3hknkknmsgcd2 = pZtysiboudai3hknkknmsgcd2;
    }

    private String ztyyobiv15x2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV15X2)
    public String getZtyyobiv15x2() {
        return ztyyobiv15x2;
    }

    public void setZtyyobiv15x2(String pZtyyobiv15x2) {
        ztyyobiv15x2 = pZtyyobiv15x2;
    }

    private String ztysiboudai1hknkknymdto;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI1HKNKKNYMDTO)
    public String getZtysiboudai1hknkknymdto() {
        return ztysiboudai1hknkknymdto;
    }

    public void setZtysiboudai1hknkknymdto(String pZtysiboudai1hknkknymdto) {
        ztysiboudai1hknkknymdto = pZtysiboudai1hknkknymdto;
    }

    private String ztysibouitjbrpyentuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUITJBRPYENTUUKTYPE)
    public String getZtysibouitjbrpyentuuktype() {
        return ztysibouitjbrpyentuuktype;
    }

    public void setZtysibouitjbrpyentuuktype(String pZtysibouitjbrpyentuuktype) {
        ztysibouitjbrpyentuuktype = pZtysibouitjbrpyentuuktype;
    }

    private String ztysibouitjbrpyentuukgk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUITJBRPYENTUUKGK)
    public String getZtysibouitjbrpyentuukgk() {
        return ztysibouitjbrpyentuukgk;
    }

    public void setZtysibouitjbrpyentuukgk(String pZtysibouitjbrpyentuukgk) {
        ztysibouitjbrpyentuukgk = pZtysibouitjbrpyentuukgk;
    }

    private String ztysiboudai1kjnkngktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI1KJNKNGKTUKTYPE)
    public String getZtysiboudai1kjnkngktuktype() {
        return ztysiboudai1kjnkngktuktype;
    }

    public void setZtysiboudai1kjnkngktuktype(String pZtysiboudai1kjnkngktuktype) {
        ztysiboudai1kjnkngktuktype = pZtysiboudai1kjnkngktuktype;
    }

    private String ztysiboudai1kjnkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI1KJNKNGK)
    public String getZtysiboudai1kjnkngk() {
        return ztysiboudai1kjnkngk;
    }

    public void setZtysiboudai1kjnkngk(String pZtysiboudai1kjnkngk) {
        ztysiboudai1kjnkngk = pZtysiboudai1kjnkngk;
    }

    private String ztysiboudai2hknkknymdto;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI2HKNKKNYMDTO)
    public String getZtysiboudai2hknkknymdto() {
        return ztysiboudai2hknkknymdto;
    }

    public void setZtysiboudai2hknkknymdto(String pZtysiboudai2hknkknymdto) {
        ztysiboudai2hknkknymdto = pZtysiboudai2hknkknymdto;
    }

    private String ztysiboudai2kjnkngktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI2KJNKNGKTUKTYPE)
    public String getZtysiboudai2kjnkngktuktype() {
        return ztysiboudai2kjnkngktuktype;
    }

    public void setZtysiboudai2kjnkngktuktype(String pZtysiboudai2kjnkngktuktype) {
        ztysiboudai2kjnkngktuktype = pZtysiboudai2kjnkngktuktype;
    }

    private String ztysiboudai2kjnkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI2KJNKNGK)
    public String getZtysiboudai2kjnkngk() {
        return ztysiboudai2kjnkngk;
    }

    public void setZtysiboudai2kjnkngk(String pZtysiboudai2kjnkngk) {
        ztysiboudai2kjnkngk = pZtysiboudai2kjnkngk;
    }

    private String ztysiboudai3kjnkngktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI3KJNKNGKTUKTYPE)
    public String getZtysiboudai3kjnkngktuktype() {
        return ztysiboudai3kjnkngktuktype;
    }

    public void setZtysiboudai3kjnkngktuktype(String pZtysiboudai3kjnkngktuktype) {
        ztysiboudai3kjnkngktuktype = pZtysiboudai3kjnkngktuktype;
    }

    private String ztysiboudai3kjnkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUDAI3KJNKNGK)
    public String getZtysiboudai3kjnkngk() {
        return ztysiboudai3kjnkngk;
    }

    public void setZtysiboudai3kjnkngk(String pZtysiboudai3kjnkngk) {
        ztysiboudai3kjnkngk = pZtysiboudai3kjnkngk;
    }

    private String ztyyobiv23;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV23)
    public String getZtyyobiv23() {
        return ztyyobiv23;
    }

    public void setZtyyobiv23(String pZtyyobiv23) {
        ztyyobiv23 = pZtyyobiv23;
    }

    private String ztydai1skwsrateyendaka;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SKWSRATEYENDAKA)
    public String getZtydai1skwsrateyendaka() {
        return ztydai1skwsrateyendaka;
    }

    public void setZtydai1skwsrateyendaka(String pZtydai1skwsrateyendaka) {
        ztydai1skwsrateyendaka = pZtydai1skwsrateyendaka;
    }

    private String ztydai1skwsrateyenkijyun;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SKWSRATEYENKIJYUN)
    public String getZtydai1skwsrateyenkijyun() {
        return ztydai1skwsrateyenkijyun;
    }

    public void setZtydai1skwsrateyenkijyun(String pZtydai1skwsrateyenkijyun) {
        ztydai1skwsrateyenkijyun = pZtydai1skwsrateyenkijyun;
    }

    private String ztydai1skwsrateyenyasu;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SKWSRATEYENYASU)
    public String getZtydai1skwsrateyenyasu() {
        return ztydai1skwsrateyenyasu;
    }

    public void setZtydai1skwsrateyenyasu(String pZtydai1skwsrateyenyasu) {
        ztydai1skwsrateyenyasu = pZtydai1skwsrateyenyasu;
    }

    private String ztydai1sibousnenoutouymd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SIBOUSNENOUTOUYMD1)
    public String getZtydai1sibousnenoutouymd1() {
        return ztydai1sibousnenoutouymd1;
    }

    public void setZtydai1sibousnenoutouymd1(String pZtydai1sibousnenoutouymd1) {
        ztydai1sibousnenoutouymd1 = pZtydai1sibousnenoutouymd1;
    }

    private String ztydai1stuuktype01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPE01)
    public String getZtydai1stuuktype01() {
        return ztydai1stuuktype01;
    }

    public void setZtydai1stuuktype01(String pZtydai1stuuktype01) {
        ztydai1stuuktype01 = pZtydai1stuuktype01;
    }

    private String ztydai1s01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1S01)
    public String getZtydai1s01() {
        return ztydai1s01;
    }

    public void setZtydai1s01(String pZtydai1s01) {
        ztydai1s01 = pZtydai1s01;
    }

    private String ztydai1syenyendakaumu01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMU01)
    public String getZtydai1syenyendakaumu01() {
        return ztydai1syenyendakaumu01;
    }

    public void setZtydai1syenyendakaumu01(String pZtydai1syenyendakaumu01) {
        ztydai1syenyendakaumu01 = pZtydai1syenyendakaumu01;
    }

    private String ztydai1syenyenkijyunumu01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNUMU01)
    public String getZtydai1syenyenkijyunumu01() {
        return ztydai1syenyenkijyunumu01;
    }

    public void setZtydai1syenyenkijyunumu01(String pZtydai1syenyenkijyunumu01) {
        ztydai1syenyenkijyunumu01 = pZtydai1syenyenkijyunumu01;
    }

    private String ztydai1syenyenyasuumu01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMU01)
    public String getZtydai1syenyenyasuumu01() {
        return ztydai1syenyenyasuumu01;
    }

    public void setZtydai1syenyenyasuumu01(String pZtydai1syenyenyasuumu01) {
        ztydai1syenyenyasuumu01 = pZtydai1syenyenyasuumu01;
    }

    private String ztydai1syentuuktype01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPE01)
    public String getZtydai1syentuuktype01() {
        return ztydai1syentuuktype01;
    }

    public void setZtydai1syentuuktype01(String pZtydai1syentuuktype01) {
        ztydai1syentuuktype01 = pZtydai1syentuuktype01;
    }

    private String ztydai1syenyendaka01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKA01)
    public String getZtydai1syenyendaka01() {
        return ztydai1syenyendaka01;
    }

    public void setZtydai1syenyendaka01(String pZtydai1syenyendaka01) {
        ztydai1syenyendaka01 = pZtydai1syenyendaka01;
    }

    private String ztydai1syenyenkijyun01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUN01)
    public String getZtydai1syenyenkijyun01() {
        return ztydai1syenyenkijyun01;
    }

    public void setZtydai1syenyenkijyun01(String pZtydai1syenyenkijyun01) {
        ztydai1syenyenkijyun01 = pZtydai1syenyenkijyun01;
    }

    private String ztydai1syenyenyasu01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASU01)
    public String getZtydai1syenyenyasu01() {
        return ztydai1syenyenyasu01;
    }

    public void setZtydai1syenyenyasu01(String pZtydai1syenyenyasu01) {
        ztydai1syenyenyasu01 = pZtydai1syenyenyasu01;
    }

    private String ztydai1zennouzndk01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDK01)
    public String getZtydai1zennouzndk01() {
        return ztydai1zennouzndk01;
    }

    public void setZtydai1zennouzndk01(String pZtydai1zennouzndk01) {
        ztydai1zennouzndk01 = pZtydai1zennouzndk01;
    }

    private String ztydai1zennouzndktype01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDKTYPE01)
    public String getZtydai1zennouzndktype01() {
        return ztydai1zennouzndktype01;
    }

    public void setZtydai1zennouzndktype01(String pZtydai1zennouzndktype01) {
        ztydai1zennouzndktype01 = pZtydai1zennouzndktype01;
    }

    private String ztydai1sbjiuktgk01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGK01)
    public String getZtydai1sbjiuktgk01() {
        return ztydai1sbjiuktgk01;
    }

    public void setZtydai1sbjiuktgk01(String pZtydai1sbjiuktgk01) {
        ztydai1sbjiuktgk01 = pZtydai1sbjiuktgk01;
    }

    private String ztydai1sbjiuktgktype01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKTYPE01)
    public String getZtydai1sbjiuktgktype01() {
        return ztydai1sbjiuktgktype01;
    }

    public void setZtydai1sbjiuktgktype01(String pZtydai1sbjiuktgktype01) {
        ztydai1sbjiuktgktype01 = pZtydai1sbjiuktgktype01;
    }

    private String ztydai1sbjiuktgkytype01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYTYPE01)
    public String getZtydai1sbjiuktgkytype01() {
        return ztydai1sbjiuktgkytype01;
    }

    public void setZtydai1sbjiuktgkytype01(String pZtydai1sbjiuktgkytype01) {
        ztydai1sbjiuktgkytype01 = pZtydai1sbjiuktgkytype01;
    }

    private String ztydai1sbjiuktgkydaka01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYDAKA01)
    public String getZtydai1sbjiuktgkydaka01() {
        return ztydai1sbjiuktgkydaka01;
    }

    public void setZtydai1sbjiuktgkydaka01(String pZtydai1sbjiuktgkydaka01) {
        ztydai1sbjiuktgkydaka01 = pZtydai1sbjiuktgkydaka01;
    }

    private String ztydai1sbjiuktgkykijyun01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYKIJYUN01)
    public String getZtydai1sbjiuktgkykijyun01() {
        return ztydai1sbjiuktgkykijyun01;
    }

    public void setZtydai1sbjiuktgkykijyun01(String pZtydai1sbjiuktgkykijyun01) {
        ztydai1sbjiuktgkykijyun01 = pZtydai1sbjiuktgkykijyun01;
    }

    private String ztydai1sbjiuktgkyyasu01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYYASU01)
    public String getZtydai1sbjiuktgkyyasu01() {
        return ztydai1sbjiuktgkyyasu01;
    }

    public void setZtydai1sbjiuktgkyyasu01(String pZtydai1sbjiuktgkyyasu01) {
        ztydai1sbjiuktgkyyasu01 = pZtydai1sbjiuktgkyyasu01;
    }

    private String ztydai1sibousnenoutouymd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SIBOUSNENOUTOUYMD2)
    public String getZtydai1sibousnenoutouymd2() {
        return ztydai1sibousnenoutouymd2;
    }

    public void setZtydai1sibousnenoutouymd2(String pZtydai1sibousnenoutouymd2) {
        ztydai1sibousnenoutouymd2 = pZtydai1sibousnenoutouymd2;
    }

    private String ztydai1stuuktype02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPE02)
    public String getZtydai1stuuktype02() {
        return ztydai1stuuktype02;
    }

    public void setZtydai1stuuktype02(String pZtydai1stuuktype02) {
        ztydai1stuuktype02 = pZtydai1stuuktype02;
    }

    private String ztydai1s02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1S02)
    public String getZtydai1s02() {
        return ztydai1s02;
    }

    public void setZtydai1s02(String pZtydai1s02) {
        ztydai1s02 = pZtydai1s02;
    }

    private String ztydai1syenyendakaumu02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMU02)
    public String getZtydai1syenyendakaumu02() {
        return ztydai1syenyendakaumu02;
    }

    public void setZtydai1syenyendakaumu02(String pZtydai1syenyendakaumu02) {
        ztydai1syenyendakaumu02 = pZtydai1syenyendakaumu02;
    }

    private String ztydai1syenyenkijyunumu02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNUMU02)
    public String getZtydai1syenyenkijyunumu02() {
        return ztydai1syenyenkijyunumu02;
    }

    public void setZtydai1syenyenkijyunumu02(String pZtydai1syenyenkijyunumu02) {
        ztydai1syenyenkijyunumu02 = pZtydai1syenyenkijyunumu02;
    }

    private String ztydai1syenyenyasuumu02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMU02)
    public String getZtydai1syenyenyasuumu02() {
        return ztydai1syenyenyasuumu02;
    }

    public void setZtydai1syenyenyasuumu02(String pZtydai1syenyenyasuumu02) {
        ztydai1syenyenyasuumu02 = pZtydai1syenyenyasuumu02;
    }

    private String ztydai1syentuuktype02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPE02)
    public String getZtydai1syentuuktype02() {
        return ztydai1syentuuktype02;
    }

    public void setZtydai1syentuuktype02(String pZtydai1syentuuktype02) {
        ztydai1syentuuktype02 = pZtydai1syentuuktype02;
    }

    private String ztydai1syenyendaka02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKA02)
    public String getZtydai1syenyendaka02() {
        return ztydai1syenyendaka02;
    }

    public void setZtydai1syenyendaka02(String pZtydai1syenyendaka02) {
        ztydai1syenyendaka02 = pZtydai1syenyendaka02;
    }

    private String ztydai1syenyenkijyun02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUN02)
    public String getZtydai1syenyenkijyun02() {
        return ztydai1syenyenkijyun02;
    }

    public void setZtydai1syenyenkijyun02(String pZtydai1syenyenkijyun02) {
        ztydai1syenyenkijyun02 = pZtydai1syenyenkijyun02;
    }

    private String ztydai1syenyenyasu02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASU02)
    public String getZtydai1syenyenyasu02() {
        return ztydai1syenyenyasu02;
    }

    public void setZtydai1syenyenyasu02(String pZtydai1syenyenyasu02) {
        ztydai1syenyenyasu02 = pZtydai1syenyenyasu02;
    }

    private String ztydai1zennouzndk02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDK02)
    public String getZtydai1zennouzndk02() {
        return ztydai1zennouzndk02;
    }

    public void setZtydai1zennouzndk02(String pZtydai1zennouzndk02) {
        ztydai1zennouzndk02 = pZtydai1zennouzndk02;
    }

    private String ztydai1zennouzndktype02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDKTYPE02)
    public String getZtydai1zennouzndktype02() {
        return ztydai1zennouzndktype02;
    }

    public void setZtydai1zennouzndktype02(String pZtydai1zennouzndktype02) {
        ztydai1zennouzndktype02 = pZtydai1zennouzndktype02;
    }

    private String ztydai1sbjiuktgk02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGK02)
    public String getZtydai1sbjiuktgk02() {
        return ztydai1sbjiuktgk02;
    }

    public void setZtydai1sbjiuktgk02(String pZtydai1sbjiuktgk02) {
        ztydai1sbjiuktgk02 = pZtydai1sbjiuktgk02;
    }

    private String ztydai1sbjiuktgktype02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKTYPE02)
    public String getZtydai1sbjiuktgktype02() {
        return ztydai1sbjiuktgktype02;
    }

    public void setZtydai1sbjiuktgktype02(String pZtydai1sbjiuktgktype02) {
        ztydai1sbjiuktgktype02 = pZtydai1sbjiuktgktype02;
    }

    private String ztydai1sbjiuktgkytype02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYTYPE02)
    public String getZtydai1sbjiuktgkytype02() {
        return ztydai1sbjiuktgkytype02;
    }

    public void setZtydai1sbjiuktgkytype02(String pZtydai1sbjiuktgkytype02) {
        ztydai1sbjiuktgkytype02 = pZtydai1sbjiuktgkytype02;
    }

    private String ztydai1sbjiuktgkydaka02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYDAKA02)
    public String getZtydai1sbjiuktgkydaka02() {
        return ztydai1sbjiuktgkydaka02;
    }

    public void setZtydai1sbjiuktgkydaka02(String pZtydai1sbjiuktgkydaka02) {
        ztydai1sbjiuktgkydaka02 = pZtydai1sbjiuktgkydaka02;
    }

    private String ztydai1sbjiuktgkykijyun02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYKIJYUN02)
    public String getZtydai1sbjiuktgkykijyun02() {
        return ztydai1sbjiuktgkykijyun02;
    }

    public void setZtydai1sbjiuktgkykijyun02(String pZtydai1sbjiuktgkykijyun02) {
        ztydai1sbjiuktgkykijyun02 = pZtydai1sbjiuktgkykijyun02;
    }

    private String ztydai1sbjiuktgkyyasu02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYYASU02)
    public String getZtydai1sbjiuktgkyyasu02() {
        return ztydai1sbjiuktgkyyasu02;
    }

    public void setZtydai1sbjiuktgkyyasu02(String pZtydai1sbjiuktgkyyasu02) {
        ztydai1sbjiuktgkyyasu02 = pZtydai1sbjiuktgkyyasu02;
    }

    private String ztydai1sibousnenoutouymd3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SIBOUSNENOUTOUYMD3)
    public String getZtydai1sibousnenoutouymd3() {
        return ztydai1sibousnenoutouymd3;
    }

    public void setZtydai1sibousnenoutouymd3(String pZtydai1sibousnenoutouymd3) {
        ztydai1sibousnenoutouymd3 = pZtydai1sibousnenoutouymd3;
    }

    private String ztydai1stuuktype03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPE03)
    public String getZtydai1stuuktype03() {
        return ztydai1stuuktype03;
    }

    public void setZtydai1stuuktype03(String pZtydai1stuuktype03) {
        ztydai1stuuktype03 = pZtydai1stuuktype03;
    }

    private String ztydai1s03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1S03)
    public String getZtydai1s03() {
        return ztydai1s03;
    }

    public void setZtydai1s03(String pZtydai1s03) {
        ztydai1s03 = pZtydai1s03;
    }

    private String ztydai1syenyendakaumu03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMU03)
    public String getZtydai1syenyendakaumu03() {
        return ztydai1syenyendakaumu03;
    }

    public void setZtydai1syenyendakaumu03(String pZtydai1syenyendakaumu03) {
        ztydai1syenyendakaumu03 = pZtydai1syenyendakaumu03;
    }

    private String ztydai1syenyenkijyunumu03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNUMU03)
    public String getZtydai1syenyenkijyunumu03() {
        return ztydai1syenyenkijyunumu03;
    }

    public void setZtydai1syenyenkijyunumu03(String pZtydai1syenyenkijyunumu03) {
        ztydai1syenyenkijyunumu03 = pZtydai1syenyenkijyunumu03;
    }

    private String ztydai1syenyenyasuumu03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMU03)
    public String getZtydai1syenyenyasuumu03() {
        return ztydai1syenyenyasuumu03;
    }

    public void setZtydai1syenyenyasuumu03(String pZtydai1syenyenyasuumu03) {
        ztydai1syenyenyasuumu03 = pZtydai1syenyenyasuumu03;
    }

    private String ztydai1syentuuktype03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPE03)
    public String getZtydai1syentuuktype03() {
        return ztydai1syentuuktype03;
    }

    public void setZtydai1syentuuktype03(String pZtydai1syentuuktype03) {
        ztydai1syentuuktype03 = pZtydai1syentuuktype03;
    }

    private String ztydai1syenyendaka03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKA03)
    public String getZtydai1syenyendaka03() {
        return ztydai1syenyendaka03;
    }

    public void setZtydai1syenyendaka03(String pZtydai1syenyendaka03) {
        ztydai1syenyendaka03 = pZtydai1syenyendaka03;
    }

    private String ztydai1syenyenkijyun03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUN03)
    public String getZtydai1syenyenkijyun03() {
        return ztydai1syenyenkijyun03;
    }

    public void setZtydai1syenyenkijyun03(String pZtydai1syenyenkijyun03) {
        ztydai1syenyenkijyun03 = pZtydai1syenyenkijyun03;
    }

    private String ztydai1syenyenyasu03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASU03)
    public String getZtydai1syenyenyasu03() {
        return ztydai1syenyenyasu03;
    }

    public void setZtydai1syenyenyasu03(String pZtydai1syenyenyasu03) {
        ztydai1syenyenyasu03 = pZtydai1syenyenyasu03;
    }

    private String ztydai1zennouzndk03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDK03)
    public String getZtydai1zennouzndk03() {
        return ztydai1zennouzndk03;
    }

    public void setZtydai1zennouzndk03(String pZtydai1zennouzndk03) {
        ztydai1zennouzndk03 = pZtydai1zennouzndk03;
    }

    private String ztydai1zennouzndktype03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDKTYPE03)
    public String getZtydai1zennouzndktype03() {
        return ztydai1zennouzndktype03;
    }

    public void setZtydai1zennouzndktype03(String pZtydai1zennouzndktype03) {
        ztydai1zennouzndktype03 = pZtydai1zennouzndktype03;
    }

    private String ztydai1sbjiuktgk03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGK03)
    public String getZtydai1sbjiuktgk03() {
        return ztydai1sbjiuktgk03;
    }

    public void setZtydai1sbjiuktgk03(String pZtydai1sbjiuktgk03) {
        ztydai1sbjiuktgk03 = pZtydai1sbjiuktgk03;
    }

    private String ztydai1sbjiuktgktype03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKTYPE03)
    public String getZtydai1sbjiuktgktype03() {
        return ztydai1sbjiuktgktype03;
    }

    public void setZtydai1sbjiuktgktype03(String pZtydai1sbjiuktgktype03) {
        ztydai1sbjiuktgktype03 = pZtydai1sbjiuktgktype03;
    }

    private String ztydai1sbjiuktgkytype03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYTYPE03)
    public String getZtydai1sbjiuktgkytype03() {
        return ztydai1sbjiuktgkytype03;
    }

    public void setZtydai1sbjiuktgkytype03(String pZtydai1sbjiuktgkytype03) {
        ztydai1sbjiuktgkytype03 = pZtydai1sbjiuktgkytype03;
    }

    private String ztydai1sbjiuktgkydaka03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYDAKA03)
    public String getZtydai1sbjiuktgkydaka03() {
        return ztydai1sbjiuktgkydaka03;
    }

    public void setZtydai1sbjiuktgkydaka03(String pZtydai1sbjiuktgkydaka03) {
        ztydai1sbjiuktgkydaka03 = pZtydai1sbjiuktgkydaka03;
    }

    private String ztydai1sbjiuktgkykijyun03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYKIJYUN03)
    public String getZtydai1sbjiuktgkykijyun03() {
        return ztydai1sbjiuktgkykijyun03;
    }

    public void setZtydai1sbjiuktgkykijyun03(String pZtydai1sbjiuktgkykijyun03) {
        ztydai1sbjiuktgkykijyun03 = pZtydai1sbjiuktgkykijyun03;
    }

    private String ztydai1sbjiuktgkyyasu03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYYASU03)
    public String getZtydai1sbjiuktgkyyasu03() {
        return ztydai1sbjiuktgkyyasu03;
    }

    public void setZtydai1sbjiuktgkyyasu03(String pZtydai1sbjiuktgkyyasu03) {
        ztydai1sbjiuktgkyyasu03 = pZtydai1sbjiuktgkyyasu03;
    }

    private String ztydai1sibousnenoutouymd4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SIBOUSNENOUTOUYMD4)
    public String getZtydai1sibousnenoutouymd4() {
        return ztydai1sibousnenoutouymd4;
    }

    public void setZtydai1sibousnenoutouymd4(String pZtydai1sibousnenoutouymd4) {
        ztydai1sibousnenoutouymd4 = pZtydai1sibousnenoutouymd4;
    }

    private String ztydai1stuuktype04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPE04)
    public String getZtydai1stuuktype04() {
        return ztydai1stuuktype04;
    }

    public void setZtydai1stuuktype04(String pZtydai1stuuktype04) {
        ztydai1stuuktype04 = pZtydai1stuuktype04;
    }

    private String ztydai1s04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1S04)
    public String getZtydai1s04() {
        return ztydai1s04;
    }

    public void setZtydai1s04(String pZtydai1s04) {
        ztydai1s04 = pZtydai1s04;
    }

    private String ztydai1syenyendakaumu04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMU04)
    public String getZtydai1syenyendakaumu04() {
        return ztydai1syenyendakaumu04;
    }

    public void setZtydai1syenyendakaumu04(String pZtydai1syenyendakaumu04) {
        ztydai1syenyendakaumu04 = pZtydai1syenyendakaumu04;
    }

    private String ztydai1syenyenkijyunumu04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNUMU04)
    public String getZtydai1syenyenkijyunumu04() {
        return ztydai1syenyenkijyunumu04;
    }

    public void setZtydai1syenyenkijyunumu04(String pZtydai1syenyenkijyunumu04) {
        ztydai1syenyenkijyunumu04 = pZtydai1syenyenkijyunumu04;
    }

    private String ztydai1syenyenyasuumu04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMU04)
    public String getZtydai1syenyenyasuumu04() {
        return ztydai1syenyenyasuumu04;
    }

    public void setZtydai1syenyenyasuumu04(String pZtydai1syenyenyasuumu04) {
        ztydai1syenyenyasuumu04 = pZtydai1syenyenyasuumu04;
    }

    private String ztydai1syentuuktype04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPE04)
    public String getZtydai1syentuuktype04() {
        return ztydai1syentuuktype04;
    }

    public void setZtydai1syentuuktype04(String pZtydai1syentuuktype04) {
        ztydai1syentuuktype04 = pZtydai1syentuuktype04;
    }

    private String ztydai1syenyendaka04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKA04)
    public String getZtydai1syenyendaka04() {
        return ztydai1syenyendaka04;
    }

    public void setZtydai1syenyendaka04(String pZtydai1syenyendaka04) {
        ztydai1syenyendaka04 = pZtydai1syenyendaka04;
    }

    private String ztydai1syenyenkijyun04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUN04)
    public String getZtydai1syenyenkijyun04() {
        return ztydai1syenyenkijyun04;
    }

    public void setZtydai1syenyenkijyun04(String pZtydai1syenyenkijyun04) {
        ztydai1syenyenkijyun04 = pZtydai1syenyenkijyun04;
    }

    private String ztydai1syenyenyasu04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASU04)
    public String getZtydai1syenyenyasu04() {
        return ztydai1syenyenyasu04;
    }

    public void setZtydai1syenyenyasu04(String pZtydai1syenyenyasu04) {
        ztydai1syenyenyasu04 = pZtydai1syenyenyasu04;
    }

    private String ztydai1zennouzndk04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDK04)
    public String getZtydai1zennouzndk04() {
        return ztydai1zennouzndk04;
    }

    public void setZtydai1zennouzndk04(String pZtydai1zennouzndk04) {
        ztydai1zennouzndk04 = pZtydai1zennouzndk04;
    }

    private String ztydai1zennouzndktype04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDKTYPE04)
    public String getZtydai1zennouzndktype04() {
        return ztydai1zennouzndktype04;
    }

    public void setZtydai1zennouzndktype04(String pZtydai1zennouzndktype04) {
        ztydai1zennouzndktype04 = pZtydai1zennouzndktype04;
    }

    private String ztydai1sbjiuktgk04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGK04)
    public String getZtydai1sbjiuktgk04() {
        return ztydai1sbjiuktgk04;
    }

    public void setZtydai1sbjiuktgk04(String pZtydai1sbjiuktgk04) {
        ztydai1sbjiuktgk04 = pZtydai1sbjiuktgk04;
    }

    private String ztydai1sbjiuktgktype04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKTYPE04)
    public String getZtydai1sbjiuktgktype04() {
        return ztydai1sbjiuktgktype04;
    }

    public void setZtydai1sbjiuktgktype04(String pZtydai1sbjiuktgktype04) {
        ztydai1sbjiuktgktype04 = pZtydai1sbjiuktgktype04;
    }

    private String ztydai1sbjiuktgkytype04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYTYPE04)
    public String getZtydai1sbjiuktgkytype04() {
        return ztydai1sbjiuktgkytype04;
    }

    public void setZtydai1sbjiuktgkytype04(String pZtydai1sbjiuktgkytype04) {
        ztydai1sbjiuktgkytype04 = pZtydai1sbjiuktgkytype04;
    }

    private String ztydai1sbjiuktgkydaka04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYDAKA04)
    public String getZtydai1sbjiuktgkydaka04() {
        return ztydai1sbjiuktgkydaka04;
    }

    public void setZtydai1sbjiuktgkydaka04(String pZtydai1sbjiuktgkydaka04) {
        ztydai1sbjiuktgkydaka04 = pZtydai1sbjiuktgkydaka04;
    }

    private String ztydai1sbjiuktgkykijyun04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYKIJYUN04)
    public String getZtydai1sbjiuktgkykijyun04() {
        return ztydai1sbjiuktgkykijyun04;
    }

    public void setZtydai1sbjiuktgkykijyun04(String pZtydai1sbjiuktgkykijyun04) {
        ztydai1sbjiuktgkykijyun04 = pZtydai1sbjiuktgkykijyun04;
    }

    private String ztydai1sbjiuktgkyyasu04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYYASU04)
    public String getZtydai1sbjiuktgkyyasu04() {
        return ztydai1sbjiuktgkyyasu04;
    }

    public void setZtydai1sbjiuktgkyyasu04(String pZtydai1sbjiuktgkyyasu04) {
        ztydai1sbjiuktgkyyasu04 = pZtydai1sbjiuktgkyyasu04;
    }

    private String ztydai1sibousnenoutouymd5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SIBOUSNENOUTOUYMD5)
    public String getZtydai1sibousnenoutouymd5() {
        return ztydai1sibousnenoutouymd5;
    }

    public void setZtydai1sibousnenoutouymd5(String pZtydai1sibousnenoutouymd5) {
        ztydai1sibousnenoutouymd5 = pZtydai1sibousnenoutouymd5;
    }

    private String ztydai1stuuktype05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPE05)
    public String getZtydai1stuuktype05() {
        return ztydai1stuuktype05;
    }

    public void setZtydai1stuuktype05(String pZtydai1stuuktype05) {
        ztydai1stuuktype05 = pZtydai1stuuktype05;
    }

    private String ztydai1s05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1S05)
    public String getZtydai1s05() {
        return ztydai1s05;
    }

    public void setZtydai1s05(String pZtydai1s05) {
        ztydai1s05 = pZtydai1s05;
    }

    private String ztydai1syenyendakaumu05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMU05)
    public String getZtydai1syenyendakaumu05() {
        return ztydai1syenyendakaumu05;
    }

    public void setZtydai1syenyendakaumu05(String pZtydai1syenyendakaumu05) {
        ztydai1syenyendakaumu05 = pZtydai1syenyendakaumu05;
    }

    private String ztydai1syenyenkijyunumu05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNUMU05)
    public String getZtydai1syenyenkijyunumu05() {
        return ztydai1syenyenkijyunumu05;
    }

    public void setZtydai1syenyenkijyunumu05(String pZtydai1syenyenkijyunumu05) {
        ztydai1syenyenkijyunumu05 = pZtydai1syenyenkijyunumu05;
    }

    private String ztydai1syenyenyasuumu05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMU05)
    public String getZtydai1syenyenyasuumu05() {
        return ztydai1syenyenyasuumu05;
    }

    public void setZtydai1syenyenyasuumu05(String pZtydai1syenyenyasuumu05) {
        ztydai1syenyenyasuumu05 = pZtydai1syenyenyasuumu05;
    }

    private String ztydai1syentuuktype05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPE05)
    public String getZtydai1syentuuktype05() {
        return ztydai1syentuuktype05;
    }

    public void setZtydai1syentuuktype05(String pZtydai1syentuuktype05) {
        ztydai1syentuuktype05 = pZtydai1syentuuktype05;
    }

    private String ztydai1syenyendaka05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKA05)
    public String getZtydai1syenyendaka05() {
        return ztydai1syenyendaka05;
    }

    public void setZtydai1syenyendaka05(String pZtydai1syenyendaka05) {
        ztydai1syenyendaka05 = pZtydai1syenyendaka05;
    }

    private String ztydai1syenyenkijyun05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUN05)
    public String getZtydai1syenyenkijyun05() {
        return ztydai1syenyenkijyun05;
    }

    public void setZtydai1syenyenkijyun05(String pZtydai1syenyenkijyun05) {
        ztydai1syenyenkijyun05 = pZtydai1syenyenkijyun05;
    }

    private String ztydai1syenyenyasu05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASU05)
    public String getZtydai1syenyenyasu05() {
        return ztydai1syenyenyasu05;
    }

    public void setZtydai1syenyenyasu05(String pZtydai1syenyenyasu05) {
        ztydai1syenyenyasu05 = pZtydai1syenyenyasu05;
    }

    private String ztydai1zennouzndk05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDK05)
    public String getZtydai1zennouzndk05() {
        return ztydai1zennouzndk05;
    }

    public void setZtydai1zennouzndk05(String pZtydai1zennouzndk05) {
        ztydai1zennouzndk05 = pZtydai1zennouzndk05;
    }

    private String ztydai1zennouzndktype05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDKTYPE05)
    public String getZtydai1zennouzndktype05() {
        return ztydai1zennouzndktype05;
    }

    public void setZtydai1zennouzndktype05(String pZtydai1zennouzndktype05) {
        ztydai1zennouzndktype05 = pZtydai1zennouzndktype05;
    }

    private String ztydai1sbjiuktgk05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGK05)
    public String getZtydai1sbjiuktgk05() {
        return ztydai1sbjiuktgk05;
    }

    public void setZtydai1sbjiuktgk05(String pZtydai1sbjiuktgk05) {
        ztydai1sbjiuktgk05 = pZtydai1sbjiuktgk05;
    }

    private String ztydai1sbjiuktgktype05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKTYPE05)
    public String getZtydai1sbjiuktgktype05() {
        return ztydai1sbjiuktgktype05;
    }

    public void setZtydai1sbjiuktgktype05(String pZtydai1sbjiuktgktype05) {
        ztydai1sbjiuktgktype05 = pZtydai1sbjiuktgktype05;
    }

    private String ztydai1sbjiuktgkytype05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYTYPE05)
    public String getZtydai1sbjiuktgkytype05() {
        return ztydai1sbjiuktgkytype05;
    }

    public void setZtydai1sbjiuktgkytype05(String pZtydai1sbjiuktgkytype05) {
        ztydai1sbjiuktgkytype05 = pZtydai1sbjiuktgkytype05;
    }

    private String ztydai1sbjiuktgkydaka05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYDAKA05)
    public String getZtydai1sbjiuktgkydaka05() {
        return ztydai1sbjiuktgkydaka05;
    }

    public void setZtydai1sbjiuktgkydaka05(String pZtydai1sbjiuktgkydaka05) {
        ztydai1sbjiuktgkydaka05 = pZtydai1sbjiuktgkydaka05;
    }

    private String ztydai1sbjiuktgkykijyun05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYKIJYUN05)
    public String getZtydai1sbjiuktgkykijyun05() {
        return ztydai1sbjiuktgkykijyun05;
    }

    public void setZtydai1sbjiuktgkykijyun05(String pZtydai1sbjiuktgkykijyun05) {
        ztydai1sbjiuktgkykijyun05 = pZtydai1sbjiuktgkykijyun05;
    }

    private String ztydai1sbjiuktgkyyasu05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYYASU05)
    public String getZtydai1sbjiuktgkyyasu05() {
        return ztydai1sbjiuktgkyyasu05;
    }

    public void setZtydai1sbjiuktgkyyasu05(String pZtydai1sbjiuktgkyyasu05) {
        ztydai1sbjiuktgkyyasu05 = pZtydai1sbjiuktgkyyasu05;
    }

    private String ztydai1sibousnenoutouymd6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SIBOUSNENOUTOUYMD6)
    public String getZtydai1sibousnenoutouymd6() {
        return ztydai1sibousnenoutouymd6;
    }

    public void setZtydai1sibousnenoutouymd6(String pZtydai1sibousnenoutouymd6) {
        ztydai1sibousnenoutouymd6 = pZtydai1sibousnenoutouymd6;
    }

    private String ztydai1stuuktype06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPE06)
    public String getZtydai1stuuktype06() {
        return ztydai1stuuktype06;
    }

    public void setZtydai1stuuktype06(String pZtydai1stuuktype06) {
        ztydai1stuuktype06 = pZtydai1stuuktype06;
    }

    private String ztydai1s06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1S06)
    public String getZtydai1s06() {
        return ztydai1s06;
    }

    public void setZtydai1s06(String pZtydai1s06) {
        ztydai1s06 = pZtydai1s06;
    }

    private String ztydai1syenyendakaumu06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMU06)
    public String getZtydai1syenyendakaumu06() {
        return ztydai1syenyendakaumu06;
    }

    public void setZtydai1syenyendakaumu06(String pZtydai1syenyendakaumu06) {
        ztydai1syenyendakaumu06 = pZtydai1syenyendakaumu06;
    }

    private String ztydai1syenyenkijyunumu06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNUMU06)
    public String getZtydai1syenyenkijyunumu06() {
        return ztydai1syenyenkijyunumu06;
    }

    public void setZtydai1syenyenkijyunumu06(String pZtydai1syenyenkijyunumu06) {
        ztydai1syenyenkijyunumu06 = pZtydai1syenyenkijyunumu06;
    }

    private String ztydai1syenyenyasuumu06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMU06)
    public String getZtydai1syenyenyasuumu06() {
        return ztydai1syenyenyasuumu06;
    }

    public void setZtydai1syenyenyasuumu06(String pZtydai1syenyenyasuumu06) {
        ztydai1syenyenyasuumu06 = pZtydai1syenyenyasuumu06;
    }

    private String ztydai1syentuuktype06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPE06)
    public String getZtydai1syentuuktype06() {
        return ztydai1syentuuktype06;
    }

    public void setZtydai1syentuuktype06(String pZtydai1syentuuktype06) {
        ztydai1syentuuktype06 = pZtydai1syentuuktype06;
    }

    private String ztydai1syenyendaka06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKA06)
    public String getZtydai1syenyendaka06() {
        return ztydai1syenyendaka06;
    }

    public void setZtydai1syenyendaka06(String pZtydai1syenyendaka06) {
        ztydai1syenyendaka06 = pZtydai1syenyendaka06;
    }

    private String ztydai1syenyenkijyun06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUN06)
    public String getZtydai1syenyenkijyun06() {
        return ztydai1syenyenkijyun06;
    }

    public void setZtydai1syenyenkijyun06(String pZtydai1syenyenkijyun06) {
        ztydai1syenyenkijyun06 = pZtydai1syenyenkijyun06;
    }

    private String ztydai1syenyenyasu06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASU06)
    public String getZtydai1syenyenyasu06() {
        return ztydai1syenyenyasu06;
    }

    public void setZtydai1syenyenyasu06(String pZtydai1syenyenyasu06) {
        ztydai1syenyenyasu06 = pZtydai1syenyenyasu06;
    }

    private String ztydai1zennouzndk06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDK06)
    public String getZtydai1zennouzndk06() {
        return ztydai1zennouzndk06;
    }

    public void setZtydai1zennouzndk06(String pZtydai1zennouzndk06) {
        ztydai1zennouzndk06 = pZtydai1zennouzndk06;
    }

    private String ztydai1zennouzndktype06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1ZENNOUZNDKTYPE06)
    public String getZtydai1zennouzndktype06() {
        return ztydai1zennouzndktype06;
    }

    public void setZtydai1zennouzndktype06(String pZtydai1zennouzndktype06) {
        ztydai1zennouzndktype06 = pZtydai1zennouzndktype06;
    }

    private String ztydai1sbjiuktgk06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGK06)
    public String getZtydai1sbjiuktgk06() {
        return ztydai1sbjiuktgk06;
    }

    public void setZtydai1sbjiuktgk06(String pZtydai1sbjiuktgk06) {
        ztydai1sbjiuktgk06 = pZtydai1sbjiuktgk06;
    }

    private String ztydai1sbjiuktgktype06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKTYPE06)
    public String getZtydai1sbjiuktgktype06() {
        return ztydai1sbjiuktgktype06;
    }

    public void setZtydai1sbjiuktgktype06(String pZtydai1sbjiuktgktype06) {
        ztydai1sbjiuktgktype06 = pZtydai1sbjiuktgktype06;
    }

    private String ztydai1sbjiuktgkytype06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYTYPE06)
    public String getZtydai1sbjiuktgkytype06() {
        return ztydai1sbjiuktgkytype06;
    }

    public void setZtydai1sbjiuktgkytype06(String pZtydai1sbjiuktgkytype06) {
        ztydai1sbjiuktgkytype06 = pZtydai1sbjiuktgkytype06;
    }

    private String ztydai1sbjiuktgkydaka06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYDAKA06)
    public String getZtydai1sbjiuktgkydaka06() {
        return ztydai1sbjiuktgkydaka06;
    }

    public void setZtydai1sbjiuktgkydaka06(String pZtydai1sbjiuktgkydaka06) {
        ztydai1sbjiuktgkydaka06 = pZtydai1sbjiuktgkydaka06;
    }

    private String ztydai1sbjiuktgkykijyun06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYKIJYUN06)
    public String getZtydai1sbjiuktgkykijyun06() {
        return ztydai1sbjiuktgkykijyun06;
    }

    public void setZtydai1sbjiuktgkykijyun06(String pZtydai1sbjiuktgkykijyun06) {
        ztydai1sbjiuktgkykijyun06 = pZtydai1sbjiuktgkykijyun06;
    }

    private String ztydai1sbjiuktgkyyasu06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SBJIUKTGKYYASU06)
    public String getZtydai1sbjiuktgkyyasu06() {
        return ztydai1sbjiuktgkyyasu06;
    }

    public void setZtydai1sbjiuktgkyyasu06(String pZtydai1sbjiuktgkyyasu06) {
        ztydai1sbjiuktgkyyasu06 = pZtydai1sbjiuktgkyyasu06;
    }

    private String ztydai1sibousnenoutouymd7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SIBOUSNENOUTOUYMD7)
    public String getZtydai1sibousnenoutouymd7() {
        return ztydai1sibousnenoutouymd7;
    }

    public void setZtydai1sibousnenoutouymd7(String pZtydai1sibousnenoutouymd7) {
        ztydai1sibousnenoutouymd7 = pZtydai1sibousnenoutouymd7;
    }

    private String ztydai1stuuktype07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPE07)
    public String getZtydai1stuuktype07() {
        return ztydai1stuuktype07;
    }

    public void setZtydai1stuuktype07(String pZtydai1stuuktype07) {
        ztydai1stuuktype07 = pZtydai1stuuktype07;
    }

    private String ztydai1s07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1S07)
    public String getZtydai1s07() {
        return ztydai1s07;
    }

    public void setZtydai1s07(String pZtydai1s07) {
        ztydai1s07 = pZtydai1s07;
    }

    private String ztydai1syenyendakaumu07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMU07)
    public String getZtydai1syenyendakaumu07() {
        return ztydai1syenyendakaumu07;
    }

    public void setZtydai1syenyendakaumu07(String pZtydai1syenyendakaumu07) {
        ztydai1syenyendakaumu07 = pZtydai1syenyendakaumu07;
    }

    private String ztydai1syenyenkijyunumu07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNUMU07)
    public String getZtydai1syenyenkijyunumu07() {
        return ztydai1syenyenkijyunumu07;
    }

    public void setZtydai1syenyenkijyunumu07(String pZtydai1syenyenkijyunumu07) {
        ztydai1syenyenkijyunumu07 = pZtydai1syenyenkijyunumu07;
    }

    private String ztydai1syenyenyasuumu07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMU07)
    public String getZtydai1syenyenyasuumu07() {
        return ztydai1syenyenyasuumu07;
    }

    public void setZtydai1syenyenyasuumu07(String pZtydai1syenyenyasuumu07) {
        ztydai1syenyenyasuumu07 = pZtydai1syenyenyasuumu07;
    }

    private String ztydai1syentuuktype07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPE07)
    public String getZtydai1syentuuktype07() {
        return ztydai1syentuuktype07;
    }

    public void setZtydai1syentuuktype07(String pZtydai1syentuuktype07) {
        ztydai1syentuuktype07 = pZtydai1syentuuktype07;
    }

    private String ztydai1syenyendaka07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKA07)
    public String getZtydai1syenyendaka07() {
        return ztydai1syenyendaka07;
    }

    public void setZtydai1syenyendaka07(String pZtydai1syenyendaka07) {
        ztydai1syenyendaka07 = pZtydai1syenyendaka07;
    }

    private String ztydai1syenyenkijyun07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUN07)
    public String getZtydai1syenyenkijyun07() {
        return ztydai1syenyenkijyun07;
    }

    public void setZtydai1syenyenkijyun07(String pZtydai1syenyenkijyun07) {
        ztydai1syenyenkijyun07 = pZtydai1syenyenkijyun07;
    }

    private String ztydai1syenyenyasu07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASU07)
    public String getZtydai1syenyenyasu07() {
        return ztydai1syenyenyasu07;
    }

    public void setZtydai1syenyenyasu07(String pZtydai1syenyenyasu07) {
        ztydai1syenyenyasu07 = pZtydai1syenyenyasu07;
    }

    private String ztydai1sibousnenoutouymd8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SIBOUSNENOUTOUYMD8)
    public String getZtydai1sibousnenoutouymd8() {
        return ztydai1sibousnenoutouymd8;
    }

    public void setZtydai1sibousnenoutouymd8(String pZtydai1sibousnenoutouymd8) {
        ztydai1sibousnenoutouymd8 = pZtydai1sibousnenoutouymd8;
    }

    private String ztydai1stuuktype08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPE08)
    public String getZtydai1stuuktype08() {
        return ztydai1stuuktype08;
    }

    public void setZtydai1stuuktype08(String pZtydai1stuuktype08) {
        ztydai1stuuktype08 = pZtydai1stuuktype08;
    }

    private String ztydai1s08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1S08)
    public String getZtydai1s08() {
        return ztydai1s08;
    }

    public void setZtydai1s08(String pZtydai1s08) {
        ztydai1s08 = pZtydai1s08;
    }

    private String ztydai1syenyendakaumu08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMU08)
    public String getZtydai1syenyendakaumu08() {
        return ztydai1syenyendakaumu08;
    }

    public void setZtydai1syenyendakaumu08(String pZtydai1syenyendakaumu08) {
        ztydai1syenyendakaumu08 = pZtydai1syenyendakaumu08;
    }

    private String ztydai1syenyenkijyunumu08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNUMU08)
    public String getZtydai1syenyenkijyunumu08() {
        return ztydai1syenyenkijyunumu08;
    }

    public void setZtydai1syenyenkijyunumu08(String pZtydai1syenyenkijyunumu08) {
        ztydai1syenyenkijyunumu08 = pZtydai1syenyenkijyunumu08;
    }

    private String ztydai1syenyenyasuumu08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMU08)
    public String getZtydai1syenyenyasuumu08() {
        return ztydai1syenyenyasuumu08;
    }

    public void setZtydai1syenyenyasuumu08(String pZtydai1syenyenyasuumu08) {
        ztydai1syenyenyasuumu08 = pZtydai1syenyenyasuumu08;
    }

    private String ztydai1syentuuktype08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPE08)
    public String getZtydai1syentuuktype08() {
        return ztydai1syentuuktype08;
    }

    public void setZtydai1syentuuktype08(String pZtydai1syentuuktype08) {
        ztydai1syentuuktype08 = pZtydai1syentuuktype08;
    }

    private String ztydai1syenyendaka08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKA08)
    public String getZtydai1syenyendaka08() {
        return ztydai1syenyendaka08;
    }

    public void setZtydai1syenyendaka08(String pZtydai1syenyendaka08) {
        ztydai1syenyendaka08 = pZtydai1syenyendaka08;
    }

    private String ztydai1syenyenkijyun08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUN08)
    public String getZtydai1syenyenkijyun08() {
        return ztydai1syenyenkijyun08;
    }

    public void setZtydai1syenyenkijyun08(String pZtydai1syenyenkijyun08) {
        ztydai1syenyenkijyun08 = pZtydai1syenyenkijyun08;
    }

    private String ztydai1syenyenyasu08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASU08)
    public String getZtydai1syenyenyasu08() {
        return ztydai1syenyenyasu08;
    }

    public void setZtydai1syenyenyasu08(String pZtydai1syenyenyasu08) {
        ztydai1syenyenyasu08 = pZtydai1syenyenyasu08;
    }

    private String ztydai1sibousnenoutouymd9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SIBOUSNENOUTOUYMD9)
    public String getZtydai1sibousnenoutouymd9() {
        return ztydai1sibousnenoutouymd9;
    }

    public void setZtydai1sibousnenoutouymd9(String pZtydai1sibousnenoutouymd9) {
        ztydai1sibousnenoutouymd9 = pZtydai1sibousnenoutouymd9;
    }

    private String ztydai1stuuktype09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPE09)
    public String getZtydai1stuuktype09() {
        return ztydai1stuuktype09;
    }

    public void setZtydai1stuuktype09(String pZtydai1stuuktype09) {
        ztydai1stuuktype09 = pZtydai1stuuktype09;
    }

    private String ztydai1s09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1S09)
    public String getZtydai1s09() {
        return ztydai1s09;
    }

    public void setZtydai1s09(String pZtydai1s09) {
        ztydai1s09 = pZtydai1s09;
    }

    private String ztydai1syenyendakaumu09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMU09)
    public String getZtydai1syenyendakaumu09() {
        return ztydai1syenyendakaumu09;
    }

    public void setZtydai1syenyendakaumu09(String pZtydai1syenyendakaumu09) {
        ztydai1syenyendakaumu09 = pZtydai1syenyendakaumu09;
    }

    private String ztydai1syenyenkijyunumu09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNUMU09)
    public String getZtydai1syenyenkijyunumu09() {
        return ztydai1syenyenkijyunumu09;
    }

    public void setZtydai1syenyenkijyunumu09(String pZtydai1syenyenkijyunumu09) {
        ztydai1syenyenkijyunumu09 = pZtydai1syenyenkijyunumu09;
    }

    private String ztydai1syenyenyasuumu09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMU09)
    public String getZtydai1syenyenyasuumu09() {
        return ztydai1syenyenyasuumu09;
    }

    public void setZtydai1syenyenyasuumu09(String pZtydai1syenyenyasuumu09) {
        ztydai1syenyenyasuumu09 = pZtydai1syenyenyasuumu09;
    }

    private String ztydai1syentuuktype09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPE09)
    public String getZtydai1syentuuktype09() {
        return ztydai1syentuuktype09;
    }

    public void setZtydai1syentuuktype09(String pZtydai1syentuuktype09) {
        ztydai1syentuuktype09 = pZtydai1syentuuktype09;
    }

    private String ztydai1syenyendaka09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKA09)
    public String getZtydai1syenyendaka09() {
        return ztydai1syenyendaka09;
    }

    public void setZtydai1syenyendaka09(String pZtydai1syenyendaka09) {
        ztydai1syenyendaka09 = pZtydai1syenyendaka09;
    }

    private String ztydai1syenyenkijyun09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUN09)
    public String getZtydai1syenyenkijyun09() {
        return ztydai1syenyenkijyun09;
    }

    public void setZtydai1syenyenkijyun09(String pZtydai1syenyenkijyun09) {
        ztydai1syenyenkijyun09 = pZtydai1syenyenkijyun09;
    }

    private String ztydai1syenyenyasu09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASU09)
    public String getZtydai1syenyenyasu09() {
        return ztydai1syenyenyasu09;
    }

    public void setZtydai1syenyenyasu09(String pZtydai1syenyenyasu09) {
        ztydai1syenyenyasu09 = pZtydai1syenyenyasu09;
    }

    private String ztydai1sibousnenoutouymd10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SIBOUSNENOUTOUYMD10)
    public String getZtydai1sibousnenoutouymd10() {
        return ztydai1sibousnenoutouymd10;
    }

    public void setZtydai1sibousnenoutouymd10(String pZtydai1sibousnenoutouymd10) {
        ztydai1sibousnenoutouymd10 = pZtydai1sibousnenoutouymd10;
    }

    private String ztydai1stuuktype10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPE10)
    public String getZtydai1stuuktype10() {
        return ztydai1stuuktype10;
    }

    public void setZtydai1stuuktype10(String pZtydai1stuuktype10) {
        ztydai1stuuktype10 = pZtydai1stuuktype10;
    }

    private String ztydai1s10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1S10)
    public String getZtydai1s10() {
        return ztydai1s10;
    }

    public void setZtydai1s10(String pZtydai1s10) {
        ztydai1s10 = pZtydai1s10;
    }

    private String ztydai1syenyendakaumu10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMU10)
    public String getZtydai1syenyendakaumu10() {
        return ztydai1syenyendakaumu10;
    }

    public void setZtydai1syenyendakaumu10(String pZtydai1syenyendakaumu10) {
        ztydai1syenyendakaumu10 = pZtydai1syenyendakaumu10;
    }

    private String ztydai1syenyenkijyunumu10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNUMU10)
    public String getZtydai1syenyenkijyunumu10() {
        return ztydai1syenyenkijyunumu10;
    }

    public void setZtydai1syenyenkijyunumu10(String pZtydai1syenyenkijyunumu10) {
        ztydai1syenyenkijyunumu10 = pZtydai1syenyenkijyunumu10;
    }

    private String ztydai1syenyenyasuumu10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMU10)
    public String getZtydai1syenyenyasuumu10() {
        return ztydai1syenyenyasuumu10;
    }

    public void setZtydai1syenyenyasuumu10(String pZtydai1syenyenyasuumu10) {
        ztydai1syenyenyasuumu10 = pZtydai1syenyenyasuumu10;
    }

    private String ztydai1syentuuktype10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPE10)
    public String getZtydai1syentuuktype10() {
        return ztydai1syentuuktype10;
    }

    public void setZtydai1syentuuktype10(String pZtydai1syentuuktype10) {
        ztydai1syentuuktype10 = pZtydai1syentuuktype10;
    }

    private String ztydai1syenyendaka10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKA10)
    public String getZtydai1syenyendaka10() {
        return ztydai1syenyendaka10;
    }

    public void setZtydai1syenyendaka10(String pZtydai1syenyendaka10) {
        ztydai1syenyendaka10 = pZtydai1syenyendaka10;
    }

    private String ztydai1syenyenkijyun10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUN10)
    public String getZtydai1syenyenkijyun10() {
        return ztydai1syenyenkijyun10;
    }

    public void setZtydai1syenyenkijyun10(String pZtydai1syenyenkijyun10) {
        ztydai1syenyenkijyun10 = pZtydai1syenyenkijyun10;
    }

    private String ztydai1syenyenyasu10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASU10)
    public String getZtydai1syenyenyasu10() {
        return ztydai1syenyenyasu10;
    }

    public void setZtydai1syenyenyasu10(String pZtydai1syenyenyasu10) {
        ztydai1syenyenyasu10 = pZtydai1syenyenyasu10;
    }

    private String ztydai1stuuktypehuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1STUUKTYPEHURYO)
    public String getZtydai1stuuktypehuryo() {
        return ztydai1stuuktypehuryo;
    }

    public void setZtydai1stuuktypehuryo(String pZtydai1stuuktypehuryo) {
        ztydai1stuuktypehuryo = pZtydai1stuuktypehuryo;
    }

    private String ztydai1shuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SHURYO)
    public String getZtydai1shuryo() {
        return ztydai1shuryo;
    }

    public void setZtydai1shuryo(String pZtydai1shuryo) {
        ztydai1shuryo = pZtydai1shuryo;
    }

    private String ztydai1syenyendakaumuhuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAUMUHURYO)
    public String getZtydai1syenyendakaumuhuryo() {
        return ztydai1syenyendakaumuhuryo;
    }

    public void setZtydai1syenyendakaumuhuryo(String pZtydai1syenyendakaumuhuryo) {
        ztydai1syenyendakaumuhuryo = pZtydai1syenyendakaumuhuryo;
    }

    private String ztydai1syenyenkjnumuhuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKJNUMUHURYO)
    public String getZtydai1syenyenkjnumuhuryo() {
        return ztydai1syenyenkjnumuhuryo;
    }

    public void setZtydai1syenyenkjnumuhuryo(String pZtydai1syenyenkjnumuhuryo) {
        ztydai1syenyenkjnumuhuryo = pZtydai1syenyenkjnumuhuryo;
    }

    private String ztydai1syenyenyasuumuhuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUUMUHURYO)
    public String getZtydai1syenyenyasuumuhuryo() {
        return ztydai1syenyenyasuumuhuryo;
    }

    public void setZtydai1syenyenyasuumuhuryo(String pZtydai1syenyenyasuumuhuryo) {
        ztydai1syenyenyasuumuhuryo = pZtydai1syenyenyasuumuhuryo;
    }

    private String ztydai1syentuuktypehuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENTUUKTYPEHURYO)
    public String getZtydai1syentuuktypehuryo() {
        return ztydai1syentuuktypehuryo;
    }

    public void setZtydai1syentuuktypehuryo(String pZtydai1syentuuktypehuryo) {
        ztydai1syentuuktypehuryo = pZtydai1syentuuktypehuryo;
    }

    private String ztydai1syenyendakahuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENDAKAHURYO)
    public String getZtydai1syenyendakahuryo() {
        return ztydai1syenyendakahuryo;
    }

    public void setZtydai1syenyendakahuryo(String pZtydai1syenyendakahuryo) {
        ztydai1syenyendakahuryo = pZtydai1syenyendakahuryo;
    }

    private String ztydai1syenyenkijyunhuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENKIJYUNHURYO)
    public String getZtydai1syenyenkijyunhuryo() {
        return ztydai1syenyenkijyunhuryo;
    }

    public void setZtydai1syenyenkijyunhuryo(String pZtydai1syenyenkijyunhuryo) {
        ztydai1syenyenkijyunhuryo = pZtydai1syenyenkijyunhuryo;
    }

    private String ztydai1syenyenyasuhuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI1SYENYENYASUHURYO)
    public String getZtydai1syenyenyasuhuryo() {
        return ztydai1syenyenyasuhuryo;
    }

    public void setZtydai1syenyenyasuhuryo(String pZtydai1syenyenyasuhuryo) {
        ztydai1syenyenyasuhuryo = pZtydai1syenyenyasuhuryo;
    }

    private String ztydai2stuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI2STUUKTYPE)
    public String getZtydai2stuuktype() {
        return ztydai2stuuktype;
    }

    public void setZtydai2stuuktype(String pZtydai2stuuktype) {
        ztydai2stuuktype = pZtydai2stuuktype;
    }

    private String ztydai2s;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI2S)
    public String getZtydai2s() {
        return ztydai2s;
    }

    public void setZtydai2s(String pZtydai2s) {
        ztydai2s = pZtydai2s;
    }

    private String ztydai2syentuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI2SYENTUUKTYPE)
    public String getZtydai2syentuuktype() {
        return ztydai2syentuuktype;
    }

    public void setZtydai2syentuuktype(String pZtydai2syentuuktype) {
        ztydai2syentuuktype = pZtydai2syentuuktype;
    }

    private String ztydai2syenyendaka;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI2SYENYENDAKA)
    public String getZtydai2syenyendaka() {
        return ztydai2syenyendaka;
    }

    public void setZtydai2syenyendaka(String pZtydai2syenyendaka) {
        ztydai2syenyendaka = pZtydai2syenyendaka;
    }

    private String ztydai2syenyenkijyun;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI2SYENYENKIJYUN)
    public String getZtydai2syenyenkijyun() {
        return ztydai2syenyenkijyun;
    }

    public void setZtydai2syenyenkijyun(String pZtydai2syenyenkijyun) {
        ztydai2syenyenkijyun = pZtydai2syenyenkijyun;
    }

    private String ztydai2syenyenyasu;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI2SYENYENYASU)
    public String getZtydai2syenyenyasu() {
        return ztydai2syenyenyasu;
    }

    public void setZtydai2syenyenyasu(String pZtydai2syenyenyasu) {
        ztydai2syenyenyasu = pZtydai2syenyenyasu;
    }

    private String ztydai3stuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI3STUUKTYPE)
    public String getZtydai3stuuktype() {
        return ztydai3stuuktype;
    }

    public void setZtydai3stuuktype(String pZtydai3stuuktype) {
        ztydai3stuuktype = pZtydai3stuuktype;
    }

    private String ztydai3s;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI3S)
    public String getZtydai3s() {
        return ztydai3s;
    }

    public void setZtydai3s(String pZtydai3s) {
        ztydai3s = pZtydai3s;
    }

    private String ztydai3syentuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI3SYENTUUKTYPE)
    public String getZtydai3syentuuktype() {
        return ztydai3syentuuktype;
    }

    public void setZtydai3syentuuktype(String pZtydai3syentuuktype) {
        ztydai3syentuuktype = pZtydai3syentuuktype;
    }

    private String ztydai3syenyendaka;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI3SYENYENDAKA)
    public String getZtydai3syenyendaka() {
        return ztydai3syenyendaka;
    }

    public void setZtydai3syenyendaka(String pZtydai3syenyendaka) {
        ztydai3syenyendaka = pZtydai3syenyendaka;
    }

    private String ztydai3syenyenkijyun;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI3SYENYENKIJYUN)
    public String getZtydai3syenyenkijyun() {
        return ztydai3syenyenkijyun;
    }

    public void setZtydai3syenyenkijyun(String pZtydai3syenyenkijyun) {
        ztydai3syenyenkijyun = pZtydai3syenyenkijyun;
    }

    private String ztydai3syenyenyasu;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYDAI3SYENYENYASU)
    public String getZtydai3syenyenyasu() {
        return ztydai3syenyenyasu;
    }

    public void setZtydai3syenyenyasu(String pZtydai3syenyenyasu) {
        ztydai3syenyenyasu = pZtydai3syenyenyasu;
    }

    private String ztysibouinjiptnkbn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUINJIPTNKBN)
    public String getZtysibouinjiptnkbn() {
        return ztysibouinjiptnkbn;
    }

    public void setZtysibouinjiptnkbn(String pZtysibouinjiptnkbn) {
        ztysibouinjiptnkbn = pZtysibouinjiptnkbn;
    }

    private String ztyyobiv25;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV25)
    public String getZtyyobiv25() {
        return ztyyobiv25;
    }

    public void setZtyyobiv25(String pZtyyobiv25) {
        ztyyobiv25 = pZtyyobiv25;
    }

    private String ztynkmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKMSGCD1)
    public String getZtynkmsgcd1() {
        return ztynkmsgcd1;
    }

    public void setZtynkmsgcd1(String pZtynkmsgcd1) {
        ztynkmsgcd1 = pZtynkmsgcd1;
    }

    private String ztynkmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKMSGCD2)
    public String getZtynkmsgcd2() {
        return ztynkmsgcd2;
    }

    public void setZtynkmsgcd2(String pZtynkmsgcd2) {
        ztynkmsgcd2 = pZtynkmsgcd2;
    }

    private String ztynkmsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKMSGCD3)
    public String getZtynkmsgcd3() {
        return ztynkmsgcd3;
    }

    public void setZtynkmsgcd3(String pZtynkmsgcd3) {
        ztynkmsgcd3 = pZtynkmsgcd3;
    }

    private String ztynkmsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKMSGCD4)
    public String getZtynkmsgcd4() {
        return ztynkmsgcd4;
    }

    public void setZtynkmsgcd4(String pZtynkmsgcd4) {
        ztynkmsgcd4 = pZtynkmsgcd4;
    }

    private String ztynkmsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKMSGCD5)
    public String getZtynkmsgcd5() {
        return ztynkmsgcd5;
    }

    public void setZtynkmsgcd5(String pZtynkmsgcd5) {
        ztynkmsgcd5 = pZtynkmsgcd5;
    }

    private String ztynkmsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKMSGCD6)
    public String getZtynkmsgcd6() {
        return ztynkmsgcd6;
    }

    public void setZtynkmsgcd6(String pZtynkmsgcd6) {
        ztynkmsgcd6 = pZtynkmsgcd6;
    }

    private String ztynkmsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKMSGCD7)
    public String getZtynkmsgcd7() {
        return ztynkmsgcd7;
    }

    public void setZtynkmsgcd7(String pZtynkmsgcd7) {
        ztynkmsgcd7 = pZtynkmsgcd7;
    }

    private String ztynkmsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKMSGCD8)
    public String getZtynkmsgcd8() {
        return ztynkmsgcd8;
    }

    public void setZtynkmsgcd8(String pZtynkmsgcd8) {
        ztynkmsgcd8 = pZtynkmsgcd8;
    }

    private String ztynkmsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKMSGCD9)
    public String getZtynkmsgcd9() {
        return ztynkmsgcd9;
    }

    public void setZtynkmsgcd9(String pZtynkmsgcd9) {
        ztynkmsgcd9 = pZtynkmsgcd9;
    }

    private String ztynkmsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKMSGCD10)
    public String getZtynkmsgcd10() {
        return ztynkmsgcd10;
    }

    public void setZtynkmsgcd10(String pZtynkmsgcd10) {
        ztynkmsgcd10 = pZtynkmsgcd10;
    }

    private String ztysiboukyuuhukinmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUKYUUHUKINMSGCD1)
    public String getZtysiboukyuuhukinmsgcd1() {
        return ztysiboukyuuhukinmsgcd1;
    }

    public void setZtysiboukyuuhukinmsgcd1(String pZtysiboukyuuhukinmsgcd1) {
        ztysiboukyuuhukinmsgcd1 = pZtysiboukyuuhukinmsgcd1;
    }

    private String ztysiboukyuuhukinmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUKYUUHUKINMSGCD2)
    public String getZtysiboukyuuhukinmsgcd2() {
        return ztysiboukyuuhukinmsgcd2;
    }

    public void setZtysiboukyuuhukinmsgcd2(String pZtysiboukyuuhukinmsgcd2) {
        ztysiboukyuuhukinmsgcd2 = pZtysiboukyuuhukinmsgcd2;
    }

    private String ztysiboukyuuhukinmsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUKYUUHUKINMSGCD3)
    public String getZtysiboukyuuhukinmsgcd3() {
        return ztysiboukyuuhukinmsgcd3;
    }

    public void setZtysiboukyuuhukinmsgcd3(String pZtysiboukyuuhukinmsgcd3) {
        ztysiboukyuuhukinmsgcd3 = pZtysiboukyuuhukinmsgcd3;
    }

    private String ztysiboukyuuhukinmsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUKYUUHUKINMSGCD4)
    public String getZtysiboukyuuhukinmsgcd4() {
        return ztysiboukyuuhukinmsgcd4;
    }

    public void setZtysiboukyuuhukinmsgcd4(String pZtysiboukyuuhukinmsgcd4) {
        ztysiboukyuuhukinmsgcd4 = pZtysiboukyuuhukinmsgcd4;
    }

    private String ztysiboukyuuhukinmsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUKYUUHUKINMSGCD5)
    public String getZtysiboukyuuhukinmsgcd5() {
        return ztysiboukyuuhukinmsgcd5;
    }

    public void setZtysiboukyuuhukinmsgcd5(String pZtysiboukyuuhukinmsgcd5) {
        ztysiboukyuuhukinmsgcd5 = pZtysiboukyuuhukinmsgcd5;
    }

    private String ztysiboukyuuhukinmsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUKYUUHUKINMSGCD6)
    public String getZtysiboukyuuhukinmsgcd6() {
        return ztysiboukyuuhukinmsgcd6;
    }

    public void setZtysiboukyuuhukinmsgcd6(String pZtysiboukyuuhukinmsgcd6) {
        ztysiboukyuuhukinmsgcd6 = pZtysiboukyuuhukinmsgcd6;
    }

    private String ztysiboukyuuhukinmsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUKYUUHUKINMSGCD7)
    public String getZtysiboukyuuhukinmsgcd7() {
        return ztysiboukyuuhukinmsgcd7;
    }

    public void setZtysiboukyuuhukinmsgcd7(String pZtysiboukyuuhukinmsgcd7) {
        ztysiboukyuuhukinmsgcd7 = pZtysiboukyuuhukinmsgcd7;
    }

    private String ztysiboukyuuhukinmsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUKYUUHUKINMSGCD8)
    public String getZtysiboukyuuhukinmsgcd8() {
        return ztysiboukyuuhukinmsgcd8;
    }

    public void setZtysiboukyuuhukinmsgcd8(String pZtysiboukyuuhukinmsgcd8) {
        ztysiboukyuuhukinmsgcd8 = pZtysiboukyuuhukinmsgcd8;
    }

    private String ztysiboukyuuhukinmsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUKYUUHUKINMSGCD9)
    public String getZtysiboukyuuhukinmsgcd9() {
        return ztysiboukyuuhukinmsgcd9;
    }

    public void setZtysiboukyuuhukinmsgcd9(String pZtysiboukyuuhukinmsgcd9) {
        ztysiboukyuuhukinmsgcd9 = pZtysiboukyuuhukinmsgcd9;
    }

    private String ztysiboukyuuhukinmsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIBOUKYUUHUKINMSGCD10)
    public String getZtysiboukyuuhukinmsgcd10() {
        return ztysiboukyuuhukinmsgcd10;
    }

    public void setZtysiboukyuuhukinmsgcd10(String pZtysiboukyuuhukinmsgcd10) {
        ztysiboukyuuhukinmsgcd10 = pZtysiboukyuuhukinmsgcd10;
    }

    private String ztynkshrstartzenymd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYNKSHRSTARTZENYMD)
    public String getZtynkshrstartzenymd() {
        return ztynkshrstartzenymd;
    }

    public void setZtynkshrstartzenymd(String pZtynkshrstartzenymd) {
        ztynkshrstartzenymd = pZtynkshrstartzenymd;
    }

    private String ztymkhyouyennkhknhentktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYMKHYOUYENNKHKNHENTKTYPE)
    public String getZtymkhyouyennkhknhentktype() {
        return ztymkhyouyennkhknhentktype;
    }

    public void setZtymkhyouyennkhknhentktype(String pZtymkhyouyennkhknhentktype) {
        ztymkhyouyennkhknhentktype = pZtymkhyouyennkhknhentktype;
    }

    private String ztymkhyouyennkhknhentkmkhgk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYMKHYOUYENNKHKNHENTKMKHGK)
    public String getZtymkhyouyennkhknhentkmkhgk() {
        return ztymkhyouyennkhknhentkmkhgk;
    }

    public void setZtymkhyouyennkhknhentkmkhgk(String pZtymkhyouyennkhknhentkmkhgk) {
        ztymkhyouyennkhknhentkmkhgk = pZtymkhyouyennkhknhentkmkhgk;
    }

    private String ztymkhyennkhknhentkmkhwari;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYMKHYENNKHKNHENTKMKHWARI)
    public String getZtymkhyennkhknhentkmkhwari() {
        return ztymkhyennkhknhentkmkhwari;
    }

    public void setZtymkhyennkhknhentkmkhwari(String pZtymkhyennkhknhentkmkhwari) {
        ztymkhyennkhknhentkmkhwari = pZtymkhyennkhknhentkmkhwari;
    }

    private String ztyhaibunwarimsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHAIBUNWARIMSGCD1)
    public String getZtyhaibunwarimsgcd1() {
        return ztyhaibunwarimsgcd1;
    }

    public void setZtyhaibunwarimsgcd1(String pZtyhaibunwarimsgcd1) {
        ztyhaibunwarimsgcd1 = pZtyhaibunwarimsgcd1;
    }

    private String ztyhaibunwarimsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHAIBUNWARIMSGCD2)
    public String getZtyhaibunwarimsgcd2() {
        return ztyhaibunwarimsgcd2;
    }

    public void setZtyhaibunwarimsgcd2(String pZtyhaibunwarimsgcd2) {
        ztyhaibunwarimsgcd2 = pZtyhaibunwarimsgcd2;
    }

    private String ztyhaibunwarimsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHAIBUNWARIMSGCD3)
    public String getZtyhaibunwarimsgcd3() {
        return ztyhaibunwarimsgcd3;
    }

    public void setZtyhaibunwarimsgcd3(String pZtyhaibunwarimsgcd3) {
        ztyhaibunwarimsgcd3 = pZtyhaibunwarimsgcd3;
    }

    private String ztyteiritutmtthbnwr;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTEIRITUTMTTHBNWR)
    public String getZtyteiritutmtthbnwr() {
        return ztyteiritutmtthbnwr;
    }

    public void setZtyteiritutmtthbnwr(String pZtyteiritutmtthbnwr) {
        ztyteiritutmtthbnwr = pZtyteiritutmtthbnwr;
    }

    private String ztysisuutmtthbnwr;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSISUUTMTTHBNWR)
    public String getZtysisuutmtthbnwr() {
        return ztysisuutmtthbnwr;
    }

    public void setZtysisuutmtthbnwr(String pZtysisuutmtthbnwr) {
        ztysisuutmtthbnwr = pZtysisuutmtthbnwr;
    }

    private String ztysisuuannaimsg1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSISUUANNAIMSG1)
    public String getZtysisuuannaimsg1() {
        return ztysisuuannaimsg1;
    }

    public void setZtysisuuannaimsg1(String pZtysisuuannaimsg1) {
        ztysisuuannaimsg1 = pZtysisuuannaimsg1;
    }

    private String ztysisuuannaimsg2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSISUUANNAIMSG2)
    public String getZtysisuuannaimsg2() {
        return ztysisuuannaimsg2;
    }

    public void setZtysisuuannaimsg2(String pZtysisuuannaimsg2) {
        ztysisuuannaimsg2 = pZtysisuuannaimsg2;
    }

    private String ztysisuuannaimsg3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSISUUANNAIMSG3)
    public String getZtysisuuannaimsg3() {
        return ztysisuuannaimsg3;
    }

    public void setZtysisuuannaimsg3(String pZtysisuuannaimsg3) {
        ztysisuuannaimsg3 = pZtysisuuannaimsg3;
    }

    private String ztymkhyouyensysnikoumsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYMKHYOUYENSYSNIKOUMSGCD)
    public String getZtymkhyouyensysnikoumsgcd() {
        return ztymkhyouyensysnikoumsgcd;
    }

    public void setZtymkhyouyensysnikoumsgcd(String pZtymkhyouyensysnikoumsgcd) {
        ztymkhyouyensysnikoumsgcd = pZtymkhyouyensysnikoumsgcd;
    }

    private String ztymkhyouyensysnikoumsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYMKHYOUYENSYSNIKOUMSGCD2)
    public String getZtymkhyouyensysnikoumsgcd2() {
        return ztymkhyouyensysnikoumsgcd2;
    }

    public void setZtymkhyouyensysnikoumsgcd2(String pZtymkhyouyensysnikoumsgcd2) {
        ztymkhyouyensysnikoumsgcd2 = pZtymkhyouyensysnikoumsgcd2;
    }

    private String ztymkhyouyensysnikoumsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYMKHYOUYENSYSNIKOUMSGCD3)
    public String getZtymkhyouyensysnikoumsgcd3() {
        return ztymkhyouyensysnikoumsgcd3;
    }

    public void setZtymkhyouyensysnikoumsgcd3(String pZtymkhyouyensysnikoumsgcd3) {
        ztymkhyouyensysnikoumsgcd3 = pZtymkhyouyensysnikoumsgcd3;
    }

    private String ztymkhyouyensysnikougktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYMKHYOUYENSYSNIKOUGKTYPE)
    public String getZtymkhyouyensysnikougktype() {
        return ztymkhyouyensysnikougktype;
    }

    public void setZtymkhyouyensysnikougktype(String pZtymkhyouyensysnikougktype) {
        ztymkhyouyensysnikougktype = pZtymkhyouyensysnikougktype;
    }

    private String ztymkhyouyensysnikougk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYMKHYOUYENSYSNIKOUGK)
    public String getZtymkhyouyensysnikougk() {
        return ztymkhyouyensysnikougk;
    }

    public void setZtymkhyouyensysnikougk(String pZtymkhyouyensysnikougk) {
        ztymkhyouyensysnikougk = pZtymkhyouyensysnikougk;
    }

    private String ztymkhyouyensysnikouwra;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYMKHYOUYENSYSNIKOUWRA)
    public String getZtymkhyouyensysnikouwra() {
        return ztymkhyouyensysnikouwra;
    }

    public void setZtymkhyouyensysnikouwra(String pZtymkhyouyensysnikouwra) {
        ztymkhyouyensysnikouwra = pZtymkhyouyensysnikouwra;
    }

    private String ztymkhyouysysnikcurrentgk;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYMKHYOUYSYSNIKCURRENTGK)
    public String getZtymkhyouysysnikcurrentgk() {
        return ztymkhyouysysnikcurrentgk;
    }

    public void setZtymkhyouysysnikcurrentgk(String pZtymkhyouysysnikcurrentgk) {
        ztymkhyouysysnikcurrentgk = pZtymkhyouysysnikcurrentgk;
    }

    private String ztyyobiv12;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV12)
    public String getZtyyobiv12() {
        return ztyyobiv12;
    }

    public void setZtyyobiv12(String pZtyyobiv12) {
        ztyyobiv12 = pZtyyobiv12;
    }

    private String ztykaigomaehrtkykmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRTKYKMSGCD1)
    public String getZtykaigomaehrtkykmsgcd1() {
        return ztykaigomaehrtkykmsgcd1;
    }

    public void setZtykaigomaehrtkykmsgcd1(String pZtykaigomaehrtkykmsgcd1) {
        ztykaigomaehrtkykmsgcd1 = pZtykaigomaehrtkykmsgcd1;
    }

    private String ztykaigomaehrtkykmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRTKYKMSGCD2)
    public String getZtykaigomaehrtkykmsgcd2() {
        return ztykaigomaehrtkykmsgcd2;
    }

    public void setZtykaigomaehrtkykmsgcd2(String pZtykaigomaehrtkykmsgcd2) {
        ztykaigomaehrtkykmsgcd2 = pZtykaigomaehrtkykmsgcd2;
    }

    private String ztykaigomaehrtkykmsgcdst1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRTKYKMSGCDST1)
    public String getZtykaigomaehrtkykmsgcdst1() {
        return ztykaigomaehrtkykmsgcdst1;
    }

    public void setZtykaigomaehrtkykmsgcdst1(String pZtykaigomaehrtkykmsgcdst1) {
        ztykaigomaehrtkykmsgcdst1 = pZtykaigomaehrtkykmsgcdst1;
    }

    private String ztykaigomaehrtkykmsgcdst2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRTKYKMSGCDST2)
    public String getZtykaigomaehrtkykmsgcdst2() {
        return ztykaigomaehrtkykmsgcdst2;
    }

    public void setZtykaigomaehrtkykmsgcdst2(String pZtykaigomaehrtkykmsgcdst2) {
        ztykaigomaehrtkykmsgcdst2 = pZtykaigomaehrtkykmsgcdst2;
    }

    private String ztykgmaehrtkhknkkn1mnryymd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRTKHKNKKN1MNRYYMD)
    public String getZtykgmaehrtkhknkkn1mnryymd() {
        return ztykgmaehrtkhknkkn1mnryymd;
    }

    public void setZtykgmaehrtkhknkkn1mnryymd(String pZtykgmaehrtkhknkkn1mnryymd) {
        ztykgmaehrtkhknkkn1mnryymd = pZtykgmaehrtkhknkkn1mnryymd;
    }

    private String ztykaigomaehrtkykitrnumu;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRTKYKITRNUMU)
    public String getZtykaigomaehrtkykitrnumu() {
        return ztykaigomaehrtkykitrnumu;
    }

    public void setZtykaigomaehrtkykitrnumu(String pZtykaigomaehrtkykitrnumu) {
        ztykaigomaehrtkykitrnumu = pZtykaigomaehrtkykitrnumu;
    }

    private String ztykaigomaehrtkykkyktuuka;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRTKYKKYKTUUKA)
    public String getZtykaigomaehrtkykkyktuuka() {
        return ztykaigomaehrtkykkyktuuka;
    }

    public void setZtykaigomaehrtkykkyktuuka(String pZtykaigomaehrtkykkyktuuka) {
        ztykaigomaehrtkykkyktuuka = pZtykaigomaehrtkykkyktuuka;
    }

    private String ztykaigomaehrtkykstdmsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRTKYKSTDMSGCD)
    public String getZtykaigomaehrtkykstdmsgcd() {
        return ztykaigomaehrtkykstdmsgcd;
    }

    public void setZtykaigomaehrtkykstdmsgcd(String pZtykaigomaehrtkykstdmsgcd) {
        ztykaigomaehrtkykstdmsgcd = pZtykaigomaehrtkykstdmsgcd;
    }

    private String ztykaigomaehrjrugktype;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKTYPE)
    public String getZtykaigomaehrjrugktype() {
        return ztykaigomaehrjrugktype;
    }

    public void setZtykaigomaehrjrugktype(String pZtykaigomaehrjrugktype) {
        ztykaigomaehrjrugktype = pZtykaigomaehrjrugktype;
    }

    private String ztykaigomaehrsikuhhknnen01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSIKUHHKNNEN01)
    public String getZtykaigomaehrsikuhhknnen01() {
        return ztykaigomaehrsikuhhknnen01;
    }

    public void setZtykaigomaehrsikuhhknnen01(String pZtykaigomaehrsikuhhknnen01) {
        ztykaigomaehrsikuhhknnen01 = pZtykaigomaehrsikuhhknnen01;
    }

    private String ztykaigomaehrstikkn01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSTIKKN01)
    public String getZtykaigomaehrstikkn01() {
        return ztykaigomaehrstikkn01;
    }

    public void setZtykaigomaehrstikkn01(String pZtykaigomaehrstikkn01) {
        ztykaigomaehrstikkn01 = pZtykaigomaehrstikkn01;
    }

    private String ztykaigomaehrjrugk01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGK01)
    public String getZtykaigomaehrjrugk01() {
        return ztykaigomaehrjrugk01;
    }

    public void setZtykaigomaehrjrugk01(String pZtykaigomaehrjrugk01) {
        ztykaigomaehrjrugk01 = pZtykaigomaehrjrugk01;
    }

    private String ztykaigomaehrsikuhhknnen02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSIKUHHKNNEN02)
    public String getZtykaigomaehrsikuhhknnen02() {
        return ztykaigomaehrsikuhhknnen02;
    }

    public void setZtykaigomaehrsikuhhknnen02(String pZtykaigomaehrsikuhhknnen02) {
        ztykaigomaehrsikuhhknnen02 = pZtykaigomaehrsikuhhknnen02;
    }

    private String ztykaigomaehrstikkn02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSTIKKN02)
    public String getZtykaigomaehrstikkn02() {
        return ztykaigomaehrstikkn02;
    }

    public void setZtykaigomaehrstikkn02(String pZtykaigomaehrstikkn02) {
        ztykaigomaehrstikkn02 = pZtykaigomaehrstikkn02;
    }

    private String ztykaigomaehrjrugk02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGK02)
    public String getZtykaigomaehrjrugk02() {
        return ztykaigomaehrjrugk02;
    }

    public void setZtykaigomaehrjrugk02(String pZtykaigomaehrjrugk02) {
        ztykaigomaehrjrugk02 = pZtykaigomaehrjrugk02;
    }

    private String ztykaigomaehrsikuhhknnen03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSIKUHHKNNEN03)
    public String getZtykaigomaehrsikuhhknnen03() {
        return ztykaigomaehrsikuhhknnen03;
    }

    public void setZtykaigomaehrsikuhhknnen03(String pZtykaigomaehrsikuhhknnen03) {
        ztykaigomaehrsikuhhknnen03 = pZtykaigomaehrsikuhhknnen03;
    }

    private String ztykaigomaehrstikkn03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSTIKKN03)
    public String getZtykaigomaehrstikkn03() {
        return ztykaigomaehrstikkn03;
    }

    public void setZtykaigomaehrstikkn03(String pZtykaigomaehrstikkn03) {
        ztykaigomaehrstikkn03 = pZtykaigomaehrstikkn03;
    }

    private String ztykaigomaehrjrugk03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGK03)
    public String getZtykaigomaehrjrugk03() {
        return ztykaigomaehrjrugk03;
    }

    public void setZtykaigomaehrjrugk03(String pZtykaigomaehrjrugk03) {
        ztykaigomaehrjrugk03 = pZtykaigomaehrjrugk03;
    }

    private String ztykaigomaehrsikuhhknnen04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSIKUHHKNNEN04)
    public String getZtykaigomaehrsikuhhknnen04() {
        return ztykaigomaehrsikuhhknnen04;
    }

    public void setZtykaigomaehrsikuhhknnen04(String pZtykaigomaehrsikuhhknnen04) {
        ztykaigomaehrsikuhhknnen04 = pZtykaigomaehrsikuhhknnen04;
    }

    private String ztykaigomaehrstikkn04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSTIKKN04)
    public String getZtykaigomaehrstikkn04() {
        return ztykaigomaehrstikkn04;
    }

    public void setZtykaigomaehrstikkn04(String pZtykaigomaehrstikkn04) {
        ztykaigomaehrstikkn04 = pZtykaigomaehrstikkn04;
    }

    private String ztykaigomaehrjrugk04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGK04)
    public String getZtykaigomaehrjrugk04() {
        return ztykaigomaehrjrugk04;
    }

    public void setZtykaigomaehrjrugk04(String pZtykaigomaehrjrugk04) {
        ztykaigomaehrjrugk04 = pZtykaigomaehrjrugk04;
    }

    private String ztykaigomaehrsikuhhknnen05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSIKUHHKNNEN05)
    public String getZtykaigomaehrsikuhhknnen05() {
        return ztykaigomaehrsikuhhknnen05;
    }

    public void setZtykaigomaehrsikuhhknnen05(String pZtykaigomaehrsikuhhknnen05) {
        ztykaigomaehrsikuhhknnen05 = pZtykaigomaehrsikuhhknnen05;
    }

    private String ztykaigomaehrstikkn05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSTIKKN05)
    public String getZtykaigomaehrstikkn05() {
        return ztykaigomaehrstikkn05;
    }

    public void setZtykaigomaehrstikkn05(String pZtykaigomaehrstikkn05) {
        ztykaigomaehrstikkn05 = pZtykaigomaehrstikkn05;
    }

    private String ztykaigomaehrjrugk05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGK05)
    public String getZtykaigomaehrjrugk05() {
        return ztykaigomaehrjrugk05;
    }

    public void setZtykaigomaehrjrugk05(String pZtykaigomaehrjrugk05) {
        ztykaigomaehrjrugk05 = pZtykaigomaehrjrugk05;
    }

    private String ztykaigomaehrsikuhhknnen06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSIKUHHKNNEN06)
    public String getZtykaigomaehrsikuhhknnen06() {
        return ztykaigomaehrsikuhhknnen06;
    }

    public void setZtykaigomaehrsikuhhknnen06(String pZtykaigomaehrsikuhhknnen06) {
        ztykaigomaehrsikuhhknnen06 = pZtykaigomaehrsikuhhknnen06;
    }

    private String ztykaigomaehrstikkn06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSTIKKN06)
    public String getZtykaigomaehrstikkn06() {
        return ztykaigomaehrstikkn06;
    }

    public void setZtykaigomaehrstikkn06(String pZtykaigomaehrstikkn06) {
        ztykaigomaehrstikkn06 = pZtykaigomaehrstikkn06;
    }

    private String ztykaigomaehrjrugk06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGK06)
    public String getZtykaigomaehrjrugk06() {
        return ztykaigomaehrjrugk06;
    }

    public void setZtykaigomaehrjrugk06(String pZtykaigomaehrjrugk06) {
        ztykaigomaehrjrugk06 = pZtykaigomaehrjrugk06;
    }

    private String ztykaigomaehrsikuhhknnen07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSIKUHHKNNEN07)
    public String getZtykaigomaehrsikuhhknnen07() {
        return ztykaigomaehrsikuhhknnen07;
    }

    public void setZtykaigomaehrsikuhhknnen07(String pZtykaigomaehrsikuhhknnen07) {
        ztykaigomaehrsikuhhknnen07 = pZtykaigomaehrsikuhhknnen07;
    }

    private String ztykaigomaehrstikkn07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSTIKKN07)
    public String getZtykaigomaehrstikkn07() {
        return ztykaigomaehrstikkn07;
    }

    public void setZtykaigomaehrstikkn07(String pZtykaigomaehrstikkn07) {
        ztykaigomaehrstikkn07 = pZtykaigomaehrstikkn07;
    }

    private String ztykaigomaehrjrugk07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGK07)
    public String getZtykaigomaehrjrugk07() {
        return ztykaigomaehrjrugk07;
    }

    public void setZtykaigomaehrjrugk07(String pZtykaigomaehrjrugk07) {
        ztykaigomaehrjrugk07 = pZtykaigomaehrjrugk07;
    }

    private String ztykaigomaehrsikuhhknnen08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSIKUHHKNNEN08)
    public String getZtykaigomaehrsikuhhknnen08() {
        return ztykaigomaehrsikuhhknnen08;
    }

    public void setZtykaigomaehrsikuhhknnen08(String pZtykaigomaehrsikuhhknnen08) {
        ztykaigomaehrsikuhhknnen08 = pZtykaigomaehrsikuhhknnen08;
    }

    private String ztykaigomaehrstikkn08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSTIKKN08)
    public String getZtykaigomaehrstikkn08() {
        return ztykaigomaehrstikkn08;
    }

    public void setZtykaigomaehrstikkn08(String pZtykaigomaehrstikkn08) {
        ztykaigomaehrstikkn08 = pZtykaigomaehrstikkn08;
    }

    private String ztykaigomaehrjrugk08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGK08)
    public String getZtykaigomaehrjrugk08() {
        return ztykaigomaehrjrugk08;
    }

    public void setZtykaigomaehrjrugk08(String pZtykaigomaehrjrugk08) {
        ztykaigomaehrjrugk08 = pZtykaigomaehrjrugk08;
    }

    private String ztykaigomaehrsikuhhknnen09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSIKUHHKNNEN09)
    public String getZtykaigomaehrsikuhhknnen09() {
        return ztykaigomaehrsikuhhknnen09;
    }

    public void setZtykaigomaehrsikuhhknnen09(String pZtykaigomaehrsikuhhknnen09) {
        ztykaigomaehrsikuhhknnen09 = pZtykaigomaehrsikuhhknnen09;
    }

    private String ztykaigomaehrstikkn09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSTIKKN09)
    public String getZtykaigomaehrstikkn09() {
        return ztykaigomaehrstikkn09;
    }

    public void setZtykaigomaehrstikkn09(String pZtykaigomaehrstikkn09) {
        ztykaigomaehrstikkn09 = pZtykaigomaehrstikkn09;
    }

    private String ztykaigomaehrjrugk09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGK09)
    public String getZtykaigomaehrjrugk09() {
        return ztykaigomaehrjrugk09;
    }

    public void setZtykaigomaehrjrugk09(String pZtykaigomaehrjrugk09) {
        ztykaigomaehrjrugk09 = pZtykaigomaehrjrugk09;
    }

    private String ztykaigomaehrsikuhhknnen10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSIKUHHKNNEN10)
    public String getZtykaigomaehrsikuhhknnen10() {
        return ztykaigomaehrsikuhhknnen10;
    }

    public void setZtykaigomaehrsikuhhknnen10(String pZtykaigomaehrsikuhhknnen10) {
        ztykaigomaehrsikuhhknnen10 = pZtykaigomaehrsikuhhknnen10;
    }

    private String ztykaigomaehrstikkn10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRSTIKKN10)
    public String getZtykaigomaehrstikkn10() {
        return ztykaigomaehrstikkn10;
    }

    public void setZtykaigomaehrstikkn10(String pZtykaigomaehrstikkn10) {
        ztykaigomaehrstikkn10 = pZtykaigomaehrstikkn10;
    }

    private String ztykaigomaehrjrugk10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGK10)
    public String getZtykaigomaehrjrugk10() {
        return ztykaigomaehrjrugk10;
    }

    public void setZtykaigomaehrjrugk10(String pZtykaigomaehrjrugk10) {
        ztykaigomaehrjrugk10 = pZtykaigomaehrjrugk10;
    }

    private String ztykaigomaehrjrugkydaka01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKYDAKA01)
    public String getZtykaigomaehrjrugkydaka01() {
        return ztykaigomaehrjrugkydaka01;
    }

    public void setZtykaigomaehrjrugkydaka01(String pZtykaigomaehrjrugkydaka01) {
        ztykaigomaehrjrugkydaka01 = pZtykaigomaehrjrugkydaka01;
    }

    private String ztykgmaehrjrugkykijyun01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYKIJYUN01)
    public String getZtykgmaehrjrugkykijyun01() {
        return ztykgmaehrjrugkykijyun01;
    }

    public void setZtykgmaehrjrugkykijyun01(String pZtykgmaehrjrugkykijyun01) {
        ztykgmaehrjrugkykijyun01 = pZtykgmaehrjrugkykijyun01;
    }

    private String ztykgmaehrjrugkyyasu01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYYASU01)
    public String getZtykgmaehrjrugkyyasu01() {
        return ztykgmaehrjrugkyyasu01;
    }

    public void setZtykgmaehrjrugkyyasu01(String pZtykgmaehrjrugkyyasu01) {
        ztykgmaehrjrugkyyasu01 = pZtykgmaehrjrugkyyasu01;
    }

    private String ztykaigomaehrjrugkydaka02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKYDAKA02)
    public String getZtykaigomaehrjrugkydaka02() {
        return ztykaigomaehrjrugkydaka02;
    }

    public void setZtykaigomaehrjrugkydaka02(String pZtykaigomaehrjrugkydaka02) {
        ztykaigomaehrjrugkydaka02 = pZtykaigomaehrjrugkydaka02;
    }

    private String ztykgmaehrjrugkykijyun02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYKIJYUN02)
    public String getZtykgmaehrjrugkykijyun02() {
        return ztykgmaehrjrugkykijyun02;
    }

    public void setZtykgmaehrjrugkykijyun02(String pZtykgmaehrjrugkykijyun02) {
        ztykgmaehrjrugkykijyun02 = pZtykgmaehrjrugkykijyun02;
    }

    private String ztykgmaehrjrugkyyasu02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYYASU02)
    public String getZtykgmaehrjrugkyyasu02() {
        return ztykgmaehrjrugkyyasu02;
    }

    public void setZtykgmaehrjrugkyyasu02(String pZtykgmaehrjrugkyyasu02) {
        ztykgmaehrjrugkyyasu02 = pZtykgmaehrjrugkyyasu02;
    }

    private String ztykaigomaehrjrugkydaka03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKYDAKA03)
    public String getZtykaigomaehrjrugkydaka03() {
        return ztykaigomaehrjrugkydaka03;
    }

    public void setZtykaigomaehrjrugkydaka03(String pZtykaigomaehrjrugkydaka03) {
        ztykaigomaehrjrugkydaka03 = pZtykaigomaehrjrugkydaka03;
    }

    private String ztykgmaehrjrugkykijyun03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYKIJYUN03)
    public String getZtykgmaehrjrugkykijyun03() {
        return ztykgmaehrjrugkykijyun03;
    }

    public void setZtykgmaehrjrugkykijyun03(String pZtykgmaehrjrugkykijyun03) {
        ztykgmaehrjrugkykijyun03 = pZtykgmaehrjrugkykijyun03;
    }

    private String ztykgmaehrjrugkyyasu03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYYASU03)
    public String getZtykgmaehrjrugkyyasu03() {
        return ztykgmaehrjrugkyyasu03;
    }

    public void setZtykgmaehrjrugkyyasu03(String pZtykgmaehrjrugkyyasu03) {
        ztykgmaehrjrugkyyasu03 = pZtykgmaehrjrugkyyasu03;
    }

    private String ztykaigomaehrjrugkydaka04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKYDAKA04)
    public String getZtykaigomaehrjrugkydaka04() {
        return ztykaigomaehrjrugkydaka04;
    }

    public void setZtykaigomaehrjrugkydaka04(String pZtykaigomaehrjrugkydaka04) {
        ztykaigomaehrjrugkydaka04 = pZtykaigomaehrjrugkydaka04;
    }

    private String ztykgmaehrjrugkykijyun04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYKIJYUN04)
    public String getZtykgmaehrjrugkykijyun04() {
        return ztykgmaehrjrugkykijyun04;
    }

    public void setZtykgmaehrjrugkykijyun04(String pZtykgmaehrjrugkykijyun04) {
        ztykgmaehrjrugkykijyun04 = pZtykgmaehrjrugkykijyun04;
    }

    private String ztykgmaehrjrugkyyasu04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYYASU04)
    public String getZtykgmaehrjrugkyyasu04() {
        return ztykgmaehrjrugkyyasu04;
    }

    public void setZtykgmaehrjrugkyyasu04(String pZtykgmaehrjrugkyyasu04) {
        ztykgmaehrjrugkyyasu04 = pZtykgmaehrjrugkyyasu04;
    }

    private String ztykaigomaehrjrugkydaka05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKYDAKA05)
    public String getZtykaigomaehrjrugkydaka05() {
        return ztykaigomaehrjrugkydaka05;
    }

    public void setZtykaigomaehrjrugkydaka05(String pZtykaigomaehrjrugkydaka05) {
        ztykaigomaehrjrugkydaka05 = pZtykaigomaehrjrugkydaka05;
    }

    private String ztykgmaehrjrugkykijyun05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYKIJYUN05)
    public String getZtykgmaehrjrugkykijyun05() {
        return ztykgmaehrjrugkykijyun05;
    }

    public void setZtykgmaehrjrugkykijyun05(String pZtykgmaehrjrugkykijyun05) {
        ztykgmaehrjrugkykijyun05 = pZtykgmaehrjrugkykijyun05;
    }

    private String ztykgmaehrjrugkyyasu05;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYYASU05)
    public String getZtykgmaehrjrugkyyasu05() {
        return ztykgmaehrjrugkyyasu05;
    }

    public void setZtykgmaehrjrugkyyasu05(String pZtykgmaehrjrugkyyasu05) {
        ztykgmaehrjrugkyyasu05 = pZtykgmaehrjrugkyyasu05;
    }

    private String ztykaigomaehrjrugkydaka06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKYDAKA06)
    public String getZtykaigomaehrjrugkydaka06() {
        return ztykaigomaehrjrugkydaka06;
    }

    public void setZtykaigomaehrjrugkydaka06(String pZtykaigomaehrjrugkydaka06) {
        ztykaigomaehrjrugkydaka06 = pZtykaigomaehrjrugkydaka06;
    }

    private String ztykgmaehrjrugkykijyun06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYKIJYUN06)
    public String getZtykgmaehrjrugkykijyun06() {
        return ztykgmaehrjrugkykijyun06;
    }

    public void setZtykgmaehrjrugkykijyun06(String pZtykgmaehrjrugkykijyun06) {
        ztykgmaehrjrugkykijyun06 = pZtykgmaehrjrugkykijyun06;
    }

    private String ztykgmaehrjrugkyyasu06;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYYASU06)
    public String getZtykgmaehrjrugkyyasu06() {
        return ztykgmaehrjrugkyyasu06;
    }

    public void setZtykgmaehrjrugkyyasu06(String pZtykgmaehrjrugkyyasu06) {
        ztykgmaehrjrugkyyasu06 = pZtykgmaehrjrugkyyasu06;
    }

    private String ztykaigomaehrjrugkydaka07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKYDAKA07)
    public String getZtykaigomaehrjrugkydaka07() {
        return ztykaigomaehrjrugkydaka07;
    }

    public void setZtykaigomaehrjrugkydaka07(String pZtykaigomaehrjrugkydaka07) {
        ztykaigomaehrjrugkydaka07 = pZtykaigomaehrjrugkydaka07;
    }

    private String ztykgmaehrjrugkykijyun07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYKIJYUN07)
    public String getZtykgmaehrjrugkykijyun07() {
        return ztykgmaehrjrugkykijyun07;
    }

    public void setZtykgmaehrjrugkykijyun07(String pZtykgmaehrjrugkykijyun07) {
        ztykgmaehrjrugkykijyun07 = pZtykgmaehrjrugkykijyun07;
    }

    private String ztykgmaehrjrugkyyasu07;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYYASU07)
    public String getZtykgmaehrjrugkyyasu07() {
        return ztykgmaehrjrugkyyasu07;
    }

    public void setZtykgmaehrjrugkyyasu07(String pZtykgmaehrjrugkyyasu07) {
        ztykgmaehrjrugkyyasu07 = pZtykgmaehrjrugkyyasu07;
    }

    private String ztykaigomaehrjrugkydaka08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKYDAKA08)
    public String getZtykaigomaehrjrugkydaka08() {
        return ztykaigomaehrjrugkydaka08;
    }

    public void setZtykaigomaehrjrugkydaka08(String pZtykaigomaehrjrugkydaka08) {
        ztykaigomaehrjrugkydaka08 = pZtykaigomaehrjrugkydaka08;
    }

    private String ztykgmaehrjrugkykijyun08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYKIJYUN08)
    public String getZtykgmaehrjrugkykijyun08() {
        return ztykgmaehrjrugkykijyun08;
    }

    public void setZtykgmaehrjrugkykijyun08(String pZtykgmaehrjrugkykijyun08) {
        ztykgmaehrjrugkykijyun08 = pZtykgmaehrjrugkykijyun08;
    }

    private String ztykgmaehrjrugkyyasu08;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYYASU08)
    public String getZtykgmaehrjrugkyyasu08() {
        return ztykgmaehrjrugkyyasu08;
    }

    public void setZtykgmaehrjrugkyyasu08(String pZtykgmaehrjrugkyyasu08) {
        ztykgmaehrjrugkyyasu08 = pZtykgmaehrjrugkyyasu08;
    }

    private String ztykaigomaehrjrugkydaka09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKYDAKA09)
    public String getZtykaigomaehrjrugkydaka09() {
        return ztykaigomaehrjrugkydaka09;
    }

    public void setZtykaigomaehrjrugkydaka09(String pZtykaigomaehrjrugkydaka09) {
        ztykaigomaehrjrugkydaka09 = pZtykaigomaehrjrugkydaka09;
    }

    private String ztykgmaehrjrugkykijyun09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYKIJYUN09)
    public String getZtykgmaehrjrugkykijyun09() {
        return ztykgmaehrjrugkykijyun09;
    }

    public void setZtykgmaehrjrugkykijyun09(String pZtykgmaehrjrugkykijyun09) {
        ztykgmaehrjrugkykijyun09 = pZtykgmaehrjrugkykijyun09;
    }

    private String ztykgmaehrjrugkyyasu09;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYYASU09)
    public String getZtykgmaehrjrugkyyasu09() {
        return ztykgmaehrjrugkyyasu09;
    }

    public void setZtykgmaehrjrugkyyasu09(String pZtykgmaehrjrugkyyasu09) {
        ztykgmaehrjrugkyyasu09 = pZtykgmaehrjrugkyyasu09;
    }

    private String ztykaigomaehrjrugkydaka10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKAIGOMAEHRJRUGKYDAKA10)
    public String getZtykaigomaehrjrugkydaka10() {
        return ztykaigomaehrjrugkydaka10;
    }

    public void setZtykaigomaehrjrugkydaka10(String pZtykaigomaehrjrugkydaka10) {
        ztykaigomaehrjrugkydaka10 = pZtykaigomaehrjrugkydaka10;
    }

    private String ztykgmaehrjrugkykijyun10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYKIJYUN10)
    public String getZtykgmaehrjrugkykijyun10() {
        return ztykgmaehrjrugkykijyun10;
    }

    public void setZtykgmaehrjrugkykijyun10(String pZtykgmaehrjrugkykijyun10) {
        ztykgmaehrjrugkykijyun10 = pZtykgmaehrjrugkykijyun10;
    }

    private String ztykgmaehrjrugkyyasu10;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKGMAEHRJRUGKYYASU10)
    public String getZtykgmaehrjrugkyyasu10() {
        return ztykgmaehrjrugkyyasu10;
    }

    public void setZtykgmaehrjrugkyyasu10(String pZtykgmaehrjrugkyyasu10) {
        ztykgmaehrjrugkyyasu10 = pZtykgmaehrjrugkyyasu10;
    }

    private String ztykzktourokuservicemsg1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKZKTOUROKUSERVICEMSG1)
    public String getZtykzktourokuservicemsg1() {
        return ztykzktourokuservicemsg1;
    }

    public void setZtykzktourokuservicemsg1(String pZtykzktourokuservicemsg1) {
        ztykzktourokuservicemsg1 = pZtykzktourokuservicemsg1;
    }

    private String ztykzktourokuservicemsg2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKZKTOUROKUSERVICEMSG2)
    public String getZtykzktourokuservicemsg2() {
        return ztykzktourokuservicemsg2;
    }

    public void setZtykzktourokuservicemsg2(String pZtykzktourokuservicemsg2) {
        ztykzktourokuservicemsg2 = pZtykzktourokuservicemsg2;
    }

    private String ztykzktourokuservicemsg3;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKZKTOUROKUSERVICEMSG3)
    public String getZtykzktourokuservicemsg3() {
        return ztykzktourokuservicemsg3;
    }

    public void setZtykzktourokuservicemsg3(String pZtykzktourokuservicemsg3) {
        ztykzktourokuservicemsg3 = pZtykzktourokuservicemsg3;
    }

    private String ztykzktourokuservicemsg4;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKZKTOUROKUSERVICEMSG4)
    public String getZtykzktourokuservicemsg4() {
        return ztykzktourokuservicemsg4;
    }

    public void setZtykzktourokuservicemsg4(String pZtykzktourokuservicemsg4) {
        ztykzktourokuservicemsg4 = pZtykzktourokuservicemsg4;
    }

    private String ztykzktourokuservicemsg5;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKZKTOUROKUSERVICEMSG5)
    public String getZtykzktourokuservicemsg5() {
        return ztykzktourokuservicemsg5;
    }

    public void setZtykzktourokuservicemsg5(String pZtykzktourokuservicemsg5) {
        ztykzktourokuservicemsg5 = pZtykzktourokuservicemsg5;
    }

    private String ztykzktourokuservicemsg6;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKZKTOUROKUSERVICEMSG6)
    public String getZtykzktourokuservicemsg6() {
        return ztykzktourokuservicemsg6;
    }

    public void setZtykzktourokuservicemsg6(String pZtykzktourokuservicemsg6) {
        ztykzktourokuservicemsg6 = pZtykzktourokuservicemsg6;
    }

    private String ztykzktourokuservicemsg7;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKZKTOUROKUSERVICEMSG7)
    public String getZtykzktourokuservicemsg7() {
        return ztykzktourokuservicemsg7;
    }

    public void setZtykzktourokuservicemsg7(String pZtykzktourokuservicemsg7) {
        ztykzktourokuservicemsg7 = pZtykzktourokuservicemsg7;
    }

    private String ztykzktourokuservicemsg8;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKZKTOUROKUSERVICEMSG8)
    public String getZtykzktourokuservicemsg8() {
        return ztykzktourokuservicemsg8;
    }

    public void setZtykzktourokuservicemsg8(String pZtykzktourokuservicemsg8) {
        ztykzktourokuservicemsg8 = pZtykzktourokuservicemsg8;
    }

    private String ztytrkkzknm118;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKNM118)
    public String getZtytrkkzknm118() {
        return ztytrkkzknm118;
    }

    public void setZtytrkkzknm118(String pZtytrkkzknm118) {
        ztytrkkzknm118 = pZtytrkkzknm118;
    }

    private String ztytrkkzksei1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKSEI1)
    public String getZtytrkkzksei1() {
        return ztytrkkzksei1;
    }

    public void setZtytrkkzksei1(String pZtytrkkzksei1) {
        ztytrkkzksei1 = pZtytrkkzksei1;
    }

    private String ztytrkkzkseiymd1zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKSEIYMD1ZENKAKU)
    public String getZtytrkkzkseiymd1zenkaku() {
        return ztytrkkzkseiymd1zenkaku;
    }

    public void setZtytrkkzkseiymd1zenkaku(String pZtytrkkzkseiymd1zenkaku) {
        ztytrkkzkseiymd1zenkaku = pZtytrkkzkseiymd1zenkaku;
    }

    private String ztytrkkzkyno1zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKYNO1ZENKAKU)
    public String getZtytrkkzkyno1zenkaku() {
        return ztytrkkzkyno1zenkaku;
    }

    public void setZtytrkkzkyno1zenkaku(String pZtytrkkzkyno1zenkaku) {
        ztytrkkzkyno1zenkaku = pZtytrkkzkyno1zenkaku;
    }

    private String ztytrkkzkadrkj1;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKADRKJ1)
    public String getZtytrkkzkadrkj1() {
        return ztytrkkzkadrkj1;
    }

    public void setZtytrkkzkadrkj1(String pZtytrkkzkadrkj1) {
        ztytrkkzkadrkj1 = pZtytrkkzkadrkj1;
    }

    private String ztytrkkzktelno1zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKTELNO1ZENKAKU)
    public String getZtytrkkzktelno1zenkaku() {
        return ztytrkkzktelno1zenkaku;
    }

    public void setZtytrkkzktelno1zenkaku(String pZtytrkkzktelno1zenkaku) {
        ztytrkkzktelno1zenkaku = pZtytrkkzktelno1zenkaku;
    }

    private String ztytrkkzknm218;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKNM218)
    public String getZtytrkkzknm218() {
        return ztytrkkzknm218;
    }

    public void setZtytrkkzknm218(String pZtytrkkzknm218) {
        ztytrkkzknm218 = pZtytrkkzknm218;
    }

    private String ztytrkkzksei2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKSEI2)
    public String getZtytrkkzksei2() {
        return ztytrkkzksei2;
    }

    public void setZtytrkkzksei2(String pZtytrkkzksei2) {
        ztytrkkzksei2 = pZtytrkkzksei2;
    }

    private String ztytrkkzkseiymd2zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKSEIYMD2ZENKAKU)
    public String getZtytrkkzkseiymd2zenkaku() {
        return ztytrkkzkseiymd2zenkaku;
    }

    public void setZtytrkkzkseiymd2zenkaku(String pZtytrkkzkseiymd2zenkaku) {
        ztytrkkzkseiymd2zenkaku = pZtytrkkzkseiymd2zenkaku;
    }

    private String ztytrkkzkyno2zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKYNO2ZENKAKU)
    public String getZtytrkkzkyno2zenkaku() {
        return ztytrkkzkyno2zenkaku;
    }

    public void setZtytrkkzkyno2zenkaku(String pZtytrkkzkyno2zenkaku) {
        ztytrkkzkyno2zenkaku = pZtytrkkzkyno2zenkaku;
    }

    private String ztytrkkzkadrkj2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKADRKJ2)
    public String getZtytrkkzkadrkj2() {
        return ztytrkkzkadrkj2;
    }

    public void setZtytrkkzkadrkj2(String pZtytrkkzkadrkj2) {
        ztytrkkzkadrkj2 = pZtytrkkzkadrkj2;
    }

    private String ztytrkkzktelno2zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYTRKKZKTELNO2ZENKAKU)
    public String getZtytrkkzktelno2zenkaku() {
        return ztytrkkzktelno2zenkaku;
    }

    public void setZtytrkkzktelno2zenkaku(String pZtytrkkzktelno2zenkaku) {
        ztytrkkzktelno2zenkaku = pZtytrkkzktelno2zenkaku;
    }

    private String ztykykdairinm18;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYKYKDAIRINM18)
    public String getZtykykdairinm18() {
        return ztykykdairinm18;
    }

    public void setZtykykdairinm18(String pZtykykdairinm18) {
        ztykykdairinm18 = pZtykykdairinm18;
    }

    private String ztyhhkndairinm;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHHKNDAIRINM)
    public String getZtyhhkndairinm() {
        return ztyhhkndairinm;
    }

    public void setZtyhhkndairinm(String pZtyhhkndairinm) {
        ztyhhkndairinm = pZtyhhkndairinm;
    }

    private String ztyyobiv100;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV100)
    public String getZtyyobiv100() {
        return ztyyobiv100;
    }

    public void setZtyyobiv100(String pZtyyobiv100) {
        ztyyobiv100 = pZtyyobiv100;
    }

    private String ztyhutanhiyustmmsgcdue01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMMSGCDUE01)
    public String getZtyhutanhiyustmmsgcdue01() {
        return ztyhutanhiyustmmsgcdue01;
    }

    public void setZtyhutanhiyustmmsgcdue01(String pZtyhutanhiyustmmsgcdue01) {
        ztyhutanhiyustmmsgcdue01 = pZtyhutanhiyustmmsgcdue01;
    }

    private String ztyhutanhiyustmmsgcdue02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMMSGCDUE02)
    public String getZtyhutanhiyustmmsgcdue02() {
        return ztyhutanhiyustmmsgcdue02;
    }

    public void setZtyhutanhiyustmmsgcdue02(String pZtyhutanhiyustmmsgcdue02) {
        ztyhutanhiyustmmsgcdue02 = pZtyhutanhiyustmmsgcdue02;
    }

    private String ztyhutanhiyustmmsgcdue03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMMSGCDUE03)
    public String getZtyhutanhiyustmmsgcdue03() {
        return ztyhutanhiyustmmsgcdue03;
    }

    public void setZtyhutanhiyustmmsgcdue03(String pZtyhutanhiyustmmsgcdue03) {
        ztyhutanhiyustmmsgcdue03 = pZtyhutanhiyustmmsgcdue03;
    }

    private String ztyhutanhiyustmmsgcdue04;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMMSGCDUE04)
    public String getZtyhutanhiyustmmsgcdue04() {
        return ztyhutanhiyustmmsgcdue04;
    }

    public void setZtyhutanhiyustmmsgcdue04(String pZtyhutanhiyustmmsgcdue04) {
        ztyhutanhiyustmmsgcdue04 = pZtyhutanhiyustmmsgcdue04;
    }

    private String ztyhutanhiyustmknsnhyuptn;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMKNSNHYUPTN)
    public String getZtyhutanhiyustmknsnhyuptn() {
        return ztyhutanhiyustmknsnhyuptn;
    }

    public void setZtyhutanhiyustmknsnhyuptn(String pZtyhutanhiyustmknsnhyuptn) {
        ztyhutanhiyustmknsnhyuptn = pZtyhutanhiyustmknsnhyuptn;
    }

    private String ztyhutanhiyustmmsgcdst01;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMMSGCDST01)
    public String getZtyhutanhiyustmmsgcdst01() {
        return ztyhutanhiyustmmsgcdst01;
    }

    public void setZtyhutanhiyustmmsgcdst01(String pZtyhutanhiyustmmsgcdst01) {
        ztyhutanhiyustmmsgcdst01 = pZtyhutanhiyustmmsgcdst01;
    }

    private String ztyhutanhiyustmmsgcdst02;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMMSGCDST02)
    public String getZtyhutanhiyustmmsgcdst02() {
        return ztyhutanhiyustmmsgcdst02;
    }

    public void setZtyhutanhiyustmmsgcdst02(String pZtyhutanhiyustmmsgcdst02) {
        ztyhutanhiyustmmsgcdst02 = pZtyhutanhiyustmmsgcdst02;
    }

    private String ztyhutanhiyustmmsgcdst03;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMMSGCDST03)
    public String getZtyhutanhiyustmmsgcdst03() {
        return ztyhutanhiyustmmsgcdst03;
    }

    public void setZtyhutanhiyustmmsgcdst03(String pZtyhutanhiyustmmsgcdst03) {
        ztyhutanhiyustmmsgcdst03 = pZtyhutanhiyustmmsgcdst03;
    }

    private String ztyhutanhiyustmytijihiritu;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMYTIJIHIRITU)
    public String getZtyhutanhiyustmytijihiritu() {
        return ztyhutanhiyustmytijihiritu;
    }

    @DataConvert("toMultiByte")
    public void setZtyhutanhiyustmytijihiritu(String pZtyhutanhiyustmytijihiritu) {
        ztyhutanhiyustmytijihiritu = pZtyhutanhiyustmytijihiritu;
    }

    private String ztyhutanhiyustmkyakkjrtmin;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMKYAKKJRTMIN)
    public String getZtyhutanhiyustmkyakkjrtmin() {
        return ztyhutanhiyustmkyakkjrtmin;
    }

    public void setZtyhutanhiyustmkyakkjrtmin(String pZtyhutanhiyustmkyakkjrtmin) {
        ztyhutanhiyustmkyakkjrtmin = pZtyhutanhiyustmkyakkjrtmin;
    }

    private String ztyhutanhiyustmkyakkjrtmax;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYHUTANHIYUSTMKYAKKJRTMAX)
    public String getZtyhutanhiyustmkyakkjrtmax() {
        return ztyhutanhiyustmkyakkjrtmax;
    }

    public void setZtyhutanhiyustmkyakkjrtmax(String pZtyhutanhiyustmkyakkjrtmax) {
        ztyhutanhiyustmkyakkjrtmax = pZtyhutanhiyustmkyakkjrtmax;
    }

    private String ztyyobiv7x2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV7X2)
    public String getZtyyobiv7x2() {
        return ztyyobiv7x2;
    }

    public void setZtyyobiv7x2(String pZtyyobiv7x2) {
        ztyyobiv7x2 = pZtyyobiv7x2;
    }

    private String ztystdstmmsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSTDSTMMSGCD)
    public String getZtystdstmmsgcd() {
        return ztystdstmmsgcd;
    }

    public void setZtystdstmmsgcd(String pZtystdstmmsgcd) {
        ztystdstmmsgcd = pZtystdstmmsgcd;
    }

    private String ztysioriwebuktriannaimsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYSIORIWEBUKTRIANNAIMSGCD)
    public String getZtysioriwebuktriannaimsgcd() {
        return ztysioriwebuktriannaimsgcd;
    }

    public void setZtysioriwebuktriannaimsgcd(String pZtysioriwebuktriannaimsgcd) {
        ztysioriwebuktriannaimsgcd = pZtysioriwebuktriannaimsgcd;
    }

    private String ztyyobiv10x2;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV10X2)
    public String getZtyyobiv10x2() {
        return ztyyobiv10x2;
    }

    public void setZtyyobiv10x2(String pZtyyobiv10x2) {
        ztyyobiv10x2 = pZtyyobiv10x2;
    }

    private String ztyyobiv69;

    @Column(name=GenZT_SaihakkouHokensyoukenTy.ZTYYOBIV69)
    public String getZtyyobiv69() {
        return ztyyobiv69;
    }

    public void setZtyyobiv69(String pZtyyobiv69) {
        ztyyobiv69 = pZtyyobiv69;
    }
}