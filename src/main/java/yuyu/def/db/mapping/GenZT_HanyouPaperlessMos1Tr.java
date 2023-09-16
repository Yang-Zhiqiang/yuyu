package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.id.PKZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.meta.GenQZT_HanyouPaperlessMos1Tr;
import yuyu.def.db.meta.QZT_HanyouPaperlessMos1Tr;

/**
 * 汎用ペーパーレス申込情報１テーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_HanyouPaperlessMos1Tr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_HanyouPaperlessMos1Tr}</td><td colspan="3">汎用ペーパーレス申込情報１テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrseihowebidkbn ztrseihowebidkbn}</td><td>（取込用）生保ＷｅｂＩＤ区分</td><td align="center">{@link PKZT_HanyouPaperlessMos1Tr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkojincd ztrseihowebkojincd}</td><td>（取込用）生保Ｗｅｂ個人コード</td><td align="center">{@link PKZT_HanyouPaperlessMos1Tr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebitijihozonhyouji ztrseihowebitijihozonhyouji}</td><td>（取込用）生保Ｗｅｂ一時保存表示</td><td align="center">{@link PKZT_HanyouPaperlessMos1Tr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebseknoc ztrseihowebseknoc}</td><td>（取込用）生保Ｗｅｂ設計書番号Ｃ</td><td align="center">{@link PKZT_HanyouPaperlessMos1Tr ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebcalckijyunymdc ztrseihowebcalckijyunymdc}</td><td>（取込用）生保Ｗｅｂ計算基準年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknknnm ztrseihowebhhknknnm}</td><td>（取込用）生保Ｗｅｂ被保険者カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknseiymdc ztrseihowebhhknseiymdc}</td><td>（取込用）生保Ｗｅｂ被保険者生年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknseikbn ztrseihowebhhknseikbn}</td><td>（取込用）生保Ｗｅｂ被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkykknnm ztrseihowebkykknnm}</td><td>（取込用）生保Ｗｅｂ契約者カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkyksyaseiymdc ztrseihowebkyksyaseiymdc}</td><td>（取込用）生保Ｗｅｂ契約者生年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkyksyaseikbn ztrseihowebkyksyaseikbn}</td><td>（取込用）生保Ｗｅｂ契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhknsyuruinoc ztrseihowebhknsyuruinoc}</td><td>（取込用）生保Ｗｅｂ保険種類番号Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhknkknc ztrseihowebhknkknc}</td><td>（取込用）生保Ｗｅｂ保険期間Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebphrkkiknc ztrseihowebphrkkiknc}</td><td>（取込用）生保ＷｅｂＰ払込期間Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebhrkkaisuukbn ztrseihowebhrkkaisuukbn}</td><td>（取込用）生保Ｗｅｂ払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsdpdkbn ztrseihowebsdpdkbn}</td><td>（取込用）生保ＷｅｂＳ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkihonsc ztrseihowebkihonsc}</td><td>（取込用）生保Ｗｅｂ基本ＳＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebnksyuruikbn ztrseihowebnksyuruikbn}</td><td>（取込用）生保Ｗｅｂ年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihoweblntkkbn ztrseihoweblntkkbn}</td><td>（取込用）生保ＷｅｂＬＮ特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebnkshrarihyj ztrseihowebnkshrarihyj}</td><td>（取込用）生保Ｗｅｂ年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmosnoc ztrseihowebmosnoc}</td><td>（取込用）生保Ｗｅｂ申込番号Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsekykkigenymdc ztrseihowebsekykkigenymdc}</td><td>（取込用）生保Ｗｅｂ設計書有効期限年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsksjsitencd ztrseihowebsksjsitencd}</td><td>（取込用）生保Ｗｅｂ作成時支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebfstmossksymdc ztrseihowebfstmossksymdc}</td><td>（取込用）生保Ｗｅｂ初回申込書作成年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhnsyukyktdkkbn ztrseihowebhnsyukyktdkkbn}</td><td>（取込用）生保Ｗｅｂ編集後契約者続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhjnkitikbn ztrseihowebhjnkitikbn}</td><td>（取込用）生保Ｗｅｂ法人形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhjnkykhyj ztrseihowebhjnkykhyj}</td><td>（取込用）生保Ｗｅｂ法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtksykmcd1 ztrseihowebtksykmcd1}</td><td>（取込用）生保Ｗｅｂ特殊項目コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtksykmcd2 ztrseihowebtksykmcd2}</td><td>（取込用）生保Ｗｅｂ特殊項目コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtksykmcd3 ztrseihowebtksykmcd3}</td><td>（取込用）生保Ｗｅｂ特殊項目コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtksykmcd4 ztrseihowebtksykmcd4}</td><td>（取込用）生保Ｗｅｂ特殊項目コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtksykmcd5 ztrseihowebtksykmcd5}</td><td>（取込用）生保Ｗｅｂ特殊項目コード５　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebteiwkknc ztrseihowebteiwkknc}</td><td>（取込用）生保Ｗｅｂ低Ｗ期間Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebknhjnnm ztrseihowebknhjnnm}</td><td>（取込用）生保Ｗｅｂカナ法人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkjhjnnm ztrseihowebkjhjnnm}</td><td>（取込用）生保Ｗｅｂ漢字法人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkndaihyounm ztrseihowebkndaihyounm}</td><td>（取込用）生保Ｗｅｂカナ代表者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkjdaihyounm ztrseihowebkjdaihyounm}</td><td>（取込用）生保Ｗｅｂ漢字代表者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdaihyouktgkkbn ztrseihowebdaihyouktgkkbn}</td><td>（取込用）生保Ｗｅｂ代表者肩書区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsykihrkp1c ztrseihowebsykihrkp1c}</td><td>（取込用）生保Ｗｅｂ初回払込Ｐ１Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebmosp1c ztrseihowebmosp1c}</td><td>（取込用）生保Ｗｅｂ申込Ｐ１Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebtkiyougyoutaikbn ztrseihowebtkiyougyoutaikbn}</td><td>（取込用）生保Ｗｅｂ統計用業態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebzennoukknc ztrseihowebzennoukknc}</td><td>（取込用）生保Ｗｅｂ前納期間Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebpaperlessmoshyj ztrseihowebpaperlessmoshyj}</td><td>（取込用）生保Ｗｅｂペーパーレス申込表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdatasousinzmhyj ztrseihowebdatasousinzmhyj}</td><td>（取込用）生保Ｗｅｂデータ送信済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkknmskhjnkitikbn ztrseihowebkknmskhjnkitikbn}</td><td>（取込用）生保Ｗｅｂ契勤務先法人形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkykottmsk ztrseihowebkykottmsk}</td><td>（取込用）生保Ｗｅｂ契約者お勤め先</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknsykgycd ztrseihowebhhknsykgycd}</td><td>（取込用）生保Ｗｅｂ被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhknmskhjnkitikbn ztrseihowebhknmskhjnkitikbn}</td><td>（取込用）生保Ｗｅｂ被勤務先法人形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknottmsk ztrseihowebhhknottmsk}</td><td>（取込用）生保Ｗｅｂ被保険者お勤め先</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknnensyuukbn ztrseihowebhhknnensyuukbn}</td><td>（取込用）生保Ｗｅｂ被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbukthksuninzuuc ztrseihowebsbukthksuninzuuc}</td><td>（取込用）生保Ｗｅｂ死亡受取人複数人数Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktbnwari1c ztrseihowebsbuktbnwari1c}</td><td>（取込用）生保Ｗｅｂ死亡受取人分割割合１Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbukttdkkbn2 ztrseihowebsbukttdkkbn2}</td><td>（取込用）生保Ｗｅｂ死亡受取人続柄区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktknnm2 ztrseihowebsbuktknnm2}</td><td>（取込用）生保Ｗｅｂ死亡受取人カナ氏名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktkjnm2 ztrseihowebsbuktkjnm2}</td><td>（取込用）生保Ｗｅｂ死亡受取人漢字氏名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktseiymd2c ztrseihowebsbuktseiymd2c}</td><td>（取込用）生保Ｗｅｂ死亡受取人生年月日２Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktbnwari2c ztrseihowebsbuktbnwari2c}</td><td>（取込用）生保Ｗｅｂ死亡受取人分割割合２Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbukttdkkbn3 ztrseihowebsbukttdkkbn3}</td><td>（取込用）生保Ｗｅｂ死亡受取人続柄区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktknnm3 ztrseihowebsbuktknnm3}</td><td>（取込用）生保Ｗｅｂ死亡受取人カナ氏名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktkjnm3 ztrseihowebsbuktkjnm3}</td><td>（取込用）生保Ｗｅｂ死亡受取人漢字氏名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktseiymd3c ztrseihowebsbuktseiymd3c}</td><td>（取込用）生保Ｗｅｂ死亡受取人生年月日３Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktbnwari3c ztrseihowebsbuktbnwari3c}</td><td>（取込用）生保Ｗｅｂ死亡受取人分割割合３Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbukttdkkbn4 ztrseihowebsbukttdkkbn4}</td><td>（取込用）生保Ｗｅｂ死亡受取人続柄区分４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktknnm4 ztrseihowebsbuktknnm4}</td><td>（取込用）生保Ｗｅｂ死亡受取人カナ氏名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktkjnm4 ztrseihowebsbuktkjnm4}</td><td>（取込用）生保Ｗｅｂ死亡受取人漢字氏名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktseiymd4c ztrseihowebsbuktseiymd4c}</td><td>（取込用）生保Ｗｅｂ死亡受取人生年月日４Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktbnwari4c ztrseihowebsbuktbnwari4c}</td><td>（取込用）生保Ｗｅｂ死亡受取人分割割合４Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebnkuktmrhhyj ztrseihowebnkuktmrhhyj}</td><td>（取込用）生保Ｗｅｂ年金受取人マル被表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbnkkknc ztrseihowebsbnkkknc}</td><td>（取込用）生保Ｗｅｂ死亡年金期間Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebikokakkjarihyj ztrseihowebikokakkjarihyj}</td><td>（取込用）生保Ｗｅｂ意向確認記事有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebfatcasnsiarihyj ztrseihowebfatcasnsiarihyj}</td><td>（取込用）生保ＷｅｂＦＡＴＣＡ宣誓有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkouhurisitencd ztrseihowebkouhurisitencd}</td><td>（取込用）生保Ｗｅｂ口振支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkouhuriyokinkbn ztrseihowebkouhuriyokinkbn}</td><td>（取込用）生保Ｗｅｂ口振預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkouhurikouzano ztrseihowebkouhurikouzano}</td><td>（取込用）生保Ｗｅｂ口振口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkuhrshmnttdkhyj ztrseihowebkuhrshmnttdkhyj}</td><td>（取込用）生保Ｗｅｂ口振書面手続表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmosymdc ztrseihowebmosymdc}</td><td>（取込用）生保Ｗｅｂ申込年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsyokugyoukktymdc ztrseihowebsyokugyoukktymdc}</td><td>（取込用）生保Ｗｅｂ職業告知年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknsintyouc ztrseihowebhhknsintyouc}</td><td>（取込用）生保Ｗｅｂ被保険者身長Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhkntaijyuuc ztrseihowebhhkntaijyuuc}</td><td>（取込用）生保Ｗｅｂ被保険者体重Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebkktymdc ztrseihowebkktymdc}</td><td>（取込用）生保Ｗｅｂ告知年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhukusuustskskbn ztrseihowebhukusuustskskbn}</td><td>（取込用）生保Ｗｅｂ複数指定書作成区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhnnkaksyoruikbn ztrseihowebhnnkaksyoruikbn}</td><td>（取込用）生保Ｗｅｂ本人確認書類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhsktkjikou ztrseihowebhsktkjikou}</td><td>（取込用）生保Ｗｅｂ補足特定事項</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebskskaksyoruikbn ztrseihowebskskaksyoruikbn}</td><td>（取込用）生保Ｗｅｂ親権者確認書類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebskshsktkjikou ztrseihowebskshsktkjikou}</td><td>（取込用）生保Ｗｅｂ親権者補足特定事項</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebbikkjnssinfoari ztrseihowebbikkjnssinfoari}</td><td>（取込用）生保Ｗｅｂ米国人示唆情報有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplbsyutrkno ztrseihowebplbsyutrkno}</td><td>（取込用）生保ＷｅｂＰＬ募集人登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplbsyukouincd ztrseihowebplbsyukouincd}</td><td>（取込用）生保ＷｅｂＰＬ募集人行員コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebnrkbsyutrkno ztrseihowebnrkbsyutrkno}</td><td>（取込用）生保Ｗｅｂ入力募集人登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebuktkid ztrseihowebuktkid}</td><td>（取込用）生保Ｗｅｂ受付管理ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdatasousinymdc ztrseihowebdatasousinymdc}</td><td>（取込用）生保Ｗｅｂデータ送信年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdatasousinhmsc ztrseihowebdatasousinhmsc}</td><td>（取込用）生保Ｗｅｂデータ送信時分秒Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmosuktkymdc ztrseihowebmosuktkymdc}</td><td>（取込用）生保Ｗｅｂ申込書受付年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhnnkakhskjk1 ztrseihowebhnnkakhskjk1}</td><td>（取込用）生保Ｗｅｂ本人確認補足事項欄１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhnnkakhskjk2 ztrseihowebhnnkakhskjk2}</td><td>（取込用）生保Ｗｅｂ本人確認補足事項欄２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhnnkakhskjk3 ztrseihowebhnnkakhskjk3}</td><td>（取込用）生保Ｗｅｂ本人確認補足事項欄３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhnnkakhskjk4 ztrseihowebhnnkakhskjk4}</td><td>（取込用）生保Ｗｅｂ本人確認補足事項欄４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhnnkakhskjk5 ztrseihowebhnnkakhskjk5}</td><td>（取込用）生保Ｗｅｂ本人確認補足事項欄５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtorihoutkjk1 ztrseihowebtorihoutkjk1}</td><td>（取込用）生保Ｗｅｂ取報特記事項欄１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtorihoutkjk2 ztrseihowebtorihoutkjk2}</td><td>（取込用）生保Ｗｅｂ取報特記事項欄２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtorihoutkjk3 ztrseihowebtorihoutkjk3}</td><td>（取込用）生保Ｗｅｂ取報特記事項欄３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtorihoutkjk4 ztrseihowebtorihoutkjk4}</td><td>（取込用）生保Ｗｅｂ取報特記事項欄４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtorihoutkjk5 ztrseihowebtorihoutkjk5}</td><td>（取込用）生保Ｗｅｂ取報特記事項欄５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdrtnskno ztrseihowebdrtnskno}</td><td>（取込用）生保Ｗｅｂ代理店設計書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbnksyukbn ztrseihowebsbnksyukbn}</td><td>（取込用）生保Ｗｅｂ死亡年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebaatkisyaknyuucd ztrseihowebaatkisyaknyuucd}</td><td>（取込用）生保ＷｅｂＡ扱者金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkktttykknrhyj ztrseihowebkktttykknrhyj}</td><td>（取込用）生保Ｗｅｂ告知書到着管理表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdtlkktarihyj ztrseihowebdtlkktarihyj}</td><td>（取込用）生保Ｗｅｂ詳細告知書有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebfatcasyoruiari ztrseihowebfatcasyoruiari}</td><td>（取込用）生保ＷｅｂＦＡＴＣＡ書類有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzhurikaebankcd ztrseihowebkzhurikaebankcd}</td><td>（取込用）生保Ｗｅｂ口座振替銀行番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkakiraikbn ztrseihowebkzkakiraikbn}</td><td>（取込用）生保Ｗｅｂ口座確認依頼区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebbmierrorhyj ztrseihowebbmierrorhyj}</td><td>（取込用）生保ＷｅｂＢＭＩエラー表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkktkmgituarihyj ztrseihowebkktkmgituarihyj}</td><td>（取込用）生保Ｗｅｂ告知項目該当有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsnshuhukbn ztrseihowebsnshuhukbn}</td><td>（取込用）生保Ｗｅｂ診査方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkeihidouituhyj ztrseihowebkeihidouituhyj}</td><td>（取込用）生保Ｗｅｂ契被同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebaeoisnsiarihyj ztrseihowebaeoisnsiarihyj}</td><td>（取込用）生保ＷｅｂＡＥＯＩ宣誓有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsiteituukakbn ztrseihowebsiteituukakbn}</td><td>（取込用）生保Ｗｅｂ指定通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebnykntuukakbn ztrseihowebnykntuukakbn}</td><td>（取込用）生保Ｗｅｂ入金通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtargettkarihyj ztrseihowebtargettkarihyj}</td><td>（取込用）生保Ｗｅｂターゲット特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtargettkkbn ztrseihowebtargettkkbn}</td><td>（取込用）生保Ｗｅｂターゲット特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtargettkmkhtc ztrseihowebtargettkmkhtc}</td><td>（取込用）生保Ｗｅｂターゲット特約目標値Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebnykntuukanykngkc ztrseihowebnykntuukanykngkc}</td><td>（取込用）生保Ｗｅｂ入金通貨入金額Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebnykntukfsthrkpc ztrseihowebnykntukfsthrkpc}</td><td>（取込用）生保Ｗｅｂ入金通貨初回払込ＰＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebnykntuknexthrkpc ztrseihowebnykntuknexthrkpc}</td><td>（取込用）生保Ｗｅｂ入金通貨次回払込ＰＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebtargetyenknsnpc ztrseihowebtargetyenknsnpc}</td><td>（取込用）生保Ｗｅｂターゲット円換算ＰＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebtargetmkhgkc ztrseihowebtargetmkhgkc}</td><td>（取込用）生保Ｗｅｂターゲット目標額Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebsaimankihyj ztrseihowebsaimankihyj}</td><td>（取込用）生保Ｗｅｂ才満期表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebrayhyj ztrseihowebrayhyj}</td><td>（取込用）生保ＷｅｂＲＡＹ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv156 ztryobiv156}</td><td>（取込用）予備項目Ｖ１５６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebpsyouhyj ztrseihowebpsyouhyj}</td><td>（取込用）生保ＷｅｂＰＳ要表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhhknkjnm ztrseihowebplhhknkjnm}</td><td>（取込用）生保ＷｅｂＰＬ被保険者漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv1 ztryobiv1}</td><td>（取込用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplkykkjnm ztrseihowebplkykkjnm}</td><td>（取込用）生保ＷｅｂＰＬ契約者漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhjkktkbn ztrseihowebplhjkktkbn}</td><td>（取込用）生保ＷｅｂＰＬ報状告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhrkkeirokbn ztrseihowebplhrkkeirokbn}</td><td>（取込用）生保ＷｅｂＰＬ払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplnkshrarihyj ztrseihowebplnkshrarihyj}</td><td>（取込用）生保ＷｅｂＰＬ年金支払有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv2 ztryobiv2}</td><td>（取込用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplmosnoc ztrseihowebplmosnoc}</td><td>（取込用）生保ＷｅｂＰＬ申込番号Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplsbuktnrkkbn ztrseihowebplsbuktnrkkbn}</td><td>（取込用）生保ＷｅｂＰＬ死亡受入力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplsbukttdkkbn ztrseihowebplsbukttdkkbn}</td><td>（取込用）生保ＷｅｂＰＬ死亡受続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplsbuktknnm ztrseihowebplsbuktknnm}</td><td>（取込用）生保ＷｅｂＰＬ死亡受カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplsbuktkjnm ztrseihowebplsbuktkjnm}</td><td>（取込用）生保ＷｅｂＰＬ死亡受漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv3 ztryobiv3}</td><td>（取込用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplsbuktseiymdc ztrseihowebplsbuktseiymdc}</td><td>（取込用）生保ＷｅｂＰＬ死亡受生年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebpltksykmcd1 ztrseihowebpltksykmcd1}</td><td>（取込用）生保ＷｅｂＰＬ特殊項目コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebpltksykmcd2 ztrseihowebpltksykmcd2}</td><td>（取込用）生保ＷｅｂＰＬ特殊項目コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebpltksykmcd3 ztrseihowebpltksykmcd3}</td><td>（取込用）生保ＷｅｂＰＬ特殊項目コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebpltksykmcd4 ztrseihowebpltksykmcd4}</td><td>（取込用）生保ＷｅｂＰＬ特殊項目コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebpltksykmcd5 ztrseihowebpltksykmcd5}</td><td>（取込用）生保ＷｅｂＰＬ特殊項目コード５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplkyktelno ztrseihowebplkyktelno}</td><td>（取込用）生保ＷｅｂＰＬ契約者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhhkntelno ztrseihowebplhhkntelno}</td><td>（取込用）生保ＷｅｂＰＬ被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv3x2 ztryobiv3x2}</td><td>（取込用）予備項目Ｖ３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplkihontikucd ztrseihowebplkihontikucd}</td><td>（取込用）生保ＷｅｂＰＬ基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebpltsinadrkai ztrseihowebpltsinadrkai}</td><td>（取込用）生保ＷｅｂＰＬ通信先住所下位</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhiikihontikucd ztrseihowebplhiikihontikucd}</td><td>（取込用）生保ＷｅｂＰＬ被基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhhknadr ztrseihowebplhhknadr}</td><td>（取込用）生保ＷｅｂＰＬ被保険者住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebgnykntuknykngkc ztrseihowebgnykntuknykngkc}</td><td>（取込用）生保Ｗｅｂ外貨入金通貨入金額Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebgnykntukfsthrkpc ztrseihowebgnykntukfsthrkpc}</td><td>（取込用）生保Ｗｅｂ外貨入金通貨初回ＰＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebgnykntuknxthrkpc ztrseihowebgnykntuknxthrkpc}</td><td>（取込用）生保Ｗｅｂ外貨入金通貨次回ＰＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebgaikakihonpc ztrseihowebgaikakihonpc}</td><td>（取込用）生保Ｗｅｂ外貨基本ＰＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebkaigmehrtkarihyj ztrseihowebkaigmehrtkarihyj}</td><td>（取込用）生保Ｗｅｂ介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebyenhsyutkarihyj ztrseihowebyenhsyutkarihyj}</td><td>（取込用）生保Ｗｅｂ円最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebgaikakihonsc ztrseihowebgaikakihonsc}</td><td>（取込用）生保Ｗｅｂ外貨基本ＳＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebdai1hknkknc ztrseihowebdai1hknkknc}</td><td>（取込用）生保Ｗｅｂ第１保険期間Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebdsmoshyj ztrseihowebdsmoshyj}</td><td>（取込用）生保ＷｅｂＤＳ申込有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdsmailaddress ztrseihowebdsmailaddress}</td><td>（取込用）生保ＷｅｂＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebankenkanrino ztrseihowebankenkanrino}</td><td>（取込用）生保Ｗｅｂ案件管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkydbosyuukjncd ztrseihowebkydbosyuukjncd}</td><td>（取込用）生保Ｗｅｂ共同募集個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhnyppltzmhyj ztrseihowebhnyppltzmhyj}</td><td>（取込用）生保Ｗｅｂ汎用ＰＰＬ対応済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebssrndhbnwrc ztrseihowebssrndhbnwrc}</td><td>（取込用）生保Ｗｅｂ指数連動部分配分割合Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebtrtrndhbnwrc ztrseihowebtrtrndhbnwrc}</td><td>（取込用）生保Ｗｅｂ定率積立部分配分割合Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebsueokikknc ztrseihowebsueokikknc}</td><td>（取込用）生保Ｗｅｂ据置期間Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebmnkuktnrkkbn ztrseihowebmnkuktnrkkbn}</td><td>（取込用）生保Ｗｅｂ満期受取人入力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmnkukttdkkbn ztrseihowebmnkukttdkkbn}</td><td>（取込用）生保Ｗｅｂ満期受取人続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmnkuktknnm ztrseihowebmnkuktknnm}</td><td>（取込用）生保Ｗｅｂ満期受取人カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmnkuktkjnm ztrseihowebmnkuktkjnm}</td><td>（取込用）生保Ｗｅｂ満期受取人漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmnkuktseiymdc ztrseihowebmnkuktseiymdc}</td><td>（取込用）生保Ｗｅｂ満期受取人生年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdsknkzmeigi ztrseihowebdsknkzmeigi}</td><td>（取込用）生保ＷｅｂＤＳカナ口座名義</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdskzsyuruikbn ztrseihowebdskzsyuruikbn}</td><td>（取込用）生保ＷｅｂＤＳ口座種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdskinyuucd ztrseihowebdskinyuucd}</td><td>（取込用）生保ＷｅｂＤＳ金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdssitencd ztrseihowebdssitencd}</td><td>（取込用）生保ＷｅｂＤＳ支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdsyokinkbn ztrseihowebdsyokinkbn}</td><td>（取込用）生保ＷｅｂＤＳ預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdskouzano ztrseihowebdskouzano}</td><td>（取込用）生保ＷｅｂＤＳ口座番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdsansyono ztrseihowebdsansyono}</td><td>（取込用）生保ＷｅｂＤＳ暗証番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdssymnttdkhyj ztrseihowebdssymnttdkhyj}</td><td>（取込用）生保ＷｅｂＤＳ書面手続表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebikkatupc ztrseihowebikkatupc}</td><td>（取込用）生保Ｗｅｂ一括払ＰＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebikkatubaraikbn ztrseihowebikkatubaraikbn}</td><td>（取込用）生保Ｗｅｂ一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebiktbrikaisuuc ztrseihowebiktbrikaisuuc}</td><td>（取込用）生保Ｗｅｂ一括払回数Ｃ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebzennoupc ztrseihowebzennoupc}</td><td>（取込用）生保Ｗｅｂ前納ＰＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebgaikazennoupc ztrseihowebgaikazennoupc}</td><td>（取込用）生保Ｗｅｂ外貨前納ＰＣ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebzennouhyj ztrseihowebzennouhyj}</td><td>（取込用）生保Ｗｅｂ前納表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebyakkankbn ztrseihowebyakkankbn}</td><td>（取込用）生保Ｗｅｂ約款区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebnetkhrzmhyj ztrseihowebnetkhrzmhyj}</td><td>（取込用）生保Ｗｅｂネット口振対応済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzktrkmoskbn ztrseihowebkzktrkmoskbn}</td><td>（取込用）生保Ｗｅｂご家族登録申込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzktdkkbn1 ztrseihowebkzktdkkbn1}</td><td>（取込用）生保Ｗｅｂご家族続柄区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkknnm1 ztrseihowebkzkknnm1}</td><td>（取込用）生保Ｗｅｂご家族カナ氏名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkkjnm1 ztrseihowebkzkkjnm1}</td><td>（取込用）生保Ｗｅｂご家族漢字氏名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkseikbn1 ztrseihowebkzkseikbn1}</td><td>（取込用）生保Ｗｅｂご家族性別区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkseiymd1c ztrseihowebkzkseiymd1c}</td><td>（取込用）生保Ｗｅｂご家族生年月日１Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkkykdoukyohyj1 ztrseihowebkzkkykdoukyohyj1}</td><td>（取込用）生保Ｗｅｂご家族契同居表示１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkyno1 ztrseihowebkzkyno1}</td><td>（取込用）生保Ｗｅｂご家族郵便番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkadr1 ztrseihowebkzkadr1}</td><td>（取込用）生保Ｗｅｂご家族住所１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzktelno1 ztrseihowebkzktelno1}</td><td>（取込用）生保Ｗｅｂご家族電話番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkykdrtkkanouhyj ztrseihowebkykdrtkkanouhyj}</td><td>（取込用）生保Ｗｅｂ契代理特約可能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhkndrtkkanouhyj ztrseihowebhhkndrtkkanouhyj}</td><td>（取込用）生保Ｗｅｂ被代理特約可能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdrtkkbn ztrseihowebdrtkkbn}</td><td>（取込用）生保Ｗｅｂ代理特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkykdrnrkkbn ztrseihowebkykdrnrkkbn}</td><td>（取込用）生保Ｗｅｂ契代理入力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhkndrnrkkbn ztrseihowebhhkndrnrkkbn}</td><td>（取込用）生保Ｗｅｂ被代理入力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhkndrtdkkbn ztrseihowebhhkndrtdkkbn}</td><td>（取込用）生保Ｗｅｂ被代理続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhkndrknnm ztrseihowebhhkndrknnm}</td><td>（取込用）生保Ｗｅｂ被代理カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhkndrkjnm ztrseihowebhhkndrkjnm}</td><td>（取込用）生保Ｗｅｂ被代理漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhkndrseiymdc ztrseihowebhhkndrseiymdc}</td><td>（取込用）生保Ｗｅｂ被代理生年月日Ｃ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdaihituarihyj ztrseihowebdaihituarihyj}</td><td>（取込用）生保Ｗｅｂ代筆有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkoureisyakakkbn1 ztrseihowebkoureisyakakkbn1}</td><td>（取込用）生保Ｗｅｂ高齢者確認区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkoureisyakakkbn2 ztrseihowebkoureisyakakkbn2}</td><td>（取込用）生保Ｗｅｂ高齢者確認区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkoureisyakakkbn3 ztrseihowebkoureisyakakkbn3}</td><td>（取込用）生保Ｗｅｂ高齢者確認区分３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebptuutihyj ztrseihowebptuutihyj}</td><td>（取込用）生保Ｗｅｂ保険料通知有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtryobiv1546 ztryobiv1546}</td><td>（取込用）予備項目Ｖ１５４６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_HanyouPaperlessMos1Tr
 * @see     PKZT_HanyouPaperlessMos1Tr
 * @see     QZT_HanyouPaperlessMos1Tr
 * @see     GenQZT_HanyouPaperlessMos1Tr
 */
@MappedSuperclass
@Table(name=GenZT_HanyouPaperlessMos1Tr.TABLE_NAME)
@IdClass(value=PKZT_HanyouPaperlessMos1Tr.class)
public abstract class GenZT_HanyouPaperlessMos1Tr extends AbstractExDBEntity<ZT_HanyouPaperlessMos1Tr, PKZT_HanyouPaperlessMos1Tr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_HanyouPaperlessMos1Tr";
    public static final String ZTRSEIHOWEBIDKBN         = "ztrseihowebidkbn";
    public static final String ZTRSEIHOWEBKOJINCD       = "ztrseihowebkojincd";
    public static final String ZTRSEIHOWEBITIJIHOZONHYOUJI = "ztrseihowebitijihozonhyouji";
    public static final String ZTRSEIHOWEBSEKNOC        = "ztrseihowebseknoc";
    public static final String ZTRSEIHOWEBCALCKIJYUNYMDC = "ztrseihowebcalckijyunymdc";
    public static final String ZTRSEIHOWEBHHKNKNNM      = "ztrseihowebhhknknnm";
    public static final String ZTRSEIHOWEBHHKNSEIYMDC   = "ztrseihowebhhknseiymdc";
    public static final String ZTRSEIHOWEBHHKNSEIKBN    = "ztrseihowebhhknseikbn";
    public static final String ZTRSEIHOWEBKYKKNNM       = "ztrseihowebkykknnm";
    public static final String ZTRSEIHOWEBKYKSYASEIYMDC = "ztrseihowebkyksyaseiymdc";
    public static final String ZTRSEIHOWEBKYKSYASEIKBN  = "ztrseihowebkyksyaseikbn";
    public static final String ZTRSEIHOWEBHKNSYURUINOC  = "ztrseihowebhknsyuruinoc";
    public static final String ZTRSEIHOWEBHKNKKNC       = "ztrseihowebhknkknc";
    public static final String ZTRSEIHOWEBPHRKKIKNC     = "ztrseihowebphrkkiknc";
    public static final String ZTRSEIHOWEBHRKKAISUUKBN  = "ztrseihowebhrkkaisuukbn";
    public static final String ZTRSEIHOWEBSDPDKBN       = "ztrseihowebsdpdkbn";
    public static final String ZTRSEIHOWEBKIHONSC       = "ztrseihowebkihonsc";
    public static final String ZTRSEIHOWEBNKSYURUIKBN   = "ztrseihowebnksyuruikbn";
    public static final String ZTRSEIHOWEBLNTKKBN       = "ztrseihoweblntkkbn";
    public static final String ZTRSEIHOWEBNKSHRARIHYJ   = "ztrseihowebnkshrarihyj";
    public static final String ZTRSEIHOWEBMOSNOC        = "ztrseihowebmosnoc";
    public static final String ZTRSEIHOWEBSEKYKKIGENYMDC = "ztrseihowebsekykkigenymdc";
    public static final String ZTRSEIHOWEBSKSJSITENCD   = "ztrseihowebsksjsitencd";
    public static final String ZTRSEIHOWEBFSTMOSSKSYMDC = "ztrseihowebfstmossksymdc";
    public static final String ZTRSEIHOWEBHNSYUKYKTDKKBN = "ztrseihowebhnsyukyktdkkbn";
    public static final String ZTRSEIHOWEBHJNKITIKBN    = "ztrseihowebhjnkitikbn";
    public static final String ZTRSEIHOWEBHJNKYKHYJ     = "ztrseihowebhjnkykhyj";
    public static final String ZTRSEIHOWEBTKSYKMCD1     = "ztrseihowebtksykmcd1";
    public static final String ZTRSEIHOWEBTKSYKMCD2     = "ztrseihowebtksykmcd2";
    public static final String ZTRSEIHOWEBTKSYKMCD3     = "ztrseihowebtksykmcd3";
    public static final String ZTRSEIHOWEBTKSYKMCD4     = "ztrseihowebtksykmcd4";
    public static final String ZTRSEIHOWEBTKSYKMCD5     = "ztrseihowebtksykmcd5";
    public static final String ZTRSEIHOWEBTEIWKKNC      = "ztrseihowebteiwkknc";
    public static final String ZTRSEIHOWEBKNHJNNM       = "ztrseihowebknhjnnm";
    public static final String ZTRSEIHOWEBKJHJNNM       = "ztrseihowebkjhjnnm";
    public static final String ZTRSEIHOWEBKNDAIHYOUNM   = "ztrseihowebkndaihyounm";
    public static final String ZTRSEIHOWEBKJDAIHYOUNM   = "ztrseihowebkjdaihyounm";
    public static final String ZTRSEIHOWEBDAIHYOUKTGKKBN = "ztrseihowebdaihyouktgkkbn";
    public static final String ZTRSEIHOWEBSYKIHRKP1C    = "ztrseihowebsykihrkp1c";
    public static final String ZTRSEIHOWEBMOSP1C        = "ztrseihowebmosp1c";
    public static final String ZTRSEIHOWEBTKIYOUGYOUTAIKBN = "ztrseihowebtkiyougyoutaikbn";
    public static final String ZTRSEIHOWEBZENNOUKKNC    = "ztrseihowebzennoukknc";
    public static final String ZTRSEIHOWEBPAPERLESSMOSHYJ = "ztrseihowebpaperlessmoshyj";
    public static final String ZTRSEIHOWEBDATASOUSINZMHYJ = "ztrseihowebdatasousinzmhyj";
    public static final String ZTRSEIHOWEBKKNMSKHJNKITIKBN = "ztrseihowebkknmskhjnkitikbn";
    public static final String ZTRSEIHOWEBKYKOTTMSK     = "ztrseihowebkykottmsk";
    public static final String ZTRSEIHOWEBHHKNSYKGYCD   = "ztrseihowebhhknsykgycd";
    public static final String ZTRSEIHOWEBHKNMSKHJNKITIKBN = "ztrseihowebhknmskhjnkitikbn";
    public static final String ZTRSEIHOWEBHHKNOTTMSK    = "ztrseihowebhhknottmsk";
    public static final String ZTRSEIHOWEBHHKNNENSYUUKBN = "ztrseihowebhhknnensyuukbn";
    public static final String ZTRSEIHOWEBSBUKTHKSUNINZUUC = "ztrseihowebsbukthksuninzuuc";
    public static final String ZTRSEIHOWEBSBUKTBNWARI1C = "ztrseihowebsbuktbnwari1c";
    public static final String ZTRSEIHOWEBSBUKTTDKKBN2  = "ztrseihowebsbukttdkkbn2";
    public static final String ZTRSEIHOWEBSBUKTKNNM2    = "ztrseihowebsbuktknnm2";
    public static final String ZTRSEIHOWEBSBUKTKJNM2    = "ztrseihowebsbuktkjnm2";
    public static final String ZTRSEIHOWEBSBUKTSEIYMD2C = "ztrseihowebsbuktseiymd2c";
    public static final String ZTRSEIHOWEBSBUKTBNWARI2C = "ztrseihowebsbuktbnwari2c";
    public static final String ZTRSEIHOWEBSBUKTTDKKBN3  = "ztrseihowebsbukttdkkbn3";
    public static final String ZTRSEIHOWEBSBUKTKNNM3    = "ztrseihowebsbuktknnm3";
    public static final String ZTRSEIHOWEBSBUKTKJNM3    = "ztrseihowebsbuktkjnm3";
    public static final String ZTRSEIHOWEBSBUKTSEIYMD3C = "ztrseihowebsbuktseiymd3c";
    public static final String ZTRSEIHOWEBSBUKTBNWARI3C = "ztrseihowebsbuktbnwari3c";
    public static final String ZTRSEIHOWEBSBUKTTDKKBN4  = "ztrseihowebsbukttdkkbn4";
    public static final String ZTRSEIHOWEBSBUKTKNNM4    = "ztrseihowebsbuktknnm4";
    public static final String ZTRSEIHOWEBSBUKTKJNM4    = "ztrseihowebsbuktkjnm4";
    public static final String ZTRSEIHOWEBSBUKTSEIYMD4C = "ztrseihowebsbuktseiymd4c";
    public static final String ZTRSEIHOWEBSBUKTBNWARI4C = "ztrseihowebsbuktbnwari4c";
    public static final String ZTRSEIHOWEBNKUKTMRHHYJ   = "ztrseihowebnkuktmrhhyj";
    public static final String ZTRSEIHOWEBSBNKKKNC      = "ztrseihowebsbnkkknc";
    public static final String ZTRSEIHOWEBIKOKAKKJARIHYJ = "ztrseihowebikokakkjarihyj";
    public static final String ZTRSEIHOWEBFATCASNSIARIHYJ = "ztrseihowebfatcasnsiarihyj";
    public static final String ZTRSEIHOWEBKOUHURISITENCD = "ztrseihowebkouhurisitencd";
    public static final String ZTRSEIHOWEBKOUHURIYOKINKBN = "ztrseihowebkouhuriyokinkbn";
    public static final String ZTRSEIHOWEBKOUHURIKOUZANO = "ztrseihowebkouhurikouzano";
    public static final String ZTRSEIHOWEBKUHRSHMNTTDKHYJ = "ztrseihowebkuhrshmnttdkhyj";
    public static final String ZTRSEIHOWEBMOSYMDC       = "ztrseihowebmosymdc";
    public static final String ZTRSEIHOWEBSYOKUGYOUKKTYMDC = "ztrseihowebsyokugyoukktymdc";
    public static final String ZTRSEIHOWEBHHKNSINTYOUC  = "ztrseihowebhhknsintyouc";
    public static final String ZTRSEIHOWEBHHKNTAIJYUUC  = "ztrseihowebhhkntaijyuuc";
    public static final String ZTRSEIHOWEBKKTYMDC       = "ztrseihowebkktymdc";
    public static final String ZTRSEIHOWEBHUKUSUUSTSKSKBN = "ztrseihowebhukusuustskskbn";
    public static final String ZTRSEIHOWEBHNNKAKSYORUIKBN = "ztrseihowebhnnkaksyoruikbn";
    public static final String ZTRSEIHOWEBHSKTKJIKOU    = "ztrseihowebhsktkjikou";
    public static final String ZTRSEIHOWEBSKSKAKSYORUIKBN = "ztrseihowebskskaksyoruikbn";
    public static final String ZTRSEIHOWEBSKSHSKTKJIKOU = "ztrseihowebskshsktkjikou";
    public static final String ZTRSEIHOWEBBIKKJNSSINFOARI = "ztrseihowebbikkjnssinfoari";
    public static final String ZTRSEIHOWEBPLBSYUTRKNO   = "ztrseihowebplbsyutrkno";
    public static final String ZTRSEIHOWEBPLBSYUKOUINCD = "ztrseihowebplbsyukouincd";
    public static final String ZTRSEIHOWEBNRKBSYUTRKNO  = "ztrseihowebnrkbsyutrkno";
    public static final String ZTRSEIHOWEBUKTKID        = "ztrseihowebuktkid";
    public static final String ZTRSEIHOWEBDATASOUSINYMDC = "ztrseihowebdatasousinymdc";
    public static final String ZTRSEIHOWEBDATASOUSINHMSC = "ztrseihowebdatasousinhmsc";
    public static final String ZTRSEIHOWEBMOSUKTKYMDC   = "ztrseihowebmosuktkymdc";
    public static final String ZTRSEIHOWEBHNNKAKHSKJK1  = "ztrseihowebhnnkakhskjk1";
    public static final String ZTRSEIHOWEBHNNKAKHSKJK2  = "ztrseihowebhnnkakhskjk2";
    public static final String ZTRSEIHOWEBHNNKAKHSKJK3  = "ztrseihowebhnnkakhskjk3";
    public static final String ZTRSEIHOWEBHNNKAKHSKJK4  = "ztrseihowebhnnkakhskjk4";
    public static final String ZTRSEIHOWEBHNNKAKHSKJK5  = "ztrseihowebhnnkakhskjk5";
    public static final String ZTRSEIHOWEBTORIHOUTKJK1  = "ztrseihowebtorihoutkjk1";
    public static final String ZTRSEIHOWEBTORIHOUTKJK2  = "ztrseihowebtorihoutkjk2";
    public static final String ZTRSEIHOWEBTORIHOUTKJK3  = "ztrseihowebtorihoutkjk3";
    public static final String ZTRSEIHOWEBTORIHOUTKJK4  = "ztrseihowebtorihoutkjk4";
    public static final String ZTRSEIHOWEBTORIHOUTKJK5  = "ztrseihowebtorihoutkjk5";
    public static final String ZTRSEIHOWEBDRTNSKNO      = "ztrseihowebdrtnskno";
    public static final String ZTRSEIHOWEBSBNKSYUKBN    = "ztrseihowebsbnksyukbn";
    public static final String ZTRSEIHOWEBAATKISYAKNYUUCD = "ztrseihowebaatkisyaknyuucd";
    public static final String ZTRSEIHOWEBKKTTTYKKNRHYJ = "ztrseihowebkktttykknrhyj";
    public static final String ZTRSEIHOWEBDTLKKTARIHYJ  = "ztrseihowebdtlkktarihyj";
    public static final String ZTRSEIHOWEBFATCASYORUIARI = "ztrseihowebfatcasyoruiari";
    public static final String ZTRSEIHOWEBKZHURIKAEBANKCD = "ztrseihowebkzhurikaebankcd";
    public static final String ZTRSEIHOWEBKZKAKIRAIKBN  = "ztrseihowebkzkakiraikbn";
    public static final String ZTRSEIHOWEBBMIERRORHYJ   = "ztrseihowebbmierrorhyj";
    public static final String ZTRSEIHOWEBKKTKMGITUARIHYJ = "ztrseihowebkktkmgituarihyj";
    public static final String ZTRSEIHOWEBSNSHUHUKBN    = "ztrseihowebsnshuhukbn";
    public static final String ZTRSEIHOWEBKEIHIDOUITUHYJ = "ztrseihowebkeihidouituhyj";
    public static final String ZTRSEIHOWEBAEOISNSIARIHYJ = "ztrseihowebaeoisnsiarihyj";
    public static final String ZTRSEIHOWEBSITEITUUKAKBN = "ztrseihowebsiteituukakbn";
    public static final String ZTRSEIHOWEBNYKNTUUKAKBN  = "ztrseihowebnykntuukakbn";
    public static final String ZTRSEIHOWEBTARGETTKARIHYJ = "ztrseihowebtargettkarihyj";
    public static final String ZTRSEIHOWEBTARGETTKKBN   = "ztrseihowebtargettkkbn";
    public static final String ZTRSEIHOWEBTARGETTKMKHTC = "ztrseihowebtargettkmkhtc";
    public static final String ZTRSEIHOWEBNYKNTUUKANYKNGKC = "ztrseihowebnykntuukanykngkc";
    public static final String ZTRSEIHOWEBNYKNTUKFSTHRKPC = "ztrseihowebnykntukfsthrkpc";
    public static final String ZTRSEIHOWEBNYKNTUKNEXTHRKPC = "ztrseihowebnykntuknexthrkpc";
    public static final String ZTRSEIHOWEBTARGETYENKNSNPC = "ztrseihowebtargetyenknsnpc";
    public static final String ZTRSEIHOWEBTARGETMKHGKC  = "ztrseihowebtargetmkhgkc";
    public static final String ZTRSEIHOWEBSAIMANKIHYJ   = "ztrseihowebsaimankihyj";
    public static final String ZTRSEIHOWEBRAYHYJ        = "ztrseihowebrayhyj";
    public static final String ZTRYOBIV156              = "ztryobiv156";
    public static final String ZTRSEIHOWEBPSYOUHYJ      = "ztrseihowebpsyouhyj";
    public static final String ZTRSEIHOWEBPLHHKNKJNM    = "ztrseihowebplhhknkjnm";
    public static final String ZTRYOBIV1                = "ztryobiv1";
    public static final String ZTRSEIHOWEBPLKYKKJNM     = "ztrseihowebplkykkjnm";
    public static final String ZTRSEIHOWEBPLHJKKTKBN    = "ztrseihowebplhjkktkbn";
    public static final String ZTRSEIHOWEBPLHRKKEIROKBN = "ztrseihowebplhrkkeirokbn";
    public static final String ZTRSEIHOWEBPLNKSHRARIHYJ = "ztrseihowebplnkshrarihyj";
    public static final String ZTRYOBIV2                = "ztryobiv2";
    public static final String ZTRSEIHOWEBPLMOSNOC      = "ztrseihowebplmosnoc";
    public static final String ZTRSEIHOWEBPLSBUKTNRKKBN = "ztrseihowebplsbuktnrkkbn";
    public static final String ZTRSEIHOWEBPLSBUKTTDKKBN = "ztrseihowebplsbukttdkkbn";
    public static final String ZTRSEIHOWEBPLSBUKTKNNM   = "ztrseihowebplsbuktknnm";
    public static final String ZTRSEIHOWEBPLSBUKTKJNM   = "ztrseihowebplsbuktkjnm";
    public static final String ZTRYOBIV3                = "ztryobiv3";
    public static final String ZTRSEIHOWEBPLSBUKTSEIYMDC = "ztrseihowebplsbuktseiymdc";
    public static final String ZTRSEIHOWEBPLTKSYKMCD1   = "ztrseihowebpltksykmcd1";
    public static final String ZTRSEIHOWEBPLTKSYKMCD2   = "ztrseihowebpltksykmcd2";
    public static final String ZTRSEIHOWEBPLTKSYKMCD3   = "ztrseihowebpltksykmcd3";
    public static final String ZTRSEIHOWEBPLTKSYKMCD4   = "ztrseihowebpltksykmcd4";
    public static final String ZTRSEIHOWEBPLTKSYKMCD5   = "ztrseihowebpltksykmcd5";
    public static final String ZTRSEIHOWEBPLKYKTELNO    = "ztrseihowebplkyktelno";
    public static final String ZTRSEIHOWEBPLHHKNTELNO   = "ztrseihowebplhhkntelno";
    public static final String ZTRYOBIV3X2              = "ztryobiv3x2";
    public static final String ZTRSEIHOWEBPLKIHONTIKUCD = "ztrseihowebplkihontikucd";
    public static final String ZTRSEIHOWEBPLTSINADRKAI  = "ztrseihowebpltsinadrkai";
    public static final String ZTRSEIHOWEBPLHIIKIHONTIKUCD = "ztrseihowebplhiikihontikucd";
    public static final String ZTRSEIHOWEBPLHHKNADR     = "ztrseihowebplhhknadr";
    public static final String ZTRSEIHOWEBGNYKNTUKNYKNGKC = "ztrseihowebgnykntuknykngkc";
    public static final String ZTRSEIHOWEBGNYKNTUKFSTHRKPC = "ztrseihowebgnykntukfsthrkpc";
    public static final String ZTRSEIHOWEBGNYKNTUKNXTHRKPC = "ztrseihowebgnykntuknxthrkpc";
    public static final String ZTRSEIHOWEBGAIKAKIHONPC  = "ztrseihowebgaikakihonpc";
    public static final String ZTRSEIHOWEBKAIGMEHRTKARIHYJ = "ztrseihowebkaigmehrtkarihyj";
    public static final String ZTRSEIHOWEBYENHSYUTKARIHYJ = "ztrseihowebyenhsyutkarihyj";
    public static final String ZTRSEIHOWEBGAIKAKIHONSC  = "ztrseihowebgaikakihonsc";
    public static final String ZTRSEIHOWEBDAI1HKNKKNC   = "ztrseihowebdai1hknkknc";
    public static final String ZTRSEIHOWEBDSMOSHYJ      = "ztrseihowebdsmoshyj";
    public static final String ZTRSEIHOWEBDSMAILADDRESS = "ztrseihowebdsmailaddress";
    public static final String ZTRSEIHOWEBANKENKANRINO  = "ztrseihowebankenkanrino";
    public static final String ZTRSEIHOWEBKYDBOSYUUKJNCD = "ztrseihowebkydbosyuukjncd";
    public static final String ZTRSEIHOWEBHNYPPLTZMHYJ  = "ztrseihowebhnyppltzmhyj";
    public static final String ZTRSEIHOWEBSSRNDHBNWRC   = "ztrseihowebssrndhbnwrc";
    public static final String ZTRSEIHOWEBTRTRNDHBNWRC  = "ztrseihowebtrtrndhbnwrc";
    public static final String ZTRSEIHOWEBSUEOKIKKNC    = "ztrseihowebsueokikknc";
    public static final String ZTRSEIHOWEBMNKUKTNRKKBN  = "ztrseihowebmnkuktnrkkbn";
    public static final String ZTRSEIHOWEBMNKUKTTDKKBN  = "ztrseihowebmnkukttdkkbn";
    public static final String ZTRSEIHOWEBMNKUKTKNNM    = "ztrseihowebmnkuktknnm";
    public static final String ZTRSEIHOWEBMNKUKTKJNM    = "ztrseihowebmnkuktkjnm";
    public static final String ZTRSEIHOWEBMNKUKTSEIYMDC = "ztrseihowebmnkuktseiymdc";
    public static final String ZTRSEIHOWEBDSKNKZMEIGI   = "ztrseihowebdsknkzmeigi";
    public static final String ZTRSEIHOWEBDSKZSYURUIKBN = "ztrseihowebdskzsyuruikbn";
    public static final String ZTRSEIHOWEBDSKINYUUCD    = "ztrseihowebdskinyuucd";
    public static final String ZTRSEIHOWEBDSSITENCD     = "ztrseihowebdssitencd";
    public static final String ZTRSEIHOWEBDSYOKINKBN    = "ztrseihowebdsyokinkbn";
    public static final String ZTRSEIHOWEBDSKOUZANO     = "ztrseihowebdskouzano";
    public static final String ZTRSEIHOWEBDSANSYONO     = "ztrseihowebdsansyono";
    public static final String ZTRSEIHOWEBDSSYMNTTDKHYJ = "ztrseihowebdssymnttdkhyj";
    public static final String ZTRSEIHOWEBIKKATUPC      = "ztrseihowebikkatupc";
    public static final String ZTRSEIHOWEBIKKATUBARAIKBN = "ztrseihowebikkatubaraikbn";
    public static final String ZTRSEIHOWEBIKTBRIKAISUUC = "ztrseihowebiktbrikaisuuc";
    public static final String ZTRSEIHOWEBZENNOUPC      = "ztrseihowebzennoupc";
    public static final String ZTRSEIHOWEBGAIKAZENNOUPC = "ztrseihowebgaikazennoupc";
    public static final String ZTRSEIHOWEBZENNOUHYJ     = "ztrseihowebzennouhyj";
    public static final String ZTRSEIHOWEBYAKKANKBN     = "ztrseihowebyakkankbn";
    public static final String ZTRSEIHOWEBNETKHRZMHYJ   = "ztrseihowebnetkhrzmhyj";
    public static final String ZTRSEIHOWEBKZKTRKMOSKBN  = "ztrseihowebkzktrkmoskbn";
    public static final String ZTRSEIHOWEBKZKTDKKBN1    = "ztrseihowebkzktdkkbn1";
    public static final String ZTRSEIHOWEBKZKKNNM1      = "ztrseihowebkzkknnm1";
    public static final String ZTRSEIHOWEBKZKKJNM1      = "ztrseihowebkzkkjnm1";
    public static final String ZTRSEIHOWEBKZKSEIKBN1    = "ztrseihowebkzkseikbn1";
    public static final String ZTRSEIHOWEBKZKSEIYMD1C   = "ztrseihowebkzkseiymd1c";
    public static final String ZTRSEIHOWEBKZKKYKDOUKYOHYJ1 = "ztrseihowebkzkkykdoukyohyj1";
    public static final String ZTRSEIHOWEBKZKYNO1       = "ztrseihowebkzkyno1";
    public static final String ZTRSEIHOWEBKZKADR1       = "ztrseihowebkzkadr1";
    public static final String ZTRSEIHOWEBKZKTELNO1     = "ztrseihowebkzktelno1";
    public static final String ZTRSEIHOWEBKYKDRTKKANOUHYJ = "ztrseihowebkykdrtkkanouhyj";
    public static final String ZTRSEIHOWEBHHKNDRTKKANOUHYJ = "ztrseihowebhhkndrtkkanouhyj";
    public static final String ZTRSEIHOWEBDRTKKBN       = "ztrseihowebdrtkkbn";
    public static final String ZTRSEIHOWEBKYKDRNRKKBN   = "ztrseihowebkykdrnrkkbn";
    public static final String ZTRSEIHOWEBHHKNDRNRKKBN  = "ztrseihowebhhkndrnrkkbn";
    public static final String ZTRSEIHOWEBHHKNDRTDKKBN  = "ztrseihowebhhkndrtdkkbn";
    public static final String ZTRSEIHOWEBHHKNDRKNNM    = "ztrseihowebhhkndrknnm";
    public static final String ZTRSEIHOWEBHHKNDRKJNM    = "ztrseihowebhhkndrkjnm";
    public static final String ZTRSEIHOWEBHHKNDRSEIYMDC = "ztrseihowebhhkndrseiymdc";
    public static final String ZTRSEIHOWEBDAIHITUARIHYJ = "ztrseihowebdaihituarihyj";
    public static final String ZTRSEIHOWEBKOUREISYAKAKKBN1 = "ztrseihowebkoureisyakakkbn1";
    public static final String ZTRSEIHOWEBKOUREISYAKAKKBN2 = "ztrseihowebkoureisyakakkbn2";
    public static final String ZTRSEIHOWEBKOUREISYAKAKKBN3 = "ztrseihowebkoureisyakakkbn3";
    public static final String ZTRSEIHOWEBPTUUTIHYJ     = "ztrseihowebptuutihyj";
    public static final String ZTRYOBIV1546             = "ztryobiv1546";

    private final PKZT_HanyouPaperlessMos1Tr primaryKey;

    public GenZT_HanyouPaperlessMos1Tr() {
        primaryKey = new PKZT_HanyouPaperlessMos1Tr();
    }

    public GenZT_HanyouPaperlessMos1Tr(
        String pZtrseihowebidkbn,
        String pZtrseihowebkojincd,
        String pZtrseihowebitijihozonhyouji,
        Integer pZtrseihowebseknoc
    ) {
        primaryKey = new PKZT_HanyouPaperlessMos1Tr(
            pZtrseihowebidkbn,
            pZtrseihowebkojincd,
            pZtrseihowebitijihozonhyouji,
            pZtrseihowebseknoc
        );
    }

    @Transient
    @Override
    public PKZT_HanyouPaperlessMos1Tr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_HanyouPaperlessMos1Tr> getMetaClass() {
        return QZT_HanyouPaperlessMos1Tr.class;
    }

    @Id
    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBIDKBN)
    public String getZtrseihowebidkbn() {
        return getPrimaryKey().getZtrseihowebidkbn();
    }

    public void setZtrseihowebidkbn(String pZtrseihowebidkbn) {
        getPrimaryKey().setZtrseihowebidkbn(pZtrseihowebidkbn);
    }

    @Id
    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKOJINCD)
    public String getZtrseihowebkojincd() {
        return getPrimaryKey().getZtrseihowebkojincd();
    }

    public void setZtrseihowebkojincd(String pZtrseihowebkojincd) {
        getPrimaryKey().setZtrseihowebkojincd(pZtrseihowebkojincd);
    }

    @Id
    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBITIJIHOZONHYOUJI)
    public String getZtrseihowebitijihozonhyouji() {
        return getPrimaryKey().getZtrseihowebitijihozonhyouji();
    }

    public void setZtrseihowebitijihozonhyouji(String pZtrseihowebitijihozonhyouji) {
        getPrimaryKey().setZtrseihowebitijihozonhyouji(pZtrseihowebitijihozonhyouji);
    }

    @Id
    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSEKNOC)
    public Integer getZtrseihowebseknoc() {
        return getPrimaryKey().getZtrseihowebseknoc();
    }

    public void setZtrseihowebseknoc(Integer pZtrseihowebseknoc) {
        getPrimaryKey().setZtrseihowebseknoc(pZtrseihowebseknoc);
    }

    private String ztrseihowebcalckijyunymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBCALCKIJYUNYMDC)
    public String getZtrseihowebcalckijyunymdc() {
        return ztrseihowebcalckijyunymdc;
    }

    public void setZtrseihowebcalckijyunymdc(String pZtrseihowebcalckijyunymdc) {
        ztrseihowebcalckijyunymdc = pZtrseihowebcalckijyunymdc;
    }

    private String ztrseihowebhhknknnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNKNNM)
    public String getZtrseihowebhhknknnm() {
        return ztrseihowebhhknknnm;
    }

    public void setZtrseihowebhhknknnm(String pZtrseihowebhhknknnm) {
        ztrseihowebhhknknnm = pZtrseihowebhhknknnm;
    }

    private String ztrseihowebhhknseiymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNSEIYMDC)
    public String getZtrseihowebhhknseiymdc() {
        return ztrseihowebhhknseiymdc;
    }

    public void setZtrseihowebhhknseiymdc(String pZtrseihowebhhknseiymdc) {
        ztrseihowebhhknseiymdc = pZtrseihowebhhknseiymdc;
    }

    private String ztrseihowebhhknseikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNSEIKBN)
    public String getZtrseihowebhhknseikbn() {
        return ztrseihowebhhknseikbn;
    }

    public void setZtrseihowebhhknseikbn(String pZtrseihowebhhknseikbn) {
        ztrseihowebhhknseikbn = pZtrseihowebhhknseikbn;
    }

    private String ztrseihowebkykknnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKYKKNNM)
    public String getZtrseihowebkykknnm() {
        return ztrseihowebkykknnm;
    }

    public void setZtrseihowebkykknnm(String pZtrseihowebkykknnm) {
        ztrseihowebkykknnm = pZtrseihowebkykknnm;
    }

    private String ztrseihowebkyksyaseiymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKYKSYASEIYMDC)
    public String getZtrseihowebkyksyaseiymdc() {
        return ztrseihowebkyksyaseiymdc;
    }

    public void setZtrseihowebkyksyaseiymdc(String pZtrseihowebkyksyaseiymdc) {
        ztrseihowebkyksyaseiymdc = pZtrseihowebkyksyaseiymdc;
    }

    private String ztrseihowebkyksyaseikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKYKSYASEIKBN)
    public String getZtrseihowebkyksyaseikbn() {
        return ztrseihowebkyksyaseikbn;
    }

    public void setZtrseihowebkyksyaseikbn(String pZtrseihowebkyksyaseikbn) {
        ztrseihowebkyksyaseikbn = pZtrseihowebkyksyaseikbn;
    }

    private String ztrseihowebhknsyuruinoc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHKNSYURUINOC)
    public String getZtrseihowebhknsyuruinoc() {
        return ztrseihowebhknsyuruinoc;
    }

    public void setZtrseihowebhknsyuruinoc(String pZtrseihowebhknsyuruinoc) {
        ztrseihowebhknsyuruinoc = pZtrseihowebhknsyuruinoc;
    }

    private Integer ztrseihowebhknkknc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHKNKKNC)
    public Integer getZtrseihowebhknkknc() {
        return ztrseihowebhknkknc;
    }

    public void setZtrseihowebhknkknc(Integer pZtrseihowebhknkknc) {
        ztrseihowebhknkknc = pZtrseihowebhknkknc;
    }

    private Integer ztrseihowebphrkkiknc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPHRKKIKNC)
    public Integer getZtrseihowebphrkkiknc() {
        return ztrseihowebphrkkiknc;
    }

    public void setZtrseihowebphrkkiknc(Integer pZtrseihowebphrkkiknc) {
        ztrseihowebphrkkiknc = pZtrseihowebphrkkiknc;
    }

    private String ztrseihowebhrkkaisuukbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHRKKAISUUKBN)
    public String getZtrseihowebhrkkaisuukbn() {
        return ztrseihowebhrkkaisuukbn;
    }

    public void setZtrseihowebhrkkaisuukbn(String pZtrseihowebhrkkaisuukbn) {
        ztrseihowebhrkkaisuukbn = pZtrseihowebhrkkaisuukbn;
    }

    private String ztrseihowebsdpdkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSDPDKBN)
    public String getZtrseihowebsdpdkbn() {
        return ztrseihowebsdpdkbn;
    }

    public void setZtrseihowebsdpdkbn(String pZtrseihowebsdpdkbn) {
        ztrseihowebsdpdkbn = pZtrseihowebsdpdkbn;
    }

    private Long ztrseihowebkihonsc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKIHONSC)
    public Long getZtrseihowebkihonsc() {
        return ztrseihowebkihonsc;
    }

    public void setZtrseihowebkihonsc(Long pZtrseihowebkihonsc) {
        ztrseihowebkihonsc = pZtrseihowebkihonsc;
    }

    private String ztrseihowebnksyuruikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBNKSYURUIKBN)
    public String getZtrseihowebnksyuruikbn() {
        return ztrseihowebnksyuruikbn;
    }

    public void setZtrseihowebnksyuruikbn(String pZtrseihowebnksyuruikbn) {
        ztrseihowebnksyuruikbn = pZtrseihowebnksyuruikbn;
    }

    private String ztrseihoweblntkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBLNTKKBN)
    public String getZtrseihoweblntkkbn() {
        return ztrseihoweblntkkbn;
    }

    public void setZtrseihoweblntkkbn(String pZtrseihoweblntkkbn) {
        ztrseihoweblntkkbn = pZtrseihoweblntkkbn;
    }

    private String ztrseihowebnkshrarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBNKSHRARIHYJ)
    public String getZtrseihowebnkshrarihyj() {
        return ztrseihowebnkshrarihyj;
    }

    public void setZtrseihowebnkshrarihyj(String pZtrseihowebnkshrarihyj) {
        ztrseihowebnkshrarihyj = pZtrseihowebnkshrarihyj;
    }

    private String ztrseihowebmosnoc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBMOSNOC)
    public String getZtrseihowebmosnoc() {
        return ztrseihowebmosnoc;
    }

    public void setZtrseihowebmosnoc(String pZtrseihowebmosnoc) {
        ztrseihowebmosnoc = pZtrseihowebmosnoc;
    }

    private String ztrseihowebsekykkigenymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSEKYKKIGENYMDC)
    public String getZtrseihowebsekykkigenymdc() {
        return ztrseihowebsekykkigenymdc;
    }

    public void setZtrseihowebsekykkigenymdc(String pZtrseihowebsekykkigenymdc) {
        ztrseihowebsekykkigenymdc = pZtrseihowebsekykkigenymdc;
    }

    private String ztrseihowebsksjsitencd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSKSJSITENCD)
    public String getZtrseihowebsksjsitencd() {
        return ztrseihowebsksjsitencd;
    }

    public void setZtrseihowebsksjsitencd(String pZtrseihowebsksjsitencd) {
        ztrseihowebsksjsitencd = pZtrseihowebsksjsitencd;
    }

    private String ztrseihowebfstmossksymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBFSTMOSSKSYMDC)
    public String getZtrseihowebfstmossksymdc() {
        return ztrseihowebfstmossksymdc;
    }

    public void setZtrseihowebfstmossksymdc(String pZtrseihowebfstmossksymdc) {
        ztrseihowebfstmossksymdc = pZtrseihowebfstmossksymdc;
    }

    private String ztrseihowebhnsyukyktdkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHNSYUKYKTDKKBN)
    public String getZtrseihowebhnsyukyktdkkbn() {
        return ztrseihowebhnsyukyktdkkbn;
    }

    public void setZtrseihowebhnsyukyktdkkbn(String pZtrseihowebhnsyukyktdkkbn) {
        ztrseihowebhnsyukyktdkkbn = pZtrseihowebhnsyukyktdkkbn;
    }

    private String ztrseihowebhjnkitikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHJNKITIKBN)
    public String getZtrseihowebhjnkitikbn() {
        return ztrseihowebhjnkitikbn;
    }

    public void setZtrseihowebhjnkitikbn(String pZtrseihowebhjnkitikbn) {
        ztrseihowebhjnkitikbn = pZtrseihowebhjnkitikbn;
    }

    private String ztrseihowebhjnkykhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHJNKYKHYJ)
    public String getZtrseihowebhjnkykhyj() {
        return ztrseihowebhjnkykhyj;
    }

    public void setZtrseihowebhjnkykhyj(String pZtrseihowebhjnkykhyj) {
        ztrseihowebhjnkykhyj = pZtrseihowebhjnkykhyj;
    }

    private String ztrseihowebtksykmcd1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTKSYKMCD1)
    public String getZtrseihowebtksykmcd1() {
        return ztrseihowebtksykmcd1;
    }

    public void setZtrseihowebtksykmcd1(String pZtrseihowebtksykmcd1) {
        ztrseihowebtksykmcd1 = pZtrseihowebtksykmcd1;
    }

    private String ztrseihowebtksykmcd2;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTKSYKMCD2)
    public String getZtrseihowebtksykmcd2() {
        return ztrseihowebtksykmcd2;
    }

    public void setZtrseihowebtksykmcd2(String pZtrseihowebtksykmcd2) {
        ztrseihowebtksykmcd2 = pZtrseihowebtksykmcd2;
    }

    private String ztrseihowebtksykmcd3;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTKSYKMCD3)
    public String getZtrseihowebtksykmcd3() {
        return ztrseihowebtksykmcd3;
    }

    public void setZtrseihowebtksykmcd3(String pZtrseihowebtksykmcd3) {
        ztrseihowebtksykmcd3 = pZtrseihowebtksykmcd3;
    }

    private String ztrseihowebtksykmcd4;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTKSYKMCD4)
    public String getZtrseihowebtksykmcd4() {
        return ztrseihowebtksykmcd4;
    }

    public void setZtrseihowebtksykmcd4(String pZtrseihowebtksykmcd4) {
        ztrseihowebtksykmcd4 = pZtrseihowebtksykmcd4;
    }

    private String ztrseihowebtksykmcd5;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTKSYKMCD5)
    public String getZtrseihowebtksykmcd5() {
        return ztrseihowebtksykmcd5;
    }

    public void setZtrseihowebtksykmcd5(String pZtrseihowebtksykmcd5) {
        ztrseihowebtksykmcd5 = pZtrseihowebtksykmcd5;
    }

    private Long ztrseihowebteiwkknc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTEIWKKNC)
    public Long getZtrseihowebteiwkknc() {
        return ztrseihowebteiwkknc;
    }

    public void setZtrseihowebteiwkknc(Long pZtrseihowebteiwkknc) {
        ztrseihowebteiwkknc = pZtrseihowebteiwkknc;
    }

    private String ztrseihowebknhjnnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKNHJNNM)
    public String getZtrseihowebknhjnnm() {
        return ztrseihowebknhjnnm;
    }

    public void setZtrseihowebknhjnnm(String pZtrseihowebknhjnnm) {
        ztrseihowebknhjnnm = pZtrseihowebknhjnnm;
    }

    private String ztrseihowebkjhjnnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKJHJNNM)
    public String getZtrseihowebkjhjnnm() {
        return ztrseihowebkjhjnnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkjhjnnm(String pZtrseihowebkjhjnnm) {
        ztrseihowebkjhjnnm = pZtrseihowebkjhjnnm;
    }

    private String ztrseihowebkndaihyounm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKNDAIHYOUNM)
    public String getZtrseihowebkndaihyounm() {
        return ztrseihowebkndaihyounm;
    }

    public void setZtrseihowebkndaihyounm(String pZtrseihowebkndaihyounm) {
        ztrseihowebkndaihyounm = pZtrseihowebkndaihyounm;
    }

    private String ztrseihowebkjdaihyounm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKJDAIHYOUNM)
    public String getZtrseihowebkjdaihyounm() {
        return ztrseihowebkjdaihyounm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkjdaihyounm(String pZtrseihowebkjdaihyounm) {
        ztrseihowebkjdaihyounm = pZtrseihowebkjdaihyounm;
    }

    private String ztrseihowebdaihyouktgkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDAIHYOUKTGKKBN)
    public String getZtrseihowebdaihyouktgkkbn() {
        return ztrseihowebdaihyouktgkkbn;
    }

    public void setZtrseihowebdaihyouktgkkbn(String pZtrseihowebdaihyouktgkkbn) {
        ztrseihowebdaihyouktgkkbn = pZtrseihowebdaihyouktgkkbn;
    }

    private Long ztrseihowebsykihrkp1c;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSYKIHRKP1C)
    public Long getZtrseihowebsykihrkp1c() {
        return ztrseihowebsykihrkp1c;
    }

    public void setZtrseihowebsykihrkp1c(Long pZtrseihowebsykihrkp1c) {
        ztrseihowebsykihrkp1c = pZtrseihowebsykihrkp1c;
    }

    private Long ztrseihowebmosp1c;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBMOSP1C)
    public Long getZtrseihowebmosp1c() {
        return ztrseihowebmosp1c;
    }

    public void setZtrseihowebmosp1c(Long pZtrseihowebmosp1c) {
        ztrseihowebmosp1c = pZtrseihowebmosp1c;
    }

    private String ztrseihowebtkiyougyoutaikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTKIYOUGYOUTAIKBN)
    public String getZtrseihowebtkiyougyoutaikbn() {
        return ztrseihowebtkiyougyoutaikbn;
    }

    public void setZtrseihowebtkiyougyoutaikbn(String pZtrseihowebtkiyougyoutaikbn) {
        ztrseihowebtkiyougyoutaikbn = pZtrseihowebtkiyougyoutaikbn;
    }

    private Integer ztrseihowebzennoukknc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBZENNOUKKNC)
    public Integer getZtrseihowebzennoukknc() {
        return ztrseihowebzennoukknc;
    }

    public void setZtrseihowebzennoukknc(Integer pZtrseihowebzennoukknc) {
        ztrseihowebzennoukknc = pZtrseihowebzennoukknc;
    }

    private String ztrseihowebpaperlessmoshyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPAPERLESSMOSHYJ)
    public String getZtrseihowebpaperlessmoshyj() {
        return ztrseihowebpaperlessmoshyj;
    }

    public void setZtrseihowebpaperlessmoshyj(String pZtrseihowebpaperlessmoshyj) {
        ztrseihowebpaperlessmoshyj = pZtrseihowebpaperlessmoshyj;
    }

    private String ztrseihowebdatasousinzmhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDATASOUSINZMHYJ)
    public String getZtrseihowebdatasousinzmhyj() {
        return ztrseihowebdatasousinzmhyj;
    }

    public void setZtrseihowebdatasousinzmhyj(String pZtrseihowebdatasousinzmhyj) {
        ztrseihowebdatasousinzmhyj = pZtrseihowebdatasousinzmhyj;
    }

    private String ztrseihowebkknmskhjnkitikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKKNMSKHJNKITIKBN)
    public String getZtrseihowebkknmskhjnkitikbn() {
        return ztrseihowebkknmskhjnkitikbn;
    }

    public void setZtrseihowebkknmskhjnkitikbn(String pZtrseihowebkknmskhjnkitikbn) {
        ztrseihowebkknmskhjnkitikbn = pZtrseihowebkknmskhjnkitikbn;
    }

    private String ztrseihowebkykottmsk;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKYKOTTMSK)
    public String getZtrseihowebkykottmsk() {
        return ztrseihowebkykottmsk;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkykottmsk(String pZtrseihowebkykottmsk) {
        ztrseihowebkykottmsk = pZtrseihowebkykottmsk;
    }

    private String ztrseihowebhhknsykgycd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNSYKGYCD)
    public String getZtrseihowebhhknsykgycd() {
        return ztrseihowebhhknsykgycd;
    }

    public void setZtrseihowebhhknsykgycd(String pZtrseihowebhhknsykgycd) {
        ztrseihowebhhknsykgycd = pZtrseihowebhhknsykgycd;
    }

    private String ztrseihowebhknmskhjnkitikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHKNMSKHJNKITIKBN)
    public String getZtrseihowebhknmskhjnkitikbn() {
        return ztrseihowebhknmskhjnkitikbn;
    }

    public void setZtrseihowebhknmskhjnkitikbn(String pZtrseihowebhknmskhjnkitikbn) {
        ztrseihowebhknmskhjnkitikbn = pZtrseihowebhknmskhjnkitikbn;
    }

    private String ztrseihowebhhknottmsk;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNOTTMSK)
    public String getZtrseihowebhhknottmsk() {
        return ztrseihowebhhknottmsk;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhhknottmsk(String pZtrseihowebhhknottmsk) {
        ztrseihowebhhknottmsk = pZtrseihowebhhknottmsk;
    }

    private String ztrseihowebhhknnensyuukbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNNENSYUUKBN)
    public String getZtrseihowebhhknnensyuukbn() {
        return ztrseihowebhhknnensyuukbn;
    }

    public void setZtrseihowebhhknnensyuukbn(String pZtrseihowebhhknnensyuukbn) {
        ztrseihowebhhknnensyuukbn = pZtrseihowebhhknnensyuukbn;
    }

    private Integer ztrseihowebsbukthksuninzuuc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTHKSUNINZUUC)
    public Integer getZtrseihowebsbukthksuninzuuc() {
        return ztrseihowebsbukthksuninzuuc;
    }

    public void setZtrseihowebsbukthksuninzuuc(Integer pZtrseihowebsbukthksuninzuuc) {
        ztrseihowebsbukthksuninzuuc = pZtrseihowebsbukthksuninzuuc;
    }

    private Integer ztrseihowebsbuktbnwari1c;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTBNWARI1C)
    public Integer getZtrseihowebsbuktbnwari1c() {
        return ztrseihowebsbuktbnwari1c;
    }

    public void setZtrseihowebsbuktbnwari1c(Integer pZtrseihowebsbuktbnwari1c) {
        ztrseihowebsbuktbnwari1c = pZtrseihowebsbuktbnwari1c;
    }

    private String ztrseihowebsbukttdkkbn2;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTTDKKBN2)
    public String getZtrseihowebsbukttdkkbn2() {
        return ztrseihowebsbukttdkkbn2;
    }

    public void setZtrseihowebsbukttdkkbn2(String pZtrseihowebsbukttdkkbn2) {
        ztrseihowebsbukttdkkbn2 = pZtrseihowebsbukttdkkbn2;
    }

    private String ztrseihowebsbuktknnm2;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTKNNM2)
    public String getZtrseihowebsbuktknnm2() {
        return ztrseihowebsbuktknnm2;
    }

    public void setZtrseihowebsbuktknnm2(String pZtrseihowebsbuktknnm2) {
        ztrseihowebsbuktknnm2 = pZtrseihowebsbuktknnm2;
    }

    private String ztrseihowebsbuktkjnm2;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTKJNM2)
    public String getZtrseihowebsbuktkjnm2() {
        return ztrseihowebsbuktkjnm2;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebsbuktkjnm2(String pZtrseihowebsbuktkjnm2) {
        ztrseihowebsbuktkjnm2 = pZtrseihowebsbuktkjnm2;
    }

    private String ztrseihowebsbuktseiymd2c;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTSEIYMD2C)
    public String getZtrseihowebsbuktseiymd2c() {
        return ztrseihowebsbuktseiymd2c;
    }

    public void setZtrseihowebsbuktseiymd2c(String pZtrseihowebsbuktseiymd2c) {
        ztrseihowebsbuktseiymd2c = pZtrseihowebsbuktseiymd2c;
    }

    private Integer ztrseihowebsbuktbnwari2c;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTBNWARI2C)
    public Integer getZtrseihowebsbuktbnwari2c() {
        return ztrseihowebsbuktbnwari2c;
    }

    public void setZtrseihowebsbuktbnwari2c(Integer pZtrseihowebsbuktbnwari2c) {
        ztrseihowebsbuktbnwari2c = pZtrseihowebsbuktbnwari2c;
    }

    private String ztrseihowebsbukttdkkbn3;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTTDKKBN3)
    public String getZtrseihowebsbukttdkkbn3() {
        return ztrseihowebsbukttdkkbn3;
    }

    public void setZtrseihowebsbukttdkkbn3(String pZtrseihowebsbukttdkkbn3) {
        ztrseihowebsbukttdkkbn3 = pZtrseihowebsbukttdkkbn3;
    }

    private String ztrseihowebsbuktknnm3;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTKNNM3)
    public String getZtrseihowebsbuktknnm3() {
        return ztrseihowebsbuktknnm3;
    }

    public void setZtrseihowebsbuktknnm3(String pZtrseihowebsbuktknnm3) {
        ztrseihowebsbuktknnm3 = pZtrseihowebsbuktknnm3;
    }

    private String ztrseihowebsbuktkjnm3;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTKJNM3)
    public String getZtrseihowebsbuktkjnm3() {
        return ztrseihowebsbuktkjnm3;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebsbuktkjnm3(String pZtrseihowebsbuktkjnm3) {
        ztrseihowebsbuktkjnm3 = pZtrseihowebsbuktkjnm3;
    }

    private String ztrseihowebsbuktseiymd3c;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTSEIYMD3C)
    public String getZtrseihowebsbuktseiymd3c() {
        return ztrseihowebsbuktseiymd3c;
    }

    public void setZtrseihowebsbuktseiymd3c(String pZtrseihowebsbuktseiymd3c) {
        ztrseihowebsbuktseiymd3c = pZtrseihowebsbuktseiymd3c;
    }

    private Integer ztrseihowebsbuktbnwari3c;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTBNWARI3C)
    public Integer getZtrseihowebsbuktbnwari3c() {
        return ztrseihowebsbuktbnwari3c;
    }

    public void setZtrseihowebsbuktbnwari3c(Integer pZtrseihowebsbuktbnwari3c) {
        ztrseihowebsbuktbnwari3c = pZtrseihowebsbuktbnwari3c;
    }

    private String ztrseihowebsbukttdkkbn4;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTTDKKBN4)
    public String getZtrseihowebsbukttdkkbn4() {
        return ztrseihowebsbukttdkkbn4;
    }

    public void setZtrseihowebsbukttdkkbn4(String pZtrseihowebsbukttdkkbn4) {
        ztrseihowebsbukttdkkbn4 = pZtrseihowebsbukttdkkbn4;
    }

    private String ztrseihowebsbuktknnm4;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTKNNM4)
    public String getZtrseihowebsbuktknnm4() {
        return ztrseihowebsbuktknnm4;
    }

    public void setZtrseihowebsbuktknnm4(String pZtrseihowebsbuktknnm4) {
        ztrseihowebsbuktknnm4 = pZtrseihowebsbuktknnm4;
    }

    private String ztrseihowebsbuktkjnm4;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTKJNM4)
    public String getZtrseihowebsbuktkjnm4() {
        return ztrseihowebsbuktkjnm4;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebsbuktkjnm4(String pZtrseihowebsbuktkjnm4) {
        ztrseihowebsbuktkjnm4 = pZtrseihowebsbuktkjnm4;
    }

    private String ztrseihowebsbuktseiymd4c;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTSEIYMD4C)
    public String getZtrseihowebsbuktseiymd4c() {
        return ztrseihowebsbuktseiymd4c;
    }

    public void setZtrseihowebsbuktseiymd4c(String pZtrseihowebsbuktseiymd4c) {
        ztrseihowebsbuktseiymd4c = pZtrseihowebsbuktseiymd4c;
    }

    private Integer ztrseihowebsbuktbnwari4c;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBUKTBNWARI4C)
    public Integer getZtrseihowebsbuktbnwari4c() {
        return ztrseihowebsbuktbnwari4c;
    }

    public void setZtrseihowebsbuktbnwari4c(Integer pZtrseihowebsbuktbnwari4c) {
        ztrseihowebsbuktbnwari4c = pZtrseihowebsbuktbnwari4c;
    }

    private String ztrseihowebnkuktmrhhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBNKUKTMRHHYJ)
    public String getZtrseihowebnkuktmrhhyj() {
        return ztrseihowebnkuktmrhhyj;
    }

    public void setZtrseihowebnkuktmrhhyj(String pZtrseihowebnkuktmrhhyj) {
        ztrseihowebnkuktmrhhyj = pZtrseihowebnkuktmrhhyj;
    }

    private Integer ztrseihowebsbnkkknc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBNKKKNC)
    public Integer getZtrseihowebsbnkkknc() {
        return ztrseihowebsbnkkknc;
    }

    public void setZtrseihowebsbnkkknc(Integer pZtrseihowebsbnkkknc) {
        ztrseihowebsbnkkknc = pZtrseihowebsbnkkknc;
    }

    private String ztrseihowebikokakkjarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBIKOKAKKJARIHYJ)
    public String getZtrseihowebikokakkjarihyj() {
        return ztrseihowebikokakkjarihyj;
    }

    public void setZtrseihowebikokakkjarihyj(String pZtrseihowebikokakkjarihyj) {
        ztrseihowebikokakkjarihyj = pZtrseihowebikokakkjarihyj;
    }

    private String ztrseihowebfatcasnsiarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBFATCASNSIARIHYJ)
    public String getZtrseihowebfatcasnsiarihyj() {
        return ztrseihowebfatcasnsiarihyj;
    }

    public void setZtrseihowebfatcasnsiarihyj(String pZtrseihowebfatcasnsiarihyj) {
        ztrseihowebfatcasnsiarihyj = pZtrseihowebfatcasnsiarihyj;
    }

    private String ztrseihowebkouhurisitencd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKOUHURISITENCD)
    public String getZtrseihowebkouhurisitencd() {
        return ztrseihowebkouhurisitencd;
    }

    public void setZtrseihowebkouhurisitencd(String pZtrseihowebkouhurisitencd) {
        ztrseihowebkouhurisitencd = pZtrseihowebkouhurisitencd;
    }

    private String ztrseihowebkouhuriyokinkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKOUHURIYOKINKBN)
    public String getZtrseihowebkouhuriyokinkbn() {
        return ztrseihowebkouhuriyokinkbn;
    }

    public void setZtrseihowebkouhuriyokinkbn(String pZtrseihowebkouhuriyokinkbn) {
        ztrseihowebkouhuriyokinkbn = pZtrseihowebkouhuriyokinkbn;
    }

    private String ztrseihowebkouhurikouzano;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKOUHURIKOUZANO)
    public String getZtrseihowebkouhurikouzano() {
        return ztrseihowebkouhurikouzano;
    }

    public void setZtrseihowebkouhurikouzano(String pZtrseihowebkouhurikouzano) {
        ztrseihowebkouhurikouzano = pZtrseihowebkouhurikouzano;
    }

    private String ztrseihowebkuhrshmnttdkhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKUHRSHMNTTDKHYJ)
    public String getZtrseihowebkuhrshmnttdkhyj() {
        return ztrseihowebkuhrshmnttdkhyj;
    }

    public void setZtrseihowebkuhrshmnttdkhyj(String pZtrseihowebkuhrshmnttdkhyj) {
        ztrseihowebkuhrshmnttdkhyj = pZtrseihowebkuhrshmnttdkhyj;
    }

    private String ztrseihowebmosymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBMOSYMDC)
    public String getZtrseihowebmosymdc() {
        return ztrseihowebmosymdc;
    }

    public void setZtrseihowebmosymdc(String pZtrseihowebmosymdc) {
        ztrseihowebmosymdc = pZtrseihowebmosymdc;
    }

    private String ztrseihowebsyokugyoukktymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSYOKUGYOUKKTYMDC)
    public String getZtrseihowebsyokugyoukktymdc() {
        return ztrseihowebsyokugyoukktymdc;
    }

    public void setZtrseihowebsyokugyoukktymdc(String pZtrseihowebsyokugyoukktymdc) {
        ztrseihowebsyokugyoukktymdc = pZtrseihowebsyokugyoukktymdc;
    }

    private Integer ztrseihowebhhknsintyouc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNSINTYOUC)
    public Integer getZtrseihowebhhknsintyouc() {
        return ztrseihowebhhknsintyouc;
    }

    public void setZtrseihowebhhknsintyouc(Integer pZtrseihowebhhknsintyouc) {
        ztrseihowebhhknsintyouc = pZtrseihowebhhknsintyouc;
    }

    private Integer ztrseihowebhhkntaijyuuc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNTAIJYUUC)
    public Integer getZtrseihowebhhkntaijyuuc() {
        return ztrseihowebhhkntaijyuuc;
    }

    public void setZtrseihowebhhkntaijyuuc(Integer pZtrseihowebhhkntaijyuuc) {
        ztrseihowebhhkntaijyuuc = pZtrseihowebhhkntaijyuuc;
    }

    private String ztrseihowebkktymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKKTYMDC)
    public String getZtrseihowebkktymdc() {
        return ztrseihowebkktymdc;
    }

    public void setZtrseihowebkktymdc(String pZtrseihowebkktymdc) {
        ztrseihowebkktymdc = pZtrseihowebkktymdc;
    }

    private String ztrseihowebhukusuustskskbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHUKUSUUSTSKSKBN)
    public String getZtrseihowebhukusuustskskbn() {
        return ztrseihowebhukusuustskskbn;
    }

    public void setZtrseihowebhukusuustskskbn(String pZtrseihowebhukusuustskskbn) {
        ztrseihowebhukusuustskskbn = pZtrseihowebhukusuustskskbn;
    }

    private String ztrseihowebhnnkaksyoruikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHNNKAKSYORUIKBN)
    public String getZtrseihowebhnnkaksyoruikbn() {
        return ztrseihowebhnnkaksyoruikbn;
    }

    public void setZtrseihowebhnnkaksyoruikbn(String pZtrseihowebhnnkaksyoruikbn) {
        ztrseihowebhnnkaksyoruikbn = pZtrseihowebhnnkaksyoruikbn;
    }

    private String ztrseihowebhsktkjikou;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHSKTKJIKOU)
    public String getZtrseihowebhsktkjikou() {
        return ztrseihowebhsktkjikou;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhsktkjikou(String pZtrseihowebhsktkjikou) {
        ztrseihowebhsktkjikou = pZtrseihowebhsktkjikou;
    }

    private String ztrseihowebskskaksyoruikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSKSKAKSYORUIKBN)
    public String getZtrseihowebskskaksyoruikbn() {
        return ztrseihowebskskaksyoruikbn;
    }

    public void setZtrseihowebskskaksyoruikbn(String pZtrseihowebskskaksyoruikbn) {
        ztrseihowebskskaksyoruikbn = pZtrseihowebskskaksyoruikbn;
    }

    private String ztrseihowebskshsktkjikou;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSKSHSKTKJIKOU)
    public String getZtrseihowebskshsktkjikou() {
        return ztrseihowebskshsktkjikou;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebskshsktkjikou(String pZtrseihowebskshsktkjikou) {
        ztrseihowebskshsktkjikou = pZtrseihowebskshsktkjikou;
    }

    private String ztrseihowebbikkjnssinfoari;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBBIKKJNSSINFOARI)
    public String getZtrseihowebbikkjnssinfoari() {
        return ztrseihowebbikkjnssinfoari;
    }

    public void setZtrseihowebbikkjnssinfoari(String pZtrseihowebbikkjnssinfoari) {
        ztrseihowebbikkjnssinfoari = pZtrseihowebbikkjnssinfoari;
    }

    private String ztrseihowebplbsyutrkno;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLBSYUTRKNO)
    public String getZtrseihowebplbsyutrkno() {
        return ztrseihowebplbsyutrkno;
    }

    public void setZtrseihowebplbsyutrkno(String pZtrseihowebplbsyutrkno) {
        ztrseihowebplbsyutrkno = pZtrseihowebplbsyutrkno;
    }

    private String ztrseihowebplbsyukouincd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLBSYUKOUINCD)
    public String getZtrseihowebplbsyukouincd() {
        return ztrseihowebplbsyukouincd;
    }

    public void setZtrseihowebplbsyukouincd(String pZtrseihowebplbsyukouincd) {
        ztrseihowebplbsyukouincd = pZtrseihowebplbsyukouincd;
    }

    private String ztrseihowebnrkbsyutrkno;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBNRKBSYUTRKNO)
    public String getZtrseihowebnrkbsyutrkno() {
        return ztrseihowebnrkbsyutrkno;
    }

    public void setZtrseihowebnrkbsyutrkno(String pZtrseihowebnrkbsyutrkno) {
        ztrseihowebnrkbsyutrkno = pZtrseihowebnrkbsyutrkno;
    }

    private String ztrseihowebuktkid;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBUKTKID)
    public String getZtrseihowebuktkid() {
        return ztrseihowebuktkid;
    }

    public void setZtrseihowebuktkid(String pZtrseihowebuktkid) {
        ztrseihowebuktkid = pZtrseihowebuktkid;
    }

    private String ztrseihowebdatasousinymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDATASOUSINYMDC)
    public String getZtrseihowebdatasousinymdc() {
        return ztrseihowebdatasousinymdc;
    }

    public void setZtrseihowebdatasousinymdc(String pZtrseihowebdatasousinymdc) {
        ztrseihowebdatasousinymdc = pZtrseihowebdatasousinymdc;
    }

    private String ztrseihowebdatasousinhmsc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDATASOUSINHMSC)
    public String getZtrseihowebdatasousinhmsc() {
        return ztrseihowebdatasousinhmsc;
    }

    public void setZtrseihowebdatasousinhmsc(String pZtrseihowebdatasousinhmsc) {
        ztrseihowebdatasousinhmsc = pZtrseihowebdatasousinhmsc;
    }

    private String ztrseihowebmosuktkymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBMOSUKTKYMDC)
    public String getZtrseihowebmosuktkymdc() {
        return ztrseihowebmosuktkymdc;
    }

    public void setZtrseihowebmosuktkymdc(String pZtrseihowebmosuktkymdc) {
        ztrseihowebmosuktkymdc = pZtrseihowebmosuktkymdc;
    }

    private String ztrseihowebhnnkakhskjk1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHNNKAKHSKJK1)
    public String getZtrseihowebhnnkakhskjk1() {
        return ztrseihowebhnnkakhskjk1;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhnnkakhskjk1(String pZtrseihowebhnnkakhskjk1) {
        ztrseihowebhnnkakhskjk1 = pZtrseihowebhnnkakhskjk1;
    }

    private String ztrseihowebhnnkakhskjk2;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHNNKAKHSKJK2)
    public String getZtrseihowebhnnkakhskjk2() {
        return ztrseihowebhnnkakhskjk2;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhnnkakhskjk2(String pZtrseihowebhnnkakhskjk2) {
        ztrseihowebhnnkakhskjk2 = pZtrseihowebhnnkakhskjk2;
    }

    private String ztrseihowebhnnkakhskjk3;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHNNKAKHSKJK3)
    public String getZtrseihowebhnnkakhskjk3() {
        return ztrseihowebhnnkakhskjk3;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhnnkakhskjk3(String pZtrseihowebhnnkakhskjk3) {
        ztrseihowebhnnkakhskjk3 = pZtrseihowebhnnkakhskjk3;
    }

    private String ztrseihowebhnnkakhskjk4;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHNNKAKHSKJK4)
    public String getZtrseihowebhnnkakhskjk4() {
        return ztrseihowebhnnkakhskjk4;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhnnkakhskjk4(String pZtrseihowebhnnkakhskjk4) {
        ztrseihowebhnnkakhskjk4 = pZtrseihowebhnnkakhskjk4;
    }

    private String ztrseihowebhnnkakhskjk5;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHNNKAKHSKJK5)
    public String getZtrseihowebhnnkakhskjk5() {
        return ztrseihowebhnnkakhskjk5;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhnnkakhskjk5(String pZtrseihowebhnnkakhskjk5) {
        ztrseihowebhnnkakhskjk5 = pZtrseihowebhnnkakhskjk5;
    }

    private String ztrseihowebtorihoutkjk1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTORIHOUTKJK1)
    public String getZtrseihowebtorihoutkjk1() {
        return ztrseihowebtorihoutkjk1;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebtorihoutkjk1(String pZtrseihowebtorihoutkjk1) {
        ztrseihowebtorihoutkjk1 = pZtrseihowebtorihoutkjk1;
    }

    private String ztrseihowebtorihoutkjk2;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTORIHOUTKJK2)
    public String getZtrseihowebtorihoutkjk2() {
        return ztrseihowebtorihoutkjk2;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebtorihoutkjk2(String pZtrseihowebtorihoutkjk2) {
        ztrseihowebtorihoutkjk2 = pZtrseihowebtorihoutkjk2;
    }

    private String ztrseihowebtorihoutkjk3;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTORIHOUTKJK3)
    public String getZtrseihowebtorihoutkjk3() {
        return ztrseihowebtorihoutkjk3;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebtorihoutkjk3(String pZtrseihowebtorihoutkjk3) {
        ztrseihowebtorihoutkjk3 = pZtrseihowebtorihoutkjk3;
    }

    private String ztrseihowebtorihoutkjk4;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTORIHOUTKJK4)
    public String getZtrseihowebtorihoutkjk4() {
        return ztrseihowebtorihoutkjk4;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebtorihoutkjk4(String pZtrseihowebtorihoutkjk4) {
        ztrseihowebtorihoutkjk4 = pZtrseihowebtorihoutkjk4;
    }

    private String ztrseihowebtorihoutkjk5;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTORIHOUTKJK5)
    public String getZtrseihowebtorihoutkjk5() {
        return ztrseihowebtorihoutkjk5;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebtorihoutkjk5(String pZtrseihowebtorihoutkjk5) {
        ztrseihowebtorihoutkjk5 = pZtrseihowebtorihoutkjk5;
    }

    private String ztrseihowebdrtnskno;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDRTNSKNO)
    public String getZtrseihowebdrtnskno() {
        return ztrseihowebdrtnskno;
    }

    public void setZtrseihowebdrtnskno(String pZtrseihowebdrtnskno) {
        ztrseihowebdrtnskno = pZtrseihowebdrtnskno;
    }

    private String ztrseihowebsbnksyukbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSBNKSYUKBN)
    public String getZtrseihowebsbnksyukbn() {
        return ztrseihowebsbnksyukbn;
    }

    public void setZtrseihowebsbnksyukbn(String pZtrseihowebsbnksyukbn) {
        ztrseihowebsbnksyukbn = pZtrseihowebsbnksyukbn;
    }

    private String ztrseihowebaatkisyaknyuucd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBAATKISYAKNYUUCD)
    public String getZtrseihowebaatkisyaknyuucd() {
        return ztrseihowebaatkisyaknyuucd;
    }

    public void setZtrseihowebaatkisyaknyuucd(String pZtrseihowebaatkisyaknyuucd) {
        ztrseihowebaatkisyaknyuucd = pZtrseihowebaatkisyaknyuucd;
    }

    private String ztrseihowebkktttykknrhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKKTTTYKKNRHYJ)
    public String getZtrseihowebkktttykknrhyj() {
        return ztrseihowebkktttykknrhyj;
    }

    public void setZtrseihowebkktttykknrhyj(String pZtrseihowebkktttykknrhyj) {
        ztrseihowebkktttykknrhyj = pZtrseihowebkktttykknrhyj;
    }

    private String ztrseihowebdtlkktarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDTLKKTARIHYJ)
    public String getZtrseihowebdtlkktarihyj() {
        return ztrseihowebdtlkktarihyj;
    }

    public void setZtrseihowebdtlkktarihyj(String pZtrseihowebdtlkktarihyj) {
        ztrseihowebdtlkktarihyj = pZtrseihowebdtlkktarihyj;
    }

    private String ztrseihowebfatcasyoruiari;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBFATCASYORUIARI)
    public String getZtrseihowebfatcasyoruiari() {
        return ztrseihowebfatcasyoruiari;
    }

    public void setZtrseihowebfatcasyoruiari(String pZtrseihowebfatcasyoruiari) {
        ztrseihowebfatcasyoruiari = pZtrseihowebfatcasyoruiari;
    }

    private String ztrseihowebkzhurikaebankcd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZHURIKAEBANKCD)
    public String getZtrseihowebkzhurikaebankcd() {
        return ztrseihowebkzhurikaebankcd;
    }

    public void setZtrseihowebkzhurikaebankcd(String pZtrseihowebkzhurikaebankcd) {
        ztrseihowebkzhurikaebankcd = pZtrseihowebkzhurikaebankcd;
    }

    private String ztrseihowebkzkakiraikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKAKIRAIKBN)
    public String getZtrseihowebkzkakiraikbn() {
        return ztrseihowebkzkakiraikbn;
    }

    public void setZtrseihowebkzkakiraikbn(String pZtrseihowebkzkakiraikbn) {
        ztrseihowebkzkakiraikbn = pZtrseihowebkzkakiraikbn;
    }

    private String ztrseihowebbmierrorhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBBMIERRORHYJ)
    public String getZtrseihowebbmierrorhyj() {
        return ztrseihowebbmierrorhyj;
    }

    public void setZtrseihowebbmierrorhyj(String pZtrseihowebbmierrorhyj) {
        ztrseihowebbmierrorhyj = pZtrseihowebbmierrorhyj;
    }

    private String ztrseihowebkktkmgituarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKKTKMGITUARIHYJ)
    public String getZtrseihowebkktkmgituarihyj() {
        return ztrseihowebkktkmgituarihyj;
    }

    public void setZtrseihowebkktkmgituarihyj(String pZtrseihowebkktkmgituarihyj) {
        ztrseihowebkktkmgituarihyj = pZtrseihowebkktkmgituarihyj;
    }

    private String ztrseihowebsnshuhukbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSNSHUHUKBN)
    public String getZtrseihowebsnshuhukbn() {
        return ztrseihowebsnshuhukbn;
    }

    public void setZtrseihowebsnshuhukbn(String pZtrseihowebsnshuhukbn) {
        ztrseihowebsnshuhukbn = pZtrseihowebsnshuhukbn;
    }

    private String ztrseihowebkeihidouituhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKEIHIDOUITUHYJ)
    public String getZtrseihowebkeihidouituhyj() {
        return ztrseihowebkeihidouituhyj;
    }

    public void setZtrseihowebkeihidouituhyj(String pZtrseihowebkeihidouituhyj) {
        ztrseihowebkeihidouituhyj = pZtrseihowebkeihidouituhyj;
    }

    private String ztrseihowebaeoisnsiarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBAEOISNSIARIHYJ)
    public String getZtrseihowebaeoisnsiarihyj() {
        return ztrseihowebaeoisnsiarihyj;
    }

    public void setZtrseihowebaeoisnsiarihyj(String pZtrseihowebaeoisnsiarihyj) {
        ztrseihowebaeoisnsiarihyj = pZtrseihowebaeoisnsiarihyj;
    }

    private String ztrseihowebsiteituukakbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSITEITUUKAKBN)
    public String getZtrseihowebsiteituukakbn() {
        return ztrseihowebsiteituukakbn;
    }

    public void setZtrseihowebsiteituukakbn(String pZtrseihowebsiteituukakbn) {
        ztrseihowebsiteituukakbn = pZtrseihowebsiteituukakbn;
    }

    private String ztrseihowebnykntuukakbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBNYKNTUUKAKBN)
    public String getZtrseihowebnykntuukakbn() {
        return ztrseihowebnykntuukakbn;
    }

    public void setZtrseihowebnykntuukakbn(String pZtrseihowebnykntuukakbn) {
        ztrseihowebnykntuukakbn = pZtrseihowebnykntuukakbn;
    }

    private String ztrseihowebtargettkarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTARGETTKARIHYJ)
    public String getZtrseihowebtargettkarihyj() {
        return ztrseihowebtargettkarihyj;
    }

    public void setZtrseihowebtargettkarihyj(String pZtrseihowebtargettkarihyj) {
        ztrseihowebtargettkarihyj = pZtrseihowebtargettkarihyj;
    }

    private String ztrseihowebtargettkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTARGETTKKBN)
    public String getZtrseihowebtargettkkbn() {
        return ztrseihowebtargettkkbn;
    }

    public void setZtrseihowebtargettkkbn(String pZtrseihowebtargettkkbn) {
        ztrseihowebtargettkkbn = pZtrseihowebtargettkkbn;
    }

    private Integer ztrseihowebtargettkmkhtc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTARGETTKMKHTC)
    public Integer getZtrseihowebtargettkmkhtc() {
        return ztrseihowebtargettkmkhtc;
    }

    public void setZtrseihowebtargettkmkhtc(Integer pZtrseihowebtargettkmkhtc) {
        ztrseihowebtargettkmkhtc = pZtrseihowebtargettkmkhtc;
    }

    private Long ztrseihowebnykntuukanykngkc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBNYKNTUUKANYKNGKC)
    public Long getZtrseihowebnykntuukanykngkc() {
        return ztrseihowebnykntuukanykngkc;
    }

    public void setZtrseihowebnykntuukanykngkc(Long pZtrseihowebnykntuukanykngkc) {
        ztrseihowebnykntuukanykngkc = pZtrseihowebnykntuukanykngkc;
    }

    private Long ztrseihowebnykntukfsthrkpc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBNYKNTUKFSTHRKPC)
    public Long getZtrseihowebnykntukfsthrkpc() {
        return ztrseihowebnykntukfsthrkpc;
    }

    public void setZtrseihowebnykntukfsthrkpc(Long pZtrseihowebnykntukfsthrkpc) {
        ztrseihowebnykntukfsthrkpc = pZtrseihowebnykntukfsthrkpc;
    }

    private Long ztrseihowebnykntuknexthrkpc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBNYKNTUKNEXTHRKPC)
    public Long getZtrseihowebnykntuknexthrkpc() {
        return ztrseihowebnykntuknexthrkpc;
    }

    public void setZtrseihowebnykntuknexthrkpc(Long pZtrseihowebnykntuknexthrkpc) {
        ztrseihowebnykntuknexthrkpc = pZtrseihowebnykntuknexthrkpc;
    }

    private Long ztrseihowebtargetyenknsnpc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTARGETYENKNSNPC)
    public Long getZtrseihowebtargetyenknsnpc() {
        return ztrseihowebtargetyenknsnpc;
    }

    public void setZtrseihowebtargetyenknsnpc(Long pZtrseihowebtargetyenknsnpc) {
        ztrseihowebtargetyenknsnpc = pZtrseihowebtargetyenknsnpc;
    }

    private Long ztrseihowebtargetmkhgkc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTARGETMKHGKC)
    public Long getZtrseihowebtargetmkhgkc() {
        return ztrseihowebtargetmkhgkc;
    }

    public void setZtrseihowebtargetmkhgkc(Long pZtrseihowebtargetmkhgkc) {
        ztrseihowebtargetmkhgkc = pZtrseihowebtargetmkhgkc;
    }

    private String ztrseihowebsaimankihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSAIMANKIHYJ)
    public String getZtrseihowebsaimankihyj() {
        return ztrseihowebsaimankihyj;
    }

    public void setZtrseihowebsaimankihyj(String pZtrseihowebsaimankihyj) {
        ztrseihowebsaimankihyj = pZtrseihowebsaimankihyj;
    }

    private String ztrseihowebrayhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBRAYHYJ)
    public String getZtrseihowebrayhyj() {
        return ztrseihowebrayhyj;
    }

    public void setZtrseihowebrayhyj(String pZtrseihowebrayhyj) {
        ztrseihowebrayhyj = pZtrseihowebrayhyj;
    }

    private String ztryobiv156;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRYOBIV156)
    public String getZtryobiv156() {
        return ztryobiv156;
    }

    public void setZtryobiv156(String pZtryobiv156) {
        ztryobiv156 = pZtryobiv156;
    }

    private String ztrseihowebpsyouhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPSYOUHYJ)
    public String getZtrseihowebpsyouhyj() {
        return ztrseihowebpsyouhyj;
    }

    public void setZtrseihowebpsyouhyj(String pZtrseihowebpsyouhyj) {
        ztrseihowebpsyouhyj = pZtrseihowebpsyouhyj;
    }

    private String ztrseihowebplhhknkjnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLHHKNKJNM)
    public String getZtrseihowebplhhknkjnm() {
        return ztrseihowebplhhknkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebplhhknkjnm(String pZtrseihowebplhhknkjnm) {
        ztrseihowebplhhknkjnm = pZtrseihowebplhhknkjnm;
    }

    private String ztryobiv1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRYOBIV1)
    public String getZtryobiv1() {
        return ztryobiv1;
    }

    public void setZtryobiv1(String pZtryobiv1) {
        ztryobiv1 = pZtryobiv1;
    }

    private String ztrseihowebplkykkjnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLKYKKJNM)
    public String getZtrseihowebplkykkjnm() {
        return ztrseihowebplkykkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebplkykkjnm(String pZtrseihowebplkykkjnm) {
        ztrseihowebplkykkjnm = pZtrseihowebplkykkjnm;
    }

    private String ztrseihowebplhjkktkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLHJKKTKBN)
    public String getZtrseihowebplhjkktkbn() {
        return ztrseihowebplhjkktkbn;
    }

    public void setZtrseihowebplhjkktkbn(String pZtrseihowebplhjkktkbn) {
        ztrseihowebplhjkktkbn = pZtrseihowebplhjkktkbn;
    }

    private String ztrseihowebplhrkkeirokbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLHRKKEIROKBN)
    public String getZtrseihowebplhrkkeirokbn() {
        return ztrseihowebplhrkkeirokbn;
    }

    public void setZtrseihowebplhrkkeirokbn(String pZtrseihowebplhrkkeirokbn) {
        ztrseihowebplhrkkeirokbn = pZtrseihowebplhrkkeirokbn;
    }

    private String ztrseihowebplnkshrarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLNKSHRARIHYJ)
    public String getZtrseihowebplnkshrarihyj() {
        return ztrseihowebplnkshrarihyj;
    }

    public void setZtrseihowebplnkshrarihyj(String pZtrseihowebplnkshrarihyj) {
        ztrseihowebplnkshrarihyj = pZtrseihowebplnkshrarihyj;
    }

    private String ztryobiv2;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRYOBIV2)
    public String getZtryobiv2() {
        return ztryobiv2;
    }

    public void setZtryobiv2(String pZtryobiv2) {
        ztryobiv2 = pZtryobiv2;
    }

    private String ztrseihowebplmosnoc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLMOSNOC)
    public String getZtrseihowebplmosnoc() {
        return ztrseihowebplmosnoc;
    }

    public void setZtrseihowebplmosnoc(String pZtrseihowebplmosnoc) {
        ztrseihowebplmosnoc = pZtrseihowebplmosnoc;
    }

    private String ztrseihowebplsbuktnrkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLSBUKTNRKKBN)
    public String getZtrseihowebplsbuktnrkkbn() {
        return ztrseihowebplsbuktnrkkbn;
    }

    public void setZtrseihowebplsbuktnrkkbn(String pZtrseihowebplsbuktnrkkbn) {
        ztrseihowebplsbuktnrkkbn = pZtrseihowebplsbuktnrkkbn;
    }

    private String ztrseihowebplsbukttdkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLSBUKTTDKKBN)
    public String getZtrseihowebplsbukttdkkbn() {
        return ztrseihowebplsbukttdkkbn;
    }

    public void setZtrseihowebplsbukttdkkbn(String pZtrseihowebplsbukttdkkbn) {
        ztrseihowebplsbukttdkkbn = pZtrseihowebplsbukttdkkbn;
    }

    private String ztrseihowebplsbuktknnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLSBUKTKNNM)
    public String getZtrseihowebplsbuktknnm() {
        return ztrseihowebplsbuktknnm;
    }

    public void setZtrseihowebplsbuktknnm(String pZtrseihowebplsbuktknnm) {
        ztrseihowebplsbuktknnm = pZtrseihowebplsbuktknnm;
    }

    private String ztrseihowebplsbuktkjnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLSBUKTKJNM)
    public String getZtrseihowebplsbuktkjnm() {
        return ztrseihowebplsbuktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebplsbuktkjnm(String pZtrseihowebplsbuktkjnm) {
        ztrseihowebplsbuktkjnm = pZtrseihowebplsbuktkjnm;
    }

    private String ztryobiv3;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRYOBIV3)
    public String getZtryobiv3() {
        return ztryobiv3;
    }

    public void setZtryobiv3(String pZtryobiv3) {
        ztryobiv3 = pZtryobiv3;
    }

    private String ztrseihowebplsbuktseiymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLSBUKTSEIYMDC)
    public String getZtrseihowebplsbuktseiymdc() {
        return ztrseihowebplsbuktseiymdc;
    }

    public void setZtrseihowebplsbuktseiymdc(String pZtrseihowebplsbuktseiymdc) {
        ztrseihowebplsbuktseiymdc = pZtrseihowebplsbuktseiymdc;
    }

    private String ztrseihowebpltksykmcd1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLTKSYKMCD1)
    public String getZtrseihowebpltksykmcd1() {
        return ztrseihowebpltksykmcd1;
    }

    public void setZtrseihowebpltksykmcd1(String pZtrseihowebpltksykmcd1) {
        ztrseihowebpltksykmcd1 = pZtrseihowebpltksykmcd1;
    }

    private String ztrseihowebpltksykmcd2;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLTKSYKMCD2)
    public String getZtrseihowebpltksykmcd2() {
        return ztrseihowebpltksykmcd2;
    }

    public void setZtrseihowebpltksykmcd2(String pZtrseihowebpltksykmcd2) {
        ztrseihowebpltksykmcd2 = pZtrseihowebpltksykmcd2;
    }

    private String ztrseihowebpltksykmcd3;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLTKSYKMCD3)
    public String getZtrseihowebpltksykmcd3() {
        return ztrseihowebpltksykmcd3;
    }

    public void setZtrseihowebpltksykmcd3(String pZtrseihowebpltksykmcd3) {
        ztrseihowebpltksykmcd3 = pZtrseihowebpltksykmcd3;
    }

    private String ztrseihowebpltksykmcd4;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLTKSYKMCD4)
    public String getZtrseihowebpltksykmcd4() {
        return ztrseihowebpltksykmcd4;
    }

    public void setZtrseihowebpltksykmcd4(String pZtrseihowebpltksykmcd4) {
        ztrseihowebpltksykmcd4 = pZtrseihowebpltksykmcd4;
    }

    private String ztrseihowebpltksykmcd5;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLTKSYKMCD5)
    public String getZtrseihowebpltksykmcd5() {
        return ztrseihowebpltksykmcd5;
    }

    public void setZtrseihowebpltksykmcd5(String pZtrseihowebpltksykmcd5) {
        ztrseihowebpltksykmcd5 = pZtrseihowebpltksykmcd5;
    }

    private String ztrseihowebplkyktelno;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLKYKTELNO)
    public String getZtrseihowebplkyktelno() {
        return ztrseihowebplkyktelno;
    }

    public void setZtrseihowebplkyktelno(String pZtrseihowebplkyktelno) {
        ztrseihowebplkyktelno = pZtrseihowebplkyktelno;
    }

    private String ztrseihowebplhhkntelno;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLHHKNTELNO)
    public String getZtrseihowebplhhkntelno() {
        return ztrseihowebplhhkntelno;
    }

    public void setZtrseihowebplhhkntelno(String pZtrseihowebplhhkntelno) {
        ztrseihowebplhhkntelno = pZtrseihowebplhhkntelno;
    }

    private String ztryobiv3x2;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRYOBIV3X2)
    public String getZtryobiv3x2() {
        return ztryobiv3x2;
    }

    public void setZtryobiv3x2(String pZtryobiv3x2) {
        ztryobiv3x2 = pZtryobiv3x2;
    }

    private String ztrseihowebplkihontikucd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLKIHONTIKUCD)
    public String getZtrseihowebplkihontikucd() {
        return ztrseihowebplkihontikucd;
    }

    public void setZtrseihowebplkihontikucd(String pZtrseihowebplkihontikucd) {
        ztrseihowebplkihontikucd = pZtrseihowebplkihontikucd;
    }

    private String ztrseihowebpltsinadrkai;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLTSINADRKAI)
    public String getZtrseihowebpltsinadrkai() {
        return ztrseihowebpltsinadrkai;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebpltsinadrkai(String pZtrseihowebpltsinadrkai) {
        ztrseihowebpltsinadrkai = pZtrseihowebpltsinadrkai;
    }

    private String ztrseihowebplhiikihontikucd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLHIIKIHONTIKUCD)
    public String getZtrseihowebplhiikihontikucd() {
        return ztrseihowebplhiikihontikucd;
    }

    public void setZtrseihowebplhiikihontikucd(String pZtrseihowebplhiikihontikucd) {
        ztrseihowebplhiikihontikucd = pZtrseihowebplhiikihontikucd;
    }

    private String ztrseihowebplhhknadr;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPLHHKNADR)
    public String getZtrseihowebplhhknadr() {
        return ztrseihowebplhhknadr;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebplhhknadr(String pZtrseihowebplhhknadr) {
        ztrseihowebplhhknadr = pZtrseihowebplhhknadr;
    }

    private Long ztrseihowebgnykntuknykngkc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBGNYKNTUKNYKNGKC)
    public Long getZtrseihowebgnykntuknykngkc() {
        return ztrseihowebgnykntuknykngkc;
    }

    public void setZtrseihowebgnykntuknykngkc(Long pZtrseihowebgnykntuknykngkc) {
        ztrseihowebgnykntuknykngkc = pZtrseihowebgnykntuknykngkc;
    }

    private Long ztrseihowebgnykntukfsthrkpc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBGNYKNTUKFSTHRKPC)
    public Long getZtrseihowebgnykntukfsthrkpc() {
        return ztrseihowebgnykntukfsthrkpc;
    }

    public void setZtrseihowebgnykntukfsthrkpc(Long pZtrseihowebgnykntukfsthrkpc) {
        ztrseihowebgnykntukfsthrkpc = pZtrseihowebgnykntukfsthrkpc;
    }

    private Long ztrseihowebgnykntuknxthrkpc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBGNYKNTUKNXTHRKPC)
    public Long getZtrseihowebgnykntuknxthrkpc() {
        return ztrseihowebgnykntuknxthrkpc;
    }

    public void setZtrseihowebgnykntuknxthrkpc(Long pZtrseihowebgnykntuknxthrkpc) {
        ztrseihowebgnykntuknxthrkpc = pZtrseihowebgnykntuknxthrkpc;
    }

    private Long ztrseihowebgaikakihonpc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBGAIKAKIHONPC)
    public Long getZtrseihowebgaikakihonpc() {
        return ztrseihowebgaikakihonpc;
    }

    public void setZtrseihowebgaikakihonpc(Long pZtrseihowebgaikakihonpc) {
        ztrseihowebgaikakihonpc = pZtrseihowebgaikakihonpc;
    }

    private String ztrseihowebkaigmehrtkarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKAIGMEHRTKARIHYJ)
    public String getZtrseihowebkaigmehrtkarihyj() {
        return ztrseihowebkaigmehrtkarihyj;
    }

    public void setZtrseihowebkaigmehrtkarihyj(String pZtrseihowebkaigmehrtkarihyj) {
        ztrseihowebkaigmehrtkarihyj = pZtrseihowebkaigmehrtkarihyj;
    }

    private String ztrseihowebyenhsyutkarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBYENHSYUTKARIHYJ)
    public String getZtrseihowebyenhsyutkarihyj() {
        return ztrseihowebyenhsyutkarihyj;
    }

    public void setZtrseihowebyenhsyutkarihyj(String pZtrseihowebyenhsyutkarihyj) {
        ztrseihowebyenhsyutkarihyj = pZtrseihowebyenhsyutkarihyj;
    }

    private Long ztrseihowebgaikakihonsc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBGAIKAKIHONSC)
    public Long getZtrseihowebgaikakihonsc() {
        return ztrseihowebgaikakihonsc;
    }

    public void setZtrseihowebgaikakihonsc(Long pZtrseihowebgaikakihonsc) {
        ztrseihowebgaikakihonsc = pZtrseihowebgaikakihonsc;
    }

    private Integer ztrseihowebdai1hknkknc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDAI1HKNKKNC)
    public Integer getZtrseihowebdai1hknkknc() {
        return ztrseihowebdai1hknkknc;
    }

    public void setZtrseihowebdai1hknkknc(Integer pZtrseihowebdai1hknkknc) {
        ztrseihowebdai1hknkknc = pZtrseihowebdai1hknkknc;
    }

    private String ztrseihowebdsmoshyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDSMOSHYJ)
    public String getZtrseihowebdsmoshyj() {
        return ztrseihowebdsmoshyj;
    }

    public void setZtrseihowebdsmoshyj(String pZtrseihowebdsmoshyj) {
        ztrseihowebdsmoshyj = pZtrseihowebdsmoshyj;
    }

    private String ztrseihowebdsmailaddress;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDSMAILADDRESS)
    public String getZtrseihowebdsmailaddress() {
        return ztrseihowebdsmailaddress;
    }

    public void setZtrseihowebdsmailaddress(String pZtrseihowebdsmailaddress) {
        ztrseihowebdsmailaddress = pZtrseihowebdsmailaddress;
    }

    private String ztrseihowebankenkanrino;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBANKENKANRINO)
    public String getZtrseihowebankenkanrino() {
        return ztrseihowebankenkanrino;
    }

    public void setZtrseihowebankenkanrino(String pZtrseihowebankenkanrino) {
        ztrseihowebankenkanrino = pZtrseihowebankenkanrino;
    }

    private String ztrseihowebkydbosyuukjncd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKYDBOSYUUKJNCD)
    public String getZtrseihowebkydbosyuukjncd() {
        return ztrseihowebkydbosyuukjncd;
    }

    public void setZtrseihowebkydbosyuukjncd(String pZtrseihowebkydbosyuukjncd) {
        ztrseihowebkydbosyuukjncd = pZtrseihowebkydbosyuukjncd;
    }

    private String ztrseihowebhnyppltzmhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHNYPPLTZMHYJ)
    public String getZtrseihowebhnyppltzmhyj() {
        return ztrseihowebhnyppltzmhyj;
    }

    public void setZtrseihowebhnyppltzmhyj(String pZtrseihowebhnyppltzmhyj) {
        ztrseihowebhnyppltzmhyj = pZtrseihowebhnyppltzmhyj;
    }

    private Integer ztrseihowebssrndhbnwrc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSSRNDHBNWRC)
    public Integer getZtrseihowebssrndhbnwrc() {
        return ztrseihowebssrndhbnwrc;
    }

    public void setZtrseihowebssrndhbnwrc(Integer pZtrseihowebssrndhbnwrc) {
        ztrseihowebssrndhbnwrc = pZtrseihowebssrndhbnwrc;
    }

    private Integer ztrseihowebtrtrndhbnwrc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBTRTRNDHBNWRC)
    public Integer getZtrseihowebtrtrndhbnwrc() {
        return ztrseihowebtrtrndhbnwrc;
    }

    public void setZtrseihowebtrtrndhbnwrc(Integer pZtrseihowebtrtrndhbnwrc) {
        ztrseihowebtrtrndhbnwrc = pZtrseihowebtrtrndhbnwrc;
    }

    private Integer ztrseihowebsueokikknc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBSUEOKIKKNC)
    public Integer getZtrseihowebsueokikknc() {
        return ztrseihowebsueokikknc;
    }

    public void setZtrseihowebsueokikknc(Integer pZtrseihowebsueokikknc) {
        ztrseihowebsueokikknc = pZtrseihowebsueokikknc;
    }

    private String ztrseihowebmnkuktnrkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBMNKUKTNRKKBN)
    public String getZtrseihowebmnkuktnrkkbn() {
        return ztrseihowebmnkuktnrkkbn;
    }

    public void setZtrseihowebmnkuktnrkkbn(String pZtrseihowebmnkuktnrkkbn) {
        ztrseihowebmnkuktnrkkbn = pZtrseihowebmnkuktnrkkbn;
    }

    private String ztrseihowebmnkukttdkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBMNKUKTTDKKBN)
    public String getZtrseihowebmnkukttdkkbn() {
        return ztrseihowebmnkukttdkkbn;
    }

    public void setZtrseihowebmnkukttdkkbn(String pZtrseihowebmnkukttdkkbn) {
        ztrseihowebmnkukttdkkbn = pZtrseihowebmnkukttdkkbn;
    }

    private String ztrseihowebmnkuktknnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBMNKUKTKNNM)
    public String getZtrseihowebmnkuktknnm() {
        return ztrseihowebmnkuktknnm;
    }

    public void setZtrseihowebmnkuktknnm(String pZtrseihowebmnkuktknnm) {
        ztrseihowebmnkuktknnm = pZtrseihowebmnkuktknnm;
    }

    private String ztrseihowebmnkuktkjnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBMNKUKTKJNM)
    public String getZtrseihowebmnkuktkjnm() {
        return ztrseihowebmnkuktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebmnkuktkjnm(String pZtrseihowebmnkuktkjnm) {
        ztrseihowebmnkuktkjnm = pZtrseihowebmnkuktkjnm;
    }

    private String ztrseihowebmnkuktseiymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBMNKUKTSEIYMDC)
    public String getZtrseihowebmnkuktseiymdc() {
        return ztrseihowebmnkuktseiymdc;
    }

    public void setZtrseihowebmnkuktseiymdc(String pZtrseihowebmnkuktseiymdc) {
        ztrseihowebmnkuktseiymdc = pZtrseihowebmnkuktseiymdc;
    }

    private String ztrseihowebdsknkzmeigi;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDSKNKZMEIGI)
    public String getZtrseihowebdsknkzmeigi() {
        return ztrseihowebdsknkzmeigi;
    }

    public void setZtrseihowebdsknkzmeigi(String pZtrseihowebdsknkzmeigi) {
        ztrseihowebdsknkzmeigi = pZtrseihowebdsknkzmeigi;
    }

    private String ztrseihowebdskzsyuruikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDSKZSYURUIKBN)
    public String getZtrseihowebdskzsyuruikbn() {
        return ztrseihowebdskzsyuruikbn;
    }

    public void setZtrseihowebdskzsyuruikbn(String pZtrseihowebdskzsyuruikbn) {
        ztrseihowebdskzsyuruikbn = pZtrseihowebdskzsyuruikbn;
    }

    private String ztrseihowebdskinyuucd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDSKINYUUCD)
    public String getZtrseihowebdskinyuucd() {
        return ztrseihowebdskinyuucd;
    }

    public void setZtrseihowebdskinyuucd(String pZtrseihowebdskinyuucd) {
        ztrseihowebdskinyuucd = pZtrseihowebdskinyuucd;
    }

    private String ztrseihowebdssitencd;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDSSITENCD)
    public String getZtrseihowebdssitencd() {
        return ztrseihowebdssitencd;
    }

    public void setZtrseihowebdssitencd(String pZtrseihowebdssitencd) {
        ztrseihowebdssitencd = pZtrseihowebdssitencd;
    }

    private String ztrseihowebdsyokinkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDSYOKINKBN)
    public String getZtrseihowebdsyokinkbn() {
        return ztrseihowebdsyokinkbn;
    }

    public void setZtrseihowebdsyokinkbn(String pZtrseihowebdsyokinkbn) {
        ztrseihowebdsyokinkbn = pZtrseihowebdsyokinkbn;
    }

    private String ztrseihowebdskouzano;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDSKOUZANO)
    public String getZtrseihowebdskouzano() {
        return ztrseihowebdskouzano;
    }

    public void setZtrseihowebdskouzano(String pZtrseihowebdskouzano) {
        ztrseihowebdskouzano = pZtrseihowebdskouzano;
    }

    private String ztrseihowebdsansyono;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDSANSYONO)
    public String getZtrseihowebdsansyono() {
        return ztrseihowebdsansyono;
    }

    public void setZtrseihowebdsansyono(String pZtrseihowebdsansyono) {
        ztrseihowebdsansyono = pZtrseihowebdsansyono;
    }

    private String ztrseihowebdssymnttdkhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDSSYMNTTDKHYJ)
    public String getZtrseihowebdssymnttdkhyj() {
        return ztrseihowebdssymnttdkhyj;
    }

    public void setZtrseihowebdssymnttdkhyj(String pZtrseihowebdssymnttdkhyj) {
        ztrseihowebdssymnttdkhyj = pZtrseihowebdssymnttdkhyj;
    }

    private Long ztrseihowebikkatupc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBIKKATUPC)
    public Long getZtrseihowebikkatupc() {
        return ztrseihowebikkatupc;
    }

    public void setZtrseihowebikkatupc(Long pZtrseihowebikkatupc) {
        ztrseihowebikkatupc = pZtrseihowebikkatupc;
    }

    private String ztrseihowebikkatubaraikbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBIKKATUBARAIKBN)
    public String getZtrseihowebikkatubaraikbn() {
        return ztrseihowebikkatubaraikbn;
    }

    public void setZtrseihowebikkatubaraikbn(String pZtrseihowebikkatubaraikbn) {
        ztrseihowebikkatubaraikbn = pZtrseihowebikkatubaraikbn;
    }

    private Integer ztrseihowebiktbrikaisuuc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBIKTBRIKAISUUC)
    public Integer getZtrseihowebiktbrikaisuuc() {
        return ztrseihowebiktbrikaisuuc;
    }

    public void setZtrseihowebiktbrikaisuuc(Integer pZtrseihowebiktbrikaisuuc) {
        ztrseihowebiktbrikaisuuc = pZtrseihowebiktbrikaisuuc;
    }

    private Long ztrseihowebzennoupc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBZENNOUPC)
    public Long getZtrseihowebzennoupc() {
        return ztrseihowebzennoupc;
    }

    public void setZtrseihowebzennoupc(Long pZtrseihowebzennoupc) {
        ztrseihowebzennoupc = pZtrseihowebzennoupc;
    }

    private Long ztrseihowebgaikazennoupc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBGAIKAZENNOUPC)
    public Long getZtrseihowebgaikazennoupc() {
        return ztrseihowebgaikazennoupc;
    }

    public void setZtrseihowebgaikazennoupc(Long pZtrseihowebgaikazennoupc) {
        ztrseihowebgaikazennoupc = pZtrseihowebgaikazennoupc;
    }

    private String ztrseihowebzennouhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBZENNOUHYJ)
    public String getZtrseihowebzennouhyj() {
        return ztrseihowebzennouhyj;
    }

    public void setZtrseihowebzennouhyj(String pZtrseihowebzennouhyj) {
        ztrseihowebzennouhyj = pZtrseihowebzennouhyj;
    }

    private String ztrseihowebyakkankbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBYAKKANKBN)
    public String getZtrseihowebyakkankbn() {
        return ztrseihowebyakkankbn;
    }

    public void setZtrseihowebyakkankbn(String pZtrseihowebyakkankbn) {
        ztrseihowebyakkankbn = pZtrseihowebyakkankbn;
    }

    private String ztrseihowebnetkhrzmhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBNETKHRZMHYJ)
    public String getZtrseihowebnetkhrzmhyj() {
        return ztrseihowebnetkhrzmhyj;
    }

    public void setZtrseihowebnetkhrzmhyj(String pZtrseihowebnetkhrzmhyj) {
        ztrseihowebnetkhrzmhyj = pZtrseihowebnetkhrzmhyj;
    }

    private String ztrseihowebkzktrkmoskbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKTRKMOSKBN)
    public String getZtrseihowebkzktrkmoskbn() {
        return ztrseihowebkzktrkmoskbn;
    }

    public void setZtrseihowebkzktrkmoskbn(String pZtrseihowebkzktrkmoskbn) {
        ztrseihowebkzktrkmoskbn = pZtrseihowebkzktrkmoskbn;
    }

    private String ztrseihowebkzktdkkbn1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKTDKKBN1)
    public String getZtrseihowebkzktdkkbn1() {
        return ztrseihowebkzktdkkbn1;
    }

    public void setZtrseihowebkzktdkkbn1(String pZtrseihowebkzktdkkbn1) {
        ztrseihowebkzktdkkbn1 = pZtrseihowebkzktdkkbn1;
    }

    private String ztrseihowebkzkknnm1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKKNNM1)
    public String getZtrseihowebkzkknnm1() {
        return ztrseihowebkzkknnm1;
    }

    public void setZtrseihowebkzkknnm1(String pZtrseihowebkzkknnm1) {
        ztrseihowebkzkknnm1 = pZtrseihowebkzkknnm1;
    }

    private String ztrseihowebkzkkjnm1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKKJNM1)
    public String getZtrseihowebkzkkjnm1() {
        return ztrseihowebkzkkjnm1;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkzkkjnm1(String pZtrseihowebkzkkjnm1) {
        ztrseihowebkzkkjnm1 = pZtrseihowebkzkkjnm1;
    }

    private String ztrseihowebkzkseikbn1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKSEIKBN1)
    public String getZtrseihowebkzkseikbn1() {
        return ztrseihowebkzkseikbn1;
    }

    public void setZtrseihowebkzkseikbn1(String pZtrseihowebkzkseikbn1) {
        ztrseihowebkzkseikbn1 = pZtrseihowebkzkseikbn1;
    }

    private String ztrseihowebkzkseiymd1c;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKSEIYMD1C)
    public String getZtrseihowebkzkseiymd1c() {
        return ztrseihowebkzkseiymd1c;
    }

    public void setZtrseihowebkzkseiymd1c(String pZtrseihowebkzkseiymd1c) {
        ztrseihowebkzkseiymd1c = pZtrseihowebkzkseiymd1c;
    }

    private String ztrseihowebkzkkykdoukyohyj1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKKYKDOUKYOHYJ1)
    public String getZtrseihowebkzkkykdoukyohyj1() {
        return ztrseihowebkzkkykdoukyohyj1;
    }

    public void setZtrseihowebkzkkykdoukyohyj1(String pZtrseihowebkzkkykdoukyohyj1) {
        ztrseihowebkzkkykdoukyohyj1 = pZtrseihowebkzkkykdoukyohyj1;
    }

    private String ztrseihowebkzkyno1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKYNO1)
    public String getZtrseihowebkzkyno1() {
        return ztrseihowebkzkyno1;
    }

    public void setZtrseihowebkzkyno1(String pZtrseihowebkzkyno1) {
        ztrseihowebkzkyno1 = pZtrseihowebkzkyno1;
    }

    private String ztrseihowebkzkadr1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKADR1)
    public String getZtrseihowebkzkadr1() {
        return ztrseihowebkzkadr1;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkzkadr1(String pZtrseihowebkzkadr1) {
        ztrseihowebkzkadr1 = pZtrseihowebkzkadr1;
    }

    private String ztrseihowebkzktelno1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKZKTELNO1)
    public String getZtrseihowebkzktelno1() {
        return ztrseihowebkzktelno1;
    }

    public void setZtrseihowebkzktelno1(String pZtrseihowebkzktelno1) {
        ztrseihowebkzktelno1 = pZtrseihowebkzktelno1;
    }

    private String ztrseihowebkykdrtkkanouhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKYKDRTKKANOUHYJ)
    public String getZtrseihowebkykdrtkkanouhyj() {
        return ztrseihowebkykdrtkkanouhyj;
    }

    public void setZtrseihowebkykdrtkkanouhyj(String pZtrseihowebkykdrtkkanouhyj) {
        ztrseihowebkykdrtkkanouhyj = pZtrseihowebkykdrtkkanouhyj;
    }

    private String ztrseihowebhhkndrtkkanouhyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNDRTKKANOUHYJ)
    public String getZtrseihowebhhkndrtkkanouhyj() {
        return ztrseihowebhhkndrtkkanouhyj;
    }

    public void setZtrseihowebhhkndrtkkanouhyj(String pZtrseihowebhhkndrtkkanouhyj) {
        ztrseihowebhhkndrtkkanouhyj = pZtrseihowebhhkndrtkkanouhyj;
    }

    private String ztrseihowebdrtkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDRTKKBN)
    public String getZtrseihowebdrtkkbn() {
        return ztrseihowebdrtkkbn;
    }

    public void setZtrseihowebdrtkkbn(String pZtrseihowebdrtkkbn) {
        ztrseihowebdrtkkbn = pZtrseihowebdrtkkbn;
    }

    private String ztrseihowebkykdrnrkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKYKDRNRKKBN)
    public String getZtrseihowebkykdrnrkkbn() {
        return ztrseihowebkykdrnrkkbn;
    }

    public void setZtrseihowebkykdrnrkkbn(String pZtrseihowebkykdrnrkkbn) {
        ztrseihowebkykdrnrkkbn = pZtrseihowebkykdrnrkkbn;
    }

    private String ztrseihowebhhkndrnrkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNDRNRKKBN)
    public String getZtrseihowebhhkndrnrkkbn() {
        return ztrseihowebhhkndrnrkkbn;
    }

    public void setZtrseihowebhhkndrnrkkbn(String pZtrseihowebhhkndrnrkkbn) {
        ztrseihowebhhkndrnrkkbn = pZtrseihowebhhkndrnrkkbn;
    }

    private String ztrseihowebhhkndrtdkkbn;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNDRTDKKBN)
    public String getZtrseihowebhhkndrtdkkbn() {
        return ztrseihowebhhkndrtdkkbn;
    }

    public void setZtrseihowebhhkndrtdkkbn(String pZtrseihowebhhkndrtdkkbn) {
        ztrseihowebhhkndrtdkkbn = pZtrseihowebhhkndrtdkkbn;
    }

    private String ztrseihowebhhkndrknnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNDRKNNM)
    public String getZtrseihowebhhkndrknnm() {
        return ztrseihowebhhkndrknnm;
    }

    public void setZtrseihowebhhkndrknnm(String pZtrseihowebhhkndrknnm) {
        ztrseihowebhhkndrknnm = pZtrseihowebhhkndrknnm;
    }

    private String ztrseihowebhhkndrkjnm;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNDRKJNM)
    public String getZtrseihowebhhkndrkjnm() {
        return ztrseihowebhhkndrkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhhkndrkjnm(String pZtrseihowebhhkndrkjnm) {
        ztrseihowebhhkndrkjnm = pZtrseihowebhhkndrkjnm;
    }

    private String ztrseihowebhhkndrseiymdc;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBHHKNDRSEIYMDC)
    public String getZtrseihowebhhkndrseiymdc() {
        return ztrseihowebhhkndrseiymdc;
    }

    public void setZtrseihowebhhkndrseiymdc(String pZtrseihowebhhkndrseiymdc) {
        ztrseihowebhhkndrseiymdc = pZtrseihowebhhkndrseiymdc;
    }

    private String ztrseihowebdaihituarihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBDAIHITUARIHYJ)
    public String getZtrseihowebdaihituarihyj() {
        return ztrseihowebdaihituarihyj;
    }

    public void setZtrseihowebdaihituarihyj(String pZtrseihowebdaihituarihyj) {
        ztrseihowebdaihituarihyj = pZtrseihowebdaihituarihyj;
    }

    private String ztrseihowebkoureisyakakkbn1;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKOUREISYAKAKKBN1)
    public String getZtrseihowebkoureisyakakkbn1() {
        return ztrseihowebkoureisyakakkbn1;
    }

    public void setZtrseihowebkoureisyakakkbn1(String pZtrseihowebkoureisyakakkbn1) {
        ztrseihowebkoureisyakakkbn1 = pZtrseihowebkoureisyakakkbn1;
    }

    private String ztrseihowebkoureisyakakkbn2;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKOUREISYAKAKKBN2)
    public String getZtrseihowebkoureisyakakkbn2() {
        return ztrseihowebkoureisyakakkbn2;
    }

    public void setZtrseihowebkoureisyakakkbn2(String pZtrseihowebkoureisyakakkbn2) {
        ztrseihowebkoureisyakakkbn2 = pZtrseihowebkoureisyakakkbn2;
    }

    private String ztrseihowebkoureisyakakkbn3;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBKOUREISYAKAKKBN3)
    public String getZtrseihowebkoureisyakakkbn3() {
        return ztrseihowebkoureisyakakkbn3;
    }

    public void setZtrseihowebkoureisyakakkbn3(String pZtrseihowebkoureisyakakkbn3) {
        ztrseihowebkoureisyakakkbn3 = pZtrseihowebkoureisyakakkbn3;
    }

    private String ztrseihowebptuutihyj;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRSEIHOWEBPTUUTIHYJ)
    public String getZtrseihowebptuutihyj() {
        return ztrseihowebptuutihyj;
    }

    public void setZtrseihowebptuutihyj(String pZtrseihowebptuutihyj) {
        ztrseihowebptuutihyj = pZtrseihowebptuutihyj;
    }

    private String ztryobiv1546;

    @Column(name=GenZT_HanyouPaperlessMos1Tr.ZTRYOBIV1546)
    public String getZtryobiv1546() {
        return ztryobiv1546;
    }

    public void setZtryobiv1546(String pZtryobiv1546) {
        ztryobiv1546 = pZtryobiv1546;
    }
}