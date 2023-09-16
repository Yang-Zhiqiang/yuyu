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
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.id.PKST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.meta.GenQST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.meta.QST_HoyuuMeisaiTyukeiyouItzHzn;

/**
 * 保有明細中継用一時保存テーブル テーブルのマッピング情報クラスで、 {@link ST_HoyuuMeisaiTyukeiyouItzHzn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_HoyuuMeisaiTyukeiyouItzHzn}</td><td colspan="3">保有明細中継用一時保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysrkijyunym ztysrkijyunym}</td><td>（中継用）数理用基準年月</td><td align="center">{@link PKST_HoyuuMeisaiTyukeiyouItzHzn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrkakutyoujobcd ztysrkakutyoujobcd}</td><td>（中継用）数理用拡張ジョブコード</td><td align="center">{@link PKST_HoyuuMeisaiTyukeiyouItzHzn ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">{@link PKST_HoyuuMeisaiTyukeiyouItzHzn ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyuukourecordlength ztyyuukourecordlength}</td><td>（中継用）有効レコード長</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrdwarea ztyrdwarea}</td><td>（中継用）ＲＤＷ領域</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyrecordkbn ztyrecordkbn}</td><td>（中継用）レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkaisigohyouji ztynenkinkaisigohyouji}</td><td>（中継用）年金開始後表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksgokurikosidhyj ztynksgokurikosidhyj}</td><td>（中継用）年金開始後繰越Ｄ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouym ztykeijyouym}</td><td>（中継用）計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidojiyukbn ztyidojiyukbn}</td><td>（中継用）異動事由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzougenkbn ztyzougenkbn}</td><td>（中継用）増減区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidourecordkbn ztyidourecordkbn}</td><td>（中継用）異動レコード区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeijyouctrlkbn ztykeijyouctrlkbn}</td><td>（中継用）計上コントロール区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhenkousyoriymd ztyhenkousyoriymd}</td><td>（中継用）変更処理年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykmfksnctr ztykykmfksnctr}</td><td>（中継用）契約ＭＦ更新ＣＴＲ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyrecordctr ztyrecordctr}</td><td>（中継用）レコードＣＴＲ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysuuriyoukouryokukaisiymd ztysuuriyoukouryokukaisiymd}</td><td>（中継用）数理用効力開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenymd ztydenymd}</td><td>（中継用）伝票日付</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybluekeizokuhyouji ztybluekeizokuhyouji}</td><td>（中継用）Ｂｌｕｅ継続表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x2 ztysuuriyouyobin1x2}</td><td>（中継用）数理用予備項目Ｎ１＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeikeijyoukbn ztytoukeikeijyoukbn}</td><td>（中継用）統計計上区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkiidouteiseikbn ztyzenkiidouteiseikbn}</td><td>（中継用）前期異動訂正区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsyym ztybsyym}</td><td>（中継用）募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkangokeiyakubosyuuym ztytenkangokeiyakubosyuuym}</td><td>（中継用）転換後契約募集年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidoujiyuucd ztyidoujiyuucd}</td><td>（中継用）異動事由コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoricd ztysyoricd}</td><td>（中継用）処理コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysekininteiseihyouji ztysekininteiseihyouji}</td><td>（中継用）責任訂正表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8 ztysuuriyouyobin8}</td><td>（中継用）数理用予備項目Ｎ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysihankibikinkbn ztysihankibikinkbn}</td><td>（中継用）四半期備金区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x3 ztysuuriyouyobin1x3}</td><td>（中継用）数理用予備項目Ｎ１＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino ztydatakanrino}</td><td>（中継用）データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyuruikigousedaikbn ztyhknsyuruikigousedaikbn}</td><td>（中継用）保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasipmenkbn ztysotodasipmenkbn}</td><td>（中継用）外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdssytikbn ztystdssytikbn}</td><td>（中継用）外出集定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdssnskbn ztystdssnskbn}</td><td>（中継用）外出診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasimanagehyouji ztysotodasimanagehyouji}</td><td>（中継用）外出満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasiphkbnmnoshyouji ztysotodasiphkbnmnoshyouji}</td><td>（中継用）外出Ｐ不可分見直表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdsstkjytkyuhyj ztystdsstkjytkyuhyj}</td><td>（中継用）外出新特条適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyousegmentkbn ztykbnkeiriyousegmentkbn}</td><td>（中継用）区分経理用セグメント区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykbnkeiriyourgnbnskkbn ztykbnkeiriyourgnbnskkbn}</td><td>（中継用）区分経理用利源分析区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuurisyuruicd ztysuurisyuruicd}</td><td>（中継用）数理種類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhosyoukinoukbn ztyhosyoukinoukbn}</td><td>（中継用）保障機能区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydaikbn ztydaikbn}</td><td>（中継用）大区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyuukbn ztytyuukbn}</td><td>（中継用）中区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoukbn ztysyoukbn}</td><td>（中継用）小区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysedaikbn ztysedaikbn}</td><td>（中継用）世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyharaikatakbn ztyharaikatakbn}</td><td>（中継用）払方区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaimnkkykhyj ztysaimnkkykhyj}</td><td>（中継用）才満期契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyannaifuyouriyuukbn ztyannaifuyouriyuukbn}</td><td>（中継用）案内不要理由区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytksyuannaikykkbn ztytksyuannaikykkbn}</td><td>（中継用）特殊案内契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysdpdkbn ztysdpdkbn}</td><td>（中継用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryouritukbn ztyryouritukbn}</td><td>（中継用）料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyao3tyou3sibousdatehyouji ztyao3tyou3sibousdatehyouji}</td><td>（中継用）青３長３死亡Ｓ建表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhihokensyaagev2 ztyhihokensyaagev2}</td><td>（中継用）被保険者年令Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnen ztydai2hhknnen}</td><td>（中継用）第２被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkbthsyumnryuhyouji ztytkbthsyumnryuhyouji}</td><td>（中継用）特別保障満了表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakupwaribikikbn ztysyukeiyakupwaribikikbn}</td><td>（中継用）主契約Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanwaribikikbn ztytenkanwaribikikbn}</td><td>（中継用）転換割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyuuhitutnknyuguryurtkbn ztyyuuhitutnknyuguryurtkbn}</td><td>（中継用）有配当転換優遇料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokujyoup ztytokujyoup}</td><td>（中継用）特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteizukisyukeiyakup ztysiteizukisyukeiyakup}</td><td>（中継用）指定月主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykihons ztykihons}</td><td>（中継用）基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysibous ztysibous}</td><td>（中継用）死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhenkougokihons ztyhenkougokihons}</td><td>（中継用）変更後基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhenkougosibous ztyhenkougosibous}</td><td>（中継用）変更後死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhenkouymd ztyhenkouymd}</td><td>（中継用）変更年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyentyoukikan ztyentyoukikan}</td><td>（中継用）延長期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonkyuuhukinsiteimd ztyseizonkyuuhukinsiteimd}</td><td>（中継用）生存給付金指定月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakusiharaikingaku ztysyukeiyakusiharaikingaku}</td><td>（中継用）主契約支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyatukaisisyatodouhukencd ztyatukaisisyatodouhukencd}</td><td>（中継用）扱支社都道府県コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakuhukasuu ztytokuyakuhukasuu}</td><td>（中継用）特約付加数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtydi2hknkknikoujihisyaage ztydi2hknkknikoujihisyaage}</td><td>（中継用）第２保険期間移行時被者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrimnentyoumaephrkkkn ztyhrimnentyoumaephrkkkn}</td><td>（中継用）払満延長前Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokubetuhosyoukikan ztytokubetuhosyoukikan}</td><td>（中継用）特別保障期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinmanryouage ztykousinmanryouage}</td><td>（中継用）更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrttekitkarihyj ztyknkuzusnzyrttekitkarihyj}</td><td>（中継用）健康増進乗率適用特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykuriagekurisagekbn ztykuriagekurisagekbn}</td><td>（中継用）繰上げ繰下げ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrizmjhknsyukigousdkbn ztyhrizmjhknsyukigousdkbn}</td><td>（中継用）払済時保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykrsgjhknsyukigousdkbn ztykrsgjhknsyukigousdkbn}</td><td>（中継用）繰下げ時保険種類記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysotodasisyouhinkaiteikbn ztysotodasisyouhinkaiteikbn}</td><td>（中継用）外出商品改定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv4 ztyyobiv4}</td><td>（中継用）予備項目Ｖ４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkans ztygoukeitenkans}</td><td>（中継用）合計転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeipbubuntenkans ztygoukeipbubuntenkans}</td><td>（中継用）合計Ｐ部分転換Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikisyuruikigou ztytenkanteikisyuruikigou}</td><td>（中継用）転換定期種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikikigousedaikbn ztytenkanteikikigousedaikbn}</td><td>（中継用）転換定期記号世代区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnkntiksotodasikusnkbn ztytnkntiksotodasikusnkbn}</td><td>（中継用）転換定期外出更新区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnkntikstdspmenkbn ztytnkntikstdspmenkbn}</td><td>（中継用）転換定期外出Ｐ免区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikikigouyobi ztytenkanteikikigouyobi}</td><td>（中継用）転換定期記号予備</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikikikan ztytenkanteikikikan}</td><td>（中継用）転換定期期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkanteikis ztygoukeitenkanteikis}</td><td>（中継用）合計転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknteikinkshrkkn ztytnknteikinkshrkkn}</td><td>（中継用）転換定期年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkansiharaikingaku ztytenkansiharaikingaku}</td><td>（中継用）転換支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnkntikshrkngk ztytnkntikshrkngk}</td><td>（中継用）転換定期支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkankaisuu ztytenkankaisuu}</td><td>（中継用）転換回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeitenkankakaku ztygoukeitenkankakaku}</td><td>（中継用）合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknkhnbbnjyuturt ztytnknkhnbbnjyuturt}</td><td>（中継用）転換基本部分充当率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtywnasigoukeitenkanteikis ztywnasigoukeitenkanteikis}</td><td>（中継用）Ｗなし合計転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknteikikousinmnryouage ztytnknteikikousinmnryouage}</td><td>（中継用）転換定期更新満了年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv5 ztyyobiv5}</td><td>（中継用）予備項目Ｖ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyujidatakanrino ztykanyujidatakanrino}</td><td>（中継用）加入時データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyujikykymd ztykanyujikykymd}</td><td>（中継用）加入時契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyuujihihokensyaage ztykanyuujihihokensyaage}</td><td>（中継用）加入時被保険者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanyuujitenkanhyouji ztykanyuujitenkanhyouji}</td><td>（中継用）加入時転換表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhsyuikktminaosikaisu ztyhsyuikktminaosikaisu}</td><td>（中継用）保障一括見直回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysknnjynbknsisnrt ztysknnjynbknsisnrt}</td><td>（中継用）責任準備金精算率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytkjykbn ztytkjykbn}</td><td>（中継用）特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakugenkikan ztysakugenkikan}</td><td>（中継用）削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyryoumasihyouten ztyryoumasihyouten}</td><td>（中継用）料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtysykyktkjyuryumsratehyj ztysykyktkjyuryumsratehyj}</td><td>（中継用）主契約特条料増レート表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykyktkjyuryumsrate ztysykyktkjyuryumsrate}</td><td>（中継用）主契約特条料増レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtydai2tokujyoukbn ztydai2tokujyoukbn}</td><td>（中継用）第２特条区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2sakugenkikan ztydai2sakugenkikan}</td><td>（中継用）第２削減期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2ryoumasihyouten ztydai2ryoumasihyouten}</td><td>（中継用）第２料増標点</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytokuteibuijyoukenhyouji ztytokuteibuijyoukenhyouji}</td><td>（中継用）特定部位条件表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteibuino1 ztytokuteibuino1}</td><td>（中継用）特定部位番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnpkkn1 ztyhtnpkkn1}</td><td>（中継用）不担保期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteibuino2 ztytokuteibuino2}</td><td>（中継用）特定部位番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnpkkn2 ztyhtnpkkn2}</td><td>（中継用）不担保期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymhituiryuyutktbijyknhyj ztymhituiryuyutktbijyknhyj}</td><td>（中継用）無配当医療用特定部位条件表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymuhaitouiryouyoutktbino1 ztymuhaitouiryouyoutktbino1}</td><td>（中継用）無配当医療用特定部位番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymuhaitouiryouyouhtnpkkn1 ztymuhaitouiryouyouhtnpkkn1}</td><td>（中継用）無配当医療用不担保期間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymuhaitouiryouyoutktbino2 ztymuhaitouiryouyoutktbino2}</td><td>（中継用）無配当医療用特定部位番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymuhaitouiryouyouhtnpkkn2 ztymuhaitouiryouyouhtnpkkn2}</td><td>（中継用）無配当医療用不担保期間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteizukipwarimasihyouji ztysiteizukipwarimasihyouji}</td><td>（中継用）指定月Ｐ割増表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwarimasisiteim1 ztypwarimasisiteim1}</td><td>（中継用）Ｐ割増指定月１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwarimasisiteim2 ztypwarimasisiteim2}</td><td>（中継用）Ｐ割増指定月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteimsykykpbairitu ztysiteimsykykpbairitu}</td><td>（中継用）指定月主契約Ｐ倍率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaisyuusiteiym ztysaisyuusiteiym}</td><td>（中継用）最終指定年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykykkitmttvkeisanym ztysykykkitmttvkeisanym}</td><td>（中継用）主契約既積立Ｖ計算年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykykkitmttsknnjynbkngk ztysykykkitmttsknnjynbkngk}</td><td>（中継用）主契約既積立責任準備金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydftumitatekingaku ztydftumitatekingaku}</td><td>（中継用）ＤＦ積立金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydftumimasikin ztydftumimasikin}</td><td>（中継用）ＤＦ積増金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyvbubundftenkankakaku ztyvbubundftenkankakaku}</td><td>（中継用）Ｖ部分ＤＦ転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydpbubundftenkankakaku ztydpbubundftenkankakaku}</td><td>（中継用）ＤＰ部分ＤＦ転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydftmttkngkitjbrbbn ztydftmttkngkitjbrbbn}</td><td>（中継用）ＤＦ積立金額一時払部分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhendous ztyhendous}</td><td>（中継用）変動Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhengakujigyounendomatucv ztyhengakujigyounendomatucv}</td><td>（中継用）変額事業年度末ＣＶ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibarais ztyitibuitijibarais}</td><td>（中継用）一部一時払Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibuitijibaraip ztyitibuitijibaraip}</td><td>（中継用）一部一時払Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyitibitjbrshrkngk ztyitibitjbrshrkngk}</td><td>（中継用）一部一時払支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeicv ztygoukeicv}</td><td>（中継用）合計ＣＶ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyminasicv ztyminasicv}</td><td>（中継用）みなしＣＶ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyloanfund ztyloanfund}</td><td>（中継用）ローンファンド</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaiteihosyougaku ztysaiteihosyougaku}</td><td>（中継用）最低保証額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhngksitihsyuyusykykp ztyhngksitihsyuyusykykp}</td><td>（中継用）変額最低保証用主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhijynbrivasbujsitihsyugk ztyhijynbrivasbujsitihsyugk}</td><td>（中継用）平準払ＶＡ死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhijynbrivamnkjsitihsyugk ztyhijynbrivamnkjsitihsyugk}</td><td>（中継用）平準払ＶＡ満期時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiinkbn ztysiinkbn}</td><td>（中継用）死因区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymudkaimasikihons ztymudkaimasikihons}</td><td>（中継用）ミューＤ買増基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaimasiymd ztykaimasiymd}</td><td>（中継用）買増年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaimasikikan ztykaimasikikan}</td><td>（中継用）買増期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhikitugikaimasis ztyhikitugikaimasis}</td><td>（中継用）引継買増Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymudkaimasisiharaikingaku ztymudkaimasisiharaikingaku}</td><td>（中継用）ミューＤ買増支払金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyszoukouryokukaisiymdx1 ztyszoukouryokukaisiymdx1}</td><td>（中継用）Ｓ増効力開始年月日＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszouhokensyuruikigoux1 ztyszouhokensyuruikigoux1}</td><td>（中継用）Ｓ増保険種類記号＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszoukigousedaikbnx1 ztyszoukigousedaikbnx1}</td><td>（中継用）Ｓ増記号世代区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszoukikanx1 ztyszoukikanx1}</td><td>（中継用）Ｓ増期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszouhihokensyaagex1 ztyszouhihokensyaagex1}</td><td>（中継用）Ｓ増被保険者年令＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszoudai2hihknsyaagex1 ztyszoudai2hihknsyaagex1}</td><td>（中継用）Ｓ増第２被保険者年令＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzoukasx1 ztyzoukasx1}</td><td>（中継用）増加Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennendozoukasx1 ztyzennendozoukasx1}</td><td>（中継用）前年度増加Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyszousiharaikingakux1 ztyszousiharaikingakux1}</td><td>（中継用）Ｓ増支払金額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyszoukouryokukaisiymdx2 ztyszoukouryokukaisiymdx2}</td><td>（中継用）Ｓ増効力開始年月日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszouhokensyuruikigoux2 ztyszouhokensyuruikigoux2}</td><td>（中継用）Ｓ増保険種類記号＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszoukigousedaikbnx2 ztyszoukigousedaikbnx2}</td><td>（中継用）Ｓ増記号世代区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszoukikanx2 ztyszoukikanx2}</td><td>（中継用）Ｓ増期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszouhihokensyaagex2 ztyszouhihokensyaagex2}</td><td>（中継用）Ｓ増被保険者年令＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszoudai2hihknsyaagex2 ztyszoudai2hihknsyaagex2}</td><td>（中継用）Ｓ増第２被保険者年令＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzoukasx2 ztyzoukasx2}</td><td>（中継用）増加Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzennendozoukasx2 ztyzennendozoukasx2}</td><td>（中継用）前年度増加Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyszousiharaikingakux2 ztyszousiharaikingakux2}</td><td>（中継用）Ｓ増支払金額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x5 ztysuuriyouyobin1x5}</td><td>（中継用）数理用予備項目Ｎ１＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1x6 ztysuuriyouyobin1x6}</td><td>（中継用）数理用予備項目Ｎ１＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrimngkizktkykpmenhyj ztyhrimngkizktkykpmenhyj}</td><td>（中継用）払満後継続特約Ｐ免表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyuustartym ztymisyuustartym}</td><td>（中継用）未収開始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymisyuukaisuu ztymisyuukaisuu}</td><td>（中継用）未収回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitjbrtkykkousnuktkarhyj ztyitjbrtkykkousnuktkarhyj}</td><td>（中継用）一時払特約更新受付有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygyousekihyoujis ztygyousekihyoujis}</td><td>（中継用）業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysykykgyusekihyjs ztysykykgyusekihyjs}</td><td>（中継用）主契約業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkangyousekihyoujis ztytenkangyousekihyoujis}</td><td>（中継用）転換業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknteikigyousekihyjs ztytnknteikigyousekihyjs}</td><td>（中継用）転換定期業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnkndpbbngyuskhyjs ztytnkndpbbngyuskhyjs}</td><td>（中継用）転換ＤＰ部分業績表示Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykykjyoutai ztykykjyoutai}</td><td>（中継用）契約状態</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenhukakbn ztypmenhukakbn}</td><td>（中継用）Ｐ免付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinkbn ztykousinkbn}</td><td>（中継用）更新区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymankiyoteikbn ztymankiyoteikbn}</td><td>（中継用）満期予定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykyktikmnkyoteikbn ztysykyktikmnkyoteikbn}</td><td>（中継用）主契約定期満期予定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknsykykkhnmnkytikbn ztytnknsykykkhnmnkytikbn}</td><td>（中継用）転換主契約基本満期予定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknsykyktikmnkytikbn ztytnknsykyktikmnkytikbn}</td><td>（中継用）転換主契約定期満期予定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikimankiyoteikbn ztytenkanteikimankiyoteikbn}</td><td>（中継用）転換定期満期予定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszoumankiyoteikbnx1 ztyszoumankiyoteikbnx1}</td><td>（中継用）Ｓ増満期予定区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszoumankiyoteikbnx2 ztyszoumankiyoteikbnx2}</td><td>（中継用）Ｓ増満期予定区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvestingmankiyoteikbn ztyvestingmankiyoteikbn}</td><td>（中継用）ベスティング満期予定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvkeisanhyouji ztyvkeisanhyouji}</td><td>（中継用）Ｖ計算表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukisinkeiyakuhyouji ztytoukisinkeiyakuhyouji}</td><td>（中継用）当期新契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykykhokenhoutekiyouhyj ztysykykhokenhoutekiyouhyj}</td><td>（中継用）主契約保険法適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuteijyoutaihushrhyj ztytokuteijyoutaihushrhyj}</td><td>（中継用）特定状態不支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyytirrthndsysnmnskaisuu ztyytirrthndsysnmnskaisuu}</td><td>（中継用）予定利率変動終身見直回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin3 ztysuuriyouyobin3}</td><td>（中継用）数理用予備項目Ｎ３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin11 ztysuuriyouyobin11}</td><td>（中継用）数理用予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywnasigoukeitenkankakaku ztywnasigoukeitenkankakaku}</td><td>（中継用）Ｗなし合計転換価格</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11 ztyyobin11}</td><td>（中継用）予備項目Ｎ１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x2 ztyyobin11x2}</td><td>（中継用）予備項目Ｎ１１＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x3 ztyyobin11x3}</td><td>（中継用）予備項目Ｎ１１＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytukibaraikansantokujyoup ztytukibaraikansantokujyoup}</td><td>（中継用）月払換算特条Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnkngkykkssnkijyuym ztytnkngkykkssnkijyuym}</td><td>（中継用）転換後契約決算計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaiteihosyouhyouji ztysaiteihosyouhyouji}</td><td>（中継用）最低保証表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin8x2 ztysuuriyouyobin8x2}</td><td>（中継用）数理用予備項目Ｎ８＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin14 ztysuuriyouyobin14}</td><td>（中継用）数理用予備項目Ｎ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrimngtkykphrkkaisuukbn ztyhrimngtkykphrkkaisuukbn}</td><td>（中継用）払満後特約Ｐ払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrimngtkykphrkkirkbn ztyhrimngtkykphrkkirkbn}</td><td>（中継用）払満後特約Ｐ払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrimngtkykpryurtkbn ztyhrimngtkykpryurtkbn}</td><td>（中継用）払満後特約Ｐ料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv13 ztyyobiv13}</td><td>（中継用）予備項目Ｖ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyidoujisaiteihosyoukngk ztyidoujisaiteihosyoukngk}</td><td>（中継用）異動時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyidoujisaiteihosyoucost ztyidoujisaiteihosyoucost}</td><td>（中継用）異動時最低保証コスト</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysinhokenfundtumitatekin ztysinhokenfundtumitatekin}</td><td>（中継用）新保険ファンド積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymsyuptusshkgkaiykhnrikn ztymsyuptusshkgkaiykhnrikn}</td><td>（中継用）未収Ｐ等差引後解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthndugtnkgetumatuv ztyrrthndugtnkgetumatuv}</td><td>（中継用）利率変動型年金月末Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthndnksaiteihosyonkgns ztyrrthndnksaiteihosyonkgns}</td><td>（中継用）利率変動年金最低保証年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthendougatanksibous ztyrrthendougatanksibous}</td><td>（中継用）利率変動型年金死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyalmyousohutomeisyoukbn ztyalmyousohutomeisyoukbn}</td><td>（中継用）ＡＬＭ用ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnkyksoftmeisyoukbn ztysnkyksoftmeisyoukbn}</td><td>（中継用）新契約ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysoftmeisyoukbn ztysoftmeisyoukbn}</td><td>（中継用）ソフト名称区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjitokujyouarihyj ztykykjitokujyouarihyj}</td><td>（中継用）契約時特条有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybnkttnknkbn ztybnkttnknkbn}</td><td>（中継用）分割転換区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanminaosikbn ztytenkanminaosikbn}</td><td>（中継用）転換見直区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysoujikeitenkankbn ztysoujikeitenkankbn}</td><td>（中継用）相似形転換区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinkaisinendo ztynenkinkaisinendo}</td><td>（中継用）年金開始年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkingatakbn ztynenkingatakbn}</td><td>（中継用）年金型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynknshry ztynknshry}</td><td>（中継用）年金支払期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyheiyoubaraikeiyakukbn ztyheiyoubaraikeiyakukbn}</td><td>（中継用）併用払契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynenkinmaruteihukakbn ztynenkinmaruteihukakbn}</td><td>（中継用）年金マル定付加区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinseizonmrtiarihyj ztysinseizonmrtiarihyj}</td><td>（中継用）新生存マル定有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysnkykyouibokijyukbn ztysnkykyouibokijyukbn}</td><td>（中継用）新契約用異募計上区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokusitujyuusitusetkbn ztytokusitujyuusitusetkbn}</td><td>（中継用）特疾重疾セット区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiktsyuknbyugnhsyunshyj ztysiktsyuknbyugnhsyunshyj}</td><td>（中継用）生活習慣病がん保障無表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmensugugtganhsyunshyj ztypmensugugtganhsyunshyj}</td><td>（中継用）Ｐ免総合型がん保障無表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytkykgyousekihyjszerohyj ztytkykgyousekihyjszerohyj}</td><td>（中継用）特約業績表示Ｓゼロ表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin7 ztysuuriyouyobin7}</td><td>（中継用）数理用予備項目Ｎ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyussaikeitaikbn ztysyussaikeitaikbn}</td><td>（中継用）出再形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybosyuukeitaikbn ztybosyuukeitaikbn}</td><td>（中継用）募集形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisosikicd ztyaatukaisosikicd}</td><td>（中継用）Ａ扱者組織コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaikojincd ztyaatukaikojincd}</td><td>（中継用）Ａ扱者個人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybsydrtencd ztybsydrtencd}</td><td>（中継用）募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtycifcd ztycifcd}</td><td>（中継用）ＣＩＦコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobiv8 ztysuuriyouyobiv8}</td><td>（中継用）数理用予備項目Ｖ８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinsakbn ztysinsakbn}</td><td>（中継用）診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hihokensyasinsakbn ztydai2hihokensyasinsakbn}</td><td>（中継用）第２被保険者診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeiyousinsakbn ztytoukeiyousinsakbn}</td><td>（中継用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2toukeiyousinsakbn ztydai2toukeiyousinsakbn}</td><td>（中継用）第２統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyketteikijyunkanwakbn ztyketteikijyunkanwakbn}</td><td>（中継用）決定基準緩和区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonsibouhyoukbn ztykihonsibouhyoukbn}</td><td>（中継用）基本死亡表区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikisibouhyoukbn ztyteikisibouhyoukbn}</td><td>（中継用）定期死亡表区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotasibouhyoukbn ztysonotasibouhyoukbn}</td><td>（中継用）その他死亡表区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymrarihyj ztymrarihyj}</td><td>（中継用）ＭＲ有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysentakujyouhouarihyouji ztysentakujyouhouarihyouji}</td><td>（中継用）選択情報有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydugktnknsntkhuhukbn ztydugktnknsntkhuhukbn}</td><td>（中継用）同額転換選択方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygengakutenkankykhyj ztygengakutenkankykhyj}</td><td>（中継用）減額転換契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjidoukousinkykkanyuuymd ztyjidoukousinkykkanyuuymd}</td><td>（中継用）自動更新契約加入年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaikohtnknkykkykymd ztysaikohtnknkykkykymd}</td><td>（中継用）最古被転換契約契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykousinmaesykyksburtkbn ztykousinmaesykyksburtkbn}</td><td>（中継用）更新前主契約死亡率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnkykhyj ztyhjnkykhyj}</td><td>（中継用）法人契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyanniskcd ztyanniskcd}</td><td>（中継用）案内先コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjncd ztyhjncd}</td><td>（中継用）法人コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhjnjigyosyocd ztyhjnjigyosyocd}</td><td>（中継用）法人事業所コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaihokenno ztysaihokenno}</td><td>（中継用）再保険番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettikekkacd ztydakuhikettikekkacd}</td><td>（中継用）諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2dakuhiketteikekkacd ztydai2dakuhiketteikekkacd}</td><td>（中継用）第２諾否決定結果コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypmenkbnv2 ztypmenkbnv2}</td><td>（中継用）Ｐ免区分Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiboukyuuhukin ztysiboukyuuhukin}</td><td>（中継用）死亡給付金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjyudthumeharaitkykhkhyj ztyjyudthumeharaitkykhkhyj}</td><td>（中継用）重度痴呆前払特約付加表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhaitoukbn ztyhaitoukbn}</td><td>（中継用）配当区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnentysihyj ztyhhknnentysihyj}</td><td>（中継用）被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2hhknnentysihyj ztydai2hhknnentysihyj}</td><td>（中継用）第２被保険者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaagetyouseihyj ztykyksyaagetyouseihyj}</td><td>（中継用）契約者年令調整表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykituenkbn ztykituenkbn}</td><td>（中継用）喫煙区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykituenhonsuu ztykituenhonsuu}</td><td>（中継用）喫煙本数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymusentakukeiyakukbn ztymusentakukeiyakukbn}</td><td>（中継用）無選択契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6x2 ztyyobiv6x2}</td><td>（中継用）予備項目Ｖ６＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivingneedstkykarihyj ztylivingneedstkykarihyj}</td><td>（中継用）リビングニーズ特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylivingneedssiharaihyouji ztylivingneedssiharaihyouji}</td><td>（中継用）リビングニーズ支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylnseikyuuymd ztylnseikyuuymd}</td><td>（中継用）ＬＮ請求年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtylnshrgenincd ztylnshrgenincd}</td><td>（中継用）ＬＮ支払原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydakuhikettisyacd ztydakuhikettisyacd}</td><td>（中継用）諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2dakuhiketteisyacd ztydai2dakuhiketteisyacd}</td><td>（中継用）第２諾否決定者コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansapotokuyakuarihyouji ztygansapotokuyakuarihyouji}</td><td>（中継用）がんサポ特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygnspshrhyj ztygnspshrhyj}</td><td>（中継用）がんサポ支払表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygansaposeikyuuymd ztygansaposeikyuuymd}</td><td>（中継用）がんサポ請求年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygnspshrgenincd ztygnspshrgenincd}</td><td>（中継用）がんサポ支払原因コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv3x2 ztyyobiv3x2}</td><td>（中継用）予備項目Ｖ３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytargetmokuhyouritu ztytargetmokuhyouritu}</td><td>（中継用）ターゲット目標率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyautoswitchmokuhyouritu ztyautoswitchmokuhyouritu}</td><td>（中継用）オートスイッチ目標率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitatekinitenarihyj ztytumitatekinitenarihyj}</td><td>（中継用）積立金移転有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitatekinitenkaisuu ztytumitatekinitenkaisuu}</td><td>（中継用）積立金移転回数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino2 ztydatakanrino2}</td><td>（中継用）データ管理番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydatakanrino3 ztydatakanrino3}</td><td>（中継用）データ管理番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrttekinendo ztyknkuzusnzyrttekinendo}</td><td>（中継用）健康増進乗率適用年度</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrt ztyknkuzusnzyrt}</td><td>（中継用）健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrtx2 ztyknkuzusnzyrtx2}</td><td>（中継用）健康増進乗率＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyknkuzusnzyrtx3 ztyknkuzusnzyrtx3}</td><td>（中継用）健康増進乗率＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkeiyakujiknkuzusnzyrt ztysinkeiyakujiknkuzusnzyrt}</td><td>（中継用）新契約時健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanjiknkuzusnzyrt ztytenkanjiknkuzusnzyrt}</td><td>（中継用）転換時健康増進乗率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkeiyakujivithkhyouji ztysinkeiyakujivithkhyouji}</td><td>（中継用）新契約時Ｖｉｔ保険表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjivithukusuukykhyj ztykykjivithukusuukykhyj}</td><td>（中継用）契約時Ｖｉｔ複数契約表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin9x2 ztysuuriyouyobin9x2}</td><td>（中継用）数理用予備項目Ｎ９＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwrbksidhitekiyouhyj ztypwrbksidhitekiyouhyj}</td><td>（中継用）保険料割引制度非適用表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin9 ztysuuriyouyobin9}</td><td>（中継用）数理用予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x7 ztysuuriyouyobin10x7}</td><td>（中継用）数理用予備項目Ｎ１０＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x8 ztysuuriyouyobin10x8}</td><td>（中継用）数理用予備項目Ｎ１０＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x9 ztysuuriyouyobin10x9}</td><td>（中継用）数理用予備項目Ｎ１０＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitatekinitenbubun ztytumitatekinitenbubun}</td><td>（中継用）積立金移転部分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysagakusknnjynbknzndk ztysagakusknnjynbknzndk}</td><td>（中継用）差額責任準備金残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x5 ztyyobin11x5}</td><td>（中継用）予備項目Ｎ１１＿５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x6 ztyyobin11x6}</td><td>（中継用）予備項目Ｎ１１＿６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x7 ztyyobin11x7}</td><td>（中継用）予備項目Ｎ１１＿７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x8 ztyyobin11x8}</td><td>（中継用）予備項目Ｎ１１＿８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x9 ztyyobin11x9}</td><td>（中継用）予備項目Ｎ１１＿９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x10 ztyyobin11x10}</td><td>（中継用）予備項目Ｎ１１＿１０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x11 ztyyobin11x11}</td><td>（中継用）予備項目Ｎ１１＿１１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x12 ztyyobin11x12}</td><td>（中継用）予備項目Ｎ１１＿１２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x13 ztyyobin11x13}</td><td>（中継用）予備項目Ｎ１１＿１３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x14 ztyyobin11x14}</td><td>（中継用）予備項目Ｎ１１＿１４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x15 ztyyobin11x15}</td><td>（中継用）予備項目Ｎ１１＿１５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x16 ztyyobin11x16}</td><td>（中継用）予備項目Ｎ１１＿１６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x17 ztyyobin11x17}</td><td>（中継用）予備項目Ｎ１１＿１７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbn ztyzyrthntiyustatuskbn}</td><td>（中継用）乗率判定用ステータス区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx2 ztyzyrthntiyustatuskbnx2}</td><td>（中継用）乗率判定用ステータス区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx3 ztyzyrthntiyustatuskbnx3}</td><td>（中継用）乗率判定用ステータス区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx4 ztyzyrthntiyustatuskbnx4}</td><td>（中継用）乗率判定用ステータス区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzyrthntiyustatuskbnx5 ztyzyrthntiyustatuskbnx5}</td><td>（中継用）乗率判定用ステータス区分＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10 ztyyobiv10}</td><td>（中継用）予備項目Ｖ１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv15x2 ztyyobiv15x2}</td><td>（中継用）予備項目Ｖ１５＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv15x3 ztyyobiv15x3}</td><td>（中継用）予備項目Ｖ１５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv15x4 ztyyobiv15x4}</td><td>（中継用）予備項目Ｖ１５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaserate1 ztykawaserate1}</td><td>（中継用）為替レート１</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd1 ztykawaseratetekiyouymd1}</td><td>（中継用）為替レート適用年月日１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaserate2 ztykawaserate2}</td><td>（中継用）為替レート２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd2 ztykawaseratetekiyouymd2}</td><td>（中継用）為替レート適用年月日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjikawaserate ztykykjikawaserate}</td><td>（中継用）契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykykjikawaseratetkyuymd ztykykjikawaseratetkyuymd}</td><td>（中継用）契約時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvatyouseigow ztymvatyouseigow}</td><td>（中継用）ＭＶＡ調整後Ｗ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtymvakeisanjisknnjynbkn ztymvakeisanjisknnjynbkn}</td><td>（中継用）ＭＶＡ計算時責任準備金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakukoujyoritu ztykaiyakukoujyoritu}</td><td>（中継用）解約控除率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrendouritu ztyrendouritu}</td><td>（中継用）連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysrkaiyakusjkkktyouseirrt ztysrkaiyakusjkkktyouseirrt}</td><td>（中継用）数理用解約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysrkyksjkkktyouseiriritu ztysrkyksjkkktyouseiriritu}</td><td>（中継用）数理用契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtymvakeisankijyunymd ztymvakeisankijyunymd}</td><td>（中継用）ＭＶＡ計算基準年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvatyouseikou ztymvatyouseikou}</td><td>（中継用）ＭＶＡ調整項</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyukngk ztyenkdtsbujsitihsyukngk}</td><td>（中継用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyucost ztyenkdtsbujsitihsyucost}</td><td>（中継用）円貨建死亡時最低保証コスト</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyuarihyj ztyenkdtsbujsitihsyuarihyj}</td><td>（中継用）円貨建死亡時最低保証あり表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakujiyoteiriritu ztykeiyakujiyoteiriritu}</td><td>（中継用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytumitateriritu ztytumitateriritu}</td><td>（中継用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykaigomaebaraitkykarihyj ztykaigomaebaraitkykarihyj}</td><td>（中継用）介護前払特約あり表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibouhyoukbn ztysibouhyoukbn}</td><td>（中継用）死亡表区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynyuukintuukakbn ztynyuukintuukakbn}</td><td>（中継用）入金通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiharaituukakbn ztysiharaituukakbn}</td><td>（中継用）支払通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtywyendttargetmokuhyouritu ztywyendttargetmokuhyouritu}</td><td>（中継用）円建Ｗターゲット目標率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuurendourate ztysisuurendourate}</td><td>（中継用）指数連動部分割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuukbn ztysisuukbn}</td><td>（中継用）指数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteirituikouhyouji ztyteirituikouhyouji}</td><td>（中継用）定率移行表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrdai1hknkkn ztysrdai1hknkkn}</td><td>（中継用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x11 ztysuuriyouyobin10x11}</td><td>（中継用）数理用予備項目Ｎ１０＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritujygn ztytmttknzoukaritujygn}</td><td>（中継用）積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysetteibairitu ztysetteibairitu}</td><td>（中継用）設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytykzenoutouymdsisuu ztytykzenoutouymdsisuu}</td><td>（中継用）直前応当日指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykimatusisuu ztykimatusisuu}</td><td>（中継用）期末指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytuukasyukbn ztytuukasyukbn}</td><td>（中継用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv2 ztyyobiv2}</td><td>（中継用）予備項目Ｖ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenkadatekihons ztyyenkadatekihons}</td><td>（中継用）円貨建基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysitihsyumegkdtsibous ztysitihsyumegkdtsibous}</td><td>（中継用）最低保証前外貨建死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyenkdtssrentumitatekin ztyenkdtssrentumitatekin}</td><td>（中継用）円貨建指数連動部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysisuurentumitatekin ztysisuurentumitatekin}</td><td>（中継用）指数連動部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynksjitirttumitatekin ztynksjitirttumitatekin}</td><td>（中継用）年金開始時定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykimatutirttumitatekin ztykimatutirttumitatekin}</td><td>（中継用）期末定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatejyuutoup ztygaikadatejyuutoup}</td><td>（中継用）外貨建充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyendttargetkijyunkingaku ztyyendttargetkijyunkingaku}</td><td>（中継用）円建ターゲット基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobiv7 ztyyobiv7}</td><td>（中継用）予備項目Ｖ７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysitivkisnyukykjikwsrate ztysitivkisnyukykjikwsrate}</td><td>（中継用）最低Ｖ計算用契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysisuurentyokugotmttkn ztysisuurentyokugotmttkn}</td><td>（中継用）指数連動部分直後積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyoteiririturironbase ztyyoteiririturironbase}</td><td>（中継用）予定利率（理論ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritujtnyknbase ztyyoteiriritujtnyknbase}</td><td>（中継用）予定利率（実入金ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykihrkmpjtnyknbase ztykihrkmpjtnyknbase}</td><td>（中継用）既払込Ｐ（実入金ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuptumitatekin ztysyuptumitatekin}</td><td>（中継用）主契約保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuptumitatekingsc ztysyuptumitatekingsc}</td><td>（中継用）主契約保険料積立金（月初）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatenkgns ztygaikadatenkgns}</td><td>（中継用）外貨建年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym2 ztyjikaipjyuutouym2}</td><td>（中継用）次回Ｐ充当年月２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyobin9 ztysuuriyobin9}</td><td>（中継用）数理予備項目Ｎ９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtygessitumitatekin ztygessitumitatekin}</td><td>（中継用）月始積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatetougetujuutoup ztygaikadatetougetujuutoup}</td><td>（中継用）外貨建当月充当Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykihrkmpmsukisymbase ztykihrkmpmsukisymbase}</td><td>（中継用）既払込Ｐ（未収開始月ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykeisanhanteiyoutmttkn ztykeisanhanteiyoutmttkn}</td><td>（中継用）計算判定用積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygtmtv ztygtmtv}</td><td>（中継用）月末Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyzettaisibouritu ztyzettaisibouritu}</td><td>（中継用）絶対死亡率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysoutaisibouritu ztysoutaisibouritu}</td><td>（中継用）相対死亡率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysoutaikaiyakuritu ztysoutaikaiyakuritu}</td><td>（中継用）相対解約率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyvhireilritu2 ztyvhireilritu2}</td><td>（中継用）Ｖ比例Ｌ率２</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyphireialpha ztyphireialpha}</td><td>（中継用）Ｐ比例α</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyphireibeta ztyphireibeta}</td><td>（中継用）Ｐ比例β</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyphireiganma ztyphireiganma}</td><td>（中継用）Ｐ比例γ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyphireilwrbkritu ztyphireilwrbkritu}</td><td>（中継用）Ｐ比例Ｌ割引率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyoteiriritumsukisymbase ztyyoteiriritumsukisymbase}</td><td>（中継用）予定利率（未収開始月ベース）</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrrthnduhknvkisovkisnyu1 ztyrrthnduhknvkisovkisnyu1}</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthnduhknvkisovkisnyu2 ztyrrthnduhknvkisovkisnyu2}</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthnduhknvkisovkisnyu3 ztyrrthnduhknvkisovkisnyu3}</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthnduhknvkisovkisnyu4 ztyrrthnduhknvkisovkisnyu4}</td><td>（中継用）利率変動保険Ｖ基礎Ｖ計算用４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyrrthnduhknvkiso ztyrrthnduhknvkiso}</td><td>（中継用）利率変動保険Ｖ基礎Ｖ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytumitatekin ztytumitatekin}</td><td>（中継用）積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykiharaikomip ztykiharaikomip}</td><td>（中継用）既払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatesyukeiyakup ztygaikadatesyukeiyakup}</td><td>（中継用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykykkjmmvatyouseigow ztykykkjmmvatyouseigow}</td><td>（中継用）解約控除前ＭＶＡ調整後Ｗ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x39 ztyyobin11x39}</td><td>（中継用）予備項目Ｎ１１＿３９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x41 ztyyobin11x41}</td><td>（中継用）予備項目Ｎ１１＿４１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x42 ztyyobin11x42}</td><td>（中継用）予備項目Ｎ１１＿４２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x43 ztyyobin11x43}</td><td>（中継用）予備項目Ｎ１１＿４３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x44 ztyyobin11x44}</td><td>（中継用）予備項目Ｎ１１＿４４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x45 ztyyobin11x45}</td><td>（中継用）予備項目Ｎ１１＿４５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin15x3 ztysuuriyouyobin15x3}</td><td>（中継用）数理用予備項目Ｎ１５＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin15x4 ztysuuriyouyobin15x4}</td><td>（中継用）数理用予備項目Ｎ１５＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin15x5 ztysuuriyouyobin15x5}</td><td>（中継用）数理用予備項目Ｎ１５＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin15x6 ztysuuriyouyobin15x6}</td><td>（中継用）数理用予備項目Ｎ１５＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv14 ztyyobiv14}</td><td>（中継用）予備項目Ｖ１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyhhknsydouituhyouji ztykyksyhhknsydouituhyouji}</td><td>（中継用）契約者被保険者同一表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaskinmeino ztykyksyaskinmeino}</td><td>（中継用）契約者索引名番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeikihons ztygoukeikihons}</td><td>（中継用）合計基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeigyousekihyjsibous ztygoukeigyousekihyjsibous}</td><td>（中継用）合計業績表示死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyalmyousibous ztyalmyousibous}</td><td>（中継用）ＡＬＭ用死亡Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyharaikomip ztyharaikomip}</td><td>（中継用）払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysiteizukiharaikomip ztysiteizukiharaikomip}</td><td>（中継用）指定月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaisyuusiteimhrkp ztysaisyuusiteimhrkp}</td><td>（中継用）最終指定月払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeinenbaraikansanp ztygoukeinenbaraikansanp}</td><td>（中継用）合計年払換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygyousekihyoujisrank ztygyousekihyoujisrank}</td><td>（中継用）業績表示Ｓランク</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikibairitu ztyteikibairitu}</td><td>（中継用）定期倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytenkangodatakanrino ztytenkangodatakanrino}</td><td>（中継用）転換後データ管理番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaitekykdatakanrino1 ztyaitekykdatakanrino1}</td><td>（中継用）相手契約データ管理番号１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaitekykdatakanrino2 ztyaitekykdatakanrino2}</td><td>（中継用）相手契約データ管理番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknsyokaipcashlesshyj ztytnknsyokaipcashlesshyj}</td><td>（中継用）転換初回Ｐキャッシュレス表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipannaikbn ztysyokaipannaikbn}</td><td>（中継用）初回Ｐ案内区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukaisiymd ztyzennoukaisiymd}</td><td>（中継用）前納開始年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzennoukikan ztyzennoukikan}</td><td>（中継用）前納期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseizonkyuuhukinsiteiy ztyseizonkyuuhukinsiteiy}</td><td>（中継用）生存給付金指定年</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyalmyouseizonkyhknsiteimd ztyalmyouseizonkyhknsiteimd}</td><td>（中継用）ＡＬＭ用生存給付金指定月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjikaipjyuutouym ztyjikaipjyuutouym}</td><td>（中継用）次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjiqpackhyj ztykykjiqpackhyj}</td><td>（中継用）契約時Ｑパック表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn3x1 ztyhktgtikkikkkn3x1}</td><td>（中継用）引継定期経過期間３＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn3x2 ztyhktgtikkikkkn3x2}</td><td>（中継用）引継定期経過期間３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn3x3 ztyhktgtikkikkkn3x3}</td><td>（中継用）引継定期経過期間３＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkkn3x4 ztyhktgtikkikkkn3x4}</td><td>（中継用）引継定期経過期間３＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadkeisankbnx1 ztykappadkeisankbnx1}</td><td>（中継用）カッパーＤ計算区分＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadkeisankbnx2 ztykappadkeisankbnx2}</td><td>（中継用）カッパーＤ計算区分＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadkeisankbnx3 ztykappadkeisankbnx3}</td><td>（中継用）カッパーＤ計算区分＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadkeisankbnx4 ztykappadkeisankbnx4}</td><td>（中継用）カッパーＤ計算区分＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin2 ztysuuriyouyobin2}</td><td>（中継用）数理用予備項目Ｎ２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6x3 ztyyobiv6x3}</td><td>（中継用）予備項目Ｖ６＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykimatuvyoutumimasikin ztykimatuvyoutumimasikin}</td><td>（中継用）期末Ｖ用積増金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykmtvyusnhknfundtmttkin ztykmtvyusnhknfundtmttkin}</td><td>（中継用）期末Ｖ用新保険ファンド積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeinenkansanp3x1 ztygoukeinenkansanp3x1}</td><td>（中継用）合計年換算Ｐ３＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeinenkansanp3x2 ztygoukeinenkansanp3x2}</td><td>（中継用）合計年換算Ｐ３＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeinenkansanp3x3 ztygoukeinenkansanp3x3}</td><td>（中継用）合計年換算Ｐ３＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygoukeinenkansanp3x4 ztygoukeinenkansanp3x4}</td><td>（中継用）合計年換算Ｐ３＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykmtvyuhijynbritmttkin ztykmtvyuhijynbritmttkin}</td><td>（中継用）期末Ｖ用平準払積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykimatuvyouitjbrtmttkin ztykimatuvyouitjbrtmttkin}</td><td>（中継用）期末Ｖ用一時払積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x26 ztyyobin11x26}</td><td>（中継用）予備項目Ｎ１１＿２６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x27 ztyyobin11x27}</td><td>（中継用）予備項目Ｎ１１＿２７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x28 ztyyobin11x28}</td><td>（中継用）予備項目Ｎ１１＿２８</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x29 ztyyobin11x29}</td><td>（中継用）予備項目Ｎ１１＿２９</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x30 ztyyobin11x30}</td><td>（中継用）予備項目Ｎ１１＿３０</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x31 ztyyobin11x31}</td><td>（中継用）予備項目Ｎ１１＿３１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x32 ztyyobin11x32}</td><td>（中継用）予備項目Ｎ１１＿３２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x33 ztyyobin11x33}</td><td>（中継用）予備項目Ｎ１１＿３３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhaitouyouloadingkijyuns ztyhaitouyouloadingkijyuns}</td><td>（中継用）配当用ローディング基準Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytouduketorihouhoukbn ztytouduketorihouhoukbn}</td><td>（中継用）当Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytumitated ztytumitated}</td><td>（中継用）積立Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykariwariated ztykariwariated}</td><td>（中継用）仮割当Ｄ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokuzensiharaikijitu ztytyokuzensiharaikijitu}</td><td>（中継用）直前支払期日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyokuzentuusanhanteis ztytyokuzentuusanhanteis}</td><td>（中継用）直前通算判定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugosiharaikijitu ztytyokugosiharaikijitu}</td><td>（中継用）直後支払期日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyokugotuusanhanteis ztytyokugotuusanhanteis}</td><td>（中継用）直後通算判定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugokyuuhutaisyous ztytyokugokyuuhutaisyous}</td><td>（中継用）直後給付対象Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytyokugocbkingaku ztytyokugocbkingaku}</td><td>（中継用）直後ＣＢ金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyokaisiharaikijitu ztysyokaisiharaikijitu}</td><td>（中継用）初回支払期日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaituusanhanteis ztysyokaituusanhanteis}</td><td>（中継用）初回通算判定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtycbnayosetuusanhanteis ztycbnayosetuusanhanteis}</td><td>（中継用）ＣＢ名寄せ通算判定Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhitenkankeiyakusuu ztyhitenkankeiyakusuu}</td><td>（中継用）被転換契約数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygoukeipbubuntenkanteikis ztygoukeipbubuntenkanteikis}</td><td>（中継用）合計Ｐ部分転換定期Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysaidaihktgtikkikkkn ztysaidaihktgtikkikkkn}</td><td>（中継用）最大引継定期経過期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisyutnknhktgkujygk ztysisyutnknhktgkujygk}</td><td>（中継用）最終転換引継控除額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x34 ztyyobin11x34}</td><td>（中継用）予備項目Ｎ１１＿３４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkykymdx1 ztyhtnknkykkykymdx1}</td><td>（中継用）被転換契約契約年月日＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnkntkbtdkisnyusx1 ztytnkntkbtdkisnyusx1}</td><td>（中継用）転換特別Ｄ計算用Ｓ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknkaiykkujytksux1 ztytnknkaiykkujytksux1}</td><td>（中継用）転換解約控除月数＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknkaiykkujygkx1 ztytnknkaiykkujygkx1}</td><td>（中継用）転換解約控除額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikihyoujix1 ztytenkanteikihyoujix1}</td><td>（中継用）転換定期表示＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyknenknsnpx1 ztyhtnknkyknenknsnpx1}</td><td>（中継用）被転換契約年換算Ｐ＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkknx1 ztyhktgtikkikkknx1}</td><td>（中継用）引継定期経過期間＿１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkykymdx2 ztyhtnknkykkykymdx2}</td><td>（中継用）被転換契約契約年月日＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnkntkbtdkisnyusx2 ztytnkntkbtdkisnyusx2}</td><td>（中継用）転換特別Ｄ計算用Ｓ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknkaiykkujytksux2 ztytnknkaiykkujytksux2}</td><td>（中継用）転換解約控除月数＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknkaiykkujygkx2 ztytnknkaiykkujygkx2}</td><td>（中継用）転換解約控除額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikihyoujix2 ztytenkanteikihyoujix2}</td><td>（中継用）転換定期表示＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyknenknsnpx2 ztyhtnknkyknenknsnpx2}</td><td>（中継用）被転換契約年換算Ｐ＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkknx2 ztyhktgtikkikkknx2}</td><td>（中継用）引継定期経過期間＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkykymdx3 ztyhtnknkykkykymdx3}</td><td>（中継用）被転換契約契約年月日＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnkntkbtdkisnyusx3 ztytnkntkbtdkisnyusx3}</td><td>（中継用）転換特別Ｄ計算用Ｓ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknkaiykkujytksux3 ztytnknkaiykkujytksux3}</td><td>（中継用）転換解約控除月数＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknkaiykkujygkx3 ztytnknkaiykkujygkx3}</td><td>（中継用）転換解約控除額＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikihyoujix3 ztytenkanteikihyoujix3}</td><td>（中継用）転換定期表示＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyknenknsnpx3 ztyhtnknkyknenknsnpx3}</td><td>（中継用）被転換契約年換算Ｐ＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkknx3 ztyhktgtikkikkknx3}</td><td>（中継用）引継定期経過期間＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykkykymdx4 ztyhtnknkykkykymdx4}</td><td>（中継用）被転換契約契約年月日＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnkntkbtdkisnyusx4 ztytnkntkbtdkisnyusx4}</td><td>（中継用）転換特別Ｄ計算用Ｓ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytnknkaiykkujytksux4 ztytnknkaiykkujytksux4}</td><td>（中継用）転換解約控除月数＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytnknkaiykkujygkx4 ztytnknkaiykkujygkx4}</td><td>（中継用）転換解約控除額＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytenkanteikihyoujix4 ztytenkanteikihyoujix4}</td><td>（中継用）転換定期表示＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkyknenknsnpx4 ztyhtnknkyknenknsnpx4}</td><td>（中継用）被転換契約年換算Ｐ＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhktgtikkikkknx4 ztyhktgtikkikkknx4}</td><td>（中継用）引継定期経過期間＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysknjyututkykkykkbn ztysknjyututkykkykkbn}</td><td>（中継用）資金充当特約契約区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyswingminyuuphrkekngk ztyswingminyuuphrkekngk}</td><td>（中継用）スイング未入Ｐ振替金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyswingminyuuphrkejyutuym ztyswingminyuuphrkejyutuym}</td><td>（中継用）スイング未入Ｐ振替充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydftounendoitijitounyuup ztydftounendoitijitounyuup}</td><td>（中継用）ＤＦ当年度一時投入Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtydfkaiyakukujyhktggk ztydfkaiyakukujyhktggk}</td><td>（中継用）ＤＦ解約控除引継額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaiyakukoujyotukisuu ztykaiyakukoujyotukisuu}</td><td>（中継用）解約控除月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydfkaiyakuhenreikin ztydfkaiyakuhenreikin}</td><td>（中継用）ＤＦ解約返戻金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuuseis ztysyuuseis}</td><td>（中継用）修正Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyaatukaisyakeisyousisyacd ztyaatukaisyakeisyousisyacd}</td><td>（中継用）Ａ扱者継承支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisyazaisekihyouji ztyaatukaisyazaisekihyouji}</td><td>（中継用）Ａ扱者在籍表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisyabosyuujiage ztyaatukaisyabosyuujiage}</td><td>（中継用）Ａ扱者募集時年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisyabsyjisikakucd ztyaatukaisyabsyjisikakucd}</td><td>（中継用）Ａ扱者募集時資格コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatukaisyasikakucd ztyaatukaisyasikakucd}</td><td>（中継用）Ａ扱者資格コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyokyksmkuztrhkkitikbn ztyokyksmkuztrhkkitikbn}</td><td>（中継用）お客様口座取引形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhoyuusisyacd ztyhoyuusisyacd}</td><td>（中継用）保有支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokansisyacd ztysyokansisyacd}</td><td>（中継用）所管支社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantousyakbn ztytantousyakbn}</td><td>（中継用）担当者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantousyakbnnew ztytantousyakbnnew}</td><td>（中継用）担当者区分（新）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyclubsumiseikbn ztyclubsumiseikbn}</td><td>（中継用）クラブスミセイ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyfollowtantousyakbn ztyfollowtantousyakbn}</td><td>（中継用）フォロー担当者区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytantousyajyoutaikbn ztytantousyajyoutaikbn}</td><td>（中継用）担当者状態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihonyoteii ztykihonyoteii}</td><td>（中継用）基本予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikiyoteii ztyteikiyoteii}</td><td>（中継用）定期予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysonotayoteii ztysonotayoteii}</td><td>（中継用）その他予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibaraikihonyoteii ztyitijibaraikihonyoteii}</td><td>（中継用）一時払基本予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibaraiteikiyoteii ztyitijibaraiteikiyoteii}</td><td>（中継用）一時払定期予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyitijibaraisonotayoteii ztyitijibaraisonotayoteii}</td><td>（中継用）一時払その他予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkankihonyoteii ztytenkankihonyoteii}</td><td>（中継用）転換基本予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytenkanteikiyoteii ztytenkanteikiyoteii}</td><td>（中継用）転換定期予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyszouyoteii ztyszouyoteii}</td><td>（中継用）Ｓ増予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvestingyoteii ztyvestingyoteii}</td><td>（中継用）ベスティング予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysippeitokuyakuyoteii ztysippeitokuyakuyoteii}</td><td>（中継用）疾病特約予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseijinbyoutokuyakuyoteii ztyseijinbyoutokuyakuyoteii}</td><td>（中継用）成人病特約予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyjyoseitokuyakuyoteii ztyjyoseitokuyakuyoteii}</td><td>（中継用）女性特約予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytuuintokuyakuyoteii ztytuuintokuyakuyoteii}</td><td>（中継用）通院特約予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaiteihosyoui ztysaiteihosyoui}</td><td>（中継用）最低保証ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvkisoitjbrkhnyoteii ztyvkisoitjbrkhnyoteii}</td><td>（中継用）Ｖ基礎一時払基本予定ｉ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyvkisorrtzeroikahyouji ztyvkisorrtzeroikahyouji}</td><td>（中継用）Ｖ基礎利率ゼロ％以下表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin3x2 ztysuuriyouyobin3x2}</td><td>（中継用）数理用予備項目Ｎ３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhoyuusisyacd2 ztyhoyuusisyacd2}</td><td>（中継用）保有支社コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydftujyukujykisnkisiym ztydftujyukujykisnkisiym}</td><td>（中継用）ＤＦ通常控除計算期始年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytikikktbrijyututksu ztytikikktbrijyututksu}</td><td>（中継用）定期一括払充当月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyunyumrtikykjtigngtkbn ztysyunyumrtikykjtigngtkbn}</td><td>（中継用）収入マル定契約時逓減型区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhkdrtkykarihyj ztyhhkdrtkykarihyj}</td><td>（中継用）被保険者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtkykarihyj ztykykdrtkykarihyj}</td><td>（中継用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv10x14 ztyyobiv10x14}</td><td>（中継用）予備項目Ｖ１０＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykappadhktgkujygkx1 ztykappadhktgkujygkx1}</td><td>（中継用）カッパーＤ引継控除額＿１</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykappadhktgkujygkx2 ztykappadhktgkujygkx2}</td><td>（中継用）カッパーＤ引継控除額＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykappadhktgkujygkx3 ztykappadhktgkujygkx3}</td><td>（中継用）カッパーＤ引継控除額＿３</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykappadhktgkujygkx4 ztykappadhktgkujygkx4}</td><td>（中継用）カッパーＤ引継控除額＿４</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytrkzsgkaiykkjynstmtkzndk ztytrkzsgkaiykkjynstmtkzndk}</td><td>（中継用）取崩後解約控除なし積立金残高</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtypmenkouryokuhasseiymd ztypmenkouryokuhasseiymd}</td><td>（中継用）Ｐ免効力発生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin5 ztysuuriyouyobin5}</td><td>（中継用）数理用予備項目Ｎ５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin13 ztysuuriyouyobin13}</td><td>（中継用）数理用予備項目Ｎ１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobin11x35 ztyyobin11x35}</td><td>（中継用）予備項目Ｎ１１＿３５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x36 ztyyobin11x36}</td><td>（中継用）予備項目Ｎ１１＿３６</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyyobin11x37 ztyyobin11x37}</td><td>（中継用）予備項目Ｎ１１＿３７</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200 ztytokuyakukoumokuv200}</td><td>（中継用）特約項目Ｖ２００</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x2 ztytokuyakukoumokuv200x2}</td><td>（中継用）特約項目Ｖ２００＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x3 ztytokuyakukoumokuv200x3}</td><td>（中継用）特約項目Ｖ２００＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x4 ztytokuyakukoumokuv200x4}</td><td>（中継用）特約項目Ｖ２００＿４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x5 ztytokuyakukoumokuv200x5}</td><td>（中継用）特約項目Ｖ２００＿５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x6 ztytokuyakukoumokuv200x6}</td><td>（中継用）特約項目Ｖ２００＿６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x7 ztytokuyakukoumokuv200x7}</td><td>（中継用）特約項目Ｖ２００＿７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x8 ztytokuyakukoumokuv200x8}</td><td>（中継用）特約項目Ｖ２００＿８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x9 ztytokuyakukoumokuv200x9}</td><td>（中継用）特約項目Ｖ２００＿９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x10 ztytokuyakukoumokuv200x10}</td><td>（中継用）特約項目Ｖ２００＿１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x11 ztytokuyakukoumokuv200x11}</td><td>（中継用）特約項目Ｖ２００＿１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x12 ztytokuyakukoumokuv200x12}</td><td>（中継用）特約項目Ｖ２００＿１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x13 ztytokuyakukoumokuv200x13}</td><td>（中継用）特約項目Ｖ２００＿１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x14 ztytokuyakukoumokuv200x14}</td><td>（中継用）特約項目Ｖ２００＿１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x15 ztytokuyakukoumokuv200x15}</td><td>（中継用）特約項目Ｖ２００＿１５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x16 ztytokuyakukoumokuv200x16}</td><td>（中継用）特約項目Ｖ２００＿１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x17 ztytokuyakukoumokuv200x17}</td><td>（中継用）特約項目Ｖ２００＿１７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x18 ztytokuyakukoumokuv200x18}</td><td>（中継用）特約項目Ｖ２００＿１８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x19 ztytokuyakukoumokuv200x19}</td><td>（中継用）特約項目Ｖ２００＿１９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x20 ztytokuyakukoumokuv200x20}</td><td>（中継用）特約項目Ｖ２００＿２０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x21 ztytokuyakukoumokuv200x21}</td><td>（中継用）特約項目Ｖ２００＿２１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x22 ztytokuyakukoumokuv200x22}</td><td>（中継用）特約項目Ｖ２００＿２２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x23 ztytokuyakukoumokuv200x23}</td><td>（中継用）特約項目Ｖ２００＿２３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x24 ztytokuyakukoumokuv200x24}</td><td>（中継用）特約項目Ｖ２００＿２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x25 ztytokuyakukoumokuv200x25}</td><td>（中継用）特約項目Ｖ２００＿２５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x26 ztytokuyakukoumokuv200x26}</td><td>（中継用）特約項目Ｖ２００＿２６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x27 ztytokuyakukoumokuv200x27}</td><td>（中継用）特約項目Ｖ２００＿２７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x28 ztytokuyakukoumokuv200x28}</td><td>（中継用）特約項目Ｖ２００＿２８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x29 ztytokuyakukoumokuv200x29}</td><td>（中継用）特約項目Ｖ２００＿２９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x30 ztytokuyakukoumokuv200x30}</td><td>（中継用）特約項目Ｖ２００＿３０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x31 ztytokuyakukoumokuv200x31}</td><td>（中継用）特約項目Ｖ２００＿３１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x32 ztytokuyakukoumokuv200x32}</td><td>（中継用）特約項目Ｖ２００＿３２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x33 ztytokuyakukoumokuv200x33}</td><td>（中継用）特約項目Ｖ２００＿３３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x34 ztytokuyakukoumokuv200x34}</td><td>（中継用）特約項目Ｖ２００＿３４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x35 ztytokuyakukoumokuv200x35}</td><td>（中継用）特約項目Ｖ２００＿３５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x36 ztytokuyakukoumokuv200x36}</td><td>（中継用）特約項目Ｖ２００＿３６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x37 ztytokuyakukoumokuv200x37}</td><td>（中継用）特約項目Ｖ２００＿３７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x38 ztytokuyakukoumokuv200x38}</td><td>（中継用）特約項目Ｖ２００＿３８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x39 ztytokuyakukoumokuv200x39}</td><td>（中継用）特約項目Ｖ２００＿３９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytokuyakukoumokuv200x40 ztytokuyakukoumokuv200x40}</td><td>（中継用）特約項目Ｖ２００＿４０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrkaiyakukoujyoritu ztysrkaiyakukoujyoritu}</td><td>（中継用）数理用解約控除率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysrteikishrtkykhukaumu ztysrteikishrtkykhukaumu}</td><td>（中継用）数理用定期支払特約付加有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_HoyuuMeisaiTyukeiyouItzHzn
 * @see     PKST_HoyuuMeisaiTyukeiyouItzHzn
 * @see     QST_HoyuuMeisaiTyukeiyouItzHzn
 * @see     GenQST_HoyuuMeisaiTyukeiyouItzHzn
 */
@MappedSuperclass
@Table(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.TABLE_NAME)
@IdClass(value=PKST_HoyuuMeisaiTyukeiyouItzHzn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenST_HoyuuMeisaiTyukeiyouItzHzn extends AbstractExDBEntity<ST_HoyuuMeisaiTyukeiyouItzHzn, PKST_HoyuuMeisaiTyukeiyouItzHzn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_HoyuuMeisaiTyukeiyouItzHzn";
    public static final String ZTYSRKIJYUNYM            = "ztysrkijyunym";
    public static final String ZTYSRKAKUTYOUJOBCD       = "ztysrkakutyoujobcd";
    public static final String ZTYSEQUENCENO            = "ztysequenceno";
    public static final String ZTYYUUKOURECORDLENGTH    = "ztyyuukourecordlength";
    public static final String ZTYRDWAREA               = "ztyrdwarea";
    public static final String ZTYRECORDKBN             = "ztyrecordkbn";
    public static final String ZTYNENKINKAISIGOHYOUJI   = "ztynenkinkaisigohyouji";
    public static final String ZTYNKSGOKURIKOSIDHYJ     = "ztynksgokurikosidhyj";
    public static final String ZTYKEIJYOUYM             = "ztykeijyouym";
    public static final String ZTYIDOJIYUKBN            = "ztyidojiyukbn";
    public static final String ZTYZOUGENKBN             = "ztyzougenkbn";
    public static final String ZTYIDOURECORDKBN         = "ztyidourecordkbn";
    public static final String ZTYKEIJYOUCTRLKBN        = "ztykeijyouctrlkbn";
    public static final String ZTYHENKOUSYORIYMD        = "ztyhenkousyoriymd";
    public static final String ZTYKYKMFKSNCTR           = "ztykykmfksnctr";
    public static final String ZTYRECORDCTR             = "ztyrecordctr";
    public static final String ZTYSUURIYOUKOURYOKUKAISIYMD = "ztysuuriyoukouryokukaisiymd";
    public static final String ZTYDENYMD                = "ztydenymd";
    public static final String ZTYBLUEKEIZOKUHYOUJI     = "ztybluekeizokuhyouji";
    public static final String ZTYSUURIYOUYOBIN1X2      = "ztysuuriyouyobin1x2";
    public static final String ZTYTOUKEIKEIJYOUKBN      = "ztytoukeikeijyoukbn";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYZENKIIDOUTEISEIKBN    = "ztyzenkiidouteiseikbn";
    public static final String ZTYBSYYM                 = "ztybsyym";
    public static final String ZTYTENKANGOKEIYAKUBOSYUUYM = "ztytenkangokeiyakubosyuuym";
    public static final String ZTYIDOUJIYUUCD           = "ztyidoujiyuucd";
    public static final String ZTYSYORICD               = "ztysyoricd";
    public static final String ZTYSEKININTEISEIHYOUJI   = "ztysekininteiseihyouji";
    public static final String ZTYSUURIYOUYOBIN8        = "ztysuuriyouyobin8";
    public static final String ZTYSIHANKIBIKINKBN       = "ztysihankibikinkbn";
    public static final String ZTYSUURIYOUYOBIN1X3      = "ztysuuriyouyobin1x3";
    public static final String ZTYDATAKANRINO           = "ztydatakanrino";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYHKNSYURUIKIGOUSEDAIKBN = "ztyhknsyuruikigousedaikbn";
    public static final String ZTYSOTODASIPMENKBN       = "ztysotodasipmenkbn";
    public static final String ZTYSTDSSYTIKBN           = "ztystdssytikbn";
    public static final String ZTYSTDSSNSKBN            = "ztystdssnskbn";
    public static final String ZTYSOTODASIMANAGEHYOUJI  = "ztysotodasimanagehyouji";
    public static final String ZTYSOTODASIPHKBNMNOSHYOUJI = "ztysotodasiphkbnmnoshyouji";
    public static final String ZTYSTDSSTKJYTKYUHYJ      = "ztystdsstkjytkyuhyj";
    public static final String ZTYKBNKEIRIYOUSEGMENTKBN = "ztykbnkeiriyousegmentkbn";
    public static final String ZTYKBNKEIRIYOURGNBNSKKBN = "ztykbnkeiriyourgnbnskkbn";
    public static final String ZTYSUURISYURUICD         = "ztysuurisyuruicd";
    public static final String ZTYHOSYOUKINOUKBN        = "ztyhosyoukinoukbn";
    public static final String ZTYDAIKBN                = "ztydaikbn";
    public static final String ZTYTYUUKBN               = "ztytyuukbn";
    public static final String ZTYSYOUKBN               = "ztysyoukbn";
    public static final String ZTYSEDAIKBN              = "ztysedaikbn";
    public static final String ZTYHARAIKATAKBN          = "ztyharaikatakbn";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSAIMNKKYKHYJ          = "ztysaimnkkykhyj";
    public static final String ZTYANNAIFUYOURIYUUKBN    = "ztyannaifuyouriyuukbn";
    public static final String ZTYTKSYUANNAIKYKKBN      = "ztytksyuannaikykkbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYSDPDKBN               = "ztysdpdkbn";
    public static final String ZTYRYOURITUKBN           = "ztyryouritukbn";
    public static final String ZTYAO3TYOU3SIBOUSDATEHYOUJI = "ztyao3tyou3sibousdatehyouji";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYHIHOKENSYAAGEV2       = "ztyhihokensyaagev2";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYDAI2HHKNNEN           = "ztydai2hhknnen";
    public static final String ZTYTKBTHSYUMNRYUHYOUJI   = "ztytkbthsyumnryuhyouji";
    public static final String ZTYSYUKEIYAKUPWARIBIKIKBN = "ztysyukeiyakupwaribikikbn";
    public static final String ZTYTENKANWARIBIKIKBN     = "ztytenkanwaribikikbn";
    public static final String ZTYYUUHITUTNKNYUGURYURTKBN = "ztyyuuhitutnknyuguryurtkbn";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYTOKUJYOUP             = "ztytokujyoup";
    public static final String ZTYSITEIZUKISYUKEIYAKUP  = "ztysiteizukisyukeiyakup";
    public static final String ZTYKIHONS                = "ztykihons";
    public static final String ZTYSIBOUS                = "ztysibous";
    public static final String ZTYHENKOUGOKIHONS        = "ztyhenkougokihons";
    public static final String ZTYHENKOUGOSIBOUS        = "ztyhenkougosibous";
    public static final String ZTYHENKOUYMD             = "ztyhenkouymd";
    public static final String ZTYENTYOUKIKAN           = "ztyentyoukikan";
    public static final String ZTYSEIZONKYUUHUKINSITEIMD = "ztyseizonkyuuhukinsiteimd";
    public static final String ZTYSYUKEIYAKUSIHARAIKINGAKU = "ztysyukeiyakusiharaikingaku";
    public static final String ZTYATUKAISISYATODOUHUKENCD = "ztyatukaisisyatodouhukencd";
    public static final String ZTYTOKUYAKUHUKASUU       = "ztytokuyakuhukasuu";
    public static final String ZTYDI2HKNKKNIKOUJIHISYAAGE = "ztydi2hknkknikoujihisyaage";
    public static final String ZTYHRIMNENTYOUMAEPHRKKKN = "ztyhrimnentyoumaephrkkkn";
    public static final String ZTYTOKUBETUHOSYOUKIKAN   = "ztytokubetuhosyoukikan";
    public static final String ZTYKOUSINMANRYOUAGE      = "ztykousinmanryouage";
    public static final String ZTYKNKUZUSNZYRTTEKITKARIHYJ = "ztyknkuzusnzyrttekitkarihyj";
    public static final String ZTYKURIAGEKURISAGEKBN    = "ztykuriagekurisagekbn";
    public static final String ZTYHRIZMJHKNSYUKIGOUSDKBN = "ztyhrizmjhknsyukigousdkbn";
    public static final String ZTYKRSGJHKNSYUKIGOUSDKBN = "ztykrsgjhknsyukigousdkbn";
    public static final String ZTYSOTODASISYOUHINKAITEIKBN = "ztysotodasisyouhinkaiteikbn";
    public static final String ZTYYOBIV4                = "ztyyobiv4";
    public static final String ZTYGOUKEITENKANS         = "ztygoukeitenkans";
    public static final String ZTYGOUKEIPBUBUNTENKANS   = "ztygoukeipbubuntenkans";
    public static final String ZTYTENKANTEIKISYURUIKIGOU = "ztytenkanteikisyuruikigou";
    public static final String ZTYTENKANTEIKIKIGOUSEDAIKBN = "ztytenkanteikikigousedaikbn";
    public static final String ZTYTNKNTIKSOTODASIKUSNKBN = "ztytnkntiksotodasikusnkbn";
    public static final String ZTYTNKNTIKSTDSPMENKBN    = "ztytnkntikstdspmenkbn";
    public static final String ZTYTENKANTEIKIKIGOUYOBI  = "ztytenkanteikikigouyobi";
    public static final String ZTYTENKANTEIKIKIKAN      = "ztytenkanteikikikan";
    public static final String ZTYGOUKEITENKANTEIKIS    = "ztygoukeitenkanteikis";
    public static final String ZTYTNKNTEIKINKSHRKKN     = "ztytnknteikinkshrkkn";
    public static final String ZTYTENKANSIHARAIKINGAKU  = "ztytenkansiharaikingaku";
    public static final String ZTYTNKNTIKSHRKNGK        = "ztytnkntikshrkngk";
    public static final String ZTYTENKANKAISUU          = "ztytenkankaisuu";
    public static final String ZTYGOUKEITENKANKAKAKU    = "ztygoukeitenkankakaku";
    public static final String ZTYTNKNKHNBBNJYUTURT     = "ztytnknkhnbbnjyuturt";
    public static final String ZTYWNASIGOUKEITENKANTEIKIS = "ztywnasigoukeitenkanteikis";
    public static final String ZTYTNKNTEIKIKOUSINMNRYOUAGE = "ztytnknteikikousinmnryouage";
    public static final String ZTYYOBIV5                = "ztyyobiv5";
    public static final String ZTYKANYUJIDATAKANRINO    = "ztykanyujidatakanrino";
    public static final String ZTYKANYUJIKYKYMD         = "ztykanyujikykymd";
    public static final String ZTYKANYUUJIHIHOKENSYAAGE = "ztykanyuujihihokensyaage";
    public static final String ZTYKANYUUJITENKANHYOUJI  = "ztykanyuujitenkanhyouji";
    public static final String ZTYHSYUIKKTMINAOSIKAISU  = "ztyhsyuikktminaosikaisu";
    public static final String ZTYSKNNJYNBKNSISNRT      = "ztysknnjynbknsisnrt";
    public static final String ZTYTKJYKBN               = "ztytkjykbn";
    public static final String ZTYSAKUGENKIKAN          = "ztysakugenkikan";
    public static final String ZTYRYOUMASIHYOUTEN       = "ztyryoumasihyouten";
    public static final String ZTYSYKYKTKJYURYUMSRATEHYJ = "ztysykyktkjyuryumsratehyj";
    public static final String ZTYSYKYKTKJYURYUMSRATE   = "ztysykyktkjyuryumsrate";
    public static final String ZTYDAI2TOKUJYOUKBN       = "ztydai2tokujyoukbn";
    public static final String ZTYDAI2SAKUGENKIKAN      = "ztydai2sakugenkikan";
    public static final String ZTYDAI2RYOUMASIHYOUTEN   = "ztydai2ryoumasihyouten";
    public static final String ZTYTOKUTEIBUIJYOUKENHYOUJI = "ztytokuteibuijyoukenhyouji";
    public static final String ZTYTOKUTEIBUINO1         = "ztytokuteibuino1";
    public static final String ZTYHTNPKKN1              = "ztyhtnpkkn1";
    public static final String ZTYTOKUTEIBUINO2         = "ztytokuteibuino2";
    public static final String ZTYHTNPKKN2              = "ztyhtnpkkn2";
    public static final String ZTYMHITUIRYUYUTKTBIJYKNHYJ = "ztymhituiryuyutktbijyknhyj";
    public static final String ZTYMUHAITOUIRYOUYOUTKTBINO1 = "ztymuhaitouiryouyoutktbino1";
    public static final String ZTYMUHAITOUIRYOUYOUHTNPKKN1 = "ztymuhaitouiryouyouhtnpkkn1";
    public static final String ZTYMUHAITOUIRYOUYOUTKTBINO2 = "ztymuhaitouiryouyoutktbino2";
    public static final String ZTYMUHAITOUIRYOUYOUHTNPKKN2 = "ztymuhaitouiryouyouhtnpkkn2";
    public static final String ZTYSITEIZUKIPWARIMASIHYOUJI = "ztysiteizukipwarimasihyouji";
    public static final String ZTYPWARIMASISITEIM1      = "ztypwarimasisiteim1";
    public static final String ZTYPWARIMASISITEIM2      = "ztypwarimasisiteim2";
    public static final String ZTYSITEIMSYKYKPBAIRITU   = "ztysiteimsykykpbairitu";
    public static final String ZTYSAISYUUSITEIYM        = "ztysaisyuusiteiym";
    public static final String ZTYSYKYKKITMTTVKEISANYM  = "ztysykykkitmttvkeisanym";
    public static final String ZTYSYKYKKITMTTSKNNJYNBKNGK = "ztysykykkitmttsknnjynbkngk";
    public static final String ZTYDFTUMITATEKINGAKU     = "ztydftumitatekingaku";
    public static final String ZTYDFTUMIMASIKIN         = "ztydftumimasikin";
    public static final String ZTYVBUBUNDFTENKANKAKAKU  = "ztyvbubundftenkankakaku";
    public static final String ZTYDPBUBUNDFTENKANKAKAKU = "ztydpbubundftenkankakaku";
    public static final String ZTYDFTMTTKNGKITJBRBBN    = "ztydftmttkngkitjbrbbn";
    public static final String ZTYHENDOUS               = "ztyhendous";
    public static final String ZTYHENGAKUJIGYOUNENDOMATUCV = "ztyhengakujigyounendomatucv";
    public static final String ZTYITIBUITIJIBARAIS      = "ztyitibuitijibarais";
    public static final String ZTYITIBUITIJIBARAIP      = "ztyitibuitijibaraip";
    public static final String ZTYITIBITJBRSHRKNGK      = "ztyitibitjbrshrkngk";
    public static final String ZTYGOUKEICV              = "ztygoukeicv";
    public static final String ZTYMINASICV              = "ztyminasicv";
    public static final String ZTYLOANFUND              = "ztyloanfund";
    public static final String ZTYSAITEIHOSYOUGAKU      = "ztysaiteihosyougaku";
    public static final String ZTYHNGKSITIHSYUYUSYKYKP  = "ztyhngksitihsyuyusykykp";
    public static final String ZTYHIJYNBRIVASBUJSITIHSYUGK = "ztyhijynbrivasbujsitihsyugk";
    public static final String ZTYHIJYNBRIVAMNKJSITIHSYUGK = "ztyhijynbrivamnkjsitihsyugk";
    public static final String ZTYSIINKBN               = "ztysiinkbn";
    public static final String ZTYMUDKAIMASIKIHONS      = "ztymudkaimasikihons";
    public static final String ZTYKAIMASIYMD            = "ztykaimasiymd";
    public static final String ZTYKAIMASIKIKAN          = "ztykaimasikikan";
    public static final String ZTYHIKITUGIKAIMASIS      = "ztyhikitugikaimasis";
    public static final String ZTYMUDKAIMASISIHARAIKINGAKU = "ztymudkaimasisiharaikingaku";
    public static final String ZTYSZOUKOURYOKUKAISIYMDX1 = "ztyszoukouryokukaisiymdx1";
    public static final String ZTYSZOUHOKENSYURUIKIGOUX1 = "ztyszouhokensyuruikigoux1";
    public static final String ZTYSZOUKIGOUSEDAIKBNX1   = "ztyszoukigousedaikbnx1";
    public static final String ZTYSZOUKIKANX1           = "ztyszoukikanx1";
    public static final String ZTYSZOUHIHOKENSYAAGEX1   = "ztyszouhihokensyaagex1";
    public static final String ZTYSZOUDAI2HIHKNSYAAGEX1 = "ztyszoudai2hihknsyaagex1";
    public static final String ZTYZOUKASX1              = "ztyzoukasx1";
    public static final String ZTYZENNENDOZOUKASX1      = "ztyzennendozoukasx1";
    public static final String ZTYSZOUSIHARAIKINGAKUX1  = "ztyszousiharaikingakux1";
    public static final String ZTYSZOUKOURYOKUKAISIYMDX2 = "ztyszoukouryokukaisiymdx2";
    public static final String ZTYSZOUHOKENSYURUIKIGOUX2 = "ztyszouhokensyuruikigoux2";
    public static final String ZTYSZOUKIGOUSEDAIKBNX2   = "ztyszoukigousedaikbnx2";
    public static final String ZTYSZOUKIKANX2           = "ztyszoukikanx2";
    public static final String ZTYSZOUHIHOKENSYAAGEX2   = "ztyszouhihokensyaagex2";
    public static final String ZTYSZOUDAI2HIHKNSYAAGEX2 = "ztyszoudai2hihknsyaagex2";
    public static final String ZTYZOUKASX2              = "ztyzoukasx2";
    public static final String ZTYZENNENDOZOUKASX2      = "ztyzennendozoukasx2";
    public static final String ZTYSZOUSIHARAIKINGAKUX2  = "ztyszousiharaikingakux2";
    public static final String ZTYSUURIYOUYOBIN1X5      = "ztysuuriyouyobin1x5";
    public static final String ZTYSUURIYOUYOBIN1X6      = "ztysuuriyouyobin1x6";
    public static final String ZTYHRIMNGKIZKTKYKPMENHYJ = "ztyhrimngkizktkykpmenhyj";
    public static final String ZTYMISYUUSTARTYM         = "ztymisyuustartym";
    public static final String ZTYMISYUUKAISUU          = "ztymisyuukaisuu";
    public static final String ZTYITJBRTKYKKOUSNUKTKARHYJ = "ztyitjbrtkykkousnuktkarhyj";
    public static final String ZTYGYOUSEKIHYOUJIS       = "ztygyousekihyoujis";
    public static final String ZTYSYKYKGYUSEKIHYJS      = "ztysykykgyusekihyjs";
    public static final String ZTYTENKANGYOUSEKIHYOUJIS = "ztytenkangyousekihyoujis";
    public static final String ZTYTNKNTEIKIGYOUSEKIHYJS = "ztytnknteikigyousekihyjs";
    public static final String ZTYTNKNDPBBNGYUSKHYJS    = "ztytnkndpbbngyuskhyjs";
    public static final String ZTYKYKJYOUTAI            = "ztykykjyoutai";
    public static final String ZTYPMENHUKAKBN           = "ztypmenhukakbn";
    public static final String ZTYKOUSINKBN             = "ztykousinkbn";
    public static final String ZTYMANKIYOTEIKBN         = "ztymankiyoteikbn";
    public static final String ZTYSYKYKTIKMNKYOTEIKBN   = "ztysykyktikmnkyoteikbn";
    public static final String ZTYTNKNSYKYKKHNMNKYTIKBN = "ztytnknsykykkhnmnkytikbn";
    public static final String ZTYTNKNSYKYKTIKMNKYTIKBN = "ztytnknsykyktikmnkytikbn";
    public static final String ZTYTENKANTEIKIMANKIYOTEIKBN = "ztytenkanteikimankiyoteikbn";
    public static final String ZTYSZOUMANKIYOTEIKBNX1   = "ztyszoumankiyoteikbnx1";
    public static final String ZTYSZOUMANKIYOTEIKBNX2   = "ztyszoumankiyoteikbnx2";
    public static final String ZTYVESTINGMANKIYOTEIKBN  = "ztyvestingmankiyoteikbn";
    public static final String ZTYVKEISANHYOUJI         = "ztyvkeisanhyouji";
    public static final String ZTYTOUKISINKEIYAKUHYOUJI = "ztytoukisinkeiyakuhyouji";
    public static final String ZTYSYKYKHOKENHOUTEKIYOUHYJ = "ztysykykhokenhoutekiyouhyj";
    public static final String ZTYTOKUTEIJYOUTAIHUSHRHYJ = "ztytokuteijyoutaihushrhyj";
    public static final String ZTYYTIRRTHNDSYSNMNSKAISUU = "ztyytirrthndsysnmnskaisuu";
    public static final String ZTYSUURIYOUYOBIN3        = "ztysuuriyouyobin3";
    public static final String ZTYSUURIYOUYOBIN11       = "ztysuuriyouyobin11";
    public static final String ZTYWNASIGOUKEITENKANKAKAKU = "ztywnasigoukeitenkankakaku";
    public static final String ZTYYOBIN11               = "ztyyobin11";
    public static final String ZTYYOBIN11X2             = "ztyyobin11x2";
    public static final String ZTYYOBIN11X3             = "ztyyobin11x3";
    public static final String ZTYTUKIBARAIKANSANTOKUJYOUP = "ztytukibaraikansantokujyoup";
    public static final String ZTYTNKNGKYKKSSNKIJYUYM   = "ztytnkngkykkssnkijyuym";
    public static final String ZTYSAITEIHOSYOUHYOUJI    = "ztysaiteihosyouhyouji";
    public static final String ZTYSUURIYOUYOBIN8X2      = "ztysuuriyouyobin8x2";
    public static final String ZTYSUURIYOUYOBIN14       = "ztysuuriyouyobin14";
    public static final String ZTYHRIMNGTKYKPHRKKAISUUKBN = "ztyhrimngtkykphrkkaisuukbn";
    public static final String ZTYHRIMNGTKYKPHRKKIRKBN  = "ztyhrimngtkykphrkkirkbn";
    public static final String ZTYHRIMNGTKYKPRYURTKBN   = "ztyhrimngtkykpryurtkbn";
    public static final String ZTYYOBIV13               = "ztyyobiv13";
    public static final String ZTYIDOUJISAITEIHOSYOUKNGK = "ztyidoujisaiteihosyoukngk";
    public static final String ZTYIDOUJISAITEIHOSYOUCOST = "ztyidoujisaiteihosyoucost";
    public static final String ZTYSINHOKENFUNDTUMITATEKIN = "ztysinhokenfundtumitatekin";
    public static final String ZTYMSYUPTUSSHKGKAIYKHNRIKN = "ztymsyuptusshkgkaiykhnrikn";
    public static final String ZTYRRTHNDUGTNKGETUMATUV  = "ztyrrthndugtnkgetumatuv";
    public static final String ZTYRRTHNDNKSAITEIHOSYONKGNS = "ztyrrthndnksaiteihosyonkgns";
    public static final String ZTYRRTHENDOUGATANKSIBOUS = "ztyrrthendougatanksibous";
    public static final String ZTYALMYOUSOHUTOMEISYOUKBN = "ztyalmyousohutomeisyoukbn";
    public static final String ZTYSNKYKSOFTMEISYOUKBN   = "ztysnkyksoftmeisyoukbn";
    public static final String ZTYSOFTMEISYOUKBN        = "ztysoftmeisyoukbn";
    public static final String ZTYKYKJITOKUJYOUARIHYJ   = "ztykykjitokujyouarihyj";
    public static final String ZTYBNKTTNKNKBN           = "ztybnkttnknkbn";
    public static final String ZTYTENKANMINAOSIKBN      = "ztytenkanminaosikbn";
    public static final String ZTYSOUJIKEITENKANKBN     = "ztysoujikeitenkankbn";
    public static final String ZTYNENKINKAISINENDO      = "ztynenkinkaisinendo";
    public static final String ZTYNENKINGATAKBN         = "ztynenkingatakbn";
    public static final String ZTYNKNSHRY               = "ztynknshry";
    public static final String ZTYHEIYOUBARAIKEIYAKUKBN = "ztyheiyoubaraikeiyakukbn";
    public static final String ZTYNENKINMARUTEIHUKAKBN  = "ztynenkinmaruteihukakbn";
    public static final String ZTYSINSEIZONMRTIARIHYJ   = "ztysinseizonmrtiarihyj";
    public static final String ZTYSNKYKYOUIBOKIJYUKBN   = "ztysnkykyouibokijyukbn";
    public static final String ZTYTOKUSITUJYUUSITUSETKBN = "ztytokusitujyuusitusetkbn";
    public static final String ZTYSIKTSYUKNBYUGNHSYUNSHYJ = "ztysiktsyuknbyugnhsyunshyj";
    public static final String ZTYPMENSUGUGTGANHSYUNSHYJ = "ztypmensugugtganhsyunshyj";
    public static final String ZTYTKYKGYOUSEKIHYJSZEROHYJ = "ztytkykgyousekihyjszerohyj";
    public static final String ZTYSUURIYOUYOBIN7        = "ztysuuriyouyobin7";
    public static final String ZTYSYUSSAIKEITAIKBN      = "ztysyussaikeitaikbn";
    public static final String ZTYYOBIV6                = "ztyyobiv6";
    public static final String ZTYBOSYUUKEITAIKBN       = "ztybosyuukeitaikbn";
    public static final String ZTYAATUKAISOSIKICD       = "ztyaatukaisosikicd";
    public static final String ZTYAATUKAIKOJINCD        = "ztyaatukaikojincd";
    public static final String ZTYBSYDRTENCD            = "ztybsydrtencd";
    public static final String ZTYCIFCD                 = "ztycifcd";
    public static final String ZTYSUURIYOUYOBIV8        = "ztysuuriyouyobiv8";
    public static final String ZTYSINSAKBN              = "ztysinsakbn";
    public static final String ZTYDAI2HIHOKENSYASINSAKBN = "ztydai2hihokensyasinsakbn";
    public static final String ZTYTOUKEIYOUSINSAKBN     = "ztytoukeiyousinsakbn";
    public static final String ZTYDAI2TOUKEIYOUSINSAKBN = "ztydai2toukeiyousinsakbn";
    public static final String ZTYKETTEIKIJYUNKANWAKBN  = "ztyketteikijyunkanwakbn";
    public static final String ZTYKIHONSIBOUHYOUKBN     = "ztykihonsibouhyoukbn";
    public static final String ZTYTEIKISIBOUHYOUKBN     = "ztyteikisibouhyoukbn";
    public static final String ZTYSONOTASIBOUHYOUKBN    = "ztysonotasibouhyoukbn";
    public static final String ZTYMRARIHYJ              = "ztymrarihyj";
    public static final String ZTYSENTAKUJYOUHOUARIHYOUJI = "ztysentakujyouhouarihyouji";
    public static final String ZTYDUGKTNKNSNTKHUHUKBN   = "ztydugktnknsntkhuhukbn";
    public static final String ZTYGENGAKUTENKANKYKHYJ   = "ztygengakutenkankykhyj";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYJIDOUKOUSINKYKKANYUUYMD = "ztyjidoukousinkykkanyuuymd";
    public static final String ZTYSAIKOHTNKNKYKKYKYMD   = "ztysaikohtnknkykkykymd";
    public static final String ZTYKOUSINMAESYKYKSBURTKBN = "ztykousinmaesykyksburtkbn";
    public static final String ZTYHJNKYKHYJ             = "ztyhjnkykhyj";
    public static final String ZTYANNISKCD              = "ztyanniskcd";
    public static final String ZTYHJNCD                 = "ztyhjncd";
    public static final String ZTYHJNJIGYOSYOCD         = "ztyhjnjigyosyocd";
    public static final String ZTYSAIHOKENNO            = "ztysaihokenno";
    public static final String ZTYDAKUHIKETTIKEKKACD    = "ztydakuhikettikekkacd";
    public static final String ZTYDAI2DAKUHIKETTEIKEKKACD = "ztydai2dakuhiketteikekkacd";
    public static final String ZTYPMENKBNV2             = "ztypmenkbnv2";
    public static final String ZTYSIBOUKYUUHUKIN        = "ztysiboukyuuhukin";
    public static final String ZTYJYUDTHUMEHARAITKYKHKHYJ = "ztyjyudthumeharaitkykhkhyj";
    public static final String ZTYHAITOUKBN             = "ztyhaitoukbn";
    public static final String ZTYHHKNNENTYSIHYJ        = "ztyhhknnentysihyj";
    public static final String ZTYDAI2HHKNNENTYSIHYJ    = "ztydai2hhknnentysihyj";
    public static final String ZTYKYKSYAAGETYOUSEIHYJ   = "ztykyksyaagetyouseihyj";
    public static final String ZTYKITUENKBN             = "ztykituenkbn";
    public static final String ZTYKITUENHONSUU          = "ztykituenhonsuu";
    public static final String ZTYMUSENTAKUKEIYAKUKBN   = "ztymusentakukeiyakukbn";
    public static final String ZTYYOBIV6X2              = "ztyyobiv6x2";
    public static final String ZTYLIVINGNEEDSTKYKARIHYJ = "ztylivingneedstkykarihyj";
    public static final String ZTYLIVINGNEEDSSIHARAIHYOUJI = "ztylivingneedssiharaihyouji";
    public static final String ZTYLNSEIKYUUYMD          = "ztylnseikyuuymd";
    public static final String ZTYLNSHRGENINCD          = "ztylnshrgenincd";
    public static final String ZTYDAKUHIKETTISYACD      = "ztydakuhikettisyacd";
    public static final String ZTYDAI2DAKUHIKETTEISYACD = "ztydai2dakuhiketteisyacd";
    public static final String ZTYGANSAPOTOKUYAKUARIHYOUJI = "ztygansapotokuyakuarihyouji";
    public static final String ZTYGNSPSHRHYJ            = "ztygnspshrhyj";
    public static final String ZTYGANSAPOSEIKYUUYMD     = "ztygansaposeikyuuymd";
    public static final String ZTYGNSPSHRGENINCD        = "ztygnspshrgenincd";
    public static final String ZTYYOBIV3X2              = "ztyyobiv3x2";
    public static final String ZTYTARGETMOKUHYOURITU    = "ztytargetmokuhyouritu";
    public static final String ZTYAUTOSWITCHMOKUHYOURITU = "ztyautoswitchmokuhyouritu";
    public static final String ZTYTUMITATEKINITENARIHYJ = "ztytumitatekinitenarihyj";
    public static final String ZTYTUMITATEKINITENKAISUU = "ztytumitatekinitenkaisuu";
    public static final String ZTYDATAKANRINO2          = "ztydatakanrino2";
    public static final String ZTYDATAKANRINO3          = "ztydatakanrino3";
    public static final String ZTYKNKUZUSNZYRTTEKINENDO = "ztyknkuzusnzyrttekinendo";
    public static final String ZTYKNKUZUSNZYRT          = "ztyknkuzusnzyrt";
    public static final String ZTYKNKUZUSNZYRTX2        = "ztyknkuzusnzyrtx2";
    public static final String ZTYKNKUZUSNZYRTX3        = "ztyknkuzusnzyrtx3";
    public static final String ZTYSINKEIYAKUJIKNKUZUSNZYRT = "ztysinkeiyakujiknkuzusnzyrt";
    public static final String ZTYTENKANJIKNKUZUSNZYRT  = "ztytenkanjiknkuzusnzyrt";
    public static final String ZTYSINKEIYAKUJIVITHKHYOUJI = "ztysinkeiyakujivithkhyouji";
    public static final String ZTYKYKJIVITHUKUSUUKYKHYJ = "ztykykjivithukusuukykhyj";
    public static final String ZTYSUURIYOUYOBIN9X2      = "ztysuuriyouyobin9x2";
    public static final String ZTYPWRBKSIDHITEKIYOUHYJ  = "ztypwrbksidhitekiyouhyj";
    public static final String ZTYSUURIYOUYOBIN9        = "ztysuuriyouyobin9";
    public static final String ZTYSUURIYOUYOBIN10X7     = "ztysuuriyouyobin10x7";
    public static final String ZTYSUURIYOUYOBIN10X8     = "ztysuuriyouyobin10x8";
    public static final String ZTYSUURIYOUYOBIN10X9     = "ztysuuriyouyobin10x9";
    public static final String ZTYTUMITATEKINITENBUBUN  = "ztytumitatekinitenbubun";
    public static final String ZTYSAGAKUSKNNJYNBKNZNDK  = "ztysagakusknnjynbknzndk";
    public static final String ZTYYOBIN11X5             = "ztyyobin11x5";
    public static final String ZTYYOBIN11X6             = "ztyyobin11x6";
    public static final String ZTYYOBIN11X7             = "ztyyobin11x7";
    public static final String ZTYYOBIN11X8             = "ztyyobin11x8";
    public static final String ZTYYOBIN11X9             = "ztyyobin11x9";
    public static final String ZTYYOBIN11X10            = "ztyyobin11x10";
    public static final String ZTYYOBIN11X11            = "ztyyobin11x11";
    public static final String ZTYYOBIN11X12            = "ztyyobin11x12";
    public static final String ZTYYOBIN11X13            = "ztyyobin11x13";
    public static final String ZTYYOBIN11X14            = "ztyyobin11x14";
    public static final String ZTYYOBIN11X15            = "ztyyobin11x15";
    public static final String ZTYYOBIN11X16            = "ztyyobin11x16";
    public static final String ZTYYOBIN11X17            = "ztyyobin11x17";
    public static final String ZTYZYRTHNTIYUSTATUSKBN   = "ztyzyrthntiyustatuskbn";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX2 = "ztyzyrthntiyustatuskbnx2";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX3 = "ztyzyrthntiyustatuskbnx3";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX4 = "ztyzyrthntiyustatuskbnx4";
    public static final String ZTYZYRTHNTIYUSTATUSKBNX5 = "ztyzyrthntiyustatuskbnx5";
    public static final String ZTYYOBIV10               = "ztyyobiv10";
    public static final String ZTYYOBIV15X2             = "ztyyobiv15x2";
    public static final String ZTYYOBIV15X3             = "ztyyobiv15x3";
    public static final String ZTYYOBIV15X4             = "ztyyobiv15x4";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYKAWASERATE1           = "ztykawaserate1";
    public static final String ZTYKAWASERATETEKIYOUYMD1 = "ztykawaseratetekiyouymd1";
    public static final String ZTYKAWASERATE2           = "ztykawaserate2";
    public static final String ZTYKAWASERATETEKIYOUYMD2 = "ztykawaseratetekiyouymd2";
    public static final String ZTYKYKJIKAWASERATE       = "ztykykjikawaserate";
    public static final String ZTYKYKJIKAWASERATETKYUYMD = "ztykykjikawaseratetkyuymd";
    public static final String ZTYMVATYOUSEIGOW         = "ztymvatyouseigow";
    public static final String ZTYMVAKEISANJISKNNJYNBKN = "ztymvakeisanjisknnjynbkn";
    public static final String ZTYKAIYAKUKOUJYORITU     = "ztykaiyakukoujyoritu";
    public static final String ZTYRENDOURITU            = "ztyrendouritu";
    public static final String ZTYSRKAIYAKUSJKKKTYOUSEIRRT = "ztysrkaiyakusjkkktyouseirrt";
    public static final String ZTYSRKYKSJKKKTYOUSEIRIRITU = "ztysrkyksjkkktyouseiriritu";
    public static final String ZTYMVAKEISANKIJYUNYMD    = "ztymvakeisankijyunymd";
    public static final String ZTYMVATYOUSEIKOU         = "ztymvatyouseikou";
    public static final String ZTYENKDTSBUJSITIHSYUKNGK = "ztyenkdtsbujsitihsyukngk";
    public static final String ZTYENKDTSBUJSITIHSYUCOST = "ztyenkdtsbujsitihsyucost";
    public static final String ZTYENKDTSBUJSITIHSYUARIHYJ = "ztyenkdtsbujsitihsyuarihyj";
    public static final String ZTYKEIYAKUJIYOTEIRIRITU  = "ztykeiyakujiyoteiriritu";
    public static final String ZTYTUMITATERIRITU        = "ztytumitateriritu";
    public static final String ZTYKAIGOMAEBARAITKYKARIHYJ = "ztykaigomaebaraitkykarihyj";
    public static final String ZTYSIBOUHYOUKBN          = "ztysibouhyoukbn";
    public static final String ZTYNYUUKINTUUKAKBN       = "ztynyuukintuukakbn";
    public static final String ZTYSIHARAITUUKAKBN       = "ztysiharaituukakbn";
    public static final String ZTYWYENDTTARGETMOKUHYOURITU = "ztywyendttargetmokuhyouritu";
    public static final String ZTYSISUURENDOURATE       = "ztysisuurendourate";
    public static final String ZTYSISUUKBN              = "ztysisuukbn";
    public static final String ZTYTEIRITUIKOUHYOUJI     = "ztyteirituikouhyouji";
    public static final String ZTYSRDAI1HKNKKN          = "ztysrdai1hknkkn";
    public static final String ZTYSUURIYOUYOBIN10X11    = "ztysuuriyouyobin10x11";
    public static final String ZTYTMTTKNZOUKARITUJYGN   = "ztytmttknzoukaritujygn";
    public static final String ZTYSETTEIBAIRITU         = "ztysetteibairitu";
    public static final String ZTYTYKZENOUTOUYMDSISUU   = "ztytykzenoutouymdsisuu";
    public static final String ZTYKIMATUSISUU           = "ztykimatusisuu";
    public static final String ZTYTUUKASYUKBN           = "ztytuukasyukbn";
    public static final String ZTYYOBIV2                = "ztyyobiv2";
    public static final String ZTYYENKADATEKIHONS       = "ztyyenkadatekihons";
    public static final String ZTYSITIHSYUMEGKDTSIBOUS  = "ztysitihsyumegkdtsibous";
    public static final String ZTYENKDTSSRENTUMITATEKIN = "ztyenkdtssrentumitatekin";
    public static final String ZTYSISUURENTUMITATEKIN   = "ztysisuurentumitatekin";
    public static final String ZTYNKSJITIRTTUMITATEKIN  = "ztynksjitirttumitatekin";
    public static final String ZTYKIMATUTIRTTUMITATEKIN = "ztykimatutirttumitatekin";
    public static final String ZTYGAIKADATEJYUUTOUP     = "ztygaikadatejyuutoup";
    public static final String ZTYYENDTTARGETKIJYUNKINGAKU = "ztyyendttargetkijyunkingaku";
    public static final String ZTYYOBIV7                = "ztyyobiv7";
    public static final String ZTYSITIVKISNYUKYKJIKWSRATE = "ztysitivkisnyukykjikwsrate";
    public static final String ZTYSISUURENTYOKUGOTMTTKN = "ztysisuurentyokugotmttkn";
    public static final String ZTYYOTEIRIRITURIRONBASE  = "ztyyoteiririturironbase";
    public static final String ZTYYOTEIRIRITUJTNYKNBASE = "ztyyoteiriritujtnyknbase";
    public static final String ZTYKIHRKMPJTNYKNBASE     = "ztykihrkmpjtnyknbase";
    public static final String ZTYSYUPTUMITATEKIN       = "ztysyuptumitatekin";
    public static final String ZTYSYUPTUMITATEKINGSC    = "ztysyuptumitatekingsc";
    public static final String ZTYGAIKADATENKGNS        = "ztygaikadatenkgns";
    public static final String ZTYJIKAIPJYUUTOUYM2      = "ztyjikaipjyuutouym2";
    public static final String ZTYSUURIYOBIN9           = "ztysuuriyobin9";
    public static final String ZTYGESSITUMITATEKIN      = "ztygessitumitatekin";
    public static final String ZTYGAIKADATETOUGETUJUUTOUP = "ztygaikadatetougetujuutoup";
    public static final String ZTYKIHRKMPMSUKISYMBASE   = "ztykihrkmpmsukisymbase";
    public static final String ZTYKEISANHANTEIYOUTMTTKN = "ztykeisanhanteiyoutmttkn";
    public static final String ZTYGTMTV                 = "ztygtmtv";
    public static final String ZTYZETTAISIBOURITU       = "ztyzettaisibouritu";
    public static final String ZTYSOUTAISIBOURITU       = "ztysoutaisibouritu";
    public static final String ZTYSOUTAIKAIYAKURITU     = "ztysoutaikaiyakuritu";
    public static final String ZTYVHIREILRITU2          = "ztyvhireilritu2";
    public static final String ZTYPHIREIALPHA           = "ztyphireialpha";
    public static final String ZTYPHIREIBETA            = "ztyphireibeta";
    public static final String ZTYPHIREIGANMA           = "ztyphireiganma";
    public static final String ZTYPHIREILWRBKRITU       = "ztyphireilwrbkritu";
    public static final String ZTYYOTEIRIRITUMSUKISYMBASE = "ztyyoteiriritumsukisymbase";
    public static final String ZTYRRTHNDUHKNVKISOVKISNYU1 = "ztyrrthnduhknvkisovkisnyu1";
    public static final String ZTYRRTHNDUHKNVKISOVKISNYU2 = "ztyrrthnduhknvkisovkisnyu2";
    public static final String ZTYRRTHNDUHKNVKISOVKISNYU3 = "ztyrrthnduhknvkisovkisnyu3";
    public static final String ZTYRRTHNDUHKNVKISOVKISNYU4 = "ztyrrthnduhknvkisovkisnyu4";
    public static final String ZTYRRTHNDUHKNVKISO       = "ztyrrthnduhknvkiso";
    public static final String ZTYTUMITATEKIN           = "ztytumitatekin";
    public static final String ZTYKIHARAIKOMIP          = "ztykiharaikomip";
    public static final String ZTYGAIKADATESYUKEIYAKUP  = "ztygaikadatesyukeiyakup";
    public static final String ZTYKYKKJMMVATYOUSEIGOW   = "ztykykkjmmvatyouseigow";
    public static final String ZTYYOBIN11X39            = "ztyyobin11x39";
    public static final String ZTYYOBIN11X41            = "ztyyobin11x41";
    public static final String ZTYYOBIN11X42            = "ztyyobin11x42";
    public static final String ZTYYOBIN11X43            = "ztyyobin11x43";
    public static final String ZTYYOBIN11X44            = "ztyyobin11x44";
    public static final String ZTYYOBIN11X45            = "ztyyobin11x45";
    public static final String ZTYSUURIYOUYOBIN15X3     = "ztysuuriyouyobin15x3";
    public static final String ZTYSUURIYOUYOBIN15X4     = "ztysuuriyouyobin15x4";
    public static final String ZTYSUURIYOUYOBIN15X5     = "ztysuuriyouyobin15x5";
    public static final String ZTYSUURIYOUYOBIN15X6     = "ztysuuriyouyobin15x6";
    public static final String ZTYYOBIV14               = "ztyyobiv14";
    public static final String ZTYKYKSYHHKNSYDOUITUHYOUJI = "ztykyksyhhknsydouituhyouji";
    public static final String ZTYKYKSYASKINMEINO       = "ztykyksyaskinmeino";
    public static final String ZTYGOUKEIKIHONS          = "ztygoukeikihons";
    public static final String ZTYGOUKEIGYOUSEKIHYJSIBOUS = "ztygoukeigyousekihyjsibous";
    public static final String ZTYALMYOUSIBOUS          = "ztyalmyousibous";
    public static final String ZTYHARAIKOMIP            = "ztyharaikomip";
    public static final String ZTYSITEIZUKIHARAIKOMIP   = "ztysiteizukiharaikomip";
    public static final String ZTYSAISYUUSITEIMHRKP     = "ztysaisyuusiteimhrkp";
    public static final String ZTYGOUKEINENBARAIKANSANP = "ztygoukeinenbaraikansanp";
    public static final String ZTYGYOUSEKIHYOUJISRANK   = "ztygyousekihyoujisrank";
    public static final String ZTYTEIKIBAIRITU          = "ztyteikibairitu";
    public static final String ZTYTENKANGODATAKANRINO   = "ztytenkangodatakanrino";
    public static final String ZTYAITEKYKDATAKANRINO1   = "ztyaitekykdatakanrino1";
    public static final String ZTYAITEKYKDATAKANRINO2   = "ztyaitekykdatakanrino2";
    public static final String ZTYTNKNSYOKAIPCASHLESSHYJ = "ztytnknsyokaipcashlesshyj";
    public static final String ZTYSYOKAIPANNAIKBN       = "ztysyokaipannaikbn";
    public static final String ZTYZENNOUKAISIYMD        = "ztyzennoukaisiymd";
    public static final String ZTYZENNOUKIKAN           = "ztyzennoukikan";
    public static final String ZTYSEIZONKYUUHUKINSITEIY = "ztyseizonkyuuhukinsiteiy";
    public static final String ZTYALMYOUSEIZONKYHKNSITEIMD = "ztyalmyouseizonkyhknsiteimd";
    public static final String ZTYJIKAIPJYUUTOUYM       = "ztyjikaipjyuutouym";
    public static final String ZTYKYKJIQPACKHYJ         = "ztykykjiqpackhyj";
    public static final String ZTYHKTGTIKKIKKKN3X1      = "ztyhktgtikkikkkn3x1";
    public static final String ZTYHKTGTIKKIKKKN3X2      = "ztyhktgtikkikkkn3x2";
    public static final String ZTYHKTGTIKKIKKKN3X3      = "ztyhktgtikkikkkn3x3";
    public static final String ZTYHKTGTIKKIKKKN3X4      = "ztyhktgtikkikkkn3x4";
    public static final String ZTYKAPPADKEISANKBNX1     = "ztykappadkeisankbnx1";
    public static final String ZTYKAPPADKEISANKBNX2     = "ztykappadkeisankbnx2";
    public static final String ZTYKAPPADKEISANKBNX3     = "ztykappadkeisankbnx3";
    public static final String ZTYKAPPADKEISANKBNX4     = "ztykappadkeisankbnx4";
    public static final String ZTYSUURIYOUYOBIN2        = "ztysuuriyouyobin2";
    public static final String ZTYYOBIV6X3              = "ztyyobiv6x3";
    public static final String ZTYKIMATUVYOUTUMIMASIKIN = "ztykimatuvyoutumimasikin";
    public static final String ZTYKMTVYUSNHKNFUNDTMTTKIN = "ztykmtvyusnhknfundtmttkin";
    public static final String ZTYGOUKEINENKANSANP3X1   = "ztygoukeinenkansanp3x1";
    public static final String ZTYGOUKEINENKANSANP3X2   = "ztygoukeinenkansanp3x2";
    public static final String ZTYGOUKEINENKANSANP3X3   = "ztygoukeinenkansanp3x3";
    public static final String ZTYGOUKEINENKANSANP3X4   = "ztygoukeinenkansanp3x4";
    public static final String ZTYKMTVYUHIJYNBRITMTTKIN = "ztykmtvyuhijynbritmttkin";
    public static final String ZTYKIMATUVYOUITJBRTMTTKIN = "ztykimatuvyouitjbrtmttkin";
    public static final String ZTYYOBIN11X26            = "ztyyobin11x26";
    public static final String ZTYYOBIN11X27            = "ztyyobin11x27";
    public static final String ZTYYOBIN11X28            = "ztyyobin11x28";
    public static final String ZTYYOBIN11X29            = "ztyyobin11x29";
    public static final String ZTYYOBIN11X30            = "ztyyobin11x30";
    public static final String ZTYYOBIN11X31            = "ztyyobin11x31";
    public static final String ZTYYOBIN11X32            = "ztyyobin11x32";
    public static final String ZTYYOBIN11X33            = "ztyyobin11x33";
    public static final String ZTYHAITOUYOULOADINGKIJYUNS = "ztyhaitouyouloadingkijyuns";
    public static final String ZTYTOUDUKETORIHOUHOUKBN  = "ztytouduketorihouhoukbn";
    public static final String ZTYTUMITATED             = "ztytumitated";
    public static final String ZTYKARIWARIATED          = "ztykariwariated";
    public static final String ZTYTYOKUZENSIHARAIKIJITU = "ztytyokuzensiharaikijitu";
    public static final String ZTYTYOKUZENTUUSANHANTEIS = "ztytyokuzentuusanhanteis";
    public static final String ZTYTYOKUGOSIHARAIKIJITU  = "ztytyokugosiharaikijitu";
    public static final String ZTYTYOKUGOTUUSANHANTEIS  = "ztytyokugotuusanhanteis";
    public static final String ZTYTYOKUGOKYUUHUTAISYOUS = "ztytyokugokyuuhutaisyous";
    public static final String ZTYTYOKUGOCBKINGAKU      = "ztytyokugocbkingaku";
    public static final String ZTYSYOKAISIHARAIKIJITU   = "ztysyokaisiharaikijitu";
    public static final String ZTYSYOKAITUUSANHANTEIS   = "ztysyokaituusanhanteis";
    public static final String ZTYCBNAYOSETUUSANHANTEIS = "ztycbnayosetuusanhanteis";
    public static final String ZTYHITENKANKEIYAKUSUU    = "ztyhitenkankeiyakusuu";
    public static final String ZTYGOUKEIPBUBUNTENKANTEIKIS = "ztygoukeipbubuntenkanteikis";
    public static final String ZTYSAIDAIHKTGTIKKIKKKN   = "ztysaidaihktgtikkikkkn";
    public static final String ZTYSISYUTNKNHKTGKUJYGK   = "ztysisyutnknhktgkujygk";
    public static final String ZTYYOBIN11X34            = "ztyyobin11x34";
    public static final String ZTYHTNKNKYKKYKYMDX1      = "ztyhtnknkykkykymdx1";
    public static final String ZTYTNKNTKBTDKISNYUSX1    = "ztytnkntkbtdkisnyusx1";
    public static final String ZTYTNKNKAIYKKUJYTKSUX1   = "ztytnknkaiykkujytksux1";
    public static final String ZTYTNKNKAIYKKUJYGKX1     = "ztytnknkaiykkujygkx1";
    public static final String ZTYTENKANTEIKIHYOUJIX1   = "ztytenkanteikihyoujix1";
    public static final String ZTYHTNKNKYKNENKNSNPX1    = "ztyhtnknkyknenknsnpx1";
    public static final String ZTYHKTGTIKKIKKKNX1       = "ztyhktgtikkikkknx1";
    public static final String ZTYHTNKNKYKKYKYMDX2      = "ztyhtnknkykkykymdx2";
    public static final String ZTYTNKNTKBTDKISNYUSX2    = "ztytnkntkbtdkisnyusx2";
    public static final String ZTYTNKNKAIYKKUJYTKSUX2   = "ztytnknkaiykkujytksux2";
    public static final String ZTYTNKNKAIYKKUJYGKX2     = "ztytnknkaiykkujygkx2";
    public static final String ZTYTENKANTEIKIHYOUJIX2   = "ztytenkanteikihyoujix2";
    public static final String ZTYHTNKNKYKNENKNSNPX2    = "ztyhtnknkyknenknsnpx2";
    public static final String ZTYHKTGTIKKIKKKNX2       = "ztyhktgtikkikkknx2";
    public static final String ZTYHTNKNKYKKYKYMDX3      = "ztyhtnknkykkykymdx3";
    public static final String ZTYTNKNTKBTDKISNYUSX3    = "ztytnkntkbtdkisnyusx3";
    public static final String ZTYTNKNKAIYKKUJYTKSUX3   = "ztytnknkaiykkujytksux3";
    public static final String ZTYTNKNKAIYKKUJYGKX3     = "ztytnknkaiykkujygkx3";
    public static final String ZTYTENKANTEIKIHYOUJIX3   = "ztytenkanteikihyoujix3";
    public static final String ZTYHTNKNKYKNENKNSNPX3    = "ztyhtnknkyknenknsnpx3";
    public static final String ZTYHKTGTIKKIKKKNX3       = "ztyhktgtikkikkknx3";
    public static final String ZTYHTNKNKYKKYKYMDX4      = "ztyhtnknkykkykymdx4";
    public static final String ZTYTNKNTKBTDKISNYUSX4    = "ztytnkntkbtdkisnyusx4";
    public static final String ZTYTNKNKAIYKKUJYTKSUX4   = "ztytnknkaiykkujytksux4";
    public static final String ZTYTNKNKAIYKKUJYGKX4     = "ztytnknkaiykkujygkx4";
    public static final String ZTYTENKANTEIKIHYOUJIX4   = "ztytenkanteikihyoujix4";
    public static final String ZTYHTNKNKYKNENKNSNPX4    = "ztyhtnknkyknenknsnpx4";
    public static final String ZTYHKTGTIKKIKKKNX4       = "ztyhktgtikkikkknx4";
    public static final String ZTYSKNJYUTUTKYKKYKKBN    = "ztysknjyututkykkykkbn";
    public static final String ZTYSWINGMINYUUPHRKEKNGK  = "ztyswingminyuuphrkekngk";
    public static final String ZTYSWINGMINYUUPHRKEJYUTUYM = "ztyswingminyuuphrkejyutuym";
    public static final String ZTYDFTOUNENDOITIJITOUNYUUP = "ztydftounendoitijitounyuup";
    public static final String ZTYDFKAIYAKUKUJYHKTGGK   = "ztydfkaiyakukujyhktggk";
    public static final String ZTYKAIYAKUKOUJYOTUKISUU  = "ztykaiyakukoujyotukisuu";
    public static final String ZTYDFKAIYAKUHENREIKIN    = "ztydfkaiyakuhenreikin";
    public static final String ZTYSYUUSEIS              = "ztysyuuseis";
    public static final String ZTYAATUKAISYAKEISYOUSISYACD = "ztyaatukaisyakeisyousisyacd";
    public static final String ZTYAATUKAISYAZAISEKIHYOUJI = "ztyaatukaisyazaisekihyouji";
    public static final String ZTYAATUKAISYABOSYUUJIAGE = "ztyaatukaisyabosyuujiage";
    public static final String ZTYAATUKAISYABSYJISIKAKUCD = "ztyaatukaisyabsyjisikakucd";
    public static final String ZTYAATUKAISYASIKAKUCD    = "ztyaatukaisyasikakucd";
    public static final String ZTYOKYKSMKUZTRHKKITIKBN  = "ztyokyksmkuztrhkkitikbn";
    public static final String ZTYHOYUUSISYACD          = "ztyhoyuusisyacd";
    public static final String ZTYSYOKANSISYACD         = "ztysyokansisyacd";
    public static final String ZTYTANTOUSYAKBN          = "ztytantousyakbn";
    public static final String ZTYTANTOUSYAKBNNEW       = "ztytantousyakbnnew";
    public static final String ZTYCLUBSUMISEIKBN        = "ztyclubsumiseikbn";
    public static final String ZTYFOLLOWTANTOUSYAKBN    = "ztyfollowtantousyakbn";
    public static final String ZTYTANTOUSYAJYOUTAIKBN   = "ztytantousyajyoutaikbn";
    public static final String ZTYKIHONYOTEII           = "ztykihonyoteii";
    public static final String ZTYTEIKIYOTEII           = "ztyteikiyoteii";
    public static final String ZTYSONOTAYOTEII          = "ztysonotayoteii";
    public static final String ZTYITIJIBARAIKIHONYOTEII = "ztyitijibaraikihonyoteii";
    public static final String ZTYITIJIBARAITEIKIYOTEII = "ztyitijibaraiteikiyoteii";
    public static final String ZTYITIJIBARAISONOTAYOTEII = "ztyitijibaraisonotayoteii";
    public static final String ZTYTENKANKIHONYOTEII     = "ztytenkankihonyoteii";
    public static final String ZTYTENKANTEIKIYOTEII     = "ztytenkanteikiyoteii";
    public static final String ZTYSZOUYOTEII            = "ztyszouyoteii";
    public static final String ZTYVESTINGYOTEII         = "ztyvestingyoteii";
    public static final String ZTYSIPPEITOKUYAKUYOTEII  = "ztysippeitokuyakuyoteii";
    public static final String ZTYSEIJINBYOUTOKUYAKUYOTEII = "ztyseijinbyoutokuyakuyoteii";
    public static final String ZTYJYOSEITOKUYAKUYOTEII  = "ztyjyoseitokuyakuyoteii";
    public static final String ZTYTUUINTOKUYAKUYOTEII   = "ztytuuintokuyakuyoteii";
    public static final String ZTYSAITEIHOSYOUI         = "ztysaiteihosyoui";
    public static final String ZTYVKISOITJBRKHNYOTEII   = "ztyvkisoitjbrkhnyoteii";
    public static final String ZTYVKISORRTZEROIKAHYOUJI = "ztyvkisorrtzeroikahyouji";
    public static final String ZTYSUURIYOUYOBIN3X2      = "ztysuuriyouyobin3x2";
    public static final String ZTYHOYUUSISYACD2         = "ztyhoyuusisyacd2";
    public static final String ZTYDFTUJYUKUJYKISNKISIYM = "ztydftujyukujykisnkisiym";
    public static final String ZTYTIKIKKTBRIJYUTUTKSU   = "ztytikikktbrijyututksu";
    public static final String ZTYSYUNYUMRTIKYKJTIGNGTKBN = "ztysyunyumrtikykjtigngtkbn";
    public static final String ZTYHHKDRTKYKARIHYJ       = "ztyhhkdrtkykarihyj";
    public static final String ZTYKYKDRTKYKARIHYJ       = "ztykykdrtkykarihyj";
    public static final String ZTYYOBIV10X14            = "ztyyobiv10x14";
    public static final String ZTYKAPPADHKTGKUJYGKX1    = "ztykappadhktgkujygkx1";
    public static final String ZTYKAPPADHKTGKUJYGKX2    = "ztykappadhktgkujygkx2";
    public static final String ZTYKAPPADHKTGKUJYGKX3    = "ztykappadhktgkujygkx3";
    public static final String ZTYKAPPADHKTGKUJYGKX4    = "ztykappadhktgkujygkx4";
    public static final String ZTYTRKZSGKAIYKKJYNSTMTKZNDK = "ztytrkzsgkaiykkjynstmtkzndk";
    public static final String ZTYPMENKOURYOKUHASSEIYMD = "ztypmenkouryokuhasseiymd";
    public static final String ZTYSUURIYOUYOBIN5        = "ztysuuriyouyobin5";
    public static final String ZTYSUURIYOUYOBIN13       = "ztysuuriyouyobin13";
    public static final String ZTYYOBIN11X35            = "ztyyobin11x35";
    public static final String ZTYYOBIN11X36            = "ztyyobin11x36";
    public static final String ZTYYOBIN11X37            = "ztyyobin11x37";
    public static final String ZTYTOKUYAKUKOUMOKUV200   = "ztytokuyakukoumokuv200";
    public static final String ZTYTOKUYAKUKOUMOKUV200X2 = "ztytokuyakukoumokuv200x2";
    public static final String ZTYTOKUYAKUKOUMOKUV200X3 = "ztytokuyakukoumokuv200x3";
    public static final String ZTYTOKUYAKUKOUMOKUV200X4 = "ztytokuyakukoumokuv200x4";
    public static final String ZTYTOKUYAKUKOUMOKUV200X5 = "ztytokuyakukoumokuv200x5";
    public static final String ZTYTOKUYAKUKOUMOKUV200X6 = "ztytokuyakukoumokuv200x6";
    public static final String ZTYTOKUYAKUKOUMOKUV200X7 = "ztytokuyakukoumokuv200x7";
    public static final String ZTYTOKUYAKUKOUMOKUV200X8 = "ztytokuyakukoumokuv200x8";
    public static final String ZTYTOKUYAKUKOUMOKUV200X9 = "ztytokuyakukoumokuv200x9";
    public static final String ZTYTOKUYAKUKOUMOKUV200X10 = "ztytokuyakukoumokuv200x10";
    public static final String ZTYTOKUYAKUKOUMOKUV200X11 = "ztytokuyakukoumokuv200x11";
    public static final String ZTYTOKUYAKUKOUMOKUV200X12 = "ztytokuyakukoumokuv200x12";
    public static final String ZTYTOKUYAKUKOUMOKUV200X13 = "ztytokuyakukoumokuv200x13";
    public static final String ZTYTOKUYAKUKOUMOKUV200X14 = "ztytokuyakukoumokuv200x14";
    public static final String ZTYTOKUYAKUKOUMOKUV200X15 = "ztytokuyakukoumokuv200x15";
    public static final String ZTYTOKUYAKUKOUMOKUV200X16 = "ztytokuyakukoumokuv200x16";
    public static final String ZTYTOKUYAKUKOUMOKUV200X17 = "ztytokuyakukoumokuv200x17";
    public static final String ZTYTOKUYAKUKOUMOKUV200X18 = "ztytokuyakukoumokuv200x18";
    public static final String ZTYTOKUYAKUKOUMOKUV200X19 = "ztytokuyakukoumokuv200x19";
    public static final String ZTYTOKUYAKUKOUMOKUV200X20 = "ztytokuyakukoumokuv200x20";
    public static final String ZTYTOKUYAKUKOUMOKUV200X21 = "ztytokuyakukoumokuv200x21";
    public static final String ZTYTOKUYAKUKOUMOKUV200X22 = "ztytokuyakukoumokuv200x22";
    public static final String ZTYTOKUYAKUKOUMOKUV200X23 = "ztytokuyakukoumokuv200x23";
    public static final String ZTYTOKUYAKUKOUMOKUV200X24 = "ztytokuyakukoumokuv200x24";
    public static final String ZTYTOKUYAKUKOUMOKUV200X25 = "ztytokuyakukoumokuv200x25";
    public static final String ZTYTOKUYAKUKOUMOKUV200X26 = "ztytokuyakukoumokuv200x26";
    public static final String ZTYTOKUYAKUKOUMOKUV200X27 = "ztytokuyakukoumokuv200x27";
    public static final String ZTYTOKUYAKUKOUMOKUV200X28 = "ztytokuyakukoumokuv200x28";
    public static final String ZTYTOKUYAKUKOUMOKUV200X29 = "ztytokuyakukoumokuv200x29";
    public static final String ZTYTOKUYAKUKOUMOKUV200X30 = "ztytokuyakukoumokuv200x30";
    public static final String ZTYTOKUYAKUKOUMOKUV200X31 = "ztytokuyakukoumokuv200x31";
    public static final String ZTYTOKUYAKUKOUMOKUV200X32 = "ztytokuyakukoumokuv200x32";
    public static final String ZTYTOKUYAKUKOUMOKUV200X33 = "ztytokuyakukoumokuv200x33";
    public static final String ZTYTOKUYAKUKOUMOKUV200X34 = "ztytokuyakukoumokuv200x34";
    public static final String ZTYTOKUYAKUKOUMOKUV200X35 = "ztytokuyakukoumokuv200x35";
    public static final String ZTYTOKUYAKUKOUMOKUV200X36 = "ztytokuyakukoumokuv200x36";
    public static final String ZTYTOKUYAKUKOUMOKUV200X37 = "ztytokuyakukoumokuv200x37";
    public static final String ZTYTOKUYAKUKOUMOKUV200X38 = "ztytokuyakukoumokuv200x38";
    public static final String ZTYTOKUYAKUKOUMOKUV200X39 = "ztytokuyakukoumokuv200x39";
    public static final String ZTYTOKUYAKUKOUMOKUV200X40 = "ztytokuyakukoumokuv200x40";
    public static final String ZTYSRKAIYAKUKOUJYORITU   = "ztysrkaiyakukoujyoritu";
    public static final String ZTYSRTEIKISHRTKYKHUKAUMU = "ztysrteikishrtkykhukaumu";

    private final PKST_HoyuuMeisaiTyukeiyouItzHzn primaryKey;

    public GenST_HoyuuMeisaiTyukeiyouItzHzn() {
        primaryKey = new PKST_HoyuuMeisaiTyukeiyouItzHzn();
    }

    public GenST_HoyuuMeisaiTyukeiyouItzHzn(
        String pZtysrkijyunym,
        String pZtysrkakutyoujobcd,
        Integer pZtysequenceno
    ) {
        primaryKey = new PKST_HoyuuMeisaiTyukeiyouItzHzn(
            pZtysrkijyunym,
            pZtysrkakutyoujobcd,
            pZtysequenceno
        );
    }

    @Transient
    @Override
    public PKST_HoyuuMeisaiTyukeiyouItzHzn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_HoyuuMeisaiTyukeiyouItzHzn> getMetaClass() {
        return QST_HoyuuMeisaiTyukeiyouItzHzn.class;
    }

    @Id
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSRKIJYUNYM)
    public String getZtysrkijyunym() {
        return getPrimaryKey().getZtysrkijyunym();
    }

    public void setZtysrkijyunym(String pZtysrkijyunym) {
        getPrimaryKey().setZtysrkijyunym(pZtysrkijyunym);
    }

    @Id
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSRKAKUTYOUJOBCD)
    public String getZtysrkakutyoujobcd() {
        return getPrimaryKey().getZtysrkakutyoujobcd();
    }

    public void setZtysrkakutyoujobcd(String pZtysrkakutyoujobcd) {
        getPrimaryKey().setZtysrkakutyoujobcd(pZtysrkakutyoujobcd);
    }

    @Id
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSEQUENCENO)
    public Integer getZtysequenceno() {
        return getPrimaryKey().getZtysequenceno();
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysequenceno(Integer pZtysequenceno) {
        getPrimaryKey().setZtysequenceno(pZtysequenceno);
    }

    private Integer ztyyuukourecordlength;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYUUKOURECORDLENGTH)
    public Integer getZtyyuukourecordlength() {
        return ztyyuukourecordlength;
    }

    public void setZtyyuukourecordlength(Integer pZtyyuukourecordlength) {
        ztyyuukourecordlength = pZtyyuukourecordlength;
    }

    private String ztyrdwarea;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRDWAREA)
    public String getZtyrdwarea() {
        return ztyrdwarea;
    }

    public void setZtyrdwarea(String pZtyrdwarea) {
        ztyrdwarea = pZtyrdwarea;
    }

    private String ztyrecordkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRECORDKBN)
    public String getZtyrecordkbn() {
        return ztyrecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyrecordkbn(String pZtyrecordkbn) {
        ztyrecordkbn = pZtyrecordkbn;
    }

    private String ztynenkinkaisigohyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYNENKINKAISIGOHYOUJI)
    public String getZtynenkinkaisigohyouji() {
        return ztynenkinkaisigohyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtynenkinkaisigohyouji(String pZtynenkinkaisigohyouji) {
        ztynenkinkaisigohyouji = pZtynenkinkaisigohyouji;
    }

    private String ztynksgokurikosidhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYNKSGOKURIKOSIDHYJ)
    public String getZtynksgokurikosidhyj() {
        return ztynksgokurikosidhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtynksgokurikosidhyj(String pZtynksgokurikosidhyj) {
        ztynksgokurikosidhyj = pZtynksgokurikosidhyj;
    }

    private String ztykeijyouym;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKEIJYOUYM)
    public String getZtykeijyouym() {
        return ztykeijyouym;
    }

    public void setZtykeijyouym(String pZtykeijyouym) {
        ztykeijyouym = pZtykeijyouym;
    }

    private String ztyidojiyukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYIDOJIYUKBN)
    public String getZtyidojiyukbn() {
        return ztyidojiyukbn;
    }

    public void setZtyidojiyukbn(String pZtyidojiyukbn) {
        ztyidojiyukbn = pZtyidojiyukbn;
    }

    private String ztyzougenkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZOUGENKBN)
    public String getZtyzougenkbn() {
        return ztyzougenkbn;
    }

    public void setZtyzougenkbn(String pZtyzougenkbn) {
        ztyzougenkbn = pZtyzougenkbn;
    }

    private String ztyidourecordkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYIDOURECORDKBN)
    public String getZtyidourecordkbn() {
        return ztyidourecordkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyidourecordkbn(String pZtyidourecordkbn) {
        ztyidourecordkbn = pZtyidourecordkbn;
    }

    private String ztykeijyouctrlkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKEIJYOUCTRLKBN)
    public String getZtykeijyouctrlkbn() {
        return ztykeijyouctrlkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykeijyouctrlkbn(String pZtykeijyouctrlkbn) {
        ztykeijyouctrlkbn = pZtykeijyouctrlkbn;
    }

    private String ztyhenkousyoriymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHENKOUSYORIYMD)
    public String getZtyhenkousyoriymd() {
        return ztyhenkousyoriymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhenkousyoriymd(String pZtyhenkousyoriymd) {
        ztyhenkousyoriymd = pZtyhenkousyoriymd;
    }

    private Integer ztykykmfksnctr;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKMFKSNCTR)
    public Integer getZtykykmfksnctr() {
        return ztykykmfksnctr;
    }

    public void setZtykykmfksnctr(Integer pZtykykmfksnctr) {
        ztykykmfksnctr = pZtykykmfksnctr;
    }

    private Integer ztyrecordctr;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRECORDCTR)
    public Integer getZtyrecordctr() {
        return ztyrecordctr;
    }

    public void setZtyrecordctr(Integer pZtyrecordctr) {
        ztyrecordctr = pZtyrecordctr;
    }

    private String ztysuuriyoukouryokukaisiymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUKOURYOKUKAISIYMD)
    public String getZtysuuriyoukouryokukaisiymd() {
        return ztysuuriyoukouryokukaisiymd;
    }

    public void setZtysuuriyoukouryokukaisiymd(String pZtysuuriyoukouryokukaisiymd) {
        ztysuuriyoukouryokukaisiymd = pZtysuuriyoukouryokukaisiymd;
    }

    private String ztydenymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDENYMD)
    public String getZtydenymd() {
        return ztydenymd;
    }

    public void setZtydenymd(String pZtydenymd) {
        ztydenymd = pZtydenymd;
    }

    private String ztybluekeizokuhyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYBLUEKEIZOKUHYOUJI)
    public String getZtybluekeizokuhyouji() {
        return ztybluekeizokuhyouji;
    }

    public void setZtybluekeizokuhyouji(String pZtybluekeizokuhyouji) {
        ztybluekeizokuhyouji = pZtybluekeizokuhyouji;
    }

    private String ztysuuriyouyobin1x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN1X2)
    public String getZtysuuriyouyobin1x2() {
        return ztysuuriyouyobin1x2;
    }

    public void setZtysuuriyouyobin1x2(String pZtysuuriyouyobin1x2) {
        ztysuuriyouyobin1x2 = pZtysuuriyouyobin1x2;
    }

    private String ztytoukeikeijyoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOUKEIKEIJYOUKBN)
    public String getZtytoukeikeijyoukbn() {
        return ztytoukeikeijyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytoukeikeijyoukbn(String pZtytoukeikeijyoukbn) {
        ztytoukeikeijyoukbn = pZtytoukeikeijyoukbn;
    }

    private String ztyraysystemhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztyzenkiidouteiseikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZENKIIDOUTEISEIKBN)
    public String getZtyzenkiidouteiseikbn() {
        return ztyzenkiidouteiseikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyzenkiidouteiseikbn(String pZtyzenkiidouteiseikbn) {
        ztyzenkiidouteiseikbn = pZtyzenkiidouteiseikbn;
    }

    private String ztybsyym;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYBSYYM)
    public String getZtybsyym() {
        return ztybsyym;
    }

    public void setZtybsyym(String pZtybsyym) {
        ztybsyym = pZtybsyym;
    }

    private String ztytenkangokeiyakubosyuuym;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANGOKEIYAKUBOSYUUYM)
    public String getZtytenkangokeiyakubosyuuym() {
        return ztytenkangokeiyakubosyuuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtytenkangokeiyakubosyuuym(String pZtytenkangokeiyakubosyuuym) {
        ztytenkangokeiyakubosyuuym = pZtytenkangokeiyakubosyuuym;
    }

    private String ztyidoujiyuucd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYIDOUJIYUUCD)
    public String getZtyidoujiyuucd() {
        return ztyidoujiyuucd;
    }

    public void setZtyidoujiyuucd(String pZtyidoujiyuucd) {
        ztyidoujiyuucd = pZtyidoujiyuucd;
    }

    private String ztysyoricd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYORICD)
    public String getZtysyoricd() {
        return ztysyoricd;
    }

    public void setZtysyoricd(String pZtysyoricd) {
        ztysyoricd = pZtysyoricd;
    }

    private String ztysekininteiseihyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSEKININTEISEIHYOUJI)
    public String getZtysekininteiseihyouji() {
        return ztysekininteiseihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysekininteiseihyouji(String pZtysekininteiseihyouji) {
        ztysekininteiseihyouji = pZtysekininteiseihyouji;
    }

    private String ztysuuriyouyobin8;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN8)
    public String getZtysuuriyouyobin8() {
        return ztysuuriyouyobin8;
    }

    public void setZtysuuriyouyobin8(String pZtysuuriyouyobin8) {
        ztysuuriyouyobin8 = pZtysuuriyouyobin8;
    }

    private String ztysihankibikinkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSIHANKIBIKINKBN)
    public String getZtysihankibikinkbn() {
        return ztysihankibikinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysihankibikinkbn(String pZtysihankibikinkbn) {
        ztysihankibikinkbn = pZtysihankibikinkbn;
    }

    private String ztysuuriyouyobin1x3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN1X3)
    public String getZtysuuriyouyobin1x3() {
        return ztysuuriyouyobin1x3;
    }

    public void setZtysuuriyouyobin1x3(String pZtysuuriyouyobin1x3) {
        ztysuuriyouyobin1x3 = pZtysuuriyouyobin1x3;
    }

    private String ztydatakanrino;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDATAKANRINO)
    public String getZtydatakanrino() {
        return ztydatakanrino;
    }

    public void setZtydatakanrino(String pZtydatakanrino) {
        ztydatakanrino = pZtydatakanrino;
    }

    private String ztyhknsyukigou;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztyhknsyuruikigousedaikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKNSYURUIKIGOUSEDAIKBN)
    public String getZtyhknsyuruikigousedaikbn() {
        return ztyhknsyuruikigousedaikbn;
    }

    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        ztyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }

    private String ztysotodasipmenkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSOTODASIPMENKBN)
    public String getZtysotodasipmenkbn() {
        return ztysotodasipmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasipmenkbn(String pZtysotodasipmenkbn) {
        ztysotodasipmenkbn = pZtysotodasipmenkbn;
    }

    private String ztystdssytikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSTDSSYTIKBN)
    public String getZtystdssytikbn() {
        return ztystdssytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssytikbn(String pZtystdssytikbn) {
        ztystdssytikbn = pZtystdssytikbn;
    }

    private String ztystdssnskbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSTDSSNSKBN)
    public String getZtystdssnskbn() {
        return ztystdssnskbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdssnskbn(String pZtystdssnskbn) {
        ztystdssnskbn = pZtystdssnskbn;
    }

    private String ztysotodasimanagehyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSOTODASIMANAGEHYOUJI)
    public String getZtysotodasimanagehyouji() {
        return ztysotodasimanagehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasimanagehyouji(String pZtysotodasimanagehyouji) {
        ztysotodasimanagehyouji = pZtysotodasimanagehyouji;
    }

    private String ztysotodasiphkbnmnoshyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSOTODASIPHKBNMNOSHYOUJI)
    public String getZtysotodasiphkbnmnoshyouji() {
        return ztysotodasiphkbnmnoshyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysotodasiphkbnmnoshyouji(String pZtysotodasiphkbnmnoshyouji) {
        ztysotodasiphkbnmnoshyouji = pZtysotodasiphkbnmnoshyouji;
    }

    private String ztystdsstkjytkyuhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSTDSSTKJYTKYUHYJ)
    public String getZtystdsstkjytkyuhyj() {
        return ztystdsstkjytkyuhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtystdsstkjytkyuhyj(String pZtystdsstkjytkyuhyj) {
        ztystdsstkjytkyuhyj = pZtystdsstkjytkyuhyj;
    }

    private String ztykbnkeiriyousegmentkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKBNKEIRIYOUSEGMENTKBN)
    public String getZtykbnkeiriyousegmentkbn() {
        return ztykbnkeiriyousegmentkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyousegmentkbn(String pZtykbnkeiriyousegmentkbn) {
        ztykbnkeiriyousegmentkbn = pZtykbnkeiriyousegmentkbn;
    }

    private String ztykbnkeiriyourgnbnskkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKBNKEIRIYOURGNBNSKKBN)
    public String getZtykbnkeiriyourgnbnskkbn() {
        return ztykbnkeiriyourgnbnskkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykbnkeiriyourgnbnskkbn(String pZtykbnkeiriyourgnbnskkbn) {
        ztykbnkeiriyourgnbnskkbn = pZtykbnkeiriyourgnbnskkbn;
    }

    private String ztysuurisyuruicd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURISYURUICD)
    public String getZtysuurisyuruicd() {
        return ztysuurisyuruicd;
    }

    public void setZtysuurisyuruicd(String pZtysuurisyuruicd) {
        ztysuurisyuruicd = pZtysuurisyuruicd;
    }

    private String ztyhosyoukinoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHOSYOUKINOUKBN)
    public String getZtyhosyoukinoukbn() {
        return ztyhosyoukinoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhosyoukinoukbn(String pZtyhosyoukinoukbn) {
        ztyhosyoukinoukbn = pZtyhosyoukinoukbn;
    }

    private String ztydaikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAIKBN)
    public String getZtydaikbn() {
        return ztydaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydaikbn(String pZtydaikbn) {
        ztydaikbn = pZtydaikbn;
    }

    private String ztytyuukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTYUUKBN)
    public String getZtytyuukbn() {
        return ztytyuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtytyuukbn(String pZtytyuukbn) {
        ztytyuukbn = pZtytyuukbn;
    }

    private String ztysyoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYOUKBN)
    public String getZtysyoukbn() {
        return ztysyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtysyoukbn(String pZtysyoukbn) {
        ztysyoukbn = pZtysyoukbn;
    }

    private String ztysedaikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSEDAIKBN)
    public String getZtysedaikbn() {
        return ztysedaikbn;
    }

    public void setZtysedaikbn(String pZtysedaikbn) {
        ztysedaikbn = pZtysedaikbn;
    }

    private String ztyharaikatakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHARAIKATAKBN)
    public String getZtyharaikatakbn() {
        return ztyharaikatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyharaikatakbn(String pZtyharaikatakbn) {
        ztyharaikatakbn = pZtyharaikatakbn;
    }

    private String ztykykymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztyhknkkn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysaimnkkykhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAIMNKKYKHYJ)
    public String getZtysaimnkkykhyj() {
        return ztysaimnkkykhyj;
    }

    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        ztysaimnkkykhyj = pZtysaimnkkykhyj;
    }

    private String ztyannaifuyouriyuukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYANNAIFUYOURIYUUKBN)
    public String getZtyannaifuyouriyuukbn() {
        return ztyannaifuyouriyuukbn;
    }

    public void setZtyannaifuyouriyuukbn(String pZtyannaifuyouriyuukbn) {
        ztyannaifuyouriyuukbn = pZtyannaifuyouriyuukbn;
    }

    private String ztytksyuannaikykkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTKSYUANNAIKYKKBN)
    public String getZtytksyuannaikykkbn() {
        return ztytksyuannaikykkbn;
    }

    public void setZtytksyuannaikykkbn(String pZtytksyuannaikykkbn) {
        ztytksyuannaikykkbn = pZtytksyuannaikykkbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztysdpdkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSDPDKBN)
    public String getZtysdpdkbn() {
        return ztysdpdkbn;
    }

    public void setZtysdpdkbn(String pZtysdpdkbn) {
        ztysdpdkbn = pZtysdpdkbn;
    }

    private String ztyryouritukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRYOURITUKBN)
    public String getZtyryouritukbn() {
        return ztyryouritukbn;
    }

    public void setZtyryouritukbn(String pZtyryouritukbn) {
        ztyryouritukbn = pZtyryouritukbn;
    }

    private String ztyao3tyou3sibousdatehyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAO3TYOU3SIBOUSDATEHYOUJI)
    public String getZtyao3tyou3sibousdatehyouji() {
        return ztyao3tyou3sibousdatehyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyao3tyou3sibousdatehyouji(String pZtyao3tyou3sibousdatehyouji) {
        ztyao3tyou3sibousdatehyouji = pZtyao3tyou3sibousdatehyouji;
    }

    private String ztyhhknseikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztyhihokensyaagev2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHIHOKENSYAAGEV2)
    public String getZtyhihokensyaagev2() {
        return ztyhihokensyaagev2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        ztyhihokensyaagev2 = pZtyhihokensyaagev2;
    }

    private String ztykyksyanen;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztydai2hhknnen;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAI2HHKNNEN)
    public String getZtydai2hhknnen() {
        return ztydai2hhknnen;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2hhknnen(String pZtydai2hhknnen) {
        ztydai2hhknnen = pZtydai2hhknnen;
    }

    private String ztytkbthsyumnryuhyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTKBTHSYUMNRYUHYOUJI)
    public String getZtytkbthsyumnryuhyouji() {
        return ztytkbthsyumnryuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytkbthsyumnryuhyouji(String pZtytkbthsyumnryuhyouji) {
        ztytkbthsyumnryuhyouji = pZtytkbthsyumnryuhyouji;
    }

    private String ztysyukeiyakupwaribikikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYUKEIYAKUPWARIBIKIKBN)
    public String getZtysyukeiyakupwaribikikbn() {
        return ztysyukeiyakupwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysyukeiyakupwaribikikbn(String pZtysyukeiyakupwaribikikbn) {
        ztysyukeiyakupwaribikikbn = pZtysyukeiyakupwaribikikbn;
    }

    private String ztytenkanwaribikikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANWARIBIKIKBN)
    public String getZtytenkanwaribikikbn() {
        return ztytenkanwaribikikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytenkanwaribikikbn(String pZtytenkanwaribikikbn) {
        ztytenkanwaribikikbn = pZtytenkanwaribikikbn;
    }

    private String ztyyuuhitutnknyuguryurtkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYUUHITUTNKNYUGURYURTKBN)
    public String getZtyyuuhitutnknyuguryurtkbn() {
        return ztyyuuhitutnknyuguryurtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyyuuhitutnknyuguryurtkbn(String pZtyyuuhitutnknyuguryurtkbn) {
        ztyyuuhitutnknyuguryurtkbn = pZtyyuuhitutnknyuguryurtkbn;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private Long ztytokujyoup;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUJYOUP)
    public Long getZtytokujyoup() {
        return ztytokujyoup;
    }

    public void setZtytokujyoup(Long pZtytokujyoup) {
        ztytokujyoup = pZtytokujyoup;
    }

    private Long ztysiteizukisyukeiyakup;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSITEIZUKISYUKEIYAKUP)
    public Long getZtysiteizukisyukeiyakup() {
        return ztysiteizukisyukeiyakup;
    }

    public void setZtysiteizukisyukeiyakup(Long pZtysiteizukisyukeiyakup) {
        ztysiteizukisyukeiyakup = pZtysiteizukisyukeiyakup;
    }

    private Long ztykihons;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKIHONS)
    public Long getZtykihons() {
        return ztykihons;
    }

    public void setZtykihons(Long pZtykihons) {
        ztykihons = pZtykihons;
    }

    private Long ztysibous;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSIBOUS)
    public Long getZtysibous() {
        return ztysibous;
    }

    public void setZtysibous(Long pZtysibous) {
        ztysibous = pZtysibous;
    }

    private Long ztyhenkougokihons;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHENKOUGOKIHONS)
    public Long getZtyhenkougokihons() {
        return ztyhenkougokihons;
    }

    public void setZtyhenkougokihons(Long pZtyhenkougokihons) {
        ztyhenkougokihons = pZtyhenkougokihons;
    }

    private Long ztyhenkougosibous;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHENKOUGOSIBOUS)
    public Long getZtyhenkougosibous() {
        return ztyhenkougosibous;
    }

    public void setZtyhenkougosibous(Long pZtyhenkougosibous) {
        ztyhenkougosibous = pZtyhenkougosibous;
    }

    private String ztyhenkouymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHENKOUYMD)
    public String getZtyhenkouymd() {
        return ztyhenkouymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhenkouymd(String pZtyhenkouymd) {
        ztyhenkouymd = pZtyhenkouymd;
    }

    private String ztyentyoukikan;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYENTYOUKIKAN)
    public String getZtyentyoukikan() {
        return ztyentyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyentyoukikan(String pZtyentyoukikan) {
        ztyentyoukikan = pZtyentyoukikan;
    }

    private String ztyseizonkyuuhukinsiteimd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSEIZONKYUUHUKINSITEIMD)
    public String getZtyseizonkyuuhukinsiteimd() {
        return ztyseizonkyuuhukinsiteimd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyseizonkyuuhukinsiteimd(String pZtyseizonkyuuhukinsiteimd) {
        ztyseizonkyuuhukinsiteimd = pZtyseizonkyuuhukinsiteimd;
    }

    private Long ztysyukeiyakusiharaikingaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYUKEIYAKUSIHARAIKINGAKU)
    public Long getZtysyukeiyakusiharaikingaku() {
        return ztysyukeiyakusiharaikingaku;
    }

    public void setZtysyukeiyakusiharaikingaku(Long pZtysyukeiyakusiharaikingaku) {
        ztysyukeiyakusiharaikingaku = pZtysyukeiyakusiharaikingaku;
    }

    private String ztyatukaisisyatodouhukencd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYATUKAISISYATODOUHUKENCD)
    public String getZtyatukaisisyatodouhukencd() {
        return ztyatukaisisyatodouhukencd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyatukaisisyatodouhukencd(String pZtyatukaisisyatodouhukencd) {
        ztyatukaisisyatodouhukencd = pZtyatukaisisyatodouhukencd;
    }

    private Integer ztytokuyakuhukasuu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUHUKASUU)
    public Integer getZtytokuyakuhukasuu() {
        return ztytokuyakuhukasuu;
    }

    public void setZtytokuyakuhukasuu(Integer pZtytokuyakuhukasuu) {
        ztytokuyakuhukasuu = pZtytokuyakuhukasuu;
    }

    private String ztydi2hknkknikoujihisyaage;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDI2HKNKKNIKOUJIHISYAAGE)
    public String getZtydi2hknkknikoujihisyaage() {
        return ztydi2hknkknikoujihisyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydi2hknkknikoujihisyaage(String pZtydi2hknkknikoujihisyaage) {
        ztydi2hknkknikoujihisyaage = pZtydi2hknkknikoujihisyaage;
    }

    private String ztyhrimnentyoumaephrkkkn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHRIMNENTYOUMAEPHRKKKN)
    public String getZtyhrimnentyoumaephrkkkn() {
        return ztyhrimnentyoumaephrkkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhrimnentyoumaephrkkkn(String pZtyhrimnentyoumaephrkkkn) {
        ztyhrimnentyoumaephrkkkn = pZtyhrimnentyoumaephrkkkn;
    }

    private String ztytokubetuhosyoukikan;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUBETUHOSYOUKIKAN)
    public String getZtytokubetuhosyoukikan() {
        return ztytokubetuhosyoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokubetuhosyoukikan(String pZtytokubetuhosyoukikan) {
        ztytokubetuhosyoukikan = pZtytokubetuhosyoukikan;
    }

    private String ztykousinmanryouage;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKOUSINMANRYOUAGE)
    public String getZtykousinmanryouage() {
        return ztykousinmanryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykousinmanryouage(String pZtykousinmanryouage) {
        ztykousinmanryouage = pZtykousinmanryouage;
    }

    private String ztyknkuzusnzyrttekitkarihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKNKUZUSNZYRTTEKITKARIHYJ)
    public String getZtyknkuzusnzyrttekitkarihyj() {
        return ztyknkuzusnzyrttekitkarihyj;
    }

    public void setZtyknkuzusnzyrttekitkarihyj(String pZtyknkuzusnzyrttekitkarihyj) {
        ztyknkuzusnzyrttekitkarihyj = pZtyknkuzusnzyrttekitkarihyj;
    }

    private String ztykuriagekurisagekbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKURIAGEKURISAGEKBN)
    public String getZtykuriagekurisagekbn() {
        return ztykuriagekurisagekbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykuriagekurisagekbn(String pZtykuriagekurisagekbn) {
        ztykuriagekurisagekbn = pZtykuriagekurisagekbn;
    }

    private String ztyhrizmjhknsyukigousdkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHRIZMJHKNSYUKIGOUSDKBN)
    public String getZtyhrizmjhknsyukigousdkbn() {
        return ztyhrizmjhknsyukigousdkbn;
    }

    public void setZtyhrizmjhknsyukigousdkbn(String pZtyhrizmjhknsyukigousdkbn) {
        ztyhrizmjhknsyukigousdkbn = pZtyhrizmjhknsyukigousdkbn;
    }

    private String ztykrsgjhknsyukigousdkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKRSGJHKNSYUKIGOUSDKBN)
    public String getZtykrsgjhknsyukigousdkbn() {
        return ztykrsgjhknsyukigousdkbn;
    }

    public void setZtykrsgjhknsyukigousdkbn(String pZtykrsgjhknsyukigousdkbn) {
        ztykrsgjhknsyukigousdkbn = pZtykrsgjhknsyukigousdkbn;
    }

    private String ztysotodasisyouhinkaiteikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSOTODASISYOUHINKAITEIKBN)
    public String getZtysotodasisyouhinkaiteikbn() {
        return ztysotodasisyouhinkaiteikbn;
    }

    public void setZtysotodasisyouhinkaiteikbn(String pZtysotodasisyouhinkaiteikbn) {
        ztysotodasisyouhinkaiteikbn = pZtysotodasisyouhinkaiteikbn;
    }

    private String ztyyobiv4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV4)
    public String getZtyyobiv4() {
        return ztyyobiv4;
    }

    public void setZtyyobiv4(String pZtyyobiv4) {
        ztyyobiv4 = pZtyyobiv4;
    }

    private Long ztygoukeitenkans;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEITENKANS)
    public Long getZtygoukeitenkans() {
        return ztygoukeitenkans;
    }

    public void setZtygoukeitenkans(Long pZtygoukeitenkans) {
        ztygoukeitenkans = pZtygoukeitenkans;
    }

    private Long ztygoukeipbubuntenkans;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEIPBUBUNTENKANS)
    public Long getZtygoukeipbubuntenkans() {
        return ztygoukeipbubuntenkans;
    }

    public void setZtygoukeipbubuntenkans(Long pZtygoukeipbubuntenkans) {
        ztygoukeipbubuntenkans = pZtygoukeipbubuntenkans;
    }

    private String ztytenkanteikisyuruikigou;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANTEIKISYURUIKIGOU)
    public String getZtytenkanteikisyuruikigou() {
        return ztytenkanteikisyuruikigou;
    }

    public void setZtytenkanteikisyuruikigou(String pZtytenkanteikisyuruikigou) {
        ztytenkanteikisyuruikigou = pZtytenkanteikisyuruikigou;
    }

    private String ztytenkanteikikigousedaikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANTEIKIKIGOUSEDAIKBN)
    public String getZtytenkanteikikigousedaikbn() {
        return ztytenkanteikikigousedaikbn;
    }

    public void setZtytenkanteikikigousedaikbn(String pZtytenkanteikikigousedaikbn) {
        ztytenkanteikikigousedaikbn = pZtytenkanteikikigousedaikbn;
    }

    private String ztytnkntiksotodasikusnkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNTIKSOTODASIKUSNKBN)
    public String getZtytnkntiksotodasikusnkbn() {
        return ztytnkntiksotodasikusnkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytnkntiksotodasikusnkbn(String pZtytnkntiksotodasikusnkbn) {
        ztytnkntiksotodasikusnkbn = pZtytnkntiksotodasikusnkbn;
    }

    private String ztytnkntikstdspmenkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNTIKSTDSPMENKBN)
    public String getZtytnkntikstdspmenkbn() {
        return ztytnkntikstdspmenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytnkntikstdspmenkbn(String pZtytnkntikstdspmenkbn) {
        ztytnkntikstdspmenkbn = pZtytnkntikstdspmenkbn;
    }

    private String ztytenkanteikikigouyobi;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANTEIKIKIGOUYOBI)
    public String getZtytenkanteikikigouyobi() {
        return ztytenkanteikikigouyobi;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanteikikigouyobi(String pZtytenkanteikikigouyobi) {
        ztytenkanteikikigouyobi = pZtytenkanteikikigouyobi;
    }

    private String ztytenkanteikikikan;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANTEIKIKIKAN)
    public String getZtytenkanteikikikan() {
        return ztytenkanteikikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytenkanteikikikan(String pZtytenkanteikikikan) {
        ztytenkanteikikikan = pZtytenkanteikikikan;
    }

    private Long ztygoukeitenkanteikis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEITENKANTEIKIS)
    public Long getZtygoukeitenkanteikis() {
        return ztygoukeitenkanteikis;
    }

    public void setZtygoukeitenkanteikis(Long pZtygoukeitenkanteikis) {
        ztygoukeitenkanteikis = pZtygoukeitenkanteikis;
    }

    private String ztytnknteikinkshrkkn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNTEIKINKSHRKKN)
    public String getZtytnknteikinkshrkkn() {
        return ztytnknteikinkshrkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytnknteikinkshrkkn(String pZtytnknteikinkshrkkn) {
        ztytnknteikinkshrkkn = pZtytnknteikinkshrkkn;
    }

    private Long ztytenkansiharaikingaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANSIHARAIKINGAKU)
    public Long getZtytenkansiharaikingaku() {
        return ztytenkansiharaikingaku;
    }

    public void setZtytenkansiharaikingaku(Long pZtytenkansiharaikingaku) {
        ztytenkansiharaikingaku = pZtytenkansiharaikingaku;
    }

    private Long ztytnkntikshrkngk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNTIKSHRKNGK)
    public Long getZtytnkntikshrkngk() {
        return ztytnkntikshrkngk;
    }

    public void setZtytnkntikshrkngk(Long pZtytnkntikshrkngk) {
        ztytnkntikshrkngk = pZtytnkntikshrkngk;
    }

    private String ztytenkankaisuu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANKAISUU)
    public String getZtytenkankaisuu() {
        return ztytenkankaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkankaisuu(String pZtytenkankaisuu) {
        ztytenkankaisuu = pZtytenkankaisuu;
    }

    private Long ztygoukeitenkankakaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEITENKANKAKAKU)
    public Long getZtygoukeitenkankakaku() {
        return ztygoukeitenkankakaku;
    }

    public void setZtygoukeitenkankakaku(Long pZtygoukeitenkankakaku) {
        ztygoukeitenkankakaku = pZtygoukeitenkankakaku;
    }

    private BizNumber ztytnknkhnbbnjyuturt;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNKHNBBNJYUTURT)
    public BizNumber getZtytnknkhnbbnjyuturt() {
        return ztytnknkhnbbnjyuturt;
    }

    public void setZtytnknkhnbbnjyuturt(BizNumber pZtytnknkhnbbnjyuturt) {
        ztytnknkhnbbnjyuturt = pZtytnknkhnbbnjyuturt;
    }

    private Long ztywnasigoukeitenkanteikis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYWNASIGOUKEITENKANTEIKIS)
    public Long getZtywnasigoukeitenkanteikis() {
        return ztywnasigoukeitenkanteikis;
    }

    public void setZtywnasigoukeitenkanteikis(Long pZtywnasigoukeitenkanteikis) {
        ztywnasigoukeitenkanteikis = pZtywnasigoukeitenkanteikis;
    }

    private String ztytnknteikikousinmnryouage;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNTEIKIKOUSINMNRYOUAGE)
    public String getZtytnknteikikousinmnryouage() {
        return ztytnknteikikousinmnryouage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytnknteikikousinmnryouage(String pZtytnknteikikousinmnryouage) {
        ztytnknteikikousinmnryouage = pZtytnknteikikousinmnryouage;
    }

    private String ztyyobiv5;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV5)
    public String getZtyyobiv5() {
        return ztyyobiv5;
    }

    public void setZtyyobiv5(String pZtyyobiv5) {
        ztyyobiv5 = pZtyyobiv5;
    }

    private String ztykanyujidatakanrino;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKANYUJIDATAKANRINO)
    public String getZtykanyujidatakanrino() {
        return ztykanyujidatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZtykanyujidatakanrino(String pZtykanyujidatakanrino) {
        ztykanyujidatakanrino = pZtykanyujidatakanrino;
    }

    private String ztykanyujikykymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKANYUJIKYKYMD)
    public String getZtykanyujikykymd() {
        return ztykanyujikykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtykanyujikykymd(String pZtykanyujikykymd) {
        ztykanyujikykymd = pZtykanyujikykymd;
    }

    private String ztykanyuujihihokensyaage;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKANYUUJIHIHOKENSYAAGE)
    public String getZtykanyuujihihokensyaage() {
        return ztykanyuujihihokensyaage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykanyuujihihokensyaage(String pZtykanyuujihihokensyaage) {
        ztykanyuujihihokensyaage = pZtykanyuujihihokensyaage;
    }

    private String ztykanyuujitenkanhyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKANYUUJITENKANHYOUJI)
    public String getZtykanyuujitenkanhyouji() {
        return ztykanyuujitenkanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykanyuujitenkanhyouji(String pZtykanyuujitenkanhyouji) {
        ztykanyuujitenkanhyouji = pZtykanyuujitenkanhyouji;
    }

    private String ztyhsyuikktminaosikaisu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHSYUIKKTMINAOSIKAISU)
    public String getZtyhsyuikktminaosikaisu() {
        return ztyhsyuikktminaosikaisu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhsyuikktminaosikaisu(String pZtyhsyuikktminaosikaisu) {
        ztyhsyuikktminaosikaisu = pZtyhsyuikktminaosikaisu;
    }

    private BizNumber ztysknnjynbknsisnrt;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSKNNJYNBKNSISNRT)
    public BizNumber getZtysknnjynbknsisnrt() {
        return ztysknnjynbknsisnrt;
    }

    public void setZtysknnjynbknsisnrt(BizNumber pZtysknnjynbknsisnrt) {
        ztysknnjynbknsisnrt = pZtysknnjynbknsisnrt;
    }

    private String ztytkjykbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTKJYKBN)
    public String getZtytkjykbn() {
        return ztytkjykbn;
    }

    public void setZtytkjykbn(String pZtytkjykbn) {
        ztytkjykbn = pZtytkjykbn;
    }

    private String ztysakugenkikan;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAKUGENKIKAN)
    public String getZtysakugenkikan() {
        return ztysakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysakugenkikan(String pZtysakugenkikan) {
        ztysakugenkikan = pZtysakugenkikan;
    }

    private Integer ztyryoumasihyouten;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRYOUMASIHYOUTEN)
    public Integer getZtyryoumasihyouten() {
        return ztyryoumasihyouten;
    }

    public void setZtyryoumasihyouten(Integer pZtyryoumasihyouten) {
        ztyryoumasihyouten = pZtyryoumasihyouten;
    }

    private String ztysykyktkjyuryumsratehyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYKYKTKJYURYUMSRATEHYJ)
    public String getZtysykyktkjyuryumsratehyj() {
        return ztysykyktkjyuryumsratehyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysykyktkjyuryumsratehyj(String pZtysykyktkjyuryumsratehyj) {
        ztysykyktkjyuryumsratehyj = pZtysykyktkjyuryumsratehyj;
    }

    private BizNumber ztysykyktkjyuryumsrate;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYKYKTKJYURYUMSRATE)
    public BizNumber getZtysykyktkjyuryumsrate() {
        return ztysykyktkjyuryumsrate;
    }

    public void setZtysykyktkjyuryumsrate(BizNumber pZtysykyktkjyuryumsrate) {
        ztysykyktkjyuryumsrate = pZtysykyktkjyuryumsrate;
    }

    private String ztydai2tokujyoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAI2TOKUJYOUKBN)
    public String getZtydai2tokujyoukbn() {
        return ztydai2tokujyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2tokujyoukbn(String pZtydai2tokujyoukbn) {
        ztydai2tokujyoukbn = pZtydai2tokujyoukbn;
    }

    private String ztydai2sakugenkikan;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAI2SAKUGENKIKAN)
    public String getZtydai2sakugenkikan() {
        return ztydai2sakugenkikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2sakugenkikan(String pZtydai2sakugenkikan) {
        ztydai2sakugenkikan = pZtydai2sakugenkikan;
    }

    private Integer ztydai2ryoumasihyouten;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAI2RYOUMASIHYOUTEN)
    public Integer getZtydai2ryoumasihyouten() {
        return ztydai2ryoumasihyouten;
    }

    public void setZtydai2ryoumasihyouten(Integer pZtydai2ryoumasihyouten) {
        ztydai2ryoumasihyouten = pZtydai2ryoumasihyouten;
    }

    private String ztytokuteibuijyoukenhyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUTEIBUIJYOUKENHYOUJI)
    public String getZtytokuteibuijyoukenhyouji() {
        return ztytokuteibuijyoukenhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytokuteibuijyoukenhyouji(String pZtytokuteibuijyoukenhyouji) {
        ztytokuteibuijyoukenhyouji = pZtytokuteibuijyoukenhyouji;
    }

    private String ztytokuteibuino1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUTEIBUINO1)
    public String getZtytokuteibuino1() {
        return ztytokuteibuino1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokuteibuino1(String pZtytokuteibuino1) {
        ztytokuteibuino1 = pZtytokuteibuino1;
    }

    private String ztyhtnpkkn1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHTNPKKN1)
    public String getZtyhtnpkkn1() {
        return ztyhtnpkkn1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhtnpkkn1(String pZtyhtnpkkn1) {
        ztyhtnpkkn1 = pZtyhtnpkkn1;
    }

    private String ztytokuteibuino2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUTEIBUINO2)
    public String getZtytokuteibuino2() {
        return ztytokuteibuino2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytokuteibuino2(String pZtytokuteibuino2) {
        ztytokuteibuino2 = pZtytokuteibuino2;
    }

    private String ztyhtnpkkn2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHTNPKKN2)
    public String getZtyhtnpkkn2() {
        return ztyhtnpkkn2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhtnpkkn2(String pZtyhtnpkkn2) {
        ztyhtnpkkn2 = pZtyhtnpkkn2;
    }

    private String ztymhituiryuyutktbijyknhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMHITUIRYUYUTKTBIJYKNHYJ)
    public String getZtymhituiryuyutktbijyknhyj() {
        return ztymhituiryuyutktbijyknhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtymhituiryuyutktbijyknhyj(String pZtymhituiryuyutktbijyknhyj) {
        ztymhituiryuyutktbijyknhyj = pZtymhituiryuyutktbijyknhyj;
    }

    private String ztymuhaitouiryouyoutktbino1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMUHAITOUIRYOUYOUTKTBINO1)
    public String getZtymuhaitouiryouyoutktbino1() {
        return ztymuhaitouiryouyoutktbino1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtymuhaitouiryouyoutktbino1(String pZtymuhaitouiryouyoutktbino1) {
        ztymuhaitouiryouyoutktbino1 = pZtymuhaitouiryouyoutktbino1;
    }

    private String ztymuhaitouiryouyouhtnpkkn1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMUHAITOUIRYOUYOUHTNPKKN1)
    public String getZtymuhaitouiryouyouhtnpkkn1() {
        return ztymuhaitouiryouyouhtnpkkn1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtymuhaitouiryouyouhtnpkkn1(String pZtymuhaitouiryouyouhtnpkkn1) {
        ztymuhaitouiryouyouhtnpkkn1 = pZtymuhaitouiryouyouhtnpkkn1;
    }

    private String ztymuhaitouiryouyoutktbino2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMUHAITOUIRYOUYOUTKTBINO2)
    public String getZtymuhaitouiryouyoutktbino2() {
        return ztymuhaitouiryouyoutktbino2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtymuhaitouiryouyoutktbino2(String pZtymuhaitouiryouyoutktbino2) {
        ztymuhaitouiryouyoutktbino2 = pZtymuhaitouiryouyoutktbino2;
    }

    private String ztymuhaitouiryouyouhtnpkkn2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMUHAITOUIRYOUYOUHTNPKKN2)
    public String getZtymuhaitouiryouyouhtnpkkn2() {
        return ztymuhaitouiryouyouhtnpkkn2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtymuhaitouiryouyouhtnpkkn2(String pZtymuhaitouiryouyouhtnpkkn2) {
        ztymuhaitouiryouyouhtnpkkn2 = pZtymuhaitouiryouyouhtnpkkn2;
    }

    private String ztysiteizukipwarimasihyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSITEIZUKIPWARIMASIHYOUJI)
    public String getZtysiteizukipwarimasihyouji() {
        return ztysiteizukipwarimasihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysiteizukipwarimasihyouji(String pZtysiteizukipwarimasihyouji) {
        ztysiteizukipwarimasihyouji = pZtysiteizukipwarimasihyouji;
    }

    private String ztypwarimasisiteim1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPWARIMASISITEIM1)
    public String getZtypwarimasisiteim1() {
        return ztypwarimasisiteim1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtypwarimasisiteim1(String pZtypwarimasisiteim1) {
        ztypwarimasisiteim1 = pZtypwarimasisiteim1;
    }

    private String ztypwarimasisiteim2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPWARIMASISITEIM2)
    public String getZtypwarimasisiteim2() {
        return ztypwarimasisiteim2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtypwarimasisiteim2(String pZtypwarimasisiteim2) {
        ztypwarimasisiteim2 = pZtypwarimasisiteim2;
    }

    private String ztysiteimsykykpbairitu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSITEIMSYKYKPBAIRITU)
    public String getZtysiteimsykykpbairitu() {
        return ztysiteimsykykpbairitu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysiteimsykykpbairitu(String pZtysiteimsykykpbairitu) {
        ztysiteimsykykpbairitu = pZtysiteimsykykpbairitu;
    }

    private String ztysaisyuusiteiym;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAISYUUSITEIYM)
    public String getZtysaisyuusiteiym() {
        return ztysaisyuusiteiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtysaisyuusiteiym(String pZtysaisyuusiteiym) {
        ztysaisyuusiteiym = pZtysaisyuusiteiym;
    }

    private String ztysykykkitmttvkeisanym;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYKYKKITMTTVKEISANYM)
    public String getZtysykykkitmttvkeisanym() {
        return ztysykykkitmttvkeisanym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtysykykkitmttvkeisanym(String pZtysykykkitmttvkeisanym) {
        ztysykykkitmttvkeisanym = pZtysykykkitmttvkeisanym;
    }

    private Long ztysykykkitmttsknnjynbkngk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYKYKKITMTTSKNNJYNBKNGK)
    public Long getZtysykykkitmttsknnjynbkngk() {
        return ztysykykkitmttsknnjynbkngk;
    }

    public void setZtysykykkitmttsknnjynbkngk(Long pZtysykykkitmttsknnjynbkngk) {
        ztysykykkitmttsknnjynbkngk = pZtysykykkitmttsknnjynbkngk;
    }

    private Long ztydftumitatekingaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDFTUMITATEKINGAKU)
    public Long getZtydftumitatekingaku() {
        return ztydftumitatekingaku;
    }

    public void setZtydftumitatekingaku(Long pZtydftumitatekingaku) {
        ztydftumitatekingaku = pZtydftumitatekingaku;
    }

    private Long ztydftumimasikin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDFTUMIMASIKIN)
    public Long getZtydftumimasikin() {
        return ztydftumimasikin;
    }

    public void setZtydftumimasikin(Long pZtydftumimasikin) {
        ztydftumimasikin = pZtydftumimasikin;
    }

    private Long ztyvbubundftenkankakaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYVBUBUNDFTENKANKAKAKU)
    public Long getZtyvbubundftenkankakaku() {
        return ztyvbubundftenkankakaku;
    }

    public void setZtyvbubundftenkankakaku(Long pZtyvbubundftenkankakaku) {
        ztyvbubundftenkankakaku = pZtyvbubundftenkankakaku;
    }

    private Long ztydpbubundftenkankakaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDPBUBUNDFTENKANKAKAKU)
    public Long getZtydpbubundftenkankakaku() {
        return ztydpbubundftenkankakaku;
    }

    public void setZtydpbubundftenkankakaku(Long pZtydpbubundftenkankakaku) {
        ztydpbubundftenkankakaku = pZtydpbubundftenkankakaku;
    }

    private Long ztydftmttkngkitjbrbbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDFTMTTKNGKITJBRBBN)
    public Long getZtydftmttkngkitjbrbbn() {
        return ztydftmttkngkitjbrbbn;
    }

    public void setZtydftmttkngkitjbrbbn(Long pZtydftmttkngkitjbrbbn) {
        ztydftmttkngkitjbrbbn = pZtydftmttkngkitjbrbbn;
    }

    private Long ztyhendous;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHENDOUS)
    public Long getZtyhendous() {
        return ztyhendous;
    }

    public void setZtyhendous(Long pZtyhendous) {
        ztyhendous = pZtyhendous;
    }

    private Long ztyhengakujigyounendomatucv;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHENGAKUJIGYOUNENDOMATUCV)
    public Long getZtyhengakujigyounendomatucv() {
        return ztyhengakujigyounendomatucv;
    }

    public void setZtyhengakujigyounendomatucv(Long pZtyhengakujigyounendomatucv) {
        ztyhengakujigyounendomatucv = pZtyhengakujigyounendomatucv;
    }

    private Long ztyitibuitijibarais;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYITIBUITIJIBARAIS)
    public Long getZtyitibuitijibarais() {
        return ztyitibuitijibarais;
    }

    public void setZtyitibuitijibarais(Long pZtyitibuitijibarais) {
        ztyitibuitijibarais = pZtyitibuitijibarais;
    }

    private Long ztyitibuitijibaraip;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYITIBUITIJIBARAIP)
    public Long getZtyitibuitijibaraip() {
        return ztyitibuitijibaraip;
    }

    public void setZtyitibuitijibaraip(Long pZtyitibuitijibaraip) {
        ztyitibuitijibaraip = pZtyitibuitijibaraip;
    }

    private Long ztyitibitjbrshrkngk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYITIBITJBRSHRKNGK)
    public Long getZtyitibitjbrshrkngk() {
        return ztyitibitjbrshrkngk;
    }

    public void setZtyitibitjbrshrkngk(Long pZtyitibitjbrshrkngk) {
        ztyitibitjbrshrkngk = pZtyitibitjbrshrkngk;
    }

    private Long ztygoukeicv;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEICV)
    public Long getZtygoukeicv() {
        return ztygoukeicv;
    }

    public void setZtygoukeicv(Long pZtygoukeicv) {
        ztygoukeicv = pZtygoukeicv;
    }

    private Long ztyminasicv;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMINASICV)
    public Long getZtyminasicv() {
        return ztyminasicv;
    }

    public void setZtyminasicv(Long pZtyminasicv) {
        ztyminasicv = pZtyminasicv;
    }

    private Long ztyloanfund;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYLOANFUND)
    public Long getZtyloanfund() {
        return ztyloanfund;
    }

    public void setZtyloanfund(Long pZtyloanfund) {
        ztyloanfund = pZtyloanfund;
    }

    private Long ztysaiteihosyougaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAITEIHOSYOUGAKU)
    public Long getZtysaiteihosyougaku() {
        return ztysaiteihosyougaku;
    }

    public void setZtysaiteihosyougaku(Long pZtysaiteihosyougaku) {
        ztysaiteihosyougaku = pZtysaiteihosyougaku;
    }

    private Long ztyhngksitihsyuyusykykp;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHNGKSITIHSYUYUSYKYKP)
    public Long getZtyhngksitihsyuyusykykp() {
        return ztyhngksitihsyuyusykykp;
    }

    public void setZtyhngksitihsyuyusykykp(Long pZtyhngksitihsyuyusykykp) {
        ztyhngksitihsyuyusykykp = pZtyhngksitihsyuyusykykp;
    }

    private Long ztyhijynbrivasbujsitihsyugk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHIJYNBRIVASBUJSITIHSYUGK)
    public Long getZtyhijynbrivasbujsitihsyugk() {
        return ztyhijynbrivasbujsitihsyugk;
    }

    public void setZtyhijynbrivasbujsitihsyugk(Long pZtyhijynbrivasbujsitihsyugk) {
        ztyhijynbrivasbujsitihsyugk = pZtyhijynbrivasbujsitihsyugk;
    }

    private Long ztyhijynbrivamnkjsitihsyugk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHIJYNBRIVAMNKJSITIHSYUGK)
    public Long getZtyhijynbrivamnkjsitihsyugk() {
        return ztyhijynbrivamnkjsitihsyugk;
    }

    public void setZtyhijynbrivamnkjsitihsyugk(Long pZtyhijynbrivamnkjsitihsyugk) {
        ztyhijynbrivamnkjsitihsyugk = pZtyhijynbrivamnkjsitihsyugk;
    }

    private String ztysiinkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSIINKBN)
    public String getZtysiinkbn() {
        return ztysiinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysiinkbn(String pZtysiinkbn) {
        ztysiinkbn = pZtysiinkbn;
    }

    private Long ztymudkaimasikihons;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMUDKAIMASIKIHONS)
    public Long getZtymudkaimasikihons() {
        return ztymudkaimasikihons;
    }

    public void setZtymudkaimasikihons(Long pZtymudkaimasikihons) {
        ztymudkaimasikihons = pZtymudkaimasikihons;
    }

    private String ztykaimasiymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAIMASIYMD)
    public String getZtykaimasiymd() {
        return ztykaimasiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtykaimasiymd(String pZtykaimasiymd) {
        ztykaimasiymd = pZtykaimasiymd;
    }

    private String ztykaimasikikan;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAIMASIKIKAN)
    public String getZtykaimasikikan() {
        return ztykaimasikikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykaimasikikan(String pZtykaimasikikan) {
        ztykaimasikikan = pZtykaimasikikan;
    }

    private Long ztyhikitugikaimasis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHIKITUGIKAIMASIS)
    public Long getZtyhikitugikaimasis() {
        return ztyhikitugikaimasis;
    }

    public void setZtyhikitugikaimasis(Long pZtyhikitugikaimasis) {
        ztyhikitugikaimasis = pZtyhikitugikaimasis;
    }

    private Long ztymudkaimasisiharaikingaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMUDKAIMASISIHARAIKINGAKU)
    public Long getZtymudkaimasisiharaikingaku() {
        return ztymudkaimasisiharaikingaku;
    }

    public void setZtymudkaimasisiharaikingaku(Long pZtymudkaimasisiharaikingaku) {
        ztymudkaimasisiharaikingaku = pZtymudkaimasisiharaikingaku;
    }

    private String ztyszoukouryokukaisiymdx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUKOURYOKUKAISIYMDX1)
    public String getZtyszoukouryokukaisiymdx1() {
        return ztyszoukouryokukaisiymdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyszoukouryokukaisiymdx1(String pZtyszoukouryokukaisiymdx1) {
        ztyszoukouryokukaisiymdx1 = pZtyszoukouryokukaisiymdx1;
    }

    private String ztyszouhokensyuruikigoux1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUHOKENSYURUIKIGOUX1)
    public String getZtyszouhokensyuruikigoux1() {
        return ztyszouhokensyuruikigoux1;
    }

    public void setZtyszouhokensyuruikigoux1(String pZtyszouhokensyuruikigoux1) {
        ztyszouhokensyuruikigoux1 = pZtyszouhokensyuruikigoux1;
    }

    private String ztyszoukigousedaikbnx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUKIGOUSEDAIKBNX1)
    public String getZtyszoukigousedaikbnx1() {
        return ztyszoukigousedaikbnx1;
    }

    public void setZtyszoukigousedaikbnx1(String pZtyszoukigousedaikbnx1) {
        ztyszoukigousedaikbnx1 = pZtyszoukigousedaikbnx1;
    }

    private String ztyszoukikanx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUKIKANX1)
    public String getZtyszoukikanx1() {
        return ztyszoukikanx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszoukikanx1(String pZtyszoukikanx1) {
        ztyszoukikanx1 = pZtyszoukikanx1;
    }

    private String ztyszouhihokensyaagex1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUHIHOKENSYAAGEX1)
    public String getZtyszouhihokensyaagex1() {
        return ztyszouhihokensyaagex1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszouhihokensyaagex1(String pZtyszouhihokensyaagex1) {
        ztyszouhihokensyaagex1 = pZtyszouhihokensyaagex1;
    }

    private String ztyszoudai2hihknsyaagex1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUDAI2HIHKNSYAAGEX1)
    public String getZtyszoudai2hihknsyaagex1() {
        return ztyszoudai2hihknsyaagex1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszoudai2hihknsyaagex1(String pZtyszoudai2hihknsyaagex1) {
        ztyszoudai2hihknsyaagex1 = pZtyszoudai2hihknsyaagex1;
    }

    private Long ztyzoukasx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZOUKASX1)
    public Long getZtyzoukasx1() {
        return ztyzoukasx1;
    }

    public void setZtyzoukasx1(Long pZtyzoukasx1) {
        ztyzoukasx1 = pZtyzoukasx1;
    }

    private Long ztyzennendozoukasx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZENNENDOZOUKASX1)
    public Long getZtyzennendozoukasx1() {
        return ztyzennendozoukasx1;
    }

    public void setZtyzennendozoukasx1(Long pZtyzennendozoukasx1) {
        ztyzennendozoukasx1 = pZtyzennendozoukasx1;
    }

    private Long ztyszousiharaikingakux1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUSIHARAIKINGAKUX1)
    public Long getZtyszousiharaikingakux1() {
        return ztyszousiharaikingakux1;
    }

    public void setZtyszousiharaikingakux1(Long pZtyszousiharaikingakux1) {
        ztyszousiharaikingakux1 = pZtyszousiharaikingakux1;
    }

    private String ztyszoukouryokukaisiymdx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUKOURYOKUKAISIYMDX2)
    public String getZtyszoukouryokukaisiymdx2() {
        return ztyszoukouryokukaisiymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyszoukouryokukaisiymdx2(String pZtyszoukouryokukaisiymdx2) {
        ztyszoukouryokukaisiymdx2 = pZtyszoukouryokukaisiymdx2;
    }

    private String ztyszouhokensyuruikigoux2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUHOKENSYURUIKIGOUX2)
    public String getZtyszouhokensyuruikigoux2() {
        return ztyszouhokensyuruikigoux2;
    }

    public void setZtyszouhokensyuruikigoux2(String pZtyszouhokensyuruikigoux2) {
        ztyszouhokensyuruikigoux2 = pZtyszouhokensyuruikigoux2;
    }

    private String ztyszoukigousedaikbnx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUKIGOUSEDAIKBNX2)
    public String getZtyszoukigousedaikbnx2() {
        return ztyszoukigousedaikbnx2;
    }

    public void setZtyszoukigousedaikbnx2(String pZtyszoukigousedaikbnx2) {
        ztyszoukigousedaikbnx2 = pZtyszoukigousedaikbnx2;
    }

    private String ztyszoukikanx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUKIKANX2)
    public String getZtyszoukikanx2() {
        return ztyszoukikanx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszoukikanx2(String pZtyszoukikanx2) {
        ztyszoukikanx2 = pZtyszoukikanx2;
    }

    private String ztyszouhihokensyaagex2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUHIHOKENSYAAGEX2)
    public String getZtyszouhihokensyaagex2() {
        return ztyszouhihokensyaagex2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszouhihokensyaagex2(String pZtyszouhihokensyaagex2) {
        ztyszouhihokensyaagex2 = pZtyszouhihokensyaagex2;
    }

    private String ztyszoudai2hihknsyaagex2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUDAI2HIHKNSYAAGEX2)
    public String getZtyszoudai2hihknsyaagex2() {
        return ztyszoudai2hihknsyaagex2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyszoudai2hihknsyaagex2(String pZtyszoudai2hihknsyaagex2) {
        ztyszoudai2hihknsyaagex2 = pZtyszoudai2hihknsyaagex2;
    }

    private Long ztyzoukasx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZOUKASX2)
    public Long getZtyzoukasx2() {
        return ztyzoukasx2;
    }

    public void setZtyzoukasx2(Long pZtyzoukasx2) {
        ztyzoukasx2 = pZtyzoukasx2;
    }

    private Long ztyzennendozoukasx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZENNENDOZOUKASX2)
    public Long getZtyzennendozoukasx2() {
        return ztyzennendozoukasx2;
    }

    public void setZtyzennendozoukasx2(Long pZtyzennendozoukasx2) {
        ztyzennendozoukasx2 = pZtyzennendozoukasx2;
    }

    private Long ztyszousiharaikingakux2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUSIHARAIKINGAKUX2)
    public Long getZtyszousiharaikingakux2() {
        return ztyszousiharaikingakux2;
    }

    public void setZtyszousiharaikingakux2(Long pZtyszousiharaikingakux2) {
        ztyszousiharaikingakux2 = pZtyszousiharaikingakux2;
    }

    private String ztysuuriyouyobin1x5;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN1X5)
    public String getZtysuuriyouyobin1x5() {
        return ztysuuriyouyobin1x5;
    }

    public void setZtysuuriyouyobin1x5(String pZtysuuriyouyobin1x5) {
        ztysuuriyouyobin1x5 = pZtysuuriyouyobin1x5;
    }

    private String ztysuuriyouyobin1x6;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN1X6)
    public String getZtysuuriyouyobin1x6() {
        return ztysuuriyouyobin1x6;
    }

    public void setZtysuuriyouyobin1x6(String pZtysuuriyouyobin1x6) {
        ztysuuriyouyobin1x6 = pZtysuuriyouyobin1x6;
    }

    private String ztyhrimngkizktkykpmenhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHRIMNGKIZKTKYKPMENHYJ)
    public String getZtyhrimngkizktkykpmenhyj() {
        return ztyhrimngkizktkykpmenhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhrimngkizktkykpmenhyj(String pZtyhrimngkizktkykpmenhyj) {
        ztyhrimngkizktkykpmenhyj = pZtyhrimngkizktkykpmenhyj;
    }

    private String ztymisyuustartym;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMISYUUSTARTYM)
    public String getZtymisyuustartym() {
        return ztymisyuustartym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtymisyuustartym(String pZtymisyuustartym) {
        ztymisyuustartym = pZtymisyuustartym;
    }

    private String ztymisyuukaisuu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMISYUUKAISUU)
    public String getZtymisyuukaisuu() {
        return ztymisyuukaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtymisyuukaisuu(String pZtymisyuukaisuu) {
        ztymisyuukaisuu = pZtymisyuukaisuu;
    }

    private String ztyitjbrtkykkousnuktkarhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYITJBRTKYKKOUSNUKTKARHYJ)
    public String getZtyitjbrtkykkousnuktkarhyj() {
        return ztyitjbrtkykkousnuktkarhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyitjbrtkykkousnuktkarhyj(String pZtyitjbrtkykkousnuktkarhyj) {
        ztyitjbrtkykkousnuktkarhyj = pZtyitjbrtkykkousnuktkarhyj;
    }

    private Long ztygyousekihyoujis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGYOUSEKIHYOUJIS)
    public Long getZtygyousekihyoujis() {
        return ztygyousekihyoujis;
    }

    public void setZtygyousekihyoujis(Long pZtygyousekihyoujis) {
        ztygyousekihyoujis = pZtygyousekihyoujis;
    }

    private Long ztysykykgyusekihyjs;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYKYKGYUSEKIHYJS)
    public Long getZtysykykgyusekihyjs() {
        return ztysykykgyusekihyjs;
    }

    public void setZtysykykgyusekihyjs(Long pZtysykykgyusekihyjs) {
        ztysykykgyusekihyjs = pZtysykykgyusekihyjs;
    }

    private Long ztytenkangyousekihyoujis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANGYOUSEKIHYOUJIS)
    public Long getZtytenkangyousekihyoujis() {
        return ztytenkangyousekihyoujis;
    }

    public void setZtytenkangyousekihyoujis(Long pZtytenkangyousekihyoujis) {
        ztytenkangyousekihyoujis = pZtytenkangyousekihyoujis;
    }

    private Long ztytnknteikigyousekihyjs;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNTEIKIGYOUSEKIHYJS)
    public Long getZtytnknteikigyousekihyjs() {
        return ztytnknteikigyousekihyjs;
    }

    public void setZtytnknteikigyousekihyjs(Long pZtytnknteikigyousekihyjs) {
        ztytnknteikigyousekihyjs = pZtytnknteikigyousekihyjs;
    }

    private Long ztytnkndpbbngyuskhyjs;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNDPBBNGYUSKHYJS)
    public Long getZtytnkndpbbngyuskhyjs() {
        return ztytnkndpbbngyuskhyjs;
    }

    public void setZtytnkndpbbngyuskhyjs(Long pZtytnkndpbbngyuskhyjs) {
        ztytnkndpbbngyuskhyjs = pZtytnkndpbbngyuskhyjs;
    }

    private String ztykykjyoutai;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKJYOUTAI)
    public String getZtykykjyoutai() {
        return ztykykjyoutai;
    }

    public void setZtykykjyoutai(String pZtykykjyoutai) {
        ztykykjyoutai = pZtykykjyoutai;
    }

    private String ztypmenhukakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPMENHUKAKBN)
    public String getZtypmenhukakbn() {
        return ztypmenhukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtypmenhukakbn(String pZtypmenhukakbn) {
        ztypmenhukakbn = pZtypmenhukakbn;
    }

    private String ztykousinkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKOUSINKBN)
    public String getZtykousinkbn() {
        return ztykousinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykousinkbn(String pZtykousinkbn) {
        ztykousinkbn = pZtykousinkbn;
    }

    private String ztymankiyoteikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMANKIYOTEIKBN)
    public String getZtymankiyoteikbn() {
        return ztymankiyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtymankiyoteikbn(String pZtymankiyoteikbn) {
        ztymankiyoteikbn = pZtymankiyoteikbn;
    }

    private String ztysykyktikmnkyoteikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYKYKTIKMNKYOTEIKBN)
    public String getZtysykyktikmnkyoteikbn() {
        return ztysykyktikmnkyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysykyktikmnkyoteikbn(String pZtysykyktikmnkyoteikbn) {
        ztysykyktikmnkyoteikbn = pZtysykyktikmnkyoteikbn;
    }

    private String ztytnknsykykkhnmnkytikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNSYKYKKHNMNKYTIKBN)
    public String getZtytnknsykykkhnmnkytikbn() {
        return ztytnknsykykkhnmnkytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytnknsykykkhnmnkytikbn(String pZtytnknsykykkhnmnkytikbn) {
        ztytnknsykykkhnmnkytikbn = pZtytnknsykykkhnmnkytikbn;
    }

    private String ztytnknsykyktikmnkytikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNSYKYKTIKMNKYTIKBN)
    public String getZtytnknsykyktikmnkytikbn() {
        return ztytnknsykyktikmnkytikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytnknsykyktikmnkytikbn(String pZtytnknsykyktikmnkytikbn) {
        ztytnknsykyktikmnkytikbn = pZtytnknsykyktikmnkytikbn;
    }

    private String ztytenkanteikimankiyoteikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANTEIKIMANKIYOTEIKBN)
    public String getZtytenkanteikimankiyoteikbn() {
        return ztytenkanteikimankiyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanteikimankiyoteikbn(String pZtytenkanteikimankiyoteikbn) {
        ztytenkanteikimankiyoteikbn = pZtytenkanteikimankiyoteikbn;
    }

    private String ztyszoumankiyoteikbnx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUMANKIYOTEIKBNX1)
    public String getZtyszoumankiyoteikbnx1() {
        return ztyszoumankiyoteikbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyszoumankiyoteikbnx1(String pZtyszoumankiyoteikbnx1) {
        ztyszoumankiyoteikbnx1 = pZtyszoumankiyoteikbnx1;
    }

    private String ztyszoumankiyoteikbnx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUMANKIYOTEIKBNX2)
    public String getZtyszoumankiyoteikbnx2() {
        return ztyszoumankiyoteikbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyszoumankiyoteikbnx2(String pZtyszoumankiyoteikbnx2) {
        ztyszoumankiyoteikbnx2 = pZtyszoumankiyoteikbnx2;
    }

    private String ztyvestingmankiyoteikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYVESTINGMANKIYOTEIKBN)
    public String getZtyvestingmankiyoteikbn() {
        return ztyvestingmankiyoteikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyvestingmankiyoteikbn(String pZtyvestingmankiyoteikbn) {
        ztyvestingmankiyoteikbn = pZtyvestingmankiyoteikbn;
    }

    private String ztyvkeisanhyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYVKEISANHYOUJI)
    public String getZtyvkeisanhyouji() {
        return ztyvkeisanhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyvkeisanhyouji(String pZtyvkeisanhyouji) {
        ztyvkeisanhyouji = pZtyvkeisanhyouji;
    }

    private String ztytoukisinkeiyakuhyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOUKISINKEIYAKUHYOUJI)
    public String getZtytoukisinkeiyakuhyouji() {
        return ztytoukisinkeiyakuhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytoukisinkeiyakuhyouji(String pZtytoukisinkeiyakuhyouji) {
        ztytoukisinkeiyakuhyouji = pZtytoukisinkeiyakuhyouji;
    }

    private String ztysykykhokenhoutekiyouhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYKYKHOKENHOUTEKIYOUHYJ)
    public String getZtysykykhokenhoutekiyouhyj() {
        return ztysykykhokenhoutekiyouhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysykykhokenhoutekiyouhyj(String pZtysykykhokenhoutekiyouhyj) {
        ztysykykhokenhoutekiyouhyj = pZtysykykhokenhoutekiyouhyj;
    }

    private String ztytokuteijyoutaihushrhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUTEIJYOUTAIHUSHRHYJ)
    public String getZtytokuteijyoutaihushrhyj() {
        return ztytokuteijyoutaihushrhyj;
    }

    public void setZtytokuteijyoutaihushrhyj(String pZtytokuteijyoutaihushrhyj) {
        ztytokuteijyoutaihushrhyj = pZtytokuteijyoutaihushrhyj;
    }

    private String ztyytirrthndsysnmnskaisuu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYTIRRTHNDSYSNMNSKAISUU)
    public String getZtyytirrthndsysnmnskaisuu() {
        return ztyytirrthndsysnmnskaisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyytirrthndsysnmnskaisuu(String pZtyytirrthndsysnmnskaisuu) {
        ztyytirrthndsysnmnskaisuu = pZtyytirrthndsysnmnskaisuu;
    }

    private String ztysuuriyouyobin3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN3)
    public String getZtysuuriyouyobin3() {
        return ztysuuriyouyobin3;
    }

    public void setZtysuuriyouyobin3(String pZtysuuriyouyobin3) {
        ztysuuriyouyobin3 = pZtysuuriyouyobin3;
    }

    private String ztysuuriyouyobin11;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN11)
    public String getZtysuuriyouyobin11() {
        return ztysuuriyouyobin11;
    }

    public void setZtysuuriyouyobin11(String pZtysuuriyouyobin11) {
        ztysuuriyouyobin11 = pZtysuuriyouyobin11;
    }

    private Long ztywnasigoukeitenkankakaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYWNASIGOUKEITENKANKAKAKU)
    public Long getZtywnasigoukeitenkankakaku() {
        return ztywnasigoukeitenkankakaku;
    }

    public void setZtywnasigoukeitenkankakaku(Long pZtywnasigoukeitenkankakaku) {
        ztywnasigoukeitenkankakaku = pZtywnasigoukeitenkankakaku;
    }

    private Long ztyyobin11;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11)
    public Long getZtyyobin11() {
        return ztyyobin11;
    }

    public void setZtyyobin11(Long pZtyyobin11) {
        ztyyobin11 = pZtyyobin11;
    }

    private Long ztyyobin11x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X2)
    public Long getZtyyobin11x2() {
        return ztyyobin11x2;
    }

    public void setZtyyobin11x2(Long pZtyyobin11x2) {
        ztyyobin11x2 = pZtyyobin11x2;
    }

    private Long ztyyobin11x3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X3)
    public Long getZtyyobin11x3() {
        return ztyyobin11x3;
    }

    public void setZtyyobin11x3(Long pZtyyobin11x3) {
        ztyyobin11x3 = pZtyyobin11x3;
    }

    private Long ztytukibaraikansantokujyoup;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTUKIBARAIKANSANTOKUJYOUP)
    public Long getZtytukibaraikansantokujyoup() {
        return ztytukibaraikansantokujyoup;
    }

    public void setZtytukibaraikansantokujyoup(Long pZtytukibaraikansantokujyoup) {
        ztytukibaraikansantokujyoup = pZtytukibaraikansantokujyoup;
    }

    private String ztytnkngkykkssnkijyuym;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNGKYKKSSNKIJYUYM)
    public String getZtytnkngkykkssnkijyuym() {
        return ztytnkngkykkssnkijyuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtytnkngkykkssnkijyuym(String pZtytnkngkykkssnkijyuym) {
        ztytnkngkykkssnkijyuym = pZtytnkngkykkssnkijyuym;
    }

    private String ztysaiteihosyouhyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAITEIHOSYOUHYOUJI)
    public String getZtysaiteihosyouhyouji() {
        return ztysaiteihosyouhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysaiteihosyouhyouji(String pZtysaiteihosyouhyouji) {
        ztysaiteihosyouhyouji = pZtysaiteihosyouhyouji;
    }

    private String ztysuuriyouyobin8x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN8X2)
    public String getZtysuuriyouyobin8x2() {
        return ztysuuriyouyobin8x2;
    }

    public void setZtysuuriyouyobin8x2(String pZtysuuriyouyobin8x2) {
        ztysuuriyouyobin8x2 = pZtysuuriyouyobin8x2;
    }

    private String ztysuuriyouyobin14;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN14)
    public String getZtysuuriyouyobin14() {
        return ztysuuriyouyobin14;
    }

    public void setZtysuuriyouyobin14(String pZtysuuriyouyobin14) {
        ztysuuriyouyobin14 = pZtysuuriyouyobin14;
    }

    private String ztyhrimngtkykphrkkaisuukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHRIMNGTKYKPHRKKAISUUKBN)
    public String getZtyhrimngtkykphrkkaisuukbn() {
        return ztyhrimngtkykphrkkaisuukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhrimngtkykphrkkaisuukbn(String pZtyhrimngtkykphrkkaisuukbn) {
        ztyhrimngtkykphrkkaisuukbn = pZtyhrimngtkykphrkkaisuukbn;
    }

    private String ztyhrimngtkykphrkkirkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHRIMNGTKYKPHRKKIRKBN)
    public String getZtyhrimngtkykphrkkirkbn() {
        return ztyhrimngtkykphrkkirkbn;
    }

    public void setZtyhrimngtkykphrkkirkbn(String pZtyhrimngtkykphrkkirkbn) {
        ztyhrimngtkykphrkkirkbn = pZtyhrimngtkykphrkkirkbn;
    }

    private String ztyhrimngtkykpryurtkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHRIMNGTKYKPRYURTKBN)
    public String getZtyhrimngtkykpryurtkbn() {
        return ztyhrimngtkykpryurtkbn;
    }

    public void setZtyhrimngtkykpryurtkbn(String pZtyhrimngtkykpryurtkbn) {
        ztyhrimngtkykpryurtkbn = pZtyhrimngtkykpryurtkbn;
    }

    private String ztyyobiv13;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV13)
    public String getZtyyobiv13() {
        return ztyyobiv13;
    }

    public void setZtyyobiv13(String pZtyyobiv13) {
        ztyyobiv13 = pZtyyobiv13;
    }

    private Long ztyidoujisaiteihosyoukngk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYIDOUJISAITEIHOSYOUKNGK)
    public Long getZtyidoujisaiteihosyoukngk() {
        return ztyidoujisaiteihosyoukngk;
    }

    public void setZtyidoujisaiteihosyoukngk(Long pZtyidoujisaiteihosyoukngk) {
        ztyidoujisaiteihosyoukngk = pZtyidoujisaiteihosyoukngk;
    }

    private Long ztyidoujisaiteihosyoucost;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYIDOUJISAITEIHOSYOUCOST)
    public Long getZtyidoujisaiteihosyoucost() {
        return ztyidoujisaiteihosyoucost;
    }

    public void setZtyidoujisaiteihosyoucost(Long pZtyidoujisaiteihosyoucost) {
        ztyidoujisaiteihosyoucost = pZtyidoujisaiteihosyoucost;
    }

    private Long ztysinhokenfundtumitatekin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSINHOKENFUNDTUMITATEKIN)
    public Long getZtysinhokenfundtumitatekin() {
        return ztysinhokenfundtumitatekin;
    }

    public void setZtysinhokenfundtumitatekin(Long pZtysinhokenfundtumitatekin) {
        ztysinhokenfundtumitatekin = pZtysinhokenfundtumitatekin;
    }

    private Long ztymsyuptusshkgkaiykhnrikn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMSYUPTUSSHKGKAIYKHNRIKN)
    public Long getZtymsyuptusshkgkaiykhnrikn() {
        return ztymsyuptusshkgkaiykhnrikn;
    }

    public void setZtymsyuptusshkgkaiykhnrikn(Long pZtymsyuptusshkgkaiykhnrikn) {
        ztymsyuptusshkgkaiykhnrikn = pZtymsyuptusshkgkaiykhnrikn;
    }

    private Long ztyrrthndugtnkgetumatuv;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRRTHNDUGTNKGETUMATUV)
    public Long getZtyrrthndugtnkgetumatuv() {
        return ztyrrthndugtnkgetumatuv;
    }

    public void setZtyrrthndugtnkgetumatuv(Long pZtyrrthndugtnkgetumatuv) {
        ztyrrthndugtnkgetumatuv = pZtyrrthndugtnkgetumatuv;
    }

    private Long ztyrrthndnksaiteihosyonkgns;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRRTHNDNKSAITEIHOSYONKGNS)
    public Long getZtyrrthndnksaiteihosyonkgns() {
        return ztyrrthndnksaiteihosyonkgns;
    }

    public void setZtyrrthndnksaiteihosyonkgns(Long pZtyrrthndnksaiteihosyonkgns) {
        ztyrrthndnksaiteihosyonkgns = pZtyrrthndnksaiteihosyonkgns;
    }

    private Long ztyrrthendougatanksibous;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRRTHENDOUGATANKSIBOUS)
    public Long getZtyrrthendougatanksibous() {
        return ztyrrthendougatanksibous;
    }

    public void setZtyrrthendougatanksibous(Long pZtyrrthendougatanksibous) {
        ztyrrthendougatanksibous = pZtyrrthendougatanksibous;
    }

    private String ztyalmyousohutomeisyoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYALMYOUSOHUTOMEISYOUKBN)
    public String getZtyalmyousohutomeisyoukbn() {
        return ztyalmyousohutomeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyalmyousohutomeisyoukbn(String pZtyalmyousohutomeisyoukbn) {
        ztyalmyousohutomeisyoukbn = pZtyalmyousohutomeisyoukbn;
    }

    private String ztysnkyksoftmeisyoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSNKYKSOFTMEISYOUKBN)
    public String getZtysnkyksoftmeisyoukbn() {
        return ztysnkyksoftmeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysnkyksoftmeisyoukbn(String pZtysnkyksoftmeisyoukbn) {
        ztysnkyksoftmeisyoukbn = pZtysnkyksoftmeisyoukbn;
    }

    private String ztysoftmeisyoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSOFTMEISYOUKBN)
    public String getZtysoftmeisyoukbn() {
        return ztysoftmeisyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysoftmeisyoukbn(String pZtysoftmeisyoukbn) {
        ztysoftmeisyoukbn = pZtysoftmeisyoukbn;
    }

    private String ztykykjitokujyouarihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKJITOKUJYOUARIHYJ)
    public String getZtykykjitokujyouarihyj() {
        return ztykykjitokujyouarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykykjitokujyouarihyj(String pZtykykjitokujyouarihyj) {
        ztykykjitokujyouarihyj = pZtykykjitokujyouarihyj;
    }

    private String ztybnkttnknkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYBNKTTNKNKBN)
    public String getZtybnkttnknkbn() {
        return ztybnkttnknkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtybnkttnknkbn(String pZtybnkttnknkbn) {
        ztybnkttnknkbn = pZtybnkttnknkbn;
    }

    private String ztytenkanminaosikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANMINAOSIKBN)
    public String getZtytenkanminaosikbn() {
        return ztytenkanminaosikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanminaosikbn(String pZtytenkanminaosikbn) {
        ztytenkanminaosikbn = pZtytenkanminaosikbn;
    }

    private String ztysoujikeitenkankbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSOUJIKEITENKANKBN)
    public String getZtysoujikeitenkankbn() {
        return ztysoujikeitenkankbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysoujikeitenkankbn(String pZtysoujikeitenkankbn) {
        ztysoujikeitenkankbn = pZtysoujikeitenkankbn;
    }

    private String ztynenkinkaisinendo;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYNENKINKAISINENDO)
    public String getZtynenkinkaisinendo() {
        return ztynenkinkaisinendo;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtynenkinkaisinendo(String pZtynenkinkaisinendo) {
        ztynenkinkaisinendo = pZtynenkinkaisinendo;
    }

    private String ztynenkingatakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYNENKINGATAKBN)
    public String getZtynenkingatakbn() {
        return ztynenkingatakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtynenkingatakbn(String pZtynenkingatakbn) {
        ztynenkingatakbn = pZtynenkingatakbn;
    }

    private String ztynknshry;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYNKNSHRY)
    public String getZtynknshry() {
        return ztynknshry;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtynknshry(String pZtynknshry) {
        ztynknshry = pZtynknshry;
    }

    private String ztyheiyoubaraikeiyakukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHEIYOUBARAIKEIYAKUKBN)
    public String getZtyheiyoubaraikeiyakukbn() {
        return ztyheiyoubaraikeiyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyheiyoubaraikeiyakukbn(String pZtyheiyoubaraikeiyakukbn) {
        ztyheiyoubaraikeiyakukbn = pZtyheiyoubaraikeiyakukbn;
    }

    private String ztynenkinmaruteihukakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYNENKINMARUTEIHUKAKBN)
    public String getZtynenkinmaruteihukakbn() {
        return ztynenkinmaruteihukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtynenkinmaruteihukakbn(String pZtynenkinmaruteihukakbn) {
        ztynenkinmaruteihukakbn = pZtynenkinmaruteihukakbn;
    }

    private String ztysinseizonmrtiarihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSINSEIZONMRTIARIHYJ)
    public String getZtysinseizonmrtiarihyj() {
        return ztysinseizonmrtiarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysinseizonmrtiarihyj(String pZtysinseizonmrtiarihyj) {
        ztysinseizonmrtiarihyj = pZtysinseizonmrtiarihyj;
    }

    private String ztysnkykyouibokijyukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSNKYKYOUIBOKIJYUKBN)
    public String getZtysnkykyouibokijyukbn() {
        return ztysnkykyouibokijyukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysnkykyouibokijyukbn(String pZtysnkykyouibokijyukbn) {
        ztysnkykyouibokijyukbn = pZtysnkykyouibokijyukbn;
    }

    private String ztytokusitujyuusitusetkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUSITUJYUUSITUSETKBN)
    public String getZtytokusitujyuusitusetkbn() {
        return ztytokusitujyuusitusetkbn;
    }

    public void setZtytokusitujyuusitusetkbn(String pZtytokusitujyuusitusetkbn) {
        ztytokusitujyuusitusetkbn = pZtytokusitujyuusitusetkbn;
    }

    private String ztysiktsyuknbyugnhsyunshyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSIKTSYUKNBYUGNHSYUNSHYJ)
    public String getZtysiktsyuknbyugnhsyunshyj() {
        return ztysiktsyuknbyugnhsyunshyj;
    }

    public void setZtysiktsyuknbyugnhsyunshyj(String pZtysiktsyuknbyugnhsyunshyj) {
        ztysiktsyuknbyugnhsyunshyj = pZtysiktsyuknbyugnhsyunshyj;
    }

    private String ztypmensugugtganhsyunshyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPMENSUGUGTGANHSYUNSHYJ)
    public String getZtypmensugugtganhsyunshyj() {
        return ztypmensugugtganhsyunshyj;
    }

    public void setZtypmensugugtganhsyunshyj(String pZtypmensugugtganhsyunshyj) {
        ztypmensugugtganhsyunshyj = pZtypmensugugtganhsyunshyj;
    }

    private String ztytkykgyousekihyjszerohyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTKYKGYOUSEKIHYJSZEROHYJ)
    public String getZtytkykgyousekihyjszerohyj() {
        return ztytkykgyousekihyjszerohyj;
    }

    public void setZtytkykgyousekihyjszerohyj(String pZtytkykgyousekihyjszerohyj) {
        ztytkykgyousekihyjszerohyj = pZtytkykgyousekihyjszerohyj;
    }

    private String ztysuuriyouyobin7;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN7)
    public String getZtysuuriyouyobin7() {
        return ztysuuriyouyobin7;
    }

    public void setZtysuuriyouyobin7(String pZtysuuriyouyobin7) {
        ztysuuriyouyobin7 = pZtysuuriyouyobin7;
    }

    private String ztysyussaikeitaikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYUSSAIKEITAIKBN)
    public String getZtysyussaikeitaikbn() {
        return ztysyussaikeitaikbn;
    }

    public void setZtysyussaikeitaikbn(String pZtysyussaikeitaikbn) {
        ztysyussaikeitaikbn = pZtysyussaikeitaikbn;
    }

    private String ztyyobiv6;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }

    private String ztybosyuukeitaikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYBOSYUUKEITAIKBN)
    public String getZtybosyuukeitaikbn() {
        return ztybosyuukeitaikbn;
    }

    public void setZtybosyuukeitaikbn(String pZtybosyuukeitaikbn) {
        ztybosyuukeitaikbn = pZtybosyuukeitaikbn;
    }

    private String ztyaatukaisosikicd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAATUKAISOSIKICD)
    public String getZtyaatukaisosikicd() {
        return ztyaatukaisosikicd;
    }

    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        ztyaatukaisosikicd = pZtyaatukaisosikicd;
    }

    private String ztyaatukaikojincd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAATUKAIKOJINCD)
    public String getZtyaatukaikojincd() {
        return ztyaatukaikojincd;
    }

    public void setZtyaatukaikojincd(String pZtyaatukaikojincd) {
        ztyaatukaikojincd = pZtyaatukaikojincd;
    }

    private String ztybsydrtencd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYBSYDRTENCD)
    public String getZtybsydrtencd() {
        return ztybsydrtencd;
    }

    public void setZtybsydrtencd(String pZtybsydrtencd) {
        ztybsydrtencd = pZtybsydrtencd;
    }

    private String ztycifcd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYCIFCD)
    public String getZtycifcd() {
        return ztycifcd;
    }

    public void setZtycifcd(String pZtycifcd) {
        ztycifcd = pZtycifcd;
    }

    private String ztysuuriyouyobiv8;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIV8)
    public String getZtysuuriyouyobiv8() {
        return ztysuuriyouyobiv8;
    }

    public void setZtysuuriyouyobiv8(String pZtysuuriyouyobiv8) {
        ztysuuriyouyobiv8 = pZtysuuriyouyobiv8;
    }

    private String ztysinsakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSINSAKBN)
    public String getZtysinsakbn() {
        return ztysinsakbn;
    }

    public void setZtysinsakbn(String pZtysinsakbn) {
        ztysinsakbn = pZtysinsakbn;
    }

    private String ztydai2hihokensyasinsakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAI2HIHOKENSYASINSAKBN)
    public String getZtydai2hihokensyasinsakbn() {
        return ztydai2hihokensyasinsakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2hihokensyasinsakbn(String pZtydai2hihokensyasinsakbn) {
        ztydai2hihokensyasinsakbn = pZtydai2hihokensyasinsakbn;
    }

    private String ztytoukeiyousinsakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOUKEIYOUSINSAKBN)
    public String getZtytoukeiyousinsakbn() {
        return ztytoukeiyousinsakbn;
    }

    public void setZtytoukeiyousinsakbn(String pZtytoukeiyousinsakbn) {
        ztytoukeiyousinsakbn = pZtytoukeiyousinsakbn;
    }

    private String ztydai2toukeiyousinsakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAI2TOUKEIYOUSINSAKBN)
    public String getZtydai2toukeiyousinsakbn() {
        return ztydai2toukeiyousinsakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2toukeiyousinsakbn(String pZtydai2toukeiyousinsakbn) {
        ztydai2toukeiyousinsakbn = pZtydai2toukeiyousinsakbn;
    }

    private String ztyketteikijyunkanwakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKETTEIKIJYUNKANWAKBN)
    public String getZtyketteikijyunkanwakbn() {
        return ztyketteikijyunkanwakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyketteikijyunkanwakbn(String pZtyketteikijyunkanwakbn) {
        ztyketteikijyunkanwakbn = pZtyketteikijyunkanwakbn;
    }

    private String ztykihonsibouhyoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKIHONSIBOUHYOUKBN)
    public String getZtykihonsibouhyoukbn() {
        return ztykihonsibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykihonsibouhyoukbn(String pZtykihonsibouhyoukbn) {
        ztykihonsibouhyoukbn = pZtykihonsibouhyoukbn;
    }

    private String ztyteikisibouhyoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTEIKISIBOUHYOUKBN)
    public String getZtyteikisibouhyoukbn() {
        return ztyteikisibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyteikisibouhyoukbn(String pZtyteikisibouhyoukbn) {
        ztyteikisibouhyoukbn = pZtyteikisibouhyoukbn;
    }

    private String ztysonotasibouhyoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSONOTASIBOUHYOUKBN)
    public String getZtysonotasibouhyoukbn() {
        return ztysonotasibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysonotasibouhyoukbn(String pZtysonotasibouhyoukbn) {
        ztysonotasibouhyoukbn = pZtysonotasibouhyoukbn;
    }

    private String ztymrarihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMRARIHYJ)
    public String getZtymrarihyj() {
        return ztymrarihyj;
    }

    public void setZtymrarihyj(String pZtymrarihyj) {
        ztymrarihyj = pZtymrarihyj;
    }

    private String ztysentakujyouhouarihyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSENTAKUJYOUHOUARIHYOUJI)
    public String getZtysentakujyouhouarihyouji() {
        return ztysentakujyouhouarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysentakujyouhouarihyouji(String pZtysentakujyouhouarihyouji) {
        ztysentakujyouhouarihyouji = pZtysentakujyouhouarihyouji;
    }

    private String ztydugktnknsntkhuhukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDUGKTNKNSNTKHUHUKBN)
    public String getZtydugktnknsntkhuhukbn() {
        return ztydugktnknsntkhuhukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydugktnknsntkhuhukbn(String pZtydugktnknsntkhuhukbn) {
        ztydugktnknsntkhuhukbn = pZtydugktnknsntkhuhukbn;
    }

    private String ztygengakutenkankykhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGENGAKUTENKANKYKHYJ)
    public String getZtygengakutenkankykhyj() {
        return ztygengakutenkankykhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygengakutenkankykhyj(String pZtygengakutenkankykhyj) {
        ztygengakutenkankykhyj = pZtygengakutenkankykhyj;
    }

    private String ztysykgycd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private String ztyjidoukousinkykkanyuuymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYJIDOUKOUSINKYKKANYUUYMD)
    public String getZtyjidoukousinkykkanyuuymd() {
        return ztyjidoukousinkykkanyuuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyjidoukousinkykkanyuuymd(String pZtyjidoukousinkykkanyuuymd) {
        ztyjidoukousinkykkanyuuymd = pZtyjidoukousinkykkanyuuymd;
    }

    private String ztysaikohtnknkykkykymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAIKOHTNKNKYKKYKYMD)
    public String getZtysaikohtnknkykkykymd() {
        return ztysaikohtnknkykkykymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysaikohtnknkykkykymd(String pZtysaikohtnknkykkykymd) {
        ztysaikohtnknkykkykymd = pZtysaikohtnknkykkykymd;
    }

    private String ztykousinmaesykyksburtkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKOUSINMAESYKYKSBURTKBN)
    public String getZtykousinmaesykyksburtkbn() {
        return ztykousinmaesykyksburtkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykousinmaesykyksburtkbn(String pZtykousinmaesykyksburtkbn) {
        ztykousinmaesykyksburtkbn = pZtykousinmaesykyksburtkbn;
    }

    private String ztyhjnkykhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHJNKYKHYJ)
    public String getZtyhjnkykhyj() {
        return ztyhjnkykhyj;
    }

    public void setZtyhjnkykhyj(String pZtyhjnkykhyj) {
        ztyhjnkykhyj = pZtyhjnkykhyj;
    }

    private String ztyanniskcd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYANNISKCD)
    public String getZtyanniskcd() {
        return ztyanniskcd;
    }

    public void setZtyanniskcd(String pZtyanniskcd) {
        ztyanniskcd = pZtyanniskcd;
    }

    private String ztyhjncd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHJNCD)
    public String getZtyhjncd() {
        return ztyhjncd;
    }

    public void setZtyhjncd(String pZtyhjncd) {
        ztyhjncd = pZtyhjncd;
    }

    private String ztyhjnjigyosyocd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHJNJIGYOSYOCD)
    public String getZtyhjnjigyosyocd() {
        return ztyhjnjigyosyocd;
    }

    public void setZtyhjnjigyosyocd(String pZtyhjnjigyosyocd) {
        ztyhjnjigyosyocd = pZtyhjnjigyosyocd;
    }

    private String ztysaihokenno;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAIHOKENNO)
    public String getZtysaihokenno() {
        return ztysaihokenno;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZtysaihokenno(String pZtysaihokenno) {
        ztysaihokenno = pZtysaihokenno;
    }

    private String ztydakuhikettikekkacd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAKUHIKETTIKEKKACD)
    public String getZtydakuhikettikekkacd() {
        return ztydakuhikettikekkacd;
    }

    public void setZtydakuhikettikekkacd(String pZtydakuhikettikekkacd) {
        ztydakuhikettikekkacd = pZtydakuhikettikekkacd;
    }

    private String ztydai2dakuhiketteikekkacd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAI2DAKUHIKETTEIKEKKACD)
    public String getZtydai2dakuhiketteikekkacd() {
        return ztydai2dakuhiketteikekkacd;
    }

    public void setZtydai2dakuhiketteikekkacd(String pZtydai2dakuhiketteikekkacd) {
        ztydai2dakuhiketteikekkacd = pZtydai2dakuhiketteikekkacd;
    }

    private String ztypmenkbnv2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPMENKBNV2)
    public String getZtypmenkbnv2() {
        return ztypmenkbnv2;
    }

    public void setZtypmenkbnv2(String pZtypmenkbnv2) {
        ztypmenkbnv2 = pZtypmenkbnv2;
    }

    private Long ztysiboukyuuhukin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSIBOUKYUUHUKIN)
    public Long getZtysiboukyuuhukin() {
        return ztysiboukyuuhukin;
    }

    public void setZtysiboukyuuhukin(Long pZtysiboukyuuhukin) {
        ztysiboukyuuhukin = pZtysiboukyuuhukin;
    }

    private String ztyjyudthumeharaitkykhkhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYJYUDTHUMEHARAITKYKHKHYJ)
    public String getZtyjyudthumeharaitkykhkhyj() {
        return ztyjyudthumeharaitkykhkhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyjyudthumeharaitkykhkhyj(String pZtyjyudthumeharaitkykhkhyj) {
        ztyjyudthumeharaitkykhkhyj = pZtyjyudthumeharaitkykhkhyj;
    }

    private String ztyhaitoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHAITOUKBN)
    public String getZtyhaitoukbn() {
        return ztyhaitoukbn;
    }

    public void setZtyhaitoukbn(String pZtyhaitoukbn) {
        ztyhaitoukbn = pZtyhaitoukbn;
    }

    private String ztyhhknnentysihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHHKNNENTYSIHYJ)
    public String getZtyhhknnentysihyj() {
        return ztyhhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyhhknnentysihyj(String pZtyhhknnentysihyj) {
        ztyhhknnentysihyj = pZtyhhknnentysihyj;
    }

    private String ztydai2hhknnentysihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAI2HHKNNENTYSIHYJ)
    public String getZtydai2hhknnentysihyj() {
        return ztydai2hhknnentysihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtydai2hhknnentysihyj(String pZtydai2hhknnentysihyj) {
        ztydai2hhknnentysihyj = pZtydai2hhknnentysihyj;
    }

    private String ztykyksyaagetyouseihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKSYAAGETYOUSEIHYJ)
    public String getZtykyksyaagetyouseihyj() {
        return ztykyksyaagetyouseihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykyksyaagetyouseihyj(String pZtykyksyaagetyouseihyj) {
        ztykyksyaagetyouseihyj = pZtykyksyaagetyouseihyj;
    }

    private String ztykituenkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKITUENKBN)
    public String getZtykituenkbn() {
        return ztykituenkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykituenkbn(String pZtykituenkbn) {
        ztykituenkbn = pZtykituenkbn;
    }

    private String ztykituenhonsuu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKITUENHONSUU)
    public String getZtykituenhonsuu() {
        return ztykituenhonsuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykituenhonsuu(String pZtykituenhonsuu) {
        ztykituenhonsuu = pZtykituenhonsuu;
    }

    private String ztymusentakukeiyakukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMUSENTAKUKEIYAKUKBN)
    public String getZtymusentakukeiyakukbn() {
        return ztymusentakukeiyakukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtymusentakukeiyakukbn(String pZtymusentakukeiyakukbn) {
        ztymusentakukeiyakukbn = pZtymusentakukeiyakukbn;
    }

    private String ztyyobiv6x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV6X2)
    public String getZtyyobiv6x2() {
        return ztyyobiv6x2;
    }

    public void setZtyyobiv6x2(String pZtyyobiv6x2) {
        ztyyobiv6x2 = pZtyyobiv6x2;
    }

    private String ztylivingneedstkykarihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYLIVINGNEEDSTKYKARIHYJ)
    public String getZtylivingneedstkykarihyj() {
        return ztylivingneedstkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtylivingneedstkykarihyj(String pZtylivingneedstkykarihyj) {
        ztylivingneedstkykarihyj = pZtylivingneedstkykarihyj;
    }

    private String ztylivingneedssiharaihyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYLIVINGNEEDSSIHARAIHYOUJI)
    public String getZtylivingneedssiharaihyouji() {
        return ztylivingneedssiharaihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtylivingneedssiharaihyouji(String pZtylivingneedssiharaihyouji) {
        ztylivingneedssiharaihyouji = pZtylivingneedssiharaihyouji;
    }

    private String ztylnseikyuuymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYLNSEIKYUUYMD)
    public String getZtylnseikyuuymd() {
        return ztylnseikyuuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtylnseikyuuymd(String pZtylnseikyuuymd) {
        ztylnseikyuuymd = pZtylnseikyuuymd;
    }

    private String ztylnshrgenincd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYLNSHRGENINCD)
    public String getZtylnshrgenincd() {
        return ztylnshrgenincd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtylnshrgenincd(String pZtylnshrgenincd) {
        ztylnshrgenincd = pZtylnshrgenincd;
    }

    private String ztydakuhikettisyacd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAKUHIKETTISYACD)
    public String getZtydakuhikettisyacd() {
        return ztydakuhikettisyacd;
    }

    public void setZtydakuhikettisyacd(String pZtydakuhikettisyacd) {
        ztydakuhikettisyacd = pZtydakuhikettisyacd;
    }

    private String ztydai2dakuhiketteisyacd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDAI2DAKUHIKETTEISYACD)
    public String getZtydai2dakuhiketteisyacd() {
        return ztydai2dakuhiketteisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtydai2dakuhiketteisyacd(String pZtydai2dakuhiketteisyacd) {
        ztydai2dakuhiketteisyacd = pZtydai2dakuhiketteisyacd;
    }

    private String ztygansapotokuyakuarihyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGANSAPOTOKUYAKUARIHYOUJI)
    public String getZtygansapotokuyakuarihyouji() {
        return ztygansapotokuyakuarihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygansapotokuyakuarihyouji(String pZtygansapotokuyakuarihyouji) {
        ztygansapotokuyakuarihyouji = pZtygansapotokuyakuarihyouji;
    }

    private String ztygnspshrhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGNSPSHRHYJ)
    public String getZtygnspshrhyj() {
        return ztygnspshrhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtygnspshrhyj(String pZtygnspshrhyj) {
        ztygnspshrhyj = pZtygnspshrhyj;
    }

    private String ztygansaposeikyuuymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGANSAPOSEIKYUUYMD)
    public String getZtygansaposeikyuuymd() {
        return ztygansaposeikyuuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtygansaposeikyuuymd(String pZtygansaposeikyuuymd) {
        ztygansaposeikyuuymd = pZtygansaposeikyuuymd;
    }

    private String ztygnspshrgenincd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGNSPSHRGENINCD)
    public String getZtygnspshrgenincd() {
        return ztygnspshrgenincd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtygnspshrgenincd(String pZtygnspshrgenincd) {
        ztygnspshrgenincd = pZtygnspshrgenincd;
    }

    private String ztyyobiv3x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV3X2)
    public String getZtyyobiv3x2() {
        return ztyyobiv3x2;
    }

    public void setZtyyobiv3x2(String pZtyyobiv3x2) {
        ztyyobiv3x2 = pZtyyobiv3x2;
    }

    private String ztytargetmokuhyouritu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTARGETMOKUHYOURITU)
    public String getZtytargetmokuhyouritu() {
        return ztytargetmokuhyouritu;
    }

    public void setZtytargetmokuhyouritu(String pZtytargetmokuhyouritu) {
        ztytargetmokuhyouritu = pZtytargetmokuhyouritu;
    }

    private String ztyautoswitchmokuhyouritu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAUTOSWITCHMOKUHYOURITU)
    public String getZtyautoswitchmokuhyouritu() {
        return ztyautoswitchmokuhyouritu;
    }

    public void setZtyautoswitchmokuhyouritu(String pZtyautoswitchmokuhyouritu) {
        ztyautoswitchmokuhyouritu = pZtyautoswitchmokuhyouritu;
    }

    private String ztytumitatekinitenarihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTUMITATEKINITENARIHYJ)
    public String getZtytumitatekinitenarihyj() {
        return ztytumitatekinitenarihyj;
    }

    public void setZtytumitatekinitenarihyj(String pZtytumitatekinitenarihyj) {
        ztytumitatekinitenarihyj = pZtytumitatekinitenarihyj;
    }

    private String ztytumitatekinitenkaisuu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTUMITATEKINITENKAISUU)
    public String getZtytumitatekinitenkaisuu() {
        return ztytumitatekinitenkaisuu;
    }

    public void setZtytumitatekinitenkaisuu(String pZtytumitatekinitenkaisuu) {
        ztytumitatekinitenkaisuu = pZtytumitatekinitenkaisuu;
    }

    private String ztydatakanrino2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDATAKANRINO2)
    public String getZtydatakanrino2() {
        return ztydatakanrino2;
    }

    public void setZtydatakanrino2(String pZtydatakanrino2) {
        ztydatakanrino2 = pZtydatakanrino2;
    }

    private String ztydatakanrino3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDATAKANRINO3)
    public String getZtydatakanrino3() {
        return ztydatakanrino3;
    }

    public void setZtydatakanrino3(String pZtydatakanrino3) {
        ztydatakanrino3 = pZtydatakanrino3;
    }

    private String ztyknkuzusnzyrttekinendo;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKNKUZUSNZYRTTEKINENDO)
    public String getZtyknkuzusnzyrttekinendo() {
        return ztyknkuzusnzyrttekinendo;
    }

    public void setZtyknkuzusnzyrttekinendo(String pZtyknkuzusnzyrttekinendo) {
        ztyknkuzusnzyrttekinendo = pZtyknkuzusnzyrttekinendo;
    }

    private String ztyknkuzusnzyrt;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKNKUZUSNZYRT)
    public String getZtyknkuzusnzyrt() {
        return ztyknkuzusnzyrt;
    }

    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        ztyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }

    private String ztyknkuzusnzyrtx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKNKUZUSNZYRTX2)
    public String getZtyknkuzusnzyrtx2() {
        return ztyknkuzusnzyrtx2;
    }

    public void setZtyknkuzusnzyrtx2(String pZtyknkuzusnzyrtx2) {
        ztyknkuzusnzyrtx2 = pZtyknkuzusnzyrtx2;
    }

    private String ztyknkuzusnzyrtx3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKNKUZUSNZYRTX3)
    public String getZtyknkuzusnzyrtx3() {
        return ztyknkuzusnzyrtx3;
    }

    public void setZtyknkuzusnzyrtx3(String pZtyknkuzusnzyrtx3) {
        ztyknkuzusnzyrtx3 = pZtyknkuzusnzyrtx3;
    }

    private String ztysinkeiyakujiknkuzusnzyrt;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSINKEIYAKUJIKNKUZUSNZYRT)
    public String getZtysinkeiyakujiknkuzusnzyrt() {
        return ztysinkeiyakujiknkuzusnzyrt;
    }

    public void setZtysinkeiyakujiknkuzusnzyrt(String pZtysinkeiyakujiknkuzusnzyrt) {
        ztysinkeiyakujiknkuzusnzyrt = pZtysinkeiyakujiknkuzusnzyrt;
    }

    private String ztytenkanjiknkuzusnzyrt;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANJIKNKUZUSNZYRT)
    public String getZtytenkanjiknkuzusnzyrt() {
        return ztytenkanjiknkuzusnzyrt;
    }

    public void setZtytenkanjiknkuzusnzyrt(String pZtytenkanjiknkuzusnzyrt) {
        ztytenkanjiknkuzusnzyrt = pZtytenkanjiknkuzusnzyrt;
    }

    private String ztysinkeiyakujivithkhyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSINKEIYAKUJIVITHKHYOUJI)
    public String getZtysinkeiyakujivithkhyouji() {
        return ztysinkeiyakujivithkhyouji;
    }

    public void setZtysinkeiyakujivithkhyouji(String pZtysinkeiyakujivithkhyouji) {
        ztysinkeiyakujivithkhyouji = pZtysinkeiyakujivithkhyouji;
    }

    private String ztykykjivithukusuukykhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKJIVITHUKUSUUKYKHYJ)
    public String getZtykykjivithukusuukykhyj() {
        return ztykykjivithukusuukykhyj;
    }

    public void setZtykykjivithukusuukykhyj(String pZtykykjivithukusuukykhyj) {
        ztykykjivithukusuukykhyj = pZtykykjivithukusuukykhyj;
    }

    private String ztysuuriyouyobin9x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN9X2)
    public String getZtysuuriyouyobin9x2() {
        return ztysuuriyouyobin9x2;
    }

    public void setZtysuuriyouyobin9x2(String pZtysuuriyouyobin9x2) {
        ztysuuriyouyobin9x2 = pZtysuuriyouyobin9x2;
    }

    private String ztypwrbksidhitekiyouhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPWRBKSIDHITEKIYOUHYJ)
    public String getZtypwrbksidhitekiyouhyj() {
        return ztypwrbksidhitekiyouhyj;
    }

    public void setZtypwrbksidhitekiyouhyj(String pZtypwrbksidhitekiyouhyj) {
        ztypwrbksidhitekiyouhyj = pZtypwrbksidhitekiyouhyj;
    }

    private String ztysuuriyouyobin9;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN9)
    public String getZtysuuriyouyobin9() {
        return ztysuuriyouyobin9;
    }

    public void setZtysuuriyouyobin9(String pZtysuuriyouyobin9) {
        ztysuuriyouyobin9 = pZtysuuriyouyobin9;
    }

    private String ztysuuriyouyobin10x7;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN10X7)
    public String getZtysuuriyouyobin10x7() {
        return ztysuuriyouyobin10x7;
    }

    public void setZtysuuriyouyobin10x7(String pZtysuuriyouyobin10x7) {
        ztysuuriyouyobin10x7 = pZtysuuriyouyobin10x7;
    }

    private String ztysuuriyouyobin10x8;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN10X8)
    public String getZtysuuriyouyobin10x8() {
        return ztysuuriyouyobin10x8;
    }

    public void setZtysuuriyouyobin10x8(String pZtysuuriyouyobin10x8) {
        ztysuuriyouyobin10x8 = pZtysuuriyouyobin10x8;
    }

    private String ztysuuriyouyobin10x9;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN10X9)
    public String getZtysuuriyouyobin10x9() {
        return ztysuuriyouyobin10x9;
    }

    public void setZtysuuriyouyobin10x9(String pZtysuuriyouyobin10x9) {
        ztysuuriyouyobin10x9 = pZtysuuriyouyobin10x9;
    }

    private Long ztytumitatekinitenbubun;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTUMITATEKINITENBUBUN)
    public Long getZtytumitatekinitenbubun() {
        return ztytumitatekinitenbubun;
    }

    public void setZtytumitatekinitenbubun(Long pZtytumitatekinitenbubun) {
        ztytumitatekinitenbubun = pZtytumitatekinitenbubun;
    }

    private Long ztysagakusknnjynbknzndk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAGAKUSKNNJYNBKNZNDK)
    public Long getZtysagakusknnjynbknzndk() {
        return ztysagakusknnjynbknzndk;
    }

    public void setZtysagakusknnjynbknzndk(Long pZtysagakusknnjynbknzndk) {
        ztysagakusknnjynbknzndk = pZtysagakusknnjynbknzndk;
    }

    private Long ztyyobin11x5;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X5)
    public Long getZtyyobin11x5() {
        return ztyyobin11x5;
    }

    public void setZtyyobin11x5(Long pZtyyobin11x5) {
        ztyyobin11x5 = pZtyyobin11x5;
    }

    private Long ztyyobin11x6;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X6)
    public Long getZtyyobin11x6() {
        return ztyyobin11x6;
    }

    public void setZtyyobin11x6(Long pZtyyobin11x6) {
        ztyyobin11x6 = pZtyyobin11x6;
    }

    private Long ztyyobin11x7;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X7)
    public Long getZtyyobin11x7() {
        return ztyyobin11x7;
    }

    public void setZtyyobin11x7(Long pZtyyobin11x7) {
        ztyyobin11x7 = pZtyyobin11x7;
    }

    private Long ztyyobin11x8;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X8)
    public Long getZtyyobin11x8() {
        return ztyyobin11x8;
    }

    public void setZtyyobin11x8(Long pZtyyobin11x8) {
        ztyyobin11x8 = pZtyyobin11x8;
    }

    private Long ztyyobin11x9;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X9)
    public Long getZtyyobin11x9() {
        return ztyyobin11x9;
    }

    public void setZtyyobin11x9(Long pZtyyobin11x9) {
        ztyyobin11x9 = pZtyyobin11x9;
    }

    private Long ztyyobin11x10;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X10)
    public Long getZtyyobin11x10() {
        return ztyyobin11x10;
    }

    public void setZtyyobin11x10(Long pZtyyobin11x10) {
        ztyyobin11x10 = pZtyyobin11x10;
    }

    private Long ztyyobin11x11;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X11)
    public Long getZtyyobin11x11() {
        return ztyyobin11x11;
    }

    public void setZtyyobin11x11(Long pZtyyobin11x11) {
        ztyyobin11x11 = pZtyyobin11x11;
    }

    private Long ztyyobin11x12;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X12)
    public Long getZtyyobin11x12() {
        return ztyyobin11x12;
    }

    public void setZtyyobin11x12(Long pZtyyobin11x12) {
        ztyyobin11x12 = pZtyyobin11x12;
    }

    private Long ztyyobin11x13;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X13)
    public Long getZtyyobin11x13() {
        return ztyyobin11x13;
    }

    public void setZtyyobin11x13(Long pZtyyobin11x13) {
        ztyyobin11x13 = pZtyyobin11x13;
    }

    private Long ztyyobin11x14;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X14)
    public Long getZtyyobin11x14() {
        return ztyyobin11x14;
    }

    public void setZtyyobin11x14(Long pZtyyobin11x14) {
        ztyyobin11x14 = pZtyyobin11x14;
    }

    private Long ztyyobin11x15;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X15)
    public Long getZtyyobin11x15() {
        return ztyyobin11x15;
    }

    public void setZtyyobin11x15(Long pZtyyobin11x15) {
        ztyyobin11x15 = pZtyyobin11x15;
    }

    private Long ztyyobin11x16;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X16)
    public Long getZtyyobin11x16() {
        return ztyyobin11x16;
    }

    public void setZtyyobin11x16(Long pZtyyobin11x16) {
        ztyyobin11x16 = pZtyyobin11x16;
    }

    private Long ztyyobin11x17;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X17)
    public Long getZtyyobin11x17() {
        return ztyyobin11x17;
    }

    public void setZtyyobin11x17(Long pZtyyobin11x17) {
        ztyyobin11x17 = pZtyyobin11x17;
    }

    private String ztyzyrthntiyustatuskbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZYRTHNTIYUSTATUSKBN)
    public String getZtyzyrthntiyustatuskbn() {
        return ztyzyrthntiyustatuskbn;
    }

    public void setZtyzyrthntiyustatuskbn(String pZtyzyrthntiyustatuskbn) {
        ztyzyrthntiyustatuskbn = pZtyzyrthntiyustatuskbn;
    }

    private String ztyzyrthntiyustatuskbnx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZYRTHNTIYUSTATUSKBNX2)
    public String getZtyzyrthntiyustatuskbnx2() {
        return ztyzyrthntiyustatuskbnx2;
    }

    public void setZtyzyrthntiyustatuskbnx2(String pZtyzyrthntiyustatuskbnx2) {
        ztyzyrthntiyustatuskbnx2 = pZtyzyrthntiyustatuskbnx2;
    }

    private String ztyzyrthntiyustatuskbnx3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZYRTHNTIYUSTATUSKBNX3)
    public String getZtyzyrthntiyustatuskbnx3() {
        return ztyzyrthntiyustatuskbnx3;
    }

    public void setZtyzyrthntiyustatuskbnx3(String pZtyzyrthntiyustatuskbnx3) {
        ztyzyrthntiyustatuskbnx3 = pZtyzyrthntiyustatuskbnx3;
    }

    private String ztyzyrthntiyustatuskbnx4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZYRTHNTIYUSTATUSKBNX4)
    public String getZtyzyrthntiyustatuskbnx4() {
        return ztyzyrthntiyustatuskbnx4;
    }

    public void setZtyzyrthntiyustatuskbnx4(String pZtyzyrthntiyustatuskbnx4) {
        ztyzyrthntiyustatuskbnx4 = pZtyzyrthntiyustatuskbnx4;
    }

    private String ztyzyrthntiyustatuskbnx5;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZYRTHNTIYUSTATUSKBNX5)
    public String getZtyzyrthntiyustatuskbnx5() {
        return ztyzyrthntiyustatuskbnx5;
    }

    public void setZtyzyrthntiyustatuskbnx5(String pZtyzyrthntiyustatuskbnx5) {
        ztyzyrthntiyustatuskbnx5 = pZtyzyrthntiyustatuskbnx5;
    }

    private String ztyyobiv10;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV10)
    public String getZtyyobiv10() {
        return ztyyobiv10;
    }

    public void setZtyyobiv10(String pZtyyobiv10) {
        ztyyobiv10 = pZtyyobiv10;
    }

    private String ztyyobiv15x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV15X2)
    public String getZtyyobiv15x2() {
        return ztyyobiv15x2;
    }

    public void setZtyyobiv15x2(String pZtyyobiv15x2) {
        ztyyobiv15x2 = pZtyyobiv15x2;
    }

    private String ztyyobiv15x3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV15X3)
    public String getZtyyobiv15x3() {
        return ztyyobiv15x3;
    }

    public void setZtyyobiv15x3(String pZtyyobiv15x3) {
        ztyyobiv15x3 = pZtyyobiv15x3;
    }

    private String ztyyobiv15x4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV15X4)
    public String getZtyyobiv15x4() {
        return ztyyobiv15x4;
    }

    public void setZtyyobiv15x4(String pZtyyobiv15x4) {
        ztyyobiv15x4 = pZtyyobiv15x4;
    }

    private String ztygaikakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykawaserate1;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAWASERATE1)
    public BizNumber getZtykawaserate1() {
        return ztykawaserate1;
    }

    public void setZtykawaserate1(BizNumber pZtykawaserate1) {
        ztykawaserate1 = pZtykawaserate1;
    }

    private String ztykawaseratetekiyouymd1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAWASERATETEKIYOUYMD1)
    public String getZtykawaseratetekiyouymd1() {
        return ztykawaseratetekiyouymd1;
    }

    public void setZtykawaseratetekiyouymd1(String pZtykawaseratetekiyouymd1) {
        ztykawaseratetekiyouymd1 = pZtykawaseratetekiyouymd1;
    }

    private BizNumber ztykawaserate2;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAWASERATE2)
    public BizNumber getZtykawaserate2() {
        return ztykawaserate2;
    }

    public void setZtykawaserate2(BizNumber pZtykawaserate2) {
        ztykawaserate2 = pZtykawaserate2;
    }

    private String ztykawaseratetekiyouymd2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAWASERATETEKIYOUYMD2)
    public String getZtykawaseratetekiyouymd2() {
        return ztykawaseratetekiyouymd2;
    }

    public void setZtykawaseratetekiyouymd2(String pZtykawaseratetekiyouymd2) {
        ztykawaseratetekiyouymd2 = pZtykawaseratetekiyouymd2;
    }

    private BizNumber ztykykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKJIKAWASERATE)
    public BizNumber getZtykykjikawaserate() {
        return ztykykjikawaserate;
    }

    public void setZtykykjikawaserate(BizNumber pZtykykjikawaserate) {
        ztykykjikawaserate = pZtykykjikawaserate;
    }

    private String ztykykjikawaseratetkyuymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKJIKAWASERATETKYUYMD)
    public String getZtykykjikawaseratetkyuymd() {
        return ztykykjikawaseratetkyuymd;
    }

    public void setZtykykjikawaseratetkyuymd(String pZtykykjikawaseratetkyuymd) {
        ztykykjikawaseratetkyuymd = pZtykykjikawaseratetkyuymd;
    }

    private Long ztymvatyouseigow;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMVATYOUSEIGOW)
    public Long getZtymvatyouseigow() {
        return ztymvatyouseigow;
    }

    public void setZtymvatyouseigow(Long pZtymvatyouseigow) {
        ztymvatyouseigow = pZtymvatyouseigow;
    }

    private Long ztymvakeisanjisknnjynbkn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMVAKEISANJISKNNJYNBKN)
    public Long getZtymvakeisanjisknnjynbkn() {
        return ztymvakeisanjisknnjynbkn;
    }

    public void setZtymvakeisanjisknnjynbkn(Long pZtymvakeisanjisknnjynbkn) {
        ztymvakeisanjisknnjynbkn = pZtymvakeisanjisknnjynbkn;
    }

    private BizNumber ztykaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAIYAKUKOUJYORITU)
    public BizNumber getZtykaiyakukoujyoritu() {
        return ztykaiyakukoujyoritu;
    }

    public void setZtykaiyakukoujyoritu(BizNumber pZtykaiyakukoujyoritu) {
        ztykaiyakukoujyoritu = pZtykaiyakukoujyoritu;
    }

    private BizNumber ztyrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRENDOURITU)
    public BizNumber getZtyrendouritu() {
        return ztyrendouritu;
    }

    public void setZtyrendouritu(BizNumber pZtyrendouritu) {
        ztyrendouritu = pZtyrendouritu;
    }

    private BizNumber ztysrkaiyakusjkkktyouseirrt;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSRKAIYAKUSJKKKTYOUSEIRRT)
    public BizNumber getZtysrkaiyakusjkkktyouseirrt() {
        return ztysrkaiyakusjkkktyouseirrt;
    }

    public void setZtysrkaiyakusjkkktyouseirrt(BizNumber pZtysrkaiyakusjkkktyouseirrt) {
        ztysrkaiyakusjkkktyouseirrt = pZtysrkaiyakusjkkktyouseirrt;
    }

    private BizNumber ztysrkyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSRKYKSJKKKTYOUSEIRIRITU)
    public BizNumber getZtysrkyksjkkktyouseiriritu() {
        return ztysrkyksjkkktyouseiriritu;
    }

    public void setZtysrkyksjkkktyouseiriritu(BizNumber pZtysrkyksjkkktyouseiriritu) {
        ztysrkyksjkkktyouseiriritu = pZtysrkyksjkkktyouseiriritu;
    }

    private String ztymvakeisankijyunymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMVAKEISANKIJYUNYMD)
    public String getZtymvakeisankijyunymd() {
        return ztymvakeisankijyunymd;
    }

    public void setZtymvakeisankijyunymd(String pZtymvakeisankijyunymd) {
        ztymvakeisankijyunymd = pZtymvakeisankijyunymd;
    }

    private BizNumber ztymvatyouseikou;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYMVATYOUSEIKOU)
    public BizNumber getZtymvatyouseikou() {
        return ztymvatyouseikou;
    }

    public void setZtymvatyouseikou(BizNumber pZtymvatyouseikou) {
        ztymvatyouseikou = pZtymvatyouseikou;
    }

    private Long ztyenkdtsbujsitihsyukngk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYENKDTSBUJSITIHSYUKNGK)
    public Long getZtyenkdtsbujsitihsyukngk() {
        return ztyenkdtsbujsitihsyukngk;
    }

    public void setZtyenkdtsbujsitihsyukngk(Long pZtyenkdtsbujsitihsyukngk) {
        ztyenkdtsbujsitihsyukngk = pZtyenkdtsbujsitihsyukngk;
    }

    private Long ztyenkdtsbujsitihsyucost;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYENKDTSBUJSITIHSYUCOST)
    public Long getZtyenkdtsbujsitihsyucost() {
        return ztyenkdtsbujsitihsyucost;
    }

    public void setZtyenkdtsbujsitihsyucost(Long pZtyenkdtsbujsitihsyucost) {
        ztyenkdtsbujsitihsyucost = pZtyenkdtsbujsitihsyucost;
    }

    private String ztyenkdtsbujsitihsyuarihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYENKDTSBUJSITIHSYUARIHYJ)
    public String getZtyenkdtsbujsitihsyuarihyj() {
        return ztyenkdtsbujsitihsyuarihyj;
    }

    public void setZtyenkdtsbujsitihsyuarihyj(String pZtyenkdtsbujsitihsyuarihyj) {
        ztyenkdtsbujsitihsyuarihyj = pZtyenkdtsbujsitihsyuarihyj;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private BizNumber ztytumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTUMITATERIRITU)
    public BizNumber getZtytumitateriritu() {
        return ztytumitateriritu;
    }

    public void setZtytumitateriritu(BizNumber pZtytumitateriritu) {
        ztytumitateriritu = pZtytumitateriritu;
    }

    private String ztykaigomaebaraitkykarihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAIGOMAEBARAITKYKARIHYJ)
    public String getZtykaigomaebaraitkykarihyj() {
        return ztykaigomaebaraitkykarihyj;
    }

    public void setZtykaigomaebaraitkykarihyj(String pZtykaigomaebaraitkykarihyj) {
        ztykaigomaebaraitkykarihyj = pZtykaigomaebaraitkykarihyj;
    }

    private String ztysibouhyoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSIBOUHYOUKBN)
    public String getZtysibouhyoukbn() {
        return ztysibouhyoukbn;
    }

    public void setZtysibouhyoukbn(String pZtysibouhyoukbn) {
        ztysibouhyoukbn = pZtysibouhyoukbn;
    }

    private String ztynyuukintuukakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYNYUUKINTUUKAKBN)
    public String getZtynyuukintuukakbn() {
        return ztynyuukintuukakbn;
    }

    public void setZtynyuukintuukakbn(String pZtynyuukintuukakbn) {
        ztynyuukintuukakbn = pZtynyuukintuukakbn;
    }

    private String ztysiharaituukakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSIHARAITUUKAKBN)
    public String getZtysiharaituukakbn() {
        return ztysiharaituukakbn;
    }

    public void setZtysiharaituukakbn(String pZtysiharaituukakbn) {
        ztysiharaituukakbn = pZtysiharaituukakbn;
    }

    private String ztywyendttargetmokuhyouritu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYWYENDTTARGETMOKUHYOURITU)
    public String getZtywyendttargetmokuhyouritu() {
        return ztywyendttargetmokuhyouritu;
    }

    public void setZtywyendttargetmokuhyouritu(String pZtywyendttargetmokuhyouritu) {
        ztywyendttargetmokuhyouritu = pZtywyendttargetmokuhyouritu;
    }

    private String ztysisuurendourate;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSISUURENDOURATE)
    public String getZtysisuurendourate() {
        return ztysisuurendourate;
    }

    public void setZtysisuurendourate(String pZtysisuurendourate) {
        ztysisuurendourate = pZtysisuurendourate;
    }

    private String ztysisuukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSISUUKBN)
    public String getZtysisuukbn() {
        return ztysisuukbn;
    }

    public void setZtysisuukbn(String pZtysisuukbn) {
        ztysisuukbn = pZtysisuukbn;
    }

    private String ztyteirituikouhyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTEIRITUIKOUHYOUJI)
    public String getZtyteirituikouhyouji() {
        return ztyteirituikouhyouji;
    }

    public void setZtyteirituikouhyouji(String pZtyteirituikouhyouji) {
        ztyteirituikouhyouji = pZtyteirituikouhyouji;
    }

    private String ztysrdai1hknkkn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSRDAI1HKNKKN)
    public String getZtysrdai1hknkkn() {
        return ztysrdai1hknkkn;
    }

    public void setZtysrdai1hknkkn(String pZtysrdai1hknkkn) {
        ztysrdai1hknkkn = pZtysrdai1hknkkn;
    }

    private String ztysuuriyouyobin10x11;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN10X11)
    public String getZtysuuriyouyobin10x11() {
        return ztysuuriyouyobin10x11;
    }

    public void setZtysuuriyouyobin10x11(String pZtysuuriyouyobin10x11) {
        ztysuuriyouyobin10x11 = pZtysuuriyouyobin10x11;
    }

    private BizNumber ztytmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTMTTKNZOUKARITUJYGN)
    public BizNumber getZtytmttknzoukaritujygn() {
        return ztytmttknzoukaritujygn;
    }

    public void setZtytmttknzoukaritujygn(BizNumber pZtytmttknzoukaritujygn) {
        ztytmttknzoukaritujygn = pZtytmttknzoukaritujygn;
    }

    private BizNumber ztysetteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSETTEIBAIRITU)
    public BizNumber getZtysetteibairitu() {
        return ztysetteibairitu;
    }

    public void setZtysetteibairitu(BizNumber pZtysetteibairitu) {
        ztysetteibairitu = pZtysetteibairitu;
    }

    private BizNumber ztytykzenoutouymdsisuu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTYKZENOUTOUYMDSISUU)
    public BizNumber getZtytykzenoutouymdsisuu() {
        return ztytykzenoutouymdsisuu;
    }

    public void setZtytykzenoutouymdsisuu(BizNumber pZtytykzenoutouymdsisuu) {
        ztytykzenoutouymdsisuu = pZtytykzenoutouymdsisuu;
    }

    private BizNumber ztykimatusisuu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKIMATUSISUU)
    public BizNumber getZtykimatusisuu() {
        return ztykimatusisuu;
    }

    public void setZtykimatusisuu(BizNumber pZtykimatusisuu) {
        ztykimatusisuu = pZtykimatusisuu;
    }

    private String ztytuukasyukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTUUKASYUKBN)
    public String getZtytuukasyukbn() {
        return ztytuukasyukbn;
    }

    public void setZtytuukasyukbn(String pZtytuukasyukbn) {
        ztytuukasyukbn = pZtytuukasyukbn;
    }

    private String ztyyobiv2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV2)
    public String getZtyyobiv2() {
        return ztyyobiv2;
    }

    public void setZtyyobiv2(String pZtyyobiv2) {
        ztyyobiv2 = pZtyyobiv2;
    }

    private Long ztyyenkadatekihons;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYENKADATEKIHONS)
    public Long getZtyyenkadatekihons() {
        return ztyyenkadatekihons;
    }

    public void setZtyyenkadatekihons(Long pZtyyenkadatekihons) {
        ztyyenkadatekihons = pZtyyenkadatekihons;
    }

    private Long ztysitihsyumegkdtsibous;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSITIHSYUMEGKDTSIBOUS)
    public Long getZtysitihsyumegkdtsibous() {
        return ztysitihsyumegkdtsibous;
    }

    public void setZtysitihsyumegkdtsibous(Long pZtysitihsyumegkdtsibous) {
        ztysitihsyumegkdtsibous = pZtysitihsyumegkdtsibous;
    }

    private Long ztyenkdtssrentumitatekin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYENKDTSSRENTUMITATEKIN)
    public Long getZtyenkdtssrentumitatekin() {
        return ztyenkdtssrentumitatekin;
    }

    public void setZtyenkdtssrentumitatekin(Long pZtyenkdtssrentumitatekin) {
        ztyenkdtssrentumitatekin = pZtyenkdtssrentumitatekin;
    }

    private Long ztysisuurentumitatekin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSISUURENTUMITATEKIN)
    public Long getZtysisuurentumitatekin() {
        return ztysisuurentumitatekin;
    }

    public void setZtysisuurentumitatekin(Long pZtysisuurentumitatekin) {
        ztysisuurentumitatekin = pZtysisuurentumitatekin;
    }

    private Long ztynksjitirttumitatekin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYNKSJITIRTTUMITATEKIN)
    public Long getZtynksjitirttumitatekin() {
        return ztynksjitirttumitatekin;
    }

    public void setZtynksjitirttumitatekin(Long pZtynksjitirttumitatekin) {
        ztynksjitirttumitatekin = pZtynksjitirttumitatekin;
    }

    private Long ztykimatutirttumitatekin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKIMATUTIRTTUMITATEKIN)
    public Long getZtykimatutirttumitatekin() {
        return ztykimatutirttumitatekin;
    }

    public void setZtykimatutirttumitatekin(Long pZtykimatutirttumitatekin) {
        ztykimatutirttumitatekin = pZtykimatutirttumitatekin;
    }

    private Long ztygaikadatejyuutoup;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGAIKADATEJYUUTOUP)
    public Long getZtygaikadatejyuutoup() {
        return ztygaikadatejyuutoup;
    }

    public void setZtygaikadatejyuutoup(Long pZtygaikadatejyuutoup) {
        ztygaikadatejyuutoup = pZtygaikadatejyuutoup;
    }

    private Long ztyyendttargetkijyunkingaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYENDTTARGETKIJYUNKINGAKU)
    public Long getZtyyendttargetkijyunkingaku() {
        return ztyyendttargetkijyunkingaku;
    }

    public void setZtyyendttargetkijyunkingaku(Long pZtyyendttargetkijyunkingaku) {
        ztyyendttargetkijyunkingaku = pZtyyendttargetkijyunkingaku;
    }

    private String ztyyobiv7;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV7)
    public String getZtyyobiv7() {
        return ztyyobiv7;
    }

    public void setZtyyobiv7(String pZtyyobiv7) {
        ztyyobiv7 = pZtyyobiv7;
    }

    private BizNumber ztysitivkisnyukykjikwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSITIVKISNYUKYKJIKWSRATE)
    public BizNumber getZtysitivkisnyukykjikwsrate() {
        return ztysitivkisnyukykjikwsrate;
    }

    public void setZtysitivkisnyukykjikwsrate(BizNumber pZtysitivkisnyukykjikwsrate) {
        ztysitivkisnyukykjikwsrate = pZtysitivkisnyukykjikwsrate;
    }

    private Long ztysisuurentyokugotmttkn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSISUURENTYOKUGOTMTTKN)
    public Long getZtysisuurentyokugotmttkn() {
        return ztysisuurentyokugotmttkn;
    }

    public void setZtysisuurentyokugotmttkn(Long pZtysisuurentyokugotmttkn) {
        ztysisuurentyokugotmttkn = pZtysisuurentyokugotmttkn;
    }

    private BizNumber ztyyoteiririturironbase;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOTEIRIRITURIRONBASE)
    public BizNumber getZtyyoteiririturironbase() {
        return ztyyoteiririturironbase;
    }

    public void setZtyyoteiririturironbase(BizNumber pZtyyoteiririturironbase) {
        ztyyoteiririturironbase = pZtyyoteiririturironbase;
    }

    private BizNumber ztyyoteiriritujtnyknbase;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOTEIRIRITUJTNYKNBASE)
    public BizNumber getZtyyoteiriritujtnyknbase() {
        return ztyyoteiriritujtnyknbase;
    }

    public void setZtyyoteiriritujtnyknbase(BizNumber pZtyyoteiriritujtnyknbase) {
        ztyyoteiriritujtnyknbase = pZtyyoteiriritujtnyknbase;
    }

    private Long ztykihrkmpjtnyknbase;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKIHRKMPJTNYKNBASE)
    public Long getZtykihrkmpjtnyknbase() {
        return ztykihrkmpjtnyknbase;
    }

    public void setZtykihrkmpjtnyknbase(Long pZtykihrkmpjtnyknbase) {
        ztykihrkmpjtnyknbase = pZtykihrkmpjtnyknbase;
    }

    private Long ztysyuptumitatekin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYUPTUMITATEKIN)
    public Long getZtysyuptumitatekin() {
        return ztysyuptumitatekin;
    }

    public void setZtysyuptumitatekin(Long pZtysyuptumitatekin) {
        ztysyuptumitatekin = pZtysyuptumitatekin;
    }

    private Long ztysyuptumitatekingsc;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYUPTUMITATEKINGSC)
    public Long getZtysyuptumitatekingsc() {
        return ztysyuptumitatekingsc;
    }

    public void setZtysyuptumitatekingsc(Long pZtysyuptumitatekingsc) {
        ztysyuptumitatekingsc = pZtysyuptumitatekingsc;
    }

    private Long ztygaikadatenkgns;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGAIKADATENKGNS)
    public Long getZtygaikadatenkgns() {
        return ztygaikadatenkgns;
    }

    public void setZtygaikadatenkgns(Long pZtygaikadatenkgns) {
        ztygaikadatenkgns = pZtygaikadatenkgns;
    }

    private String ztyjikaipjyuutouym2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYJIKAIPJYUUTOUYM2)
    public String getZtyjikaipjyuutouym2() {
        return ztyjikaipjyuutouym2;
    }

    public void setZtyjikaipjyuutouym2(String pZtyjikaipjyuutouym2) {
        ztyjikaipjyuutouym2 = pZtyjikaipjyuutouym2;
    }

    private Integer ztysuuriyobin9;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOBIN9)
    public Integer getZtysuuriyobin9() {
        return ztysuuriyobin9;
    }

    public void setZtysuuriyobin9(Integer pZtysuuriyobin9) {
        ztysuuriyobin9 = pZtysuuriyobin9;
    }

    private Long ztygessitumitatekin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGESSITUMITATEKIN)
    public Long getZtygessitumitatekin() {
        return ztygessitumitatekin;
    }

    public void setZtygessitumitatekin(Long pZtygessitumitatekin) {
        ztygessitumitatekin = pZtygessitumitatekin;
    }

    private Long ztygaikadatetougetujuutoup;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGAIKADATETOUGETUJUUTOUP)
    public Long getZtygaikadatetougetujuutoup() {
        return ztygaikadatetougetujuutoup;
    }

    public void setZtygaikadatetougetujuutoup(Long pZtygaikadatetougetujuutoup) {
        ztygaikadatetougetujuutoup = pZtygaikadatetougetujuutoup;
    }

    private Long ztykihrkmpmsukisymbase;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKIHRKMPMSUKISYMBASE)
    public Long getZtykihrkmpmsukisymbase() {
        return ztykihrkmpmsukisymbase;
    }

    public void setZtykihrkmpmsukisymbase(Long pZtykihrkmpmsukisymbase) {
        ztykihrkmpmsukisymbase = pZtykihrkmpmsukisymbase;
    }

    private Long ztykeisanhanteiyoutmttkn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKEISANHANTEIYOUTMTTKN)
    public Long getZtykeisanhanteiyoutmttkn() {
        return ztykeisanhanteiyoutmttkn;
    }

    public void setZtykeisanhanteiyoutmttkn(Long pZtykeisanhanteiyoutmttkn) {
        ztykeisanhanteiyoutmttkn = pZtykeisanhanteiyoutmttkn;
    }

    private Long ztygtmtv;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGTMTV)
    public Long getZtygtmtv() {
        return ztygtmtv;
    }

    public void setZtygtmtv(Long pZtygtmtv) {
        ztygtmtv = pZtygtmtv;
    }

    private BizNumber ztyzettaisibouritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZETTAISIBOURITU)
    public BizNumber getZtyzettaisibouritu() {
        return ztyzettaisibouritu;
    }

    public void setZtyzettaisibouritu(BizNumber pZtyzettaisibouritu) {
        ztyzettaisibouritu = pZtyzettaisibouritu;
    }

    private BizNumber ztysoutaisibouritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSOUTAISIBOURITU)
    public BizNumber getZtysoutaisibouritu() {
        return ztysoutaisibouritu;
    }

    public void setZtysoutaisibouritu(BizNumber pZtysoutaisibouritu) {
        ztysoutaisibouritu = pZtysoutaisibouritu;
    }

    private BizNumber ztysoutaikaiyakuritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSOUTAIKAIYAKURITU)
    public BizNumber getZtysoutaikaiyakuritu() {
        return ztysoutaikaiyakuritu;
    }

    public void setZtysoutaikaiyakuritu(BizNumber pZtysoutaikaiyakuritu) {
        ztysoutaikaiyakuritu = pZtysoutaikaiyakuritu;
    }

    private BizNumber ztyvhireilritu2;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYVHIREILRITU2)
    public BizNumber getZtyvhireilritu2() {
        return ztyvhireilritu2;
    }

    public void setZtyvhireilritu2(BizNumber pZtyvhireilritu2) {
        ztyvhireilritu2 = pZtyvhireilritu2;
    }

    private BizNumber ztyphireialpha;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPHIREIALPHA)
    public BizNumber getZtyphireialpha() {
        return ztyphireialpha;
    }

    public void setZtyphireialpha(BizNumber pZtyphireialpha) {
        ztyphireialpha = pZtyphireialpha;
    }

    private BizNumber ztyphireibeta;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPHIREIBETA)
    public BizNumber getZtyphireibeta() {
        return ztyphireibeta;
    }

    public void setZtyphireibeta(BizNumber pZtyphireibeta) {
        ztyphireibeta = pZtyphireibeta;
    }

    private BizNumber ztyphireiganma;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPHIREIGANMA)
    public BizNumber getZtyphireiganma() {
        return ztyphireiganma;
    }

    public void setZtyphireiganma(BizNumber pZtyphireiganma) {
        ztyphireiganma = pZtyphireiganma;
    }

    private BizNumber ztyphireilwrbkritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPHIREILWRBKRITU)
    public BizNumber getZtyphireilwrbkritu() {
        return ztyphireilwrbkritu;
    }

    public void setZtyphireilwrbkritu(BizNumber pZtyphireilwrbkritu) {
        ztyphireilwrbkritu = pZtyphireilwrbkritu;
    }

    private BizNumber ztyyoteiriritumsukisymbase;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOTEIRIRITUMSUKISYMBASE)
    public BizNumber getZtyyoteiriritumsukisymbase() {
        return ztyyoteiriritumsukisymbase;
    }

    public void setZtyyoteiriritumsukisymbase(BizNumber pZtyyoteiriritumsukisymbase) {
        ztyyoteiriritumsukisymbase = pZtyyoteiriritumsukisymbase;
    }

    private Long ztyrrthnduhknvkisovkisnyu1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRRTHNDUHKNVKISOVKISNYU1)
    public Long getZtyrrthnduhknvkisovkisnyu1() {
        return ztyrrthnduhknvkisovkisnyu1;
    }

    public void setZtyrrthnduhknvkisovkisnyu1(Long pZtyrrthnduhknvkisovkisnyu1) {
        ztyrrthnduhknvkisovkisnyu1 = pZtyrrthnduhknvkisovkisnyu1;
    }

    private Long ztyrrthnduhknvkisovkisnyu2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRRTHNDUHKNVKISOVKISNYU2)
    public Long getZtyrrthnduhknvkisovkisnyu2() {
        return ztyrrthnduhknvkisovkisnyu2;
    }

    public void setZtyrrthnduhknvkisovkisnyu2(Long pZtyrrthnduhknvkisovkisnyu2) {
        ztyrrthnduhknvkisovkisnyu2 = pZtyrrthnduhknvkisovkisnyu2;
    }

    private Long ztyrrthnduhknvkisovkisnyu3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRRTHNDUHKNVKISOVKISNYU3)
    public Long getZtyrrthnduhknvkisovkisnyu3() {
        return ztyrrthnduhknvkisovkisnyu3;
    }

    public void setZtyrrthnduhknvkisovkisnyu3(Long pZtyrrthnduhknvkisovkisnyu3) {
        ztyrrthnduhknvkisovkisnyu3 = pZtyrrthnduhknvkisovkisnyu3;
    }

    private Long ztyrrthnduhknvkisovkisnyu4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRRTHNDUHKNVKISOVKISNYU4)
    public Long getZtyrrthnduhknvkisovkisnyu4() {
        return ztyrrthnduhknvkisovkisnyu4;
    }

    public void setZtyrrthnduhknvkisovkisnyu4(Long pZtyrrthnduhknvkisovkisnyu4) {
        ztyrrthnduhknvkisovkisnyu4 = pZtyrrthnduhknvkisovkisnyu4;
    }

    private Long ztyrrthnduhknvkiso;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYRRTHNDUHKNVKISO)
    public Long getZtyrrthnduhknvkiso() {
        return ztyrrthnduhknvkiso;
    }

    public void setZtyrrthnduhknvkiso(Long pZtyrrthnduhknvkiso) {
        ztyrrthnduhknvkiso = pZtyrrthnduhknvkiso;
    }

    private Long ztytumitatekin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTUMITATEKIN)
    public Long getZtytumitatekin() {
        return ztytumitatekin;
    }

    public void setZtytumitatekin(Long pZtytumitatekin) {
        ztytumitatekin = pZtytumitatekin;
    }

    private Long ztykiharaikomip;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKIHARAIKOMIP)
    public Long getZtykiharaikomip() {
        return ztykiharaikomip;
    }

    public void setZtykiharaikomip(Long pZtykiharaikomip) {
        ztykiharaikomip = pZtykiharaikomip;
    }

    private Long ztygaikadatesyukeiyakup;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGAIKADATESYUKEIYAKUP)
    public Long getZtygaikadatesyukeiyakup() {
        return ztygaikadatesyukeiyakup;
    }

    public void setZtygaikadatesyukeiyakup(Long pZtygaikadatesyukeiyakup) {
        ztygaikadatesyukeiyakup = pZtygaikadatesyukeiyakup;
    }

    private Long ztykykkjmmvatyouseigow;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKKJMMVATYOUSEIGOW)
    public Long getZtykykkjmmvatyouseigow() {
        return ztykykkjmmvatyouseigow;
    }

    public void setZtykykkjmmvatyouseigow(Long pZtykykkjmmvatyouseigow) {
        ztykykkjmmvatyouseigow = pZtykykkjmmvatyouseigow;
    }

    private Long ztyyobin11x39;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X39)
    public Long getZtyyobin11x39() {
        return ztyyobin11x39;
    }

    public void setZtyyobin11x39(Long pZtyyobin11x39) {
        ztyyobin11x39 = pZtyyobin11x39;
    }

    private Long ztyyobin11x41;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X41)
    public Long getZtyyobin11x41() {
        return ztyyobin11x41;
    }

    public void setZtyyobin11x41(Long pZtyyobin11x41) {
        ztyyobin11x41 = pZtyyobin11x41;
    }

    private Long ztyyobin11x42;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X42)
    public Long getZtyyobin11x42() {
        return ztyyobin11x42;
    }

    public void setZtyyobin11x42(Long pZtyyobin11x42) {
        ztyyobin11x42 = pZtyyobin11x42;
    }

    private Long ztyyobin11x43;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X43)
    public Long getZtyyobin11x43() {
        return ztyyobin11x43;
    }

    public void setZtyyobin11x43(Long pZtyyobin11x43) {
        ztyyobin11x43 = pZtyyobin11x43;
    }

    private Long ztyyobin11x44;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X44)
    public Long getZtyyobin11x44() {
        return ztyyobin11x44;
    }

    public void setZtyyobin11x44(Long pZtyyobin11x44) {
        ztyyobin11x44 = pZtyyobin11x44;
    }

    private Long ztyyobin11x45;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X45)
    public Long getZtyyobin11x45() {
        return ztyyobin11x45;
    }

    public void setZtyyobin11x45(Long pZtyyobin11x45) {
        ztyyobin11x45 = pZtyyobin11x45;
    }

    private String ztysuuriyouyobin15x3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN15X3)
    public String getZtysuuriyouyobin15x3() {
        return ztysuuriyouyobin15x3;
    }

    public void setZtysuuriyouyobin15x3(String pZtysuuriyouyobin15x3) {
        ztysuuriyouyobin15x3 = pZtysuuriyouyobin15x3;
    }

    private String ztysuuriyouyobin15x4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN15X4)
    public String getZtysuuriyouyobin15x4() {
        return ztysuuriyouyobin15x4;
    }

    public void setZtysuuriyouyobin15x4(String pZtysuuriyouyobin15x4) {
        ztysuuriyouyobin15x4 = pZtysuuriyouyobin15x4;
    }

    private String ztysuuriyouyobin15x5;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN15X5)
    public String getZtysuuriyouyobin15x5() {
        return ztysuuriyouyobin15x5;
    }

    public void setZtysuuriyouyobin15x5(String pZtysuuriyouyobin15x5) {
        ztysuuriyouyobin15x5 = pZtysuuriyouyobin15x5;
    }

    private String ztysuuriyouyobin15x6;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN15X6)
    public String getZtysuuriyouyobin15x6() {
        return ztysuuriyouyobin15x6;
    }

    public void setZtysuuriyouyobin15x6(String pZtysuuriyouyobin15x6) {
        ztysuuriyouyobin15x6 = pZtysuuriyouyobin15x6;
    }

    private String ztyyobiv14;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV14)
    public String getZtyyobiv14() {
        return ztyyobiv14;
    }

    public void setZtyyobiv14(String pZtyyobiv14) {
        ztyyobiv14 = pZtyyobiv14;
    }

    private String ztykyksyhhknsydouituhyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKSYHHKNSYDOUITUHYOUJI)
    public String getZtykyksyhhknsydouituhyouji() {
        return ztykyksyhhknsydouituhyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykyksyhhknsydouituhyouji(String pZtykyksyhhknsydouituhyouji) {
        ztykyksyhhknsydouituhyouji = pZtykyksyhhknsydouituhyouji;
    }

    private String ztykyksyaskinmeino;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKSYASKINMEINO)
    public String getZtykyksyaskinmeino() {
        return ztykyksyaskinmeino;
    }

    public void setZtykyksyaskinmeino(String pZtykyksyaskinmeino) {
        ztykyksyaskinmeino = pZtykyksyaskinmeino;
    }

    private Long ztygoukeikihons;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEIKIHONS)
    public Long getZtygoukeikihons() {
        return ztygoukeikihons;
    }

    public void setZtygoukeikihons(Long pZtygoukeikihons) {
        ztygoukeikihons = pZtygoukeikihons;
    }

    private Long ztygoukeigyousekihyjsibous;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEIGYOUSEKIHYJSIBOUS)
    public Long getZtygoukeigyousekihyjsibous() {
        return ztygoukeigyousekihyjsibous;
    }

    public void setZtygoukeigyousekihyjsibous(Long pZtygoukeigyousekihyjsibous) {
        ztygoukeigyousekihyjsibous = pZtygoukeigyousekihyjsibous;
    }

    private Long ztyalmyousibous;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYALMYOUSIBOUS)
    public Long getZtyalmyousibous() {
        return ztyalmyousibous;
    }

    public void setZtyalmyousibous(Long pZtyalmyousibous) {
        ztyalmyousibous = pZtyalmyousibous;
    }

    private Long ztyharaikomip;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHARAIKOMIP)
    public Long getZtyharaikomip() {
        return ztyharaikomip;
    }

    public void setZtyharaikomip(Long pZtyharaikomip) {
        ztyharaikomip = pZtyharaikomip;
    }

    private Long ztysiteizukiharaikomip;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSITEIZUKIHARAIKOMIP)
    public Long getZtysiteizukiharaikomip() {
        return ztysiteizukiharaikomip;
    }

    public void setZtysiteizukiharaikomip(Long pZtysiteizukiharaikomip) {
        ztysiteizukiharaikomip = pZtysiteizukiharaikomip;
    }

    private Long ztysaisyuusiteimhrkp;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAISYUUSITEIMHRKP)
    public Long getZtysaisyuusiteimhrkp() {
        return ztysaisyuusiteimhrkp;
    }

    public void setZtysaisyuusiteimhrkp(Long pZtysaisyuusiteimhrkp) {
        ztysaisyuusiteimhrkp = pZtysaisyuusiteimhrkp;
    }

    private Long ztygoukeinenbaraikansanp;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEINENBARAIKANSANP)
    public Long getZtygoukeinenbaraikansanp() {
        return ztygoukeinenbaraikansanp;
    }

    public void setZtygoukeinenbaraikansanp(Long pZtygoukeinenbaraikansanp) {
        ztygoukeinenbaraikansanp = pZtygoukeinenbaraikansanp;
    }

    private String ztygyousekihyoujisrank;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGYOUSEKIHYOUJISRANK)
    public String getZtygyousekihyoujisrank() {
        return ztygyousekihyoujisrank;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtygyousekihyoujisrank(String pZtygyousekihyoujisrank) {
        ztygyousekihyoujisrank = pZtygyousekihyoujisrank;
    }

    private BizNumber ztyteikibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTEIKIBAIRITU)
    public BizNumber getZtyteikibairitu() {
        return ztyteikibairitu;
    }

    public void setZtyteikibairitu(BizNumber pZtyteikibairitu) {
        ztyteikibairitu = pZtyteikibairitu;
    }

    private String ztytenkangodatakanrino;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANGODATAKANRINO)
    public String getZtytenkangodatakanrino() {
        return ztytenkangodatakanrino;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZtytenkangodatakanrino(String pZtytenkangodatakanrino) {
        ztytenkangodatakanrino = pZtytenkangodatakanrino;
    }

    private String ztyaitekykdatakanrino1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAITEKYKDATAKANRINO1)
    public String getZtyaitekykdatakanrino1() {
        return ztyaitekykdatakanrino1;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZtyaitekykdatakanrino1(String pZtyaitekykdatakanrino1) {
        ztyaitekykdatakanrino1 = pZtyaitekykdatakanrino1;
    }

    private String ztyaitekykdatakanrino2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAITEKYKDATAKANRINO2)
    public String getZtyaitekykdatakanrino2() {
        return ztyaitekykdatakanrino2;
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZtyaitekykdatakanrino2(String pZtyaitekykdatakanrino2) {
        ztyaitekykdatakanrino2 = pZtyaitekykdatakanrino2;
    }

    private String ztytnknsyokaipcashlesshyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNSYOKAIPCASHLESSHYJ)
    public String getZtytnknsyokaipcashlesshyj() {
        return ztytnknsyokaipcashlesshyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytnknsyokaipcashlesshyj(String pZtytnknsyokaipcashlesshyj) {
        ztytnknsyokaipcashlesshyj = pZtytnknsyokaipcashlesshyj;
    }

    private String ztysyokaipannaikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYOKAIPANNAIKBN)
    public String getZtysyokaipannaikbn() {
        return ztysyokaipannaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysyokaipannaikbn(String pZtysyokaipannaikbn) {
        ztysyokaipannaikbn = pZtysyokaipannaikbn;
    }

    private String ztyzennoukaisiymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZENNOUKAISIYMD)
    public String getZtyzennoukaisiymd() {
        return ztyzennoukaisiymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyzennoukaisiymd(String pZtyzennoukaisiymd) {
        ztyzennoukaisiymd = pZtyzennoukaisiymd;
    }

    private String ztyzennoukikan;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYZENNOUKIKAN)
    public String getZtyzennoukikan() {
        return ztyzennoukikan;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyzennoukikan(String pZtyzennoukikan) {
        ztyzennoukikan = pZtyzennoukikan;
    }

    private String ztyseizonkyuuhukinsiteiy;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSEIZONKYUUHUKINSITEIY)
    public String getZtyseizonkyuuhukinsiteiy() {
        return ztyseizonkyuuhukinsiteiy;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyseizonkyuuhukinsiteiy(String pZtyseizonkyuuhukinsiteiy) {
        ztyseizonkyuuhukinsiteiy = pZtyseizonkyuuhukinsiteiy;
    }

    private String ztyalmyouseizonkyhknsiteimd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYALMYOUSEIZONKYHKNSITEIMD)
    public String getZtyalmyouseizonkyhknsiteimd() {
        return ztyalmyouseizonkyhknsiteimd;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyalmyouseizonkyhknsiteimd(String pZtyalmyouseizonkyhknsiteimd) {
        ztyalmyouseizonkyhknsiteimd = pZtyalmyouseizonkyhknsiteimd;
    }

    private String ztyjikaipjyuutouym;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYJIKAIPJYUUTOUYM)
    public String getZtyjikaipjyuutouym() {
        return ztyjikaipjyuutouym;
    }

    public void setZtyjikaipjyuutouym(String pZtyjikaipjyuutouym) {
        ztyjikaipjyuutouym = pZtyjikaipjyuutouym;
    }

    private String ztykykjiqpackhyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKJIQPACKHYJ)
    public String getZtykykjiqpackhyj() {
        return ztykykjiqpackhyj;
    }

    public void setZtykykjiqpackhyj(String pZtykykjiqpackhyj) {
        ztykykjiqpackhyj = pZtykykjiqpackhyj;
    }

    private String ztyhktgtikkikkkn3x1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKTGTIKKIKKKN3X1)
    public String getZtyhktgtikkikkkn3x1() {
        return ztyhktgtikkikkkn3x1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkkn3x1(String pZtyhktgtikkikkkn3x1) {
        ztyhktgtikkikkkn3x1 = pZtyhktgtikkikkkn3x1;
    }

    private String ztyhktgtikkikkkn3x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKTGTIKKIKKKN3X2)
    public String getZtyhktgtikkikkkn3x2() {
        return ztyhktgtikkikkkn3x2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkkn3x2(String pZtyhktgtikkikkkn3x2) {
        ztyhktgtikkikkkn3x2 = pZtyhktgtikkikkkn3x2;
    }

    private String ztyhktgtikkikkkn3x3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKTGTIKKIKKKN3X3)
    public String getZtyhktgtikkikkkn3x3() {
        return ztyhktgtikkikkkn3x3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkkn3x3(String pZtyhktgtikkikkkn3x3) {
        ztyhktgtikkikkkn3x3 = pZtyhktgtikkikkkn3x3;
    }

    private String ztyhktgtikkikkkn3x4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKTGTIKKIKKKN3X4)
    public String getZtyhktgtikkikkkn3x4() {
        return ztyhktgtikkikkkn3x4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkkn3x4(String pZtyhktgtikkikkkn3x4) {
        ztyhktgtikkikkkn3x4 = pZtyhktgtikkikkkn3x4;
    }

    private String ztykappadkeisankbnx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAPPADKEISANKBNX1)
    public String getZtykappadkeisankbnx1() {
        return ztykappadkeisankbnx1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykappadkeisankbnx1(String pZtykappadkeisankbnx1) {
        ztykappadkeisankbnx1 = pZtykappadkeisankbnx1;
    }

    private String ztykappadkeisankbnx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAPPADKEISANKBNX2)
    public String getZtykappadkeisankbnx2() {
        return ztykappadkeisankbnx2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykappadkeisankbnx2(String pZtykappadkeisankbnx2) {
        ztykappadkeisankbnx2 = pZtykappadkeisankbnx2;
    }

    private String ztykappadkeisankbnx3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAPPADKEISANKBNX3)
    public String getZtykappadkeisankbnx3() {
        return ztykappadkeisankbnx3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykappadkeisankbnx3(String pZtykappadkeisankbnx3) {
        ztykappadkeisankbnx3 = pZtykappadkeisankbnx3;
    }

    private String ztykappadkeisankbnx4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAPPADKEISANKBNX4)
    public String getZtykappadkeisankbnx4() {
        return ztykappadkeisankbnx4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtykappadkeisankbnx4(String pZtykappadkeisankbnx4) {
        ztykappadkeisankbnx4 = pZtykappadkeisankbnx4;
    }

    private String ztysuuriyouyobin2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN2)
    public String getZtysuuriyouyobin2() {
        return ztysuuriyouyobin2;
    }

    public void setZtysuuriyouyobin2(String pZtysuuriyouyobin2) {
        ztysuuriyouyobin2 = pZtysuuriyouyobin2;
    }

    private String ztyyobiv6x3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV6X3)
    public String getZtyyobiv6x3() {
        return ztyyobiv6x3;
    }

    public void setZtyyobiv6x3(String pZtyyobiv6x3) {
        ztyyobiv6x3 = pZtyyobiv6x3;
    }

    private Long ztykimatuvyoutumimasikin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKIMATUVYOUTUMIMASIKIN)
    public Long getZtykimatuvyoutumimasikin() {
        return ztykimatuvyoutumimasikin;
    }

    public void setZtykimatuvyoutumimasikin(Long pZtykimatuvyoutumimasikin) {
        ztykimatuvyoutumimasikin = pZtykimatuvyoutumimasikin;
    }

    private Long ztykmtvyusnhknfundtmttkin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKMTVYUSNHKNFUNDTMTTKIN)
    public Long getZtykmtvyusnhknfundtmttkin() {
        return ztykmtvyusnhknfundtmttkin;
    }

    public void setZtykmtvyusnhknfundtmttkin(Long pZtykmtvyusnhknfundtmttkin) {
        ztykmtvyusnhknfundtmttkin = pZtykmtvyusnhknfundtmttkin;
    }

    private Long ztygoukeinenkansanp3x1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEINENKANSANP3X1)
    public Long getZtygoukeinenkansanp3x1() {
        return ztygoukeinenkansanp3x1;
    }

    public void setZtygoukeinenkansanp3x1(Long pZtygoukeinenkansanp3x1) {
        ztygoukeinenkansanp3x1 = pZtygoukeinenkansanp3x1;
    }

    private Long ztygoukeinenkansanp3x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEINENKANSANP3X2)
    public Long getZtygoukeinenkansanp3x2() {
        return ztygoukeinenkansanp3x2;
    }

    public void setZtygoukeinenkansanp3x2(Long pZtygoukeinenkansanp3x2) {
        ztygoukeinenkansanp3x2 = pZtygoukeinenkansanp3x2;
    }

    private Long ztygoukeinenkansanp3x3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEINENKANSANP3X3)
    public Long getZtygoukeinenkansanp3x3() {
        return ztygoukeinenkansanp3x3;
    }

    public void setZtygoukeinenkansanp3x3(Long pZtygoukeinenkansanp3x3) {
        ztygoukeinenkansanp3x3 = pZtygoukeinenkansanp3x3;
    }

    private Long ztygoukeinenkansanp3x4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEINENKANSANP3X4)
    public Long getZtygoukeinenkansanp3x4() {
        return ztygoukeinenkansanp3x4;
    }

    public void setZtygoukeinenkansanp3x4(Long pZtygoukeinenkansanp3x4) {
        ztygoukeinenkansanp3x4 = pZtygoukeinenkansanp3x4;
    }

    private Long ztykmtvyuhijynbritmttkin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKMTVYUHIJYNBRITMTTKIN)
    public Long getZtykmtvyuhijynbritmttkin() {
        return ztykmtvyuhijynbritmttkin;
    }

    public void setZtykmtvyuhijynbritmttkin(Long pZtykmtvyuhijynbritmttkin) {
        ztykmtvyuhijynbritmttkin = pZtykmtvyuhijynbritmttkin;
    }

    private Long ztykimatuvyouitjbrtmttkin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKIMATUVYOUITJBRTMTTKIN)
    public Long getZtykimatuvyouitjbrtmttkin() {
        return ztykimatuvyouitjbrtmttkin;
    }

    public void setZtykimatuvyouitjbrtmttkin(Long pZtykimatuvyouitjbrtmttkin) {
        ztykimatuvyouitjbrtmttkin = pZtykimatuvyouitjbrtmttkin;
    }

    private Long ztyyobin11x26;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X26)
    public Long getZtyyobin11x26() {
        return ztyyobin11x26;
    }

    public void setZtyyobin11x26(Long pZtyyobin11x26) {
        ztyyobin11x26 = pZtyyobin11x26;
    }

    private Long ztyyobin11x27;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X27)
    public Long getZtyyobin11x27() {
        return ztyyobin11x27;
    }

    public void setZtyyobin11x27(Long pZtyyobin11x27) {
        ztyyobin11x27 = pZtyyobin11x27;
    }

    private Long ztyyobin11x28;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X28)
    public Long getZtyyobin11x28() {
        return ztyyobin11x28;
    }

    public void setZtyyobin11x28(Long pZtyyobin11x28) {
        ztyyobin11x28 = pZtyyobin11x28;
    }

    private Long ztyyobin11x29;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X29)
    public Long getZtyyobin11x29() {
        return ztyyobin11x29;
    }

    public void setZtyyobin11x29(Long pZtyyobin11x29) {
        ztyyobin11x29 = pZtyyobin11x29;
    }

    private Long ztyyobin11x30;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X30)
    public Long getZtyyobin11x30() {
        return ztyyobin11x30;
    }

    public void setZtyyobin11x30(Long pZtyyobin11x30) {
        ztyyobin11x30 = pZtyyobin11x30;
    }

    private Long ztyyobin11x31;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X31)
    public Long getZtyyobin11x31() {
        return ztyyobin11x31;
    }

    public void setZtyyobin11x31(Long pZtyyobin11x31) {
        ztyyobin11x31 = pZtyyobin11x31;
    }

    private Long ztyyobin11x32;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X32)
    public Long getZtyyobin11x32() {
        return ztyyobin11x32;
    }

    public void setZtyyobin11x32(Long pZtyyobin11x32) {
        ztyyobin11x32 = pZtyyobin11x32;
    }

    private Long ztyyobin11x33;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X33)
    public Long getZtyyobin11x33() {
        return ztyyobin11x33;
    }

    public void setZtyyobin11x33(Long pZtyyobin11x33) {
        ztyyobin11x33 = pZtyyobin11x33;
    }

    private Long ztyhaitouyouloadingkijyuns;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHAITOUYOULOADINGKIJYUNS)
    public Long getZtyhaitouyouloadingkijyuns() {
        return ztyhaitouyouloadingkijyuns;
    }

    public void setZtyhaitouyouloadingkijyuns(Long pZtyhaitouyouloadingkijyuns) {
        ztyhaitouyouloadingkijyuns = pZtyhaitouyouloadingkijyuns;
    }

    private String ztytouduketorihouhoukbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOUDUKETORIHOUHOUKBN)
    public String getZtytouduketorihouhoukbn() {
        return ztytouduketorihouhoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytouduketorihouhoukbn(String pZtytouduketorihouhoukbn) {
        ztytouduketorihouhoukbn = pZtytouduketorihouhoukbn;
    }

    private Long ztytumitated;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTUMITATED)
    public Long getZtytumitated() {
        return ztytumitated;
    }

    public void setZtytumitated(Long pZtytumitated) {
        ztytumitated = pZtytumitated;
    }

    private Long ztykariwariated;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKARIWARIATED)
    public Long getZtykariwariated() {
        return ztykariwariated;
    }

    public void setZtykariwariated(Long pZtykariwariated) {
        ztykariwariated = pZtykariwariated;
    }

    private String ztytyokuzensiharaikijitu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTYOKUZENSIHARAIKIJITU)
    public String getZtytyokuzensiharaikijitu() {
        return ztytyokuzensiharaikijitu;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtytyokuzensiharaikijitu(String pZtytyokuzensiharaikijitu) {
        ztytyokuzensiharaikijitu = pZtytyokuzensiharaikijitu;
    }

    private Long ztytyokuzentuusanhanteis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTYOKUZENTUUSANHANTEIS)
    public Long getZtytyokuzentuusanhanteis() {
        return ztytyokuzentuusanhanteis;
    }

    public void setZtytyokuzentuusanhanteis(Long pZtytyokuzentuusanhanteis) {
        ztytyokuzentuusanhanteis = pZtytyokuzentuusanhanteis;
    }

    private String ztytyokugosiharaikijitu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTYOKUGOSIHARAIKIJITU)
    public String getZtytyokugosiharaikijitu() {
        return ztytyokugosiharaikijitu;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtytyokugosiharaikijitu(String pZtytyokugosiharaikijitu) {
        ztytyokugosiharaikijitu = pZtytyokugosiharaikijitu;
    }

    private Long ztytyokugotuusanhanteis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTYOKUGOTUUSANHANTEIS)
    public Long getZtytyokugotuusanhanteis() {
        return ztytyokugotuusanhanteis;
    }

    public void setZtytyokugotuusanhanteis(Long pZtytyokugotuusanhanteis) {
        ztytyokugotuusanhanteis = pZtytyokugotuusanhanteis;
    }

    private Long ztytyokugokyuuhutaisyous;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTYOKUGOKYUUHUTAISYOUS)
    public Long getZtytyokugokyuuhutaisyous() {
        return ztytyokugokyuuhutaisyous;
    }

    public void setZtytyokugokyuuhutaisyous(Long pZtytyokugokyuuhutaisyous) {
        ztytyokugokyuuhutaisyous = pZtytyokugokyuuhutaisyous;
    }

    private Long ztytyokugocbkingaku;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTYOKUGOCBKINGAKU)
    public Long getZtytyokugocbkingaku() {
        return ztytyokugocbkingaku;
    }

    public void setZtytyokugocbkingaku(Long pZtytyokugocbkingaku) {
        ztytyokugocbkingaku = pZtytyokugocbkingaku;
    }

    private String ztysyokaisiharaikijitu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYOKAISIHARAIKIJITU)
    public String getZtysyokaisiharaikijitu() {
        return ztysyokaisiharaikijitu;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtysyokaisiharaikijitu(String pZtysyokaisiharaikijitu) {
        ztysyokaisiharaikijitu = pZtysyokaisiharaikijitu;
    }

    private Long ztysyokaituusanhanteis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYOKAITUUSANHANTEIS)
    public Long getZtysyokaituusanhanteis() {
        return ztysyokaituusanhanteis;
    }

    public void setZtysyokaituusanhanteis(Long pZtysyokaituusanhanteis) {
        ztysyokaituusanhanteis = pZtysyokaituusanhanteis;
    }

    private Long ztycbnayosetuusanhanteis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYCBNAYOSETUUSANHANTEIS)
    public Long getZtycbnayosetuusanhanteis() {
        return ztycbnayosetuusanhanteis;
    }

    public void setZtycbnayosetuusanhanteis(Long pZtycbnayosetuusanhanteis) {
        ztycbnayosetuusanhanteis = pZtycbnayosetuusanhanteis;
    }

    private String ztyhitenkankeiyakusuu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHITENKANKEIYAKUSUU)
    public String getZtyhitenkankeiyakusuu() {
        return ztyhitenkankeiyakusuu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhitenkankeiyakusuu(String pZtyhitenkankeiyakusuu) {
        ztyhitenkankeiyakusuu = pZtyhitenkankeiyakusuu;
    }

    private Long ztygoukeipbubuntenkanteikis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYGOUKEIPBUBUNTENKANTEIKIS)
    public Long getZtygoukeipbubuntenkanteikis() {
        return ztygoukeipbubuntenkanteikis;
    }

    public void setZtygoukeipbubuntenkanteikis(Long pZtygoukeipbubuntenkanteikis) {
        ztygoukeipbubuntenkanteikis = pZtygoukeipbubuntenkanteikis;
    }

    private String ztysaidaihktgtikkikkkn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAIDAIHKTGTIKKIKKKN)
    public String getZtysaidaihktgtikkikkkn() {
        return ztysaidaihktgtikkikkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtysaidaihktgtikkikkkn(String pZtysaidaihktgtikkikkkn) {
        ztysaidaihktgtikkikkkn = pZtysaidaihktgtikkikkkn;
    }

    private Long ztysisyutnknhktgkujygk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSISYUTNKNHKTGKUJYGK)
    public Long getZtysisyutnknhktgkujygk() {
        return ztysisyutnknhktgkujygk;
    }

    public void setZtysisyutnknhktgkujygk(Long pZtysisyutnknhktgkujygk) {
        ztysisyutnknhktgkujygk = pZtysisyutnknhktgkujygk;
    }

    private Long ztyyobin11x34;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X34)
    public Long getZtyyobin11x34() {
        return ztyyobin11x34;
    }

    public void setZtyyobin11x34(Long pZtyyobin11x34) {
        ztyyobin11x34 = pZtyyobin11x34;
    }

    private String ztyhtnknkykkykymdx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHTNKNKYKKYKYMDX1)
    public String getZtyhtnknkykkykymdx1() {
        return ztyhtnknkykkykymdx1;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhtnknkykkykymdx1(String pZtyhtnknkykkykymdx1) {
        ztyhtnknkykkykymdx1 = pZtyhtnknkykkykymdx1;
    }

    private Long ztytnkntkbtdkisnyusx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNTKBTDKISNYUSX1)
    public Long getZtytnkntkbtdkisnyusx1() {
        return ztytnkntkbtdkisnyusx1;
    }

    public void setZtytnkntkbtdkisnyusx1(Long pZtytnkntkbtdkisnyusx1) {
        ztytnkntkbtdkisnyusx1 = pZtytnkntkbtdkisnyusx1;
    }

    private String ztytnknkaiykkujytksux1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNKAIYKKUJYTKSUX1)
    public String getZtytnknkaiykkujytksux1() {
        return ztytnknkaiykkujytksux1;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtytnknkaiykkujytksux1(String pZtytnknkaiykkujytksux1) {
        ztytnknkaiykkujytksux1 = pZtytnknkaiykkujytksux1;
    }

    private Long ztytnknkaiykkujygkx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNKAIYKKUJYGKX1)
    public Long getZtytnknkaiykkujygkx1() {
        return ztytnknkaiykkujygkx1;
    }

    public void setZtytnknkaiykkujygkx1(Long pZtytnknkaiykkujygkx1) {
        ztytnknkaiykkujygkx1 = pZtytnknkaiykkujygkx1;
    }

    private String ztytenkanteikihyoujix1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANTEIKIHYOUJIX1)
    public String getZtytenkanteikihyoujix1() {
        return ztytenkanteikihyoujix1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanteikihyoujix1(String pZtytenkanteikihyoujix1) {
        ztytenkanteikihyoujix1 = pZtytenkanteikihyoujix1;
    }

    private Long ztyhtnknkyknenknsnpx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHTNKNKYKNENKNSNPX1)
    public Long getZtyhtnknkyknenknsnpx1() {
        return ztyhtnknkyknenknsnpx1;
    }

    public void setZtyhtnknkyknenknsnpx1(Long pZtyhtnknkyknenknsnpx1) {
        ztyhtnknkyknenknsnpx1 = pZtyhtnknkyknenknsnpx1;
    }

    private String ztyhktgtikkikkknx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKTGTIKKIKKKNX1)
    public String getZtyhktgtikkikkknx1() {
        return ztyhktgtikkikkknx1;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkknx1(String pZtyhktgtikkikkknx1) {
        ztyhktgtikkikkknx1 = pZtyhktgtikkikkknx1;
    }

    private String ztyhtnknkykkykymdx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHTNKNKYKKYKYMDX2)
    public String getZtyhtnknkykkykymdx2() {
        return ztyhtnknkykkykymdx2;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhtnknkykkykymdx2(String pZtyhtnknkykkykymdx2) {
        ztyhtnknkykkykymdx2 = pZtyhtnknkykkykymdx2;
    }

    private Long ztytnkntkbtdkisnyusx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNTKBTDKISNYUSX2)
    public Long getZtytnkntkbtdkisnyusx2() {
        return ztytnkntkbtdkisnyusx2;
    }

    public void setZtytnkntkbtdkisnyusx2(Long pZtytnkntkbtdkisnyusx2) {
        ztytnkntkbtdkisnyusx2 = pZtytnkntkbtdkisnyusx2;
    }

    private String ztytnknkaiykkujytksux2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNKAIYKKUJYTKSUX2)
    public String getZtytnknkaiykkujytksux2() {
        return ztytnknkaiykkujytksux2;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtytnknkaiykkujytksux2(String pZtytnknkaiykkujytksux2) {
        ztytnknkaiykkujytksux2 = pZtytnknkaiykkujytksux2;
    }

    private Long ztytnknkaiykkujygkx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNKAIYKKUJYGKX2)
    public Long getZtytnknkaiykkujygkx2() {
        return ztytnknkaiykkujygkx2;
    }

    public void setZtytnknkaiykkujygkx2(Long pZtytnknkaiykkujygkx2) {
        ztytnknkaiykkujygkx2 = pZtytnknkaiykkujygkx2;
    }

    private String ztytenkanteikihyoujix2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANTEIKIHYOUJIX2)
    public String getZtytenkanteikihyoujix2() {
        return ztytenkanteikihyoujix2;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanteikihyoujix2(String pZtytenkanteikihyoujix2) {
        ztytenkanteikihyoujix2 = pZtytenkanteikihyoujix2;
    }

    private Long ztyhtnknkyknenknsnpx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHTNKNKYKNENKNSNPX2)
    public Long getZtyhtnknkyknenknsnpx2() {
        return ztyhtnknkyknenknsnpx2;
    }

    public void setZtyhtnknkyknenknsnpx2(Long pZtyhtnknkyknenknsnpx2) {
        ztyhtnknkyknenknsnpx2 = pZtyhtnknkyknenknsnpx2;
    }

    private String ztyhktgtikkikkknx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKTGTIKKIKKKNX2)
    public String getZtyhktgtikkikkknx2() {
        return ztyhktgtikkikkknx2;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkknx2(String pZtyhktgtikkikkknx2) {
        ztyhktgtikkikkknx2 = pZtyhktgtikkikkknx2;
    }

    private String ztyhtnknkykkykymdx3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHTNKNKYKKYKYMDX3)
    public String getZtyhtnknkykkykymdx3() {
        return ztyhtnknkykkykymdx3;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhtnknkykkykymdx3(String pZtyhtnknkykkykymdx3) {
        ztyhtnknkykkykymdx3 = pZtyhtnknkykkykymdx3;
    }

    private Long ztytnkntkbtdkisnyusx3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNTKBTDKISNYUSX3)
    public Long getZtytnkntkbtdkisnyusx3() {
        return ztytnkntkbtdkisnyusx3;
    }

    public void setZtytnkntkbtdkisnyusx3(Long pZtytnkntkbtdkisnyusx3) {
        ztytnkntkbtdkisnyusx3 = pZtytnkntkbtdkisnyusx3;
    }

    private String ztytnknkaiykkujytksux3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNKAIYKKUJYTKSUX3)
    public String getZtytnknkaiykkujytksux3() {
        return ztytnknkaiykkujytksux3;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtytnknkaiykkujytksux3(String pZtytnknkaiykkujytksux3) {
        ztytnknkaiykkujytksux3 = pZtytnknkaiykkujytksux3;
    }

    private Long ztytnknkaiykkujygkx3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNKAIYKKUJYGKX3)
    public Long getZtytnknkaiykkujygkx3() {
        return ztytnknkaiykkujygkx3;
    }

    public void setZtytnknkaiykkujygkx3(Long pZtytnknkaiykkujygkx3) {
        ztytnknkaiykkujygkx3 = pZtytnknkaiykkujygkx3;
    }

    private String ztytenkanteikihyoujix3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANTEIKIHYOUJIX3)
    public String getZtytenkanteikihyoujix3() {
        return ztytenkanteikihyoujix3;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanteikihyoujix3(String pZtytenkanteikihyoujix3) {
        ztytenkanteikihyoujix3 = pZtytenkanteikihyoujix3;
    }

    private Long ztyhtnknkyknenknsnpx3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHTNKNKYKNENKNSNPX3)
    public Long getZtyhtnknkyknenknsnpx3() {
        return ztyhtnknkyknenknsnpx3;
    }

    public void setZtyhtnknkyknenknsnpx3(Long pZtyhtnknkyknenknsnpx3) {
        ztyhtnknkyknenknsnpx3 = pZtyhtnknkyknenknsnpx3;
    }

    private String ztyhktgtikkikkknx3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKTGTIKKIKKKNX3)
    public String getZtyhktgtikkikkknx3() {
        return ztyhktgtikkikkknx3;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkknx3(String pZtyhktgtikkikkknx3) {
        ztyhktgtikkikkknx3 = pZtyhktgtikkikkknx3;
    }

    private String ztyhtnknkykkykymdx4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHTNKNKYKKYKYMDX4)
    public String getZtyhtnknkykkykymdx4() {
        return ztyhtnknkykkykymdx4;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZtyhtnknkykkykymdx4(String pZtyhtnknkykkykymdx4) {
        ztyhtnknkykkykymdx4 = pZtyhtnknkykkykymdx4;
    }

    private Long ztytnkntkbtdkisnyusx4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNTKBTDKISNYUSX4)
    public Long getZtytnkntkbtdkisnyusx4() {
        return ztytnkntkbtdkisnyusx4;
    }

    public void setZtytnkntkbtdkisnyusx4(Long pZtytnkntkbtdkisnyusx4) {
        ztytnkntkbtdkisnyusx4 = pZtytnkntkbtdkisnyusx4;
    }

    private String ztytnknkaiykkujytksux4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNKAIYKKUJYTKSUX4)
    public String getZtytnknkaiykkujytksux4() {
        return ztytnknkaiykkujytksux4;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtytnknkaiykkujytksux4(String pZtytnknkaiykkujytksux4) {
        ztytnknkaiykkujytksux4 = pZtytnknkaiykkujytksux4;
    }

    private Long ztytnknkaiykkujygkx4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTNKNKAIYKKUJYGKX4)
    public Long getZtytnknkaiykkujygkx4() {
        return ztytnknkaiykkujygkx4;
    }

    public void setZtytnknkaiykkujygkx4(Long pZtytnknkaiykkujygkx4) {
        ztytnknkaiykkujygkx4 = pZtytnknkaiykkujygkx4;
    }

    private String ztytenkanteikihyoujix4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANTEIKIHYOUJIX4)
    public String getZtytenkanteikihyoujix4() {
        return ztytenkanteikihyoujix4;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytenkanteikihyoujix4(String pZtytenkanteikihyoujix4) {
        ztytenkanteikihyoujix4 = pZtytenkanteikihyoujix4;
    }

    private Long ztyhtnknkyknenknsnpx4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHTNKNKYKNENKNSNPX4)
    public Long getZtyhtnknkyknenknsnpx4() {
        return ztyhtnknkyknenknsnpx4;
    }

    public void setZtyhtnknkyknenknsnpx4(Long pZtyhtnknkyknenknsnpx4) {
        ztyhtnknkyknenknsnpx4 = pZtyhtnknkyknenknsnpx4;
    }

    private String ztyhktgtikkikkknx4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHKTGTIKKIKKKNX4)
    public String getZtyhktgtikkikkknx4() {
        return ztyhktgtikkikkknx4;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyhktgtikkikkknx4(String pZtyhktgtikkikkknx4) {
        ztyhktgtikkikkknx4 = pZtyhktgtikkikkknx4;
    }

    private String ztysknjyututkykkykkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSKNJYUTUTKYKKYKKBN)
    public String getZtysknjyututkykkykkbn() {
        return ztysknjyututkykkykkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtysknjyututkykkykkbn(String pZtysknjyututkykkykkbn) {
        ztysknjyututkykkykkbn = pZtysknjyututkykkykkbn;
    }

    private Long ztyswingminyuuphrkekngk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSWINGMINYUUPHRKEKNGK)
    public Long getZtyswingminyuuphrkekngk() {
        return ztyswingminyuuphrkekngk;
    }

    public void setZtyswingminyuuphrkekngk(Long pZtyswingminyuuphrkekngk) {
        ztyswingminyuuphrkekngk = pZtyswingminyuuphrkekngk;
    }

    private String ztyswingminyuuphrkejyutuym;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSWINGMINYUUPHRKEJYUTUYM)
    public String getZtyswingminyuuphrkejyutuym() {
        return ztyswingminyuuphrkejyutuym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtyswingminyuuphrkejyutuym(String pZtyswingminyuuphrkejyutuym) {
        ztyswingminyuuphrkejyutuym = pZtyswingminyuuphrkejyutuym;
    }

    private Long ztydftounendoitijitounyuup;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDFTOUNENDOITIJITOUNYUUP)
    public Long getZtydftounendoitijitounyuup() {
        return ztydftounendoitijitounyuup;
    }

    public void setZtydftounendoitijitounyuup(Long pZtydftounendoitijitounyuup) {
        ztydftounendoitijitounyuup = pZtydftounendoitijitounyuup;
    }

    private Long ztydfkaiyakukujyhktggk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDFKAIYAKUKUJYHKTGGK)
    public Long getZtydfkaiyakukujyhktggk() {
        return ztydfkaiyakukujyhktggk;
    }

    public void setZtydfkaiyakukujyhktggk(Long pZtydfkaiyakukujyhktggk) {
        ztydfkaiyakukujyhktggk = pZtydfkaiyakukujyhktggk;
    }

    private String ztykaiyakukoujyotukisuu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAIYAKUKOUJYOTUKISUU)
    public String getZtykaiyakukoujyotukisuu() {
        return ztykaiyakukoujyotukisuu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtykaiyakukoujyotukisuu(String pZtykaiyakukoujyotukisuu) {
        ztykaiyakukoujyotukisuu = pZtykaiyakukoujyotukisuu;
    }

    private Long ztydfkaiyakuhenreikin;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDFKAIYAKUHENREIKIN)
    public Long getZtydfkaiyakuhenreikin() {
        return ztydfkaiyakuhenreikin;
    }

    public void setZtydfkaiyakuhenreikin(Long pZtydfkaiyakuhenreikin) {
        ztydfkaiyakuhenreikin = pZtydfkaiyakuhenreikin;
    }

    private Long ztysyuuseis;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYUUSEIS)
    public Long getZtysyuuseis() {
        return ztysyuuseis;
    }

    public void setZtysyuuseis(Long pZtysyuuseis) {
        ztysyuuseis = pZtysyuuseis;
    }

    private String ztyaatukaisyakeisyousisyacd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAATUKAISYAKEISYOUSISYACD)
    public String getZtyaatukaisyakeisyousisyacd() {
        return ztyaatukaisyakeisyousisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtyaatukaisyakeisyousisyacd(String pZtyaatukaisyakeisyousisyacd) {
        ztyaatukaisyakeisyousisyacd = pZtyaatukaisyakeisyousisyacd;
    }

    private String ztyaatukaisyazaisekihyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAATUKAISYAZAISEKIHYOUJI)
    public String getZtyaatukaisyazaisekihyouji() {
        return ztyaatukaisyazaisekihyouji;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyaatukaisyazaisekihyouji(String pZtyaatukaisyazaisekihyouji) {
        ztyaatukaisyazaisekihyouji = pZtyaatukaisyazaisekihyouji;
    }

    private String ztyaatukaisyabosyuujiage;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAATUKAISYABOSYUUJIAGE)
    public String getZtyaatukaisyabosyuujiage() {
        return ztyaatukaisyabosyuujiage;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyaatukaisyabosyuujiage(String pZtyaatukaisyabosyuujiage) {
        ztyaatukaisyabosyuujiage = pZtyaatukaisyabosyuujiage;
    }

    private String ztyaatukaisyabsyjisikakucd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAATUKAISYABSYJISIKAKUCD)
    public String getZtyaatukaisyabsyjisikakucd() {
        return ztyaatukaisyabsyjisikakucd;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZtyaatukaisyabsyjisikakucd(String pZtyaatukaisyabsyjisikakucd) {
        ztyaatukaisyabsyjisikakucd = pZtyaatukaisyabsyjisikakucd;
    }

    private String ztyaatukaisyasikakucd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYAATUKAISYASIKAKUCD)
    public String getZtyaatukaisyasikakucd() {
        return ztyaatukaisyasikakucd;
    }

    @Padding(mode = "left", padChar = '0', length = 5)
    public void setZtyaatukaisyasikakucd(String pZtyaatukaisyasikakucd) {
        ztyaatukaisyasikakucd = pZtyaatukaisyasikakucd;
    }

    private String ztyokyksmkuztrhkkitikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYOKYKSMKUZTRHKKITIKBN)
    public String getZtyokyksmkuztrhkkitikbn() {
        return ztyokyksmkuztrhkkitikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyokyksmkuztrhkkitikbn(String pZtyokyksmkuztrhkkitikbn) {
        ztyokyksmkuztrhkkitikbn = pZtyokyksmkuztrhkkitikbn;
    }

    private String ztyhoyuusisyacd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHOYUUSISYACD)
    public String getZtyhoyuusisyacd() {
        return ztyhoyuusisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtyhoyuusisyacd(String pZtyhoyuusisyacd) {
        ztyhoyuusisyacd = pZtyhoyuusisyacd;
    }

    private String ztysyokansisyacd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYOKANSISYACD)
    public String getZtysyokansisyacd() {
        return ztysyokansisyacd;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtysyokansisyacd(String pZtysyokansisyacd) {
        ztysyokansisyacd = pZtysyokansisyacd;
    }

    private String ztytantousyakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTANTOUSYAKBN)
    public String getZtytantousyakbn() {
        return ztytantousyakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytantousyakbn(String pZtytantousyakbn) {
        ztytantousyakbn = pZtytantousyakbn;
    }

    private String ztytantousyakbnnew;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTANTOUSYAKBNNEW)
    public String getZtytantousyakbnnew() {
        return ztytantousyakbnnew;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtytantousyakbnnew(String pZtytantousyakbnnew) {
        ztytantousyakbnnew = pZtytantousyakbnnew;
    }

    private String ztyclubsumiseikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYCLUBSUMISEIKBN)
    public String getZtyclubsumiseikbn() {
        return ztyclubsumiseikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZtyclubsumiseikbn(String pZtyclubsumiseikbn) {
        ztyclubsumiseikbn = pZtyclubsumiseikbn;
    }

    private String ztyfollowtantousyakbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYFOLLOWTANTOUSYAKBN)
    public String getZtyfollowtantousyakbn() {
        return ztyfollowtantousyakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtyfollowtantousyakbn(String pZtyfollowtantousyakbn) {
        ztyfollowtantousyakbn = pZtyfollowtantousyakbn;
    }

    private String ztytantousyajyoutaikbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTANTOUSYAJYOUTAIKBN)
    public String getZtytantousyajyoutaikbn() {
        return ztytantousyajyoutaikbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytantousyajyoutaikbn(String pZtytantousyajyoutaikbn) {
        ztytantousyajyoutaikbn = pZtytantousyajyoutaikbn;
    }

    private String ztykihonyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKIHONYOTEII)
    public String getZtykihonyoteii() {
        return ztykihonyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtykihonyoteii(String pZtykihonyoteii) {
        ztykihonyoteii = pZtykihonyoteii;
    }

    private String ztyteikiyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTEIKIYOTEII)
    public String getZtyteikiyoteii() {
        return ztyteikiyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyteikiyoteii(String pZtyteikiyoteii) {
        ztyteikiyoteii = pZtyteikiyoteii;
    }

    private String ztysonotayoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSONOTAYOTEII)
    public String getZtysonotayoteii() {
        return ztysonotayoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtysonotayoteii(String pZtysonotayoteii) {
        ztysonotayoteii = pZtysonotayoteii;
    }

    private String ztyitijibaraikihonyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYITIJIBARAIKIHONYOTEII)
    public String getZtyitijibaraikihonyoteii() {
        return ztyitijibaraikihonyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyitijibaraikihonyoteii(String pZtyitijibaraikihonyoteii) {
        ztyitijibaraikihonyoteii = pZtyitijibaraikihonyoteii;
    }

    private String ztyitijibaraiteikiyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYITIJIBARAITEIKIYOTEII)
    public String getZtyitijibaraiteikiyoteii() {
        return ztyitijibaraiteikiyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyitijibaraiteikiyoteii(String pZtyitijibaraiteikiyoteii) {
        ztyitijibaraiteikiyoteii = pZtyitijibaraiteikiyoteii;
    }

    private String ztyitijibaraisonotayoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYITIJIBARAISONOTAYOTEII)
    public String getZtyitijibaraisonotayoteii() {
        return ztyitijibaraisonotayoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyitijibaraisonotayoteii(String pZtyitijibaraisonotayoteii) {
        ztyitijibaraisonotayoteii = pZtyitijibaraisonotayoteii;
    }

    private String ztytenkankihonyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANKIHONYOTEII)
    public String getZtytenkankihonyoteii() {
        return ztytenkankihonyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtytenkankihonyoteii(String pZtytenkankihonyoteii) {
        ztytenkankihonyoteii = pZtytenkankihonyoteii;
    }

    private String ztytenkanteikiyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTENKANTEIKIYOTEII)
    public String getZtytenkanteikiyoteii() {
        return ztytenkanteikiyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtytenkanteikiyoteii(String pZtytenkanteikiyoteii) {
        ztytenkanteikiyoteii = pZtytenkanteikiyoteii;
    }

    private String ztyszouyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSZOUYOTEII)
    public String getZtyszouyoteii() {
        return ztyszouyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyszouyoteii(String pZtyszouyoteii) {
        ztyszouyoteii = pZtyszouyoteii;
    }

    private String ztyvestingyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYVESTINGYOTEII)
    public String getZtyvestingyoteii() {
        return ztyvestingyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyvestingyoteii(String pZtyvestingyoteii) {
        ztyvestingyoteii = pZtyvestingyoteii;
    }

    private String ztysippeitokuyakuyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSIPPEITOKUYAKUYOTEII)
    public String getZtysippeitokuyakuyoteii() {
        return ztysippeitokuyakuyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtysippeitokuyakuyoteii(String pZtysippeitokuyakuyoteii) {
        ztysippeitokuyakuyoteii = pZtysippeitokuyakuyoteii;
    }

    private String ztyseijinbyoutokuyakuyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSEIJINBYOUTOKUYAKUYOTEII)
    public String getZtyseijinbyoutokuyakuyoteii() {
        return ztyseijinbyoutokuyakuyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyseijinbyoutokuyakuyoteii(String pZtyseijinbyoutokuyakuyoteii) {
        ztyseijinbyoutokuyakuyoteii = pZtyseijinbyoutokuyakuyoteii;
    }

    private String ztyjyoseitokuyakuyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYJYOSEITOKUYAKUYOTEII)
    public String getZtyjyoseitokuyakuyoteii() {
        return ztyjyoseitokuyakuyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyjyoseitokuyakuyoteii(String pZtyjyoseitokuyakuyoteii) {
        ztyjyoseitokuyakuyoteii = pZtyjyoseitokuyakuyoteii;
    }

    private String ztytuuintokuyakuyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTUUINTOKUYAKUYOTEII)
    public String getZtytuuintokuyakuyoteii() {
        return ztytuuintokuyakuyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtytuuintokuyakuyoteii(String pZtytuuintokuyakuyoteii) {
        ztytuuintokuyakuyoteii = pZtytuuintokuyakuyoteii;
    }

    private String ztysaiteihosyoui;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSAITEIHOSYOUI)
    public String getZtysaiteihosyoui() {
        return ztysaiteihosyoui;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtysaiteihosyoui(String pZtysaiteihosyoui) {
        ztysaiteihosyoui = pZtysaiteihosyoui;
    }

    private String ztyvkisoitjbrkhnyoteii;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYVKISOITJBRKHNYOTEII)
    public String getZtyvkisoitjbrkhnyoteii() {
        return ztyvkisoitjbrkhnyoteii;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZtyvkisoitjbrkhnyoteii(String pZtyvkisoitjbrkhnyoteii) {
        ztyvkisoitjbrkhnyoteii = pZtyvkisoitjbrkhnyoteii;
    }

    private String ztyvkisorrtzeroikahyouji;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYVKISORRTZEROIKAHYOUJI)
    public String getZtyvkisorrtzeroikahyouji() {
        return ztyvkisorrtzeroikahyouji;
    }

    public void setZtyvkisorrtzeroikahyouji(String pZtyvkisorrtzeroikahyouji) {
        ztyvkisorrtzeroikahyouji = pZtyvkisorrtzeroikahyouji;
    }

    private String ztysuuriyouyobin3x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN3X2)
    public String getZtysuuriyouyobin3x2() {
        return ztysuuriyouyobin3x2;
    }

    public void setZtysuuriyouyobin3x2(String pZtysuuriyouyobin3x2) {
        ztysuuriyouyobin3x2 = pZtysuuriyouyobin3x2;
    }

    private String ztyhoyuusisyacd2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHOYUUSISYACD2)
    public String getZtyhoyuusisyacd2() {
        return ztyhoyuusisyacd2;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZtyhoyuusisyacd2(String pZtyhoyuusisyacd2) {
        ztyhoyuusisyacd2 = pZtyhoyuusisyacd2;
    }

    private String ztydftujyukujykisnkisiym;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYDFTUJYUKUJYKISNKISIYM)
    public String getZtydftujyukujykisnkisiym() {
        return ztydftujyukujykisnkisiym;
    }

    @Padding(mode = "left", padChar = '0', length = 6)
    public void setZtydftujyukujykisnkisiym(String pZtydftujyukujykisnkisiym) {
        ztydftujyukujykisnkisiym = pZtydftujyukujykisnkisiym;
    }

    private String ztytikikktbrijyututksu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTIKIKKTBRIJYUTUTKSU)
    public String getZtytikikktbrijyututksu() {
        return ztytikikktbrijyututksu;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytikikktbrijyututksu(String pZtytikikktbrijyututksu) {
        ztytikikktbrijyututksu = pZtytikikktbrijyututksu;
    }

    private String ztysyunyumrtikykjtigngtkbn;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSYUNYUMRTIKYKJTIGNGTKBN)
    public String getZtysyunyumrtikykjtigngtkbn() {
        return ztysyunyumrtikykjtigngtkbn;
    }

    public void setZtysyunyumrtikykjtigngtkbn(String pZtysyunyumrtikykjtigngtkbn) {
        ztysyunyumrtikykjtigngtkbn = pZtysyunyumrtikykjtigngtkbn;
    }

    private String ztyhhkdrtkykarihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYHHKDRTKYKARIHYJ)
    public String getZtyhhkdrtkykarihyj() {
        return ztyhhkdrtkykarihyj;
    }

    public void setZtyhhkdrtkykarihyj(String pZtyhhkdrtkykarihyj) {
        ztyhhkdrtkykarihyj = pZtyhhkdrtkykarihyj;
    }

    private String ztykykdrtkykarihyj;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKYKDRTKYKARIHYJ)
    public String getZtykykdrtkykarihyj() {
        return ztykykdrtkykarihyj;
    }

    public void setZtykykdrtkykarihyj(String pZtykykdrtkykarihyj) {
        ztykykdrtkykarihyj = pZtykykdrtkykarihyj;
    }

    private String ztyyobiv10x14;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIV10X14)
    public String getZtyyobiv10x14() {
        return ztyyobiv10x14;
    }

    public void setZtyyobiv10x14(String pZtyyobiv10x14) {
        ztyyobiv10x14 = pZtyyobiv10x14;
    }

    private Long ztykappadhktgkujygkx1;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAPPADHKTGKUJYGKX1)
    public Long getZtykappadhktgkujygkx1() {
        return ztykappadhktgkujygkx1;
    }

    public void setZtykappadhktgkujygkx1(Long pZtykappadhktgkujygkx1) {
        ztykappadhktgkujygkx1 = pZtykappadhktgkujygkx1;
    }

    private Long ztykappadhktgkujygkx2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAPPADHKTGKUJYGKX2)
    public Long getZtykappadhktgkujygkx2() {
        return ztykappadhktgkujygkx2;
    }

    public void setZtykappadhktgkujygkx2(Long pZtykappadhktgkujygkx2) {
        ztykappadhktgkujygkx2 = pZtykappadhktgkujygkx2;
    }

    private Long ztykappadhktgkujygkx3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAPPADHKTGKUJYGKX3)
    public Long getZtykappadhktgkujygkx3() {
        return ztykappadhktgkujygkx3;
    }

    public void setZtykappadhktgkujygkx3(Long pZtykappadhktgkujygkx3) {
        ztykappadhktgkujygkx3 = pZtykappadhktgkujygkx3;
    }

    private Long ztykappadhktgkujygkx4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYKAPPADHKTGKUJYGKX4)
    public Long getZtykappadhktgkujygkx4() {
        return ztykappadhktgkujygkx4;
    }

    public void setZtykappadhktgkujygkx4(Long pZtykappadhktgkujygkx4) {
        ztykappadhktgkujygkx4 = pZtykappadhktgkujygkx4;
    }

    private Long ztytrkzsgkaiykkjynstmtkzndk;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTRKZSGKAIYKKJYNSTMTKZNDK)
    public Long getZtytrkzsgkaiykkjynstmtkzndk() {
        return ztytrkzsgkaiykkjynstmtkzndk;
    }

    public void setZtytrkzsgkaiykkjynstmtkzndk(Long pZtytrkzsgkaiykkjynstmtkzndk) {
        ztytrkzsgkaiykkjynstmtkzndk = pZtytrkzsgkaiykkjynstmtkzndk;
    }

    private String ztypmenkouryokuhasseiymd;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYPMENKOURYOKUHASSEIYMD)
    public String getZtypmenkouryokuhasseiymd() {
        return ztypmenkouryokuhasseiymd;
    }

    public void setZtypmenkouryokuhasseiymd(String pZtypmenkouryokuhasseiymd) {
        ztypmenkouryokuhasseiymd = pZtypmenkouryokuhasseiymd;
    }

    private String ztysuuriyouyobin5;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN5)
    public String getZtysuuriyouyobin5() {
        return ztysuuriyouyobin5;
    }

    public void setZtysuuriyouyobin5(String pZtysuuriyouyobin5) {
        ztysuuriyouyobin5 = pZtysuuriyouyobin5;
    }

    private String ztysuuriyouyobin13;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSUURIYOUYOBIN13)
    public String getZtysuuriyouyobin13() {
        return ztysuuriyouyobin13;
    }

    public void setZtysuuriyouyobin13(String pZtysuuriyouyobin13) {
        ztysuuriyouyobin13 = pZtysuuriyouyobin13;
    }

    private Long ztyyobin11x35;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X35)
    public Long getZtyyobin11x35() {
        return ztyyobin11x35;
    }

    public void setZtyyobin11x35(Long pZtyyobin11x35) {
        ztyyobin11x35 = pZtyyobin11x35;
    }

    private Long ztyyobin11x36;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X36)
    public Long getZtyyobin11x36() {
        return ztyyobin11x36;
    }

    public void setZtyyobin11x36(Long pZtyyobin11x36) {
        ztyyobin11x36 = pZtyyobin11x36;
    }

    private Long ztyyobin11x37;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYYOBIN11X37)
    public Long getZtyyobin11x37() {
        return ztyyobin11x37;
    }

    public void setZtyyobin11x37(Long pZtyyobin11x37) {
        ztyyobin11x37 = pZtyyobin11x37;
    }

    private String ztytokuyakukoumokuv200;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200)
    public String getZtytokuyakukoumokuv200() {
        return ztytokuyakukoumokuv200;
    }

    public void setZtytokuyakukoumokuv200(String pZtytokuyakukoumokuv200) {
        ztytokuyakukoumokuv200 = pZtytokuyakukoumokuv200;
    }

    private String ztytokuyakukoumokuv200x2;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X2)
    public String getZtytokuyakukoumokuv200x2() {
        return ztytokuyakukoumokuv200x2;
    }

    public void setZtytokuyakukoumokuv200x2(String pZtytokuyakukoumokuv200x2) {
        ztytokuyakukoumokuv200x2 = pZtytokuyakukoumokuv200x2;
    }

    private String ztytokuyakukoumokuv200x3;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X3)
    public String getZtytokuyakukoumokuv200x3() {
        return ztytokuyakukoumokuv200x3;
    }

    public void setZtytokuyakukoumokuv200x3(String pZtytokuyakukoumokuv200x3) {
        ztytokuyakukoumokuv200x3 = pZtytokuyakukoumokuv200x3;
    }

    private String ztytokuyakukoumokuv200x4;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X4)
    public String getZtytokuyakukoumokuv200x4() {
        return ztytokuyakukoumokuv200x4;
    }

    public void setZtytokuyakukoumokuv200x4(String pZtytokuyakukoumokuv200x4) {
        ztytokuyakukoumokuv200x4 = pZtytokuyakukoumokuv200x4;
    }

    private String ztytokuyakukoumokuv200x5;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X5)
    public String getZtytokuyakukoumokuv200x5() {
        return ztytokuyakukoumokuv200x5;
    }

    public void setZtytokuyakukoumokuv200x5(String pZtytokuyakukoumokuv200x5) {
        ztytokuyakukoumokuv200x5 = pZtytokuyakukoumokuv200x5;
    }

    private String ztytokuyakukoumokuv200x6;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X6)
    public String getZtytokuyakukoumokuv200x6() {
        return ztytokuyakukoumokuv200x6;
    }

    public void setZtytokuyakukoumokuv200x6(String pZtytokuyakukoumokuv200x6) {
        ztytokuyakukoumokuv200x6 = pZtytokuyakukoumokuv200x6;
    }

    private String ztytokuyakukoumokuv200x7;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X7)
    public String getZtytokuyakukoumokuv200x7() {
        return ztytokuyakukoumokuv200x7;
    }

    public void setZtytokuyakukoumokuv200x7(String pZtytokuyakukoumokuv200x7) {
        ztytokuyakukoumokuv200x7 = pZtytokuyakukoumokuv200x7;
    }

    private String ztytokuyakukoumokuv200x8;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X8)
    public String getZtytokuyakukoumokuv200x8() {
        return ztytokuyakukoumokuv200x8;
    }

    public void setZtytokuyakukoumokuv200x8(String pZtytokuyakukoumokuv200x8) {
        ztytokuyakukoumokuv200x8 = pZtytokuyakukoumokuv200x8;
    }

    private String ztytokuyakukoumokuv200x9;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X9)
    public String getZtytokuyakukoumokuv200x9() {
        return ztytokuyakukoumokuv200x9;
    }

    public void setZtytokuyakukoumokuv200x9(String pZtytokuyakukoumokuv200x9) {
        ztytokuyakukoumokuv200x9 = pZtytokuyakukoumokuv200x9;
    }

    private String ztytokuyakukoumokuv200x10;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X10)
    public String getZtytokuyakukoumokuv200x10() {
        return ztytokuyakukoumokuv200x10;
    }

    public void setZtytokuyakukoumokuv200x10(String pZtytokuyakukoumokuv200x10) {
        ztytokuyakukoumokuv200x10 = pZtytokuyakukoumokuv200x10;
    }

    private String ztytokuyakukoumokuv200x11;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X11)
    public String getZtytokuyakukoumokuv200x11() {
        return ztytokuyakukoumokuv200x11;
    }

    public void setZtytokuyakukoumokuv200x11(String pZtytokuyakukoumokuv200x11) {
        ztytokuyakukoumokuv200x11 = pZtytokuyakukoumokuv200x11;
    }

    private String ztytokuyakukoumokuv200x12;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X12)
    public String getZtytokuyakukoumokuv200x12() {
        return ztytokuyakukoumokuv200x12;
    }

    public void setZtytokuyakukoumokuv200x12(String pZtytokuyakukoumokuv200x12) {
        ztytokuyakukoumokuv200x12 = pZtytokuyakukoumokuv200x12;
    }

    private String ztytokuyakukoumokuv200x13;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X13)
    public String getZtytokuyakukoumokuv200x13() {
        return ztytokuyakukoumokuv200x13;
    }

    public void setZtytokuyakukoumokuv200x13(String pZtytokuyakukoumokuv200x13) {
        ztytokuyakukoumokuv200x13 = pZtytokuyakukoumokuv200x13;
    }

    private String ztytokuyakukoumokuv200x14;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X14)
    public String getZtytokuyakukoumokuv200x14() {
        return ztytokuyakukoumokuv200x14;
    }

    public void setZtytokuyakukoumokuv200x14(String pZtytokuyakukoumokuv200x14) {
        ztytokuyakukoumokuv200x14 = pZtytokuyakukoumokuv200x14;
    }

    private String ztytokuyakukoumokuv200x15;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X15)
    public String getZtytokuyakukoumokuv200x15() {
        return ztytokuyakukoumokuv200x15;
    }

    public void setZtytokuyakukoumokuv200x15(String pZtytokuyakukoumokuv200x15) {
        ztytokuyakukoumokuv200x15 = pZtytokuyakukoumokuv200x15;
    }

    private String ztytokuyakukoumokuv200x16;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X16)
    public String getZtytokuyakukoumokuv200x16() {
        return ztytokuyakukoumokuv200x16;
    }

    public void setZtytokuyakukoumokuv200x16(String pZtytokuyakukoumokuv200x16) {
        ztytokuyakukoumokuv200x16 = pZtytokuyakukoumokuv200x16;
    }

    private String ztytokuyakukoumokuv200x17;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X17)
    public String getZtytokuyakukoumokuv200x17() {
        return ztytokuyakukoumokuv200x17;
    }

    public void setZtytokuyakukoumokuv200x17(String pZtytokuyakukoumokuv200x17) {
        ztytokuyakukoumokuv200x17 = pZtytokuyakukoumokuv200x17;
    }

    private String ztytokuyakukoumokuv200x18;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X18)
    public String getZtytokuyakukoumokuv200x18() {
        return ztytokuyakukoumokuv200x18;
    }

    public void setZtytokuyakukoumokuv200x18(String pZtytokuyakukoumokuv200x18) {
        ztytokuyakukoumokuv200x18 = pZtytokuyakukoumokuv200x18;
    }

    private String ztytokuyakukoumokuv200x19;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X19)
    public String getZtytokuyakukoumokuv200x19() {
        return ztytokuyakukoumokuv200x19;
    }

    public void setZtytokuyakukoumokuv200x19(String pZtytokuyakukoumokuv200x19) {
        ztytokuyakukoumokuv200x19 = pZtytokuyakukoumokuv200x19;
    }

    private String ztytokuyakukoumokuv200x20;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X20)
    public String getZtytokuyakukoumokuv200x20() {
        return ztytokuyakukoumokuv200x20;
    }

    public void setZtytokuyakukoumokuv200x20(String pZtytokuyakukoumokuv200x20) {
        ztytokuyakukoumokuv200x20 = pZtytokuyakukoumokuv200x20;
    }

    private String ztytokuyakukoumokuv200x21;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X21)
    public String getZtytokuyakukoumokuv200x21() {
        return ztytokuyakukoumokuv200x21;
    }

    public void setZtytokuyakukoumokuv200x21(String pZtytokuyakukoumokuv200x21) {
        ztytokuyakukoumokuv200x21 = pZtytokuyakukoumokuv200x21;
    }

    private String ztytokuyakukoumokuv200x22;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X22)
    public String getZtytokuyakukoumokuv200x22() {
        return ztytokuyakukoumokuv200x22;
    }

    public void setZtytokuyakukoumokuv200x22(String pZtytokuyakukoumokuv200x22) {
        ztytokuyakukoumokuv200x22 = pZtytokuyakukoumokuv200x22;
    }

    private String ztytokuyakukoumokuv200x23;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X23)
    public String getZtytokuyakukoumokuv200x23() {
        return ztytokuyakukoumokuv200x23;
    }

    public void setZtytokuyakukoumokuv200x23(String pZtytokuyakukoumokuv200x23) {
        ztytokuyakukoumokuv200x23 = pZtytokuyakukoumokuv200x23;
    }

    private String ztytokuyakukoumokuv200x24;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X24)
    public String getZtytokuyakukoumokuv200x24() {
        return ztytokuyakukoumokuv200x24;
    }

    public void setZtytokuyakukoumokuv200x24(String pZtytokuyakukoumokuv200x24) {
        ztytokuyakukoumokuv200x24 = pZtytokuyakukoumokuv200x24;
    }

    private String ztytokuyakukoumokuv200x25;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X25)
    public String getZtytokuyakukoumokuv200x25() {
        return ztytokuyakukoumokuv200x25;
    }

    public void setZtytokuyakukoumokuv200x25(String pZtytokuyakukoumokuv200x25) {
        ztytokuyakukoumokuv200x25 = pZtytokuyakukoumokuv200x25;
    }

    private String ztytokuyakukoumokuv200x26;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X26)
    public String getZtytokuyakukoumokuv200x26() {
        return ztytokuyakukoumokuv200x26;
    }

    public void setZtytokuyakukoumokuv200x26(String pZtytokuyakukoumokuv200x26) {
        ztytokuyakukoumokuv200x26 = pZtytokuyakukoumokuv200x26;
    }

    private String ztytokuyakukoumokuv200x27;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X27)
    public String getZtytokuyakukoumokuv200x27() {
        return ztytokuyakukoumokuv200x27;
    }

    public void setZtytokuyakukoumokuv200x27(String pZtytokuyakukoumokuv200x27) {
        ztytokuyakukoumokuv200x27 = pZtytokuyakukoumokuv200x27;
    }

    private String ztytokuyakukoumokuv200x28;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X28)
    public String getZtytokuyakukoumokuv200x28() {
        return ztytokuyakukoumokuv200x28;
    }

    public void setZtytokuyakukoumokuv200x28(String pZtytokuyakukoumokuv200x28) {
        ztytokuyakukoumokuv200x28 = pZtytokuyakukoumokuv200x28;
    }

    private String ztytokuyakukoumokuv200x29;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X29)
    public String getZtytokuyakukoumokuv200x29() {
        return ztytokuyakukoumokuv200x29;
    }

    public void setZtytokuyakukoumokuv200x29(String pZtytokuyakukoumokuv200x29) {
        ztytokuyakukoumokuv200x29 = pZtytokuyakukoumokuv200x29;
    }

    private String ztytokuyakukoumokuv200x30;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X30)
    public String getZtytokuyakukoumokuv200x30() {
        return ztytokuyakukoumokuv200x30;
    }

    public void setZtytokuyakukoumokuv200x30(String pZtytokuyakukoumokuv200x30) {
        ztytokuyakukoumokuv200x30 = pZtytokuyakukoumokuv200x30;
    }

    private String ztytokuyakukoumokuv200x31;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X31)
    public String getZtytokuyakukoumokuv200x31() {
        return ztytokuyakukoumokuv200x31;
    }

    public void setZtytokuyakukoumokuv200x31(String pZtytokuyakukoumokuv200x31) {
        ztytokuyakukoumokuv200x31 = pZtytokuyakukoumokuv200x31;
    }

    private String ztytokuyakukoumokuv200x32;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X32)
    public String getZtytokuyakukoumokuv200x32() {
        return ztytokuyakukoumokuv200x32;
    }

    public void setZtytokuyakukoumokuv200x32(String pZtytokuyakukoumokuv200x32) {
        ztytokuyakukoumokuv200x32 = pZtytokuyakukoumokuv200x32;
    }

    private String ztytokuyakukoumokuv200x33;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X33)
    public String getZtytokuyakukoumokuv200x33() {
        return ztytokuyakukoumokuv200x33;
    }

    public void setZtytokuyakukoumokuv200x33(String pZtytokuyakukoumokuv200x33) {
        ztytokuyakukoumokuv200x33 = pZtytokuyakukoumokuv200x33;
    }

    private String ztytokuyakukoumokuv200x34;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X34)
    public String getZtytokuyakukoumokuv200x34() {
        return ztytokuyakukoumokuv200x34;
    }

    public void setZtytokuyakukoumokuv200x34(String pZtytokuyakukoumokuv200x34) {
        ztytokuyakukoumokuv200x34 = pZtytokuyakukoumokuv200x34;
    }

    private String ztytokuyakukoumokuv200x35;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X35)
    public String getZtytokuyakukoumokuv200x35() {
        return ztytokuyakukoumokuv200x35;
    }

    public void setZtytokuyakukoumokuv200x35(String pZtytokuyakukoumokuv200x35) {
        ztytokuyakukoumokuv200x35 = pZtytokuyakukoumokuv200x35;
    }

    private String ztytokuyakukoumokuv200x36;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X36)
    public String getZtytokuyakukoumokuv200x36() {
        return ztytokuyakukoumokuv200x36;
    }

    public void setZtytokuyakukoumokuv200x36(String pZtytokuyakukoumokuv200x36) {
        ztytokuyakukoumokuv200x36 = pZtytokuyakukoumokuv200x36;
    }

    private String ztytokuyakukoumokuv200x37;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X37)
    public String getZtytokuyakukoumokuv200x37() {
        return ztytokuyakukoumokuv200x37;
    }

    public void setZtytokuyakukoumokuv200x37(String pZtytokuyakukoumokuv200x37) {
        ztytokuyakukoumokuv200x37 = pZtytokuyakukoumokuv200x37;
    }

    private String ztytokuyakukoumokuv200x38;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X38)
    public String getZtytokuyakukoumokuv200x38() {
        return ztytokuyakukoumokuv200x38;
    }

    public void setZtytokuyakukoumokuv200x38(String pZtytokuyakukoumokuv200x38) {
        ztytokuyakukoumokuv200x38 = pZtytokuyakukoumokuv200x38;
    }

    private String ztytokuyakukoumokuv200x39;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X39)
    public String getZtytokuyakukoumokuv200x39() {
        return ztytokuyakukoumokuv200x39;
    }

    public void setZtytokuyakukoumokuv200x39(String pZtytokuyakukoumokuv200x39) {
        ztytokuyakukoumokuv200x39 = pZtytokuyakukoumokuv200x39;
    }

    private String ztytokuyakukoumokuv200x40;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYTOKUYAKUKOUMOKUV200X40)
    public String getZtytokuyakukoumokuv200x40() {
        return ztytokuyakukoumokuv200x40;
    }

    public void setZtytokuyakukoumokuv200x40(String pZtytokuyakukoumokuv200x40) {
        ztytokuyakukoumokuv200x40 = pZtytokuyakukoumokuv200x40;
    }

    private BizNumber ztysrkaiyakukoujyoritu;

    @Type(type="BizNumberType")
    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSRKAIYAKUKOUJYORITU)
    public BizNumber getZtysrkaiyakukoujyoritu() {
        return ztysrkaiyakukoujyoritu;
    }

    public void setZtysrkaiyakukoujyoritu(BizNumber pZtysrkaiyakukoujyoritu) {
        ztysrkaiyakukoujyoritu = pZtysrkaiyakukoujyoritu;
    }

    private String ztysrteikishrtkykhukaumu;

    @Column(name=GenST_HoyuuMeisaiTyukeiyouItzHzn.ZTYSRTEIKISHRTKYKHUKAUMU)
    public String getZtysrteikishrtkykhukaumu() {
        return ztysrteikishrtkykhukaumu;
    }

    public void setZtysrteikishrtkykhukaumu(String pZtysrteikishrtkykhukaumu) {
        ztysrteikishrtkykhukaumu = pZtysrteikishrtkykhukaumu;
    }
}