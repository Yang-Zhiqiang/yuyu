package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.mapping.GenZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.meta.GenQZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.meta.QZT_KeizokurituRenrakuULFRn;

/**
 * 継続率連絡データＵＬＦテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KeizokurituRenrakuULFRn}</td><td colspan="3">継続率連絡データＵＬＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatukaikojincd</td><td>（連携用）扱者個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukgu</td><td>（連携用）種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntksyuannaikykkbn</td><td>（連携用）特殊案内契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukinkbn</td><td>（連携用）集金区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnanniskcd</td><td>（連携用）案内先コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuukintantousosikicd</td><td>（連携用）集金担当組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndnthrkkeirokbn</td><td>（連携用）団体払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhyuukousyoumetukbn</td><td>（連携用）（契約保全）有効消滅区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeikatukisuu</td><td>（連携用）経過月数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakukensuu</td><td>（連携用）契約件数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkihons</td><td>（連携用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyuuseis9keta</td><td>（連携用）修正Ｓ（９桁）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhsys</td><td>（連携用）保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnatukaisosikicd</td><td>（連携用）扱者組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknm</td><td>（連携用）契約者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkyknm</td><td>（連携用）漢字契約者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2keta</td><td>（連携用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmarutokuhyj</td><td>（連携用）マル特表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyohktyouseihyj</td><td>（連携用）重複調整表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngyoumujyouhyouji</td><td>（連携用）業務上表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkydatkihyj</td><td>（連携用）共同扱表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntenkankaisuu</td><td>（連携用）転換回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktatkibanhktgksnkbn</td><td>（連携用）継続手当用基盤引継加算区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjidoukousinhyouji</td><td>（連携用）自動更新表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeijimrtiarihyj</td><td>（連携用）新契約時マル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnskeijikzkmrtiarihyj</td><td>（連携用）新契約時家族マル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhukkatukeiiarihyj</td><td>（連携用）復活経緯有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyouhukutyouseiskeihyj</td><td>（連携用）重複調整新契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphkbnmnoshyouji</td><td>（連携用）Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigomarusyuuarihyj</td><td>（連携用）介護マル終有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnheiyoubaraikeiyakukbn</td><td>（連携用）併用払契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhngkjidouentyoukbn</td><td>（連携用）変額自動延長区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhngkjidouentyoukikan</td><td>（連携用）変額自動延長期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndoujihuhomrtisyukigou</td><td>（連携用）同時付保マル定種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv1</td><td>（連携用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseizonmrtiarihyj</td><td>（連携用）生存マル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteigenmrtiarihyj</td><td>（連携用）逓減マル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyunkensuu</td><td>（連携用）純件数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnaltourokukeiyakuhyj</td><td>（連携用）ＡＬ登録契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjikokykhyj</td><td>（連携用）自己契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsynymrtiarihyj</td><td>（連携用）収入マル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykniyutksytioukbn</td><td>（連携用）契約内容特殊対応区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnreguardmrtiarihyj</td><td>（連携用）リガードマル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnreguardmrsyuarihyj</td><td>（連携用）リガードマル終有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnvguardmrtiarihyj</td><td>（連携用）Ｖガードマル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkousintkykhyj</td><td>（連携用）更新特約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkousinkakuninnasihyj</td><td>（連携用）更新確認無表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfollowhunouhyj</td><td>（連携用）フォロー不能表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigosynymrtiarihyj</td><td>（連携用）介護収入マル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigoteigenmrtiarihyj</td><td>（連携用）介護逓減マル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsuperknkuseikatupackhyj</td><td>（連携用）スーパー健康生活パック表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigonktkykarihyj</td><td>（連携用）介護年金特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkaigomrtiarihyj</td><td>（連携用）介護マル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeiyakukbn</td><td>（連携用）契約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeizokutyuuihyouji</td><td>（連携用）継続注意表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkikeiyakutyuuihyouji</td><td>（連携用）既契約注意表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbosyuunincd</td><td>（連携用）募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhsyuikktminaosikaisu</td><td>（連携用）保障一括見直回数</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjiqpackhyj</td><td>（連携用）契約時Ｑパック表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbnkttnknkbn</td><td>（連携用）分割転換区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrtikousinkbn</td><td>（連携用）マル定更新区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpmenkbnv1</td><td>（連携用）Ｐ免区分Ｖ１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyouikunktkykarihyj</td><td>（連携用）養育年金特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoumetucd</td><td>（連携用）消滅コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseikatusyuunyuumrtis</td><td>（連携用）生活収入マル定Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhitenkansyono1</td><td>（連携用）被転換証券番号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhitenkansyono2</td><td>（連携用）被転換証券番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhitenkansyono3</td><td>（連携用）被転換証券番号３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhitenkansyono4</td><td>（連携用）被転換証券番号４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhitenkansyono5</td><td>（連携用）被転換証券番号５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhitenkansyono6</td><td>（連携用）被転換証券番号６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkansanp</td><td>（連携用）年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndai3bunyanenkansanp</td><td>（連携用）第３分野年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnkykym</td><td>（連携用）契約年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsytikbn</td><td>（連携用）集定区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfundbubunnenkansanp</td><td>（連携用）ファンド部分年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnjikaipjyuutouym</td><td>（連携用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktatsyuuseis</td><td>（連携用）継続手当用修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiktsynymrtiarihyj</td><td>（連携用）生活収入マル定有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlivguardarihyj</td><td>（連携用）ＬＩＶガード有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlivguards</td><td>（連携用）ＬＩＶガードＳ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnknkuzusnzyrttekitkarihyj</td><td>（連携用）健康増進乗率適用特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbluekzjtkaisiymd</td><td>（連携用）Ｂｌｕｅ継続状態開始年月日　</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknkuzusnzyrtstkbn</td><td>（連携用）健康増進乗率用ステータス区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokuyakuno</td><td>（連携用）特約番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnvityugusttkyuhyj</td><td>（連携用）Ｖｉｔ優遇措置適用表示　</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdrtkykarihyj</td><td>（連携用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdairiseikyuutkykarihyj</td><td>（連携用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktourokuservicearihyj</td><td>（連携用）家族登録サービス有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyendthnkymd8keta</td><td>（連携用）円建変更日（８桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv8</td><td>（連携用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkhsyoumetujiyuu</td><td>（連携用）（契約保全）消滅事由</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnitijibaraipkyktuuka</td><td>（連携用）一時払Ｐ（契約通貨建）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkawaseraten5</td><td>（連携用）為替レートＮ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnnnknsnpssysyup</td><td>（連携用）年換算Ｐ算出用主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnknsnpssyhrkkskbn</td><td>（連携用）年換算Ｐ算出用払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnnknsnpyennkgotmttrrt</td><td>（連携用）年換算Ｐ算出用円建年金変更後積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnnnknsnpyennkgonksjtmttkn</td><td>（連携用）年換算Ｐ算出用円建年金変更後年金開始時積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiteituukakbn</td><td>（連携用）指定通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyuruikigousedaikbn</td><td>（連携用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x1</td><td>（連携用）保険種類記号予備１＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x2</td><td>（連携用）保険種類記号予備１＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x3</td><td>（連携用）保険種類記号予備１＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x4</td><td>（連携用）保険種類記号予備１＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x5</td><td>（連携用）保険種類記号予備１＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x6</td><td>（連携用）保険種類記号予備１＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x7</td><td>（連携用）保険種類記号予備１＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x8</td><td>（連携用）保険種類記号予備１＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x9</td><td>（連携用）保険種類記号予備１＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x10</td><td>（連携用）保険種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x11</td><td>（連携用）保険種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x12</td><td>（連携用）保険種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x13</td><td>（連携用）保険種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x14</td><td>（連携用）保険種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi1x15</td><td>（連携用）保険種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x1</td><td>（連携用）保険種類記号予備２＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x2</td><td>（連携用）保険種類記号予備２＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x3</td><td>（連携用）保険種類記号予備２＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x4</td><td>（連携用）保険種類記号予備２＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x5</td><td>（連携用）保険種類記号予備２＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x6</td><td>（連携用）保険種類記号予備２＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x7</td><td>（連携用）保険種類記号予備２＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x8</td><td>（連携用）保険種類記号予備２＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x9</td><td>（連携用）保険種類記号予備２＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi2x10</td><td>（連携用）保険種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x1</td><td>（連携用）保険種類記号予備３＿１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x2</td><td>（連携用）保険種類記号予備３＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x3</td><td>（連携用）保険種類記号予備３＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x4</td><td>（連携用）保険種類記号予備３＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x5</td><td>（連携用）保険種類記号予備３＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x6</td><td>（連携用）保険種類記号予備３＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x7</td><td>（連携用）保険種類記号予備３＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x8</td><td>（連携用）保険種類記号予備３＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x9</td><td>（連携用）保険種類記号予備３＿９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhokensyuruikigouyobi3x10</td><td>（連携用）保険種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnryouritukbn</td><td>（連携用）料率区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv33</td><td>（連携用）予備項目Ｖ３３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KeizokurituRenrakuULFRn
 * @see     GenZT_KeizokurituRenrakuULFRn
 * @see     QZT_KeizokurituRenrakuULFRn
 * @see     GenQZT_KeizokurituRenrakuULFRn
 */
public class PKZT_KeizokurituRenrakuULFRn extends AbstractExDBPrimaryKey<ZT_KeizokurituRenrakuULFRn, PKZT_KeizokurituRenrakuULFRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KeizokurituRenrakuULFRn() {
    }

    public PKZT_KeizokurituRenrakuULFRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_KeizokurituRenrakuULFRn> getEntityClass() {
        return ZT_KeizokurituRenrakuULFRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}