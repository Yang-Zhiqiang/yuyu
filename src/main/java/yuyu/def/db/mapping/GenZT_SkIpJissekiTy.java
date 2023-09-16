package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SkIpJissekiTy;
import yuyu.def.db.id.PKZT_SkIpJissekiTy;
import yuyu.def.db.meta.GenQZT_SkIpJissekiTy;
import yuyu.def.db.meta.QZT_SkIpJissekiTy;

/**
 * 新契約インプット実績Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SkIpJissekiTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkIpJissekiTy}</td><td colspan="3">新契約インプット実績Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKZT_SkIpJissekiTy ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtymosym ztymosym}</td><td>（中継用）申込月度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatukaikojincd ztyatukaikojincd}</td><td>（中継用）扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydairitenatkikeitaikbn ztydairitenatkikeitaikbn}</td><td>（中継用）代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatkiwari3keta ztyatkiwari3keta}</td><td>（中継用）扱割合（３桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykjsakininisetteihyj ztykjsakininisetteihyj}</td><td>（中継用）計上先任意設定表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykydatkikbn ztykydatkikbn}</td><td>（中継用）共同扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyoumetukbn ztymossyoumetukbn}</td><td>（中継用）申込消滅区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2keta ztyhhknnen2keta}</td><td>（中継用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykktaikbn ztykykktaikbn}</td><td>（中継用）契約形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryouritukbn ztyryouritukbn}</td><td>（中継用）料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrendouyouharaikomip ztyrendouyouharaikomip}</td><td>（中継用）連動用払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyatukaisosikicd ztyatukaisosikicd}</td><td>（中継用）扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeiyousinsakbn ztytoukeiyousinsakbn}</td><td>（中継用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysdpdkbn ztysdpdkbn}</td><td>（中継用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygyousekiyouhosyous ztygyousekiyouhosyous}</td><td>（中継用）業績用保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeikihons ztygoukeikihons}</td><td>（中継用）合計基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusymd ztymusymd}</td><td>（中継用）申込年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosnyuuryokuymd ztymosnyuuryokuymd}</td><td>（中継用）申込入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipryosyuymd ztysyokaipryosyuymd}</td><td>（中継用）初回Ｐ領収年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfstpnyknsyoriymd ztyfstpnyknsyoriymd}</td><td>（中継用）初回Ｐ入金処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykokutiymd ztykokutiymd}</td><td>（中継用）告知年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyumtkktymd ztymossyumtkktymd}</td><td>（中継用）申込消滅確定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisyaketsyoriymd ztysisyaketsyoriymd}</td><td>（中継用）支社決定処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyosakuseiymd ztymossyosakuseiymd}</td><td>（中継用）申込書作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsakuinmeino ztyhhknsakuinmeino}</td><td>（中継用）被保険者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitousiharaikbn ztyhaitousiharaikbn}</td><td>（中継用）配当支払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhubikbn ztyhubikbn}</td><td>（中継用）不備区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsinkihontikucd ztytsinkihontikucd}</td><td>（中継用）通信先基本地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisekiym ztyseisekiym}</td><td>（中継用）成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokusyujimutoriatukaikbn ztytokusyujimutoriatukaikbn}</td><td>（中継用）特殊事務取扱区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaskinmeino ztykyksyaskinmeino}</td><td>（中継用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossakuseino ztymossakuseino}</td><td>（中継用）申込書作成番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x1 ztyhokensyuruikigouyobi1x1}</td><td>（中継用）保険種類記号予備１＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x2 ztyhokensyuruikigouyobi1x2}</td><td>（中継用）保険種類記号予備１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x3 ztyhokensyuruikigouyobi1x3}</td><td>（中継用）保険種類記号予備１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x4 ztyhokensyuruikigouyobi1x4}</td><td>（中継用）保険種類記号予備１＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x5 ztyhokensyuruikigouyobi1x5}</td><td>（中継用）保険種類記号予備１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x6 ztyhokensyuruikigouyobi1x6}</td><td>（中継用）保険種類記号予備１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x7 ztyhokensyuruikigouyobi1x7}</td><td>（中継用）保険種類記号予備１＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x8 ztyhokensyuruikigouyobi1x8}</td><td>（中継用）保険種類記号予備１＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x9 ztyhokensyuruikigouyobi1x9}</td><td>（中継用）保険種類記号予備１＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x10 ztyhokensyuruikigouyobi1x10}</td><td>（中継用）保険種類記号予備１＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x11 ztyhokensyuruikigouyobi1x11}</td><td>（中継用）保険種類記号予備１＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x12 ztyhokensyuruikigouyobi1x12}</td><td>（中継用）保険種類記号予備１＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x13 ztyhokensyuruikigouyobi1x13}</td><td>（中継用）保険種類記号予備１＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x14 ztyhokensyuruikigouyobi1x14}</td><td>（中継用）保険種類記号予備１＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi1x15 ztyhokensyuruikigouyobi1x15}</td><td>（中継用）保険種類記号予備１＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x1 ztyhokensyuruikigouyobi2x1}</td><td>（中継用）保険種類記号予備２＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x2 ztyhokensyuruikigouyobi2x2}</td><td>（中継用）保険種類記号予備２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x3 ztyhokensyuruikigouyobi2x3}</td><td>（中継用）保険種類記号予備２＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x4 ztyhokensyuruikigouyobi2x4}</td><td>（中継用）保険種類記号予備２＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x5 ztyhokensyuruikigouyobi2x5}</td><td>（中継用）保険種類記号予備２＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x6 ztyhokensyuruikigouyobi2x6}</td><td>（中継用）保険種類記号予備２＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x7 ztyhokensyuruikigouyobi2x7}</td><td>（中継用）保険種類記号予備２＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x8 ztyhokensyuruikigouyobi2x8}</td><td>（中継用）保険種類記号予備２＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x9 ztyhokensyuruikigouyobi2x9}</td><td>（中継用）保険種類記号予備２＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi2x10 ztyhokensyuruikigouyobi2x10}</td><td>（中継用）保険種類記号予備２＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x1 ztyhokensyuruikigouyobi3x1}</td><td>（中継用）保険種類記号予備３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x2 ztyhokensyuruikigouyobi3x2}</td><td>（中継用）保険種類記号予備３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x3 ztyhokensyuruikigouyobi3x3}</td><td>（中継用）保険種類記号予備３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x4 ztyhokensyuruikigouyobi3x4}</td><td>（中継用）保険種類記号予備３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x5 ztyhokensyuruikigouyobi3x5}</td><td>（中継用）保険種類記号予備３＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x6 ztyhokensyuruikigouyobi3x6}</td><td>（中継用）保険種類記号予備３＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x7 ztyhokensyuruikigouyobi3x7}</td><td>（中継用）保険種類記号予備３＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x8 ztyhokensyuruikigouyobi3x8}</td><td>（中継用）保険種類記号予備３＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x9 ztyhokensyuruikigouyobi3x9}</td><td>（中継用）保険種類記号予備３＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhokensyuruikigouyobi3x10 ztyhokensyuruikigouyobi3x10}</td><td>（中継用）保険種類記号予備３＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynstkarihyj ztynstkarihyj}</td><td>（中継用）年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdairiseikyuutkykarihyj ztystdairiseikyuutkykarihyj}</td><td>（中継用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai1kyktdkkbn ztydai1kyktdkkbn}</td><td>（中継用）第１契約者続柄区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyouninymd ztymossyouninymd}</td><td>（中継用）申込承認入力年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkansanp ztynenkansanp}</td><td>（中継用）年換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysibous ztysibous}</td><td>（中継用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynksyuruikbn1 ztynksyuruikbn1}</td><td>（中継用）年金種類区分（１文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhensyuukeiyakusyamei ztyhensyuukeiyakusyamei}</td><td>（中継用）編集契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjitsinkaiadr ztykanjitsinkaiadr}</td><td>（中継用）漢字通信先下位住所</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsintelno ztytsintelno}</td><td>（中継用）通信先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknmei ztyhhknmei}</td><td>（中継用）被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhensyuuyoukyksyaseiymd ztyhensyuuyoukyksyaseiymd}</td><td>（中継用）編集用契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibaraipkyktuuka ztyitijibaraipkyktuuka}</td><td>（中継用）一時払Ｐ（契約通貨建）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseraten5 ztykawaseraten5}</td><td>（中継用）為替レートＮ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyhrktuukakbn ztyhrktuukakbn}</td><td>（中継用）払込通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteituukakbn ztysiteituukakbn}</td><td>（中継用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyksbsitihsyutkykarihyj ztysyksbsitihsyutkykarihyj}</td><td>（中継用）初期死亡時最低保証特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyskkaigomaehrtkykarihyj ztyskkaigomaehrtkykarihyj}</td><td>（中継用）（新契約）介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonskyktuuka ztykihonskyktuuka}</td><td>（中継用）基本Ｓ（契約通貨建）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzenkizennouhyouji ztyzenkizennouhyouji}</td><td>（中継用）全期前納表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynnknsnpssysyup ztynnknsnpssysyup}</td><td>（中継用）年換算Ｐ算出用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynknsnpssyhrkkskbn ztynknsnpssyhrkkskbn}</td><td>（中継用）年換算Ｐ算出用払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtkykarihyj ztykykdrtkykarihyj}</td><td>（中継用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktrkservicearihyj ztykzktrkservicearihyj}</td><td>（中継用）ご家族登録サービス有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x1 ztyyobiv250x1}</td><td>（中継用）予備項目Ｖ２５０＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x2 ztyyobiv250x2}</td><td>（中継用）予備項目Ｖ２５０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x3 ztyyobiv250x3}</td><td>（中継用）予備項目Ｖ２５０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x4 ztyyobiv250x4}</td><td>（中継用）予備項目Ｖ２５０＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv250x5 ztyyobiv250x5}</td><td>（中継用）予備項目Ｖ２５０＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv213 ztyyobiv213}</td><td>（中継用）予備項目Ｖ２１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkIpJissekiTy
 * @see     PKZT_SkIpJissekiTy
 * @see     QZT_SkIpJissekiTy
 * @see     GenQZT_SkIpJissekiTy
 */
@MappedSuperclass
@Table(name=GenZT_SkIpJissekiTy.TABLE_NAME)
@IdClass(value=PKZT_SkIpJissekiTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SkIpJissekiTy extends AbstractExDBEntity<ZT_SkIpJissekiTy, PKZT_SkIpJissekiTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkIpJissekiTy";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYMOSYM                 = "ztymosym";
    public static final String ZTYATUKAIKOJINCD         = "ztyatukaikojincd";
    public static final String ZTYDAIRITENATKIKEITAIKBN = "ztydairitenatkikeitaikbn";
    public static final String ZTYATKIWARI3KETA         = "ztyatkiwari3keta";
    public static final String ZTYKJSAKININISETTEIHYJ   = "ztykjsakininisetteihyj";
    public static final String ZTYMOSNO                 = "ztymosno";
    public static final String ZTYKYDATKIKBN            = "ztykydatkikbn";
    public static final String ZTYMOSSYOUMETUKBN        = "ztymossyoumetukbn";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHHKNNEN2KETA          = "ztyhhknnen2keta";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYKYKKTAIKBN            = "ztykykktaikbn";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYRYOURITUKBN           = "ztyryouritukbn";
    public static final String ZTYRENDOUYOUHARAIKOMIP   = "ztyrendouyouharaikomip";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYATUKAISOSIKICD        = "ztyatukaisosikicd";
    public static final String ZTYTOUKEIYOUSINSAKBN     = "ztytoukeiyousinsakbn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYSDPDKBN               = "ztysdpdkbn";
    public static final String ZTYGYOUSEKIYOUHOSYOUS    = "ztygyousekiyouhosyous";
    public static final String ZTYGOUKEIKIHONS          = "ztygoukeikihons";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYMUSYMD                = "ztymusymd";
    public static final String ZTYMOSNYUURYOKUYMD       = "ztymosnyuuryokuymd";
    public static final String ZTYSYOKAIPRYOSYUYMD      = "ztysyokaipryosyuymd";
    public static final String ZTYFSTPNYKNSYORIYMD      = "ztyfstpnyknsyoriymd";
    public static final String ZTYKOKUTIYMD             = "ztykokutiymd";
    public static final String ZTYMOSSYUMTKKTYMD        = "ztymossyumtkktymd";
    public static final String ZTYSISYAKETSYORIYMD      = "ztysisyaketsyoriymd";
    public static final String ZTYMOSSYOSAKUSEIYMD      = "ztymossyosakuseiymd";
    public static final String ZTYHHKNSAKUINMEINO       = "ztyhhknsakuinmeino";
    public static final String ZTYHAITOUSIHARAIKBN      = "ztyhaitousiharaikbn";
    public static final String ZTYHUBIKBN               = "ztyhubikbn";
    public static final String ZTYTSINKIHONTIKUCD       = "ztytsinkihontikucd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYSEISEKIYM             = "ztyseisekiym";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYTOKUSYUJIMUTORIATUKAIKBN = "ztytokusyujimutoriatukaikbn";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYKYKSYASKINMEINO       = "ztykyksyaskinmeino";
    public static final String ZTYMOSSAKUSEINO          = "ztymossakuseino";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X1 = "ztyhokensyuruikigouyobi1x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X2 = "ztyhokensyuruikigouyobi1x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X3 = "ztyhokensyuruikigouyobi1x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X4 = "ztyhokensyuruikigouyobi1x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X5 = "ztyhokensyuruikigouyobi1x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X6 = "ztyhokensyuruikigouyobi1x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X7 = "ztyhokensyuruikigouyobi1x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X8 = "ztyhokensyuruikigouyobi1x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X9 = "ztyhokensyuruikigouyobi1x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X10 = "ztyhokensyuruikigouyobi1x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X11 = "ztyhokensyuruikigouyobi1x11";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X12 = "ztyhokensyuruikigouyobi1x12";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X13 = "ztyhokensyuruikigouyobi1x13";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X14 = "ztyhokensyuruikigouyobi1x14";
    public static final String ZTYHOKENSYURUIKIGOUYOBI1X15 = "ztyhokensyuruikigouyobi1x15";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X1 = "ztyhokensyuruikigouyobi2x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X2 = "ztyhokensyuruikigouyobi2x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X3 = "ztyhokensyuruikigouyobi2x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X4 = "ztyhokensyuruikigouyobi2x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X5 = "ztyhokensyuruikigouyobi2x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X6 = "ztyhokensyuruikigouyobi2x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X7 = "ztyhokensyuruikigouyobi2x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X8 = "ztyhokensyuruikigouyobi2x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X9 = "ztyhokensyuruikigouyobi2x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI2X10 = "ztyhokensyuruikigouyobi2x10";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X1 = "ztyhokensyuruikigouyobi3x1";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X2 = "ztyhokensyuruikigouyobi3x2";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X3 = "ztyhokensyuruikigouyobi3x3";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X4 = "ztyhokensyuruikigouyobi3x4";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X5 = "ztyhokensyuruikigouyobi3x5";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X6 = "ztyhokensyuruikigouyobi3x6";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X7 = "ztyhokensyuruikigouyobi3x7";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X8 = "ztyhokensyuruikigouyobi3x8";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X9 = "ztyhokensyuruikigouyobi3x9";
    public static final String ZTYHOKENSYURUIKIGOUYOBI3X10 = "ztyhokensyuruikigouyobi3x10";
    public static final String ZTYNSTKARIHYJ            = "ztynstkarihyj";
    public static final String ZTYSTDAIRISEIKYUUTKYKARIHYJ = "ztystdairiseikyuutkykarihyj";
    public static final String ZTYDAI1KYKTDKKBN         = "ztydai1kyktdkkbn";
    public static final String ZTYMOSSYOUNINYMD         = "ztymossyouninymd";
    public static final String ZTYNENKANSANP            = "ztynenkansanp";
    public static final String ZTYSIBOUS                = "ztysibous";
    public static final String ZTYNKSYURUIKBN1          = "ztynksyuruikbn1";
    public static final String ZTYHENSYUUKEIYAKUSYAMEI  = "ztyhensyuukeiyakusyamei";
    public static final String ZTYKANJITSINKAIADR       = "ztykanjitsinkaiadr";
    public static final String ZTYTSINTELNO             = "ztytsintelno";
    public static final String ZTYHHKNMEI               = "ztyhhknmei";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYHENSYUUYOUKYKSYASEIYMD = "ztyhensyuuyoukyksyaseiymd";
    public static final String ZTYITIJIBARAIPKYKTUUKA   = "ztyitijibaraipkyktuuka";
    public static final String ZTYKAWASERATEN5          = "ztykawaseraten5";
    public static final String ZTYHRKTUUKAKBN           = "ztyhrktuukakbn";
    public static final String ZTYSITEITUUKAKBN         = "ztysiteituukakbn";
    public static final String ZTYSYKSBSITIHSYUTKYKARIHYJ = "ztysyksbsitihsyutkykarihyj";
    public static final String ZTYSKKAIGOMAEHRTKYKARIHYJ = "ztyskkaigomaehrtkykarihyj";
    public static final String ZTYKIHONSKYKTUUKA        = "ztykihonskyktuuka";
    public static final String ZTYZENKIZENNOUHYOUJI     = "ztyzenkizennouhyouji";
    public static final String ZTYNNKNSNPSSYSYUP        = "ztynnknsnpssysyup";
    public static final String ZTYNKNSNPSSYHRKKSKBN     = "ztynknsnpssyhrkkskbn";
    public static final String ZTYKYKDRTKYKARIHYJ       = "ztykykdrtkykarihyj";
    public static final String ZTYKZKTRKSERVICEARIHYJ   = "ztykzktrkservicearihyj";
    public static final String ZTYYOBIV250X1            = "ztyyobiv250x1";
    public static final String ZTYYOBIV250X2            = "ztyyobiv250x2";
    public static final String ZTYYOBIV250X3            = "ztyyobiv250x3";
    public static final String ZTYYOBIV250X4            = "ztyyobiv250x4";
    public static final String ZTYYOBIV250X5            = "ztyyobiv250x5";
    public static final String ZTYYOBIV213              = "ztyyobiv213";

    private final PKZT_SkIpJissekiTy primaryKey;

    public GenZT_SkIpJissekiTy() {
        primaryKey = new PKZT_SkIpJissekiTy();
    }

    public GenZT_SkIpJissekiTy(Integer pZtysequenceno) {
        primaryKey = new PKZT_SkIpJissekiTy(pZtysequenceno);
    }

    @Transient
    @Override
    public PKZT_SkIpJissekiTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkIpJissekiTy> getMetaClass() {
        return QZT_SkIpJissekiTy.class;
    }

    @Id
    @Column(name=GenZT_SkIpJissekiTy.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private String ztymosym;

    @Column(name=GenZT_SkIpJissekiTy.ZTYMOSYM)
    public String getZtymosym() {
        return ztymosym;
    }

    public void setZtymosym(String pZtymosym) {
        ztymosym = pZtymosym;
    }

    private String ztyatukaikojincd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYATUKAIKOJINCD)
    public String getZtyatukaikojincd() {
        return ztyatukaikojincd;
    }

    public void setZtyatukaikojincd(String pZtyatukaikojincd) {
        ztyatukaikojincd = pZtyatukaikojincd;
    }

    private String ztydairitenatkikeitaikbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYDAIRITENATKIKEITAIKBN)
    public String getZtydairitenatkikeitaikbn() {
        return ztydairitenatkikeitaikbn;
    }

    public void setZtydairitenatkikeitaikbn(String pZtydairitenatkikeitaikbn) {
        ztydairitenatkikeitaikbn = pZtydairitenatkikeitaikbn;
    }

    private Integer ztyatkiwari3keta;

    @Column(name=GenZT_SkIpJissekiTy.ZTYATKIWARI3KETA)
    public Integer getZtyatkiwari3keta() {
        return ztyatkiwari3keta;
    }

    public void setZtyatkiwari3keta(Integer pZtyatkiwari3keta) {
        ztyatkiwari3keta = pZtyatkiwari3keta;
    }

    private String ztykjsakininisetteihyj;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKJSAKININISETTEIHYJ)
    public String getZtykjsakininisetteihyj() {
        return ztykjsakininisetteihyj;
    }

    public void setZtykjsakininisetteihyj(String pZtykjsakininisetteihyj) {
        ztykjsakininisetteihyj = pZtykjsakininisetteihyj;
    }

    private String ztymosno;

    @Column(name=GenZT_SkIpJissekiTy.ZTYMOSNO)
    public String getZtymosno() {
        return ztymosno;
    }

    public void setZtymosno(String pZtymosno) {
        ztymosno = pZtymosno;
    }

    private String ztykydatkikbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKYDATKIKBN)
    public String getZtykydatkikbn() {
        return ztykydatkikbn;
    }

    public void setZtykydatkikbn(String pZtykydatkikbn) {
        ztykydatkikbn = pZtykydatkikbn;
    }

    private String ztymossyoumetukbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYMOSSYOUMETUKBN)
    public String getZtymossyoumetukbn() {
        return ztymossyoumetukbn;
    }

    public void setZtymossyoumetukbn(String pZtymossyoumetukbn) {
        ztymossyoumetukbn = pZtymossyoumetukbn;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhhknnen2keta;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHHKNNEN2KETA)
    public String getZtyhhknnen2keta() {
        return ztyhhknnen2keta;
    }

    public void setZtyhhknnen2keta(String pZtyhhknnen2keta) {
        ztyhhknnen2keta = pZtyhhknnen2keta;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztykykktaikbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKYKKTAIKBN)
    public String getZtykykktaikbn() {
        return ztykykktaikbn;
    }

    public void setZtykykktaikbn(String pZtykykktaikbn) {
        ztykykktaikbn = pZtykykktaikbn;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztyryouritukbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYRYOURITUKBN)
    public String getZtyryouritukbn() {
        return ztyryouritukbn;
    }

    public void setZtyryouritukbn(String pZtyryouritukbn) {
        ztyryouritukbn = pZtyryouritukbn;
    }

    private Long ztyrendouyouharaikomip;

    @Column(name=GenZT_SkIpJissekiTy.ZTYRENDOUYOUHARAIKOMIP)
    public Long getZtyrendouyouharaikomip() {
        return ztyrendouyouharaikomip;
    }

    public void setZtyrendouyouharaikomip(Long pZtyrendouyouharaikomip) {
        ztyrendouyouharaikomip = pZtyrendouyouharaikomip;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private String ztyatukaisosikicd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYATUKAISOSIKICD)
    public String getZtyatukaisosikicd() {
        return ztyatukaisosikicd;
    }

    public void setZtyatukaisosikicd(String pZtyatukaisosikicd) {
        ztyatukaisosikicd = pZtyatukaisosikicd;
    }

    private String ztytoukeiyousinsakbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYTOUKEIYOUSINSAKBN)
    public String getZtytoukeiyousinsakbn() {
        return ztytoukeiyousinsakbn;
    }

    public void setZtytoukeiyousinsakbn(String pZtytoukeiyousinsakbn) {
        ztytoukeiyousinsakbn = pZtytoukeiyousinsakbn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztysdpdkbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSDPDKBN)
    public String getZtysdpdkbn() {
        return ztysdpdkbn;
    }

    public void setZtysdpdkbn(String pZtysdpdkbn) {
        ztysdpdkbn = pZtysdpdkbn;
    }

    private Long ztygyousekiyouhosyous;

    @Column(name=GenZT_SkIpJissekiTy.ZTYGYOUSEKIYOUHOSYOUS)
    public Long getZtygyousekiyouhosyous() {
        return ztygyousekiyouhosyous;
    }

    public void setZtygyousekiyouhosyous(Long pZtygyousekiyouhosyous) {
        ztygyousekiyouhosyous = pZtygyousekiyouhosyous;
    }

    private Long ztygoukeikihons;

    @Column(name=GenZT_SkIpJissekiTy.ZTYGOUKEIKIHONS)
    public Long getZtygoukeikihons() {
        return ztygoukeikihons;
    }

    public void setZtygoukeikihons(Long pZtygoukeikihons) {
        ztygoukeikihons = pZtygoukeikihons;
    }

    private String ztykykymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztymusymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYMUSYMD)
    public String getZtymusymd() {
        return ztymusymd;
    }

    public void setZtymusymd(String pZtymusymd) {
        ztymusymd = pZtymusymd;
    }

    private String ztymosnyuuryokuymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYMOSNYUURYOKUYMD)
    public String getZtymosnyuuryokuymd() {
        return ztymosnyuuryokuymd;
    }

    public void setZtymosnyuuryokuymd(String pZtymosnyuuryokuymd) {
        ztymosnyuuryokuymd = pZtymosnyuuryokuymd;
    }

    private String ztysyokaipryosyuymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSYOKAIPRYOSYUYMD)
    public String getZtysyokaipryosyuymd() {
        return ztysyokaipryosyuymd;
    }

    public void setZtysyokaipryosyuymd(String pZtysyokaipryosyuymd) {
        ztysyokaipryosyuymd = pZtysyokaipryosyuymd;
    }

    private String ztyfstpnyknsyoriymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYFSTPNYKNSYORIYMD)
    public String getZtyfstpnyknsyoriymd() {
        return ztyfstpnyknsyoriymd;
    }

    public void setZtyfstpnyknsyoriymd(String pZtyfstpnyknsyoriymd) {
        ztyfstpnyknsyoriymd = pZtyfstpnyknsyoriymd;
    }

    private String ztykokutiymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKOKUTIYMD)
    public String getZtykokutiymd() {
        return ztykokutiymd;
    }

    public void setZtykokutiymd(String pZtykokutiymd) {
        ztykokutiymd = pZtykokutiymd;
    }

    private String ztymossyumtkktymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYMOSSYUMTKKTYMD)
    public String getZtymossyumtkktymd() {
        return ztymossyumtkktymd;
    }

    public void setZtymossyumtkktymd(String pZtymossyumtkktymd) {
        ztymossyumtkktymd = pZtymossyumtkktymd;
    }

    private String ztysisyaketsyoriymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSISYAKETSYORIYMD)
    public String getZtysisyaketsyoriymd() {
        return ztysisyaketsyoriymd;
    }

    public void setZtysisyaketsyoriymd(String pZtysisyaketsyoriymd) {
        ztysisyaketsyoriymd = pZtysisyaketsyoriymd;
    }

    private String ztymossyosakuseiymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYMOSSYOSAKUSEIYMD)
    public String getZtymossyosakuseiymd() {
        return ztymossyosakuseiymd;
    }

    public void setZtymossyosakuseiymd(String pZtymossyosakuseiymd) {
        ztymossyosakuseiymd = pZtymossyosakuseiymd;
    }

    private String ztyhhknsakuinmeino;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHHKNSAKUINMEINO)
    public String getZtyhhknsakuinmeino() {
        return ztyhhknsakuinmeino;
    }

    public void setZtyhhknsakuinmeino(String pZtyhhknsakuinmeino) {
        ztyhhknsakuinmeino = pZtyhhknsakuinmeino;
    }

    private String ztyhaitousiharaikbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHAITOUSIHARAIKBN)
    public String getZtyhaitousiharaikbn() {
        return ztyhaitousiharaikbn;
    }

    public void setZtyhaitousiharaikbn(String pZtyhaitousiharaikbn) {
        ztyhaitousiharaikbn = pZtyhaitousiharaikbn;
    }

    private String ztyhubikbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHUBIKBN)
    public String getZtyhubikbn() {
        return ztyhubikbn;
    }

    public void setZtyhubikbn(String pZtyhubikbn) {
        ztyhubikbn = pZtyhubikbn;
    }

    private String ztytsinkihontikucd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYTSINKIHONTIKUCD)
    public String getZtytsinkihontikucd() {
        return ztytsinkihontikucd;
    }

    public void setZtytsinkihontikucd(String pZtytsinkihontikucd) {
        ztytsinkihontikucd = pZtytsinkihontikucd;
    }

    private String ztysyono;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyseisekiym;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSEISEKIYM)
    public String getZtyseisekiym() {
        return ztyseisekiym;
    }

    public void setZtyseisekiym(String pZtyseisekiym) {
        ztyseisekiym = pZtyseisekiym;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztytokusyujimutoriatukaikbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYTOKUSYUJIMUTORIATUKAIKBN)
    public String getZtytokusyujimutoriatukaikbn() {
        return ztytokusyujimutoriatukaikbn;
    }

    public void setZtytokusyujimutoriatukaikbn(String pZtytokusyujimutoriatukaikbn) {
        ztytokusyujimutoriatukaikbn = pZtytokusyujimutoriatukaikbn;
    }

    private String ztybsydrtencd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }

    private String ztycifcd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztykyksyaskinmeino;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKYKSYASKINMEINO)
    public String getZtykyksyaskinmeino() {
        return ztykyksyaskinmeino;
    }

    public void setZtykyksyaskinmeino(String pZtykyksyaskinmeino) {
        ztykyksyaskinmeino = pZtykyksyaskinmeino;
    }

    private String ztymossakuseino;

    @Column(name=GenZT_SkIpJissekiTy.ZTYMOSSAKUSEINO)
    public String getZtymossakuseino() {
        return ztymossakuseino;
    }

    public void setZtymossakuseino(String pZtymossakuseino) {
        ztymossakuseino = pZtymossakuseino;
    }

    private String ztyhokensyuruikigouyobi1x1;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X1)
    public String getZtyhokensyuruikigouyobi1x1() {
        return ztyhokensyuruikigouyobi1x1;
    }

    public void setZtyhokensyuruikigouyobi1x1(String pZtyhokensyuruikigouyobi1x1) {
        ztyhokensyuruikigouyobi1x1 = pZtyhokensyuruikigouyobi1x1;
    }

    private String ztyhokensyuruikigouyobi1x2;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X2)
    public String getZtyhokensyuruikigouyobi1x2() {
        return ztyhokensyuruikigouyobi1x2;
    }

    public void setZtyhokensyuruikigouyobi1x2(String pZtyhokensyuruikigouyobi1x2) {
        ztyhokensyuruikigouyobi1x2 = pZtyhokensyuruikigouyobi1x2;
    }

    private String ztyhokensyuruikigouyobi1x3;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X3)
    public String getZtyhokensyuruikigouyobi1x3() {
        return ztyhokensyuruikigouyobi1x3;
    }

    public void setZtyhokensyuruikigouyobi1x3(String pZtyhokensyuruikigouyobi1x3) {
        ztyhokensyuruikigouyobi1x3 = pZtyhokensyuruikigouyobi1x3;
    }

    private String ztyhokensyuruikigouyobi1x4;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X4)
    public String getZtyhokensyuruikigouyobi1x4() {
        return ztyhokensyuruikigouyobi1x4;
    }

    public void setZtyhokensyuruikigouyobi1x4(String pZtyhokensyuruikigouyobi1x4) {
        ztyhokensyuruikigouyobi1x4 = pZtyhokensyuruikigouyobi1x4;
    }

    private String ztyhokensyuruikigouyobi1x5;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X5)
    public String getZtyhokensyuruikigouyobi1x5() {
        return ztyhokensyuruikigouyobi1x5;
    }

    public void setZtyhokensyuruikigouyobi1x5(String pZtyhokensyuruikigouyobi1x5) {
        ztyhokensyuruikigouyobi1x5 = pZtyhokensyuruikigouyobi1x5;
    }

    private String ztyhokensyuruikigouyobi1x6;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X6)
    public String getZtyhokensyuruikigouyobi1x6() {
        return ztyhokensyuruikigouyobi1x6;
    }

    public void setZtyhokensyuruikigouyobi1x6(String pZtyhokensyuruikigouyobi1x6) {
        ztyhokensyuruikigouyobi1x6 = pZtyhokensyuruikigouyobi1x6;
    }

    private String ztyhokensyuruikigouyobi1x7;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X7)
    public String getZtyhokensyuruikigouyobi1x7() {
        return ztyhokensyuruikigouyobi1x7;
    }

    public void setZtyhokensyuruikigouyobi1x7(String pZtyhokensyuruikigouyobi1x7) {
        ztyhokensyuruikigouyobi1x7 = pZtyhokensyuruikigouyobi1x7;
    }

    private String ztyhokensyuruikigouyobi1x8;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X8)
    public String getZtyhokensyuruikigouyobi1x8() {
        return ztyhokensyuruikigouyobi1x8;
    }

    public void setZtyhokensyuruikigouyobi1x8(String pZtyhokensyuruikigouyobi1x8) {
        ztyhokensyuruikigouyobi1x8 = pZtyhokensyuruikigouyobi1x8;
    }

    private String ztyhokensyuruikigouyobi1x9;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X9)
    public String getZtyhokensyuruikigouyobi1x9() {
        return ztyhokensyuruikigouyobi1x9;
    }

    public void setZtyhokensyuruikigouyobi1x9(String pZtyhokensyuruikigouyobi1x9) {
        ztyhokensyuruikigouyobi1x9 = pZtyhokensyuruikigouyobi1x9;
    }

    private String ztyhokensyuruikigouyobi1x10;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X10)
    public String getZtyhokensyuruikigouyobi1x10() {
        return ztyhokensyuruikigouyobi1x10;
    }

    public void setZtyhokensyuruikigouyobi1x10(String pZtyhokensyuruikigouyobi1x10) {
        ztyhokensyuruikigouyobi1x10 = pZtyhokensyuruikigouyobi1x10;
    }

    private String ztyhokensyuruikigouyobi1x11;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X11)
    public String getZtyhokensyuruikigouyobi1x11() {
        return ztyhokensyuruikigouyobi1x11;
    }

    public void setZtyhokensyuruikigouyobi1x11(String pZtyhokensyuruikigouyobi1x11) {
        ztyhokensyuruikigouyobi1x11 = pZtyhokensyuruikigouyobi1x11;
    }

    private String ztyhokensyuruikigouyobi1x12;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X12)
    public String getZtyhokensyuruikigouyobi1x12() {
        return ztyhokensyuruikigouyobi1x12;
    }

    public void setZtyhokensyuruikigouyobi1x12(String pZtyhokensyuruikigouyobi1x12) {
        ztyhokensyuruikigouyobi1x12 = pZtyhokensyuruikigouyobi1x12;
    }

    private String ztyhokensyuruikigouyobi1x13;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X13)
    public String getZtyhokensyuruikigouyobi1x13() {
        return ztyhokensyuruikigouyobi1x13;
    }

    public void setZtyhokensyuruikigouyobi1x13(String pZtyhokensyuruikigouyobi1x13) {
        ztyhokensyuruikigouyobi1x13 = pZtyhokensyuruikigouyobi1x13;
    }

    private String ztyhokensyuruikigouyobi1x14;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X14)
    public String getZtyhokensyuruikigouyobi1x14() {
        return ztyhokensyuruikigouyobi1x14;
    }

    public void setZtyhokensyuruikigouyobi1x14(String pZtyhokensyuruikigouyobi1x14) {
        ztyhokensyuruikigouyobi1x14 = pZtyhokensyuruikigouyobi1x14;
    }

    private String ztyhokensyuruikigouyobi1x15;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI1X15)
    public String getZtyhokensyuruikigouyobi1x15() {
        return ztyhokensyuruikigouyobi1x15;
    }

    public void setZtyhokensyuruikigouyobi1x15(String pZtyhokensyuruikigouyobi1x15) {
        ztyhokensyuruikigouyobi1x15 = pZtyhokensyuruikigouyobi1x15;
    }

    private String ztyhokensyuruikigouyobi2x1;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI2X1)
    public String getZtyhokensyuruikigouyobi2x1() {
        return ztyhokensyuruikigouyobi2x1;
    }

    public void setZtyhokensyuruikigouyobi2x1(String pZtyhokensyuruikigouyobi2x1) {
        ztyhokensyuruikigouyobi2x1 = pZtyhokensyuruikigouyobi2x1;
    }

    private String ztyhokensyuruikigouyobi2x2;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI2X2)
    public String getZtyhokensyuruikigouyobi2x2() {
        return ztyhokensyuruikigouyobi2x2;
    }

    public void setZtyhokensyuruikigouyobi2x2(String pZtyhokensyuruikigouyobi2x2) {
        ztyhokensyuruikigouyobi2x2 = pZtyhokensyuruikigouyobi2x2;
    }

    private String ztyhokensyuruikigouyobi2x3;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI2X3)
    public String getZtyhokensyuruikigouyobi2x3() {
        return ztyhokensyuruikigouyobi2x3;
    }

    public void setZtyhokensyuruikigouyobi2x3(String pZtyhokensyuruikigouyobi2x3) {
        ztyhokensyuruikigouyobi2x3 = pZtyhokensyuruikigouyobi2x3;
    }

    private String ztyhokensyuruikigouyobi2x4;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI2X4)
    public String getZtyhokensyuruikigouyobi2x4() {
        return ztyhokensyuruikigouyobi2x4;
    }

    public void setZtyhokensyuruikigouyobi2x4(String pZtyhokensyuruikigouyobi2x4) {
        ztyhokensyuruikigouyobi2x4 = pZtyhokensyuruikigouyobi2x4;
    }

    private String ztyhokensyuruikigouyobi2x5;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI2X5)
    public String getZtyhokensyuruikigouyobi2x5() {
        return ztyhokensyuruikigouyobi2x5;
    }

    public void setZtyhokensyuruikigouyobi2x5(String pZtyhokensyuruikigouyobi2x5) {
        ztyhokensyuruikigouyobi2x5 = pZtyhokensyuruikigouyobi2x5;
    }

    private String ztyhokensyuruikigouyobi2x6;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI2X6)
    public String getZtyhokensyuruikigouyobi2x6() {
        return ztyhokensyuruikigouyobi2x6;
    }

    public void setZtyhokensyuruikigouyobi2x6(String pZtyhokensyuruikigouyobi2x6) {
        ztyhokensyuruikigouyobi2x6 = pZtyhokensyuruikigouyobi2x6;
    }

    private String ztyhokensyuruikigouyobi2x7;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI2X7)
    public String getZtyhokensyuruikigouyobi2x7() {
        return ztyhokensyuruikigouyobi2x7;
    }

    public void setZtyhokensyuruikigouyobi2x7(String pZtyhokensyuruikigouyobi2x7) {
        ztyhokensyuruikigouyobi2x7 = pZtyhokensyuruikigouyobi2x7;
    }

    private String ztyhokensyuruikigouyobi2x8;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI2X8)
    public String getZtyhokensyuruikigouyobi2x8() {
        return ztyhokensyuruikigouyobi2x8;
    }

    public void setZtyhokensyuruikigouyobi2x8(String pZtyhokensyuruikigouyobi2x8) {
        ztyhokensyuruikigouyobi2x8 = pZtyhokensyuruikigouyobi2x8;
    }

    private String ztyhokensyuruikigouyobi2x9;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI2X9)
    public String getZtyhokensyuruikigouyobi2x9() {
        return ztyhokensyuruikigouyobi2x9;
    }

    public void setZtyhokensyuruikigouyobi2x9(String pZtyhokensyuruikigouyobi2x9) {
        ztyhokensyuruikigouyobi2x9 = pZtyhokensyuruikigouyobi2x9;
    }

    private String ztyhokensyuruikigouyobi2x10;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI2X10)
    public String getZtyhokensyuruikigouyobi2x10() {
        return ztyhokensyuruikigouyobi2x10;
    }

    public void setZtyhokensyuruikigouyobi2x10(String pZtyhokensyuruikigouyobi2x10) {
        ztyhokensyuruikigouyobi2x10 = pZtyhokensyuruikigouyobi2x10;
    }

    private String ztyhokensyuruikigouyobi3x1;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI3X1)
    public String getZtyhokensyuruikigouyobi3x1() {
        return ztyhokensyuruikigouyobi3x1;
    }

    public void setZtyhokensyuruikigouyobi3x1(String pZtyhokensyuruikigouyobi3x1) {
        ztyhokensyuruikigouyobi3x1 = pZtyhokensyuruikigouyobi3x1;
    }

    private String ztyhokensyuruikigouyobi3x2;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI3X2)
    public String getZtyhokensyuruikigouyobi3x2() {
        return ztyhokensyuruikigouyobi3x2;
    }

    public void setZtyhokensyuruikigouyobi3x2(String pZtyhokensyuruikigouyobi3x2) {
        ztyhokensyuruikigouyobi3x2 = pZtyhokensyuruikigouyobi3x2;
    }

    private String ztyhokensyuruikigouyobi3x3;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI3X3)
    public String getZtyhokensyuruikigouyobi3x3() {
        return ztyhokensyuruikigouyobi3x3;
    }

    public void setZtyhokensyuruikigouyobi3x3(String pZtyhokensyuruikigouyobi3x3) {
        ztyhokensyuruikigouyobi3x3 = pZtyhokensyuruikigouyobi3x3;
    }

    private String ztyhokensyuruikigouyobi3x4;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI3X4)
    public String getZtyhokensyuruikigouyobi3x4() {
        return ztyhokensyuruikigouyobi3x4;
    }

    public void setZtyhokensyuruikigouyobi3x4(String pZtyhokensyuruikigouyobi3x4) {
        ztyhokensyuruikigouyobi3x4 = pZtyhokensyuruikigouyobi3x4;
    }

    private String ztyhokensyuruikigouyobi3x5;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI3X5)
    public String getZtyhokensyuruikigouyobi3x5() {
        return ztyhokensyuruikigouyobi3x5;
    }

    public void setZtyhokensyuruikigouyobi3x5(String pZtyhokensyuruikigouyobi3x5) {
        ztyhokensyuruikigouyobi3x5 = pZtyhokensyuruikigouyobi3x5;
    }

    private String ztyhokensyuruikigouyobi3x6;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI3X6)
    public String getZtyhokensyuruikigouyobi3x6() {
        return ztyhokensyuruikigouyobi3x6;
    }

    public void setZtyhokensyuruikigouyobi3x6(String pZtyhokensyuruikigouyobi3x6) {
        ztyhokensyuruikigouyobi3x6 = pZtyhokensyuruikigouyobi3x6;
    }

    private String ztyhokensyuruikigouyobi3x7;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI3X7)
    public String getZtyhokensyuruikigouyobi3x7() {
        return ztyhokensyuruikigouyobi3x7;
    }

    public void setZtyhokensyuruikigouyobi3x7(String pZtyhokensyuruikigouyobi3x7) {
        ztyhokensyuruikigouyobi3x7 = pZtyhokensyuruikigouyobi3x7;
    }

    private String ztyhokensyuruikigouyobi3x8;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI3X8)
    public String getZtyhokensyuruikigouyobi3x8() {
        return ztyhokensyuruikigouyobi3x8;
    }

    public void setZtyhokensyuruikigouyobi3x8(String pZtyhokensyuruikigouyobi3x8) {
        ztyhokensyuruikigouyobi3x8 = pZtyhokensyuruikigouyobi3x8;
    }

    private String ztyhokensyuruikigouyobi3x9;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI3X9)
    public String getZtyhokensyuruikigouyobi3x9() {
        return ztyhokensyuruikigouyobi3x9;
    }

    public void setZtyhokensyuruikigouyobi3x9(String pZtyhokensyuruikigouyobi3x9) {
        ztyhokensyuruikigouyobi3x9 = pZtyhokensyuruikigouyobi3x9;
    }

    private String ztyhokensyuruikigouyobi3x10;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHOKENSYURUIKIGOUYOBI3X10)
    public String getZtyhokensyuruikigouyobi3x10() {
        return ztyhokensyuruikigouyobi3x10;
    }

    public void setZtyhokensyuruikigouyobi3x10(String pZtyhokensyuruikigouyobi3x10) {
        ztyhokensyuruikigouyobi3x10 = pZtyhokensyuruikigouyobi3x10;
    }

    private String ztynstkarihyj;

    @Column(name=GenZT_SkIpJissekiTy.ZTYNSTKARIHYJ)
    public String getZtynstkarihyj() {
        return ztynstkarihyj;
    }

    public void setZtynstkarihyj(String pZtynstkarihyj) {
        ztynstkarihyj = pZtynstkarihyj;
    }

    private String ztystdairiseikyuutkykarihyj;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZtystdairiseikyuutkykarihyj() {
        return ztystdairiseikyuutkykarihyj;
    }

    public void setZtystdairiseikyuutkykarihyj(String pZtystdairiseikyuutkykarihyj) {
        ztystdairiseikyuutkykarihyj = pZtystdairiseikyuutkykarihyj;
    }

    private String ztydai1kyktdkkbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYDAI1KYKTDKKBN)
    public String getZtydai1kyktdkkbn() {
        return ztydai1kyktdkkbn;
    }

    public void setZtydai1kyktdkkbn(String pZtydai1kyktdkkbn) {
        ztydai1kyktdkkbn = pZtydai1kyktdkkbn;
    }

    private String ztymossyouninymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYMOSSYOUNINYMD)
    public String getZtymossyouninymd() {
        return ztymossyouninymd;
    }

    public void setZtymossyouninymd(String pZtymossyouninymd) {
        ztymossyouninymd = pZtymossyouninymd;
    }

    private Long ztynenkansanp;

    @Column(name=GenZT_SkIpJissekiTy.ZTYNENKANSANP)
    public Long getZtynenkansanp() {
        return ztynenkansanp;
    }

    public void setZtynenkansanp(Long pZtynenkansanp) {
        ztynenkansanp = pZtynenkansanp;
    }

    private Long ztysibous;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSIBOUS)
    public Long getZtysibous() {
        return ztysibous;
    }

    public void setZtysibous(Long pZtysibous) {
        ztysibous = pZtysibous;
    }

    private String ztynksyuruikbn1;

    @Column(name=GenZT_SkIpJissekiTy.ZTYNKSYURUIKBN1)
    public String getZtynksyuruikbn1() {
        return ztynksyuruikbn1;
    }

    public void setZtynksyuruikbn1(String pZtynksyuruikbn1) {
        ztynksyuruikbn1 = pZtynksyuruikbn1;
    }

    private String ztyhensyuukeiyakusyamei;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHENSYUUKEIYAKUSYAMEI)
    public String getZtyhensyuukeiyakusyamei() {
        return ztyhensyuukeiyakusyamei;
    }

    public void setZtyhensyuukeiyakusyamei(String pZtyhensyuukeiyakusyamei) {
        ztyhensyuukeiyakusyamei = pZtyhensyuukeiyakusyamei;
    }

    private String ztykanjitsinkaiadr;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKANJITSINKAIADR)
    public String getZtykanjitsinkaiadr() {
        return ztykanjitsinkaiadr;
    }

    public void setZtykanjitsinkaiadr(String pZtykanjitsinkaiadr) {
        ztykanjitsinkaiadr = pZtykanjitsinkaiadr;
    }

    private String ztytsintelno;

    @Column(name=GenZT_SkIpJissekiTy.ZTYTSINTELNO)
    public String getZtytsintelno() {
        return ztytsintelno;
    }

    public void setZtytsintelno(String pZtytsintelno) {
        ztytsintelno = pZtytsintelno;
    }

    private String ztyhhknmei;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHHKNMEI)
    public String getZtyhhknmei() {
        return ztyhhknmei;
    }

    public void setZtyhhknmei(String pZtyhhknmei) {
        ztyhhknmei = pZtyhhknmei;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztyhensyuuyoukyksyaseiymd;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHENSYUUYOUKYKSYASEIYMD)
    public String getZtyhensyuuyoukyksyaseiymd() {
        return ztyhensyuuyoukyksyaseiymd;
    }

    public void setZtyhensyuuyoukyksyaseiymd(String pZtyhensyuuyoukyksyaseiymd) {
        ztyhensyuuyoukyksyaseiymd = pZtyhensyuuyoukyksyaseiymd;
    }

    private BizNumber ztyitijibaraipkyktuuka;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkIpJissekiTy.ZTYITIJIBARAIPKYKTUUKA)
    public BizNumber getZtyitijibaraipkyktuuka() {
        return ztyitijibaraipkyktuuka;
    }

    public void setZtyitijibaraipkyktuuka(BizNumber pZtyitijibaraipkyktuuka) {
        ztyitijibaraipkyktuuka = pZtyitijibaraipkyktuuka;
    }

    private BizNumber ztykawaseraten5;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SkIpJissekiTy.ZTYKAWASERATEN5)
    public BizNumber getZtykawaseraten5() {
        return ztykawaseraten5;
    }

    public void setZtykawaseraten5(BizNumber pZtykawaseraten5) {
        ztykawaseraten5 = pZtykawaseraten5;
    }

    private String ztyhrktuukakbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYHRKTUUKAKBN)
    public String getZtyhrktuukakbn() {
        return ztyhrktuukakbn;
    }

    public void setZtyhrktuukakbn(String pZtyhrktuukakbn) {
        ztyhrktuukakbn = pZtyhrktuukakbn;
    }

    private String ztysiteituukakbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSITEITUUKAKBN)
    public String getZtysiteituukakbn() {
        return ztysiteituukakbn;
    }

    public void setZtysiteituukakbn(String pZtysiteituukakbn) {
        ztysiteituukakbn = pZtysiteituukakbn;
    }

    private String ztysyksbsitihsyutkykarihyj;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSYKSBSITIHSYUTKYKARIHYJ)
    public String getZtysyksbsitihsyutkykarihyj() {
        return ztysyksbsitihsyutkykarihyj;
    }

    public void setZtysyksbsitihsyutkykarihyj(String pZtysyksbsitihsyutkykarihyj) {
        ztysyksbsitihsyutkykarihyj = pZtysyksbsitihsyutkykarihyj;
    }

    private String ztyskkaigomaehrtkykarihyj;

    @Column(name=GenZT_SkIpJissekiTy.ZTYSKKAIGOMAEHRTKYKARIHYJ)
    public String getZtyskkaigomaehrtkykarihyj() {
        return ztyskkaigomaehrtkykarihyj;
    }

    public void setZtyskkaigomaehrtkykarihyj(String pZtyskkaigomaehrtkykarihyj) {
        ztyskkaigomaehrtkykarihyj = pZtyskkaigomaehrtkykarihyj;
    }

    private Long ztykihonskyktuuka;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKIHONSKYKTUUKA)
    public Long getZtykihonskyktuuka() {
        return ztykihonskyktuuka;
    }

    public void setZtykihonskyktuuka(Long pZtykihonskyktuuka) {
        ztykihonskyktuuka = pZtykihonskyktuuka;
    }

    private String ztyzenkizennouhyouji;

    @Column(name=GenZT_SkIpJissekiTy.ZTYZENKIZENNOUHYOUJI)
    public String getZtyzenkizennouhyouji() {
        return ztyzenkizennouhyouji;
    }

    public void setZtyzenkizennouhyouji(String pZtyzenkizennouhyouji) {
        ztyzenkizennouhyouji = pZtyzenkizennouhyouji;
    }

    private Long ztynnknsnpssysyup;

    @Column(name=GenZT_SkIpJissekiTy.ZTYNNKNSNPSSYSYUP)
    public Long getZtynnknsnpssysyup() {
        return ztynnknsnpssysyup;
    }

    public void setZtynnknsnpssysyup(Long pZtynnknsnpssysyup) {
        ztynnknsnpssysyup = pZtynnknsnpssysyup;
    }

    private String ztynknsnpssyhrkkskbn;

    @Column(name=GenZT_SkIpJissekiTy.ZTYNKNSNPSSYHRKKSKBN)
    public String getZtynknsnpssyhrkkskbn() {
        return ztynknsnpssyhrkkskbn;
    }

    public void setZtynknsnpssyhrkkskbn(String pZtynknsnpssyhrkkskbn) {
        ztynknsnpssyhrkkskbn = pZtynknsnpssyhrkkskbn;
    }

    private String ztykykdrtkykarihyj;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKYKDRTKYKARIHYJ)
    public String getZtykykdrtkykarihyj() {
        return ztykykdrtkykarihyj;
    }

    public void setZtykykdrtkykarihyj(String pZtykykdrtkykarihyj) {
        ztykykdrtkykarihyj = pZtykykdrtkykarihyj;
    }

    private String ztykzktrkservicearihyj;

    @Column(name=GenZT_SkIpJissekiTy.ZTYKZKTRKSERVICEARIHYJ)
    public String getZtykzktrkservicearihyj() {
        return ztykzktrkservicearihyj;
    }

    public void setZtykzktrkservicearihyj(String pZtykzktrkservicearihyj) {
        ztykzktrkservicearihyj = pZtykzktrkservicearihyj;
    }

    private String ztyyobiv250x1;

    @Column(name=GenZT_SkIpJissekiTy.ZTYYOBIV250X1)
    public String getZtyyobiv250x1() {
        return ztyyobiv250x1;
    }

    public void setZtyyobiv250x1(String pZtyyobiv250x1) {
        ztyyobiv250x1 = pZtyyobiv250x1;
    }

    private String ztyyobiv250x2;

    @Column(name=GenZT_SkIpJissekiTy.ZTYYOBIV250X2)
    public String getZtyyobiv250x2() {
        return ztyyobiv250x2;
    }

    public void setZtyyobiv250x2(String pZtyyobiv250x2) {
        ztyyobiv250x2 = pZtyyobiv250x2;
    }

    private String ztyyobiv250x3;

    @Column(name=GenZT_SkIpJissekiTy.ZTYYOBIV250X3)
    public String getZtyyobiv250x3() {
        return ztyyobiv250x3;
    }

    public void setZtyyobiv250x3(String pZtyyobiv250x3) {
        ztyyobiv250x3 = pZtyyobiv250x3;
    }

    private String ztyyobiv250x4;

    @Column(name=GenZT_SkIpJissekiTy.ZTYYOBIV250X4)
    public String getZtyyobiv250x4() {
        return ztyyobiv250x4;
    }

    public void setZtyyobiv250x4(String pZtyyobiv250x4) {
        ztyyobiv250x4 = pZtyyobiv250x4;
    }

    private String ztyyobiv250x5;

    @Column(name=GenZT_SkIpJissekiTy.ZTYYOBIV250X5)
    public String getZtyyobiv250x5() {
        return ztyyobiv250x5;
    }

    public void setZtyyobiv250x5(String pZtyyobiv250x5) {
        ztyyobiv250x5 = pZtyyobiv250x5;
    }

    private String ztyyobiv213;

    @Column(name=GenZT_SkIpJissekiTy.ZTYYOBIV213)
    public String getZtyyobiv213() {
        return ztyyobiv213;
    }

    public void setZtyyobiv213(String pZtyyobiv213) {
        ztyyobiv213 = pZtyyobiv213;
    }
}