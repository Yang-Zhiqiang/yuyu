package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_DrtenIpToukeiRn;
import yuyu.def.db.id.PKZT_DrtenIpToukeiRn;
import yuyu.def.db.meta.GenQZT_DrtenIpToukeiRn;
import yuyu.def.db.meta.QZT_DrtenIpToukeiRn;

/**
 * 代理店用ＩＰ統計用Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_DrtenIpToukeiRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_DrtenIpToukeiRn}</td><td colspan="3">代理店用ＩＰ統計用Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrneigyouhonbusisyacd zrneigyouhonbusisyacd}</td><td>（連携用）営業本部支社コード</td><td align="center">{@link PKZT_DrtenIpToukeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsosikicd zrnsosikicd}</td><td>（連携用）組織コード</td><td align="center">{@link PKZT_DrtenIpToukeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatukaikojincd zrnatukaikojincd}</td><td>（連携用）扱者個人コード</td><td align="center">{@link PKZT_DrtenIpToukeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosym zrnmosym}</td><td>（連携用）申込月度</td><td align="center">{@link PKZT_DrtenIpToukeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmoskbn zrnmoskbn}</td><td>（連携用）申込区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntansyukukjatukaisyanm zrntansyukukjatukaisyanm}</td><td>（連携用）短縮漢字扱者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">{@link PKZT_DrtenIpToukeiRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyoumetukbn zrnmossyoumetukbn}</td><td>（連携用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkurikosiriyuukbn zrnkurikosiriyuukbn}</td><td>（連携用）繰越理由区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknzumihyouji zrnnyknzumihyouji}</td><td>（連携用）入金済表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeihknsyruikbn zrntoukeihknsyruikbn}</td><td>（連携用）統計用保険種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjykktkbn zrnhjykktkbn}</td><td>（連携用）報状告知区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykktaikbn zrnkykktaikbn}</td><td>（連携用）契約形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyunhsys zrnjyunhsys}</td><td>（連携用）純保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhsys zrnhsys}</td><td>（連携用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsoukensuu zrnsoukensuu}</td><td>（連携用）総件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnketjkkbn zrnketjkkbn}</td><td>（連携用）決定状況区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhiktjyoutaikbn zrndakuhiktjyoutaikbn}</td><td>（連携用）諾否決定状態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonhubi zrnkihonhubi}</td><td>（連携用）基本不備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsphubi zrnsphubi}</td><td>（連携用）ＳＰ不備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsseigenhubi zrnsseigenhubi}</td><td>（連携用）Ｓ制限不備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnayosehumei zrnnayosehumei}</td><td>（連携用）名寄不明</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuusangendoover zrntuusangendoover}</td><td>（連携用）通算限度オーバー</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosketteihoryuu zrnmosketteihoryuu}</td><td>（連携用）申込決定保留</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykkakjissityuu zrnkykkakjissityuu}</td><td>（連携用）契約確認実施中</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkktketteihoryuu zrnkktketteihoryuu}</td><td>（連携用）告知決定保留</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhonsyakethoryuu zrnhonsyakethoryuu}</td><td>（連携用）本社決定保留</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseiymdhubi zrnseiymdhubi}</td><td>（連携用）生年月日不備</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphusoku zrnphusoku}</td><td>（連携用）Ｐ不足</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrhuketyu zrnsrhuketyu}</td><td>（連携用）成立保留受付中</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpkakin zrnpkakin}</td><td>（連携用）Ｐ過金</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsudirtnatkikeitaikbn zrnbsudirtnatkikeitaikbn}</td><td>（連携用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakuseiymd zrnsakuseiymd}</td><td>（連携用）作成日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkikbn zrnkydatkikbn}</td><td>（連携用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntansyukukjhhknnm zrntansyukukjhhknnm}</td><td>（連携用）短縮漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsykgycd zrnhhknsykgycd}</td><td>（連携用）被保険者職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnen2keta zrnhhknnen2keta}</td><td>（連携用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmusymd zrnmusymd}</td><td>（連携用）申込年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaipryosyuymd zrnsyokaipryosyuymd}</td><td>（連携用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkokutiymd zrnkokutiymd}</td><td>（連携用）告知年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosnyuuryokuymd zrnmosnyuuryokuymd}</td><td>（連携用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsekininkaisiymd zrnsekininkaisiymd}</td><td>（連携用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstpnyknsyoriymd zrnfstpnyknsyoriymd}</td><td>（連携用）初回Ｐ入金処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnfstpnyknnaiyoukbn zrnfstpnyknnaiyoukbn}</td><td>（連携用）初回Ｐ入金内容区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisyaketsyoriymd zrnsisyaketsyoriymd}</td><td>（連携用）支社決定処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosakuseiymd zrnsyosakuseiymd}</td><td>（連携用）証券作成年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisekiym zrnseisekiym}</td><td>（連携用）成績計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyokaiharaikomip zrnsyokaiharaikomip}</td><td>（連携用）初回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokusyujimutoriatukaikbn zrntokusyujimutoriatukaikbn}</td><td>（連携用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtencd zrnbsydrtencd}</td><td>（連携用）募集代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbsydrtenkjnm zrnbsydrtenkjnm}</td><td>（連携用）募集代理店漢字名称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatkisyagyskkjsosikicd zrnatkisyagyskkjsosikicd}</td><td>（連携用）扱者業績計上先組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnatkisyadrtenatkiwari zrnatkisyadrtenatkiwari}</td><td>（連携用）扱者代理店扱割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkinyuukikancd zrnkinyuukikancd}</td><td>（連携用）金融機関コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrninfositencd zrninfositencd}</td><td>（連携用）（情報系）支店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncifcd zrncifcd}</td><td>（連携用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkyknm10 zrnkjkyknm10}</td><td>（連携用）漢字契約者名（１０文字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkthhbhyouji zrnkthhbhyouji}</td><td>（連携用）決定保留不備表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrhhbhyouji zrnsrhhbhyouji}</td><td>（連携用）成立保留不備表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyumtkktymd zrnmossyumtkktymd}</td><td>（連携用）申込消滅確定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenjimusyocd zrndairitenjimusyocd}</td><td>（連携用）代理店事務所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsrybnwari zrntsrybnwari}</td><td>（連携用）手数料分割割合</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndrtenkeijyouym zrndrtenkeijyouym}</td><td>（連携用）代理店計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkydatkidairitencd zrnkydatkidairitencd}</td><td>（連携用）共同扱代理店コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndaihyoubosyuunincd zrndaihyoubosyuunincd}</td><td>（連携用）代表募集人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntansyukukjdhybosyuunm zrntansyukukjdhybosyuunm}</td><td>（連携用）短縮漢字代表募集人名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkyknm15 zrnknkyknm15}</td><td>（連携用）カナ契約者名（１５文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndakuhikettikekkacd zrndakuhikettikekkacd}</td><td>（連携用）諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndkhktiymd zrndkhktiymd}</td><td>（連携用）諾否決定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntoukeiyousinsakbn zrntoukeiyousinsakbn}</td><td>（連携用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhonninkknnkbn zrnhonninkknnkbn}</td><td>（連携用）本人確認区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnstkarihyj zrnnstkarihyj}</td><td>（連携用）年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnstknkkkn zrnnstknkkkn}</td><td>（連携用）年金支払特約年金期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtentsryhushrkykhyouji zrndrtentsryhushrkykhyouji}</td><td>（連携用）代理店手数料不支払契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnyknkanskanouhyouji zrnnyknkanskanouhyouji}</td><td>（連携用）入金勧奨可能表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndshukahyouji zrndshukahyouji}</td><td>（連携用）ＤＳ付加表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnstdairiseikyuutkykarihyj zrnstdairiseikyuutkykarihyj}</td><td>（連携用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen zrnkyksyanen}</td><td>（連携用）契約者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseikbn zrnkyksyaseikbn}</td><td>（連携用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseiymd zrnhhknseiymd}</td><td>（連携用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtenpaperlessmoshyj zrndrtenpaperlessmoshyj}</td><td>（連携用）代理店ペーパーレス申込表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndrtenmostousyaukeymd zrndrtenmostousyaukeymd}</td><td>（連携用）代理店申込書当社受付年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktuuka zrnkyktuuka}</td><td>（連携用）契約通貨</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrktuuka zrnhrktuuka}</td><td>（連携用）払込通貨</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykihrkpgaika zrnsykihrkpgaika}</td><td>（連携用）初回払込Ｐ（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyennykntkarihyouji zrnyennykntkarihyouji}</td><td>（連携用）円入金特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikanykntkarihyouji zrngaikanykntkarihyouji}</td><td>（連携用）外貨入金特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihonsgaika zrnkihonsgaika}</td><td>（連携用）基本Ｓ（外貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntekiyoukawaserate zrntekiyoukawaserate}</td><td>（連携用）適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd zrnkawaseratetekiyouymd}</td><td>（連携用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmkhyoutiyensysnikoukbn zrnmkhyoutiyensysnikoukbn}</td><td>（連携用）目標到達時円建終身保障移行区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyksbyensitihsyutkykhyj zrnsyksbyensitihsyutkykhyj}</td><td>（連携用）初期死亡時円換算最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyudkaigomehrtkarihyj zrnjyudkaigomehrtkarihyj}</td><td>（連携用）重度介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykihrkpsiteituuka zrnsykihrkpsiteituuka}</td><td>（連携用）初回払込Ｐ（指定通貨）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnteirituhaibunwari zrnteirituhaibunwari}</td><td>（連携用）定率部分配分割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsueokikknkbn zrnsueokikknkbn}</td><td>（連携用）据置期間区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnksyuruikbn1 zrnnksyuruikbn1}</td><td>（連携用）年金種類区分（１文字）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkbtinfo1 zrndairitenkbtinfo1}</td><td>（連携用）代理店個別情報１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkbtinfo2 zrndairitenkbtinfo2}</td><td>（連携用）代理店個別情報２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndairitenkbtinfo3 zrndairitenkbtinfo3}</td><td>（連携用）代理店個別情報３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyohurimiryou zrnyohurimiryou}</td><td>（連携用）預振未了</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkznyuuryokuymd zrnkznyuuryokuymd}</td><td>（連携用）口座入力年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitemosno zrnsetaitemosno}</td><td>（連携用）セット相手申込番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakkanjyuryouhoukbn zrnyakkanjyuryouhoukbn}</td><td>（連携用）約款受領方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyakkanbunsyono zrnyakkanbunsyono}</td><td>（連携用）約款文書番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzhuritourokuhoukbn zrnkzhuritourokuhoukbn}</td><td>（連携用）口座振替登録方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditnyuuryokuymd zrncreditnyuuryokuymd}</td><td>（連携用）クレジット入力年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncreditmiryou zrncreditmiryou}</td><td>（連携用）クレカ未了</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncredittrkhoukbn zrncredittrkhoukbn}</td><td>（連携用）クレジット登録方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncardbrandkbn zrncardbrandkbn}</td><td>（連携用）カードブランド</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrncarddatasousinymd zrncarddatasousinymd}</td><td>（連携用）カードデータ送信日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykdrtkykarihyj zrnkykdrtkykarihyj}</td><td>（連携用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktrkservicekbn zrnkzktrkservicekbn}</td><td>（連携用）ご家族登録サービス区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikisiharaiarihyj zrnteikisiharaiarihyj}</td><td>（連携用）定期支払特約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikishrkinshrtuukakbn zrnteikishrkinshrtuukakbn}</td><td>（連携用）定期支払金支払通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikisiharaikin zrnteikisiharaikin}</td><td>（連携用）定期支払金</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkoureikzksetumeihoukbn zrnkoureikzksetumeihoukbn}</td><td>（連携用）高齢者ご家族等説明方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkoureimndnhukusuukaikbn zrnkoureimndnhukusuukaikbn}</td><td>（連携用）高齢者面談複数回実施区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkoureitratkisyaigidskkbn zrnkoureitratkisyaigidskkbn}</td><td>（連携用）高齢者取扱者以外同席区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssysyup zrnnnknsnpssysyup}</td><td>（連携用）年換算Ｐ算出用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnnknsnpssykwsrate zrnnnknsnpssykwsrate}</td><td>（連携用）年換算Ｐ算出用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnzennoup zrnzennoup}</td><td>（連携用）前納保険料</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnenkinzeiseitokuyakukbn zrnnenkinzeiseitokuyakukbn}</td><td>（連携用）年金税制特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv33 zrnyobiv33}</td><td>（連携用）予備項目Ｖ３３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_DrtenIpToukeiRn
 * @see     PKZT_DrtenIpToukeiRn
 * @see     QZT_DrtenIpToukeiRn
 * @see     GenQZT_DrtenIpToukeiRn
 */
@MappedSuperclass
@Table(name=GenZT_DrtenIpToukeiRn.TABLE_NAME)
@IdClass(value=PKZT_DrtenIpToukeiRn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_DrtenIpToukeiRn extends AbstractExDBEntityForZDB<ZT_DrtenIpToukeiRn, PKZT_DrtenIpToukeiRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_DrtenIpToukeiRn";
    public static final String ZRNEIGYOUHONBUSISYACD    = "zrneigyouhonbusisyacd";
    public static final String ZRNSOSIKICD              = "zrnsosikicd";
    public static final String ZRNATUKAIKOJINCD         = "zrnatukaikojincd";
    public static final String ZRNMOSYM                 = "zrnmosym";
    public static final String ZRNMOSKBN                = "zrnmoskbn";
    public static final String ZRNTANSYUKUKJATUKAISYANM = "zrntansyukukjatukaisyanm";
    public static final String ZRNMOSNO                 = "zrnmosno";
    public static final String ZRNMOSSYOUMETUKBN        = "zrnmossyoumetukbn";
    public static final String ZRNKURIKOSIRIYUUKBN      = "zrnkurikosiriyuukbn";
    public static final String ZRNNYKNZUMIHYOUJI        = "zrnnyknzumihyouji";
    public static final String ZRNTOUKEIHKNSYRUIKBN     = "zrntoukeihknsyruikbn";
    public static final String ZRNHJYKKTKBN             = "zrnhjykktkbn";
    public static final String ZRNKYKKTAIKBN            = "zrnkykktaikbn";
    public static final String ZRNJYUNHSYS              = "zrnjyunhsys";
    public static final String ZRNHSYS                  = "zrnhsys";
    public static final String ZRNSOUKENSUU             = "zrnsoukensuu";
    public static final String ZRNKETJKKBN              = "zrnketjkkbn";
    public static final String ZRNDAKUHIKTJYOUTAIKBN    = "zrndakuhiktjyoutaikbn";
    public static final String ZRNKIHONHUBI             = "zrnkihonhubi";
    public static final String ZRNSPHUBI                = "zrnsphubi";
    public static final String ZRNSSEIGENHUBI           = "zrnsseigenhubi";
    public static final String ZRNNAYOSEHUMEI           = "zrnnayosehumei";
    public static final String ZRNTUUSANGENDOOVER       = "zrntuusangendoover";
    public static final String ZRNMOSKETTEIHORYUU       = "zrnmosketteihoryuu";
    public static final String ZRNKYKKAKJISSITYUU       = "zrnkykkakjissityuu";
    public static final String ZRNKKTKETTEIHORYUU       = "zrnkktketteihoryuu";
    public static final String ZRNHONSYAKETHORYUU       = "zrnhonsyakethoryuu";
    public static final String ZRNSEIYMDHUBI            = "zrnseiymdhubi";
    public static final String ZRNPHUSOKU               = "zrnphusoku";
    public static final String ZRNSRHUKETYU             = "zrnsrhuketyu";
    public static final String ZRNPKAKIN                = "zrnpkakin";
    public static final String ZRNBSUDIRTNATKIKEITAIKBN = "zrnbsudirtnatkikeitaikbn";
    public static final String ZRNSAKUSEIYMD            = "zrnsakuseiymd";
    public static final String ZRNKYDATKIKBN            = "zrnkydatkikbn";
    public static final String ZRNTANSYUKUKJHHKNNM      = "zrntansyukukjhhknnm";
    public static final String ZRNHHKNSYKGYCD           = "zrnhhknsykgycd";
    public static final String ZRNHHKNNEN2KETA          = "zrnhhknnen2keta";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNMUSYMD                = "zrnmusymd";
    public static final String ZRNSYOKAIPRYOSYUYMD      = "zrnsyokaipryosyuymd";
    public static final String ZRNKOKUTIYMD             = "zrnkokutiymd";
    public static final String ZRNMOSNYUURYOKUYMD       = "zrnmosnyuuryokuymd";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNSEKININKAISIYMD       = "zrnsekininkaisiymd";
    public static final String ZRNFSTPNYKNSYORIYMD      = "zrnfstpnyknsyoriymd";
    public static final String ZRNFSTPNYKNNAIYOUKBN     = "zrnfstpnyknnaiyoukbn";
    public static final String ZRNSISYAKETSYORIYMD      = "zrnsisyaketsyoriymd";
    public static final String ZRNSYOSAKUSEIYMD         = "zrnsyosakuseiymd";
    public static final String ZRNSEISEKIYM             = "zrnseisekiym";
    public static final String ZRNSYOKAIHARAIKOMIP      = "zrnsyokaiharaikomip";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNTOKUSYUJIMUTORIATUKAIKBN = "zrntokusyujimutoriatukaikbn";
    public static final String ZRNBSYDRTENCD            = "zrnbsydrtencd";
    public static final String ZRNBSYDRTENKJNM          = "zrnbsydrtenkjnm";
    public static final String ZRNATKISYAGYSKKJSOSIKICD = "zrnatkisyagyskkjsosikicd";
    public static final String ZRNATKISYADRTENATKIWARI  = "zrnatkisyadrtenatkiwari";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNKINYUUKIKANCD         = "zrnkinyuukikancd";
    public static final String ZRNINFOSITENCD           = "zrninfositencd";
    public static final String ZRNCIFCD                 = "zrncifcd";
    public static final String ZRNKJKYKNM10             = "zrnkjkyknm10";
    public static final String ZRNKTHHBHYOUJI           = "zrnkthhbhyouji";
    public static final String ZRNSRHHBHYOUJI           = "zrnsrhhbhyouji";
    public static final String ZRNMOSSYUMTKKTYMD        = "zrnmossyumtkktymd";
    public static final String ZRNDAIRITENJIMUSYOCD     = "zrndairitenjimusyocd";
    public static final String ZRNTSRYBNWARI            = "zrntsrybnwari";
    public static final String ZRNDRTENKEIJYOUYM        = "zrndrtenkeijyouym";
    public static final String ZRNKYDATKIDAIRITENCD     = "zrnkydatkidairitencd";
    public static final String ZRNDAIHYOUBOSYUUNINCD    = "zrndaihyoubosyuunincd";
    public static final String ZRNTANSYUKUKJDHYBOSYUUNM = "zrntansyukukjdhybosyuunm";
    public static final String ZRNKNKYKNM15             = "zrnknkyknm15";
    public static final String ZRNDAKUHIKETTIKEKKACD    = "zrndakuhikettikekkacd";
    public static final String ZRNDKHKTIYMD             = "zrndkhktiymd";
    public static final String ZRNTOUKEIYOUSINSAKBN     = "zrntoukeiyousinsakbn";
    public static final String ZRNHONNINKKNNKBN         = "zrnhonninkknnkbn";
    public static final String ZRNNSTKARIHYJ            = "zrnnstkarihyj";
    public static final String ZRNNSTKNKKKN             = "zrnnstknkkkn";
    public static final String ZRNDRTENTSRYHUSHRKYKHYOUJI = "zrndrtentsryhushrkykhyouji";
    public static final String ZRNNYKNKANSKANOUHYOUJI   = "zrnnyknkanskanouhyouji";
    public static final String ZRNDSHUKAHYOUJI          = "zrndshukahyouji";
    public static final String ZRNSTDAIRISEIKYUUTKYKARIHYJ = "zrnstdairiseikyuutkykarihyj";
    public static final String ZRNKYKSYANEN             = "zrnkyksyanen";
    public static final String ZRNKYKSYASEIKBN          = "zrnkyksyaseikbn";
    public static final String ZRNHHKNSEIYMD            = "zrnhhknseiymd";
    public static final String ZRNDRTENPAPERLESSMOSHYJ  = "zrndrtenpaperlessmoshyj";
    public static final String ZRNDRTENMOSTOUSYAUKEYMD  = "zrndrtenmostousyaukeymd";
    public static final String ZRNKYKTUUKA              = "zrnkyktuuka";
    public static final String ZRNHRKTUUKA              = "zrnhrktuuka";
    public static final String ZRNSYKIHRKPGAIKA         = "zrnsykihrkpgaika";
    public static final String ZRNYENNYKNTKARIHYOUJI    = "zrnyennykntkarihyouji";
    public static final String ZRNGAIKANYKNTKARIHYOUJI  = "zrngaikanykntkarihyouji";
    public static final String ZRNKIHONSGAIKA           = "zrnkihonsgaika";
    public static final String ZRNTEKIYOUKAWASERATE     = "zrntekiyoukawaserate";
    public static final String ZRNKAWASERATETEKIYOUYMD  = "zrnkawaseratetekiyouymd";
    public static final String ZRNMKHYOUTIYENSYSNIKOUKBN = "zrnmkhyoutiyensysnikoukbn";
    public static final String ZRNSYKSBYENSITIHSYUTKYKHYJ = "zrnsyksbyensitihsyutkykhyj";
    public static final String ZRNJYUDKAIGOMEHRTKARIHYJ = "zrnjyudkaigomehrtkarihyj";
    public static final String ZRNSYKIHRKPSITEITUUKA    = "zrnsykihrkpsiteituuka";
    public static final String ZRNTEIRITUHAIBUNWARI     = "zrnteirituhaibunwari";
    public static final String ZRNSUEOKIKKNKBN          = "zrnsueokikknkbn";
    public static final String ZRNNKSYURUIKBN1          = "zrnnksyuruikbn1";
    public static final String ZRNDAIRITENKBTINFO1      = "zrndairitenkbtinfo1";
    public static final String ZRNDAIRITENKBTINFO2      = "zrndairitenkbtinfo2";
    public static final String ZRNDAIRITENKBTINFO3      = "zrndairitenkbtinfo3";
    public static final String ZRNYOHURIMIRYOU          = "zrnyohurimiryou";
    public static final String ZRNKZNYUURYOKUYMD        = "zrnkznyuuryokuymd";
    public static final String ZRNSETAITEMOSNO          = "zrnsetaitemosno";
    public static final String ZRNYAKKANJYURYOUHOUKBN   = "zrnyakkanjyuryouhoukbn";
    public static final String ZRNYAKKANBUNSYONO        = "zrnyakkanbunsyono";
    public static final String ZRNKZHURITOUROKUHOUKBN   = "zrnkzhuritourokuhoukbn";
    public static final String ZRNDAI1HKNKKN            = "zrndai1hknkkn";
    public static final String ZRNCREDITNYUURYOKUYMD    = "zrncreditnyuuryokuymd";
    public static final String ZRNCREDITMIRYOU          = "zrncreditmiryou";
    public static final String ZRNCREDITTRKHOUKBN       = "zrncredittrkhoukbn";
    public static final String ZRNCARDBRANDKBN          = "zrncardbrandkbn";
    public static final String ZRNCARDDATASOUSINYMD     = "zrncarddatasousinymd";
    public static final String ZRNKYKDRTKYKARIHYJ       = "zrnkykdrtkykarihyj";
    public static final String ZRNKZKTRKSERVICEKBN      = "zrnkzktrkservicekbn";
    public static final String ZRNTEIKISIHARAIARIHYJ    = "zrnteikisiharaiarihyj";
    public static final String ZRNTEIKISHRKINSHRTUUKAKBN = "zrnteikishrkinshrtuukakbn";
    public static final String ZRNTEIKISIHARAIKIN       = "zrnteikisiharaikin";
    public static final String ZRNKOUREIKZKSETUMEIHOUKBN = "zrnkoureikzksetumeihoukbn";
    public static final String ZRNKOUREIMNDNHUKUSUUKAIKBN = "zrnkoureimndnhukusuukaikbn";
    public static final String ZRNKOUREITRATKISYAIGIDSKKBN = "zrnkoureitratkisyaigidskkbn";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNNNKNSNPSSYSYUP        = "zrnnnknsnpssysyup";
    public static final String ZRNNNKNSNPSSYKWSRATE     = "zrnnnknsnpssykwsrate";
    public static final String ZRNZENNOUP               = "zrnzennoup";
    public static final String ZRNNENKINZEISEITOKUYAKUKBN = "zrnnenkinzeiseitokuyakukbn";
    public static final String ZRNYOBIV33               = "zrnyobiv33";

    private final PKZT_DrtenIpToukeiRn primaryKey;

    public GenZT_DrtenIpToukeiRn() {
        primaryKey = new PKZT_DrtenIpToukeiRn();
    }

    public GenZT_DrtenIpToukeiRn(
        String pZrneigyouhonbusisyacd,
        String pZrnsosikicd,
        String pZrnatukaikojincd,
        String pZrnmosym,
        String pZrnmosno
    ) {
        primaryKey = new PKZT_DrtenIpToukeiRn(
            pZrneigyouhonbusisyacd,
            pZrnsosikicd,
            pZrnatukaikojincd,
            pZrnmosym,
            pZrnmosno
        );
    }

    @Transient
    @Override
    public PKZT_DrtenIpToukeiRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_DrtenIpToukeiRn> getMetaClass() {
        return QZT_DrtenIpToukeiRn.class;
    }

    @Id
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNEIGYOUHONBUSISYACD)
    public String getZrneigyouhonbusisyacd() {
        return getPrimaryKey().getZrneigyouhonbusisyacd();
    }

    public void setZrneigyouhonbusisyacd(String pZrneigyouhonbusisyacd) {
        getPrimaryKey().setZrneigyouhonbusisyacd(pZrneigyouhonbusisyacd);
    }

    @Id
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSOSIKICD)
    public String getZrnsosikicd() {
        return getPrimaryKey().getZrnsosikicd();
    }

    public void setZrnsosikicd(String pZrnsosikicd) {
        getPrimaryKey().setZrnsosikicd(pZrnsosikicd);
    }

    @Id
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNATUKAIKOJINCD)
    public String getZrnatukaikojincd() {
        return getPrimaryKey().getZrnatukaikojincd();
    }

    public void setZrnatukaikojincd(String pZrnatukaikojincd) {
        getPrimaryKey().setZrnatukaikojincd(pZrnatukaikojincd);
    }

    @Id
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNMOSYM)
    public String getZrnmosym() {
        return getPrimaryKey().getZrnmosym();
    }

    public void setZrnmosym(String pZrnmosym) {
        getPrimaryKey().setZrnmosym(pZrnmosym);
    }

    private String zrnmoskbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNMOSKBN)
    public String getZrnmoskbn() {
        return zrnmoskbn;
    }

    public void setZrnmoskbn(String pZrnmoskbn) {
        zrnmoskbn = pZrnmoskbn;
    }

    private String zrntansyukukjatukaisyanm;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTANSYUKUKJATUKAISYANM)
    public String getZrntansyukukjatukaisyanm() {
        return zrntansyukukjatukaisyanm;
    }

    @DataConvert("toMultiByte")
    public void setZrntansyukukjatukaisyanm(String pZrntansyukukjatukaisyanm) {
        zrntansyukukjatukaisyanm = pZrntansyukukjatukaisyanm;
    }

    @Id
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNMOSNO)
    public String getZrnmosno() {
        return getPrimaryKey().getZrnmosno();
    }

    public void setZrnmosno(String pZrnmosno) {
        getPrimaryKey().setZrnmosno(pZrnmosno);
    }

    private String zrnmossyoumetukbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNMOSSYOUMETUKBN)
    public String getZrnmossyoumetukbn() {
        return zrnmossyoumetukbn;
    }

    public void setZrnmossyoumetukbn(String pZrnmossyoumetukbn) {
        zrnmossyoumetukbn = pZrnmossyoumetukbn;
    }

    private String zrnkurikosiriyuukbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKURIKOSIRIYUUKBN)
    public String getZrnkurikosiriyuukbn() {
        return zrnkurikosiriyuukbn;
    }

    public void setZrnkurikosiriyuukbn(String pZrnkurikosiriyuukbn) {
        zrnkurikosiriyuukbn = pZrnkurikosiriyuukbn;
    }

    private String zrnnyknzumihyouji;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNNYKNZUMIHYOUJI)
    public String getZrnnyknzumihyouji() {
        return zrnnyknzumihyouji;
    }

    public void setZrnnyknzumihyouji(String pZrnnyknzumihyouji) {
        zrnnyknzumihyouji = pZrnnyknzumihyouji;
    }

    private String zrntoukeihknsyruikbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTOUKEIHKNSYRUIKBN)
    public String getZrntoukeihknsyruikbn() {
        return zrntoukeihknsyruikbn;
    }

    public void setZrntoukeihknsyruikbn(String pZrntoukeihknsyruikbn) {
        zrntoukeihknsyruikbn = pZrntoukeihknsyruikbn;
    }

    private String zrnhjykktkbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHJYKKTKBN)
    public String getZrnhjykktkbn() {
        return zrnhjykktkbn;
    }

    public void setZrnhjykktkbn(String pZrnhjykktkbn) {
        zrnhjykktkbn = pZrnhjykktkbn;
    }

    private String zrnkykktaikbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKYKKTAIKBN)
    public String getZrnkykktaikbn() {
        return zrnkykktaikbn;
    }

    public void setZrnkykktaikbn(String pZrnkykktaikbn) {
        zrnkykktaikbn = pZrnkykktaikbn;
    }

    private Long zrnjyunhsys;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNJYUNHSYS)
    public Long getZrnjyunhsys() {
        return zrnjyunhsys;
    }

    public void setZrnjyunhsys(Long pZrnjyunhsys) {
        zrnjyunhsys = pZrnjyunhsys;
    }

    private Long zrnhsys;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHSYS)
    public Long getZrnhsys() {
        return zrnhsys;
    }

    public void setZrnhsys(Long pZrnhsys) {
        zrnhsys = pZrnhsys;
    }

    private Integer zrnsoukensuu;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSOUKENSUU)
    public Integer getZrnsoukensuu() {
        return zrnsoukensuu;
    }

    public void setZrnsoukensuu(Integer pZrnsoukensuu) {
        zrnsoukensuu = pZrnsoukensuu;
    }

    private String zrnketjkkbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKETJKKBN)
    public String getZrnketjkkbn() {
        return zrnketjkkbn;
    }

    public void setZrnketjkkbn(String pZrnketjkkbn) {
        zrnketjkkbn = pZrnketjkkbn;
    }

    private String zrndakuhiktjyoutaikbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDAKUHIKTJYOUTAIKBN)
    public String getZrndakuhiktjyoutaikbn() {
        return zrndakuhiktjyoutaikbn;
    }

    public void setZrndakuhiktjyoutaikbn(String pZrndakuhiktjyoutaikbn) {
        zrndakuhiktjyoutaikbn = pZrndakuhiktjyoutaikbn;
    }

    private String zrnkihonhubi;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKIHONHUBI)
    public String getZrnkihonhubi() {
        return zrnkihonhubi;
    }

    public void setZrnkihonhubi(String pZrnkihonhubi) {
        zrnkihonhubi = pZrnkihonhubi;
    }

    private String zrnsphubi;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSPHUBI)
    public String getZrnsphubi() {
        return zrnsphubi;
    }

    public void setZrnsphubi(String pZrnsphubi) {
        zrnsphubi = pZrnsphubi;
    }

    private String zrnsseigenhubi;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSSEIGENHUBI)
    public String getZrnsseigenhubi() {
        return zrnsseigenhubi;
    }

    public void setZrnsseigenhubi(String pZrnsseigenhubi) {
        zrnsseigenhubi = pZrnsseigenhubi;
    }

    private String zrnnayosehumei;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNNAYOSEHUMEI)
    public String getZrnnayosehumei() {
        return zrnnayosehumei;
    }

    public void setZrnnayosehumei(String pZrnnayosehumei) {
        zrnnayosehumei = pZrnnayosehumei;
    }

    private String zrntuusangendoover;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTUUSANGENDOOVER)
    public String getZrntuusangendoover() {
        return zrntuusangendoover;
    }

    public void setZrntuusangendoover(String pZrntuusangendoover) {
        zrntuusangendoover = pZrntuusangendoover;
    }

    private String zrnmosketteihoryuu;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNMOSKETTEIHORYUU)
    public String getZrnmosketteihoryuu() {
        return zrnmosketteihoryuu;
    }

    public void setZrnmosketteihoryuu(String pZrnmosketteihoryuu) {
        zrnmosketteihoryuu = pZrnmosketteihoryuu;
    }

    private String zrnkykkakjissityuu;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKYKKAKJISSITYUU)
    public String getZrnkykkakjissityuu() {
        return zrnkykkakjissityuu;
    }

    public void setZrnkykkakjissityuu(String pZrnkykkakjissityuu) {
        zrnkykkakjissityuu = pZrnkykkakjissityuu;
    }

    private String zrnkktketteihoryuu;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKKTKETTEIHORYUU)
    public String getZrnkktketteihoryuu() {
        return zrnkktketteihoryuu;
    }

    public void setZrnkktketteihoryuu(String pZrnkktketteihoryuu) {
        zrnkktketteihoryuu = pZrnkktketteihoryuu;
    }

    private String zrnhonsyakethoryuu;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHONSYAKETHORYUU)
    public String getZrnhonsyakethoryuu() {
        return zrnhonsyakethoryuu;
    }

    public void setZrnhonsyakethoryuu(String pZrnhonsyakethoryuu) {
        zrnhonsyakethoryuu = pZrnhonsyakethoryuu;
    }

    private String zrnseiymdhubi;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSEIYMDHUBI)
    public String getZrnseiymdhubi() {
        return zrnseiymdhubi;
    }

    public void setZrnseiymdhubi(String pZrnseiymdhubi) {
        zrnseiymdhubi = pZrnseiymdhubi;
    }

    private String zrnphusoku;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNPHUSOKU)
    public String getZrnphusoku() {
        return zrnphusoku;
    }

    public void setZrnphusoku(String pZrnphusoku) {
        zrnphusoku = pZrnphusoku;
    }

    private String zrnsrhuketyu;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSRHUKETYU)
    public String getZrnsrhuketyu() {
        return zrnsrhuketyu;
    }

    public void setZrnsrhuketyu(String pZrnsrhuketyu) {
        zrnsrhuketyu = pZrnsrhuketyu;
    }

    private String zrnpkakin;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNPKAKIN)
    public String getZrnpkakin() {
        return zrnpkakin;
    }

    public void setZrnpkakin(String pZrnpkakin) {
        zrnpkakin = pZrnpkakin;
    }

    private String zrnbsudirtnatkikeitaikbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNBSUDIRTNATKIKEITAIKBN)
    public String getZrnbsudirtnatkikeitaikbn() {
        return zrnbsudirtnatkikeitaikbn;
    }

    public void setZrnbsudirtnatkikeitaikbn(String pZrnbsudirtnatkikeitaikbn) {
        zrnbsudirtnatkikeitaikbn = pZrnbsudirtnatkikeitaikbn;
    }

    private String zrnsakuseiymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSAKUSEIYMD)
    public String getZrnsakuseiymd() {
        return zrnsakuseiymd;
    }

    public void setZrnsakuseiymd(String pZrnsakuseiymd) {
        zrnsakuseiymd = pZrnsakuseiymd;
    }

    private String zrnkydatkikbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKYDATKIKBN)
    public String getZrnkydatkikbn() {
        return zrnkydatkikbn;
    }

    public void setZrnkydatkikbn(String pZrnkydatkikbn) {
        zrnkydatkikbn = pZrnkydatkikbn;
    }

    private String zrntansyukukjhhknnm;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTANSYUKUKJHHKNNM)
    public String getZrntansyukukjhhknnm() {
        return zrntansyukukjhhknnm;
    }

    @DataConvert("toMultiByte")
    public void setZrntansyukukjhhknnm(String pZrntansyukukjhhknnm) {
        zrntansyukukjhhknnm = pZrntansyukukjhhknnm;
    }

    private String zrnhhknsykgycd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHHKNSYKGYCD)
    public String getZrnhhknsykgycd() {
        return zrnhhknsykgycd;
    }

    public void setZrnhhknsykgycd(String pZrnhhknsykgycd) {
        zrnhhknsykgycd = pZrnhhknsykgycd;
    }

    private String zrnhhknnen2keta;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHHKNNEN2KETA)
    public String getZrnhhknnen2keta() {
        return zrnhhknnen2keta;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknnen2keta(String pZrnhhknnen2keta) {
        zrnhhknnen2keta = pZrnhhknnen2keta;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnmusymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNMUSYMD)
    public String getZrnmusymd() {
        return zrnmusymd;
    }

    public void setZrnmusymd(String pZrnmusymd) {
        zrnmusymd = pZrnmusymd;
    }

    private String zrnsyokaipryosyuymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSYOKAIPRYOSYUYMD)
    public String getZrnsyokaipryosyuymd() {
        return zrnsyokaipryosyuymd;
    }

    public void setZrnsyokaipryosyuymd(String pZrnsyokaipryosyuymd) {
        zrnsyokaipryosyuymd = pZrnsyokaipryosyuymd;
    }

    private String zrnkokutiymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKOKUTIYMD)
    public String getZrnkokutiymd() {
        return zrnkokutiymd;
    }

    public void setZrnkokutiymd(String pZrnkokutiymd) {
        zrnkokutiymd = pZrnkokutiymd;
    }

    private String zrnmosnyuuryokuymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNMOSNYUURYOKUYMD)
    public String getZrnmosnyuuryokuymd() {
        return zrnmosnyuuryokuymd;
    }

    public void setZrnmosnyuuryokuymd(String pZrnmosnyuuryokuymd) {
        zrnmosnyuuryokuymd = pZrnmosnyuuryokuymd;
    }

    private String zrnkykymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnsekininkaisiymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSEKININKAISIYMD)
    public String getZrnsekininkaisiymd() {
        return zrnsekininkaisiymd;
    }

    public void setZrnsekininkaisiymd(String pZrnsekininkaisiymd) {
        zrnsekininkaisiymd = pZrnsekininkaisiymd;
    }

    private String zrnfstpnyknsyoriymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNFSTPNYKNSYORIYMD)
    public String getZrnfstpnyknsyoriymd() {
        return zrnfstpnyknsyoriymd;
    }

    public void setZrnfstpnyknsyoriymd(String pZrnfstpnyknsyoriymd) {
        zrnfstpnyknsyoriymd = pZrnfstpnyknsyoriymd;
    }

    private String zrnfstpnyknnaiyoukbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNFSTPNYKNNAIYOUKBN)
    public String getZrnfstpnyknnaiyoukbn() {
        return zrnfstpnyknnaiyoukbn;
    }

    public void setZrnfstpnyknnaiyoukbn(String pZrnfstpnyknnaiyoukbn) {
        zrnfstpnyknnaiyoukbn = pZrnfstpnyknnaiyoukbn;
    }

    private String zrnsisyaketsyoriymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSISYAKETSYORIYMD)
    public String getZrnsisyaketsyoriymd() {
        return zrnsisyaketsyoriymd;
    }

    public void setZrnsisyaketsyoriymd(String pZrnsisyaketsyoriymd) {
        zrnsisyaketsyoriymd = pZrnsisyaketsyoriymd;
    }

    private String zrnsyosakuseiymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSYOSAKUSEIYMD)
    public String getZrnsyosakuseiymd() {
        return zrnsyosakuseiymd;
    }

    public void setZrnsyosakuseiymd(String pZrnsyosakuseiymd) {
        zrnsyosakuseiymd = pZrnsyosakuseiymd;
    }

    private String zrnseisekiym;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSEISEKIYM)
    public String getZrnseisekiym() {
        return zrnseisekiym;
    }

    public void setZrnseisekiym(String pZrnseisekiym) {
        zrnseisekiym = pZrnseisekiym;
    }

    private Long zrnsyokaiharaikomip;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSYOKAIHARAIKOMIP)
    public Long getZrnsyokaiharaikomip() {
        return zrnsyokaiharaikomip;
    }

    public void setZrnsyokaiharaikomip(Long pZrnsyokaiharaikomip) {
        zrnsyokaiharaikomip = pZrnsyokaiharaikomip;
    }

    private String zrnsyono;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrntokusyujimutoriatukaikbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTOKUSYUJIMUTORIATUKAIKBN)
    public String getZrntokusyujimutoriatukaikbn() {
        return zrntokusyujimutoriatukaikbn;
    }

    public void setZrntokusyujimutoriatukaikbn(String pZrntokusyujimutoriatukaikbn) {
        zrntokusyujimutoriatukaikbn = pZrntokusyujimutoriatukaikbn;
    }

    private String zrnbsydrtencd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNBSYDRTENCD)
    public String getZrnbsydrtencd() {
        return zrnbsydrtencd;
    }

    public void setZrnbsydrtencd(String pZrnbsydrtencd) {
        zrnbsydrtencd = pZrnbsydrtencd;
    }

    private String zrnbsydrtenkjnm;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNBSYDRTENKJNM)
    public String getZrnbsydrtenkjnm() {
        return zrnbsydrtenkjnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnbsydrtenkjnm(String pZrnbsydrtenkjnm) {
        zrnbsydrtenkjnm = pZrnbsydrtenkjnm;
    }

    private String zrnatkisyagyskkjsosikicd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNATKISYAGYSKKJSOSIKICD)
    public String getZrnatkisyagyskkjsosikicd() {
        return zrnatkisyagyskkjsosikicd;
    }

    public void setZrnatkisyagyskkjsosikicd(String pZrnatkisyagyskkjsosikicd) {
        zrnatkisyagyskkjsosikicd = pZrnatkisyagyskkjsosikicd;
    }

    private Integer zrnatkisyadrtenatkiwari;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNATKISYADRTENATKIWARI)
    public Integer getZrnatkisyadrtenatkiwari() {
        return zrnatkisyadrtenatkiwari;
    }

    public void setZrnatkisyadrtenatkiwari(Integer pZrnatkisyadrtenatkiwari) {
        zrnatkisyadrtenatkiwari = pZrnatkisyadrtenatkiwari;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnkinyuukikancd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKINYUUKIKANCD)
    public String getZrnkinyuukikancd() {
        return zrnkinyuukikancd;
    }

    public void setZrnkinyuukikancd(String pZrnkinyuukikancd) {
        zrnkinyuukikancd = pZrnkinyuukikancd;
    }

    private String zrninfositencd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNINFOSITENCD)
    public String getZrninfositencd() {
        return zrninfositencd;
    }

    public void setZrninfositencd(String pZrninfositencd) {
        zrninfositencd = pZrninfositencd;
    }

    private String zrncifcd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNCIFCD)
    public String getZrncifcd() {
        return zrncifcd;
    }

    public void setZrncifcd(String pZrncifcd) {
        zrncifcd = pZrncifcd;
    }

    private String zrnkjkyknm10;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKJKYKNM10)
    public String getZrnkjkyknm10() {
        return zrnkjkyknm10;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkyknm10(String pZrnkjkyknm10) {
        zrnkjkyknm10 = pZrnkjkyknm10;
    }

    private String zrnkthhbhyouji;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKTHHBHYOUJI)
    public String getZrnkthhbhyouji() {
        return zrnkthhbhyouji;
    }

    public void setZrnkthhbhyouji(String pZrnkthhbhyouji) {
        zrnkthhbhyouji = pZrnkthhbhyouji;
    }

    private String zrnsrhhbhyouji;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSRHHBHYOUJI)
    public String getZrnsrhhbhyouji() {
        return zrnsrhhbhyouji;
    }

    public void setZrnsrhhbhyouji(String pZrnsrhhbhyouji) {
        zrnsrhhbhyouji = pZrnsrhhbhyouji;
    }

    private String zrnmossyumtkktymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNMOSSYUMTKKTYMD)
    public String getZrnmossyumtkktymd() {
        return zrnmossyumtkktymd;
    }

    public void setZrnmossyumtkktymd(String pZrnmossyumtkktymd) {
        zrnmossyumtkktymd = pZrnmossyumtkktymd;
    }

    private String zrndairitenjimusyocd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDAIRITENJIMUSYOCD)
    public String getZrndairitenjimusyocd() {
        return zrndairitenjimusyocd;
    }

    public void setZrndairitenjimusyocd(String pZrndairitenjimusyocd) {
        zrndairitenjimusyocd = pZrndairitenjimusyocd;
    }

    private Long zrntsrybnwari;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTSRYBNWARI)
    public Long getZrntsrybnwari() {
        return zrntsrybnwari;
    }

    public void setZrntsrybnwari(Long pZrntsrybnwari) {
        zrntsrybnwari = pZrntsrybnwari;
    }

    private String zrndrtenkeijyouym;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDRTENKEIJYOUYM)
    public String getZrndrtenkeijyouym() {
        return zrndrtenkeijyouym;
    }

    public void setZrndrtenkeijyouym(String pZrndrtenkeijyouym) {
        zrndrtenkeijyouym = pZrndrtenkeijyouym;
    }

    private String zrnkydatkidairitencd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKYDATKIDAIRITENCD)
    public String getZrnkydatkidairitencd() {
        return zrnkydatkidairitencd;
    }

    public void setZrnkydatkidairitencd(String pZrnkydatkidairitencd) {
        zrnkydatkidairitencd = pZrnkydatkidairitencd;
    }

    private String zrndaihyoubosyuunincd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDAIHYOUBOSYUUNINCD)
    public String getZrndaihyoubosyuunincd() {
        return zrndaihyoubosyuunincd;
    }

    public void setZrndaihyoubosyuunincd(String pZrndaihyoubosyuunincd) {
        zrndaihyoubosyuunincd = pZrndaihyoubosyuunincd;
    }

    private String zrntansyukukjdhybosyuunm;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTANSYUKUKJDHYBOSYUUNM)
    public String getZrntansyukukjdhybosyuunm() {
        return zrntansyukukjdhybosyuunm;
    }

    @DataConvert("toMultiByte")
    public void setZrntansyukukjdhybosyuunm(String pZrntansyukukjdhybosyuunm) {
        zrntansyukukjdhybosyuunm = pZrntansyukukjdhybosyuunm;
    }

    private String zrnknkyknm15;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKNKYKNM15)
    public String getZrnknkyknm15() {
        return zrnknkyknm15;
    }

    public void setZrnknkyknm15(String pZrnknkyknm15) {
        zrnknkyknm15 = pZrnknkyknm15;
    }

    private String zrndakuhikettikekkacd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDAKUHIKETTIKEKKACD)
    public String getZrndakuhikettikekkacd() {
        return zrndakuhikettikekkacd;
    }

    public void setZrndakuhikettikekkacd(String pZrndakuhikettikekkacd) {
        zrndakuhikettikekkacd = pZrndakuhikettikekkacd;
    }

    private String zrndkhktiymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDKHKTIYMD)
    public String getZrndkhktiymd() {
        return zrndkhktiymd;
    }

    public void setZrndkhktiymd(String pZrndkhktiymd) {
        zrndkhktiymd = pZrndkhktiymd;
    }

    private String zrntoukeiyousinsakbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTOUKEIYOUSINSAKBN)
    public String getZrntoukeiyousinsakbn() {
        return zrntoukeiyousinsakbn;
    }

    public void setZrntoukeiyousinsakbn(String pZrntoukeiyousinsakbn) {
        zrntoukeiyousinsakbn = pZrntoukeiyousinsakbn;
    }

    private String zrnhonninkknnkbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHONNINKKNNKBN)
    public String getZrnhonninkknnkbn() {
        return zrnhonninkknnkbn;
    }

    public void setZrnhonninkknnkbn(String pZrnhonninkknnkbn) {
        zrnhonninkknnkbn = pZrnhonninkknnkbn;
    }

    private String zrnnstkarihyj;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNNSTKARIHYJ)
    public String getZrnnstkarihyj() {
        return zrnnstkarihyj;
    }

    public void setZrnnstkarihyj(String pZrnnstkarihyj) {
        zrnnstkarihyj = pZrnnstkarihyj;
    }

    private String zrnnstknkkkn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNNSTKNKKKN)
    public String getZrnnstknkkkn() {
        return zrnnstknkkkn;
    }

    public void setZrnnstknkkkn(String pZrnnstknkkkn) {
        zrnnstknkkkn = pZrnnstknkkkn;
    }

    private String zrndrtentsryhushrkykhyouji;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDRTENTSRYHUSHRKYKHYOUJI)
    public String getZrndrtentsryhushrkykhyouji() {
        return zrndrtentsryhushrkykhyouji;
    }

    public void setZrndrtentsryhushrkykhyouji(String pZrndrtentsryhushrkykhyouji) {
        zrndrtentsryhushrkykhyouji = pZrndrtentsryhushrkykhyouji;
    }

    private String zrnnyknkanskanouhyouji;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNNYKNKANSKANOUHYOUJI)
    public String getZrnnyknkanskanouhyouji() {
        return zrnnyknkanskanouhyouji;
    }

    public void setZrnnyknkanskanouhyouji(String pZrnnyknkanskanouhyouji) {
        zrnnyknkanskanouhyouji = pZrnnyknkanskanouhyouji;
    }

    private String zrndshukahyouji;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDSHUKAHYOUJI)
    public String getZrndshukahyouji() {
        return zrndshukahyouji;
    }

    public void setZrndshukahyouji(String pZrndshukahyouji) {
        zrndshukahyouji = pZrndshukahyouji;
    }

    private String zrnstdairiseikyuutkykarihyj;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZrnstdairiseikyuutkykarihyj() {
        return zrnstdairiseikyuutkykarihyj;
    }

    public void setZrnstdairiseikyuutkykarihyj(String pZrnstdairiseikyuutkykarihyj) {
        zrnstdairiseikyuutkykarihyj = pZrnstdairiseikyuutkykarihyj;
    }

    private String zrnkyksyanen;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKYKSYANEN)
    public String getZrnkyksyanen() {
        return zrnkyksyanen;
    }

    public void setZrnkyksyanen(String pZrnkyksyanen) {
        zrnkyksyanen = pZrnkyksyanen;
    }

    private String zrnkyksyaseikbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKYKSYASEIKBN)
    public String getZrnkyksyaseikbn() {
        return zrnkyksyaseikbn;
    }

    public void setZrnkyksyaseikbn(String pZrnkyksyaseikbn) {
        zrnkyksyaseikbn = pZrnkyksyaseikbn;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrndrtenpaperlessmoshyj;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDRTENPAPERLESSMOSHYJ)
    public String getZrndrtenpaperlessmoshyj() {
        return zrndrtenpaperlessmoshyj;
    }

    public void setZrndrtenpaperlessmoshyj(String pZrndrtenpaperlessmoshyj) {
        zrndrtenpaperlessmoshyj = pZrndrtenpaperlessmoshyj;
    }

    private String zrndrtenmostousyaukeymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDRTENMOSTOUSYAUKEYMD)
    public String getZrndrtenmostousyaukeymd() {
        return zrndrtenmostousyaukeymd;
    }

    public void setZrndrtenmostousyaukeymd(String pZrndrtenmostousyaukeymd) {
        zrndrtenmostousyaukeymd = pZrndrtenmostousyaukeymd;
    }

    private String zrnkyktuuka;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKYKTUUKA)
    public String getZrnkyktuuka() {
        return zrnkyktuuka;
    }

    public void setZrnkyktuuka(String pZrnkyktuuka) {
        zrnkyktuuka = pZrnkyktuuka;
    }

    private String zrnhrktuuka;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHRKTUUKA)
    public String getZrnhrktuuka() {
        return zrnhrktuuka;
    }

    public void setZrnhrktuuka(String pZrnhrktuuka) {
        zrnhrktuuka = pZrnhrktuuka;
    }

    private BizNumber zrnsykihrkpgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSYKIHRKPGAIKA)
    public BizNumber getZrnsykihrkpgaika() {
        return zrnsykihrkpgaika;
    }

    public void setZrnsykihrkpgaika(BizNumber pZrnsykihrkpgaika) {
        zrnsykihrkpgaika = pZrnsykihrkpgaika;
    }

    private String zrnyennykntkarihyouji;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNYENNYKNTKARIHYOUJI)
    public String getZrnyennykntkarihyouji() {
        return zrnyennykntkarihyouji;
    }

    public void setZrnyennykntkarihyouji(String pZrnyennykntkarihyouji) {
        zrnyennykntkarihyouji = pZrnyennykntkarihyouji;
    }

    private String zrngaikanykntkarihyouji;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNGAIKANYKNTKARIHYOUJI)
    public String getZrngaikanykntkarihyouji() {
        return zrngaikanykntkarihyouji;
    }

    public void setZrngaikanykntkarihyouji(String pZrngaikanykntkarihyouji) {
        zrngaikanykntkarihyouji = pZrngaikanykntkarihyouji;
    }

    private BizNumber zrnkihonsgaika;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKIHONSGAIKA)
    public BizNumber getZrnkihonsgaika() {
        return zrnkihonsgaika;
    }

    public void setZrnkihonsgaika(BizNumber pZrnkihonsgaika) {
        zrnkihonsgaika = pZrnkihonsgaika;
    }

    private BizNumber zrntekiyoukawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTEKIYOUKAWASERATE)
    public BizNumber getZrntekiyoukawaserate() {
        return zrntekiyoukawaserate;
    }

    public void setZrntekiyoukawaserate(BizNumber pZrntekiyoukawaserate) {
        zrntekiyoukawaserate = pZrntekiyoukawaserate;
    }

    private String zrnkawaseratetekiyouymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKAWASERATETEKIYOUYMD)
    public String getZrnkawaseratetekiyouymd() {
        return zrnkawaseratetekiyouymd;
    }

    public void setZrnkawaseratetekiyouymd(String pZrnkawaseratetekiyouymd) {
        zrnkawaseratetekiyouymd = pZrnkawaseratetekiyouymd;
    }

    private String zrnmkhyoutiyensysnikoukbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNMKHYOUTIYENSYSNIKOUKBN)
    public String getZrnmkhyoutiyensysnikoukbn() {
        return zrnmkhyoutiyensysnikoukbn;
    }

    public void setZrnmkhyoutiyensysnikoukbn(String pZrnmkhyoutiyensysnikoukbn) {
        zrnmkhyoutiyensysnikoukbn = pZrnmkhyoutiyensysnikoukbn;
    }

    private String zrnsyksbyensitihsyutkykhyj;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSYKSBYENSITIHSYUTKYKHYJ)
    public String getZrnsyksbyensitihsyutkykhyj() {
        return zrnsyksbyensitihsyutkykhyj;
    }

    public void setZrnsyksbyensitihsyutkykhyj(String pZrnsyksbyensitihsyutkykhyj) {
        zrnsyksbyensitihsyutkykhyj = pZrnsyksbyensitihsyutkykhyj;
    }

    private String zrnjyudkaigomehrtkarihyj;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNJYUDKAIGOMEHRTKARIHYJ)
    public String getZrnjyudkaigomehrtkarihyj() {
        return zrnjyudkaigomehrtkarihyj;
    }

    public void setZrnjyudkaigomehrtkarihyj(String pZrnjyudkaigomehrtkarihyj) {
        zrnjyudkaigomehrtkarihyj = pZrnjyudkaigomehrtkarihyj;
    }

    private BizNumber zrnsykihrkpsiteituuka;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSYKIHRKPSITEITUUKA)
    public BizNumber getZrnsykihrkpsiteituuka() {
        return zrnsykihrkpsiteituuka;
    }

    public void setZrnsykihrkpsiteituuka(BizNumber pZrnsykihrkpsiteituuka) {
        zrnsykihrkpsiteituuka = pZrnsykihrkpsiteituuka;
    }

    private String zrnteirituhaibunwari;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTEIRITUHAIBUNWARI)
    public String getZrnteirituhaibunwari() {
        return zrnteirituhaibunwari;
    }

    public void setZrnteirituhaibunwari(String pZrnteirituhaibunwari) {
        zrnteirituhaibunwari = pZrnteirituhaibunwari;
    }

    private String zrnsueokikknkbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSUEOKIKKNKBN)
    public String getZrnsueokikknkbn() {
        return zrnsueokikknkbn;
    }

    public void setZrnsueokikknkbn(String pZrnsueokikknkbn) {
        zrnsueokikknkbn = pZrnsueokikknkbn;
    }

    private String zrnnksyuruikbn1;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNNKSYURUIKBN1)
    public String getZrnnksyuruikbn1() {
        return zrnnksyuruikbn1;
    }

    public void setZrnnksyuruikbn1(String pZrnnksyuruikbn1) {
        zrnnksyuruikbn1 = pZrnnksyuruikbn1;
    }

    private String zrndairitenkbtinfo1;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDAIRITENKBTINFO1)
    public String getZrndairitenkbtinfo1() {
        return zrndairitenkbtinfo1;
    }

    public void setZrndairitenkbtinfo1(String pZrndairitenkbtinfo1) {
        zrndairitenkbtinfo1 = pZrndairitenkbtinfo1;
    }

    private String zrndairitenkbtinfo2;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDAIRITENKBTINFO2)
    public String getZrndairitenkbtinfo2() {
        return zrndairitenkbtinfo2;
    }

    public void setZrndairitenkbtinfo2(String pZrndairitenkbtinfo2) {
        zrndairitenkbtinfo2 = pZrndairitenkbtinfo2;
    }

    private String zrndairitenkbtinfo3;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDAIRITENKBTINFO3)
    public String getZrndairitenkbtinfo3() {
        return zrndairitenkbtinfo3;
    }

    public void setZrndairitenkbtinfo3(String pZrndairitenkbtinfo3) {
        zrndairitenkbtinfo3 = pZrndairitenkbtinfo3;
    }

    private String zrnyohurimiryou;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNYOHURIMIRYOU)
    public String getZrnyohurimiryou() {
        return zrnyohurimiryou;
    }

    public void setZrnyohurimiryou(String pZrnyohurimiryou) {
        zrnyohurimiryou = pZrnyohurimiryou;
    }

    private String zrnkznyuuryokuymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKZNYUURYOKUYMD)
    public String getZrnkznyuuryokuymd() {
        return zrnkznyuuryokuymd;
    }

    public void setZrnkznyuuryokuymd(String pZrnkznyuuryokuymd) {
        zrnkznyuuryokuymd = pZrnkznyuuryokuymd;
    }

    private String zrnsetaitemosno;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSETAITEMOSNO)
    public String getZrnsetaitemosno() {
        return zrnsetaitemosno;
    }

    public void setZrnsetaitemosno(String pZrnsetaitemosno) {
        zrnsetaitemosno = pZrnsetaitemosno;
    }

    private String zrnyakkanjyuryouhoukbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNYAKKANJYURYOUHOUKBN)
    public String getZrnyakkanjyuryouhoukbn() {
        return zrnyakkanjyuryouhoukbn;
    }

    public void setZrnyakkanjyuryouhoukbn(String pZrnyakkanjyuryouhoukbn) {
        zrnyakkanjyuryouhoukbn = pZrnyakkanjyuryouhoukbn;
    }

    private String zrnyakkanbunsyono;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNYAKKANBUNSYONO)
    public String getZrnyakkanbunsyono() {
        return zrnyakkanbunsyono;
    }

    public void setZrnyakkanbunsyono(String pZrnyakkanbunsyono) {
        zrnyakkanbunsyono = pZrnyakkanbunsyono;
    }

    private String zrnkzhuritourokuhoukbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKZHURITOUROKUHOUKBN)
    public String getZrnkzhuritourokuhoukbn() {
        return zrnkzhuritourokuhoukbn;
    }

    public void setZrnkzhuritourokuhoukbn(String pZrnkzhuritourokuhoukbn) {
        zrnkzhuritourokuhoukbn = pZrnkzhuritourokuhoukbn;
    }

    private String zrndai1hknkkn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNDAI1HKNKKN)
    public String getZrndai1hknkkn() {
        return zrndai1hknkkn;
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        zrndai1hknkkn = pZrndai1hknkkn;
    }

    private String zrncreditnyuuryokuymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNCREDITNYUURYOKUYMD)
    public String getZrncreditnyuuryokuymd() {
        return zrncreditnyuuryokuymd;
    }

    public void setZrncreditnyuuryokuymd(String pZrncreditnyuuryokuymd) {
        zrncreditnyuuryokuymd = pZrncreditnyuuryokuymd;
    }

    private String zrncreditmiryou;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNCREDITMIRYOU)
    public String getZrncreditmiryou() {
        return zrncreditmiryou;
    }

    public void setZrncreditmiryou(String pZrncreditmiryou) {
        zrncreditmiryou = pZrncreditmiryou;
    }

    private String zrncredittrkhoukbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNCREDITTRKHOUKBN)
    public String getZrncredittrkhoukbn() {
        return zrncredittrkhoukbn;
    }

    public void setZrncredittrkhoukbn(String pZrncredittrkhoukbn) {
        zrncredittrkhoukbn = pZrncredittrkhoukbn;
    }

    private String zrncardbrandkbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNCARDBRANDKBN)
    public String getZrncardbrandkbn() {
        return zrncardbrandkbn;
    }

    @DataConvert("toMultiByte")
    public void setZrncardbrandkbn(String pZrncardbrandkbn) {
        zrncardbrandkbn = pZrncardbrandkbn;
    }

    private String zrncarddatasousinymd;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNCARDDATASOUSINYMD)
    public String getZrncarddatasousinymd() {
        return zrncarddatasousinymd;
    }

    public void setZrncarddatasousinymd(String pZrncarddatasousinymd) {
        zrncarddatasousinymd = pZrncarddatasousinymd;
    }

    private String zrnkykdrtkykarihyj;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKYKDRTKYKARIHYJ)
    public String getZrnkykdrtkykarihyj() {
        return zrnkykdrtkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkykdrtkykarihyj(String pZrnkykdrtkykarihyj) {
        zrnkykdrtkykarihyj = pZrnkykdrtkykarihyj;
    }

    private String zrnkzktrkservicekbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKZKTRKSERVICEKBN)
    public String getZrnkzktrkservicekbn() {
        return zrnkzktrkservicekbn;
    }

    public void setZrnkzktrkservicekbn(String pZrnkzktrkservicekbn) {
        zrnkzktrkservicekbn = pZrnkzktrkservicekbn;
    }

    private String zrnteikisiharaiarihyj;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTEIKISIHARAIARIHYJ)
    public String getZrnteikisiharaiarihyj() {
        return zrnteikisiharaiarihyj;
    }

    public void setZrnteikisiharaiarihyj(String pZrnteikisiharaiarihyj) {
        zrnteikisiharaiarihyj = pZrnteikisiharaiarihyj;
    }

    private String zrnteikishrkinshrtuukakbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTEIKISHRKINSHRTUUKAKBN)
    public String getZrnteikishrkinshrtuukakbn() {
        return zrnteikishrkinshrtuukakbn;
    }

    public void setZrnteikishrkinshrtuukakbn(String pZrnteikishrkinshrtuukakbn) {
        zrnteikishrkinshrtuukakbn = pZrnteikishrkinshrtuukakbn;
    }

    private BizNumber zrnteikisiharaikin;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNTEIKISIHARAIKIN)
    public BizNumber getZrnteikisiharaikin() {
        return zrnteikisiharaikin;
    }

    public void setZrnteikisiharaikin(BizNumber pZrnteikisiharaikin) {
        zrnteikisiharaikin = pZrnteikisiharaikin;
    }

    private String zrnkoureikzksetumeihoukbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKOUREIKZKSETUMEIHOUKBN)
    public String getZrnkoureikzksetumeihoukbn() {
        return zrnkoureikzksetumeihoukbn;
    }

    public void setZrnkoureikzksetumeihoukbn(String pZrnkoureikzksetumeihoukbn) {
        zrnkoureikzksetumeihoukbn = pZrnkoureikzksetumeihoukbn;
    }

    private String zrnkoureimndnhukusuukaikbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKOUREIMNDNHUKUSUUKAIKBN)
    public String getZrnkoureimndnhukusuukaikbn() {
        return zrnkoureimndnhukusuukaikbn;
    }

    public void setZrnkoureimndnhukusuukaikbn(String pZrnkoureimndnhukusuukaikbn) {
        zrnkoureimndnhukusuukaikbn = pZrnkoureimndnhukusuukaikbn;
    }

    private String zrnkoureitratkisyaigidskkbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNKOUREITRATKISYAIGIDSKKBN)
    public String getZrnkoureitratkisyaigidskkbn() {
        return zrnkoureitratkisyaigidskkbn;
    }

    public void setZrnkoureitratkisyaigidskkbn(String pZrnkoureitratkisyaigidskkbn) {
        zrnkoureitratkisyaigidskkbn = pZrnkoureitratkisyaigidskkbn;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private Long zrnnnknsnpssysyup;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNNNKNSNPSSYSYUP)
    public Long getZrnnnknsnpssysyup() {
        return zrnnnknsnpssysyup;
    }

    public void setZrnnnknsnpssysyup(Long pZrnnnknsnpssysyup) {
        zrnnnknsnpssysyup = pZrnnnknsnpssysyup;
    }

    private BizNumber zrnnnknsnpssykwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_DrtenIpToukeiRn.ZRNNNKNSNPSSYKWSRATE)
    public BizNumber getZrnnnknsnpssykwsrate() {
        return zrnnnknsnpssykwsrate;
    }

    public void setZrnnnknsnpssykwsrate(BizNumber pZrnnnknsnpssykwsrate) {
        zrnnnknsnpssykwsrate = pZrnnnknsnpssykwsrate;
    }

    private Long zrnzennoup;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNZENNOUP)
    public Long getZrnzennoup() {
        return zrnzennoup;
    }

    public void setZrnzennoup(Long pZrnzennoup) {
        zrnzennoup = pZrnzennoup;
    }

    private String zrnnenkinzeiseitokuyakukbn;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNNENKINZEISEITOKUYAKUKBN)
    public String getZrnnenkinzeiseitokuyakukbn() {
        return zrnnenkinzeiseitokuyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnenkinzeiseitokuyakukbn(String pZrnnenkinzeiseitokuyakukbn) {
        zrnnenkinzeiseitokuyakukbn = pZrnnenkinzeiseitokuyakukbn;
    }

    private String zrnyobiv33;

    @Column(name=GenZT_DrtenIpToukeiRn.ZRNYOBIV33)
    public String getZrnyobiv33() {
        return zrnyobiv33;
    }

    public void setZrnyobiv33(String pZrnyobiv33) {
        zrnyobiv33 = pZrnyobiv33;
    }
}