package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_TiginSinkinBosRn;
import yuyu.def.db.id.PKZT_TiginSinkinBosRn;
import yuyu.def.db.meta.GenQZT_TiginSinkinBosRn;
import yuyu.def.db.meta.QZT_TiginSinkinBosRn;

/**
 * 地銀信金募集テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TiginSinkinBosRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TiginSinkinBosRn}</td><td colspan="3">地銀信金募集テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnseihowebidkbn zrnseihowebidkbn}</td><td>（連携用）生保ＷｅｂＩＤ区分</td><td align="center">{@link PKZT_TiginSinkinBosRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkojincd zrnseihowebkojincd}</td><td>（連携用）生保Ｗｅｂ個人コード</td><td align="center">{@link PKZT_TiginSinkinBosRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebitijihozonhyouji zrnseihowebitijihozonhyouji}</td><td>（連携用）生保Ｗｅｂ一時保存表示</td><td align="center">{@link PKZT_TiginSinkinBosRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebsekno zrnseihowebsekno}</td><td>（連携用）生保Ｗｅｂ設計書番号</td><td align="center">{@link PKZT_TiginSinkinBosRn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebcalckijyunymd zrnseihowebcalckijyunymd}</td><td>（連携用）生保Ｗｅｂ計算基準年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhknknnm zrnseihowebhhknknnm}</td><td>（連携用）生保Ｗｅｂ被保険者カナ氏名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhknkjnm zrnseihowebhhknkjnm}</td><td>（連携用）生保Ｗｅｂ被保険者漢字氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhknseiymd zrnseihowebhhknseiymd}</td><td>（連携用）生保Ｗｅｂ被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhknseikbn zrnseihowebhhknseikbn}</td><td>（連携用）生保Ｗｅｂ被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebmrhkihontikucd zrnseihowebmrhkihontikucd}</td><td>（連携用）生保Ｗｅｂマル被基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhknadr zrnseihowebhhknadr}</td><td>（連携用）生保Ｗｅｂ被保険者住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkykknnm zrnseihowebkykknnm}</td><td>（連携用）生保Ｗｅｂ契約者カナ氏名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkykkjnm zrnseihowebkykkjnm}</td><td>（連携用）生保Ｗｅｂ契約者漢字氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkyksyaseiymd zrnseihowebkyksyaseiymd}</td><td>（連携用）生保Ｗｅｂ契約者生年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebkyksyaseikbn zrnseihowebkyksyaseikbn}</td><td>（連携用）生保Ｗｅｂ契約者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkykkihontikucd zrnseihowebkykkihontikucd}</td><td>（連携用）生保Ｗｅｂ契約者基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkykadr zrnseihowebkykadr}</td><td>（連携用）生保Ｗｅｂ契約者住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhknsyuruino zrnseihowebhknsyuruino}</td><td>（連携用）生保Ｗｅｂ保険種類番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebhjkktkbn zrnseihowebhjkktkbn}</td><td>（連携用）生保Ｗｅｂ報状告知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhknkkn zrnseihowebhknkkn}</td><td>（連携用）生保Ｗｅｂ保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebphrkkikn zrnseihowebphrkkikn}</td><td>（連携用）生保ＷｅｂＰ払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebhrkkaisuukbn zrnseihowebhrkkaisuukbn}</td><td>（連携用）生保Ｗｅｂ払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhrkkeirokbn zrnseihowebhrkkeirokbn}</td><td>（連携用）生保Ｗｅｂ払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebsdpdkbn zrnseihowebsdpdkbn}</td><td>（連携用）生保ＷｅｂＳ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkihons zrnseihowebkihons}</td><td>（連携用）生保Ｗｅｂ基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebnksyuruikbn zrnseihowebnksyuruikbn}</td><td>（連携用）生保Ｗｅｂ年金種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihoweblntkkbn zrnseihoweblntkkbn}</td><td>（連携用）生保ＷｅｂＬＮ特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebnkshrarihyj zrnseihowebnkshrarihyj}</td><td>（連携用）生保Ｗｅｂ年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebmosno zrnseihowebmosno}</td><td>（連携用）生保Ｗｅｂ申込番号</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebsekykkigenymd zrnseihowebsekykkigenymd}</td><td>（連携用）生保Ｗｅｂ設計書有効期限年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebsksjsitencd zrnseihowebsksjsitencd}</td><td>（連携用）生保Ｗｅｂ作成時支店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebsbuktnrkkbn zrnseihowebsbuktnrkkbn}</td><td>（連携用）生保Ｗｅｂ死亡受取人入力区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebsbukttdkkbn zrnseihowebsbukttdkkbn}</td><td>（連携用）生保Ｗｅｂ死亡受取人続柄区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebsbuktknnm zrnseihowebsbuktknnm}</td><td>（連携用）生保Ｗｅｂ死亡受取人カナ氏名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebsbuktkjnm zrnseihowebsbuktkjnm}</td><td>（連携用）生保Ｗｅｂ死亡受取人漢字氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebsbuktseiymd zrnseihowebsbuktseiymd}</td><td>（連携用）生保Ｗｅｂ死亡受取人生年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebmosprtzmhyj zrnseihowebmosprtzmhyj}</td><td>（連携用）生保Ｗｅｂ申込書印刷済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebfstmossksymd zrnseihowebfstmossksymd}</td><td>（連携用）生保Ｗｅｂ初回申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebhnsyukyktdkkbn zrnseihowebhnsyukyktdkkbn}</td><td>（連携用）生保Ｗｅｂ編集後契約者続柄区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebbsyutrkno zrnseihowebbsyutrkno}</td><td>（連携用）生保Ｗｅｂ募集人登録番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhjnkitikbn zrnseihowebhjnkitikbn}</td><td>（連携用）生保Ｗｅｂ法人形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhjnkykhyj zrnseihowebhjnkykhyj}</td><td>（連携用）生保Ｗｅｂ法人契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebtksykmcd1 zrnseihowebtksykmcd1}</td><td>（連携用）生保Ｗｅｂ特殊項目コード１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebtksykmcd2 zrnseihowebtksykmcd2}</td><td>（連携用）生保Ｗｅｂ特殊項目コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebtksykmcd3 zrnseihowebtksykmcd3}</td><td>（連携用）生保Ｗｅｂ特殊項目コード３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebtksykmcd4 zrnseihowebtksykmcd4}</td><td>（連携用）生保Ｗｅｂ特殊項目コード４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebtksykmcd5 zrnseihowebtksykmcd5}</td><td>（連携用）生保Ｗｅｂ特殊項目コード５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebteiwkkn zrnseihowebteiwkkn}</td><td>（連携用）生保Ｗｅｂ低Ｗ期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhkntelno zrnseihowebhhkntelno}</td><td>（連携用）生保Ｗｅｂ被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkyktelno zrnseihowebkyktelno}</td><td>（連携用）生保Ｗｅｂ契約者電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebknhjnnm zrnseihowebknhjnnm}</td><td>（連携用）生保Ｗｅｂカナ法人名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkjhjnnm zrnseihowebkjhjnnm}</td><td>（連携用）生保Ｗｅｂ漢字法人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkndaihyounm zrnseihowebkndaihyounm}</td><td>（連携用）生保Ｗｅｂカナ代表者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkjdaihyounm zrnseihowebkjdaihyounm}</td><td>（連携用）生保Ｗｅｂ漢字代表者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebdaihyouktgkkbn zrnseihowebdaihyouktgkkbn}</td><td>（連携用）生保Ｗｅｂ代表者肩書区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebsykihrkp1 zrnseihowebsykihrkp1}</td><td>（連携用）生保Ｗｅｂ初回払込Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebmosp1 zrnseihowebmosp1}</td><td>（連携用）生保Ｗｅｂ申込Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebtkiyougyoutaikbn zrnseihowebtkiyougyoutaikbn}</td><td>（連携用）生保Ｗｅｂ統計用業態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebpaperlessmoshyj zrnseihowebpaperlessmoshyj}</td><td>（連携用）生保Ｗｅｂペーパーレス申込表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebdatasousinzmhyj zrnseihowebdatasousinzmhyj}</td><td>（連携用）生保Ｗｅｂデータ送信済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebdrtnskno zrnseihowebdrtnskno}</td><td>（連携用）生保Ｗｅｂ代理店設計書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebsbnksyukbn zrnseihowebsbnksyukbn}</td><td>（連携用）生保Ｗｅｂ死亡年金種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebaatkisyaknyuucd zrnseihowebaatkisyaknyuucd}</td><td>（連携用）生保ＷｅｂＡ扱者金融機関コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkeihidouituhyj zrnseihowebkeihidouituhyj}</td><td>（連携用）生保Ｗｅｂ契被同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebsiteituukakbn zrnseihowebsiteituukakbn}</td><td>（連携用）生保Ｗｅｂ指定通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebnykntuukakbn zrnseihowebnykntuukakbn}</td><td>（連携用）生保Ｗｅｂ入金通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebtargettkarihyj zrnseihowebtargettkarihyj}</td><td>（連携用）生保Ｗｅｂターゲット特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebtargettkkbn zrnseihowebtargettkkbn}</td><td>（連携用）生保Ｗｅｂターゲット特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebtargettkmkht zrnseihowebtargettkmkht}</td><td>（連携用）生保Ｗｅｂターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebnykntuukanykngk zrnseihowebnykntuukanykngk}</td><td>（連携用）生保Ｗｅｂ入金通貨入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebnykntukfsthrkp zrnseihowebnykntukfsthrkp}</td><td>（連携用）生保Ｗｅｂ入金通貨初回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebnykntuknexthrkp zrnseihowebnykntuknexthrkp}</td><td>（連携用）生保Ｗｅｂ入金通貨次回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebsaimankihyj zrnseihowebsaimankihyj}</td><td>（連携用）生保Ｗｅｂ才満期表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebrayhyj zrnseihowebrayhyj}</td><td>（連携用）生保ＷｅｂＲＡＹ表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebgnykntuknykngk zrnseihowebgnykntuknykngk}</td><td>（連携用）生保Ｗｅｂ外貨入金通貨入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebgnykntukfsthrkp zrnseihowebgnykntukfsthrkp}</td><td>（連携用）生保Ｗｅｂ外貨入金通貨初回Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebgnykntuknxthrkp zrnseihowebgnykntuknxthrkp}</td><td>（連携用）生保Ｗｅｂ外貨入金通貨次回Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebgaikakihonp zrnseihowebgaikakihonp}</td><td>（連携用）生保Ｗｅｂ外貨基本Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebkaigmehrtkarihyj zrnseihowebkaigmehrtkarihyj}</td><td>（連携用）生保Ｗｅｂ介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebyenhsyutkarihyj zrnseihowebyenhsyutkarihyj}</td><td>（連携用）生保Ｗｅｂ円最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebgaikakihons zrnseihowebgaikakihons}</td><td>（連携用）生保Ｗｅｂ外貨基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebdai1hknkkn zrnseihowebdai1hknkkn}</td><td>（連携用）生保Ｗｅｂ第１保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebkyksykgycd zrnseihowebkyksykgycd}</td><td>（連携用）生保Ｗｅｂ契約者職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkknmskhjnkitikbn zrnseihowebkknmskhjnkitikbn}</td><td>（連携用）生保Ｗｅｂ契勤務先法人形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkykottmsk zrnseihowebkykottmsk}</td><td>（連携用）生保Ｗｅｂ契約者お勤め先</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhknsykgycd zrnseihowebhhknsykgycd}</td><td>（連携用）生保Ｗｅｂ被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhknmskhjnkitikbn zrnseihowebhknmskhjnkitikbn}</td><td>（連携用）生保Ｗｅｂ被勤務先法人形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhknottmsk zrnseihowebhhknottmsk}</td><td>（連携用）生保Ｗｅｂ被保険者お勤め先</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhknnensyuukbn zrnseihowebhhknnensyuukbn}</td><td>（連携用）生保Ｗｅｂ被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplhhknkjnm zrnseihowebplhhknkjnm}</td><td>（連携用）生保ＷｅｂＰＬ被保険者漢字氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplkykkjnm zrnseihowebplkykkjnm}</td><td>（連携用）生保ＷｅｂＰＬ契約者漢字氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplhrkkeirokbn zrnseihowebplhrkkeirokbn}</td><td>（連携用）生保ＷｅｂＰＬ払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplsbuktnrkkbn zrnseihowebplsbuktnrkkbn}</td><td>（連携用）生保ＷｅｂＰＬ死亡受入力区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplsbukttdkkbn zrnseihowebplsbukttdkkbn}</td><td>（連携用）生保ＷｅｂＰＬ死亡受続柄区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplsbuktknnm zrnseihowebplsbuktknnm}</td><td>（連携用）生保ＷｅｂＰＬ死亡受カナ氏名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplsbuktkjnm zrnseihowebplsbuktkjnm}</td><td>（連携用）生保ＷｅｂＰＬ死亡受漢字氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplsbuktseiymd zrnseihowebplsbuktseiymd}</td><td>（連携用）生保ＷｅｂＰＬ死亡受生年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebplhhkntelno zrnseihowebplhhkntelno}</td><td>（連携用）生保ＷｅｂＰＬ被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplkyktelno zrnseihowebplkyktelno}</td><td>（連携用）生保ＷｅｂＰＬ契約者電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplkihontikucd zrnseihowebplkihontikucd}</td><td>（連携用）生保ＷｅｂＰＬ基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebpltsinadrkai zrnseihowebpltsinadrkai}</td><td>（連携用）生保ＷｅｂＰＬ通信先住所下位</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplhiikihontikucd zrnseihowebplhiikihontikucd}</td><td>（連携用）生保ＷｅｂＰＬ被基本地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebplhhknadr zrnseihowebplhhknadr}</td><td>（連携用）生保ＷｅｂＰＬ被保険者住所</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhnyppltzmhyj zrnseihowebhnyppltzmhyj}</td><td>（連携用）生保Ｗｅｂ汎用ＰＰＬ対応済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebssrndhbnwr zrnseihowebssrndhbnwr}</td><td>（連携用）生保Ｗｅｂ指数連動部分配分割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebtrtrndhbnwr zrnseihowebtrtrndhbnwr}</td><td>（連携用）生保Ｗｅｂ定率積立部分配分割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebsueokikkn zrnseihowebsueokikkn}</td><td>（連携用）生保Ｗｅｂ据置期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebmnkuktnrkkbn zrnseihowebmnkuktnrkkbn}</td><td>（連携用）生保Ｗｅｂ満期受取人入力区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebmnkukttdkkbn zrnseihowebmnkukttdkkbn}</td><td>（連携用）生保Ｗｅｂ満期受取人続柄区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebmnkuktknnm zrnseihowebmnkuktknnm}</td><td>（連携用）生保Ｗｅｂ満期受取人カナ氏名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebmnkuktkjnm zrnseihowebmnkuktkjnm}</td><td>（連携用）生保Ｗｅｂ満期受取人漢字氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebmnkuktseiymd zrnseihowebmnkuktseiymd}</td><td>（連携用）生保Ｗｅｂ満期受取人生年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebankenkanrino zrnseihowebankenkanrino}</td><td>（連携用）生保Ｗｅｂ案件管理番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebikkatup zrnseihowebikkatup}</td><td>（連携用）生保Ｗｅｂ一括払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebikkatubaraikbn zrnseihowebikkatubaraikbn}</td><td>（連携用）生保Ｗｅｂ一括払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebiktbrikaisuu zrnseihowebiktbrikaisuu}</td><td>（連携用）生保Ｗｅｂ一括払回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebzennoup zrnseihowebzennoup}</td><td>（連携用）生保Ｗｅｂ前納Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebgaikazennoup zrnseihowebgaikazennoup}</td><td>（連携用）生保Ｗｅｂ外貨前納Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseihowebzennoukkn zrnseihowebzennoukkn}</td><td>（連携用）生保Ｗｅｂ前納期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebzennouhyj zrnseihowebzennouhyj}</td><td>（連携用）生保Ｗｅｂ前納表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkydbosyuukjncd zrnseihowebkydbosyuukjncd}</td><td>（連携用）生保Ｗｅｂ共同募集個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkzktrkmoskbn zrnseihowebkzktrkmoskbn}</td><td>（連携用）生保Ｗｅｂご家族登録申込区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkzktdkkbn1 zrnseihowebkzktdkkbn1}</td><td>（連携用）生保Ｗｅｂご家族続柄区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkzkknnm1 zrnseihowebkzkknnm1}</td><td>（連携用）生保Ｗｅｂご家族カナ氏名１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkzkkjnm1 zrnseihowebkzkkjnm1}</td><td>（連携用）生保Ｗｅｂご家族漢字氏名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkzkseikbn1 zrnseihowebkzkseikbn1}</td><td>（連携用）生保Ｗｅｂご家族性別区分１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkzkseiymd1 zrnseihowebkzkseiymd1}</td><td>（連携用）生保Ｗｅｂご家族生年月日１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseihowebkzkkykdoukyohyj1 zrnseihowebkzkkykdoukyohyj1}</td><td>（連携用）生保Ｗｅｂご家族契同居表示１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkzkyno1 zrnseihowebkzkyno1}</td><td>（連携用）生保Ｗｅｂご家族郵便番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkzkadr1 zrnseihowebkzkadr1}</td><td>（連携用）生保Ｗｅｂご家族住所１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkzktelno1 zrnseihowebkzktelno1}</td><td>（連携用）生保Ｗｅｂご家族電話番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkykdrtkkanouhyj zrnseihowebkykdrtkkanouhyj}</td><td>（連携用）生保Ｗｅｂ契代理特約可能表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhkndrtkkanouhyj zrnseihowebhhkndrtkkanouhyj}</td><td>（連携用）生保Ｗｅｂ被代理特約可能表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebdrtkkbn zrnseihowebdrtkkbn}</td><td>（連携用）生保Ｗｅｂ代理特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebkykdrnrkkbn zrnseihowebkykdrnrkkbn}</td><td>（連携用）生保Ｗｅｂ契代理入力区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhkndrnrkkbn zrnseihowebhhkndrnrkkbn}</td><td>（連携用）生保Ｗｅｂ被代理入力区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhkndrtdkkbn zrnseihowebhhkndrtdkkbn}</td><td>（連携用）生保Ｗｅｂ被代理続柄区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhkndrknnm zrnseihowebhhkndrknnm}</td><td>（連携用）生保Ｗｅｂ被代理カナ氏名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhkndrkjnm zrnseihowebhhkndrkjnm}</td><td>（連携用）生保Ｗｅｂ被代理漢字氏名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseihowebhhkndrseiymd zrnseihowebhhkndrseiymd}</td><td>（連携用）生保Ｗｅｂ被代理生年月日</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     ZT_TiginSinkinBosRn
 * @see     PKZT_TiginSinkinBosRn
 * @see     QZT_TiginSinkinBosRn
 * @see     GenQZT_TiginSinkinBosRn
 */
@MappedSuperclass
@Table(name=GenZT_TiginSinkinBosRn.TABLE_NAME)
@IdClass(value=PKZT_TiginSinkinBosRn.class)
public abstract class GenZT_TiginSinkinBosRn extends AbstractExDBEntityForZDB<ZT_TiginSinkinBosRn, PKZT_TiginSinkinBosRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TiginSinkinBosRn";
    public static final String ZRNSEIHOWEBIDKBN         = "zrnseihowebidkbn";
    public static final String ZRNSEIHOWEBKOJINCD       = "zrnseihowebkojincd";
    public static final String ZRNSEIHOWEBITIJIHOZONHYOUJI = "zrnseihowebitijihozonhyouji";
    public static final String ZRNSEIHOWEBSEKNO         = "zrnseihowebsekno";
    public static final String ZRNSEIHOWEBCALCKIJYUNYMD = "zrnseihowebcalckijyunymd";
    public static final String ZRNSEIHOWEBHHKNKNNM      = "zrnseihowebhhknknnm";
    public static final String ZRNSEIHOWEBHHKNKJNM      = "zrnseihowebhhknkjnm";
    public static final String ZRNSEIHOWEBHHKNSEIYMD    = "zrnseihowebhhknseiymd";
    public static final String ZRNSEIHOWEBHHKNSEIKBN    = "zrnseihowebhhknseikbn";
    public static final String ZRNSEIHOWEBMRHKIHONTIKUCD = "zrnseihowebmrhkihontikucd";
    public static final String ZRNSEIHOWEBHHKNADR       = "zrnseihowebhhknadr";
    public static final String ZRNSEIHOWEBKYKKNNM       = "zrnseihowebkykknnm";
    public static final String ZRNSEIHOWEBKYKKJNM       = "zrnseihowebkykkjnm";
    public static final String ZRNSEIHOWEBKYKSYASEIYMD  = "zrnseihowebkyksyaseiymd";
    public static final String ZRNSEIHOWEBKYKSYASEIKBN  = "zrnseihowebkyksyaseikbn";
    public static final String ZRNSEIHOWEBKYKKIHONTIKUCD = "zrnseihowebkykkihontikucd";
    public static final String ZRNSEIHOWEBKYKADR        = "zrnseihowebkykadr";
    public static final String ZRNSEIHOWEBHKNSYURUINO   = "zrnseihowebhknsyuruino";
    public static final String ZRNSEIHOWEBHJKKTKBN      = "zrnseihowebhjkktkbn";
    public static final String ZRNSEIHOWEBHKNKKN        = "zrnseihowebhknkkn";
    public static final String ZRNSEIHOWEBPHRKKIKN      = "zrnseihowebphrkkikn";
    public static final String ZRNSEIHOWEBHRKKAISUUKBN  = "zrnseihowebhrkkaisuukbn";
    public static final String ZRNSEIHOWEBHRKKEIROKBN   = "zrnseihowebhrkkeirokbn";
    public static final String ZRNSEIHOWEBSDPDKBN       = "zrnseihowebsdpdkbn";
    public static final String ZRNSEIHOWEBKIHONS        = "zrnseihowebkihons";
    public static final String ZRNSEIHOWEBNKSYURUIKBN   = "zrnseihowebnksyuruikbn";
    public static final String ZRNSEIHOWEBLNTKKBN       = "zrnseihoweblntkkbn";
    public static final String ZRNSEIHOWEBNKSHRARIHYJ   = "zrnseihowebnkshrarihyj";
    public static final String ZRNSEIHOWEBMOSNO         = "zrnseihowebmosno";
    public static final String ZRNSEIHOWEBSEKYKKIGENYMD = "zrnseihowebsekykkigenymd";
    public static final String ZRNSEIHOWEBSKSJSITENCD   = "zrnseihowebsksjsitencd";
    public static final String ZRNSEIHOWEBSBUKTNRKKBN   = "zrnseihowebsbuktnrkkbn";
    public static final String ZRNSEIHOWEBSBUKTTDKKBN   = "zrnseihowebsbukttdkkbn";
    public static final String ZRNSEIHOWEBSBUKTKNNM     = "zrnseihowebsbuktknnm";
    public static final String ZRNSEIHOWEBSBUKTKJNM     = "zrnseihowebsbuktkjnm";
    public static final String ZRNSEIHOWEBSBUKTSEIYMD   = "zrnseihowebsbuktseiymd";
    public static final String ZRNSEIHOWEBMOSPRTZMHYJ   = "zrnseihowebmosprtzmhyj";
    public static final String ZRNSEIHOWEBFSTMOSSKSYMD  = "zrnseihowebfstmossksymd";
    public static final String ZRNSEIHOWEBHNSYUKYKTDKKBN = "zrnseihowebhnsyukyktdkkbn";
    public static final String ZRNSEIHOWEBBSYUTRKNO     = "zrnseihowebbsyutrkno";
    public static final String ZRNSEIHOWEBHJNKITIKBN    = "zrnseihowebhjnkitikbn";
    public static final String ZRNSEIHOWEBHJNKYKHYJ     = "zrnseihowebhjnkykhyj";
    public static final String ZRNSEIHOWEBTKSYKMCD1     = "zrnseihowebtksykmcd1";
    public static final String ZRNSEIHOWEBTKSYKMCD2     = "zrnseihowebtksykmcd2";
    public static final String ZRNSEIHOWEBTKSYKMCD3     = "zrnseihowebtksykmcd3";
    public static final String ZRNSEIHOWEBTKSYKMCD4     = "zrnseihowebtksykmcd4";
    public static final String ZRNSEIHOWEBTKSYKMCD5     = "zrnseihowebtksykmcd5";
    public static final String ZRNSEIHOWEBTEIWKKN       = "zrnseihowebteiwkkn";
    public static final String ZRNSEIHOWEBHHKNTELNO     = "zrnseihowebhhkntelno";
    public static final String ZRNSEIHOWEBKYKTELNO      = "zrnseihowebkyktelno";
    public static final String ZRNSEIHOWEBKNHJNNM       = "zrnseihowebknhjnnm";
    public static final String ZRNSEIHOWEBKJHJNNM       = "zrnseihowebkjhjnnm";
    public static final String ZRNSEIHOWEBKNDAIHYOUNM   = "zrnseihowebkndaihyounm";
    public static final String ZRNSEIHOWEBKJDAIHYOUNM   = "zrnseihowebkjdaihyounm";
    public static final String ZRNSEIHOWEBDAIHYOUKTGKKBN = "zrnseihowebdaihyouktgkkbn";
    public static final String ZRNSEIHOWEBSYKIHRKP1     = "zrnseihowebsykihrkp1";
    public static final String ZRNSEIHOWEBMOSP1         = "zrnseihowebmosp1";
    public static final String ZRNSEIHOWEBTKIYOUGYOUTAIKBN = "zrnseihowebtkiyougyoutaikbn";
    public static final String ZRNSEIHOWEBPAPERLESSMOSHYJ = "zrnseihowebpaperlessmoshyj";
    public static final String ZRNSEIHOWEBDATASOUSINZMHYJ = "zrnseihowebdatasousinzmhyj";
    public static final String ZRNSEIHOWEBDRTNSKNO      = "zrnseihowebdrtnskno";
    public static final String ZRNSEIHOWEBSBNKSYUKBN    = "zrnseihowebsbnksyukbn";
    public static final String ZRNSEIHOWEBAATKISYAKNYUUCD = "zrnseihowebaatkisyaknyuucd";
    public static final String ZRNSEIHOWEBKEIHIDOUITUHYJ = "zrnseihowebkeihidouituhyj";
    public static final String ZRNSEIHOWEBSITEITUUKAKBN = "zrnseihowebsiteituukakbn";
    public static final String ZRNSEIHOWEBNYKNTUUKAKBN  = "zrnseihowebnykntuukakbn";
    public static final String ZRNSEIHOWEBTARGETTKARIHYJ = "zrnseihowebtargettkarihyj";
    public static final String ZRNSEIHOWEBTARGETTKKBN   = "zrnseihowebtargettkkbn";
    public static final String ZRNSEIHOWEBTARGETTKMKHT  = "zrnseihowebtargettkmkht";
    public static final String ZRNSEIHOWEBNYKNTUUKANYKNGK = "zrnseihowebnykntuukanykngk";
    public static final String ZRNSEIHOWEBNYKNTUKFSTHRKP = "zrnseihowebnykntukfsthrkp";
    public static final String ZRNSEIHOWEBNYKNTUKNEXTHRKP = "zrnseihowebnykntuknexthrkp";
    public static final String ZRNSEIHOWEBSAIMANKIHYJ   = "zrnseihowebsaimankihyj";
    public static final String ZRNSEIHOWEBRAYHYJ        = "zrnseihowebrayhyj";
    public static final String ZRNSEIHOWEBGNYKNTUKNYKNGK = "zrnseihowebgnykntuknykngk";
    public static final String ZRNSEIHOWEBGNYKNTUKFSTHRKP = "zrnseihowebgnykntukfsthrkp";
    public static final String ZRNSEIHOWEBGNYKNTUKNXTHRKP = "zrnseihowebgnykntuknxthrkp";
    public static final String ZRNSEIHOWEBGAIKAKIHONP   = "zrnseihowebgaikakihonp";
    public static final String ZRNSEIHOWEBKAIGMEHRTKARIHYJ = "zrnseihowebkaigmehrtkarihyj";
    public static final String ZRNSEIHOWEBYENHSYUTKARIHYJ = "zrnseihowebyenhsyutkarihyj";
    public static final String ZRNSEIHOWEBGAIKAKIHONS   = "zrnseihowebgaikakihons";
    public static final String ZRNSEIHOWEBDAI1HKNKKN    = "zrnseihowebdai1hknkkn";
    public static final String ZRNSEIHOWEBKYKSYKGYCD    = "zrnseihowebkyksykgycd";
    public static final String ZRNSEIHOWEBKKNMSKHJNKITIKBN = "zrnseihowebkknmskhjnkitikbn";
    public static final String ZRNSEIHOWEBKYKOTTMSK     = "zrnseihowebkykottmsk";
    public static final String ZRNSEIHOWEBHHKNSYKGYCD   = "zrnseihowebhhknsykgycd";
    public static final String ZRNSEIHOWEBHKNMSKHJNKITIKBN = "zrnseihowebhknmskhjnkitikbn";
    public static final String ZRNSEIHOWEBHHKNOTTMSK    = "zrnseihowebhhknottmsk";
    public static final String ZRNSEIHOWEBHHKNNENSYUUKBN = "zrnseihowebhhknnensyuukbn";
    public static final String ZRNSEIHOWEBPLHHKNKJNM    = "zrnseihowebplhhknkjnm";
    public static final String ZRNSEIHOWEBPLKYKKJNM     = "zrnseihowebplkykkjnm";
    public static final String ZRNSEIHOWEBPLHRKKEIROKBN = "zrnseihowebplhrkkeirokbn";
    public static final String ZRNSEIHOWEBPLSBUKTNRKKBN = "zrnseihowebplsbuktnrkkbn";
    public static final String ZRNSEIHOWEBPLSBUKTTDKKBN = "zrnseihowebplsbukttdkkbn";
    public static final String ZRNSEIHOWEBPLSBUKTKNNM   = "zrnseihowebplsbuktknnm";
    public static final String ZRNSEIHOWEBPLSBUKTKJNM   = "zrnseihowebplsbuktkjnm";
    public static final String ZRNSEIHOWEBPLSBUKTSEIYMD = "zrnseihowebplsbuktseiymd";
    public static final String ZRNSEIHOWEBPLHHKNTELNO   = "zrnseihowebplhhkntelno";
    public static final String ZRNSEIHOWEBPLKYKTELNO    = "zrnseihowebplkyktelno";
    public static final String ZRNSEIHOWEBPLKIHONTIKUCD = "zrnseihowebplkihontikucd";
    public static final String ZRNSEIHOWEBPLTSINADRKAI  = "zrnseihowebpltsinadrkai";
    public static final String ZRNSEIHOWEBPLHIIKIHONTIKUCD = "zrnseihowebplhiikihontikucd";
    public static final String ZRNSEIHOWEBPLHHKNADR     = "zrnseihowebplhhknadr";
    public static final String ZRNSEIHOWEBHNYPPLTZMHYJ  = "zrnseihowebhnyppltzmhyj";
    public static final String ZRNSEIHOWEBSSRNDHBNWR    = "zrnseihowebssrndhbnwr";
    public static final String ZRNSEIHOWEBTRTRNDHBNWR   = "zrnseihowebtrtrndhbnwr";
    public static final String ZRNSEIHOWEBSUEOKIKKN     = "zrnseihowebsueokikkn";
    public static final String ZRNSEIHOWEBMNKUKTNRKKBN  = "zrnseihowebmnkuktnrkkbn";
    public static final String ZRNSEIHOWEBMNKUKTTDKKBN  = "zrnseihowebmnkukttdkkbn";
    public static final String ZRNSEIHOWEBMNKUKTKNNM    = "zrnseihowebmnkuktknnm";
    public static final String ZRNSEIHOWEBMNKUKTKJNM    = "zrnseihowebmnkuktkjnm";
    public static final String ZRNSEIHOWEBMNKUKTSEIYMD  = "zrnseihowebmnkuktseiymd";
    public static final String ZRNSEIHOWEBANKENKANRINO  = "zrnseihowebankenkanrino";
    public static final String ZRNSEIHOWEBIKKATUP       = "zrnseihowebikkatup";
    public static final String ZRNSEIHOWEBIKKATUBARAIKBN = "zrnseihowebikkatubaraikbn";
    public static final String ZRNSEIHOWEBIKTBRIKAISUU  = "zrnseihowebiktbrikaisuu";
    public static final String ZRNSEIHOWEBZENNOUP       = "zrnseihowebzennoup";
    public static final String ZRNSEIHOWEBGAIKAZENNOUP  = "zrnseihowebgaikazennoup";
    public static final String ZRNSEIHOWEBZENNOUKKN     = "zrnseihowebzennoukkn";
    public static final String ZRNSEIHOWEBZENNOUHYJ     = "zrnseihowebzennouhyj";
    public static final String ZRNSEIHOWEBKYDBOSYUUKJNCD = "zrnseihowebkydbosyuukjncd";
    public static final String ZRNSEIHOWEBKZKTRKMOSKBN  = "zrnseihowebkzktrkmoskbn";
    public static final String ZRNSEIHOWEBKZKTDKKBN1    = "zrnseihowebkzktdkkbn1";
    public static final String ZRNSEIHOWEBKZKKNNM1      = "zrnseihowebkzkknnm1";
    public static final String ZRNSEIHOWEBKZKKJNM1      = "zrnseihowebkzkkjnm1";
    public static final String ZRNSEIHOWEBKZKSEIKBN1    = "zrnseihowebkzkseikbn1";
    public static final String ZRNSEIHOWEBKZKSEIYMD1    = "zrnseihowebkzkseiymd1";
    public static final String ZRNSEIHOWEBKZKKYKDOUKYOHYJ1 = "zrnseihowebkzkkykdoukyohyj1";
    public static final String ZRNSEIHOWEBKZKYNO1       = "zrnseihowebkzkyno1";
    public static final String ZRNSEIHOWEBKZKADR1       = "zrnseihowebkzkadr1";
    public static final String ZRNSEIHOWEBKZKTELNO1     = "zrnseihowebkzktelno1";
    public static final String ZRNSEIHOWEBKYKDRTKKANOUHYJ = "zrnseihowebkykdrtkkanouhyj";
    public static final String ZRNSEIHOWEBHHKNDRTKKANOUHYJ = "zrnseihowebhhkndrtkkanouhyj";
    public static final String ZRNSEIHOWEBDRTKKBN       = "zrnseihowebdrtkkbn";
    public static final String ZRNSEIHOWEBKYKDRNRKKBN   = "zrnseihowebkykdrnrkkbn";
    public static final String ZRNSEIHOWEBHHKNDRNRKKBN  = "zrnseihowebhhkndrnrkkbn";
    public static final String ZRNSEIHOWEBHHKNDRTDKKBN  = "zrnseihowebhhkndrtdkkbn";
    public static final String ZRNSEIHOWEBHHKNDRKNNM    = "zrnseihowebhhkndrknnm";
    public static final String ZRNSEIHOWEBHHKNDRKJNM    = "zrnseihowebhhkndrkjnm";
    public static final String ZRNSEIHOWEBHHKNDRSEIYMD  = "zrnseihowebhhkndrseiymd";

    private final PKZT_TiginSinkinBosRn primaryKey;

    public GenZT_TiginSinkinBosRn() {
        primaryKey = new PKZT_TiginSinkinBosRn();
    }

    public GenZT_TiginSinkinBosRn(
        String pZrnseihowebidkbn,
        String pZrnseihowebkojincd,
        String pZrnseihowebitijihozonhyouji,
        Integer pZrnseihowebsekno
    ) {
        primaryKey = new PKZT_TiginSinkinBosRn(
            pZrnseihowebidkbn,
            pZrnseihowebkojincd,
            pZrnseihowebitijihozonhyouji,
            pZrnseihowebsekno
        );
    }

    @Transient
    @Override
    public PKZT_TiginSinkinBosRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TiginSinkinBosRn> getMetaClass() {
        return QZT_TiginSinkinBosRn.class;
    }

    @Id
    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBIDKBN)
    public String getZrnseihowebidkbn() {
        return getPrimaryKey().getZrnseihowebidkbn();
    }

    public void setZrnseihowebidkbn(String pZrnseihowebidkbn) {
        getPrimaryKey().setZrnseihowebidkbn(pZrnseihowebidkbn);
    }

    @Id
    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKOJINCD)
    public String getZrnseihowebkojincd() {
        return getPrimaryKey().getZrnseihowebkojincd();
    }

    public void setZrnseihowebkojincd(String pZrnseihowebkojincd) {
        getPrimaryKey().setZrnseihowebkojincd(pZrnseihowebkojincd);
    }

    @Id
    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBITIJIHOZONHYOUJI)
    public String getZrnseihowebitijihozonhyouji() {
        return getPrimaryKey().getZrnseihowebitijihozonhyouji();
    }

    public void setZrnseihowebitijihozonhyouji(String pZrnseihowebitijihozonhyouji) {
        getPrimaryKey().setZrnseihowebitijihozonhyouji(pZrnseihowebitijihozonhyouji);
    }

    @Id
    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSEKNO)
    public Integer getZrnseihowebsekno() {
        return getPrimaryKey().getZrnseihowebsekno();
    }

    public void setZrnseihowebsekno(Integer pZrnseihowebsekno) {
        getPrimaryKey().setZrnseihowebsekno(pZrnseihowebsekno);
    }

    private Integer zrnseihowebcalckijyunymd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBCALCKIJYUNYMD)
    public Integer getZrnseihowebcalckijyunymd() {
        return zrnseihowebcalckijyunymd;
    }

    public void setZrnseihowebcalckijyunymd(Integer pZrnseihowebcalckijyunymd) {
        zrnseihowebcalckijyunymd = pZrnseihowebcalckijyunymd;
    }

    private String zrnseihowebhhknknnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNKNNM)
    public String getZrnseihowebhhknknnm() {
        return zrnseihowebhhknknnm;
    }

    public void setZrnseihowebhhknknnm(String pZrnseihowebhhknknnm) {
        zrnseihowebhhknknnm = pZrnseihowebhhknknnm;
    }

    private String zrnseihowebhhknkjnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNKJNM)
    public String getZrnseihowebhhknkjnm() {
        return zrnseihowebhhknkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebhhknkjnm(String pZrnseihowebhhknkjnm) {
        zrnseihowebhhknkjnm = pZrnseihowebhhknkjnm;
    }

    private Integer zrnseihowebhhknseiymd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNSEIYMD)
    public Integer getZrnseihowebhhknseiymd() {
        return zrnseihowebhhknseiymd;
    }

    public void setZrnseihowebhhknseiymd(Integer pZrnseihowebhhknseiymd) {
        zrnseihowebhhknseiymd = pZrnseihowebhhknseiymd;
    }

    private String zrnseihowebhhknseikbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNSEIKBN)
    public String getZrnseihowebhhknseikbn() {
        return zrnseihowebhhknseikbn;
    }

    public void setZrnseihowebhhknseikbn(String pZrnseihowebhhknseikbn) {
        zrnseihowebhhknseikbn = pZrnseihowebhhknseikbn;
    }

    private String zrnseihowebmrhkihontikucd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBMRHKIHONTIKUCD)
    public String getZrnseihowebmrhkihontikucd() {
        return zrnseihowebmrhkihontikucd;
    }

    public void setZrnseihowebmrhkihontikucd(String pZrnseihowebmrhkihontikucd) {
        zrnseihowebmrhkihontikucd = pZrnseihowebmrhkihontikucd;
    }

    private String zrnseihowebhhknadr;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNADR)
    public String getZrnseihowebhhknadr() {
        return zrnseihowebhhknadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebhhknadr(String pZrnseihowebhhknadr) {
        zrnseihowebhhknadr = pZrnseihowebhhknadr;
    }

    private String zrnseihowebkykknnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKKNNM)
    public String getZrnseihowebkykknnm() {
        return zrnseihowebkykknnm;
    }

    public void setZrnseihowebkykknnm(String pZrnseihowebkykknnm) {
        zrnseihowebkykknnm = pZrnseihowebkykknnm;
    }

    private String zrnseihowebkykkjnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKKJNM)
    public String getZrnseihowebkykkjnm() {
        return zrnseihowebkykkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebkykkjnm(String pZrnseihowebkykkjnm) {
        zrnseihowebkykkjnm = pZrnseihowebkykkjnm;
    }

    private Integer zrnseihowebkyksyaseiymd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKSYASEIYMD)
    public Integer getZrnseihowebkyksyaseiymd() {
        return zrnseihowebkyksyaseiymd;
    }

    public void setZrnseihowebkyksyaseiymd(Integer pZrnseihowebkyksyaseiymd) {
        zrnseihowebkyksyaseiymd = pZrnseihowebkyksyaseiymd;
    }

    private String zrnseihowebkyksyaseikbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKSYASEIKBN)
    public String getZrnseihowebkyksyaseikbn() {
        return zrnseihowebkyksyaseikbn;
    }

    public void setZrnseihowebkyksyaseikbn(String pZrnseihowebkyksyaseikbn) {
        zrnseihowebkyksyaseikbn = pZrnseihowebkyksyaseikbn;
    }

    private String zrnseihowebkykkihontikucd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKKIHONTIKUCD)
    public String getZrnseihowebkykkihontikucd() {
        return zrnseihowebkykkihontikucd;
    }

    public void setZrnseihowebkykkihontikucd(String pZrnseihowebkykkihontikucd) {
        zrnseihowebkykkihontikucd = pZrnseihowebkykkihontikucd;
    }

    private String zrnseihowebkykadr;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKADR)
    public String getZrnseihowebkykadr() {
        return zrnseihowebkykadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebkykadr(String pZrnseihowebkykadr) {
        zrnseihowebkykadr = pZrnseihowebkykadr;
    }

    private Integer zrnseihowebhknsyuruino;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHKNSYURUINO)
    public Integer getZrnseihowebhknsyuruino() {
        return zrnseihowebhknsyuruino;
    }

    public void setZrnseihowebhknsyuruino(Integer pZrnseihowebhknsyuruino) {
        zrnseihowebhknsyuruino = pZrnseihowebhknsyuruino;
    }

    private String zrnseihowebhjkktkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHJKKTKBN)
    public String getZrnseihowebhjkktkbn() {
        return zrnseihowebhjkktkbn;
    }

    public void setZrnseihowebhjkktkbn(String pZrnseihowebhjkktkbn) {
        zrnseihowebhjkktkbn = pZrnseihowebhjkktkbn;
    }

    private Integer zrnseihowebhknkkn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHKNKKN)
    public Integer getZrnseihowebhknkkn() {
        return zrnseihowebhknkkn;
    }

    public void setZrnseihowebhknkkn(Integer pZrnseihowebhknkkn) {
        zrnseihowebhknkkn = pZrnseihowebhknkkn;
    }

    private Integer zrnseihowebphrkkikn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPHRKKIKN)
    public Integer getZrnseihowebphrkkikn() {
        return zrnseihowebphrkkikn;
    }

    public void setZrnseihowebphrkkikn(Integer pZrnseihowebphrkkikn) {
        zrnseihowebphrkkikn = pZrnseihowebphrkkikn;
    }

    private String zrnseihowebhrkkaisuukbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHRKKAISUUKBN)
    public String getZrnseihowebhrkkaisuukbn() {
        return zrnseihowebhrkkaisuukbn;
    }

    public void setZrnseihowebhrkkaisuukbn(String pZrnseihowebhrkkaisuukbn) {
        zrnseihowebhrkkaisuukbn = pZrnseihowebhrkkaisuukbn;
    }

    private String zrnseihowebhrkkeirokbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHRKKEIROKBN)
    public String getZrnseihowebhrkkeirokbn() {
        return zrnseihowebhrkkeirokbn;
    }

    public void setZrnseihowebhrkkeirokbn(String pZrnseihowebhrkkeirokbn) {
        zrnseihowebhrkkeirokbn = pZrnseihowebhrkkeirokbn;
    }

    private String zrnseihowebsdpdkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSDPDKBN)
    public String getZrnseihowebsdpdkbn() {
        return zrnseihowebsdpdkbn;
    }

    public void setZrnseihowebsdpdkbn(String pZrnseihowebsdpdkbn) {
        zrnseihowebsdpdkbn = pZrnseihowebsdpdkbn;
    }

    private Long zrnseihowebkihons;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKIHONS)
    public Long getZrnseihowebkihons() {
        return zrnseihowebkihons;
    }

    public void setZrnseihowebkihons(Long pZrnseihowebkihons) {
        zrnseihowebkihons = pZrnseihowebkihons;
    }

    private String zrnseihowebnksyuruikbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBNKSYURUIKBN)
    public String getZrnseihowebnksyuruikbn() {
        return zrnseihowebnksyuruikbn;
    }

    public void setZrnseihowebnksyuruikbn(String pZrnseihowebnksyuruikbn) {
        zrnseihowebnksyuruikbn = pZrnseihowebnksyuruikbn;
    }

    private String zrnseihoweblntkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBLNTKKBN)
    public String getZrnseihoweblntkkbn() {
        return zrnseihoweblntkkbn;
    }

    public void setZrnseihoweblntkkbn(String pZrnseihoweblntkkbn) {
        zrnseihoweblntkkbn = pZrnseihoweblntkkbn;
    }

    private String zrnseihowebnkshrarihyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBNKSHRARIHYJ)
    public String getZrnseihowebnkshrarihyj() {
        return zrnseihowebnkshrarihyj;
    }

    public void setZrnseihowebnkshrarihyj(String pZrnseihowebnkshrarihyj) {
        zrnseihowebnkshrarihyj = pZrnseihowebnkshrarihyj;
    }

    private Long zrnseihowebmosno;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBMOSNO)
    public Long getZrnseihowebmosno() {
        return zrnseihowebmosno;
    }

    public void setZrnseihowebmosno(Long pZrnseihowebmosno) {
        zrnseihowebmosno = pZrnseihowebmosno;
    }

    private Integer zrnseihowebsekykkigenymd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSEKYKKIGENYMD)
    public Integer getZrnseihowebsekykkigenymd() {
        return zrnseihowebsekykkigenymd;
    }

    public void setZrnseihowebsekykkigenymd(Integer pZrnseihowebsekykkigenymd) {
        zrnseihowebsekykkigenymd = pZrnseihowebsekykkigenymd;
    }

    private String zrnseihowebsksjsitencd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSKSJSITENCD)
    public String getZrnseihowebsksjsitencd() {
        return zrnseihowebsksjsitencd;
    }

    public void setZrnseihowebsksjsitencd(String pZrnseihowebsksjsitencd) {
        zrnseihowebsksjsitencd = pZrnseihowebsksjsitencd;
    }

    private String zrnseihowebsbuktnrkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSBUKTNRKKBN)
    public String getZrnseihowebsbuktnrkkbn() {
        return zrnseihowebsbuktnrkkbn;
    }

    public void setZrnseihowebsbuktnrkkbn(String pZrnseihowebsbuktnrkkbn) {
        zrnseihowebsbuktnrkkbn = pZrnseihowebsbuktnrkkbn;
    }

    private String zrnseihowebsbukttdkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSBUKTTDKKBN)
    public String getZrnseihowebsbukttdkkbn() {
        return zrnseihowebsbukttdkkbn;
    }

    public void setZrnseihowebsbukttdkkbn(String pZrnseihowebsbukttdkkbn) {
        zrnseihowebsbukttdkkbn = pZrnseihowebsbukttdkkbn;
    }

    private String zrnseihowebsbuktknnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSBUKTKNNM)
    public String getZrnseihowebsbuktknnm() {
        return zrnseihowebsbuktknnm;
    }

    public void setZrnseihowebsbuktknnm(String pZrnseihowebsbuktknnm) {
        zrnseihowebsbuktknnm = pZrnseihowebsbuktknnm;
    }

    private String zrnseihowebsbuktkjnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSBUKTKJNM)
    public String getZrnseihowebsbuktkjnm() {
        return zrnseihowebsbuktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebsbuktkjnm(String pZrnseihowebsbuktkjnm) {
        zrnseihowebsbuktkjnm = pZrnseihowebsbuktkjnm;
    }

    private Integer zrnseihowebsbuktseiymd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSBUKTSEIYMD)
    public Integer getZrnseihowebsbuktseiymd() {
        return zrnseihowebsbuktseiymd;
    }

    public void setZrnseihowebsbuktseiymd(Integer pZrnseihowebsbuktseiymd) {
        zrnseihowebsbuktseiymd = pZrnseihowebsbuktseiymd;
    }

    private String zrnseihowebmosprtzmhyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBMOSPRTZMHYJ)
    public String getZrnseihowebmosprtzmhyj() {
        return zrnseihowebmosprtzmhyj;
    }

    public void setZrnseihowebmosprtzmhyj(String pZrnseihowebmosprtzmhyj) {
        zrnseihowebmosprtzmhyj = pZrnseihowebmosprtzmhyj;
    }

    private Integer zrnseihowebfstmossksymd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBFSTMOSSKSYMD)
    public Integer getZrnseihowebfstmossksymd() {
        return zrnseihowebfstmossksymd;
    }

    public void setZrnseihowebfstmossksymd(Integer pZrnseihowebfstmossksymd) {
        zrnseihowebfstmossksymd = pZrnseihowebfstmossksymd;
    }

    private String zrnseihowebhnsyukyktdkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHNSYUKYKTDKKBN)
    public String getZrnseihowebhnsyukyktdkkbn() {
        return zrnseihowebhnsyukyktdkkbn;
    }

    public void setZrnseihowebhnsyukyktdkkbn(String pZrnseihowebhnsyukyktdkkbn) {
        zrnseihowebhnsyukyktdkkbn = pZrnseihowebhnsyukyktdkkbn;
    }

    private String zrnseihowebbsyutrkno;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBBSYUTRKNO)
    public String getZrnseihowebbsyutrkno() {
        return zrnseihowebbsyutrkno;
    }

    public void setZrnseihowebbsyutrkno(String pZrnseihowebbsyutrkno) {
        zrnseihowebbsyutrkno = pZrnseihowebbsyutrkno;
    }

    private String zrnseihowebhjnkitikbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHJNKITIKBN)
    public String getZrnseihowebhjnkitikbn() {
        return zrnseihowebhjnkitikbn;
    }

    public void setZrnseihowebhjnkitikbn(String pZrnseihowebhjnkitikbn) {
        zrnseihowebhjnkitikbn = pZrnseihowebhjnkitikbn;
    }

    private String zrnseihowebhjnkykhyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHJNKYKHYJ)
    public String getZrnseihowebhjnkykhyj() {
        return zrnseihowebhjnkykhyj;
    }

    public void setZrnseihowebhjnkykhyj(String pZrnseihowebhjnkykhyj) {
        zrnseihowebhjnkykhyj = pZrnseihowebhjnkykhyj;
    }

    private String zrnseihowebtksykmcd1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTKSYKMCD1)
    public String getZrnseihowebtksykmcd1() {
        return zrnseihowebtksykmcd1;
    }

    public void setZrnseihowebtksykmcd1(String pZrnseihowebtksykmcd1) {
        zrnseihowebtksykmcd1 = pZrnseihowebtksykmcd1;
    }

    private String zrnseihowebtksykmcd2;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTKSYKMCD2)
    public String getZrnseihowebtksykmcd2() {
        return zrnseihowebtksykmcd2;
    }

    public void setZrnseihowebtksykmcd2(String pZrnseihowebtksykmcd2) {
        zrnseihowebtksykmcd2 = pZrnseihowebtksykmcd2;
    }

    private String zrnseihowebtksykmcd3;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTKSYKMCD3)
    public String getZrnseihowebtksykmcd3() {
        return zrnseihowebtksykmcd3;
    }

    public void setZrnseihowebtksykmcd3(String pZrnseihowebtksykmcd3) {
        zrnseihowebtksykmcd3 = pZrnseihowebtksykmcd3;
    }

    private String zrnseihowebtksykmcd4;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTKSYKMCD4)
    public String getZrnseihowebtksykmcd4() {
        return zrnseihowebtksykmcd4;
    }

    public void setZrnseihowebtksykmcd4(String pZrnseihowebtksykmcd4) {
        zrnseihowebtksykmcd4 = pZrnseihowebtksykmcd4;
    }

    private String zrnseihowebtksykmcd5;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTKSYKMCD5)
    public String getZrnseihowebtksykmcd5() {
        return zrnseihowebtksykmcd5;
    }

    public void setZrnseihowebtksykmcd5(String pZrnseihowebtksykmcd5) {
        zrnseihowebtksykmcd5 = pZrnseihowebtksykmcd5;
    }

    private Long zrnseihowebteiwkkn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTEIWKKN)
    public Long getZrnseihowebteiwkkn() {
        return zrnseihowebteiwkkn;
    }

    public void setZrnseihowebteiwkkn(Long pZrnseihowebteiwkkn) {
        zrnseihowebteiwkkn = pZrnseihowebteiwkkn;
    }

    private String zrnseihowebhhkntelno;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNTELNO)
    public String getZrnseihowebhhkntelno() {
        return zrnseihowebhhkntelno;
    }

    public void setZrnseihowebhhkntelno(String pZrnseihowebhhkntelno) {
        zrnseihowebhhkntelno = pZrnseihowebhhkntelno;
    }

    private String zrnseihowebkyktelno;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKTELNO)
    public String getZrnseihowebkyktelno() {
        return zrnseihowebkyktelno;
    }

    public void setZrnseihowebkyktelno(String pZrnseihowebkyktelno) {
        zrnseihowebkyktelno = pZrnseihowebkyktelno;
    }

    private String zrnseihowebknhjnnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKNHJNNM)
    public String getZrnseihowebknhjnnm() {
        return zrnseihowebknhjnnm;
    }

    public void setZrnseihowebknhjnnm(String pZrnseihowebknhjnnm) {
        zrnseihowebknhjnnm = pZrnseihowebknhjnnm;
    }

    private String zrnseihowebkjhjnnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKJHJNNM)
    public String getZrnseihowebkjhjnnm() {
        return zrnseihowebkjhjnnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebkjhjnnm(String pZrnseihowebkjhjnnm) {
        zrnseihowebkjhjnnm = pZrnseihowebkjhjnnm;
    }

    private String zrnseihowebkndaihyounm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKNDAIHYOUNM)
    public String getZrnseihowebkndaihyounm() {
        return zrnseihowebkndaihyounm;
    }

    public void setZrnseihowebkndaihyounm(String pZrnseihowebkndaihyounm) {
        zrnseihowebkndaihyounm = pZrnseihowebkndaihyounm;
    }

    private String zrnseihowebkjdaihyounm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKJDAIHYOUNM)
    public String getZrnseihowebkjdaihyounm() {
        return zrnseihowebkjdaihyounm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebkjdaihyounm(String pZrnseihowebkjdaihyounm) {
        zrnseihowebkjdaihyounm = pZrnseihowebkjdaihyounm;
    }

    private String zrnseihowebdaihyouktgkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBDAIHYOUKTGKKBN)
    public String getZrnseihowebdaihyouktgkkbn() {
        return zrnseihowebdaihyouktgkkbn;
    }

    public void setZrnseihowebdaihyouktgkkbn(String pZrnseihowebdaihyouktgkkbn) {
        zrnseihowebdaihyouktgkkbn = pZrnseihowebdaihyouktgkkbn;
    }

    private Long zrnseihowebsykihrkp1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSYKIHRKP1)
    public Long getZrnseihowebsykihrkp1() {
        return zrnseihowebsykihrkp1;
    }

    public void setZrnseihowebsykihrkp1(Long pZrnseihowebsykihrkp1) {
        zrnseihowebsykihrkp1 = pZrnseihowebsykihrkp1;
    }

    private Long zrnseihowebmosp1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBMOSP1)
    public Long getZrnseihowebmosp1() {
        return zrnseihowebmosp1;
    }

    public void setZrnseihowebmosp1(Long pZrnseihowebmosp1) {
        zrnseihowebmosp1 = pZrnseihowebmosp1;
    }

    private String zrnseihowebtkiyougyoutaikbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTKIYOUGYOUTAIKBN)
    public String getZrnseihowebtkiyougyoutaikbn() {
        return zrnseihowebtkiyougyoutaikbn;
    }

    public void setZrnseihowebtkiyougyoutaikbn(String pZrnseihowebtkiyougyoutaikbn) {
        zrnseihowebtkiyougyoutaikbn = pZrnseihowebtkiyougyoutaikbn;
    }

    private String zrnseihowebpaperlessmoshyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPAPERLESSMOSHYJ)
    public String getZrnseihowebpaperlessmoshyj() {
        return zrnseihowebpaperlessmoshyj;
    }

    public void setZrnseihowebpaperlessmoshyj(String pZrnseihowebpaperlessmoshyj) {
        zrnseihowebpaperlessmoshyj = pZrnseihowebpaperlessmoshyj;
    }

    private String zrnseihowebdatasousinzmhyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBDATASOUSINZMHYJ)
    public String getZrnseihowebdatasousinzmhyj() {
        return zrnseihowebdatasousinzmhyj;
    }

    public void setZrnseihowebdatasousinzmhyj(String pZrnseihowebdatasousinzmhyj) {
        zrnseihowebdatasousinzmhyj = pZrnseihowebdatasousinzmhyj;
    }

    private String zrnseihowebdrtnskno;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBDRTNSKNO)
    public String getZrnseihowebdrtnskno() {
        return zrnseihowebdrtnskno;
    }

    public void setZrnseihowebdrtnskno(String pZrnseihowebdrtnskno) {
        zrnseihowebdrtnskno = pZrnseihowebdrtnskno;
    }

    private String zrnseihowebsbnksyukbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSBNKSYUKBN)
    public String getZrnseihowebsbnksyukbn() {
        return zrnseihowebsbnksyukbn;
    }

    public void setZrnseihowebsbnksyukbn(String pZrnseihowebsbnksyukbn) {
        zrnseihowebsbnksyukbn = pZrnseihowebsbnksyukbn;
    }

    private String zrnseihowebaatkisyaknyuucd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBAATKISYAKNYUUCD)
    public String getZrnseihowebaatkisyaknyuucd() {
        return zrnseihowebaatkisyaknyuucd;
    }

    public void setZrnseihowebaatkisyaknyuucd(String pZrnseihowebaatkisyaknyuucd) {
        zrnseihowebaatkisyaknyuucd = pZrnseihowebaatkisyaknyuucd;
    }

    private String zrnseihowebkeihidouituhyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKEIHIDOUITUHYJ)
    public String getZrnseihowebkeihidouituhyj() {
        return zrnseihowebkeihidouituhyj;
    }

    public void setZrnseihowebkeihidouituhyj(String pZrnseihowebkeihidouituhyj) {
        zrnseihowebkeihidouituhyj = pZrnseihowebkeihidouituhyj;
    }

    private String zrnseihowebsiteituukakbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSITEITUUKAKBN)
    public String getZrnseihowebsiteituukakbn() {
        return zrnseihowebsiteituukakbn;
    }

    public void setZrnseihowebsiteituukakbn(String pZrnseihowebsiteituukakbn) {
        zrnseihowebsiteituukakbn = pZrnseihowebsiteituukakbn;
    }

    private String zrnseihowebnykntuukakbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBNYKNTUUKAKBN)
    public String getZrnseihowebnykntuukakbn() {
        return zrnseihowebnykntuukakbn;
    }

    public void setZrnseihowebnykntuukakbn(String pZrnseihowebnykntuukakbn) {
        zrnseihowebnykntuukakbn = pZrnseihowebnykntuukakbn;
    }

    private String zrnseihowebtargettkarihyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTARGETTKARIHYJ)
    public String getZrnseihowebtargettkarihyj() {
        return zrnseihowebtargettkarihyj;
    }

    public void setZrnseihowebtargettkarihyj(String pZrnseihowebtargettkarihyj) {
        zrnseihowebtargettkarihyj = pZrnseihowebtargettkarihyj;
    }

    private String zrnseihowebtargettkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTARGETTKKBN)
    public String getZrnseihowebtargettkkbn() {
        return zrnseihowebtargettkkbn;
    }

    public void setZrnseihowebtargettkkbn(String pZrnseihowebtargettkkbn) {
        zrnseihowebtargettkkbn = pZrnseihowebtargettkkbn;
    }

    private Integer zrnseihowebtargettkmkht;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTARGETTKMKHT)
    public Integer getZrnseihowebtargettkmkht() {
        return zrnseihowebtargettkmkht;
    }

    public void setZrnseihowebtargettkmkht(Integer pZrnseihowebtargettkmkht) {
        zrnseihowebtargettkmkht = pZrnseihowebtargettkmkht;
    }

    private Long zrnseihowebnykntuukanykngk;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBNYKNTUUKANYKNGK)
    public Long getZrnseihowebnykntuukanykngk() {
        return zrnseihowebnykntuukanykngk;
    }

    public void setZrnseihowebnykntuukanykngk(Long pZrnseihowebnykntuukanykngk) {
        zrnseihowebnykntuukanykngk = pZrnseihowebnykntuukanykngk;
    }

    private Long zrnseihowebnykntukfsthrkp;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBNYKNTUKFSTHRKP)
    public Long getZrnseihowebnykntukfsthrkp() {
        return zrnseihowebnykntukfsthrkp;
    }

    public void setZrnseihowebnykntukfsthrkp(Long pZrnseihowebnykntukfsthrkp) {
        zrnseihowebnykntukfsthrkp = pZrnseihowebnykntukfsthrkp;
    }

    private Long zrnseihowebnykntuknexthrkp;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBNYKNTUKNEXTHRKP)
    public Long getZrnseihowebnykntuknexthrkp() {
        return zrnseihowebnykntuknexthrkp;
    }

    public void setZrnseihowebnykntuknexthrkp(Long pZrnseihowebnykntuknexthrkp) {
        zrnseihowebnykntuknexthrkp = pZrnseihowebnykntuknexthrkp;
    }

    private String zrnseihowebsaimankihyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSAIMANKIHYJ)
    public String getZrnseihowebsaimankihyj() {
        return zrnseihowebsaimankihyj;
    }

    public void setZrnseihowebsaimankihyj(String pZrnseihowebsaimankihyj) {
        zrnseihowebsaimankihyj = pZrnseihowebsaimankihyj;
    }

    private String zrnseihowebrayhyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBRAYHYJ)
    public String getZrnseihowebrayhyj() {
        return zrnseihowebrayhyj;
    }

    public void setZrnseihowebrayhyj(String pZrnseihowebrayhyj) {
        zrnseihowebrayhyj = pZrnseihowebrayhyj;
    }

    private Long zrnseihowebgnykntuknykngk;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBGNYKNTUKNYKNGK)
    public Long getZrnseihowebgnykntuknykngk() {
        return zrnseihowebgnykntuknykngk;
    }

    public void setZrnseihowebgnykntuknykngk(Long pZrnseihowebgnykntuknykngk) {
        zrnseihowebgnykntuknykngk = pZrnseihowebgnykntuknykngk;
    }

    private Long zrnseihowebgnykntukfsthrkp;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBGNYKNTUKFSTHRKP)
    public Long getZrnseihowebgnykntukfsthrkp() {
        return zrnseihowebgnykntukfsthrkp;
    }

    public void setZrnseihowebgnykntukfsthrkp(Long pZrnseihowebgnykntukfsthrkp) {
        zrnseihowebgnykntukfsthrkp = pZrnseihowebgnykntukfsthrkp;
    }

    private Long zrnseihowebgnykntuknxthrkp;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBGNYKNTUKNXTHRKP)
    public Long getZrnseihowebgnykntuknxthrkp() {
        return zrnseihowebgnykntuknxthrkp;
    }

    public void setZrnseihowebgnykntuknxthrkp(Long pZrnseihowebgnykntuknxthrkp) {
        zrnseihowebgnykntuknxthrkp = pZrnseihowebgnykntuknxthrkp;
    }

    private Long zrnseihowebgaikakihonp;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBGAIKAKIHONP)
    public Long getZrnseihowebgaikakihonp() {
        return zrnseihowebgaikakihonp;
    }

    public void setZrnseihowebgaikakihonp(Long pZrnseihowebgaikakihonp) {
        zrnseihowebgaikakihonp = pZrnseihowebgaikakihonp;
    }

    private String zrnseihowebkaigmehrtkarihyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKAIGMEHRTKARIHYJ)
    public String getZrnseihowebkaigmehrtkarihyj() {
        return zrnseihowebkaigmehrtkarihyj;
    }

    public void setZrnseihowebkaigmehrtkarihyj(String pZrnseihowebkaigmehrtkarihyj) {
        zrnseihowebkaigmehrtkarihyj = pZrnseihowebkaigmehrtkarihyj;
    }

    private String zrnseihowebyenhsyutkarihyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBYENHSYUTKARIHYJ)
    public String getZrnseihowebyenhsyutkarihyj() {
        return zrnseihowebyenhsyutkarihyj;
    }

    public void setZrnseihowebyenhsyutkarihyj(String pZrnseihowebyenhsyutkarihyj) {
        zrnseihowebyenhsyutkarihyj = pZrnseihowebyenhsyutkarihyj;
    }

    private Long zrnseihowebgaikakihons;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBGAIKAKIHONS)
    public Long getZrnseihowebgaikakihons() {
        return zrnseihowebgaikakihons;
    }

    public void setZrnseihowebgaikakihons(Long pZrnseihowebgaikakihons) {
        zrnseihowebgaikakihons = pZrnseihowebgaikakihons;
    }

    private Integer zrnseihowebdai1hknkkn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBDAI1HKNKKN)
    public Integer getZrnseihowebdai1hknkkn() {
        return zrnseihowebdai1hknkkn;
    }

    public void setZrnseihowebdai1hknkkn(Integer pZrnseihowebdai1hknkkn) {
        zrnseihowebdai1hknkkn = pZrnseihowebdai1hknkkn;
    }

    private String zrnseihowebkyksykgycd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKSYKGYCD)
    public String getZrnseihowebkyksykgycd() {
        return zrnseihowebkyksykgycd;
    }

    public void setZrnseihowebkyksykgycd(String pZrnseihowebkyksykgycd) {
        zrnseihowebkyksykgycd = pZrnseihowebkyksykgycd;
    }

    private String zrnseihowebkknmskhjnkitikbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKKNMSKHJNKITIKBN)
    public String getZrnseihowebkknmskhjnkitikbn() {
        return zrnseihowebkknmskhjnkitikbn;
    }

    public void setZrnseihowebkknmskhjnkitikbn(String pZrnseihowebkknmskhjnkitikbn) {
        zrnseihowebkknmskhjnkitikbn = pZrnseihowebkknmskhjnkitikbn;
    }

    private String zrnseihowebkykottmsk;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKOTTMSK)
    public String getZrnseihowebkykottmsk() {
        return zrnseihowebkykottmsk;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebkykottmsk(String pZrnseihowebkykottmsk) {
        zrnseihowebkykottmsk = pZrnseihowebkykottmsk;
    }

    private String zrnseihowebhhknsykgycd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNSYKGYCD)
    public String getZrnseihowebhhknsykgycd() {
        return zrnseihowebhhknsykgycd;
    }

    public void setZrnseihowebhhknsykgycd(String pZrnseihowebhhknsykgycd) {
        zrnseihowebhhknsykgycd = pZrnseihowebhhknsykgycd;
    }

    private String zrnseihowebhknmskhjnkitikbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHKNMSKHJNKITIKBN)
    public String getZrnseihowebhknmskhjnkitikbn() {
        return zrnseihowebhknmskhjnkitikbn;
    }

    public void setZrnseihowebhknmskhjnkitikbn(String pZrnseihowebhknmskhjnkitikbn) {
        zrnseihowebhknmskhjnkitikbn = pZrnseihowebhknmskhjnkitikbn;
    }

    private String zrnseihowebhhknottmsk;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNOTTMSK)
    public String getZrnseihowebhhknottmsk() {
        return zrnseihowebhhknottmsk;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebhhknottmsk(String pZrnseihowebhhknottmsk) {
        zrnseihowebhhknottmsk = pZrnseihowebhhknottmsk;
    }

    private String zrnseihowebhhknnensyuukbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNNENSYUUKBN)
    public String getZrnseihowebhhknnensyuukbn() {
        return zrnseihowebhhknnensyuukbn;
    }

    public void setZrnseihowebhhknnensyuukbn(String pZrnseihowebhhknnensyuukbn) {
        zrnseihowebhhknnensyuukbn = pZrnseihowebhhknnensyuukbn;
    }

    private String zrnseihowebplhhknkjnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLHHKNKJNM)
    public String getZrnseihowebplhhknkjnm() {
        return zrnseihowebplhhknkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebplhhknkjnm(String pZrnseihowebplhhknkjnm) {
        zrnseihowebplhhknkjnm = pZrnseihowebplhhknkjnm;
    }

    private String zrnseihowebplkykkjnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLKYKKJNM)
    public String getZrnseihowebplkykkjnm() {
        return zrnseihowebplkykkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebplkykkjnm(String pZrnseihowebplkykkjnm) {
        zrnseihowebplkykkjnm = pZrnseihowebplkykkjnm;
    }

    private String zrnseihowebplhrkkeirokbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLHRKKEIROKBN)
    public String getZrnseihowebplhrkkeirokbn() {
        return zrnseihowebplhrkkeirokbn;
    }

    public void setZrnseihowebplhrkkeirokbn(String pZrnseihowebplhrkkeirokbn) {
        zrnseihowebplhrkkeirokbn = pZrnseihowebplhrkkeirokbn;
    }

    private String zrnseihowebplsbuktnrkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLSBUKTNRKKBN)
    public String getZrnseihowebplsbuktnrkkbn() {
        return zrnseihowebplsbuktnrkkbn;
    }

    public void setZrnseihowebplsbuktnrkkbn(String pZrnseihowebplsbuktnrkkbn) {
        zrnseihowebplsbuktnrkkbn = pZrnseihowebplsbuktnrkkbn;
    }

    private String zrnseihowebplsbukttdkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLSBUKTTDKKBN)
    public String getZrnseihowebplsbukttdkkbn() {
        return zrnseihowebplsbukttdkkbn;
    }

    public void setZrnseihowebplsbukttdkkbn(String pZrnseihowebplsbukttdkkbn) {
        zrnseihowebplsbukttdkkbn = pZrnseihowebplsbukttdkkbn;
    }

    private String zrnseihowebplsbuktknnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLSBUKTKNNM)
    public String getZrnseihowebplsbuktknnm() {
        return zrnseihowebplsbuktknnm;
    }

    public void setZrnseihowebplsbuktknnm(String pZrnseihowebplsbuktknnm) {
        zrnseihowebplsbuktknnm = pZrnseihowebplsbuktknnm;
    }

    private String zrnseihowebplsbuktkjnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLSBUKTKJNM)
    public String getZrnseihowebplsbuktkjnm() {
        return zrnseihowebplsbuktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebplsbuktkjnm(String pZrnseihowebplsbuktkjnm) {
        zrnseihowebplsbuktkjnm = pZrnseihowebplsbuktkjnm;
    }

    private Integer zrnseihowebplsbuktseiymd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLSBUKTSEIYMD)
    public Integer getZrnseihowebplsbuktseiymd() {
        return zrnseihowebplsbuktseiymd;
    }

    public void setZrnseihowebplsbuktseiymd(Integer pZrnseihowebplsbuktseiymd) {
        zrnseihowebplsbuktseiymd = pZrnseihowebplsbuktseiymd;
    }

    private String zrnseihowebplhhkntelno;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLHHKNTELNO)
    public String getZrnseihowebplhhkntelno() {
        return zrnseihowebplhhkntelno;
    }

    public void setZrnseihowebplhhkntelno(String pZrnseihowebplhhkntelno) {
        zrnseihowebplhhkntelno = pZrnseihowebplhhkntelno;
    }

    private String zrnseihowebplkyktelno;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLKYKTELNO)
    public String getZrnseihowebplkyktelno() {
        return zrnseihowebplkyktelno;
    }

    public void setZrnseihowebplkyktelno(String pZrnseihowebplkyktelno) {
        zrnseihowebplkyktelno = pZrnseihowebplkyktelno;
    }

    private String zrnseihowebplkihontikucd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLKIHONTIKUCD)
    public String getZrnseihowebplkihontikucd() {
        return zrnseihowebplkihontikucd;
    }

    public void setZrnseihowebplkihontikucd(String pZrnseihowebplkihontikucd) {
        zrnseihowebplkihontikucd = pZrnseihowebplkihontikucd;
    }

    private String zrnseihowebpltsinadrkai;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLTSINADRKAI)
    public String getZrnseihowebpltsinadrkai() {
        return zrnseihowebpltsinadrkai;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebpltsinadrkai(String pZrnseihowebpltsinadrkai) {
        zrnseihowebpltsinadrkai = pZrnseihowebpltsinadrkai;
    }

    private String zrnseihowebplhiikihontikucd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLHIIKIHONTIKUCD)
    public String getZrnseihowebplhiikihontikucd() {
        return zrnseihowebplhiikihontikucd;
    }

    public void setZrnseihowebplhiikihontikucd(String pZrnseihowebplhiikihontikucd) {
        zrnseihowebplhiikihontikucd = pZrnseihowebplhiikihontikucd;
    }

    private String zrnseihowebplhhknadr;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBPLHHKNADR)
    public String getZrnseihowebplhhknadr() {
        return zrnseihowebplhhknadr;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebplhhknadr(String pZrnseihowebplhhknadr) {
        zrnseihowebplhhknadr = pZrnseihowebplhhknadr;
    }

    private String zrnseihowebhnyppltzmhyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHNYPPLTZMHYJ)
    public String getZrnseihowebhnyppltzmhyj() {
        return zrnseihowebhnyppltzmhyj;
    }

    public void setZrnseihowebhnyppltzmhyj(String pZrnseihowebhnyppltzmhyj) {
        zrnseihowebhnyppltzmhyj = pZrnseihowebhnyppltzmhyj;
    }

    private Integer zrnseihowebssrndhbnwr;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSSRNDHBNWR)
    public Integer getZrnseihowebssrndhbnwr() {
        return zrnseihowebssrndhbnwr;
    }

    public void setZrnseihowebssrndhbnwr(Integer pZrnseihowebssrndhbnwr) {
        zrnseihowebssrndhbnwr = pZrnseihowebssrndhbnwr;
    }

    private Integer zrnseihowebtrtrndhbnwr;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBTRTRNDHBNWR)
    public Integer getZrnseihowebtrtrndhbnwr() {
        return zrnseihowebtrtrndhbnwr;
    }

    public void setZrnseihowebtrtrndhbnwr(Integer pZrnseihowebtrtrndhbnwr) {
        zrnseihowebtrtrndhbnwr = pZrnseihowebtrtrndhbnwr;
    }

    private Integer zrnseihowebsueokikkn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBSUEOKIKKN)
    public Integer getZrnseihowebsueokikkn() {
        return zrnseihowebsueokikkn;
    }

    public void setZrnseihowebsueokikkn(Integer pZrnseihowebsueokikkn) {
        zrnseihowebsueokikkn = pZrnseihowebsueokikkn;
    }

    private String zrnseihowebmnkuktnrkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBMNKUKTNRKKBN)
    public String getZrnseihowebmnkuktnrkkbn() {
        return zrnseihowebmnkuktnrkkbn;
    }

    public void setZrnseihowebmnkuktnrkkbn(String pZrnseihowebmnkuktnrkkbn) {
        zrnseihowebmnkuktnrkkbn = pZrnseihowebmnkuktnrkkbn;
    }

    private String zrnseihowebmnkukttdkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBMNKUKTTDKKBN)
    public String getZrnseihowebmnkukttdkkbn() {
        return zrnseihowebmnkukttdkkbn;
    }

    public void setZrnseihowebmnkukttdkkbn(String pZrnseihowebmnkukttdkkbn) {
        zrnseihowebmnkukttdkkbn = pZrnseihowebmnkukttdkkbn;
    }

    private String zrnseihowebmnkuktknnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBMNKUKTKNNM)
    public String getZrnseihowebmnkuktknnm() {
        return zrnseihowebmnkuktknnm;
    }

    public void setZrnseihowebmnkuktknnm(String pZrnseihowebmnkuktknnm) {
        zrnseihowebmnkuktknnm = pZrnseihowebmnkuktknnm;
    }

    private String zrnseihowebmnkuktkjnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBMNKUKTKJNM)
    public String getZrnseihowebmnkuktkjnm() {
        return zrnseihowebmnkuktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebmnkuktkjnm(String pZrnseihowebmnkuktkjnm) {
        zrnseihowebmnkuktkjnm = pZrnseihowebmnkuktkjnm;
    }

    private Integer zrnseihowebmnkuktseiymd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBMNKUKTSEIYMD)
    public Integer getZrnseihowebmnkuktseiymd() {
        return zrnseihowebmnkuktseiymd;
    }

    public void setZrnseihowebmnkuktseiymd(Integer pZrnseihowebmnkuktseiymd) {
        zrnseihowebmnkuktseiymd = pZrnseihowebmnkuktseiymd;
    }

    private String zrnseihowebankenkanrino;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBANKENKANRINO)
    public String getZrnseihowebankenkanrino() {
        return zrnseihowebankenkanrino;
    }

    public void setZrnseihowebankenkanrino(String pZrnseihowebankenkanrino) {
        zrnseihowebankenkanrino = pZrnseihowebankenkanrino;
    }

    private Long zrnseihowebikkatup;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBIKKATUP)
    public Long getZrnseihowebikkatup() {
        return zrnseihowebikkatup;
    }

    public void setZrnseihowebikkatup(Long pZrnseihowebikkatup) {
        zrnseihowebikkatup = pZrnseihowebikkatup;
    }

    private String zrnseihowebikkatubaraikbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBIKKATUBARAIKBN)
    public String getZrnseihowebikkatubaraikbn() {
        return zrnseihowebikkatubaraikbn;
    }

    public void setZrnseihowebikkatubaraikbn(String pZrnseihowebikkatubaraikbn) {
        zrnseihowebikkatubaraikbn = pZrnseihowebikkatubaraikbn;
    }

    private Integer zrnseihowebiktbrikaisuu;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBIKTBRIKAISUU)
    public Integer getZrnseihowebiktbrikaisuu() {
        return zrnseihowebiktbrikaisuu;
    }

    public void setZrnseihowebiktbrikaisuu(Integer pZrnseihowebiktbrikaisuu) {
        zrnseihowebiktbrikaisuu = pZrnseihowebiktbrikaisuu;
    }

    private Long zrnseihowebzennoup;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBZENNOUP)
    public Long getZrnseihowebzennoup() {
        return zrnseihowebzennoup;
    }

    public void setZrnseihowebzennoup(Long pZrnseihowebzennoup) {
        zrnseihowebzennoup = pZrnseihowebzennoup;
    }

    private Long zrnseihowebgaikazennoup;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBGAIKAZENNOUP)
    public Long getZrnseihowebgaikazennoup() {
        return zrnseihowebgaikazennoup;
    }

    public void setZrnseihowebgaikazennoup(Long pZrnseihowebgaikazennoup) {
        zrnseihowebgaikazennoup = pZrnseihowebgaikazennoup;
    }

    private Integer zrnseihowebzennoukkn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBZENNOUKKN)
    public Integer getZrnseihowebzennoukkn() {
        return zrnseihowebzennoukkn;
    }

    public void setZrnseihowebzennoukkn(Integer pZrnseihowebzennoukkn) {
        zrnseihowebzennoukkn = pZrnseihowebzennoukkn;
    }

    private String zrnseihowebzennouhyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBZENNOUHYJ)
    public String getZrnseihowebzennouhyj() {
        return zrnseihowebzennouhyj;
    }

    public void setZrnseihowebzennouhyj(String pZrnseihowebzennouhyj) {
        zrnseihowebzennouhyj = pZrnseihowebzennouhyj;
    }

    private String zrnseihowebkydbosyuukjncd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYDBOSYUUKJNCD)
    public String getZrnseihowebkydbosyuukjncd() {
        return zrnseihowebkydbosyuukjncd;
    }

    public void setZrnseihowebkydbosyuukjncd(String pZrnseihowebkydbosyuukjncd) {
        zrnseihowebkydbosyuukjncd = pZrnseihowebkydbosyuukjncd;
    }

    private String zrnseihowebkzktrkmoskbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKZKTRKMOSKBN)
    public String getZrnseihowebkzktrkmoskbn() {
        return zrnseihowebkzktrkmoskbn;
    }

    public void setZrnseihowebkzktrkmoskbn(String pZrnseihowebkzktrkmoskbn) {
        zrnseihowebkzktrkmoskbn = pZrnseihowebkzktrkmoskbn;
    }

    private String zrnseihowebkzktdkkbn1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKZKTDKKBN1)
    public String getZrnseihowebkzktdkkbn1() {
        return zrnseihowebkzktdkkbn1;
    }

    public void setZrnseihowebkzktdkkbn1(String pZrnseihowebkzktdkkbn1) {
        zrnseihowebkzktdkkbn1 = pZrnseihowebkzktdkkbn1;
    }

    private String zrnseihowebkzkknnm1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKZKKNNM1)
    public String getZrnseihowebkzkknnm1() {
        return zrnseihowebkzkknnm1;
    }

    public void setZrnseihowebkzkknnm1(String pZrnseihowebkzkknnm1) {
        zrnseihowebkzkknnm1 = pZrnseihowebkzkknnm1;
    }

    private String zrnseihowebkzkkjnm1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKZKKJNM1)
    public String getZrnseihowebkzkkjnm1() {
        return zrnseihowebkzkkjnm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebkzkkjnm1(String pZrnseihowebkzkkjnm1) {
        zrnseihowebkzkkjnm1 = pZrnseihowebkzkkjnm1;
    }

    private String zrnseihowebkzkseikbn1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKZKSEIKBN1)
    public String getZrnseihowebkzkseikbn1() {
        return zrnseihowebkzkseikbn1;
    }

    public void setZrnseihowebkzkseikbn1(String pZrnseihowebkzkseikbn1) {
        zrnseihowebkzkseikbn1 = pZrnseihowebkzkseikbn1;
    }

    private Integer zrnseihowebkzkseiymd1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKZKSEIYMD1)
    public Integer getZrnseihowebkzkseiymd1() {
        return zrnseihowebkzkseiymd1;
    }

    public void setZrnseihowebkzkseiymd1(Integer pZrnseihowebkzkseiymd1) {
        zrnseihowebkzkseiymd1 = pZrnseihowebkzkseiymd1;
    }

    private String zrnseihowebkzkkykdoukyohyj1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKZKKYKDOUKYOHYJ1)
    public String getZrnseihowebkzkkykdoukyohyj1() {
        return zrnseihowebkzkkykdoukyohyj1;
    }

    public void setZrnseihowebkzkkykdoukyohyj1(String pZrnseihowebkzkkykdoukyohyj1) {
        zrnseihowebkzkkykdoukyohyj1 = pZrnseihowebkzkkykdoukyohyj1;
    }

    private String zrnseihowebkzkyno1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKZKYNO1)
    public String getZrnseihowebkzkyno1() {
        return zrnseihowebkzkyno1;
    }

    public void setZrnseihowebkzkyno1(String pZrnseihowebkzkyno1) {
        zrnseihowebkzkyno1 = pZrnseihowebkzkyno1;
    }

    private String zrnseihowebkzkadr1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKZKADR1)
    public String getZrnseihowebkzkadr1() {
        return zrnseihowebkzkadr1;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebkzkadr1(String pZrnseihowebkzkadr1) {
        zrnseihowebkzkadr1 = pZrnseihowebkzkadr1;
    }

    private String zrnseihowebkzktelno1;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKZKTELNO1)
    public String getZrnseihowebkzktelno1() {
        return zrnseihowebkzktelno1;
    }

    public void setZrnseihowebkzktelno1(String pZrnseihowebkzktelno1) {
        zrnseihowebkzktelno1 = pZrnseihowebkzktelno1;
    }

    private String zrnseihowebkykdrtkkanouhyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKDRTKKANOUHYJ)
    public String getZrnseihowebkykdrtkkanouhyj() {
        return zrnseihowebkykdrtkkanouhyj;
    }

    public void setZrnseihowebkykdrtkkanouhyj(String pZrnseihowebkykdrtkkanouhyj) {
        zrnseihowebkykdrtkkanouhyj = pZrnseihowebkykdrtkkanouhyj;
    }

    private String zrnseihowebhhkndrtkkanouhyj;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNDRTKKANOUHYJ)
    public String getZrnseihowebhhkndrtkkanouhyj() {
        return zrnseihowebhhkndrtkkanouhyj;
    }

    public void setZrnseihowebhhkndrtkkanouhyj(String pZrnseihowebhhkndrtkkanouhyj) {
        zrnseihowebhhkndrtkkanouhyj = pZrnseihowebhhkndrtkkanouhyj;
    }

    private String zrnseihowebdrtkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBDRTKKBN)
    public String getZrnseihowebdrtkkbn() {
        return zrnseihowebdrtkkbn;
    }

    public void setZrnseihowebdrtkkbn(String pZrnseihowebdrtkkbn) {
        zrnseihowebdrtkkbn = pZrnseihowebdrtkkbn;
    }

    private String zrnseihowebkykdrnrkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBKYKDRNRKKBN)
    public String getZrnseihowebkykdrnrkkbn() {
        return zrnseihowebkykdrnrkkbn;
    }

    public void setZrnseihowebkykdrnrkkbn(String pZrnseihowebkykdrnrkkbn) {
        zrnseihowebkykdrnrkkbn = pZrnseihowebkykdrnrkkbn;
    }

    private String zrnseihowebhhkndrnrkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNDRNRKKBN)
    public String getZrnseihowebhhkndrnrkkbn() {
        return zrnseihowebhhkndrnrkkbn;
    }

    public void setZrnseihowebhhkndrnrkkbn(String pZrnseihowebhhkndrnrkkbn) {
        zrnseihowebhhkndrnrkkbn = pZrnseihowebhhkndrnrkkbn;
    }

    private String zrnseihowebhhkndrtdkkbn;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNDRTDKKBN)
    public String getZrnseihowebhhkndrtdkkbn() {
        return zrnseihowebhhkndrtdkkbn;
    }

    public void setZrnseihowebhhkndrtdkkbn(String pZrnseihowebhhkndrtdkkbn) {
        zrnseihowebhhkndrtdkkbn = pZrnseihowebhhkndrtdkkbn;
    }

    private String zrnseihowebhhkndrknnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNDRKNNM)
    public String getZrnseihowebhhkndrknnm() {
        return zrnseihowebhhkndrknnm;
    }

    public void setZrnseihowebhhkndrknnm(String pZrnseihowebhhkndrknnm) {
        zrnseihowebhhkndrknnm = pZrnseihowebhhkndrknnm;
    }

    private String zrnseihowebhhkndrkjnm;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNDRKJNM)
    public String getZrnseihowebhhkndrkjnm() {
        return zrnseihowebhhkndrkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnseihowebhhkndrkjnm(String pZrnseihowebhhkndrkjnm) {
        zrnseihowebhhkndrkjnm = pZrnseihowebhhkndrkjnm;
    }

    private Integer zrnseihowebhhkndrseiymd;

    @Column(name=GenZT_TiginSinkinBosRn.ZRNSEIHOWEBHHKNDRSEIYMD)
    public Integer getZrnseihowebhhkndrseiymd() {
        return zrnseihowebhhkndrseiymd;
    }

    public void setZrnseihowebhhkndrseiymd(Integer pZrnseihowebhhkndrseiymd) {
        zrnseihowebhhkndrseiymd = pZrnseihowebhhkndrseiymd;
    }
}