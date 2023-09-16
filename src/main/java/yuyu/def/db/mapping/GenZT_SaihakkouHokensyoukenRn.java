package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SaihakkouHokensyoukenRn;
import yuyu.def.db.id.PKZT_SaihakkouHokensyoukenRn;
import yuyu.def.db.meta.GenQZT_SaihakkouHokensyoukenRn;
import yuyu.def.db.meta.QZT_SaihakkouHokensyoukenRn;

/**
 * 再発行保険証券Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SaihakkouHokensyoukenRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SaihakkouHokensyoukenRn}</td><td colspan="3">再発行保険証券Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_SaihakkouHokensyoukenRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_SaihakkouHokensyoukenRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanryoutuutidouhuukbn zrnkanryoutuutidouhuukbn}</td><td>（連携用）完了通知同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdrsktirasidouhuukbn zrnstdrsktirasidouhuukbn}</td><td>（連携用）被保険者代理人チラシ同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaisyoumeikbn zrnaisyoumeikbn}</td><td>（連携用）愛称名区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsagyoukbn zrnsagyoukbn}</td><td>（連携用）作業区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakkanbunsyono zrnyakkanbunsyono}</td><td>（連携用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv23x2 zrnyobiv23x2}</td><td>（連携用）予備項目Ｖ２３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd1 zrnhyoujiranhidarimsgcd1}</td><td>（連携用）表示欄左メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd2 zrnhyoujiranhidarimsgcd2}</td><td>（連携用）表示欄左メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd3 zrnhyoujiranhidarimsgcd3}</td><td>（連携用）表示欄左メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd4 zrnhyoujiranhidarimsgcd4}</td><td>（連携用）表示欄左メッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd5 zrnhyoujiranhidarimsgcd5}</td><td>（連携用）表示欄左メッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd6 zrnhyoujiranhidarimsgcd6}</td><td>（連携用）表示欄左メッセージコード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd7 zrnhyoujiranhidarimsgcd7}</td><td>（連携用）表示欄左メッセージコード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd8 zrnhyoujiranhidarimsgcd8}</td><td>（連携用）表示欄左メッセージコード８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd9 zrnhyoujiranhidarimsgcd9}</td><td>（連携用）表示欄左メッセージコード９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd10 zrnhyoujiranhidarimsgcd10}</td><td>（連携用）表示欄左メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd11 zrnhyoujiranhidarimsgcd11}</td><td>（連携用）表示欄左メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd12 zrnhyoujiranhidarimsgcd12}</td><td>（連携用）表示欄左メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd13 zrnhyoujiranhidarimsgcd13}</td><td>（連携用）表示欄左メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd14 zrnhyoujiranhidarimsgcd14}</td><td>（連携用）表示欄左メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd15 zrnhyoujiranhidarimsgcd15}</td><td>（連携用）表示欄左メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd16 zrnhyoujiranhidarimsgcd16}</td><td>（連携用）表示欄左メッセージコード１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd17 zrnhyoujiranhidarimsgcd17}</td><td>（連携用）表示欄左メッセージコード１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd18 zrnhyoujiranhidarimsgcd18}</td><td>（連携用）表示欄左メッセージコード１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd19 zrnhyoujiranhidarimsgcd19}</td><td>（連携用）表示欄左メッセージコード１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranhidarimsgcd20 zrnhyoujiranhidarimsgcd20}</td><td>（連携用）表示欄左メッセージコード２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd1 zrnhyoujiranmigimsgcd1}</td><td>（連携用）表示欄右メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd2 zrnhyoujiranmigimsgcd2}</td><td>（連携用）表示欄右メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd3 zrnhyoujiranmigimsgcd3}</td><td>（連携用）表示欄右メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd4 zrnhyoujiranmigimsgcd4}</td><td>（連携用）表示欄右メッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd5 zrnhyoujiranmigimsgcd5}</td><td>（連携用）表示欄右メッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd6 zrnhyoujiranmigimsgcd6}</td><td>（連携用）表示欄右メッセージコード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd7 zrnhyoujiranmigimsgcd7}</td><td>（連携用）表示欄右メッセージコード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd8 zrnhyoujiranmigimsgcd8}</td><td>（連携用）表示欄右メッセージコード８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd9 zrnhyoujiranmigimsgcd9}</td><td>（連携用）表示欄右メッセージコード９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd10 zrnhyoujiranmigimsgcd10}</td><td>（連携用）表示欄右メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd11 zrnhyoujiranmigimsgcd11}</td><td>（連携用）表示欄右メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd12 zrnhyoujiranmigimsgcd12}</td><td>（連携用）表示欄右メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd13 zrnhyoujiranmigimsgcd13}</td><td>（連携用）表示欄右メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd14 zrnhyoujiranmigimsgcd14}</td><td>（連携用）表示欄右メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd15 zrnhyoujiranmigimsgcd15}</td><td>（連携用）表示欄右メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd16 zrnhyoujiranmigimsgcd16}</td><td>（連携用）表示欄右メッセージコード１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd17 zrnhyoujiranmigimsgcd17}</td><td>（連携用）表示欄右メッセージコード１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd18 zrnhyoujiranmigimsgcd18}</td><td>（連携用）表示欄右メッセージコード１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd19 zrnhyoujiranmigimsgcd19}</td><td>（連携用）表示欄右メッセージコード１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranmigimsgcd20 zrnhyoujiranmigimsgcd20}</td><td>（連携用）表示欄右メッセージコード２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsknnkaisiymdseireki zrnsknnkaisiymdseireki}</td><td>（連携用）責任開始日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiranytirrt zrnhyoujiranytirrt}</td><td>（連携用）表示欄予定利率</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiransjkkktusirrt zrnhyoujiransjkkktusirrt}</td><td>（連携用）表示欄市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujirantumitateriritu zrnhyoujirantumitateriritu}</td><td>（連携用）表示欄積立利率</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujirantumitateriritu2 zrnhyoujirantumitateriritu2}</td><td>（連携用）表示欄積立利率２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujirantmttknzkrtjygn zrnhyoujirantmttknzkrtjygn}</td><td>（連携用）表示欄積立金増加率の上限</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyoujiransetteibairitu zrnhyoujiransetteibairitu}</td><td>（連携用）表示欄設定倍率</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22x11 zrnyobiv22x11}</td><td>（連携用）予備項目Ｖ２２＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoukenhakkouymd zrnsyoukenhakkouymd}</td><td>（連携用）証券発行年月日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouryokukaisimsg zrnkouryokukaisimsg}</td><td>（連携用）効力開始メッセージ</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisikihknnmsyouken zrnseisikihknnmsyouken}</td><td>（連携用）正式保険名称（証券）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruinmsyouken zrnnksyuruinmsyouken}</td><td>（連携用）年金種類名称（証券用）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv116 zrnyobiv116}</td><td>（連携用）予備項目Ｖ１１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj zrnkyknmkj}</td><td>（連携用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihknsyaseiymdwareki zrnhihknsyaseiymdwareki}</td><td>（連携用）被保険者生年月日（和暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsei zrnhhknsei}</td><td>（連携用）被保険者性別</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2 zrnhhknnen2}</td><td>（連携用）被保険者年齢Ｃ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn1 zrnuktmidasikbn1}</td><td>（連携用）受取人見出し区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn1 zrnuktkbn1}</td><td>（連携用）受取人区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm1 zrnuktnm1}</td><td>（連携用）受取人名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktbnwari1 zrnuktbnwari1}</td><td>（連携用）受取人分割割合１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn2 zrnuktmidasikbn2}</td><td>（連携用）受取人見出し区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn2 zrnuktkbn2}</td><td>（連携用）受取人区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm2 zrnuktnm2}</td><td>（連携用）受取人名２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktbnwari2 zrnuktbnwari2}</td><td>（連携用）受取人分割割合２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn3 zrnuktmidasikbn3}</td><td>（連携用）受取人見出し区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn3 zrnuktkbn3}</td><td>（連携用）受取人区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm3 zrnuktnm3}</td><td>（連携用）受取人名３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktbnwari3 zrnuktbnwari3}</td><td>（連携用）受取人分割割合３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn4 zrnuktmidasikbn4}</td><td>（連携用）受取人見出し区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn4 zrnuktkbn4}</td><td>（連携用）受取人区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm4 zrnuktnm4}</td><td>（連携用）受取人名４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktbnwari4 zrnuktbnwari4}</td><td>（連携用）受取人分割割合４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn5 zrnuktmidasikbn5}</td><td>（連携用）受取人見出し区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn5 zrnuktkbn5}</td><td>（連携用）受取人区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm5 zrnuktnm5}</td><td>（連携用）受取人名５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktbnwari5 zrnuktbnwari5}</td><td>（連携用）受取人分割割合５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn6 zrnuktmidasikbn6}</td><td>（連携用）受取人見出し区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn6 zrnuktkbn6}</td><td>（連携用）受取人区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm6 zrnuktnm6}</td><td>（連携用）受取人名６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktbnwari6 zrnuktbnwari6}</td><td>（連携用）受取人分割割合６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn7 zrnuktmidasikbn7}</td><td>（連携用）受取人見出し区分７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn7 zrnuktkbn7}</td><td>（連携用）受取人区分７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm7 zrnuktnm7}</td><td>（連携用）受取人名７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktbnwari7 zrnuktbnwari7}</td><td>（連携用）受取人分割割合７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn8 zrnuktmidasikbn8}</td><td>（連携用）受取人見出し区分８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn8 zrnuktkbn8}</td><td>（連携用）受取人区分８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm8 zrnuktnm8}</td><td>（連携用）受取人名８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktbnwari8 zrnuktbnwari8}</td><td>（連携用）受取人分割割合８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn9 zrnuktmidasikbn9}</td><td>（連携用）受取人見出し区分９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn9 zrnuktkbn9}</td><td>（連携用）受取人区分９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm9 zrnuktnm9}</td><td>（連携用）受取人名９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktbnwari9 zrnuktbnwari9}</td><td>（連携用）受取人分割割合９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktmidasikbn10 zrnuktmidasikbn10}</td><td>（連携用）受取人見出し区分１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktkbn10 zrnuktkbn10}</td><td>（連携用）受取人区分１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktnm10 zrnuktnm10}</td><td>（連携用）受取人名１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnuktbnwari10 zrnuktbnwari10}</td><td>（連携用）受取人分割割合１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv45 zrnyobiv45}</td><td>（連携用）予備項目Ｖ４５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmsgcd1 zrnpmsgcd1}</td><td>（連携用）保険料メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmsgcd2 zrnpmsgcd2}</td><td>（連携用）保険料メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmsgcd3 zrnpmsgcd3}</td><td>（連携用）保険料メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10 zrnyobiv10}</td><td>（連携用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptuukatype zrnptuukatype}</td><td>（連携用）保険料金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpkngk zrnpkngk}</td><td>（連携用）保険料金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpkngktuuka zrnpkngktuuka}</td><td>（連携用）保険料金額通貨</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikiikkatubaraitukisuu zrnteikiikkatubaraitukisuu}</td><td>（連携用）定期一括払月数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnztikiktbriyhrkgktuktype zrnztikiktbriyhrkgktuktype}</td><td>（連携用）前納定期一括払円貨払込額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnznntikiktbriyenhrkgk zrnznntikiktbriyenhrkgk}</td><td>（連携用）前納定期一括払円貨払込額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnznnkai zrnznnkai}</td><td>（連携用）前納回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnptokuyakumsgcd zrnptokuyakumsgcd}</td><td>（連携用）保険料特約メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntikiktbriyhrkgktuktype zrntikiktbriyhrkgktuktype}</td><td>（連携用）定期一括払円貨払込額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntikiktbriyenhrkgk zrntikiktbriyenhrkgk}</td><td>（連携用）定期一括払円貨払込額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv32 zrnyobiv32}</td><td>（連携用）予備項目Ｖ３２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymdseireki zrnkykymdseireki}</td><td>（連携用）契約年月日（西暦）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkknmidasikbn zrnphrkkknmidasikbn}</td><td>（連携用）保険料払込期間見出し区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkknmsgkbn zrnhrkkknmsgkbn}</td><td>（連携用）払込期間メッセージ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuumsgkbn zrnhrkkaisuumsgkbn}</td><td>（連携用）払込回数メッセージ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkktuki zrnphrkktuki}</td><td>（連携用）保険料払込期月</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkhouhoumsgkbn zrnhrkhouhoumsgkbn}</td><td>（連携用）払込方法メッセージ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv18 zrnyobiv18}</td><td>（連携用）予備項目Ｖ１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykrenban1 zrnsyukyktkykrenban1}</td><td>（連携用）主契約特約連番１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykmsgkbn1 zrnsyukyktkykmsgkbn1}</td><td>（連携用）主契約特約メッセージ区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkyksmsgkbn1 zrnsyukyktkyksmsgkbn1}</td><td>（連携用）主契約特約保険金額メッセージ区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkknmsgkbn1 zrnsyukyktkykhknkknmsgkbn1}</td><td>（連携用）主契約特約保険期間メッセージ区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykstuukatype1 zrnsyukyktkykstuukatype1}</td><td>（連携用）主契約特約保険金額通貨タイプ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkngk1 zrnsyukyktkykhknkngk1}</td><td>（連携用）主契約特約保険金額１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai1hknkknymdto1 zrnsyutkdai1hknkknymdto1}</td><td>（連携用）主契約特約第１保険期間年月日（至）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai2hknkknymdto1 zrnsyutkdai2hknkknymdto1}</td><td>（連携用）主契約特約第２保険期間年月日（至）１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22 zrnyobiv22}</td><td>（連携用）予備項目Ｖ２２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykrenban2 zrnsyukyktkykrenban2}</td><td>（連携用）主契約特約連番２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykmsgkbn2 zrnsyukyktkykmsgkbn2}</td><td>（連携用）主契約特約メッセージ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkyksmsgkbn2 zrnsyukyktkyksmsgkbn2}</td><td>（連携用）主契約特約保険金額メッセージ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkknmsgkbn2 zrnsyukyktkykhknkknmsgkbn2}</td><td>（連携用）主契約特約保険期間メッセージ区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykstuukatype2 zrnsyukyktkykstuukatype2}</td><td>（連携用）主契約特約保険金額通貨タイプ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkngk2 zrnsyukyktkykhknkngk2}</td><td>（連携用）主契約特約保険金額２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai1hknkknymdto2 zrnsyutkdai1hknkknymdto2}</td><td>（連携用）主契約特約第１保険期間年月日（至）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai2hknkknymdto2 zrnsyutkdai2hknkknymdto2}</td><td>（連携用）主契約特約第２保険期間年月日（至）２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22x2 zrnyobiv22x2}</td><td>（連携用）予備項目Ｖ２２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykrenban3 zrnsyukyktkykrenban3}</td><td>（連携用）主契約特約連番３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykmsgkbn3 zrnsyukyktkykmsgkbn3}</td><td>（連携用）主契約特約メッセージ区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkyksmsgkbn3 zrnsyukyktkyksmsgkbn3}</td><td>（連携用）主契約特約保険金額メッセージ区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkknmsgkbn3 zrnsyukyktkykhknkknmsgkbn3}</td><td>（連携用）主契約特約保険期間メッセージ区分３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykstuukatype3 zrnsyukyktkykstuukatype3}</td><td>（連携用）主契約特約保険金額通貨タイプ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkngk3 zrnsyukyktkykhknkngk3}</td><td>（連携用）主契約特約保険金額３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai1hknkknymdto3 zrnsyutkdai1hknkknymdto3}</td><td>（連携用）主契約特約第１保険期間年月日（至）３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai2hknkknymdto3 zrnsyutkdai2hknkknymdto3}</td><td>（連携用）主契約特約第２保険期間年月日（至）３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22x3 zrnyobiv22x3}</td><td>（連携用）予備項目Ｖ２２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykrenban4 zrnsyukyktkykrenban4}</td><td>（連携用）主契約特約連番４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykmsgkbn4 zrnsyukyktkykmsgkbn4}</td><td>（連携用）主契約特約メッセージ区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkyksmsgkbn4 zrnsyukyktkyksmsgkbn4}</td><td>（連携用）主契約特約保険金額メッセージ区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkknmsgkbn4 zrnsyukyktkykhknkknmsgkbn4}</td><td>（連携用）主契約特約保険期間メッセージ区分４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykstuukatype4 zrnsyukyktkykstuukatype4}</td><td>（連携用）主契約特約保険金額通貨タイプ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkngk4 zrnsyukyktkykhknkngk4}</td><td>（連携用）主契約特約保険金額４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai1hknkknymdto4 zrnsyutkdai1hknkknymdto4}</td><td>（連携用）主契約特約第１保険期間年月日（至）４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai2hknkknymdto4 zrnsyutkdai2hknkknymdto4}</td><td>（連携用）主契約特約第２保険期間年月日（至）４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22x4 zrnyobiv22x4}</td><td>（連携用）予備項目Ｖ２２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykrenban5 zrnsyukyktkykrenban5}</td><td>（連携用）主契約特約連番５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykmsgkbn5 zrnsyukyktkykmsgkbn5}</td><td>（連携用）主契約特約メッセージ区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkyksmsgkbn5 zrnsyukyktkyksmsgkbn5}</td><td>（連携用）主契約特約保険金額メッセージ区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkknmsgkbn5 zrnsyukyktkykhknkknmsgkbn5}</td><td>（連携用）主契約特約保険期間メッセージ区分５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykstuukatype5 zrnsyukyktkykstuukatype5}</td><td>（連携用）主契約特約保険金額通貨タイプ５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkngk5 zrnsyukyktkykhknkngk5}</td><td>（連携用）主契約特約保険金額５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai1hknkknymdto5 zrnsyutkdai1hknkknymdto5}</td><td>（連携用）主契約特約第１保険期間年月日（至）５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai2hknkknymdto5 zrnsyutkdai2hknkknymdto5}</td><td>（連携用）主契約特約第２保険期間年月日（至）５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22x5 zrnyobiv22x5}</td><td>（連携用）予備項目Ｖ２２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykrenban6 zrnsyukyktkykrenban6}</td><td>（連携用）主契約特約連番６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykmsgkbn6 zrnsyukyktkykmsgkbn6}</td><td>（連携用）主契約特約メッセージ区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkyksmsgkbn6 zrnsyukyktkyksmsgkbn6}</td><td>（連携用）主契約特約保険金額メッセージ区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkknmsgkbn6 zrnsyukyktkykhknkknmsgkbn6}</td><td>（連携用）主契約特約保険期間メッセージ区分６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykstuukatype6 zrnsyukyktkykstuukatype6}</td><td>（連携用）主契約特約保険金額通貨タイプ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkngk6 zrnsyukyktkykhknkngk6}</td><td>（連携用）主契約特約保険金額６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai1hknkknymdto6 zrnsyutkdai1hknkknymdto6}</td><td>（連携用）主契約特約第１保険期間年月日（至）６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai2hknkknymdto6 zrnsyutkdai2hknkknymdto6}</td><td>（連携用）主契約特約第２保険期間年月日（至）６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22x6 zrnyobiv22x6}</td><td>（連携用）予備項目Ｖ２２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykrenban7 zrnsyukyktkykrenban7}</td><td>（連携用）主契約特約連番７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykmsgkbn7 zrnsyukyktkykmsgkbn7}</td><td>（連携用）主契約特約メッセージ区分７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkyksmsgkbn7 zrnsyukyktkyksmsgkbn7}</td><td>（連携用）主契約特約保険金額メッセージ区分７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkknmsgkbn7 zrnsyukyktkykhknkknmsgkbn7}</td><td>（連携用）主契約特約保険期間メッセージ区分７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykstuukatype7 zrnsyukyktkykstuukatype7}</td><td>（連携用）主契約特約保険金額通貨タイプ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkngk7 zrnsyukyktkykhknkngk7}</td><td>（連携用）主契約特約保険金額７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai1hknkknymdto7 zrnsyutkdai1hknkknymdto7}</td><td>（連携用）主契約特約第１保険期間年月日（至）７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai2hknkknymdto7 zrnsyutkdai2hknkknymdto7}</td><td>（連携用）主契約特約第２保険期間年月日（至）７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22x7 zrnyobiv22x7}</td><td>（連携用）予備項目Ｖ２２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykrenban8 zrnsyukyktkykrenban8}</td><td>（連携用）主契約特約連番８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykmsgkbn8 zrnsyukyktkykmsgkbn8}</td><td>（連携用）主契約特約メッセージ区分８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkyksmsgkbn8 zrnsyukyktkyksmsgkbn8}</td><td>（連携用）主契約特約保険金額メッセージ区分８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkknmsgkbn8 zrnsyukyktkykhknkknmsgkbn8}</td><td>（連携用）主契約特約保険期間メッセージ区分８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykstuukatype8 zrnsyukyktkykstuukatype8}</td><td>（連携用）主契約特約保険金額通貨タイプ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkngk8 zrnsyukyktkykhknkngk8}</td><td>（連携用）主契約特約保険金額８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai1hknkknymdto8 zrnsyutkdai1hknkknymdto8}</td><td>（連携用）主契約特約第１保険期間年月日（至）８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai2hknkknymdto8 zrnsyutkdai2hknkknymdto8}</td><td>（連携用）主契約特約第２保険期間年月日（至）８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22x8 zrnyobiv22x8}</td><td>（連携用）予備項目Ｖ２２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykrenban9 zrnsyukyktkykrenban9}</td><td>（連携用）主契約特約連番９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykmsgkbn9 zrnsyukyktkykmsgkbn9}</td><td>（連携用）主契約特約メッセージ区分９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkyksmsgkbn9 zrnsyukyktkyksmsgkbn9}</td><td>（連携用）主契約特約保険金額メッセージ区分９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkknmsgkbn9 zrnsyukyktkykhknkknmsgkbn9}</td><td>（連携用）主契約特約保険期間メッセージ区分９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykstuukatype9 zrnsyukyktkykstuukatype9}</td><td>（連携用）主契約特約保険金額通貨タイプ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkngk9 zrnsyukyktkykhknkngk9}</td><td>（連携用）主契約特約保険金額９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai1hknkknymdto9 zrnsyutkdai1hknkknymdto9}</td><td>（連携用）主契約特約第１保険期間年月日（至）９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai2hknkknymdto9 zrnsyutkdai2hknkknymdto9}</td><td>（連携用）主契約特約第２保険期間年月日（至）９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22x9 zrnyobiv22x9}</td><td>（連携用）予備項目Ｖ２２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykrenban10 zrnsyukyktkykrenban10}</td><td>（連携用）主契約特約連番１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykmsgkbn10 zrnsyukyktkykmsgkbn10}</td><td>（連携用）主契約特約メッセージ区分１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkyksmsgkbn10 zrnsyukyktkyksmsgkbn10}</td><td>（連携用）主契約特約保険金額メッセージ区分１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkknmsgkbn10 zrnsyukyktkykhknkknmsgkbn10}</td><td>（連携用）主契約特約保険期間メッセージ区分１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykstuukatype10 zrnsyukyktkykstuukatype10}</td><td>（連携用）主契約特約保険金額通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukyktkykhknkngk10 zrnsyukyktkykhknkngk10}</td><td>（連携用）主契約特約保険金額１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai1hknkknymdto10 zrnsyutkdai1hknkknymdto10}</td><td>（連携用）主契約特約第１保険期間年月日（至）１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyutkdai2hknkknymdto10 zrnsyutkdai2hknkknymdto10}</td><td>（連携用）主契約特約第２保険期間年月日（至）１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv22x10 zrnyobiv22x10}</td><td>（連携用）予備項目Ｖ２２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv50 zrnyobiv50}</td><td>（連携用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd1 zrnkykniyustmsgcd1}</td><td>（連携用）契約内容欄下メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd2 zrnkykniyustmsgcd2}</td><td>（連携用）契約内容欄下メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd3 zrnkykniyustmsgcd3}</td><td>（連携用）契約内容欄下メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd4 zrnkykniyustmsgcd4}</td><td>（連携用）契約内容欄下メッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd5 zrnkykniyustmsgcd5}</td><td>（連携用）契約内容欄下メッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd6 zrnkykniyustmsgcd6}</td><td>（連携用）契約内容欄下メッセージコード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd7 zrnkykniyustmsgcd7}</td><td>（連携用）契約内容欄下メッセージコード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd8 zrnkykniyustmsgcd8}</td><td>（連携用）契約内容欄下メッセージコード８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd9 zrnkykniyustmsgcd9}</td><td>（連携用）契約内容欄下メッセージコード９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd10 zrnkykniyustmsgcd10}</td><td>（連携用）契約内容欄下メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd11 zrnkykniyustmsgcd11}</td><td>（連携用）契約内容欄下メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd12 zrnkykniyustmsgcd12}</td><td>（連携用）契約内容欄下メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd13 zrnkykniyustmsgcd13}</td><td>（連携用）契約内容欄下メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd14 zrnkykniyustmsgcd14}</td><td>（連携用）契約内容欄下メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustmsgcd15 zrnkykniyustmsgcd15}</td><td>（連携用）契約内容欄下メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustitjbrptuuktype zrnkykniyustitjbrptuuktype}</td><td>（連携用）契約内容欄下一時払保険料通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustitjbrp zrnkykniyustitjbrp}</td><td>（連携用）契約内容欄下一時払保険料</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustkihonstype zrnkykniyustkihonstype}</td><td>（連携用）契約内容欄下基本保険金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyustkihons zrnkykniyustkihons}</td><td>（連携用）契約内容欄下基本保険金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd1 zrnsonotanyranmsgcd1}</td><td>（連携用）その他内容欄メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd2 zrnsonotanyranmsgcd2}</td><td>（連携用）その他内容欄メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd3 zrnsonotanyranmsgcd3}</td><td>（連携用）その他内容欄メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd4 zrnsonotanyranmsgcd4}</td><td>（連携用）その他内容欄メッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd5 zrnsonotanyranmsgcd5}</td><td>（連携用）その他内容欄メッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd6 zrnsonotanyranmsgcd6}</td><td>（連携用）その他内容欄メッセージコード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd7 zrnsonotanyranmsgcd7}</td><td>（連携用）その他内容欄メッセージコード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd8 zrnsonotanyranmsgcd8}</td><td>（連携用）その他内容欄メッセージコード８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd9 zrnsonotanyranmsgcd9}</td><td>（連携用）その他内容欄メッセージコード９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd10 zrnsonotanyranmsgcd10}</td><td>（連携用）その他内容欄メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd11 zrnsonotanyranmsgcd11}</td><td>（連携用）その他内容欄メッセージコード１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd12 zrnsonotanyranmsgcd12}</td><td>（連携用）その他内容欄メッセージコード１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd13 zrnsonotanyranmsgcd13}</td><td>（連携用）その他内容欄メッセージコード１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd14 zrnsonotanyranmsgcd14}</td><td>（連携用）その他内容欄メッセージコード１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd15 zrnsonotanyranmsgcd15}</td><td>（連携用）その他内容欄メッセージコード１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd16 zrnsonotanyranmsgcd16}</td><td>（連携用）その他内容欄メッセージコード１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd17 zrnsonotanyranmsgcd17}</td><td>（連携用）その他内容欄メッセージコード１７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd18 zrnsonotanyranmsgcd18}</td><td>（連携用）その他内容欄メッセージコード１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd19 zrnsonotanyranmsgcd19}</td><td>（連携用）その他内容欄メッセージコード１９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmsgcd20 zrnsonotanyranmsgcd20}</td><td>（連携用）その他内容欄メッセージコード２０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyransiteituuka zrnsonotanyransiteituuka}</td><td>（連携用）その他内容欄指定通貨</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyrannykntuktype zrnsonotanyrannykntuktype}</td><td>（連携用）その他内容欄入金通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyrannykntuukap zrnsonotanyrannykntuukap}</td><td>（連携用）その他内容欄入金通貨保険料</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyrannykntuukasyu zrnsonotanyrannykntuukasyu}</td><td>（連携用）その他内容欄入金通貨種類</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranenkhrikmrate zrnsonotanyranenkhrikmrate}</td><td>（連携用）その他内容欄円貨払込特約レート</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranstigikwsrate zrnsonotanyranstigikwsrate}</td><td>（連携用）その他内容欄指定外通貨払込特約レート</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanykjnkngktuktype zrnsonotanykjnkngktuktype}</td><td>（連携用）その他内容欄基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanykjnkngk zrnsonotanykjnkngk}</td><td>（連携用）その他内容欄基準金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanykjnkngkrate zrnsonotanykjnkngkrate}</td><td>（連携用）その他内容欄基準金額換算レート</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanykjnkngktuuka zrnsonotanykjnkngktuuka}</td><td>（連携用）その他内容欄基準金額通貨</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranpentuktype zrnsonotanyranpentuktype}</td><td>（連携用）その他内容欄保険料円換算通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranpenknsngk zrnsonotanyranpenknsngk}</td><td>（連携用）その他内容欄保険料円換算額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmkhtoutatuwariai zrnpmkhtoutatuwariai}</td><td>（連携用）その他内容欄目標到達割合</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyranmkhgk zrnsonotanyranmkhgk}</td><td>（連携用）その他内容欄目標額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyrannkshrstartymd zrnsonotanyrannkshrstartymd}</td><td>（連携用）その他内容欄年金支払開始日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyrannkkkn zrnsonotanyrannkkkn}</td><td>（連携用）その他内容欄年金期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyyensysnhkhnkymd zrnsonotanyyensysnhkhnkymd}</td><td>（連携用）その他内容欄円建終身保険変更日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanytmttkngktuktype zrnsonotanytmttkngktuktype}</td><td>（連携用）その他内容欄積立金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyteiritutmttkngk zrnsonotanyteiritutmttkngk}</td><td>（連携用）その他内容欄定率積立金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyransisuutmttkngk zrnsonotanyransisuutmttkngk}</td><td>（連携用）その他内容欄指数積立金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyransisuunm zrnsonotanyransisuunm}</td><td>（連携用）その他内容欄指数名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyrendouritu zrnsonotanyrendouritu}</td><td>（連携用）その他内容欄連動率</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyteikisiharaikin zrnsonotanyteikisiharaikin}</td><td>（連携用）その他内容欄定期支払金</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsonotanyrangaimsgcd zrnsonotanyrangaimsgcd}</td><td>（連携用）その他内容欄外メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv6 zrnyobiv6}</td><td>（連携用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyounymsgcd zrnhosyounymsgcd}</td><td>（連携用）保障内容メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv15 zrnyobiv15}</td><td>（連携用）予備項目Ｖ１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhosyounyhihknsyanmkanji zrnhosyounyhihknsyanmkanji}</td><td>（連携用）保障内容被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24 zrnyobiv24}</td><td>（連携用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboumidasimsgcd zrnsiboumidasimsgcd}</td><td>（連携用）死亡保障見出しメッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboumidasimsgcd2 zrnsiboumidasimsgcd2}</td><td>（連携用）死亡保障見出しメッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai1hknkknmsgcd1 zrnsiboudai1hknkknmsgcd1}</td><td>（連携用）死亡保障第１保険期間メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai1hknkknmsgcd2 zrnsiboudai1hknkknmsgcd2}</td><td>（連携用）死亡保障第１保険期間メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai1hknkknigimsgcd zrnsiboudai1hknkknigimsgcd}</td><td>（連携用）死亡保障第１保険期間不慮の事故以外Ｓ表メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai1hknkknigimsgcd2 zrnsiboudai1hknkknigimsgcd2}</td><td>（連携用）死亡保障第１保険期間不慮の事故以外Ｓ表メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai1hknkknhrsmsgcd zrnsiboudai1hknkknhrsmsgcd}</td><td>（連携用）死亡保障第１保険期間不慮の事故Ｓ表メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai1hknkknhrsmsgcd2 zrnsiboudai1hknkknhrsmsgcd2}</td><td>（連携用）死亡保障第１保険期間不慮の事故Ｓ表メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai1hknkknsmrmsgcd zrnsiboudai1hknkknsmrmsgcd}</td><td>（連携用）死亡保障第１保険期間Ｓ表丸印メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai2hknkknmsgcd1 zrnsiboudai2hknkknmsgcd1}</td><td>（連携用）死亡保障第２保険期間メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai2hknkknmsgcd2 zrnsiboudai2hknkknmsgcd2}</td><td>（連携用）死亡保障第２保険期間メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai2hknkknsmsgcd zrnsiboudai2hknkknsmsgcd}</td><td>（連携用）死亡保障第２保険期間Ｓ表メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai2hknkknsmsgcd2 zrnsiboudai2hknkknsmsgcd2}</td><td>（連携用）死亡保障第２保険期間Ｓ表メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai3hknkknmsgcd1 zrnsiboudai3hknkknmsgcd1}</td><td>（連携用）死亡保障第３保険期間メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai3hknkknmsgcd2 zrnsiboudai3hknkknmsgcd2}</td><td>（連携用）死亡保障第３保険期間メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv15x2 zrnyobiv15x2}</td><td>（連携用）予備項目Ｖ１５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai1hknkknymdto zrnsiboudai1hknkknymdto}</td><td>（連携用）死亡保障第１保険期間年月日（至）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibouitjbrpyentuuktype zrnsibouitjbrpyentuuktype}</td><td>（連携用）死亡保障一時払保険料相当円換算額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibouitjbrpyentuukgk zrnsibouitjbrpyentuukgk}</td><td>（連携用）死亡保障一時払保険料相当円換算額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai1kjnkngktuktype zrnsiboudai1kjnkngktuktype}</td><td>（連携用）死亡保障第１基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai1kjnkngk zrnsiboudai1kjnkngk}</td><td>（連携用）死亡保障第１基準金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai2hknkknymdto zrnsiboudai2hknkknymdto}</td><td>（連携用）死亡保障第２保険期間年月日（至）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai2kjnkngktuktype zrnsiboudai2kjnkngktuktype}</td><td>（連携用）死亡保障第２基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai2kjnkngk zrnsiboudai2kjnkngk}</td><td>（連携用）死亡保障第２基準金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai3kjnkngktuktype zrnsiboudai3kjnkngktuktype}</td><td>（連携用）死亡保障第３基準金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboudai3kjnkngk zrnsiboudai3kjnkngk}</td><td>（連携用）死亡保障第３基準金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv23 zrnyobiv23}</td><td>（連携用）予備項目Ｖ２３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1skwsrateyendaka zrndai1skwsrateyendaka}</td><td>（連携用）第１死亡保険金額為替レート（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1skwsrateyenkijyun zrndai1skwsrateyenkijyun}</td><td>（連携用）第１死亡保険金額為替レート（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1skwsrateyenyasu zrndai1skwsrateyenyasu}</td><td>（連携用）第１死亡保険金額為替レート（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sibousnenoutouymd1 zrndai1sibousnenoutouymd1}</td><td>（連携用）第１死亡保険金額年単位応当年月日０１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktype01 zrndai1stuuktype01}</td><td>（連携用）第１死亡保険金額通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1s01 zrndai1s01}</td><td>（連携用）第１死亡保険金額０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumu01 zrndai1syenyendakaumu01}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunumu01 zrndai1syenyenkijyunumu01}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumu01 zrndai1syenyenyasuumu01}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktype01 zrndai1syentuuktype01}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendaka01 zrndai1syenyendaka01}</td><td>（連携用）第１死亡保険金額（円貨）（円高）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyun01 zrndai1syenyenkijyun01}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasu01 zrndai1syenyenyasu01}</td><td>（連携用）第１死亡保険金額（円貨）（円安）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndk01 zrndai1zennouzndk01}</td><td>（連携用）第１前納残高０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndktype01 zrndai1zennouzndktype01}</td><td>（連携用）第１前納残高通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgk01 zrndai1sbjiuktgk01}</td><td>（連携用）第１死亡時受取額０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgktype01 zrndai1sbjiuktgktype01}</td><td>（連携用）第１死亡時受取額通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkytype01 zrndai1sbjiuktgkytype01}</td><td>（連携用）第１死亡時受取額（円貨）通貨タイプ０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkydaka01 zrndai1sbjiuktgkydaka01}</td><td>（連携用）第１死亡時受取額（円貨）（円高）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkykijyun01 zrndai1sbjiuktgkykijyun01}</td><td>（連携用）第１死亡時受取額（円貨）（中央値）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkyyasu01 zrndai1sbjiuktgkyyasu01}</td><td>（連携用）第１死亡時受取額（円貨）（円安）０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sibousnenoutouymd2 zrndai1sibousnenoutouymd2}</td><td>（連携用）第１死亡保険金額年単位応当年月日０２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktype02 zrndai1stuuktype02}</td><td>（連携用）第１死亡保険金額通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1s02 zrndai1s02}</td><td>（連携用）第１死亡保険金額０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumu02 zrndai1syenyendakaumu02}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunumu02 zrndai1syenyenkijyunumu02}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumu02 zrndai1syenyenyasuumu02}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktype02 zrndai1syentuuktype02}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendaka02 zrndai1syenyendaka02}</td><td>（連携用）第１死亡保険金額（円貨）（円高）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyun02 zrndai1syenyenkijyun02}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasu02 zrndai1syenyenyasu02}</td><td>（連携用）第１死亡保険金額（円貨）（円安）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndk02 zrndai1zennouzndk02}</td><td>（連携用）第１前納残高０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndktype02 zrndai1zennouzndktype02}</td><td>（連携用）第１前納残高通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgk02 zrndai1sbjiuktgk02}</td><td>（連携用）第１死亡時受取額０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgktype02 zrndai1sbjiuktgktype02}</td><td>（連携用）第１死亡時受取額通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkytype02 zrndai1sbjiuktgkytype02}</td><td>（連携用）第１死亡時受取額（円貨）通貨タイプ０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkydaka02 zrndai1sbjiuktgkydaka02}</td><td>（連携用）第１死亡時受取額（円貨）（円高）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkykijyun02 zrndai1sbjiuktgkykijyun02}</td><td>（連携用）第１死亡時受取額（円貨）（中央値）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkyyasu02 zrndai1sbjiuktgkyyasu02}</td><td>（連携用）第１死亡時受取額（円貨）（円安）０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sibousnenoutouymd3 zrndai1sibousnenoutouymd3}</td><td>（連携用）第１死亡保険金額年単位応当年月日０３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktype03 zrndai1stuuktype03}</td><td>（連携用）第１死亡保険金額通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1s03 zrndai1s03}</td><td>（連携用）第１死亡保険金額０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumu03 zrndai1syenyendakaumu03}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunumu03 zrndai1syenyenkijyunumu03}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumu03 zrndai1syenyenyasuumu03}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktype03 zrndai1syentuuktype03}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendaka03 zrndai1syenyendaka03}</td><td>（連携用）第１死亡保険金額（円貨）（円高）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyun03 zrndai1syenyenkijyun03}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasu03 zrndai1syenyenyasu03}</td><td>（連携用）第１死亡保険金額（円貨）（円安）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndk03 zrndai1zennouzndk03}</td><td>（連携用）第１前納残高０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndktype03 zrndai1zennouzndktype03}</td><td>（連携用）第１前納残高通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgk03 zrndai1sbjiuktgk03}</td><td>（連携用）第１死亡時受取額０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgktype03 zrndai1sbjiuktgktype03}</td><td>（連携用）第１死亡時受取額通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkytype03 zrndai1sbjiuktgkytype03}</td><td>（連携用）第１死亡時受取額（円貨）通貨タイプ０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkydaka03 zrndai1sbjiuktgkydaka03}</td><td>（連携用）第１死亡時受取額（円貨）（円高）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkykijyun03 zrndai1sbjiuktgkykijyun03}</td><td>（連携用）第１死亡時受取額（円貨）（中央値）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkyyasu03 zrndai1sbjiuktgkyyasu03}</td><td>（連携用）第１死亡時受取額（円貨）（円安）０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sibousnenoutouymd4 zrndai1sibousnenoutouymd4}</td><td>（連携用）第１死亡保険金額年単位応当年月日０４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktype04 zrndai1stuuktype04}</td><td>（連携用）第１死亡保険金額通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1s04 zrndai1s04}</td><td>（連携用）第１死亡保険金額０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumu04 zrndai1syenyendakaumu04}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunumu04 zrndai1syenyenkijyunumu04}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumu04 zrndai1syenyenyasuumu04}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktype04 zrndai1syentuuktype04}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendaka04 zrndai1syenyendaka04}</td><td>（連携用）第１死亡保険金額（円貨）（円高）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyun04 zrndai1syenyenkijyun04}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasu04 zrndai1syenyenyasu04}</td><td>（連携用）第１死亡保険金額（円貨）（円安）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndk04 zrndai1zennouzndk04}</td><td>（連携用）第１前納残高０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndktype04 zrndai1zennouzndktype04}</td><td>（連携用）第１前納残高通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgk04 zrndai1sbjiuktgk04}</td><td>（連携用）第１死亡時受取額０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgktype04 zrndai1sbjiuktgktype04}</td><td>（連携用）第１死亡時受取額通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkytype04 zrndai1sbjiuktgkytype04}</td><td>（連携用）第１死亡時受取額（円貨）通貨タイプ０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkydaka04 zrndai1sbjiuktgkydaka04}</td><td>（連携用）第１死亡時受取額（円貨）（円高）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkykijyun04 zrndai1sbjiuktgkykijyun04}</td><td>（連携用）第１死亡時受取額（円貨）（中央値）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkyyasu04 zrndai1sbjiuktgkyyasu04}</td><td>（連携用）第１死亡時受取額（円貨）（円安）０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sibousnenoutouymd5 zrndai1sibousnenoutouymd5}</td><td>（連携用）第１死亡保険金額年単位応当年月日０５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktype05 zrndai1stuuktype05}</td><td>（連携用）第１死亡保険金額通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1s05 zrndai1s05}</td><td>（連携用）第１死亡保険金額０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumu05 zrndai1syenyendakaumu05}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunumu05 zrndai1syenyenkijyunumu05}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumu05 zrndai1syenyenyasuumu05}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktype05 zrndai1syentuuktype05}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendaka05 zrndai1syenyendaka05}</td><td>（連携用）第１死亡保険金額（円貨）（円高）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyun05 zrndai1syenyenkijyun05}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasu05 zrndai1syenyenyasu05}</td><td>（連携用）第１死亡保険金額（円貨）（円安）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndk05 zrndai1zennouzndk05}</td><td>（連携用）第１前納残高０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndktype05 zrndai1zennouzndktype05}</td><td>（連携用）第１前納残高通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgk05 zrndai1sbjiuktgk05}</td><td>（連携用）第１死亡時受取額０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgktype05 zrndai1sbjiuktgktype05}</td><td>（連携用）第１死亡時受取額通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkytype05 zrndai1sbjiuktgkytype05}</td><td>（連携用）第１死亡時受取額（円貨）通貨タイプ０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkydaka05 zrndai1sbjiuktgkydaka05}</td><td>（連携用）第１死亡時受取額（円貨）（円高）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkykijyun05 zrndai1sbjiuktgkykijyun05}</td><td>（連携用）第１死亡時受取額（円貨）（中央値）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkyyasu05 zrndai1sbjiuktgkyyasu05}</td><td>（連携用）第１死亡時受取額（円貨）（円安）０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sibousnenoutouymd6 zrndai1sibousnenoutouymd6}</td><td>（連携用）第１死亡保険金額年単位応当年月日０６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktype06 zrndai1stuuktype06}</td><td>（連携用）第１死亡保険金額通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1s06 zrndai1s06}</td><td>（連携用）第１死亡保険金額０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumu06 zrndai1syenyendakaumu06}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunumu06 zrndai1syenyenkijyunumu06}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumu06 zrndai1syenyenyasuumu06}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktype06 zrndai1syentuuktype06}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendaka06 zrndai1syenyendaka06}</td><td>（連携用）第１死亡保険金額（円貨）（円高）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyun06 zrndai1syenyenkijyun06}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasu06 zrndai1syenyenyasu06}</td><td>（連携用）第１死亡保険金額（円貨）（円安）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndk06 zrndai1zennouzndk06}</td><td>（連携用）第１前納残高０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1zennouzndktype06 zrndai1zennouzndktype06}</td><td>（連携用）第１前納残高通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgk06 zrndai1sbjiuktgk06}</td><td>（連携用）第１死亡時受取額０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgktype06 zrndai1sbjiuktgktype06}</td><td>（連携用）第１死亡時受取額通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkytype06 zrndai1sbjiuktgkytype06}</td><td>（連携用）第１死亡時受取額（円貨）通貨タイプ０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkydaka06 zrndai1sbjiuktgkydaka06}</td><td>（連携用）第１死亡時受取額（円貨）（円高）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkykijyun06 zrndai1sbjiuktgkykijyun06}</td><td>（連携用）第１死亡時受取額（円貨）（中央値）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sbjiuktgkyyasu06 zrndai1sbjiuktgkyyasu06}</td><td>（連携用）第１死亡時受取額（円貨）（円安）０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sibousnenoutouymd7 zrndai1sibousnenoutouymd7}</td><td>（連携用）第１死亡保険金額年単位応当年月日０７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktype07 zrndai1stuuktype07}</td><td>（連携用）第１死亡保険金額通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1s07 zrndai1s07}</td><td>（連携用）第１死亡保険金額０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumu07 zrndai1syenyendakaumu07}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunumu07 zrndai1syenyenkijyunumu07}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumu07 zrndai1syenyenyasuumu07}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktype07 zrndai1syentuuktype07}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendaka07 zrndai1syenyendaka07}</td><td>（連携用）第１死亡保険金額（円貨）（円高）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyun07 zrndai1syenyenkijyun07}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasu07 zrndai1syenyenyasu07}</td><td>（連携用）第１死亡保険金額（円貨）（円安）０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sibousnenoutouymd8 zrndai1sibousnenoutouymd8}</td><td>（連携用）第１死亡保険金額年単位応当年月日０８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktype08 zrndai1stuuktype08}</td><td>（連携用）第１死亡保険金額通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1s08 zrndai1s08}</td><td>（連携用）第１死亡保険金額０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumu08 zrndai1syenyendakaumu08}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunumu08 zrndai1syenyenkijyunumu08}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumu08 zrndai1syenyenyasuumu08}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktype08 zrndai1syentuuktype08}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendaka08 zrndai1syenyendaka08}</td><td>（連携用）第１死亡保険金額（円貨）（円高）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyun08 zrndai1syenyenkijyun08}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasu08 zrndai1syenyenyasu08}</td><td>（連携用）第１死亡保険金額（円貨）（円安）０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sibousnenoutouymd9 zrndai1sibousnenoutouymd9}</td><td>（連携用）第１死亡保険金額年単位応当年月日０９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktype09 zrndai1stuuktype09}</td><td>（連携用）第１死亡保険金額通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1s09 zrndai1s09}</td><td>（連携用）第１死亡保険金額０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumu09 zrndai1syenyendakaumu09}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunumu09 zrndai1syenyenkijyunumu09}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumu09 zrndai1syenyenyasuumu09}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktype09 zrndai1syentuuktype09}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendaka09 zrndai1syenyendaka09}</td><td>（連携用）第１死亡保険金額（円貨）（円高）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyun09 zrndai1syenyenkijyun09}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasu09 zrndai1syenyenyasu09}</td><td>（連携用）第１死亡保険金額（円貨）（円安）０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1sibousnenoutouymd10 zrndai1sibousnenoutouymd10}</td><td>（連携用）第１死亡保険金額年単位応当年月日１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktype10 zrndai1stuuktype10}</td><td>（連携用）第１死亡保険金額通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1s10 zrndai1s10}</td><td>（連携用）第１死亡保険金額１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumu10 zrndai1syenyendakaumu10}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunumu10 zrndai1syenyenkijyunumu10}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumu10 zrndai1syenyenyasuumu10}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktype10 zrndai1syentuuktype10}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendaka10 zrndai1syenyendaka10}</td><td>（連携用）第１死亡保険金額（円貨）（円高）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyun10 zrndai1syenyenkijyun10}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasu10 zrndai1syenyenyasu10}</td><td>（連携用）第１死亡保険金額（円貨）（円安）１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1stuuktypehuryo zrndai1stuuktypehuryo}</td><td>（連携用）第１死亡保険金額通貨タイプ（不慮）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1shuryo zrndai1shuryo}</td><td>（連携用）第１死亡保険金額（不慮）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakaumuhuryo zrndai1syenyendakaumuhuryo}</td><td>（連携用）第１死亡保険金額（円貨）（円高）丸印有無（不慮）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkjnumuhuryo zrndai1syenyenkjnumuhuryo}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）丸印有無（不慮）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuumuhuryo zrndai1syenyenyasuumuhuryo}</td><td>（連携用）第１死亡保険金額（円貨）（円安）丸印有無（不慮）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syentuuktypehuryo zrndai1syentuuktypehuryo}</td><td>（連携用）第１死亡保険金額（円貨）通貨タイプ（不慮）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyendakahuryo zrndai1syenyendakahuryo}</td><td>（連携用）第１死亡保険金額（円貨）（円高）（不慮）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenkijyunhuryo zrndai1syenyenkijyunhuryo}</td><td>（連携用）第１死亡保険金額（円貨）（中央値）（不慮）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1syenyenyasuhuryo zrndai1syenyenyasuhuryo}</td><td>（連携用）第１死亡保険金額（円貨）（円安）（不慮）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2stuuktype zrndai2stuuktype}</td><td>（連携用）第２死亡保険金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2s zrndai2s}</td><td>（連携用）第２死亡保険金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2syentuuktype zrndai2syentuuktype}</td><td>（連携用）第２死亡保険金額（円貨）通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2syenyendaka zrndai2syenyendaka}</td><td>（連携用）第２死亡保険金額（円貨）（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2syenyenkijyun zrndai2syenyenkijyun}</td><td>（連携用）第２死亡保険金額（円貨）（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2syenyenyasu zrndai2syenyenyasu}</td><td>（連携用）第２死亡保険金額（円貨）（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai3stuuktype zrndai3stuuktype}</td><td>（連携用）第３死亡保険金額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai3s zrndai3s}</td><td>（連携用）第３死亡保険金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai3syentuuktype zrndai3syentuuktype}</td><td>（連携用）第３死亡保険金額（円貨）通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai3syenyendaka zrndai3syenyendaka}</td><td>（連携用）第３死亡保険金額（円貨）（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai3syenyenkijyun zrndai3syenyenkijyun}</td><td>（連携用）第３死亡保険金額（円貨）（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai3syenyenyasu zrndai3syenyenyasu}</td><td>（連携用）第３死亡保険金額（円貨）（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibouinjiptnkbn zrnsibouinjiptnkbn}</td><td>（連携用）死亡保障印字パターン</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv25 zrnyobiv25}</td><td>（連携用）予備項目Ｖ２５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkmsgcd1 zrnnkmsgcd1}</td><td>（連携用）年金メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkmsgcd2 zrnnkmsgcd2}</td><td>（連携用）年金メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkmsgcd3 zrnnkmsgcd3}</td><td>（連携用）年金メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkmsgcd4 zrnnkmsgcd4}</td><td>（連携用）年金メッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkmsgcd5 zrnnkmsgcd5}</td><td>（連携用）年金メッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkmsgcd6 zrnnkmsgcd6}</td><td>（連携用）年金メッセージコード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkmsgcd7 zrnnkmsgcd7}</td><td>（連携用）年金メッセージコード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkmsgcd8 zrnnkmsgcd8}</td><td>（連携用）年金メッセージコード８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkmsgcd9 zrnnkmsgcd9}</td><td>（連携用）年金メッセージコード９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkmsgcd10 zrnnkmsgcd10}</td><td>（連携用）年金メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukinmsgcd1 zrnsiboukyuuhukinmsgcd1}</td><td>（連携用）死亡給付金メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukinmsgcd2 zrnsiboukyuuhukinmsgcd2}</td><td>（連携用）死亡給付金メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukinmsgcd3 zrnsiboukyuuhukinmsgcd3}</td><td>（連携用）死亡給付金メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukinmsgcd4 zrnsiboukyuuhukinmsgcd4}</td><td>（連携用）死亡給付金メッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukinmsgcd5 zrnsiboukyuuhukinmsgcd5}</td><td>（連携用）死亡給付金メッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukinmsgcd6 zrnsiboukyuuhukinmsgcd6}</td><td>（連携用）死亡給付金メッセージコード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukinmsgcd7 zrnsiboukyuuhukinmsgcd7}</td><td>（連携用）死亡給付金メッセージコード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukinmsgcd8 zrnsiboukyuuhukinmsgcd8}</td><td>（連携用）死亡給付金メッセージコード８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukinmsgcd9 zrnsiboukyuuhukinmsgcd9}</td><td>（連携用）死亡給付金メッセージコード９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiboukyuuhukinmsgcd10 zrnsiboukyuuhukinmsgcd10}</td><td>（連携用）死亡給付金メッセージコード１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrstartzenymd zrnnkshrstartzenymd}</td><td>（連携用）年金支払開始日前日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyouyennkhknhentktype zrnmkhyouyennkhknhentktype}</td><td>（連携用）目標到達時円建年金保険変更特約目標額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyouyennkhknhentkmkhgk zrnmkhyouyennkhknhentkmkhgk}</td><td>（連携用）目標到達時円建年金保険変更特約目標額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyennkhknhentkmkhwari zrnmkhyennkhknhentkmkhwari}</td><td>（連携用）目標到達時円建年金保険変更特約目標割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaibunwarimsgcd1 zrnhaibunwarimsgcd1}</td><td>（連携用）配分割合メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaibunwarimsgcd2 zrnhaibunwarimsgcd2}</td><td>（連携用）配分割合メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaibunwarimsgcd3 zrnhaibunwarimsgcd3}</td><td>（連携用）配分割合メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteiritutmtthbnwr zrnteiritutmtthbnwr}</td><td>（連携用）定率積立部分配分割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuutmtthbnwr zrnsisuutmtthbnwr}</td><td>（連携用）指数積立部分配分割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuannaimsg1 zrnsisuuannaimsg1}</td><td>（連携用）指数案内メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuannaimsg2 zrnsisuuannaimsg2}</td><td>（連携用）指数案内メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuuannaimsg3 zrnsisuuannaimsg3}</td><td>（連携用）指数案内メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyouyensysnikoumsgcd zrnmkhyouyensysnikoumsgcd}</td><td>（連携用）目標到達時円建終身保険移行特約メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyouyensysnikoumsgcd2 zrnmkhyouyensysnikoumsgcd2}</td><td>（連携用）目標到達時円建終身保険移行特約メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyouyensysnikoumsgcd3 zrnmkhyouyensysnikoumsgcd3}</td><td>（連携用）目標到達時円建終身保険移行特約メッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyouyensysnikougktype zrnmkhyouyensysnikougktype}</td><td>（連携用）目標到達時円建終身保険移行特約目標額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyouyensysnikougk zrnmkhyouyensysnikougk}</td><td>（連携用）目標到達時円建終身保険移行特約目標額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyouyensysnikouwra zrnmkhyouyensysnikouwra}</td><td>（連携用）目標到達時円建終身保険移行特約目標割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyouysysnikcurrentgk zrnmkhyouysysnikcurrentgk}</td><td>（連携用）目標到達時円建終身保険移行特約現在の目標額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv12 zrnyobiv12}</td><td>（連携用）予備項目Ｖ１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrtkykmsgcd1 zrnkaigomaehrtkykmsgcd1}</td><td>（連携用）介護前払特約メッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrtkykmsgcd2 zrnkaigomaehrtkykmsgcd2}</td><td>（連携用）介護前払特約メッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrtkykmsgcdst1 zrnkaigomaehrtkykmsgcdst1}</td><td>（連携用）介護前払特約メッセージコード表下１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrtkykmsgcdst2 zrnkaigomaehrtkykmsgcdst2}</td><td>（連携用）介護前払特約メッセージコード表下２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrtkhknkkn1mnryymd zrnkgmaehrtkhknkkn1mnryymd}</td><td>（連携用）介護前払特約第１保険期間満了日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrtkykitrnumu zrnkaigomaehrtkykitrnumu}</td><td>（連携用）介護前払特約受取額一覧有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrtkykkyktuuka zrnkaigomaehrtkykkyktuuka}</td><td>（連携用）介護前払特約契約通貨</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrtkykstdmsgcd zrnkaigomaehrtkykstdmsgcd}</td><td>（連携用）介護前払特約指定代理メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugktype zrnkaigomaehrjrugktype}</td><td>（連携用）介護前払受領額通貨タイプ</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrsikuhhknnen01 zrnkaigomaehrsikuhhknnen01}</td><td>（連携用）介護前払請求日時点被保険者年齢０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrstikkn01 zrnkaigomaehrstikkn01}</td><td>（連携用）介護前払所定期間０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugk01 zrnkaigomaehrjrugk01}</td><td>（連携用）介護前払受領額０１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrsikuhhknnen02 zrnkaigomaehrsikuhhknnen02}</td><td>（連携用）介護前払請求日時点被保険者年齢０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrstikkn02 zrnkaigomaehrstikkn02}</td><td>（連携用）介護前払所定期間０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugk02 zrnkaigomaehrjrugk02}</td><td>（連携用）介護前払受領額０２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrsikuhhknnen03 zrnkaigomaehrsikuhhknnen03}</td><td>（連携用）介護前払請求日時点被保険者年齢０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrstikkn03 zrnkaigomaehrstikkn03}</td><td>（連携用）介護前払所定期間０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugk03 zrnkaigomaehrjrugk03}</td><td>（連携用）介護前払受領額０３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrsikuhhknnen04 zrnkaigomaehrsikuhhknnen04}</td><td>（連携用）介護前払請求日時点被保険者年齢０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrstikkn04 zrnkaigomaehrstikkn04}</td><td>（連携用）介護前払所定期間０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugk04 zrnkaigomaehrjrugk04}</td><td>（連携用）介護前払受領額０４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrsikuhhknnen05 zrnkaigomaehrsikuhhknnen05}</td><td>（連携用）介護前払請求日時点被保険者年齢０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrstikkn05 zrnkaigomaehrstikkn05}</td><td>（連携用）介護前払所定期間０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugk05 zrnkaigomaehrjrugk05}</td><td>（連携用）介護前払受領額０５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrsikuhhknnen06 zrnkaigomaehrsikuhhknnen06}</td><td>（連携用）介護前払請求日時点被保険者年齢０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrstikkn06 zrnkaigomaehrstikkn06}</td><td>（連携用）介護前払所定期間０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugk06 zrnkaigomaehrjrugk06}</td><td>（連携用）介護前払受領額０６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrsikuhhknnen07 zrnkaigomaehrsikuhhknnen07}</td><td>（連携用）介護前払請求日時点被保険者年齢０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrstikkn07 zrnkaigomaehrstikkn07}</td><td>（連携用）介護前払所定期間０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugk07 zrnkaigomaehrjrugk07}</td><td>（連携用）介護前払受領額０７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrsikuhhknnen08 zrnkaigomaehrsikuhhknnen08}</td><td>（連携用）介護前払請求日時点被保険者年齢０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrstikkn08 zrnkaigomaehrstikkn08}</td><td>（連携用）介護前払所定期間０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugk08 zrnkaigomaehrjrugk08}</td><td>（連携用）介護前払受領額０８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrsikuhhknnen09 zrnkaigomaehrsikuhhknnen09}</td><td>（連携用）介護前払請求日時点被保険者年齢０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrstikkn09 zrnkaigomaehrstikkn09}</td><td>（連携用）介護前払所定期間０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugk09 zrnkaigomaehrjrugk09}</td><td>（連携用）介護前払受領額０９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrsikuhhknnen10 zrnkaigomaehrsikuhhknnen10}</td><td>（連携用）介護前払請求日時点被保険者年齢１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrstikkn10 zrnkaigomaehrstikkn10}</td><td>（連携用）介護前払所定期間１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugk10 zrnkaigomaehrjrugk10}</td><td>（連携用）介護前払受領額１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugkydaka01 zrnkaigomaehrjrugkydaka01}</td><td>（連携用）介護前払受領額０１（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkykijyun01 zrnkgmaehrjrugkykijyun01}</td><td>（連携用）介護前払受領額０１（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkyyasu01 zrnkgmaehrjrugkyyasu01}</td><td>（連携用）介護前払受領額０１（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugkydaka02 zrnkaigomaehrjrugkydaka02}</td><td>（連携用）介護前払受領額０２（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkykijyun02 zrnkgmaehrjrugkykijyun02}</td><td>（連携用）介護前払受領額０２（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkyyasu02 zrnkgmaehrjrugkyyasu02}</td><td>（連携用）介護前払受領額０２（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugkydaka03 zrnkaigomaehrjrugkydaka03}</td><td>（連携用）介護前払受領額０３（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkykijyun03 zrnkgmaehrjrugkykijyun03}</td><td>（連携用）介護前払受領額０３（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkyyasu03 zrnkgmaehrjrugkyyasu03}</td><td>（連携用）介護前払受領額０３（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugkydaka04 zrnkaigomaehrjrugkydaka04}</td><td>（連携用）介護前払受領額０４（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkykijyun04 zrnkgmaehrjrugkykijyun04}</td><td>（連携用）介護前払受領額０４（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkyyasu04 zrnkgmaehrjrugkyyasu04}</td><td>（連携用）介護前払受領額０４（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugkydaka05 zrnkaigomaehrjrugkydaka05}</td><td>（連携用）介護前払受領額０５（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkykijyun05 zrnkgmaehrjrugkykijyun05}</td><td>（連携用）介護前払受領額０５（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkyyasu05 zrnkgmaehrjrugkyyasu05}</td><td>（連携用）介護前払受領額０５（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugkydaka06 zrnkaigomaehrjrugkydaka06}</td><td>（連携用）介護前払受領額０６（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkykijyun06 zrnkgmaehrjrugkykijyun06}</td><td>（連携用）介護前払受領額０６（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkyyasu06 zrnkgmaehrjrugkyyasu06}</td><td>（連携用）介護前払受領額０６（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugkydaka07 zrnkaigomaehrjrugkydaka07}</td><td>（連携用）介護前払受領額０７（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkykijyun07 zrnkgmaehrjrugkykijyun07}</td><td>（連携用）介護前払受領額０７（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkyyasu07 zrnkgmaehrjrugkyyasu07}</td><td>（連携用）介護前払受領額０７（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugkydaka08 zrnkaigomaehrjrugkydaka08}</td><td>（連携用）介護前払受領額０８（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkykijyun08 zrnkgmaehrjrugkykijyun08}</td><td>（連携用）介護前払受領額０８（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkyyasu08 zrnkgmaehrjrugkyyasu08}</td><td>（連携用）介護前払受領額０８（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugkydaka09 zrnkaigomaehrjrugkydaka09}</td><td>（連携用）介護前払受領額０９（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkykijyun09 zrnkgmaehrjrugkykijyun09}</td><td>（連携用）介護前払受領額０９（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkyyasu09 zrnkgmaehrjrugkyyasu09}</td><td>（連携用）介護前払受領額０９（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomaehrjrugkydaka10 zrnkaigomaehrjrugkydaka10}</td><td>（連携用）介護前払受領額１０（円高）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkykijyun10 zrnkgmaehrjrugkykijyun10}</td><td>（連携用）介護前払受領額１０（中央値）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkgmaehrjrugkyyasu10 zrnkgmaehrjrugkyyasu10}</td><td>（連携用）介護前払受領額１０（円安）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicemsg1 zrnkzktourokuservicemsg1}</td><td>（連携用）ご家族登録サービスメッセージコード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicemsg2 zrnkzktourokuservicemsg2}</td><td>（連携用）ご家族登録サービスメッセージコード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicemsg3 zrnkzktourokuservicemsg3}</td><td>（連携用）ご家族登録サービスメッセージコード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicemsg4 zrnkzktourokuservicemsg4}</td><td>（連携用）ご家族登録サービスメッセージコード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicemsg5 zrnkzktourokuservicemsg5}</td><td>（連携用）ご家族登録サービスメッセージコード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicemsg6 zrnkzktourokuservicemsg6}</td><td>（連携用）ご家族登録サービスメッセージコード６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicemsg7 zrnkzktourokuservicemsg7}</td><td>（連携用）ご家族登録サービスメッセージコード７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicemsg8 zrnkzktourokuservicemsg8}</td><td>（連携用）ご家族登録サービスメッセージコード８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzknm118 zrntrkkzknm118}</td><td>（連携用）登録家族名１（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzksei1 zrntrkkzksei1}</td><td>（連携用）登録家族性別１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkseiymd1zenkaku zrntrkkzkseiymd1zenkaku}</td><td>（連携用）登録家族１人目生年月日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkyno1zenkaku zrntrkkzkyno1zenkaku}</td><td>（連携用）登録家族１人目郵便番号</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkadrkj1 zrntrkkzkadrkj1}</td><td>（連携用）登録家族１人目住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzktelno1zenkaku zrntrkkzktelno1zenkaku}</td><td>（連携用）登録家族１人目電話番号</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzknm218 zrntrkkzknm218}</td><td>（連携用）登録家族名２（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzksei2 zrntrkkzksei2}</td><td>（連携用）登録家族性別２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkseiymd2zenkaku zrntrkkzkseiymd2zenkaku}</td><td>（連携用）登録家族２人目生年月日</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkyno2zenkaku zrntrkkzkyno2zenkaku}</td><td>（連携用）登録家族２人目郵便番号</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzkadrkj2 zrntrkkzkadrkj2}</td><td>（連携用）登録家族２人目住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzktelno2zenkaku zrntrkkzktelno2zenkaku}</td><td>（連携用）登録家族２人目電話番号</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdairinm18 zrnkykdairinm18}</td><td>（連携用）契約者代理人名（１８桁）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhkndairinm zrnhhkndairinm}</td><td>（連携用）被保険者代理人氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv100 zrnyobiv100}</td><td>（連携用）予備項目Ｖ１００</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmmsgcdue01 zrnhutanhiyustmmsgcdue01}</td><td>（連携用）ご負担費用説明欄メッセージコード表上１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmmsgcdue02 zrnhutanhiyustmmsgcdue02}</td><td>（連携用）ご負担費用説明欄メッセージコード表上２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmmsgcdue03 zrnhutanhiyustmmsgcdue03}</td><td>（連携用）ご負担費用説明欄メッセージコード表上３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmmsgcdue04 zrnhutanhiyustmmsgcdue04}</td><td>（連携用）ご負担費用説明欄メッセージコード表上４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmknsnhyuptn zrnhutanhiyustmknsnhyuptn}</td><td>（連携用）ご負担費用説明欄換算費用パターン</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmmsgcdst01 zrnhutanhiyustmmsgcdst01}</td><td>（連携用）ご負担費用説明欄メッセージコード表下１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmmsgcdst02 zrnhutanhiyustmmsgcdst02}</td><td>（連携用）ご負担費用説明欄メッセージコード表下２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmmsgcdst03 zrnhutanhiyustmmsgcdst03}</td><td>（連携用）ご負担費用説明欄メッセージコード表下３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmytijihiritu zrnhutanhiyustmytijihiritu}</td><td>（連携用）ご負担費用説明欄予定維持費率</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmkyakkjrtmin zrnhutanhiyustmkyakkjrtmin}</td><td>（連携用）ご負担費用説明欄解約控除率最小</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhutanhiyustmkyakkjrtmax zrnhutanhiyustmkyakkjrtmax}</td><td>（連携用）ご負担費用説明欄解約控除率最大</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7x2 zrnyobiv7x2}</td><td>（連携用）予備項目Ｖ７＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdstmmsgcd zrnstdstmmsgcd}</td><td>（連携用）指定代理請求特約説明欄メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsioriwebuktriannaimsgcd zrnsioriwebuktriannaimsgcd}</td><td>（連携用）しおりＷＥＢ受取案内メッセージコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x2 zrnyobiv10x2}</td><td>（連携用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv69 zrnyobiv69}</td><td>（連携用）予備項目Ｖ６９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_SaihakkouHokensyoukenRn
 * @see     PKZT_SaihakkouHokensyoukenRn
 * @see     QZT_SaihakkouHokensyoukenRn
 * @see     GenQZT_SaihakkouHokensyoukenRn
 */
@MappedSuperclass
@Table(name=GenZT_SaihakkouHokensyoukenRn.TABLE_NAME)
@IdClass(value=PKZT_SaihakkouHokensyoukenRn.class)
public abstract class GenZT_SaihakkouHokensyoukenRn extends AbstractExDBEntityForZDB<ZT_SaihakkouHokensyoukenRn, PKZT_SaihakkouHokensyoukenRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SaihakkouHokensyoukenRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNKANRYOUTUUTIDOUHUUKBN = "zrnkanryoutuutidouhuukbn";
    public static final String ZRNSIKIBETUNO            = "zrnsikibetuno";
    public static final String ZRNSTDRSKTIRASIDOUHUUKBN = "zrnstdrsktirasidouhuukbn";
    public static final String ZRNAISYOUMEIKBN          = "zrnaisyoumeikbn";
    public static final String ZRNSAGYOUKBN             = "zrnsagyoukbn";
    public static final String ZRNYAKKANBUNSYONO        = "zrnyakkanbunsyono";
    public static final String ZRNYOBIV23X2             = "zrnyobiv23x2";
    public static final String ZRNHYOUJIRANHIDARIMSGCD1 = "zrnhyoujiranhidarimsgcd1";
    public static final String ZRNHYOUJIRANHIDARIMSGCD2 = "zrnhyoujiranhidarimsgcd2";
    public static final String ZRNHYOUJIRANHIDARIMSGCD3 = "zrnhyoujiranhidarimsgcd3";
    public static final String ZRNHYOUJIRANHIDARIMSGCD4 = "zrnhyoujiranhidarimsgcd4";
    public static final String ZRNHYOUJIRANHIDARIMSGCD5 = "zrnhyoujiranhidarimsgcd5";
    public static final String ZRNHYOUJIRANHIDARIMSGCD6 = "zrnhyoujiranhidarimsgcd6";
    public static final String ZRNHYOUJIRANHIDARIMSGCD7 = "zrnhyoujiranhidarimsgcd7";
    public static final String ZRNHYOUJIRANHIDARIMSGCD8 = "zrnhyoujiranhidarimsgcd8";
    public static final String ZRNHYOUJIRANHIDARIMSGCD9 = "zrnhyoujiranhidarimsgcd9";
    public static final String ZRNHYOUJIRANHIDARIMSGCD10 = "zrnhyoujiranhidarimsgcd10";
    public static final String ZRNHYOUJIRANHIDARIMSGCD11 = "zrnhyoujiranhidarimsgcd11";
    public static final String ZRNHYOUJIRANHIDARIMSGCD12 = "zrnhyoujiranhidarimsgcd12";
    public static final String ZRNHYOUJIRANHIDARIMSGCD13 = "zrnhyoujiranhidarimsgcd13";
    public static final String ZRNHYOUJIRANHIDARIMSGCD14 = "zrnhyoujiranhidarimsgcd14";
    public static final String ZRNHYOUJIRANHIDARIMSGCD15 = "zrnhyoujiranhidarimsgcd15";
    public static final String ZRNHYOUJIRANHIDARIMSGCD16 = "zrnhyoujiranhidarimsgcd16";
    public static final String ZRNHYOUJIRANHIDARIMSGCD17 = "zrnhyoujiranhidarimsgcd17";
    public static final String ZRNHYOUJIRANHIDARIMSGCD18 = "zrnhyoujiranhidarimsgcd18";
    public static final String ZRNHYOUJIRANHIDARIMSGCD19 = "zrnhyoujiranhidarimsgcd19";
    public static final String ZRNHYOUJIRANHIDARIMSGCD20 = "zrnhyoujiranhidarimsgcd20";
    public static final String ZRNHYOUJIRANMIGIMSGCD1   = "zrnhyoujiranmigimsgcd1";
    public static final String ZRNHYOUJIRANMIGIMSGCD2   = "zrnhyoujiranmigimsgcd2";
    public static final String ZRNHYOUJIRANMIGIMSGCD3   = "zrnhyoujiranmigimsgcd3";
    public static final String ZRNHYOUJIRANMIGIMSGCD4   = "zrnhyoujiranmigimsgcd4";
    public static final String ZRNHYOUJIRANMIGIMSGCD5   = "zrnhyoujiranmigimsgcd5";
    public static final String ZRNHYOUJIRANMIGIMSGCD6   = "zrnhyoujiranmigimsgcd6";
    public static final String ZRNHYOUJIRANMIGIMSGCD7   = "zrnhyoujiranmigimsgcd7";
    public static final String ZRNHYOUJIRANMIGIMSGCD8   = "zrnhyoujiranmigimsgcd8";
    public static final String ZRNHYOUJIRANMIGIMSGCD9   = "zrnhyoujiranmigimsgcd9";
    public static final String ZRNHYOUJIRANMIGIMSGCD10  = "zrnhyoujiranmigimsgcd10";
    public static final String ZRNHYOUJIRANMIGIMSGCD11  = "zrnhyoujiranmigimsgcd11";
    public static final String ZRNHYOUJIRANMIGIMSGCD12  = "zrnhyoujiranmigimsgcd12";
    public static final String ZRNHYOUJIRANMIGIMSGCD13  = "zrnhyoujiranmigimsgcd13";
    public static final String ZRNHYOUJIRANMIGIMSGCD14  = "zrnhyoujiranmigimsgcd14";
    public static final String ZRNHYOUJIRANMIGIMSGCD15  = "zrnhyoujiranmigimsgcd15";
    public static final String ZRNHYOUJIRANMIGIMSGCD16  = "zrnhyoujiranmigimsgcd16";
    public static final String ZRNHYOUJIRANMIGIMSGCD17  = "zrnhyoujiranmigimsgcd17";
    public static final String ZRNHYOUJIRANMIGIMSGCD18  = "zrnhyoujiranmigimsgcd18";
    public static final String ZRNHYOUJIRANMIGIMSGCD19  = "zrnhyoujiranmigimsgcd19";
    public static final String ZRNHYOUJIRANMIGIMSGCD20  = "zrnhyoujiranmigimsgcd20";
    public static final String ZRNSKNNKAISIYMDSEIREKI   = "zrnsknnkaisiymdseireki";
    public static final String ZRNHYOUJIRANYTIRRT       = "zrnhyoujiranytirrt";
    public static final String ZRNHYOUJIRANSJKKKTUSIRRT = "zrnhyoujiransjkkktusirrt";
    public static final String ZRNHYOUJIRANTUMITATERIRITU = "zrnhyoujirantumitateriritu";
    public static final String ZRNHYOUJIRANTUMITATERIRITU2 = "zrnhyoujirantumitateriritu2";
    public static final String ZRNHYOUJIRANTMTTKNZKRTJYGN = "zrnhyoujirantmttknzkrtjygn";
    public static final String ZRNHYOUJIRANSETTEIBAIRITU = "zrnhyoujiransetteibairitu";
    public static final String ZRNYOBIV22X11            = "zrnyobiv22x11";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNSYOUKENHAKKOUYMD      = "zrnsyoukenhakkouymd";
    public static final String ZRNKOURYOKUKAISIMSG      = "zrnkouryokukaisimsg";
    public static final String ZRNSEISIKIHKNNMSYOUKEN   = "zrnseisikihknnmsyouken";
    public static final String ZRNNKSYURUINMSYOUKEN     = "zrnnksyuruinmsyouken";
    public static final String ZRNYOBIV116              = "zrnyobiv116";
    public static final String ZRNKYKNMKJ               = "zrnkyknmkj";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNHIHKNSYASEIYMDWAREKI  = "zrnhihknsyaseiymdwareki";
    public static final String ZRNHHKNSEI               = "zrnhhknsei";
    public static final String ZRNHHKNNEN2              = "zrnhhknnen2";
    public static final String ZRNUKTMIDASIKBN1         = "zrnuktmidasikbn1";
    public static final String ZRNUKTKBN1               = "zrnuktkbn1";
    public static final String ZRNUKTNM1                = "zrnuktnm1";
    public static final String ZRNUKTBNWARI1            = "zrnuktbnwari1";
    public static final String ZRNUKTMIDASIKBN2         = "zrnuktmidasikbn2";
    public static final String ZRNUKTKBN2               = "zrnuktkbn2";
    public static final String ZRNUKTNM2                = "zrnuktnm2";
    public static final String ZRNUKTBNWARI2            = "zrnuktbnwari2";
    public static final String ZRNUKTMIDASIKBN3         = "zrnuktmidasikbn3";
    public static final String ZRNUKTKBN3               = "zrnuktkbn3";
    public static final String ZRNUKTNM3                = "zrnuktnm3";
    public static final String ZRNUKTBNWARI3            = "zrnuktbnwari3";
    public static final String ZRNUKTMIDASIKBN4         = "zrnuktmidasikbn4";
    public static final String ZRNUKTKBN4               = "zrnuktkbn4";
    public static final String ZRNUKTNM4                = "zrnuktnm4";
    public static final String ZRNUKTBNWARI4            = "zrnuktbnwari4";
    public static final String ZRNUKTMIDASIKBN5         = "zrnuktmidasikbn5";
    public static final String ZRNUKTKBN5               = "zrnuktkbn5";
    public static final String ZRNUKTNM5                = "zrnuktnm5";
    public static final String ZRNUKTBNWARI5            = "zrnuktbnwari5";
    public static final String ZRNUKTMIDASIKBN6         = "zrnuktmidasikbn6";
    public static final String ZRNUKTKBN6               = "zrnuktkbn6";
    public static final String ZRNUKTNM6                = "zrnuktnm6";
    public static final String ZRNUKTBNWARI6            = "zrnuktbnwari6";
    public static final String ZRNUKTMIDASIKBN7         = "zrnuktmidasikbn7";
    public static final String ZRNUKTKBN7               = "zrnuktkbn7";
    public static final String ZRNUKTNM7                = "zrnuktnm7";
    public static final String ZRNUKTBNWARI7            = "zrnuktbnwari7";
    public static final String ZRNUKTMIDASIKBN8         = "zrnuktmidasikbn8";
    public static final String ZRNUKTKBN8               = "zrnuktkbn8";
    public static final String ZRNUKTNM8                = "zrnuktnm8";
    public static final String ZRNUKTBNWARI8            = "zrnuktbnwari8";
    public static final String ZRNUKTMIDASIKBN9         = "zrnuktmidasikbn9";
    public static final String ZRNUKTKBN9               = "zrnuktkbn9";
    public static final String ZRNUKTNM9                = "zrnuktnm9";
    public static final String ZRNUKTBNWARI9            = "zrnuktbnwari9";
    public static final String ZRNUKTMIDASIKBN10        = "zrnuktmidasikbn10";
    public static final String ZRNUKTKBN10              = "zrnuktkbn10";
    public static final String ZRNUKTNM10               = "zrnuktnm10";
    public static final String ZRNUKTBNWARI10           = "zrnuktbnwari10";
    public static final String ZRNYOBIV45               = "zrnyobiv45";
    public static final String ZRNPMSGCD1               = "zrnpmsgcd1";
    public static final String ZRNPMSGCD2               = "zrnpmsgcd2";
    public static final String ZRNPMSGCD3               = "zrnpmsgcd3";
    public static final String ZRNYOBIV10               = "zrnyobiv10";
    public static final String ZRNPTUUKATYPE            = "zrnptuukatype";
    public static final String ZRNPKNGK                 = "zrnpkngk";
    public static final String ZRNPKNGKTUUKA            = "zrnpkngktuuka";
    public static final String ZRNTEIKIIKKATUBARAITUKISUU = "zrnteikiikkatubaraitukisuu";
    public static final String ZRNZTIKIKTBRIYHRKGKTUKTYPE = "zrnztikiktbriyhrkgktuktype";
    public static final String ZRNZNNTIKIKTBRIYENHRKGK  = "zrnznntikiktbriyenhrkgk";
    public static final String ZRNZNNKAI                = "zrnznnkai";
    public static final String ZRNPTOKUYAKUMSGCD        = "zrnptokuyakumsgcd";
    public static final String ZRNTIKIKTBRIYHRKGKTUKTYPE = "zrntikiktbriyhrkgktuktype";
    public static final String ZRNTIKIKTBRIYENHRKGK     = "zrntikiktbriyenhrkgk";
    public static final String ZRNYOBIV32               = "zrnyobiv32";
    public static final String ZRNKYKYMDSEIREKI         = "zrnkykymdseireki";
    public static final String ZRNPHRKKKNMIDASIKBN      = "zrnphrkkknmidasikbn";
    public static final String ZRNHRKKKNMSGKBN          = "zrnhrkkknmsgkbn";
    public static final String ZRNHRKKAISUUMSGKBN       = "zrnhrkkaisuumsgkbn";
    public static final String ZRNPHRKKTUKI             = "zrnphrkktuki";
    public static final String ZRNHRKHOUHOUMSGKBN       = "zrnhrkhouhoumsgkbn";
    public static final String ZRNYOBIV18               = "zrnyobiv18";
    public static final String ZRNSYUKYKTKYKRENBAN1     = "zrnsyukyktkykrenban1";
    public static final String ZRNSYUKYKTKYKMSGKBN1     = "zrnsyukyktkykmsgkbn1";
    public static final String ZRNSYUKYKTKYKSMSGKBN1    = "zrnsyukyktkyksmsgkbn1";
    public static final String ZRNSYUKYKTKYKHKNKKNMSGKBN1 = "zrnsyukyktkykhknkknmsgkbn1";
    public static final String ZRNSYUKYKTKYKSTUUKATYPE1 = "zrnsyukyktkykstuukatype1";
    public static final String ZRNSYUKYKTKYKHKNKNGK1    = "zrnsyukyktkykhknkngk1";
    public static final String ZRNSYUTKDAI1HKNKKNYMDTO1 = "zrnsyutkdai1hknkknymdto1";
    public static final String ZRNSYUTKDAI2HKNKKNYMDTO1 = "zrnsyutkdai2hknkknymdto1";
    public static final String ZRNYOBIV22               = "zrnyobiv22";
    public static final String ZRNSYUKYKTKYKRENBAN2     = "zrnsyukyktkykrenban2";
    public static final String ZRNSYUKYKTKYKMSGKBN2     = "zrnsyukyktkykmsgkbn2";
    public static final String ZRNSYUKYKTKYKSMSGKBN2    = "zrnsyukyktkyksmsgkbn2";
    public static final String ZRNSYUKYKTKYKHKNKKNMSGKBN2 = "zrnsyukyktkykhknkknmsgkbn2";
    public static final String ZRNSYUKYKTKYKSTUUKATYPE2 = "zrnsyukyktkykstuukatype2";
    public static final String ZRNSYUKYKTKYKHKNKNGK2    = "zrnsyukyktkykhknkngk2";
    public static final String ZRNSYUTKDAI1HKNKKNYMDTO2 = "zrnsyutkdai1hknkknymdto2";
    public static final String ZRNSYUTKDAI2HKNKKNYMDTO2 = "zrnsyutkdai2hknkknymdto2";
    public static final String ZRNYOBIV22X2             = "zrnyobiv22x2";
    public static final String ZRNSYUKYKTKYKRENBAN3     = "zrnsyukyktkykrenban3";
    public static final String ZRNSYUKYKTKYKMSGKBN3     = "zrnsyukyktkykmsgkbn3";
    public static final String ZRNSYUKYKTKYKSMSGKBN3    = "zrnsyukyktkyksmsgkbn3";
    public static final String ZRNSYUKYKTKYKHKNKKNMSGKBN3 = "zrnsyukyktkykhknkknmsgkbn3";
    public static final String ZRNSYUKYKTKYKSTUUKATYPE3 = "zrnsyukyktkykstuukatype3";
    public static final String ZRNSYUKYKTKYKHKNKNGK3    = "zrnsyukyktkykhknkngk3";
    public static final String ZRNSYUTKDAI1HKNKKNYMDTO3 = "zrnsyutkdai1hknkknymdto3";
    public static final String ZRNSYUTKDAI2HKNKKNYMDTO3 = "zrnsyutkdai2hknkknymdto3";
    public static final String ZRNYOBIV22X3             = "zrnyobiv22x3";
    public static final String ZRNSYUKYKTKYKRENBAN4     = "zrnsyukyktkykrenban4";
    public static final String ZRNSYUKYKTKYKMSGKBN4     = "zrnsyukyktkykmsgkbn4";
    public static final String ZRNSYUKYKTKYKSMSGKBN4    = "zrnsyukyktkyksmsgkbn4";
    public static final String ZRNSYUKYKTKYKHKNKKNMSGKBN4 = "zrnsyukyktkykhknkknmsgkbn4";
    public static final String ZRNSYUKYKTKYKSTUUKATYPE4 = "zrnsyukyktkykstuukatype4";
    public static final String ZRNSYUKYKTKYKHKNKNGK4    = "zrnsyukyktkykhknkngk4";
    public static final String ZRNSYUTKDAI1HKNKKNYMDTO4 = "zrnsyutkdai1hknkknymdto4";
    public static final String ZRNSYUTKDAI2HKNKKNYMDTO4 = "zrnsyutkdai2hknkknymdto4";
    public static final String ZRNYOBIV22X4             = "zrnyobiv22x4";
    public static final String ZRNSYUKYKTKYKRENBAN5     = "zrnsyukyktkykrenban5";
    public static final String ZRNSYUKYKTKYKMSGKBN5     = "zrnsyukyktkykmsgkbn5";
    public static final String ZRNSYUKYKTKYKSMSGKBN5    = "zrnsyukyktkyksmsgkbn5";
    public static final String ZRNSYUKYKTKYKHKNKKNMSGKBN5 = "zrnsyukyktkykhknkknmsgkbn5";
    public static final String ZRNSYUKYKTKYKSTUUKATYPE5 = "zrnsyukyktkykstuukatype5";
    public static final String ZRNSYUKYKTKYKHKNKNGK5    = "zrnsyukyktkykhknkngk5";
    public static final String ZRNSYUTKDAI1HKNKKNYMDTO5 = "zrnsyutkdai1hknkknymdto5";
    public static final String ZRNSYUTKDAI2HKNKKNYMDTO5 = "zrnsyutkdai2hknkknymdto5";
    public static final String ZRNYOBIV22X5             = "zrnyobiv22x5";
    public static final String ZRNSYUKYKTKYKRENBAN6     = "zrnsyukyktkykrenban6";
    public static final String ZRNSYUKYKTKYKMSGKBN6     = "zrnsyukyktkykmsgkbn6";
    public static final String ZRNSYUKYKTKYKSMSGKBN6    = "zrnsyukyktkyksmsgkbn6";
    public static final String ZRNSYUKYKTKYKHKNKKNMSGKBN6 = "zrnsyukyktkykhknkknmsgkbn6";
    public static final String ZRNSYUKYKTKYKSTUUKATYPE6 = "zrnsyukyktkykstuukatype6";
    public static final String ZRNSYUKYKTKYKHKNKNGK6    = "zrnsyukyktkykhknkngk6";
    public static final String ZRNSYUTKDAI1HKNKKNYMDTO6 = "zrnsyutkdai1hknkknymdto6";
    public static final String ZRNSYUTKDAI2HKNKKNYMDTO6 = "zrnsyutkdai2hknkknymdto6";
    public static final String ZRNYOBIV22X6             = "zrnyobiv22x6";
    public static final String ZRNSYUKYKTKYKRENBAN7     = "zrnsyukyktkykrenban7";
    public static final String ZRNSYUKYKTKYKMSGKBN7     = "zrnsyukyktkykmsgkbn7";
    public static final String ZRNSYUKYKTKYKSMSGKBN7    = "zrnsyukyktkyksmsgkbn7";
    public static final String ZRNSYUKYKTKYKHKNKKNMSGKBN7 = "zrnsyukyktkykhknkknmsgkbn7";
    public static final String ZRNSYUKYKTKYKSTUUKATYPE7 = "zrnsyukyktkykstuukatype7";
    public static final String ZRNSYUKYKTKYKHKNKNGK7    = "zrnsyukyktkykhknkngk7";
    public static final String ZRNSYUTKDAI1HKNKKNYMDTO7 = "zrnsyutkdai1hknkknymdto7";
    public static final String ZRNSYUTKDAI2HKNKKNYMDTO7 = "zrnsyutkdai2hknkknymdto7";
    public static final String ZRNYOBIV22X7             = "zrnyobiv22x7";
    public static final String ZRNSYUKYKTKYKRENBAN8     = "zrnsyukyktkykrenban8";
    public static final String ZRNSYUKYKTKYKMSGKBN8     = "zrnsyukyktkykmsgkbn8";
    public static final String ZRNSYUKYKTKYKSMSGKBN8    = "zrnsyukyktkyksmsgkbn8";
    public static final String ZRNSYUKYKTKYKHKNKKNMSGKBN8 = "zrnsyukyktkykhknkknmsgkbn8";
    public static final String ZRNSYUKYKTKYKSTUUKATYPE8 = "zrnsyukyktkykstuukatype8";
    public static final String ZRNSYUKYKTKYKHKNKNGK8    = "zrnsyukyktkykhknkngk8";
    public static final String ZRNSYUTKDAI1HKNKKNYMDTO8 = "zrnsyutkdai1hknkknymdto8";
    public static final String ZRNSYUTKDAI2HKNKKNYMDTO8 = "zrnsyutkdai2hknkknymdto8";
    public static final String ZRNYOBIV22X8             = "zrnyobiv22x8";
    public static final String ZRNSYUKYKTKYKRENBAN9     = "zrnsyukyktkykrenban9";
    public static final String ZRNSYUKYKTKYKMSGKBN9     = "zrnsyukyktkykmsgkbn9";
    public static final String ZRNSYUKYKTKYKSMSGKBN9    = "zrnsyukyktkyksmsgkbn9";
    public static final String ZRNSYUKYKTKYKHKNKKNMSGKBN9 = "zrnsyukyktkykhknkknmsgkbn9";
    public static final String ZRNSYUKYKTKYKSTUUKATYPE9 = "zrnsyukyktkykstuukatype9";
    public static final String ZRNSYUKYKTKYKHKNKNGK9    = "zrnsyukyktkykhknkngk9";
    public static final String ZRNSYUTKDAI1HKNKKNYMDTO9 = "zrnsyutkdai1hknkknymdto9";
    public static final String ZRNSYUTKDAI2HKNKKNYMDTO9 = "zrnsyutkdai2hknkknymdto9";
    public static final String ZRNYOBIV22X9             = "zrnyobiv22x9";
    public static final String ZRNSYUKYKTKYKRENBAN10    = "zrnsyukyktkykrenban10";
    public static final String ZRNSYUKYKTKYKMSGKBN10    = "zrnsyukyktkykmsgkbn10";
    public static final String ZRNSYUKYKTKYKSMSGKBN10   = "zrnsyukyktkyksmsgkbn10";
    public static final String ZRNSYUKYKTKYKHKNKKNMSGKBN10 = "zrnsyukyktkykhknkknmsgkbn10";
    public static final String ZRNSYUKYKTKYKSTUUKATYPE10 = "zrnsyukyktkykstuukatype10";
    public static final String ZRNSYUKYKTKYKHKNKNGK10   = "zrnsyukyktkykhknkngk10";
    public static final String ZRNSYUTKDAI1HKNKKNYMDTO10 = "zrnsyutkdai1hknkknymdto10";
    public static final String ZRNSYUTKDAI2HKNKKNYMDTO10 = "zrnsyutkdai2hknkknymdto10";
    public static final String ZRNYOBIV22X10            = "zrnyobiv22x10";
    public static final String ZRNYOBIV50               = "zrnyobiv50";
    public static final String ZRNKYKNIYUSTMSGCD1       = "zrnkykniyustmsgcd1";
    public static final String ZRNKYKNIYUSTMSGCD2       = "zrnkykniyustmsgcd2";
    public static final String ZRNKYKNIYUSTMSGCD3       = "zrnkykniyustmsgcd3";
    public static final String ZRNKYKNIYUSTMSGCD4       = "zrnkykniyustmsgcd4";
    public static final String ZRNKYKNIYUSTMSGCD5       = "zrnkykniyustmsgcd5";
    public static final String ZRNKYKNIYUSTMSGCD6       = "zrnkykniyustmsgcd6";
    public static final String ZRNKYKNIYUSTMSGCD7       = "zrnkykniyustmsgcd7";
    public static final String ZRNKYKNIYUSTMSGCD8       = "zrnkykniyustmsgcd8";
    public static final String ZRNKYKNIYUSTMSGCD9       = "zrnkykniyustmsgcd9";
    public static final String ZRNKYKNIYUSTMSGCD10      = "zrnkykniyustmsgcd10";
    public static final String ZRNKYKNIYUSTMSGCD11      = "zrnkykniyustmsgcd11";
    public static final String ZRNKYKNIYUSTMSGCD12      = "zrnkykniyustmsgcd12";
    public static final String ZRNKYKNIYUSTMSGCD13      = "zrnkykniyustmsgcd13";
    public static final String ZRNKYKNIYUSTMSGCD14      = "zrnkykniyustmsgcd14";
    public static final String ZRNKYKNIYUSTMSGCD15      = "zrnkykniyustmsgcd15";
    public static final String ZRNKYKNIYUSTITJBRPTUUKTYPE = "zrnkykniyustitjbrptuuktype";
    public static final String ZRNKYKNIYUSTITJBRP       = "zrnkykniyustitjbrp";
    public static final String ZRNKYKNIYUSTKIHONSTYPE   = "zrnkykniyustkihonstype";
    public static final String ZRNKYKNIYUSTKIHONS       = "zrnkykniyustkihons";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNSONOTANYRANMSGCD1     = "zrnsonotanyranmsgcd1";
    public static final String ZRNSONOTANYRANMSGCD2     = "zrnsonotanyranmsgcd2";
    public static final String ZRNSONOTANYRANMSGCD3     = "zrnsonotanyranmsgcd3";
    public static final String ZRNSONOTANYRANMSGCD4     = "zrnsonotanyranmsgcd4";
    public static final String ZRNSONOTANYRANMSGCD5     = "zrnsonotanyranmsgcd5";
    public static final String ZRNSONOTANYRANMSGCD6     = "zrnsonotanyranmsgcd6";
    public static final String ZRNSONOTANYRANMSGCD7     = "zrnsonotanyranmsgcd7";
    public static final String ZRNSONOTANYRANMSGCD8     = "zrnsonotanyranmsgcd8";
    public static final String ZRNSONOTANYRANMSGCD9     = "zrnsonotanyranmsgcd9";
    public static final String ZRNSONOTANYRANMSGCD10    = "zrnsonotanyranmsgcd10";
    public static final String ZRNSONOTANYRANMSGCD11    = "zrnsonotanyranmsgcd11";
    public static final String ZRNSONOTANYRANMSGCD12    = "zrnsonotanyranmsgcd12";
    public static final String ZRNSONOTANYRANMSGCD13    = "zrnsonotanyranmsgcd13";
    public static final String ZRNSONOTANYRANMSGCD14    = "zrnsonotanyranmsgcd14";
    public static final String ZRNSONOTANYRANMSGCD15    = "zrnsonotanyranmsgcd15";
    public static final String ZRNSONOTANYRANMSGCD16    = "zrnsonotanyranmsgcd16";
    public static final String ZRNSONOTANYRANMSGCD17    = "zrnsonotanyranmsgcd17";
    public static final String ZRNSONOTANYRANMSGCD18    = "zrnsonotanyranmsgcd18";
    public static final String ZRNSONOTANYRANMSGCD19    = "zrnsonotanyranmsgcd19";
    public static final String ZRNSONOTANYRANMSGCD20    = "zrnsonotanyranmsgcd20";
    public static final String ZRNSONOTANYRANSITEITUUKA = "zrnsonotanyransiteituuka";
    public static final String ZRNSONOTANYRANNYKNTUKTYPE = "zrnsonotanyrannykntuktype";
    public static final String ZRNSONOTANYRANNYKNTUUKAP = "zrnsonotanyrannykntuukap";
    public static final String ZRNSONOTANYRANNYKNTUUKASYU = "zrnsonotanyrannykntuukasyu";
    public static final String ZRNSONOTANYRANENKHRIKMRATE = "zrnsonotanyranenkhrikmrate";
    public static final String ZRNSONOTANYRANSTIGIKWSRATE = "zrnsonotanyranstigikwsrate";
    public static final String ZRNSONOTANYKJNKNGKTUKTYPE = "zrnsonotanykjnkngktuktype";
    public static final String ZRNSONOTANYKJNKNGK       = "zrnsonotanykjnkngk";
    public static final String ZRNSONOTANYKJNKNGKRATE   = "zrnsonotanykjnkngkrate";
    public static final String ZRNSONOTANYKJNKNGKTUUKA  = "zrnsonotanykjnkngktuuka";
    public static final String ZRNSONOTANYRANPENTUKTYPE = "zrnsonotanyranpentuktype";
    public static final String ZRNSONOTANYRANPENKNSNGK  = "zrnsonotanyranpenknsngk";
    public static final String ZRNPMKHTOUTATUWARIAI     = "zrnpmkhtoutatuwariai";
    public static final String ZRNSONOTANYRANMKHGK      = "zrnsonotanyranmkhgk";
    public static final String ZRNSONOTANYRANNKSHRSTARTYMD = "zrnsonotanyrannkshrstartymd";
    public static final String ZRNSONOTANYRANNKKKN      = "zrnsonotanyrannkkkn";
    public static final String ZRNSONOTANYYENSYSNHKHNKYMD = "zrnsonotanyyensysnhkhnkymd";
    public static final String ZRNSONOTANYTMTTKNGKTUKTYPE = "zrnsonotanytmttkngktuktype";
    public static final String ZRNSONOTANYTEIRITUTMTTKNGK = "zrnsonotanyteiritutmttkngk";
    public static final String ZRNSONOTANYRANSISUUTMTTKNGK = "zrnsonotanyransisuutmttkngk";
    public static final String ZRNSONOTANYRANSISUUNM    = "zrnsonotanyransisuunm";
    public static final String ZRNSONOTANYRENDOURITU    = "zrnsonotanyrendouritu";
    public static final String ZRNSONOTANYTEIKISIHARAIKIN = "zrnsonotanyteikisiharaikin";
    public static final String ZRNSONOTANYRANGAIMSGCD   = "zrnsonotanyrangaimsgcd";
    public static final String ZRNYOBIV6                = "zrnyobiv6";
    public static final String ZRNHOSYOUNYMSGCD         = "zrnhosyounymsgcd";
    public static final String ZRNYOBIV15               = "zrnyobiv15";
    public static final String ZRNHOSYOUNYHIHKNSYANMKANJI = "zrnhosyounyhihknsyanmkanji";
    public static final String ZRNYOBIV24               = "zrnyobiv24";
    public static final String ZRNSIBOUMIDASIMSGCD      = "zrnsiboumidasimsgcd";
    public static final String ZRNSIBOUMIDASIMSGCD2     = "zrnsiboumidasimsgcd2";
    public static final String ZRNSIBOUDAI1HKNKKNMSGCD1 = "zrnsiboudai1hknkknmsgcd1";
    public static final String ZRNSIBOUDAI1HKNKKNMSGCD2 = "zrnsiboudai1hknkknmsgcd2";
    public static final String ZRNSIBOUDAI1HKNKKNIGIMSGCD = "zrnsiboudai1hknkknigimsgcd";
    public static final String ZRNSIBOUDAI1HKNKKNIGIMSGCD2 = "zrnsiboudai1hknkknigimsgcd2";
    public static final String ZRNSIBOUDAI1HKNKKNHRSMSGCD = "zrnsiboudai1hknkknhrsmsgcd";
    public static final String ZRNSIBOUDAI1HKNKKNHRSMSGCD2 = "zrnsiboudai1hknkknhrsmsgcd2";
    public static final String ZRNSIBOUDAI1HKNKKNSMRMSGCD = "zrnsiboudai1hknkknsmrmsgcd";
    public static final String ZRNSIBOUDAI2HKNKKNMSGCD1 = "zrnsiboudai2hknkknmsgcd1";
    public static final String ZRNSIBOUDAI2HKNKKNMSGCD2 = "zrnsiboudai2hknkknmsgcd2";
    public static final String ZRNSIBOUDAI2HKNKKNSMSGCD = "zrnsiboudai2hknkknsmsgcd";
    public static final String ZRNSIBOUDAI2HKNKKNSMSGCD2 = "zrnsiboudai2hknkknsmsgcd2";
    public static final String ZRNSIBOUDAI3HKNKKNMSGCD1 = "zrnsiboudai3hknkknmsgcd1";
    public static final String ZRNSIBOUDAI3HKNKKNMSGCD2 = "zrnsiboudai3hknkknmsgcd2";
    public static final String ZRNYOBIV15X2             = "zrnyobiv15x2";
    public static final String ZRNSIBOUDAI1HKNKKNYMDTO  = "zrnsiboudai1hknkknymdto";
    public static final String ZRNSIBOUITJBRPYENTUUKTYPE = "zrnsibouitjbrpyentuuktype";
    public static final String ZRNSIBOUITJBRPYENTUUKGK  = "zrnsibouitjbrpyentuukgk";
    public static final String ZRNSIBOUDAI1KJNKNGKTUKTYPE = "zrnsiboudai1kjnkngktuktype";
    public static final String ZRNSIBOUDAI1KJNKNGK      = "zrnsiboudai1kjnkngk";
    public static final String ZRNSIBOUDAI2HKNKKNYMDTO  = "zrnsiboudai2hknkknymdto";
    public static final String ZRNSIBOUDAI2KJNKNGKTUKTYPE = "zrnsiboudai2kjnkngktuktype";
    public static final String ZRNSIBOUDAI2KJNKNGK      = "zrnsiboudai2kjnkngk";
    public static final String ZRNSIBOUDAI3KJNKNGKTUKTYPE = "zrnsiboudai3kjnkngktuktype";
    public static final String ZRNSIBOUDAI3KJNKNGK      = "zrnsiboudai3kjnkngk";
    public static final String ZRNYOBIV23               = "zrnyobiv23";
    public static final String ZRNDAI1SKWSRATEYENDAKA   = "zrndai1skwsrateyendaka";
    public static final String ZRNDAI1SKWSRATEYENKIJYUN = "zrndai1skwsrateyenkijyun";
    public static final String ZRNDAI1SKWSRATEYENYASU   = "zrndai1skwsrateyenyasu";
    public static final String ZRNDAI1SIBOUSNENOUTOUYMD1 = "zrndai1sibousnenoutouymd1";
    public static final String ZRNDAI1STUUKTYPE01       = "zrndai1stuuktype01";
    public static final String ZRNDAI1S01               = "zrndai1s01";
    public static final String ZRNDAI1SYENYENDAKAUMU01  = "zrndai1syenyendakaumu01";
    public static final String ZRNDAI1SYENYENKIJYUNUMU01 = "zrndai1syenyenkijyunumu01";
    public static final String ZRNDAI1SYENYENYASUUMU01  = "zrndai1syenyenyasuumu01";
    public static final String ZRNDAI1SYENTUUKTYPE01    = "zrndai1syentuuktype01";
    public static final String ZRNDAI1SYENYENDAKA01     = "zrndai1syenyendaka01";
    public static final String ZRNDAI1SYENYENKIJYUN01   = "zrndai1syenyenkijyun01";
    public static final String ZRNDAI1SYENYENYASU01     = "zrndai1syenyenyasu01";
    public static final String ZRNDAI1ZENNOUZNDK01      = "zrndai1zennouzndk01";
    public static final String ZRNDAI1ZENNOUZNDKTYPE01  = "zrndai1zennouzndktype01";
    public static final String ZRNDAI1SBJIUKTGK01       = "zrndai1sbjiuktgk01";
    public static final String ZRNDAI1SBJIUKTGKTYPE01   = "zrndai1sbjiuktgktype01";
    public static final String ZRNDAI1SBJIUKTGKYTYPE01  = "zrndai1sbjiuktgkytype01";
    public static final String ZRNDAI1SBJIUKTGKYDAKA01  = "zrndai1sbjiuktgkydaka01";
    public static final String ZRNDAI1SBJIUKTGKYKIJYUN01 = "zrndai1sbjiuktgkykijyun01";
    public static final String ZRNDAI1SBJIUKTGKYYASU01  = "zrndai1sbjiuktgkyyasu01";
    public static final String ZRNDAI1SIBOUSNENOUTOUYMD2 = "zrndai1sibousnenoutouymd2";
    public static final String ZRNDAI1STUUKTYPE02       = "zrndai1stuuktype02";
    public static final String ZRNDAI1S02               = "zrndai1s02";
    public static final String ZRNDAI1SYENYENDAKAUMU02  = "zrndai1syenyendakaumu02";
    public static final String ZRNDAI1SYENYENKIJYUNUMU02 = "zrndai1syenyenkijyunumu02";
    public static final String ZRNDAI1SYENYENYASUUMU02  = "zrndai1syenyenyasuumu02";
    public static final String ZRNDAI1SYENTUUKTYPE02    = "zrndai1syentuuktype02";
    public static final String ZRNDAI1SYENYENDAKA02     = "zrndai1syenyendaka02";
    public static final String ZRNDAI1SYENYENKIJYUN02   = "zrndai1syenyenkijyun02";
    public static final String ZRNDAI1SYENYENYASU02     = "zrndai1syenyenyasu02";
    public static final String ZRNDAI1ZENNOUZNDK02      = "zrndai1zennouzndk02";
    public static final String ZRNDAI1ZENNOUZNDKTYPE02  = "zrndai1zennouzndktype02";
    public static final String ZRNDAI1SBJIUKTGK02       = "zrndai1sbjiuktgk02";
    public static final String ZRNDAI1SBJIUKTGKTYPE02   = "zrndai1sbjiuktgktype02";
    public static final String ZRNDAI1SBJIUKTGKYTYPE02  = "zrndai1sbjiuktgkytype02";
    public static final String ZRNDAI1SBJIUKTGKYDAKA02  = "zrndai1sbjiuktgkydaka02";
    public static final String ZRNDAI1SBJIUKTGKYKIJYUN02 = "zrndai1sbjiuktgkykijyun02";
    public static final String ZRNDAI1SBJIUKTGKYYASU02  = "zrndai1sbjiuktgkyyasu02";
    public static final String ZRNDAI1SIBOUSNENOUTOUYMD3 = "zrndai1sibousnenoutouymd3";
    public static final String ZRNDAI1STUUKTYPE03       = "zrndai1stuuktype03";
    public static final String ZRNDAI1S03               = "zrndai1s03";
    public static final String ZRNDAI1SYENYENDAKAUMU03  = "zrndai1syenyendakaumu03";
    public static final String ZRNDAI1SYENYENKIJYUNUMU03 = "zrndai1syenyenkijyunumu03";
    public static final String ZRNDAI1SYENYENYASUUMU03  = "zrndai1syenyenyasuumu03";
    public static final String ZRNDAI1SYENTUUKTYPE03    = "zrndai1syentuuktype03";
    public static final String ZRNDAI1SYENYENDAKA03     = "zrndai1syenyendaka03";
    public static final String ZRNDAI1SYENYENKIJYUN03   = "zrndai1syenyenkijyun03";
    public static final String ZRNDAI1SYENYENYASU03     = "zrndai1syenyenyasu03";
    public static final String ZRNDAI1ZENNOUZNDK03      = "zrndai1zennouzndk03";
    public static final String ZRNDAI1ZENNOUZNDKTYPE03  = "zrndai1zennouzndktype03";
    public static final String ZRNDAI1SBJIUKTGK03       = "zrndai1sbjiuktgk03";
    public static final String ZRNDAI1SBJIUKTGKTYPE03   = "zrndai1sbjiuktgktype03";
    public static final String ZRNDAI1SBJIUKTGKYTYPE03  = "zrndai1sbjiuktgkytype03";
    public static final String ZRNDAI1SBJIUKTGKYDAKA03  = "zrndai1sbjiuktgkydaka03";
    public static final String ZRNDAI1SBJIUKTGKYKIJYUN03 = "zrndai1sbjiuktgkykijyun03";
    public static final String ZRNDAI1SBJIUKTGKYYASU03  = "zrndai1sbjiuktgkyyasu03";
    public static final String ZRNDAI1SIBOUSNENOUTOUYMD4 = "zrndai1sibousnenoutouymd4";
    public static final String ZRNDAI1STUUKTYPE04       = "zrndai1stuuktype04";
    public static final String ZRNDAI1S04               = "zrndai1s04";
    public static final String ZRNDAI1SYENYENDAKAUMU04  = "zrndai1syenyendakaumu04";
    public static final String ZRNDAI1SYENYENKIJYUNUMU04 = "zrndai1syenyenkijyunumu04";
    public static final String ZRNDAI1SYENYENYASUUMU04  = "zrndai1syenyenyasuumu04";
    public static final String ZRNDAI1SYENTUUKTYPE04    = "zrndai1syentuuktype04";
    public static final String ZRNDAI1SYENYENDAKA04     = "zrndai1syenyendaka04";
    public static final String ZRNDAI1SYENYENKIJYUN04   = "zrndai1syenyenkijyun04";
    public static final String ZRNDAI1SYENYENYASU04     = "zrndai1syenyenyasu04";
    public static final String ZRNDAI1ZENNOUZNDK04      = "zrndai1zennouzndk04";
    public static final String ZRNDAI1ZENNOUZNDKTYPE04  = "zrndai1zennouzndktype04";
    public static final String ZRNDAI1SBJIUKTGK04       = "zrndai1sbjiuktgk04";
    public static final String ZRNDAI1SBJIUKTGKTYPE04   = "zrndai1sbjiuktgktype04";
    public static final String ZRNDAI1SBJIUKTGKYTYPE04  = "zrndai1sbjiuktgkytype04";
    public static final String ZRNDAI1SBJIUKTGKYDAKA04  = "zrndai1sbjiuktgkydaka04";
    public static final String ZRNDAI1SBJIUKTGKYKIJYUN04 = "zrndai1sbjiuktgkykijyun04";
    public static final String ZRNDAI1SBJIUKTGKYYASU04  = "zrndai1sbjiuktgkyyasu04";
    public static final String ZRNDAI1SIBOUSNENOUTOUYMD5 = "zrndai1sibousnenoutouymd5";
    public static final String ZRNDAI1STUUKTYPE05       = "zrndai1stuuktype05";
    public static final String ZRNDAI1S05               = "zrndai1s05";
    public static final String ZRNDAI1SYENYENDAKAUMU05  = "zrndai1syenyendakaumu05";
    public static final String ZRNDAI1SYENYENKIJYUNUMU05 = "zrndai1syenyenkijyunumu05";
    public static final String ZRNDAI1SYENYENYASUUMU05  = "zrndai1syenyenyasuumu05";
    public static final String ZRNDAI1SYENTUUKTYPE05    = "zrndai1syentuuktype05";
    public static final String ZRNDAI1SYENYENDAKA05     = "zrndai1syenyendaka05";
    public static final String ZRNDAI1SYENYENKIJYUN05   = "zrndai1syenyenkijyun05";
    public static final String ZRNDAI1SYENYENYASU05     = "zrndai1syenyenyasu05";
    public static final String ZRNDAI1ZENNOUZNDK05      = "zrndai1zennouzndk05";
    public static final String ZRNDAI1ZENNOUZNDKTYPE05  = "zrndai1zennouzndktype05";
    public static final String ZRNDAI1SBJIUKTGK05       = "zrndai1sbjiuktgk05";
    public static final String ZRNDAI1SBJIUKTGKTYPE05   = "zrndai1sbjiuktgktype05";
    public static final String ZRNDAI1SBJIUKTGKYTYPE05  = "zrndai1sbjiuktgkytype05";
    public static final String ZRNDAI1SBJIUKTGKYDAKA05  = "zrndai1sbjiuktgkydaka05";
    public static final String ZRNDAI1SBJIUKTGKYKIJYUN05 = "zrndai1sbjiuktgkykijyun05";
    public static final String ZRNDAI1SBJIUKTGKYYASU05  = "zrndai1sbjiuktgkyyasu05";
    public static final String ZRNDAI1SIBOUSNENOUTOUYMD6 = "zrndai1sibousnenoutouymd6";
    public static final String ZRNDAI1STUUKTYPE06       = "zrndai1stuuktype06";
    public static final String ZRNDAI1S06               = "zrndai1s06";
    public static final String ZRNDAI1SYENYENDAKAUMU06  = "zrndai1syenyendakaumu06";
    public static final String ZRNDAI1SYENYENKIJYUNUMU06 = "zrndai1syenyenkijyunumu06";
    public static final String ZRNDAI1SYENYENYASUUMU06  = "zrndai1syenyenyasuumu06";
    public static final String ZRNDAI1SYENTUUKTYPE06    = "zrndai1syentuuktype06";
    public static final String ZRNDAI1SYENYENDAKA06     = "zrndai1syenyendaka06";
    public static final String ZRNDAI1SYENYENKIJYUN06   = "zrndai1syenyenkijyun06";
    public static final String ZRNDAI1SYENYENYASU06     = "zrndai1syenyenyasu06";
    public static final String ZRNDAI1ZENNOUZNDK06      = "zrndai1zennouzndk06";
    public static final String ZRNDAI1ZENNOUZNDKTYPE06  = "zrndai1zennouzndktype06";
    public static final String ZRNDAI1SBJIUKTGK06       = "zrndai1sbjiuktgk06";
    public static final String ZRNDAI1SBJIUKTGKTYPE06   = "zrndai1sbjiuktgktype06";
    public static final String ZRNDAI1SBJIUKTGKYTYPE06  = "zrndai1sbjiuktgkytype06";
    public static final String ZRNDAI1SBJIUKTGKYDAKA06  = "zrndai1sbjiuktgkydaka06";
    public static final String ZRNDAI1SBJIUKTGKYKIJYUN06 = "zrndai1sbjiuktgkykijyun06";
    public static final String ZRNDAI1SBJIUKTGKYYASU06  = "zrndai1sbjiuktgkyyasu06";
    public static final String ZRNDAI1SIBOUSNENOUTOUYMD7 = "zrndai1sibousnenoutouymd7";
    public static final String ZRNDAI1STUUKTYPE07       = "zrndai1stuuktype07";
    public static final String ZRNDAI1S07               = "zrndai1s07";
    public static final String ZRNDAI1SYENYENDAKAUMU07  = "zrndai1syenyendakaumu07";
    public static final String ZRNDAI1SYENYENKIJYUNUMU07 = "zrndai1syenyenkijyunumu07";
    public static final String ZRNDAI1SYENYENYASUUMU07  = "zrndai1syenyenyasuumu07";
    public static final String ZRNDAI1SYENTUUKTYPE07    = "zrndai1syentuuktype07";
    public static final String ZRNDAI1SYENYENDAKA07     = "zrndai1syenyendaka07";
    public static final String ZRNDAI1SYENYENKIJYUN07   = "zrndai1syenyenkijyun07";
    public static final String ZRNDAI1SYENYENYASU07     = "zrndai1syenyenyasu07";
    public static final String ZRNDAI1SIBOUSNENOUTOUYMD8 = "zrndai1sibousnenoutouymd8";
    public static final String ZRNDAI1STUUKTYPE08       = "zrndai1stuuktype08";
    public static final String ZRNDAI1S08               = "zrndai1s08";
    public static final String ZRNDAI1SYENYENDAKAUMU08  = "zrndai1syenyendakaumu08";
    public static final String ZRNDAI1SYENYENKIJYUNUMU08 = "zrndai1syenyenkijyunumu08";
    public static final String ZRNDAI1SYENYENYASUUMU08  = "zrndai1syenyenyasuumu08";
    public static final String ZRNDAI1SYENTUUKTYPE08    = "zrndai1syentuuktype08";
    public static final String ZRNDAI1SYENYENDAKA08     = "zrndai1syenyendaka08";
    public static final String ZRNDAI1SYENYENKIJYUN08   = "zrndai1syenyenkijyun08";
    public static final String ZRNDAI1SYENYENYASU08     = "zrndai1syenyenyasu08";
    public static final String ZRNDAI1SIBOUSNENOUTOUYMD9 = "zrndai1sibousnenoutouymd9";
    public static final String ZRNDAI1STUUKTYPE09       = "zrndai1stuuktype09";
    public static final String ZRNDAI1S09               = "zrndai1s09";
    public static final String ZRNDAI1SYENYENDAKAUMU09  = "zrndai1syenyendakaumu09";
    public static final String ZRNDAI1SYENYENKIJYUNUMU09 = "zrndai1syenyenkijyunumu09";
    public static final String ZRNDAI1SYENYENYASUUMU09  = "zrndai1syenyenyasuumu09";
    public static final String ZRNDAI1SYENTUUKTYPE09    = "zrndai1syentuuktype09";
    public static final String ZRNDAI1SYENYENDAKA09     = "zrndai1syenyendaka09";
    public static final String ZRNDAI1SYENYENKIJYUN09   = "zrndai1syenyenkijyun09";
    public static final String ZRNDAI1SYENYENYASU09     = "zrndai1syenyenyasu09";
    public static final String ZRNDAI1SIBOUSNENOUTOUYMD10 = "zrndai1sibousnenoutouymd10";
    public static final String ZRNDAI1STUUKTYPE10       = "zrndai1stuuktype10";
    public static final String ZRNDAI1S10               = "zrndai1s10";
    public static final String ZRNDAI1SYENYENDAKAUMU10  = "zrndai1syenyendakaumu10";
    public static final String ZRNDAI1SYENYENKIJYUNUMU10 = "zrndai1syenyenkijyunumu10";
    public static final String ZRNDAI1SYENYENYASUUMU10  = "zrndai1syenyenyasuumu10";
    public static final String ZRNDAI1SYENTUUKTYPE10    = "zrndai1syentuuktype10";
    public static final String ZRNDAI1SYENYENDAKA10     = "zrndai1syenyendaka10";
    public static final String ZRNDAI1SYENYENKIJYUN10   = "zrndai1syenyenkijyun10";
    public static final String ZRNDAI1SYENYENYASU10     = "zrndai1syenyenyasu10";
    public static final String ZRNDAI1STUUKTYPEHURYO    = "zrndai1stuuktypehuryo";
    public static final String ZRNDAI1SHURYO            = "zrndai1shuryo";
    public static final String ZRNDAI1SYENYENDAKAUMUHURYO = "zrndai1syenyendakaumuhuryo";
    public static final String ZRNDAI1SYENYENKJNUMUHURYO = "zrndai1syenyenkjnumuhuryo";
    public static final String ZRNDAI1SYENYENYASUUMUHURYO = "zrndai1syenyenyasuumuhuryo";
    public static final String ZRNDAI1SYENTUUKTYPEHURYO = "zrndai1syentuuktypehuryo";
    public static final String ZRNDAI1SYENYENDAKAHURYO  = "zrndai1syenyendakahuryo";
    public static final String ZRNDAI1SYENYENKIJYUNHURYO = "zrndai1syenyenkijyunhuryo";
    public static final String ZRNDAI1SYENYENYASUHURYO  = "zrndai1syenyenyasuhuryo";
    public static final String ZRNDAI2STUUKTYPE         = "zrndai2stuuktype";
    public static final String ZRNDAI2S                 = "zrndai2s";
    public static final String ZRNDAI2SYENTUUKTYPE      = "zrndai2syentuuktype";
    public static final String ZRNDAI2SYENYENDAKA       = "zrndai2syenyendaka";
    public static final String ZRNDAI2SYENYENKIJYUN     = "zrndai2syenyenkijyun";
    public static final String ZRNDAI2SYENYENYASU       = "zrndai2syenyenyasu";
    public static final String ZRNDAI3STUUKTYPE         = "zrndai3stuuktype";
    public static final String ZRNDAI3S                 = "zrndai3s";
    public static final String ZRNDAI3SYENTUUKTYPE      = "zrndai3syentuuktype";
    public static final String ZRNDAI3SYENYENDAKA       = "zrndai3syenyendaka";
    public static final String ZRNDAI3SYENYENKIJYUN     = "zrndai3syenyenkijyun";
    public static final String ZRNDAI3SYENYENYASU       = "zrndai3syenyenyasu";
    public static final String ZRNSIBOUINJIPTNKBN       = "zrnsibouinjiptnkbn";
    public static final String ZRNYOBIV25               = "zrnyobiv25";
    public static final String ZRNNKMSGCD1              = "zrnnkmsgcd1";
    public static final String ZRNNKMSGCD2              = "zrnnkmsgcd2";
    public static final String ZRNNKMSGCD3              = "zrnnkmsgcd3";
    public static final String ZRNNKMSGCD4              = "zrnnkmsgcd4";
    public static final String ZRNNKMSGCD5              = "zrnnkmsgcd5";
    public static final String ZRNNKMSGCD6              = "zrnnkmsgcd6";
    public static final String ZRNNKMSGCD7              = "zrnnkmsgcd7";
    public static final String ZRNNKMSGCD8              = "zrnnkmsgcd8";
    public static final String ZRNNKMSGCD9              = "zrnnkmsgcd9";
    public static final String ZRNNKMSGCD10             = "zrnnkmsgcd10";
    public static final String ZRNSIBOUKYUUHUKINMSGCD1  = "zrnsiboukyuuhukinmsgcd1";
    public static final String ZRNSIBOUKYUUHUKINMSGCD2  = "zrnsiboukyuuhukinmsgcd2";
    public static final String ZRNSIBOUKYUUHUKINMSGCD3  = "zrnsiboukyuuhukinmsgcd3";
    public static final String ZRNSIBOUKYUUHUKINMSGCD4  = "zrnsiboukyuuhukinmsgcd4";
    public static final String ZRNSIBOUKYUUHUKINMSGCD5  = "zrnsiboukyuuhukinmsgcd5";
    public static final String ZRNSIBOUKYUUHUKINMSGCD6  = "zrnsiboukyuuhukinmsgcd6";
    public static final String ZRNSIBOUKYUUHUKINMSGCD7  = "zrnsiboukyuuhukinmsgcd7";
    public static final String ZRNSIBOUKYUUHUKINMSGCD8  = "zrnsiboukyuuhukinmsgcd8";
    public static final String ZRNSIBOUKYUUHUKINMSGCD9  = "zrnsiboukyuuhukinmsgcd9";
    public static final String ZRNSIBOUKYUUHUKINMSGCD10 = "zrnsiboukyuuhukinmsgcd10";
    public static final String ZRNNKSHRSTARTZENYMD      = "zrnnkshrstartzenymd";
    public static final String ZRNMKHYOUYENNKHKNHENTKTYPE = "zrnmkhyouyennkhknhentktype";
    public static final String ZRNMKHYOUYENNKHKNHENTKMKHGK = "zrnmkhyouyennkhknhentkmkhgk";
    public static final String ZRNMKHYENNKHKNHENTKMKHWARI = "zrnmkhyennkhknhentkmkhwari";
    public static final String ZRNHAIBUNWARIMSGCD1      = "zrnhaibunwarimsgcd1";
    public static final String ZRNHAIBUNWARIMSGCD2      = "zrnhaibunwarimsgcd2";
    public static final String ZRNHAIBUNWARIMSGCD3      = "zrnhaibunwarimsgcd3";
    public static final String ZRNTEIRITUTMTTHBNWR      = "zrnteiritutmtthbnwr";
    public static final String ZRNSISUUTMTTHBNWR        = "zrnsisuutmtthbnwr";
    public static final String ZRNSISUUANNAIMSG1        = "zrnsisuuannaimsg1";
    public static final String ZRNSISUUANNAIMSG2        = "zrnsisuuannaimsg2";
    public static final String ZRNSISUUANNAIMSG3        = "zrnsisuuannaimsg3";
    public static final String ZRNMKHYOUYENSYSNIKOUMSGCD = "zrnmkhyouyensysnikoumsgcd";
    public static final String ZRNMKHYOUYENSYSNIKOUMSGCD2 = "zrnmkhyouyensysnikoumsgcd2";
    public static final String ZRNMKHYOUYENSYSNIKOUMSGCD3 = "zrnmkhyouyensysnikoumsgcd3";
    public static final String ZRNMKHYOUYENSYSNIKOUGKTYPE = "zrnmkhyouyensysnikougktype";
    public static final String ZRNMKHYOUYENSYSNIKOUGK   = "zrnmkhyouyensysnikougk";
    public static final String ZRNMKHYOUYENSYSNIKOUWRA  = "zrnmkhyouyensysnikouwra";
    public static final String ZRNMKHYOUYSYSNIKCURRENTGK = "zrnmkhyouysysnikcurrentgk";
    public static final String ZRNYOBIV12               = "zrnyobiv12";
    public static final String ZRNKAIGOMAEHRTKYKMSGCD1  = "zrnkaigomaehrtkykmsgcd1";
    public static final String ZRNKAIGOMAEHRTKYKMSGCD2  = "zrnkaigomaehrtkykmsgcd2";
    public static final String ZRNKAIGOMAEHRTKYKMSGCDST1 = "zrnkaigomaehrtkykmsgcdst1";
    public static final String ZRNKAIGOMAEHRTKYKMSGCDST2 = "zrnkaigomaehrtkykmsgcdst2";
    public static final String ZRNKGMAEHRTKHKNKKN1MNRYYMD = "zrnkgmaehrtkhknkkn1mnryymd";
    public static final String ZRNKAIGOMAEHRTKYKITRNUMU = "zrnkaigomaehrtkykitrnumu";
    public static final String ZRNKAIGOMAEHRTKYKKYKTUUKA = "zrnkaigomaehrtkykkyktuuka";
    public static final String ZRNKAIGOMAEHRTKYKSTDMSGCD = "zrnkaigomaehrtkykstdmsgcd";
    public static final String ZRNKAIGOMAEHRJRUGKTYPE   = "zrnkaigomaehrjrugktype";
    public static final String ZRNKAIGOMAEHRSIKUHHKNNEN01 = "zrnkaigomaehrsikuhhknnen01";
    public static final String ZRNKAIGOMAEHRSTIKKN01    = "zrnkaigomaehrstikkn01";
    public static final String ZRNKAIGOMAEHRJRUGK01     = "zrnkaigomaehrjrugk01";
    public static final String ZRNKAIGOMAEHRSIKUHHKNNEN02 = "zrnkaigomaehrsikuhhknnen02";
    public static final String ZRNKAIGOMAEHRSTIKKN02    = "zrnkaigomaehrstikkn02";
    public static final String ZRNKAIGOMAEHRJRUGK02     = "zrnkaigomaehrjrugk02";
    public static final String ZRNKAIGOMAEHRSIKUHHKNNEN03 = "zrnkaigomaehrsikuhhknnen03";
    public static final String ZRNKAIGOMAEHRSTIKKN03    = "zrnkaigomaehrstikkn03";
    public static final String ZRNKAIGOMAEHRJRUGK03     = "zrnkaigomaehrjrugk03";
    public static final String ZRNKAIGOMAEHRSIKUHHKNNEN04 = "zrnkaigomaehrsikuhhknnen04";
    public static final String ZRNKAIGOMAEHRSTIKKN04    = "zrnkaigomaehrstikkn04";
    public static final String ZRNKAIGOMAEHRJRUGK04     = "zrnkaigomaehrjrugk04";
    public static final String ZRNKAIGOMAEHRSIKUHHKNNEN05 = "zrnkaigomaehrsikuhhknnen05";
    public static final String ZRNKAIGOMAEHRSTIKKN05    = "zrnkaigomaehrstikkn05";
    public static final String ZRNKAIGOMAEHRJRUGK05     = "zrnkaigomaehrjrugk05";
    public static final String ZRNKAIGOMAEHRSIKUHHKNNEN06 = "zrnkaigomaehrsikuhhknnen06";
    public static final String ZRNKAIGOMAEHRSTIKKN06    = "zrnkaigomaehrstikkn06";
    public static final String ZRNKAIGOMAEHRJRUGK06     = "zrnkaigomaehrjrugk06";
    public static final String ZRNKAIGOMAEHRSIKUHHKNNEN07 = "zrnkaigomaehrsikuhhknnen07";
    public static final String ZRNKAIGOMAEHRSTIKKN07    = "zrnkaigomaehrstikkn07";
    public static final String ZRNKAIGOMAEHRJRUGK07     = "zrnkaigomaehrjrugk07";
    public static final String ZRNKAIGOMAEHRSIKUHHKNNEN08 = "zrnkaigomaehrsikuhhknnen08";
    public static final String ZRNKAIGOMAEHRSTIKKN08    = "zrnkaigomaehrstikkn08";
    public static final String ZRNKAIGOMAEHRJRUGK08     = "zrnkaigomaehrjrugk08";
    public static final String ZRNKAIGOMAEHRSIKUHHKNNEN09 = "zrnkaigomaehrsikuhhknnen09";
    public static final String ZRNKAIGOMAEHRSTIKKN09    = "zrnkaigomaehrstikkn09";
    public static final String ZRNKAIGOMAEHRJRUGK09     = "zrnkaigomaehrjrugk09";
    public static final String ZRNKAIGOMAEHRSIKUHHKNNEN10 = "zrnkaigomaehrsikuhhknnen10";
    public static final String ZRNKAIGOMAEHRSTIKKN10    = "zrnkaigomaehrstikkn10";
    public static final String ZRNKAIGOMAEHRJRUGK10     = "zrnkaigomaehrjrugk10";
    public static final String ZRNKAIGOMAEHRJRUGKYDAKA01 = "zrnkaigomaehrjrugkydaka01";
    public static final String ZRNKGMAEHRJRUGKYKIJYUN01 = "zrnkgmaehrjrugkykijyun01";
    public static final String ZRNKGMAEHRJRUGKYYASU01   = "zrnkgmaehrjrugkyyasu01";
    public static final String ZRNKAIGOMAEHRJRUGKYDAKA02 = "zrnkaigomaehrjrugkydaka02";
    public static final String ZRNKGMAEHRJRUGKYKIJYUN02 = "zrnkgmaehrjrugkykijyun02";
    public static final String ZRNKGMAEHRJRUGKYYASU02   = "zrnkgmaehrjrugkyyasu02";
    public static final String ZRNKAIGOMAEHRJRUGKYDAKA03 = "zrnkaigomaehrjrugkydaka03";
    public static final String ZRNKGMAEHRJRUGKYKIJYUN03 = "zrnkgmaehrjrugkykijyun03";
    public static final String ZRNKGMAEHRJRUGKYYASU03   = "zrnkgmaehrjrugkyyasu03";
    public static final String ZRNKAIGOMAEHRJRUGKYDAKA04 = "zrnkaigomaehrjrugkydaka04";
    public static final String ZRNKGMAEHRJRUGKYKIJYUN04 = "zrnkgmaehrjrugkykijyun04";
    public static final String ZRNKGMAEHRJRUGKYYASU04   = "zrnkgmaehrjrugkyyasu04";
    public static final String ZRNKAIGOMAEHRJRUGKYDAKA05 = "zrnkaigomaehrjrugkydaka05";
    public static final String ZRNKGMAEHRJRUGKYKIJYUN05 = "zrnkgmaehrjrugkykijyun05";
    public static final String ZRNKGMAEHRJRUGKYYASU05   = "zrnkgmaehrjrugkyyasu05";
    public static final String ZRNKAIGOMAEHRJRUGKYDAKA06 = "zrnkaigomaehrjrugkydaka06";
    public static final String ZRNKGMAEHRJRUGKYKIJYUN06 = "zrnkgmaehrjrugkykijyun06";
    public static final String ZRNKGMAEHRJRUGKYYASU06   = "zrnkgmaehrjrugkyyasu06";
    public static final String ZRNKAIGOMAEHRJRUGKYDAKA07 = "zrnkaigomaehrjrugkydaka07";
    public static final String ZRNKGMAEHRJRUGKYKIJYUN07 = "zrnkgmaehrjrugkykijyun07";
    public static final String ZRNKGMAEHRJRUGKYYASU07   = "zrnkgmaehrjrugkyyasu07";
    public static final String ZRNKAIGOMAEHRJRUGKYDAKA08 = "zrnkaigomaehrjrugkydaka08";
    public static final String ZRNKGMAEHRJRUGKYKIJYUN08 = "zrnkgmaehrjrugkykijyun08";
    public static final String ZRNKGMAEHRJRUGKYYASU08   = "zrnkgmaehrjrugkyyasu08";
    public static final String ZRNKAIGOMAEHRJRUGKYDAKA09 = "zrnkaigomaehrjrugkydaka09";
    public static final String ZRNKGMAEHRJRUGKYKIJYUN09 = "zrnkgmaehrjrugkykijyun09";
    public static final String ZRNKGMAEHRJRUGKYYASU09   = "zrnkgmaehrjrugkyyasu09";
    public static final String ZRNKAIGOMAEHRJRUGKYDAKA10 = "zrnkaigomaehrjrugkydaka10";
    public static final String ZRNKGMAEHRJRUGKYKIJYUN10 = "zrnkgmaehrjrugkykijyun10";
    public static final String ZRNKGMAEHRJRUGKYYASU10   = "zrnkgmaehrjrugkyyasu10";
    public static final String ZRNKZKTOUROKUSERVICEMSG1 = "zrnkzktourokuservicemsg1";
    public static final String ZRNKZKTOUROKUSERVICEMSG2 = "zrnkzktourokuservicemsg2";
    public static final String ZRNKZKTOUROKUSERVICEMSG3 = "zrnkzktourokuservicemsg3";
    public static final String ZRNKZKTOUROKUSERVICEMSG4 = "zrnkzktourokuservicemsg4";
    public static final String ZRNKZKTOUROKUSERVICEMSG5 = "zrnkzktourokuservicemsg5";
    public static final String ZRNKZKTOUROKUSERVICEMSG6 = "zrnkzktourokuservicemsg6";
    public static final String ZRNKZKTOUROKUSERVICEMSG7 = "zrnkzktourokuservicemsg7";
    public static final String ZRNKZKTOUROKUSERVICEMSG8 = "zrnkzktourokuservicemsg8";
    public static final String ZRNTRKKZKNM118           = "zrntrkkzknm118";
    public static final String ZRNTRKKZKSEI1            = "zrntrkkzksei1";
    public static final String ZRNTRKKZKSEIYMD1ZENKAKU  = "zrntrkkzkseiymd1zenkaku";
    public static final String ZRNTRKKZKYNO1ZENKAKU     = "zrntrkkzkyno1zenkaku";
    public static final String ZRNTRKKZKADRKJ1          = "zrntrkkzkadrkj1";
    public static final String ZRNTRKKZKTELNO1ZENKAKU   = "zrntrkkzktelno1zenkaku";
    public static final String ZRNTRKKZKNM218           = "zrntrkkzknm218";
    public static final String ZRNTRKKZKSEI2            = "zrntrkkzksei2";
    public static final String ZRNTRKKZKSEIYMD2ZENKAKU  = "zrntrkkzkseiymd2zenkaku";
    public static final String ZRNTRKKZKYNO2ZENKAKU     = "zrntrkkzkyno2zenkaku";
    public static final String ZRNTRKKZKADRKJ2          = "zrntrkkzkadrkj2";
    public static final String ZRNTRKKZKTELNO2ZENKAKU   = "zrntrkkzktelno2zenkaku";
    public static final String ZRNKYKDAIRINM18          = "zrnkykdairinm18";
    public static final String ZRNHHKNDAIRINM           = "zrnhhkndairinm";
    public static final String ZRNYOBIV100              = "zrnyobiv100";
    public static final String ZRNHUTANHIYUSTMMSGCDUE01 = "zrnhutanhiyustmmsgcdue01";
    public static final String ZRNHUTANHIYUSTMMSGCDUE02 = "zrnhutanhiyustmmsgcdue02";
    public static final String ZRNHUTANHIYUSTMMSGCDUE03 = "zrnhutanhiyustmmsgcdue03";
    public static final String ZRNHUTANHIYUSTMMSGCDUE04 = "zrnhutanhiyustmmsgcdue04";
    public static final String ZRNHUTANHIYUSTMKNSNHYUPTN = "zrnhutanhiyustmknsnhyuptn";
    public static final String ZRNHUTANHIYUSTMMSGCDST01 = "zrnhutanhiyustmmsgcdst01";
    public static final String ZRNHUTANHIYUSTMMSGCDST02 = "zrnhutanhiyustmmsgcdst02";
    public static final String ZRNHUTANHIYUSTMMSGCDST03 = "zrnhutanhiyustmmsgcdst03";
    public static final String ZRNHUTANHIYUSTMYTIJIHIRITU = "zrnhutanhiyustmytijihiritu";
    public static final String ZRNHUTANHIYUSTMKYAKKJRTMIN = "zrnhutanhiyustmkyakkjrtmin";
    public static final String ZRNHUTANHIYUSTMKYAKKJRTMAX = "zrnhutanhiyustmkyakkjrtmax";
    public static final String ZRNYOBIV7X2              = "zrnyobiv7x2";
    public static final String ZRNSTDSTMMSGCD           = "zrnstdstmmsgcd";
    public static final String ZRNSIORIWEBUKTRIANNAIMSGCD = "zrnsioriwebuktriannaimsgcd";
    public static final String ZRNYOBIV10X2             = "zrnyobiv10x2";
    public static final String ZRNYOBIV69               = "zrnyobiv69";

    private final PKZT_SaihakkouHokensyoukenRn primaryKey;

    public GenZT_SaihakkouHokensyoukenRn() {
        primaryKey = new PKZT_SaihakkouHokensyoukenRn();
    }

    public GenZT_SaihakkouHokensyoukenRn(String pZrntyouhyouymd, String pZrnsyono) {
        primaryKey = new PKZT_SaihakkouHokensyoukenRn(pZrntyouhyouymd, pZrnsyono);
    }

    @Transient
    @Override
    public PKZT_SaihakkouHokensyoukenRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SaihakkouHokensyoukenRn> getMetaClass() {
        return QZT_SaihakkouHokensyoukenRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    @Id
    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrnkanryoutuutidouhuukbn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKANRYOUTUUTIDOUHUUKBN)
    public String getZrnkanryoutuutidouhuukbn() {
        return zrnkanryoutuutidouhuukbn;
    }

    public void setZrnkanryoutuutidouhuukbn(String pZrnkanryoutuutidouhuukbn) {
        zrnkanryoutuutidouhuukbn = pZrnkanryoutuutidouhuukbn;
    }

    private String zrnsikibetuno;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIKIBETUNO)
    public String getZrnsikibetuno() {
        return zrnsikibetuno;
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        zrnsikibetuno = pZrnsikibetuno;
    }

    private String zrnstdrsktirasidouhuukbn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSTDRSKTIRASIDOUHUUKBN)
    public String getZrnstdrsktirasidouhuukbn() {
        return zrnstdrsktirasidouhuukbn;
    }

    public void setZrnstdrsktirasidouhuukbn(String pZrnstdrsktirasidouhuukbn) {
        zrnstdrsktirasidouhuukbn = pZrnstdrsktirasidouhuukbn;
    }

    private String zrnaisyoumeikbn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNAISYOUMEIKBN)
    public String getZrnaisyoumeikbn() {
        return zrnaisyoumeikbn;
    }

    public void setZrnaisyoumeikbn(String pZrnaisyoumeikbn) {
        zrnaisyoumeikbn = pZrnaisyoumeikbn;
    }

    private String zrnsagyoukbn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSAGYOUKBN)
    public String getZrnsagyoukbn() {
        return zrnsagyoukbn;
    }

    public void setZrnsagyoukbn(String pZrnsagyoukbn) {
        zrnsagyoukbn = pZrnsagyoukbn;
    }

    private String zrnyakkanbunsyono;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYAKKANBUNSYONO)
    public String getZrnyakkanbunsyono() {
        return zrnyakkanbunsyono;
    }

    public void setZrnyakkanbunsyono(String pZrnyakkanbunsyono) {
        zrnyakkanbunsyono = pZrnyakkanbunsyono;
    }

    private String zrnyobiv23x2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV23X2)
    public String getZrnyobiv23x2() {
        return zrnyobiv23x2;
    }

    public void setZrnyobiv23x2(String pZrnyobiv23x2) {
        zrnyobiv23x2 = pZrnyobiv23x2;
    }

    private String zrnhyoujiranhidarimsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD1)
    public String getZrnhyoujiranhidarimsgcd1() {
        return zrnhyoujiranhidarimsgcd1;
    }

    public void setZrnhyoujiranhidarimsgcd1(String pZrnhyoujiranhidarimsgcd1) {
        zrnhyoujiranhidarimsgcd1 = pZrnhyoujiranhidarimsgcd1;
    }

    private String zrnhyoujiranhidarimsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD2)
    public String getZrnhyoujiranhidarimsgcd2() {
        return zrnhyoujiranhidarimsgcd2;
    }

    public void setZrnhyoujiranhidarimsgcd2(String pZrnhyoujiranhidarimsgcd2) {
        zrnhyoujiranhidarimsgcd2 = pZrnhyoujiranhidarimsgcd2;
    }

    private String zrnhyoujiranhidarimsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD3)
    public String getZrnhyoujiranhidarimsgcd3() {
        return zrnhyoujiranhidarimsgcd3;
    }

    public void setZrnhyoujiranhidarimsgcd3(String pZrnhyoujiranhidarimsgcd3) {
        zrnhyoujiranhidarimsgcd3 = pZrnhyoujiranhidarimsgcd3;
    }

    private String zrnhyoujiranhidarimsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD4)
    public String getZrnhyoujiranhidarimsgcd4() {
        return zrnhyoujiranhidarimsgcd4;
    }

    public void setZrnhyoujiranhidarimsgcd4(String pZrnhyoujiranhidarimsgcd4) {
        zrnhyoujiranhidarimsgcd4 = pZrnhyoujiranhidarimsgcd4;
    }

    private String zrnhyoujiranhidarimsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD5)
    public String getZrnhyoujiranhidarimsgcd5() {
        return zrnhyoujiranhidarimsgcd5;
    }

    public void setZrnhyoujiranhidarimsgcd5(String pZrnhyoujiranhidarimsgcd5) {
        zrnhyoujiranhidarimsgcd5 = pZrnhyoujiranhidarimsgcd5;
    }

    private String zrnhyoujiranhidarimsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD6)
    public String getZrnhyoujiranhidarimsgcd6() {
        return zrnhyoujiranhidarimsgcd6;
    }

    public void setZrnhyoujiranhidarimsgcd6(String pZrnhyoujiranhidarimsgcd6) {
        zrnhyoujiranhidarimsgcd6 = pZrnhyoujiranhidarimsgcd6;
    }

    private String zrnhyoujiranhidarimsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD7)
    public String getZrnhyoujiranhidarimsgcd7() {
        return zrnhyoujiranhidarimsgcd7;
    }

    public void setZrnhyoujiranhidarimsgcd7(String pZrnhyoujiranhidarimsgcd7) {
        zrnhyoujiranhidarimsgcd7 = pZrnhyoujiranhidarimsgcd7;
    }

    private String zrnhyoujiranhidarimsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD8)
    public String getZrnhyoujiranhidarimsgcd8() {
        return zrnhyoujiranhidarimsgcd8;
    }

    public void setZrnhyoujiranhidarimsgcd8(String pZrnhyoujiranhidarimsgcd8) {
        zrnhyoujiranhidarimsgcd8 = pZrnhyoujiranhidarimsgcd8;
    }

    private String zrnhyoujiranhidarimsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD9)
    public String getZrnhyoujiranhidarimsgcd9() {
        return zrnhyoujiranhidarimsgcd9;
    }

    public void setZrnhyoujiranhidarimsgcd9(String pZrnhyoujiranhidarimsgcd9) {
        zrnhyoujiranhidarimsgcd9 = pZrnhyoujiranhidarimsgcd9;
    }

    private String zrnhyoujiranhidarimsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD10)
    public String getZrnhyoujiranhidarimsgcd10() {
        return zrnhyoujiranhidarimsgcd10;
    }

    public void setZrnhyoujiranhidarimsgcd10(String pZrnhyoujiranhidarimsgcd10) {
        zrnhyoujiranhidarimsgcd10 = pZrnhyoujiranhidarimsgcd10;
    }

    private String zrnhyoujiranhidarimsgcd11;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD11)
    public String getZrnhyoujiranhidarimsgcd11() {
        return zrnhyoujiranhidarimsgcd11;
    }

    public void setZrnhyoujiranhidarimsgcd11(String pZrnhyoujiranhidarimsgcd11) {
        zrnhyoujiranhidarimsgcd11 = pZrnhyoujiranhidarimsgcd11;
    }

    private String zrnhyoujiranhidarimsgcd12;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD12)
    public String getZrnhyoujiranhidarimsgcd12() {
        return zrnhyoujiranhidarimsgcd12;
    }

    public void setZrnhyoujiranhidarimsgcd12(String pZrnhyoujiranhidarimsgcd12) {
        zrnhyoujiranhidarimsgcd12 = pZrnhyoujiranhidarimsgcd12;
    }

    private String zrnhyoujiranhidarimsgcd13;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD13)
    public String getZrnhyoujiranhidarimsgcd13() {
        return zrnhyoujiranhidarimsgcd13;
    }

    public void setZrnhyoujiranhidarimsgcd13(String pZrnhyoujiranhidarimsgcd13) {
        zrnhyoujiranhidarimsgcd13 = pZrnhyoujiranhidarimsgcd13;
    }

    private String zrnhyoujiranhidarimsgcd14;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD14)
    public String getZrnhyoujiranhidarimsgcd14() {
        return zrnhyoujiranhidarimsgcd14;
    }

    public void setZrnhyoujiranhidarimsgcd14(String pZrnhyoujiranhidarimsgcd14) {
        zrnhyoujiranhidarimsgcd14 = pZrnhyoujiranhidarimsgcd14;
    }

    private String zrnhyoujiranhidarimsgcd15;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD15)
    public String getZrnhyoujiranhidarimsgcd15() {
        return zrnhyoujiranhidarimsgcd15;
    }

    public void setZrnhyoujiranhidarimsgcd15(String pZrnhyoujiranhidarimsgcd15) {
        zrnhyoujiranhidarimsgcd15 = pZrnhyoujiranhidarimsgcd15;
    }

    private String zrnhyoujiranhidarimsgcd16;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD16)
    public String getZrnhyoujiranhidarimsgcd16() {
        return zrnhyoujiranhidarimsgcd16;
    }

    public void setZrnhyoujiranhidarimsgcd16(String pZrnhyoujiranhidarimsgcd16) {
        zrnhyoujiranhidarimsgcd16 = pZrnhyoujiranhidarimsgcd16;
    }

    private String zrnhyoujiranhidarimsgcd17;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD17)
    public String getZrnhyoujiranhidarimsgcd17() {
        return zrnhyoujiranhidarimsgcd17;
    }

    public void setZrnhyoujiranhidarimsgcd17(String pZrnhyoujiranhidarimsgcd17) {
        zrnhyoujiranhidarimsgcd17 = pZrnhyoujiranhidarimsgcd17;
    }

    private String zrnhyoujiranhidarimsgcd18;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD18)
    public String getZrnhyoujiranhidarimsgcd18() {
        return zrnhyoujiranhidarimsgcd18;
    }

    public void setZrnhyoujiranhidarimsgcd18(String pZrnhyoujiranhidarimsgcd18) {
        zrnhyoujiranhidarimsgcd18 = pZrnhyoujiranhidarimsgcd18;
    }

    private String zrnhyoujiranhidarimsgcd19;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD19)
    public String getZrnhyoujiranhidarimsgcd19() {
        return zrnhyoujiranhidarimsgcd19;
    }

    public void setZrnhyoujiranhidarimsgcd19(String pZrnhyoujiranhidarimsgcd19) {
        zrnhyoujiranhidarimsgcd19 = pZrnhyoujiranhidarimsgcd19;
    }

    private String zrnhyoujiranhidarimsgcd20;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANHIDARIMSGCD20)
    public String getZrnhyoujiranhidarimsgcd20() {
        return zrnhyoujiranhidarimsgcd20;
    }

    public void setZrnhyoujiranhidarimsgcd20(String pZrnhyoujiranhidarimsgcd20) {
        zrnhyoujiranhidarimsgcd20 = pZrnhyoujiranhidarimsgcd20;
    }

    private String zrnhyoujiranmigimsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD1)
    public String getZrnhyoujiranmigimsgcd1() {
        return zrnhyoujiranmigimsgcd1;
    }

    public void setZrnhyoujiranmigimsgcd1(String pZrnhyoujiranmigimsgcd1) {
        zrnhyoujiranmigimsgcd1 = pZrnhyoujiranmigimsgcd1;
    }

    private String zrnhyoujiranmigimsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD2)
    public String getZrnhyoujiranmigimsgcd2() {
        return zrnhyoujiranmigimsgcd2;
    }

    public void setZrnhyoujiranmigimsgcd2(String pZrnhyoujiranmigimsgcd2) {
        zrnhyoujiranmigimsgcd2 = pZrnhyoujiranmigimsgcd2;
    }

    private String zrnhyoujiranmigimsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD3)
    public String getZrnhyoujiranmigimsgcd3() {
        return zrnhyoujiranmigimsgcd3;
    }

    public void setZrnhyoujiranmigimsgcd3(String pZrnhyoujiranmigimsgcd3) {
        zrnhyoujiranmigimsgcd3 = pZrnhyoujiranmigimsgcd3;
    }

    private String zrnhyoujiranmigimsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD4)
    public String getZrnhyoujiranmigimsgcd4() {
        return zrnhyoujiranmigimsgcd4;
    }

    public void setZrnhyoujiranmigimsgcd4(String pZrnhyoujiranmigimsgcd4) {
        zrnhyoujiranmigimsgcd4 = pZrnhyoujiranmigimsgcd4;
    }

    private String zrnhyoujiranmigimsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD5)
    public String getZrnhyoujiranmigimsgcd5() {
        return zrnhyoujiranmigimsgcd5;
    }

    public void setZrnhyoujiranmigimsgcd5(String pZrnhyoujiranmigimsgcd5) {
        zrnhyoujiranmigimsgcd5 = pZrnhyoujiranmigimsgcd5;
    }

    private String zrnhyoujiranmigimsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD6)
    public String getZrnhyoujiranmigimsgcd6() {
        return zrnhyoujiranmigimsgcd6;
    }

    public void setZrnhyoujiranmigimsgcd6(String pZrnhyoujiranmigimsgcd6) {
        zrnhyoujiranmigimsgcd6 = pZrnhyoujiranmigimsgcd6;
    }

    private String zrnhyoujiranmigimsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD7)
    public String getZrnhyoujiranmigimsgcd7() {
        return zrnhyoujiranmigimsgcd7;
    }

    public void setZrnhyoujiranmigimsgcd7(String pZrnhyoujiranmigimsgcd7) {
        zrnhyoujiranmigimsgcd7 = pZrnhyoujiranmigimsgcd7;
    }

    private String zrnhyoujiranmigimsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD8)
    public String getZrnhyoujiranmigimsgcd8() {
        return zrnhyoujiranmigimsgcd8;
    }

    public void setZrnhyoujiranmigimsgcd8(String pZrnhyoujiranmigimsgcd8) {
        zrnhyoujiranmigimsgcd8 = pZrnhyoujiranmigimsgcd8;
    }

    private String zrnhyoujiranmigimsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD9)
    public String getZrnhyoujiranmigimsgcd9() {
        return zrnhyoujiranmigimsgcd9;
    }

    public void setZrnhyoujiranmigimsgcd9(String pZrnhyoujiranmigimsgcd9) {
        zrnhyoujiranmigimsgcd9 = pZrnhyoujiranmigimsgcd9;
    }

    private String zrnhyoujiranmigimsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD10)
    public String getZrnhyoujiranmigimsgcd10() {
        return zrnhyoujiranmigimsgcd10;
    }

    public void setZrnhyoujiranmigimsgcd10(String pZrnhyoujiranmigimsgcd10) {
        zrnhyoujiranmigimsgcd10 = pZrnhyoujiranmigimsgcd10;
    }

    private String zrnhyoujiranmigimsgcd11;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD11)
    public String getZrnhyoujiranmigimsgcd11() {
        return zrnhyoujiranmigimsgcd11;
    }

    public void setZrnhyoujiranmigimsgcd11(String pZrnhyoujiranmigimsgcd11) {
        zrnhyoujiranmigimsgcd11 = pZrnhyoujiranmigimsgcd11;
    }

    private String zrnhyoujiranmigimsgcd12;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD12)
    public String getZrnhyoujiranmigimsgcd12() {
        return zrnhyoujiranmigimsgcd12;
    }

    public void setZrnhyoujiranmigimsgcd12(String pZrnhyoujiranmigimsgcd12) {
        zrnhyoujiranmigimsgcd12 = pZrnhyoujiranmigimsgcd12;
    }

    private String zrnhyoujiranmigimsgcd13;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD13)
    public String getZrnhyoujiranmigimsgcd13() {
        return zrnhyoujiranmigimsgcd13;
    }

    public void setZrnhyoujiranmigimsgcd13(String pZrnhyoujiranmigimsgcd13) {
        zrnhyoujiranmigimsgcd13 = pZrnhyoujiranmigimsgcd13;
    }

    private String zrnhyoujiranmigimsgcd14;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD14)
    public String getZrnhyoujiranmigimsgcd14() {
        return zrnhyoujiranmigimsgcd14;
    }

    public void setZrnhyoujiranmigimsgcd14(String pZrnhyoujiranmigimsgcd14) {
        zrnhyoujiranmigimsgcd14 = pZrnhyoujiranmigimsgcd14;
    }

    private String zrnhyoujiranmigimsgcd15;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD15)
    public String getZrnhyoujiranmigimsgcd15() {
        return zrnhyoujiranmigimsgcd15;
    }

    public void setZrnhyoujiranmigimsgcd15(String pZrnhyoujiranmigimsgcd15) {
        zrnhyoujiranmigimsgcd15 = pZrnhyoujiranmigimsgcd15;
    }

    private String zrnhyoujiranmigimsgcd16;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD16)
    public String getZrnhyoujiranmigimsgcd16() {
        return zrnhyoujiranmigimsgcd16;
    }

    public void setZrnhyoujiranmigimsgcd16(String pZrnhyoujiranmigimsgcd16) {
        zrnhyoujiranmigimsgcd16 = pZrnhyoujiranmigimsgcd16;
    }

    private String zrnhyoujiranmigimsgcd17;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD17)
    public String getZrnhyoujiranmigimsgcd17() {
        return zrnhyoujiranmigimsgcd17;
    }

    public void setZrnhyoujiranmigimsgcd17(String pZrnhyoujiranmigimsgcd17) {
        zrnhyoujiranmigimsgcd17 = pZrnhyoujiranmigimsgcd17;
    }

    private String zrnhyoujiranmigimsgcd18;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD18)
    public String getZrnhyoujiranmigimsgcd18() {
        return zrnhyoujiranmigimsgcd18;
    }

    public void setZrnhyoujiranmigimsgcd18(String pZrnhyoujiranmigimsgcd18) {
        zrnhyoujiranmigimsgcd18 = pZrnhyoujiranmigimsgcd18;
    }

    private String zrnhyoujiranmigimsgcd19;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD19)
    public String getZrnhyoujiranmigimsgcd19() {
        return zrnhyoujiranmigimsgcd19;
    }

    public void setZrnhyoujiranmigimsgcd19(String pZrnhyoujiranmigimsgcd19) {
        zrnhyoujiranmigimsgcd19 = pZrnhyoujiranmigimsgcd19;
    }

    private String zrnhyoujiranmigimsgcd20;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANMIGIMSGCD20)
    public String getZrnhyoujiranmigimsgcd20() {
        return zrnhyoujiranmigimsgcd20;
    }

    public void setZrnhyoujiranmigimsgcd20(String pZrnhyoujiranmigimsgcd20) {
        zrnhyoujiranmigimsgcd20 = pZrnhyoujiranmigimsgcd20;
    }

    private String zrnsknnkaisiymdseireki;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSKNNKAISIYMDSEIREKI)
    public String getZrnsknnkaisiymdseireki() {
        return zrnsknnkaisiymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnsknnkaisiymdseireki(String pZrnsknnkaisiymdseireki) {
        zrnsknnkaisiymdseireki = pZrnsknnkaisiymdseireki;
    }

    private String zrnhyoujiranytirrt;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANYTIRRT)
    public String getZrnhyoujiranytirrt() {
        return zrnhyoujiranytirrt;
    }

    @DataConvert("toMultiByte")
    public void setZrnhyoujiranytirrt(String pZrnhyoujiranytirrt) {
        zrnhyoujiranytirrt = pZrnhyoujiranytirrt;
    }

    private String zrnhyoujiransjkkktusirrt;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANSJKKKTUSIRRT)
    public String getZrnhyoujiransjkkktusirrt() {
        return zrnhyoujiransjkkktusirrt;
    }

    @DataConvert("toMultiByte")
    public void setZrnhyoujiransjkkktusirrt(String pZrnhyoujiransjkkktusirrt) {
        zrnhyoujiransjkkktusirrt = pZrnhyoujiransjkkktusirrt;
    }

    private String zrnhyoujirantumitateriritu;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANTUMITATERIRITU)
    public String getZrnhyoujirantumitateriritu() {
        return zrnhyoujirantumitateriritu;
    }

    @DataConvert("toMultiByte")
    public void setZrnhyoujirantumitateriritu(String pZrnhyoujirantumitateriritu) {
        zrnhyoujirantumitateriritu = pZrnhyoujirantumitateriritu;
    }

    private String zrnhyoujirantumitateriritu2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANTUMITATERIRITU2)
    public String getZrnhyoujirantumitateriritu2() {
        return zrnhyoujirantumitateriritu2;
    }

    @DataConvert("toMultiByte")
    public void setZrnhyoujirantumitateriritu2(String pZrnhyoujirantumitateriritu2) {
        zrnhyoujirantumitateriritu2 = pZrnhyoujirantumitateriritu2;
    }

    private String zrnhyoujirantmttknzkrtjygn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANTMTTKNZKRTJYGN)
    public String getZrnhyoujirantmttknzkrtjygn() {
        return zrnhyoujirantmttknzkrtjygn;
    }

    @DataConvert("toMultiByte")
    public void setZrnhyoujirantmttknzkrtjygn(String pZrnhyoujirantmttknzkrtjygn) {
        zrnhyoujirantmttknzkrtjygn = pZrnhyoujirantmttknzkrtjygn;
    }

    private String zrnhyoujiransetteibairitu;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHYOUJIRANSETTEIBAIRITU)
    public String getZrnhyoujiransetteibairitu() {
        return zrnhyoujiransetteibairitu;
    }

    @DataConvert("toMultiByte")
    public void setZrnhyoujiransetteibairitu(String pZrnhyoujiransetteibairitu) {
        zrnhyoujiransetteibairitu = pZrnhyoujiransetteibairitu;
    }

    private String zrnyobiv22x11;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22X11)
    public String getZrnyobiv22x11() {
        return zrnyobiv22x11;
    }

    public void setZrnyobiv22x11(String pZrnyobiv22x11) {
        zrnyobiv22x11 = pZrnyobiv22x11;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnsyoukenhakkouymd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYOUKENHAKKOUYMD)
    public String getZrnsyoukenhakkouymd() {
        return zrnsyoukenhakkouymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyoukenhakkouymd(String pZrnsyoukenhakkouymd) {
        zrnsyoukenhakkouymd = pZrnsyoukenhakkouymd;
    }

    private String zrnkouryokukaisimsg;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKOURYOKUKAISIMSG)
    public String getZrnkouryokukaisimsg() {
        return zrnkouryokukaisimsg;
    }

    @DataConvert("toMultiByte")
    public void setZrnkouryokukaisimsg(String pZrnkouryokukaisimsg) {
        zrnkouryokukaisimsg = pZrnkouryokukaisimsg;
    }

    private String zrnseisikihknnmsyouken;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSEISIKIHKNNMSYOUKEN)
    public String getZrnseisikihknnmsyouken() {
        return zrnseisikihknnmsyouken;
    }

    @DataConvert("toMultiByte")
    public void setZrnseisikihknnmsyouken(String pZrnseisikihknnmsyouken) {
        zrnseisikihknnmsyouken = pZrnseisikihknnmsyouken;
    }

    private String zrnnksyuruinmsyouken;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKSYURUINMSYOUKEN)
    public String getZrnnksyuruinmsyouken() {
        return zrnnksyuruinmsyouken;
    }

    @DataConvert("toMultiByte")
    public void setZrnnksyuruinmsyouken(String pZrnnksyuruinmsyouken) {
        zrnnksyuruinmsyouken = pZrnnksyuruinmsyouken;
    }

    private String zrnyobiv116;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV116)
    public String getZrnyobiv116() {
        return zrnyobiv116;
    }

    public void setZrnyobiv116(String pZrnyobiv116) {
        zrnyobiv116 = pZrnyobiv116;
    }

    private String zrnkyknmkj;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNMKJ)
    public String getZrnkyknmkj() {
        return zrnkyknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj(String pZrnkyknmkj) {
        zrnkyknmkj = pZrnkyknmkj;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnhihknsyaseiymdwareki;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHIHKNSYASEIYMDWAREKI)
    public String getZrnhihknsyaseiymdwareki() {
        return zrnhihknsyaseiymdwareki;
    }

    @DataConvert("toMultiByte")
    public void setZrnhihknsyaseiymdwareki(String pZrnhihknsyaseiymdwareki) {
        zrnhihknsyaseiymdwareki = pZrnhihknsyaseiymdwareki;
    }

    private String zrnhhknsei;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHHKNSEI)
    public String getZrnhhknsei() {
        return zrnhhknsei;
    }

    public void setZrnhhknsei(String pZrnhhknsei) {
        zrnhhknsei = pZrnhhknsei;
    }

    private String zrnhhknnen2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHHKNNEN2)
    public String getZrnhhknnen2() {
        return zrnhhknnen2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2(String pZrnhhknnen2) {
        zrnhhknnen2 = pZrnhhknnen2;
    }

    private String zrnuktmidasikbn1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTMIDASIKBN1)
    public String getZrnuktmidasikbn1() {
        return zrnuktmidasikbn1;
    }

    public void setZrnuktmidasikbn1(String pZrnuktmidasikbn1) {
        zrnuktmidasikbn1 = pZrnuktmidasikbn1;
    }

    private String zrnuktkbn1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTKBN1)
    public String getZrnuktkbn1() {
        return zrnuktkbn1;
    }

    public void setZrnuktkbn1(String pZrnuktkbn1) {
        zrnuktkbn1 = pZrnuktkbn1;
    }

    private String zrnuktnm1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTNM1)
    public String getZrnuktnm1() {
        return zrnuktnm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm1(String pZrnuktnm1) {
        zrnuktnm1 = pZrnuktnm1;
    }

    private String zrnuktbnwari1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTBNWARI1)
    public String getZrnuktbnwari1() {
        return zrnuktbnwari1;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnuktbnwari1(String pZrnuktbnwari1) {
        zrnuktbnwari1 = pZrnuktbnwari1;
    }

    private String zrnuktmidasikbn2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTMIDASIKBN2)
    public String getZrnuktmidasikbn2() {
        return zrnuktmidasikbn2;
    }

    public void setZrnuktmidasikbn2(String pZrnuktmidasikbn2) {
        zrnuktmidasikbn2 = pZrnuktmidasikbn2;
    }

    private String zrnuktkbn2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTKBN2)
    public String getZrnuktkbn2() {
        return zrnuktkbn2;
    }

    public void setZrnuktkbn2(String pZrnuktkbn2) {
        zrnuktkbn2 = pZrnuktkbn2;
    }

    private String zrnuktnm2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTNM2)
    public String getZrnuktnm2() {
        return zrnuktnm2;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm2(String pZrnuktnm2) {
        zrnuktnm2 = pZrnuktnm2;
    }

    private String zrnuktbnwari2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTBNWARI2)
    public String getZrnuktbnwari2() {
        return zrnuktbnwari2;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnuktbnwari2(String pZrnuktbnwari2) {
        zrnuktbnwari2 = pZrnuktbnwari2;
    }

    private String zrnuktmidasikbn3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTMIDASIKBN3)
    public String getZrnuktmidasikbn3() {
        return zrnuktmidasikbn3;
    }

    public void setZrnuktmidasikbn3(String pZrnuktmidasikbn3) {
        zrnuktmidasikbn3 = pZrnuktmidasikbn3;
    }

    private String zrnuktkbn3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTKBN3)
    public String getZrnuktkbn3() {
        return zrnuktkbn3;
    }

    public void setZrnuktkbn3(String pZrnuktkbn3) {
        zrnuktkbn3 = pZrnuktkbn3;
    }

    private String zrnuktnm3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTNM3)
    public String getZrnuktnm3() {
        return zrnuktnm3;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm3(String pZrnuktnm3) {
        zrnuktnm3 = pZrnuktnm3;
    }

    private String zrnuktbnwari3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTBNWARI3)
    public String getZrnuktbnwari3() {
        return zrnuktbnwari3;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnuktbnwari3(String pZrnuktbnwari3) {
        zrnuktbnwari3 = pZrnuktbnwari3;
    }

    private String zrnuktmidasikbn4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTMIDASIKBN4)
    public String getZrnuktmidasikbn4() {
        return zrnuktmidasikbn4;
    }

    public void setZrnuktmidasikbn4(String pZrnuktmidasikbn4) {
        zrnuktmidasikbn4 = pZrnuktmidasikbn4;
    }

    private String zrnuktkbn4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTKBN4)
    public String getZrnuktkbn4() {
        return zrnuktkbn4;
    }

    public void setZrnuktkbn4(String pZrnuktkbn4) {
        zrnuktkbn4 = pZrnuktkbn4;
    }

    private String zrnuktnm4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTNM4)
    public String getZrnuktnm4() {
        return zrnuktnm4;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm4(String pZrnuktnm4) {
        zrnuktnm4 = pZrnuktnm4;
    }

    private String zrnuktbnwari4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTBNWARI4)
    public String getZrnuktbnwari4() {
        return zrnuktbnwari4;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnuktbnwari4(String pZrnuktbnwari4) {
        zrnuktbnwari4 = pZrnuktbnwari4;
    }

    private String zrnuktmidasikbn5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTMIDASIKBN5)
    public String getZrnuktmidasikbn5() {
        return zrnuktmidasikbn5;
    }

    public void setZrnuktmidasikbn5(String pZrnuktmidasikbn5) {
        zrnuktmidasikbn5 = pZrnuktmidasikbn5;
    }

    private String zrnuktkbn5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTKBN5)
    public String getZrnuktkbn5() {
        return zrnuktkbn5;
    }

    public void setZrnuktkbn5(String pZrnuktkbn5) {
        zrnuktkbn5 = pZrnuktkbn5;
    }

    private String zrnuktnm5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTNM5)
    public String getZrnuktnm5() {
        return zrnuktnm5;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm5(String pZrnuktnm5) {
        zrnuktnm5 = pZrnuktnm5;
    }

    private String zrnuktbnwari5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTBNWARI5)
    public String getZrnuktbnwari5() {
        return zrnuktbnwari5;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnuktbnwari5(String pZrnuktbnwari5) {
        zrnuktbnwari5 = pZrnuktbnwari5;
    }

    private String zrnuktmidasikbn6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTMIDASIKBN6)
    public String getZrnuktmidasikbn6() {
        return zrnuktmidasikbn6;
    }

    public void setZrnuktmidasikbn6(String pZrnuktmidasikbn6) {
        zrnuktmidasikbn6 = pZrnuktmidasikbn6;
    }

    private String zrnuktkbn6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTKBN6)
    public String getZrnuktkbn6() {
        return zrnuktkbn6;
    }

    public void setZrnuktkbn6(String pZrnuktkbn6) {
        zrnuktkbn6 = pZrnuktkbn6;
    }

    private String zrnuktnm6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTNM6)
    public String getZrnuktnm6() {
        return zrnuktnm6;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm6(String pZrnuktnm6) {
        zrnuktnm6 = pZrnuktnm6;
    }

    private String zrnuktbnwari6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTBNWARI6)
    public String getZrnuktbnwari6() {
        return zrnuktbnwari6;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnuktbnwari6(String pZrnuktbnwari6) {
        zrnuktbnwari6 = pZrnuktbnwari6;
    }

    private String zrnuktmidasikbn7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTMIDASIKBN7)
    public String getZrnuktmidasikbn7() {
        return zrnuktmidasikbn7;
    }

    public void setZrnuktmidasikbn7(String pZrnuktmidasikbn7) {
        zrnuktmidasikbn7 = pZrnuktmidasikbn7;
    }

    private String zrnuktkbn7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTKBN7)
    public String getZrnuktkbn7() {
        return zrnuktkbn7;
    }

    public void setZrnuktkbn7(String pZrnuktkbn7) {
        zrnuktkbn7 = pZrnuktkbn7;
    }

    private String zrnuktnm7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTNM7)
    public String getZrnuktnm7() {
        return zrnuktnm7;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm7(String pZrnuktnm7) {
        zrnuktnm7 = pZrnuktnm7;
    }

    private String zrnuktbnwari7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTBNWARI7)
    public String getZrnuktbnwari7() {
        return zrnuktbnwari7;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnuktbnwari7(String pZrnuktbnwari7) {
        zrnuktbnwari7 = pZrnuktbnwari7;
    }

    private String zrnuktmidasikbn8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTMIDASIKBN8)
    public String getZrnuktmidasikbn8() {
        return zrnuktmidasikbn8;
    }

    public void setZrnuktmidasikbn8(String pZrnuktmidasikbn8) {
        zrnuktmidasikbn8 = pZrnuktmidasikbn8;
    }

    private String zrnuktkbn8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTKBN8)
    public String getZrnuktkbn8() {
        return zrnuktkbn8;
    }

    public void setZrnuktkbn8(String pZrnuktkbn8) {
        zrnuktkbn8 = pZrnuktkbn8;
    }

    private String zrnuktnm8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTNM8)
    public String getZrnuktnm8() {
        return zrnuktnm8;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm8(String pZrnuktnm8) {
        zrnuktnm8 = pZrnuktnm8;
    }

    private String zrnuktbnwari8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTBNWARI8)
    public String getZrnuktbnwari8() {
        return zrnuktbnwari8;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnuktbnwari8(String pZrnuktbnwari8) {
        zrnuktbnwari8 = pZrnuktbnwari8;
    }

    private String zrnuktmidasikbn9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTMIDASIKBN9)
    public String getZrnuktmidasikbn9() {
        return zrnuktmidasikbn9;
    }

    public void setZrnuktmidasikbn9(String pZrnuktmidasikbn9) {
        zrnuktmidasikbn9 = pZrnuktmidasikbn9;
    }

    private String zrnuktkbn9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTKBN9)
    public String getZrnuktkbn9() {
        return zrnuktkbn9;
    }

    public void setZrnuktkbn9(String pZrnuktkbn9) {
        zrnuktkbn9 = pZrnuktkbn9;
    }

    private String zrnuktnm9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTNM9)
    public String getZrnuktnm9() {
        return zrnuktnm9;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm9(String pZrnuktnm9) {
        zrnuktnm9 = pZrnuktnm9;
    }

    private String zrnuktbnwari9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTBNWARI9)
    public String getZrnuktbnwari9() {
        return zrnuktbnwari9;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnuktbnwari9(String pZrnuktbnwari9) {
        zrnuktbnwari9 = pZrnuktbnwari9;
    }

    private String zrnuktmidasikbn10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTMIDASIKBN10)
    public String getZrnuktmidasikbn10() {
        return zrnuktmidasikbn10;
    }

    public void setZrnuktmidasikbn10(String pZrnuktmidasikbn10) {
        zrnuktmidasikbn10 = pZrnuktmidasikbn10;
    }

    private String zrnuktkbn10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTKBN10)
    public String getZrnuktkbn10() {
        return zrnuktkbn10;
    }

    public void setZrnuktkbn10(String pZrnuktkbn10) {
        zrnuktkbn10 = pZrnuktkbn10;
    }

    private String zrnuktnm10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTNM10)
    public String getZrnuktnm10() {
        return zrnuktnm10;
    }

    @DataConvert("toMultiByte")
    public void setZrnuktnm10(String pZrnuktnm10) {
        zrnuktnm10 = pZrnuktnm10;
    }

    private String zrnuktbnwari10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNUKTBNWARI10)
    public String getZrnuktbnwari10() {
        return zrnuktbnwari10;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnuktbnwari10(String pZrnuktbnwari10) {
        zrnuktbnwari10 = pZrnuktbnwari10;
    }

    private String zrnyobiv45;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV45)
    public String getZrnyobiv45() {
        return zrnyobiv45;
    }

    public void setZrnyobiv45(String pZrnyobiv45) {
        zrnyobiv45 = pZrnyobiv45;
    }

    private String zrnpmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNPMSGCD1)
    public String getZrnpmsgcd1() {
        return zrnpmsgcd1;
    }

    public void setZrnpmsgcd1(String pZrnpmsgcd1) {
        zrnpmsgcd1 = pZrnpmsgcd1;
    }

    private String zrnpmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNPMSGCD2)
    public String getZrnpmsgcd2() {
        return zrnpmsgcd2;
    }

    public void setZrnpmsgcd2(String pZrnpmsgcd2) {
        zrnpmsgcd2 = pZrnpmsgcd2;
    }

    private String zrnpmsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNPMSGCD3)
    public String getZrnpmsgcd3() {
        return zrnpmsgcd3;
    }

    public void setZrnpmsgcd3(String pZrnpmsgcd3) {
        zrnpmsgcd3 = pZrnpmsgcd3;
    }

    private String zrnyobiv10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV10)
    public String getZrnyobiv10() {
        return zrnyobiv10;
    }

    public void setZrnyobiv10(String pZrnyobiv10) {
        zrnyobiv10 = pZrnyobiv10;
    }

    private String zrnptuukatype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNPTUUKATYPE)
    public String getZrnptuukatype() {
        return zrnptuukatype;
    }

    public void setZrnptuukatype(String pZrnptuukatype) {
        zrnptuukatype = pZrnptuukatype;
    }

    private String zrnpkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNPKNGK)
    public String getZrnpkngk() {
        return zrnpkngk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnpkngk(String pZrnpkngk) {
        zrnpkngk = pZrnpkngk;
    }

    private String zrnpkngktuuka;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNPKNGKTUUKA)
    public String getZrnpkngktuuka() {
        return zrnpkngktuuka;
    }

    @DataConvert("toMultiByte")
    public void setZrnpkngktuuka(String pZrnpkngktuuka) {
        zrnpkngktuuka = pZrnpkngktuuka;
    }

    private String zrnteikiikkatubaraitukisuu;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTEIKIIKKATUBARAITUKISUU)
    public String getZrnteikiikkatubaraitukisuu() {
        return zrnteikiikkatubaraitukisuu;
    }

    public void setZrnteikiikkatubaraitukisuu(String pZrnteikiikkatubaraitukisuu) {
        zrnteikiikkatubaraitukisuu = pZrnteikiikkatubaraitukisuu;
    }

    private String zrnztikiktbriyhrkgktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNZTIKIKTBRIYHRKGKTUKTYPE)
    public String getZrnztikiktbriyhrkgktuktype() {
        return zrnztikiktbriyhrkgktuktype;
    }

    public void setZrnztikiktbriyhrkgktuktype(String pZrnztikiktbriyhrkgktuktype) {
        zrnztikiktbriyhrkgktuktype = pZrnztikiktbriyhrkgktuktype;
    }

    private String zrnznntikiktbriyenhrkgk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNZNNTIKIKTBRIYENHRKGK)
    public String getZrnznntikiktbriyenhrkgk() {
        return zrnznntikiktbriyenhrkgk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnznntikiktbriyenhrkgk(String pZrnznntikiktbriyenhrkgk) {
        zrnznntikiktbriyenhrkgk = pZrnznntikiktbriyenhrkgk;
    }

    private String zrnznnkai;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNZNNKAI)
    public String getZrnznnkai() {
        return zrnznnkai;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnznnkai(String pZrnznnkai) {
        zrnznnkai = pZrnznnkai;
    }

    private String zrnptokuyakumsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNPTOKUYAKUMSGCD)
    public String getZrnptokuyakumsgcd() {
        return zrnptokuyakumsgcd;
    }

    public void setZrnptokuyakumsgcd(String pZrnptokuyakumsgcd) {
        zrnptokuyakumsgcd = pZrnptokuyakumsgcd;
    }

    private String zrntikiktbriyhrkgktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTIKIKTBRIYHRKGKTUKTYPE)
    public String getZrntikiktbriyhrkgktuktype() {
        return zrntikiktbriyhrkgktuktype;
    }

    public void setZrntikiktbriyhrkgktuktype(String pZrntikiktbriyhrkgktuktype) {
        zrntikiktbriyhrkgktuktype = pZrntikiktbriyhrkgktuktype;
    }

    private String zrntikiktbriyenhrkgk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTIKIKTBRIYENHRKGK)
    public String getZrntikiktbriyenhrkgk() {
        return zrntikiktbriyenhrkgk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrntikiktbriyenhrkgk(String pZrntikiktbriyenhrkgk) {
        zrntikiktbriyenhrkgk = pZrntikiktbriyenhrkgk;
    }

    private String zrnyobiv32;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV32)
    public String getZrnyobiv32() {
        return zrnyobiv32;
    }

    public void setZrnyobiv32(String pZrnyobiv32) {
        zrnyobiv32 = pZrnyobiv32;
    }

    private String zrnkykymdseireki;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKYMDSEIREKI)
    public String getZrnkykymdseireki() {
        return zrnkykymdseireki;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykymdseireki(String pZrnkykymdseireki) {
        zrnkykymdseireki = pZrnkykymdseireki;
    }

    private String zrnphrkkknmidasikbn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNPHRKKKNMIDASIKBN)
    public String getZrnphrkkknmidasikbn() {
        return zrnphrkkknmidasikbn;
    }

    public void setZrnphrkkknmidasikbn(String pZrnphrkkknmidasikbn) {
        zrnphrkkknmidasikbn = pZrnphrkkknmidasikbn;
    }

    private String zrnhrkkknmsgkbn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHRKKKNMSGKBN)
    public String getZrnhrkkknmsgkbn() {
        return zrnhrkkknmsgkbn;
    }

    public void setZrnhrkkknmsgkbn(String pZrnhrkkknmsgkbn) {
        zrnhrkkknmsgkbn = pZrnhrkkknmsgkbn;
    }

    private String zrnhrkkaisuumsgkbn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHRKKAISUUMSGKBN)
    public String getZrnhrkkaisuumsgkbn() {
        return zrnhrkkaisuumsgkbn;
    }

    public void setZrnhrkkaisuumsgkbn(String pZrnhrkkaisuumsgkbn) {
        zrnhrkkaisuumsgkbn = pZrnhrkkaisuumsgkbn;
    }

    private String zrnphrkktuki;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNPHRKKTUKI)
    public String getZrnphrkktuki() {
        return zrnphrkktuki;
    }

    @DataConvert("toMultiByte")
    public void setZrnphrkktuki(String pZrnphrkktuki) {
        zrnphrkktuki = pZrnphrkktuki;
    }

    private String zrnhrkhouhoumsgkbn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHRKHOUHOUMSGKBN)
    public String getZrnhrkhouhoumsgkbn() {
        return zrnhrkhouhoumsgkbn;
    }

    public void setZrnhrkhouhoumsgkbn(String pZrnhrkhouhoumsgkbn) {
        zrnhrkhouhoumsgkbn = pZrnhrkhouhoumsgkbn;
    }

    private String zrnyobiv18;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV18)
    public String getZrnyobiv18() {
        return zrnyobiv18;
    }

    public void setZrnyobiv18(String pZrnyobiv18) {
        zrnyobiv18 = pZrnyobiv18;
    }

    private String zrnsyukyktkykrenban1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKRENBAN1)
    public String getZrnsyukyktkykrenban1() {
        return zrnsyukyktkykrenban1;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyukyktkykrenban1(String pZrnsyukyktkykrenban1) {
        zrnsyukyktkykrenban1 = pZrnsyukyktkykrenban1;
    }

    private String zrnsyukyktkykmsgkbn1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKMSGKBN1)
    public String getZrnsyukyktkykmsgkbn1() {
        return zrnsyukyktkykmsgkbn1;
    }

    public void setZrnsyukyktkykmsgkbn1(String pZrnsyukyktkykmsgkbn1) {
        zrnsyukyktkykmsgkbn1 = pZrnsyukyktkykmsgkbn1;
    }

    private String zrnsyukyktkyksmsgkbn1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSMSGKBN1)
    public String getZrnsyukyktkyksmsgkbn1() {
        return zrnsyukyktkyksmsgkbn1;
    }

    public void setZrnsyukyktkyksmsgkbn1(String pZrnsyukyktkyksmsgkbn1) {
        zrnsyukyktkyksmsgkbn1 = pZrnsyukyktkyksmsgkbn1;
    }

    private String zrnsyukyktkykhknkknmsgkbn1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKKNMSGKBN1)
    public String getZrnsyukyktkykhknkknmsgkbn1() {
        return zrnsyukyktkykhknkknmsgkbn1;
    }

    public void setZrnsyukyktkykhknkknmsgkbn1(String pZrnsyukyktkykhknkknmsgkbn1) {
        zrnsyukyktkykhknkknmsgkbn1 = pZrnsyukyktkykhknkknmsgkbn1;
    }

    private String zrnsyukyktkykstuukatype1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSTUUKATYPE1)
    public String getZrnsyukyktkykstuukatype1() {
        return zrnsyukyktkykstuukatype1;
    }

    public void setZrnsyukyktkykstuukatype1(String pZrnsyukyktkykstuukatype1) {
        zrnsyukyktkykstuukatype1 = pZrnsyukyktkykstuukatype1;
    }

    private String zrnsyukyktkykhknkngk1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKNGK1)
    public String getZrnsyukyktkykhknkngk1() {
        return zrnsyukyktkykhknkngk1;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsyukyktkykhknkngk1(String pZrnsyukyktkykhknkngk1) {
        zrnsyukyktkykhknkngk1 = pZrnsyukyktkykhknkngk1;
    }

    private String zrnsyutkdai1hknkknymdto1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI1HKNKKNYMDTO1)
    public String getZrnsyutkdai1hknkknymdto1() {
        return zrnsyutkdai1hknkknymdto1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai1hknkknymdto1(String pZrnsyutkdai1hknkknymdto1) {
        zrnsyutkdai1hknkknymdto1 = pZrnsyutkdai1hknkknymdto1;
    }

    private String zrnsyutkdai2hknkknymdto1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI2HKNKKNYMDTO1)
    public String getZrnsyutkdai2hknkknymdto1() {
        return zrnsyutkdai2hknkknymdto1;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai2hknkknymdto1(String pZrnsyutkdai2hknkknymdto1) {
        zrnsyutkdai2hknkknymdto1 = pZrnsyutkdai2hknkknymdto1;
    }

    private String zrnyobiv22;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22)
    public String getZrnyobiv22() {
        return zrnyobiv22;
    }

    public void setZrnyobiv22(String pZrnyobiv22) {
        zrnyobiv22 = pZrnyobiv22;
    }

    private String zrnsyukyktkykrenban2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKRENBAN2)
    public String getZrnsyukyktkykrenban2() {
        return zrnsyukyktkykrenban2;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyukyktkykrenban2(String pZrnsyukyktkykrenban2) {
        zrnsyukyktkykrenban2 = pZrnsyukyktkykrenban2;
    }

    private String zrnsyukyktkykmsgkbn2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKMSGKBN2)
    public String getZrnsyukyktkykmsgkbn2() {
        return zrnsyukyktkykmsgkbn2;
    }

    public void setZrnsyukyktkykmsgkbn2(String pZrnsyukyktkykmsgkbn2) {
        zrnsyukyktkykmsgkbn2 = pZrnsyukyktkykmsgkbn2;
    }

    private String zrnsyukyktkyksmsgkbn2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSMSGKBN2)
    public String getZrnsyukyktkyksmsgkbn2() {
        return zrnsyukyktkyksmsgkbn2;
    }

    public void setZrnsyukyktkyksmsgkbn2(String pZrnsyukyktkyksmsgkbn2) {
        zrnsyukyktkyksmsgkbn2 = pZrnsyukyktkyksmsgkbn2;
    }

    private String zrnsyukyktkykhknkknmsgkbn2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKKNMSGKBN2)
    public String getZrnsyukyktkykhknkknmsgkbn2() {
        return zrnsyukyktkykhknkknmsgkbn2;
    }

    public void setZrnsyukyktkykhknkknmsgkbn2(String pZrnsyukyktkykhknkknmsgkbn2) {
        zrnsyukyktkykhknkknmsgkbn2 = pZrnsyukyktkykhknkknmsgkbn2;
    }

    private String zrnsyukyktkykstuukatype2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSTUUKATYPE2)
    public String getZrnsyukyktkykstuukatype2() {
        return zrnsyukyktkykstuukatype2;
    }

    public void setZrnsyukyktkykstuukatype2(String pZrnsyukyktkykstuukatype2) {
        zrnsyukyktkykstuukatype2 = pZrnsyukyktkykstuukatype2;
    }

    private String zrnsyukyktkykhknkngk2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKNGK2)
    public String getZrnsyukyktkykhknkngk2() {
        return zrnsyukyktkykhknkngk2;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsyukyktkykhknkngk2(String pZrnsyukyktkykhknkngk2) {
        zrnsyukyktkykhknkngk2 = pZrnsyukyktkykhknkngk2;
    }

    private String zrnsyutkdai1hknkknymdto2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI1HKNKKNYMDTO2)
    public String getZrnsyutkdai1hknkknymdto2() {
        return zrnsyutkdai1hknkknymdto2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai1hknkknymdto2(String pZrnsyutkdai1hknkknymdto2) {
        zrnsyutkdai1hknkknymdto2 = pZrnsyutkdai1hknkknymdto2;
    }

    private String zrnsyutkdai2hknkknymdto2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI2HKNKKNYMDTO2)
    public String getZrnsyutkdai2hknkknymdto2() {
        return zrnsyutkdai2hknkknymdto2;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai2hknkknymdto2(String pZrnsyutkdai2hknkknymdto2) {
        zrnsyutkdai2hknkknymdto2 = pZrnsyutkdai2hknkknymdto2;
    }

    private String zrnyobiv22x2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22X2)
    public String getZrnyobiv22x2() {
        return zrnyobiv22x2;
    }

    public void setZrnyobiv22x2(String pZrnyobiv22x2) {
        zrnyobiv22x2 = pZrnyobiv22x2;
    }

    private String zrnsyukyktkykrenban3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKRENBAN3)
    public String getZrnsyukyktkykrenban3() {
        return zrnsyukyktkykrenban3;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyukyktkykrenban3(String pZrnsyukyktkykrenban3) {
        zrnsyukyktkykrenban3 = pZrnsyukyktkykrenban3;
    }

    private String zrnsyukyktkykmsgkbn3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKMSGKBN3)
    public String getZrnsyukyktkykmsgkbn3() {
        return zrnsyukyktkykmsgkbn3;
    }

    public void setZrnsyukyktkykmsgkbn3(String pZrnsyukyktkykmsgkbn3) {
        zrnsyukyktkykmsgkbn3 = pZrnsyukyktkykmsgkbn3;
    }

    private String zrnsyukyktkyksmsgkbn3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSMSGKBN3)
    public String getZrnsyukyktkyksmsgkbn3() {
        return zrnsyukyktkyksmsgkbn3;
    }

    public void setZrnsyukyktkyksmsgkbn3(String pZrnsyukyktkyksmsgkbn3) {
        zrnsyukyktkyksmsgkbn3 = pZrnsyukyktkyksmsgkbn3;
    }

    private String zrnsyukyktkykhknkknmsgkbn3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKKNMSGKBN3)
    public String getZrnsyukyktkykhknkknmsgkbn3() {
        return zrnsyukyktkykhknkknmsgkbn3;
    }

    public void setZrnsyukyktkykhknkknmsgkbn3(String pZrnsyukyktkykhknkknmsgkbn3) {
        zrnsyukyktkykhknkknmsgkbn3 = pZrnsyukyktkykhknkknmsgkbn3;
    }

    private String zrnsyukyktkykstuukatype3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSTUUKATYPE3)
    public String getZrnsyukyktkykstuukatype3() {
        return zrnsyukyktkykstuukatype3;
    }

    public void setZrnsyukyktkykstuukatype3(String pZrnsyukyktkykstuukatype3) {
        zrnsyukyktkykstuukatype3 = pZrnsyukyktkykstuukatype3;
    }

    private String zrnsyukyktkykhknkngk3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKNGK3)
    public String getZrnsyukyktkykhknkngk3() {
        return zrnsyukyktkykhknkngk3;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsyukyktkykhknkngk3(String pZrnsyukyktkykhknkngk3) {
        zrnsyukyktkykhknkngk3 = pZrnsyukyktkykhknkngk3;
    }

    private String zrnsyutkdai1hknkknymdto3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI1HKNKKNYMDTO3)
    public String getZrnsyutkdai1hknkknymdto3() {
        return zrnsyutkdai1hknkknymdto3;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai1hknkknymdto3(String pZrnsyutkdai1hknkknymdto3) {
        zrnsyutkdai1hknkknymdto3 = pZrnsyutkdai1hknkknymdto3;
    }

    private String zrnsyutkdai2hknkknymdto3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI2HKNKKNYMDTO3)
    public String getZrnsyutkdai2hknkknymdto3() {
        return zrnsyutkdai2hknkknymdto3;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai2hknkknymdto3(String pZrnsyutkdai2hknkknymdto3) {
        zrnsyutkdai2hknkknymdto3 = pZrnsyutkdai2hknkknymdto3;
    }

    private String zrnyobiv22x3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22X3)
    public String getZrnyobiv22x3() {
        return zrnyobiv22x3;
    }

    public void setZrnyobiv22x3(String pZrnyobiv22x3) {
        zrnyobiv22x3 = pZrnyobiv22x3;
    }

    private String zrnsyukyktkykrenban4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKRENBAN4)
    public String getZrnsyukyktkykrenban4() {
        return zrnsyukyktkykrenban4;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyukyktkykrenban4(String pZrnsyukyktkykrenban4) {
        zrnsyukyktkykrenban4 = pZrnsyukyktkykrenban4;
    }

    private String zrnsyukyktkykmsgkbn4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKMSGKBN4)
    public String getZrnsyukyktkykmsgkbn4() {
        return zrnsyukyktkykmsgkbn4;
    }

    public void setZrnsyukyktkykmsgkbn4(String pZrnsyukyktkykmsgkbn4) {
        zrnsyukyktkykmsgkbn4 = pZrnsyukyktkykmsgkbn4;
    }

    private String zrnsyukyktkyksmsgkbn4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSMSGKBN4)
    public String getZrnsyukyktkyksmsgkbn4() {
        return zrnsyukyktkyksmsgkbn4;
    }

    public void setZrnsyukyktkyksmsgkbn4(String pZrnsyukyktkyksmsgkbn4) {
        zrnsyukyktkyksmsgkbn4 = pZrnsyukyktkyksmsgkbn4;
    }

    private String zrnsyukyktkykhknkknmsgkbn4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKKNMSGKBN4)
    public String getZrnsyukyktkykhknkknmsgkbn4() {
        return zrnsyukyktkykhknkknmsgkbn4;
    }

    public void setZrnsyukyktkykhknkknmsgkbn4(String pZrnsyukyktkykhknkknmsgkbn4) {
        zrnsyukyktkykhknkknmsgkbn4 = pZrnsyukyktkykhknkknmsgkbn4;
    }

    private String zrnsyukyktkykstuukatype4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSTUUKATYPE4)
    public String getZrnsyukyktkykstuukatype4() {
        return zrnsyukyktkykstuukatype4;
    }

    public void setZrnsyukyktkykstuukatype4(String pZrnsyukyktkykstuukatype4) {
        zrnsyukyktkykstuukatype4 = pZrnsyukyktkykstuukatype4;
    }

    private String zrnsyukyktkykhknkngk4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKNGK4)
    public String getZrnsyukyktkykhknkngk4() {
        return zrnsyukyktkykhknkngk4;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsyukyktkykhknkngk4(String pZrnsyukyktkykhknkngk4) {
        zrnsyukyktkykhknkngk4 = pZrnsyukyktkykhknkngk4;
    }

    private String zrnsyutkdai1hknkknymdto4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI1HKNKKNYMDTO4)
    public String getZrnsyutkdai1hknkknymdto4() {
        return zrnsyutkdai1hknkknymdto4;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai1hknkknymdto4(String pZrnsyutkdai1hknkknymdto4) {
        zrnsyutkdai1hknkknymdto4 = pZrnsyutkdai1hknkknymdto4;
    }

    private String zrnsyutkdai2hknkknymdto4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI2HKNKKNYMDTO4)
    public String getZrnsyutkdai2hknkknymdto4() {
        return zrnsyutkdai2hknkknymdto4;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai2hknkknymdto4(String pZrnsyutkdai2hknkknymdto4) {
        zrnsyutkdai2hknkknymdto4 = pZrnsyutkdai2hknkknymdto4;
    }

    private String zrnyobiv22x4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22X4)
    public String getZrnyobiv22x4() {
        return zrnyobiv22x4;
    }

    public void setZrnyobiv22x4(String pZrnyobiv22x4) {
        zrnyobiv22x4 = pZrnyobiv22x4;
    }

    private String zrnsyukyktkykrenban5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKRENBAN5)
    public String getZrnsyukyktkykrenban5() {
        return zrnsyukyktkykrenban5;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyukyktkykrenban5(String pZrnsyukyktkykrenban5) {
        zrnsyukyktkykrenban5 = pZrnsyukyktkykrenban5;
    }

    private String zrnsyukyktkykmsgkbn5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKMSGKBN5)
    public String getZrnsyukyktkykmsgkbn5() {
        return zrnsyukyktkykmsgkbn5;
    }

    public void setZrnsyukyktkykmsgkbn5(String pZrnsyukyktkykmsgkbn5) {
        zrnsyukyktkykmsgkbn5 = pZrnsyukyktkykmsgkbn5;
    }

    private String zrnsyukyktkyksmsgkbn5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSMSGKBN5)
    public String getZrnsyukyktkyksmsgkbn5() {
        return zrnsyukyktkyksmsgkbn5;
    }

    public void setZrnsyukyktkyksmsgkbn5(String pZrnsyukyktkyksmsgkbn5) {
        zrnsyukyktkyksmsgkbn5 = pZrnsyukyktkyksmsgkbn5;
    }

    private String zrnsyukyktkykhknkknmsgkbn5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKKNMSGKBN5)
    public String getZrnsyukyktkykhknkknmsgkbn5() {
        return zrnsyukyktkykhknkknmsgkbn5;
    }

    public void setZrnsyukyktkykhknkknmsgkbn5(String pZrnsyukyktkykhknkknmsgkbn5) {
        zrnsyukyktkykhknkknmsgkbn5 = pZrnsyukyktkykhknkknmsgkbn5;
    }

    private String zrnsyukyktkykstuukatype5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSTUUKATYPE5)
    public String getZrnsyukyktkykstuukatype5() {
        return zrnsyukyktkykstuukatype5;
    }

    public void setZrnsyukyktkykstuukatype5(String pZrnsyukyktkykstuukatype5) {
        zrnsyukyktkykstuukatype5 = pZrnsyukyktkykstuukatype5;
    }

    private String zrnsyukyktkykhknkngk5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKNGK5)
    public String getZrnsyukyktkykhknkngk5() {
        return zrnsyukyktkykhknkngk5;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsyukyktkykhknkngk5(String pZrnsyukyktkykhknkngk5) {
        zrnsyukyktkykhknkngk5 = pZrnsyukyktkykhknkngk5;
    }

    private String zrnsyutkdai1hknkknymdto5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI1HKNKKNYMDTO5)
    public String getZrnsyutkdai1hknkknymdto5() {
        return zrnsyutkdai1hknkknymdto5;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai1hknkknymdto5(String pZrnsyutkdai1hknkknymdto5) {
        zrnsyutkdai1hknkknymdto5 = pZrnsyutkdai1hknkknymdto5;
    }

    private String zrnsyutkdai2hknkknymdto5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI2HKNKKNYMDTO5)
    public String getZrnsyutkdai2hknkknymdto5() {
        return zrnsyutkdai2hknkknymdto5;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai2hknkknymdto5(String pZrnsyutkdai2hknkknymdto5) {
        zrnsyutkdai2hknkknymdto5 = pZrnsyutkdai2hknkknymdto5;
    }

    private String zrnyobiv22x5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22X5)
    public String getZrnyobiv22x5() {
        return zrnyobiv22x5;
    }

    public void setZrnyobiv22x5(String pZrnyobiv22x5) {
        zrnyobiv22x5 = pZrnyobiv22x5;
    }

    private String zrnsyukyktkykrenban6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKRENBAN6)
    public String getZrnsyukyktkykrenban6() {
        return zrnsyukyktkykrenban6;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyukyktkykrenban6(String pZrnsyukyktkykrenban6) {
        zrnsyukyktkykrenban6 = pZrnsyukyktkykrenban6;
    }

    private String zrnsyukyktkykmsgkbn6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKMSGKBN6)
    public String getZrnsyukyktkykmsgkbn6() {
        return zrnsyukyktkykmsgkbn6;
    }

    public void setZrnsyukyktkykmsgkbn6(String pZrnsyukyktkykmsgkbn6) {
        zrnsyukyktkykmsgkbn6 = pZrnsyukyktkykmsgkbn6;
    }

    private String zrnsyukyktkyksmsgkbn6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSMSGKBN6)
    public String getZrnsyukyktkyksmsgkbn6() {
        return zrnsyukyktkyksmsgkbn6;
    }

    public void setZrnsyukyktkyksmsgkbn6(String pZrnsyukyktkyksmsgkbn6) {
        zrnsyukyktkyksmsgkbn6 = pZrnsyukyktkyksmsgkbn6;
    }

    private String zrnsyukyktkykhknkknmsgkbn6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKKNMSGKBN6)
    public String getZrnsyukyktkykhknkknmsgkbn6() {
        return zrnsyukyktkykhknkknmsgkbn6;
    }

    public void setZrnsyukyktkykhknkknmsgkbn6(String pZrnsyukyktkykhknkknmsgkbn6) {
        zrnsyukyktkykhknkknmsgkbn6 = pZrnsyukyktkykhknkknmsgkbn6;
    }

    private String zrnsyukyktkykstuukatype6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSTUUKATYPE6)
    public String getZrnsyukyktkykstuukatype6() {
        return zrnsyukyktkykstuukatype6;
    }

    public void setZrnsyukyktkykstuukatype6(String pZrnsyukyktkykstuukatype6) {
        zrnsyukyktkykstuukatype6 = pZrnsyukyktkykstuukatype6;
    }

    private String zrnsyukyktkykhknkngk6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKNGK6)
    public String getZrnsyukyktkykhknkngk6() {
        return zrnsyukyktkykhknkngk6;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsyukyktkykhknkngk6(String pZrnsyukyktkykhknkngk6) {
        zrnsyukyktkykhknkngk6 = pZrnsyukyktkykhknkngk6;
    }

    private String zrnsyutkdai1hknkknymdto6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI1HKNKKNYMDTO6)
    public String getZrnsyutkdai1hknkknymdto6() {
        return zrnsyutkdai1hknkknymdto6;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai1hknkknymdto6(String pZrnsyutkdai1hknkknymdto6) {
        zrnsyutkdai1hknkknymdto6 = pZrnsyutkdai1hknkknymdto6;
    }

    private String zrnsyutkdai2hknkknymdto6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI2HKNKKNYMDTO6)
    public String getZrnsyutkdai2hknkknymdto6() {
        return zrnsyutkdai2hknkknymdto6;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai2hknkknymdto6(String pZrnsyutkdai2hknkknymdto6) {
        zrnsyutkdai2hknkknymdto6 = pZrnsyutkdai2hknkknymdto6;
    }

    private String zrnyobiv22x6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22X6)
    public String getZrnyobiv22x6() {
        return zrnyobiv22x6;
    }

    public void setZrnyobiv22x6(String pZrnyobiv22x6) {
        zrnyobiv22x6 = pZrnyobiv22x6;
    }

    private String zrnsyukyktkykrenban7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKRENBAN7)
    public String getZrnsyukyktkykrenban7() {
        return zrnsyukyktkykrenban7;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyukyktkykrenban7(String pZrnsyukyktkykrenban7) {
        zrnsyukyktkykrenban7 = pZrnsyukyktkykrenban7;
    }

    private String zrnsyukyktkykmsgkbn7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKMSGKBN7)
    public String getZrnsyukyktkykmsgkbn7() {
        return zrnsyukyktkykmsgkbn7;
    }

    public void setZrnsyukyktkykmsgkbn7(String pZrnsyukyktkykmsgkbn7) {
        zrnsyukyktkykmsgkbn7 = pZrnsyukyktkykmsgkbn7;
    }

    private String zrnsyukyktkyksmsgkbn7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSMSGKBN7)
    public String getZrnsyukyktkyksmsgkbn7() {
        return zrnsyukyktkyksmsgkbn7;
    }

    public void setZrnsyukyktkyksmsgkbn7(String pZrnsyukyktkyksmsgkbn7) {
        zrnsyukyktkyksmsgkbn7 = pZrnsyukyktkyksmsgkbn7;
    }

    private String zrnsyukyktkykhknkknmsgkbn7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKKNMSGKBN7)
    public String getZrnsyukyktkykhknkknmsgkbn7() {
        return zrnsyukyktkykhknkknmsgkbn7;
    }

    public void setZrnsyukyktkykhknkknmsgkbn7(String pZrnsyukyktkykhknkknmsgkbn7) {
        zrnsyukyktkykhknkknmsgkbn7 = pZrnsyukyktkykhknkknmsgkbn7;
    }

    private String zrnsyukyktkykstuukatype7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSTUUKATYPE7)
    public String getZrnsyukyktkykstuukatype7() {
        return zrnsyukyktkykstuukatype7;
    }

    public void setZrnsyukyktkykstuukatype7(String pZrnsyukyktkykstuukatype7) {
        zrnsyukyktkykstuukatype7 = pZrnsyukyktkykstuukatype7;
    }

    private String zrnsyukyktkykhknkngk7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKNGK7)
    public String getZrnsyukyktkykhknkngk7() {
        return zrnsyukyktkykhknkngk7;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsyukyktkykhknkngk7(String pZrnsyukyktkykhknkngk7) {
        zrnsyukyktkykhknkngk7 = pZrnsyukyktkykhknkngk7;
    }

    private String zrnsyutkdai1hknkknymdto7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI1HKNKKNYMDTO7)
    public String getZrnsyutkdai1hknkknymdto7() {
        return zrnsyutkdai1hknkknymdto7;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai1hknkknymdto7(String pZrnsyutkdai1hknkknymdto7) {
        zrnsyutkdai1hknkknymdto7 = pZrnsyutkdai1hknkknymdto7;
    }

    private String zrnsyutkdai2hknkknymdto7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI2HKNKKNYMDTO7)
    public String getZrnsyutkdai2hknkknymdto7() {
        return zrnsyutkdai2hknkknymdto7;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai2hknkknymdto7(String pZrnsyutkdai2hknkknymdto7) {
        zrnsyutkdai2hknkknymdto7 = pZrnsyutkdai2hknkknymdto7;
    }

    private String zrnyobiv22x7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22X7)
    public String getZrnyobiv22x7() {
        return zrnyobiv22x7;
    }

    public void setZrnyobiv22x7(String pZrnyobiv22x7) {
        zrnyobiv22x7 = pZrnyobiv22x7;
    }

    private String zrnsyukyktkykrenban8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKRENBAN8)
    public String getZrnsyukyktkykrenban8() {
        return zrnsyukyktkykrenban8;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyukyktkykrenban8(String pZrnsyukyktkykrenban8) {
        zrnsyukyktkykrenban8 = pZrnsyukyktkykrenban8;
    }

    private String zrnsyukyktkykmsgkbn8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKMSGKBN8)
    public String getZrnsyukyktkykmsgkbn8() {
        return zrnsyukyktkykmsgkbn8;
    }

    public void setZrnsyukyktkykmsgkbn8(String pZrnsyukyktkykmsgkbn8) {
        zrnsyukyktkykmsgkbn8 = pZrnsyukyktkykmsgkbn8;
    }

    private String zrnsyukyktkyksmsgkbn8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSMSGKBN8)
    public String getZrnsyukyktkyksmsgkbn8() {
        return zrnsyukyktkyksmsgkbn8;
    }

    public void setZrnsyukyktkyksmsgkbn8(String pZrnsyukyktkyksmsgkbn8) {
        zrnsyukyktkyksmsgkbn8 = pZrnsyukyktkyksmsgkbn8;
    }

    private String zrnsyukyktkykhknkknmsgkbn8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKKNMSGKBN8)
    public String getZrnsyukyktkykhknkknmsgkbn8() {
        return zrnsyukyktkykhknkknmsgkbn8;
    }

    public void setZrnsyukyktkykhknkknmsgkbn8(String pZrnsyukyktkykhknkknmsgkbn8) {
        zrnsyukyktkykhknkknmsgkbn8 = pZrnsyukyktkykhknkknmsgkbn8;
    }

    private String zrnsyukyktkykstuukatype8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSTUUKATYPE8)
    public String getZrnsyukyktkykstuukatype8() {
        return zrnsyukyktkykstuukatype8;
    }

    public void setZrnsyukyktkykstuukatype8(String pZrnsyukyktkykstuukatype8) {
        zrnsyukyktkykstuukatype8 = pZrnsyukyktkykstuukatype8;
    }

    private String zrnsyukyktkykhknkngk8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKNGK8)
    public String getZrnsyukyktkykhknkngk8() {
        return zrnsyukyktkykhknkngk8;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsyukyktkykhknkngk8(String pZrnsyukyktkykhknkngk8) {
        zrnsyukyktkykhknkngk8 = pZrnsyukyktkykhknkngk8;
    }

    private String zrnsyutkdai1hknkknymdto8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI1HKNKKNYMDTO8)
    public String getZrnsyutkdai1hknkknymdto8() {
        return zrnsyutkdai1hknkknymdto8;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai1hknkknymdto8(String pZrnsyutkdai1hknkknymdto8) {
        zrnsyutkdai1hknkknymdto8 = pZrnsyutkdai1hknkknymdto8;
    }

    private String zrnsyutkdai2hknkknymdto8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI2HKNKKNYMDTO8)
    public String getZrnsyutkdai2hknkknymdto8() {
        return zrnsyutkdai2hknkknymdto8;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai2hknkknymdto8(String pZrnsyutkdai2hknkknymdto8) {
        zrnsyutkdai2hknkknymdto8 = pZrnsyutkdai2hknkknymdto8;
    }

    private String zrnyobiv22x8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22X8)
    public String getZrnyobiv22x8() {
        return zrnyobiv22x8;
    }

    public void setZrnyobiv22x8(String pZrnyobiv22x8) {
        zrnyobiv22x8 = pZrnyobiv22x8;
    }

    private String zrnsyukyktkykrenban9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKRENBAN9)
    public String getZrnsyukyktkykrenban9() {
        return zrnsyukyktkykrenban9;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyukyktkykrenban9(String pZrnsyukyktkykrenban9) {
        zrnsyukyktkykrenban9 = pZrnsyukyktkykrenban9;
    }

    private String zrnsyukyktkykmsgkbn9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKMSGKBN9)
    public String getZrnsyukyktkykmsgkbn9() {
        return zrnsyukyktkykmsgkbn9;
    }

    public void setZrnsyukyktkykmsgkbn9(String pZrnsyukyktkykmsgkbn9) {
        zrnsyukyktkykmsgkbn9 = pZrnsyukyktkykmsgkbn9;
    }

    private String zrnsyukyktkyksmsgkbn9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSMSGKBN9)
    public String getZrnsyukyktkyksmsgkbn9() {
        return zrnsyukyktkyksmsgkbn9;
    }

    public void setZrnsyukyktkyksmsgkbn9(String pZrnsyukyktkyksmsgkbn9) {
        zrnsyukyktkyksmsgkbn9 = pZrnsyukyktkyksmsgkbn9;
    }

    private String zrnsyukyktkykhknkknmsgkbn9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKKNMSGKBN9)
    public String getZrnsyukyktkykhknkknmsgkbn9() {
        return zrnsyukyktkykhknkknmsgkbn9;
    }

    public void setZrnsyukyktkykhknkknmsgkbn9(String pZrnsyukyktkykhknkknmsgkbn9) {
        zrnsyukyktkykhknkknmsgkbn9 = pZrnsyukyktkykhknkknmsgkbn9;
    }

    private String zrnsyukyktkykstuukatype9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSTUUKATYPE9)
    public String getZrnsyukyktkykstuukatype9() {
        return zrnsyukyktkykstuukatype9;
    }

    public void setZrnsyukyktkykstuukatype9(String pZrnsyukyktkykstuukatype9) {
        zrnsyukyktkykstuukatype9 = pZrnsyukyktkykstuukatype9;
    }

    private String zrnsyukyktkykhknkngk9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKNGK9)
    public String getZrnsyukyktkykhknkngk9() {
        return zrnsyukyktkykhknkngk9;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsyukyktkykhknkngk9(String pZrnsyukyktkykhknkngk9) {
        zrnsyukyktkykhknkngk9 = pZrnsyukyktkykhknkngk9;
    }

    private String zrnsyutkdai1hknkknymdto9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI1HKNKKNYMDTO9)
    public String getZrnsyutkdai1hknkknymdto9() {
        return zrnsyutkdai1hknkknymdto9;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai1hknkknymdto9(String pZrnsyutkdai1hknkknymdto9) {
        zrnsyutkdai1hknkknymdto9 = pZrnsyutkdai1hknkknymdto9;
    }

    private String zrnsyutkdai2hknkknymdto9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI2HKNKKNYMDTO9)
    public String getZrnsyutkdai2hknkknymdto9() {
        return zrnsyutkdai2hknkknymdto9;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai2hknkknymdto9(String pZrnsyutkdai2hknkknymdto9) {
        zrnsyutkdai2hknkknymdto9 = pZrnsyutkdai2hknkknymdto9;
    }

    private String zrnyobiv22x9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22X9)
    public String getZrnyobiv22x9() {
        return zrnyobiv22x9;
    }

    public void setZrnyobiv22x9(String pZrnyobiv22x9) {
        zrnyobiv22x9 = pZrnyobiv22x9;
    }

    private String zrnsyukyktkykrenban10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKRENBAN10)
    public String getZrnsyukyktkykrenban10() {
        return zrnsyukyktkykrenban10;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsyukyktkykrenban10(String pZrnsyukyktkykrenban10) {
        zrnsyukyktkykrenban10 = pZrnsyukyktkykrenban10;
    }

    private String zrnsyukyktkykmsgkbn10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKMSGKBN10)
    public String getZrnsyukyktkykmsgkbn10() {
        return zrnsyukyktkykmsgkbn10;
    }

    public void setZrnsyukyktkykmsgkbn10(String pZrnsyukyktkykmsgkbn10) {
        zrnsyukyktkykmsgkbn10 = pZrnsyukyktkykmsgkbn10;
    }

    private String zrnsyukyktkyksmsgkbn10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSMSGKBN10)
    public String getZrnsyukyktkyksmsgkbn10() {
        return zrnsyukyktkyksmsgkbn10;
    }

    public void setZrnsyukyktkyksmsgkbn10(String pZrnsyukyktkyksmsgkbn10) {
        zrnsyukyktkyksmsgkbn10 = pZrnsyukyktkyksmsgkbn10;
    }

    private String zrnsyukyktkykhknkknmsgkbn10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKKNMSGKBN10)
    public String getZrnsyukyktkykhknkknmsgkbn10() {
        return zrnsyukyktkykhknkknmsgkbn10;
    }

    public void setZrnsyukyktkykhknkknmsgkbn10(String pZrnsyukyktkykhknkknmsgkbn10) {
        zrnsyukyktkykhknkknmsgkbn10 = pZrnsyukyktkykhknkknmsgkbn10;
    }

    private String zrnsyukyktkykstuukatype10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKSTUUKATYPE10)
    public String getZrnsyukyktkykstuukatype10() {
        return zrnsyukyktkykstuukatype10;
    }

    public void setZrnsyukyktkykstuukatype10(String pZrnsyukyktkykstuukatype10) {
        zrnsyukyktkykstuukatype10 = pZrnsyukyktkykstuukatype10;
    }

    private String zrnsyukyktkykhknkngk10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUKYKTKYKHKNKNGK10)
    public String getZrnsyukyktkykhknkngk10() {
        return zrnsyukyktkykhknkngk10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsyukyktkykhknkngk10(String pZrnsyukyktkykhknkngk10) {
        zrnsyukyktkykhknkngk10 = pZrnsyukyktkykhknkngk10;
    }

    private String zrnsyutkdai1hknkknymdto10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI1HKNKKNYMDTO10)
    public String getZrnsyutkdai1hknkknymdto10() {
        return zrnsyutkdai1hknkknymdto10;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai1hknkknymdto10(String pZrnsyutkdai1hknkknymdto10) {
        zrnsyutkdai1hknkknymdto10 = pZrnsyutkdai1hknkknymdto10;
    }

    private String zrnsyutkdai2hknkknymdto10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSYUTKDAI2HKNKKNYMDTO10)
    public String getZrnsyutkdai2hknkknymdto10() {
        return zrnsyutkdai2hknkknymdto10;
    }

    @DataConvert("toMultiByte")
    public void setZrnsyutkdai2hknkknymdto10(String pZrnsyutkdai2hknkknymdto10) {
        zrnsyutkdai2hknkknymdto10 = pZrnsyutkdai2hknkknymdto10;
    }

    private String zrnyobiv22x10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV22X10)
    public String getZrnyobiv22x10() {
        return zrnyobiv22x10;
    }

    public void setZrnyobiv22x10(String pZrnyobiv22x10) {
        zrnyobiv22x10 = pZrnyobiv22x10;
    }

    private String zrnyobiv50;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV50)
    public String getZrnyobiv50() {
        return zrnyobiv50;
    }

    public void setZrnyobiv50(String pZrnyobiv50) {
        zrnyobiv50 = pZrnyobiv50;
    }

    private String zrnkykniyustmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD1)
    public String getZrnkykniyustmsgcd1() {
        return zrnkykniyustmsgcd1;
    }

    public void setZrnkykniyustmsgcd1(String pZrnkykniyustmsgcd1) {
        zrnkykniyustmsgcd1 = pZrnkykniyustmsgcd1;
    }

    private String zrnkykniyustmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD2)
    public String getZrnkykniyustmsgcd2() {
        return zrnkykniyustmsgcd2;
    }

    public void setZrnkykniyustmsgcd2(String pZrnkykniyustmsgcd2) {
        zrnkykniyustmsgcd2 = pZrnkykniyustmsgcd2;
    }

    private String zrnkykniyustmsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD3)
    public String getZrnkykniyustmsgcd3() {
        return zrnkykniyustmsgcd3;
    }

    public void setZrnkykniyustmsgcd3(String pZrnkykniyustmsgcd3) {
        zrnkykniyustmsgcd3 = pZrnkykniyustmsgcd3;
    }

    private String zrnkykniyustmsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD4)
    public String getZrnkykniyustmsgcd4() {
        return zrnkykniyustmsgcd4;
    }

    public void setZrnkykniyustmsgcd4(String pZrnkykniyustmsgcd4) {
        zrnkykniyustmsgcd4 = pZrnkykniyustmsgcd4;
    }

    private String zrnkykniyustmsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD5)
    public String getZrnkykniyustmsgcd5() {
        return zrnkykniyustmsgcd5;
    }

    public void setZrnkykniyustmsgcd5(String pZrnkykniyustmsgcd5) {
        zrnkykniyustmsgcd5 = pZrnkykniyustmsgcd5;
    }

    private String zrnkykniyustmsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD6)
    public String getZrnkykniyustmsgcd6() {
        return zrnkykniyustmsgcd6;
    }

    public void setZrnkykniyustmsgcd6(String pZrnkykniyustmsgcd6) {
        zrnkykniyustmsgcd6 = pZrnkykniyustmsgcd6;
    }

    private String zrnkykniyustmsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD7)
    public String getZrnkykniyustmsgcd7() {
        return zrnkykniyustmsgcd7;
    }

    public void setZrnkykniyustmsgcd7(String pZrnkykniyustmsgcd7) {
        zrnkykniyustmsgcd7 = pZrnkykniyustmsgcd7;
    }

    private String zrnkykniyustmsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD8)
    public String getZrnkykniyustmsgcd8() {
        return zrnkykniyustmsgcd8;
    }

    public void setZrnkykniyustmsgcd8(String pZrnkykniyustmsgcd8) {
        zrnkykniyustmsgcd8 = pZrnkykniyustmsgcd8;
    }

    private String zrnkykniyustmsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD9)
    public String getZrnkykniyustmsgcd9() {
        return zrnkykniyustmsgcd9;
    }

    public void setZrnkykniyustmsgcd9(String pZrnkykniyustmsgcd9) {
        zrnkykniyustmsgcd9 = pZrnkykniyustmsgcd9;
    }

    private String zrnkykniyustmsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD10)
    public String getZrnkykniyustmsgcd10() {
        return zrnkykniyustmsgcd10;
    }

    public void setZrnkykniyustmsgcd10(String pZrnkykniyustmsgcd10) {
        zrnkykniyustmsgcd10 = pZrnkykniyustmsgcd10;
    }

    private String zrnkykniyustmsgcd11;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD11)
    public String getZrnkykniyustmsgcd11() {
        return zrnkykniyustmsgcd11;
    }

    public void setZrnkykniyustmsgcd11(String pZrnkykniyustmsgcd11) {
        zrnkykniyustmsgcd11 = pZrnkykniyustmsgcd11;
    }

    private String zrnkykniyustmsgcd12;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD12)
    public String getZrnkykniyustmsgcd12() {
        return zrnkykniyustmsgcd12;
    }

    public void setZrnkykniyustmsgcd12(String pZrnkykniyustmsgcd12) {
        zrnkykniyustmsgcd12 = pZrnkykniyustmsgcd12;
    }

    private String zrnkykniyustmsgcd13;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD13)
    public String getZrnkykniyustmsgcd13() {
        return zrnkykniyustmsgcd13;
    }

    public void setZrnkykniyustmsgcd13(String pZrnkykniyustmsgcd13) {
        zrnkykniyustmsgcd13 = pZrnkykniyustmsgcd13;
    }

    private String zrnkykniyustmsgcd14;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD14)
    public String getZrnkykniyustmsgcd14() {
        return zrnkykniyustmsgcd14;
    }

    public void setZrnkykniyustmsgcd14(String pZrnkykniyustmsgcd14) {
        zrnkykniyustmsgcd14 = pZrnkykniyustmsgcd14;
    }

    private String zrnkykniyustmsgcd15;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTMSGCD15)
    public String getZrnkykniyustmsgcd15() {
        return zrnkykniyustmsgcd15;
    }

    public void setZrnkykniyustmsgcd15(String pZrnkykniyustmsgcd15) {
        zrnkykniyustmsgcd15 = pZrnkykniyustmsgcd15;
    }

    private String zrnkykniyustitjbrptuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTITJBRPTUUKTYPE)
    public String getZrnkykniyustitjbrptuuktype() {
        return zrnkykniyustitjbrptuuktype;
    }

    public void setZrnkykniyustitjbrptuuktype(String pZrnkykniyustitjbrptuuktype) {
        zrnkykniyustitjbrptuuktype = pZrnkykniyustitjbrptuuktype;
    }

    private String zrnkykniyustitjbrp;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTITJBRP)
    public String getZrnkykniyustitjbrp() {
        return zrnkykniyustitjbrp;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkykniyustitjbrp(String pZrnkykniyustitjbrp) {
        zrnkykniyustitjbrp = pZrnkykniyustitjbrp;
    }

    private String zrnkykniyustkihonstype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTKIHONSTYPE)
    public String getZrnkykniyustkihonstype() {
        return zrnkykniyustkihonstype;
    }

    public void setZrnkykniyustkihonstype(String pZrnkykniyustkihonstype) {
        zrnkykniyustkihonstype = pZrnkykniyustkihonstype;
    }

    private String zrnkykniyustkihons;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKNIYUSTKIHONS)
    public String getZrnkykniyustkihons() {
        return zrnkykniyustkihons;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkykniyustkihons(String pZrnkykniyustkihons) {
        zrnkykniyustkihons = pZrnkykniyustkihons;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrnsonotanyranmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD1)
    public String getZrnsonotanyranmsgcd1() {
        return zrnsonotanyranmsgcd1;
    }

    public void setZrnsonotanyranmsgcd1(String pZrnsonotanyranmsgcd1) {
        zrnsonotanyranmsgcd1 = pZrnsonotanyranmsgcd1;
    }

    private String zrnsonotanyranmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD2)
    public String getZrnsonotanyranmsgcd2() {
        return zrnsonotanyranmsgcd2;
    }

    public void setZrnsonotanyranmsgcd2(String pZrnsonotanyranmsgcd2) {
        zrnsonotanyranmsgcd2 = pZrnsonotanyranmsgcd2;
    }

    private String zrnsonotanyranmsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD3)
    public String getZrnsonotanyranmsgcd3() {
        return zrnsonotanyranmsgcd3;
    }

    public void setZrnsonotanyranmsgcd3(String pZrnsonotanyranmsgcd3) {
        zrnsonotanyranmsgcd3 = pZrnsonotanyranmsgcd3;
    }

    private String zrnsonotanyranmsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD4)
    public String getZrnsonotanyranmsgcd4() {
        return zrnsonotanyranmsgcd4;
    }

    public void setZrnsonotanyranmsgcd4(String pZrnsonotanyranmsgcd4) {
        zrnsonotanyranmsgcd4 = pZrnsonotanyranmsgcd4;
    }

    private String zrnsonotanyranmsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD5)
    public String getZrnsonotanyranmsgcd5() {
        return zrnsonotanyranmsgcd5;
    }

    public void setZrnsonotanyranmsgcd5(String pZrnsonotanyranmsgcd5) {
        zrnsonotanyranmsgcd5 = pZrnsonotanyranmsgcd5;
    }

    private String zrnsonotanyranmsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD6)
    public String getZrnsonotanyranmsgcd6() {
        return zrnsonotanyranmsgcd6;
    }

    public void setZrnsonotanyranmsgcd6(String pZrnsonotanyranmsgcd6) {
        zrnsonotanyranmsgcd6 = pZrnsonotanyranmsgcd6;
    }

    private String zrnsonotanyranmsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD7)
    public String getZrnsonotanyranmsgcd7() {
        return zrnsonotanyranmsgcd7;
    }

    public void setZrnsonotanyranmsgcd7(String pZrnsonotanyranmsgcd7) {
        zrnsonotanyranmsgcd7 = pZrnsonotanyranmsgcd7;
    }

    private String zrnsonotanyranmsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD8)
    public String getZrnsonotanyranmsgcd8() {
        return zrnsonotanyranmsgcd8;
    }

    public void setZrnsonotanyranmsgcd8(String pZrnsonotanyranmsgcd8) {
        zrnsonotanyranmsgcd8 = pZrnsonotanyranmsgcd8;
    }

    private String zrnsonotanyranmsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD9)
    public String getZrnsonotanyranmsgcd9() {
        return zrnsonotanyranmsgcd9;
    }

    public void setZrnsonotanyranmsgcd9(String pZrnsonotanyranmsgcd9) {
        zrnsonotanyranmsgcd9 = pZrnsonotanyranmsgcd9;
    }

    private String zrnsonotanyranmsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD10)
    public String getZrnsonotanyranmsgcd10() {
        return zrnsonotanyranmsgcd10;
    }

    public void setZrnsonotanyranmsgcd10(String pZrnsonotanyranmsgcd10) {
        zrnsonotanyranmsgcd10 = pZrnsonotanyranmsgcd10;
    }

    private String zrnsonotanyranmsgcd11;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD11)
    public String getZrnsonotanyranmsgcd11() {
        return zrnsonotanyranmsgcd11;
    }

    public void setZrnsonotanyranmsgcd11(String pZrnsonotanyranmsgcd11) {
        zrnsonotanyranmsgcd11 = pZrnsonotanyranmsgcd11;
    }

    private String zrnsonotanyranmsgcd12;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD12)
    public String getZrnsonotanyranmsgcd12() {
        return zrnsonotanyranmsgcd12;
    }

    public void setZrnsonotanyranmsgcd12(String pZrnsonotanyranmsgcd12) {
        zrnsonotanyranmsgcd12 = pZrnsonotanyranmsgcd12;
    }

    private String zrnsonotanyranmsgcd13;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD13)
    public String getZrnsonotanyranmsgcd13() {
        return zrnsonotanyranmsgcd13;
    }

    public void setZrnsonotanyranmsgcd13(String pZrnsonotanyranmsgcd13) {
        zrnsonotanyranmsgcd13 = pZrnsonotanyranmsgcd13;
    }

    private String zrnsonotanyranmsgcd14;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD14)
    public String getZrnsonotanyranmsgcd14() {
        return zrnsonotanyranmsgcd14;
    }

    public void setZrnsonotanyranmsgcd14(String pZrnsonotanyranmsgcd14) {
        zrnsonotanyranmsgcd14 = pZrnsonotanyranmsgcd14;
    }

    private String zrnsonotanyranmsgcd15;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD15)
    public String getZrnsonotanyranmsgcd15() {
        return zrnsonotanyranmsgcd15;
    }

    public void setZrnsonotanyranmsgcd15(String pZrnsonotanyranmsgcd15) {
        zrnsonotanyranmsgcd15 = pZrnsonotanyranmsgcd15;
    }

    private String zrnsonotanyranmsgcd16;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD16)
    public String getZrnsonotanyranmsgcd16() {
        return zrnsonotanyranmsgcd16;
    }

    public void setZrnsonotanyranmsgcd16(String pZrnsonotanyranmsgcd16) {
        zrnsonotanyranmsgcd16 = pZrnsonotanyranmsgcd16;
    }

    private String zrnsonotanyranmsgcd17;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD17)
    public String getZrnsonotanyranmsgcd17() {
        return zrnsonotanyranmsgcd17;
    }

    public void setZrnsonotanyranmsgcd17(String pZrnsonotanyranmsgcd17) {
        zrnsonotanyranmsgcd17 = pZrnsonotanyranmsgcd17;
    }

    private String zrnsonotanyranmsgcd18;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD18)
    public String getZrnsonotanyranmsgcd18() {
        return zrnsonotanyranmsgcd18;
    }

    public void setZrnsonotanyranmsgcd18(String pZrnsonotanyranmsgcd18) {
        zrnsonotanyranmsgcd18 = pZrnsonotanyranmsgcd18;
    }

    private String zrnsonotanyranmsgcd19;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD19)
    public String getZrnsonotanyranmsgcd19() {
        return zrnsonotanyranmsgcd19;
    }

    public void setZrnsonotanyranmsgcd19(String pZrnsonotanyranmsgcd19) {
        zrnsonotanyranmsgcd19 = pZrnsonotanyranmsgcd19;
    }

    private String zrnsonotanyranmsgcd20;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMSGCD20)
    public String getZrnsonotanyranmsgcd20() {
        return zrnsonotanyranmsgcd20;
    }

    public void setZrnsonotanyranmsgcd20(String pZrnsonotanyranmsgcd20) {
        zrnsonotanyranmsgcd20 = pZrnsonotanyranmsgcd20;
    }

    private String zrnsonotanyransiteituuka;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANSITEITUUKA)
    public String getZrnsonotanyransiteituuka() {
        return zrnsonotanyransiteituuka;
    }

    @DataConvert("toMultiByte")
    public void setZrnsonotanyransiteituuka(String pZrnsonotanyransiteituuka) {
        zrnsonotanyransiteituuka = pZrnsonotanyransiteituuka;
    }

    private String zrnsonotanyrannykntuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANNYKNTUKTYPE)
    public String getZrnsonotanyrannykntuktype() {
        return zrnsonotanyrannykntuktype;
    }

    public void setZrnsonotanyrannykntuktype(String pZrnsonotanyrannykntuktype) {
        zrnsonotanyrannykntuktype = pZrnsonotanyrannykntuktype;
    }

    private String zrnsonotanyrannykntuukap;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANNYKNTUUKAP)
    public String getZrnsonotanyrannykntuukap() {
        return zrnsonotanyrannykntuukap;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsonotanyrannykntuukap(String pZrnsonotanyrannykntuukap) {
        zrnsonotanyrannykntuukap = pZrnsonotanyrannykntuukap;
    }

    private String zrnsonotanyrannykntuukasyu;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANNYKNTUUKASYU)
    public String getZrnsonotanyrannykntuukasyu() {
        return zrnsonotanyrannykntuukasyu;
    }

    @DataConvert("toMultiByte")
    public void setZrnsonotanyrannykntuukasyu(String pZrnsonotanyrannykntuukasyu) {
        zrnsonotanyrannykntuukasyu = pZrnsonotanyrannykntuukasyu;
    }

    private String zrnsonotanyranenkhrikmrate;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANENKHRIKMRATE)
    public String getZrnsonotanyranenkhrikmrate() {
        return zrnsonotanyranenkhrikmrate;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsonotanyranenkhrikmrate(String pZrnsonotanyranenkhrikmrate) {
        zrnsonotanyranenkhrikmrate = pZrnsonotanyranenkhrikmrate;
    }

    private String zrnsonotanyranstigikwsrate;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANSTIGIKWSRATE)
    public String getZrnsonotanyranstigikwsrate() {
        return zrnsonotanyranstigikwsrate;
    }

    @Padding(mode = "left", padChar ='0', length =7)
    public void setZrnsonotanyranstigikwsrate(String pZrnsonotanyranstigikwsrate) {
        zrnsonotanyranstigikwsrate = pZrnsonotanyranstigikwsrate;
    }

    private String zrnsonotanykjnkngktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYKJNKNGKTUKTYPE)
    public String getZrnsonotanykjnkngktuktype() {
        return zrnsonotanykjnkngktuktype;
    }

    public void setZrnsonotanykjnkngktuktype(String pZrnsonotanykjnkngktuktype) {
        zrnsonotanykjnkngktuktype = pZrnsonotanykjnkngktuktype;
    }

    private String zrnsonotanykjnkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYKJNKNGK)
    public String getZrnsonotanykjnkngk() {
        return zrnsonotanykjnkngk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsonotanykjnkngk(String pZrnsonotanykjnkngk) {
        zrnsonotanykjnkngk = pZrnsonotanykjnkngk;
    }

    private String zrnsonotanykjnkngkrate;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYKJNKNGKRATE)
    public String getZrnsonotanykjnkngkrate() {
        return zrnsonotanykjnkngkrate;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrnsonotanykjnkngkrate(String pZrnsonotanykjnkngkrate) {
        zrnsonotanykjnkngkrate = pZrnsonotanykjnkngkrate;
    }

    private String zrnsonotanykjnkngktuuka;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYKJNKNGKTUUKA)
    public String getZrnsonotanykjnkngktuuka() {
        return zrnsonotanykjnkngktuuka;
    }

    @DataConvert("toMultiByte")
    public void setZrnsonotanykjnkngktuuka(String pZrnsonotanykjnkngktuuka) {
        zrnsonotanykjnkngktuuka = pZrnsonotanykjnkngktuuka;
    }

    private String zrnsonotanyranpentuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANPENTUKTYPE)
    public String getZrnsonotanyranpentuktype() {
        return zrnsonotanyranpentuktype;
    }

    public void setZrnsonotanyranpentuktype(String pZrnsonotanyranpentuktype) {
        zrnsonotanyranpentuktype = pZrnsonotanyranpentuktype;
    }

    private String zrnsonotanyranpenknsngk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANPENKNSNGK)
    public String getZrnsonotanyranpenknsngk() {
        return zrnsonotanyranpenknsngk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsonotanyranpenknsngk(String pZrnsonotanyranpenknsngk) {
        zrnsonotanyranpenknsngk = pZrnsonotanyranpenknsngk;
    }

    private String zrnpmkhtoutatuwariai;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNPMKHTOUTATUWARIAI)
    public String getZrnpmkhtoutatuwariai() {
        return zrnpmkhtoutatuwariai;
    }

    @DataConvert("toMultiByte")
    public void setZrnpmkhtoutatuwariai(String pZrnpmkhtoutatuwariai) {
        zrnpmkhtoutatuwariai = pZrnpmkhtoutatuwariai;
    }

    private String zrnsonotanyranmkhgk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANMKHGK)
    public String getZrnsonotanyranmkhgk() {
        return zrnsonotanyranmkhgk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsonotanyranmkhgk(String pZrnsonotanyranmkhgk) {
        zrnsonotanyranmkhgk = pZrnsonotanyranmkhgk;
    }

    private String zrnsonotanyrannkshrstartymd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANNKSHRSTARTYMD)
    public String getZrnsonotanyrannkshrstartymd() {
        return zrnsonotanyrannkshrstartymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnsonotanyrannkshrstartymd(String pZrnsonotanyrannkshrstartymd) {
        zrnsonotanyrannkshrstartymd = pZrnsonotanyrannkshrstartymd;
    }

    private String zrnsonotanyrannkkkn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANNKKKN)
    public String getZrnsonotanyrannkkkn() {
        return zrnsonotanyrannkkkn;
    }

    @Padding(mode = "left", padChar ='0', length =2)
    public void setZrnsonotanyrannkkkn(String pZrnsonotanyrannkkkn) {
        zrnsonotanyrannkkkn = pZrnsonotanyrannkkkn;
    }

    private String zrnsonotanyyensysnhkhnkymd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYYENSYSNHKHNKYMD)
    public String getZrnsonotanyyensysnhkhnkymd() {
        return zrnsonotanyyensysnhkhnkymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnsonotanyyensysnhkhnkymd(String pZrnsonotanyyensysnhkhnkymd) {
        zrnsonotanyyensysnhkhnkymd = pZrnsonotanyyensysnhkhnkymd;
    }

    private String zrnsonotanytmttkngktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYTMTTKNGKTUKTYPE)
    public String getZrnsonotanytmttkngktuktype() {
        return zrnsonotanytmttkngktuktype;
    }

    public void setZrnsonotanytmttkngktuktype(String pZrnsonotanytmttkngktuktype) {
        zrnsonotanytmttkngktuktype = pZrnsonotanytmttkngktuktype;
    }

    private String zrnsonotanyteiritutmttkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYTEIRITUTMTTKNGK)
    public String getZrnsonotanyteiritutmttkngk() {
        return zrnsonotanyteiritutmttkngk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsonotanyteiritutmttkngk(String pZrnsonotanyteiritutmttkngk) {
        zrnsonotanyteiritutmttkngk = pZrnsonotanyteiritutmttkngk;
    }

    private String zrnsonotanyransisuutmttkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANSISUUTMTTKNGK)
    public String getZrnsonotanyransisuutmttkngk() {
        return zrnsonotanyransisuutmttkngk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsonotanyransisuutmttkngk(String pZrnsonotanyransisuutmttkngk) {
        zrnsonotanyransisuutmttkngk = pZrnsonotanyransisuutmttkngk;
    }

    private String zrnsonotanyransisuunm;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANSISUUNM)
    public String getZrnsonotanyransisuunm() {
        return zrnsonotanyransisuunm;
    }

    @DataConvert("toMultiByte")
    public void setZrnsonotanyransisuunm(String pZrnsonotanyransisuunm) {
        zrnsonotanyransisuunm = pZrnsonotanyransisuunm;
    }

    private String zrnsonotanyrendouritu;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRENDOURITU)
    public String getZrnsonotanyrendouritu() {
        return zrnsonotanyrendouritu;
    }

    @DataConvert("toMultiByte")
    public void setZrnsonotanyrendouritu(String pZrnsonotanyrendouritu) {
        zrnsonotanyrendouritu = pZrnsonotanyrendouritu;
    }

    private String zrnsonotanyteikisiharaikin;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYTEIKISIHARAIKIN)
    public String getZrnsonotanyteikisiharaikin() {
        return zrnsonotanyteikisiharaikin;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsonotanyteikisiharaikin(String pZrnsonotanyteikisiharaikin) {
        zrnsonotanyteikisiharaikin = pZrnsonotanyteikisiharaikin;
    }

    private String zrnsonotanyrangaimsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSONOTANYRANGAIMSGCD)
    public String getZrnsonotanyrangaimsgcd() {
        return zrnsonotanyrangaimsgcd;
    }

    public void setZrnsonotanyrangaimsgcd(String pZrnsonotanyrangaimsgcd) {
        zrnsonotanyrangaimsgcd = pZrnsonotanyrangaimsgcd;
    }

    private String zrnyobiv6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV6)
    public String getZrnyobiv6() {
        return zrnyobiv6;
    }

    public void setZrnyobiv6(String pZrnyobiv6) {
        zrnyobiv6 = pZrnyobiv6;
    }

    private String zrnhosyounymsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHOSYOUNYMSGCD)
    public String getZrnhosyounymsgcd() {
        return zrnhosyounymsgcd;
    }

    public void setZrnhosyounymsgcd(String pZrnhosyounymsgcd) {
        zrnhosyounymsgcd = pZrnhosyounymsgcd;
    }

    private String zrnyobiv15;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV15)
    public String getZrnyobiv15() {
        return zrnyobiv15;
    }

    public void setZrnyobiv15(String pZrnyobiv15) {
        zrnyobiv15 = pZrnyobiv15;
    }

    private String zrnhosyounyhihknsyanmkanji;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHOSYOUNYHIHKNSYANMKANJI)
    public String getZrnhosyounyhihknsyanmkanji() {
        return zrnhosyounyhihknsyanmkanji;
    }

    @DataConvert("toMultiByte")
    public void setZrnhosyounyhihknsyanmkanji(String pZrnhosyounyhihknsyanmkanji) {
        zrnhosyounyhihknsyanmkanji = pZrnhosyounyhihknsyanmkanji;
    }

    private String zrnyobiv24;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV24)
    public String getZrnyobiv24() {
        return zrnyobiv24;
    }

    public void setZrnyobiv24(String pZrnyobiv24) {
        zrnyobiv24 = pZrnyobiv24;
    }

    private String zrnsiboumidasimsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUMIDASIMSGCD)
    public String getZrnsiboumidasimsgcd() {
        return zrnsiboumidasimsgcd;
    }

    public void setZrnsiboumidasimsgcd(String pZrnsiboumidasimsgcd) {
        zrnsiboumidasimsgcd = pZrnsiboumidasimsgcd;
    }

    private String zrnsiboumidasimsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUMIDASIMSGCD2)
    public String getZrnsiboumidasimsgcd2() {
        return zrnsiboumidasimsgcd2;
    }

    public void setZrnsiboumidasimsgcd2(String pZrnsiboumidasimsgcd2) {
        zrnsiboumidasimsgcd2 = pZrnsiboumidasimsgcd2;
    }

    private String zrnsiboudai1hknkknmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI1HKNKKNMSGCD1)
    public String getZrnsiboudai1hknkknmsgcd1() {
        return zrnsiboudai1hknkknmsgcd1;
    }

    public void setZrnsiboudai1hknkknmsgcd1(String pZrnsiboudai1hknkknmsgcd1) {
        zrnsiboudai1hknkknmsgcd1 = pZrnsiboudai1hknkknmsgcd1;
    }

    private String zrnsiboudai1hknkknmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI1HKNKKNMSGCD2)
    public String getZrnsiboudai1hknkknmsgcd2() {
        return zrnsiboudai1hknkknmsgcd2;
    }

    public void setZrnsiboudai1hknkknmsgcd2(String pZrnsiboudai1hknkknmsgcd2) {
        zrnsiboudai1hknkknmsgcd2 = pZrnsiboudai1hknkknmsgcd2;
    }

    private String zrnsiboudai1hknkknigimsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI1HKNKKNIGIMSGCD)
    public String getZrnsiboudai1hknkknigimsgcd() {
        return zrnsiboudai1hknkknigimsgcd;
    }

    public void setZrnsiboudai1hknkknigimsgcd(String pZrnsiboudai1hknkknigimsgcd) {
        zrnsiboudai1hknkknigimsgcd = pZrnsiboudai1hknkknigimsgcd;
    }

    private String zrnsiboudai1hknkknigimsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI1HKNKKNIGIMSGCD2)
    public String getZrnsiboudai1hknkknigimsgcd2() {
        return zrnsiboudai1hknkknigimsgcd2;
    }

    public void setZrnsiboudai1hknkknigimsgcd2(String pZrnsiboudai1hknkknigimsgcd2) {
        zrnsiboudai1hknkknigimsgcd2 = pZrnsiboudai1hknkknigimsgcd2;
    }

    private String zrnsiboudai1hknkknhrsmsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI1HKNKKNHRSMSGCD)
    public String getZrnsiboudai1hknkknhrsmsgcd() {
        return zrnsiboudai1hknkknhrsmsgcd;
    }

    public void setZrnsiboudai1hknkknhrsmsgcd(String pZrnsiboudai1hknkknhrsmsgcd) {
        zrnsiboudai1hknkknhrsmsgcd = pZrnsiboudai1hknkknhrsmsgcd;
    }

    private String zrnsiboudai1hknkknhrsmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI1HKNKKNHRSMSGCD2)
    public String getZrnsiboudai1hknkknhrsmsgcd2() {
        return zrnsiboudai1hknkknhrsmsgcd2;
    }

    public void setZrnsiboudai1hknkknhrsmsgcd2(String pZrnsiboudai1hknkknhrsmsgcd2) {
        zrnsiboudai1hknkknhrsmsgcd2 = pZrnsiboudai1hknkknhrsmsgcd2;
    }

    private String zrnsiboudai1hknkknsmrmsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI1HKNKKNSMRMSGCD)
    public String getZrnsiboudai1hknkknsmrmsgcd() {
        return zrnsiboudai1hknkknsmrmsgcd;
    }

    public void setZrnsiboudai1hknkknsmrmsgcd(String pZrnsiboudai1hknkknsmrmsgcd) {
        zrnsiboudai1hknkknsmrmsgcd = pZrnsiboudai1hknkknsmrmsgcd;
    }

    private String zrnsiboudai2hknkknmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI2HKNKKNMSGCD1)
    public String getZrnsiboudai2hknkknmsgcd1() {
        return zrnsiboudai2hknkknmsgcd1;
    }

    public void setZrnsiboudai2hknkknmsgcd1(String pZrnsiboudai2hknkknmsgcd1) {
        zrnsiboudai2hknkknmsgcd1 = pZrnsiboudai2hknkknmsgcd1;
    }

    private String zrnsiboudai2hknkknmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI2HKNKKNMSGCD2)
    public String getZrnsiboudai2hknkknmsgcd2() {
        return zrnsiboudai2hknkknmsgcd2;
    }

    public void setZrnsiboudai2hknkknmsgcd2(String pZrnsiboudai2hknkknmsgcd2) {
        zrnsiboudai2hknkknmsgcd2 = pZrnsiboudai2hknkknmsgcd2;
    }

    private String zrnsiboudai2hknkknsmsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI2HKNKKNSMSGCD)
    public String getZrnsiboudai2hknkknsmsgcd() {
        return zrnsiboudai2hknkknsmsgcd;
    }

    public void setZrnsiboudai2hknkknsmsgcd(String pZrnsiboudai2hknkknsmsgcd) {
        zrnsiboudai2hknkknsmsgcd = pZrnsiboudai2hknkknsmsgcd;
    }

    private String zrnsiboudai2hknkknsmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI2HKNKKNSMSGCD2)
    public String getZrnsiboudai2hknkknsmsgcd2() {
        return zrnsiboudai2hknkknsmsgcd2;
    }

    public void setZrnsiboudai2hknkknsmsgcd2(String pZrnsiboudai2hknkknsmsgcd2) {
        zrnsiboudai2hknkknsmsgcd2 = pZrnsiboudai2hknkknsmsgcd2;
    }

    private String zrnsiboudai3hknkknmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI3HKNKKNMSGCD1)
    public String getZrnsiboudai3hknkknmsgcd1() {
        return zrnsiboudai3hknkknmsgcd1;
    }

    public void setZrnsiboudai3hknkknmsgcd1(String pZrnsiboudai3hknkknmsgcd1) {
        zrnsiboudai3hknkknmsgcd1 = pZrnsiboudai3hknkknmsgcd1;
    }

    private String zrnsiboudai3hknkknmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI3HKNKKNMSGCD2)
    public String getZrnsiboudai3hknkknmsgcd2() {
        return zrnsiboudai3hknkknmsgcd2;
    }

    public void setZrnsiboudai3hknkknmsgcd2(String pZrnsiboudai3hknkknmsgcd2) {
        zrnsiboudai3hknkknmsgcd2 = pZrnsiboudai3hknkknmsgcd2;
    }

    private String zrnyobiv15x2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV15X2)
    public String getZrnyobiv15x2() {
        return zrnyobiv15x2;
    }

    public void setZrnyobiv15x2(String pZrnyobiv15x2) {
        zrnyobiv15x2 = pZrnyobiv15x2;
    }

    private String zrnsiboudai1hknkknymdto;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI1HKNKKNYMDTO)
    public String getZrnsiboudai1hknkknymdto() {
        return zrnsiboudai1hknkknymdto;
    }

    @DataConvert("toMultiByte")
    public void setZrnsiboudai1hknkknymdto(String pZrnsiboudai1hknkknymdto) {
        zrnsiboudai1hknkknymdto = pZrnsiboudai1hknkknymdto;
    }

    private String zrnsibouitjbrpyentuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUITJBRPYENTUUKTYPE)
    public String getZrnsibouitjbrpyentuuktype() {
        return zrnsibouitjbrpyentuuktype;
    }

    public void setZrnsibouitjbrpyentuuktype(String pZrnsibouitjbrpyentuuktype) {
        zrnsibouitjbrpyentuuktype = pZrnsibouitjbrpyentuuktype;
    }

    private String zrnsibouitjbrpyentuukgk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUITJBRPYENTUUKGK)
    public String getZrnsibouitjbrpyentuukgk() {
        return zrnsibouitjbrpyentuukgk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsibouitjbrpyentuukgk(String pZrnsibouitjbrpyentuukgk) {
        zrnsibouitjbrpyentuukgk = pZrnsibouitjbrpyentuukgk;
    }

    private String zrnsiboudai1kjnkngktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI1KJNKNGKTUKTYPE)
    public String getZrnsiboudai1kjnkngktuktype() {
        return zrnsiboudai1kjnkngktuktype;
    }

    public void setZrnsiboudai1kjnkngktuktype(String pZrnsiboudai1kjnkngktuktype) {
        zrnsiboudai1kjnkngktuktype = pZrnsiboudai1kjnkngktuktype;
    }

    private String zrnsiboudai1kjnkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI1KJNKNGK)
    public String getZrnsiboudai1kjnkngk() {
        return zrnsiboudai1kjnkngk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsiboudai1kjnkngk(String pZrnsiboudai1kjnkngk) {
        zrnsiboudai1kjnkngk = pZrnsiboudai1kjnkngk;
    }

    private String zrnsiboudai2hknkknymdto;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI2HKNKKNYMDTO)
    public String getZrnsiboudai2hknkknymdto() {
        return zrnsiboudai2hknkknymdto;
    }

    @DataConvert("toMultiByte")
    public void setZrnsiboudai2hknkknymdto(String pZrnsiboudai2hknkknymdto) {
        zrnsiboudai2hknkknymdto = pZrnsiboudai2hknkknymdto;
    }

    private String zrnsiboudai2kjnkngktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI2KJNKNGKTUKTYPE)
    public String getZrnsiboudai2kjnkngktuktype() {
        return zrnsiboudai2kjnkngktuktype;
    }

    public void setZrnsiboudai2kjnkngktuktype(String pZrnsiboudai2kjnkngktuktype) {
        zrnsiboudai2kjnkngktuktype = pZrnsiboudai2kjnkngktuktype;
    }

    private String zrnsiboudai2kjnkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI2KJNKNGK)
    public String getZrnsiboudai2kjnkngk() {
        return zrnsiboudai2kjnkngk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsiboudai2kjnkngk(String pZrnsiboudai2kjnkngk) {
        zrnsiboudai2kjnkngk = pZrnsiboudai2kjnkngk;
    }

    private String zrnsiboudai3kjnkngktuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI3KJNKNGKTUKTYPE)
    public String getZrnsiboudai3kjnkngktuktype() {
        return zrnsiboudai3kjnkngktuktype;
    }

    public void setZrnsiboudai3kjnkngktuktype(String pZrnsiboudai3kjnkngktuktype) {
        zrnsiboudai3kjnkngktuktype = pZrnsiboudai3kjnkngktuktype;
    }

    private String zrnsiboudai3kjnkngk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUDAI3KJNKNGK)
    public String getZrnsiboudai3kjnkngk() {
        return zrnsiboudai3kjnkngk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnsiboudai3kjnkngk(String pZrnsiboudai3kjnkngk) {
        zrnsiboudai3kjnkngk = pZrnsiboudai3kjnkngk;
    }

    private String zrnyobiv23;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV23)
    public String getZrnyobiv23() {
        return zrnyobiv23;
    }

    public void setZrnyobiv23(String pZrnyobiv23) {
        zrnyobiv23 = pZrnyobiv23;
    }

    private String zrndai1skwsrateyendaka;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SKWSRATEYENDAKA)
    public String getZrndai1skwsrateyendaka() {
        return zrndai1skwsrateyendaka;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrndai1skwsrateyendaka(String pZrndai1skwsrateyendaka) {
        zrndai1skwsrateyendaka = pZrndai1skwsrateyendaka;
    }

    private String zrndai1skwsrateyenkijyun;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SKWSRATEYENKIJYUN)
    public String getZrndai1skwsrateyenkijyun() {
        return zrndai1skwsrateyenkijyun;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrndai1skwsrateyenkijyun(String pZrndai1skwsrateyenkijyun) {
        zrndai1skwsrateyenkijyun = pZrndai1skwsrateyenkijyun;
    }

    private String zrndai1skwsrateyenyasu;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SKWSRATEYENYASU)
    public String getZrndai1skwsrateyenyasu() {
        return zrndai1skwsrateyenyasu;
    }

    @Padding(mode = "left", padChar ='0', length =5)
    public void setZrndai1skwsrateyenyasu(String pZrndai1skwsrateyenyasu) {
        zrndai1skwsrateyenyasu = pZrndai1skwsrateyenyasu;
    }

    private String zrndai1sibousnenoutouymd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SIBOUSNENOUTOUYMD1)
    public String getZrndai1sibousnenoutouymd1() {
        return zrndai1sibousnenoutouymd1;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1sibousnenoutouymd1(String pZrndai1sibousnenoutouymd1) {
        zrndai1sibousnenoutouymd1 = pZrndai1sibousnenoutouymd1;
    }

    private String zrndai1stuuktype01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPE01)
    public String getZrndai1stuuktype01() {
        return zrndai1stuuktype01;
    }

    public void setZrndai1stuuktype01(String pZrndai1stuuktype01) {
        zrndai1stuuktype01 = pZrndai1stuuktype01;
    }

    private String zrndai1s01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1S01)
    public String getZrndai1s01() {
        return zrndai1s01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1s01(String pZrndai1s01) {
        zrndai1s01 = pZrndai1s01;
    }

    private String zrndai1syenyendakaumu01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMU01)
    public String getZrndai1syenyendakaumu01() {
        return zrndai1syenyendakaumu01;
    }

    public void setZrndai1syenyendakaumu01(String pZrndai1syenyendakaumu01) {
        zrndai1syenyendakaumu01 = pZrndai1syenyendakaumu01;
    }

    private String zrndai1syenyenkijyunumu01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNUMU01)
    public String getZrndai1syenyenkijyunumu01() {
        return zrndai1syenyenkijyunumu01;
    }

    public void setZrndai1syenyenkijyunumu01(String pZrndai1syenyenkijyunumu01) {
        zrndai1syenyenkijyunumu01 = pZrndai1syenyenkijyunumu01;
    }

    private String zrndai1syenyenyasuumu01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMU01)
    public String getZrndai1syenyenyasuumu01() {
        return zrndai1syenyenyasuumu01;
    }

    public void setZrndai1syenyenyasuumu01(String pZrndai1syenyenyasuumu01) {
        zrndai1syenyenyasuumu01 = pZrndai1syenyenyasuumu01;
    }

    private String zrndai1syentuuktype01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPE01)
    public String getZrndai1syentuuktype01() {
        return zrndai1syentuuktype01;
    }

    public void setZrndai1syentuuktype01(String pZrndai1syentuuktype01) {
        zrndai1syentuuktype01 = pZrndai1syentuuktype01;
    }

    private String zrndai1syenyendaka01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKA01)
    public String getZrndai1syenyendaka01() {
        return zrndai1syenyendaka01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendaka01(String pZrndai1syenyendaka01) {
        zrndai1syenyendaka01 = pZrndai1syenyendaka01;
    }

    private String zrndai1syenyenkijyun01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUN01)
    public String getZrndai1syenyenkijyun01() {
        return zrndai1syenyenkijyun01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyun01(String pZrndai1syenyenkijyun01) {
        zrndai1syenyenkijyun01 = pZrndai1syenyenkijyun01;
    }

    private String zrndai1syenyenyasu01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASU01)
    public String getZrndai1syenyenyasu01() {
        return zrndai1syenyenyasu01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasu01(String pZrndai1syenyenyasu01) {
        zrndai1syenyenyasu01 = pZrndai1syenyenyasu01;
    }

    private String zrndai1zennouzndk01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDK01)
    public String getZrndai1zennouzndk01() {
        return zrndai1zennouzndk01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1zennouzndk01(String pZrndai1zennouzndk01) {
        zrndai1zennouzndk01 = pZrndai1zennouzndk01;
    }

    private String zrndai1zennouzndktype01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDKTYPE01)
    public String getZrndai1zennouzndktype01() {
        return zrndai1zennouzndktype01;
    }

    public void setZrndai1zennouzndktype01(String pZrndai1zennouzndktype01) {
        zrndai1zennouzndktype01 = pZrndai1zennouzndktype01;
    }

    private String zrndai1sbjiuktgk01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGK01)
    public String getZrndai1sbjiuktgk01() {
        return zrndai1sbjiuktgk01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgk01(String pZrndai1sbjiuktgk01) {
        zrndai1sbjiuktgk01 = pZrndai1sbjiuktgk01;
    }

    private String zrndai1sbjiuktgktype01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKTYPE01)
    public String getZrndai1sbjiuktgktype01() {
        return zrndai1sbjiuktgktype01;
    }

    public void setZrndai1sbjiuktgktype01(String pZrndai1sbjiuktgktype01) {
        zrndai1sbjiuktgktype01 = pZrndai1sbjiuktgktype01;
    }

    private String zrndai1sbjiuktgkytype01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYTYPE01)
    public String getZrndai1sbjiuktgkytype01() {
        return zrndai1sbjiuktgkytype01;
    }

    public void setZrndai1sbjiuktgkytype01(String pZrndai1sbjiuktgkytype01) {
        zrndai1sbjiuktgkytype01 = pZrndai1sbjiuktgkytype01;
    }

    private String zrndai1sbjiuktgkydaka01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYDAKA01)
    public String getZrndai1sbjiuktgkydaka01() {
        return zrndai1sbjiuktgkydaka01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkydaka01(String pZrndai1sbjiuktgkydaka01) {
        zrndai1sbjiuktgkydaka01 = pZrndai1sbjiuktgkydaka01;
    }

    private String zrndai1sbjiuktgkykijyun01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYKIJYUN01)
    public String getZrndai1sbjiuktgkykijyun01() {
        return zrndai1sbjiuktgkykijyun01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkykijyun01(String pZrndai1sbjiuktgkykijyun01) {
        zrndai1sbjiuktgkykijyun01 = pZrndai1sbjiuktgkykijyun01;
    }

    private String zrndai1sbjiuktgkyyasu01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYYASU01)
    public String getZrndai1sbjiuktgkyyasu01() {
        return zrndai1sbjiuktgkyyasu01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkyyasu01(String pZrndai1sbjiuktgkyyasu01) {
        zrndai1sbjiuktgkyyasu01 = pZrndai1sbjiuktgkyyasu01;
    }

    private String zrndai1sibousnenoutouymd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SIBOUSNENOUTOUYMD2)
    public String getZrndai1sibousnenoutouymd2() {
        return zrndai1sibousnenoutouymd2;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1sibousnenoutouymd2(String pZrndai1sibousnenoutouymd2) {
        zrndai1sibousnenoutouymd2 = pZrndai1sibousnenoutouymd2;
    }

    private String zrndai1stuuktype02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPE02)
    public String getZrndai1stuuktype02() {
        return zrndai1stuuktype02;
    }

    public void setZrndai1stuuktype02(String pZrndai1stuuktype02) {
        zrndai1stuuktype02 = pZrndai1stuuktype02;
    }

    private String zrndai1s02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1S02)
    public String getZrndai1s02() {
        return zrndai1s02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1s02(String pZrndai1s02) {
        zrndai1s02 = pZrndai1s02;
    }

    private String zrndai1syenyendakaumu02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMU02)
    public String getZrndai1syenyendakaumu02() {
        return zrndai1syenyendakaumu02;
    }

    public void setZrndai1syenyendakaumu02(String pZrndai1syenyendakaumu02) {
        zrndai1syenyendakaumu02 = pZrndai1syenyendakaumu02;
    }

    private String zrndai1syenyenkijyunumu02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNUMU02)
    public String getZrndai1syenyenkijyunumu02() {
        return zrndai1syenyenkijyunumu02;
    }

    public void setZrndai1syenyenkijyunumu02(String pZrndai1syenyenkijyunumu02) {
        zrndai1syenyenkijyunumu02 = pZrndai1syenyenkijyunumu02;
    }

    private String zrndai1syenyenyasuumu02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMU02)
    public String getZrndai1syenyenyasuumu02() {
        return zrndai1syenyenyasuumu02;
    }

    public void setZrndai1syenyenyasuumu02(String pZrndai1syenyenyasuumu02) {
        zrndai1syenyenyasuumu02 = pZrndai1syenyenyasuumu02;
    }

    private String zrndai1syentuuktype02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPE02)
    public String getZrndai1syentuuktype02() {
        return zrndai1syentuuktype02;
    }

    public void setZrndai1syentuuktype02(String pZrndai1syentuuktype02) {
        zrndai1syentuuktype02 = pZrndai1syentuuktype02;
    }

    private String zrndai1syenyendaka02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKA02)
    public String getZrndai1syenyendaka02() {
        return zrndai1syenyendaka02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendaka02(String pZrndai1syenyendaka02) {
        zrndai1syenyendaka02 = pZrndai1syenyendaka02;
    }

    private String zrndai1syenyenkijyun02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUN02)
    public String getZrndai1syenyenkijyun02() {
        return zrndai1syenyenkijyun02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyun02(String pZrndai1syenyenkijyun02) {
        zrndai1syenyenkijyun02 = pZrndai1syenyenkijyun02;
    }

    private String zrndai1syenyenyasu02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASU02)
    public String getZrndai1syenyenyasu02() {
        return zrndai1syenyenyasu02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasu02(String pZrndai1syenyenyasu02) {
        zrndai1syenyenyasu02 = pZrndai1syenyenyasu02;
    }

    private String zrndai1zennouzndk02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDK02)
    public String getZrndai1zennouzndk02() {
        return zrndai1zennouzndk02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1zennouzndk02(String pZrndai1zennouzndk02) {
        zrndai1zennouzndk02 = pZrndai1zennouzndk02;
    }

    private String zrndai1zennouzndktype02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDKTYPE02)
    public String getZrndai1zennouzndktype02() {
        return zrndai1zennouzndktype02;
    }

    public void setZrndai1zennouzndktype02(String pZrndai1zennouzndktype02) {
        zrndai1zennouzndktype02 = pZrndai1zennouzndktype02;
    }

    private String zrndai1sbjiuktgk02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGK02)
    public String getZrndai1sbjiuktgk02() {
        return zrndai1sbjiuktgk02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgk02(String pZrndai1sbjiuktgk02) {
        zrndai1sbjiuktgk02 = pZrndai1sbjiuktgk02;
    }

    private String zrndai1sbjiuktgktype02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKTYPE02)
    public String getZrndai1sbjiuktgktype02() {
        return zrndai1sbjiuktgktype02;
    }

    public void setZrndai1sbjiuktgktype02(String pZrndai1sbjiuktgktype02) {
        zrndai1sbjiuktgktype02 = pZrndai1sbjiuktgktype02;
    }

    private String zrndai1sbjiuktgkytype02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYTYPE02)
    public String getZrndai1sbjiuktgkytype02() {
        return zrndai1sbjiuktgkytype02;
    }

    public void setZrndai1sbjiuktgkytype02(String pZrndai1sbjiuktgkytype02) {
        zrndai1sbjiuktgkytype02 = pZrndai1sbjiuktgkytype02;
    }

    private String zrndai1sbjiuktgkydaka02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYDAKA02)
    public String getZrndai1sbjiuktgkydaka02() {
        return zrndai1sbjiuktgkydaka02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkydaka02(String pZrndai1sbjiuktgkydaka02) {
        zrndai1sbjiuktgkydaka02 = pZrndai1sbjiuktgkydaka02;
    }

    private String zrndai1sbjiuktgkykijyun02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYKIJYUN02)
    public String getZrndai1sbjiuktgkykijyun02() {
        return zrndai1sbjiuktgkykijyun02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkykijyun02(String pZrndai1sbjiuktgkykijyun02) {
        zrndai1sbjiuktgkykijyun02 = pZrndai1sbjiuktgkykijyun02;
    }

    private String zrndai1sbjiuktgkyyasu02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYYASU02)
    public String getZrndai1sbjiuktgkyyasu02() {
        return zrndai1sbjiuktgkyyasu02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkyyasu02(String pZrndai1sbjiuktgkyyasu02) {
        zrndai1sbjiuktgkyyasu02 = pZrndai1sbjiuktgkyyasu02;
    }

    private String zrndai1sibousnenoutouymd3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SIBOUSNENOUTOUYMD3)
    public String getZrndai1sibousnenoutouymd3() {
        return zrndai1sibousnenoutouymd3;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1sibousnenoutouymd3(String pZrndai1sibousnenoutouymd3) {
        zrndai1sibousnenoutouymd3 = pZrndai1sibousnenoutouymd3;
    }

    private String zrndai1stuuktype03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPE03)
    public String getZrndai1stuuktype03() {
        return zrndai1stuuktype03;
    }

    public void setZrndai1stuuktype03(String pZrndai1stuuktype03) {
        zrndai1stuuktype03 = pZrndai1stuuktype03;
    }

    private String zrndai1s03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1S03)
    public String getZrndai1s03() {
        return zrndai1s03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1s03(String pZrndai1s03) {
        zrndai1s03 = pZrndai1s03;
    }

    private String zrndai1syenyendakaumu03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMU03)
    public String getZrndai1syenyendakaumu03() {
        return zrndai1syenyendakaumu03;
    }

    public void setZrndai1syenyendakaumu03(String pZrndai1syenyendakaumu03) {
        zrndai1syenyendakaumu03 = pZrndai1syenyendakaumu03;
    }

    private String zrndai1syenyenkijyunumu03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNUMU03)
    public String getZrndai1syenyenkijyunumu03() {
        return zrndai1syenyenkijyunumu03;
    }

    public void setZrndai1syenyenkijyunumu03(String pZrndai1syenyenkijyunumu03) {
        zrndai1syenyenkijyunumu03 = pZrndai1syenyenkijyunumu03;
    }

    private String zrndai1syenyenyasuumu03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMU03)
    public String getZrndai1syenyenyasuumu03() {
        return zrndai1syenyenyasuumu03;
    }

    public void setZrndai1syenyenyasuumu03(String pZrndai1syenyenyasuumu03) {
        zrndai1syenyenyasuumu03 = pZrndai1syenyenyasuumu03;
    }

    private String zrndai1syentuuktype03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPE03)
    public String getZrndai1syentuuktype03() {
        return zrndai1syentuuktype03;
    }

    public void setZrndai1syentuuktype03(String pZrndai1syentuuktype03) {
        zrndai1syentuuktype03 = pZrndai1syentuuktype03;
    }

    private String zrndai1syenyendaka03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKA03)
    public String getZrndai1syenyendaka03() {
        return zrndai1syenyendaka03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendaka03(String pZrndai1syenyendaka03) {
        zrndai1syenyendaka03 = pZrndai1syenyendaka03;
    }

    private String zrndai1syenyenkijyun03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUN03)
    public String getZrndai1syenyenkijyun03() {
        return zrndai1syenyenkijyun03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyun03(String pZrndai1syenyenkijyun03) {
        zrndai1syenyenkijyun03 = pZrndai1syenyenkijyun03;
    }

    private String zrndai1syenyenyasu03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASU03)
    public String getZrndai1syenyenyasu03() {
        return zrndai1syenyenyasu03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasu03(String pZrndai1syenyenyasu03) {
        zrndai1syenyenyasu03 = pZrndai1syenyenyasu03;
    }

    private String zrndai1zennouzndk03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDK03)
    public String getZrndai1zennouzndk03() {
        return zrndai1zennouzndk03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1zennouzndk03(String pZrndai1zennouzndk03) {
        zrndai1zennouzndk03 = pZrndai1zennouzndk03;
    }

    private String zrndai1zennouzndktype03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDKTYPE03)
    public String getZrndai1zennouzndktype03() {
        return zrndai1zennouzndktype03;
    }

    public void setZrndai1zennouzndktype03(String pZrndai1zennouzndktype03) {
        zrndai1zennouzndktype03 = pZrndai1zennouzndktype03;
    }

    private String zrndai1sbjiuktgk03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGK03)
    public String getZrndai1sbjiuktgk03() {
        return zrndai1sbjiuktgk03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgk03(String pZrndai1sbjiuktgk03) {
        zrndai1sbjiuktgk03 = pZrndai1sbjiuktgk03;
    }

    private String zrndai1sbjiuktgktype03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKTYPE03)
    public String getZrndai1sbjiuktgktype03() {
        return zrndai1sbjiuktgktype03;
    }

    public void setZrndai1sbjiuktgktype03(String pZrndai1sbjiuktgktype03) {
        zrndai1sbjiuktgktype03 = pZrndai1sbjiuktgktype03;
    }

    private String zrndai1sbjiuktgkytype03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYTYPE03)
    public String getZrndai1sbjiuktgkytype03() {
        return zrndai1sbjiuktgkytype03;
    }

    public void setZrndai1sbjiuktgkytype03(String pZrndai1sbjiuktgkytype03) {
        zrndai1sbjiuktgkytype03 = pZrndai1sbjiuktgkytype03;
    }

    private String zrndai1sbjiuktgkydaka03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYDAKA03)
    public String getZrndai1sbjiuktgkydaka03() {
        return zrndai1sbjiuktgkydaka03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkydaka03(String pZrndai1sbjiuktgkydaka03) {
        zrndai1sbjiuktgkydaka03 = pZrndai1sbjiuktgkydaka03;
    }

    private String zrndai1sbjiuktgkykijyun03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYKIJYUN03)
    public String getZrndai1sbjiuktgkykijyun03() {
        return zrndai1sbjiuktgkykijyun03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkykijyun03(String pZrndai1sbjiuktgkykijyun03) {
        zrndai1sbjiuktgkykijyun03 = pZrndai1sbjiuktgkykijyun03;
    }

    private String zrndai1sbjiuktgkyyasu03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYYASU03)
    public String getZrndai1sbjiuktgkyyasu03() {
        return zrndai1sbjiuktgkyyasu03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkyyasu03(String pZrndai1sbjiuktgkyyasu03) {
        zrndai1sbjiuktgkyyasu03 = pZrndai1sbjiuktgkyyasu03;
    }

    private String zrndai1sibousnenoutouymd4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SIBOUSNENOUTOUYMD4)
    public String getZrndai1sibousnenoutouymd4() {
        return zrndai1sibousnenoutouymd4;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1sibousnenoutouymd4(String pZrndai1sibousnenoutouymd4) {
        zrndai1sibousnenoutouymd4 = pZrndai1sibousnenoutouymd4;
    }

    private String zrndai1stuuktype04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPE04)
    public String getZrndai1stuuktype04() {
        return zrndai1stuuktype04;
    }

    public void setZrndai1stuuktype04(String pZrndai1stuuktype04) {
        zrndai1stuuktype04 = pZrndai1stuuktype04;
    }

    private String zrndai1s04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1S04)
    public String getZrndai1s04() {
        return zrndai1s04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1s04(String pZrndai1s04) {
        zrndai1s04 = pZrndai1s04;
    }

    private String zrndai1syenyendakaumu04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMU04)
    public String getZrndai1syenyendakaumu04() {
        return zrndai1syenyendakaumu04;
    }

    public void setZrndai1syenyendakaumu04(String pZrndai1syenyendakaumu04) {
        zrndai1syenyendakaumu04 = pZrndai1syenyendakaumu04;
    }

    private String zrndai1syenyenkijyunumu04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNUMU04)
    public String getZrndai1syenyenkijyunumu04() {
        return zrndai1syenyenkijyunumu04;
    }

    public void setZrndai1syenyenkijyunumu04(String pZrndai1syenyenkijyunumu04) {
        zrndai1syenyenkijyunumu04 = pZrndai1syenyenkijyunumu04;
    }

    private String zrndai1syenyenyasuumu04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMU04)
    public String getZrndai1syenyenyasuumu04() {
        return zrndai1syenyenyasuumu04;
    }

    public void setZrndai1syenyenyasuumu04(String pZrndai1syenyenyasuumu04) {
        zrndai1syenyenyasuumu04 = pZrndai1syenyenyasuumu04;
    }

    private String zrndai1syentuuktype04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPE04)
    public String getZrndai1syentuuktype04() {
        return zrndai1syentuuktype04;
    }

    public void setZrndai1syentuuktype04(String pZrndai1syentuuktype04) {
        zrndai1syentuuktype04 = pZrndai1syentuuktype04;
    }

    private String zrndai1syenyendaka04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKA04)
    public String getZrndai1syenyendaka04() {
        return zrndai1syenyendaka04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendaka04(String pZrndai1syenyendaka04) {
        zrndai1syenyendaka04 = pZrndai1syenyendaka04;
    }

    private String zrndai1syenyenkijyun04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUN04)
    public String getZrndai1syenyenkijyun04() {
        return zrndai1syenyenkijyun04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyun04(String pZrndai1syenyenkijyun04) {
        zrndai1syenyenkijyun04 = pZrndai1syenyenkijyun04;
    }

    private String zrndai1syenyenyasu04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASU04)
    public String getZrndai1syenyenyasu04() {
        return zrndai1syenyenyasu04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasu04(String pZrndai1syenyenyasu04) {
        zrndai1syenyenyasu04 = pZrndai1syenyenyasu04;
    }

    private String zrndai1zennouzndk04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDK04)
    public String getZrndai1zennouzndk04() {
        return zrndai1zennouzndk04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1zennouzndk04(String pZrndai1zennouzndk04) {
        zrndai1zennouzndk04 = pZrndai1zennouzndk04;
    }

    private String zrndai1zennouzndktype04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDKTYPE04)
    public String getZrndai1zennouzndktype04() {
        return zrndai1zennouzndktype04;
    }

    public void setZrndai1zennouzndktype04(String pZrndai1zennouzndktype04) {
        zrndai1zennouzndktype04 = pZrndai1zennouzndktype04;
    }

    private String zrndai1sbjiuktgk04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGK04)
    public String getZrndai1sbjiuktgk04() {
        return zrndai1sbjiuktgk04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgk04(String pZrndai1sbjiuktgk04) {
        zrndai1sbjiuktgk04 = pZrndai1sbjiuktgk04;
    }

    private String zrndai1sbjiuktgktype04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKTYPE04)
    public String getZrndai1sbjiuktgktype04() {
        return zrndai1sbjiuktgktype04;
    }

    public void setZrndai1sbjiuktgktype04(String pZrndai1sbjiuktgktype04) {
        zrndai1sbjiuktgktype04 = pZrndai1sbjiuktgktype04;
    }

    private String zrndai1sbjiuktgkytype04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYTYPE04)
    public String getZrndai1sbjiuktgkytype04() {
        return zrndai1sbjiuktgkytype04;
    }

    public void setZrndai1sbjiuktgkytype04(String pZrndai1sbjiuktgkytype04) {
        zrndai1sbjiuktgkytype04 = pZrndai1sbjiuktgkytype04;
    }

    private String zrndai1sbjiuktgkydaka04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYDAKA04)
    public String getZrndai1sbjiuktgkydaka04() {
        return zrndai1sbjiuktgkydaka04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkydaka04(String pZrndai1sbjiuktgkydaka04) {
        zrndai1sbjiuktgkydaka04 = pZrndai1sbjiuktgkydaka04;
    }

    private String zrndai1sbjiuktgkykijyun04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYKIJYUN04)
    public String getZrndai1sbjiuktgkykijyun04() {
        return zrndai1sbjiuktgkykijyun04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkykijyun04(String pZrndai1sbjiuktgkykijyun04) {
        zrndai1sbjiuktgkykijyun04 = pZrndai1sbjiuktgkykijyun04;
    }

    private String zrndai1sbjiuktgkyyasu04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYYASU04)
    public String getZrndai1sbjiuktgkyyasu04() {
        return zrndai1sbjiuktgkyyasu04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkyyasu04(String pZrndai1sbjiuktgkyyasu04) {
        zrndai1sbjiuktgkyyasu04 = pZrndai1sbjiuktgkyyasu04;
    }

    private String zrndai1sibousnenoutouymd5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SIBOUSNENOUTOUYMD5)
    public String getZrndai1sibousnenoutouymd5() {
        return zrndai1sibousnenoutouymd5;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1sibousnenoutouymd5(String pZrndai1sibousnenoutouymd5) {
        zrndai1sibousnenoutouymd5 = pZrndai1sibousnenoutouymd5;
    }

    private String zrndai1stuuktype05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPE05)
    public String getZrndai1stuuktype05() {
        return zrndai1stuuktype05;
    }

    public void setZrndai1stuuktype05(String pZrndai1stuuktype05) {
        zrndai1stuuktype05 = pZrndai1stuuktype05;
    }

    private String zrndai1s05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1S05)
    public String getZrndai1s05() {
        return zrndai1s05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1s05(String pZrndai1s05) {
        zrndai1s05 = pZrndai1s05;
    }

    private String zrndai1syenyendakaumu05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMU05)
    public String getZrndai1syenyendakaumu05() {
        return zrndai1syenyendakaumu05;
    }

    public void setZrndai1syenyendakaumu05(String pZrndai1syenyendakaumu05) {
        zrndai1syenyendakaumu05 = pZrndai1syenyendakaumu05;
    }

    private String zrndai1syenyenkijyunumu05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNUMU05)
    public String getZrndai1syenyenkijyunumu05() {
        return zrndai1syenyenkijyunumu05;
    }

    public void setZrndai1syenyenkijyunumu05(String pZrndai1syenyenkijyunumu05) {
        zrndai1syenyenkijyunumu05 = pZrndai1syenyenkijyunumu05;
    }

    private String zrndai1syenyenyasuumu05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMU05)
    public String getZrndai1syenyenyasuumu05() {
        return zrndai1syenyenyasuumu05;
    }

    public void setZrndai1syenyenyasuumu05(String pZrndai1syenyenyasuumu05) {
        zrndai1syenyenyasuumu05 = pZrndai1syenyenyasuumu05;
    }

    private String zrndai1syentuuktype05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPE05)
    public String getZrndai1syentuuktype05() {
        return zrndai1syentuuktype05;
    }

    public void setZrndai1syentuuktype05(String pZrndai1syentuuktype05) {
        zrndai1syentuuktype05 = pZrndai1syentuuktype05;
    }

    private String zrndai1syenyendaka05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKA05)
    public String getZrndai1syenyendaka05() {
        return zrndai1syenyendaka05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendaka05(String pZrndai1syenyendaka05) {
        zrndai1syenyendaka05 = pZrndai1syenyendaka05;
    }

    private String zrndai1syenyenkijyun05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUN05)
    public String getZrndai1syenyenkijyun05() {
        return zrndai1syenyenkijyun05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyun05(String pZrndai1syenyenkijyun05) {
        zrndai1syenyenkijyun05 = pZrndai1syenyenkijyun05;
    }

    private String zrndai1syenyenyasu05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASU05)
    public String getZrndai1syenyenyasu05() {
        return zrndai1syenyenyasu05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasu05(String pZrndai1syenyenyasu05) {
        zrndai1syenyenyasu05 = pZrndai1syenyenyasu05;
    }

    private String zrndai1zennouzndk05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDK05)
    public String getZrndai1zennouzndk05() {
        return zrndai1zennouzndk05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1zennouzndk05(String pZrndai1zennouzndk05) {
        zrndai1zennouzndk05 = pZrndai1zennouzndk05;
    }

    private String zrndai1zennouzndktype05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDKTYPE05)
    public String getZrndai1zennouzndktype05() {
        return zrndai1zennouzndktype05;
    }

    public void setZrndai1zennouzndktype05(String pZrndai1zennouzndktype05) {
        zrndai1zennouzndktype05 = pZrndai1zennouzndktype05;
    }

    private String zrndai1sbjiuktgk05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGK05)
    public String getZrndai1sbjiuktgk05() {
        return zrndai1sbjiuktgk05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgk05(String pZrndai1sbjiuktgk05) {
        zrndai1sbjiuktgk05 = pZrndai1sbjiuktgk05;
    }

    private String zrndai1sbjiuktgktype05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKTYPE05)
    public String getZrndai1sbjiuktgktype05() {
        return zrndai1sbjiuktgktype05;
    }

    public void setZrndai1sbjiuktgktype05(String pZrndai1sbjiuktgktype05) {
        zrndai1sbjiuktgktype05 = pZrndai1sbjiuktgktype05;
    }

    private String zrndai1sbjiuktgkytype05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYTYPE05)
    public String getZrndai1sbjiuktgkytype05() {
        return zrndai1sbjiuktgkytype05;
    }

    public void setZrndai1sbjiuktgkytype05(String pZrndai1sbjiuktgkytype05) {
        zrndai1sbjiuktgkytype05 = pZrndai1sbjiuktgkytype05;
    }

    private String zrndai1sbjiuktgkydaka05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYDAKA05)
    public String getZrndai1sbjiuktgkydaka05() {
        return zrndai1sbjiuktgkydaka05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkydaka05(String pZrndai1sbjiuktgkydaka05) {
        zrndai1sbjiuktgkydaka05 = pZrndai1sbjiuktgkydaka05;
    }

    private String zrndai1sbjiuktgkykijyun05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYKIJYUN05)
    public String getZrndai1sbjiuktgkykijyun05() {
        return zrndai1sbjiuktgkykijyun05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkykijyun05(String pZrndai1sbjiuktgkykijyun05) {
        zrndai1sbjiuktgkykijyun05 = pZrndai1sbjiuktgkykijyun05;
    }

    private String zrndai1sbjiuktgkyyasu05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYYASU05)
    public String getZrndai1sbjiuktgkyyasu05() {
        return zrndai1sbjiuktgkyyasu05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkyyasu05(String pZrndai1sbjiuktgkyyasu05) {
        zrndai1sbjiuktgkyyasu05 = pZrndai1sbjiuktgkyyasu05;
    }

    private String zrndai1sibousnenoutouymd6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SIBOUSNENOUTOUYMD6)
    public String getZrndai1sibousnenoutouymd6() {
        return zrndai1sibousnenoutouymd6;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1sibousnenoutouymd6(String pZrndai1sibousnenoutouymd6) {
        zrndai1sibousnenoutouymd6 = pZrndai1sibousnenoutouymd6;
    }

    private String zrndai1stuuktype06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPE06)
    public String getZrndai1stuuktype06() {
        return zrndai1stuuktype06;
    }

    public void setZrndai1stuuktype06(String pZrndai1stuuktype06) {
        zrndai1stuuktype06 = pZrndai1stuuktype06;
    }

    private String zrndai1s06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1S06)
    public String getZrndai1s06() {
        return zrndai1s06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1s06(String pZrndai1s06) {
        zrndai1s06 = pZrndai1s06;
    }

    private String zrndai1syenyendakaumu06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMU06)
    public String getZrndai1syenyendakaumu06() {
        return zrndai1syenyendakaumu06;
    }

    public void setZrndai1syenyendakaumu06(String pZrndai1syenyendakaumu06) {
        zrndai1syenyendakaumu06 = pZrndai1syenyendakaumu06;
    }

    private String zrndai1syenyenkijyunumu06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNUMU06)
    public String getZrndai1syenyenkijyunumu06() {
        return zrndai1syenyenkijyunumu06;
    }

    public void setZrndai1syenyenkijyunumu06(String pZrndai1syenyenkijyunumu06) {
        zrndai1syenyenkijyunumu06 = pZrndai1syenyenkijyunumu06;
    }

    private String zrndai1syenyenyasuumu06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMU06)
    public String getZrndai1syenyenyasuumu06() {
        return zrndai1syenyenyasuumu06;
    }

    public void setZrndai1syenyenyasuumu06(String pZrndai1syenyenyasuumu06) {
        zrndai1syenyenyasuumu06 = pZrndai1syenyenyasuumu06;
    }

    private String zrndai1syentuuktype06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPE06)
    public String getZrndai1syentuuktype06() {
        return zrndai1syentuuktype06;
    }

    public void setZrndai1syentuuktype06(String pZrndai1syentuuktype06) {
        zrndai1syentuuktype06 = pZrndai1syentuuktype06;
    }

    private String zrndai1syenyendaka06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKA06)
    public String getZrndai1syenyendaka06() {
        return zrndai1syenyendaka06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendaka06(String pZrndai1syenyendaka06) {
        zrndai1syenyendaka06 = pZrndai1syenyendaka06;
    }

    private String zrndai1syenyenkijyun06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUN06)
    public String getZrndai1syenyenkijyun06() {
        return zrndai1syenyenkijyun06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyun06(String pZrndai1syenyenkijyun06) {
        zrndai1syenyenkijyun06 = pZrndai1syenyenkijyun06;
    }

    private String zrndai1syenyenyasu06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASU06)
    public String getZrndai1syenyenyasu06() {
        return zrndai1syenyenyasu06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasu06(String pZrndai1syenyenyasu06) {
        zrndai1syenyenyasu06 = pZrndai1syenyenyasu06;
    }

    private String zrndai1zennouzndk06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDK06)
    public String getZrndai1zennouzndk06() {
        return zrndai1zennouzndk06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1zennouzndk06(String pZrndai1zennouzndk06) {
        zrndai1zennouzndk06 = pZrndai1zennouzndk06;
    }

    private String zrndai1zennouzndktype06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1ZENNOUZNDKTYPE06)
    public String getZrndai1zennouzndktype06() {
        return zrndai1zennouzndktype06;
    }

    public void setZrndai1zennouzndktype06(String pZrndai1zennouzndktype06) {
        zrndai1zennouzndktype06 = pZrndai1zennouzndktype06;
    }

    private String zrndai1sbjiuktgk06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGK06)
    public String getZrndai1sbjiuktgk06() {
        return zrndai1sbjiuktgk06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgk06(String pZrndai1sbjiuktgk06) {
        zrndai1sbjiuktgk06 = pZrndai1sbjiuktgk06;
    }

    private String zrndai1sbjiuktgktype06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKTYPE06)
    public String getZrndai1sbjiuktgktype06() {
        return zrndai1sbjiuktgktype06;
    }

    public void setZrndai1sbjiuktgktype06(String pZrndai1sbjiuktgktype06) {
        zrndai1sbjiuktgktype06 = pZrndai1sbjiuktgktype06;
    }

    private String zrndai1sbjiuktgkytype06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYTYPE06)
    public String getZrndai1sbjiuktgkytype06() {
        return zrndai1sbjiuktgkytype06;
    }

    public void setZrndai1sbjiuktgkytype06(String pZrndai1sbjiuktgkytype06) {
        zrndai1sbjiuktgkytype06 = pZrndai1sbjiuktgkytype06;
    }

    private String zrndai1sbjiuktgkydaka06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYDAKA06)
    public String getZrndai1sbjiuktgkydaka06() {
        return zrndai1sbjiuktgkydaka06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkydaka06(String pZrndai1sbjiuktgkydaka06) {
        zrndai1sbjiuktgkydaka06 = pZrndai1sbjiuktgkydaka06;
    }

    private String zrndai1sbjiuktgkykijyun06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYKIJYUN06)
    public String getZrndai1sbjiuktgkykijyun06() {
        return zrndai1sbjiuktgkykijyun06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkykijyun06(String pZrndai1sbjiuktgkykijyun06) {
        zrndai1sbjiuktgkykijyun06 = pZrndai1sbjiuktgkykijyun06;
    }

    private String zrndai1sbjiuktgkyyasu06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SBJIUKTGKYYASU06)
    public String getZrndai1sbjiuktgkyyasu06() {
        return zrndai1sbjiuktgkyyasu06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1sbjiuktgkyyasu06(String pZrndai1sbjiuktgkyyasu06) {
        zrndai1sbjiuktgkyyasu06 = pZrndai1sbjiuktgkyyasu06;
    }

    private String zrndai1sibousnenoutouymd7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SIBOUSNENOUTOUYMD7)
    public String getZrndai1sibousnenoutouymd7() {
        return zrndai1sibousnenoutouymd7;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1sibousnenoutouymd7(String pZrndai1sibousnenoutouymd7) {
        zrndai1sibousnenoutouymd7 = pZrndai1sibousnenoutouymd7;
    }

    private String zrndai1stuuktype07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPE07)
    public String getZrndai1stuuktype07() {
        return zrndai1stuuktype07;
    }

    public void setZrndai1stuuktype07(String pZrndai1stuuktype07) {
        zrndai1stuuktype07 = pZrndai1stuuktype07;
    }

    private String zrndai1s07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1S07)
    public String getZrndai1s07() {
        return zrndai1s07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1s07(String pZrndai1s07) {
        zrndai1s07 = pZrndai1s07;
    }

    private String zrndai1syenyendakaumu07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMU07)
    public String getZrndai1syenyendakaumu07() {
        return zrndai1syenyendakaumu07;
    }

    public void setZrndai1syenyendakaumu07(String pZrndai1syenyendakaumu07) {
        zrndai1syenyendakaumu07 = pZrndai1syenyendakaumu07;
    }

    private String zrndai1syenyenkijyunumu07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNUMU07)
    public String getZrndai1syenyenkijyunumu07() {
        return zrndai1syenyenkijyunumu07;
    }

    public void setZrndai1syenyenkijyunumu07(String pZrndai1syenyenkijyunumu07) {
        zrndai1syenyenkijyunumu07 = pZrndai1syenyenkijyunumu07;
    }

    private String zrndai1syenyenyasuumu07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMU07)
    public String getZrndai1syenyenyasuumu07() {
        return zrndai1syenyenyasuumu07;
    }

    public void setZrndai1syenyenyasuumu07(String pZrndai1syenyenyasuumu07) {
        zrndai1syenyenyasuumu07 = pZrndai1syenyenyasuumu07;
    }

    private String zrndai1syentuuktype07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPE07)
    public String getZrndai1syentuuktype07() {
        return zrndai1syentuuktype07;
    }

    public void setZrndai1syentuuktype07(String pZrndai1syentuuktype07) {
        zrndai1syentuuktype07 = pZrndai1syentuuktype07;
    }

    private String zrndai1syenyendaka07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKA07)
    public String getZrndai1syenyendaka07() {
        return zrndai1syenyendaka07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendaka07(String pZrndai1syenyendaka07) {
        zrndai1syenyendaka07 = pZrndai1syenyendaka07;
    }

    private String zrndai1syenyenkijyun07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUN07)
    public String getZrndai1syenyenkijyun07() {
        return zrndai1syenyenkijyun07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyun07(String pZrndai1syenyenkijyun07) {
        zrndai1syenyenkijyun07 = pZrndai1syenyenkijyun07;
    }

    private String zrndai1syenyenyasu07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASU07)
    public String getZrndai1syenyenyasu07() {
        return zrndai1syenyenyasu07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasu07(String pZrndai1syenyenyasu07) {
        zrndai1syenyenyasu07 = pZrndai1syenyenyasu07;
    }

    private String zrndai1sibousnenoutouymd8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SIBOUSNENOUTOUYMD8)
    public String getZrndai1sibousnenoutouymd8() {
        return zrndai1sibousnenoutouymd8;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1sibousnenoutouymd8(String pZrndai1sibousnenoutouymd8) {
        zrndai1sibousnenoutouymd8 = pZrndai1sibousnenoutouymd8;
    }

    private String zrndai1stuuktype08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPE08)
    public String getZrndai1stuuktype08() {
        return zrndai1stuuktype08;
    }

    public void setZrndai1stuuktype08(String pZrndai1stuuktype08) {
        zrndai1stuuktype08 = pZrndai1stuuktype08;
    }

    private String zrndai1s08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1S08)
    public String getZrndai1s08() {
        return zrndai1s08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1s08(String pZrndai1s08) {
        zrndai1s08 = pZrndai1s08;
    }

    private String zrndai1syenyendakaumu08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMU08)
    public String getZrndai1syenyendakaumu08() {
        return zrndai1syenyendakaumu08;
    }

    public void setZrndai1syenyendakaumu08(String pZrndai1syenyendakaumu08) {
        zrndai1syenyendakaumu08 = pZrndai1syenyendakaumu08;
    }

    private String zrndai1syenyenkijyunumu08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNUMU08)
    public String getZrndai1syenyenkijyunumu08() {
        return zrndai1syenyenkijyunumu08;
    }

    public void setZrndai1syenyenkijyunumu08(String pZrndai1syenyenkijyunumu08) {
        zrndai1syenyenkijyunumu08 = pZrndai1syenyenkijyunumu08;
    }

    private String zrndai1syenyenyasuumu08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMU08)
    public String getZrndai1syenyenyasuumu08() {
        return zrndai1syenyenyasuumu08;
    }

    public void setZrndai1syenyenyasuumu08(String pZrndai1syenyenyasuumu08) {
        zrndai1syenyenyasuumu08 = pZrndai1syenyenyasuumu08;
    }

    private String zrndai1syentuuktype08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPE08)
    public String getZrndai1syentuuktype08() {
        return zrndai1syentuuktype08;
    }

    public void setZrndai1syentuuktype08(String pZrndai1syentuuktype08) {
        zrndai1syentuuktype08 = pZrndai1syentuuktype08;
    }

    private String zrndai1syenyendaka08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKA08)
    public String getZrndai1syenyendaka08() {
        return zrndai1syenyendaka08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendaka08(String pZrndai1syenyendaka08) {
        zrndai1syenyendaka08 = pZrndai1syenyendaka08;
    }

    private String zrndai1syenyenkijyun08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUN08)
    public String getZrndai1syenyenkijyun08() {
        return zrndai1syenyenkijyun08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyun08(String pZrndai1syenyenkijyun08) {
        zrndai1syenyenkijyun08 = pZrndai1syenyenkijyun08;
    }

    private String zrndai1syenyenyasu08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASU08)
    public String getZrndai1syenyenyasu08() {
        return zrndai1syenyenyasu08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasu08(String pZrndai1syenyenyasu08) {
        zrndai1syenyenyasu08 = pZrndai1syenyenyasu08;
    }

    private String zrndai1sibousnenoutouymd9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SIBOUSNENOUTOUYMD9)
    public String getZrndai1sibousnenoutouymd9() {
        return zrndai1sibousnenoutouymd9;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1sibousnenoutouymd9(String pZrndai1sibousnenoutouymd9) {
        zrndai1sibousnenoutouymd9 = pZrndai1sibousnenoutouymd9;
    }

    private String zrndai1stuuktype09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPE09)
    public String getZrndai1stuuktype09() {
        return zrndai1stuuktype09;
    }

    public void setZrndai1stuuktype09(String pZrndai1stuuktype09) {
        zrndai1stuuktype09 = pZrndai1stuuktype09;
    }

    private String zrndai1s09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1S09)
    public String getZrndai1s09() {
        return zrndai1s09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1s09(String pZrndai1s09) {
        zrndai1s09 = pZrndai1s09;
    }

    private String zrndai1syenyendakaumu09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMU09)
    public String getZrndai1syenyendakaumu09() {
        return zrndai1syenyendakaumu09;
    }

    public void setZrndai1syenyendakaumu09(String pZrndai1syenyendakaumu09) {
        zrndai1syenyendakaumu09 = pZrndai1syenyendakaumu09;
    }

    private String zrndai1syenyenkijyunumu09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNUMU09)
    public String getZrndai1syenyenkijyunumu09() {
        return zrndai1syenyenkijyunumu09;
    }

    public void setZrndai1syenyenkijyunumu09(String pZrndai1syenyenkijyunumu09) {
        zrndai1syenyenkijyunumu09 = pZrndai1syenyenkijyunumu09;
    }

    private String zrndai1syenyenyasuumu09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMU09)
    public String getZrndai1syenyenyasuumu09() {
        return zrndai1syenyenyasuumu09;
    }

    public void setZrndai1syenyenyasuumu09(String pZrndai1syenyenyasuumu09) {
        zrndai1syenyenyasuumu09 = pZrndai1syenyenyasuumu09;
    }

    private String zrndai1syentuuktype09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPE09)
    public String getZrndai1syentuuktype09() {
        return zrndai1syentuuktype09;
    }

    public void setZrndai1syentuuktype09(String pZrndai1syentuuktype09) {
        zrndai1syentuuktype09 = pZrndai1syentuuktype09;
    }

    private String zrndai1syenyendaka09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKA09)
    public String getZrndai1syenyendaka09() {
        return zrndai1syenyendaka09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendaka09(String pZrndai1syenyendaka09) {
        zrndai1syenyendaka09 = pZrndai1syenyendaka09;
    }

    private String zrndai1syenyenkijyun09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUN09)
    public String getZrndai1syenyenkijyun09() {
        return zrndai1syenyenkijyun09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyun09(String pZrndai1syenyenkijyun09) {
        zrndai1syenyenkijyun09 = pZrndai1syenyenkijyun09;
    }

    private String zrndai1syenyenyasu09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASU09)
    public String getZrndai1syenyenyasu09() {
        return zrndai1syenyenyasu09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasu09(String pZrndai1syenyenyasu09) {
        zrndai1syenyenyasu09 = pZrndai1syenyenyasu09;
    }

    private String zrndai1sibousnenoutouymd10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SIBOUSNENOUTOUYMD10)
    public String getZrndai1sibousnenoutouymd10() {
        return zrndai1sibousnenoutouymd10;
    }

    @DataConvert("toMultiByte")
    public void setZrndai1sibousnenoutouymd10(String pZrndai1sibousnenoutouymd10) {
        zrndai1sibousnenoutouymd10 = pZrndai1sibousnenoutouymd10;
    }

    private String zrndai1stuuktype10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPE10)
    public String getZrndai1stuuktype10() {
        return zrndai1stuuktype10;
    }

    public void setZrndai1stuuktype10(String pZrndai1stuuktype10) {
        zrndai1stuuktype10 = pZrndai1stuuktype10;
    }

    private String zrndai1s10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1S10)
    public String getZrndai1s10() {
        return zrndai1s10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1s10(String pZrndai1s10) {
        zrndai1s10 = pZrndai1s10;
    }

    private String zrndai1syenyendakaumu10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMU10)
    public String getZrndai1syenyendakaumu10() {
        return zrndai1syenyendakaumu10;
    }

    public void setZrndai1syenyendakaumu10(String pZrndai1syenyendakaumu10) {
        zrndai1syenyendakaumu10 = pZrndai1syenyendakaumu10;
    }

    private String zrndai1syenyenkijyunumu10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNUMU10)
    public String getZrndai1syenyenkijyunumu10() {
        return zrndai1syenyenkijyunumu10;
    }

    public void setZrndai1syenyenkijyunumu10(String pZrndai1syenyenkijyunumu10) {
        zrndai1syenyenkijyunumu10 = pZrndai1syenyenkijyunumu10;
    }

    private String zrndai1syenyenyasuumu10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMU10)
    public String getZrndai1syenyenyasuumu10() {
        return zrndai1syenyenyasuumu10;
    }

    public void setZrndai1syenyenyasuumu10(String pZrndai1syenyenyasuumu10) {
        zrndai1syenyenyasuumu10 = pZrndai1syenyenyasuumu10;
    }

    private String zrndai1syentuuktype10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPE10)
    public String getZrndai1syentuuktype10() {
        return zrndai1syentuuktype10;
    }

    public void setZrndai1syentuuktype10(String pZrndai1syentuuktype10) {
        zrndai1syentuuktype10 = pZrndai1syentuuktype10;
    }

    private String zrndai1syenyendaka10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKA10)
    public String getZrndai1syenyendaka10() {
        return zrndai1syenyendaka10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendaka10(String pZrndai1syenyendaka10) {
        zrndai1syenyendaka10 = pZrndai1syenyendaka10;
    }

    private String zrndai1syenyenkijyun10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUN10)
    public String getZrndai1syenyenkijyun10() {
        return zrndai1syenyenkijyun10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyun10(String pZrndai1syenyenkijyun10) {
        zrndai1syenyenkijyun10 = pZrndai1syenyenkijyun10;
    }

    private String zrndai1syenyenyasu10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASU10)
    public String getZrndai1syenyenyasu10() {
        return zrndai1syenyenyasu10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasu10(String pZrndai1syenyenyasu10) {
        zrndai1syenyenyasu10 = pZrndai1syenyenyasu10;
    }

    private String zrndai1stuuktypehuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1STUUKTYPEHURYO)
    public String getZrndai1stuuktypehuryo() {
        return zrndai1stuuktypehuryo;
    }

    public void setZrndai1stuuktypehuryo(String pZrndai1stuuktypehuryo) {
        zrndai1stuuktypehuryo = pZrndai1stuuktypehuryo;
    }

    private String zrndai1shuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SHURYO)
    public String getZrndai1shuryo() {
        return zrndai1shuryo;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1shuryo(String pZrndai1shuryo) {
        zrndai1shuryo = pZrndai1shuryo;
    }

    private String zrndai1syenyendakaumuhuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAUMUHURYO)
    public String getZrndai1syenyendakaumuhuryo() {
        return zrndai1syenyendakaumuhuryo;
    }

    public void setZrndai1syenyendakaumuhuryo(String pZrndai1syenyendakaumuhuryo) {
        zrndai1syenyendakaumuhuryo = pZrndai1syenyendakaumuhuryo;
    }

    private String zrndai1syenyenkjnumuhuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKJNUMUHURYO)
    public String getZrndai1syenyenkjnumuhuryo() {
        return zrndai1syenyenkjnumuhuryo;
    }

    public void setZrndai1syenyenkjnumuhuryo(String pZrndai1syenyenkjnumuhuryo) {
        zrndai1syenyenkjnumuhuryo = pZrndai1syenyenkjnumuhuryo;
    }

    private String zrndai1syenyenyasuumuhuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUUMUHURYO)
    public String getZrndai1syenyenyasuumuhuryo() {
        return zrndai1syenyenyasuumuhuryo;
    }

    public void setZrndai1syenyenyasuumuhuryo(String pZrndai1syenyenyasuumuhuryo) {
        zrndai1syenyenyasuumuhuryo = pZrndai1syenyenyasuumuhuryo;
    }

    private String zrndai1syentuuktypehuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENTUUKTYPEHURYO)
    public String getZrndai1syentuuktypehuryo() {
        return zrndai1syentuuktypehuryo;
    }

    public void setZrndai1syentuuktypehuryo(String pZrndai1syentuuktypehuryo) {
        zrndai1syentuuktypehuryo = pZrndai1syentuuktypehuryo;
    }

    private String zrndai1syenyendakahuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENDAKAHURYO)
    public String getZrndai1syenyendakahuryo() {
        return zrndai1syenyendakahuryo;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyendakahuryo(String pZrndai1syenyendakahuryo) {
        zrndai1syenyendakahuryo = pZrndai1syenyendakahuryo;
    }

    private String zrndai1syenyenkijyunhuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENKIJYUNHURYO)
    public String getZrndai1syenyenkijyunhuryo() {
        return zrndai1syenyenkijyunhuryo;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenkijyunhuryo(String pZrndai1syenyenkijyunhuryo) {
        zrndai1syenyenkijyunhuryo = pZrndai1syenyenkijyunhuryo;
    }

    private String zrndai1syenyenyasuhuryo;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI1SYENYENYASUHURYO)
    public String getZrndai1syenyenyasuhuryo() {
        return zrndai1syenyenyasuhuryo;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai1syenyenyasuhuryo(String pZrndai1syenyenyasuhuryo) {
        zrndai1syenyenyasuhuryo = pZrndai1syenyenyasuhuryo;
    }

    private String zrndai2stuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI2STUUKTYPE)
    public String getZrndai2stuuktype() {
        return zrndai2stuuktype;
    }

    public void setZrndai2stuuktype(String pZrndai2stuuktype) {
        zrndai2stuuktype = pZrndai2stuuktype;
    }

    private String zrndai2s;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI2S)
    public String getZrndai2s() {
        return zrndai2s;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai2s(String pZrndai2s) {
        zrndai2s = pZrndai2s;
    }

    private String zrndai2syentuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI2SYENTUUKTYPE)
    public String getZrndai2syentuuktype() {
        return zrndai2syentuuktype;
    }

    public void setZrndai2syentuuktype(String pZrndai2syentuuktype) {
        zrndai2syentuuktype = pZrndai2syentuuktype;
    }

    private String zrndai2syenyendaka;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI2SYENYENDAKA)
    public String getZrndai2syenyendaka() {
        return zrndai2syenyendaka;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai2syenyendaka(String pZrndai2syenyendaka) {
        zrndai2syenyendaka = pZrndai2syenyendaka;
    }

    private String zrndai2syenyenkijyun;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI2SYENYENKIJYUN)
    public String getZrndai2syenyenkijyun() {
        return zrndai2syenyenkijyun;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai2syenyenkijyun(String pZrndai2syenyenkijyun) {
        zrndai2syenyenkijyun = pZrndai2syenyenkijyun;
    }

    private String zrndai2syenyenyasu;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI2SYENYENYASU)
    public String getZrndai2syenyenyasu() {
        return zrndai2syenyenyasu;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai2syenyenyasu(String pZrndai2syenyenyasu) {
        zrndai2syenyenyasu = pZrndai2syenyenyasu;
    }

    private String zrndai3stuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI3STUUKTYPE)
    public String getZrndai3stuuktype() {
        return zrndai3stuuktype;
    }

    public void setZrndai3stuuktype(String pZrndai3stuuktype) {
        zrndai3stuuktype = pZrndai3stuuktype;
    }

    private String zrndai3s;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI3S)
    public String getZrndai3s() {
        return zrndai3s;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai3s(String pZrndai3s) {
        zrndai3s = pZrndai3s;
    }

    private String zrndai3syentuuktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI3SYENTUUKTYPE)
    public String getZrndai3syentuuktype() {
        return zrndai3syentuuktype;
    }

    public void setZrndai3syentuuktype(String pZrndai3syentuuktype) {
        zrndai3syentuuktype = pZrndai3syentuuktype;
    }

    private String zrndai3syenyendaka;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI3SYENYENDAKA)
    public String getZrndai3syenyendaka() {
        return zrndai3syenyendaka;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai3syenyendaka(String pZrndai3syenyendaka) {
        zrndai3syenyendaka = pZrndai3syenyendaka;
    }

    private String zrndai3syenyenkijyun;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI3SYENYENKIJYUN)
    public String getZrndai3syenyenkijyun() {
        return zrndai3syenyenkijyun;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai3syenyenkijyun(String pZrndai3syenyenkijyun) {
        zrndai3syenyenkijyun = pZrndai3syenyenkijyun;
    }

    private String zrndai3syenyenyasu;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNDAI3SYENYENYASU)
    public String getZrndai3syenyenyasu() {
        return zrndai3syenyenyasu;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrndai3syenyenyasu(String pZrndai3syenyenyasu) {
        zrndai3syenyenyasu = pZrndai3syenyenyasu;
    }

    private String zrnsibouinjiptnkbn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUINJIPTNKBN)
    public String getZrnsibouinjiptnkbn() {
        return zrnsibouinjiptnkbn;
    }

    public void setZrnsibouinjiptnkbn(String pZrnsibouinjiptnkbn) {
        zrnsibouinjiptnkbn = pZrnsibouinjiptnkbn;
    }

    private String zrnyobiv25;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV25)
    public String getZrnyobiv25() {
        return zrnyobiv25;
    }

    public void setZrnyobiv25(String pZrnyobiv25) {
        zrnyobiv25 = pZrnyobiv25;
    }

    private String zrnnkmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKMSGCD1)
    public String getZrnnkmsgcd1() {
        return zrnnkmsgcd1;
    }

    public void setZrnnkmsgcd1(String pZrnnkmsgcd1) {
        zrnnkmsgcd1 = pZrnnkmsgcd1;
    }

    private String zrnnkmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKMSGCD2)
    public String getZrnnkmsgcd2() {
        return zrnnkmsgcd2;
    }

    public void setZrnnkmsgcd2(String pZrnnkmsgcd2) {
        zrnnkmsgcd2 = pZrnnkmsgcd2;
    }

    private String zrnnkmsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKMSGCD3)
    public String getZrnnkmsgcd3() {
        return zrnnkmsgcd3;
    }

    public void setZrnnkmsgcd3(String pZrnnkmsgcd3) {
        zrnnkmsgcd3 = pZrnnkmsgcd3;
    }

    private String zrnnkmsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKMSGCD4)
    public String getZrnnkmsgcd4() {
        return zrnnkmsgcd4;
    }

    public void setZrnnkmsgcd4(String pZrnnkmsgcd4) {
        zrnnkmsgcd4 = pZrnnkmsgcd4;
    }

    private String zrnnkmsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKMSGCD5)
    public String getZrnnkmsgcd5() {
        return zrnnkmsgcd5;
    }

    public void setZrnnkmsgcd5(String pZrnnkmsgcd5) {
        zrnnkmsgcd5 = pZrnnkmsgcd5;
    }

    private String zrnnkmsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKMSGCD6)
    public String getZrnnkmsgcd6() {
        return zrnnkmsgcd6;
    }

    public void setZrnnkmsgcd6(String pZrnnkmsgcd6) {
        zrnnkmsgcd6 = pZrnnkmsgcd6;
    }

    private String zrnnkmsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKMSGCD7)
    public String getZrnnkmsgcd7() {
        return zrnnkmsgcd7;
    }

    public void setZrnnkmsgcd7(String pZrnnkmsgcd7) {
        zrnnkmsgcd7 = pZrnnkmsgcd7;
    }

    private String zrnnkmsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKMSGCD8)
    public String getZrnnkmsgcd8() {
        return zrnnkmsgcd8;
    }

    public void setZrnnkmsgcd8(String pZrnnkmsgcd8) {
        zrnnkmsgcd8 = pZrnnkmsgcd8;
    }

    private String zrnnkmsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKMSGCD9)
    public String getZrnnkmsgcd9() {
        return zrnnkmsgcd9;
    }

    public void setZrnnkmsgcd9(String pZrnnkmsgcd9) {
        zrnnkmsgcd9 = pZrnnkmsgcd9;
    }

    private String zrnnkmsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKMSGCD10)
    public String getZrnnkmsgcd10() {
        return zrnnkmsgcd10;
    }

    public void setZrnnkmsgcd10(String pZrnnkmsgcd10) {
        zrnnkmsgcd10 = pZrnnkmsgcd10;
    }

    private String zrnsiboukyuuhukinmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUKYUUHUKINMSGCD1)
    public String getZrnsiboukyuuhukinmsgcd1() {
        return zrnsiboukyuuhukinmsgcd1;
    }

    public void setZrnsiboukyuuhukinmsgcd1(String pZrnsiboukyuuhukinmsgcd1) {
        zrnsiboukyuuhukinmsgcd1 = pZrnsiboukyuuhukinmsgcd1;
    }

    private String zrnsiboukyuuhukinmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUKYUUHUKINMSGCD2)
    public String getZrnsiboukyuuhukinmsgcd2() {
        return zrnsiboukyuuhukinmsgcd2;
    }

    public void setZrnsiboukyuuhukinmsgcd2(String pZrnsiboukyuuhukinmsgcd2) {
        zrnsiboukyuuhukinmsgcd2 = pZrnsiboukyuuhukinmsgcd2;
    }

    private String zrnsiboukyuuhukinmsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUKYUUHUKINMSGCD3)
    public String getZrnsiboukyuuhukinmsgcd3() {
        return zrnsiboukyuuhukinmsgcd3;
    }

    public void setZrnsiboukyuuhukinmsgcd3(String pZrnsiboukyuuhukinmsgcd3) {
        zrnsiboukyuuhukinmsgcd3 = pZrnsiboukyuuhukinmsgcd3;
    }

    private String zrnsiboukyuuhukinmsgcd4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUKYUUHUKINMSGCD4)
    public String getZrnsiboukyuuhukinmsgcd4() {
        return zrnsiboukyuuhukinmsgcd4;
    }

    public void setZrnsiboukyuuhukinmsgcd4(String pZrnsiboukyuuhukinmsgcd4) {
        zrnsiboukyuuhukinmsgcd4 = pZrnsiboukyuuhukinmsgcd4;
    }

    private String zrnsiboukyuuhukinmsgcd5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUKYUUHUKINMSGCD5)
    public String getZrnsiboukyuuhukinmsgcd5() {
        return zrnsiboukyuuhukinmsgcd5;
    }

    public void setZrnsiboukyuuhukinmsgcd5(String pZrnsiboukyuuhukinmsgcd5) {
        zrnsiboukyuuhukinmsgcd5 = pZrnsiboukyuuhukinmsgcd5;
    }

    private String zrnsiboukyuuhukinmsgcd6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUKYUUHUKINMSGCD6)
    public String getZrnsiboukyuuhukinmsgcd6() {
        return zrnsiboukyuuhukinmsgcd6;
    }

    public void setZrnsiboukyuuhukinmsgcd6(String pZrnsiboukyuuhukinmsgcd6) {
        zrnsiboukyuuhukinmsgcd6 = pZrnsiboukyuuhukinmsgcd6;
    }

    private String zrnsiboukyuuhukinmsgcd7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUKYUUHUKINMSGCD7)
    public String getZrnsiboukyuuhukinmsgcd7() {
        return zrnsiboukyuuhukinmsgcd7;
    }

    public void setZrnsiboukyuuhukinmsgcd7(String pZrnsiboukyuuhukinmsgcd7) {
        zrnsiboukyuuhukinmsgcd7 = pZrnsiboukyuuhukinmsgcd7;
    }

    private String zrnsiboukyuuhukinmsgcd8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUKYUUHUKINMSGCD8)
    public String getZrnsiboukyuuhukinmsgcd8() {
        return zrnsiboukyuuhukinmsgcd8;
    }

    public void setZrnsiboukyuuhukinmsgcd8(String pZrnsiboukyuuhukinmsgcd8) {
        zrnsiboukyuuhukinmsgcd8 = pZrnsiboukyuuhukinmsgcd8;
    }

    private String zrnsiboukyuuhukinmsgcd9;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUKYUUHUKINMSGCD9)
    public String getZrnsiboukyuuhukinmsgcd9() {
        return zrnsiboukyuuhukinmsgcd9;
    }

    public void setZrnsiboukyuuhukinmsgcd9(String pZrnsiboukyuuhukinmsgcd9) {
        zrnsiboukyuuhukinmsgcd9 = pZrnsiboukyuuhukinmsgcd9;
    }

    private String zrnsiboukyuuhukinmsgcd10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIBOUKYUUHUKINMSGCD10)
    public String getZrnsiboukyuuhukinmsgcd10() {
        return zrnsiboukyuuhukinmsgcd10;
    }

    public void setZrnsiboukyuuhukinmsgcd10(String pZrnsiboukyuuhukinmsgcd10) {
        zrnsiboukyuuhukinmsgcd10 = pZrnsiboukyuuhukinmsgcd10;
    }

    private String zrnnkshrstartzenymd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNNKSHRSTARTZENYMD)
    public String getZrnnkshrstartzenymd() {
        return zrnnkshrstartzenymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnnkshrstartzenymd(String pZrnnkshrstartzenymd) {
        zrnnkshrstartzenymd = pZrnnkshrstartzenymd;
    }

    private String zrnmkhyouyennkhknhentktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNMKHYOUYENNKHKNHENTKTYPE)
    public String getZrnmkhyouyennkhknhentktype() {
        return zrnmkhyouyennkhknhentktype;
    }

    public void setZrnmkhyouyennkhknhentktype(String pZrnmkhyouyennkhknhentktype) {
        zrnmkhyouyennkhknhentktype = pZrnmkhyouyennkhknhentktype;
    }

    private String zrnmkhyouyennkhknhentkmkhgk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNMKHYOUYENNKHKNHENTKMKHGK)
    public String getZrnmkhyouyennkhknhentkmkhgk() {
        return zrnmkhyouyennkhknhentkmkhgk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmkhyouyennkhknhentkmkhgk(String pZrnmkhyouyennkhknhentkmkhgk) {
        zrnmkhyouyennkhknhentkmkhgk = pZrnmkhyouyennkhknhentkmkhgk;
    }

    private String zrnmkhyennkhknhentkmkhwari;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNMKHYENNKHKNHENTKMKHWARI)
    public String getZrnmkhyennkhknhentkmkhwari() {
        return zrnmkhyennkhknhentkmkhwari;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnmkhyennkhknhentkmkhwari(String pZrnmkhyennkhknhentkmkhwari) {
        zrnmkhyennkhknhentkmkhwari = pZrnmkhyennkhknhentkmkhwari;
    }

    private String zrnhaibunwarimsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHAIBUNWARIMSGCD1)
    public String getZrnhaibunwarimsgcd1() {
        return zrnhaibunwarimsgcd1;
    }

    public void setZrnhaibunwarimsgcd1(String pZrnhaibunwarimsgcd1) {
        zrnhaibunwarimsgcd1 = pZrnhaibunwarimsgcd1;
    }

    private String zrnhaibunwarimsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHAIBUNWARIMSGCD2)
    public String getZrnhaibunwarimsgcd2() {
        return zrnhaibunwarimsgcd2;
    }

    public void setZrnhaibunwarimsgcd2(String pZrnhaibunwarimsgcd2) {
        zrnhaibunwarimsgcd2 = pZrnhaibunwarimsgcd2;
    }

    private String zrnhaibunwarimsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHAIBUNWARIMSGCD3)
    public String getZrnhaibunwarimsgcd3() {
        return zrnhaibunwarimsgcd3;
    }

    public void setZrnhaibunwarimsgcd3(String pZrnhaibunwarimsgcd3) {
        zrnhaibunwarimsgcd3 = pZrnhaibunwarimsgcd3;
    }

    private String zrnteiritutmtthbnwr;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTEIRITUTMTTHBNWR)
    public String getZrnteiritutmtthbnwr() {
        return zrnteiritutmtthbnwr;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnteiritutmtthbnwr(String pZrnteiritutmtthbnwr) {
        zrnteiritutmtthbnwr = pZrnteiritutmtthbnwr;
    }

    private String zrnsisuutmtthbnwr;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSISUUTMTTHBNWR)
    public String getZrnsisuutmtthbnwr() {
        return zrnsisuutmtthbnwr;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnsisuutmtthbnwr(String pZrnsisuutmtthbnwr) {
        zrnsisuutmtthbnwr = pZrnsisuutmtthbnwr;
    }

    private String zrnsisuuannaimsg1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSISUUANNAIMSG1)
    public String getZrnsisuuannaimsg1() {
        return zrnsisuuannaimsg1;
    }

    public void setZrnsisuuannaimsg1(String pZrnsisuuannaimsg1) {
        zrnsisuuannaimsg1 = pZrnsisuuannaimsg1;
    }

    private String zrnsisuuannaimsg2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSISUUANNAIMSG2)
    public String getZrnsisuuannaimsg2() {
        return zrnsisuuannaimsg2;
    }

    public void setZrnsisuuannaimsg2(String pZrnsisuuannaimsg2) {
        zrnsisuuannaimsg2 = pZrnsisuuannaimsg2;
    }

    private String zrnsisuuannaimsg3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSISUUANNAIMSG3)
    public String getZrnsisuuannaimsg3() {
        return zrnsisuuannaimsg3;
    }

    public void setZrnsisuuannaimsg3(String pZrnsisuuannaimsg3) {
        zrnsisuuannaimsg3 = pZrnsisuuannaimsg3;
    }

    private String zrnmkhyouyensysnikoumsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNMKHYOUYENSYSNIKOUMSGCD)
    public String getZrnmkhyouyensysnikoumsgcd() {
        return zrnmkhyouyensysnikoumsgcd;
    }

    public void setZrnmkhyouyensysnikoumsgcd(String pZrnmkhyouyensysnikoumsgcd) {
        zrnmkhyouyensysnikoumsgcd = pZrnmkhyouyensysnikoumsgcd;
    }

    private String zrnmkhyouyensysnikoumsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNMKHYOUYENSYSNIKOUMSGCD2)
    public String getZrnmkhyouyensysnikoumsgcd2() {
        return zrnmkhyouyensysnikoumsgcd2;
    }

    public void setZrnmkhyouyensysnikoumsgcd2(String pZrnmkhyouyensysnikoumsgcd2) {
        zrnmkhyouyensysnikoumsgcd2 = pZrnmkhyouyensysnikoumsgcd2;
    }

    private String zrnmkhyouyensysnikoumsgcd3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNMKHYOUYENSYSNIKOUMSGCD3)
    public String getZrnmkhyouyensysnikoumsgcd3() {
        return zrnmkhyouyensysnikoumsgcd3;
    }

    public void setZrnmkhyouyensysnikoumsgcd3(String pZrnmkhyouyensysnikoumsgcd3) {
        zrnmkhyouyensysnikoumsgcd3 = pZrnmkhyouyensysnikoumsgcd3;
    }

    private String zrnmkhyouyensysnikougktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNMKHYOUYENSYSNIKOUGKTYPE)
    public String getZrnmkhyouyensysnikougktype() {
        return zrnmkhyouyensysnikougktype;
    }

    public void setZrnmkhyouyensysnikougktype(String pZrnmkhyouyensysnikougktype) {
        zrnmkhyouyensysnikougktype = pZrnmkhyouyensysnikougktype;
    }

    private String zrnmkhyouyensysnikougk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNMKHYOUYENSYSNIKOUGK)
    public String getZrnmkhyouyensysnikougk() {
        return zrnmkhyouyensysnikougk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmkhyouyensysnikougk(String pZrnmkhyouyensysnikougk) {
        zrnmkhyouyensysnikougk = pZrnmkhyouyensysnikougk;
    }

    private String zrnmkhyouyensysnikouwra;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNMKHYOUYENSYSNIKOUWRA)
    public String getZrnmkhyouyensysnikouwra() {
        return zrnmkhyouyensysnikouwra;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnmkhyouyensysnikouwra(String pZrnmkhyouyensysnikouwra) {
        zrnmkhyouyensysnikouwra = pZrnmkhyouyensysnikouwra;
    }

    private String zrnmkhyouysysnikcurrentgk;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNMKHYOUYSYSNIKCURRENTGK)
    public String getZrnmkhyouysysnikcurrentgk() {
        return zrnmkhyouysysnikcurrentgk;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnmkhyouysysnikcurrentgk(String pZrnmkhyouysysnikcurrentgk) {
        zrnmkhyouysysnikcurrentgk = pZrnmkhyouysysnikcurrentgk;
    }

    private String zrnyobiv12;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV12)
    public String getZrnyobiv12() {
        return zrnyobiv12;
    }

    public void setZrnyobiv12(String pZrnyobiv12) {
        zrnyobiv12 = pZrnyobiv12;
    }

    private String zrnkaigomaehrtkykmsgcd1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRTKYKMSGCD1)
    public String getZrnkaigomaehrtkykmsgcd1() {
        return zrnkaigomaehrtkykmsgcd1;
    }

    public void setZrnkaigomaehrtkykmsgcd1(String pZrnkaigomaehrtkykmsgcd1) {
        zrnkaigomaehrtkykmsgcd1 = pZrnkaigomaehrtkykmsgcd1;
    }

    private String zrnkaigomaehrtkykmsgcd2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRTKYKMSGCD2)
    public String getZrnkaigomaehrtkykmsgcd2() {
        return zrnkaigomaehrtkykmsgcd2;
    }

    public void setZrnkaigomaehrtkykmsgcd2(String pZrnkaigomaehrtkykmsgcd2) {
        zrnkaigomaehrtkykmsgcd2 = pZrnkaigomaehrtkykmsgcd2;
    }

    private String zrnkaigomaehrtkykmsgcdst1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRTKYKMSGCDST1)
    public String getZrnkaigomaehrtkykmsgcdst1() {
        return zrnkaigomaehrtkykmsgcdst1;
    }

    public void setZrnkaigomaehrtkykmsgcdst1(String pZrnkaigomaehrtkykmsgcdst1) {
        zrnkaigomaehrtkykmsgcdst1 = pZrnkaigomaehrtkykmsgcdst1;
    }

    private String zrnkaigomaehrtkykmsgcdst2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRTKYKMSGCDST2)
    public String getZrnkaigomaehrtkykmsgcdst2() {
        return zrnkaigomaehrtkykmsgcdst2;
    }

    public void setZrnkaigomaehrtkykmsgcdst2(String pZrnkaigomaehrtkykmsgcdst2) {
        zrnkaigomaehrtkykmsgcdst2 = pZrnkaigomaehrtkykmsgcdst2;
    }

    private String zrnkgmaehrtkhknkkn1mnryymd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRTKHKNKKN1MNRYYMD)
    public String getZrnkgmaehrtkhknkkn1mnryymd() {
        return zrnkgmaehrtkhknkkn1mnryymd;
    }

    @DataConvert("toMultiByte")
    public void setZrnkgmaehrtkhknkkn1mnryymd(String pZrnkgmaehrtkhknkkn1mnryymd) {
        zrnkgmaehrtkhknkkn1mnryymd = pZrnkgmaehrtkhknkkn1mnryymd;
    }

    private String zrnkaigomaehrtkykitrnumu;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRTKYKITRNUMU)
    public String getZrnkaigomaehrtkykitrnumu() {
        return zrnkaigomaehrtkykitrnumu;
    }

    public void setZrnkaigomaehrtkykitrnumu(String pZrnkaigomaehrtkykitrnumu) {
        zrnkaigomaehrtkykitrnumu = pZrnkaigomaehrtkykitrnumu;
    }

    private String zrnkaigomaehrtkykkyktuuka;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRTKYKKYKTUUKA)
    public String getZrnkaigomaehrtkykkyktuuka() {
        return zrnkaigomaehrtkykkyktuuka;
    }

    @DataConvert("toMultiByte")
    public void setZrnkaigomaehrtkykkyktuuka(String pZrnkaigomaehrtkykkyktuuka) {
        zrnkaigomaehrtkykkyktuuka = pZrnkaigomaehrtkykkyktuuka;
    }

    private String zrnkaigomaehrtkykstdmsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRTKYKSTDMSGCD)
    public String getZrnkaigomaehrtkykstdmsgcd() {
        return zrnkaigomaehrtkykstdmsgcd;
    }

    public void setZrnkaigomaehrtkykstdmsgcd(String pZrnkaigomaehrtkykstdmsgcd) {
        zrnkaigomaehrtkykstdmsgcd = pZrnkaigomaehrtkykstdmsgcd;
    }

    private String zrnkaigomaehrjrugktype;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKTYPE)
    public String getZrnkaigomaehrjrugktype() {
        return zrnkaigomaehrjrugktype;
    }

    public void setZrnkaigomaehrjrugktype(String pZrnkaigomaehrjrugktype) {
        zrnkaigomaehrjrugktype = pZrnkaigomaehrjrugktype;
    }

    private String zrnkaigomaehrsikuhhknnen01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSIKUHHKNNEN01)
    public String getZrnkaigomaehrsikuhhknnen01() {
        return zrnkaigomaehrsikuhhknnen01;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrsikuhhknnen01(String pZrnkaigomaehrsikuhhknnen01) {
        zrnkaigomaehrsikuhhknnen01 = pZrnkaigomaehrsikuhhknnen01;
    }

    private String zrnkaigomaehrstikkn01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSTIKKN01)
    public String getZrnkaigomaehrstikkn01() {
        return zrnkaigomaehrstikkn01;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrstikkn01(String pZrnkaigomaehrstikkn01) {
        zrnkaigomaehrstikkn01 = pZrnkaigomaehrstikkn01;
    }

    private String zrnkaigomaehrjrugk01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGK01)
    public String getZrnkaigomaehrjrugk01() {
        return zrnkaigomaehrjrugk01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugk01(String pZrnkaigomaehrjrugk01) {
        zrnkaigomaehrjrugk01 = pZrnkaigomaehrjrugk01;
    }

    private String zrnkaigomaehrsikuhhknnen02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSIKUHHKNNEN02)
    public String getZrnkaigomaehrsikuhhknnen02() {
        return zrnkaigomaehrsikuhhknnen02;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrsikuhhknnen02(String pZrnkaigomaehrsikuhhknnen02) {
        zrnkaigomaehrsikuhhknnen02 = pZrnkaigomaehrsikuhhknnen02;
    }

    private String zrnkaigomaehrstikkn02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSTIKKN02)
    public String getZrnkaigomaehrstikkn02() {
        return zrnkaigomaehrstikkn02;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrstikkn02(String pZrnkaigomaehrstikkn02) {
        zrnkaigomaehrstikkn02 = pZrnkaigomaehrstikkn02;
    }

    private String zrnkaigomaehrjrugk02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGK02)
    public String getZrnkaigomaehrjrugk02() {
        return zrnkaigomaehrjrugk02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugk02(String pZrnkaigomaehrjrugk02) {
        zrnkaigomaehrjrugk02 = pZrnkaigomaehrjrugk02;
    }

    private String zrnkaigomaehrsikuhhknnen03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSIKUHHKNNEN03)
    public String getZrnkaigomaehrsikuhhknnen03() {
        return zrnkaigomaehrsikuhhknnen03;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrsikuhhknnen03(String pZrnkaigomaehrsikuhhknnen03) {
        zrnkaigomaehrsikuhhknnen03 = pZrnkaigomaehrsikuhhknnen03;
    }

    private String zrnkaigomaehrstikkn03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSTIKKN03)
    public String getZrnkaigomaehrstikkn03() {
        return zrnkaigomaehrstikkn03;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrstikkn03(String pZrnkaigomaehrstikkn03) {
        zrnkaigomaehrstikkn03 = pZrnkaigomaehrstikkn03;
    }

    private String zrnkaigomaehrjrugk03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGK03)
    public String getZrnkaigomaehrjrugk03() {
        return zrnkaigomaehrjrugk03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugk03(String pZrnkaigomaehrjrugk03) {
        zrnkaigomaehrjrugk03 = pZrnkaigomaehrjrugk03;
    }

    private String zrnkaigomaehrsikuhhknnen04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSIKUHHKNNEN04)
    public String getZrnkaigomaehrsikuhhknnen04() {
        return zrnkaigomaehrsikuhhknnen04;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrsikuhhknnen04(String pZrnkaigomaehrsikuhhknnen04) {
        zrnkaigomaehrsikuhhknnen04 = pZrnkaigomaehrsikuhhknnen04;
    }

    private String zrnkaigomaehrstikkn04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSTIKKN04)
    public String getZrnkaigomaehrstikkn04() {
        return zrnkaigomaehrstikkn04;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrstikkn04(String pZrnkaigomaehrstikkn04) {
        zrnkaigomaehrstikkn04 = pZrnkaigomaehrstikkn04;
    }

    private String zrnkaigomaehrjrugk04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGK04)
    public String getZrnkaigomaehrjrugk04() {
        return zrnkaigomaehrjrugk04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugk04(String pZrnkaigomaehrjrugk04) {
        zrnkaigomaehrjrugk04 = pZrnkaigomaehrjrugk04;
    }

    private String zrnkaigomaehrsikuhhknnen05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSIKUHHKNNEN05)
    public String getZrnkaigomaehrsikuhhknnen05() {
        return zrnkaigomaehrsikuhhknnen05;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrsikuhhknnen05(String pZrnkaigomaehrsikuhhknnen05) {
        zrnkaigomaehrsikuhhknnen05 = pZrnkaigomaehrsikuhhknnen05;
    }

    private String zrnkaigomaehrstikkn05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSTIKKN05)
    public String getZrnkaigomaehrstikkn05() {
        return zrnkaigomaehrstikkn05;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrstikkn05(String pZrnkaigomaehrstikkn05) {
        zrnkaigomaehrstikkn05 = pZrnkaigomaehrstikkn05;
    }

    private String zrnkaigomaehrjrugk05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGK05)
    public String getZrnkaigomaehrjrugk05() {
        return zrnkaigomaehrjrugk05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugk05(String pZrnkaigomaehrjrugk05) {
        zrnkaigomaehrjrugk05 = pZrnkaigomaehrjrugk05;
    }

    private String zrnkaigomaehrsikuhhknnen06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSIKUHHKNNEN06)
    public String getZrnkaigomaehrsikuhhknnen06() {
        return zrnkaigomaehrsikuhhknnen06;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrsikuhhknnen06(String pZrnkaigomaehrsikuhhknnen06) {
        zrnkaigomaehrsikuhhknnen06 = pZrnkaigomaehrsikuhhknnen06;
    }

    private String zrnkaigomaehrstikkn06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSTIKKN06)
    public String getZrnkaigomaehrstikkn06() {
        return zrnkaigomaehrstikkn06;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrstikkn06(String pZrnkaigomaehrstikkn06) {
        zrnkaigomaehrstikkn06 = pZrnkaigomaehrstikkn06;
    }

    private String zrnkaigomaehrjrugk06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGK06)
    public String getZrnkaigomaehrjrugk06() {
        return zrnkaigomaehrjrugk06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugk06(String pZrnkaigomaehrjrugk06) {
        zrnkaigomaehrjrugk06 = pZrnkaigomaehrjrugk06;
    }

    private String zrnkaigomaehrsikuhhknnen07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSIKUHHKNNEN07)
    public String getZrnkaigomaehrsikuhhknnen07() {
        return zrnkaigomaehrsikuhhknnen07;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrsikuhhknnen07(String pZrnkaigomaehrsikuhhknnen07) {
        zrnkaigomaehrsikuhhknnen07 = pZrnkaigomaehrsikuhhknnen07;
    }

    private String zrnkaigomaehrstikkn07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSTIKKN07)
    public String getZrnkaigomaehrstikkn07() {
        return zrnkaigomaehrstikkn07;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrstikkn07(String pZrnkaigomaehrstikkn07) {
        zrnkaigomaehrstikkn07 = pZrnkaigomaehrstikkn07;
    }

    private String zrnkaigomaehrjrugk07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGK07)
    public String getZrnkaigomaehrjrugk07() {
        return zrnkaigomaehrjrugk07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugk07(String pZrnkaigomaehrjrugk07) {
        zrnkaigomaehrjrugk07 = pZrnkaigomaehrjrugk07;
    }

    private String zrnkaigomaehrsikuhhknnen08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSIKUHHKNNEN08)
    public String getZrnkaigomaehrsikuhhknnen08() {
        return zrnkaigomaehrsikuhhknnen08;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrsikuhhknnen08(String pZrnkaigomaehrsikuhhknnen08) {
        zrnkaigomaehrsikuhhknnen08 = pZrnkaigomaehrsikuhhknnen08;
    }

    private String zrnkaigomaehrstikkn08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSTIKKN08)
    public String getZrnkaigomaehrstikkn08() {
        return zrnkaigomaehrstikkn08;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrstikkn08(String pZrnkaigomaehrstikkn08) {
        zrnkaigomaehrstikkn08 = pZrnkaigomaehrstikkn08;
    }

    private String zrnkaigomaehrjrugk08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGK08)
    public String getZrnkaigomaehrjrugk08() {
        return zrnkaigomaehrjrugk08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugk08(String pZrnkaigomaehrjrugk08) {
        zrnkaigomaehrjrugk08 = pZrnkaigomaehrjrugk08;
    }

    private String zrnkaigomaehrsikuhhknnen09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSIKUHHKNNEN09)
    public String getZrnkaigomaehrsikuhhknnen09() {
        return zrnkaigomaehrsikuhhknnen09;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrsikuhhknnen09(String pZrnkaigomaehrsikuhhknnen09) {
        zrnkaigomaehrsikuhhknnen09 = pZrnkaigomaehrsikuhhknnen09;
    }

    private String zrnkaigomaehrstikkn09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSTIKKN09)
    public String getZrnkaigomaehrstikkn09() {
        return zrnkaigomaehrstikkn09;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrstikkn09(String pZrnkaigomaehrstikkn09) {
        zrnkaigomaehrstikkn09 = pZrnkaigomaehrstikkn09;
    }

    private String zrnkaigomaehrjrugk09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGK09)
    public String getZrnkaigomaehrjrugk09() {
        return zrnkaigomaehrjrugk09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugk09(String pZrnkaigomaehrjrugk09) {
        zrnkaigomaehrjrugk09 = pZrnkaigomaehrjrugk09;
    }

    private String zrnkaigomaehrsikuhhknnen10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSIKUHHKNNEN10)
    public String getZrnkaigomaehrsikuhhknnen10() {
        return zrnkaigomaehrsikuhhknnen10;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrsikuhhknnen10(String pZrnkaigomaehrsikuhhknnen10) {
        zrnkaigomaehrsikuhhknnen10 = pZrnkaigomaehrsikuhhknnen10;
    }

    private String zrnkaigomaehrstikkn10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRSTIKKN10)
    public String getZrnkaigomaehrstikkn10() {
        return zrnkaigomaehrstikkn10;
    }

    @Padding(mode = "left", padChar ='0', length =3)
    public void setZrnkaigomaehrstikkn10(String pZrnkaigomaehrstikkn10) {
        zrnkaigomaehrstikkn10 = pZrnkaigomaehrstikkn10;
    }

    private String zrnkaigomaehrjrugk10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGK10)
    public String getZrnkaigomaehrjrugk10() {
        return zrnkaigomaehrjrugk10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugk10(String pZrnkaigomaehrjrugk10) {
        zrnkaigomaehrjrugk10 = pZrnkaigomaehrjrugk10;
    }

    private String zrnkaigomaehrjrugkydaka01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKYDAKA01)
    public String getZrnkaigomaehrjrugkydaka01() {
        return zrnkaigomaehrjrugkydaka01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugkydaka01(String pZrnkaigomaehrjrugkydaka01) {
        zrnkaigomaehrjrugkydaka01 = pZrnkaigomaehrjrugkydaka01;
    }

    private String zrnkgmaehrjrugkykijyun01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYKIJYUN01)
    public String getZrnkgmaehrjrugkykijyun01() {
        return zrnkgmaehrjrugkykijyun01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkykijyun01(String pZrnkgmaehrjrugkykijyun01) {
        zrnkgmaehrjrugkykijyun01 = pZrnkgmaehrjrugkykijyun01;
    }

    private String zrnkgmaehrjrugkyyasu01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYYASU01)
    public String getZrnkgmaehrjrugkyyasu01() {
        return zrnkgmaehrjrugkyyasu01;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkyyasu01(String pZrnkgmaehrjrugkyyasu01) {
        zrnkgmaehrjrugkyyasu01 = pZrnkgmaehrjrugkyyasu01;
    }

    private String zrnkaigomaehrjrugkydaka02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKYDAKA02)
    public String getZrnkaigomaehrjrugkydaka02() {
        return zrnkaigomaehrjrugkydaka02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugkydaka02(String pZrnkaigomaehrjrugkydaka02) {
        zrnkaigomaehrjrugkydaka02 = pZrnkaigomaehrjrugkydaka02;
    }

    private String zrnkgmaehrjrugkykijyun02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYKIJYUN02)
    public String getZrnkgmaehrjrugkykijyun02() {
        return zrnkgmaehrjrugkykijyun02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkykijyun02(String pZrnkgmaehrjrugkykijyun02) {
        zrnkgmaehrjrugkykijyun02 = pZrnkgmaehrjrugkykijyun02;
    }

    private String zrnkgmaehrjrugkyyasu02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYYASU02)
    public String getZrnkgmaehrjrugkyyasu02() {
        return zrnkgmaehrjrugkyyasu02;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkyyasu02(String pZrnkgmaehrjrugkyyasu02) {
        zrnkgmaehrjrugkyyasu02 = pZrnkgmaehrjrugkyyasu02;
    }

    private String zrnkaigomaehrjrugkydaka03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKYDAKA03)
    public String getZrnkaigomaehrjrugkydaka03() {
        return zrnkaigomaehrjrugkydaka03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugkydaka03(String pZrnkaigomaehrjrugkydaka03) {
        zrnkaigomaehrjrugkydaka03 = pZrnkaigomaehrjrugkydaka03;
    }

    private String zrnkgmaehrjrugkykijyun03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYKIJYUN03)
    public String getZrnkgmaehrjrugkykijyun03() {
        return zrnkgmaehrjrugkykijyun03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkykijyun03(String pZrnkgmaehrjrugkykijyun03) {
        zrnkgmaehrjrugkykijyun03 = pZrnkgmaehrjrugkykijyun03;
    }

    private String zrnkgmaehrjrugkyyasu03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYYASU03)
    public String getZrnkgmaehrjrugkyyasu03() {
        return zrnkgmaehrjrugkyyasu03;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkyyasu03(String pZrnkgmaehrjrugkyyasu03) {
        zrnkgmaehrjrugkyyasu03 = pZrnkgmaehrjrugkyyasu03;
    }

    private String zrnkaigomaehrjrugkydaka04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKYDAKA04)
    public String getZrnkaigomaehrjrugkydaka04() {
        return zrnkaigomaehrjrugkydaka04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugkydaka04(String pZrnkaigomaehrjrugkydaka04) {
        zrnkaigomaehrjrugkydaka04 = pZrnkaigomaehrjrugkydaka04;
    }

    private String zrnkgmaehrjrugkykijyun04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYKIJYUN04)
    public String getZrnkgmaehrjrugkykijyun04() {
        return zrnkgmaehrjrugkykijyun04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkykijyun04(String pZrnkgmaehrjrugkykijyun04) {
        zrnkgmaehrjrugkykijyun04 = pZrnkgmaehrjrugkykijyun04;
    }

    private String zrnkgmaehrjrugkyyasu04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYYASU04)
    public String getZrnkgmaehrjrugkyyasu04() {
        return zrnkgmaehrjrugkyyasu04;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkyyasu04(String pZrnkgmaehrjrugkyyasu04) {
        zrnkgmaehrjrugkyyasu04 = pZrnkgmaehrjrugkyyasu04;
    }

    private String zrnkaigomaehrjrugkydaka05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKYDAKA05)
    public String getZrnkaigomaehrjrugkydaka05() {
        return zrnkaigomaehrjrugkydaka05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugkydaka05(String pZrnkaigomaehrjrugkydaka05) {
        zrnkaigomaehrjrugkydaka05 = pZrnkaigomaehrjrugkydaka05;
    }

    private String zrnkgmaehrjrugkykijyun05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYKIJYUN05)
    public String getZrnkgmaehrjrugkykijyun05() {
        return zrnkgmaehrjrugkykijyun05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkykijyun05(String pZrnkgmaehrjrugkykijyun05) {
        zrnkgmaehrjrugkykijyun05 = pZrnkgmaehrjrugkykijyun05;
    }

    private String zrnkgmaehrjrugkyyasu05;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYYASU05)
    public String getZrnkgmaehrjrugkyyasu05() {
        return zrnkgmaehrjrugkyyasu05;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkyyasu05(String pZrnkgmaehrjrugkyyasu05) {
        zrnkgmaehrjrugkyyasu05 = pZrnkgmaehrjrugkyyasu05;
    }

    private String zrnkaigomaehrjrugkydaka06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKYDAKA06)
    public String getZrnkaigomaehrjrugkydaka06() {
        return zrnkaigomaehrjrugkydaka06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugkydaka06(String pZrnkaigomaehrjrugkydaka06) {
        zrnkaigomaehrjrugkydaka06 = pZrnkaigomaehrjrugkydaka06;
    }

    private String zrnkgmaehrjrugkykijyun06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYKIJYUN06)
    public String getZrnkgmaehrjrugkykijyun06() {
        return zrnkgmaehrjrugkykijyun06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkykijyun06(String pZrnkgmaehrjrugkykijyun06) {
        zrnkgmaehrjrugkykijyun06 = pZrnkgmaehrjrugkykijyun06;
    }

    private String zrnkgmaehrjrugkyyasu06;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYYASU06)
    public String getZrnkgmaehrjrugkyyasu06() {
        return zrnkgmaehrjrugkyyasu06;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkyyasu06(String pZrnkgmaehrjrugkyyasu06) {
        zrnkgmaehrjrugkyyasu06 = pZrnkgmaehrjrugkyyasu06;
    }

    private String zrnkaigomaehrjrugkydaka07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKYDAKA07)
    public String getZrnkaigomaehrjrugkydaka07() {
        return zrnkaigomaehrjrugkydaka07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugkydaka07(String pZrnkaigomaehrjrugkydaka07) {
        zrnkaigomaehrjrugkydaka07 = pZrnkaigomaehrjrugkydaka07;
    }

    private String zrnkgmaehrjrugkykijyun07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYKIJYUN07)
    public String getZrnkgmaehrjrugkykijyun07() {
        return zrnkgmaehrjrugkykijyun07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkykijyun07(String pZrnkgmaehrjrugkykijyun07) {
        zrnkgmaehrjrugkykijyun07 = pZrnkgmaehrjrugkykijyun07;
    }

    private String zrnkgmaehrjrugkyyasu07;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYYASU07)
    public String getZrnkgmaehrjrugkyyasu07() {
        return zrnkgmaehrjrugkyyasu07;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkyyasu07(String pZrnkgmaehrjrugkyyasu07) {
        zrnkgmaehrjrugkyyasu07 = pZrnkgmaehrjrugkyyasu07;
    }

    private String zrnkaigomaehrjrugkydaka08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKYDAKA08)
    public String getZrnkaigomaehrjrugkydaka08() {
        return zrnkaigomaehrjrugkydaka08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugkydaka08(String pZrnkaigomaehrjrugkydaka08) {
        zrnkaigomaehrjrugkydaka08 = pZrnkaigomaehrjrugkydaka08;
    }

    private String zrnkgmaehrjrugkykijyun08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYKIJYUN08)
    public String getZrnkgmaehrjrugkykijyun08() {
        return zrnkgmaehrjrugkykijyun08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkykijyun08(String pZrnkgmaehrjrugkykijyun08) {
        zrnkgmaehrjrugkykijyun08 = pZrnkgmaehrjrugkykijyun08;
    }

    private String zrnkgmaehrjrugkyyasu08;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYYASU08)
    public String getZrnkgmaehrjrugkyyasu08() {
        return zrnkgmaehrjrugkyyasu08;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkyyasu08(String pZrnkgmaehrjrugkyyasu08) {
        zrnkgmaehrjrugkyyasu08 = pZrnkgmaehrjrugkyyasu08;
    }

    private String zrnkaigomaehrjrugkydaka09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKYDAKA09)
    public String getZrnkaigomaehrjrugkydaka09() {
        return zrnkaigomaehrjrugkydaka09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugkydaka09(String pZrnkaigomaehrjrugkydaka09) {
        zrnkaigomaehrjrugkydaka09 = pZrnkaigomaehrjrugkydaka09;
    }

    private String zrnkgmaehrjrugkykijyun09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYKIJYUN09)
    public String getZrnkgmaehrjrugkykijyun09() {
        return zrnkgmaehrjrugkykijyun09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkykijyun09(String pZrnkgmaehrjrugkykijyun09) {
        zrnkgmaehrjrugkykijyun09 = pZrnkgmaehrjrugkykijyun09;
    }

    private String zrnkgmaehrjrugkyyasu09;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYYASU09)
    public String getZrnkgmaehrjrugkyyasu09() {
        return zrnkgmaehrjrugkyyasu09;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkyyasu09(String pZrnkgmaehrjrugkyyasu09) {
        zrnkgmaehrjrugkyyasu09 = pZrnkgmaehrjrugkyyasu09;
    }

    private String zrnkaigomaehrjrugkydaka10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKAIGOMAEHRJRUGKYDAKA10)
    public String getZrnkaigomaehrjrugkydaka10() {
        return zrnkaigomaehrjrugkydaka10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkaigomaehrjrugkydaka10(String pZrnkaigomaehrjrugkydaka10) {
        zrnkaigomaehrjrugkydaka10 = pZrnkaigomaehrjrugkydaka10;
    }

    private String zrnkgmaehrjrugkykijyun10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYKIJYUN10)
    public String getZrnkgmaehrjrugkykijyun10() {
        return zrnkgmaehrjrugkykijyun10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkykijyun10(String pZrnkgmaehrjrugkykijyun10) {
        zrnkgmaehrjrugkykijyun10 = pZrnkgmaehrjrugkykijyun10;
    }

    private String zrnkgmaehrjrugkyyasu10;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKGMAEHRJRUGKYYASU10)
    public String getZrnkgmaehrjrugkyyasu10() {
        return zrnkgmaehrjrugkyyasu10;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnkgmaehrjrugkyyasu10(String pZrnkgmaehrjrugkyyasu10) {
        zrnkgmaehrjrugkyyasu10 = pZrnkgmaehrjrugkyyasu10;
    }

    private String zrnkzktourokuservicemsg1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKZKTOUROKUSERVICEMSG1)
    public String getZrnkzktourokuservicemsg1() {
        return zrnkzktourokuservicemsg1;
    }

    public void setZrnkzktourokuservicemsg1(String pZrnkzktourokuservicemsg1) {
        zrnkzktourokuservicemsg1 = pZrnkzktourokuservicemsg1;
    }

    private String zrnkzktourokuservicemsg2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKZKTOUROKUSERVICEMSG2)
    public String getZrnkzktourokuservicemsg2() {
        return zrnkzktourokuservicemsg2;
    }

    public void setZrnkzktourokuservicemsg2(String pZrnkzktourokuservicemsg2) {
        zrnkzktourokuservicemsg2 = pZrnkzktourokuservicemsg2;
    }

    private String zrnkzktourokuservicemsg3;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKZKTOUROKUSERVICEMSG3)
    public String getZrnkzktourokuservicemsg3() {
        return zrnkzktourokuservicemsg3;
    }

    public void setZrnkzktourokuservicemsg3(String pZrnkzktourokuservicemsg3) {
        zrnkzktourokuservicemsg3 = pZrnkzktourokuservicemsg3;
    }

    private String zrnkzktourokuservicemsg4;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKZKTOUROKUSERVICEMSG4)
    public String getZrnkzktourokuservicemsg4() {
        return zrnkzktourokuservicemsg4;
    }

    public void setZrnkzktourokuservicemsg4(String pZrnkzktourokuservicemsg4) {
        zrnkzktourokuservicemsg4 = pZrnkzktourokuservicemsg4;
    }

    private String zrnkzktourokuservicemsg5;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKZKTOUROKUSERVICEMSG5)
    public String getZrnkzktourokuservicemsg5() {
        return zrnkzktourokuservicemsg5;
    }

    public void setZrnkzktourokuservicemsg5(String pZrnkzktourokuservicemsg5) {
        zrnkzktourokuservicemsg5 = pZrnkzktourokuservicemsg5;
    }

    private String zrnkzktourokuservicemsg6;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKZKTOUROKUSERVICEMSG6)
    public String getZrnkzktourokuservicemsg6() {
        return zrnkzktourokuservicemsg6;
    }

    public void setZrnkzktourokuservicemsg6(String pZrnkzktourokuservicemsg6) {
        zrnkzktourokuservicemsg6 = pZrnkzktourokuservicemsg6;
    }

    private String zrnkzktourokuservicemsg7;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKZKTOUROKUSERVICEMSG7)
    public String getZrnkzktourokuservicemsg7() {
        return zrnkzktourokuservicemsg7;
    }

    public void setZrnkzktourokuservicemsg7(String pZrnkzktourokuservicemsg7) {
        zrnkzktourokuservicemsg7 = pZrnkzktourokuservicemsg7;
    }

    private String zrnkzktourokuservicemsg8;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKZKTOUROKUSERVICEMSG8)
    public String getZrnkzktourokuservicemsg8() {
        return zrnkzktourokuservicemsg8;
    }

    public void setZrnkzktourokuservicemsg8(String pZrnkzktourokuservicemsg8) {
        zrnkzktourokuservicemsg8 = pZrnkzktourokuservicemsg8;
    }

    private String zrntrkkzknm118;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKNM118)
    public String getZrntrkkzknm118() {
        return zrntrkkzknm118;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzknm118(String pZrntrkkzknm118) {
        zrntrkkzknm118 = pZrntrkkzknm118;
    }

    private String zrntrkkzksei1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKSEI1)
    public String getZrntrkkzksei1() {
        return zrntrkkzksei1;
    }

    public void setZrntrkkzksei1(String pZrntrkkzksei1) {
        zrntrkkzksei1 = pZrntrkkzksei1;
    }

    private String zrntrkkzkseiymd1zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKSEIYMD1ZENKAKU)
    public String getZrntrkkzkseiymd1zenkaku() {
        return zrntrkkzkseiymd1zenkaku;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkseiymd1zenkaku(String pZrntrkkzkseiymd1zenkaku) {
        zrntrkkzkseiymd1zenkaku = pZrntrkkzkseiymd1zenkaku;
    }

    private String zrntrkkzkyno1zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKYNO1ZENKAKU)
    public String getZrntrkkzkyno1zenkaku() {
        return zrntrkkzkyno1zenkaku;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkyno1zenkaku(String pZrntrkkzkyno1zenkaku) {
        zrntrkkzkyno1zenkaku = pZrntrkkzkyno1zenkaku;
    }

    private String zrntrkkzkadrkj1;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKADRKJ1)
    public String getZrntrkkzkadrkj1() {
        return zrntrkkzkadrkj1;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkadrkj1(String pZrntrkkzkadrkj1) {
        zrntrkkzkadrkj1 = pZrntrkkzkadrkj1;
    }

    private String zrntrkkzktelno1zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKTELNO1ZENKAKU)
    public String getZrntrkkzktelno1zenkaku() {
        return zrntrkkzktelno1zenkaku;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzktelno1zenkaku(String pZrntrkkzktelno1zenkaku) {
        zrntrkkzktelno1zenkaku = pZrntrkkzktelno1zenkaku;
    }

    private String zrntrkkzknm218;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKNM218)
    public String getZrntrkkzknm218() {
        return zrntrkkzknm218;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzknm218(String pZrntrkkzknm218) {
        zrntrkkzknm218 = pZrntrkkzknm218;
    }

    private String zrntrkkzksei2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKSEI2)
    public String getZrntrkkzksei2() {
        return zrntrkkzksei2;
    }

    public void setZrntrkkzksei2(String pZrntrkkzksei2) {
        zrntrkkzksei2 = pZrntrkkzksei2;
    }

    private String zrntrkkzkseiymd2zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKSEIYMD2ZENKAKU)
    public String getZrntrkkzkseiymd2zenkaku() {
        return zrntrkkzkseiymd2zenkaku;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkseiymd2zenkaku(String pZrntrkkzkseiymd2zenkaku) {
        zrntrkkzkseiymd2zenkaku = pZrntrkkzkseiymd2zenkaku;
    }

    private String zrntrkkzkyno2zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKYNO2ZENKAKU)
    public String getZrntrkkzkyno2zenkaku() {
        return zrntrkkzkyno2zenkaku;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkyno2zenkaku(String pZrntrkkzkyno2zenkaku) {
        zrntrkkzkyno2zenkaku = pZrntrkkzkyno2zenkaku;
    }

    private String zrntrkkzkadrkj2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKADRKJ2)
    public String getZrntrkkzkadrkj2() {
        return zrntrkkzkadrkj2;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzkadrkj2(String pZrntrkkzkadrkj2) {
        zrntrkkzkadrkj2 = pZrntrkkzkadrkj2;
    }

    private String zrntrkkzktelno2zenkaku;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNTRKKZKTELNO2ZENKAKU)
    public String getZrntrkkzktelno2zenkaku() {
        return zrntrkkzktelno2zenkaku;
    }

    @DataConvert("toMultiByte")
    public void setZrntrkkzktelno2zenkaku(String pZrntrkkzktelno2zenkaku) {
        zrntrkkzktelno2zenkaku = pZrntrkkzktelno2zenkaku;
    }

    private String zrnkykdairinm18;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNKYKDAIRINM18)
    public String getZrnkykdairinm18() {
        return zrnkykdairinm18;
    }

    @DataConvert("toMultiByte")
    public void setZrnkykdairinm18(String pZrnkykdairinm18) {
        zrnkykdairinm18 = pZrnkykdairinm18;
    }

    private String zrnhhkndairinm;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHHKNDAIRINM)
    public String getZrnhhkndairinm() {
        return zrnhhkndairinm;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhkndairinm(String pZrnhhkndairinm) {
        zrnhhkndairinm = pZrnhhkndairinm;
    }

    private String zrnyobiv100;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV100)
    public String getZrnyobiv100() {
        return zrnyobiv100;
    }

    public void setZrnyobiv100(String pZrnyobiv100) {
        zrnyobiv100 = pZrnyobiv100;
    }

    private String zrnhutanhiyustmmsgcdue01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMMSGCDUE01)
    public String getZrnhutanhiyustmmsgcdue01() {
        return zrnhutanhiyustmmsgcdue01;
    }

    public void setZrnhutanhiyustmmsgcdue01(String pZrnhutanhiyustmmsgcdue01) {
        zrnhutanhiyustmmsgcdue01 = pZrnhutanhiyustmmsgcdue01;
    }

    private String zrnhutanhiyustmmsgcdue02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMMSGCDUE02)
    public String getZrnhutanhiyustmmsgcdue02() {
        return zrnhutanhiyustmmsgcdue02;
    }

    public void setZrnhutanhiyustmmsgcdue02(String pZrnhutanhiyustmmsgcdue02) {
        zrnhutanhiyustmmsgcdue02 = pZrnhutanhiyustmmsgcdue02;
    }

    private String zrnhutanhiyustmmsgcdue03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMMSGCDUE03)
    public String getZrnhutanhiyustmmsgcdue03() {
        return zrnhutanhiyustmmsgcdue03;
    }

    public void setZrnhutanhiyustmmsgcdue03(String pZrnhutanhiyustmmsgcdue03) {
        zrnhutanhiyustmmsgcdue03 = pZrnhutanhiyustmmsgcdue03;
    }

    private String zrnhutanhiyustmmsgcdue04;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMMSGCDUE04)
    public String getZrnhutanhiyustmmsgcdue04() {
        return zrnhutanhiyustmmsgcdue04;
    }

    public void setZrnhutanhiyustmmsgcdue04(String pZrnhutanhiyustmmsgcdue04) {
        zrnhutanhiyustmmsgcdue04 = pZrnhutanhiyustmmsgcdue04;
    }

    private String zrnhutanhiyustmknsnhyuptn;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMKNSNHYUPTN)
    public String getZrnhutanhiyustmknsnhyuptn() {
        return zrnhutanhiyustmknsnhyuptn;
    }

    public void setZrnhutanhiyustmknsnhyuptn(String pZrnhutanhiyustmknsnhyuptn) {
        zrnhutanhiyustmknsnhyuptn = pZrnhutanhiyustmknsnhyuptn;
    }

    private String zrnhutanhiyustmmsgcdst01;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMMSGCDST01)
    public String getZrnhutanhiyustmmsgcdst01() {
        return zrnhutanhiyustmmsgcdst01;
    }

    public void setZrnhutanhiyustmmsgcdst01(String pZrnhutanhiyustmmsgcdst01) {
        zrnhutanhiyustmmsgcdst01 = pZrnhutanhiyustmmsgcdst01;
    }

    private String zrnhutanhiyustmmsgcdst02;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMMSGCDST02)
    public String getZrnhutanhiyustmmsgcdst02() {
        return zrnhutanhiyustmmsgcdst02;
    }

    public void setZrnhutanhiyustmmsgcdst02(String pZrnhutanhiyustmmsgcdst02) {
        zrnhutanhiyustmmsgcdst02 = pZrnhutanhiyustmmsgcdst02;
    }

    private String zrnhutanhiyustmmsgcdst03;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMMSGCDST03)
    public String getZrnhutanhiyustmmsgcdst03() {
        return zrnhutanhiyustmmsgcdst03;
    }

    public void setZrnhutanhiyustmmsgcdst03(String pZrnhutanhiyustmmsgcdst03) {
        zrnhutanhiyustmmsgcdst03 = pZrnhutanhiyustmmsgcdst03;
    }

    private String zrnhutanhiyustmytijihiritu;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMYTIJIHIRITU)
    public String getZrnhutanhiyustmytijihiritu() {
        return zrnhutanhiyustmytijihiritu;
    }

    @DataConvert("toMultiByte")
    public void setZrnhutanhiyustmytijihiritu(String pZrnhutanhiyustmytijihiritu) {
        zrnhutanhiyustmytijihiritu = pZrnhutanhiyustmytijihiritu;
    }

    private String zrnhutanhiyustmkyakkjrtmin;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMKYAKKJRTMIN)
    public String getZrnhutanhiyustmkyakkjrtmin() {
        return zrnhutanhiyustmkyakkjrtmin;
    }

    @DataConvert("toMultiByte")
    public void setZrnhutanhiyustmkyakkjrtmin(String pZrnhutanhiyustmkyakkjrtmin) {
        zrnhutanhiyustmkyakkjrtmin = pZrnhutanhiyustmkyakkjrtmin;
    }

    private String zrnhutanhiyustmkyakkjrtmax;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNHUTANHIYUSTMKYAKKJRTMAX)
    public String getZrnhutanhiyustmkyakkjrtmax() {
        return zrnhutanhiyustmkyakkjrtmax;
    }

    @DataConvert("toMultiByte")
    public void setZrnhutanhiyustmkyakkjrtmax(String pZrnhutanhiyustmkyakkjrtmax) {
        zrnhutanhiyustmkyakkjrtmax = pZrnhutanhiyustmkyakkjrtmax;
    }

    private String zrnyobiv7x2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV7X2)
    public String getZrnyobiv7x2() {
        return zrnyobiv7x2;
    }

    public void setZrnyobiv7x2(String pZrnyobiv7x2) {
        zrnyobiv7x2 = pZrnyobiv7x2;
    }

    private String zrnstdstmmsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSTDSTMMSGCD)
    public String getZrnstdstmmsgcd() {
        return zrnstdstmmsgcd;
    }

    public void setZrnstdstmmsgcd(String pZrnstdstmmsgcd) {
        zrnstdstmmsgcd = pZrnstdstmmsgcd;
    }

    private String zrnsioriwebuktriannaimsgcd;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNSIORIWEBUKTRIANNAIMSGCD)
    public String getZrnsioriwebuktriannaimsgcd() {
        return zrnsioriwebuktriannaimsgcd;
    }

    public void setZrnsioriwebuktriannaimsgcd(String pZrnsioriwebuktriannaimsgcd) {
        zrnsioriwebuktriannaimsgcd = pZrnsioriwebuktriannaimsgcd;
    }

    private String zrnyobiv10x2;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV10X2)
    public String getZrnyobiv10x2() {
        return zrnyobiv10x2;
    }

    public void setZrnyobiv10x2(String pZrnyobiv10x2) {
        zrnyobiv10x2 = pZrnyobiv10x2;
    }

    private String zrnyobiv69;

    @Column(name=GenZT_SaihakkouHokensyoukenRn.ZRNYOBIV69)
    public String getZrnyobiv69() {
        return zrnyobiv69;
    }

    public void setZrnyobiv69(String pZrnyobiv69) {
        zrnyobiv69 = pZrnyobiv69;
    }
}