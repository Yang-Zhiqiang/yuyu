package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TiginSinkinBosRn;
import yuyu.def.db.mapping.GenZT_TiginSinkinBosRn;
import yuyu.def.db.meta.GenQZT_TiginSinkinBosRn;
import yuyu.def.db.meta.QZT_TiginSinkinBosRn;

/**
 * 地銀信金募集テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TiginSinkinBosRn}</td><td colspan="3">地銀信金募集テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnseihowebidkbn zrnseihowebidkbn}</td><td>（連携用）生保ＷｅｂＩＤ区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnseihowebkojincd zrnseihowebkojincd}</td><td>（連携用）生保Ｗｅｂ個人コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnseihowebitijihozonhyouji zrnseihowebitijihozonhyouji}</td><td>（連携用）生保Ｗｅｂ一時保存表示</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnseihowebsekno zrnseihowebsekno}</td><td>（連携用）生保Ｗｅｂ設計書番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebcalckijyunymd</td><td>（連携用）生保Ｗｅｂ計算基準年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebhhknknnm</td><td>（連携用）生保Ｗｅｂ被保険者カナ氏名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhknkjnm</td><td>（連携用）生保Ｗｅｂ被保険者漢字氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhknseiymd</td><td>（連携用）生保Ｗｅｂ被保険者生年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebhhknseikbn</td><td>（連携用）生保Ｗｅｂ被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebmrhkihontikucd</td><td>（連携用）生保Ｗｅｂマル被基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhknadr</td><td>（連携用）生保Ｗｅｂ被保険者住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkykknnm</td><td>（連携用）生保Ｗｅｂ契約者カナ氏名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkykkjnm</td><td>（連携用）生保Ｗｅｂ契約者漢字氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkyksyaseiymd</td><td>（連携用）生保Ｗｅｂ契約者生年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebkyksyaseikbn</td><td>（連携用）生保Ｗｅｂ契約者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkykkihontikucd</td><td>（連携用）生保Ｗｅｂ契約者基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkykadr</td><td>（連携用）生保Ｗｅｂ契約者住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhknsyuruino</td><td>（連携用）生保Ｗｅｂ保険種類番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebhjkktkbn</td><td>（連携用）生保Ｗｅｂ報状告知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhknkkn</td><td>（連携用）生保Ｗｅｂ保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebphrkkikn</td><td>（連携用）生保ＷｅｂＰ払込期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebhrkkaisuukbn</td><td>（連携用）生保Ｗｅｂ払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhrkkeirokbn</td><td>（連携用）生保Ｗｅｂ払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebsdpdkbn</td><td>（連携用）生保ＷｅｂＳ建Ｐ建区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkihons</td><td>（連携用）生保Ｗｅｂ基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebnksyuruikbn</td><td>（連携用）生保Ｗｅｂ年金種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihoweblntkkbn</td><td>（連携用）生保ＷｅｂＬＮ特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebnkshrarihyj</td><td>（連携用）生保Ｗｅｂ年金支払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebmosno</td><td>（連携用）生保Ｗｅｂ申込番号</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebsekykkigenymd</td><td>（連携用）生保Ｗｅｂ設計書有効期限年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebsksjsitencd</td><td>（連携用）生保Ｗｅｂ作成時支店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebsbuktnrkkbn</td><td>（連携用）生保Ｗｅｂ死亡受取人入力区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebsbukttdkkbn</td><td>（連携用）生保Ｗｅｂ死亡受取人続柄区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebsbuktknnm</td><td>（連携用）生保Ｗｅｂ死亡受取人カナ氏名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebsbuktkjnm</td><td>（連携用）生保Ｗｅｂ死亡受取人漢字氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebsbuktseiymd</td><td>（連携用）生保Ｗｅｂ死亡受取人生年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebmosprtzmhyj</td><td>（連携用）生保Ｗｅｂ申込書印刷済表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebfstmossksymd</td><td>（連携用）生保Ｗｅｂ初回申込書作成年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebhnsyukyktdkkbn</td><td>（連携用）生保Ｗｅｂ編集後契約者続柄区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebbsyutrkno</td><td>（連携用）生保Ｗｅｂ募集人登録番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhjnkitikbn</td><td>（連携用）生保Ｗｅｂ法人形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhjnkykhyj</td><td>（連携用）生保Ｗｅｂ法人契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebtksykmcd1</td><td>（連携用）生保Ｗｅｂ特殊項目コード１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebtksykmcd2</td><td>（連携用）生保Ｗｅｂ特殊項目コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebtksykmcd3</td><td>（連携用）生保Ｗｅｂ特殊項目コード３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebtksykmcd4</td><td>（連携用）生保Ｗｅｂ特殊項目コード４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebtksykmcd5</td><td>（連携用）生保Ｗｅｂ特殊項目コード５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebteiwkkn</td><td>（連携用）生保Ｗｅｂ低Ｗ期間</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebhhkntelno</td><td>（連携用）生保Ｗｅｂ被保険者電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkyktelno</td><td>（連携用）生保Ｗｅｂ契約者電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebknhjnnm</td><td>（連携用）生保Ｗｅｂカナ法人名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkjhjnnm</td><td>（連携用）生保Ｗｅｂ漢字法人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkndaihyounm</td><td>（連携用）生保Ｗｅｂカナ代表者名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkjdaihyounm</td><td>（連携用）生保Ｗｅｂ漢字代表者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebdaihyouktgkkbn</td><td>（連携用）生保Ｗｅｂ代表者肩書区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebsykihrkp1</td><td>（連携用）生保Ｗｅｂ初回払込Ｐ１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebmosp1</td><td>（連携用）生保Ｗｅｂ申込Ｐ１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebtkiyougyoutaikbn</td><td>（連携用）生保Ｗｅｂ統計用業態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebpaperlessmoshyj</td><td>（連携用）生保Ｗｅｂペーパーレス申込表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebdatasousinzmhyj</td><td>（連携用）生保Ｗｅｂデータ送信済表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebdrtnskno</td><td>（連携用）生保Ｗｅｂ代理店設計書番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebsbnksyukbn</td><td>（連携用）生保Ｗｅｂ死亡年金種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebaatkisyaknyuucd</td><td>（連携用）生保ＷｅｂＡ扱者金融機関コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkeihidouituhyj</td><td>（連携用）生保Ｗｅｂ契被同一表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebsiteituukakbn</td><td>（連携用）生保Ｗｅｂ指定通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebnykntuukakbn</td><td>（連携用）生保Ｗｅｂ入金通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebtargettkarihyj</td><td>（連携用）生保Ｗｅｂターゲット特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebtargettkkbn</td><td>（連携用）生保Ｗｅｂターゲット特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebtargettkmkht</td><td>（連携用）生保Ｗｅｂターゲット特約目標値</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebnykntuukanykngk</td><td>（連携用）生保Ｗｅｂ入金通貨入金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebnykntukfsthrkp</td><td>（連携用）生保Ｗｅｂ入金通貨初回払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebnykntuknexthrkp</td><td>（連携用）生保Ｗｅｂ入金通貨次回払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebsaimankihyj</td><td>（連携用）生保Ｗｅｂ才満期表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebrayhyj</td><td>（連携用）生保ＷｅｂＲＡＹ表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebgnykntuknykngk</td><td>（連携用）生保Ｗｅｂ外貨入金通貨入金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebgnykntukfsthrkp</td><td>（連携用）生保Ｗｅｂ外貨入金通貨初回Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebgnykntuknxthrkp</td><td>（連携用）生保Ｗｅｂ外貨入金通貨次回Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebgaikakihonp</td><td>（連携用）生保Ｗｅｂ外貨基本Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebkaigmehrtkarihyj</td><td>（連携用）生保Ｗｅｂ介護前払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebyenhsyutkarihyj</td><td>（連携用）生保Ｗｅｂ円最低保証特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebgaikakihons</td><td>（連携用）生保Ｗｅｂ外貨基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebdai1hknkkn</td><td>（連携用）生保Ｗｅｂ第１保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebkyksykgycd</td><td>（連携用）生保Ｗｅｂ契約者職業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkknmskhjnkitikbn</td><td>（連携用）生保Ｗｅｂ契勤務先法人形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkykottmsk</td><td>（連携用）生保Ｗｅｂ契約者お勤め先</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhknsykgycd</td><td>（連携用）生保Ｗｅｂ被保険者職業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhknmskhjnkitikbn</td><td>（連携用）生保Ｗｅｂ被勤務先法人形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhknottmsk</td><td>（連携用）生保Ｗｅｂ被保険者お勤め先</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhknnensyuukbn</td><td>（連携用）生保Ｗｅｂ被保険者年収区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplhhknkjnm</td><td>（連携用）生保ＷｅｂＰＬ被保険者漢字氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplkykkjnm</td><td>（連携用）生保ＷｅｂＰＬ契約者漢字氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplhrkkeirokbn</td><td>（連携用）生保ＷｅｂＰＬ払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplsbuktnrkkbn</td><td>（連携用）生保ＷｅｂＰＬ死亡受入力区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplsbukttdkkbn</td><td>（連携用）生保ＷｅｂＰＬ死亡受続柄区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplsbuktknnm</td><td>（連携用）生保ＷｅｂＰＬ死亡受カナ氏名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplsbuktkjnm</td><td>（連携用）生保ＷｅｂＰＬ死亡受漢字氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplsbuktseiymd</td><td>（連携用）生保ＷｅｂＰＬ死亡受生年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebplhhkntelno</td><td>（連携用）生保ＷｅｂＰＬ被保険者電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplkyktelno</td><td>（連携用）生保ＷｅｂＰＬ契約者電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplkihontikucd</td><td>（連携用）生保ＷｅｂＰＬ基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebpltsinadrkai</td><td>（連携用）生保ＷｅｂＰＬ通信先住所下位</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplhiikihontikucd</td><td>（連携用）生保ＷｅｂＰＬ被基本地区コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebplhhknadr</td><td>（連携用）生保ＷｅｂＰＬ被保険者住所</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhnyppltzmhyj</td><td>（連携用）生保Ｗｅｂ汎用ＰＰＬ対応済表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebssrndhbnwr</td><td>（連携用）生保Ｗｅｂ指数連動部分配分割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebtrtrndhbnwr</td><td>（連携用）生保Ｗｅｂ定率積立部分配分割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebsueokikkn</td><td>（連携用）生保Ｗｅｂ据置期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebmnkuktnrkkbn</td><td>（連携用）生保Ｗｅｂ満期受取人入力区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebmnkukttdkkbn</td><td>（連携用）生保Ｗｅｂ満期受取人続柄区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebmnkuktknnm</td><td>（連携用）生保Ｗｅｂ満期受取人カナ氏名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebmnkuktkjnm</td><td>（連携用）生保Ｗｅｂ満期受取人漢字氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebmnkuktseiymd</td><td>（連携用）生保Ｗｅｂ満期受取人生年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebankenkanrino</td><td>（連携用）生保Ｗｅｂ案件管理番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebikkatup</td><td>（連携用）生保Ｗｅｂ一括払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebikkatubaraikbn</td><td>（連携用）生保Ｗｅｂ一括払区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebiktbrikaisuu</td><td>（連携用）生保Ｗｅｂ一括払回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebzennoup</td><td>（連携用）生保Ｗｅｂ前納Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebgaikazennoup</td><td>（連携用）生保Ｗｅｂ外貨前納Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnseihowebzennoukkn</td><td>（連携用）生保Ｗｅｂ前納期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebzennouhyj</td><td>（連携用）生保Ｗｅｂ前納表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkydbosyuukjncd</td><td>（連携用）生保Ｗｅｂ共同募集個人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkzktrkmoskbn</td><td>（連携用）生保Ｗｅｂご家族登録申込区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkzktdkkbn1</td><td>（連携用）生保Ｗｅｂご家族続柄区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkzkknnm1</td><td>（連携用）生保Ｗｅｂご家族カナ氏名１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkzkkjnm1</td><td>（連携用）生保Ｗｅｂご家族漢字氏名１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkzkseikbn1</td><td>（連携用）生保Ｗｅｂご家族性別区分１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkzkseiymd1</td><td>（連携用）生保Ｗｅｂご家族生年月日１</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnseihowebkzkkykdoukyohyj1</td><td>（連携用）生保Ｗｅｂご家族契同居表示１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkzkyno1</td><td>（連携用）生保Ｗｅｂご家族郵便番号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkzkadr1</td><td>（連携用）生保Ｗｅｂご家族住所１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkzktelno1</td><td>（連携用）生保Ｗｅｂご家族電話番号１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkykdrtkkanouhyj</td><td>（連携用）生保Ｗｅｂ契代理特約可能表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhkndrtkkanouhyj</td><td>（連携用）生保Ｗｅｂ被代理特約可能表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebdrtkkbn</td><td>（連携用）生保Ｗｅｂ代理特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebkykdrnrkkbn</td><td>（連携用）生保Ｗｅｂ契代理入力区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhkndrnrkkbn</td><td>（連携用）生保Ｗｅｂ被代理入力区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhkndrtdkkbn</td><td>（連携用）生保Ｗｅｂ被代理続柄区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhkndrknnm</td><td>（連携用）生保Ｗｅｂ被代理カナ氏名</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhkndrkjnm</td><td>（連携用）生保Ｗｅｂ被代理漢字氏名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnseihowebhhkndrseiymd</td><td>（連携用）生保Ｗｅｂ被代理生年月日</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     ZT_TiginSinkinBosRn
 * @see     GenZT_TiginSinkinBosRn
 * @see     QZT_TiginSinkinBosRn
 * @see     GenQZT_TiginSinkinBosRn
 */
public class PKZT_TiginSinkinBosRn extends AbstractExDBPrimaryKey<ZT_TiginSinkinBosRn, PKZT_TiginSinkinBosRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_TiginSinkinBosRn() {
    }

    public PKZT_TiginSinkinBosRn(
        String pZrnseihowebidkbn,
        String pZrnseihowebkojincd,
        String pZrnseihowebitijihozonhyouji,
        Integer pZrnseihowebsekno
    ) {
        zrnseihowebidkbn = pZrnseihowebidkbn;
        zrnseihowebkojincd = pZrnseihowebkojincd;
        zrnseihowebitijihozonhyouji = pZrnseihowebitijihozonhyouji;
        zrnseihowebsekno = pZrnseihowebsekno;
    }

    @Transient
    @Override
    public Class<ZT_TiginSinkinBosRn> getEntityClass() {
        return ZT_TiginSinkinBosRn.class;
    }

    private String zrnseihowebidkbn;

    public String getZrnseihowebidkbn() {
        return zrnseihowebidkbn;
    }

    public void setZrnseihowebidkbn(String pZrnseihowebidkbn) {
        zrnseihowebidkbn = pZrnseihowebidkbn;
    }
    private String zrnseihowebkojincd;

    public String getZrnseihowebkojincd() {
        return zrnseihowebkojincd;
    }

    public void setZrnseihowebkojincd(String pZrnseihowebkojincd) {
        zrnseihowebkojincd = pZrnseihowebkojincd;
    }
    private String zrnseihowebitijihozonhyouji;

    public String getZrnseihowebitijihozonhyouji() {
        return zrnseihowebitijihozonhyouji;
    }

    public void setZrnseihowebitijihozonhyouji(String pZrnseihowebitijihozonhyouji) {
        zrnseihowebitijihozonhyouji = pZrnseihowebitijihozonhyouji;
    }
    private Integer zrnseihowebsekno;

    public Integer getZrnseihowebsekno() {
        return zrnseihowebsekno;
    }

    public void setZrnseihowebsekno(Integer pZrnseihowebsekno) {
        zrnseihowebsekno = pZrnseihowebsekno;
    }

}