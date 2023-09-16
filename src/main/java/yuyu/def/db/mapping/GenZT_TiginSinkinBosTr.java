package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import yuyu.def.db.entity.ZT_TiginSinkinBosTr;
import yuyu.def.db.id.PKZT_TiginSinkinBosTr;
import yuyu.def.db.meta.GenQZT_TiginSinkinBosTr;
import yuyu.def.db.meta.QZT_TiginSinkinBosTr;

/**
 * 地銀信金募集テーブル（取） テーブルのマッピング情報クラスで、 {@link ZT_TiginSinkinBosTr} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TiginSinkinBosTr}</td><td colspan="3">地銀信金募集テーブル（取）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtrseihowebidkbn ztrseihowebidkbn}</td><td>（取込用）生保ＷｅｂＩＤ区分</td><td align="center">{@link PKZT_TiginSinkinBosTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkojincd ztrseihowebkojincd}</td><td>（取込用）生保Ｗｅｂ個人コード</td><td align="center">{@link PKZT_TiginSinkinBosTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebitijihozonhyouji ztrseihowebitijihozonhyouji}</td><td>（取込用）生保Ｗｅｂ一時保存表示</td><td align="center">{@link PKZT_TiginSinkinBosTr ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsekno ztrseihowebsekno}</td><td>（取込用）生保Ｗｅｂ設計書番号</td><td align="center">{@link PKZT_TiginSinkinBosTr ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebcalckijyunymd ztrseihowebcalckijyunymd}</td><td>（取込用）生保Ｗｅｂ計算基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknknnm ztrseihowebhhknknnm}</td><td>（取込用）生保Ｗｅｂ被保険者カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknkjnm ztrseihowebhhknkjnm}</td><td>（取込用）生保Ｗｅｂ被保険者漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknseiymd ztrseihowebhhknseiymd}</td><td>（取込用）生保Ｗｅｂ被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknseikbn ztrseihowebhhknseikbn}</td><td>（取込用）生保Ｗｅｂ被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmrhkihontikucd ztrseihowebmrhkihontikucd}</td><td>（取込用）生保Ｗｅｂマル被基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknadr ztrseihowebhhknadr}</td><td>（取込用）生保Ｗｅｂ被保険者住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkykknnm ztrseihowebkykknnm}</td><td>（取込用）生保Ｗｅｂ契約者カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkykkjnm ztrseihowebkykkjnm}</td><td>（取込用）生保Ｗｅｂ契約者漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkyksyaseiymd ztrseihowebkyksyaseiymd}</td><td>（取込用）生保Ｗｅｂ契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkyksyaseikbn ztrseihowebkyksyaseikbn}</td><td>（取込用）生保Ｗｅｂ契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkykkihontikucd ztrseihowebkykkihontikucd}</td><td>（取込用）生保Ｗｅｂ契約者基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkykadr ztrseihowebkykadr}</td><td>（取込用）生保Ｗｅｂ契約者住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhknsyuruino ztrseihowebhknsyuruino}</td><td>（取込用）生保Ｗｅｂ保険種類番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhjkktkbn ztrseihowebhjkktkbn}</td><td>（取込用）生保Ｗｅｂ報状告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhknkkn ztrseihowebhknkkn}</td><td>（取込用）生保Ｗｅｂ保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebphrkkikn ztrseihowebphrkkikn}</td><td>（取込用）生保ＷｅｂＰ払込期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebhrkkaisuukbn ztrseihowebhrkkaisuukbn}</td><td>（取込用）生保Ｗｅｂ払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhrkkeirokbn ztrseihowebhrkkeirokbn}</td><td>（取込用）生保Ｗｅｂ払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsdpdkbn ztrseihowebsdpdkbn}</td><td>（取込用）生保ＷｅｂＳ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkihons ztrseihowebkihons}</td><td>（取込用）生保Ｗｅｂ基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebnksyuruikbn ztrseihowebnksyuruikbn}</td><td>（取込用）生保Ｗｅｂ年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihoweblntkkbn ztrseihoweblntkkbn}</td><td>（取込用）生保ＷｅｂＬＮ特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebnkshrarihyj ztrseihowebnkshrarihyj}</td><td>（取込用）生保Ｗｅｂ年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmosno ztrseihowebmosno}</td><td>（取込用）生保Ｗｅｂ申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsekykkigenymd ztrseihowebsekykkigenymd}</td><td>（取込用）生保Ｗｅｂ設計書有効期限年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsksjsitencd ztrseihowebsksjsitencd}</td><td>（取込用）生保Ｗｅｂ作成時支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktnrkkbn ztrseihowebsbuktnrkkbn}</td><td>（取込用）生保Ｗｅｂ死亡受取人入力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbukttdkkbn ztrseihowebsbukttdkkbn}</td><td>（取込用）生保Ｗｅｂ死亡受取人続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktknnm ztrseihowebsbuktknnm}</td><td>（取込用）生保Ｗｅｂ死亡受取人カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktkjnm ztrseihowebsbuktkjnm}</td><td>（取込用）生保Ｗｅｂ死亡受取人漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbuktseiymd ztrseihowebsbuktseiymd}</td><td>（取込用）生保Ｗｅｂ死亡受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmosprtzmhyj ztrseihowebmosprtzmhyj}</td><td>（取込用）生保Ｗｅｂ申込書印刷済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebfstmossksymd ztrseihowebfstmossksymd}</td><td>（取込用）生保Ｗｅｂ初回申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhnsyukyktdkkbn ztrseihowebhnsyukyktdkkbn}</td><td>（取込用）生保Ｗｅｂ編集後契約者続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebbsyutrkno ztrseihowebbsyutrkno}</td><td>（取込用）生保Ｗｅｂ募集人登録番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhjnkitikbn ztrseihowebhjnkitikbn}</td><td>（取込用）生保Ｗｅｂ法人形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhjnkykhyj ztrseihowebhjnkykhyj}</td><td>（取込用）生保Ｗｅｂ法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtksykmcd1 ztrseihowebtksykmcd1}</td><td>（取込用）生保Ｗｅｂ特殊項目コード１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtksykmcd2 ztrseihowebtksykmcd2}</td><td>（取込用）生保Ｗｅｂ特殊項目コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtksykmcd3 ztrseihowebtksykmcd3}</td><td>（取込用）生保Ｗｅｂ特殊項目コード３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtksykmcd4 ztrseihowebtksykmcd4}</td><td>（取込用）生保Ｗｅｂ特殊項目コード４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtksykmcd5 ztrseihowebtksykmcd5}</td><td>（取込用）生保Ｗｅｂ特殊項目コード５　</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebteiwkkn ztrseihowebteiwkkn}</td><td>（取込用）生保Ｗｅｂ低Ｗ期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhkntelno ztrseihowebhhkntelno}</td><td>（取込用）生保Ｗｅｂ被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkyktelno ztrseihowebkyktelno}</td><td>（取込用）生保Ｗｅｂ契約者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebknhjnnm ztrseihowebknhjnnm}</td><td>（取込用）生保Ｗｅｂカナ法人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkjhjnnm ztrseihowebkjhjnnm}</td><td>（取込用）生保Ｗｅｂ漢字法人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkndaihyounm ztrseihowebkndaihyounm}</td><td>（取込用）生保Ｗｅｂカナ代表者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkjdaihyounm ztrseihowebkjdaihyounm}</td><td>（取込用）生保Ｗｅｂ漢字代表者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdaihyouktgkkbn ztrseihowebdaihyouktgkkbn}</td><td>（取込用）生保Ｗｅｂ代表者肩書区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsykihrkp1 ztrseihowebsykihrkp1}</td><td>（取込用）生保Ｗｅｂ初回払込Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebmosp1 ztrseihowebmosp1}</td><td>（取込用）生保Ｗｅｂ申込Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebtkiyougyoutaikbn ztrseihowebtkiyougyoutaikbn}</td><td>（取込用）生保Ｗｅｂ統計用業態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebpaperlessmoshyj ztrseihowebpaperlessmoshyj}</td><td>（取込用）生保Ｗｅｂペーパーレス申込表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdatasousinzmhyj ztrseihowebdatasousinzmhyj}</td><td>（取込用）生保Ｗｅｂデータ送信済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebdrtnskno ztrseihowebdrtnskno}</td><td>（取込用）生保Ｗｅｂ代理店設計書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsbnksyukbn ztrseihowebsbnksyukbn}</td><td>（取込用）生保Ｗｅｂ死亡年金種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebaatkisyaknyuucd ztrseihowebaatkisyaknyuucd}</td><td>（取込用）生保ＷｅｂＡ扱者金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkeihidouituhyj ztrseihowebkeihidouituhyj}</td><td>（取込用）生保Ｗｅｂ契被同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebsiteituukakbn ztrseihowebsiteituukakbn}</td><td>（取込用）生保Ｗｅｂ指定通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebnykntuukakbn ztrseihowebnykntuukakbn}</td><td>（取込用）生保Ｗｅｂ入金通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtargettkarihyj ztrseihowebtargettkarihyj}</td><td>（取込用）生保Ｗｅｂターゲット特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtargettkkbn ztrseihowebtargettkkbn}</td><td>（取込用）生保Ｗｅｂターゲット特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebtargettkmkht ztrseihowebtargettkmkht}</td><td>（取込用）生保Ｗｅｂターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebnykntuukanykngk ztrseihowebnykntuukanykngk}</td><td>（取込用）生保Ｗｅｂ入金通貨入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebnykntukfsthrkp ztrseihowebnykntukfsthrkp}</td><td>（取込用）生保Ｗｅｂ入金通貨初回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebnykntuknexthrkp ztrseihowebnykntuknexthrkp}</td><td>（取込用）生保Ｗｅｂ入金通貨次回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebsaimankihyj ztrseihowebsaimankihyj}</td><td>（取込用）生保Ｗｅｂ才満期表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebrayhyj ztrseihowebrayhyj}</td><td>（取込用）生保ＷｅｂＲＡＹ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebgnykntuknykngk ztrseihowebgnykntuknykngk}</td><td>（取込用）生保Ｗｅｂ外貨入金通貨入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebgnykntukfsthrkp ztrseihowebgnykntukfsthrkp}</td><td>（取込用）生保Ｗｅｂ外貨入金通貨初回Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebgnykntuknxthrkp ztrseihowebgnykntuknxthrkp}</td><td>（取込用）生保Ｗｅｂ外貨入金通貨次回Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebgaikakihonp ztrseihowebgaikakihonp}</td><td>（取込用）生保Ｗｅｂ外貨基本Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebkaigmehrtkarihyj ztrseihowebkaigmehrtkarihyj}</td><td>（取込用）生保Ｗｅｂ介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebyenhsyutkarihyj ztrseihowebyenhsyutkarihyj}</td><td>（取込用）生保Ｗｅｂ円最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebgaikakihons ztrseihowebgaikakihons}</td><td>（取込用）生保Ｗｅｂ外貨基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebdai1hknkkn ztrseihowebdai1hknkkn}</td><td>（取込用）生保Ｗｅｂ第１保険期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebkyksykgycd ztrseihowebkyksykgycd}</td><td>（取込用）生保Ｗｅｂ契約者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkknmskhjnkitikbn ztrseihowebkknmskhjnkitikbn}</td><td>（取込用）生保Ｗｅｂ契勤務先法人形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkykottmsk ztrseihowebkykottmsk}</td><td>（取込用）生保Ｗｅｂ契約者お勤め先</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknsykgycd ztrseihowebhhknsykgycd}</td><td>（取込用）生保Ｗｅｂ被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhknmskhjnkitikbn ztrseihowebhknmskhjnkitikbn}</td><td>（取込用）生保Ｗｅｂ被勤務先法人形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknottmsk ztrseihowebhhknottmsk}</td><td>（取込用）生保Ｗｅｂ被保険者お勤め先</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhhknnensyuukbn ztrseihowebhhknnensyuukbn}</td><td>（取込用）生保Ｗｅｂ被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhhknkjnm ztrseihowebplhhknkjnm}</td><td>（取込用）生保ＷｅｂＰＬ被保険者漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplkykkjnm ztrseihowebplkykkjnm}</td><td>（取込用）生保ＷｅｂＰＬ契約者漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhrkkeirokbn ztrseihowebplhrkkeirokbn}</td><td>（取込用）生保ＷｅｂＰＬ払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplsbuktnrkkbn ztrseihowebplsbuktnrkkbn}</td><td>（取込用）生保ＷｅｂＰＬ死亡受入力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplsbukttdkkbn ztrseihowebplsbukttdkkbn}</td><td>（取込用）生保ＷｅｂＰＬ死亡受続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplsbuktknnm ztrseihowebplsbuktknnm}</td><td>（取込用）生保ＷｅｂＰＬ死亡受カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplsbuktkjnm ztrseihowebplsbuktkjnm}</td><td>（取込用）生保ＷｅｂＰＬ死亡受漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplsbuktseiymd ztrseihowebplsbuktseiymd}</td><td>（取込用）生保ＷｅｂＰＬ死亡受生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhhkntelno ztrseihowebplhhkntelno}</td><td>（取込用）生保ＷｅｂＰＬ被保険者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplkyktelno ztrseihowebplkyktelno}</td><td>（取込用）生保ＷｅｂＰＬ契約者電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplkihontikucd ztrseihowebplkihontikucd}</td><td>（取込用）生保ＷｅｂＰＬ基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebpltsinadrkai ztrseihowebpltsinadrkai}</td><td>（取込用）生保ＷｅｂＰＬ通信先住所下位</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhiikihontikucd ztrseihowebplhiikihontikucd}</td><td>（取込用）生保ＷｅｂＰＬ被基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebplhhknadr ztrseihowebplhhknadr}</td><td>（取込用）生保ＷｅｂＰＬ被保険者住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebhnyppltzmhyj ztrseihowebhnyppltzmhyj}</td><td>（取込用）生保Ｗｅｂ汎用ＰＰＬ対応済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebssrndhbnwr ztrseihowebssrndhbnwr}</td><td>（取込用）生保Ｗｅｂ指数連動部分配分割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebtrtrndhbnwr ztrseihowebtrtrndhbnwr}</td><td>（取込用）生保Ｗｅｂ定率積立部分配分割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebsueokikkn ztrseihowebsueokikkn}</td><td>（取込用）生保Ｗｅｂ据置期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebmnkuktnrkkbn ztrseihowebmnkuktnrkkbn}</td><td>（取込用）生保Ｗｅｂ満期受取人入力区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmnkukttdkkbn ztrseihowebmnkukttdkkbn}</td><td>（取込用）生保Ｗｅｂ満期受取人続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmnkuktknnm ztrseihowebmnkuktknnm}</td><td>（取込用）生保Ｗｅｂ満期受取人カナ氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmnkuktkjnm ztrseihowebmnkuktkjnm}</td><td>（取込用）生保Ｗｅｂ満期受取人漢字氏名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebmnkuktseiymd ztrseihowebmnkuktseiymd}</td><td>（取込用）生保Ｗｅｂ満期受取人生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebankenkanrino ztrseihowebankenkanrino}</td><td>（取込用）生保Ｗｅｂ案件管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebikkatup ztrseihowebikkatup}</td><td>（取込用）生保Ｗｅｂ一括払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebikkatubaraikbn ztrseihowebikkatubaraikbn}</td><td>（取込用）生保Ｗｅｂ一括払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebiktbrikaisuu ztrseihowebiktbrikaisuu}</td><td>（取込用）生保Ｗｅｂ一括払回数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebzennoup ztrseihowebzennoup}</td><td>（取込用）生保Ｗｅｂ前納Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebgaikazennoup ztrseihowebgaikazennoup}</td><td>（取込用）生保Ｗｅｂ外貨前納Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtrseihowebzennoukkn ztrseihowebzennoukkn}</td><td>（取込用）生保Ｗｅｂ前納期間</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtrseihowebzennouhyj ztrseihowebzennouhyj}</td><td>（取込用）生保Ｗｅｂ前納表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkydbosyuukjncd ztrseihowebkydbosyuukjncd}</td><td>（取込用）生保Ｗｅｂ共同募集個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzktrkmoskbn ztrseihowebkzktrkmoskbn}</td><td>（取込用）生保Ｗｅｂご家族登録申込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzktdkkbn1 ztrseihowebkzktdkkbn1}</td><td>（取込用）生保Ｗｅｂご家族続柄区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkknnm1 ztrseihowebkzkknnm1}</td><td>（取込用）生保Ｗｅｂご家族カナ氏名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkkjnm1 ztrseihowebkzkkjnm1}</td><td>（取込用）生保Ｗｅｂご家族漢字氏名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkseikbn1 ztrseihowebkzkseikbn1}</td><td>（取込用）生保Ｗｅｂご家族性別区分１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtrseihowebkzkseiymd1 ztrseihowebkzkseiymd1}</td><td>（取込用）生保Ｗｅｂご家族生年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>{@link #getZtrseihowebhhkndrseiymd ztrseihowebhhkndrseiymd}</td><td>（取込用）生保Ｗｅｂ被代理生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TiginSinkinBosTr
 * @see     PKZT_TiginSinkinBosTr
 * @see     QZT_TiginSinkinBosTr
 * @see     GenQZT_TiginSinkinBosTr
 */
@MappedSuperclass
@Table(name=GenZT_TiginSinkinBosTr.TABLE_NAME)
@IdClass(value=PKZT_TiginSinkinBosTr.class)
public abstract class GenZT_TiginSinkinBosTr extends AbstractExDBEntity<ZT_TiginSinkinBosTr, PKZT_TiginSinkinBosTr> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TiginSinkinBosTr";
    public static final String ZTRSEIHOWEBIDKBN         = "ztrseihowebidkbn";
    public static final String ZTRSEIHOWEBKOJINCD       = "ztrseihowebkojincd";
    public static final String ZTRSEIHOWEBITIJIHOZONHYOUJI = "ztrseihowebitijihozonhyouji";
    public static final String ZTRSEIHOWEBSEKNO         = "ztrseihowebsekno";
    public static final String ZTRSEIHOWEBCALCKIJYUNYMD = "ztrseihowebcalckijyunymd";
    public static final String ZTRSEIHOWEBHHKNKNNM      = "ztrseihowebhhknknnm";
    public static final String ZTRSEIHOWEBHHKNKJNM      = "ztrseihowebhhknkjnm";
    public static final String ZTRSEIHOWEBHHKNSEIYMD    = "ztrseihowebhhknseiymd";
    public static final String ZTRSEIHOWEBHHKNSEIKBN    = "ztrseihowebhhknseikbn";
    public static final String ZTRSEIHOWEBMRHKIHONTIKUCD = "ztrseihowebmrhkihontikucd";
    public static final String ZTRSEIHOWEBHHKNADR       = "ztrseihowebhhknadr";
    public static final String ZTRSEIHOWEBKYKKNNM       = "ztrseihowebkykknnm";
    public static final String ZTRSEIHOWEBKYKKJNM       = "ztrseihowebkykkjnm";
    public static final String ZTRSEIHOWEBKYKSYASEIYMD  = "ztrseihowebkyksyaseiymd";
    public static final String ZTRSEIHOWEBKYKSYASEIKBN  = "ztrseihowebkyksyaseikbn";
    public static final String ZTRSEIHOWEBKYKKIHONTIKUCD = "ztrseihowebkykkihontikucd";
    public static final String ZTRSEIHOWEBKYKADR        = "ztrseihowebkykadr";
    public static final String ZTRSEIHOWEBHKNSYURUINO   = "ztrseihowebhknsyuruino";
    public static final String ZTRSEIHOWEBHJKKTKBN      = "ztrseihowebhjkktkbn";
    public static final String ZTRSEIHOWEBHKNKKN        = "ztrseihowebhknkkn";
    public static final String ZTRSEIHOWEBPHRKKIKN      = "ztrseihowebphrkkikn";
    public static final String ZTRSEIHOWEBHRKKAISUUKBN  = "ztrseihowebhrkkaisuukbn";
    public static final String ZTRSEIHOWEBHRKKEIROKBN   = "ztrseihowebhrkkeirokbn";
    public static final String ZTRSEIHOWEBSDPDKBN       = "ztrseihowebsdpdkbn";
    public static final String ZTRSEIHOWEBKIHONS        = "ztrseihowebkihons";
    public static final String ZTRSEIHOWEBNKSYURUIKBN   = "ztrseihowebnksyuruikbn";
    public static final String ZTRSEIHOWEBLNTKKBN       = "ztrseihoweblntkkbn";
    public static final String ZTRSEIHOWEBNKSHRARIHYJ   = "ztrseihowebnkshrarihyj";
    public static final String ZTRSEIHOWEBMOSNO         = "ztrseihowebmosno";
    public static final String ZTRSEIHOWEBSEKYKKIGENYMD = "ztrseihowebsekykkigenymd";
    public static final String ZTRSEIHOWEBSKSJSITENCD   = "ztrseihowebsksjsitencd";
    public static final String ZTRSEIHOWEBSBUKTNRKKBN   = "ztrseihowebsbuktnrkkbn";
    public static final String ZTRSEIHOWEBSBUKTTDKKBN   = "ztrseihowebsbukttdkkbn";
    public static final String ZTRSEIHOWEBSBUKTKNNM     = "ztrseihowebsbuktknnm";
    public static final String ZTRSEIHOWEBSBUKTKJNM     = "ztrseihowebsbuktkjnm";
    public static final String ZTRSEIHOWEBSBUKTSEIYMD   = "ztrseihowebsbuktseiymd";
    public static final String ZTRSEIHOWEBMOSPRTZMHYJ   = "ztrseihowebmosprtzmhyj";
    public static final String ZTRSEIHOWEBFSTMOSSKSYMD  = "ztrseihowebfstmossksymd";
    public static final String ZTRSEIHOWEBHNSYUKYKTDKKBN = "ztrseihowebhnsyukyktdkkbn";
    public static final String ZTRSEIHOWEBBSYUTRKNO     = "ztrseihowebbsyutrkno";
    public static final String ZTRSEIHOWEBHJNKITIKBN    = "ztrseihowebhjnkitikbn";
    public static final String ZTRSEIHOWEBHJNKYKHYJ     = "ztrseihowebhjnkykhyj";
    public static final String ZTRSEIHOWEBTKSYKMCD1     = "ztrseihowebtksykmcd1";
    public static final String ZTRSEIHOWEBTKSYKMCD2     = "ztrseihowebtksykmcd2";
    public static final String ZTRSEIHOWEBTKSYKMCD3     = "ztrseihowebtksykmcd3";
    public static final String ZTRSEIHOWEBTKSYKMCD4     = "ztrseihowebtksykmcd4";
    public static final String ZTRSEIHOWEBTKSYKMCD5     = "ztrseihowebtksykmcd5";
    public static final String ZTRSEIHOWEBTEIWKKN       = "ztrseihowebteiwkkn";
    public static final String ZTRSEIHOWEBHHKNTELNO     = "ztrseihowebhhkntelno";
    public static final String ZTRSEIHOWEBKYKTELNO      = "ztrseihowebkyktelno";
    public static final String ZTRSEIHOWEBKNHJNNM       = "ztrseihowebknhjnnm";
    public static final String ZTRSEIHOWEBKJHJNNM       = "ztrseihowebkjhjnnm";
    public static final String ZTRSEIHOWEBKNDAIHYOUNM   = "ztrseihowebkndaihyounm";
    public static final String ZTRSEIHOWEBKJDAIHYOUNM   = "ztrseihowebkjdaihyounm";
    public static final String ZTRSEIHOWEBDAIHYOUKTGKKBN = "ztrseihowebdaihyouktgkkbn";
    public static final String ZTRSEIHOWEBSYKIHRKP1     = "ztrseihowebsykihrkp1";
    public static final String ZTRSEIHOWEBMOSP1         = "ztrseihowebmosp1";
    public static final String ZTRSEIHOWEBTKIYOUGYOUTAIKBN = "ztrseihowebtkiyougyoutaikbn";
    public static final String ZTRSEIHOWEBPAPERLESSMOSHYJ = "ztrseihowebpaperlessmoshyj";
    public static final String ZTRSEIHOWEBDATASOUSINZMHYJ = "ztrseihowebdatasousinzmhyj";
    public static final String ZTRSEIHOWEBDRTNSKNO      = "ztrseihowebdrtnskno";
    public static final String ZTRSEIHOWEBSBNKSYUKBN    = "ztrseihowebsbnksyukbn";
    public static final String ZTRSEIHOWEBAATKISYAKNYUUCD = "ztrseihowebaatkisyaknyuucd";
    public static final String ZTRSEIHOWEBKEIHIDOUITUHYJ = "ztrseihowebkeihidouituhyj";
    public static final String ZTRSEIHOWEBSITEITUUKAKBN = "ztrseihowebsiteituukakbn";
    public static final String ZTRSEIHOWEBNYKNTUUKAKBN  = "ztrseihowebnykntuukakbn";
    public static final String ZTRSEIHOWEBTARGETTKARIHYJ = "ztrseihowebtargettkarihyj";
    public static final String ZTRSEIHOWEBTARGETTKKBN   = "ztrseihowebtargettkkbn";
    public static final String ZTRSEIHOWEBTARGETTKMKHT  = "ztrseihowebtargettkmkht";
    public static final String ZTRSEIHOWEBNYKNTUUKANYKNGK = "ztrseihowebnykntuukanykngk";
    public static final String ZTRSEIHOWEBNYKNTUKFSTHRKP = "ztrseihowebnykntukfsthrkp";
    public static final String ZTRSEIHOWEBNYKNTUKNEXTHRKP = "ztrseihowebnykntuknexthrkp";
    public static final String ZTRSEIHOWEBSAIMANKIHYJ   = "ztrseihowebsaimankihyj";
    public static final String ZTRSEIHOWEBRAYHYJ        = "ztrseihowebrayhyj";
    public static final String ZTRSEIHOWEBGNYKNTUKNYKNGK = "ztrseihowebgnykntuknykngk";
    public static final String ZTRSEIHOWEBGNYKNTUKFSTHRKP = "ztrseihowebgnykntukfsthrkp";
    public static final String ZTRSEIHOWEBGNYKNTUKNXTHRKP = "ztrseihowebgnykntuknxthrkp";
    public static final String ZTRSEIHOWEBGAIKAKIHONP   = "ztrseihowebgaikakihonp";
    public static final String ZTRSEIHOWEBKAIGMEHRTKARIHYJ = "ztrseihowebkaigmehrtkarihyj";
    public static final String ZTRSEIHOWEBYENHSYUTKARIHYJ = "ztrseihowebyenhsyutkarihyj";
    public static final String ZTRSEIHOWEBGAIKAKIHONS   = "ztrseihowebgaikakihons";
    public static final String ZTRSEIHOWEBDAI1HKNKKN    = "ztrseihowebdai1hknkkn";
    public static final String ZTRSEIHOWEBKYKSYKGYCD    = "ztrseihowebkyksykgycd";
    public static final String ZTRSEIHOWEBKKNMSKHJNKITIKBN = "ztrseihowebkknmskhjnkitikbn";
    public static final String ZTRSEIHOWEBKYKOTTMSK     = "ztrseihowebkykottmsk";
    public static final String ZTRSEIHOWEBHHKNSYKGYCD   = "ztrseihowebhhknsykgycd";
    public static final String ZTRSEIHOWEBHKNMSKHJNKITIKBN = "ztrseihowebhknmskhjnkitikbn";
    public static final String ZTRSEIHOWEBHHKNOTTMSK    = "ztrseihowebhhknottmsk";
    public static final String ZTRSEIHOWEBHHKNNENSYUUKBN = "ztrseihowebhhknnensyuukbn";
    public static final String ZTRSEIHOWEBPLHHKNKJNM    = "ztrseihowebplhhknkjnm";
    public static final String ZTRSEIHOWEBPLKYKKJNM     = "ztrseihowebplkykkjnm";
    public static final String ZTRSEIHOWEBPLHRKKEIROKBN = "ztrseihowebplhrkkeirokbn";
    public static final String ZTRSEIHOWEBPLSBUKTNRKKBN = "ztrseihowebplsbuktnrkkbn";
    public static final String ZTRSEIHOWEBPLSBUKTTDKKBN = "ztrseihowebplsbukttdkkbn";
    public static final String ZTRSEIHOWEBPLSBUKTKNNM   = "ztrseihowebplsbuktknnm";
    public static final String ZTRSEIHOWEBPLSBUKTKJNM   = "ztrseihowebplsbuktkjnm";
    public static final String ZTRSEIHOWEBPLSBUKTSEIYMD = "ztrseihowebplsbuktseiymd";
    public static final String ZTRSEIHOWEBPLHHKNTELNO   = "ztrseihowebplhhkntelno";
    public static final String ZTRSEIHOWEBPLKYKTELNO    = "ztrseihowebplkyktelno";
    public static final String ZTRSEIHOWEBPLKIHONTIKUCD = "ztrseihowebplkihontikucd";
    public static final String ZTRSEIHOWEBPLTSINADRKAI  = "ztrseihowebpltsinadrkai";
    public static final String ZTRSEIHOWEBPLHIIKIHONTIKUCD = "ztrseihowebplhiikihontikucd";
    public static final String ZTRSEIHOWEBPLHHKNADR     = "ztrseihowebplhhknadr";
    public static final String ZTRSEIHOWEBHNYPPLTZMHYJ  = "ztrseihowebhnyppltzmhyj";
    public static final String ZTRSEIHOWEBSSRNDHBNWR    = "ztrseihowebssrndhbnwr";
    public static final String ZTRSEIHOWEBTRTRNDHBNWR   = "ztrseihowebtrtrndhbnwr";
    public static final String ZTRSEIHOWEBSUEOKIKKN     = "ztrseihowebsueokikkn";
    public static final String ZTRSEIHOWEBMNKUKTNRKKBN  = "ztrseihowebmnkuktnrkkbn";
    public static final String ZTRSEIHOWEBMNKUKTTDKKBN  = "ztrseihowebmnkukttdkkbn";
    public static final String ZTRSEIHOWEBMNKUKTKNNM    = "ztrseihowebmnkuktknnm";
    public static final String ZTRSEIHOWEBMNKUKTKJNM    = "ztrseihowebmnkuktkjnm";
    public static final String ZTRSEIHOWEBMNKUKTSEIYMD  = "ztrseihowebmnkuktseiymd";
    public static final String ZTRSEIHOWEBANKENKANRINO  = "ztrseihowebankenkanrino";
    public static final String ZTRSEIHOWEBIKKATUP       = "ztrseihowebikkatup";
    public static final String ZTRSEIHOWEBIKKATUBARAIKBN = "ztrseihowebikkatubaraikbn";
    public static final String ZTRSEIHOWEBIKTBRIKAISUU  = "ztrseihowebiktbrikaisuu";
    public static final String ZTRSEIHOWEBZENNOUP       = "ztrseihowebzennoup";
    public static final String ZTRSEIHOWEBGAIKAZENNOUP  = "ztrseihowebgaikazennoup";
    public static final String ZTRSEIHOWEBZENNOUKKN     = "ztrseihowebzennoukkn";
    public static final String ZTRSEIHOWEBZENNOUHYJ     = "ztrseihowebzennouhyj";
    public static final String ZTRSEIHOWEBKYDBOSYUUKJNCD = "ztrseihowebkydbosyuukjncd";
    public static final String ZTRSEIHOWEBKZKTRKMOSKBN  = "ztrseihowebkzktrkmoskbn";
    public static final String ZTRSEIHOWEBKZKTDKKBN1    = "ztrseihowebkzktdkkbn1";
    public static final String ZTRSEIHOWEBKZKKNNM1      = "ztrseihowebkzkknnm1";
    public static final String ZTRSEIHOWEBKZKKJNM1      = "ztrseihowebkzkkjnm1";
    public static final String ZTRSEIHOWEBKZKSEIKBN1    = "ztrseihowebkzkseikbn1";
    public static final String ZTRSEIHOWEBKZKSEIYMD1    = "ztrseihowebkzkseiymd1";
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
    public static final String ZTRSEIHOWEBHHKNDRSEIYMD  = "ztrseihowebhhkndrseiymd";

    private final PKZT_TiginSinkinBosTr primaryKey;

    public GenZT_TiginSinkinBosTr() {
        primaryKey = new PKZT_TiginSinkinBosTr();
    }

    public GenZT_TiginSinkinBosTr(
        String pZtrseihowebidkbn,
        String pZtrseihowebkojincd,
        String pZtrseihowebitijihozonhyouji,
        Integer pZtrseihowebsekno
    ) {
        primaryKey = new PKZT_TiginSinkinBosTr(
            pZtrseihowebidkbn,
            pZtrseihowebkojincd,
            pZtrseihowebitijihozonhyouji,
            pZtrseihowebsekno
        );
    }

    @Transient
    @Override
    public PKZT_TiginSinkinBosTr getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TiginSinkinBosTr> getMetaClass() {
        return QZT_TiginSinkinBosTr.class;
    }

    @Id
    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBIDKBN)
    public String getZtrseihowebidkbn() {
        return getPrimaryKey().getZtrseihowebidkbn();
    }

    public void setZtrseihowebidkbn(String pZtrseihowebidkbn) {
        getPrimaryKey().setZtrseihowebidkbn(pZtrseihowebidkbn);
    }

    @Id
    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKOJINCD)
    public String getZtrseihowebkojincd() {
        return getPrimaryKey().getZtrseihowebkojincd();
    }

    public void setZtrseihowebkojincd(String pZtrseihowebkojincd) {
        getPrimaryKey().setZtrseihowebkojincd(pZtrseihowebkojincd);
    }

    @Id
    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBITIJIHOZONHYOUJI)
    public String getZtrseihowebitijihozonhyouji() {
        return getPrimaryKey().getZtrseihowebitijihozonhyouji();
    }

    public void setZtrseihowebitijihozonhyouji(String pZtrseihowebitijihozonhyouji) {
        getPrimaryKey().setZtrseihowebitijihozonhyouji(pZtrseihowebitijihozonhyouji);
    }

    @Id
    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSEKNO)
    public Integer getZtrseihowebsekno() {
        return getPrimaryKey().getZtrseihowebsekno();
    }

    public void setZtrseihowebsekno(Integer pZtrseihowebsekno) {
        getPrimaryKey().setZtrseihowebsekno(pZtrseihowebsekno);
    }

    private String ztrseihowebcalckijyunymd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBCALCKIJYUNYMD)
    public String getZtrseihowebcalckijyunymd() {
        return ztrseihowebcalckijyunymd;
    }

    public void setZtrseihowebcalckijyunymd(String pZtrseihowebcalckijyunymd) {
        ztrseihowebcalckijyunymd = pZtrseihowebcalckijyunymd;
    }

    private String ztrseihowebhhknknnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNKNNM)
    public String getZtrseihowebhhknknnm() {
        return ztrseihowebhhknknnm;
    }

    public void setZtrseihowebhhknknnm(String pZtrseihowebhhknknnm) {
        ztrseihowebhhknknnm = pZtrseihowebhhknknnm;
    }

    private String ztrseihowebhhknkjnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNKJNM)
    public String getZtrseihowebhhknkjnm() {
        return ztrseihowebhhknkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhhknkjnm(String pZtrseihowebhhknkjnm) {
        ztrseihowebhhknkjnm = pZtrseihowebhhknkjnm;
    }

    private String ztrseihowebhhknseiymd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNSEIYMD)
    public String getZtrseihowebhhknseiymd() {
        return ztrseihowebhhknseiymd;
    }

    public void setZtrseihowebhhknseiymd(String pZtrseihowebhhknseiymd) {
        ztrseihowebhhknseiymd = pZtrseihowebhhknseiymd;
    }

    private String ztrseihowebhhknseikbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNSEIKBN)
    public String getZtrseihowebhhknseikbn() {
        return ztrseihowebhhknseikbn;
    }

    public void setZtrseihowebhhknseikbn(String pZtrseihowebhhknseikbn) {
        ztrseihowebhhknseikbn = pZtrseihowebhhknseikbn;
    }

    private String ztrseihowebmrhkihontikucd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBMRHKIHONTIKUCD)
    public String getZtrseihowebmrhkihontikucd() {
        return ztrseihowebmrhkihontikucd;
    }

    public void setZtrseihowebmrhkihontikucd(String pZtrseihowebmrhkihontikucd) {
        ztrseihowebmrhkihontikucd = pZtrseihowebmrhkihontikucd;
    }

    private String ztrseihowebhhknadr;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNADR)
    public String getZtrseihowebhhknadr() {
        return ztrseihowebhhknadr;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhhknadr(String pZtrseihowebhhknadr) {
        ztrseihowebhhknadr = pZtrseihowebhhknadr;
    }

    private String ztrseihowebkykknnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKKNNM)
    public String getZtrseihowebkykknnm() {
        return ztrseihowebkykknnm;
    }

    public void setZtrseihowebkykknnm(String pZtrseihowebkykknnm) {
        ztrseihowebkykknnm = pZtrseihowebkykknnm;
    }

    private String ztrseihowebkykkjnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKKJNM)
    public String getZtrseihowebkykkjnm() {
        return ztrseihowebkykkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkykkjnm(String pZtrseihowebkykkjnm) {
        ztrseihowebkykkjnm = pZtrseihowebkykkjnm;
    }

    private String ztrseihowebkyksyaseiymd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKSYASEIYMD)
    public String getZtrseihowebkyksyaseiymd() {
        return ztrseihowebkyksyaseiymd;
    }

    public void setZtrseihowebkyksyaseiymd(String pZtrseihowebkyksyaseiymd) {
        ztrseihowebkyksyaseiymd = pZtrseihowebkyksyaseiymd;
    }

    private String ztrseihowebkyksyaseikbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKSYASEIKBN)
    public String getZtrseihowebkyksyaseikbn() {
        return ztrseihowebkyksyaseikbn;
    }

    public void setZtrseihowebkyksyaseikbn(String pZtrseihowebkyksyaseikbn) {
        ztrseihowebkyksyaseikbn = pZtrseihowebkyksyaseikbn;
    }

    private String ztrseihowebkykkihontikucd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKKIHONTIKUCD)
    public String getZtrseihowebkykkihontikucd() {
        return ztrseihowebkykkihontikucd;
    }

    public void setZtrseihowebkykkihontikucd(String pZtrseihowebkykkihontikucd) {
        ztrseihowebkykkihontikucd = pZtrseihowebkykkihontikucd;
    }

    private String ztrseihowebkykadr;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKADR)
    public String getZtrseihowebkykadr() {
        return ztrseihowebkykadr;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkykadr(String pZtrseihowebkykadr) {
        ztrseihowebkykadr = pZtrseihowebkykadr;
    }

    private String ztrseihowebhknsyuruino;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHKNSYURUINO)
    public String getZtrseihowebhknsyuruino() {
        return ztrseihowebhknsyuruino;
    }

    public void setZtrseihowebhknsyuruino(String pZtrseihowebhknsyuruino) {
        ztrseihowebhknsyuruino = pZtrseihowebhknsyuruino;
    }

    private String ztrseihowebhjkktkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHJKKTKBN)
    public String getZtrseihowebhjkktkbn() {
        return ztrseihowebhjkktkbn;
    }

    public void setZtrseihowebhjkktkbn(String pZtrseihowebhjkktkbn) {
        ztrseihowebhjkktkbn = pZtrseihowebhjkktkbn;
    }

    private Integer ztrseihowebhknkkn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHKNKKN)
    public Integer getZtrseihowebhknkkn() {
        return ztrseihowebhknkkn;
    }

    public void setZtrseihowebhknkkn(Integer pZtrseihowebhknkkn) {
        ztrseihowebhknkkn = pZtrseihowebhknkkn;
    }

    private Integer ztrseihowebphrkkikn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPHRKKIKN)
    public Integer getZtrseihowebphrkkikn() {
        return ztrseihowebphrkkikn;
    }

    public void setZtrseihowebphrkkikn(Integer pZtrseihowebphrkkikn) {
        ztrseihowebphrkkikn = pZtrseihowebphrkkikn;
    }

    private String ztrseihowebhrkkaisuukbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHRKKAISUUKBN)
    public String getZtrseihowebhrkkaisuukbn() {
        return ztrseihowebhrkkaisuukbn;
    }

    public void setZtrseihowebhrkkaisuukbn(String pZtrseihowebhrkkaisuukbn) {
        ztrseihowebhrkkaisuukbn = pZtrseihowebhrkkaisuukbn;
    }

    private String ztrseihowebhrkkeirokbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHRKKEIROKBN)
    public String getZtrseihowebhrkkeirokbn() {
        return ztrseihowebhrkkeirokbn;
    }

    public void setZtrseihowebhrkkeirokbn(String pZtrseihowebhrkkeirokbn) {
        ztrseihowebhrkkeirokbn = pZtrseihowebhrkkeirokbn;
    }

    private String ztrseihowebsdpdkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSDPDKBN)
    public String getZtrseihowebsdpdkbn() {
        return ztrseihowebsdpdkbn;
    }

    public void setZtrseihowebsdpdkbn(String pZtrseihowebsdpdkbn) {
        ztrseihowebsdpdkbn = pZtrseihowebsdpdkbn;
    }

    private Long ztrseihowebkihons;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKIHONS)
    public Long getZtrseihowebkihons() {
        return ztrseihowebkihons;
    }

    public void setZtrseihowebkihons(Long pZtrseihowebkihons) {
        ztrseihowebkihons = pZtrseihowebkihons;
    }

    private String ztrseihowebnksyuruikbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBNKSYURUIKBN)
    public String getZtrseihowebnksyuruikbn() {
        return ztrseihowebnksyuruikbn;
    }

    public void setZtrseihowebnksyuruikbn(String pZtrseihowebnksyuruikbn) {
        ztrseihowebnksyuruikbn = pZtrseihowebnksyuruikbn;
    }

    private String ztrseihoweblntkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBLNTKKBN)
    public String getZtrseihoweblntkkbn() {
        return ztrseihoweblntkkbn;
    }

    public void setZtrseihoweblntkkbn(String pZtrseihoweblntkkbn) {
        ztrseihoweblntkkbn = pZtrseihoweblntkkbn;
    }

    private String ztrseihowebnkshrarihyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBNKSHRARIHYJ)
    public String getZtrseihowebnkshrarihyj() {
        return ztrseihowebnkshrarihyj;
    }

    public void setZtrseihowebnkshrarihyj(String pZtrseihowebnkshrarihyj) {
        ztrseihowebnkshrarihyj = pZtrseihowebnkshrarihyj;
    }

    private String ztrseihowebmosno;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBMOSNO)
    public String getZtrseihowebmosno() {
        return ztrseihowebmosno;
    }

    public void setZtrseihowebmosno(String pZtrseihowebmosno) {
        ztrseihowebmosno = pZtrseihowebmosno;
    }

    private String ztrseihowebsekykkigenymd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSEKYKKIGENYMD)
    public String getZtrseihowebsekykkigenymd() {
        return ztrseihowebsekykkigenymd;
    }

    public void setZtrseihowebsekykkigenymd(String pZtrseihowebsekykkigenymd) {
        ztrseihowebsekykkigenymd = pZtrseihowebsekykkigenymd;
    }

    private String ztrseihowebsksjsitencd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSKSJSITENCD)
    public String getZtrseihowebsksjsitencd() {
        return ztrseihowebsksjsitencd;
    }

    public void setZtrseihowebsksjsitencd(String pZtrseihowebsksjsitencd) {
        ztrseihowebsksjsitencd = pZtrseihowebsksjsitencd;
    }

    private String ztrseihowebsbuktnrkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSBUKTNRKKBN)
    public String getZtrseihowebsbuktnrkkbn() {
        return ztrseihowebsbuktnrkkbn;
    }

    public void setZtrseihowebsbuktnrkkbn(String pZtrseihowebsbuktnrkkbn) {
        ztrseihowebsbuktnrkkbn = pZtrseihowebsbuktnrkkbn;
    }

    private String ztrseihowebsbukttdkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSBUKTTDKKBN)
    public String getZtrseihowebsbukttdkkbn() {
        return ztrseihowebsbukttdkkbn;
    }

    public void setZtrseihowebsbukttdkkbn(String pZtrseihowebsbukttdkkbn) {
        ztrseihowebsbukttdkkbn = pZtrseihowebsbukttdkkbn;
    }

    private String ztrseihowebsbuktknnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSBUKTKNNM)
    public String getZtrseihowebsbuktknnm() {
        return ztrseihowebsbuktknnm;
    }

    public void setZtrseihowebsbuktknnm(String pZtrseihowebsbuktknnm) {
        ztrseihowebsbuktknnm = pZtrseihowebsbuktknnm;
    }

    private String ztrseihowebsbuktkjnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSBUKTKJNM)
    public String getZtrseihowebsbuktkjnm() {
        return ztrseihowebsbuktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebsbuktkjnm(String pZtrseihowebsbuktkjnm) {
        ztrseihowebsbuktkjnm = pZtrseihowebsbuktkjnm;
    }

    private String ztrseihowebsbuktseiymd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSBUKTSEIYMD)
    public String getZtrseihowebsbuktseiymd() {
        return ztrseihowebsbuktseiymd;
    }

    public void setZtrseihowebsbuktseiymd(String pZtrseihowebsbuktseiymd) {
        ztrseihowebsbuktseiymd = pZtrseihowebsbuktseiymd;
    }

    private String ztrseihowebmosprtzmhyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBMOSPRTZMHYJ)
    public String getZtrseihowebmosprtzmhyj() {
        return ztrseihowebmosprtzmhyj;
    }

    public void setZtrseihowebmosprtzmhyj(String pZtrseihowebmosprtzmhyj) {
        ztrseihowebmosprtzmhyj = pZtrseihowebmosprtzmhyj;
    }

    private String ztrseihowebfstmossksymd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBFSTMOSSKSYMD)
    public String getZtrseihowebfstmossksymd() {
        return ztrseihowebfstmossksymd;
    }

    public void setZtrseihowebfstmossksymd(String pZtrseihowebfstmossksymd) {
        ztrseihowebfstmossksymd = pZtrseihowebfstmossksymd;
    }

    private String ztrseihowebhnsyukyktdkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHNSYUKYKTDKKBN)
    public String getZtrseihowebhnsyukyktdkkbn() {
        return ztrseihowebhnsyukyktdkkbn;
    }

    public void setZtrseihowebhnsyukyktdkkbn(String pZtrseihowebhnsyukyktdkkbn) {
        ztrseihowebhnsyukyktdkkbn = pZtrseihowebhnsyukyktdkkbn;
    }

    private String ztrseihowebbsyutrkno;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBBSYUTRKNO)
    public String getZtrseihowebbsyutrkno() {
        return ztrseihowebbsyutrkno;
    }

    public void setZtrseihowebbsyutrkno(String pZtrseihowebbsyutrkno) {
        ztrseihowebbsyutrkno = pZtrseihowebbsyutrkno;
    }

    private String ztrseihowebhjnkitikbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHJNKITIKBN)
    public String getZtrseihowebhjnkitikbn() {
        return ztrseihowebhjnkitikbn;
    }

    public void setZtrseihowebhjnkitikbn(String pZtrseihowebhjnkitikbn) {
        ztrseihowebhjnkitikbn = pZtrseihowebhjnkitikbn;
    }

    private String ztrseihowebhjnkykhyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHJNKYKHYJ)
    public String getZtrseihowebhjnkykhyj() {
        return ztrseihowebhjnkykhyj;
    }

    public void setZtrseihowebhjnkykhyj(String pZtrseihowebhjnkykhyj) {
        ztrseihowebhjnkykhyj = pZtrseihowebhjnkykhyj;
    }

    private String ztrseihowebtksykmcd1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTKSYKMCD1)
    public String getZtrseihowebtksykmcd1() {
        return ztrseihowebtksykmcd1;
    }

    public void setZtrseihowebtksykmcd1(String pZtrseihowebtksykmcd1) {
        ztrseihowebtksykmcd1 = pZtrseihowebtksykmcd1;
    }

    private String ztrseihowebtksykmcd2;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTKSYKMCD2)
    public String getZtrseihowebtksykmcd2() {
        return ztrseihowebtksykmcd2;
    }

    public void setZtrseihowebtksykmcd2(String pZtrseihowebtksykmcd2) {
        ztrseihowebtksykmcd2 = pZtrseihowebtksykmcd2;
    }

    private String ztrseihowebtksykmcd3;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTKSYKMCD3)
    public String getZtrseihowebtksykmcd3() {
        return ztrseihowebtksykmcd3;
    }

    public void setZtrseihowebtksykmcd3(String pZtrseihowebtksykmcd3) {
        ztrseihowebtksykmcd3 = pZtrseihowebtksykmcd3;
    }

    private String ztrseihowebtksykmcd4;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTKSYKMCD4)
    public String getZtrseihowebtksykmcd4() {
        return ztrseihowebtksykmcd4;
    }

    public void setZtrseihowebtksykmcd4(String pZtrseihowebtksykmcd4) {
        ztrseihowebtksykmcd4 = pZtrseihowebtksykmcd4;
    }

    private String ztrseihowebtksykmcd5;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTKSYKMCD5)
    public String getZtrseihowebtksykmcd5() {
        return ztrseihowebtksykmcd5;
    }

    public void setZtrseihowebtksykmcd5(String pZtrseihowebtksykmcd5) {
        ztrseihowebtksykmcd5 = pZtrseihowebtksykmcd5;
    }

    private Long ztrseihowebteiwkkn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTEIWKKN)
    public Long getZtrseihowebteiwkkn() {
        return ztrseihowebteiwkkn;
    }

    public void setZtrseihowebteiwkkn(Long pZtrseihowebteiwkkn) {
        ztrseihowebteiwkkn = pZtrseihowebteiwkkn;
    }

    private String ztrseihowebhhkntelno;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNTELNO)
    public String getZtrseihowebhhkntelno() {
        return ztrseihowebhhkntelno;
    }

    public void setZtrseihowebhhkntelno(String pZtrseihowebhhkntelno) {
        ztrseihowebhhkntelno = pZtrseihowebhhkntelno;
    }

    private String ztrseihowebkyktelno;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKTELNO)
    public String getZtrseihowebkyktelno() {
        return ztrseihowebkyktelno;
    }

    public void setZtrseihowebkyktelno(String pZtrseihowebkyktelno) {
        ztrseihowebkyktelno = pZtrseihowebkyktelno;
    }

    private String ztrseihowebknhjnnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKNHJNNM)
    public String getZtrseihowebknhjnnm() {
        return ztrseihowebknhjnnm;
    }

    public void setZtrseihowebknhjnnm(String pZtrseihowebknhjnnm) {
        ztrseihowebknhjnnm = pZtrseihowebknhjnnm;
    }

    private String ztrseihowebkjhjnnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKJHJNNM)
    public String getZtrseihowebkjhjnnm() {
        return ztrseihowebkjhjnnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkjhjnnm(String pZtrseihowebkjhjnnm) {
        ztrseihowebkjhjnnm = pZtrseihowebkjhjnnm;
    }

    private String ztrseihowebkndaihyounm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKNDAIHYOUNM)
    public String getZtrseihowebkndaihyounm() {
        return ztrseihowebkndaihyounm;
    }

    public void setZtrseihowebkndaihyounm(String pZtrseihowebkndaihyounm) {
        ztrseihowebkndaihyounm = pZtrseihowebkndaihyounm;
    }

    private String ztrseihowebkjdaihyounm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKJDAIHYOUNM)
    public String getZtrseihowebkjdaihyounm() {
        return ztrseihowebkjdaihyounm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkjdaihyounm(String pZtrseihowebkjdaihyounm) {
        ztrseihowebkjdaihyounm = pZtrseihowebkjdaihyounm;
    }

    private String ztrseihowebdaihyouktgkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBDAIHYOUKTGKKBN)
    public String getZtrseihowebdaihyouktgkkbn() {
        return ztrseihowebdaihyouktgkkbn;
    }

    public void setZtrseihowebdaihyouktgkkbn(String pZtrseihowebdaihyouktgkkbn) {
        ztrseihowebdaihyouktgkkbn = pZtrseihowebdaihyouktgkkbn;
    }

    private Long ztrseihowebsykihrkp1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSYKIHRKP1)
    public Long getZtrseihowebsykihrkp1() {
        return ztrseihowebsykihrkp1;
    }

    public void setZtrseihowebsykihrkp1(Long pZtrseihowebsykihrkp1) {
        ztrseihowebsykihrkp1 = pZtrseihowebsykihrkp1;
    }

    private Long ztrseihowebmosp1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBMOSP1)
    public Long getZtrseihowebmosp1() {
        return ztrseihowebmosp1;
    }

    public void setZtrseihowebmosp1(Long pZtrseihowebmosp1) {
        ztrseihowebmosp1 = pZtrseihowebmosp1;
    }

    private String ztrseihowebtkiyougyoutaikbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTKIYOUGYOUTAIKBN)
    public String getZtrseihowebtkiyougyoutaikbn() {
        return ztrseihowebtkiyougyoutaikbn;
    }

    public void setZtrseihowebtkiyougyoutaikbn(String pZtrseihowebtkiyougyoutaikbn) {
        ztrseihowebtkiyougyoutaikbn = pZtrseihowebtkiyougyoutaikbn;
    }

    private String ztrseihowebpaperlessmoshyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPAPERLESSMOSHYJ)
    public String getZtrseihowebpaperlessmoshyj() {
        return ztrseihowebpaperlessmoshyj;
    }

    public void setZtrseihowebpaperlessmoshyj(String pZtrseihowebpaperlessmoshyj) {
        ztrseihowebpaperlessmoshyj = pZtrseihowebpaperlessmoshyj;
    }

    private String ztrseihowebdatasousinzmhyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBDATASOUSINZMHYJ)
    public String getZtrseihowebdatasousinzmhyj() {
        return ztrseihowebdatasousinzmhyj;
    }

    public void setZtrseihowebdatasousinzmhyj(String pZtrseihowebdatasousinzmhyj) {
        ztrseihowebdatasousinzmhyj = pZtrseihowebdatasousinzmhyj;
    }

    private String ztrseihowebdrtnskno;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBDRTNSKNO)
    public String getZtrseihowebdrtnskno() {
        return ztrseihowebdrtnskno;
    }

    public void setZtrseihowebdrtnskno(String pZtrseihowebdrtnskno) {
        ztrseihowebdrtnskno = pZtrseihowebdrtnskno;
    }

    private String ztrseihowebsbnksyukbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSBNKSYUKBN)
    public String getZtrseihowebsbnksyukbn() {
        return ztrseihowebsbnksyukbn;
    }

    public void setZtrseihowebsbnksyukbn(String pZtrseihowebsbnksyukbn) {
        ztrseihowebsbnksyukbn = pZtrseihowebsbnksyukbn;
    }

    private String ztrseihowebaatkisyaknyuucd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBAATKISYAKNYUUCD)
    public String getZtrseihowebaatkisyaknyuucd() {
        return ztrseihowebaatkisyaknyuucd;
    }

    public void setZtrseihowebaatkisyaknyuucd(String pZtrseihowebaatkisyaknyuucd) {
        ztrseihowebaatkisyaknyuucd = pZtrseihowebaatkisyaknyuucd;
    }

    private String ztrseihowebkeihidouituhyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKEIHIDOUITUHYJ)
    public String getZtrseihowebkeihidouituhyj() {
        return ztrseihowebkeihidouituhyj;
    }

    public void setZtrseihowebkeihidouituhyj(String pZtrseihowebkeihidouituhyj) {
        ztrseihowebkeihidouituhyj = pZtrseihowebkeihidouituhyj;
    }

    private String ztrseihowebsiteituukakbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSITEITUUKAKBN)
    public String getZtrseihowebsiteituukakbn() {
        return ztrseihowebsiteituukakbn;
    }

    public void setZtrseihowebsiteituukakbn(String pZtrseihowebsiteituukakbn) {
        ztrseihowebsiteituukakbn = pZtrseihowebsiteituukakbn;
    }

    private String ztrseihowebnykntuukakbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBNYKNTUUKAKBN)
    public String getZtrseihowebnykntuukakbn() {
        return ztrseihowebnykntuukakbn;
    }

    public void setZtrseihowebnykntuukakbn(String pZtrseihowebnykntuukakbn) {
        ztrseihowebnykntuukakbn = pZtrseihowebnykntuukakbn;
    }

    private String ztrseihowebtargettkarihyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTARGETTKARIHYJ)
    public String getZtrseihowebtargettkarihyj() {
        return ztrseihowebtargettkarihyj;
    }

    public void setZtrseihowebtargettkarihyj(String pZtrseihowebtargettkarihyj) {
        ztrseihowebtargettkarihyj = pZtrseihowebtargettkarihyj;
    }

    private String ztrseihowebtargettkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTARGETTKKBN)
    public String getZtrseihowebtargettkkbn() {
        return ztrseihowebtargettkkbn;
    }

    public void setZtrseihowebtargettkkbn(String pZtrseihowebtargettkkbn) {
        ztrseihowebtargettkkbn = pZtrseihowebtargettkkbn;
    }

    private Integer ztrseihowebtargettkmkht;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTARGETTKMKHT)
    public Integer getZtrseihowebtargettkmkht() {
        return ztrseihowebtargettkmkht;
    }

    public void setZtrseihowebtargettkmkht(Integer pZtrseihowebtargettkmkht) {
        ztrseihowebtargettkmkht = pZtrseihowebtargettkmkht;
    }

    private Long ztrseihowebnykntuukanykngk;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBNYKNTUUKANYKNGK)
    public Long getZtrseihowebnykntuukanykngk() {
        return ztrseihowebnykntuukanykngk;
    }

    public void setZtrseihowebnykntuukanykngk(Long pZtrseihowebnykntuukanykngk) {
        ztrseihowebnykntuukanykngk = pZtrseihowebnykntuukanykngk;
    }

    private Long ztrseihowebnykntukfsthrkp;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBNYKNTUKFSTHRKP)
    public Long getZtrseihowebnykntukfsthrkp() {
        return ztrseihowebnykntukfsthrkp;
    }

    public void setZtrseihowebnykntukfsthrkp(Long pZtrseihowebnykntukfsthrkp) {
        ztrseihowebnykntukfsthrkp = pZtrseihowebnykntukfsthrkp;
    }

    private Long ztrseihowebnykntuknexthrkp;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBNYKNTUKNEXTHRKP)
    public Long getZtrseihowebnykntuknexthrkp() {
        return ztrseihowebnykntuknexthrkp;
    }

    public void setZtrseihowebnykntuknexthrkp(Long pZtrseihowebnykntuknexthrkp) {
        ztrseihowebnykntuknexthrkp = pZtrseihowebnykntuknexthrkp;
    }

    private String ztrseihowebsaimankihyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSAIMANKIHYJ)
    public String getZtrseihowebsaimankihyj() {
        return ztrseihowebsaimankihyj;
    }

    public void setZtrseihowebsaimankihyj(String pZtrseihowebsaimankihyj) {
        ztrseihowebsaimankihyj = pZtrseihowebsaimankihyj;
    }

    private String ztrseihowebrayhyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBRAYHYJ)
    public String getZtrseihowebrayhyj() {
        return ztrseihowebrayhyj;
    }

    public void setZtrseihowebrayhyj(String pZtrseihowebrayhyj) {
        ztrseihowebrayhyj = pZtrseihowebrayhyj;
    }

    private Long ztrseihowebgnykntuknykngk;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBGNYKNTUKNYKNGK)
    public Long getZtrseihowebgnykntuknykngk() {
        return ztrseihowebgnykntuknykngk;
    }

    public void setZtrseihowebgnykntuknykngk(Long pZtrseihowebgnykntuknykngk) {
        ztrseihowebgnykntuknykngk = pZtrseihowebgnykntuknykngk;
    }

    private Long ztrseihowebgnykntukfsthrkp;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBGNYKNTUKFSTHRKP)
    public Long getZtrseihowebgnykntukfsthrkp() {
        return ztrseihowebgnykntukfsthrkp;
    }

    public void setZtrseihowebgnykntukfsthrkp(Long pZtrseihowebgnykntukfsthrkp) {
        ztrseihowebgnykntukfsthrkp = pZtrseihowebgnykntukfsthrkp;
    }

    private Long ztrseihowebgnykntuknxthrkp;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBGNYKNTUKNXTHRKP)
    public Long getZtrseihowebgnykntuknxthrkp() {
        return ztrseihowebgnykntuknxthrkp;
    }

    public void setZtrseihowebgnykntuknxthrkp(Long pZtrseihowebgnykntuknxthrkp) {
        ztrseihowebgnykntuknxthrkp = pZtrseihowebgnykntuknxthrkp;
    }

    private Long ztrseihowebgaikakihonp;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBGAIKAKIHONP)
    public Long getZtrseihowebgaikakihonp() {
        return ztrseihowebgaikakihonp;
    }

    public void setZtrseihowebgaikakihonp(Long pZtrseihowebgaikakihonp) {
        ztrseihowebgaikakihonp = pZtrseihowebgaikakihonp;
    }

    private String ztrseihowebkaigmehrtkarihyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKAIGMEHRTKARIHYJ)
    public String getZtrseihowebkaigmehrtkarihyj() {
        return ztrseihowebkaigmehrtkarihyj;
    }

    public void setZtrseihowebkaigmehrtkarihyj(String pZtrseihowebkaigmehrtkarihyj) {
        ztrseihowebkaigmehrtkarihyj = pZtrseihowebkaigmehrtkarihyj;
    }

    private String ztrseihowebyenhsyutkarihyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBYENHSYUTKARIHYJ)
    public String getZtrseihowebyenhsyutkarihyj() {
        return ztrseihowebyenhsyutkarihyj;
    }

    public void setZtrseihowebyenhsyutkarihyj(String pZtrseihowebyenhsyutkarihyj) {
        ztrseihowebyenhsyutkarihyj = pZtrseihowebyenhsyutkarihyj;
    }

    private Long ztrseihowebgaikakihons;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBGAIKAKIHONS)
    public Long getZtrseihowebgaikakihons() {
        return ztrseihowebgaikakihons;
    }

    public void setZtrseihowebgaikakihons(Long pZtrseihowebgaikakihons) {
        ztrseihowebgaikakihons = pZtrseihowebgaikakihons;
    }

    private Integer ztrseihowebdai1hknkkn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBDAI1HKNKKN)
    public Integer getZtrseihowebdai1hknkkn() {
        return ztrseihowebdai1hknkkn;
    }

    public void setZtrseihowebdai1hknkkn(Integer pZtrseihowebdai1hknkkn) {
        ztrseihowebdai1hknkkn = pZtrseihowebdai1hknkkn;
    }

    private String ztrseihowebkyksykgycd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKSYKGYCD)
    public String getZtrseihowebkyksykgycd() {
        return ztrseihowebkyksykgycd;
    }

    public void setZtrseihowebkyksykgycd(String pZtrseihowebkyksykgycd) {
        ztrseihowebkyksykgycd = pZtrseihowebkyksykgycd;
    }

    private String ztrseihowebkknmskhjnkitikbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKKNMSKHJNKITIKBN)
    public String getZtrseihowebkknmskhjnkitikbn() {
        return ztrseihowebkknmskhjnkitikbn;
    }

    public void setZtrseihowebkknmskhjnkitikbn(String pZtrseihowebkknmskhjnkitikbn) {
        ztrseihowebkknmskhjnkitikbn = pZtrseihowebkknmskhjnkitikbn;
    }

    private String ztrseihowebkykottmsk;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKOTTMSK)
    public String getZtrseihowebkykottmsk() {
        return ztrseihowebkykottmsk;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkykottmsk(String pZtrseihowebkykottmsk) {
        ztrseihowebkykottmsk = pZtrseihowebkykottmsk;
    }

    private String ztrseihowebhhknsykgycd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNSYKGYCD)
    public String getZtrseihowebhhknsykgycd() {
        return ztrseihowebhhknsykgycd;
    }

    public void setZtrseihowebhhknsykgycd(String pZtrseihowebhhknsykgycd) {
        ztrseihowebhhknsykgycd = pZtrseihowebhhknsykgycd;
    }

    private String ztrseihowebhknmskhjnkitikbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHKNMSKHJNKITIKBN)
    public String getZtrseihowebhknmskhjnkitikbn() {
        return ztrseihowebhknmskhjnkitikbn;
    }

    public void setZtrseihowebhknmskhjnkitikbn(String pZtrseihowebhknmskhjnkitikbn) {
        ztrseihowebhknmskhjnkitikbn = pZtrseihowebhknmskhjnkitikbn;
    }

    private String ztrseihowebhhknottmsk;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNOTTMSK)
    public String getZtrseihowebhhknottmsk() {
        return ztrseihowebhhknottmsk;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhhknottmsk(String pZtrseihowebhhknottmsk) {
        ztrseihowebhhknottmsk = pZtrseihowebhhknottmsk;
    }

    private String ztrseihowebhhknnensyuukbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNNENSYUUKBN)
    public String getZtrseihowebhhknnensyuukbn() {
        return ztrseihowebhhknnensyuukbn;
    }

    public void setZtrseihowebhhknnensyuukbn(String pZtrseihowebhhknnensyuukbn) {
        ztrseihowebhhknnensyuukbn = pZtrseihowebhhknnensyuukbn;
    }

    private String ztrseihowebplhhknkjnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLHHKNKJNM)
    public String getZtrseihowebplhhknkjnm() {
        return ztrseihowebplhhknkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebplhhknkjnm(String pZtrseihowebplhhknkjnm) {
        ztrseihowebplhhknkjnm = pZtrseihowebplhhknkjnm;
    }

    private String ztrseihowebplkykkjnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLKYKKJNM)
    public String getZtrseihowebplkykkjnm() {
        return ztrseihowebplkykkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebplkykkjnm(String pZtrseihowebplkykkjnm) {
        ztrseihowebplkykkjnm = pZtrseihowebplkykkjnm;
    }

    private String ztrseihowebplhrkkeirokbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLHRKKEIROKBN)
    public String getZtrseihowebplhrkkeirokbn() {
        return ztrseihowebplhrkkeirokbn;
    }

    public void setZtrseihowebplhrkkeirokbn(String pZtrseihowebplhrkkeirokbn) {
        ztrseihowebplhrkkeirokbn = pZtrseihowebplhrkkeirokbn;
    }

    private String ztrseihowebplsbuktnrkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLSBUKTNRKKBN)
    public String getZtrseihowebplsbuktnrkkbn() {
        return ztrseihowebplsbuktnrkkbn;
    }

    public void setZtrseihowebplsbuktnrkkbn(String pZtrseihowebplsbuktnrkkbn) {
        ztrseihowebplsbuktnrkkbn = pZtrseihowebplsbuktnrkkbn;
    }

    private String ztrseihowebplsbukttdkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLSBUKTTDKKBN)
    public String getZtrseihowebplsbukttdkkbn() {
        return ztrseihowebplsbukttdkkbn;
    }

    public void setZtrseihowebplsbukttdkkbn(String pZtrseihowebplsbukttdkkbn) {
        ztrseihowebplsbukttdkkbn = pZtrseihowebplsbukttdkkbn;
    }

    private String ztrseihowebplsbuktknnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLSBUKTKNNM)
    public String getZtrseihowebplsbuktknnm() {
        return ztrseihowebplsbuktknnm;
    }

    public void setZtrseihowebplsbuktknnm(String pZtrseihowebplsbuktknnm) {
        ztrseihowebplsbuktknnm = pZtrseihowebplsbuktknnm;
    }

    private String ztrseihowebplsbuktkjnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLSBUKTKJNM)
    public String getZtrseihowebplsbuktkjnm() {
        return ztrseihowebplsbuktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebplsbuktkjnm(String pZtrseihowebplsbuktkjnm) {
        ztrseihowebplsbuktkjnm = pZtrseihowebplsbuktkjnm;
    }

    private String ztrseihowebplsbuktseiymd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLSBUKTSEIYMD)
    public String getZtrseihowebplsbuktseiymd() {
        return ztrseihowebplsbuktseiymd;
    }

    public void setZtrseihowebplsbuktseiymd(String pZtrseihowebplsbuktseiymd) {
        ztrseihowebplsbuktseiymd = pZtrseihowebplsbuktseiymd;
    }

    private String ztrseihowebplhhkntelno;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLHHKNTELNO)
    public String getZtrseihowebplhhkntelno() {
        return ztrseihowebplhhkntelno;
    }

    public void setZtrseihowebplhhkntelno(String pZtrseihowebplhhkntelno) {
        ztrseihowebplhhkntelno = pZtrseihowebplhhkntelno;
    }

    private String ztrseihowebplkyktelno;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLKYKTELNO)
    public String getZtrseihowebplkyktelno() {
        return ztrseihowebplkyktelno;
    }

    public void setZtrseihowebplkyktelno(String pZtrseihowebplkyktelno) {
        ztrseihowebplkyktelno = pZtrseihowebplkyktelno;
    }

    private String ztrseihowebplkihontikucd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLKIHONTIKUCD)
    public String getZtrseihowebplkihontikucd() {
        return ztrseihowebplkihontikucd;
    }

    public void setZtrseihowebplkihontikucd(String pZtrseihowebplkihontikucd) {
        ztrseihowebplkihontikucd = pZtrseihowebplkihontikucd;
    }

    private String ztrseihowebpltsinadrkai;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLTSINADRKAI)
    public String getZtrseihowebpltsinadrkai() {
        return ztrseihowebpltsinadrkai;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebpltsinadrkai(String pZtrseihowebpltsinadrkai) {
        ztrseihowebpltsinadrkai = pZtrseihowebpltsinadrkai;
    }

    private String ztrseihowebplhiikihontikucd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLHIIKIHONTIKUCD)
    public String getZtrseihowebplhiikihontikucd() {
        return ztrseihowebplhiikihontikucd;
    }

    public void setZtrseihowebplhiikihontikucd(String pZtrseihowebplhiikihontikucd) {
        ztrseihowebplhiikihontikucd = pZtrseihowebplhiikihontikucd;
    }

    private String ztrseihowebplhhknadr;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBPLHHKNADR)
    public String getZtrseihowebplhhknadr() {
        return ztrseihowebplhhknadr;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebplhhknadr(String pZtrseihowebplhhknadr) {
        ztrseihowebplhhknadr = pZtrseihowebplhhknadr;
    }

    private String ztrseihowebhnyppltzmhyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHNYPPLTZMHYJ)
    public String getZtrseihowebhnyppltzmhyj() {
        return ztrseihowebhnyppltzmhyj;
    }

    public void setZtrseihowebhnyppltzmhyj(String pZtrseihowebhnyppltzmhyj) {
        ztrseihowebhnyppltzmhyj = pZtrseihowebhnyppltzmhyj;
    }

    private Integer ztrseihowebssrndhbnwr;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSSRNDHBNWR)
    public Integer getZtrseihowebssrndhbnwr() {
        return ztrseihowebssrndhbnwr;
    }

    public void setZtrseihowebssrndhbnwr(Integer pZtrseihowebssrndhbnwr) {
        ztrseihowebssrndhbnwr = pZtrseihowebssrndhbnwr;
    }

    private Integer ztrseihowebtrtrndhbnwr;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBTRTRNDHBNWR)
    public Integer getZtrseihowebtrtrndhbnwr() {
        return ztrseihowebtrtrndhbnwr;
    }

    public void setZtrseihowebtrtrndhbnwr(Integer pZtrseihowebtrtrndhbnwr) {
        ztrseihowebtrtrndhbnwr = pZtrseihowebtrtrndhbnwr;
    }

    private Integer ztrseihowebsueokikkn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBSUEOKIKKN)
    public Integer getZtrseihowebsueokikkn() {
        return ztrseihowebsueokikkn;
    }

    public void setZtrseihowebsueokikkn(Integer pZtrseihowebsueokikkn) {
        ztrseihowebsueokikkn = pZtrseihowebsueokikkn;
    }

    private String ztrseihowebmnkuktnrkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBMNKUKTNRKKBN)
    public String getZtrseihowebmnkuktnrkkbn() {
        return ztrseihowebmnkuktnrkkbn;
    }

    public void setZtrseihowebmnkuktnrkkbn(String pZtrseihowebmnkuktnrkkbn) {
        ztrseihowebmnkuktnrkkbn = pZtrseihowebmnkuktnrkkbn;
    }

    private String ztrseihowebmnkukttdkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBMNKUKTTDKKBN)
    public String getZtrseihowebmnkukttdkkbn() {
        return ztrseihowebmnkukttdkkbn;
    }

    public void setZtrseihowebmnkukttdkkbn(String pZtrseihowebmnkukttdkkbn) {
        ztrseihowebmnkukttdkkbn = pZtrseihowebmnkukttdkkbn;
    }

    private String ztrseihowebmnkuktknnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBMNKUKTKNNM)
    public String getZtrseihowebmnkuktknnm() {
        return ztrseihowebmnkuktknnm;
    }

    public void setZtrseihowebmnkuktknnm(String pZtrseihowebmnkuktknnm) {
        ztrseihowebmnkuktknnm = pZtrseihowebmnkuktknnm;
    }

    private String ztrseihowebmnkuktkjnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBMNKUKTKJNM)
    public String getZtrseihowebmnkuktkjnm() {
        return ztrseihowebmnkuktkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebmnkuktkjnm(String pZtrseihowebmnkuktkjnm) {
        ztrseihowebmnkuktkjnm = pZtrseihowebmnkuktkjnm;
    }

    private String ztrseihowebmnkuktseiymd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBMNKUKTSEIYMD)
    public String getZtrseihowebmnkuktseiymd() {
        return ztrseihowebmnkuktseiymd;
    }

    public void setZtrseihowebmnkuktseiymd(String pZtrseihowebmnkuktseiymd) {
        ztrseihowebmnkuktseiymd = pZtrseihowebmnkuktseiymd;
    }

    private String ztrseihowebankenkanrino;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBANKENKANRINO)
    public String getZtrseihowebankenkanrino() {
        return ztrseihowebankenkanrino;
    }

    public void setZtrseihowebankenkanrino(String pZtrseihowebankenkanrino) {
        ztrseihowebankenkanrino = pZtrseihowebankenkanrino;
    }

    private Long ztrseihowebikkatup;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBIKKATUP)
    public Long getZtrseihowebikkatup() {
        return ztrseihowebikkatup;
    }

    public void setZtrseihowebikkatup(Long pZtrseihowebikkatup) {
        ztrseihowebikkatup = pZtrseihowebikkatup;
    }

    private String ztrseihowebikkatubaraikbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBIKKATUBARAIKBN)
    public String getZtrseihowebikkatubaraikbn() {
        return ztrseihowebikkatubaraikbn;
    }

    public void setZtrseihowebikkatubaraikbn(String pZtrseihowebikkatubaraikbn) {
        ztrseihowebikkatubaraikbn = pZtrseihowebikkatubaraikbn;
    }

    private Integer ztrseihowebiktbrikaisuu;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBIKTBRIKAISUU)
    public Integer getZtrseihowebiktbrikaisuu() {
        return ztrseihowebiktbrikaisuu;
    }

    public void setZtrseihowebiktbrikaisuu(Integer pZtrseihowebiktbrikaisuu) {
        ztrseihowebiktbrikaisuu = pZtrseihowebiktbrikaisuu;
    }

    private Long ztrseihowebzennoup;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBZENNOUP)
    public Long getZtrseihowebzennoup() {
        return ztrseihowebzennoup;
    }

    public void setZtrseihowebzennoup(Long pZtrseihowebzennoup) {
        ztrseihowebzennoup = pZtrseihowebzennoup;
    }

    private Long ztrseihowebgaikazennoup;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBGAIKAZENNOUP)
    public Long getZtrseihowebgaikazennoup() {
        return ztrseihowebgaikazennoup;
    }

    public void setZtrseihowebgaikazennoup(Long pZtrseihowebgaikazennoup) {
        ztrseihowebgaikazennoup = pZtrseihowebgaikazennoup;
    }

    private Integer ztrseihowebzennoukkn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBZENNOUKKN)
    public Integer getZtrseihowebzennoukkn() {
        return ztrseihowebzennoukkn;
    }

    public void setZtrseihowebzennoukkn(Integer pZtrseihowebzennoukkn) {
        ztrseihowebzennoukkn = pZtrseihowebzennoukkn;
    }

    private String ztrseihowebzennouhyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBZENNOUHYJ)
    public String getZtrseihowebzennouhyj() {
        return ztrseihowebzennouhyj;
    }

    public void setZtrseihowebzennouhyj(String pZtrseihowebzennouhyj) {
        ztrseihowebzennouhyj = pZtrseihowebzennouhyj;
    }

    private String ztrseihowebkydbosyuukjncd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYDBOSYUUKJNCD)
    public String getZtrseihowebkydbosyuukjncd() {
        return ztrseihowebkydbosyuukjncd;
    }

    public void setZtrseihowebkydbosyuukjncd(String pZtrseihowebkydbosyuukjncd) {
        ztrseihowebkydbosyuukjncd = pZtrseihowebkydbosyuukjncd;
    }

    private String ztrseihowebkzktrkmoskbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKZKTRKMOSKBN)
    public String getZtrseihowebkzktrkmoskbn() {
        return ztrseihowebkzktrkmoskbn;
    }

    public void setZtrseihowebkzktrkmoskbn(String pZtrseihowebkzktrkmoskbn) {
        ztrseihowebkzktrkmoskbn = pZtrseihowebkzktrkmoskbn;
    }

    private String ztrseihowebkzktdkkbn1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKZKTDKKBN1)
    public String getZtrseihowebkzktdkkbn1() {
        return ztrseihowebkzktdkkbn1;
    }

    public void setZtrseihowebkzktdkkbn1(String pZtrseihowebkzktdkkbn1) {
        ztrseihowebkzktdkkbn1 = pZtrseihowebkzktdkkbn1;
    }

    private String ztrseihowebkzkknnm1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKZKKNNM1)
    public String getZtrseihowebkzkknnm1() {
        return ztrseihowebkzkknnm1;
    }

    public void setZtrseihowebkzkknnm1(String pZtrseihowebkzkknnm1) {
        ztrseihowebkzkknnm1 = pZtrseihowebkzkknnm1;
    }

    private String ztrseihowebkzkkjnm1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKZKKJNM1)
    public String getZtrseihowebkzkkjnm1() {
        return ztrseihowebkzkkjnm1;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkzkkjnm1(String pZtrseihowebkzkkjnm1) {
        ztrseihowebkzkkjnm1 = pZtrseihowebkzkkjnm1;
    }

    private String ztrseihowebkzkseikbn1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKZKSEIKBN1)
    public String getZtrseihowebkzkseikbn1() {
        return ztrseihowebkzkseikbn1;
    }

    public void setZtrseihowebkzkseikbn1(String pZtrseihowebkzkseikbn1) {
        ztrseihowebkzkseikbn1 = pZtrseihowebkzkseikbn1;
    }

    private String ztrseihowebkzkseiymd1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKZKSEIYMD1)
    public String getZtrseihowebkzkseiymd1() {
        return ztrseihowebkzkseiymd1;
    }

    public void setZtrseihowebkzkseiymd1(String pZtrseihowebkzkseiymd1) {
        ztrseihowebkzkseiymd1 = pZtrseihowebkzkseiymd1;
    }

    private String ztrseihowebkzkkykdoukyohyj1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKZKKYKDOUKYOHYJ1)
    public String getZtrseihowebkzkkykdoukyohyj1() {
        return ztrseihowebkzkkykdoukyohyj1;
    }

    public void setZtrseihowebkzkkykdoukyohyj1(String pZtrseihowebkzkkykdoukyohyj1) {
        ztrseihowebkzkkykdoukyohyj1 = pZtrseihowebkzkkykdoukyohyj1;
    }

    private String ztrseihowebkzkyno1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKZKYNO1)
    public String getZtrseihowebkzkyno1() {
        return ztrseihowebkzkyno1;
    }

    public void setZtrseihowebkzkyno1(String pZtrseihowebkzkyno1) {
        ztrseihowebkzkyno1 = pZtrseihowebkzkyno1;
    }

    private String ztrseihowebkzkadr1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKZKADR1)
    public String getZtrseihowebkzkadr1() {
        return ztrseihowebkzkadr1;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebkzkadr1(String pZtrseihowebkzkadr1) {
        ztrseihowebkzkadr1 = pZtrseihowebkzkadr1;
    }

    private String ztrseihowebkzktelno1;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKZKTELNO1)
    public String getZtrseihowebkzktelno1() {
        return ztrseihowebkzktelno1;
    }

    public void setZtrseihowebkzktelno1(String pZtrseihowebkzktelno1) {
        ztrseihowebkzktelno1 = pZtrseihowebkzktelno1;
    }

    private String ztrseihowebkykdrtkkanouhyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKDRTKKANOUHYJ)
    public String getZtrseihowebkykdrtkkanouhyj() {
        return ztrseihowebkykdrtkkanouhyj;
    }

    public void setZtrseihowebkykdrtkkanouhyj(String pZtrseihowebkykdrtkkanouhyj) {
        ztrseihowebkykdrtkkanouhyj = pZtrseihowebkykdrtkkanouhyj;
    }

    private String ztrseihowebhhkndrtkkanouhyj;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNDRTKKANOUHYJ)
    public String getZtrseihowebhhkndrtkkanouhyj() {
        return ztrseihowebhhkndrtkkanouhyj;
    }

    public void setZtrseihowebhhkndrtkkanouhyj(String pZtrseihowebhhkndrtkkanouhyj) {
        ztrseihowebhhkndrtkkanouhyj = pZtrseihowebhhkndrtkkanouhyj;
    }

    private String ztrseihowebdrtkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBDRTKKBN)
    public String getZtrseihowebdrtkkbn() {
        return ztrseihowebdrtkkbn;
    }

    public void setZtrseihowebdrtkkbn(String pZtrseihowebdrtkkbn) {
        ztrseihowebdrtkkbn = pZtrseihowebdrtkkbn;
    }

    private String ztrseihowebkykdrnrkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBKYKDRNRKKBN)
    public String getZtrseihowebkykdrnrkkbn() {
        return ztrseihowebkykdrnrkkbn;
    }

    public void setZtrseihowebkykdrnrkkbn(String pZtrseihowebkykdrnrkkbn) {
        ztrseihowebkykdrnrkkbn = pZtrseihowebkykdrnrkkbn;
    }

    private String ztrseihowebhhkndrnrkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNDRNRKKBN)
    public String getZtrseihowebhhkndrnrkkbn() {
        return ztrseihowebhhkndrnrkkbn;
    }

    public void setZtrseihowebhhkndrnrkkbn(String pZtrseihowebhhkndrnrkkbn) {
        ztrseihowebhhkndrnrkkbn = pZtrseihowebhhkndrnrkkbn;
    }

    private String ztrseihowebhhkndrtdkkbn;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNDRTDKKBN)
    public String getZtrseihowebhhkndrtdkkbn() {
        return ztrseihowebhhkndrtdkkbn;
    }

    public void setZtrseihowebhhkndrtdkkbn(String pZtrseihowebhhkndrtdkkbn) {
        ztrseihowebhhkndrtdkkbn = pZtrseihowebhhkndrtdkkbn;
    }

    private String ztrseihowebhhkndrknnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNDRKNNM)
    public String getZtrseihowebhhkndrknnm() {
        return ztrseihowebhhkndrknnm;
    }

    public void setZtrseihowebhhkndrknnm(String pZtrseihowebhhkndrknnm) {
        ztrseihowebhhkndrknnm = pZtrseihowebhhkndrknnm;
    }

    private String ztrseihowebhhkndrkjnm;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNDRKJNM)
    public String getZtrseihowebhhkndrkjnm() {
        return ztrseihowebhhkndrkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZtrseihowebhhkndrkjnm(String pZtrseihowebhhkndrkjnm) {
        ztrseihowebhhkndrkjnm = pZtrseihowebhhkndrkjnm;
    }

    private String ztrseihowebhhkndrseiymd;

    @Column(name=GenZT_TiginSinkinBosTr.ZTRSEIHOWEBHHKNDRSEIYMD)
    public String getZtrseihowebhhkndrseiymd() {
        return ztrseihowebhhkndrseiymd;
    }

    public void setZtrseihowebhhkndrseiymd(String pZtrseihowebhhkndrseiymd) {
        ztrseihowebhhkndrseiymd = pZtrseihowebhhkndrseiymd;
    }
}