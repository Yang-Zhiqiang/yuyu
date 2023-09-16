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
import yuyu.def.db.entity.ZT_Sp2RnduyuSouseiritu1Ty;
import yuyu.def.db.id.PKZT_Sp2RnduyuSouseiritu1Ty;
import yuyu.def.db.meta.GenQZT_Sp2RnduyuSouseiritu1Ty;
import yuyu.def.db.meta.QZT_Sp2RnduyuSouseiritu1Ty;

/**
 * ＳＰ２連動用総成立Fテーブル１（中） テーブルのマッピング情報クラスで、 {@link ZT_Sp2RnduyuSouseiritu1Ty} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Sp2RnduyuSouseiritu1Ty}</td><td colspan="3">ＳＰ２連動用総成立Fテーブル１（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyktgysyrymd ztyktgysyrymd}</td><td>（中継用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgysyono ztyktgysyono}</td><td>（中継用）結合用証券番号</td><td align="center">{@link PKZT_Sp2RnduyuSouseiritu1Ty ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgyfilerenno ztyktgyfilerenno}</td><td>（中継用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisyasisyacd ztyaatukaisyasisyacd}</td><td>（中継用）Ａ扱者支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymosno ztymosno}</td><td>（中継用）申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihons ztykihons}</td><td>（中継用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysibous ztysibous}</td><td>（中継用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygyousekihyoukayouhosyous ztygyousekihyoukayouhosyous}</td><td>（中継用）業績評価用保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukitnknitjbrkhns ztygukitnknitjbrkhns}</td><td>（中継用）合計転換一時払基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukitnknitjbrsbus ztygukitnknitjbrsbus}</td><td>（中継用）合計転換一時払死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykktijgukitnknitjbrkhns ztykktijgukitnknitjbrkhns}</td><td>（中継用）確定時合計転換一時払基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykktijgukitnknitjbrsbus ztykktijgukitnknitjbrsbus}</td><td>（中継用）確定時合計転換一時払死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyokaiharaikomip ztysyokaiharaikomip}</td><td>（中継用）初回払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryouritukbn ztyryouritukbn}</td><td>（中継用）料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksyuannaikykkbn ztytksyuannaikykkbn}</td><td>（中継用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysdpdkbn ztysdpdkbn}</td><td>（中継用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyanniskcd ztyanniskcd}</td><td>（中継用）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduketorihouhoukbn ztyduketorihouhoukbn}</td><td>（中継用）Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyhhknsydouituhyouji ztykyksyhhknsydouituhyouji}</td><td>（中継用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyakikykarihyj ztykyksyakikykarihyj}</td><td>（中継用）契約者既契約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkankeiyakuhyouji ztytenkankeiyakuhyouji}</td><td>（中継用）転換契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjigyoukeiyakuhyouji ztyjigyoukeiyakuhyouji}</td><td>（中継用）事業契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinzeiseitokuyakukbn ztynenkinzeiseitokuyakukbn}</td><td>（中継用）年金税制特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyusseimaekanyuukykkbn ztysyusseimaekanyuukykkbn}</td><td>（中継用）出生前加入契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokukeiyakuhyouji ztykazokukeiyakuhyouji}</td><td>（中継用）家族契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikokykhyj ztyjikokykhyj}</td><td>（中継用）自己契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuusyoumeisiyouhyouji ztytuusyoumeisiyouhyouji}</td><td>（中継用）通称名使用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysethokenkbn ztysethokenkbn}</td><td>（中継用）セット保険区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikeisyouhinkbn ztyteikeisyouhinkbn}</td><td>（中継用）提携商品区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuninbosyuuteate ztytokuninbosyuuteate}</td><td>（中継用）特認募集手当</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyseisekiym ztyseisekiym}</td><td>（中継用）成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisekikeijyousyuuseis ztyseisekikeijyousyuuseis}</td><td>（中継用）成績計上修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuuseissakugenhyouji ztysyuuseissakugenhyouji}</td><td>（中継用）修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisisyatodouhukencd ztyaatukaisisyatodouhukencd}</td><td>（中継用）Ａ扱支社都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaikojincd ztyaatukaikojincd}</td><td>（中継用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatukaisosikicd ztybatukaisosikicd}</td><td>（中継用）Ｂ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatukaisyakojincd ztybatukaisyakojincd}</td><td>（中継用）Ｂ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarutokukbn ztymarutokukbn}</td><td>（中継用）マル特区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygyoumujyouhyouji ztygyoumujyouhyouji}</td><td>（中継用）業務上表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuikakeijyoukbn ztytuikakeijyoukbn}</td><td>（中継用）追加計上区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisekinomikeijyoukbn ztyseisekinomikeijyoukbn}</td><td>（中継用）成績のみ計上区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikikeijyoukbn ztyteikikeijyoukbn}</td><td>（中継用）定期計上区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhngkmskkatkisykbn ztyhngkmskkatkisykbn}</td><td>（中継用）変額無資格扱者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknkyuuyosakugenhyj ztytnknkyuuyosakugenhyj}</td><td>（中継用）転換給与削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkankaisuu ztytenkankaisuu}</td><td>（中継用）転換回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhiyubrigssnsikkijyunkbn ztyhiyubrigssnsikkijyunkbn}</td><td>（中継用）併用払合算正規基準区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysekininkaisiymd ztysekininkaisiymd}</td><td>（中継用）責任開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykigetusmkrgkykhyj ztykigetusmkrgkykhyj}</td><td>（中継用）期月締切後契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhensyuusyoriymd ztyhensyuusyoriymd}</td><td>（中継用）編集処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjisisyaatukaihyouji ztyjisisyaatukaihyouji}</td><td>（中継用）自支社扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatkisytktntusy1atkihyj ztyaatkisytktntusy1atkihyj}</td><td>（中継用）Ａ扱者地区担当者１扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatkisytktntusy2atkihyj ztyaatkisytktntusy2atkihyj}</td><td>（中継用）Ａ扱者地区担当者２扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatkisyasyokan1atkihyj ztyaatkisyasyokan1atkihyj}</td><td>（中継用）Ａ扱者所管１扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatkisyasyokan2atkihyj ztyaatkisyasyokan2atkihyj}</td><td>（中継用）Ａ扱者所管２扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatkisytktntusy1atkihyj ztybatkisytktntusy1atkihyj}</td><td>（中継用）Ｂ扱者地区担当者１扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatkisytktntusy2atkihyj ztybatkisytktntusy2atkihyj}</td><td>（中継用）Ｂ扱者地区担当者２扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatkisyasyokan1atkihyj ztybatkisyasyokan1atkihyj}</td><td>（中継用）Ｂ扱者所管１扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatkisyasyokan2atkihyj ztybatkisyasyokan2atkihyj}</td><td>（中継用）Ｂ扱者所管２扱表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeizokutyuuihyouji ztykeizokutyuuihyouji}</td><td>（中継用）継続注意表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakubisiteihyouji ztykeiyakubisiteihyouji}</td><td>（中継用）契約日指定表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoukentukihyouji ztyjyoukentukihyouji}</td><td>（中継用）条件付表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuninhyouji ztytokuninhyouji}</td><td>（中継用）特認表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykessantyouseikbn ztykessantyouseikbn}</td><td>（中継用）決算調整区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaneihyouji ztyhaneihyouji}</td><td>（中継用）繁栄表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukinkbn ztysyukinkbn}</td><td>（中継用）集金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakusyasyokugyoucd ztykeiyakusyasyokugyoucd}</td><td>（中継用）契約者職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseikeikeirokbn ztyseikeikeirokbn}</td><td>（中継用）成契経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2seikeikeirokbn ztydai2seikeikeirokbn}</td><td>（中継用）第２成契経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigentokuteisyuruikigou ztyteigentokuteisyuruikigou}</td><td>（中継用）逓減トク定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigentokuteikikan ztyteigentokuteikikan}</td><td>（中継用）逓減トク定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigentokuteis ztyteigentokuteis}</td><td>（中継用）逓減トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyteigentokuteip ztyteigentokuteip}</td><td>（中継用）逓減トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytigntktisdtpdtkbn ztytigntktisdtpdtkbn}</td><td>（中継用）逓減トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigentokuteisyuuseis ztyteigentokuteisyuuseis}</td><td>（中継用）逓減トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyteigentktimodssakugenhyj ztyteigentktimodssakugenhyj}</td><td>（中継用）逓減トク定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigentktikgusdkbn ztyteigentktikgusdkbn}</td><td>（中継用）逓減トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9 ztyyobiv9}</td><td>（中継用）予備項目Ｖ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteibuicdx1 ztytokuteibuicdx1}</td><td>（中継用）特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnpkknx1 ztyhtnpkknx1}</td><td>（中継用）不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteibuicdx2 ztytokuteibuicdx2}</td><td>（中継用）特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnpkknx2 ztyhtnpkknx2}</td><td>（中継用）不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknmei ztyhhknmei}</td><td>（中継用）被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknjhhknmei ztyknjhhknmei}</td><td>（中継用）漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseiymd ztyhhknseiymd}</td><td>（中継用）被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknhnsktodouhukencd ztyhhknhnsktodouhukencd}</td><td>（中継用）被保険者本籍都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyakikykarihyj ztyhihokensyakikykarihyj}</td><td>（中継用）被保険者既契約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynobikkosaimankikbn ztynobikkosaimankikbn}</td><td>（中継用）のびっこ才満期区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsysysnhonninkknnkbn ztyhhknsysysnhonninkknnkbn}</td><td>（中継用）被保険者初診本人確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsysisnhonninkknnkbn ztyhhknsysisnhonninkknnkbn}</td><td>（中継用）被保険者再診本人確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktourokuservicearihyj ztykzktourokuservicearihyj}</td><td>（中継用）家族登録サービス有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x12 ztyyobiv4x12}</td><td>（中継用）予備項目Ｖ４＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhensyuukeiyakusyamei ztyhensyuukeiyakusyamei}</td><td>（中継用）編集契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhnsyuknjkyksynm ztyhnsyuknjkyksynm}</td><td>（中継用）編集漢字契約者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseiymd ztykyksyaseiymd}</td><td>（中継用）契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseikbn ztykyksyaseikbn}</td><td>（中継用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrt ztyknkuzusnzyrt}</td><td>（中継用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvitdoujimos2kenmeikouhyj ztyvitdoujimos2kenmeikouhyj}</td><td>（中継用）Ｖｉｔ同時申込２件目以降表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykikykvitarituikamoshyj ztykikykvitarituikamoshyj}</td><td>（中継用）既契約Ｖｉｔ有追加申込表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykvithokenkbn ztyhtnknkykvithokenkbn}</td><td>（中継用）被転換契約Ｖｉｔ保険区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykikykvithokenhoyuujkkbn ztykikykvithokenhoyuujkkbn}</td><td>（中継用）既契約Ｖｉｔ保険保有状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2x2 ztyyobiv2x2}</td><td>（中継用）予備項目Ｖ２＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsnsknewyno ztytsnsknewyno}</td><td>（中継用）通信先新郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytsnsknewtikucd ztytsnsknewtikucd}</td><td>（中継用）通信先新地区コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymossyumtkktymd ztymossyumtkktymd}</td><td>（中継用）申込消滅確定年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykituenkbn ztykituenkbn}</td><td>（中継用）喫煙区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuusinsakijyuusyokbn ztytuusinsakijyuusyokbn}</td><td>（中継用）通信先住所区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteisyuruikigou ztymaruteisyuruikigou}</td><td>（中継用）マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikikan ztymaruteikikan}</td><td>（中継用）マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteiphrkkkn ztymaruteiphrkkkn}</td><td>（中継用）マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteis ztymaruteis}</td><td>（中継用）マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymaruteip ztymaruteip}</td><td>（中継用）マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymaruteisyuuseis ztymaruteisyuuseis}</td><td>（中継用）マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymaruteisyuuseisskgnhyj ztymaruteisyuuseisskgnhyj}</td><td>（中継用）マル定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteitokujyoukbn ztymaruteitokujyoukbn}</td><td>（中継用）マル定特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtitkjyuskgnkkn ztymrtitkjyuskgnkkn}</td><td>（中継用）マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtitkjyuryumshyutn ztymrtitkjyuryumshyutn}</td><td>（中継用）マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtymaruteitokujyoup ztymaruteitokujyoup}</td><td>（中継用）マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuryumrtipwrbkkbn ztysuryumrtipwrbkkbn}</td><td>（中継用）数理用マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteipwaribikikbn ztymaruteipwaribikikbn}</td><td>（中継用）マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtitnknyugukbn ztymrtitnknyugukbn}</td><td>（中継用）マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikigousedaikbn ztymaruteikigousedaikbn}</td><td>（中継用）マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruteikikousnmnryoage ztymaruteikikousnmnryoage}</td><td>（中継用）マル定更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2 ztyyobiv2}</td><td>（中継用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruyousyuruikigou ztymaruyousyuruikigou}</td><td>（中継用）マル養種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruyoukikan ztymaruyoukikan}</td><td>（中継用）マル養期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruyous ztymaruyous}</td><td>（中継用）マル養Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymaruyoup ztymaruyoup}</td><td>（中継用）マル養Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymaruyousdatepdatekbn ztymaruyousdatepdatekbn}</td><td>（中継用）マル養Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruyousyuuseis ztymaruyousyuuseis}</td><td>（中継用）マル養修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymaruyousyuuseisskgnhyj ztymaruyousyuuseisskgnhyj}</td><td>（中継用）マル養修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymaruyoukigousedaikbn ztymaruyoukigousedaikbn}</td><td>（中継用）マル養記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x3 ztyyobiv9x3}</td><td>（中継用）予備項目Ｖ９＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyuusyuruikigou ztymarusyuusyuruikigou}</td><td>（中継用）マル終種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyuukikan ztymarusyuukikan}</td><td>（中継用）マル終期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyuus ztymarusyuus}</td><td>（中継用）マル終Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymarusyuup ztymarusyuup}</td><td>（中継用）マル終Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymarusyuusdatepdatekbn ztymarusyuusdatepdatekbn}</td><td>（中継用）マル終Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyuusyuuseis ztymarusyuusyuuseis}</td><td>（中継用）マル終修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymarusyuusyuuseisskgnhyj ztymarusyuusyuuseisskgnhyj}</td><td>（中継用）マル終修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymarusyuukigousedaikbn ztymarusyuukigousedaikbn}</td><td>（中継用）マル終記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x4 ztyyobiv9x4}</td><td>（中継用）予備項目Ｖ９＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteisyuruikigou ztytokuteisyuruikigou}</td><td>（中継用）トク定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteikikan ztytokuteikikan}</td><td>（中継用）トク定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteis ztytokuteis}</td><td>（中継用）トク定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokuteip ztytokuteip}</td><td>（中継用）トク定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokuteisdatepdatekbn ztytokuteisdatepdatekbn}</td><td>（中継用）トク定Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteisyuuseis ztytokuteisyuuseis}</td><td>（中継用）トク定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokuteisyuuseisskgnhyj ztytokuteisyuuseisskgnhyj}</td><td>（中継用）トク定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteikigousedaikbn ztytokuteikigousedaikbn}</td><td>（中継用）トク定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x5 ztyyobiv9x5}</td><td>（中継用）予備項目Ｖ９＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitkyknox1 ztykzkmrtitkyknox1}</td><td>（中継用）家族マル定特約番号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtisyuruikgux1 ztykazokumrtisyuruikgux1}</td><td>（中継用）家族マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteikikanx1 ztykazokumaruteikikanx1}</td><td>（中継用）家族マル定期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiphrkkknx1 ztykazokumrtiphrkkknx1}</td><td>（中継用）家族マル定Ｐ払込期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteisx1 ztykazokumaruteisx1}</td><td>（中継用）家族マル定Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteipx1 ztykazokumaruteipx1}</td><td>（中継用）家族マル定Ｐ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyanmx1 ztykzkmrtihihknsyanmx1}</td><td>（中継用）家族マル定被保険者名＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyseiymdx1 ztykzkmrtihihknsyseiymdx1}</td><td>（中継用）家族マル定被保険者生年月日＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsysibtkbnx1 ztykzkmrtihihknsysibtkbnx1}</td><td>（中継用）家族マル定被保険者性別区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtihihknsyaagex1 ztykazokumrtihihknsyaagex1}</td><td>（中継用）家族マル定被保険者年令＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtimodsx1 ztykzkmrtimodsx1}</td><td>（中継用）家族マル定修正Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumrtimodsskgnhyjx1 ztykazokumrtimodsskgnhyjx1}</td><td>（中継用）家族マル定修正Ｓ削減表示＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitnknyugukbnx1 ztykzkmrtitnknyugukbnx1}</td><td>（中継用）家族マル定転換優遇区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtikgusdkbnx1 ztykazokumrtikgusdkbnx1}</td><td>（中継用）家族マル定記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiagetyusihyjx1 ztykazokumrtiagetyusihyjx1}</td><td>（中継用）家族マル定年令調整表示＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikusnmnryoagex1 ztykzkmrtikusnmnryoagex1}</td><td>（中継用）家族マル定更新満了年令＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitkyknox2 ztykzkmrtitkyknox2}</td><td>（中継用）家族マル定特約番号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtisyuruikgux2 ztykazokumrtisyuruikgux2}</td><td>（中継用）家族マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteikikanx2 ztykazokumaruteikikanx2}</td><td>（中継用）家族マル定期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiphrkkknx2 ztykazokumrtiphrkkknx2}</td><td>（中継用）家族マル定Ｐ払込期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteisx2 ztykazokumaruteisx2}</td><td>（中継用）家族マル定Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteipx2 ztykazokumaruteipx2}</td><td>（中継用）家族マル定Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyanmx2 ztykzkmrtihihknsyanmx2}</td><td>（中継用）家族マル定被保険者名＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyseiymdx2 ztykzkmrtihihknsyseiymdx2}</td><td>（中継用）家族マル定被保険者生年月日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsysibtkbnx2 ztykzkmrtihihknsysibtkbnx2}</td><td>（中継用）家族マル定被保険者性別区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtihihknsyaagex2 ztykazokumrtihihknsyaagex2}</td><td>（中継用）家族マル定被保険者年令＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtimodsx2 ztykzkmrtimodsx2}</td><td>（中継用）家族マル定修正Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumrtimodsskgnhyjx2 ztykazokumrtimodsskgnhyjx2}</td><td>（中継用）家族マル定修正Ｓ削減表示＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitnknyugukbnx2 ztykzkmrtitnknyugukbnx2}</td><td>（中継用）家族マル定転換優遇区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtikgusdkbnx2 ztykazokumrtikgusdkbnx2}</td><td>（中継用）家族マル定記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiagetyusihyjx2 ztykazokumrtiagetyusihyjx2}</td><td>（中継用）家族マル定年令調整表示＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikusnmnryoagex2 ztykzkmrtikusnmnryoagex2}</td><td>（中継用）家族マル定更新満了年令＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x2 ztyyobiv4x2}</td><td>（中継用）予備項目Ｖ４＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitkyknox3 ztykzkmrtitkyknox3}</td><td>（中継用）家族マル定特約番号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtisyuruikgux3 ztykazokumrtisyuruikgux3}</td><td>（中継用）家族マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteikikanx3 ztykazokumaruteikikanx3}</td><td>（中継用）家族マル定期間＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiphrkkknx3 ztykazokumrtiphrkkknx3}</td><td>（中継用）家族マル定Ｐ払込期間＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteisx3 ztykazokumaruteisx3}</td><td>（中継用）家族マル定Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteipx3 ztykazokumaruteipx3}</td><td>（中継用）家族マル定Ｐ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyanmx3 ztykzkmrtihihknsyanmx3}</td><td>（中継用）家族マル定被保険者名＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyseiymdx3 ztykzkmrtihihknsyseiymdx3}</td><td>（中継用）家族マル定被保険者生年月日＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsysibtkbnx3 ztykzkmrtihihknsysibtkbnx3}</td><td>（中継用）家族マル定被保険者性別区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtihihknsyaagex3 ztykazokumrtihihknsyaagex3}</td><td>（中継用）家族マル定被保険者年令＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtimodsx3 ztykzkmrtimodsx3}</td><td>（中継用）家族マル定修正Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumrtimodsskgnhyjx3 ztykazokumrtimodsskgnhyjx3}</td><td>（中継用）家族マル定修正Ｓ削減表示＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitnknyugukbnx3 ztykzkmrtitnknyugukbnx3}</td><td>（中継用）家族マル定転換優遇区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtikgusdkbnx3 ztykazokumrtikgusdkbnx3}</td><td>（中継用）家族マル定記号世代区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiagetyusihyjx3 ztykazokumrtiagetyusihyjx3}</td><td>（中継用）家族マル定年令調整表示＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikusnmnryoagex3 ztykzkmrtikusnmnryoagex3}</td><td>（中継用）家族マル定更新満了年令＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x3 ztyyobiv4x3}</td><td>（中継用）予備項目Ｖ４＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitkyknox4 ztykzkmrtitkyknox4}</td><td>（中継用）家族マル定特約番号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtisyuruikgux4 ztykazokumrtisyuruikgux4}</td><td>（中継用）家族マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteikikanx4 ztykazokumaruteikikanx4}</td><td>（中継用）家族マル定期間＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiphrkkknx4 ztykazokumrtiphrkkknx4}</td><td>（中継用）家族マル定Ｐ払込期間＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteisx4 ztykazokumaruteisx4}</td><td>（中継用）家族マル定Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteipx4 ztykazokumaruteipx4}</td><td>（中継用）家族マル定Ｐ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyanmx4 ztykzkmrtihihknsyanmx4}</td><td>（中継用）家族マル定被保険者名＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyseiymdx4 ztykzkmrtihihknsyseiymdx4}</td><td>（中継用）家族マル定被保険者生年月日＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsysibtkbnx4 ztykzkmrtihihknsysibtkbnx4}</td><td>（中継用）家族マル定被保険者性別区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtihihknsyaagex4 ztykazokumrtihihknsyaagex4}</td><td>（中継用）家族マル定被保険者年令＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtimodsx4 ztykzkmrtimodsx4}</td><td>（中継用）家族マル定修正Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumrtimodsskgnhyjx4 ztykazokumrtimodsskgnhyjx4}</td><td>（中継用）家族マル定修正Ｓ削減表示＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitnknyugukbnx4 ztykzkmrtitnknyugukbnx4}</td><td>（中継用）家族マル定転換優遇区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtikgusdkbnx4 ztykazokumrtikgusdkbnx4}</td><td>（中継用）家族マル定記号世代区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiagetyusihyjx4 ztykazokumrtiagetyusihyjx4}</td><td>（中継用）家族マル定年令調整表示＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikusnmnryoagex4 ztykzkmrtikusnmnryoagex4}</td><td>（中継用）家族マル定更新満了年令＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x4 ztyyobiv4x4}</td><td>（中継用）予備項目Ｖ４＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitkyknox5 ztykzkmrtitkyknox5}</td><td>（中継用）家族マル定特約番号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtisyuruikgux5 ztykazokumrtisyuruikgux5}</td><td>（中継用）家族マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteikikanx5 ztykazokumaruteikikanx5}</td><td>（中継用）家族マル定期間＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiphrkkknx5 ztykazokumrtiphrkkknx5}</td><td>（中継用）家族マル定Ｐ払込期間＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteisx5 ztykazokumaruteisx5}</td><td>（中継用）家族マル定Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteipx5 ztykazokumaruteipx5}</td><td>（中継用）家族マル定Ｐ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyanmx5 ztykzkmrtihihknsyanmx5}</td><td>（中継用）家族マル定被保険者名＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyseiymdx5 ztykzkmrtihihknsyseiymdx5}</td><td>（中継用）家族マル定被保険者生年月日＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsysibtkbnx5 ztykzkmrtihihknsysibtkbnx5}</td><td>（中継用）家族マル定被保険者性別区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtihihknsyaagex5 ztykazokumrtihihknsyaagex5}</td><td>（中継用）家族マル定被保険者年令＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtimodsx5 ztykzkmrtimodsx5}</td><td>（中継用）家族マル定修正Ｓ＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumrtimodsskgnhyjx5 ztykazokumrtimodsskgnhyjx5}</td><td>（中継用）家族マル定修正Ｓ削減表示＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitnknyugukbnx5 ztykzkmrtitnknyugukbnx5}</td><td>（中継用）家族マル定転換優遇区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtikgusdkbnx5 ztykazokumrtikgusdkbnx5}</td><td>（中継用）家族マル定記号世代区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiagetyusihyjx5 ztykazokumrtiagetyusihyjx5}</td><td>（中継用）家族マル定年令調整表示＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikusnmnryoagex5 ztykzkmrtikusnmnryoagex5}</td><td>（中継用）家族マル定更新満了年令＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x5 ztyyobiv4x5}</td><td>（中継用）予備項目Ｖ４＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitkyknox6 ztykzkmrtitkyknox6}</td><td>（中継用）家族マル定特約番号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtisyuruikgux6 ztykazokumrtisyuruikgux6}</td><td>（中継用）家族マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteikikanx6 ztykazokumaruteikikanx6}</td><td>（中継用）家族マル定期間＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiphrkkknx6 ztykazokumrtiphrkkknx6}</td><td>（中継用）家族マル定Ｐ払込期間＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteisx6 ztykazokumaruteisx6}</td><td>（中継用）家族マル定Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteipx6 ztykazokumaruteipx6}</td><td>（中継用）家族マル定Ｐ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyanmx6 ztykzkmrtihihknsyanmx6}</td><td>（中継用）家族マル定被保険者名＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyseiymdx6 ztykzkmrtihihknsyseiymdx6}</td><td>（中継用）家族マル定被保険者生年月日＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsysibtkbnx6 ztykzkmrtihihknsysibtkbnx6}</td><td>（中継用）家族マル定被保険者性別区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtihihknsyaagex6 ztykazokumrtihihknsyaagex6}</td><td>（中継用）家族マル定被保険者年令＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtimodsx6 ztykzkmrtimodsx6}</td><td>（中継用）家族マル定修正Ｓ＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumrtimodsskgnhyjx6 ztykazokumrtimodsskgnhyjx6}</td><td>（中継用）家族マル定修正Ｓ削減表示＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitnknyugukbnx6 ztykzkmrtitnknyugukbnx6}</td><td>（中継用）家族マル定転換優遇区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtikgusdkbnx6 ztykazokumrtikgusdkbnx6}</td><td>（中継用）家族マル定記号世代区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiagetyusihyjx6 ztykazokumrtiagetyusihyjx6}</td><td>（中継用）家族マル定年令調整表示＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikusnmnryoagex6 ztykzkmrtikusnmnryoagex6}</td><td>（中継用）家族マル定更新満了年令＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x6 ztyyobiv4x6}</td><td>（中継用）予備項目Ｖ４＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitkyknox7 ztykzkmrtitkyknox7}</td><td>（中継用）家族マル定特約番号＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtisyuruikgux7 ztykazokumrtisyuruikgux7}</td><td>（中継用）家族マル定種類記号＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteikikanx7 ztykazokumaruteikikanx7}</td><td>（中継用）家族マル定期間＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiphrkkknx7 ztykazokumrtiphrkkknx7}</td><td>（中継用）家族マル定Ｐ払込期間＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteisx7 ztykazokumaruteisx7}</td><td>（中継用）家族マル定Ｓ＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteipx7 ztykazokumaruteipx7}</td><td>（中継用）家族マル定Ｐ＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyanmx7 ztykzkmrtihihknsyanmx7}</td><td>（中継用）家族マル定被保険者名＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyseiymdx7 ztykzkmrtihihknsyseiymdx7}</td><td>（中継用）家族マル定被保険者生年月日＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsysibtkbnx7 ztykzkmrtihihknsysibtkbnx7}</td><td>（中継用）家族マル定被保険者性別区分＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtihihknsyaagex7 ztykazokumrtihihknsyaagex7}</td><td>（中継用）家族マル定被保険者年令＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtimodsx7 ztykzkmrtimodsx7}</td><td>（中継用）家族マル定修正Ｓ＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumrtimodsskgnhyjx7 ztykazokumrtimodsskgnhyjx7}</td><td>（中継用）家族マル定修正Ｓ削減表示＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitnknyugukbnx7 ztykzkmrtitnknyugukbnx7}</td><td>（中継用）家族マル定転換優遇区分＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtikgusdkbnx7 ztykazokumrtikgusdkbnx7}</td><td>（中継用）家族マル定記号世代区分＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiagetyusihyjx7 ztykazokumrtiagetyusihyjx7}</td><td>（中継用）家族マル定年令調整表示＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikusnmnryoagex7 ztykzkmrtikusnmnryoagex7}</td><td>（中継用）家族マル定更新満了年令＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x7 ztyyobiv4x7}</td><td>（中継用）予備項目Ｖ４＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitkyknox8 ztykzkmrtitkyknox8}</td><td>（中継用）家族マル定特約番号＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtisyuruikgux8 ztykazokumrtisyuruikgux8}</td><td>（中継用）家族マル定種類記号＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteikikanx8 ztykazokumaruteikikanx8}</td><td>（中継用）家族マル定期間＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiphrkkknx8 ztykazokumrtiphrkkknx8}</td><td>（中継用）家族マル定Ｐ払込期間＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteisx8 ztykazokumaruteisx8}</td><td>（中継用）家族マル定Ｓ＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteipx8 ztykazokumaruteipx8}</td><td>（中継用）家族マル定Ｐ＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyanmx8 ztykzkmrtihihknsyanmx8}</td><td>（中継用）家族マル定被保険者名＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyseiymdx8 ztykzkmrtihihknsyseiymdx8}</td><td>（中継用）家族マル定被保険者生年月日＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsysibtkbnx8 ztykzkmrtihihknsysibtkbnx8}</td><td>（中継用）家族マル定被保険者性別区分＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtihihknsyaagex8 ztykazokumrtihihknsyaagex8}</td><td>（中継用）家族マル定被保険者年令＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtimodsx8 ztykzkmrtimodsx8}</td><td>（中継用）家族マル定修正Ｓ＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumrtimodsskgnhyjx8 ztykazokumrtimodsskgnhyjx8}</td><td>（中継用）家族マル定修正Ｓ削減表示＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitnknyugukbnx8 ztykzkmrtitnknyugukbnx8}</td><td>（中継用）家族マル定転換優遇区分＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtikgusdkbnx8 ztykazokumrtikgusdkbnx8}</td><td>（中継用）家族マル定記号世代区分＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiagetyusihyjx8 ztykazokumrtiagetyusihyjx8}</td><td>（中継用）家族マル定年令調整表示＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikusnmnryoagex8 ztykzkmrtikusnmnryoagex8}</td><td>（中継用）家族マル定更新満了年令＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x8 ztyyobiv4x8}</td><td>（中継用）予備項目Ｖ４＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitkyknox9 ztykzkmrtitkyknox9}</td><td>（中継用）家族マル定特約番号＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtisyuruikgux9 ztykazokumrtisyuruikgux9}</td><td>（中継用）家族マル定種類記号＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteikikanx9 ztykazokumaruteikikanx9}</td><td>（中継用）家族マル定期間＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiphrkkknx9 ztykazokumrtiphrkkknx9}</td><td>（中継用）家族マル定Ｐ払込期間＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteisx9 ztykazokumaruteisx9}</td><td>（中継用）家族マル定Ｓ＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteipx9 ztykazokumaruteipx9}</td><td>（中継用）家族マル定Ｐ＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyanmx9 ztykzkmrtihihknsyanmx9}</td><td>（中継用）家族マル定被保険者名＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyseiymdx9 ztykzkmrtihihknsyseiymdx9}</td><td>（中継用）家族マル定被保険者生年月日＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsysibtkbnx9 ztykzkmrtihihknsysibtkbnx9}</td><td>（中継用）家族マル定被保険者性別区分＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtihihknsyaagex9 ztykazokumrtihihknsyaagex9}</td><td>（中継用）家族マル定被保険者年令＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtimodsx9 ztykzkmrtimodsx9}</td><td>（中継用）家族マル定修正Ｓ＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumrtimodsskgnhyjx9 ztykazokumrtimodsskgnhyjx9}</td><td>（中継用）家族マル定修正Ｓ削減表示＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitnknyugukbnx9 ztykzkmrtitnknyugukbnx9}</td><td>（中継用）家族マル定転換優遇区分＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtikgusdkbnx9 ztykazokumrtikgusdkbnx9}</td><td>（中継用）家族マル定記号世代区分＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiagetyusihyjx9 ztykazokumrtiagetyusihyjx9}</td><td>（中継用）家族マル定年令調整表示＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikusnmnryoagex9 ztykzkmrtikusnmnryoagex9}</td><td>（中継用）家族マル定更新満了年令＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x9 ztyyobiv4x9}</td><td>（中継用）予備項目Ｖ４＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitkyknox10 ztykzkmrtitkyknox10}</td><td>（中継用）家族マル定特約番号＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtisyuruikgux10 ztykazokumrtisyuruikgux10}</td><td>（中継用）家族マル定種類記号＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteikikanx10 ztykazokumaruteikikanx10}</td><td>（中継用）家族マル定期間＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiphrkkknx10 ztykazokumrtiphrkkknx10}</td><td>（中継用）家族マル定Ｐ払込期間＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteisx10 ztykazokumaruteisx10}</td><td>（中継用）家族マル定Ｓ＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumaruteipx10 ztykazokumaruteipx10}</td><td>（中継用）家族マル定Ｐ＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyanmx10 ztykzkmrtihihknsyanmx10}</td><td>（中継用）家族マル定被保険者名＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsyseiymdx10 ztykzkmrtihihknsyseiymdx10}</td><td>（中継用）家族マル定被保険者生年月日＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtihihknsysibtkbnx10 ztykzkmrtihihknsysibtkbnx10}</td><td>（中継用）家族マル定被保険者性別区分＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtihihknsyaagex10 ztykazokumrtihihknsyaagex10}</td><td>（中継用）家族マル定被保険者年令＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtimodsx10 ztykzkmrtimodsx10}</td><td>（中継用）家族マル定修正Ｓ＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykazokumrtimodsskgnhyjx10 ztykazokumrtimodsskgnhyjx10}</td><td>（中継用）家族マル定修正Ｓ削減表示＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtitnknyugukbnx10 ztykzkmrtitnknyugukbnx10}</td><td>（中継用）家族マル定転換優遇区分＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtikgusdkbnx10 ztykazokumrtikgusdkbnx10}</td><td>（中継用）家族マル定記号世代区分＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykazokumrtiagetyusihyjx10 ztykazokumrtiagetyusihyjx10}</td><td>（中継用）家族マル定年令調整表示＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzkmrtikusnmnryoagex10 ztykzkmrtikusnmnryoagex10}</td><td>（中継用）家族マル定更新満了年令＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x10 ztyyobiv4x10}</td><td>（中継用）予備項目Ｖ４＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrtkykhuhokbnx1 ztynkshrtkykhuhokbnx1}</td><td>（中継用）年金支払特約付保区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrtkyknksyuruikbnx1 ztynkshrtkyknksyuruikbnx1}</td><td>（中継用）年金支払特約年金種類区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrtkyknkkknx1 ztynkshrtkyknkkknx1}</td><td>（中継用）年金支払特約年金期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrtkyknknengkx1 ztynkshrtkyknknengkx1}</td><td>（中継用）年金支払特約年金年額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynkshrtkykduketorihhkbnx1 ztynkshrtkykduketorihhkbnx1}</td><td>（中継用）年金支払特約Ｄ受取方法区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10 ztyyobiv10}</td><td>（中継用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrtkykhuhokbnx2 ztynkshrtkykhuhokbnx2}</td><td>（中継用）年金支払特約付保区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrtkyknksyuruikbnx2 ztynkshrtkyknksyuruikbnx2}</td><td>（中継用）年金支払特約年金種類区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrtkyknkkknx2 ztynkshrtkyknkkknx2}</td><td>（中継用）年金支払特約年金期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynkshrtkyknknengkx2 ztynkshrtkyknknengkx2}</td><td>（中継用）年金支払特約年金年額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynkshrtkykduketorihhkbnx2 ztynkshrtkykduketorihhkbnx2}</td><td>（中継用）年金支払特約Ｄ受取方法区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x2 ztyyobiv10x2}</td><td>（中継用）予備項目Ｖ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyougaitkyksyuruikgu ztysyougaitkyksyuruikgu}</td><td>（中継用）傷害特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyougaitokuyakukikan ztysyougaitokuyakukikan}</td><td>（中継用）傷害特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyougaitkykphrkkkn ztysyougaitkykphrkkkn}</td><td>（中継用）傷害特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyougaitokuyakus ztysyougaitokuyakus}</td><td>（中継用）傷害特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyougaitokuyakup ztysyougaitokuyakup}</td><td>（中継用）傷害特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyougaitkkatakbn ztysyougaitkkatakbn}</td><td>（中継用）傷害特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyougaitkykkgusdkbn ztysyougaitkykkgusdkbn}</td><td>（中継用）傷害特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyugitkykpwrbkkbn ztysyugitkykpwrbkkbn}</td><td>（中継用）傷害特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyougaitkykkusnmnryoage ztysyougaitkykkusnmnryoage}</td><td>（中継用）傷害特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv5x2 ztyyobiv5x2}</td><td>（中継用）予備項目Ｖ５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysigiwrmstkyksyuruikgu ztysigiwrmstkyksyuruikgu}</td><td>（中継用）災害割増特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysigiwrmstkykkkn ztysigiwrmstkykkkn}</td><td>（中継用）災害割増特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaigaiwrmstkykphrkkkn ztysaigaiwrmstkykphrkkkn}</td><td>（中継用）災害割増特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaigaiwarimasitokuyakus ztysaigaiwarimasitokuyakus}</td><td>（中継用）災害割増特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaigaiwarimasitokuyakup ztysaigaiwarimasitokuyakup}</td><td>（中継用）災害割増特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaigaiwrmstkykkgusdkbn ztysaigaiwrmstkykkgusdkbn}</td><td>（中継用）災害割増特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysigiwrmstkykpwrbkkbn ztysigiwrmstkykpwrbkkbn}</td><td>（中継用）災害割増特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysigiwrmstkykkusnmnryoage ztysigiwrmstkykkusnmnryoage}</td><td>（中継用）災害割増特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv5x3 ztyyobiv5x3}</td><td>（中継用）予備項目Ｖ５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkyksyuruikgu ztysiginyuintkyksyuruikgu}</td><td>（中継用）災害入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkykkkn ztysiginyuintkykkkn}</td><td>（中継用）災害入院特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaigainyuintkykphrkkkn ztysaigainyuintkykphrkkkn}</td><td>（中継用）災害入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkykntgk ztysiginyuintkykntgk}</td><td>（中継用）災害入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkykgtkbn ztysiginyuintkykgtkbn}</td><td>（中継用）災害入院特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaigainyuuintokuyakup ztysaigainyuuintokuyakup}</td><td>（中継用）災害入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaigainyuintkykkgusdkbn ztysaigainyuintkykkgusdkbn}</td><td>（中継用）災害入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiginyuintkykpwrbkkbn ztysiginyuintkykpwrbkkbn}</td><td>（中継用）災害入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7 ztyyobiv7}</td><td>（中継用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkyksyuruikgu ztysppinyuintkyksyuruikgu}</td><td>（中継用）疾病入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkykkkn ztysppinyuintkykkkn}</td><td>（中継用）疾病入院特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuuintkykphrkkkn ztysppinyuuintkykphrkkkn}</td><td>（中継用）疾病入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkykntgk ztysppinyuintkykntgk}</td><td>（中継用）疾病入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkykgtkbn ztysppinyuintkykgtkbn}</td><td>（中継用）疾病入院特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysippeinyuuintokuyakup ztysippeinyuuintokuyakup}</td><td>（中継用）疾病入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkjyuryumshyutn ztysppinyuintkjyuryumshyutn}</td><td>（中継用）疾病入院特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysippeinyuuintokujyoup ztysippeinyuuintokujyoup}</td><td>（中継用）疾病入院特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysppinyuintktbicdx1 ztysppinyuintktbicdx1}</td><td>（中継用）疾病入院特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuinhtnpkknx1 ztysppinyuinhtnpkknx1}</td><td>（中継用）疾病入院不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintktbicdx2 ztysppinyuintktbicdx2}</td><td>（中継用）疾病入院特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuinhtnpkknx2 ztysppinyuinhtnpkknx2}</td><td>（中継用）疾病入院不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuuintkykkgusdkbn ztysppinyuuintkykkgusdkbn}</td><td>（中継用）疾病入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysppinyuintkykpwrbkkbn ztysppinyuintkykpwrbkkbn}</td><td>（中継用）疾病入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv7x2 ztyyobiv7x2}</td><td>（中継用）予備項目Ｖ７＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkyksyuruikgu ztysijnbyutkyksyuruikgu}</td><td>（中継用）成人病特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseijinbyoutokuyakukikan ztyseijinbyoutokuyakukikan}</td><td>（中継用）成人病特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseijinbyoutkykphrkkkn ztyseijinbyoutkykphrkkkn}</td><td>（中継用）成人病特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseijinbyoutokuyakuntgk ztyseijinbyoutokuyakuntgk}</td><td>（中継用）成人病特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyseijinbyoutokuyakup ztyseijinbyoutokuyakup}</td><td>（中継用）成人病特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkjyuryumshyutn ztysijnbyutkjyuryumshyutn}</td><td>（中継用）成人病特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyseijinbyoutokujyoup ztyseijinbyoutokujyoup}</td><td>（中継用）成人病特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyseijinbyoutokuteibuicdx1 ztyseijinbyoutokuteibuicdx1}</td><td>（中継用）成人病特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseijinbyouhutanpokikanx1 ztyseijinbyouhutanpokikanx1}</td><td>（中継用）成人病不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseijinbyoutokuteibuicdx2 ztyseijinbyoutokuteibuicdx2}</td><td>（中継用）成人病特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseijinbyouhutanpokikanx2 ztyseijinbyouhutanpokikanx2}</td><td>（中継用）成人病不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseijinbyoutkykkgusdkbn ztyseijinbyoutkykkgusdkbn}</td><td>（中継用）成人病特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkykgankyuhgtkbn ztysijnbyutkykgankyuhgtkbn}</td><td>（中継用）成人病特約ガン給付型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkykpwrbkkbn ztysijnbyutkykpwrbkkbn}</td><td>（中継用）成人病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysijnbyutkykkusnmnryoage ztysijnbyutkykkusnmnryoage}</td><td>（中継用）成人病特約更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4x11 ztyyobiv4x11}</td><td>（中継用）予備項目Ｖ４＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyheiyoubaraikbn ztyheiyoubaraikbn}</td><td>（中継用）併用払区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhiyubriaitsyono ztyhiyubriaitsyono}</td><td>（中継用）併用払相手証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhiyubriaithrkkeirokbn ztyhiyubriaithrkkeirokbn}</td><td>（中継用）併用払相手払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyheiyoubaraiaitekihons ztyheiyoubaraiaitekihons}</td><td>（中継用）併用払相手基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhiyubrigukitnknitjbrkhns ztyhiyubrigukitnknitjbrkhns}</td><td>（中継用）併用払合計転換一時払基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyheiyoubaraiaitesibous ztyheiyoubaraiaitesibous}</td><td>（中継用）併用払相手死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhiyubrigukitnknitjbrsbus ztyhiyubrigukitnknitjbrsbus}</td><td>（中継用）併用払合計転換一時払死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyheiyoubaraiaitesyuuseis ztyheiyoubaraiaitesyuuseis}</td><td>（中継用）併用払相手修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyheiyoubaraiaitehrkp ztyheiyoubaraiaitehrkp}</td><td>（中継用）併用払相手払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhiyubriaitsykykp ztyhiyubriaitsykykp}</td><td>（中継用）併用払相手主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyheiyoubaraiaitemrtis ztyheiyoubaraiaitemrtis}</td><td>（中継用）併用払相手マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhiyubrigukiaitkzkmrtis ztyhiyubrigukiaitkzkmrtis}</td><td>（中継用）併用払合計相手家族マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytukibaraikyktenkanhyj ztytukibaraikyktenkanhyj}</td><td>（中継用）月払契約転換表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybonusharaihrkkigetu1 ztybonusharaihrkkigetu1}</td><td>（中継用）ボーナス払払込期月１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybonusharaihrkkigetu2 ztybonusharaihrkkigetu2}</td><td>（中継用）ボーナス払払込期月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhiyubriaitsiznmrtis ztyhiyubriaitsiznmrtis}</td><td>（中継用）併用払相手生存マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhiyubriaittignmrtis ztyhiyubriaittignmrtis}</td><td>（中継用）併用払相手逓減マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkjykbn ztytkjykbn}</td><td>（中継用）特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakugenkikan ztysakugenkikan}</td><td>（中継用）削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryoumasihyouten ztyryoumasihyouten}</td><td>（中継用）料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytokujyoup ztytokujyoup}</td><td>（中継用）特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhjncd ztyhjncd}</td><td>（中継用）法人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnjigyosyocd ztyhjnjigyosyocd}</td><td>（中継用）法人事業所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyuugyouinsuu ztyjyuugyouinsuu}</td><td>（中継用）従業員数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyiktkaisuu ztyiktkaisuu}</td><td>（中継用）一括回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyznnkai ztyznnkai}</td><td>（中継用）前納回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktsnatkitkykkbn ztykyktsnatkitkykkbn}</td><td>（中継用）契約通算扱特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyktsnatkitkykstagekbn ztykyktsnatkitkykstagekbn}</td><td>（中継用）契約通算扱特約ステージ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmentokuyakukbn ztypmentokuyakukbn}</td><td>（中継用）Ｐ免特約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3 ztyyobiv3}</td><td>（中継用）予備項目Ｖ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkykznnunyukngk ztytkykznnunyukngk}</td><td>（中継用）特約前納入金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyokaipnyuukinhouhoukbn ztysyokaipnyuukinhouhoukbn}</td><td>（中継用）初回Ｐ入金方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksyonox1 ztyhtnknkyksyonox1}</td><td>（中継用）被転換契約証券番号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknsyuruikgux1 ztyhtnknkykhknsyuruikgux1}</td><td>（中継用）被転換契約保険種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanuketukeymdx1 ztytenkanuketukeymdx1}</td><td>（中継用）転換受付年月日＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkykymdx1 ztyhtnknkykkykymdx1}</td><td>（中継用）被転換契約契約年月日＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknkknx1 ztyhtnknkykhknkknx1}</td><td>（中継用）被転換契約保険期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykphrkkknx1 ztyhtnknkykphrkkknx1}</td><td>（中継用）被転換契約Ｐ払込期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkaisuukbnx1 ztyhtnknkykhrkkaisuukbnx1}</td><td>（中継用）被転換契約払込回数区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkeirokbnx1 ztyhtnknkykhrkkeirokbnx1}</td><td>（中継用）被転換契約払込経路区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknuktkzngtkijyuhyjx1 ztytnknuktkzngtkijyuhyjx1}</td><td>（中継用）転換受付前月計上表示＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykmrtisyuruikgux1 ztyhtnknkykmrtisyuruikgux1}</td><td>（中継用）被転換契約マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksyonox2 ztyhtnknkyksyonox2}</td><td>（中継用）被転換契約証券番号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknsyuruikgux2 ztyhtnknkykhknsyuruikgux2}</td><td>（中継用）被転換契約保険種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanuketukeymdx2 ztytenkanuketukeymdx2}</td><td>（中継用）転換受付年月日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkykymdx2 ztyhtnknkykkykymdx2}</td><td>（中継用）被転換契約契約年月日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknkknx2 ztyhtnknkykhknkknx2}</td><td>（中継用）被転換契約保険期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykphrkkknx2 ztyhtnknkykphrkkknx2}</td><td>（中継用）被転換契約Ｐ払込期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkaisuukbnx2 ztyhtnknkykhrkkaisuukbnx2}</td><td>（中継用）被転換契約払込回数区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkeirokbnx2 ztyhtnknkykhrkkeirokbnx2}</td><td>（中継用）被転換契約払込経路区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknuktkzngtkijyuhyjx2 ztytnknuktkzngtkijyuhyjx2}</td><td>（中継用）転換受付前月計上表示＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykmrtisyuruikgux2 ztyhtnknkykmrtisyuruikgux2}</td><td>（中継用）被転換契約マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksyonox3 ztyhtnknkyksyonox3}</td><td>（中継用）被転換契約証券番号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknsyuruikgux3 ztyhtnknkykhknsyuruikgux3}</td><td>（中継用）被転換契約保険種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanuketukeymdx3 ztytenkanuketukeymdx3}</td><td>（中継用）転換受付年月日＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkykymdx3 ztyhtnknkykkykymdx3}</td><td>（中継用）被転換契約契約年月日＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknkknx3 ztyhtnknkykhknkknx3}</td><td>（中継用）被転換契約保険期間＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykphrkkknx3 ztyhtnknkykphrkkknx3}</td><td>（中継用）被転換契約Ｐ払込期間＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkaisuukbnx3 ztyhtnknkykhrkkaisuukbnx3}</td><td>（中継用）被転換契約払込回数区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkeirokbnx3 ztyhtnknkykhrkkeirokbnx3}</td><td>（中継用）被転換契約払込経路区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknuktkzngtkijyuhyjx3 ztytnknuktkzngtkijyuhyjx3}</td><td>（中継用）転換受付前月計上表示＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykmrtisyuruikgux3 ztyhtnknkykmrtisyuruikgux3}</td><td>（中継用）被転換契約マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksyonox4 ztyhtnknkyksyonox4}</td><td>（中継用）被転換契約証券番号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknsyuruikgux4 ztyhtnknkykhknsyuruikgux4}</td><td>（中継用）被転換契約保険種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanuketukeymdx4 ztytenkanuketukeymdx4}</td><td>（中継用）転換受付年月日＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkykymdx4 ztyhtnknkykkykymdx4}</td><td>（中継用）被転換契約契約年月日＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknkknx4 ztyhtnknkykhknkknx4}</td><td>（中継用）被転換契約保険期間＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykphrkkknx4 ztyhtnknkykphrkkknx4}</td><td>（中継用）被転換契約Ｐ払込期間＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkaisuukbnx4 ztyhtnknkykhrkkaisuukbnx4}</td><td>（中継用）被転換契約払込回数区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkeirokbnx4 ztyhtnknkykhrkkeirokbnx4}</td><td>（中継用）被転換契約払込経路区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknuktkzngtkijyuhyjx4 ztytnknuktkzngtkijyuhyjx4}</td><td>（中継用）転換受付前月計上表示＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykmrtisyuruikgux4 ztyhtnknkykmrtisyuruikgux4}</td><td>（中継用）被転換契約マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksyonox5 ztyhtnknkyksyonox5}</td><td>（中継用）被転換契約証券番号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknsyuruikgux5 ztyhtnknkykhknsyuruikgux5}</td><td>（中継用）被転換契約保険種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanuketukeymdx5 ztytenkanuketukeymdx5}</td><td>（中継用）転換受付年月日＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkykymdx5 ztyhtnknkykkykymdx5}</td><td>（中継用）被転換契約契約年月日＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknkknx5 ztyhtnknkykhknkknx5}</td><td>（中継用）被転換契約保険期間＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykphrkkknx5 ztyhtnknkykphrkkknx5}</td><td>（中継用）被転換契約Ｐ払込期間＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkaisuukbnx5 ztyhtnknkykhrkkaisuukbnx5}</td><td>（中継用）被転換契約払込回数区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkeirokbnx5 ztyhtnknkykhrkkeirokbnx5}</td><td>（中継用）被転換契約払込経路区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknuktkzngtkijyuhyjx5 ztytnknuktkzngtkijyuhyjx5}</td><td>（中継用）転換受付前月計上表示＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykmrtisyuruikgux5 ztyhtnknkykmrtisyuruikgux5}</td><td>（中継用）被転換契約マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksyonox6 ztyhtnknkyksyonox6}</td><td>（中継用）被転換契約証券番号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknsyuruikgux6 ztyhtnknkykhknsyuruikgux6}</td><td>（中継用）被転換契約保険種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanuketukeymdx6 ztytenkanuketukeymdx6}</td><td>（中継用）転換受付年月日＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkykymdx6 ztyhtnknkykkykymdx6}</td><td>（中継用）被転換契約契約年月日＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhknkknx6 ztyhtnknkykhknkknx6}</td><td>（中継用）被転換契約保険期間＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykphrkkknx6 ztyhtnknkykphrkkknx6}</td><td>（中継用）被転換契約Ｐ払込期間＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkaisuukbnx6 ztyhtnknkykhrkkaisuukbnx6}</td><td>（中継用）被転換契約払込回数区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhrkkeirokbnx6 ztyhtnknkykhrkkeirokbnx6}</td><td>（中継用）被転換契約払込経路区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknuktkzngtkijyuhyjx6 ztytnknuktkzngtkijyuhyjx6}</td><td>（中継用）転換受付前月計上表示＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykmrtisyuruikgux6 ztyhtnknkykmrtisyuruikgux6}</td><td>（中継用）被転換契約マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygukihtnknkykkhns ztygukihtnknkykkhns}</td><td>（中継用）合計被転換契約基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukihtnknkyksbus ztygukihtnknkyksbus}</td><td>（中継用）合計被転換契約死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukihtnknkykhntiyup ztygukihtnknkykhntiyup}</td><td>（中継用）合計被転換契約判定用Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukihtnknkyksigwrmstkyks ztygukihtnknkyksigwrmstkyks}</td><td>（中継用）合計被転換契約災害割増特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukihtnknkyksyugitkyks ztygukihtnknkyksyugitkyks}</td><td>（中継用）合計被転換契約傷害特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukihtnknsignyintkykntgk ztygukihtnknsignyintkykntgk}</td><td>（中継用）合計被転換災害入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtygukihtnknknkutkykntgk ztygukihtnknknkutkykntgk}</td><td>（中継用）合計被転換健康特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtygukihtnknkykmods ztygukihtnknkykmods}</td><td>（中継用）合計被転換契約修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkankakaku ztygoukeitenkankakaku}</td><td>（中継用）合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukitnknjsknnjynbkn ztygukitnknjsknnjynbkn}</td><td>（中継用）合計転換時責任準備金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukitnknsisnkstkkngk ztygukitnknsisnkstkkngk}</td><td>（中継用）合計転換精算貸付金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukitnknsisnttkekngk ztygukitnknsisnttkekngk}</td><td>（中継用）合計転換精算立替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkanseisand ztygoukeitenkanseisand}</td><td>（中継用）合計転換精算Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukitnknsisnmkikp ztygukitnknsisnmkikp}</td><td>（中継用）合計転換精算未経過Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukitnknsisnsntkngk ztygukitnknsisnsntkngk}</td><td>（中継用）合計転換精算その他金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukitnknkhnbbnkiykkujygk ztygukitnknkhnbbnkiykkujygk}</td><td>（中継用）合計転換基本部分解約控除額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukitnkntikbbnkiykkujygk ztygukitnkntikbbnkiykkujygk}</td><td>（中継用）合計転換定期部分解約控除額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygukitnknitjbrtiks ztygukitnknitjbrtiks}</td><td>（中継用）合計転換一時払定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysethokenno ztysethokenno}</td><td>（中継用）セット保険番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysckbn ztysckbn}</td><td>（中継用）ＳＣ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyenjyosyacd ztyenjyosyacd}</td><td>（中継用）援助者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynaibuwarimodosigaku ztynaibuwarimodosigaku}</td><td>（中継用）内部割戻額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeiyakukakuninsyuruikbn ztykeiyakukakuninsyuruikbn}</td><td>（中継用）契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysoujikeitenkanhyouji ztysoujikeitenkanhyouji}</td><td>（中継用）相似形転換表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanjisketteihouhoukbn ztytenkanjisketteihouhoukbn}</td><td>（中継用）転換時Ｓ決定方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeikanensuukbn ztykeikanensuukbn}</td><td>（中継用）経過年数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhhknsytisyukbnx1 ztyhtnknkykhhknsytisyukbnx1}</td><td>（中継用）被転換契約被保険者対象区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhhknsytisyukbnx2 ztyhtnknkykhhknsytisyukbnx2}</td><td>（中継用）被転換契約被保険者対象区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhhknsytisyukbnx3 ztyhtnknkykhhknsytisyukbnx3}</td><td>（中継用）被転換契約被保険者対象区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhhknsytisyukbnx4 ztyhtnknkykhhknsytisyukbnx4}</td><td>（中継用）被転換契約被保険者対象区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhhknsytisyukbnx5 ztyhtnknkykhhknsytisyukbnx5}</td><td>（中継用）被転換契約被保険者対象区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykhhknsytisyukbnx6 ztyhtnknkykhhknsytisyukbnx6}</td><td>（中継用）被転換契約被保険者対象区分＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykktijgukipbbntnkns ztykktijgukipbbntnkns}</td><td>（中継用）確定時合計Ｐ部分転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyonendosyokaip ztysyonendosyokaip}</td><td>（中継用）初年度初回Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyonendo2kaimeikoup ztysyonendo2kaimeikoup}</td><td>（中継用）初年度２回目以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjinendoikoup ztyjinendoikoup}</td><td>（中継用）次年度以降Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusikyuukisogaku ztysyukeiyakusikyuukisogaku}</td><td>（中継用）主契約支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysykyknenhantatskyuksgk ztysykyknenhantatskyuksgk}</td><td>（中継用）主契約年半手当支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtymaruteisikyuukisogaku ztymaruteisikyuukisogaku}</td><td>（中継用）マル定支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyitjbrzugkskyuksgkx1 ztyitjbrzugkskyuksgkx1}</td><td>（中継用）一時払増額支給基礎額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyitjbrzugkskyuksgkx2 ztyitjbrzugkskyuksgkx2}</td><td>（中継用）一時払増額支給基礎額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyitjbrzgknnhntatskyksgkx1 ztyitjbrzgknnhntatskyksgkx1}</td><td>（中継用）一時払増額年半手当支給基礎額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyitjbrzgknnhntatskyksgkx2 ztyitjbrzgknnhntatskyksgkx2}</td><td>（中継用）一時払増額年半手当支給基礎額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtykzkmrtiskyuksgk ztykzkmrtiskyuksgk}</td><td>（中継用）家族マル定支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyitibitjbrskyuksgk ztyitibitjbrskyuksgk}</td><td>（中継用）一部一時払支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyitbitjbrnnhntatskyuksgk ztyitbitjbrnnhntatskyuksgk}</td><td>（中継用）一部一時払年半手当支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysykykksnbsyutat ztysykykksnbsyutat}</td><td>（中継用）主契約加算募集手当</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyitjbrzugkksnbsyutatx1 ztyitjbrzugkksnbsyutatx1}</td><td>（中継用）一時払増額加算募集手当＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyitjbrzugkksnbsyutatx2 ztyitjbrzugkksnbsyutatx2}</td><td>（中継用）一時払増額加算募集手当＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyitibitjbrksnbsyutat ztyitibitjbrksnbsyutat}</td><td>（中継用）一部一時払加算募集手当</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyjyunkensuu ztyjyunkensuu}</td><td>（中継用）純件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykansankensuu ztykansankensuu}</td><td>（中継用）換算件数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraikikan ztyitibuitijibaraikikan}</td><td>（中継用）一部一時払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibarais ztyitibuitijibarais}</td><td>（中継用）一部一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraip ztyitibuitijibaraip}</td><td>（中継用）一部一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibitjbrsdtpdtkbn ztyitibitjbrsdtpdtkbn}</td><td>（中継用）一部一時払Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraisyuuseis ztyitibuitijibaraisyuuseis}</td><td>（中継用）一部一時払修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibitjbrmodsskgnhyj ztyitibitjbrmodsskgnhyj}</td><td>（中継用）一部一時払修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyousyoriym ztysuuriyousyoriym}</td><td>（中継用）数理用処理年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyosinsinsahouhoukbn ztysyosinsinsahouhoukbn}</td><td>（中継用）初診診査方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisinsinsahouhoukbn ztysaisinsinsahouhoukbn}</td><td>（中継用）再診診査方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmrtisyuruikgu ztyseizonmrtisyuruikgu}</td><td>（中継用）生存マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmaruteikikan ztyseizonmaruteikikan}</td><td>（中継用）生存マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmrtiphrkkkn ztyseizonmrtiphrkkkn}</td><td>（中継用）生存マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmaruteis ztyseizonmaruteis}</td><td>（中継用）生存マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyseizonmaruteip ztyseizonmaruteip}</td><td>（中継用）生存マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyseizonmaruteisyuuseis ztyseizonmaruteisyuuseis}</td><td>（中継用）生存マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyseizonmrtimodsskgnhyj ztyseizonmrtimodsskgnhyj}</td><td>（中継用）生存マル定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtitkjyukbn ztysiznmrtitkjyukbn}</td><td>（中継用）生存マル定特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtitkjyuskgnkkn ztysiznmrtitkjyuskgnkkn}</td><td>（中継用）生存マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtitkjyuryumshyutn ztysiznmrtitkjyuryumshyutn}</td><td>（中継用）生存マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysiznmrtitkjyup ztysiznmrtitkjyup}</td><td>（中継用）生存マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiznmrtiskyuksgk ztysiznmrtiskyuksgk}</td><td>（中継用）生存マル定支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiznmrtsyrikgux1 ztyhtnknkyksiznmrtsyrikgux1}</td><td>（中継用）被転換契約生存マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiznmrtsyrikgux2 ztyhtnknkyksiznmrtsyrikgux2}</td><td>（中継用）被転換契約生存マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiznmrtsyrikgux3 ztyhtnknkyksiznmrtsyrikgux3}</td><td>（中継用）被転換契約生存マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiznmrtsyrikgux4 ztyhtnknkyksiznmrtsyrikgux4}</td><td>（中継用）被転換契約生存マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiznmrtsyrikgux5 ztyhtnknkyksiznmrtsyrikgux5}</td><td>（中継用）被転換契約生存マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyksiznmrtsyrikgux6 ztyhtnknkyksiznmrtsyrikgux6}</td><td>（中継用）被転換契約生存マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuryusiznmrtipwrbkkbn ztysuryusiznmrtipwrbkkbn}</td><td>（中継用）数理用生存マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtipwrbkkbn ztysiznmrtipwrbkkbn}</td><td>（中継用）生存マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiznmrtitnknyugukbn ztysiznmrtitnknyugukbn}</td><td>（中継用）生存マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonmrtikgusdkbn ztyseizonmrtikgusdkbn}</td><td>（中継用）生存マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1 ztyyobiv1}</td><td>（中継用）予備項目Ｖ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyamei ztydai2hihokensyamei}</td><td>（中継用）第２被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2kanjihihokensyamei ztydai2kanjihihokensyamei}</td><td>（中継用）第２漢字被保険者名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyaseiymd ztydai2hihokensyaseiymd}</td><td>（中継用）第２被保険者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyaseibetukbn ztydai2hihokensyaseibetukbn}</td><td>（中継用）第２被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihknsyahnskhkncd ztydai2hihknsyahnskhkncd}</td><td>（中継用）第２被保険者本籍府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnen ztydai2hhknnen}</td><td>（中継用）第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihknsyakikykarihyj ztydai2hihknsyakikykarihyj}</td><td>（中継用）第２被保険者既契約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksydi2hihknsyaduithyj ztykyksydi2hihknsyaduithyj}</td><td>（中継用）契約者第２被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2syosinsinsahouhoukbn ztydai2syosinsinsahouhoukbn}</td><td>（中継用）第２初診診査方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2saisinsinsahouhoukbn ztydai2saisinsinsahouhoukbn}</td><td>（中継用）第２再診診査方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2syokugyoucd ztydai2syokugyoucd}</td><td>（中継用）第２職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2sakugenkikan ztydai2sakugenkikan}</td><td>（中継用）第２削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2ryoumasihyouten ztydai2ryoumasihyouten}</td><td>（中継用）第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtymrtidi2skgnkkn ztymrtidi2skgnkkn}</td><td>（中継用）マル定第２削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrtidi2ryumshyutn ztymrtidi2ryumshyutn}</td><td>（中継用）マル定第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydi2kykkknnsyrikbn ztydi2kykkknnsyrikbn}</td><td>（中継用）第２契約確認種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtidi2skgnkkn ztytignmrtidi2skgnkkn}</td><td>（中継用）逓減マル定第２削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtidi2ryumshyutn ztytignmrtidi2ryumshyutn}</td><td>（中継用）逓減マル定第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2syosinhonninkknnkbn ztydai2syosinhonninkknnkbn}</td><td>（中継用）第２初診本人確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sisnhonninkknnkbn ztydi2sisnhonninkknnkbn}</td><td>（中継用）第２再診本人確認区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x6 ztyyobiv9x6}</td><td>（中継用）予備項目Ｖ９＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2syugitkyksyrikgu ztydi2syugitkyksyrikgu}</td><td>（中継用）第２傷害特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2syougaitokuyakukikan ztydai2syougaitokuyakukikan}</td><td>（中継用）第２傷害特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2syugitkykphrkkkn ztydi2syugitkykphrkkkn}</td><td>（中継用）第２傷害特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2syougaitokuyakus ztydai2syougaitokuyakus}</td><td>（中継用）第２傷害特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydai2syougaitokuyakup ztydai2syougaitokuyakup}</td><td>（中継用）第２傷害特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2syugitkykgtkbn ztydi2syugitkykgtkbn}</td><td>（中継用）第２傷害特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2syugitkykkgusdkbn ztydi2syugitkykkgusdkbn}</td><td>（中継用）第２傷害特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2syugitkykpwrbkkbn ztydi2syugitkykpwrbkkbn}</td><td>（中継用）第２傷害特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8 ztyyobiv8}</td><td>（中継用）予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkyksyrikgu ztydi2sigiwrmstkyksyrikgu}</td><td>（中継用）第２災害割増特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkykkkn ztydi2sigiwrmstkykkkn}</td><td>（中継用）第２災害割増特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkykphrkkkn ztydi2sigiwrmstkykphrkkkn}</td><td>（中継用）第２災害割増特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkyks ztydi2sigiwrmstkyks}</td><td>（中継用）第２災害割増特約Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkykp ztydi2sigiwrmstkykp}</td><td>（中継用）第２災害割増特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkykkgusdkbn ztydi2sigiwrmstkykkgusdkbn}</td><td>（中継用）第２災害割増特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sigiwrmstkykpwrbkkbn ztydi2sigiwrmstkykpwrbkkbn}</td><td>（中継用）第２災害割増特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x7 ztyyobiv9x7}</td><td>（中継用）予備項目Ｖ９＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkyksyrikgu ztydi2siginyuintkyksyrikgu}</td><td>（中継用）第２災害入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykkkn ztydi2siginyuintkykkkn}</td><td>（中継用）第２災害入院特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykphrkkkn ztydi2siginyuintkykphrkkkn}</td><td>（中継用）第２災害入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykntgk ztydi2siginyuintkykntgk}</td><td>（中継用）第２災害入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykp ztydi2siginyuintkykp}</td><td>（中継用）第２災害入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykgtkbn ztydi2siginyuintkykgtkbn}</td><td>（中継用）第２災害入院特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyintkykkgusdkbn ztydi2siginyintkykkgusdkbn}</td><td>（中継用）第２災害入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2siginyuintkykpwrbkkbn ztydi2siginyuintkykpwrbkkbn}</td><td>（中継用）第２災害入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x3 ztyyobiv10x3}</td><td>（中継用）予備項目Ｖ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkyksyrikgu ztydi2sppinyuintkyksyrikgu}</td><td>（中継用）第２疾病入院特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykkkn ztydi2sppinyuintkykkkn}</td><td>（中継用）第２疾病入院特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykphrkkkn ztydi2sppinyuintkykphrkkkn}</td><td>（中継用）第２疾病入院特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykntgk ztydi2sppinyuintkykntgk}</td><td>（中継用）第２疾病入院特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykp ztydi2sppinyuintkykp}</td><td>（中継用）第２疾病入院特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykgtkbn ztydi2sppinyuintkykgtkbn}</td><td>（中継用）第２疾病入院特約型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyintkjyryumshytn ztydi2sppinyintkjyryumshytn}</td><td>（中継用）第２疾病入院特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkjyup ztydi2sppinyuintkjyup}</td><td>（中継用）第２疾病入院特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintktbicdx1 ztydi2sppinyuintktbicdx1}</td><td>（中継用）第２疾病入院特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuinhtnpkknx1 ztydi2sppinyuinhtnpkknx1}</td><td>（中継用）第２疾病入院不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintktbicdx2 ztydi2sppinyuintktbicdx2}</td><td>（中継用）第２疾病入院特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuinhtnpkknx2 ztydi2sppinyuinhtnpkknx2}</td><td>（中継用）第２疾病入院不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyintkykkgusdkbn ztydi2sppinyintkykkgusdkbn}</td><td>（中継用）第２疾病入院特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sppinyuintkykpwrbkkbn ztydi2sppinyuintkykpwrbkkbn}</td><td>（中継用）第２疾病入院特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3x2 ztyyobiv3x2}</td><td>（中継用）予備項目Ｖ３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkyksyrikgu ztydi2sijnbyutkyksyrikgu}</td><td>（中継用）第２成人病特約種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkykkkn ztydi2sijnbyutkykkkn}</td><td>（中継用）第２成人病特約期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkykphrkkkn ztydi2sijnbyutkykphrkkkn}</td><td>（中継用）第２成人病特約Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkykntgk ztydi2sijnbyutkykntgk}</td><td>（中継用）第２成人病特約日額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2seijinbyoutokuyakup ztydai2seijinbyoutokuyakup}</td><td>（中継用）第２成人病特約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkjyurymshytn ztydi2sijnbyutkjyurymshytn}</td><td>（中継用）第２成人病特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydai2seijinbyoutokujyoup ztydai2seijinbyoutokujyoup}</td><td>（中継用）第２成人病特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutktbicdx1 ztydi2sijnbyutktbicdx1}</td><td>（中継用）第２成人病特定部位コード＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyuhtnpkknx1 ztydi2sijnbyuhtnpkknx1}</td><td>（中継用）第２成人病不担保期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutktbicdx2 ztydi2sijnbyutktbicdx2}</td><td>（中継用）第２成人病特定部位コード＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyuhtnpkknx2 ztydi2sijnbyuhtnpkknx2}</td><td>（中継用）第２成人病不担保期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkykkgusdkbn ztydi2sijnbyutkykkgusdkbn}</td><td>（中継用）第２成人病特約記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbytkykgankyhgtkbn ztydi2sijnbytkykgankyhgtkbn}</td><td>（中継用）第２成人病特約ガン給付型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydi2sijnbyutkykpwrbkkbn ztydi2sijnbyutkykpwrbkkbn}</td><td>（中継用）第２成人病特約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3x3 ztyyobiv3x3}</td><td>（中継用）予備項目Ｖ３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2jyoukentukihyouji ztydai2jyoukentukihyouji}</td><td>（中継用）第２条件付表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtisyukgu ztytignmrtisyukgu}</td><td>（中継用）逓減マル定種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteikikan ztyteigenmaruteikikan}</td><td>（中継用）逓減マル定期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmrtiphrkkkn ztyteigenmrtiphrkkkn}</td><td>（中継用）逓減マル定Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteis ztyteigenmaruteis}</td><td>（中継用）逓減マル定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteip ztyteigenmaruteip}</td><td>（中継用）逓減マル定Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyteigenmaruteisyuuseis ztyteigenmaruteisyuuseis}</td><td>（中継用）逓減マル定修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyteigenmrtimodssakugenhyj ztyteigenmrtimodssakugenhyj}</td><td>（中継用）逓減マル定修正Ｓ削減表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtitkjyukbn ztytignmrtitkjyukbn}</td><td>（中継用）逓減マル定特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtitkjyuskgnkkn ztytignmrtitkjyuskgnkkn}</td><td>（中継用）逓減マル定特条削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtitkjyuryumshyutn ztytignmrtitkjyuryumshyutn}</td><td>（中継用）逓減マル定特条料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytignmrtitkjyup ztytignmrtitkjyup}</td><td>（中継用）逓減マル定特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytignmrtiskyuksgk ztytignmrtiskyuksgk}</td><td>（中継用）逓減マル定支給基礎額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyktignmrtsyrikgux1 ztyhtnknkyktignmrtsyrikgux1}</td><td>（中継用）被転換契約逓減マル定種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyktignmrtsyrikgux2 ztyhtnknkyktignmrtsyrikgux2}</td><td>（中継用）被転換契約逓減マル定種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyktignmrtsyrikgux3 ztyhtnknkyktignmrtsyrikgux3}</td><td>（中継用）被転換契約逓減マル定種類記号＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyktignmrtsyrikgux4 ztyhtnknkyktignmrtsyrikgux4}</td><td>（中継用）被転換契約逓減マル定種類記号＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyktignmrtsyrikgux5 ztyhtnknkyktignmrtsyrikgux5}</td><td>（中継用）被転換契約逓減マル定種類記号＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyktignmrtsyrikgux6 ztyhtnknkyktignmrtsyrikgux6}</td><td>（中継用）被転換契約逓減マル定種類記号＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuryutignmrtipwrbkkbn ztysuryutignmrtipwrbkkbn}</td><td>（中継用）数理用逓減マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtipwrbkkbn ztytignmrtipwrbkkbn}</td><td>（中継用）逓減マル定Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytignmrtitnknyugukbn ztytignmrtitnknyugukbn}</td><td>（中継用）逓減マル定転換優遇区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteigenmrtikgusdkbn ztyteigenmrtikgusdkbn}</td><td>（中継用）逓減マル定記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv1x2 ztyyobiv1x2}</td><td>（中継用）予備項目Ｖ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytktsppisetkykkbn ztytktsppisetkykkbn}</td><td>（中継用）特定疾病セット契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyudmnsiskknsetkykkbn ztyjyudmnsiskknsetkykkbn}</td><td>（中継用）重度慢性疾患セット契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv8x2 ztyyobiv8x2}</td><td>（中継用）予備項目Ｖ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitesyono1 ztysetaitesyono1}</td><td>（中継用）セット相手証券番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitehokensyuruikigou1 ztysetaitehokensyuruikigou1}</td><td>（中継用）セット相手保険種類記号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitemrtisyuruikgu1 ztysetaitemrtisyuruikgu1}</td><td>（中継用）セット相手マル定種類記号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitesiznmrtisyurui1 ztysetaitesiznmrtisyurui1}</td><td>（中継用）セット相手生存マル定種類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitetignmrtisyurui1 ztysetaitetignmrtisyurui1}</td><td>（中継用）セット相手逓減マル定種類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitekihonbubuns1 ztysetaitekihonbubuns1}</td><td>（中継用）セット相手基本部分Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetgukitnknitjbrkhns1 ztysetgukitnknitjbrkhns1}</td><td>（中継用）セット合計転換一時払基本Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitesibous1 ztysetaitesibous1}</td><td>（中継用）セット相手死亡Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetgukitnknitjbrsbus1 ztysetgukitnknitjbrsbus1}</td><td>（中継用）セット合計転換一時払死亡Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitesyuuseis1 ztysetaitesyuuseis1}</td><td>（中継用）セット相手修正Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaiteharaikomip1 ztysetaiteharaikomip1}</td><td>（中継用）セット相手払込Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitesyukeiyakububunp1 ztysetaitesyukeiyakububunp1}</td><td>（中継用）セット相手主契約部分Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitgukikzkmrtis1 ztysetaitgukikzkmrtis1}</td><td>（中継用）セット相手合計家族マル定Ｓ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitetenkankykhyj1 ztysetaitetenkankykhyj1}</td><td>（中継用）セット相手転換契約表示１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysetaitesiteimhrkp1 ztysetaitesiteimhrkp1}</td><td>（中継用）セット相手指定月払込Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitesiteimsykykp1 ztysetaitesiteimsykykp1}</td><td>（中継用）セット相手指定月主契約Ｐ１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysetaitenkmrtisyurui1 ztysetaitenkmrtisyurui1}</td><td>（中継用）セット相手年金マル定種類１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv18 ztyyobiv18}</td><td>（中継用）予備項目Ｖ１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_Sp2RnduyuSouseiritu1Ty
 * @see     PKZT_Sp2RnduyuSouseiritu1Ty
 * @see     QZT_Sp2RnduyuSouseiritu1Ty
 * @see     GenQZT_Sp2RnduyuSouseiritu1Ty
 */
@MappedSuperclass
@Table(name=GenZT_Sp2RnduyuSouseiritu1Ty.TABLE_NAME)
@IdClass(value=PKZT_Sp2RnduyuSouseiritu1Ty.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Sp2RnduyuSouseiritu1Ty extends AbstractExDBEntity<ZT_Sp2RnduyuSouseiritu1Ty, PKZT_Sp2RnduyuSouseiritu1Ty> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Sp2RnduyuSouseiritu1Ty";
    public static final String ZTYKTGYSYRYMD            = "ztyktgysyrymd";
    public static final String ZTYKTGYSYONO             = "ztyktgysyono";
    public static final String ZTYKTGYFILERENNO         = "ztyktgyfilerenno";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYAATUKAISYASISYACD     = "ztyaatukaisyasisyacd";
    public static final String ZTYMOSNO                 = "ztymosno";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYKIHONS                = "ztykihons";
    public static final String ZTYSIBOUS                = "ztysibous";
    public static final String ZTYGYOUSEKIHYOUKAYOUHOSYOUS = "ztygyousekihyoukayouhosyous";
    public static final String ZTYGUKITNKNITJBRKHNS     = "ztygukitnknitjbrkhns";
    public static final String ZTYGUKITNKNITJBRSBUS     = "ztygukitnknitjbrsbus";
    public static final String ZTYKKTIJGUKITNKNITJBRKHNS = "ztykktijgukitnknitjbrkhns";
    public static final String ZTYKKTIJGUKITNKNITJBRSBUS = "ztykktijgukitnknitjbrsbus";
    public static final String ZTYSYOKAIHARAIKOMIP      = "ztysyokaiharaikomip";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYRYOURITUKBN           = "ztyryouritukbn";
    public static final String ZTYTKSYUANNAIKYKKBN      = "ztytksyuannaikykkbn";
    public static final String ZTYSDPDKBN               = "ztysdpdkbn";
    public static final String ZTYANNISKCD              = "ztyanniskcd";
    public static final String ZTYDUKETORIHOUHOUKBN     = "ztyduketorihouhoukbn";
    public static final String ZTYKYKSYHHKNSYDOUITUHYOUJI = "ztykyksyhhknsydouituhyouji";
    public static final String ZTYKYKSYAKIKYKARIHYJ     = "ztykyksyakikykarihyj";
    public static final String ZTYTENKANKEIYAKUHYOUJI   = "ztytenkankeiyakuhyouji";
    public static final String ZTYJIGYOUKEIYAKUHYOUJI   = "ztyjigyoukeiyakuhyouji";
    public static final String ZTYNENKINZEISEITOKUYAKUKBN = "ztynenkinzeiseitokuyakukbn";
    public static final String ZTYSYUSSEIMAEKANYUUKYKKBN = "ztysyusseimaekanyuukykkbn";
    public static final String ZTYKAZOKUKEIYAKUHYOUJI   = "ztykazokukeiyakuhyouji";
    public static final String ZTYJIKOKYKHYJ            = "ztyjikokykhyj";
    public static final String ZTYTUUSYOUMEISIYOUHYOUJI = "ztytuusyoumeisiyouhyouji";
    public static final String ZTYSETHOKENKBN           = "ztysethokenkbn";
    public static final String ZTYTEIKEISYOUHINKBN      = "ztyteikeisyouhinkbn";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYTOKUNINBOSYUUTEATE    = "ztytokuninbosyuuteate";
    public static final String ZTYSEISEKIYM             = "ztyseisekiym";
    public static final String ZTYSEISEKIKEIJYOUSYUUSEIS = "ztyseisekikeijyousyuuseis";
    public static final String ZTYSYUUSEISSAKUGENHYOUJI = "ztysyuuseissakugenhyouji";
    public static final String ZTYAATUKAISISYATODOUHUKENCD = "ztyaatukaisisyatodouhukencd";
    public static final String ZTYAATUKAISOSIKICD       = "ztyaatukaisosikicd";
    public static final String ZTYAATUKAIKOJINCD        = "ztyaatukaikojincd";
    public static final String ZTYBATUKAISOSIKICD       = "ztybatukaisosikicd";
    public static final String ZTYBATUKAISYAKOJINCD     = "ztybatukaisyakojincd";
    public static final String ZTYMARUTOKUKBN           = "ztymarutokukbn";
    public static final String ZTYGYOUMUJYOUHYOUJI      = "ztygyoumujyouhyouji";
    public static final String ZTYTUIKAKEIJYOUKBN       = "ztytuikakeijyoukbn";
    public static final String ZTYSEISEKINOMIKEIJYOUKBN = "ztyseisekinomikeijyoukbn";
    public static final String ZTYTEIKIKEIJYOUKBN       = "ztyteikikeijyoukbn";
    public static final String ZTYHNGKMSKKATKISYKBN     = "ztyhngkmskkatkisykbn";
    public static final String ZTYTNKNKYUUYOSAKUGENHYJ  = "ztytnknkyuuyosakugenhyj";
    public static final String ZTYTENKANKAISUU          = "ztytenkankaisuu";
    public static final String ZTYHIYUBRIGSSNSIKKIJYUNKBN = "ztyhiyubrigssnsikkijyunkbn";
    public static final String ZTYSEKININKAISIYMD       = "ztysekininkaisiymd";
    public static final String ZTYKIGETUSMKRGKYKHYJ     = "ztykigetusmkrgkykhyj";
    public static final String ZTYHENSYUUSYORIYMD       = "ztyhensyuusyoriymd";
    public static final String ZTYJISISYAATUKAIHYOUJI   = "ztyjisisyaatukaihyouji";
    public static final String ZTYAATKISYTKTNTUSY1ATKIHYJ = "ztyaatkisytktntusy1atkihyj";
    public static final String ZTYAATKISYTKTNTUSY2ATKIHYJ = "ztyaatkisytktntusy2atkihyj";
    public static final String ZTYAATKISYASYOKAN1ATKIHYJ = "ztyaatkisyasyokan1atkihyj";
    public static final String ZTYAATKISYASYOKAN2ATKIHYJ = "ztyaatkisyasyokan2atkihyj";
    public static final String ZTYBATKISYTKTNTUSY1ATKIHYJ = "ztybatkisytktntusy1atkihyj";
    public static final String ZTYBATKISYTKTNTUSY2ATKIHYJ = "ztybatkisytktntusy2atkihyj";
    public static final String ZTYBATKISYASYOKAN1ATKIHYJ = "ztybatkisyasyokan1atkihyj";
    public static final String ZTYBATKISYASYOKAN2ATKIHYJ = "ztybatkisyasyokan2atkihyj";
    public static final String ZTYKEIZOKUTYUUIHYOUJI    = "ztykeizokutyuuihyouji";
    public static final String ZTYKEIYAKUBISITEIHYOUJI  = "ztykeiyakubisiteihyouji";
    public static final String ZTYJYOUKENTUKIHYOUJI     = "ztyjyoukentukihyouji";
    public static final String ZTYTOKUNINHYOUJI         = "ztytokuninhyouji";
    public static final String ZTYKESSANTYOUSEIKBN      = "ztykessantyouseikbn";
    public static final String ZTYHANEIHYOUJI           = "ztyhaneihyouji";
    public static final String ZTYSYUKINKBN             = "ztysyukinkbn";
    public static final String ZTYKEIYAKUSYASYOKUGYOUCD = "ztykeiyakusyasyokugyoucd";
    public static final String ZTYSEIKEIKEIROKBN        = "ztyseikeikeirokbn";
    public static final String ZTYDAI2SEIKEIKEIROKBN    = "ztydai2seikeikeirokbn";
    public static final String ZTYTEIGENTOKUTEISYURUIKIGOU = "ztyteigentokuteisyuruikigou";
    public static final String ZTYTEIGENTOKUTEIKIKAN    = "ztyteigentokuteikikan";
    public static final String ZTYTEIGENTOKUTEIS        = "ztyteigentokuteis";
    public static final String ZTYTEIGENTOKUTEIP        = "ztyteigentokuteip";
    public static final String ZTYTIGNTKTISDTPDTKBN     = "ztytigntktisdtpdtkbn";
    public static final String ZTYTEIGENTOKUTEISYUUSEIS = "ztyteigentokuteisyuuseis";
    public static final String ZTYTEIGENTKTIMODSSAKUGENHYJ = "ztyteigentktimodssakugenhyj";
    public static final String ZTYTEIGENTKTIKGUSDKBN    = "ztyteigentktikgusdkbn";
    public static final String ZTYYOBIV9                = "ztyyobiv9";
    public static final String ZTYTOKUTEIBUICDX1        = "ztytokuteibuicdx1";
    public static final String ZTYHTNPKKNX1             = "ztyhtnpkknx1";
    public static final String ZTYTOKUTEIBUICDX2        = "ztytokuteibuicdx2";
    public static final String ZTYHTNPKKNX2             = "ztyhtnpkknx2";
    public static final String ZTYHHKNMEI               = "ztyhhknmei";
    public static final String ZTYKNJHHKNMEI            = "ztyknjhhknmei";
    public static final String ZTYHHKNSEIYMD            = "ztyhhknseiymd";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHHKNHNSKTODOUHUKENCD  = "ztyhhknhnsktodouhukencd";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYHIHOKENSYAKIKYKARIHYJ = "ztyhihokensyakikykarihyj";
    public static final String ZTYNOBIKKOSAIMANKIKBN    = "ztynobikkosaimankikbn";
    public static final String ZTYHHKNSYSYSNHONNINKKNNKBN = "ztyhhknsysysnhonninkknnkbn";
    public static final String ZTYHHKNSYSISNHONNINKKNNKBN = "ztyhhknsysisnhonninkknnkbn";
    public static final String ZTYKZKTOUROKUSERVICEARIHYJ = "ztykzktourokuservicearihyj";
    public static final String ZTYYOBIV4X12             = "ztyyobiv4x12";
    public static final String ZTYHENSYUUKEIYAKUSYAMEI  = "ztyhensyuukeiyakusyamei";
    public static final String ZTYHNSYUKNJKYKSYNM       = "ztyhnsyuknjkyksynm";
    public static final String ZTYKYKSYASEIYMD          = "ztykyksyaseiymd";
    public static final String ZTYKYKSYASEIKBN          = "ztykyksyaseikbn";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYKNKUZUSNZYRT          = "ztyknkuzusnzyrt";
    public static final String ZTYVITDOUJIMOS2KENMEIKOUHYJ = "ztyvitdoujimos2kenmeikouhyj";
    public static final String ZTYKIKYKVITARITUIKAMOSHYJ = "ztykikykvitarituikamoshyj";
    public static final String ZTYHTNKNKYKVITHOKENKBN   = "ztyhtnknkykvithokenkbn";
    public static final String ZTYKIKYKVITHOKENHOYUUJKKBN = "ztykikykvithokenhoyuujkkbn";
    public static final String ZTYYOBIV2X2              = "ztyyobiv2x2";
    public static final String ZTYTSNSKNEWYNO           = "ztytsnsknewyno";
    public static final String ZTYTSNSKNEWTIKUCD        = "ztytsnsknewtikucd";
    public static final String ZTYMOSSYUMTKKTYMD        = "ztymossyumtkktymd";
    public static final String ZTYKITUENKBN             = "ztykituenkbn";
    public static final String ZTYTUUSINSAKIJYUUSYOKBN  = "ztytuusinsakijyuusyokbn";
    public static final String ZTYMARUTEISYURUIKIGOU    = "ztymaruteisyuruikigou";
    public static final String ZTYMARUTEIKIKAN          = "ztymaruteikikan";
    public static final String ZTYMARUTEIPHRKKKN        = "ztymaruteiphrkkkn";
    public static final String ZTYMARUTEIS              = "ztymaruteis";
    public static final String ZTYMARUTEIP              = "ztymaruteip";
    public static final String ZTYMARUTEISYUUSEIS       = "ztymaruteisyuuseis";
    public static final String ZTYMARUTEISYUUSEISSKGNHYJ = "ztymaruteisyuuseisskgnhyj";
    public static final String ZTYMARUTEITOKUJYOUKBN    = "ztymaruteitokujyoukbn";
    public static final String ZTYMRTITKJYUSKGNKKN      = "ztymrtitkjyuskgnkkn";
    public static final String ZTYMRTITKJYURYUMSHYUTN   = "ztymrtitkjyuryumshyutn";
    public static final String ZTYMARUTEITOKUJYOUP      = "ztymaruteitokujyoup";
    public static final String ZTYSURYUMRTIPWRBKKBN     = "ztysuryumrtipwrbkkbn";
    public static final String ZTYMARUTEIPWARIBIKIKBN   = "ztymaruteipwaribikikbn";
    public static final String ZTYMRTITNKNYUGUKBN       = "ztymrtitnknyugukbn";
    public static final String ZTYMARUTEIKIGOUSEDAIKBN  = "ztymaruteikigousedaikbn";
    public static final String ZTYMARUTEIKIKOUSNMNRYOAGE = "ztymaruteikikousnmnryoage";
    public static final String ZTYYOBIV2                = "ztyyobiv2";
    public static final String ZTYMARUYOUSYURUIKIGOU    = "ztymaruyousyuruikigou";
    public static final String ZTYMARUYOUKIKAN          = "ztymaruyoukikan";
    public static final String ZTYMARUYOUS              = "ztymaruyous";
    public static final String ZTYMARUYOUP              = "ztymaruyoup";
    public static final String ZTYMARUYOUSDATEPDATEKBN  = "ztymaruyousdatepdatekbn";
    public static final String ZTYMARUYOUSYUUSEIS       = "ztymaruyousyuuseis";
    public static final String ZTYMARUYOUSYUUSEISSKGNHYJ = "ztymaruyousyuuseisskgnhyj";
    public static final String ZTYMARUYOUKIGOUSEDAIKBN  = "ztymaruyoukigousedaikbn";
    public static final String ZTYYOBIV9X3              = "ztyyobiv9x3";
    public static final String ZTYMARUSYUUSYURUIKIGOU   = "ztymarusyuusyuruikigou";
    public static final String ZTYMARUSYUUKIKAN         = "ztymarusyuukikan";
    public static final String ZTYMARUSYUUS             = "ztymarusyuus";
    public static final String ZTYMARUSYUUP             = "ztymarusyuup";
    public static final String ZTYMARUSYUUSDATEPDATEKBN = "ztymarusyuusdatepdatekbn";
    public static final String ZTYMARUSYUUSYUUSEIS      = "ztymarusyuusyuuseis";
    public static final String ZTYMARUSYUUSYUUSEISSKGNHYJ = "ztymarusyuusyuuseisskgnhyj";
    public static final String ZTYMARUSYUUKIGOUSEDAIKBN = "ztymarusyuukigousedaikbn";
    public static final String ZTYYOBIV9X4              = "ztyyobiv9x4";
    public static final String ZTYTOKUTEISYURUIKIGOU    = "ztytokuteisyuruikigou";
    public static final String ZTYTOKUTEIKIKAN          = "ztytokuteikikan";
    public static final String ZTYTOKUTEIS              = "ztytokuteis";
    public static final String ZTYTOKUTEIP              = "ztytokuteip";
    public static final String ZTYTOKUTEISDATEPDATEKBN  = "ztytokuteisdatepdatekbn";
    public static final String ZTYTOKUTEISYUUSEIS       = "ztytokuteisyuuseis";
    public static final String ZTYTOKUTEISYUUSEISSKGNHYJ = "ztytokuteisyuuseisskgnhyj";
    public static final String ZTYTOKUTEIKIGOUSEDAIKBN  = "ztytokuteikigousedaikbn";
    public static final String ZTYYOBIV9X5              = "ztyyobiv9x5";
    public static final String ZTYKZKMRTITKYKNOX1       = "ztykzkmrtitkyknox1";
    public static final String ZTYKAZOKUMRTISYURUIKGUX1 = "ztykazokumrtisyuruikgux1";
    public static final String ZTYKAZOKUMARUTEIKIKANX1  = "ztykazokumaruteikikanx1";
    public static final String ZTYKAZOKUMRTIPHRKKKNX1   = "ztykazokumrtiphrkkknx1";
    public static final String ZTYKAZOKUMARUTEISX1      = "ztykazokumaruteisx1";
    public static final String ZTYKAZOKUMARUTEIPX1      = "ztykazokumaruteipx1";
    public static final String ZTYKZKMRTIHIHKNSYANMX1   = "ztykzkmrtihihknsyanmx1";
    public static final String ZTYKZKMRTIHIHKNSYSEIYMDX1 = "ztykzkmrtihihknsyseiymdx1";
    public static final String ZTYKZKMRTIHIHKNSYSIBTKBNX1 = "ztykzkmrtihihknsysibtkbnx1";
    public static final String ZTYKAZOKUMRTIHIHKNSYAAGEX1 = "ztykazokumrtihihknsyaagex1";
    public static final String ZTYKZKMRTIMODSX1         = "ztykzkmrtimodsx1";
    public static final String ZTYKAZOKUMRTIMODSSKGNHYJX1 = "ztykazokumrtimodsskgnhyjx1";
    public static final String ZTYKZKMRTITNKNYUGUKBNX1  = "ztykzkmrtitnknyugukbnx1";
    public static final String ZTYKAZOKUMRTIKGUSDKBNX1  = "ztykazokumrtikgusdkbnx1";
    public static final String ZTYKAZOKUMRTIAGETYUSIHYJX1 = "ztykazokumrtiagetyusihyjx1";
    public static final String ZTYKZKMRTIKUSNMNRYOAGEX1 = "ztykzkmrtikusnmnryoagex1";
    public static final String ZTYYOBIV4                = "ztyyobiv4";
    public static final String ZTYKZKMRTITKYKNOX2       = "ztykzkmrtitkyknox2";
    public static final String ZTYKAZOKUMRTISYURUIKGUX2 = "ztykazokumrtisyuruikgux2";
    public static final String ZTYKAZOKUMARUTEIKIKANX2  = "ztykazokumaruteikikanx2";
    public static final String ZTYKAZOKUMRTIPHRKKKNX2   = "ztykazokumrtiphrkkknx2";
    public static final String ZTYKAZOKUMARUTEISX2      = "ztykazokumaruteisx2";
    public static final String ZTYKAZOKUMARUTEIPX2      = "ztykazokumaruteipx2";
    public static final String ZTYKZKMRTIHIHKNSYANMX2   = "ztykzkmrtihihknsyanmx2";
    public static final String ZTYKZKMRTIHIHKNSYSEIYMDX2 = "ztykzkmrtihihknsyseiymdx2";
    public static final String ZTYKZKMRTIHIHKNSYSIBTKBNX2 = "ztykzkmrtihihknsysibtkbnx2";
    public static final String ZTYKAZOKUMRTIHIHKNSYAAGEX2 = "ztykazokumrtihihknsyaagex2";
    public static final String ZTYKZKMRTIMODSX2         = "ztykzkmrtimodsx2";
    public static final String ZTYKAZOKUMRTIMODSSKGNHYJX2 = "ztykazokumrtimodsskgnhyjx2";
    public static final String ZTYKZKMRTITNKNYUGUKBNX2  = "ztykzkmrtitnknyugukbnx2";
    public static final String ZTYKAZOKUMRTIKGUSDKBNX2  = "ztykazokumrtikgusdkbnx2";
    public static final String ZTYKAZOKUMRTIAGETYUSIHYJX2 = "ztykazokumrtiagetyusihyjx2";
    public static final String ZTYKZKMRTIKUSNMNRYOAGEX2 = "ztykzkmrtikusnmnryoagex2";
    public static final String ZTYYOBIV4X2              = "ztyyobiv4x2";
    public static final String ZTYKZKMRTITKYKNOX3       = "ztykzkmrtitkyknox3";
    public static final String ZTYKAZOKUMRTISYURUIKGUX3 = "ztykazokumrtisyuruikgux3";
    public static final String ZTYKAZOKUMARUTEIKIKANX3  = "ztykazokumaruteikikanx3";
    public static final String ZTYKAZOKUMRTIPHRKKKNX3   = "ztykazokumrtiphrkkknx3";
    public static final String ZTYKAZOKUMARUTEISX3      = "ztykazokumaruteisx3";
    public static final String ZTYKAZOKUMARUTEIPX3      = "ztykazokumaruteipx3";
    public static final String ZTYKZKMRTIHIHKNSYANMX3   = "ztykzkmrtihihknsyanmx3";
    public static final String ZTYKZKMRTIHIHKNSYSEIYMDX3 = "ztykzkmrtihihknsyseiymdx3";
    public static final String ZTYKZKMRTIHIHKNSYSIBTKBNX3 = "ztykzkmrtihihknsysibtkbnx3";
    public static final String ZTYKAZOKUMRTIHIHKNSYAAGEX3 = "ztykazokumrtihihknsyaagex3";
    public static final String ZTYKZKMRTIMODSX3         = "ztykzkmrtimodsx3";
    public static final String ZTYKAZOKUMRTIMODSSKGNHYJX3 = "ztykazokumrtimodsskgnhyjx3";
    public static final String ZTYKZKMRTITNKNYUGUKBNX3  = "ztykzkmrtitnknyugukbnx3";
    public static final String ZTYKAZOKUMRTIKGUSDKBNX3  = "ztykazokumrtikgusdkbnx3";
    public static final String ZTYKAZOKUMRTIAGETYUSIHYJX3 = "ztykazokumrtiagetyusihyjx3";
    public static final String ZTYKZKMRTIKUSNMNRYOAGEX3 = "ztykzkmrtikusnmnryoagex3";
    public static final String ZTYYOBIV4X3              = "ztyyobiv4x3";
    public static final String ZTYKZKMRTITKYKNOX4       = "ztykzkmrtitkyknox4";
    public static final String ZTYKAZOKUMRTISYURUIKGUX4 = "ztykazokumrtisyuruikgux4";
    public static final String ZTYKAZOKUMARUTEIKIKANX4  = "ztykazokumaruteikikanx4";
    public static final String ZTYKAZOKUMRTIPHRKKKNX4   = "ztykazokumrtiphrkkknx4";
    public static final String ZTYKAZOKUMARUTEISX4      = "ztykazokumaruteisx4";
    public static final String ZTYKAZOKUMARUTEIPX4      = "ztykazokumaruteipx4";
    public static final String ZTYKZKMRTIHIHKNSYANMX4   = "ztykzkmrtihihknsyanmx4";
    public static final String ZTYKZKMRTIHIHKNSYSEIYMDX4 = "ztykzkmrtihihknsyseiymdx4";
    public static final String ZTYKZKMRTIHIHKNSYSIBTKBNX4 = "ztykzkmrtihihknsysibtkbnx4";
    public static final String ZTYKAZOKUMRTIHIHKNSYAAGEX4 = "ztykazokumrtihihknsyaagex4";
    public static final String ZTYKZKMRTIMODSX4         = "ztykzkmrtimodsx4";
    public static final String ZTYKAZOKUMRTIMODSSKGNHYJX4 = "ztykazokumrtimodsskgnhyjx4";
    public static final String ZTYKZKMRTITNKNYUGUKBNX4  = "ztykzkmrtitnknyugukbnx4";
    public static final String ZTYKAZOKUMRTIKGUSDKBNX4  = "ztykazokumrtikgusdkbnx4";
    public static final String ZTYKAZOKUMRTIAGETYUSIHYJX4 = "ztykazokumrtiagetyusihyjx4";
    public static final String ZTYKZKMRTIKUSNMNRYOAGEX4 = "ztykzkmrtikusnmnryoagex4";
    public static final String ZTYYOBIV4X4              = "ztyyobiv4x4";
    public static final String ZTYKZKMRTITKYKNOX5       = "ztykzkmrtitkyknox5";
    public static final String ZTYKAZOKUMRTISYURUIKGUX5 = "ztykazokumrtisyuruikgux5";
    public static final String ZTYKAZOKUMARUTEIKIKANX5  = "ztykazokumaruteikikanx5";
    public static final String ZTYKAZOKUMRTIPHRKKKNX5   = "ztykazokumrtiphrkkknx5";
    public static final String ZTYKAZOKUMARUTEISX5      = "ztykazokumaruteisx5";
    public static final String ZTYKAZOKUMARUTEIPX5      = "ztykazokumaruteipx5";
    public static final String ZTYKZKMRTIHIHKNSYANMX5   = "ztykzkmrtihihknsyanmx5";
    public static final String ZTYKZKMRTIHIHKNSYSEIYMDX5 = "ztykzkmrtihihknsyseiymdx5";
    public static final String ZTYKZKMRTIHIHKNSYSIBTKBNX5 = "ztykzkmrtihihknsysibtkbnx5";
    public static final String ZTYKAZOKUMRTIHIHKNSYAAGEX5 = "ztykazokumrtihihknsyaagex5";
    public static final String ZTYKZKMRTIMODSX5         = "ztykzkmrtimodsx5";
    public static final String ZTYKAZOKUMRTIMODSSKGNHYJX5 = "ztykazokumrtimodsskgnhyjx5";
    public static final String ZTYKZKMRTITNKNYUGUKBNX5  = "ztykzkmrtitnknyugukbnx5";
    public static final String ZTYKAZOKUMRTIKGUSDKBNX5  = "ztykazokumrtikgusdkbnx5";
    public static final String ZTYKAZOKUMRTIAGETYUSIHYJX5 = "ztykazokumrtiagetyusihyjx5";
    public static final String ZTYKZKMRTIKUSNMNRYOAGEX5 = "ztykzkmrtikusnmnryoagex5";
    public static final String ZTYYOBIV4X5              = "ztyyobiv4x5";
    public static final String ZTYKZKMRTITKYKNOX6       = "ztykzkmrtitkyknox6";
    public static final String ZTYKAZOKUMRTISYURUIKGUX6 = "ztykazokumrtisyuruikgux6";
    public static final String ZTYKAZOKUMARUTEIKIKANX6  = "ztykazokumaruteikikanx6";
    public static final String ZTYKAZOKUMRTIPHRKKKNX6   = "ztykazokumrtiphrkkknx6";
    public static final String ZTYKAZOKUMARUTEISX6      = "ztykazokumaruteisx6";
    public static final String ZTYKAZOKUMARUTEIPX6      = "ztykazokumaruteipx6";
    public static final String ZTYKZKMRTIHIHKNSYANMX6   = "ztykzkmrtihihknsyanmx6";
    public static final String ZTYKZKMRTIHIHKNSYSEIYMDX6 = "ztykzkmrtihihknsyseiymdx6";
    public static final String ZTYKZKMRTIHIHKNSYSIBTKBNX6 = "ztykzkmrtihihknsysibtkbnx6";
    public static final String ZTYKAZOKUMRTIHIHKNSYAAGEX6 = "ztykazokumrtihihknsyaagex6";
    public static final String ZTYKZKMRTIMODSX6         = "ztykzkmrtimodsx6";
    public static final String ZTYKAZOKUMRTIMODSSKGNHYJX6 = "ztykazokumrtimodsskgnhyjx6";
    public static final String ZTYKZKMRTITNKNYUGUKBNX6  = "ztykzkmrtitnknyugukbnx6";
    public static final String ZTYKAZOKUMRTIKGUSDKBNX6  = "ztykazokumrtikgusdkbnx6";
    public static final String ZTYKAZOKUMRTIAGETYUSIHYJX6 = "ztykazokumrtiagetyusihyjx6";
    public static final String ZTYKZKMRTIKUSNMNRYOAGEX6 = "ztykzkmrtikusnmnryoagex6";
    public static final String ZTYYOBIV4X6              = "ztyyobiv4x6";
    public static final String ZTYKZKMRTITKYKNOX7       = "ztykzkmrtitkyknox7";
    public static final String ZTYKAZOKUMRTISYURUIKGUX7 = "ztykazokumrtisyuruikgux7";
    public static final String ZTYKAZOKUMARUTEIKIKANX7  = "ztykazokumaruteikikanx7";
    public static final String ZTYKAZOKUMRTIPHRKKKNX7   = "ztykazokumrtiphrkkknx7";
    public static final String ZTYKAZOKUMARUTEISX7      = "ztykazokumaruteisx7";
    public static final String ZTYKAZOKUMARUTEIPX7      = "ztykazokumaruteipx7";
    public static final String ZTYKZKMRTIHIHKNSYANMX7   = "ztykzkmrtihihknsyanmx7";
    public static final String ZTYKZKMRTIHIHKNSYSEIYMDX7 = "ztykzkmrtihihknsyseiymdx7";
    public static final String ZTYKZKMRTIHIHKNSYSIBTKBNX7 = "ztykzkmrtihihknsysibtkbnx7";
    public static final String ZTYKAZOKUMRTIHIHKNSYAAGEX7 = "ztykazokumrtihihknsyaagex7";
    public static final String ZTYKZKMRTIMODSX7         = "ztykzkmrtimodsx7";
    public static final String ZTYKAZOKUMRTIMODSSKGNHYJX7 = "ztykazokumrtimodsskgnhyjx7";
    public static final String ZTYKZKMRTITNKNYUGUKBNX7  = "ztykzkmrtitnknyugukbnx7";
    public static final String ZTYKAZOKUMRTIKGUSDKBNX7  = "ztykazokumrtikgusdkbnx7";
    public static final String ZTYKAZOKUMRTIAGETYUSIHYJX7 = "ztykazokumrtiagetyusihyjx7";
    public static final String ZTYKZKMRTIKUSNMNRYOAGEX7 = "ztykzkmrtikusnmnryoagex7";
    public static final String ZTYYOBIV4X7              = "ztyyobiv4x7";
    public static final String ZTYKZKMRTITKYKNOX8       = "ztykzkmrtitkyknox8";
    public static final String ZTYKAZOKUMRTISYURUIKGUX8 = "ztykazokumrtisyuruikgux8";
    public static final String ZTYKAZOKUMARUTEIKIKANX8  = "ztykazokumaruteikikanx8";
    public static final String ZTYKAZOKUMRTIPHRKKKNX8   = "ztykazokumrtiphrkkknx8";
    public static final String ZTYKAZOKUMARUTEISX8      = "ztykazokumaruteisx8";
    public static final String ZTYKAZOKUMARUTEIPX8      = "ztykazokumaruteipx8";
    public static final String ZTYKZKMRTIHIHKNSYANMX8   = "ztykzkmrtihihknsyanmx8";
    public static final String ZTYKZKMRTIHIHKNSYSEIYMDX8 = "ztykzkmrtihihknsyseiymdx8";
    public static final String ZTYKZKMRTIHIHKNSYSIBTKBNX8 = "ztykzkmrtihihknsysibtkbnx8";
    public static final String ZTYKAZOKUMRTIHIHKNSYAAGEX8 = "ztykazokumrtihihknsyaagex8";
    public static final String ZTYKZKMRTIMODSX8         = "ztykzkmrtimodsx8";
    public static final String ZTYKAZOKUMRTIMODSSKGNHYJX8 = "ztykazokumrtimodsskgnhyjx8";
    public static final String ZTYKZKMRTITNKNYUGUKBNX8  = "ztykzkmrtitnknyugukbnx8";
    public static final String ZTYKAZOKUMRTIKGUSDKBNX8  = "ztykazokumrtikgusdkbnx8";
    public static final String ZTYKAZOKUMRTIAGETYUSIHYJX8 = "ztykazokumrtiagetyusihyjx8";
    public static final String ZTYKZKMRTIKUSNMNRYOAGEX8 = "ztykzkmrtikusnmnryoagex8";
    public static final String ZTYYOBIV4X8              = "ztyyobiv4x8";
    public static final String ZTYKZKMRTITKYKNOX9       = "ztykzkmrtitkyknox9";
    public static final String ZTYKAZOKUMRTISYURUIKGUX9 = "ztykazokumrtisyuruikgux9";
    public static final String ZTYKAZOKUMARUTEIKIKANX9  = "ztykazokumaruteikikanx9";
    public static final String ZTYKAZOKUMRTIPHRKKKNX9   = "ztykazokumrtiphrkkknx9";
    public static final String ZTYKAZOKUMARUTEISX9      = "ztykazokumaruteisx9";
    public static final String ZTYKAZOKUMARUTEIPX9      = "ztykazokumaruteipx9";
    public static final String ZTYKZKMRTIHIHKNSYANMX9   = "ztykzkmrtihihknsyanmx9";
    public static final String ZTYKZKMRTIHIHKNSYSEIYMDX9 = "ztykzkmrtihihknsyseiymdx9";
    public static final String ZTYKZKMRTIHIHKNSYSIBTKBNX9 = "ztykzkmrtihihknsysibtkbnx9";
    public static final String ZTYKAZOKUMRTIHIHKNSYAAGEX9 = "ztykazokumrtihihknsyaagex9";
    public static final String ZTYKZKMRTIMODSX9         = "ztykzkmrtimodsx9";
    public static final String ZTYKAZOKUMRTIMODSSKGNHYJX9 = "ztykazokumrtimodsskgnhyjx9";
    public static final String ZTYKZKMRTITNKNYUGUKBNX9  = "ztykzkmrtitnknyugukbnx9";
    public static final String ZTYKAZOKUMRTIKGUSDKBNX9  = "ztykazokumrtikgusdkbnx9";
    public static final String ZTYKAZOKUMRTIAGETYUSIHYJX9 = "ztykazokumrtiagetyusihyjx9";
    public static final String ZTYKZKMRTIKUSNMNRYOAGEX9 = "ztykzkmrtikusnmnryoagex9";
    public static final String ZTYYOBIV4X9              = "ztyyobiv4x9";
    public static final String ZTYKZKMRTITKYKNOX10      = "ztykzkmrtitkyknox10";
    public static final String ZTYKAZOKUMRTISYURUIKGUX10 = "ztykazokumrtisyuruikgux10";
    public static final String ZTYKAZOKUMARUTEIKIKANX10 = "ztykazokumaruteikikanx10";
    public static final String ZTYKAZOKUMRTIPHRKKKNX10  = "ztykazokumrtiphrkkknx10";
    public static final String ZTYKAZOKUMARUTEISX10     = "ztykazokumaruteisx10";
    public static final String ZTYKAZOKUMARUTEIPX10     = "ztykazokumaruteipx10";
    public static final String ZTYKZKMRTIHIHKNSYANMX10  = "ztykzkmrtihihknsyanmx10";
    public static final String ZTYKZKMRTIHIHKNSYSEIYMDX10 = "ztykzkmrtihihknsyseiymdx10";
    public static final String ZTYKZKMRTIHIHKNSYSIBTKBNX10 = "ztykzkmrtihihknsysibtkbnx10";
    public static final String ZTYKAZOKUMRTIHIHKNSYAAGEX10 = "ztykazokumrtihihknsyaagex10";
    public static final String ZTYKZKMRTIMODSX10        = "ztykzkmrtimodsx10";
    public static final String ZTYKAZOKUMRTIMODSSKGNHYJX10 = "ztykazokumrtimodsskgnhyjx10";
    public static final String ZTYKZKMRTITNKNYUGUKBNX10 = "ztykzkmrtitnknyugukbnx10";
    public static final String ZTYKAZOKUMRTIKGUSDKBNX10 = "ztykazokumrtikgusdkbnx10";
    public static final String ZTYKAZOKUMRTIAGETYUSIHYJX10 = "ztykazokumrtiagetyusihyjx10";
    public static final String ZTYKZKMRTIKUSNMNRYOAGEX10 = "ztykzkmrtikusnmnryoagex10";
    public static final String ZTYYOBIV4X10             = "ztyyobiv4x10";
    public static final String ZTYNKSHRTKYKHUHOKBNX1    = "ztynkshrtkykhuhokbnx1";
    public static final String ZTYNKSHRTKYKNKSYURUIKBNX1 = "ztynkshrtkyknksyuruikbnx1";
    public static final String ZTYNKSHRTKYKNKKKNX1      = "ztynkshrtkyknkkknx1";
    public static final String ZTYNKSHRTKYKNKNENGKX1    = "ztynkshrtkyknknengkx1";
    public static final String ZTYNKSHRTKYKDUKETORIHHKBNX1 = "ztynkshrtkykduketorihhkbnx1";
    public static final String ZTYYOBIV10               = "ztyyobiv10";
    public static final String ZTYNKSHRTKYKHUHOKBNX2    = "ztynkshrtkykhuhokbnx2";
    public static final String ZTYNKSHRTKYKNKSYURUIKBNX2 = "ztynkshrtkyknksyuruikbnx2";
    public static final String ZTYNKSHRTKYKNKKKNX2      = "ztynkshrtkyknkkknx2";
    public static final String ZTYNKSHRTKYKNKNENGKX2    = "ztynkshrtkyknknengkx2";
    public static final String ZTYNKSHRTKYKDUKETORIHHKBNX2 = "ztynkshrtkykduketorihhkbnx2";
    public static final String ZTYYOBIV10X2             = "ztyyobiv10x2";
    public static final String ZTYSYOUGAITKYKSYURUIKGU  = "ztysyougaitkyksyuruikgu";
    public static final String ZTYSYOUGAITOKUYAKUKIKAN  = "ztysyougaitokuyakukikan";
    public static final String ZTYSYOUGAITKYKPHRKKKN    = "ztysyougaitkykphrkkkn";
    public static final String ZTYSYOUGAITOKUYAKUS      = "ztysyougaitokuyakus";
    public static final String ZTYSYOUGAITOKUYAKUP      = "ztysyougaitokuyakup";
    public static final String ZTYSYOUGAITKKATAKBN      = "ztysyougaitkkatakbn";
    public static final String ZTYSYOUGAITKYKKGUSDKBN   = "ztysyougaitkykkgusdkbn";
    public static final String ZTYSYUGITKYKPWRBKKBN     = "ztysyugitkykpwrbkkbn";
    public static final String ZTYSYOUGAITKYKKUSNMNRYOAGE = "ztysyougaitkykkusnmnryoage";
    public static final String ZTYYOBIV5X2              = "ztyyobiv5x2";
    public static final String ZTYSIGIWRMSTKYKSYURUIKGU = "ztysigiwrmstkyksyuruikgu";
    public static final String ZTYSIGIWRMSTKYKKKN       = "ztysigiwrmstkykkkn";
    public static final String ZTYSAIGAIWRMSTKYKPHRKKKN = "ztysaigaiwrmstkykphrkkkn";
    public static final String ZTYSAIGAIWARIMASITOKUYAKUS = "ztysaigaiwarimasitokuyakus";
    public static final String ZTYSAIGAIWARIMASITOKUYAKUP = "ztysaigaiwarimasitokuyakup";
    public static final String ZTYSAIGAIWRMSTKYKKGUSDKBN = "ztysaigaiwrmstkykkgusdkbn";
    public static final String ZTYSIGIWRMSTKYKPWRBKKBN  = "ztysigiwrmstkykpwrbkkbn";
    public static final String ZTYSIGIWRMSTKYKKUSNMNRYOAGE = "ztysigiwrmstkykkusnmnryoage";
    public static final String ZTYYOBIV5X3              = "ztyyobiv5x3";
    public static final String ZTYSIGINYUINTKYKSYURUIKGU = "ztysiginyuintkyksyuruikgu";
    public static final String ZTYSIGINYUINTKYKKKN      = "ztysiginyuintkykkkn";
    public static final String ZTYSAIGAINYUINTKYKPHRKKKN = "ztysaigainyuintkykphrkkkn";
    public static final String ZTYSIGINYUINTKYKNTGK     = "ztysiginyuintkykntgk";
    public static final String ZTYSIGINYUINTKYKGTKBN    = "ztysiginyuintkykgtkbn";
    public static final String ZTYSAIGAINYUUINTOKUYAKUP = "ztysaigainyuuintokuyakup";
    public static final String ZTYSAIGAINYUINTKYKKGUSDKBN = "ztysaigainyuintkykkgusdkbn";
    public static final String ZTYSIGINYUINTKYKPWRBKKBN = "ztysiginyuintkykpwrbkkbn";
    public static final String ZTYYOBIV7                = "ztyyobiv7";
    public static final String ZTYSPPINYUINTKYKSYURUIKGU = "ztysppinyuintkyksyuruikgu";
    public static final String ZTYSPPINYUINTKYKKKN      = "ztysppinyuintkykkkn";
    public static final String ZTYSPPINYUUINTKYKPHRKKKN = "ztysppinyuuintkykphrkkkn";
    public static final String ZTYSPPINYUINTKYKNTGK     = "ztysppinyuintkykntgk";
    public static final String ZTYSPPINYUINTKYKGTKBN    = "ztysppinyuintkykgtkbn";
    public static final String ZTYSIPPEINYUUINTOKUYAKUP = "ztysippeinyuuintokuyakup";
    public static final String ZTYSPPINYUINTKJYURYUMSHYUTN = "ztysppinyuintkjyuryumshyutn";
    public static final String ZTYSIPPEINYUUINTOKUJYOUP = "ztysippeinyuuintokujyoup";
    public static final String ZTYSPPINYUINTKTBICDX1    = "ztysppinyuintktbicdx1";
    public static final String ZTYSPPINYUINHTNPKKNX1    = "ztysppinyuinhtnpkknx1";
    public static final String ZTYSPPINYUINTKTBICDX2    = "ztysppinyuintktbicdx2";
    public static final String ZTYSPPINYUINHTNPKKNX2    = "ztysppinyuinhtnpkknx2";
    public static final String ZTYSPPINYUUINTKYKKGUSDKBN = "ztysppinyuuintkykkgusdkbn";
    public static final String ZTYSPPINYUINTKYKPWRBKKBN = "ztysppinyuintkykpwrbkkbn";
    public static final String ZTYYOBIV7X2              = "ztyyobiv7x2";
    public static final String ZTYSIJNBYUTKYKSYURUIKGU  = "ztysijnbyutkyksyuruikgu";
    public static final String ZTYSEIJINBYOUTOKUYAKUKIKAN = "ztyseijinbyoutokuyakukikan";
    public static final String ZTYSEIJINBYOUTKYKPHRKKKN = "ztyseijinbyoutkykphrkkkn";
    public static final String ZTYSEIJINBYOUTOKUYAKUNTGK = "ztyseijinbyoutokuyakuntgk";
    public static final String ZTYSEIJINBYOUTOKUYAKUP   = "ztyseijinbyoutokuyakup";
    public static final String ZTYSIJNBYUTKJYURYUMSHYUTN = "ztysijnbyutkjyuryumshyutn";
    public static final String ZTYSEIJINBYOUTOKUJYOUP   = "ztyseijinbyoutokujyoup";
    public static final String ZTYSEIJINBYOUTOKUTEIBUICDX1 = "ztyseijinbyoutokuteibuicdx1";
    public static final String ZTYSEIJINBYOUHUTANPOKIKANX1 = "ztyseijinbyouhutanpokikanx1";
    public static final String ZTYSEIJINBYOUTOKUTEIBUICDX2 = "ztyseijinbyoutokuteibuicdx2";
    public static final String ZTYSEIJINBYOUHUTANPOKIKANX2 = "ztyseijinbyouhutanpokikanx2";
    public static final String ZTYSEIJINBYOUTKYKKGUSDKBN = "ztyseijinbyoutkykkgusdkbn";
    public static final String ZTYSIJNBYUTKYKGANKYUHGTKBN = "ztysijnbyutkykgankyuhgtkbn";
    public static final String ZTYSIJNBYUTKYKPWRBKKBN   = "ztysijnbyutkykpwrbkkbn";
    public static final String ZTYSIJNBYUTKYKKUSNMNRYOAGE = "ztysijnbyutkykkusnmnryoage";
    public static final String ZTYYOBIV4X11             = "ztyyobiv4x11";
    public static final String ZTYHEIYOUBARAIKBN        = "ztyheiyoubaraikbn";
    public static final String ZTYHIYUBRIAITSYONO       = "ztyhiyubriaitsyono";
    public static final String ZTYHIYUBRIAITHRKKEIROKBN = "ztyhiyubriaithrkkeirokbn";
    public static final String ZTYHEIYOUBARAIAITEKIHONS = "ztyheiyoubaraiaitekihons";
    public static final String ZTYHIYUBRIGUKITNKNITJBRKHNS = "ztyhiyubrigukitnknitjbrkhns";
    public static final String ZTYHEIYOUBARAIAITESIBOUS = "ztyheiyoubaraiaitesibous";
    public static final String ZTYHIYUBRIGUKITNKNITJBRSBUS = "ztyhiyubrigukitnknitjbrsbus";
    public static final String ZTYHEIYOUBARAIAITESYUUSEIS = "ztyheiyoubaraiaitesyuuseis";
    public static final String ZTYHEIYOUBARAIAITEHRKP   = "ztyheiyoubaraiaitehrkp";
    public static final String ZTYHIYUBRIAITSYKYKP      = "ztyhiyubriaitsykykp";
    public static final String ZTYHEIYOUBARAIAITEMRTIS  = "ztyheiyoubaraiaitemrtis";
    public static final String ZTYHIYUBRIGUKIAITKZKMRTIS = "ztyhiyubrigukiaitkzkmrtis";
    public static final String ZTYTUKIBARAIKYKTENKANHYJ = "ztytukibaraikyktenkanhyj";
    public static final String ZTYBONUSHARAIHRKKIGETU1  = "ztybonusharaihrkkigetu1";
    public static final String ZTYBONUSHARAIHRKKIGETU2  = "ztybonusharaihrkkigetu2";
    public static final String ZTYHIYUBRIAITSIZNMRTIS   = "ztyhiyubriaitsiznmrtis";
    public static final String ZTYHIYUBRIAITTIGNMRTIS   = "ztyhiyubriaittignmrtis";
    public static final String ZTYTKJYKBN               = "ztytkjykbn";
    public static final String ZTYSAKUGENKIKAN          = "ztysakugenkikan";
    public static final String ZTYRYOUMASIHYOUTEN       = "ztyryoumasihyouten";
    public static final String ZTYTOKUJYOUP             = "ztytokujyoup";
    public static final String ZTYHJNCD                 = "ztyhjncd";
    public static final String ZTYHJNJIGYOSYOCD         = "ztyhjnjigyosyocd";
    public static final String ZTYJYUUGYOUINSUU         = "ztyjyuugyouinsuu";
    public static final String ZTYIKTKAISUU             = "ztyiktkaisuu";
    public static final String ZTYZNNKAI                = "ztyznnkai";
    public static final String ZTYKYKTSNATKITKYKKBN     = "ztykyktsnatkitkykkbn";
    public static final String ZTYKYKTSNATKITKYKSTAGEKBN = "ztykyktsnatkitkykstagekbn";
    public static final String ZTYPMENTOKUYAKUKBN       = "ztypmentokuyakukbn";
    public static final String ZTYYOBIV3                = "ztyyobiv3";
    public static final String ZTYTKYKZNNUNYUKNGK       = "ztytkykznnunyukngk";
    public static final String ZTYSYOKAIPNYUUKINHOUHOUKBN = "ztysyokaipnyuukinhouhoukbn";
    public static final String ZTYHTNKNKYKSYONOX1       = "ztyhtnknkyksyonox1";
    public static final String ZTYHTNKNKYKHKNSYURUIKGUX1 = "ztyhtnknkykhknsyuruikgux1";
    public static final String ZTYTENKANUKETUKEYMDX1    = "ztytenkanuketukeymdx1";
    public static final String ZTYHTNKNKYKKYKYMDX1      = "ztyhtnknkykkykymdx1";
    public static final String ZTYHTNKNKYKHKNKKNX1      = "ztyhtnknkykhknkknx1";
    public static final String ZTYHTNKNKYKPHRKKKNX1     = "ztyhtnknkykphrkkknx1";
    public static final String ZTYHTNKNKYKHRKKAISUUKBNX1 = "ztyhtnknkykhrkkaisuukbnx1";
    public static final String ZTYHTNKNKYKHRKKEIROKBNX1 = "ztyhtnknkykhrkkeirokbnx1";
    public static final String ZTYTNKNUKTKZNGTKIJYUHYJX1 = "ztytnknuktkzngtkijyuhyjx1";
    public static final String ZTYHTNKNKYKMRTISYURUIKGUX1 = "ztyhtnknkykmrtisyuruikgux1";
    public static final String ZTYHTNKNKYKSYONOX2       = "ztyhtnknkyksyonox2";
    public static final String ZTYHTNKNKYKHKNSYURUIKGUX2 = "ztyhtnknkykhknsyuruikgux2";
    public static final String ZTYTENKANUKETUKEYMDX2    = "ztytenkanuketukeymdx2";
    public static final String ZTYHTNKNKYKKYKYMDX2      = "ztyhtnknkykkykymdx2";
    public static final String ZTYHTNKNKYKHKNKKNX2      = "ztyhtnknkykhknkknx2";
    public static final String ZTYHTNKNKYKPHRKKKNX2     = "ztyhtnknkykphrkkknx2";
    public static final String ZTYHTNKNKYKHRKKAISUUKBNX2 = "ztyhtnknkykhrkkaisuukbnx2";
    public static final String ZTYHTNKNKYKHRKKEIROKBNX2 = "ztyhtnknkykhrkkeirokbnx2";
    public static final String ZTYTNKNUKTKZNGTKIJYUHYJX2 = "ztytnknuktkzngtkijyuhyjx2";
    public static final String ZTYHTNKNKYKMRTISYURUIKGUX2 = "ztyhtnknkykmrtisyuruikgux2";
    public static final String ZTYHTNKNKYKSYONOX3       = "ztyhtnknkyksyonox3";
    public static final String ZTYHTNKNKYKHKNSYURUIKGUX3 = "ztyhtnknkykhknsyuruikgux3";
    public static final String ZTYTENKANUKETUKEYMDX3    = "ztytenkanuketukeymdx3";
    public static final String ZTYHTNKNKYKKYKYMDX3      = "ztyhtnknkykkykymdx3";
    public static final String ZTYHTNKNKYKHKNKKNX3      = "ztyhtnknkykhknkknx3";
    public static final String ZTYHTNKNKYKPHRKKKNX3     = "ztyhtnknkykphrkkknx3";
    public static final String ZTYHTNKNKYKHRKKAISUUKBNX3 = "ztyhtnknkykhrkkaisuukbnx3";
    public static final String ZTYHTNKNKYKHRKKEIROKBNX3 = "ztyhtnknkykhrkkeirokbnx3";
    public static final String ZTYTNKNUKTKZNGTKIJYUHYJX3 = "ztytnknuktkzngtkijyuhyjx3";
    public static final String ZTYHTNKNKYKMRTISYURUIKGUX3 = "ztyhtnknkykmrtisyuruikgux3";
    public static final String ZTYHTNKNKYKSYONOX4       = "ztyhtnknkyksyonox4";
    public static final String ZTYHTNKNKYKHKNSYURUIKGUX4 = "ztyhtnknkykhknsyuruikgux4";
    public static final String ZTYTENKANUKETUKEYMDX4    = "ztytenkanuketukeymdx4";
    public static final String ZTYHTNKNKYKKYKYMDX4      = "ztyhtnknkykkykymdx4";
    public static final String ZTYHTNKNKYKHKNKKNX4      = "ztyhtnknkykhknkknx4";
    public static final String ZTYHTNKNKYKPHRKKKNX4     = "ztyhtnknkykphrkkknx4";
    public static final String ZTYHTNKNKYKHRKKAISUUKBNX4 = "ztyhtnknkykhrkkaisuukbnx4";
    public static final String ZTYHTNKNKYKHRKKEIROKBNX4 = "ztyhtnknkykhrkkeirokbnx4";
    public static final String ZTYTNKNUKTKZNGTKIJYUHYJX4 = "ztytnknuktkzngtkijyuhyjx4";
    public static final String ZTYHTNKNKYKMRTISYURUIKGUX4 = "ztyhtnknkykmrtisyuruikgux4";
    public static final String ZTYHTNKNKYKSYONOX5       = "ztyhtnknkyksyonox5";
    public static final String ZTYHTNKNKYKHKNSYURUIKGUX5 = "ztyhtnknkykhknsyuruikgux5";
    public static final String ZTYTENKANUKETUKEYMDX5    = "ztytenkanuketukeymdx5";
    public static final String ZTYHTNKNKYKKYKYMDX5      = "ztyhtnknkykkykymdx5";
    public static final String ZTYHTNKNKYKHKNKKNX5      = "ztyhtnknkykhknkknx5";
    public static final String ZTYHTNKNKYKPHRKKKNX5     = "ztyhtnknkykphrkkknx5";
    public static final String ZTYHTNKNKYKHRKKAISUUKBNX5 = "ztyhtnknkykhrkkaisuukbnx5";
    public static final String ZTYHTNKNKYKHRKKEIROKBNX5 = "ztyhtnknkykhrkkeirokbnx5";
    public static final String ZTYTNKNUKTKZNGTKIJYUHYJX5 = "ztytnknuktkzngtkijyuhyjx5";
    public static final String ZTYHTNKNKYKMRTISYURUIKGUX5 = "ztyhtnknkykmrtisyuruikgux5";
    public static final String ZTYHTNKNKYKSYONOX6       = "ztyhtnknkyksyonox6";
    public static final String ZTYHTNKNKYKHKNSYURUIKGUX6 = "ztyhtnknkykhknsyuruikgux6";
    public static final String ZTYTENKANUKETUKEYMDX6    = "ztytenkanuketukeymdx6";
    public static final String ZTYHTNKNKYKKYKYMDX6      = "ztyhtnknkykkykymdx6";
    public static final String ZTYHTNKNKYKHKNKKNX6      = "ztyhtnknkykhknkknx6";
    public static final String ZTYHTNKNKYKPHRKKKNX6     = "ztyhtnknkykphrkkknx6";
    public static final String ZTYHTNKNKYKHRKKAISUUKBNX6 = "ztyhtnknkykhrkkaisuukbnx6";
    public static final String ZTYHTNKNKYKHRKKEIROKBNX6 = "ztyhtnknkykhrkkeirokbnx6";
    public static final String ZTYTNKNUKTKZNGTKIJYUHYJX6 = "ztytnknuktkzngtkijyuhyjx6";
    public static final String ZTYHTNKNKYKMRTISYURUIKGUX6 = "ztyhtnknkykmrtisyuruikgux6";
    public static final String ZTYGUKIHTNKNKYKKHNS      = "ztygukihtnknkykkhns";
    public static final String ZTYGUKIHTNKNKYKSBUS      = "ztygukihtnknkyksbus";
    public static final String ZTYGUKIHTNKNKYKHNTIYUP   = "ztygukihtnknkykhntiyup";
    public static final String ZTYGUKIHTNKNKYKSIGWRMSTKYKS = "ztygukihtnknkyksigwrmstkyks";
    public static final String ZTYGUKIHTNKNKYKSYUGITKYKS = "ztygukihtnknkyksyugitkyks";
    public static final String ZTYGUKIHTNKNSIGNYINTKYKNTGK = "ztygukihtnknsignyintkykntgk";
    public static final String ZTYGUKIHTNKNKNKUTKYKNTGK = "ztygukihtnknknkutkykntgk";
    public static final String ZTYGUKIHTNKNKYKMODS      = "ztygukihtnknkykmods";
    public static final String ZTYGOUKEITENKANKAKAKU    = "ztygoukeitenkankakaku";
    public static final String ZTYGUKITNKNJSKNNJYNBKN   = "ztygukitnknjsknnjynbkn";
    public static final String ZTYGUKITNKNSISNKSTKKNGK  = "ztygukitnknsisnkstkkngk";
    public static final String ZTYGUKITNKNSISNTTKEKNGK  = "ztygukitnknsisnttkekngk";
    public static final String ZTYGOUKEITENKANSEISAND   = "ztygoukeitenkanseisand";
    public static final String ZTYGUKITNKNSISNMKIKP     = "ztygukitnknsisnmkikp";
    public static final String ZTYGUKITNKNSISNSNTKNGK   = "ztygukitnknsisnsntkngk";
    public static final String ZTYGUKITNKNKHNBBNKIYKKUJYGK = "ztygukitnknkhnbbnkiykkujygk";
    public static final String ZTYGUKITNKNTIKBBNKIYKKUJYGK = "ztygukitnkntikbbnkiykkujygk";
    public static final String ZTYGUKITNKNITJBRTIKS     = "ztygukitnknitjbrtiks";
    public static final String ZTYSETHOKENNO            = "ztysethokenno";
    public static final String ZTYSCKBN                 = "ztysckbn";
    public static final String ZTYENJYOSYACD            = "ztyenjyosyacd";
    public static final String ZTYNAIBUWARIMODOSIGAKU   = "ztynaibuwarimodosigaku";
    public static final String ZTYKEIYAKUKAKUNINSYURUIKBN = "ztykeiyakukakuninsyuruikbn";
    public static final String ZTYSOUJIKEITENKANHYOUJI  = "ztysoujikeitenkanhyouji";
    public static final String ZTYTENKANJISKETTEIHOUHOUKBN = "ztytenkanjisketteihouhoukbn";
    public static final String ZTYKEIKANENSUUKBN        = "ztykeikanensuukbn";
    public static final String ZTYHTNKNKYKHHKNSYTISYUKBNX1 = "ztyhtnknkykhhknsytisyukbnx1";
    public static final String ZTYHTNKNKYKHHKNSYTISYUKBNX2 = "ztyhtnknkykhhknsytisyukbnx2";
    public static final String ZTYHTNKNKYKHHKNSYTISYUKBNX3 = "ztyhtnknkykhhknsytisyukbnx3";
    public static final String ZTYHTNKNKYKHHKNSYTISYUKBNX4 = "ztyhtnknkykhhknsytisyukbnx4";
    public static final String ZTYHTNKNKYKHHKNSYTISYUKBNX5 = "ztyhtnknkykhhknsytisyukbnx5";
    public static final String ZTYHTNKNKYKHHKNSYTISYUKBNX6 = "ztyhtnknkykhhknsytisyukbnx6";
    public static final String ZTYKKTIJGUKIPBBNTNKNS    = "ztykktijgukipbbntnkns";
    public static final String ZTYSYONENDOSYOKAIP       = "ztysyonendosyokaip";
    public static final String ZTYSYONENDO2KAIMEIKOUP   = "ztysyonendo2kaimeikoup";
    public static final String ZTYJINENDOIKOUP          = "ztyjinendoikoup";
    public static final String ZTYSYUKEIYAKUSIKYUUKISOGAKU = "ztysyukeiyakusikyuukisogaku";
    public static final String ZTYSYKYKNENHANTATSKYUKSGK = "ztysykyknenhantatskyuksgk";
    public static final String ZTYMARUTEISIKYUUKISOGAKU = "ztymaruteisikyuukisogaku";
    public static final String ZTYITJBRZUGKSKYUKSGKX1   = "ztyitjbrzugkskyuksgkx1";
    public static final String ZTYITJBRZUGKSKYUKSGKX2   = "ztyitjbrzugkskyuksgkx2";
    public static final String ZTYITJBRZGKNNHNTATSKYKSGKX1 = "ztyitjbrzgknnhntatskyksgkx1";
    public static final String ZTYITJBRZGKNNHNTATSKYKSGKX2 = "ztyitjbrzgknnhntatskyksgkx2";
    public static final String ZTYKZKMRTISKYUKSGK       = "ztykzkmrtiskyuksgk";
    public static final String ZTYITIBITJBRSKYUKSGK     = "ztyitibitjbrskyuksgk";
    public static final String ZTYITBITJBRNNHNTATSKYUKSGK = "ztyitbitjbrnnhntatskyuksgk";
    public static final String ZTYSYKYKKSNBSYUTAT       = "ztysykykksnbsyutat";
    public static final String ZTYITJBRZUGKKSNBSYUTATX1 = "ztyitjbrzugkksnbsyutatx1";
    public static final String ZTYITJBRZUGKKSNBSYUTATX2 = "ztyitjbrzugkksnbsyutatx2";
    public static final String ZTYITIBITJBRKSNBSYUTAT   = "ztyitibitjbrksnbsyutat";
    public static final String ZTYJYUNKENSUU            = "ztyjyunkensuu";
    public static final String ZTYKANSANKENSUU          = "ztykansankensuu";
    public static final String ZTYITIBUITIJIBARAIKIKAN  = "ztyitibuitijibaraikikan";
    public static final String ZTYITIBUITIJIBARAIS      = "ztyitibuitijibarais";
    public static final String ZTYITIBUITIJIBARAIP      = "ztyitibuitijibaraip";
    public static final String ZTYITIBITJBRSDTPDTKBN    = "ztyitibitjbrsdtpdtkbn";
    public static final String ZTYITIBUITIJIBARAISYUUSEIS = "ztyitibuitijibaraisyuuseis";
    public static final String ZTYITIBITJBRMODSSKGNHYJ  = "ztyitibitjbrmodsskgnhyj";
    public static final String ZTYSUURIYOUSYORIYM       = "ztysuuriyousyoriym";
    public static final String ZTYSYOSINSINSAHOUHOUKBN  = "ztysyosinsinsahouhoukbn";
    public static final String ZTYSAISINSINSAHOUHOUKBN  = "ztysaisinsinsahouhoukbn";
    public static final String ZTYSEIZONMRTISYURUIKGU   = "ztyseizonmrtisyuruikgu";
    public static final String ZTYSEIZONMARUTEIKIKAN    = "ztyseizonmaruteikikan";
    public static final String ZTYSEIZONMRTIPHRKKKN     = "ztyseizonmrtiphrkkkn";
    public static final String ZTYSEIZONMARUTEIS        = "ztyseizonmaruteis";
    public static final String ZTYSEIZONMARUTEIP        = "ztyseizonmaruteip";
    public static final String ZTYSEIZONMARUTEISYUUSEIS = "ztyseizonmaruteisyuuseis";
    public static final String ZTYSEIZONMRTIMODSSKGNHYJ = "ztyseizonmrtimodsskgnhyj";
    public static final String ZTYSIZNMRTITKJYUKBN      = "ztysiznmrtitkjyukbn";
    public static final String ZTYSIZNMRTITKJYUSKGNKKN  = "ztysiznmrtitkjyuskgnkkn";
    public static final String ZTYSIZNMRTITKJYURYUMSHYUTN = "ztysiznmrtitkjyuryumshyutn";
    public static final String ZTYSIZNMRTITKJYUP        = "ztysiznmrtitkjyup";
    public static final String ZTYSIZNMRTISKYUKSGK      = "ztysiznmrtiskyuksgk";
    public static final String ZTYHTNKNKYKSIZNMRTSYRIKGUX1 = "ztyhtnknkyksiznmrtsyrikgux1";
    public static final String ZTYHTNKNKYKSIZNMRTSYRIKGUX2 = "ztyhtnknkyksiznmrtsyrikgux2";
    public static final String ZTYHTNKNKYKSIZNMRTSYRIKGUX3 = "ztyhtnknkyksiznmrtsyrikgux3";
    public static final String ZTYHTNKNKYKSIZNMRTSYRIKGUX4 = "ztyhtnknkyksiznmrtsyrikgux4";
    public static final String ZTYHTNKNKYKSIZNMRTSYRIKGUX5 = "ztyhtnknkyksiznmrtsyrikgux5";
    public static final String ZTYHTNKNKYKSIZNMRTSYRIKGUX6 = "ztyhtnknkyksiznmrtsyrikgux6";
    public static final String ZTYSURYUSIZNMRTIPWRBKKBN = "ztysuryusiznmrtipwrbkkbn";
    public static final String ZTYSIZNMRTIPWRBKKBN      = "ztysiznmrtipwrbkkbn";
    public static final String ZTYSIZNMRTITNKNYUGUKBN   = "ztysiznmrtitnknyugukbn";
    public static final String ZTYSEIZONMRTIKGUSDKBN    = "ztyseizonmrtikgusdkbn";
    public static final String ZTYYOBIV1                = "ztyyobiv1";
    public static final String ZTYDAI2HIHOKENSYAMEI     = "ztydai2hihokensyamei";
    public static final String ZTYDAI2KANJIHIHOKENSYAMEI = "ztydai2kanjihihokensyamei";
    public static final String ZTYDAI2HIHOKENSYASEIYMD  = "ztydai2hihokensyaseiymd";
    public static final String ZTYDAI2HIHOKENSYASEIBETUKBN = "ztydai2hihokensyaseibetukbn";
    public static final String ZTYDAI2HIHKNSYAHNSKHKNCD = "ztydai2hihknsyahnskhkncd";
    public static final String ZTYDAI2HHKNNEN           = "ztydai2hhknnen";
    public static final String ZTYDAI2HIHKNSYAKIKYKARIHYJ = "ztydai2hihknsyakikykarihyj";
    public static final String ZTYKYKSYDI2HIHKNSYADUITHYJ = "ztykyksydi2hihknsyaduithyj";
    public static final String ZTYDAI2SYOSINSINSAHOUHOUKBN = "ztydai2syosinsinsahouhoukbn";
    public static final String ZTYDAI2SAISINSINSAHOUHOUKBN = "ztydai2saisinsinsahouhoukbn";
    public static final String ZTYDAI2SYOKUGYOUCD       = "ztydai2syokugyoucd";
    public static final String ZTYDAI2SAKUGENKIKAN      = "ztydai2sakugenkikan";
    public static final String ZTYDAI2RYOUMASIHYOUTEN   = "ztydai2ryoumasihyouten";
    public static final String ZTYMRTIDI2SKGNKKN        = "ztymrtidi2skgnkkn";
    public static final String ZTYMRTIDI2RYUMSHYUTN     = "ztymrtidi2ryumshyutn";
    public static final String ZTYDI2KYKKKNNSYRIKBN     = "ztydi2kykkknnsyrikbn";
    public static final String ZTYTIGNMRTIDI2SKGNKKN    = "ztytignmrtidi2skgnkkn";
    public static final String ZTYTIGNMRTIDI2RYUMSHYUTN = "ztytignmrtidi2ryumshyutn";
    public static final String ZTYDAI2SYOSINHONNINKKNNKBN = "ztydai2syosinhonninkknnkbn";
    public static final String ZTYDI2SISNHONNINKKNNKBN  = "ztydi2sisnhonninkknnkbn";
    public static final String ZTYYOBIV9X6              = "ztyyobiv9x6";
    public static final String ZTYDI2SYUGITKYKSYRIKGU   = "ztydi2syugitkyksyrikgu";
    public static final String ZTYDAI2SYOUGAITOKUYAKUKIKAN = "ztydai2syougaitokuyakukikan";
    public static final String ZTYDI2SYUGITKYKPHRKKKN   = "ztydi2syugitkykphrkkkn";
    public static final String ZTYDAI2SYOUGAITOKUYAKUS  = "ztydai2syougaitokuyakus";
    public static final String ZTYDAI2SYOUGAITOKUYAKUP  = "ztydai2syougaitokuyakup";
    public static final String ZTYDI2SYUGITKYKGTKBN     = "ztydi2syugitkykgtkbn";
    public static final String ZTYDI2SYUGITKYKKGUSDKBN  = "ztydi2syugitkykkgusdkbn";
    public static final String ZTYDI2SYUGITKYKPWRBKKBN  = "ztydi2syugitkykpwrbkkbn";
    public static final String ZTYYOBIV8                = "ztyyobiv8";
    public static final String ZTYDI2SIGIWRMSTKYKSYRIKGU = "ztydi2sigiwrmstkyksyrikgu";
    public static final String ZTYDI2SIGIWRMSTKYKKKN    = "ztydi2sigiwrmstkykkkn";
    public static final String ZTYDI2SIGIWRMSTKYKPHRKKKN = "ztydi2sigiwrmstkykphrkkkn";
    public static final String ZTYDI2SIGIWRMSTKYKS      = "ztydi2sigiwrmstkyks";
    public static final String ZTYDI2SIGIWRMSTKYKP      = "ztydi2sigiwrmstkykp";
    public static final String ZTYDI2SIGIWRMSTKYKKGUSDKBN = "ztydi2sigiwrmstkykkgusdkbn";
    public static final String ZTYDI2SIGIWRMSTKYKPWRBKKBN = "ztydi2sigiwrmstkykpwrbkkbn";
    public static final String ZTYYOBIV9X7              = "ztyyobiv9x7";
    public static final String ZTYDI2SIGINYUINTKYKSYRIKGU = "ztydi2siginyuintkyksyrikgu";
    public static final String ZTYDI2SIGINYUINTKYKKKN   = "ztydi2siginyuintkykkkn";
    public static final String ZTYDI2SIGINYUINTKYKPHRKKKN = "ztydi2siginyuintkykphrkkkn";
    public static final String ZTYDI2SIGINYUINTKYKNTGK  = "ztydi2siginyuintkykntgk";
    public static final String ZTYDI2SIGINYUINTKYKP     = "ztydi2siginyuintkykp";
    public static final String ZTYDI2SIGINYUINTKYKGTKBN = "ztydi2siginyuintkykgtkbn";
    public static final String ZTYDI2SIGINYINTKYKKGUSDKBN = "ztydi2siginyintkykkgusdkbn";
    public static final String ZTYDI2SIGINYUINTKYKPWRBKKBN = "ztydi2siginyuintkykpwrbkkbn";
    public static final String ZTYYOBIV10X3             = "ztyyobiv10x3";
    public static final String ZTYDI2SPPINYUINTKYKSYRIKGU = "ztydi2sppinyuintkyksyrikgu";
    public static final String ZTYDI2SPPINYUINTKYKKKN   = "ztydi2sppinyuintkykkkn";
    public static final String ZTYDI2SPPINYUINTKYKPHRKKKN = "ztydi2sppinyuintkykphrkkkn";
    public static final String ZTYDI2SPPINYUINTKYKNTGK  = "ztydi2sppinyuintkykntgk";
    public static final String ZTYDI2SPPINYUINTKYKP     = "ztydi2sppinyuintkykp";
    public static final String ZTYDI2SPPINYUINTKYKGTKBN = "ztydi2sppinyuintkykgtkbn";
    public static final String ZTYDI2SPPINYINTKJYRYUMSHYTN = "ztydi2sppinyintkjyryumshytn";
    public static final String ZTYDI2SPPINYUINTKJYUP    = "ztydi2sppinyuintkjyup";
    public static final String ZTYDI2SPPINYUINTKTBICDX1 = "ztydi2sppinyuintktbicdx1";
    public static final String ZTYDI2SPPINYUINHTNPKKNX1 = "ztydi2sppinyuinhtnpkknx1";
    public static final String ZTYDI2SPPINYUINTKTBICDX2 = "ztydi2sppinyuintktbicdx2";
    public static final String ZTYDI2SPPINYUINHTNPKKNX2 = "ztydi2sppinyuinhtnpkknx2";
    public static final String ZTYDI2SPPINYINTKYKKGUSDKBN = "ztydi2sppinyintkykkgusdkbn";
    public static final String ZTYDI2SPPINYUINTKYKPWRBKKBN = "ztydi2sppinyuintkykpwrbkkbn";
    public static final String ZTYYOBIV3X2              = "ztyyobiv3x2";
    public static final String ZTYDI2SIJNBYUTKYKSYRIKGU = "ztydi2sijnbyutkyksyrikgu";
    public static final String ZTYDI2SIJNBYUTKYKKKN     = "ztydi2sijnbyutkykkkn";
    public static final String ZTYDI2SIJNBYUTKYKPHRKKKN = "ztydi2sijnbyutkykphrkkkn";
    public static final String ZTYDI2SIJNBYUTKYKNTGK    = "ztydi2sijnbyutkykntgk";
    public static final String ZTYDAI2SEIJINBYOUTOKUYAKUP = "ztydai2seijinbyoutokuyakup";
    public static final String ZTYDI2SIJNBYUTKJYURYMSHYTN = "ztydi2sijnbyutkjyurymshytn";
    public static final String ZTYDAI2SEIJINBYOUTOKUJYOUP = "ztydai2seijinbyoutokujyoup";
    public static final String ZTYDI2SIJNBYUTKTBICDX1   = "ztydi2sijnbyutktbicdx1";
    public static final String ZTYDI2SIJNBYUHTNPKKNX1   = "ztydi2sijnbyuhtnpkknx1";
    public static final String ZTYDI2SIJNBYUTKTBICDX2   = "ztydi2sijnbyutktbicdx2";
    public static final String ZTYDI2SIJNBYUHTNPKKNX2   = "ztydi2sijnbyuhtnpkknx2";
    public static final String ZTYDI2SIJNBYUTKYKKGUSDKBN = "ztydi2sijnbyutkykkgusdkbn";
    public static final String ZTYDI2SIJNBYTKYKGANKYHGTKBN = "ztydi2sijnbytkykgankyhgtkbn";
    public static final String ZTYDI2SIJNBYUTKYKPWRBKKBN = "ztydi2sijnbyutkykpwrbkkbn";
    public static final String ZTYYOBIV3X3              = "ztyyobiv3x3";
    public static final String ZTYDAI2JYOUKENTUKIHYOUJI = "ztydai2jyoukentukihyouji";
    public static final String ZTYTIGNMRTISYUKGU        = "ztytignmrtisyukgu";
    public static final String ZTYTEIGENMARUTEIKIKAN    = "ztyteigenmaruteikikan";
    public static final String ZTYTEIGENMRTIPHRKKKN     = "ztyteigenmrtiphrkkkn";
    public static final String ZTYTEIGENMARUTEIS        = "ztyteigenmaruteis";
    public static final String ZTYTEIGENMARUTEIP        = "ztyteigenmaruteip";
    public static final String ZTYTEIGENMARUTEISYUUSEIS = "ztyteigenmaruteisyuuseis";
    public static final String ZTYTEIGENMRTIMODSSAKUGENHYJ = "ztyteigenmrtimodssakugenhyj";
    public static final String ZTYTIGNMRTITKJYUKBN      = "ztytignmrtitkjyukbn";
    public static final String ZTYTIGNMRTITKJYUSKGNKKN  = "ztytignmrtitkjyuskgnkkn";
    public static final String ZTYTIGNMRTITKJYURYUMSHYUTN = "ztytignmrtitkjyuryumshyutn";
    public static final String ZTYTIGNMRTITKJYUP        = "ztytignmrtitkjyup";
    public static final String ZTYTIGNMRTISKYUKSGK      = "ztytignmrtiskyuksgk";
    public static final String ZTYHTNKNKYKTIGNMRTSYRIKGUX1 = "ztyhtnknkyktignmrtsyrikgux1";
    public static final String ZTYHTNKNKYKTIGNMRTSYRIKGUX2 = "ztyhtnknkyktignmrtsyrikgux2";
    public static final String ZTYHTNKNKYKTIGNMRTSYRIKGUX3 = "ztyhtnknkyktignmrtsyrikgux3";
    public static final String ZTYHTNKNKYKTIGNMRTSYRIKGUX4 = "ztyhtnknkyktignmrtsyrikgux4";
    public static final String ZTYHTNKNKYKTIGNMRTSYRIKGUX5 = "ztyhtnknkyktignmrtsyrikgux5";
    public static final String ZTYHTNKNKYKTIGNMRTSYRIKGUX6 = "ztyhtnknkyktignmrtsyrikgux6";
    public static final String ZTYSURYUTIGNMRTIPWRBKKBN = "ztysuryutignmrtipwrbkkbn";
    public static final String ZTYTIGNMRTIPWRBKKBN      = "ztytignmrtipwrbkkbn";
    public static final String ZTYTIGNMRTITNKNYUGUKBN   = "ztytignmrtitnknyugukbn";
    public static final String ZTYTEIGENMRTIKGUSDKBN    = "ztyteigenmrtikgusdkbn";
    public static final String ZTYYOBIV1X2              = "ztyyobiv1x2";
    public static final String ZTYTKTSPPISETKYKKBN      = "ztytktsppisetkykkbn";
    public static final String ZTYJYUDMNSISKKNSETKYKKBN = "ztyjyudmnsiskknsetkykkbn";
    public static final String ZTYYOBIV8X2              = "ztyyobiv8x2";
    public static final String ZTYSETAITESYONO1         = "ztysetaitesyono1";
    public static final String ZTYSETAITEHOKENSYURUIKIGOU1 = "ztysetaitehokensyuruikigou1";
    public static final String ZTYSETAITEMRTISYURUIKGU1 = "ztysetaitemrtisyuruikgu1";
    public static final String ZTYSETAITESIZNMRTISYURUI1 = "ztysetaitesiznmrtisyurui1";
    public static final String ZTYSETAITETIGNMRTISYURUI1 = "ztysetaitetignmrtisyurui1";
    public static final String ZTYSETAITEKIHONBUBUNS1   = "ztysetaitekihonbubuns1";
    public static final String ZTYSETGUKITNKNITJBRKHNS1 = "ztysetgukitnknitjbrkhns1";
    public static final String ZTYSETAITESIBOUS1        = "ztysetaitesibous1";
    public static final String ZTYSETGUKITNKNITJBRSBUS1 = "ztysetgukitnknitjbrsbus1";
    public static final String ZTYSETAITESYUUSEIS1      = "ztysetaitesyuuseis1";
    public static final String ZTYSETAITEHARAIKOMIP1    = "ztysetaiteharaikomip1";
    public static final String ZTYSETAITESYUKEIYAKUBUBUNP1 = "ztysetaitesyukeiyakububunp1";
    public static final String ZTYSETAITGUKIKZKMRTIS1   = "ztysetaitgukikzkmrtis1";
    public static final String ZTYSETAITETENKANKYKHYJ1  = "ztysetaitetenkankykhyj1";
    public static final String ZTYSETAITESITEIMHRKP1    = "ztysetaitesiteimhrkp1";
    public static final String ZTYSETAITESITEIMSYKYKP1  = "ztysetaitesiteimsykykp1";
    public static final String ZTYSETAITENKMRTISYURUI1  = "ztysetaitenkmrtisyurui1";
    public static final String ZTYYOBIV18               = "ztyyobiv18";

    private final PKZT_Sp2RnduyuSouseiritu1Ty primaryKey;

    public GenZT_Sp2RnduyuSouseiritu1Ty() {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu1Ty();
    }

    public GenZT_Sp2RnduyuSouseiritu1Ty(String pZtyktgysyono) {
        primaryKey = new PKZT_Sp2RnduyuSouseiritu1Ty(pZtyktgysyono);
    }

    @Transient
    @Override
    public PKZT_Sp2RnduyuSouseiritu1Ty getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Sp2RnduyuSouseiritu1Ty> getMetaClass() {
        return QZT_Sp2RnduyuSouseiritu1Ty.class;
    }

    private String ztyktgysyrymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKTGYSYRYMD)
    public String getZtyktgysyrymd() {
        return ztyktgysyrymd;
    }

    public void setZtyktgysyrymd(String pZtyktgysyrymd) {
        ztyktgysyrymd = pZtyktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKTGYSYONO)
    public String getZtyktgysyono() {
        return getPrimaryKey().getZtyktgysyono();
    }

    public void setZtyktgysyono(String pZtyktgysyono) {
        getPrimaryKey().setZtyktgysyono(pZtyktgysyono);
    }

    private String ztyktgyfilerenno;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKTGYFILERENNO)
    public String getZtyktgyfilerenno() {
        return ztyktgyfilerenno;
    }

    public void setZtyktgyfilerenno(String pZtyktgyfilerenno) {
        ztyktgyfilerenno = pZtyktgyfilerenno;
    }

    private String ztysyono;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYONO)
    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }

    private String ztyaatukaisyasisyacd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYAATUKAISYASISYACD)
    public String getZtyaatukaisyasisyacd() {
        return ztyaatukaisyasisyacd;
    }

    public void setZtyaatukaisyasisyacd(String pZtyaatukaisyasisyacd) {
        ztyaatukaisyasisyacd = pZtyaatukaisyasisyacd;
    }

    private String ztymosno;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMOSNO)
    public String getZtymosno() {
        return ztymosno;
    }

    public void setZtymosno(String pZtymosno) {
        ztymosno = pZtymosno;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztykykymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private Long ztykihons;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private Long ztysibous;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIBOUS)
    public Long getZtysibous() {
        return ztysibous;
    }

    public void setZtysibous(Long pZtysibous) {
        ztysibous = pZtysibous;
    }

    private Long ztygyousekihyoukayouhosyous;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGYOUSEKIHYOUKAYOUHOSYOUS)
    public Long getZtygyousekihyoukayouhosyous() {
        return ztygyousekihyoukayouhosyous;
    }

    public void setZtygyousekihyoukayouhosyous(Long pZtygyousekihyoukayouhosyous) {
        ztygyousekihyoukayouhosyous = pZtygyousekihyoukayouhosyous;
    }

    private Long ztygukitnknitjbrkhns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKITNKNITJBRKHNS)
    public Long getZtygukitnknitjbrkhns() {
        return ztygukitnknitjbrkhns;
    }

    public void setZtygukitnknitjbrkhns(Long pZtygukitnknitjbrkhns) {
        ztygukitnknitjbrkhns = pZtygukitnknitjbrkhns;
    }

    private Long ztygukitnknitjbrsbus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKITNKNITJBRSBUS)
    public Long getZtygukitnknitjbrsbus() {
        return ztygukitnknitjbrsbus;
    }

    public void setZtygukitnknitjbrsbus(Long pZtygukitnknitjbrsbus) {
        ztygukitnknitjbrsbus = pZtygukitnknitjbrsbus;
    }

    private Long ztykktijgukitnknitjbrkhns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKKTIJGUKITNKNITJBRKHNS)
    public Long getZtykktijgukitnknitjbrkhns() {
        return ztykktijgukitnknitjbrkhns;
    }

    public void setZtykktijgukitnknitjbrkhns(Long pZtykktijgukitnknitjbrkhns) {
        ztykktijgukitnknitjbrkhns = pZtykktijgukitnknitjbrkhns;
    }

    private Long ztykktijgukitnknitjbrsbus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKKTIJGUKITNKNITJBRSBUS)
    public Long getZtykktijgukitnknitjbrsbus() {
        return ztykktijgukitnknitjbrsbus;
    }

    public void setZtykktijgukitnknitjbrsbus(Long pZtykktijgukitnknitjbrsbus) {
        ztykktijgukitnknitjbrsbus = pZtykktijgukitnknitjbrsbus;
    }

    private Long ztysyokaiharaikomip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOKAIHARAIKOMIP)
    public Long getZtysyokaiharaikomip() {
        return ztysyokaiharaikomip;
    }

    public void setZtysyokaiharaikomip(Long pZtysyokaiharaikomip) {
        ztysyokaiharaikomip = pZtysyokaiharaikomip;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztyryouritukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYRYOURITUKBN)
    public String getZtyryouritukbn() {
        return ztyryouritukbn;
    }

    public void setZtyryouritukbn(String pZtyryouritukbn) {
        ztyryouritukbn = pZtyryouritukbn;
    }

    private String ztytksyuannaikykkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTKSYUANNAIKYKKBN)
    public String getZtytksyuannaikykkbn() {
        return ztytksyuannaikykkbn;
    }

    public void setZtytksyuannaikykkbn(String pZtytksyuannaikykkbn) {
        ztytksyuannaikykkbn = pZtytksyuannaikykkbn;
    }

    private String ztysdpdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSDPDKBN)
    public String getZtysdpdkbn() {
        return ztysdpdkbn;
    }

    public void setZtysdpdkbn(String pZtysdpdkbn) {
        ztysdpdkbn = pZtysdpdkbn;
    }

    private String ztyanniskcd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private String ztyduketorihouhoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDUKETORIHOUHOUKBN)
    public String getZtyduketorihouhoukbn() {
        return ztyduketorihouhoukbn;
    }

    public void setZtyduketorihouhoukbn(String pZtyduketorihouhoukbn) {
        ztyduketorihouhoukbn = pZtyduketorihouhoukbn;
    }

    private String ztykyksyhhknsydouituhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKYKSYHHKNSYDOUITUHYOUJI)
    public String getZtykyksyhhknsydouituhyouji() {
        return ztykyksyhhknsydouituhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykyksyhhknsydouituhyouji(String pZtykyksyhhknsydouituhyouji) {
        ztykyksyhhknsydouituhyouji = pZtykyksyhhknsydouituhyouji;
    }

    private String ztykyksyakikykarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKYKSYAKIKYKARIHYJ)
    public String getZtykyksyakikykarihyj() {
        return ztykyksyakikykarihyj;
    }

    public void setZtykyksyakikykarihyj(String pZtykyksyakikykarihyj) {
        ztykyksyakikykarihyj = pZtykyksyakikykarihyj;
    }

    private String ztytenkankeiyakuhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTENKANKEIYAKUHYOUJI)
    public String getZtytenkankeiyakuhyouji() {
        return ztytenkankeiyakuhyouji;
    }

    public void setZtytenkankeiyakuhyouji(String pZtytenkankeiyakuhyouji) {
        ztytenkankeiyakuhyouji = pZtytenkankeiyakuhyouji;
    }

    private String ztyjigyoukeiyakuhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYJIGYOUKEIYAKUHYOUJI)
    public String getZtyjigyoukeiyakuhyouji() {
        return ztyjigyoukeiyakuhyouji;
    }

    public void setZtyjigyoukeiyakuhyouji(String pZtyjigyoukeiyakuhyouji) {
        ztyjigyoukeiyakuhyouji = pZtyjigyoukeiyakuhyouji;
    }

    private String ztynenkinzeiseitokuyakukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNENKINZEISEITOKUYAKUKBN)
    public String getZtynenkinzeiseitokuyakukbn() {
        return ztynenkinzeiseitokuyakukbn;
    }

    public void setZtynenkinzeiseitokuyakukbn(String pZtynenkinzeiseitokuyakukbn) {
        ztynenkinzeiseitokuyakukbn = pZtynenkinzeiseitokuyakukbn;
    }

    private String ztysyusseimaekanyuukykkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYUSSEIMAEKANYUUKYKKBN)
    public String getZtysyusseimaekanyuukykkbn() {
        return ztysyusseimaekanyuukykkbn;
    }

    public void setZtysyusseimaekanyuukykkbn(String pZtysyusseimaekanyuukykkbn) {
        ztysyusseimaekanyuukykkbn = pZtysyusseimaekanyuukykkbn;
    }

    private String ztykazokukeiyakuhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUKEIYAKUHYOUJI)
    public String getZtykazokukeiyakuhyouji() {
        return ztykazokukeiyakuhyouji;
    }

    public void setZtykazokukeiyakuhyouji(String pZtykazokukeiyakuhyouji) {
        ztykazokukeiyakuhyouji = pZtykazokukeiyakuhyouji;
    }

    private String ztyjikokykhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYJIKOKYKHYJ)
    public String getZtyjikokykhyj() {
        return ztyjikokykhyj;
    }

    public void setZtyjikokykhyj(String pZtyjikokykhyj) {
        ztyjikokykhyj = pZtyjikokykhyj;
    }

    private String ztytuusyoumeisiyouhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTUUSYOUMEISIYOUHYOUJI)
    public String getZtytuusyoumeisiyouhyouji() {
        return ztytuusyoumeisiyouhyouji;
    }

    public void setZtytuusyoumeisiyouhyouji(String pZtytuusyoumeisiyouhyouji) {
        ztytuusyoumeisiyouhyouji = pZtytuusyoumeisiyouhyouji;
    }

    private String ztysethokenkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETHOKENKBN)
    public String getZtysethokenkbn() {
        return ztysethokenkbn;
    }

    public void setZtysethokenkbn(String pZtysethokenkbn) {
        ztysethokenkbn = pZtysethokenkbn;
    }

    private String ztyteikeisyouhinkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIKEISYOUHINKBN)
    public String getZtyteikeisyouhinkbn() {
        return ztyteikeisyouhinkbn;
    }

    public void setZtyteikeisyouhinkbn(String pZtyteikeisyouhinkbn) {
        ztyteikeisyouhinkbn = pZtyteikeisyouhinkbn;
    }

    private String ztysykgycd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private Long ztytokuninbosyuuteate;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUNINBOSYUUTEATE)
    public Long getZtytokuninbosyuuteate() {
        return ztytokuninbosyuuteate;
    }

    public void setZtytokuninbosyuuteate(Long pZtytokuninbosyuuteate) {
        ztytokuninbosyuuteate = pZtytokuninbosyuuteate;
    }

    private String ztyseisekiym;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEISEKIYM)
    public String getZtyseisekiym() {
        return ztyseisekiym;
    }

    public void setZtyseisekiym(String pZtyseisekiym) {
        ztyseisekiym = pZtyseisekiym;
    }

    private Long ztyseisekikeijyousyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEISEKIKEIJYOUSYUUSEIS)
    public Long getZtyseisekikeijyousyuuseis() {
        return ztyseisekikeijyousyuuseis;
    }

    public void setZtyseisekikeijyousyuuseis(Long pZtyseisekikeijyousyuuseis) {
        ztyseisekikeijyousyuuseis = pZtyseisekikeijyousyuuseis;
    }

    private String ztysyuuseissakugenhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYUUSEISSAKUGENHYOUJI)
    public String getZtysyuuseissakugenhyouji() {
        return ztysyuuseissakugenhyouji;
    }

    public void setZtysyuuseissakugenhyouji(String pZtysyuuseissakugenhyouji) {
        ztysyuuseissakugenhyouji = pZtysyuuseissakugenhyouji;
    }

    private String ztyaatukaisisyatodouhukencd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYAATUKAISISYATODOUHUKENCD)
    public String getZtyaatukaisisyatodouhukencd() {
        return ztyaatukaisisyatodouhukencd;
    }

    public void setZtyaatukaisisyatodouhukencd(String pZtyaatukaisisyatodouhukencd) {
        ztyaatukaisisyatodouhukencd = pZtyaatukaisisyatodouhukencd;
    }

    private String ztyaatukaisosikicd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }

    private String ztyaatukaikojincd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYAATUKAIKOJINCD)
    public String getZtyaatukaikojincd() {
        return ztyaatukaikojincd;
    }

    public void setZtyaatukaikojincd(String pZtyaatukaikojincd) {
        ztyaatukaikojincd = pZtyaatukaikojincd;
    }

    private String ztybatukaisosikicd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYBATUKAISOSIKICD)
    public String getZtybatukaisosikicd() {
        return ztybatukaisosikicd;
    }

    public void setZtybatukaisosikicd(String pZtybatukaisosikicd) {
        ztybatukaisosikicd = pZtybatukaisosikicd;
    }

    private String ztybatukaisyakojincd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYBATUKAISYAKOJINCD)
    public String getZtybatukaisyakojincd() {
        return ztybatukaisyakojincd;
    }

    public void setZtybatukaisyakojincd(String pZtybatukaisyakojincd) {
        ztybatukaisyakojincd = pZtybatukaisyakojincd;
    }

    private String ztymarutokukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTOKUKBN)
    public String getZtymarutokukbn() {
        return ztymarutokukbn;
    }

    public void setZtymarutokukbn(String pZtymarutokukbn) {
        ztymarutokukbn = pZtymarutokukbn;
    }

    private String ztygyoumujyouhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGYOUMUJYOUHYOUJI)
    public String getZtygyoumujyouhyouji() {
        return ztygyoumujyouhyouji;
    }

    public void setZtygyoumujyouhyouji(String pZtygyoumujyouhyouji) {
        ztygyoumujyouhyouji = pZtygyoumujyouhyouji;
    }

    private String ztytuikakeijyoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTUIKAKEIJYOUKBN)
    public String getZtytuikakeijyoukbn() {
        return ztytuikakeijyoukbn;
    }

    public void setZtytuikakeijyoukbn(String pZtytuikakeijyoukbn) {
        ztytuikakeijyoukbn = pZtytuikakeijyoukbn;
    }

    private String ztyseisekinomikeijyoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEISEKINOMIKEIJYOUKBN)
    public String getZtyseisekinomikeijyoukbn() {
        return ztyseisekinomikeijyoukbn;
    }

    public void setZtyseisekinomikeijyoukbn(String pZtyseisekinomikeijyoukbn) {
        ztyseisekinomikeijyoukbn = pZtyseisekinomikeijyoukbn;
    }

    private String ztyteikikeijyoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIKIKEIJYOUKBN)
    public String getZtyteikikeijyoukbn() {
        return ztyteikikeijyoukbn;
    }

    public void setZtyteikikeijyoukbn(String pZtyteikikeijyoukbn) {
        ztyteikikeijyoukbn = pZtyteikikeijyoukbn;
    }

    private String ztyhngkmskkatkisykbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHNGKMSKKATKISYKBN)
    public String getZtyhngkmskkatkisykbn() {
        return ztyhngkmskkatkisykbn;
    }

    public void setZtyhngkmskkatkisykbn(String pZtyhngkmskkatkisykbn) {
        ztyhngkmskkatkisykbn = pZtyhngkmskkatkisykbn;
    }

    private String ztytnknkyuuyosakugenhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTNKNKYUUYOSAKUGENHYJ)
    public String getZtytnknkyuuyosakugenhyj() {
        return ztytnknkyuuyosakugenhyj;
    }

    public void setZtytnknkyuuyosakugenhyj(String pZtytnknkyuuyosakugenhyj) {
        ztytnknkyuuyosakugenhyj = pZtytnknkyuuyosakugenhyj;
    }

    private String ztytenkankaisuu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTENKANKAISUU)
    public String getZtytenkankaisuu() {
        return ztytenkankaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkankaisuu(String pZtytenkankaisuu) {
        ztytenkankaisuu = pZtytenkankaisuu;
    }

    private String ztyhiyubrigssnsikkijyunkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIYUBRIGSSNSIKKIJYUNKBN)
    public String getZtyhiyubrigssnsikkijyunkbn() {
        return ztyhiyubrigssnsikkijyunkbn;
    }

    public void setZtyhiyubrigssnsikkijyunkbn(String pZtyhiyubrigssnsikkijyunkbn) {
        ztyhiyubrigssnsikkijyunkbn = pZtyhiyubrigssnsikkijyunkbn;
    }

    private String ztysekininkaisiymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEKININKAISIYMD)
    public String getZtysekininkaisiymd() {
        return ztysekininkaisiymd;
    }

    public void setZtysekininkaisiymd(String pZtysekininkaisiymd) {
        ztysekininkaisiymd = pZtysekininkaisiymd;
    }

    private String ztykigetusmkrgkykhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKIGETUSMKRGKYKHYJ)
    public String getZtykigetusmkrgkykhyj() {
        return ztykigetusmkrgkykhyj;
    }

    public void setZtykigetusmkrgkykhyj(String pZtykigetusmkrgkykhyj) {
        ztykigetusmkrgkykhyj = pZtykigetusmkrgkykhyj;
    }

    private String ztyhensyuusyoriymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHENSYUUSYORIYMD)
    public String getZtyhensyuusyoriymd() {
        return ztyhensyuusyoriymd;
    }

    public void setZtyhensyuusyoriymd(String pZtyhensyuusyoriymd) {
        ztyhensyuusyoriymd = pZtyhensyuusyoriymd;
    }

    private String ztyjisisyaatukaihyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYJISISYAATUKAIHYOUJI)
    public String getZtyjisisyaatukaihyouji() {
        return ztyjisisyaatukaihyouji;
    }

    public void setZtyjisisyaatukaihyouji(String pZtyjisisyaatukaihyouji) {
        ztyjisisyaatukaihyouji = pZtyjisisyaatukaihyouji;
    }

    private String ztyaatkisytktntusy1atkihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYAATKISYTKTNTUSY1ATKIHYJ)
    public String getZtyaatkisytktntusy1atkihyj() {
        return ztyaatkisytktntusy1atkihyj;
    }

    public void setZtyaatkisytktntusy1atkihyj(String pZtyaatkisytktntusy1atkihyj) {
        ztyaatkisytktntusy1atkihyj = pZtyaatkisytktntusy1atkihyj;
    }

    private String ztyaatkisytktntusy2atkihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYAATKISYTKTNTUSY2ATKIHYJ)
    public String getZtyaatkisytktntusy2atkihyj() {
        return ztyaatkisytktntusy2atkihyj;
    }

    public void setZtyaatkisytktntusy2atkihyj(String pZtyaatkisytktntusy2atkihyj) {
        ztyaatkisytktntusy2atkihyj = pZtyaatkisytktntusy2atkihyj;
    }

    private String ztyaatkisyasyokan1atkihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYAATKISYASYOKAN1ATKIHYJ)
    public String getZtyaatkisyasyokan1atkihyj() {
        return ztyaatkisyasyokan1atkihyj;
    }

    public void setZtyaatkisyasyokan1atkihyj(String pZtyaatkisyasyokan1atkihyj) {
        ztyaatkisyasyokan1atkihyj = pZtyaatkisyasyokan1atkihyj;
    }

    private String ztyaatkisyasyokan2atkihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYAATKISYASYOKAN2ATKIHYJ)
    public String getZtyaatkisyasyokan2atkihyj() {
        return ztyaatkisyasyokan2atkihyj;
    }

    public void setZtyaatkisyasyokan2atkihyj(String pZtyaatkisyasyokan2atkihyj) {
        ztyaatkisyasyokan2atkihyj = pZtyaatkisyasyokan2atkihyj;
    }

    private String ztybatkisytktntusy1atkihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYBATKISYTKTNTUSY1ATKIHYJ)
    public String getZtybatkisytktntusy1atkihyj() {
        return ztybatkisytktntusy1atkihyj;
    }

    public void setZtybatkisytktntusy1atkihyj(String pZtybatkisytktntusy1atkihyj) {
        ztybatkisytktntusy1atkihyj = pZtybatkisytktntusy1atkihyj;
    }

    private String ztybatkisytktntusy2atkihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYBATKISYTKTNTUSY2ATKIHYJ)
    public String getZtybatkisytktntusy2atkihyj() {
        return ztybatkisytktntusy2atkihyj;
    }

    public void setZtybatkisytktntusy2atkihyj(String pZtybatkisytktntusy2atkihyj) {
        ztybatkisytktntusy2atkihyj = pZtybatkisytktntusy2atkihyj;
    }

    private String ztybatkisyasyokan1atkihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYBATKISYASYOKAN1ATKIHYJ)
    public String getZtybatkisyasyokan1atkihyj() {
        return ztybatkisyasyokan1atkihyj;
    }

    public void setZtybatkisyasyokan1atkihyj(String pZtybatkisyasyokan1atkihyj) {
        ztybatkisyasyokan1atkihyj = pZtybatkisyasyokan1atkihyj;
    }

    private String ztybatkisyasyokan2atkihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYBATKISYASYOKAN2ATKIHYJ)
    public String getZtybatkisyasyokan2atkihyj() {
        return ztybatkisyasyokan2atkihyj;
    }

    public void setZtybatkisyasyokan2atkihyj(String pZtybatkisyasyokan2atkihyj) {
        ztybatkisyasyokan2atkihyj = pZtybatkisyasyokan2atkihyj;
    }

    private String ztykeizokutyuuihyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKEIZOKUTYUUIHYOUJI)
    public String getZtykeizokutyuuihyouji() {
        return ztykeizokutyuuihyouji;
    }

    public void setZtykeizokutyuuihyouji(String pZtykeizokutyuuihyouji) {
        ztykeizokutyuuihyouji = pZtykeizokutyuuihyouji;
    }

    private String ztykeiyakubisiteihyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKEIYAKUBISITEIHYOUJI)
    public String getZtykeiyakubisiteihyouji() {
        return ztykeiyakubisiteihyouji;
    }

    public void setZtykeiyakubisiteihyouji(String pZtykeiyakubisiteihyouji) {
        ztykeiyakubisiteihyouji = pZtykeiyakubisiteihyouji;
    }

    private String ztyjyoukentukihyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYJYOUKENTUKIHYOUJI)
    public String getZtyjyoukentukihyouji() {
        return ztyjyoukentukihyouji;
    }

    public void setZtyjyoukentukihyouji(String pZtyjyoukentukihyouji) {
        ztyjyoukentukihyouji = pZtyjyoukentukihyouji;
    }

    private String ztytokuninhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUNINHYOUJI)
    public String getZtytokuninhyouji() {
        return ztytokuninhyouji;
    }

    public void setZtytokuninhyouji(String pZtytokuninhyouji) {
        ztytokuninhyouji = pZtytokuninhyouji;
    }

    private String ztykessantyouseikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKESSANTYOUSEIKBN)
    public String getZtykessantyouseikbn() {
        return ztykessantyouseikbn;
    }

    public void setZtykessantyouseikbn(String pZtykessantyouseikbn) {
        ztykessantyouseikbn = pZtykessantyouseikbn;
    }

    private String ztyhaneihyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHANEIHYOUJI)
    public String getZtyhaneihyouji() {
        return ztyhaneihyouji;
    }

    public void setZtyhaneihyouji(String pZtyhaneihyouji) {
        ztyhaneihyouji = pZtyhaneihyouji;
    }

    private String ztysyukinkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYUKINKBN)
    public String getZtysyukinkbn() {
        return ztysyukinkbn;
    }

    public void setZtysyukinkbn(String pZtysyukinkbn) {
        ztysyukinkbn = pZtysyukinkbn;
    }

    private String ztykeiyakusyasyokugyoucd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKEIYAKUSYASYOKUGYOUCD)
    public String getZtykeiyakusyasyokugyoucd() {
        return ztykeiyakusyasyokugyoucd;
    }

    public void setZtykeiyakusyasyokugyoucd(String pZtykeiyakusyasyokugyoucd) {
        ztykeiyakusyasyokugyoucd = pZtykeiyakusyasyokugyoucd;
    }

    private String ztyseikeikeirokbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIKEIKEIROKBN)
    public String getZtyseikeikeirokbn() {
        return ztyseikeikeirokbn;
    }

    public void setZtyseikeikeirokbn(String pZtyseikeikeirokbn) {
        ztyseikeikeirokbn = pZtyseikeikeirokbn;
    }

    private String ztydai2seikeikeirokbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SEIKEIKEIROKBN)
    public String getZtydai2seikeikeirokbn() {
        return ztydai2seikeikeirokbn;
    }

    public void setZtydai2seikeikeirokbn(String pZtydai2seikeikeirokbn) {
        ztydai2seikeikeirokbn = pZtydai2seikeikeirokbn;
    }

    private String ztyteigentokuteisyuruikigou;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENTOKUTEISYURUIKIGOU)
    public String getZtyteigentokuteisyuruikigou() {
        return ztyteigentokuteisyuruikigou;
    }

    public void setZtyteigentokuteisyuruikigou(String pZtyteigentokuteisyuruikigou) {
        ztyteigentokuteisyuruikigou = pZtyteigentokuteisyuruikigou;
    }

    private String ztyteigentokuteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENTOKUTEIKIKAN)
    public String getZtyteigentokuteikikan() {
        return ztyteigentokuteikikan;
    }

    public void setZtyteigentokuteikikan(String pZtyteigentokuteikikan) {
        ztyteigentokuteikikan = pZtyteigentokuteikikan;
    }

    private Long ztyteigentokuteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENTOKUTEIS)
    public Long getZtyteigentokuteis() {
        return ztyteigentokuteis;
    }

    public void setZtyteigentokuteis(Long pZtyteigentokuteis) {
        ztyteigentokuteis = pZtyteigentokuteis;
    }

    private Long ztyteigentokuteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENTOKUTEIP)
    public Long getZtyteigentokuteip() {
        return ztyteigentokuteip;
    }

    public void setZtyteigentokuteip(Long pZtyteigentokuteip) {
        ztyteigentokuteip = pZtyteigentokuteip;
    }

    private String ztytigntktisdtpdtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNTKTISDTPDTKBN)
    public String getZtytigntktisdtpdtkbn() {
        return ztytigntktisdtpdtkbn;
    }

    public void setZtytigntktisdtpdtkbn(String pZtytigntktisdtpdtkbn) {
        ztytigntktisdtpdtkbn = pZtytigntktisdtpdtkbn;
    }

    private Long ztyteigentokuteisyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENTOKUTEISYUUSEIS)
    public Long getZtyteigentokuteisyuuseis() {
        return ztyteigentokuteisyuuseis;
    }

    public void setZtyteigentokuteisyuuseis(Long pZtyteigentokuteisyuuseis) {
        ztyteigentokuteisyuuseis = pZtyteigentokuteisyuuseis;
    }

    private String ztyteigentktimodssakugenhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENTKTIMODSSAKUGENHYJ)
    public String getZtyteigentktimodssakugenhyj() {
        return ztyteigentktimodssakugenhyj;
    }

    public void setZtyteigentktimodssakugenhyj(String pZtyteigentktimodssakugenhyj) {
        ztyteigentktimodssakugenhyj = pZtyteigentktimodssakugenhyj;
    }

    private String ztyteigentktikgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENTKTIKGUSDKBN)
    public String getZtyteigentktikgusdkbn() {
        return ztyteigentktikgusdkbn;
    }

    public void setZtyteigentktikgusdkbn(String pZtyteigentktikgusdkbn) {
        ztyteigentktikgusdkbn = pZtyteigentktikgusdkbn;
    }

    private String ztyyobiv9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV9)
    public String getZtyyobiv9() {
        return ztyyobiv9;
    }

    public void setZtyyobiv9(String pZtyyobiv9) {
        ztyyobiv9 = pZtyyobiv9;
    }

    private String ztytokuteibuicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUTEIBUICDX1)
    public String getZtytokuteibuicdx1() {
        return ztytokuteibuicdx1;
    }

    public void setZtytokuteibuicdx1(String pZtytokuteibuicdx1) {
        ztytokuteibuicdx1 = pZtytokuteibuicdx1;
    }

    private String ztyhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNPKKNX1)
    public String getZtyhtnpkknx1() {
        return ztyhtnpkknx1;
    }

    public void setZtyhtnpkknx1(String pZtyhtnpkknx1) {
        ztyhtnpkknx1 = pZtyhtnpkknx1;
    }

    private String ztytokuteibuicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUTEIBUICDX2)
    public String getZtytokuteibuicdx2() {
        return ztytokuteibuicdx2;
    }

    public void setZtytokuteibuicdx2(String pZtytokuteibuicdx2) {
        ztytokuteibuicdx2 = pZtytokuteibuicdx2;
    }

    private String ztyhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNPKKNX2)
    public String getZtyhtnpkknx2() {
        return ztyhtnpkknx2;
    }

    public void setZtyhtnpkknx2(String pZtyhtnpkknx2) {
        ztyhtnpkknx2 = pZtyhtnpkknx2;
    }

    private String ztyhhknmei;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHHKNMEI)
    public String getZtyhhknmei() {
        return ztyhhknmei;
    }

    public void setZtyhhknmei(String pZtyhhknmei) {
        ztyhhknmei = pZtyhhknmei;
    }

    private String ztyknjhhknmei;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKNJHHKNMEI)
    public String getZtyknjhhknmei() {
        return ztyknjhhknmei;
    }

    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        ztyknjhhknmei = pZtyknjhhknmei;
    }

    private String ztyhhknseiymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHHKNSEIYMD)
    public String getZtyhhknseiymd() {
        return ztyhhknseiymd;
    }

    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        ztyhhknseiymd = pZtyhhknseiymd;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhhknhnsktodouhukencd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHHKNHNSKTODOUHUKENCD)
    public String getZtyhhknhnsktodouhukencd() {
        return ztyhhknhnsktodouhukencd;
    }

    public void setZtyhhknhnsktodouhukencd(String pZtyhhknhnsktodouhukencd) {
        ztyhhknhnsktodouhukencd = pZtyhhknhnsktodouhukencd;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztyhihokensyakikykarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIHOKENSYAKIKYKARIHYJ)
    public String getZtyhihokensyakikykarihyj() {
        return ztyhihokensyakikykarihyj;
    }

    public void setZtyhihokensyakikykarihyj(String pZtyhihokensyakikykarihyj) {
        ztyhihokensyakikykarihyj = pZtyhihokensyakikykarihyj;
    }

    private String ztynobikkosaimankikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNOBIKKOSAIMANKIKBN)
    public String getZtynobikkosaimankikbn() {
        return ztynobikkosaimankikbn;
    }

    public void setZtynobikkosaimankikbn(String pZtynobikkosaimankikbn) {
        ztynobikkosaimankikbn = pZtynobikkosaimankikbn;
    }

    private String ztyhhknsysysnhonninkknnkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHHKNSYSYSNHONNINKKNNKBN)
    public String getZtyhhknsysysnhonninkknnkbn() {
        return ztyhhknsysysnhonninkknnkbn;
    }

    public void setZtyhhknsysysnhonninkknnkbn(String pZtyhhknsysysnhonninkknnkbn) {
        ztyhhknsysysnhonninkknnkbn = pZtyhhknsysysnhonninkknnkbn;
    }

    private String ztyhhknsysisnhonninkknnkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHHKNSYSISNHONNINKKNNKBN)
    public String getZtyhhknsysisnhonninkknnkbn() {
        return ztyhhknsysisnhonninkknnkbn;
    }

    public void setZtyhhknsysisnhonninkknnkbn(String pZtyhhknsysisnhonninkknnkbn) {
        ztyhhknsysisnhonninkknnkbn = pZtyhhknsysisnhonninkknnkbn;
    }

    private String ztykzktourokuservicearihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKTOUROKUSERVICEARIHYJ)
    public String getZtykzktourokuservicearihyj() {
        return ztykzktourokuservicearihyj;
    }

    public void setZtykzktourokuservicearihyj(String pZtykzktourokuservicearihyj) {
        ztykzktourokuservicearihyj = pZtykzktourokuservicearihyj;
    }

    private String ztyyobiv4x12;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X12)
    public String getZtyyobiv4x12() {
        return ztyyobiv4x12;
    }

    public void setZtyyobiv4x12(String pZtyyobiv4x12) {
        ztyyobiv4x12 = pZtyyobiv4x12;
    }

    private String ztyhensyuukeiyakusyamei;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHENSYUUKEIYAKUSYAMEI)
    public String getZtyhensyuukeiyakusyamei() {
        return ztyhensyuukeiyakusyamei;
    }

    public void setZtyhensyuukeiyakusyamei(String pZtyhensyuukeiyakusyamei) {
        ztyhensyuukeiyakusyamei = pZtyhensyuukeiyakusyamei;
    }

    private String ztyhnsyuknjkyksynm;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHNSYUKNJKYKSYNM)
    public String getZtyhnsyuknjkyksynm() {
        return ztyhnsyuknjkyksynm;
    }

    public void setZtyhnsyuknjkyksynm(String pZtyhnsyuknjkyksynm) {
        ztyhnsyuknjkyksynm = pZtyhnsyuknjkyksynm;
    }

    private String ztykyksyaseiymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKYKSYASEIYMD)
    public String getZtykyksyaseiymd() {
        return ztykyksyaseiymd;
    }

    public void setZtykyksyaseiymd(String pZtykyksyaseiymd) {
        ztykyksyaseiymd = pZtykyksyaseiymd;
    }

    private String ztykyksyaseikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKYKSYASEIKBN)
    public String getZtykyksyaseikbn() {
        return ztykyksyaseikbn;
    }

    public void setZtykyksyaseikbn(String pZtykyksyaseikbn) {
        ztykyksyaseikbn = pZtykyksyaseikbn;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztyknkuzusnzyrt;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKNKUZUSNZYRT)
    public String getZtyknkuzusnzyrt() {
        return ztyknkuzusnzyrt;
    }

    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        ztyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }

    private String ztyvitdoujimos2kenmeikouhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYVITDOUJIMOS2KENMEIKOUHYJ)
    public String getZtyvitdoujimos2kenmeikouhyj() {
        return ztyvitdoujimos2kenmeikouhyj;
    }

    public void setZtyvitdoujimos2kenmeikouhyj(String pZtyvitdoujimos2kenmeikouhyj) {
        ztyvitdoujimos2kenmeikouhyj = pZtyvitdoujimos2kenmeikouhyj;
    }

    private String ztykikykvitarituikamoshyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKIKYKVITARITUIKAMOSHYJ)
    public String getZtykikykvitarituikamoshyj() {
        return ztykikykvitarituikamoshyj;
    }

    public void setZtykikykvitarituikamoshyj(String pZtykikykvitarituikamoshyj) {
        ztykikykvitarituikamoshyj = pZtykikykvitarituikamoshyj;
    }

    private String ztyhtnknkykvithokenkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKVITHOKENKBN)
    public String getZtyhtnknkykvithokenkbn() {
        return ztyhtnknkykvithokenkbn;
    }

    public void setZtyhtnknkykvithokenkbn(String pZtyhtnknkykvithokenkbn) {
        ztyhtnknkykvithokenkbn = pZtyhtnknkykvithokenkbn;
    }

    private String ztykikykvithokenhoyuujkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKIKYKVITHOKENHOYUUJKKBN)
    public String getZtykikykvithokenhoyuujkkbn() {
        return ztykikykvithokenhoyuujkkbn;
    }

    public void setZtykikykvithokenhoyuujkkbn(String pZtykikykvithokenhoyuujkkbn) {
        ztykikykvithokenhoyuujkkbn = pZtykikykvithokenhoyuujkkbn;
    }

    private String ztyyobiv2x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV2X2)
    public String getZtyyobiv2x2() {
        return ztyyobiv2x2;
    }

    public void setZtyyobiv2x2(String pZtyyobiv2x2) {
        ztyyobiv2x2 = pZtyyobiv2x2;
    }

    private String ztytsnsknewyno;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTSNSKNEWYNO)
    public String getZtytsnsknewyno() {
        return ztytsnsknewyno;
    }

    public void setZtytsnsknewyno(String pZtytsnsknewyno) {
        ztytsnsknewyno = pZtytsnsknewyno;
    }

    private String ztytsnsknewtikucd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTSNSKNEWTIKUCD)
    public String getZtytsnsknewtikucd() {
        return ztytsnsknewtikucd;
    }

    public void setZtytsnsknewtikucd(String pZtytsnsknewtikucd) {
        ztytsnsknewtikucd = pZtytsnsknewtikucd;
    }

    private String ztymossyumtkktymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMOSSYUMTKKTYMD)
    public String getZtymossyumtkktymd() {
        return ztymossyumtkktymd;
    }

    public void setZtymossyumtkktymd(String pZtymossyumtkktymd) {
        ztymossyumtkktymd = pZtymossyumtkktymd;
    }

    private String ztykituenkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKITUENKBN)
    public String getZtykituenkbn() {
        return ztykituenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykituenkbn(String pZtykituenkbn) {
        ztykituenkbn = pZtykituenkbn;
    }

    private String ztytuusinsakijyuusyokbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTUUSINSAKIJYUUSYOKBN)
    public String getZtytuusinsakijyuusyokbn() {
        return ztytuusinsakijyuusyokbn;
    }

    public void setZtytuusinsakijyuusyokbn(String pZtytuusinsakijyuusyokbn) {
        ztytuusinsakijyuusyokbn = pZtytuusinsakijyuusyokbn;
    }

    private String ztymaruteisyuruikigou;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEISYURUIKIGOU)
    public String getZtymaruteisyuruikigou() {
        return ztymaruteisyuruikigou;
    }

    public void setZtymaruteisyuruikigou(String pZtymaruteisyuruikigou) {
        ztymaruteisyuruikigou = pZtymaruteisyuruikigou;
    }

    private String ztymaruteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEIKIKAN)
    public String getZtymaruteikikan() {
        return ztymaruteikikan;
    }

    public void setZtymaruteikikan(String pZtymaruteikikan) {
        ztymaruteikikan = pZtymaruteikikan;
    }

    private String ztymaruteiphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEIPHRKKKN)
    public String getZtymaruteiphrkkkn() {
        return ztymaruteiphrkkkn;
    }

    public void setZtymaruteiphrkkkn(String pZtymaruteiphrkkkn) {
        ztymaruteiphrkkkn = pZtymaruteiphrkkkn;
    }

    private Long ztymaruteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEIS)
    public Long getZtymaruteis() {
        return ztymaruteis;
    }

    public void setZtymaruteis(Long pZtymaruteis) {
        ztymaruteis = pZtymaruteis;
    }

    private Long ztymaruteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEIP)
    public Long getZtymaruteip() {
        return ztymaruteip;
    }

    public void setZtymaruteip(Long pZtymaruteip) {
        ztymaruteip = pZtymaruteip;
    }

    private Long ztymaruteisyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEISYUUSEIS)
    public Long getZtymaruteisyuuseis() {
        return ztymaruteisyuuseis;
    }

    public void setZtymaruteisyuuseis(Long pZtymaruteisyuuseis) {
        ztymaruteisyuuseis = pZtymaruteisyuuseis;
    }

    private String ztymaruteisyuuseisskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEISYUUSEISSKGNHYJ)
    public String getZtymaruteisyuuseisskgnhyj() {
        return ztymaruteisyuuseisskgnhyj;
    }

    public void setZtymaruteisyuuseisskgnhyj(String pZtymaruteisyuuseisskgnhyj) {
        ztymaruteisyuuseisskgnhyj = pZtymaruteisyuuseisskgnhyj;
    }

    private String ztymaruteitokujyoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEITOKUJYOUKBN)
    public String getZtymaruteitokujyoukbn() {
        return ztymaruteitokujyoukbn;
    }

    public void setZtymaruteitokujyoukbn(String pZtymaruteitokujyoukbn) {
        ztymaruteitokujyoukbn = pZtymaruteitokujyoukbn;
    }

    private String ztymrtitkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMRTITKJYUSKGNKKN)
    public String getZtymrtitkjyuskgnkkn() {
        return ztymrtitkjyuskgnkkn;
    }

    public void setZtymrtitkjyuskgnkkn(String pZtymrtitkjyuskgnkkn) {
        ztymrtitkjyuskgnkkn = pZtymrtitkjyuskgnkkn;
    }

    private Integer ztymrtitkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMRTITKJYURYUMSHYUTN)
    public Integer getZtymrtitkjyuryumshyutn() {
        return ztymrtitkjyuryumshyutn;
    }

    public void setZtymrtitkjyuryumshyutn(Integer pZtymrtitkjyuryumshyutn) {
        ztymrtitkjyuryumshyutn = pZtymrtitkjyuryumshyutn;
    }

    private Long ztymaruteitokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEITOKUJYOUP)
    public Long getZtymaruteitokujyoup() {
        return ztymaruteitokujyoup;
    }

    public void setZtymaruteitokujyoup(Long pZtymaruteitokujyoup) {
        ztymaruteitokujyoup = pZtymaruteitokujyoup;
    }

    private String ztysuryumrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSURYUMRTIPWRBKKBN)
    public String getZtysuryumrtipwrbkkbn() {
        return ztysuryumrtipwrbkkbn;
    }

    public void setZtysuryumrtipwrbkkbn(String pZtysuryumrtipwrbkkbn) {
        ztysuryumrtipwrbkkbn = pZtysuryumrtipwrbkkbn;
    }

    private String ztymaruteipwaribikikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEIPWARIBIKIKBN)
    public String getZtymaruteipwaribikikbn() {
        return ztymaruteipwaribikikbn;
    }

    public void setZtymaruteipwaribikikbn(String pZtymaruteipwaribikikbn) {
        ztymaruteipwaribikikbn = pZtymaruteipwaribikikbn;
    }

    private String ztymrtitnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMRTITNKNYUGUKBN)
    public String getZtymrtitnknyugukbn() {
        return ztymrtitnknyugukbn;
    }

    public void setZtymrtitnknyugukbn(String pZtymrtitnknyugukbn) {
        ztymrtitnknyugukbn = pZtymrtitnknyugukbn;
    }

    private String ztymaruteikigousedaikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEIKIGOUSEDAIKBN)
    public String getZtymaruteikigousedaikbn() {
        return ztymaruteikigousedaikbn;
    }

    public void setZtymaruteikigousedaikbn(String pZtymaruteikigousedaikbn) {
        ztymaruteikigousedaikbn = pZtymaruteikigousedaikbn;
    }

    private String ztymaruteikikousnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEIKIKOUSNMNRYOAGE)
    public String getZtymaruteikikousnmnryoage() {
        return ztymaruteikikousnmnryoage;
    }

    public void setZtymaruteikikousnmnryoage(String pZtymaruteikikousnmnryoage) {
        ztymaruteikikousnmnryoage = pZtymaruteikikousnmnryoage;
    }

    private String ztyyobiv2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV2)
    public String getZtyyobiv2() {
        return ztyyobiv2;
    }

    public void setZtyyobiv2(String pZtyyobiv2) {
        ztyyobiv2 = pZtyyobiv2;
    }

    private String ztymaruyousyuruikigou;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUYOUSYURUIKIGOU)
    public String getZtymaruyousyuruikigou() {
        return ztymaruyousyuruikigou;
    }

    public void setZtymaruyousyuruikigou(String pZtymaruyousyuruikigou) {
        ztymaruyousyuruikigou = pZtymaruyousyuruikigou;
    }

    private String ztymaruyoukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUYOUKIKAN)
    public String getZtymaruyoukikan() {
        return ztymaruyoukikan;
    }

    public void setZtymaruyoukikan(String pZtymaruyoukikan) {
        ztymaruyoukikan = pZtymaruyoukikan;
    }

    private Long ztymaruyous;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUYOUS)
    public Long getZtymaruyous() {
        return ztymaruyous;
    }

    public void setZtymaruyous(Long pZtymaruyous) {
        ztymaruyous = pZtymaruyous;
    }

    private Long ztymaruyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUYOUP)
    public Long getZtymaruyoup() {
        return ztymaruyoup;
    }

    public void setZtymaruyoup(Long pZtymaruyoup) {
        ztymaruyoup = pZtymaruyoup;
    }

    private String ztymaruyousdatepdatekbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUYOUSDATEPDATEKBN)
    public String getZtymaruyousdatepdatekbn() {
        return ztymaruyousdatepdatekbn;
    }

    public void setZtymaruyousdatepdatekbn(String pZtymaruyousdatepdatekbn) {
        ztymaruyousdatepdatekbn = pZtymaruyousdatepdatekbn;
    }

    private Long ztymaruyousyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUYOUSYUUSEIS)
    public Long getZtymaruyousyuuseis() {
        return ztymaruyousyuuseis;
    }

    public void setZtymaruyousyuuseis(Long pZtymaruyousyuuseis) {
        ztymaruyousyuuseis = pZtymaruyousyuuseis;
    }

    private String ztymaruyousyuuseisskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUYOUSYUUSEISSKGNHYJ)
    public String getZtymaruyousyuuseisskgnhyj() {
        return ztymaruyousyuuseisskgnhyj;
    }

    public void setZtymaruyousyuuseisskgnhyj(String pZtymaruyousyuuseisskgnhyj) {
        ztymaruyousyuuseisskgnhyj = pZtymaruyousyuuseisskgnhyj;
    }

    private String ztymaruyoukigousedaikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUYOUKIGOUSEDAIKBN)
    public String getZtymaruyoukigousedaikbn() {
        return ztymaruyoukigousedaikbn;
    }

    public void setZtymaruyoukigousedaikbn(String pZtymaruyoukigousedaikbn) {
        ztymaruyoukigousedaikbn = pZtymaruyoukigousedaikbn;
    }

    private String ztyyobiv9x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV9X3)
    public String getZtyyobiv9x3() {
        return ztyyobiv9x3;
    }

    public void setZtyyobiv9x3(String pZtyyobiv9x3) {
        ztyyobiv9x3 = pZtyyobiv9x3;
    }

    private String ztymarusyuusyuruikigou;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUSYUUSYURUIKIGOU)
    public String getZtymarusyuusyuruikigou() {
        return ztymarusyuusyuruikigou;
    }

    public void setZtymarusyuusyuruikigou(String pZtymarusyuusyuruikigou) {
        ztymarusyuusyuruikigou = pZtymarusyuusyuruikigou;
    }

    private String ztymarusyuukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUSYUUKIKAN)
    public String getZtymarusyuukikan() {
        return ztymarusyuukikan;
    }

    public void setZtymarusyuukikan(String pZtymarusyuukikan) {
        ztymarusyuukikan = pZtymarusyuukikan;
    }

    private Long ztymarusyuus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUSYUUS)
    public Long getZtymarusyuus() {
        return ztymarusyuus;
    }

    public void setZtymarusyuus(Long pZtymarusyuus) {
        ztymarusyuus = pZtymarusyuus;
    }

    private Long ztymarusyuup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUSYUUP)
    public Long getZtymarusyuup() {
        return ztymarusyuup;
    }

    public void setZtymarusyuup(Long pZtymarusyuup) {
        ztymarusyuup = pZtymarusyuup;
    }

    private String ztymarusyuusdatepdatekbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUSYUUSDATEPDATEKBN)
    public String getZtymarusyuusdatepdatekbn() {
        return ztymarusyuusdatepdatekbn;
    }

    public void setZtymarusyuusdatepdatekbn(String pZtymarusyuusdatepdatekbn) {
        ztymarusyuusdatepdatekbn = pZtymarusyuusdatepdatekbn;
    }

    private Long ztymarusyuusyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUSYUUSYUUSEIS)
    public Long getZtymarusyuusyuuseis() {
        return ztymarusyuusyuuseis;
    }

    public void setZtymarusyuusyuuseis(Long pZtymarusyuusyuuseis) {
        ztymarusyuusyuuseis = pZtymarusyuusyuuseis;
    }

    private String ztymarusyuusyuuseisskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUSYUUSYUUSEISSKGNHYJ)
    public String getZtymarusyuusyuuseisskgnhyj() {
        return ztymarusyuusyuuseisskgnhyj;
    }

    public void setZtymarusyuusyuuseisskgnhyj(String pZtymarusyuusyuuseisskgnhyj) {
        ztymarusyuusyuuseisskgnhyj = pZtymarusyuusyuuseisskgnhyj;
    }

    private String ztymarusyuukigousedaikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUSYUUKIGOUSEDAIKBN)
    public String getZtymarusyuukigousedaikbn() {
        return ztymarusyuukigousedaikbn;
    }

    public void setZtymarusyuukigousedaikbn(String pZtymarusyuukigousedaikbn) {
        ztymarusyuukigousedaikbn = pZtymarusyuukigousedaikbn;
    }

    private String ztyyobiv9x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV9X4)
    public String getZtyyobiv9x4() {
        return ztyyobiv9x4;
    }

    public void setZtyyobiv9x4(String pZtyyobiv9x4) {
        ztyyobiv9x4 = pZtyyobiv9x4;
    }

    private String ztytokuteisyuruikigou;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUTEISYURUIKIGOU)
    public String getZtytokuteisyuruikigou() {
        return ztytokuteisyuruikigou;
    }

    public void setZtytokuteisyuruikigou(String pZtytokuteisyuruikigou) {
        ztytokuteisyuruikigou = pZtytokuteisyuruikigou;
    }

    private String ztytokuteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUTEIKIKAN)
    public String getZtytokuteikikan() {
        return ztytokuteikikan;
    }

    public void setZtytokuteikikan(String pZtytokuteikikan) {
        ztytokuteikikan = pZtytokuteikikan;
    }

    private Long ztytokuteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUTEIS)
    public Long getZtytokuteis() {
        return ztytokuteis;
    }

    public void setZtytokuteis(Long pZtytokuteis) {
        ztytokuteis = pZtytokuteis;
    }

    private Long ztytokuteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUTEIP)
    public Long getZtytokuteip() {
        return ztytokuteip;
    }

    public void setZtytokuteip(Long pZtytokuteip) {
        ztytokuteip = pZtytokuteip;
    }

    private String ztytokuteisdatepdatekbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUTEISDATEPDATEKBN)
    public String getZtytokuteisdatepdatekbn() {
        return ztytokuteisdatepdatekbn;
    }

    public void setZtytokuteisdatepdatekbn(String pZtytokuteisdatepdatekbn) {
        ztytokuteisdatepdatekbn = pZtytokuteisdatepdatekbn;
    }

    private Long ztytokuteisyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUTEISYUUSEIS)
    public Long getZtytokuteisyuuseis() {
        return ztytokuteisyuuseis;
    }

    public void setZtytokuteisyuuseis(Long pZtytokuteisyuuseis) {
        ztytokuteisyuuseis = pZtytokuteisyuuseis;
    }

    private String ztytokuteisyuuseisskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUTEISYUUSEISSKGNHYJ)
    public String getZtytokuteisyuuseisskgnhyj() {
        return ztytokuteisyuuseisskgnhyj;
    }

    public void setZtytokuteisyuuseisskgnhyj(String pZtytokuteisyuuseisskgnhyj) {
        ztytokuteisyuuseisskgnhyj = pZtytokuteisyuuseisskgnhyj;
    }

    private String ztytokuteikigousedaikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUTEIKIGOUSEDAIKBN)
    public String getZtytokuteikigousedaikbn() {
        return ztytokuteikigousedaikbn;
    }

    public void setZtytokuteikigousedaikbn(String pZtytokuteikigousedaikbn) {
        ztytokuteikigousedaikbn = pZtytokuteikigousedaikbn;
    }

    private String ztyyobiv9x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV9X5)
    public String getZtyyobiv9x5() {
        return ztyyobiv9x5;
    }

    public void setZtyyobiv9x5(String pZtyyobiv9x5) {
        ztyyobiv9x5 = pZtyyobiv9x5;
    }

    private String ztykzkmrtitkyknox1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITKYKNOX1)
    public String getZtykzkmrtitkyknox1() {
        return ztykzkmrtitkyknox1;
    }

    public void setZtykzkmrtitkyknox1(String pZtykzkmrtitkyknox1) {
        ztykzkmrtitkyknox1 = pZtykzkmrtitkyknox1;
    }

    private String ztykazokumrtisyuruikgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTISYURUIKGUX1)
    public String getZtykazokumrtisyuruikgux1() {
        return ztykazokumrtisyuruikgux1;
    }

    public void setZtykazokumrtisyuruikgux1(String pZtykazokumrtisyuruikgux1) {
        ztykazokumrtisyuruikgux1 = pZtykazokumrtisyuruikgux1;
    }

    private String ztykazokumaruteikikanx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIKIKANX1)
    public String getZtykazokumaruteikikanx1() {
        return ztykazokumaruteikikanx1;
    }

    public void setZtykazokumaruteikikanx1(String pZtykazokumaruteikikanx1) {
        ztykazokumaruteikikanx1 = pZtykazokumaruteikikanx1;
    }

    private String ztykazokumrtiphrkkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIPHRKKKNX1)
    public String getZtykazokumrtiphrkkknx1() {
        return ztykazokumrtiphrkkknx1;
    }

    public void setZtykazokumrtiphrkkknx1(String pZtykazokumrtiphrkkknx1) {
        ztykazokumrtiphrkkknx1 = pZtykazokumrtiphrkkknx1;
    }

    private Long ztykazokumaruteisx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEISX1)
    public Long getZtykazokumaruteisx1() {
        return ztykazokumaruteisx1;
    }

    public void setZtykazokumaruteisx1(Long pZtykazokumaruteisx1) {
        ztykazokumaruteisx1 = pZtykazokumaruteisx1;
    }

    private Long ztykazokumaruteipx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIPX1)
    public Long getZtykazokumaruteipx1() {
        return ztykazokumaruteipx1;
    }

    public void setZtykazokumaruteipx1(Long pZtykazokumaruteipx1) {
        ztykazokumaruteipx1 = pZtykazokumaruteipx1;
    }

    private String ztykzkmrtihihknsyanmx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYANMX1)
    public String getZtykzkmrtihihknsyanmx1() {
        return ztykzkmrtihihknsyanmx1;
    }

    public void setZtykzkmrtihihknsyanmx1(String pZtykzkmrtihihknsyanmx1) {
        ztykzkmrtihihknsyanmx1 = pZtykzkmrtihihknsyanmx1;
    }

    private String ztykzkmrtihihknsyseiymdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSEIYMDX1)
    public String getZtykzkmrtihihknsyseiymdx1() {
        return ztykzkmrtihihknsyseiymdx1;
    }

    public void setZtykzkmrtihihknsyseiymdx1(String pZtykzkmrtihihknsyseiymdx1) {
        ztykzkmrtihihknsyseiymdx1 = pZtykzkmrtihihknsyseiymdx1;
    }

    private String ztykzkmrtihihknsysibtkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSIBTKBNX1)
    public String getZtykzkmrtihihknsysibtkbnx1() {
        return ztykzkmrtihihknsysibtkbnx1;
    }

    public void setZtykzkmrtihihknsysibtkbnx1(String pZtykzkmrtihihknsysibtkbnx1) {
        ztykzkmrtihihknsysibtkbnx1 = pZtykzkmrtihihknsysibtkbnx1;
    }

    private String ztykazokumrtihihknsyaagex1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIHIHKNSYAAGEX1)
    public String getZtykazokumrtihihknsyaagex1() {
        return ztykazokumrtihihknsyaagex1;
    }

    public void setZtykazokumrtihihknsyaagex1(String pZtykazokumrtihihknsyaagex1) {
        ztykazokumrtihihknsyaagex1 = pZtykazokumrtihihknsyaagex1;
    }

    private Long ztykzkmrtimodsx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIMODSX1)
    public Long getZtykzkmrtimodsx1() {
        return ztykzkmrtimodsx1;
    }

    public void setZtykzkmrtimodsx1(Long pZtykzkmrtimodsx1) {
        ztykzkmrtimodsx1 = pZtykzkmrtimodsx1;
    }

    private String ztykazokumrtimodsskgnhyjx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIMODSSKGNHYJX1)
    public String getZtykazokumrtimodsskgnhyjx1() {
        return ztykazokumrtimodsskgnhyjx1;
    }

    public void setZtykazokumrtimodsskgnhyjx1(String pZtykazokumrtimodsskgnhyjx1) {
        ztykazokumrtimodsskgnhyjx1 = pZtykazokumrtimodsskgnhyjx1;
    }

    private String ztykzkmrtitnknyugukbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITNKNYUGUKBNX1)
    public String getZtykzkmrtitnknyugukbnx1() {
        return ztykzkmrtitnknyugukbnx1;
    }

    public void setZtykzkmrtitnknyugukbnx1(String pZtykzkmrtitnknyugukbnx1) {
        ztykzkmrtitnknyugukbnx1 = pZtykzkmrtitnknyugukbnx1;
    }

    private String ztykazokumrtikgusdkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIKGUSDKBNX1)
    public String getZtykazokumrtikgusdkbnx1() {
        return ztykazokumrtikgusdkbnx1;
    }

    public void setZtykazokumrtikgusdkbnx1(String pZtykazokumrtikgusdkbnx1) {
        ztykazokumrtikgusdkbnx1 = pZtykazokumrtikgusdkbnx1;
    }

    private String ztykazokumrtiagetyusihyjx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIAGETYUSIHYJX1)
    public String getZtykazokumrtiagetyusihyjx1() {
        return ztykazokumrtiagetyusihyjx1;
    }

    public void setZtykazokumrtiagetyusihyjx1(String pZtykazokumrtiagetyusihyjx1) {
        ztykazokumrtiagetyusihyjx1 = pZtykazokumrtiagetyusihyjx1;
    }

    private String ztykzkmrtikusnmnryoagex1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIKUSNMNRYOAGEX1)
    public String getZtykzkmrtikusnmnryoagex1() {
        return ztykzkmrtikusnmnryoagex1;
    }

    public void setZtykzkmrtikusnmnryoagex1(String pZtykzkmrtikusnmnryoagex1) {
        ztykzkmrtikusnmnryoagex1 = pZtykzkmrtikusnmnryoagex1;
    }

    private String ztyyobiv4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }

    private String ztykzkmrtitkyknox2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITKYKNOX2)
    public String getZtykzkmrtitkyknox2() {
        return ztykzkmrtitkyknox2;
    }

    public void setZtykzkmrtitkyknox2(String pZtykzkmrtitkyknox2) {
        ztykzkmrtitkyknox2 = pZtykzkmrtitkyknox2;
    }

    private String ztykazokumrtisyuruikgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTISYURUIKGUX2)
    public String getZtykazokumrtisyuruikgux2() {
        return ztykazokumrtisyuruikgux2;
    }

    public void setZtykazokumrtisyuruikgux2(String pZtykazokumrtisyuruikgux2) {
        ztykazokumrtisyuruikgux2 = pZtykazokumrtisyuruikgux2;
    }

    private String ztykazokumaruteikikanx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIKIKANX2)
    public String getZtykazokumaruteikikanx2() {
        return ztykazokumaruteikikanx2;
    }

    public void setZtykazokumaruteikikanx2(String pZtykazokumaruteikikanx2) {
        ztykazokumaruteikikanx2 = pZtykazokumaruteikikanx2;
    }

    private String ztykazokumrtiphrkkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIPHRKKKNX2)
    public String getZtykazokumrtiphrkkknx2() {
        return ztykazokumrtiphrkkknx2;
    }

    public void setZtykazokumrtiphrkkknx2(String pZtykazokumrtiphrkkknx2) {
        ztykazokumrtiphrkkknx2 = pZtykazokumrtiphrkkknx2;
    }

    private Long ztykazokumaruteisx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEISX2)
    public Long getZtykazokumaruteisx2() {
        return ztykazokumaruteisx2;
    }

    public void setZtykazokumaruteisx2(Long pZtykazokumaruteisx2) {
        ztykazokumaruteisx2 = pZtykazokumaruteisx2;
    }

    private Long ztykazokumaruteipx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIPX2)
    public Long getZtykazokumaruteipx2() {
        return ztykazokumaruteipx2;
    }

    public void setZtykazokumaruteipx2(Long pZtykazokumaruteipx2) {
        ztykazokumaruteipx2 = pZtykazokumaruteipx2;
    }

    private String ztykzkmrtihihknsyanmx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYANMX2)
    public String getZtykzkmrtihihknsyanmx2() {
        return ztykzkmrtihihknsyanmx2;
    }

    public void setZtykzkmrtihihknsyanmx2(String pZtykzkmrtihihknsyanmx2) {
        ztykzkmrtihihknsyanmx2 = pZtykzkmrtihihknsyanmx2;
    }

    private String ztykzkmrtihihknsyseiymdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSEIYMDX2)
    public String getZtykzkmrtihihknsyseiymdx2() {
        return ztykzkmrtihihknsyseiymdx2;
    }

    public void setZtykzkmrtihihknsyseiymdx2(String pZtykzkmrtihihknsyseiymdx2) {
        ztykzkmrtihihknsyseiymdx2 = pZtykzkmrtihihknsyseiymdx2;
    }

    private String ztykzkmrtihihknsysibtkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSIBTKBNX2)
    public String getZtykzkmrtihihknsysibtkbnx2() {
        return ztykzkmrtihihknsysibtkbnx2;
    }

    public void setZtykzkmrtihihknsysibtkbnx2(String pZtykzkmrtihihknsysibtkbnx2) {
        ztykzkmrtihihknsysibtkbnx2 = pZtykzkmrtihihknsysibtkbnx2;
    }

    private String ztykazokumrtihihknsyaagex2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIHIHKNSYAAGEX2)
    public String getZtykazokumrtihihknsyaagex2() {
        return ztykazokumrtihihknsyaagex2;
    }

    public void setZtykazokumrtihihknsyaagex2(String pZtykazokumrtihihknsyaagex2) {
        ztykazokumrtihihknsyaagex2 = pZtykazokumrtihihknsyaagex2;
    }

    private Long ztykzkmrtimodsx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIMODSX2)
    public Long getZtykzkmrtimodsx2() {
        return ztykzkmrtimodsx2;
    }

    public void setZtykzkmrtimodsx2(Long pZtykzkmrtimodsx2) {
        ztykzkmrtimodsx2 = pZtykzkmrtimodsx2;
    }

    private String ztykazokumrtimodsskgnhyjx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIMODSSKGNHYJX2)
    public String getZtykazokumrtimodsskgnhyjx2() {
        return ztykazokumrtimodsskgnhyjx2;
    }

    public void setZtykazokumrtimodsskgnhyjx2(String pZtykazokumrtimodsskgnhyjx2) {
        ztykazokumrtimodsskgnhyjx2 = pZtykazokumrtimodsskgnhyjx2;
    }

    private String ztykzkmrtitnknyugukbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITNKNYUGUKBNX2)
    public String getZtykzkmrtitnknyugukbnx2() {
        return ztykzkmrtitnknyugukbnx2;
    }

    public void setZtykzkmrtitnknyugukbnx2(String pZtykzkmrtitnknyugukbnx2) {
        ztykzkmrtitnknyugukbnx2 = pZtykzkmrtitnknyugukbnx2;
    }

    private String ztykazokumrtikgusdkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIKGUSDKBNX2)
    public String getZtykazokumrtikgusdkbnx2() {
        return ztykazokumrtikgusdkbnx2;
    }

    public void setZtykazokumrtikgusdkbnx2(String pZtykazokumrtikgusdkbnx2) {
        ztykazokumrtikgusdkbnx2 = pZtykazokumrtikgusdkbnx2;
    }

    private String ztykazokumrtiagetyusihyjx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIAGETYUSIHYJX2)
    public String getZtykazokumrtiagetyusihyjx2() {
        return ztykazokumrtiagetyusihyjx2;
    }

    public void setZtykazokumrtiagetyusihyjx2(String pZtykazokumrtiagetyusihyjx2) {
        ztykazokumrtiagetyusihyjx2 = pZtykazokumrtiagetyusihyjx2;
    }

    private String ztykzkmrtikusnmnryoagex2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIKUSNMNRYOAGEX2)
    public String getZtykzkmrtikusnmnryoagex2() {
        return ztykzkmrtikusnmnryoagex2;
    }

    public void setZtykzkmrtikusnmnryoagex2(String pZtykzkmrtikusnmnryoagex2) {
        ztykzkmrtikusnmnryoagex2 = pZtykzkmrtikusnmnryoagex2;
    }

    private String ztyyobiv4x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X2)
    public String getZtyyobiv4x2() {
        return ztyyobiv4x2;
    }

    public void setZtyyobiv4x2(String pZtyyobiv4x2) {
        ztyyobiv4x2 = pZtyyobiv4x2;
    }

    private String ztykzkmrtitkyknox3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITKYKNOX3)
    public String getZtykzkmrtitkyknox3() {
        return ztykzkmrtitkyknox3;
    }

    public void setZtykzkmrtitkyknox3(String pZtykzkmrtitkyknox3) {
        ztykzkmrtitkyknox3 = pZtykzkmrtitkyknox3;
    }

    private String ztykazokumrtisyuruikgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTISYURUIKGUX3)
    public String getZtykazokumrtisyuruikgux3() {
        return ztykazokumrtisyuruikgux3;
    }

    public void setZtykazokumrtisyuruikgux3(String pZtykazokumrtisyuruikgux3) {
        ztykazokumrtisyuruikgux3 = pZtykazokumrtisyuruikgux3;
    }

    private String ztykazokumaruteikikanx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIKIKANX3)
    public String getZtykazokumaruteikikanx3() {
        return ztykazokumaruteikikanx3;
    }

    public void setZtykazokumaruteikikanx3(String pZtykazokumaruteikikanx3) {
        ztykazokumaruteikikanx3 = pZtykazokumaruteikikanx3;
    }

    private String ztykazokumrtiphrkkknx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIPHRKKKNX3)
    public String getZtykazokumrtiphrkkknx3() {
        return ztykazokumrtiphrkkknx3;
    }

    public void setZtykazokumrtiphrkkknx3(String pZtykazokumrtiphrkkknx3) {
        ztykazokumrtiphrkkknx3 = pZtykazokumrtiphrkkknx3;
    }

    private Long ztykazokumaruteisx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEISX3)
    public Long getZtykazokumaruteisx3() {
        return ztykazokumaruteisx3;
    }

    public void setZtykazokumaruteisx3(Long pZtykazokumaruteisx3) {
        ztykazokumaruteisx3 = pZtykazokumaruteisx3;
    }

    private Long ztykazokumaruteipx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIPX3)
    public Long getZtykazokumaruteipx3() {
        return ztykazokumaruteipx3;
    }

    public void setZtykazokumaruteipx3(Long pZtykazokumaruteipx3) {
        ztykazokumaruteipx3 = pZtykazokumaruteipx3;
    }

    private String ztykzkmrtihihknsyanmx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYANMX3)
    public String getZtykzkmrtihihknsyanmx3() {
        return ztykzkmrtihihknsyanmx3;
    }

    public void setZtykzkmrtihihknsyanmx3(String pZtykzkmrtihihknsyanmx3) {
        ztykzkmrtihihknsyanmx3 = pZtykzkmrtihihknsyanmx3;
    }

    private String ztykzkmrtihihknsyseiymdx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSEIYMDX3)
    public String getZtykzkmrtihihknsyseiymdx3() {
        return ztykzkmrtihihknsyseiymdx3;
    }

    public void setZtykzkmrtihihknsyseiymdx3(String pZtykzkmrtihihknsyseiymdx3) {
        ztykzkmrtihihknsyseiymdx3 = pZtykzkmrtihihknsyseiymdx3;
    }

    private String ztykzkmrtihihknsysibtkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSIBTKBNX3)
    public String getZtykzkmrtihihknsysibtkbnx3() {
        return ztykzkmrtihihknsysibtkbnx3;
    }

    public void setZtykzkmrtihihknsysibtkbnx3(String pZtykzkmrtihihknsysibtkbnx3) {
        ztykzkmrtihihknsysibtkbnx3 = pZtykzkmrtihihknsysibtkbnx3;
    }

    private String ztykazokumrtihihknsyaagex3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIHIHKNSYAAGEX3)
    public String getZtykazokumrtihihknsyaagex3() {
        return ztykazokumrtihihknsyaagex3;
    }

    public void setZtykazokumrtihihknsyaagex3(String pZtykazokumrtihihknsyaagex3) {
        ztykazokumrtihihknsyaagex3 = pZtykazokumrtihihknsyaagex3;
    }

    private Long ztykzkmrtimodsx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIMODSX3)
    public Long getZtykzkmrtimodsx3() {
        return ztykzkmrtimodsx3;
    }

    public void setZtykzkmrtimodsx3(Long pZtykzkmrtimodsx3) {
        ztykzkmrtimodsx3 = pZtykzkmrtimodsx3;
    }

    private String ztykazokumrtimodsskgnhyjx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIMODSSKGNHYJX3)
    public String getZtykazokumrtimodsskgnhyjx3() {
        return ztykazokumrtimodsskgnhyjx3;
    }

    public void setZtykazokumrtimodsskgnhyjx3(String pZtykazokumrtimodsskgnhyjx3) {
        ztykazokumrtimodsskgnhyjx3 = pZtykazokumrtimodsskgnhyjx3;
    }

    private String ztykzkmrtitnknyugukbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITNKNYUGUKBNX3)
    public String getZtykzkmrtitnknyugukbnx3() {
        return ztykzkmrtitnknyugukbnx3;
    }

    public void setZtykzkmrtitnknyugukbnx3(String pZtykzkmrtitnknyugukbnx3) {
        ztykzkmrtitnknyugukbnx3 = pZtykzkmrtitnknyugukbnx3;
    }

    private String ztykazokumrtikgusdkbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIKGUSDKBNX3)
    public String getZtykazokumrtikgusdkbnx3() {
        return ztykazokumrtikgusdkbnx3;
    }

    public void setZtykazokumrtikgusdkbnx3(String pZtykazokumrtikgusdkbnx3) {
        ztykazokumrtikgusdkbnx3 = pZtykazokumrtikgusdkbnx3;
    }

    private String ztykazokumrtiagetyusihyjx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIAGETYUSIHYJX3)
    public String getZtykazokumrtiagetyusihyjx3() {
        return ztykazokumrtiagetyusihyjx3;
    }

    public void setZtykazokumrtiagetyusihyjx3(String pZtykazokumrtiagetyusihyjx3) {
        ztykazokumrtiagetyusihyjx3 = pZtykazokumrtiagetyusihyjx3;
    }

    private String ztykzkmrtikusnmnryoagex3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIKUSNMNRYOAGEX3)
    public String getZtykzkmrtikusnmnryoagex3() {
        return ztykzkmrtikusnmnryoagex3;
    }

    public void setZtykzkmrtikusnmnryoagex3(String pZtykzkmrtikusnmnryoagex3) {
        ztykzkmrtikusnmnryoagex3 = pZtykzkmrtikusnmnryoagex3;
    }

    private String ztyyobiv4x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X3)
    public String getZtyyobiv4x3() {
        return ztyyobiv4x3;
    }

    public void setZtyyobiv4x3(String pZtyyobiv4x3) {
        ztyyobiv4x3 = pZtyyobiv4x3;
    }

    private String ztykzkmrtitkyknox4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITKYKNOX4)
    public String getZtykzkmrtitkyknox4() {
        return ztykzkmrtitkyknox4;
    }

    public void setZtykzkmrtitkyknox4(String pZtykzkmrtitkyknox4) {
        ztykzkmrtitkyknox4 = pZtykzkmrtitkyknox4;
    }

    private String ztykazokumrtisyuruikgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTISYURUIKGUX4)
    public String getZtykazokumrtisyuruikgux4() {
        return ztykazokumrtisyuruikgux4;
    }

    public void setZtykazokumrtisyuruikgux4(String pZtykazokumrtisyuruikgux4) {
        ztykazokumrtisyuruikgux4 = pZtykazokumrtisyuruikgux4;
    }

    private String ztykazokumaruteikikanx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIKIKANX4)
    public String getZtykazokumaruteikikanx4() {
        return ztykazokumaruteikikanx4;
    }

    public void setZtykazokumaruteikikanx4(String pZtykazokumaruteikikanx4) {
        ztykazokumaruteikikanx4 = pZtykazokumaruteikikanx4;
    }

    private String ztykazokumrtiphrkkknx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIPHRKKKNX4)
    public String getZtykazokumrtiphrkkknx4() {
        return ztykazokumrtiphrkkknx4;
    }

    public void setZtykazokumrtiphrkkknx4(String pZtykazokumrtiphrkkknx4) {
        ztykazokumrtiphrkkknx4 = pZtykazokumrtiphrkkknx4;
    }

    private Long ztykazokumaruteisx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEISX4)
    public Long getZtykazokumaruteisx4() {
        return ztykazokumaruteisx4;
    }

    public void setZtykazokumaruteisx4(Long pZtykazokumaruteisx4) {
        ztykazokumaruteisx4 = pZtykazokumaruteisx4;
    }

    private Long ztykazokumaruteipx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIPX4)
    public Long getZtykazokumaruteipx4() {
        return ztykazokumaruteipx4;
    }

    public void setZtykazokumaruteipx4(Long pZtykazokumaruteipx4) {
        ztykazokumaruteipx4 = pZtykazokumaruteipx4;
    }

    private String ztykzkmrtihihknsyanmx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYANMX4)
    public String getZtykzkmrtihihknsyanmx4() {
        return ztykzkmrtihihknsyanmx4;
    }

    public void setZtykzkmrtihihknsyanmx4(String pZtykzkmrtihihknsyanmx4) {
        ztykzkmrtihihknsyanmx4 = pZtykzkmrtihihknsyanmx4;
    }

    private String ztykzkmrtihihknsyseiymdx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSEIYMDX4)
    public String getZtykzkmrtihihknsyseiymdx4() {
        return ztykzkmrtihihknsyseiymdx4;
    }

    public void setZtykzkmrtihihknsyseiymdx4(String pZtykzkmrtihihknsyseiymdx4) {
        ztykzkmrtihihknsyseiymdx4 = pZtykzkmrtihihknsyseiymdx4;
    }

    private String ztykzkmrtihihknsysibtkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSIBTKBNX4)
    public String getZtykzkmrtihihknsysibtkbnx4() {
        return ztykzkmrtihihknsysibtkbnx4;
    }

    public void setZtykzkmrtihihknsysibtkbnx4(String pZtykzkmrtihihknsysibtkbnx4) {
        ztykzkmrtihihknsysibtkbnx4 = pZtykzkmrtihihknsysibtkbnx4;
    }

    private String ztykazokumrtihihknsyaagex4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIHIHKNSYAAGEX4)
    public String getZtykazokumrtihihknsyaagex4() {
        return ztykazokumrtihihknsyaagex4;
    }

    public void setZtykazokumrtihihknsyaagex4(String pZtykazokumrtihihknsyaagex4) {
        ztykazokumrtihihknsyaagex4 = pZtykazokumrtihihknsyaagex4;
    }

    private Long ztykzkmrtimodsx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIMODSX4)
    public Long getZtykzkmrtimodsx4() {
        return ztykzkmrtimodsx4;
    }

    public void setZtykzkmrtimodsx4(Long pZtykzkmrtimodsx4) {
        ztykzkmrtimodsx4 = pZtykzkmrtimodsx4;
    }

    private String ztykazokumrtimodsskgnhyjx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIMODSSKGNHYJX4)
    public String getZtykazokumrtimodsskgnhyjx4() {
        return ztykazokumrtimodsskgnhyjx4;
    }

    public void setZtykazokumrtimodsskgnhyjx4(String pZtykazokumrtimodsskgnhyjx4) {
        ztykazokumrtimodsskgnhyjx4 = pZtykazokumrtimodsskgnhyjx4;
    }

    private String ztykzkmrtitnknyugukbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITNKNYUGUKBNX4)
    public String getZtykzkmrtitnknyugukbnx4() {
        return ztykzkmrtitnknyugukbnx4;
    }

    public void setZtykzkmrtitnknyugukbnx4(String pZtykzkmrtitnknyugukbnx4) {
        ztykzkmrtitnknyugukbnx4 = pZtykzkmrtitnknyugukbnx4;
    }

    private String ztykazokumrtikgusdkbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIKGUSDKBNX4)
    public String getZtykazokumrtikgusdkbnx4() {
        return ztykazokumrtikgusdkbnx4;
    }

    public void setZtykazokumrtikgusdkbnx4(String pZtykazokumrtikgusdkbnx4) {
        ztykazokumrtikgusdkbnx4 = pZtykazokumrtikgusdkbnx4;
    }

    private String ztykazokumrtiagetyusihyjx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIAGETYUSIHYJX4)
    public String getZtykazokumrtiagetyusihyjx4() {
        return ztykazokumrtiagetyusihyjx4;
    }

    public void setZtykazokumrtiagetyusihyjx4(String pZtykazokumrtiagetyusihyjx4) {
        ztykazokumrtiagetyusihyjx4 = pZtykazokumrtiagetyusihyjx4;
    }

    private String ztykzkmrtikusnmnryoagex4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIKUSNMNRYOAGEX4)
    public String getZtykzkmrtikusnmnryoagex4() {
        return ztykzkmrtikusnmnryoagex4;
    }

    public void setZtykzkmrtikusnmnryoagex4(String pZtykzkmrtikusnmnryoagex4) {
        ztykzkmrtikusnmnryoagex4 = pZtykzkmrtikusnmnryoagex4;
    }

    private String ztyyobiv4x4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X4)
    public String getZtyyobiv4x4() {
        return ztyyobiv4x4;
    }

    public void setZtyyobiv4x4(String pZtyyobiv4x4) {
        ztyyobiv4x4 = pZtyyobiv4x4;
    }

    private String ztykzkmrtitkyknox5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITKYKNOX5)
    public String getZtykzkmrtitkyknox5() {
        return ztykzkmrtitkyknox5;
    }

    public void setZtykzkmrtitkyknox5(String pZtykzkmrtitkyknox5) {
        ztykzkmrtitkyknox5 = pZtykzkmrtitkyknox5;
    }

    private String ztykazokumrtisyuruikgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTISYURUIKGUX5)
    public String getZtykazokumrtisyuruikgux5() {
        return ztykazokumrtisyuruikgux5;
    }

    public void setZtykazokumrtisyuruikgux5(String pZtykazokumrtisyuruikgux5) {
        ztykazokumrtisyuruikgux5 = pZtykazokumrtisyuruikgux5;
    }

    private String ztykazokumaruteikikanx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIKIKANX5)
    public String getZtykazokumaruteikikanx5() {
        return ztykazokumaruteikikanx5;
    }

    public void setZtykazokumaruteikikanx5(String pZtykazokumaruteikikanx5) {
        ztykazokumaruteikikanx5 = pZtykazokumaruteikikanx5;
    }

    private String ztykazokumrtiphrkkknx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIPHRKKKNX5)
    public String getZtykazokumrtiphrkkknx5() {
        return ztykazokumrtiphrkkknx5;
    }

    public void setZtykazokumrtiphrkkknx5(String pZtykazokumrtiphrkkknx5) {
        ztykazokumrtiphrkkknx5 = pZtykazokumrtiphrkkknx5;
    }

    private Long ztykazokumaruteisx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEISX5)
    public Long getZtykazokumaruteisx5() {
        return ztykazokumaruteisx5;
    }

    public void setZtykazokumaruteisx5(Long pZtykazokumaruteisx5) {
        ztykazokumaruteisx5 = pZtykazokumaruteisx5;
    }

    private Long ztykazokumaruteipx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIPX5)
    public Long getZtykazokumaruteipx5() {
        return ztykazokumaruteipx5;
    }

    public void setZtykazokumaruteipx5(Long pZtykazokumaruteipx5) {
        ztykazokumaruteipx5 = pZtykazokumaruteipx5;
    }

    private String ztykzkmrtihihknsyanmx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYANMX5)
    public String getZtykzkmrtihihknsyanmx5() {
        return ztykzkmrtihihknsyanmx5;
    }

    public void setZtykzkmrtihihknsyanmx5(String pZtykzkmrtihihknsyanmx5) {
        ztykzkmrtihihknsyanmx5 = pZtykzkmrtihihknsyanmx5;
    }

    private String ztykzkmrtihihknsyseiymdx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSEIYMDX5)
    public String getZtykzkmrtihihknsyseiymdx5() {
        return ztykzkmrtihihknsyseiymdx5;
    }

    public void setZtykzkmrtihihknsyseiymdx5(String pZtykzkmrtihihknsyseiymdx5) {
        ztykzkmrtihihknsyseiymdx5 = pZtykzkmrtihihknsyseiymdx5;
    }

    private String ztykzkmrtihihknsysibtkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSIBTKBNX5)
    public String getZtykzkmrtihihknsysibtkbnx5() {
        return ztykzkmrtihihknsysibtkbnx5;
    }

    public void setZtykzkmrtihihknsysibtkbnx5(String pZtykzkmrtihihknsysibtkbnx5) {
        ztykzkmrtihihknsysibtkbnx5 = pZtykzkmrtihihknsysibtkbnx5;
    }

    private String ztykazokumrtihihknsyaagex5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIHIHKNSYAAGEX5)
    public String getZtykazokumrtihihknsyaagex5() {
        return ztykazokumrtihihknsyaagex5;
    }

    public void setZtykazokumrtihihknsyaagex5(String pZtykazokumrtihihknsyaagex5) {
        ztykazokumrtihihknsyaagex5 = pZtykazokumrtihihknsyaagex5;
    }

    private Long ztykzkmrtimodsx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIMODSX5)
    public Long getZtykzkmrtimodsx5() {
        return ztykzkmrtimodsx5;
    }

    public void setZtykzkmrtimodsx5(Long pZtykzkmrtimodsx5) {
        ztykzkmrtimodsx5 = pZtykzkmrtimodsx5;
    }

    private String ztykazokumrtimodsskgnhyjx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIMODSSKGNHYJX5)
    public String getZtykazokumrtimodsskgnhyjx5() {
        return ztykazokumrtimodsskgnhyjx5;
    }

    public void setZtykazokumrtimodsskgnhyjx5(String pZtykazokumrtimodsskgnhyjx5) {
        ztykazokumrtimodsskgnhyjx5 = pZtykazokumrtimodsskgnhyjx5;
    }

    private String ztykzkmrtitnknyugukbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITNKNYUGUKBNX5)
    public String getZtykzkmrtitnknyugukbnx5() {
        return ztykzkmrtitnknyugukbnx5;
    }

    public void setZtykzkmrtitnknyugukbnx5(String pZtykzkmrtitnknyugukbnx5) {
        ztykzkmrtitnknyugukbnx5 = pZtykzkmrtitnknyugukbnx5;
    }

    private String ztykazokumrtikgusdkbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIKGUSDKBNX5)
    public String getZtykazokumrtikgusdkbnx5() {
        return ztykazokumrtikgusdkbnx5;
    }

    public void setZtykazokumrtikgusdkbnx5(String pZtykazokumrtikgusdkbnx5) {
        ztykazokumrtikgusdkbnx5 = pZtykazokumrtikgusdkbnx5;
    }

    private String ztykazokumrtiagetyusihyjx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIAGETYUSIHYJX5)
    public String getZtykazokumrtiagetyusihyjx5() {
        return ztykazokumrtiagetyusihyjx5;
    }

    public void setZtykazokumrtiagetyusihyjx5(String pZtykazokumrtiagetyusihyjx5) {
        ztykazokumrtiagetyusihyjx5 = pZtykazokumrtiagetyusihyjx5;
    }

    private String ztykzkmrtikusnmnryoagex5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIKUSNMNRYOAGEX5)
    public String getZtykzkmrtikusnmnryoagex5() {
        return ztykzkmrtikusnmnryoagex5;
    }

    public void setZtykzkmrtikusnmnryoagex5(String pZtykzkmrtikusnmnryoagex5) {
        ztykzkmrtikusnmnryoagex5 = pZtykzkmrtikusnmnryoagex5;
    }

    private String ztyyobiv4x5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X5)
    public String getZtyyobiv4x5() {
        return ztyyobiv4x5;
    }

    public void setZtyyobiv4x5(String pZtyyobiv4x5) {
        ztyyobiv4x5 = pZtyyobiv4x5;
    }

    private String ztykzkmrtitkyknox6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITKYKNOX6)
    public String getZtykzkmrtitkyknox6() {
        return ztykzkmrtitkyknox6;
    }

    public void setZtykzkmrtitkyknox6(String pZtykzkmrtitkyknox6) {
        ztykzkmrtitkyknox6 = pZtykzkmrtitkyknox6;
    }

    private String ztykazokumrtisyuruikgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTISYURUIKGUX6)
    public String getZtykazokumrtisyuruikgux6() {
        return ztykazokumrtisyuruikgux6;
    }

    public void setZtykazokumrtisyuruikgux6(String pZtykazokumrtisyuruikgux6) {
        ztykazokumrtisyuruikgux6 = pZtykazokumrtisyuruikgux6;
    }

    private String ztykazokumaruteikikanx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIKIKANX6)
    public String getZtykazokumaruteikikanx6() {
        return ztykazokumaruteikikanx6;
    }

    public void setZtykazokumaruteikikanx6(String pZtykazokumaruteikikanx6) {
        ztykazokumaruteikikanx6 = pZtykazokumaruteikikanx6;
    }

    private String ztykazokumrtiphrkkknx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIPHRKKKNX6)
    public String getZtykazokumrtiphrkkknx6() {
        return ztykazokumrtiphrkkknx6;
    }

    public void setZtykazokumrtiphrkkknx6(String pZtykazokumrtiphrkkknx6) {
        ztykazokumrtiphrkkknx6 = pZtykazokumrtiphrkkknx6;
    }

    private Long ztykazokumaruteisx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEISX6)
    public Long getZtykazokumaruteisx6() {
        return ztykazokumaruteisx6;
    }

    public void setZtykazokumaruteisx6(Long pZtykazokumaruteisx6) {
        ztykazokumaruteisx6 = pZtykazokumaruteisx6;
    }

    private Long ztykazokumaruteipx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIPX6)
    public Long getZtykazokumaruteipx6() {
        return ztykazokumaruteipx6;
    }

    public void setZtykazokumaruteipx6(Long pZtykazokumaruteipx6) {
        ztykazokumaruteipx6 = pZtykazokumaruteipx6;
    }

    private String ztykzkmrtihihknsyanmx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYANMX6)
    public String getZtykzkmrtihihknsyanmx6() {
        return ztykzkmrtihihknsyanmx6;
    }

    public void setZtykzkmrtihihknsyanmx6(String pZtykzkmrtihihknsyanmx6) {
        ztykzkmrtihihknsyanmx6 = pZtykzkmrtihihknsyanmx6;
    }

    private String ztykzkmrtihihknsyseiymdx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSEIYMDX6)
    public String getZtykzkmrtihihknsyseiymdx6() {
        return ztykzkmrtihihknsyseiymdx6;
    }

    public void setZtykzkmrtihihknsyseiymdx6(String pZtykzkmrtihihknsyseiymdx6) {
        ztykzkmrtihihknsyseiymdx6 = pZtykzkmrtihihknsyseiymdx6;
    }

    private String ztykzkmrtihihknsysibtkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSIBTKBNX6)
    public String getZtykzkmrtihihknsysibtkbnx6() {
        return ztykzkmrtihihknsysibtkbnx6;
    }

    public void setZtykzkmrtihihknsysibtkbnx6(String pZtykzkmrtihihknsysibtkbnx6) {
        ztykzkmrtihihknsysibtkbnx6 = pZtykzkmrtihihknsysibtkbnx6;
    }

    private String ztykazokumrtihihknsyaagex6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIHIHKNSYAAGEX6)
    public String getZtykazokumrtihihknsyaagex6() {
        return ztykazokumrtihihknsyaagex6;
    }

    public void setZtykazokumrtihihknsyaagex6(String pZtykazokumrtihihknsyaagex6) {
        ztykazokumrtihihknsyaagex6 = pZtykazokumrtihihknsyaagex6;
    }

    private Long ztykzkmrtimodsx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIMODSX6)
    public Long getZtykzkmrtimodsx6() {
        return ztykzkmrtimodsx6;
    }

    public void setZtykzkmrtimodsx6(Long pZtykzkmrtimodsx6) {
        ztykzkmrtimodsx6 = pZtykzkmrtimodsx6;
    }

    private String ztykazokumrtimodsskgnhyjx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIMODSSKGNHYJX6)
    public String getZtykazokumrtimodsskgnhyjx6() {
        return ztykazokumrtimodsskgnhyjx6;
    }

    public void setZtykazokumrtimodsskgnhyjx6(String pZtykazokumrtimodsskgnhyjx6) {
        ztykazokumrtimodsskgnhyjx6 = pZtykazokumrtimodsskgnhyjx6;
    }

    private String ztykzkmrtitnknyugukbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITNKNYUGUKBNX6)
    public String getZtykzkmrtitnknyugukbnx6() {
        return ztykzkmrtitnknyugukbnx6;
    }

    public void setZtykzkmrtitnknyugukbnx6(String pZtykzkmrtitnknyugukbnx6) {
        ztykzkmrtitnknyugukbnx6 = pZtykzkmrtitnknyugukbnx6;
    }

    private String ztykazokumrtikgusdkbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIKGUSDKBNX6)
    public String getZtykazokumrtikgusdkbnx6() {
        return ztykazokumrtikgusdkbnx6;
    }

    public void setZtykazokumrtikgusdkbnx6(String pZtykazokumrtikgusdkbnx6) {
        ztykazokumrtikgusdkbnx6 = pZtykazokumrtikgusdkbnx6;
    }

    private String ztykazokumrtiagetyusihyjx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIAGETYUSIHYJX6)
    public String getZtykazokumrtiagetyusihyjx6() {
        return ztykazokumrtiagetyusihyjx6;
    }

    public void setZtykazokumrtiagetyusihyjx6(String pZtykazokumrtiagetyusihyjx6) {
        ztykazokumrtiagetyusihyjx6 = pZtykazokumrtiagetyusihyjx6;
    }

    private String ztykzkmrtikusnmnryoagex6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIKUSNMNRYOAGEX6)
    public String getZtykzkmrtikusnmnryoagex6() {
        return ztykzkmrtikusnmnryoagex6;
    }

    public void setZtykzkmrtikusnmnryoagex6(String pZtykzkmrtikusnmnryoagex6) {
        ztykzkmrtikusnmnryoagex6 = pZtykzkmrtikusnmnryoagex6;
    }

    private String ztyyobiv4x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X6)
    public String getZtyyobiv4x6() {
        return ztyyobiv4x6;
    }

    public void setZtyyobiv4x6(String pZtyyobiv4x6) {
        ztyyobiv4x6 = pZtyyobiv4x6;
    }

    private String ztykzkmrtitkyknox7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITKYKNOX7)
    public String getZtykzkmrtitkyknox7() {
        return ztykzkmrtitkyknox7;
    }

    public void setZtykzkmrtitkyknox7(String pZtykzkmrtitkyknox7) {
        ztykzkmrtitkyknox7 = pZtykzkmrtitkyknox7;
    }

    private String ztykazokumrtisyuruikgux7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTISYURUIKGUX7)
    public String getZtykazokumrtisyuruikgux7() {
        return ztykazokumrtisyuruikgux7;
    }

    public void setZtykazokumrtisyuruikgux7(String pZtykazokumrtisyuruikgux7) {
        ztykazokumrtisyuruikgux7 = pZtykazokumrtisyuruikgux7;
    }

    private String ztykazokumaruteikikanx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIKIKANX7)
    public String getZtykazokumaruteikikanx7() {
        return ztykazokumaruteikikanx7;
    }

    public void setZtykazokumaruteikikanx7(String pZtykazokumaruteikikanx7) {
        ztykazokumaruteikikanx7 = pZtykazokumaruteikikanx7;
    }

    private String ztykazokumrtiphrkkknx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIPHRKKKNX7)
    public String getZtykazokumrtiphrkkknx7() {
        return ztykazokumrtiphrkkknx7;
    }

    public void setZtykazokumrtiphrkkknx7(String pZtykazokumrtiphrkkknx7) {
        ztykazokumrtiphrkkknx7 = pZtykazokumrtiphrkkknx7;
    }

    private Long ztykazokumaruteisx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEISX7)
    public Long getZtykazokumaruteisx7() {
        return ztykazokumaruteisx7;
    }

    public void setZtykazokumaruteisx7(Long pZtykazokumaruteisx7) {
        ztykazokumaruteisx7 = pZtykazokumaruteisx7;
    }

    private Long ztykazokumaruteipx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIPX7)
    public Long getZtykazokumaruteipx7() {
        return ztykazokumaruteipx7;
    }

    public void setZtykazokumaruteipx7(Long pZtykazokumaruteipx7) {
        ztykazokumaruteipx7 = pZtykazokumaruteipx7;
    }

    private String ztykzkmrtihihknsyanmx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYANMX7)
    public String getZtykzkmrtihihknsyanmx7() {
        return ztykzkmrtihihknsyanmx7;
    }

    public void setZtykzkmrtihihknsyanmx7(String pZtykzkmrtihihknsyanmx7) {
        ztykzkmrtihihknsyanmx7 = pZtykzkmrtihihknsyanmx7;
    }

    private String ztykzkmrtihihknsyseiymdx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSEIYMDX7)
    public String getZtykzkmrtihihknsyseiymdx7() {
        return ztykzkmrtihihknsyseiymdx7;
    }

    public void setZtykzkmrtihihknsyseiymdx7(String pZtykzkmrtihihknsyseiymdx7) {
        ztykzkmrtihihknsyseiymdx7 = pZtykzkmrtihihknsyseiymdx7;
    }

    private String ztykzkmrtihihknsysibtkbnx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSIBTKBNX7)
    public String getZtykzkmrtihihknsysibtkbnx7() {
        return ztykzkmrtihihknsysibtkbnx7;
    }

    public void setZtykzkmrtihihknsysibtkbnx7(String pZtykzkmrtihihknsysibtkbnx7) {
        ztykzkmrtihihknsysibtkbnx7 = pZtykzkmrtihihknsysibtkbnx7;
    }

    private String ztykazokumrtihihknsyaagex7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIHIHKNSYAAGEX7)
    public String getZtykazokumrtihihknsyaagex7() {
        return ztykazokumrtihihknsyaagex7;
    }

    public void setZtykazokumrtihihknsyaagex7(String pZtykazokumrtihihknsyaagex7) {
        ztykazokumrtihihknsyaagex7 = pZtykazokumrtihihknsyaagex7;
    }

    private Long ztykzkmrtimodsx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIMODSX7)
    public Long getZtykzkmrtimodsx7() {
        return ztykzkmrtimodsx7;
    }

    public void setZtykzkmrtimodsx7(Long pZtykzkmrtimodsx7) {
        ztykzkmrtimodsx7 = pZtykzkmrtimodsx7;
    }

    private String ztykazokumrtimodsskgnhyjx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIMODSSKGNHYJX7)
    public String getZtykazokumrtimodsskgnhyjx7() {
        return ztykazokumrtimodsskgnhyjx7;
    }

    public void setZtykazokumrtimodsskgnhyjx7(String pZtykazokumrtimodsskgnhyjx7) {
        ztykazokumrtimodsskgnhyjx7 = pZtykazokumrtimodsskgnhyjx7;
    }

    private String ztykzkmrtitnknyugukbnx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITNKNYUGUKBNX7)
    public String getZtykzkmrtitnknyugukbnx7() {
        return ztykzkmrtitnknyugukbnx7;
    }

    public void setZtykzkmrtitnknyugukbnx7(String pZtykzkmrtitnknyugukbnx7) {
        ztykzkmrtitnknyugukbnx7 = pZtykzkmrtitnknyugukbnx7;
    }

    private String ztykazokumrtikgusdkbnx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIKGUSDKBNX7)
    public String getZtykazokumrtikgusdkbnx7() {
        return ztykazokumrtikgusdkbnx7;
    }

    public void setZtykazokumrtikgusdkbnx7(String pZtykazokumrtikgusdkbnx7) {
        ztykazokumrtikgusdkbnx7 = pZtykazokumrtikgusdkbnx7;
    }

    private String ztykazokumrtiagetyusihyjx7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIAGETYUSIHYJX7)
    public String getZtykazokumrtiagetyusihyjx7() {
        return ztykazokumrtiagetyusihyjx7;
    }

    public void setZtykazokumrtiagetyusihyjx7(String pZtykazokumrtiagetyusihyjx7) {
        ztykazokumrtiagetyusihyjx7 = pZtykazokumrtiagetyusihyjx7;
    }

    private String ztykzkmrtikusnmnryoagex7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIKUSNMNRYOAGEX7)
    public String getZtykzkmrtikusnmnryoagex7() {
        return ztykzkmrtikusnmnryoagex7;
    }

    public void setZtykzkmrtikusnmnryoagex7(String pZtykzkmrtikusnmnryoagex7) {
        ztykzkmrtikusnmnryoagex7 = pZtykzkmrtikusnmnryoagex7;
    }

    private String ztyyobiv4x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X7)
    public String getZtyyobiv4x7() {
        return ztyyobiv4x7;
    }

    public void setZtyyobiv4x7(String pZtyyobiv4x7) {
        ztyyobiv4x7 = pZtyyobiv4x7;
    }

    private String ztykzkmrtitkyknox8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITKYKNOX8)
    public String getZtykzkmrtitkyknox8() {
        return ztykzkmrtitkyknox8;
    }

    public void setZtykzkmrtitkyknox8(String pZtykzkmrtitkyknox8) {
        ztykzkmrtitkyknox8 = pZtykzkmrtitkyknox8;
    }

    private String ztykazokumrtisyuruikgux8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTISYURUIKGUX8)
    public String getZtykazokumrtisyuruikgux8() {
        return ztykazokumrtisyuruikgux8;
    }

    public void setZtykazokumrtisyuruikgux8(String pZtykazokumrtisyuruikgux8) {
        ztykazokumrtisyuruikgux8 = pZtykazokumrtisyuruikgux8;
    }

    private String ztykazokumaruteikikanx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIKIKANX8)
    public String getZtykazokumaruteikikanx8() {
        return ztykazokumaruteikikanx8;
    }

    public void setZtykazokumaruteikikanx8(String pZtykazokumaruteikikanx8) {
        ztykazokumaruteikikanx8 = pZtykazokumaruteikikanx8;
    }

    private String ztykazokumrtiphrkkknx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIPHRKKKNX8)
    public String getZtykazokumrtiphrkkknx8() {
        return ztykazokumrtiphrkkknx8;
    }

    public void setZtykazokumrtiphrkkknx8(String pZtykazokumrtiphrkkknx8) {
        ztykazokumrtiphrkkknx8 = pZtykazokumrtiphrkkknx8;
    }

    private Long ztykazokumaruteisx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEISX8)
    public Long getZtykazokumaruteisx8() {
        return ztykazokumaruteisx8;
    }

    public void setZtykazokumaruteisx8(Long pZtykazokumaruteisx8) {
        ztykazokumaruteisx8 = pZtykazokumaruteisx8;
    }

    private Long ztykazokumaruteipx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIPX8)
    public Long getZtykazokumaruteipx8() {
        return ztykazokumaruteipx8;
    }

    public void setZtykazokumaruteipx8(Long pZtykazokumaruteipx8) {
        ztykazokumaruteipx8 = pZtykazokumaruteipx8;
    }

    private String ztykzkmrtihihknsyanmx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYANMX8)
    public String getZtykzkmrtihihknsyanmx8() {
        return ztykzkmrtihihknsyanmx8;
    }

    public void setZtykzkmrtihihknsyanmx8(String pZtykzkmrtihihknsyanmx8) {
        ztykzkmrtihihknsyanmx8 = pZtykzkmrtihihknsyanmx8;
    }

    private String ztykzkmrtihihknsyseiymdx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSEIYMDX8)
    public String getZtykzkmrtihihknsyseiymdx8() {
        return ztykzkmrtihihknsyseiymdx8;
    }

    public void setZtykzkmrtihihknsyseiymdx8(String pZtykzkmrtihihknsyseiymdx8) {
        ztykzkmrtihihknsyseiymdx8 = pZtykzkmrtihihknsyseiymdx8;
    }

    private String ztykzkmrtihihknsysibtkbnx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSIBTKBNX8)
    public String getZtykzkmrtihihknsysibtkbnx8() {
        return ztykzkmrtihihknsysibtkbnx8;
    }

    public void setZtykzkmrtihihknsysibtkbnx8(String pZtykzkmrtihihknsysibtkbnx8) {
        ztykzkmrtihihknsysibtkbnx8 = pZtykzkmrtihihknsysibtkbnx8;
    }

    private String ztykazokumrtihihknsyaagex8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIHIHKNSYAAGEX8)
    public String getZtykazokumrtihihknsyaagex8() {
        return ztykazokumrtihihknsyaagex8;
    }

    public void setZtykazokumrtihihknsyaagex8(String pZtykazokumrtihihknsyaagex8) {
        ztykazokumrtihihknsyaagex8 = pZtykazokumrtihihknsyaagex8;
    }

    private Long ztykzkmrtimodsx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIMODSX8)
    public Long getZtykzkmrtimodsx8() {
        return ztykzkmrtimodsx8;
    }

    public void setZtykzkmrtimodsx8(Long pZtykzkmrtimodsx8) {
        ztykzkmrtimodsx8 = pZtykzkmrtimodsx8;
    }

    private String ztykazokumrtimodsskgnhyjx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIMODSSKGNHYJX8)
    public String getZtykazokumrtimodsskgnhyjx8() {
        return ztykazokumrtimodsskgnhyjx8;
    }

    public void setZtykazokumrtimodsskgnhyjx8(String pZtykazokumrtimodsskgnhyjx8) {
        ztykazokumrtimodsskgnhyjx8 = pZtykazokumrtimodsskgnhyjx8;
    }

    private String ztykzkmrtitnknyugukbnx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITNKNYUGUKBNX8)
    public String getZtykzkmrtitnknyugukbnx8() {
        return ztykzkmrtitnknyugukbnx8;
    }

    public void setZtykzkmrtitnknyugukbnx8(String pZtykzkmrtitnknyugukbnx8) {
        ztykzkmrtitnknyugukbnx8 = pZtykzkmrtitnknyugukbnx8;
    }

    private String ztykazokumrtikgusdkbnx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIKGUSDKBNX8)
    public String getZtykazokumrtikgusdkbnx8() {
        return ztykazokumrtikgusdkbnx8;
    }

    public void setZtykazokumrtikgusdkbnx8(String pZtykazokumrtikgusdkbnx8) {
        ztykazokumrtikgusdkbnx8 = pZtykazokumrtikgusdkbnx8;
    }

    private String ztykazokumrtiagetyusihyjx8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIAGETYUSIHYJX8)
    public String getZtykazokumrtiagetyusihyjx8() {
        return ztykazokumrtiagetyusihyjx8;
    }

    public void setZtykazokumrtiagetyusihyjx8(String pZtykazokumrtiagetyusihyjx8) {
        ztykazokumrtiagetyusihyjx8 = pZtykazokumrtiagetyusihyjx8;
    }

    private String ztykzkmrtikusnmnryoagex8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIKUSNMNRYOAGEX8)
    public String getZtykzkmrtikusnmnryoagex8() {
        return ztykzkmrtikusnmnryoagex8;
    }

    public void setZtykzkmrtikusnmnryoagex8(String pZtykzkmrtikusnmnryoagex8) {
        ztykzkmrtikusnmnryoagex8 = pZtykzkmrtikusnmnryoagex8;
    }

    private String ztyyobiv4x8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X8)
    public String getZtyyobiv4x8() {
        return ztyyobiv4x8;
    }

    public void setZtyyobiv4x8(String pZtyyobiv4x8) {
        ztyyobiv4x8 = pZtyyobiv4x8;
    }

    private String ztykzkmrtitkyknox9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITKYKNOX9)
    public String getZtykzkmrtitkyknox9() {
        return ztykzkmrtitkyknox9;
    }

    public void setZtykzkmrtitkyknox9(String pZtykzkmrtitkyknox9) {
        ztykzkmrtitkyknox9 = pZtykzkmrtitkyknox9;
    }

    private String ztykazokumrtisyuruikgux9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTISYURUIKGUX9)
    public String getZtykazokumrtisyuruikgux9() {
        return ztykazokumrtisyuruikgux9;
    }

    public void setZtykazokumrtisyuruikgux9(String pZtykazokumrtisyuruikgux9) {
        ztykazokumrtisyuruikgux9 = pZtykazokumrtisyuruikgux9;
    }

    private String ztykazokumaruteikikanx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIKIKANX9)
    public String getZtykazokumaruteikikanx9() {
        return ztykazokumaruteikikanx9;
    }

    public void setZtykazokumaruteikikanx9(String pZtykazokumaruteikikanx9) {
        ztykazokumaruteikikanx9 = pZtykazokumaruteikikanx9;
    }

    private String ztykazokumrtiphrkkknx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIPHRKKKNX9)
    public String getZtykazokumrtiphrkkknx9() {
        return ztykazokumrtiphrkkknx9;
    }

    public void setZtykazokumrtiphrkkknx9(String pZtykazokumrtiphrkkknx9) {
        ztykazokumrtiphrkkknx9 = pZtykazokumrtiphrkkknx9;
    }

    private Long ztykazokumaruteisx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEISX9)
    public Long getZtykazokumaruteisx9() {
        return ztykazokumaruteisx9;
    }

    public void setZtykazokumaruteisx9(Long pZtykazokumaruteisx9) {
        ztykazokumaruteisx9 = pZtykazokumaruteisx9;
    }

    private Long ztykazokumaruteipx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIPX9)
    public Long getZtykazokumaruteipx9() {
        return ztykazokumaruteipx9;
    }

    public void setZtykazokumaruteipx9(Long pZtykazokumaruteipx9) {
        ztykazokumaruteipx9 = pZtykazokumaruteipx9;
    }

    private String ztykzkmrtihihknsyanmx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYANMX9)
    public String getZtykzkmrtihihknsyanmx9() {
        return ztykzkmrtihihknsyanmx9;
    }

    public void setZtykzkmrtihihknsyanmx9(String pZtykzkmrtihihknsyanmx9) {
        ztykzkmrtihihknsyanmx9 = pZtykzkmrtihihknsyanmx9;
    }

    private String ztykzkmrtihihknsyseiymdx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSEIYMDX9)
    public String getZtykzkmrtihihknsyseiymdx9() {
        return ztykzkmrtihihknsyseiymdx9;
    }

    public void setZtykzkmrtihihknsyseiymdx9(String pZtykzkmrtihihknsyseiymdx9) {
        ztykzkmrtihihknsyseiymdx9 = pZtykzkmrtihihknsyseiymdx9;
    }

    private String ztykzkmrtihihknsysibtkbnx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSIBTKBNX9)
    public String getZtykzkmrtihihknsysibtkbnx9() {
        return ztykzkmrtihihknsysibtkbnx9;
    }

    public void setZtykzkmrtihihknsysibtkbnx9(String pZtykzkmrtihihknsysibtkbnx9) {
        ztykzkmrtihihknsysibtkbnx9 = pZtykzkmrtihihknsysibtkbnx9;
    }

    private String ztykazokumrtihihknsyaagex9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIHIHKNSYAAGEX9)
    public String getZtykazokumrtihihknsyaagex9() {
        return ztykazokumrtihihknsyaagex9;
    }

    public void setZtykazokumrtihihknsyaagex9(String pZtykazokumrtihihknsyaagex9) {
        ztykazokumrtihihknsyaagex9 = pZtykazokumrtihihknsyaagex9;
    }

    private Long ztykzkmrtimodsx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIMODSX9)
    public Long getZtykzkmrtimodsx9() {
        return ztykzkmrtimodsx9;
    }

    public void setZtykzkmrtimodsx9(Long pZtykzkmrtimodsx9) {
        ztykzkmrtimodsx9 = pZtykzkmrtimodsx9;
    }

    private String ztykazokumrtimodsskgnhyjx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIMODSSKGNHYJX9)
    public String getZtykazokumrtimodsskgnhyjx9() {
        return ztykazokumrtimodsskgnhyjx9;
    }

    public void setZtykazokumrtimodsskgnhyjx9(String pZtykazokumrtimodsskgnhyjx9) {
        ztykazokumrtimodsskgnhyjx9 = pZtykazokumrtimodsskgnhyjx9;
    }

    private String ztykzkmrtitnknyugukbnx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITNKNYUGUKBNX9)
    public String getZtykzkmrtitnknyugukbnx9() {
        return ztykzkmrtitnknyugukbnx9;
    }

    public void setZtykzkmrtitnknyugukbnx9(String pZtykzkmrtitnknyugukbnx9) {
        ztykzkmrtitnknyugukbnx9 = pZtykzkmrtitnknyugukbnx9;
    }

    private String ztykazokumrtikgusdkbnx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIKGUSDKBNX9)
    public String getZtykazokumrtikgusdkbnx9() {
        return ztykazokumrtikgusdkbnx9;
    }

    public void setZtykazokumrtikgusdkbnx9(String pZtykazokumrtikgusdkbnx9) {
        ztykazokumrtikgusdkbnx9 = pZtykazokumrtikgusdkbnx9;
    }

    private String ztykazokumrtiagetyusihyjx9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIAGETYUSIHYJX9)
    public String getZtykazokumrtiagetyusihyjx9() {
        return ztykazokumrtiagetyusihyjx9;
    }

    public void setZtykazokumrtiagetyusihyjx9(String pZtykazokumrtiagetyusihyjx9) {
        ztykazokumrtiagetyusihyjx9 = pZtykazokumrtiagetyusihyjx9;
    }

    private String ztykzkmrtikusnmnryoagex9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIKUSNMNRYOAGEX9)
    public String getZtykzkmrtikusnmnryoagex9() {
        return ztykzkmrtikusnmnryoagex9;
    }

    public void setZtykzkmrtikusnmnryoagex9(String pZtykzkmrtikusnmnryoagex9) {
        ztykzkmrtikusnmnryoagex9 = pZtykzkmrtikusnmnryoagex9;
    }

    private String ztyyobiv4x9;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X9)
    public String getZtyyobiv4x9() {
        return ztyyobiv4x9;
    }

    public void setZtyyobiv4x9(String pZtyyobiv4x9) {
        ztyyobiv4x9 = pZtyyobiv4x9;
    }

    private String ztykzkmrtitkyknox10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITKYKNOX10)
    public String getZtykzkmrtitkyknox10() {
        return ztykzkmrtitkyknox10;
    }

    public void setZtykzkmrtitkyknox10(String pZtykzkmrtitkyknox10) {
        ztykzkmrtitkyknox10 = pZtykzkmrtitkyknox10;
    }

    private String ztykazokumrtisyuruikgux10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTISYURUIKGUX10)
    public String getZtykazokumrtisyuruikgux10() {
        return ztykazokumrtisyuruikgux10;
    }

    public void setZtykazokumrtisyuruikgux10(String pZtykazokumrtisyuruikgux10) {
        ztykazokumrtisyuruikgux10 = pZtykazokumrtisyuruikgux10;
    }

    private String ztykazokumaruteikikanx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIKIKANX10)
    public String getZtykazokumaruteikikanx10() {
        return ztykazokumaruteikikanx10;
    }

    public void setZtykazokumaruteikikanx10(String pZtykazokumaruteikikanx10) {
        ztykazokumaruteikikanx10 = pZtykazokumaruteikikanx10;
    }

    private String ztykazokumrtiphrkkknx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIPHRKKKNX10)
    public String getZtykazokumrtiphrkkknx10() {
        return ztykazokumrtiphrkkknx10;
    }

    public void setZtykazokumrtiphrkkknx10(String pZtykazokumrtiphrkkknx10) {
        ztykazokumrtiphrkkknx10 = pZtykazokumrtiphrkkknx10;
    }

    private Long ztykazokumaruteisx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEISX10)
    public Long getZtykazokumaruteisx10() {
        return ztykazokumaruteisx10;
    }

    public void setZtykazokumaruteisx10(Long pZtykazokumaruteisx10) {
        ztykazokumaruteisx10 = pZtykazokumaruteisx10;
    }

    private Long ztykazokumaruteipx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMARUTEIPX10)
    public Long getZtykazokumaruteipx10() {
        return ztykazokumaruteipx10;
    }

    public void setZtykazokumaruteipx10(Long pZtykazokumaruteipx10) {
        ztykazokumaruteipx10 = pZtykazokumaruteipx10;
    }

    private String ztykzkmrtihihknsyanmx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYANMX10)
    public String getZtykzkmrtihihknsyanmx10() {
        return ztykzkmrtihihknsyanmx10;
    }

    public void setZtykzkmrtihihknsyanmx10(String pZtykzkmrtihihknsyanmx10) {
        ztykzkmrtihihknsyanmx10 = pZtykzkmrtihihknsyanmx10;
    }

    private String ztykzkmrtihihknsyseiymdx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSEIYMDX10)
    public String getZtykzkmrtihihknsyseiymdx10() {
        return ztykzkmrtihihknsyseiymdx10;
    }

    public void setZtykzkmrtihihknsyseiymdx10(String pZtykzkmrtihihknsyseiymdx10) {
        ztykzkmrtihihknsyseiymdx10 = pZtykzkmrtihihknsyseiymdx10;
    }

    private String ztykzkmrtihihknsysibtkbnx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIHIHKNSYSIBTKBNX10)
    public String getZtykzkmrtihihknsysibtkbnx10() {
        return ztykzkmrtihihknsysibtkbnx10;
    }

    public void setZtykzkmrtihihknsysibtkbnx10(String pZtykzkmrtihihknsysibtkbnx10) {
        ztykzkmrtihihknsysibtkbnx10 = pZtykzkmrtihihknsysibtkbnx10;
    }

    private String ztykazokumrtihihknsyaagex10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIHIHKNSYAAGEX10)
    public String getZtykazokumrtihihknsyaagex10() {
        return ztykazokumrtihihknsyaagex10;
    }

    public void setZtykazokumrtihihknsyaagex10(String pZtykazokumrtihihknsyaagex10) {
        ztykazokumrtihihknsyaagex10 = pZtykazokumrtihihknsyaagex10;
    }

    private Long ztykzkmrtimodsx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIMODSX10)
    public Long getZtykzkmrtimodsx10() {
        return ztykzkmrtimodsx10;
    }

    public void setZtykzkmrtimodsx10(Long pZtykzkmrtimodsx10) {
        ztykzkmrtimodsx10 = pZtykzkmrtimodsx10;
    }

    private String ztykazokumrtimodsskgnhyjx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIMODSSKGNHYJX10)
    public String getZtykazokumrtimodsskgnhyjx10() {
        return ztykazokumrtimodsskgnhyjx10;
    }

    public void setZtykazokumrtimodsskgnhyjx10(String pZtykazokumrtimodsskgnhyjx10) {
        ztykazokumrtimodsskgnhyjx10 = pZtykazokumrtimodsskgnhyjx10;
    }

    private String ztykzkmrtitnknyugukbnx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTITNKNYUGUKBNX10)
    public String getZtykzkmrtitnknyugukbnx10() {
        return ztykzkmrtitnknyugukbnx10;
    }

    public void setZtykzkmrtitnknyugukbnx10(String pZtykzkmrtitnknyugukbnx10) {
        ztykzkmrtitnknyugukbnx10 = pZtykzkmrtitnknyugukbnx10;
    }

    private String ztykazokumrtikgusdkbnx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIKGUSDKBNX10)
    public String getZtykazokumrtikgusdkbnx10() {
        return ztykazokumrtikgusdkbnx10;
    }

    public void setZtykazokumrtikgusdkbnx10(String pZtykazokumrtikgusdkbnx10) {
        ztykazokumrtikgusdkbnx10 = pZtykazokumrtikgusdkbnx10;
    }

    private String ztykazokumrtiagetyusihyjx10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKAZOKUMRTIAGETYUSIHYJX10)
    public String getZtykazokumrtiagetyusihyjx10() {
        return ztykazokumrtiagetyusihyjx10;
    }

    public void setZtykazokumrtiagetyusihyjx10(String pZtykazokumrtiagetyusihyjx10) {
        ztykazokumrtiagetyusihyjx10 = pZtykazokumrtiagetyusihyjx10;
    }

    private String ztykzkmrtikusnmnryoagex10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTIKUSNMNRYOAGEX10)
    public String getZtykzkmrtikusnmnryoagex10() {
        return ztykzkmrtikusnmnryoagex10;
    }

    public void setZtykzkmrtikusnmnryoagex10(String pZtykzkmrtikusnmnryoagex10) {
        ztykzkmrtikusnmnryoagex10 = pZtykzkmrtikusnmnryoagex10;
    }

    private String ztyyobiv4x10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X10)
    public String getZtyyobiv4x10() {
        return ztyyobiv4x10;
    }

    public void setZtyyobiv4x10(String pZtyyobiv4x10) {
        ztyyobiv4x10 = pZtyyobiv4x10;
    }

    private String ztynkshrtkykhuhokbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNKSHRTKYKHUHOKBNX1)
    public String getZtynkshrtkykhuhokbnx1() {
        return ztynkshrtkykhuhokbnx1;
    }

    public void setZtynkshrtkykhuhokbnx1(String pZtynkshrtkykhuhokbnx1) {
        ztynkshrtkykhuhokbnx1 = pZtynkshrtkykhuhokbnx1;
    }

    private String ztynkshrtkyknksyuruikbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNKSHRTKYKNKSYURUIKBNX1)
    public String getZtynkshrtkyknksyuruikbnx1() {
        return ztynkshrtkyknksyuruikbnx1;
    }

    public void setZtynkshrtkyknksyuruikbnx1(String pZtynkshrtkyknksyuruikbnx1) {
        ztynkshrtkyknksyuruikbnx1 = pZtynkshrtkyknksyuruikbnx1;
    }

    private String ztynkshrtkyknkkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNKSHRTKYKNKKKNX1)
    public String getZtynkshrtkyknkkknx1() {
        return ztynkshrtkyknkkknx1;
    }

    public void setZtynkshrtkyknkkknx1(String pZtynkshrtkyknkkknx1) {
        ztynkshrtkyknkkknx1 = pZtynkshrtkyknkkknx1;
    }

    private Long ztynkshrtkyknknengkx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNKSHRTKYKNKNENGKX1)
    public Long getZtynkshrtkyknknengkx1() {
        return ztynkshrtkyknknengkx1;
    }

    public void setZtynkshrtkyknknengkx1(Long pZtynkshrtkyknknengkx1) {
        ztynkshrtkyknknengkx1 = pZtynkshrtkyknknengkx1;
    }

    private String ztynkshrtkykduketorihhkbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNKSHRTKYKDUKETORIHHKBNX1)
    public String getZtynkshrtkykduketorihhkbnx1() {
        return ztynkshrtkykduketorihhkbnx1;
    }

    public void setZtynkshrtkykduketorihhkbnx1(String pZtynkshrtkykduketorihhkbnx1) {
        ztynkshrtkykduketorihhkbnx1 = pZtynkshrtkykduketorihhkbnx1;
    }

    private String ztyyobiv10;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV10)
    public String getZtyyobiv10() {
        return ztyyobiv10;
    }

    public void setZtyyobiv10(String pZtyyobiv10) {
        ztyyobiv10 = pZtyyobiv10;
    }

    private String ztynkshrtkykhuhokbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNKSHRTKYKHUHOKBNX2)
    public String getZtynkshrtkykhuhokbnx2() {
        return ztynkshrtkykhuhokbnx2;
    }

    public void setZtynkshrtkykhuhokbnx2(String pZtynkshrtkykhuhokbnx2) {
        ztynkshrtkykhuhokbnx2 = pZtynkshrtkykhuhokbnx2;
    }

    private String ztynkshrtkyknksyuruikbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNKSHRTKYKNKSYURUIKBNX2)
    public String getZtynkshrtkyknksyuruikbnx2() {
        return ztynkshrtkyknksyuruikbnx2;
    }

    public void setZtynkshrtkyknksyuruikbnx2(String pZtynkshrtkyknksyuruikbnx2) {
        ztynkshrtkyknksyuruikbnx2 = pZtynkshrtkyknksyuruikbnx2;
    }

    private String ztynkshrtkyknkkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNKSHRTKYKNKKKNX2)
    public String getZtynkshrtkyknkkknx2() {
        return ztynkshrtkyknkkknx2;
    }

    public void setZtynkshrtkyknkkknx2(String pZtynkshrtkyknkkknx2) {
        ztynkshrtkyknkkknx2 = pZtynkshrtkyknkkknx2;
    }

    private Long ztynkshrtkyknknengkx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNKSHRTKYKNKNENGKX2)
    public Long getZtynkshrtkyknknengkx2() {
        return ztynkshrtkyknknengkx2;
    }

    public void setZtynkshrtkyknknengkx2(Long pZtynkshrtkyknknengkx2) {
        ztynkshrtkyknknengkx2 = pZtynkshrtkyknknengkx2;
    }

    private String ztynkshrtkykduketorihhkbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNKSHRTKYKDUKETORIHHKBNX2)
    public String getZtynkshrtkykduketorihhkbnx2() {
        return ztynkshrtkykduketorihhkbnx2;
    }

    public void setZtynkshrtkykduketorihhkbnx2(String pZtynkshrtkykduketorihhkbnx2) {
        ztynkshrtkykduketorihhkbnx2 = pZtynkshrtkykduketorihhkbnx2;
    }

    private String ztyyobiv10x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV10X2)
    public String getZtyyobiv10x2() {
        return ztyyobiv10x2;
    }

    public void setZtyyobiv10x2(String pZtyyobiv10x2) {
        ztyyobiv10x2 = pZtyyobiv10x2;
    }

    private String ztysyougaitkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOUGAITKYKSYURUIKGU)
    public String getZtysyougaitkyksyuruikgu() {
        return ztysyougaitkyksyuruikgu;
    }

    public void setZtysyougaitkyksyuruikgu(String pZtysyougaitkyksyuruikgu) {
        ztysyougaitkyksyuruikgu = pZtysyougaitkyksyuruikgu;
    }

    private String ztysyougaitokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOUGAITOKUYAKUKIKAN)
    public String getZtysyougaitokuyakukikan() {
        return ztysyougaitokuyakukikan;
    }

    public void setZtysyougaitokuyakukikan(String pZtysyougaitokuyakukikan) {
        ztysyougaitokuyakukikan = pZtysyougaitokuyakukikan;
    }

    private String ztysyougaitkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOUGAITKYKPHRKKKN)
    public String getZtysyougaitkykphrkkkn() {
        return ztysyougaitkykphrkkkn;
    }

    public void setZtysyougaitkykphrkkkn(String pZtysyougaitkykphrkkkn) {
        ztysyougaitkykphrkkkn = pZtysyougaitkykphrkkkn;
    }

    private Long ztysyougaitokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOUGAITOKUYAKUS)
    public Long getZtysyougaitokuyakus() {
        return ztysyougaitokuyakus;
    }

    public void setZtysyougaitokuyakus(Long pZtysyougaitokuyakus) {
        ztysyougaitokuyakus = pZtysyougaitokuyakus;
    }

    private Long ztysyougaitokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOUGAITOKUYAKUP)
    public Long getZtysyougaitokuyakup() {
        return ztysyougaitokuyakup;
    }

    public void setZtysyougaitokuyakup(Long pZtysyougaitokuyakup) {
        ztysyougaitokuyakup = pZtysyougaitokuyakup;
    }

    private String ztysyougaitkkatakbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOUGAITKKATAKBN)
    public String getZtysyougaitkkatakbn() {
        return ztysyougaitkkatakbn;
    }

    public void setZtysyougaitkkatakbn(String pZtysyougaitkkatakbn) {
        ztysyougaitkkatakbn = pZtysyougaitkkatakbn;
    }

    private String ztysyougaitkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOUGAITKYKKGUSDKBN)
    public String getZtysyougaitkykkgusdkbn() {
        return ztysyougaitkykkgusdkbn;
    }

    public void setZtysyougaitkykkgusdkbn(String pZtysyougaitkykkgusdkbn) {
        ztysyougaitkykkgusdkbn = pZtysyougaitkykkgusdkbn;
    }

    private String ztysyugitkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYUGITKYKPWRBKKBN)
    public String getZtysyugitkykpwrbkkbn() {
        return ztysyugitkykpwrbkkbn;
    }

    public void setZtysyugitkykpwrbkkbn(String pZtysyugitkykpwrbkkbn) {
        ztysyugitkykpwrbkkbn = pZtysyugitkykpwrbkkbn;
    }

    private String ztysyougaitkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOUGAITKYKKUSNMNRYOAGE)
    public String getZtysyougaitkykkusnmnryoage() {
        return ztysyougaitkykkusnmnryoage;
    }

    public void setZtysyougaitkykkusnmnryoage(String pZtysyougaitkykkusnmnryoage) {
        ztysyougaitkykkusnmnryoage = pZtysyougaitkykkusnmnryoage;
    }

    private String ztyyobiv5x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV5X2)
    public String getZtyyobiv5x2() {
        return ztyyobiv5x2;
    }

    public void setZtyyobiv5x2(String pZtyyobiv5x2) {
        ztyyobiv5x2 = pZtyyobiv5x2;
    }

    private String ztysigiwrmstkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIGIWRMSTKYKSYURUIKGU)
    public String getZtysigiwrmstkyksyuruikgu() {
        return ztysigiwrmstkyksyuruikgu;
    }

    public void setZtysigiwrmstkyksyuruikgu(String pZtysigiwrmstkyksyuruikgu) {
        ztysigiwrmstkyksyuruikgu = pZtysigiwrmstkyksyuruikgu;
    }

    private String ztysigiwrmstkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIGIWRMSTKYKKKN)
    public String getZtysigiwrmstkykkkn() {
        return ztysigiwrmstkykkkn;
    }

    public void setZtysigiwrmstkykkkn(String pZtysigiwrmstkykkkn) {
        ztysigiwrmstkykkkn = pZtysigiwrmstkykkkn;
    }

    private String ztysaigaiwrmstkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSAIGAIWRMSTKYKPHRKKKN)
    public String getZtysaigaiwrmstkykphrkkkn() {
        return ztysaigaiwrmstkykphrkkkn;
    }

    public void setZtysaigaiwrmstkykphrkkkn(String pZtysaigaiwrmstkykphrkkkn) {
        ztysaigaiwrmstkykphrkkkn = pZtysaigaiwrmstkykphrkkkn;
    }

    private Long ztysaigaiwarimasitokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSAIGAIWARIMASITOKUYAKUS)
    public Long getZtysaigaiwarimasitokuyakus() {
        return ztysaigaiwarimasitokuyakus;
    }

    public void setZtysaigaiwarimasitokuyakus(Long pZtysaigaiwarimasitokuyakus) {
        ztysaigaiwarimasitokuyakus = pZtysaigaiwarimasitokuyakus;
    }

    private Long ztysaigaiwarimasitokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSAIGAIWARIMASITOKUYAKUP)
    public Long getZtysaigaiwarimasitokuyakup() {
        return ztysaigaiwarimasitokuyakup;
    }

    public void setZtysaigaiwarimasitokuyakup(Long pZtysaigaiwarimasitokuyakup) {
        ztysaigaiwarimasitokuyakup = pZtysaigaiwarimasitokuyakup;
    }

    private String ztysaigaiwrmstkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSAIGAIWRMSTKYKKGUSDKBN)
    public String getZtysaigaiwrmstkykkgusdkbn() {
        return ztysaigaiwrmstkykkgusdkbn;
    }

    public void setZtysaigaiwrmstkykkgusdkbn(String pZtysaigaiwrmstkykkgusdkbn) {
        ztysaigaiwrmstkykkgusdkbn = pZtysaigaiwrmstkykkgusdkbn;
    }

    private String ztysigiwrmstkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIGIWRMSTKYKPWRBKKBN)
    public String getZtysigiwrmstkykpwrbkkbn() {
        return ztysigiwrmstkykpwrbkkbn;
    }

    public void setZtysigiwrmstkykpwrbkkbn(String pZtysigiwrmstkykpwrbkkbn) {
        ztysigiwrmstkykpwrbkkbn = pZtysigiwrmstkykpwrbkkbn;
    }

    private String ztysigiwrmstkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIGIWRMSTKYKKUSNMNRYOAGE)
    public String getZtysigiwrmstkykkusnmnryoage() {
        return ztysigiwrmstkykkusnmnryoage;
    }

    public void setZtysigiwrmstkykkusnmnryoage(String pZtysigiwrmstkykkusnmnryoage) {
        ztysigiwrmstkykkusnmnryoage = pZtysigiwrmstkykkusnmnryoage;
    }

    private String ztyyobiv5x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV5X3)
    public String getZtyyobiv5x3() {
        return ztyyobiv5x3;
    }

    public void setZtyyobiv5x3(String pZtyyobiv5x3) {
        ztyyobiv5x3 = pZtyyobiv5x3;
    }

    private String ztysiginyuintkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIGINYUINTKYKSYURUIKGU)
    public String getZtysiginyuintkyksyuruikgu() {
        return ztysiginyuintkyksyuruikgu;
    }

    public void setZtysiginyuintkyksyuruikgu(String pZtysiginyuintkyksyuruikgu) {
        ztysiginyuintkyksyuruikgu = pZtysiginyuintkyksyuruikgu;
    }

    private String ztysiginyuintkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIGINYUINTKYKKKN)
    public String getZtysiginyuintkykkkn() {
        return ztysiginyuintkykkkn;
    }

    public void setZtysiginyuintkykkkn(String pZtysiginyuintkykkkn) {
        ztysiginyuintkykkkn = pZtysiginyuintkykkkn;
    }

    private String ztysaigainyuintkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSAIGAINYUINTKYKPHRKKKN)
    public String getZtysaigainyuintkykphrkkkn() {
        return ztysaigainyuintkykphrkkkn;
    }

    public void setZtysaigainyuintkykphrkkkn(String pZtysaigainyuintkykphrkkkn) {
        ztysaigainyuintkykphrkkkn = pZtysaigainyuintkykphrkkkn;
    }

    private Integer ztysiginyuintkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIGINYUINTKYKNTGK)
    public Integer getZtysiginyuintkykntgk() {
        return ztysiginyuintkykntgk;
    }

    public void setZtysiginyuintkykntgk(Integer pZtysiginyuintkykntgk) {
        ztysiginyuintkykntgk = pZtysiginyuintkykntgk;
    }

    private String ztysiginyuintkykgtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIGINYUINTKYKGTKBN)
    public String getZtysiginyuintkykgtkbn() {
        return ztysiginyuintkykgtkbn;
    }

    public void setZtysiginyuintkykgtkbn(String pZtysiginyuintkykgtkbn) {
        ztysiginyuintkykgtkbn = pZtysiginyuintkykgtkbn;
    }

    private Long ztysaigainyuuintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSAIGAINYUUINTOKUYAKUP)
    public Long getZtysaigainyuuintokuyakup() {
        return ztysaigainyuuintokuyakup;
    }

    public void setZtysaigainyuuintokuyakup(Long pZtysaigainyuuintokuyakup) {
        ztysaigainyuuintokuyakup = pZtysaigainyuuintokuyakup;
    }

    private String ztysaigainyuintkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSAIGAINYUINTKYKKGUSDKBN)
    public String getZtysaigainyuintkykkgusdkbn() {
        return ztysaigainyuintkykkgusdkbn;
    }

    public void setZtysaigainyuintkykkgusdkbn(String pZtysaigainyuintkykkgusdkbn) {
        ztysaigainyuintkykkgusdkbn = pZtysaigainyuintkykkgusdkbn;
    }

    private String ztysiginyuintkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIGINYUINTKYKPWRBKKBN)
    public String getZtysiginyuintkykpwrbkkbn() {
        return ztysiginyuintkykpwrbkkbn;
    }

    public void setZtysiginyuintkykpwrbkkbn(String pZtysiginyuintkykpwrbkkbn) {
        ztysiginyuintkykpwrbkkbn = pZtysiginyuintkykpwrbkkbn;
    }

    private String ztyyobiv7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV7)
    public String getZtyyobiv7() {
        return ztyyobiv7;
    }

    public void setZtyyobiv7(String pZtyyobiv7) {
        ztyyobiv7 = pZtyyobiv7;
    }

    private String ztysppinyuintkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUINTKYKSYURUIKGU)
    public String getZtysppinyuintkyksyuruikgu() {
        return ztysppinyuintkyksyuruikgu;
    }

    public void setZtysppinyuintkyksyuruikgu(String pZtysppinyuintkyksyuruikgu) {
        ztysppinyuintkyksyuruikgu = pZtysppinyuintkyksyuruikgu;
    }

    private String ztysppinyuintkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUINTKYKKKN)
    public String getZtysppinyuintkykkkn() {
        return ztysppinyuintkykkkn;
    }

    public void setZtysppinyuintkykkkn(String pZtysppinyuintkykkkn) {
        ztysppinyuintkykkkn = pZtysppinyuintkykkkn;
    }

    private String ztysppinyuuintkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUUINTKYKPHRKKKN)
    public String getZtysppinyuuintkykphrkkkn() {
        return ztysppinyuuintkykphrkkkn;
    }

    public void setZtysppinyuuintkykphrkkkn(String pZtysppinyuuintkykphrkkkn) {
        ztysppinyuuintkykphrkkkn = pZtysppinyuuintkykphrkkkn;
    }

    private Integer ztysppinyuintkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUINTKYKNTGK)
    public Integer getZtysppinyuintkykntgk() {
        return ztysppinyuintkykntgk;
    }

    public void setZtysppinyuintkykntgk(Integer pZtysppinyuintkykntgk) {
        ztysppinyuintkykntgk = pZtysppinyuintkykntgk;
    }

    private String ztysppinyuintkykgtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUINTKYKGTKBN)
    public String getZtysppinyuintkykgtkbn() {
        return ztysppinyuintkykgtkbn;
    }

    public void setZtysppinyuintkykgtkbn(String pZtysppinyuintkykgtkbn) {
        ztysppinyuintkykgtkbn = pZtysppinyuintkykgtkbn;
    }

    private Long ztysippeinyuuintokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIPPEINYUUINTOKUYAKUP)
    public Long getZtysippeinyuuintokuyakup() {
        return ztysippeinyuuintokuyakup;
    }

    public void setZtysippeinyuuintokuyakup(Long pZtysippeinyuuintokuyakup) {
        ztysippeinyuuintokuyakup = pZtysippeinyuuintokuyakup;
    }

    private Integer ztysppinyuintkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUINTKJYURYUMSHYUTN)
    public Integer getZtysppinyuintkjyuryumshyutn() {
        return ztysppinyuintkjyuryumshyutn;
    }

    public void setZtysppinyuintkjyuryumshyutn(Integer pZtysppinyuintkjyuryumshyutn) {
        ztysppinyuintkjyuryumshyutn = pZtysppinyuintkjyuryumshyutn;
    }

    private Long ztysippeinyuuintokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIPPEINYUUINTOKUJYOUP)
    public Long getZtysippeinyuuintokujyoup() {
        return ztysippeinyuuintokujyoup;
    }

    public void setZtysippeinyuuintokujyoup(Long pZtysippeinyuuintokujyoup) {
        ztysippeinyuuintokujyoup = pZtysippeinyuuintokujyoup;
    }

    private String ztysppinyuintktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUINTKTBICDX1)
    public String getZtysppinyuintktbicdx1() {
        return ztysppinyuintktbicdx1;
    }

    public void setZtysppinyuintktbicdx1(String pZtysppinyuintktbicdx1) {
        ztysppinyuintktbicdx1 = pZtysppinyuintktbicdx1;
    }

    private String ztysppinyuinhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUINHTNPKKNX1)
    public String getZtysppinyuinhtnpkknx1() {
        return ztysppinyuinhtnpkknx1;
    }

    public void setZtysppinyuinhtnpkknx1(String pZtysppinyuinhtnpkknx1) {
        ztysppinyuinhtnpkknx1 = pZtysppinyuinhtnpkknx1;
    }

    private String ztysppinyuintktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUINTKTBICDX2)
    public String getZtysppinyuintktbicdx2() {
        return ztysppinyuintktbicdx2;
    }

    public void setZtysppinyuintktbicdx2(String pZtysppinyuintktbicdx2) {
        ztysppinyuintktbicdx2 = pZtysppinyuintktbicdx2;
    }

    private String ztysppinyuinhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUINHTNPKKNX2)
    public String getZtysppinyuinhtnpkknx2() {
        return ztysppinyuinhtnpkknx2;
    }

    public void setZtysppinyuinhtnpkknx2(String pZtysppinyuinhtnpkknx2) {
        ztysppinyuinhtnpkknx2 = pZtysppinyuinhtnpkknx2;
    }

    private String ztysppinyuuintkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUUINTKYKKGUSDKBN)
    public String getZtysppinyuuintkykkgusdkbn() {
        return ztysppinyuuintkykkgusdkbn;
    }

    public void setZtysppinyuuintkykkgusdkbn(String pZtysppinyuuintkykkgusdkbn) {
        ztysppinyuuintkykkgusdkbn = pZtysppinyuuintkykkgusdkbn;
    }

    private String ztysppinyuintkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSPPINYUINTKYKPWRBKKBN)
    public String getZtysppinyuintkykpwrbkkbn() {
        return ztysppinyuintkykpwrbkkbn;
    }

    public void setZtysppinyuintkykpwrbkkbn(String pZtysppinyuintkykpwrbkkbn) {
        ztysppinyuintkykpwrbkkbn = pZtysppinyuintkykpwrbkkbn;
    }

    private String ztyyobiv7x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV7X2)
    public String getZtyyobiv7x2() {
        return ztyyobiv7x2;
    }

    public void setZtyyobiv7x2(String pZtyyobiv7x2) {
        ztyyobiv7x2 = pZtyyobiv7x2;
    }

    private String ztysijnbyutkyksyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIJNBYUTKYKSYURUIKGU)
    public String getZtysijnbyutkyksyuruikgu() {
        return ztysijnbyutkyksyuruikgu;
    }

    public void setZtysijnbyutkyksyuruikgu(String pZtysijnbyutkyksyuruikgu) {
        ztysijnbyutkyksyuruikgu = pZtysijnbyutkyksyuruikgu;
    }

    private String ztyseijinbyoutokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIJINBYOUTOKUYAKUKIKAN)
    public String getZtyseijinbyoutokuyakukikan() {
        return ztyseijinbyoutokuyakukikan;
    }

    public void setZtyseijinbyoutokuyakukikan(String pZtyseijinbyoutokuyakukikan) {
        ztyseijinbyoutokuyakukikan = pZtyseijinbyoutokuyakukikan;
    }

    private String ztyseijinbyoutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIJINBYOUTKYKPHRKKKN)
    public String getZtyseijinbyoutkykphrkkkn() {
        return ztyseijinbyoutkykphrkkkn;
    }

    public void setZtyseijinbyoutkykphrkkkn(String pZtyseijinbyoutkykphrkkkn) {
        ztyseijinbyoutkykphrkkkn = pZtyseijinbyoutkykphrkkkn;
    }

    private Integer ztyseijinbyoutokuyakuntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIJINBYOUTOKUYAKUNTGK)
    public Integer getZtyseijinbyoutokuyakuntgk() {
        return ztyseijinbyoutokuyakuntgk;
    }

    public void setZtyseijinbyoutokuyakuntgk(Integer pZtyseijinbyoutokuyakuntgk) {
        ztyseijinbyoutokuyakuntgk = pZtyseijinbyoutokuyakuntgk;
    }

    private Long ztyseijinbyoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIJINBYOUTOKUYAKUP)
    public Long getZtyseijinbyoutokuyakup() {
        return ztyseijinbyoutokuyakup;
    }

    public void setZtyseijinbyoutokuyakup(Long pZtyseijinbyoutokuyakup) {
        ztyseijinbyoutokuyakup = pZtyseijinbyoutokuyakup;
    }

    private Integer ztysijnbyutkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIJNBYUTKJYURYUMSHYUTN)
    public Integer getZtysijnbyutkjyuryumshyutn() {
        return ztysijnbyutkjyuryumshyutn;
    }

    public void setZtysijnbyutkjyuryumshyutn(Integer pZtysijnbyutkjyuryumshyutn) {
        ztysijnbyutkjyuryumshyutn = pZtysijnbyutkjyuryumshyutn;
    }

    private Long ztyseijinbyoutokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIJINBYOUTOKUJYOUP)
    public Long getZtyseijinbyoutokujyoup() {
        return ztyseijinbyoutokujyoup;
    }

    public void setZtyseijinbyoutokujyoup(Long pZtyseijinbyoutokujyoup) {
        ztyseijinbyoutokujyoup = pZtyseijinbyoutokujyoup;
    }

    private String ztyseijinbyoutokuteibuicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIJINBYOUTOKUTEIBUICDX1)
    public String getZtyseijinbyoutokuteibuicdx1() {
        return ztyseijinbyoutokuteibuicdx1;
    }

    public void setZtyseijinbyoutokuteibuicdx1(String pZtyseijinbyoutokuteibuicdx1) {
        ztyseijinbyoutokuteibuicdx1 = pZtyseijinbyoutokuteibuicdx1;
    }

    private String ztyseijinbyouhutanpokikanx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIJINBYOUHUTANPOKIKANX1)
    public String getZtyseijinbyouhutanpokikanx1() {
        return ztyseijinbyouhutanpokikanx1;
    }

    public void setZtyseijinbyouhutanpokikanx1(String pZtyseijinbyouhutanpokikanx1) {
        ztyseijinbyouhutanpokikanx1 = pZtyseijinbyouhutanpokikanx1;
    }

    private String ztyseijinbyoutokuteibuicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIJINBYOUTOKUTEIBUICDX2)
    public String getZtyseijinbyoutokuteibuicdx2() {
        return ztyseijinbyoutokuteibuicdx2;
    }

    public void setZtyseijinbyoutokuteibuicdx2(String pZtyseijinbyoutokuteibuicdx2) {
        ztyseijinbyoutokuteibuicdx2 = pZtyseijinbyoutokuteibuicdx2;
    }

    private String ztyseijinbyouhutanpokikanx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIJINBYOUHUTANPOKIKANX2)
    public String getZtyseijinbyouhutanpokikanx2() {
        return ztyseijinbyouhutanpokikanx2;
    }

    public void setZtyseijinbyouhutanpokikanx2(String pZtyseijinbyouhutanpokikanx2) {
        ztyseijinbyouhutanpokikanx2 = pZtyseijinbyouhutanpokikanx2;
    }

    private String ztyseijinbyoutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIJINBYOUTKYKKGUSDKBN)
    public String getZtyseijinbyoutkykkgusdkbn() {
        return ztyseijinbyoutkykkgusdkbn;
    }

    public void setZtyseijinbyoutkykkgusdkbn(String pZtyseijinbyoutkykkgusdkbn) {
        ztyseijinbyoutkykkgusdkbn = pZtyseijinbyoutkykkgusdkbn;
    }

    private String ztysijnbyutkykgankyuhgtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIJNBYUTKYKGANKYUHGTKBN)
    public String getZtysijnbyutkykgankyuhgtkbn() {
        return ztysijnbyutkykgankyuhgtkbn;
    }

    public void setZtysijnbyutkykgankyuhgtkbn(String pZtysijnbyutkykgankyuhgtkbn) {
        ztysijnbyutkykgankyuhgtkbn = pZtysijnbyutkykgankyuhgtkbn;
    }

    private String ztysijnbyutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIJNBYUTKYKPWRBKKBN)
    public String getZtysijnbyutkykpwrbkkbn() {
        return ztysijnbyutkykpwrbkkbn;
    }

    public void setZtysijnbyutkykpwrbkkbn(String pZtysijnbyutkykpwrbkkbn) {
        ztysijnbyutkykpwrbkkbn = pZtysijnbyutkykpwrbkkbn;
    }

    private String ztysijnbyutkykkusnmnryoage;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIJNBYUTKYKKUSNMNRYOAGE)
    public String getZtysijnbyutkykkusnmnryoage() {
        return ztysijnbyutkykkusnmnryoage;
    }

    public void setZtysijnbyutkykkusnmnryoage(String pZtysijnbyutkykkusnmnryoage) {
        ztysijnbyutkykkusnmnryoage = pZtysijnbyutkykkusnmnryoage;
    }

    private String ztyyobiv4x11;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV4X11)
    public String getZtyyobiv4x11() {
        return ztyyobiv4x11;
    }

    public void setZtyyobiv4x11(String pZtyyobiv4x11) {
        ztyyobiv4x11 = pZtyyobiv4x11;
    }

    private String ztyheiyoubaraikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHEIYOUBARAIKBN)
    public String getZtyheiyoubaraikbn() {
        return ztyheiyoubaraikbn;
    }

    public void setZtyheiyoubaraikbn(String pZtyheiyoubaraikbn) {
        ztyheiyoubaraikbn = pZtyheiyoubaraikbn;
    }

    private String ztyhiyubriaitsyono;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIYUBRIAITSYONO)
    public String getZtyhiyubriaitsyono() {
        return ztyhiyubriaitsyono;
    }

    public void setZtyhiyubriaitsyono(String pZtyhiyubriaitsyono) {
        ztyhiyubriaitsyono = pZtyhiyubriaitsyono;
    }

    private String ztyhiyubriaithrkkeirokbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIYUBRIAITHRKKEIROKBN)
    public String getZtyhiyubriaithrkkeirokbn() {
        return ztyhiyubriaithrkkeirokbn;
    }

    public void setZtyhiyubriaithrkkeirokbn(String pZtyhiyubriaithrkkeirokbn) {
        ztyhiyubriaithrkkeirokbn = pZtyhiyubriaithrkkeirokbn;
    }

    private Long ztyheiyoubaraiaitekihons;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHEIYOUBARAIAITEKIHONS)
    public Long getZtyheiyoubaraiaitekihons() {
        return ztyheiyoubaraiaitekihons;
    }

    public void setZtyheiyoubaraiaitekihons(Long pZtyheiyoubaraiaitekihons) {
        ztyheiyoubaraiaitekihons = pZtyheiyoubaraiaitekihons;
    }

    private Long ztyhiyubrigukitnknitjbrkhns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIYUBRIGUKITNKNITJBRKHNS)
    public Long getZtyhiyubrigukitnknitjbrkhns() {
        return ztyhiyubrigukitnknitjbrkhns;
    }

    public void setZtyhiyubrigukitnknitjbrkhns(Long pZtyhiyubrigukitnknitjbrkhns) {
        ztyhiyubrigukitnknitjbrkhns = pZtyhiyubrigukitnknitjbrkhns;
    }

    private Long ztyheiyoubaraiaitesibous;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHEIYOUBARAIAITESIBOUS)
    public Long getZtyheiyoubaraiaitesibous() {
        return ztyheiyoubaraiaitesibous;
    }

    public void setZtyheiyoubaraiaitesibous(Long pZtyheiyoubaraiaitesibous) {
        ztyheiyoubaraiaitesibous = pZtyheiyoubaraiaitesibous;
    }

    private Long ztyhiyubrigukitnknitjbrsbus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIYUBRIGUKITNKNITJBRSBUS)
    public Long getZtyhiyubrigukitnknitjbrsbus() {
        return ztyhiyubrigukitnknitjbrsbus;
    }

    public void setZtyhiyubrigukitnknitjbrsbus(Long pZtyhiyubrigukitnknitjbrsbus) {
        ztyhiyubrigukitnknitjbrsbus = pZtyhiyubrigukitnknitjbrsbus;
    }

    private Long ztyheiyoubaraiaitesyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHEIYOUBARAIAITESYUUSEIS)
    public Long getZtyheiyoubaraiaitesyuuseis() {
        return ztyheiyoubaraiaitesyuuseis;
    }

    public void setZtyheiyoubaraiaitesyuuseis(Long pZtyheiyoubaraiaitesyuuseis) {
        ztyheiyoubaraiaitesyuuseis = pZtyheiyoubaraiaitesyuuseis;
    }

    private Long ztyheiyoubaraiaitehrkp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHEIYOUBARAIAITEHRKP)
    public Long getZtyheiyoubaraiaitehrkp() {
        return ztyheiyoubaraiaitehrkp;
    }

    public void setZtyheiyoubaraiaitehrkp(Long pZtyheiyoubaraiaitehrkp) {
        ztyheiyoubaraiaitehrkp = pZtyheiyoubaraiaitehrkp;
    }

    private Long ztyhiyubriaitsykykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIYUBRIAITSYKYKP)
    public Long getZtyhiyubriaitsykykp() {
        return ztyhiyubriaitsykykp;
    }

    public void setZtyhiyubriaitsykykp(Long pZtyhiyubriaitsykykp) {
        ztyhiyubriaitsykykp = pZtyhiyubriaitsykykp;
    }

    private Long ztyheiyoubaraiaitemrtis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHEIYOUBARAIAITEMRTIS)
    public Long getZtyheiyoubaraiaitemrtis() {
        return ztyheiyoubaraiaitemrtis;
    }

    public void setZtyheiyoubaraiaitemrtis(Long pZtyheiyoubaraiaitemrtis) {
        ztyheiyoubaraiaitemrtis = pZtyheiyoubaraiaitemrtis;
    }

    private Long ztyhiyubrigukiaitkzkmrtis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIYUBRIGUKIAITKZKMRTIS)
    public Long getZtyhiyubrigukiaitkzkmrtis() {
        return ztyhiyubrigukiaitkzkmrtis;
    }

    public void setZtyhiyubrigukiaitkzkmrtis(Long pZtyhiyubrigukiaitkzkmrtis) {
        ztyhiyubrigukiaitkzkmrtis = pZtyhiyubrigukiaitkzkmrtis;
    }

    private String ztytukibaraikyktenkanhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTUKIBARAIKYKTENKANHYJ)
    public String getZtytukibaraikyktenkanhyj() {
        return ztytukibaraikyktenkanhyj;
    }

    public void setZtytukibaraikyktenkanhyj(String pZtytukibaraikyktenkanhyj) {
        ztytukibaraikyktenkanhyj = pZtytukibaraikyktenkanhyj;
    }

    private String ztybonusharaihrkkigetu1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYBONUSHARAIHRKKIGETU1)
    public String getZtybonusharaihrkkigetu1() {
        return ztybonusharaihrkkigetu1;
    }

    public void setZtybonusharaihrkkigetu1(String pZtybonusharaihrkkigetu1) {
        ztybonusharaihrkkigetu1 = pZtybonusharaihrkkigetu1;
    }

    private String ztybonusharaihrkkigetu2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYBONUSHARAIHRKKIGETU2)
    public String getZtybonusharaihrkkigetu2() {
        return ztybonusharaihrkkigetu2;
    }

    public void setZtybonusharaihrkkigetu2(String pZtybonusharaihrkkigetu2) {
        ztybonusharaihrkkigetu2 = pZtybonusharaihrkkigetu2;
    }

    private Long ztyhiyubriaitsiznmrtis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIYUBRIAITSIZNMRTIS)
    public Long getZtyhiyubriaitsiznmrtis() {
        return ztyhiyubriaitsiznmrtis;
    }

    public void setZtyhiyubriaitsiznmrtis(Long pZtyhiyubriaitsiznmrtis) {
        ztyhiyubriaitsiznmrtis = pZtyhiyubriaitsiznmrtis;
    }

    private Long ztyhiyubriaittignmrtis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHIYUBRIAITTIGNMRTIS)
    public Long getZtyhiyubriaittignmrtis() {
        return ztyhiyubriaittignmrtis;
    }

    public void setZtyhiyubriaittignmrtis(Long pZtyhiyubriaittignmrtis) {
        ztyhiyubriaittignmrtis = pZtyhiyubriaittignmrtis;
    }

    private String ztytkjykbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTKJYKBN)
    public String getZtytkjykbn() {
        return ztytkjykbn;
    }

    public void setZtytkjykbn(String pZtytkjykbn) {
        ztytkjykbn = pZtytkjykbn;
    }

    private String ztysakugenkikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSAKUGENKIKAN)
    public String getZtysakugenkikan() {
        return ztysakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysakugenkikan(String pZtysakugenkikan) {
        ztysakugenkikan = pZtysakugenkikan;
    }

    private Integer ztyryoumasihyouten;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYRYOUMASIHYOUTEN)
    public Integer getZtyryoumasihyouten() {
        return ztyryoumasihyouten;
    }

    public void setZtyryoumasihyouten(Integer pZtyryoumasihyouten) {
        ztyryoumasihyouten = pZtyryoumasihyouten;
    }

    private Long ztytokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTOKUJYOUP)
    public Long getZtytokujyoup() {
        return ztytokujyoup;
    }

    public void setZtytokujyoup(Long pZtytokujyoup) {
        ztytokujyoup = pZtytokujyoup;
    }

    private String ztyhjncd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHJNCD)
    public String getZtyhjncd() {
        return ztyhjncd;
    }

    public void setZtyhjncd(String pZtyhjncd) {
        ztyhjncd = pZtyhjncd;
    }

    private String ztyhjnjigyosyocd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHJNJIGYOSYOCD)
    public String getZtyhjnjigyosyocd() {
        return ztyhjnjigyosyocd;
    }

    public void setZtyhjnjigyosyocd(String pZtyhjnjigyosyocd) {
        ztyhjnjigyosyocd = pZtyhjnjigyosyocd;
    }

    private Integer ztyjyuugyouinsuu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYJYUUGYOUINSUU)
    public Integer getZtyjyuugyouinsuu() {
        return ztyjyuugyouinsuu;
    }

    public void setZtyjyuugyouinsuu(Integer pZtyjyuugyouinsuu) {
        ztyjyuugyouinsuu = pZtyjyuugyouinsuu;
    }

    private String ztyiktkaisuu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYIKTKAISUU)
    public String getZtyiktkaisuu() {
        return ztyiktkaisuu;
    }

    public void setZtyiktkaisuu(String pZtyiktkaisuu) {
        ztyiktkaisuu = pZtyiktkaisuu;
    }

    private String ztyznnkai;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYZNNKAI)
    public String getZtyznnkai() {
        return ztyznnkai;
    }

    public void setZtyznnkai(String pZtyznnkai) {
        ztyznnkai = pZtyznnkai;
    }

    private String ztykyktsnatkitkykkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKYKTSNATKITKYKKBN)
    public String getZtykyktsnatkitkykkbn() {
        return ztykyktsnatkitkykkbn;
    }

    public void setZtykyktsnatkitkykkbn(String pZtykyktsnatkitkykkbn) {
        ztykyktsnatkitkykkbn = pZtykyktsnatkitkykkbn;
    }

    private String ztykyktsnatkitkykstagekbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKYKTSNATKITKYKSTAGEKBN)
    public String getZtykyktsnatkitkykstagekbn() {
        return ztykyktsnatkitkykstagekbn;
    }

    public void setZtykyktsnatkitkykstagekbn(String pZtykyktsnatkitkykstagekbn) {
        ztykyktsnatkitkykstagekbn = pZtykyktsnatkitkykstagekbn;
    }

    private String ztypmentokuyakukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYPMENTOKUYAKUKBN)
    public String getZtypmentokuyakukbn() {
        return ztypmentokuyakukbn;
    }

    public void setZtypmentokuyakukbn(String pZtypmentokuyakukbn) {
        ztypmentokuyakukbn = pZtypmentokuyakukbn;
    }

    private String ztyyobiv3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV3)
    public String getZtyyobiv3() {
        return ztyyobiv3;
    }

    public void setZtyyobiv3(String pZtyyobiv3) {
        ztyyobiv3 = pZtyyobiv3;
    }

    private Long ztytkykznnunyukngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTKYKZNNUNYUKNGK)
    public Long getZtytkykznnunyukngk() {
        return ztytkykznnunyukngk;
    }

    public void setZtytkykznnunyukngk(Long pZtytkykznnunyukngk) {
        ztytkykznnunyukngk = pZtytkykznnunyukngk;
    }

    private String ztysyokaipnyuukinhouhoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOKAIPNYUUKINHOUHOUKBN)
    public String getZtysyokaipnyuukinhouhoukbn() {
        return ztysyokaipnyuukinhouhoukbn;
    }

    public void setZtysyokaipnyuukinhouhoukbn(String pZtysyokaipnyuukinhouhoukbn) {
        ztysyokaipnyuukinhouhoukbn = pZtysyokaipnyuukinhouhoukbn;
    }

    private String ztyhtnknkyksyonox1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSYONOX1)
    public String getZtyhtnknkyksyonox1() {
        return ztyhtnknkyksyonox1;
    }

    public void setZtyhtnknkyksyonox1(String pZtyhtnknkyksyonox1) {
        ztyhtnknkyksyonox1 = pZtyhtnknkyksyonox1;
    }

    private String ztyhtnknkykhknsyuruikgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNSYURUIKGUX1)
    public String getZtyhtnknkykhknsyuruikgux1() {
        return ztyhtnknkykhknsyuruikgux1;
    }

    public void setZtyhtnknkykhknsyuruikgux1(String pZtyhtnknkykhknsyuruikgux1) {
        ztyhtnknkykhknsyuruikgux1 = pZtyhtnknkykhknsyuruikgux1;
    }

    private String ztytenkanuketukeymdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTENKANUKETUKEYMDX1)
    public String getZtytenkanuketukeymdx1() {
        return ztytenkanuketukeymdx1;
    }

    public void setZtytenkanuketukeymdx1(String pZtytenkanuketukeymdx1) {
        ztytenkanuketukeymdx1 = pZtytenkanuketukeymdx1;
    }

    private String ztyhtnknkykkykymdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKKYKYMDX1)
    public String getZtyhtnknkykkykymdx1() {
        return ztyhtnknkykkykymdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhtnknkykkykymdx1(String pZtyhtnknkykkykymdx1) {
        ztyhtnknkykkykymdx1 = pZtyhtnknkykkykymdx1;
    }

    private String ztyhtnknkykhknkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNKKNX1)
    public String getZtyhtnknkykhknkknx1() {
        return ztyhtnknkykhknkknx1;
    }

    public void setZtyhtnknkykhknkknx1(String pZtyhtnknkykhknkknx1) {
        ztyhtnknkykhknkknx1 = pZtyhtnknkykhknkknx1;
    }

    private String ztyhtnknkykphrkkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKPHRKKKNX1)
    public String getZtyhtnknkykphrkkknx1() {
        return ztyhtnknkykphrkkknx1;
    }

    public void setZtyhtnknkykphrkkknx1(String pZtyhtnknkykphrkkknx1) {
        ztyhtnknkykphrkkknx1 = pZtyhtnknkykphrkkknx1;
    }

    private String ztyhtnknkykhrkkaisuukbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKAISUUKBNX1)
    public String getZtyhtnknkykhrkkaisuukbnx1() {
        return ztyhtnknkykhrkkaisuukbnx1;
    }

    public void setZtyhtnknkykhrkkaisuukbnx1(String pZtyhtnknkykhrkkaisuukbnx1) {
        ztyhtnknkykhrkkaisuukbnx1 = pZtyhtnknkykhrkkaisuukbnx1;
    }

    private String ztyhtnknkykhrkkeirokbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKEIROKBNX1)
    public String getZtyhtnknkykhrkkeirokbnx1() {
        return ztyhtnknkykhrkkeirokbnx1;
    }

    public void setZtyhtnknkykhrkkeirokbnx1(String pZtyhtnknkykhrkkeirokbnx1) {
        ztyhtnknkykhrkkeirokbnx1 = pZtyhtnknkykhrkkeirokbnx1;
    }

    private String ztytnknuktkzngtkijyuhyjx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTNKNUKTKZNGTKIJYUHYJX1)
    public String getZtytnknuktkzngtkijyuhyjx1() {
        return ztytnknuktkzngtkijyuhyjx1;
    }

    public void setZtytnknuktkzngtkijyuhyjx1(String pZtytnknuktkzngtkijyuhyjx1) {
        ztytnknuktkzngtkijyuhyjx1 = pZtytnknuktkzngtkijyuhyjx1;
    }

    private String ztyhtnknkykmrtisyuruikgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKMRTISYURUIKGUX1)
    public String getZtyhtnknkykmrtisyuruikgux1() {
        return ztyhtnknkykmrtisyuruikgux1;
    }

    public void setZtyhtnknkykmrtisyuruikgux1(String pZtyhtnknkykmrtisyuruikgux1) {
        ztyhtnknkykmrtisyuruikgux1 = pZtyhtnknkykmrtisyuruikgux1;
    }

    private String ztyhtnknkyksyonox2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSYONOX2)
    public String getZtyhtnknkyksyonox2() {
        return ztyhtnknkyksyonox2;
    }

    public void setZtyhtnknkyksyonox2(String pZtyhtnknkyksyonox2) {
        ztyhtnknkyksyonox2 = pZtyhtnknkyksyonox2;
    }

    private String ztyhtnknkykhknsyuruikgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNSYURUIKGUX2)
    public String getZtyhtnknkykhknsyuruikgux2() {
        return ztyhtnknkykhknsyuruikgux2;
    }

    public void setZtyhtnknkykhknsyuruikgux2(String pZtyhtnknkykhknsyuruikgux2) {
        ztyhtnknkykhknsyuruikgux2 = pZtyhtnknkykhknsyuruikgux2;
    }

    private String ztytenkanuketukeymdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTENKANUKETUKEYMDX2)
    public String getZtytenkanuketukeymdx2() {
        return ztytenkanuketukeymdx2;
    }

    public void setZtytenkanuketukeymdx2(String pZtytenkanuketukeymdx2) {
        ztytenkanuketukeymdx2 = pZtytenkanuketukeymdx2;
    }

    private String ztyhtnknkykkykymdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKKYKYMDX2)
    public String getZtyhtnknkykkykymdx2() {
        return ztyhtnknkykkykymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhtnknkykkykymdx2(String pZtyhtnknkykkykymdx2) {
        ztyhtnknkykkykymdx2 = pZtyhtnknkykkykymdx2;
    }

    private String ztyhtnknkykhknkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNKKNX2)
    public String getZtyhtnknkykhknkknx2() {
        return ztyhtnknkykhknkknx2;
    }

    public void setZtyhtnknkykhknkknx2(String pZtyhtnknkykhknkknx2) {
        ztyhtnknkykhknkknx2 = pZtyhtnknkykhknkknx2;
    }

    private String ztyhtnknkykphrkkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKPHRKKKNX2)
    public String getZtyhtnknkykphrkkknx2() {
        return ztyhtnknkykphrkkknx2;
    }

    public void setZtyhtnknkykphrkkknx2(String pZtyhtnknkykphrkkknx2) {
        ztyhtnknkykphrkkknx2 = pZtyhtnknkykphrkkknx2;
    }

    private String ztyhtnknkykhrkkaisuukbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKAISUUKBNX2)
    public String getZtyhtnknkykhrkkaisuukbnx2() {
        return ztyhtnknkykhrkkaisuukbnx2;
    }

    public void setZtyhtnknkykhrkkaisuukbnx2(String pZtyhtnknkykhrkkaisuukbnx2) {
        ztyhtnknkykhrkkaisuukbnx2 = pZtyhtnknkykhrkkaisuukbnx2;
    }

    private String ztyhtnknkykhrkkeirokbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKEIROKBNX2)
    public String getZtyhtnknkykhrkkeirokbnx2() {
        return ztyhtnknkykhrkkeirokbnx2;
    }

    public void setZtyhtnknkykhrkkeirokbnx2(String pZtyhtnknkykhrkkeirokbnx2) {
        ztyhtnknkykhrkkeirokbnx2 = pZtyhtnknkykhrkkeirokbnx2;
    }

    private String ztytnknuktkzngtkijyuhyjx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTNKNUKTKZNGTKIJYUHYJX2)
    public String getZtytnknuktkzngtkijyuhyjx2() {
        return ztytnknuktkzngtkijyuhyjx2;
    }

    public void setZtytnknuktkzngtkijyuhyjx2(String pZtytnknuktkzngtkijyuhyjx2) {
        ztytnknuktkzngtkijyuhyjx2 = pZtytnknuktkzngtkijyuhyjx2;
    }

    private String ztyhtnknkykmrtisyuruikgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKMRTISYURUIKGUX2)
    public String getZtyhtnknkykmrtisyuruikgux2() {
        return ztyhtnknkykmrtisyuruikgux2;
    }

    public void setZtyhtnknkykmrtisyuruikgux2(String pZtyhtnknkykmrtisyuruikgux2) {
        ztyhtnknkykmrtisyuruikgux2 = pZtyhtnknkykmrtisyuruikgux2;
    }

    private String ztyhtnknkyksyonox3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSYONOX3)
    public String getZtyhtnknkyksyonox3() {
        return ztyhtnknkyksyonox3;
    }

    public void setZtyhtnknkyksyonox3(String pZtyhtnknkyksyonox3) {
        ztyhtnknkyksyonox3 = pZtyhtnknkyksyonox3;
    }

    private String ztyhtnknkykhknsyuruikgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNSYURUIKGUX3)
    public String getZtyhtnknkykhknsyuruikgux3() {
        return ztyhtnknkykhknsyuruikgux3;
    }

    public void setZtyhtnknkykhknsyuruikgux3(String pZtyhtnknkykhknsyuruikgux3) {
        ztyhtnknkykhknsyuruikgux3 = pZtyhtnknkykhknsyuruikgux3;
    }

    private String ztytenkanuketukeymdx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTENKANUKETUKEYMDX3)
    public String getZtytenkanuketukeymdx3() {
        return ztytenkanuketukeymdx3;
    }

    public void setZtytenkanuketukeymdx3(String pZtytenkanuketukeymdx3) {
        ztytenkanuketukeymdx3 = pZtytenkanuketukeymdx3;
    }

    private String ztyhtnknkykkykymdx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKKYKYMDX3)
    public String getZtyhtnknkykkykymdx3() {
        return ztyhtnknkykkykymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhtnknkykkykymdx3(String pZtyhtnknkykkykymdx3) {
        ztyhtnknkykkykymdx3 = pZtyhtnknkykkykymdx3;
    }

    private String ztyhtnknkykhknkknx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNKKNX3)
    public String getZtyhtnknkykhknkknx3() {
        return ztyhtnknkykhknkknx3;
    }

    public void setZtyhtnknkykhknkknx3(String pZtyhtnknkykhknkknx3) {
        ztyhtnknkykhknkknx3 = pZtyhtnknkykhknkknx3;
    }

    private String ztyhtnknkykphrkkknx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKPHRKKKNX3)
    public String getZtyhtnknkykphrkkknx3() {
        return ztyhtnknkykphrkkknx3;
    }

    public void setZtyhtnknkykphrkkknx3(String pZtyhtnknkykphrkkknx3) {
        ztyhtnknkykphrkkknx3 = pZtyhtnknkykphrkkknx3;
    }

    private String ztyhtnknkykhrkkaisuukbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKAISUUKBNX3)
    public String getZtyhtnknkykhrkkaisuukbnx3() {
        return ztyhtnknkykhrkkaisuukbnx3;
    }

    public void setZtyhtnknkykhrkkaisuukbnx3(String pZtyhtnknkykhrkkaisuukbnx3) {
        ztyhtnknkykhrkkaisuukbnx3 = pZtyhtnknkykhrkkaisuukbnx3;
    }

    private String ztyhtnknkykhrkkeirokbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKEIROKBNX3)
    public String getZtyhtnknkykhrkkeirokbnx3() {
        return ztyhtnknkykhrkkeirokbnx3;
    }

    public void setZtyhtnknkykhrkkeirokbnx3(String pZtyhtnknkykhrkkeirokbnx3) {
        ztyhtnknkykhrkkeirokbnx3 = pZtyhtnknkykhrkkeirokbnx3;
    }

    private String ztytnknuktkzngtkijyuhyjx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTNKNUKTKZNGTKIJYUHYJX3)
    public String getZtytnknuktkzngtkijyuhyjx3() {
        return ztytnknuktkzngtkijyuhyjx3;
    }

    public void setZtytnknuktkzngtkijyuhyjx3(String pZtytnknuktkzngtkijyuhyjx3) {
        ztytnknuktkzngtkijyuhyjx3 = pZtytnknuktkzngtkijyuhyjx3;
    }

    private String ztyhtnknkykmrtisyuruikgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKMRTISYURUIKGUX3)
    public String getZtyhtnknkykmrtisyuruikgux3() {
        return ztyhtnknkykmrtisyuruikgux3;
    }

    public void setZtyhtnknkykmrtisyuruikgux3(String pZtyhtnknkykmrtisyuruikgux3) {
        ztyhtnknkykmrtisyuruikgux3 = pZtyhtnknkykmrtisyuruikgux3;
    }

    private String ztyhtnknkyksyonox4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSYONOX4)
    public String getZtyhtnknkyksyonox4() {
        return ztyhtnknkyksyonox4;
    }

    public void setZtyhtnknkyksyonox4(String pZtyhtnknkyksyonox4) {
        ztyhtnknkyksyonox4 = pZtyhtnknkyksyonox4;
    }

    private String ztyhtnknkykhknsyuruikgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNSYURUIKGUX4)
    public String getZtyhtnknkykhknsyuruikgux4() {
        return ztyhtnknkykhknsyuruikgux4;
    }

    public void setZtyhtnknkykhknsyuruikgux4(String pZtyhtnknkykhknsyuruikgux4) {
        ztyhtnknkykhknsyuruikgux4 = pZtyhtnknkykhknsyuruikgux4;
    }

    private String ztytenkanuketukeymdx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTENKANUKETUKEYMDX4)
    public String getZtytenkanuketukeymdx4() {
        return ztytenkanuketukeymdx4;
    }

    public void setZtytenkanuketukeymdx4(String pZtytenkanuketukeymdx4) {
        ztytenkanuketukeymdx4 = pZtytenkanuketukeymdx4;
    }

    private String ztyhtnknkykkykymdx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKKYKYMDX4)
    public String getZtyhtnknkykkykymdx4() {
        return ztyhtnknkykkykymdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhtnknkykkykymdx4(String pZtyhtnknkykkykymdx4) {
        ztyhtnknkykkykymdx4 = pZtyhtnknkykkykymdx4;
    }

    private String ztyhtnknkykhknkknx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNKKNX4)
    public String getZtyhtnknkykhknkknx4() {
        return ztyhtnknkykhknkknx4;
    }

    public void setZtyhtnknkykhknkknx4(String pZtyhtnknkykhknkknx4) {
        ztyhtnknkykhknkknx4 = pZtyhtnknkykhknkknx4;
    }

    private String ztyhtnknkykphrkkknx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKPHRKKKNX4)
    public String getZtyhtnknkykphrkkknx4() {
        return ztyhtnknkykphrkkknx4;
    }

    public void setZtyhtnknkykphrkkknx4(String pZtyhtnknkykphrkkknx4) {
        ztyhtnknkykphrkkknx4 = pZtyhtnknkykphrkkknx4;
    }

    private String ztyhtnknkykhrkkaisuukbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKAISUUKBNX4)
    public String getZtyhtnknkykhrkkaisuukbnx4() {
        return ztyhtnknkykhrkkaisuukbnx4;
    }

    public void setZtyhtnknkykhrkkaisuukbnx4(String pZtyhtnknkykhrkkaisuukbnx4) {
        ztyhtnknkykhrkkaisuukbnx4 = pZtyhtnknkykhrkkaisuukbnx4;
    }

    private String ztyhtnknkykhrkkeirokbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKEIROKBNX4)
    public String getZtyhtnknkykhrkkeirokbnx4() {
        return ztyhtnknkykhrkkeirokbnx4;
    }

    public void setZtyhtnknkykhrkkeirokbnx4(String pZtyhtnknkykhrkkeirokbnx4) {
        ztyhtnknkykhrkkeirokbnx4 = pZtyhtnknkykhrkkeirokbnx4;
    }

    private String ztytnknuktkzngtkijyuhyjx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTNKNUKTKZNGTKIJYUHYJX4)
    public String getZtytnknuktkzngtkijyuhyjx4() {
        return ztytnknuktkzngtkijyuhyjx4;
    }

    public void setZtytnknuktkzngtkijyuhyjx4(String pZtytnknuktkzngtkijyuhyjx4) {
        ztytnknuktkzngtkijyuhyjx4 = pZtytnknuktkzngtkijyuhyjx4;
    }

    private String ztyhtnknkykmrtisyuruikgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKMRTISYURUIKGUX4)
    public String getZtyhtnknkykmrtisyuruikgux4() {
        return ztyhtnknkykmrtisyuruikgux4;
    }

    public void setZtyhtnknkykmrtisyuruikgux4(String pZtyhtnknkykmrtisyuruikgux4) {
        ztyhtnknkykmrtisyuruikgux4 = pZtyhtnknkykmrtisyuruikgux4;
    }

    private String ztyhtnknkyksyonox5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSYONOX5)
    public String getZtyhtnknkyksyonox5() {
        return ztyhtnknkyksyonox5;
    }

    public void setZtyhtnknkyksyonox5(String pZtyhtnknkyksyonox5) {
        ztyhtnknkyksyonox5 = pZtyhtnknkyksyonox5;
    }

    private String ztyhtnknkykhknsyuruikgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNSYURUIKGUX5)
    public String getZtyhtnknkykhknsyuruikgux5() {
        return ztyhtnknkykhknsyuruikgux5;
    }

    public void setZtyhtnknkykhknsyuruikgux5(String pZtyhtnknkykhknsyuruikgux5) {
        ztyhtnknkykhknsyuruikgux5 = pZtyhtnknkykhknsyuruikgux5;
    }

    private String ztytenkanuketukeymdx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTENKANUKETUKEYMDX5)
    public String getZtytenkanuketukeymdx5() {
        return ztytenkanuketukeymdx5;
    }

    public void setZtytenkanuketukeymdx5(String pZtytenkanuketukeymdx5) {
        ztytenkanuketukeymdx5 = pZtytenkanuketukeymdx5;
    }

    private String ztyhtnknkykkykymdx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKKYKYMDX5)
    public String getZtyhtnknkykkykymdx5() {
        return ztyhtnknkykkykymdx5;
    }

    public void setZtyhtnknkykkykymdx5(String pZtyhtnknkykkykymdx5) {
        ztyhtnknkykkykymdx5 = pZtyhtnknkykkykymdx5;
    }

    private String ztyhtnknkykhknkknx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNKKNX5)
    public String getZtyhtnknkykhknkknx5() {
        return ztyhtnknkykhknkknx5;
    }

    public void setZtyhtnknkykhknkknx5(String pZtyhtnknkykhknkknx5) {
        ztyhtnknkykhknkknx5 = pZtyhtnknkykhknkknx5;
    }

    private String ztyhtnknkykphrkkknx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKPHRKKKNX5)
    public String getZtyhtnknkykphrkkknx5() {
        return ztyhtnknkykphrkkknx5;
    }

    public void setZtyhtnknkykphrkkknx5(String pZtyhtnknkykphrkkknx5) {
        ztyhtnknkykphrkkknx5 = pZtyhtnknkykphrkkknx5;
    }

    private String ztyhtnknkykhrkkaisuukbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKAISUUKBNX5)
    public String getZtyhtnknkykhrkkaisuukbnx5() {
        return ztyhtnknkykhrkkaisuukbnx5;
    }

    public void setZtyhtnknkykhrkkaisuukbnx5(String pZtyhtnknkykhrkkaisuukbnx5) {
        ztyhtnknkykhrkkaisuukbnx5 = pZtyhtnknkykhrkkaisuukbnx5;
    }

    private String ztyhtnknkykhrkkeirokbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKEIROKBNX5)
    public String getZtyhtnknkykhrkkeirokbnx5() {
        return ztyhtnknkykhrkkeirokbnx5;
    }

    public void setZtyhtnknkykhrkkeirokbnx5(String pZtyhtnknkykhrkkeirokbnx5) {
        ztyhtnknkykhrkkeirokbnx5 = pZtyhtnknkykhrkkeirokbnx5;
    }

    private String ztytnknuktkzngtkijyuhyjx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTNKNUKTKZNGTKIJYUHYJX5)
    public String getZtytnknuktkzngtkijyuhyjx5() {
        return ztytnknuktkzngtkijyuhyjx5;
    }

    public void setZtytnknuktkzngtkijyuhyjx5(String pZtytnknuktkzngtkijyuhyjx5) {
        ztytnknuktkzngtkijyuhyjx5 = pZtytnknuktkzngtkijyuhyjx5;
    }

    private String ztyhtnknkykmrtisyuruikgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKMRTISYURUIKGUX5)
    public String getZtyhtnknkykmrtisyuruikgux5() {
        return ztyhtnknkykmrtisyuruikgux5;
    }

    public void setZtyhtnknkykmrtisyuruikgux5(String pZtyhtnknkykmrtisyuruikgux5) {
        ztyhtnknkykmrtisyuruikgux5 = pZtyhtnknkykmrtisyuruikgux5;
    }

    private String ztyhtnknkyksyonox6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSYONOX6)
    public String getZtyhtnknkyksyonox6() {
        return ztyhtnknkyksyonox6;
    }

    public void setZtyhtnknkyksyonox6(String pZtyhtnknkyksyonox6) {
        ztyhtnknkyksyonox6 = pZtyhtnknkyksyonox6;
    }

    private String ztyhtnknkykhknsyuruikgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNSYURUIKGUX6)
    public String getZtyhtnknkykhknsyuruikgux6() {
        return ztyhtnknkykhknsyuruikgux6;
    }

    public void setZtyhtnknkykhknsyuruikgux6(String pZtyhtnknkykhknsyuruikgux6) {
        ztyhtnknkykhknsyuruikgux6 = pZtyhtnknkykhknsyuruikgux6;
    }

    private String ztytenkanuketukeymdx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTENKANUKETUKEYMDX6)
    public String getZtytenkanuketukeymdx6() {
        return ztytenkanuketukeymdx6;
    }

    public void setZtytenkanuketukeymdx6(String pZtytenkanuketukeymdx6) {
        ztytenkanuketukeymdx6 = pZtytenkanuketukeymdx6;
    }

    private String ztyhtnknkykkykymdx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKKYKYMDX6)
    public String getZtyhtnknkykkykymdx6() {
        return ztyhtnknkykkykymdx6;
    }

    public void setZtyhtnknkykkykymdx6(String pZtyhtnknkykkykymdx6) {
        ztyhtnknkykkykymdx6 = pZtyhtnknkykkykymdx6;
    }

    private String ztyhtnknkykhknkknx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHKNKKNX6)
    public String getZtyhtnknkykhknkknx6() {
        return ztyhtnknkykhknkknx6;
    }

    public void setZtyhtnknkykhknkknx6(String pZtyhtnknkykhknkknx6) {
        ztyhtnknkykhknkknx6 = pZtyhtnknkykhknkknx6;
    }

    private String ztyhtnknkykphrkkknx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKPHRKKKNX6)
    public String getZtyhtnknkykphrkkknx6() {
        return ztyhtnknkykphrkkknx6;
    }

    public void setZtyhtnknkykphrkkknx6(String pZtyhtnknkykphrkkknx6) {
        ztyhtnknkykphrkkknx6 = pZtyhtnknkykphrkkknx6;
    }

    private String ztyhtnknkykhrkkaisuukbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKAISUUKBNX6)
    public String getZtyhtnknkykhrkkaisuukbnx6() {
        return ztyhtnknkykhrkkaisuukbnx6;
    }

    public void setZtyhtnknkykhrkkaisuukbnx6(String pZtyhtnknkykhrkkaisuukbnx6) {
        ztyhtnknkykhrkkaisuukbnx6 = pZtyhtnknkykhrkkaisuukbnx6;
    }

    private String ztyhtnknkykhrkkeirokbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHRKKEIROKBNX6)
    public String getZtyhtnknkykhrkkeirokbnx6() {
        return ztyhtnknkykhrkkeirokbnx6;
    }

    public void setZtyhtnknkykhrkkeirokbnx6(String pZtyhtnknkykhrkkeirokbnx6) {
        ztyhtnknkykhrkkeirokbnx6 = pZtyhtnknkykhrkkeirokbnx6;
    }

    private String ztytnknuktkzngtkijyuhyjx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTNKNUKTKZNGTKIJYUHYJX6)
    public String getZtytnknuktkzngtkijyuhyjx6() {
        return ztytnknuktkzngtkijyuhyjx6;
    }

    public void setZtytnknuktkzngtkijyuhyjx6(String pZtytnknuktkzngtkijyuhyjx6) {
        ztytnknuktkzngtkijyuhyjx6 = pZtytnknuktkzngtkijyuhyjx6;
    }

    private String ztyhtnknkykmrtisyuruikgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKMRTISYURUIKGUX6)
    public String getZtyhtnknkykmrtisyuruikgux6() {
        return ztyhtnknkykmrtisyuruikgux6;
    }

    public void setZtyhtnknkykmrtisyuruikgux6(String pZtyhtnknkykmrtisyuruikgux6) {
        ztyhtnknkykmrtisyuruikgux6 = pZtyhtnknkykmrtisyuruikgux6;
    }

    private Long ztygukihtnknkykkhns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKIHTNKNKYKKHNS)
    public Long getZtygukihtnknkykkhns() {
        return ztygukihtnknkykkhns;
    }

    public void setZtygukihtnknkykkhns(Long pZtygukihtnknkykkhns) {
        ztygukihtnknkykkhns = pZtygukihtnknkykkhns;
    }

    private Long ztygukihtnknkyksbus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKIHTNKNKYKSBUS)
    public Long getZtygukihtnknkyksbus() {
        return ztygukihtnknkyksbus;
    }

    public void setZtygukihtnknkyksbus(Long pZtygukihtnknkyksbus) {
        ztygukihtnknkyksbus = pZtygukihtnknkyksbus;
    }

    private Long ztygukihtnknkykhntiyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKIHTNKNKYKHNTIYUP)
    public Long getZtygukihtnknkykhntiyup() {
        return ztygukihtnknkykhntiyup;
    }

    public void setZtygukihtnknkykhntiyup(Long pZtygukihtnknkykhntiyup) {
        ztygukihtnknkykhntiyup = pZtygukihtnknkykhntiyup;
    }

    private Long ztygukihtnknkyksigwrmstkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKIHTNKNKYKSIGWRMSTKYKS)
    public Long getZtygukihtnknkyksigwrmstkyks() {
        return ztygukihtnknkyksigwrmstkyks;
    }

    public void setZtygukihtnknkyksigwrmstkyks(Long pZtygukihtnknkyksigwrmstkyks) {
        ztygukihtnknkyksigwrmstkyks = pZtygukihtnknkyksigwrmstkyks;
    }

    private Long ztygukihtnknkyksyugitkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKIHTNKNKYKSYUGITKYKS)
    public Long getZtygukihtnknkyksyugitkyks() {
        return ztygukihtnknkyksyugitkyks;
    }

    public void setZtygukihtnknkyksyugitkyks(Long pZtygukihtnknkyksyugitkyks) {
        ztygukihtnknkyksyugitkyks = pZtygukihtnknkyksyugitkyks;
    }

    private Integer ztygukihtnknsignyintkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKIHTNKNSIGNYINTKYKNTGK)
    public Integer getZtygukihtnknsignyintkykntgk() {
        return ztygukihtnknsignyintkykntgk;
    }

    public void setZtygukihtnknsignyintkykntgk(Integer pZtygukihtnknsignyintkykntgk) {
        ztygukihtnknsignyintkykntgk = pZtygukihtnknsignyintkykntgk;
    }

    private Integer ztygukihtnknknkutkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKIHTNKNKNKUTKYKNTGK)
    public Integer getZtygukihtnknknkutkykntgk() {
        return ztygukihtnknknkutkykntgk;
    }

    public void setZtygukihtnknknkutkykntgk(Integer pZtygukihtnknknkutkykntgk) {
        ztygukihtnknknkutkykntgk = pZtygukihtnknknkutkykntgk;
    }

    private Long ztygukihtnknkykmods;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKIHTNKNKYKMODS)
    public Long getZtygukihtnknkykmods() {
        return ztygukihtnknkykmods;
    }

    public void setZtygukihtnknkykmods(Long pZtygukihtnknkykmods) {
        ztygukihtnknkykmods = pZtygukihtnknkykmods;
    }

    private Long ztygoukeitenkankakaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGOUKEITENKANKAKAKU)
    public Long getZtygoukeitenkankakaku() {
        return ztygoukeitenkankakaku;
    }

    public void setZtygoukeitenkankakaku(Long pZtygoukeitenkankakaku) {
        ztygoukeitenkankakaku = pZtygoukeitenkankakaku;
    }

    private Long ztygukitnknjsknnjynbkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKITNKNJSKNNJYNBKN)
    public Long getZtygukitnknjsknnjynbkn() {
        return ztygukitnknjsknnjynbkn;
    }

    public void setZtygukitnknjsknnjynbkn(Long pZtygukitnknjsknnjynbkn) {
        ztygukitnknjsknnjynbkn = pZtygukitnknjsknnjynbkn;
    }

    private Long ztygukitnknsisnkstkkngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKITNKNSISNKSTKKNGK)
    public Long getZtygukitnknsisnkstkkngk() {
        return ztygukitnknsisnkstkkngk;
    }

    public void setZtygukitnknsisnkstkkngk(Long pZtygukitnknsisnkstkkngk) {
        ztygukitnknsisnkstkkngk = pZtygukitnknsisnkstkkngk;
    }

    private Long ztygukitnknsisnttkekngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKITNKNSISNTTKEKNGK)
    public Long getZtygukitnknsisnttkekngk() {
        return ztygukitnknsisnttkekngk;
    }

    public void setZtygukitnknsisnttkekngk(Long pZtygukitnknsisnttkekngk) {
        ztygukitnknsisnttkekngk = pZtygukitnknsisnttkekngk;
    }

    private Long ztygoukeitenkanseisand;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGOUKEITENKANSEISAND)
    public Long getZtygoukeitenkanseisand() {
        return ztygoukeitenkanseisand;
    }

    public void setZtygoukeitenkanseisand(Long pZtygoukeitenkanseisand) {
        ztygoukeitenkanseisand = pZtygoukeitenkanseisand;
    }

    private Long ztygukitnknsisnmkikp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKITNKNSISNMKIKP)
    public Long getZtygukitnknsisnmkikp() {
        return ztygukitnknsisnmkikp;
    }

    public void setZtygukitnknsisnmkikp(Long pZtygukitnknsisnmkikp) {
        ztygukitnknsisnmkikp = pZtygukitnknsisnmkikp;
    }

    private Long ztygukitnknsisnsntkngk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKITNKNSISNSNTKNGK)
    public Long getZtygukitnknsisnsntkngk() {
        return ztygukitnknsisnsntkngk;
    }

    public void setZtygukitnknsisnsntkngk(Long pZtygukitnknsisnsntkngk) {
        ztygukitnknsisnsntkngk = pZtygukitnknsisnsntkngk;
    }

    private Long ztygukitnknkhnbbnkiykkujygk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKITNKNKHNBBNKIYKKUJYGK)
    public Long getZtygukitnknkhnbbnkiykkujygk() {
        return ztygukitnknkhnbbnkiykkujygk;
    }

    public void setZtygukitnknkhnbbnkiykkujygk(Long pZtygukitnknkhnbbnkiykkujygk) {
        ztygukitnknkhnbbnkiykkujygk = pZtygukitnknkhnbbnkiykkujygk;
    }

    private Long ztygukitnkntikbbnkiykkujygk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKITNKNTIKBBNKIYKKUJYGK)
    public Long getZtygukitnkntikbbnkiykkujygk() {
        return ztygukitnkntikbbnkiykkujygk;
    }

    public void setZtygukitnkntikbbnkiykkujygk(Long pZtygukitnkntikbbnkiykkujygk) {
        ztygukitnkntikbbnkiykkujygk = pZtygukitnkntikbbnkiykkujygk;
    }

    private Long ztygukitnknitjbrtiks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYGUKITNKNITJBRTIKS)
    public Long getZtygukitnknitjbrtiks() {
        return ztygukitnknitjbrtiks;
    }

    public void setZtygukitnknitjbrtiks(Long pZtygukitnknitjbrtiks) {
        ztygukitnknitjbrtiks = pZtygukitnknitjbrtiks;
    }

    private String ztysethokenno;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETHOKENNO)
    public String getZtysethokenno() {
        return ztysethokenno;
    }

    public void setZtysethokenno(String pZtysethokenno) {
        ztysethokenno = pZtysethokenno;
    }

    private String ztysckbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSCKBN)
    public String getZtysckbn() {
        return ztysckbn;
    }

    public void setZtysckbn(String pZtysckbn) {
        ztysckbn = pZtysckbn;
    }

    private String ztyenjyosyacd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYENJYOSYACD)
    public String getZtyenjyosyacd() {
        return ztyenjyosyacd;
    }

    public void setZtyenjyosyacd(String pZtyenjyosyacd) {
        ztyenjyosyacd = pZtyenjyosyacd;
    }

    private Long ztynaibuwarimodosigaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYNAIBUWARIMODOSIGAKU)
    public Long getZtynaibuwarimodosigaku() {
        return ztynaibuwarimodosigaku;
    }

    public void setZtynaibuwarimodosigaku(Long pZtynaibuwarimodosigaku) {
        ztynaibuwarimodosigaku = pZtynaibuwarimodosigaku;
    }

    private String ztykeiyakukakuninsyuruikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKEIYAKUKAKUNINSYURUIKBN)
    public String getZtykeiyakukakuninsyuruikbn() {
        return ztykeiyakukakuninsyuruikbn;
    }

    public void setZtykeiyakukakuninsyuruikbn(String pZtykeiyakukakuninsyuruikbn) {
        ztykeiyakukakuninsyuruikbn = pZtykeiyakukakuninsyuruikbn;
    }

    private String ztysoujikeitenkanhyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSOUJIKEITENKANHYOUJI)
    public String getZtysoujikeitenkanhyouji() {
        return ztysoujikeitenkanhyouji;
    }

    public void setZtysoujikeitenkanhyouji(String pZtysoujikeitenkanhyouji) {
        ztysoujikeitenkanhyouji = pZtysoujikeitenkanhyouji;
    }

    private String ztytenkanjisketteihouhoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTENKANJISKETTEIHOUHOUKBN)
    public String getZtytenkanjisketteihouhoukbn() {
        return ztytenkanjisketteihouhoukbn;
    }

    public void setZtytenkanjisketteihouhoukbn(String pZtytenkanjisketteihouhoukbn) {
        ztytenkanjisketteihouhoukbn = pZtytenkanjisketteihouhoukbn;
    }

    private String ztykeikanensuukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKEIKANENSUUKBN)
    public String getZtykeikanensuukbn() {
        return ztykeikanensuukbn;
    }

    public void setZtykeikanensuukbn(String pZtykeikanensuukbn) {
        ztykeikanensuukbn = pZtykeikanensuukbn;
    }

    private String ztyhtnknkykhhknsytisyukbnx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHHKNSYTISYUKBNX1)
    public String getZtyhtnknkykhhknsytisyukbnx1() {
        return ztyhtnknkykhhknsytisyukbnx1;
    }

    public void setZtyhtnknkykhhknsytisyukbnx1(String pZtyhtnknkykhhknsytisyukbnx1) {
        ztyhtnknkykhhknsytisyukbnx1 = pZtyhtnknkykhhknsytisyukbnx1;
    }

    private String ztyhtnknkykhhknsytisyukbnx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHHKNSYTISYUKBNX2)
    public String getZtyhtnknkykhhknsytisyukbnx2() {
        return ztyhtnknkykhhknsytisyukbnx2;
    }

    public void setZtyhtnknkykhhknsytisyukbnx2(String pZtyhtnknkykhhknsytisyukbnx2) {
        ztyhtnknkykhhknsytisyukbnx2 = pZtyhtnknkykhhknsytisyukbnx2;
    }

    private String ztyhtnknkykhhknsytisyukbnx3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHHKNSYTISYUKBNX3)
    public String getZtyhtnknkykhhknsytisyukbnx3() {
        return ztyhtnknkykhhknsytisyukbnx3;
    }

    public void setZtyhtnknkykhhknsytisyukbnx3(String pZtyhtnknkykhhknsytisyukbnx3) {
        ztyhtnknkykhhknsytisyukbnx3 = pZtyhtnknkykhhknsytisyukbnx3;
    }

    private String ztyhtnknkykhhknsytisyukbnx4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHHKNSYTISYUKBNX4)
    public String getZtyhtnknkykhhknsytisyukbnx4() {
        return ztyhtnknkykhhknsytisyukbnx4;
    }

    public void setZtyhtnknkykhhknsytisyukbnx4(String pZtyhtnknkykhhknsytisyukbnx4) {
        ztyhtnknkykhhknsytisyukbnx4 = pZtyhtnknkykhhknsytisyukbnx4;
    }

    private String ztyhtnknkykhhknsytisyukbnx5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHHKNSYTISYUKBNX5)
    public String getZtyhtnknkykhhknsytisyukbnx5() {
        return ztyhtnknkykhhknsytisyukbnx5;
    }

    public void setZtyhtnknkykhhknsytisyukbnx5(String pZtyhtnknkykhhknsytisyukbnx5) {
        ztyhtnknkykhhknsytisyukbnx5 = pZtyhtnknkykhhknsytisyukbnx5;
    }

    private String ztyhtnknkykhhknsytisyukbnx6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKHHKNSYTISYUKBNX6)
    public String getZtyhtnknkykhhknsytisyukbnx6() {
        return ztyhtnknkykhhknsytisyukbnx6;
    }

    public void setZtyhtnknkykhhknsytisyukbnx6(String pZtyhtnknkykhhknsytisyukbnx6) {
        ztyhtnknkykhhknsytisyukbnx6 = pZtyhtnknkykhhknsytisyukbnx6;
    }

    private Long ztykktijgukipbbntnkns;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKKTIJGUKIPBBNTNKNS)
    public Long getZtykktijgukipbbntnkns() {
        return ztykktijgukipbbntnkns;
    }

    public void setZtykktijgukipbbntnkns(Long pZtykktijgukipbbntnkns) {
        ztykktijgukipbbntnkns = pZtykktijgukipbbntnkns;
    }

    private Long ztysyonendosyokaip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYONENDOSYOKAIP)
    public Long getZtysyonendosyokaip() {
        return ztysyonendosyokaip;
    }

    public void setZtysyonendosyokaip(Long pZtysyonendosyokaip) {
        ztysyonendosyokaip = pZtysyonendosyokaip;
    }

    private Long ztysyonendo2kaimeikoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYONENDO2KAIMEIKOUP)
    public Long getZtysyonendo2kaimeikoup() {
        return ztysyonendo2kaimeikoup;
    }

    public void setZtysyonendo2kaimeikoup(Long pZtysyonendo2kaimeikoup) {
        ztysyonendo2kaimeikoup = pZtysyonendo2kaimeikoup;
    }

    private Long ztyjinendoikoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYJINENDOIKOUP)
    public Long getZtyjinendoikoup() {
        return ztyjinendoikoup;
    }

    public void setZtyjinendoikoup(Long pZtyjinendoikoup) {
        ztyjinendoikoup = pZtyjinendoikoup;
    }

    private Integer ztysyukeiyakusikyuukisogaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYUKEIYAKUSIKYUUKISOGAKU)
    public Integer getZtysyukeiyakusikyuukisogaku() {
        return ztysyukeiyakusikyuukisogaku;
    }

    public void setZtysyukeiyakusikyuukisogaku(Integer pZtysyukeiyakusikyuukisogaku) {
        ztysyukeiyakusikyuukisogaku = pZtysyukeiyakusikyuukisogaku;
    }

    private Integer ztysykyknenhantatskyuksgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYKYKNENHANTATSKYUKSGK)
    public Integer getZtysykyknenhantatskyuksgk() {
        return ztysykyknenhantatskyuksgk;
    }

    public void setZtysykyknenhantatskyuksgk(Integer pZtysykyknenhantatskyuksgk) {
        ztysykyknenhantatskyuksgk = pZtysykyknenhantatskyuksgk;
    }

    private Integer ztymaruteisikyuukisogaku;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMARUTEISIKYUUKISOGAKU)
    public Integer getZtymaruteisikyuukisogaku() {
        return ztymaruteisikyuukisogaku;
    }

    public void setZtymaruteisikyuukisogaku(Integer pZtymaruteisikyuukisogaku) {
        ztymaruteisikyuukisogaku = pZtymaruteisikyuukisogaku;
    }

    private Integer ztyitjbrzugkskyuksgkx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITJBRZUGKSKYUKSGKX1)
    public Integer getZtyitjbrzugkskyuksgkx1() {
        return ztyitjbrzugkskyuksgkx1;
    }

    public void setZtyitjbrzugkskyuksgkx1(Integer pZtyitjbrzugkskyuksgkx1) {
        ztyitjbrzugkskyuksgkx1 = pZtyitjbrzugkskyuksgkx1;
    }

    private Integer ztyitjbrzugkskyuksgkx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITJBRZUGKSKYUKSGKX2)
    public Integer getZtyitjbrzugkskyuksgkx2() {
        return ztyitjbrzugkskyuksgkx2;
    }

    public void setZtyitjbrzugkskyuksgkx2(Integer pZtyitjbrzugkskyuksgkx2) {
        ztyitjbrzugkskyuksgkx2 = pZtyitjbrzugkskyuksgkx2;
    }

    private Integer ztyitjbrzgknnhntatskyksgkx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITJBRZGKNNHNTATSKYKSGKX1)
    public Integer getZtyitjbrzgknnhntatskyksgkx1() {
        return ztyitjbrzgknnhntatskyksgkx1;
    }

    public void setZtyitjbrzgknnhntatskyksgkx1(Integer pZtyitjbrzgknnhntatskyksgkx1) {
        ztyitjbrzgknnhntatskyksgkx1 = pZtyitjbrzgknnhntatskyksgkx1;
    }

    private Integer ztyitjbrzgknnhntatskyksgkx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITJBRZGKNNHNTATSKYKSGKX2)
    public Integer getZtyitjbrzgknnhntatskyksgkx2() {
        return ztyitjbrzgknnhntatskyksgkx2;
    }

    public void setZtyitjbrzgknnhntatskyksgkx2(Integer pZtyitjbrzgknnhntatskyksgkx2) {
        ztyitjbrzgknnhntatskyksgkx2 = pZtyitjbrzgknnhntatskyksgkx2;
    }

    private Integer ztykzkmrtiskyuksgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKZKMRTISKYUKSGK)
    public Integer getZtykzkmrtiskyuksgk() {
        return ztykzkmrtiskyuksgk;
    }

    public void setZtykzkmrtiskyuksgk(Integer pZtykzkmrtiskyuksgk) {
        ztykzkmrtiskyuksgk = pZtykzkmrtiskyuksgk;
    }

    private Integer ztyitibitjbrskyuksgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITIBITJBRSKYUKSGK)
    public Integer getZtyitibitjbrskyuksgk() {
        return ztyitibitjbrskyuksgk;
    }

    public void setZtyitibitjbrskyuksgk(Integer pZtyitibitjbrskyuksgk) {
        ztyitibitjbrskyuksgk = pZtyitibitjbrskyuksgk;
    }

    private Integer ztyitbitjbrnnhntatskyuksgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITBITJBRNNHNTATSKYUKSGK)
    public Integer getZtyitbitjbrnnhntatskyuksgk() {
        return ztyitbitjbrnnhntatskyuksgk;
    }

    public void setZtyitbitjbrnnhntatskyuksgk(Integer pZtyitbitjbrnnhntatskyuksgk) {
        ztyitbitjbrnnhntatskyuksgk = pZtyitbitjbrnnhntatskyuksgk;
    }

    private Integer ztysykykksnbsyutat;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYKYKKSNBSYUTAT)
    public Integer getZtysykykksnbsyutat() {
        return ztysykykksnbsyutat;
    }

    public void setZtysykykksnbsyutat(Integer pZtysykykksnbsyutat) {
        ztysykykksnbsyutat = pZtysykykksnbsyutat;
    }

    private Integer ztyitjbrzugkksnbsyutatx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITJBRZUGKKSNBSYUTATX1)
    public Integer getZtyitjbrzugkksnbsyutatx1() {
        return ztyitjbrzugkksnbsyutatx1;
    }

    public void setZtyitjbrzugkksnbsyutatx1(Integer pZtyitjbrzugkksnbsyutatx1) {
        ztyitjbrzugkksnbsyutatx1 = pZtyitjbrzugkksnbsyutatx1;
    }

    private Integer ztyitjbrzugkksnbsyutatx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITJBRZUGKKSNBSYUTATX2)
    public Integer getZtyitjbrzugkksnbsyutatx2() {
        return ztyitjbrzugkksnbsyutatx2;
    }

    public void setZtyitjbrzugkksnbsyutatx2(Integer pZtyitjbrzugkksnbsyutatx2) {
        ztyitjbrzugkksnbsyutatx2 = pZtyitjbrzugkksnbsyutatx2;
    }

    private Integer ztyitibitjbrksnbsyutat;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITIBITJBRKSNBSYUTAT)
    public Integer getZtyitibitjbrksnbsyutat() {
        return ztyitibitjbrksnbsyutat;
    }

    public void setZtyitibitjbrksnbsyutat(Integer pZtyitibitjbrksnbsyutat) {
        ztyitibitjbrksnbsyutat = pZtyitibitjbrksnbsyutat;
    }

    private BizNumber ztyjyunkensuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYJYUNKENSUU)
    public BizNumber getZtyjyunkensuu() {
        return ztyjyunkensuu;
    }

    public void setZtyjyunkensuu(BizNumber pZtyjyunkensuu) {
        ztyjyunkensuu = pZtyjyunkensuu;
    }

    private BizNumber ztykansankensuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKANSANKENSUU)
    public BizNumber getZtykansankensuu() {
        return ztykansankensuu;
    }

    public void setZtykansankensuu(BizNumber pZtykansankensuu) {
        ztykansankensuu = pZtykansankensuu;
    }

    private String ztyitibuitijibaraikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITIBUITIJIBARAIKIKAN)
    public String getZtyitibuitijibaraikikan() {
        return ztyitibuitijibaraikikan;
    }

    public void setZtyitibuitijibaraikikan(String pZtyitibuitijibaraikikan) {
        ztyitibuitijibaraikikan = pZtyitibuitijibaraikikan;
    }

    private Long ztyitibuitijibarais;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITIBUITIJIBARAIS)
    public Long getZtyitibuitijibarais() {
        return ztyitibuitijibarais;
    }

    public void setZtyitibuitijibarais(Long pZtyitibuitijibarais) {
        ztyitibuitijibarais = pZtyitibuitijibarais;
    }

    private Long ztyitibuitijibaraip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITIBUITIJIBARAIP)
    public Long getZtyitibuitijibaraip() {
        return ztyitibuitijibaraip;
    }

    public void setZtyitibuitijibaraip(Long pZtyitibuitijibaraip) {
        ztyitibuitijibaraip = pZtyitibuitijibaraip;
    }

    private String ztyitibitjbrsdtpdtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITIBITJBRSDTPDTKBN)
    public String getZtyitibitjbrsdtpdtkbn() {
        return ztyitibitjbrsdtpdtkbn;
    }

    public void setZtyitibitjbrsdtpdtkbn(String pZtyitibitjbrsdtpdtkbn) {
        ztyitibitjbrsdtpdtkbn = pZtyitibitjbrsdtpdtkbn;
    }

    private Long ztyitibuitijibaraisyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITIBUITIJIBARAISYUUSEIS)
    public Long getZtyitibuitijibaraisyuuseis() {
        return ztyitibuitijibaraisyuuseis;
    }

    public void setZtyitibuitijibaraisyuuseis(Long pZtyitibuitijibaraisyuuseis) {
        ztyitibuitijibaraisyuuseis = pZtyitibuitijibaraisyuuseis;
    }

    private String ztyitibitjbrmodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYITIBITJBRMODSSKGNHYJ)
    public String getZtyitibitjbrmodsskgnhyj() {
        return ztyitibitjbrmodsskgnhyj;
    }

    public void setZtyitibitjbrmodsskgnhyj(String pZtyitibitjbrmodsskgnhyj) {
        ztyitibitjbrmodsskgnhyj = pZtyitibitjbrmodsskgnhyj;
    }

    private String ztysuuriyousyoriym;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSUURIYOUSYORIYM)
    public String getZtysuuriyousyoriym() {
        return ztysuuriyousyoriym;
    }

    public void setZtysuuriyousyoriym(String pZtysuuriyousyoriym) {
        ztysuuriyousyoriym = pZtysuuriyousyoriym;
    }

    private String ztysyosinsinsahouhoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSYOSINSINSAHOUHOUKBN)
    public String getZtysyosinsinsahouhoukbn() {
        return ztysyosinsinsahouhoukbn;
    }

    public void setZtysyosinsinsahouhoukbn(String pZtysyosinsinsahouhoukbn) {
        ztysyosinsinsahouhoukbn = pZtysyosinsinsahouhoukbn;
    }

    private String ztysaisinsinsahouhoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSAISINSINSAHOUHOUKBN)
    public String getZtysaisinsinsahouhoukbn() {
        return ztysaisinsinsahouhoukbn;
    }

    public void setZtysaisinsinsahouhoukbn(String pZtysaisinsinsahouhoukbn) {
        ztysaisinsinsahouhoukbn = pZtysaisinsinsahouhoukbn;
    }

    private String ztyseizonmrtisyuruikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIZONMRTISYURUIKGU)
    public String getZtyseizonmrtisyuruikgu() {
        return ztyseizonmrtisyuruikgu;
    }

    public void setZtyseizonmrtisyuruikgu(String pZtyseizonmrtisyuruikgu) {
        ztyseizonmrtisyuruikgu = pZtyseizonmrtisyuruikgu;
    }

    private String ztyseizonmaruteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIZONMARUTEIKIKAN)
    public String getZtyseizonmaruteikikan() {
        return ztyseizonmaruteikikan;
    }

    public void setZtyseizonmaruteikikan(String pZtyseizonmaruteikikan) {
        ztyseizonmaruteikikan = pZtyseizonmaruteikikan;
    }

    private String ztyseizonmrtiphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIZONMRTIPHRKKKN)
    public String getZtyseizonmrtiphrkkkn() {
        return ztyseizonmrtiphrkkkn;
    }

    public void setZtyseizonmrtiphrkkkn(String pZtyseizonmrtiphrkkkn) {
        ztyseizonmrtiphrkkkn = pZtyseizonmrtiphrkkkn;
    }

    private Long ztyseizonmaruteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIZONMARUTEIS)
    public Long getZtyseizonmaruteis() {
        return ztyseizonmaruteis;
    }

    public void setZtyseizonmaruteis(Long pZtyseizonmaruteis) {
        ztyseizonmaruteis = pZtyseizonmaruteis;
    }

    private Long ztyseizonmaruteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIZONMARUTEIP)
    public Long getZtyseizonmaruteip() {
        return ztyseizonmaruteip;
    }

    public void setZtyseizonmaruteip(Long pZtyseizonmaruteip) {
        ztyseizonmaruteip = pZtyseizonmaruteip;
    }

    private Long ztyseizonmaruteisyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIZONMARUTEISYUUSEIS)
    public Long getZtyseizonmaruteisyuuseis() {
        return ztyseizonmaruteisyuuseis;
    }

    public void setZtyseizonmaruteisyuuseis(Long pZtyseizonmaruteisyuuseis) {
        ztyseizonmaruteisyuuseis = pZtyseizonmaruteisyuuseis;
    }

    private String ztyseizonmrtimodsskgnhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIZONMRTIMODSSKGNHYJ)
    public String getZtyseizonmrtimodsskgnhyj() {
        return ztyseizonmrtimodsskgnhyj;
    }

    public void setZtyseizonmrtimodsskgnhyj(String pZtyseizonmrtimodsskgnhyj) {
        ztyseizonmrtimodsskgnhyj = pZtyseizonmrtimodsskgnhyj;
    }

    private String ztysiznmrtitkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIZNMRTITKJYUKBN)
    public String getZtysiznmrtitkjyukbn() {
        return ztysiznmrtitkjyukbn;
    }

    public void setZtysiznmrtitkjyukbn(String pZtysiznmrtitkjyukbn) {
        ztysiznmrtitkjyukbn = pZtysiznmrtitkjyukbn;
    }

    private String ztysiznmrtitkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIZNMRTITKJYUSKGNKKN)
    public String getZtysiznmrtitkjyuskgnkkn() {
        return ztysiznmrtitkjyuskgnkkn;
    }

    public void setZtysiznmrtitkjyuskgnkkn(String pZtysiznmrtitkjyuskgnkkn) {
        ztysiznmrtitkjyuskgnkkn = pZtysiznmrtitkjyuskgnkkn;
    }

    private Integer ztysiznmrtitkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIZNMRTITKJYURYUMSHYUTN)
    public Integer getZtysiznmrtitkjyuryumshyutn() {
        return ztysiznmrtitkjyuryumshyutn;
    }

    public void setZtysiznmrtitkjyuryumshyutn(Integer pZtysiznmrtitkjyuryumshyutn) {
        ztysiznmrtitkjyuryumshyutn = pZtysiznmrtitkjyuryumshyutn;
    }

    private Long ztysiznmrtitkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIZNMRTITKJYUP)
    public Long getZtysiznmrtitkjyup() {
        return ztysiznmrtitkjyup;
    }

    public void setZtysiznmrtitkjyup(Long pZtysiznmrtitkjyup) {
        ztysiznmrtitkjyup = pZtysiznmrtitkjyup;
    }

    private Integer ztysiznmrtiskyuksgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIZNMRTISKYUKSGK)
    public Integer getZtysiznmrtiskyuksgk() {
        return ztysiznmrtiskyuksgk;
    }

    public void setZtysiznmrtiskyuksgk(Integer pZtysiznmrtiskyuksgk) {
        ztysiznmrtiskyuksgk = pZtysiznmrtiskyuksgk;
    }

    private String ztyhtnknkyksiznmrtsyrikgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSIZNMRTSYRIKGUX1)
    public String getZtyhtnknkyksiznmrtsyrikgux1() {
        return ztyhtnknkyksiznmrtsyrikgux1;
    }

    public void setZtyhtnknkyksiznmrtsyrikgux1(String pZtyhtnknkyksiznmrtsyrikgux1) {
        ztyhtnknkyksiznmrtsyrikgux1 = pZtyhtnknkyksiznmrtsyrikgux1;
    }

    private String ztyhtnknkyksiznmrtsyrikgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSIZNMRTSYRIKGUX2)
    public String getZtyhtnknkyksiznmrtsyrikgux2() {
        return ztyhtnknkyksiznmrtsyrikgux2;
    }

    public void setZtyhtnknkyksiznmrtsyrikgux2(String pZtyhtnknkyksiznmrtsyrikgux2) {
        ztyhtnknkyksiznmrtsyrikgux2 = pZtyhtnknkyksiznmrtsyrikgux2;
    }

    private String ztyhtnknkyksiznmrtsyrikgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSIZNMRTSYRIKGUX3)
    public String getZtyhtnknkyksiznmrtsyrikgux3() {
        return ztyhtnknkyksiznmrtsyrikgux3;
    }

    public void setZtyhtnknkyksiznmrtsyrikgux3(String pZtyhtnknkyksiznmrtsyrikgux3) {
        ztyhtnknkyksiznmrtsyrikgux3 = pZtyhtnknkyksiznmrtsyrikgux3;
    }

    private String ztyhtnknkyksiznmrtsyrikgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSIZNMRTSYRIKGUX4)
    public String getZtyhtnknkyksiznmrtsyrikgux4() {
        return ztyhtnknkyksiznmrtsyrikgux4;
    }

    public void setZtyhtnknkyksiznmrtsyrikgux4(String pZtyhtnknkyksiznmrtsyrikgux4) {
        ztyhtnknkyksiznmrtsyrikgux4 = pZtyhtnknkyksiznmrtsyrikgux4;
    }

    private String ztyhtnknkyksiznmrtsyrikgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSIZNMRTSYRIKGUX5)
    public String getZtyhtnknkyksiznmrtsyrikgux5() {
        return ztyhtnknkyksiznmrtsyrikgux5;
    }

    public void setZtyhtnknkyksiznmrtsyrikgux5(String pZtyhtnknkyksiznmrtsyrikgux5) {
        ztyhtnknkyksiznmrtsyrikgux5 = pZtyhtnknkyksiznmrtsyrikgux5;
    }

    private String ztyhtnknkyksiznmrtsyrikgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKSIZNMRTSYRIKGUX6)
    public String getZtyhtnknkyksiznmrtsyrikgux6() {
        return ztyhtnknkyksiznmrtsyrikgux6;
    }

    public void setZtyhtnknkyksiznmrtsyrikgux6(String pZtyhtnknkyksiznmrtsyrikgux6) {
        ztyhtnknkyksiznmrtsyrikgux6 = pZtyhtnknkyksiznmrtsyrikgux6;
    }

    private String ztysuryusiznmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSURYUSIZNMRTIPWRBKKBN)
    public String getZtysuryusiznmrtipwrbkkbn() {
        return ztysuryusiznmrtipwrbkkbn;
    }

    public void setZtysuryusiznmrtipwrbkkbn(String pZtysuryusiznmrtipwrbkkbn) {
        ztysuryusiznmrtipwrbkkbn = pZtysuryusiznmrtipwrbkkbn;
    }

    private String ztysiznmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIZNMRTIPWRBKKBN)
    public String getZtysiznmrtipwrbkkbn() {
        return ztysiznmrtipwrbkkbn;
    }

    public void setZtysiznmrtipwrbkkbn(String pZtysiznmrtipwrbkkbn) {
        ztysiznmrtipwrbkkbn = pZtysiznmrtipwrbkkbn;
    }

    private String ztysiznmrtitnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSIZNMRTITNKNYUGUKBN)
    public String getZtysiznmrtitnknyugukbn() {
        return ztysiznmrtitnknyugukbn;
    }

    public void setZtysiznmrtitnknyugukbn(String pZtysiznmrtitnknyugukbn) {
        ztysiznmrtitnknyugukbn = pZtysiznmrtitnknyugukbn;
    }

    private String ztyseizonmrtikgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSEIZONMRTIKGUSDKBN)
    public String getZtyseizonmrtikgusdkbn() {
        return ztyseizonmrtikgusdkbn;
    }

    public void setZtyseizonmrtikgusdkbn(String pZtyseizonmrtikgusdkbn) {
        ztyseizonmrtikgusdkbn = pZtyseizonmrtikgusdkbn;
    }

    private String ztyyobiv1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV1)
    public String getZtyyobiv1() {
        return ztyyobiv1;
    }

    public void setZtyyobiv1(String pZtyyobiv1) {
        ztyyobiv1 = pZtyyobiv1;
    }

    private String ztydai2hihokensyamei;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2HIHOKENSYAMEI)
    public String getZtydai2hihokensyamei() {
        return ztydai2hihokensyamei;
    }

    public void setZtydai2hihokensyamei(String pZtydai2hihokensyamei) {
        ztydai2hihokensyamei = pZtydai2hihokensyamei;
    }

    private String ztydai2kanjihihokensyamei;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2KANJIHIHOKENSYAMEI)
    public String getZtydai2kanjihihokensyamei() {
        return ztydai2kanjihihokensyamei;
    }

    public void setZtydai2kanjihihokensyamei(String pZtydai2kanjihihokensyamei) {
        ztydai2kanjihihokensyamei = pZtydai2kanjihihokensyamei;
    }

    private String ztydai2hihokensyaseiymd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2HIHOKENSYASEIYMD)
    public String getZtydai2hihokensyaseiymd() {
        return ztydai2hihokensyaseiymd;
    }

    public void setZtydai2hihokensyaseiymd(String pZtydai2hihokensyaseiymd) {
        ztydai2hihokensyaseiymd = pZtydai2hihokensyaseiymd;
    }

    private String ztydai2hihokensyaseibetukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2HIHOKENSYASEIBETUKBN)
    public String getZtydai2hihokensyaseibetukbn() {
        return ztydai2hihokensyaseibetukbn;
    }

    public void setZtydai2hihokensyaseibetukbn(String pZtydai2hihokensyaseibetukbn) {
        ztydai2hihokensyaseibetukbn = pZtydai2hihokensyaseibetukbn;
    }

    private String ztydai2hihknsyahnskhkncd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2HIHKNSYAHNSKHKNCD)
    public String getZtydai2hihknsyahnskhkncd() {
        return ztydai2hihknsyahnskhkncd;
    }

    public void setZtydai2hihknsyahnskhkncd(String pZtydai2hihknsyahnskhkncd) {
        ztydai2hihknsyahnskhkncd = pZtydai2hihknsyahnskhkncd;
    }

    private String ztydai2hhknnen;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2HHKNNEN)
    public String getZtydai2hhknnen() {
        return ztydai2hhknnen;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2hhknnen(String pZtydai2hhknnen) {
        ztydai2hhknnen = pZtydai2hhknnen;
    }

    private String ztydai2hihknsyakikykarihyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2HIHKNSYAKIKYKARIHYJ)
    public String getZtydai2hihknsyakikykarihyj() {
        return ztydai2hihknsyakikykarihyj;
    }

    public void setZtydai2hihknsyakikykarihyj(String pZtydai2hihknsyakikykarihyj) {
        ztydai2hihknsyakikykarihyj = pZtydai2hihknsyakikykarihyj;
    }

    private String ztykyksydi2hihknsyaduithyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYKYKSYDI2HIHKNSYADUITHYJ)
    public String getZtykyksydi2hihknsyaduithyj() {
        return ztykyksydi2hihknsyaduithyj;
    }

    public void setZtykyksydi2hihknsyaduithyj(String pZtykyksydi2hihknsyaduithyj) {
        ztykyksydi2hihknsyaduithyj = pZtykyksydi2hihknsyaduithyj;
    }

    private String ztydai2syosinsinsahouhoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SYOSINSINSAHOUHOUKBN)
    public String getZtydai2syosinsinsahouhoukbn() {
        return ztydai2syosinsinsahouhoukbn;
    }

    public void setZtydai2syosinsinsahouhoukbn(String pZtydai2syosinsinsahouhoukbn) {
        ztydai2syosinsinsahouhoukbn = pZtydai2syosinsinsahouhoukbn;
    }

    private String ztydai2saisinsinsahouhoukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SAISINSINSAHOUHOUKBN)
    public String getZtydai2saisinsinsahouhoukbn() {
        return ztydai2saisinsinsahouhoukbn;
    }

    public void setZtydai2saisinsinsahouhoukbn(String pZtydai2saisinsinsahouhoukbn) {
        ztydai2saisinsinsahouhoukbn = pZtydai2saisinsinsahouhoukbn;
    }

    private String ztydai2syokugyoucd;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SYOKUGYOUCD)
    public String getZtydai2syokugyoucd() {
        return ztydai2syokugyoucd;
    }

    public void setZtydai2syokugyoucd(String pZtydai2syokugyoucd) {
        ztydai2syokugyoucd = pZtydai2syokugyoucd;
    }

    private String ztydai2sakugenkikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SAKUGENKIKAN)
    public String getZtydai2sakugenkikan() {
        return ztydai2sakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2sakugenkikan(String pZtydai2sakugenkikan) {
        ztydai2sakugenkikan = pZtydai2sakugenkikan;
    }

    private Integer ztydai2ryoumasihyouten;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2RYOUMASIHYOUTEN)
    public Integer getZtydai2ryoumasihyouten() {
        return ztydai2ryoumasihyouten;
    }

    public void setZtydai2ryoumasihyouten(Integer pZtydai2ryoumasihyouten) {
        ztydai2ryoumasihyouten = pZtydai2ryoumasihyouten;
    }

    private String ztymrtidi2skgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMRTIDI2SKGNKKN)
    public String getZtymrtidi2skgnkkn() {
        return ztymrtidi2skgnkkn;
    }

    public void setZtymrtidi2skgnkkn(String pZtymrtidi2skgnkkn) {
        ztymrtidi2skgnkkn = pZtymrtidi2skgnkkn;
    }

    private Integer ztymrtidi2ryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYMRTIDI2RYUMSHYUTN)
    public Integer getZtymrtidi2ryumshyutn() {
        return ztymrtidi2ryumshyutn;
    }

    public void setZtymrtidi2ryumshyutn(Integer pZtymrtidi2ryumshyutn) {
        ztymrtidi2ryumshyutn = pZtymrtidi2ryumshyutn;
    }

    private String ztydi2kykkknnsyrikbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2KYKKKNNSYRIKBN)
    public String getZtydi2kykkknnsyrikbn() {
        return ztydi2kykkknnsyrikbn;
    }

    public void setZtydi2kykkknnsyrikbn(String pZtydi2kykkknnsyrikbn) {
        ztydi2kykkknnsyrikbn = pZtydi2kykkknnsyrikbn;
    }

    private String ztytignmrtidi2skgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNMRTIDI2SKGNKKN)
    public String getZtytignmrtidi2skgnkkn() {
        return ztytignmrtidi2skgnkkn;
    }

    public void setZtytignmrtidi2skgnkkn(String pZtytignmrtidi2skgnkkn) {
        ztytignmrtidi2skgnkkn = pZtytignmrtidi2skgnkkn;
    }

    private Integer ztytignmrtidi2ryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNMRTIDI2RYUMSHYUTN)
    public Integer getZtytignmrtidi2ryumshyutn() {
        return ztytignmrtidi2ryumshyutn;
    }

    public void setZtytignmrtidi2ryumshyutn(Integer pZtytignmrtidi2ryumshyutn) {
        ztytignmrtidi2ryumshyutn = pZtytignmrtidi2ryumshyutn;
    }

    private String ztydai2syosinhonninkknnkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SYOSINHONNINKKNNKBN)
    public String getZtydai2syosinhonninkknnkbn() {
        return ztydai2syosinhonninkknnkbn;
    }

    public void setZtydai2syosinhonninkknnkbn(String pZtydai2syosinhonninkknnkbn) {
        ztydai2syosinhonninkknnkbn = pZtydai2syosinhonninkknnkbn;
    }

    private String ztydi2sisnhonninkknnkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SISNHONNINKKNNKBN)
    public String getZtydi2sisnhonninkknnkbn() {
        return ztydi2sisnhonninkknnkbn;
    }

    public void setZtydi2sisnhonninkknnkbn(String pZtydi2sisnhonninkknnkbn) {
        ztydi2sisnhonninkknnkbn = pZtydi2sisnhonninkknnkbn;
    }

    private String ztyyobiv9x6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV9X6)
    public String getZtyyobiv9x6() {
        return ztyyobiv9x6;
    }

    public void setZtyyobiv9x6(String pZtyyobiv9x6) {
        ztyyobiv9x6 = pZtyyobiv9x6;
    }

    private String ztydi2syugitkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SYUGITKYKSYRIKGU)
    public String getZtydi2syugitkyksyrikgu() {
        return ztydi2syugitkyksyrikgu;
    }

    public void setZtydi2syugitkyksyrikgu(String pZtydi2syugitkyksyrikgu) {
        ztydi2syugitkyksyrikgu = pZtydi2syugitkyksyrikgu;
    }

    private String ztydai2syougaitokuyakukikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SYOUGAITOKUYAKUKIKAN)
    public String getZtydai2syougaitokuyakukikan() {
        return ztydai2syougaitokuyakukikan;
    }

    public void setZtydai2syougaitokuyakukikan(String pZtydai2syougaitokuyakukikan) {
        ztydai2syougaitokuyakukikan = pZtydai2syougaitokuyakukikan;
    }

    private String ztydi2syugitkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SYUGITKYKPHRKKKN)
    public String getZtydi2syugitkykphrkkkn() {
        return ztydi2syugitkykphrkkkn;
    }

    public void setZtydi2syugitkykphrkkkn(String pZtydi2syugitkykphrkkkn) {
        ztydi2syugitkykphrkkkn = pZtydi2syugitkykphrkkkn;
    }

    private Long ztydai2syougaitokuyakus;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SYOUGAITOKUYAKUS)
    public Long getZtydai2syougaitokuyakus() {
        return ztydai2syougaitokuyakus;
    }

    public void setZtydai2syougaitokuyakus(Long pZtydai2syougaitokuyakus) {
        ztydai2syougaitokuyakus = pZtydai2syougaitokuyakus;
    }

    private Long ztydai2syougaitokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SYOUGAITOKUYAKUP)
    public Long getZtydai2syougaitokuyakup() {
        return ztydai2syougaitokuyakup;
    }

    public void setZtydai2syougaitokuyakup(Long pZtydai2syougaitokuyakup) {
        ztydai2syougaitokuyakup = pZtydai2syougaitokuyakup;
    }

    private String ztydi2syugitkykgtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SYUGITKYKGTKBN)
    public String getZtydi2syugitkykgtkbn() {
        return ztydi2syugitkykgtkbn;
    }

    public void setZtydi2syugitkykgtkbn(String pZtydi2syugitkykgtkbn) {
        ztydi2syugitkykgtkbn = pZtydi2syugitkykgtkbn;
    }

    private String ztydi2syugitkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SYUGITKYKKGUSDKBN)
    public String getZtydi2syugitkykkgusdkbn() {
        return ztydi2syugitkykkgusdkbn;
    }

    public void setZtydi2syugitkykkgusdkbn(String pZtydi2syugitkykkgusdkbn) {
        ztydi2syugitkykkgusdkbn = pZtydi2syugitkykkgusdkbn;
    }

    private String ztydi2syugitkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SYUGITKYKPWRBKKBN)
    public String getZtydi2syugitkykpwrbkkbn() {
        return ztydi2syugitkykpwrbkkbn;
    }

    public void setZtydi2syugitkykpwrbkkbn(String pZtydi2syugitkykpwrbkkbn) {
        ztydi2syugitkykpwrbkkbn = pZtydi2syugitkykpwrbkkbn;
    }

    private String ztyyobiv8;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV8)
    public String getZtyyobiv8() {
        return ztyyobiv8;
    }

    public void setZtyyobiv8(String pZtyyobiv8) {
        ztyyobiv8 = pZtyyobiv8;
    }

    private String ztydi2sigiwrmstkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGIWRMSTKYKSYRIKGU)
    public String getZtydi2sigiwrmstkyksyrikgu() {
        return ztydi2sigiwrmstkyksyrikgu;
    }

    public void setZtydi2sigiwrmstkyksyrikgu(String pZtydi2sigiwrmstkyksyrikgu) {
        ztydi2sigiwrmstkyksyrikgu = pZtydi2sigiwrmstkyksyrikgu;
    }

    private String ztydi2sigiwrmstkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGIWRMSTKYKKKN)
    public String getZtydi2sigiwrmstkykkkn() {
        return ztydi2sigiwrmstkykkkn;
    }

    public void setZtydi2sigiwrmstkykkkn(String pZtydi2sigiwrmstkykkkn) {
        ztydi2sigiwrmstkykkkn = pZtydi2sigiwrmstkykkkn;
    }

    private String ztydi2sigiwrmstkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGIWRMSTKYKPHRKKKN)
    public String getZtydi2sigiwrmstkykphrkkkn() {
        return ztydi2sigiwrmstkykphrkkkn;
    }

    public void setZtydi2sigiwrmstkykphrkkkn(String pZtydi2sigiwrmstkykphrkkkn) {
        ztydi2sigiwrmstkykphrkkkn = pZtydi2sigiwrmstkykphrkkkn;
    }

    private Long ztydi2sigiwrmstkyks;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGIWRMSTKYKS)
    public Long getZtydi2sigiwrmstkyks() {
        return ztydi2sigiwrmstkyks;
    }

    public void setZtydi2sigiwrmstkyks(Long pZtydi2sigiwrmstkyks) {
        ztydi2sigiwrmstkyks = pZtydi2sigiwrmstkyks;
    }

    private Long ztydi2sigiwrmstkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGIWRMSTKYKP)
    public Long getZtydi2sigiwrmstkykp() {
        return ztydi2sigiwrmstkykp;
    }

    public void setZtydi2sigiwrmstkykp(Long pZtydi2sigiwrmstkykp) {
        ztydi2sigiwrmstkykp = pZtydi2sigiwrmstkykp;
    }

    private String ztydi2sigiwrmstkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGIWRMSTKYKKGUSDKBN)
    public String getZtydi2sigiwrmstkykkgusdkbn() {
        return ztydi2sigiwrmstkykkgusdkbn;
    }

    public void setZtydi2sigiwrmstkykkgusdkbn(String pZtydi2sigiwrmstkykkgusdkbn) {
        ztydi2sigiwrmstkykkgusdkbn = pZtydi2sigiwrmstkykkgusdkbn;
    }

    private String ztydi2sigiwrmstkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGIWRMSTKYKPWRBKKBN)
    public String getZtydi2sigiwrmstkykpwrbkkbn() {
        return ztydi2sigiwrmstkykpwrbkkbn;
    }

    public void setZtydi2sigiwrmstkykpwrbkkbn(String pZtydi2sigiwrmstkykpwrbkkbn) {
        ztydi2sigiwrmstkykpwrbkkbn = pZtydi2sigiwrmstkykpwrbkkbn;
    }

    private String ztyyobiv9x7;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV9X7)
    public String getZtyyobiv9x7() {
        return ztyyobiv9x7;
    }

    public void setZtyyobiv9x7(String pZtyyobiv9x7) {
        ztyyobiv9x7 = pZtyyobiv9x7;
    }

    private String ztydi2siginyuintkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGINYUINTKYKSYRIKGU)
    public String getZtydi2siginyuintkyksyrikgu() {
        return ztydi2siginyuintkyksyrikgu;
    }

    public void setZtydi2siginyuintkyksyrikgu(String pZtydi2siginyuintkyksyrikgu) {
        ztydi2siginyuintkyksyrikgu = pZtydi2siginyuintkyksyrikgu;
    }

    private String ztydi2siginyuintkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGINYUINTKYKKKN)
    public String getZtydi2siginyuintkykkkn() {
        return ztydi2siginyuintkykkkn;
    }

    public void setZtydi2siginyuintkykkkn(String pZtydi2siginyuintkykkkn) {
        ztydi2siginyuintkykkkn = pZtydi2siginyuintkykkkn;
    }

    private String ztydi2siginyuintkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGINYUINTKYKPHRKKKN)
    public String getZtydi2siginyuintkykphrkkkn() {
        return ztydi2siginyuintkykphrkkkn;
    }

    public void setZtydi2siginyuintkykphrkkkn(String pZtydi2siginyuintkykphrkkkn) {
        ztydi2siginyuintkykphrkkkn = pZtydi2siginyuintkykphrkkkn;
    }

    private Integer ztydi2siginyuintkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGINYUINTKYKNTGK)
    public Integer getZtydi2siginyuintkykntgk() {
        return ztydi2siginyuintkykntgk;
    }

    public void setZtydi2siginyuintkykntgk(Integer pZtydi2siginyuintkykntgk) {
        ztydi2siginyuintkykntgk = pZtydi2siginyuintkykntgk;
    }

    private Long ztydi2siginyuintkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGINYUINTKYKP)
    public Long getZtydi2siginyuintkykp() {
        return ztydi2siginyuintkykp;
    }

    public void setZtydi2siginyuintkykp(Long pZtydi2siginyuintkykp) {
        ztydi2siginyuintkykp = pZtydi2siginyuintkykp;
    }

    private String ztydi2siginyuintkykgtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGINYUINTKYKGTKBN)
    public String getZtydi2siginyuintkykgtkbn() {
        return ztydi2siginyuintkykgtkbn;
    }

    public void setZtydi2siginyuintkykgtkbn(String pZtydi2siginyuintkykgtkbn) {
        ztydi2siginyuintkykgtkbn = pZtydi2siginyuintkykgtkbn;
    }

    private String ztydi2siginyintkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGINYINTKYKKGUSDKBN)
    public String getZtydi2siginyintkykkgusdkbn() {
        return ztydi2siginyintkykkgusdkbn;
    }

    public void setZtydi2siginyintkykkgusdkbn(String pZtydi2siginyintkykkgusdkbn) {
        ztydi2siginyintkykkgusdkbn = pZtydi2siginyintkykkgusdkbn;
    }

    private String ztydi2siginyuintkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIGINYUINTKYKPWRBKKBN)
    public String getZtydi2siginyuintkykpwrbkkbn() {
        return ztydi2siginyuintkykpwrbkkbn;
    }

    public void setZtydi2siginyuintkykpwrbkkbn(String pZtydi2siginyuintkykpwrbkkbn) {
        ztydi2siginyuintkykpwrbkkbn = pZtydi2siginyuintkykpwrbkkbn;
    }

    private String ztyyobiv10x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV10X3)
    public String getZtyyobiv10x3() {
        return ztyyobiv10x3;
    }

    public void setZtyyobiv10x3(String pZtyyobiv10x3) {
        ztyyobiv10x3 = pZtyyobiv10x3;
    }

    private String ztydi2sppinyuintkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINTKYKSYRIKGU)
    public String getZtydi2sppinyuintkyksyrikgu() {
        return ztydi2sppinyuintkyksyrikgu;
    }

    public void setZtydi2sppinyuintkyksyrikgu(String pZtydi2sppinyuintkyksyrikgu) {
        ztydi2sppinyuintkyksyrikgu = pZtydi2sppinyuintkyksyrikgu;
    }

    private String ztydi2sppinyuintkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINTKYKKKN)
    public String getZtydi2sppinyuintkykkkn() {
        return ztydi2sppinyuintkykkkn;
    }

    public void setZtydi2sppinyuintkykkkn(String pZtydi2sppinyuintkykkkn) {
        ztydi2sppinyuintkykkkn = pZtydi2sppinyuintkykkkn;
    }

    private String ztydi2sppinyuintkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINTKYKPHRKKKN)
    public String getZtydi2sppinyuintkykphrkkkn() {
        return ztydi2sppinyuintkykphrkkkn;
    }

    public void setZtydi2sppinyuintkykphrkkkn(String pZtydi2sppinyuintkykphrkkkn) {
        ztydi2sppinyuintkykphrkkkn = pZtydi2sppinyuintkykphrkkkn;
    }

    private Integer ztydi2sppinyuintkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINTKYKNTGK)
    public Integer getZtydi2sppinyuintkykntgk() {
        return ztydi2sppinyuintkykntgk;
    }

    public void setZtydi2sppinyuintkykntgk(Integer pZtydi2sppinyuintkykntgk) {
        ztydi2sppinyuintkykntgk = pZtydi2sppinyuintkykntgk;
    }

    private Long ztydi2sppinyuintkykp;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINTKYKP)
    public Long getZtydi2sppinyuintkykp() {
        return ztydi2sppinyuintkykp;
    }

    public void setZtydi2sppinyuintkykp(Long pZtydi2sppinyuintkykp) {
        ztydi2sppinyuintkykp = pZtydi2sppinyuintkykp;
    }

    private String ztydi2sppinyuintkykgtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINTKYKGTKBN)
    public String getZtydi2sppinyuintkykgtkbn() {
        return ztydi2sppinyuintkykgtkbn;
    }

    public void setZtydi2sppinyuintkykgtkbn(String pZtydi2sppinyuintkykgtkbn) {
        ztydi2sppinyuintkykgtkbn = pZtydi2sppinyuintkykgtkbn;
    }

    private Integer ztydi2sppinyintkjyryumshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYINTKJYRYUMSHYTN)
    public Integer getZtydi2sppinyintkjyryumshytn() {
        return ztydi2sppinyintkjyryumshytn;
    }

    public void setZtydi2sppinyintkjyryumshytn(Integer pZtydi2sppinyintkjyryumshytn) {
        ztydi2sppinyintkjyryumshytn = pZtydi2sppinyintkjyryumshytn;
    }

    private Long ztydi2sppinyuintkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINTKJYUP)
    public Long getZtydi2sppinyuintkjyup() {
        return ztydi2sppinyuintkjyup;
    }

    public void setZtydi2sppinyuintkjyup(Long pZtydi2sppinyuintkjyup) {
        ztydi2sppinyuintkjyup = pZtydi2sppinyuintkjyup;
    }

    private String ztydi2sppinyuintktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINTKTBICDX1)
    public String getZtydi2sppinyuintktbicdx1() {
        return ztydi2sppinyuintktbicdx1;
    }

    public void setZtydi2sppinyuintktbicdx1(String pZtydi2sppinyuintktbicdx1) {
        ztydi2sppinyuintktbicdx1 = pZtydi2sppinyuintktbicdx1;
    }

    private String ztydi2sppinyuinhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINHTNPKKNX1)
    public String getZtydi2sppinyuinhtnpkknx1() {
        return ztydi2sppinyuinhtnpkknx1;
    }

    public void setZtydi2sppinyuinhtnpkknx1(String pZtydi2sppinyuinhtnpkknx1) {
        ztydi2sppinyuinhtnpkknx1 = pZtydi2sppinyuinhtnpkknx1;
    }

    private String ztydi2sppinyuintktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINTKTBICDX2)
    public String getZtydi2sppinyuintktbicdx2() {
        return ztydi2sppinyuintktbicdx2;
    }

    public void setZtydi2sppinyuintktbicdx2(String pZtydi2sppinyuintktbicdx2) {
        ztydi2sppinyuintktbicdx2 = pZtydi2sppinyuintktbicdx2;
    }

    private String ztydi2sppinyuinhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINHTNPKKNX2)
    public String getZtydi2sppinyuinhtnpkknx2() {
        return ztydi2sppinyuinhtnpkknx2;
    }

    public void setZtydi2sppinyuinhtnpkknx2(String pZtydi2sppinyuinhtnpkknx2) {
        ztydi2sppinyuinhtnpkknx2 = pZtydi2sppinyuinhtnpkknx2;
    }

    private String ztydi2sppinyintkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYINTKYKKGUSDKBN)
    public String getZtydi2sppinyintkykkgusdkbn() {
        return ztydi2sppinyintkykkgusdkbn;
    }

    public void setZtydi2sppinyintkykkgusdkbn(String pZtydi2sppinyintkykkgusdkbn) {
        ztydi2sppinyintkykkgusdkbn = pZtydi2sppinyintkykkgusdkbn;
    }

    private String ztydi2sppinyuintkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SPPINYUINTKYKPWRBKKBN)
    public String getZtydi2sppinyuintkykpwrbkkbn() {
        return ztydi2sppinyuintkykpwrbkkbn;
    }

    public void setZtydi2sppinyuintkykpwrbkkbn(String pZtydi2sppinyuintkykpwrbkkbn) {
        ztydi2sppinyuintkykpwrbkkbn = pZtydi2sppinyuintkykpwrbkkbn;
    }

    private String ztyyobiv3x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV3X2)
    public String getZtyyobiv3x2() {
        return ztyyobiv3x2;
    }

    public void setZtyyobiv3x2(String pZtyyobiv3x2) {
        ztyyobiv3x2 = pZtyyobiv3x2;
    }

    private String ztydi2sijnbyutkyksyrikgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUTKYKSYRIKGU)
    public String getZtydi2sijnbyutkyksyrikgu() {
        return ztydi2sijnbyutkyksyrikgu;
    }

    public void setZtydi2sijnbyutkyksyrikgu(String pZtydi2sijnbyutkyksyrikgu) {
        ztydi2sijnbyutkyksyrikgu = pZtydi2sijnbyutkyksyrikgu;
    }

    private String ztydi2sijnbyutkykkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUTKYKKKN)
    public String getZtydi2sijnbyutkykkkn() {
        return ztydi2sijnbyutkykkkn;
    }

    public void setZtydi2sijnbyutkykkkn(String pZtydi2sijnbyutkykkkn) {
        ztydi2sijnbyutkykkkn = pZtydi2sijnbyutkykkkn;
    }

    private String ztydi2sijnbyutkykphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUTKYKPHRKKKN)
    public String getZtydi2sijnbyutkykphrkkkn() {
        return ztydi2sijnbyutkykphrkkkn;
    }

    public void setZtydi2sijnbyutkykphrkkkn(String pZtydi2sijnbyutkykphrkkkn) {
        ztydi2sijnbyutkykphrkkkn = pZtydi2sijnbyutkykphrkkkn;
    }

    private Integer ztydi2sijnbyutkykntgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUTKYKNTGK)
    public Integer getZtydi2sijnbyutkykntgk() {
        return ztydi2sijnbyutkykntgk;
    }

    public void setZtydi2sijnbyutkykntgk(Integer pZtydi2sijnbyutkykntgk) {
        ztydi2sijnbyutkykntgk = pZtydi2sijnbyutkykntgk;
    }

    private Long ztydai2seijinbyoutokuyakup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SEIJINBYOUTOKUYAKUP)
    public Long getZtydai2seijinbyoutokuyakup() {
        return ztydai2seijinbyoutokuyakup;
    }

    public void setZtydai2seijinbyoutokuyakup(Long pZtydai2seijinbyoutokuyakup) {
        ztydai2seijinbyoutokuyakup = pZtydai2seijinbyoutokuyakup;
    }

    private Integer ztydi2sijnbyutkjyurymshytn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUTKJYURYMSHYTN)
    public Integer getZtydi2sijnbyutkjyurymshytn() {
        return ztydi2sijnbyutkjyurymshytn;
    }

    public void setZtydi2sijnbyutkjyurymshytn(Integer pZtydi2sijnbyutkjyurymshytn) {
        ztydi2sijnbyutkjyurymshytn = pZtydi2sijnbyutkjyurymshytn;
    }

    private Long ztydai2seijinbyoutokujyoup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2SEIJINBYOUTOKUJYOUP)
    public Long getZtydai2seijinbyoutokujyoup() {
        return ztydai2seijinbyoutokujyoup;
    }

    public void setZtydai2seijinbyoutokujyoup(Long pZtydai2seijinbyoutokujyoup) {
        ztydai2seijinbyoutokujyoup = pZtydai2seijinbyoutokujyoup;
    }

    private String ztydi2sijnbyutktbicdx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUTKTBICDX1)
    public String getZtydi2sijnbyutktbicdx1() {
        return ztydi2sijnbyutktbicdx1;
    }

    public void setZtydi2sijnbyutktbicdx1(String pZtydi2sijnbyutktbicdx1) {
        ztydi2sijnbyutktbicdx1 = pZtydi2sijnbyutktbicdx1;
    }

    private String ztydi2sijnbyuhtnpkknx1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUHTNPKKNX1)
    public String getZtydi2sijnbyuhtnpkknx1() {
        return ztydi2sijnbyuhtnpkknx1;
    }

    public void setZtydi2sijnbyuhtnpkknx1(String pZtydi2sijnbyuhtnpkknx1) {
        ztydi2sijnbyuhtnpkknx1 = pZtydi2sijnbyuhtnpkknx1;
    }

    private String ztydi2sijnbyutktbicdx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUTKTBICDX2)
    public String getZtydi2sijnbyutktbicdx2() {
        return ztydi2sijnbyutktbicdx2;
    }

    public void setZtydi2sijnbyutktbicdx2(String pZtydi2sijnbyutktbicdx2) {
        ztydi2sijnbyutktbicdx2 = pZtydi2sijnbyutktbicdx2;
    }

    private String ztydi2sijnbyuhtnpkknx2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUHTNPKKNX2)
    public String getZtydi2sijnbyuhtnpkknx2() {
        return ztydi2sijnbyuhtnpkknx2;
    }

    public void setZtydi2sijnbyuhtnpkknx2(String pZtydi2sijnbyuhtnpkknx2) {
        ztydi2sijnbyuhtnpkknx2 = pZtydi2sijnbyuhtnpkknx2;
    }

    private String ztydi2sijnbyutkykkgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUTKYKKGUSDKBN)
    public String getZtydi2sijnbyutkykkgusdkbn() {
        return ztydi2sijnbyutkykkgusdkbn;
    }

    public void setZtydi2sijnbyutkykkgusdkbn(String pZtydi2sijnbyutkykkgusdkbn) {
        ztydi2sijnbyutkykkgusdkbn = pZtydi2sijnbyutkykkgusdkbn;
    }

    private String ztydi2sijnbytkykgankyhgtkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYTKYKGANKYHGTKBN)
    public String getZtydi2sijnbytkykgankyhgtkbn() {
        return ztydi2sijnbytkykgankyhgtkbn;
    }

    public void setZtydi2sijnbytkykgankyhgtkbn(String pZtydi2sijnbytkykgankyhgtkbn) {
        ztydi2sijnbytkykgankyhgtkbn = pZtydi2sijnbytkykgankyhgtkbn;
    }

    private String ztydi2sijnbyutkykpwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDI2SIJNBYUTKYKPWRBKKBN)
    public String getZtydi2sijnbyutkykpwrbkkbn() {
        return ztydi2sijnbyutkykpwrbkkbn;
    }

    public void setZtydi2sijnbyutkykpwrbkkbn(String pZtydi2sijnbyutkykpwrbkkbn) {
        ztydi2sijnbyutkykpwrbkkbn = pZtydi2sijnbyutkykpwrbkkbn;
    }

    private String ztyyobiv3x3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV3X3)
    public String getZtyyobiv3x3() {
        return ztyyobiv3x3;
    }

    public void setZtyyobiv3x3(String pZtyyobiv3x3) {
        ztyyobiv3x3 = pZtyyobiv3x3;
    }

    private String ztydai2jyoukentukihyouji;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYDAI2JYOUKENTUKIHYOUJI)
    public String getZtydai2jyoukentukihyouji() {
        return ztydai2jyoukentukihyouji;
    }

    public void setZtydai2jyoukentukihyouji(String pZtydai2jyoukentukihyouji) {
        ztydai2jyoukentukihyouji = pZtydai2jyoukentukihyouji;
    }

    private String ztytignmrtisyukgu;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNMRTISYUKGU)
    public String getZtytignmrtisyukgu() {
        return ztytignmrtisyukgu;
    }

    public void setZtytignmrtisyukgu(String pZtytignmrtisyukgu) {
        ztytignmrtisyukgu = pZtytignmrtisyukgu;
    }

    private String ztyteigenmaruteikikan;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENMARUTEIKIKAN)
    public String getZtyteigenmaruteikikan() {
        return ztyteigenmaruteikikan;
    }

    public void setZtyteigenmaruteikikan(String pZtyteigenmaruteikikan) {
        ztyteigenmaruteikikan = pZtyteigenmaruteikikan;
    }

    private String ztyteigenmrtiphrkkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENMRTIPHRKKKN)
    public String getZtyteigenmrtiphrkkkn() {
        return ztyteigenmrtiphrkkkn;
    }

    public void setZtyteigenmrtiphrkkkn(String pZtyteigenmrtiphrkkkn) {
        ztyteigenmrtiphrkkkn = pZtyteigenmrtiphrkkkn;
    }

    private Long ztyteigenmaruteis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENMARUTEIS)
    public Long getZtyteigenmaruteis() {
        return ztyteigenmaruteis;
    }

    public void setZtyteigenmaruteis(Long pZtyteigenmaruteis) {
        ztyteigenmaruteis = pZtyteigenmaruteis;
    }

    private Long ztyteigenmaruteip;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENMARUTEIP)
    public Long getZtyteigenmaruteip() {
        return ztyteigenmaruteip;
    }

    public void setZtyteigenmaruteip(Long pZtyteigenmaruteip) {
        ztyteigenmaruteip = pZtyteigenmaruteip;
    }

    private Long ztyteigenmaruteisyuuseis;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENMARUTEISYUUSEIS)
    public Long getZtyteigenmaruteisyuuseis() {
        return ztyteigenmaruteisyuuseis;
    }

    public void setZtyteigenmaruteisyuuseis(Long pZtyteigenmaruteisyuuseis) {
        ztyteigenmaruteisyuuseis = pZtyteigenmaruteisyuuseis;
    }

    private String ztyteigenmrtimodssakugenhyj;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENMRTIMODSSAKUGENHYJ)
    public String getZtyteigenmrtimodssakugenhyj() {
        return ztyteigenmrtimodssakugenhyj;
    }

    public void setZtyteigenmrtimodssakugenhyj(String pZtyteigenmrtimodssakugenhyj) {
        ztyteigenmrtimodssakugenhyj = pZtyteigenmrtimodssakugenhyj;
    }

    private String ztytignmrtitkjyukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNMRTITKJYUKBN)
    public String getZtytignmrtitkjyukbn() {
        return ztytignmrtitkjyukbn;
    }

    public void setZtytignmrtitkjyukbn(String pZtytignmrtitkjyukbn) {
        ztytignmrtitkjyukbn = pZtytignmrtitkjyukbn;
    }

    private String ztytignmrtitkjyuskgnkkn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNMRTITKJYUSKGNKKN)
    public String getZtytignmrtitkjyuskgnkkn() {
        return ztytignmrtitkjyuskgnkkn;
    }

    public void setZtytignmrtitkjyuskgnkkn(String pZtytignmrtitkjyuskgnkkn) {
        ztytignmrtitkjyuskgnkkn = pZtytignmrtitkjyuskgnkkn;
    }

    private Integer ztytignmrtitkjyuryumshyutn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNMRTITKJYURYUMSHYUTN)
    public Integer getZtytignmrtitkjyuryumshyutn() {
        return ztytignmrtitkjyuryumshyutn;
    }

    public void setZtytignmrtitkjyuryumshyutn(Integer pZtytignmrtitkjyuryumshyutn) {
        ztytignmrtitkjyuryumshyutn = pZtytignmrtitkjyuryumshyutn;
    }

    private Long ztytignmrtitkjyup;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNMRTITKJYUP)
    public Long getZtytignmrtitkjyup() {
        return ztytignmrtitkjyup;
    }

    public void setZtytignmrtitkjyup(Long pZtytignmrtitkjyup) {
        ztytignmrtitkjyup = pZtytignmrtitkjyup;
    }

    private Integer ztytignmrtiskyuksgk;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNMRTISKYUKSGK)
    public Integer getZtytignmrtiskyuksgk() {
        return ztytignmrtiskyuksgk;
    }

    public void setZtytignmrtiskyuksgk(Integer pZtytignmrtiskyuksgk) {
        ztytignmrtiskyuksgk = pZtytignmrtiskyuksgk;
    }

    private String ztyhtnknkyktignmrtsyrikgux1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKTIGNMRTSYRIKGUX1)
    public String getZtyhtnknkyktignmrtsyrikgux1() {
        return ztyhtnknkyktignmrtsyrikgux1;
    }

    public void setZtyhtnknkyktignmrtsyrikgux1(String pZtyhtnknkyktignmrtsyrikgux1) {
        ztyhtnknkyktignmrtsyrikgux1 = pZtyhtnknkyktignmrtsyrikgux1;
    }

    private String ztyhtnknkyktignmrtsyrikgux2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKTIGNMRTSYRIKGUX2)
    public String getZtyhtnknkyktignmrtsyrikgux2() {
        return ztyhtnknkyktignmrtsyrikgux2;
    }

    public void setZtyhtnknkyktignmrtsyrikgux2(String pZtyhtnknkyktignmrtsyrikgux2) {
        ztyhtnknkyktignmrtsyrikgux2 = pZtyhtnknkyktignmrtsyrikgux2;
    }

    private String ztyhtnknkyktignmrtsyrikgux3;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKTIGNMRTSYRIKGUX3)
    public String getZtyhtnknkyktignmrtsyrikgux3() {
        return ztyhtnknkyktignmrtsyrikgux3;
    }

    public void setZtyhtnknkyktignmrtsyrikgux3(String pZtyhtnknkyktignmrtsyrikgux3) {
        ztyhtnknkyktignmrtsyrikgux3 = pZtyhtnknkyktignmrtsyrikgux3;
    }

    private String ztyhtnknkyktignmrtsyrikgux4;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKTIGNMRTSYRIKGUX4)
    public String getZtyhtnknkyktignmrtsyrikgux4() {
        return ztyhtnknkyktignmrtsyrikgux4;
    }

    public void setZtyhtnknkyktignmrtsyrikgux4(String pZtyhtnknkyktignmrtsyrikgux4) {
        ztyhtnknkyktignmrtsyrikgux4 = pZtyhtnknkyktignmrtsyrikgux4;
    }

    private String ztyhtnknkyktignmrtsyrikgux5;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKTIGNMRTSYRIKGUX5)
    public String getZtyhtnknkyktignmrtsyrikgux5() {
        return ztyhtnknkyktignmrtsyrikgux5;
    }

    public void setZtyhtnknkyktignmrtsyrikgux5(String pZtyhtnknkyktignmrtsyrikgux5) {
        ztyhtnknkyktignmrtsyrikgux5 = pZtyhtnknkyktignmrtsyrikgux5;
    }

    private String ztyhtnknkyktignmrtsyrikgux6;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYHTNKNKYKTIGNMRTSYRIKGUX6)
    public String getZtyhtnknkyktignmrtsyrikgux6() {
        return ztyhtnknkyktignmrtsyrikgux6;
    }

    public void setZtyhtnknkyktignmrtsyrikgux6(String pZtyhtnknkyktignmrtsyrikgux6) {
        ztyhtnknkyktignmrtsyrikgux6 = pZtyhtnknkyktignmrtsyrikgux6;
    }

    private String ztysuryutignmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSURYUTIGNMRTIPWRBKKBN)
    public String getZtysuryutignmrtipwrbkkbn() {
        return ztysuryutignmrtipwrbkkbn;
    }

    public void setZtysuryutignmrtipwrbkkbn(String pZtysuryutignmrtipwrbkkbn) {
        ztysuryutignmrtipwrbkkbn = pZtysuryutignmrtipwrbkkbn;
    }

    private String ztytignmrtipwrbkkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNMRTIPWRBKKBN)
    public String getZtytignmrtipwrbkkbn() {
        return ztytignmrtipwrbkkbn;
    }

    public void setZtytignmrtipwrbkkbn(String pZtytignmrtipwrbkkbn) {
        ztytignmrtipwrbkkbn = pZtytignmrtipwrbkkbn;
    }

    private String ztytignmrtitnknyugukbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTIGNMRTITNKNYUGUKBN)
    public String getZtytignmrtitnknyugukbn() {
        return ztytignmrtitnknyugukbn;
    }

    public void setZtytignmrtitnknyugukbn(String pZtytignmrtitnknyugukbn) {
        ztytignmrtitnknyugukbn = pZtytignmrtitnknyugukbn;
    }

    private String ztyteigenmrtikgusdkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTEIGENMRTIKGUSDKBN)
    public String getZtyteigenmrtikgusdkbn() {
        return ztyteigenmrtikgusdkbn;
    }

    public void setZtyteigenmrtikgusdkbn(String pZtyteigenmrtikgusdkbn) {
        ztyteigenmrtikgusdkbn = pZtyteigenmrtikgusdkbn;
    }

    private String ztyyobiv1x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV1X2)
    public String getZtyyobiv1x2() {
        return ztyyobiv1x2;
    }

    public void setZtyyobiv1x2(String pZtyyobiv1x2) {
        ztyyobiv1x2 = pZtyyobiv1x2;
    }

    private String ztytktsppisetkykkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYTKTSPPISETKYKKBN)
    public String getZtytktsppisetkykkbn() {
        return ztytktsppisetkykkbn;
    }

    public void setZtytktsppisetkykkbn(String pZtytktsppisetkykkbn) {
        ztytktsppisetkykkbn = pZtytktsppisetkykkbn;
    }

    private String ztyjyudmnsiskknsetkykkbn;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYJYUDMNSISKKNSETKYKKBN)
    public String getZtyjyudmnsiskknsetkykkbn() {
        return ztyjyudmnsiskknsetkykkbn;
    }

    public void setZtyjyudmnsiskknsetkykkbn(String pZtyjyudmnsiskknsetkykkbn) {
        ztyjyudmnsiskknsetkykkbn = pZtyjyudmnsiskknsetkykkbn;
    }

    private String ztyyobiv8x2;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV8X2)
    public String getZtyyobiv8x2() {
        return ztyyobiv8x2;
    }

    public void setZtyyobiv8x2(String pZtyyobiv8x2) {
        ztyyobiv8x2 = pZtyyobiv8x2;
    }

    private String ztysetaitesyono1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITESYONO1)
    public String getZtysetaitesyono1() {
        return ztysetaitesyono1;
    }

    public void setZtysetaitesyono1(String pZtysetaitesyono1) {
        ztysetaitesyono1 = pZtysetaitesyono1;
    }

    private String ztysetaitehokensyuruikigou1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITEHOKENSYURUIKIGOU1)
    public String getZtysetaitehokensyuruikigou1() {
        return ztysetaitehokensyuruikigou1;
    }

    public void setZtysetaitehokensyuruikigou1(String pZtysetaitehokensyuruikigou1) {
        ztysetaitehokensyuruikigou1 = pZtysetaitehokensyuruikigou1;
    }

    private String ztysetaitemrtisyuruikgu1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITEMRTISYURUIKGU1)
    public String getZtysetaitemrtisyuruikgu1() {
        return ztysetaitemrtisyuruikgu1;
    }

    public void setZtysetaitemrtisyuruikgu1(String pZtysetaitemrtisyuruikgu1) {
        ztysetaitemrtisyuruikgu1 = pZtysetaitemrtisyuruikgu1;
    }

    private String ztysetaitesiznmrtisyurui1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITESIZNMRTISYURUI1)
    public String getZtysetaitesiznmrtisyurui1() {
        return ztysetaitesiznmrtisyurui1;
    }

    public void setZtysetaitesiznmrtisyurui1(String pZtysetaitesiznmrtisyurui1) {
        ztysetaitesiznmrtisyurui1 = pZtysetaitesiznmrtisyurui1;
    }

    private String ztysetaitetignmrtisyurui1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITETIGNMRTISYURUI1)
    public String getZtysetaitetignmrtisyurui1() {
        return ztysetaitetignmrtisyurui1;
    }

    public void setZtysetaitetignmrtisyurui1(String pZtysetaitetignmrtisyurui1) {
        ztysetaitetignmrtisyurui1 = pZtysetaitetignmrtisyurui1;
    }

    private Long ztysetaitekihonbubuns1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITEKIHONBUBUNS1)
    public Long getZtysetaitekihonbubuns1() {
        return ztysetaitekihonbubuns1;
    }

    public void setZtysetaitekihonbubuns1(Long pZtysetaitekihonbubuns1) {
        ztysetaitekihonbubuns1 = pZtysetaitekihonbubuns1;
    }

    private Long ztysetgukitnknitjbrkhns1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETGUKITNKNITJBRKHNS1)
    public Long getZtysetgukitnknitjbrkhns1() {
        return ztysetgukitnknitjbrkhns1;
    }

    public void setZtysetgukitnknitjbrkhns1(Long pZtysetgukitnknitjbrkhns1) {
        ztysetgukitnknitjbrkhns1 = pZtysetgukitnknitjbrkhns1;
    }

    private Long ztysetaitesibous1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITESIBOUS1)
    public Long getZtysetaitesibous1() {
        return ztysetaitesibous1;
    }

    public void setZtysetaitesibous1(Long pZtysetaitesibous1) {
        ztysetaitesibous1 = pZtysetaitesibous1;
    }

    private Long ztysetgukitnknitjbrsbus1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETGUKITNKNITJBRSBUS1)
    public Long getZtysetgukitnknitjbrsbus1() {
        return ztysetgukitnknitjbrsbus1;
    }

    public void setZtysetgukitnknitjbrsbus1(Long pZtysetgukitnknitjbrsbus1) {
        ztysetgukitnknitjbrsbus1 = pZtysetgukitnknitjbrsbus1;
    }

    private Long ztysetaitesyuuseis1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITESYUUSEIS1)
    public Long getZtysetaitesyuuseis1() {
        return ztysetaitesyuuseis1;
    }

    public void setZtysetaitesyuuseis1(Long pZtysetaitesyuuseis1) {
        ztysetaitesyuuseis1 = pZtysetaitesyuuseis1;
    }

    private Long ztysetaiteharaikomip1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITEHARAIKOMIP1)
    public Long getZtysetaiteharaikomip1() {
        return ztysetaiteharaikomip1;
    }

    public void setZtysetaiteharaikomip1(Long pZtysetaiteharaikomip1) {
        ztysetaiteharaikomip1 = pZtysetaiteharaikomip1;
    }

    private Long ztysetaitesyukeiyakububunp1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITESYUKEIYAKUBUBUNP1)
    public Long getZtysetaitesyukeiyakububunp1() {
        return ztysetaitesyukeiyakububunp1;
    }

    public void setZtysetaitesyukeiyakububunp1(Long pZtysetaitesyukeiyakububunp1) {
        ztysetaitesyukeiyakububunp1 = pZtysetaitesyukeiyakububunp1;
    }

    private Long ztysetaitgukikzkmrtis1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITGUKIKZKMRTIS1)
    public Long getZtysetaitgukikzkmrtis1() {
        return ztysetaitgukikzkmrtis1;
    }

    public void setZtysetaitgukikzkmrtis1(Long pZtysetaitgukikzkmrtis1) {
        ztysetaitgukikzkmrtis1 = pZtysetaitgukikzkmrtis1;
    }

    private String ztysetaitetenkankykhyj1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITETENKANKYKHYJ1)
    public String getZtysetaitetenkankykhyj1() {
        return ztysetaitetenkankykhyj1;
    }

    public void setZtysetaitetenkankykhyj1(String pZtysetaitetenkankykhyj1) {
        ztysetaitetenkankykhyj1 = pZtysetaitetenkankykhyj1;
    }

    private Long ztysetaitesiteimhrkp1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITESITEIMHRKP1)
    public Long getZtysetaitesiteimhrkp1() {
        return ztysetaitesiteimhrkp1;
    }

    public void setZtysetaitesiteimhrkp1(Long pZtysetaitesiteimhrkp1) {
        ztysetaitesiteimhrkp1 = pZtysetaitesiteimhrkp1;
    }

    private Long ztysetaitesiteimsykykp1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITESITEIMSYKYKP1)
    public Long getZtysetaitesiteimsykykp1() {
        return ztysetaitesiteimsykykp1;
    }

    public void setZtysetaitesiteimsykykp1(Long pZtysetaitesiteimsykykp1) {
        ztysetaitesiteimsykykp1 = pZtysetaitesiteimsykykp1;
    }

    private String ztysetaitenkmrtisyurui1;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYSETAITENKMRTISYURUI1)
    public String getZtysetaitenkmrtisyurui1() {
        return ztysetaitenkmrtisyurui1;
    }

    public void setZtysetaitenkmrtisyurui1(String pZtysetaitenkmrtisyurui1) {
        ztysetaitenkmrtisyurui1 = pZtysetaitenkmrtisyurui1;
    }

    private String ztyyobiv18;

    @Column(name=GenZT_Sp2RnduyuSouseiritu1Ty.ZTYYOBIV18)
    public String getZtyyobiv18() {
        return ztyyobiv18;
    }

    public void setZtyyobiv18(String pZtyyobiv18) {
        ztyyobiv18 = pZtyyobiv18;
    }
}