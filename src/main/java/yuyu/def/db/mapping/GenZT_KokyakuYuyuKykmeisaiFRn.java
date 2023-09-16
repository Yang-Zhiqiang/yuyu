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
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.id.PKZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.meta.GenQZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.meta.QZT_KokyakuYuyuKykmeisaiFRn;

/**
 * 顧客用ゆうゆう契約明細Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_KokyakuYuyuKykmeisaiFRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KokyakuYuyuKykmeisaiFRn}</td><td colspan="3">顧客用ゆうゆう契約明細Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">{@link PKZT_KokyakuYuyuKykmeisaiFRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkmnenkansanp zrnhrkmnenkansanp}</td><td>（連携用）払込年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyengyousekihosyous zrnyengyousekihosyous}</td><td>（連携用）円換算業績保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsymtymd zrnsymtymd}</td><td>（連携用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakukigou zrnsyukeiyakukigou}</td><td>（連携用）主契約記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykykratesedaikbn zrnsykykratesedaikbn}</td><td>（連携用）主契約レート世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyudkaigomehrtkarihyj zrnjyudkaigomehrtkarihyj}</td><td>（連携用）重度介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmentokuyakukbn zrnpmentokuyakukbn}</td><td>（連携用）Ｐ免特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrtkykarihyj zrnkykdrtkykarihyj}</td><td>（連携用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv158 zrnyobiv158}</td><td>（連携用）予備項目Ｖ１５８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsyym zrnbsyym}</td><td>（連携用）募集年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkyknm18 zrnknkyknm18}</td><td>（連携用）カナ契約者名（１８文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm zrnkjkyknm}</td><td>（連携用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseiymd zrnkyksyaseiymd}</td><td>（連携用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen3 zrnkyksyanen3}</td><td>（連携用）契約者年齢（３桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjikyksyanen zrnkykjikyksyanen}</td><td>（連携用）契約時契約者年齢</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuusinsakihumeihyj zrntuusinsakihumeihyj}</td><td>（連携用）通信先不明表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihontikucd zrnkihontikucd}</td><td>（連携用）基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntodouhukencd zrntodouhukencd}</td><td>（連携用）都道府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikutyousoncd5 zrnsikutyousoncd5}</td><td>（連携用）市区町村コード（５桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjadr62 zrnkjadr62}</td><td>（連携用）漢字住所（６２文字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntelno zrntelno}</td><td>（連携用）電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2telno zrndai2telno}</td><td>（連携用）第２電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknhhknmei zrnknhhknmei}</td><td>（連携用）カナ被保険者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei zrnknjhhknmei}</td><td>（連携用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseiymd zrnhhknseiymd}</td><td>（連携用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen zrnhhknnen}</td><td>（連携用）被保険者年齢</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjihhknnen zrnkykjihhknnen}</td><td>（連携用）契約時被保険者年齢</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmannenreikykhyj zrnmannenreikykhyj}</td><td>（連携用）満年齢契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyhhknsydouituhyouji zrnkyksyhhknsydouituhyouji}</td><td>（連携用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjyutikbn zrnkykjyutikbn}</td><td>（連携用）契約状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoumetucd zrnsyoumetucd}</td><td>（連携用）消滅コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikikaisiymd zrntorihikikaisiymd}</td><td>（連携用）取引開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpowerfulhyj zrnpowerfulhyj}</td><td>（連携用）パワフル表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnlargehyj zrnlargehyj}</td><td>（連携用）ラージ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouhinbunruikbn zrnsyouhinbunruikbn}</td><td>（連携用）商品分類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyouhnnmkbn zrnsyouhnnmkbn}</td><td>（連携用）商品名称区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknnmcd zrnhknnmcd}</td><td>（連携用）保険名称コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkbthsyukiknmanryouym zrntkbthsyukiknmanryouym}</td><td>（連携用）特別保障期間満了年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnldownym zrnldownym}</td><td>（連携用）Ｌダウン年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkmanryouym zrnhrkmanryouym}</td><td>（連携用）払込満了年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmankiym zrnmankiym}</td><td>（連携用）満期年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykykyoteiriritu zrnsykykyoteiriritu}</td><td>（連携用）主契約予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrserieshyj zrnrserieshyj}</td><td>（連携用）Ｒシリーズ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduketorihouhoukbn zrnduketorihouhoukbn}</td><td>（連携用）Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrninfoteikyoutsghyj zrninfoteikyoutsghyj}</td><td>（連携用）情報提供対象外表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaimitukykhyj zrnnaimitukykhyj}</td><td>（連携用）内密契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrarihyj zrnmrarihyj}</td><td>（連携用）ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasitukenaimituhyj zrnkasitukenaimituhyj}</td><td>（連携用）貸付内密表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdktyuuiarihyj zrnttdktyuuiarihyj}</td><td>（連携用）手続注意情報有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdktyuuisetkacd1 zrnttdktyuuisetkacd1}</td><td>（連携用）手続注意台帳設定課コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdktyuuisetymd1 zrnttdktyuuisetymd1}</td><td>（連携用）手続注意台帳設定年月日１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdktyuuisetkbn1 zrnttdktyuuisetkbn1}</td><td>（連携用）手続注意台帳設定区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdktyuuisetkacd2 zrnttdktyuuisetkacd2}</td><td>（連携用）手続注意台帳設定課コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdktyuuisetymd2 zrnttdktyuuisetymd2}</td><td>（連携用）手続注意台帳設定年月日２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdktyuuisetkbn2 zrnttdktyuuisetkbn2}</td><td>（連携用）手続注意台帳設定区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnttdktyuui3kenijyouhyj zrnttdktyuui3kenijyouhyj}</td><td>（連携用）手続注意３件以上あり表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsentakujyouhouarihyouji zrnsentakujyouhouarihyouji}</td><td>（連携用）選択情報有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstknsetkykhyj zrnstknsetkykhyj}</td><td>（連携用）質権設定契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenharaikomip zrnyenharaikomip}</td><td>（連携用）円換算払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyenkihons zrnyenkihons}</td><td>（連携用）円換算基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyensibous zrnyensibous}</td><td>（連携用）円換算死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhrkhuhukbn zrnhrkhuhukbn}</td><td>（連携用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyuunoukeirokbn zrnsyuunoukeirokbn}</td><td>（連携用）収納経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncalckijyunymd zrncalckijyunymd}</td><td>（連携用）計算基準年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntumitatedzndk zrntumitatedzndk}</td><td>（連携用）積立Ｄ残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntumitatedzndkhunouhyj zrntumitatedzndkhunouhyj}</td><td>（連携用）積立Ｄ残高計算不能表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenatkihyj zrndairitenatkihyj}</td><td>（連携用）代理店扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantou1sisyacd zrntantou1sisyacd}</td><td>（連携用）担当１支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantou1sibucd zrntantou1sibucd}</td><td>（連携用）担当１支部コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantou1kojincd zrntantou1kojincd}</td><td>（連携用）担当１個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantou1tantoukaisiymd zrntantou1tantoukaisiymd}</td><td>（連携用）担当１担当開始年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantou1tantousyakbn zrntantou1tantousyakbn}</td><td>（連携用）担当１担当者区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantou2sisyacd zrntantou2sisyacd}</td><td>（連携用）担当２支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantou2sibucd zrntantou2sibucd}</td><td>（連携用）担当２支部コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantou2kojincd zrntantou2kojincd}</td><td>（連携用）担当２個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantou2tantoukaisiymd zrntantou2tantoukaisiymd}</td><td>（連携用）担当２担当開始年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntantou2tantousyakbn zrntantou2tantousyakbn}</td><td>（連携用）担当２担当者区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikijikbn zrnsikijikbn}</td><td>（連携用）職事区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikyou1sosikicd zrnteikyou1sosikicd}</td><td>（連携用）情報提供先１組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikyou1kojincd zrnteikyou1kojincd}</td><td>（連携用）情報提供先１個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikyou1tantoukbn zrnteikyou1tantoukbn}</td><td>（連携用）情報提供先１担当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikyou2sosikicd zrnteikyou2sosikicd}</td><td>（連携用）情報提供先２組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikyou2kojincd zrnteikyou2kojincd}</td><td>（連携用）情報提供先２個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikyou2tantoukbn zrnteikyou2tantoukbn}</td><td>（連携用）情報提供先２担当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnadrsyokansisyacd zrnadrsyokansisyacd}</td><td>（連携用）住所所管支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyukjsaki1sosikicd zrnhyukjsaki1sosikicd}</td><td>（連携用）保有計上先１組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyukjsaki1kojincd zrnhyukjsaki1kojincd}</td><td>（連携用）保有計上先１個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyukjsaki1tantoukbn zrnhyukjsaki1tantoukbn}</td><td>（連携用）保有計上先１担当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyukjsaki2sosikicd zrnhyukjsaki2sosikicd}</td><td>（連携用）保有計上先２組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyukjsaki2kojincd zrnhyukjsaki2kojincd}</td><td>（連携用）保有計上先２個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhyukjsaki2tantoukbn zrnhyukjsaki2tantoukbn}</td><td>（連携用）保有計上先２担当区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrninfotysytymd zrninfotysytymd}</td><td>（連携用）情報抽出年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdairiseikyuutkykarihyj zrnstdairiseikyuutkykarihyj}</td><td>（連携用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhouteityotikuhknhyj zrnhouteityotikuhknhyj}</td><td>（連携用）法定貯蓄性保険表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrctservicekbn zrndrctservicekbn}</td><td>（連携用）ダイレクトサービス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhksuhngktkbtknjgnkbn zrnhksuhngktkbtknjgnkbn}</td><td>（連携用）複数変額特別勘定群区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteituukakbn zrnsiteituukakbn}</td><td>（連携用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyouyenhknhentkarihyj zrnmkhyouyenhknhentkarihyj}</td><td>（連携用）目標到達時円建保険変更特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenkhrikmtkarihyj zrnyenkhrikmtkarihyj}</td><td>（連携用）円貨払込特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstigihrikmtkarihyj zrnstigihrikmtkarihyj}</td><td>（連携用）指定外通貨払込特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenshrgksitihsyutkhyj zrnyenshrgksitihsyutkhyj}</td><td>（連携用）円換算支払額最低保証特約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiteituukaharaikomip zrnsiteituukaharaikomip}</td><td>（連携用）指定通貨建払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnhrktuukaharaikomip zrnhrktuukaharaikomip}</td><td>（連携用）払込通貨建払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteituukakihonsx2 zrnsiteituukakihonsx2}</td><td>（連携用）指定通貨建基本Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsiteituukasibous zrnsiteituukasibous}</td><td>（連携用）指定通貨建死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnteikisiharaiarihyj zrnteikisiharaiarihyj}</td><td>（連携用）定期支払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenteikishrkngk zrnyenteikishrkngk}</td><td>（連携用）円換算定期支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiteituukateikishrkngk zrnsiteituukateikishrkngk}</td><td>（連携用）指定通貨建定期支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobiv98 zrnyobiv98}</td><td>（連携用）予備項目Ｖ９８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenkihonhijynbris zrnyenkihonhijynbris}</td><td>（連携用）円換算基本平準払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyenkihonitijibarais zrnyenkihonitijibarais}</td><td>（連携用）円換算基本一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyenkihonhijynbrip zrnyenkihonhijynbrip}</td><td>（連携用）円換算基本平準払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnyenkihonitijibaraip zrnyenkihonitijibaraip}</td><td>（連携用）円換算基本一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntrkkzk1trkarihyj zrntrkkzk1trkarihyj}</td><td>（連携用）登録家族１登録有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntrkkzk2trkarihyj zrntrkkzk2trkarihyj}</td><td>（連携用）登録家族２登録有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyno7keta zrnyno7keta}</td><td>（連携用）郵便番号（７桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv241 zrnyobiv241}</td><td>（連携用）予備項目Ｖ２４１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv26 zrnyobiv26}</td><td>（連携用）予備項目Ｖ２６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv250x2 zrnyobiv250x2}</td><td>（連携用）予備項目Ｖ２５０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv50 zrnyobiv50}</td><td>（連携用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KokyakuYuyuKykmeisaiFRn
 * @see     PKZT_KokyakuYuyuKykmeisaiFRn
 * @see     QZT_KokyakuYuyuKykmeisaiFRn
 * @see     GenQZT_KokyakuYuyuKykmeisaiFRn
 */
@MappedSuperclass
@Table(name=GenZT_KokyakuYuyuKykmeisaiFRn.TABLE_NAME)
@IdClass(value=PKZT_KokyakuYuyuKykmeisaiFRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KokyakuYuyuKykmeisaiFRn extends AbstractExDBEntityForZDB<ZT_KokyakuYuyuKykmeisaiFRn, PKZT_KokyakuYuyuKykmeisaiFRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KokyakuYuyuKykmeisaiFRn";
    public static final String ZRNSEQUENCENO            = "zrnsequenceno";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHRKMNENKANSANP        = "zrnhrkmnenkansanp";
    public static final String ZRNYENGYOUSEKIHOSYOUS    = "zrnyengyousekihosyous";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNSYMTYMD               = "zrnsymtymd";
    public static final String ZRNSYUKEIYAKUKIGOU       = "zrnsyukeiyakukigou";
    public static final String ZRNSYKYKRATESEDAIKBN     = "zrnsykykratesedaikbn";
    public static final String ZRNJYUDKAIGOMEHRTKARIHYJ = "zrnjyudkaigomehrtkarihyj";
    public static final String ZRNPMENTOKUYAKUKBN       = "zrnpmentokuyakukbn";
    public static final String ZRNKYKDRTKYKARIHYJ       = "zrnkykdrtkykarihyj";
    public static final String ZRNYOBIV158              = "zrnyobiv158";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNBSYYM                 = "zrnbsyym";
    public static final String ZRNKNKYKNM18             = "zrnknkyknm18";
    public static final String ZRNKJKYKNM               = "zrnkjkyknm";
    public static final String ZRNKYKSYASEIYMD          = "zrnkyksyaseiymd";
    public static final String ZRNKYKSYANEN3            = "zrnkyksyanen3";
    public static final String ZRNKYKJIKYKSYANEN        = "zrnkykjikyksyanen";
    public static final String ZRNTUUSINSAKIHUMEIHYJ    = "zrntuusinsakihumeihyj";
    public static final String ZRNKIHONTIKUCD           = "zrnkihontikucd";
    public static final String ZRNTODOUHUKENCD          = "zrntodouhukencd";
    public static final String ZRNSIKUTYOUSONCD5        = "zrnsikutyousoncd5";
    public static final String ZRNKJADR62               = "zrnkjadr62";
    public static final String ZRNTELNO                 = "zrntelno";
    public static final String ZRNDAI2TELNO             = "zrndai2telno";
    public static final String ZRNKNHHKNMEI             = "zrnknhhknmei";
    public static final String ZRNKNJHHKNMEI            = "zrnknjhhknmei";
    public static final String ZRNHHKNSEIYMD            = "zrnhhknseiymd";
    public static final String ZRNHHKNNEN               = "zrnhhknnen";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNKYKJIHHKNNEN          = "zrnkykjihhknnen";
    public static final String ZRNMANNENREIKYKHYJ       = "zrnmannenreikykhyj";
    public static final String ZRNKYKSYHHKNSYDOUITUHYOUJI = "zrnkyksyhhknsydouituhyouji";
    public static final String ZRNKYKJYUTIKBN           = "zrnkykjyutikbn";
    public static final String ZRNANNAIFUYOURIYUUKBN    = "zrnannaifuyouriyuukbn";
    public static final String ZRNSYOUMETUCD            = "zrnsyoumetucd";
    public static final String ZRNTORIHIKIKAISIYMD      = "zrntorihikikaisiymd";
    public static final String ZRNPOWERFULHYJ           = "zrnpowerfulhyj";
    public static final String ZRNLARGEHYJ              = "zrnlargehyj";
    public static final String ZRNSYOUHINBUNRUIKBN      = "zrnsyouhinbunruikbn";
    public static final String ZRNSYOUHNNMKBN           = "zrnsyouhnnmkbn";
    public static final String ZRNHKNNMCD               = "zrnhknnmcd";
    public static final String ZRNTKBTHSYUKIKNMANRYOUYM = "zrntkbthsyukiknmanryouym";
    public static final String ZRNLDOWNYM               = "zrnldownym";
    public static final String ZRNHRKMANRYOUYM          = "zrnhrkmanryouym";
    public static final String ZRNMANKIYM               = "zrnmankiym";
    public static final String ZRNSYKYKYOTEIRIRITU      = "zrnsykykyoteiriritu";
    public static final String ZRNRSERIESHYJ            = "zrnrserieshyj";
    public static final String ZRNDUKETORIHOUHOUKBN     = "zrnduketorihouhoukbn";
    public static final String ZRNINFOTEIKYOUTSGHYJ     = "zrninfoteikyoutsghyj";
    public static final String ZRNNAIMITUKYKHYJ         = "zrnnaimitukykhyj";
    public static final String ZRNMRARIHYJ              = "zrnmrarihyj";
    public static final String ZRNKASITUKENAIMITUHYJ    = "zrnkasitukenaimituhyj";
    public static final String ZRNTTDKTYUUIARIHYJ       = "zrnttdktyuuiarihyj";
    public static final String ZRNTTDKTYUUISETKACD1     = "zrnttdktyuuisetkacd1";
    public static final String ZRNTTDKTYUUISETYMD1      = "zrnttdktyuuisetymd1";
    public static final String ZRNTTDKTYUUISETKBN1      = "zrnttdktyuuisetkbn1";
    public static final String ZRNTTDKTYUUISETKACD2     = "zrnttdktyuuisetkacd2";
    public static final String ZRNTTDKTYUUISETYMD2      = "zrnttdktyuuisetymd2";
    public static final String ZRNTTDKTYUUISETKBN2      = "zrnttdktyuuisetkbn2";
    public static final String ZRNTTDKTYUUI3KENIJYOUHYJ = "zrnttdktyuui3kenijyouhyj";
    public static final String ZRNSENTAKUJYOUHOUARIHYOUJI = "zrnsentakujyouhouarihyouji";
    public static final String ZRNSTKNSETKYKHYJ         = "zrnstknsetkykhyj";
    public static final String ZRNYENHARAIKOMIP         = "zrnyenharaikomip";
    public static final String ZRNYENKIHONS             = "zrnyenkihons";
    public static final String ZRNYENSIBOUS             = "zrnyensibous";
    public static final String ZRNHRKHUHUKBN            = "zrnhrkhuhukbn";
    public static final String ZRNSYUUNOUKEIROKBN       = "zrnsyuunoukeirokbn";
    public static final String ZRNCALCKIJYUNYMD         = "zrncalckijyunymd";
    public static final String ZRNTUMITATEDZNDK         = "zrntumitatedzndk";
    public static final String ZRNTUMITATEDZNDKHUNOUHYJ = "zrntumitatedzndkhunouhyj";
    public static final String ZRNDAIRITENATKIHYJ       = "zrndairitenatkihyj";
    public static final String ZRNTANTOU1SISYACD        = "zrntantou1sisyacd";
    public static final String ZRNTANTOU1SIBUCD         = "zrntantou1sibucd";
    public static final String ZRNTANTOU1KOJINCD        = "zrntantou1kojincd";
    public static final String ZRNTANTOU1TANTOUKAISIYMD = "zrntantou1tantoukaisiymd";
    public static final String ZRNTANTOU1TANTOUSYAKBN   = "zrntantou1tantousyakbn";
    public static final String ZRNTANTOU2SISYACD        = "zrntantou2sisyacd";
    public static final String ZRNTANTOU2SIBUCD         = "zrntantou2sibucd";
    public static final String ZRNTANTOU2KOJINCD        = "zrntantou2kojincd";
    public static final String ZRNTANTOU2TANTOUKAISIYMD = "zrntantou2tantoukaisiymd";
    public static final String ZRNTANTOU2TANTOUSYAKBN   = "zrntantou2tantousyakbn";
    public static final String ZRNSIKIJIKBN             = "zrnsikijikbn";
    public static final String ZRNTEIKYOU1SOSIKICD      = "zrnteikyou1sosikicd";
    public static final String ZRNTEIKYOU1KOJINCD       = "zrnteikyou1kojincd";
    public static final String ZRNTEIKYOU1TANTOUKBN     = "zrnteikyou1tantoukbn";
    public static final String ZRNTEIKYOU2SOSIKICD      = "zrnteikyou2sosikicd";
    public static final String ZRNTEIKYOU2KOJINCD       = "zrnteikyou2kojincd";
    public static final String ZRNTEIKYOU2TANTOUKBN     = "zrnteikyou2tantoukbn";
    public static final String ZRNADRSYOKANSISYACD      = "zrnadrsyokansisyacd";
    public static final String ZRNHYUKJSAKI1SOSIKICD    = "zrnhyukjsaki1sosikicd";
    public static final String ZRNHYUKJSAKI1KOJINCD     = "zrnhyukjsaki1kojincd";
    public static final String ZRNHYUKJSAKI1TANTOUKBN   = "zrnhyukjsaki1tantoukbn";
    public static final String ZRNHYUKJSAKI2SOSIKICD    = "zrnhyukjsaki2sosikicd";
    public static final String ZRNHYUKJSAKI2KOJINCD     = "zrnhyukjsaki2kojincd";
    public static final String ZRNHYUKJSAKI2TANTOUKBN   = "zrnhyukjsaki2tantoukbn";
    public static final String ZRNINFOTYSYTYMD          = "zrninfotysytymd";
    public static final String ZRNSTDAIRISEIKYUUTKYKARIHYJ = "zrnstdairiseikyuutkykarihyj";
    public static final String ZRNHOUTEITYOTIKUHKNHYJ   = "zrnhouteityotikuhknhyj";
    public static final String ZRNDRCTSERVICEKBN        = "zrndrctservicekbn";
    public static final String ZRNHKSUHNGKTKBTKNJGNKBN  = "zrnhksuhngktkbtknjgnkbn";
    public static final String ZRNSITEITUUKAKBN         = "zrnsiteituukakbn";
    public static final String ZRNMKHYOUYENHKNHENTKARIHYJ = "zrnmkhyouyenhknhentkarihyj";
    public static final String ZRNYENKHRIKMTKARIHYJ     = "zrnyenkhrikmtkarihyj";
    public static final String ZRNSTIGIHRIKMTKARIHYJ    = "zrnstigihrikmtkarihyj";
    public static final String ZRNYENSHRGKSITIHSYUTKHYJ = "zrnyenshrgksitihsyutkhyj";
    public static final String ZRNSITEITUUKAHARAIKOMIP  = "zrnsiteituukaharaikomip";
    public static final String ZRNHRKTUUKAHARAIKOMIP    = "zrnhrktuukaharaikomip";
    public static final String ZRNSITEITUUKAKIHONSX2    = "zrnsiteituukakihonsx2";
    public static final String ZRNSITEITUUKASIBOUS      = "zrnsiteituukasibous";
    public static final String ZRNTEIKISIHARAIARIHYJ    = "zrnteikisiharaiarihyj";
    public static final String ZRNYENTEIKISHRKNGK       = "zrnyenteikishrkngk";
    public static final String ZRNSITEITUUKATEIKISHRKNGK = "zrnsiteituukateikishrkngk";
    public static final String ZRNYOBIV98               = "zrnyobiv98";
    public static final String ZRNYENKIHONHIJYNBRIS     = "zrnyenkihonhijynbris";
    public static final String ZRNYENKIHONITIJIBARAIS   = "zrnyenkihonitijibarais";
    public static final String ZRNYENKIHONHIJYNBRIP     = "zrnyenkihonhijynbrip";
    public static final String ZRNYENKIHONITIJIBARAIP   = "zrnyenkihonitijibaraip";
    public static final String ZRNTRKKZK1TRKARIHYJ      = "zrntrkkzk1trkarihyj";
    public static final String ZRNTRKKZK2TRKARIHYJ      = "zrntrkkzk2trkarihyj";
    public static final String ZRNYNO7KETA              = "zrnyno7keta";
    public static final String ZRNYOBIV241              = "zrnyobiv241";
    public static final String ZRNYOBIV26               = "zrnyobiv26";
    public static final String ZRNYOBIV250X2            = "zrnyobiv250x2";
    public static final String ZRNYOBIV50               = "zrnyobiv50";

    private final PKZT_KokyakuYuyuKykmeisaiFRn primaryKey;

    public GenZT_KokyakuYuyuKykmeisaiFRn() {
        primaryKey = new PKZT_KokyakuYuyuKykmeisaiFRn();
    }

    public GenZT_KokyakuYuyuKykmeisaiFRn(Integer pZrnsequenceno) {
        primaryKey = new PKZT_KokyakuYuyuKykmeisaiFRn(pZrnsequenceno);
    }

    @Transient
    @Override
    public PKZT_KokyakuYuyuKykmeisaiFRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KokyakuYuyuKykmeisaiFRn> getMetaClass() {
        return QZT_KokyakuYuyuKykmeisaiFRn.class;
    }

    @Id
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSEQUENCENO)
    public Integer getZrnsequenceno() {
        return getPrimaryKey().getZrnsequenceno();
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        getPrimaryKey().setZrnsequenceno(pZrnsequenceno);
    }

    private String zrnsyono;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private Long zrnhrkmnenkansanp;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHRKMNENKANSANP)
    public Long getZrnhrkmnenkansanp() {
        return zrnhrkmnenkansanp;
    }

    public void setZrnhrkmnenkansanp(Long pZrnhrkmnenkansanp) {
        zrnhrkmnenkansanp = pZrnhrkmnenkansanp;
    }

    private Long zrnyengyousekihosyous;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENGYOUSEKIHOSYOUS)
    public Long getZrnyengyousekihosyous() {
        return zrnyengyousekihosyous;
    }

    public void setZrnyengyousekihosyous(Long pZrnyengyousekihosyous) {
        zrnyengyousekihosyous = pZrnyengyousekihosyous;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private String zrnsymtymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSYMTYMD)
    public String getZrnsymtymd() {
        return zrnsymtymd;
    }

    public void setZrnsymtymd(String pZrnsymtymd) {
        zrnsymtymd = pZrnsymtymd;
    }

    private String zrnsyukeiyakukigou;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSYUKEIYAKUKIGOU)
    public String getZrnsyukeiyakukigou() {
        return zrnsyukeiyakukigou;
    }

    public void setZrnsyukeiyakukigou(String pZrnsyukeiyakukigou) {
        zrnsyukeiyakukigou = pZrnsyukeiyakukigou;
    }

    private String zrnsykykratesedaikbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSYKYKRATESEDAIKBN)
    public String getZrnsykykratesedaikbn() {
        return zrnsykykratesedaikbn;
    }

    public void setZrnsykykratesedaikbn(String pZrnsykykratesedaikbn) {
        zrnsykykratesedaikbn = pZrnsykykratesedaikbn;
    }

    private String zrnjyudkaigomehrtkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNJYUDKAIGOMEHRTKARIHYJ)
    public String getZrnjyudkaigomehrtkarihyj() {
        return zrnjyudkaigomehrtkarihyj;
    }

    public void setZrnjyudkaigomehrtkarihyj(String pZrnjyudkaigomehrtkarihyj) {
        zrnjyudkaigomehrtkarihyj = pZrnjyudkaigomehrtkarihyj;
    }

    private String zrnpmentokuyakukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNPMENTOKUYAKUKBN)
    public String getZrnpmentokuyakukbn() {
        return zrnpmentokuyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmentokuyakukbn(String pZrnpmentokuyakukbn) {
        zrnpmentokuyakukbn = pZrnpmentokuyakukbn;
    }

    private String zrnkykdrtkykarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKYKDRTKYKARIHYJ)
    public String getZrnkykdrtkykarihyj() {
        return zrnkykdrtkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykdrtkykarihyj(String pZrnkykdrtkykarihyj) {
        zrnkykdrtkykarihyj = pZrnkykdrtkykarihyj;
    }

    private String zrnyobiv158;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYOBIV158)
    public String getZrnyobiv158() {
        return zrnyobiv158;
    }

    public void setZrnyobiv158(String pZrnyobiv158) {
        zrnyobiv158 = pZrnyobiv158;
    }

    private String zrnkykymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnbsyym;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNBSYYM)
    public String getZrnbsyym() {
        return zrnbsyym;
    }

    public void setZrnbsyym(String pZrnbsyym) {
        zrnbsyym = pZrnbsyym;
    }

    private String zrnknkyknm18;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKNKYKNM18)
    public String getZrnknkyknm18() {
        return zrnknkyknm18;
    }

    public void setZrnknkyknm18(String pZrnknkyknm18) {
        zrnknkyknm18 = pZrnknkyknm18;
    }

    private String zrnkjkyknm;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKJKYKNM)
    public String getZrnkjkyknm() {
        return zrnkjkyknm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm(String pZrnkjkyknm) {
        zrnkjkyknm = pZrnkjkyknm;
    }

    private String zrnkyksyaseiymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKYKSYASEIYMD)
    public String getZrnkyksyaseiymd() {
        return zrnkyksyaseiymd;
    }

    public void setZrnkyksyaseiymd(String pZrnkyksyaseiymd) {
        zrnkyksyaseiymd = pZrnkyksyaseiymd;
    }

    private String zrnkyksyanen3;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKYKSYANEN3)
    public String getZrnkyksyanen3() {
        return zrnkyksyanen3;
    }

    public void setZrnkyksyanen3(String pZrnkyksyanen3) {
        zrnkyksyanen3 = pZrnkyksyanen3;
    }

    private String zrnkykjikyksyanen;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKYKJIKYKSYANEN)
    public String getZrnkykjikyksyanen() {
        return zrnkykjikyksyanen;
    }

    public void setZrnkykjikyksyanen(String pZrnkykjikyksyanen) {
        zrnkykjikyksyanen = pZrnkykjikyksyanen;
    }

    private String zrntuusinsakihumeihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTUUSINSAKIHUMEIHYJ)
    public String getZrntuusinsakihumeihyj() {
        return zrntuusinsakihumeihyj;
    }

    public void setZrntuusinsakihumeihyj(String pZrntuusinsakihumeihyj) {
        zrntuusinsakihumeihyj = pZrntuusinsakihumeihyj;
    }

    private String zrnkihontikucd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKIHONTIKUCD)
    public String getZrnkihontikucd() {
        return zrnkihontikucd;
    }

    public void setZrnkihontikucd(String pZrnkihontikucd) {
        zrnkihontikucd = pZrnkihontikucd;
    }

    private String zrntodouhukencd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTODOUHUKENCD)
    public String getZrntodouhukencd() {
        return zrntodouhukencd;
    }

    public void setZrntodouhukencd(String pZrntodouhukencd) {
        zrntodouhukencd = pZrntodouhukencd;
    }

    private String zrnsikutyousoncd5;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSIKUTYOUSONCD5)
    public String getZrnsikutyousoncd5() {
        return zrnsikutyousoncd5;
    }

    public void setZrnsikutyousoncd5(String pZrnsikutyousoncd5) {
        zrnsikutyousoncd5 = pZrnsikutyousoncd5;
    }

    private String zrnkjadr62;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKJADR62)
    public String getZrnkjadr62() {
        return zrnkjadr62;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjadr62(String pZrnkjadr62) {
        zrnkjadr62 = pZrnkjadr62;
    }

    private String zrntelno;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTELNO)
    public String getZrntelno() {
        return zrntelno;
    }

    public void setZrntelno(String pZrntelno) {
        zrntelno = pZrntelno;
    }

    private String zrndai2telno;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNDAI2TELNO)
    public String getZrndai2telno() {
        return zrndai2telno;
    }

    public void setZrndai2telno(String pZrndai2telno) {
        zrndai2telno = pZrndai2telno;
    }

    private String zrnknhhknmei;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKNHHKNMEI)
    public String getZrnknhhknmei() {
        return zrnknhhknmei;
    }

    public void setZrnknhhknmei(String pZrnknhhknmei) {
        zrnknhhknmei = pZrnknhhknmei;
    }

    private String zrnknjhhknmei;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKNJHHKNMEI)
    public String getZrnknjhhknmei() {
        return zrnknjhhknmei;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei(String pZrnknjhhknmei) {
        zrnknjhhknmei = pZrnknjhhknmei;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrnhhknnen;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHHKNNEN)
    public String getZrnhhknnen() {
        return zrnhhknnen;
    }

    public void setZrnhhknnen(String pZrnhhknnen) {
        zrnhhknnen = pZrnhhknnen;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnkykjihhknnen;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKYKJIHHKNNEN)
    public String getZrnkykjihhknnen() {
        return zrnkykjihhknnen;
    }

    public void setZrnkykjihhknnen(String pZrnkykjihhknnen) {
        zrnkykjihhknnen = pZrnkykjihhknnen;
    }

    private String zrnmannenreikykhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNMANNENREIKYKHYJ)
    public String getZrnmannenreikykhyj() {
        return zrnmannenreikykhyj;
    }

    public void setZrnmannenreikykhyj(String pZrnmannenreikykhyj) {
        zrnmannenreikykhyj = pZrnmannenreikykhyj;
    }

    private String zrnkyksyhhknsydouituhyouji;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKYKSYHHKNSYDOUITUHYOUJI)
    public String getZrnkyksyhhknsydouituhyouji() {
        return zrnkyksyhhknsydouituhyouji;
    }

    public void setZrnkyksyhhknsydouituhyouji(String pZrnkyksyhhknsydouituhyouji) {
        zrnkyksyhhknsydouituhyouji = pZrnkyksyhhknsydouituhyouji;
    }

    private String zrnkykjyutikbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKYKJYUTIKBN)
    public String getZrnkykjyutikbn() {
        return zrnkykjyutikbn;
    }

    public void setZrnkykjyutikbn(String pZrnkykjyutikbn) {
        zrnkykjyutikbn = pZrnkykjyutikbn;
    }

    private String zrnannaifuyouriyuukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNANNAIFUYOURIYUUKBN)
    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }

    private String zrnsyoumetucd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSYOUMETUCD)
    public String getZrnsyoumetucd() {
        return zrnsyoumetucd;
    }

    public void setZrnsyoumetucd(String pZrnsyoumetucd) {
        zrnsyoumetucd = pZrnsyoumetucd;
    }

    private String zrntorihikikaisiymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTORIHIKIKAISIYMD)
    public String getZrntorihikikaisiymd() {
        return zrntorihikikaisiymd;
    }

    public void setZrntorihikikaisiymd(String pZrntorihikikaisiymd) {
        zrntorihikikaisiymd = pZrntorihikikaisiymd;
    }

    private String zrnpowerfulhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNPOWERFULHYJ)
    public String getZrnpowerfulhyj() {
        return zrnpowerfulhyj;
    }

    public void setZrnpowerfulhyj(String pZrnpowerfulhyj) {
        zrnpowerfulhyj = pZrnpowerfulhyj;
    }

    private String zrnlargehyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNLARGEHYJ)
    public String getZrnlargehyj() {
        return zrnlargehyj;
    }

    public void setZrnlargehyj(String pZrnlargehyj) {
        zrnlargehyj = pZrnlargehyj;
    }

    private String zrnsyouhinbunruikbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSYOUHINBUNRUIKBN)
    public String getZrnsyouhinbunruikbn() {
        return zrnsyouhinbunruikbn;
    }

    public void setZrnsyouhinbunruikbn(String pZrnsyouhinbunruikbn) {
        zrnsyouhinbunruikbn = pZrnsyouhinbunruikbn;
    }

    private String zrnsyouhnnmkbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSYOUHNNMKBN)
    public String getZrnsyouhnnmkbn() {
        return zrnsyouhnnmkbn;
    }

    public void setZrnsyouhnnmkbn(String pZrnsyouhnnmkbn) {
        zrnsyouhnnmkbn = pZrnsyouhnnmkbn;
    }

    private String zrnhknnmcd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHKNNMCD)
    public String getZrnhknnmcd() {
        return zrnhknnmcd;
    }

    public void setZrnhknnmcd(String pZrnhknnmcd) {
        zrnhknnmcd = pZrnhknnmcd;
    }

    private String zrntkbthsyukiknmanryouym;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTKBTHSYUKIKNMANRYOUYM)
    public String getZrntkbthsyukiknmanryouym() {
        return zrntkbthsyukiknmanryouym;
    }

    public void setZrntkbthsyukiknmanryouym(String pZrntkbthsyukiknmanryouym) {
        zrntkbthsyukiknmanryouym = pZrntkbthsyukiknmanryouym;
    }

    private String zrnldownym;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNLDOWNYM)
    public String getZrnldownym() {
        return zrnldownym;
    }

    public void setZrnldownym(String pZrnldownym) {
        zrnldownym = pZrnldownym;
    }

    private String zrnhrkmanryouym;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHRKMANRYOUYM)
    public String getZrnhrkmanryouym() {
        return zrnhrkmanryouym;
    }

    public void setZrnhrkmanryouym(String pZrnhrkmanryouym) {
        zrnhrkmanryouym = pZrnhrkmanryouym;
    }

    private String zrnmankiym;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNMANKIYM)
    public String getZrnmankiym() {
        return zrnmankiym;
    }

    public void setZrnmankiym(String pZrnmankiym) {
        zrnmankiym = pZrnmankiym;
    }

    private BizNumber zrnsykykyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSYKYKYOTEIRIRITU)
    public BizNumber getZrnsykykyoteiriritu() {
        return zrnsykykyoteiriritu;
    }

    public void setZrnsykykyoteiriritu(BizNumber pZrnsykykyoteiriritu) {
        zrnsykykyoteiriritu = pZrnsykykyoteiriritu;
    }

    private String zrnrserieshyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNRSERIESHYJ)
    public String getZrnrserieshyj() {
        return zrnrserieshyj;
    }

    public void setZrnrserieshyj(String pZrnrserieshyj) {
        zrnrserieshyj = pZrnrserieshyj;
    }

    private String zrnduketorihouhoukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNDUKETORIHOUHOUKBN)
    public String getZrnduketorihouhoukbn() {
        return zrnduketorihouhoukbn;
    }

    public void setZrnduketorihouhoukbn(String pZrnduketorihouhoukbn) {
        zrnduketorihouhoukbn = pZrnduketorihouhoukbn;
    }

    private String zrninfoteikyoutsghyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNINFOTEIKYOUTSGHYJ)
    public String getZrninfoteikyoutsghyj() {
        return zrninfoteikyoutsghyj;
    }

    public void setZrninfoteikyoutsghyj(String pZrninfoteikyoutsghyj) {
        zrninfoteikyoutsghyj = pZrninfoteikyoutsghyj;
    }

    private String zrnnaimitukykhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNNAIMITUKYKHYJ)
    public String getZrnnaimitukykhyj() {
        return zrnnaimitukykhyj;
    }

    public void setZrnnaimitukykhyj(String pZrnnaimitukykhyj) {
        zrnnaimitukykhyj = pZrnnaimitukykhyj;
    }

    private String zrnmrarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNMRARIHYJ)
    public String getZrnmrarihyj() {
        return zrnmrarihyj;
    }

    public void setZrnmrarihyj(String pZrnmrarihyj) {
        zrnmrarihyj = pZrnmrarihyj;
    }

    private String zrnkasitukenaimituhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNKASITUKENAIMITUHYJ)
    public String getZrnkasitukenaimituhyj() {
        return zrnkasitukenaimituhyj;
    }

    public void setZrnkasitukenaimituhyj(String pZrnkasitukenaimituhyj) {
        zrnkasitukenaimituhyj = pZrnkasitukenaimituhyj;
    }

    private String zrnttdktyuuiarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTTDKTYUUIARIHYJ)
    public String getZrnttdktyuuiarihyj() {
        return zrnttdktyuuiarihyj;
    }

    public void setZrnttdktyuuiarihyj(String pZrnttdktyuuiarihyj) {
        zrnttdktyuuiarihyj = pZrnttdktyuuiarihyj;
    }

    private String zrnttdktyuuisetkacd1;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTTDKTYUUISETKACD1)
    public String getZrnttdktyuuisetkacd1() {
        return zrnttdktyuuisetkacd1;
    }

    public void setZrnttdktyuuisetkacd1(String pZrnttdktyuuisetkacd1) {
        zrnttdktyuuisetkacd1 = pZrnttdktyuuisetkacd1;
    }

    private String zrnttdktyuuisetymd1;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTTDKTYUUISETYMD1)
    public String getZrnttdktyuuisetymd1() {
        return zrnttdktyuuisetymd1;
    }

    public void setZrnttdktyuuisetymd1(String pZrnttdktyuuisetymd1) {
        zrnttdktyuuisetymd1 = pZrnttdktyuuisetymd1;
    }

    private String zrnttdktyuuisetkbn1;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTTDKTYUUISETKBN1)
    public String getZrnttdktyuuisetkbn1() {
        return zrnttdktyuuisetkbn1;
    }

    public void setZrnttdktyuuisetkbn1(String pZrnttdktyuuisetkbn1) {
        zrnttdktyuuisetkbn1 = pZrnttdktyuuisetkbn1;
    }

    private String zrnttdktyuuisetkacd2;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTTDKTYUUISETKACD2)
    public String getZrnttdktyuuisetkacd2() {
        return zrnttdktyuuisetkacd2;
    }

    public void setZrnttdktyuuisetkacd2(String pZrnttdktyuuisetkacd2) {
        zrnttdktyuuisetkacd2 = pZrnttdktyuuisetkacd2;
    }

    private String zrnttdktyuuisetymd2;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTTDKTYUUISETYMD2)
    public String getZrnttdktyuuisetymd2() {
        return zrnttdktyuuisetymd2;
    }

    public void setZrnttdktyuuisetymd2(String pZrnttdktyuuisetymd2) {
        zrnttdktyuuisetymd2 = pZrnttdktyuuisetymd2;
    }

    private String zrnttdktyuuisetkbn2;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTTDKTYUUISETKBN2)
    public String getZrnttdktyuuisetkbn2() {
        return zrnttdktyuuisetkbn2;
    }

    public void setZrnttdktyuuisetkbn2(String pZrnttdktyuuisetkbn2) {
        zrnttdktyuuisetkbn2 = pZrnttdktyuuisetkbn2;
    }

    private String zrnttdktyuui3kenijyouhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTTDKTYUUI3KENIJYOUHYJ)
    public String getZrnttdktyuui3kenijyouhyj() {
        return zrnttdktyuui3kenijyouhyj;
    }

    public void setZrnttdktyuui3kenijyouhyj(String pZrnttdktyuui3kenijyouhyj) {
        zrnttdktyuui3kenijyouhyj = pZrnttdktyuui3kenijyouhyj;
    }

    private String zrnsentakujyouhouarihyouji;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSENTAKUJYOUHOUARIHYOUJI)
    public String getZrnsentakujyouhouarihyouji() {
        return zrnsentakujyouhouarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsentakujyouhouarihyouji(String pZrnsentakujyouhouarihyouji) {
        zrnsentakujyouhouarihyouji = pZrnsentakujyouhouarihyouji;
    }

    private String zrnstknsetkykhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSTKNSETKYKHYJ)
    public String getZrnstknsetkykhyj() {
        return zrnstknsetkykhyj;
    }

    public void setZrnstknsetkykhyj(String pZrnstknsetkykhyj) {
        zrnstknsetkykhyj = pZrnstknsetkykhyj;
    }

    private Long zrnyenharaikomip;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENHARAIKOMIP)
    public Long getZrnyenharaikomip() {
        return zrnyenharaikomip;
    }

    public void setZrnyenharaikomip(Long pZrnyenharaikomip) {
        zrnyenharaikomip = pZrnyenharaikomip;
    }

    private Long zrnyenkihons;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENKIHONS)
    public Long getZrnyenkihons() {
        return zrnyenkihons;
    }

    public void setZrnyenkihons(Long pZrnyenkihons) {
        zrnyenkihons = pZrnyenkihons;
    }

    private Long zrnyensibous;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENSIBOUS)
    public Long getZrnyensibous() {
        return zrnyensibous;
    }

    public void setZrnyensibous(Long pZrnyensibous) {
        zrnyensibous = pZrnyensibous;
    }

    private String zrnhrkhuhukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHRKHUHUKBN)
    public String getZrnhrkhuhukbn() {
        return zrnhrkhuhukbn;
    }

    public void setZrnhrkhuhukbn(String pZrnhrkhuhukbn) {
        zrnhrkhuhukbn = pZrnhrkhuhukbn;
    }

    private String zrnsyuunoukeirokbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSYUUNOUKEIROKBN)
    public String getZrnsyuunoukeirokbn() {
        return zrnsyuunoukeirokbn;
    }

    public void setZrnsyuunoukeirokbn(String pZrnsyuunoukeirokbn) {
        zrnsyuunoukeirokbn = pZrnsyuunoukeirokbn;
    }

    private String zrncalckijyunymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNCALCKIJYUNYMD)
    public String getZrncalckijyunymd() {
        return zrncalckijyunymd;
    }

    public void setZrncalckijyunymd(String pZrncalckijyunymd) {
        zrncalckijyunymd = pZrncalckijyunymd;
    }

    private Long zrntumitatedzndk;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTUMITATEDZNDK)
    public Long getZrntumitatedzndk() {
        return zrntumitatedzndk;
    }

    public void setZrntumitatedzndk(Long pZrntumitatedzndk) {
        zrntumitatedzndk = pZrntumitatedzndk;
    }

    private String zrntumitatedzndkhunouhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTUMITATEDZNDKHUNOUHYJ)
    public String getZrntumitatedzndkhunouhyj() {
        return zrntumitatedzndkhunouhyj;
    }

    public void setZrntumitatedzndkhunouhyj(String pZrntumitatedzndkhunouhyj) {
        zrntumitatedzndkhunouhyj = pZrntumitatedzndkhunouhyj;
    }

    private String zrndairitenatkihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNDAIRITENATKIHYJ)
    public String getZrndairitenatkihyj() {
        return zrndairitenatkihyj;
    }

    public void setZrndairitenatkihyj(String pZrndairitenatkihyj) {
        zrndairitenatkihyj = pZrndairitenatkihyj;
    }

    private String zrntantou1sisyacd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTANTOU1SISYACD)
    public String getZrntantou1sisyacd() {
        return zrntantou1sisyacd;
    }

    public void setZrntantou1sisyacd(String pZrntantou1sisyacd) {
        zrntantou1sisyacd = pZrntantou1sisyacd;
    }

    private String zrntantou1sibucd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTANTOU1SIBUCD)
    public String getZrntantou1sibucd() {
        return zrntantou1sibucd;
    }

    public void setZrntantou1sibucd(String pZrntantou1sibucd) {
        zrntantou1sibucd = pZrntantou1sibucd;
    }

    private String zrntantou1kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTANTOU1KOJINCD)
    public String getZrntantou1kojincd() {
        return zrntantou1kojincd;
    }

    public void setZrntantou1kojincd(String pZrntantou1kojincd) {
        zrntantou1kojincd = pZrntantou1kojincd;
    }

    private String zrntantou1tantoukaisiymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTANTOU1TANTOUKAISIYMD)
    public String getZrntantou1tantoukaisiymd() {
        return zrntantou1tantoukaisiymd;
    }

    public void setZrntantou1tantoukaisiymd(String pZrntantou1tantoukaisiymd) {
        zrntantou1tantoukaisiymd = pZrntantou1tantoukaisiymd;
    }

    private String zrntantou1tantousyakbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTANTOU1TANTOUSYAKBN)
    public String getZrntantou1tantousyakbn() {
        return zrntantou1tantousyakbn;
    }

    public void setZrntantou1tantousyakbn(String pZrntantou1tantousyakbn) {
        zrntantou1tantousyakbn = pZrntantou1tantousyakbn;
    }

    private String zrntantou2sisyacd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTANTOU2SISYACD)
    public String getZrntantou2sisyacd() {
        return zrntantou2sisyacd;
    }

    public void setZrntantou2sisyacd(String pZrntantou2sisyacd) {
        zrntantou2sisyacd = pZrntantou2sisyacd;
    }

    private String zrntantou2sibucd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTANTOU2SIBUCD)
    public String getZrntantou2sibucd() {
        return zrntantou2sibucd;
    }

    public void setZrntantou2sibucd(String pZrntantou2sibucd) {
        zrntantou2sibucd = pZrntantou2sibucd;
    }

    private String zrntantou2kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTANTOU2KOJINCD)
    public String getZrntantou2kojincd() {
        return zrntantou2kojincd;
    }

    public void setZrntantou2kojincd(String pZrntantou2kojincd) {
        zrntantou2kojincd = pZrntantou2kojincd;
    }

    private String zrntantou2tantoukaisiymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTANTOU2TANTOUKAISIYMD)
    public String getZrntantou2tantoukaisiymd() {
        return zrntantou2tantoukaisiymd;
    }

    public void setZrntantou2tantoukaisiymd(String pZrntantou2tantoukaisiymd) {
        zrntantou2tantoukaisiymd = pZrntantou2tantoukaisiymd;
    }

    private String zrntantou2tantousyakbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTANTOU2TANTOUSYAKBN)
    public String getZrntantou2tantousyakbn() {
        return zrntantou2tantousyakbn;
    }

    public void setZrntantou2tantousyakbn(String pZrntantou2tantousyakbn) {
        zrntantou2tantousyakbn = pZrntantou2tantousyakbn;
    }

    private String zrnsikijikbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSIKIJIKBN)
    public String getZrnsikijikbn() {
        return zrnsikijikbn;
    }

    public void setZrnsikijikbn(String pZrnsikijikbn) {
        zrnsikijikbn = pZrnsikijikbn;
    }

    private String zrnteikyou1sosikicd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTEIKYOU1SOSIKICD)
    public String getZrnteikyou1sosikicd() {
        return zrnteikyou1sosikicd;
    }

    public void setZrnteikyou1sosikicd(String pZrnteikyou1sosikicd) {
        zrnteikyou1sosikicd = pZrnteikyou1sosikicd;
    }

    private String zrnteikyou1kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTEIKYOU1KOJINCD)
    public String getZrnteikyou1kojincd() {
        return zrnteikyou1kojincd;
    }

    public void setZrnteikyou1kojincd(String pZrnteikyou1kojincd) {
        zrnteikyou1kojincd = pZrnteikyou1kojincd;
    }

    private String zrnteikyou1tantoukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTEIKYOU1TANTOUKBN)
    public String getZrnteikyou1tantoukbn() {
        return zrnteikyou1tantoukbn;
    }

    public void setZrnteikyou1tantoukbn(String pZrnteikyou1tantoukbn) {
        zrnteikyou1tantoukbn = pZrnteikyou1tantoukbn;
    }

    private String zrnteikyou2sosikicd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTEIKYOU2SOSIKICD)
    public String getZrnteikyou2sosikicd() {
        return zrnteikyou2sosikicd;
    }

    public void setZrnteikyou2sosikicd(String pZrnteikyou2sosikicd) {
        zrnteikyou2sosikicd = pZrnteikyou2sosikicd;
    }

    private String zrnteikyou2kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTEIKYOU2KOJINCD)
    public String getZrnteikyou2kojincd() {
        return zrnteikyou2kojincd;
    }

    public void setZrnteikyou2kojincd(String pZrnteikyou2kojincd) {
        zrnteikyou2kojincd = pZrnteikyou2kojincd;
    }

    private String zrnteikyou2tantoukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTEIKYOU2TANTOUKBN)
    public String getZrnteikyou2tantoukbn() {
        return zrnteikyou2tantoukbn;
    }

    public void setZrnteikyou2tantoukbn(String pZrnteikyou2tantoukbn) {
        zrnteikyou2tantoukbn = pZrnteikyou2tantoukbn;
    }

    private String zrnadrsyokansisyacd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNADRSYOKANSISYACD)
    public String getZrnadrsyokansisyacd() {
        return zrnadrsyokansisyacd;
    }

    public void setZrnadrsyokansisyacd(String pZrnadrsyokansisyacd) {
        zrnadrsyokansisyacd = pZrnadrsyokansisyacd;
    }

    private String zrnhyukjsaki1sosikicd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHYUKJSAKI1SOSIKICD)
    public String getZrnhyukjsaki1sosikicd() {
        return zrnhyukjsaki1sosikicd;
    }

    public void setZrnhyukjsaki1sosikicd(String pZrnhyukjsaki1sosikicd) {
        zrnhyukjsaki1sosikicd = pZrnhyukjsaki1sosikicd;
    }

    private String zrnhyukjsaki1kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHYUKJSAKI1KOJINCD)
    public String getZrnhyukjsaki1kojincd() {
        return zrnhyukjsaki1kojincd;
    }

    public void setZrnhyukjsaki1kojincd(String pZrnhyukjsaki1kojincd) {
        zrnhyukjsaki1kojincd = pZrnhyukjsaki1kojincd;
    }

    private String zrnhyukjsaki1tantoukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHYUKJSAKI1TANTOUKBN)
    public String getZrnhyukjsaki1tantoukbn() {
        return zrnhyukjsaki1tantoukbn;
    }

    public void setZrnhyukjsaki1tantoukbn(String pZrnhyukjsaki1tantoukbn) {
        zrnhyukjsaki1tantoukbn = pZrnhyukjsaki1tantoukbn;
    }

    private String zrnhyukjsaki2sosikicd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHYUKJSAKI2SOSIKICD)
    public String getZrnhyukjsaki2sosikicd() {
        return zrnhyukjsaki2sosikicd;
    }

    public void setZrnhyukjsaki2sosikicd(String pZrnhyukjsaki2sosikicd) {
        zrnhyukjsaki2sosikicd = pZrnhyukjsaki2sosikicd;
    }

    private String zrnhyukjsaki2kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHYUKJSAKI2KOJINCD)
    public String getZrnhyukjsaki2kojincd() {
        return zrnhyukjsaki2kojincd;
    }

    public void setZrnhyukjsaki2kojincd(String pZrnhyukjsaki2kojincd) {
        zrnhyukjsaki2kojincd = pZrnhyukjsaki2kojincd;
    }

    private String zrnhyukjsaki2tantoukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHYUKJSAKI2TANTOUKBN)
    public String getZrnhyukjsaki2tantoukbn() {
        return zrnhyukjsaki2tantoukbn;
    }

    public void setZrnhyukjsaki2tantoukbn(String pZrnhyukjsaki2tantoukbn) {
        zrnhyukjsaki2tantoukbn = pZrnhyukjsaki2tantoukbn;
    }

    private String zrninfotysytymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNINFOTYSYTYMD)
    public String getZrninfotysytymd() {
        return zrninfotysytymd;
    }

    public void setZrninfotysytymd(String pZrninfotysytymd) {
        zrninfotysytymd = pZrninfotysytymd;
    }

    private String zrnstdairiseikyuutkykarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZrnstdairiseikyuutkykarihyj() {
        return zrnstdairiseikyuutkykarihyj;
    }

    public void setZrnstdairiseikyuutkykarihyj(String pZrnstdairiseikyuutkykarihyj) {
        zrnstdairiseikyuutkykarihyj = pZrnstdairiseikyuutkykarihyj;
    }

    private String zrnhouteityotikuhknhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHOUTEITYOTIKUHKNHYJ)
    public String getZrnhouteityotikuhknhyj() {
        return zrnhouteityotikuhknhyj;
    }

    public void setZrnhouteityotikuhknhyj(String pZrnhouteityotikuhknhyj) {
        zrnhouteityotikuhknhyj = pZrnhouteityotikuhknhyj;
    }

    private String zrndrctservicekbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNDRCTSERVICEKBN)
    public String getZrndrctservicekbn() {
        return zrndrctservicekbn;
    }

    public void setZrndrctservicekbn(String pZrndrctservicekbn) {
        zrndrctservicekbn = pZrndrctservicekbn;
    }

    private String zrnhksuhngktkbtknjgnkbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHKSUHNGKTKBTKNJGNKBN)
    public String getZrnhksuhngktkbtknjgnkbn() {
        return zrnhksuhngktkbtknjgnkbn;
    }

    public void setZrnhksuhngktkbtknjgnkbn(String pZrnhksuhngktkbtknjgnkbn) {
        zrnhksuhngktkbtknjgnkbn = pZrnhksuhngktkbtknjgnkbn;
    }

    private String zrnsiteituukakbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSITEITUUKAKBN)
    public String getZrnsiteituukakbn() {
        return zrnsiteituukakbn;
    }

    public void setZrnsiteituukakbn(String pZrnsiteituukakbn) {
        zrnsiteituukakbn = pZrnsiteituukakbn;
    }

    private String zrnmkhyouyenhknhentkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNMKHYOUYENHKNHENTKARIHYJ)
    public String getZrnmkhyouyenhknhentkarihyj() {
        return zrnmkhyouyenhknhentkarihyj;
    }

    public void setZrnmkhyouyenhknhentkarihyj(String pZrnmkhyouyenhknhentkarihyj) {
        zrnmkhyouyenhknhentkarihyj = pZrnmkhyouyenhknhentkarihyj;
    }

    private String zrnyenkhrikmtkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENKHRIKMTKARIHYJ)
    public String getZrnyenkhrikmtkarihyj() {
        return zrnyenkhrikmtkarihyj;
    }

    public void setZrnyenkhrikmtkarihyj(String pZrnyenkhrikmtkarihyj) {
        zrnyenkhrikmtkarihyj = pZrnyenkhrikmtkarihyj;
    }

    private String zrnstigihrikmtkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSTIGIHRIKMTKARIHYJ)
    public String getZrnstigihrikmtkarihyj() {
        return zrnstigihrikmtkarihyj;
    }

    public void setZrnstigihrikmtkarihyj(String pZrnstigihrikmtkarihyj) {
        zrnstigihrikmtkarihyj = pZrnstigihrikmtkarihyj;
    }

    private String zrnyenshrgksitihsyutkhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENSHRGKSITIHSYUTKHYJ)
    public String getZrnyenshrgksitihsyutkhyj() {
        return zrnyenshrgksitihsyutkhyj;
    }

    public void setZrnyenshrgksitihsyutkhyj(String pZrnyenshrgksitihsyutkhyj) {
        zrnyenshrgksitihsyutkhyj = pZrnyenshrgksitihsyutkhyj;
    }

    private BizNumber zrnsiteituukaharaikomip;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSITEITUUKAHARAIKOMIP)
    public BizNumber getZrnsiteituukaharaikomip() {
        return zrnsiteituukaharaikomip;
    }

    public void setZrnsiteituukaharaikomip(BizNumber pZrnsiteituukaharaikomip) {
        zrnsiteituukaharaikomip = pZrnsiteituukaharaikomip;
    }

    private Long zrnhrktuukaharaikomip;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNHRKTUUKAHARAIKOMIP)
    public Long getZrnhrktuukaharaikomip() {
        return zrnhrktuukaharaikomip;
    }

    public void setZrnhrktuukaharaikomip(Long pZrnhrktuukaharaikomip) {
        zrnhrktuukaharaikomip = pZrnhrktuukaharaikomip;
    }

    private BizNumber zrnsiteituukakihonsx2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSITEITUUKAKIHONSX2)
    public BizNumber getZrnsiteituukakihonsx2() {
        return zrnsiteituukakihonsx2;
    }

    public void setZrnsiteituukakihonsx2(BizNumber pZrnsiteituukakihonsx2) {
        zrnsiteituukakihonsx2 = pZrnsiteituukakihonsx2;
    }

    private BizNumber zrnsiteituukasibous;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSITEITUUKASIBOUS)
    public BizNumber getZrnsiteituukasibous() {
        return zrnsiteituukasibous;
    }

    public void setZrnsiteituukasibous(BizNumber pZrnsiteituukasibous) {
        zrnsiteituukasibous = pZrnsiteituukasibous;
    }

    private String zrnteikisiharaiarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTEIKISIHARAIARIHYJ)
    public String getZrnteikisiharaiarihyj() {
        return zrnteikisiharaiarihyj;
    }

    public void setZrnteikisiharaiarihyj(String pZrnteikisiharaiarihyj) {
        zrnteikisiharaiarihyj = pZrnteikisiharaiarihyj;
    }

    private Long zrnyenteikishrkngk;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENTEIKISHRKNGK)
    public Long getZrnyenteikishrkngk() {
        return zrnyenteikishrkngk;
    }

    public void setZrnyenteikishrkngk(Long pZrnyenteikishrkngk) {
        zrnyenteikishrkngk = pZrnyenteikishrkngk;
    }

    private BizNumber zrnsiteituukateikishrkngk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNSITEITUUKATEIKISHRKNGK)
    public BizNumber getZrnsiteituukateikishrkngk() {
        return zrnsiteituukateikishrkngk;
    }

    public void setZrnsiteituukateikishrkngk(BizNumber pZrnsiteituukateikishrkngk) {
        zrnsiteituukateikishrkngk = pZrnsiteituukateikishrkngk;
    }

    private String zrnyobiv98;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYOBIV98)
    public String getZrnyobiv98() {
        return zrnyobiv98;
    }

    public void setZrnyobiv98(String pZrnyobiv98) {
        zrnyobiv98 = pZrnyobiv98;
    }

    private Long zrnyenkihonhijynbris;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENKIHONHIJYNBRIS)
    public Long getZrnyenkihonhijynbris() {
        return zrnyenkihonhijynbris;
    }

    public void setZrnyenkihonhijynbris(Long pZrnyenkihonhijynbris) {
        zrnyenkihonhijynbris = pZrnyenkihonhijynbris;
    }

    private Long zrnyenkihonitijibarais;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENKIHONITIJIBARAIS)
    public Long getZrnyenkihonitijibarais() {
        return zrnyenkihonitijibarais;
    }

    public void setZrnyenkihonitijibarais(Long pZrnyenkihonitijibarais) {
        zrnyenkihonitijibarais = pZrnyenkihonitijibarais;
    }

    private Long zrnyenkihonhijynbrip;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENKIHONHIJYNBRIP)
    public Long getZrnyenkihonhijynbrip() {
        return zrnyenkihonhijynbrip;
    }

    public void setZrnyenkihonhijynbrip(Long pZrnyenkihonhijynbrip) {
        zrnyenkihonhijynbrip = pZrnyenkihonhijynbrip;
    }

    private Long zrnyenkihonitijibaraip;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYENKIHONITIJIBARAIP)
    public Long getZrnyenkihonitijibaraip() {
        return zrnyenkihonitijibaraip;
    }

    public void setZrnyenkihonitijibaraip(Long pZrnyenkihonitijibaraip) {
        zrnyenkihonitijibaraip = pZrnyenkihonitijibaraip;
    }

    private String zrntrkkzk1trkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTRKKZK1TRKARIHYJ)
    public String getZrntrkkzk1trkarihyj() {
        return zrntrkkzk1trkarihyj;
    }

    public void setZrntrkkzk1trkarihyj(String pZrntrkkzk1trkarihyj) {
        zrntrkkzk1trkarihyj = pZrntrkkzk1trkarihyj;
    }

    private String zrntrkkzk2trkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNTRKKZK2TRKARIHYJ)
    public String getZrntrkkzk2trkarihyj() {
        return zrntrkkzk2trkarihyj;
    }

    public void setZrntrkkzk2trkarihyj(String pZrntrkkzk2trkarihyj) {
        zrntrkkzk2trkarihyj = pZrntrkkzk2trkarihyj;
    }

    private String zrnyno7keta;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYNO7KETA)
    public String getZrnyno7keta() {
        return zrnyno7keta;
    }

    public void setZrnyno7keta(String pZrnyno7keta) {
        zrnyno7keta = pZrnyno7keta;
    }

    private String zrnyobiv241;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYOBIV241)
    public String getZrnyobiv241() {
        return zrnyobiv241;
    }

    public void setZrnyobiv241(String pZrnyobiv241) {
        zrnyobiv241 = pZrnyobiv241;
    }

    private String zrnyobiv26;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYOBIV26)
    public String getZrnyobiv26() {
        return zrnyobiv26;
    }

    public void setZrnyobiv26(String pZrnyobiv26) {
        zrnyobiv26 = pZrnyobiv26;
    }

    private String zrnyobiv250x2;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYOBIV250X2)
    public String getZrnyobiv250x2() {
        return zrnyobiv250x2;
    }

    public void setZrnyobiv250x2(String pZrnyobiv250x2) {
        zrnyobiv250x2 = pZrnyobiv250x2;
    }

    private String zrnyobiv50;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFRn.ZRNYOBIV50)
    public String getZrnyobiv50() {
        return zrnyobiv50;
    }

    public void setZrnyobiv50(String pZrnyobiv50) {
        zrnyobiv50 = pZrnyobiv50;
    }
}