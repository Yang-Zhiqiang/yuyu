package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HT_SisyaToukeiHokan;
import yuyu.def.db.id.PKHT_SisyaToukeiHokan;
import yuyu.def.db.meta.GenQHT_SisyaToukeiHokan;
import yuyu.def.db.meta.QHT_SisyaToukeiHokan;

/**
 * 支社統計保管テーブル テーブルのマッピング情報クラスで、 {@link HT_SisyaToukeiHokan} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SisyaToukeiHokan}</td><td colspan="3">支社統計保管テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSstmosno sstmosno}</td><td>支社統計用申込番号</td><td align="center">{@link PKHT_SisyaToukeiHokan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_SisyaToukeiHokan ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyrctrltblkostime syrctrltblkostime}</td><td>処理コントロールTBL更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsyono sstsyono}</td><td>支社統計用証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmosym sstmosym}</td><td>支社統計用申込月度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmoskbn sstmoskbn}</td><td>支社統計用申込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstbosyuudrtenatkikeitaikbn sstbosyuudrtenatkikeitaikbn}</td><td>支社統計用募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkydatkikbn sstkydatkikbn}</td><td>支社統計用共同扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstatukaisyadrtenhyouji sstatukaisyadrtenhyouji}</td><td>支社統計用扱者代理店表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTratkiagcd tratkiagcd}</td><td>取扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsteigyouhonbusisyacd ssteigyouhonbusisyacd}</td><td>支社統計用営業本部支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsosikicd sstsosikicd}</td><td>支社統計用組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstatkisyagyskkjsosikicd sstatkisyagyskkjsosikicd}</td><td>支社統計用扱者業績計上先組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstcifcd sstcifcd}</td><td>支社統計用ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstatkisyadrtenatkiwari sstatkisyadrtenatkiwari}</td><td>支社統計用扱者代理店扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSsttsrybnwari ssttsrybnwari}</td><td>支社統計用手数料分割割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSstsinhsys sstsinhsys}</td><td>支社統計用新保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSstsoukensuu sstsoukensuu}</td><td>支社統計用総件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSstkydatkidairitencd sstkydatkidairitencd}</td><td>支社統計用共同扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstbosyuudrtenkobetuinfo1 sstbosyuudrtenkobetuinfo1}</td><td>支社統計用募集代理店個別情報１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstbosyuudrtenkobetuinfo2 sstbosyuudrtenkobetuinfo2}</td><td>支社統計用募集代理店個別情報２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstbosyuudrtenkobetuinfo3 sstbosyuudrtenkobetuinfo3}</td><td>支社統計用募集代理店個別情報３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstbosyuudrtenkobetuinfo4 sstbosyuudrtenkobetuinfo4}</td><td>支社統計用募集代理店個別情報４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstbosyuudrtenkobetuinfo5 sstbosyuudrtenkobetuinfo5}</td><td>支社統計用募集代理店個別情報５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstbankkouincd sstbankkouincd}</td><td>支社統計用銀行行員コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstdaihyoubosyuunincd sstdaihyoubosyuunincd}</td><td>支社統計用代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstatukaikojincd sstatukaikojincd}</td><td>支社統計用扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkanjihihokensyanm sstkanjihihokensyanm}</td><td>支社統計用漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsttansyukukjhhknnm ssttansyukukjhhknnm}</td><td>支社統計用短縮漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthhknsyokugyoucd ssthhknsyokugyoucd}</td><td>支社統計用被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthhknnen2keta ssthhknnen2keta}</td><td>支社統計用被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthhknseikbn ssthhknseikbn}</td><td>支社統計用被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthhknseiymd ssthhknseiymd}</td><td>支社統計用被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkjkyknm sstkjkyknm}</td><td>支社統計用漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkjkyknm10 sstkjkyknm10}</td><td>支社統計用漢字契約者名（１０文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstknkyknm15 sstknkyknm15}</td><td>支社統計用カナ契約者名（１５文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstknkyknm18 sstknkyknm18}</td><td>支社統計用カナ契約者名（１８文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkyksyanen sstkyksyanen}</td><td>支社統計用契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkyksyaseikbn sstkyksyaseikbn}</td><td>支社統計用契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthjnkykhyj ssthjnkykhyj}</td><td>支社統計用法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkjhjnnm sstkjhjnnm}</td><td>支社統計用漢字法人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstseirituyoukihontikucd sstseirituyoukihontikucd}</td><td>支社統計用成立率用基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmossyoumetukbn sstmossyoumetukbn}</td><td>支社統計用申込消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkurikosiriyuukbn sstkurikosiriyuukbn}</td><td>支社統計用繰越理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstnyknzumihyouji sstnyknzumihyouji}</td><td>支社統計用入金済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstnyknjkkbn sstnyknjkkbn}</td><td>支社統計用入金状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthoujyoukokutikbn ssthoujyoukokutikbn}</td><td>支社統計用報状告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkykkeitaikbn sstkykkeitaikbn}</td><td>支社統計用契約形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstketteijkkbn sstketteijkkbn}</td><td>支社統計用決定状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstdakuhiketteijyoutaikbn sstdakuhiketteijyoutaikbn}</td><td>支社統計用諾否決定状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstdakuhiketteikekkacd sstdakuhiketteikekkacd}</td><td>支社統計用諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstdakuhiketteiymd sstdakuhiketteiymd}</td><td>支社統計用諾否決定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsttokusyujimutoriatukaikbn ssttokusyujimutoriatukaikbn}</td><td>支社統計用特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsttoukeiyousinsakbn ssttoukeiyousinsakbn}</td><td>支社統計用統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthonninkakuninkbn ssthonninkakuninkbn}</td><td>支社統計用本人確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstdrtentsryhushrkykhyouji sstdrtentsryhushrkykhyouji}</td><td>支社統計用代理店手数料不支払契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstnyknkanskanouhyouji sstnyknkanskanouhyouji}</td><td>支社統計用入金勧奨可能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstdshukahyouji sstdshukahyouji}</td><td>支社統計用ＤＳ付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsiteidairisktkykarihyouj sstsiteidairisktkykarihyouj}</td><td>支社統計用指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsttokuteikanikokutikbn ssttokuteikanikokutikbn}</td><td>支社統計用特定簡易告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkykkakuninsyuruikbn sstkykkakuninsyuruikbn}</td><td>支社統計用契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkykkakuninjkkbn1 sstkykkakuninjkkbn1}</td><td>支社統計用契約確認状況区分（1文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmosketteikekkakbn sstmosketteikekkakbn}</td><td>支社統計用申込決定結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsinsazumihyouji sstsinsazumihyouji}</td><td>支社統計用診査済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstannaisakicd sstannaisakicd}</td><td>支社統計用案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmosjkkbn sstmosjkkbn}</td><td>支社統計用申込状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkihonhubi sstkihonhubi}</td><td>支社統計用基本不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsphubi sstsphubi}</td><td>支社統計用ＳＰ不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsseigenhubi sstsseigenhubi}</td><td>支社統計用Ｓ制限不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstnayosehumei sstnayosehumei}</td><td>支社統計用名寄不明</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsttuusangendoover ssttuusangendoover}</td><td>支社統計用通算限度オーバー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmosketteihoryuu sstmosketteihoryuu}</td><td>支社統計用申込決定保留</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkykkakuninjissityuu sstkykkakuninjissityuu}</td><td>支社統計用契約確認実施中</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkokutiketteihoryuu sstkokutiketteihoryuu}</td><td>支社統計用告知決定保留</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthonsyaketteihoryuu ssthonsyaketteihoryuu}</td><td>支社統計用本社決定保留</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstseiymdhubi sstseiymdhubi}</td><td>支社統計用生年月日不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstphusoku sstphusoku}</td><td>支社統計用Ｐ不足</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstseirituhoryuuuketuketyuu sstseirituhoryuuuketuketyuu}</td><td>支社統計用成立保留受付中</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstpkakin sstpkakin}</td><td>支社統計用Ｐ過金</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstketteihoryuuhubihyouji sstketteihoryuuhubihyouji}</td><td>支社統計用決定保留不備表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstseirituhoryuuhubihyouji sstseirituhoryuuhubihyouji}</td><td>支社統計用成立保留不備表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstyohurimiryou sstyohurimiryou}</td><td>支社統計用預振未了</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsttoukeiyouhknsyuruikbn ssttoukeiyouhknsyuruikbn}</td><td>支社統計用統計用保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthknsyuruinm ssthknsyuruinm}</td><td>支社統計用保険種類名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthknkkn ssthknkkn}</td><td>支社統計用保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstphrkkikn sstphrkkikn}</td><td>支社統計用Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthrkkaisuukbn ssthrkkaisuukbn}</td><td>支社統計用払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthrkkeirokbn ssthrkkeirokbn}</td><td>支社統計用払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstnkshrtkykarihyouji sstnkshrtkykarihyouji}</td><td>支社統計用年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstnkshrtkyknkkkn sstnkshrtkyknkkkn}</td><td>支社統計用年金支払特約年金期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstjyunhsys sstjyunhsys}</td><td>支社統計用純保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSsthsys ssthsys}</td><td>支社統計用保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSstkyktuuka sstkyktuuka}</td><td>支社統計用契約通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthrktuuka ssthrktuuka}</td><td>支社統計用払込通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsttuukatanikbn ssttuukatanikbn}</td><td>支社統計用通貨単位区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstfstphrkgkyen sstfstphrkgkyen}</td><td>支社統計用初回Ｐ払込必要額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSstfstphrkgkhrktuukamoji sstfstphrkgkhrktuukamoji}</td><td>支社統計用初回Ｐ払込必要額（払込通貨）（文字列）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstfstphrkgkgaika sstfstphrkgkgaika}</td><td>支社統計用初回Ｐ払込必要額（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSstfstpsshkhrkgkyen sstfstpsshkhrkgkyen}</td><td>支社統計用初回Ｐ差引払込額（円貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSstyennykntkykarihyouji sstyennykntkykarihyouji}</td><td>支社統計用円入金特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstgaikanykntkykarihyouji sstgaikanykntkykarihyouji}</td><td>支社統計用外貨入金特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsyenshrtkykarihyouji ssyenshrtkykarihyouji}</td><td>支社統計用円支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkihonsgaika sstkihonsgaika}</td><td>支社統計用基本Ｓ（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSsttekiyoukawaserate ssttekiyoukawaserate}</td><td>支社統計用適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSstkawaseratetekiyouymd sstkawaseratetekiyouymd}</td><td>支社統計用為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsakuseiymd sstsakuseiymd}</td><td>支社統計用作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmosymd sstmosymd}</td><td>支社統計用申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkokutiymd sstkokutiymd}</td><td>支社統計用告知年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmosnyuuryokuymd sstmosnyuuryokuymd}</td><td>支社統計用申込入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkouzanyuuryokuymd sstkouzanyuuryokuymd}</td><td>支社統計用口座入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkykymd sstkykymd}</td><td>支社統計用契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsekininkaisiymd sstsekininkaisiymd}</td><td>支社統計用責任開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsisyaketteisyoriymd sstsisyaketteisyoriymd}</td><td>支社統計用支社決定処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsyoukensakuseiymd sstsyoukensakuseiymd}</td><td>支社統計用証券作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstseisekikijyym sstseisekikijyym}</td><td>支社統計用成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmossyoumetukakuteiymd sstmossyoumetukakuteiymd}</td><td>支社統計用申込消滅確定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstdrtenkeijyouym sstdrtenkeijyouym}</td><td>支社統計用代理店計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmostoutyakuymd sstmostoutyakuymd}</td><td>支社統計用申込書到着年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkkttoutyakuymd sstkkttoutyakuymd}</td><td>支社統計用告知書到着年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmossakuseiymd sstmossakuseiymd}</td><td>支社統計用申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmosksnym sstmosksnym}</td><td>支社統計用申込起算年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkariseirituymd sstkariseirituymd}</td><td>支社統計用仮成立年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsinsayoteiymd sstsinsayoteiymd}</td><td>支社統計用診査予定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkousinymd sstkousinymd}</td><td>支社統計用更新年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstryousyuuymd sstryousyuuymd}</td><td>支社統計用領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstfstpryousyuuymd sstfstpryousyuuymd}</td><td>支社統計用初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstfstpnyknsyoriymd sstfstpnyknsyoriymd}</td><td>支社統計用初回Ｐ入金処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstfstpnyknnaiyoukbn sstfstpnyknnaiyoukbn}</td><td>支社統計用初回Ｐ入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstfstpnyknhouhoukbn2 sstfstpnyknhouhoukbn2}</td><td>支社統計用初回Ｐ入金方法区分（２文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstdrtenpaperlessmoshyj sstdrtenpaperlessmoshyj}</td><td>支社統計用代理店ペーパーレス申込表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstdrtenmostousyaukeymd sstdrtenmostousyaukeymd}</td><td>支社統計用代理店申込書当社受付年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstmkhyoutiyensysnikoukbn sstmkhyoutiyensysnikoukbn}</td><td>支社統計用目標到達時円建終身保障移行区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsyksbyensitihsyutkykhyj sstsyksbyensitihsyutkykhyj}</td><td>支社統計用初期死亡時円換算最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstjyudkaigomehrtkarihyj sstjyudkaigomehrtkarihyj}</td><td>支社統計用重度介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstfstphrkgksiteituuka sstfstphrkgksiteituuka}</td><td>支社統計用初回Ｐ払込必要額（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSstteirituhaibunwari sstteirituhaibunwari}</td><td>支社統計用定率部分配分割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsueokikknkbn sstsueokikknkbn}</td><td>支社統計用据置期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstnksyuruikbn1 sstnksyuruikbn1}</td><td>支社統計用年金種類（１文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsetaitemosno sstsetaitemosno}</td><td>支社統計用セット相手申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstyakkanjyuryouhoukbn sstyakkanjyuryouhoukbn}</td><td>支社統計用約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstyakkanbunsyono sstyakkanbunsyono}</td><td>支社統計用約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkzhuritourokuhoukbn sstkzhuritourokuhoukbn}</td><td>支社統計用口座振替登録方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstdai1hknkkn sstdai1hknkkn}</td><td>支社統計用第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstcreditnyuuryokuymd sstcreditnyuuryokuymd}</td><td>支社統計用クレジット入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstcreditmiryou sstcreditmiryou}</td><td>支社統計用クレカ未了</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstcredittrkhoukbn sstcredittrkhoukbn}</td><td>支社統計用クレジット登録方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstcardbrandkbn sstcardbrandkbn}</td><td>支社統計用カードブランド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstcarddatasousinymd sstcarddatasousinymd}</td><td>支社統計用カードデータ送信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkzktrkservicekbn sstkzktrkservicekbn}</td><td>支社統計用ご家族登録サービス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkykdrtkykarihyj sstkykdrtkykarihyj}</td><td>支社統計用契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstteikishrtkykarihyouji sstteikishrtkykarihyouji}</td><td>支社統計用定期支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstteikishrkinshrtuukakbn sstteikishrkinshrtuukakbn}</td><td>支社統計用定期支払金支払通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstteikisiharaikin sstteikisiharaikin}</td><td>支社統計用定期支払金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSstkoureikzksetumeihoukbn sstkoureikzksetumeihoukbn}</td><td>支社統計用高齢者ご家族等説明方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkoureimndnhukusuukaikbn sstkoureimndnhukusuukaikbn}</td><td>支社統計用高齢者面談複数回実施区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstkoureitratkisyaigidskkbn sstkoureitratkisyaigidskkbn}</td><td>支社統計用高齢者取扱者以外同席区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSsthknsyukigou ssthknsyukigou}</td><td>支社統計用保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstsaimnkkykhyj sstsaimnkkykhyj}</td><td>支社統計用才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstnnknsnpssysyup sstnnknsnpssysyup}</td><td>支社統計用年換算Ｐ算出用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSstnnknsnpssykwsrate sstnnknsnpssykwsrate}</td><td>支社統計用年換算Ｐ算出用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSstzennoup sstzennoup}</td><td>支社統計用前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getSstkzktuutityokusoukbn sstkzktuutityokusoukbn}</td><td>支社統計用ご家族通知直送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSstnenkinzeiseitokuyakukbn sstnenkinzeiseitokuyakukbn}</td><td>支社統計用年金税制特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SisyaToukeiHokan
 * @see     PKHT_SisyaToukeiHokan
 * @see     QHT_SisyaToukeiHokan
 * @see     GenQHT_SisyaToukeiHokan
 */
@MappedSuperclass
@Table(name=GenHT_SisyaToukeiHokan.TABLE_NAME)
@IdClass(value=PKHT_SisyaToukeiHokan.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenHT_SisyaToukeiHokan extends AbstractExDBEntity<HT_SisyaToukeiHokan, PKHT_SisyaToukeiHokan> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SisyaToukeiHokan";
    public static final String SSTMOSNO                 = "sstmosno";
    public static final String RENNO                    = "renno";
    public static final String SYRCTRLTBLKOSTIME        = "syrctrltblkostime";
    public static final String SSTSYONO                 = "sstsyono";
    public static final String SSTMOSYM                 = "sstmosym";
    public static final String SSTMOSKBN                = "sstmoskbn";
    public static final String SSTBOSYUUDRTENATKIKEITAIKBN = "sstbosyuudrtenatkikeitaikbn";
    public static final String SSTKYDATKIKBN            = "sstkydatkikbn";
    public static final String SSTATUKAISYADRTENHYOUJI  = "sstatukaisyadrtenhyouji";
    public static final String TRATKIAGCD               = "tratkiagcd";
    public static final String SSTEIGYOUHONBUSISYACD    = "ssteigyouhonbusisyacd";
    public static final String SSTSOSIKICD              = "sstsosikicd";
    public static final String SSTATKISYAGYSKKJSOSIKICD = "sstatkisyagyskkjsosikicd";
    public static final String SSTCIFCD                 = "sstcifcd";
    public static final String SSTATKISYADRTENATKIWARI  = "sstatkisyadrtenatkiwari";
    public static final String SSTTSRYBNWARI            = "ssttsrybnwari";
    public static final String SSTSINHSYS               = "sstsinhsys";
    public static final String SSTSOUKENSUU             = "sstsoukensuu";
    public static final String SSTKYDATKIDAIRITENCD     = "sstkydatkidairitencd";
    public static final String SSTBOSYUUDRTENKOBETUINFO1 = "sstbosyuudrtenkobetuinfo1";
    public static final String SSTBOSYUUDRTENKOBETUINFO2 = "sstbosyuudrtenkobetuinfo2";
    public static final String SSTBOSYUUDRTENKOBETUINFO3 = "sstbosyuudrtenkobetuinfo3";
    public static final String SSTBOSYUUDRTENKOBETUINFO4 = "sstbosyuudrtenkobetuinfo4";
    public static final String SSTBOSYUUDRTENKOBETUINFO5 = "sstbosyuudrtenkobetuinfo5";
    public static final String SSTBANKKOUINCD           = "sstbankkouincd";
    public static final String SSTDAIHYOUBOSYUUNINCD    = "sstdaihyoubosyuunincd";
    public static final String SSTATUKAIKOJINCD         = "sstatukaikojincd";
    public static final String SSTKANJIHIHOKENSYANM     = "sstkanjihihokensyanm";
    public static final String SSTTANSYUKUKJHHKNNM      = "ssttansyukukjhhknnm";
    public static final String SSTHHKNSYOKUGYOUCD       = "ssthhknsyokugyoucd";
    public static final String SSTHHKNNEN2KETA          = "ssthhknnen2keta";
    public static final String SSTHHKNSEIKBN            = "ssthhknseikbn";
    public static final String SSTHHKNSEIYMD            = "ssthhknseiymd";
    public static final String SSTKJKYKNM               = "sstkjkyknm";
    public static final String SSTKJKYKNM10             = "sstkjkyknm10";
    public static final String SSTKNKYKNM15             = "sstknkyknm15";
    public static final String SSTKNKYKNM18             = "sstknkyknm18";
    public static final String SSTKYKSYANEN             = "sstkyksyanen";
    public static final String SSTKYKSYASEIKBN          = "sstkyksyaseikbn";
    public static final String SSTHJNKYKHYJ             = "ssthjnkykhyj";
    public static final String SSTKJHJNNM               = "sstkjhjnnm";
    public static final String SSTSEIRITUYOUKIHONTIKUCD = "sstseirituyoukihontikucd";
    public static final String SSTMOSSYOUMETUKBN        = "sstmossyoumetukbn";
    public static final String SSTKURIKOSIRIYUUKBN      = "sstkurikosiriyuukbn";
    public static final String SSTNYKNZUMIHYOUJI        = "sstnyknzumihyouji";
    public static final String SSTNYKNJKKBN             = "sstnyknjkkbn";
    public static final String SSTHOUJYOUKOKUTIKBN      = "ssthoujyoukokutikbn";
    public static final String SSTKYKKEITAIKBN          = "sstkykkeitaikbn";
    public static final String SSTKETTEIJKKBN           = "sstketteijkkbn";
    public static final String SSTDAKUHIKETTEIJYOUTAIKBN = "sstdakuhiketteijyoutaikbn";
    public static final String SSTDAKUHIKETTEIKEKKACD   = "sstdakuhiketteikekkacd";
    public static final String SSTDAKUHIKETTEIYMD       = "sstdakuhiketteiymd";
    public static final String SSTTOKUSYUJIMUTORIATUKAIKBN = "ssttokusyujimutoriatukaikbn";
    public static final String SSTTOUKEIYOUSINSAKBN     = "ssttoukeiyousinsakbn";
    public static final String SSTHONNINKAKUNINKBN      = "ssthonninkakuninkbn";
    public static final String SSTDRTENTSRYHUSHRKYKHYOUJI = "sstdrtentsryhushrkykhyouji";
    public static final String SSTNYKNKANSKANOUHYOUJI   = "sstnyknkanskanouhyouji";
    public static final String SSTDSHUKAHYOUJI          = "sstdshukahyouji";
    public static final String SSTSITEIDAIRISKTKYKARIHYOUJ = "sstsiteidairisktkykarihyouj";
    public static final String SSTTOKUTEIKANIKOKUTIKBN  = "ssttokuteikanikokutikbn";
    public static final String SSTKYKKAKUNINSYURUIKBN   = "sstkykkakuninsyuruikbn";
    public static final String SSTKYKKAKUNINJKKBN1      = "sstkykkakuninjkkbn1";
    public static final String SSTMOSKETTEIKEKKAKBN     = "sstmosketteikekkakbn";
    public static final String SSTSINSAZUMIHYOUJI       = "sstsinsazumihyouji";
    public static final String SSTANNAISAKICD           = "sstannaisakicd";
    public static final String SSTMOSJKKBN              = "sstmosjkkbn";
    public static final String SSTKIHONHUBI             = "sstkihonhubi";
    public static final String SSTSPHUBI                = "sstsphubi";
    public static final String SSTSSEIGENHUBI           = "sstsseigenhubi";
    public static final String SSTNAYOSEHUMEI           = "sstnayosehumei";
    public static final String SSTTUUSANGENDOOVER       = "ssttuusangendoover";
    public static final String SSTMOSKETTEIHORYUU       = "sstmosketteihoryuu";
    public static final String SSTKYKKAKUNINJISSITYUU   = "sstkykkakuninjissityuu";
    public static final String SSTKOKUTIKETTEIHORYUU    = "sstkokutiketteihoryuu";
    public static final String SSTHONSYAKETTEIHORYUU    = "ssthonsyaketteihoryuu";
    public static final String SSTSEIYMDHUBI            = "sstseiymdhubi";
    public static final String SSTPHUSOKU               = "sstphusoku";
    public static final String SSTSEIRITUHORYUUUKETUKETYUU = "sstseirituhoryuuuketuketyuu";
    public static final String SSTPKAKIN                = "sstpkakin";
    public static final String SSTKETTEIHORYUUHUBIHYOUJI = "sstketteihoryuuhubihyouji";
    public static final String SSTSEIRITUHORYUUHUBIHYOUJI = "sstseirituhoryuuhubihyouji";
    public static final String SSTYOHURIMIRYOU          = "sstyohurimiryou";
    public static final String SSTTOUKEIYOUHKNSYURUIKBN = "ssttoukeiyouhknsyuruikbn";
    public static final String SSTHKNSYURUINM           = "ssthknsyuruinm";
    public static final String SSTHKNKKN                = "ssthknkkn";
    public static final String SSTPHRKKIKN              = "sstphrkkikn";
    public static final String SSTHRKKAISUUKBN          = "ssthrkkaisuukbn";
    public static final String SSTHRKKEIROKBN           = "ssthrkkeirokbn";
    public static final String SSTNKSHRTKYKARIHYOUJI    = "sstnkshrtkykarihyouji";
    public static final String SSTNKSHRTKYKNKKKN        = "sstnkshrtkyknkkkn";
    public static final String SSTJYUNHSYS              = "sstjyunhsys";
    public static final String SSTHSYS                  = "ssthsys";
    public static final String SSTKYKTUUKA              = "sstkyktuuka";
    public static final String SSTHRKTUUKA              = "ssthrktuuka";
    public static final String SSTTUUKATANIKBN          = "ssttuukatanikbn";
    public static final String SSTFSTPHRKGKYEN          = "sstfstphrkgkyen";
    public static final String SSTFSTPHRKGKHRKTUUKAMOJI = "sstfstphrkgkhrktuukamoji";
    public static final String SSTFSTPHRKGKGAIKA        = "sstfstphrkgkgaika";
    public static final String SSTFSTPSSHKHRKGKYEN      = "sstfstpsshkhrkgkyen";
    public static final String SSTYENNYKNTKYKARIHYOUJI  = "sstyennykntkykarihyouji";
    public static final String SSTGAIKANYKNTKYKARIHYOUJI = "sstgaikanykntkykarihyouji";
    public static final String SSYENSHRTKYKARIHYOUJI    = "ssyenshrtkykarihyouji";
    public static final String SSTKIHONSGAIKA           = "sstkihonsgaika";
    public static final String SSTTEKIYOUKAWASERATE     = "ssttekiyoukawaserate";
    public static final String SSTKAWASERATETEKIYOUYMD  = "sstkawaseratetekiyouymd";
    public static final String SSTSAKUSEIYMD            = "sstsakuseiymd";
    public static final String SSTMOSYMD                = "sstmosymd";
    public static final String SSTKOKUTIYMD             = "sstkokutiymd";
    public static final String SSTMOSNYUURYOKUYMD       = "sstmosnyuuryokuymd";
    public static final String SSTKOUZANYUURYOKUYMD     = "sstkouzanyuuryokuymd";
    public static final String SSTKYKYMD                = "sstkykymd";
    public static final String SSTSEKININKAISIYMD       = "sstsekininkaisiymd";
    public static final String SSTSISYAKETTEISYORIYMD   = "sstsisyaketteisyoriymd";
    public static final String SSTSYOUKENSAKUSEIYMD     = "sstsyoukensakuseiymd";
    public static final String SSTSEISEKIKIJYYM         = "sstseisekikijyym";
    public static final String SSTMOSSYOUMETUKAKUTEIYMD = "sstmossyoumetukakuteiymd";
    public static final String SSTDRTENKEIJYOUYM        = "sstdrtenkeijyouym";
    public static final String SSTMOSTOUTYAKUYMD        = "sstmostoutyakuymd";
    public static final String SSTKKTTOUTYAKUYMD        = "sstkkttoutyakuymd";
    public static final String SSTMOSSAKUSEIYMD         = "sstmossakuseiymd";
    public static final String SSTMOSKSNYM              = "sstmosksnym";
    public static final String SSTKARISEIRITUYMD        = "sstkariseirituymd";
    public static final String SSTSINSAYOTEIYMD         = "sstsinsayoteiymd";
    public static final String SSTKOUSINYMD             = "sstkousinymd";
    public static final String SSTRYOUSYUUYMD           = "sstryousyuuymd";
    public static final String SSTFSTPRYOUSYUUYMD       = "sstfstpryousyuuymd";
    public static final String SSTFSTPNYKNSYORIYMD      = "sstfstpnyknsyoriymd";
    public static final String SSTFSTPNYKNNAIYOUKBN     = "sstfstpnyknnaiyoukbn";
    public static final String SSTFSTPNYKNHOUHOUKBN2    = "sstfstpnyknhouhoukbn2";
    public static final String SSTDRTENPAPERLESSMOSHYJ  = "sstdrtenpaperlessmoshyj";
    public static final String SSTDRTENMOSTOUSYAUKEYMD  = "sstdrtenmostousyaukeymd";
    public static final String SSTMKHYOUTIYENSYSNIKOUKBN = "sstmkhyoutiyensysnikoukbn";
    public static final String SSTSYKSBYENSITIHSYUTKYKHYJ = "sstsyksbyensitihsyutkykhyj";
    public static final String SSTJYUDKAIGOMEHRTKARIHYJ = "sstjyudkaigomehrtkarihyj";
    public static final String SSTFSTPHRKGKSITEITUUKA   = "sstfstphrkgksiteituuka";
    public static final String SSTTEIRITUHAIBUNWARI     = "sstteirituhaibunwari";
    public static final String SSTSUEOKIKKNKBN          = "sstsueokikknkbn";
    public static final String SSTNKSYURUIKBN1          = "sstnksyuruikbn1";
    public static final String SSTSETAITEMOSNO          = "sstsetaitemosno";
    public static final String SSTYAKKANJYURYOUHOUKBN   = "sstyakkanjyuryouhoukbn";
    public static final String SSTYAKKANBUNSYONO        = "sstyakkanbunsyono";
    public static final String SSTKZHURITOUROKUHOUKBN   = "sstkzhuritourokuhoukbn";
    public static final String SSTDAI1HKNKKN            = "sstdai1hknkkn";
    public static final String SSTCREDITNYUURYOKUYMD    = "sstcreditnyuuryokuymd";
    public static final String SSTCREDITMIRYOU          = "sstcreditmiryou";
    public static final String SSTCREDITTRKHOUKBN       = "sstcredittrkhoukbn";
    public static final String SSTCARDBRANDKBN          = "sstcardbrandkbn";
    public static final String SSTCARDDATASOUSINYMD     = "sstcarddatasousinymd";
    public static final String SSTKZKTRKSERVICEKBN      = "sstkzktrkservicekbn";
    public static final String SSTKYKDRTKYKARIHYJ       = "sstkykdrtkykarihyj";
    public static final String SSTTEIKISHRTKYKARIHYOUJI = "sstteikishrtkykarihyouji";
    public static final String SSTTEIKISHRKINSHRTUUKAKBN = "sstteikishrkinshrtuukakbn";
    public static final String SSTTEIKISIHARAIKIN       = "sstteikisiharaikin";
    public static final String SSTKOUREIKZKSETUMEIHOUKBN = "sstkoureikzksetumeihoukbn";
    public static final String SSTKOUREIMNDNHUKUSUUKAIKBN = "sstkoureimndnhukusuukaikbn";
    public static final String SSTKOUREITRATKISYAIGIDSKKBN = "sstkoureitratkisyaigidskkbn";
    public static final String SSTHKNSYUKIGOU           = "ssthknsyukigou";
    public static final String SSTSAIMNKKYKHYJ          = "sstsaimnkkykhyj";
    public static final String SSTNNKNSNPSSYSYUP        = "sstnnknsnpssysyup";
    public static final String SSTNNKNSNPSSYKWSRATE     = "sstnnknsnpssykwsrate";
    public static final String SSTZENNOUP               = "sstzennoup";
    public static final String SSTKZKTUUTITYOKUSOUKBN   = "sstkzktuutityokusoukbn";
    public static final String SSTNENKINZEISEITOKUYAKUKBN = "sstnenkinzeiseitokuyakukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SisyaToukeiHokan primaryKey;

    public GenHT_SisyaToukeiHokan() {
        primaryKey = new PKHT_SisyaToukeiHokan();
    }

    public GenHT_SisyaToukeiHokan(String pSstmosno, Integer pRenno) {
        primaryKey = new PKHT_SisyaToukeiHokan(pSstmosno, pRenno);
    }

    @Transient
    @Override
    public PKHT_SisyaToukeiHokan getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SisyaToukeiHokan> getMetaClass() {
        return QHT_SisyaToukeiHokan.class;
    }

    @Id
    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSNO)
    public String getSstmosno() {
        return getPrimaryKey().getSstmosno();
    }

    public void setSstmosno(String pSstmosno) {
        getPrimaryKey().setSstmosno(pSstmosno);
    }

    @Id
    @Column(name=GenHT_SisyaToukeiHokan.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String syrctrltblkostime;

    @Column(name=GenHT_SisyaToukeiHokan.SYRCTRLTBLKOSTIME)
    public String getSyrctrltblkostime() {
        return syrctrltblkostime;
    }

    public void setSyrctrltblkostime(String pSyrctrltblkostime) {
        syrctrltblkostime = pSyrctrltblkostime;
    }

    private String sstsyono;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSYONO)
    public String getSstsyono() {
        return sstsyono;
    }

    public void setSstsyono(String pSstsyono) {
        sstsyono = pSstsyono;
    }

    private String sstmosym;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSYM)
    public String getSstmosym() {
        return sstmosym;
    }

    public void setSstmosym(String pSstmosym) {
        sstmosym = pSstmosym;
    }

    private String sstmoskbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSKBN)
    public String getSstmoskbn() {
        return sstmoskbn;
    }

    public void setSstmoskbn(String pSstmoskbn) {
        sstmoskbn = pSstmoskbn;
    }

    private String sstbosyuudrtenatkikeitaikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTBOSYUUDRTENATKIKEITAIKBN)
    public String getSstbosyuudrtenatkikeitaikbn() {
        return sstbosyuudrtenatkikeitaikbn;
    }

    public void setSstbosyuudrtenatkikeitaikbn(String pSstbosyuudrtenatkikeitaikbn) {
        sstbosyuudrtenatkikeitaikbn = pSstbosyuudrtenatkikeitaikbn;
    }

    private String sstkydatkikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYDATKIKBN)
    public String getSstkydatkikbn() {
        return sstkydatkikbn;
    }

    public void setSstkydatkikbn(String pSstkydatkikbn) {
        sstkydatkikbn = pSstkydatkikbn;
    }

    private String sstatukaisyadrtenhyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTATUKAISYADRTENHYOUJI)
    public String getSstatukaisyadrtenhyouji() {
        return sstatukaisyadrtenhyouji;
    }

    public void setSstatukaisyadrtenhyouji(String pSstatukaisyadrtenhyouji) {
        sstatukaisyadrtenhyouji = pSstatukaisyadrtenhyouji;
    }

    private String tratkiagcd;

    @Column(name=GenHT_SisyaToukeiHokan.TRATKIAGCD)
    public String getTratkiagcd() {
        return tratkiagcd;
    }

    public void setTratkiagcd(String pTratkiagcd) {
        tratkiagcd = pTratkiagcd;
    }

    private String ssteigyouhonbusisyacd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTEIGYOUHONBUSISYACD)
    public String getSsteigyouhonbusisyacd() {
        return ssteigyouhonbusisyacd;
    }

    public void setSsteigyouhonbusisyacd(String pSsteigyouhonbusisyacd) {
        ssteigyouhonbusisyacd = pSsteigyouhonbusisyacd;
    }

    private String sstsosikicd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSOSIKICD)
    public String getSstsosikicd() {
        return sstsosikicd;
    }

    public void setSstsosikicd(String pSstsosikicd) {
        sstsosikicd = pSstsosikicd;
    }

    private String sstatkisyagyskkjsosikicd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTATKISYAGYSKKJSOSIKICD)
    public String getSstatkisyagyskkjsosikicd() {
        return sstatkisyagyskkjsosikicd;
    }

    public void setSstatkisyagyskkjsosikicd(String pSstatkisyagyskkjsosikicd) {
        sstatkisyagyskkjsosikicd = pSstatkisyagyskkjsosikicd;
    }

    private String sstcifcd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTCIFCD)
    public String getSstcifcd() {
        return sstcifcd;
    }

    public void setSstcifcd(String pSstcifcd) {
        sstcifcd = pSstcifcd;
    }

    private Integer sstatkisyadrtenatkiwari;

    @Column(name=GenHT_SisyaToukeiHokan.SSTATKISYADRTENATKIWARI)
    public Integer getSstatkisyadrtenatkiwari() {
        return sstatkisyadrtenatkiwari;
    }

    public void setSstatkisyadrtenatkiwari(Integer pSstatkisyadrtenatkiwari) {
        sstatkisyadrtenatkiwari = pSstatkisyadrtenatkiwari;
    }

    private Long ssttsrybnwari;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTSRYBNWARI)
    public Long getSsttsrybnwari() {
        return ssttsrybnwari;
    }

    public void setSsttsrybnwari(Long pSsttsrybnwari) {
        ssttsrybnwari = pSsttsrybnwari;
    }

    private Long sstsinhsys;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSINHSYS)
    public Long getSstsinhsys() {
        return sstsinhsys;
    }

    public void setSstsinhsys(Long pSstsinhsys) {
        sstsinhsys = pSstsinhsys;
    }

    private Integer sstsoukensuu;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSOUKENSUU)
    public Integer getSstsoukensuu() {
        return sstsoukensuu;
    }

    public void setSstsoukensuu(Integer pSstsoukensuu) {
        sstsoukensuu = pSstsoukensuu;
    }

    private String sstkydatkidairitencd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYDATKIDAIRITENCD)
    public String getSstkydatkidairitencd() {
        return sstkydatkidairitencd;
    }

    public void setSstkydatkidairitencd(String pSstkydatkidairitencd) {
        sstkydatkidairitencd = pSstkydatkidairitencd;
    }

    private String sstbosyuudrtenkobetuinfo1;

    @Column(name=GenHT_SisyaToukeiHokan.SSTBOSYUUDRTENKOBETUINFO1)
    public String getSstbosyuudrtenkobetuinfo1() {
        return sstbosyuudrtenkobetuinfo1;
    }

    public void setSstbosyuudrtenkobetuinfo1(String pSstbosyuudrtenkobetuinfo1) {
        sstbosyuudrtenkobetuinfo1 = pSstbosyuudrtenkobetuinfo1;
    }

    private String sstbosyuudrtenkobetuinfo2;

    @Column(name=GenHT_SisyaToukeiHokan.SSTBOSYUUDRTENKOBETUINFO2)
    public String getSstbosyuudrtenkobetuinfo2() {
        return sstbosyuudrtenkobetuinfo2;
    }

    public void setSstbosyuudrtenkobetuinfo2(String pSstbosyuudrtenkobetuinfo2) {
        sstbosyuudrtenkobetuinfo2 = pSstbosyuudrtenkobetuinfo2;
    }

    private String sstbosyuudrtenkobetuinfo3;

    @Column(name=GenHT_SisyaToukeiHokan.SSTBOSYUUDRTENKOBETUINFO3)
    public String getSstbosyuudrtenkobetuinfo3() {
        return sstbosyuudrtenkobetuinfo3;
    }

    public void setSstbosyuudrtenkobetuinfo3(String pSstbosyuudrtenkobetuinfo3) {
        sstbosyuudrtenkobetuinfo3 = pSstbosyuudrtenkobetuinfo3;
    }

    private String sstbosyuudrtenkobetuinfo4;

    @Column(name=GenHT_SisyaToukeiHokan.SSTBOSYUUDRTENKOBETUINFO4)
    public String getSstbosyuudrtenkobetuinfo4() {
        return sstbosyuudrtenkobetuinfo4;
    }

    public void setSstbosyuudrtenkobetuinfo4(String pSstbosyuudrtenkobetuinfo4) {
        sstbosyuudrtenkobetuinfo4 = pSstbosyuudrtenkobetuinfo4;
    }

    private String sstbosyuudrtenkobetuinfo5;

    @Column(name=GenHT_SisyaToukeiHokan.SSTBOSYUUDRTENKOBETUINFO5)
    public String getSstbosyuudrtenkobetuinfo5() {
        return sstbosyuudrtenkobetuinfo5;
    }

    public void setSstbosyuudrtenkobetuinfo5(String pSstbosyuudrtenkobetuinfo5) {
        sstbosyuudrtenkobetuinfo5 = pSstbosyuudrtenkobetuinfo5;
    }

    private String sstbankkouincd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTBANKKOUINCD)
    public String getSstbankkouincd() {
        return sstbankkouincd;
    }

    public void setSstbankkouincd(String pSstbankkouincd) {
        sstbankkouincd = pSstbankkouincd;
    }

    private String sstdaihyoubosyuunincd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTDAIHYOUBOSYUUNINCD)
    public String getSstdaihyoubosyuunincd() {
        return sstdaihyoubosyuunincd;
    }

    public void setSstdaihyoubosyuunincd(String pSstdaihyoubosyuunincd) {
        sstdaihyoubosyuunincd = pSstdaihyoubosyuunincd;
    }

    private String sstatukaikojincd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTATUKAIKOJINCD)
    public String getSstatukaikojincd() {
        return sstatukaikojincd;
    }

    public void setSstatukaikojincd(String pSstatukaikojincd) {
        sstatukaikojincd = pSstatukaikojincd;
    }

    private String sstkanjihihokensyanm;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKANJIHIHOKENSYANM)
    public String getSstkanjihihokensyanm() {
        return sstkanjihihokensyanm;
    }

    public void setSstkanjihihokensyanm(String pSstkanjihihokensyanm) {
        sstkanjihihokensyanm = pSstkanjihihokensyanm;
    }

    private String ssttansyukukjhhknnm;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTANSYUKUKJHHKNNM)
    public String getSsttansyukukjhhknnm() {
        return ssttansyukukjhhknnm;
    }

    public void setSsttansyukukjhhknnm(String pSsttansyukukjhhknnm) {
        ssttansyukukjhhknnm = pSsttansyukukjhhknnm;
    }

    private String ssthhknsyokugyoucd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHHKNSYOKUGYOUCD)
    public String getSsthhknsyokugyoucd() {
        return ssthhknsyokugyoucd;
    }

    public void setSsthhknsyokugyoucd(String pSsthhknsyokugyoucd) {
        ssthhknsyokugyoucd = pSsthhknsyokugyoucd;
    }

    private String ssthhknnen2keta;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHHKNNEN2KETA)
    public String getSsthhknnen2keta() {
        return ssthhknnen2keta;
    }

    public void setSsthhknnen2keta(String pSsthhknnen2keta) {
        ssthhknnen2keta = pSsthhknnen2keta;
    }

    private String ssthhknseikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHHKNSEIKBN)
    public String getSsthhknseikbn() {
        return ssthhknseikbn;
    }

    public void setSsthhknseikbn(String pSsthhknseikbn) {
        ssthhknseikbn = pSsthhknseikbn;
    }

    private String ssthhknseiymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHHKNSEIYMD)
    public String getSsthhknseiymd() {
        return ssthhknseiymd;
    }

    public void setSsthhknseiymd(String pSsthhknseiymd) {
        ssthhknseiymd = pSsthhknseiymd;
    }

    private String sstkjkyknm;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKJKYKNM)
    public String getSstkjkyknm() {
        return sstkjkyknm;
    }

    public void setSstkjkyknm(String pSstkjkyknm) {
        sstkjkyknm = pSstkjkyknm;
    }

    private String sstkjkyknm10;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKJKYKNM10)
    public String getSstkjkyknm10() {
        return sstkjkyknm10;
    }

    public void setSstkjkyknm10(String pSstkjkyknm10) {
        sstkjkyknm10 = pSstkjkyknm10;
    }

    private String sstknkyknm15;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKNKYKNM15)
    public String getSstknkyknm15() {
        return sstknkyknm15;
    }

    public void setSstknkyknm15(String pSstknkyknm15) {
        sstknkyknm15 = pSstknkyknm15;
    }

    private String sstknkyknm18;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKNKYKNM18)
    public String getSstknkyknm18() {
        return sstknkyknm18;
    }

    public void setSstknkyknm18(String pSstknkyknm18) {
        sstknkyknm18 = pSstknkyknm18;
    }

    private String sstkyksyanen;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYKSYANEN)
    public String getSstkyksyanen() {
        return sstkyksyanen;
    }

    public void setSstkyksyanen(String pSstkyksyanen) {
        sstkyksyanen = pSstkyksyanen;
    }

    private String sstkyksyaseikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYKSYASEIKBN)
    public String getSstkyksyaseikbn() {
        return sstkyksyaseikbn;
    }

    public void setSstkyksyaseikbn(String pSstkyksyaseikbn) {
        sstkyksyaseikbn = pSstkyksyaseikbn;
    }

    private String ssthjnkykhyj;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHJNKYKHYJ)
    public String getSsthjnkykhyj() {
        return ssthjnkykhyj;
    }

    public void setSsthjnkykhyj(String pSsthjnkykhyj) {
        ssthjnkykhyj = pSsthjnkykhyj;
    }

    private String sstkjhjnnm;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKJHJNNM)
    public String getSstkjhjnnm() {
        return sstkjhjnnm;
    }

    public void setSstkjhjnnm(String pSstkjhjnnm) {
        sstkjhjnnm = pSstkjhjnnm;
    }

    private String sstseirituyoukihontikucd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSEIRITUYOUKIHONTIKUCD)
    public String getSstseirituyoukihontikucd() {
        return sstseirituyoukihontikucd;
    }

    public void setSstseirituyoukihontikucd(String pSstseirituyoukihontikucd) {
        sstseirituyoukihontikucd = pSstseirituyoukihontikucd;
    }

    private String sstmossyoumetukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSSYOUMETUKBN)
    public String getSstmossyoumetukbn() {
        return sstmossyoumetukbn;
    }

    public void setSstmossyoumetukbn(String pSstmossyoumetukbn) {
        sstmossyoumetukbn = pSstmossyoumetukbn;
    }

    private String sstkurikosiriyuukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKURIKOSIRIYUUKBN)
    public String getSstkurikosiriyuukbn() {
        return sstkurikosiriyuukbn;
    }

    public void setSstkurikosiriyuukbn(String pSstkurikosiriyuukbn) {
        sstkurikosiriyuukbn = pSstkurikosiriyuukbn;
    }

    private String sstnyknzumihyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTNYKNZUMIHYOUJI)
    public String getSstnyknzumihyouji() {
        return sstnyknzumihyouji;
    }

    public void setSstnyknzumihyouji(String pSstnyknzumihyouji) {
        sstnyknzumihyouji = pSstnyknzumihyouji;
    }

    private String sstnyknjkkbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTNYKNJKKBN)
    public String getSstnyknjkkbn() {
        return sstnyknjkkbn;
    }

    public void setSstnyknjkkbn(String pSstnyknjkkbn) {
        sstnyknjkkbn = pSstnyknjkkbn;
    }

    private String ssthoujyoukokutikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHOUJYOUKOKUTIKBN)
    public String getSsthoujyoukokutikbn() {
        return ssthoujyoukokutikbn;
    }

    public void setSsthoujyoukokutikbn(String pSsthoujyoukokutikbn) {
        ssthoujyoukokutikbn = pSsthoujyoukokutikbn;
    }

    private String sstkykkeitaikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYKKEITAIKBN)
    public String getSstkykkeitaikbn() {
        return sstkykkeitaikbn;
    }

    public void setSstkykkeitaikbn(String pSstkykkeitaikbn) {
        sstkykkeitaikbn = pSstkykkeitaikbn;
    }

    private String sstketteijkkbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKETTEIJKKBN)
    public String getSstketteijkkbn() {
        return sstketteijkkbn;
    }

    public void setSstketteijkkbn(String pSstketteijkkbn) {
        sstketteijkkbn = pSstketteijkkbn;
    }

    private String sstdakuhiketteijyoutaikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTDAKUHIKETTEIJYOUTAIKBN)
    public String getSstdakuhiketteijyoutaikbn() {
        return sstdakuhiketteijyoutaikbn;
    }

    public void setSstdakuhiketteijyoutaikbn(String pSstdakuhiketteijyoutaikbn) {
        sstdakuhiketteijyoutaikbn = pSstdakuhiketteijyoutaikbn;
    }

    private String sstdakuhiketteikekkacd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTDAKUHIKETTEIKEKKACD)
    public String getSstdakuhiketteikekkacd() {
        return sstdakuhiketteikekkacd;
    }

    public void setSstdakuhiketteikekkacd(String pSstdakuhiketteikekkacd) {
        sstdakuhiketteikekkacd = pSstdakuhiketteikekkacd;
    }

    private String sstdakuhiketteiymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTDAKUHIKETTEIYMD)
    public String getSstdakuhiketteiymd() {
        return sstdakuhiketteiymd;
    }

    public void setSstdakuhiketteiymd(String pSstdakuhiketteiymd) {
        sstdakuhiketteiymd = pSstdakuhiketteiymd;
    }

    private String ssttokusyujimutoriatukaikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTOKUSYUJIMUTORIATUKAIKBN)
    public String getSsttokusyujimutoriatukaikbn() {
        return ssttokusyujimutoriatukaikbn;
    }

    public void setSsttokusyujimutoriatukaikbn(String pSsttokusyujimutoriatukaikbn) {
        ssttokusyujimutoriatukaikbn = pSsttokusyujimutoriatukaikbn;
    }

    private String ssttoukeiyousinsakbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTOUKEIYOUSINSAKBN)
    public String getSsttoukeiyousinsakbn() {
        return ssttoukeiyousinsakbn;
    }

    public void setSsttoukeiyousinsakbn(String pSsttoukeiyousinsakbn) {
        ssttoukeiyousinsakbn = pSsttoukeiyousinsakbn;
    }

    private String ssthonninkakuninkbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHONNINKAKUNINKBN)
    public String getSsthonninkakuninkbn() {
        return ssthonninkakuninkbn;
    }

    public void setSsthonninkakuninkbn(String pSsthonninkakuninkbn) {
        ssthonninkakuninkbn = pSsthonninkakuninkbn;
    }

    private String sstdrtentsryhushrkykhyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTDRTENTSRYHUSHRKYKHYOUJI)
    public String getSstdrtentsryhushrkykhyouji() {
        return sstdrtentsryhushrkykhyouji;
    }

    public void setSstdrtentsryhushrkykhyouji(String pSstdrtentsryhushrkykhyouji) {
        sstdrtentsryhushrkykhyouji = pSstdrtentsryhushrkykhyouji;
    }

    private String sstnyknkanskanouhyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTNYKNKANSKANOUHYOUJI)
    public String getSstnyknkanskanouhyouji() {
        return sstnyknkanskanouhyouji;
    }

    public void setSstnyknkanskanouhyouji(String pSstnyknkanskanouhyouji) {
        sstnyknkanskanouhyouji = pSstnyknkanskanouhyouji;
    }

    private String sstdshukahyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTDSHUKAHYOUJI)
    public String getSstdshukahyouji() {
        return sstdshukahyouji;
    }

    public void setSstdshukahyouji(String pSstdshukahyouji) {
        sstdshukahyouji = pSstdshukahyouji;
    }

    private String sstsiteidairisktkykarihyouj;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSITEIDAIRISKTKYKARIHYOUJ)
    public String getSstsiteidairisktkykarihyouj() {
        return sstsiteidairisktkykarihyouj;
    }

    public void setSstsiteidairisktkykarihyouj(String pSstsiteidairisktkykarihyouj) {
        sstsiteidairisktkykarihyouj = pSstsiteidairisktkykarihyouj;
    }

    private String ssttokuteikanikokutikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTOKUTEIKANIKOKUTIKBN)
    public String getSsttokuteikanikokutikbn() {
        return ssttokuteikanikokutikbn;
    }

    public void setSsttokuteikanikokutikbn(String pSsttokuteikanikokutikbn) {
        ssttokuteikanikokutikbn = pSsttokuteikanikokutikbn;
    }

    private String sstkykkakuninsyuruikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYKKAKUNINSYURUIKBN)
    public String getSstkykkakuninsyuruikbn() {
        return sstkykkakuninsyuruikbn;
    }

    public void setSstkykkakuninsyuruikbn(String pSstkykkakuninsyuruikbn) {
        sstkykkakuninsyuruikbn = pSstkykkakuninsyuruikbn;
    }

    private String sstkykkakuninjkkbn1;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYKKAKUNINJKKBN1)
    public String getSstkykkakuninjkkbn1() {
        return sstkykkakuninjkkbn1;
    }

    public void setSstkykkakuninjkkbn1(String pSstkykkakuninjkkbn1) {
        sstkykkakuninjkkbn1 = pSstkykkakuninjkkbn1;
    }

    private String sstmosketteikekkakbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSKETTEIKEKKAKBN)
    public String getSstmosketteikekkakbn() {
        return sstmosketteikekkakbn;
    }

    public void setSstmosketteikekkakbn(String pSstmosketteikekkakbn) {
        sstmosketteikekkakbn = pSstmosketteikekkakbn;
    }

    private String sstsinsazumihyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSINSAZUMIHYOUJI)
    public String getSstsinsazumihyouji() {
        return sstsinsazumihyouji;
    }

    public void setSstsinsazumihyouji(String pSstsinsazumihyouji) {
        sstsinsazumihyouji = pSstsinsazumihyouji;
    }

    private String sstannaisakicd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTANNAISAKICD)
    public String getSstannaisakicd() {
        return sstannaisakicd;
    }

    public void setSstannaisakicd(String pSstannaisakicd) {
        sstannaisakicd = pSstannaisakicd;
    }

    private String sstmosjkkbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSJKKBN)
    public String getSstmosjkkbn() {
        return sstmosjkkbn;
    }

    public void setSstmosjkkbn(String pSstmosjkkbn) {
        sstmosjkkbn = pSstmosjkkbn;
    }

    private String sstkihonhubi;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKIHONHUBI)
    public String getSstkihonhubi() {
        return sstkihonhubi;
    }

    public void setSstkihonhubi(String pSstkihonhubi) {
        sstkihonhubi = pSstkihonhubi;
    }

    private String sstsphubi;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSPHUBI)
    public String getSstsphubi() {
        return sstsphubi;
    }

    public void setSstsphubi(String pSstsphubi) {
        sstsphubi = pSstsphubi;
    }

    private String sstsseigenhubi;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSSEIGENHUBI)
    public String getSstsseigenhubi() {
        return sstsseigenhubi;
    }

    public void setSstsseigenhubi(String pSstsseigenhubi) {
        sstsseigenhubi = pSstsseigenhubi;
    }

    private String sstnayosehumei;

    @Column(name=GenHT_SisyaToukeiHokan.SSTNAYOSEHUMEI)
    public String getSstnayosehumei() {
        return sstnayosehumei;
    }

    public void setSstnayosehumei(String pSstnayosehumei) {
        sstnayosehumei = pSstnayosehumei;
    }

    private String ssttuusangendoover;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTUUSANGENDOOVER)
    public String getSsttuusangendoover() {
        return ssttuusangendoover;
    }

    public void setSsttuusangendoover(String pSsttuusangendoover) {
        ssttuusangendoover = pSsttuusangendoover;
    }

    private String sstmosketteihoryuu;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSKETTEIHORYUU)
    public String getSstmosketteihoryuu() {
        return sstmosketteihoryuu;
    }

    public void setSstmosketteihoryuu(String pSstmosketteihoryuu) {
        sstmosketteihoryuu = pSstmosketteihoryuu;
    }

    private String sstkykkakuninjissityuu;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYKKAKUNINJISSITYUU)
    public String getSstkykkakuninjissityuu() {
        return sstkykkakuninjissityuu;
    }

    public void setSstkykkakuninjissityuu(String pSstkykkakuninjissityuu) {
        sstkykkakuninjissityuu = pSstkykkakuninjissityuu;
    }

    private String sstkokutiketteihoryuu;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKOKUTIKETTEIHORYUU)
    public String getSstkokutiketteihoryuu() {
        return sstkokutiketteihoryuu;
    }

    public void setSstkokutiketteihoryuu(String pSstkokutiketteihoryuu) {
        sstkokutiketteihoryuu = pSstkokutiketteihoryuu;
    }

    private String ssthonsyaketteihoryuu;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHONSYAKETTEIHORYUU)
    public String getSsthonsyaketteihoryuu() {
        return ssthonsyaketteihoryuu;
    }

    public void setSsthonsyaketteihoryuu(String pSsthonsyaketteihoryuu) {
        ssthonsyaketteihoryuu = pSsthonsyaketteihoryuu;
    }

    private String sstseiymdhubi;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSEIYMDHUBI)
    public String getSstseiymdhubi() {
        return sstseiymdhubi;
    }

    public void setSstseiymdhubi(String pSstseiymdhubi) {
        sstseiymdhubi = pSstseiymdhubi;
    }

    private String sstphusoku;

    @Column(name=GenHT_SisyaToukeiHokan.SSTPHUSOKU)
    public String getSstphusoku() {
        return sstphusoku;
    }

    public void setSstphusoku(String pSstphusoku) {
        sstphusoku = pSstphusoku;
    }

    private String sstseirituhoryuuuketuketyuu;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSEIRITUHORYUUUKETUKETYUU)
    public String getSstseirituhoryuuuketuketyuu() {
        return sstseirituhoryuuuketuketyuu;
    }

    public void setSstseirituhoryuuuketuketyuu(String pSstseirituhoryuuuketuketyuu) {
        sstseirituhoryuuuketuketyuu = pSstseirituhoryuuuketuketyuu;
    }

    private String sstpkakin;

    @Column(name=GenHT_SisyaToukeiHokan.SSTPKAKIN)
    public String getSstpkakin() {
        return sstpkakin;
    }

    public void setSstpkakin(String pSstpkakin) {
        sstpkakin = pSstpkakin;
    }

    private String sstketteihoryuuhubihyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKETTEIHORYUUHUBIHYOUJI)
    public String getSstketteihoryuuhubihyouji() {
        return sstketteihoryuuhubihyouji;
    }

    public void setSstketteihoryuuhubihyouji(String pSstketteihoryuuhubihyouji) {
        sstketteihoryuuhubihyouji = pSstketteihoryuuhubihyouji;
    }

    private String sstseirituhoryuuhubihyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSEIRITUHORYUUHUBIHYOUJI)
    public String getSstseirituhoryuuhubihyouji() {
        return sstseirituhoryuuhubihyouji;
    }

    public void setSstseirituhoryuuhubihyouji(String pSstseirituhoryuuhubihyouji) {
        sstseirituhoryuuhubihyouji = pSstseirituhoryuuhubihyouji;
    }

    private String sstyohurimiryou;

    @Column(name=GenHT_SisyaToukeiHokan.SSTYOHURIMIRYOU)
    public String getSstyohurimiryou() {
        return sstyohurimiryou;
    }

    public void setSstyohurimiryou(String pSstyohurimiryou) {
        sstyohurimiryou = pSstyohurimiryou;
    }

    private String ssttoukeiyouhknsyuruikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTOUKEIYOUHKNSYURUIKBN)
    public String getSsttoukeiyouhknsyuruikbn() {
        return ssttoukeiyouhknsyuruikbn;
    }

    public void setSsttoukeiyouhknsyuruikbn(String pSsttoukeiyouhknsyuruikbn) {
        ssttoukeiyouhknsyuruikbn = pSsttoukeiyouhknsyuruikbn;
    }

    private String ssthknsyuruinm;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHKNSYURUINM)
    public String getSsthknsyuruinm() {
        return ssthknsyuruinm;
    }

    public void setSsthknsyuruinm(String pSsthknsyuruinm) {
        ssthknsyuruinm = pSsthknsyuruinm;
    }

    private String ssthknkkn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHKNKKN)
    public String getSsthknkkn() {
        return ssthknkkn;
    }

    public void setSsthknkkn(String pSsthknkkn) {
        ssthknkkn = pSsthknkkn;
    }

    private String sstphrkkikn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTPHRKKIKN)
    public String getSstphrkkikn() {
        return sstphrkkikn;
    }

    public void setSstphrkkikn(String pSstphrkkikn) {
        sstphrkkikn = pSstphrkkikn;
    }

    private String ssthrkkaisuukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHRKKAISUUKBN)
    public String getSsthrkkaisuukbn() {
        return ssthrkkaisuukbn;
    }

    public void setSsthrkkaisuukbn(String pSsthrkkaisuukbn) {
        ssthrkkaisuukbn = pSsthrkkaisuukbn;
    }

    private String ssthrkkeirokbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHRKKEIROKBN)
    public String getSsthrkkeirokbn() {
        return ssthrkkeirokbn;
    }

    public void setSsthrkkeirokbn(String pSsthrkkeirokbn) {
        ssthrkkeirokbn = pSsthrkkeirokbn;
    }

    private String sstnkshrtkykarihyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTNKSHRTKYKARIHYOUJI)
    public String getSstnkshrtkykarihyouji() {
        return sstnkshrtkykarihyouji;
    }

    public void setSstnkshrtkykarihyouji(String pSstnkshrtkykarihyouji) {
        sstnkshrtkykarihyouji = pSstnkshrtkykarihyouji;
    }

    private String sstnkshrtkyknkkkn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTNKSHRTKYKNKKKN)
    public String getSstnkshrtkyknkkkn() {
        return sstnkshrtkyknkkkn;
    }

    public void setSstnkshrtkyknkkkn(String pSstnkshrtkyknkkkn) {
        sstnkshrtkyknkkkn = pSstnkshrtkyknkkkn;
    }

    private Long sstjyunhsys;

    @Column(name=GenHT_SisyaToukeiHokan.SSTJYUNHSYS)
    public Long getSstjyunhsys() {
        return sstjyunhsys;
    }

    public void setSstjyunhsys(Long pSstjyunhsys) {
        sstjyunhsys = pSstjyunhsys;
    }

    private Long ssthsys;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHSYS)
    public Long getSsthsys() {
        return ssthsys;
    }

    public void setSsthsys(Long pSsthsys) {
        ssthsys = pSsthsys;
    }

    private String sstkyktuuka;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYKTUUKA)
    public String getSstkyktuuka() {
        return sstkyktuuka;
    }

    public void setSstkyktuuka(String pSstkyktuuka) {
        sstkyktuuka = pSstkyktuuka;
    }

    private String ssthrktuuka;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHRKTUUKA)
    public String getSsthrktuuka() {
        return ssthrktuuka;
    }

    public void setSsthrktuuka(String pSsthrktuuka) {
        ssthrktuuka = pSsthrktuuka;
    }

    private String ssttuukatanikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTUUKATANIKBN)
    public String getSsttuukatanikbn() {
        return ssttuukatanikbn;
    }

    public void setSsttuukatanikbn(String pSsttuukatanikbn) {
        ssttuukatanikbn = pSsttuukatanikbn;
    }

    private Long sstfstphrkgkyen;

    @Column(name=GenHT_SisyaToukeiHokan.SSTFSTPHRKGKYEN)
    public Long getSstfstphrkgkyen() {
        return sstfstphrkgkyen;
    }

    public void setSstfstphrkgkyen(Long pSstfstphrkgkyen) {
        sstfstphrkgkyen = pSstfstphrkgkyen;
    }

    private String sstfstphrkgkhrktuukamoji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTFSTPHRKGKHRKTUUKAMOJI)
    public String getSstfstphrkgkhrktuukamoji() {
        return sstfstphrkgkhrktuukamoji;
    }

    public void setSstfstphrkgkhrktuukamoji(String pSstfstphrkgkhrktuukamoji) {
        sstfstphrkgkhrktuukamoji = pSstfstphrkgkhrktuukamoji;
    }

    private BizNumber sstfstphrkgkgaika;

    @Type(type="BizNumberType")
    @Column(name=GenHT_SisyaToukeiHokan.SSTFSTPHRKGKGAIKA)
    public BizNumber getSstfstphrkgkgaika() {
        return sstfstphrkgkgaika;
    }

    public void setSstfstphrkgkgaika(BizNumber pSstfstphrkgkgaika) {
        sstfstphrkgkgaika = pSstfstphrkgkgaika;
    }

    private Long sstfstpsshkhrkgkyen;

    @Column(name=GenHT_SisyaToukeiHokan.SSTFSTPSSHKHRKGKYEN)
    public Long getSstfstpsshkhrkgkyen() {
        return sstfstpsshkhrkgkyen;
    }

    public void setSstfstpsshkhrkgkyen(Long pSstfstpsshkhrkgkyen) {
        sstfstpsshkhrkgkyen = pSstfstpsshkhrkgkyen;
    }

    private String sstyennykntkykarihyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTYENNYKNTKYKARIHYOUJI)
    public String getSstyennykntkykarihyouji() {
        return sstyennykntkykarihyouji;
    }

    public void setSstyennykntkykarihyouji(String pSstyennykntkykarihyouji) {
        sstyennykntkykarihyouji = pSstyennykntkykarihyouji;
    }

    private String sstgaikanykntkykarihyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTGAIKANYKNTKYKARIHYOUJI)
    public String getSstgaikanykntkykarihyouji() {
        return sstgaikanykntkykarihyouji;
    }

    public void setSstgaikanykntkykarihyouji(String pSstgaikanykntkykarihyouji) {
        sstgaikanykntkykarihyouji = pSstgaikanykntkykarihyouji;
    }

    private String ssyenshrtkykarihyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSYENSHRTKYKARIHYOUJI)
    public String getSsyenshrtkykarihyouji() {
        return ssyenshrtkykarihyouji;
    }

    public void setSsyenshrtkykarihyouji(String pSsyenshrtkykarihyouji) {
        ssyenshrtkykarihyouji = pSsyenshrtkykarihyouji;
    }

    private BizNumber sstkihonsgaika;

    @Type(type="BizNumberType")
    @Column(name=GenHT_SisyaToukeiHokan.SSTKIHONSGAIKA)
    public BizNumber getSstkihonsgaika() {
        return sstkihonsgaika;
    }

    public void setSstkihonsgaika(BizNumber pSstkihonsgaika) {
        sstkihonsgaika = pSstkihonsgaika;
    }

    private BizNumber ssttekiyoukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenHT_SisyaToukeiHokan.SSTTEKIYOUKAWASERATE)
    public BizNumber getSsttekiyoukawaserate() {
        return ssttekiyoukawaserate;
    }

    public void setSsttekiyoukawaserate(BizNumber pSsttekiyoukawaserate) {
        ssttekiyoukawaserate = pSsttekiyoukawaserate;
    }

    private String sstkawaseratetekiyouymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKAWASERATETEKIYOUYMD)
    public String getSstkawaseratetekiyouymd() {
        return sstkawaseratetekiyouymd;
    }

    public void setSstkawaseratetekiyouymd(String pSstkawaseratetekiyouymd) {
        sstkawaseratetekiyouymd = pSstkawaseratetekiyouymd;
    }

    private String sstsakuseiymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSAKUSEIYMD)
    public String getSstsakuseiymd() {
        return sstsakuseiymd;
    }

    public void setSstsakuseiymd(String pSstsakuseiymd) {
        sstsakuseiymd = pSstsakuseiymd;
    }

    private String sstmosymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSYMD)
    public String getSstmosymd() {
        return sstmosymd;
    }

    public void setSstmosymd(String pSstmosymd) {
        sstmosymd = pSstmosymd;
    }

    private String sstkokutiymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKOKUTIYMD)
    public String getSstkokutiymd() {
        return sstkokutiymd;
    }

    public void setSstkokutiymd(String pSstkokutiymd) {
        sstkokutiymd = pSstkokutiymd;
    }

    private String sstmosnyuuryokuymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSNYUURYOKUYMD)
    public String getSstmosnyuuryokuymd() {
        return sstmosnyuuryokuymd;
    }

    public void setSstmosnyuuryokuymd(String pSstmosnyuuryokuymd) {
        sstmosnyuuryokuymd = pSstmosnyuuryokuymd;
    }

    private String sstkouzanyuuryokuymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKOUZANYUURYOKUYMD)
    public String getSstkouzanyuuryokuymd() {
        return sstkouzanyuuryokuymd;
    }

    public void setSstkouzanyuuryokuymd(String pSstkouzanyuuryokuymd) {
        sstkouzanyuuryokuymd = pSstkouzanyuuryokuymd;
    }

    private String sstkykymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYKYMD)
    public String getSstkykymd() {
        return sstkykymd;
    }

    public void setSstkykymd(String pSstkykymd) {
        sstkykymd = pSstkykymd;
    }

    private String sstsekininkaisiymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSEKININKAISIYMD)
    public String getSstsekininkaisiymd() {
        return sstsekininkaisiymd;
    }

    public void setSstsekininkaisiymd(String pSstsekininkaisiymd) {
        sstsekininkaisiymd = pSstsekininkaisiymd;
    }

    private String sstsisyaketteisyoriymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSISYAKETTEISYORIYMD)
    public String getSstsisyaketteisyoriymd() {
        return sstsisyaketteisyoriymd;
    }

    public void setSstsisyaketteisyoriymd(String pSstsisyaketteisyoriymd) {
        sstsisyaketteisyoriymd = pSstsisyaketteisyoriymd;
    }

    private String sstsyoukensakuseiymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSYOUKENSAKUSEIYMD)
    public String getSstsyoukensakuseiymd() {
        return sstsyoukensakuseiymd;
    }

    public void setSstsyoukensakuseiymd(String pSstsyoukensakuseiymd) {
        sstsyoukensakuseiymd = pSstsyoukensakuseiymd;
    }

    private String sstseisekikijyym;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSEISEKIKIJYYM)
    public String getSstseisekikijyym() {
        return sstseisekikijyym;
    }

    public void setSstseisekikijyym(String pSstseisekikijyym) {
        sstseisekikijyym = pSstseisekikijyym;
    }

    private String sstmossyoumetukakuteiymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSSYOUMETUKAKUTEIYMD)
    public String getSstmossyoumetukakuteiymd() {
        return sstmossyoumetukakuteiymd;
    }

    public void setSstmossyoumetukakuteiymd(String pSstmossyoumetukakuteiymd) {
        sstmossyoumetukakuteiymd = pSstmossyoumetukakuteiymd;
    }

    private String sstdrtenkeijyouym;

    @Column(name=GenHT_SisyaToukeiHokan.SSTDRTENKEIJYOUYM)
    public String getSstdrtenkeijyouym() {
        return sstdrtenkeijyouym;
    }

    public void setSstdrtenkeijyouym(String pSstdrtenkeijyouym) {
        sstdrtenkeijyouym = pSstdrtenkeijyouym;
    }

    private String sstmostoutyakuymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSTOUTYAKUYMD)
    public String getSstmostoutyakuymd() {
        return sstmostoutyakuymd;
    }

    public void setSstmostoutyakuymd(String pSstmostoutyakuymd) {
        sstmostoutyakuymd = pSstmostoutyakuymd;
    }

    private String sstkkttoutyakuymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKKTTOUTYAKUYMD)
    public String getSstkkttoutyakuymd() {
        return sstkkttoutyakuymd;
    }

    public void setSstkkttoutyakuymd(String pSstkkttoutyakuymd) {
        sstkkttoutyakuymd = pSstkkttoutyakuymd;
    }

    private String sstmossakuseiymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSSAKUSEIYMD)
    public String getSstmossakuseiymd() {
        return sstmossakuseiymd;
    }

    public void setSstmossakuseiymd(String pSstmossakuseiymd) {
        sstmossakuseiymd = pSstmossakuseiymd;
    }

    private String sstmosksnym;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMOSKSNYM)
    public String getSstmosksnym() {
        return sstmosksnym;
    }

    public void setSstmosksnym(String pSstmosksnym) {
        sstmosksnym = pSstmosksnym;
    }

    private String sstkariseirituymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKARISEIRITUYMD)
    public String getSstkariseirituymd() {
        return sstkariseirituymd;
    }

    public void setSstkariseirituymd(String pSstkariseirituymd) {
        sstkariseirituymd = pSstkariseirituymd;
    }

    private String sstsinsayoteiymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSINSAYOTEIYMD)
    public String getSstsinsayoteiymd() {
        return sstsinsayoteiymd;
    }

    public void setSstsinsayoteiymd(String pSstsinsayoteiymd) {
        sstsinsayoteiymd = pSstsinsayoteiymd;
    }

    private String sstkousinymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKOUSINYMD)
    public String getSstkousinymd() {
        return sstkousinymd;
    }

    public void setSstkousinymd(String pSstkousinymd) {
        sstkousinymd = pSstkousinymd;
    }

    private String sstryousyuuymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTRYOUSYUUYMD)
    public String getSstryousyuuymd() {
        return sstryousyuuymd;
    }

    public void setSstryousyuuymd(String pSstryousyuuymd) {
        sstryousyuuymd = pSstryousyuuymd;
    }

    private String sstfstpryousyuuymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTFSTPRYOUSYUUYMD)
    public String getSstfstpryousyuuymd() {
        return sstfstpryousyuuymd;
    }

    public void setSstfstpryousyuuymd(String pSstfstpryousyuuymd) {
        sstfstpryousyuuymd = pSstfstpryousyuuymd;
    }

    private String sstfstpnyknsyoriymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTFSTPNYKNSYORIYMD)
    public String getSstfstpnyknsyoriymd() {
        return sstfstpnyknsyoriymd;
    }

    public void setSstfstpnyknsyoriymd(String pSstfstpnyknsyoriymd) {
        sstfstpnyknsyoriymd = pSstfstpnyknsyoriymd;
    }

    private String sstfstpnyknnaiyoukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTFSTPNYKNNAIYOUKBN)
    public String getSstfstpnyknnaiyoukbn() {
        return sstfstpnyknnaiyoukbn;
    }

    public void setSstfstpnyknnaiyoukbn(String pSstfstpnyknnaiyoukbn) {
        sstfstpnyknnaiyoukbn = pSstfstpnyknnaiyoukbn;
    }

    private String sstfstpnyknhouhoukbn2;

    @Column(name=GenHT_SisyaToukeiHokan.SSTFSTPNYKNHOUHOUKBN2)
    public String getSstfstpnyknhouhoukbn2() {
        return sstfstpnyknhouhoukbn2;
    }

    public void setSstfstpnyknhouhoukbn2(String pSstfstpnyknhouhoukbn2) {
        sstfstpnyknhouhoukbn2 = pSstfstpnyknhouhoukbn2;
    }

    private String sstdrtenpaperlessmoshyj;

    @Column(name=GenHT_SisyaToukeiHokan.SSTDRTENPAPERLESSMOSHYJ)
    public String getSstdrtenpaperlessmoshyj() {
        return sstdrtenpaperlessmoshyj;
    }

    public void setSstdrtenpaperlessmoshyj(String pSstdrtenpaperlessmoshyj) {
        sstdrtenpaperlessmoshyj = pSstdrtenpaperlessmoshyj;
    }

    private String sstdrtenmostousyaukeymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTDRTENMOSTOUSYAUKEYMD)
    public String getSstdrtenmostousyaukeymd() {
        return sstdrtenmostousyaukeymd;
    }

    public void setSstdrtenmostousyaukeymd(String pSstdrtenmostousyaukeymd) {
        sstdrtenmostousyaukeymd = pSstdrtenmostousyaukeymd;
    }

    private String sstmkhyoutiyensysnikoukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTMKHYOUTIYENSYSNIKOUKBN)
    public String getSstmkhyoutiyensysnikoukbn() {
        return sstmkhyoutiyensysnikoukbn;
    }

    public void setSstmkhyoutiyensysnikoukbn(String pSstmkhyoutiyensysnikoukbn) {
        sstmkhyoutiyensysnikoukbn = pSstmkhyoutiyensysnikoukbn;
    }

    private String sstsyksbyensitihsyutkykhyj;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSYKSBYENSITIHSYUTKYKHYJ)
    public String getSstsyksbyensitihsyutkykhyj() {
        return sstsyksbyensitihsyutkykhyj;
    }

    public void setSstsyksbyensitihsyutkykhyj(String pSstsyksbyensitihsyutkykhyj) {
        sstsyksbyensitihsyutkykhyj = pSstsyksbyensitihsyutkykhyj;
    }

    private String sstjyudkaigomehrtkarihyj;

    @Column(name=GenHT_SisyaToukeiHokan.SSTJYUDKAIGOMEHRTKARIHYJ)
    public String getSstjyudkaigomehrtkarihyj() {
        return sstjyudkaigomehrtkarihyj;
    }

    public void setSstjyudkaigomehrtkarihyj(String pSstjyudkaigomehrtkarihyj) {
        sstjyudkaigomehrtkarihyj = pSstjyudkaigomehrtkarihyj;
    }

    private BizNumber sstfstphrkgksiteituuka;

    @Type(type="BizNumberType")
    @Column(name=GenHT_SisyaToukeiHokan.SSTFSTPHRKGKSITEITUUKA)
    public BizNumber getSstfstphrkgksiteituuka() {
        return sstfstphrkgksiteituuka;
    }

    public void setSstfstphrkgksiteituuka(BizNumber pSstfstphrkgksiteituuka) {
        sstfstphrkgksiteituuka = pSstfstphrkgksiteituuka;
    }

    private String sstteirituhaibunwari;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTEIRITUHAIBUNWARI)
    public String getSstteirituhaibunwari() {
        return sstteirituhaibunwari;
    }

    public void setSstteirituhaibunwari(String pSstteirituhaibunwari) {
        sstteirituhaibunwari = pSstteirituhaibunwari;
    }

    private String sstsueokikknkbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSUEOKIKKNKBN)
    public String getSstsueokikknkbn() {
        return sstsueokikknkbn;
    }

    public void setSstsueokikknkbn(String pSstsueokikknkbn) {
        sstsueokikknkbn = pSstsueokikknkbn;
    }

    private String sstnksyuruikbn1;

    @Column(name=GenHT_SisyaToukeiHokan.SSTNKSYURUIKBN1)
    public String getSstnksyuruikbn1() {
        return sstnksyuruikbn1;
    }

    public void setSstnksyuruikbn1(String pSstnksyuruikbn1) {
        sstnksyuruikbn1 = pSstnksyuruikbn1;
    }

    private String sstsetaitemosno;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSETAITEMOSNO)
    public String getSstsetaitemosno() {
        return sstsetaitemosno;
    }

    public void setSstsetaitemosno(String pSstsetaitemosno) {
        sstsetaitemosno = pSstsetaitemosno;
    }

    private String sstyakkanjyuryouhoukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTYAKKANJYURYOUHOUKBN)
    public String getSstyakkanjyuryouhoukbn() {
        return sstyakkanjyuryouhoukbn;
    }

    public void setSstyakkanjyuryouhoukbn(String pSstyakkanjyuryouhoukbn) {
        sstyakkanjyuryouhoukbn = pSstyakkanjyuryouhoukbn;
    }

    private String sstyakkanbunsyono;

    @Column(name=GenHT_SisyaToukeiHokan.SSTYAKKANBUNSYONO)
    public String getSstyakkanbunsyono() {
        return sstyakkanbunsyono;
    }

    public void setSstyakkanbunsyono(String pSstyakkanbunsyono) {
        sstyakkanbunsyono = pSstyakkanbunsyono;
    }

    private String sstkzhuritourokuhoukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKZHURITOUROKUHOUKBN)
    public String getSstkzhuritourokuhoukbn() {
        return sstkzhuritourokuhoukbn;
    }

    public void setSstkzhuritourokuhoukbn(String pSstkzhuritourokuhoukbn) {
        sstkzhuritourokuhoukbn = pSstkzhuritourokuhoukbn;
    }

    private String sstdai1hknkkn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTDAI1HKNKKN)
    public String getSstdai1hknkkn() {
        return sstdai1hknkkn;
    }

    public void setSstdai1hknkkn(String pSstdai1hknkkn) {
        sstdai1hknkkn = pSstdai1hknkkn;
    }

    private String sstcreditnyuuryokuymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTCREDITNYUURYOKUYMD)
    public String getSstcreditnyuuryokuymd() {
        return sstcreditnyuuryokuymd;
    }

    public void setSstcreditnyuuryokuymd(String pSstcreditnyuuryokuymd) {
        sstcreditnyuuryokuymd = pSstcreditnyuuryokuymd;
    }

    private String sstcreditmiryou;

    @Column(name=GenHT_SisyaToukeiHokan.SSTCREDITMIRYOU)
    public String getSstcreditmiryou() {
        return sstcreditmiryou;
    }

    public void setSstcreditmiryou(String pSstcreditmiryou) {
        sstcreditmiryou = pSstcreditmiryou;
    }

    private String sstcredittrkhoukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTCREDITTRKHOUKBN)
    public String getSstcredittrkhoukbn() {
        return sstcredittrkhoukbn;
    }

    public void setSstcredittrkhoukbn(String pSstcredittrkhoukbn) {
        sstcredittrkhoukbn = pSstcredittrkhoukbn;
    }

    private String sstcardbrandkbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTCARDBRANDKBN)
    public String getSstcardbrandkbn() {
        return sstcardbrandkbn;
    }

    public void setSstcardbrandkbn(String pSstcardbrandkbn) {
        sstcardbrandkbn = pSstcardbrandkbn;
    }

    private String sstcarddatasousinymd;

    @Column(name=GenHT_SisyaToukeiHokan.SSTCARDDATASOUSINYMD)
    public String getSstcarddatasousinymd() {
        return sstcarddatasousinymd;
    }

    public void setSstcarddatasousinymd(String pSstcarddatasousinymd) {
        sstcarddatasousinymd = pSstcarddatasousinymd;
    }

    private String sstkzktrkservicekbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKZKTRKSERVICEKBN)
    public String getSstkzktrkservicekbn() {
        return sstkzktrkservicekbn;
    }

    public void setSstkzktrkservicekbn(String pSstkzktrkservicekbn) {
        sstkzktrkservicekbn = pSstkzktrkservicekbn;
    }

    private String sstkykdrtkykarihyj;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKYKDRTKYKARIHYJ)
    public String getSstkykdrtkykarihyj() {
        return sstkykdrtkykarihyj;
    }

    public void setSstkykdrtkykarihyj(String pSstkykdrtkykarihyj) {
        sstkykdrtkykarihyj = pSstkykdrtkykarihyj;
    }

    private String sstteikishrtkykarihyouji;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTEIKISHRTKYKARIHYOUJI)
    public String getSstteikishrtkykarihyouji() {
        return sstteikishrtkykarihyouji;
    }

    public void setSstteikishrtkykarihyouji(String pSstteikishrtkykarihyouji) {
        sstteikishrtkykarihyouji = pSstteikishrtkykarihyouji;
    }

    private String sstteikishrkinshrtuukakbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTTEIKISHRKINSHRTUUKAKBN)
    public String getSstteikishrkinshrtuukakbn() {
        return sstteikishrkinshrtuukakbn;
    }

    public void setSstteikishrkinshrtuukakbn(String pSstteikishrkinshrtuukakbn) {
        sstteikishrkinshrtuukakbn = pSstteikishrkinshrtuukakbn;
    }

    private BizNumber sstteikisiharaikin;

    @Type(type="BizNumberType")
    @Column(name=GenHT_SisyaToukeiHokan.SSTTEIKISIHARAIKIN)
    public BizNumber getSstteikisiharaikin() {
        return sstteikisiharaikin;
    }

    public void setSstteikisiharaikin(BizNumber pSstteikisiharaikin) {
        sstteikisiharaikin = pSstteikisiharaikin;
    }

    private String sstkoureikzksetumeihoukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKOUREIKZKSETUMEIHOUKBN)
    public String getSstkoureikzksetumeihoukbn() {
        return sstkoureikzksetumeihoukbn;
    }

    public void setSstkoureikzksetumeihoukbn(String pSstkoureikzksetumeihoukbn) {
        sstkoureikzksetumeihoukbn = pSstkoureikzksetumeihoukbn;
    }

    private String sstkoureimndnhukusuukaikbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKOUREIMNDNHUKUSUUKAIKBN)
    public String getSstkoureimndnhukusuukaikbn() {
        return sstkoureimndnhukusuukaikbn;
    }

    public void setSstkoureimndnhukusuukaikbn(String pSstkoureimndnhukusuukaikbn) {
        sstkoureimndnhukusuukaikbn = pSstkoureimndnhukusuukaikbn;
    }

    private String sstkoureitratkisyaigidskkbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKOUREITRATKISYAIGIDSKKBN)
    public String getSstkoureitratkisyaigidskkbn() {
        return sstkoureitratkisyaigidskkbn;
    }

    public void setSstkoureitratkisyaigidskkbn(String pSstkoureitratkisyaigidskkbn) {
        sstkoureitratkisyaigidskkbn = pSstkoureitratkisyaigidskkbn;
    }

    private String ssthknsyukigou;

    @Column(name=GenHT_SisyaToukeiHokan.SSTHKNSYUKIGOU)
    public String getSsthknsyukigou() {
        return ssthknsyukigou;
    }

    public void setSsthknsyukigou(String pSsthknsyukigou) {
        ssthknsyukigou = pSsthknsyukigou;
    }

    private String sstsaimnkkykhyj;

    @Column(name=GenHT_SisyaToukeiHokan.SSTSAIMNKKYKHYJ)
    public String getSstsaimnkkykhyj() {
        return sstsaimnkkykhyj;
    }

    public void setSstsaimnkkykhyj(String pSstsaimnkkykhyj) {
        sstsaimnkkykhyj = pSstsaimnkkykhyj;
    }

    private Long sstnnknsnpssysyup;

    @Column(name=GenHT_SisyaToukeiHokan.SSTNNKNSNPSSYSYUP)
    public Long getSstnnknsnpssysyup() {
        return sstnnknsnpssysyup;
    }

    public void setSstnnknsnpssysyup(Long pSstnnknsnpssysyup) {
        sstnnknsnpssysyup = pSstnnknsnpssysyup;
    }

    private BizNumber sstnnknsnpssykwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenHT_SisyaToukeiHokan.SSTNNKNSNPSSYKWSRATE)
    public BizNumber getSstnnknsnpssykwsrate() {
        return sstnnknsnpssykwsrate;
    }

    public void setSstnnknsnpssykwsrate(BizNumber pSstnnknsnpssykwsrate) {
        sstnnknsnpssykwsrate = pSstnnknsnpssykwsrate;
    }

    private Long sstzennoup;

    @Column(name=GenHT_SisyaToukeiHokan.SSTZENNOUP)
    public Long getSstzennoup() {
        return sstzennoup;
    }

    public void setSstzennoup(Long pSstzennoup) {
        sstzennoup = pSstzennoup;
    }

    private String sstkzktuutityokusoukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTKZKTUUTITYOKUSOUKBN)
    public String getSstkzktuutityokusoukbn() {
        return sstkzktuutityokusoukbn;
    }

    public void setSstkzktuutityokusoukbn(String pSstkzktuutityokusoukbn) {
        sstkzktuutityokusoukbn = pSstkzktuutityokusoukbn;
    }

    private String sstnenkinzeiseitokuyakukbn;

    @Column(name=GenHT_SisyaToukeiHokan.SSTNENKINZEISEITOKUYAKUKBN)
    public String getSstnenkinzeiseitokuyakukbn() {
        return sstnenkinzeiseitokuyakukbn;
    }

    public void setSstnenkinzeiseitokuyakukbn(String pSstnenkinzeiseitokuyakukbn) {
        sstnenkinzeiseitokuyakukbn = pSstnenkinzeiseitokuyakukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenHT_SisyaToukeiHokan.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SisyaToukeiHokan.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SisyaToukeiHokan.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}