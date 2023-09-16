package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.mapping.GenZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.meta.GenQZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.meta.QZT_KeizokurituRenrakuULFTy;

/**
 * 継続率連絡データＵＬＦテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KeizokurituRenrakuULFTy}</td><td colspan="3">継続率連絡データＵＬＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysyono</td><td>（中継用）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatukaikojincd</td><td>（中継用）扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukgu</td><td>（中継用）種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytksyuannaikykkbn</td><td>（中継用）特殊案内契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukinkbn</td><td>（中継用）集金区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyanniskcd</td><td>（中継用）案内先コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuukintantousosikicd</td><td>（中継用）集金担当組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydnthrkkeirokbn</td><td>（中継用）団体払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhyuukousyoumetukbn</td><td>（中継用）（契約保全）有効消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeikatukisuu</td><td>（中継用）経過月数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakukensuu</td><td>（中継用）契約件数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykihons</td><td>（中継用）基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyuuseis9keta</td><td>（中継用）修正Ｓ（９桁）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhsys</td><td>（中継用）保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyatukaisosikicd</td><td>（中継用）扱者組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknm</td><td>（中継用）契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkyknm</td><td>（中継用）漢字契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen2keta</td><td>（中継用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymarutokuhyj</td><td>（中継用）マル特表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyohktyouseihyj</td><td>（中継用）重複調整表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygyoumujyouhyouji</td><td>（中継用）業務上表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydatkihyj</td><td>（中継用）共同扱表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytenkankaisuu</td><td>（中継用）転換回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktatkibanhktgksnkbn</td><td>（中継用）継続手当用基盤引継加算区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjidoukousinhyouji</td><td>（中継用）自動更新表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeijimrtiarihyj</td><td>（中継用）新契約時マル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyskeijikzkmrtiarihyj</td><td>（中継用）新契約時家族マル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhukkatukeiiarihyj</td><td>（中継用）復活経緯有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouhukutyouseiskeihyj</td><td>（中継用）重複調整新契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphkbnmnoshyouji</td><td>（中継用）Ｐ不可分見直表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaigomarusyuuarihyj</td><td>（中継用）介護マル終有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyheiyoubaraikeiyakukbn</td><td>（中継用）併用払契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhngkjidouentyoukbn</td><td>（中継用）変額自動延長区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhngkjidouentyoukikan</td><td>（中継用）変額自動延長期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydoujihuhomrtisyukigou</td><td>（中継用）同時付保マル定種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv1</td><td>（中継用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseizonmrtiarihyj</td><td>（中継用）生存マル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteigenmrtiarihyj</td><td>（中継用）逓減マル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyunkensuu</td><td>（中継用）純件数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyaltourokukeiyakuhyj</td><td>（中継用）ＡＬ登録契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjikokykhyj</td><td>（中継用）自己契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysynymrtiarihyj</td><td>（中継用）収入マル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykniyutksytioukbn</td><td>（中継用）契約内容特殊対応区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyreguardmrtiarihyj</td><td>（中継用）リガードマル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyreguardmrsyuarihyj</td><td>（中継用）リガードマル終有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvguardmrtiarihyj</td><td>（中継用）Ｖガードマル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykousintkykhyj</td><td>（中継用）更新特約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykousinkakuninnasihyj</td><td>（中継用）更新確認無表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfollowhunouhyj</td><td>（中継用）フォロー不能表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaigosynymrtiarihyj</td><td>（中継用）介護収入マル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaigoteigenmrtiarihyj</td><td>（中継用）介護逓減マル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysuperknkuseikatupackhyj</td><td>（中継用）スーパー健康生活パック表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaigonktkykarihyj</td><td>（中継用）介護年金特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykaigomrtiarihyj</td><td>（中継用）介護マル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeiyakukbn</td><td>（中継用）契約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeizokutyuuihyouji</td><td>（中継用）継続注意表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykikeiyakutyuuihyouji</td><td>（中継用）既契約注意表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybosyuunincd</td><td>（中継用）募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhsyuikktminaosikaisu</td><td>（中継用）保障一括見直回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjiqpackhyj</td><td>（中継用）契約時Ｑパック表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybnkttnknkbn</td><td>（中継用）分割転換区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrtikousinkbn</td><td>（中継用）マル定更新区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmenkbnv1</td><td>（中継用）Ｐ免区分Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyouikunktkykarihyj</td><td>（中継用）養育年金特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoumetucd</td><td>（中継用）消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseikatusyuunyuumrtis</td><td>（中継用）生活収入マル定Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhitenkansyono1</td><td>（中継用）被転換証券番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhitenkansyono2</td><td>（中継用）被転換証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhitenkansyono3</td><td>（中継用）被転換証券番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhitenkansyono4</td><td>（中継用）被転換証券番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhitenkansyono5</td><td>（中継用）被転換証券番号５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhitenkansyono6</td><td>（中継用）被転換証券番号６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynenkansanp</td><td>（中継用）年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztydai3bunyanenkansanp</td><td>（中継用）第３分野年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztykykym</td><td>（中継用）契約年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysytikbn</td><td>（中継用）集定区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfundbubunnenkansanp</td><td>（中継用）ファンド部分年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyjikaipjyuutouym</td><td>（中継用）次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktatsyuuseis</td><td>（中継用）継続手当用修正Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiktsynymrtiarihyj</td><td>（中継用）生活収入マル定有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylivguardarihyj</td><td>（中継用）ＬＩＶガード有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylivguards</td><td>（中継用）ＬＩＶガードＳ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyknkuzusnzyrttekitkarihyj</td><td>（中継用）健康増進乗率適用特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybluekzjtkaisiymd</td><td>（中継用）Ｂｌｕｅ継続状態開始年月日　</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkuzusnzyrtstkbn</td><td>（中継用）健康増進乗率用ステータス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokuyakuno</td><td>（中継用）特約番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyvityugusttkyuhyj</td><td>（中継用）Ｖｉｔ優遇措置適用表示　</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrtkykarihyj</td><td>（中継用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdairiseikyuutkykarihyj</td><td>（中継用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktourokuservicearihyj</td><td>（中継用）家族登録サービス有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyendthnkymd8keta</td><td>（中継用）円建変更日（８桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv8</td><td>（中継用）予備項目Ｖ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykhsyoumetujiyuu</td><td>（中継用）（契約保全）消滅事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyitijibaraipkyktuuka</td><td>（中継用）一時払Ｐ（契約通貨建）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykawaseraten5</td><td>（中継用）為替レートＮ５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztynnknsnpssysyup</td><td>（中継用）年換算Ｐ算出用主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynknsnpssyhrkkskbn</td><td>（中継用）年換算Ｐ算出用払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynnknsnpyennkgotmttrrt</td><td>（中継用）年換算Ｐ算出用円建年金変更後積立利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztynnknsnpyennkgonksjtmttkn</td><td>（中継用）年換算Ｐ算出用円建年金変更後年金開始時積立金</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiteituukakbn</td><td>（中継用）指定通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyuruikigousedaikbn</td><td>（中継用）保険種類記号世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x1</td><td>（中継用）保険種類記号予備１＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x2</td><td>（中継用）保険種類記号予備１＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x3</td><td>（中継用）保険種類記号予備１＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x4</td><td>（中継用）保険種類記号予備１＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x5</td><td>（中継用）保険種類記号予備１＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x6</td><td>（中継用）保険種類記号予備１＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x7</td><td>（中継用）保険種類記号予備１＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x8</td><td>（中継用）保険種類記号予備１＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x9</td><td>（中継用）保険種類記号予備１＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x10</td><td>（中継用）保険種類記号予備１＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x11</td><td>（中継用）保険種類記号予備１＿１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x12</td><td>（中継用）保険種類記号予備１＿１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x13</td><td>（中継用）保険種類記号予備１＿１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x14</td><td>（中継用）保険種類記号予備１＿１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi1x15</td><td>（中継用）保険種類記号予備１＿１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x1</td><td>（中継用）保険種類記号予備２＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x2</td><td>（中継用）保険種類記号予備２＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x3</td><td>（中継用）保険種類記号予備２＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x4</td><td>（中継用）保険種類記号予備２＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x5</td><td>（中継用）保険種類記号予備２＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x6</td><td>（中継用）保険種類記号予備２＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x7</td><td>（中継用）保険種類記号予備２＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x8</td><td>（中継用）保険種類記号予備２＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x9</td><td>（中継用）保険種類記号予備２＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi2x10</td><td>（中継用）保険種類記号予備２＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x1</td><td>（中継用）保険種類記号予備３＿１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x2</td><td>（中継用）保険種類記号予備３＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x3</td><td>（中継用）保険種類記号予備３＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x4</td><td>（中継用）保険種類記号予備３＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x5</td><td>（中継用）保険種類記号予備３＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x6</td><td>（中継用）保険種類記号予備３＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x7</td><td>（中継用）保険種類記号予備３＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x8</td><td>（中継用）保険種類記号予備３＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x9</td><td>（中継用）保険種類記号予備３＿９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhokensyuruikigouyobi3x10</td><td>（中継用）保険種類記号予備３＿１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyryouritukbn</td><td>（中継用）料率区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv33</td><td>（中継用）予備項目Ｖ３３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KeizokurituRenrakuULFTy
 * @see     GenZT_KeizokurituRenrakuULFTy
 * @see     QZT_KeizokurituRenrakuULFTy
 * @see     GenQZT_KeizokurituRenrakuULFTy
 */
public class PKZT_KeizokurituRenrakuULFTy extends AbstractExDBPrimaryKey<ZT_KeizokurituRenrakuULFTy, PKZT_KeizokurituRenrakuULFTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KeizokurituRenrakuULFTy() {
    }

    public PKZT_KeizokurituRenrakuULFTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_KeizokurituRenrakuULFTy> getEntityClass() {
        return ZT_KeizokurituRenrakuULFTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}