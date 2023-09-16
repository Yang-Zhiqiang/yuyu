package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_SisyaToukeiHokan;
import yuyu.def.db.mapping.GenHT_SisyaToukeiHokan;
import yuyu.def.db.meta.GenQHT_SisyaToukeiHokan;
import yuyu.def.db.meta.QHT_SisyaToukeiHokan;

/**
 * 支社統計保管テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SisyaToukeiHokan}</td><td colspan="3">支社統計保管テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSstmosno sstmosno}</td><td>支社統計用申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syrctrltblkostime</td><td>処理コントロールTBL更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsyono</td><td>支社統計用証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmosym</td><td>支社統計用申込月度</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmoskbn</td><td>支社統計用申込区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstbosyuudrtenatkikeitaikbn</td><td>支社統計用募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkydatkikbn</td><td>支社統計用共同扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstatukaisyadrtenhyouji</td><td>支社統計用扱者代理店表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tratkiagcd</td><td>取扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssteigyouhonbusisyacd</td><td>支社統計用営業本部支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsosikicd</td><td>支社統計用組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstatkisyagyskkjsosikicd</td><td>支社統計用扱者業績計上先組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstcifcd</td><td>支社統計用ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstatkisyadrtenatkiwari</td><td>支社統計用扱者代理店扱割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ssttsrybnwari</td><td>支社統計用手数料分割割合</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>sstsinhsys</td><td>支社統計用新保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>sstsoukensuu</td><td>支社統計用総件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sstkydatkidairitencd</td><td>支社統計用共同扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstbosyuudrtenkobetuinfo1</td><td>支社統計用募集代理店個別情報１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstbosyuudrtenkobetuinfo2</td><td>支社統計用募集代理店個別情報２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstbosyuudrtenkobetuinfo3</td><td>支社統計用募集代理店個別情報３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstbosyuudrtenkobetuinfo4</td><td>支社統計用募集代理店個別情報４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstbosyuudrtenkobetuinfo5</td><td>支社統計用募集代理店個別情報５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstbankkouincd</td><td>支社統計用銀行行員コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstdaihyoubosyuunincd</td><td>支社統計用代表募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstatukaikojincd</td><td>支社統計用扱者個人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkanjihihokensyanm</td><td>支社統計用漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssttansyukukjhhknnm</td><td>支社統計用短縮漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthhknsyokugyoucd</td><td>支社統計用被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthhknnen2keta</td><td>支社統計用被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthhknseikbn</td><td>支社統計用被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthhknseiymd</td><td>支社統計用被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkjkyknm</td><td>支社統計用漢字契約者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkjkyknm10</td><td>支社統計用漢字契約者名（１０文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstknkyknm15</td><td>支社統計用カナ契約者名（１５文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstknkyknm18</td><td>支社統計用カナ契約者名（１８文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkyksyanen</td><td>支社統計用契約者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkyksyaseikbn</td><td>支社統計用契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthjnkykhyj</td><td>支社統計用法人契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkjhjnnm</td><td>支社統計用漢字法人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstseirituyoukihontikucd</td><td>支社統計用成立率用基本地区コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmossyoumetukbn</td><td>支社統計用申込消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkurikosiriyuukbn</td><td>支社統計用繰越理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstnyknzumihyouji</td><td>支社統計用入金済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstnyknjkkbn</td><td>支社統計用入金状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthoujyoukokutikbn</td><td>支社統計用報状告知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkykkeitaikbn</td><td>支社統計用契約形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstketteijkkbn</td><td>支社統計用決定状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstdakuhiketteijyoutaikbn</td><td>支社統計用諾否決定状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstdakuhiketteikekkacd</td><td>支社統計用諾否決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstdakuhiketteiymd</td><td>支社統計用諾否決定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssttokusyujimutoriatukaikbn</td><td>支社統計用特殊事務取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssttoukeiyousinsakbn</td><td>支社統計用統計用診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthonninkakuninkbn</td><td>支社統計用本人確認区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstdrtentsryhushrkykhyouji</td><td>支社統計用代理店手数料不支払契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstnyknkanskanouhyouji</td><td>支社統計用入金勧奨可能表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstdshukahyouji</td><td>支社統計用ＤＳ付加表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsiteidairisktkykarihyouj</td><td>支社統計用指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssttokuteikanikokutikbn</td><td>支社統計用特定簡易告知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkykkakuninsyuruikbn</td><td>支社統計用契約確認種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkykkakuninjkkbn1</td><td>支社統計用契約確認状況区分（1文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmosketteikekkakbn</td><td>支社統計用申込決定結果区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsinsazumihyouji</td><td>支社統計用診査済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstannaisakicd</td><td>支社統計用案内先コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmosjkkbn</td><td>支社統計用申込状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkihonhubi</td><td>支社統計用基本不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsphubi</td><td>支社統計用ＳＰ不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsseigenhubi</td><td>支社統計用Ｓ制限不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstnayosehumei</td><td>支社統計用名寄不明</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssttuusangendoover</td><td>支社統計用通算限度オーバー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmosketteihoryuu</td><td>支社統計用申込決定保留</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkykkakuninjissityuu</td><td>支社統計用契約確認実施中</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkokutiketteihoryuu</td><td>支社統計用告知決定保留</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthonsyaketteihoryuu</td><td>支社統計用本社決定保留</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstseiymdhubi</td><td>支社統計用生年月日不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstphusoku</td><td>支社統計用Ｐ不足</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstseirituhoryuuuketuketyuu</td><td>支社統計用成立保留受付中</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstpkakin</td><td>支社統計用Ｐ過金</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstketteihoryuuhubihyouji</td><td>支社統計用決定保留不備表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstseirituhoryuuhubihyouji</td><td>支社統計用成立保留不備表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstyohurimiryou</td><td>支社統計用預振未了</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssttoukeiyouhknsyuruikbn</td><td>支社統計用統計用保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthknsyuruinm</td><td>支社統計用保険種類名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthknkkn</td><td>支社統計用保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstphrkkikn</td><td>支社統計用Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthrkkaisuukbn</td><td>支社統計用払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthrkkeirokbn</td><td>支社統計用払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstnkshrtkykarihyouji</td><td>支社統計用年金支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstnkshrtkyknkkkn</td><td>支社統計用年金支払特約年金期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstjyunhsys</td><td>支社統計用純保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ssthsys</td><td>支社統計用保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>sstkyktuuka</td><td>支社統計用契約通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthrktuuka</td><td>支社統計用払込通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssttuukatanikbn</td><td>支社統計用通貨単位区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstfstphrkgkyen</td><td>支社統計用初回Ｐ払込必要額（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>sstfstphrkgkhrktuukamoji</td><td>支社統計用初回Ｐ払込必要額（払込通貨）（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstfstphrkgkgaika</td><td>支社統計用初回Ｐ払込必要額（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sstfstpsshkhrkgkyen</td><td>支社統計用初回Ｐ差引払込額（円貨）</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>sstyennykntkykarihyouji</td><td>支社統計用円入金特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstgaikanykntkykarihyouji</td><td>支社統計用外貨入金特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssyenshrtkykarihyouji</td><td>支社統計用円支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkihonsgaika</td><td>支社統計用基本Ｓ（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ssttekiyoukawaserate</td><td>支社統計用適用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sstkawaseratetekiyouymd</td><td>支社統計用為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsakuseiymd</td><td>支社統計用作成日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmosymd</td><td>支社統計用申込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkokutiymd</td><td>支社統計用告知年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmosnyuuryokuymd</td><td>支社統計用申込入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkouzanyuuryokuymd</td><td>支社統計用口座入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkykymd</td><td>支社統計用契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsekininkaisiymd</td><td>支社統計用責任開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsisyaketteisyoriymd</td><td>支社統計用支社決定処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsyoukensakuseiymd</td><td>支社統計用証券作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstseisekikijyym</td><td>支社統計用成績計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmossyoumetukakuteiymd</td><td>支社統計用申込消滅確定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstdrtenkeijyouym</td><td>支社統計用代理店計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmostoutyakuymd</td><td>支社統計用申込書到着年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkkttoutyakuymd</td><td>支社統計用告知書到着年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmossakuseiymd</td><td>支社統計用申込書作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmosksnym</td><td>支社統計用申込起算年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkariseirituymd</td><td>支社統計用仮成立年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsinsayoteiymd</td><td>支社統計用診査予定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkousinymd</td><td>支社統計用更新年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstryousyuuymd</td><td>支社統計用領収年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstfstpryousyuuymd</td><td>支社統計用初回Ｐ領収年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstfstpnyknsyoriymd</td><td>支社統計用初回Ｐ入金処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstfstpnyknnaiyoukbn</td><td>支社統計用初回Ｐ入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstfstpnyknhouhoukbn2</td><td>支社統計用初回Ｐ入金方法区分（２文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstdrtenpaperlessmoshyj</td><td>支社統計用代理店ペーパーレス申込表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstdrtenmostousyaukeymd</td><td>支社統計用代理店申込書当社受付年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstmkhyoutiyensysnikoukbn</td><td>支社統計用目標到達時円建終身保障移行区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsyksbyensitihsyutkykhyj</td><td>支社統計用初期死亡時円換算最低保証特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstjyudkaigomehrtkarihyj</td><td>支社統計用重度介護前払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstfstphrkgksiteituuka</td><td>支社統計用初回Ｐ払込必要額（指定通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sstteirituhaibunwari</td><td>支社統計用定率部分配分割合</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsueokikknkbn</td><td>支社統計用据置期間区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstnksyuruikbn1</td><td>支社統計用年金種類（１文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsetaitemosno</td><td>支社統計用セット相手申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstyakkanjyuryouhoukbn</td><td>支社統計用約款受領方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstyakkanbunsyono</td><td>支社統計用約款文書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkzhuritourokuhoukbn</td><td>支社統計用口座振替登録方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstdai1hknkkn</td><td>支社統計用第１保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstcreditnyuuryokuymd</td><td>支社統計用クレジット入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstcreditmiryou</td><td>支社統計用クレカ未了</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstcredittrkhoukbn</td><td>支社統計用クレジット登録方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstcardbrandkbn</td><td>支社統計用カードブランド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstcarddatasousinymd</td><td>支社統計用カードデータ送信日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkzktrkservicekbn</td><td>支社統計用ご家族登録サービス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkykdrtkykarihyj</td><td>支社統計用契約者代理特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstteikishrtkykarihyouji</td><td>支社統計用定期支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstteikishrkinshrtuukakbn</td><td>支社統計用定期支払金支払通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstteikisiharaikin</td><td>支社統計用定期支払金</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sstkoureikzksetumeihoukbn</td><td>支社統計用高齢者ご家族等説明方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkoureimndnhukusuukaikbn</td><td>支社統計用高齢者面談複数回実施区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstkoureitratkisyaigidskkbn</td><td>支社統計用高齢者取扱者以外同席区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ssthknsyukigou</td><td>支社統計用保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstsaimnkkykhyj</td><td>支社統計用才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstnnknsnpssysyup</td><td>支社統計用年換算Ｐ算出用主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>sstnnknsnpssykwsrate</td><td>支社統計用年換算Ｐ算出用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>sstzennoup</td><td>支社統計用前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>sstkzktuutityokusoukbn</td><td>支社統計用ご家族通知直送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sstnenkinzeiseitokuyakukbn</td><td>支社統計用年金税制特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SisyaToukeiHokan
 * @see     GenHT_SisyaToukeiHokan
 * @see     QHT_SisyaToukeiHokan
 * @see     GenQHT_SisyaToukeiHokan
 */
public class PKHT_SisyaToukeiHokan extends AbstractExDBPrimaryKey<HT_SisyaToukeiHokan, PKHT_SisyaToukeiHokan> {

    private static final long serialVersionUID = 1L;

    public PKHT_SisyaToukeiHokan() {
    }

    public PKHT_SisyaToukeiHokan(String pSstmosno, Integer pRenno) {
        sstmosno = pSstmosno;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_SisyaToukeiHokan> getEntityClass() {
        return HT_SisyaToukeiHokan.class;
    }

    private String sstmosno;

    public String getSstmosno() {
        return sstmosno;
    }

    public void setSstmosno(String pSstmosno) {
        sstmosno = pSstmosno;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}