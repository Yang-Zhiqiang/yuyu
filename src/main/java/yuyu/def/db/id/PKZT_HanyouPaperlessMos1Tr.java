package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.mapping.GenZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.meta.GenQZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.meta.QZT_HanyouPaperlessMos1Tr;

/**
 * 汎用ペーパーレス申込情報１テーブル（取） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HanyouPaperlessMos1Tr}</td><td colspan="3">汎用ペーパーレス申込情報１テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrseihowebidkbn ztrseihowebidkbn}</td><td>（取込用）生保ＷｅｂＩＤ区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrseihowebkojincd ztrseihowebkojincd}</td><td>（取込用）生保Ｗｅｂ個人コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrseihowebitijihozonhyouji ztrseihowebitijihozonhyouji}</td><td>（取込用）生保Ｗｅｂ一時保存表示</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtrseihowebseknoc ztrseihowebseknoc}</td><td>（取込用）生保Ｗｅｂ設計書番号Ｃ</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebcalckijyunymdc</td><td>（取込用）生保Ｗｅｂ計算基準年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknknnm</td><td>（取込用）生保Ｗｅｂ被保険者カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknseiymdc</td><td>（取込用）生保Ｗｅｂ被保険者生年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknseikbn</td><td>（取込用）生保Ｗｅｂ被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkykknnm</td><td>（取込用）生保Ｗｅｂ契約者カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkyksyaseiymdc</td><td>（取込用）生保Ｗｅｂ契約者生年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkyksyaseikbn</td><td>（取込用）生保Ｗｅｂ契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhknsyuruinoc</td><td>（取込用）生保Ｗｅｂ保険種類番号Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhknkknc</td><td>（取込用）生保Ｗｅｂ保険期間Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebphrkkiknc</td><td>（取込用）生保ＷｅｂＰ払込期間Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebhrkkaisuukbn</td><td>（取込用）生保Ｗｅｂ払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsdpdkbn</td><td>（取込用）生保ＷｅｂＳ建Ｐ建区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkihonsc</td><td>（取込用）生保Ｗｅｂ基本ＳＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebnksyuruikbn</td><td>（取込用）生保Ｗｅｂ年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihoweblntkkbn</td><td>（取込用）生保ＷｅｂＬＮ特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebnkshrarihyj</td><td>（取込用）生保Ｗｅｂ年金支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmosnoc</td><td>（取込用）生保Ｗｅｂ申込番号Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsekykkigenymdc</td><td>（取込用）生保Ｗｅｂ設計書有効期限年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsksjsitencd</td><td>（取込用）生保Ｗｅｂ作成時支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebfstmossksymdc</td><td>（取込用）生保Ｗｅｂ初回申込書作成年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhnsyukyktdkkbn</td><td>（取込用）生保Ｗｅｂ編集後契約者続柄区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhjnkitikbn</td><td>（取込用）生保Ｗｅｂ法人形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhjnkykhyj</td><td>（取込用）生保Ｗｅｂ法人契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtksykmcd1</td><td>（取込用）生保Ｗｅｂ特殊項目コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtksykmcd2</td><td>（取込用）生保Ｗｅｂ特殊項目コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtksykmcd3</td><td>（取込用）生保Ｗｅｂ特殊項目コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtksykmcd4</td><td>（取込用）生保Ｗｅｂ特殊項目コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtksykmcd5</td><td>（取込用）生保Ｗｅｂ特殊項目コード５　</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebteiwkknc</td><td>（取込用）生保Ｗｅｂ低Ｗ期間Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebknhjnnm</td><td>（取込用）生保Ｗｅｂカナ法人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkjhjnnm</td><td>（取込用）生保Ｗｅｂ漢字法人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkndaihyounm</td><td>（取込用）生保Ｗｅｂカナ代表者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkjdaihyounm</td><td>（取込用）生保Ｗｅｂ漢字代表者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdaihyouktgkkbn</td><td>（取込用）生保Ｗｅｂ代表者肩書区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsykihrkp1c</td><td>（取込用）生保Ｗｅｂ初回払込Ｐ１Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebmosp1c</td><td>（取込用）生保Ｗｅｂ申込Ｐ１Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebtkiyougyoutaikbn</td><td>（取込用）生保Ｗｅｂ統計用業態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebzennoukknc</td><td>（取込用）生保Ｗｅｂ前納期間Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebpaperlessmoshyj</td><td>（取込用）生保Ｗｅｂペーパーレス申込表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdatasousinzmhyj</td><td>（取込用）生保Ｗｅｂデータ送信済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkknmskhjnkitikbn</td><td>（取込用）生保Ｗｅｂ契勤務先法人形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkykottmsk</td><td>（取込用）生保Ｗｅｂ契約者お勤め先</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknsykgycd</td><td>（取込用）生保Ｗｅｂ被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhknmskhjnkitikbn</td><td>（取込用）生保Ｗｅｂ被勤務先法人形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknottmsk</td><td>（取込用）生保Ｗｅｂ被保険者お勤め先</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknnensyuukbn</td><td>（取込用）生保Ｗｅｂ被保険者年収区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbukthksuninzuuc</td><td>（取込用）生保Ｗｅｂ死亡受取人複数人数Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebsbuktbnwari1c</td><td>（取込用）生保Ｗｅｂ死亡受取人分割割合１Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebsbukttdkkbn2</td><td>（取込用）生保Ｗｅｂ死亡受取人続柄区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktknnm2</td><td>（取込用）生保Ｗｅｂ死亡受取人カナ氏名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktkjnm2</td><td>（取込用）生保Ｗｅｂ死亡受取人漢字氏名２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktseiymd2c</td><td>（取込用）生保Ｗｅｂ死亡受取人生年月日２Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktbnwari2c</td><td>（取込用）生保Ｗｅｂ死亡受取人分割割合２Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebsbukttdkkbn3</td><td>（取込用）生保Ｗｅｂ死亡受取人続柄区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktknnm3</td><td>（取込用）生保Ｗｅｂ死亡受取人カナ氏名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktkjnm3</td><td>（取込用）生保Ｗｅｂ死亡受取人漢字氏名３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktseiymd3c</td><td>（取込用）生保Ｗｅｂ死亡受取人生年月日３Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktbnwari3c</td><td>（取込用）生保Ｗｅｂ死亡受取人分割割合３Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebsbukttdkkbn4</td><td>（取込用）生保Ｗｅｂ死亡受取人続柄区分４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktknnm4</td><td>（取込用）生保Ｗｅｂ死亡受取人カナ氏名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktkjnm4</td><td>（取込用）生保Ｗｅｂ死亡受取人漢字氏名４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktseiymd4c</td><td>（取込用）生保Ｗｅｂ死亡受取人生年月日４Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbuktbnwari4c</td><td>（取込用）生保Ｗｅｂ死亡受取人分割割合４Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebnkuktmrhhyj</td><td>（取込用）生保Ｗｅｂ年金受取人マル被表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbnkkknc</td><td>（取込用）生保Ｗｅｂ死亡年金期間Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebikokakkjarihyj</td><td>（取込用）生保Ｗｅｂ意向確認記事有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebfatcasnsiarihyj</td><td>（取込用）生保ＷｅｂＦＡＴＣＡ宣誓有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkouhurisitencd</td><td>（取込用）生保Ｗｅｂ口振支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkouhuriyokinkbn</td><td>（取込用）生保Ｗｅｂ口振預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkouhurikouzano</td><td>（取込用）生保Ｗｅｂ口振口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkuhrshmnttdkhyj</td><td>（取込用）生保Ｗｅｂ口振書面手続表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmosymdc</td><td>（取込用）生保Ｗｅｂ申込年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsyokugyoukktymdc</td><td>（取込用）生保Ｗｅｂ職業告知年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhhknsintyouc</td><td>（取込用）生保Ｗｅｂ被保険者身長Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebhhkntaijyuuc</td><td>（取込用）生保Ｗｅｂ被保険者体重Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebkktymdc</td><td>（取込用）生保Ｗｅｂ告知年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhukusuustskskbn</td><td>（取込用）生保Ｗｅｂ複数指定書作成区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhnnkaksyoruikbn</td><td>（取込用）生保Ｗｅｂ本人確認書類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhsktkjikou</td><td>（取込用）生保Ｗｅｂ補足特定事項</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebskskaksyoruikbn</td><td>（取込用）生保Ｗｅｂ親権者確認書類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebskshsktkjikou</td><td>（取込用）生保Ｗｅｂ親権者補足特定事項</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebbikkjnssinfoari</td><td>（取込用）生保Ｗｅｂ米国人示唆情報有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplbsyutrkno</td><td>（取込用）生保ＷｅｂＰＬ募集人登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplbsyukouincd</td><td>（取込用）生保ＷｅｂＰＬ募集人行員コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebnrkbsyutrkno</td><td>（取込用）生保Ｗｅｂ入力募集人登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebuktkid</td><td>（取込用）生保Ｗｅｂ受付管理ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdatasousinymdc</td><td>（取込用）生保Ｗｅｂデータ送信年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdatasousinhmsc</td><td>（取込用）生保Ｗｅｂデータ送信時分秒Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmosuktkymdc</td><td>（取込用）生保Ｗｅｂ申込書受付年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhnnkakhskjk1</td><td>（取込用）生保Ｗｅｂ本人確認補足事項欄１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhnnkakhskjk2</td><td>（取込用）生保Ｗｅｂ本人確認補足事項欄２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhnnkakhskjk3</td><td>（取込用）生保Ｗｅｂ本人確認補足事項欄３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhnnkakhskjk4</td><td>（取込用）生保Ｗｅｂ本人確認補足事項欄４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhnnkakhskjk5</td><td>（取込用）生保Ｗｅｂ本人確認補足事項欄５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtorihoutkjk1</td><td>（取込用）生保Ｗｅｂ取報特記事項欄１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtorihoutkjk2</td><td>（取込用）生保Ｗｅｂ取報特記事項欄２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtorihoutkjk3</td><td>（取込用）生保Ｗｅｂ取報特記事項欄３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtorihoutkjk4</td><td>（取込用）生保Ｗｅｂ取報特記事項欄４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtorihoutkjk5</td><td>（取込用）生保Ｗｅｂ取報特記事項欄５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdrtnskno</td><td>（取込用）生保Ｗｅｂ代理店設計書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsbnksyukbn</td><td>（取込用）生保Ｗｅｂ死亡年金種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebaatkisyaknyuucd</td><td>（取込用）生保ＷｅｂＡ扱者金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkktttykknrhyj</td><td>（取込用）生保Ｗｅｂ告知書到着管理表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdtlkktarihyj</td><td>（取込用）生保Ｗｅｂ詳細告知書有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebfatcasyoruiari</td><td>（取込用）生保ＷｅｂＦＡＴＣＡ書類有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzhurikaebankcd</td><td>（取込用）生保Ｗｅｂ口座振替銀行番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkakiraikbn</td><td>（取込用）生保Ｗｅｂ口座確認依頼区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebbmierrorhyj</td><td>（取込用）生保ＷｅｂＢＭＩエラー表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkktkmgituarihyj</td><td>（取込用）生保Ｗｅｂ告知項目該当有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsnshuhukbn</td><td>（取込用）生保Ｗｅｂ診査方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkeihidouituhyj</td><td>（取込用）生保Ｗｅｂ契被同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebaeoisnsiarihyj</td><td>（取込用）生保ＷｅｂＡＥＯＩ宣誓有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebsiteituukakbn</td><td>（取込用）生保Ｗｅｂ指定通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebnykntuukakbn</td><td>（取込用）生保Ｗｅｂ入金通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtargettkarihyj</td><td>（取込用）生保Ｗｅｂターゲット特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtargettkkbn</td><td>（取込用）生保Ｗｅｂターゲット特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebtargettkmkhtc</td><td>（取込用）生保Ｗｅｂターゲット特約目標値Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebnykntuukanykngkc</td><td>（取込用）生保Ｗｅｂ入金通貨入金額Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebnykntukfsthrkpc</td><td>（取込用）生保Ｗｅｂ入金通貨初回払込ＰＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebnykntuknexthrkpc</td><td>（取込用）生保Ｗｅｂ入金通貨次回払込ＰＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebtargetyenknsnpc</td><td>（取込用）生保Ｗｅｂターゲット円換算ＰＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebtargetmkhgkc</td><td>（取込用）生保Ｗｅｂターゲット目標額Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebsaimankihyj</td><td>（取込用）生保Ｗｅｂ才満期表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebrayhyj</td><td>（取込用）生保ＷｅｂＲＡＹ表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv156</td><td>（取込用）予備項目Ｖ１５６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebpsyouhyj</td><td>（取込用）生保ＷｅｂＰＳ要表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhhknkjnm</td><td>（取込用）生保ＷｅｂＰＬ被保険者漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv1</td><td>（取込用）予備項目Ｖ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplkykkjnm</td><td>（取込用）生保ＷｅｂＰＬ契約者漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhjkktkbn</td><td>（取込用）生保ＷｅｂＰＬ報状告知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhrkkeirokbn</td><td>（取込用）生保ＷｅｂＰＬ払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplnkshrarihyj</td><td>（取込用）生保ＷｅｂＰＬ年金支払有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv2</td><td>（取込用）予備項目Ｖ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplmosnoc</td><td>（取込用）生保ＷｅｂＰＬ申込番号Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplsbuktnrkkbn</td><td>（取込用）生保ＷｅｂＰＬ死亡受入力区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplsbukttdkkbn</td><td>（取込用）生保ＷｅｂＰＬ死亡受続柄区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplsbuktknnm</td><td>（取込用）生保ＷｅｂＰＬ死亡受カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplsbuktkjnm</td><td>（取込用）生保ＷｅｂＰＬ死亡受漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv3</td><td>（取込用）予備項目Ｖ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplsbuktseiymdc</td><td>（取込用）生保ＷｅｂＰＬ死亡受生年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebpltksykmcd1</td><td>（取込用）生保ＷｅｂＰＬ特殊項目コード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebpltksykmcd2</td><td>（取込用）生保ＷｅｂＰＬ特殊項目コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebpltksykmcd3</td><td>（取込用）生保ＷｅｂＰＬ特殊項目コード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebpltksykmcd4</td><td>（取込用）生保ＷｅｂＰＬ特殊項目コード４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebpltksykmcd5</td><td>（取込用）生保ＷｅｂＰＬ特殊項目コード５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplkyktelno</td><td>（取込用）生保ＷｅｂＰＬ契約者電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhhkntelno</td><td>（取込用）生保ＷｅｂＰＬ被保険者電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv3x2</td><td>（取込用）予備項目Ｖ３＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplkihontikucd</td><td>（取込用）生保ＷｅｂＰＬ基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebpltsinadrkai</td><td>（取込用）生保ＷｅｂＰＬ通信先住所下位</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhiikihontikucd</td><td>（取込用）生保ＷｅｂＰＬ被基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebplhhknadr</td><td>（取込用）生保ＷｅｂＰＬ被保険者住所</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebgnykntuknykngkc</td><td>（取込用）生保Ｗｅｂ外貨入金通貨入金額Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebgnykntukfsthrkpc</td><td>（取込用）生保Ｗｅｂ外貨入金通貨初回ＰＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebgnykntuknxthrkpc</td><td>（取込用）生保Ｗｅｂ外貨入金通貨次回ＰＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebgaikakihonpc</td><td>（取込用）生保Ｗｅｂ外貨基本ＰＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebkaigmehrtkarihyj</td><td>（取込用）生保Ｗｅｂ介護前払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebyenhsyutkarihyj</td><td>（取込用）生保Ｗｅｂ円最低保証特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebgaikakihonsc</td><td>（取込用）生保Ｗｅｂ外貨基本ＳＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebdai1hknkknc</td><td>（取込用）生保Ｗｅｂ第１保険期間Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebdsmoshyj</td><td>（取込用）生保ＷｅｂＤＳ申込有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdsmailaddress</td><td>（取込用）生保ＷｅｂＤＳメールアドレス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebankenkanrino</td><td>（取込用）生保Ｗｅｂ案件管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkydbosyuukjncd</td><td>（取込用）生保Ｗｅｂ共同募集個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebhnyppltzmhyj</td><td>（取込用）生保Ｗｅｂ汎用ＰＰＬ対応済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebssrndhbnwrc</td><td>（取込用）生保Ｗｅｂ指数連動部分配分割合Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebtrtrndhbnwrc</td><td>（取込用）生保Ｗｅｂ定率積立部分配分割合Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebsueokikknc</td><td>（取込用）生保Ｗｅｂ据置期間Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebmnkuktnrkkbn</td><td>（取込用）生保Ｗｅｂ満期受取人入力区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmnkukttdkkbn</td><td>（取込用）生保Ｗｅｂ満期受取人続柄区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmnkuktknnm</td><td>（取込用）生保Ｗｅｂ満期受取人カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmnkuktkjnm</td><td>（取込用）生保Ｗｅｂ満期受取人漢字氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebmnkuktseiymdc</td><td>（取込用）生保Ｗｅｂ満期受取人生年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdsknkzmeigi</td><td>（取込用）生保ＷｅｂＤＳカナ口座名義</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdskzsyuruikbn</td><td>（取込用）生保ＷｅｂＤＳ口座種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdskinyuucd</td><td>（取込用）生保ＷｅｂＤＳ金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdssitencd</td><td>（取込用）生保ＷｅｂＤＳ支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdsyokinkbn</td><td>（取込用）生保ＷｅｂＤＳ預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdskouzano</td><td>（取込用）生保ＷｅｂＤＳ口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdsansyono</td><td>（取込用）生保ＷｅｂＤＳ暗証番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdssymnttdkhyj</td><td>（取込用）生保ＷｅｂＤＳ書面手続表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebikkatupc</td><td>（取込用）生保Ｗｅｂ一括払ＰＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebikkatubaraikbn</td><td>（取込用）生保Ｗｅｂ一括払区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebiktbrikaisuuc</td><td>（取込用）生保Ｗｅｂ一括払回数Ｃ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztrseihowebzennoupc</td><td>（取込用）生保Ｗｅｂ前納ＰＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebgaikazennoupc</td><td>（取込用）生保Ｗｅｂ外貨前納ＰＣ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztrseihowebzennouhyj</td><td>（取込用）生保Ｗｅｂ前納表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebyakkankbn</td><td>（取込用）生保Ｗｅｂ約款区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebnetkhrzmhyj</td><td>（取込用）生保Ｗｅｂネット口振対応済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzktrkmoskbn</td><td>（取込用）生保Ｗｅｂご家族登録申込区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzktdkkbn1</td><td>（取込用）生保Ｗｅｂご家族続柄区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkknnm1</td><td>（取込用）生保Ｗｅｂご家族カナ氏名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkkjnm1</td><td>（取込用）生保Ｗｅｂご家族漢字氏名１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkseikbn1</td><td>（取込用）生保Ｗｅｂご家族性別区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkzkseiymd1c</td><td>（取込用）生保Ｗｅｂご家族生年月日１Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>ztrseihowebhhkndrseiymdc</td><td>（取込用）生保Ｗｅｂ被代理生年月日Ｃ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebdaihituarihyj</td><td>（取込用）生保Ｗｅｂ代筆有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkoureisyakakkbn1</td><td>（取込用）生保Ｗｅｂ高齢者確認区分１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkoureisyakakkbn2</td><td>（取込用）生保Ｗｅｂ高齢者確認区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebkoureisyakakkbn3</td><td>（取込用）生保Ｗｅｂ高齢者確認区分３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztrseihowebptuutihyj</td><td>（取込用）生保Ｗｅｂ保険料通知有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztryobiv1546</td><td>（取込用）予備項目Ｖ１５４６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_HanyouPaperlessMos1Tr
 * @see     GenZT_HanyouPaperlessMos1Tr
 * @see     QZT_HanyouPaperlessMos1Tr
 * @see     GenQZT_HanyouPaperlessMos1Tr
 */
public class PKZT_HanyouPaperlessMos1Tr extends AbstractExDBPrimaryKey<ZT_HanyouPaperlessMos1Tr, PKZT_HanyouPaperlessMos1Tr> {

    private static final long serialVersionUID = 1L;

    public PKZT_HanyouPaperlessMos1Tr() {
    }

    public PKZT_HanyouPaperlessMos1Tr(
        String pZtrseihowebidkbn,
        String pZtrseihowebkojincd,
        String pZtrseihowebitijihozonhyouji,
        Integer pZtrseihowebseknoc
    ) {
        ztrseihowebidkbn = pZtrseihowebidkbn;
        ztrseihowebkojincd = pZtrseihowebkojincd;
        ztrseihowebitijihozonhyouji = pZtrseihowebitijihozonhyouji;
        ztrseihowebseknoc = pZtrseihowebseknoc;
    }

    @Transient
    @Override
    public Class<ZT_HanyouPaperlessMos1Tr> getEntityClass() {
        return ZT_HanyouPaperlessMos1Tr.class;
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
    private Integer ztrseihowebseknoc;

    public Integer getZtrseihowebseknoc() {
        return ztrseihowebseknoc;
    }

    public void setZtrseihowebseknoc(Integer pZtrseihowebseknoc) {
        ztrseihowebseknoc = pZtrseihowebseknoc;
    }

}