package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.mapping.GenZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.meta.GenQZT_KokyakuYuyuKykmeisaiFRn;
import yuyu.def.db.meta.QZT_KokyakuYuyuKykmeisaiFRn;

/**
 * 顧客用ゆうゆう契約明細Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KokyakuYuyuKykmeisaiFRn}</td><td colspan="3">顧客用ゆうゆう契約明細Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsequenceno zrnsequenceno}</td><td>（連携用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkmnenkansanp</td><td>（連携用）払込年換算Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyengyousekihosyous</td><td>（連携用）円換算業績保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsymtymd</td><td>（連携用）消滅年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyukeiyakukigou</td><td>（連携用）主契約記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykykratesedaikbn</td><td>（連携用）主契約レート世代区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyudkaigomehrtkarihyj</td><td>（連携用）重度介護前払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpmentokuyakukbn</td><td>（連携用）Ｐ免特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdrtkykarihyj</td><td>（連携用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv158</td><td>（連携用）予備項目Ｖ１５８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsyym</td><td>（連携用）募集年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknkyknm18</td><td>（連携用）カナ契約者名（１８文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkyknm</td><td>（連携用）漢字契約者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseiymd</td><td>（連携用）契約者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyanen3</td><td>（連携用）契約者年齢（３桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjikyksyanen</td><td>（連携用）契約時契約者年齢</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuusinsakihumeihyj</td><td>（連携用）通信先不明表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihontikucd</td><td>（連携用）基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntodouhukencd</td><td>（連携用）都道府県コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsikutyousoncd5</td><td>（連携用）市区町村コード（５桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjadr62</td><td>（連携用）漢字住所（６２文字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntelno</td><td>（連携用）電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai2telno</td><td>（連携用）第２電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknhhknmei</td><td>（連携用）カナ被保険者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnknjhhknmei</td><td>（連携用）漢字被保険者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknseiymd</td><td>（連携用）被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen</td><td>（連携用）被保険者年齢</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjihhknnen</td><td>（連携用）契約時被保険者年齢</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmannenreikykhyj</td><td>（連携用）満年齢契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyhhknsydouituhyouji</td><td>（連携用）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykjyutikbn</td><td>（連携用）契約状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnannaifuyouriyuukbn</td><td>（連携用）案内不要理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoumetucd</td><td>（連携用）消滅コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntorihikikaisiymd</td><td>（連携用）取引開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpowerfulhyj</td><td>（連携用）パワフル表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnlargehyj</td><td>（連携用）ラージ表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyouhinbunruikbn</td><td>（連携用）商品分類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyouhnnmkbn</td><td>（連携用）商品名称区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknnmcd</td><td>（連携用）保険名称コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntkbthsyukiknmanryouym</td><td>（連携用）特別保障期間満了年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnldownym</td><td>（連携用）Ｌダウン年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkmanryouym</td><td>（連携用）払込満了年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmankiym</td><td>（連携用）満期年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykykyoteiriritu</td><td>（連携用）主契約予定利率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnrserieshyj</td><td>（連携用）Ｒシリーズ表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnduketorihouhoukbn</td><td>（連携用）Ｄ受取方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrninfoteikyoutsghyj</td><td>（連携用）情報提供対象外表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnaimitukykhyj</td><td>（連携用）内密契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmrarihyj</td><td>（連携用）ＭＲ有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkasitukenaimituhyj</td><td>（連携用）貸付内密表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdktyuuiarihyj</td><td>（連携用）手続注意情報有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdktyuuisetkacd1</td><td>（連携用）手続注意台帳設定課コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdktyuuisetymd1</td><td>（連携用）手続注意台帳設定年月日１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdktyuuisetkbn1</td><td>（連携用）手続注意台帳設定区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdktyuuisetkacd2</td><td>（連携用）手続注意台帳設定課コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdktyuuisetymd2</td><td>（連携用）手続注意台帳設定年月日２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdktyuuisetkbn2</td><td>（連携用）手続注意台帳設定区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnttdktyuui3kenijyouhyj</td><td>（連携用）手続注意３件以上あり表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsentakujyouhouarihyouji</td><td>（連携用）選択情報有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstknsetkykhyj</td><td>（連携用）質権設定契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenharaikomip</td><td>（連携用）円換算払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyenkihons</td><td>（連携用）円換算基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyensibous</td><td>（連携用）円換算死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhrkhuhukbn</td><td>（連携用）払込方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyuunoukeirokbn</td><td>（連携用）収納経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncalckijyunymd</td><td>（連携用）計算基準年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntumitatedzndk</td><td>（連携用）積立Ｄ残高</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntumitatedzndkhunouhyj</td><td>（連携用）積立Ｄ残高計算不能表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenatkihyj</td><td>（連携用）代理店扱表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantou1sisyacd</td><td>（連携用）担当１支社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantou1sibucd</td><td>（連携用）担当１支部コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantou1kojincd</td><td>（連携用）担当１個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantou1tantoukaisiymd</td><td>（連携用）担当１担当開始年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantou1tantousyakbn</td><td>（連携用）担当１担当者区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantou2sisyacd</td><td>（連携用）担当２支社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantou2sibucd</td><td>（連携用）担当２支部コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantou2kojincd</td><td>（連携用）担当２個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantou2tantoukaisiymd</td><td>（連携用）担当２担当開始年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntantou2tantousyakbn</td><td>（連携用）担当２担当者区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsikijikbn</td><td>（連携用）職事区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikyou1sosikicd</td><td>（連携用）情報提供先１組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikyou1kojincd</td><td>（連携用）情報提供先１個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikyou1tantoukbn</td><td>（連携用）情報提供先１担当区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikyou2sosikicd</td><td>（連携用）情報提供先２組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikyou2kojincd</td><td>（連携用）情報提供先２個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikyou2tantoukbn</td><td>（連携用）情報提供先２担当区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnadrsyokansisyacd</td><td>（連携用）住所所管支社コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhyukjsaki1sosikicd</td><td>（連携用）保有計上先１組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhyukjsaki1kojincd</td><td>（連携用）保有計上先１個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhyukjsaki1tantoukbn</td><td>（連携用）保有計上先１担当区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhyukjsaki2sosikicd</td><td>（連携用）保有計上先２組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhyukjsaki2kojincd</td><td>（連携用）保有計上先２個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhyukjsaki2tantoukbn</td><td>（連携用）保有計上先２担当区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrninfotysytymd</td><td>（連携用）情報抽出年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdairiseikyuutkykarihyj</td><td>（連携用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhouteityotikuhknhyj</td><td>（連携用）法定貯蓄性保険表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrctservicekbn</td><td>（連携用）ダイレクトサービス区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhksuhngktkbtknjgnkbn</td><td>（連携用）複数変額特別勘定群区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiteituukakbn</td><td>（連携用）指定通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmkhyouyenhknhentkarihyj</td><td>（連携用）目標到達時円建保険変更特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenkhrikmtkarihyj</td><td>（連携用）円貨払込特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstigihrikmtkarihyj</td><td>（連携用）指定外通貨払込特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenshrgksitihsyutkhyj</td><td>（連携用）円換算支払額最低保証特約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsiteituukaharaikomip</td><td>（連携用）指定通貨建払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnhrktuukaharaikomip</td><td>（連携用）払込通貨建払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiteituukakihonsx2</td><td>（連携用）指定通貨建基本Ｓ＿２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnsiteituukasibous</td><td>（連携用）指定通貨建死亡Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnteikisiharaiarihyj</td><td>（連携用）定期支払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenteikishrkngk</td><td>（連携用）円換算定期支払金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsiteituukateikishrkngk</td><td>（連携用）指定通貨建定期支払金額</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyobiv98</td><td>（連携用）予備項目Ｖ９８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenkihonhijynbris</td><td>（連携用）円換算基本平準払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyenkihonitijibarais</td><td>（連携用）円換算基本一時払Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyenkihonhijynbrip</td><td>（連携用）円換算基本平準払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnyenkihonitijibaraip</td><td>（連携用）円換算基本一時払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrntrkkzk1trkarihyj</td><td>（連携用）登録家族１登録有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntrkkzk2trkarihyj</td><td>（連携用）登録家族２登録有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyno7keta</td><td>（連携用）郵便番号（７桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv241</td><td>（連携用）予備項目Ｖ２４１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv26</td><td>（連携用）予備項目Ｖ２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250x2</td><td>（連携用）予備項目Ｖ２５０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv50</td><td>（連携用）予備項目Ｖ５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KokyakuYuyuKykmeisaiFRn
 * @see     GenZT_KokyakuYuyuKykmeisaiFRn
 * @see     QZT_KokyakuYuyuKykmeisaiFRn
 * @see     GenQZT_KokyakuYuyuKykmeisaiFRn
 */
public class PKZT_KokyakuYuyuKykmeisaiFRn extends AbstractExDBPrimaryKey<ZT_KokyakuYuyuKykmeisaiFRn, PKZT_KokyakuYuyuKykmeisaiFRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KokyakuYuyuKykmeisaiFRn() {
    }

    public PKZT_KokyakuYuyuKykmeisaiFRn(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

    @Transient
    @Override
    public Class<ZT_KokyakuYuyuKykmeisaiFRn> getEntityClass() {
        return ZT_KokyakuYuyuKykmeisaiFRn.class;
    }

    private Integer zrnsequenceno;

    public Integer getZrnsequenceno() {
        return zrnsequenceno;
    }

    public void setZrnsequenceno(Integer pZrnsequenceno) {
        zrnsequenceno = pZrnsequenceno;
    }

}