package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenIpToukeiRn;
import yuyu.def.db.mapping.GenZT_DrtenIpToukeiRn;
import yuyu.def.db.meta.GenQZT_DrtenIpToukeiRn;
import yuyu.def.db.meta.QZT_DrtenIpToukeiRn;

/**
 * 代理店用ＩＰ統計用Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenIpToukeiRn}</td><td colspan="3">代理店用ＩＰ統計用Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrneigyouhonbusisyacd zrneigyouhonbusisyacd}</td><td>（連携用）営業本部支社コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsosikicd zrnsosikicd}</td><td>（連携用）組織コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnatukaikojincd zrnatukaikojincd}</td><td>（連携用）扱者個人コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnmosym zrnmosym}</td><td>（連携用）申込月度</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmoskbn</td><td>（連携用）申込区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntansyukukjatukaisyanm</td><td>（連携用）短縮漢字扱者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyoumetukbn</td><td>（連携用）申込消滅区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkurikosiriyuukbn</td><td>（連携用）繰越理由区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknzumihyouji</td><td>（連携用）入金済表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeihknsyruikbn</td><td>（連携用）統計用保険種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhjykktkbn</td><td>（連携用）報状告知区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykktaikbn</td><td>（連携用）契約形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyunhsys</td><td>（連携用）純保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnhsys</td><td>（連携用）保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsoukensuu</td><td>（連携用）総件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnketjkkbn</td><td>（連携用）決定状況区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhiktjyoutaikbn</td><td>（連携用）諾否決定状態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihonhubi</td><td>（連携用）基本不備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsphubi</td><td>（連携用）ＳＰ不備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsseigenhubi</td><td>（連携用）Ｓ制限不備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnayosehumei</td><td>（連携用）名寄不明</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuusangendoover</td><td>（連携用）通算限度オーバー</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosketteihoryuu</td><td>（連携用）申込決定保留</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykkakjissityuu</td><td>（連携用）契約確認実施中</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkktketteihoryuu</td><td>（連携用）告知決定保留</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhonsyakethoryuu</td><td>（連携用）本社決定保留</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseiymdhubi</td><td>（連携用）生年月日不備</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphusoku</td><td>（連携用）Ｐ不足</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsrhuketyu</td><td>（連携用）成立保留受付中</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpkakin</td><td>（連携用）Ｐ過金</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsudirtnatkikeitaikbn</td><td>（連携用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakuseiymd</td><td>（連携用）作成日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkydatkikbn</td><td>（連携用）共同扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntansyukukjhhknnm</td><td>（連携用）短縮漢字被保険者名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhhknsykgycd</td><td>（連携用）被保険者職業コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnen2keta</td><td>（連携用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseikbn</td><td>（連携用）被保険者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmusymd</td><td>（連携用）申込年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaipryosyuymd</td><td>（連携用）初回Ｐ領収年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkokutiymd</td><td>（連携用）告知年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmosnyuuryokuymd</td><td>（連携用）申込入力年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykymd</td><td>（連携用）契約年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsekininkaisiymd</td><td>（連携用）責任開始年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstpnyknsyoriymd</td><td>（連携用）初回Ｐ入金処理年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnfstpnyknnaiyoukbn</td><td>（連携用）初回Ｐ入金内容区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsisyaketsyoriymd</td><td>（連携用）支社決定処理年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyosakuseiymd</td><td>（連携用）証券作成年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnseisekiym</td><td>（連携用）成績計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyokaiharaikomip</td><td>（連携用）初回払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsyono</td><td>（連携用）証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntokusyujimutoriatukaikbn</td><td>（連携用）特殊事務取扱区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsydrtencd</td><td>（連携用）募集代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbsydrtenkjnm</td><td>（連携用）募集代理店漢字名称</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnatkisyagyskkjsosikicd</td><td>（連携用）扱者業績計上先組織コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnatkisyadrtenatkiwari</td><td>（連携用）扱者代理店扱割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>zrnhknkkn</td><td>（連携用）保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnphrkkikn</td><td>（連携用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkaisuukbn</td><td>（連携用）払込回数区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrkkeirokbn</td><td>（連携用）払込経路区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkinyuukikancd</td><td>（連携用）金融機関コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrninfositencd</td><td>（連携用）（情報系）支店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncifcd</td><td>（連携用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkjkyknm10</td><td>（連携用）漢字契約者名（１０文字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkthhbhyouji</td><td>（連携用）決定保留不備表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsrhhbhyouji</td><td>（連携用）成立保留不備表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmossyumtkktymd</td><td>（連携用）申込消滅確定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenjimusyocd</td><td>（連携用）代理店事務所コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntsrybnwari</td><td>（連携用）手数料分割割合</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrndrtenkeijyouym</td><td>（連携用）代理店計上年月</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkydatkidairitencd</td><td>（連携用）共同扱代理店コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndaihyoubosyuunincd</td><td>（連携用）代表募集人コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntansyukukjdhybosyuunm</td><td>（連携用）短縮漢字代表募集人名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnknkyknm15</td><td>（連携用）カナ契約者名（１５文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndakuhikettikekkacd</td><td>（連携用）諾否決定結果コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndkhktiymd</td><td>（連携用）諾否決定年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntoukeiyousinsakbn</td><td>（連携用）統計用診査区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhonninkknnkbn</td><td>（連携用）本人確認区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnstkarihyj</td><td>（連携用）年金支払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnstknkkkn</td><td>（連携用）年金支払特約年金期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtentsryhushrkykhyouji</td><td>（連携用）代理店手数料不支払契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnyknkanskanouhyouji</td><td>（連携用）入金勧奨可能表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndshukahyouji</td><td>（連携用）ＤＳ付加表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnstdairiseikyuutkykarihyj</td><td>（連携用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyanen</td><td>（連携用）契約者年令</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyksyaseikbn</td><td>（連携用）契約者性別区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknseiymd</td><td>（連携用）被保険者生年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtenpaperlessmoshyj</td><td>（連携用）代理店ペーパーレス申込表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrtenmostousyaukeymd</td><td>（連携用）代理店申込書当社受付年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyktuuka</td><td>（連携用）契約通貨</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhrktuuka</td><td>（連携用）払込通貨</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykihrkpgaika</td><td>（連携用）初回払込Ｐ（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnyennykntkarihyouji</td><td>（連携用）円入金特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrngaikanykntkarihyouji</td><td>（連携用）外貨入金特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkihonsgaika</td><td>（連携用）基本Ｓ（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrntekiyoukawaserate</td><td>（連携用）適用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkawaseratetekiyouymd</td><td>（連携用）為替レート適用年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnmkhyoutiyensysnikoukbn</td><td>（連携用）目標到達時円建終身保障移行区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyksbyensitihsyutkykhyj</td><td>（連携用）初期死亡時円換算最低保証特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnjyudkaigomehrtkarihyj</td><td>（連携用）重度介護前払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsykihrkpsiteituuka</td><td>（連携用）初回払込Ｐ（指定通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnteirituhaibunwari</td><td>（連携用）定率部分配分割合</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsueokikknkbn</td><td>（連携用）据置期間区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnksyuruikbn1</td><td>（連携用）年金種類区分（１文字）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkbtinfo1</td><td>（連携用）代理店個別情報１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkbtinfo2</td><td>（連携用）代理店個別情報２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndairitenkbtinfo3</td><td>（連携用）代理店個別情報３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyohurimiryou</td><td>（連携用）預振未了</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkznyuuryokuymd</td><td>（連携用）口座入力年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsetaitemosno</td><td>（連携用）セット相手申込番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyakkanjyuryouhoukbn</td><td>（連携用）約款受領方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyakkanbunsyono</td><td>（連携用）約款文書番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhuritourokuhoukbn</td><td>（連携用）口座振替登録方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndai1hknkkn</td><td>（連携用）第１保険期間</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditnyuuryokuymd</td><td>（連携用）クレジット入力年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditmiryou</td><td>（連携用）クレカ未了</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncredittrkhoukbn</td><td>（連携用）クレジット登録方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncardbrandkbn</td><td>（連携用）カードブランド</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrncarddatasousinymd</td><td>（連携用）カードデータ送信日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkykdrtkykarihyj</td><td>（連携用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzktrkservicekbn</td><td>（連携用）ご家族登録サービス区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikisiharaiarihyj</td><td>（連携用）定期支払特約有表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikishrkinshrtuukakbn</td><td>（連携用）定期支払金支払通貨区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnteikisiharaikin</td><td>（連携用）定期支払金</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnkoureikzksetumeihoukbn</td><td>（連携用）高齢者ご家族等説明方法区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkoureimndnhukusuukaikbn</td><td>（連携用）高齢者面談複数回実施区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkoureitratkisyaigidskkbn</td><td>（連携用）高齢者取扱者以外同席区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhknsyukigou</td><td>（連携用）保険種類記号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaimnkkykhyj</td><td>（連携用）才満期契約表示</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnnknsnpssysyup</td><td>（連携用）年換算Ｐ算出用主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnnknsnpssykwsrate</td><td>（連携用）年換算Ｐ算出用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>zrnzennoup</td><td>（連携用）前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnnenkinzeiseitokuyakukbn</td><td>（連携用）年金税制特約区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv33</td><td>（連携用）予備項目Ｖ３３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenIpToukeiRn
 * @see     GenZT_DrtenIpToukeiRn
 * @see     QZT_DrtenIpToukeiRn
 * @see     GenQZT_DrtenIpToukeiRn
 */
public class PKZT_DrtenIpToukeiRn extends AbstractExDBPrimaryKey<ZT_DrtenIpToukeiRn, PKZT_DrtenIpToukeiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenIpToukeiRn() {
    }

    public PKZT_DrtenIpToukeiRn(
        String pZrneigyouhonbusisyacd,
        String pZrnsosikicd,
        String pZrnatukaikojincd,
        String pZrnmosym,
        String pZrnmosno
    ) {
        zrneigyouhonbusisyacd = pZrneigyouhonbusisyacd;
        zrnsosikicd = pZrnsosikicd;
        zrnatukaikojincd = pZrnatukaikojincd;
        zrnmosym = pZrnmosym;
        zrnmosno = pZrnmosno;
    }

    @Transient
    @Override
    public Class<ZT_DrtenIpToukeiRn> getEntityClass() {
        return ZT_DrtenIpToukeiRn.class;
    }

    private String zrneigyouhonbusisyacd;

    public String getZrneigyouhonbusisyacd() {
        return zrneigyouhonbusisyacd;
    }

    public void setZrneigyouhonbusisyacd(String pZrneigyouhonbusisyacd) {
        zrneigyouhonbusisyacd = pZrneigyouhonbusisyacd;
    }
    private String zrnsosikicd;

    public String getZrnsosikicd() {
        return zrnsosikicd;
    }

    public void setZrnsosikicd(String pZrnsosikicd) {
        zrnsosikicd = pZrnsosikicd;
    }
    private String zrnatukaikojincd;

    public String getZrnatukaikojincd() {
        return zrnatukaikojincd;
    }

    public void setZrnatukaikojincd(String pZrnatukaikojincd) {
        zrnatukaikojincd = pZrnatukaikojincd;
    }
    private String zrnmosym;

    public String getZrnmosym() {
        return zrnmosym;
    }

    public void setZrnmosym(String pZrnmosym) {
        zrnmosym = pZrnmosym;
    }
    private String zrnmosno;

    public String getZrnmosno() {
        return zrnmosno;
    }

    public void setZrnmosno(String pZrnmosno) {
        zrnmosno = pZrnmosno;
    }

}