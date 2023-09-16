package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.id.PKZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.meta.GenQZT_KeizokurituRenrakuULFRn;
import yuyu.def.db.meta.QZT_KeizokurituRenrakuULFRn;

/**
 * 継続率連絡データＵＬＦテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KeizokurituRenrakuULFRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KeizokurituRenrakuULFRn}</td><td colspan="3">継続率連絡データＵＬＦテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_KeizokurituRenrakuULFRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatukaikojincd zrnatukaikojincd}</td><td>（連携用）扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukgu zrnsyukgu}</td><td>（連携用）種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksyuannaikykkbn zrntksyuannaikykkbn}</td><td>（連携用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukinkbn zrnsyukinkbn}</td><td>（連携用）集金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnanniskcd zrnanniskcd}</td><td>（連携用）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuukintantousosikicd zrnsyuukintantousosikicd}</td><td>（連携用）集金担当組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndnthrkkeirokbn zrndnthrkkeirokbn}</td><td>（連携用）団体払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhyuukousyoumetukbn zrnkhyuukousyoumetukbn}</td><td>（連携用）（契約保全）有効消滅区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikatukisuu zrnkeikatukisuu}</td><td>（連携用）経過月数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakukensuu zrnkeiyakukensuu}</td><td>（連携用）契約件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkihons zrnkihons}</td><td>（連携用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyuuseis9keta zrnsyuuseis9keta}</td><td>（連携用）修正Ｓ（９桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhsys zrnhsys}</td><td>（連携用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnatukaisosikicd zrnatukaisosikicd}</td><td>（連携用）扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknm zrnkyknm}</td><td>（連携用）契約者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm zrnkjkyknm}</td><td>（連携用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2keta zrnhhknnen2keta}</td><td>（連携用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarutokuhyj zrnmarutokuhyj}</td><td>（連携用）マル特表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyohktyouseihyj zrntyohktyouseihyj}</td><td>（連携用）重複調整表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngyoumujyouhyouji zrngyoumujyouhyouji}</td><td>（連携用）業務上表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkihyj zrnkydatkihyj}</td><td>（連携用）共同扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkankaisuu zrntenkankaisuu}</td><td>（連携用）転換回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktatkibanhktgksnkbn zrnkzktatkibanhktgksnkbn}</td><td>（連携用）継続手当用基盤引継加算区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjidoukousinhyouji zrnjidoukousinhyouji}</td><td>（連携用）自動更新表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeijimrtiarihyj zrnskeijimrtiarihyj}</td><td>（連携用）新契約時マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnskeijikzkmrtiarihyj zrnskeijikzkmrtiarihyj}</td><td>（連携用）新契約時家族マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhukkatukeiiarihyj zrnhukkatukeiiarihyj}</td><td>（連携用）復活経緯有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhukutyouseiskeihyj zrntyouhukutyouseiskeihyj}</td><td>（連携用）重複調整新契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphkbnmnoshyouji zrnphkbnmnoshyouji}</td><td>（連携用）Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomarusyuuarihyj zrnkaigomarusyuuarihyj}</td><td>（連携用）介護マル終有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheiyoubaraikeiyakukbn zrnheiyoubaraikeiyakukbn}</td><td>（連携用）併用払契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhngkjidouentyoukbn zrnhngkjidouentyoukbn}</td><td>（連携用）変額自動延長区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhngkjidouentyoukikan zrnhngkjidouentyoukikan}</td><td>（連携用）変額自動延長期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndoujihuhomrtisyukigou zrndoujihuhomrtisyukigou}</td><td>（連携用）同時付保マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmrtiarihyj zrnseizonmrtiarihyj}</td><td>（連携用）生存マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmrtiarihyj zrnteigenmrtiarihyj}</td><td>（連携用）逓減マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyunkensuu zrnjyunkensuu}</td><td>（連携用）純件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnaltourokukeiyakuhyj zrnaltourokukeiyakuhyj}</td><td>（連携用）ＡＬ登録契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikokykhyj zrnjikokykhyj}</td><td>（連携用）自己契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsynymrtiarihyj zrnsynymrtiarihyj}</td><td>（連携用）収入マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykniyutksytioukbn zrnkykniyutksytioukbn}</td><td>（連携用）契約内容特殊対応区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnreguardmrtiarihyj zrnreguardmrtiarihyj}</td><td>（連携用）リガードマル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnreguardmrsyuarihyj zrnreguardmrsyuarihyj}</td><td>（連携用）リガードマル終有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvguardmrtiarihyj zrnvguardmrtiarihyj}</td><td>（連携用）Ｖガードマル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousintkykhyj zrnkousintkykhyj}</td><td>（連携用）更新特約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkousinkakuninnasihyj zrnkousinkakuninnasihyj}</td><td>（連携用）更新確認無表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfollowhunouhyj zrnfollowhunouhyj}</td><td>（連携用）フォロー不能表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigosynymrtiarihyj zrnkaigosynymrtiarihyj}</td><td>（連携用）介護収入マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigoteigenmrtiarihyj zrnkaigoteigenmrtiarihyj}</td><td>（連携用）介護逓減マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuperknkuseikatupackhyj zrnsuperknkuseikatupackhyj}</td><td>（連携用）スーパー健康生活パック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigonktkykarihyj zrnkaigonktkykarihyj}</td><td>（連携用）介護年金特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaigomrtiarihyj zrnkaigomrtiarihyj}</td><td>（連携用）介護マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakukbn zrnkeiyakukbn}</td><td>（連携用）契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeizokutyuuihyouji zrnkeizokutyuuihyouji}</td><td>（連携用）継続注意表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikeiyakutyuuihyouji zrnkikeiyakutyuuihyouji}</td><td>（連携用）既契約注意表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbosyuunincd zrnbosyuunincd}</td><td>（連携用）募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhsyuikktminaosikaisu zrnhsyuikktminaosikaisu}</td><td>（連携用）保障一括見直回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjiqpackhyj zrnkykjiqpackhyj}</td><td>（連携用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbnkttnknkbn zrnbnkttnknkbn}</td><td>（連携用）分割転換区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtikousinkbn zrnmrtikousinkbn}</td><td>（連携用）マル定更新区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmenkbnv1 zrnpmenkbnv1}</td><td>（連携用）Ｐ免区分Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyouikunktkykarihyj zrnyouikunktkykarihyj}</td><td>（連携用）養育年金特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumetucd zrnsyoumetucd}</td><td>（連携用）消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikatusyuunyuumrtis zrnseikatusyuunyuumrtis}</td><td>（連携用）生活収入マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhitenkansyono1 zrnhitenkansyono1}</td><td>（連携用）被転換証券番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhitenkansyono2 zrnhitenkansyono2}</td><td>（連携用）被転換証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhitenkansyono3 zrnhitenkansyono3}</td><td>（連携用）被転換証券番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhitenkansyono4 zrnhitenkansyono4}</td><td>（連携用）被転換証券番号４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhitenkansyono5 zrnhitenkansyono5}</td><td>（連携用）被転換証券番号５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhitenkansyono6 zrnhitenkansyono6}</td><td>（連携用）被転換証券番号６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkansanp zrnnenkansanp}</td><td>（連携用）年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai3bunyanenkansanp zrndai3bunyanenkansanp}</td><td>（連携用）第３分野年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkykym zrnkykym}</td><td>（連携用）契約年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsytikbn zrnsytikbn}</td><td>（連携用）集定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfundbubunnenkansanp zrnfundbubunnenkansanp}</td><td>（連携用）ファンド部分年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjikaipjyuutouym zrnjikaipjyuutouym}</td><td>（連携用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktatsyuuseis zrnkzktatsyuuseis}</td><td>（連携用）継続手当用修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiktsynymrtiarihyj zrnsiktsynymrtiarihyj}</td><td>（連携用）生活収入マル定有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivguardarihyj zrnlivguardarihyj}</td><td>（連携用）ＬＩＶガード有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlivguards zrnlivguards}</td><td>（連携用）ＬＩＶガードＳ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrttekitkarihyj zrnknkuzusnzyrttekitkarihyj}</td><td>（連携用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbluekzjtkaisiymd zrnbluekzjtkaisiymd}</td><td>（連携用）Ｂｌｕｅ継続状態開始年月日　</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrtstkbn zrnknkuzusnzyrtstkbn}</td><td>（連携用）健康増進乗率用ステータス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuyakuno zrntokuyakuno}</td><td>（連携用）特約番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvityugusttkyuhyj zrnvityugusttkyuhyj}</td><td>（連携用）Ｖｉｔ優遇措置適用表示　</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrtkykarihyj zrnkykdrtkykarihyj}</td><td>（連携用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdairiseikyuutkykarihyj zrnstdairiseikyuutkykarihyj}</td><td>（連携用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicearihyj zrnkzktourokuservicearihyj}</td><td>（連携用）家族登録サービス有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyendthnkymd8keta zrnyendthnkymd8keta}</td><td>（連携用）円建変更日（８桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkhsyoumetujiyuu zrnkhsyoumetujiyuu}</td><td>（連携用）（契約保全）消滅事由</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitijibaraipkyktuuka zrnitijibaraipkyktuuka}</td><td>（連携用）一時払Ｐ（契約通貨建）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseraten5 zrnkawaseraten5}</td><td>（連携用）為替レートＮ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssysyup zrnnnknsnpssysyup}</td><td>（連携用）年換算Ｐ算出用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnknsnpssyhrkkskbn zrnnknsnpssyhrkkskbn}</td><td>（連携用）年換算Ｐ算出用払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpyennkgotmttrrt zrnnnknsnpyennkgotmttrrt}</td><td>（連携用）年換算Ｐ算出用円建年金変更後積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpyennkgonksjtmttkn zrnnnknsnpyennkgonksjtmttkn}</td><td>（連携用）年換算Ｐ算出用円建年金変更後年金開始時積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteituukakbn zrnsiteituukakbn}</td><td>（連携用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x1 zrnhokensyuruikigouyobi1x1}</td><td>（連携用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x2 zrnhokensyuruikigouyobi1x2}</td><td>（連携用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x3 zrnhokensyuruikigouyobi1x3}</td><td>（連携用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x4 zrnhokensyuruikigouyobi1x4}</td><td>（連携用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x5 zrnhokensyuruikigouyobi1x5}</td><td>（連携用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x6 zrnhokensyuruikigouyobi1x6}</td><td>（連携用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x7 zrnhokensyuruikigouyobi1x7}</td><td>（連携用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x8 zrnhokensyuruikigouyobi1x8}</td><td>（連携用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x9 zrnhokensyuruikigouyobi1x9}</td><td>（連携用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x10 zrnhokensyuruikigouyobi1x10}</td><td>（連携用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x11 zrnhokensyuruikigouyobi1x11}</td><td>（連携用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x12 zrnhokensyuruikigouyobi1x12}</td><td>（連携用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x13 zrnhokensyuruikigouyobi1x13}</td><td>（連携用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x14 zrnhokensyuruikigouyobi1x14}</td><td>（連携用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi1x15 zrnhokensyuruikigouyobi1x15}</td><td>（連携用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x1 zrnhokensyuruikigouyobi2x1}</td><td>（連携用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x2 zrnhokensyuruikigouyobi2x2}</td><td>（連携用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x3 zrnhokensyuruikigouyobi2x3}</td><td>（連携用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x4 zrnhokensyuruikigouyobi2x4}</td><td>（連携用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x5 zrnhokensyuruikigouyobi2x5}</td><td>（連携用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x6 zrnhokensyuruikigouyobi2x6}</td><td>（連携用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x7 zrnhokensyuruikigouyobi2x7}</td><td>（連携用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x8 zrnhokensyuruikigouyobi2x8}</td><td>（連携用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x9 zrnhokensyuruikigouyobi2x9}</td><td>（連携用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi2x10 zrnhokensyuruikigouyobi2x10}</td><td>（連携用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x1 zrnhokensyuruikigouyobi3x1}</td><td>（連携用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x2 zrnhokensyuruikigouyobi3x2}</td><td>（連携用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x3 zrnhokensyuruikigouyobi3x3}</td><td>（連携用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x4 zrnhokensyuruikigouyobi3x4}</td><td>（連携用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x5 zrnhokensyuruikigouyobi3x5}</td><td>（連携用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x6 zrnhokensyuruikigouyobi3x6}</td><td>（連携用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x7 zrnhokensyuruikigouyobi3x7}</td><td>（連携用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x8 zrnhokensyuruikigouyobi3x8}</td><td>（連携用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x9 zrnhokensyuruikigouyobi3x9}</td><td>（連携用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhokensyuruikigouyobi3x10 zrnhokensyuruikigouyobi3x10}</td><td>（連携用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryouritukbn zrnryouritukbn}</td><td>（連携用）料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv33 zrnyobiv33}</td><td>（連携用）予備項目Ｖ３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KeizokurituRenrakuULFRn
 * @see     PKZT_KeizokurituRenrakuULFRn
 * @see     QZT_KeizokurituRenrakuULFRn
 * @see     GenQZT_KeizokurituRenrakuULFRn
 */
@MappedSuperclass
@Table(name=GenZT_KeizokurituRenrakuULFRn.TABLE_NAME)
@IdClass(value=PKZT_KeizokurituRenrakuULFRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KeizokurituRenrakuULFRn extends AbstractExDBEntityForZDB<ZT_KeizokurituRenrakuULFRn, PKZT_KeizokurituRenrakuULFRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KeizokurituRenrakuULFRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNATUKAIKOJINCD         = "zrnatukaikojincd";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNSYUKGU                = "zrnsyukgu";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNTKSYUANNAIKYKKBN      = "zrntksyuannaikykkbn";
    public static final String ZRNSYUKINKBN             = "zrnsyukinkbn";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNANNISKCD              = "zrnanniskcd";
    public static final String ZRNSYUUKINTANTOUSOSIKICD = "zrnsyuukintantousosikicd";
    public static final String ZRNDNTHRKKEIROKBN        = "zrndnthrkkeirokbn";
    public static final String ZRNKHYUUKOUSYOUMETUKBN   = "zrnkhyuukousyoumetukbn";
    public static final String ZRNKEIKATUKISUU          = "zrnkeikatukisuu";
    public static final String ZRNKEIYAKUKENSUU         = "zrnkeiyakukensuu";
    public static final String ZRNKIHONS                = "zrnkihons";
    public static final String ZRNSYUUSEIS9KETA         = "zrnsyuuseis9keta";
    public static final String ZRNHSYS                  = "zrnhsys";
    public static final String ZRNATUKAISOSIKICD        = "zrnatukaisosikicd";
    public static final String ZRNKYKNM                 = "zrnkyknm";
    public static final String ZRNKJKYKNM               = "zrnkjkyknm";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHHKNNEN2KETA          = "zrnhhknnen2keta";
    public static final String ZRNMARUTOKUHYJ           = "zrnmarutokuhyj";
    public static final String ZRNTYOHKTYOUSEIHYJ       = "zrntyohktyouseihyj";
    public static final String ZRNGYOUMUJYOUHYOUJI      = "zrngyoumujyouhyouji";
    public static final String ZRNKYDATKIHYJ            = "zrnkydatkihyj";
    public static final String ZRNTENKANKAISUU          = "zrntenkankaisuu";
    public static final String ZRNKZKTATKIBANHKTGKSNKBN = "zrnkzktatkibanhktgksnkbn";
    public static final String ZRNJIDOUKOUSINHYOUJI     = "zrnjidoukousinhyouji";
    public static final String ZRNSKEIJIMRTIARIHYJ      = "zrnskeijimrtiarihyj";
    public static final String ZRNSKEIJIKZKMRTIARIHYJ   = "zrnskeijikzkmrtiarihyj";
    public static final String ZRNHUKKATUKEIIARIHYJ     = "zrnhukkatukeiiarihyj";
    public static final String ZRNTYOUHUKUTYOUSEISKEIHYJ = "zrntyouhukutyouseiskeihyj";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNPHKBNMNOSHYOUJI       = "zrnphkbnmnoshyouji";
    public static final String ZRNKAIGOMARUSYUUARIHYJ   = "zrnkaigomarusyuuarihyj";
    public static final String ZRNHEIYOUBARAIKEIYAKUKBN = "zrnheiyoubaraikeiyakukbn";
    public static final String ZRNHNGKJIDOUENTYOUKBN    = "zrnhngkjidouentyoukbn";
    public static final String ZRNHNGKJIDOUENTYOUKIKAN  = "zrnhngkjidouentyoukikan";
    public static final String ZRNDOUJIHUHOMRTISYUKIGOU = "zrndoujihuhomrtisyukigou";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNSEIZONMRTIARIHYJ      = "zrnseizonmrtiarihyj";
    public static final String ZRNTEIGENMRTIARIHYJ      = "zrnteigenmrtiarihyj";
    public static final String ZRNJYUNKENSUU            = "zrnjyunkensuu";
    public static final String ZRNALTOUROKUKEIYAKUHYJ   = "zrnaltourokukeiyakuhyj";
    public static final String ZRNJIKOKYKHYJ            = "zrnjikokykhyj";
    public static final String ZRNSYNYMRTIARIHYJ        = "zrnsynymrtiarihyj";
    public static final String ZRNKYKNIYUTKSYTIOUKBN    = "zrnkykniyutksytioukbn";
    public static final String ZRNREGUARDMRTIARIHYJ     = "zrnreguardmrtiarihyj";
    public static final String ZRNREGUARDMRSYUARIHYJ    = "zrnreguardmrsyuarihyj";
    public static final String ZRNVGUARDMRTIARIHYJ      = "zrnvguardmrtiarihyj";
    public static final String ZRNKOUSINTKYKHYJ         = "zrnkousintkykhyj";
    public static final String ZRNKOUSINKAKUNINNASIHYJ  = "zrnkousinkakuninnasihyj";
    public static final String ZRNFOLLOWHUNOUHYJ        = "zrnfollowhunouhyj";
    public static final String ZRNKAIGOSYNYMRTIARIHYJ   = "zrnkaigosynymrtiarihyj";
    public static final String ZRNKAIGOTEIGENMRTIARIHYJ = "zrnkaigoteigenmrtiarihyj";
    public static final String ZRNSUPERKNKUSEIKATUPACKHYJ = "zrnsuperknkuseikatupackhyj";
    public static final String ZRNKAIGONKTKYKARIHYJ     = "zrnkaigonktkykarihyj";
    public static final String ZRNKAIGOMRTIARIHYJ       = "zrnkaigomrtiarihyj";
    public static final String ZRNKEIYAKUKBN            = "zrnkeiyakukbn";
    public static final String ZRNKEIZOKUTYUUIHYOUJI    = "zrnkeizokutyuuihyouji";
    public static final String ZRNKIKEIYAKUTYUUIHYOUJI  = "zrnkikeiyakutyuuihyouji";
    public static final String ZRNBOSYUUNINCD           = "zrnbosyuunincd";
    public static final String ZRNHSYUIKKTMINAOSIKAISU  = "zrnhsyuikktminaosikaisu";
    public static final String ZRNKYKJIQPACKHYJ         = "zrnkykjiqpackhyj";
    public static final String ZRNBNKTTNKNKBN           = "zrnbnkttnknkbn";
    public static final String ZRNMRTIKOUSINKBN         = "zrnmrtikousinkbn";
    public static final String ZRNPMENKBNV1             = "zrnpmenkbnv1";
    public static final String ZRNYOUIKUNKTKYKARIHYJ    = "zrnyouikunktkykarihyj";
    public static final String ZRNSYOUMETUCD            = "zrnsyoumetucd";
    public static final String ZRNSEIKATUSYUUNYUUMRTIS  = "zrnseikatusyuunyuumrtis";
    public static final String ZRNHITENKANSYONO1        = "zrnhitenkansyono1";
    public static final String ZRNHITENKANSYONO2        = "zrnhitenkansyono2";
    public static final String ZRNHITENKANSYONO3        = "zrnhitenkansyono3";
    public static final String ZRNHITENKANSYONO4        = "zrnhitenkansyono4";
    public static final String ZRNHITENKANSYONO5        = "zrnhitenkansyono5";
    public static final String ZRNHITENKANSYONO6        = "zrnhitenkansyono6";
    public static final String ZRNNENKANSANP            = "zrnnenkansanp";
    public static final String ZRNDAI3BUNYANENKANSANP   = "zrndai3bunyanenkansanp";
    public static final String ZRNKYKYM                 = "zrnkykym";
    public static final String ZRNSYTIKBN               = "zrnsytikbn";
    public static final String ZRNFUNDBUBUNNENKANSANP   = "zrnfundbubunnenkansanp";
    public static final String ZRNJIKAIPJYUUTOUYM       = "zrnjikaipjyuutouym";
    public static final String ZRNKZKTATSYUUSEIS        = "zrnkzktatsyuuseis";
    public static final String ZRNSIKTSYNYMRTIARIHYJ    = "zrnsiktsynymrtiarihyj";
    public static final String ZRNLIVGUARDARIHYJ        = "zrnlivguardarihyj";
    public static final String ZRNLIVGUARDS             = "zrnlivguards";
    public static final String ZRNKNKUZUSNZYRTTEKITKARIHYJ = "zrnknkuzusnzyrttekitkarihyj";
    public static final String ZRNBLUEKZJTKAISIYMD      = "zrnbluekzjtkaisiymd";
    public static final String ZRNKNKUZUSNZYRTSTKBN     = "zrnknkuzusnzyrtstkbn";
    public static final String ZRNTOKUYAKUNO            = "zrntokuyakuno";
    public static final String ZRNVITYUGUSTTKYUHYJ      = "zrnvityugusttkyuhyj";
    public static final String ZRNKYKDRTKYKARIHYJ       = "zrnkykdrtkykarihyj";
    public static final String ZRNSTDAIRISEIKYUUTKYKARIHYJ = "zrnstdairiseikyuutkykarihyj";
    public static final String ZRNKZKTOUROKUSERVICEARIHYJ = "zrnkzktourokuservicearihyj";
    public static final String ZRNYENDTHNKYMD8KETA      = "zrnyendthnkymd8keta";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNKHSYOUMETUJIYUU       = "zrnkhsyoumetujiyuu";
    public static final String ZRNITIJIBARAIPKYKTUUKA   = "zrnitijibaraipkyktuuka";
    public static final String ZRNKAWASERATEN5          = "zrnkawaseraten5";
    public static final String ZRNNNKNSNPSSYSYUP        = "zrnnnknsnpssysyup";
    public static final String ZRNNKNSNPSSYHRKKSKBN     = "zrnnknsnpssyhrkkskbn";
    public static final String ZRNNNKNSNPYENNKGOTMTTRRT = "zrnnnknsnpyennkgotmttrrt";
    public static final String ZRNNNKNSNPYENNKGONKSJTMTTKN = "zrnnnknsnpyennkgonksjtmttkn";
    public static final String ZRNSITEITUUKAKBN         = "zrnsiteituukakbn";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X1 = "zrnhokensyuruikigouyobi1x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X2 = "zrnhokensyuruikigouyobi1x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X3 = "zrnhokensyuruikigouyobi1x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X4 = "zrnhokensyuruikigouyobi1x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X5 = "zrnhokensyuruikigouyobi1x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X6 = "zrnhokensyuruikigouyobi1x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X7 = "zrnhokensyuruikigouyobi1x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X8 = "zrnhokensyuruikigouyobi1x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X9 = "zrnhokensyuruikigouyobi1x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X10 = "zrnhokensyuruikigouyobi1x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X11 = "zrnhokensyuruikigouyobi1x11";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X12 = "zrnhokensyuruikigouyobi1x12";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X13 = "zrnhokensyuruikigouyobi1x13";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X14 = "zrnhokensyuruikigouyobi1x14";
    public static final String ZRNHOKENSYURUIKIGOUYOBI1X15 = "zrnhokensyuruikigouyobi1x15";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X1 = "zrnhokensyuruikigouyobi2x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X2 = "zrnhokensyuruikigouyobi2x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X3 = "zrnhokensyuruikigouyobi2x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X4 = "zrnhokensyuruikigouyobi2x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X5 = "zrnhokensyuruikigouyobi2x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X6 = "zrnhokensyuruikigouyobi2x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X7 = "zrnhokensyuruikigouyobi2x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X8 = "zrnhokensyuruikigouyobi2x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X9 = "zrnhokensyuruikigouyobi2x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI2X10 = "zrnhokensyuruikigouyobi2x10";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X1 = "zrnhokensyuruikigouyobi3x1";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X2 = "zrnhokensyuruikigouyobi3x2";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X3 = "zrnhokensyuruikigouyobi3x3";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X4 = "zrnhokensyuruikigouyobi3x4";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X5 = "zrnhokensyuruikigouyobi3x5";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X6 = "zrnhokensyuruikigouyobi3x6";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X7 = "zrnhokensyuruikigouyobi3x7";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X8 = "zrnhokensyuruikigouyobi3x8";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X9 = "zrnhokensyuruikigouyobi3x9";
    public static final String ZRNHOKENSYURUIKIGOUYOBI3X10 = "zrnhokensyuruikigouyobi3x10";
    public static final String ZRNRYOURITUKBN           = "zrnryouritukbn";
    public static final String ZRNYOBIV33               = "zrnyobiv33";

    private final PKZT_KeizokurituRenrakuULFRn primaryKey;

    public GenZT_KeizokurituRenrakuULFRn() {
        primaryKey = new PKZT_KeizokurituRenrakuULFRn();
    }

    public GenZT_KeizokurituRenrakuULFRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_KeizokurituRenrakuULFRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_KeizokurituRenrakuULFRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KeizokurituRenrakuULFRn> getMetaClass() {
        return QZT_KeizokurituRenrakuULFRn.class;
    }

    @Id
    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnsyono;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnatukaikojincd;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNATUKAIKOJINCD)
    public String getZrnatukaikojincd() {
        return zrnatukaikojincd;
    }

    public void setZrnatukaikojincd(String pZrnatukaikojincd) {
        zrnatukaikojincd = pZrnatukaikojincd;
    }

    private String zrnbsyym;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnsyukgu;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSYUKGU)
    public String getZrnsyukgu() {
        return zrnsyukgu;
    }

    public void setZrnsyukgu(String pZrnsyukgu) {
        zrnsyukgu = pZrnsyukgu;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrntksyuannaikykkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNTKSYUANNAIKYKKBN)
    public String getZrntksyuannaikykkbn() {
        return zrntksyuannaikykkbn;
    }

    public void setZrntksyuannaikykkbn(String pZrntksyuannaikykkbn) {
        zrntksyuannaikykkbn = pZrntksyuannaikykkbn;
    }

    private String zrnsyukinkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSYUKINKBN)
    public String getZrnsyukinkbn() {
        return zrnsyukinkbn;
    }

    public void setZrnsyukinkbn(String pZrnsyukinkbn) {
        zrnsyukinkbn = pZrnsyukinkbn;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnanniskcd;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNANNISKCD)
    public String getZrnanniskcd() {
        return zrnanniskcd;
    }

    public void setZrnanniskcd(String pZrnanniskcd) {
        zrnanniskcd = pZrnanniskcd;
    }

    private String zrnsyuukintantousosikicd;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSYUUKINTANTOUSOSIKICD)
    public String getZrnsyuukintantousosikicd() {
        return zrnsyuukintantousosikicd;
    }

    public void setZrnsyuukintantousosikicd(String pZrnsyuukintantousosikicd) {
        zrnsyuukintantousosikicd = pZrnsyuukintantousosikicd;
    }

    private String zrndnthrkkeirokbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNDNTHRKKEIROKBN)
    public String getZrndnthrkkeirokbn() {
        return zrndnthrkkeirokbn;
    }

    public void setZrndnthrkkeirokbn(String pZrndnthrkkeirokbn) {
        zrndnthrkkeirokbn = pZrndnthrkkeirokbn;
    }

    private String zrnkhyuukousyoumetukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKHYUUKOUSYOUMETUKBN)
    public String getZrnkhyuukousyoumetukbn() {
        return zrnkhyuukousyoumetukbn;
    }

    public void setZrnkhyuukousyoumetukbn(String pZrnkhyuukousyoumetukbn) {
        zrnkhyuukousyoumetukbn = pZrnkhyuukousyoumetukbn;
    }

    private String zrnkeikatukisuu;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKEIKATUKISUU)
    public String getZrnkeikatukisuu() {
        return zrnkeikatukisuu;
    }

    public void setZrnkeikatukisuu(String pZrnkeikatukisuu) {
        zrnkeikatukisuu = pZrnkeikatukisuu;
    }

    private BizNumber zrnkeiyakukensuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKEIYAKUKENSUU)
    public BizNumber getZrnkeiyakukensuu() {
        return zrnkeiyakukensuu;
    }

    public void setZrnkeiyakukensuu(BizNumber pZrnkeiyakukensuu) {
        zrnkeiyakukensuu = pZrnkeiyakukensuu;
    }

    private Long zrnkihons;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKIHONS)
    public Long getZrnkihons() {
        return zrnkihons;
    }

    public void setZrnkihons(Long pZrnkihons) {
        zrnkihons = pZrnkihons;
    }

    private Long zrnsyuuseis9keta;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSYUUSEIS9KETA)
    public Long getZrnsyuuseis9keta() {
        return zrnsyuuseis9keta;
    }

    public void setZrnsyuuseis9keta(Long pZrnsyuuseis9keta) {
        zrnsyuuseis9keta = pZrnsyuuseis9keta;
    }

    private Long zrnhsys;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHSYS)
    public Long getZrnhsys() {
        return zrnhsys;
    }

    public void setZrnhsys(Long pZrnhsys) {
        zrnhsys = pZrnhsys;
    }

    private String zrnatukaisosikicd;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNATUKAISOSIKICD)
    public String getZrnatukaisosikicd() {
        return zrnatukaisosikicd;
    }

    public void setZrnatukaisosikicd(String pZrnatukaisosikicd) {
        zrnatukaisosikicd = pZrnatukaisosikicd;
    }

    private String zrnkyknm;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKYKNM)
    public String getZrnkyknm() {
        return zrnkyknm;
    }

    public void setZrnkyknm(String pZrnkyknm) {
        zrnkyknm = pZrnkyknm;
    }

    private String zrnkjkyknm;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKJKYKNM)
    public String getZrnkjkyknm() {
        return zrnkjkyknm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm(String pZrnkjkyknm) {
        zrnkjkyknm = pZrnkjkyknm;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhhknnen2keta;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHHKNNEN2KETA)
    public String getZrnhhknnen2keta() {
        return zrnhhknnen2keta;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2keta(String pZrnhhknnen2keta) {
        zrnhhknnen2keta = pZrnhhknnen2keta;
    }

    private String zrnmarutokuhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNMARUTOKUHYJ)
    public String getZrnmarutokuhyj() {
        return zrnmarutokuhyj;
    }

    public void setZrnmarutokuhyj(String pZrnmarutokuhyj) {
        zrnmarutokuhyj = pZrnmarutokuhyj;
    }

    private String zrntyohktyouseihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNTYOHKTYOUSEIHYJ)
    public String getZrntyohktyouseihyj() {
        return zrntyohktyouseihyj;
    }

    public void setZrntyohktyouseihyj(String pZrntyohktyouseihyj) {
        zrntyohktyouseihyj = pZrntyohktyouseihyj;
    }

    private String zrngyoumujyouhyouji;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNGYOUMUJYOUHYOUJI)
    public String getZrngyoumujyouhyouji() {
        return zrngyoumujyouhyouji;
    }

    public void setZrngyoumujyouhyouji(String pZrngyoumujyouhyouji) {
        zrngyoumujyouhyouji = pZrngyoumujyouhyouji;
    }

    private String zrnkydatkihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKYDATKIHYJ)
    public String getZrnkydatkihyj() {
        return zrnkydatkihyj;
    }

    public void setZrnkydatkihyj(String pZrnkydatkihyj) {
        zrnkydatkihyj = pZrnkydatkihyj;
    }

    private String zrntenkankaisuu;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNTENKANKAISUU)
    public String getZrntenkankaisuu() {
        return zrntenkankaisuu;
    }

    public void setZrntenkankaisuu(String pZrntenkankaisuu) {
        zrntenkankaisuu = pZrntenkankaisuu;
    }

    private String zrnkzktatkibanhktgksnkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKZKTATKIBANHKTGKSNKBN)
    public String getZrnkzktatkibanhktgksnkbn() {
        return zrnkzktatkibanhktgksnkbn;
    }

    public void setZrnkzktatkibanhktgksnkbn(String pZrnkzktatkibanhktgksnkbn) {
        zrnkzktatkibanhktgksnkbn = pZrnkzktatkibanhktgksnkbn;
    }

    private String zrnjidoukousinhyouji;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNJIDOUKOUSINHYOUJI)
    public String getZrnjidoukousinhyouji() {
        return zrnjidoukousinhyouji;
    }

    public void setZrnjidoukousinhyouji(String pZrnjidoukousinhyouji) {
        zrnjidoukousinhyouji = pZrnjidoukousinhyouji;
    }

    private String zrnskeijimrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSKEIJIMRTIARIHYJ)
    public String getZrnskeijimrtiarihyj() {
        return zrnskeijimrtiarihyj;
    }

    public void setZrnskeijimrtiarihyj(String pZrnskeijimrtiarihyj) {
        zrnskeijimrtiarihyj = pZrnskeijimrtiarihyj;
    }

    private String zrnskeijikzkmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSKEIJIKZKMRTIARIHYJ)
    public String getZrnskeijikzkmrtiarihyj() {
        return zrnskeijikzkmrtiarihyj;
    }

    public void setZrnskeijikzkmrtiarihyj(String pZrnskeijikzkmrtiarihyj) {
        zrnskeijikzkmrtiarihyj = pZrnskeijikzkmrtiarihyj;
    }

    private String zrnhukkatukeiiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHUKKATUKEIIARIHYJ)
    public String getZrnhukkatukeiiarihyj() {
        return zrnhukkatukeiiarihyj;
    }

    public void setZrnhukkatukeiiarihyj(String pZrnhukkatukeiiarihyj) {
        zrnhukkatukeiiarihyj = pZrnhukkatukeiiarihyj;
    }

    private String zrntyouhukutyouseiskeihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNTYOUHUKUTYOUSEISKEIHYJ)
    public String getZrntyouhukutyouseiskeihyj() {
        return zrntyouhukutyouseiskeihyj;
    }

    public void setZrntyouhukutyouseiskeihyj(String pZrntyouhukutyouseiskeihyj) {
        zrntyouhukutyouseiskeihyj = pZrntyouhukutyouseiskeihyj;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnphkbnmnoshyouji;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNPHKBNMNOSHYOUJI)
    public String getZrnphkbnmnoshyouji() {
        return zrnphkbnmnoshyouji;
    }

    public void setZrnphkbnmnoshyouji(String pZrnphkbnmnoshyouji) {
        zrnphkbnmnoshyouji = pZrnphkbnmnoshyouji;
    }

    private String zrnkaigomarusyuuarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKAIGOMARUSYUUARIHYJ)
    public String getZrnkaigomarusyuuarihyj() {
        return zrnkaigomarusyuuarihyj;
    }

    public void setZrnkaigomarusyuuarihyj(String pZrnkaigomarusyuuarihyj) {
        zrnkaigomarusyuuarihyj = pZrnkaigomarusyuuarihyj;
    }

    private String zrnheiyoubaraikeiyakukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHEIYOUBARAIKEIYAKUKBN)
    public String getZrnheiyoubaraikeiyakukbn() {
        return zrnheiyoubaraikeiyakukbn;
    }

    public void setZrnheiyoubaraikeiyakukbn(String pZrnheiyoubaraikeiyakukbn) {
        zrnheiyoubaraikeiyakukbn = pZrnheiyoubaraikeiyakukbn;
    }

    private String zrnhngkjidouentyoukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHNGKJIDOUENTYOUKBN)
    public String getZrnhngkjidouentyoukbn() {
        return zrnhngkjidouentyoukbn;
    }

    public void setZrnhngkjidouentyoukbn(String pZrnhngkjidouentyoukbn) {
        zrnhngkjidouentyoukbn = pZrnhngkjidouentyoukbn;
    }

    private String zrnhngkjidouentyoukikan;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHNGKJIDOUENTYOUKIKAN)
    public String getZrnhngkjidouentyoukikan() {
        return zrnhngkjidouentyoukikan;
    }

    public void setZrnhngkjidouentyoukikan(String pZrnhngkjidouentyoukikan) {
        zrnhngkjidouentyoukikan = pZrnhngkjidouentyoukikan;
    }

    private String zrndoujihuhomrtisyukigou;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNDOUJIHUHOMRTISYUKIGOU)
    public String getZrndoujihuhomrtisyukigou() {
        return zrndoujihuhomrtisyukigou;
    }

    public void setZrndoujihuhomrtisyukigou(String pZrndoujihuhomrtisyukigou) {
        zrndoujihuhomrtisyukigou = pZrndoujihuhomrtisyukigou;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrnseizonmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSEIZONMRTIARIHYJ)
    public String getZrnseizonmrtiarihyj() {
        return zrnseizonmrtiarihyj;
    }

    public void setZrnseizonmrtiarihyj(String pZrnseizonmrtiarihyj) {
        zrnseizonmrtiarihyj = pZrnseizonmrtiarihyj;
    }

    private String zrnteigenmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNTEIGENMRTIARIHYJ)
    public String getZrnteigenmrtiarihyj() {
        return zrnteigenmrtiarihyj;
    }

    public void setZrnteigenmrtiarihyj(String pZrnteigenmrtiarihyj) {
        zrnteigenmrtiarihyj = pZrnteigenmrtiarihyj;
    }

    private BizNumber zrnjyunkensuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNJYUNKENSUU)
    public BizNumber getZrnjyunkensuu() {
        return zrnjyunkensuu;
    }

    public void setZrnjyunkensuu(BizNumber pZrnjyunkensuu) {
        zrnjyunkensuu = pZrnjyunkensuu;
    }

    private String zrnaltourokukeiyakuhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNALTOUROKUKEIYAKUHYJ)
    public String getZrnaltourokukeiyakuhyj() {
        return zrnaltourokukeiyakuhyj;
    }

    public void setZrnaltourokukeiyakuhyj(String pZrnaltourokukeiyakuhyj) {
        zrnaltourokukeiyakuhyj = pZrnaltourokukeiyakuhyj;
    }

    private String zrnjikokykhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNJIKOKYKHYJ)
    public String getZrnjikokykhyj() {
        return zrnjikokykhyj;
    }

    public void setZrnjikokykhyj(String pZrnjikokykhyj) {
        zrnjikokykhyj = pZrnjikokykhyj;
    }

    private String zrnsynymrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSYNYMRTIARIHYJ)
    public String getZrnsynymrtiarihyj() {
        return zrnsynymrtiarihyj;
    }

    public void setZrnsynymrtiarihyj(String pZrnsynymrtiarihyj) {
        zrnsynymrtiarihyj = pZrnsynymrtiarihyj;
    }

    private String zrnkykniyutksytioukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKYKNIYUTKSYTIOUKBN)
    public String getZrnkykniyutksytioukbn() {
        return zrnkykniyutksytioukbn;
    }

    public void setZrnkykniyutksytioukbn(String pZrnkykniyutksytioukbn) {
        zrnkykniyutksytioukbn = pZrnkykniyutksytioukbn;
    }

    private String zrnreguardmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNREGUARDMRTIARIHYJ)
    public String getZrnreguardmrtiarihyj() {
        return zrnreguardmrtiarihyj;
    }

    public void setZrnreguardmrtiarihyj(String pZrnreguardmrtiarihyj) {
        zrnreguardmrtiarihyj = pZrnreguardmrtiarihyj;
    }

    private String zrnreguardmrsyuarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNREGUARDMRSYUARIHYJ)
    public String getZrnreguardmrsyuarihyj() {
        return zrnreguardmrsyuarihyj;
    }

    public void setZrnreguardmrsyuarihyj(String pZrnreguardmrsyuarihyj) {
        zrnreguardmrsyuarihyj = pZrnreguardmrsyuarihyj;
    }

    private String zrnvguardmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNVGUARDMRTIARIHYJ)
    public String getZrnvguardmrtiarihyj() {
        return zrnvguardmrtiarihyj;
    }

    public void setZrnvguardmrtiarihyj(String pZrnvguardmrtiarihyj) {
        zrnvguardmrtiarihyj = pZrnvguardmrtiarihyj;
    }

    private String zrnkousintkykhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKOUSINTKYKHYJ)
    public String getZrnkousintkykhyj() {
        return zrnkousintkykhyj;
    }

    public void setZrnkousintkykhyj(String pZrnkousintkykhyj) {
        zrnkousintkykhyj = pZrnkousintkykhyj;
    }

    private String zrnkousinkakuninnasihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKOUSINKAKUNINNASIHYJ)
    public String getZrnkousinkakuninnasihyj() {
        return zrnkousinkakuninnasihyj;
    }

    public void setZrnkousinkakuninnasihyj(String pZrnkousinkakuninnasihyj) {
        zrnkousinkakuninnasihyj = pZrnkousinkakuninnasihyj;
    }

    private String zrnfollowhunouhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNFOLLOWHUNOUHYJ)
    public String getZrnfollowhunouhyj() {
        return zrnfollowhunouhyj;
    }

    public void setZrnfollowhunouhyj(String pZrnfollowhunouhyj) {
        zrnfollowhunouhyj = pZrnfollowhunouhyj;
    }

    private String zrnkaigosynymrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKAIGOSYNYMRTIARIHYJ)
    public String getZrnkaigosynymrtiarihyj() {
        return zrnkaigosynymrtiarihyj;
    }

    public void setZrnkaigosynymrtiarihyj(String pZrnkaigosynymrtiarihyj) {
        zrnkaigosynymrtiarihyj = pZrnkaigosynymrtiarihyj;
    }

    private String zrnkaigoteigenmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKAIGOTEIGENMRTIARIHYJ)
    public String getZrnkaigoteigenmrtiarihyj() {
        return zrnkaigoteigenmrtiarihyj;
    }

    public void setZrnkaigoteigenmrtiarihyj(String pZrnkaigoteigenmrtiarihyj) {
        zrnkaigoteigenmrtiarihyj = pZrnkaigoteigenmrtiarihyj;
    }

    private String zrnsuperknkuseikatupackhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSUPERKNKUSEIKATUPACKHYJ)
    public String getZrnsuperknkuseikatupackhyj() {
        return zrnsuperknkuseikatupackhyj;
    }

    public void setZrnsuperknkuseikatupackhyj(String pZrnsuperknkuseikatupackhyj) {
        zrnsuperknkuseikatupackhyj = pZrnsuperknkuseikatupackhyj;
    }

    private String zrnkaigonktkykarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKAIGONKTKYKARIHYJ)
    public String getZrnkaigonktkykarihyj() {
        return zrnkaigonktkykarihyj;
    }

    public void setZrnkaigonktkykarihyj(String pZrnkaigonktkykarihyj) {
        zrnkaigonktkykarihyj = pZrnkaigonktkykarihyj;
    }

    private String zrnkaigomrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKAIGOMRTIARIHYJ)
    public String getZrnkaigomrtiarihyj() {
        return zrnkaigomrtiarihyj;
    }

    public void setZrnkaigomrtiarihyj(String pZrnkaigomrtiarihyj) {
        zrnkaigomrtiarihyj = pZrnkaigomrtiarihyj;
    }

    private String zrnkeiyakukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKEIYAKUKBN)
    public String getZrnkeiyakukbn() {
        return zrnkeiyakukbn;
    }

    public void setZrnkeiyakukbn(String pZrnkeiyakukbn) {
        zrnkeiyakukbn = pZrnkeiyakukbn;
    }

    private String zrnkeizokutyuuihyouji;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKEIZOKUTYUUIHYOUJI)
    public String getZrnkeizokutyuuihyouji() {
        return zrnkeizokutyuuihyouji;
    }

    public void setZrnkeizokutyuuihyouji(String pZrnkeizokutyuuihyouji) {
        zrnkeizokutyuuihyouji = pZrnkeizokutyuuihyouji;
    }

    private String zrnkikeiyakutyuuihyouji;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKIKEIYAKUTYUUIHYOUJI)
    public String getZrnkikeiyakutyuuihyouji() {
        return zrnkikeiyakutyuuihyouji;
    }

    public void setZrnkikeiyakutyuuihyouji(String pZrnkikeiyakutyuuihyouji) {
        zrnkikeiyakutyuuihyouji = pZrnkikeiyakutyuuihyouji;
    }

    private String zrnbosyuunincd;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNBOSYUUNINCD)
    public String getZrnbosyuunincd() {
        return zrnbosyuunincd;
    }

    public void setZrnbosyuunincd(String pZrnbosyuunincd) {
        zrnbosyuunincd = pZrnbosyuunincd;
    }

    private String zrnhsyuikktminaosikaisu;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHSYUIKKTMINAOSIKAISU)
    public String getZrnhsyuikktminaosikaisu() {
        return zrnhsyuikktminaosikaisu;
    }

    public void setZrnhsyuikktminaosikaisu(String pZrnhsyuikktminaosikaisu) {
        zrnhsyuikktminaosikaisu = pZrnhsyuikktminaosikaisu;
    }

    private String zrnkykjiqpackhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKYKJIQPACKHYJ)
    public String getZrnkykjiqpackhyj() {
        return zrnkykjiqpackhyj;
    }

    public void setZrnkykjiqpackhyj(String pZrnkykjiqpackhyj) {
        zrnkykjiqpackhyj = pZrnkykjiqpackhyj;
    }

    private String zrnbnkttnknkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNBNKTTNKNKBN)
    public String getZrnbnkttnknkbn() {
        return zrnbnkttnknkbn;
    }

    public void setZrnbnkttnknkbn(String pZrnbnkttnknkbn) {
        zrnbnkttnknkbn = pZrnbnkttnknkbn;
    }

    private String zrnmrtikousinkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNMRTIKOUSINKBN)
    public String getZrnmrtikousinkbn() {
        return zrnmrtikousinkbn;
    }

    public void setZrnmrtikousinkbn(String pZrnmrtikousinkbn) {
        zrnmrtikousinkbn = pZrnmrtikousinkbn;
    }

    private String zrnpmenkbnv1;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNPMENKBNV1)
    public String getZrnpmenkbnv1() {
        return zrnpmenkbnv1;
    }

    public void setZrnpmenkbnv1(String pZrnpmenkbnv1) {
        zrnpmenkbnv1 = pZrnpmenkbnv1;
    }

    private String zrnyouikunktkykarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNYOUIKUNKTKYKARIHYJ)
    public String getZrnyouikunktkykarihyj() {
        return zrnyouikunktkykarihyj;
    }

    public void setZrnyouikunktkykarihyj(String pZrnyouikunktkykarihyj) {
        zrnyouikunktkykarihyj = pZrnyouikunktkykarihyj;
    }

    private String zrnsyoumetucd;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSYOUMETUCD)
    public String getZrnsyoumetucd() {
        return zrnsyoumetucd;
    }

    public void setZrnsyoumetucd(String pZrnsyoumetucd) {
        zrnsyoumetucd = pZrnsyoumetucd;
    }

    private Long zrnseikatusyuunyuumrtis;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSEIKATUSYUUNYUUMRTIS)
    public Long getZrnseikatusyuunyuumrtis() {
        return zrnseikatusyuunyuumrtis;
    }

    public void setZrnseikatusyuunyuumrtis(Long pZrnseikatusyuunyuumrtis) {
        zrnseikatusyuunyuumrtis = pZrnseikatusyuunyuumrtis;
    }

    private String zrnhitenkansyono1;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHITENKANSYONO1)
    public String getZrnhitenkansyono1() {
        return zrnhitenkansyono1;
    }

    public void setZrnhitenkansyono1(String pZrnhitenkansyono1) {
        zrnhitenkansyono1 = pZrnhitenkansyono1;
    }

    private String zrnhitenkansyono2;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHITENKANSYONO2)
    public String getZrnhitenkansyono2() {
        return zrnhitenkansyono2;
    }

    public void setZrnhitenkansyono2(String pZrnhitenkansyono2) {
        zrnhitenkansyono2 = pZrnhitenkansyono2;
    }

    private String zrnhitenkansyono3;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHITENKANSYONO3)
    public String getZrnhitenkansyono3() {
        return zrnhitenkansyono3;
    }

    public void setZrnhitenkansyono3(String pZrnhitenkansyono3) {
        zrnhitenkansyono3 = pZrnhitenkansyono3;
    }

    private String zrnhitenkansyono4;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHITENKANSYONO4)
    public String getZrnhitenkansyono4() {
        return zrnhitenkansyono4;
    }

    public void setZrnhitenkansyono4(String pZrnhitenkansyono4) {
        zrnhitenkansyono4 = pZrnhitenkansyono4;
    }

    private String zrnhitenkansyono5;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHITENKANSYONO5)
    public String getZrnhitenkansyono5() {
        return zrnhitenkansyono5;
    }

    public void setZrnhitenkansyono5(String pZrnhitenkansyono5) {
        zrnhitenkansyono5 = pZrnhitenkansyono5;
    }

    private String zrnhitenkansyono6;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHITENKANSYONO6)
    public String getZrnhitenkansyono6() {
        return zrnhitenkansyono6;
    }

    public void setZrnhitenkansyono6(String pZrnhitenkansyono6) {
        zrnhitenkansyono6 = pZrnhitenkansyono6;
    }

    private Long zrnnenkansanp;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNNENKANSANP)
    public Long getZrnnenkansanp() {
        return zrnnenkansanp;
    }

    public void setZrnnenkansanp(Long pZrnnenkansanp) {
        zrnnenkansanp = pZrnnenkansanp;
    }

    private Long zrndai3bunyanenkansanp;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNDAI3BUNYANENKANSANP)
    public Long getZrndai3bunyanenkansanp() {
        return zrndai3bunyanenkansanp;
    }

    public void setZrndai3bunyanenkansanp(Long pZrndai3bunyanenkansanp) {
        zrndai3bunyanenkansanp = pZrndai3bunyanenkansanp;
    }

    private String zrnkykym;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKYKYM)
    public String getZrnkykym() {
        return zrnkykym;
    }

    public void setZrnkykym(String pZrnkykym) {
        zrnkykym = pZrnkykym;
    }

    private String zrnsytikbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSYTIKBN)
    public String getZrnsytikbn() {
        return zrnsytikbn;
    }

    public void setZrnsytikbn(String pZrnsytikbn) {
        zrnsytikbn = pZrnsytikbn;
    }

    private Long zrnfundbubunnenkansanp;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNFUNDBUBUNNENKANSANP)
    public Long getZrnfundbubunnenkansanp() {
        return zrnfundbubunnenkansanp;
    }

    public void setZrnfundbubunnenkansanp(Long pZrnfundbubunnenkansanp) {
        zrnfundbubunnenkansanp = pZrnfundbubunnenkansanp;
    }

    private String zrnjikaipjyuutouym;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNJIKAIPJYUUTOUYM)
    public String getZrnjikaipjyuutouym() {
        return zrnjikaipjyuutouym;
    }

    public void setZrnjikaipjyuutouym(String pZrnjikaipjyuutouym) {
        zrnjikaipjyuutouym = pZrnjikaipjyuutouym;
    }

    private Long zrnkzktatsyuuseis;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKZKTATSYUUSEIS)
    public Long getZrnkzktatsyuuseis() {
        return zrnkzktatsyuuseis;
    }

    public void setZrnkzktatsyuuseis(Long pZrnkzktatsyuuseis) {
        zrnkzktatsyuuseis = pZrnkzktatsyuuseis;
    }

    private String zrnsiktsynymrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSIKTSYNYMRTIARIHYJ)
    public String getZrnsiktsynymrtiarihyj() {
        return zrnsiktsynymrtiarihyj;
    }

    public void setZrnsiktsynymrtiarihyj(String pZrnsiktsynymrtiarihyj) {
        zrnsiktsynymrtiarihyj = pZrnsiktsynymrtiarihyj;
    }

    private String zrnlivguardarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNLIVGUARDARIHYJ)
    public String getZrnlivguardarihyj() {
        return zrnlivguardarihyj;
    }

    public void setZrnlivguardarihyj(String pZrnlivguardarihyj) {
        zrnlivguardarihyj = pZrnlivguardarihyj;
    }

    private Long zrnlivguards;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNLIVGUARDS)
    public Long getZrnlivguards() {
        return zrnlivguards;
    }

    public void setZrnlivguards(Long pZrnlivguards) {
        zrnlivguards = pZrnlivguards;
    }

    private String zrnknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZrnknkuzusnzyrttekitkarihyj() {
        return zrnknkuzusnzyrttekitkarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnknkuzusnzyrttekitkarihyj(String pZrnknkuzusnzyrttekitkarihyj) {
        zrnknkuzusnzyrttekitkarihyj = pZrnknkuzusnzyrttekitkarihyj;
    }

    private String zrnbluekzjtkaisiymd;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNBLUEKZJTKAISIYMD)
    public String getZrnbluekzjtkaisiymd() {
        return zrnbluekzjtkaisiymd;
    }

    public void setZrnbluekzjtkaisiymd(String pZrnbluekzjtkaisiymd) {
        zrnbluekzjtkaisiymd = pZrnbluekzjtkaisiymd;
    }

    private String zrnknkuzusnzyrtstkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKNKUZUSNZYRTSTKBN)
    public String getZrnknkuzusnzyrtstkbn() {
        return zrnknkuzusnzyrtstkbn;
    }

    public void setZrnknkuzusnzyrtstkbn(String pZrnknkuzusnzyrtstkbn) {
        zrnknkuzusnzyrtstkbn = pZrnknkuzusnzyrtstkbn;
    }

    private String zrntokuyakuno;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNTOKUYAKUNO)
    public String getZrntokuyakuno() {
        return zrntokuyakuno;
    }

    public void setZrntokuyakuno(String pZrntokuyakuno) {
        zrntokuyakuno = pZrntokuyakuno;
    }

    private String zrnvityugusttkyuhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNVITYUGUSTTKYUHYJ)
    public String getZrnvityugusttkyuhyj() {
        return zrnvityugusttkyuhyj;
    }

    public void setZrnvityugusttkyuhyj(String pZrnvityugusttkyuhyj) {
        zrnvityugusttkyuhyj = pZrnvityugusttkyuhyj;
    }

    private String zrnkykdrtkykarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKYKDRTKYKARIHYJ)
    public String getZrnkykdrtkykarihyj() {
        return zrnkykdrtkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykdrtkykarihyj(String pZrnkykdrtkykarihyj) {
        zrnkykdrtkykarihyj = pZrnkykdrtkykarihyj;
    }

    private String zrnstdairiseikyuutkykarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZrnstdairiseikyuutkykarihyj() {
        return zrnstdairiseikyuutkykarihyj;
    }

    public void setZrnstdairiseikyuutkykarihyj(String pZrnstdairiseikyuutkykarihyj) {
        zrnstdairiseikyuutkykarihyj = pZrnstdairiseikyuutkykarihyj;
    }

    private String zrnkzktourokuservicearihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKZKTOUROKUSERVICEARIHYJ)
    public String getZrnkzktourokuservicearihyj() {
        return zrnkzktourokuservicearihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzktourokuservicearihyj(String pZrnkzktourokuservicearihyj) {
        zrnkzktourokuservicearihyj = pZrnkzktourokuservicearihyj;
    }

    private String zrnyendthnkymd8keta;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNYENDTHNKYMD8KETA)
    public String getZrnyendthnkymd8keta() {
        return zrnyendthnkymd8keta;
    }

    public void setZrnyendthnkymd8keta(String pZrnyendthnkymd8keta) {
        zrnyendthnkymd8keta = pZrnyendthnkymd8keta;
    }

    private String zrnkykymd;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrnkhsyoumetujiyuu;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKHSYOUMETUJIYUU)
    public String getZrnkhsyoumetujiyuu() {
        return zrnkhsyoumetujiyuu;
    }

    public void setZrnkhsyoumetujiyuu(String pZrnkhsyoumetujiyuu) {
        zrnkhsyoumetujiyuu = pZrnkhsyoumetujiyuu;
    }

    private BizNumber zrnitijibaraipkyktuuka;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNITIJIBARAIPKYKTUUKA)
    public BizNumber getZrnitijibaraipkyktuuka() {
        return zrnitijibaraipkyktuuka;
    }

    public void setZrnitijibaraipkyktuuka(BizNumber pZrnitijibaraipkyktuuka) {
        zrnitijibaraipkyktuuka = pZrnitijibaraipkyktuuka;
    }

    private BizNumber zrnkawaseraten5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNKAWASERATEN5)
    public BizNumber getZrnkawaseraten5() {
        return zrnkawaseraten5;
    }

    public void setZrnkawaseraten5(BizNumber pZrnkawaseraten5) {
        zrnkawaseraten5 = pZrnkawaseraten5;
    }

    private Long zrnnnknsnpssysyup;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNNNKNSNPSSYSYUP)
    public Long getZrnnnknsnpssysyup() {
        return zrnnnknsnpssysyup;
    }

    public void setZrnnnknsnpssysyup(Long pZrnnnknsnpssysyup) {
        zrnnnknsnpssysyup = pZrnnnknsnpssysyup;
    }

    private String zrnnknsnpssyhrkkskbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNNKNSNPSSYHRKKSKBN)
    public String getZrnnknsnpssyhrkkskbn() {
        return zrnnknsnpssyhrkkskbn;
    }

    public void setZrnnknsnpssyhrkkskbn(String pZrnnknsnpssyhrkkskbn) {
        zrnnknsnpssyhrkkskbn = pZrnnknsnpssyhrkkskbn;
    }

    private BizNumber zrnnnknsnpyennkgotmttrrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNNNKNSNPYENNKGOTMTTRRT)
    public BizNumber getZrnnnknsnpyennkgotmttrrt() {
        return zrnnnknsnpyennkgotmttrrt;
    }

    public void setZrnnnknsnpyennkgotmttrrt(BizNumber pZrnnnknsnpyennkgotmttrrt) {
        zrnnnknsnpyennkgotmttrrt = pZrnnnknsnpyennkgotmttrrt;
    }

    private Long zrnnnknsnpyennkgonksjtmttkn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNNNKNSNPYENNKGONKSJTMTTKN)
    public Long getZrnnnknsnpyennkgonksjtmttkn() {
        return zrnnnknsnpyennkgonksjtmttkn;
    }

    public void setZrnnnknsnpyennkgonksjtmttkn(Long pZrnnnknsnpyennkgonksjtmttkn) {
        zrnnnknsnpyennkgonksjtmttkn = pZrnnnknsnpyennkgonksjtmttkn;
    }

    private String zrnsiteituukakbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNSITEITUUKAKBN)
    public String getZrnsiteituukakbn() {
        return zrnsiteituukakbn;
    }

    public void setZrnsiteituukakbn(String pZrnsiteituukakbn) {
        zrnsiteituukakbn = pZrnsiteituukakbn;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnhokensyuruikigouyobi1x1;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X1)
    public String getZrnhokensyuruikigouyobi1x1() {
        return zrnhokensyuruikigouyobi1x1;
    }

    public void setZrnhokensyuruikigouyobi1x1(String pZrnhokensyuruikigouyobi1x1) {
        zrnhokensyuruikigouyobi1x1 = pZrnhokensyuruikigouyobi1x1;
    }

    private String zrnhokensyuruikigouyobi1x2;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X2)
    public String getZrnhokensyuruikigouyobi1x2() {
        return zrnhokensyuruikigouyobi1x2;
    }

    public void setZrnhokensyuruikigouyobi1x2(String pZrnhokensyuruikigouyobi1x2) {
        zrnhokensyuruikigouyobi1x2 = pZrnhokensyuruikigouyobi1x2;
    }

    private String zrnhokensyuruikigouyobi1x3;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X3)
    public String getZrnhokensyuruikigouyobi1x3() {
        return zrnhokensyuruikigouyobi1x3;
    }

    public void setZrnhokensyuruikigouyobi1x3(String pZrnhokensyuruikigouyobi1x3) {
        zrnhokensyuruikigouyobi1x3 = pZrnhokensyuruikigouyobi1x3;
    }

    private String zrnhokensyuruikigouyobi1x4;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X4)
    public String getZrnhokensyuruikigouyobi1x4() {
        return zrnhokensyuruikigouyobi1x4;
    }

    public void setZrnhokensyuruikigouyobi1x4(String pZrnhokensyuruikigouyobi1x4) {
        zrnhokensyuruikigouyobi1x4 = pZrnhokensyuruikigouyobi1x4;
    }

    private String zrnhokensyuruikigouyobi1x5;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X5)
    public String getZrnhokensyuruikigouyobi1x5() {
        return zrnhokensyuruikigouyobi1x5;
    }

    public void setZrnhokensyuruikigouyobi1x5(String pZrnhokensyuruikigouyobi1x5) {
        zrnhokensyuruikigouyobi1x5 = pZrnhokensyuruikigouyobi1x5;
    }

    private String zrnhokensyuruikigouyobi1x6;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X6)
    public String getZrnhokensyuruikigouyobi1x6() {
        return zrnhokensyuruikigouyobi1x6;
    }

    public void setZrnhokensyuruikigouyobi1x6(String pZrnhokensyuruikigouyobi1x6) {
        zrnhokensyuruikigouyobi1x6 = pZrnhokensyuruikigouyobi1x6;
    }

    private String zrnhokensyuruikigouyobi1x7;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X7)
    public String getZrnhokensyuruikigouyobi1x7() {
        return zrnhokensyuruikigouyobi1x7;
    }

    public void setZrnhokensyuruikigouyobi1x7(String pZrnhokensyuruikigouyobi1x7) {
        zrnhokensyuruikigouyobi1x7 = pZrnhokensyuruikigouyobi1x7;
    }

    private String zrnhokensyuruikigouyobi1x8;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X8)
    public String getZrnhokensyuruikigouyobi1x8() {
        return zrnhokensyuruikigouyobi1x8;
    }

    public void setZrnhokensyuruikigouyobi1x8(String pZrnhokensyuruikigouyobi1x8) {
        zrnhokensyuruikigouyobi1x8 = pZrnhokensyuruikigouyobi1x8;
    }

    private String zrnhokensyuruikigouyobi1x9;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X9)
    public String getZrnhokensyuruikigouyobi1x9() {
        return zrnhokensyuruikigouyobi1x9;
    }

    public void setZrnhokensyuruikigouyobi1x9(String pZrnhokensyuruikigouyobi1x9) {
        zrnhokensyuruikigouyobi1x9 = pZrnhokensyuruikigouyobi1x9;
    }

    private String zrnhokensyuruikigouyobi1x10;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X10)
    public String getZrnhokensyuruikigouyobi1x10() {
        return zrnhokensyuruikigouyobi1x10;
    }

    public void setZrnhokensyuruikigouyobi1x10(String pZrnhokensyuruikigouyobi1x10) {
        zrnhokensyuruikigouyobi1x10 = pZrnhokensyuruikigouyobi1x10;
    }

    private String zrnhokensyuruikigouyobi1x11;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X11)
    public String getZrnhokensyuruikigouyobi1x11() {
        return zrnhokensyuruikigouyobi1x11;
    }

    public void setZrnhokensyuruikigouyobi1x11(String pZrnhokensyuruikigouyobi1x11) {
        zrnhokensyuruikigouyobi1x11 = pZrnhokensyuruikigouyobi1x11;
    }

    private String zrnhokensyuruikigouyobi1x12;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X12)
    public String getZrnhokensyuruikigouyobi1x12() {
        return zrnhokensyuruikigouyobi1x12;
    }

    public void setZrnhokensyuruikigouyobi1x12(String pZrnhokensyuruikigouyobi1x12) {
        zrnhokensyuruikigouyobi1x12 = pZrnhokensyuruikigouyobi1x12;
    }

    private String zrnhokensyuruikigouyobi1x13;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X13)
    public String getZrnhokensyuruikigouyobi1x13() {
        return zrnhokensyuruikigouyobi1x13;
    }

    public void setZrnhokensyuruikigouyobi1x13(String pZrnhokensyuruikigouyobi1x13) {
        zrnhokensyuruikigouyobi1x13 = pZrnhokensyuruikigouyobi1x13;
    }

    private String zrnhokensyuruikigouyobi1x14;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X14)
    public String getZrnhokensyuruikigouyobi1x14() {
        return zrnhokensyuruikigouyobi1x14;
    }

    public void setZrnhokensyuruikigouyobi1x14(String pZrnhokensyuruikigouyobi1x14) {
        zrnhokensyuruikigouyobi1x14 = pZrnhokensyuruikigouyobi1x14;
    }

    private String zrnhokensyuruikigouyobi1x15;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI1X15)
    public String getZrnhokensyuruikigouyobi1x15() {
        return zrnhokensyuruikigouyobi1x15;
    }

    public void setZrnhokensyuruikigouyobi1x15(String pZrnhokensyuruikigouyobi1x15) {
        zrnhokensyuruikigouyobi1x15 = pZrnhokensyuruikigouyobi1x15;
    }

    private String zrnhokensyuruikigouyobi2x1;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI2X1)
    public String getZrnhokensyuruikigouyobi2x1() {
        return zrnhokensyuruikigouyobi2x1;
    }

    public void setZrnhokensyuruikigouyobi2x1(String pZrnhokensyuruikigouyobi2x1) {
        zrnhokensyuruikigouyobi2x1 = pZrnhokensyuruikigouyobi2x1;
    }

    private String zrnhokensyuruikigouyobi2x2;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI2X2)
    public String getZrnhokensyuruikigouyobi2x2() {
        return zrnhokensyuruikigouyobi2x2;
    }

    public void setZrnhokensyuruikigouyobi2x2(String pZrnhokensyuruikigouyobi2x2) {
        zrnhokensyuruikigouyobi2x2 = pZrnhokensyuruikigouyobi2x2;
    }

    private String zrnhokensyuruikigouyobi2x3;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI2X3)
    public String getZrnhokensyuruikigouyobi2x3() {
        return zrnhokensyuruikigouyobi2x3;
    }

    public void setZrnhokensyuruikigouyobi2x3(String pZrnhokensyuruikigouyobi2x3) {
        zrnhokensyuruikigouyobi2x3 = pZrnhokensyuruikigouyobi2x3;
    }

    private String zrnhokensyuruikigouyobi2x4;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI2X4)
    public String getZrnhokensyuruikigouyobi2x4() {
        return zrnhokensyuruikigouyobi2x4;
    }

    public void setZrnhokensyuruikigouyobi2x4(String pZrnhokensyuruikigouyobi2x4) {
        zrnhokensyuruikigouyobi2x4 = pZrnhokensyuruikigouyobi2x4;
    }

    private String zrnhokensyuruikigouyobi2x5;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI2X5)
    public String getZrnhokensyuruikigouyobi2x5() {
        return zrnhokensyuruikigouyobi2x5;
    }

    public void setZrnhokensyuruikigouyobi2x5(String pZrnhokensyuruikigouyobi2x5) {
        zrnhokensyuruikigouyobi2x5 = pZrnhokensyuruikigouyobi2x5;
    }

    private String zrnhokensyuruikigouyobi2x6;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI2X6)
    public String getZrnhokensyuruikigouyobi2x6() {
        return zrnhokensyuruikigouyobi2x6;
    }

    public void setZrnhokensyuruikigouyobi2x6(String pZrnhokensyuruikigouyobi2x6) {
        zrnhokensyuruikigouyobi2x6 = pZrnhokensyuruikigouyobi2x6;
    }

    private String zrnhokensyuruikigouyobi2x7;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI2X7)
    public String getZrnhokensyuruikigouyobi2x7() {
        return zrnhokensyuruikigouyobi2x7;
    }

    public void setZrnhokensyuruikigouyobi2x7(String pZrnhokensyuruikigouyobi2x7) {
        zrnhokensyuruikigouyobi2x7 = pZrnhokensyuruikigouyobi2x7;
    }

    private String zrnhokensyuruikigouyobi2x8;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI2X8)
    public String getZrnhokensyuruikigouyobi2x8() {
        return zrnhokensyuruikigouyobi2x8;
    }

    public void setZrnhokensyuruikigouyobi2x8(String pZrnhokensyuruikigouyobi2x8) {
        zrnhokensyuruikigouyobi2x8 = pZrnhokensyuruikigouyobi2x8;
    }

    private String zrnhokensyuruikigouyobi2x9;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI2X9)
    public String getZrnhokensyuruikigouyobi2x9() {
        return zrnhokensyuruikigouyobi2x9;
    }

    public void setZrnhokensyuruikigouyobi2x9(String pZrnhokensyuruikigouyobi2x9) {
        zrnhokensyuruikigouyobi2x9 = pZrnhokensyuruikigouyobi2x9;
    }

    private String zrnhokensyuruikigouyobi2x10;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI2X10)
    public String getZrnhokensyuruikigouyobi2x10() {
        return zrnhokensyuruikigouyobi2x10;
    }

    public void setZrnhokensyuruikigouyobi2x10(String pZrnhokensyuruikigouyobi2x10) {
        zrnhokensyuruikigouyobi2x10 = pZrnhokensyuruikigouyobi2x10;
    }

    private String zrnhokensyuruikigouyobi3x1;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI3X1)
    public String getZrnhokensyuruikigouyobi3x1() {
        return zrnhokensyuruikigouyobi3x1;
    }

    public void setZrnhokensyuruikigouyobi3x1(String pZrnhokensyuruikigouyobi3x1) {
        zrnhokensyuruikigouyobi3x1 = pZrnhokensyuruikigouyobi3x1;
    }

    private String zrnhokensyuruikigouyobi3x2;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI3X2)
    public String getZrnhokensyuruikigouyobi3x2() {
        return zrnhokensyuruikigouyobi3x2;
    }

    public void setZrnhokensyuruikigouyobi3x2(String pZrnhokensyuruikigouyobi3x2) {
        zrnhokensyuruikigouyobi3x2 = pZrnhokensyuruikigouyobi3x2;
    }

    private String zrnhokensyuruikigouyobi3x3;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI3X3)
    public String getZrnhokensyuruikigouyobi3x3() {
        return zrnhokensyuruikigouyobi3x3;
    }

    public void setZrnhokensyuruikigouyobi3x3(String pZrnhokensyuruikigouyobi3x3) {
        zrnhokensyuruikigouyobi3x3 = pZrnhokensyuruikigouyobi3x3;
    }

    private String zrnhokensyuruikigouyobi3x4;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI3X4)
    public String getZrnhokensyuruikigouyobi3x4() {
        return zrnhokensyuruikigouyobi3x4;
    }

    public void setZrnhokensyuruikigouyobi3x4(String pZrnhokensyuruikigouyobi3x4) {
        zrnhokensyuruikigouyobi3x4 = pZrnhokensyuruikigouyobi3x4;
    }

    private String zrnhokensyuruikigouyobi3x5;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI3X5)
    public String getZrnhokensyuruikigouyobi3x5() {
        return zrnhokensyuruikigouyobi3x5;
    }

    public void setZrnhokensyuruikigouyobi3x5(String pZrnhokensyuruikigouyobi3x5) {
        zrnhokensyuruikigouyobi3x5 = pZrnhokensyuruikigouyobi3x5;
    }

    private String zrnhokensyuruikigouyobi3x6;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI3X6)
    public String getZrnhokensyuruikigouyobi3x6() {
        return zrnhokensyuruikigouyobi3x6;
    }

    public void setZrnhokensyuruikigouyobi3x6(String pZrnhokensyuruikigouyobi3x6) {
        zrnhokensyuruikigouyobi3x6 = pZrnhokensyuruikigouyobi3x6;
    }

    private String zrnhokensyuruikigouyobi3x7;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI3X7)
    public String getZrnhokensyuruikigouyobi3x7() {
        return zrnhokensyuruikigouyobi3x7;
    }

    public void setZrnhokensyuruikigouyobi3x7(String pZrnhokensyuruikigouyobi3x7) {
        zrnhokensyuruikigouyobi3x7 = pZrnhokensyuruikigouyobi3x7;
    }

    private String zrnhokensyuruikigouyobi3x8;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI3X8)
    public String getZrnhokensyuruikigouyobi3x8() {
        return zrnhokensyuruikigouyobi3x8;
    }

    public void setZrnhokensyuruikigouyobi3x8(String pZrnhokensyuruikigouyobi3x8) {
        zrnhokensyuruikigouyobi3x8 = pZrnhokensyuruikigouyobi3x8;
    }

    private String zrnhokensyuruikigouyobi3x9;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI3X9)
    public String getZrnhokensyuruikigouyobi3x9() {
        return zrnhokensyuruikigouyobi3x9;
    }

    public void setZrnhokensyuruikigouyobi3x9(String pZrnhokensyuruikigouyobi3x9) {
        zrnhokensyuruikigouyobi3x9 = pZrnhokensyuruikigouyobi3x9;
    }

    private String zrnhokensyuruikigouyobi3x10;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNHOKENSYURUIKIGOUYOBI3X10)
    public String getZrnhokensyuruikigouyobi3x10() {
        return zrnhokensyuruikigouyobi3x10;
    }

    public void setZrnhokensyuruikigouyobi3x10(String pZrnhokensyuruikigouyobi3x10) {
        zrnhokensyuruikigouyobi3x10 = pZrnhokensyuruikigouyobi3x10;
    }

    private String zrnryouritukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNRYOURITUKBN)
    public String getZrnryouritukbn() {
        return zrnryouritukbn;
    }

    public void setZrnryouritukbn(String pZrnryouritukbn) {
        zrnryouritukbn = pZrnryouritukbn;
    }

    private String zrnyobiv33;

    @Column(name=GenZT_KeizokurituRenrakuULFRn.ZRNYOBIV33)
    public String getZrnyobiv33() {
        return zrnyobiv33;
    }

    public void setZrnyobiv33(String pZrnyobiv33) {
        zrnyobiv33 = pZrnyobiv33;
    }
}