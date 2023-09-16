package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TiginSinkinBosTr;
import yuyu.def.db.mapping.GenZT_TiginSinkinBosTr;
import yuyu.def.db.meta.GenQZT_TiginSinkinBosTr;
import yuyu.def.db.meta.QZT_TiginSinkinBosTr;

/**
 * 地銀信金募集テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TiginSinkinBosTr}</td><td colspan="3">地銀信金募集テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrseihowebidkbn ztrseihowebidkbn}</td><td>（取込用）生保ＷｅｂＩＤ区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrseihowebkojincd ztrseihowebkojincd}</td><td>（取込用）生保Ｗｅｂ個人コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrseihowebitijihozonhyouji ztrseihowebitijihozonhyouji}</td><td>（取込用）生保Ｗｅｂ一時保存表示</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrseihowebsekno ztrseihowebsekno}</td><td>（取込用）生保Ｗｅｂ設計書番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebcalckijyunymd</td><td>（取込用）生保Ｗｅｂ計算基準年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknknnm</td><td>（取込用）生保Ｗｅｂ被保険者カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknkjnm</td><td>（取込用）生保Ｗｅｂ被保険者漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknseiymd</td><td>（取込用）生保Ｗｅｂ被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknseikbn</td><td>（取込用）生保Ｗｅｂ被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmrhkihontikucd</td><td>（取込用）生保Ｗｅｂマル被基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknadr</td><td>（取込用）生保Ｗｅｂ被保険者住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkykknnm</td><td>（取込用）生保Ｗｅｂ契約者カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkykkjnm</td><td>（取込用）生保Ｗｅｂ契約者漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkyksyaseiymd</td><td>（取込用）生保Ｗｅｂ契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkyksyaseikbn</td><td>（取込用）生保Ｗｅｂ契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkykkihontikucd</td><td>（取込用）生保Ｗｅｂ契約者基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkykadr</td><td>（取込用）生保Ｗｅｂ契約者住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhknsyuruino</td><td>（取込用）生保Ｗｅｂ保険種類番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhjkktkbn</td><td>（取込用）生保Ｗｅｂ報状告知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhknkkn</td><td>（取込用）生保Ｗｅｂ保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebphrkkikn</td><td>（取込用）生保ＷｅｂＰ払込期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebhrkkaisuukbn</td><td>（取込用）生保Ｗｅｂ払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhrkkeirokbn</td><td>（取込用）生保Ｗｅｂ払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsdpdkbn</td><td>（取込用）生保ＷｅｂＳ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkihons</td><td>（取込用）生保Ｗｅｂ基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebnksyuruikbn</td><td>（取込用）生保Ｗｅｂ年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihoweblntkkbn</td><td>（取込用）生保ＷｅｂＬＮ特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebnkshrarihyj</td><td>（取込用）生保Ｗｅｂ年金支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmosno</td><td>（取込用）生保Ｗｅｂ申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsekykkigenymd</td><td>（取込用）生保Ｗｅｂ設計書有効期限年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsksjsitencd</td><td>（取込用）生保Ｗｅｂ作成時支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktnrkkbn</td><td>（取込用）生保Ｗｅｂ死亡受取人入力区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbukttdkkbn</td><td>（取込用）生保Ｗｅｂ死亡受取人続柄区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktknnm</td><td>（取込用）生保Ｗｅｂ死亡受取人カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktkjnm</td><td>（取込用）生保Ｗｅｂ死亡受取人漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktseiymd</td><td>（取込用）生保Ｗｅｂ死亡受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmosprtzmhyj</td><td>（取込用）生保Ｗｅｂ申込書印刷済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebfstmossksymd</td><td>（取込用）生保Ｗｅｂ初回申込書作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhnsyukyktdkkbn</td><td>（取込用）生保Ｗｅｂ編集後契約者続柄区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebbsyutrkno</td><td>（取込用）生保Ｗｅｂ募集人登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhjnkitikbn</td><td>（取込用）生保Ｗｅｂ法人形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhjnkykhyj</td><td>（取込用）生保Ｗｅｂ法人契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtksykmcd1</td><td>（取込用）生保Ｗｅｂ特殊項目コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtksykmcd2</td><td>（取込用）生保Ｗｅｂ特殊項目コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtksykmcd3</td><td>（取込用）生保Ｗｅｂ特殊項目コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtksykmcd4</td><td>（取込用）生保Ｗｅｂ特殊項目コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtksykmcd5</td><td>（取込用）生保Ｗｅｂ特殊項目コード５　</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebteiwkkn</td><td>（取込用）生保Ｗｅｂ低Ｗ期間</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebhhkntelno</td><td>（取込用）生保Ｗｅｂ被保険者電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkyktelno</td><td>（取込用）生保Ｗｅｂ契約者電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebknhjnnm</td><td>（取込用）生保Ｗｅｂカナ法人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkjhjnnm</td><td>（取込用）生保Ｗｅｂ漢字法人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkndaihyounm</td><td>（取込用）生保Ｗｅｂカナ代表者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkjdaihyounm</td><td>（取込用）生保Ｗｅｂ漢字代表者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdaihyouktgkkbn</td><td>（取込用）生保Ｗｅｂ代表者肩書区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsykihrkp1</td><td>（取込用）生保Ｗｅｂ初回払込Ｐ１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebmosp1</td><td>（取込用）生保Ｗｅｂ申込Ｐ１</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebtkiyougyoutaikbn</td><td>（取込用）生保Ｗｅｂ統計用業態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebpaperlessmoshyj</td><td>（取込用）生保Ｗｅｂペーパーレス申込表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdatasousinzmhyj</td><td>（取込用）生保Ｗｅｂデータ送信済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdrtnskno</td><td>（取込用）生保Ｗｅｂ代理店設計書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbnksyukbn</td><td>（取込用）生保Ｗｅｂ死亡年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebaatkisyaknyuucd</td><td>（取込用）生保ＷｅｂＡ扱者金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkeihidouituhyj</td><td>（取込用）生保Ｗｅｂ契被同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsiteituukakbn</td><td>（取込用）生保Ｗｅｂ指定通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebnykntuukakbn</td><td>（取込用）生保Ｗｅｂ入金通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtargettkarihyj</td><td>（取込用）生保Ｗｅｂターゲット特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtargettkkbn</td><td>（取込用）生保Ｗｅｂターゲット特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtargettkmkht</td><td>（取込用）生保Ｗｅｂターゲット特約目標値</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebnykntuukanykngk</td><td>（取込用）生保Ｗｅｂ入金通貨入金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebnykntukfsthrkp</td><td>（取込用）生保Ｗｅｂ入金通貨初回払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebnykntuknexthrkp</td><td>（取込用）生保Ｗｅｂ入金通貨次回払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebsaimankihyj</td><td>（取込用）生保Ｗｅｂ才満期表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebrayhyj</td><td>（取込用）生保ＷｅｂＲＡＹ表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebgnykntuknykngk</td><td>（取込用）生保Ｗｅｂ外貨入金通貨入金額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebgnykntukfsthrkp</td><td>（取込用）生保Ｗｅｂ外貨入金通貨初回Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebgnykntuknxthrkp</td><td>（取込用）生保Ｗｅｂ外貨入金通貨次回Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebgaikakihonp</td><td>（取込用）生保Ｗｅｂ外貨基本Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebkaigmehrtkarihyj</td><td>（取込用）生保Ｗｅｂ介護前払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebyenhsyutkarihyj</td><td>（取込用）生保Ｗｅｂ円最低保証特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebgaikakihons</td><td>（取込用）生保Ｗｅｂ外貨基本Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebdai1hknkkn</td><td>（取込用）生保Ｗｅｂ第１保険期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebkyksykgycd</td><td>（取込用）生保Ｗｅｂ契約者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkknmskhjnkitikbn</td><td>（取込用）生保Ｗｅｂ契勤務先法人形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkykottmsk</td><td>（取込用）生保Ｗｅｂ契約者お勤め先</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknsykgycd</td><td>（取込用）生保Ｗｅｂ被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhknmskhjnkitikbn</td><td>（取込用）生保Ｗｅｂ被勤務先法人形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknottmsk</td><td>（取込用）生保Ｗｅｂ被保険者お勤め先</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknnensyuukbn</td><td>（取込用）生保Ｗｅｂ被保険者年収区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhhknkjnm</td><td>（取込用）生保ＷｅｂＰＬ被保険者漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplkykkjnm</td><td>（取込用）生保ＷｅｂＰＬ契約者漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhrkkeirokbn</td><td>（取込用）生保ＷｅｂＰＬ払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplsbuktnrkkbn</td><td>（取込用）生保ＷｅｂＰＬ死亡受入力区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplsbukttdkkbn</td><td>（取込用）生保ＷｅｂＰＬ死亡受続柄区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplsbuktknnm</td><td>（取込用）生保ＷｅｂＰＬ死亡受カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplsbuktkjnm</td><td>（取込用）生保ＷｅｂＰＬ死亡受漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplsbuktseiymd</td><td>（取込用）生保ＷｅｂＰＬ死亡受生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhhkntelno</td><td>（取込用）生保ＷｅｂＰＬ被保険者電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplkyktelno</td><td>（取込用）生保ＷｅｂＰＬ契約者電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplkihontikucd</td><td>（取込用）生保ＷｅｂＰＬ基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebpltsinadrkai</td><td>（取込用）生保ＷｅｂＰＬ通信先住所下位</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhiikihontikucd</td><td>（取込用）生保ＷｅｂＰＬ被基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhhknadr</td><td>（取込用）生保ＷｅｂＰＬ被保険者住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhnyppltzmhyj</td><td>（取込用）生保Ｗｅｂ汎用ＰＰＬ対応済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebssrndhbnwr</td><td>（取込用）生保Ｗｅｂ指数連動部分配分割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebtrtrndhbnwr</td><td>（取込用）生保Ｗｅｂ定率積立部分配分割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebsueokikkn</td><td>（取込用）生保Ｗｅｂ据置期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebmnkuktnrkkbn</td><td>（取込用）生保Ｗｅｂ満期受取人入力区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmnkukttdkkbn</td><td>（取込用）生保Ｗｅｂ満期受取人続柄区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmnkuktknnm</td><td>（取込用）生保Ｗｅｂ満期受取人カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmnkuktkjnm</td><td>（取込用）生保Ｗｅｂ満期受取人漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmnkuktseiymd</td><td>（取込用）生保Ｗｅｂ満期受取人生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebankenkanrino</td><td>（取込用）生保Ｗｅｂ案件管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebikkatup</td><td>（取込用）生保Ｗｅｂ一括払Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebikkatubaraikbn</td><td>（取込用）生保Ｗｅｂ一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebiktbrikaisuu</td><td>（取込用）生保Ｗｅｂ一括払回数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebzennoup</td><td>（取込用）生保Ｗｅｂ前納Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebgaikazennoup</td><td>（取込用）生保Ｗｅｂ外貨前納Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebzennoukkn</td><td>（取込用）生保Ｗｅｂ前納期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebzennouhyj</td><td>（取込用）生保Ｗｅｂ前納表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkydbosyuukjncd</td><td>（取込用）生保Ｗｅｂ共同募集個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzktrkmoskbn</td><td>（取込用）生保Ｗｅｂご家族登録申込区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzktdkkbn1</td><td>（取込用）生保Ｗｅｂご家族続柄区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkknnm1</td><td>（取込用）生保Ｗｅｂご家族カナ氏名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkkjnm1</td><td>（取込用）生保Ｗｅｂご家族漢字氏名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkseikbn1</td><td>（取込用）生保Ｗｅｂご家族性別区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkseiymd1</td><td>（取込用）生保Ｗｅｂご家族生年月日１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkkykdoukyohyj1</td><td>（取込用）生保Ｗｅｂご家族契同居表示１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkyno1</td><td>（取込用）生保Ｗｅｂご家族郵便番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkadr1</td><td>（取込用）生保Ｗｅｂご家族住所１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzktelno1</td><td>（取込用）生保Ｗｅｂご家族電話番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkykdrtkkanouhyj</td><td>（取込用）生保Ｗｅｂ契代理特約可能表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhkndrtkkanouhyj</td><td>（取込用）生保Ｗｅｂ被代理特約可能表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdrtkkbn</td><td>（取込用）生保Ｗｅｂ代理特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkykdrnrkkbn</td><td>（取込用）生保Ｗｅｂ契代理入力区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhkndrnrkkbn</td><td>（取込用）生保Ｗｅｂ被代理入力区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhkndrtdkkbn</td><td>（取込用）生保Ｗｅｂ被代理続柄区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhkndrknnm</td><td>（取込用）生保Ｗｅｂ被代理カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhkndrkjnm</td><td>（取込用）生保Ｗｅｂ被代理漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhkndrseiymd</td><td>（取込用）生保Ｗｅｂ被代理生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TiginSinkinBosTr
 * @see     GenZT_TiginSinkinBosTr
 * @see     QZT_TiginSinkinBosTr
 * @see     GenQZT_TiginSinkinBosTr
 */
public class PKZT_TiginSinkinBosTr extends AbstractExDBPrimaryKey<ZT_TiginSinkinBosTr, PKZT_TiginSinkinBosTr> {

    private static final long serialVersionUID = 1L;

    public PKZT_TiginSinkinBosTr() {
    }

    public PKZT_TiginSinkinBosTr(
        String pZtrseihowebidkbn,
        String pZtrseihowebkojincd,
        String pZtrseihowebitijihozonhyouji,
        Integer pZtrseihowebsekno
    ) {
        ztrseihowebidkbn = pZtrseihowebidkbn;
        ztrseihowebkojincd = pZtrseihowebkojincd;
        ztrseihowebitijihozonhyouji = pZtrseihowebitijihozonhyouji;
        ztrseihowebsekno = pZtrseihowebsekno;
    }

    @Transient
    @Override
    public Class<ZT_TiginSinkinBosTr> getEntityClass() {
        return ZT_TiginSinkinBosTr.class;
    }

    private String ztrseihowebidkbn;

    public String getZtrseihowebidkbn() {
        return ztrseihowebidkbn;
    }

    public void setZtrseihowebidkbn(String pZtrseihowebidkbn) {
        ztrseihowebidkbn = pZtrseihowebidkbn;
    }
    private String ztrseihowebkojincd;

    public String getZtrseihowebkojincd() {
        return ztrseihowebkojincd;
    }

    public void setZtrseihowebkojincd(String pZtrseihowebkojincd) {
        ztrseihowebkojincd = pZtrseihowebkojincd;
    }
    private String ztrseihowebitijihozonhyouji;

    public String getZtrseihowebitijihozonhyouji() {
        return ztrseihowebitijihozonhyouji;
    }

    public void setZtrseihowebitijihozonhyouji(String pZtrseihowebitijihozonhyouji) {
        ztrseihowebitijihozonhyouji = pZtrseihowebitijihozonhyouji;
    }
    private Integer ztrseihowebsekno;

    public Integer getZtrseihowebsekno() {
        return ztrseihowebsekno;
    }

    public void setZtrseihowebsekno(Integer pZtrseihowebsekno) {
        ztrseihowebsekno = pZtrseihowebsekno;
    }

}