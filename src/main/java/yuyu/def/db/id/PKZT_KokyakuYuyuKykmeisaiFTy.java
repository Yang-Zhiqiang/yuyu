package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.mapping.GenZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.meta.GenQZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.db.meta.QZT_KokyakuYuyuKykmeisaiFTy;

/**
 * 顧客用ゆうゆう契約明細Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KokyakuYuyuKykmeisaiFTy}</td><td colspan="3">顧客用ゆうゆう契約明細Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztysyono</td><td>（中継用）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkmnenkansanp</td><td>（中継用）払込年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyengyousekihosyous</td><td>（中継用）円換算業績保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysymtymd</td><td>（中継用）消滅年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyukeiyakukigou</td><td>（中継用）主契約記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykykratesedaikbn</td><td>（中継用）主契約レート世代区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyudkaigomehrtkarihyj</td><td>（中継用）重度介護前払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypmentokuyakukbn</td><td>（中継用）Ｐ免特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrtkykarihyj</td><td>（中継用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv158</td><td>（中継用）予備項目Ｖ１５８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsyym</td><td>（中継用）募集年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkyknm18</td><td>（中継用）カナ契約者名（１８文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkyknm</td><td>（中継用）漢字契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseiymd</td><td>（中継用）契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyanen3</td><td>（中継用）契約者年齢（３桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjikyksyanen</td><td>（中継用）契約時契約者年齢</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuusinsakihumeihyj</td><td>（中継用）通信先不明表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihontikucd</td><td>（中継用）基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytodouhukencd</td><td>（中継用）都道府県コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysikutyousoncd5</td><td>（中継用）市区町村コード（５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjadr62</td><td>（中継用）漢字住所（６２文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytelno</td><td>（中継用）電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2telno</td><td>（中継用）第２電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknhhknmei</td><td>（中継用）カナ被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjhhknmei</td><td>（中継用）漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseiymd</td><td>（中継用）被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen</td><td>（中継用）被保険者年齢</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjihhknnen</td><td>（中継用）契約時被保険者年齢</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymannenreikykhyj</td><td>（中継用）満年齢契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyhhknsydouituhyouji</td><td>（中継用）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykjyutikbn</td><td>（中継用）契約状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyannaifuyouriyuukbn</td><td>（中継用）案内不要理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoumetucd</td><td>（中継用）消滅コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytorihikikaisiymd</td><td>（中継用）取引開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypowerfulhyj</td><td>（中継用）パワフル表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylargehyj</td><td>（中継用）ラージ表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouhinbunruikbn</td><td>（中継用）商品分類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouhnnmkbn</td><td>（中継用）商品名称区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknnmcd</td><td>（中継用）保険名称コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkbthsyukiknmanryouym</td><td>（中継用）特別保障期間満了年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyldownym</td><td>（中継用）Ｌダウン年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkmanryouym</td><td>（中継用）払込満了年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymankiym</td><td>（中継用）満期年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykykyoteiriritu</td><td>（中継用）主契約予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyrserieshyj</td><td>（中継用）Ｒシリーズ表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyduketorihouhoukbn</td><td>（中継用）Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyinfoteikyoutsghyj</td><td>（中継用）情報提供対象外表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynaimitukykhyj</td><td>（中継用）内密契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymrarihyj</td><td>（中継用）ＭＲ有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykasitukenaimituhyj</td><td>（中継用）貸付内密表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdktyuuiarihyj</td><td>（中継用）手続注意情報有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdktyuuisetkacd1</td><td>（中継用）手続注意台帳設定課コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdktyuuisetymd1</td><td>（中継用）手続注意台帳設定年月日１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdktyuuisetkbn1</td><td>（中継用）手続注意台帳設定区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdktyuuisetkacd2</td><td>（中継用）手続注意台帳設定課コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdktyuuisetymd2</td><td>（中継用）手続注意台帳設定年月日２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdktyuuisetkbn2</td><td>（中継用）手続注意台帳設定区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyttdktyuui3kenijyouhyj</td><td>（中継用）手続注意３件以上あり表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysentakujyouhouarihyouji</td><td>（中継用）選択情報有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystknsetkykhyj</td><td>（中継用）質権設定契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenharaikomip</td><td>（中継用）円換算払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyenkihons</td><td>（中継用）円換算基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyensibous</td><td>（中継用）円換算死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhrkhuhukbn</td><td>（中継用）払込方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyuunoukeirokbn</td><td>（中継用）収納経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycalckijyunymd</td><td>（中継用）計算基準年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytumitatedzndk</td><td>（中継用）積立Ｄ残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytumitatedzndkhunouhyj</td><td>（中継用）積立Ｄ残高計算不能表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenatkihyj</td><td>（中継用）代理店扱表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantou1sisyacd</td><td>（中継用）担当１支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantou1sibucd</td><td>（中継用）担当１支部コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantou1kojincd</td><td>（中継用）担当１個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantou1tantoukaisiymd</td><td>（中継用）担当１担当開始年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantou1tantousyakbn</td><td>（中継用）担当１担当者区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantou2sisyacd</td><td>（中継用）担当２支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantou2sibucd</td><td>（中継用）担当２支部コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantou2kojincd</td><td>（中継用）担当２個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantou2tantoukaisiymd</td><td>（中継用）担当２担当開始年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytantou2tantousyakbn</td><td>（中継用）担当２担当者区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysikijikbn</td><td>（中継用）職事区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikyou1sosikicd</td><td>（中継用）情報提供先１組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikyou1kojincd</td><td>（中継用）情報提供先１個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikyou1tantoukbn</td><td>（中継用）情報提供先１担当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikyou2sosikicd</td><td>（中継用）情報提供先２組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikyou2kojincd</td><td>（中継用）情報提供先２個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikyou2tantoukbn</td><td>（中継用）情報提供先２担当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyadrsyokansisyacd</td><td>（中継用）住所所管支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhyukjsaki1sosikicd</td><td>（中継用）保有計上先１組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhyukjsaki1kojincd</td><td>（中継用）保有計上先１個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhyukjsaki1tantoukbn</td><td>（中継用）保有計上先１担当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhyukjsaki2sosikicd</td><td>（中継用）保有計上先２組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhyukjsaki2kojincd</td><td>（中継用）保有計上先２個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhyukjsaki2tantoukbn</td><td>（中継用）保有計上先２担当区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyinfotysytymd</td><td>（中継用）情報抽出年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdairiseikyuutkykarihyj</td><td>（中継用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhouteityotikuhknhyj</td><td>（中継用）法定貯蓄性保険表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrctservicekbn</td><td>（中継用）ダイレクトサービス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhksuhngktkbtknjgnkbn</td><td>（中継用）複数変額特別勘定群区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiteituukakbn</td><td>（中継用）指定通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymkhyouyenhknhentkarihyj</td><td>（中継用）目標到達時円建保険変更特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenkhrikmtkarihyj</td><td>（中継用）円貨払込特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystigihrikmtkarihyj</td><td>（中継用）指定外通貨払込特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenshrgksitihsyutkhyj</td><td>（中継用）円換算支払額最低保証特約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiteituukaharaikomip</td><td>（中継用）指定通貨建払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyhrktuukaharaikomip</td><td>（中継用）払込通貨建払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiteituukakihonsx2</td><td>（中継用）指定通貨建基本Ｓ＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztysiteituukasibous</td><td>（中継用）指定通貨建死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyteikisiharaiarihyj</td><td>（中継用）定期支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenteikishrkngk</td><td>（中継用）円換算定期支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysiteituukateikishrkngk</td><td>（中継用）指定通貨建定期支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyobiv98</td><td>（中継用）予備項目Ｖ９８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenkihonhijynbris</td><td>（中継用）円換算基本平準払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyenkihonitijibarais</td><td>（中継用）円換算基本一時払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyenkihonhijynbrip</td><td>（中継用）円換算基本平準払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyyenkihonitijibaraip</td><td>（中継用）円換算基本一時払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztytrkkzk1trkarihyj</td><td>（中継用）登録家族１登録有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkkzk2trkarihyj</td><td>（中継用）登録家族２登録有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyno7keta</td><td>（中継用）郵便番号（７桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv241</td><td>（中継用）予備項目Ｖ２４１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv26</td><td>（中継用）予備項目Ｖ２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250x2</td><td>（中継用）予備項目Ｖ２５０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv50</td><td>（中継用）予備項目Ｖ５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KokyakuYuyuKykmeisaiFTy
 * @see     GenZT_KokyakuYuyuKykmeisaiFTy
 * @see     QZT_KokyakuYuyuKykmeisaiFTy
 * @see     GenQZT_KokyakuYuyuKykmeisaiFTy
 */
public class PKZT_KokyakuYuyuKykmeisaiFTy extends AbstractExDBPrimaryKey<ZT_KokyakuYuyuKykmeisaiFTy, PKZT_KokyakuYuyuKykmeisaiFTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KokyakuYuyuKykmeisaiFTy() {
    }

    public PKZT_KokyakuYuyuKykmeisaiFTy(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ZT_KokyakuYuyuKykmeisaiFTy> getEntityClass() {
        return ZT_KokyakuYuyuKykmeisaiFTy.class;
    }

    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}