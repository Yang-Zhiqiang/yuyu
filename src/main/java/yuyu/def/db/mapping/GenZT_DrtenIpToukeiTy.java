package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_DrtenIpToukeiTy;
import yuyu.def.db.id.PKZT_DrtenIpToukeiTy;
import yuyu.def.db.meta.GenQZT_DrtenIpToukeiTy;
import yuyu.def.db.meta.QZT_DrtenIpToukeiTy;

/**
 * 代理店用ＩＰ統計用Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_DrtenIpToukeiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenIpToukeiTy}</td><td colspan="3">代理店用ＩＰ統計用Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyeigyouhonbusisyacd ztyeigyouhonbusisyacd}</td><td>（中継用）営業本部支社コード</td><td align="center">{@link PKZT_DrtenIpToukeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysosikicd ztysosikicd}</td><td>（中継用）組織コード</td><td align="center">{@link PKZT_DrtenIpToukeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatukaikojincd ztyatukaikojincd}</td><td>（中継用）扱者個人コード</td><td align="center">{@link PKZT_DrtenIpToukeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosym ztymosym}</td><td>（中継用）申込月度</td><td align="center">{@link PKZT_DrtenIpToukeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymoskbn ztymoskbn}</td><td>（中継用）申込区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytansyukukjatukaisyanm ztytansyukukjatukaisyanm}</td><td>（中継用）短縮漢字扱者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">{@link PKZT_DrtenIpToukeiTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyoumetukbn ztymossyoumetukbn}</td><td>（中継用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykurikosiriyuukbn ztykurikosiriyuukbn}</td><td>（中継用）繰越理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknzumihyouji ztynyknzumihyouji}</td><td>（中継用）入金済表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeihknsyruikbn ztytoukeihknsyruikbn}</td><td>（中継用）統計用保険種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjykktkbn ztyhjykktkbn}</td><td>（中継用）報状告知区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykktaikbn ztykykktaikbn}</td><td>（中継用）契約形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyunhsys ztyjyunhsys}</td><td>（中継用）純保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhsys ztyhsys}</td><td>（中継用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysoukensuu ztysoukensuu}</td><td>（中継用）総件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyketjkkbn ztyketjkkbn}</td><td>（中継用）決定状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhiktjyoutaikbn ztydakuhiktjyoutaikbn}</td><td>（中継用）諾否決定状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonhubi ztykihonhubi}</td><td>（中継用）基本不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysphubi ztysphubi}</td><td>（中継用）ＳＰ不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysseigenhubi ztysseigenhubi}</td><td>（中継用）Ｓ制限不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynayosehumei ztynayosehumei}</td><td>（中継用）名寄不明</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuusangendoover ztytuusangendoover}</td><td>（中継用）通算限度オーバー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosketteihoryuu ztymosketteihoryuu}</td><td>（中継用）申込決定保留</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykkakjissityuu ztykykkakjissityuu}</td><td>（中継用）契約確認実施中</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykktketteihoryuu ztykktketteihoryuu}</td><td>（中継用）告知決定保留</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhonsyakethoryuu ztyhonsyakethoryuu}</td><td>（中継用）本社決定保留</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseiymdhubi ztyseiymdhubi}</td><td>（中継用）生年月日不備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphusoku ztyphusoku}</td><td>（中継用）Ｐ不足</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrhuketyu ztysrhuketyu}</td><td>（中継用）成立保留受付中</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypkakin ztypkakin}</td><td>（中継用）Ｐ過金</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakuseiymd ztysakuseiymd}</td><td>（中継用）作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkikbn ztykydatkikbn}</td><td>（中継用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytansyukukjhhknnm ztytansyukukjhhknnm}</td><td>（中継用）短縮漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsykgycd ztyhhknsykgycd}</td><td>（中継用）被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2keta ztyhhknnen2keta}</td><td>（中継用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusymd ztymusymd}</td><td>（中継用）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipryosyuymd ztysyokaipryosyuymd}</td><td>（中継用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykokutiymd ztykokutiymd}</td><td>（中継用）告知年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosnyuuryokuymd ztymosnyuuryokuymd}</td><td>（中継用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysekininkaisiymd ztysekininkaisiymd}</td><td>（中継用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstpnyknsyoriymd ztyfstpnyknsyoriymd}</td><td>（中継用）初回Ｐ入金処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstpnyknnaiyoukbn ztyfstpnyknnaiyoukbn}</td><td>（中継用）初回Ｐ入金内容区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisyaketsyoriymd ztysisyaketsyoriymd}</td><td>（中継用）支社決定処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosakuseiymd ztysyosakuseiymd}</td><td>（中継用）証券作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisekiym ztyseisekiym}</td><td>（中継用）成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaiharaikomip ztysyokaiharaikomip}</td><td>（中継用）初回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokusyujimutoriatukaikbn ztytokusyujimutoriatukaikbn}</td><td>（中継用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtenkjnm ztybsydrtenkjnm}</td><td>（中継用）募集代理店漢字名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatkisyagyskkjsosikicd ztyatkisyagyskkjsosikicd}</td><td>（中継用）扱者業績計上先組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatkisyadrtenatkiwari ztyatkisyadrtenatkiwari}</td><td>（中継用）扱者代理店扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykinyuukikancd ztykinyuukikancd}</td><td>（中継用）金融機関コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyinfositencd ztyinfositencd}</td><td>（中継用）（情報系）支店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkyknm10 ztykjkyknm10}</td><td>（中継用）漢字契約者名（１０文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykthhbhyouji ztykthhbhyouji}</td><td>（中継用）決定保留不備表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrhhbhyouji ztysrhhbhyouji}</td><td>（中継用）成立保留不備表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyumtkktymd ztymossyumtkktymd}</td><td>（中継用）申込消滅確定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenjimusyocd ztydairitenjimusyocd}</td><td>（中継用）代理店事務所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsrybnwari ztytsrybnwari}</td><td>（中継用）手数料分割割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydrtenkeijyouym ztydrtenkeijyouym}</td><td>（中継用）代理店計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkidairitencd ztykydatkidairitencd}</td><td>（中継用）共同扱代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaihyoubosyuunincd ztydaihyoubosyuunincd}</td><td>（中継用）代表募集人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytansyukukjdhybosyuunm ztytansyukukjdhybosyuunm}</td><td>（中継用）短縮漢字代表募集人名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkyknm15 ztyknkyknm15}</td><td>（中継用）カナ契約者名（１５文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettikekkacd ztydakuhikettikekkacd}</td><td>（中継用）諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydkhktiymd ztydkhktiymd}</td><td>（中継用）諾否決定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeiyousinsakbn ztytoukeiyousinsakbn}</td><td>（中継用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhonninkknnkbn ztyhonninkknnkbn}</td><td>（中継用）本人確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynstkarihyj ztynstkarihyj}</td><td>（中継用）年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynstknkkkn ztynstknkkkn}</td><td>（中継用）年金支払特約年金期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrtentsryhushrkykhyouji ztydrtentsryhushrkykhyouji}</td><td>（中継用）代理店手数料不支払契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyknkanskanouhyouji ztynyknkanskanouhyouji}</td><td>（中継用）入金勧奨可能表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydshukahyouji ztydshukahyouji}</td><td>（中継用）ＤＳ付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdairiseikyuutkykarihyj ztystdairiseikyuutkykarihyj}</td><td>（中継用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseikbn ztykyksyaseikbn}</td><td>（中継用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrtenpaperlessmoshyj ztydrtenpaperlessmoshyj}</td><td>（中継用）代理店ペーパーレス申込表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydrtenmostousyaukeymd ztydrtenmostousyaukeymd}</td><td>（中継用）代理店申込書当社受付年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktuuka ztykyktuuka}</td><td>（中継用）契約通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrktuuka ztyhrktuuka}</td><td>（中継用）払込通貨</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykihrkpgaika ztysykihrkpgaika}</td><td>（中継用）初回払込Ｐ（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyennykntkarihyouji ztyyennykntkarihyouji}</td><td>（中継用）円入金特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikanykntkarihyouji ztygaikanykntkarihyouji}</td><td>（中継用）外貨入金特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonsgaika ztykihonsgaika}</td><td>（中継用）基本Ｓ（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytekiyoukawaserate ztytekiyoukawaserate}</td><td>（中継用）適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd ztykawaseratetekiyouymd}</td><td>（中継用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymkhyoutiyensysnikoukbn ztymkhyoutiyensysnikoukbn}</td><td>（中継用）目標到達時円建終身保障移行区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyksbyensitihsyutkykhyj ztysyksbyensitihsyutkykhyj}</td><td>（中継用）初期死亡時円換算最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyudkaigomehrtkarihyj ztyjyudkaigomehrtkarihyj}</td><td>（中継用）重度介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykihrkpsiteituuka ztysykihrkpsiteituuka}</td><td>（中継用）初回払込Ｐ（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyteirituhaibunwari ztyteirituhaibunwari}</td><td>（中継用）定率部分配分割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysueokikknkbn ztysueokikknkbn}</td><td>（中継用）据置期間区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikbn1 ztynksyuruikbn1}</td><td>（中継用）年金種類区分（１文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenkbtinfo1 ztydairitenkbtinfo1}</td><td>（中継用）代理店個別情報１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenkbtinfo2 ztydairitenkbtinfo2}</td><td>（中継用）代理店個別情報２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenkbtinfo3 ztydairitenkbtinfo3}</td><td>（中継用）代理店個別情報３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyohurimiryou ztyyohurimiryou}</td><td>（中継用）預振未了</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykznyuuryokuymd ztykznyuuryokuymd}</td><td>（中継用）口座入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitemosno ztysetaitemosno}</td><td>（中継用）セット相手申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyakkanjyuryouhoukbn ztyyakkanjyuryouhoukbn}</td><td>（中継用）約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyakkanbunsyono ztyyakkanbunsyono}</td><td>（中継用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzhuritourokuhoukbn ztykzhuritourokuhoukbn}</td><td>（中継用）口座振替登録方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1hknkkn ztydai1hknkkn}</td><td>（中継用）第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditnyuuryokuymd ztycreditnyuuryokuymd}</td><td>（中継用）クレジット入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycreditmiryou ztycreditmiryou}</td><td>（中継用）クレカ未了</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycredittrkhoukbn ztycredittrkhoukbn}</td><td>（中継用）クレジット登録方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycardbrandkbn ztycardbrandkbn}</td><td>（中継用）カードブランド</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycarddatasousinymd ztycarddatasousinymd}</td><td>（中継用）カードデータ送信日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtkykarihyj ztykykdrtkykarihyj}</td><td>（中継用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktrkservicekbn ztykzktrkservicekbn}</td><td>（中継用）ご家族登録サービス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikisiharaiarihyj ztyteikisiharaiarihyj}</td><td>（中継用）定期支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikishrkinshrtuukakbn ztyteikishrkinshrtuukakbn}</td><td>（中継用）定期支払金支払通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikisiharaikin ztyteikisiharaikin}</td><td>（中継用）定期支払金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykoureikzksetumeihoukbn ztykoureikzksetumeihoukbn}</td><td>（中継用）高齢者ご家族等説明方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykoureimndnhukusuukaikbn ztykoureimndnhukusuukaikbn}</td><td>（中継用）高齢者面談複数回実施区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykoureitratkisyaigidskkbn ztykoureitratkisyaigidskkbn}</td><td>（中継用）高齢者取扱者以外同席区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssysyup ztynnknsnpssysyup}</td><td>（中継用）年換算Ｐ算出用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssykwsrate ztynnknsnpssykwsrate}</td><td>（中継用）年換算Ｐ算出用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyzennoup ztyzennoup}</td><td>（中継用）前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynenkinzeiseitokuyakukbn ztynenkinzeiseitokuyakukbn}</td><td>（中継用）年金税制特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv33 ztyyobiv33}</td><td>（中継用）予備項目Ｖ３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenIpToukeiTy
 * @see     PKZT_DrtenIpToukeiTy
 * @see     QZT_DrtenIpToukeiTy
 * @see     GenQZT_DrtenIpToukeiTy
 */
@MappedSuperclass
@Table(name=GenZT_DrtenIpToukeiTy.TABLE_NAME)
@IdClass(value=PKZT_DrtenIpToukeiTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_DrtenIpToukeiTy extends AbstractExDBEntity<ZT_DrtenIpToukeiTy, PKZT_DrtenIpToukeiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenIpToukeiTy";
    public static final String ZTYEIGYOUHONBUSISYACD    = "ztyeigyouhonbusisyacd";
    public static final String ZTYSOSIKICD              = "ztysosikicd";
    public static final String ZTYATUKAIKOJINCD         = "ztyatukaikojincd";
    public static final String ZTYMOSYM                 = "ztymosym";
    public static final String ZTYMOSKBN                = "ztymoskbn";
    public static final String ZTYTANSYUKUKJATUKAISYANM = "ztytansyukukjatukaisyanm";
    public static final String ZTYMOSNO                 = "ztymosno";
    public static final String ZTYMOSSYOUMETUKBN        = "ztymossyoumetukbn";
    public static final String ZTYKURIKOSIRIYUUKBN      = "ztykurikosiriyuukbn";
    public static final String ZTYNYKNZUMIHYOUJI        = "ztynyknzumihyouji";
    public static final String ZTYTOUKEIHKNSYRUIKBN     = "ztytoukeihknsyruikbn";
    public static final String ZTYHJYKKTKBN             = "ztyhjykktkbn";
    public static final String ZTYKYKKTAIKBN            = "ztykykktaikbn";
    public static final String ZTYJYUNHSYS              = "ztyjyunhsys";
    public static final String ZTYHSYS                  = "ztyhsys";
    public static final String ZTYSOUKENSUU             = "ztysoukensuu";
    public static final String ZTYKETJKKBN              = "ztyketjkkbn";
    public static final String ZTYDAKUHIKTJYOUTAIKBN    = "ztydakuhiktjyoutaikbn";
    public static final String ZTYKIHONHUBI             = "ztykihonhubi";
    public static final String ZTYSPHUBI                = "ztysphubi";
    public static final String ZTYSSEIGENHUBI           = "ztysseigenhubi";
    public static final String ZTYNAYOSEHUMEI           = "ztynayosehumei";
    public static final String ZTYTUUSANGENDOOVER       = "ztytuusangendoover";
    public static final String ZTYMOSKETTEIHORYUU       = "ztymosketteihoryuu";
    public static final String ZTYKYKKAKJISSITYUU       = "ztykykkakjissityuu";
    public static final String ZTYKKTKETTEIHORYUU       = "ztykktketteihoryuu";
    public static final String ZTYHONSYAKETHORYUU       = "ztyhonsyakethoryuu";
    public static final String ZTYSEIYMDHUBI            = "ztyseiymdhubi";
    public static final String ZTYPHUSOKU               = "ztyphusoku";
    public static final String ZTYSRHUKETYU             = "ztysrhuketyu";
    public static final String ZTYPKAKIN                = "ztypkakin";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYSAKUSEIYMD            = "ztysakuseiymd";
    public static final String ZTYKYDATKIKBN            = "ztykydatkikbn";
    public static final String ZTYTANSYUKUKJHHKNNM      = "ztytansyukukjhhknnm";
    public static final String ZTYHHKNSYKGYCD           = "ztyhhknsykgycd";
    public static final String ZTYHHKNNEN2KETA          = "ztyhhknnen2keta";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYMUSYMD                = "ztymusymd";
    public static final String ZTYSYOKAIPRYOSYUYMD      = "ztysyokaipryosyuymd";
    public static final String ZTYKOKUTIYMD             = "ztykokutiymd";
    public static final String ZTYMOSNYUURYOKUYMD       = "ztymosnyuuryokuymd";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYSEKININKAISIYMD       = "ztysekininkaisiymd";
    public static final String ZTYFSTPNYKNSYORIYMD      = "ztyfstpnyknsyoriymd";
    public static final String ZTYFSTPNYKNNAIYOUKBN     = "ztyfstpnyknnaiyoukbn";
    public static final String ZTYSISYAKETSYORIYMD      = "ztysisyaketsyoriymd";
    public static final String ZTYSYOSAKUSEIYMD         = "ztysyosakuseiymd";
    public static final String ZTYSEISEKIYM             = "ztyseisekiym";
    public static final String ZTYSYOKAIHARAIKOMIP      = "ztysyokaiharaikomip";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYTOKUSYUJIMUTORIATUKAIKBN = "ztytokusyujimutoriatukaikbn";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYBSYDRTENKJNM          = "ztybsydrtenkjnm";
    public static final String ZTYATKISYAGYSKKJSOSIKICD = "ztyatkisyagyskkjsosikicd";
    public static final String ZTYATKISYADRTENATKIWARI  = "ztyatkisyadrtenatkiwari";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYKINYUUKIKANCD         = "ztykinyuukikancd";
    public static final String ZTYINFOSITENCD           = "ztyinfositencd";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYKJKYKNM10             = "ztykjkyknm10";
    public static final String ZTYKTHHBHYOUJI           = "ztykthhbhyouji";
    public static final String ZTYSRHHBHYOUJI           = "ztysrhhbhyouji";
    public static final String ZTYMOSSYUMTKKTYMD        = "ztymossyumtkktymd";
    public static final String ZTYDAIRITENJIMUSYOCD     = "ztydairitenjimusyocd";
    public static final String ZTYTSRYBNWARI            = "ztytsrybnwari";
    public static final String ZTYDRTENKEIJYOUYM        = "ztydrtenkeijyouym";
    public static final String ZTYKYDATKIDAIRITENCD     = "ztykydatkidairitencd";
    public static final String ZTYDAIHYOUBOSYUUNINCD    = "ztydaihyoubosyuunincd";
    public static final String ZTYTANSYUKUKJDHYBOSYUUNM = "ztytansyukukjdhybosyuunm";
    public static final String ZTYKNKYKNM15             = "ztyknkyknm15";
    public static final String ZTYDAKUHIKETTIKEKKACD    = "ztydakuhikettikekkacd";
    public static final String ZTYDKHKTIYMD             = "ztydkhktiymd";
    public static final String ZTYTOUKEIYOUSINSAKBN     = "ztytoukeiyousinsakbn";
    public static final String ZTYHONNINKKNNKBN         = "ztyhonninkknnkbn";
    public static final String ZTYNSTKARIHYJ            = "ztynstkarihyj";
    public static final String ZTYNSTKNKKKN             = "ztynstknkkkn";
    public static final String ZTYDRTENTSRYHUSHRKYKHYOUJI = "ztydrtentsryhushrkykhyouji";
    public static final String ZTYNYKNKANSKANOUHYOUJI   = "ztynyknkanskanouhyouji";
    public static final String ZTYDSHUKAHYOUJI          = "ztydshukahyouji";
    public static final String ZTYSTDAIRISEIKYUUTKYKARIHYJ = "ztystdairiseikyuutkykarihyj";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYKYKSYASEIKBN          = "ztykyksyaseikbn";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYDRTENPAPERLESSMOSHYJ  = "ztydrtenpaperlessmoshyj";
    public static final String ZTYDRTENMOSTOUSYAUKEYMD  = "ztydrtenmostousyaukeymd";
    public static final String ZTYKYKTUUKA              = "ztykyktuuka";
    public static final String ZTYHRKTUUKA              = "ztyhrktuuka";
    public static final String ZTYSYKIHRKPGAIKA         = "ztysykihrkpgaika";
    public static final String ZTYYENNYKNTKARIHYOUJI    = "ztyyennykntkarihyouji";
    public static final String ZTYGAIKANYKNTKARIHYOUJI  = "ztygaikanykntkarihyouji";
    public static final String ZTYKIHONSGAIKA           = "ztykihonsgaika";
    public static final String ZTYTEKIYOUKAWASERATE     = "ztytekiyoukawaserate";
    public static final String ZTYKAWASERATETEKIYOUYMD  = "ztykawaseratetekiyouymd";
    public static final String ZTYMKHYOUTIYENSYSNIKOUKBN = "ztymkhyoutiyensysnikoukbn";
    public static final String ZTYSYKSBYENSITIHSYUTKYKHYJ = "ztysyksbyensitihsyutkykhyj";
    public static final String ZTYJYUDKAIGOMEHRTKARIHYJ = "ztyjyudkaigomehrtkarihyj";
    public static final String ZTYSYKIHRKPSITEITUUKA    = "ztysykihrkpsiteituuka";
    public static final String ZTYTEIRITUHAIBUNWARI     = "ztyteirituhaibunwari";
    public static final String ZTYSUEOKIKKNKBN          = "ztysueokikknkbn";
    public static final String ZTYNKSYURUIKBN1          = "ztynksyuruikbn1";
    public static final String ZTYDAIRITENKBTINFO1      = "ztydairitenkbtinfo1";
    public static final String ZTYDAIRITENKBTINFO2      = "ztydairitenkbtinfo2";
    public static final String ZTYDAIRITENKBTINFO3      = "ztydairitenkbtinfo3";
    public static final String ZTYYOHURIMIRYOU          = "ztyyohurimiryou";
    public static final String ZTYKZNYUURYOKUYMD        = "ztykznyuuryokuymd";
    public static final String ZTYSETAITEMOSNO          = "ztysetaitemosno";
    public static final String ZTYYAKKANJYURYOUHOUKBN   = "ztyyakkanjyuryouhoukbn";
    public static final String ZTYYAKKANBUNSYONO        = "ztyyakkanbunsyono";
    public static final String ZTYKZHURITOUROKUHOUKBN   = "ztykzhuritourokuhoukbn";
    public static final String ZTYDAI1HKNKKN            = "ztydai1hknkkn";
    public static final String ZTYCREDITNYUURYOKUYMD    = "ztycreditnyuuryokuymd";
    public static final String ZTYCREDITMIRYOU          = "ztycreditmiryou";
    public static final String ZTYCREDITTRKHOUKBN       = "ztycredittrkhoukbn";
    public static final String ZTYCARDBRANDKBN          = "ztycardbrandkbn";
    public static final String ZTYCARDDATASOUSINYMD     = "ztycarddatasousinymd";
    public static final String ZTYKYKDRTKYKARIHYJ       = "ztykykdrtkykarihyj";
    public static final String ZTYKZKTRKSERVICEKBN      = "ztykzktrkservicekbn";
    public static final String ZTYTEIKISIHARAIARIHYJ    = "ztyteikisiharaiarihyj";
    public static final String ZTYTEIKISHRKINSHRTUUKAKBN = "ztyteikishrkinshrtuukakbn";
    public static final String ZTYTEIKISIHARAIKIN       = "ztyteikisiharaikin";
    public static final String ZTYKOUREIKZKSETUMEIHOUKBN = "ztykoureikzksetumeihoukbn";
    public static final String ZTYKOUREIMNDNHUKUSUUKAIKBN = "ztykoureimndnhukusuukaikbn";
    public static final String ZTYKOUREITRATKISYAIGIDSKKBN = "ztykoureitratkisyaigidskkbn";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYNNKNSNPSSYSYUP        = "ztynnknsnpssysyup";
    public static final String ZTYNNKNSNPSSYKWSRATE     = "ztynnknsnpssykwsrate";
    public static final String ZTYZENNOUP               = "ztyzennoup";
    public static final String ZTYNENKINZEISEITOKUYAKUKBN = "ztynenkinzeiseitokuyakukbn";
    public static final String ZTYYOBIV33               = "ztyyobiv33";

    private final PKZT_DrtenIpToukeiTy primaryKey;

    public GenZT_DrtenIpToukeiTy() {
        primaryKey = new PKZT_DrtenIpToukeiTy();
    }

    public GenZT_DrtenIpToukeiTy(
        String pZtyeigyouhonbusisyacd,
        String pZtysosikicd,
        String pZtyatukaikojincd,
        String pZtymosym,
        String pZtymosno
    ) {
        primaryKey = new PKZT_DrtenIpToukeiTy(
            pZtyeigyouhonbusisyacd,
            pZtysosikicd,
            pZtyatukaikojincd,
            pZtymosym,
            pZtymosno
        );
    }

    @Transient
    @Override
    public PKZT_DrtenIpToukeiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenIpToukeiTy> getMetaClass() {
        return QZT_DrtenIpToukeiTy.class;
    }

    @Id
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYEIGYOUHONBUSISYACD)
    public String getZtyeigyouhonbusisyacd() {
        return getPrimaryKey().getZtyeigyouhonbusisyacd();
    }

    public void setZtyeigyouhonbusisyacd(String pZtyeigyouhonbusisyacd) {
        getPrimaryKey().setZtyeigyouhonbusisyacd(pZtyeigyouhonbusisyacd);
    }

    @Id
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSOSIKICD)
    public String getZtysosikicd() {
        return getPrimaryKey().getZtysosikicd();
    }

    public void setZtysosikicd(String pZtysosikicd) {
        getPrimaryKey().setZtysosikicd(pZtysosikicd);
    }

    @Id
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYATUKAIKOJINCD)
    public String getZtyatukaikojincd() {
        return getPrimaryKey().getZtyatukaikojincd();
    }

    public void setZtyatukaikojincd(String pZtyatukaikojincd) {
        getPrimaryKey().setZtyatukaikojincd(pZtyatukaikojincd);
    }

    @Id
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYMOSYM)
    public String getZtymosym() {
        return getPrimaryKey().getZtymosym();
    }

    public void setZtymosym(String pZtymosym) {
        getPrimaryKey().setZtymosym(pZtymosym);
    }

    private String ztymoskbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYMOSKBN)
    public String getZtymoskbn() {
        return ztymoskbn;
    }

    public void setZtymoskbn(String pZtymoskbn) {
        ztymoskbn = pZtymoskbn;
    }

    private String ztytansyukukjatukaisyanm;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTANSYUKUKJATUKAISYANM)
    public String getZtytansyukukjatukaisyanm() {
        return ztytansyukukjatukaisyanm;
    }

    public void setZtytansyukukjatukaisyanm(String pZtytansyukukjatukaisyanm) {
        ztytansyukukjatukaisyanm = pZtytansyukukjatukaisyanm;
    }

    @Id
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYMOSNO)
    public String getZtymosno() {
        return getPrimaryKey().getZtymosno();
    }

    public void setZtymosno(String pZtymosno) {
        getPrimaryKey().setZtymosno(pZtymosno);
    }

    private String ztymossyoumetukbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYMOSSYOUMETUKBN)
    public String getZtymossyoumetukbn() {
        return ztymossyoumetukbn;
    }

    public void setZtymossyoumetukbn(String pZtymossyoumetukbn) {
        ztymossyoumetukbn = pZtymossyoumetukbn;
    }

    private String ztykurikosiriyuukbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKURIKOSIRIYUUKBN)
    public String getZtykurikosiriyuukbn() {
        return ztykurikosiriyuukbn;
    }

    public void setZtykurikosiriyuukbn(String pZtykurikosiriyuukbn) {
        ztykurikosiriyuukbn = pZtykurikosiriyuukbn;
    }

    private String ztynyknzumihyouji;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYNYKNZUMIHYOUJI)
    public String getZtynyknzumihyouji() {
        return ztynyknzumihyouji;
    }

    public void setZtynyknzumihyouji(String pZtynyknzumihyouji) {
        ztynyknzumihyouji = pZtynyknzumihyouji;
    }

    private String ztytoukeihknsyruikbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTOUKEIHKNSYRUIKBN)
    public String getZtytoukeihknsyruikbn() {
        return ztytoukeihknsyruikbn;
    }

    public void setZtytoukeihknsyruikbn(String pZtytoukeihknsyruikbn) {
        ztytoukeihknsyruikbn = pZtytoukeihknsyruikbn;
    }

    private String ztyhjykktkbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHJYKKTKBN)
    public String getZtyhjykktkbn() {
        return ztyhjykktkbn;
    }

    public void setZtyhjykktkbn(String pZtyhjykktkbn) {
        ztyhjykktkbn = pZtyhjykktkbn;
    }

    private String ztykykktaikbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKYKKTAIKBN)
    public String getZtykykktaikbn() {
        return ztykykktaikbn;
    }

    public void setZtykykktaikbn(String pZtykykktaikbn) {
        ztykykktaikbn = pZtykykktaikbn;
    }

    private Long ztyjyunhsys;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYJYUNHSYS)
    public Long getZtyjyunhsys() {
        return ztyjyunhsys;
    }

    public void setZtyjyunhsys(Long pZtyjyunhsys) {
        ztyjyunhsys = pZtyjyunhsys;
    }

    private Long ztyhsys;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHSYS)
    public Long getZtyhsys() {
        return ztyhsys;
    }

    public void setZtyhsys(Long pZtyhsys) {
        ztyhsys = pZtyhsys;
    }

    private Integer ztysoukensuu;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSOUKENSUU)
    public Integer getZtysoukensuu() {
        return ztysoukensuu;
    }

    public void setZtysoukensuu(Integer pZtysoukensuu) {
        ztysoukensuu = pZtysoukensuu;
    }

    private String ztyketjkkbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKETJKKBN)
    public String getZtyketjkkbn() {
        return ztyketjkkbn;
    }

    public void setZtyketjkkbn(String pZtyketjkkbn) {
        ztyketjkkbn = pZtyketjkkbn;
    }

    private String ztydakuhiktjyoutaikbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDAKUHIKTJYOUTAIKBN)
    public String getZtydakuhiktjyoutaikbn() {
        return ztydakuhiktjyoutaikbn;
    }

    public void setZtydakuhiktjyoutaikbn(String pZtydakuhiktjyoutaikbn) {
        ztydakuhiktjyoutaikbn = pZtydakuhiktjyoutaikbn;
    }

    private String ztykihonhubi;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKIHONHUBI)
    public String getZtykihonhubi() {
        return ztykihonhubi;
    }

    public void setZtykihonhubi(String pZtykihonhubi) {
        ztykihonhubi = pZtykihonhubi;
    }

    private String ztysphubi;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSPHUBI)
    public String getZtysphubi() {
        return ztysphubi;
    }

    public void setZtysphubi(String pZtysphubi) {
        ztysphubi = pZtysphubi;
    }

    private String ztysseigenhubi;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSSEIGENHUBI)
    public String getZtysseigenhubi() {
        return ztysseigenhubi;
    }

    public void setZtysseigenhubi(String pZtysseigenhubi) {
        ztysseigenhubi = pZtysseigenhubi;
    }

    private String ztynayosehumei;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYNAYOSEHUMEI)
    public String getZtynayosehumei() {
        return ztynayosehumei;
    }

    public void setZtynayosehumei(String pZtynayosehumei) {
        ztynayosehumei = pZtynayosehumei;
    }

    private String ztytuusangendoover;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTUUSANGENDOOVER)
    public String getZtytuusangendoover() {
        return ztytuusangendoover;
    }

    public void setZtytuusangendoover(String pZtytuusangendoover) {
        ztytuusangendoover = pZtytuusangendoover;
    }

    private String ztymosketteihoryuu;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYMOSKETTEIHORYUU)
    public String getZtymosketteihoryuu() {
        return ztymosketteihoryuu;
    }

    public void setZtymosketteihoryuu(String pZtymosketteihoryuu) {
        ztymosketteihoryuu = pZtymosketteihoryuu;
    }

    private String ztykykkakjissityuu;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKYKKAKJISSITYUU)
    public String getZtykykkakjissityuu() {
        return ztykykkakjissityuu;
    }

    public void setZtykykkakjissityuu(String pZtykykkakjissityuu) {
        ztykykkakjissityuu = pZtykykkakjissityuu;
    }

    private String ztykktketteihoryuu;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKKTKETTEIHORYUU)
    public String getZtykktketteihoryuu() {
        return ztykktketteihoryuu;
    }

    public void setZtykktketteihoryuu(String pZtykktketteihoryuu) {
        ztykktketteihoryuu = pZtykktketteihoryuu;
    }

    private String ztyhonsyakethoryuu;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHONSYAKETHORYUU)
    public String getZtyhonsyakethoryuu() {
        return ztyhonsyakethoryuu;
    }

    public void setZtyhonsyakethoryuu(String pZtyhonsyakethoryuu) {
        ztyhonsyakethoryuu = pZtyhonsyakethoryuu;
    }

    private String ztyseiymdhubi;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSEIYMDHUBI)
    public String getZtyseiymdhubi() {
        return ztyseiymdhubi;
    }

    public void setZtyseiymdhubi(String pZtyseiymdhubi) {
        ztyseiymdhubi = pZtyseiymdhubi;
    }

    private String ztyphusoku;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYPHUSOKU)
    public String getZtyphusoku() {
        return ztyphusoku;
    }

    public void setZtyphusoku(String pZtyphusoku) {
        ztyphusoku = pZtyphusoku;
    }

    private String ztysrhuketyu;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSRHUKETYU)
    public String getZtysrhuketyu() {
        return ztysrhuketyu;
    }

    public void setZtysrhuketyu(String pZtysrhuketyu) {
        ztysrhuketyu = pZtysrhuketyu;
    }

    private String ztypkakin;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYPKAKIN)
    public String getZtypkakin() {
        return ztypkakin;
    }

    public void setZtypkakin(String pZtypkakin) {
        ztypkakin = pZtypkakin;
    }

    private String ztybsudirtnatkikeitaikbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }

    private String ztysakuseiymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSAKUSEIYMD)
    public String getZtysakuseiymd() {
        return ztysakuseiymd;
    }

    public void setZtysakuseiymd(String pZtysakuseiymd) {
        ztysakuseiymd = pZtysakuseiymd;
    }

    private String ztykydatkikbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKYDATKIKBN)
    public String getZtykydatkikbn() {
        return ztykydatkikbn;
    }

    public void setZtykydatkikbn(String pZtykydatkikbn) {
        ztykydatkikbn = pZtykydatkikbn;
    }

    private String ztytansyukukjhhknnm;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTANSYUKUKJHHKNNM)
    public String getZtytansyukukjhhknnm() {
        return ztytansyukukjhhknnm;
    }

    public void setZtytansyukukjhhknnm(String pZtytansyukukjhhknnm) {
        ztytansyukukjhhknnm = pZtytansyukukjhhknnm;
    }

    private String ztyhhknsykgycd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHHKNSYKGYCD)
    public String getZtyhhknsykgycd() {
        return ztyhhknsykgycd;
    }

    public void setZtyhhknsykgycd(String pZtyhhknsykgycd) {
        ztyhhknsykgycd = pZtyhhknsykgycd;
    }

    private String ztyhhknnen2keta;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHHKNNEN2KETA)
    public String getZtyhhknnen2keta() {
        return ztyhhknnen2keta;
    }

    public void setZtyhhknnen2keta(String pZtyhhknnen2keta) {
        ztyhhknnen2keta = pZtyhhknnen2keta;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztymusymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYMUSYMD)
    public String getZtymusymd() {
        return ztymusymd;
    }

    public void setZtymusymd(String pZtymusymd) {
        ztymusymd = pZtymusymd;
    }

    private String ztysyokaipryosyuymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSYOKAIPRYOSYUYMD)
    public String getZtysyokaipryosyuymd() {
        return ztysyokaipryosyuymd;
    }

    public void setZtysyokaipryosyuymd(String pZtysyokaipryosyuymd) {
        ztysyokaipryosyuymd = pZtysyokaipryosyuymd;
    }

    private String ztykokutiymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKOKUTIYMD)
    public String getZtykokutiymd() {
        return ztykokutiymd;
    }

    public void setZtykokutiymd(String pZtykokutiymd) {
        ztykokutiymd = pZtykokutiymd;
    }

    private String ztymosnyuuryokuymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYMOSNYUURYOKUYMD)
    public String getZtymosnyuuryokuymd() {
        return ztymosnyuuryokuymd;
    }

    public void setZtymosnyuuryokuymd(String pZtymosnyuuryokuymd) {
        ztymosnyuuryokuymd = pZtymosnyuuryokuymd;
    }

    private String ztykykymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztysekininkaisiymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSEKININKAISIYMD)
    public String getZtysekininkaisiymd() {
        return ztysekininkaisiymd;
    }

    public void setZtysekininkaisiymd(String pZtysekininkaisiymd) {
        ztysekininkaisiymd = pZtysekininkaisiymd;
    }

    private String ztyfstpnyknsyoriymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYFSTPNYKNSYORIYMD)
    public String getZtyfstpnyknsyoriymd() {
        return ztyfstpnyknsyoriymd;
    }

    public void setZtyfstpnyknsyoriymd(String pZtyfstpnyknsyoriymd) {
        ztyfstpnyknsyoriymd = pZtyfstpnyknsyoriymd;
    }

    private String ztyfstpnyknnaiyoukbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYFSTPNYKNNAIYOUKBN)
    public String getZtyfstpnyknnaiyoukbn() {
        return ztyfstpnyknnaiyoukbn;
    }

    public void setZtyfstpnyknnaiyoukbn(String pZtyfstpnyknnaiyoukbn) {
        ztyfstpnyknnaiyoukbn = pZtyfstpnyknnaiyoukbn;
    }

    private String ztysisyaketsyoriymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSISYAKETSYORIYMD)
    public String getZtysisyaketsyoriymd() {
        return ztysisyaketsyoriymd;
    }

    public void setZtysisyaketsyoriymd(String pZtysisyaketsyoriymd) {
        ztysisyaketsyoriymd = pZtysisyaketsyoriymd;
    }

    private String ztysyosakuseiymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSYOSAKUSEIYMD)
    public String getZtysyosakuseiymd() {
        return ztysyosakuseiymd;
    }

    public void setZtysyosakuseiymd(String pZtysyosakuseiymd) {
        ztysyosakuseiymd = pZtysyosakuseiymd;
    }

    private String ztyseisekiym;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSEISEKIYM)
    public String getZtyseisekiym() {
        return ztyseisekiym;
    }

    public void setZtyseisekiym(String pZtyseisekiym) {
        ztyseisekiym = pZtyseisekiym;
    }

    private Long ztysyokaiharaikomip;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSYOKAIHARAIKOMIP)
    public Long getZtysyokaiharaikomip() {
        return ztysyokaiharaikomip;
    }

    public void setZtysyokaiharaikomip(Long pZtysyokaiharaikomip) {
        ztysyokaiharaikomip = pZtysyokaiharaikomip;
    }

    private String ztysyono;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztytokusyujimutoriatukaikbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTOKUSYUJIMUTORIATUKAIKBN)
    public String getZtytokusyujimutoriatukaikbn() {
        return ztytokusyujimutoriatukaikbn;
    }

    public void setZtytokusyujimutoriatukaikbn(String pZtytokusyujimutoriatukaikbn) {
        ztytokusyujimutoriatukaikbn = pZtytokusyujimutoriatukaikbn;
    }

    private String ztybsydrtencd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }

    private String ztybsydrtenkjnm;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYBSYDRTENKJNM)
    public String getZtybsydrtenkjnm() {
        return ztybsydrtenkjnm;
    }

    public void setZtybsydrtenkjnm(String pZtybsydrtenkjnm) {
        ztybsydrtenkjnm = pZtybsydrtenkjnm;
    }

    private String ztyatkisyagyskkjsosikicd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYATKISYAGYSKKJSOSIKICD)
    public String getZtyatkisyagyskkjsosikicd() {
        return ztyatkisyagyskkjsosikicd;
    }

    public void setZtyatkisyagyskkjsosikicd(String pZtyatkisyagyskkjsosikicd) {
        ztyatkisyagyskkjsosikicd = pZtyatkisyagyskkjsosikicd;
    }

    private Integer ztyatkisyadrtenatkiwari;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYATKISYADRTENATKIWARI)
    public Integer getZtyatkisyadrtenatkiwari() {
        return ztyatkisyadrtenatkiwari;
    }

    public void setZtyatkisyadrtenatkiwari(Integer pZtyatkisyadrtenatkiwari) {
        ztyatkisyadrtenatkiwari = pZtyatkisyadrtenatkiwari;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztykinyuukikancd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKINYUUKIKANCD)
    public String getZtykinyuukikancd() {
        return ztykinyuukikancd;
    }

    public void setZtykinyuukikancd(String pZtykinyuukikancd) {
        ztykinyuukikancd = pZtykinyuukikancd;
    }

    private String ztyinfositencd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYINFOSITENCD)
    public String getZtyinfositencd() {
        return ztyinfositencd;
    }

    public void setZtyinfositencd(String pZtyinfositencd) {
        ztyinfositencd = pZtyinfositencd;
    }

    private String ztycifcd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztykjkyknm10;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKJKYKNM10)
    public String getZtykjkyknm10() {
        return ztykjkyknm10;
    }

    public void setZtykjkyknm10(String pZtykjkyknm10) {
        ztykjkyknm10 = pZtykjkyknm10;
    }

    private String ztykthhbhyouji;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKTHHBHYOUJI)
    public String getZtykthhbhyouji() {
        return ztykthhbhyouji;
    }

    public void setZtykthhbhyouji(String pZtykthhbhyouji) {
        ztykthhbhyouji = pZtykthhbhyouji;
    }

    private String ztysrhhbhyouji;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSRHHBHYOUJI)
    public String getZtysrhhbhyouji() {
        return ztysrhhbhyouji;
    }

    public void setZtysrhhbhyouji(String pZtysrhhbhyouji) {
        ztysrhhbhyouji = pZtysrhhbhyouji;
    }

    private String ztymossyumtkktymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYMOSSYUMTKKTYMD)
    public String getZtymossyumtkktymd() {
        return ztymossyumtkktymd;
    }

    public void setZtymossyumtkktymd(String pZtymossyumtkktymd) {
        ztymossyumtkktymd = pZtymossyumtkktymd;
    }

    private String ztydairitenjimusyocd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDAIRITENJIMUSYOCD)
    public String getZtydairitenjimusyocd() {
        return ztydairitenjimusyocd;
    }

    public void setZtydairitenjimusyocd(String pZtydairitenjimusyocd) {
        ztydairitenjimusyocd = pZtydairitenjimusyocd;
    }

    private Long ztytsrybnwari;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTSRYBNWARI)
    public Long getZtytsrybnwari() {
        return ztytsrybnwari;
    }

    public void setZtytsrybnwari(Long pZtytsrybnwari) {
        ztytsrybnwari = pZtytsrybnwari;
    }

    private String ztydrtenkeijyouym;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDRTENKEIJYOUYM)
    public String getZtydrtenkeijyouym() {
        return ztydrtenkeijyouym;
    }

    public void setZtydrtenkeijyouym(String pZtydrtenkeijyouym) {
        ztydrtenkeijyouym = pZtydrtenkeijyouym;
    }

    private String ztykydatkidairitencd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKYDATKIDAIRITENCD)
    public String getZtykydatkidairitencd() {
        return ztykydatkidairitencd;
    }

    public void setZtykydatkidairitencd(String pZtykydatkidairitencd) {
        ztykydatkidairitencd = pZtykydatkidairitencd;
    }

    private String ztydaihyoubosyuunincd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDAIHYOUBOSYUUNINCD)
    public String getZtydaihyoubosyuunincd() {
        return ztydaihyoubosyuunincd;
    }

    public void setZtydaihyoubosyuunincd(String pZtydaihyoubosyuunincd) {
        ztydaihyoubosyuunincd = pZtydaihyoubosyuunincd;
    }

    private String ztytansyukukjdhybosyuunm;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTANSYUKUKJDHYBOSYUUNM)
    public String getZtytansyukukjdhybosyuunm() {
        return ztytansyukukjdhybosyuunm;
    }

    public void setZtytansyukukjdhybosyuunm(String pZtytansyukukjdhybosyuunm) {
        ztytansyukukjdhybosyuunm = pZtytansyukukjdhybosyuunm;
    }

    private String ztyknkyknm15;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKNKYKNM15)
    public String getZtyknkyknm15() {
        return ztyknkyknm15;
    }

    public void setZtyknkyknm15(String pZtyknkyknm15) {
        ztyknkyknm15 = pZtyknkyknm15;
    }

    private String ztydakuhikettikekkacd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDAKUHIKETTIKEKKACD)
    public String getZtydakuhikettikekkacd() {
        return ztydakuhikettikekkacd;
    }

    public void setZtydakuhikettikekkacd(String pZtydakuhikettikekkacd) {
        ztydakuhikettikekkacd = pZtydakuhikettikekkacd;
    }

    private String ztydkhktiymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDKHKTIYMD)
    public String getZtydkhktiymd() {
        return ztydkhktiymd;
    }

    public void setZtydkhktiymd(String pZtydkhktiymd) {
        ztydkhktiymd = pZtydkhktiymd;
    }

    private String ztytoukeiyousinsakbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTOUKEIYOUSINSAKBN)
    public String getZtytoukeiyousinsakbn() {
        return ztytoukeiyousinsakbn;
    }

    public void setZtytoukeiyousinsakbn(String pZtytoukeiyousinsakbn) {
        ztytoukeiyousinsakbn = pZtytoukeiyousinsakbn;
    }

    private String ztyhonninkknnkbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHONNINKKNNKBN)
    public String getZtyhonninkknnkbn() {
        return ztyhonninkknnkbn;
    }

    public void setZtyhonninkknnkbn(String pZtyhonninkknnkbn) {
        ztyhonninkknnkbn = pZtyhonninkknnkbn;
    }

    private String ztynstkarihyj;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYNSTKARIHYJ)
    public String getZtynstkarihyj() {
        return ztynstkarihyj;
    }

    public void setZtynstkarihyj(String pZtynstkarihyj) {
        ztynstkarihyj = pZtynstkarihyj;
    }

    private String ztynstknkkkn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYNSTKNKKKN)
    public String getZtynstknkkkn() {
        return ztynstknkkkn;
    }

    public void setZtynstknkkkn(String pZtynstknkkkn) {
        ztynstknkkkn = pZtynstknkkkn;
    }

    private String ztydrtentsryhushrkykhyouji;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDRTENTSRYHUSHRKYKHYOUJI)
    public String getZtydrtentsryhushrkykhyouji() {
        return ztydrtentsryhushrkykhyouji;
    }

    public void setZtydrtentsryhushrkykhyouji(String pZtydrtentsryhushrkykhyouji) {
        ztydrtentsryhushrkykhyouji = pZtydrtentsryhushrkykhyouji;
    }

    private String ztynyknkanskanouhyouji;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYNYKNKANSKANOUHYOUJI)
    public String getZtynyknkanskanouhyouji() {
        return ztynyknkanskanouhyouji;
    }

    public void setZtynyknkanskanouhyouji(String pZtynyknkanskanouhyouji) {
        ztynyknkanskanouhyouji = pZtynyknkanskanouhyouji;
    }

    private String ztydshukahyouji;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDSHUKAHYOUJI)
    public String getZtydshukahyouji() {
        return ztydshukahyouji;
    }

    public void setZtydshukahyouji(String pZtydshukahyouji) {
        ztydshukahyouji = pZtydshukahyouji;
    }

    private String ztystdairiseikyuutkykarihyj;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZtystdairiseikyuutkykarihyj() {
        return ztystdairiseikyuutkykarihyj;
    }

    public void setZtystdairiseikyuutkykarihyj(String pZtystdairiseikyuutkykarihyj) {
        ztystdairiseikyuutkykarihyj = pZtystdairiseikyuutkykarihyj;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztykyksyaseikbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKYKSYASEIKBN)
    public String getZtykyksyaseikbn() {
        return ztykyksyaseikbn;
    }

    public void setZtykyksyaseikbn(String pZtykyksyaseikbn) {
        ztykyksyaseikbn = pZtykyksyaseikbn;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztydrtenpaperlessmoshyj;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDRTENPAPERLESSMOSHYJ)
    public String getZtydrtenpaperlessmoshyj() {
        return ztydrtenpaperlessmoshyj;
    }

    public void setZtydrtenpaperlessmoshyj(String pZtydrtenpaperlessmoshyj) {
        ztydrtenpaperlessmoshyj = pZtydrtenpaperlessmoshyj;
    }

    private String ztydrtenmostousyaukeymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDRTENMOSTOUSYAUKEYMD)
    public String getZtydrtenmostousyaukeymd() {
        return ztydrtenmostousyaukeymd;
    }

    public void setZtydrtenmostousyaukeymd(String pZtydrtenmostousyaukeymd) {
        ztydrtenmostousyaukeymd = pZtydrtenmostousyaukeymd;
    }

    private String ztykyktuuka;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKYKTUUKA)
    public String getZtykyktuuka() {
        return ztykyktuuka;
    }

    public void setZtykyktuuka(String pZtykyktuuka) {
        ztykyktuuka = pZtykyktuuka;
    }

    private String ztyhrktuuka;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHRKTUUKA)
    public String getZtyhrktuuka() {
        return ztyhrktuuka;
    }

    public void setZtyhrktuuka(String pZtyhrktuuka) {
        ztyhrktuuka = pZtyhrktuuka;
    }

    private BizNumber ztysykihrkpgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSYKIHRKPGAIKA)
    public BizNumber getZtysykihrkpgaika() {
        return ztysykihrkpgaika;
    }

    public void setZtysykihrkpgaika(BizNumber pZtysykihrkpgaika) {
        ztysykihrkpgaika = pZtysykihrkpgaika;
    }

    private String ztyyennykntkarihyouji;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYYENNYKNTKARIHYOUJI)
    public String getZtyyennykntkarihyouji() {
        return ztyyennykntkarihyouji;
    }

    public void setZtyyennykntkarihyouji(String pZtyyennykntkarihyouji) {
        ztyyennykntkarihyouji = pZtyyennykntkarihyouji;
    }

    private String ztygaikanykntkarihyouji;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYGAIKANYKNTKARIHYOUJI)
    public String getZtygaikanykntkarihyouji() {
        return ztygaikanykntkarihyouji;
    }

    public void setZtygaikanykntkarihyouji(String pZtygaikanykntkarihyouji) {
        ztygaikanykntkarihyouji = pZtygaikanykntkarihyouji;
    }

    private BizNumber ztykihonsgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKIHONSGAIKA)
    public BizNumber getZtykihonsgaika() {
        return ztykihonsgaika;
    }

    public void setZtykihonsgaika(BizNumber pZtykihonsgaika) {
        ztykihonsgaika = pZtykihonsgaika;
    }

    private BizNumber ztytekiyoukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTEKIYOUKAWASERATE)
    public BizNumber getZtytekiyoukawaserate() {
        return ztytekiyoukawaserate;
    }

    public void setZtytekiyoukawaserate(BizNumber pZtytekiyoukawaserate) {
        ztytekiyoukawaserate = pZtytekiyoukawaserate;
    }

    private String ztykawaseratetekiyouymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKAWASERATETEKIYOUYMD)
    public String getZtykawaseratetekiyouymd() {
        return ztykawaseratetekiyouymd;
    }

    public void setZtykawaseratetekiyouymd(String pZtykawaseratetekiyouymd) {
        ztykawaseratetekiyouymd = pZtykawaseratetekiyouymd;
    }

    private String ztymkhyoutiyensysnikoukbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYMKHYOUTIYENSYSNIKOUKBN)
    public String getZtymkhyoutiyensysnikoukbn() {
        return ztymkhyoutiyensysnikoukbn;
    }

    public void setZtymkhyoutiyensysnikoukbn(String pZtymkhyoutiyensysnikoukbn) {
        ztymkhyoutiyensysnikoukbn = pZtymkhyoutiyensysnikoukbn;
    }

    private String ztysyksbyensitihsyutkykhyj;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSYKSBYENSITIHSYUTKYKHYJ)
    public String getZtysyksbyensitihsyutkykhyj() {
        return ztysyksbyensitihsyutkykhyj;
    }

    public void setZtysyksbyensitihsyutkykhyj(String pZtysyksbyensitihsyutkykhyj) {
        ztysyksbyensitihsyutkykhyj = pZtysyksbyensitihsyutkykhyj;
    }

    private String ztyjyudkaigomehrtkarihyj;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYJYUDKAIGOMEHRTKARIHYJ)
    public String getZtyjyudkaigomehrtkarihyj() {
        return ztyjyudkaigomehrtkarihyj;
    }

    public void setZtyjyudkaigomehrtkarihyj(String pZtyjyudkaigomehrtkarihyj) {
        ztyjyudkaigomehrtkarihyj = pZtyjyudkaigomehrtkarihyj;
    }

    private BizNumber ztysykihrkpsiteituuka;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSYKIHRKPSITEITUUKA)
    public BizNumber getZtysykihrkpsiteituuka() {
        return ztysykihrkpsiteituuka;
    }

    public void setZtysykihrkpsiteituuka(BizNumber pZtysykihrkpsiteituuka) {
        ztysykihrkpsiteituuka = pZtysykihrkpsiteituuka;
    }

    private String ztyteirituhaibunwari;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTEIRITUHAIBUNWARI)
    public String getZtyteirituhaibunwari() {
        return ztyteirituhaibunwari;
    }

    public void setZtyteirituhaibunwari(String pZtyteirituhaibunwari) {
        ztyteirituhaibunwari = pZtyteirituhaibunwari;
    }

    private String ztysueokikknkbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSUEOKIKKNKBN)
    public String getZtysueokikknkbn() {
        return ztysueokikknkbn;
    }

    public void setZtysueokikknkbn(String pZtysueokikknkbn) {
        ztysueokikknkbn = pZtysueokikknkbn;
    }

    private String ztynksyuruikbn1;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYNKSYURUIKBN1)
    public String getZtynksyuruikbn1() {
        return ztynksyuruikbn1;
    }

    public void setZtynksyuruikbn1(String pZtynksyuruikbn1) {
        ztynksyuruikbn1 = pZtynksyuruikbn1;
    }

    private String ztydairitenkbtinfo1;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDAIRITENKBTINFO1)
    public String getZtydairitenkbtinfo1() {
        return ztydairitenkbtinfo1;
    }

    public void setZtydairitenkbtinfo1(String pZtydairitenkbtinfo1) {
        ztydairitenkbtinfo1 = pZtydairitenkbtinfo1;
    }

    private String ztydairitenkbtinfo2;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDAIRITENKBTINFO2)
    public String getZtydairitenkbtinfo2() {
        return ztydairitenkbtinfo2;
    }

    public void setZtydairitenkbtinfo2(String pZtydairitenkbtinfo2) {
        ztydairitenkbtinfo2 = pZtydairitenkbtinfo2;
    }

    private String ztydairitenkbtinfo3;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDAIRITENKBTINFO3)
    public String getZtydairitenkbtinfo3() {
        return ztydairitenkbtinfo3;
    }

    public void setZtydairitenkbtinfo3(String pZtydairitenkbtinfo3) {
        ztydairitenkbtinfo3 = pZtydairitenkbtinfo3;
    }

    private String ztyyohurimiryou;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYYOHURIMIRYOU)
    public String getZtyyohurimiryou() {
        return ztyyohurimiryou;
    }

    public void setZtyyohurimiryou(String pZtyyohurimiryou) {
        ztyyohurimiryou = pZtyyohurimiryou;
    }

    private String ztykznyuuryokuymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKZNYUURYOKUYMD)
    public String getZtykznyuuryokuymd() {
        return ztykznyuuryokuymd;
    }

    public void setZtykznyuuryokuymd(String pZtykznyuuryokuymd) {
        ztykznyuuryokuymd = pZtykznyuuryokuymd;
    }

    private String ztysetaitemosno;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSETAITEMOSNO)
    public String getZtysetaitemosno() {
        return ztysetaitemosno;
    }

    public void setZtysetaitemosno(String pZtysetaitemosno) {
        ztysetaitemosno = pZtysetaitemosno;
    }

    private String ztyyakkanjyuryouhoukbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYYAKKANJYURYOUHOUKBN)
    public String getZtyyakkanjyuryouhoukbn() {
        return ztyyakkanjyuryouhoukbn;
    }

    public void setZtyyakkanjyuryouhoukbn(String pZtyyakkanjyuryouhoukbn) {
        ztyyakkanjyuryouhoukbn = pZtyyakkanjyuryouhoukbn;
    }

    private String ztyyakkanbunsyono;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYYAKKANBUNSYONO)
    public String getZtyyakkanbunsyono() {
        return ztyyakkanbunsyono;
    }

    public void setZtyyakkanbunsyono(String pZtyyakkanbunsyono) {
        ztyyakkanbunsyono = pZtyyakkanbunsyono;
    }

    private String ztykzhuritourokuhoukbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKZHURITOUROKUHOUKBN)
    public String getZtykzhuritourokuhoukbn() {
        return ztykzhuritourokuhoukbn;
    }

    public void setZtykzhuritourokuhoukbn(String pZtykzhuritourokuhoukbn) {
        ztykzhuritourokuhoukbn = pZtykzhuritourokuhoukbn;
    }

    private String ztydai1hknkkn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYDAI1HKNKKN)
    public String getZtydai1hknkkn() {
        return ztydai1hknkkn;
    }

    public void setZtydai1hknkkn(String pZtydai1hknkkn) {
        ztydai1hknkkn = pZtydai1hknkkn;
    }

    private String ztycreditnyuuryokuymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYCREDITNYUURYOKUYMD)
    public String getZtycreditnyuuryokuymd() {
        return ztycreditnyuuryokuymd;
    }

    public void setZtycreditnyuuryokuymd(String pZtycreditnyuuryokuymd) {
        ztycreditnyuuryokuymd = pZtycreditnyuuryokuymd;
    }

    private String ztycreditmiryou;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYCREDITMIRYOU)
    public String getZtycreditmiryou() {
        return ztycreditmiryou;
    }

    public void setZtycreditmiryou(String pZtycreditmiryou) {
        ztycreditmiryou = pZtycreditmiryou;
    }

    private String ztycredittrkhoukbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYCREDITTRKHOUKBN)
    public String getZtycredittrkhoukbn() {
        return ztycredittrkhoukbn;
    }

    public void setZtycredittrkhoukbn(String pZtycredittrkhoukbn) {
        ztycredittrkhoukbn = pZtycredittrkhoukbn;
    }

    private String ztycardbrandkbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYCARDBRANDKBN)
    public String getZtycardbrandkbn() {
        return ztycardbrandkbn;
    }

    public void setZtycardbrandkbn(String pZtycardbrandkbn) {
        ztycardbrandkbn = pZtycardbrandkbn;
    }

    private String ztycarddatasousinymd;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYCARDDATASOUSINYMD)
    public String getZtycarddatasousinymd() {
        return ztycarddatasousinymd;
    }

    public void setZtycarddatasousinymd(String pZtycarddatasousinymd) {
        ztycarddatasousinymd = pZtycarddatasousinymd;
    }

    private String ztykykdrtkykarihyj;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKYKDRTKYKARIHYJ)
    public String getZtykykdrtkykarihyj() {
        return ztykykdrtkykarihyj;
    }

    public void setZtykykdrtkykarihyj(String pZtykykdrtkykarihyj) {
        ztykykdrtkykarihyj = pZtykykdrtkykarihyj;
    }

    private String ztykzktrkservicekbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKZKTRKSERVICEKBN)
    public String getZtykzktrkservicekbn() {
        return ztykzktrkservicekbn;
    }

    public void setZtykzktrkservicekbn(String pZtykzktrkservicekbn) {
        ztykzktrkservicekbn = pZtykzktrkservicekbn;
    }

    private String ztyteikisiharaiarihyj;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTEIKISIHARAIARIHYJ)
    public String getZtyteikisiharaiarihyj() {
        return ztyteikisiharaiarihyj;
    }

    public void setZtyteikisiharaiarihyj(String pZtyteikisiharaiarihyj) {
        ztyteikisiharaiarihyj = pZtyteikisiharaiarihyj;
    }

    private String ztyteikishrkinshrtuukakbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTEIKISHRKINSHRTUUKAKBN)
    public String getZtyteikishrkinshrtuukakbn() {
        return ztyteikishrkinshrtuukakbn;
    }

    public void setZtyteikishrkinshrtuukakbn(String pZtyteikishrkinshrtuukakbn) {
        ztyteikishrkinshrtuukakbn = pZtyteikishrkinshrtuukakbn;
    }

    private BizNumber ztyteikisiharaikin;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYTEIKISIHARAIKIN)
    public BizNumber getZtyteikisiharaikin() {
        return ztyteikisiharaikin;
    }

    public void setZtyteikisiharaikin(BizNumber pZtyteikisiharaikin) {
        ztyteikisiharaikin = pZtyteikisiharaikin;
    }

    private String ztykoureikzksetumeihoukbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKOUREIKZKSETUMEIHOUKBN)
    public String getZtykoureikzksetumeihoukbn() {
        return ztykoureikzksetumeihoukbn;
    }

    public void setZtykoureikzksetumeihoukbn(String pZtykoureikzksetumeihoukbn) {
        ztykoureikzksetumeihoukbn = pZtykoureikzksetumeihoukbn;
    }

    private String ztykoureimndnhukusuukaikbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKOUREIMNDNHUKUSUUKAIKBN)
    public String getZtykoureimndnhukusuukaikbn() {
        return ztykoureimndnhukusuukaikbn;
    }

    public void setZtykoureimndnhukusuukaikbn(String pZtykoureimndnhukusuukaikbn) {
        ztykoureimndnhukusuukaikbn = pZtykoureimndnhukusuukaikbn;
    }

    private String ztykoureitratkisyaigidskkbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYKOUREITRATKISYAIGIDSKKBN)
    public String getZtykoureitratkisyaigidskkbn() {
        return ztykoureitratkisyaigidskkbn;
    }

    public void setZtykoureitratkisyaigidskkbn(String pZtykoureitratkisyaigidskkbn) {
        ztykoureitratkisyaigidskkbn = pZtykoureitratkisyaigidskkbn;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private Long ztynnknsnpssysyup;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYNNKNSNPSSYSYUP)
    public Long getZtynnknsnpssysyup() {
        return ztynnknsnpssysyup;
    }

    public void setZtynnknsnpssysyup(Long pZtynnknsnpssysyup) {
        ztynnknsnpssysyup = pZtynnknsnpssysyup;
    }

    private BizNumber ztynnknsnpssykwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiTy.ZTYNNKNSNPSSYKWSRATE)
    public BizNumber getZtynnknsnpssykwsrate() {
        return ztynnknsnpssykwsrate;
    }

    public void setZtynnknsnpssykwsrate(BizNumber pZtynnknsnpssykwsrate) {
        ztynnknsnpssykwsrate = pZtynnknsnpssykwsrate;
    }

    private Long ztyzennoup;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYZENNOUP)
    public Long getZtyzennoup() {
        return ztyzennoup;
    }

    public void setZtyzennoup(Long pZtyzennoup) {
        ztyzennoup = pZtyzennoup;
    }

    private String ztynenkinzeiseitokuyakukbn;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYNENKINZEISEITOKUYAKUKBN)
    public String getZtynenkinzeiseitokuyakukbn() {
        return ztynenkinzeiseitokuyakukbn;
    }

    public void setZtynenkinzeiseitokuyakukbn(String pZtynenkinzeiseitokuyakukbn) {
        ztynenkinzeiseitokuyakukbn = pZtynenkinzeiseitokuyakukbn;
    }

    private String ztyyobiv33;

    @Column(name=GenZT_DrtenIpToukeiTy.ZTYYOBIV33)
    public String getZtyyobiv33() {
        return ztyyobiv33;
    }

    public void setZtyyobiv33(String pZtyyobiv33) {
        ztyyobiv33 = pZtyyobiv33;
    }
}