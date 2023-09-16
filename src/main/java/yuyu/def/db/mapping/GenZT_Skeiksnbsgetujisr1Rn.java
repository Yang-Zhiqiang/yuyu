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
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr1Rn;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr1Rn;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr1Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr1Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル１（連） テーブルのマッピング情報クラスで、 {@link ZT_Skeiksnbsgetujisr1Rn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Skeiksnbsgetujisr1Rn}</td><td colspan="3">新契約決算ベース月次成立Ｆテーブル１（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnktgysyrymd zrnktgysyrymd}</td><td>（連携用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgysyono zrnktgysyono}</td><td>（連携用）結合用証券番号</td><td align="center">{@link PKZT_Skeiksnbsgetujisr1Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgyfilerenno zrnktgyfilerenno}</td><td>（連携用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisyasisyacd zrnaatukaisyasisyacd}</td><td>（連携用）Ａ扱者支社コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmosno zrnmosno}</td><td>（連携用）申込番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykymd zrnkykymd}</td><td>（連携用）契約年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkihons zrnkihons}</td><td>（連携用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsibous zrnsibous}</td><td>（連携用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngyousekihyoukayouhosyous zrngyousekihyoukayouhosyous}</td><td>（連携用）業績評価用保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukitnknitjbrkhns zrngukitnknitjbrkhns}</td><td>（連携用）合計転換一時払基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukitnknitjbrsbus zrngukitnknitjbrsbus}</td><td>（連携用）合計転換一時払死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkktijgukitnknitjbrkhns zrnkktijgukitnknitjbrkhns}</td><td>（連携用）確定時合計転換一時払基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkktijgukitnknitjbrsbus zrnkktijgukitnknitjbrsbus}</td><td>（連携用）確定時合計転換一時払死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyokaiharaikomip zrnsyokaiharaikomip}</td><td>（連携用）初回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakup zrnsyukeiyakup}</td><td>（連携用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhrkkeirokbn zrnhrkkeirokbn}</td><td>（連携用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryouritukbn zrnryouritukbn}</td><td>（連携用）料率区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntksyuannaikykkbn zrntksyuannaikykkbn}</td><td>（連携用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsdpdkbn zrnsdpdkbn}</td><td>（連携用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnanniskcd zrnanniskcd}</td><td>（連携用）案内先コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnduketorihouhoukbn zrnduketorihouhoukbn}</td><td>（連携用）Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyhhknsydouituhyouji zrnkyksyhhknsydouituhyouji}</td><td>（連携用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyakikykarihyj zrnkyksyakikykarihyj}</td><td>（連携用）契約者既契約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkankeiyakuhyouji zrntenkankeiyakuhyouji}</td><td>（連携用）転換契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjigyoukeiyakuhyouji zrnjigyoukeiyakuhyouji}</td><td>（連携用）事業契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnenkinzeiseitokuyakukbn zrnnenkinzeiseitokuyakukbn}</td><td>（連携用）年金税制特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyusseimaekanyuukykkbn zrnsyusseimaekanyuukykkbn}</td><td>（連携用）出生前加入契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokukeiyakuhyouji zrnkazokukeiyakuhyouji}</td><td>（連携用）家族契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjikokykhyj zrnjikokykhyj}</td><td>（連携用）自己契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuusyoumeisiyouhyouji zrntuusyoumeisiyouhyouji}</td><td>（連携用）通称名使用表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsethokenkbn zrnsethokenkbn}</td><td>（連携用）セット保険区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikeisyouhinkbn zrnteikeisyouhinkbn}</td><td>（連携用）提携商品区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsykgycd zrnsykgycd}</td><td>（連携用）職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuninbosyuuteate zrntokuninbosyuuteate}</td><td>（連携用）特認募集手当</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseisekiym zrnseisekiym}</td><td>（連携用）成績計上年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisekikeijyousyuuseis zrnseisekikeijyousyuuseis}</td><td>（連携用）成績計上修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyuuseissakugenhyouji zrnsyuuseissakugenhyouji}</td><td>（連携用）修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisisyatodouhukencd zrnaatukaisisyatodouhukencd}</td><td>（連携用）Ａ扱支社都道府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaisosikicd zrnaatukaisosikicd}</td><td>（連携用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatukaikojincd zrnaatukaikojincd}</td><td>（連携用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatukaisosikicd zrnbatukaisosikicd}</td><td>（連携用）Ｂ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatukaisyakojincd zrnbatukaisyakojincd}</td><td>（連携用）Ｂ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarutokukbn zrnmarutokukbn}</td><td>（連携用）マル特区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngyoumujyouhyouji zrngyoumujyouhyouji}</td><td>（連携用）業務上表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuikakeijyoukbn zrntuikakeijyoukbn}</td><td>（連携用）追加計上区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseisekinomikeijyoukbn zrnseisekinomikeijyoukbn}</td><td>（連携用）成績のみ計上区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteikikeijyoukbn zrnteikikeijyoukbn}</td><td>（連携用）定期計上区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhngkmskkatkisykbn zrnhngkmskkatkisykbn}</td><td>（連携用）変額無資格扱者区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknkyuuyosakugenhyj zrntnknkyuuyosakugenhyj}</td><td>（連携用）転換給与削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkankaisuu zrntenkankaisuu}</td><td>（連携用）転換回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhiyubrigssnsikkijyunkbn zrnhiyubrigssnsikkijyunkbn}</td><td>（連携用）併用払合算正規基準区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsekininkaisiymd zrnsekininkaisiymd}</td><td>（連携用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkigetusmkrgkykhyj zrnkigetusmkrgkykhyj}</td><td>（連携用）期月締切後契約表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhensyuusyoriymd zrnhensyuusyoriymd}</td><td>（連携用）編集処理年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjisisyaatukaihyouji zrnjisisyaatukaihyouji}</td><td>（連携用）自支社扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatkisytktntusy1atkihyj zrnaatkisytktntusy1atkihyj}</td><td>（連携用）Ａ扱者地区担当者１扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatkisytktntusy2atkihyj zrnaatkisytktntusy2atkihyj}</td><td>（連携用）Ａ扱者地区担当者２扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatkisyasyokan1atkihyj zrnaatkisyasyokan1atkihyj}</td><td>（連携用）Ａ扱者所管１扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnaatkisyasyokan2atkihyj zrnaatkisyasyokan2atkihyj}</td><td>（連携用）Ａ扱者所管２扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatkisytktntusy1atkihyj zrnbatkisytktntusy1atkihyj}</td><td>（連携用）Ｂ扱者地区担当者１扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatkisytktntusy2atkihyj zrnbatkisytktntusy2atkihyj}</td><td>（連携用）Ｂ扱者地区担当者２扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatkisyasyokan1atkihyj zrnbatkisyasyokan1atkihyj}</td><td>（連携用）Ｂ扱者所管１扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbatkisyasyokan2atkihyj zrnbatkisyasyokan2atkihyj}</td><td>（連携用）Ｂ扱者所管２扱表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeizokutyuuihyouji zrnkeizokutyuuihyouji}</td><td>（連携用）継続注意表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakubisiteihyouji zrnkeiyakubisiteihyouji}</td><td>（連携用）契約日指定表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyoukentukihyouji zrnjyoukentukihyouji}</td><td>（連携用）条件付表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuninhyouji zrntokuninhyouji}</td><td>（連携用）特認表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkessantyouseikbn zrnkessantyouseikbn}</td><td>（連携用）決算調整区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhaneihyouji zrnhaneihyouji}</td><td>（連携用）繁栄表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyukinkbn zrnsyukinkbn}</td><td>（連携用）集金区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakusyasyokugyoucd zrnkeiyakusyasyokugyoucd}</td><td>（連携用）契約者職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseikeikeirokbn zrnseikeikeirokbn}</td><td>（連携用）成契経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2seikeikeirokbn zrndai2seikeikeirokbn}</td><td>（連携用）第２成契経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigentokuteisyuruikigou zrnteigentokuteisyuruikigou}</td><td>（連携用）逓減トク定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigentokuteikikan zrnteigentokuteikikan}</td><td>（連携用）逓減トク定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigentokuteis zrnteigentokuteis}</td><td>（連携用）逓減トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnteigentokuteip zrnteigentokuteip}</td><td>（連携用）逓減トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntigntktisdtpdtkbn zrntigntktisdtpdtkbn}</td><td>（連携用）逓減トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigentokuteisyuuseis zrnteigentokuteisyuuseis}</td><td>（連携用）逓減トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnteigentktimodssakugenhyj zrnteigentktimodssakugenhyj}</td><td>（連携用）逓減トク定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigentktikgusdkbn zrnteigentktikgusdkbn}</td><td>（連携用）逓減トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9 zrnyobiv9}</td><td>（連携用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteibuicdx1 zrntokuteibuicdx1}</td><td>（連携用）特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnpkknx1 zrnhtnpkknx1}</td><td>（連携用）不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteibuicdx2 zrntokuteibuicdx2}</td><td>（連携用）特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnpkknx2 zrnhtnpkknx2}</td><td>（連携用）不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknmei zrnhhknmei}</td><td>（連携用）被保険者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknjhhknmei zrnknjhhknmei}</td><td>（連携用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseiymd zrnhhknseiymd}</td><td>（連携用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknseikbn zrnhhknseikbn}</td><td>（連携用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknhnsktodouhukencd zrnhhknhnsktodouhukencd}</td><td>（連携用）被保険者本籍都道府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyaagev2 zrnhihokensyaagev2}</td><td>（連携用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhihokensyakikykarihyj zrnhihokensyakikykarihyj}</td><td>（連携用）被保険者既契約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnobikkosaimankikbn zrnnobikkosaimankikbn}</td><td>（連携用）のびっこ才満期区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsysysnhonninkknnkbn zrnhhknsysysnhonninkknnkbn}</td><td>（連携用）被保険者初診本人確認区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknsysisnhonninkknnkbn zrnhhknsysisnhonninkknnkbn}</td><td>（連携用）被保険者再診本人確認区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzktourokuservicearihyj zrnkzktourokuservicearihyj}</td><td>（連携用）家族登録サービス有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x12 zrnyobiv4x12}</td><td>（連携用）予備項目Ｖ４＿１２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhensyuukeiyakusyamei zrnhensyuukeiyakusyamei}</td><td>（連携用）編集契約者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhnsyuknjkyksynm zrnhnsyuknjkyksynm}</td><td>（連携用）編集漢字契約者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseiymd zrnkyksyaseiymd}</td><td>（連携用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyaseikbn zrnkyksyaseikbn}</td><td>（連携用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksyanen zrnkyksyanen}</td><td>（連携用）契約者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnknkuzusnzyrt zrnknkuzusnzyrt}</td><td>（連携用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnvitdoujimos2kenmeikouhyj zrnvitdoujimos2kenmeikouhyj}</td><td>（連携用）Ｖｉｔ同時申込２件目以降表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikykvitarituikamoshyj zrnkikykvitarituikamoshyj}</td><td>（連携用）既契約Ｖｉｔ有追加申込表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykvithokenkbn zrnhtnknkykvithokenkbn}</td><td>（連携用）被転換契約Ｖｉｔ保険区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkikykvithokenhoyuujkkbn zrnkikykvithokenhoyuujkkbn}</td><td>（連携用）既契約Ｖｉｔ保険保有状況区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2x2 zrnyobiv2x2}</td><td>（連携用）予備項目Ｖ２＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsnsknewyno zrntsnsknewyno}</td><td>（連携用）通信先新郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntsnsknewtikucd zrntsnsknewtikucd}</td><td>（連携用）通信先新地区コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmossyumtkktymd zrnmossyumtkktymd}</td><td>（連携用）申込消滅確定年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkituenkbn zrnkituenkbn}</td><td>（連携用）喫煙区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntuusinsakijyuusyokbn zrntuusinsakijyuusyokbn}</td><td>（連携用）通信先住所区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteisyuruikigou zrnmaruteisyuruikigou}</td><td>（連携用）マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikikan zrnmaruteikikan}</td><td>（連携用）マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteiphrkkkn zrnmaruteiphrkkkn}</td><td>（連携用）マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteis zrnmaruteis}</td><td>（連携用）マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmaruteip zrnmaruteip}</td><td>（連携用）マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmaruteisyuuseis zrnmaruteisyuuseis}</td><td>（連携用）マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmaruteisyuuseisskgnhyj zrnmaruteisyuuseisskgnhyj}</td><td>（連携用）マル定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteitokujyoukbn zrnmaruteitokujyoukbn}</td><td>（連携用）マル定特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtitkjyuskgnkkn zrnmrtitkjyuskgnkkn}</td><td>（連携用）マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtitkjyuryumshyutn zrnmrtitkjyuryumshyutn}</td><td>（連携用）マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnmaruteitokujyoup zrnmaruteitokujyoup}</td><td>（連携用）マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsuryumrtipwrbkkbn zrnsuryumrtipwrbkkbn}</td><td>（連携用）数理用マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteipwaribikikbn zrnmaruteipwaribikikbn}</td><td>（連携用）マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtitnknyugukbn zrnmrtitnknyugukbn}</td><td>（連携用）マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikigousedaikbn zrnmaruteikigousedaikbn}</td><td>（連携用）マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruteikikousnmnryoage zrnmaruteikikousnmnryoage}</td><td>（連携用）マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv2 zrnyobiv2}</td><td>（連携用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruyousyuruikigou zrnmaruyousyuruikigou}</td><td>（連携用）マル養種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruyoukikan zrnmaruyoukikan}</td><td>（連携用）マル養期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruyous zrnmaruyous}</td><td>（連携用）マル養Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmaruyoup zrnmaruyoup}</td><td>（連携用）マル養Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmaruyousdatepdatekbn zrnmaruyousdatepdatekbn}</td><td>（連携用）マル養Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruyousyuuseis zrnmaruyousyuuseis}</td><td>（連携用）マル養修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmaruyousyuuseisskgnhyj zrnmaruyousyuuseisskgnhyj}</td><td>（連携用）マル養修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmaruyoukigousedaikbn zrnmaruyoukigousedaikbn}</td><td>（連携用）マル養記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x3 zrnyobiv9x3}</td><td>（連携用）予備項目Ｖ９＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyuusyuruikigou zrnmarusyuusyuruikigou}</td><td>（連携用）マル終種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyuukikan zrnmarusyuukikan}</td><td>（連携用）マル終期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyuus zrnmarusyuus}</td><td>（連携用）マル終Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmarusyuup zrnmarusyuup}</td><td>（連携用）マル終Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmarusyuusdatepdatekbn zrnmarusyuusdatepdatekbn}</td><td>（連携用）マル終Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyuusyuuseis zrnmarusyuusyuuseis}</td><td>（連携用）マル終修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnmarusyuusyuuseisskgnhyj zrnmarusyuusyuuseisskgnhyj}</td><td>（連携用）マル終修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmarusyuukigousedaikbn zrnmarusyuukigousedaikbn}</td><td>（連携用）マル終記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x4 zrnyobiv9x4}</td><td>（連携用）予備項目Ｖ９＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteisyuruikigou zrntokuteisyuruikigou}</td><td>（連携用）トク定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteikikan zrntokuteikikan}</td><td>（連携用）トク定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteis zrntokuteis}</td><td>（連携用）トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokuteip zrntokuteip}</td><td>（連携用）トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokuteisdatepdatekbn zrntokuteisdatepdatekbn}</td><td>（連携用）トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteisyuuseis zrntokuteisyuuseis}</td><td>（連携用）トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntokuteisyuuseisskgnhyj zrntokuteisyuuseisskgnhyj}</td><td>（連携用）トク定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntokuteikigousedaikbn zrntokuteikigousedaikbn}</td><td>（連携用）トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x5 zrnyobiv9x5}</td><td>（連携用）予備項目Ｖ９＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitkyknox1 zrnkzkmrtitkyknox1}</td><td>（連携用）家族マル定特約番号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtisyuruikgux1 zrnkazokumrtisyuruikgux1}</td><td>（連携用）家族マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteikikanx1 zrnkazokumaruteikikanx1}</td><td>（連携用）家族マル定期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiphrkkknx1 zrnkazokumrtiphrkkknx1}</td><td>（連携用）家族マル定Ｐ払込期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteisx1 zrnkazokumaruteisx1}</td><td>（連携用）家族マル定Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteipx1 zrnkazokumaruteipx1}</td><td>（連携用）家族マル定Ｐ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyanmx1 zrnkzkmrtihihknsyanmx1}</td><td>（連携用）家族マル定被保険者名＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyseiymdx1 zrnkzkmrtihihknsyseiymdx1}</td><td>（連携用）家族マル定被保険者生年月日＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsysibtkbnx1 zrnkzkmrtihihknsysibtkbnx1}</td><td>（連携用）家族マル定被保険者性別区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtihihknsyaagex1 zrnkazokumrtihihknsyaagex1}</td><td>（連携用）家族マル定被保険者年令＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtimodsx1 zrnkzkmrtimodsx1}</td><td>（連携用）家族マル定修正Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtimodsskgnhyjx1 zrnkazokumrtimodsskgnhyjx1}</td><td>（連携用）家族マル定修正Ｓ削減表示＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitnknyugukbnx1 zrnkzkmrtitnknyugukbnx1}</td><td>（連携用）家族マル定転換優遇区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtikgusdkbnx1 zrnkazokumrtikgusdkbnx1}</td><td>（連携用）家族マル定記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiagetyusihyjx1 zrnkazokumrtiagetyusihyjx1}</td><td>（連携用）家族マル定年令調整表示＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikusnmnryoagex1 zrnkzkmrtikusnmnryoagex1}</td><td>（連携用）家族マル定更新満了年令＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4 zrnyobiv4}</td><td>（連携用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitkyknox2 zrnkzkmrtitkyknox2}</td><td>（連携用）家族マル定特約番号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtisyuruikgux2 zrnkazokumrtisyuruikgux2}</td><td>（連携用）家族マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteikikanx2 zrnkazokumaruteikikanx2}</td><td>（連携用）家族マル定期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiphrkkknx2 zrnkazokumrtiphrkkknx2}</td><td>（連携用）家族マル定Ｐ払込期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteisx2 zrnkazokumaruteisx2}</td><td>（連携用）家族マル定Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteipx2 zrnkazokumaruteipx2}</td><td>（連携用）家族マル定Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyanmx2 zrnkzkmrtihihknsyanmx2}</td><td>（連携用）家族マル定被保険者名＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyseiymdx2 zrnkzkmrtihihknsyseiymdx2}</td><td>（連携用）家族マル定被保険者生年月日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsysibtkbnx2 zrnkzkmrtihihknsysibtkbnx2}</td><td>（連携用）家族マル定被保険者性別区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtihihknsyaagex2 zrnkazokumrtihihknsyaagex2}</td><td>（連携用）家族マル定被保険者年令＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtimodsx2 zrnkzkmrtimodsx2}</td><td>（連携用）家族マル定修正Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtimodsskgnhyjx2 zrnkazokumrtimodsskgnhyjx2}</td><td>（連携用）家族マル定修正Ｓ削減表示＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitnknyugukbnx2 zrnkzkmrtitnknyugukbnx2}</td><td>（連携用）家族マル定転換優遇区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtikgusdkbnx2 zrnkazokumrtikgusdkbnx2}</td><td>（連携用）家族マル定記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiagetyusihyjx2 zrnkazokumrtiagetyusihyjx2}</td><td>（連携用）家族マル定年令調整表示＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikusnmnryoagex2 zrnkzkmrtikusnmnryoagex2}</td><td>（連携用）家族マル定更新満了年令＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x2 zrnyobiv4x2}</td><td>（連携用）予備項目Ｖ４＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitkyknox3 zrnkzkmrtitkyknox3}</td><td>（連携用）家族マル定特約番号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtisyuruikgux3 zrnkazokumrtisyuruikgux3}</td><td>（連携用）家族マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteikikanx3 zrnkazokumaruteikikanx3}</td><td>（連携用）家族マル定期間＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiphrkkknx3 zrnkazokumrtiphrkkknx3}</td><td>（連携用）家族マル定Ｐ払込期間＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteisx3 zrnkazokumaruteisx3}</td><td>（連携用）家族マル定Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteipx3 zrnkazokumaruteipx3}</td><td>（連携用）家族マル定Ｐ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyanmx3 zrnkzkmrtihihknsyanmx3}</td><td>（連携用）家族マル定被保険者名＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyseiymdx3 zrnkzkmrtihihknsyseiymdx3}</td><td>（連携用）家族マル定被保険者生年月日＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsysibtkbnx3 zrnkzkmrtihihknsysibtkbnx3}</td><td>（連携用）家族マル定被保険者性別区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtihihknsyaagex3 zrnkazokumrtihihknsyaagex3}</td><td>（連携用）家族マル定被保険者年令＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtimodsx3 zrnkzkmrtimodsx3}</td><td>（連携用）家族マル定修正Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtimodsskgnhyjx3 zrnkazokumrtimodsskgnhyjx3}</td><td>（連携用）家族マル定修正Ｓ削減表示＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitnknyugukbnx3 zrnkzkmrtitnknyugukbnx3}</td><td>（連携用）家族マル定転換優遇区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtikgusdkbnx3 zrnkazokumrtikgusdkbnx3}</td><td>（連携用）家族マル定記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiagetyusihyjx3 zrnkazokumrtiagetyusihyjx3}</td><td>（連携用）家族マル定年令調整表示＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikusnmnryoagex3 zrnkzkmrtikusnmnryoagex3}</td><td>（連携用）家族マル定更新満了年令＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x3 zrnyobiv4x3}</td><td>（連携用）予備項目Ｖ４＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitkyknox4 zrnkzkmrtitkyknox4}</td><td>（連携用）家族マル定特約番号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtisyuruikgux4 zrnkazokumrtisyuruikgux4}</td><td>（連携用）家族マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteikikanx4 zrnkazokumaruteikikanx4}</td><td>（連携用）家族マル定期間＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiphrkkknx4 zrnkazokumrtiphrkkknx4}</td><td>（連携用）家族マル定Ｐ払込期間＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteisx4 zrnkazokumaruteisx4}</td><td>（連携用）家族マル定Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteipx4 zrnkazokumaruteipx4}</td><td>（連携用）家族マル定Ｐ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyanmx4 zrnkzkmrtihihknsyanmx4}</td><td>（連携用）家族マル定被保険者名＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyseiymdx4 zrnkzkmrtihihknsyseiymdx4}</td><td>（連携用）家族マル定被保険者生年月日＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsysibtkbnx4 zrnkzkmrtihihknsysibtkbnx4}</td><td>（連携用）家族マル定被保険者性別区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtihihknsyaagex4 zrnkazokumrtihihknsyaagex4}</td><td>（連携用）家族マル定被保険者年令＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtimodsx4 zrnkzkmrtimodsx4}</td><td>（連携用）家族マル定修正Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtimodsskgnhyjx4 zrnkazokumrtimodsskgnhyjx4}</td><td>（連携用）家族マル定修正Ｓ削減表示＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitnknyugukbnx4 zrnkzkmrtitnknyugukbnx4}</td><td>（連携用）家族マル定転換優遇区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtikgusdkbnx4 zrnkazokumrtikgusdkbnx4}</td><td>（連携用）家族マル定記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiagetyusihyjx4 zrnkazokumrtiagetyusihyjx4}</td><td>（連携用）家族マル定年令調整表示＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikusnmnryoagex4 zrnkzkmrtikusnmnryoagex4}</td><td>（連携用）家族マル定更新満了年令＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x4 zrnyobiv4x4}</td><td>（連携用）予備項目Ｖ４＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitkyknox5 zrnkzkmrtitkyknox5}</td><td>（連携用）家族マル定特約番号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtisyuruikgux5 zrnkazokumrtisyuruikgux5}</td><td>（連携用）家族マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteikikanx5 zrnkazokumaruteikikanx5}</td><td>（連携用）家族マル定期間＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiphrkkknx5 zrnkazokumrtiphrkkknx5}</td><td>（連携用）家族マル定Ｐ払込期間＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteisx5 zrnkazokumaruteisx5}</td><td>（連携用）家族マル定Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteipx5 zrnkazokumaruteipx5}</td><td>（連携用）家族マル定Ｐ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyanmx5 zrnkzkmrtihihknsyanmx5}</td><td>（連携用）家族マル定被保険者名＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyseiymdx5 zrnkzkmrtihihknsyseiymdx5}</td><td>（連携用）家族マル定被保険者生年月日＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsysibtkbnx5 zrnkzkmrtihihknsysibtkbnx5}</td><td>（連携用）家族マル定被保険者性別区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtihihknsyaagex5 zrnkazokumrtihihknsyaagex5}</td><td>（連携用）家族マル定被保険者年令＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtimodsx5 zrnkzkmrtimodsx5}</td><td>（連携用）家族マル定修正Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtimodsskgnhyjx5 zrnkazokumrtimodsskgnhyjx5}</td><td>（連携用）家族マル定修正Ｓ削減表示＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitnknyugukbnx5 zrnkzkmrtitnknyugukbnx5}</td><td>（連携用）家族マル定転換優遇区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtikgusdkbnx5 zrnkazokumrtikgusdkbnx5}</td><td>（連携用）家族マル定記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiagetyusihyjx5 zrnkazokumrtiagetyusihyjx5}</td><td>（連携用）家族マル定年令調整表示＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikusnmnryoagex5 zrnkzkmrtikusnmnryoagex5}</td><td>（連携用）家族マル定更新満了年令＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x5 zrnyobiv4x5}</td><td>（連携用）予備項目Ｖ４＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitkyknox6 zrnkzkmrtitkyknox6}</td><td>（連携用）家族マル定特約番号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtisyuruikgux6 zrnkazokumrtisyuruikgux6}</td><td>（連携用）家族マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteikikanx6 zrnkazokumaruteikikanx6}</td><td>（連携用）家族マル定期間＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiphrkkknx6 zrnkazokumrtiphrkkknx6}</td><td>（連携用）家族マル定Ｐ払込期間＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteisx6 zrnkazokumaruteisx6}</td><td>（連携用）家族マル定Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteipx6 zrnkazokumaruteipx6}</td><td>（連携用）家族マル定Ｐ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyanmx6 zrnkzkmrtihihknsyanmx6}</td><td>（連携用）家族マル定被保険者名＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyseiymdx6 zrnkzkmrtihihknsyseiymdx6}</td><td>（連携用）家族マル定被保険者生年月日＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsysibtkbnx6 zrnkzkmrtihihknsysibtkbnx6}</td><td>（連携用）家族マル定被保険者性別区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtihihknsyaagex6 zrnkazokumrtihihknsyaagex6}</td><td>（連携用）家族マル定被保険者年令＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtimodsx6 zrnkzkmrtimodsx6}</td><td>（連携用）家族マル定修正Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtimodsskgnhyjx6 zrnkazokumrtimodsskgnhyjx6}</td><td>（連携用）家族マル定修正Ｓ削減表示＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitnknyugukbnx6 zrnkzkmrtitnknyugukbnx6}</td><td>（連携用）家族マル定転換優遇区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtikgusdkbnx6 zrnkazokumrtikgusdkbnx6}</td><td>（連携用）家族マル定記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiagetyusihyjx6 zrnkazokumrtiagetyusihyjx6}</td><td>（連携用）家族マル定年令調整表示＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikusnmnryoagex6 zrnkzkmrtikusnmnryoagex6}</td><td>（連携用）家族マル定更新満了年令＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x6 zrnyobiv4x6}</td><td>（連携用）予備項目Ｖ４＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitkyknox7 zrnkzkmrtitkyknox7}</td><td>（連携用）家族マル定特約番号＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtisyuruikgux7 zrnkazokumrtisyuruikgux7}</td><td>（連携用）家族マル定種類記号＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteikikanx7 zrnkazokumaruteikikanx7}</td><td>（連携用）家族マル定期間＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiphrkkknx7 zrnkazokumrtiphrkkknx7}</td><td>（連携用）家族マル定Ｐ払込期間＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteisx7 zrnkazokumaruteisx7}</td><td>（連携用）家族マル定Ｓ＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteipx7 zrnkazokumaruteipx7}</td><td>（連携用）家族マル定Ｐ＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyanmx7 zrnkzkmrtihihknsyanmx7}</td><td>（連携用）家族マル定被保険者名＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyseiymdx7 zrnkzkmrtihihknsyseiymdx7}</td><td>（連携用）家族マル定被保険者生年月日＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsysibtkbnx7 zrnkzkmrtihihknsysibtkbnx7}</td><td>（連携用）家族マル定被保険者性別区分＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtihihknsyaagex7 zrnkazokumrtihihknsyaagex7}</td><td>（連携用）家族マル定被保険者年令＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtimodsx7 zrnkzkmrtimodsx7}</td><td>（連携用）家族マル定修正Ｓ＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtimodsskgnhyjx7 zrnkazokumrtimodsskgnhyjx7}</td><td>（連携用）家族マル定修正Ｓ削減表示＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitnknyugukbnx7 zrnkzkmrtitnknyugukbnx7}</td><td>（連携用）家族マル定転換優遇区分＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtikgusdkbnx7 zrnkazokumrtikgusdkbnx7}</td><td>（連携用）家族マル定記号世代区分＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiagetyusihyjx7 zrnkazokumrtiagetyusihyjx7}</td><td>（連携用）家族マル定年令調整表示＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikusnmnryoagex7 zrnkzkmrtikusnmnryoagex7}</td><td>（連携用）家族マル定更新満了年令＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x7 zrnyobiv4x7}</td><td>（連携用）予備項目Ｖ４＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitkyknox8 zrnkzkmrtitkyknox8}</td><td>（連携用）家族マル定特約番号＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtisyuruikgux8 zrnkazokumrtisyuruikgux8}</td><td>（連携用）家族マル定種類記号＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteikikanx8 zrnkazokumaruteikikanx8}</td><td>（連携用）家族マル定期間＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiphrkkknx8 zrnkazokumrtiphrkkknx8}</td><td>（連携用）家族マル定Ｐ払込期間＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteisx8 zrnkazokumaruteisx8}</td><td>（連携用）家族マル定Ｓ＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteipx8 zrnkazokumaruteipx8}</td><td>（連携用）家族マル定Ｐ＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyanmx8 zrnkzkmrtihihknsyanmx8}</td><td>（連携用）家族マル定被保険者名＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyseiymdx8 zrnkzkmrtihihknsyseiymdx8}</td><td>（連携用）家族マル定被保険者生年月日＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsysibtkbnx8 zrnkzkmrtihihknsysibtkbnx8}</td><td>（連携用）家族マル定被保険者性別区分＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtihihknsyaagex8 zrnkazokumrtihihknsyaagex8}</td><td>（連携用）家族マル定被保険者年令＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtimodsx8 zrnkzkmrtimodsx8}</td><td>（連携用）家族マル定修正Ｓ＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtimodsskgnhyjx8 zrnkazokumrtimodsskgnhyjx8}</td><td>（連携用）家族マル定修正Ｓ削減表示＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitnknyugukbnx8 zrnkzkmrtitnknyugukbnx8}</td><td>（連携用）家族マル定転換優遇区分＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtikgusdkbnx8 zrnkazokumrtikgusdkbnx8}</td><td>（連携用）家族マル定記号世代区分＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiagetyusihyjx8 zrnkazokumrtiagetyusihyjx8}</td><td>（連携用）家族マル定年令調整表示＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikusnmnryoagex8 zrnkzkmrtikusnmnryoagex8}</td><td>（連携用）家族マル定更新満了年令＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x8 zrnyobiv4x8}</td><td>（連携用）予備項目Ｖ４＿８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitkyknox9 zrnkzkmrtitkyknox9}</td><td>（連携用）家族マル定特約番号＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtisyuruikgux9 zrnkazokumrtisyuruikgux9}</td><td>（連携用）家族マル定種類記号＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteikikanx9 zrnkazokumaruteikikanx9}</td><td>（連携用）家族マル定期間＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiphrkkknx9 zrnkazokumrtiphrkkknx9}</td><td>（連携用）家族マル定Ｐ払込期間＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteisx9 zrnkazokumaruteisx9}</td><td>（連携用）家族マル定Ｓ＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteipx9 zrnkazokumaruteipx9}</td><td>（連携用）家族マル定Ｐ＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyanmx9 zrnkzkmrtihihknsyanmx9}</td><td>（連携用）家族マル定被保険者名＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyseiymdx9 zrnkzkmrtihihknsyseiymdx9}</td><td>（連携用）家族マル定被保険者生年月日＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsysibtkbnx9 zrnkzkmrtihihknsysibtkbnx9}</td><td>（連携用）家族マル定被保険者性別区分＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtihihknsyaagex9 zrnkazokumrtihihknsyaagex9}</td><td>（連携用）家族マル定被保険者年令＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtimodsx9 zrnkzkmrtimodsx9}</td><td>（連携用）家族マル定修正Ｓ＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtimodsskgnhyjx9 zrnkazokumrtimodsskgnhyjx9}</td><td>（連携用）家族マル定修正Ｓ削減表示＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitnknyugukbnx9 zrnkzkmrtitnknyugukbnx9}</td><td>（連携用）家族マル定転換優遇区分＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtikgusdkbnx9 zrnkazokumrtikgusdkbnx9}</td><td>（連携用）家族マル定記号世代区分＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiagetyusihyjx9 zrnkazokumrtiagetyusihyjx9}</td><td>（連携用）家族マル定年令調整表示＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikusnmnryoagex9 zrnkzkmrtikusnmnryoagex9}</td><td>（連携用）家族マル定更新満了年令＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x9 zrnyobiv4x9}</td><td>（連携用）予備項目Ｖ４＿９</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitkyknox10 zrnkzkmrtitkyknox10}</td><td>（連携用）家族マル定特約番号＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtisyuruikgux10 zrnkazokumrtisyuruikgux10}</td><td>（連携用）家族マル定種類記号＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteikikanx10 zrnkazokumaruteikikanx10}</td><td>（連携用）家族マル定期間＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiphrkkknx10 zrnkazokumrtiphrkkknx10}</td><td>（連携用）家族マル定Ｐ払込期間＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteisx10 zrnkazokumaruteisx10}</td><td>（連携用）家族マル定Ｓ＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumaruteipx10 zrnkazokumaruteipx10}</td><td>（連携用）家族マル定Ｐ＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyanmx10 zrnkzkmrtihihknsyanmx10}</td><td>（連携用）家族マル定被保険者名＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsyseiymdx10 zrnkzkmrtihihknsyseiymdx10}</td><td>（連携用）家族マル定被保険者生年月日＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtihihknsysibtkbnx10 zrnkzkmrtihihknsysibtkbnx10}</td><td>（連携用）家族マル定被保険者性別区分＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtihihknsyaagex10 zrnkazokumrtihihknsyaagex10}</td><td>（連携用）家族マル定被保険者年令＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtimodsx10 zrnkzkmrtimodsx10}</td><td>（連携用）家族マル定修正Ｓ＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtimodsskgnhyjx10 zrnkazokumrtimodsskgnhyjx10}</td><td>（連携用）家族マル定修正Ｓ削減表示＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtitnknyugukbnx10 zrnkzkmrtitnknyugukbnx10}</td><td>（連携用）家族マル定転換優遇区分＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtikgusdkbnx10 zrnkazokumrtikgusdkbnx10}</td><td>（連携用）家族マル定記号世代区分＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkazokumrtiagetyusihyjx10 zrnkazokumrtiagetyusihyjx10}</td><td>（連携用）家族マル定年令調整表示＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtikusnmnryoagex10 zrnkzkmrtikusnmnryoagex10}</td><td>（連携用）家族マル定更新満了年令＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x10 zrnyobiv4x10}</td><td>（連携用）予備項目Ｖ４＿１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrtkykhuhokbnx1 zrnnkshrtkykhuhokbnx1}</td><td>（連携用）年金支払特約付保区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrtkyknksyuruikbnx1 zrnnkshrtkyknksyuruikbnx1}</td><td>（連携用）年金支払特約年金種類区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrtkyknkkknx1 zrnnkshrtkyknkkknx1}</td><td>（連携用）年金支払特約年金期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrtkyknknengkx1 zrnnkshrtkyknknengkx1}</td><td>（連携用）年金支払特約年金年額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnkshrtkykduketorihhkbnx1 zrnnkshrtkykduketorihhkbnx1}</td><td>（連携用）年金支払特約Ｄ受取方法区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10 zrnyobiv10}</td><td>（連携用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrtkykhuhokbnx2 zrnnkshrtkykhuhokbnx2}</td><td>（連携用）年金支払特約付保区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrtkyknksyuruikbnx2 zrnnkshrtkyknksyuruikbnx2}</td><td>（連携用）年金支払特約年金種類区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrtkyknkkknx2 zrnnkshrtkyknkkknx2}</td><td>（連携用）年金支払特約年金期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnkshrtkyknknengkx2 zrnnkshrtkyknknengkx2}</td><td>（連携用）年金支払特約年金年額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnkshrtkykduketorihhkbnx2 zrnnkshrtkykduketorihhkbnx2}</td><td>（連携用）年金支払特約Ｄ受取方法区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x2 zrnyobiv10x2}</td><td>（連携用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyougaitkyksyuruikgu zrnsyougaitkyksyuruikgu}</td><td>（連携用）傷害特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyougaitokuyakukikan zrnsyougaitokuyakukikan}</td><td>（連携用）傷害特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyougaitkykphrkkkn zrnsyougaitkykphrkkkn}</td><td>（連携用）傷害特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyougaitokuyakus zrnsyougaitokuyakus}</td><td>（連携用）傷害特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyougaitokuyakup zrnsyougaitokuyakup}</td><td>（連携用）傷害特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyougaitkkatakbn zrnsyougaitkkatakbn}</td><td>（連携用）傷害特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyougaitkykkgusdkbn zrnsyougaitkykkgusdkbn}</td><td>（連携用）傷害特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyugitkykpwrbkkbn zrnsyugitkykpwrbkkbn}</td><td>（連携用）傷害特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyougaitkykkusnmnryoage zrnsyougaitkykkusnmnryoage}</td><td>（連携用）傷害特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5x2 zrnyobiv5x2}</td><td>（連携用）予備項目Ｖ５＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsigiwrmstkyksyuruikgu zrnsigiwrmstkyksyuruikgu}</td><td>（連携用）災害割増特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsigiwrmstkykkkn zrnsigiwrmstkykkkn}</td><td>（連携用）災害割増特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaigaiwrmstkykphrkkkn zrnsaigaiwrmstkykphrkkkn}</td><td>（連携用）災害割増特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaigaiwarimasitokuyakus zrnsaigaiwarimasitokuyakus}</td><td>（連携用）災害割増特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaigaiwarimasitokuyakup zrnsaigaiwarimasitokuyakup}</td><td>（連携用）災害割増特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaigaiwrmstkykkgusdkbn zrnsaigaiwrmstkykkgusdkbn}</td><td>（連携用）災害割増特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsigiwrmstkykpwrbkkbn zrnsigiwrmstkykpwrbkkbn}</td><td>（連携用）災害割増特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsigiwrmstkykkusnmnryoage zrnsigiwrmstkykkusnmnryoage}</td><td>（連携用）災害割増特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv5x3 zrnyobiv5x3}</td><td>（連携用）予備項目Ｖ５＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkyksyuruikgu zrnsiginyuintkyksyuruikgu}</td><td>（連携用）災害入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkykkkn zrnsiginyuintkykkkn}</td><td>（連携用）災害入院特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaigainyuintkykphrkkkn zrnsaigainyuintkykphrkkkn}</td><td>（連携用）災害入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkykntgk zrnsiginyuintkykntgk}</td><td>（連携用）災害入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkykgtkbn zrnsiginyuintkykgtkbn}</td><td>（連携用）災害入院特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaigainyuuintokuyakup zrnsaigainyuuintokuyakup}</td><td>（連携用）災害入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsaigainyuintkykkgusdkbn zrnsaigainyuintkykkgusdkbn}</td><td>（連携用）災害入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiginyuintkykpwrbkkbn zrnsiginyuintkykpwrbkkbn}</td><td>（連携用）災害入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7 zrnyobiv7}</td><td>（連携用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkyksyuruikgu zrnsppinyuintkyksyuruikgu}</td><td>（連携用）疾病入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkykkkn zrnsppinyuintkykkkn}</td><td>（連携用）疾病入院特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuuintkykphrkkkn zrnsppinyuuintkykphrkkkn}</td><td>（連携用）疾病入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkykntgk zrnsppinyuintkykntgk}</td><td>（連携用）疾病入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkykgtkbn zrnsppinyuintkykgtkbn}</td><td>（連携用）疾病入院特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsippeinyuuintokuyakup zrnsippeinyuuintokuyakup}</td><td>（連携用）疾病入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkjyuryumshyutn zrnsppinyuintkjyuryumshyutn}</td><td>（連携用）疾病入院特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsippeinyuuintokujyoup zrnsippeinyuuintokujyoup}</td><td>（連携用）疾病入院特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintktbicdx1 zrnsppinyuintktbicdx1}</td><td>（連携用）疾病入院特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuinhtnpkknx1 zrnsppinyuinhtnpkknx1}</td><td>（連携用）疾病入院不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintktbicdx2 zrnsppinyuintktbicdx2}</td><td>（連携用）疾病入院特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuinhtnpkknx2 zrnsppinyuinhtnpkknx2}</td><td>（連携用）疾病入院不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuuintkykkgusdkbn zrnsppinyuuintkykkgusdkbn}</td><td>（連携用）疾病入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsppinyuintkykpwrbkkbn zrnsppinyuintkykpwrbkkbn}</td><td>（連携用）疾病入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv7x2 zrnyobiv7x2}</td><td>（連携用）予備項目Ｖ７＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkyksyuruikgu zrnsijnbyutkyksyuruikgu}</td><td>（連携用）成人病特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseijinbyoutokuyakukikan zrnseijinbyoutokuyakukikan}</td><td>（連携用）成人病特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseijinbyoutkykphrkkkn zrnseijinbyoutkykphrkkkn}</td><td>（連携用）成人病特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseijinbyoutokuyakuntgk zrnseijinbyoutokuyakuntgk}</td><td>（連携用）成人病特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseijinbyoutokuyakup zrnseijinbyoutokuyakup}</td><td>（連携用）成人病特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkjyuryumshyutn zrnsijnbyutkjyuryumshyutn}</td><td>（連携用）成人病特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnseijinbyoutokujyoup zrnseijinbyoutokujyoup}</td><td>（連携用）成人病特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseijinbyoutokuteibuicdx1 zrnseijinbyoutokuteibuicdx1}</td><td>（連携用）成人病特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseijinbyouhutanpokikanx1 zrnseijinbyouhutanpokikanx1}</td><td>（連携用）成人病不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseijinbyoutokuteibuicdx2 zrnseijinbyoutokuteibuicdx2}</td><td>（連携用）成人病特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseijinbyouhutanpokikanx2 zrnseijinbyouhutanpokikanx2}</td><td>（連携用）成人病不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseijinbyoutkykkgusdkbn zrnseijinbyoutkykkgusdkbn}</td><td>（連携用）成人病特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkykgankyuhgtkbn zrnsijnbyutkykgankyuhgtkbn}</td><td>（連携用）成人病特約ガン給付型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkykpwrbkkbn zrnsijnbyutkykpwrbkkbn}</td><td>（連携用）成人病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsijnbyutkykkusnmnryoage zrnsijnbyutkykkusnmnryoage}</td><td>（連携用）成人病特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv4x11 zrnyobiv4x11}</td><td>（連携用）予備項目Ｖ４＿１１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheiyoubaraikbn zrnheiyoubaraikbn}</td><td>（連携用）併用払区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhiyubriaitsyono zrnhiyubriaitsyono}</td><td>（連携用）併用払相手証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhiyubriaithrkkeirokbn zrnhiyubriaithrkkeirokbn}</td><td>（連携用）併用払相手払込経路区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnheiyoubaraiaitekihons zrnheiyoubaraiaitekihons}</td><td>（連携用）併用払相手基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhiyubrigukitnknitjbrkhns zrnhiyubrigukitnknitjbrkhns}</td><td>（連携用）併用払合計転換一時払基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnheiyoubaraiaitesibous zrnheiyoubaraiaitesibous}</td><td>（連携用）併用払相手死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhiyubrigukitnknitjbrsbus zrnhiyubrigukitnknitjbrsbus}</td><td>（連携用）併用払合計転換一時払死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnheiyoubaraiaitesyuuseis zrnheiyoubaraiaitesyuuseis}</td><td>（連携用）併用払相手修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnheiyoubaraiaitehrkp zrnheiyoubaraiaitehrkp}</td><td>（連携用）併用払相手払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhiyubriaitsykykp zrnhiyubriaitsykykp}</td><td>（連携用）併用払相手主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnheiyoubaraiaitemrtis zrnheiyoubaraiaitemrtis}</td><td>（連携用）併用払相手マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhiyubrigukiaitkzkmrtis zrnhiyubrigukiaitkzkmrtis}</td><td>（連携用）併用払合計相手家族マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntukibaraikyktenkanhyj zrntukibaraikyktenkanhyj}</td><td>（連携用）月払契約転換表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbonusharaihrkkigetu1 zrnbonusharaihrkkigetu1}</td><td>（連携用）ボーナス払払込期月１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbonusharaihrkkigetu2 zrnbonusharaihrkkigetu2}</td><td>（連携用）ボーナス払払込期月２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhiyubriaitsiznmrtis zrnhiyubriaitsiznmrtis}</td><td>（連携用）併用払相手生存マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhiyubriaittignmrtis zrnhiyubriaittignmrtis}</td><td>（連携用）併用払相手逓減マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntkjykbn zrntkjykbn}</td><td>（連携用）特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakugenkikan zrnsakugenkikan}</td><td>（連携用）削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnryoumasihyouten zrnryoumasihyouten}</td><td>（連携用）料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntokujyoup zrntokujyoup}</td><td>（連携用）特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnhjncd zrnhjncd}</td><td>（連携用）法人コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhjnjigyosyocd zrnhjnjigyosyocd}</td><td>（連携用）法人事業所コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyuugyouinsuu zrnjyuugyouinsuu}</td><td>（連携用）従業員数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrniktkaisuu zrniktkaisuu}</td><td>（連携用）一括回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnznnkai zrnznnkai}</td><td>（連携用）前納回数</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktsnatkitkykkbn zrnkyktsnatkitkykkbn}</td><td>（連携用）契約通算扱特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyktsnatkitkykstagekbn zrnkyktsnatkitkykstagekbn}</td><td>（連携用）契約通算扱特約ステージ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnpmentokuyakukbn zrnpmentokuyakukbn}</td><td>（連携用）Ｐ免特約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3 zrnyobiv3}</td><td>（連携用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntkykznnunyukngk zrntkykznnunyukngk}</td><td>（連携用）特約前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyokaipnyuukinhouhoukbn zrnsyokaipnyuukinhouhoukbn}</td><td>（連携用）初回Ｐ入金方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksyonox1 zrnhtnknkyksyonox1}</td><td>（連携用）被転換契約証券番号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknsyuruikgux1 zrnhtnknkykhknsyuruikgux1}</td><td>（連携用）被転換契約保険種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanuketukeymdx1 zrntenkanuketukeymdx1}</td><td>（連携用）転換受付年月日＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkykymdx1 zrnhtnknkykkykymdx1}</td><td>（連携用）被転換契約契約年月日＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknkknx1 zrnhtnknkykhknkknx1}</td><td>（連携用）被転換契約保険期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykphrkkknx1 zrnhtnknkykphrkkknx1}</td><td>（連携用）被転換契約Ｐ払込期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkaisuukbnx1 zrnhtnknkykhrkkaisuukbnx1}</td><td>（連携用）被転換契約払込回数区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkeirokbnx1 zrnhtnknkykhrkkeirokbnx1}</td><td>（連携用）被転換契約払込経路区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknuktkzngtkijyuhyjx1 zrntnknuktkzngtkijyuhyjx1}</td><td>（連携用）転換受付前月計上表示＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykmrtisyuruikgux1 zrnhtnknkykmrtisyuruikgux1}</td><td>（連携用）被転換契約マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksyonox2 zrnhtnknkyksyonox2}</td><td>（連携用）被転換契約証券番号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknsyuruikgux2 zrnhtnknkykhknsyuruikgux2}</td><td>（連携用）被転換契約保険種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanuketukeymdx2 zrntenkanuketukeymdx2}</td><td>（連携用）転換受付年月日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkykymdx2 zrnhtnknkykkykymdx2}</td><td>（連携用）被転換契約契約年月日＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknkknx2 zrnhtnknkykhknkknx2}</td><td>（連携用）被転換契約保険期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykphrkkknx2 zrnhtnknkykphrkkknx2}</td><td>（連携用）被転換契約Ｐ払込期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkaisuukbnx2 zrnhtnknkykhrkkaisuukbnx2}</td><td>（連携用）被転換契約払込回数区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkeirokbnx2 zrnhtnknkykhrkkeirokbnx2}</td><td>（連携用）被転換契約払込経路区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknuktkzngtkijyuhyjx2 zrntnknuktkzngtkijyuhyjx2}</td><td>（連携用）転換受付前月計上表示＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykmrtisyuruikgux2 zrnhtnknkykmrtisyuruikgux2}</td><td>（連携用）被転換契約マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksyonox3 zrnhtnknkyksyonox3}</td><td>（連携用）被転換契約証券番号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknsyuruikgux3 zrnhtnknkykhknsyuruikgux3}</td><td>（連携用）被転換契約保険種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanuketukeymdx3 zrntenkanuketukeymdx3}</td><td>（連携用）転換受付年月日＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkykymdx3 zrnhtnknkykkykymdx3}</td><td>（連携用）被転換契約契約年月日＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknkknx3 zrnhtnknkykhknkknx3}</td><td>（連携用）被転換契約保険期間＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykphrkkknx3 zrnhtnknkykphrkkknx3}</td><td>（連携用）被転換契約Ｐ払込期間＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkaisuukbnx3 zrnhtnknkykhrkkaisuukbnx3}</td><td>（連携用）被転換契約払込回数区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkeirokbnx3 zrnhtnknkykhrkkeirokbnx3}</td><td>（連携用）被転換契約払込経路区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknuktkzngtkijyuhyjx3 zrntnknuktkzngtkijyuhyjx3}</td><td>（連携用）転換受付前月計上表示＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykmrtisyuruikgux3 zrnhtnknkykmrtisyuruikgux3}</td><td>（連携用）被転換契約マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksyonox4 zrnhtnknkyksyonox4}</td><td>（連携用）被転換契約証券番号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknsyuruikgux4 zrnhtnknkykhknsyuruikgux4}</td><td>（連携用）被転換契約保険種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanuketukeymdx4 zrntenkanuketukeymdx4}</td><td>（連携用）転換受付年月日＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkykymdx4 zrnhtnknkykkykymdx4}</td><td>（連携用）被転換契約契約年月日＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknkknx4 zrnhtnknkykhknkknx4}</td><td>（連携用）被転換契約保険期間＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykphrkkknx4 zrnhtnknkykphrkkknx4}</td><td>（連携用）被転換契約Ｐ払込期間＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkaisuukbnx4 zrnhtnknkykhrkkaisuukbnx4}</td><td>（連携用）被転換契約払込回数区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkeirokbnx4 zrnhtnknkykhrkkeirokbnx4}</td><td>（連携用）被転換契約払込経路区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknuktkzngtkijyuhyjx4 zrntnknuktkzngtkijyuhyjx4}</td><td>（連携用）転換受付前月計上表示＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykmrtisyuruikgux4 zrnhtnknkykmrtisyuruikgux4}</td><td>（連携用）被転換契約マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksyonox5 zrnhtnknkyksyonox5}</td><td>（連携用）被転換契約証券番号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknsyuruikgux5 zrnhtnknkykhknsyuruikgux5}</td><td>（連携用）被転換契約保険種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanuketukeymdx5 zrntenkanuketukeymdx5}</td><td>（連携用）転換受付年月日＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkykymdx5 zrnhtnknkykkykymdx5}</td><td>（連携用）被転換契約契約年月日＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknkknx5 zrnhtnknkykhknkknx5}</td><td>（連携用）被転換契約保険期間＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykphrkkknx5 zrnhtnknkykphrkkknx5}</td><td>（連携用）被転換契約Ｐ払込期間＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkaisuukbnx5 zrnhtnknkykhrkkaisuukbnx5}</td><td>（連携用）被転換契約払込回数区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkeirokbnx5 zrnhtnknkykhrkkeirokbnx5}</td><td>（連携用）被転換契約払込経路区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknuktkzngtkijyuhyjx5 zrntnknuktkzngtkijyuhyjx5}</td><td>（連携用）転換受付前月計上表示＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykmrtisyuruikgux5 zrnhtnknkykmrtisyuruikgux5}</td><td>（連携用）被転換契約マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksyonox6 zrnhtnknkyksyonox6}</td><td>（連携用）被転換契約証券番号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknsyuruikgux6 zrnhtnknkykhknsyuruikgux6}</td><td>（連携用）被転換契約保険種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanuketukeymdx6 zrntenkanuketukeymdx6}</td><td>（連携用）転換受付年月日＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykkykymdx6 zrnhtnknkykkykymdx6}</td><td>（連携用）被転換契約契約年月日＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhknkknx6 zrnhtnknkykhknkknx6}</td><td>（連携用）被転換契約保険期間＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykphrkkknx6 zrnhtnknkykphrkkknx6}</td><td>（連携用）被転換契約Ｐ払込期間＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkaisuukbnx6 zrnhtnknkykhrkkaisuukbnx6}</td><td>（連携用）被転換契約払込回数区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhrkkeirokbnx6 zrnhtnknkykhrkkeirokbnx6}</td><td>（連携用）被転換契約払込経路区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntnknuktkzngtkijyuhyjx6 zrntnknuktkzngtkijyuhyjx6}</td><td>（連携用）転換受付前月計上表示＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykmrtisyuruikgux6 zrnhtnknkykmrtisyuruikgux6}</td><td>（連携用）被転換契約マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngukihtnknkykkhns zrngukihtnknkykkhns}</td><td>（連携用）合計被転換契約基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukihtnknkyksbus zrngukihtnknkyksbus}</td><td>（連携用）合計被転換契約死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukihtnknkykhntiyup zrngukihtnknkykhntiyup}</td><td>（連携用）合計被転換契約判定用Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukihtnknkyksigwrmstkyks zrngukihtnknkyksigwrmstkyks}</td><td>（連携用）合計被転換契約災害割増特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukihtnknkyksyugitkyks zrngukihtnknkyksyugitkyks}</td><td>（連携用）合計被転換契約傷害特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukihtnknsignyintkykntgk zrngukihtnknsignyintkykntgk}</td><td>（連携用）合計被転換災害入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrngukihtnknknkutkykntgk zrngukihtnknknkutkykntgk}</td><td>（連携用）合計被転換健康特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrngukihtnknkykmods zrngukihtnknkykmods}</td><td>（連携用）合計被転換契約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkankakaku zrngoukeitenkankakaku}</td><td>（連携用）合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukitnknjsknnjynbkn zrngukitnknjsknnjynbkn}</td><td>（連携用）合計転換時責任準備金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukitnknsisnkstkkngk zrngukitnknsisnkstkkngk}</td><td>（連携用）合計転換精算貸付金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukitnknsisnttkekngk zrngukitnknsisnttkekngk}</td><td>（連携用）合計転換精算立替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngoukeitenkanseisand zrngoukeitenkanseisand}</td><td>（連携用）合計転換精算Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukitnknsisnmkikp zrngukitnknsisnmkikp}</td><td>（連携用）合計転換精算未経過Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukitnknsisnsntkngk zrngukitnknsisnsntkngk}</td><td>（連携用）合計転換精算その他金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukitnknkhnbbnkiykkujygk zrngukitnknkhnbbnkiykkujygk}</td><td>（連携用）合計転換基本部分解約控除額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukitnkntikbbnkiykkujygk zrngukitnkntikbbnkiykkujygk}</td><td>（連携用）合計転換定期部分解約控除額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngukitnknitjbrtiks zrngukitnknitjbrtiks}</td><td>（連携用）合計転換一時払定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsethokenno zrnsethokenno}</td><td>（連携用）セット保険番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsckbn zrnsckbn}</td><td>（連携用）ＳＣ区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnenjyosyacd zrnenjyosyacd}</td><td>（連携用）援助者コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnaibuwarimodosigaku zrnnaibuwarimodosigaku}</td><td>（連携用）内部割戻額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkeiyakukakuninsyuruikbn zrnkeiyakukakuninsyuruikbn}</td><td>（連携用）契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsoujikeitenkanhyouji zrnsoujikeitenkanhyouji}</td><td>（連携用）相似形転換表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntenkanjisketteihouhoukbn zrntenkanjisketteihouhoukbn}</td><td>（連携用）転換時Ｓ決定方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeikanensuukbn zrnkeikanensuukbn}</td><td>（連携用）経過年数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhhknsytisyukbnx1 zrnhtnknkykhhknsytisyukbnx1}</td><td>（連携用）被転換契約被保険者対象区分＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhhknsytisyukbnx2 zrnhtnknkykhhknsytisyukbnx2}</td><td>（連携用）被転換契約被保険者対象区分＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhhknsytisyukbnx3 zrnhtnknkykhhknsytisyukbnx3}</td><td>（連携用）被転換契約被保険者対象区分＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhhknsytisyukbnx4 zrnhtnknkykhhknsytisyukbnx4}</td><td>（連携用）被転換契約被保険者対象区分＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhhknsytisyukbnx5 zrnhtnknkykhhknsytisyukbnx5}</td><td>（連携用）被転換契約被保険者対象区分＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykhhknsytisyukbnx6 zrnhtnknkykhhknsytisyukbnx6}</td><td>（連携用）被転換契約被保険者対象区分＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkktijgukipbbntnkns zrnkktijgukipbbntnkns}</td><td>（連携用）確定時合計Ｐ部分転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyonendosyokaip zrnsyonendosyokaip}</td><td>（連携用）初年度初回Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyonendo2kaimeikoup zrnsyonendo2kaimeikoup}</td><td>（連携用）初年度２回目以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnjinendoikoup zrnjinendoikoup}</td><td>（連携用）次年度以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyukeiyakusikyuukisogaku zrnsyukeiyakusikyuukisogaku}</td><td>（連携用）主契約支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsykyknenhantatskyuksgk zrnsykyknenhantatskyuksgk}</td><td>（連携用）主契約年半手当支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnmaruteisikyuukisogaku zrnmaruteisikyuukisogaku}</td><td>（連携用）マル定支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnitjbrzugkskyuksgkx1 zrnitjbrzugkskyuksgkx1}</td><td>（連携用）一時払増額支給基礎額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnitjbrzugkskyuksgkx2 zrnitjbrzugkskyuksgkx2}</td><td>（連携用）一時払増額支給基礎額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnitjbrzgknnhntatskyksgkx1 zrnitjbrzgknnhntatskyksgkx1}</td><td>（連携用）一時払増額年半手当支給基礎額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnitjbrzgknnhntatskyksgkx2 zrnitjbrzgknnhntatskyksgkx2}</td><td>（連携用）一時払増額年半手当支給基礎額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnkzkmrtiskyuksgk zrnkzkmrtiskyuksgk}</td><td>（連携用）家族マル定支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnitibitjbrskyuksgk zrnitibitjbrskyuksgk}</td><td>（連携用）一部一時払支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnitbitjbrnnhntatskyuksgk zrnitbitjbrnnhntatskyuksgk}</td><td>（連携用）一部一時払年半手当支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsykykksnbsyutat zrnsykykksnbsyutat}</td><td>（連携用）主契約加算募集手当</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnitjbrzugkksnbsyutatx1 zrnitjbrzugkksnbsyutatx1}</td><td>（連携用）一時払増額加算募集手当＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnitjbrzugkksnbsyutatx2 zrnitjbrzugkksnbsyutatx2}</td><td>（連携用）一時払増額加算募集手当＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnitibitjbrksnbsyutat zrnitibitjbrksnbsyutat}</td><td>（連携用）一部一時払加算募集手当</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnjyunkensuu zrnjyunkensuu}</td><td>（連携用）純件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkansankensuu zrnkansankensuu}</td><td>（連携用）換算件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraikikan zrnitibuitijibaraikikan}</td><td>（連携用）一部一時払期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibarais zrnitibuitijibarais}</td><td>（連携用）一部一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraip zrnitibuitijibaraip}</td><td>（連携用）一部一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibitjbrsdtpdtkbn zrnitibitjbrsdtpdtkbn}</td><td>（連携用）一部一時払Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnitibuitijibaraisyuuseis zrnitibuitijibaraisyuuseis}</td><td>（連携用）一部一時払修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnitibitjbrmodsskgnhyj zrnitibitjbrmodsskgnhyj}</td><td>（連携用）一部一時払修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyousyoriym zrnsuuriyousyoriym}</td><td>（連携用）数理用処理年月</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyosinsinsahouhoukbn zrnsyosinsinsahouhoukbn}</td><td>（連携用）初診診査方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaisinsinsahouhoukbn zrnsaisinsinsahouhoukbn}</td><td>（連携用）再診診査方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmrtisyuruikgu zrnseizonmrtisyuruikgu}</td><td>（連携用）生存マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmaruteikikan zrnseizonmaruteikikan}</td><td>（連携用）生存マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmrtiphrkkkn zrnseizonmrtiphrkkkn}</td><td>（連携用）生存マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmaruteis zrnseizonmaruteis}</td><td>（連携用）生存マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseizonmaruteip zrnseizonmaruteip}</td><td>（連携用）生存マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseizonmaruteisyuuseis zrnseizonmaruteisyuuseis}</td><td>（連携用）生存マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnseizonmrtimodsskgnhyj zrnseizonmrtimodsskgnhyj}</td><td>（連携用）生存マル定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtitkjyukbn zrnsiznmrtitkjyukbn}</td><td>（連携用）生存マル定特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtitkjyuskgnkkn zrnsiznmrtitkjyuskgnkkn}</td><td>（連携用）生存マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtitkjyuryumshyutn zrnsiznmrtitkjyuryumshyutn}</td><td>（連携用）生存マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtitkjyup zrnsiznmrtitkjyup}</td><td>（連携用）生存マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtiskyuksgk zrnsiznmrtiskyuksgk}</td><td>（連携用）生存マル定支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiznmrtsyrikgux1 zrnhtnknkyksiznmrtsyrikgux1}</td><td>（連携用）被転換契約生存マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiznmrtsyrikgux2 zrnhtnknkyksiznmrtsyrikgux2}</td><td>（連携用）被転換契約生存マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiznmrtsyrikgux3 zrnhtnknkyksiznmrtsyrikgux3}</td><td>（連携用）被転換契約生存マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiznmrtsyrikgux4 zrnhtnknkyksiznmrtsyrikgux4}</td><td>（連携用）被転換契約生存マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiznmrtsyrikgux5 zrnhtnknkyksiznmrtsyrikgux5}</td><td>（連携用）被転換契約生存マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyksiznmrtsyrikgux6 zrnhtnknkyksiznmrtsyrikgux6}</td><td>（連携用）被転換契約生存マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuryusiznmrtipwrbkkbn zrnsuryusiznmrtipwrbkkbn}</td><td>（連携用）数理用生存マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtipwrbkkbn zrnsiznmrtipwrbkkbn}</td><td>（連携用）生存マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsiznmrtitnknyugukbn zrnsiznmrtitnknyugukbn}</td><td>（連携用）生存マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnseizonmrtikgusdkbn zrnseizonmrtikgusdkbn}</td><td>（連携用）生存マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1 zrnyobiv1}</td><td>（連携用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyamei zrndai2hihokensyamei}</td><td>（連携用）第２被保険者名</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2kanjihihokensyamei zrndai2kanjihihokensyamei}</td><td>（連携用）第２漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyaseiymd zrndai2hihokensyaseiymd}</td><td>（連携用）第２被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihokensyaseibetukbn zrndai2hihokensyaseibetukbn}</td><td>（連携用）第２被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihknsyahnskhkncd zrndai2hihknsyahnskhkncd}</td><td>（連携用）第２被保険者本籍府県コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hhknnen zrndai2hhknnen}</td><td>（連携用）第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2hihknsyakikykarihyj zrndai2hihknsyakikykarihyj}</td><td>（連携用）第２被保険者既契約有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyksydi2hihknsyaduithyj zrnkyksydi2hihknsyaduithyj}</td><td>（連携用）契約者第２被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2syosinsinsahouhoukbn zrndai2syosinsinsahouhoukbn}</td><td>（連携用）第２初診診査方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2saisinsinsahouhoukbn zrndai2saisinsinsahouhoukbn}</td><td>（連携用）第２再診診査方法区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2syokugyoucd zrndai2syokugyoucd}</td><td>（連携用）第２職業コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2sakugenkikan zrndai2sakugenkikan}</td><td>（連携用）第２削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2ryoumasihyouten zrndai2ryoumasihyouten}</td><td>（連携用）第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnmrtidi2skgnkkn zrnmrtidi2skgnkkn}</td><td>（連携用）マル定第２削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmrtidi2ryumshyutn zrnmrtidi2ryumshyutn}</td><td>（連携用）マル定第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndi2kykkknnsyrikbn zrndi2kykkknnsyrikbn}</td><td>（連携用）第２契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtidi2skgnkkn zrntignmrtidi2skgnkkn}</td><td>（連携用）逓減マル定第２削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtidi2ryumshyutn zrntignmrtidi2ryumshyutn}</td><td>（連携用）逓減マル定第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2syosinhonninkknnkbn zrndai2syosinhonninkknnkbn}</td><td>（連携用）第２初診本人確認区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sisnhonninkknnkbn zrndi2sisnhonninkknnkbn}</td><td>（連携用）第２再診本人確認区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x6 zrnyobiv9x6}</td><td>（連携用）予備項目Ｖ９＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2syugitkyksyrikgu zrndi2syugitkyksyrikgu}</td><td>（連携用）第２傷害特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2syougaitokuyakukikan zrndai2syougaitokuyakukikan}</td><td>（連携用）第２傷害特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2syugitkykphrkkkn zrndi2syugitkykphrkkkn}</td><td>（連携用）第２傷害特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2syougaitokuyakus zrndai2syougaitokuyakus}</td><td>（連携用）第２傷害特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndai2syougaitokuyakup zrndai2syougaitokuyakup}</td><td>（連携用）第２傷害特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2syugitkykgtkbn zrndi2syugitkykgtkbn}</td><td>（連携用）第２傷害特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2syugitkykkgusdkbn zrndi2syugitkykkgusdkbn}</td><td>（連携用）第２傷害特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2syugitkykpwrbkkbn zrndi2syugitkykpwrbkkbn}</td><td>（連携用）第２傷害特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8 zrnyobiv8}</td><td>（連携用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkyksyrikgu zrndi2sigiwrmstkyksyrikgu}</td><td>（連携用）第２災害割増特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkykkkn zrndi2sigiwrmstkykkkn}</td><td>（連携用）第２災害割増特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkykphrkkkn zrndi2sigiwrmstkykphrkkkn}</td><td>（連携用）第２災害割増特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkyks zrndi2sigiwrmstkyks}</td><td>（連携用）第２災害割増特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkykp zrndi2sigiwrmstkykp}</td><td>（連携用）第２災害割増特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkykkgusdkbn zrndi2sigiwrmstkykkgusdkbn}</td><td>（連携用）第２災害割増特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sigiwrmstkykpwrbkkbn zrndi2sigiwrmstkykpwrbkkbn}</td><td>（連携用）第２災害割増特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x7 zrnyobiv9x7}</td><td>（連携用）予備項目Ｖ９＿７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkyksyrikgu zrndi2siginyuintkyksyrikgu}</td><td>（連携用）第２災害入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykkkn zrndi2siginyuintkykkkn}</td><td>（連携用）第２災害入院特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykphrkkkn zrndi2siginyuintkykphrkkkn}</td><td>（連携用）第２災害入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykntgk zrndi2siginyuintkykntgk}</td><td>（連携用）第２災害入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykp zrndi2siginyuintkykp}</td><td>（連携用）第２災害入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykgtkbn zrndi2siginyuintkykgtkbn}</td><td>（連携用）第２災害入院特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyintkykkgusdkbn zrndi2siginyintkykkgusdkbn}</td><td>（連携用）第２災害入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2siginyuintkykpwrbkkbn zrndi2siginyuintkykpwrbkkbn}</td><td>（連携用）第２災害入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv10x3 zrnyobiv10x3}</td><td>（連携用）予備項目Ｖ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkyksyrikgu zrndi2sppinyuintkyksyrikgu}</td><td>（連携用）第２疾病入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykkkn zrndi2sppinyuintkykkkn}</td><td>（連携用）第２疾病入院特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykphrkkkn zrndi2sppinyuintkykphrkkkn}</td><td>（連携用）第２疾病入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykntgk zrndi2sppinyuintkykntgk}</td><td>（連携用）第２疾病入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykp zrndi2sppinyuintkykp}</td><td>（連携用）第２疾病入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykgtkbn zrndi2sppinyuintkykgtkbn}</td><td>（連携用）第２疾病入院特約型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyintkjyryumshytn zrndi2sppinyintkjyryumshytn}</td><td>（連携用）第２疾病入院特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkjyup zrndi2sppinyuintkjyup}</td><td>（連携用）第２疾病入院特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintktbicdx1 zrndi2sppinyuintktbicdx1}</td><td>（連携用）第２疾病入院特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuinhtnpkknx1 zrndi2sppinyuinhtnpkknx1}</td><td>（連携用）第２疾病入院不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintktbicdx2 zrndi2sppinyuintktbicdx2}</td><td>（連携用）第２疾病入院特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuinhtnpkknx2 zrndi2sppinyuinhtnpkknx2}</td><td>（連携用）第２疾病入院不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyintkykkgusdkbn zrndi2sppinyintkykkgusdkbn}</td><td>（連携用）第２疾病入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sppinyuintkykpwrbkkbn zrndi2sppinyuintkykpwrbkkbn}</td><td>（連携用）第２疾病入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3x2 zrnyobiv3x2}</td><td>（連携用）予備項目Ｖ３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkyksyrikgu zrndi2sijnbyutkyksyrikgu}</td><td>（連携用）第２成人病特約種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkykkkn zrndi2sijnbyutkykkkn}</td><td>（連携用）第２成人病特約期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkykphrkkkn zrndi2sijnbyutkykphrkkkn}</td><td>（連携用）第２成人病特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkykntgk zrndi2sijnbyutkykntgk}</td><td>（連携用）第２成人病特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2seijinbyoutokuyakup zrndai2seijinbyoutokuyakup}</td><td>（連携用）第２成人病特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkjyurymshytn zrndi2sijnbyutkjyurymshytn}</td><td>（連携用）第２成人病特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrndai2seijinbyoutokujyoup zrndai2seijinbyoutokujyoup}</td><td>（連携用）第２成人病特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutktbicdx1 zrndi2sijnbyutktbicdx1}</td><td>（連携用）第２成人病特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyuhtnpkknx1 zrndi2sijnbyuhtnpkknx1}</td><td>（連携用）第２成人病不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutktbicdx2 zrndi2sijnbyutktbicdx2}</td><td>（連携用）第２成人病特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyuhtnpkknx2 zrndi2sijnbyuhtnpkknx2}</td><td>（連携用）第２成人病不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkykkgusdkbn zrndi2sijnbyutkykkgusdkbn}</td><td>（連携用）第２成人病特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbytkykgankyhgtkbn zrndi2sijnbytkykgankyhgtkbn}</td><td>（連携用）第２成人病特約ガン給付型区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndi2sijnbyutkykpwrbkkbn zrndi2sijnbyutkykpwrbkkbn}</td><td>（連携用）第２成人病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv3x3 zrnyobiv3x3}</td><td>（連携用）予備項目Ｖ３＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2jyoukentukihyouji zrndai2jyoukentukihyouji}</td><td>（連携用）第２条件付表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtisyukgu zrntignmrtisyukgu}</td><td>（連携用）逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteikikan zrnteigenmaruteikikan}</td><td>（連携用）逓減マル定期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmrtiphrkkkn zrnteigenmrtiphrkkkn}</td><td>（連携用）逓減マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteis zrnteigenmaruteis}</td><td>（連携用）逓減マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteip zrnteigenmaruteip}</td><td>（連携用）逓減マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnteigenmaruteisyuuseis zrnteigenmaruteisyuuseis}</td><td>（連携用）逓減マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnteigenmrtimodssakugenhyj zrnteigenmrtimodssakugenhyj}</td><td>（連携用）逓減マル定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtitkjyukbn zrntignmrtitkjyukbn}</td><td>（連携用）逓減マル定特条区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtitkjyuskgnkkn zrntignmrtitkjyuskgnkkn}</td><td>（連携用）逓減マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtitkjyuryumshyutn zrntignmrtitkjyuryumshyutn}</td><td>（連携用）逓減マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntignmrtitkjyup zrntignmrtitkjyup}</td><td>（連携用）逓減マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntignmrtiskyuksgk zrntignmrtiskyuksgk}</td><td>（連携用）逓減マル定支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyktignmrtsyrikgux1 zrnhtnknkyktignmrtsyrikgux1}</td><td>（連携用）被転換契約逓減マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyktignmrtsyrikgux2 zrnhtnknkyktignmrtsyrikgux2}</td><td>（連携用）被転換契約逓減マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyktignmrtsyrikgux3 zrnhtnknkyktignmrtsyrikgux3}</td><td>（連携用）被転換契約逓減マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyktignmrtsyrikgux4 zrnhtnknkyktignmrtsyrikgux4}</td><td>（連携用）被転換契約逓減マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyktignmrtsyrikgux5 zrnhtnknkyktignmrtsyrikgux5}</td><td>（連携用）被転換契約逓減マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkyktignmrtsyrikgux6 zrnhtnknkyktignmrtsyrikgux6}</td><td>（連携用）被転換契約逓減マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuryutignmrtipwrbkkbn zrnsuryutignmrtipwrbkkbn}</td><td>（連携用）数理用逓減マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtipwrbkkbn zrntignmrtipwrbkkbn}</td><td>（連携用）逓減マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntignmrtitnknyugukbn zrntignmrtitnknyugukbn}</td><td>（連携用）逓減マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnteigenmrtikgusdkbn zrnteigenmrtikgusdkbn}</td><td>（連携用）逓減マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv1x2 zrnyobiv1x2}</td><td>（連携用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntktsppisetkykkbn zrntktsppisetkykkbn}</td><td>（連携用）特定疾病セット契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnjyudmnsiskknsetkykkbn zrnjyudmnsiskknsetkykkbn}</td><td>（連携用）重度慢性疾患セット契約区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv8x2 zrnyobiv8x2}</td><td>（連携用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitesyono1 zrnsetaitesyono1}</td><td>（連携用）セット相手証券番号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitehokensyuruikigou1 zrnsetaitehokensyuruikigou1}</td><td>（連携用）セット相手保険種類記号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitemrtisyuruikgu1 zrnsetaitemrtisyuruikgu1}</td><td>（連携用）セット相手マル定種類記号１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitesiznmrtisyurui1 zrnsetaitesiznmrtisyurui1}</td><td>（連携用）セット相手生存マル定種類１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitetignmrtisyurui1 zrnsetaitetignmrtisyurui1}</td><td>（連携用）セット相手逓減マル定種類１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitekihonbubuns1 zrnsetaitekihonbubuns1}</td><td>（連携用）セット相手基本部分Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetgukitnknitjbrkhns1 zrnsetgukitnknitjbrkhns1}</td><td>（連携用）セット合計転換一時払基本Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitesibous1 zrnsetaitesibous1}</td><td>（連携用）セット相手死亡Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetgukitnknitjbrsbus1 zrnsetgukitnknitjbrsbus1}</td><td>（連携用）セット合計転換一時払死亡Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitesyuuseis1 zrnsetaitesyuuseis1}</td><td>（連携用）セット相手修正Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaiteharaikomip1 zrnsetaiteharaikomip1}</td><td>（連携用）セット相手払込Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitesyukeiyakububunp1 zrnsetaitesyukeiyakububunp1}</td><td>（連携用）セット相手主契約部分Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitgukikzkmrtis1 zrnsetaitgukikzkmrtis1}</td><td>（連携用）セット相手合計家族マル定Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitetenkankykhyj1 zrnsetaitetenkankykhyj1}</td><td>（連携用）セット相手転換契約表示１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsetaitesiteimhrkp1 zrnsetaitesiteimhrkp1}</td><td>（連携用）セット相手指定月払込Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitesiteimsykykp1 zrnsetaitesiteimsykykp1}</td><td>（連携用）セット相手指定月主契約Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsetaitenkmrtisyurui1 zrnsetaitenkmrtisyurui1}</td><td>（連携用）セット相手年金マル定種類１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv18 zrnyobiv18}</td><td>（連携用）予備項目Ｖ１８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_Skeiksnbsgetujisr1Rn
 * @see     PKZT_Skeiksnbsgetujisr1Rn
 * @see     QZT_Skeiksnbsgetujisr1Rn
 * @see     GenQZT_Skeiksnbsgetujisr1Rn
 */
@MappedSuperclass
@Table(name=GenZT_Skeiksnbsgetujisr1Rn.TABLE_NAME)
@IdClass(value=PKZT_Skeiksnbsgetujisr1Rn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Skeiksnbsgetujisr1Rn extends AbstractExDBEntityForZDB<ZT_Skeiksnbsgetujisr1Rn, PKZT_Skeiksnbsgetujisr1Rn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Skeiksnbsgetujisr1Rn";
    public static final String ZRNKTGYSYRYMD            = "zrnktgysyrymd";
    public static final String ZRNKTGYSYONO             = "zrnktgysyono";
    public static final String ZRNKTGYFILERENNO         = "zrnktgyfilerenno";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNAATUKAISYASISYACD     = "zrnaatukaisyasisyacd";
    public static final String ZRNMOSNO                 = "zrnmosno";
    public static final String ZRNHKNSYUKIGOU           = "zrnhknsyukigou";
    public static final String ZRNKYKYMD                = "zrnkykymd";
    public static final String ZRNHKNKKN                = "zrnhknkkn";
    public static final String ZRNPHRKKIKN              = "zrnphrkkikn";
    public static final String ZRNSAIMNKKYKHYJ          = "zrnsaimnkkykhyj";
    public static final String ZRNKIHONS                = "zrnkihons";
    public static final String ZRNSIBOUS                = "zrnsibous";
    public static final String ZRNGYOUSEKIHYOUKAYOUHOSYOUS = "zrngyousekihyoukayouhosyous";
    public static final String ZRNGUKITNKNITJBRKHNS     = "zrngukitnknitjbrkhns";
    public static final String ZRNGUKITNKNITJBRSBUS     = "zrngukitnknitjbrsbus";
    public static final String ZRNKKTIJGUKITNKNITJBRKHNS = "zrnkktijgukitnknitjbrkhns";
    public static final String ZRNKKTIJGUKITNKNITJBRSBUS = "zrnkktijgukitnknitjbrsbus";
    public static final String ZRNSYOKAIHARAIKOMIP      = "zrnsyokaiharaikomip";
    public static final String ZRNSYUKEIYAKUP           = "zrnsyukeiyakup";
    public static final String ZRNHRKKAISUUKBN          = "zrnhrkkaisuukbn";
    public static final String ZRNHRKKEIROKBN           = "zrnhrkkeirokbn";
    public static final String ZRNRYOURITUKBN           = "zrnryouritukbn";
    public static final String ZRNTKSYUANNAIKYKKBN      = "zrntksyuannaikykkbn";
    public static final String ZRNSDPDKBN               = "zrnsdpdkbn";
    public static final String ZRNANNISKCD              = "zrnanniskcd";
    public static final String ZRNDUKETORIHOUHOUKBN     = "zrnduketorihouhoukbn";
    public static final String ZRNKYKSYHHKNSYDOUITUHYOUJI = "zrnkyksyhhknsydouituhyouji";
    public static final String ZRNKYKSYAKIKYKARIHYJ     = "zrnkyksyakikykarihyj";
    public static final String ZRNTENKANKEIYAKUHYOUJI   = "zrntenkankeiyakuhyouji";
    public static final String ZRNJIGYOUKEIYAKUHYOUJI   = "zrnjigyoukeiyakuhyouji";
    public static final String ZRNNENKINZEISEITOKUYAKUKBN = "zrnnenkinzeiseitokuyakukbn";
    public static final String ZRNSYUSSEIMAEKANYUUKYKKBN = "zrnsyusseimaekanyuukykkbn";
    public static final String ZRNKAZOKUKEIYAKUHYOUJI   = "zrnkazokukeiyakuhyouji";
    public static final String ZRNJIKOKYKHYJ            = "zrnjikokykhyj";
    public static final String ZRNTUUSYOUMEISIYOUHYOUJI = "zrntuusyoumeisiyouhyouji";
    public static final String ZRNSETHOKENKBN           = "zrnsethokenkbn";
    public static final String ZRNTEIKEISYOUHINKBN      = "zrnteikeisyouhinkbn";
    public static final String ZRNSYKGYCD               = "zrnsykgycd";
    public static final String ZRNTOKUNINBOSYUUTEATE    = "zrntokuninbosyuuteate";
    public static final String ZRNSEISEKIYM             = "zrnseisekiym";
    public static final String ZRNSEISEKIKEIJYOUSYUUSEIS = "zrnseisekikeijyousyuuseis";
    public static final String ZRNSYUUSEISSAKUGENHYOUJI = "zrnsyuuseissakugenhyouji";
    public static final String ZRNAATUKAISISYATODOUHUKENCD = "zrnaatukaisisyatodouhukencd";
    public static final String ZRNAATUKAISOSIKICD       = "zrnaatukaisosikicd";
    public static final String ZRNAATUKAIKOJINCD        = "zrnaatukaikojincd";
    public static final String ZRNBATUKAISOSIKICD       = "zrnbatukaisosikicd";
    public static final String ZRNBATUKAISYAKOJINCD     = "zrnbatukaisyakojincd";
    public static final String ZRNMARUTOKUKBN           = "zrnmarutokukbn";
    public static final String ZRNGYOUMUJYOUHYOUJI      = "zrngyoumujyouhyouji";
    public static final String ZRNTUIKAKEIJYOUKBN       = "zrntuikakeijyoukbn";
    public static final String ZRNSEISEKINOMIKEIJYOUKBN = "zrnseisekinomikeijyoukbn";
    public static final String ZRNTEIKIKEIJYOUKBN       = "zrnteikikeijyoukbn";
    public static final String ZRNHNGKMSKKATKISYKBN     = "zrnhngkmskkatkisykbn";
    public static final String ZRNTNKNKYUUYOSAKUGENHYJ  = "zrntnknkyuuyosakugenhyj";
    public static final String ZRNTENKANKAISUU          = "zrntenkankaisuu";
    public static final String ZRNHIYUBRIGSSNSIKKIJYUNKBN = "zrnhiyubrigssnsikkijyunkbn";
    public static final String ZRNSEKININKAISIYMD       = "zrnsekininkaisiymd";
    public static final String ZRNKIGETUSMKRGKYKHYJ     = "zrnkigetusmkrgkykhyj";
    public static final String ZRNHENSYUUSYORIYMD       = "zrnhensyuusyoriymd";
    public static final String ZRNJISISYAATUKAIHYOUJI   = "zrnjisisyaatukaihyouji";
    public static final String ZRNAATKISYTKTNTUSY1ATKIHYJ = "zrnaatkisytktntusy1atkihyj";
    public static final String ZRNAATKISYTKTNTUSY2ATKIHYJ = "zrnaatkisytktntusy2atkihyj";
    public static final String ZRNAATKISYASYOKAN1ATKIHYJ = "zrnaatkisyasyokan1atkihyj";
    public static final String ZRNAATKISYASYOKAN2ATKIHYJ = "zrnaatkisyasyokan2atkihyj";
    public static final String ZRNBATKISYTKTNTUSY1ATKIHYJ = "zrnbatkisytktntusy1atkihyj";
    public static final String ZRNBATKISYTKTNTUSY2ATKIHYJ = "zrnbatkisytktntusy2atkihyj";
    public static final String ZRNBATKISYASYOKAN1ATKIHYJ = "zrnbatkisyasyokan1atkihyj";
    public static final String ZRNBATKISYASYOKAN2ATKIHYJ = "zrnbatkisyasyokan2atkihyj";
    public static final String ZRNKEIZOKUTYUUIHYOUJI    = "zrnkeizokutyuuihyouji";
    public static final String ZRNKEIYAKUBISITEIHYOUJI  = "zrnkeiyakubisiteihyouji";
    public static final String ZRNJYOUKENTUKIHYOUJI     = "zrnjyoukentukihyouji";
    public static final String ZRNTOKUNINHYOUJI         = "zrntokuninhyouji";
    public static final String ZRNKESSANTYOUSEIKBN      = "zrnkessantyouseikbn";
    public static final String ZRNHANEIHYOUJI           = "zrnhaneihyouji";
    public static final String ZRNSYUKINKBN             = "zrnsyukinkbn";
    public static final String ZRNKEIYAKUSYASYOKUGYOUCD = "zrnkeiyakusyasyokugyoucd";
    public static final String ZRNSEIKEIKEIROKBN        = "zrnseikeikeirokbn";
    public static final String ZRNDAI2SEIKEIKEIROKBN    = "zrndai2seikeikeirokbn";
    public static final String ZRNTEIGENTOKUTEISYURUIKIGOU = "zrnteigentokuteisyuruikigou";
    public static final String ZRNTEIGENTOKUTEIKIKAN    = "zrnteigentokuteikikan";
    public static final String ZRNTEIGENTOKUTEIS        = "zrnteigentokuteis";
    public static final String ZRNTEIGENTOKUTEIP        = "zrnteigentokuteip";
    public static final String ZRNTIGNTKTISDTPDTKBN     = "zrntigntktisdtpdtkbn";
    public static final String ZRNTEIGENTOKUTEISYUUSEIS = "zrnteigentokuteisyuuseis";
    public static final String ZRNTEIGENTKTIMODSSAKUGENHYJ = "zrnteigentktimodssakugenhyj";
    public static final String ZRNTEIGENTKTIKGUSDKBN    = "zrnteigentktikgusdkbn";
    public static final String ZRNYOBIV9                = "zrnyobiv9";
    public static final String ZRNTOKUTEIBUICDX1        = "zrntokuteibuicdx1";
    public static final String ZRNHTNPKKNX1             = "zrnhtnpkknx1";
    public static final String ZRNTOKUTEIBUICDX2        = "zrntokuteibuicdx2";
    public static final String ZRNHTNPKKNX2             = "zrnhtnpkknx2";
    public static final String ZRNHHKNMEI               = "zrnhhknmei";
    public static final String ZRNKNJHHKNMEI            = "zrnknjhhknmei";
    public static final String ZRNHHKNSEIYMD            = "zrnhhknseiymd";
    public static final String ZRNHHKNSEIKBN            = "zrnhhknseikbn";
    public static final String ZRNHHKNHNSKTODOUHUKENCD  = "zrnhhknhnsktodouhukencd";
    public static final String ZRNHIHOKENSYAAGEV2       = "zrnhihokensyaagev2";
    public static final String ZRNHIHOKENSYAKIKYKARIHYJ = "zrnhihokensyakikykarihyj";
    public static final String ZRNNOBIKKOSAIMANKIKBN    = "zrnnobikkosaimankikbn";
    public static final String ZRNHHKNSYSYSNHONNINKKNNKBN = "zrnhhknsysysnhonninkknnkbn";
    public static final String ZRNHHKNSYSISNHONNINKKNNKBN = "zrnhhknsysisnhonninkknnkbn";
    public static final String ZRNKZKTOUROKUSERVICEARIHYJ = "zrnkzktourokuservicearihyj";
    public static final String ZRNYOBIV4X12             = "zrnyobiv4x12";
    public static final String ZRNHENSYUUKEIYAKUSYAMEI  = "zrnhensyuukeiyakusyamei";
    public static final String ZRNHNSYUKNJKYKSYNM       = "zrnhnsyuknjkyksynm";
    public static final String ZRNKYKSYASEIYMD          = "zrnkyksyaseiymd";
    public static final String ZRNKYKSYASEIKBN          = "zrnkyksyaseikbn";
    public static final String ZRNKYKSYANEN             = "zrnkyksyanen";
    public static final String ZRNHKNSYURUIKIGOUSEDAIKBN = "zrnhknsyuruikigousedaikbn";
    public static final String ZRNKNKUZUSNZYRT          = "zrnknkuzusnzyrt";
    public static final String ZRNVITDOUJIMOS2KENMEIKOUHYJ = "zrnvitdoujimos2kenmeikouhyj";
    public static final String ZRNKIKYKVITARITUIKAMOSHYJ = "zrnkikykvitarituikamoshyj";
    public static final String ZRNHTNKNKYKVITHOKENKBN   = "zrnhtnknkykvithokenkbn";
    public static final String ZRNKIKYKVITHOKENHOYUUJKKBN = "zrnkikykvithokenhoyuujkkbn";
    public static final String ZRNYOBIV2X2              = "zrnyobiv2x2";
    public static final String ZRNTSNSKNEWYNO           = "zrntsnsknewyno";
    public static final String ZRNTSNSKNEWTIKUCD        = "zrntsnsknewtikucd";
    public static final String ZRNMOSSYUMTKKTYMD        = "zrnmossyumtkktymd";
    public static final String ZRNKITUENKBN             = "zrnkituenkbn";
    public static final String ZRNTUUSINSAKIJYUUSYOKBN  = "zrntuusinsakijyuusyokbn";
    public static final String ZRNMARUTEISYURUIKIGOU    = "zrnmaruteisyuruikigou";
    public static final String ZRNMARUTEIKIKAN          = "zrnmaruteikikan";
    public static final String ZRNMARUTEIPHRKKKN        = "zrnmaruteiphrkkkn";
    public static final String ZRNMARUTEIS              = "zrnmaruteis";
    public static final String ZRNMARUTEIP              = "zrnmaruteip";
    public static final String ZRNMARUTEISYUUSEIS       = "zrnmaruteisyuuseis";
    public static final String ZRNMARUTEISYUUSEISSKGNHYJ = "zrnmaruteisyuuseisskgnhyj";
    public static final String ZRNMARUTEITOKUJYOUKBN    = "zrnmaruteitokujyoukbn";
    public static final String ZRNMRTITKJYUSKGNKKN      = "zrnmrtitkjyuskgnkkn";
    public static final String ZRNMRTITKJYURYUMSHYUTN   = "zrnmrtitkjyuryumshyutn";
    public static final String ZRNMARUTEITOKUJYOUP      = "zrnmaruteitokujyoup";
    public static final String ZRNSURYUMRTIPWRBKKBN     = "zrnsuryumrtipwrbkkbn";
    public static final String ZRNMARUTEIPWARIBIKIKBN   = "zrnmaruteipwaribikikbn";
    public static final String ZRNMRTITNKNYUGUKBN       = "zrnmrtitnknyugukbn";
    public static final String ZRNMARUTEIKIGOUSEDAIKBN  = "zrnmaruteikigousedaikbn";
    public static final String ZRNMARUTEIKIKOUSNMNRYOAGE = "zrnmaruteikikousnmnryoage";
    public static final String ZRNYOBIV2                = "zrnyobiv2";
    public static final String ZRNMARUYOUSYURUIKIGOU    = "zrnmaruyousyuruikigou";
    public static final String ZRNMARUYOUKIKAN          = "zrnmaruyoukikan";
    public static final String ZRNMARUYOUS              = "zrnmaruyous";
    public static final String ZRNMARUYOUP              = "zrnmaruyoup";
    public static final String ZRNMARUYOUSDATEPDATEKBN  = "zrnmaruyousdatepdatekbn";
    public static final String ZRNMARUYOUSYUUSEIS       = "zrnmaruyousyuuseis";
    public static final String ZRNMARUYOUSYUUSEISSKGNHYJ = "zrnmaruyousyuuseisskgnhyj";
    public static final String ZRNMARUYOUKIGOUSEDAIKBN  = "zrnmaruyoukigousedaikbn";
    public static final String ZRNYOBIV9X3              = "zrnyobiv9x3";
    public static final String ZRNMARUSYUUSYURUIKIGOU   = "zrnmarusyuusyuruikigou";
    public static final String ZRNMARUSYUUKIKAN         = "zrnmarusyuukikan";
    public static final String ZRNMARUSYUUS             = "zrnmarusyuus";
    public static final String ZRNMARUSYUUP             = "zrnmarusyuup";
    public static final String ZRNMARUSYUUSDATEPDATEKBN = "zrnmarusyuusdatepdatekbn";
    public static final String ZRNMARUSYUUSYUUSEIS      = "zrnmarusyuusyuuseis";
    public static final String ZRNMARUSYUUSYUUSEISSKGNHYJ = "zrnmarusyuusyuuseisskgnhyj";
    public static final String ZRNMARUSYUUKIGOUSEDAIKBN = "zrnmarusyuukigousedaikbn";
    public static final String ZRNYOBIV9X4              = "zrnyobiv9x4";
    public static final String ZRNTOKUTEISYURUIKIGOU    = "zrntokuteisyuruikigou";
    public static final String ZRNTOKUTEIKIKAN          = "zrntokuteikikan";
    public static final String ZRNTOKUTEIS              = "zrntokuteis";
    public static final String ZRNTOKUTEIP              = "zrntokuteip";
    public static final String ZRNTOKUTEISDATEPDATEKBN  = "zrntokuteisdatepdatekbn";
    public static final String ZRNTOKUTEISYUUSEIS       = "zrntokuteisyuuseis";
    public static final String ZRNTOKUTEISYUUSEISSKGNHYJ = "zrntokuteisyuuseisskgnhyj";
    public static final String ZRNTOKUTEIKIGOUSEDAIKBN  = "zrntokuteikigousedaikbn";
    public static final String ZRNYOBIV9X5              = "zrnyobiv9x5";
    public static final String ZRNKZKMRTITKYKNOX1       = "zrnkzkmrtitkyknox1";
    public static final String ZRNKAZOKUMRTISYURUIKGUX1 = "zrnkazokumrtisyuruikgux1";
    public static final String ZRNKAZOKUMARUTEIKIKANX1  = "zrnkazokumaruteikikanx1";
    public static final String ZRNKAZOKUMRTIPHRKKKNX1   = "zrnkazokumrtiphrkkknx1";
    public static final String ZRNKAZOKUMARUTEISX1      = "zrnkazokumaruteisx1";
    public static final String ZRNKAZOKUMARUTEIPX1      = "zrnkazokumaruteipx1";
    public static final String ZRNKZKMRTIHIHKNSYANMX1   = "zrnkzkmrtihihknsyanmx1";
    public static final String ZRNKZKMRTIHIHKNSYSEIYMDX1 = "zrnkzkmrtihihknsyseiymdx1";
    public static final String ZRNKZKMRTIHIHKNSYSIBTKBNX1 = "zrnkzkmrtihihknsysibtkbnx1";
    public static final String ZRNKAZOKUMRTIHIHKNSYAAGEX1 = "zrnkazokumrtihihknsyaagex1";
    public static final String ZRNKZKMRTIMODSX1         = "zrnkzkmrtimodsx1";
    public static final String ZRNKAZOKUMRTIMODSSKGNHYJX1 = "zrnkazokumrtimodsskgnhyjx1";
    public static final String ZRNKZKMRTITNKNYUGUKBNX1  = "zrnkzkmrtitnknyugukbnx1";
    public static final String ZRNKAZOKUMRTIKGUSDKBNX1  = "zrnkazokumrtikgusdkbnx1";
    public static final String ZRNKAZOKUMRTIAGETYUSIHYJX1 = "zrnkazokumrtiagetyusihyjx1";
    public static final String ZRNKZKMRTIKUSNMNRYOAGEX1 = "zrnkzkmrtikusnmnryoagex1";
    public static final String ZRNYOBIV4                = "zrnyobiv4";
    public static final String ZRNKZKMRTITKYKNOX2       = "zrnkzkmrtitkyknox2";
    public static final String ZRNKAZOKUMRTISYURUIKGUX2 = "zrnkazokumrtisyuruikgux2";
    public static final String ZRNKAZOKUMARUTEIKIKANX2  = "zrnkazokumaruteikikanx2";
    public static final String ZRNKAZOKUMRTIPHRKKKNX2   = "zrnkazokumrtiphrkkknx2";
    public static final String ZRNKAZOKUMARUTEISX2      = "zrnkazokumaruteisx2";
    public static final String ZRNKAZOKUMARUTEIPX2      = "zrnkazokumaruteipx2";
    public static final String ZRNKZKMRTIHIHKNSYANMX2   = "zrnkzkmrtihihknsyanmx2";
    public static final String ZRNKZKMRTIHIHKNSYSEIYMDX2 = "zrnkzkmrtihihknsyseiymdx2";
    public static final String ZRNKZKMRTIHIHKNSYSIBTKBNX2 = "zrnkzkmrtihihknsysibtkbnx2";
    public static final String ZRNKAZOKUMRTIHIHKNSYAAGEX2 = "zrnkazokumrtihihknsyaagex2";
    public static final String ZRNKZKMRTIMODSX2         = "zrnkzkmrtimodsx2";
    public static final String ZRNKAZOKUMRTIMODSSKGNHYJX2 = "zrnkazokumrtimodsskgnhyjx2";
    public static final String ZRNKZKMRTITNKNYUGUKBNX2  = "zrnkzkmrtitnknyugukbnx2";
    public static final String ZRNKAZOKUMRTIKGUSDKBNX2  = "zrnkazokumrtikgusdkbnx2";
    public static final String ZRNKAZOKUMRTIAGETYUSIHYJX2 = "zrnkazokumrtiagetyusihyjx2";
    public static final String ZRNKZKMRTIKUSNMNRYOAGEX2 = "zrnkzkmrtikusnmnryoagex2";
    public static final String ZRNYOBIV4X2              = "zrnyobiv4x2";
    public static final String ZRNKZKMRTITKYKNOX3       = "zrnkzkmrtitkyknox3";
    public static final String ZRNKAZOKUMRTISYURUIKGUX3 = "zrnkazokumrtisyuruikgux3";
    public static final String ZRNKAZOKUMARUTEIKIKANX3  = "zrnkazokumaruteikikanx3";
    public static final String ZRNKAZOKUMRTIPHRKKKNX3   = "zrnkazokumrtiphrkkknx3";
    public static final String ZRNKAZOKUMARUTEISX3      = "zrnkazokumaruteisx3";
    public static final String ZRNKAZOKUMARUTEIPX3      = "zrnkazokumaruteipx3";
    public static final String ZRNKZKMRTIHIHKNSYANMX3   = "zrnkzkmrtihihknsyanmx3";
    public static final String ZRNKZKMRTIHIHKNSYSEIYMDX3 = "zrnkzkmrtihihknsyseiymdx3";
    public static final String ZRNKZKMRTIHIHKNSYSIBTKBNX3 = "zrnkzkmrtihihknsysibtkbnx3";
    public static final String ZRNKAZOKUMRTIHIHKNSYAAGEX3 = "zrnkazokumrtihihknsyaagex3";
    public static final String ZRNKZKMRTIMODSX3         = "zrnkzkmrtimodsx3";
    public static final String ZRNKAZOKUMRTIMODSSKGNHYJX3 = "zrnkazokumrtimodsskgnhyjx3";
    public static final String ZRNKZKMRTITNKNYUGUKBNX3  = "zrnkzkmrtitnknyugukbnx3";
    public static final String ZRNKAZOKUMRTIKGUSDKBNX3  = "zrnkazokumrtikgusdkbnx3";
    public static final String ZRNKAZOKUMRTIAGETYUSIHYJX3 = "zrnkazokumrtiagetyusihyjx3";
    public static final String ZRNKZKMRTIKUSNMNRYOAGEX3 = "zrnkzkmrtikusnmnryoagex3";
    public static final String ZRNYOBIV4X3              = "zrnyobiv4x3";
    public static final String ZRNKZKMRTITKYKNOX4       = "zrnkzkmrtitkyknox4";
    public static final String ZRNKAZOKUMRTISYURUIKGUX4 = "zrnkazokumrtisyuruikgux4";
    public static final String ZRNKAZOKUMARUTEIKIKANX4  = "zrnkazokumaruteikikanx4";
    public static final String ZRNKAZOKUMRTIPHRKKKNX4   = "zrnkazokumrtiphrkkknx4";
    public static final String ZRNKAZOKUMARUTEISX4      = "zrnkazokumaruteisx4";
    public static final String ZRNKAZOKUMARUTEIPX4      = "zrnkazokumaruteipx4";
    public static final String ZRNKZKMRTIHIHKNSYANMX4   = "zrnkzkmrtihihknsyanmx4";
    public static final String ZRNKZKMRTIHIHKNSYSEIYMDX4 = "zrnkzkmrtihihknsyseiymdx4";
    public static final String ZRNKZKMRTIHIHKNSYSIBTKBNX4 = "zrnkzkmrtihihknsysibtkbnx4";
    public static final String ZRNKAZOKUMRTIHIHKNSYAAGEX4 = "zrnkazokumrtihihknsyaagex4";
    public static final String ZRNKZKMRTIMODSX4         = "zrnkzkmrtimodsx4";
    public static final String ZRNKAZOKUMRTIMODSSKGNHYJX4 = "zrnkazokumrtimodsskgnhyjx4";
    public static final String ZRNKZKMRTITNKNYUGUKBNX4  = "zrnkzkmrtitnknyugukbnx4";
    public static final String ZRNKAZOKUMRTIKGUSDKBNX4  = "zrnkazokumrtikgusdkbnx4";
    public static final String ZRNKAZOKUMRTIAGETYUSIHYJX4 = "zrnkazokumrtiagetyusihyjx4";
    public static final String ZRNKZKMRTIKUSNMNRYOAGEX4 = "zrnkzkmrtikusnmnryoagex4";
    public static final String ZRNYOBIV4X4              = "zrnyobiv4x4";
    public static final String ZRNKZKMRTITKYKNOX5       = "zrnkzkmrtitkyknox5";
    public static final String ZRNKAZOKUMRTISYURUIKGUX5 = "zrnkazokumrtisyuruikgux5";
    public static final String ZRNKAZOKUMARUTEIKIKANX5  = "zrnkazokumaruteikikanx5";
    public static final String ZRNKAZOKUMRTIPHRKKKNX5   = "zrnkazokumrtiphrkkknx5";
    public static final String ZRNKAZOKUMARUTEISX5      = "zrnkazokumaruteisx5";
    public static final String ZRNKAZOKUMARUTEIPX5      = "zrnkazokumaruteipx5";
    public static final String ZRNKZKMRTIHIHKNSYANMX5   = "zrnkzkmrtihihknsyanmx5";
    public static final String ZRNKZKMRTIHIHKNSYSEIYMDX5 = "zrnkzkmrtihihknsyseiymdx5";
    public static final String ZRNKZKMRTIHIHKNSYSIBTKBNX5 = "zrnkzkmrtihihknsysibtkbnx5";
    public static final String ZRNKAZOKUMRTIHIHKNSYAAGEX5 = "zrnkazokumrtihihknsyaagex5";
    public static final String ZRNKZKMRTIMODSX5         = "zrnkzkmrtimodsx5";
    public static final String ZRNKAZOKUMRTIMODSSKGNHYJX5 = "zrnkazokumrtimodsskgnhyjx5";
    public static final String ZRNKZKMRTITNKNYUGUKBNX5  = "zrnkzkmrtitnknyugukbnx5";
    public static final String ZRNKAZOKUMRTIKGUSDKBNX5  = "zrnkazokumrtikgusdkbnx5";
    public static final String ZRNKAZOKUMRTIAGETYUSIHYJX5 = "zrnkazokumrtiagetyusihyjx5";
    public static final String ZRNKZKMRTIKUSNMNRYOAGEX5 = "zrnkzkmrtikusnmnryoagex5";
    public static final String ZRNYOBIV4X5              = "zrnyobiv4x5";
    public static final String ZRNKZKMRTITKYKNOX6       = "zrnkzkmrtitkyknox6";
    public static final String ZRNKAZOKUMRTISYURUIKGUX6 = "zrnkazokumrtisyuruikgux6";
    public static final String ZRNKAZOKUMARUTEIKIKANX6  = "zrnkazokumaruteikikanx6";
    public static final String ZRNKAZOKUMRTIPHRKKKNX6   = "zrnkazokumrtiphrkkknx6";
    public static final String ZRNKAZOKUMARUTEISX6      = "zrnkazokumaruteisx6";
    public static final String ZRNKAZOKUMARUTEIPX6      = "zrnkazokumaruteipx6";
    public static final String ZRNKZKMRTIHIHKNSYANMX6   = "zrnkzkmrtihihknsyanmx6";
    public static final String ZRNKZKMRTIHIHKNSYSEIYMDX6 = "zrnkzkmrtihihknsyseiymdx6";
    public static final String ZRNKZKMRTIHIHKNSYSIBTKBNX6 = "zrnkzkmrtihihknsysibtkbnx6";
    public static final String ZRNKAZOKUMRTIHIHKNSYAAGEX6 = "zrnkazokumrtihihknsyaagex6";
    public static final String ZRNKZKMRTIMODSX6         = "zrnkzkmrtimodsx6";
    public static final String ZRNKAZOKUMRTIMODSSKGNHYJX6 = "zrnkazokumrtimodsskgnhyjx6";
    public static final String ZRNKZKMRTITNKNYUGUKBNX6  = "zrnkzkmrtitnknyugukbnx6";
    public static final String ZRNKAZOKUMRTIKGUSDKBNX6  = "zrnkazokumrtikgusdkbnx6";
    public static final String ZRNKAZOKUMRTIAGETYUSIHYJX6 = "zrnkazokumrtiagetyusihyjx6";
    public static final String ZRNKZKMRTIKUSNMNRYOAGEX6 = "zrnkzkmrtikusnmnryoagex6";
    public static final String ZRNYOBIV4X6              = "zrnyobiv4x6";
    public static final String ZRNKZKMRTITKYKNOX7       = "zrnkzkmrtitkyknox7";
    public static final String ZRNKAZOKUMRTISYURUIKGUX7 = "zrnkazokumrtisyuruikgux7";
    public static final String ZRNKAZOKUMARUTEIKIKANX7  = "zrnkazokumaruteikikanx7";
    public static final String ZRNKAZOKUMRTIPHRKKKNX7   = "zrnkazokumrtiphrkkknx7";
    public static final String ZRNKAZOKUMARUTEISX7      = "zrnkazokumaruteisx7";
    public static final String ZRNKAZOKUMARUTEIPX7      = "zrnkazokumaruteipx7";
    public static final String ZRNKZKMRTIHIHKNSYANMX7   = "zrnkzkmrtihihknsyanmx7";
    public static final String ZRNKZKMRTIHIHKNSYSEIYMDX7 = "zrnkzkmrtihihknsyseiymdx7";
    public static final String ZRNKZKMRTIHIHKNSYSIBTKBNX7 = "zrnkzkmrtihihknsysibtkbnx7";
    public static final String ZRNKAZOKUMRTIHIHKNSYAAGEX7 = "zrnkazokumrtihihknsyaagex7";
    public static final String ZRNKZKMRTIMODSX7         = "zrnkzkmrtimodsx7";
    public static final String ZRNKAZOKUMRTIMODSSKGNHYJX7 = "zrnkazokumrtimodsskgnhyjx7";
    public static final String ZRNKZKMRTITNKNYUGUKBNX7  = "zrnkzkmrtitnknyugukbnx7";
    public static final String ZRNKAZOKUMRTIKGUSDKBNX7  = "zrnkazokumrtikgusdkbnx7";
    public static final String ZRNKAZOKUMRTIAGETYUSIHYJX7 = "zrnkazokumrtiagetyusihyjx7";
    public static final String ZRNKZKMRTIKUSNMNRYOAGEX7 = "zrnkzkmrtikusnmnryoagex7";
    public static final String ZRNYOBIV4X7              = "zrnyobiv4x7";
    public static final String ZRNKZKMRTITKYKNOX8       = "zrnkzkmrtitkyknox8";
    public static final String ZRNKAZOKUMRTISYURUIKGUX8 = "zrnkazokumrtisyuruikgux8";
    public static final String ZRNKAZOKUMARUTEIKIKANX8  = "zrnkazokumaruteikikanx8";
    public static final String ZRNKAZOKUMRTIPHRKKKNX8   = "zrnkazokumrtiphrkkknx8";
    public static final String ZRNKAZOKUMARUTEISX8      = "zrnkazokumaruteisx8";
    public static final String ZRNKAZOKUMARUTEIPX8      = "zrnkazokumaruteipx8";
    public static final String ZRNKZKMRTIHIHKNSYANMX8   = "zrnkzkmrtihihknsyanmx8";
    public static final String ZRNKZKMRTIHIHKNSYSEIYMDX8 = "zrnkzkmrtihihknsyseiymdx8";
    public static final String ZRNKZKMRTIHIHKNSYSIBTKBNX8 = "zrnkzkmrtihihknsysibtkbnx8";
    public static final String ZRNKAZOKUMRTIHIHKNSYAAGEX8 = "zrnkazokumrtihihknsyaagex8";
    public static final String ZRNKZKMRTIMODSX8         = "zrnkzkmrtimodsx8";
    public static final String ZRNKAZOKUMRTIMODSSKGNHYJX8 = "zrnkazokumrtimodsskgnhyjx8";
    public static final String ZRNKZKMRTITNKNYUGUKBNX8  = "zrnkzkmrtitnknyugukbnx8";
    public static final String ZRNKAZOKUMRTIKGUSDKBNX8  = "zrnkazokumrtikgusdkbnx8";
    public static final String ZRNKAZOKUMRTIAGETYUSIHYJX8 = "zrnkazokumrtiagetyusihyjx8";
    public static final String ZRNKZKMRTIKUSNMNRYOAGEX8 = "zrnkzkmrtikusnmnryoagex8";
    public static final String ZRNYOBIV4X8              = "zrnyobiv4x8";
    public static final String ZRNKZKMRTITKYKNOX9       = "zrnkzkmrtitkyknox9";
    public static final String ZRNKAZOKUMRTISYURUIKGUX9 = "zrnkazokumrtisyuruikgux9";
    public static final String ZRNKAZOKUMARUTEIKIKANX9  = "zrnkazokumaruteikikanx9";
    public static final String ZRNKAZOKUMRTIPHRKKKNX9   = "zrnkazokumrtiphrkkknx9";
    public static final String ZRNKAZOKUMARUTEISX9      = "zrnkazokumaruteisx9";
    public static final String ZRNKAZOKUMARUTEIPX9      = "zrnkazokumaruteipx9";
    public static final String ZRNKZKMRTIHIHKNSYANMX9   = "zrnkzkmrtihihknsyanmx9";
    public static final String ZRNKZKMRTIHIHKNSYSEIYMDX9 = "zrnkzkmrtihihknsyseiymdx9";
    public static final String ZRNKZKMRTIHIHKNSYSIBTKBNX9 = "zrnkzkmrtihihknsysibtkbnx9";
    public static final String ZRNKAZOKUMRTIHIHKNSYAAGEX9 = "zrnkazokumrtihihknsyaagex9";
    public static final String ZRNKZKMRTIMODSX9         = "zrnkzkmrtimodsx9";
    public static final String ZRNKAZOKUMRTIMODSSKGNHYJX9 = "zrnkazokumrtimodsskgnhyjx9";
    public static final String ZRNKZKMRTITNKNYUGUKBNX9  = "zrnkzkmrtitnknyugukbnx9";
    public static final String ZRNKAZOKUMRTIKGUSDKBNX9  = "zrnkazokumrtikgusdkbnx9";
    public static final String ZRNKAZOKUMRTIAGETYUSIHYJX9 = "zrnkazokumrtiagetyusihyjx9";
    public static final String ZRNKZKMRTIKUSNMNRYOAGEX9 = "zrnkzkmrtikusnmnryoagex9";
    public static final String ZRNYOBIV4X9              = "zrnyobiv4x9";
    public static final String ZRNKZKMRTITKYKNOX10      = "zrnkzkmrtitkyknox10";
    public static final String ZRNKAZOKUMRTISYURUIKGUX10 = "zrnkazokumrtisyuruikgux10";
    public static final String ZRNKAZOKUMARUTEIKIKANX10 = "zrnkazokumaruteikikanx10";
    public static final String ZRNKAZOKUMRTIPHRKKKNX10  = "zrnkazokumrtiphrkkknx10";
    public static final String ZRNKAZOKUMARUTEISX10     = "zrnkazokumaruteisx10";
    public static final String ZRNKAZOKUMARUTEIPX10     = "zrnkazokumaruteipx10";
    public static final String ZRNKZKMRTIHIHKNSYANMX10  = "zrnkzkmrtihihknsyanmx10";
    public static final String ZRNKZKMRTIHIHKNSYSEIYMDX10 = "zrnkzkmrtihihknsyseiymdx10";
    public static final String ZRNKZKMRTIHIHKNSYSIBTKBNX10 = "zrnkzkmrtihihknsysibtkbnx10";
    public static final String ZRNKAZOKUMRTIHIHKNSYAAGEX10 = "zrnkazokumrtihihknsyaagex10";
    public static final String ZRNKZKMRTIMODSX10        = "zrnkzkmrtimodsx10";
    public static final String ZRNKAZOKUMRTIMODSSKGNHYJX10 = "zrnkazokumrtimodsskgnhyjx10";
    public static final String ZRNKZKMRTITNKNYUGUKBNX10 = "zrnkzkmrtitnknyugukbnx10";
    public static final String ZRNKAZOKUMRTIKGUSDKBNX10 = "zrnkazokumrtikgusdkbnx10";
    public static final String ZRNKAZOKUMRTIAGETYUSIHYJX10 = "zrnkazokumrtiagetyusihyjx10";
    public static final String ZRNKZKMRTIKUSNMNRYOAGEX10 = "zrnkzkmrtikusnmnryoagex10";
    public static final String ZRNYOBIV4X10             = "zrnyobiv4x10";
    public static final String ZRNNKSHRTKYKHUHOKBNX1    = "zrnnkshrtkykhuhokbnx1";
    public static final String ZRNNKSHRTKYKNKSYURUIKBNX1 = "zrnnkshrtkyknksyuruikbnx1";
    public static final String ZRNNKSHRTKYKNKKKNX1      = "zrnnkshrtkyknkkknx1";
    public static final String ZRNNKSHRTKYKNKNENGKX1    = "zrnnkshrtkyknknengkx1";
    public static final String ZRNNKSHRTKYKDUKETORIHHKBNX1 = "zrnnkshrtkykduketorihhkbnx1";
    public static final String ZRNYOBIV10               = "zrnyobiv10";
    public static final String ZRNNKSHRTKYKHUHOKBNX2    = "zrnnkshrtkykhuhokbnx2";
    public static final String ZRNNKSHRTKYKNKSYURUIKBNX2 = "zrnnkshrtkyknksyuruikbnx2";
    public static final String ZRNNKSHRTKYKNKKKNX2      = "zrnnkshrtkyknkkknx2";
    public static final String ZRNNKSHRTKYKNKNENGKX2    = "zrnnkshrtkyknknengkx2";
    public static final String ZRNNKSHRTKYKDUKETORIHHKBNX2 = "zrnnkshrtkykduketorihhkbnx2";
    public static final String ZRNYOBIV10X2             = "zrnyobiv10x2";
    public static final String ZRNSYOUGAITKYKSYURUIKGU  = "zrnsyougaitkyksyuruikgu";
    public static final String ZRNSYOUGAITOKUYAKUKIKAN  = "zrnsyougaitokuyakukikan";
    public static final String ZRNSYOUGAITKYKPHRKKKN    = "zrnsyougaitkykphrkkkn";
    public static final String ZRNSYOUGAITOKUYAKUS      = "zrnsyougaitokuyakus";
    public static final String ZRNSYOUGAITOKUYAKUP      = "zrnsyougaitokuyakup";
    public static final String ZRNSYOUGAITKKATAKBN      = "zrnsyougaitkkatakbn";
    public static final String ZRNSYOUGAITKYKKGUSDKBN   = "zrnsyougaitkykkgusdkbn";
    public static final String ZRNSYUGITKYKPWRBKKBN     = "zrnsyugitkykpwrbkkbn";
    public static final String ZRNSYOUGAITKYKKUSNMNRYOAGE = "zrnsyougaitkykkusnmnryoage";
    public static final String ZRNYOBIV5X2              = "zrnyobiv5x2";
    public static final String ZRNSIGIWRMSTKYKSYURUIKGU = "zrnsigiwrmstkyksyuruikgu";
    public static final String ZRNSIGIWRMSTKYKKKN       = "zrnsigiwrmstkykkkn";
    public static final String ZRNSAIGAIWRMSTKYKPHRKKKN = "zrnsaigaiwrmstkykphrkkkn";
    public static final String ZRNSAIGAIWARIMASITOKUYAKUS = "zrnsaigaiwarimasitokuyakus";
    public static final String ZRNSAIGAIWARIMASITOKUYAKUP = "zrnsaigaiwarimasitokuyakup";
    public static final String ZRNSAIGAIWRMSTKYKKGUSDKBN = "zrnsaigaiwrmstkykkgusdkbn";
    public static final String ZRNSIGIWRMSTKYKPWRBKKBN  = "zrnsigiwrmstkykpwrbkkbn";
    public static final String ZRNSIGIWRMSTKYKKUSNMNRYOAGE = "zrnsigiwrmstkykkusnmnryoage";
    public static final String ZRNYOBIV5X3              = "zrnyobiv5x3";
    public static final String ZRNSIGINYUINTKYKSYURUIKGU = "zrnsiginyuintkyksyuruikgu";
    public static final String ZRNSIGINYUINTKYKKKN      = "zrnsiginyuintkykkkn";
    public static final String ZRNSAIGAINYUINTKYKPHRKKKN = "zrnsaigainyuintkykphrkkkn";
    public static final String ZRNSIGINYUINTKYKNTGK     = "zrnsiginyuintkykntgk";
    public static final String ZRNSIGINYUINTKYKGTKBN    = "zrnsiginyuintkykgtkbn";
    public static final String ZRNSAIGAINYUUINTOKUYAKUP = "zrnsaigainyuuintokuyakup";
    public static final String ZRNSAIGAINYUINTKYKKGUSDKBN = "zrnsaigainyuintkykkgusdkbn";
    public static final String ZRNSIGINYUINTKYKPWRBKKBN = "zrnsiginyuintkykpwrbkkbn";
    public static final String ZRNYOBIV7                = "zrnyobiv7";
    public static final String ZRNSPPINYUINTKYKSYURUIKGU = "zrnsppinyuintkyksyuruikgu";
    public static final String ZRNSPPINYUINTKYKKKN      = "zrnsppinyuintkykkkn";
    public static final String ZRNSPPINYUUINTKYKPHRKKKN = "zrnsppinyuuintkykphrkkkn";
    public static final String ZRNSPPINYUINTKYKNTGK     = "zrnsppinyuintkykntgk";
    public static final String ZRNSPPINYUINTKYKGTKBN    = "zrnsppinyuintkykgtkbn";
    public static final String ZRNSIPPEINYUUINTOKUYAKUP = "zrnsippeinyuuintokuyakup";
    public static final String ZRNSPPINYUINTKJYURYUMSHYUTN = "zrnsppinyuintkjyuryumshyutn";
    public static final String ZRNSIPPEINYUUINTOKUJYOUP = "zrnsippeinyuuintokujyoup";
    public static final String ZRNSPPINYUINTKTBICDX1    = "zrnsppinyuintktbicdx1";
    public static final String ZRNSPPINYUINHTNPKKNX1    = "zrnsppinyuinhtnpkknx1";
    public static final String ZRNSPPINYUINTKTBICDX2    = "zrnsppinyuintktbicdx2";
    public static final String ZRNSPPINYUINHTNPKKNX2    = "zrnsppinyuinhtnpkknx2";
    public static final String ZRNSPPINYUUINTKYKKGUSDKBN = "zrnsppinyuuintkykkgusdkbn";
    public static final String ZRNSPPINYUINTKYKPWRBKKBN = "zrnsppinyuintkykpwrbkkbn";
    public static final String ZRNYOBIV7X2              = "zrnyobiv7x2";
    public static final String ZRNSIJNBYUTKYKSYURUIKGU  = "zrnsijnbyutkyksyuruikgu";
    public static final String ZRNSEIJINBYOUTOKUYAKUKIKAN = "zrnseijinbyoutokuyakukikan";
    public static final String ZRNSEIJINBYOUTKYKPHRKKKN = "zrnseijinbyoutkykphrkkkn";
    public static final String ZRNSEIJINBYOUTOKUYAKUNTGK = "zrnseijinbyoutokuyakuntgk";
    public static final String ZRNSEIJINBYOUTOKUYAKUP   = "zrnseijinbyoutokuyakup";
    public static final String ZRNSIJNBYUTKJYURYUMSHYUTN = "zrnsijnbyutkjyuryumshyutn";
    public static final String ZRNSEIJINBYOUTOKUJYOUP   = "zrnseijinbyoutokujyoup";
    public static final String ZRNSEIJINBYOUTOKUTEIBUICDX1 = "zrnseijinbyoutokuteibuicdx1";
    public static final String ZRNSEIJINBYOUHUTANPOKIKANX1 = "zrnseijinbyouhutanpokikanx1";
    public static final String ZRNSEIJINBYOUTOKUTEIBUICDX2 = "zrnseijinbyoutokuteibuicdx2";
    public static final String ZRNSEIJINBYOUHUTANPOKIKANX2 = "zrnseijinbyouhutanpokikanx2";
    public static final String ZRNSEIJINBYOUTKYKKGUSDKBN = "zrnseijinbyoutkykkgusdkbn";
    public static final String ZRNSIJNBYUTKYKGANKYUHGTKBN = "zrnsijnbyutkykgankyuhgtkbn";
    public static final String ZRNSIJNBYUTKYKPWRBKKBN   = "zrnsijnbyutkykpwrbkkbn";
    public static final String ZRNSIJNBYUTKYKKUSNMNRYOAGE = "zrnsijnbyutkykkusnmnryoage";
    public static final String ZRNYOBIV4X11             = "zrnyobiv4x11";
    public static final String ZRNHEIYOUBARAIKBN        = "zrnheiyoubaraikbn";
    public static final String ZRNHIYUBRIAITSYONO       = "zrnhiyubriaitsyono";
    public static final String ZRNHIYUBRIAITHRKKEIROKBN = "zrnhiyubriaithrkkeirokbn";
    public static final String ZRNHEIYOUBARAIAITEKIHONS = "zrnheiyoubaraiaitekihons";
    public static final String ZRNHIYUBRIGUKITNKNITJBRKHNS = "zrnhiyubrigukitnknitjbrkhns";
    public static final String ZRNHEIYOUBARAIAITESIBOUS = "zrnheiyoubaraiaitesibous";
    public static final String ZRNHIYUBRIGUKITNKNITJBRSBUS = "zrnhiyubrigukitnknitjbrsbus";
    public static final String ZRNHEIYOUBARAIAITESYUUSEIS = "zrnheiyoubaraiaitesyuuseis";
    public static final String ZRNHEIYOUBARAIAITEHRKP   = "zrnheiyoubaraiaitehrkp";
    public static final String ZRNHIYUBRIAITSYKYKP      = "zrnhiyubriaitsykykp";
    public static final String ZRNHEIYOUBARAIAITEMRTIS  = "zrnheiyoubaraiaitemrtis";
    public static final String ZRNHIYUBRIGUKIAITKZKMRTIS = "zrnhiyubrigukiaitkzkmrtis";
    public static final String ZRNTUKIBARAIKYKTENKANHYJ = "zrntukibaraikyktenkanhyj";
    public static final String ZRNBONUSHARAIHRKKIGETU1  = "zrnbonusharaihrkkigetu1";
    public static final String ZRNBONUSHARAIHRKKIGETU2  = "zrnbonusharaihrkkigetu2";
    public static final String ZRNHIYUBRIAITSIZNMRTIS   = "zrnhiyubriaitsiznmrtis";
    public static final String ZRNHIYUBRIAITTIGNMRTIS   = "zrnhiyubriaittignmrtis";
    public static final String ZRNTKJYKBN               = "zrntkjykbn";
    public static final String ZRNSAKUGENKIKAN          = "zrnsakugenkikan";
    public static final String ZRNRYOUMASIHYOUTEN       = "zrnryoumasihyouten";
    public static final String ZRNTOKUJYOUP             = "zrntokujyoup";
    public static final String ZRNHJNCD                 = "zrnhjncd";
    public static final String ZRNHJNJIGYOSYOCD         = "zrnhjnjigyosyocd";
    public static final String ZRNJYUUGYOUINSUU         = "zrnjyuugyouinsuu";
    public static final String ZRNIKTKAISUU             = "zrniktkaisuu";
    public static final String ZRNZNNKAI                = "zrnznnkai";
    public static final String ZRNKYKTSNATKITKYKKBN     = "zrnkyktsnatkitkykkbn";
    public static final String ZRNKYKTSNATKITKYKSTAGEKBN = "zrnkyktsnatkitkykstagekbn";
    public static final String ZRNPMENTOKUYAKUKBN       = "zrnpmentokuyakukbn";
    public static final String ZRNYOBIV3                = "zrnyobiv3";
    public static final String ZRNTKYKZNNUNYUKNGK       = "zrntkykznnunyukngk";
    public static final String ZRNSYOKAIPNYUUKINHOUHOUKBN = "zrnsyokaipnyuukinhouhoukbn";
    public static final String ZRNHTNKNKYKSYONOX1       = "zrnhtnknkyksyonox1";
    public static final String ZRNHTNKNKYKHKNSYURUIKGUX1 = "zrnhtnknkykhknsyuruikgux1";
    public static final String ZRNTENKANUKETUKEYMDX1    = "zrntenkanuketukeymdx1";
    public static final String ZRNHTNKNKYKKYKYMDX1      = "zrnhtnknkykkykymdx1";
    public static final String ZRNHTNKNKYKHKNKKNX1      = "zrnhtnknkykhknkknx1";
    public static final String ZRNHTNKNKYKPHRKKKNX1     = "zrnhtnknkykphrkkknx1";
    public static final String ZRNHTNKNKYKHRKKAISUUKBNX1 = "zrnhtnknkykhrkkaisuukbnx1";
    public static final String ZRNHTNKNKYKHRKKEIROKBNX1 = "zrnhtnknkykhrkkeirokbnx1";
    public static final String ZRNTNKNUKTKZNGTKIJYUHYJX1 = "zrntnknuktkzngtkijyuhyjx1";
    public static final String ZRNHTNKNKYKMRTISYURUIKGUX1 = "zrnhtnknkykmrtisyuruikgux1";
    public static final String ZRNHTNKNKYKSYONOX2       = "zrnhtnknkyksyonox2";
    public static final String ZRNHTNKNKYKHKNSYURUIKGUX2 = "zrnhtnknkykhknsyuruikgux2";
    public static final String ZRNTENKANUKETUKEYMDX2    = "zrntenkanuketukeymdx2";
    public static final String ZRNHTNKNKYKKYKYMDX2      = "zrnhtnknkykkykymdx2";
    public static final String ZRNHTNKNKYKHKNKKNX2      = "zrnhtnknkykhknkknx2";
    public static final String ZRNHTNKNKYKPHRKKKNX2     = "zrnhtnknkykphrkkknx2";
    public static final String ZRNHTNKNKYKHRKKAISUUKBNX2 = "zrnhtnknkykhrkkaisuukbnx2";
    public static final String ZRNHTNKNKYKHRKKEIROKBNX2 = "zrnhtnknkykhrkkeirokbnx2";
    public static final String ZRNTNKNUKTKZNGTKIJYUHYJX2 = "zrntnknuktkzngtkijyuhyjx2";
    public static final String ZRNHTNKNKYKMRTISYURUIKGUX2 = "zrnhtnknkykmrtisyuruikgux2";
    public static final String ZRNHTNKNKYKSYONOX3       = "zrnhtnknkyksyonox3";
    public static final String ZRNHTNKNKYKHKNSYURUIKGUX3 = "zrnhtnknkykhknsyuruikgux3";
    public static final String ZRNTENKANUKETUKEYMDX3    = "zrntenkanuketukeymdx3";
    public static final String ZRNHTNKNKYKKYKYMDX3      = "zrnhtnknkykkykymdx3";
    public static final String ZRNHTNKNKYKHKNKKNX3      = "zrnhtnknkykhknkknx3";
    public static final String ZRNHTNKNKYKPHRKKKNX3     = "zrnhtnknkykphrkkknx3";
    public static final String ZRNHTNKNKYKHRKKAISUUKBNX3 = "zrnhtnknkykhrkkaisuukbnx3";
    public static final String ZRNHTNKNKYKHRKKEIROKBNX3 = "zrnhtnknkykhrkkeirokbnx3";
    public static final String ZRNTNKNUKTKZNGTKIJYUHYJX3 = "zrntnknuktkzngtkijyuhyjx3";
    public static final String ZRNHTNKNKYKMRTISYURUIKGUX3 = "zrnhtnknkykmrtisyuruikgux3";
    public static final String ZRNHTNKNKYKSYONOX4       = "zrnhtnknkyksyonox4";
    public static final String ZRNHTNKNKYKHKNSYURUIKGUX4 = "zrnhtnknkykhknsyuruikgux4";
    public static final String ZRNTENKANUKETUKEYMDX4    = "zrntenkanuketukeymdx4";
    public static final String ZRNHTNKNKYKKYKYMDX4      = "zrnhtnknkykkykymdx4";
    public static final String ZRNHTNKNKYKHKNKKNX4      = "zrnhtnknkykhknkknx4";
    public static final String ZRNHTNKNKYKPHRKKKNX4     = "zrnhtnknkykphrkkknx4";
    public static final String ZRNHTNKNKYKHRKKAISUUKBNX4 = "zrnhtnknkykhrkkaisuukbnx4";
    public static final String ZRNHTNKNKYKHRKKEIROKBNX4 = "zrnhtnknkykhrkkeirokbnx4";
    public static final String ZRNTNKNUKTKZNGTKIJYUHYJX4 = "zrntnknuktkzngtkijyuhyjx4";
    public static final String ZRNHTNKNKYKMRTISYURUIKGUX4 = "zrnhtnknkykmrtisyuruikgux4";
    public static final String ZRNHTNKNKYKSYONOX5       = "zrnhtnknkyksyonox5";
    public static final String ZRNHTNKNKYKHKNSYURUIKGUX5 = "zrnhtnknkykhknsyuruikgux5";
    public static final String ZRNTENKANUKETUKEYMDX5    = "zrntenkanuketukeymdx5";
    public static final String ZRNHTNKNKYKKYKYMDX5      = "zrnhtnknkykkykymdx5";
    public static final String ZRNHTNKNKYKHKNKKNX5      = "zrnhtnknkykhknkknx5";
    public static final String ZRNHTNKNKYKPHRKKKNX5     = "zrnhtnknkykphrkkknx5";
    public static final String ZRNHTNKNKYKHRKKAISUUKBNX5 = "zrnhtnknkykhrkkaisuukbnx5";
    public static final String ZRNHTNKNKYKHRKKEIROKBNX5 = "zrnhtnknkykhrkkeirokbnx5";
    public static final String ZRNTNKNUKTKZNGTKIJYUHYJX5 = "zrntnknuktkzngtkijyuhyjx5";
    public static final String ZRNHTNKNKYKMRTISYURUIKGUX5 = "zrnhtnknkykmrtisyuruikgux5";
    public static final String ZRNHTNKNKYKSYONOX6       = "zrnhtnknkyksyonox6";
    public static final String ZRNHTNKNKYKHKNSYURUIKGUX6 = "zrnhtnknkykhknsyuruikgux6";
    public static final String ZRNTENKANUKETUKEYMDX6    = "zrntenkanuketukeymdx6";
    public static final String ZRNHTNKNKYKKYKYMDX6      = "zrnhtnknkykkykymdx6";
    public static final String ZRNHTNKNKYKHKNKKNX6      = "zrnhtnknkykhknkknx6";
    public static final String ZRNHTNKNKYKPHRKKKNX6     = "zrnhtnknkykphrkkknx6";
    public static final String ZRNHTNKNKYKHRKKAISUUKBNX6 = "zrnhtnknkykhrkkaisuukbnx6";
    public static final String ZRNHTNKNKYKHRKKEIROKBNX6 = "zrnhtnknkykhrkkeirokbnx6";
    public static final String ZRNTNKNUKTKZNGTKIJYUHYJX6 = "zrntnknuktkzngtkijyuhyjx6";
    public static final String ZRNHTNKNKYKMRTISYURUIKGUX6 = "zrnhtnknkykmrtisyuruikgux6";
    public static final String ZRNGUKIHTNKNKYKKHNS      = "zrngukihtnknkykkhns";
    public static final String ZRNGUKIHTNKNKYKSBUS      = "zrngukihtnknkyksbus";
    public static final String ZRNGUKIHTNKNKYKHNTIYUP   = "zrngukihtnknkykhntiyup";
    public static final String ZRNGUKIHTNKNKYKSIGWRMSTKYKS = "zrngukihtnknkyksigwrmstkyks";
    public static final String ZRNGUKIHTNKNKYKSYUGITKYKS = "zrngukihtnknkyksyugitkyks";
    public static final String ZRNGUKIHTNKNSIGNYINTKYKNTGK = "zrngukihtnknsignyintkykntgk";
    public static final String ZRNGUKIHTNKNKNKUTKYKNTGK = "zrngukihtnknknkutkykntgk";
    public static final String ZRNGUKIHTNKNKYKMODS      = "zrngukihtnknkykmods";
    public static final String ZRNGOUKEITENKANKAKAKU    = "zrngoukeitenkankakaku";
    public static final String ZRNGUKITNKNJSKNNJYNBKN   = "zrngukitnknjsknnjynbkn";
    public static final String ZRNGUKITNKNSISNKSTKKNGK  = "zrngukitnknsisnkstkkngk";
    public static final String ZRNGUKITNKNSISNTTKEKNGK  = "zrngukitnknsisnttkekngk";
    public static final String ZRNGOUKEITENKANSEISAND   = "zrngoukeitenkanseisand";
    public static final String ZRNGUKITNKNSISNMKIKP     = "zrngukitnknsisnmkikp";
    public static final String ZRNGUKITNKNSISNSNTKNGK   = "zrngukitnknsisnsntkngk";
    public static final String ZRNGUKITNKNKHNBBNKIYKKUJYGK = "zrngukitnknkhnbbnkiykkujygk";
    public static final String ZRNGUKITNKNTIKBBNKIYKKUJYGK = "zrngukitnkntikbbnkiykkujygk";
    public static final String ZRNGUKITNKNITJBRTIKS     = "zrngukitnknitjbrtiks";
    public static final String ZRNSETHOKENNO            = "zrnsethokenno";
    public static final String ZRNSCKBN                 = "zrnsckbn";
    public static final String ZRNENJYOSYACD            = "zrnenjyosyacd";
    public static final String ZRNNAIBUWARIMODOSIGAKU   = "zrnnaibuwarimodosigaku";
    public static final String ZRNKEIYAKUKAKUNINSYURUIKBN = "zrnkeiyakukakuninsyuruikbn";
    public static final String ZRNSOUJIKEITENKANHYOUJI  = "zrnsoujikeitenkanhyouji";
    public static final String ZRNTENKANJISKETTEIHOUHOUKBN = "zrntenkanjisketteihouhoukbn";
    public static final String ZRNKEIKANENSUUKBN        = "zrnkeikanensuukbn";
    public static final String ZRNHTNKNKYKHHKNSYTISYUKBNX1 = "zrnhtnknkykhhknsytisyukbnx1";
    public static final String ZRNHTNKNKYKHHKNSYTISYUKBNX2 = "zrnhtnknkykhhknsytisyukbnx2";
    public static final String ZRNHTNKNKYKHHKNSYTISYUKBNX3 = "zrnhtnknkykhhknsytisyukbnx3";
    public static final String ZRNHTNKNKYKHHKNSYTISYUKBNX4 = "zrnhtnknkykhhknsytisyukbnx4";
    public static final String ZRNHTNKNKYKHHKNSYTISYUKBNX5 = "zrnhtnknkykhhknsytisyukbnx5";
    public static final String ZRNHTNKNKYKHHKNSYTISYUKBNX6 = "zrnhtnknkykhhknsytisyukbnx6";
    public static final String ZRNKKTIJGUKIPBBNTNKNS    = "zrnkktijgukipbbntnkns";
    public static final String ZRNSYONENDOSYOKAIP       = "zrnsyonendosyokaip";
    public static final String ZRNSYONENDO2KAIMEIKOUP   = "zrnsyonendo2kaimeikoup";
    public static final String ZRNJINENDOIKOUP          = "zrnjinendoikoup";
    public static final String ZRNSYUKEIYAKUSIKYUUKISOGAKU = "zrnsyukeiyakusikyuukisogaku";
    public static final String ZRNSYKYKNENHANTATSKYUKSGK = "zrnsykyknenhantatskyuksgk";
    public static final String ZRNMARUTEISIKYUUKISOGAKU = "zrnmaruteisikyuukisogaku";
    public static final String ZRNITJBRZUGKSKYUKSGKX1   = "zrnitjbrzugkskyuksgkx1";
    public static final String ZRNITJBRZUGKSKYUKSGKX2   = "zrnitjbrzugkskyuksgkx2";
    public static final String ZRNITJBRZGKNNHNTATSKYKSGKX1 = "zrnitjbrzgknnhntatskyksgkx1";
    public static final String ZRNITJBRZGKNNHNTATSKYKSGKX2 = "zrnitjbrzgknnhntatskyksgkx2";
    public static final String ZRNKZKMRTISKYUKSGK       = "zrnkzkmrtiskyuksgk";
    public static final String ZRNITIBITJBRSKYUKSGK     = "zrnitibitjbrskyuksgk";
    public static final String ZRNITBITJBRNNHNTATSKYUKSGK = "zrnitbitjbrnnhntatskyuksgk";
    public static final String ZRNSYKYKKSNBSYUTAT       = "zrnsykykksnbsyutat";
    public static final String ZRNITJBRZUGKKSNBSYUTATX1 = "zrnitjbrzugkksnbsyutatx1";
    public static final String ZRNITJBRZUGKKSNBSYUTATX2 = "zrnitjbrzugkksnbsyutatx2";
    public static final String ZRNITIBITJBRKSNBSYUTAT   = "zrnitibitjbrksnbsyutat";
    public static final String ZRNJYUNKENSUU            = "zrnjyunkensuu";
    public static final String ZRNKANSANKENSUU          = "zrnkansankensuu";
    public static final String ZRNITIBUITIJIBARAIKIKAN  = "zrnitibuitijibaraikikan";
    public static final String ZRNITIBUITIJIBARAIS      = "zrnitibuitijibarais";
    public static final String ZRNITIBUITIJIBARAIP      = "zrnitibuitijibaraip";
    public static final String ZRNITIBITJBRSDTPDTKBN    = "zrnitibitjbrsdtpdtkbn";
    public static final String ZRNITIBUITIJIBARAISYUUSEIS = "zrnitibuitijibaraisyuuseis";
    public static final String ZRNITIBITJBRMODSSKGNHYJ  = "zrnitibitjbrmodsskgnhyj";
    public static final String ZRNSUURIYOUSYORIYM       = "zrnsuuriyousyoriym";
    public static final String ZRNSYOSINSINSAHOUHOUKBN  = "zrnsyosinsinsahouhoukbn";
    public static final String ZRNSAISINSINSAHOUHOUKBN  = "zrnsaisinsinsahouhoukbn";
    public static final String ZRNSEIZONMRTISYURUIKGU   = "zrnseizonmrtisyuruikgu";
    public static final String ZRNSEIZONMARUTEIKIKAN    = "zrnseizonmaruteikikan";
    public static final String ZRNSEIZONMRTIPHRKKKN     = "zrnseizonmrtiphrkkkn";
    public static final String ZRNSEIZONMARUTEIS        = "zrnseizonmaruteis";
    public static final String ZRNSEIZONMARUTEIP        = "zrnseizonmaruteip";
    public static final String ZRNSEIZONMARUTEISYUUSEIS = "zrnseizonmaruteisyuuseis";
    public static final String ZRNSEIZONMRTIMODSSKGNHYJ = "zrnseizonmrtimodsskgnhyj";
    public static final String ZRNSIZNMRTITKJYUKBN      = "zrnsiznmrtitkjyukbn";
    public static final String ZRNSIZNMRTITKJYUSKGNKKN  = "zrnsiznmrtitkjyuskgnkkn";
    public static final String ZRNSIZNMRTITKJYURYUMSHYUTN = "zrnsiznmrtitkjyuryumshyutn";
    public static final String ZRNSIZNMRTITKJYUP        = "zrnsiznmrtitkjyup";
    public static final String ZRNSIZNMRTISKYUKSGK      = "zrnsiznmrtiskyuksgk";
    public static final String ZRNHTNKNKYKSIZNMRTSYRIKGUX1 = "zrnhtnknkyksiznmrtsyrikgux1";
    public static final String ZRNHTNKNKYKSIZNMRTSYRIKGUX2 = "zrnhtnknkyksiznmrtsyrikgux2";
    public static final String ZRNHTNKNKYKSIZNMRTSYRIKGUX3 = "zrnhtnknkyksiznmrtsyrikgux3";
    public static final String ZRNHTNKNKYKSIZNMRTSYRIKGUX4 = "zrnhtnknkyksiznmrtsyrikgux4";
    public static final String ZRNHTNKNKYKSIZNMRTSYRIKGUX5 = "zrnhtnknkyksiznmrtsyrikgux5";
    public static final String ZRNHTNKNKYKSIZNMRTSYRIKGUX6 = "zrnhtnknkyksiznmrtsyrikgux6";
    public static final String ZRNSURYUSIZNMRTIPWRBKKBN = "zrnsuryusiznmrtipwrbkkbn";
    public static final String ZRNSIZNMRTIPWRBKKBN      = "zrnsiznmrtipwrbkkbn";
    public static final String ZRNSIZNMRTITNKNYUGUKBN   = "zrnsiznmrtitnknyugukbn";
    public static final String ZRNSEIZONMRTIKGUSDKBN    = "zrnseizonmrtikgusdkbn";
    public static final String ZRNYOBIV1                = "zrnyobiv1";
    public static final String ZRNDAI2HIHOKENSYAMEI     = "zrndai2hihokensyamei";
    public static final String ZRNDAI2KANJIHIHOKENSYAMEI = "zrndai2kanjihihokensyamei";
    public static final String ZRNDAI2HIHOKENSYASEIYMD  = "zrndai2hihokensyaseiymd";
    public static final String ZRNDAI2HIHOKENSYASEIBETUKBN = "zrndai2hihokensyaseibetukbn";
    public static final String ZRNDAI2HIHKNSYAHNSKHKNCD = "zrndai2hihknsyahnskhkncd";
    public static final String ZRNDAI2HHKNNEN           = "zrndai2hhknnen";
    public static final String ZRNDAI2HIHKNSYAKIKYKARIHYJ = "zrndai2hihknsyakikykarihyj";
    public static final String ZRNKYKSYDI2HIHKNSYADUITHYJ = "zrnkyksydi2hihknsyaduithyj";
    public static final String ZRNDAI2SYOSINSINSAHOUHOUKBN = "zrndai2syosinsinsahouhoukbn";
    public static final String ZRNDAI2SAISINSINSAHOUHOUKBN = "zrndai2saisinsinsahouhoukbn";
    public static final String ZRNDAI2SYOKUGYOUCD       = "zrndai2syokugyoucd";
    public static final String ZRNDAI2SAKUGENKIKAN      = "zrndai2sakugenkikan";
    public static final String ZRNDAI2RYOUMASIHYOUTEN   = "zrndai2ryoumasihyouten";
    public static final String ZRNMRTIDI2SKGNKKN        = "zrnmrtidi2skgnkkn";
    public static final String ZRNMRTIDI2RYUMSHYUTN     = "zrnmrtidi2ryumshyutn";
    public static final String ZRNDI2KYKKKNNSYRIKBN     = "zrndi2kykkknnsyrikbn";
    public static final String ZRNTIGNMRTIDI2SKGNKKN    = "zrntignmrtidi2skgnkkn";
    public static final String ZRNTIGNMRTIDI2RYUMSHYUTN = "zrntignmrtidi2ryumshyutn";
    public static final String ZRNDAI2SYOSINHONNINKKNNKBN = "zrndai2syosinhonninkknnkbn";
    public static final String ZRNDI2SISNHONNINKKNNKBN  = "zrndi2sisnhonninkknnkbn";
    public static final String ZRNYOBIV9X6              = "zrnyobiv9x6";
    public static final String ZRNDI2SYUGITKYKSYRIKGU   = "zrndi2syugitkyksyrikgu";
    public static final String ZRNDAI2SYOUGAITOKUYAKUKIKAN = "zrndai2syougaitokuyakukikan";
    public static final String ZRNDI2SYUGITKYKPHRKKKN   = "zrndi2syugitkykphrkkkn";
    public static final String ZRNDAI2SYOUGAITOKUYAKUS  = "zrndai2syougaitokuyakus";
    public static final String ZRNDAI2SYOUGAITOKUYAKUP  = "zrndai2syougaitokuyakup";
    public static final String ZRNDI2SYUGITKYKGTKBN     = "zrndi2syugitkykgtkbn";
    public static final String ZRNDI2SYUGITKYKKGUSDKBN  = "zrndi2syugitkykkgusdkbn";
    public static final String ZRNDI2SYUGITKYKPWRBKKBN  = "zrndi2syugitkykpwrbkkbn";
    public static final String ZRNYOBIV8                = "zrnyobiv8";
    public static final String ZRNDI2SIGIWRMSTKYKSYRIKGU = "zrndi2sigiwrmstkyksyrikgu";
    public static final String ZRNDI2SIGIWRMSTKYKKKN    = "zrndi2sigiwrmstkykkkn";
    public static final String ZRNDI2SIGIWRMSTKYKPHRKKKN = "zrndi2sigiwrmstkykphrkkkn";
    public static final String ZRNDI2SIGIWRMSTKYKS      = "zrndi2sigiwrmstkyks";
    public static final String ZRNDI2SIGIWRMSTKYKP      = "zrndi2sigiwrmstkykp";
    public static final String ZRNDI2SIGIWRMSTKYKKGUSDKBN = "zrndi2sigiwrmstkykkgusdkbn";
    public static final String ZRNDI2SIGIWRMSTKYKPWRBKKBN = "zrndi2sigiwrmstkykpwrbkkbn";
    public static final String ZRNYOBIV9X7              = "zrnyobiv9x7";
    public static final String ZRNDI2SIGINYUINTKYKSYRIKGU = "zrndi2siginyuintkyksyrikgu";
    public static final String ZRNDI2SIGINYUINTKYKKKN   = "zrndi2siginyuintkykkkn";
    public static final String ZRNDI2SIGINYUINTKYKPHRKKKN = "zrndi2siginyuintkykphrkkkn";
    public static final String ZRNDI2SIGINYUINTKYKNTGK  = "zrndi2siginyuintkykntgk";
    public static final String ZRNDI2SIGINYUINTKYKP     = "zrndi2siginyuintkykp";
    public static final String ZRNDI2SIGINYUINTKYKGTKBN = "zrndi2siginyuintkykgtkbn";
    public static final String ZRNDI2SIGINYINTKYKKGUSDKBN = "zrndi2siginyintkykkgusdkbn";
    public static final String ZRNDI2SIGINYUINTKYKPWRBKKBN = "zrndi2siginyuintkykpwrbkkbn";
    public static final String ZRNYOBIV10X3             = "zrnyobiv10x3";
    public static final String ZRNDI2SPPINYUINTKYKSYRIKGU = "zrndi2sppinyuintkyksyrikgu";
    public static final String ZRNDI2SPPINYUINTKYKKKN   = "zrndi2sppinyuintkykkkn";
    public static final String ZRNDI2SPPINYUINTKYKPHRKKKN = "zrndi2sppinyuintkykphrkkkn";
    public static final String ZRNDI2SPPINYUINTKYKNTGK  = "zrndi2sppinyuintkykntgk";
    public static final String ZRNDI2SPPINYUINTKYKP     = "zrndi2sppinyuintkykp";
    public static final String ZRNDI2SPPINYUINTKYKGTKBN = "zrndi2sppinyuintkykgtkbn";
    public static final String ZRNDI2SPPINYINTKJYRYUMSHYTN = "zrndi2sppinyintkjyryumshytn";
    public static final String ZRNDI2SPPINYUINTKJYUP    = "zrndi2sppinyuintkjyup";
    public static final String ZRNDI2SPPINYUINTKTBICDX1 = "zrndi2sppinyuintktbicdx1";
    public static final String ZRNDI2SPPINYUINHTNPKKNX1 = "zrndi2sppinyuinhtnpkknx1";
    public static final String ZRNDI2SPPINYUINTKTBICDX2 = "zrndi2sppinyuintktbicdx2";
    public static final String ZRNDI2SPPINYUINHTNPKKNX2 = "zrndi2sppinyuinhtnpkknx2";
    public static final String ZRNDI2SPPINYINTKYKKGUSDKBN = "zrndi2sppinyintkykkgusdkbn";
    public static final String ZRNDI2SPPINYUINTKYKPWRBKKBN = "zrndi2sppinyuintkykpwrbkkbn";
    public static final String ZRNYOBIV3X2              = "zrnyobiv3x2";
    public static final String ZRNDI2SIJNBYUTKYKSYRIKGU = "zrndi2sijnbyutkyksyrikgu";
    public static final String ZRNDI2SIJNBYUTKYKKKN     = "zrndi2sijnbyutkykkkn";
    public static final String ZRNDI2SIJNBYUTKYKPHRKKKN = "zrndi2sijnbyutkykphrkkkn";
    public static final String ZRNDI2SIJNBYUTKYKNTGK    = "zrndi2sijnbyutkykntgk";
    public static final String ZRNDAI2SEIJINBYOUTOKUYAKUP = "zrndai2seijinbyoutokuyakup";
    public static final String ZRNDI2SIJNBYUTKJYURYMSHYTN = "zrndi2sijnbyutkjyurymshytn";
    public static final String ZRNDAI2SEIJINBYOUTOKUJYOUP = "zrndai2seijinbyoutokujyoup";
    public static final String ZRNDI2SIJNBYUTKTBICDX1   = "zrndi2sijnbyutktbicdx1";
    public static final String ZRNDI2SIJNBYUHTNPKKNX1   = "zrndi2sijnbyuhtnpkknx1";
    public static final String ZRNDI2SIJNBYUTKTBICDX2   = "zrndi2sijnbyutktbicdx2";
    public static final String ZRNDI2SIJNBYUHTNPKKNX2   = "zrndi2sijnbyuhtnpkknx2";
    public static final String ZRNDI2SIJNBYUTKYKKGUSDKBN = "zrndi2sijnbyutkykkgusdkbn";
    public static final String ZRNDI2SIJNBYTKYKGANKYHGTKBN = "zrndi2sijnbytkykgankyhgtkbn";
    public static final String ZRNDI2SIJNBYUTKYKPWRBKKBN = "zrndi2sijnbyutkykpwrbkkbn";
    public static final String ZRNYOBIV3X3              = "zrnyobiv3x3";
    public static final String ZRNDAI2JYOUKENTUKIHYOUJI = "zrndai2jyoukentukihyouji";
    public static final String ZRNTIGNMRTISYUKGU        = "zrntignmrtisyukgu";
    public static final String ZRNTEIGENMARUTEIKIKAN    = "zrnteigenmaruteikikan";
    public static final String ZRNTEIGENMRTIPHRKKKN     = "zrnteigenmrtiphrkkkn";
    public static final String ZRNTEIGENMARUTEIS        = "zrnteigenmaruteis";
    public static final String ZRNTEIGENMARUTEIP        = "zrnteigenmaruteip";
    public static final String ZRNTEIGENMARUTEISYUUSEIS = "zrnteigenmaruteisyuuseis";
    public static final String ZRNTEIGENMRTIMODSSAKUGENHYJ = "zrnteigenmrtimodssakugenhyj";
    public static final String ZRNTIGNMRTITKJYUKBN      = "zrntignmrtitkjyukbn";
    public static final String ZRNTIGNMRTITKJYUSKGNKKN  = "zrntignmrtitkjyuskgnkkn";
    public static final String ZRNTIGNMRTITKJYURYUMSHYUTN = "zrntignmrtitkjyuryumshyutn";
    public static final String ZRNTIGNMRTITKJYUP        = "zrntignmrtitkjyup";
    public static final String ZRNTIGNMRTISKYUKSGK      = "zrntignmrtiskyuksgk";
    public static final String ZRNHTNKNKYKTIGNMRTSYRIKGUX1 = "zrnhtnknkyktignmrtsyrikgux1";
    public static final String ZRNHTNKNKYKTIGNMRTSYRIKGUX2 = "zrnhtnknkyktignmrtsyrikgux2";
    public static final String ZRNHTNKNKYKTIGNMRTSYRIKGUX3 = "zrnhtnknkyktignmrtsyrikgux3";
    public static final String ZRNHTNKNKYKTIGNMRTSYRIKGUX4 = "zrnhtnknkyktignmrtsyrikgux4";
    public static final String ZRNHTNKNKYKTIGNMRTSYRIKGUX5 = "zrnhtnknkyktignmrtsyrikgux5";
    public static final String ZRNHTNKNKYKTIGNMRTSYRIKGUX6 = "zrnhtnknkyktignmrtsyrikgux6";
    public static final String ZRNSURYUTIGNMRTIPWRBKKBN = "zrnsuryutignmrtipwrbkkbn";
    public static final String ZRNTIGNMRTIPWRBKKBN      = "zrntignmrtipwrbkkbn";
    public static final String ZRNTIGNMRTITNKNYUGUKBN   = "zrntignmrtitnknyugukbn";
    public static final String ZRNTEIGENMRTIKGUSDKBN    = "zrnteigenmrtikgusdkbn";
    public static final String ZRNYOBIV1X2              = "zrnyobiv1x2";
    public static final String ZRNTKTSPPISETKYKKBN      = "zrntktsppisetkykkbn";
    public static final String ZRNJYUDMNSISKKNSETKYKKBN = "zrnjyudmnsiskknsetkykkbn";
    public static final String ZRNYOBIV8X2              = "zrnyobiv8x2";
    public static final String ZRNSETAITESYONO1         = "zrnsetaitesyono1";
    public static final String ZRNSETAITEHOKENSYURUIKIGOU1 = "zrnsetaitehokensyuruikigou1";
    public static final String ZRNSETAITEMRTISYURUIKGU1 = "zrnsetaitemrtisyuruikgu1";
    public static final String ZRNSETAITESIZNMRTISYURUI1 = "zrnsetaitesiznmrtisyurui1";
    public static final String ZRNSETAITETIGNMRTISYURUI1 = "zrnsetaitetignmrtisyurui1";
    public static final String ZRNSETAITEKIHONBUBUNS1   = "zrnsetaitekihonbubuns1";
    public static final String ZRNSETGUKITNKNITJBRKHNS1 = "zrnsetgukitnknitjbrkhns1";
    public static final String ZRNSETAITESIBOUS1        = "zrnsetaitesibous1";
    public static final String ZRNSETGUKITNKNITJBRSBUS1 = "zrnsetgukitnknitjbrsbus1";
    public static final String ZRNSETAITESYUUSEIS1      = "zrnsetaitesyuuseis1";
    public static final String ZRNSETAITEHARAIKOMIP1    = "zrnsetaiteharaikomip1";
    public static final String ZRNSETAITESYUKEIYAKUBUBUNP1 = "zrnsetaitesyukeiyakububunp1";
    public static final String ZRNSETAITGUKIKZKMRTIS1   = "zrnsetaitgukikzkmrtis1";
    public static final String ZRNSETAITETENKANKYKHYJ1  = "zrnsetaitetenkankykhyj1";
    public static final String ZRNSETAITESITEIMHRKP1    = "zrnsetaitesiteimhrkp1";
    public static final String ZRNSETAITESITEIMSYKYKP1  = "zrnsetaitesiteimsykykp1";
    public static final String ZRNSETAITENKMRTISYURUI1  = "zrnsetaitenkmrtisyurui1";
    public static final String ZRNYOBIV18               = "zrnyobiv18";

    private final PKZT_Skeiksnbsgetujisr1Rn primaryKey;

    public GenZT_Skeiksnbsgetujisr1Rn() {
        primaryKey = new PKZT_Skeiksnbsgetujisr1Rn();
    }

    public GenZT_Skeiksnbsgetujisr1Rn(String pZrnktgysyono) {
        primaryKey = new PKZT_Skeiksnbsgetujisr1Rn(pZrnktgysyono);
    }

    @Transient
    @Override
    public PKZT_Skeiksnbsgetujisr1Rn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Skeiksnbsgetujisr1Rn> getMetaClass() {
        return QZT_Skeiksnbsgetujisr1Rn.class;
    }

    private String zrnktgysyrymd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKTGYSYRYMD)
    public String getZrnktgysyrymd() {
        return zrnktgysyrymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnktgysyrymd(String pZrnktgysyrymd) {
        zrnktgysyrymd = pZrnktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKTGYSYONO)
    public String getZrnktgysyono() {
        return getPrimaryKey().getZrnktgysyono();
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnktgysyono(String pZrnktgysyono) {
        getPrimaryKey().setZrnktgysyono(pZrnktgysyono);
    }

    private String zrnktgyfilerenno;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKTGYFILERENNO)
    public String getZrnktgyfilerenno() {
        return zrnktgyfilerenno;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnktgyfilerenno(String pZrnktgyfilerenno) {
        zrnktgyfilerenno = pZrnktgyfilerenno;
    }

    private String zrnsyono;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYONO)
    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }

    private String zrnaatukaisyasisyacd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNAATUKAISYASISYACD)
    public String getZrnaatukaisyasisyacd() {
        return zrnaatukaisyasisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnaatukaisyasisyacd(String pZrnaatukaisyasisyacd) {
        zrnaatukaisyasisyacd = pZrnaatukaisyasisyacd;
    }

    private String zrnmosno;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMOSNO)
    public String getZrnmosno() {
        return zrnmosno;
    }

    public void setZrnmosno(String pZrnmosno) {
        zrnmosno = pZrnmosno;
    }

    private String zrnhknsyukigou;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHKNSYUKIGOU)
    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }

    private String zrnkykymd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKYKYMD)
    public String getZrnkykymd() {
        return zrnkykymd;
    }

    public void setZrnkykymd(String pZrnkykymd) {
        zrnkykymd = pZrnkykymd;
    }

    private String zrnhknkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHKNKKN)
    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }

    private String zrnphrkkikn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNPHRKKIKN)
    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }

    private String zrnsaimnkkykhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSAIMNKKYKHYJ)
    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }

    private Long zrnkihons;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKIHONS)
    public Long getZrnkihons() {
        return zrnkihons;
    }

    public void setZrnkihons(Long pZrnkihons) {
        zrnkihons = pZrnkihons;
    }

    private Long zrnsibous;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIBOUS)
    public Long getZrnsibous() {
        return zrnsibous;
    }

    public void setZrnsibous(Long pZrnsibous) {
        zrnsibous = pZrnsibous;
    }

    private Long zrngyousekihyoukayouhosyous;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGYOUSEKIHYOUKAYOUHOSYOUS)
    public Long getZrngyousekihyoukayouhosyous() {
        return zrngyousekihyoukayouhosyous;
    }

    public void setZrngyousekihyoukayouhosyous(Long pZrngyousekihyoukayouhosyous) {
        zrngyousekihyoukayouhosyous = pZrngyousekihyoukayouhosyous;
    }

    private Long zrngukitnknitjbrkhns;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKITNKNITJBRKHNS)
    public Long getZrngukitnknitjbrkhns() {
        return zrngukitnknitjbrkhns;
    }

    public void setZrngukitnknitjbrkhns(Long pZrngukitnknitjbrkhns) {
        zrngukitnknitjbrkhns = pZrngukitnknitjbrkhns;
    }

    private Long zrngukitnknitjbrsbus;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKITNKNITJBRSBUS)
    public Long getZrngukitnknitjbrsbus() {
        return zrngukitnknitjbrsbus;
    }

    public void setZrngukitnknitjbrsbus(Long pZrngukitnknitjbrsbus) {
        zrngukitnknitjbrsbus = pZrngukitnknitjbrsbus;
    }

    private Long zrnkktijgukitnknitjbrkhns;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKKTIJGUKITNKNITJBRKHNS)
    public Long getZrnkktijgukitnknitjbrkhns() {
        return zrnkktijgukitnknitjbrkhns;
    }

    public void setZrnkktijgukitnknitjbrkhns(Long pZrnkktijgukitnknitjbrkhns) {
        zrnkktijgukitnknitjbrkhns = pZrnkktijgukitnknitjbrkhns;
    }

    private Long zrnkktijgukitnknitjbrsbus;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKKTIJGUKITNKNITJBRSBUS)
    public Long getZrnkktijgukitnknitjbrsbus() {
        return zrnkktijgukitnknitjbrsbus;
    }

    public void setZrnkktijgukitnknitjbrsbus(Long pZrnkktijgukitnknitjbrsbus) {
        zrnkktijgukitnknitjbrsbus = pZrnkktijgukitnknitjbrsbus;
    }

    private Long zrnsyokaiharaikomip;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOKAIHARAIKOMIP)
    public Long getZrnsyokaiharaikomip() {
        return zrnsyokaiharaikomip;
    }

    public void setZrnsyokaiharaikomip(Long pZrnsyokaiharaikomip) {
        zrnsyokaiharaikomip = pZrnsyokaiharaikomip;
    }

    private Long zrnsyukeiyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYUKEIYAKUP)
    public Long getZrnsyukeiyakup() {
        return zrnsyukeiyakup;
    }

    public void setZrnsyukeiyakup(Long pZrnsyukeiyakup) {
        zrnsyukeiyakup = pZrnsyukeiyakup;
    }

    private String zrnhrkkaisuukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHRKKAISUUKBN)
    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }

    private String zrnhrkkeirokbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHRKKEIROKBN)
    public String getZrnhrkkeirokbn() {
        return zrnhrkkeirokbn;
    }

    public void setZrnhrkkeirokbn(String pZrnhrkkeirokbn) {
        zrnhrkkeirokbn = pZrnhrkkeirokbn;
    }

    private String zrnryouritukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNRYOURITUKBN)
    public String getZrnryouritukbn() {
        return zrnryouritukbn;
    }

    public void setZrnryouritukbn(String pZrnryouritukbn) {
        zrnryouritukbn = pZrnryouritukbn;
    }

    private String zrntksyuannaikykkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTKSYUANNAIKYKKBN)
    public String getZrntksyuannaikykkbn() {
        return zrntksyuannaikykkbn;
    }

    public void setZrntksyuannaikykkbn(String pZrntksyuannaikykkbn) {
        zrntksyuannaikykkbn = pZrntksyuannaikykkbn;
    }

    private String zrnsdpdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSDPDKBN)
    public String getZrnsdpdkbn() {
        return zrnsdpdkbn;
    }

    public void setZrnsdpdkbn(String pZrnsdpdkbn) {
        zrnsdpdkbn = pZrnsdpdkbn;
    }

    private String zrnanniskcd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNANNISKCD)
    public String getZrnanniskcd() {
        return zrnanniskcd;
    }

    public void setZrnanniskcd(String pZrnanniskcd) {
        zrnanniskcd = pZrnanniskcd;
    }

    private String zrnduketorihouhoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDUKETORIHOUHOUKBN)
    public String getZrnduketorihouhoukbn() {
        return zrnduketorihouhoukbn;
    }

    public void setZrnduketorihouhoukbn(String pZrnduketorihouhoukbn) {
        zrnduketorihouhoukbn = pZrnduketorihouhoukbn;
    }

    private String zrnkyksyhhknsydouituhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKYKSYHHKNSYDOUITUHYOUJI)
    public String getZrnkyksyhhknsydouituhyouji() {
        return zrnkyksyhhknsydouituhyouji;
    }

    public void setZrnkyksyhhknsydouituhyouji(String pZrnkyksyhhknsydouituhyouji) {
        zrnkyksyhhknsydouituhyouji = pZrnkyksyhhknsydouituhyouji;
    }

    private String zrnkyksyakikykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKYKSYAKIKYKARIHYJ)
    public String getZrnkyksyakikykarihyj() {
        return zrnkyksyakikykarihyj;
    }

    public void setZrnkyksyakikykarihyj(String pZrnkyksyakikykarihyj) {
        zrnkyksyakikykarihyj = pZrnkyksyakikykarihyj;
    }

    private String zrntenkankeiyakuhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTENKANKEIYAKUHYOUJI)
    public String getZrntenkankeiyakuhyouji() {
        return zrntenkankeiyakuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkankeiyakuhyouji(String pZrntenkankeiyakuhyouji) {
        zrntenkankeiyakuhyouji = pZrntenkankeiyakuhyouji;
    }

    private String zrnjigyoukeiyakuhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNJIGYOUKEIYAKUHYOUJI)
    public String getZrnjigyoukeiyakuhyouji() {
        return zrnjigyoukeiyakuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjigyoukeiyakuhyouji(String pZrnjigyoukeiyakuhyouji) {
        zrnjigyoukeiyakuhyouji = pZrnjigyoukeiyakuhyouji;
    }

    private String zrnnenkinzeiseitokuyakukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNENKINZEISEITOKUYAKUKBN)
    public String getZrnnenkinzeiseitokuyakukbn() {
        return zrnnenkinzeiseitokuyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnenkinzeiseitokuyakukbn(String pZrnnenkinzeiseitokuyakukbn) {
        zrnnenkinzeiseitokuyakukbn = pZrnnenkinzeiseitokuyakukbn;
    }

    private String zrnsyusseimaekanyuukykkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYUSSEIMAEKANYUUKYKKBN)
    public String getZrnsyusseimaekanyuukykkbn() {
        return zrnsyusseimaekanyuukykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyusseimaekanyuukykkbn(String pZrnsyusseimaekanyuukykkbn) {
        zrnsyusseimaekanyuukykkbn = pZrnsyusseimaekanyuukykkbn;
    }

    private String zrnkazokukeiyakuhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUKEIYAKUHYOUJI)
    public String getZrnkazokukeiyakuhyouji() {
        return zrnkazokukeiyakuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokukeiyakuhyouji(String pZrnkazokukeiyakuhyouji) {
        zrnkazokukeiyakuhyouji = pZrnkazokukeiyakuhyouji;
    }

    private String zrnjikokykhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNJIKOKYKHYJ)
    public String getZrnjikokykhyj() {
        return zrnjikokykhyj;
    }

    public void setZrnjikokykhyj(String pZrnjikokykhyj) {
        zrnjikokykhyj = pZrnjikokykhyj;
    }

    private String zrntuusyoumeisiyouhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTUUSYOUMEISIYOUHYOUJI)
    public String getZrntuusyoumeisiyouhyouji() {
        return zrntuusyoumeisiyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntuusyoumeisiyouhyouji(String pZrntuusyoumeisiyouhyouji) {
        zrntuusyoumeisiyouhyouji = pZrntuusyoumeisiyouhyouji;
    }

    private String zrnsethokenkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETHOKENKBN)
    public String getZrnsethokenkbn() {
        return zrnsethokenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsethokenkbn(String pZrnsethokenkbn) {
        zrnsethokenkbn = pZrnsethokenkbn;
    }

    private String zrnteikeisyouhinkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIKEISYOUHINKBN)
    public String getZrnteikeisyouhinkbn() {
        return zrnteikeisyouhinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnteikeisyouhinkbn(String pZrnteikeisyouhinkbn) {
        zrnteikeisyouhinkbn = pZrnteikeisyouhinkbn;
    }

    private String zrnsykgycd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYKGYCD)
    public String getZrnsykgycd() {
        return zrnsykgycd;
    }

    public void setZrnsykgycd(String pZrnsykgycd) {
        zrnsykgycd = pZrnsykgycd;
    }

    private Long zrntokuninbosyuuteate;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUNINBOSYUUTEATE)
    public Long getZrntokuninbosyuuteate() {
        return zrntokuninbosyuuteate;
    }

    public void setZrntokuninbosyuuteate(Long pZrntokuninbosyuuteate) {
        zrntokuninbosyuuteate = pZrntokuninbosyuuteate;
    }

    private String zrnseisekiym;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEISEKIYM)
    public String getZrnseisekiym() {
        return zrnseisekiym;
    }

    public void setZrnseisekiym(String pZrnseisekiym) {
        zrnseisekiym = pZrnseisekiym;
    }

    private Long zrnseisekikeijyousyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEISEKIKEIJYOUSYUUSEIS)
    public Long getZrnseisekikeijyousyuuseis() {
        return zrnseisekikeijyousyuuseis;
    }

    public void setZrnseisekikeijyousyuuseis(Long pZrnseisekikeijyousyuuseis) {
        zrnseisekikeijyousyuuseis = pZrnseisekikeijyousyuuseis;
    }

    private String zrnsyuuseissakugenhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYUUSEISSAKUGENHYOUJI)
    public String getZrnsyuuseissakugenhyouji() {
        return zrnsyuuseissakugenhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsyuuseissakugenhyouji(String pZrnsyuuseissakugenhyouji) {
        zrnsyuuseissakugenhyouji = pZrnsyuuseissakugenhyouji;
    }

    private String zrnaatukaisisyatodouhukencd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNAATUKAISISYATODOUHUKENCD)
    public String getZrnaatukaisisyatodouhukencd() {
        return zrnaatukaisisyatodouhukencd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnaatukaisisyatodouhukencd(String pZrnaatukaisisyatodouhukencd) {
        zrnaatukaisisyatodouhukencd = pZrnaatukaisisyatodouhukencd;
    }

    private String zrnaatukaisosikicd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNAATUKAISOSIKICD)
    public String getZrnaatukaisosikicd() {
        return zrnaatukaisosikicd;
    }

    public void setZrnaatukaisosikicd(String pZrnaatukaisosikicd) {
        zrnaatukaisosikicd = pZrnaatukaisosikicd;
    }

    private String zrnaatukaikojincd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNAATUKAIKOJINCD)
    public String getZrnaatukaikojincd() {
        return zrnaatukaikojincd;
    }

    public void setZrnaatukaikojincd(String pZrnaatukaikojincd) {
        zrnaatukaikojincd = pZrnaatukaikojincd;
    }

    private String zrnbatukaisosikicd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNBATUKAISOSIKICD)
    public String getZrnbatukaisosikicd() {
        return zrnbatukaisosikicd;
    }

    public void setZrnbatukaisosikicd(String pZrnbatukaisosikicd) {
        zrnbatukaisosikicd = pZrnbatukaisosikicd;
    }

    private String zrnbatukaisyakojincd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNBATUKAISYAKOJINCD)
    public String getZrnbatukaisyakojincd() {
        return zrnbatukaisyakojincd;
    }

    public void setZrnbatukaisyakojincd(String pZrnbatukaisyakojincd) {
        zrnbatukaisyakojincd = pZrnbatukaisyakojincd;
    }

    private String zrnmarutokukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTOKUKBN)
    public String getZrnmarutokukbn() {
        return zrnmarutokukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmarutokukbn(String pZrnmarutokukbn) {
        zrnmarutokukbn = pZrnmarutokukbn;
    }

    private String zrngyoumujyouhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGYOUMUJYOUHYOUJI)
    public String getZrngyoumujyouhyouji() {
        return zrngyoumujyouhyouji;
    }

    public void setZrngyoumujyouhyouji(String pZrngyoumujyouhyouji) {
        zrngyoumujyouhyouji = pZrngyoumujyouhyouji;
    }

    private String zrntuikakeijyoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTUIKAKEIJYOUKBN)
    public String getZrntuikakeijyoukbn() {
        return zrntuikakeijyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntuikakeijyoukbn(String pZrntuikakeijyoukbn) {
        zrntuikakeijyoukbn = pZrntuikakeijyoukbn;
    }

    private String zrnseisekinomikeijyoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEISEKINOMIKEIJYOUKBN)
    public String getZrnseisekinomikeijyoukbn() {
        return zrnseisekinomikeijyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnseisekinomikeijyoukbn(String pZrnseisekinomikeijyoukbn) {
        zrnseisekinomikeijyoukbn = pZrnseisekinomikeijyoukbn;
    }

    private String zrnteikikeijyoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIKIKEIJYOUKBN)
    public String getZrnteikikeijyoukbn() {
        return zrnteikikeijyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteikikeijyoukbn(String pZrnteikikeijyoukbn) {
        zrnteikikeijyoukbn = pZrnteikikeijyoukbn;
    }

    private String zrnhngkmskkatkisykbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHNGKMSKKATKISYKBN)
    public String getZrnhngkmskkatkisykbn() {
        return zrnhngkmskkatkisykbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhngkmskkatkisykbn(String pZrnhngkmskkatkisykbn) {
        zrnhngkmskkatkisykbn = pZrnhngkmskkatkisykbn;
    }

    private String zrntnknkyuuyosakugenhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTNKNKYUUYOSAKUGENHYJ)
    public String getZrntnknkyuuyosakugenhyj() {
        return zrntnknkyuuyosakugenhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknkyuuyosakugenhyj(String pZrntnknkyuuyosakugenhyj) {
        zrntnknkyuuyosakugenhyj = pZrntnknkyuuyosakugenhyj;
    }

    private String zrntenkankaisuu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTENKANKAISUU)
    public String getZrntenkankaisuu() {
        return zrntenkankaisuu;
    }

    public void setZrntenkankaisuu(String pZrntenkankaisuu) {
        zrntenkankaisuu = pZrntenkankaisuu;
    }

    private String zrnhiyubrigssnsikkijyunkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIYUBRIGSSNSIKKIJYUNKBN)
    public String getZrnhiyubrigssnsikkijyunkbn() {
        return zrnhiyubrigssnsikkijyunkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhiyubrigssnsikkijyunkbn(String pZrnhiyubrigssnsikkijyunkbn) {
        zrnhiyubrigssnsikkijyunkbn = pZrnhiyubrigssnsikkijyunkbn;
    }

    private String zrnsekininkaisiymd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEKININKAISIYMD)
    public String getZrnsekininkaisiymd() {
        return zrnsekininkaisiymd;
    }

    public void setZrnsekininkaisiymd(String pZrnsekininkaisiymd) {
        zrnsekininkaisiymd = pZrnsekininkaisiymd;
    }

    private String zrnkigetusmkrgkykhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKIGETUSMKRGKYKHYJ)
    public String getZrnkigetusmkrgkykhyj() {
        return zrnkigetusmkrgkykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkigetusmkrgkykhyj(String pZrnkigetusmkrgkykhyj) {
        zrnkigetusmkrgkykhyj = pZrnkigetusmkrgkykhyj;
    }

    private String zrnhensyuusyoriymd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHENSYUUSYORIYMD)
    public String getZrnhensyuusyoriymd() {
        return zrnhensyuusyoriymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhensyuusyoriymd(String pZrnhensyuusyoriymd) {
        zrnhensyuusyoriymd = pZrnhensyuusyoriymd;
    }

    private String zrnjisisyaatukaihyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNJISISYAATUKAIHYOUJI)
    public String getZrnjisisyaatukaihyouji() {
        return zrnjisisyaatukaihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjisisyaatukaihyouji(String pZrnjisisyaatukaihyouji) {
        zrnjisisyaatukaihyouji = pZrnjisisyaatukaihyouji;
    }

    private String zrnaatkisytktntusy1atkihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNAATKISYTKTNTUSY1ATKIHYJ)
    public String getZrnaatkisytktntusy1atkihyj() {
        return zrnaatkisytktntusy1atkihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnaatkisytktntusy1atkihyj(String pZrnaatkisytktntusy1atkihyj) {
        zrnaatkisytktntusy1atkihyj = pZrnaatkisytktntusy1atkihyj;
    }

    private String zrnaatkisytktntusy2atkihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNAATKISYTKTNTUSY2ATKIHYJ)
    public String getZrnaatkisytktntusy2atkihyj() {
        return zrnaatkisytktntusy2atkihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnaatkisytktntusy2atkihyj(String pZrnaatkisytktntusy2atkihyj) {
        zrnaatkisytktntusy2atkihyj = pZrnaatkisytktntusy2atkihyj;
    }

    private String zrnaatkisyasyokan1atkihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNAATKISYASYOKAN1ATKIHYJ)
    public String getZrnaatkisyasyokan1atkihyj() {
        return zrnaatkisyasyokan1atkihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnaatkisyasyokan1atkihyj(String pZrnaatkisyasyokan1atkihyj) {
        zrnaatkisyasyokan1atkihyj = pZrnaatkisyasyokan1atkihyj;
    }

    private String zrnaatkisyasyokan2atkihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNAATKISYASYOKAN2ATKIHYJ)
    public String getZrnaatkisyasyokan2atkihyj() {
        return zrnaatkisyasyokan2atkihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnaatkisyasyokan2atkihyj(String pZrnaatkisyasyokan2atkihyj) {
        zrnaatkisyasyokan2atkihyj = pZrnaatkisyasyokan2atkihyj;
    }

    private String zrnbatkisytktntusy1atkihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNBATKISYTKTNTUSY1ATKIHYJ)
    public String getZrnbatkisytktntusy1atkihyj() {
        return zrnbatkisytktntusy1atkihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbatkisytktntusy1atkihyj(String pZrnbatkisytktntusy1atkihyj) {
        zrnbatkisytktntusy1atkihyj = pZrnbatkisytktntusy1atkihyj;
    }

    private String zrnbatkisytktntusy2atkihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNBATKISYTKTNTUSY2ATKIHYJ)
    public String getZrnbatkisytktntusy2atkihyj() {
        return zrnbatkisytktntusy2atkihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbatkisytktntusy2atkihyj(String pZrnbatkisytktntusy2atkihyj) {
        zrnbatkisytktntusy2atkihyj = pZrnbatkisytktntusy2atkihyj;
    }

    private String zrnbatkisyasyokan1atkihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNBATKISYASYOKAN1ATKIHYJ)
    public String getZrnbatkisyasyokan1atkihyj() {
        return zrnbatkisyasyokan1atkihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbatkisyasyokan1atkihyj(String pZrnbatkisyasyokan1atkihyj) {
        zrnbatkisyasyokan1atkihyj = pZrnbatkisyasyokan1atkihyj;
    }

    private String zrnbatkisyasyokan2atkihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNBATKISYASYOKAN2ATKIHYJ)
    public String getZrnbatkisyasyokan2atkihyj() {
        return zrnbatkisyasyokan2atkihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnbatkisyasyokan2atkihyj(String pZrnbatkisyasyokan2atkihyj) {
        zrnbatkisyasyokan2atkihyj = pZrnbatkisyasyokan2atkihyj;
    }

    private String zrnkeizokutyuuihyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKEIZOKUTYUUIHYOUJI)
    public String getZrnkeizokutyuuihyouji() {
        return zrnkeizokutyuuihyouji;
    }

    public void setZrnkeizokutyuuihyouji(String pZrnkeizokutyuuihyouji) {
        zrnkeizokutyuuihyouji = pZrnkeizokutyuuihyouji;
    }

    private String zrnkeiyakubisiteihyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKEIYAKUBISITEIHYOUJI)
    public String getZrnkeiyakubisiteihyouji() {
        return zrnkeiyakubisiteihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkeiyakubisiteihyouji(String pZrnkeiyakubisiteihyouji) {
        zrnkeiyakubisiteihyouji = pZrnkeiyakubisiteihyouji;
    }

    private String zrnjyoukentukihyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNJYOUKENTUKIHYOUJI)
    public String getZrnjyoukentukihyouji() {
        return zrnjyoukentukihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyoukentukihyouji(String pZrnjyoukentukihyouji) {
        zrnjyoukentukihyouji = pZrnjyoukentukihyouji;
    }

    private String zrntokuninhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUNINHYOUJI)
    public String getZrntokuninhyouji() {
        return zrntokuninhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuninhyouji(String pZrntokuninhyouji) {
        zrntokuninhyouji = pZrntokuninhyouji;
    }

    private String zrnkessantyouseikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKESSANTYOUSEIKBN)
    public String getZrnkessantyouseikbn() {
        return zrnkessantyouseikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkessantyouseikbn(String pZrnkessantyouseikbn) {
        zrnkessantyouseikbn = pZrnkessantyouseikbn;
    }

    private String zrnhaneihyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHANEIHYOUJI)
    public String getZrnhaneihyouji() {
        return zrnhaneihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhaneihyouji(String pZrnhaneihyouji) {
        zrnhaneihyouji = pZrnhaneihyouji;
    }

    private String zrnsyukinkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYUKINKBN)
    public String getZrnsyukinkbn() {
        return zrnsyukinkbn;
    }

    public void setZrnsyukinkbn(String pZrnsyukinkbn) {
        zrnsyukinkbn = pZrnsyukinkbn;
    }

    private String zrnkeiyakusyasyokugyoucd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKEIYAKUSYASYOKUGYOUCD)
    public String getZrnkeiyakusyasyokugyoucd() {
        return zrnkeiyakusyasyokugyoucd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnkeiyakusyasyokugyoucd(String pZrnkeiyakusyasyokugyoucd) {
        zrnkeiyakusyasyokugyoucd = pZrnkeiyakusyasyokugyoucd;
    }

    private String zrnseikeikeirokbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIKEIKEIROKBN)
    public String getZrnseikeikeirokbn() {
        return zrnseikeikeirokbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseikeikeirokbn(String pZrnseikeikeirokbn) {
        zrnseikeikeirokbn = pZrnseikeikeirokbn;
    }

    private String zrndai2seikeikeirokbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SEIKEIKEIROKBN)
    public String getZrndai2seikeikeirokbn() {
        return zrndai2seikeikeirokbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2seikeikeirokbn(String pZrndai2seikeikeirokbn) {
        zrndai2seikeikeirokbn = pZrndai2seikeikeirokbn;
    }

    private String zrnteigentokuteisyuruikigou;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENTOKUTEISYURUIKIGOU)
    public String getZrnteigentokuteisyuruikigou() {
        return zrnteigentokuteisyuruikigou;
    }

    public void setZrnteigentokuteisyuruikigou(String pZrnteigentokuteisyuruikigou) {
        zrnteigentokuteisyuruikigou = pZrnteigentokuteisyuruikigou;
    }

    private String zrnteigentokuteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENTOKUTEIKIKAN)
    public String getZrnteigentokuteikikan() {
        return zrnteigentokuteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnteigentokuteikikan(String pZrnteigentokuteikikan) {
        zrnteigentokuteikikan = pZrnteigentokuteikikan;
    }

    private Long zrnteigentokuteis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENTOKUTEIS)
    public Long getZrnteigentokuteis() {
        return zrnteigentokuteis;
    }

    public void setZrnteigentokuteis(Long pZrnteigentokuteis) {
        zrnteigentokuteis = pZrnteigentokuteis;
    }

    private Long zrnteigentokuteip;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENTOKUTEIP)
    public Long getZrnteigentokuteip() {
        return zrnteigentokuteip;
    }

    public void setZrnteigentokuteip(Long pZrnteigentokuteip) {
        zrnteigentokuteip = pZrnteigentokuteip;
    }

    private String zrntigntktisdtpdtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNTKTISDTPDTKBN)
    public String getZrntigntktisdtpdtkbn() {
        return zrntigntktisdtpdtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntigntktisdtpdtkbn(String pZrntigntktisdtpdtkbn) {
        zrntigntktisdtpdtkbn = pZrntigntktisdtpdtkbn;
    }

    private Long zrnteigentokuteisyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENTOKUTEISYUUSEIS)
    public Long getZrnteigentokuteisyuuseis() {
        return zrnteigentokuteisyuuseis;
    }

    public void setZrnteigentokuteisyuuseis(Long pZrnteigentokuteisyuuseis) {
        zrnteigentokuteisyuuseis = pZrnteigentokuteisyuuseis;
    }

    private String zrnteigentktimodssakugenhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENTKTIMODSSAKUGENHYJ)
    public String getZrnteigentktimodssakugenhyj() {
        return zrnteigentktimodssakugenhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigentktimodssakugenhyj(String pZrnteigentktimodssakugenhyj) {
        zrnteigentktimodssakugenhyj = pZrnteigentktimodssakugenhyj;
    }

    private String zrnteigentktikgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENTKTIKGUSDKBN)
    public String getZrnteigentktikgusdkbn() {
        return zrnteigentktikgusdkbn;
    }

    public void setZrnteigentktikgusdkbn(String pZrnteigentktikgusdkbn) {
        zrnteigentktikgusdkbn = pZrnteigentktikgusdkbn;
    }

    private String zrnyobiv9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV9)
    public String getZrnyobiv9() {
        return zrnyobiv9;
    }

    public void setZrnyobiv9(String pZrnyobiv9) {
        zrnyobiv9 = pZrnyobiv9;
    }

    private String zrntokuteibuicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUTEIBUICDX1)
    public String getZrntokuteibuicdx1() {
        return zrntokuteibuicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokuteibuicdx1(String pZrntokuteibuicdx1) {
        zrntokuteibuicdx1 = pZrntokuteibuicdx1;
    }

    private String zrnhtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNPKKNX1)
    public String getZrnhtnpkknx1() {
        return zrnhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnpkknx1(String pZrnhtnpkknx1) {
        zrnhtnpkknx1 = pZrnhtnpkknx1;
    }

    private String zrntokuteibuicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUTEIBUICDX2)
    public String getZrntokuteibuicdx2() {
        return zrntokuteibuicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokuteibuicdx2(String pZrntokuteibuicdx2) {
        zrntokuteibuicdx2 = pZrntokuteibuicdx2;
    }

    private String zrnhtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNPKKNX2)
    public String getZrnhtnpkknx2() {
        return zrnhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnpkknx2(String pZrnhtnpkknx2) {
        zrnhtnpkknx2 = pZrnhtnpkknx2;
    }

    private String zrnhhknmei;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHHKNMEI)
    public String getZrnhhknmei() {
        return zrnhhknmei;
    }

    public void setZrnhhknmei(String pZrnhhknmei) {
        zrnhhknmei = pZrnhhknmei;
    }

    private String zrnknjhhknmei;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKNJHHKNMEI)
    public String getZrnknjhhknmei() {
        return zrnknjhhknmei;
    }

    @DataConvert("toMultiByte")
    public void setZrnknjhhknmei(String pZrnknjhhknmei) {
        zrnknjhhknmei = pZrnknjhhknmei;
    }

    private String zrnhhknseiymd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHHKNSEIYMD)
    public String getZrnhhknseiymd() {
        return zrnhhknseiymd;
    }

    public void setZrnhhknseiymd(String pZrnhhknseiymd) {
        zrnhhknseiymd = pZrnhhknseiymd;
    }

    private String zrnhhknseikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHHKNSEIKBN)
    public String getZrnhhknseikbn() {
        return zrnhhknseikbn;
    }

    public void setZrnhhknseikbn(String pZrnhhknseikbn) {
        zrnhhknseikbn = pZrnhhknseikbn;
    }

    private String zrnhhknhnsktodouhukencd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHHKNHNSKTODOUHUKENCD)
    public String getZrnhhknhnsktodouhukencd() {
        return zrnhhknhnsktodouhukencd;
    }

    public void setZrnhhknhnsktodouhukencd(String pZrnhhknhnsktodouhukencd) {
        zrnhhknhnsktodouhukencd = pZrnhhknhnsktodouhukencd;
    }

    private String zrnhihokensyaagev2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIHOKENSYAAGEV2)
    public String getZrnhihokensyaagev2() {
        return zrnhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhihokensyaagev2(String pZrnhihokensyaagev2) {
        zrnhihokensyaagev2 = pZrnhihokensyaagev2;
    }

    private String zrnhihokensyakikykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIHOKENSYAKIKYKARIHYJ)
    public String getZrnhihokensyakikykarihyj() {
        return zrnhihokensyakikykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhihokensyakikykarihyj(String pZrnhihokensyakikykarihyj) {
        zrnhihokensyakikykarihyj = pZrnhihokensyakikykarihyj;
    }

    private String zrnnobikkosaimankikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNOBIKKOSAIMANKIKBN)
    public String getZrnnobikkosaimankikbn() {
        return zrnnobikkosaimankikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnobikkosaimankikbn(String pZrnnobikkosaimankikbn) {
        zrnnobikkosaimankikbn = pZrnnobikkosaimankikbn;
    }

    private String zrnhhknsysysnhonninkknnkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHHKNSYSYSNHONNINKKNNKBN)
    public String getZrnhhknsysysnhonninkknnkbn() {
        return zrnhhknsysysnhonninkknnkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknsysysnhonninkknnkbn(String pZrnhhknsysysnhonninkknnkbn) {
        zrnhhknsysysnhonninkknnkbn = pZrnhhknsysysnhonninkknnkbn;
    }

    private String zrnhhknsysisnhonninkknnkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHHKNSYSISNHONNINKKNNKBN)
    public String getZrnhhknsysisnhonninkknnkbn() {
        return zrnhhknsysisnhonninkknnkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhhknsysisnhonninkknnkbn(String pZrnhhknsysisnhonninkknnkbn) {
        zrnhhknsysisnhonninkknnkbn = pZrnhhknsysisnhonninkknnkbn;
    }

    private String zrnkzktourokuservicearihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKTOUROKUSERVICEARIHYJ)
    public String getZrnkzktourokuservicearihyj() {
        return zrnkzktourokuservicearihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzktourokuservicearihyj(String pZrnkzktourokuservicearihyj) {
        zrnkzktourokuservicearihyj = pZrnkzktourokuservicearihyj;
    }

    private String zrnyobiv4x12;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X12)
    public String getZrnyobiv4x12() {
        return zrnyobiv4x12;
    }

    public void setZrnyobiv4x12(String pZrnyobiv4x12) {
        zrnyobiv4x12 = pZrnyobiv4x12;
    }

    private String zrnhensyuukeiyakusyamei;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHENSYUUKEIYAKUSYAMEI)
    public String getZrnhensyuukeiyakusyamei() {
        return zrnhensyuukeiyakusyamei;
    }

    public void setZrnhensyuukeiyakusyamei(String pZrnhensyuukeiyakusyamei) {
        zrnhensyuukeiyakusyamei = pZrnhensyuukeiyakusyamei;
    }

    private String zrnhnsyuknjkyksynm;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHNSYUKNJKYKSYNM)
    public String getZrnhnsyuknjkyksynm() {
        return zrnhnsyuknjkyksynm;
    }

    @DataConvert("toMultiByte")
    public void setZrnhnsyuknjkyksynm(String pZrnhnsyuknjkyksynm) {
        zrnhnsyuknjkyksynm = pZrnhnsyuknjkyksynm;
    }

    private String zrnkyksyaseiymd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKYKSYASEIYMD)
    public String getZrnkyksyaseiymd() {
        return zrnkyksyaseiymd;
    }

    public void setZrnkyksyaseiymd(String pZrnkyksyaseiymd) {
        zrnkyksyaseiymd = pZrnkyksyaseiymd;
    }

    private String zrnkyksyaseikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKYKSYASEIKBN)
    public String getZrnkyksyaseikbn() {
        return zrnkyksyaseikbn;
    }

    public void setZrnkyksyaseikbn(String pZrnkyksyaseikbn) {
        zrnkyksyaseikbn = pZrnkyksyaseikbn;
    }

    private String zrnkyksyanen;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKYKSYANEN)
    public String getZrnkyksyanen() {
        return zrnkyksyanen;
    }

    public void setZrnkyksyanen(String pZrnkyksyanen) {
        zrnkyksyanen = pZrnkyksyanen;
    }

    private String zrnhknsyuruikigousedaikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHKNSYURUIKIGOUSEDAIKBN)
    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }

    private String zrnknkuzusnzyrt;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKNKUZUSNZYRT)
    public String getZrnknkuzusnzyrt() {
        return zrnknkuzusnzyrt;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnknkuzusnzyrt(String pZrnknkuzusnzyrt) {
        zrnknkuzusnzyrt = pZrnknkuzusnzyrt;
    }

    private String zrnvitdoujimos2kenmeikouhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNVITDOUJIMOS2KENMEIKOUHYJ)
    public String getZrnvitdoujimos2kenmeikouhyj() {
        return zrnvitdoujimos2kenmeikouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnvitdoujimos2kenmeikouhyj(String pZrnvitdoujimos2kenmeikouhyj) {
        zrnvitdoujimos2kenmeikouhyj = pZrnvitdoujimos2kenmeikouhyj;
    }

    private String zrnkikykvitarituikamoshyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKIKYKVITARITUIKAMOSHYJ)
    public String getZrnkikykvitarituikamoshyj() {
        return zrnkikykvitarituikamoshyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkikykvitarituikamoshyj(String pZrnkikykvitarituikamoshyj) {
        zrnkikykvitarituikamoshyj = pZrnkikykvitarituikamoshyj;
    }

    private String zrnhtnknkykvithokenkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKVITHOKENKBN)
    public String getZrnhtnknkykvithokenkbn() {
        return zrnhtnknkykvithokenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykvithokenkbn(String pZrnhtnknkykvithokenkbn) {
        zrnhtnknkykvithokenkbn = pZrnhtnknkykvithokenkbn;
    }

    private String zrnkikykvithokenhoyuujkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKIKYKVITHOKENHOYUUJKKBN)
    public String getZrnkikykvithokenhoyuujkkbn() {
        return zrnkikykvithokenhoyuujkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkikykvithokenhoyuujkkbn(String pZrnkikykvithokenhoyuujkkbn) {
        zrnkikykvithokenhoyuujkkbn = pZrnkikykvithokenhoyuujkkbn;
    }

    private String zrnyobiv2x2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV2X2)
    public String getZrnyobiv2x2() {
        return zrnyobiv2x2;
    }

    public void setZrnyobiv2x2(String pZrnyobiv2x2) {
        zrnyobiv2x2 = pZrnyobiv2x2;
    }

    private String zrntsnsknewyno;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTSNSKNEWYNO)
    public String getZrntsnsknewyno() {
        return zrntsnsknewyno;
    }

    public void setZrntsnsknewyno(String pZrntsnsknewyno) {
        zrntsnsknewyno = pZrntsnsknewyno;
    }

    private String zrntsnsknewtikucd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTSNSKNEWTIKUCD)
    public String getZrntsnsknewtikucd() {
        return zrntsnsknewtikucd;
    }

    public void setZrntsnsknewtikucd(String pZrntsnsknewtikucd) {
        zrntsnsknewtikucd = pZrntsnsknewtikucd;
    }

    private String zrnmossyumtkktymd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMOSSYUMTKKTYMD)
    public String getZrnmossyumtkktymd() {
        return zrnmossyumtkktymd;
    }

    public void setZrnmossyumtkktymd(String pZrnmossyumtkktymd) {
        zrnmossyumtkktymd = pZrnmossyumtkktymd;
    }

    private String zrnkituenkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKITUENKBN)
    public String getZrnkituenkbn() {
        return zrnkituenkbn;
    }

    public void setZrnkituenkbn(String pZrnkituenkbn) {
        zrnkituenkbn = pZrnkituenkbn;
    }

    private String zrntuusinsakijyuusyokbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTUUSINSAKIJYUUSYOKBN)
    public String getZrntuusinsakijyuusyokbn() {
        return zrntuusinsakijyuusyokbn;
    }

    public void setZrntuusinsakijyuusyokbn(String pZrntuusinsakijyuusyokbn) {
        zrntuusinsakijyuusyokbn = pZrntuusinsakijyuusyokbn;
    }

    private String zrnmaruteisyuruikigou;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEISYURUIKIGOU)
    public String getZrnmaruteisyuruikigou() {
        return zrnmaruteisyuruikigou;
    }

    public void setZrnmaruteisyuruikigou(String pZrnmaruteisyuruikigou) {
        zrnmaruteisyuruikigou = pZrnmaruteisyuruikigou;
    }

    private String zrnmaruteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEIKIKAN)
    public String getZrnmaruteikikan() {
        return zrnmaruteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmaruteikikan(String pZrnmaruteikikan) {
        zrnmaruteikikan = pZrnmaruteikikan;
    }

    private String zrnmaruteiphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEIPHRKKKN)
    public String getZrnmaruteiphrkkkn() {
        return zrnmaruteiphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmaruteiphrkkkn(String pZrnmaruteiphrkkkn) {
        zrnmaruteiphrkkkn = pZrnmaruteiphrkkkn;
    }

    private Long zrnmaruteis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEIS)
    public Long getZrnmaruteis() {
        return zrnmaruteis;
    }

    public void setZrnmaruteis(Long pZrnmaruteis) {
        zrnmaruteis = pZrnmaruteis;
    }

    private Long zrnmaruteip;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEIP)
    public Long getZrnmaruteip() {
        return zrnmaruteip;
    }

    public void setZrnmaruteip(Long pZrnmaruteip) {
        zrnmaruteip = pZrnmaruteip;
    }

    private Long zrnmaruteisyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEISYUUSEIS)
    public Long getZrnmaruteisyuuseis() {
        return zrnmaruteisyuuseis;
    }

    public void setZrnmaruteisyuuseis(Long pZrnmaruteisyuuseis) {
        zrnmaruteisyuuseis = pZrnmaruteisyuuseis;
    }

    private String zrnmaruteisyuuseisskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEISYUUSEISSKGNHYJ)
    public String getZrnmaruteisyuuseisskgnhyj() {
        return zrnmaruteisyuuseisskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteisyuuseisskgnhyj(String pZrnmaruteisyuuseisskgnhyj) {
        zrnmaruteisyuuseisskgnhyj = pZrnmaruteisyuuseisskgnhyj;
    }

    private String zrnmaruteitokujyoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEITOKUJYOUKBN)
    public String getZrnmaruteitokujyoukbn() {
        return zrnmaruteitokujyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruteitokujyoukbn(String pZrnmaruteitokujyoukbn) {
        zrnmaruteitokujyoukbn = pZrnmaruteitokujyoukbn;
    }

    private String zrnmrtitkjyuskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMRTITKJYUSKGNKKN)
    public String getZrnmrtitkjyuskgnkkn() {
        return zrnmrtitkjyuskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmrtitkjyuskgnkkn(String pZrnmrtitkjyuskgnkkn) {
        zrnmrtitkjyuskgnkkn = pZrnmrtitkjyuskgnkkn;
    }

    private Integer zrnmrtitkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMRTITKJYURYUMSHYUTN)
    public Integer getZrnmrtitkjyuryumshyutn() {
        return zrnmrtitkjyuryumshyutn;
    }

    public void setZrnmrtitkjyuryumshyutn(Integer pZrnmrtitkjyuryumshyutn) {
        zrnmrtitkjyuryumshyutn = pZrnmrtitkjyuryumshyutn;
    }

    private Long zrnmaruteitokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEITOKUJYOUP)
    public Long getZrnmaruteitokujyoup() {
        return zrnmaruteitokujyoup;
    }

    public void setZrnmaruteitokujyoup(Long pZrnmaruteitokujyoup) {
        zrnmaruteitokujyoup = pZrnmaruteitokujyoup;
    }

    private String zrnsuryumrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSURYUMRTIPWRBKKBN)
    public String getZrnsuryumrtipwrbkkbn() {
        return zrnsuryumrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuryumrtipwrbkkbn(String pZrnsuryumrtipwrbkkbn) {
        zrnsuryumrtipwrbkkbn = pZrnsuryumrtipwrbkkbn;
    }

    private String zrnmaruteipwaribikikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEIPWARIBIKIKBN)
    public String getZrnmaruteipwaribikikbn() {
        return zrnmaruteipwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmaruteipwaribikikbn(String pZrnmaruteipwaribikikbn) {
        zrnmaruteipwaribikikbn = pZrnmaruteipwaribikikbn;
    }

    private String zrnmrtitnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMRTITNKNYUGUKBN)
    public String getZrnmrtitnknyugukbn() {
        return zrnmrtitnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmrtitnknyugukbn(String pZrnmrtitnknyugukbn) {
        zrnmrtitnknyugukbn = pZrnmrtitnknyugukbn;
    }

    private String zrnmaruteikigousedaikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEIKIGOUSEDAIKBN)
    public String getZrnmaruteikigousedaikbn() {
        return zrnmaruteikigousedaikbn;
    }

    public void setZrnmaruteikigousedaikbn(String pZrnmaruteikigousedaikbn) {
        zrnmaruteikigousedaikbn = pZrnmaruteikigousedaikbn;
    }

    private String zrnmaruteikikousnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEIKIKOUSNMNRYOAGE)
    public String getZrnmaruteikikousnmnryoage() {
        return zrnmaruteikikousnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmaruteikikousnmnryoage(String pZrnmaruteikikousnmnryoage) {
        zrnmaruteikikousnmnryoage = pZrnmaruteikikousnmnryoage;
    }

    private String zrnyobiv2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV2)
    public String getZrnyobiv2() {
        return zrnyobiv2;
    }

    public void setZrnyobiv2(String pZrnyobiv2) {
        zrnyobiv2 = pZrnyobiv2;
    }

    private String zrnmaruyousyuruikigou;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUYOUSYURUIKIGOU)
    public String getZrnmaruyousyuruikigou() {
        return zrnmaruyousyuruikigou;
    }

    public void setZrnmaruyousyuruikigou(String pZrnmaruyousyuruikigou) {
        zrnmaruyousyuruikigou = pZrnmaruyousyuruikigou;
    }

    private String zrnmaruyoukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUYOUKIKAN)
    public String getZrnmaruyoukikan() {
        return zrnmaruyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmaruyoukikan(String pZrnmaruyoukikan) {
        zrnmaruyoukikan = pZrnmaruyoukikan;
    }

    private Long zrnmaruyous;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUYOUS)
    public Long getZrnmaruyous() {
        return zrnmaruyous;
    }

    public void setZrnmaruyous(Long pZrnmaruyous) {
        zrnmaruyous = pZrnmaruyous;
    }

    private Long zrnmaruyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUYOUP)
    public Long getZrnmaruyoup() {
        return zrnmaruyoup;
    }

    public void setZrnmaruyoup(Long pZrnmaruyoup) {
        zrnmaruyoup = pZrnmaruyoup;
    }

    private String zrnmaruyousdatepdatekbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUYOUSDATEPDATEKBN)
    public String getZrnmaruyousdatepdatekbn() {
        return zrnmaruyousdatepdatekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruyousdatepdatekbn(String pZrnmaruyousdatepdatekbn) {
        zrnmaruyousdatepdatekbn = pZrnmaruyousdatepdatekbn;
    }

    private Long zrnmaruyousyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUYOUSYUUSEIS)
    public Long getZrnmaruyousyuuseis() {
        return zrnmaruyousyuuseis;
    }

    public void setZrnmaruyousyuuseis(Long pZrnmaruyousyuuseis) {
        zrnmaruyousyuuseis = pZrnmaruyousyuuseis;
    }

    private String zrnmaruyousyuuseisskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUYOUSYUUSEISSKGNHYJ)
    public String getZrnmaruyousyuuseisskgnhyj() {
        return zrnmaruyousyuuseisskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmaruyousyuuseisskgnhyj(String pZrnmaruyousyuuseisskgnhyj) {
        zrnmaruyousyuuseisskgnhyj = pZrnmaruyousyuuseisskgnhyj;
    }

    private String zrnmaruyoukigousedaikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUYOUKIGOUSEDAIKBN)
    public String getZrnmaruyoukigousedaikbn() {
        return zrnmaruyoukigousedaikbn;
    }

    public void setZrnmaruyoukigousedaikbn(String pZrnmaruyoukigousedaikbn) {
        zrnmaruyoukigousedaikbn = pZrnmaruyoukigousedaikbn;
    }

    private String zrnyobiv9x3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV9X3)
    public String getZrnyobiv9x3() {
        return zrnyobiv9x3;
    }

    public void setZrnyobiv9x3(String pZrnyobiv9x3) {
        zrnyobiv9x3 = pZrnyobiv9x3;
    }

    private String zrnmarusyuusyuruikigou;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUSYUUSYURUIKIGOU)
    public String getZrnmarusyuusyuruikigou() {
        return zrnmarusyuusyuruikigou;
    }

    public void setZrnmarusyuusyuruikigou(String pZrnmarusyuusyuruikigou) {
        zrnmarusyuusyuruikigou = pZrnmarusyuusyuruikigou;
    }

    private String zrnmarusyuukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUSYUUKIKAN)
    public String getZrnmarusyuukikan() {
        return zrnmarusyuukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmarusyuukikan(String pZrnmarusyuukikan) {
        zrnmarusyuukikan = pZrnmarusyuukikan;
    }

    private Long zrnmarusyuus;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUSYUUS)
    public Long getZrnmarusyuus() {
        return zrnmarusyuus;
    }

    public void setZrnmarusyuus(Long pZrnmarusyuus) {
        zrnmarusyuus = pZrnmarusyuus;
    }

    private Long zrnmarusyuup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUSYUUP)
    public Long getZrnmarusyuup() {
        return zrnmarusyuup;
    }

    public void setZrnmarusyuup(Long pZrnmarusyuup) {
        zrnmarusyuup = pZrnmarusyuup;
    }

    private String zrnmarusyuusdatepdatekbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUSYUUSDATEPDATEKBN)
    public String getZrnmarusyuusdatepdatekbn() {
        return zrnmarusyuusdatepdatekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmarusyuusdatepdatekbn(String pZrnmarusyuusdatepdatekbn) {
        zrnmarusyuusdatepdatekbn = pZrnmarusyuusdatepdatekbn;
    }

    private Long zrnmarusyuusyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUSYUUSYUUSEIS)
    public Long getZrnmarusyuusyuuseis() {
        return zrnmarusyuusyuuseis;
    }

    public void setZrnmarusyuusyuuseis(Long pZrnmarusyuusyuuseis) {
        zrnmarusyuusyuuseis = pZrnmarusyuusyuuseis;
    }

    private String zrnmarusyuusyuuseisskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUSYUUSYUUSEISSKGNHYJ)
    public String getZrnmarusyuusyuuseisskgnhyj() {
        return zrnmarusyuusyuuseisskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnmarusyuusyuuseisskgnhyj(String pZrnmarusyuusyuuseisskgnhyj) {
        zrnmarusyuusyuuseisskgnhyj = pZrnmarusyuusyuuseisskgnhyj;
    }

    private String zrnmarusyuukigousedaikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUSYUUKIGOUSEDAIKBN)
    public String getZrnmarusyuukigousedaikbn() {
        return zrnmarusyuukigousedaikbn;
    }

    public void setZrnmarusyuukigousedaikbn(String pZrnmarusyuukigousedaikbn) {
        zrnmarusyuukigousedaikbn = pZrnmarusyuukigousedaikbn;
    }

    private String zrnyobiv9x4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV9X4)
    public String getZrnyobiv9x4() {
        return zrnyobiv9x4;
    }

    public void setZrnyobiv9x4(String pZrnyobiv9x4) {
        zrnyobiv9x4 = pZrnyobiv9x4;
    }

    private String zrntokuteisyuruikigou;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUTEISYURUIKIGOU)
    public String getZrntokuteisyuruikigou() {
        return zrntokuteisyuruikigou;
    }

    public void setZrntokuteisyuruikigou(String pZrntokuteisyuruikigou) {
        zrntokuteisyuruikigou = pZrntokuteisyuruikigou;
    }

    private String zrntokuteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUTEIKIKAN)
    public String getZrntokuteikikan() {
        return zrntokuteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntokuteikikan(String pZrntokuteikikan) {
        zrntokuteikikan = pZrntokuteikikan;
    }

    private Long zrntokuteis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUTEIS)
    public Long getZrntokuteis() {
        return zrntokuteis;
    }

    public void setZrntokuteis(Long pZrntokuteis) {
        zrntokuteis = pZrntokuteis;
    }

    private Long zrntokuteip;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUTEIP)
    public Long getZrntokuteip() {
        return zrntokuteip;
    }

    public void setZrntokuteip(Long pZrntokuteip) {
        zrntokuteip = pZrntokuteip;
    }

    private String zrntokuteisdatepdatekbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUTEISDATEPDATEKBN)
    public String getZrntokuteisdatepdatekbn() {
        return zrntokuteisdatepdatekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteisdatepdatekbn(String pZrntokuteisdatepdatekbn) {
        zrntokuteisdatepdatekbn = pZrntokuteisdatepdatekbn;
    }

    private Long zrntokuteisyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUTEISYUUSEIS)
    public Long getZrntokuteisyuuseis() {
        return zrntokuteisyuuseis;
    }

    public void setZrntokuteisyuuseis(Long pZrntokuteisyuuseis) {
        zrntokuteisyuuseis = pZrntokuteisyuuseis;
    }

    private String zrntokuteisyuuseisskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUTEISYUUSEISSKGNHYJ)
    public String getZrntokuteisyuuseisskgnhyj() {
        return zrntokuteisyuuseisskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntokuteisyuuseisskgnhyj(String pZrntokuteisyuuseisskgnhyj) {
        zrntokuteisyuuseisskgnhyj = pZrntokuteisyuuseisskgnhyj;
    }

    private String zrntokuteikigousedaikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUTEIKIGOUSEDAIKBN)
    public String getZrntokuteikigousedaikbn() {
        return zrntokuteikigousedaikbn;
    }

    public void setZrntokuteikigousedaikbn(String pZrntokuteikigousedaikbn) {
        zrntokuteikigousedaikbn = pZrntokuteikigousedaikbn;
    }

    private String zrnyobiv9x5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV9X5)
    public String getZrnyobiv9x5() {
        return zrnyobiv9x5;
    }

    public void setZrnyobiv9x5(String pZrnyobiv9x5) {
        zrnyobiv9x5 = pZrnyobiv9x5;
    }

    private String zrnkzkmrtitkyknox1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITKYKNOX1)
    public String getZrnkzkmrtitkyknox1() {
        return zrnkzkmrtitkyknox1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitkyknox1(String pZrnkzkmrtitkyknox1) {
        zrnkzkmrtitkyknox1 = pZrnkzkmrtitkyknox1;
    }

    private String zrnkazokumrtisyuruikgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTISYURUIKGUX1)
    public String getZrnkazokumrtisyuruikgux1() {
        return zrnkazokumrtisyuruikgux1;
    }

    public void setZrnkazokumrtisyuruikgux1(String pZrnkazokumrtisyuruikgux1) {
        zrnkazokumrtisyuruikgux1 = pZrnkazokumrtisyuruikgux1;
    }

    private String zrnkazokumaruteikikanx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIKIKANX1)
    public String getZrnkazokumaruteikikanx1() {
        return zrnkazokumaruteikikanx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumaruteikikanx1(String pZrnkazokumaruteikikanx1) {
        zrnkazokumaruteikikanx1 = pZrnkazokumaruteikikanx1;
    }

    private String zrnkazokumrtiphrkkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIPHRKKKNX1)
    public String getZrnkazokumrtiphrkkknx1() {
        return zrnkazokumrtiphrkkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtiphrkkknx1(String pZrnkazokumrtiphrkkknx1) {
        zrnkazokumrtiphrkkknx1 = pZrnkazokumrtiphrkkknx1;
    }

    private Long zrnkazokumaruteisx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEISX1)
    public Long getZrnkazokumaruteisx1() {
        return zrnkazokumaruteisx1;
    }

    public void setZrnkazokumaruteisx1(Long pZrnkazokumaruteisx1) {
        zrnkazokumaruteisx1 = pZrnkazokumaruteisx1;
    }

    private Long zrnkazokumaruteipx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIPX1)
    public Long getZrnkazokumaruteipx1() {
        return zrnkazokumaruteipx1;
    }

    public void setZrnkazokumaruteipx1(Long pZrnkazokumaruteipx1) {
        zrnkazokumaruteipx1 = pZrnkazokumaruteipx1;
    }

    private String zrnkzkmrtihihknsyanmx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYANMX1)
    public String getZrnkzkmrtihihknsyanmx1() {
        return zrnkzkmrtihihknsyanmx1;
    }

    public void setZrnkzkmrtihihknsyanmx1(String pZrnkzkmrtihihknsyanmx1) {
        zrnkzkmrtihihknsyanmx1 = pZrnkzkmrtihihknsyanmx1;
    }

    private String zrnkzkmrtihihknsyseiymdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSEIYMDX1)
    public String getZrnkzkmrtihihknsyseiymdx1() {
        return zrnkzkmrtihihknsyseiymdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkzkmrtihihknsyseiymdx1(String pZrnkzkmrtihihknsyseiymdx1) {
        zrnkzkmrtihihknsyseiymdx1 = pZrnkzkmrtihihknsyseiymdx1;
    }

    private String zrnkzkmrtihihknsysibtkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSIBTKBNX1)
    public String getZrnkzkmrtihihknsysibtkbnx1() {
        return zrnkzkmrtihihknsysibtkbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtihihknsysibtkbnx1(String pZrnkzkmrtihihknsysibtkbnx1) {
        zrnkzkmrtihihknsysibtkbnx1 = pZrnkzkmrtihihknsysibtkbnx1;
    }

    private String zrnkazokumrtihihknsyaagex1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIHIHKNSYAAGEX1)
    public String getZrnkazokumrtihihknsyaagex1() {
        return zrnkazokumrtihihknsyaagex1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtihihknsyaagex1(String pZrnkazokumrtihihknsyaagex1) {
        zrnkazokumrtihihknsyaagex1 = pZrnkazokumrtihihknsyaagex1;
    }

    private Long zrnkzkmrtimodsx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIMODSX1)
    public Long getZrnkzkmrtimodsx1() {
        return zrnkzkmrtimodsx1;
    }

    public void setZrnkzkmrtimodsx1(Long pZrnkzkmrtimodsx1) {
        zrnkzkmrtimodsx1 = pZrnkzkmrtimodsx1;
    }

    private String zrnkazokumrtimodsskgnhyjx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIMODSSKGNHYJX1)
    public String getZrnkazokumrtimodsskgnhyjx1() {
        return zrnkazokumrtimodsskgnhyjx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtimodsskgnhyjx1(String pZrnkazokumrtimodsskgnhyjx1) {
        zrnkazokumrtimodsskgnhyjx1 = pZrnkazokumrtimodsskgnhyjx1;
    }

    private String zrnkzkmrtitnknyugukbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITNKNYUGUKBNX1)
    public String getZrnkzkmrtitnknyugukbnx1() {
        return zrnkzkmrtitnknyugukbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitnknyugukbnx1(String pZrnkzkmrtitnknyugukbnx1) {
        zrnkzkmrtitnknyugukbnx1 = pZrnkzkmrtitnknyugukbnx1;
    }

    private String zrnkazokumrtikgusdkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIKGUSDKBNX1)
    public String getZrnkazokumrtikgusdkbnx1() {
        return zrnkazokumrtikgusdkbnx1;
    }

    public void setZrnkazokumrtikgusdkbnx1(String pZrnkazokumrtikgusdkbnx1) {
        zrnkazokumrtikgusdkbnx1 = pZrnkazokumrtikgusdkbnx1;
    }

    private String zrnkazokumrtiagetyusihyjx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIAGETYUSIHYJX1)
    public String getZrnkazokumrtiagetyusihyjx1() {
        return zrnkazokumrtiagetyusihyjx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtiagetyusihyjx1(String pZrnkazokumrtiagetyusihyjx1) {
        zrnkazokumrtiagetyusihyjx1 = pZrnkazokumrtiagetyusihyjx1;
    }

    private String zrnkzkmrtikusnmnryoagex1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIKUSNMNRYOAGEX1)
    public String getZrnkzkmrtikusnmnryoagex1() {
        return zrnkzkmrtikusnmnryoagex1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtikusnmnryoagex1(String pZrnkzkmrtikusnmnryoagex1) {
        zrnkzkmrtikusnmnryoagex1 = pZrnkzkmrtikusnmnryoagex1;
    }

    private String zrnyobiv4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4)
    public String getZrnyobiv4() {
        return zrnyobiv4;
    }

    public void setZrnyobiv4(String pZrnyobiv4) {
        zrnyobiv4 = pZrnyobiv4;
    }

    private String zrnkzkmrtitkyknox2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITKYKNOX2)
    public String getZrnkzkmrtitkyknox2() {
        return zrnkzkmrtitkyknox2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitkyknox2(String pZrnkzkmrtitkyknox2) {
        zrnkzkmrtitkyknox2 = pZrnkzkmrtitkyknox2;
    }

    private String zrnkazokumrtisyuruikgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTISYURUIKGUX2)
    public String getZrnkazokumrtisyuruikgux2() {
        return zrnkazokumrtisyuruikgux2;
    }

    public void setZrnkazokumrtisyuruikgux2(String pZrnkazokumrtisyuruikgux2) {
        zrnkazokumrtisyuruikgux2 = pZrnkazokumrtisyuruikgux2;
    }

    private String zrnkazokumaruteikikanx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIKIKANX2)
    public String getZrnkazokumaruteikikanx2() {
        return zrnkazokumaruteikikanx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumaruteikikanx2(String pZrnkazokumaruteikikanx2) {
        zrnkazokumaruteikikanx2 = pZrnkazokumaruteikikanx2;
    }

    private String zrnkazokumrtiphrkkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIPHRKKKNX2)
    public String getZrnkazokumrtiphrkkknx2() {
        return zrnkazokumrtiphrkkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtiphrkkknx2(String pZrnkazokumrtiphrkkknx2) {
        zrnkazokumrtiphrkkknx2 = pZrnkazokumrtiphrkkknx2;
    }

    private Long zrnkazokumaruteisx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEISX2)
    public Long getZrnkazokumaruteisx2() {
        return zrnkazokumaruteisx2;
    }

    public void setZrnkazokumaruteisx2(Long pZrnkazokumaruteisx2) {
        zrnkazokumaruteisx2 = pZrnkazokumaruteisx2;
    }

    private Long zrnkazokumaruteipx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIPX2)
    public Long getZrnkazokumaruteipx2() {
        return zrnkazokumaruteipx2;
    }

    public void setZrnkazokumaruteipx2(Long pZrnkazokumaruteipx2) {
        zrnkazokumaruteipx2 = pZrnkazokumaruteipx2;
    }

    private String zrnkzkmrtihihknsyanmx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYANMX2)
    public String getZrnkzkmrtihihknsyanmx2() {
        return zrnkzkmrtihihknsyanmx2;
    }

    public void setZrnkzkmrtihihknsyanmx2(String pZrnkzkmrtihihknsyanmx2) {
        zrnkzkmrtihihknsyanmx2 = pZrnkzkmrtihihknsyanmx2;
    }

    private String zrnkzkmrtihihknsyseiymdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSEIYMDX2)
    public String getZrnkzkmrtihihknsyseiymdx2() {
        return zrnkzkmrtihihknsyseiymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkzkmrtihihknsyseiymdx2(String pZrnkzkmrtihihknsyseiymdx2) {
        zrnkzkmrtihihknsyseiymdx2 = pZrnkzkmrtihihknsyseiymdx2;
    }

    private String zrnkzkmrtihihknsysibtkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSIBTKBNX2)
    public String getZrnkzkmrtihihknsysibtkbnx2() {
        return zrnkzkmrtihihknsysibtkbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtihihknsysibtkbnx2(String pZrnkzkmrtihihknsysibtkbnx2) {
        zrnkzkmrtihihknsysibtkbnx2 = pZrnkzkmrtihihknsysibtkbnx2;
    }

    private String zrnkazokumrtihihknsyaagex2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIHIHKNSYAAGEX2)
    public String getZrnkazokumrtihihknsyaagex2() {
        return zrnkazokumrtihihknsyaagex2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtihihknsyaagex2(String pZrnkazokumrtihihknsyaagex2) {
        zrnkazokumrtihihknsyaagex2 = pZrnkazokumrtihihknsyaagex2;
    }

    private Long zrnkzkmrtimodsx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIMODSX2)
    public Long getZrnkzkmrtimodsx2() {
        return zrnkzkmrtimodsx2;
    }

    public void setZrnkzkmrtimodsx2(Long pZrnkzkmrtimodsx2) {
        zrnkzkmrtimodsx2 = pZrnkzkmrtimodsx2;
    }

    private String zrnkazokumrtimodsskgnhyjx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIMODSSKGNHYJX2)
    public String getZrnkazokumrtimodsskgnhyjx2() {
        return zrnkazokumrtimodsskgnhyjx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtimodsskgnhyjx2(String pZrnkazokumrtimodsskgnhyjx2) {
        zrnkazokumrtimodsskgnhyjx2 = pZrnkazokumrtimodsskgnhyjx2;
    }

    private String zrnkzkmrtitnknyugukbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITNKNYUGUKBNX2)
    public String getZrnkzkmrtitnknyugukbnx2() {
        return zrnkzkmrtitnknyugukbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitnknyugukbnx2(String pZrnkzkmrtitnknyugukbnx2) {
        zrnkzkmrtitnknyugukbnx2 = pZrnkzkmrtitnknyugukbnx2;
    }

    private String zrnkazokumrtikgusdkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIKGUSDKBNX2)
    public String getZrnkazokumrtikgusdkbnx2() {
        return zrnkazokumrtikgusdkbnx2;
    }

    public void setZrnkazokumrtikgusdkbnx2(String pZrnkazokumrtikgusdkbnx2) {
        zrnkazokumrtikgusdkbnx2 = pZrnkazokumrtikgusdkbnx2;
    }

    private String zrnkazokumrtiagetyusihyjx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIAGETYUSIHYJX2)
    public String getZrnkazokumrtiagetyusihyjx2() {
        return zrnkazokumrtiagetyusihyjx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtiagetyusihyjx2(String pZrnkazokumrtiagetyusihyjx2) {
        zrnkazokumrtiagetyusihyjx2 = pZrnkazokumrtiagetyusihyjx2;
    }

    private String zrnkzkmrtikusnmnryoagex2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIKUSNMNRYOAGEX2)
    public String getZrnkzkmrtikusnmnryoagex2() {
        return zrnkzkmrtikusnmnryoagex2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtikusnmnryoagex2(String pZrnkzkmrtikusnmnryoagex2) {
        zrnkzkmrtikusnmnryoagex2 = pZrnkzkmrtikusnmnryoagex2;
    }

    private String zrnyobiv4x2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X2)
    public String getZrnyobiv4x2() {
        return zrnyobiv4x2;
    }

    public void setZrnyobiv4x2(String pZrnyobiv4x2) {
        zrnyobiv4x2 = pZrnyobiv4x2;
    }

    private String zrnkzkmrtitkyknox3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITKYKNOX3)
    public String getZrnkzkmrtitkyknox3() {
        return zrnkzkmrtitkyknox3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitkyknox3(String pZrnkzkmrtitkyknox3) {
        zrnkzkmrtitkyknox3 = pZrnkzkmrtitkyknox3;
    }

    private String zrnkazokumrtisyuruikgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTISYURUIKGUX3)
    public String getZrnkazokumrtisyuruikgux3() {
        return zrnkazokumrtisyuruikgux3;
    }

    public void setZrnkazokumrtisyuruikgux3(String pZrnkazokumrtisyuruikgux3) {
        zrnkazokumrtisyuruikgux3 = pZrnkazokumrtisyuruikgux3;
    }

    private String zrnkazokumaruteikikanx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIKIKANX3)
    public String getZrnkazokumaruteikikanx3() {
        return zrnkazokumaruteikikanx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumaruteikikanx3(String pZrnkazokumaruteikikanx3) {
        zrnkazokumaruteikikanx3 = pZrnkazokumaruteikikanx3;
    }

    private String zrnkazokumrtiphrkkknx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIPHRKKKNX3)
    public String getZrnkazokumrtiphrkkknx3() {
        return zrnkazokumrtiphrkkknx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtiphrkkknx3(String pZrnkazokumrtiphrkkknx3) {
        zrnkazokumrtiphrkkknx3 = pZrnkazokumrtiphrkkknx3;
    }

    private Long zrnkazokumaruteisx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEISX3)
    public Long getZrnkazokumaruteisx3() {
        return zrnkazokumaruteisx3;
    }

    public void setZrnkazokumaruteisx3(Long pZrnkazokumaruteisx3) {
        zrnkazokumaruteisx3 = pZrnkazokumaruteisx3;
    }

    private Long zrnkazokumaruteipx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIPX3)
    public Long getZrnkazokumaruteipx3() {
        return zrnkazokumaruteipx3;
    }

    public void setZrnkazokumaruteipx3(Long pZrnkazokumaruteipx3) {
        zrnkazokumaruteipx3 = pZrnkazokumaruteipx3;
    }

    private String zrnkzkmrtihihknsyanmx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYANMX3)
    public String getZrnkzkmrtihihknsyanmx3() {
        return zrnkzkmrtihihknsyanmx3;
    }

    public void setZrnkzkmrtihihknsyanmx3(String pZrnkzkmrtihihknsyanmx3) {
        zrnkzkmrtihihknsyanmx3 = pZrnkzkmrtihihknsyanmx3;
    }

    private String zrnkzkmrtihihknsyseiymdx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSEIYMDX3)
    public String getZrnkzkmrtihihknsyseiymdx3() {
        return zrnkzkmrtihihknsyseiymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkzkmrtihihknsyseiymdx3(String pZrnkzkmrtihihknsyseiymdx3) {
        zrnkzkmrtihihknsyseiymdx3 = pZrnkzkmrtihihknsyseiymdx3;
    }

    private String zrnkzkmrtihihknsysibtkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSIBTKBNX3)
    public String getZrnkzkmrtihihknsysibtkbnx3() {
        return zrnkzkmrtihihknsysibtkbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtihihknsysibtkbnx3(String pZrnkzkmrtihihknsysibtkbnx3) {
        zrnkzkmrtihihknsysibtkbnx3 = pZrnkzkmrtihihknsysibtkbnx3;
    }

    private String zrnkazokumrtihihknsyaagex3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIHIHKNSYAAGEX3)
    public String getZrnkazokumrtihihknsyaagex3() {
        return zrnkazokumrtihihknsyaagex3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtihihknsyaagex3(String pZrnkazokumrtihihknsyaagex3) {
        zrnkazokumrtihihknsyaagex3 = pZrnkazokumrtihihknsyaagex3;
    }

    private Long zrnkzkmrtimodsx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIMODSX3)
    public Long getZrnkzkmrtimodsx3() {
        return zrnkzkmrtimodsx3;
    }

    public void setZrnkzkmrtimodsx3(Long pZrnkzkmrtimodsx3) {
        zrnkzkmrtimodsx3 = pZrnkzkmrtimodsx3;
    }

    private String zrnkazokumrtimodsskgnhyjx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIMODSSKGNHYJX3)
    public String getZrnkazokumrtimodsskgnhyjx3() {
        return zrnkazokumrtimodsskgnhyjx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtimodsskgnhyjx3(String pZrnkazokumrtimodsskgnhyjx3) {
        zrnkazokumrtimodsskgnhyjx3 = pZrnkazokumrtimodsskgnhyjx3;
    }

    private String zrnkzkmrtitnknyugukbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITNKNYUGUKBNX3)
    public String getZrnkzkmrtitnknyugukbnx3() {
        return zrnkzkmrtitnknyugukbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitnknyugukbnx3(String pZrnkzkmrtitnknyugukbnx3) {
        zrnkzkmrtitnknyugukbnx3 = pZrnkzkmrtitnknyugukbnx3;
    }

    private String zrnkazokumrtikgusdkbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIKGUSDKBNX3)
    public String getZrnkazokumrtikgusdkbnx3() {
        return zrnkazokumrtikgusdkbnx3;
    }

    public void setZrnkazokumrtikgusdkbnx3(String pZrnkazokumrtikgusdkbnx3) {
        zrnkazokumrtikgusdkbnx3 = pZrnkazokumrtikgusdkbnx3;
    }

    private String zrnkazokumrtiagetyusihyjx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIAGETYUSIHYJX3)
    public String getZrnkazokumrtiagetyusihyjx3() {
        return zrnkazokumrtiagetyusihyjx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtiagetyusihyjx3(String pZrnkazokumrtiagetyusihyjx3) {
        zrnkazokumrtiagetyusihyjx3 = pZrnkazokumrtiagetyusihyjx3;
    }

    private String zrnkzkmrtikusnmnryoagex3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIKUSNMNRYOAGEX3)
    public String getZrnkzkmrtikusnmnryoagex3() {
        return zrnkzkmrtikusnmnryoagex3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtikusnmnryoagex3(String pZrnkzkmrtikusnmnryoagex3) {
        zrnkzkmrtikusnmnryoagex3 = pZrnkzkmrtikusnmnryoagex3;
    }

    private String zrnyobiv4x3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X3)
    public String getZrnyobiv4x3() {
        return zrnyobiv4x3;
    }

    public void setZrnyobiv4x3(String pZrnyobiv4x3) {
        zrnyobiv4x3 = pZrnyobiv4x3;
    }

    private String zrnkzkmrtitkyknox4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITKYKNOX4)
    public String getZrnkzkmrtitkyknox4() {
        return zrnkzkmrtitkyknox4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitkyknox4(String pZrnkzkmrtitkyknox4) {
        zrnkzkmrtitkyknox4 = pZrnkzkmrtitkyknox4;
    }

    private String zrnkazokumrtisyuruikgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTISYURUIKGUX4)
    public String getZrnkazokumrtisyuruikgux4() {
        return zrnkazokumrtisyuruikgux4;
    }

    public void setZrnkazokumrtisyuruikgux4(String pZrnkazokumrtisyuruikgux4) {
        zrnkazokumrtisyuruikgux4 = pZrnkazokumrtisyuruikgux4;
    }

    private String zrnkazokumaruteikikanx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIKIKANX4)
    public String getZrnkazokumaruteikikanx4() {
        return zrnkazokumaruteikikanx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumaruteikikanx4(String pZrnkazokumaruteikikanx4) {
        zrnkazokumaruteikikanx4 = pZrnkazokumaruteikikanx4;
    }

    private String zrnkazokumrtiphrkkknx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIPHRKKKNX4)
    public String getZrnkazokumrtiphrkkknx4() {
        return zrnkazokumrtiphrkkknx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtiphrkkknx4(String pZrnkazokumrtiphrkkknx4) {
        zrnkazokumrtiphrkkknx4 = pZrnkazokumrtiphrkkknx4;
    }

    private Long zrnkazokumaruteisx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEISX4)
    public Long getZrnkazokumaruteisx4() {
        return zrnkazokumaruteisx4;
    }

    public void setZrnkazokumaruteisx4(Long pZrnkazokumaruteisx4) {
        zrnkazokumaruteisx4 = pZrnkazokumaruteisx4;
    }

    private Long zrnkazokumaruteipx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIPX4)
    public Long getZrnkazokumaruteipx4() {
        return zrnkazokumaruteipx4;
    }

    public void setZrnkazokumaruteipx4(Long pZrnkazokumaruteipx4) {
        zrnkazokumaruteipx4 = pZrnkazokumaruteipx4;
    }

    private String zrnkzkmrtihihknsyanmx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYANMX4)
    public String getZrnkzkmrtihihknsyanmx4() {
        return zrnkzkmrtihihknsyanmx4;
    }

    public void setZrnkzkmrtihihknsyanmx4(String pZrnkzkmrtihihknsyanmx4) {
        zrnkzkmrtihihknsyanmx4 = pZrnkzkmrtihihknsyanmx4;
    }

    private String zrnkzkmrtihihknsyseiymdx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSEIYMDX4)
    public String getZrnkzkmrtihihknsyseiymdx4() {
        return zrnkzkmrtihihknsyseiymdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkzkmrtihihknsyseiymdx4(String pZrnkzkmrtihihknsyseiymdx4) {
        zrnkzkmrtihihknsyseiymdx4 = pZrnkzkmrtihihknsyseiymdx4;
    }

    private String zrnkzkmrtihihknsysibtkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSIBTKBNX4)
    public String getZrnkzkmrtihihknsysibtkbnx4() {
        return zrnkzkmrtihihknsysibtkbnx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtihihknsysibtkbnx4(String pZrnkzkmrtihihknsysibtkbnx4) {
        zrnkzkmrtihihknsysibtkbnx4 = pZrnkzkmrtihihknsysibtkbnx4;
    }

    private String zrnkazokumrtihihknsyaagex4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIHIHKNSYAAGEX4)
    public String getZrnkazokumrtihihknsyaagex4() {
        return zrnkazokumrtihihknsyaagex4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtihihknsyaagex4(String pZrnkazokumrtihihknsyaagex4) {
        zrnkazokumrtihihknsyaagex4 = pZrnkazokumrtihihknsyaagex4;
    }

    private Long zrnkzkmrtimodsx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIMODSX4)
    public Long getZrnkzkmrtimodsx4() {
        return zrnkzkmrtimodsx4;
    }

    public void setZrnkzkmrtimodsx4(Long pZrnkzkmrtimodsx4) {
        zrnkzkmrtimodsx4 = pZrnkzkmrtimodsx4;
    }

    private String zrnkazokumrtimodsskgnhyjx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIMODSSKGNHYJX4)
    public String getZrnkazokumrtimodsskgnhyjx4() {
        return zrnkazokumrtimodsskgnhyjx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtimodsskgnhyjx4(String pZrnkazokumrtimodsskgnhyjx4) {
        zrnkazokumrtimodsskgnhyjx4 = pZrnkazokumrtimodsskgnhyjx4;
    }

    private String zrnkzkmrtitnknyugukbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITNKNYUGUKBNX4)
    public String getZrnkzkmrtitnknyugukbnx4() {
        return zrnkzkmrtitnknyugukbnx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitnknyugukbnx4(String pZrnkzkmrtitnknyugukbnx4) {
        zrnkzkmrtitnknyugukbnx4 = pZrnkzkmrtitnknyugukbnx4;
    }

    private String zrnkazokumrtikgusdkbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIKGUSDKBNX4)
    public String getZrnkazokumrtikgusdkbnx4() {
        return zrnkazokumrtikgusdkbnx4;
    }

    public void setZrnkazokumrtikgusdkbnx4(String pZrnkazokumrtikgusdkbnx4) {
        zrnkazokumrtikgusdkbnx4 = pZrnkazokumrtikgusdkbnx4;
    }

    private String zrnkazokumrtiagetyusihyjx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIAGETYUSIHYJX4)
    public String getZrnkazokumrtiagetyusihyjx4() {
        return zrnkazokumrtiagetyusihyjx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtiagetyusihyjx4(String pZrnkazokumrtiagetyusihyjx4) {
        zrnkazokumrtiagetyusihyjx4 = pZrnkazokumrtiagetyusihyjx4;
    }

    private String zrnkzkmrtikusnmnryoagex4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIKUSNMNRYOAGEX4)
    public String getZrnkzkmrtikusnmnryoagex4() {
        return zrnkzkmrtikusnmnryoagex4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtikusnmnryoagex4(String pZrnkzkmrtikusnmnryoagex4) {
        zrnkzkmrtikusnmnryoagex4 = pZrnkzkmrtikusnmnryoagex4;
    }

    private String zrnyobiv4x4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X4)
    public String getZrnyobiv4x4() {
        return zrnyobiv4x4;
    }

    public void setZrnyobiv4x4(String pZrnyobiv4x4) {
        zrnyobiv4x4 = pZrnyobiv4x4;
    }

    private String zrnkzkmrtitkyknox5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITKYKNOX5)
    public String getZrnkzkmrtitkyknox5() {
        return zrnkzkmrtitkyknox5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitkyknox5(String pZrnkzkmrtitkyknox5) {
        zrnkzkmrtitkyknox5 = pZrnkzkmrtitkyknox5;
    }

    private String zrnkazokumrtisyuruikgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTISYURUIKGUX5)
    public String getZrnkazokumrtisyuruikgux5() {
        return zrnkazokumrtisyuruikgux5;
    }

    public void setZrnkazokumrtisyuruikgux5(String pZrnkazokumrtisyuruikgux5) {
        zrnkazokumrtisyuruikgux5 = pZrnkazokumrtisyuruikgux5;
    }

    private String zrnkazokumaruteikikanx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIKIKANX5)
    public String getZrnkazokumaruteikikanx5() {
        return zrnkazokumaruteikikanx5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumaruteikikanx5(String pZrnkazokumaruteikikanx5) {
        zrnkazokumaruteikikanx5 = pZrnkazokumaruteikikanx5;
    }

    private String zrnkazokumrtiphrkkknx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIPHRKKKNX5)
    public String getZrnkazokumrtiphrkkknx5() {
        return zrnkazokumrtiphrkkknx5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtiphrkkknx5(String pZrnkazokumrtiphrkkknx5) {
        zrnkazokumrtiphrkkknx5 = pZrnkazokumrtiphrkkknx5;
    }

    private Long zrnkazokumaruteisx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEISX5)
    public Long getZrnkazokumaruteisx5() {
        return zrnkazokumaruteisx5;
    }

    public void setZrnkazokumaruteisx5(Long pZrnkazokumaruteisx5) {
        zrnkazokumaruteisx5 = pZrnkazokumaruteisx5;
    }

    private Long zrnkazokumaruteipx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIPX5)
    public Long getZrnkazokumaruteipx5() {
        return zrnkazokumaruteipx5;
    }

    public void setZrnkazokumaruteipx5(Long pZrnkazokumaruteipx5) {
        zrnkazokumaruteipx5 = pZrnkazokumaruteipx5;
    }

    private String zrnkzkmrtihihknsyanmx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYANMX5)
    public String getZrnkzkmrtihihknsyanmx5() {
        return zrnkzkmrtihihknsyanmx5;
    }

    public void setZrnkzkmrtihihknsyanmx5(String pZrnkzkmrtihihknsyanmx5) {
        zrnkzkmrtihihknsyanmx5 = pZrnkzkmrtihihknsyanmx5;
    }

    private String zrnkzkmrtihihknsyseiymdx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSEIYMDX5)
    public String getZrnkzkmrtihihknsyseiymdx5() {
        return zrnkzkmrtihihknsyseiymdx5;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkzkmrtihihknsyseiymdx5(String pZrnkzkmrtihihknsyseiymdx5) {
        zrnkzkmrtihihknsyseiymdx5 = pZrnkzkmrtihihknsyseiymdx5;
    }

    private String zrnkzkmrtihihknsysibtkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSIBTKBNX5)
    public String getZrnkzkmrtihihknsysibtkbnx5() {
        return zrnkzkmrtihihknsysibtkbnx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtihihknsysibtkbnx5(String pZrnkzkmrtihihknsysibtkbnx5) {
        zrnkzkmrtihihknsysibtkbnx5 = pZrnkzkmrtihihknsysibtkbnx5;
    }

    private String zrnkazokumrtihihknsyaagex5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIHIHKNSYAAGEX5)
    public String getZrnkazokumrtihihknsyaagex5() {
        return zrnkazokumrtihihknsyaagex5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtihihknsyaagex5(String pZrnkazokumrtihihknsyaagex5) {
        zrnkazokumrtihihknsyaagex5 = pZrnkazokumrtihihknsyaagex5;
    }

    private Long zrnkzkmrtimodsx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIMODSX5)
    public Long getZrnkzkmrtimodsx5() {
        return zrnkzkmrtimodsx5;
    }

    public void setZrnkzkmrtimodsx5(Long pZrnkzkmrtimodsx5) {
        zrnkzkmrtimodsx5 = pZrnkzkmrtimodsx5;
    }

    private String zrnkazokumrtimodsskgnhyjx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIMODSSKGNHYJX5)
    public String getZrnkazokumrtimodsskgnhyjx5() {
        return zrnkazokumrtimodsskgnhyjx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtimodsskgnhyjx5(String pZrnkazokumrtimodsskgnhyjx5) {
        zrnkazokumrtimodsskgnhyjx5 = pZrnkazokumrtimodsskgnhyjx5;
    }

    private String zrnkzkmrtitnknyugukbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITNKNYUGUKBNX5)
    public String getZrnkzkmrtitnknyugukbnx5() {
        return zrnkzkmrtitnknyugukbnx5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitnknyugukbnx5(String pZrnkzkmrtitnknyugukbnx5) {
        zrnkzkmrtitnknyugukbnx5 = pZrnkzkmrtitnknyugukbnx5;
    }

    private String zrnkazokumrtikgusdkbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIKGUSDKBNX5)
    public String getZrnkazokumrtikgusdkbnx5() {
        return zrnkazokumrtikgusdkbnx5;
    }

    public void setZrnkazokumrtikgusdkbnx5(String pZrnkazokumrtikgusdkbnx5) {
        zrnkazokumrtikgusdkbnx5 = pZrnkazokumrtikgusdkbnx5;
    }

    private String zrnkazokumrtiagetyusihyjx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIAGETYUSIHYJX5)
    public String getZrnkazokumrtiagetyusihyjx5() {
        return zrnkazokumrtiagetyusihyjx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtiagetyusihyjx5(String pZrnkazokumrtiagetyusihyjx5) {
        zrnkazokumrtiagetyusihyjx5 = pZrnkazokumrtiagetyusihyjx5;
    }

    private String zrnkzkmrtikusnmnryoagex5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIKUSNMNRYOAGEX5)
    public String getZrnkzkmrtikusnmnryoagex5() {
        return zrnkzkmrtikusnmnryoagex5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtikusnmnryoagex5(String pZrnkzkmrtikusnmnryoagex5) {
        zrnkzkmrtikusnmnryoagex5 = pZrnkzkmrtikusnmnryoagex5;
    }

    private String zrnyobiv4x5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X5)
    public String getZrnyobiv4x5() {
        return zrnyobiv4x5;
    }

    public void setZrnyobiv4x5(String pZrnyobiv4x5) {
        zrnyobiv4x5 = pZrnyobiv4x5;
    }

    private String zrnkzkmrtitkyknox6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITKYKNOX6)
    public String getZrnkzkmrtitkyknox6() {
        return zrnkzkmrtitkyknox6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitkyknox6(String pZrnkzkmrtitkyknox6) {
        zrnkzkmrtitkyknox6 = pZrnkzkmrtitkyknox6;
    }

    private String zrnkazokumrtisyuruikgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTISYURUIKGUX6)
    public String getZrnkazokumrtisyuruikgux6() {
        return zrnkazokumrtisyuruikgux6;
    }

    public void setZrnkazokumrtisyuruikgux6(String pZrnkazokumrtisyuruikgux6) {
        zrnkazokumrtisyuruikgux6 = pZrnkazokumrtisyuruikgux6;
    }

    private String zrnkazokumaruteikikanx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIKIKANX6)
    public String getZrnkazokumaruteikikanx6() {
        return zrnkazokumaruteikikanx6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumaruteikikanx6(String pZrnkazokumaruteikikanx6) {
        zrnkazokumaruteikikanx6 = pZrnkazokumaruteikikanx6;
    }

    private String zrnkazokumrtiphrkkknx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIPHRKKKNX6)
    public String getZrnkazokumrtiphrkkknx6() {
        return zrnkazokumrtiphrkkknx6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtiphrkkknx6(String pZrnkazokumrtiphrkkknx6) {
        zrnkazokumrtiphrkkknx6 = pZrnkazokumrtiphrkkknx6;
    }

    private Long zrnkazokumaruteisx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEISX6)
    public Long getZrnkazokumaruteisx6() {
        return zrnkazokumaruteisx6;
    }

    public void setZrnkazokumaruteisx6(Long pZrnkazokumaruteisx6) {
        zrnkazokumaruteisx6 = pZrnkazokumaruteisx6;
    }

    private Long zrnkazokumaruteipx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIPX6)
    public Long getZrnkazokumaruteipx6() {
        return zrnkazokumaruteipx6;
    }

    public void setZrnkazokumaruteipx6(Long pZrnkazokumaruteipx6) {
        zrnkazokumaruteipx6 = pZrnkazokumaruteipx6;
    }

    private String zrnkzkmrtihihknsyanmx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYANMX6)
    public String getZrnkzkmrtihihknsyanmx6() {
        return zrnkzkmrtihihknsyanmx6;
    }

    public void setZrnkzkmrtihihknsyanmx6(String pZrnkzkmrtihihknsyanmx6) {
        zrnkzkmrtihihknsyanmx6 = pZrnkzkmrtihihknsyanmx6;
    }

    private String zrnkzkmrtihihknsyseiymdx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSEIYMDX6)
    public String getZrnkzkmrtihihknsyseiymdx6() {
        return zrnkzkmrtihihknsyseiymdx6;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkzkmrtihihknsyseiymdx6(String pZrnkzkmrtihihknsyseiymdx6) {
        zrnkzkmrtihihknsyseiymdx6 = pZrnkzkmrtihihknsyseiymdx6;
    }

    private String zrnkzkmrtihihknsysibtkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSIBTKBNX6)
    public String getZrnkzkmrtihihknsysibtkbnx6() {
        return zrnkzkmrtihihknsysibtkbnx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtihihknsysibtkbnx6(String pZrnkzkmrtihihknsysibtkbnx6) {
        zrnkzkmrtihihknsysibtkbnx6 = pZrnkzkmrtihihknsysibtkbnx6;
    }

    private String zrnkazokumrtihihknsyaagex6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIHIHKNSYAAGEX6)
    public String getZrnkazokumrtihihknsyaagex6() {
        return zrnkazokumrtihihknsyaagex6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtihihknsyaagex6(String pZrnkazokumrtihihknsyaagex6) {
        zrnkazokumrtihihknsyaagex6 = pZrnkazokumrtihihknsyaagex6;
    }

    private Long zrnkzkmrtimodsx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIMODSX6)
    public Long getZrnkzkmrtimodsx6() {
        return zrnkzkmrtimodsx6;
    }

    public void setZrnkzkmrtimodsx6(Long pZrnkzkmrtimodsx6) {
        zrnkzkmrtimodsx6 = pZrnkzkmrtimodsx6;
    }

    private String zrnkazokumrtimodsskgnhyjx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIMODSSKGNHYJX6)
    public String getZrnkazokumrtimodsskgnhyjx6() {
        return zrnkazokumrtimodsskgnhyjx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtimodsskgnhyjx6(String pZrnkazokumrtimodsskgnhyjx6) {
        zrnkazokumrtimodsskgnhyjx6 = pZrnkazokumrtimodsskgnhyjx6;
    }

    private String zrnkzkmrtitnknyugukbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITNKNYUGUKBNX6)
    public String getZrnkzkmrtitnknyugukbnx6() {
        return zrnkzkmrtitnknyugukbnx6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitnknyugukbnx6(String pZrnkzkmrtitnknyugukbnx6) {
        zrnkzkmrtitnknyugukbnx6 = pZrnkzkmrtitnknyugukbnx6;
    }

    private String zrnkazokumrtikgusdkbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIKGUSDKBNX6)
    public String getZrnkazokumrtikgusdkbnx6() {
        return zrnkazokumrtikgusdkbnx6;
    }

    public void setZrnkazokumrtikgusdkbnx6(String pZrnkazokumrtikgusdkbnx6) {
        zrnkazokumrtikgusdkbnx6 = pZrnkazokumrtikgusdkbnx6;
    }

    private String zrnkazokumrtiagetyusihyjx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIAGETYUSIHYJX6)
    public String getZrnkazokumrtiagetyusihyjx6() {
        return zrnkazokumrtiagetyusihyjx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtiagetyusihyjx6(String pZrnkazokumrtiagetyusihyjx6) {
        zrnkazokumrtiagetyusihyjx6 = pZrnkazokumrtiagetyusihyjx6;
    }

    private String zrnkzkmrtikusnmnryoagex6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIKUSNMNRYOAGEX6)
    public String getZrnkzkmrtikusnmnryoagex6() {
        return zrnkzkmrtikusnmnryoagex6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtikusnmnryoagex6(String pZrnkzkmrtikusnmnryoagex6) {
        zrnkzkmrtikusnmnryoagex6 = pZrnkzkmrtikusnmnryoagex6;
    }

    private String zrnyobiv4x6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X6)
    public String getZrnyobiv4x6() {
        return zrnyobiv4x6;
    }

    public void setZrnyobiv4x6(String pZrnyobiv4x6) {
        zrnyobiv4x6 = pZrnyobiv4x6;
    }

    private String zrnkzkmrtitkyknox7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITKYKNOX7)
    public String getZrnkzkmrtitkyknox7() {
        return zrnkzkmrtitkyknox7;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitkyknox7(String pZrnkzkmrtitkyknox7) {
        zrnkzkmrtitkyknox7 = pZrnkzkmrtitkyknox7;
    }

    private String zrnkazokumrtisyuruikgux7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTISYURUIKGUX7)
    public String getZrnkazokumrtisyuruikgux7() {
        return zrnkazokumrtisyuruikgux7;
    }

    public void setZrnkazokumrtisyuruikgux7(String pZrnkazokumrtisyuruikgux7) {
        zrnkazokumrtisyuruikgux7 = pZrnkazokumrtisyuruikgux7;
    }

    private String zrnkazokumaruteikikanx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIKIKANX7)
    public String getZrnkazokumaruteikikanx7() {
        return zrnkazokumaruteikikanx7;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumaruteikikanx7(String pZrnkazokumaruteikikanx7) {
        zrnkazokumaruteikikanx7 = pZrnkazokumaruteikikanx7;
    }

    private String zrnkazokumrtiphrkkknx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIPHRKKKNX7)
    public String getZrnkazokumrtiphrkkknx7() {
        return zrnkazokumrtiphrkkknx7;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtiphrkkknx7(String pZrnkazokumrtiphrkkknx7) {
        zrnkazokumrtiphrkkknx7 = pZrnkazokumrtiphrkkknx7;
    }

    private Long zrnkazokumaruteisx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEISX7)
    public Long getZrnkazokumaruteisx7() {
        return zrnkazokumaruteisx7;
    }

    public void setZrnkazokumaruteisx7(Long pZrnkazokumaruteisx7) {
        zrnkazokumaruteisx7 = pZrnkazokumaruteisx7;
    }

    private Long zrnkazokumaruteipx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIPX7)
    public Long getZrnkazokumaruteipx7() {
        return zrnkazokumaruteipx7;
    }

    public void setZrnkazokumaruteipx7(Long pZrnkazokumaruteipx7) {
        zrnkazokumaruteipx7 = pZrnkazokumaruteipx7;
    }

    private String zrnkzkmrtihihknsyanmx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYANMX7)
    public String getZrnkzkmrtihihknsyanmx7() {
        return zrnkzkmrtihihknsyanmx7;
    }

    public void setZrnkzkmrtihihknsyanmx7(String pZrnkzkmrtihihknsyanmx7) {
        zrnkzkmrtihihknsyanmx7 = pZrnkzkmrtihihknsyanmx7;
    }

    private String zrnkzkmrtihihknsyseiymdx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSEIYMDX7)
    public String getZrnkzkmrtihihknsyseiymdx7() {
        return zrnkzkmrtihihknsyseiymdx7;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkzkmrtihihknsyseiymdx7(String pZrnkzkmrtihihknsyseiymdx7) {
        zrnkzkmrtihihknsyseiymdx7 = pZrnkzkmrtihihknsyseiymdx7;
    }

    private String zrnkzkmrtihihknsysibtkbnx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSIBTKBNX7)
    public String getZrnkzkmrtihihknsysibtkbnx7() {
        return zrnkzkmrtihihknsysibtkbnx7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtihihknsysibtkbnx7(String pZrnkzkmrtihihknsysibtkbnx7) {
        zrnkzkmrtihihknsysibtkbnx7 = pZrnkzkmrtihihknsysibtkbnx7;
    }

    private String zrnkazokumrtihihknsyaagex7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIHIHKNSYAAGEX7)
    public String getZrnkazokumrtihihknsyaagex7() {
        return zrnkazokumrtihihknsyaagex7;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtihihknsyaagex7(String pZrnkazokumrtihihknsyaagex7) {
        zrnkazokumrtihihknsyaagex7 = pZrnkazokumrtihihknsyaagex7;
    }

    private Long zrnkzkmrtimodsx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIMODSX7)
    public Long getZrnkzkmrtimodsx7() {
        return zrnkzkmrtimodsx7;
    }

    public void setZrnkzkmrtimodsx7(Long pZrnkzkmrtimodsx7) {
        zrnkzkmrtimodsx7 = pZrnkzkmrtimodsx7;
    }

    private String zrnkazokumrtimodsskgnhyjx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIMODSSKGNHYJX7)
    public String getZrnkazokumrtimodsskgnhyjx7() {
        return zrnkazokumrtimodsskgnhyjx7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtimodsskgnhyjx7(String pZrnkazokumrtimodsskgnhyjx7) {
        zrnkazokumrtimodsskgnhyjx7 = pZrnkazokumrtimodsskgnhyjx7;
    }

    private String zrnkzkmrtitnknyugukbnx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITNKNYUGUKBNX7)
    public String getZrnkzkmrtitnknyugukbnx7() {
        return zrnkzkmrtitnknyugukbnx7;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitnknyugukbnx7(String pZrnkzkmrtitnknyugukbnx7) {
        zrnkzkmrtitnknyugukbnx7 = pZrnkzkmrtitnknyugukbnx7;
    }

    private String zrnkazokumrtikgusdkbnx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIKGUSDKBNX7)
    public String getZrnkazokumrtikgusdkbnx7() {
        return zrnkazokumrtikgusdkbnx7;
    }

    public void setZrnkazokumrtikgusdkbnx7(String pZrnkazokumrtikgusdkbnx7) {
        zrnkazokumrtikgusdkbnx7 = pZrnkazokumrtikgusdkbnx7;
    }

    private String zrnkazokumrtiagetyusihyjx7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIAGETYUSIHYJX7)
    public String getZrnkazokumrtiagetyusihyjx7() {
        return zrnkazokumrtiagetyusihyjx7;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtiagetyusihyjx7(String pZrnkazokumrtiagetyusihyjx7) {
        zrnkazokumrtiagetyusihyjx7 = pZrnkazokumrtiagetyusihyjx7;
    }

    private String zrnkzkmrtikusnmnryoagex7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIKUSNMNRYOAGEX7)
    public String getZrnkzkmrtikusnmnryoagex7() {
        return zrnkzkmrtikusnmnryoagex7;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtikusnmnryoagex7(String pZrnkzkmrtikusnmnryoagex7) {
        zrnkzkmrtikusnmnryoagex7 = pZrnkzkmrtikusnmnryoagex7;
    }

    private String zrnyobiv4x7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X7)
    public String getZrnyobiv4x7() {
        return zrnyobiv4x7;
    }

    public void setZrnyobiv4x7(String pZrnyobiv4x7) {
        zrnyobiv4x7 = pZrnyobiv4x7;
    }

    private String zrnkzkmrtitkyknox8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITKYKNOX8)
    public String getZrnkzkmrtitkyknox8() {
        return zrnkzkmrtitkyknox8;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitkyknox8(String pZrnkzkmrtitkyknox8) {
        zrnkzkmrtitkyknox8 = pZrnkzkmrtitkyknox8;
    }

    private String zrnkazokumrtisyuruikgux8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTISYURUIKGUX8)
    public String getZrnkazokumrtisyuruikgux8() {
        return zrnkazokumrtisyuruikgux8;
    }

    public void setZrnkazokumrtisyuruikgux8(String pZrnkazokumrtisyuruikgux8) {
        zrnkazokumrtisyuruikgux8 = pZrnkazokumrtisyuruikgux8;
    }

    private String zrnkazokumaruteikikanx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIKIKANX8)
    public String getZrnkazokumaruteikikanx8() {
        return zrnkazokumaruteikikanx8;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumaruteikikanx8(String pZrnkazokumaruteikikanx8) {
        zrnkazokumaruteikikanx8 = pZrnkazokumaruteikikanx8;
    }

    private String zrnkazokumrtiphrkkknx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIPHRKKKNX8)
    public String getZrnkazokumrtiphrkkknx8() {
        return zrnkazokumrtiphrkkknx8;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtiphrkkknx8(String pZrnkazokumrtiphrkkknx8) {
        zrnkazokumrtiphrkkknx8 = pZrnkazokumrtiphrkkknx8;
    }

    private Long zrnkazokumaruteisx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEISX8)
    public Long getZrnkazokumaruteisx8() {
        return zrnkazokumaruteisx8;
    }

    public void setZrnkazokumaruteisx8(Long pZrnkazokumaruteisx8) {
        zrnkazokumaruteisx8 = pZrnkazokumaruteisx8;
    }

    private Long zrnkazokumaruteipx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIPX8)
    public Long getZrnkazokumaruteipx8() {
        return zrnkazokumaruteipx8;
    }

    public void setZrnkazokumaruteipx8(Long pZrnkazokumaruteipx8) {
        zrnkazokumaruteipx8 = pZrnkazokumaruteipx8;
    }

    private String zrnkzkmrtihihknsyanmx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYANMX8)
    public String getZrnkzkmrtihihknsyanmx8() {
        return zrnkzkmrtihihknsyanmx8;
    }

    public void setZrnkzkmrtihihknsyanmx8(String pZrnkzkmrtihihknsyanmx8) {
        zrnkzkmrtihihknsyanmx8 = pZrnkzkmrtihihknsyanmx8;
    }

    private String zrnkzkmrtihihknsyseiymdx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSEIYMDX8)
    public String getZrnkzkmrtihihknsyseiymdx8() {
        return zrnkzkmrtihihknsyseiymdx8;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkzkmrtihihknsyseiymdx8(String pZrnkzkmrtihihknsyseiymdx8) {
        zrnkzkmrtihihknsyseiymdx8 = pZrnkzkmrtihihknsyseiymdx8;
    }

    private String zrnkzkmrtihihknsysibtkbnx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSIBTKBNX8)
    public String getZrnkzkmrtihihknsysibtkbnx8() {
        return zrnkzkmrtihihknsysibtkbnx8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtihihknsysibtkbnx8(String pZrnkzkmrtihihknsysibtkbnx8) {
        zrnkzkmrtihihknsysibtkbnx8 = pZrnkzkmrtihihknsysibtkbnx8;
    }

    private String zrnkazokumrtihihknsyaagex8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIHIHKNSYAAGEX8)
    public String getZrnkazokumrtihihknsyaagex8() {
        return zrnkazokumrtihihknsyaagex8;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtihihknsyaagex8(String pZrnkazokumrtihihknsyaagex8) {
        zrnkazokumrtihihknsyaagex8 = pZrnkazokumrtihihknsyaagex8;
    }

    private Long zrnkzkmrtimodsx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIMODSX8)
    public Long getZrnkzkmrtimodsx8() {
        return zrnkzkmrtimodsx8;
    }

    public void setZrnkzkmrtimodsx8(Long pZrnkzkmrtimodsx8) {
        zrnkzkmrtimodsx8 = pZrnkzkmrtimodsx8;
    }

    private String zrnkazokumrtimodsskgnhyjx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIMODSSKGNHYJX8)
    public String getZrnkazokumrtimodsskgnhyjx8() {
        return zrnkazokumrtimodsskgnhyjx8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtimodsskgnhyjx8(String pZrnkazokumrtimodsskgnhyjx8) {
        zrnkazokumrtimodsskgnhyjx8 = pZrnkazokumrtimodsskgnhyjx8;
    }

    private String zrnkzkmrtitnknyugukbnx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITNKNYUGUKBNX8)
    public String getZrnkzkmrtitnknyugukbnx8() {
        return zrnkzkmrtitnknyugukbnx8;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitnknyugukbnx8(String pZrnkzkmrtitnknyugukbnx8) {
        zrnkzkmrtitnknyugukbnx8 = pZrnkzkmrtitnknyugukbnx8;
    }

    private String zrnkazokumrtikgusdkbnx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIKGUSDKBNX8)
    public String getZrnkazokumrtikgusdkbnx8() {
        return zrnkazokumrtikgusdkbnx8;
    }

    public void setZrnkazokumrtikgusdkbnx8(String pZrnkazokumrtikgusdkbnx8) {
        zrnkazokumrtikgusdkbnx8 = pZrnkazokumrtikgusdkbnx8;
    }

    private String zrnkazokumrtiagetyusihyjx8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIAGETYUSIHYJX8)
    public String getZrnkazokumrtiagetyusihyjx8() {
        return zrnkazokumrtiagetyusihyjx8;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtiagetyusihyjx8(String pZrnkazokumrtiagetyusihyjx8) {
        zrnkazokumrtiagetyusihyjx8 = pZrnkazokumrtiagetyusihyjx8;
    }

    private String zrnkzkmrtikusnmnryoagex8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIKUSNMNRYOAGEX8)
    public String getZrnkzkmrtikusnmnryoagex8() {
        return zrnkzkmrtikusnmnryoagex8;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtikusnmnryoagex8(String pZrnkzkmrtikusnmnryoagex8) {
        zrnkzkmrtikusnmnryoagex8 = pZrnkzkmrtikusnmnryoagex8;
    }

    private String zrnyobiv4x8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X8)
    public String getZrnyobiv4x8() {
        return zrnyobiv4x8;
    }

    public void setZrnyobiv4x8(String pZrnyobiv4x8) {
        zrnyobiv4x8 = pZrnyobiv4x8;
    }

    private String zrnkzkmrtitkyknox9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITKYKNOX9)
    public String getZrnkzkmrtitkyknox9() {
        return zrnkzkmrtitkyknox9;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitkyknox9(String pZrnkzkmrtitkyknox9) {
        zrnkzkmrtitkyknox9 = pZrnkzkmrtitkyknox9;
    }

    private String zrnkazokumrtisyuruikgux9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTISYURUIKGUX9)
    public String getZrnkazokumrtisyuruikgux9() {
        return zrnkazokumrtisyuruikgux9;
    }

    public void setZrnkazokumrtisyuruikgux9(String pZrnkazokumrtisyuruikgux9) {
        zrnkazokumrtisyuruikgux9 = pZrnkazokumrtisyuruikgux9;
    }

    private String zrnkazokumaruteikikanx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIKIKANX9)
    public String getZrnkazokumaruteikikanx9() {
        return zrnkazokumaruteikikanx9;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumaruteikikanx9(String pZrnkazokumaruteikikanx9) {
        zrnkazokumaruteikikanx9 = pZrnkazokumaruteikikanx9;
    }

    private String zrnkazokumrtiphrkkknx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIPHRKKKNX9)
    public String getZrnkazokumrtiphrkkknx9() {
        return zrnkazokumrtiphrkkknx9;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtiphrkkknx9(String pZrnkazokumrtiphrkkknx9) {
        zrnkazokumrtiphrkkknx9 = pZrnkazokumrtiphrkkknx9;
    }

    private Long zrnkazokumaruteisx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEISX9)
    public Long getZrnkazokumaruteisx9() {
        return zrnkazokumaruteisx9;
    }

    public void setZrnkazokumaruteisx9(Long pZrnkazokumaruteisx9) {
        zrnkazokumaruteisx9 = pZrnkazokumaruteisx9;
    }

    private Long zrnkazokumaruteipx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIPX9)
    public Long getZrnkazokumaruteipx9() {
        return zrnkazokumaruteipx9;
    }

    public void setZrnkazokumaruteipx9(Long pZrnkazokumaruteipx9) {
        zrnkazokumaruteipx9 = pZrnkazokumaruteipx9;
    }

    private String zrnkzkmrtihihknsyanmx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYANMX9)
    public String getZrnkzkmrtihihknsyanmx9() {
        return zrnkzkmrtihihknsyanmx9;
    }

    public void setZrnkzkmrtihihknsyanmx9(String pZrnkzkmrtihihknsyanmx9) {
        zrnkzkmrtihihknsyanmx9 = pZrnkzkmrtihihknsyanmx9;
    }

    private String zrnkzkmrtihihknsyseiymdx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSEIYMDX9)
    public String getZrnkzkmrtihihknsyseiymdx9() {
        return zrnkzkmrtihihknsyseiymdx9;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkzkmrtihihknsyseiymdx9(String pZrnkzkmrtihihknsyseiymdx9) {
        zrnkzkmrtihihknsyseiymdx9 = pZrnkzkmrtihihknsyseiymdx9;
    }

    private String zrnkzkmrtihihknsysibtkbnx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSIBTKBNX9)
    public String getZrnkzkmrtihihknsysibtkbnx9() {
        return zrnkzkmrtihihknsysibtkbnx9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtihihknsysibtkbnx9(String pZrnkzkmrtihihknsysibtkbnx9) {
        zrnkzkmrtihihknsysibtkbnx9 = pZrnkzkmrtihihknsysibtkbnx9;
    }

    private String zrnkazokumrtihihknsyaagex9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIHIHKNSYAAGEX9)
    public String getZrnkazokumrtihihknsyaagex9() {
        return zrnkazokumrtihihknsyaagex9;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtihihknsyaagex9(String pZrnkazokumrtihihknsyaagex9) {
        zrnkazokumrtihihknsyaagex9 = pZrnkazokumrtihihknsyaagex9;
    }

    private Long zrnkzkmrtimodsx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIMODSX9)
    public Long getZrnkzkmrtimodsx9() {
        return zrnkzkmrtimodsx9;
    }

    public void setZrnkzkmrtimodsx9(Long pZrnkzkmrtimodsx9) {
        zrnkzkmrtimodsx9 = pZrnkzkmrtimodsx9;
    }

    private String zrnkazokumrtimodsskgnhyjx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIMODSSKGNHYJX9)
    public String getZrnkazokumrtimodsskgnhyjx9() {
        return zrnkazokumrtimodsskgnhyjx9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtimodsskgnhyjx9(String pZrnkazokumrtimodsskgnhyjx9) {
        zrnkazokumrtimodsskgnhyjx9 = pZrnkazokumrtimodsskgnhyjx9;
    }

    private String zrnkzkmrtitnknyugukbnx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITNKNYUGUKBNX9)
    public String getZrnkzkmrtitnknyugukbnx9() {
        return zrnkzkmrtitnknyugukbnx9;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitnknyugukbnx9(String pZrnkzkmrtitnknyugukbnx9) {
        zrnkzkmrtitnknyugukbnx9 = pZrnkzkmrtitnknyugukbnx9;
    }

    private String zrnkazokumrtikgusdkbnx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIKGUSDKBNX9)
    public String getZrnkazokumrtikgusdkbnx9() {
        return zrnkazokumrtikgusdkbnx9;
    }

    public void setZrnkazokumrtikgusdkbnx9(String pZrnkazokumrtikgusdkbnx9) {
        zrnkazokumrtikgusdkbnx9 = pZrnkazokumrtikgusdkbnx9;
    }

    private String zrnkazokumrtiagetyusihyjx9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIAGETYUSIHYJX9)
    public String getZrnkazokumrtiagetyusihyjx9() {
        return zrnkazokumrtiagetyusihyjx9;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtiagetyusihyjx9(String pZrnkazokumrtiagetyusihyjx9) {
        zrnkazokumrtiagetyusihyjx9 = pZrnkazokumrtiagetyusihyjx9;
    }

    private String zrnkzkmrtikusnmnryoagex9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIKUSNMNRYOAGEX9)
    public String getZrnkzkmrtikusnmnryoagex9() {
        return zrnkzkmrtikusnmnryoagex9;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtikusnmnryoagex9(String pZrnkzkmrtikusnmnryoagex9) {
        zrnkzkmrtikusnmnryoagex9 = pZrnkzkmrtikusnmnryoagex9;
    }

    private String zrnyobiv4x9;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X9)
    public String getZrnyobiv4x9() {
        return zrnyobiv4x9;
    }

    public void setZrnyobiv4x9(String pZrnyobiv4x9) {
        zrnyobiv4x9 = pZrnyobiv4x9;
    }

    private String zrnkzkmrtitkyknox10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITKYKNOX10)
    public String getZrnkzkmrtitkyknox10() {
        return zrnkzkmrtitkyknox10;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitkyknox10(String pZrnkzkmrtitkyknox10) {
        zrnkzkmrtitkyknox10 = pZrnkzkmrtitkyknox10;
    }

    private String zrnkazokumrtisyuruikgux10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTISYURUIKGUX10)
    public String getZrnkazokumrtisyuruikgux10() {
        return zrnkazokumrtisyuruikgux10;
    }

    public void setZrnkazokumrtisyuruikgux10(String pZrnkazokumrtisyuruikgux10) {
        zrnkazokumrtisyuruikgux10 = pZrnkazokumrtisyuruikgux10;
    }

    private String zrnkazokumaruteikikanx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIKIKANX10)
    public String getZrnkazokumaruteikikanx10() {
        return zrnkazokumaruteikikanx10;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumaruteikikanx10(String pZrnkazokumaruteikikanx10) {
        zrnkazokumaruteikikanx10 = pZrnkazokumaruteikikanx10;
    }

    private String zrnkazokumrtiphrkkknx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIPHRKKKNX10)
    public String getZrnkazokumrtiphrkkknx10() {
        return zrnkazokumrtiphrkkknx10;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtiphrkkknx10(String pZrnkazokumrtiphrkkknx10) {
        zrnkazokumrtiphrkkknx10 = pZrnkazokumrtiphrkkknx10;
    }

    private Long zrnkazokumaruteisx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEISX10)
    public Long getZrnkazokumaruteisx10() {
        return zrnkazokumaruteisx10;
    }

    public void setZrnkazokumaruteisx10(Long pZrnkazokumaruteisx10) {
        zrnkazokumaruteisx10 = pZrnkazokumaruteisx10;
    }

    private Long zrnkazokumaruteipx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMARUTEIPX10)
    public Long getZrnkazokumaruteipx10() {
        return zrnkazokumaruteipx10;
    }

    public void setZrnkazokumaruteipx10(Long pZrnkazokumaruteipx10) {
        zrnkazokumaruteipx10 = pZrnkazokumaruteipx10;
    }

    private String zrnkzkmrtihihknsyanmx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYANMX10)
    public String getZrnkzkmrtihihknsyanmx10() {
        return zrnkzkmrtihihknsyanmx10;
    }

    public void setZrnkzkmrtihihknsyanmx10(String pZrnkzkmrtihihknsyanmx10) {
        zrnkzkmrtihihknsyanmx10 = pZrnkzkmrtihihknsyanmx10;
    }

    private String zrnkzkmrtihihknsyseiymdx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSEIYMDX10)
    public String getZrnkzkmrtihihknsyseiymdx10() {
        return zrnkzkmrtihihknsyseiymdx10;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkzkmrtihihknsyseiymdx10(String pZrnkzkmrtihihknsyseiymdx10) {
        zrnkzkmrtihihknsyseiymdx10 = pZrnkzkmrtihihknsyseiymdx10;
    }

    private String zrnkzkmrtihihknsysibtkbnx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIHIHKNSYSIBTKBNX10)
    public String getZrnkzkmrtihihknsysibtkbnx10() {
        return zrnkzkmrtihihknsysibtkbnx10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkzkmrtihihknsysibtkbnx10(String pZrnkzkmrtihihknsysibtkbnx10) {
        zrnkzkmrtihihknsysibtkbnx10 = pZrnkzkmrtihihknsysibtkbnx10;
    }

    private String zrnkazokumrtihihknsyaagex10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIHIHKNSYAAGEX10)
    public String getZrnkazokumrtihihknsyaagex10() {
        return zrnkazokumrtihihknsyaagex10;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkazokumrtihihknsyaagex10(String pZrnkazokumrtihihknsyaagex10) {
        zrnkazokumrtihihknsyaagex10 = pZrnkazokumrtihihknsyaagex10;
    }

    private Long zrnkzkmrtimodsx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIMODSX10)
    public Long getZrnkzkmrtimodsx10() {
        return zrnkzkmrtimodsx10;
    }

    public void setZrnkzkmrtimodsx10(Long pZrnkzkmrtimodsx10) {
        zrnkzkmrtimodsx10 = pZrnkzkmrtimodsx10;
    }

    private String zrnkazokumrtimodsskgnhyjx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIMODSSKGNHYJX10)
    public String getZrnkazokumrtimodsskgnhyjx10() {
        return zrnkazokumrtimodsskgnhyjx10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtimodsskgnhyjx10(String pZrnkazokumrtimodsskgnhyjx10) {
        zrnkazokumrtimodsskgnhyjx10 = pZrnkazokumrtimodsskgnhyjx10;
    }

    private String zrnkzkmrtitnknyugukbnx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTITNKNYUGUKBNX10)
    public String getZrnkzkmrtitnknyugukbnx10() {
        return zrnkzkmrtitnknyugukbnx10;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtitnknyugukbnx10(String pZrnkzkmrtitnknyugukbnx10) {
        zrnkzkmrtitnknyugukbnx10 = pZrnkzkmrtitnknyugukbnx10;
    }

    private String zrnkazokumrtikgusdkbnx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIKGUSDKBNX10)
    public String getZrnkazokumrtikgusdkbnx10() {
        return zrnkazokumrtikgusdkbnx10;
    }

    public void setZrnkazokumrtikgusdkbnx10(String pZrnkazokumrtikgusdkbnx10) {
        zrnkazokumrtikgusdkbnx10 = pZrnkazokumrtikgusdkbnx10;
    }

    private String zrnkazokumrtiagetyusihyjx10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKAZOKUMRTIAGETYUSIHYJX10)
    public String getZrnkazokumrtiagetyusihyjx10() {
        return zrnkazokumrtiagetyusihyjx10;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkazokumrtiagetyusihyjx10(String pZrnkazokumrtiagetyusihyjx10) {
        zrnkazokumrtiagetyusihyjx10 = pZrnkazokumrtiagetyusihyjx10;
    }

    private String zrnkzkmrtikusnmnryoagex10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTIKUSNMNRYOAGEX10)
    public String getZrnkzkmrtikusnmnryoagex10() {
        return zrnkzkmrtikusnmnryoagex10;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkzkmrtikusnmnryoagex10(String pZrnkzkmrtikusnmnryoagex10) {
        zrnkzkmrtikusnmnryoagex10 = pZrnkzkmrtikusnmnryoagex10;
    }

    private String zrnyobiv4x10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X10)
    public String getZrnyobiv4x10() {
        return zrnyobiv4x10;
    }

    public void setZrnyobiv4x10(String pZrnyobiv4x10) {
        zrnyobiv4x10 = pZrnyobiv4x10;
    }

    private String zrnnkshrtkykhuhokbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNKSHRTKYKHUHOKBNX1)
    public String getZrnnkshrtkykhuhokbnx1() {
        return zrnnkshrtkykhuhokbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkshrtkykhuhokbnx1(String pZrnnkshrtkykhuhokbnx1) {
        zrnnkshrtkykhuhokbnx1 = pZrnnkshrtkykhuhokbnx1;
    }

    private String zrnnkshrtkyknksyuruikbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNKSHRTKYKNKSYURUIKBNX1)
    public String getZrnnkshrtkyknksyuruikbnx1() {
        return zrnnkshrtkyknksyuruikbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkshrtkyknksyuruikbnx1(String pZrnnkshrtkyknksyuruikbnx1) {
        zrnnkshrtkyknksyuruikbnx1 = pZrnnkshrtkyknksyuruikbnx1;
    }

    private String zrnnkshrtkyknkkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNKSHRTKYKNKKKNX1)
    public String getZrnnkshrtkyknkkknx1() {
        return zrnnkshrtkyknkkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnkshrtkyknkkknx1(String pZrnnkshrtkyknkkknx1) {
        zrnnkshrtkyknkkknx1 = pZrnnkshrtkyknkkknx1;
    }

    private Long zrnnkshrtkyknknengkx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNKSHRTKYKNKNENGKX1)
    public Long getZrnnkshrtkyknknengkx1() {
        return zrnnkshrtkyknknengkx1;
    }

    public void setZrnnkshrtkyknknengkx1(Long pZrnnkshrtkyknknengkx1) {
        zrnnkshrtkyknknengkx1 = pZrnnkshrtkyknknengkx1;
    }

    private String zrnnkshrtkykduketorihhkbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNKSHRTKYKDUKETORIHHKBNX1)
    public String getZrnnkshrtkykduketorihhkbnx1() {
        return zrnnkshrtkykduketorihhkbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkshrtkykduketorihhkbnx1(String pZrnnkshrtkykduketorihhkbnx1) {
        zrnnkshrtkykduketorihhkbnx1 = pZrnnkshrtkykduketorihhkbnx1;
    }

    private String zrnyobiv10;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV10)
    public String getZrnyobiv10() {
        return zrnyobiv10;
    }

    public void setZrnyobiv10(String pZrnyobiv10) {
        zrnyobiv10 = pZrnyobiv10;
    }

    private String zrnnkshrtkykhuhokbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNKSHRTKYKHUHOKBNX2)
    public String getZrnnkshrtkykhuhokbnx2() {
        return zrnnkshrtkykhuhokbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkshrtkykhuhokbnx2(String pZrnnkshrtkykhuhokbnx2) {
        zrnnkshrtkykhuhokbnx2 = pZrnnkshrtkykhuhokbnx2;
    }

    private String zrnnkshrtkyknksyuruikbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNKSHRTKYKNKSYURUIKBNX2)
    public String getZrnnkshrtkyknksyuruikbnx2() {
        return zrnnkshrtkyknksyuruikbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkshrtkyknksyuruikbnx2(String pZrnnkshrtkyknksyuruikbnx2) {
        zrnnkshrtkyknksyuruikbnx2 = pZrnnkshrtkyknksyuruikbnx2;
    }

    private String zrnnkshrtkyknkkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNKSHRTKYKNKKKNX2)
    public String getZrnnkshrtkyknkkknx2() {
        return zrnnkshrtkyknkkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnnkshrtkyknkkknx2(String pZrnnkshrtkyknkkknx2) {
        zrnnkshrtkyknkkknx2 = pZrnnkshrtkyknkkknx2;
    }

    private Long zrnnkshrtkyknknengkx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNKSHRTKYKNKNENGKX2)
    public Long getZrnnkshrtkyknknengkx2() {
        return zrnnkshrtkyknknengkx2;
    }

    public void setZrnnkshrtkyknknengkx2(Long pZrnnkshrtkyknknengkx2) {
        zrnnkshrtkyknknengkx2 = pZrnnkshrtkyknknengkx2;
    }

    private String zrnnkshrtkykduketorihhkbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNKSHRTKYKDUKETORIHHKBNX2)
    public String getZrnnkshrtkykduketorihhkbnx2() {
        return zrnnkshrtkykduketorihhkbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnkshrtkykduketorihhkbnx2(String pZrnnkshrtkykduketorihhkbnx2) {
        zrnnkshrtkykduketorihhkbnx2 = pZrnnkshrtkykduketorihhkbnx2;
    }

    private String zrnyobiv10x2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV10X2)
    public String getZrnyobiv10x2() {
        return zrnyobiv10x2;
    }

    public void setZrnyobiv10x2(String pZrnyobiv10x2) {
        zrnyobiv10x2 = pZrnyobiv10x2;
    }

    private String zrnsyougaitkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOUGAITKYKSYURUIKGU)
    public String getZrnsyougaitkyksyuruikgu() {
        return zrnsyougaitkyksyuruikgu;
    }

    public void setZrnsyougaitkyksyuruikgu(String pZrnsyougaitkyksyuruikgu) {
        zrnsyougaitkyksyuruikgu = pZrnsyougaitkyksyuruikgu;
    }

    private String zrnsyougaitokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOUGAITOKUYAKUKIKAN)
    public String getZrnsyougaitokuyakukikan() {
        return zrnsyougaitokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyougaitokuyakukikan(String pZrnsyougaitokuyakukikan) {
        zrnsyougaitokuyakukikan = pZrnsyougaitokuyakukikan;
    }

    private String zrnsyougaitkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOUGAITKYKPHRKKKN)
    public String getZrnsyougaitkykphrkkkn() {
        return zrnsyougaitkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyougaitkykphrkkkn(String pZrnsyougaitkykphrkkkn) {
        zrnsyougaitkykphrkkkn = pZrnsyougaitkykphrkkkn;
    }

    private Long zrnsyougaitokuyakus;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOUGAITOKUYAKUS)
    public Long getZrnsyougaitokuyakus() {
        return zrnsyougaitokuyakus;
    }

    public void setZrnsyougaitokuyakus(Long pZrnsyougaitokuyakus) {
        zrnsyougaitokuyakus = pZrnsyougaitokuyakus;
    }

    private Long zrnsyougaitokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOUGAITOKUYAKUP)
    public Long getZrnsyougaitokuyakup() {
        return zrnsyougaitokuyakup;
    }

    public void setZrnsyougaitokuyakup(Long pZrnsyougaitokuyakup) {
        zrnsyougaitokuyakup = pZrnsyougaitokuyakup;
    }

    private String zrnsyougaitkkatakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOUGAITKKATAKBN)
    public String getZrnsyougaitkkatakbn() {
        return zrnsyougaitkkatakbn;
    }

    public void setZrnsyougaitkkatakbn(String pZrnsyougaitkkatakbn) {
        zrnsyougaitkkatakbn = pZrnsyougaitkkatakbn;
    }

    private String zrnsyougaitkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOUGAITKYKKGUSDKBN)
    public String getZrnsyougaitkykkgusdkbn() {
        return zrnsyougaitkykkgusdkbn;
    }

    public void setZrnsyougaitkykkgusdkbn(String pZrnsyougaitkykkgusdkbn) {
        zrnsyougaitkykkgusdkbn = pZrnsyougaitkykkgusdkbn;
    }

    private String zrnsyugitkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYUGITKYKPWRBKKBN)
    public String getZrnsyugitkykpwrbkkbn() {
        return zrnsyugitkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyugitkykpwrbkkbn(String pZrnsyugitkykpwrbkkbn) {
        zrnsyugitkykpwrbkkbn = pZrnsyugitkykpwrbkkbn;
    }

    private String zrnsyougaitkykkusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOUGAITKYKKUSNMNRYOAGE)
    public String getZrnsyougaitkykkusnmnryoage() {
        return zrnsyougaitkykkusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyougaitkykkusnmnryoage(String pZrnsyougaitkykkusnmnryoage) {
        zrnsyougaitkykkusnmnryoage = pZrnsyougaitkykkusnmnryoage;
    }

    private String zrnyobiv5x2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV5X2)
    public String getZrnyobiv5x2() {
        return zrnyobiv5x2;
    }

    public void setZrnyobiv5x2(String pZrnyobiv5x2) {
        zrnyobiv5x2 = pZrnyobiv5x2;
    }

    private String zrnsigiwrmstkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIGIWRMSTKYKSYURUIKGU)
    public String getZrnsigiwrmstkyksyuruikgu() {
        return zrnsigiwrmstkyksyuruikgu;
    }

    public void setZrnsigiwrmstkyksyuruikgu(String pZrnsigiwrmstkyksyuruikgu) {
        zrnsigiwrmstkyksyuruikgu = pZrnsigiwrmstkyksyuruikgu;
    }

    private String zrnsigiwrmstkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIGIWRMSTKYKKKN)
    public String getZrnsigiwrmstkykkkn() {
        return zrnsigiwrmstkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsigiwrmstkykkkn(String pZrnsigiwrmstkykkkn) {
        zrnsigiwrmstkykkkn = pZrnsigiwrmstkykkkn;
    }

    private String zrnsaigaiwrmstkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSAIGAIWRMSTKYKPHRKKKN)
    public String getZrnsaigaiwrmstkykphrkkkn() {
        return zrnsaigaiwrmstkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsaigaiwrmstkykphrkkkn(String pZrnsaigaiwrmstkykphrkkkn) {
        zrnsaigaiwrmstkykphrkkkn = pZrnsaigaiwrmstkykphrkkkn;
    }

    private Long zrnsaigaiwarimasitokuyakus;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSAIGAIWARIMASITOKUYAKUS)
    public Long getZrnsaigaiwarimasitokuyakus() {
        return zrnsaigaiwarimasitokuyakus;
    }

    public void setZrnsaigaiwarimasitokuyakus(Long pZrnsaigaiwarimasitokuyakus) {
        zrnsaigaiwarimasitokuyakus = pZrnsaigaiwarimasitokuyakus;
    }

    private Long zrnsaigaiwarimasitokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSAIGAIWARIMASITOKUYAKUP)
    public Long getZrnsaigaiwarimasitokuyakup() {
        return zrnsaigaiwarimasitokuyakup;
    }

    public void setZrnsaigaiwarimasitokuyakup(Long pZrnsaigaiwarimasitokuyakup) {
        zrnsaigaiwarimasitokuyakup = pZrnsaigaiwarimasitokuyakup;
    }

    private String zrnsaigaiwrmstkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSAIGAIWRMSTKYKKGUSDKBN)
    public String getZrnsaigaiwrmstkykkgusdkbn() {
        return zrnsaigaiwrmstkykkgusdkbn;
    }

    public void setZrnsaigaiwrmstkykkgusdkbn(String pZrnsaigaiwrmstkykkgusdkbn) {
        zrnsaigaiwrmstkykkgusdkbn = pZrnsaigaiwrmstkykkgusdkbn;
    }

    private String zrnsigiwrmstkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIGIWRMSTKYKPWRBKKBN)
    public String getZrnsigiwrmstkykpwrbkkbn() {
        return zrnsigiwrmstkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsigiwrmstkykpwrbkkbn(String pZrnsigiwrmstkykpwrbkkbn) {
        zrnsigiwrmstkykpwrbkkbn = pZrnsigiwrmstkykpwrbkkbn;
    }

    private String zrnsigiwrmstkykkusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIGIWRMSTKYKKUSNMNRYOAGE)
    public String getZrnsigiwrmstkykkusnmnryoage() {
        return zrnsigiwrmstkykkusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsigiwrmstkykkusnmnryoage(String pZrnsigiwrmstkykkusnmnryoage) {
        zrnsigiwrmstkykkusnmnryoage = pZrnsigiwrmstkykkusnmnryoage;
    }

    private String zrnyobiv5x3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV5X3)
    public String getZrnyobiv5x3() {
        return zrnyobiv5x3;
    }

    public void setZrnyobiv5x3(String pZrnyobiv5x3) {
        zrnyobiv5x3 = pZrnyobiv5x3;
    }

    private String zrnsiginyuintkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIGINYUINTKYKSYURUIKGU)
    public String getZrnsiginyuintkyksyuruikgu() {
        return zrnsiginyuintkyksyuruikgu;
    }

    public void setZrnsiginyuintkyksyuruikgu(String pZrnsiginyuintkyksyuruikgu) {
        zrnsiginyuintkyksyuruikgu = pZrnsiginyuintkyksyuruikgu;
    }

    private String zrnsiginyuintkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIGINYUINTKYKKKN)
    public String getZrnsiginyuintkykkkn() {
        return zrnsiginyuintkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiginyuintkykkkn(String pZrnsiginyuintkykkkn) {
        zrnsiginyuintkykkkn = pZrnsiginyuintkykkkn;
    }

    private String zrnsaigainyuintkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSAIGAINYUINTKYKPHRKKKN)
    public String getZrnsaigainyuintkykphrkkkn() {
        return zrnsaigainyuintkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsaigainyuintkykphrkkkn(String pZrnsaigainyuintkykphrkkkn) {
        zrnsaigainyuintkykphrkkkn = pZrnsaigainyuintkykphrkkkn;
    }

    private Integer zrnsiginyuintkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIGINYUINTKYKNTGK)
    public Integer getZrnsiginyuintkykntgk() {
        return zrnsiginyuintkykntgk;
    }

    public void setZrnsiginyuintkykntgk(Integer pZrnsiginyuintkykntgk) {
        zrnsiginyuintkykntgk = pZrnsiginyuintkykntgk;
    }

    private String zrnsiginyuintkykgtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIGINYUINTKYKGTKBN)
    public String getZrnsiginyuintkykgtkbn() {
        return zrnsiginyuintkykgtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiginyuintkykgtkbn(String pZrnsiginyuintkykgtkbn) {
        zrnsiginyuintkykgtkbn = pZrnsiginyuintkykgtkbn;
    }

    private Long zrnsaigainyuuintokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSAIGAINYUUINTOKUYAKUP)
    public Long getZrnsaigainyuuintokuyakup() {
        return zrnsaigainyuuintokuyakup;
    }

    public void setZrnsaigainyuuintokuyakup(Long pZrnsaigainyuuintokuyakup) {
        zrnsaigainyuuintokuyakup = pZrnsaigainyuuintokuyakup;
    }

    private String zrnsaigainyuintkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSAIGAINYUINTKYKKGUSDKBN)
    public String getZrnsaigainyuintkykkgusdkbn() {
        return zrnsaigainyuintkykkgusdkbn;
    }

    public void setZrnsaigainyuintkykkgusdkbn(String pZrnsaigainyuintkykkgusdkbn) {
        zrnsaigainyuintkykkgusdkbn = pZrnsaigainyuintkykkgusdkbn;
    }

    private String zrnsiginyuintkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIGINYUINTKYKPWRBKKBN)
    public String getZrnsiginyuintkykpwrbkkbn() {
        return zrnsiginyuintkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiginyuintkykpwrbkkbn(String pZrnsiginyuintkykpwrbkkbn) {
        zrnsiginyuintkykpwrbkkbn = pZrnsiginyuintkykpwrbkkbn;
    }

    private String zrnyobiv7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV7)
    public String getZrnyobiv7() {
        return zrnyobiv7;
    }

    public void setZrnyobiv7(String pZrnyobiv7) {
        zrnyobiv7 = pZrnyobiv7;
    }

    private String zrnsppinyuintkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUINTKYKSYURUIKGU)
    public String getZrnsppinyuintkyksyuruikgu() {
        return zrnsppinyuintkyksyuruikgu;
    }

    public void setZrnsppinyuintkyksyuruikgu(String pZrnsppinyuintkyksyuruikgu) {
        zrnsppinyuintkyksyuruikgu = pZrnsppinyuintkyksyuruikgu;
    }

    private String zrnsppinyuintkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUINTKYKKKN)
    public String getZrnsppinyuintkykkkn() {
        return zrnsppinyuintkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsppinyuintkykkkn(String pZrnsppinyuintkykkkn) {
        zrnsppinyuintkykkkn = pZrnsppinyuintkykkkn;
    }

    private String zrnsppinyuuintkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUUINTKYKPHRKKKN)
    public String getZrnsppinyuuintkykphrkkkn() {
        return zrnsppinyuuintkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsppinyuuintkykphrkkkn(String pZrnsppinyuuintkykphrkkkn) {
        zrnsppinyuuintkykphrkkkn = pZrnsppinyuuintkykphrkkkn;
    }

    private Integer zrnsppinyuintkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUINTKYKNTGK)
    public Integer getZrnsppinyuintkykntgk() {
        return zrnsppinyuintkykntgk;
    }

    public void setZrnsppinyuintkykntgk(Integer pZrnsppinyuintkykntgk) {
        zrnsppinyuintkykntgk = pZrnsppinyuintkykntgk;
    }

    private String zrnsppinyuintkykgtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUINTKYKGTKBN)
    public String getZrnsppinyuintkykgtkbn() {
        return zrnsppinyuintkykgtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsppinyuintkykgtkbn(String pZrnsppinyuintkykgtkbn) {
        zrnsppinyuintkykgtkbn = pZrnsppinyuintkykgtkbn;
    }

    private Long zrnsippeinyuuintokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIPPEINYUUINTOKUYAKUP)
    public Long getZrnsippeinyuuintokuyakup() {
        return zrnsippeinyuuintokuyakup;
    }

    public void setZrnsippeinyuuintokuyakup(Long pZrnsippeinyuuintokuyakup) {
        zrnsippeinyuuintokuyakup = pZrnsippeinyuuintokuyakup;
    }

    private Integer zrnsppinyuintkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUINTKJYURYUMSHYUTN)
    public Integer getZrnsppinyuintkjyuryumshyutn() {
        return zrnsppinyuintkjyuryumshyutn;
    }

    public void setZrnsppinyuintkjyuryumshyutn(Integer pZrnsppinyuintkjyuryumshyutn) {
        zrnsppinyuintkjyuryumshyutn = pZrnsppinyuintkjyuryumshyutn;
    }

    private Long zrnsippeinyuuintokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIPPEINYUUINTOKUJYOUP)
    public Long getZrnsippeinyuuintokujyoup() {
        return zrnsippeinyuuintokujyoup;
    }

    public void setZrnsippeinyuuintokujyoup(Long pZrnsippeinyuuintokujyoup) {
        zrnsippeinyuuintokujyoup = pZrnsippeinyuuintokujyoup;
    }

    private String zrnsppinyuintktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUINTKTBICDX1)
    public String getZrnsppinyuintktbicdx1() {
        return zrnsppinyuintktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsppinyuintktbicdx1(String pZrnsppinyuintktbicdx1) {
        zrnsppinyuintktbicdx1 = pZrnsppinyuintktbicdx1;
    }

    private String zrnsppinyuinhtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUINHTNPKKNX1)
    public String getZrnsppinyuinhtnpkknx1() {
        return zrnsppinyuinhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsppinyuinhtnpkknx1(String pZrnsppinyuinhtnpkknx1) {
        zrnsppinyuinhtnpkknx1 = pZrnsppinyuinhtnpkknx1;
    }

    private String zrnsppinyuintktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUINTKTBICDX2)
    public String getZrnsppinyuintktbicdx2() {
        return zrnsppinyuintktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsppinyuintktbicdx2(String pZrnsppinyuintktbicdx2) {
        zrnsppinyuintktbicdx2 = pZrnsppinyuintktbicdx2;
    }

    private String zrnsppinyuinhtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUINHTNPKKNX2)
    public String getZrnsppinyuinhtnpkknx2() {
        return zrnsppinyuinhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsppinyuinhtnpkknx2(String pZrnsppinyuinhtnpkknx2) {
        zrnsppinyuinhtnpkknx2 = pZrnsppinyuinhtnpkknx2;
    }

    private String zrnsppinyuuintkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUUINTKYKKGUSDKBN)
    public String getZrnsppinyuuintkykkgusdkbn() {
        return zrnsppinyuuintkykkgusdkbn;
    }

    public void setZrnsppinyuuintkykkgusdkbn(String pZrnsppinyuuintkykkgusdkbn) {
        zrnsppinyuuintkykkgusdkbn = pZrnsppinyuuintkykkgusdkbn;
    }

    private String zrnsppinyuintkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSPPINYUINTKYKPWRBKKBN)
    public String getZrnsppinyuintkykpwrbkkbn() {
        return zrnsppinyuintkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsppinyuintkykpwrbkkbn(String pZrnsppinyuintkykpwrbkkbn) {
        zrnsppinyuintkykpwrbkkbn = pZrnsppinyuintkykpwrbkkbn;
    }

    private String zrnyobiv7x2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV7X2)
    public String getZrnyobiv7x2() {
        return zrnyobiv7x2;
    }

    public void setZrnyobiv7x2(String pZrnyobiv7x2) {
        zrnyobiv7x2 = pZrnyobiv7x2;
    }

    private String zrnsijnbyutkyksyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIJNBYUTKYKSYURUIKGU)
    public String getZrnsijnbyutkyksyuruikgu() {
        return zrnsijnbyutkyksyuruikgu;
    }

    public void setZrnsijnbyutkyksyuruikgu(String pZrnsijnbyutkyksyuruikgu) {
        zrnsijnbyutkyksyuruikgu = pZrnsijnbyutkyksyuruikgu;
    }

    private String zrnseijinbyoutokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIJINBYOUTOKUYAKUKIKAN)
    public String getZrnseijinbyoutokuyakukikan() {
        return zrnseijinbyoutokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseijinbyoutokuyakukikan(String pZrnseijinbyoutokuyakukikan) {
        zrnseijinbyoutokuyakukikan = pZrnseijinbyoutokuyakukikan;
    }

    private String zrnseijinbyoutkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIJINBYOUTKYKPHRKKKN)
    public String getZrnseijinbyoutkykphrkkkn() {
        return zrnseijinbyoutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseijinbyoutkykphrkkkn(String pZrnseijinbyoutkykphrkkkn) {
        zrnseijinbyoutkykphrkkkn = pZrnseijinbyoutkykphrkkkn;
    }

    private Integer zrnseijinbyoutokuyakuntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIJINBYOUTOKUYAKUNTGK)
    public Integer getZrnseijinbyoutokuyakuntgk() {
        return zrnseijinbyoutokuyakuntgk;
    }

    public void setZrnseijinbyoutokuyakuntgk(Integer pZrnseijinbyoutokuyakuntgk) {
        zrnseijinbyoutokuyakuntgk = pZrnseijinbyoutokuyakuntgk;
    }

    private Long zrnseijinbyoutokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIJINBYOUTOKUYAKUP)
    public Long getZrnseijinbyoutokuyakup() {
        return zrnseijinbyoutokuyakup;
    }

    public void setZrnseijinbyoutokuyakup(Long pZrnseijinbyoutokuyakup) {
        zrnseijinbyoutokuyakup = pZrnseijinbyoutokuyakup;
    }

    private Integer zrnsijnbyutkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIJNBYUTKJYURYUMSHYUTN)
    public Integer getZrnsijnbyutkjyuryumshyutn() {
        return zrnsijnbyutkjyuryumshyutn;
    }

    public void setZrnsijnbyutkjyuryumshyutn(Integer pZrnsijnbyutkjyuryumshyutn) {
        zrnsijnbyutkjyuryumshyutn = pZrnsijnbyutkjyuryumshyutn;
    }

    private Long zrnseijinbyoutokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIJINBYOUTOKUJYOUP)
    public Long getZrnseijinbyoutokujyoup() {
        return zrnseijinbyoutokujyoup;
    }

    public void setZrnseijinbyoutokujyoup(Long pZrnseijinbyoutokujyoup) {
        zrnseijinbyoutokujyoup = pZrnseijinbyoutokujyoup;
    }

    private String zrnseijinbyoutokuteibuicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIJINBYOUTOKUTEIBUICDX1)
    public String getZrnseijinbyoutokuteibuicdx1() {
        return zrnseijinbyoutokuteibuicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseijinbyoutokuteibuicdx1(String pZrnseijinbyoutokuteibuicdx1) {
        zrnseijinbyoutokuteibuicdx1 = pZrnseijinbyoutokuteibuicdx1;
    }

    private String zrnseijinbyouhutanpokikanx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIJINBYOUHUTANPOKIKANX1)
    public String getZrnseijinbyouhutanpokikanx1() {
        return zrnseijinbyouhutanpokikanx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseijinbyouhutanpokikanx1(String pZrnseijinbyouhutanpokikanx1) {
        zrnseijinbyouhutanpokikanx1 = pZrnseijinbyouhutanpokikanx1;
    }

    private String zrnseijinbyoutokuteibuicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIJINBYOUTOKUTEIBUICDX2)
    public String getZrnseijinbyoutokuteibuicdx2() {
        return zrnseijinbyoutokuteibuicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseijinbyoutokuteibuicdx2(String pZrnseijinbyoutokuteibuicdx2) {
        zrnseijinbyoutokuteibuicdx2 = pZrnseijinbyoutokuteibuicdx2;
    }

    private String zrnseijinbyouhutanpokikanx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIJINBYOUHUTANPOKIKANX2)
    public String getZrnseijinbyouhutanpokikanx2() {
        return zrnseijinbyouhutanpokikanx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseijinbyouhutanpokikanx2(String pZrnseijinbyouhutanpokikanx2) {
        zrnseijinbyouhutanpokikanx2 = pZrnseijinbyouhutanpokikanx2;
    }

    private String zrnseijinbyoutkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIJINBYOUTKYKKGUSDKBN)
    public String getZrnseijinbyoutkykkgusdkbn() {
        return zrnseijinbyoutkykkgusdkbn;
    }

    public void setZrnseijinbyoutkykkgusdkbn(String pZrnseijinbyoutkykkgusdkbn) {
        zrnseijinbyoutkykkgusdkbn = pZrnseijinbyoutkykkgusdkbn;
    }

    private String zrnsijnbyutkykgankyuhgtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIJNBYUTKYKGANKYUHGTKBN)
    public String getZrnsijnbyutkykgankyuhgtkbn() {
        return zrnsijnbyutkykgankyuhgtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsijnbyutkykgankyuhgtkbn(String pZrnsijnbyutkykgankyuhgtkbn) {
        zrnsijnbyutkykgankyuhgtkbn = pZrnsijnbyutkykgankyuhgtkbn;
    }

    private String zrnsijnbyutkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIJNBYUTKYKPWRBKKBN)
    public String getZrnsijnbyutkykpwrbkkbn() {
        return zrnsijnbyutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsijnbyutkykpwrbkkbn(String pZrnsijnbyutkykpwrbkkbn) {
        zrnsijnbyutkykpwrbkkbn = pZrnsijnbyutkykpwrbkkbn;
    }

    private String zrnsijnbyutkykkusnmnryoage;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIJNBYUTKYKKUSNMNRYOAGE)
    public String getZrnsijnbyutkykkusnmnryoage() {
        return zrnsijnbyutkykkusnmnryoage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsijnbyutkykkusnmnryoage(String pZrnsijnbyutkykkusnmnryoage) {
        zrnsijnbyutkykkusnmnryoage = pZrnsijnbyutkykkusnmnryoage;
    }

    private String zrnyobiv4x11;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV4X11)
    public String getZrnyobiv4x11() {
        return zrnyobiv4x11;
    }

    public void setZrnyobiv4x11(String pZrnyobiv4x11) {
        zrnyobiv4x11 = pZrnyobiv4x11;
    }

    private String zrnheiyoubaraikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHEIYOUBARAIKBN)
    public String getZrnheiyoubaraikbn() {
        return zrnheiyoubaraikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnheiyoubaraikbn(String pZrnheiyoubaraikbn) {
        zrnheiyoubaraikbn = pZrnheiyoubaraikbn;
    }

    private String zrnhiyubriaitsyono;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIYUBRIAITSYONO)
    public String getZrnhiyubriaitsyono() {
        return zrnhiyubriaitsyono;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhiyubriaitsyono(String pZrnhiyubriaitsyono) {
        zrnhiyubriaitsyono = pZrnhiyubriaitsyono;
    }

    private String zrnhiyubriaithrkkeirokbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIYUBRIAITHRKKEIROKBN)
    public String getZrnhiyubriaithrkkeirokbn() {
        return zrnhiyubriaithrkkeirokbn;
    }

    public void setZrnhiyubriaithrkkeirokbn(String pZrnhiyubriaithrkkeirokbn) {
        zrnhiyubriaithrkkeirokbn = pZrnhiyubriaithrkkeirokbn;
    }

    private Long zrnheiyoubaraiaitekihons;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHEIYOUBARAIAITEKIHONS)
    public Long getZrnheiyoubaraiaitekihons() {
        return zrnheiyoubaraiaitekihons;
    }

    public void setZrnheiyoubaraiaitekihons(Long pZrnheiyoubaraiaitekihons) {
        zrnheiyoubaraiaitekihons = pZrnheiyoubaraiaitekihons;
    }

    private Long zrnhiyubrigukitnknitjbrkhns;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIYUBRIGUKITNKNITJBRKHNS)
    public Long getZrnhiyubrigukitnknitjbrkhns() {
        return zrnhiyubrigukitnknitjbrkhns;
    }

    public void setZrnhiyubrigukitnknitjbrkhns(Long pZrnhiyubrigukitnknitjbrkhns) {
        zrnhiyubrigukitnknitjbrkhns = pZrnhiyubrigukitnknitjbrkhns;
    }

    private Long zrnheiyoubaraiaitesibous;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHEIYOUBARAIAITESIBOUS)
    public Long getZrnheiyoubaraiaitesibous() {
        return zrnheiyoubaraiaitesibous;
    }

    public void setZrnheiyoubaraiaitesibous(Long pZrnheiyoubaraiaitesibous) {
        zrnheiyoubaraiaitesibous = pZrnheiyoubaraiaitesibous;
    }

    private Long zrnhiyubrigukitnknitjbrsbus;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIYUBRIGUKITNKNITJBRSBUS)
    public Long getZrnhiyubrigukitnknitjbrsbus() {
        return zrnhiyubrigukitnknitjbrsbus;
    }

    public void setZrnhiyubrigukitnknitjbrsbus(Long pZrnhiyubrigukitnknitjbrsbus) {
        zrnhiyubrigukitnknitjbrsbus = pZrnhiyubrigukitnknitjbrsbus;
    }

    private Long zrnheiyoubaraiaitesyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHEIYOUBARAIAITESYUUSEIS)
    public Long getZrnheiyoubaraiaitesyuuseis() {
        return zrnheiyoubaraiaitesyuuseis;
    }

    public void setZrnheiyoubaraiaitesyuuseis(Long pZrnheiyoubaraiaitesyuuseis) {
        zrnheiyoubaraiaitesyuuseis = pZrnheiyoubaraiaitesyuuseis;
    }

    private Long zrnheiyoubaraiaitehrkp;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHEIYOUBARAIAITEHRKP)
    public Long getZrnheiyoubaraiaitehrkp() {
        return zrnheiyoubaraiaitehrkp;
    }

    public void setZrnheiyoubaraiaitehrkp(Long pZrnheiyoubaraiaitehrkp) {
        zrnheiyoubaraiaitehrkp = pZrnheiyoubaraiaitehrkp;
    }

    private Long zrnhiyubriaitsykykp;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIYUBRIAITSYKYKP)
    public Long getZrnhiyubriaitsykykp() {
        return zrnhiyubriaitsykykp;
    }

    public void setZrnhiyubriaitsykykp(Long pZrnhiyubriaitsykykp) {
        zrnhiyubriaitsykykp = pZrnhiyubriaitsykykp;
    }

    private Long zrnheiyoubaraiaitemrtis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHEIYOUBARAIAITEMRTIS)
    public Long getZrnheiyoubaraiaitemrtis() {
        return zrnheiyoubaraiaitemrtis;
    }

    public void setZrnheiyoubaraiaitemrtis(Long pZrnheiyoubaraiaitemrtis) {
        zrnheiyoubaraiaitemrtis = pZrnheiyoubaraiaitemrtis;
    }

    private Long zrnhiyubrigukiaitkzkmrtis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIYUBRIGUKIAITKZKMRTIS)
    public Long getZrnhiyubrigukiaitkzkmrtis() {
        return zrnhiyubrigukiaitkzkmrtis;
    }

    public void setZrnhiyubrigukiaitkzkmrtis(Long pZrnhiyubrigukiaitkzkmrtis) {
        zrnhiyubrigukiaitkzkmrtis = pZrnhiyubrigukiaitkzkmrtis;
    }

    private String zrntukibaraikyktenkanhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTUKIBARAIKYKTENKANHYJ)
    public String getZrntukibaraikyktenkanhyj() {
        return zrntukibaraikyktenkanhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntukibaraikyktenkanhyj(String pZrntukibaraikyktenkanhyj) {
        zrntukibaraikyktenkanhyj = pZrntukibaraikyktenkanhyj;
    }

    private String zrnbonusharaihrkkigetu1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNBONUSHARAIHRKKIGETU1)
    public String getZrnbonusharaihrkkigetu1() {
        return zrnbonusharaihrkkigetu1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnbonusharaihrkkigetu1(String pZrnbonusharaihrkkigetu1) {
        zrnbonusharaihrkkigetu1 = pZrnbonusharaihrkkigetu1;
    }

    private String zrnbonusharaihrkkigetu2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNBONUSHARAIHRKKIGETU2)
    public String getZrnbonusharaihrkkigetu2() {
        return zrnbonusharaihrkkigetu2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnbonusharaihrkkigetu2(String pZrnbonusharaihrkkigetu2) {
        zrnbonusharaihrkkigetu2 = pZrnbonusharaihrkkigetu2;
    }

    private Long zrnhiyubriaitsiznmrtis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIYUBRIAITSIZNMRTIS)
    public Long getZrnhiyubriaitsiznmrtis() {
        return zrnhiyubriaitsiznmrtis;
    }

    public void setZrnhiyubriaitsiznmrtis(Long pZrnhiyubriaitsiznmrtis) {
        zrnhiyubriaitsiznmrtis = pZrnhiyubriaitsiznmrtis;
    }

    private Long zrnhiyubriaittignmrtis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHIYUBRIAITTIGNMRTIS)
    public Long getZrnhiyubriaittignmrtis() {
        return zrnhiyubriaittignmrtis;
    }

    public void setZrnhiyubriaittignmrtis(Long pZrnhiyubriaittignmrtis) {
        zrnhiyubriaittignmrtis = pZrnhiyubriaittignmrtis;
    }

    private String zrntkjykbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTKJYKBN)
    public String getZrntkjykbn() {
        return zrntkjykbn;
    }

    public void setZrntkjykbn(String pZrntkjykbn) {
        zrntkjykbn = pZrntkjykbn;
    }

    private String zrnsakugenkikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSAKUGENKIKAN)
    public String getZrnsakugenkikan() {
        return zrnsakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsakugenkikan(String pZrnsakugenkikan) {
        zrnsakugenkikan = pZrnsakugenkikan;
    }

    private Integer zrnryoumasihyouten;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNRYOUMASIHYOUTEN)
    public Integer getZrnryoumasihyouten() {
        return zrnryoumasihyouten;
    }

    public void setZrnryoumasihyouten(Integer pZrnryoumasihyouten) {
        zrnryoumasihyouten = pZrnryoumasihyouten;
    }

    private Long zrntokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTOKUJYOUP)
    public Long getZrntokujyoup() {
        return zrntokujyoup;
    }

    public void setZrntokujyoup(Long pZrntokujyoup) {
        zrntokujyoup = pZrntokujyoup;
    }

    private String zrnhjncd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHJNCD)
    public String getZrnhjncd() {
        return zrnhjncd;
    }

    public void setZrnhjncd(String pZrnhjncd) {
        zrnhjncd = pZrnhjncd;
    }

    private String zrnhjnjigyosyocd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHJNJIGYOSYOCD)
    public String getZrnhjnjigyosyocd() {
        return zrnhjnjigyosyocd;
    }

    public void setZrnhjnjigyosyocd(String pZrnhjnjigyosyocd) {
        zrnhjnjigyosyocd = pZrnhjnjigyosyocd;
    }

    private Integer zrnjyuugyouinsuu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNJYUUGYOUINSUU)
    public Integer getZrnjyuugyouinsuu() {
        return zrnjyuugyouinsuu;
    }

    public void setZrnjyuugyouinsuu(Integer pZrnjyuugyouinsuu) {
        zrnjyuugyouinsuu = pZrnjyuugyouinsuu;
    }

    private String zrniktkaisuu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNIKTKAISUU)
    public String getZrniktkaisuu() {
        return zrniktkaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrniktkaisuu(String pZrniktkaisuu) {
        zrniktkaisuu = pZrniktkaisuu;
    }

    private String zrnznnkai;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNZNNKAI)
    public String getZrnznnkai() {
        return zrnznnkai;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnznnkai(String pZrnznnkai) {
        zrnznnkai = pZrnznnkai;
    }

    private String zrnkyktsnatkitkykkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKYKTSNATKITKYKKBN)
    public String getZrnkyktsnatkitkykkbn() {
        return zrnkyktsnatkitkykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkyktsnatkitkykkbn(String pZrnkyktsnatkitkykkbn) {
        zrnkyktsnatkitkykkbn = pZrnkyktsnatkitkykkbn;
    }

    private String zrnkyktsnatkitkykstagekbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKYKTSNATKITKYKSTAGEKBN)
    public String getZrnkyktsnatkitkykstagekbn() {
        return zrnkyktsnatkitkykstagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkyktsnatkitkykstagekbn(String pZrnkyktsnatkitkykstagekbn) {
        zrnkyktsnatkitkykstagekbn = pZrnkyktsnatkitkykstagekbn;
    }

    private String zrnpmentokuyakukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNPMENTOKUYAKUKBN)
    public String getZrnpmentokuyakukbn() {
        return zrnpmentokuyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnpmentokuyakukbn(String pZrnpmentokuyakukbn) {
        zrnpmentokuyakukbn = pZrnpmentokuyakukbn;
    }

    private String zrnyobiv3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV3)
    public String getZrnyobiv3() {
        return zrnyobiv3;
    }

    public void setZrnyobiv3(String pZrnyobiv3) {
        zrnyobiv3 = pZrnyobiv3;
    }

    private Long zrntkykznnunyukngk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTKYKZNNUNYUKNGK)
    public Long getZrntkykznnunyukngk() {
        return zrntkykznnunyukngk;
    }

    public void setZrntkykznnunyukngk(Long pZrntkykznnunyukngk) {
        zrntkykznnunyukngk = pZrntkykznnunyukngk;
    }

    private String zrnsyokaipnyuukinhouhoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOKAIPNYUUKINHOUHOUKBN)
    public String getZrnsyokaipnyuukinhouhoukbn() {
        return zrnsyokaipnyuukinhouhoukbn;
    }

    public void setZrnsyokaipnyuukinhouhoukbn(String pZrnsyokaipnyuukinhouhoukbn) {
        zrnsyokaipnyuukinhouhoukbn = pZrnsyokaipnyuukinhouhoukbn;
    }

    private String zrnhtnknkyksyonox1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSYONOX1)
    public String getZrnhtnknkyksyonox1() {
        return zrnhtnknkyksyonox1;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkyksyonox1(String pZrnhtnknkyksyonox1) {
        zrnhtnknkyksyonox1 = pZrnhtnknkyksyonox1;
    }

    private String zrnhtnknkykhknsyuruikgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNSYURUIKGUX1)
    public String getZrnhtnknkykhknsyuruikgux1() {
        return zrnhtnknkykhknsyuruikgux1;
    }

    public void setZrnhtnknkykhknsyuruikgux1(String pZrnhtnknkykhknsyuruikgux1) {
        zrnhtnknkykhknsyuruikgux1 = pZrnhtnknkykhknsyuruikgux1;
    }

    private String zrntenkanuketukeymdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTENKANUKETUKEYMDX1)
    public String getZrntenkanuketukeymdx1() {
        return zrntenkanuketukeymdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntenkanuketukeymdx1(String pZrntenkanuketukeymdx1) {
        zrntenkanuketukeymdx1 = pZrntenkanuketukeymdx1;
    }

    private String zrnhtnknkykkykymdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKKYKYMDX1)
    public String getZrnhtnknkykkykymdx1() {
        return zrnhtnknkykkykymdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknkykkykymdx1(String pZrnhtnknkykkykymdx1) {
        zrnhtnknkykkykymdx1 = pZrnhtnknkykkykymdx1;
    }

    private String zrnhtnknkykhknkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNKKNX1)
    public String getZrnhtnknkykhknkknx1() {
        return zrnhtnknkykhknkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykhknkknx1(String pZrnhtnknkykhknkknx1) {
        zrnhtnknkykhknkknx1 = pZrnhtnknkykhknkknx1;
    }

    private String zrnhtnknkykphrkkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKPHRKKKNX1)
    public String getZrnhtnknkykphrkkknx1() {
        return zrnhtnknkykphrkkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykphrkkknx1(String pZrnhtnknkykphrkkknx1) {
        zrnhtnknkykphrkkknx1 = pZrnhtnknkykphrkkknx1;
    }

    private String zrnhtnknkykhrkkaisuukbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKAISUUKBNX1)
    public String getZrnhtnknkykhrkkaisuukbnx1() {
        return zrnhtnknkykhrkkaisuukbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkkaisuukbnx1(String pZrnhtnknkykhrkkaisuukbnx1) {
        zrnhtnknkykhrkkaisuukbnx1 = pZrnhtnknkykhrkkaisuukbnx1;
    }

    private String zrnhtnknkykhrkkeirokbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKEIROKBNX1)
    public String getZrnhtnknkykhrkkeirokbnx1() {
        return zrnhtnknkykhrkkeirokbnx1;
    }

    public void setZrnhtnknkykhrkkeirokbnx1(String pZrnhtnknkykhrkkeirokbnx1) {
        zrnhtnknkykhrkkeirokbnx1 = pZrnhtnknkykhrkkeirokbnx1;
    }

    private String zrntnknuktkzngtkijyuhyjx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTNKNUKTKZNGTKIJYUHYJX1)
    public String getZrntnknuktkzngtkijyuhyjx1() {
        return zrntnknuktkzngtkijyuhyjx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknuktkzngtkijyuhyjx1(String pZrntnknuktkzngtkijyuhyjx1) {
        zrntnknuktkzngtkijyuhyjx1 = pZrntnknuktkzngtkijyuhyjx1;
    }

    private String zrnhtnknkykmrtisyuruikgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKMRTISYURUIKGUX1)
    public String getZrnhtnknkykmrtisyuruikgux1() {
        return zrnhtnknkykmrtisyuruikgux1;
    }

    public void setZrnhtnknkykmrtisyuruikgux1(String pZrnhtnknkykmrtisyuruikgux1) {
        zrnhtnknkykmrtisyuruikgux1 = pZrnhtnknkykmrtisyuruikgux1;
    }

    private String zrnhtnknkyksyonox2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSYONOX2)
    public String getZrnhtnknkyksyonox2() {
        return zrnhtnknkyksyonox2;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkyksyonox2(String pZrnhtnknkyksyonox2) {
        zrnhtnknkyksyonox2 = pZrnhtnknkyksyonox2;
    }

    private String zrnhtnknkykhknsyuruikgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNSYURUIKGUX2)
    public String getZrnhtnknkykhknsyuruikgux2() {
        return zrnhtnknkykhknsyuruikgux2;
    }

    public void setZrnhtnknkykhknsyuruikgux2(String pZrnhtnknkykhknsyuruikgux2) {
        zrnhtnknkykhknsyuruikgux2 = pZrnhtnknkykhknsyuruikgux2;
    }

    private String zrntenkanuketukeymdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTENKANUKETUKEYMDX2)
    public String getZrntenkanuketukeymdx2() {
        return zrntenkanuketukeymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntenkanuketukeymdx2(String pZrntenkanuketukeymdx2) {
        zrntenkanuketukeymdx2 = pZrntenkanuketukeymdx2;
    }

    private String zrnhtnknkykkykymdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKKYKYMDX2)
    public String getZrnhtnknkykkykymdx2() {
        return zrnhtnknkykkykymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknkykkykymdx2(String pZrnhtnknkykkykymdx2) {
        zrnhtnknkykkykymdx2 = pZrnhtnknkykkykymdx2;
    }

    private String zrnhtnknkykhknkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNKKNX2)
    public String getZrnhtnknkykhknkknx2() {
        return zrnhtnknkykhknkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykhknkknx2(String pZrnhtnknkykhknkknx2) {
        zrnhtnknkykhknkknx2 = pZrnhtnknkykhknkknx2;
    }

    private String zrnhtnknkykphrkkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKPHRKKKNX2)
    public String getZrnhtnknkykphrkkknx2() {
        return zrnhtnknkykphrkkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykphrkkknx2(String pZrnhtnknkykphrkkknx2) {
        zrnhtnknkykphrkkknx2 = pZrnhtnknkykphrkkknx2;
    }

    private String zrnhtnknkykhrkkaisuukbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKAISUUKBNX2)
    public String getZrnhtnknkykhrkkaisuukbnx2() {
        return zrnhtnknkykhrkkaisuukbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkkaisuukbnx2(String pZrnhtnknkykhrkkaisuukbnx2) {
        zrnhtnknkykhrkkaisuukbnx2 = pZrnhtnknkykhrkkaisuukbnx2;
    }

    private String zrnhtnknkykhrkkeirokbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKEIROKBNX2)
    public String getZrnhtnknkykhrkkeirokbnx2() {
        return zrnhtnknkykhrkkeirokbnx2;
    }

    public void setZrnhtnknkykhrkkeirokbnx2(String pZrnhtnknkykhrkkeirokbnx2) {
        zrnhtnknkykhrkkeirokbnx2 = pZrnhtnknkykhrkkeirokbnx2;
    }

    private String zrntnknuktkzngtkijyuhyjx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTNKNUKTKZNGTKIJYUHYJX2)
    public String getZrntnknuktkzngtkijyuhyjx2() {
        return zrntnknuktkzngtkijyuhyjx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknuktkzngtkijyuhyjx2(String pZrntnknuktkzngtkijyuhyjx2) {
        zrntnknuktkzngtkijyuhyjx2 = pZrntnknuktkzngtkijyuhyjx2;
    }

    private String zrnhtnknkykmrtisyuruikgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKMRTISYURUIKGUX2)
    public String getZrnhtnknkykmrtisyuruikgux2() {
        return zrnhtnknkykmrtisyuruikgux2;
    }

    public void setZrnhtnknkykmrtisyuruikgux2(String pZrnhtnknkykmrtisyuruikgux2) {
        zrnhtnknkykmrtisyuruikgux2 = pZrnhtnknkykmrtisyuruikgux2;
    }

    private String zrnhtnknkyksyonox3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSYONOX3)
    public String getZrnhtnknkyksyonox3() {
        return zrnhtnknkyksyonox3;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkyksyonox3(String pZrnhtnknkyksyonox3) {
        zrnhtnknkyksyonox3 = pZrnhtnknkyksyonox3;
    }

    private String zrnhtnknkykhknsyuruikgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNSYURUIKGUX3)
    public String getZrnhtnknkykhknsyuruikgux3() {
        return zrnhtnknkykhknsyuruikgux3;
    }

    public void setZrnhtnknkykhknsyuruikgux3(String pZrnhtnknkykhknsyuruikgux3) {
        zrnhtnknkykhknsyuruikgux3 = pZrnhtnknkykhknsyuruikgux3;
    }

    private String zrntenkanuketukeymdx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTENKANUKETUKEYMDX3)
    public String getZrntenkanuketukeymdx3() {
        return zrntenkanuketukeymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntenkanuketukeymdx3(String pZrntenkanuketukeymdx3) {
        zrntenkanuketukeymdx3 = pZrntenkanuketukeymdx3;
    }

    private String zrnhtnknkykkykymdx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKKYKYMDX3)
    public String getZrnhtnknkykkykymdx3() {
        return zrnhtnknkykkykymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknkykkykymdx3(String pZrnhtnknkykkykymdx3) {
        zrnhtnknkykkykymdx3 = pZrnhtnknkykkykymdx3;
    }

    private String zrnhtnknkykhknkknx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNKKNX3)
    public String getZrnhtnknkykhknkknx3() {
        return zrnhtnknkykhknkknx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykhknkknx3(String pZrnhtnknkykhknkknx3) {
        zrnhtnknkykhknkknx3 = pZrnhtnknkykhknkknx3;
    }

    private String zrnhtnknkykphrkkknx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKPHRKKKNX3)
    public String getZrnhtnknkykphrkkknx3() {
        return zrnhtnknkykphrkkknx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykphrkkknx3(String pZrnhtnknkykphrkkknx3) {
        zrnhtnknkykphrkkknx3 = pZrnhtnknkykphrkkknx3;
    }

    private String zrnhtnknkykhrkkaisuukbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKAISUUKBNX3)
    public String getZrnhtnknkykhrkkaisuukbnx3() {
        return zrnhtnknkykhrkkaisuukbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkkaisuukbnx3(String pZrnhtnknkykhrkkaisuukbnx3) {
        zrnhtnknkykhrkkaisuukbnx3 = pZrnhtnknkykhrkkaisuukbnx3;
    }

    private String zrnhtnknkykhrkkeirokbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKEIROKBNX3)
    public String getZrnhtnknkykhrkkeirokbnx3() {
        return zrnhtnknkykhrkkeirokbnx3;
    }

    public void setZrnhtnknkykhrkkeirokbnx3(String pZrnhtnknkykhrkkeirokbnx3) {
        zrnhtnknkykhrkkeirokbnx3 = pZrnhtnknkykhrkkeirokbnx3;
    }

    private String zrntnknuktkzngtkijyuhyjx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTNKNUKTKZNGTKIJYUHYJX3)
    public String getZrntnknuktkzngtkijyuhyjx3() {
        return zrntnknuktkzngtkijyuhyjx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknuktkzngtkijyuhyjx3(String pZrntnknuktkzngtkijyuhyjx3) {
        zrntnknuktkzngtkijyuhyjx3 = pZrntnknuktkzngtkijyuhyjx3;
    }

    private String zrnhtnknkykmrtisyuruikgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKMRTISYURUIKGUX3)
    public String getZrnhtnknkykmrtisyuruikgux3() {
        return zrnhtnknkykmrtisyuruikgux3;
    }

    public void setZrnhtnknkykmrtisyuruikgux3(String pZrnhtnknkykmrtisyuruikgux3) {
        zrnhtnknkykmrtisyuruikgux3 = pZrnhtnknkykmrtisyuruikgux3;
    }

    private String zrnhtnknkyksyonox4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSYONOX4)
    public String getZrnhtnknkyksyonox4() {
        return zrnhtnknkyksyonox4;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkyksyonox4(String pZrnhtnknkyksyonox4) {
        zrnhtnknkyksyonox4 = pZrnhtnknkyksyonox4;
    }

    private String zrnhtnknkykhknsyuruikgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNSYURUIKGUX4)
    public String getZrnhtnknkykhknsyuruikgux4() {
        return zrnhtnknkykhknsyuruikgux4;
    }

    public void setZrnhtnknkykhknsyuruikgux4(String pZrnhtnknkykhknsyuruikgux4) {
        zrnhtnknkykhknsyuruikgux4 = pZrnhtnknkykhknsyuruikgux4;
    }

    private String zrntenkanuketukeymdx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTENKANUKETUKEYMDX4)
    public String getZrntenkanuketukeymdx4() {
        return zrntenkanuketukeymdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntenkanuketukeymdx4(String pZrntenkanuketukeymdx4) {
        zrntenkanuketukeymdx4 = pZrntenkanuketukeymdx4;
    }

    private String zrnhtnknkykkykymdx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKKYKYMDX4)
    public String getZrnhtnknkykkykymdx4() {
        return zrnhtnknkykkykymdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknkykkykymdx4(String pZrnhtnknkykkykymdx4) {
        zrnhtnknkykkykymdx4 = pZrnhtnknkykkykymdx4;
    }

    private String zrnhtnknkykhknkknx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNKKNX4)
    public String getZrnhtnknkykhknkknx4() {
        return zrnhtnknkykhknkknx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykhknkknx4(String pZrnhtnknkykhknkknx4) {
        zrnhtnknkykhknkknx4 = pZrnhtnknkykhknkknx4;
    }

    private String zrnhtnknkykphrkkknx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKPHRKKKNX4)
    public String getZrnhtnknkykphrkkknx4() {
        return zrnhtnknkykphrkkknx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykphrkkknx4(String pZrnhtnknkykphrkkknx4) {
        zrnhtnknkykphrkkknx4 = pZrnhtnknkykphrkkknx4;
    }

    private String zrnhtnknkykhrkkaisuukbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKAISUUKBNX4)
    public String getZrnhtnknkykhrkkaisuukbnx4() {
        return zrnhtnknkykhrkkaisuukbnx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkkaisuukbnx4(String pZrnhtnknkykhrkkaisuukbnx4) {
        zrnhtnknkykhrkkaisuukbnx4 = pZrnhtnknkykhrkkaisuukbnx4;
    }

    private String zrnhtnknkykhrkkeirokbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKEIROKBNX4)
    public String getZrnhtnknkykhrkkeirokbnx4() {
        return zrnhtnknkykhrkkeirokbnx4;
    }

    public void setZrnhtnknkykhrkkeirokbnx4(String pZrnhtnknkykhrkkeirokbnx4) {
        zrnhtnknkykhrkkeirokbnx4 = pZrnhtnknkykhrkkeirokbnx4;
    }

    private String zrntnknuktkzngtkijyuhyjx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTNKNUKTKZNGTKIJYUHYJX4)
    public String getZrntnknuktkzngtkijyuhyjx4() {
        return zrntnknuktkzngtkijyuhyjx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknuktkzngtkijyuhyjx4(String pZrntnknuktkzngtkijyuhyjx4) {
        zrntnknuktkzngtkijyuhyjx4 = pZrntnknuktkzngtkijyuhyjx4;
    }

    private String zrnhtnknkykmrtisyuruikgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKMRTISYURUIKGUX4)
    public String getZrnhtnknkykmrtisyuruikgux4() {
        return zrnhtnknkykmrtisyuruikgux4;
    }

    public void setZrnhtnknkykmrtisyuruikgux4(String pZrnhtnknkykmrtisyuruikgux4) {
        zrnhtnknkykmrtisyuruikgux4 = pZrnhtnknkykmrtisyuruikgux4;
    }

    private String zrnhtnknkyksyonox5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSYONOX5)
    public String getZrnhtnknkyksyonox5() {
        return zrnhtnknkyksyonox5;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkyksyonox5(String pZrnhtnknkyksyonox5) {
        zrnhtnknkyksyonox5 = pZrnhtnknkyksyonox5;
    }

    private String zrnhtnknkykhknsyuruikgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNSYURUIKGUX5)
    public String getZrnhtnknkykhknsyuruikgux5() {
        return zrnhtnknkykhknsyuruikgux5;
    }

    public void setZrnhtnknkykhknsyuruikgux5(String pZrnhtnknkykhknsyuruikgux5) {
        zrnhtnknkykhknsyuruikgux5 = pZrnhtnknkykhknsyuruikgux5;
    }

    private String zrntenkanuketukeymdx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTENKANUKETUKEYMDX5)
    public String getZrntenkanuketukeymdx5() {
        return zrntenkanuketukeymdx5;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntenkanuketukeymdx5(String pZrntenkanuketukeymdx5) {
        zrntenkanuketukeymdx5 = pZrntenkanuketukeymdx5;
    }

    private String zrnhtnknkykkykymdx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKKYKYMDX5)
    public String getZrnhtnknkykkykymdx5() {
        return zrnhtnknkykkykymdx5;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknkykkykymdx5(String pZrnhtnknkykkykymdx5) {
        zrnhtnknkykkykymdx5 = pZrnhtnknkykkykymdx5;
    }

    private String zrnhtnknkykhknkknx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNKKNX5)
    public String getZrnhtnknkykhknkknx5() {
        return zrnhtnknkykhknkknx5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykhknkknx5(String pZrnhtnknkykhknkknx5) {
        zrnhtnknkykhknkknx5 = pZrnhtnknkykhknkknx5;
    }

    private String zrnhtnknkykphrkkknx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKPHRKKKNX5)
    public String getZrnhtnknkykphrkkknx5() {
        return zrnhtnknkykphrkkknx5;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykphrkkknx5(String pZrnhtnknkykphrkkknx5) {
        zrnhtnknkykphrkkknx5 = pZrnhtnknkykphrkkknx5;
    }

    private String zrnhtnknkykhrkkaisuukbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKAISUUKBNX5)
    public String getZrnhtnknkykhrkkaisuukbnx5() {
        return zrnhtnknkykhrkkaisuukbnx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkkaisuukbnx5(String pZrnhtnknkykhrkkaisuukbnx5) {
        zrnhtnknkykhrkkaisuukbnx5 = pZrnhtnknkykhrkkaisuukbnx5;
    }

    private String zrnhtnknkykhrkkeirokbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKEIROKBNX5)
    public String getZrnhtnknkykhrkkeirokbnx5() {
        return zrnhtnknkykhrkkeirokbnx5;
    }

    public void setZrnhtnknkykhrkkeirokbnx5(String pZrnhtnknkykhrkkeirokbnx5) {
        zrnhtnknkykhrkkeirokbnx5 = pZrnhtnknkykhrkkeirokbnx5;
    }

    private String zrntnknuktkzngtkijyuhyjx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTNKNUKTKZNGTKIJYUHYJX5)
    public String getZrntnknuktkzngtkijyuhyjx5() {
        return zrntnknuktkzngtkijyuhyjx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknuktkzngtkijyuhyjx5(String pZrntnknuktkzngtkijyuhyjx5) {
        zrntnknuktkzngtkijyuhyjx5 = pZrntnknuktkzngtkijyuhyjx5;
    }

    private String zrnhtnknkykmrtisyuruikgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKMRTISYURUIKGUX5)
    public String getZrnhtnknkykmrtisyuruikgux5() {
        return zrnhtnknkykmrtisyuruikgux5;
    }

    public void setZrnhtnknkykmrtisyuruikgux5(String pZrnhtnknkykmrtisyuruikgux5) {
        zrnhtnknkykmrtisyuruikgux5 = pZrnhtnknkykmrtisyuruikgux5;
    }

    private String zrnhtnknkyksyonox6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSYONOX6)
    public String getZrnhtnknkyksyonox6() {
        return zrnhtnknkyksyonox6;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnhtnknkyksyonox6(String pZrnhtnknkyksyonox6) {
        zrnhtnknkyksyonox6 = pZrnhtnknkyksyonox6;
    }

    private String zrnhtnknkykhknsyuruikgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNSYURUIKGUX6)
    public String getZrnhtnknkykhknsyuruikgux6() {
        return zrnhtnknkykhknsyuruikgux6;
    }

    public void setZrnhtnknkykhknsyuruikgux6(String pZrnhtnknkykhknsyuruikgux6) {
        zrnhtnknkykhknsyuruikgux6 = pZrnhtnknkykhknsyuruikgux6;
    }

    private String zrntenkanuketukeymdx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTENKANUKETUKEYMDX6)
    public String getZrntenkanuketukeymdx6() {
        return zrntenkanuketukeymdx6;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrntenkanuketukeymdx6(String pZrntenkanuketukeymdx6) {
        zrntenkanuketukeymdx6 = pZrntenkanuketukeymdx6;
    }

    private String zrnhtnknkykkykymdx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKKYKYMDX6)
    public String getZrnhtnknkykkykymdx6() {
        return zrnhtnknkykkykymdx6;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnhtnknkykkykymdx6(String pZrnhtnknkykkykymdx6) {
        zrnhtnknkykkykymdx6 = pZrnhtnknkykkykymdx6;
    }

    private String zrnhtnknkykhknkknx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHKNKKNX6)
    public String getZrnhtnknkykhknkknx6() {
        return zrnhtnknkykhknkknx6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykhknkknx6(String pZrnhtnknkykhknkknx6) {
        zrnhtnknkykhknkknx6 = pZrnhtnknkykhknkknx6;
    }

    private String zrnhtnknkykphrkkknx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKPHRKKKNX6)
    public String getZrnhtnknkykphrkkknx6() {
        return zrnhtnknkykphrkkknx6;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnhtnknkykphrkkknx6(String pZrnhtnknkykphrkkknx6) {
        zrnhtnknkykphrkkknx6 = pZrnhtnknkykphrkkknx6;
    }

    private String zrnhtnknkykhrkkaisuukbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKAISUUKBNX6)
    public String getZrnhtnknkykhrkkaisuukbnx6() {
        return zrnhtnknkykhrkkaisuukbnx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhrkkaisuukbnx6(String pZrnhtnknkykhrkkaisuukbnx6) {
        zrnhtnknkykhrkkaisuukbnx6 = pZrnhtnknkykhrkkaisuukbnx6;
    }

    private String zrnhtnknkykhrkkeirokbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHRKKEIROKBNX6)
    public String getZrnhtnknkykhrkkeirokbnx6() {
        return zrnhtnknkykhrkkeirokbnx6;
    }

    public void setZrnhtnknkykhrkkeirokbnx6(String pZrnhtnknkykhrkkeirokbnx6) {
        zrnhtnknkykhrkkeirokbnx6 = pZrnhtnknkykhrkkeirokbnx6;
    }

    private String zrntnknuktkzngtkijyuhyjx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTNKNUKTKZNGTKIJYUHYJX6)
    public String getZrntnknuktkzngtkijyuhyjx6() {
        return zrntnknuktkzngtkijyuhyjx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntnknuktkzngtkijyuhyjx6(String pZrntnknuktkzngtkijyuhyjx6) {
        zrntnknuktkzngtkijyuhyjx6 = pZrntnknuktkzngtkijyuhyjx6;
    }

    private String zrnhtnknkykmrtisyuruikgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKMRTISYURUIKGUX6)
    public String getZrnhtnknkykmrtisyuruikgux6() {
        return zrnhtnknkykmrtisyuruikgux6;
    }

    public void setZrnhtnknkykmrtisyuruikgux6(String pZrnhtnknkykmrtisyuruikgux6) {
        zrnhtnknkykmrtisyuruikgux6 = pZrnhtnknkykmrtisyuruikgux6;
    }

    private Long zrngukihtnknkykkhns;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKIHTNKNKYKKHNS)
    public Long getZrngukihtnknkykkhns() {
        return zrngukihtnknkykkhns;
    }

    public void setZrngukihtnknkykkhns(Long pZrngukihtnknkykkhns) {
        zrngukihtnknkykkhns = pZrngukihtnknkykkhns;
    }

    private Long zrngukihtnknkyksbus;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKIHTNKNKYKSBUS)
    public Long getZrngukihtnknkyksbus() {
        return zrngukihtnknkyksbus;
    }

    public void setZrngukihtnknkyksbus(Long pZrngukihtnknkyksbus) {
        zrngukihtnknkyksbus = pZrngukihtnknkyksbus;
    }

    private Long zrngukihtnknkykhntiyup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKIHTNKNKYKHNTIYUP)
    public Long getZrngukihtnknkykhntiyup() {
        return zrngukihtnknkykhntiyup;
    }

    public void setZrngukihtnknkykhntiyup(Long pZrngukihtnknkykhntiyup) {
        zrngukihtnknkykhntiyup = pZrngukihtnknkykhntiyup;
    }

    private Long zrngukihtnknkyksigwrmstkyks;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKIHTNKNKYKSIGWRMSTKYKS)
    public Long getZrngukihtnknkyksigwrmstkyks() {
        return zrngukihtnknkyksigwrmstkyks;
    }

    public void setZrngukihtnknkyksigwrmstkyks(Long pZrngukihtnknkyksigwrmstkyks) {
        zrngukihtnknkyksigwrmstkyks = pZrngukihtnknkyksigwrmstkyks;
    }

    private Long zrngukihtnknkyksyugitkyks;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKIHTNKNKYKSYUGITKYKS)
    public Long getZrngukihtnknkyksyugitkyks() {
        return zrngukihtnknkyksyugitkyks;
    }

    public void setZrngukihtnknkyksyugitkyks(Long pZrngukihtnknkyksyugitkyks) {
        zrngukihtnknkyksyugitkyks = pZrngukihtnknkyksyugitkyks;
    }

    private Integer zrngukihtnknsignyintkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKIHTNKNSIGNYINTKYKNTGK)
    public Integer getZrngukihtnknsignyintkykntgk() {
        return zrngukihtnknsignyintkykntgk;
    }

    public void setZrngukihtnknsignyintkykntgk(Integer pZrngukihtnknsignyintkykntgk) {
        zrngukihtnknsignyintkykntgk = pZrngukihtnknsignyintkykntgk;
    }

    private Integer zrngukihtnknknkutkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKIHTNKNKNKUTKYKNTGK)
    public Integer getZrngukihtnknknkutkykntgk() {
        return zrngukihtnknknkutkykntgk;
    }

    public void setZrngukihtnknknkutkykntgk(Integer pZrngukihtnknknkutkykntgk) {
        zrngukihtnknknkutkykntgk = pZrngukihtnknknkutkykntgk;
    }

    private Long zrngukihtnknkykmods;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKIHTNKNKYKMODS)
    public Long getZrngukihtnknkykmods() {
        return zrngukihtnknkykmods;
    }

    public void setZrngukihtnknkykmods(Long pZrngukihtnknkykmods) {
        zrngukihtnknkykmods = pZrngukihtnknkykmods;
    }

    private Long zrngoukeitenkankakaku;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGOUKEITENKANKAKAKU)
    public Long getZrngoukeitenkankakaku() {
        return zrngoukeitenkankakaku;
    }

    public void setZrngoukeitenkankakaku(Long pZrngoukeitenkankakaku) {
        zrngoukeitenkankakaku = pZrngoukeitenkankakaku;
    }

    private Long zrngukitnknjsknnjynbkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKITNKNJSKNNJYNBKN)
    public Long getZrngukitnknjsknnjynbkn() {
        return zrngukitnknjsknnjynbkn;
    }

    public void setZrngukitnknjsknnjynbkn(Long pZrngukitnknjsknnjynbkn) {
        zrngukitnknjsknnjynbkn = pZrngukitnknjsknnjynbkn;
    }

    private Long zrngukitnknsisnkstkkngk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKITNKNSISNKSTKKNGK)
    public Long getZrngukitnknsisnkstkkngk() {
        return zrngukitnknsisnkstkkngk;
    }

    public void setZrngukitnknsisnkstkkngk(Long pZrngukitnknsisnkstkkngk) {
        zrngukitnknsisnkstkkngk = pZrngukitnknsisnkstkkngk;
    }

    private Long zrngukitnknsisnttkekngk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKITNKNSISNTTKEKNGK)
    public Long getZrngukitnknsisnttkekngk() {
        return zrngukitnknsisnttkekngk;
    }

    public void setZrngukitnknsisnttkekngk(Long pZrngukitnknsisnttkekngk) {
        zrngukitnknsisnttkekngk = pZrngukitnknsisnttkekngk;
    }

    private Long zrngoukeitenkanseisand;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGOUKEITENKANSEISAND)
    public Long getZrngoukeitenkanseisand() {
        return zrngoukeitenkanseisand;
    }

    public void setZrngoukeitenkanseisand(Long pZrngoukeitenkanseisand) {
        zrngoukeitenkanseisand = pZrngoukeitenkanseisand;
    }

    private Long zrngukitnknsisnmkikp;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKITNKNSISNMKIKP)
    public Long getZrngukitnknsisnmkikp() {
        return zrngukitnknsisnmkikp;
    }

    public void setZrngukitnknsisnmkikp(Long pZrngukitnknsisnmkikp) {
        zrngukitnknsisnmkikp = pZrngukitnknsisnmkikp;
    }

    private Long zrngukitnknsisnsntkngk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKITNKNSISNSNTKNGK)
    public Long getZrngukitnknsisnsntkngk() {
        return zrngukitnknsisnsntkngk;
    }

    public void setZrngukitnknsisnsntkngk(Long pZrngukitnknsisnsntkngk) {
        zrngukitnknsisnsntkngk = pZrngukitnknsisnsntkngk;
    }

    private Long zrngukitnknkhnbbnkiykkujygk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKITNKNKHNBBNKIYKKUJYGK)
    public Long getZrngukitnknkhnbbnkiykkujygk() {
        return zrngukitnknkhnbbnkiykkujygk;
    }

    public void setZrngukitnknkhnbbnkiykkujygk(Long pZrngukitnknkhnbbnkiykkujygk) {
        zrngukitnknkhnbbnkiykkujygk = pZrngukitnknkhnbbnkiykkujygk;
    }

    private Long zrngukitnkntikbbnkiykkujygk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKITNKNTIKBBNKIYKKUJYGK)
    public Long getZrngukitnkntikbbnkiykkujygk() {
        return zrngukitnkntikbbnkiykkujygk;
    }

    public void setZrngukitnkntikbbnkiykkujygk(Long pZrngukitnkntikbbnkiykkujygk) {
        zrngukitnkntikbbnkiykkujygk = pZrngukitnkntikbbnkiykkujygk;
    }

    private Long zrngukitnknitjbrtiks;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNGUKITNKNITJBRTIKS)
    public Long getZrngukitnknitjbrtiks() {
        return zrngukitnknitjbrtiks;
    }

    public void setZrngukitnknitjbrtiks(Long pZrngukitnknitjbrtiks) {
        zrngukitnknitjbrtiks = pZrngukitnknitjbrtiks;
    }

    private String zrnsethokenno;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETHOKENNO)
    public String getZrnsethokenno() {
        return zrnsethokenno;
    }

    @Padding(mode = "left", padChar = '0', length = 9)
    public void setZrnsethokenno(String pZrnsethokenno) {
        zrnsethokenno = pZrnsethokenno;
    }

    private String zrnsckbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSCKBN)
    public String getZrnsckbn() {
        return zrnsckbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsckbn(String pZrnsckbn) {
        zrnsckbn = pZrnsckbn;
    }

    private String zrnenjyosyacd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNENJYOSYACD)
    public String getZrnenjyosyacd() {
        return zrnenjyosyacd;
    }

    public void setZrnenjyosyacd(String pZrnenjyosyacd) {
        zrnenjyosyacd = pZrnenjyosyacd;
    }

    private Long zrnnaibuwarimodosigaku;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNNAIBUWARIMODOSIGAKU)
    public Long getZrnnaibuwarimodosigaku() {
        return zrnnaibuwarimodosigaku;
    }

    public void setZrnnaibuwarimodosigaku(Long pZrnnaibuwarimodosigaku) {
        zrnnaibuwarimodosigaku = pZrnnaibuwarimodosigaku;
    }

    private String zrnkeiyakukakuninsyuruikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKEIYAKUKAKUNINSYURUIKBN)
    public String getZrnkeiyakukakuninsyuruikbn() {
        return zrnkeiyakukakuninsyuruikbn;
    }

    public void setZrnkeiyakukakuninsyuruikbn(String pZrnkeiyakukakuninsyuruikbn) {
        zrnkeiyakukakuninsyuruikbn = pZrnkeiyakukakuninsyuruikbn;
    }

    private String zrnsoujikeitenkanhyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSOUJIKEITENKANHYOUJI)
    public String getZrnsoujikeitenkanhyouji() {
        return zrnsoujikeitenkanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsoujikeitenkanhyouji(String pZrnsoujikeitenkanhyouji) {
        zrnsoujikeitenkanhyouji = pZrnsoujikeitenkanhyouji;
    }

    private String zrntenkanjisketteihouhoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTENKANJISKETTEIHOUHOUKBN)
    public String getZrntenkanjisketteihouhoukbn() {
        return zrntenkanjisketteihouhoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntenkanjisketteihouhoukbn(String pZrntenkanjisketteihouhoukbn) {
        zrntenkanjisketteihouhoukbn = pZrntenkanjisketteihouhoukbn;
    }

    private String zrnkeikanensuukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKEIKANENSUUKBN)
    public String getZrnkeikanensuukbn() {
        return zrnkeikanensuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkeikanensuukbn(String pZrnkeikanensuukbn) {
        zrnkeikanensuukbn = pZrnkeikanensuukbn;
    }

    private String zrnhtnknkykhhknsytisyukbnx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHHKNSYTISYUKBNX1)
    public String getZrnhtnknkykhhknsytisyukbnx1() {
        return zrnhtnknkykhhknsytisyukbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhhknsytisyukbnx1(String pZrnhtnknkykhhknsytisyukbnx1) {
        zrnhtnknkykhhknsytisyukbnx1 = pZrnhtnknkykhhknsytisyukbnx1;
    }

    private String zrnhtnknkykhhknsytisyukbnx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHHKNSYTISYUKBNX2)
    public String getZrnhtnknkykhhknsytisyukbnx2() {
        return zrnhtnknkykhhknsytisyukbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhhknsytisyukbnx2(String pZrnhtnknkykhhknsytisyukbnx2) {
        zrnhtnknkykhhknsytisyukbnx2 = pZrnhtnknkykhhknsytisyukbnx2;
    }

    private String zrnhtnknkykhhknsytisyukbnx3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHHKNSYTISYUKBNX3)
    public String getZrnhtnknkykhhknsytisyukbnx3() {
        return zrnhtnknkykhhknsytisyukbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhhknsytisyukbnx3(String pZrnhtnknkykhhknsytisyukbnx3) {
        zrnhtnknkykhhknsytisyukbnx3 = pZrnhtnknkykhhknsytisyukbnx3;
    }

    private String zrnhtnknkykhhknsytisyukbnx4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHHKNSYTISYUKBNX4)
    public String getZrnhtnknkykhhknsytisyukbnx4() {
        return zrnhtnknkykhhknsytisyukbnx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhhknsytisyukbnx4(String pZrnhtnknkykhhknsytisyukbnx4) {
        zrnhtnknkykhhknsytisyukbnx4 = pZrnhtnknkykhhknsytisyukbnx4;
    }

    private String zrnhtnknkykhhknsytisyukbnx5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHHKNSYTISYUKBNX5)
    public String getZrnhtnknkykhhknsytisyukbnx5() {
        return zrnhtnknkykhhknsytisyukbnx5;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhhknsytisyukbnx5(String pZrnhtnknkykhhknsytisyukbnx5) {
        zrnhtnknkykhhknsytisyukbnx5 = pZrnhtnknkykhhknsytisyukbnx5;
    }

    private String zrnhtnknkykhhknsytisyukbnx6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKHHKNSYTISYUKBNX6)
    public String getZrnhtnknkykhhknsytisyukbnx6() {
        return zrnhtnknkykhhknsytisyukbnx6;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykhhknsytisyukbnx6(String pZrnhtnknkykhhknsytisyukbnx6) {
        zrnhtnknkykhhknsytisyukbnx6 = pZrnhtnknkykhhknsytisyukbnx6;
    }

    private Long zrnkktijgukipbbntnkns;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKKTIJGUKIPBBNTNKNS)
    public Long getZrnkktijgukipbbntnkns() {
        return zrnkktijgukipbbntnkns;
    }

    public void setZrnkktijgukipbbntnkns(Long pZrnkktijgukipbbntnkns) {
        zrnkktijgukipbbntnkns = pZrnkktijgukipbbntnkns;
    }

    private Long zrnsyonendosyokaip;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYONENDOSYOKAIP)
    public Long getZrnsyonendosyokaip() {
        return zrnsyonendosyokaip;
    }

    public void setZrnsyonendosyokaip(Long pZrnsyonendosyokaip) {
        zrnsyonendosyokaip = pZrnsyonendosyokaip;
    }

    private Long zrnsyonendo2kaimeikoup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYONENDO2KAIMEIKOUP)
    public Long getZrnsyonendo2kaimeikoup() {
        return zrnsyonendo2kaimeikoup;
    }

    public void setZrnsyonendo2kaimeikoup(Long pZrnsyonendo2kaimeikoup) {
        zrnsyonendo2kaimeikoup = pZrnsyonendo2kaimeikoup;
    }

    private Long zrnjinendoikoup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNJINENDOIKOUP)
    public Long getZrnjinendoikoup() {
        return zrnjinendoikoup;
    }

    public void setZrnjinendoikoup(Long pZrnjinendoikoup) {
        zrnjinendoikoup = pZrnjinendoikoup;
    }

    private Integer zrnsyukeiyakusikyuukisogaku;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYUKEIYAKUSIKYUUKISOGAKU)
    public Integer getZrnsyukeiyakusikyuukisogaku() {
        return zrnsyukeiyakusikyuukisogaku;
    }

    public void setZrnsyukeiyakusikyuukisogaku(Integer pZrnsyukeiyakusikyuukisogaku) {
        zrnsyukeiyakusikyuukisogaku = pZrnsyukeiyakusikyuukisogaku;
    }

    private Integer zrnsykyknenhantatskyuksgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYKYKNENHANTATSKYUKSGK)
    public Integer getZrnsykyknenhantatskyuksgk() {
        return zrnsykyknenhantatskyuksgk;
    }

    public void setZrnsykyknenhantatskyuksgk(Integer pZrnsykyknenhantatskyuksgk) {
        zrnsykyknenhantatskyuksgk = pZrnsykyknenhantatskyuksgk;
    }

    private Integer zrnmaruteisikyuukisogaku;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMARUTEISIKYUUKISOGAKU)
    public Integer getZrnmaruteisikyuukisogaku() {
        return zrnmaruteisikyuukisogaku;
    }

    public void setZrnmaruteisikyuukisogaku(Integer pZrnmaruteisikyuukisogaku) {
        zrnmaruteisikyuukisogaku = pZrnmaruteisikyuukisogaku;
    }

    private Integer zrnitjbrzugkskyuksgkx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITJBRZUGKSKYUKSGKX1)
    public Integer getZrnitjbrzugkskyuksgkx1() {
        return zrnitjbrzugkskyuksgkx1;
    }

    public void setZrnitjbrzugkskyuksgkx1(Integer pZrnitjbrzugkskyuksgkx1) {
        zrnitjbrzugkskyuksgkx1 = pZrnitjbrzugkskyuksgkx1;
    }

    private Integer zrnitjbrzugkskyuksgkx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITJBRZUGKSKYUKSGKX2)
    public Integer getZrnitjbrzugkskyuksgkx2() {
        return zrnitjbrzugkskyuksgkx2;
    }

    public void setZrnitjbrzugkskyuksgkx2(Integer pZrnitjbrzugkskyuksgkx2) {
        zrnitjbrzugkskyuksgkx2 = pZrnitjbrzugkskyuksgkx2;
    }

    private Integer zrnitjbrzgknnhntatskyksgkx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITJBRZGKNNHNTATSKYKSGKX1)
    public Integer getZrnitjbrzgknnhntatskyksgkx1() {
        return zrnitjbrzgknnhntatskyksgkx1;
    }

    public void setZrnitjbrzgknnhntatskyksgkx1(Integer pZrnitjbrzgknnhntatskyksgkx1) {
        zrnitjbrzgknnhntatskyksgkx1 = pZrnitjbrzgknnhntatskyksgkx1;
    }

    private Integer zrnitjbrzgknnhntatskyksgkx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITJBRZGKNNHNTATSKYKSGKX2)
    public Integer getZrnitjbrzgknnhntatskyksgkx2() {
        return zrnitjbrzgknnhntatskyksgkx2;
    }

    public void setZrnitjbrzgknnhntatskyksgkx2(Integer pZrnitjbrzgknnhntatskyksgkx2) {
        zrnitjbrzgknnhntatskyksgkx2 = pZrnitjbrzgknnhntatskyksgkx2;
    }

    private Integer zrnkzkmrtiskyuksgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKZKMRTISKYUKSGK)
    public Integer getZrnkzkmrtiskyuksgk() {
        return zrnkzkmrtiskyuksgk;
    }

    public void setZrnkzkmrtiskyuksgk(Integer pZrnkzkmrtiskyuksgk) {
        zrnkzkmrtiskyuksgk = pZrnkzkmrtiskyuksgk;
    }

    private Integer zrnitibitjbrskyuksgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITIBITJBRSKYUKSGK)
    public Integer getZrnitibitjbrskyuksgk() {
        return zrnitibitjbrskyuksgk;
    }

    public void setZrnitibitjbrskyuksgk(Integer pZrnitibitjbrskyuksgk) {
        zrnitibitjbrskyuksgk = pZrnitibitjbrskyuksgk;
    }

    private Integer zrnitbitjbrnnhntatskyuksgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITBITJBRNNHNTATSKYUKSGK)
    public Integer getZrnitbitjbrnnhntatskyuksgk() {
        return zrnitbitjbrnnhntatskyuksgk;
    }

    public void setZrnitbitjbrnnhntatskyuksgk(Integer pZrnitbitjbrnnhntatskyuksgk) {
        zrnitbitjbrnnhntatskyuksgk = pZrnitbitjbrnnhntatskyuksgk;
    }

    private Integer zrnsykykksnbsyutat;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYKYKKSNBSYUTAT)
    public Integer getZrnsykykksnbsyutat() {
        return zrnsykykksnbsyutat;
    }

    public void setZrnsykykksnbsyutat(Integer pZrnsykykksnbsyutat) {
        zrnsykykksnbsyutat = pZrnsykykksnbsyutat;
    }

    private Integer zrnitjbrzugkksnbsyutatx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITJBRZUGKKSNBSYUTATX1)
    public Integer getZrnitjbrzugkksnbsyutatx1() {
        return zrnitjbrzugkksnbsyutatx1;
    }

    public void setZrnitjbrzugkksnbsyutatx1(Integer pZrnitjbrzugkksnbsyutatx1) {
        zrnitjbrzugkksnbsyutatx1 = pZrnitjbrzugkksnbsyutatx1;
    }

    private Integer zrnitjbrzugkksnbsyutatx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITJBRZUGKKSNBSYUTATX2)
    public Integer getZrnitjbrzugkksnbsyutatx2() {
        return zrnitjbrzugkksnbsyutatx2;
    }

    public void setZrnitjbrzugkksnbsyutatx2(Integer pZrnitjbrzugkksnbsyutatx2) {
        zrnitjbrzugkksnbsyutatx2 = pZrnitjbrzugkksnbsyutatx2;
    }

    private Integer zrnitibitjbrksnbsyutat;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITIBITJBRKSNBSYUTAT)
    public Integer getZrnitibitjbrksnbsyutat() {
        return zrnitibitjbrksnbsyutat;
    }

    public void setZrnitibitjbrksnbsyutat(Integer pZrnitibitjbrksnbsyutat) {
        zrnitibitjbrksnbsyutat = pZrnitibitjbrksnbsyutat;
    }

    private BizNumber zrnjyunkensuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNJYUNKENSUU)
    public BizNumber getZrnjyunkensuu() {
        return zrnjyunkensuu;
    }

    public void setZrnjyunkensuu(BizNumber pZrnjyunkensuu) {
        zrnjyunkensuu = pZrnjyunkensuu;
    }

    private BizNumber zrnkansankensuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKANSANKENSUU)
    public BizNumber getZrnkansankensuu() {
        return zrnkansankensuu;
    }

    public void setZrnkansankensuu(BizNumber pZrnkansankensuu) {
        zrnkansankensuu = pZrnkansankensuu;
    }

    private String zrnitibuitijibaraikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITIBUITIJIBARAIKIKAN)
    public String getZrnitibuitijibaraikikan() {
        return zrnitibuitijibaraikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnitibuitijibaraikikan(String pZrnitibuitijibaraikikan) {
        zrnitibuitijibaraikikan = pZrnitibuitijibaraikikan;
    }

    private Long zrnitibuitijibarais;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITIBUITIJIBARAIS)
    public Long getZrnitibuitijibarais() {
        return zrnitibuitijibarais;
    }

    public void setZrnitibuitijibarais(Long pZrnitibuitijibarais) {
        zrnitibuitijibarais = pZrnitibuitijibarais;
    }

    private Long zrnitibuitijibaraip;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITIBUITIJIBARAIP)
    public Long getZrnitibuitijibaraip() {
        return zrnitibuitijibaraip;
    }

    public void setZrnitibuitijibaraip(Long pZrnitibuitijibaraip) {
        zrnitibuitijibaraip = pZrnitibuitijibaraip;
    }

    private String zrnitibitjbrsdtpdtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITIBITJBRSDTPDTKBN)
    public String getZrnitibitjbrsdtpdtkbn() {
        return zrnitibitjbrsdtpdtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnitibitjbrsdtpdtkbn(String pZrnitibitjbrsdtpdtkbn) {
        zrnitibitjbrsdtpdtkbn = pZrnitibitjbrsdtpdtkbn;
    }

    private Long zrnitibuitijibaraisyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITIBUITIJIBARAISYUUSEIS)
    public Long getZrnitibuitijibaraisyuuseis() {
        return zrnitibuitijibaraisyuuseis;
    }

    public void setZrnitibuitijibaraisyuuseis(Long pZrnitibuitijibaraisyuuseis) {
        zrnitibuitijibaraisyuuseis = pZrnitibuitijibaraisyuuseis;
    }

    private String zrnitibitjbrmodsskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNITIBITJBRMODSSKGNHYJ)
    public String getZrnitibitjbrmodsskgnhyj() {
        return zrnitibitjbrmodsskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnitibitjbrmodsskgnhyj(String pZrnitibitjbrmodsskgnhyj) {
        zrnitibitjbrmodsskgnhyj = pZrnitibitjbrmodsskgnhyj;
    }

    private String zrnsuuriyousyoriym;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSUURIYOUSYORIYM)
    public String getZrnsuuriyousyoriym() {
        return zrnsuuriyousyoriym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZrnsuuriyousyoriym(String pZrnsuuriyousyoriym) {
        zrnsuuriyousyoriym = pZrnsuuriyousyoriym;
    }

    private String zrnsyosinsinsahouhoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSYOSINSINSAHOUHOUKBN)
    public String getZrnsyosinsinsahouhoukbn() {
        return zrnsyosinsinsahouhoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsyosinsinsahouhoukbn(String pZrnsyosinsinsahouhoukbn) {
        zrnsyosinsinsahouhoukbn = pZrnsyosinsinsahouhoukbn;
    }

    private String zrnsaisinsinsahouhoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSAISINSINSAHOUHOUKBN)
    public String getZrnsaisinsinsahouhoukbn() {
        return zrnsaisinsinsahouhoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsaisinsinsahouhoukbn(String pZrnsaisinsinsahouhoukbn) {
        zrnsaisinsinsahouhoukbn = pZrnsaisinsinsahouhoukbn;
    }

    private String zrnseizonmrtisyuruikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIZONMRTISYURUIKGU)
    public String getZrnseizonmrtisyuruikgu() {
        return zrnseizonmrtisyuruikgu;
    }

    public void setZrnseizonmrtisyuruikgu(String pZrnseizonmrtisyuruikgu) {
        zrnseizonmrtisyuruikgu = pZrnseizonmrtisyuruikgu;
    }

    private String zrnseizonmaruteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIZONMARUTEIKIKAN)
    public String getZrnseizonmaruteikikan() {
        return zrnseizonmaruteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseizonmaruteikikan(String pZrnseizonmaruteikikan) {
        zrnseizonmaruteikikan = pZrnseizonmaruteikikan;
    }

    private String zrnseizonmrtiphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIZONMRTIPHRKKKN)
    public String getZrnseizonmrtiphrkkkn() {
        return zrnseizonmrtiphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnseizonmrtiphrkkkn(String pZrnseizonmrtiphrkkkn) {
        zrnseizonmrtiphrkkkn = pZrnseizonmrtiphrkkkn;
    }

    private Long zrnseizonmaruteis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIZONMARUTEIS)
    public Long getZrnseizonmaruteis() {
        return zrnseizonmaruteis;
    }

    public void setZrnseizonmaruteis(Long pZrnseizonmaruteis) {
        zrnseizonmaruteis = pZrnseizonmaruteis;
    }

    private Long zrnseizonmaruteip;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIZONMARUTEIP)
    public Long getZrnseizonmaruteip() {
        return zrnseizonmaruteip;
    }

    public void setZrnseizonmaruteip(Long pZrnseizonmaruteip) {
        zrnseizonmaruteip = pZrnseizonmaruteip;
    }

    private Long zrnseizonmaruteisyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIZONMARUTEISYUUSEIS)
    public Long getZrnseizonmaruteisyuuseis() {
        return zrnseizonmaruteisyuuseis;
    }

    public void setZrnseizonmaruteisyuuseis(Long pZrnseizonmaruteisyuuseis) {
        zrnseizonmaruteisyuuseis = pZrnseizonmaruteisyuuseis;
    }

    private String zrnseizonmrtimodsskgnhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIZONMRTIMODSSKGNHYJ)
    public String getZrnseizonmrtimodsskgnhyj() {
        return zrnseizonmrtimodsskgnhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnseizonmrtimodsskgnhyj(String pZrnseizonmrtimodsskgnhyj) {
        zrnseizonmrtimodsskgnhyj = pZrnseizonmrtimodsskgnhyj;
    }

    private String zrnsiznmrtitkjyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIZNMRTITKJYUKBN)
    public String getZrnsiznmrtitkjyukbn() {
        return zrnsiznmrtitkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsiznmrtitkjyukbn(String pZrnsiznmrtitkjyukbn) {
        zrnsiznmrtitkjyukbn = pZrnsiznmrtitkjyukbn;
    }

    private String zrnsiznmrtitkjyuskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIZNMRTITKJYUSKGNKKN)
    public String getZrnsiznmrtitkjyuskgnkkn() {
        return zrnsiznmrtitkjyuskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiznmrtitkjyuskgnkkn(String pZrnsiznmrtitkjyuskgnkkn) {
        zrnsiznmrtitkjyuskgnkkn = pZrnsiznmrtitkjyuskgnkkn;
    }

    private Integer zrnsiznmrtitkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIZNMRTITKJYURYUMSHYUTN)
    public Integer getZrnsiznmrtitkjyuryumshyutn() {
        return zrnsiznmrtitkjyuryumshyutn;
    }

    public void setZrnsiznmrtitkjyuryumshyutn(Integer pZrnsiznmrtitkjyuryumshyutn) {
        zrnsiznmrtitkjyuryumshyutn = pZrnsiznmrtitkjyuryumshyutn;
    }

    private Long zrnsiznmrtitkjyup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIZNMRTITKJYUP)
    public Long getZrnsiznmrtitkjyup() {
        return zrnsiznmrtitkjyup;
    }

    public void setZrnsiznmrtitkjyup(Long pZrnsiznmrtitkjyup) {
        zrnsiznmrtitkjyup = pZrnsiznmrtitkjyup;
    }

    private Integer zrnsiznmrtiskyuksgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIZNMRTISKYUKSGK)
    public Integer getZrnsiznmrtiskyuksgk() {
        return zrnsiznmrtiskyuksgk;
    }

    public void setZrnsiznmrtiskyuksgk(Integer pZrnsiznmrtiskyuksgk) {
        zrnsiznmrtiskyuksgk = pZrnsiznmrtiskyuksgk;
    }

    private String zrnhtnknkyksiznmrtsyrikgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSIZNMRTSYRIKGUX1)
    public String getZrnhtnknkyksiznmrtsyrikgux1() {
        return zrnhtnknkyksiznmrtsyrikgux1;
    }

    public void setZrnhtnknkyksiznmrtsyrikgux1(String pZrnhtnknkyksiznmrtsyrikgux1) {
        zrnhtnknkyksiznmrtsyrikgux1 = pZrnhtnknkyksiznmrtsyrikgux1;
    }

    private String zrnhtnknkyksiznmrtsyrikgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSIZNMRTSYRIKGUX2)
    public String getZrnhtnknkyksiznmrtsyrikgux2() {
        return zrnhtnknkyksiznmrtsyrikgux2;
    }

    public void setZrnhtnknkyksiznmrtsyrikgux2(String pZrnhtnknkyksiznmrtsyrikgux2) {
        zrnhtnknkyksiznmrtsyrikgux2 = pZrnhtnknkyksiznmrtsyrikgux2;
    }

    private String zrnhtnknkyksiznmrtsyrikgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSIZNMRTSYRIKGUX3)
    public String getZrnhtnknkyksiznmrtsyrikgux3() {
        return zrnhtnknkyksiznmrtsyrikgux3;
    }

    public void setZrnhtnknkyksiznmrtsyrikgux3(String pZrnhtnknkyksiznmrtsyrikgux3) {
        zrnhtnknkyksiznmrtsyrikgux3 = pZrnhtnknkyksiznmrtsyrikgux3;
    }

    private String zrnhtnknkyksiznmrtsyrikgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSIZNMRTSYRIKGUX4)
    public String getZrnhtnknkyksiznmrtsyrikgux4() {
        return zrnhtnknkyksiznmrtsyrikgux4;
    }

    public void setZrnhtnknkyksiznmrtsyrikgux4(String pZrnhtnknkyksiznmrtsyrikgux4) {
        zrnhtnknkyksiznmrtsyrikgux4 = pZrnhtnknkyksiznmrtsyrikgux4;
    }

    private String zrnhtnknkyksiznmrtsyrikgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSIZNMRTSYRIKGUX5)
    public String getZrnhtnknkyksiznmrtsyrikgux5() {
        return zrnhtnknkyksiznmrtsyrikgux5;
    }

    public void setZrnhtnknkyksiznmrtsyrikgux5(String pZrnhtnknkyksiznmrtsyrikgux5) {
        zrnhtnknkyksiznmrtsyrikgux5 = pZrnhtnknkyksiznmrtsyrikgux5;
    }

    private String zrnhtnknkyksiznmrtsyrikgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKSIZNMRTSYRIKGUX6)
    public String getZrnhtnknkyksiznmrtsyrikgux6() {
        return zrnhtnknkyksiznmrtsyrikgux6;
    }

    public void setZrnhtnknkyksiznmrtsyrikgux6(String pZrnhtnknkyksiznmrtsyrikgux6) {
        zrnhtnknkyksiznmrtsyrikgux6 = pZrnhtnknkyksiznmrtsyrikgux6;
    }

    private String zrnsuryusiznmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSURYUSIZNMRTIPWRBKKBN)
    public String getZrnsuryusiznmrtipwrbkkbn() {
        return zrnsuryusiznmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuryusiznmrtipwrbkkbn(String pZrnsuryusiznmrtipwrbkkbn) {
        zrnsuryusiznmrtipwrbkkbn = pZrnsuryusiznmrtipwrbkkbn;
    }

    private String zrnsiznmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIZNMRTIPWRBKKBN)
    public String getZrnsiznmrtipwrbkkbn() {
        return zrnsiznmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiznmrtipwrbkkbn(String pZrnsiznmrtipwrbkkbn) {
        zrnsiznmrtipwrbkkbn = pZrnsiznmrtipwrbkkbn;
    }

    private String zrnsiznmrtitnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSIZNMRTITNKNYUGUKBN)
    public String getZrnsiznmrtitnknyugukbn() {
        return zrnsiznmrtitnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsiznmrtitnknyugukbn(String pZrnsiznmrtitnknyugukbn) {
        zrnsiznmrtitnknyugukbn = pZrnsiznmrtitnknyugukbn;
    }

    private String zrnseizonmrtikgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSEIZONMRTIKGUSDKBN)
    public String getZrnseizonmrtikgusdkbn() {
        return zrnseizonmrtikgusdkbn;
    }

    public void setZrnseizonmrtikgusdkbn(String pZrnseizonmrtikgusdkbn) {
        zrnseizonmrtikgusdkbn = pZrnseizonmrtikgusdkbn;
    }

    private String zrnyobiv1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV1)
    public String getZrnyobiv1() {
        return zrnyobiv1;
    }

    public void setZrnyobiv1(String pZrnyobiv1) {
        zrnyobiv1 = pZrnyobiv1;
    }

    private String zrndai2hihokensyamei;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2HIHOKENSYAMEI)
    public String getZrndai2hihokensyamei() {
        return zrndai2hihokensyamei;
    }

    public void setZrndai2hihokensyamei(String pZrndai2hihokensyamei) {
        zrndai2hihokensyamei = pZrndai2hihokensyamei;
    }

    private String zrndai2kanjihihokensyamei;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2KANJIHIHOKENSYAMEI)
    public String getZrndai2kanjihihokensyamei() {
        return zrndai2kanjihihokensyamei;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2kanjihihokensyamei(String pZrndai2kanjihihokensyamei) {
        zrndai2kanjihihokensyamei = pZrndai2kanjihihokensyamei;
    }

    private String zrndai2hihokensyaseiymd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2HIHOKENSYASEIYMD)
    public String getZrndai2hihokensyaseiymd() {
        return zrndai2hihokensyaseiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrndai2hihokensyaseiymd(String pZrndai2hihokensyaseiymd) {
        zrndai2hihokensyaseiymd = pZrndai2hihokensyaseiymd;
    }

    private String zrndai2hihokensyaseibetukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2HIHOKENSYASEIBETUKBN)
    public String getZrndai2hihokensyaseibetukbn() {
        return zrndai2hihokensyaseibetukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2hihokensyaseibetukbn(String pZrndai2hihokensyaseibetukbn) {
        zrndai2hihokensyaseibetukbn = pZrndai2hihokensyaseibetukbn;
    }

    private String zrndai2hihknsyahnskhkncd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2HIHKNSYAHNSKHKNCD)
    public String getZrndai2hihknsyahnskhkncd() {
        return zrndai2hihknsyahnskhkncd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2hihknsyahnskhkncd(String pZrndai2hihknsyahnskhkncd) {
        zrndai2hihknsyahnskhkncd = pZrndai2hihknsyahnskhkncd;
    }

    private String zrndai2hhknnen;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2HHKNNEN)
    public String getZrndai2hhknnen() {
        return zrndai2hhknnen;
    }

    public void setZrndai2hhknnen(String pZrndai2hhknnen) {
        zrndai2hhknnen = pZrndai2hhknnen;
    }

    private String zrndai2hihknsyakikykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2HIHKNSYAKIKYKARIHYJ)
    public String getZrndai2hihknsyakikykarihyj() {
        return zrndai2hihknsyakikykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2hihknsyakikykarihyj(String pZrndai2hihknsyakikykarihyj) {
        zrndai2hihknsyakikykarihyj = pZrndai2hihknsyakikykarihyj;
    }

    private String zrnkyksydi2hihknsyaduithyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNKYKSYDI2HIHKNSYADUITHYJ)
    public String getZrnkyksydi2hihknsyaduithyj() {
        return zrnkyksydi2hihknsyaduithyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkyksydi2hihknsyaduithyj(String pZrnkyksydi2hihknsyaduithyj) {
        zrnkyksydi2hihknsyaduithyj = pZrnkyksydi2hihknsyaduithyj;
    }

    private String zrndai2syosinsinsahouhoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SYOSINSINSAHOUHOUKBN)
    public String getZrndai2syosinsinsahouhoukbn() {
        return zrndai2syosinsinsahouhoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2syosinsinsahouhoukbn(String pZrndai2syosinsinsahouhoukbn) {
        zrndai2syosinsinsahouhoukbn = pZrndai2syosinsinsahouhoukbn;
    }

    private String zrndai2saisinsinsahouhoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SAISINSINSAHOUHOUKBN)
    public String getZrndai2saisinsinsahouhoukbn() {
        return zrndai2saisinsinsahouhoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2saisinsinsahouhoukbn(String pZrndai2saisinsinsahouhoukbn) {
        zrndai2saisinsinsahouhoukbn = pZrndai2saisinsinsahouhoukbn;
    }

    private String zrndai2syokugyoucd;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SYOKUGYOUCD)
    public String getZrndai2syokugyoucd() {
        return zrndai2syokugyoucd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrndai2syokugyoucd(String pZrndai2syokugyoucd) {
        zrndai2syokugyoucd = pZrndai2syokugyoucd;
    }

    private String zrndai2sakugenkikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SAKUGENKIKAN)
    public String getZrndai2sakugenkikan() {
        return zrndai2sakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2sakugenkikan(String pZrndai2sakugenkikan) {
        zrndai2sakugenkikan = pZrndai2sakugenkikan;
    }

    private Integer zrndai2ryoumasihyouten;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2RYOUMASIHYOUTEN)
    public Integer getZrndai2ryoumasihyouten() {
        return zrndai2ryoumasihyouten;
    }

    public void setZrndai2ryoumasihyouten(Integer pZrndai2ryoumasihyouten) {
        zrndai2ryoumasihyouten = pZrndai2ryoumasihyouten;
    }

    private String zrnmrtidi2skgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMRTIDI2SKGNKKN)
    public String getZrnmrtidi2skgnkkn() {
        return zrnmrtidi2skgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnmrtidi2skgnkkn(String pZrnmrtidi2skgnkkn) {
        zrnmrtidi2skgnkkn = pZrnmrtidi2skgnkkn;
    }

    private Integer zrnmrtidi2ryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNMRTIDI2RYUMSHYUTN)
    public Integer getZrnmrtidi2ryumshyutn() {
        return zrnmrtidi2ryumshyutn;
    }

    public void setZrnmrtidi2ryumshyutn(Integer pZrnmrtidi2ryumshyutn) {
        zrnmrtidi2ryumshyutn = pZrnmrtidi2ryumshyutn;
    }

    private String zrndi2kykkknnsyrikbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2KYKKKNNSYRIKBN)
    public String getZrndi2kykkknnsyrikbn() {
        return zrndi2kykkknnsyrikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2kykkknnsyrikbn(String pZrndi2kykkknnsyrikbn) {
        zrndi2kykkknnsyrikbn = pZrndi2kykkknnsyrikbn;
    }

    private String zrntignmrtidi2skgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNMRTIDI2SKGNKKN)
    public String getZrntignmrtidi2skgnkkn() {
        return zrntignmrtidi2skgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntignmrtidi2skgnkkn(String pZrntignmrtidi2skgnkkn) {
        zrntignmrtidi2skgnkkn = pZrntignmrtidi2skgnkkn;
    }

    private Integer zrntignmrtidi2ryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNMRTIDI2RYUMSHYUTN)
    public Integer getZrntignmrtidi2ryumshyutn() {
        return zrntignmrtidi2ryumshyutn;
    }

    public void setZrntignmrtidi2ryumshyutn(Integer pZrntignmrtidi2ryumshyutn) {
        zrntignmrtidi2ryumshyutn = pZrntignmrtidi2ryumshyutn;
    }

    private String zrndai2syosinhonninkknnkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SYOSINHONNINKKNNKBN)
    public String getZrndai2syosinhonninkknnkbn() {
        return zrndai2syosinhonninkknnkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2syosinhonninkknnkbn(String pZrndai2syosinhonninkknnkbn) {
        zrndai2syosinhonninkknnkbn = pZrndai2syosinhonninkknnkbn;
    }

    private String zrndi2sisnhonninkknnkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SISNHONNINKKNNKBN)
    public String getZrndi2sisnhonninkknnkbn() {
        return zrndi2sisnhonninkknnkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sisnhonninkknnkbn(String pZrndi2sisnhonninkknnkbn) {
        zrndi2sisnhonninkknnkbn = pZrndi2sisnhonninkknnkbn;
    }

    private String zrnyobiv9x6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV9X6)
    public String getZrnyobiv9x6() {
        return zrnyobiv9x6;
    }

    public void setZrnyobiv9x6(String pZrnyobiv9x6) {
        zrnyobiv9x6 = pZrnyobiv9x6;
    }

    private String zrndi2syugitkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SYUGITKYKSYRIKGU)
    public String getZrndi2syugitkyksyrikgu() {
        return zrndi2syugitkyksyrikgu;
    }

    public void setZrndi2syugitkyksyrikgu(String pZrndi2syugitkyksyrikgu) {
        zrndi2syugitkyksyrikgu = pZrndi2syugitkyksyrikgu;
    }

    private String zrndai2syougaitokuyakukikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SYOUGAITOKUYAKUKIKAN)
    public String getZrndai2syougaitokuyakukikan() {
        return zrndai2syougaitokuyakukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndai2syougaitokuyakukikan(String pZrndai2syougaitokuyakukikan) {
        zrndai2syougaitokuyakukikan = pZrndai2syougaitokuyakukikan;
    }

    private String zrndi2syugitkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SYUGITKYKPHRKKKN)
    public String getZrndi2syugitkykphrkkkn() {
        return zrndi2syugitkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2syugitkykphrkkkn(String pZrndi2syugitkykphrkkkn) {
        zrndi2syugitkykphrkkkn = pZrndi2syugitkykphrkkkn;
    }

    private Long zrndai2syougaitokuyakus;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SYOUGAITOKUYAKUS)
    public Long getZrndai2syougaitokuyakus() {
        return zrndai2syougaitokuyakus;
    }

    public void setZrndai2syougaitokuyakus(Long pZrndai2syougaitokuyakus) {
        zrndai2syougaitokuyakus = pZrndai2syougaitokuyakus;
    }

    private Long zrndai2syougaitokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SYOUGAITOKUYAKUP)
    public Long getZrndai2syougaitokuyakup() {
        return zrndai2syougaitokuyakup;
    }

    public void setZrndai2syougaitokuyakup(Long pZrndai2syougaitokuyakup) {
        zrndai2syougaitokuyakup = pZrndai2syougaitokuyakup;
    }

    private String zrndi2syugitkykgtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SYUGITKYKGTKBN)
    public String getZrndi2syugitkykgtkbn() {
        return zrndi2syugitkykgtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2syugitkykgtkbn(String pZrndi2syugitkykgtkbn) {
        zrndi2syugitkykgtkbn = pZrndi2syugitkykgtkbn;
    }

    private String zrndi2syugitkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SYUGITKYKKGUSDKBN)
    public String getZrndi2syugitkykkgusdkbn() {
        return zrndi2syugitkykkgusdkbn;
    }

    public void setZrndi2syugitkykkgusdkbn(String pZrndi2syugitkykkgusdkbn) {
        zrndi2syugitkykkgusdkbn = pZrndi2syugitkykkgusdkbn;
    }

    private String zrndi2syugitkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SYUGITKYKPWRBKKBN)
    public String getZrndi2syugitkykpwrbkkbn() {
        return zrndi2syugitkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2syugitkykpwrbkkbn(String pZrndi2syugitkykpwrbkkbn) {
        zrndi2syugitkykpwrbkkbn = pZrndi2syugitkykpwrbkkbn;
    }

    private String zrnyobiv8;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV8)
    public String getZrnyobiv8() {
        return zrnyobiv8;
    }

    public void setZrnyobiv8(String pZrnyobiv8) {
        zrnyobiv8 = pZrnyobiv8;
    }

    private String zrndi2sigiwrmstkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGIWRMSTKYKSYRIKGU)
    public String getZrndi2sigiwrmstkyksyrikgu() {
        return zrndi2sigiwrmstkyksyrikgu;
    }

    public void setZrndi2sigiwrmstkyksyrikgu(String pZrndi2sigiwrmstkyksyrikgu) {
        zrndi2sigiwrmstkyksyrikgu = pZrndi2sigiwrmstkyksyrikgu;
    }

    private String zrndi2sigiwrmstkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGIWRMSTKYKKKN)
    public String getZrndi2sigiwrmstkykkkn() {
        return zrndi2sigiwrmstkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sigiwrmstkykkkn(String pZrndi2sigiwrmstkykkkn) {
        zrndi2sigiwrmstkykkkn = pZrndi2sigiwrmstkykkkn;
    }

    private String zrndi2sigiwrmstkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGIWRMSTKYKPHRKKKN)
    public String getZrndi2sigiwrmstkykphrkkkn() {
        return zrndi2sigiwrmstkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sigiwrmstkykphrkkkn(String pZrndi2sigiwrmstkykphrkkkn) {
        zrndi2sigiwrmstkykphrkkkn = pZrndi2sigiwrmstkykphrkkkn;
    }

    private Long zrndi2sigiwrmstkyks;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGIWRMSTKYKS)
    public Long getZrndi2sigiwrmstkyks() {
        return zrndi2sigiwrmstkyks;
    }

    public void setZrndi2sigiwrmstkyks(Long pZrndi2sigiwrmstkyks) {
        zrndi2sigiwrmstkyks = pZrndi2sigiwrmstkyks;
    }

    private Long zrndi2sigiwrmstkykp;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGIWRMSTKYKP)
    public Long getZrndi2sigiwrmstkykp() {
        return zrndi2sigiwrmstkykp;
    }

    public void setZrndi2sigiwrmstkykp(Long pZrndi2sigiwrmstkykp) {
        zrndi2sigiwrmstkykp = pZrndi2sigiwrmstkykp;
    }

    private String zrndi2sigiwrmstkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGIWRMSTKYKKGUSDKBN)
    public String getZrndi2sigiwrmstkykkgusdkbn() {
        return zrndi2sigiwrmstkykkgusdkbn;
    }

    public void setZrndi2sigiwrmstkykkgusdkbn(String pZrndi2sigiwrmstkykkgusdkbn) {
        zrndi2sigiwrmstkykkgusdkbn = pZrndi2sigiwrmstkykkgusdkbn;
    }

    private String zrndi2sigiwrmstkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGIWRMSTKYKPWRBKKBN)
    public String getZrndi2sigiwrmstkykpwrbkkbn() {
        return zrndi2sigiwrmstkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sigiwrmstkykpwrbkkbn(String pZrndi2sigiwrmstkykpwrbkkbn) {
        zrndi2sigiwrmstkykpwrbkkbn = pZrndi2sigiwrmstkykpwrbkkbn;
    }

    private String zrnyobiv9x7;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV9X7)
    public String getZrnyobiv9x7() {
        return zrnyobiv9x7;
    }

    public void setZrnyobiv9x7(String pZrnyobiv9x7) {
        zrnyobiv9x7 = pZrnyobiv9x7;
    }

    private String zrndi2siginyuintkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGINYUINTKYKSYRIKGU)
    public String getZrndi2siginyuintkyksyrikgu() {
        return zrndi2siginyuintkyksyrikgu;
    }

    public void setZrndi2siginyuintkyksyrikgu(String pZrndi2siginyuintkyksyrikgu) {
        zrndi2siginyuintkyksyrikgu = pZrndi2siginyuintkyksyrikgu;
    }

    private String zrndi2siginyuintkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGINYUINTKYKKKN)
    public String getZrndi2siginyuintkykkkn() {
        return zrndi2siginyuintkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2siginyuintkykkkn(String pZrndi2siginyuintkykkkn) {
        zrndi2siginyuintkykkkn = pZrndi2siginyuintkykkkn;
    }

    private String zrndi2siginyuintkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGINYUINTKYKPHRKKKN)
    public String getZrndi2siginyuintkykphrkkkn() {
        return zrndi2siginyuintkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2siginyuintkykphrkkkn(String pZrndi2siginyuintkykphrkkkn) {
        zrndi2siginyuintkykphrkkkn = pZrndi2siginyuintkykphrkkkn;
    }

    private Integer zrndi2siginyuintkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGINYUINTKYKNTGK)
    public Integer getZrndi2siginyuintkykntgk() {
        return zrndi2siginyuintkykntgk;
    }

    public void setZrndi2siginyuintkykntgk(Integer pZrndi2siginyuintkykntgk) {
        zrndi2siginyuintkykntgk = pZrndi2siginyuintkykntgk;
    }

    private Long zrndi2siginyuintkykp;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGINYUINTKYKP)
    public Long getZrndi2siginyuintkykp() {
        return zrndi2siginyuintkykp;
    }

    public void setZrndi2siginyuintkykp(Long pZrndi2siginyuintkykp) {
        zrndi2siginyuintkykp = pZrndi2siginyuintkykp;
    }

    private String zrndi2siginyuintkykgtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGINYUINTKYKGTKBN)
    public String getZrndi2siginyuintkykgtkbn() {
        return zrndi2siginyuintkykgtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2siginyuintkykgtkbn(String pZrndi2siginyuintkykgtkbn) {
        zrndi2siginyuintkykgtkbn = pZrndi2siginyuintkykgtkbn;
    }

    private String zrndi2siginyintkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGINYINTKYKKGUSDKBN)
    public String getZrndi2siginyintkykkgusdkbn() {
        return zrndi2siginyintkykkgusdkbn;
    }

    public void setZrndi2siginyintkykkgusdkbn(String pZrndi2siginyintkykkgusdkbn) {
        zrndi2siginyintkykkgusdkbn = pZrndi2siginyintkykkgusdkbn;
    }

    private String zrndi2siginyuintkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIGINYUINTKYKPWRBKKBN)
    public String getZrndi2siginyuintkykpwrbkkbn() {
        return zrndi2siginyuintkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2siginyuintkykpwrbkkbn(String pZrndi2siginyuintkykpwrbkkbn) {
        zrndi2siginyuintkykpwrbkkbn = pZrndi2siginyuintkykpwrbkkbn;
    }

    private String zrnyobiv10x3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV10X3)
    public String getZrnyobiv10x3() {
        return zrnyobiv10x3;
    }

    public void setZrnyobiv10x3(String pZrnyobiv10x3) {
        zrnyobiv10x3 = pZrnyobiv10x3;
    }

    private String zrndi2sppinyuintkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINTKYKSYRIKGU)
    public String getZrndi2sppinyuintkyksyrikgu() {
        return zrndi2sppinyuintkyksyrikgu;
    }

    public void setZrndi2sppinyuintkyksyrikgu(String pZrndi2sppinyuintkyksyrikgu) {
        zrndi2sppinyuintkyksyrikgu = pZrndi2sppinyuintkyksyrikgu;
    }

    private String zrndi2sppinyuintkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINTKYKKKN)
    public String getZrndi2sppinyuintkykkkn() {
        return zrndi2sppinyuintkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sppinyuintkykkkn(String pZrndi2sppinyuintkykkkn) {
        zrndi2sppinyuintkykkkn = pZrndi2sppinyuintkykkkn;
    }

    private String zrndi2sppinyuintkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINTKYKPHRKKKN)
    public String getZrndi2sppinyuintkykphrkkkn() {
        return zrndi2sppinyuintkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sppinyuintkykphrkkkn(String pZrndi2sppinyuintkykphrkkkn) {
        zrndi2sppinyuintkykphrkkkn = pZrndi2sppinyuintkykphrkkkn;
    }

    private Integer zrndi2sppinyuintkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINTKYKNTGK)
    public Integer getZrndi2sppinyuintkykntgk() {
        return zrndi2sppinyuintkykntgk;
    }

    public void setZrndi2sppinyuintkykntgk(Integer pZrndi2sppinyuintkykntgk) {
        zrndi2sppinyuintkykntgk = pZrndi2sppinyuintkykntgk;
    }

    private Long zrndi2sppinyuintkykp;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINTKYKP)
    public Long getZrndi2sppinyuintkykp() {
        return zrndi2sppinyuintkykp;
    }

    public void setZrndi2sppinyuintkykp(Long pZrndi2sppinyuintkykp) {
        zrndi2sppinyuintkykp = pZrndi2sppinyuintkykp;
    }

    private String zrndi2sppinyuintkykgtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINTKYKGTKBN)
    public String getZrndi2sppinyuintkykgtkbn() {
        return zrndi2sppinyuintkykgtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sppinyuintkykgtkbn(String pZrndi2sppinyuintkykgtkbn) {
        zrndi2sppinyuintkykgtkbn = pZrndi2sppinyuintkykgtkbn;
    }

    private Integer zrndi2sppinyintkjyryumshytn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYINTKJYRYUMSHYTN)
    public Integer getZrndi2sppinyintkjyryumshytn() {
        return zrndi2sppinyintkjyryumshytn;
    }

    public void setZrndi2sppinyintkjyryumshytn(Integer pZrndi2sppinyintkjyryumshytn) {
        zrndi2sppinyintkjyryumshytn = pZrndi2sppinyintkjyryumshytn;
    }

    private Long zrndi2sppinyuintkjyup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINTKJYUP)
    public Long getZrndi2sppinyuintkjyup() {
        return zrndi2sppinyuintkjyup;
    }

    public void setZrndi2sppinyuintkjyup(Long pZrndi2sppinyuintkjyup) {
        zrndi2sppinyuintkjyup = pZrndi2sppinyuintkjyup;
    }

    private String zrndi2sppinyuintktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINTKTBICDX1)
    public String getZrndi2sppinyuintktbicdx1() {
        return zrndi2sppinyuintktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sppinyuintktbicdx1(String pZrndi2sppinyuintktbicdx1) {
        zrndi2sppinyuintktbicdx1 = pZrndi2sppinyuintktbicdx1;
    }

    private String zrndi2sppinyuinhtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINHTNPKKNX1)
    public String getZrndi2sppinyuinhtnpkknx1() {
        return zrndi2sppinyuinhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sppinyuinhtnpkknx1(String pZrndi2sppinyuinhtnpkknx1) {
        zrndi2sppinyuinhtnpkknx1 = pZrndi2sppinyuinhtnpkknx1;
    }

    private String zrndi2sppinyuintktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINTKTBICDX2)
    public String getZrndi2sppinyuintktbicdx2() {
        return zrndi2sppinyuintktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sppinyuintktbicdx2(String pZrndi2sppinyuintktbicdx2) {
        zrndi2sppinyuintktbicdx2 = pZrndi2sppinyuintktbicdx2;
    }

    private String zrndi2sppinyuinhtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINHTNPKKNX2)
    public String getZrndi2sppinyuinhtnpkknx2() {
        return zrndi2sppinyuinhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sppinyuinhtnpkknx2(String pZrndi2sppinyuinhtnpkknx2) {
        zrndi2sppinyuinhtnpkknx2 = pZrndi2sppinyuinhtnpkknx2;
    }

    private String zrndi2sppinyintkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYINTKYKKGUSDKBN)
    public String getZrndi2sppinyintkykkgusdkbn() {
        return zrndi2sppinyintkykkgusdkbn;
    }

    public void setZrndi2sppinyintkykkgusdkbn(String pZrndi2sppinyintkykkgusdkbn) {
        zrndi2sppinyintkykkgusdkbn = pZrndi2sppinyintkykkgusdkbn;
    }

    private String zrndi2sppinyuintkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SPPINYUINTKYKPWRBKKBN)
    public String getZrndi2sppinyuintkykpwrbkkbn() {
        return zrndi2sppinyuintkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sppinyuintkykpwrbkkbn(String pZrndi2sppinyuintkykpwrbkkbn) {
        zrndi2sppinyuintkykpwrbkkbn = pZrndi2sppinyuintkykpwrbkkbn;
    }

    private String zrnyobiv3x2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV3X2)
    public String getZrnyobiv3x2() {
        return zrnyobiv3x2;
    }

    public void setZrnyobiv3x2(String pZrnyobiv3x2) {
        zrnyobiv3x2 = pZrnyobiv3x2;
    }

    private String zrndi2sijnbyutkyksyrikgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUTKYKSYRIKGU)
    public String getZrndi2sijnbyutkyksyrikgu() {
        return zrndi2sijnbyutkyksyrikgu;
    }

    public void setZrndi2sijnbyutkyksyrikgu(String pZrndi2sijnbyutkyksyrikgu) {
        zrndi2sijnbyutkyksyrikgu = pZrndi2sijnbyutkyksyrikgu;
    }

    private String zrndi2sijnbyutkykkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUTKYKKKN)
    public String getZrndi2sijnbyutkykkkn() {
        return zrndi2sijnbyutkykkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sijnbyutkykkkn(String pZrndi2sijnbyutkykkkn) {
        zrndi2sijnbyutkykkkn = pZrndi2sijnbyutkykkkn;
    }

    private String zrndi2sijnbyutkykphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUTKYKPHRKKKN)
    public String getZrndi2sijnbyutkykphrkkkn() {
        return zrndi2sijnbyutkykphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sijnbyutkykphrkkkn(String pZrndi2sijnbyutkykphrkkkn) {
        zrndi2sijnbyutkykphrkkkn = pZrndi2sijnbyutkykphrkkkn;
    }

    private Integer zrndi2sijnbyutkykntgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUTKYKNTGK)
    public Integer getZrndi2sijnbyutkykntgk() {
        return zrndi2sijnbyutkykntgk;
    }

    public void setZrndi2sijnbyutkykntgk(Integer pZrndi2sijnbyutkykntgk) {
        zrndi2sijnbyutkykntgk = pZrndi2sijnbyutkykntgk;
    }

    private Long zrndai2seijinbyoutokuyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SEIJINBYOUTOKUYAKUP)
    public Long getZrndai2seijinbyoutokuyakup() {
        return zrndai2seijinbyoutokuyakup;
    }

    public void setZrndai2seijinbyoutokuyakup(Long pZrndai2seijinbyoutokuyakup) {
        zrndai2seijinbyoutokuyakup = pZrndai2seijinbyoutokuyakup;
    }

    private Integer zrndi2sijnbyutkjyurymshytn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUTKJYURYMSHYTN)
    public Integer getZrndi2sijnbyutkjyurymshytn() {
        return zrndi2sijnbyutkjyurymshytn;
    }

    public void setZrndi2sijnbyutkjyurymshytn(Integer pZrndi2sijnbyutkjyurymshytn) {
        zrndi2sijnbyutkjyurymshytn = pZrndi2sijnbyutkjyurymshytn;
    }

    private Long zrndai2seijinbyoutokujyoup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2SEIJINBYOUTOKUJYOUP)
    public Long getZrndai2seijinbyoutokujyoup() {
        return zrndai2seijinbyoutokujyoup;
    }

    public void setZrndai2seijinbyoutokujyoup(Long pZrndai2seijinbyoutokujyoup) {
        zrndai2seijinbyoutokujyoup = pZrndai2seijinbyoutokujyoup;
    }

    private String zrndi2sijnbyutktbicdx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUTKTBICDX1)
    public String getZrndi2sijnbyutktbicdx1() {
        return zrndi2sijnbyutktbicdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sijnbyutktbicdx1(String pZrndi2sijnbyutktbicdx1) {
        zrndi2sijnbyutktbicdx1 = pZrndi2sijnbyutktbicdx1;
    }

    private String zrndi2sijnbyuhtnpkknx1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUHTNPKKNX1)
    public String getZrndi2sijnbyuhtnpkknx1() {
        return zrndi2sijnbyuhtnpkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sijnbyuhtnpkknx1(String pZrndi2sijnbyuhtnpkknx1) {
        zrndi2sijnbyuhtnpkknx1 = pZrndi2sijnbyuhtnpkknx1;
    }

    private String zrndi2sijnbyutktbicdx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUTKTBICDX2)
    public String getZrndi2sijnbyutktbicdx2() {
        return zrndi2sijnbyutktbicdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sijnbyutktbicdx2(String pZrndi2sijnbyutktbicdx2) {
        zrndi2sijnbyutktbicdx2 = pZrndi2sijnbyutktbicdx2;
    }

    private String zrndi2sijnbyuhtnpkknx2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUHTNPKKNX2)
    public String getZrndi2sijnbyuhtnpkknx2() {
        return zrndi2sijnbyuhtnpkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sijnbyuhtnpkknx2(String pZrndi2sijnbyuhtnpkknx2) {
        zrndi2sijnbyuhtnpkknx2 = pZrndi2sijnbyuhtnpkknx2;
    }

    private String zrndi2sijnbyutkykkgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUTKYKKGUSDKBN)
    public String getZrndi2sijnbyutkykkgusdkbn() {
        return zrndi2sijnbyutkykkgusdkbn;
    }

    public void setZrndi2sijnbyutkykkgusdkbn(String pZrndi2sijnbyutkykkgusdkbn) {
        zrndi2sijnbyutkykkgusdkbn = pZrndi2sijnbyutkykkgusdkbn;
    }

    private String zrndi2sijnbytkykgankyhgtkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYTKYKGANKYHGTKBN)
    public String getZrndi2sijnbytkykgankyhgtkbn() {
        return zrndi2sijnbytkykgankyhgtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndi2sijnbytkykgankyhgtkbn(String pZrndi2sijnbytkykgankyhgtkbn) {
        zrndi2sijnbytkykgankyhgtkbn = pZrndi2sijnbytkykgankyhgtkbn;
    }

    private String zrndi2sijnbyutkykpwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDI2SIJNBYUTKYKPWRBKKBN)
    public String getZrndi2sijnbyutkykpwrbkkbn() {
        return zrndi2sijnbyutkykpwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrndi2sijnbyutkykpwrbkkbn(String pZrndi2sijnbyutkykpwrbkkbn) {
        zrndi2sijnbyutkykpwrbkkbn = pZrndi2sijnbyutkykpwrbkkbn;
    }

    private String zrnyobiv3x3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV3X3)
    public String getZrnyobiv3x3() {
        return zrnyobiv3x3;
    }

    public void setZrnyobiv3x3(String pZrnyobiv3x3) {
        zrnyobiv3x3 = pZrnyobiv3x3;
    }

    private String zrndai2jyoukentukihyouji;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNDAI2JYOUKENTUKIHYOUJI)
    public String getZrndai2jyoukentukihyouji() {
        return zrndai2jyoukentukihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrndai2jyoukentukihyouji(String pZrndai2jyoukentukihyouji) {
        zrndai2jyoukentukihyouji = pZrndai2jyoukentukihyouji;
    }

    private String zrntignmrtisyukgu;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNMRTISYUKGU)
    public String getZrntignmrtisyukgu() {
        return zrntignmrtisyukgu;
    }

    public void setZrntignmrtisyukgu(String pZrntignmrtisyukgu) {
        zrntignmrtisyukgu = pZrntignmrtisyukgu;
    }

    private String zrnteigenmaruteikikan;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENMARUTEIKIKAN)
    public String getZrnteigenmaruteikikan() {
        return zrnteigenmaruteikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnteigenmaruteikikan(String pZrnteigenmaruteikikan) {
        zrnteigenmaruteikikan = pZrnteigenmaruteikikan;
    }

    private String zrnteigenmrtiphrkkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENMRTIPHRKKKN)
    public String getZrnteigenmrtiphrkkkn() {
        return zrnteigenmrtiphrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnteigenmrtiphrkkkn(String pZrnteigenmrtiphrkkkn) {
        zrnteigenmrtiphrkkkn = pZrnteigenmrtiphrkkkn;
    }

    private Long zrnteigenmaruteis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENMARUTEIS)
    public Long getZrnteigenmaruteis() {
        return zrnteigenmaruteis;
    }

    public void setZrnteigenmaruteis(Long pZrnteigenmaruteis) {
        zrnteigenmaruteis = pZrnteigenmaruteis;
    }

    private Long zrnteigenmaruteip;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENMARUTEIP)
    public Long getZrnteigenmaruteip() {
        return zrnteigenmaruteip;
    }

    public void setZrnteigenmaruteip(Long pZrnteigenmaruteip) {
        zrnteigenmaruteip = pZrnteigenmaruteip;
    }

    private Long zrnteigenmaruteisyuuseis;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENMARUTEISYUUSEIS)
    public Long getZrnteigenmaruteisyuuseis() {
        return zrnteigenmaruteisyuuseis;
    }

    public void setZrnteigenmaruteisyuuseis(Long pZrnteigenmaruteisyuuseis) {
        zrnteigenmaruteisyuuseis = pZrnteigenmaruteisyuuseis;
    }

    private String zrnteigenmrtimodssakugenhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENMRTIMODSSAKUGENHYJ)
    public String getZrnteigenmrtimodssakugenhyj() {
        return zrnteigenmrtimodssakugenhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnteigenmrtimodssakugenhyj(String pZrnteigenmrtimodssakugenhyj) {
        zrnteigenmrtimodssakugenhyj = pZrnteigenmrtimodssakugenhyj;
    }

    private String zrntignmrtitkjyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNMRTITKJYUKBN)
    public String getZrntignmrtitkjyukbn() {
        return zrntignmrtitkjyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntignmrtitkjyukbn(String pZrntignmrtitkjyukbn) {
        zrntignmrtitkjyukbn = pZrntignmrtitkjyukbn;
    }

    private String zrntignmrtitkjyuskgnkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNMRTITKJYUSKGNKKN)
    public String getZrntignmrtitkjyuskgnkkn() {
        return zrntignmrtitkjyuskgnkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntignmrtitkjyuskgnkkn(String pZrntignmrtitkjyuskgnkkn) {
        zrntignmrtitkjyuskgnkkn = pZrntignmrtitkjyuskgnkkn;
    }

    private Integer zrntignmrtitkjyuryumshyutn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNMRTITKJYURYUMSHYUTN)
    public Integer getZrntignmrtitkjyuryumshyutn() {
        return zrntignmrtitkjyuryumshyutn;
    }

    public void setZrntignmrtitkjyuryumshyutn(Integer pZrntignmrtitkjyuryumshyutn) {
        zrntignmrtitkjyuryumshyutn = pZrntignmrtitkjyuryumshyutn;
    }

    private Long zrntignmrtitkjyup;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNMRTITKJYUP)
    public Long getZrntignmrtitkjyup() {
        return zrntignmrtitkjyup;
    }

    public void setZrntignmrtitkjyup(Long pZrntignmrtitkjyup) {
        zrntignmrtitkjyup = pZrntignmrtitkjyup;
    }

    private Integer zrntignmrtiskyuksgk;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNMRTISKYUKSGK)
    public Integer getZrntignmrtiskyuksgk() {
        return zrntignmrtiskyuksgk;
    }

    public void setZrntignmrtiskyuksgk(Integer pZrntignmrtiskyuksgk) {
        zrntignmrtiskyuksgk = pZrntignmrtiskyuksgk;
    }

    private String zrnhtnknkyktignmrtsyrikgux1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKTIGNMRTSYRIKGUX1)
    public String getZrnhtnknkyktignmrtsyrikgux1() {
        return zrnhtnknkyktignmrtsyrikgux1;
    }

    public void setZrnhtnknkyktignmrtsyrikgux1(String pZrnhtnknkyktignmrtsyrikgux1) {
        zrnhtnknkyktignmrtsyrikgux1 = pZrnhtnknkyktignmrtsyrikgux1;
    }

    private String zrnhtnknkyktignmrtsyrikgux2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKTIGNMRTSYRIKGUX2)
    public String getZrnhtnknkyktignmrtsyrikgux2() {
        return zrnhtnknkyktignmrtsyrikgux2;
    }

    public void setZrnhtnknkyktignmrtsyrikgux2(String pZrnhtnknkyktignmrtsyrikgux2) {
        zrnhtnknkyktignmrtsyrikgux2 = pZrnhtnknkyktignmrtsyrikgux2;
    }

    private String zrnhtnknkyktignmrtsyrikgux3;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKTIGNMRTSYRIKGUX3)
    public String getZrnhtnknkyktignmrtsyrikgux3() {
        return zrnhtnknkyktignmrtsyrikgux3;
    }

    public void setZrnhtnknkyktignmrtsyrikgux3(String pZrnhtnknkyktignmrtsyrikgux3) {
        zrnhtnknkyktignmrtsyrikgux3 = pZrnhtnknkyktignmrtsyrikgux3;
    }

    private String zrnhtnknkyktignmrtsyrikgux4;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKTIGNMRTSYRIKGUX4)
    public String getZrnhtnknkyktignmrtsyrikgux4() {
        return zrnhtnknkyktignmrtsyrikgux4;
    }

    public void setZrnhtnknkyktignmrtsyrikgux4(String pZrnhtnknkyktignmrtsyrikgux4) {
        zrnhtnknkyktignmrtsyrikgux4 = pZrnhtnknkyktignmrtsyrikgux4;
    }

    private String zrnhtnknkyktignmrtsyrikgux5;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKTIGNMRTSYRIKGUX5)
    public String getZrnhtnknkyktignmrtsyrikgux5() {
        return zrnhtnknkyktignmrtsyrikgux5;
    }

    public void setZrnhtnknkyktignmrtsyrikgux5(String pZrnhtnknkyktignmrtsyrikgux5) {
        zrnhtnknkyktignmrtsyrikgux5 = pZrnhtnknkyktignmrtsyrikgux5;
    }

    private String zrnhtnknkyktignmrtsyrikgux6;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNHTNKNKYKTIGNMRTSYRIKGUX6)
    public String getZrnhtnknkyktignmrtsyrikgux6() {
        return zrnhtnknkyktignmrtsyrikgux6;
    }

    public void setZrnhtnknkyktignmrtsyrikgux6(String pZrnhtnknkyktignmrtsyrikgux6) {
        zrnhtnknkyktignmrtsyrikgux6 = pZrnhtnknkyktignmrtsyrikgux6;
    }

    private String zrnsuryutignmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSURYUTIGNMRTIPWRBKKBN)
    public String getZrnsuryutignmrtipwrbkkbn() {
        return zrnsuryutignmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuryutignmrtipwrbkkbn(String pZrnsuryutignmrtipwrbkkbn) {
        zrnsuryutignmrtipwrbkkbn = pZrnsuryutignmrtipwrbkkbn;
    }

    private String zrntignmrtipwrbkkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNMRTIPWRBKKBN)
    public String getZrntignmrtipwrbkkbn() {
        return zrntignmrtipwrbkkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntignmrtipwrbkkbn(String pZrntignmrtipwrbkkbn) {
        zrntignmrtipwrbkkbn = pZrntignmrtipwrbkkbn;
    }

    private String zrntignmrtitnknyugukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTIGNMRTITNKNYUGUKBN)
    public String getZrntignmrtitnknyugukbn() {
        return zrntignmrtitnknyugukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntignmrtitnknyugukbn(String pZrntignmrtitnknyugukbn) {
        zrntignmrtitnknyugukbn = pZrntignmrtitnknyugukbn;
    }

    private String zrnteigenmrtikgusdkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTEIGENMRTIKGUSDKBN)
    public String getZrnteigenmrtikgusdkbn() {
        return zrnteigenmrtikgusdkbn;
    }

    public void setZrnteigenmrtikgusdkbn(String pZrnteigenmrtikgusdkbn) {
        zrnteigenmrtikgusdkbn = pZrnteigenmrtikgusdkbn;
    }

    private String zrnyobiv1x2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV1X2)
    public String getZrnyobiv1x2() {
        return zrnyobiv1x2;
    }

    public void setZrnyobiv1x2(String pZrnyobiv1x2) {
        zrnyobiv1x2 = pZrnyobiv1x2;
    }

    private String zrntktsppisetkykkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNTKTSPPISETKYKKBN)
    public String getZrntktsppisetkykkbn() {
        return zrntktsppisetkykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrntktsppisetkykkbn(String pZrntktsppisetkykkbn) {
        zrntktsppisetkykkbn = pZrntktsppisetkykkbn;
    }

    private String zrnjyudmnsiskknsetkykkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNJYUDMNSISKKNSETKYKKBN)
    public String getZrnjyudmnsiskknsetkykkbn() {
        return zrnjyudmnsiskknsetkykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnjyudmnsiskknsetkykkbn(String pZrnjyudmnsiskknsetkykkbn) {
        zrnjyudmnsiskknsetkykkbn = pZrnjyudmnsiskknsetkykkbn;
    }

    private String zrnyobiv8x2;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV8X2)
    public String getZrnyobiv8x2() {
        return zrnyobiv8x2;
    }

    public void setZrnyobiv8x2(String pZrnyobiv8x2) {
        zrnyobiv8x2 = pZrnyobiv8x2;
    }

    private String zrnsetaitesyono1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITESYONO1)
    public String getZrnsetaitesyono1() {
        return zrnsetaitesyono1;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnsetaitesyono1(String pZrnsetaitesyono1) {
        zrnsetaitesyono1 = pZrnsetaitesyono1;
    }

    private String zrnsetaitehokensyuruikigou1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITEHOKENSYURUIKIGOU1)
    public String getZrnsetaitehokensyuruikigou1() {
        return zrnsetaitehokensyuruikigou1;
    }

    public void setZrnsetaitehokensyuruikigou1(String pZrnsetaitehokensyuruikigou1) {
        zrnsetaitehokensyuruikigou1 = pZrnsetaitehokensyuruikigou1;
    }

    private String zrnsetaitemrtisyuruikgu1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITEMRTISYURUIKGU1)
    public String getZrnsetaitemrtisyuruikgu1() {
        return zrnsetaitemrtisyuruikgu1;
    }

    public void setZrnsetaitemrtisyuruikgu1(String pZrnsetaitemrtisyuruikgu1) {
        zrnsetaitemrtisyuruikgu1 = pZrnsetaitemrtisyuruikgu1;
    }

    private String zrnsetaitesiznmrtisyurui1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITESIZNMRTISYURUI1)
    public String getZrnsetaitesiznmrtisyurui1() {
        return zrnsetaitesiznmrtisyurui1;
    }

    public void setZrnsetaitesiznmrtisyurui1(String pZrnsetaitesiznmrtisyurui1) {
        zrnsetaitesiznmrtisyurui1 = pZrnsetaitesiznmrtisyurui1;
    }

    private String zrnsetaitetignmrtisyurui1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITETIGNMRTISYURUI1)
    public String getZrnsetaitetignmrtisyurui1() {
        return zrnsetaitetignmrtisyurui1;
    }

    public void setZrnsetaitetignmrtisyurui1(String pZrnsetaitetignmrtisyurui1) {
        zrnsetaitetignmrtisyurui1 = pZrnsetaitetignmrtisyurui1;
    }

    private Long zrnsetaitekihonbubuns1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITEKIHONBUBUNS1)
    public Long getZrnsetaitekihonbubuns1() {
        return zrnsetaitekihonbubuns1;
    }

    public void setZrnsetaitekihonbubuns1(Long pZrnsetaitekihonbubuns1) {
        zrnsetaitekihonbubuns1 = pZrnsetaitekihonbubuns1;
    }

    private Long zrnsetgukitnknitjbrkhns1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETGUKITNKNITJBRKHNS1)
    public Long getZrnsetgukitnknitjbrkhns1() {
        return zrnsetgukitnknitjbrkhns1;
    }

    public void setZrnsetgukitnknitjbrkhns1(Long pZrnsetgukitnknitjbrkhns1) {
        zrnsetgukitnknitjbrkhns1 = pZrnsetgukitnknitjbrkhns1;
    }

    private Long zrnsetaitesibous1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITESIBOUS1)
    public Long getZrnsetaitesibous1() {
        return zrnsetaitesibous1;
    }

    public void setZrnsetaitesibous1(Long pZrnsetaitesibous1) {
        zrnsetaitesibous1 = pZrnsetaitesibous1;
    }

    private Long zrnsetgukitnknitjbrsbus1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETGUKITNKNITJBRSBUS1)
    public Long getZrnsetgukitnknitjbrsbus1() {
        return zrnsetgukitnknitjbrsbus1;
    }

    public void setZrnsetgukitnknitjbrsbus1(Long pZrnsetgukitnknitjbrsbus1) {
        zrnsetgukitnknitjbrsbus1 = pZrnsetgukitnknitjbrsbus1;
    }

    private Long zrnsetaitesyuuseis1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITESYUUSEIS1)
    public Long getZrnsetaitesyuuseis1() {
        return zrnsetaitesyuuseis1;
    }

    public void setZrnsetaitesyuuseis1(Long pZrnsetaitesyuuseis1) {
        zrnsetaitesyuuseis1 = pZrnsetaitesyuuseis1;
    }

    private Long zrnsetaiteharaikomip1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITEHARAIKOMIP1)
    public Long getZrnsetaiteharaikomip1() {
        return zrnsetaiteharaikomip1;
    }

    public void setZrnsetaiteharaikomip1(Long pZrnsetaiteharaikomip1) {
        zrnsetaiteharaikomip1 = pZrnsetaiteharaikomip1;
    }

    private Long zrnsetaitesyukeiyakububunp1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITESYUKEIYAKUBUBUNP1)
    public Long getZrnsetaitesyukeiyakububunp1() {
        return zrnsetaitesyukeiyakububunp1;
    }

    public void setZrnsetaitesyukeiyakububunp1(Long pZrnsetaitesyukeiyakububunp1) {
        zrnsetaitesyukeiyakububunp1 = pZrnsetaitesyukeiyakububunp1;
    }

    private Long zrnsetaitgukikzkmrtis1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITGUKIKZKMRTIS1)
    public Long getZrnsetaitgukikzkmrtis1() {
        return zrnsetaitgukikzkmrtis1;
    }

    public void setZrnsetaitgukikzkmrtis1(Long pZrnsetaitgukikzkmrtis1) {
        zrnsetaitgukikzkmrtis1 = pZrnsetaitgukikzkmrtis1;
    }

    private String zrnsetaitetenkankykhyj1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITETENKANKYKHYJ1)
    public String getZrnsetaitetenkankykhyj1() {
        return zrnsetaitetenkankykhyj1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsetaitetenkankykhyj1(String pZrnsetaitetenkankykhyj1) {
        zrnsetaitetenkankykhyj1 = pZrnsetaitetenkankykhyj1;
    }

    private Long zrnsetaitesiteimhrkp1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITESITEIMHRKP1)
    public Long getZrnsetaitesiteimhrkp1() {
        return zrnsetaitesiteimhrkp1;
    }

    public void setZrnsetaitesiteimhrkp1(Long pZrnsetaitesiteimhrkp1) {
        zrnsetaitesiteimhrkp1 = pZrnsetaitesiteimhrkp1;
    }

    private Long zrnsetaitesiteimsykykp1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITESITEIMSYKYKP1)
    public Long getZrnsetaitesiteimsykykp1() {
        return zrnsetaitesiteimsykykp1;
    }

    public void setZrnsetaitesiteimsykykp1(Long pZrnsetaitesiteimsykykp1) {
        zrnsetaitesiteimsykykp1 = pZrnsetaitesiteimsykykp1;
    }

    private String zrnsetaitenkmrtisyurui1;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNSETAITENKMRTISYURUI1)
    public String getZrnsetaitenkmrtisyurui1() {
        return zrnsetaitenkmrtisyurui1;
    }

    public void setZrnsetaitenkmrtisyurui1(String pZrnsetaitenkmrtisyurui1) {
        zrnsetaitenkmrtisyurui1 = pZrnsetaitenkmrtisyurui1;
    }

    private String zrnyobiv18;

    @Column(name=GenZT_Skeiksnbsgetujisr1Rn.ZRNYOBIV18)
    public String getZrnyobiv18() {
        return zrnyobiv18;
    }

    public void setZrnyobiv18(String pZrnyobiv18) {
        zrnyobiv18 = pZrnyobiv18;
    }
}