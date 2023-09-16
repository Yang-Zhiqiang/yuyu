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
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.id.PKZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.meta.GenQZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.meta.QZT_KokyakuYuyuKykmeisaiFTy;

/**
 * 顧客用ゆうゆう契約明細Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_KokyakuYuyuKykmeisaiFTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KokyakuYuyuKykmeisaiFTy}</td><td colspan="3">顧客用ゆうゆう契約明細Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_KokyakuYuyuKykmeisaiFTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkmnenkansanp ztyhrkmnenkansanp}</td><td>（中継用）払込年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyengyousekihosyous ztyyengyousekihosyous}</td><td>（中継用）円換算業績保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysymtymd ztysymtymd}</td><td>（中継用）消滅年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakukigou ztysyukeiyakukigou}</td><td>（中継用）主契約記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykykratesedaikbn ztysykykratesedaikbn}</td><td>（中継用）主契約レート世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyudkaigomehrtkarihyj ztyjyudkaigomehrtkarihyj}</td><td>（中継用）重度介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmentokuyakukbn ztypmentokuyakukbn}</td><td>（中継用）Ｐ免特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtkykarihyj ztykykdrtkykarihyj}</td><td>（中継用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv158 ztyyobiv158}</td><td>（中継用）予備項目Ｖ１５８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkyknm18 ztyknkyknm18}</td><td>（中継用）カナ契約者名（１８文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm ztykjkyknm}</td><td>（中継用）漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseiymd ztykyksyaseiymd}</td><td>（中継用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen3 ztykyksyanen3}</td><td>（中継用）契約者年齢（３桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjikyksyanen ztykykjikyksyanen}</td><td>（中継用）契約時契約者年齢</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuusinsakihumeihyj ztytuusinsakihumeihyj}</td><td>（中継用）通信先不明表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihontikucd ztykihontikucd}</td><td>（中継用）基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytodouhukencd ztytodouhukencd}</td><td>（中継用）都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikutyousoncd5 ztysikutyousoncd5}</td><td>（中継用）市区町村コード（５桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjadr62 ztykjadr62}</td><td>（中継用）漢字住所（６２文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytelno ztytelno}</td><td>（中継用）電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2telno ztydai2telno}</td><td>（中継用）第２電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknhhknmei ztyknhhknmei}</td><td>（中継用）カナ被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei ztyknjhhknmei}</td><td>（中継用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen ztyhhknnen}</td><td>（中継用）被保険者年齢</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjihhknnen ztykykjihhknnen}</td><td>（中継用）契約時被保険者年齢</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymannenreikykhyj ztymannenreikykhyj}</td><td>（中継用）満年齢契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyhhknsydouituhyouji ztykyksyhhknsydouituhyouji}</td><td>（中継用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjyutikbn ztykykjyutikbn}</td><td>（中継用）契約状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoumetucd ztysyoumetucd}</td><td>（中継用）消滅コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikikaisiymd ztytorihikikaisiymd}</td><td>（中継用）取引開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypowerfulhyj ztypowerfulhyj}</td><td>（中継用）パワフル表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylargehyj ztylargehyj}</td><td>（中継用）ラージ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouhinbunruikbn ztysyouhinbunruikbn}</td><td>（中継用）商品分類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyouhnnmkbn ztysyouhnnmkbn}</td><td>（中継用）商品名称区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknnmcd ztyhknnmcd}</td><td>（中継用）保険名称コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkbthsyukiknmanryouym ztytkbthsyukiknmanryouym}</td><td>（中継用）特別保障期間満了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyldownym ztyldownym}</td><td>（中継用）Ｌダウン年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkmanryouym ztyhrkmanryouym}</td><td>（中継用）払込満了年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymankiym ztymankiym}</td><td>（中継用）満期年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykykyoteiriritu ztysykykyoteiriritu}</td><td>（中継用）主契約予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrserieshyj ztyrserieshyj}</td><td>（中継用）Ｒシリーズ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduketorihouhoukbn ztyduketorihouhoukbn}</td><td>（中継用）Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyinfoteikyoutsghyj ztyinfoteikyoutsghyj}</td><td>（中継用）情報提供対象外表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaimitukykhyj ztynaimitukykhyj}</td><td>（中継用）内密契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrarihyj ztymrarihyj}</td><td>（中継用）ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasitukenaimituhyj ztykasitukenaimituhyj}</td><td>（中継用）貸付内密表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdktyuuiarihyj ztyttdktyuuiarihyj}</td><td>（中継用）手続注意情報有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdktyuuisetkacd1 ztyttdktyuuisetkacd1}</td><td>（中継用）手続注意台帳設定課コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdktyuuisetymd1 ztyttdktyuuisetymd1}</td><td>（中継用）手続注意台帳設定年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdktyuuisetkbn1 ztyttdktyuuisetkbn1}</td><td>（中継用）手続注意台帳設定区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdktyuuisetkacd2 ztyttdktyuuisetkacd2}</td><td>（中継用）手続注意台帳設定課コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdktyuuisetymd2 ztyttdktyuuisetymd2}</td><td>（中継用）手続注意台帳設定年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdktyuuisetkbn2 ztyttdktyuuisetkbn2}</td><td>（中継用）手続注意台帳設定区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyttdktyuui3kenijyouhyj ztyttdktyuui3kenijyouhyj}</td><td>（中継用）手続注意３件以上あり表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysentakujyouhouarihyouji ztysentakujyouhouarihyouji}</td><td>（中継用）選択情報有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystknsetkykhyj ztystknsetkykhyj}</td><td>（中継用）質権設定契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenharaikomip ztyyenharaikomip}</td><td>（中継用）円換算払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyenkihons ztyyenkihons}</td><td>（中継用）円換算基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyensibous ztyyensibous}</td><td>（中継用）円換算死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhrkhuhukbn ztyhrkhuhukbn}</td><td>（中継用）払込方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyuunoukeirokbn ztysyuunoukeirokbn}</td><td>（中継用）収納経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycalckijyunymd ztycalckijyunymd}</td><td>（中継用）計算基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitatedzndk ztytumitatedzndk}</td><td>（中継用）積立Ｄ残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytumitatedzndkhunouhyj ztytumitatedzndkhunouhyj}</td><td>（中継用）積立Ｄ残高計算不能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenatkihyj ztydairitenatkihyj}</td><td>（中継用）代理店扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantou1sisyacd ztytantou1sisyacd}</td><td>（中継用）担当１支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantou1sibucd ztytantou1sibucd}</td><td>（中継用）担当１支部コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantou1kojincd ztytantou1kojincd}</td><td>（中継用）担当１個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantou1tantoukaisiymd ztytantou1tantoukaisiymd}</td><td>（中継用）担当１担当開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantou1tantousyakbn ztytantou1tantousyakbn}</td><td>（中継用）担当１担当者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantou2sisyacd ztytantou2sisyacd}</td><td>（中継用）担当２支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantou2sibucd ztytantou2sibucd}</td><td>（中継用）担当２支部コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantou2kojincd ztytantou2kojincd}</td><td>（中継用）担当２個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantou2tantoukaisiymd ztytantou2tantoukaisiymd}</td><td>（中継用）担当２担当開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantou2tantousyakbn ztytantou2tantousyakbn}</td><td>（中継用）担当２担当者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikijikbn ztysikijikbn}</td><td>（中継用）職事区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikyou1sosikicd ztyteikyou1sosikicd}</td><td>（中継用）情報提供先１組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikyou1kojincd ztyteikyou1kojincd}</td><td>（中継用）情報提供先１個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikyou1tantoukbn ztyteikyou1tantoukbn}</td><td>（中継用）情報提供先１担当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikyou2sosikicd ztyteikyou2sosikicd}</td><td>（中継用）情報提供先２組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikyou2kojincd ztyteikyou2kojincd}</td><td>（中継用）情報提供先２個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikyou2tantoukbn ztyteikyou2tantoukbn}</td><td>（中継用）情報提供先２担当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyadrsyokansisyacd ztyadrsyokansisyacd}</td><td>（中継用）住所所管支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyukjsaki1sosikicd ztyhyukjsaki1sosikicd}</td><td>（中継用）保有計上先１組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyukjsaki1kojincd ztyhyukjsaki1kojincd}</td><td>（中継用）保有計上先１個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyukjsaki1tantoukbn ztyhyukjsaki1tantoukbn}</td><td>（中継用）保有計上先１担当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyukjsaki2sosikicd ztyhyukjsaki2sosikicd}</td><td>（中継用）保有計上先２組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyukjsaki2kojincd ztyhyukjsaki2kojincd}</td><td>（中継用）保有計上先２個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhyukjsaki2tantoukbn ztyhyukjsaki2tantoukbn}</td><td>（中継用）保有計上先２担当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyinfotysytymd ztyinfotysytymd}</td><td>（中継用）情報抽出年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdairiseikyuutkykarihyj ztystdairiseikyuutkykarihyj}</td><td>（中継用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhouteityotikuhknhyj ztyhouteityotikuhknhyj}</td><td>（中継用）法定貯蓄性保険表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrctservicekbn ztydrctservicekbn}</td><td>（中継用）ダイレクトサービス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhksuhngktkbtknjgnkbn ztyhksuhngktkbtknjgnkbn}</td><td>（中継用）複数変額特別勘定群区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteituukakbn ztysiteituukakbn}</td><td>（中継用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyouyenhknhentkarihyj ztymkhyouyenhknhentkarihyj}</td><td>（中継用）目標到達時円建保険変更特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenkhrikmtkarihyj ztyyenkhrikmtkarihyj}</td><td>（中継用）円貨払込特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystigihrikmtkarihyj ztystigihrikmtkarihyj}</td><td>（中継用）指定外通貨払込特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenshrgksitihsyutkhyj ztyyenshrgksitihsyutkhyj}</td><td>（中継用）円換算支払額最低保証特約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteituukaharaikomip ztysiteituukaharaikomip}</td><td>（中継用）指定通貨建払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyhrktuukaharaikomip ztyhrktuukaharaikomip}</td><td>（中継用）払込通貨建払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteituukakihonsx2 ztysiteituukakihonsx2}</td><td>（中継用）指定通貨建基本Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysiteituukasibous ztysiteituukasibous}</td><td>（中継用）指定通貨建死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyteikisiharaiarihyj ztyteikisiharaiarihyj}</td><td>（中継用）定期支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenteikishrkngk ztyyenteikishrkngk}</td><td>（中継用）円換算定期支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteituukateikishrkngk ztysiteituukateikishrkngk}</td><td>（中継用）指定通貨建定期支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobiv98 ztyyobiv98}</td><td>（中継用）予備項目Ｖ９８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenkihonhijynbris ztyyenkihonhijynbris}</td><td>（中継用）円換算基本平準払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyenkihonitijibarais ztyyenkihonitijibarais}</td><td>（中継用）円換算基本一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyenkihonhijynbrip ztyyenkihonhijynbrip}</td><td>（中継用）円換算基本平準払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyenkihonitijibaraip ztyyenkihonitijibaraip}</td><td>（中継用）円換算基本一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytrkkzk1trkarihyj ztytrkkzk1trkarihyj}</td><td>（中継用）登録家族１登録有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytrkkzk2trkarihyj ztytrkkzk2trkarihyj}</td><td>（中継用）登録家族２登録有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyno7keta ztyyno7keta}</td><td>（中継用）郵便番号（７桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv241 ztyyobiv241}</td><td>（中継用）予備項目Ｖ２４１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv26 ztyyobiv26}</td><td>（中継用）予備項目Ｖ２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x2 ztyyobiv250x2}</td><td>（中継用）予備項目Ｖ２５０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv50 ztyyobiv50}</td><td>（中継用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KokyakuYuyuKykmeisaiFTy
 * @see     PKZT_KokyakuYuyuKykmeisaiFTy
 * @see     QZT_KokyakuYuyuKykmeisaiFTy
 * @see     GenQZT_KokyakuYuyuKykmeisaiFTy
 */
@MappedSuperclass
@Table(name=GenZT_KokyakuYuyuKykmeisaiFTy.TABLE_NAME)
@IdClass(value=PKZT_KokyakuYuyuKykmeisaiFTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_KokyakuYuyuKykmeisaiFTy extends AbstractExDBEntity<ZT_KokyakuYuyuKykmeisaiFTy, PKZT_KokyakuYuyuKykmeisaiFTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_KokyakuYuyuKykmeisaiFTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHRKMNENKANSANP        = "ztyhrkmnenkansanp";
    public static final String ZTYYENGYOUSEKIHOSYOUS    = "ztyyengyousekihosyous";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYSYMTYMD               = "ztysymtymd";
    public static final String ZTYSYUKEIYAKUKIGOU       = "ztysyukeiyakukigou";
    public static final String ZTYSYKYKRATESEDAIKBN     = "ztysykykratesedaikbn";
    public static final String ZTYJYUDKAIGOMEHRTKARIHYJ = "ztyjyudkaigomehrtkarihyj";
    public static final String ZTYPMENTOKUYAKUKBN       = "ztypmentokuyakukbn";
    public static final String ZTYKYKDRTKYKARIHYJ       = "ztykykdrtkykarihyj";
    public static final String ZTYYOBIV158              = "ztyyobiv158";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYKNKYKNM18             = "ztyknkyknm18";
    public static final String ZTYKJKYKNM               = "ztykjkyknm";
    public static final String ZTYKYKSYASEIYMD          = "ztykyksyaseiymd";
    public static final String ZTYKYKSYANEN3            = "ztykyksyanen3";
    public static final String ZTYKYKJIKYKSYANEN        = "ztykykjikyksyanen";
    public static final String ZTYTUUSINSAKIHUMEIHYJ    = "ztytuusinsakihumeihyj";
    public static final String ZTYKIHONTIKUCD           = "ztykihontikucd";
    public static final String ZTYTODOUHUKENCD          = "ztytodouhukencd";
    public static final String ZTYSIKUTYOUSONCD5        = "ztysikutyousoncd5";
    public static final String ZTYKJADR62               = "ztykjadr62";
    public static final String ZTYTELNO                 = "ztytelno";
    public static final String ZTYDAI2TELNO             = "ztydai2telno";
    public static final String ZTYKNHHKNMEI             = "ztyknhhknmei";
    public static final String ZTYKNJHHKNMEI            = "ztyknjhhknmei";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYHHKNNEN               = "ztyhhknnen";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYKYKJIHHKNNEN          = "ztykykjihhknnen";
    public static final String ZTYMANNENREIKYKHYJ       = "ztymannenreikykhyj";
    public static final String ZTYKYKSYHHKNSYDOUITUHYOUJI = "ztykyksyhhknsydouituhyouji";
    public static final String ZTYKYKJYUTIKBN           = "ztykykjyutikbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYSYOUMETUCD            = "ztysyoumetucd";
    public static final String ZTYTORIHIKIKAISIYMD      = "ztytorihikikaisiymd";
    public static final String ZTYPOWERFULHYJ           = "ztypowerfulhyj";
    public static final String ZTYLARGEHYJ              = "ztylargehyj";
    public static final String ZTYSYOUHINBUNRUIKBN      = "ztysyouhinbunruikbn";
    public static final String ZTYSYOUHNNMKBN           = "ztysyouhnnmkbn";
    public static final String ZTYHKNNMCD               = "ztyhknnmcd";
    public static final String ZTYTKBTHSYUKIKNMANRYOUYM = "ztytkbthsyukiknmanryouym";
    public static final String ZTYLDOWNYM               = "ztyldownym";
    public static final String ZTYHRKMANRYOUYM          = "ztyhrkmanryouym";
    public static final String ZTYMANKIYM               = "ztymankiym";
    public static final String ZTYSYKYKYOTEIRIRITU      = "ztysykykyoteiriritu";
    public static final String ZTYRSERIESHYJ            = "ztyrserieshyj";
    public static final String ZTYDUKETORIHOUHOUKBN     = "ztyduketorihouhoukbn";
    public static final String ZTYINFOTEIKYOUTSGHYJ     = "ztyinfoteikyoutsghyj";
    public static final String ZTYNAIMITUKYKHYJ         = "ztynaimitukykhyj";
    public static final String ZTYMRARIHYJ              = "ztymrarihyj";
    public static final String ZTYKASITUKENAIMITUHYJ    = "ztykasitukenaimituhyj";
    public static final String ZTYTTDKTYUUIARIHYJ       = "ztyttdktyuuiarihyj";
    public static final String ZTYTTDKTYUUISETKACD1     = "ztyttdktyuuisetkacd1";
    public static final String ZTYTTDKTYUUISETYMD1      = "ztyttdktyuuisetymd1";
    public static final String ZTYTTDKTYUUISETKBN1      = "ztyttdktyuuisetkbn1";
    public static final String ZTYTTDKTYUUISETKACD2     = "ztyttdktyuuisetkacd2";
    public static final String ZTYTTDKTYUUISETYMD2      = "ztyttdktyuuisetymd2";
    public static final String ZTYTTDKTYUUISETKBN2      = "ztyttdktyuuisetkbn2";
    public static final String ZTYTTDKTYUUI3KENIJYOUHYJ = "ztyttdktyuui3kenijyouhyj";
    public static final String ZTYSENTAKUJYOUHOUARIHYOUJI = "ztysentakujyouhouarihyouji";
    public static final String ZTYSTKNSETKYKHYJ         = "ztystknsetkykhyj";
    public static final String ZTYYENHARAIKOMIP         = "ztyyenharaikomip";
    public static final String ZTYYENKIHONS             = "ztyyenkihons";
    public static final String ZTYYENSIBOUS             = "ztyyensibous";
    public static final String ZTYHRKHUHUKBN            = "ztyhrkhuhukbn";
    public static final String ZTYSYUUNOUKEIROKBN       = "ztysyuunoukeirokbn";
    public static final String ZTYCALCKIJYUNYMD         = "ztycalckijyunymd";
    public static final String ZTYTUMITATEDZNDK         = "ztytumitatedzndk";
    public static final String ZTYTUMITATEDZNDKHUNOUHYJ = "ztytumitatedzndkhunouhyj";
    public static final String ZTYDAIRITENATKIHYJ       = "ztydairitenatkihyj";
    public static final String ZTYTANTOU1SISYACD        = "ztytantou1sisyacd";
    public static final String ZTYTANTOU1SIBUCD         = "ztytantou1sibucd";
    public static final String ZTYTANTOU1KOJINCD        = "ztytantou1kojincd";
    public static final String ZTYTANTOU1TANTOUKAISIYMD = "ztytantou1tantoukaisiymd";
    public static final String ZTYTANTOU1TANTOUSYAKBN   = "ztytantou1tantousyakbn";
    public static final String ZTYTANTOU2SISYACD        = "ztytantou2sisyacd";
    public static final String ZTYTANTOU2SIBUCD         = "ztytantou2sibucd";
    public static final String ZTYTANTOU2KOJINCD        = "ztytantou2kojincd";
    public static final String ZTYTANTOU2TANTOUKAISIYMD = "ztytantou2tantoukaisiymd";
    public static final String ZTYTANTOU2TANTOUSYAKBN   = "ztytantou2tantousyakbn";
    public static final String ZTYSIKIJIKBN             = "ztysikijikbn";
    public static final String ZTYTEIKYOU1SOSIKICD      = "ztyteikyou1sosikicd";
    public static final String ZTYTEIKYOU1KOJINCD       = "ztyteikyou1kojincd";
    public static final String ZTYTEIKYOU1TANTOUKBN     = "ztyteikyou1tantoukbn";
    public static final String ZTYTEIKYOU2SOSIKICD      = "ztyteikyou2sosikicd";
    public static final String ZTYTEIKYOU2KOJINCD       = "ztyteikyou2kojincd";
    public static final String ZTYTEIKYOU2TANTOUKBN     = "ztyteikyou2tantoukbn";
    public static final String ZTYADRSYOKANSISYACD      = "ztyadrsyokansisyacd";
    public static final String ZTYHYUKJSAKI1SOSIKICD    = "ztyhyukjsaki1sosikicd";
    public static final String ZTYHYUKJSAKI1KOJINCD     = "ztyhyukjsaki1kojincd";
    public static final String ZTYHYUKJSAKI1TANTOUKBN   = "ztyhyukjsaki1tantoukbn";
    public static final String ZTYHYUKJSAKI2SOSIKICD    = "ztyhyukjsaki2sosikicd";
    public static final String ZTYHYUKJSAKI2KOJINCD     = "ztyhyukjsaki2kojincd";
    public static final String ZTYHYUKJSAKI2TANTOUKBN   = "ztyhyukjsaki2tantoukbn";
    public static final String ZTYINFOTYSYTYMD          = "ztyinfotysytymd";
    public static final String ZTYSTDAIRISEIKYUUTKYKARIHYJ = "ztystdairiseikyuutkykarihyj";
    public static final String ZTYHOUTEITYOTIKUHKNHYJ   = "ztyhouteityotikuhknhyj";
    public static final String ZTYDRCTSERVICEKBN        = "ztydrctservicekbn";
    public static final String ZTYHKSUHNGKTKBTKNJGNKBN  = "ztyhksuhngktkbtknjgnkbn";
    public static final String ZTYSITEITUUKAKBN         = "ztysiteituukakbn";
    public static final String ZTYMKHYOUYENHKNHENTKARIHYJ = "ztymkhyouyenhknhentkarihyj";
    public static final String ZTYYENKHRIKMTKARIHYJ     = "ztyyenkhrikmtkarihyj";
    public static final String ZTYSTIGIHRIKMTKARIHYJ    = "ztystigihrikmtkarihyj";
    public static final String ZTYYENSHRGKSITIHSYUTKHYJ = "ztyyenshrgksitihsyutkhyj";
    public static final String ZTYSITEITUUKAHARAIKOMIP  = "ztysiteituukaharaikomip";
    public static final String ZTYHRKTUUKAHARAIKOMIP    = "ztyhrktuukaharaikomip";
    public static final String ZTYSITEITUUKAKIHONSX2    = "ztysiteituukakihonsx2";
    public static final String ZTYSITEITUUKASIBOUS      = "ztysiteituukasibous";
    public static final String ZTYTEIKISIHARAIARIHYJ    = "ztyteikisiharaiarihyj";
    public static final String ZTYYENTEIKISHRKNGK       = "ztyyenteikishrkngk";
    public static final String ZTYSITEITUUKATEIKISHRKNGK = "ztysiteituukateikishrkngk";
    public static final String ZTYYOBIV98               = "ztyyobiv98";
    public static final String ZTYYENKIHONHIJYNBRIS     = "ztyyenkihonhijynbris";
    public static final String ZTYYENKIHONITIJIBARAIS   = "ztyyenkihonitijibarais";
    public static final String ZTYYENKIHONHIJYNBRIP     = "ztyyenkihonhijynbrip";
    public static final String ZTYYENKIHONITIJIBARAIP   = "ztyyenkihonitijibaraip";
    public static final String ZTYTRKKZK1TRKARIHYJ      = "ztytrkkzk1trkarihyj";
    public static final String ZTYTRKKZK2TRKARIHYJ      = "ztytrkkzk2trkarihyj";
    public static final String ZTYYNO7KETA              = "ztyyno7keta";
    public static final String ZTYYOBIV241              = "ztyyobiv241";
    public static final String ZTYYOBIV26               = "ztyyobiv26";
    public static final String ZTYYOBIV250X2            = "ztyyobiv250x2";
    public static final String ZTYYOBIV50               = "ztyyobiv50";

    private final PKZT_KokyakuYuyuKykmeisaiFTy primaryKey;

    public GenZT_KokyakuYuyuKykmeisaiFTy() {
        primaryKey = new PKZT_KokyakuYuyuKykmeisaiFTy();
    }

    public GenZT_KokyakuYuyuKykmeisaiFTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_KokyakuYuyuKykmeisaiFTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_KokyakuYuyuKykmeisaiFTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_KokyakuYuyuKykmeisaiFTy> getMetaClass() {
        return QZT_KokyakuYuyuKykmeisaiFTy.class;
    }

    @Id
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztysyono;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private Long ztyhrkmnenkansanp;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHRKMNENKANSANP)
    public Long getZtyhrkmnenkansanp() {
        return ztyhrkmnenkansanp;
    }

    public void setZtyhrkmnenkansanp(Long pZtyhrkmnenkansanp) {
        ztyhrkmnenkansanp = pZtyhrkmnenkansanp;
    }

    private Long ztyyengyousekihosyous;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENGYOUSEKIHOSYOUS)
    public Long getZtyyengyousekihosyous() {
        return ztyyengyousekihosyous;
    }

    public void setZtyyengyousekihosyous(Long pZtyyengyousekihosyous) {
        ztyyengyousekihosyous = pZtyyengyousekihosyous;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztysymtymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSYMTYMD)
    public String getZtysymtymd() {
        return ztysymtymd;
    }

    public void setZtysymtymd(String pZtysymtymd) {
        ztysymtymd = pZtysymtymd;
    }

    private String ztysyukeiyakukigou;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSYUKEIYAKUKIGOU)
    public String getZtysyukeiyakukigou() {
        return ztysyukeiyakukigou;
    }

    public void setZtysyukeiyakukigou(String pZtysyukeiyakukigou) {
        ztysyukeiyakukigou = pZtysyukeiyakukigou;
    }

    private String ztysykykratesedaikbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSYKYKRATESEDAIKBN)
    public String getZtysykykratesedaikbn() {
        return ztysykykratesedaikbn;
    }

    public void setZtysykykratesedaikbn(String pZtysykykratesedaikbn) {
        ztysykykratesedaikbn = pZtysykykratesedaikbn;
    }

    private String ztyjyudkaigomehrtkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYJYUDKAIGOMEHRTKARIHYJ)
    public String getZtyjyudkaigomehrtkarihyj() {
        return ztyjyudkaigomehrtkarihyj;
    }

    public void setZtyjyudkaigomehrtkarihyj(String pZtyjyudkaigomehrtkarihyj) {
        ztyjyudkaigomehrtkarihyj = pZtyjyudkaigomehrtkarihyj;
    }

    private String ztypmentokuyakukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYPMENTOKUYAKUKBN)
    public String getZtypmentokuyakukbn() {
        return ztypmentokuyakukbn;
    }

    public void setZtypmentokuyakukbn(String pZtypmentokuyakukbn) {
        ztypmentokuyakukbn = pZtypmentokuyakukbn;
    }

    private String ztykykdrtkykarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKYKDRTKYKARIHYJ)
    public String getZtykykdrtkykarihyj() {
        return ztykykdrtkykarihyj;
    }

    public void setZtykykdrtkykarihyj(String pZtykykdrtkykarihyj) {
        ztykykdrtkykarihyj = pZtykykdrtkykarihyj;
    }

    private String ztyyobiv158;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYOBIV158)
    public String getZtyyobiv158() {
        return ztyyobiv158;
    }

    public void setZtyyobiv158(String pZtyyobiv158) {
        ztyyobiv158 = pZtyyobiv158;
    }

    private String ztykykymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztybsyym;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztyknkyknm18;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKNKYKNM18)
    public String getZtyknkyknm18() {
        return ztyknkyknm18;
    }

    public void setZtyknkyknm18(String pZtyknkyknm18) {
        ztyknkyknm18 = pZtyknkyknm18;
    }

    private String ztykjkyknm;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKJKYKNM)
    public String getZtykjkyknm() {
        return ztykjkyknm;
    }

    public void setZtykjkyknm(String pZtykjkyknm) {
        ztykjkyknm = pZtykjkyknm;
    }

    private String ztykyksyaseiymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKYKSYASEIYMD)
    public String getZtykyksyaseiymd() {
        return ztykyksyaseiymd;
    }

    public void setZtykyksyaseiymd(String pZtykyksyaseiymd) {
        ztykyksyaseiymd = pZtykyksyaseiymd;
    }

    private String ztykyksyanen3;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKYKSYANEN3)
    public String getZtykyksyanen3() {
        return ztykyksyanen3;
    }

    public void setZtykyksyanen3(String pZtykyksyanen3) {
        ztykyksyanen3 = pZtykyksyanen3;
    }

    private String ztykykjikyksyanen;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKYKJIKYKSYANEN)
    public String getZtykykjikyksyanen() {
        return ztykykjikyksyanen;
    }

    public void setZtykykjikyksyanen(String pZtykykjikyksyanen) {
        ztykykjikyksyanen = pZtykykjikyksyanen;
    }

    private String ztytuusinsakihumeihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTUUSINSAKIHUMEIHYJ)
    public String getZtytuusinsakihumeihyj() {
        return ztytuusinsakihumeihyj;
    }

    public void setZtytuusinsakihumeihyj(String pZtytuusinsakihumeihyj) {
        ztytuusinsakihumeihyj = pZtytuusinsakihumeihyj;
    }

    private String ztykihontikucd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKIHONTIKUCD)
    public String getZtykihontikucd() {
        return ztykihontikucd;
    }

    public void setZtykihontikucd(String pZtykihontikucd) {
        ztykihontikucd = pZtykihontikucd;
    }

    private String ztytodouhukencd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTODOUHUKENCD)
    public String getZtytodouhukencd() {
        return ztytodouhukencd;
    }

    public void setZtytodouhukencd(String pZtytodouhukencd) {
        ztytodouhukencd = pZtytodouhukencd;
    }

    private String ztysikutyousoncd5;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSIKUTYOUSONCD5)
    public String getZtysikutyousoncd5() {
        return ztysikutyousoncd5;
    }

    public void setZtysikutyousoncd5(String pZtysikutyousoncd5) {
        ztysikutyousoncd5 = pZtysikutyousoncd5;
    }

    private String ztykjadr62;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKJADR62)
    public String getZtykjadr62() {
        return ztykjadr62;
    }

    public void setZtykjadr62(String pZtykjadr62) {
        ztykjadr62 = pZtykjadr62;
    }

    private String ztytelno;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTELNO)
    public String getZtytelno() {
        return ztytelno;
    }

    public void setZtytelno(String pZtytelno) {
        ztytelno = pZtytelno;
    }

    private String ztydai2telno;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYDAI2TELNO)
    public String getZtydai2telno() {
        return ztydai2telno;
    }

    public void setZtydai2telno(String pZtydai2telno) {
        ztydai2telno = pZtydai2telno;
    }

    private String ztyknhhknmei;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKNHHKNMEI)
    public String getZtyknhhknmei() {
        return ztyknhhknmei;
    }

    public void setZtyknhhknmei(String pZtyknhhknmei) {
        ztyknhhknmei = pZtyknhhknmei;
    }

    private String ztyknjhhknmei;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKNJHHKNMEI)
    public String getZtyknjhhknmei() {
        return ztyknjhhknmei;
    }

    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        ztyknjhhknmei = pZtyknjhhknmei;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztyhhknnen;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHHKNNEN)
    public String getZtyhhknnen() {
        return ztyhhknnen;
    }

    public void setZtyhhknnen(String pZtyhhknnen) {
        ztyhhknnen = pZtyhhknnen;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztykykjihhknnen;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKYKJIHHKNNEN)
    public String getZtykykjihhknnen() {
        return ztykykjihhknnen;
    }

    public void setZtykykjihhknnen(String pZtykykjihhknnen) {
        ztykykjihhknnen = pZtykykjihhknnen;
    }

    private String ztymannenreikykhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYMANNENREIKYKHYJ)
    public String getZtymannenreikykhyj() {
        return ztymannenreikykhyj;
    }

    public void setZtymannenreikykhyj(String pZtymannenreikykhyj) {
        ztymannenreikykhyj = pZtymannenreikykhyj;
    }

    private String ztykyksyhhknsydouituhyouji;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKYKSYHHKNSYDOUITUHYOUJI)
    public String getZtykyksyhhknsydouituhyouji() {
        return ztykyksyhhknsydouituhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykyksyhhknsydouituhyouji(String pZtykyksyhhknsydouituhyouji) {
        ztykyksyhhknsydouituhyouji = pZtykyksyhhknsydouituhyouji;
    }

    private String ztykykjyutikbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKYKJYUTIKBN)
    public String getZtykykjyutikbn() {
        return ztykykjyutikbn;
    }

    public void setZtykykjyutikbn(String pZtykykjyutikbn) {
        ztykykjyutikbn = pZtykykjyutikbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztysyoumetucd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSYOUMETUCD)
    public String getZtysyoumetucd() {
        return ztysyoumetucd;
    }

    public void setZtysyoumetucd(String pZtysyoumetucd) {
        ztysyoumetucd = pZtysyoumetucd;
    }

    private String ztytorihikikaisiymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTORIHIKIKAISIYMD)
    public String getZtytorihikikaisiymd() {
        return ztytorihikikaisiymd;
    }

    public void setZtytorihikikaisiymd(String pZtytorihikikaisiymd) {
        ztytorihikikaisiymd = pZtytorihikikaisiymd;
    }

    private String ztypowerfulhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYPOWERFULHYJ)
    public String getZtypowerfulhyj() {
        return ztypowerfulhyj;
    }

    public void setZtypowerfulhyj(String pZtypowerfulhyj) {
        ztypowerfulhyj = pZtypowerfulhyj;
    }

    private String ztylargehyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYLARGEHYJ)
    public String getZtylargehyj() {
        return ztylargehyj;
    }

    public void setZtylargehyj(String pZtylargehyj) {
        ztylargehyj = pZtylargehyj;
    }

    private String ztysyouhinbunruikbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSYOUHINBUNRUIKBN)
    public String getZtysyouhinbunruikbn() {
        return ztysyouhinbunruikbn;
    }

    public void setZtysyouhinbunruikbn(String pZtysyouhinbunruikbn) {
        ztysyouhinbunruikbn = pZtysyouhinbunruikbn;
    }

    private String ztysyouhnnmkbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSYOUHNNMKBN)
    public String getZtysyouhnnmkbn() {
        return ztysyouhnnmkbn;
    }

    public void setZtysyouhnnmkbn(String pZtysyouhnnmkbn) {
        ztysyouhnnmkbn = pZtysyouhnnmkbn;
    }

    private String ztyhknnmcd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHKNNMCD)
    public String getZtyhknnmcd() {
        return ztyhknnmcd;
    }

    public void setZtyhknnmcd(String pZtyhknnmcd) {
        ztyhknnmcd = pZtyhknnmcd;
    }

    private String ztytkbthsyukiknmanryouym;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTKBTHSYUKIKNMANRYOUYM)
    public String getZtytkbthsyukiknmanryouym() {
        return ztytkbthsyukiknmanryouym;
    }

    public void setZtytkbthsyukiknmanryouym(String pZtytkbthsyukiknmanryouym) {
        ztytkbthsyukiknmanryouym = pZtytkbthsyukiknmanryouym;
    }

    private String ztyldownym;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYLDOWNYM)
    public String getZtyldownym() {
        return ztyldownym;
    }

    public void setZtyldownym(String pZtyldownym) {
        ztyldownym = pZtyldownym;
    }

    private String ztyhrkmanryouym;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHRKMANRYOUYM)
    public String getZtyhrkmanryouym() {
        return ztyhrkmanryouym;
    }

    public void setZtyhrkmanryouym(String pZtyhrkmanryouym) {
        ztyhrkmanryouym = pZtyhrkmanryouym;
    }

    private String ztymankiym;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYMANKIYM)
    public String getZtymankiym() {
        return ztymankiym;
    }

    public void setZtymankiym(String pZtymankiym) {
        ztymankiym = pZtymankiym;
    }

    private BizNumber ztysykykyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSYKYKYOTEIRIRITU)
    public BizNumber getZtysykykyoteiriritu() {
        return ztysykykyoteiriritu;
    }

    public void setZtysykykyoteiriritu(BizNumber pZtysykykyoteiriritu) {
        ztysykykyoteiriritu = pZtysykykyoteiriritu;
    }

    private String ztyrserieshyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYRSERIESHYJ)
    public String getZtyrserieshyj() {
        return ztyrserieshyj;
    }

    public void setZtyrserieshyj(String pZtyrserieshyj) {
        ztyrserieshyj = pZtyrserieshyj;
    }

    private String ztyduketorihouhoukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYDUKETORIHOUHOUKBN)
    public String getZtyduketorihouhoukbn() {
        return ztyduketorihouhoukbn;
    }

    public void setZtyduketorihouhoukbn(String pZtyduketorihouhoukbn) {
        ztyduketorihouhoukbn = pZtyduketorihouhoukbn;
    }

    private String ztyinfoteikyoutsghyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYINFOTEIKYOUTSGHYJ)
    public String getZtyinfoteikyoutsghyj() {
        return ztyinfoteikyoutsghyj;
    }

    public void setZtyinfoteikyoutsghyj(String pZtyinfoteikyoutsghyj) {
        ztyinfoteikyoutsghyj = pZtyinfoteikyoutsghyj;
    }

    private String ztynaimitukykhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYNAIMITUKYKHYJ)
    public String getZtynaimitukykhyj() {
        return ztynaimitukykhyj;
    }

    public void setZtynaimitukykhyj(String pZtynaimitukykhyj) {
        ztynaimitukykhyj = pZtynaimitukykhyj;
    }

    private String ztymrarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYMRARIHYJ)
    public String getZtymrarihyj() {
        return ztymrarihyj;
    }

    public void setZtymrarihyj(String pZtymrarihyj) {
        ztymrarihyj = pZtymrarihyj;
    }

    private String ztykasitukenaimituhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYKASITUKENAIMITUHYJ)
    public String getZtykasitukenaimituhyj() {
        return ztykasitukenaimituhyj;
    }

    public void setZtykasitukenaimituhyj(String pZtykasitukenaimituhyj) {
        ztykasitukenaimituhyj = pZtykasitukenaimituhyj;
    }

    private String ztyttdktyuuiarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTTDKTYUUIARIHYJ)
    public String getZtyttdktyuuiarihyj() {
        return ztyttdktyuuiarihyj;
    }

    public void setZtyttdktyuuiarihyj(String pZtyttdktyuuiarihyj) {
        ztyttdktyuuiarihyj = pZtyttdktyuuiarihyj;
    }

    private String ztyttdktyuuisetkacd1;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTTDKTYUUISETKACD1)
    public String getZtyttdktyuuisetkacd1() {
        return ztyttdktyuuisetkacd1;
    }

    public void setZtyttdktyuuisetkacd1(String pZtyttdktyuuisetkacd1) {
        ztyttdktyuuisetkacd1 = pZtyttdktyuuisetkacd1;
    }

    private String ztyttdktyuuisetymd1;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTTDKTYUUISETYMD1)
    public String getZtyttdktyuuisetymd1() {
        return ztyttdktyuuisetymd1;
    }

    public void setZtyttdktyuuisetymd1(String pZtyttdktyuuisetymd1) {
        ztyttdktyuuisetymd1 = pZtyttdktyuuisetymd1;
    }

    private String ztyttdktyuuisetkbn1;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTTDKTYUUISETKBN1)
    public String getZtyttdktyuuisetkbn1() {
        return ztyttdktyuuisetkbn1;
    }

    public void setZtyttdktyuuisetkbn1(String pZtyttdktyuuisetkbn1) {
        ztyttdktyuuisetkbn1 = pZtyttdktyuuisetkbn1;
    }

    private String ztyttdktyuuisetkacd2;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTTDKTYUUISETKACD2)
    public String getZtyttdktyuuisetkacd2() {
        return ztyttdktyuuisetkacd2;
    }

    public void setZtyttdktyuuisetkacd2(String pZtyttdktyuuisetkacd2) {
        ztyttdktyuuisetkacd2 = pZtyttdktyuuisetkacd2;
    }

    private String ztyttdktyuuisetymd2;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTTDKTYUUISETYMD2)
    public String getZtyttdktyuuisetymd2() {
        return ztyttdktyuuisetymd2;
    }

    public void setZtyttdktyuuisetymd2(String pZtyttdktyuuisetymd2) {
        ztyttdktyuuisetymd2 = pZtyttdktyuuisetymd2;
    }

    private String ztyttdktyuuisetkbn2;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTTDKTYUUISETKBN2)
    public String getZtyttdktyuuisetkbn2() {
        return ztyttdktyuuisetkbn2;
    }

    public void setZtyttdktyuuisetkbn2(String pZtyttdktyuuisetkbn2) {
        ztyttdktyuuisetkbn2 = pZtyttdktyuuisetkbn2;
    }

    private String ztyttdktyuui3kenijyouhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTTDKTYUUI3KENIJYOUHYJ)
    public String getZtyttdktyuui3kenijyouhyj() {
        return ztyttdktyuui3kenijyouhyj;
    }

    public void setZtyttdktyuui3kenijyouhyj(String pZtyttdktyuui3kenijyouhyj) {
        ztyttdktyuui3kenijyouhyj = pZtyttdktyuui3kenijyouhyj;
    }

    private String ztysentakujyouhouarihyouji;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSENTAKUJYOUHOUARIHYOUJI)
    public String getZtysentakujyouhouarihyouji() {
        return ztysentakujyouhouarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysentakujyouhouarihyouji(String pZtysentakujyouhouarihyouji) {
        ztysentakujyouhouarihyouji = pZtysentakujyouhouarihyouji;
    }

    private String ztystknsetkykhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSTKNSETKYKHYJ)
    public String getZtystknsetkykhyj() {
        return ztystknsetkykhyj;
    }

    public void setZtystknsetkykhyj(String pZtystknsetkykhyj) {
        ztystknsetkykhyj = pZtystknsetkykhyj;
    }

    private Long ztyyenharaikomip;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENHARAIKOMIP)
    public Long getZtyyenharaikomip() {
        return ztyyenharaikomip;
    }

    public void setZtyyenharaikomip(Long pZtyyenharaikomip) {
        ztyyenharaikomip = pZtyyenharaikomip;
    }

    private Long ztyyenkihons;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENKIHONS)
    public Long getZtyyenkihons() {
        return ztyyenkihons;
    }

    public void setZtyyenkihons(Long pZtyyenkihons) {
        ztyyenkihons = pZtyyenkihons;
    }

    private Long ztyyensibous;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENSIBOUS)
    public Long getZtyyensibous() {
        return ztyyensibous;
    }

    public void setZtyyensibous(Long pZtyyensibous) {
        ztyyensibous = pZtyyensibous;
    }

    private String ztyhrkhuhukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHRKHUHUKBN)
    public String getZtyhrkhuhukbn() {
        return ztyhrkhuhukbn;
    }

    public void setZtyhrkhuhukbn(String pZtyhrkhuhukbn) {
        ztyhrkhuhukbn = pZtyhrkhuhukbn;
    }

    private String ztysyuunoukeirokbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSYUUNOUKEIROKBN)
    public String getZtysyuunoukeirokbn() {
        return ztysyuunoukeirokbn;
    }

    public void setZtysyuunoukeirokbn(String pZtysyuunoukeirokbn) {
        ztysyuunoukeirokbn = pZtysyuunoukeirokbn;
    }

    private String ztycalckijyunymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYCALCKIJYUNYMD)
    public String getZtycalckijyunymd() {
        return ztycalckijyunymd;
    }

    public void setZtycalckijyunymd(String pZtycalckijyunymd) {
        ztycalckijyunymd = pZtycalckijyunymd;
    }

    private Long ztytumitatedzndk;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTUMITATEDZNDK)
    public Long getZtytumitatedzndk() {
        return ztytumitatedzndk;
    }

    public void setZtytumitatedzndk(Long pZtytumitatedzndk) {
        ztytumitatedzndk = pZtytumitatedzndk;
    }

    private String ztytumitatedzndkhunouhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTUMITATEDZNDKHUNOUHYJ)
    public String getZtytumitatedzndkhunouhyj() {
        return ztytumitatedzndkhunouhyj;
    }

    public void setZtytumitatedzndkhunouhyj(String pZtytumitatedzndkhunouhyj) {
        ztytumitatedzndkhunouhyj = pZtytumitatedzndkhunouhyj;
    }

    private String ztydairitenatkihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYDAIRITENATKIHYJ)
    public String getZtydairitenatkihyj() {
        return ztydairitenatkihyj;
    }

    public void setZtydairitenatkihyj(String pZtydairitenatkihyj) {
        ztydairitenatkihyj = pZtydairitenatkihyj;
    }

    private String ztytantou1sisyacd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTANTOU1SISYACD)
    public String getZtytantou1sisyacd() {
        return ztytantou1sisyacd;
    }

    public void setZtytantou1sisyacd(String pZtytantou1sisyacd) {
        ztytantou1sisyacd = pZtytantou1sisyacd;
    }

    private String ztytantou1sibucd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTANTOU1SIBUCD)
    public String getZtytantou1sibucd() {
        return ztytantou1sibucd;
    }

    public void setZtytantou1sibucd(String pZtytantou1sibucd) {
        ztytantou1sibucd = pZtytantou1sibucd;
    }

    private String ztytantou1kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTANTOU1KOJINCD)
    public String getZtytantou1kojincd() {
        return ztytantou1kojincd;
    }

    public void setZtytantou1kojincd(String pZtytantou1kojincd) {
        ztytantou1kojincd = pZtytantou1kojincd;
    }

    private String ztytantou1tantoukaisiymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTANTOU1TANTOUKAISIYMD)
    public String getZtytantou1tantoukaisiymd() {
        return ztytantou1tantoukaisiymd;
    }

    public void setZtytantou1tantoukaisiymd(String pZtytantou1tantoukaisiymd) {
        ztytantou1tantoukaisiymd = pZtytantou1tantoukaisiymd;
    }

    private String ztytantou1tantousyakbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTANTOU1TANTOUSYAKBN)
    public String getZtytantou1tantousyakbn() {
        return ztytantou1tantousyakbn;
    }

    public void setZtytantou1tantousyakbn(String pZtytantou1tantousyakbn) {
        ztytantou1tantousyakbn = pZtytantou1tantousyakbn;
    }

    private String ztytantou2sisyacd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTANTOU2SISYACD)
    public String getZtytantou2sisyacd() {
        return ztytantou2sisyacd;
    }

    public void setZtytantou2sisyacd(String pZtytantou2sisyacd) {
        ztytantou2sisyacd = pZtytantou2sisyacd;
    }

    private String ztytantou2sibucd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTANTOU2SIBUCD)
    public String getZtytantou2sibucd() {
        return ztytantou2sibucd;
    }

    public void setZtytantou2sibucd(String pZtytantou2sibucd) {
        ztytantou2sibucd = pZtytantou2sibucd;
    }

    private String ztytantou2kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTANTOU2KOJINCD)
    public String getZtytantou2kojincd() {
        return ztytantou2kojincd;
    }

    public void setZtytantou2kojincd(String pZtytantou2kojincd) {
        ztytantou2kojincd = pZtytantou2kojincd;
    }

    private String ztytantou2tantoukaisiymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTANTOU2TANTOUKAISIYMD)
    public String getZtytantou2tantoukaisiymd() {
        return ztytantou2tantoukaisiymd;
    }

    public void setZtytantou2tantoukaisiymd(String pZtytantou2tantoukaisiymd) {
        ztytantou2tantoukaisiymd = pZtytantou2tantoukaisiymd;
    }

    private String ztytantou2tantousyakbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTANTOU2TANTOUSYAKBN)
    public String getZtytantou2tantousyakbn() {
        return ztytantou2tantousyakbn;
    }

    public void setZtytantou2tantousyakbn(String pZtytantou2tantousyakbn) {
        ztytantou2tantousyakbn = pZtytantou2tantousyakbn;
    }

    private String ztysikijikbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSIKIJIKBN)
    public String getZtysikijikbn() {
        return ztysikijikbn;
    }

    public void setZtysikijikbn(String pZtysikijikbn) {
        ztysikijikbn = pZtysikijikbn;
    }

    private String ztyteikyou1sosikicd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTEIKYOU1SOSIKICD)
    public String getZtyteikyou1sosikicd() {
        return ztyteikyou1sosikicd;
    }

    public void setZtyteikyou1sosikicd(String pZtyteikyou1sosikicd) {
        ztyteikyou1sosikicd = pZtyteikyou1sosikicd;
    }

    private String ztyteikyou1kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTEIKYOU1KOJINCD)
    public String getZtyteikyou1kojincd() {
        return ztyteikyou1kojincd;
    }

    public void setZtyteikyou1kojincd(String pZtyteikyou1kojincd) {
        ztyteikyou1kojincd = pZtyteikyou1kojincd;
    }

    private String ztyteikyou1tantoukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTEIKYOU1TANTOUKBN)
    public String getZtyteikyou1tantoukbn() {
        return ztyteikyou1tantoukbn;
    }

    public void setZtyteikyou1tantoukbn(String pZtyteikyou1tantoukbn) {
        ztyteikyou1tantoukbn = pZtyteikyou1tantoukbn;
    }

    private String ztyteikyou2sosikicd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTEIKYOU2SOSIKICD)
    public String getZtyteikyou2sosikicd() {
        return ztyteikyou2sosikicd;
    }

    public void setZtyteikyou2sosikicd(String pZtyteikyou2sosikicd) {
        ztyteikyou2sosikicd = pZtyteikyou2sosikicd;
    }

    private String ztyteikyou2kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTEIKYOU2KOJINCD)
    public String getZtyteikyou2kojincd() {
        return ztyteikyou2kojincd;
    }

    public void setZtyteikyou2kojincd(String pZtyteikyou2kojincd) {
        ztyteikyou2kojincd = pZtyteikyou2kojincd;
    }

    private String ztyteikyou2tantoukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTEIKYOU2TANTOUKBN)
    public String getZtyteikyou2tantoukbn() {
        return ztyteikyou2tantoukbn;
    }

    public void setZtyteikyou2tantoukbn(String pZtyteikyou2tantoukbn) {
        ztyteikyou2tantoukbn = pZtyteikyou2tantoukbn;
    }

    private String ztyadrsyokansisyacd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYADRSYOKANSISYACD)
    public String getZtyadrsyokansisyacd() {
        return ztyadrsyokansisyacd;
    }

    public void setZtyadrsyokansisyacd(String pZtyadrsyokansisyacd) {
        ztyadrsyokansisyacd = pZtyadrsyokansisyacd;
    }

    private String ztyhyukjsaki1sosikicd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHYUKJSAKI1SOSIKICD)
    public String getZtyhyukjsaki1sosikicd() {
        return ztyhyukjsaki1sosikicd;
    }

    public void setZtyhyukjsaki1sosikicd(String pZtyhyukjsaki1sosikicd) {
        ztyhyukjsaki1sosikicd = pZtyhyukjsaki1sosikicd;
    }

    private String ztyhyukjsaki1kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHYUKJSAKI1KOJINCD)
    public String getZtyhyukjsaki1kojincd() {
        return ztyhyukjsaki1kojincd;
    }

    public void setZtyhyukjsaki1kojincd(String pZtyhyukjsaki1kojincd) {
        ztyhyukjsaki1kojincd = pZtyhyukjsaki1kojincd;
    }

    private String ztyhyukjsaki1tantoukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHYUKJSAKI1TANTOUKBN)
    public String getZtyhyukjsaki1tantoukbn() {
        return ztyhyukjsaki1tantoukbn;
    }

    public void setZtyhyukjsaki1tantoukbn(String pZtyhyukjsaki1tantoukbn) {
        ztyhyukjsaki1tantoukbn = pZtyhyukjsaki1tantoukbn;
    }

    private String ztyhyukjsaki2sosikicd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHYUKJSAKI2SOSIKICD)
    public String getZtyhyukjsaki2sosikicd() {
        return ztyhyukjsaki2sosikicd;
    }

    public void setZtyhyukjsaki2sosikicd(String pZtyhyukjsaki2sosikicd) {
        ztyhyukjsaki2sosikicd = pZtyhyukjsaki2sosikicd;
    }

    private String ztyhyukjsaki2kojincd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHYUKJSAKI2KOJINCD)
    public String getZtyhyukjsaki2kojincd() {
        return ztyhyukjsaki2kojincd;
    }

    public void setZtyhyukjsaki2kojincd(String pZtyhyukjsaki2kojincd) {
        ztyhyukjsaki2kojincd = pZtyhyukjsaki2kojincd;
    }

    private String ztyhyukjsaki2tantoukbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHYUKJSAKI2TANTOUKBN)
    public String getZtyhyukjsaki2tantoukbn() {
        return ztyhyukjsaki2tantoukbn;
    }

    public void setZtyhyukjsaki2tantoukbn(String pZtyhyukjsaki2tantoukbn) {
        ztyhyukjsaki2tantoukbn = pZtyhyukjsaki2tantoukbn;
    }

    private String ztyinfotysytymd;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYINFOTYSYTYMD)
    public String getZtyinfotysytymd() {
        return ztyinfotysytymd;
    }

    public void setZtyinfotysytymd(String pZtyinfotysytymd) {
        ztyinfotysytymd = pZtyinfotysytymd;
    }

    private String ztystdairiseikyuutkykarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZtystdairiseikyuutkykarihyj() {
        return ztystdairiseikyuutkykarihyj;
    }

    public void setZtystdairiseikyuutkykarihyj(String pZtystdairiseikyuutkykarihyj) {
        ztystdairiseikyuutkykarihyj = pZtystdairiseikyuutkykarihyj;
    }

    private String ztyhouteityotikuhknhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHOUTEITYOTIKUHKNHYJ)
    public String getZtyhouteityotikuhknhyj() {
        return ztyhouteityotikuhknhyj;
    }

    public void setZtyhouteityotikuhknhyj(String pZtyhouteityotikuhknhyj) {
        ztyhouteityotikuhknhyj = pZtyhouteityotikuhknhyj;
    }

    private String ztydrctservicekbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYDRCTSERVICEKBN)
    public String getZtydrctservicekbn() {
        return ztydrctservicekbn;
    }

    public void setZtydrctservicekbn(String pZtydrctservicekbn) {
        ztydrctservicekbn = pZtydrctservicekbn;
    }

    private String ztyhksuhngktkbtknjgnkbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHKSUHNGKTKBTKNJGNKBN)
    public String getZtyhksuhngktkbtknjgnkbn() {
        return ztyhksuhngktkbtknjgnkbn;
    }

    public void setZtyhksuhngktkbtknjgnkbn(String pZtyhksuhngktkbtknjgnkbn) {
        ztyhksuhngktkbtknjgnkbn = pZtyhksuhngktkbtknjgnkbn;
    }

    private String ztysiteituukakbn;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSITEITUUKAKBN)
    public String getZtysiteituukakbn() {
        return ztysiteituukakbn;
    }

    public void setZtysiteituukakbn(String pZtysiteituukakbn) {
        ztysiteituukakbn = pZtysiteituukakbn;
    }

    private String ztymkhyouyenhknhentkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYMKHYOUYENHKNHENTKARIHYJ)
    public String getZtymkhyouyenhknhentkarihyj() {
        return ztymkhyouyenhknhentkarihyj;
    }

    public void setZtymkhyouyenhknhentkarihyj(String pZtymkhyouyenhknhentkarihyj) {
        ztymkhyouyenhknhentkarihyj = pZtymkhyouyenhknhentkarihyj;
    }

    private String ztyyenkhrikmtkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENKHRIKMTKARIHYJ)
    public String getZtyyenkhrikmtkarihyj() {
        return ztyyenkhrikmtkarihyj;
    }

    public void setZtyyenkhrikmtkarihyj(String pZtyyenkhrikmtkarihyj) {
        ztyyenkhrikmtkarihyj = pZtyyenkhrikmtkarihyj;
    }

    private String ztystigihrikmtkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSTIGIHRIKMTKARIHYJ)
    public String getZtystigihrikmtkarihyj() {
        return ztystigihrikmtkarihyj;
    }

    public void setZtystigihrikmtkarihyj(String pZtystigihrikmtkarihyj) {
        ztystigihrikmtkarihyj = pZtystigihrikmtkarihyj;
    }

    private String ztyyenshrgksitihsyutkhyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENSHRGKSITIHSYUTKHYJ)
    public String getZtyyenshrgksitihsyutkhyj() {
        return ztyyenshrgksitihsyutkhyj;
    }

    public void setZtyyenshrgksitihsyutkhyj(String pZtyyenshrgksitihsyutkhyj) {
        ztyyenshrgksitihsyutkhyj = pZtyyenshrgksitihsyutkhyj;
    }

    private BizNumber ztysiteituukaharaikomip;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSITEITUUKAHARAIKOMIP)
    public BizNumber getZtysiteituukaharaikomip() {
        return ztysiteituukaharaikomip;
    }

    public void setZtysiteituukaharaikomip(BizNumber pZtysiteituukaharaikomip) {
        ztysiteituukaharaikomip = pZtysiteituukaharaikomip;
    }

    private Long ztyhrktuukaharaikomip;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYHRKTUUKAHARAIKOMIP)
    public Long getZtyhrktuukaharaikomip() {
        return ztyhrktuukaharaikomip;
    }

    public void setZtyhrktuukaharaikomip(Long pZtyhrktuukaharaikomip) {
        ztyhrktuukaharaikomip = pZtyhrktuukaharaikomip;
    }

    private BizNumber ztysiteituukakihonsx2;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSITEITUUKAKIHONSX2)
    public BizNumber getZtysiteituukakihonsx2() {
        return ztysiteituukakihonsx2;
    }

    public void setZtysiteituukakihonsx2(BizNumber pZtysiteituukakihonsx2) {
        ztysiteituukakihonsx2 = pZtysiteituukakihonsx2;
    }

    private BizNumber ztysiteituukasibous;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSITEITUUKASIBOUS)
    public BizNumber getZtysiteituukasibous() {
        return ztysiteituukasibous;
    }

    public void setZtysiteituukasibous(BizNumber pZtysiteituukasibous) {
        ztysiteituukasibous = pZtysiteituukasibous;
    }

    private String ztyteikisiharaiarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTEIKISIHARAIARIHYJ)
    public String getZtyteikisiharaiarihyj() {
        return ztyteikisiharaiarihyj;
    }

    public void setZtyteikisiharaiarihyj(String pZtyteikisiharaiarihyj) {
        ztyteikisiharaiarihyj = pZtyteikisiharaiarihyj;
    }

    private Long ztyyenteikishrkngk;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENTEIKISHRKNGK)
    public Long getZtyyenteikishrkngk() {
        return ztyyenteikishrkngk;
    }

    public void setZtyyenteikishrkngk(Long pZtyyenteikishrkngk) {
        ztyyenteikishrkngk = pZtyyenteikishrkngk;
    }

    private BizNumber ztysiteituukateikishrkngk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYSITEITUUKATEIKISHRKNGK)
    public BizNumber getZtysiteituukateikishrkngk() {
        return ztysiteituukateikishrkngk;
    }

    public void setZtysiteituukateikishrkngk(BizNumber pZtysiteituukateikishrkngk) {
        ztysiteituukateikishrkngk = pZtysiteituukateikishrkngk;
    }

    private String ztyyobiv98;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYOBIV98)
    public String getZtyyobiv98() {
        return ztyyobiv98;
    }

    public void setZtyyobiv98(String pZtyyobiv98) {
        ztyyobiv98 = pZtyyobiv98;
    }

    private Long ztyyenkihonhijynbris;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENKIHONHIJYNBRIS)
    public Long getZtyyenkihonhijynbris() {
        return ztyyenkihonhijynbris;
    }

    public void setZtyyenkihonhijynbris(Long pZtyyenkihonhijynbris) {
        ztyyenkihonhijynbris = pZtyyenkihonhijynbris;
    }

    private Long ztyyenkihonitijibarais;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENKIHONITIJIBARAIS)
    public Long getZtyyenkihonitijibarais() {
        return ztyyenkihonitijibarais;
    }

    public void setZtyyenkihonitijibarais(Long pZtyyenkihonitijibarais) {
        ztyyenkihonitijibarais = pZtyyenkihonitijibarais;
    }

    private Long ztyyenkihonhijynbrip;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENKIHONHIJYNBRIP)
    public Long getZtyyenkihonhijynbrip() {
        return ztyyenkihonhijynbrip;
    }

    public void setZtyyenkihonhijynbrip(Long pZtyyenkihonhijynbrip) {
        ztyyenkihonhijynbrip = pZtyyenkihonhijynbrip;
    }

    private Long ztyyenkihonitijibaraip;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYENKIHONITIJIBARAIP)
    public Long getZtyyenkihonitijibaraip() {
        return ztyyenkihonitijibaraip;
    }

    public void setZtyyenkihonitijibaraip(Long pZtyyenkihonitijibaraip) {
        ztyyenkihonitijibaraip = pZtyyenkihonitijibaraip;
    }

    private String ztytrkkzk1trkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTRKKZK1TRKARIHYJ)
    public String getZtytrkkzk1trkarihyj() {
        return ztytrkkzk1trkarihyj;
    }

    public void setZtytrkkzk1trkarihyj(String pZtytrkkzk1trkarihyj) {
        ztytrkkzk1trkarihyj = pZtytrkkzk1trkarihyj;
    }

    private String ztytrkkzk2trkarihyj;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYTRKKZK2TRKARIHYJ)
    public String getZtytrkkzk2trkarihyj() {
        return ztytrkkzk2trkarihyj;
    }

    public void setZtytrkkzk2trkarihyj(String pZtytrkkzk2trkarihyj) {
        ztytrkkzk2trkarihyj = pZtytrkkzk2trkarihyj;
    }

    private String ztyyno7keta;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYNO7KETA)
    public String getZtyyno7keta() {
        return ztyyno7keta;
    }

    public void setZtyyno7keta(String pZtyyno7keta) {
        ztyyno7keta = pZtyyno7keta;
    }

    private String ztyyobiv241;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYOBIV241)
    public String getZtyyobiv241() {
        return ztyyobiv241;
    }

    public void setZtyyobiv241(String pZtyyobiv241) {
        ztyyobiv241 = pZtyyobiv241;
    }

    private String ztyyobiv26;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYOBIV26)
    public String getZtyyobiv26() {
        return ztyyobiv26;
    }

    public void setZtyyobiv26(String pZtyyobiv26) {
        ztyyobiv26 = pZtyyobiv26;
    }

    private String ztyyobiv250x2;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYOBIV250X2)
    public String getZtyyobiv250x2() {
        return ztyyobiv250x2;
    }

    public void setZtyyobiv250x2(String pZtyyobiv250x2) {
        ztyyobiv250x2 = pZtyyobiv250x2;
    }

    private String ztyyobiv50;

    @Column(name=GenZT_KokyakuYuyuKykmeisaiFTy.ZTYYOBIV50)
    public String getZtyyobiv50() {
        return ztyyobiv50;
    }

    public void setZtyyobiv50(String pZtyyobiv50) {
        ztyyobiv50 = pZtyyobiv50;
    }
}