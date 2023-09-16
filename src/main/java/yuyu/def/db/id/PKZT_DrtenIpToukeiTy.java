package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_DrtenIpToukeiTy;
import yuyu.def.db.mapping.GenZT_DrtenIpToukeiTy;
import yuyu.def.db.meta.GenQZT_DrtenIpToukeiTy;
import yuyu.def.db.meta.QZT_DrtenIpToukeiTy;

/**
 * 代理店用ＩＰ統計用Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenIpToukeiTy}</td><td colspan="3">代理店用ＩＰ統計用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyeigyouhonbusisyacd ztyeigyouhonbusisyacd}</td><td>（中継用）営業本部支社コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysosikicd ztysosikicd}</td><td>（中継用）組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyatukaikojincd ztyatukaikojincd}</td><td>（中継用）扱者個人コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtymosym ztymosym}</td><td>（中継用）申込月度</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymoskbn</td><td>（中継用）申込区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytansyukukjatukaisyanm</td><td>（中継用）短縮漢字扱者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossyoumetukbn</td><td>（中継用）申込消滅区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykurikosiriyuukbn</td><td>（中継用）繰越理由区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknzumihyouji</td><td>（中継用）入金済表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeihknsyruikbn</td><td>（中継用）統計用保険種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhjykktkbn</td><td>（中継用）報状告知区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykktaikbn</td><td>（中継用）契約形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyunhsys</td><td>（中継用）純保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztyhsys</td><td>（中継用）保障Ｓ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysoukensuu</td><td>（中継用）総件数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyketjkkbn</td><td>（中継用）決定状況区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhiktjyoutaikbn</td><td>（中継用）諾否決定状態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihonhubi</td><td>（中継用）基本不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysphubi</td><td>（中継用）ＳＰ不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysseigenhubi</td><td>（中継用）Ｓ制限不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynayosehumei</td><td>（中継用）名寄不明</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuusangendoover</td><td>（中継用）通算限度オーバー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosketteihoryuu</td><td>（中継用）申込決定保留</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykkakjissityuu</td><td>（中継用）契約確認実施中</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykktketteihoryuu</td><td>（中継用）告知決定保留</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhonsyakethoryuu</td><td>（中継用）本社決定保留</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseiymdhubi</td><td>（中継用）生年月日不備</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphusoku</td><td>（中継用）Ｐ不足</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysrhuketyu</td><td>（中継用）成立保留受付中</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypkakin</td><td>（中継用）Ｐ過金</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsudirtnatkikeitaikbn</td><td>（中継用）募集代理店扱形態区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakuseiymd</td><td>（中継用）作成日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydatkikbn</td><td>（中継用）共同扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytansyukukjhhknnm</td><td>（中継用）短縮漢字被保険者名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknsykgycd</td><td>（中継用）被保険者職業コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnen2keta</td><td>（中継用）被保険者年令（２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymusymd</td><td>（中継用）申込年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaipryosyuymd</td><td>（中継用）初回Ｐ領収年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykokutiymd</td><td>（中継用）告知年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymosnyuuryokuymd</td><td>（中継用）申込入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysekininkaisiymd</td><td>（中継用）責任開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstpnyknsyoriymd</td><td>（中継用）初回Ｐ入金処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyfstpnyknnaiyoukbn</td><td>（中継用）初回Ｐ入金内容区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysisyaketsyoriymd</td><td>（中継用）支社決定処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyosakuseiymd</td><td>（中継用）証券作成年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyseisekiym</td><td>（中継用）成績計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyokaiharaikomip</td><td>（中継用）初回払込Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysyono</td><td>（中継用）証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytokusyujimutoriatukaikbn</td><td>（中継用）特殊事務取扱区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtencd</td><td>（中継用）募集代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybsydrtenkjnm</td><td>（中継用）募集代理店漢字名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatkisyagyskkjsosikicd</td><td>（中継用）扱者業績計上先組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyatkisyadrtenatkiwari</td><td>（中継用）扱者代理店扱割合</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztyhknkkn</td><td>（中継用）保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyphrkkikn</td><td>（中継用）Ｐ払込期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkaisuukbn</td><td>（中継用）払込回数区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeirokbn</td><td>（中継用）払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykinyuukikancd</td><td>（中継用）金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyinfositencd</td><td>（中継用）（情報系）支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycifcd</td><td>（中継用）ＣＩＦコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkyknm10</td><td>（中継用）漢字契約者名（１０文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykthhbhyouji</td><td>（中継用）決定保留不備表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysrhhbhyouji</td><td>（中継用）成立保留不備表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymossyumtkktymd</td><td>（中継用）申込消滅確定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenjimusyocd</td><td>（中継用）代理店事務所コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytsrybnwari</td><td>（中継用）手数料分割割合</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztydrtenkeijyouym</td><td>（中継用）代理店計上年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykydatkidairitencd</td><td>（中継用）共同扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydaihyoubosyuunincd</td><td>（中継用）代表募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytansyukukjdhybosyuunm</td><td>（中継用）短縮漢字代表募集人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknkyknm15</td><td>（中継用）カナ契約者名（１５文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydakuhikettikekkacd</td><td>（中継用）諾否決定結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydkhktiymd</td><td>（中継用）諾否決定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytoukeiyousinsakbn</td><td>（中継用）統計用診査区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhonninkknnkbn</td><td>（中継用）本人確認区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynstkarihyj</td><td>（中継用）年金支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynstknkkkn</td><td>（中継用）年金支払特約年金期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrtentsryhushrkykhyouji</td><td>（中継用）代理店手数料不支払契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynyknkanskanouhyouji</td><td>（中継用）入金勧奨可能表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydshukahyouji</td><td>（中継用）ＤＳ付加表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztystdairiseikyuutkykarihyj</td><td>（中継用）指定代理請求特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyanen</td><td>（中継用）契約者年令</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseikbn</td><td>（中継用）契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseiymd</td><td>（中継用）被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrtenpaperlessmoshyj</td><td>（中継用）代理店ペーパーレス申込表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydrtenmostousyaukeymd</td><td>（中継用）代理店申込書当社受付年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyktuuka</td><td>（中継用）契約通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrktuuka</td><td>（中継用）払込通貨</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykihrkpgaika</td><td>（中継用）初回払込Ｐ（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyyennykntkarihyouji</td><td>（中継用）円入金特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztygaikanykntkarihyouji</td><td>（中継用）外貨入金特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykihonsgaika</td><td>（中継用）基本Ｓ（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztytekiyoukawaserate</td><td>（中継用）適用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykawaseratetekiyouymd</td><td>（中継用）為替レート適用年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymkhyoutiyensysnikoukbn</td><td>（中継用）目標到達時円建終身保障移行区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyksbyensitihsyutkykhyj</td><td>（中継用）初期死亡時円換算最低保証特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyudkaigomehrtkarihyj</td><td>（中継用）重度介護前払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysykihrkpsiteituuka</td><td>（中継用）初回払込Ｐ（指定通貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyteirituhaibunwari</td><td>（中継用）定率部分配分割合</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysueokikknkbn</td><td>（中継用）据置期間区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynksyuruikbn1</td><td>（中継用）年金種類区分（１文字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenkbtinfo1</td><td>（中継用）代理店個別情報１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenkbtinfo2</td><td>（中継用）代理店個別情報２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydairitenkbtinfo3</td><td>（中継用）代理店個別情報３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyohurimiryou</td><td>（中継用）預振未了</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykznyuuryokuymd</td><td>（中継用）口座入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysetaitemosno</td><td>（中継用）セット相手申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyakkanjyuryouhoukbn</td><td>（中継用）約款受領方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyakkanbunsyono</td><td>（中継用）約款文書番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuritourokuhoukbn</td><td>（中継用）口座振替登録方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai1hknkkn</td><td>（中継用）第１保険期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycreditnyuuryokuymd</td><td>（中継用）クレジット入力年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycreditmiryou</td><td>（中継用）クレカ未了</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycredittrkhoukbn</td><td>（中継用）クレジット登録方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycardbrandkbn</td><td>（中継用）カードブランド</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztycarddatasousinymd</td><td>（中継用）カードデータ送信日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykdrtkykarihyj</td><td>（中継用）契約者代理特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzktrkservicekbn</td><td>（中継用）ご家族登録サービス区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikisiharaiarihyj</td><td>（中継用）定期支払特約有表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikishrkinshrtuukakbn</td><td>（中継用）定期支払金支払通貨区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyteikisiharaikin</td><td>（中継用）定期支払金</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztykoureikzksetumeihoukbn</td><td>（中継用）高齢者ご家族等説明方法区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykoureimndnhukusuukaikbn</td><td>（中継用）高齢者面談複数回実施区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykoureitratkisyaigidskkbn</td><td>（中継用）高齢者取扱者以外同席区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknsyukigou</td><td>（中継用）保険種類記号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaimnkkykhyj</td><td>（中継用）才満期契約表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynnknsnpssysyup</td><td>（中継用）年換算Ｐ算出用主契約Ｐ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynnknsnpssykwsrate</td><td>（中継用）年換算Ｐ算出用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>ztyzennoup</td><td>（中継用）前納保険料</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztynenkinzeiseitokuyakukbn</td><td>（中継用）年金税制特約区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv33</td><td>（中継用）予備項目Ｖ３３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenIpToukeiTy
 * @see     GenZT_DrtenIpToukeiTy
 * @see     QZT_DrtenIpToukeiTy
 * @see     GenQZT_DrtenIpToukeiTy
 */
public class PKZT_DrtenIpToukeiTy extends AbstractExDBPrimaryKey<ZT_DrtenIpToukeiTy, PKZT_DrtenIpToukeiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_DrtenIpToukeiTy() {
    }

    public PKZT_DrtenIpToukeiTy(
        String pZtyeigyouhonbusisyacd,
        String pZtysosikicd,
        String pZtyatukaikojincd,
        String pZtymosym,
        String pZtymosno
    ) {
        ztyeigyouhonbusisyacd = pZtyeigyouhonbusisyacd;
        ztysosikicd = pZtysosikicd;
        ztyatukaikojincd = pZtyatukaikojincd;
        ztymosym = pZtymosym;
        ztymosno = pZtymosno;
    }

    @Transient
    @Override
    public Class<ZT_DrtenIpToukeiTy> getEntityClass() {
        return ZT_DrtenIpToukeiTy.class;
    }

    private String ztyeigyouhonbusisyacd;

    public String getZtyeigyouhonbusisyacd() {
        return ztyeigyouhonbusisyacd;
    }

    public void setZtyeigyouhonbusisyacd(String pZtyeigyouhonbusisyacd) {
        ztyeigyouhonbusisyacd = pZtyeigyouhonbusisyacd;
    }
    private String ztysosikicd;

    public String getZtysosikicd() {
        return ztysosikicd;
    }

    public void setZtysosikicd(String pZtysosikicd) {
        ztysosikicd = pZtysosikicd;
    }
    private String ztyatukaikojincd;

    public String getZtyatukaikojincd() {
        return ztyatukaikojincd;
    }

    public void setZtyatukaikojincd(String pZtyatukaikojincd) {
        ztyatukaikojincd = pZtyatukaikojincd;
    }
    private String ztymosym;

    public String getZtymosym() {
        return ztymosym;
    }

    public void setZtymosym(String pZtymosym) {
        ztymosym = pZtymosym;
    }
    private String ztymosno;

    public String getZtymosno() {
        return ztymosno;
    }

    public void setZtymosno(String pZtymosno) {
        ztymosno = pZtymosno;
    }

}