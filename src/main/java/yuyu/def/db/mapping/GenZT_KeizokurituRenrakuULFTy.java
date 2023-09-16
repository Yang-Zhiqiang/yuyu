package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.id.PKZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.meta.GenQZT_KeizokurituRenrakuULFTy;
import yuyu.def.db.meta.QZT_KeizokurituRenrakuULFTy;

/**
 * 継続率連絡データＵＬＦテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KeizokurituRenrakuULFTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KeizokurituRenrakuULFTy}</td><td colspan="3">継続率連絡データＵＬＦテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_KeizokurituRenrakuULFTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatukaikojincd ztyatukaikojincd}</td><td>（中継用）扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukgu ztysyukgu}</td><td>（中継用）種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksyuannaikykkbn ztytksyuannaikykkbn}</td><td>（中継用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukinkbn ztysyukinkbn}</td><td>（中継用）集金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyanniskcd ztyanniskcd}</td><td>（中継用）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuukintantousosikicd ztysyuukintantousosikicd}</td><td>（中継用）集金担当組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydnthrkkeirokbn ztydnthrkkeirokbn}</td><td>（中継用）団体払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhyuukousyoumetukbn ztykhyuukousyoumetukbn}</td><td>（中継用）（契約保全）有効消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikatukisuu ztykeikatukisuu}</td><td>（中継用）経過月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakukensuu ztykeiyakukensuu}</td><td>（中継用）契約件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykihons ztykihons}</td><td>（中継用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuuseis9keta ztysyuuseis9keta}</td><td>（中継用）修正Ｓ（９桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhsys ztyhsys}</td><td>（中継用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyatukaisosikicd ztyatukaisosikicd}</td><td>（中継用）扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknm ztykyknm}</td><td>（中継用）契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm ztykjkyknm}</td><td>（中継用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2keta ztyhhknnen2keta}</td><td>（中継用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarutokuhyj ztymarutokuhyj}</td><td>（中継用）マル特表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyohktyouseihyj ztytyohktyouseihyj}</td><td>（中継用）重複調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygyoumujyouhyouji ztygyoumujyouhyouji}</td><td>（中継用）業務上表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkihyj ztykydatkihyj}</td><td>（中継用）共同扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkankaisuu ztytenkankaisuu}</td><td>（中継用）転換回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktatkibanhktgksnkbn ztykzktatkibanhktgksnkbn}</td><td>（中継用）継続手当用基盤引継加算区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjidoukousinhyouji ztyjidoukousinhyouji}</td><td>（中継用）自動更新表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeijimrtiarihyj ztyskeijimrtiarihyj}</td><td>（中継用）新契約時マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskeijikzkmrtiarihyj ztyskeijikzkmrtiarihyj}</td><td>（中継用）新契約時家族マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhukkatukeiiarihyj ztyhukkatukeiiarihyj}</td><td>（中継用）復活経緯有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhukutyouseiskeihyj ztytyouhukutyouseiskeihyj}</td><td>（中継用）重複調整新契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphkbnmnoshyouji ztyphkbnmnoshyouji}</td><td>（中継用）Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomarusyuuarihyj ztykaigomarusyuuarihyj}</td><td>（中継用）介護マル終有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyheiyoubaraikeiyakukbn ztyheiyoubaraikeiyakukbn}</td><td>（中継用）併用払契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhngkjidouentyoukbn ztyhngkjidouentyoukbn}</td><td>（中継用）変額自動延長区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhngkjidouentyoukikan ztyhngkjidouentyoukikan}</td><td>（中継用）変額自動延長期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydoujihuhomrtisyukigou ztydoujihuhomrtisyukigou}</td><td>（中継用）同時付保マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1 ztyyobiv1}</td><td>（中継用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmrtiarihyj ztyseizonmrtiarihyj}</td><td>（中継用）生存マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmrtiarihyj ztyteigenmrtiarihyj}</td><td>（中継用）逓減マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyunkensuu ztyjyunkensuu}</td><td>（中継用）純件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyaltourokukeiyakuhyj ztyaltourokukeiyakuhyj}</td><td>（中継用）ＡＬ登録契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikokykhyj ztyjikokykhyj}</td><td>（中継用）自己契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysynymrtiarihyj ztysynymrtiarihyj}</td><td>（中継用）収入マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykniyutksytioukbn ztykykniyutksytioukbn}</td><td>（中継用）契約内容特殊対応区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyreguardmrtiarihyj ztyreguardmrtiarihyj}</td><td>（中継用）リガードマル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyreguardmrsyuarihyj ztyreguardmrsyuarihyj}</td><td>（中継用）リガードマル終有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvguardmrtiarihyj ztyvguardmrtiarihyj}</td><td>（中継用）Ｖガードマル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousintkykhyj ztykousintkykhyj}</td><td>（中継用）更新特約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinkakuninnasihyj ztykousinkakuninnasihyj}</td><td>（中継用）更新確認無表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfollowhunouhyj ztyfollowhunouhyj}</td><td>（中継用）フォロー不能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigosynymrtiarihyj ztykaigosynymrtiarihyj}</td><td>（中継用）介護収入マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigoteigenmrtiarihyj ztykaigoteigenmrtiarihyj}</td><td>（中継用）介護逓減マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuperknkuseikatupackhyj ztysuperknkuseikatupackhyj}</td><td>（中継用）スーパー健康生活パック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigonktkykarihyj ztykaigonktkykarihyj}</td><td>（中継用）介護年金特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaigomrtiarihyj ztykaigomrtiarihyj}</td><td>（中継用）介護マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakukbn ztykeiyakukbn}</td><td>（中継用）契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeizokutyuuihyouji ztykeizokutyuuihyouji}</td><td>（中継用）継続注意表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykikeiyakutyuuihyouji ztykikeiyakutyuuihyouji}</td><td>（中継用）既契約注意表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuunincd ztybosyuunincd}</td><td>（中継用）募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhsyuikktminaosikaisu ztyhsyuikktminaosikaisu}</td><td>（中継用）保障一括見直回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjiqpackhyj ztykykjiqpackhyj}</td><td>（中継用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnkttnknkbn ztybnkttnknkbn}</td><td>（中継用）分割転換区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtikousinkbn ztymrtikousinkbn}</td><td>（中継用）マル定更新区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenkbnv1 ztypmenkbnv1}</td><td>（中継用）Ｐ免区分Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyouikunktkykarihyj ztyyouikunktkykarihyj}</td><td>（中継用）養育年金特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumetucd ztysyoumetucd}</td><td>（中継用）消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikatusyuunyuumrtis ztyseikatusyuunyuumrtis}</td><td>（中継用）生活収入マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhitenkansyono1 ztyhitenkansyono1}</td><td>（中継用）被転換証券番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhitenkansyono2 ztyhitenkansyono2}</td><td>（中継用）被転換証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhitenkansyono3 ztyhitenkansyono3}</td><td>（中継用）被転換証券番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhitenkansyono4 ztyhitenkansyono4}</td><td>（中継用）被転換証券番号４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhitenkansyono5 ztyhitenkansyono5}</td><td>（中継用）被転換証券番号５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhitenkansyono6 ztyhitenkansyono6}</td><td>（中継用）被転換証券番号６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkansanp ztynenkansanp}</td><td>（中継用）年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai3bunyanenkansanp ztydai3bunyanenkansanp}</td><td>（中継用）第３分野年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykykym ztykykym}</td><td>（中継用）契約年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysytikbn ztysytikbn}</td><td>（中継用）集定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfundbubunnenkansanp ztyfundbubunnenkansanp}</td><td>（中継用）ファンド部分年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym ztyjikaipjyuutouym}</td><td>（中継用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktatsyuuseis ztykzktatsyuuseis}</td><td>（中継用）継続手当用修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiktsynymrtiarihyj ztysiktsynymrtiarihyj}</td><td>（中継用）生活収入マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivguardarihyj ztylivguardarihyj}</td><td>（中継用）ＬＩＶガード有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivguards ztylivguards}</td><td>（中継用）ＬＩＶガードＳ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrttekitkarihyj ztyknkuzusnzyrttekitkarihyj}</td><td>（中継用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybluekzjtkaisiymd ztybluekzjtkaisiymd}</td><td>（中継用）Ｂｌｕｅ継続状態開始年月日　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrtstkbn ztyknkuzusnzyrtstkbn}</td><td>（中継用）健康増進乗率用ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakuno ztytokuyakuno}</td><td>（中継用）特約番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvityugusttkyuhyj ztyvityugusttkyuhyj}</td><td>（中継用）Ｖｉｔ優遇措置適用表示　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtkykarihyj ztykykdrtkykarihyj}</td><td>（中継用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdairiseikyuutkykarihyj ztystdairiseikyuutkykarihyj}</td><td>（中継用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicearihyj ztykzktourokuservicearihyj}</td><td>（中継用）家族登録サービス有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyendthnkymd8keta ztyyendthnkymd8keta}</td><td>（中継用）円建変更日（８桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykhsyoumetujiyuu ztykhsyoumetujiyuu}</td><td>（中継用）（契約保全）消滅事由</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibaraipkyktuuka ztyitijibaraipkyktuuka}</td><td>（中継用）一時払Ｐ（契約通貨建）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseraten5 ztykawaseraten5}</td><td>（中継用）為替レートＮ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssysyup ztynnknsnpssysyup}</td><td>（中継用）年換算Ｐ算出用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynknsnpssyhrkkskbn ztynknsnpssyhrkkskbn}</td><td>（中継用）年換算Ｐ算出用払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynnknsnpyennkgotmttrrt ztynnknsnpyennkgotmttrrt}</td><td>（中継用）年換算Ｐ算出用円建年金変更後積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtynnknsnpyennkgonksjtmttkn ztynnknsnpyennkgonksjtmttkn}</td><td>（中継用）年換算Ｐ算出用円建年金変更後年金開始時積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteituukakbn ztysiteituukakbn}</td><td>（中継用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x1 ztyhokensyuruikigouyobi1x1}</td><td>（中継用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x2 ztyhokensyuruikigouyobi1x2}</td><td>（中継用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x3 ztyhokensyuruikigouyobi1x3}</td><td>（中継用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x4 ztyhokensyuruikigouyobi1x4}</td><td>（中継用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x5 ztyhokensyuruikigouyobi1x5}</td><td>（中継用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x6 ztyhokensyuruikigouyobi1x6}</td><td>（中継用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x7 ztyhokensyuruikigouyobi1x7}</td><td>（中継用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x8 ztyhokensyuruikigouyobi1x8}</td><td>（中継用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x9 ztyhokensyuruikigouyobi1x9}</td><td>（中継用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x10 ztyhokensyuruikigouyobi1x10}</td><td>（中継用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x11 ztyhokensyuruikigouyobi1x11}</td><td>（中継用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x12 ztyhokensyuruikigouyobi1x12}</td><td>（中継用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x13 ztyhokensyuruikigouyobi1x13}</td><td>（中継用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x14 ztyhokensyuruikigouyobi1x14}</td><td>（中継用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x15 ztyhokensyuruikigouyobi1x15}</td><td>（中継用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x1 ztyhokensyuruikigouyobi2x1}</td><td>（中継用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x2 ztyhokensyuruikigouyobi2x2}</td><td>（中継用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x3 ztyhokensyuruikigouyobi2x3}</td><td>（中継用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x4 ztyhokensyuruikigouyobi2x4}</td><td>（中継用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x5 ztyhokensyuruikigouyobi2x5}</td><td>（中継用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x6 ztyhokensyuruikigouyobi2x6}</td><td>（中継用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x7 ztyhokensyuruikigouyobi2x7}</td><td>（中継用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x8 ztyhokensyuruikigouyobi2x8}</td><td>（中継用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x9 ztyhokensyuruikigouyobi2x9}</td><td>（中継用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x10 ztyhokensyuruikigouyobi2x10}</td><td>（中継用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x1 ztyhokensyuruikigouyobi3x1}</td><td>（中継用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x2 ztyhokensyuruikigouyobi3x2}</td><td>（中継用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x3 ztyhokensyuruikigouyobi3x3}</td><td>（中継用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x4 ztyhokensyuruikigouyobi3x4}</td><td>（中継用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x5 ztyhokensyuruikigouyobi3x5}</td><td>（中継用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x6 ztyhokensyuruikigouyobi3x6}</td><td>（中継用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x7 ztyhokensyuruikigouyobi3x7}</td><td>（中継用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x8 ztyhokensyuruikigouyobi3x8}</td><td>（中継用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x9 ztyhokensyuruikigouyobi3x9}</td><td>（中継用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x10 ztyhokensyuruikigouyobi3x10}</td><td>（中継用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryouritukbn ztyryouritukbn}</td><td>（中継用）料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv33 ztyyobiv33}</td><td>（中継用）予備項目Ｖ３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KeizokurituRenrakuULFTy
 * @see     PKZT_KeizokurituRenrakuULFTy
 * @see     QZT_KeizokurituRenrakuULFTy
 * @see     GenQZT_KeizokurituRenrakuULFTy
 */
@MappedSuperclass
@Table(name=GenZT_KeizokurituRenrakuULFTy.TABLE_NAME)
@IdClass(value=PKZT_KeizokurituRenrakuULFTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KeizokurituRenrakuULFTy extends AbstractExDBEntity<ZT_KeizokurituRenrakuULFTy, PKZT_KeizokurituRenrakuULFTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KeizokurituRenrakuULFTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYATUKAIKOJINCD         = "ztyatukaikojincd";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYSYUKGU                = "ztysyukgu";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYTKSYUANNAIKYKKBN      = "ztytksyuannaikykkbn";
    public static final String ZTYSYUKINKBN             = "ztysyukinkbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYANNISKCD              = "ztyanniskcd";
    public static final String ZTYSYUUKINTANTOUSOSIKICD = "ztysyuukintantousosikicd";
    public static final String ZTYDNTHRKKEIROKBN        = "ztydnthrkkeirokbn";
    public static final String ZTYKHYUUKOUSYOUMETUKBN   = "ztykhyuukousyoumetukbn";
    public static final String ZTYKEIKATUKISUU          = "ztykeikatukisuu";
    public static final String ZTYKEIYAKUKENSUU         = "ztykeiyakukensuu";
    public static final String ZTYKIHONS                = "ztykihons";
    public static final String ZTYSYUUSEIS9KETA         = "ztysyuuseis9keta";
    public static final String ZTYHSYS                  = "ztyhsys";
    public static final String ZTYATUKAISOSIKICD        = "ztyatukaisosikicd";
    public static final String ZTYKYKNM                 = "ztykyknm";
    public static final String ZTYKJKYKNM               = "ztykjkyknm";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHHKNNEN2KETA          = "ztyhhknnen2keta";
    public static final String ZTYMARUTOKUHYJ           = "ztymarutokuhyj";
    public static final String ZTYTYOHKTYOUSEIHYJ       = "ztytyohktyouseihyj";
    public static final String ZTYGYOUMUJYOUHYOUJI      = "ztygyoumujyouhyouji";
    public static final String ZTYKYDATKIHYJ            = "ztykydatkihyj";
    public static final String ZTYTENKANKAISUU          = "ztytenkankaisuu";
    public static final String ZTYKZKTATKIBANHKTGKSNKBN = "ztykzktatkibanhktgksnkbn";
    public static final String ZTYJIDOUKOUSINHYOUJI     = "ztyjidoukousinhyouji";
    public static final String ZTYSKEIJIMRTIARIHYJ      = "ztyskeijimrtiarihyj";
    public static final String ZTYSKEIJIKZKMRTIARIHYJ   = "ztyskeijikzkmrtiarihyj";
    public static final String ZTYHUKKATUKEIIARIHYJ     = "ztyhukkatukeiiarihyj";
    public static final String ZTYTYOUHUKUTYOUSEISKEIHYJ = "ztytyouhukutyouseiskeihyj";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYPHKBNMNOSHYOUJI       = "ztyphkbnmnoshyouji";
    public static final String ZTYKAIGOMARUSYUUARIHYJ   = "ztykaigomarusyuuarihyj";
    public static final String ZTYHEIYOUBARAIKEIYAKUKBN = "ztyheiyoubaraikeiyakukbn";
    public static final String ZTYHNGKJIDOUENTYOUKBN    = "ztyhngkjidouentyoukbn";
    public static final String ZTYHNGKJIDOUENTYOUKIKAN  = "ztyhngkjidouentyoukikan";
    public static final String ZTYDOUJIHUHOMRTISYUKIGOU = "ztydoujihuhomrtisyukigou";
    public static final String ZTYYOBIV1                = "ztyyobiv1";
    public static final String ZTYSEIZONMRTIARIHYJ      = "ztyseizonmrtiarihyj";
    public static final String ZTYTEIGENMRTIARIHYJ      = "ztyteigenmrtiarihyj";
    public static final String ZTYJYUNKENSUU            = "ztyjyunkensuu";
    public static final String ZTYALTOUROKUKEIYAKUHYJ   = "ztyaltourokukeiyakuhyj";
    public static final String ZTYJIKOKYKHYJ            = "ztyjikokykhyj";
    public static final String ZTYSYNYMRTIARIHYJ        = "ztysynymrtiarihyj";
    public static final String ZTYKYKNIYUTKSYTIOUKBN    = "ztykykniyutksytioukbn";
    public static final String ZTYREGUARDMRTIARIHYJ     = "ztyreguardmrtiarihyj";
    public static final String ZTYREGUARDMRSYUARIHYJ    = "ztyreguardmrsyuarihyj";
    public static final String ZTYVGUARDMRTIARIHYJ      = "ztyvguardmrtiarihyj";
    public static final String ZTYKOUSINTKYKHYJ         = "ztykousintkykhyj";
    public static final String ZTYKOUSINKAKUNINNASIHYJ  = "ztykousinkakuninnasihyj";
    public static final String ZTYFOLLOWHUNOUHYJ        = "ztyfollowhunouhyj";
    public static final String ZTYKAIGOSYNYMRTIARIHYJ   = "ztykaigosynymrtiarihyj";
    public static final String ZTYKAIGOTEIGENMRTIARIHYJ = "ztykaigoteigenmrtiarihyj";
    public static final String ZTYSUPERKNKUSEIKATUPACKHYJ = "ztysuperknkuseikatupackhyj";
    public static final String ZTYKAIGONKTKYKARIHYJ     = "ztykaigonktkykarihyj";
    public static final String ZTYKAIGOMRTIARIHYJ       = "ztykaigomrtiarihyj";
    public static final String ZTYKEIYAKUKBN            = "ztykeiyakukbn";
    public static final String ZTYKEIZOKUTYUUIHYOUJI    = "ztykeizokutyuuihyouji";
    public static final String ZTYKIKEIYAKUTYUUIHYOUJI  = "ztykikeiyakutyuuihyouji";
    public static final String ZTYBOSYUUNINCD           = "ztybosyuunincd";
    public static final String ZTYHSYUIKKTMINAOSIKAISU  = "ztyhsyuikktminaosikaisu";
    public static final String ZTYKYKJIQPACKHYJ         = "ztykykjiqpackhyj";
    public static final String ZTYBNKTTNKNKBN           = "ztybnkttnknkbn";
    public static final String ZTYMRTIKOUSINKBN         = "ztymrtikousinkbn";
    public static final String ZTYPMENKBNV1             = "ztypmenkbnv1";
    public static final String ZTYYOUIKUNKTKYKARIHYJ    = "ztyyouikunktkykarihyj";
    public static final String ZTYSYOUMETUCD            = "ztysyoumetucd";
    public static final String ZTYSEIKATUSYUUNYUUMRTIS  = "ztyseikatusyuunyuumrtis";
    public static final String ZTYHITENKANSYONO1        = "ztyhitenkansyono1";
    public static final String ZTYHITENKANSYONO2        = "ztyhitenkansyono2";
    public static final String ZTYHITENKANSYONO3        = "ztyhitenkansyono3";
    public static final String ZTYHITENKANSYONO4        = "ztyhitenkansyono4";
    public static final String ZTYHITENKANSYONO5        = "ztyhitenkansyono5";
    public static final String ZTYHITENKANSYONO6        = "ztyhitenkansyono6";
    public static final String ZTYNENKANSANP            = "ztynenkansanp";
    public static final String ZTYDAI3BUNYANENKANSANP   = "ztydai3bunyanenkansanp";
    public static final String ZTYKYKYM                 = "ztykykym";
    public static final String ZTYSYTIKBN               = "ztysytikbn";
    public static final String ZTYFUNDBUBUNNENKANSANP   = "ztyfundbubunnenkansanp";
    public static final String ZTYJIKAIPJYUUTOUYM       = "ztyjikaipjyuutouym";
    public static final String ZTYKZKTATSYUUSEIS        = "ztykzktatsyuuseis";
    public static final String ZTYSIKTSYNYMRTIARIHYJ    = "ztysiktsynymrtiarihyj";
    public static final String ZTYLIVGUARDARIHYJ        = "ztylivguardarihyj";
    public static final String ZTYLIVGUARDS             = "ztylivguards";
    public static final String ZTYKNKUZUSNZYRTTEKITKARIHYJ = "ztyknkuzusnzyrttekitkarihyj";
    public static final String ZTYBLUEKZJTKAISIYMD      = "ztybluekzjtkaisiymd";
    public static final String ZTYKNKUZUSNZYRTSTKBN     = "ztyknkuzusnzyrtstkbn";
    public static final String ZTYTOKUYAKUNO            = "ztytokuyakuno";
    public static final String ZTYVITYUGUSTTKYUHYJ      = "ztyvityugusttkyuhyj";
    public static final String ZTYKYKDRTKYKARIHYJ       = "ztykykdrtkykarihyj";
    public static final String ZTYSTDAIRISEIKYUUTKYKARIHYJ = "ztystdairiseikyuutkykarihyj";
    public static final String ZTYKZKTOUROKUSERVICEARIHYJ = "ztykzktourokuservicearihyj";
    public static final String ZTYYENDTHNKYMD8KETA      = "ztyyendthnkymd8keta";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYKHSYOUMETUJIYUU       = "ztykhsyoumetujiyuu";
    public static final String ZTYITIJIBARAIPKYKTUUKA   = "ztyitijibaraipkyktuuka";
    public static final String ZTYKAWASERATEN5          = "ztykawaseraten5";
    public static final String ZTYNNKNSNPSSYSYUP        = "ztynnknsnpssysyup";
    public static final String ZTYNKNSNPSSYHRKKSKBN     = "ztynknsnpssyhrkkskbn";
    public static final String ZTYNNKNSNPYENNKGOTMTTRRT = "ztynnknsnpyennkgotmttrrt";
    public static final String ZTYNNKNSNPYENNKGONKSJTMTTKN = "ztynnknsnpyennkgonksjtmttkn";
    public static final String ZTYSITEITUUKAKBN         = "ztysiteituukakbn";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X1 = "ztyhokensyuruikigouyobi1x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X2 = "ztyhokensyuruikigouyobi1x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X3 = "ztyhokensyuruikigouyobi1x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X4 = "ztyhokensyuruikigouyobi1x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X5 = "ztyhokensyuruikigouyobi1x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X6 = "ztyhokensyuruikigouyobi1x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X7 = "ztyhokensyuruikigouyobi1x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X8 = "ztyhokensyuruikigouyobi1x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X9 = "ztyhokensyuruikigouyobi1x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X10 = "ztyhokensyuruikigouyobi1x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X11 = "ztyhokensyuruikigouyobi1x11";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X12 = "ztyhokensyuruikigouyobi1x12";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X13 = "ztyhokensyuruikigouyobi1x13";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X14 = "ztyhokensyuruikigouyobi1x14";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X15 = "ztyhokensyuruikigouyobi1x15";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X1 = "ztyhokensyuruikigouyobi2x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X2 = "ztyhokensyuruikigouyobi2x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X3 = "ztyhokensyuruikigouyobi2x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X4 = "ztyhokensyuruikigouyobi2x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X5 = "ztyhokensyuruikigouyobi2x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X6 = "ztyhokensyuruikigouyobi2x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X7 = "ztyhokensyuruikigouyobi2x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X8 = "ztyhokensyuruikigouyobi2x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X9 = "ztyhokensyuruikigouyobi2x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X10 = "ztyhokensyuruikigouyobi2x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X1 = "ztyhokensyuruikigouyobi3x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X2 = "ztyhokensyuruikigouyobi3x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X3 = "ztyhokensyuruikigouyobi3x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X4 = "ztyhokensyuruikigouyobi3x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X5 = "ztyhokensyuruikigouyobi3x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X6 = "ztyhokensyuruikigouyobi3x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X7 = "ztyhokensyuruikigouyobi3x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X8 = "ztyhokensyuruikigouyobi3x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X9 = "ztyhokensyuruikigouyobi3x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X10 = "ztyhokensyuruikigouyobi3x10";
    public static final String ZTYRYOURITUKBN           = "ztyryouritukbn";
    public static final String ZTYYOBIV33               = "ztyyobiv33";

    private final PKZT_KeizokurituRenrakuULFTy primaryKey;

    public GenZT_KeizokurituRenrakuULFTy() {
        primaryKey = new PKZT_KeizokurituRenrakuULFTy();
    }

    public GenZT_KeizokurituRenrakuULFTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_KeizokurituRenrakuULFTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_KeizokurituRenrakuULFTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KeizokurituRenrakuULFTy> getMetaClass() {
        return QZT_KeizokurituRenrakuULFTy.class;
    }

    @Id
    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztysyono;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyatukaikojincd;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYATUKAIKOJINCD)
    public String getZtyatukaikojincd() {
        return ztyatukaikojincd;
    }

    public void setZtyatukaikojincd(String pZtyatukaikojincd) {
        ztyatukaikojincd = pZtyatukaikojincd;
    }

    private String ztybsyym;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztysyukgu;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSYUKGU)
    public String getZtysyukgu() {
        return ztysyukgu;
    }

    public void setZtysyukgu(String pZtysyukgu) {
        ztysyukgu = pZtysyukgu;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztytksyuannaikykkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYTKSYUANNAIKYKKBN)
    public String getZtytksyuannaikykkbn() {
        return ztytksyuannaikykkbn;
    }

    public void setZtytksyuannaikykkbn(String pZtytksyuannaikykkbn) {
        ztytksyuannaikykkbn = pZtytksyuannaikykkbn;
    }

    private String ztysyukinkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSYUKINKBN)
    public String getZtysyukinkbn() {
        return ztysyukinkbn;
    }

    public void setZtysyukinkbn(String pZtysyukinkbn) {
        ztysyukinkbn = pZtysyukinkbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyanniskcd;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private String ztysyuukintantousosikicd;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSYUUKINTANTOUSOSIKICD)
    public String getZtysyuukintantousosikicd() {
        return ztysyuukintantousosikicd;
    }

    public void setZtysyuukintantousosikicd(String pZtysyuukintantousosikicd) {
        ztysyuukintantousosikicd = pZtysyuukintantousosikicd;
    }

    private String ztydnthrkkeirokbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYDNTHRKKEIROKBN)
    public String getZtydnthrkkeirokbn() {
        return ztydnthrkkeirokbn;
    }

    public void setZtydnthrkkeirokbn(String pZtydnthrkkeirokbn) {
        ztydnthrkkeirokbn = pZtydnthrkkeirokbn;
    }

    private String ztykhyuukousyoumetukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKHYUUKOUSYOUMETUKBN)
    public String getZtykhyuukousyoumetukbn() {
        return ztykhyuukousyoumetukbn;
    }

    public void setZtykhyuukousyoumetukbn(String pZtykhyuukousyoumetukbn) {
        ztykhyuukousyoumetukbn = pZtykhyuukousyoumetukbn;
    }

    private String ztykeikatukisuu;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKEIKATUKISUU)
    public String getZtykeikatukisuu() {
        return ztykeikatukisuu;
    }

    public void setZtykeikatukisuu(String pZtykeikatukisuu) {
        ztykeikatukisuu = pZtykeikatukisuu;
    }

    private BizNumber ztykeiyakukensuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKEIYAKUKENSUU)
    public BizNumber getZtykeiyakukensuu() {
        return ztykeiyakukensuu;
    }

    public void setZtykeiyakukensuu(BizNumber pZtykeiyakukensuu) {
        ztykeiyakukensuu = pZtykeiyakukensuu;
    }

    private Long ztykihons;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private Long ztysyuuseis9keta;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSYUUSEIS9KETA)
    public Long getZtysyuuseis9keta() {
        return ztysyuuseis9keta;
    }

    public void setZtysyuuseis9keta(Long pZtysyuuseis9keta) {
        ztysyuuseis9keta = pZtysyuuseis9keta;
    }

    private Long ztyhsys;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHSYS)
    public Long getZtyhsys() {
        return ztyhsys;
    }

    public void setZtyhsys(Long pZtyhsys) {
        ztyhsys = pZtyhsys;
    }

    private String ztyatukaisosikicd;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYATUKAISOSIKICD)
    public String getZtyatukaisosikicd() {
        return ztyatukaisosikicd;
    }

    public void setZtyatukaisosikicd(String pZtyatukaisosikicd) {
        ztyatukaisosikicd = pZtyatukaisosikicd;
    }

    private String ztykyknm;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKYKNM)
    public String getZtykyknm() {
        return ztykyknm;
    }

    public void setZtykyknm(String pZtykyknm) {
        ztykyknm = pZtykyknm;
    }

    private String ztykjkyknm;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKJKYKNM)
    public String getZtykjkyknm() {
        return ztykjkyknm;
    }

    public void setZtykjkyknm(String pZtykjkyknm) {
        ztykjkyknm = pZtykjkyknm;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhhknnen2keta;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHHKNNEN2KETA)
    public String getZtyhhknnen2keta() {
        return ztyhhknnen2keta;
    }

    public void setZtyhhknnen2keta(String pZtyhhknnen2keta) {
        ztyhhknnen2keta = pZtyhhknnen2keta;
    }

    private String ztymarutokuhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYMARUTOKUHYJ)
    public String getZtymarutokuhyj() {
        return ztymarutokuhyj;
    }

    public void setZtymarutokuhyj(String pZtymarutokuhyj) {
        ztymarutokuhyj = pZtymarutokuhyj;
    }

    private String ztytyohktyouseihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYTYOHKTYOUSEIHYJ)
    public String getZtytyohktyouseihyj() {
        return ztytyohktyouseihyj;
    }

    public void setZtytyohktyouseihyj(String pZtytyohktyouseihyj) {
        ztytyohktyouseihyj = pZtytyohktyouseihyj;
    }

    private String ztygyoumujyouhyouji;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYGYOUMUJYOUHYOUJI)
    public String getZtygyoumujyouhyouji() {
        return ztygyoumujyouhyouji;
    }

    public void setZtygyoumujyouhyouji(String pZtygyoumujyouhyouji) {
        ztygyoumujyouhyouji = pZtygyoumujyouhyouji;
    }

    private String ztykydatkihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKYDATKIHYJ)
    public String getZtykydatkihyj() {
        return ztykydatkihyj;
    }

    public void setZtykydatkihyj(String pZtykydatkihyj) {
        ztykydatkihyj = pZtykydatkihyj;
    }

    private String ztytenkankaisuu;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYTENKANKAISUU)
    public String getZtytenkankaisuu() {
        return ztytenkankaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkankaisuu(String pZtytenkankaisuu) {
        ztytenkankaisuu = pZtytenkankaisuu;
    }

    private String ztykzktatkibanhktgksnkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKZKTATKIBANHKTGKSNKBN)
    public String getZtykzktatkibanhktgksnkbn() {
        return ztykzktatkibanhktgksnkbn;
    }

    public void setZtykzktatkibanhktgksnkbn(String pZtykzktatkibanhktgksnkbn) {
        ztykzktatkibanhktgksnkbn = pZtykzktatkibanhktgksnkbn;
    }

    private String ztyjidoukousinhyouji;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYJIDOUKOUSINHYOUJI)
    public String getZtyjidoukousinhyouji() {
        return ztyjidoukousinhyouji;
    }

    public void setZtyjidoukousinhyouji(String pZtyjidoukousinhyouji) {
        ztyjidoukousinhyouji = pZtyjidoukousinhyouji;
    }

    private String ztyskeijimrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSKEIJIMRTIARIHYJ)
    public String getZtyskeijimrtiarihyj() {
        return ztyskeijimrtiarihyj;
    }

    public void setZtyskeijimrtiarihyj(String pZtyskeijimrtiarihyj) {
        ztyskeijimrtiarihyj = pZtyskeijimrtiarihyj;
    }

    private String ztyskeijikzkmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSKEIJIKZKMRTIARIHYJ)
    public String getZtyskeijikzkmrtiarihyj() {
        return ztyskeijikzkmrtiarihyj;
    }

    public void setZtyskeijikzkmrtiarihyj(String pZtyskeijikzkmrtiarihyj) {
        ztyskeijikzkmrtiarihyj = pZtyskeijikzkmrtiarihyj;
    }

    private String ztyhukkatukeiiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHUKKATUKEIIARIHYJ)
    public String getZtyhukkatukeiiarihyj() {
        return ztyhukkatukeiiarihyj;
    }

    public void setZtyhukkatukeiiarihyj(String pZtyhukkatukeiiarihyj) {
        ztyhukkatukeiiarihyj = pZtyhukkatukeiiarihyj;
    }

    private String ztytyouhukutyouseiskeihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYTYOUHUKUTYOUSEISKEIHYJ)
    public String getZtytyouhukutyouseiskeihyj() {
        return ztytyouhukutyouseiskeihyj;
    }

    public void setZtytyouhukutyouseiskeihyj(String pZtytyouhukutyouseiskeihyj) {
        ztytyouhukutyouseiskeihyj = pZtytyouhukutyouseiskeihyj;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyphkbnmnoshyouji;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYPHKBNMNOSHYOUJI)
    public String getZtyphkbnmnoshyouji() {
        return ztyphkbnmnoshyouji;
    }

    public void setZtyphkbnmnoshyouji(String pZtyphkbnmnoshyouji) {
        ztyphkbnmnoshyouji = pZtyphkbnmnoshyouji;
    }

    private String ztykaigomarusyuuarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKAIGOMARUSYUUARIHYJ)
    public String getZtykaigomarusyuuarihyj() {
        return ztykaigomarusyuuarihyj;
    }

    public void setZtykaigomarusyuuarihyj(String pZtykaigomarusyuuarihyj) {
        ztykaigomarusyuuarihyj = pZtykaigomarusyuuarihyj;
    }

    private String ztyheiyoubaraikeiyakukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHEIYOUBARAIKEIYAKUKBN)
    public String getZtyheiyoubaraikeiyakukbn() {
        return ztyheiyoubaraikeiyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyheiyoubaraikeiyakukbn(String pZtyheiyoubaraikeiyakukbn) {
        ztyheiyoubaraikeiyakukbn = pZtyheiyoubaraikeiyakukbn;
    }

    private String ztyhngkjidouentyoukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHNGKJIDOUENTYOUKBN)
    public String getZtyhngkjidouentyoukbn() {
        return ztyhngkjidouentyoukbn;
    }

    public void setZtyhngkjidouentyoukbn(String pZtyhngkjidouentyoukbn) {
        ztyhngkjidouentyoukbn = pZtyhngkjidouentyoukbn;
    }

    private String ztyhngkjidouentyoukikan;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHNGKJIDOUENTYOUKIKAN)
    public String getZtyhngkjidouentyoukikan() {
        return ztyhngkjidouentyoukikan;
    }

    public void setZtyhngkjidouentyoukikan(String pZtyhngkjidouentyoukikan) {
        ztyhngkjidouentyoukikan = pZtyhngkjidouentyoukikan;
    }

    private String ztydoujihuhomrtisyukigou;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYDOUJIHUHOMRTISYUKIGOU)
    public String getZtydoujihuhomrtisyukigou() {
        return ztydoujihuhomrtisyukigou;
    }

    public void setZtydoujihuhomrtisyukigou(String pZtydoujihuhomrtisyukigou) {
        ztydoujihuhomrtisyukigou = pZtydoujihuhomrtisyukigou;
    }

    private String ztyyobiv1;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYYOBIV1)
    public String getZtyyobiv1() {
        return ztyyobiv1;
    }

    public void setZtyyobiv1(String pZtyyobiv1) {
        ztyyobiv1 = pZtyyobiv1;
    }

    private String ztyseizonmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSEIZONMRTIARIHYJ)
    public String getZtyseizonmrtiarihyj() {
        return ztyseizonmrtiarihyj;
    }

    public void setZtyseizonmrtiarihyj(String pZtyseizonmrtiarihyj) {
        ztyseizonmrtiarihyj = pZtyseizonmrtiarihyj;
    }

    private String ztyteigenmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYTEIGENMRTIARIHYJ)
    public String getZtyteigenmrtiarihyj() {
        return ztyteigenmrtiarihyj;
    }

    public void setZtyteigenmrtiarihyj(String pZtyteigenmrtiarihyj) {
        ztyteigenmrtiarihyj = pZtyteigenmrtiarihyj;
    }

    private BizNumber ztyjyunkensuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYJYUNKENSUU)
    public BizNumber getZtyjyunkensuu() {
        return ztyjyunkensuu;
    }

    public void setZtyjyunkensuu(BizNumber pZtyjyunkensuu) {
        ztyjyunkensuu = pZtyjyunkensuu;
    }

    private String ztyaltourokukeiyakuhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYALTOUROKUKEIYAKUHYJ)
    public String getZtyaltourokukeiyakuhyj() {
        return ztyaltourokukeiyakuhyj;
    }

    public void setZtyaltourokukeiyakuhyj(String pZtyaltourokukeiyakuhyj) {
        ztyaltourokukeiyakuhyj = pZtyaltourokukeiyakuhyj;
    }

    private String ztyjikokykhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYJIKOKYKHYJ)
    public String getZtyjikokykhyj() {
        return ztyjikokykhyj;
    }

    public void setZtyjikokykhyj(String pZtyjikokykhyj) {
        ztyjikokykhyj = pZtyjikokykhyj;
    }

    private String ztysynymrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSYNYMRTIARIHYJ)
    public String getZtysynymrtiarihyj() {
        return ztysynymrtiarihyj;
    }

    public void setZtysynymrtiarihyj(String pZtysynymrtiarihyj) {
        ztysynymrtiarihyj = pZtysynymrtiarihyj;
    }

    private String ztykykniyutksytioukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKYKNIYUTKSYTIOUKBN)
    public String getZtykykniyutksytioukbn() {
        return ztykykniyutksytioukbn;
    }

    public void setZtykykniyutksytioukbn(String pZtykykniyutksytioukbn) {
        ztykykniyutksytioukbn = pZtykykniyutksytioukbn;
    }

    private String ztyreguardmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYREGUARDMRTIARIHYJ)
    public String getZtyreguardmrtiarihyj() {
        return ztyreguardmrtiarihyj;
    }

    public void setZtyreguardmrtiarihyj(String pZtyreguardmrtiarihyj) {
        ztyreguardmrtiarihyj = pZtyreguardmrtiarihyj;
    }

    private String ztyreguardmrsyuarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYREGUARDMRSYUARIHYJ)
    public String getZtyreguardmrsyuarihyj() {
        return ztyreguardmrsyuarihyj;
    }

    public void setZtyreguardmrsyuarihyj(String pZtyreguardmrsyuarihyj) {
        ztyreguardmrsyuarihyj = pZtyreguardmrsyuarihyj;
    }

    private String ztyvguardmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYVGUARDMRTIARIHYJ)
    public String getZtyvguardmrtiarihyj() {
        return ztyvguardmrtiarihyj;
    }

    public void setZtyvguardmrtiarihyj(String pZtyvguardmrtiarihyj) {
        ztyvguardmrtiarihyj = pZtyvguardmrtiarihyj;
    }

    private String ztykousintkykhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKOUSINTKYKHYJ)
    public String getZtykousintkykhyj() {
        return ztykousintkykhyj;
    }

    public void setZtykousintkykhyj(String pZtykousintkykhyj) {
        ztykousintkykhyj = pZtykousintkykhyj;
    }

    private String ztykousinkakuninnasihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKOUSINKAKUNINNASIHYJ)
    public String getZtykousinkakuninnasihyj() {
        return ztykousinkakuninnasihyj;
    }

    public void setZtykousinkakuninnasihyj(String pZtykousinkakuninnasihyj) {
        ztykousinkakuninnasihyj = pZtykousinkakuninnasihyj;
    }

    private String ztyfollowhunouhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYFOLLOWHUNOUHYJ)
    public String getZtyfollowhunouhyj() {
        return ztyfollowhunouhyj;
    }

    public void setZtyfollowhunouhyj(String pZtyfollowhunouhyj) {
        ztyfollowhunouhyj = pZtyfollowhunouhyj;
    }

    private String ztykaigosynymrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKAIGOSYNYMRTIARIHYJ)
    public String getZtykaigosynymrtiarihyj() {
        return ztykaigosynymrtiarihyj;
    }

    public void setZtykaigosynymrtiarihyj(String pZtykaigosynymrtiarihyj) {
        ztykaigosynymrtiarihyj = pZtykaigosynymrtiarihyj;
    }

    private String ztykaigoteigenmrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKAIGOTEIGENMRTIARIHYJ)
    public String getZtykaigoteigenmrtiarihyj() {
        return ztykaigoteigenmrtiarihyj;
    }

    public void setZtykaigoteigenmrtiarihyj(String pZtykaigoteigenmrtiarihyj) {
        ztykaigoteigenmrtiarihyj = pZtykaigoteigenmrtiarihyj;
    }

    private String ztysuperknkuseikatupackhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSUPERKNKUSEIKATUPACKHYJ)
    public String getZtysuperknkuseikatupackhyj() {
        return ztysuperknkuseikatupackhyj;
    }

    public void setZtysuperknkuseikatupackhyj(String pZtysuperknkuseikatupackhyj) {
        ztysuperknkuseikatupackhyj = pZtysuperknkuseikatupackhyj;
    }

    private String ztykaigonktkykarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKAIGONKTKYKARIHYJ)
    public String getZtykaigonktkykarihyj() {
        return ztykaigonktkykarihyj;
    }

    public void setZtykaigonktkykarihyj(String pZtykaigonktkykarihyj) {
        ztykaigonktkykarihyj = pZtykaigonktkykarihyj;
    }

    private String ztykaigomrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKAIGOMRTIARIHYJ)
    public String getZtykaigomrtiarihyj() {
        return ztykaigomrtiarihyj;
    }

    public void setZtykaigomrtiarihyj(String pZtykaigomrtiarihyj) {
        ztykaigomrtiarihyj = pZtykaigomrtiarihyj;
    }

    private String ztykeiyakukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKEIYAKUKBN)
    public String getZtykeiyakukbn() {
        return ztykeiyakukbn;
    }

    public void setZtykeiyakukbn(String pZtykeiyakukbn) {
        ztykeiyakukbn = pZtykeiyakukbn;
    }

    private String ztykeizokutyuuihyouji;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKEIZOKUTYUUIHYOUJI)
    public String getZtykeizokutyuuihyouji() {
        return ztykeizokutyuuihyouji;
    }

    public void setZtykeizokutyuuihyouji(String pZtykeizokutyuuihyouji) {
        ztykeizokutyuuihyouji = pZtykeizokutyuuihyouji;
    }

    private String ztykikeiyakutyuuihyouji;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKIKEIYAKUTYUUIHYOUJI)
    public String getZtykikeiyakutyuuihyouji() {
        return ztykikeiyakutyuuihyouji;
    }

    public void setZtykikeiyakutyuuihyouji(String pZtykikeiyakutyuuihyouji) {
        ztykikeiyakutyuuihyouji = pZtykikeiyakutyuuihyouji;
    }

    private String ztybosyuunincd;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYBOSYUUNINCD)
    public String getZtybosyuunincd() {
        return ztybosyuunincd;
    }

    public void setZtybosyuunincd(String pZtybosyuunincd) {
        ztybosyuunincd = pZtybosyuunincd;
    }

    private String ztyhsyuikktminaosikaisu;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHSYUIKKTMINAOSIKAISU)
    public String getZtyhsyuikktminaosikaisu() {
        return ztyhsyuikktminaosikaisu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhsyuikktminaosikaisu(String pZtyhsyuikktminaosikaisu) {
        ztyhsyuikktminaosikaisu = pZtyhsyuikktminaosikaisu;
    }

    private String ztykykjiqpackhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKYKJIQPACKHYJ)
    public String getZtykykjiqpackhyj() {
        return ztykykjiqpackhyj;
    }

    public void setZtykykjiqpackhyj(String pZtykykjiqpackhyj) {
        ztykykjiqpackhyj = pZtykykjiqpackhyj;
    }

    private String ztybnkttnknkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYBNKTTNKNKBN)
    public String getZtybnkttnknkbn() {
        return ztybnkttnknkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtybnkttnknkbn(String pZtybnkttnknkbn) {
        ztybnkttnknkbn = pZtybnkttnknkbn;
    }

    private String ztymrtikousinkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYMRTIKOUSINKBN)
    public String getZtymrtikousinkbn() {
        return ztymrtikousinkbn;
    }

    public void setZtymrtikousinkbn(String pZtymrtikousinkbn) {
        ztymrtikousinkbn = pZtymrtikousinkbn;
    }

    private String ztypmenkbnv1;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYPMENKBNV1)
    public String getZtypmenkbnv1() {
        return ztypmenkbnv1;
    }

    public void setZtypmenkbnv1(String pZtypmenkbnv1) {
        ztypmenkbnv1 = pZtypmenkbnv1;
    }

    private String ztyyouikunktkykarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYYOUIKUNKTKYKARIHYJ)
    public String getZtyyouikunktkykarihyj() {
        return ztyyouikunktkykarihyj;
    }

    public void setZtyyouikunktkykarihyj(String pZtyyouikunktkykarihyj) {
        ztyyouikunktkykarihyj = pZtyyouikunktkykarihyj;
    }

    private String ztysyoumetucd;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSYOUMETUCD)
    public String getZtysyoumetucd() {
        return ztysyoumetucd;
    }

    public void setZtysyoumetucd(String pZtysyoumetucd) {
        ztysyoumetucd = pZtysyoumetucd;
    }

    private Long ztyseikatusyuunyuumrtis;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSEIKATUSYUUNYUUMRTIS)
    public Long getZtyseikatusyuunyuumrtis() {
        return ztyseikatusyuunyuumrtis;
    }

    public void setZtyseikatusyuunyuumrtis(Long pZtyseikatusyuunyuumrtis) {
        ztyseikatusyuunyuumrtis = pZtyseikatusyuunyuumrtis;
    }

    private String ztyhitenkansyono1;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHITENKANSYONO1)
    public String getZtyhitenkansyono1() {
        return ztyhitenkansyono1;
    }

    public void setZtyhitenkansyono1(String pZtyhitenkansyono1) {
        ztyhitenkansyono1 = pZtyhitenkansyono1;
    }

    private String ztyhitenkansyono2;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHITENKANSYONO2)
    public String getZtyhitenkansyono2() {
        return ztyhitenkansyono2;
    }

    public void setZtyhitenkansyono2(String pZtyhitenkansyono2) {
        ztyhitenkansyono2 = pZtyhitenkansyono2;
    }

    private String ztyhitenkansyono3;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHITENKANSYONO3)
    public String getZtyhitenkansyono3() {
        return ztyhitenkansyono3;
    }

    public void setZtyhitenkansyono3(String pZtyhitenkansyono3) {
        ztyhitenkansyono3 = pZtyhitenkansyono3;
    }

    private String ztyhitenkansyono4;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHITENKANSYONO4)
    public String getZtyhitenkansyono4() {
        return ztyhitenkansyono4;
    }

    public void setZtyhitenkansyono4(String pZtyhitenkansyono4) {
        ztyhitenkansyono4 = pZtyhitenkansyono4;
    }

    private String ztyhitenkansyono5;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHITENKANSYONO5)
    public String getZtyhitenkansyono5() {
        return ztyhitenkansyono5;
    }

    public void setZtyhitenkansyono5(String pZtyhitenkansyono5) {
        ztyhitenkansyono5 = pZtyhitenkansyono5;
    }

    private String ztyhitenkansyono6;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHITENKANSYONO6)
    public String getZtyhitenkansyono6() {
        return ztyhitenkansyono6;
    }

    public void setZtyhitenkansyono6(String pZtyhitenkansyono6) {
        ztyhitenkansyono6 = pZtyhitenkansyono6;
    }

    private Long ztynenkansanp;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYNENKANSANP)
    public Long getZtynenkansanp() {
        return ztynenkansanp;
    }

    public void setZtynenkansanp(Long pZtynenkansanp) {
        ztynenkansanp = pZtynenkansanp;
    }

    private Long ztydai3bunyanenkansanp;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYDAI3BUNYANENKANSANP)
    public Long getZtydai3bunyanenkansanp() {
        return ztydai3bunyanenkansanp;
    }

    public void setZtydai3bunyanenkansanp(Long pZtydai3bunyanenkansanp) {
        ztydai3bunyanenkansanp = pZtydai3bunyanenkansanp;
    }

    private String ztykykym;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKYKYM)
    public String getZtykykym() {
        return ztykykym;
    }

    public void setZtykykym(String pZtykykym) {
        ztykykym = pZtykykym;
    }

    private String ztysytikbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSYTIKBN)
    public String getZtysytikbn() {
        return ztysytikbn;
    }

    public void setZtysytikbn(String pZtysytikbn) {
        ztysytikbn = pZtysytikbn;
    }

    private Long ztyfundbubunnenkansanp;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYFUNDBUBUNNENKANSANP)
    public Long getZtyfundbubunnenkansanp() {
        return ztyfundbubunnenkansanp;
    }

    public void setZtyfundbubunnenkansanp(Long pZtyfundbubunnenkansanp) {
        ztyfundbubunnenkansanp = pZtyfundbubunnenkansanp;
    }

    private String ztyjikaipjyuutouym;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYJIKAIPJYUUTOUYM)
    public String getZtyjikaipjyuutouym() {
        return ztyjikaipjyuutouym;
    }

    public void setZtyjikaipjyuutouym(String pZtyjikaipjyuutouym) {
        ztyjikaipjyuutouym = pZtyjikaipjyuutouym;
    }

    private Long ztykzktatsyuuseis;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKZKTATSYUUSEIS)
    public Long getZtykzktatsyuuseis() {
        return ztykzktatsyuuseis;
    }

    public void setZtykzktatsyuuseis(Long pZtykzktatsyuuseis) {
        ztykzktatsyuuseis = pZtykzktatsyuuseis;
    }

    private String ztysiktsynymrtiarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSIKTSYNYMRTIARIHYJ)
    public String getZtysiktsynymrtiarihyj() {
        return ztysiktsynymrtiarihyj;
    }

    public void setZtysiktsynymrtiarihyj(String pZtysiktsynymrtiarihyj) {
        ztysiktsynymrtiarihyj = pZtysiktsynymrtiarihyj;
    }

    private String ztylivguardarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYLIVGUARDARIHYJ)
    public String getZtylivguardarihyj() {
        return ztylivguardarihyj;
    }

    public void setZtylivguardarihyj(String pZtylivguardarihyj) {
        ztylivguardarihyj = pZtylivguardarihyj;
    }

    private Long ztylivguards;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYLIVGUARDS)
    public Long getZtylivguards() {
        return ztylivguards;
    }

    public void setZtylivguards(Long pZtylivguards) {
        ztylivguards = pZtylivguards;
    }

    private String ztyknkuzusnzyrttekitkarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZtyknkuzusnzyrttekitkarihyj() {
        return ztyknkuzusnzyrttekitkarihyj;
    }

    public void setZtyknkuzusnzyrttekitkarihyj(String pZtyknkuzusnzyrttekitkarihyj) {
        ztyknkuzusnzyrttekitkarihyj = pZtyknkuzusnzyrttekitkarihyj;
    }

    private String ztybluekzjtkaisiymd;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYBLUEKZJTKAISIYMD)
    public String getZtybluekzjtkaisiymd() {
        return ztybluekzjtkaisiymd;
    }

    public void setZtybluekzjtkaisiymd(String pZtybluekzjtkaisiymd) {
        ztybluekzjtkaisiymd = pZtybluekzjtkaisiymd;
    }

    private String ztyknkuzusnzyrtstkbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKNKUZUSNZYRTSTKBN)
    public String getZtyknkuzusnzyrtstkbn() {
        return ztyknkuzusnzyrtstkbn;
    }

    public void setZtyknkuzusnzyrtstkbn(String pZtyknkuzusnzyrtstkbn) {
        ztyknkuzusnzyrtstkbn = pZtyknkuzusnzyrtstkbn;
    }

    private String ztytokuyakuno;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYTOKUYAKUNO)
    public String getZtytokuyakuno() {
        return ztytokuyakuno;
    }

    public void setZtytokuyakuno(String pZtytokuyakuno) {
        ztytokuyakuno = pZtytokuyakuno;
    }

    private String ztyvityugusttkyuhyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYVITYUGUSTTKYUHYJ)
    public String getZtyvityugusttkyuhyj() {
        return ztyvityugusttkyuhyj;
    }

    public void setZtyvityugusttkyuhyj(String pZtyvityugusttkyuhyj) {
        ztyvityugusttkyuhyj = pZtyvityugusttkyuhyj;
    }

    private String ztykykdrtkykarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKYKDRTKYKARIHYJ)
    public String getZtykykdrtkykarihyj() {
        return ztykykdrtkykarihyj;
    }

    public void setZtykykdrtkykarihyj(String pZtykykdrtkykarihyj) {
        ztykykdrtkykarihyj = pZtykykdrtkykarihyj;
    }

    private String ztystdairiseikyuutkykarihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZtystdairiseikyuutkykarihyj() {
        return ztystdairiseikyuutkykarihyj;
    }

    public void setZtystdairiseikyuutkykarihyj(String pZtystdairiseikyuutkykarihyj) {
        ztystdairiseikyuutkykarihyj = pZtystdairiseikyuutkykarihyj;
    }

    private String ztykzktourokuservicearihyj;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKZKTOUROKUSERVICEARIHYJ)
    public String getZtykzktourokuservicearihyj() {
        return ztykzktourokuservicearihyj;
    }

    public void setZtykzktourokuservicearihyj(String pZtykzktourokuservicearihyj) {
        ztykzktourokuservicearihyj = pZtykzktourokuservicearihyj;
    }

    private String ztyyendthnkymd8keta;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYYENDTHNKYMD8KETA)
    public String getZtyyendthnkymd8keta() {
        return ztyyendthnkymd8keta;
    }

    public void setZtyyendthnkymd8keta(String pZtyyendthnkymd8keta) {
        ztyyendthnkymd8keta = pZtyyendthnkymd8keta;
    }

    private String ztykykymd;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    private String ztykhsyoumetujiyuu;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKHSYOUMETUJIYUU)
    public String getZtykhsyoumetujiyuu() {
        return ztykhsyoumetujiyuu;
    }

    public void setZtykhsyoumetujiyuu(String pZtykhsyoumetujiyuu) {
        ztykhsyoumetujiyuu = pZtykhsyoumetujiyuu;
    }

    private BizNumber ztyitijibaraipkyktuuka;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYITIJIBARAIPKYKTUUKA)
    public BizNumber getZtyitijibaraipkyktuuka() {
        return ztyitijibaraipkyktuuka;
    }

    public void setZtyitijibaraipkyktuuka(BizNumber pZtyitijibaraipkyktuuka) {
        ztyitijibaraipkyktuuka = pZtyitijibaraipkyktuuka;
    }

    private BizNumber ztykawaseraten5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYKAWASERATEN5)
    public BizNumber getZtykawaseraten5() {
        return ztykawaseraten5;
    }

    public void setZtykawaseraten5(BizNumber pZtykawaseraten5) {
        ztykawaseraten5 = pZtykawaseraten5;
    }

    private Long ztynnknsnpssysyup;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYNNKNSNPSSYSYUP)
    public Long getZtynnknsnpssysyup() {
        return ztynnknsnpssysyup;
    }

    public void setZtynnknsnpssysyup(Long pZtynnknsnpssysyup) {
        ztynnknsnpssysyup = pZtynnknsnpssysyup;
    }

    private String ztynknsnpssyhrkkskbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYNKNSNPSSYHRKKSKBN)
    public String getZtynknsnpssyhrkkskbn() {
        return ztynknsnpssyhrkkskbn;
    }

    public void setZtynknsnpssyhrkkskbn(String pZtynknsnpssyhrkkskbn) {
        ztynknsnpssyhrkkskbn = pZtynknsnpssyhrkkskbn;
    }

    private BizNumber ztynnknsnpyennkgotmttrrt;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYNNKNSNPYENNKGOTMTTRRT)
    public BizNumber getZtynnknsnpyennkgotmttrrt() {
        return ztynnknsnpyennkgotmttrrt;
    }

    public void setZtynnknsnpyennkgotmttrrt(BizNumber pZtynnknsnpyennkgotmttrrt) {
        ztynnknsnpyennkgotmttrrt = pZtynnknsnpyennkgotmttrrt;
    }

    private Long ztynnknsnpyennkgonksjtmttkn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYNNKNSNPYENNKGONKSJTMTTKN)
    public Long getZtynnknsnpyennkgonksjtmttkn() {
        return ztynnknsnpyennkgonksjtmttkn;
    }

    public void setZtynnknsnpyennkgonksjtmttkn(Long pZtynnknsnpyennkgonksjtmttkn) {
        ztynnknsnpyennkgonksjtmttkn = pZtynnknsnpyennkgonksjtmttkn;
    }

    private String ztysiteituukakbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYSITEITUUKAKBN)
    public String getZtysiteituukakbn() {
        return ztysiteituukakbn;
    }

    public void setZtysiteituukakbn(String pZtysiteituukakbn) {
        ztysiteituukakbn = pZtysiteituukakbn;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztyhokensyuruikigouyobi1x1;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X1)
    public String getZtyhokensyuruikigouyobi1x1() {
        return ztyhokensyuruikigouyobi1x1;
    }

    public void setZtyhokensyuruikigouyobi1x1(String pZtyhokensyuruikigouyobi1x1) {
        ztyhokensyuruikigouyobi1x1 = pZtyhokensyuruikigouyobi1x1;
    }

    private String ztyhokensyuruikigouyobi1x2;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X2)
    public String getZtyhokensyuruikigouyobi1x2() {
        return ztyhokensyuruikigouyobi1x2;
    }

    public void setZtyhokensyuruikigouyobi1x2(String pZtyhokensyuruikigouyobi1x2) {
        ztyhokensyuruikigouyobi1x2 = pZtyhokensyuruikigouyobi1x2;
    }

    private String ztyhokensyuruikigouyobi1x3;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X3)
    public String getZtyhokensyuruikigouyobi1x3() {
        return ztyhokensyuruikigouyobi1x3;
    }

    public void setZtyhokensyuruikigouyobi1x3(String pZtyhokensyuruikigouyobi1x3) {
        ztyhokensyuruikigouyobi1x3 = pZtyhokensyuruikigouyobi1x3;
    }

    private String ztyhokensyuruikigouyobi1x4;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X4)
    public String getZtyhokensyuruikigouyobi1x4() {
        return ztyhokensyuruikigouyobi1x4;
    }

    public void setZtyhokensyuruikigouyobi1x4(String pZtyhokensyuruikigouyobi1x4) {
        ztyhokensyuruikigouyobi1x4 = pZtyhokensyuruikigouyobi1x4;
    }

    private String ztyhokensyuruikigouyobi1x5;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X5)
    public String getZtyhokensyuruikigouyobi1x5() {
        return ztyhokensyuruikigouyobi1x5;
    }

    public void setZtyhokensyuruikigouyobi1x5(String pZtyhokensyuruikigouyobi1x5) {
        ztyhokensyuruikigouyobi1x5 = pZtyhokensyuruikigouyobi1x5;
    }

    private String ztyhokensyuruikigouyobi1x6;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X6)
    public String getZtyhokensyuruikigouyobi1x6() {
        return ztyhokensyuruikigouyobi1x6;
    }

    public void setZtyhokensyuruikigouyobi1x6(String pZtyhokensyuruikigouyobi1x6) {
        ztyhokensyuruikigouyobi1x6 = pZtyhokensyuruikigouyobi1x6;
    }

    private String ztyhokensyuruikigouyobi1x7;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X7)
    public String getZtyhokensyuruikigouyobi1x7() {
        return ztyhokensyuruikigouyobi1x7;
    }

    public void setZtyhokensyuruikigouyobi1x7(String pZtyhokensyuruikigouyobi1x7) {
        ztyhokensyuruikigouyobi1x7 = pZtyhokensyuruikigouyobi1x7;
    }

    private String ztyhokensyuruikigouyobi1x8;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X8)
    public String getZtyhokensyuruikigouyobi1x8() {
        return ztyhokensyuruikigouyobi1x8;
    }

    public void setZtyhokensyuruikigouyobi1x8(String pZtyhokensyuruikigouyobi1x8) {
        ztyhokensyuruikigouyobi1x8 = pZtyhokensyuruikigouyobi1x8;
    }

    private String ztyhokensyuruikigouyobi1x9;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X9)
    public String getZtyhokensyuruikigouyobi1x9() {
        return ztyhokensyuruikigouyobi1x9;
    }

    public void setZtyhokensyuruikigouyobi1x9(String pZtyhokensyuruikigouyobi1x9) {
        ztyhokensyuruikigouyobi1x9 = pZtyhokensyuruikigouyobi1x9;
    }

    private String ztyhokensyuruikigouyobi1x10;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X10)
    public String getZtyhokensyuruikigouyobi1x10() {
        return ztyhokensyuruikigouyobi1x10;
    }

    public void setZtyhokensyuruikigouyobi1x10(String pZtyhokensyuruikigouyobi1x10) {
        ztyhokensyuruikigouyobi1x10 = pZtyhokensyuruikigouyobi1x10;
    }

    private String ztyhokensyuruikigouyobi1x11;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X11)
    public String getZtyhokensyuruikigouyobi1x11() {
        return ztyhokensyuruikigouyobi1x11;
    }

    public void setZtyhokensyuruikigouyobi1x11(String pZtyhokensyuruikigouyobi1x11) {
        ztyhokensyuruikigouyobi1x11 = pZtyhokensyuruikigouyobi1x11;
    }

    private String ztyhokensyuruikigouyobi1x12;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X12)
    public String getZtyhokensyuruikigouyobi1x12() {
        return ztyhokensyuruikigouyobi1x12;
    }

    public void setZtyhokensyuruikigouyobi1x12(String pZtyhokensyuruikigouyobi1x12) {
        ztyhokensyuruikigouyobi1x12 = pZtyhokensyuruikigouyobi1x12;
    }

    private String ztyhokensyuruikigouyobi1x13;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X13)
    public String getZtyhokensyuruikigouyobi1x13() {
        return ztyhokensyuruikigouyobi1x13;
    }

    public void setZtyhokensyuruikigouyobi1x13(String pZtyhokensyuruikigouyobi1x13) {
        ztyhokensyuruikigouyobi1x13 = pZtyhokensyuruikigouyobi1x13;
    }

    private String ztyhokensyuruikigouyobi1x14;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X14)
    public String getZtyhokensyuruikigouyobi1x14() {
        return ztyhokensyuruikigouyobi1x14;
    }

    public void setZtyhokensyuruikigouyobi1x14(String pZtyhokensyuruikigouyobi1x14) {
        ztyhokensyuruikigouyobi1x14 = pZtyhokensyuruikigouyobi1x14;
    }

    private String ztyhokensyuruikigouyobi1x15;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI1X15)
    public String getZtyhokensyuruikigouyobi1x15() {
        return ztyhokensyuruikigouyobi1x15;
    }

    public void setZtyhokensyuruikigouyobi1x15(String pZtyhokensyuruikigouyobi1x15) {
        ztyhokensyuruikigouyobi1x15 = pZtyhokensyuruikigouyobi1x15;
    }

    private String ztyhokensyuruikigouyobi2x1;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI2X1)
    public String getZtyhokensyuruikigouyobi2x1() {
        return ztyhokensyuruikigouyobi2x1;
    }

    public void setZtyhokensyuruikigouyobi2x1(String pZtyhokensyuruikigouyobi2x1) {
        ztyhokensyuruikigouyobi2x1 = pZtyhokensyuruikigouyobi2x1;
    }

    private String ztyhokensyuruikigouyobi2x2;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI2X2)
    public String getZtyhokensyuruikigouyobi2x2() {
        return ztyhokensyuruikigouyobi2x2;
    }

    public void setZtyhokensyuruikigouyobi2x2(String pZtyhokensyuruikigouyobi2x2) {
        ztyhokensyuruikigouyobi2x2 = pZtyhokensyuruikigouyobi2x2;
    }

    private String ztyhokensyuruikigouyobi2x3;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI2X3)
    public String getZtyhokensyuruikigouyobi2x3() {
        return ztyhokensyuruikigouyobi2x3;
    }

    public void setZtyhokensyuruikigouyobi2x3(String pZtyhokensyuruikigouyobi2x3) {
        ztyhokensyuruikigouyobi2x3 = pZtyhokensyuruikigouyobi2x3;
    }

    private String ztyhokensyuruikigouyobi2x4;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI2X4)
    public String getZtyhokensyuruikigouyobi2x4() {
        return ztyhokensyuruikigouyobi2x4;
    }

    public void setZtyhokensyuruikigouyobi2x4(String pZtyhokensyuruikigouyobi2x4) {
        ztyhokensyuruikigouyobi2x4 = pZtyhokensyuruikigouyobi2x4;
    }

    private String ztyhokensyuruikigouyobi2x5;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI2X5)
    public String getZtyhokensyuruikigouyobi2x5() {
        return ztyhokensyuruikigouyobi2x5;
    }

    public void setZtyhokensyuruikigouyobi2x5(String pZtyhokensyuruikigouyobi2x5) {
        ztyhokensyuruikigouyobi2x5 = pZtyhokensyuruikigouyobi2x5;
    }

    private String ztyhokensyuruikigouyobi2x6;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI2X6)
    public String getZtyhokensyuruikigouyobi2x6() {
        return ztyhokensyuruikigouyobi2x6;
    }

    public void setZtyhokensyuruikigouyobi2x6(String pZtyhokensyuruikigouyobi2x6) {
        ztyhokensyuruikigouyobi2x6 = pZtyhokensyuruikigouyobi2x6;
    }

    private String ztyhokensyuruikigouyobi2x7;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI2X7)
    public String getZtyhokensyuruikigouyobi2x7() {
        return ztyhokensyuruikigouyobi2x7;
    }

    public void setZtyhokensyuruikigouyobi2x7(String pZtyhokensyuruikigouyobi2x7) {
        ztyhokensyuruikigouyobi2x7 = pZtyhokensyuruikigouyobi2x7;
    }

    private String ztyhokensyuruikigouyobi2x8;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI2X8)
    public String getZtyhokensyuruikigouyobi2x8() {
        return ztyhokensyuruikigouyobi2x8;
    }

    public void setZtyhokensyuruikigouyobi2x8(String pZtyhokensyuruikigouyobi2x8) {
        ztyhokensyuruikigouyobi2x8 = pZtyhokensyuruikigouyobi2x8;
    }

    private String ztyhokensyuruikigouyobi2x9;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI2X9)
    public String getZtyhokensyuruikigouyobi2x9() {
        return ztyhokensyuruikigouyobi2x9;
    }

    public void setZtyhokensyuruikigouyobi2x9(String pZtyhokensyuruikigouyobi2x9) {
        ztyhokensyuruikigouyobi2x9 = pZtyhokensyuruikigouyobi2x9;
    }

    private String ztyhokensyuruikigouyobi2x10;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI2X10)
    public String getZtyhokensyuruikigouyobi2x10() {
        return ztyhokensyuruikigouyobi2x10;
    }

    public void setZtyhokensyuruikigouyobi2x10(String pZtyhokensyuruikigouyobi2x10) {
        ztyhokensyuruikigouyobi2x10 = pZtyhokensyuruikigouyobi2x10;
    }

    private String ztyhokensyuruikigouyobi3x1;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI3X1)
    public String getZtyhokensyuruikigouyobi3x1() {
        return ztyhokensyuruikigouyobi3x1;
    }

    public void setZtyhokensyuruikigouyobi3x1(String pZtyhokensyuruikigouyobi3x1) {
        ztyhokensyuruikigouyobi3x1 = pZtyhokensyuruikigouyobi3x1;
    }

    private String ztyhokensyuruikigouyobi3x2;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI3X2)
    public String getZtyhokensyuruikigouyobi3x2() {
        return ztyhokensyuruikigouyobi3x2;
    }

    public void setZtyhokensyuruikigouyobi3x2(String pZtyhokensyuruikigouyobi3x2) {
        ztyhokensyuruikigouyobi3x2 = pZtyhokensyuruikigouyobi3x2;
    }

    private String ztyhokensyuruikigouyobi3x3;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI3X3)
    public String getZtyhokensyuruikigouyobi3x3() {
        return ztyhokensyuruikigouyobi3x3;
    }

    public void setZtyhokensyuruikigouyobi3x3(String pZtyhokensyuruikigouyobi3x3) {
        ztyhokensyuruikigouyobi3x3 = pZtyhokensyuruikigouyobi3x3;
    }

    private String ztyhokensyuruikigouyobi3x4;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI3X4)
    public String getZtyhokensyuruikigouyobi3x4() {
        return ztyhokensyuruikigouyobi3x4;
    }

    public void setZtyhokensyuruikigouyobi3x4(String pZtyhokensyuruikigouyobi3x4) {
        ztyhokensyuruikigouyobi3x4 = pZtyhokensyuruikigouyobi3x4;
    }

    private String ztyhokensyuruikigouyobi3x5;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI3X5)
    public String getZtyhokensyuruikigouyobi3x5() {
        return ztyhokensyuruikigouyobi3x5;
    }

    public void setZtyhokensyuruikigouyobi3x5(String pZtyhokensyuruikigouyobi3x5) {
        ztyhokensyuruikigouyobi3x5 = pZtyhokensyuruikigouyobi3x5;
    }

    private String ztyhokensyuruikigouyobi3x6;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI3X6)
    public String getZtyhokensyuruikigouyobi3x6() {
        return ztyhokensyuruikigouyobi3x6;
    }

    public void setZtyhokensyuruikigouyobi3x6(String pZtyhokensyuruikigouyobi3x6) {
        ztyhokensyuruikigouyobi3x6 = pZtyhokensyuruikigouyobi3x6;
    }

    private String ztyhokensyuruikigouyobi3x7;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI3X7)
    public String getZtyhokensyuruikigouyobi3x7() {
        return ztyhokensyuruikigouyobi3x7;
    }

    public void setZtyhokensyuruikigouyobi3x7(String pZtyhokensyuruikigouyobi3x7) {
        ztyhokensyuruikigouyobi3x7 = pZtyhokensyuruikigouyobi3x7;
    }

    private String ztyhokensyuruikigouyobi3x8;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI3X8)
    public String getZtyhokensyuruikigouyobi3x8() {
        return ztyhokensyuruikigouyobi3x8;
    }

    public void setZtyhokensyuruikigouyobi3x8(String pZtyhokensyuruikigouyobi3x8) {
        ztyhokensyuruikigouyobi3x8 = pZtyhokensyuruikigouyobi3x8;
    }

    private String ztyhokensyuruikigouyobi3x9;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI3X9)
    public String getZtyhokensyuruikigouyobi3x9() {
        return ztyhokensyuruikigouyobi3x9;
    }

    public void setZtyhokensyuruikigouyobi3x9(String pZtyhokensyuruikigouyobi3x9) {
        ztyhokensyuruikigouyobi3x9 = pZtyhokensyuruikigouyobi3x9;
    }

    private String ztyhokensyuruikigouyobi3x10;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYHOKENSYURUIKIGOUYOBI3X10)
    public String getZtyhokensyuruikigouyobi3x10() {
        return ztyhokensyuruikigouyobi3x10;
    }

    public void setZtyhokensyuruikigouyobi3x10(String pZtyhokensyuruikigouyobi3x10) {
        ztyhokensyuruikigouyobi3x10 = pZtyhokensyuruikigouyobi3x10;
    }

    private String ztyryouritukbn;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYRYOURITUKBN)
    public String getZtyryouritukbn() {
        return ztyryouritukbn;
    }

    public void setZtyryouritukbn(String pZtyryouritukbn) {
        ztyryouritukbn = pZtyryouritukbn;
    }

    private String ztyyobiv33;

    @Column(name=GenZT_KeizokurituRenrakuULFTy.ZTYYOBIV33)
    public String getZtyyobiv33() {
        return ztyyobiv33;
    }

    public void setZtyyobiv33(String pZtyyobiv33) {
        ztyyobiv33 = pZtyyobiv33;
    }
}